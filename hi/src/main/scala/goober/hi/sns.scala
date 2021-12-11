package goober.hi

import goober.free.sns.SnsIO
import software.amazon.awssdk.services.sns.model._


object sns {
  import goober.free.{sns ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addPermissionInput(
      topicArn: Option[String] = None,
      label: Option[String] = None,
      aWSAccountId: Option[List[delegate]] = None,
      actionName: Option[List[action]] = None
    ): AddPermissionInput =
      AddPermissionInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(label)(_.label(_))
        .ifSome(aWSAccountId)(_.aWSAccountId(_))
        .ifSome(actionName)(_.actionName(_))
        .build

    def authorizationErrorException(
      message: Option[String] = None
    ): AuthorizationErrorException =
      AuthorizationErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def checkIfPhoneNumberIsOptedOutInput(
      phoneNumber: Option[String] = None
    ): CheckIfPhoneNumberIsOptedOutInput =
      CheckIfPhoneNumberIsOptedOutInput
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def checkIfPhoneNumberIsOptedOutResponse(
      isOptedOut: Option[Boolean] = None
    ): CheckIfPhoneNumberIsOptedOutResponse =
      CheckIfPhoneNumberIsOptedOutResponse
        .builder
        .ifSome(isOptedOut)(_.isOptedOut(_))
        .build

    def concurrentAccessException(
      message: Option[String] = None
    ): ConcurrentAccessException =
      ConcurrentAccessException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def confirmSubscriptionInput(
      topicArn: Option[String] = None,
      token: Option[String] = None,
      authenticateOnUnsubscribe: Option[String] = None
    ): ConfirmSubscriptionInput =
      ConfirmSubscriptionInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(token)(_.token(_))
        .ifSome(authenticateOnUnsubscribe)(_.authenticateOnUnsubscribe(_))
        .build

    def confirmSubscriptionResponse(
      subscriptionArn: Option[String] = None
    ): ConfirmSubscriptionResponse =
      ConfirmSubscriptionResponse
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def createEndpointResponse(
      endpointArn: Option[String] = None
    ): CreateEndpointResponse =
      CreateEndpointResponse
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def createPlatformApplicationInput(
      name: Option[String] = None,
      platform: Option[String] = None,
      attributes: Option[MapStringToString] = None
    ): CreatePlatformApplicationInput =
      CreatePlatformApplicationInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def createPlatformApplicationResponse(
      platformApplicationArn: Option[String] = None
    ): CreatePlatformApplicationResponse =
      CreatePlatformApplicationResponse
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .build

    def createPlatformEndpointInput(
      platformApplicationArn: Option[String] = None,
      token: Option[String] = None,
      customUserData: Option[String] = None,
      attributes: Option[MapStringToString] = None
    ): CreatePlatformEndpointInput =
      CreatePlatformEndpointInput
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .ifSome(token)(_.token(_))
        .ifSome(customUserData)(_.customUserData(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def createSMSSandboxPhoneNumberInput(
      phoneNumber: Option[String] = None,
      languageCode: Option[String] = None
    ): CreateSMSSandboxPhoneNumberInput =
      CreateSMSSandboxPhoneNumberInput
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def createTopicInput(
      name: Option[String] = None,
      attributes: Option[TopicAttributesMap] = None,
      tags: Option[List[Tag]] = None
    ): CreateTopicInput =
      CreateTopicInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTopicResponse(
      topicArn: Option[String] = None
    ): CreateTopicResponse =
      CreateTopicResponse
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def deleteEndpointInput(
      endpointArn: Option[String] = None
    ): DeleteEndpointInput =
      DeleteEndpointInput
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def deletePlatformApplicationInput(
      platformApplicationArn: Option[String] = None
    ): DeletePlatformApplicationInput =
      DeletePlatformApplicationInput
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .build

    def deleteSMSSandboxPhoneNumberInput(
      phoneNumber: Option[String] = None
    ): DeleteSMSSandboxPhoneNumberInput =
      DeleteSMSSandboxPhoneNumberInput
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def deleteTopicInput(
      topicArn: Option[String] = None
    ): DeleteTopicInput =
      DeleteTopicInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def endpoint(
      endpointArn: Option[String] = None,
      attributes: Option[MapStringToString] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def endpointDisabledException(
      message: Option[String] = None
    ): EndpointDisabledException =
      EndpointDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def filterPolicyLimitExceededException(
      message: Option[String] = None
    ): FilterPolicyLimitExceededException =
      FilterPolicyLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getEndpointAttributesInput(
      endpointArn: Option[String] = None
    ): GetEndpointAttributesInput =
      GetEndpointAttributesInput
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def getEndpointAttributesResponse(
      attributes: Option[MapStringToString] = None
    ): GetEndpointAttributesResponse =
      GetEndpointAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getPlatformApplicationAttributesInput(
      platformApplicationArn: Option[String] = None
    ): GetPlatformApplicationAttributesInput =
      GetPlatformApplicationAttributesInput
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .build

    def getPlatformApplicationAttributesResponse(
      attributes: Option[MapStringToString] = None
    ): GetPlatformApplicationAttributesResponse =
      GetPlatformApplicationAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getSMSAttributesInput(
      attributes: Option[List[String]] = None
    ): GetSMSAttributesInput =
      GetSMSAttributesInput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getSMSAttributesResponse(
      attributes: Option[MapStringToString] = None
    ): GetSMSAttributesResponse =
      GetSMSAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getSMSSandboxAccountStatusInput(

    ): GetSMSSandboxAccountStatusInput =
      GetSMSSandboxAccountStatusInput
        .builder

        .build

    def getSubscriptionAttributesInput(
      subscriptionArn: Option[String] = None
    ): GetSubscriptionAttributesInput =
      GetSubscriptionAttributesInput
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def getSubscriptionAttributesResponse(
      attributes: Option[SubscriptionAttributesMap] = None
    ): GetSubscriptionAttributesResponse =
      GetSubscriptionAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def getTopicAttributesInput(
      topicArn: Option[String] = None
    ): GetTopicAttributesInput =
      GetTopicAttributesInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def getTopicAttributesResponse(
      attributes: Option[TopicAttributesMap] = None
    ): GetTopicAttributesResponse =
      GetTopicAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSecurityException(
      message: Option[String] = None
    ): InvalidSecurityException =
      InvalidSecurityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSAccessDeniedException(
      message: Option[String] = None
    ): KMSAccessDeniedException =
      KMSAccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSDisabledException(
      message: Option[String] = None
    ): KMSDisabledException =
      KMSDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSInvalidStateException(
      message: Option[String] = None
    ): KMSInvalidStateException =
      KMSInvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSNotFoundException(
      message: Option[String] = None
    ): KMSNotFoundException =
      KMSNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSOptInRequired(
      message: Option[String] = None
    ): KMSOptInRequired =
      KMSOptInRequired
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSThrottlingException(
      message: Option[String] = None
    ): KMSThrottlingException =
      KMSThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listEndpointsByPlatformApplicationInput(
      platformApplicationArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListEndpointsByPlatformApplicationInput =
      ListEndpointsByPlatformApplicationInput
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEndpointsByPlatformApplicationResponse(
      endpoints: Option[List[Endpoint]] = None,
      nextToken: Option[String] = None
    ): ListEndpointsByPlatformApplicationResponse =
      ListEndpointsByPlatformApplicationResponse
        .builder
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOriginationNumbersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListOriginationNumbersRequest =
      ListOriginationNumbersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPhoneNumbersOptedOutInput(
      nextToken: Option[String] = None
    ): ListPhoneNumbersOptedOutInput =
      ListPhoneNumbersOptedOutInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPhoneNumbersOptedOutResponse(
      phoneNumbers: Option[List[PhoneNumber]] = None,
      nextToken: Option[String] = None
    ): ListPhoneNumbersOptedOutResponse =
      ListPhoneNumbersOptedOutResponse
        .builder
        .ifSome(phoneNumbers)(_.phoneNumbers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlatformApplicationsInput(
      nextToken: Option[String] = None
    ): ListPlatformApplicationsInput =
      ListPlatformApplicationsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlatformApplicationsResponse(
      platformApplications: Option[List[PlatformApplication]] = None,
      nextToken: Option[String] = None
    ): ListPlatformApplicationsResponse =
      ListPlatformApplicationsResponse
        .builder
        .ifSome(platformApplications)(_.platformApplications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSMSSandboxPhoneNumbersInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSMSSandboxPhoneNumbersInput =
      ListSMSSandboxPhoneNumbersInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSubscriptionsByTopicInput(
      topicArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListSubscriptionsByTopicInput =
      ListSubscriptionsByTopicInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSubscriptionsByTopicResponse(
      subscriptions: Option[List[Subscription]] = None,
      nextToken: Option[String] = None
    ): ListSubscriptionsByTopicResponse =
      ListSubscriptionsByTopicResponse
        .builder
        .ifSome(subscriptions)(_.subscriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSubscriptionsInput(
      nextToken: Option[String] = None
    ): ListSubscriptionsInput =
      ListSubscriptionsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSubscriptionsResponse(
      subscriptions: Option[List[Subscription]] = None,
      nextToken: Option[String] = None
    ): ListSubscriptionsResponse =
      ListSubscriptionsResponse
        .builder
        .ifSome(subscriptions)(_.subscriptions(_))
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

    def listTopicsInput(
      nextToken: Option[String] = None
    ): ListTopicsInput =
      ListTopicsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTopicsResponse(
      topics: Option[List[Topic]] = None,
      nextToken: Option[String] = None
    ): ListTopicsResponse =
      ListTopicsResponse
        .builder
        .ifSome(topics)(_.topics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def messageAttributeValue(
      dataType: Option[String] = None,
      stringValue: Option[String] = None,
      binaryValue: Option[Binary] = None
    ): MessageAttributeValue =
      MessageAttributeValue
        .builder
        .ifSome(dataType)(_.dataType(_))
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(binaryValue)(_.binaryValue(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def optInPhoneNumberInput(
      phoneNumber: Option[String] = None
    ): OptInPhoneNumberInput =
      OptInPhoneNumberInput
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def optInPhoneNumberResponse(

    ): OptInPhoneNumberResponse =
      OptInPhoneNumberResponse
        .builder

        .build

    def optedOutException(
      message: Option[String] = None
    ): OptedOutException =
      OptedOutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def phoneNumberInformation(
      createdAt: Option[Timestamp] = None,
      phoneNumber: Option[String] = None,
      status: Option[String] = None,
      iso2CountryCode: Option[String] = None,
      routeType: Option[String] = None,
      numberCapabilities: Option[List[NumberCapability]] = None
    ): PhoneNumberInformation =
      PhoneNumberInformation
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(iso2CountryCode)(_.iso2CountryCode(_))
        .ifSome(routeType)(_.routeType(_))
        .ifSome(numberCapabilities)(_.numberCapabilities(_))
        .build

    def platformApplication(
      platformApplicationArn: Option[String] = None,
      attributes: Option[MapStringToString] = None
    ): PlatformApplication =
      PlatformApplication
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def platformApplicationDisabledException(
      message: Option[String] = None
    ): PlatformApplicationDisabledException =
      PlatformApplicationDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publishInput(
      topicArn: Option[String] = None,
      targetArn: Option[String] = None,
      phoneNumber: Option[String] = None,
      message: Option[String] = None,
      subject: Option[String] = None,
      messageStructure: Option[String] = None,
      messageAttributes: Option[MessageAttributeMap] = None,
      messageDeduplicationId: Option[String] = None,
      messageGroupId: Option[String] = None
    ): PublishInput =
      PublishInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(message)(_.message(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(messageStructure)(_.messageStructure(_))
        .ifSome(messageAttributes)(_.messageAttributes(_))
        .ifSome(messageDeduplicationId)(_.messageDeduplicationId(_))
        .ifSome(messageGroupId)(_.messageGroupId(_))
        .build

    def publishResponse(
      messageId: Option[String] = None,
      sequenceNumber: Option[String] = None
    ): PublishResponse =
      PublishResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .build

    def removePermissionInput(
      topicArn: Option[String] = None,
      label: Option[String] = None
    ): RemovePermissionInput =
      RemovePermissionInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(label)(_.label(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sMSSandboxPhoneNumber(
      phoneNumber: Option[String] = None,
      status: Option[String] = None
    ): SMSSandboxPhoneNumber =
      SMSSandboxPhoneNumber
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(status)(_.status(_))
        .build

    def setEndpointAttributesInput(
      endpointArn: Option[String] = None,
      attributes: Option[MapStringToString] = None
    ): SetEndpointAttributesInput =
      SetEndpointAttributesInput
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def setPlatformApplicationAttributesInput(
      platformApplicationArn: Option[String] = None,
      attributes: Option[MapStringToString] = None
    ): SetPlatformApplicationAttributesInput =
      SetPlatformApplicationAttributesInput
        .builder
        .ifSome(platformApplicationArn)(_.platformApplicationArn(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def setSMSAttributesInput(
      attributes: Option[MapStringToString] = None
    ): SetSMSAttributesInput =
      SetSMSAttributesInput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def setSMSAttributesResponse(

    ): SetSMSAttributesResponse =
      SetSMSAttributesResponse
        .builder

        .build

    def setSubscriptionAttributesInput(
      subscriptionArn: Option[String] = None,
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): SetSubscriptionAttributesInput =
      SetSubscriptionAttributesInput
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def setTopicAttributesInput(
      topicArn: Option[String] = None,
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): SetTopicAttributesInput =
      SetTopicAttributesInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def staleTagException(
      message: Option[String] = None
    ): StaleTagException =
      StaleTagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def subscribeInput(
      topicArn: Option[String] = None,
      protocol: Option[String] = None,
      endpoint: Option[String] = None,
      attributes: Option[SubscriptionAttributesMap] = None,
      returnSubscriptionArn: Option[Boolean] = None
    ): SubscribeInput =
      SubscribeInput
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(returnSubscriptionArn)(_.returnSubscriptionArn(_))
        .build

    def subscribeResponse(
      subscriptionArn: Option[String] = None
    ): SubscribeResponse =
      SubscribeResponse
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def subscription(
      subscriptionArn: Option[String] = None,
      owner: Option[String] = None,
      protocol: Option[String] = None,
      endpoint: Option[String] = None,
      topicArn: Option[String] = None
    ): Subscription =
      Subscription
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def subscriptionLimitExceededException(
      message: Option[String] = None
    ): SubscriptionLimitExceededException =
      SubscriptionLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
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

    def tagLimitExceededException(
      message: Option[String] = None
    ): TagLimitExceededException =
      TagLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagPolicyException(
      message: Option[String] = None
    ): TagPolicyException =
      TagPolicyException
        .builder
        .ifSome(message)(_.message(_))
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

    def throttledException(
      message: Option[String] = None
    ): ThrottledException =
      ThrottledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def topic(
      topicArn: Option[String] = None
    ): Topic =
      Topic
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def topicLimitExceededException(
      message: Option[String] = None
    ): TopicLimitExceededException =
      TopicLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsubscribeInput(
      subscriptionArn: Option[String] = None
    ): UnsubscribeInput =
      UnsubscribeInput
        .builder
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
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

    def userErrorException(
      message: Option[String] = None
    ): UserErrorException =
      UserErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def verificationException(
      message: Option[String] = None,
      status: Option[String] = None
    ): VerificationException =
      VerificationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(status)(_.status(_))
        .build

    def verifySMSSandboxPhoneNumberInput(
      phoneNumber: Option[String] = None,
      oneTimePassword: Option[String] = None
    ): VerifySMSSandboxPhoneNumberInput =
      VerifySMSSandboxPhoneNumberInput
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(oneTimePassword)(_.oneTimePassword(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
