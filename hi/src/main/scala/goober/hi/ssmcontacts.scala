package goober.hi

import goober.free.ssmcontacts.SsmContactsIO
import software.amazon.awssdk.services.ssmcontacts.model._


object ssmcontacts {
  import goober.free.{ssmcontacts ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptPageRequest(
      pageId: Option[String] = None,
      contactChannelId: Option[String] = None,
      acceptType: Option[String] = None,
      note: Option[String] = None,
      acceptCode: Option[String] = None
    ): AcceptPageRequest =
      AcceptPageRequest
        .builder
        .ifSome(pageId)(_.pageId(_))
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .ifSome(acceptType)(_.acceptType(_))
        .ifSome(note)(_.note(_))
        .ifSome(acceptCode)(_.acceptCode(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def activateContactChannelRequest(
      contactChannelId: Option[String] = None,
      activationCode: Option[String] = None
    ): ActivateContactChannelRequest =
      ActivateContactChannelRequest
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .ifSome(activationCode)(_.activationCode(_))
        .build

    def channelTargetInfo(
      contactChannelId: Option[String] = None,
      retryIntervalInMinutes: Option[Int] = None
    ): ChannelTargetInfo =
      ChannelTargetInfo
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .ifSome(retryIntervalInMinutes)(_.retryIntervalInMinutes(_))
        .build

    def conflictException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def contact(
      contactArn: Option[String] = None,
      alias: Option[String] = None,
      displayName: Option[String] = None,
      `type`: Option[String] = None
    ): Contact =
      Contact
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def contactChannel(
      contactChannelArn: Option[String] = None,
      contactArn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      deliveryAddress: Option[ContactChannelAddress] = None,
      activationStatus: Option[String] = None
    ): ContactChannel =
      ContactChannel
        .builder
        .ifSome(contactChannelArn)(_.contactChannelArn(_))
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(deliveryAddress)(_.deliveryAddress(_))
        .ifSome(activationStatus)(_.activationStatus(_))
        .build

    def contactChannelAddress(
      simpleAddress: Option[String] = None
    ): ContactChannelAddress =
      ContactChannelAddress
        .builder
        .ifSome(simpleAddress)(_.simpleAddress(_))
        .build

    def contactTargetInfo(
      contactId: Option[String] = None,
      isEssential: Option[Boolean] = None
    ): ContactTargetInfo =
      ContactTargetInfo
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(isEssential)(_.isEssential(_))
        .build

    def createContactChannelRequest(
      contactId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      deliveryAddress: Option[ContactChannelAddress] = None,
      deferActivation: Option[Boolean] = None,
      idempotencyToken: Option[String] = None
    ): CreateContactChannelRequest =
      CreateContactChannelRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(deliveryAddress)(_.deliveryAddress(_))
        .ifSome(deferActivation)(_.deferActivation(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createContactRequest(
      alias: Option[String] = None,
      displayName: Option[String] = None,
      `type`: Option[String] = None,
      plan: Option[Plan] = None,
      tags: Option[List[Tag]] = None,
      idempotencyToken: Option[String] = None
    ): CreateContactRequest =
      CreateContactRequest
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(plan)(_.plan(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def dataEncryptionException(
      message: Option[String] = None
    ): DataEncryptionException =
      DataEncryptionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deactivateContactChannelRequest(
      contactChannelId: Option[String] = None
    ): DeactivateContactChannelRequest =
      DeactivateContactChannelRequest
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .build

    def deleteContactChannelRequest(
      contactChannelId: Option[String] = None
    ): DeleteContactChannelRequest =
      DeleteContactChannelRequest
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .build

    def deleteContactRequest(
      contactId: Option[String] = None
    ): DeleteContactRequest =
      DeleteContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def describeEngagementRequest(
      engagementId: Option[String] = None
    ): DescribeEngagementRequest =
      DescribeEngagementRequest
        .builder
        .ifSome(engagementId)(_.engagementId(_))
        .build

    def describePageRequest(
      pageId: Option[String] = None
    ): DescribePageRequest =
      DescribePageRequest
        .builder
        .ifSome(pageId)(_.pageId(_))
        .build

    def engagement(
      engagementArn: Option[String] = None,
      contactArn: Option[String] = None,
      sender: Option[String] = None,
      incidentId: Option[String] = None,
      startTime: Option[DateTime] = None,
      stopTime: Option[DateTime] = None
    ): Engagement =
      Engagement
        .builder
        .ifSome(engagementArn)(_.engagementArn(_))
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(sender)(_.sender(_))
        .ifSome(incidentId)(_.incidentId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(stopTime)(_.stopTime(_))
        .build

    def getContactChannelRequest(
      contactChannelId: Option[String] = None
    ): GetContactChannelRequest =
      GetContactChannelRequest
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .build

    def getContactPolicyRequest(
      contactArn: Option[String] = None
    ): GetContactPolicyRequest =
      GetContactPolicyRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .build

    def getContactRequest(
      contactId: Option[String] = None
    ): GetContactRequest =
      GetContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def listContactChannelsRequest(
      contactId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListContactChannelsRequest =
      ListContactChannelsRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listContactsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      aliasPrefix: Option[String] = None,
      `type`: Option[String] = None
    ): ListContactsRequest =
      ListContactsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(aliasPrefix)(_.aliasPrefix(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def listEngagementsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      incidentId: Option[String] = None,
      timeRangeValue: Option[TimeRange] = None
    ): ListEngagementsRequest =
      ListEngagementsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(incidentId)(_.incidentId(_))
        .ifSome(timeRangeValue)(_.timeRangeValue(_))
        .build

    def listPageReceiptsRequest(
      pageId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPageReceiptsRequest =
      ListPageReceiptsRequest
        .builder
        .ifSome(pageId)(_.pageId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPagesByContactRequest(
      contactId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPagesByContactRequest =
      ListPagesByContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPagesByEngagementRequest(
      engagementId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPagesByEngagementRequest =
      ListPagesByEngagementRequest
        .builder
        .ifSome(engagementId)(_.engagementId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def page(
      pageArn: Option[String] = None,
      engagementArn: Option[String] = None,
      contactArn: Option[String] = None,
      sender: Option[String] = None,
      incidentId: Option[String] = None,
      sentTime: Option[DateTime] = None,
      deliveryTime: Option[DateTime] = None,
      readTime: Option[DateTime] = None
    ): Page =
      Page
        .builder
        .ifSome(pageArn)(_.pageArn(_))
        .ifSome(engagementArn)(_.engagementArn(_))
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(sender)(_.sender(_))
        .ifSome(incidentId)(_.incidentId(_))
        .ifSome(sentTime)(_.sentTime(_))
        .ifSome(deliveryTime)(_.deliveryTime(_))
        .ifSome(readTime)(_.readTime(_))
        .build

    def plan(
      stages: Option[List[Stage]] = None
    ): Plan =
      Plan
        .builder
        .ifSome(stages)(_.stages(_))
        .build

    def putContactPolicyRequest(
      contactArn: Option[String] = None,
      policy: Option[String] = None
    ): PutContactPolicyRequest =
      PutContactPolicyRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def receipt(
      contactChannelArn: Option[String] = None,
      receiptType: Option[String] = None,
      receiptInfo: Option[String] = None,
      receiptTime: Option[DateTime] = None
    ): Receipt =
      Receipt
        .builder
        .ifSome(contactChannelArn)(_.contactChannelArn(_))
        .ifSome(receiptType)(_.receiptType(_))
        .ifSome(receiptInfo)(_.receiptInfo(_))
        .ifSome(receiptTime)(_.receiptTime(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def sendActivationCodeRequest(
      contactChannelId: Option[String] = None
    ): SendActivationCodeRequest =
      SendActivationCodeRequest
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def stage(
      durationInMinutes: Option[Int] = None,
      targets: Option[List[Target]] = None
    ): Stage =
      Stage
        .builder
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .ifSome(targets)(_.targets(_))
        .build

    def startEngagementRequest(
      contactId: Option[String] = None,
      sender: Option[String] = None,
      subject: Option[String] = None,
      content: Option[String] = None,
      publicSubject: Option[String] = None,
      publicContent: Option[String] = None,
      incidentId: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): StartEngagementRequest =
      StartEngagementRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(sender)(_.sender(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(content)(_.content(_))
        .ifSome(publicSubject)(_.publicSubject(_))
        .ifSome(publicContent)(_.publicContent(_))
        .ifSome(incidentId)(_.incidentId(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def stopEngagementRequest(
      engagementId: Option[String] = None,
      reason: Option[String] = None
    ): StopEngagementRequest =
      StopEngagementRequest
        .builder
        .ifSome(engagementId)(_.engagementId(_))
        .ifSome(reason)(_.reason(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def target(
      channelTargetInfo: Option[ChannelTargetInfo] = None,
      contactTargetInfo: Option[ContactTargetInfo] = None
    ): Target =
      Target
        .builder
        .ifSome(channelTargetInfo)(_.channelTargetInfo(_))
        .ifSome(contactTargetInfo)(_.contactTargetInfo(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def timeRange(
      startTime: Option[DateTime] = None,
      endTime: Option[DateTime] = None
    ): TimeRange =
      TimeRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateContactChannelRequest(
      contactChannelId: Option[String] = None,
      name: Option[String] = None,
      deliveryAddress: Option[ContactChannelAddress] = None
    ): UpdateContactChannelRequest =
      UpdateContactChannelRequest
        .builder
        .ifSome(contactChannelId)(_.contactChannelId(_))
        .ifSome(name)(_.name(_))
        .ifSome(deliveryAddress)(_.deliveryAddress(_))
        .build

    def updateContactRequest(
      contactId: Option[String] = None,
      displayName: Option[String] = None,
      plan: Option[Plan] = None
    ): UpdateContactRequest =
      UpdateContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(plan)(_.plan(_))
        .build

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
        .build

    def validationExceptionField(
      name: Option[String] = None,
      message: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
