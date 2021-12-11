package goober.hi

import goober.free.shield.ShieldIO
import software.amazon.awssdk.services.shield.model._


object shield {
  import goober.free.{shield ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accessDeniedForDependencyException(
      message: Option[String] = None
    ): AccessDeniedForDependencyException =
      AccessDeniedForDependencyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associateDRTLogBucketRequest(
      logBucket: Option[String] = None
    ): AssociateDRTLogBucketRequest =
      AssociateDRTLogBucketRequest
        .builder
        .ifSome(logBucket)(_.logBucket(_))
        .build

    def associateDRTLogBucketResponse(

    ): AssociateDRTLogBucketResponse =
      AssociateDRTLogBucketResponse
        .builder

        .build

    def associateDRTRoleRequest(
      roleArn: Option[String] = None
    ): AssociateDRTRoleRequest =
      AssociateDRTRoleRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def associateDRTRoleResponse(

    ): AssociateDRTRoleResponse =
      AssociateDRTRoleResponse
        .builder

        .build

    def associateHealthCheckRequest(
      protectionId: Option[String] = None,
      healthCheckArn: Option[String] = None
    ): AssociateHealthCheckRequest =
      AssociateHealthCheckRequest
        .builder
        .ifSome(protectionId)(_.protectionId(_))
        .ifSome(healthCheckArn)(_.healthCheckArn(_))
        .build

    def associateHealthCheckResponse(

    ): AssociateHealthCheckResponse =
      AssociateHealthCheckResponse
        .builder

        .build

    def associateProactiveEngagementDetailsRequest(
      emergencyContactList: Option[List[EmergencyContact]] = None
    ): AssociateProactiveEngagementDetailsRequest =
      AssociateProactiveEngagementDetailsRequest
        .builder
        .ifSome(emergencyContactList)(_.emergencyContactList(_))
        .build

    def associateProactiveEngagementDetailsResponse(

    ): AssociateProactiveEngagementDetailsResponse =
      AssociateProactiveEngagementDetailsResponse
        .builder

        .build

    def attackDetail(
      attackId: Option[String] = None,
      resourceArn: Option[String] = None,
      subResources: Option[List[SubResourceSummary]] = None,
      startTime: Option[AttackTimestamp] = None,
      endTime: Option[AttackTimestamp] = None,
      attackCounters: Option[List[SummarizedCounter]] = None,
      attackProperties: Option[List[AttackProperty]] = None,
      mitigations: Option[List[Mitigation]] = None
    ): AttackDetail =
      AttackDetail
        .builder
        .ifSome(attackId)(_.attackId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(subResources)(_.subResources(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(attackCounters)(_.attackCounters(_))
        .ifSome(attackProperties)(_.attackProperties(_))
        .ifSome(mitigations)(_.mitigations(_))
        .build

    def attackProperty(
      attackLayer: Option[String] = None,
      attackPropertyIdentifier: Option[String] = None,
      topContributors: Option[List[Contributor]] = None,
      unit: Option[String] = None,
      total: Option[Long] = None
    ): AttackProperty =
      AttackProperty
        .builder
        .ifSome(attackLayer)(_.attackLayer(_))
        .ifSome(attackPropertyIdentifier)(_.attackPropertyIdentifier(_))
        .ifSome(topContributors)(_.topContributors(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(total)(_.total(_))
        .build

    def attackStatisticsDataItem(
      attackVolume: Option[AttackVolume] = None,
      attackCount: Option[Long] = None
    ): AttackStatisticsDataItem =
      AttackStatisticsDataItem
        .builder
        .ifSome(attackVolume)(_.attackVolume(_))
        .ifSome(attackCount)(_.attackCount(_))
        .build

    def attackSummary(
      attackId: Option[String] = None,
      resourceArn: Option[String] = None,
      startTime: Option[AttackTimestamp] = None,
      endTime: Option[AttackTimestamp] = None,
      attackVectors: Option[List[AttackVectorDescription]] = None
    ): AttackSummary =
      AttackSummary
        .builder
        .ifSome(attackId)(_.attackId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(attackVectors)(_.attackVectors(_))
        .build

    def attackVectorDescription(
      vectorType: Option[String] = None
    ): AttackVectorDescription =
      AttackVectorDescription
        .builder
        .ifSome(vectorType)(_.vectorType(_))
        .build

    def attackVolume(
      bitsPerSecond: Option[AttackVolumeStatistics] = None,
      packetsPerSecond: Option[AttackVolumeStatistics] = None,
      requestsPerSecond: Option[AttackVolumeStatistics] = None
    ): AttackVolume =
      AttackVolume
        .builder
        .ifSome(bitsPerSecond)(_.bitsPerSecond(_))
        .ifSome(packetsPerSecond)(_.packetsPerSecond(_))
        .ifSome(requestsPerSecond)(_.requestsPerSecond(_))
        .build

    def attackVolumeStatistics(
      max: Option[Double] = None
    ): AttackVolumeStatistics =
      AttackVolumeStatistics
        .builder
        .ifSome(max)(_.max(_))
        .build

    def contributor(
      name: Option[String] = None,
      value: Option[Long] = None
    ): Contributor =
      Contributor
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def createProtectionGroupRequest(
      protectionGroupId: Option[String] = None,
      aggregation: Option[String] = None,
      pattern: Option[String] = None,
      resourceType: Option[String] = None,
      members: Option[List[ResourceArn]] = None,
      tags: Option[List[Tag]] = None
    ): CreateProtectionGroupRequest =
      CreateProtectionGroupRequest
        .builder
        .ifSome(protectionGroupId)(_.protectionGroupId(_))
        .ifSome(aggregation)(_.aggregation(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(members)(_.members(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProtectionGroupResponse(

    ): CreateProtectionGroupResponse =
      CreateProtectionGroupResponse
        .builder

        .build

    def createProtectionRequest(
      name: Option[String] = None,
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateProtectionRequest =
      CreateProtectionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProtectionResponse(
      protectionId: Option[String] = None
    ): CreateProtectionResponse =
      CreateProtectionResponse
        .builder
        .ifSome(protectionId)(_.protectionId(_))
        .build

    def createSubscriptionRequest(

    ): CreateSubscriptionRequest =
      CreateSubscriptionRequest
        .builder

        .build

    def createSubscriptionResponse(

    ): CreateSubscriptionResponse =
      CreateSubscriptionResponse
        .builder

        .build

    def deleteProtectionGroupRequest(
      protectionGroupId: Option[String] = None
    ): DeleteProtectionGroupRequest =
      DeleteProtectionGroupRequest
        .builder
        .ifSome(protectionGroupId)(_.protectionGroupId(_))
        .build

    def deleteProtectionGroupResponse(

    ): DeleteProtectionGroupResponse =
      DeleteProtectionGroupResponse
        .builder

        .build

    def deleteProtectionRequest(
      protectionId: Option[String] = None
    ): DeleteProtectionRequest =
      DeleteProtectionRequest
        .builder
        .ifSome(protectionId)(_.protectionId(_))
        .build

    def deleteProtectionResponse(

    ): DeleteProtectionResponse =
      DeleteProtectionResponse
        .builder

        .build

    def deleteSubscriptionRequest(

    ): DeleteSubscriptionRequest =
      DeleteSubscriptionRequest
        .builder

        .build

    def deleteSubscriptionResponse(

    ): DeleteSubscriptionResponse =
      DeleteSubscriptionResponse
        .builder

        .build

    def describeAttackRequest(
      attackId: Option[String] = None
    ): DescribeAttackRequest =
      DescribeAttackRequest
        .builder
        .ifSome(attackId)(_.attackId(_))
        .build

    def describeAttackResponse(
      attack: Option[AttackDetail] = None
    ): DescribeAttackResponse =
      DescribeAttackResponse
        .builder
        .ifSome(attack)(_.attack(_))
        .build

    def describeAttackStatisticsRequest(

    ): DescribeAttackStatisticsRequest =
      DescribeAttackStatisticsRequest
        .builder

        .build

    def describeAttackStatisticsResponse(
      timeRange: Option[TimeRange] = None,
      dataItems: Option[List[AttackStatisticsDataItem]] = None
    ): DescribeAttackStatisticsResponse =
      DescribeAttackStatisticsResponse
        .builder
        .ifSome(timeRange)(_.timeRange(_))
        .ifSome(dataItems)(_.dataItems(_))
        .build

    def describeDRTAccessRequest(

    ): DescribeDRTAccessRequest =
      DescribeDRTAccessRequest
        .builder

        .build

    def describeDRTAccessResponse(
      roleArn: Option[String] = None,
      logBucketList: Option[List[LogBucket]] = None
    ): DescribeDRTAccessResponse =
      DescribeDRTAccessResponse
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(logBucketList)(_.logBucketList(_))
        .build

    def describeEmergencyContactSettingsRequest(

    ): DescribeEmergencyContactSettingsRequest =
      DescribeEmergencyContactSettingsRequest
        .builder

        .build

    def describeEmergencyContactSettingsResponse(
      emergencyContactList: Option[List[EmergencyContact]] = None
    ): DescribeEmergencyContactSettingsResponse =
      DescribeEmergencyContactSettingsResponse
        .builder
        .ifSome(emergencyContactList)(_.emergencyContactList(_))
        .build

    def describeProtectionGroupRequest(
      protectionGroupId: Option[String] = None
    ): DescribeProtectionGroupRequest =
      DescribeProtectionGroupRequest
        .builder
        .ifSome(protectionGroupId)(_.protectionGroupId(_))
        .build

    def describeProtectionGroupResponse(
      protectionGroup: Option[ProtectionGroup] = None
    ): DescribeProtectionGroupResponse =
      DescribeProtectionGroupResponse
        .builder
        .ifSome(protectionGroup)(_.protectionGroup(_))
        .build

    def describeProtectionRequest(
      protectionId: Option[String] = None,
      resourceArn: Option[String] = None
    ): DescribeProtectionRequest =
      DescribeProtectionRequest
        .builder
        .ifSome(protectionId)(_.protectionId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeProtectionResponse(
      protection: Option[Protection] = None
    ): DescribeProtectionResponse =
      DescribeProtectionResponse
        .builder
        .ifSome(protection)(_.protection(_))
        .build

    def describeSubscriptionRequest(

    ): DescribeSubscriptionRequest =
      DescribeSubscriptionRequest
        .builder

        .build

    def describeSubscriptionResponse(
      subscription: Option[Subscription] = None
    ): DescribeSubscriptionResponse =
      DescribeSubscriptionResponse
        .builder
        .ifSome(subscription)(_.subscription(_))
        .build

    def disableProactiveEngagementRequest(

    ): DisableProactiveEngagementRequest =
      DisableProactiveEngagementRequest
        .builder

        .build

    def disableProactiveEngagementResponse(

    ): DisableProactiveEngagementResponse =
      DisableProactiveEngagementResponse
        .builder

        .build

    def disassociateDRTLogBucketRequest(
      logBucket: Option[String] = None
    ): DisassociateDRTLogBucketRequest =
      DisassociateDRTLogBucketRequest
        .builder
        .ifSome(logBucket)(_.logBucket(_))
        .build

    def disassociateDRTLogBucketResponse(

    ): DisassociateDRTLogBucketResponse =
      DisassociateDRTLogBucketResponse
        .builder

        .build

    def disassociateDRTRoleRequest(

    ): DisassociateDRTRoleRequest =
      DisassociateDRTRoleRequest
        .builder

        .build

    def disassociateDRTRoleResponse(

    ): DisassociateDRTRoleResponse =
      DisassociateDRTRoleResponse
        .builder

        .build

    def disassociateHealthCheckRequest(
      protectionId: Option[String] = None,
      healthCheckArn: Option[String] = None
    ): DisassociateHealthCheckRequest =
      DisassociateHealthCheckRequest
        .builder
        .ifSome(protectionId)(_.protectionId(_))
        .ifSome(healthCheckArn)(_.healthCheckArn(_))
        .build

    def disassociateHealthCheckResponse(

    ): DisassociateHealthCheckResponse =
      DisassociateHealthCheckResponse
        .builder

        .build

    def emergencyContact(
      emailAddress: Option[String] = None,
      phoneNumber: Option[String] = None,
      contactNotes: Option[String] = None
    ): EmergencyContact =
      EmergencyContact
        .builder
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(contactNotes)(_.contactNotes(_))
        .build

    def enableProactiveEngagementRequest(

    ): EnableProactiveEngagementRequest =
      EnableProactiveEngagementRequest
        .builder

        .build

    def enableProactiveEngagementResponse(

    ): EnableProactiveEngagementResponse =
      EnableProactiveEngagementResponse
        .builder

        .build

    def getSubscriptionStateRequest(

    ): GetSubscriptionStateRequest =
      GetSubscriptionStateRequest
        .builder

        .build

    def getSubscriptionStateResponse(
      subscriptionState: Option[String] = None
    ): GetSubscriptionStateResponse =
      GetSubscriptionStateResponse
        .builder
        .ifSome(subscriptionState)(_.subscriptionState(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOperationException(
      message: Option[String] = None
    ): InvalidOperationException =
      InvalidOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPaginationTokenException(
      message: Option[String] = None
    ): InvalidPaginationTokenException =
      InvalidPaginationTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
        .build

    def invalidResourceException(
      message: Option[String] = None
    ): InvalidResourceException =
      InvalidResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limit(
      `type`: Option[String] = None,
      max: Option[Long] = None
    ): Limit =
      Limit
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(max)(_.max(_))
        .build

    def limitsExceededException(
      message: Option[String] = None,
      `type`: Option[String] = None,
      limit: Option[LimitNumber] = None
    ): LimitsExceededException =
      LimitsExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listAttacksRequest(
      resourceArns: Option[List[ResourceArn]] = None,
      startTime: Option[TimeRange] = None,
      endTime: Option[TimeRange] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAttacksRequest =
      ListAttacksRequest
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAttacksResponse(
      attackSummaries: Option[List[AttackSummary]] = None,
      nextToken: Option[String] = None
    ): ListAttacksResponse =
      ListAttacksResponse
        .builder
        .ifSome(attackSummaries)(_.attackSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProtectionGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProtectionGroupsRequest =
      ListProtectionGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProtectionGroupsResponse(
      protectionGroups: Option[List[ProtectionGroup]] = None,
      nextToken: Option[String] = None
    ): ListProtectionGroupsResponse =
      ListProtectionGroupsResponse
        .builder
        .ifSome(protectionGroups)(_.protectionGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProtectionsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProtectionsRequest =
      ListProtectionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProtectionsResponse(
      protections: Option[List[Protection]] = None,
      nextToken: Option[String] = None
    ): ListProtectionsResponse =
      ListProtectionsResponse
        .builder
        .ifSome(protections)(_.protections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourcesInProtectionGroupRequest(
      protectionGroupId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourcesInProtectionGroupRequest =
      ListResourcesInProtectionGroupRequest
        .builder
        .ifSome(protectionGroupId)(_.protectionGroupId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourcesInProtectionGroupResponse(
      resourceArns: Option[List[ResourceArn]] = None,
      nextToken: Option[String] = None
    ): ListResourcesInProtectionGroupResponse =
      ListResourcesInProtectionGroupResponse
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def lockedSubscriptionException(
      message: Option[String] = None
    ): LockedSubscriptionException =
      LockedSubscriptionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def mitigation(
      mitigationName: Option[String] = None
    ): Mitigation =
      Mitigation
        .builder
        .ifSome(mitigationName)(_.mitigationName(_))
        .build

    def noAssociatedRoleException(
      message: Option[String] = None
    ): NoAssociatedRoleException =
      NoAssociatedRoleException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def optimisticLockException(
      message: Option[String] = None
    ): OptimisticLockException =
      OptimisticLockException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def protection(
      id: Option[String] = None,
      name: Option[String] = None,
      resourceArn: Option[String] = None,
      healthCheckIds: Option[List[HealthCheckId]] = None,
      protectionArn: Option[String] = None
    ): Protection =
      Protection
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(healthCheckIds)(_.healthCheckIds(_))
        .ifSome(protectionArn)(_.protectionArn(_))
        .build

    def protectionGroup(
      protectionGroupId: Option[String] = None,
      aggregation: Option[String] = None,
      pattern: Option[String] = None,
      resourceType: Option[String] = None,
      members: Option[List[ResourceArn]] = None,
      protectionGroupArn: Option[String] = None
    ): ProtectionGroup =
      ProtectionGroup
        .builder
        .ifSome(protectionGroupId)(_.protectionGroupId(_))
        .ifSome(aggregation)(_.aggregation(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(members)(_.members(_))
        .ifSome(protectionGroupArn)(_.protectionGroupArn(_))
        .build

    def protectionGroupArbitraryPatternLimits(
      maxMembers: Option[Long] = None
    ): ProtectionGroupArbitraryPatternLimits =
      ProtectionGroupArbitraryPatternLimits
        .builder
        .ifSome(maxMembers)(_.maxMembers(_))
        .build

    def protectionGroupLimits(
      maxProtectionGroups: Option[Long] = None,
      patternTypeLimits: Option[ProtectionGroupPatternTypeLimits] = None
    ): ProtectionGroupLimits =
      ProtectionGroupLimits
        .builder
        .ifSome(maxProtectionGroups)(_.maxProtectionGroups(_))
        .ifSome(patternTypeLimits)(_.patternTypeLimits(_))
        .build

    def protectionGroupPatternTypeLimits(
      arbitraryPatternLimits: Option[ProtectionGroupArbitraryPatternLimits] = None
    ): ProtectionGroupPatternTypeLimits =
      ProtectionGroupPatternTypeLimits
        .builder
        .ifSome(arbitraryPatternLimits)(_.arbitraryPatternLimits(_))
        .build

    def protectionLimits(
      protectedResourceTypeLimits: Option[List[Limit]] = None
    ): ProtectionLimits =
      ProtectionLimits
        .builder
        .ifSome(protectedResourceTypeLimits)(_.protectedResourceTypeLimits(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def subResourceSummary(
      `type`: Option[String] = None,
      id: Option[String] = None,
      attackVectors: Option[List[SummarizedAttackVector]] = None,
      counters: Option[List[SummarizedCounter]] = None
    ): SubResourceSummary =
      SubResourceSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(attackVectors)(_.attackVectors(_))
        .ifSome(counters)(_.counters(_))
        .build

    def subscription(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      timeCommitmentInSeconds: Option[DurationInSeconds] = None,
      autoRenew: Option[String] = None,
      limits: Option[List[Limit]] = None,
      proactiveEngagementStatus: Option[String] = None,
      subscriptionLimits: Option[SubscriptionLimits] = None,
      subscriptionArn: Option[String] = None
    ): Subscription =
      Subscription
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(timeCommitmentInSeconds)(_.timeCommitmentInSeconds(_))
        .ifSome(autoRenew)(_.autoRenew(_))
        .ifSome(limits)(_.limits(_))
        .ifSome(proactiveEngagementStatus)(_.proactiveEngagementStatus(_))
        .ifSome(subscriptionLimits)(_.subscriptionLimits(_))
        .ifSome(subscriptionArn)(_.subscriptionArn(_))
        .build

    def subscriptionLimits(
      protectionLimits: Option[ProtectionLimits] = None,
      protectionGroupLimits: Option[ProtectionGroupLimits] = None
    ): SubscriptionLimits =
      SubscriptionLimits
        .builder
        .ifSome(protectionLimits)(_.protectionLimits(_))
        .ifSome(protectionGroupLimits)(_.protectionGroupLimits(_))
        .build

    def summarizedAttackVector(
      vectorType: Option[String] = None,
      vectorCounters: Option[List[SummarizedCounter]] = None
    ): SummarizedAttackVector =
      SummarizedAttackVector
        .builder
        .ifSome(vectorType)(_.vectorType(_))
        .ifSome(vectorCounters)(_.vectorCounters(_))
        .build

    def summarizedCounter(
      name: Option[String] = None,
      max: Option[Double] = None,
      average: Option[Double] = None,
      sum: Option[Double] = None,
      n: Option[Int] = None,
      unit: Option[String] = None
    ): SummarizedCounter =
      SummarizedCounter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(max)(_.max(_))
        .ifSome(average)(_.average(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(n)(_.n(_))
        .ifSome(unit)(_.unit(_))
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

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def timeRange(
      fromInclusive: Option[AttackTimestamp] = None,
      toExclusive: Option[AttackTimestamp] = None
    ): TimeRange =
      TimeRange
        .builder
        .ifSome(fromInclusive)(_.fromInclusive(_))
        .ifSome(toExclusive)(_.toExclusive(_))
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

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateEmergencyContactSettingsRequest(
      emergencyContactList: Option[List[EmergencyContact]] = None
    ): UpdateEmergencyContactSettingsRequest =
      UpdateEmergencyContactSettingsRequest
        .builder
        .ifSome(emergencyContactList)(_.emergencyContactList(_))
        .build

    def updateEmergencyContactSettingsResponse(

    ): UpdateEmergencyContactSettingsResponse =
      UpdateEmergencyContactSettingsResponse
        .builder

        .build

    def updateProtectionGroupRequest(
      protectionGroupId: Option[String] = None,
      aggregation: Option[String] = None,
      pattern: Option[String] = None,
      resourceType: Option[String] = None,
      members: Option[List[ResourceArn]] = None
    ): UpdateProtectionGroupRequest =
      UpdateProtectionGroupRequest
        .builder
        .ifSome(protectionGroupId)(_.protectionGroupId(_))
        .ifSome(aggregation)(_.aggregation(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(members)(_.members(_))
        .build

    def updateProtectionGroupResponse(

    ): UpdateProtectionGroupResponse =
      UpdateProtectionGroupResponse
        .builder

        .build

    def updateSubscriptionRequest(
      autoRenew: Option[String] = None
    ): UpdateSubscriptionRequest =
      UpdateSubscriptionRequest
        .builder
        .ifSome(autoRenew)(_.autoRenew(_))
        .build

    def updateSubscriptionResponse(

    ): UpdateSubscriptionResponse =
      UpdateSubscriptionResponse
        .builder

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
