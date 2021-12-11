package goober.hi

import goober.free.cloudtrail.CloudTrailIO
import software.amazon.awssdk.services.cloudtrail.model._


object cloudtrail {
  import goober.free.{cloudtrail ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addTagsRequest(
      resourceId: Option[String] = None,
      tagsList: Option[List[Tag]] = None
    ): AddTagsRequest =
      AddTagsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagsList)(_.tagsList(_))
        .build

    def addTagsResponse(

    ): AddTagsResponse =
      AddTagsResponse
        .builder

        .build

    def advancedEventSelector(
      name: Option[String] = None,
      fieldSelectors: Option[List[AdvancedFieldSelector]] = None
    ): AdvancedEventSelector =
      AdvancedEventSelector
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(fieldSelectors)(_.fieldSelectors(_))
        .build

    def advancedFieldSelector(
      field: Option[String] = None,
      equals: Option[List[OperatorValue]] = None,
      startsWith: Option[List[OperatorValue]] = None,
      endsWith: Option[List[OperatorValue]] = None,
      notEquals: Option[List[OperatorValue]] = None,
      notStartsWith: Option[List[OperatorValue]] = None,
      notEndsWith: Option[List[OperatorValue]] = None
    ): AdvancedFieldSelector =
      AdvancedFieldSelector
        .builder
        .ifSome(field)(_.field(_))
        .ifSome(equals)(_.equals(_))
        .ifSome(startsWith)(_.startsWith(_))
        .ifSome(endsWith)(_.endsWith(_))
        .ifSome(notEquals)(_.notEquals(_))
        .ifSome(notStartsWith)(_.notStartsWith(_))
        .ifSome(notEndsWith)(_.notEndsWith(_))
        .build

    def cloudTrailARNInvalidException(

    ): CloudTrailARNInvalidException =
      CloudTrailARNInvalidException
        .builder

        .build

    def cloudTrailAccessNotEnabledException(

    ): CloudTrailAccessNotEnabledException =
      CloudTrailAccessNotEnabledException
        .builder

        .build

    def cloudTrailInvalidClientTokenIdException(

    ): CloudTrailInvalidClientTokenIdException =
      CloudTrailInvalidClientTokenIdException
        .builder

        .build

    def cloudWatchLogsDeliveryUnavailableException(

    ): CloudWatchLogsDeliveryUnavailableException =
      CloudWatchLogsDeliveryUnavailableException
        .builder

        .build

    def conflictException(

    ): ConflictException =
      ConflictException
        .builder

        .build

