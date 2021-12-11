package goober.hi

import goober.free.ses.SesIO
import software.amazon.awssdk.services.ses.model._


object ses {
  import goober.free.{ses ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountSendingPausedException(

    ): AccountSendingPausedException =
      AccountSendingPausedException
        .builder

        .build

    def addHeaderAction(
      headerName: Option[String] = None,
      headerValue: Option[String] = None
    ): AddHeaderAction =
      AddHeaderAction
        .builder
        .ifSome(headerName)(_.headerName(_))
        .ifSome(headerValue)(_.headerValue(_))
        .build

    def alreadyExistsException(
      name: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(name)(_.name(_))
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

    def bounceAction(
      topicArn: Option[String] = None,
      smtpReplyCode: Option[String] = None,
      statusCode: Option[String] = None,
      message: Option[String] = None,
      sender: Option[String] = None
    ): BounceAction =
      BounceAction
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(smtpReplyCode)(_.smtpReplyCode(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(sender)(_.sender(_))
        .build

    def bouncedRecipientInfo(
      recipient: Option[String] = None,
      recipientArn: Option[String] = None,
      bounceType: Option[String] = None,
      recipientDsnFields: Option[RecipientDsnFields] = None
    ): BouncedRecipientInfo =
      BouncedRecipientInfo
        .builder
        .ifSome(recipient)(_.recipient(_))
        .ifSome(recipientArn)(_.recipientArn(_))
        .ifSome(bounceType)(_.bounceType(_))
        .ifSome(recipientDsnFields)(_.recipientDsnFields(_))
        .build

    def bulkEmailDestination(
      destination: Option[Destination] = None,
      replacementTags: Option[List[MessageTag]] = None,
      replacementTemplateData: Option[String] = None
    ): BulkEmailDestination =
      BulkEmailDestination
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(replacementTags)(_.replacementTags(_))
        .ifSome(replacementTemplateData)(_.replacementTemplateData(_))
        .build

    def bulkEmailDestinationStatus(
      status: Option[String] = None,
      error: Option[String] = None,
      messageId: Option[String] = None
    ): BulkEmailDestinationStatus =
      BulkEmailDestinationStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(error)(_.error(_))
        .ifSome(messageId)(_.messageId(_))
        .build

    def cannotDeleteException(
      name: Option[String] = None
    ): CannotDeleteException =
      CannotDeleteException
        .builder
        .ifSome(name)(_.name(_))
        .build

    def cloneReceiptRuleSetRequest(
      ruleSetName: Option[String] = None,
      originalRuleSetName: Option[String] = None
    ): CloneReceiptRuleSetRequest =
      CloneReceiptRuleSetRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(originalRuleSetName)(_.originalRuleSetName(_))
        .build

    def cloneReceiptRuleSetResponse(

    ): CloneReceiptRuleSetResponse =
      CloneReceiptRuleSetResponse
        .builder

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

    def configurationSet(
      name: Option[String] = None
    ): ConfigurationSet =
      ConfigurationSet
        .builder
        .ifSome(name)(_.name(_))
        .build

    def configurationSetAlreadyExistsException(
      configurationSetName: Option[String] = None
    ): ConfigurationSetAlreadyExistsException =
      ConfigurationSetAlreadyExistsException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def configurationSetDoesNotExistException(
      configurationSetName: Option[String] = None
    ): ConfigurationSetDoesNotExistException =
      ConfigurationSetDoesNotExistException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def configurationSetSendingPausedException(
      configurationSetName: Option[String] = None
    ): ConfigurationSetSendingPausedException =
      ConfigurationSetSendingPausedException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
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
      eventDestination: Option[EventDestination] = None
    ): CreateConfigurationSetEventDestinationRequest =
      CreateConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestination)(_.eventDestination(_))
        .build

    def createConfigurationSetEventDestinationResponse(

    ): CreateConfigurationSetEventDestinationResponse =
      CreateConfigurationSetEventDestinationResponse
        .builder

        .build

    def createConfigurationSetRequest(
      configurationSet: Option[ConfigurationSet] = None
    ): CreateConfigurationSetRequest =
      CreateConfigurationSetRequest
        .builder
        .ifSome(configurationSet)(_.configurationSet(_))
        .build

    def createConfigurationSetResponse(

    ): CreateConfigurationSetResponse =
      CreateConfigurationSetResponse
        .builder

        .build

    def createConfigurationSetTrackingOptionsRequest(
      configurationSetName: Option[String] = None,
      trackingOptions: Option[TrackingOptions] = None
    ): CreateConfigurationSetTrackingOptionsRequest =
      CreateConfigurationSetTrackingOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .build

    def createConfigurationSetTrackingOptionsResponse(

    ): CreateConfigurationSetTrackingOptionsResponse =
      CreateConfigurationSetTrackingOptionsResponse
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

    def createReceiptFilterRequest(
      filter: Option[ReceiptFilter] = None
    ): CreateReceiptFilterRequest =
      CreateReceiptFilterRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .build

    def createReceiptFilterResponse(

    ): CreateReceiptFilterResponse =
      CreateReceiptFilterResponse
        .builder

        .build

    def createReceiptRuleRequest(
      ruleSetName: Option[String] = None,
      after: Option[String] = None,
      rule: Option[ReceiptRule] = None
    ): CreateReceiptRuleRequest =
      CreateReceiptRuleRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(after)(_.after(_))
        .ifSome(rule)(_.rule(_))
        .build

    def createReceiptRuleResponse(

    ): CreateReceiptRuleResponse =
      CreateReceiptRuleResponse
        .builder

        .build

    def createReceiptRuleSetRequest(
      ruleSetName: Option[String] = None
    ): CreateReceiptRuleSetRequest =
      CreateReceiptRuleSetRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .build

    def createReceiptRuleSetResponse(

    ): CreateReceiptRuleSetResponse =
      CreateReceiptRuleSetResponse
        .builder

        .build

    def createTemplateRequest(
      template: Option[Template] = None
    ): CreateTemplateRequest =
      CreateTemplateRequest
        .builder
        .ifSome(template)(_.template(_))
        .build

    def createTemplateResponse(

    ): CreateTemplateResponse =
      CreateTemplateResponse
        .builder

        .build

    def customVerificationEmailInvalidContentException(

    ): CustomVerificationEmailInvalidContentException =
      CustomVerificationEmailInvalidContentException
        .builder

        .build

    def customVerificationEmailTemplate(
      templateName: Option[String] = None,
      fromEmailAddress: Option[String] = None,
      templateSubject: Option[String] = None,
      successRedirectionURL: Option[String] = None,
      failureRedirectionURL: Option[String] = None
    ): CustomVerificationEmailTemplate =
      CustomVerificationEmailTemplate
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .ifSome(templateSubject)(_.templateSubject(_))
        .ifSome(successRedirectionURL)(_.successRedirectionURL(_))
        .ifSome(failureRedirectionURL)(_.failureRedirectionURL(_))
        .build

    def customVerificationEmailTemplateAlreadyExistsException(
      customVerificationEmailTemplateName: Option[String] = None
    ): CustomVerificationEmailTemplateAlreadyExistsException =
      CustomVerificationEmailTemplateAlreadyExistsException
        .builder
        .ifSome(customVerificationEmailTemplateName)(_.customVerificationEmailTemplateName(_))
        .build

    def customVerificationEmailTemplateDoesNotExistException(
      customVerificationEmailTemplateName: Option[String] = None
    ): CustomVerificationEmailTemplateDoesNotExistException =
      CustomVerificationEmailTemplateDoesNotExistException
        .builder
        .ifSome(customVerificationEmailTemplateName)(_.customVerificationEmailTemplateName(_))
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

    def deleteConfigurationSetTrackingOptionsRequest(
      configurationSetName: Option[String] = None
    ): DeleteConfigurationSetTrackingOptionsRequest =
      DeleteConfigurationSetTrackingOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def deleteConfigurationSetTrackingOptionsResponse(

    ): DeleteConfigurationSetTrackingOptionsResponse =
      DeleteConfigurationSetTrackingOptionsResponse
        .builder

        .build

    def deleteCustomVerificationEmailTemplateRequest(
      templateName: Option[String] = None
    ): DeleteCustomVerificationEmailTemplateRequest =
      DeleteCustomVerificationEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteIdentityPolicyRequest(
      identity: Option[String] = None,
      policyName: Option[String] = None
    ): DeleteIdentityPolicyRequest =
      DeleteIdentityPolicyRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteIdentityPolicyResponse(

    ): DeleteIdentityPolicyResponse =
      DeleteIdentityPolicyResponse
        .builder

        .build

    def deleteIdentityRequest(
      identity: Option[String] = None
    ): DeleteIdentityRequest =
      DeleteIdentityRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .build

    def deleteIdentityResponse(

    ): DeleteIdentityResponse =
      DeleteIdentityResponse
        .builder

        .build

    def deleteReceiptFilterRequest(
      filterName: Option[String] = None
    ): DeleteReceiptFilterRequest =
      DeleteReceiptFilterRequest
        .builder
        .ifSome(filterName)(_.filterName(_))
        .build

    def deleteReceiptFilterResponse(

    ): DeleteReceiptFilterResponse =
      DeleteReceiptFilterResponse
        .builder

        .build

    def deleteReceiptRuleRequest(
      ruleSetName: Option[String] = None,
      ruleName: Option[String] = None
    ): DeleteReceiptRuleRequest =
      DeleteReceiptRuleRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def deleteReceiptRuleResponse(

    ): DeleteReceiptRuleResponse =
      DeleteReceiptRuleResponse
        .builder

        .build

    def deleteReceiptRuleSetRequest(
      ruleSetName: Option[String] = None
    ): DeleteReceiptRuleSetRequest =
      DeleteReceiptRuleSetRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .build

    def deleteReceiptRuleSetResponse(

    ): DeleteReceiptRuleSetResponse =
      DeleteReceiptRuleSetResponse
        .builder

        .build

    def deleteTemplateRequest(
      templateName: Option[String] = None
    ): DeleteTemplateRequest =
      DeleteTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteTemplateResponse(

    ): DeleteTemplateResponse =
      DeleteTemplateResponse
        .builder

        .build

    def deleteVerifiedEmailAddressRequest(
      emailAddress: Option[String] = None
    ): DeleteVerifiedEmailAddressRequest =
      DeleteVerifiedEmailAddressRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def deliveryOptions(
      tlsPolicy: Option[String] = None
    ): DeliveryOptions =
      DeliveryOptions
        .builder
        .ifSome(tlsPolicy)(_.tlsPolicy(_))
        .build

    def describeActiveReceiptRuleSetRequest(

    ): DescribeActiveReceiptRuleSetRequest =
      DescribeActiveReceiptRuleSetRequest
        .builder

        .build

    def describeActiveReceiptRuleSetResponse(
      metadata: Option[ReceiptRuleSetMetadata] = None,
      rules: Option[List[ReceiptRule]] = None
    ): DescribeActiveReceiptRuleSetResponse =
      DescribeActiveReceiptRuleSetResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(rules)(_.rules(_))
        .build

    def describeConfigurationSetRequest(
      configurationSetName: Option[String] = None,
      configurationSetAttributeNames: Option[List[ConfigurationSetAttribute]] = None
    ): DescribeConfigurationSetRequest =
      DescribeConfigurationSetRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(configurationSetAttributeNames)(_.configurationSetAttributeNames(_))
        .build

    def describeConfigurationSetResponse(
      configurationSet: Option[ConfigurationSet] = None,
      eventDestinations: Option[List[EventDestination]] = None,
      trackingOptions: Option[TrackingOptions] = None,
      deliveryOptions: Option[DeliveryOptions] = None,
      reputationOptions: Option[ReputationOptions] = None
    ): DescribeConfigurationSetResponse =
      DescribeConfigurationSetResponse
        .builder
        .ifSome(configurationSet)(_.configurationSet(_))
        .ifSome(eventDestinations)(_.eventDestinations(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .ifSome(deliveryOptions)(_.deliveryOptions(_))
        .ifSome(reputationOptions)(_.reputationOptions(_))
        .build

    def describeReceiptRuleRequest(
      ruleSetName: Option[String] = None,
      ruleName: Option[String] = None
    ): DescribeReceiptRuleRequest =
      DescribeReceiptRuleRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def describeReceiptRuleResponse(
      rule: Option[ReceiptRule] = None
    ): DescribeReceiptRuleResponse =
      DescribeReceiptRuleResponse
        .builder
        .ifSome(rule)(_.rule(_))
        .build

    def describeReceiptRuleSetRequest(
      ruleSetName: Option[String] = None
    ): DescribeReceiptRuleSetRequest =
      DescribeReceiptRuleSetRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .build

    def describeReceiptRuleSetResponse(
      metadata: Option[ReceiptRuleSetMetadata] = None,
      rules: Option[List[ReceiptRule]] = None
    ): DescribeReceiptRuleSetResponse =
      DescribeReceiptRuleSetResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(rules)(_.rules(_))
        .build

    def destination(
      toAddresses: Option[List[Address]] = None,
      ccAddresses: Option[List[Address]] = None,
      bccAddresses: Option[List[Address]] = None
    ): Destination =
      Destination
        .builder
        .ifSome(toAddresses)(_.toAddresses(_))
        .ifSome(ccAddresses)(_.ccAddresses(_))
        .ifSome(bccAddresses)(_.bccAddresses(_))
        .build

    def eventDestination(
      name: Option[String] = None,
      enabled: Option[Boolean] = None,
      matchingEventTypes: Option[List[EventType]] = None,
      kinesisFirehoseDestination: Option[KinesisFirehoseDestination] = None,
      cloudWatchDestination: Option[CloudWatchDestination] = None,
      sNSDestination: Option[SNSDestination] = None
    ): EventDestination =
      EventDestination
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(matchingEventTypes)(_.matchingEventTypes(_))
        .ifSome(kinesisFirehoseDestination)(_.kinesisFirehoseDestination(_))
        .ifSome(cloudWatchDestination)(_.cloudWatchDestination(_))
        .ifSome(sNSDestination)(_.sNSDestination(_))
        .build

    def eventDestinationAlreadyExistsException(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): EventDestinationAlreadyExistsException =
      EventDestinationAlreadyExistsException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def eventDestinationDoesNotExistException(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): EventDestinationDoesNotExistException =
      EventDestinationDoesNotExistException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def extensionField(
      name: Option[String] = None,
      value: Option[String] = None
    ): ExtensionField =
      ExtensionField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def fromEmailAddressNotVerifiedException(
      fromEmailAddress: Option[String] = None
    ): FromEmailAddressNotVerifiedException =
      FromEmailAddressNotVerifiedException
        .builder
        .ifSome(fromEmailAddress)(_.fromEmailAddress(_))
        .build

    def getAccountSendingEnabledResponse(
      enabled: Option[Boolean] = None
    ): GetAccountSendingEnabledResponse =
      GetAccountSendingEnabledResponse
        .builder
        .ifSome(enabled)(_.enabled(_))
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

    def getIdentityDkimAttributesRequest(
      identities: Option[List[Identity]] = None
    ): GetIdentityDkimAttributesRequest =
      GetIdentityDkimAttributesRequest
        .builder
        .ifSome(identities)(_.identities(_))
        .build

    def getIdentityDkimAttributesResponse(
      dkimAttributes: Option[DkimAttributes] = None
    ): GetIdentityDkimAttributesResponse =
      GetIdentityDkimAttributesResponse
        .builder
        .ifSome(dkimAttributes)(_.dkimAttributes(_))
        .build

    def getIdentityMailFromDomainAttributesRequest(
      identities: Option[List[Identity]] = None
    ): GetIdentityMailFromDomainAttributesRequest =
      GetIdentityMailFromDomainAttributesRequest
        .builder
        .ifSome(identities)(_.identities(_))
        .build

    def getIdentityMailFromDomainAttributesResponse(
      mailFromDomainAttributes: Option[MailFromDomainAttributes] = None
    ): GetIdentityMailFromDomainAttributesResponse =
      GetIdentityMailFromDomainAttributesResponse
        .builder
        .ifSome(mailFromDomainAttributes)(_.mailFromDomainAttributes(_))
        .build

    def getIdentityNotificationAttributesRequest(
      identities: Option[List[Identity]] = None
    ): GetIdentityNotificationAttributesRequest =
      GetIdentityNotificationAttributesRequest
        .builder
        .ifSome(identities)(_.identities(_))
        .build

    def getIdentityNotificationAttributesResponse(
      notificationAttributes: Option[NotificationAttributes] = None
    ): GetIdentityNotificationAttributesResponse =
      GetIdentityNotificationAttributesResponse
        .builder
        .ifSome(notificationAttributes)(_.notificationAttributes(_))
        .build

    def getIdentityPoliciesRequest(
      identity: Option[String] = None,
      policyNames: Option[List[PolicyName]] = None
    ): GetIdentityPoliciesRequest =
      GetIdentityPoliciesRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def getIdentityPoliciesResponse(
      policies: Option[PolicyMap] = None
    ): GetIdentityPoliciesResponse =
      GetIdentityPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .build

    def getIdentityVerificationAttributesRequest(
      identities: Option[List[Identity]] = None
    ): GetIdentityVerificationAttributesRequest =
      GetIdentityVerificationAttributesRequest
        .builder
        .ifSome(identities)(_.identities(_))
        .build

    def getIdentityVerificationAttributesResponse(
      verificationAttributes: Option[VerificationAttributes] = None
    ): GetIdentityVerificationAttributesResponse =
      GetIdentityVerificationAttributesResponse
        .builder
        .ifSome(verificationAttributes)(_.verificationAttributes(_))
        .build

    def getSendQuotaResponse(
      max24HourSend: Option[Max24HourSend] = None,
      maxSendRate: Option[MaxSendRate] = None,
      sentLast24Hours: Option[SentLast24Hours] = None
    ): GetSendQuotaResponse =
      GetSendQuotaResponse
        .builder
        .ifSome(max24HourSend)(_.max24HourSend(_))
        .ifSome(maxSendRate)(_.maxSendRate(_))
        .ifSome(sentLast24Hours)(_.sentLast24Hours(_))
        .build

    def getSendStatisticsResponse(
      sendDataPoints: Option[List[SendDataPoint]] = None
    ): GetSendStatisticsResponse =
      GetSendStatisticsResponse
        .builder
        .ifSome(sendDataPoints)(_.sendDataPoints(_))
        .build

    def getTemplateRequest(
      templateName: Option[String] = None
    ): GetTemplateRequest =
      GetTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def getTemplateResponse(
      template: Option[Template] = None
    ): GetTemplateResponse =
      GetTemplateResponse
        .builder
        .ifSome(template)(_.template(_))
        .build

    def identityDkimAttributes(
      dkimEnabled: Option[Boolean] = None,
      dkimVerificationStatus: Option[String] = None,
      dkimTokens: Option[List[VerificationToken]] = None
    ): IdentityDkimAttributes =
      IdentityDkimAttributes
        .builder
        .ifSome(dkimEnabled)(_.dkimEnabled(_))
        .ifSome(dkimVerificationStatus)(_.dkimVerificationStatus(_))
        .ifSome(dkimTokens)(_.dkimTokens(_))
        .build

    def identityMailFromDomainAttributes(
      mailFromDomain: Option[String] = None,
      mailFromDomainStatus: Option[String] = None,
      behaviorOnMXFailure: Option[String] = None
    ): IdentityMailFromDomainAttributes =
      IdentityMailFromDomainAttributes
        .builder
        .ifSome(mailFromDomain)(_.mailFromDomain(_))
        .ifSome(mailFromDomainStatus)(_.mailFromDomainStatus(_))
        .ifSome(behaviorOnMXFailure)(_.behaviorOnMXFailure(_))
        .build

    def identityNotificationAttributes(
      bounceTopic: Option[String] = None,
      complaintTopic: Option[String] = None,
      deliveryTopic: Option[String] = None,
      forwardingEnabled: Option[Boolean] = None,
      headersInBounceNotificationsEnabled: Option[Boolean] = None,
      headersInComplaintNotificationsEnabled: Option[Boolean] = None,
      headersInDeliveryNotificationsEnabled: Option[Boolean] = None
    ): IdentityNotificationAttributes =
      IdentityNotificationAttributes
        .builder
        .ifSome(bounceTopic)(_.bounceTopic(_))
        .ifSome(complaintTopic)(_.complaintTopic(_))
        .ifSome(deliveryTopic)(_.deliveryTopic(_))
        .ifSome(forwardingEnabled)(_.forwardingEnabled(_))
        .ifSome(headersInBounceNotificationsEnabled)(_.headersInBounceNotificationsEnabled(_))
        .ifSome(headersInComplaintNotificationsEnabled)(_.headersInComplaintNotificationsEnabled(_))
        .ifSome(headersInDeliveryNotificationsEnabled)(_.headersInDeliveryNotificationsEnabled(_))
        .build

    def identityVerificationAttributes(
      verificationStatus: Option[String] = None,
      verificationToken: Option[String] = None
    ): IdentityVerificationAttributes =
      IdentityVerificationAttributes
        .builder
        .ifSome(verificationStatus)(_.verificationStatus(_))
        .ifSome(verificationToken)(_.verificationToken(_))
        .build

    def invalidCloudWatchDestinationException(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): InvalidCloudWatchDestinationException =
      InvalidCloudWatchDestinationException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def invalidConfigurationSetException(

    ): InvalidConfigurationSetException =
      InvalidConfigurationSetException
        .builder

        .build

    def invalidDeliveryOptionsException(

    ): InvalidDeliveryOptionsException =
      InvalidDeliveryOptionsException
        .builder

        .build

    def invalidFirehoseDestinationException(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): InvalidFirehoseDestinationException =
      InvalidFirehoseDestinationException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def invalidLambdaFunctionException(
      functionArn: Option[String] = None
    ): InvalidLambdaFunctionException =
      InvalidLambdaFunctionException
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .build

    def invalidPolicyException(

    ): InvalidPolicyException =
      InvalidPolicyException
        .builder

        .build

    def invalidRenderingParameterException(
      templateName: Option[String] = None
    ): InvalidRenderingParameterException =
      InvalidRenderingParameterException
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def invalidS3ConfigurationException(
      bucket: Option[String] = None
    ): InvalidS3ConfigurationException =
      InvalidS3ConfigurationException
        .builder
        .ifSome(bucket)(_.bucket(_))
        .build

    def invalidSNSDestinationException(
      configurationSetName: Option[String] = None,
      eventDestinationName: Option[String] = None
    ): InvalidSNSDestinationException =
      InvalidSNSDestinationException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestinationName)(_.eventDestinationName(_))
        .build

    def invalidSnsTopicException(
      topic: Option[String] = None
    ): InvalidSnsTopicException =
      InvalidSnsTopicException
        .builder
        .ifSome(topic)(_.topic(_))
        .build

    def invalidTemplateException(
      templateName: Option[String] = None
    ): InvalidTemplateException =
      InvalidTemplateException
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def invalidTrackingOptionsException(

    ): InvalidTrackingOptionsException =
      InvalidTrackingOptionsException
        .builder

        .build

    def kinesisFirehoseDestination(
      iAMRoleARN: Option[String] = None,
      deliveryStreamARN: Option[String] = None
    ): KinesisFirehoseDestination =
      KinesisFirehoseDestination
        .builder
        .ifSome(iAMRoleARN)(_.iAMRoleARN(_))
        .ifSome(deliveryStreamARN)(_.deliveryStreamARN(_))
        .build

    def lambdaAction(
      topicArn: Option[String] = None,
      functionArn: Option[String] = None,
      invocationType: Option[String] = None
    ): LambdaAction =
      LambdaAction
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(invocationType)(_.invocationType(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listConfigurationSetsRequest(
      nextToken: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListConfigurationSetsRequest =
      ListConfigurationSetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listConfigurationSetsResponse(
      configurationSets: Option[List[ConfigurationSet]] = None,
      nextToken: Option[String] = None
    ): ListConfigurationSetsResponse =
      ListConfigurationSetsResponse
        .builder
        .ifSome(configurationSets)(_.configurationSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomVerificationEmailTemplatesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCustomVerificationEmailTemplatesRequest =
      ListCustomVerificationEmailTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCustomVerificationEmailTemplatesResponse(
      customVerificationEmailTemplates: Option[List[CustomVerificationEmailTemplate]] = None,
      nextToken: Option[String] = None
    ): ListCustomVerificationEmailTemplatesResponse =
      ListCustomVerificationEmailTemplatesResponse
        .builder
        .ifSome(customVerificationEmailTemplates)(_.customVerificationEmailTemplates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentitiesRequest(
      identityType: Option[String] = None,
      nextToken: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListIdentitiesRequest =
      ListIdentitiesRequest
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listIdentitiesResponse(
      identities: Option[List[Identity]] = None,
      nextToken: Option[String] = None
    ): ListIdentitiesResponse =
      ListIdentitiesResponse
        .builder
        .ifSome(identities)(_.identities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityPoliciesRequest(
      identity: Option[String] = None
    ): ListIdentityPoliciesRequest =
      ListIdentityPoliciesRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .build

    def listIdentityPoliciesResponse(
      policyNames: Option[List[PolicyName]] = None
    ): ListIdentityPoliciesResponse =
      ListIdentityPoliciesResponse
        .builder
        .ifSome(policyNames)(_.policyNames(_))
        .build

    def listReceiptFiltersRequest(

    ): ListReceiptFiltersRequest =
      ListReceiptFiltersRequest
        .builder

        .build

    def listReceiptFiltersResponse(
      filters: Option[List[ReceiptFilter]] = None
    ): ListReceiptFiltersResponse =
      ListReceiptFiltersResponse
        .builder
        .ifSome(filters)(_.filters(_))
        .build

    def listReceiptRuleSetsRequest(
      nextToken: Option[String] = None
    ): ListReceiptRuleSetsRequest =
      ListReceiptRuleSetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReceiptRuleSetsResponse(
      ruleSets: Option[List[ReceiptRuleSetMetadata]] = None,
      nextToken: Option[String] = None
    ): ListReceiptRuleSetsResponse =
      ListReceiptRuleSetsResponse
        .builder
        .ifSome(ruleSets)(_.ruleSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTemplatesRequest(
      nextToken: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListTemplatesRequest =
      ListTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTemplatesResponse(
      templatesMetadata: Option[List[TemplateMetadata]] = None,
      nextToken: Option[String] = None
    ): ListTemplatesResponse =
      ListTemplatesResponse
        .builder
        .ifSome(templatesMetadata)(_.templatesMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVerifiedEmailAddressesResponse(
      verifiedEmailAddresses: Option[List[Address]] = None
    ): ListVerifiedEmailAddressesResponse =
      ListVerifiedEmailAddressesResponse
        .builder
        .ifSome(verifiedEmailAddresses)(_.verifiedEmailAddresses(_))
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

    def messageDsn(
      reportingMta: Option[String] = None,
      arrivalDate: Option[ArrivalDate] = None,
      extensionFields: Option[List[ExtensionField]] = None
    ): MessageDsn =
      MessageDsn
        .builder
        .ifSome(reportingMta)(_.reportingMta(_))
        .ifSome(arrivalDate)(_.arrivalDate(_))
        .ifSome(extensionFields)(_.extensionFields(_))
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

    def missingRenderingAttributeException(
      templateName: Option[String] = None
    ): MissingRenderingAttributeException =
      MissingRenderingAttributeException
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def productionAccessNotGrantedException(

    ): ProductionAccessNotGrantedException =
      ProductionAccessNotGrantedException
        .builder

        .build

    def putConfigurationSetDeliveryOptionsRequest(
      configurationSetName: Option[String] = None,
      deliveryOptions: Option[DeliveryOptions] = None
    ): PutConfigurationSetDeliveryOptionsRequest =
      PutConfigurationSetDeliveryOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(deliveryOptions)(_.deliveryOptions(_))
        .build

    def putConfigurationSetDeliveryOptionsResponse(

    ): PutConfigurationSetDeliveryOptionsResponse =
      PutConfigurationSetDeliveryOptionsResponse
        .builder

        .build

    def putIdentityPolicyRequest(
      identity: Option[String] = None,
      policyName: Option[String] = None,
      policy: Option[String] = None
    ): PutIdentityPolicyRequest =
      PutIdentityPolicyRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putIdentityPolicyResponse(

    ): PutIdentityPolicyResponse =
      PutIdentityPolicyResponse
        .builder

        .build

    def rawMessage(
      data: Option[RawMessageData] = None
    ): RawMessage =
      RawMessage
        .builder
        .ifSome(data)(_.data(_))
        .build

    def receiptAction(
      s3Action: Option[S3Action] = None,
      bounceAction: Option[BounceAction] = None,
      workmailAction: Option[WorkmailAction] = None,
      lambdaAction: Option[LambdaAction] = None,
      stopAction: Option[StopAction] = None,
      addHeaderAction: Option[AddHeaderAction] = None,
      sNSAction: Option[SNSAction] = None
    ): ReceiptAction =
      ReceiptAction
        .builder
        .ifSome(s3Action)(_.s3Action(_))
        .ifSome(bounceAction)(_.bounceAction(_))
        .ifSome(workmailAction)(_.workmailAction(_))
        .ifSome(lambdaAction)(_.lambdaAction(_))
        .ifSome(stopAction)(_.stopAction(_))
        .ifSome(addHeaderAction)(_.addHeaderAction(_))
        .ifSome(sNSAction)(_.sNSAction(_))
        .build

    def receiptFilter(
      name: Option[String] = None,
      ipFilter: Option[ReceiptIpFilter] = None
    ): ReceiptFilter =
      ReceiptFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ipFilter)(_.ipFilter(_))
        .build

    def receiptIpFilter(
      policy: Option[String] = None,
      cidr: Option[String] = None
    ): ReceiptIpFilter =
      ReceiptIpFilter
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(cidr)(_.cidr(_))
        .build

    def receiptRule(
      name: Option[String] = None,
      enabled: Option[Boolean] = None,
      tlsPolicy: Option[String] = None,
      recipients: Option[List[Recipient]] = None,
      actions: Option[List[ReceiptAction]] = None,
      scanEnabled: Option[Boolean] = None
    ): ReceiptRule =
      ReceiptRule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(tlsPolicy)(_.tlsPolicy(_))
        .ifSome(recipients)(_.recipients(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(scanEnabled)(_.scanEnabled(_))
        .build

    def receiptRuleSetMetadata(
      name: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None
    ): ReceiptRuleSetMetadata =
      ReceiptRuleSetMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .build

    def recipientDsnFields(
      finalRecipient: Option[String] = None,
      action: Option[String] = None,
      remoteMta: Option[String] = None,
      status: Option[String] = None,
      diagnosticCode: Option[String] = None,
      lastAttemptDate: Option[LastAttemptDate] = None,
      extensionFields: Option[List[ExtensionField]] = None
    ): RecipientDsnFields =
      RecipientDsnFields
        .builder
        .ifSome(finalRecipient)(_.finalRecipient(_))
        .ifSome(action)(_.action(_))
        .ifSome(remoteMta)(_.remoteMta(_))
        .ifSome(status)(_.status(_))
        .ifSome(diagnosticCode)(_.diagnosticCode(_))
        .ifSome(lastAttemptDate)(_.lastAttemptDate(_))
        .ifSome(extensionFields)(_.extensionFields(_))
        .build

    def reorderReceiptRuleSetRequest(
      ruleSetName: Option[String] = None,
      ruleNames: Option[List[ReceiptRuleName]] = None
    ): ReorderReceiptRuleSetRequest =
      ReorderReceiptRuleSetRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(ruleNames)(_.ruleNames(_))
        .build

    def reorderReceiptRuleSetResponse(

    ): ReorderReceiptRuleSetResponse =
      ReorderReceiptRuleSetResponse
        .builder

        .build

    def reputationOptions(
      sendingEnabled: Option[Boolean] = None,
      reputationMetricsEnabled: Option[Boolean] = None,
      lastFreshStart: Option[LastFreshStart] = None
    ): ReputationOptions =
      ReputationOptions
        .builder
        .ifSome(sendingEnabled)(_.sendingEnabled(_))
        .ifSome(reputationMetricsEnabled)(_.reputationMetricsEnabled(_))
        .ifSome(lastFreshStart)(_.lastFreshStart(_))
        .build

    def ruleDoesNotExistException(
      name: Option[String] = None
    ): RuleDoesNotExistException =
      RuleDoesNotExistException
        .builder
        .ifSome(name)(_.name(_))
        .build

    def ruleSetDoesNotExistException(
      name: Option[String] = None
    ): RuleSetDoesNotExistException =
      RuleSetDoesNotExistException
        .builder
        .ifSome(name)(_.name(_))
        .build

    def s3Action(
      topicArn: Option[String] = None,
      bucketName: Option[String] = None,
      objectKeyPrefix: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): S3Action =
      S3Action
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(objectKeyPrefix)(_.objectKeyPrefix(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def sNSAction(
      topicArn: Option[String] = None,
      encoding: Option[String] = None
    ): SNSAction =
      SNSAction
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(encoding)(_.encoding(_))
        .build

    def sNSDestination(
      topicARN: Option[String] = None
    ): SNSDestination =
      SNSDestination
        .builder
        .ifSome(topicARN)(_.topicARN(_))
        .build

    def sendBounceRequest(
      originalMessageId: Option[String] = None,
      bounceSender: Option[String] = None,
      explanation: Option[String] = None,
      messageDsn: Option[MessageDsn] = None,
      bouncedRecipientInfoList: Option[List[BouncedRecipientInfo]] = None,
      bounceSenderArn: Option[String] = None
    ): SendBounceRequest =
      SendBounceRequest
        .builder
        .ifSome(originalMessageId)(_.originalMessageId(_))
        .ifSome(bounceSender)(_.bounceSender(_))
        .ifSome(explanation)(_.explanation(_))
        .ifSome(messageDsn)(_.messageDsn(_))
        .ifSome(bouncedRecipientInfoList)(_.bouncedRecipientInfoList(_))
        .ifSome(bounceSenderArn)(_.bounceSenderArn(_))
        .build

    def sendBounceResponse(
      messageId: Option[String] = None
    ): SendBounceResponse =
      SendBounceResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def sendBulkTemplatedEmailRequest(
      source: Option[String] = None,
      sourceArn: Option[String] = None,
      replyToAddresses: Option[List[Address]] = None,
      returnPath: Option[String] = None,
      returnPathArn: Option[String] = None,
      configurationSetName: Option[String] = None,
      defaultTags: Option[List[MessageTag]] = None,
      template: Option[String] = None,
      templateArn: Option[String] = None,
      defaultTemplateData: Option[String] = None,
      destinations: Option[List[BulkEmailDestination]] = None
    ): SendBulkTemplatedEmailRequest =
      SendBulkTemplatedEmailRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(returnPath)(_.returnPath(_))
        .ifSome(returnPathArn)(_.returnPathArn(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(defaultTags)(_.defaultTags(_))
        .ifSome(template)(_.template(_))
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(defaultTemplateData)(_.defaultTemplateData(_))
        .ifSome(destinations)(_.destinations(_))
        .build

    def sendBulkTemplatedEmailResponse(
      status: Option[List[BulkEmailDestinationStatus]] = None
    ): SendBulkTemplatedEmailResponse =
      SendBulkTemplatedEmailResponse
        .builder
        .ifSome(status)(_.status(_))
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

    def sendDataPoint(
      timestamp: Option[Timestamp] = None,
      deliveryAttempts: Option[Counter] = None,
      bounces: Option[Counter] = None,
      complaints: Option[Counter] = None,
      rejects: Option[Counter] = None
    ): SendDataPoint =
      SendDataPoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(deliveryAttempts)(_.deliveryAttempts(_))
        .ifSome(bounces)(_.bounces(_))
        .ifSome(complaints)(_.complaints(_))
        .ifSome(rejects)(_.rejects(_))
        .build

    def sendEmailRequest(
      source: Option[String] = None,
      destination: Option[Destination] = None,
      message: Option[Message] = None,
      replyToAddresses: Option[List[Address]] = None,
      returnPath: Option[String] = None,
      sourceArn: Option[String] = None,
      returnPathArn: Option[String] = None,
      tags: Option[List[MessageTag]] = None,
      configurationSetName: Option[String] = None
    ): SendEmailRequest =
      SendEmailRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(message)(_.message(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(returnPath)(_.returnPath(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(returnPathArn)(_.returnPathArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def sendEmailResponse(
      messageId: Option[String] = None
    ): SendEmailResponse =
      SendEmailResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def sendRawEmailRequest(
      source: Option[String] = None,
      destinations: Option[List[Address]] = None,
      rawMessage: Option[RawMessage] = None,
      fromArn: Option[String] = None,
      sourceArn: Option[String] = None,
      returnPathArn: Option[String] = None,
      tags: Option[List[MessageTag]] = None,
      configurationSetName: Option[String] = None
    ): SendRawEmailRequest =
      SendRawEmailRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(rawMessage)(_.rawMessage(_))
        .ifSome(fromArn)(_.fromArn(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(returnPathArn)(_.returnPathArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def sendRawEmailResponse(
      messageId: Option[String] = None
    ): SendRawEmailResponse =
      SendRawEmailResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def sendTemplatedEmailRequest(
      source: Option[String] = None,
      destination: Option[Destination] = None,
      replyToAddresses: Option[List[Address]] = None,
      returnPath: Option[String] = None,
      sourceArn: Option[String] = None,
      returnPathArn: Option[String] = None,
      tags: Option[List[MessageTag]] = None,
      configurationSetName: Option[String] = None,
      template: Option[String] = None,
      templateArn: Option[String] = None,
      templateData: Option[String] = None
    ): SendTemplatedEmailRequest =
      SendTemplatedEmailRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(returnPath)(_.returnPath(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(returnPathArn)(_.returnPathArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(template)(_.template(_))
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateData)(_.templateData(_))
        .build

    def sendTemplatedEmailResponse(
      messageId: Option[String] = None
    ): SendTemplatedEmailResponse =
      SendTemplatedEmailResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def setActiveReceiptRuleSetRequest(
      ruleSetName: Option[String] = None
    ): SetActiveReceiptRuleSetRequest =
      SetActiveReceiptRuleSetRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .build

    def setActiveReceiptRuleSetResponse(

    ): SetActiveReceiptRuleSetResponse =
      SetActiveReceiptRuleSetResponse
        .builder

        .build

    def setIdentityDkimEnabledRequest(
      identity: Option[String] = None,
      dkimEnabled: Option[Boolean] = None
    ): SetIdentityDkimEnabledRequest =
      SetIdentityDkimEnabledRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(dkimEnabled)(_.dkimEnabled(_))
        .build

    def setIdentityDkimEnabledResponse(

    ): SetIdentityDkimEnabledResponse =
      SetIdentityDkimEnabledResponse
        .builder

        .build

    def setIdentityFeedbackForwardingEnabledRequest(
      identity: Option[String] = None,
      forwardingEnabled: Option[Boolean] = None
    ): SetIdentityFeedbackForwardingEnabledRequest =
      SetIdentityFeedbackForwardingEnabledRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(forwardingEnabled)(_.forwardingEnabled(_))
        .build

    def setIdentityFeedbackForwardingEnabledResponse(

    ): SetIdentityFeedbackForwardingEnabledResponse =
      SetIdentityFeedbackForwardingEnabledResponse
        .builder

        .build

    def setIdentityHeadersInNotificationsEnabledRequest(
      identity: Option[String] = None,
      notificationType: Option[String] = None,
      enabled: Option[Boolean] = None
    ): SetIdentityHeadersInNotificationsEnabledRequest =
      SetIdentityHeadersInNotificationsEnabledRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(notificationType)(_.notificationType(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def setIdentityHeadersInNotificationsEnabledResponse(

    ): SetIdentityHeadersInNotificationsEnabledResponse =
      SetIdentityHeadersInNotificationsEnabledResponse
        .builder

        .build

    def setIdentityMailFromDomainRequest(
      identity: Option[String] = None,
      mailFromDomain: Option[String] = None,
      behaviorOnMXFailure: Option[String] = None
    ): SetIdentityMailFromDomainRequest =
      SetIdentityMailFromDomainRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(mailFromDomain)(_.mailFromDomain(_))
        .ifSome(behaviorOnMXFailure)(_.behaviorOnMXFailure(_))
        .build

    def setIdentityMailFromDomainResponse(

    ): SetIdentityMailFromDomainResponse =
      SetIdentityMailFromDomainResponse
        .builder

        .build

    def setIdentityNotificationTopicRequest(
      identity: Option[String] = None,
      notificationType: Option[String] = None,
      snsTopic: Option[String] = None
    ): SetIdentityNotificationTopicRequest =
      SetIdentityNotificationTopicRequest
        .builder
        .ifSome(identity)(_.identity(_))
        .ifSome(notificationType)(_.notificationType(_))
        .ifSome(snsTopic)(_.snsTopic(_))
        .build

    def setIdentityNotificationTopicResponse(

    ): SetIdentityNotificationTopicResponse =
      SetIdentityNotificationTopicResponse
        .builder

        .build

    def setReceiptRulePositionRequest(
      ruleSetName: Option[String] = None,
      ruleName: Option[String] = None,
      after: Option[String] = None
    ): SetReceiptRulePositionRequest =
      SetReceiptRulePositionRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(after)(_.after(_))
        .build

    def setReceiptRulePositionResponse(

    ): SetReceiptRulePositionResponse =
      SetReceiptRulePositionResponse
        .builder

        .build

    def stopAction(
      scope: Option[String] = None,
      topicArn: Option[String] = None
    ): StopAction =
      StopAction
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def template(
      templateName: Option[String] = None,
      subjectPart: Option[String] = None,
      textPart: Option[String] = None,
      htmlPart: Option[String] = None
    ): Template =
      Template
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(subjectPart)(_.subjectPart(_))
        .ifSome(textPart)(_.textPart(_))
        .ifSome(htmlPart)(_.htmlPart(_))
        .build

    def templateDoesNotExistException(
      templateName: Option[String] = None
    ): TemplateDoesNotExistException =
      TemplateDoesNotExistException
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def templateMetadata(
      name: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None
    ): TemplateMetadata =
      TemplateMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .build

    def testRenderTemplateRequest(
      templateName: Option[String] = None,
      templateData: Option[String] = None
    ): TestRenderTemplateRequest =
      TestRenderTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateData)(_.templateData(_))
        .build

    def testRenderTemplateResponse(
      renderedTemplate: Option[String] = None
    ): TestRenderTemplateResponse =
      TestRenderTemplateResponse
        .builder
        .ifSome(renderedTemplate)(_.renderedTemplate(_))
        .build

    def trackingOptions(
      customRedirectDomain: Option[String] = None
    ): TrackingOptions =
      TrackingOptions
        .builder
        .ifSome(customRedirectDomain)(_.customRedirectDomain(_))
        .build

    def trackingOptionsAlreadyExistsException(
      configurationSetName: Option[String] = None
    ): TrackingOptionsAlreadyExistsException =
      TrackingOptionsAlreadyExistsException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def trackingOptionsDoesNotExistException(
      configurationSetName: Option[String] = None
    ): TrackingOptionsDoesNotExistException =
      TrackingOptionsDoesNotExistException
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .build

    def updateAccountSendingEnabledRequest(
      enabled: Option[Boolean] = None
    ): UpdateAccountSendingEnabledRequest =
      UpdateAccountSendingEnabledRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateConfigurationSetEventDestinationRequest(
      configurationSetName: Option[String] = None,
      eventDestination: Option[EventDestination] = None
    ): UpdateConfigurationSetEventDestinationRequest =
      UpdateConfigurationSetEventDestinationRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(eventDestination)(_.eventDestination(_))
        .build

    def updateConfigurationSetEventDestinationResponse(

    ): UpdateConfigurationSetEventDestinationResponse =
      UpdateConfigurationSetEventDestinationResponse
        .builder

        .build

    def updateConfigurationSetReputationMetricsEnabledRequest(
      configurationSetName: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UpdateConfigurationSetReputationMetricsEnabledRequest =
      UpdateConfigurationSetReputationMetricsEnabledRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateConfigurationSetSendingEnabledRequest(
      configurationSetName: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UpdateConfigurationSetSendingEnabledRequest =
      UpdateConfigurationSetSendingEnabledRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateConfigurationSetTrackingOptionsRequest(
      configurationSetName: Option[String] = None,
      trackingOptions: Option[TrackingOptions] = None
    ): UpdateConfigurationSetTrackingOptionsRequest =
      UpdateConfigurationSetTrackingOptionsRequest
        .builder
        .ifSome(configurationSetName)(_.configurationSetName(_))
        .ifSome(trackingOptions)(_.trackingOptions(_))
        .build

    def updateConfigurationSetTrackingOptionsResponse(

    ): UpdateConfigurationSetTrackingOptionsResponse =
      UpdateConfigurationSetTrackingOptionsResponse
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

    def updateReceiptRuleRequest(
      ruleSetName: Option[String] = None,
      rule: Option[ReceiptRule] = None
    ): UpdateReceiptRuleRequest =
      UpdateReceiptRuleRequest
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(rule)(_.rule(_))
        .build

    def updateReceiptRuleResponse(

    ): UpdateReceiptRuleResponse =
      UpdateReceiptRuleResponse
        .builder

        .build

    def updateTemplateRequest(
      template: Option[Template] = None
    ): UpdateTemplateRequest =
      UpdateTemplateRequest
        .builder
        .ifSome(template)(_.template(_))
        .build

    def updateTemplateResponse(

    ): UpdateTemplateResponse =
      UpdateTemplateResponse
        .builder

        .build

    def verifyDomainDkimRequest(
      domain: Option[String] = None
    ): VerifyDomainDkimRequest =
      VerifyDomainDkimRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def verifyDomainDkimResponse(
      dkimTokens: Option[List[VerificationToken]] = None
    ): VerifyDomainDkimResponse =
      VerifyDomainDkimResponse
        .builder
        .ifSome(dkimTokens)(_.dkimTokens(_))
        .build

    def verifyDomainIdentityRequest(
      domain: Option[String] = None
    ): VerifyDomainIdentityRequest =
      VerifyDomainIdentityRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def verifyDomainIdentityResponse(
      verificationToken: Option[String] = None
    ): VerifyDomainIdentityResponse =
      VerifyDomainIdentityResponse
        .builder
        .ifSome(verificationToken)(_.verificationToken(_))
        .build

    def verifyEmailAddressRequest(
      emailAddress: Option[String] = None
    ): VerifyEmailAddressRequest =
      VerifyEmailAddressRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def verifyEmailIdentityRequest(
      emailAddress: Option[String] = None
    ): VerifyEmailIdentityRequest =
      VerifyEmailIdentityRequest
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def verifyEmailIdentityResponse(

    ): VerifyEmailIdentityResponse =
      VerifyEmailIdentityResponse
        .builder

        .build

    def workmailAction(
      topicArn: Option[String] = None,
      organizationArn: Option[String] = None
    ): WorkmailAction =
      WorkmailAction
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(organizationArn)(_.organizationArn(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
