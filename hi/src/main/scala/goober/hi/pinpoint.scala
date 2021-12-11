package goober.hi

import goober.free.pinpoint.PinpointIO
import software.amazon.awssdk.services.pinpoint.model._


object pinpoint {
  import goober.free.{pinpoint ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aDMChannelRequest(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      enabled: Option[Boolean] = None
    ): ADMChannelRequest =
      ADMChannelRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def aDMChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): ADMChannelResponse =
      ADMChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def aDMMessage(
      action: Option[String] = None,
      body: Option[String] = None,
      consolidationKey: Option[String] = None,
      data: Option[MapOf__string] = None,
      expiresAfter: Option[String] = None,
      iconReference: Option[String] = None,
      imageIconUrl: Option[String] = None,
      imageUrl: Option[String] = None,
      mD5: Option[String] = None,
      rawContent: Option[String] = None,
      silentPush: Option[Boolean] = None,
      smallImageIconUrl: Option[String] = None,
      sound: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): ADMMessage =
      ADMMessage
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(consolidationKey)(_.consolidationKey(_))
        .ifSome(data)(_.data(_))
        .ifSome(expiresAfter)(_.expiresAfter(_))
        .ifSome(iconReference)(_.iconReference(_))
        .ifSome(imageIconUrl)(_.imageIconUrl(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(mD5)(_.mD5(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(silentPush)(_.silentPush(_))
        .ifSome(smallImageIconUrl)(_.smallImageIconUrl(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def aPNSChannelRequest(
      bundleId: Option[String] = None,
      certificate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      privateKey: Option[String] = None,
      teamId: Option[String] = None,
      tokenKey: Option[String] = None,
      tokenKeyId: Option[String] = None
    ): APNSChannelRequest =
      APNSChannelRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(teamId)(_.teamId(_))
        .ifSome(tokenKey)(_.tokenKey(_))
        .ifSome(tokenKeyId)(_.tokenKeyId(_))
        .build

    def aPNSChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      hasTokenKey: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): APNSChannelResponse =
      APNSChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(hasTokenKey)(_.hasTokenKey(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def aPNSMessage(
      aPNSPushType: Option[String] = None,
      action: Option[String] = None,
      badge: Option[Int] = None,
      body: Option[String] = None,
      category: Option[String] = None,
      collapseId: Option[String] = None,
      data: Option[MapOf__string] = None,
      mediaUrl: Option[String] = None,
      preferredAuthenticationMethod: Option[String] = None,
      priority: Option[String] = None,
      rawContent: Option[String] = None,
      silentPush: Option[Boolean] = None,
      sound: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      threadId: Option[String] = None,
      timeToLive: Option[Int] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): APNSMessage =
      APNSMessage
        .builder
        .ifSome(aPNSPushType)(_.aPNSPushType(_))
        .ifSome(action)(_.action(_))
        .ifSome(badge)(_.badge(_))
        .ifSome(body)(_.body(_))
        .ifSome(category)(_.category(_))
        .ifSome(collapseId)(_.collapseId(_))
        .ifSome(data)(_.data(_))
        .ifSome(mediaUrl)(_.mediaUrl(_))
        .ifSome(preferredAuthenticationMethod)(_.preferredAuthenticationMethod(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(silentPush)(_.silentPush(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(threadId)(_.threadId(_))
        .ifSome(timeToLive)(_.timeToLive(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def aPNSPushNotificationTemplate(
      action: Option[String] = None,
      body: Option[String] = None,
      mediaUrl: Option[String] = None,
      rawContent: Option[String] = None,
      sound: Option[String] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): APNSPushNotificationTemplate =
      APNSPushNotificationTemplate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(mediaUrl)(_.mediaUrl(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def aPNSSandboxChannelRequest(
      bundleId: Option[String] = None,
      certificate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      privateKey: Option[String] = None,
      teamId: Option[String] = None,
      tokenKey: Option[String] = None,
      tokenKeyId: Option[String] = None
    ): APNSSandboxChannelRequest =
      APNSSandboxChannelRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(teamId)(_.teamId(_))
        .ifSome(tokenKey)(_.tokenKey(_))
        .ifSome(tokenKeyId)(_.tokenKeyId(_))
        .build

    def aPNSSandboxChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      hasTokenKey: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): APNSSandboxChannelResponse =
      APNSSandboxChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(hasTokenKey)(_.hasTokenKey(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def aPNSVoipChannelRequest(
      bundleId: Option[String] = None,
      certificate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      privateKey: Option[String] = None,
      teamId: Option[String] = None,
      tokenKey: Option[String] = None,
      tokenKeyId: Option[String] = None
    ): APNSVoipChannelRequest =
      APNSVoipChannelRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(teamId)(_.teamId(_))
        .ifSome(tokenKey)(_.tokenKey(_))
        .ifSome(tokenKeyId)(_.tokenKeyId(_))
        .build

    def aPNSVoipChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      hasTokenKey: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): APNSVoipChannelResponse =
      APNSVoipChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(hasTokenKey)(_.hasTokenKey(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def aPNSVoipSandboxChannelRequest(
      bundleId: Option[String] = None,
      certificate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      privateKey: Option[String] = None,
      teamId: Option[String] = None,
      tokenKey: Option[String] = None,
      tokenKeyId: Option[String] = None
    ): APNSVoipSandboxChannelRequest =
      APNSVoipSandboxChannelRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(teamId)(_.teamId(_))
        .ifSome(tokenKey)(_.tokenKey(_))
        .ifSome(tokenKeyId)(_.tokenKeyId(_))
        .build

    def aPNSVoipSandboxChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      defaultAuthenticationMethod: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      hasTokenKey: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): APNSVoipSandboxChannelResponse =
      APNSVoipSandboxChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultAuthenticationMethod)(_.defaultAuthenticationMethod(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(hasTokenKey)(_.hasTokenKey(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def activitiesResponse(
      item: Option[List[ActivityResponse]] = None,
      nextToken: Option[String] = None
    ): ActivitiesResponse =
      ActivitiesResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def activity(
      cUSTOM: Option[CustomMessageActivity] = None,
      conditionalSplit: Option[ConditionalSplitActivity] = None,
      description: Option[String] = None,
      eMAIL: Option[EmailMessageActivity] = None,
      holdout: Option[HoldoutActivity] = None,
      multiCondition: Option[MultiConditionalSplitActivity] = None,
      pUSH: Option[PushMessageActivity] = None,
      randomSplit: Option[RandomSplitActivity] = None,
      sMS: Option[SMSMessageActivity] = None,
      wait: Option[WaitActivity] = None
    ): Activity =
      Activity
        .builder
        .ifSome(cUSTOM)(_.cUSTOM(_))
        .ifSome(conditionalSplit)(_.conditionalSplit(_))
        .ifSome(description)(_.description(_))
        .ifSome(eMAIL)(_.eMAIL(_))
        .ifSome(holdout)(_.holdout(_))
        .ifSome(multiCondition)(_.multiCondition(_))
        .ifSome(pUSH)(_.pUSH(_))
        .ifSome(randomSplit)(_.randomSplit(_))
        .ifSome(sMS)(_.sMS(_))
        .ifSome(wait)(_.wait(_))
        .build

    def activityResponse(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      end: Option[String] = None,
      id: Option[String] = None,
      result: Option[String] = None,
      scheduledStart: Option[String] = None,
      start: Option[String] = None,
      state: Option[String] = None,
      successfulEndpointCount: Option[Int] = None,
      timezonesCompletedCount: Option[Int] = None,
      timezonesTotalCount: Option[Int] = None,
      totalEndpointCount: Option[Int] = None,
      treatmentId: Option[String] = None
    ): ActivityResponse =
      ActivityResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(end)(_.end(_))
        .ifSome(id)(_.id(_))
        .ifSome(result)(_.result(_))
        .ifSome(scheduledStart)(_.scheduledStart(_))
        .ifSome(start)(_.start(_))
        .ifSome(state)(_.state(_))
        .ifSome(successfulEndpointCount)(_.successfulEndpointCount(_))
        .ifSome(timezonesCompletedCount)(_.timezonesCompletedCount(_))
        .ifSome(timezonesTotalCount)(_.timezonesTotalCount(_))
        .ifSome(totalEndpointCount)(_.totalEndpointCount(_))
        .ifSome(treatmentId)(_.treatmentId(_))
        .build

    def addressConfiguration(
      bodyOverride: Option[String] = None,
      channelType: Option[String] = None,
      context: Option[MapOf__string] = None,
      rawContent: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      titleOverride: Option[String] = None
    ): AddressConfiguration =
      AddressConfiguration
        .builder
        .ifSome(bodyOverride)(_.bodyOverride(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(context)(_.context(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(titleOverride)(_.titleOverride(_))
        .build

    def androidPushNotificationTemplate(
      action: Option[String] = None,
      body: Option[String] = None,
      imageIconUrl: Option[String] = None,
      imageUrl: Option[String] = None,
      rawContent: Option[String] = None,
      smallImageIconUrl: Option[String] = None,
      sound: Option[String] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): AndroidPushNotificationTemplate =
      AndroidPushNotificationTemplate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(imageIconUrl)(_.imageIconUrl(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(smallImageIconUrl)(_.smallImageIconUrl(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def applicationDateRangeKpiResponse(
      applicationId: Option[String] = None,
      endTime: Option[__timestampIso8601] = None,
      kpiName: Option[String] = None,
      kpiResult: Option[BaseKpiResult] = None,
      nextToken: Option[String] = None,
      startTime: Option[__timestampIso8601] = None
    ): ApplicationDateRangeKpiResponse =
      ApplicationDateRangeKpiResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(kpiName)(_.kpiName(_))
        .ifSome(kpiResult)(_.kpiResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def applicationResponse(
      arn: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      tags: Option[MapOf__string] = None
    ): ApplicationResponse =
      ApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def applicationSettingsResource(
      applicationId: Option[String] = None,
      campaignHook: Option[CampaignHook] = None,
      lastModifiedDate: Option[String] = None,
      limits: Option[CampaignLimits] = None,
      quietTime: Option[QuietTime] = None
    ): ApplicationSettingsResource =
      ApplicationSettingsResource
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignHook)(_.campaignHook(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(quietTime)(_.quietTime(_))
        .build

    def applicationsResponse(
      item: Option[List[ApplicationResponse]] = None,
      nextToken: Option[String] = None
    ): ApplicationsResponse =
      ApplicationsResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def attributeDimension(
      attributeType: Option[String] = None,
      values: Option[List[__string]] = None
    ): AttributeDimension =
      AttributeDimension
        .builder
        .ifSome(attributeType)(_.attributeType(_))
        .ifSome(values)(_.values(_))
        .build

    def attributesResource(
      applicationId: Option[String] = None,
      attributeType: Option[String] = None,
      attributes: Option[List[__string]] = None
    ): AttributesResource =
      AttributesResource
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(attributeType)(_.attributeType(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def badRequestException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def baiduChannelRequest(
      apiKey: Option[String] = None,
      enabled: Option[Boolean] = None,
      secretKey: Option[String] = None
    ): BaiduChannelRequest =
      BaiduChannelRequest
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(secretKey)(_.secretKey(_))
        .build

    def baiduChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      credential: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): BaiduChannelResponse =
      BaiduChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(credential)(_.credential(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def baiduMessage(
      action: Option[String] = None,
      body: Option[String] = None,
      data: Option[MapOf__string] = None,
      iconReference: Option[String] = None,
      imageIconUrl: Option[String] = None,
      imageUrl: Option[String] = None,
      rawContent: Option[String] = None,
      silentPush: Option[Boolean] = None,
      smallImageIconUrl: Option[String] = None,
      sound: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      timeToLive: Option[Int] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): BaiduMessage =
      BaiduMessage
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(data)(_.data(_))
        .ifSome(iconReference)(_.iconReference(_))
        .ifSome(imageIconUrl)(_.imageIconUrl(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(silentPush)(_.silentPush(_))
        .ifSome(smallImageIconUrl)(_.smallImageIconUrl(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(timeToLive)(_.timeToLive(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def campaignCustomMessage(
      data: Option[String] = None
    ): CampaignCustomMessage =
      CampaignCustomMessage
        .builder
        .ifSome(data)(_.data(_))
        .build

    def campaignDateRangeKpiResponse(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      endTime: Option[__timestampIso8601] = None,
      kpiName: Option[String] = None,
      kpiResult: Option[BaseKpiResult] = None,
      nextToken: Option[String] = None,
      startTime: Option[__timestampIso8601] = None
    ): CampaignDateRangeKpiResponse =
      CampaignDateRangeKpiResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(kpiName)(_.kpiName(_))
        .ifSome(kpiResult)(_.kpiResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def campaignEmailMessage(
      body: Option[String] = None,
      fromAddress: Option[String] = None,
      htmlBody: Option[String] = None,
      title: Option[String] = None
    ): CampaignEmailMessage =
      CampaignEmailMessage
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(fromAddress)(_.fromAddress(_))
        .ifSome(htmlBody)(_.htmlBody(_))
        .ifSome(title)(_.title(_))
        .build

    def campaignEventFilter(
      dimensions: Option[EventDimensions] = None,
      filterType: Option[String] = None
    ): CampaignEventFilter =
      CampaignEventFilter
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(filterType)(_.filterType(_))
        .build

    def campaignHook(
      lambdaFunctionName: Option[String] = None,
      mode: Option[String] = None,
      webUrl: Option[String] = None
    ): CampaignHook =
      CampaignHook
        .builder
        .ifSome(lambdaFunctionName)(_.lambdaFunctionName(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(webUrl)(_.webUrl(_))
        .build

    def campaignLimits(
      daily: Option[Int] = None,
      maximumDuration: Option[Int] = None,
      messagesPerSecond: Option[Int] = None,
      total: Option[Int] = None
    ): CampaignLimits =
      CampaignLimits
        .builder
        .ifSome(daily)(_.daily(_))
        .ifSome(maximumDuration)(_.maximumDuration(_))
        .ifSome(messagesPerSecond)(_.messagesPerSecond(_))
        .ifSome(total)(_.total(_))
        .build

    def campaignResponse(
      additionalTreatments: Option[List[TreatmentResource]] = None,
      applicationId: Option[String] = None,
      arn: Option[String] = None,
      creationDate: Option[String] = None,
      customDeliveryConfiguration: Option[CustomDeliveryConfiguration] = None,
      defaultState: Option[CampaignState] = None,
      description: Option[String] = None,
      holdoutPercent: Option[Int] = None,
      hook: Option[CampaignHook] = None,
      id: Option[String] = None,
      isPaused: Option[Boolean] = None,
      lastModifiedDate: Option[String] = None,
      limits: Option[CampaignLimits] = None,
      messageConfiguration: Option[MessageConfiguration] = None,
      name: Option[String] = None,
      schedule: Option[Schedule] = None,
      segmentId: Option[String] = None,
      segmentVersion: Option[Int] = None,
      state: Option[CampaignState] = None,
      tags: Option[MapOf__string] = None,
      templateConfiguration: Option[TemplateConfiguration] = None,
      treatmentDescription: Option[String] = None,
      treatmentName: Option[String] = None,
      version: Option[Int] = None
    ): CampaignResponse =
      CampaignResponse
        .builder
        .ifSome(additionalTreatments)(_.additionalTreatments(_))
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(customDeliveryConfiguration)(_.customDeliveryConfiguration(_))
        .ifSome(defaultState)(_.defaultState(_))
        .ifSome(description)(_.description(_))
        .ifSome(holdoutPercent)(_.holdoutPercent(_))
        .ifSome(hook)(_.hook(_))
        .ifSome(id)(_.id(_))
        .ifSome(isPaused)(_.isPaused(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(messageConfiguration)(_.messageConfiguration(_))
        .ifSome(name)(_.name(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(segmentVersion)(_.segmentVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateConfiguration)(_.templateConfiguration(_))
        .ifSome(treatmentDescription)(_.treatmentDescription(_))
        .ifSome(treatmentName)(_.treatmentName(_))
        .ifSome(version)(_.version(_))
        .build

    def campaignSmsMessage(
      body: Option[String] = None,
      messageType: Option[String] = None,
      originationNumber: Option[String] = None,
      senderId: Option[String] = None,
      entityId: Option[String] = None,
      templateId: Option[String] = None
    ): CampaignSmsMessage =
      CampaignSmsMessage
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(messageType)(_.messageType(_))
        .ifSome(originationNumber)(_.originationNumber(_))
        .ifSome(senderId)(_.senderId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def campaignState(
      campaignStatus: Option[String] = None
    ): CampaignState =
      CampaignState
        .builder
        .ifSome(campaignStatus)(_.campaignStatus(_))
        .build

    def campaignsResponse(
      item: Option[List[CampaignResponse]] = None,
      nextToken: Option[String] = None
    ): CampaignsResponse =
      CampaignsResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def channelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      version: Option[Int] = None
    ): ChannelResponse =
      ChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(version)(_.version(_))
        .build

    def channelsResponse(
      channels: Option[MapOfChannelResponse] = None
    ): ChannelsResponse =
      ChannelsResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .build

    def condition(
      conditions: Option[List[SimpleCondition]] = None,
      operator: Option[String] = None
    ): Condition =
      Condition
        .builder
        .ifSome(conditions)(_.conditions(_))
        .ifSome(operator)(_.operator(_))
        .build

    def conditionalSplitActivity(
      condition: Option[Condition] = None,
      evaluationWaitTime: Option[WaitTime] = None,
      falseActivity: Option[String] = None,
      trueActivity: Option[String] = None
    ): ConditionalSplitActivity =
      ConditionalSplitActivity
        .builder
        .ifSome(condition)(_.condition(_))
        .ifSome(evaluationWaitTime)(_.evaluationWaitTime(_))
        .ifSome(falseActivity)(_.falseActivity(_))
        .ifSome(trueActivity)(_.trueActivity(_))
        .build

    def conflictException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def createAppRequest(
      createApplicationRequest: Option[CreateApplicationRequest] = None
    ): CreateAppRequest =
      CreateAppRequest
        .builder
        .ifSome(createApplicationRequest)(_.createApplicationRequest(_))
        .build

    def createAppResponse(
      applicationResponse: Option[ApplicationResponse] = None
    ): CreateAppResponse =
      CreateAppResponse
        .builder
        .ifSome(applicationResponse)(_.applicationResponse(_))
        .build

    def createApplicationRequest(
      name: Option[String] = None,
      tags: Option[MapOf__string] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCampaignRequest(
      applicationId: Option[String] = None,
      writeCampaignRequest: Option[WriteCampaignRequest] = None
    ): CreateCampaignRequest =
      CreateCampaignRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(writeCampaignRequest)(_.writeCampaignRequest(_))
        .build

    def createCampaignResponse(
      campaignResponse: Option[CampaignResponse] = None
    ): CreateCampaignResponse =
      CreateCampaignResponse
        .builder
        .ifSome(campaignResponse)(_.campaignResponse(_))
        .build

    def createEmailTemplateRequest(
      emailTemplateRequest: Option[EmailTemplateRequest] = None,
      templateName: Option[String] = None
    ): CreateEmailTemplateRequest =
      CreateEmailTemplateRequest
        .builder
        .ifSome(emailTemplateRequest)(_.emailTemplateRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createEmailTemplateResponse(
      createTemplateMessageBody: Option[CreateTemplateMessageBody] = None
    ): CreateEmailTemplateResponse =
      CreateEmailTemplateResponse
        .builder
        .ifSome(createTemplateMessageBody)(_.createTemplateMessageBody(_))
        .build

    def createExportJobRequest(
      applicationId: Option[String] = None,
      exportJobRequest: Option[ExportJobRequest] = None
    ): CreateExportJobRequest =
      CreateExportJobRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(exportJobRequest)(_.exportJobRequest(_))
        .build

    def createExportJobResponse(
      exportJobResponse: Option[ExportJobResponse] = None
    ): CreateExportJobResponse =
      CreateExportJobResponse
        .builder
        .ifSome(exportJobResponse)(_.exportJobResponse(_))
        .build

    def createImportJobRequest(
      applicationId: Option[String] = None,
      importJobRequest: Option[ImportJobRequest] = None
    ): CreateImportJobRequest =
      CreateImportJobRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(importJobRequest)(_.importJobRequest(_))
        .build

    def createImportJobResponse(
      importJobResponse: Option[ImportJobResponse] = None
    ): CreateImportJobResponse =
      CreateImportJobResponse
        .builder
        .ifSome(importJobResponse)(_.importJobResponse(_))
        .build

    def createJourneyRequest(
      applicationId: Option[String] = None,
      writeJourneyRequest: Option[WriteJourneyRequest] = None
    ): CreateJourneyRequest =
      CreateJourneyRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(writeJourneyRequest)(_.writeJourneyRequest(_))
        .build

    def createJourneyResponse(
      journeyResponse: Option[JourneyResponse] = None
    ): CreateJourneyResponse =
      CreateJourneyResponse
        .builder
        .ifSome(journeyResponse)(_.journeyResponse(_))
        .build

    def createPushTemplateRequest(
      pushNotificationTemplateRequest: Option[PushNotificationTemplateRequest] = None,
      templateName: Option[String] = None
    ): CreatePushTemplateRequest =
      CreatePushTemplateRequest
        .builder
        .ifSome(pushNotificationTemplateRequest)(_.pushNotificationTemplateRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createPushTemplateResponse(
      createTemplateMessageBody: Option[CreateTemplateMessageBody] = None
    ): CreatePushTemplateResponse =
      CreatePushTemplateResponse
        .builder
        .ifSome(createTemplateMessageBody)(_.createTemplateMessageBody(_))
        .build

    def createRecommenderConfiguration(
      attributes: Option[MapOf__string] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      recommendationProviderIdType: Option[String] = None,
      recommendationProviderRoleArn: Option[String] = None,
      recommendationProviderUri: Option[String] = None,
      recommendationTransformerUri: Option[String] = None,
      recommendationsDisplayName: Option[String] = None,
      recommendationsPerMessage: Option[Int] = None
    ): CreateRecommenderConfiguration =
      CreateRecommenderConfiguration
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(recommendationProviderIdType)(_.recommendationProviderIdType(_))
        .ifSome(recommendationProviderRoleArn)(_.recommendationProviderRoleArn(_))
        .ifSome(recommendationProviderUri)(_.recommendationProviderUri(_))
        .ifSome(recommendationTransformerUri)(_.recommendationTransformerUri(_))
        .ifSome(recommendationsDisplayName)(_.recommendationsDisplayName(_))
        .ifSome(recommendationsPerMessage)(_.recommendationsPerMessage(_))
        .build

    def createRecommenderConfigurationRequest(
      createRecommenderConfiguration: Option[CreateRecommenderConfiguration] = None
    ): CreateRecommenderConfigurationRequest =
      CreateRecommenderConfigurationRequest
        .builder
        .ifSome(createRecommenderConfiguration)(_.createRecommenderConfiguration(_))
        .build

    def createRecommenderConfigurationResponse(
      recommenderConfigurationResponse: Option[RecommenderConfigurationResponse] = None
    ): CreateRecommenderConfigurationResponse =
      CreateRecommenderConfigurationResponse
        .builder
        .ifSome(recommenderConfigurationResponse)(_.recommenderConfigurationResponse(_))
        .build

    def createSegmentRequest(
      applicationId: Option[String] = None,
      writeSegmentRequest: Option[WriteSegmentRequest] = None
    ): CreateSegmentRequest =
      CreateSegmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(writeSegmentRequest)(_.writeSegmentRequest(_))
        .build

    def createSegmentResponse(
      segmentResponse: Option[SegmentResponse] = None
    ): CreateSegmentResponse =
      CreateSegmentResponse
        .builder
        .ifSome(segmentResponse)(_.segmentResponse(_))
        .build

    def createSmsTemplateRequest(
      sMSTemplateRequest: Option[SMSTemplateRequest] = None,
      templateName: Option[String] = None
    ): CreateSmsTemplateRequest =
      CreateSmsTemplateRequest
        .builder
        .ifSome(sMSTemplateRequest)(_.sMSTemplateRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createSmsTemplateResponse(
      createTemplateMessageBody: Option[CreateTemplateMessageBody] = None
    ): CreateSmsTemplateResponse =
      CreateSmsTemplateResponse
        .builder
        .ifSome(createTemplateMessageBody)(_.createTemplateMessageBody(_))
        .build

    def createTemplateMessageBody(
      arn: Option[String] = None,
      message: Option[String] = None,
      requestID: Option[String] = None
    ): CreateTemplateMessageBody =
      CreateTemplateMessageBody
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def createVoiceTemplateRequest(
      templateName: Option[String] = None,
      voiceTemplateRequest: Option[VoiceTemplateRequest] = None
    ): CreateVoiceTemplateRequest =
      CreateVoiceTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(voiceTemplateRequest)(_.voiceTemplateRequest(_))
        .build

    def createVoiceTemplateResponse(
      createTemplateMessageBody: Option[CreateTemplateMessageBody] = None
    ): CreateVoiceTemplateResponse =
      CreateVoiceTemplateResponse
        .builder
        .ifSome(createTemplateMessageBody)(_.createTemplateMessageBody(_))
        .build

    def customDeliveryConfiguration(
      deliveryUri: Option[String] = None,
      endpointTypes: Option[List[__EndpointTypesElement]] = None
    ): CustomDeliveryConfiguration =
      CustomDeliveryConfiguration
        .builder
        .ifSome(deliveryUri)(_.deliveryUri(_))
        .ifSome(endpointTypes)(_.endpointTypes(_))
        .build

    def customMessageActivity(
      deliveryUri: Option[String] = None,
      endpointTypes: Option[List[__EndpointTypesElement]] = None,
      messageConfig: Option[JourneyCustomMessage] = None,
      nextActivity: Option[String] = None,
      templateName: Option[String] = None,
      templateVersion: Option[String] = None
    ): CustomMessageActivity =
      CustomMessageActivity
        .builder
        .ifSome(deliveryUri)(_.deliveryUri(_))
        .ifSome(endpointTypes)(_.endpointTypes(_))
        .ifSome(messageConfig)(_.messageConfig(_))
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateVersion)(_.templateVersion(_))
        .build

    def defaultMessage(
      body: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None
    ): DefaultMessage =
      DefaultMessage
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(substitutions)(_.substitutions(_))
        .build

    def defaultPushNotificationMessage(
      action: Option[String] = None,
      body: Option[String] = None,
      data: Option[MapOf__string] = None,
      silentPush: Option[Boolean] = None,
      substitutions: Option[MapOfListOf__string] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): DefaultPushNotificationMessage =
      DefaultPushNotificationMessage
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(data)(_.data(_))
        .ifSome(silentPush)(_.silentPush(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def defaultPushNotificationTemplate(
      action: Option[String] = None,
      body: Option[String] = None,
      sound: Option[String] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): DefaultPushNotificationTemplate =
      DefaultPushNotificationTemplate
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def deleteAdmChannelRequest(
      applicationId: Option[String] = None
    ): DeleteAdmChannelRequest =
      DeleteAdmChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteAdmChannelResponse(
      aDMChannelResponse: Option[ADMChannelResponse] = None
    ): DeleteAdmChannelResponse =
      DeleteAdmChannelResponse
        .builder
        .ifSome(aDMChannelResponse)(_.aDMChannelResponse(_))
        .build

    def deleteApnsChannelRequest(
      applicationId: Option[String] = None
    ): DeleteApnsChannelRequest =
      DeleteApnsChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteApnsChannelResponse(
      aPNSChannelResponse: Option[APNSChannelResponse] = None
    ): DeleteApnsChannelResponse =
      DeleteApnsChannelResponse
        .builder
        .ifSome(aPNSChannelResponse)(_.aPNSChannelResponse(_))
        .build

    def deleteApnsSandboxChannelRequest(
      applicationId: Option[String] = None
    ): DeleteApnsSandboxChannelRequest =
      DeleteApnsSandboxChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteApnsSandboxChannelResponse(
      aPNSSandboxChannelResponse: Option[APNSSandboxChannelResponse] = None
    ): DeleteApnsSandboxChannelResponse =
      DeleteApnsSandboxChannelResponse
        .builder
        .ifSome(aPNSSandboxChannelResponse)(_.aPNSSandboxChannelResponse(_))
        .build

    def deleteApnsVoipChannelRequest(
      applicationId: Option[String] = None
    ): DeleteApnsVoipChannelRequest =
      DeleteApnsVoipChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteApnsVoipChannelResponse(
      aPNSVoipChannelResponse: Option[APNSVoipChannelResponse] = None
    ): DeleteApnsVoipChannelResponse =
      DeleteApnsVoipChannelResponse
        .builder
        .ifSome(aPNSVoipChannelResponse)(_.aPNSVoipChannelResponse(_))
        .build

    def deleteApnsVoipSandboxChannelRequest(
      applicationId: Option[String] = None
    ): DeleteApnsVoipSandboxChannelRequest =
      DeleteApnsVoipSandboxChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteApnsVoipSandboxChannelResponse(
      aPNSVoipSandboxChannelResponse: Option[APNSVoipSandboxChannelResponse] = None
    ): DeleteApnsVoipSandboxChannelResponse =
      DeleteApnsVoipSandboxChannelResponse
        .builder
        .ifSome(aPNSVoipSandboxChannelResponse)(_.aPNSVoipSandboxChannelResponse(_))
        .build

    def deleteAppRequest(
      applicationId: Option[String] = None
    ): DeleteAppRequest =
      DeleteAppRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteAppResponse(
      applicationResponse: Option[ApplicationResponse] = None
    ): DeleteAppResponse =
      DeleteAppResponse
        .builder
        .ifSome(applicationResponse)(_.applicationResponse(_))
        .build

    def deleteBaiduChannelRequest(
      applicationId: Option[String] = None
    ): DeleteBaiduChannelRequest =
      DeleteBaiduChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteBaiduChannelResponse(
      baiduChannelResponse: Option[BaiduChannelResponse] = None
    ): DeleteBaiduChannelResponse =
      DeleteBaiduChannelResponse
        .builder
        .ifSome(baiduChannelResponse)(_.baiduChannelResponse(_))
        .build

    def deleteCampaignRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None
    ): DeleteCampaignRequest =
      DeleteCampaignRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .build

    def deleteCampaignResponse(
      campaignResponse: Option[CampaignResponse] = None
    ): DeleteCampaignResponse =
      DeleteCampaignResponse
        .builder
        .ifSome(campaignResponse)(_.campaignResponse(_))
        .build

    def deleteEmailChannelRequest(
      applicationId: Option[String] = None
    ): DeleteEmailChannelRequest =
      DeleteEmailChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteEmailChannelResponse(
      emailChannelResponse: Option[EmailChannelResponse] = None
    ): DeleteEmailChannelResponse =
      DeleteEmailChannelResponse
        .builder
        .ifSome(emailChannelResponse)(_.emailChannelResponse(_))
        .build

    def deleteEmailTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): DeleteEmailTemplateRequest =
      DeleteEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteEmailTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): DeleteEmailTemplateResponse =
      DeleteEmailTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def deleteEndpointRequest(
      applicationId: Option[String] = None,
      endpointId: Option[String] = None
    ): DeleteEndpointRequest =
      DeleteEndpointRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endpointId)(_.endpointId(_))
        .build

    def deleteEndpointResponse(
      endpointResponse: Option[EndpointResponse] = None
    ): DeleteEndpointResponse =
      DeleteEndpointResponse
        .builder
        .ifSome(endpointResponse)(_.endpointResponse(_))
        .build

    def deleteEventStreamRequest(
      applicationId: Option[String] = None
    ): DeleteEventStreamRequest =
      DeleteEventStreamRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteEventStreamResponse(
      eventStream: Option[EventStream] = None
    ): DeleteEventStreamResponse =
      DeleteEventStreamResponse
        .builder
        .ifSome(eventStream)(_.eventStream(_))
        .build

    def deleteGcmChannelRequest(
      applicationId: Option[String] = None
    ): DeleteGcmChannelRequest =
      DeleteGcmChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteGcmChannelResponse(
      gCMChannelResponse: Option[GCMChannelResponse] = None
    ): DeleteGcmChannelResponse =
      DeleteGcmChannelResponse
        .builder
        .ifSome(gCMChannelResponse)(_.gCMChannelResponse(_))
        .build

    def deleteJourneyRequest(
      applicationId: Option[String] = None,
      journeyId: Option[String] = None
    ): DeleteJourneyRequest =
      DeleteJourneyRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .build

    def deleteJourneyResponse(
      journeyResponse: Option[JourneyResponse] = None
    ): DeleteJourneyResponse =
      DeleteJourneyResponse
        .builder
        .ifSome(journeyResponse)(_.journeyResponse(_))
        .build

    def deletePushTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): DeletePushTemplateRequest =
      DeletePushTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def deletePushTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): DeletePushTemplateResponse =
      DeletePushTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def deleteRecommenderConfigurationRequest(
      recommenderId: Option[String] = None
    ): DeleteRecommenderConfigurationRequest =
      DeleteRecommenderConfigurationRequest
        .builder
        .ifSome(recommenderId)(_.recommenderId(_))
        .build

    def deleteRecommenderConfigurationResponse(
      recommenderConfigurationResponse: Option[RecommenderConfigurationResponse] = None
    ): DeleteRecommenderConfigurationResponse =
      DeleteRecommenderConfigurationResponse
        .builder
        .ifSome(recommenderConfigurationResponse)(_.recommenderConfigurationResponse(_))
        .build

    def deleteSegmentRequest(
      applicationId: Option[String] = None,
      segmentId: Option[String] = None
    ): DeleteSegmentRequest =
      DeleteSegmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(segmentId)(_.segmentId(_))
        .build

    def deleteSegmentResponse(
      segmentResponse: Option[SegmentResponse] = None
    ): DeleteSegmentResponse =
      DeleteSegmentResponse
        .builder
        .ifSome(segmentResponse)(_.segmentResponse(_))
        .build

    def deleteSmsChannelRequest(
      applicationId: Option[String] = None
    ): DeleteSmsChannelRequest =
      DeleteSmsChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteSmsChannelResponse(
      sMSChannelResponse: Option[SMSChannelResponse] = None
    ): DeleteSmsChannelResponse =
      DeleteSmsChannelResponse
        .builder
        .ifSome(sMSChannelResponse)(_.sMSChannelResponse(_))
        .build

    def deleteSmsTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): DeleteSmsTemplateRequest =
      DeleteSmsTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteSmsTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): DeleteSmsTemplateResponse =
      DeleteSmsTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def deleteUserEndpointsRequest(
      applicationId: Option[String] = None,
      userId: Option[String] = None
    ): DeleteUserEndpointsRequest =
      DeleteUserEndpointsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def deleteUserEndpointsResponse(
      endpointsResponse: Option[EndpointsResponse] = None
    ): DeleteUserEndpointsResponse =
      DeleteUserEndpointsResponse
        .builder
        .ifSome(endpointsResponse)(_.endpointsResponse(_))
        .build

    def deleteVoiceChannelRequest(
      applicationId: Option[String] = None
    ): DeleteVoiceChannelRequest =
      DeleteVoiceChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def deleteVoiceChannelResponse(
      voiceChannelResponse: Option[VoiceChannelResponse] = None
    ): DeleteVoiceChannelResponse =
      DeleteVoiceChannelResponse
        .builder
        .ifSome(voiceChannelResponse)(_.voiceChannelResponse(_))
        .build

    def deleteVoiceTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): DeleteVoiceTemplateRequest =
      DeleteVoiceTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteVoiceTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): DeleteVoiceTemplateResponse =
      DeleteVoiceTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def directMessageConfiguration(
      aDMMessage: Option[ADMMessage] = None,
      aPNSMessage: Option[APNSMessage] = None,
      baiduMessage: Option[BaiduMessage] = None,
      defaultMessage: Option[DefaultMessage] = None,
      defaultPushNotificationMessage: Option[DefaultPushNotificationMessage] = None,
      emailMessage: Option[EmailMessage] = None,
      gCMMessage: Option[GCMMessage] = None,
      sMSMessage: Option[SMSMessage] = None,
      voiceMessage: Option[VoiceMessage] = None
    ): DirectMessageConfiguration =
      DirectMessageConfiguration
        .builder
        .ifSome(aDMMessage)(_.aDMMessage(_))
        .ifSome(aPNSMessage)(_.aPNSMessage(_))
        .ifSome(baiduMessage)(_.baiduMessage(_))
        .ifSome(defaultMessage)(_.defaultMessage(_))
        .ifSome(defaultPushNotificationMessage)(_.defaultPushNotificationMessage(_))
        .ifSome(emailMessage)(_.emailMessage(_))
        .ifSome(gCMMessage)(_.gCMMessage(_))
        .ifSome(sMSMessage)(_.sMSMessage(_))
        .ifSome(voiceMessage)(_.voiceMessage(_))
        .build

    def emailChannelRequest(
      configurationSet: Option[String] = None,
      enabled: Option[Boolean] = None,
      fromAddress: Option[String] = None,
      identity: Option[String] = None,
      roleArn: Option[String] = None
    ): EmailChannelRequest =
      EmailChannelRequest
        .builder
        .ifSome(configurationSet)(_.configurationSet(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(fromAddress)(_.fromAddress(_))
        .ifSome(identity)(_.identity(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def emailChannelResponse(
      applicationId: Option[String] = None,
      configurationSet: Option[String] = None,
      creationDate: Option[String] = None,
      enabled: Option[Boolean] = None,
      fromAddress: Option[String] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      identity: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      messagesPerSecond: Option[Int] = None,
      platform: Option[String] = None,
      roleArn: Option[String] = None,
      version: Option[Int] = None
    ): EmailChannelResponse =
      EmailChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(configurationSet)(_.configurationSet(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(fromAddress)(_.fromAddress(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(identity)(_.identity(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(messagesPerSecond)(_.messagesPerSecond(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(version)(_.version(_))
        .build

    def emailMessage(
      body: Option[String] = None,
      feedbackForwardingAddress: Option[String] = None,
      fromAddress: Option[String] = None,
      rawEmail: Option[RawEmail] = None,
      replyToAddresses: Option[List[__string]] = None,
      simpleEmail: Option[SimpleEmail] = None,
      substitutions: Option[MapOfListOf__string] = None
    ): EmailMessage =
      EmailMessage
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(feedbackForwardingAddress)(_.feedbackForwardingAddress(_))
        .ifSome(fromAddress)(_.fromAddress(_))
        .ifSome(rawEmail)(_.rawEmail(_))
        .ifSome(replyToAddresses)(_.replyToAddresses(_))
        .ifSome(simpleEmail)(_.simpleEmail(_))
        .ifSome(substitutions)(_.substitutions(_))
        .build

    def emailMessageActivity(
      messageConfig: Option[JourneyEmailMessage] = None,
      nextActivity: Option[String] = None,
      templateName: Option[String] = None,
      templateVersion: Option[String] = None
    ): EmailMessageActivity =
      EmailMessageActivity
        .builder
        .ifSome(messageConfig)(_.messageConfig(_))
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateVersion)(_.templateVersion(_))
        .build

    def emailTemplateRequest(
      defaultSubstitutions: Option[String] = None,
      htmlPart: Option[String] = None,
      recommenderId: Option[String] = None,
      subject: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      textPart: Option[String] = None
    ): EmailTemplateRequest =
      EmailTemplateRequest
        .builder
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(htmlPart)(_.htmlPart(_))
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(textPart)(_.textPart(_))
        .build

    def emailTemplateResponse(
      arn: Option[String] = None,
      creationDate: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      htmlPart: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      recommenderId: Option[String] = None,
      subject: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None,
      textPart: Option[String] = None,
      version: Option[String] = None
    ): EmailTemplateResponse =
      EmailTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(htmlPart)(_.htmlPart(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .ifSome(textPart)(_.textPart(_))
        .ifSome(version)(_.version(_))
        .build

    def endpointBatchItem(
      address: Option[String] = None,
      attributes: Option[MapOfListOf__string] = None,
      channelType: Option[String] = None,
      demographic: Option[EndpointDemographic] = None,
      effectiveDate: Option[String] = None,
      endpointStatus: Option[String] = None,
      id: Option[String] = None,
      location: Option[EndpointLocation] = None,
      metrics: Option[MapOf__double] = None,
      optOut: Option[String] = None,
      requestId: Option[String] = None,
      user: Option[EndpointUser] = None
    ): EndpointBatchItem =
      EndpointBatchItem
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(demographic)(_.demographic(_))
        .ifSome(effectiveDate)(_.effectiveDate(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(id)(_.id(_))
        .ifSome(location)(_.location(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(optOut)(_.optOut(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(user)(_.user(_))
        .build

    def endpointBatchRequest(
      item: Option[List[EndpointBatchItem]] = None
    ): EndpointBatchRequest =
      EndpointBatchRequest
        .builder
        .ifSome(item)(_.item(_))
        .build

    def endpointDemographic(
      appVersion: Option[String] = None,
      locale: Option[String] = None,
      make: Option[String] = None,
      model: Option[String] = None,
      modelVersion: Option[String] = None,
      platform: Option[String] = None,
      platformVersion: Option[String] = None,
      timezone: Option[String] = None
    ): EndpointDemographic =
      EndpointDemographic
        .builder
        .ifSome(appVersion)(_.appVersion(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(make)(_.make(_))
        .ifSome(model)(_.model(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(timezone)(_.timezone(_))
        .build

    def endpointItemResponse(
      message: Option[String] = None,
      statusCode: Option[Int] = None
    ): EndpointItemResponse =
      EndpointItemResponse
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def endpointLocation(
      city: Option[String] = None,
      country: Option[String] = None,
      latitude: Option[__double] = None,
      longitude: Option[__double] = None,
      postalCode: Option[String] = None,
      region: Option[String] = None
    ): EndpointLocation =
      EndpointLocation
        .builder
        .ifSome(city)(_.city(_))
        .ifSome(country)(_.country(_))
        .ifSome(latitude)(_.latitude(_))
        .ifSome(longitude)(_.longitude(_))
        .ifSome(postalCode)(_.postalCode(_))
        .ifSome(region)(_.region(_))
        .build

    def endpointRequest(
      address: Option[String] = None,
      attributes: Option[MapOfListOf__string] = None,
      channelType: Option[String] = None,
      demographic: Option[EndpointDemographic] = None,
      effectiveDate: Option[String] = None,
      endpointStatus: Option[String] = None,
      location: Option[EndpointLocation] = None,
      metrics: Option[MapOf__double] = None,
      optOut: Option[String] = None,
      requestId: Option[String] = None,
      user: Option[EndpointUser] = None
    ): EndpointRequest =
      EndpointRequest
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(demographic)(_.demographic(_))
        .ifSome(effectiveDate)(_.effectiveDate(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(location)(_.location(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(optOut)(_.optOut(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(user)(_.user(_))
        .build

    def endpointResponse(
      address: Option[String] = None,
      applicationId: Option[String] = None,
      attributes: Option[MapOfListOf__string] = None,
      channelType: Option[String] = None,
      cohortId: Option[String] = None,
      creationDate: Option[String] = None,
      demographic: Option[EndpointDemographic] = None,
      effectiveDate: Option[String] = None,
      endpointStatus: Option[String] = None,
      id: Option[String] = None,
      location: Option[EndpointLocation] = None,
      metrics: Option[MapOf__double] = None,
      optOut: Option[String] = None,
      requestId: Option[String] = None,
      user: Option[EndpointUser] = None
    ): EndpointResponse =
      EndpointResponse
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(cohortId)(_.cohortId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(demographic)(_.demographic(_))
        .ifSome(effectiveDate)(_.effectiveDate(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(id)(_.id(_))
        .ifSome(location)(_.location(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(optOut)(_.optOut(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(user)(_.user(_))
        .build

    def endpointSendConfiguration(
      bodyOverride: Option[String] = None,
      context: Option[MapOf__string] = None,
      rawContent: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      titleOverride: Option[String] = None
    ): EndpointSendConfiguration =
      EndpointSendConfiguration
        .builder
        .ifSome(bodyOverride)(_.bodyOverride(_))
        .ifSome(context)(_.context(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(titleOverride)(_.titleOverride(_))
        .build

    def endpointUser(
      userAttributes: Option[MapOfListOf__string] = None,
      userId: Option[String] = None
    ): EndpointUser =
      EndpointUser
        .builder
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(userId)(_.userId(_))
        .build

    def endpointsResponse(
      item: Option[List[EndpointResponse]] = None
    ): EndpointsResponse =
      EndpointsResponse
        .builder
        .ifSome(item)(_.item(_))
        .build

    def event(
      appPackageName: Option[String] = None,
      appTitle: Option[String] = None,
      appVersionCode: Option[String] = None,
      attributes: Option[MapOf__string] = None,
      clientSdkVersion: Option[String] = None,
      eventType: Option[String] = None,
      metrics: Option[MapOf__double] = None,
      sdkName: Option[String] = None,
      session: Option[Session] = None,
      timestamp: Option[String] = None
    ): Event =
      Event
        .builder
        .ifSome(appPackageName)(_.appPackageName(_))
        .ifSome(appTitle)(_.appTitle(_))
        .ifSome(appVersionCode)(_.appVersionCode(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(clientSdkVersion)(_.clientSdkVersion(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(sdkName)(_.sdkName(_))
        .ifSome(session)(_.session(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def eventCondition(
      dimensions: Option[EventDimensions] = None,
      messageActivity: Option[String] = None
    ): EventCondition =
      EventCondition
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(messageActivity)(_.messageActivity(_))
        .build

    def eventDimensions(
      attributes: Option[MapOfAttributeDimension] = None,
      eventType: Option[SetDimension] = None,
      metrics: Option[MapOfMetricDimension] = None
    ): EventDimensions =
      EventDimensions
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def eventFilter(
      dimensions: Option[EventDimensions] = None,
      filterType: Option[String] = None
    ): EventFilter =
      EventFilter
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(filterType)(_.filterType(_))
        .build

    def eventItemResponse(
      message: Option[String] = None,
      statusCode: Option[Int] = None
    ): EventItemResponse =
      EventItemResponse
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def eventStartCondition(
      eventFilter: Option[EventFilter] = None,
      segmentId: Option[String] = None
    ): EventStartCondition =
      EventStartCondition
        .builder
        .ifSome(eventFilter)(_.eventFilter(_))
        .ifSome(segmentId)(_.segmentId(_))
        .build

    def eventStream(
      applicationId: Option[String] = None,
      destinationStreamArn: Option[String] = None,
      externalId: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      lastUpdatedBy: Option[String] = None,
      roleArn: Option[String] = None
    ): EventStream =
      EventStream
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(destinationStreamArn)(_.destinationStreamArn(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def eventsBatch(
      endpoint: Option[PublicEndpoint] = None,
      events: Option[MapOfEvent] = None
    ): EventsBatch =
      EventsBatch
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(events)(_.events(_))
        .build

    def eventsRequest(
      batchItem: Option[MapOfEventsBatch] = None
    ): EventsRequest =
      EventsRequest
        .builder
        .ifSome(batchItem)(_.batchItem(_))
        .build

    def eventsResponse(
      results: Option[MapOfItemResponse] = None
    ): EventsResponse =
      EventsResponse
        .builder
        .ifSome(results)(_.results(_))
        .build

    def exportJobRequest(
      roleArn: Option[String] = None,
      s3UrlPrefix: Option[String] = None,
      segmentId: Option[String] = None,
      segmentVersion: Option[Int] = None
    ): ExportJobRequest =
      ExportJobRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(s3UrlPrefix)(_.s3UrlPrefix(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(segmentVersion)(_.segmentVersion(_))
        .build

    def exportJobResource(
      roleArn: Option[String] = None,
      s3UrlPrefix: Option[String] = None,
      segmentId: Option[String] = None,
      segmentVersion: Option[Int] = None
    ): ExportJobResource =
      ExportJobResource
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(s3UrlPrefix)(_.s3UrlPrefix(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(segmentVersion)(_.segmentVersion(_))
        .build

    def exportJobResponse(
      applicationId: Option[String] = None,
      completedPieces: Option[Int] = None,
      completionDate: Option[String] = None,
      creationDate: Option[String] = None,
      definition: Option[ExportJobResource] = None,
      failedPieces: Option[Int] = None,
      failures: Option[List[__string]] = None,
      id: Option[String] = None,
      jobStatus: Option[String] = None,
      totalFailures: Option[Int] = None,
      totalPieces: Option[Int] = None,
      totalProcessed: Option[Int] = None,
      `type`: Option[String] = None
    ): ExportJobResponse =
      ExportJobResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(completedPieces)(_.completedPieces(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(failedPieces)(_.failedPieces(_))
        .ifSome(failures)(_.failures(_))
        .ifSome(id)(_.id(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(totalFailures)(_.totalFailures(_))
        .ifSome(totalPieces)(_.totalPieces(_))
        .ifSome(totalProcessed)(_.totalProcessed(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def exportJobsResponse(
      item: Option[List[ExportJobResponse]] = None,
      nextToken: Option[String] = None
    ): ExportJobsResponse =
      ExportJobsResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def forbiddenException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def gCMChannelRequest(
      apiKey: Option[String] = None,
      enabled: Option[Boolean] = None
    ): GCMChannelRequest =
      GCMChannelRequest
        .builder
        .ifSome(apiKey)(_.apiKey(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def gCMChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      credential: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): GCMChannelResponse =
      GCMChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(credential)(_.credential(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def gCMMessage(
      action: Option[String] = None,
      body: Option[String] = None,
      collapseKey: Option[String] = None,
      data: Option[MapOf__string] = None,
      iconReference: Option[String] = None,
      imageIconUrl: Option[String] = None,
      imageUrl: Option[String] = None,
      priority: Option[String] = None,
      rawContent: Option[String] = None,
      restrictedPackageName: Option[String] = None,
      silentPush: Option[Boolean] = None,
      smallImageIconUrl: Option[String] = None,
      sound: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      timeToLive: Option[Int] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): GCMMessage =
      GCMMessage
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(collapseKey)(_.collapseKey(_))
        .ifSome(data)(_.data(_))
        .ifSome(iconReference)(_.iconReference(_))
        .ifSome(imageIconUrl)(_.imageIconUrl(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(restrictedPackageName)(_.restrictedPackageName(_))
        .ifSome(silentPush)(_.silentPush(_))
        .ifSome(smallImageIconUrl)(_.smallImageIconUrl(_))
        .ifSome(sound)(_.sound(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(timeToLive)(_.timeToLive(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def gPSCoordinates(
      latitude: Option[__double] = None,
      longitude: Option[__double] = None
    ): GPSCoordinates =
      GPSCoordinates
        .builder
        .ifSome(latitude)(_.latitude(_))
        .ifSome(longitude)(_.longitude(_))
        .build

    def gPSPointDimension(
      coordinates: Option[GPSCoordinates] = None,
      rangeInKilometers: Option[__double] = None
    ): GPSPointDimension =
      GPSPointDimension
        .builder
        .ifSome(coordinates)(_.coordinates(_))
        .ifSome(rangeInKilometers)(_.rangeInKilometers(_))
        .build

    def getAdmChannelRequest(
      applicationId: Option[String] = None
    ): GetAdmChannelRequest =
      GetAdmChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getAdmChannelResponse(
      aDMChannelResponse: Option[ADMChannelResponse] = None
    ): GetAdmChannelResponse =
      GetAdmChannelResponse
        .builder
        .ifSome(aDMChannelResponse)(_.aDMChannelResponse(_))
        .build

    def getApnsChannelRequest(
      applicationId: Option[String] = None
    ): GetApnsChannelRequest =
      GetApnsChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getApnsChannelResponse(
      aPNSChannelResponse: Option[APNSChannelResponse] = None
    ): GetApnsChannelResponse =
      GetApnsChannelResponse
        .builder
        .ifSome(aPNSChannelResponse)(_.aPNSChannelResponse(_))
        .build

    def getApnsSandboxChannelRequest(
      applicationId: Option[String] = None
    ): GetApnsSandboxChannelRequest =
      GetApnsSandboxChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getApnsSandboxChannelResponse(
      aPNSSandboxChannelResponse: Option[APNSSandboxChannelResponse] = None
    ): GetApnsSandboxChannelResponse =
      GetApnsSandboxChannelResponse
        .builder
        .ifSome(aPNSSandboxChannelResponse)(_.aPNSSandboxChannelResponse(_))
        .build

    def getApnsVoipChannelRequest(
      applicationId: Option[String] = None
    ): GetApnsVoipChannelRequest =
      GetApnsVoipChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getApnsVoipChannelResponse(
      aPNSVoipChannelResponse: Option[APNSVoipChannelResponse] = None
    ): GetApnsVoipChannelResponse =
      GetApnsVoipChannelResponse
        .builder
        .ifSome(aPNSVoipChannelResponse)(_.aPNSVoipChannelResponse(_))
        .build

    def getApnsVoipSandboxChannelRequest(
      applicationId: Option[String] = None
    ): GetApnsVoipSandboxChannelRequest =
      GetApnsVoipSandboxChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getApnsVoipSandboxChannelResponse(
      aPNSVoipSandboxChannelResponse: Option[APNSVoipSandboxChannelResponse] = None
    ): GetApnsVoipSandboxChannelResponse =
      GetApnsVoipSandboxChannelResponse
        .builder
        .ifSome(aPNSVoipSandboxChannelResponse)(_.aPNSVoipSandboxChannelResponse(_))
        .build

    def getAppRequest(
      applicationId: Option[String] = None
    ): GetAppRequest =
      GetAppRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getAppResponse(
      applicationResponse: Option[ApplicationResponse] = None
    ): GetAppResponse =
      GetAppResponse
        .builder
        .ifSome(applicationResponse)(_.applicationResponse(_))
        .build

    def getApplicationDateRangeKpiRequest(
      applicationId: Option[String] = None,
      endTime: Option[__timestampIso8601] = None,
      kpiName: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[String] = None,
      startTime: Option[__timestampIso8601] = None
    ): GetApplicationDateRangeKpiRequest =
      GetApplicationDateRangeKpiRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(kpiName)(_.kpiName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def getApplicationDateRangeKpiResponse(
      applicationDateRangeKpiResponse: Option[ApplicationDateRangeKpiResponse] = None
    ): GetApplicationDateRangeKpiResponse =
      GetApplicationDateRangeKpiResponse
        .builder
        .ifSome(applicationDateRangeKpiResponse)(_.applicationDateRangeKpiResponse(_))
        .build

    def getApplicationSettingsRequest(
      applicationId: Option[String] = None
    ): GetApplicationSettingsRequest =
      GetApplicationSettingsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getApplicationSettingsResponse(
      applicationSettingsResource: Option[ApplicationSettingsResource] = None
    ): GetApplicationSettingsResponse =
      GetApplicationSettingsResponse
        .builder
        .ifSome(applicationSettingsResource)(_.applicationSettingsResource(_))
        .build

    def getAppsRequest(
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetAppsRequest =
      GetAppsRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getAppsResponse(
      applicationsResponse: Option[ApplicationsResponse] = None
    ): GetAppsResponse =
      GetAppsResponse
        .builder
        .ifSome(applicationsResponse)(_.applicationsResponse(_))
        .build

    def getBaiduChannelRequest(
      applicationId: Option[String] = None
    ): GetBaiduChannelRequest =
      GetBaiduChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getBaiduChannelResponse(
      baiduChannelResponse: Option[BaiduChannelResponse] = None
    ): GetBaiduChannelResponse =
      GetBaiduChannelResponse
        .builder
        .ifSome(baiduChannelResponse)(_.baiduChannelResponse(_))
        .build

    def getCampaignActivitiesRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetCampaignActivitiesRequest =
      GetCampaignActivitiesRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getCampaignActivitiesResponse(
      activitiesResponse: Option[ActivitiesResponse] = None
    ): GetCampaignActivitiesResponse =
      GetCampaignActivitiesResponse
        .builder
        .ifSome(activitiesResponse)(_.activitiesResponse(_))
        .build

    def getCampaignDateRangeKpiRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      endTime: Option[__timestampIso8601] = None,
      kpiName: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[String] = None,
      startTime: Option[__timestampIso8601] = None
    ): GetCampaignDateRangeKpiRequest =
      GetCampaignDateRangeKpiRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(kpiName)(_.kpiName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def getCampaignDateRangeKpiResponse(
      campaignDateRangeKpiResponse: Option[CampaignDateRangeKpiResponse] = None
    ): GetCampaignDateRangeKpiResponse =
      GetCampaignDateRangeKpiResponse
        .builder
        .ifSome(campaignDateRangeKpiResponse)(_.campaignDateRangeKpiResponse(_))
        .build

    def getCampaignRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None
    ): GetCampaignRequest =
      GetCampaignRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .build

    def getCampaignResponse(
      campaignResponse: Option[CampaignResponse] = None
    ): GetCampaignResponse =
      GetCampaignResponse
        .builder
        .ifSome(campaignResponse)(_.campaignResponse(_))
        .build

    def getCampaignVersionRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      version: Option[String] = None
    ): GetCampaignVersionRequest =
      GetCampaignVersionRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(version)(_.version(_))
        .build

    def getCampaignVersionResponse(
      campaignResponse: Option[CampaignResponse] = None
    ): GetCampaignVersionResponse =
      GetCampaignVersionResponse
        .builder
        .ifSome(campaignResponse)(_.campaignResponse(_))
        .build

    def getCampaignVersionsRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetCampaignVersionsRequest =
      GetCampaignVersionsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getCampaignVersionsResponse(
      campaignsResponse: Option[CampaignsResponse] = None
    ): GetCampaignVersionsResponse =
      GetCampaignVersionsResponse
        .builder
        .ifSome(campaignsResponse)(_.campaignsResponse(_))
        .build

    def getCampaignsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetCampaignsRequest =
      GetCampaignsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getCampaignsResponse(
      campaignsResponse: Option[CampaignsResponse] = None
    ): GetCampaignsResponse =
      GetCampaignsResponse
        .builder
        .ifSome(campaignsResponse)(_.campaignsResponse(_))
        .build

    def getChannelsRequest(
      applicationId: Option[String] = None
    ): GetChannelsRequest =
      GetChannelsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getChannelsResponse(
      channelsResponse: Option[ChannelsResponse] = None
    ): GetChannelsResponse =
      GetChannelsResponse
        .builder
        .ifSome(channelsResponse)(_.channelsResponse(_))
        .build

    def getEmailChannelRequest(
      applicationId: Option[String] = None
    ): GetEmailChannelRequest =
      GetEmailChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getEmailChannelResponse(
      emailChannelResponse: Option[EmailChannelResponse] = None
    ): GetEmailChannelResponse =
      GetEmailChannelResponse
        .builder
        .ifSome(emailChannelResponse)(_.emailChannelResponse(_))
        .build

    def getEmailTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): GetEmailTemplateRequest =
      GetEmailTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def getEmailTemplateResponse(
      emailTemplateResponse: Option[EmailTemplateResponse] = None
    ): GetEmailTemplateResponse =
      GetEmailTemplateResponse
        .builder
        .ifSome(emailTemplateResponse)(_.emailTemplateResponse(_))
        .build

    def getEndpointRequest(
      applicationId: Option[String] = None,
      endpointId: Option[String] = None
    ): GetEndpointRequest =
      GetEndpointRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endpointId)(_.endpointId(_))
        .build

    def getEndpointResponse(
      endpointResponse: Option[EndpointResponse] = None
    ): GetEndpointResponse =
      GetEndpointResponse
        .builder
        .ifSome(endpointResponse)(_.endpointResponse(_))
        .build

    def getEventStreamRequest(
      applicationId: Option[String] = None
    ): GetEventStreamRequest =
      GetEventStreamRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getEventStreamResponse(
      eventStream: Option[EventStream] = None
    ): GetEventStreamResponse =
      GetEventStreamResponse
        .builder
        .ifSome(eventStream)(_.eventStream(_))
        .build

    def getExportJobRequest(
      applicationId: Option[String] = None,
      jobId: Option[String] = None
    ): GetExportJobRequest =
      GetExportJobRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def getExportJobResponse(
      exportJobResponse: Option[ExportJobResponse] = None
    ): GetExportJobResponse =
      GetExportJobResponse
        .builder
        .ifSome(exportJobResponse)(_.exportJobResponse(_))
        .build

    def getExportJobsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetExportJobsRequest =
      GetExportJobsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getExportJobsResponse(
      exportJobsResponse: Option[ExportJobsResponse] = None
    ): GetExportJobsResponse =
      GetExportJobsResponse
        .builder
        .ifSome(exportJobsResponse)(_.exportJobsResponse(_))
        .build

    def getGcmChannelRequest(
      applicationId: Option[String] = None
    ): GetGcmChannelRequest =
      GetGcmChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getGcmChannelResponse(
      gCMChannelResponse: Option[GCMChannelResponse] = None
    ): GetGcmChannelResponse =
      GetGcmChannelResponse
        .builder
        .ifSome(gCMChannelResponse)(_.gCMChannelResponse(_))
        .build

    def getImportJobRequest(
      applicationId: Option[String] = None,
      jobId: Option[String] = None
    ): GetImportJobRequest =
      GetImportJobRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def getImportJobResponse(
      importJobResponse: Option[ImportJobResponse] = None
    ): GetImportJobResponse =
      GetImportJobResponse
        .builder
        .ifSome(importJobResponse)(_.importJobResponse(_))
        .build

    def getImportJobsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetImportJobsRequest =
      GetImportJobsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getImportJobsResponse(
      importJobsResponse: Option[ImportJobsResponse] = None
    ): GetImportJobsResponse =
      GetImportJobsResponse
        .builder
        .ifSome(importJobsResponse)(_.importJobsResponse(_))
        .build

    def getJourneyDateRangeKpiRequest(
      applicationId: Option[String] = None,
      endTime: Option[__timestampIso8601] = None,
      journeyId: Option[String] = None,
      kpiName: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[String] = None,
      startTime: Option[__timestampIso8601] = None
    ): GetJourneyDateRangeKpiRequest =
      GetJourneyDateRangeKpiRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(kpiName)(_.kpiName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def getJourneyDateRangeKpiResponse(
      journeyDateRangeKpiResponse: Option[JourneyDateRangeKpiResponse] = None
    ): GetJourneyDateRangeKpiResponse =
      GetJourneyDateRangeKpiResponse
        .builder
        .ifSome(journeyDateRangeKpiResponse)(_.journeyDateRangeKpiResponse(_))
        .build

    def getJourneyExecutionActivityMetricsRequest(
      applicationId: Option[String] = None,
      journeyActivityId: Option[String] = None,
      journeyId: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[String] = None
    ): GetJourneyExecutionActivityMetricsRequest =
      GetJourneyExecutionActivityMetricsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyActivityId)(_.journeyActivityId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def getJourneyExecutionActivityMetricsResponse(
      journeyExecutionActivityMetricsResponse: Option[JourneyExecutionActivityMetricsResponse] = None
    ): GetJourneyExecutionActivityMetricsResponse =
      GetJourneyExecutionActivityMetricsResponse
        .builder
        .ifSome(journeyExecutionActivityMetricsResponse)(_.journeyExecutionActivityMetricsResponse(_))
        .build

    def getJourneyExecutionMetricsRequest(
      applicationId: Option[String] = None,
      journeyId: Option[String] = None,
      nextToken: Option[String] = None,
      pageSize: Option[String] = None
    ): GetJourneyExecutionMetricsRequest =
      GetJourneyExecutionMetricsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def getJourneyExecutionMetricsResponse(
      journeyExecutionMetricsResponse: Option[JourneyExecutionMetricsResponse] = None
    ): GetJourneyExecutionMetricsResponse =
      GetJourneyExecutionMetricsResponse
        .builder
        .ifSome(journeyExecutionMetricsResponse)(_.journeyExecutionMetricsResponse(_))
        .build

    def getJourneyRequest(
      applicationId: Option[String] = None,
      journeyId: Option[String] = None
    ): GetJourneyRequest =
      GetJourneyRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .build

    def getJourneyResponse(
      journeyResponse: Option[JourneyResponse] = None
    ): GetJourneyResponse =
      GetJourneyResponse
        .builder
        .ifSome(journeyResponse)(_.journeyResponse(_))
        .build

    def getPushTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): GetPushTemplateRequest =
      GetPushTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def getPushTemplateResponse(
      pushNotificationTemplateResponse: Option[PushNotificationTemplateResponse] = None
    ): GetPushTemplateResponse =
      GetPushTemplateResponse
        .builder
        .ifSome(pushNotificationTemplateResponse)(_.pushNotificationTemplateResponse(_))
        .build

    def getRecommenderConfigurationRequest(
      recommenderId: Option[String] = None
    ): GetRecommenderConfigurationRequest =
      GetRecommenderConfigurationRequest
        .builder
        .ifSome(recommenderId)(_.recommenderId(_))
        .build

    def getRecommenderConfigurationResponse(
      recommenderConfigurationResponse: Option[RecommenderConfigurationResponse] = None
    ): GetRecommenderConfigurationResponse =
      GetRecommenderConfigurationResponse
        .builder
        .ifSome(recommenderConfigurationResponse)(_.recommenderConfigurationResponse(_))
        .build

    def getRecommenderConfigurationsRequest(
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetRecommenderConfigurationsRequest =
      GetRecommenderConfigurationsRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getRecommenderConfigurationsResponse(
      listRecommenderConfigurationsResponse: Option[ListRecommenderConfigurationsResponse] = None
    ): GetRecommenderConfigurationsResponse =
      GetRecommenderConfigurationsResponse
        .builder
        .ifSome(listRecommenderConfigurationsResponse)(_.listRecommenderConfigurationsResponse(_))
        .build

    def getSegmentExportJobsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      segmentId: Option[String] = None,
      token: Option[String] = None
    ): GetSegmentExportJobsRequest =
      GetSegmentExportJobsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(token)(_.token(_))
        .build

    def getSegmentExportJobsResponse(
      exportJobsResponse: Option[ExportJobsResponse] = None
    ): GetSegmentExportJobsResponse =
      GetSegmentExportJobsResponse
        .builder
        .ifSome(exportJobsResponse)(_.exportJobsResponse(_))
        .build

    def getSegmentImportJobsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      segmentId: Option[String] = None,
      token: Option[String] = None
    ): GetSegmentImportJobsRequest =
      GetSegmentImportJobsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(token)(_.token(_))
        .build

    def getSegmentImportJobsResponse(
      importJobsResponse: Option[ImportJobsResponse] = None
    ): GetSegmentImportJobsResponse =
      GetSegmentImportJobsResponse
        .builder
        .ifSome(importJobsResponse)(_.importJobsResponse(_))
        .build

    def getSegmentRequest(
      applicationId: Option[String] = None,
      segmentId: Option[String] = None
    ): GetSegmentRequest =
      GetSegmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(segmentId)(_.segmentId(_))
        .build

    def getSegmentResponse(
      segmentResponse: Option[SegmentResponse] = None
    ): GetSegmentResponse =
      GetSegmentResponse
        .builder
        .ifSome(segmentResponse)(_.segmentResponse(_))
        .build

    def getSegmentVersionRequest(
      applicationId: Option[String] = None,
      segmentId: Option[String] = None,
      version: Option[String] = None
    ): GetSegmentVersionRequest =
      GetSegmentVersionRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(version)(_.version(_))
        .build

    def getSegmentVersionResponse(
      segmentResponse: Option[SegmentResponse] = None
    ): GetSegmentVersionResponse =
      GetSegmentVersionResponse
        .builder
        .ifSome(segmentResponse)(_.segmentResponse(_))
        .build

    def getSegmentVersionsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      segmentId: Option[String] = None,
      token: Option[String] = None
    ): GetSegmentVersionsRequest =
      GetSegmentVersionsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(token)(_.token(_))
        .build

    def getSegmentVersionsResponse(
      segmentsResponse: Option[SegmentsResponse] = None
    ): GetSegmentVersionsResponse =
      GetSegmentVersionsResponse
        .builder
        .ifSome(segmentsResponse)(_.segmentsResponse(_))
        .build

    def getSegmentsRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): GetSegmentsRequest =
      GetSegmentsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def getSegmentsResponse(
      segmentsResponse: Option[SegmentsResponse] = None
    ): GetSegmentsResponse =
      GetSegmentsResponse
        .builder
        .ifSome(segmentsResponse)(_.segmentsResponse(_))
        .build

    def getSmsChannelRequest(
      applicationId: Option[String] = None
    ): GetSmsChannelRequest =
      GetSmsChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getSmsChannelResponse(
      sMSChannelResponse: Option[SMSChannelResponse] = None
    ): GetSmsChannelResponse =
      GetSmsChannelResponse
        .builder
        .ifSome(sMSChannelResponse)(_.sMSChannelResponse(_))
        .build

    def getSmsTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): GetSmsTemplateRequest =
      GetSmsTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def getSmsTemplateResponse(
      sMSTemplateResponse: Option[SMSTemplateResponse] = None
    ): GetSmsTemplateResponse =
      GetSmsTemplateResponse
        .builder
        .ifSome(sMSTemplateResponse)(_.sMSTemplateResponse(_))
        .build

    def getUserEndpointsRequest(
      applicationId: Option[String] = None,
      userId: Option[String] = None
    ): GetUserEndpointsRequest =
      GetUserEndpointsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def getUserEndpointsResponse(
      endpointsResponse: Option[EndpointsResponse] = None
    ): GetUserEndpointsResponse =
      GetUserEndpointsResponse
        .builder
        .ifSome(endpointsResponse)(_.endpointsResponse(_))
        .build

    def getVoiceChannelRequest(
      applicationId: Option[String] = None
    ): GetVoiceChannelRequest =
      GetVoiceChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getVoiceChannelResponse(
      voiceChannelResponse: Option[VoiceChannelResponse] = None
    ): GetVoiceChannelResponse =
      GetVoiceChannelResponse
        .builder
        .ifSome(voiceChannelResponse)(_.voiceChannelResponse(_))
        .build

    def getVoiceTemplateRequest(
      templateName: Option[String] = None,
      version: Option[String] = None
    ): GetVoiceTemplateRequest =
      GetVoiceTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def getVoiceTemplateResponse(
      voiceTemplateResponse: Option[VoiceTemplateResponse] = None
    ): GetVoiceTemplateResponse =
      GetVoiceTemplateResponse
        .builder
        .ifSome(voiceTemplateResponse)(_.voiceTemplateResponse(_))
        .build

    def holdoutActivity(
      nextActivity: Option[String] = None,
      percentage: Option[Int] = None
    ): HoldoutActivity =
      HoldoutActivity
        .builder
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(percentage)(_.percentage(_))
        .build

    def importJobRequest(
      defineSegment: Option[Boolean] = None,
      externalId: Option[String] = None,
      format: Option[String] = None,
      registerEndpoints: Option[Boolean] = None,
      roleArn: Option[String] = None,
      s3Url: Option[String] = None,
      segmentId: Option[String] = None,
      segmentName: Option[String] = None
    ): ImportJobRequest =
      ImportJobRequest
        .builder
        .ifSome(defineSegment)(_.defineSegment(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(format)(_.format(_))
        .ifSome(registerEndpoints)(_.registerEndpoints(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(s3Url)(_.s3Url(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(segmentName)(_.segmentName(_))
        .build

    def importJobResource(
      defineSegment: Option[Boolean] = None,
      externalId: Option[String] = None,
      format: Option[String] = None,
      registerEndpoints: Option[Boolean] = None,
      roleArn: Option[String] = None,
      s3Url: Option[String] = None,
      segmentId: Option[String] = None,
      segmentName: Option[String] = None
    ): ImportJobResource =
      ImportJobResource
        .builder
        .ifSome(defineSegment)(_.defineSegment(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(format)(_.format(_))
        .ifSome(registerEndpoints)(_.registerEndpoints(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(s3Url)(_.s3Url(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(segmentName)(_.segmentName(_))
        .build

    def importJobResponse(
      applicationId: Option[String] = None,
      completedPieces: Option[Int] = None,
      completionDate: Option[String] = None,
      creationDate: Option[String] = None,
      definition: Option[ImportJobResource] = None,
      failedPieces: Option[Int] = None,
      failures: Option[List[__string]] = None,
      id: Option[String] = None,
      jobStatus: Option[String] = None,
      totalFailures: Option[Int] = None,
      totalPieces: Option[Int] = None,
      totalProcessed: Option[Int] = None,
      `type`: Option[String] = None
    ): ImportJobResponse =
      ImportJobResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(completedPieces)(_.completedPieces(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(failedPieces)(_.failedPieces(_))
        .ifSome(failures)(_.failures(_))
        .ifSome(id)(_.id(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(totalFailures)(_.totalFailures(_))
        .ifSome(totalPieces)(_.totalPieces(_))
        .ifSome(totalProcessed)(_.totalProcessed(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def importJobsResponse(
      item: Option[List[ImportJobResponse]] = None,
      nextToken: Option[String] = None
    ): ImportJobsResponse =
      ImportJobsResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def itemResponse(
      endpointItemResponse: Option[EndpointItemResponse] = None,
      eventsItemResponse: Option[MapOfEventItemResponse] = None
    ): ItemResponse =
      ItemResponse
        .builder
        .ifSome(endpointItemResponse)(_.endpointItemResponse(_))
        .ifSome(eventsItemResponse)(_.eventsItemResponse(_))
        .build

    def journeyCustomMessage(
      data: Option[String] = None
    ): JourneyCustomMessage =
      JourneyCustomMessage
        .builder
        .ifSome(data)(_.data(_))
        .build

    def journeyDateRangeKpiResponse(
      applicationId: Option[String] = None,
      endTime: Option[__timestampIso8601] = None,
      journeyId: Option[String] = None,
      kpiName: Option[String] = None,
      kpiResult: Option[BaseKpiResult] = None,
      nextToken: Option[String] = None,
      startTime: Option[__timestampIso8601] = None
    ): JourneyDateRangeKpiResponse =
      JourneyDateRangeKpiResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(kpiName)(_.kpiName(_))
        .ifSome(kpiResult)(_.kpiResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def journeyEmailMessage(
      fromAddress: Option[String] = None
    ): JourneyEmailMessage =
      JourneyEmailMessage
        .builder
        .ifSome(fromAddress)(_.fromAddress(_))
        .build

    def journeyExecutionActivityMetricsResponse(
      activityType: Option[String] = None,
      applicationId: Option[String] = None,
      journeyActivityId: Option[String] = None,
      journeyId: Option[String] = None,
      lastEvaluatedTime: Option[String] = None,
      metrics: Option[MapOf__string] = None
    ): JourneyExecutionActivityMetricsResponse =
      JourneyExecutionActivityMetricsResponse
        .builder
        .ifSome(activityType)(_.activityType(_))
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyActivityId)(_.journeyActivityId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(lastEvaluatedTime)(_.lastEvaluatedTime(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def journeyExecutionMetricsResponse(
      applicationId: Option[String] = None,
      journeyId: Option[String] = None,
      lastEvaluatedTime: Option[String] = None,
      metrics: Option[MapOf__string] = None
    ): JourneyExecutionMetricsResponse =
      JourneyExecutionMetricsResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(lastEvaluatedTime)(_.lastEvaluatedTime(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def journeyLimits(
      dailyCap: Option[Int] = None,
      endpointReentryCap: Option[Int] = None,
      messagesPerSecond: Option[Int] = None,
      endpointReentryInterval: Option[String] = None
    ): JourneyLimits =
      JourneyLimits
        .builder
        .ifSome(dailyCap)(_.dailyCap(_))
        .ifSome(endpointReentryCap)(_.endpointReentryCap(_))
        .ifSome(messagesPerSecond)(_.messagesPerSecond(_))
        .ifSome(endpointReentryInterval)(_.endpointReentryInterval(_))
        .build

    def journeyPushMessage(
      timeToLive: Option[String] = None
    ): JourneyPushMessage =
      JourneyPushMessage
        .builder
        .ifSome(timeToLive)(_.timeToLive(_))
        .build

    def journeyResponse(
      activities: Option[MapOfActivity] = None,
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      id: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      limits: Option[JourneyLimits] = None,
      localTime: Option[Boolean] = None,
      name: Option[String] = None,
      quietTime: Option[QuietTime] = None,
      refreshFrequency: Option[String] = None,
      schedule: Option[JourneySchedule] = None,
      startActivity: Option[String] = None,
      startCondition: Option[StartCondition] = None,
      state: Option[String] = None,
      tags: Option[MapOf__string] = None,
      waitForQuietTime: Option[Boolean] = None,
      refreshOnSegmentUpdate: Option[Boolean] = None
    ): JourneyResponse =
      JourneyResponse
        .builder
        .ifSome(activities)(_.activities(_))
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(localTime)(_.localTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(quietTime)(_.quietTime(_))
        .ifSome(refreshFrequency)(_.refreshFrequency(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(startActivity)(_.startActivity(_))
        .ifSome(startCondition)(_.startCondition(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(waitForQuietTime)(_.waitForQuietTime(_))
        .ifSome(refreshOnSegmentUpdate)(_.refreshOnSegmentUpdate(_))
        .build

    def journeySMSMessage(
      messageType: Option[String] = None,
      originationNumber: Option[String] = None,
      senderId: Option[String] = None,
      entityId: Option[String] = None,
      templateId: Option[String] = None
    ): JourneySMSMessage =
      JourneySMSMessage
        .builder
        .ifSome(messageType)(_.messageType(_))
        .ifSome(originationNumber)(_.originationNumber(_))
        .ifSome(senderId)(_.senderId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def journeySchedule(
      endTime: Option[__timestampIso8601] = None,
      startTime: Option[__timestampIso8601] = None,
      timezone: Option[String] = None
    ): JourneySchedule =
      JourneySchedule
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(timezone)(_.timezone(_))
        .build

    def journeyStateRequest(
      state: Option[String] = None
    ): JourneyStateRequest =
      JourneyStateRequest
        .builder
        .ifSome(state)(_.state(_))
        .build

    def journeysResponse(
      item: Option[List[JourneyResponse]] = None,
      nextToken: Option[String] = None
    ): JourneysResponse =
      JourneysResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJourneysRequest(
      applicationId: Option[String] = None,
      pageSize: Option[String] = None,
      token: Option[String] = None
    ): ListJourneysRequest =
      ListJourneysRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(token)(_.token(_))
        .build

    def listJourneysResponse(
      journeysResponse: Option[JourneysResponse] = None
    ): ListJourneysResponse =
      ListJourneysResponse
        .builder
        .ifSome(journeysResponse)(_.journeysResponse(_))
        .build

    def listRecommenderConfigurationsResponse(
      item: Option[List[RecommenderConfigurationResponse]] = None,
      nextToken: Option[String] = None
    ): ListRecommenderConfigurationsResponse =
      ListRecommenderConfigurationsResponse
        .builder
        .ifSome(item)(_.item(_))
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
      tagsModel: Option[TagsModel] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tagsModel)(_.tagsModel(_))
        .build

    def listTemplateVersionsRequest(
      nextToken: Option[String] = None,
      pageSize: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None
    ): ListTemplateVersionsRequest =
      ListTemplateVersionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .build

    def listTemplateVersionsResponse(
      templateVersionsResponse: Option[TemplateVersionsResponse] = None
    ): ListTemplateVersionsResponse =
      ListTemplateVersionsResponse
        .builder
        .ifSome(templateVersionsResponse)(_.templateVersionsResponse(_))
        .build

    def listTemplatesRequest(
      nextToken: Option[String] = None,
      pageSize: Option[String] = None,
      prefix: Option[String] = None,
      templateType: Option[String] = None
    ): ListTemplatesRequest =
      ListTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(templateType)(_.templateType(_))
        .build

    def listTemplatesResponse(
      templatesResponse: Option[TemplatesResponse] = None
    ): ListTemplatesResponse =
      ListTemplatesResponse
        .builder
        .ifSome(templatesResponse)(_.templatesResponse(_))
        .build

    def message(
      action: Option[String] = None,
      body: Option[String] = None,
      imageIconUrl: Option[String] = None,
      imageSmallIconUrl: Option[String] = None,
      imageUrl: Option[String] = None,
      jsonBody: Option[String] = None,
      mediaUrl: Option[String] = None,
      rawContent: Option[String] = None,
      silentPush: Option[Boolean] = None,
      timeToLive: Option[Int] = None,
      title: Option[String] = None,
      url: Option[String] = None
    ): Message =
      Message
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(body)(_.body(_))
        .ifSome(imageIconUrl)(_.imageIconUrl(_))
        .ifSome(imageSmallIconUrl)(_.imageSmallIconUrl(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(jsonBody)(_.jsonBody(_))
        .ifSome(mediaUrl)(_.mediaUrl(_))
        .ifSome(rawContent)(_.rawContent(_))
        .ifSome(silentPush)(_.silentPush(_))
        .ifSome(timeToLive)(_.timeToLive(_))
        .ifSome(title)(_.title(_))
        .ifSome(url)(_.url(_))
        .build

    def messageBody(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): MessageBody =
      MessageBody
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def messageConfiguration(
      aDMMessage: Option[Message] = None,
      aPNSMessage: Option[Message] = None,
      baiduMessage: Option[Message] = None,
      customMessage: Option[CampaignCustomMessage] = None,
      defaultMessage: Option[Message] = None,
      emailMessage: Option[CampaignEmailMessage] = None,
      gCMMessage: Option[Message] = None,
      sMSMessage: Option[CampaignSmsMessage] = None
    ): MessageConfiguration =
      MessageConfiguration
        .builder
        .ifSome(aDMMessage)(_.aDMMessage(_))
        .ifSome(aPNSMessage)(_.aPNSMessage(_))
        .ifSome(baiduMessage)(_.baiduMessage(_))
        .ifSome(customMessage)(_.customMessage(_))
        .ifSome(defaultMessage)(_.defaultMessage(_))
        .ifSome(emailMessage)(_.emailMessage(_))
        .ifSome(gCMMessage)(_.gCMMessage(_))
        .ifSome(sMSMessage)(_.sMSMessage(_))
        .build

    def messageRequest(
      addresses: Option[MapOfAddressConfiguration] = None,
      context: Option[MapOf__string] = None,
      endpoints: Option[MapOfEndpointSendConfiguration] = None,
      messageConfiguration: Option[DirectMessageConfiguration] = None,
      templateConfiguration: Option[TemplateConfiguration] = None,
      traceId: Option[String] = None
    ): MessageRequest =
      MessageRequest
        .builder
        .ifSome(addresses)(_.addresses(_))
        .ifSome(context)(_.context(_))
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(messageConfiguration)(_.messageConfiguration(_))
        .ifSome(templateConfiguration)(_.templateConfiguration(_))
        .ifSome(traceId)(_.traceId(_))
        .build

    def messageResponse(
      applicationId: Option[String] = None,
      endpointResult: Option[MapOfEndpointMessageResult] = None,
      requestId: Option[String] = None,
      result: Option[MapOfMessageResult] = None
    ): MessageResponse =
      MessageResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endpointResult)(_.endpointResult(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(result)(_.result(_))
        .build

    def methodNotAllowedException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): MethodNotAllowedException =
      MethodNotAllowedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def metricDimension(
      comparisonOperator: Option[String] = None,
      value: Option[__double] = None
    ): MetricDimension =
      MetricDimension
        .builder
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(value)(_.value(_))
        .build

    def multiConditionalBranch(
      condition: Option[SimpleCondition] = None,
      nextActivity: Option[String] = None
    ): MultiConditionalBranch =
      MultiConditionalBranch
        .builder
        .ifSome(condition)(_.condition(_))
        .ifSome(nextActivity)(_.nextActivity(_))
        .build

    def multiConditionalSplitActivity(
      branches: Option[List[MultiConditionalBranch]] = None,
      defaultActivity: Option[String] = None,
      evaluationWaitTime: Option[WaitTime] = None
    ): MultiConditionalSplitActivity =
      MultiConditionalSplitActivity
        .builder
        .ifSome(branches)(_.branches(_))
        .ifSome(defaultActivity)(_.defaultActivity(_))
        .ifSome(evaluationWaitTime)(_.evaluationWaitTime(_))
        .build

    def notFoundException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def numberValidateRequest(
      isoCountryCode: Option[String] = None,
      phoneNumber: Option[String] = None
    ): NumberValidateRequest =
      NumberValidateRequest
        .builder
        .ifSome(isoCountryCode)(_.isoCountryCode(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def numberValidateResponse(
      carrier: Option[String] = None,
      city: Option[String] = None,
      cleansedPhoneNumberE164: Option[String] = None,
      cleansedPhoneNumberNational: Option[String] = None,
      country: Option[String] = None,
      countryCodeIso2: Option[String] = None,
      countryCodeNumeric: Option[String] = None,
      county: Option[String] = None,
      originalCountryCodeIso2: Option[String] = None,
      originalPhoneNumber: Option[String] = None,
      phoneType: Option[String] = None,
      phoneTypeCode: Option[Int] = None,
      timezone: Option[String] = None,
      zipCode: Option[String] = None
    ): NumberValidateResponse =
      NumberValidateResponse
        .builder
        .ifSome(carrier)(_.carrier(_))
        .ifSome(city)(_.city(_))
        .ifSome(cleansedPhoneNumberE164)(_.cleansedPhoneNumberE164(_))
        .ifSome(cleansedPhoneNumberNational)(_.cleansedPhoneNumberNational(_))
        .ifSome(country)(_.country(_))
        .ifSome(countryCodeIso2)(_.countryCodeIso2(_))
        .ifSome(countryCodeNumeric)(_.countryCodeNumeric(_))
        .ifSome(county)(_.county(_))
        .ifSome(originalCountryCodeIso2)(_.originalCountryCodeIso2(_))
        .ifSome(originalPhoneNumber)(_.originalPhoneNumber(_))
        .ifSome(phoneType)(_.phoneType(_))
        .ifSome(phoneTypeCode)(_.phoneTypeCode(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(zipCode)(_.zipCode(_))
        .build

    def payloadTooLargeException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): PayloadTooLargeException =
      PayloadTooLargeException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def phoneNumberValidateRequest(
      numberValidateRequest: Option[NumberValidateRequest] = None
    ): PhoneNumberValidateRequest =
      PhoneNumberValidateRequest
        .builder
        .ifSome(numberValidateRequest)(_.numberValidateRequest(_))
        .build

    def phoneNumberValidateResponse(
      numberValidateResponse: Option[NumberValidateResponse] = None
    ): PhoneNumberValidateResponse =
      PhoneNumberValidateResponse
        .builder
        .ifSome(numberValidateResponse)(_.numberValidateResponse(_))
        .build

    def publicEndpoint(
      address: Option[String] = None,
      attributes: Option[MapOfListOf__string] = None,
      channelType: Option[String] = None,
      demographic: Option[EndpointDemographic] = None,
      effectiveDate: Option[String] = None,
      endpointStatus: Option[String] = None,
      location: Option[EndpointLocation] = None,
      metrics: Option[MapOf__double] = None,
      optOut: Option[String] = None,
      requestId: Option[String] = None,
      user: Option[EndpointUser] = None
    ): PublicEndpoint =
      PublicEndpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(demographic)(_.demographic(_))
        .ifSome(effectiveDate)(_.effectiveDate(_))
        .ifSome(endpointStatus)(_.endpointStatus(_))
        .ifSome(location)(_.location(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(optOut)(_.optOut(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(user)(_.user(_))
        .build

    def pushMessageActivity(
      messageConfig: Option[JourneyPushMessage] = None,
      nextActivity: Option[String] = None,
      templateName: Option[String] = None,
      templateVersion: Option[String] = None
    ): PushMessageActivity =
      PushMessageActivity
        .builder
        .ifSome(messageConfig)(_.messageConfig(_))
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateVersion)(_.templateVersion(_))
        .build

    def pushNotificationTemplateRequest(
      aDM: Option[AndroidPushNotificationTemplate] = None,
      aPNS: Option[APNSPushNotificationTemplate] = None,
      baidu: Option[AndroidPushNotificationTemplate] = None,
      default: Option[DefaultPushNotificationTemplate] = None,
      defaultSubstitutions: Option[String] = None,
      gCM: Option[AndroidPushNotificationTemplate] = None,
      recommenderId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None
    ): PushNotificationTemplateRequest =
      PushNotificationTemplateRequest
        .builder
        .ifSome(aDM)(_.aDM(_))
        .ifSome(aPNS)(_.aPNS(_))
        .ifSome(baidu)(_.baidu(_))
        .ifSome(default)(_.default(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(gCM)(_.gCM(_))
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .build

    def pushNotificationTemplateResponse(
      aDM: Option[AndroidPushNotificationTemplate] = None,
      aPNS: Option[APNSPushNotificationTemplate] = None,
      arn: Option[String] = None,
      baidu: Option[AndroidPushNotificationTemplate] = None,
      creationDate: Option[String] = None,
      default: Option[DefaultPushNotificationTemplate] = None,
      defaultSubstitutions: Option[String] = None,
      gCM: Option[AndroidPushNotificationTemplate] = None,
      lastModifiedDate: Option[String] = None,
      recommenderId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None,
      version: Option[String] = None
    ): PushNotificationTemplateResponse =
      PushNotificationTemplateResponse
        .builder
        .ifSome(aDM)(_.aDM(_))
        .ifSome(aPNS)(_.aPNS(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(baidu)(_.baidu(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(default)(_.default(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(gCM)(_.gCM(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .ifSome(version)(_.version(_))
        .build

    def putEventStreamRequest(
      applicationId: Option[String] = None,
      writeEventStream: Option[WriteEventStream] = None
    ): PutEventStreamRequest =
      PutEventStreamRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(writeEventStream)(_.writeEventStream(_))
        .build

    def putEventStreamResponse(
      eventStream: Option[EventStream] = None
    ): PutEventStreamResponse =
      PutEventStreamResponse
        .builder
        .ifSome(eventStream)(_.eventStream(_))
        .build

    def putEventsRequest(
      applicationId: Option[String] = None,
      eventsRequest: Option[EventsRequest] = None
    ): PutEventsRequest =
      PutEventsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(eventsRequest)(_.eventsRequest(_))
        .build

    def putEventsResponse(
      eventsResponse: Option[EventsResponse] = None
    ): PutEventsResponse =
      PutEventsResponse
        .builder
        .ifSome(eventsResponse)(_.eventsResponse(_))
        .build

    def quietTime(
      end: Option[String] = None,
      start: Option[String] = None
    ): QuietTime =
      QuietTime
        .builder
        .ifSome(end)(_.end(_))
        .ifSome(start)(_.start(_))
        .build

    def randomSplitActivity(
      branches: Option[List[RandomSplitEntry]] = None
    ): RandomSplitActivity =
      RandomSplitActivity
        .builder
        .ifSome(branches)(_.branches(_))
        .build

    def randomSplitEntry(
      nextActivity: Option[String] = None,
      percentage: Option[Int] = None
    ): RandomSplitEntry =
      RandomSplitEntry
        .builder
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(percentage)(_.percentage(_))
        .build

    def rawEmail(
      data: Option[__blob] = None
    ): RawEmail =
      RawEmail
        .builder
        .ifSome(data)(_.data(_))
        .build

    def recencyDimension(
      duration: Option[String] = None,
      recencyType: Option[String] = None
    ): RecencyDimension =
      RecencyDimension
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(recencyType)(_.recencyType(_))
        .build

    def recommenderConfigurationResponse(
      attributes: Option[MapOf__string] = None,
      creationDate: Option[String] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      name: Option[String] = None,
      recommendationProviderIdType: Option[String] = None,
      recommendationProviderRoleArn: Option[String] = None,
      recommendationProviderUri: Option[String] = None,
      recommendationTransformerUri: Option[String] = None,
      recommendationsDisplayName: Option[String] = None,
      recommendationsPerMessage: Option[Int] = None
    ): RecommenderConfigurationResponse =
      RecommenderConfigurationResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(recommendationProviderIdType)(_.recommendationProviderIdType(_))
        .ifSome(recommendationProviderRoleArn)(_.recommendationProviderRoleArn(_))
        .ifSome(recommendationProviderUri)(_.recommendationProviderUri(_))
        .ifSome(recommendationTransformerUri)(_.recommendationTransformerUri(_))
        .ifSome(recommendationsDisplayName)(_.recommendationsDisplayName(_))
        .ifSome(recommendationsPerMessage)(_.recommendationsPerMessage(_))
        .build

    def removeAttributesRequest(
      applicationId: Option[String] = None,
      attributeType: Option[String] = None,
      updateAttributesRequest: Option[UpdateAttributesRequest] = None
    ): RemoveAttributesRequest =
      RemoveAttributesRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(attributeType)(_.attributeType(_))
        .ifSome(updateAttributesRequest)(_.updateAttributesRequest(_))
        .build

    def removeAttributesResponse(
      attributesResource: Option[AttributesResource] = None
    ): RemoveAttributesResponse =
      RemoveAttributesResponse
        .builder
        .ifSome(attributesResource)(_.attributesResource(_))
        .build

    def resultRow(
      groupedBys: Option[List[ResultRowValue]] = None,
      values: Option[List[ResultRowValue]] = None
    ): ResultRow =
      ResultRow
        .builder
        .ifSome(groupedBys)(_.groupedBys(_))
        .ifSome(values)(_.values(_))
        .build

    def resultRowValue(
      key: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None
    ): ResultRowValue =
      ResultRowValue
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def sMSChannelRequest(
      enabled: Option[Boolean] = None,
      senderId: Option[String] = None,
      shortCode: Option[String] = None
    ): SMSChannelRequest =
      SMSChannelRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(senderId)(_.senderId(_))
        .ifSome(shortCode)(_.shortCode(_))
        .build

    def sMSChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      promotionalMessagesPerSecond: Option[Int] = None,
      senderId: Option[String] = None,
      shortCode: Option[String] = None,
      transactionalMessagesPerSecond: Option[Int] = None,
      version: Option[Int] = None
    ): SMSChannelResponse =
      SMSChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(promotionalMessagesPerSecond)(_.promotionalMessagesPerSecond(_))
        .ifSome(senderId)(_.senderId(_))
        .ifSome(shortCode)(_.shortCode(_))
        .ifSome(transactionalMessagesPerSecond)(_.transactionalMessagesPerSecond(_))
        .ifSome(version)(_.version(_))
        .build

    def sMSMessage(
      body: Option[String] = None,
      keyword: Option[String] = None,
      mediaUrl: Option[String] = None,
      messageType: Option[String] = None,
      originationNumber: Option[String] = None,
      senderId: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      entityId: Option[String] = None,
      templateId: Option[String] = None
    ): SMSMessage =
      SMSMessage
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(keyword)(_.keyword(_))
        .ifSome(mediaUrl)(_.mediaUrl(_))
        .ifSome(messageType)(_.messageType(_))
        .ifSome(originationNumber)(_.originationNumber(_))
        .ifSome(senderId)(_.senderId(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def sMSMessageActivity(
      messageConfig: Option[JourneySMSMessage] = None,
      nextActivity: Option[String] = None,
      templateName: Option[String] = None,
      templateVersion: Option[String] = None
    ): SMSMessageActivity =
      SMSMessageActivity
        .builder
        .ifSome(messageConfig)(_.messageConfig(_))
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateVersion)(_.templateVersion(_))
        .build

    def sMSTemplateRequest(
      body: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      recommenderId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None
    ): SMSTemplateRequest =
      SMSTemplateRequest
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .build

    def sMSTemplateResponse(
      arn: Option[String] = None,
      body: Option[String] = None,
      creationDate: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      recommenderId: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None,
      version: Option[String] = None
    ): SMSTemplateResponse =
      SMSTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(body)(_.body(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .ifSome(version)(_.version(_))
        .build

    def schedule(
      endTime: Option[String] = None,
      eventFilter: Option[CampaignEventFilter] = None,
      frequency: Option[String] = None,
      isLocalTime: Option[Boolean] = None,
      quietTime: Option[QuietTime] = None,
      startTime: Option[String] = None,
      timezone: Option[String] = None
    ): Schedule =
      Schedule
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(eventFilter)(_.eventFilter(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(isLocalTime)(_.isLocalTime(_))
        .ifSome(quietTime)(_.quietTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(timezone)(_.timezone(_))
        .build

    def segmentBehaviors(
      recency: Option[RecencyDimension] = None
    ): SegmentBehaviors =
      SegmentBehaviors
        .builder
        .ifSome(recency)(_.recency(_))
        .build

    def segmentCondition(
      segmentId: Option[String] = None
    ): SegmentCondition =
      SegmentCondition
        .builder
        .ifSome(segmentId)(_.segmentId(_))
        .build

    def segmentDemographics(
      appVersion: Option[SetDimension] = None,
      channel: Option[SetDimension] = None,
      deviceType: Option[SetDimension] = None,
      make: Option[SetDimension] = None,
      model: Option[SetDimension] = None,
      platform: Option[SetDimension] = None
    ): SegmentDemographics =
      SegmentDemographics
        .builder
        .ifSome(appVersion)(_.appVersion(_))
        .ifSome(channel)(_.channel(_))
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(make)(_.make(_))
        .ifSome(model)(_.model(_))
        .ifSome(platform)(_.platform(_))
        .build

    def segmentDimensions(
      attributes: Option[MapOfAttributeDimension] = None,
      behavior: Option[SegmentBehaviors] = None,
      demographic: Option[SegmentDemographics] = None,
      location: Option[SegmentLocation] = None,
      metrics: Option[MapOfMetricDimension] = None,
      userAttributes: Option[MapOfAttributeDimension] = None
    ): SegmentDimensions =
      SegmentDimensions
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(behavior)(_.behavior(_))
        .ifSome(demographic)(_.demographic(_))
        .ifSome(location)(_.location(_))
        .ifSome(metrics)(_.metrics(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .build

    def segmentGroup(
      dimensions: Option[List[SegmentDimensions]] = None,
      sourceSegments: Option[List[SegmentReference]] = None,
      sourceType: Option[String] = None,
      `type`: Option[String] = None
    ): SegmentGroup =
      SegmentGroup
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(sourceSegments)(_.sourceSegments(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def segmentGroupList(
      groups: Option[List[SegmentGroup]] = None,
      include: Option[String] = None
    ): SegmentGroupList =
      SegmentGroupList
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(include)(_.include(_))
        .build

    def segmentImportResource(
      channelCounts: Option[MapOf__integer] = None,
      externalId: Option[String] = None,
      format: Option[String] = None,
      roleArn: Option[String] = None,
      s3Url: Option[String] = None,
      size: Option[Int] = None
    ): SegmentImportResource =
      SegmentImportResource
        .builder
        .ifSome(channelCounts)(_.channelCounts(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(format)(_.format(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(s3Url)(_.s3Url(_))
        .ifSome(size)(_.size(_))
        .build

    def segmentLocation(
      country: Option[SetDimension] = None,
      gPSPoint: Option[GPSPointDimension] = None
    ): SegmentLocation =
      SegmentLocation
        .builder
        .ifSome(country)(_.country(_))
        .ifSome(gPSPoint)(_.gPSPoint(_))
        .build

    def segmentReference(
      id: Option[String] = None,
      version: Option[Int] = None
    ): SegmentReference =
      SegmentReference
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def segmentResponse(
      applicationId: Option[String] = None,
      arn: Option[String] = None,
      creationDate: Option[String] = None,
      dimensions: Option[SegmentDimensions] = None,
      id: Option[String] = None,
      importDefinition: Option[SegmentImportResource] = None,
      lastModifiedDate: Option[String] = None,
      name: Option[String] = None,
      segmentGroups: Option[SegmentGroupList] = None,
      segmentType: Option[String] = None,
      tags: Option[MapOf__string] = None,
      version: Option[Int] = None
    ): SegmentResponse =
      SegmentResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(id)(_.id(_))
        .ifSome(importDefinition)(_.importDefinition(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(segmentGroups)(_.segmentGroups(_))
        .ifSome(segmentType)(_.segmentType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(version)(_.version(_))
        .build

    def segmentsResponse(
      item: Option[List[SegmentResponse]] = None,
      nextToken: Option[String] = None
    ): SegmentsResponse =
      SegmentsResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def sendMessagesRequest(
      applicationId: Option[String] = None,
      messageRequest: Option[MessageRequest] = None
    ): SendMessagesRequest =
      SendMessagesRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(messageRequest)(_.messageRequest(_))
        .build

    def sendMessagesResponse(
      messageResponse: Option[MessageResponse] = None
    ): SendMessagesResponse =
      SendMessagesResponse
        .builder
        .ifSome(messageResponse)(_.messageResponse(_))
        .build

    def sendUsersMessageRequest(
      context: Option[MapOf__string] = None,
      messageConfiguration: Option[DirectMessageConfiguration] = None,
      templateConfiguration: Option[TemplateConfiguration] = None,
      traceId: Option[String] = None,
      users: Option[MapOfEndpointSendConfiguration] = None
    ): SendUsersMessageRequest =
      SendUsersMessageRequest
        .builder
        .ifSome(context)(_.context(_))
        .ifSome(messageConfiguration)(_.messageConfiguration(_))
        .ifSome(templateConfiguration)(_.templateConfiguration(_))
        .ifSome(traceId)(_.traceId(_))
        .ifSome(users)(_.users(_))
        .build

    def sendUsersMessageResponse(
      applicationId: Option[String] = None,
      requestId: Option[String] = None,
      result: Option[MapOfMapOfEndpointMessageResult] = None
    ): SendUsersMessageResponse =
      SendUsersMessageResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(result)(_.result(_))
        .build

    def sendUsersMessagesRequest(
      applicationId: Option[String] = None,
      sendUsersMessageRequest: Option[SendUsersMessageRequest] = None
    ): SendUsersMessagesRequest =
      SendUsersMessagesRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(sendUsersMessageRequest)(_.sendUsersMessageRequest(_))
        .build

    def sendUsersMessagesResponse(
      sendUsersMessageResponse: Option[SendUsersMessageResponse] = None
    ): SendUsersMessagesResponse =
      SendUsersMessagesResponse
        .builder
        .ifSome(sendUsersMessageResponse)(_.sendUsersMessageResponse(_))
        .build

    def session(
      duration: Option[Int] = None,
      id: Option[String] = None,
      startTimestamp: Option[String] = None,
      stopTimestamp: Option[String] = None
    ): Session =
      Session
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(id)(_.id(_))
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(stopTimestamp)(_.stopTimestamp(_))
        .build

    def setDimension(
      dimensionType: Option[String] = None,
      values: Option[List[__string]] = None
    ): SetDimension =
      SetDimension
        .builder
        .ifSome(dimensionType)(_.dimensionType(_))
        .ifSome(values)(_.values(_))
        .build

    def simpleCondition(
      eventCondition: Option[EventCondition] = None,
      segmentCondition: Option[SegmentCondition] = None,
      segmentDimensions: Option[SegmentDimensions] = None
    ): SimpleCondition =
      SimpleCondition
        .builder
        .ifSome(eventCondition)(_.eventCondition(_))
        .ifSome(segmentCondition)(_.segmentCondition(_))
        .ifSome(segmentDimensions)(_.segmentDimensions(_))
        .build

    def simpleEmail(
      htmlPart: Option[SimpleEmailPart] = None,
      subject: Option[SimpleEmailPart] = None,
      textPart: Option[SimpleEmailPart] = None
    ): SimpleEmail =
      SimpleEmail
        .builder
        .ifSome(htmlPart)(_.htmlPart(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(textPart)(_.textPart(_))
        .build

    def simpleEmailPart(
      charset: Option[String] = None,
      data: Option[String] = None
    ): SimpleEmailPart =
      SimpleEmailPart
        .builder
        .ifSome(charset)(_.charset(_))
        .ifSome(data)(_.data(_))
        .build

    def startCondition(
      description: Option[String] = None,
      eventStartCondition: Option[EventStartCondition] = None,
      segmentStartCondition: Option[SegmentCondition] = None
    ): StartCondition =
      StartCondition
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(eventStartCondition)(_.eventStartCondition(_))
        .ifSome(segmentStartCondition)(_.segmentStartCondition(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tagsModel: Option[TagsModel] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagsModel)(_.tagsModel(_))
        .build

    def tagsModel(
      tags: Option[MapOf__string] = None
    ): TagsModel =
      TagsModel
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def template(
      name: Option[String] = None,
      version: Option[String] = None
    ): Template =
      Template
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def templateActiveVersionRequest(
      version: Option[String] = None
    ): TemplateActiveVersionRequest =
      TemplateActiveVersionRequest
        .builder
        .ifSome(version)(_.version(_))
        .build

    def templateConfiguration(
      emailTemplate: Option[Template] = None,
      pushTemplate: Option[Template] = None,
      sMSTemplate: Option[Template] = None,
      voiceTemplate: Option[Template] = None
    ): TemplateConfiguration =
      TemplateConfiguration
        .builder
        .ifSome(emailTemplate)(_.emailTemplate(_))
        .ifSome(pushTemplate)(_.pushTemplate(_))
        .ifSome(sMSTemplate)(_.sMSTemplate(_))
        .ifSome(voiceTemplate)(_.voiceTemplate(_))
        .build

    def templateResponse(
      arn: Option[String] = None,
      creationDate: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None,
      version: Option[String] = None
    ): TemplateResponse =
      TemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .ifSome(version)(_.version(_))
        .build

    def templateVersionResponse(
      creationDate: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      templateDescription: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None,
      version: Option[String] = None
    ): TemplateVersionResponse =
      TemplateVersionResponse
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .ifSome(version)(_.version(_))
        .build

    def templateVersionsResponse(
      item: Option[List[TemplateVersionResponse]] = None,
      message: Option[String] = None,
      nextToken: Option[String] = None,
      requestID: Option[String] = None
    ): TemplateVersionsResponse =
      TemplateVersionsResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(message)(_.message(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def templatesResponse(
      item: Option[List[TemplateResponse]] = None,
      nextToken: Option[String] = None
    ): TemplatesResponse =
      TemplatesResponse
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None,
      requestID: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestID)(_.requestID(_))
        .build

    def treatmentResource(
      customDeliveryConfiguration: Option[CustomDeliveryConfiguration] = None,
      id: Option[String] = None,
      messageConfiguration: Option[MessageConfiguration] = None,
      schedule: Option[Schedule] = None,
      sizePercent: Option[Int] = None,
      state: Option[CampaignState] = None,
      templateConfiguration: Option[TemplateConfiguration] = None,
      treatmentDescription: Option[String] = None,
      treatmentName: Option[String] = None
    ): TreatmentResource =
      TreatmentResource
        .builder
        .ifSome(customDeliveryConfiguration)(_.customDeliveryConfiguration(_))
        .ifSome(id)(_.id(_))
        .ifSome(messageConfiguration)(_.messageConfiguration(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(sizePercent)(_.sizePercent(_))
        .ifSome(state)(_.state(_))
        .ifSome(templateConfiguration)(_.templateConfiguration(_))
        .ifSome(treatmentDescription)(_.treatmentDescription(_))
        .ifSome(treatmentName)(_.treatmentName(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAdmChannelRequest(
      aDMChannelRequest: Option[ADMChannelRequest] = None,
      applicationId: Option[String] = None
    ): UpdateAdmChannelRequest =
      UpdateAdmChannelRequest
        .builder
        .ifSome(aDMChannelRequest)(_.aDMChannelRequest(_))
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def updateAdmChannelResponse(
      aDMChannelResponse: Option[ADMChannelResponse] = None
    ): UpdateAdmChannelResponse =
      UpdateAdmChannelResponse
        .builder
        .ifSome(aDMChannelResponse)(_.aDMChannelResponse(_))
        .build

    def updateApnsChannelRequest(
      aPNSChannelRequest: Option[APNSChannelRequest] = None,
      applicationId: Option[String] = None
    ): UpdateApnsChannelRequest =
      UpdateApnsChannelRequest
        .builder
        .ifSome(aPNSChannelRequest)(_.aPNSChannelRequest(_))
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def updateApnsChannelResponse(
      aPNSChannelResponse: Option[APNSChannelResponse] = None
    ): UpdateApnsChannelResponse =
      UpdateApnsChannelResponse
        .builder
        .ifSome(aPNSChannelResponse)(_.aPNSChannelResponse(_))
        .build

    def updateApnsSandboxChannelRequest(
      aPNSSandboxChannelRequest: Option[APNSSandboxChannelRequest] = None,
      applicationId: Option[String] = None
    ): UpdateApnsSandboxChannelRequest =
      UpdateApnsSandboxChannelRequest
        .builder
        .ifSome(aPNSSandboxChannelRequest)(_.aPNSSandboxChannelRequest(_))
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def updateApnsSandboxChannelResponse(
      aPNSSandboxChannelResponse: Option[APNSSandboxChannelResponse] = None
    ): UpdateApnsSandboxChannelResponse =
      UpdateApnsSandboxChannelResponse
        .builder
        .ifSome(aPNSSandboxChannelResponse)(_.aPNSSandboxChannelResponse(_))
        .build

    def updateApnsVoipChannelRequest(
      aPNSVoipChannelRequest: Option[APNSVoipChannelRequest] = None,
      applicationId: Option[String] = None
    ): UpdateApnsVoipChannelRequest =
      UpdateApnsVoipChannelRequest
        .builder
        .ifSome(aPNSVoipChannelRequest)(_.aPNSVoipChannelRequest(_))
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def updateApnsVoipChannelResponse(
      aPNSVoipChannelResponse: Option[APNSVoipChannelResponse] = None
    ): UpdateApnsVoipChannelResponse =
      UpdateApnsVoipChannelResponse
        .builder
        .ifSome(aPNSVoipChannelResponse)(_.aPNSVoipChannelResponse(_))
        .build

    def updateApnsVoipSandboxChannelRequest(
      aPNSVoipSandboxChannelRequest: Option[APNSVoipSandboxChannelRequest] = None,
      applicationId: Option[String] = None
    ): UpdateApnsVoipSandboxChannelRequest =
      UpdateApnsVoipSandboxChannelRequest
        .builder
        .ifSome(aPNSVoipSandboxChannelRequest)(_.aPNSVoipSandboxChannelRequest(_))
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def updateApnsVoipSandboxChannelResponse(
      aPNSVoipSandboxChannelResponse: Option[APNSVoipSandboxChannelResponse] = None
    ): UpdateApnsVoipSandboxChannelResponse =
      UpdateApnsVoipSandboxChannelResponse
        .builder
        .ifSome(aPNSVoipSandboxChannelResponse)(_.aPNSVoipSandboxChannelResponse(_))
        .build

    def updateApplicationSettingsRequest(
      applicationId: Option[String] = None,
      writeApplicationSettingsRequest: Option[WriteApplicationSettingsRequest] = None
    ): UpdateApplicationSettingsRequest =
      UpdateApplicationSettingsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(writeApplicationSettingsRequest)(_.writeApplicationSettingsRequest(_))
        .build

    def updateApplicationSettingsResponse(
      applicationSettingsResource: Option[ApplicationSettingsResource] = None
    ): UpdateApplicationSettingsResponse =
      UpdateApplicationSettingsResponse
        .builder
        .ifSome(applicationSettingsResource)(_.applicationSettingsResource(_))
        .build

    def updateAttributesRequest(
      blacklist: Option[List[__string]] = None
    ): UpdateAttributesRequest =
      UpdateAttributesRequest
        .builder
        .ifSome(blacklist)(_.blacklist(_))
        .build

    def updateBaiduChannelRequest(
      applicationId: Option[String] = None,
      baiduChannelRequest: Option[BaiduChannelRequest] = None
    ): UpdateBaiduChannelRequest =
      UpdateBaiduChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(baiduChannelRequest)(_.baiduChannelRequest(_))
        .build

    def updateBaiduChannelResponse(
      baiduChannelResponse: Option[BaiduChannelResponse] = None
    ): UpdateBaiduChannelResponse =
      UpdateBaiduChannelResponse
        .builder
        .ifSome(baiduChannelResponse)(_.baiduChannelResponse(_))
        .build

    def updateCampaignRequest(
      applicationId: Option[String] = None,
      campaignId: Option[String] = None,
      writeCampaignRequest: Option[WriteCampaignRequest] = None
    ): UpdateCampaignRequest =
      UpdateCampaignRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(campaignId)(_.campaignId(_))
        .ifSome(writeCampaignRequest)(_.writeCampaignRequest(_))
        .build

    def updateCampaignResponse(
      campaignResponse: Option[CampaignResponse] = None
    ): UpdateCampaignResponse =
      UpdateCampaignResponse
        .builder
        .ifSome(campaignResponse)(_.campaignResponse(_))
        .build

    def updateEmailChannelRequest(
      applicationId: Option[String] = None,
      emailChannelRequest: Option[EmailChannelRequest] = None
    ): UpdateEmailChannelRequest =
      UpdateEmailChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(emailChannelRequest)(_.emailChannelRequest(_))
        .build

    def updateEmailChannelResponse(
      emailChannelResponse: Option[EmailChannelResponse] = None
    ): UpdateEmailChannelResponse =
      UpdateEmailChannelResponse
        .builder
        .ifSome(emailChannelResponse)(_.emailChannelResponse(_))
        .build

    def updateEmailTemplateRequest(
      createNewVersion: Option[Boolean] = None,
      emailTemplateRequest: Option[EmailTemplateRequest] = None,
      templateName: Option[String] = None,
      version: Option[String] = None
    ): UpdateEmailTemplateRequest =
      UpdateEmailTemplateRequest
        .builder
        .ifSome(createNewVersion)(_.createNewVersion(_))
        .ifSome(emailTemplateRequest)(_.emailTemplateRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def updateEmailTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): UpdateEmailTemplateResponse =
      UpdateEmailTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def updateEndpointRequest(
      applicationId: Option[String] = None,
      endpointId: Option[String] = None,
      endpointRequest: Option[EndpointRequest] = None
    ): UpdateEndpointRequest =
      UpdateEndpointRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(endpointRequest)(_.endpointRequest(_))
        .build

    def updateEndpointResponse(
      messageBody: Option[MessageBody] = None
    ): UpdateEndpointResponse =
      UpdateEndpointResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def updateEndpointsBatchRequest(
      applicationId: Option[String] = None,
      endpointBatchRequest: Option[EndpointBatchRequest] = None
    ): UpdateEndpointsBatchRequest =
      UpdateEndpointsBatchRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(endpointBatchRequest)(_.endpointBatchRequest(_))
        .build

    def updateEndpointsBatchResponse(
      messageBody: Option[MessageBody] = None
    ): UpdateEndpointsBatchResponse =
      UpdateEndpointsBatchResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def updateGcmChannelRequest(
      applicationId: Option[String] = None,
      gCMChannelRequest: Option[GCMChannelRequest] = None
    ): UpdateGcmChannelRequest =
      UpdateGcmChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(gCMChannelRequest)(_.gCMChannelRequest(_))
        .build

    def updateGcmChannelResponse(
      gCMChannelResponse: Option[GCMChannelResponse] = None
    ): UpdateGcmChannelResponse =
      UpdateGcmChannelResponse
        .builder
        .ifSome(gCMChannelResponse)(_.gCMChannelResponse(_))
        .build

    def updateJourneyRequest(
      applicationId: Option[String] = None,
      journeyId: Option[String] = None,
      writeJourneyRequest: Option[WriteJourneyRequest] = None
    ): UpdateJourneyRequest =
      UpdateJourneyRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(writeJourneyRequest)(_.writeJourneyRequest(_))
        .build

    def updateJourneyResponse(
      journeyResponse: Option[JourneyResponse] = None
    ): UpdateJourneyResponse =
      UpdateJourneyResponse
        .builder
        .ifSome(journeyResponse)(_.journeyResponse(_))
        .build

    def updateJourneyStateRequest(
      applicationId: Option[String] = None,
      journeyId: Option[String] = None,
      journeyStateRequest: Option[JourneyStateRequest] = None
    ): UpdateJourneyStateRequest =
      UpdateJourneyStateRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(journeyId)(_.journeyId(_))
        .ifSome(journeyStateRequest)(_.journeyStateRequest(_))
        .build

    def updateJourneyStateResponse(
      journeyResponse: Option[JourneyResponse] = None
    ): UpdateJourneyStateResponse =
      UpdateJourneyStateResponse
        .builder
        .ifSome(journeyResponse)(_.journeyResponse(_))
        .build

    def updatePushTemplateRequest(
      createNewVersion: Option[Boolean] = None,
      pushNotificationTemplateRequest: Option[PushNotificationTemplateRequest] = None,
      templateName: Option[String] = None,
      version: Option[String] = None
    ): UpdatePushTemplateRequest =
      UpdatePushTemplateRequest
        .builder
        .ifSome(createNewVersion)(_.createNewVersion(_))
        .ifSome(pushNotificationTemplateRequest)(_.pushNotificationTemplateRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def updatePushTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): UpdatePushTemplateResponse =
      UpdatePushTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def updateRecommenderConfiguration(
      attributes: Option[MapOf__string] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      recommendationProviderIdType: Option[String] = None,
      recommendationProviderRoleArn: Option[String] = None,
      recommendationProviderUri: Option[String] = None,
      recommendationTransformerUri: Option[String] = None,
      recommendationsDisplayName: Option[String] = None,
      recommendationsPerMessage: Option[Int] = None
    ): UpdateRecommenderConfiguration =
      UpdateRecommenderConfiguration
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(recommendationProviderIdType)(_.recommendationProviderIdType(_))
        .ifSome(recommendationProviderRoleArn)(_.recommendationProviderRoleArn(_))
        .ifSome(recommendationProviderUri)(_.recommendationProviderUri(_))
        .ifSome(recommendationTransformerUri)(_.recommendationTransformerUri(_))
        .ifSome(recommendationsDisplayName)(_.recommendationsDisplayName(_))
        .ifSome(recommendationsPerMessage)(_.recommendationsPerMessage(_))
        .build

    def updateRecommenderConfigurationRequest(
      recommenderId: Option[String] = None,
      updateRecommenderConfiguration: Option[UpdateRecommenderConfiguration] = None
    ): UpdateRecommenderConfigurationRequest =
      UpdateRecommenderConfigurationRequest
        .builder
        .ifSome(recommenderId)(_.recommenderId(_))
        .ifSome(updateRecommenderConfiguration)(_.updateRecommenderConfiguration(_))
        .build

    def updateRecommenderConfigurationResponse(
      recommenderConfigurationResponse: Option[RecommenderConfigurationResponse] = None
    ): UpdateRecommenderConfigurationResponse =
      UpdateRecommenderConfigurationResponse
        .builder
        .ifSome(recommenderConfigurationResponse)(_.recommenderConfigurationResponse(_))
        .build

    def updateSegmentRequest(
      applicationId: Option[String] = None,
      segmentId: Option[String] = None,
      writeSegmentRequest: Option[WriteSegmentRequest] = None
    ): UpdateSegmentRequest =
      UpdateSegmentRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(writeSegmentRequest)(_.writeSegmentRequest(_))
        .build

    def updateSegmentResponse(
      segmentResponse: Option[SegmentResponse] = None
    ): UpdateSegmentResponse =
      UpdateSegmentResponse
        .builder
        .ifSome(segmentResponse)(_.segmentResponse(_))
        .build

    def updateSmsChannelRequest(
      applicationId: Option[String] = None,
      sMSChannelRequest: Option[SMSChannelRequest] = None
    ): UpdateSmsChannelRequest =
      UpdateSmsChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(sMSChannelRequest)(_.sMSChannelRequest(_))
        .build

    def updateSmsChannelResponse(
      sMSChannelResponse: Option[SMSChannelResponse] = None
    ): UpdateSmsChannelResponse =
      UpdateSmsChannelResponse
        .builder
        .ifSome(sMSChannelResponse)(_.sMSChannelResponse(_))
        .build

    def updateSmsTemplateRequest(
      createNewVersion: Option[Boolean] = None,
      sMSTemplateRequest: Option[SMSTemplateRequest] = None,
      templateName: Option[String] = None,
      version: Option[String] = None
    ): UpdateSmsTemplateRequest =
      UpdateSmsTemplateRequest
        .builder
        .ifSome(createNewVersion)(_.createNewVersion(_))
        .ifSome(sMSTemplateRequest)(_.sMSTemplateRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .build

    def updateSmsTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): UpdateSmsTemplateResponse =
      UpdateSmsTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def updateTemplateActiveVersionRequest(
      templateActiveVersionRequest: Option[TemplateActiveVersionRequest] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None
    ): UpdateTemplateActiveVersionRequest =
      UpdateTemplateActiveVersionRequest
        .builder
        .ifSome(templateActiveVersionRequest)(_.templateActiveVersionRequest(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .build

    def updateTemplateActiveVersionResponse(
      messageBody: Option[MessageBody] = None
    ): UpdateTemplateActiveVersionResponse =
      UpdateTemplateActiveVersionResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def updateVoiceChannelRequest(
      applicationId: Option[String] = None,
      voiceChannelRequest: Option[VoiceChannelRequest] = None
    ): UpdateVoiceChannelRequest =
      UpdateVoiceChannelRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(voiceChannelRequest)(_.voiceChannelRequest(_))
        .build

    def updateVoiceChannelResponse(
      voiceChannelResponse: Option[VoiceChannelResponse] = None
    ): UpdateVoiceChannelResponse =
      UpdateVoiceChannelResponse
        .builder
        .ifSome(voiceChannelResponse)(_.voiceChannelResponse(_))
        .build

    def updateVoiceTemplateRequest(
      createNewVersion: Option[Boolean] = None,
      templateName: Option[String] = None,
      version: Option[String] = None,
      voiceTemplateRequest: Option[VoiceTemplateRequest] = None
    ): UpdateVoiceTemplateRequest =
      UpdateVoiceTemplateRequest
        .builder
        .ifSome(createNewVersion)(_.createNewVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(version)(_.version(_))
        .ifSome(voiceTemplateRequest)(_.voiceTemplateRequest(_))
        .build

    def updateVoiceTemplateResponse(
      messageBody: Option[MessageBody] = None
    ): UpdateVoiceTemplateResponse =
      UpdateVoiceTemplateResponse
        .builder
        .ifSome(messageBody)(_.messageBody(_))
        .build

    def voiceChannelRequest(
      enabled: Option[Boolean] = None
    ): VoiceChannelRequest =
      VoiceChannelRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def voiceChannelResponse(
      applicationId: Option[String] = None,
      creationDate: Option[String] = None,
      enabled: Option[Boolean] = None,
      hasCredential: Option[Boolean] = None,
      id: Option[String] = None,
      isArchived: Option[Boolean] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      platform: Option[String] = None,
      version: Option[Int] = None
    ): VoiceChannelResponse =
      VoiceChannelResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(hasCredential)(_.hasCredential(_))
        .ifSome(id)(_.id(_))
        .ifSome(isArchived)(_.isArchived(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(version)(_.version(_))
        .build

    def voiceMessage(
      body: Option[String] = None,
      languageCode: Option[String] = None,
      originationNumber: Option[String] = None,
      substitutions: Option[MapOfListOf__string] = None,
      voiceId: Option[String] = None
    ): VoiceMessage =
      VoiceMessage
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(originationNumber)(_.originationNumber(_))
        .ifSome(substitutions)(_.substitutions(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def voiceTemplateRequest(
      body: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      languageCode: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      voiceId: Option[String] = None
    ): VoiceTemplateRequest =
      VoiceTemplateRequest
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def voiceTemplateResponse(
      arn: Option[String] = None,
      body: Option[String] = None,
      creationDate: Option[String] = None,
      defaultSubstitutions: Option[String] = None,
      languageCode: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      tags: Option[MapOf__string] = None,
      templateDescription: Option[String] = None,
      templateName: Option[String] = None,
      templateType: Option[String] = None,
      version: Option[String] = None,
      voiceId: Option[String] = None
    ): VoiceTemplateResponse =
      VoiceTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(body)(_.body(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(defaultSubstitutions)(_.defaultSubstitutions(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateType)(_.templateType(_))
        .ifSome(version)(_.version(_))
        .ifSome(voiceId)(_.voiceId(_))
        .build

    def waitActivity(
      nextActivity: Option[String] = None,
      waitTime: Option[WaitTime] = None
    ): WaitActivity =
      WaitActivity
        .builder
        .ifSome(nextActivity)(_.nextActivity(_))
        .ifSome(waitTime)(_.waitTime(_))
        .build

    def waitTime(
      waitFor: Option[String] = None,
      waitUntil: Option[String] = None
    ): WaitTime =
      WaitTime
        .builder
        .ifSome(waitFor)(_.waitFor(_))
        .ifSome(waitUntil)(_.waitUntil(_))
        .build

    def writeApplicationSettingsRequest(
      campaignHook: Option[CampaignHook] = None,
      cloudWatchMetricsEnabled: Option[Boolean] = None,
      eventTaggingEnabled: Option[Boolean] = None,
      limits: Option[CampaignLimits] = None,
      quietTime: Option[QuietTime] = None
    ): WriteApplicationSettingsRequest =
      WriteApplicationSettingsRequest
        .builder
        .ifSome(campaignHook)(_.campaignHook(_))
        .ifSome(cloudWatchMetricsEnabled)(_.cloudWatchMetricsEnabled(_))
        .ifSome(eventTaggingEnabled)(_.eventTaggingEnabled(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(quietTime)(_.quietTime(_))
        .build

    def writeCampaignRequest(
      additionalTreatments: Option[List[WriteTreatmentResource]] = None,
      customDeliveryConfiguration: Option[CustomDeliveryConfiguration] = None,
      description: Option[String] = None,
      holdoutPercent: Option[Int] = None,
      hook: Option[CampaignHook] = None,
      isPaused: Option[Boolean] = None,
      limits: Option[CampaignLimits] = None,
      messageConfiguration: Option[MessageConfiguration] = None,
      name: Option[String] = None,
      schedule: Option[Schedule] = None,
      segmentId: Option[String] = None,
      segmentVersion: Option[Int] = None,
      tags: Option[MapOf__string] = None,
      templateConfiguration: Option[TemplateConfiguration] = None,
      treatmentDescription: Option[String] = None,
      treatmentName: Option[String] = None
    ): WriteCampaignRequest =
      WriteCampaignRequest
        .builder
        .ifSome(additionalTreatments)(_.additionalTreatments(_))
        .ifSome(customDeliveryConfiguration)(_.customDeliveryConfiguration(_))
        .ifSome(description)(_.description(_))
        .ifSome(holdoutPercent)(_.holdoutPercent(_))
        .ifSome(hook)(_.hook(_))
        .ifSome(isPaused)(_.isPaused(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(messageConfiguration)(_.messageConfiguration(_))
        .ifSome(name)(_.name(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(segmentId)(_.segmentId(_))
        .ifSome(segmentVersion)(_.segmentVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateConfiguration)(_.templateConfiguration(_))
        .ifSome(treatmentDescription)(_.treatmentDescription(_))
        .ifSome(treatmentName)(_.treatmentName(_))
        .build

    def writeEventStream(
      destinationStreamArn: Option[String] = None,
      roleArn: Option[String] = None
    ): WriteEventStream =
      WriteEventStream
        .builder
        .ifSome(destinationStreamArn)(_.destinationStreamArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def writeJourneyRequest(
      activities: Option[MapOfActivity] = None,
      creationDate: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      limits: Option[JourneyLimits] = None,
      localTime: Option[Boolean] = None,
      name: Option[String] = None,
      quietTime: Option[QuietTime] = None,
      refreshFrequency: Option[String] = None,
      schedule: Option[JourneySchedule] = None,
      startActivity: Option[String] = None,
      startCondition: Option[StartCondition] = None,
      state: Option[String] = None,
      waitForQuietTime: Option[Boolean] = None,
      refreshOnSegmentUpdate: Option[Boolean] = None
    ): WriteJourneyRequest =
      WriteJourneyRequest
        .builder
        .ifSome(activities)(_.activities(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(localTime)(_.localTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(quietTime)(_.quietTime(_))
        .ifSome(refreshFrequency)(_.refreshFrequency(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(startActivity)(_.startActivity(_))
        .ifSome(startCondition)(_.startCondition(_))
        .ifSome(state)(_.state(_))
        .ifSome(waitForQuietTime)(_.waitForQuietTime(_))
        .ifSome(refreshOnSegmentUpdate)(_.refreshOnSegmentUpdate(_))
        .build

    def writeSegmentRequest(
      dimensions: Option[SegmentDimensions] = None,
      name: Option[String] = None,
      segmentGroups: Option[SegmentGroupList] = None,
      tags: Option[MapOf__string] = None
    ): WriteSegmentRequest =
      WriteSegmentRequest
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(name)(_.name(_))
        .ifSome(segmentGroups)(_.segmentGroups(_))
        .ifSome(tags)(_.tags(_))
        .build

    def writeTreatmentResource(
      customDeliveryConfiguration: Option[CustomDeliveryConfiguration] = None,
      messageConfiguration: Option[MessageConfiguration] = None,
      schedule: Option[Schedule] = None,
      sizePercent: Option[Int] = None,
      templateConfiguration: Option[TemplateConfiguration] = None,
      treatmentDescription: Option[String] = None,
      treatmentName: Option[String] = None
    ): WriteTreatmentResource =
      WriteTreatmentResource
        .builder
        .ifSome(customDeliveryConfiguration)(_.customDeliveryConfiguration(_))
        .ifSome(messageConfiguration)(_.messageConfiguration(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(sizePercent)(_.sizePercent(_))
        .ifSome(templateConfiguration)(_.templateConfiguration(_))
        .ifSome(treatmentDescription)(_.treatmentDescription(_))
        .ifSome(treatmentName)(_.treatmentName(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