    def createTrailRequest(
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      snsTopicName: Option[String] = None,
      includeGlobalServiceEvents: Option[Boolean] = None,
      isMultiRegionTrail: Option[Boolean] = None,
      enableLogFileValidation: Option[Boolean] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      isOrganizationTrail: Option[Boolean] = None,
      tagsList: Option[List[Tag]] = None
    ): CreateTrailRequest =
      CreateTrailRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(snsTopicName)(_.snsTopicName(_))
        .ifSome(includeGlobalServiceEvents)(_.includeGlobalServiceEvents(_))
        .ifSome(isMultiRegionTrail)(_.isMultiRegionTrail(_))
        .ifSome(enableLogFileValidation)(_.enableLogFileValidation(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(isOrganizationTrail)(_.isOrganizationTrail(_))
        .ifSome(tagsList)(_.tagsList(_))
        .build

    def createTrailResponse(
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      snsTopicName: Option[String] = None,
      snsTopicARN: Option[String] = None,
      includeGlobalServiceEvents: Option[Boolean] = None,
      isMultiRegionTrail: Option[Boolean] = None,
      trailARN: Option[String] = None,
      logFileValidationEnabled: Option[Boolean] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      isOrganizationTrail: Option[Boolean] = None
    ): CreateTrailResponse =
      CreateTrailResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(snsTopicName)(_.snsTopicName(_))
        .ifSome(snsTopicARN)(_.snsTopicARN(_))
        .ifSome(includeGlobalServiceEvents)(_.includeGlobalServiceEvents(_))
        .ifSome(isMultiRegionTrail)(_.isMultiRegionTrail(_))
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(logFileValidationEnabled)(_.logFileValidationEnabled(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(isOrganizationTrail)(_.isOrganizationTrail(_))
        .build

    def dataResource(
      `type`: Option[String] = None,
      values: Option[List[String]] = None
    ): DataResource =
      DataResource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(values)(_.values(_))
        .build

    def deleteTrailRequest(
      name: Option[String] = None
    ): DeleteTrailRequest =
      DeleteTrailRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteTrailResponse(

    ): DeleteTrailResponse =
      DeleteTrailResponse
        .builder

        .build

    def describeTrailsRequest(
      trailNameList: Option[List[String]] = None,
      includeShadowTrails: Option[Boolean] = None
    ): DescribeTrailsRequest =
      DescribeTrailsRequest
        .builder
        .ifSome(trailNameList)(_.trailNameList(_))
        .ifSome(includeShadowTrails)(_.includeShadowTrails(_))
        .build

    def describeTrailsResponse(
      trailList: Option[List[Trail]] = None
    ): DescribeTrailsResponse =
      DescribeTrailsResponse
        .builder
        .ifSome(trailList)(_.trailList(_))
        .build

    def event(
      eventId: Option[String] = None,
      eventName: Option[String] = None,
      readOnly: Option[String] = None,
      accessKeyId: Option[String] = None,
      eventTime: Option[Date] = None,
      eventSource: Option[String] = None,
      username: Option[String] = None,
      resources: Option[List[Resource]] = None,
      cloudTrailEvent: Option[String] = None
    ): Event =
      Event
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventName)(_.eventName(_))
        .ifSome(readOnly)(_.readOnly(_))
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(username)(_.username(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(cloudTrailEvent)(_.cloudTrailEvent(_))
        .build

    def eventSelector(
      readWriteType: Option[String] = None,
      includeManagementEvents: Option[Boolean] = None,
      dataResources: Option[List[DataResource]] = None,
      excludeManagementEventSources: Option[List[String]] = None
    ): EventSelector =
      EventSelector
        .builder
        .ifSome(readWriteType)(_.readWriteType(_))
        .ifSome(includeManagementEvents)(_.includeManagementEvents(_))
        .ifSome(dataResources)(_.dataResources(_))
        .ifSome(excludeManagementEventSources)(_.excludeManagementEventSources(_))
        .build

    def getEventSelectorsRequest(
      trailName: Option[String] = None
    ): GetEventSelectorsRequest =
      GetEventSelectorsRequest
        .builder
        .ifSome(trailName)(_.trailName(_))
        .build

    def getEventSelectorsResponse(
      trailARN: Option[String] = None,
      eventSelectors: Option[List[EventSelector]] = None,
      advancedEventSelectors: Option[List[AdvancedEventSelector]] = None
    ): GetEventSelectorsResponse =
      GetEventSelectorsResponse
        .builder
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(eventSelectors)(_.eventSelectors(_))
        .ifSome(advancedEventSelectors)(_.advancedEventSelectors(_))
        .build

    def getInsightSelectorsRequest(
      trailName: Option[String] = None
    ): GetInsightSelectorsRequest =
      GetInsightSelectorsRequest
        .builder
        .ifSome(trailName)(_.trailName(_))
        .build

    def getInsightSelectorsResponse(
      trailARN: Option[String] = None,
      insightSelectors: Option[List[InsightSelector]] = None
    ): GetInsightSelectorsResponse =
      GetInsightSelectorsResponse
        .builder
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(insightSelectors)(_.insightSelectors(_))
        .build

    def getTrailRequest(
      name: Option[String] = None
    ): GetTrailRequest =
      GetTrailRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getTrailResponse(
      trail: Option[Trail] = None
    ): GetTrailResponse =
      GetTrailResponse
        .builder
        .ifSome(trail)(_.trail(_))
        .build

    def getTrailStatusRequest(
      name: Option[String] = None
    ): GetTrailStatusRequest =
      GetTrailStatusRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getTrailStatusResponse(
      isLogging: Option[Boolean] = None,
      latestDeliveryError: Option[String] = None,
      latestNotificationError: Option[String] = None,
      latestDeliveryTime: Option[Date] = None,
      latestNotificationTime: Option[Date] = None,
      startLoggingTime: Option[Date] = None,
      stopLoggingTime: Option[Date] = None,
      latestCloudWatchLogsDeliveryError: Option[String] = None,
      latestCloudWatchLogsDeliveryTime: Option[Date] = None,
      latestDigestDeliveryTime: Option[Date] = None,
      latestDigestDeliveryError: Option[String] = None,
      latestDeliveryAttemptTime: Option[String] = None,
      latestNotificationAttemptTime: Option[String] = None,
      latestNotificationAttemptSucceeded: Option[String] = None,
      latestDeliveryAttemptSucceeded: Option[String] = None,
      timeLoggingStarted: Option[String] = None,
      timeLoggingStopped: Option[String] = None
    ): GetTrailStatusResponse =
      GetTrailStatusResponse
        .builder
        .ifSome(isLogging)(_.isLogging(_))
        .ifSome(latestDeliveryError)(_.latestDeliveryError(_))
        .ifSome(latestNotificationError)(_.latestNotificationError(_))
        .ifSome(latestDeliveryTime)(_.latestDeliveryTime(_))
        .ifSome(latestNotificationTime)(_.latestNotificationTime(_))
        .ifSome(startLoggingTime)(_.startLoggingTime(_))
        .ifSome(stopLoggingTime)(_.stopLoggingTime(_))
        .ifSome(latestCloudWatchLogsDeliveryError)(_.latestCloudWatchLogsDeliveryError(_))
        .ifSome(latestCloudWatchLogsDeliveryTime)(_.latestCloudWatchLogsDeliveryTime(_))
        .ifSome(latestDigestDeliveryTime)(_.latestDigestDeliveryTime(_))
        .ifSome(latestDigestDeliveryError)(_.latestDigestDeliveryError(_))
        .ifSome(latestDeliveryAttemptTime)(_.latestDeliveryAttemptTime(_))
        .ifSome(latestNotificationAttemptTime)(_.latestNotificationAttemptTime(_))
        .ifSome(latestNotificationAttemptSucceeded)(_.latestNotificationAttemptSucceeded(_))
        .ifSome(latestDeliveryAttemptSucceeded)(_.latestDeliveryAttemptSucceeded(_))
        .ifSome(timeLoggingStarted)(_.timeLoggingStarted(_))
        .ifSome(timeLoggingStopped)(_.timeLoggingStopped(_))
        .build

    def insightNotEnabledException(

    ): InsightNotEnabledException =
      InsightNotEnabledException
        .builder

        .build

    def insightSelector(
      insightType: Option[String] = None
    ): InsightSelector =
      InsightSelector
        .builder
        .ifSome(insightType)(_.insightType(_))
        .build

    def insufficientDependencyServiceAccessPermissionException(

    ): InsufficientDependencyServiceAccessPermissionException =
      InsufficientDependencyServiceAccessPermissionException
        .builder

        .build

    def insufficientEncryptionPolicyException(

    ): InsufficientEncryptionPolicyException =
      InsufficientEncryptionPolicyException
        .builder

        .build

    def insufficientS3BucketPolicyException(

    ): InsufficientS3BucketPolicyException =
      InsufficientS3BucketPolicyException
        .builder

        .build

    def insufficientSnsTopicPolicyException(

    ): InsufficientSnsTopicPolicyException =
      InsufficientSnsTopicPolicyException
        .builder

        .build

    def invalidCloudWatchLogsLogGroupArnException(

    ): InvalidCloudWatchLogsLogGroupArnException =
      InvalidCloudWatchLogsLogGroupArnException
        .builder

        .build

    def invalidCloudWatchLogsRoleArnException(

    ): InvalidCloudWatchLogsRoleArnException =
      InvalidCloudWatchLogsRoleArnException
        .builder

        .build

    def invalidEventCategoryException(

    ): InvalidEventCategoryException =
      InvalidEventCategoryException
        .builder

        .build

    def invalidEventSelectorsException(

    ): InvalidEventSelectorsException =
      InvalidEventSelectorsException
        .builder

        .build

    def invalidHomeRegionException(

    ): InvalidHomeRegionException =
      InvalidHomeRegionException
        .builder

        .build

    def invalidInsightSelectorsException(

    ): InvalidInsightSelectorsException =
      InvalidInsightSelectorsException
        .builder

        .build

    def invalidKmsKeyIdException(

    ): InvalidKmsKeyIdException =
      InvalidKmsKeyIdException
        .builder

        .build

    def invalidLookupAttributesException(

    ): InvalidLookupAttributesException =
      InvalidLookupAttributesException
        .builder

        .build

    def invalidMaxResultsException(

    ): InvalidMaxResultsException =
      InvalidMaxResultsException
        .builder

        .build

    def invalidNextTokenException(

    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder

        .build

    def invalidParameterCombinationException(

    ): InvalidParameterCombinationException =
      InvalidParameterCombinationException
        .builder

        .build

    def invalidS3BucketNameException(

    ): InvalidS3BucketNameException =
      InvalidS3BucketNameException
        .builder

        .build

    def invalidS3PrefixException(

    ): InvalidS3PrefixException =
      InvalidS3PrefixException
        .builder

        .build

    def invalidSnsTopicNameException(

    ): InvalidSnsTopicNameException =
      InvalidSnsTopicNameException
        .builder

        .build

    def invalidTagParameterException(

    ): InvalidTagParameterException =
      InvalidTagParameterException
        .builder

        .build

    def invalidTimeRangeException(

    ): InvalidTimeRangeException =
      InvalidTimeRangeException
        .builder

        .build

    def invalidTokenException(

    ): InvalidTokenException =
      InvalidTokenException
        .builder

        .build

    def invalidTrailNameException(

    ): InvalidTrailNameException =
      InvalidTrailNameException
        .builder

        .build

    def kmsException(

    ): KmsException =
      KmsException
        .builder

        .build

    def kmsKeyDisabledException(

    ): KmsKeyDisabledException =
      KmsKeyDisabledException
        .builder

        .build

    def kmsKeyNotFoundException(

    ): KmsKeyNotFoundException =
      KmsKeyNotFoundException
        .builder

        .build

    def listPublicKeysRequest(
      startTime: Option[Date] = None,
      endTime: Option[Date] = None,
      nextToken: Option[String] = None
    ): ListPublicKeysRequest =
      ListPublicKeysRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPublicKeysResponse(
      publicKeyList: Option[List[PublicKey]] = None,
      nextToken: Option[String] = None
    ): ListPublicKeysResponse =
      ListPublicKeysResponse
        .builder
        .ifSome(publicKeyList)(_.publicKeyList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsRequest(
      resourceIdList: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(resourceIdList)(_.resourceIdList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsResponse(
      resourceTagList: Option[List[ResourceTag]] = None,
      nextToken: Option[String] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(resourceTagList)(_.resourceTagList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrailsRequest(
      nextToken: Option[String] = None
    ): ListTrailsRequest =
      ListTrailsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTrailsResponse(
      trails: Option[List[TrailInfo]] = None,
      nextToken: Option[String] = None
    ): ListTrailsResponse =
      ListTrailsResponse
        .builder
        .ifSome(trails)(_.trails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lookupAttribute(
      attributeKey: Option[String] = None,
      attributeValue: Option[String] = None
    ): LookupAttribute =
      LookupAttribute
        .builder
        .ifSome(attributeKey)(_.attributeKey(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def lookupEventsRequest(
      lookupAttributes: Option[List[LookupAttribute]] = None,
      startTime: Option[Date] = None,
      endTime: Option[Date] = None,
      eventCategory: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): LookupEventsRequest =
      LookupEventsRequest
        .builder
        .ifSome(lookupAttributes)(_.lookupAttributes(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(eventCategory)(_.eventCategory(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lookupEventsResponse(
      events: Option[List[Event]] = None,
      nextToken: Option[String] = None
    ): LookupEventsResponse =
      LookupEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def maximumNumberOfTrailsExceededException(

    ): MaximumNumberOfTrailsExceededException =
      MaximumNumberOfTrailsExceededException
        .builder

        .build

    def notOrganizationMasterAccountException(

    ): NotOrganizationMasterAccountException =
      NotOrganizationMasterAccountException
        .builder

        .build

    def operationNotPermittedException(

    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder

        .build

    def organizationNotInAllFeaturesModeException(

    ): OrganizationNotInAllFeaturesModeException =
      OrganizationNotInAllFeaturesModeException
        .builder

        .build

    def organizationsNotInUseException(

    ): OrganizationsNotInUseException =
      OrganizationsNotInUseException
        .builder

        .build

    def publicKey(
      value: Option[ByteBuffer] = None,
      validityStartTime: Option[Date] = None,
      validityEndTime: Option[Date] = None,
      fingerprint: Option[String] = None
    ): PublicKey =
      PublicKey
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(validityStartTime)(_.validityStartTime(_))
        .ifSome(validityEndTime)(_.validityEndTime(_))
        .ifSome(fingerprint)(_.fingerprint(_))
        .build

    def putEventSelectorsRequest(
      trailName: Option[String] = None,
      eventSelectors: Option[List[EventSelector]] = None,
      advancedEventSelectors: Option[List[AdvancedEventSelector]] = None
    ): PutEventSelectorsRequest =
      PutEventSelectorsRequest
        .builder
        .ifSome(trailName)(_.trailName(_))
        .ifSome(eventSelectors)(_.eventSelectors(_))
        .ifSome(advancedEventSelectors)(_.advancedEventSelectors(_))
        .build

    def putEventSelectorsResponse(
      trailARN: Option[String] = None,
      eventSelectors: Option[List[EventSelector]] = None,
      advancedEventSelectors: Option[List[AdvancedEventSelector]] = None
    ): PutEventSelectorsResponse =
      PutEventSelectorsResponse
        .builder
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(eventSelectors)(_.eventSelectors(_))
        .ifSome(advancedEventSelectors)(_.advancedEventSelectors(_))
        .build

    def putInsightSelectorsRequest(
      trailName: Option[String] = None,
      insightSelectors: Option[List[InsightSelector]] = None
    ): PutInsightSelectorsRequest =
      PutInsightSelectorsRequest
        .builder
        .ifSome(trailName)(_.trailName(_))
        .ifSome(insightSelectors)(_.insightSelectors(_))
        .build

    def putInsightSelectorsResponse(
      trailARN: Option[String] = None,
      insightSelectors: Option[List[InsightSelector]] = None
    ): PutInsightSelectorsResponse =
      PutInsightSelectorsResponse
        .builder
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(insightSelectors)(_.insightSelectors(_))
        .build

    def removeTagsRequest(
      resourceId: Option[String] = None,
      tagsList: Option[List[Tag]] = None
    ): RemoveTagsRequest =
      RemoveTagsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagsList)(_.tagsList(_))
        .build

    def removeTagsResponse(

    ): RemoveTagsResponse =
      RemoveTagsResponse
        .builder

        .build

    def resource(
      resourceType: Option[String] = None,
      resourceName: Option[String] = None
    ): Resource =
      Resource
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourceTag(
      resourceId: Option[String] = None,
      tagsList: Option[List[Tag]] = None
    ): ResourceTag =
      ResourceTag
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagsList)(_.tagsList(_))
        .build

    def resourceTypeNotSupportedException(

    ): ResourceTypeNotSupportedException =
      ResourceTypeNotSupportedException
        .builder

        .build

    def s3BucketDoesNotExistException(

    ): S3BucketDoesNotExistException =
      S3BucketDoesNotExistException
        .builder

        .build

    def startLoggingRequest(
      name: Option[String] = None
    ): StartLoggingRequest =
      StartLoggingRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startLoggingResponse(

    ): StartLoggingResponse =
      StartLoggingResponse
        .builder

        .build

    def stopLoggingRequest(
      name: Option[String] = None
    ): StopLoggingRequest =
      StopLoggingRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopLoggingResponse(

    ): StopLoggingResponse =
      StopLoggingResponse
        .builder

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

    def tagsLimitExceededException(

    ): TagsLimitExceededException =
      TagsLimitExceededException
        .builder

        .build

    def trail(
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      snsTopicName: Option[String] = None,
      snsTopicARN: Option[String] = None,
      includeGlobalServiceEvents: Option[Boolean] = None,
      isMultiRegionTrail: Option[Boolean] = None,
      homeRegion: Option[String] = None,
      trailARN: Option[String] = None,
      logFileValidationEnabled: Option[Boolean] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      hasCustomEventSelectors: Option[Boolean] = None,
      hasInsightSelectors: Option[Boolean] = None,
      isOrganizationTrail: Option[Boolean] = None
    ): Trail =
      Trail
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(snsTopicName)(_.snsTopicName(_))
        .ifSome(snsTopicARN)(_.snsTopicARN(_))
        .ifSome(includeGlobalServiceEvents)(_.includeGlobalServiceEvents(_))
        .ifSome(isMultiRegionTrail)(_.isMultiRegionTrail(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(logFileValidationEnabled)(_.logFileValidationEnabled(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(hasCustomEventSelectors)(_.hasCustomEventSelectors(_))
        .ifSome(hasInsightSelectors)(_.hasInsightSelectors(_))
        .ifSome(isOrganizationTrail)(_.isOrganizationTrail(_))
        .build

    def trailAlreadyExistsException(

    ): TrailAlreadyExistsException =
      TrailAlreadyExistsException
        .builder

        .build

    def trailInfo(
      trailARN: Option[String] = None,
      name: Option[String] = None,
      homeRegion: Option[String] = None
    ): TrailInfo =
      TrailInfo
        .builder
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(name)(_.name(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .build

    def trailNotFoundException(

    ): TrailNotFoundException =
      TrailNotFoundException
        .builder

        .build

    def trailNotProvidedException(

    ): TrailNotProvidedException =
      TrailNotProvidedException
        .builder

        .build

    def unsupportedOperationException(

    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder

        .build

    def updateTrailRequest(
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      snsTopicName: Option[String] = None,
      includeGlobalServiceEvents: Option[Boolean] = None,
      isMultiRegionTrail: Option[Boolean] = None,
      enableLogFileValidation: Option[Boolean] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      isOrganizationTrail: Option[Boolean] = None
    ): UpdateTrailRequest =
      UpdateTrailRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(snsTopicName)(_.snsTopicName(_))
        .ifSome(includeGlobalServiceEvents)(_.includeGlobalServiceEvents(_))
        .ifSome(isMultiRegionTrail)(_.isMultiRegionTrail(_))
        .ifSome(enableLogFileValidation)(_.enableLogFileValidation(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(isOrganizationTrail)(_.isOrganizationTrail(_))
        .build

    def updateTrailResponse(
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      snsTopicName: Option[String] = None,
      snsTopicARN: Option[String] = None,
      includeGlobalServiceEvents: Option[Boolean] = None,
      isMultiRegionTrail: Option[Boolean] = None,
      trailARN: Option[String] = None,
      logFileValidationEnabled: Option[Boolean] = None,
      cloudWatchLogsLogGroupArn: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      kmsKeyId: Option[String] = None,
      isOrganizationTrail: Option[Boolean] = None
    ): UpdateTrailResponse =
      UpdateTrailResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(snsTopicName)(_.snsTopicName(_))
        .ifSome(snsTopicARN)(_.snsTopicARN(_))
        .ifSome(includeGlobalServiceEvents)(_.includeGlobalServiceEvents(_))
        .ifSome(isMultiRegionTrail)(_.isMultiRegionTrail(_))
        .ifSome(trailARN)(_.trailARN(_))
        .ifSome(logFileValidationEnabled)(_.logFileValidationEnabled(_))
        .ifSome(cloudWatchLogsLogGroupArn)(_.cloudWatchLogsLogGroupArn(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(isOrganizationTrail)(_.isOrganizationTrail(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
