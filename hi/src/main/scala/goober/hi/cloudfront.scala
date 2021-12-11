package goober.hi

import goober.free.cloudfront.CloudFrontIO
import software.amazon.awssdk.services.cloudfront.model._


object cloudfront {
  import goober.free.{cloudfront ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDenied(
      message: Option[String] = None
    ): AccessDenied =
      AccessDenied
        .builder
        .ifSome(message)(_.message(_))
        .build

    def activeTrustedKeyGroups(
      enabled: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[KGKeyPairIds]] = None
    ): ActiveTrustedKeyGroups =
      ActiveTrustedKeyGroups
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def activeTrustedSigners(
      enabled: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[Signer]] = None
    ): ActiveTrustedSigners =
      ActiveTrustedSigners
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def aliasICPRecordal(
      cNAME: Option[String] = None,
      iCPRecordalStatus: Option[String] = None
    ): AliasICPRecordal =
      AliasICPRecordal
        .builder
        .ifSome(cNAME)(_.cNAME(_))
        .ifSome(iCPRecordalStatus)(_.iCPRecordalStatus(_))
        .build

    def aliases(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): Aliases =
      Aliases
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def allowedMethods(
      quantity: Option[Int] = None,
      items: Option[List[Method]] = None,
      cachedMethods: Option[CachedMethods] = None
    ): AllowedMethods =
      AllowedMethods
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .ifSome(cachedMethods)(_.cachedMethods(_))
        .build

    def batchTooLarge(
      message: Option[String] = None
    ): BatchTooLarge =
      BatchTooLarge
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cNAMEAlreadyExists(
      message: Option[String] = None
    ): CNAMEAlreadyExists =
      CNAMEAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cacheBehavior(
      pathPattern: Option[String] = None,
      targetOriginId: Option[String] = None,
      trustedSigners: Option[TrustedSigners] = None,
      trustedKeyGroups: Option[TrustedKeyGroups] = None,
      viewerProtocolPolicy: Option[String] = None,
      allowedMethods: Option[AllowedMethods] = None,
      smoothStreaming: Option[Boolean] = None,
      compress: Option[Boolean] = None,
      lambdaFunctionAssociations: Option[LambdaFunctionAssociations] = None,
      functionAssociations: Option[FunctionAssociations] = None,
      fieldLevelEncryptionId: Option[String] = None,
      realtimeLogConfigArn: Option[String] = None,
      cachePolicyId: Option[String] = None,
      originRequestPolicyId: Option[String] = None,
      forwardedValues: Option[ForwardedValues] = None,
      minTTL: Option[long] = None,
      defaultTTL: Option[long] = None,
      maxTTL: Option[long] = None
    ): CacheBehavior =
      CacheBehavior
        .builder
        .ifSome(pathPattern)(_.pathPattern(_))
        .ifSome(targetOriginId)(_.targetOriginId(_))
        .ifSome(trustedSigners)(_.trustedSigners(_))
        .ifSome(trustedKeyGroups)(_.trustedKeyGroups(_))
        .ifSome(viewerProtocolPolicy)(_.viewerProtocolPolicy(_))
        .ifSome(allowedMethods)(_.allowedMethods(_))
        .ifSome(smoothStreaming)(_.smoothStreaming(_))
        .ifSome(compress)(_.compress(_))
        .ifSome(lambdaFunctionAssociations)(_.lambdaFunctionAssociations(_))
        .ifSome(functionAssociations)(_.functionAssociations(_))
        .ifSome(fieldLevelEncryptionId)(_.fieldLevelEncryptionId(_))
        .ifSome(realtimeLogConfigArn)(_.realtimeLogConfigArn(_))
        .ifSome(cachePolicyId)(_.cachePolicyId(_))
        .ifSome(originRequestPolicyId)(_.originRequestPolicyId(_))
        .ifSome(forwardedValues)(_.forwardedValues(_))
        .ifSome(minTTL)(_.minTTL(_))
        .ifSome(defaultTTL)(_.defaultTTL(_))
        .ifSome(maxTTL)(_.maxTTL(_))
        .build

    def cacheBehaviors(
      quantity: Option[Int] = None,
      items: Option[List[CacheBehavior]] = None
    ): CacheBehaviors =
      CacheBehaviors
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def cachePolicy(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      cachePolicyConfig: Option[CachePolicyConfig] = None
    ): CachePolicy =
      CachePolicy
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(cachePolicyConfig)(_.cachePolicyConfig(_))
        .build

    def cachePolicyAlreadyExists(
      message: Option[String] = None
    ): CachePolicyAlreadyExists =
      CachePolicyAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cachePolicyConfig(
      comment: Option[String] = None,
      name: Option[String] = None,
      defaultTTL: Option[long] = None,
      maxTTL: Option[long] = None,
      minTTL: Option[long] = None,
      parametersInCacheKeyAndForwardedToOrigin: Option[ParametersInCacheKeyAndForwardedToOrigin] = None
    ): CachePolicyConfig =
      CachePolicyConfig
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(name)(_.name(_))
        .ifSome(defaultTTL)(_.defaultTTL(_))
        .ifSome(maxTTL)(_.maxTTL(_))
        .ifSome(minTTL)(_.minTTL(_))
        .ifSome(parametersInCacheKeyAndForwardedToOrigin)(_.parametersInCacheKeyAndForwardedToOrigin(_))
        .build

    def cachePolicyCookiesConfig(
      cookieBehavior: Option[String] = None,
      cookies: Option[CookieNames] = None
    ): CachePolicyCookiesConfig =
      CachePolicyCookiesConfig
        .builder
        .ifSome(cookieBehavior)(_.cookieBehavior(_))
        .ifSome(cookies)(_.cookies(_))
        .build

    def cachePolicyHeadersConfig(
      headerBehavior: Option[String] = None,
      headers: Option[Headers] = None
    ): CachePolicyHeadersConfig =
      CachePolicyHeadersConfig
        .builder
        .ifSome(headerBehavior)(_.headerBehavior(_))
        .ifSome(headers)(_.headers(_))
        .build

    def cachePolicyInUse(
      message: Option[String] = None
    ): CachePolicyInUse =
      CachePolicyInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cachePolicyList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[CachePolicySummary]] = None
    ): CachePolicyList =
      CachePolicyList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def cachePolicyQueryStringsConfig(
      queryStringBehavior: Option[String] = None,
      queryStrings: Option[QueryStringNames] = None
    ): CachePolicyQueryStringsConfig =
      CachePolicyQueryStringsConfig
        .builder
        .ifSome(queryStringBehavior)(_.queryStringBehavior(_))
        .ifSome(queryStrings)(_.queryStrings(_))
        .build

    def cachePolicySummary(
      `type`: Option[String] = None,
      cachePolicy: Option[CachePolicy] = None
    ): CachePolicySummary =
      CachePolicySummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(cachePolicy)(_.cachePolicy(_))
        .build

    def cachedMethods(
      quantity: Option[Int] = None,
      items: Option[List[Method]] = None
    ): CachedMethods =
      CachedMethods
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def cannotChangeImmutablePublicKeyFields(
      message: Option[String] = None
    ): CannotChangeImmutablePublicKeyFields =
      CannotChangeImmutablePublicKeyFields
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudFrontOriginAccessIdentity(
      id: Option[String] = None,
      s3CanonicalUserId: Option[String] = None,
      cloudFrontOriginAccessIdentityConfig: Option[CloudFrontOriginAccessIdentityConfig] = None
    ): CloudFrontOriginAccessIdentity =
      CloudFrontOriginAccessIdentity
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(s3CanonicalUserId)(_.s3CanonicalUserId(_))
        .ifSome(cloudFrontOriginAccessIdentityConfig)(_.cloudFrontOriginAccessIdentityConfig(_))
        .build

    def cloudFrontOriginAccessIdentityAlreadyExists(
      message: Option[String] = None
    ): CloudFrontOriginAccessIdentityAlreadyExists =
      CloudFrontOriginAccessIdentityAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudFrontOriginAccessIdentityConfig(
      callerReference: Option[String] = None,
      comment: Option[String] = None
    ): CloudFrontOriginAccessIdentityConfig =
      CloudFrontOriginAccessIdentityConfig
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(comment)(_.comment(_))
        .build

    def cloudFrontOriginAccessIdentityInUse(
      message: Option[String] = None
    ): CloudFrontOriginAccessIdentityInUse =
      CloudFrontOriginAccessIdentityInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudFrontOriginAccessIdentityList(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[CloudFrontOriginAccessIdentitySummary]] = None
    ): CloudFrontOriginAccessIdentityList =
      CloudFrontOriginAccessIdentityList
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def cloudFrontOriginAccessIdentitySummary(
      id: Option[String] = None,
      s3CanonicalUserId: Option[String] = None,
      comment: Option[String] = None
    ): CloudFrontOriginAccessIdentitySummary =
      CloudFrontOriginAccessIdentitySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(s3CanonicalUserId)(_.s3CanonicalUserId(_))
        .ifSome(comment)(_.comment(_))
        .build

    def contentTypeProfile(
      format: Option[String] = None,
      profileId: Option[String] = None,
      contentType: Option[String] = None
    ): ContentTypeProfile =
      ContentTypeProfile
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(profileId)(_.profileId(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def contentTypeProfileConfig(
      forwardWhenContentTypeIsUnknown: Option[Boolean] = None,
      contentTypeProfiles: Option[ContentTypeProfiles] = None
    ): ContentTypeProfileConfig =
      ContentTypeProfileConfig
        .builder
        .ifSome(forwardWhenContentTypeIsUnknown)(_.forwardWhenContentTypeIsUnknown(_))
        .ifSome(contentTypeProfiles)(_.contentTypeProfiles(_))
        .build

    def contentTypeProfiles(
      quantity: Option[Int] = None,
      items: Option[List[ContentTypeProfile]] = None
    ): ContentTypeProfiles =
      ContentTypeProfiles
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def cookieNames(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): CookieNames =
      CookieNames
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def cookiePreference(
      forward: Option[String] = None,
      whitelistedNames: Option[CookieNames] = None
    ): CookiePreference =
      CookiePreference
        .builder
        .ifSome(forward)(_.forward(_))
        .ifSome(whitelistedNames)(_.whitelistedNames(_))
        .build

    def createCachePolicyRequest(
      cachePolicyConfig: Option[CachePolicyConfig] = None
    ): CreateCachePolicyRequest =
      CreateCachePolicyRequest
        .builder
        .ifSome(cachePolicyConfig)(_.cachePolicyConfig(_))
        .build

    def createCloudFrontOriginAccessIdentityRequest(
      cloudFrontOriginAccessIdentityConfig: Option[CloudFrontOriginAccessIdentityConfig] = None
    ): CreateCloudFrontOriginAccessIdentityRequest =
      CreateCloudFrontOriginAccessIdentityRequest
        .builder
        .ifSome(cloudFrontOriginAccessIdentityConfig)(_.cloudFrontOriginAccessIdentityConfig(_))
        .build

    def createDistributionRequest(
      distributionConfig: Option[DistributionConfig] = None
    ): CreateDistributionRequest =
      CreateDistributionRequest
        .builder
        .ifSome(distributionConfig)(_.distributionConfig(_))
        .build

    def createDistributionWithTagsRequest(
      distributionConfigWithTags: Option[DistributionConfigWithTags] = None
    ): CreateDistributionWithTagsRequest =
      CreateDistributionWithTagsRequest
        .builder
        .ifSome(distributionConfigWithTags)(_.distributionConfigWithTags(_))
        .build

    def createFieldLevelEncryptionConfigRequest(
      fieldLevelEncryptionConfig: Option[FieldLevelEncryptionConfig] = None
    ): CreateFieldLevelEncryptionConfigRequest =
      CreateFieldLevelEncryptionConfigRequest
        .builder
        .ifSome(fieldLevelEncryptionConfig)(_.fieldLevelEncryptionConfig(_))
        .build

    def createFieldLevelEncryptionProfileRequest(
      fieldLevelEncryptionProfileConfig: Option[FieldLevelEncryptionProfileConfig] = None
    ): CreateFieldLevelEncryptionProfileRequest =
      CreateFieldLevelEncryptionProfileRequest
        .builder
        .ifSome(fieldLevelEncryptionProfileConfig)(_.fieldLevelEncryptionProfileConfig(_))
        .build

    def createFunctionRequest(
      name: Option[String] = None,
      functionConfig: Option[FunctionConfig] = None,
      functionCode: Option[FunctionBlob] = None
    ): CreateFunctionRequest =
      CreateFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(functionConfig)(_.functionConfig(_))
        .ifSome(functionCode)(_.functionCode(_))
        .build

    def createInvalidationRequest(
      distributionId: Option[String] = None,
      invalidationBatch: Option[InvalidationBatch] = None
    ): CreateInvalidationRequest =
      CreateInvalidationRequest
        .builder
        .ifSome(distributionId)(_.distributionId(_))
        .ifSome(invalidationBatch)(_.invalidationBatch(_))
        .build

    def createKeyGroupRequest(
      keyGroupConfig: Option[KeyGroupConfig] = None
    ): CreateKeyGroupRequest =
      CreateKeyGroupRequest
        .builder
        .ifSome(keyGroupConfig)(_.keyGroupConfig(_))
        .build

    def createMonitoringSubscriptionRequest(
      distributionId: Option[String] = None,
      monitoringSubscription: Option[MonitoringSubscription] = None
    ): CreateMonitoringSubscriptionRequest =
      CreateMonitoringSubscriptionRequest
        .builder
        .ifSome(distributionId)(_.distributionId(_))
        .ifSome(monitoringSubscription)(_.monitoringSubscription(_))
        .build

    def createOriginRequestPolicyRequest(
      originRequestPolicyConfig: Option[OriginRequestPolicyConfig] = None
    ): CreateOriginRequestPolicyRequest =
      CreateOriginRequestPolicyRequest
        .builder
        .ifSome(originRequestPolicyConfig)(_.originRequestPolicyConfig(_))
        .build

    def createPublicKeyRequest(
      publicKeyConfig: Option[PublicKeyConfig] = None
    ): CreatePublicKeyRequest =
      CreatePublicKeyRequest
        .builder
        .ifSome(publicKeyConfig)(_.publicKeyConfig(_))
        .build

    def createRealtimeLogConfigRequest(
      endPoints: Option[List[EndPoint]] = None,
      fields: Option[List[string]] = None,
      name: Option[String] = None,
      samplingRate: Option[long] = None
    ): CreateRealtimeLogConfigRequest =
      CreateRealtimeLogConfigRequest
        .builder
        .ifSome(endPoints)(_.endPoints(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(name)(_.name(_))
        .ifSome(samplingRate)(_.samplingRate(_))
        .build

    def createStreamingDistributionRequest(
      streamingDistributionConfig: Option[StreamingDistributionConfig] = None
    ): CreateStreamingDistributionRequest =
      CreateStreamingDistributionRequest
        .builder
        .ifSome(streamingDistributionConfig)(_.streamingDistributionConfig(_))
        .build

    def createStreamingDistributionWithTagsRequest(
      streamingDistributionConfigWithTags: Option[StreamingDistributionConfigWithTags] = None
    ): CreateStreamingDistributionWithTagsRequest =
      CreateStreamingDistributionWithTagsRequest
        .builder
        .ifSome(streamingDistributionConfigWithTags)(_.streamingDistributionConfigWithTags(_))
        .build

    def customErrorResponse(
      errorCode: Option[Int] = None,
      responsePagePath: Option[String] = None,
      responseCode: Option[String] = None,
      errorCachingMinTTL: Option[long] = None
    ): CustomErrorResponse =
      CustomErrorResponse
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(responsePagePath)(_.responsePagePath(_))
        .ifSome(responseCode)(_.responseCode(_))
        .ifSome(errorCachingMinTTL)(_.errorCachingMinTTL(_))
        .build

    def customErrorResponses(
      quantity: Option[Int] = None,
      items: Option[List[CustomErrorResponse]] = None
    ): CustomErrorResponses =
      CustomErrorResponses
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def customHeaders(
      quantity: Option[Int] = None,
      items: Option[List[OriginCustomHeader]] = None
    ): CustomHeaders =
      CustomHeaders
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def customOriginConfig(
      hTTPPort: Option[Int] = None,
      hTTPSPort: Option[Int] = None,
      originProtocolPolicy: Option[String] = None,
      originSslProtocols: Option[OriginSslProtocols] = None,
      originReadTimeout: Option[Int] = None,
      originKeepaliveTimeout: Option[Int] = None
    ): CustomOriginConfig =
      CustomOriginConfig
        .builder
        .ifSome(hTTPPort)(_.hTTPPort(_))
        .ifSome(hTTPSPort)(_.hTTPSPort(_))
        .ifSome(originProtocolPolicy)(_.originProtocolPolicy(_))
        .ifSome(originSslProtocols)(_.originSslProtocols(_))
        .ifSome(originReadTimeout)(_.originReadTimeout(_))
        .ifSome(originKeepaliveTimeout)(_.originKeepaliveTimeout(_))
        .build

    def defaultCacheBehavior(
      targetOriginId: Option[String] = None,
      trustedSigners: Option[TrustedSigners] = None,
      trustedKeyGroups: Option[TrustedKeyGroups] = None,
      viewerProtocolPolicy: Option[String] = None,
      allowedMethods: Option[AllowedMethods] = None,
      smoothStreaming: Option[Boolean] = None,
      compress: Option[Boolean] = None,
      lambdaFunctionAssociations: Option[LambdaFunctionAssociations] = None,
      functionAssociations: Option[FunctionAssociations] = None,
      fieldLevelEncryptionId: Option[String] = None,
      realtimeLogConfigArn: Option[String] = None,
      cachePolicyId: Option[String] = None,
      originRequestPolicyId: Option[String] = None,
      forwardedValues: Option[ForwardedValues] = None,
      minTTL: Option[long] = None,
      defaultTTL: Option[long] = None,
      maxTTL: Option[long] = None
    ): DefaultCacheBehavior =
      DefaultCacheBehavior
        .builder
        .ifSome(targetOriginId)(_.targetOriginId(_))
        .ifSome(trustedSigners)(_.trustedSigners(_))
        .ifSome(trustedKeyGroups)(_.trustedKeyGroups(_))
        .ifSome(viewerProtocolPolicy)(_.viewerProtocolPolicy(_))
        .ifSome(allowedMethods)(_.allowedMethods(_))
        .ifSome(smoothStreaming)(_.smoothStreaming(_))
        .ifSome(compress)(_.compress(_))
        .ifSome(lambdaFunctionAssociations)(_.lambdaFunctionAssociations(_))
        .ifSome(functionAssociations)(_.functionAssociations(_))
        .ifSome(fieldLevelEncryptionId)(_.fieldLevelEncryptionId(_))
        .ifSome(realtimeLogConfigArn)(_.realtimeLogConfigArn(_))
        .ifSome(cachePolicyId)(_.cachePolicyId(_))
        .ifSome(originRequestPolicyId)(_.originRequestPolicyId(_))
        .ifSome(forwardedValues)(_.forwardedValues(_))
        .ifSome(minTTL)(_.minTTL(_))
        .ifSome(defaultTTL)(_.defaultTTL(_))
        .ifSome(maxTTL)(_.maxTTL(_))
        .build

    def deleteCachePolicyRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteCachePolicyRequest =
      DeleteCachePolicyRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteCloudFrontOriginAccessIdentityRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteCloudFrontOriginAccessIdentityRequest =
      DeleteCloudFrontOriginAccessIdentityRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteDistributionRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteDistributionRequest =
      DeleteDistributionRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteFieldLevelEncryptionConfigRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteFieldLevelEncryptionConfigRequest =
      DeleteFieldLevelEncryptionConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteFieldLevelEncryptionProfileRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteFieldLevelEncryptionProfileRequest =
      DeleteFieldLevelEncryptionProfileRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteFunctionRequest(
      name: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteFunctionRequest =
      DeleteFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteKeyGroupRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteKeyGroupRequest =
      DeleteKeyGroupRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteMonitoringSubscriptionRequest(
      distributionId: Option[String] = None
    ): DeleteMonitoringSubscriptionRequest =
      DeleteMonitoringSubscriptionRequest
        .builder
        .ifSome(distributionId)(_.distributionId(_))
        .build

    def deleteOriginRequestPolicyRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteOriginRequestPolicyRequest =
      DeleteOriginRequestPolicyRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deletePublicKeyRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeletePublicKeyRequest =
      DeletePublicKeyRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def deleteRealtimeLogConfigRequest(
      name: Option[String] = None,
      aRN: Option[String] = None
    ): DeleteRealtimeLogConfigRequest =
      DeleteRealtimeLogConfigRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def deleteStreamingDistributionRequest(
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): DeleteStreamingDistributionRequest =
      DeleteStreamingDistributionRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def describeFunctionRequest(
      name: Option[String] = None,
      stage: Option[String] = None
    ): DescribeFunctionRequest =
      DescribeFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(stage)(_.stage(_))
        .build

    def distribution(
      id: Option[String] = None,
      aRN: Option[String] = None,
      status: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      inProgressInvalidationBatches: Option[Int] = None,
      domainName: Option[String] = None,
      activeTrustedSigners: Option[ActiveTrustedSigners] = None,
      activeTrustedKeyGroups: Option[ActiveTrustedKeyGroups] = None,
      distributionConfig: Option[DistributionConfig] = None,
      aliasICPRecordals: Option[List[AliasICPRecordal]] = None
    ): Distribution =
      Distribution
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(inProgressInvalidationBatches)(_.inProgressInvalidationBatches(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(activeTrustedSigners)(_.activeTrustedSigners(_))
        .ifSome(activeTrustedKeyGroups)(_.activeTrustedKeyGroups(_))
        .ifSome(distributionConfig)(_.distributionConfig(_))
        .ifSome(aliasICPRecordals)(_.aliasICPRecordals(_))
        .build

    def distributionAlreadyExists(
      message: Option[String] = None
    ): DistributionAlreadyExists =
      DistributionAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def distributionConfig(
      callerReference: Option[String] = None,
      aliases: Option[Aliases] = None,
      defaultRootObject: Option[String] = None,
      origins: Option[Origins] = None,
      originGroups: Option[OriginGroups] = None,
      defaultCacheBehavior: Option[DefaultCacheBehavior] = None,
      cacheBehaviors: Option[CacheBehaviors] = None,
      customErrorResponses: Option[CustomErrorResponses] = None,
      comment: Option[String] = None,
      logging: Option[LoggingConfig] = None,
      priceClass: Option[String] = None,
      enabled: Option[Boolean] = None,
      viewerCertificate: Option[ViewerCertificate] = None,
      restrictions: Option[Restrictions] = None,
      webACLId: Option[String] = None,
      httpVersion: Option[String] = None,
      isIPV6Enabled: Option[Boolean] = None
    ): DistributionConfig =
      DistributionConfig
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(aliases)(_.aliases(_))
        .ifSome(defaultRootObject)(_.defaultRootObject(_))
        .ifSome(origins)(_.origins(_))
        .ifSome(originGroups)(_.originGroups(_))
        .ifSome(defaultCacheBehavior)(_.defaultCacheBehavior(_))
        .ifSome(cacheBehaviors)(_.cacheBehaviors(_))
        .ifSome(customErrorResponses)(_.customErrorResponses(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(priceClass)(_.priceClass(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(viewerCertificate)(_.viewerCertificate(_))
        .ifSome(restrictions)(_.restrictions(_))
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(httpVersion)(_.httpVersion(_))
        .ifSome(isIPV6Enabled)(_.isIPV6Enabled(_))
        .build

    def distributionConfigWithTags(
      distributionConfig: Option[DistributionConfig] = None,
      tags: Option[Tags] = None
    ): DistributionConfigWithTags =
      DistributionConfigWithTags
        .builder
        .ifSome(distributionConfig)(_.distributionConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def distributionIdList(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): DistributionIdList =
      DistributionIdList
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def distributionList(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[DistributionSummary]] = None
    ): DistributionList =
      DistributionList
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def distributionNotDisabled(
      message: Option[String] = None
    ): DistributionNotDisabled =
      DistributionNotDisabled
        .builder
        .ifSome(message)(_.message(_))
        .build

    def distributionSummary(
      id: Option[String] = None,
      aRN: Option[String] = None,
      status: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      domainName: Option[String] = None,
      aliases: Option[Aliases] = None,
      origins: Option[Origins] = None,
      originGroups: Option[OriginGroups] = None,
      defaultCacheBehavior: Option[DefaultCacheBehavior] = None,
      cacheBehaviors: Option[CacheBehaviors] = None,
      customErrorResponses: Option[CustomErrorResponses] = None,
      comment: Option[String] = None,
      priceClass: Option[String] = None,
      enabled: Option[Boolean] = None,
      viewerCertificate: Option[ViewerCertificate] = None,
      restrictions: Option[Restrictions] = None,
      webACLId: Option[String] = None,
      httpVersion: Option[String] = None,
      isIPV6Enabled: Option[Boolean] = None,
      aliasICPRecordals: Option[List[AliasICPRecordal]] = None
    ): DistributionSummary =
      DistributionSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(aliases)(_.aliases(_))
        .ifSome(origins)(_.origins(_))
        .ifSome(originGroups)(_.originGroups(_))
        .ifSome(defaultCacheBehavior)(_.defaultCacheBehavior(_))
        .ifSome(cacheBehaviors)(_.cacheBehaviors(_))
        .ifSome(customErrorResponses)(_.customErrorResponses(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(priceClass)(_.priceClass(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(viewerCertificate)(_.viewerCertificate(_))
        .ifSome(restrictions)(_.restrictions(_))
        .ifSome(webACLId)(_.webACLId(_))
        .ifSome(httpVersion)(_.httpVersion(_))
        .ifSome(isIPV6Enabled)(_.isIPV6Enabled(_))
        .ifSome(aliasICPRecordals)(_.aliasICPRecordals(_))
        .build

    def encryptionEntities(
      quantity: Option[Int] = None,
      items: Option[List[EncryptionEntity]] = None
    ): EncryptionEntities =
      EncryptionEntities
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def encryptionEntity(
      publicKeyId: Option[String] = None,
      providerId: Option[String] = None,
      fieldPatterns: Option[FieldPatterns] = None
    ): EncryptionEntity =
      EncryptionEntity
        .builder
        .ifSome(publicKeyId)(_.publicKeyId(_))
        .ifSome(providerId)(_.providerId(_))
        .ifSome(fieldPatterns)(_.fieldPatterns(_))
        .build

    def endPoint(
      streamType: Option[String] = None,
      kinesisStreamConfig: Option[KinesisStreamConfig] = None
    ): EndPoint =
      EndPoint
        .builder
        .ifSome(streamType)(_.streamType(_))
        .ifSome(kinesisStreamConfig)(_.kinesisStreamConfig(_))
        .build

    def fieldLevelEncryption(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      fieldLevelEncryptionConfig: Option[FieldLevelEncryptionConfig] = None
    ): FieldLevelEncryption =
      FieldLevelEncryption
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(fieldLevelEncryptionConfig)(_.fieldLevelEncryptionConfig(_))
        .build

    def fieldLevelEncryptionConfig(
      callerReference: Option[String] = None,
      comment: Option[String] = None,
      queryArgProfileConfig: Option[QueryArgProfileConfig] = None,
      contentTypeProfileConfig: Option[ContentTypeProfileConfig] = None
    ): FieldLevelEncryptionConfig =
      FieldLevelEncryptionConfig
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(queryArgProfileConfig)(_.queryArgProfileConfig(_))
        .ifSome(contentTypeProfileConfig)(_.contentTypeProfileConfig(_))
        .build

    def fieldLevelEncryptionConfigAlreadyExists(
      message: Option[String] = None
    ): FieldLevelEncryptionConfigAlreadyExists =
      FieldLevelEncryptionConfigAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fieldLevelEncryptionConfigInUse(
      message: Option[String] = None
    ): FieldLevelEncryptionConfigInUse =
      FieldLevelEncryptionConfigInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fieldLevelEncryptionList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[FieldLevelEncryptionSummary]] = None
    ): FieldLevelEncryptionList =
      FieldLevelEncryptionList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def fieldLevelEncryptionProfile(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      fieldLevelEncryptionProfileConfig: Option[FieldLevelEncryptionProfileConfig] = None
    ): FieldLevelEncryptionProfile =
      FieldLevelEncryptionProfile
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(fieldLevelEncryptionProfileConfig)(_.fieldLevelEncryptionProfileConfig(_))
        .build

    def fieldLevelEncryptionProfileAlreadyExists(
      message: Option[String] = None
    ): FieldLevelEncryptionProfileAlreadyExists =
      FieldLevelEncryptionProfileAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fieldLevelEncryptionProfileConfig(
      name: Option[String] = None,
      callerReference: Option[String] = None,
      comment: Option[String] = None,
      encryptionEntities: Option[EncryptionEntities] = None
    ): FieldLevelEncryptionProfileConfig =
      FieldLevelEncryptionProfileConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(encryptionEntities)(_.encryptionEntities(_))
        .build

    def fieldLevelEncryptionProfileInUse(
      message: Option[String] = None
    ): FieldLevelEncryptionProfileInUse =
      FieldLevelEncryptionProfileInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fieldLevelEncryptionProfileList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[FieldLevelEncryptionProfileSummary]] = None
    ): FieldLevelEncryptionProfileList =
      FieldLevelEncryptionProfileList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def fieldLevelEncryptionProfileSizeExceeded(
      message: Option[String] = None
    ): FieldLevelEncryptionProfileSizeExceeded =
      FieldLevelEncryptionProfileSizeExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fieldLevelEncryptionProfileSummary(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      name: Option[String] = None,
      encryptionEntities: Option[EncryptionEntities] = None,
      comment: Option[String] = None
    ): FieldLevelEncryptionProfileSummary =
      FieldLevelEncryptionProfileSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(encryptionEntities)(_.encryptionEntities(_))
        .ifSome(comment)(_.comment(_))
        .build

    def fieldLevelEncryptionSummary(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      comment: Option[String] = None,
      queryArgProfileConfig: Option[QueryArgProfileConfig] = None,
      contentTypeProfileConfig: Option[ContentTypeProfileConfig] = None
    ): FieldLevelEncryptionSummary =
      FieldLevelEncryptionSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(queryArgProfileConfig)(_.queryArgProfileConfig(_))
        .ifSome(contentTypeProfileConfig)(_.contentTypeProfileConfig(_))
        .build

    def fieldPatterns(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): FieldPatterns =
      FieldPatterns
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def forwardedValues(
      queryString: Option[Boolean] = None,
      cookies: Option[CookiePreference] = None,
      headers: Option[Headers] = None,
      queryStringCacheKeys: Option[QueryStringCacheKeys] = None
    ): ForwardedValues =
      ForwardedValues
        .builder
        .ifSome(queryString)(_.queryString(_))
        .ifSome(cookies)(_.cookies(_))
        .ifSome(headers)(_.headers(_))
        .ifSome(queryStringCacheKeys)(_.queryStringCacheKeys(_))
        .build

    def functionAlreadyExists(
      message: Option[String] = None
    ): FunctionAlreadyExists =
      FunctionAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def functionAssociation(
      functionARN: Option[String] = None,
      eventType: Option[String] = None
    ): FunctionAssociation =
      FunctionAssociation
        .builder
        .ifSome(functionARN)(_.functionARN(_))
        .ifSome(eventType)(_.eventType(_))
        .build

    def functionAssociations(
      quantity: Option[Int] = None,
      items: Option[List[FunctionAssociation]] = None
    ): FunctionAssociations =
      FunctionAssociations
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def functionConfig(
      comment: Option[String] = None,
      runtime: Option[String] = None
    ): FunctionConfig =
      FunctionConfig
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(runtime)(_.runtime(_))
        .build

    def functionInUse(
      message: Option[String] = None
    ): FunctionInUse =
      FunctionInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def functionList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[FunctionSummary]] = None
    ): FunctionList =
      FunctionList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def functionMetadata(
      functionARN: Option[String] = None,
      stage: Option[String] = None,
      createdTime: Option[timestamp] = None,
      lastModifiedTime: Option[timestamp] = None
    ): FunctionMetadata =
      FunctionMetadata
        .builder
        .ifSome(functionARN)(_.functionARN(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def functionSizeLimitExceeded(
      message: Option[String] = None
    ): FunctionSizeLimitExceeded =
      FunctionSizeLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def functionSummary(
      name: Option[String] = None,
      status: Option[String] = None,
      functionConfig: Option[FunctionConfig] = None,
      functionMetadata: Option[FunctionMetadata] = None
    ): FunctionSummary =
      FunctionSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(functionConfig)(_.functionConfig(_))
        .ifSome(functionMetadata)(_.functionMetadata(_))
        .build

    def geoRestriction(
      restrictionType: Option[String] = None,
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): GeoRestriction =
      GeoRestriction
        .builder
        .ifSome(restrictionType)(_.restrictionType(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def getCachePolicyConfigRequest(
      id: Option[String] = None
    ): GetCachePolicyConfigRequest =
      GetCachePolicyConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getCachePolicyRequest(
      id: Option[String] = None
    ): GetCachePolicyRequest =
      GetCachePolicyRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getCloudFrontOriginAccessIdentityConfigRequest(
      id: Option[String] = None
    ): GetCloudFrontOriginAccessIdentityConfigRequest =
      GetCloudFrontOriginAccessIdentityConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getCloudFrontOriginAccessIdentityRequest(
      id: Option[String] = None
    ): GetCloudFrontOriginAccessIdentityRequest =
      GetCloudFrontOriginAccessIdentityRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getDistributionConfigRequest(
      id: Option[String] = None
    ): GetDistributionConfigRequest =
      GetDistributionConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getDistributionRequest(
      id: Option[String] = None
    ): GetDistributionRequest =
      GetDistributionRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getFieldLevelEncryptionConfigRequest(
      id: Option[String] = None
    ): GetFieldLevelEncryptionConfigRequest =
      GetFieldLevelEncryptionConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getFieldLevelEncryptionProfileConfigRequest(
      id: Option[String] = None
    ): GetFieldLevelEncryptionProfileConfigRequest =
      GetFieldLevelEncryptionProfileConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getFieldLevelEncryptionProfileRequest(
      id: Option[String] = None
    ): GetFieldLevelEncryptionProfileRequest =
      GetFieldLevelEncryptionProfileRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getFieldLevelEncryptionRequest(
      id: Option[String] = None
    ): GetFieldLevelEncryptionRequest =
      GetFieldLevelEncryptionRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getFunctionRequest(
      name: Option[String] = None,
      stage: Option[String] = None
    ): GetFunctionRequest =
      GetFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(stage)(_.stage(_))
        .build

    def getInvalidationRequest(
      distributionId: Option[String] = None,
      id: Option[String] = None
    ): GetInvalidationRequest =
      GetInvalidationRequest
        .builder
        .ifSome(distributionId)(_.distributionId(_))
        .ifSome(id)(_.id(_))
        .build

    def getKeyGroupConfigRequest(
      id: Option[String] = None
    ): GetKeyGroupConfigRequest =
      GetKeyGroupConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getKeyGroupRequest(
      id: Option[String] = None
    ): GetKeyGroupRequest =
      GetKeyGroupRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getMonitoringSubscriptionRequest(
      distributionId: Option[String] = None
    ): GetMonitoringSubscriptionRequest =
      GetMonitoringSubscriptionRequest
        .builder
        .ifSome(distributionId)(_.distributionId(_))
        .build

    def getOriginRequestPolicyConfigRequest(
      id: Option[String] = None
    ): GetOriginRequestPolicyConfigRequest =
      GetOriginRequestPolicyConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getOriginRequestPolicyRequest(
      id: Option[String] = None
    ): GetOriginRequestPolicyRequest =
      GetOriginRequestPolicyRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getPublicKeyConfigRequest(
      id: Option[String] = None
    ): GetPublicKeyConfigRequest =
      GetPublicKeyConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getPublicKeyRequest(
      id: Option[String] = None
    ): GetPublicKeyRequest =
      GetPublicKeyRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getRealtimeLogConfigRequest(
      name: Option[String] = None,
      aRN: Option[String] = None
    ): GetRealtimeLogConfigRequest =
      GetRealtimeLogConfigRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def getStreamingDistributionConfigRequest(
      id: Option[String] = None
    ): GetStreamingDistributionConfigRequest =
      GetStreamingDistributionConfigRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getStreamingDistributionRequest(
      id: Option[String] = None
    ): GetStreamingDistributionRequest =
      GetStreamingDistributionRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def headers(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): Headers =
      Headers
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def illegalDelete(
      message: Option[String] = None
    ): IllegalDelete =
      IllegalDelete
        .builder
        .ifSome(message)(_.message(_))
        .build

    def illegalFieldLevelEncryptionConfigAssociationWithCacheBehavior(
      message: Option[String] = None
    ): IllegalFieldLevelEncryptionConfigAssociationWithCacheBehavior =
      IllegalFieldLevelEncryptionConfigAssociationWithCacheBehavior
        .builder
        .ifSome(message)(_.message(_))
        .build

    def illegalUpdate(
      message: Option[String] = None
    ): IllegalUpdate =
      IllegalUpdate
        .builder
        .ifSome(message)(_.message(_))
        .build

    def inconsistentQuantities(
      message: Option[String] = None
    ): InconsistentQuantities =
      InconsistentQuantities
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

    def invalidDefaultRootObject(
      message: Option[String] = None
    ): InvalidDefaultRootObject =
      InvalidDefaultRootObject
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidErrorCode(
      message: Option[String] = None
    ): InvalidErrorCode =
      InvalidErrorCode
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidForwardCookies(
      message: Option[String] = None
    ): InvalidForwardCookies =
      InvalidForwardCookies
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFunctionAssociation(
      message: Option[String] = None
    ): InvalidFunctionAssociation =
      InvalidFunctionAssociation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidGeoRestrictionParameter(
      message: Option[String] = None
    ): InvalidGeoRestrictionParameter =
      InvalidGeoRestrictionParameter
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidHeadersForS3Origin(
      message: Option[String] = None
    ): InvalidHeadersForS3Origin =
      InvalidHeadersForS3Origin
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidIfMatchVersion(
      message: Option[String] = None
    ): InvalidIfMatchVersion =
      InvalidIfMatchVersion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidLambdaFunctionAssociation(
      message: Option[String] = None
    ): InvalidLambdaFunctionAssociation =
      InvalidLambdaFunctionAssociation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidLocationCode(
      message: Option[String] = None
    ): InvalidLocationCode =
      InvalidLocationCode
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidMinimumProtocolVersion(
      message: Option[String] = None
    ): InvalidMinimumProtocolVersion =
      InvalidMinimumProtocolVersion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOrigin(
      message: Option[String] = None
    ): InvalidOrigin =
      InvalidOrigin
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOriginAccessIdentity(
      message: Option[String] = None
    ): InvalidOriginAccessIdentity =
      InvalidOriginAccessIdentity
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOriginKeepaliveTimeout(
      message: Option[String] = None
    ): InvalidOriginKeepaliveTimeout =
      InvalidOriginKeepaliveTimeout
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOriginReadTimeout(
      message: Option[String] = None
    ): InvalidOriginReadTimeout =
      InvalidOriginReadTimeout
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidProtocolSettings(
      message: Option[String] = None
    ): InvalidProtocolSettings =
      InvalidProtocolSettings
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidQueryStringParameters(
      message: Option[String] = None
    ): InvalidQueryStringParameters =
      InvalidQueryStringParameters
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRelativePath(
      message: Option[String] = None
    ): InvalidRelativePath =
      InvalidRelativePath
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequiredProtocol(
      message: Option[String] = None
    ): InvalidRequiredProtocol =
      InvalidRequiredProtocol
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResponseCode(
      message: Option[String] = None
    ): InvalidResponseCode =
      InvalidResponseCode
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTTLOrder(
      message: Option[String] = None
    ): InvalidTTLOrder =
      InvalidTTLOrder
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTagging(
      message: Option[String] = None
    ): InvalidTagging =
      InvalidTagging
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidViewerCertificate(
      message: Option[String] = None
    ): InvalidViewerCertificate =
      InvalidViewerCertificate
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidWebACLId(
      message: Option[String] = None
    ): InvalidWebACLId =
      InvalidWebACLId
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidation(
      id: Option[String] = None,
      status: Option[String] = None,
      createTime: Option[timestamp] = None,
      invalidationBatch: Option[InvalidationBatch] = None
    ): Invalidation =
      Invalidation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(invalidationBatch)(_.invalidationBatch(_))
        .build

    def invalidationBatch(
      paths: Option[Paths] = None,
      callerReference: Option[String] = None
    ): InvalidationBatch =
      InvalidationBatch
        .builder
        .ifSome(paths)(_.paths(_))
        .ifSome(callerReference)(_.callerReference(_))
        .build

    def invalidationList(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[InvalidationSummary]] = None
    ): InvalidationList =
      InvalidationList
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def invalidationSummary(
      id: Option[String] = None,
      createTime: Option[timestamp] = None,
      status: Option[String] = None
    ): InvalidationSummary =
      InvalidationSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(status)(_.status(_))
        .build

    def kGKeyPairIds(
      keyGroupId: Option[String] = None,
      keyPairIds: Option[KeyPairIds] = None
    ): KGKeyPairIds =
      KGKeyPairIds
        .builder
        .ifSome(keyGroupId)(_.keyGroupId(_))
        .ifSome(keyPairIds)(_.keyPairIds(_))
        .build

    def keyGroup(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      keyGroupConfig: Option[KeyGroupConfig] = None
    ): KeyGroup =
      KeyGroup
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(keyGroupConfig)(_.keyGroupConfig(_))
        .build

    def keyGroupAlreadyExists(
      message: Option[String] = None
    ): KeyGroupAlreadyExists =
      KeyGroupAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyGroupConfig(
      name: Option[String] = None,
      items: Option[List[string]] = None,
      comment: Option[String] = None
    ): KeyGroupConfig =
      KeyGroupConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(items)(_.items(_))
        .ifSome(comment)(_.comment(_))
        .build

    def keyGroupList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[KeyGroupSummary]] = None
    ): KeyGroupList =
      KeyGroupList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def keyGroupSummary(
      keyGroup: Option[KeyGroup] = None
    ): KeyGroupSummary =
      KeyGroupSummary
        .builder
        .ifSome(keyGroup)(_.keyGroup(_))
        .build

    def keyPairIds(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): KeyPairIds =
      KeyPairIds
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def kinesisStreamConfig(
      roleARN: Option[String] = None,
      streamARN: Option[String] = None
    ): KinesisStreamConfig =
      KinesisStreamConfig
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(streamARN)(_.streamARN(_))
        .build

    def lambdaFunctionAssociation(
      lambdaFunctionARN: Option[String] = None,
      eventType: Option[String] = None,
      includeBody: Option[Boolean] = None
    ): LambdaFunctionAssociation =
      LambdaFunctionAssociation
        .builder
        .ifSome(lambdaFunctionARN)(_.lambdaFunctionARN(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(includeBody)(_.includeBody(_))
        .build

    def lambdaFunctionAssociations(
      quantity: Option[Int] = None,
      items: Option[List[LambdaFunctionAssociation]] = None
    ): LambdaFunctionAssociations =
      LambdaFunctionAssociations
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def listCachePoliciesRequest(
      `type`: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListCachePoliciesRequest =
      ListCachePoliciesRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listCloudFrontOriginAccessIdentitiesRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListCloudFrontOriginAccessIdentitiesRequest =
      ListCloudFrontOriginAccessIdentitiesRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listDistributionsByCachePolicyIdRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      cachePolicyId: Option[String] = None
    ): ListDistributionsByCachePolicyIdRequest =
      ListDistributionsByCachePolicyIdRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(cachePolicyId)(_.cachePolicyId(_))
        .build

    def listDistributionsByKeyGroupRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      keyGroupId: Option[String] = None
    ): ListDistributionsByKeyGroupRequest =
      ListDistributionsByKeyGroupRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(keyGroupId)(_.keyGroupId(_))
        .build

    def listDistributionsByOriginRequestPolicyIdRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      originRequestPolicyId: Option[String] = None
    ): ListDistributionsByOriginRequestPolicyIdRequest =
      ListDistributionsByOriginRequestPolicyIdRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(originRequestPolicyId)(_.originRequestPolicyId(_))
        .build

    def listDistributionsByRealtimeLogConfigRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      realtimeLogConfigName: Option[String] = None,
      realtimeLogConfigArn: Option[String] = None
    ): ListDistributionsByRealtimeLogConfigRequest =
      ListDistributionsByRealtimeLogConfigRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(realtimeLogConfigName)(_.realtimeLogConfigName(_))
        .ifSome(realtimeLogConfigArn)(_.realtimeLogConfigArn(_))
        .build

    def listDistributionsByWebACLIdRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      webACLId: Option[String] = None
    ): ListDistributionsByWebACLIdRequest =
      ListDistributionsByWebACLIdRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(webACLId)(_.webACLId(_))
        .build

    def listDistributionsRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListDistributionsRequest =
      ListDistributionsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listFieldLevelEncryptionConfigsRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListFieldLevelEncryptionConfigsRequest =
      ListFieldLevelEncryptionConfigsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listFieldLevelEncryptionProfilesRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListFieldLevelEncryptionProfilesRequest =
      ListFieldLevelEncryptionProfilesRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listFunctionsRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None,
      stage: Option[String] = None
    ): ListFunctionsRequest =
      ListFunctionsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(stage)(_.stage(_))
        .build

    def listInvalidationsRequest(
      distributionId: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListInvalidationsRequest =
      ListInvalidationsRequest
        .builder
        .ifSome(distributionId)(_.distributionId(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listKeyGroupsRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListKeyGroupsRequest =
      ListKeyGroupsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listOriginRequestPoliciesRequest(
      `type`: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListOriginRequestPoliciesRequest =
      ListOriginRequestPoliciesRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listPublicKeysRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListPublicKeysRequest =
      ListPublicKeysRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listRealtimeLogConfigsRequest(
      maxItems: Option[String] = None,
      marker: Option[String] = None
    ): ListRealtimeLogConfigsRequest =
      ListRealtimeLogConfigsRequest
        .builder
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listStreamingDistributionsRequest(
      marker: Option[String] = None,
      maxItems: Option[String] = None
    ): ListStreamingDistributionsRequest =
      ListStreamingDistributionsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listTagsForResourceRequest(
      resource: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .build

    def loggingConfig(
      enabled: Option[Boolean] = None,
      includeCookies: Option[Boolean] = None,
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): LoggingConfig =
      LoggingConfig
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(includeCookies)(_.includeCookies(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def missingBody(
      message: Option[String] = None
    ): MissingBody =
      MissingBody
        .builder
        .ifSome(message)(_.message(_))
        .build

    def monitoringSubscription(
      realtimeMetricsSubscriptionConfig: Option[RealtimeMetricsSubscriptionConfig] = None
    ): MonitoringSubscription =
      MonitoringSubscription
        .builder
        .ifSome(realtimeMetricsSubscriptionConfig)(_.realtimeMetricsSubscriptionConfig(_))
        .build

    def noSuchCachePolicy(
      message: Option[String] = None
    ): NoSuchCachePolicy =
      NoSuchCachePolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchCloudFrontOriginAccessIdentity(
      message: Option[String] = None
    ): NoSuchCloudFrontOriginAccessIdentity =
      NoSuchCloudFrontOriginAccessIdentity
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchDistribution(
      message: Option[String] = None
    ): NoSuchDistribution =
      NoSuchDistribution
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchFieldLevelEncryptionConfig(
      message: Option[String] = None
    ): NoSuchFieldLevelEncryptionConfig =
      NoSuchFieldLevelEncryptionConfig
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchFieldLevelEncryptionProfile(
      message: Option[String] = None
    ): NoSuchFieldLevelEncryptionProfile =
      NoSuchFieldLevelEncryptionProfile
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchFunctionExists(
      message: Option[String] = None
    ): NoSuchFunctionExists =
      NoSuchFunctionExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchInvalidation(
      message: Option[String] = None
    ): NoSuchInvalidation =
      NoSuchInvalidation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchOrigin(
      message: Option[String] = None
    ): NoSuchOrigin =
      NoSuchOrigin
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchOriginRequestPolicy(
      message: Option[String] = None
    ): NoSuchOriginRequestPolicy =
      NoSuchOriginRequestPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchPublicKey(
      message: Option[String] = None
    ): NoSuchPublicKey =
      NoSuchPublicKey
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchRealtimeLogConfig(
      message: Option[String] = None
    ): NoSuchRealtimeLogConfig =
      NoSuchRealtimeLogConfig
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchResource(
      message: Option[String] = None
    ): NoSuchResource =
      NoSuchResource
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchStreamingDistribution(
      message: Option[String] = None
    ): NoSuchStreamingDistribution =
      NoSuchStreamingDistribution
        .builder
        .ifSome(message)(_.message(_))
        .build

    def origin(
      id: Option[String] = None,
      domainName: Option[String] = None,
      originPath: Option[String] = None,
      customHeaders: Option[CustomHeaders] = None,
      s3OriginConfig: Option[S3OriginConfig] = None,
      customOriginConfig: Option[CustomOriginConfig] = None,
      connectionAttempts: Option[Int] = None,
      connectionTimeout: Option[Int] = None,
      originShield: Option[OriginShield] = None
    ): Origin =
      Origin
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(originPath)(_.originPath(_))
        .ifSome(customHeaders)(_.customHeaders(_))
        .ifSome(s3OriginConfig)(_.s3OriginConfig(_))
        .ifSome(customOriginConfig)(_.customOriginConfig(_))
        .ifSome(connectionAttempts)(_.connectionAttempts(_))
        .ifSome(connectionTimeout)(_.connectionTimeout(_))
        .ifSome(originShield)(_.originShield(_))
        .build

    def originCustomHeader(
      headerName: Option[String] = None,
      headerValue: Option[String] = None
    ): OriginCustomHeader =
      OriginCustomHeader
        .builder
        .ifSome(headerName)(_.headerName(_))
        .ifSome(headerValue)(_.headerValue(_))
        .build

    def originGroup(
      id: Option[String] = None,
      failoverCriteria: Option[OriginGroupFailoverCriteria] = None,
      members: Option[OriginGroupMembers] = None
    ): OriginGroup =
      OriginGroup
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(failoverCriteria)(_.failoverCriteria(_))
        .ifSome(members)(_.members(_))
        .build

    def originGroupFailoverCriteria(
      statusCodes: Option[StatusCodes] = None
    ): OriginGroupFailoverCriteria =
      OriginGroupFailoverCriteria
        .builder
        .ifSome(statusCodes)(_.statusCodes(_))
        .build

    def originGroupMember(
      originId: Option[String] = None
    ): OriginGroupMember =
      OriginGroupMember
        .builder
        .ifSome(originId)(_.originId(_))
        .build

    def originGroupMembers(
      quantity: Option[Int] = None,
      items: Option[List[OriginGroupMember]] = None
    ): OriginGroupMembers =
      OriginGroupMembers
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def originGroups(
      quantity: Option[Int] = None,
      items: Option[List[OriginGroup]] = None
    ): OriginGroups =
      OriginGroups
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def originRequestPolicy(
      id: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      originRequestPolicyConfig: Option[OriginRequestPolicyConfig] = None
    ): OriginRequestPolicy =
      OriginRequestPolicy
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(originRequestPolicyConfig)(_.originRequestPolicyConfig(_))
        .build

    def originRequestPolicyAlreadyExists(
      message: Option[String] = None
    ): OriginRequestPolicyAlreadyExists =
      OriginRequestPolicyAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def originRequestPolicyConfig(
      comment: Option[String] = None,
      name: Option[String] = None,
      headersConfig: Option[OriginRequestPolicyHeadersConfig] = None,
      cookiesConfig: Option[OriginRequestPolicyCookiesConfig] = None,
      queryStringsConfig: Option[OriginRequestPolicyQueryStringsConfig] = None
    ): OriginRequestPolicyConfig =
      OriginRequestPolicyConfig
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(name)(_.name(_))
        .ifSome(headersConfig)(_.headersConfig(_))
        .ifSome(cookiesConfig)(_.cookiesConfig(_))
        .ifSome(queryStringsConfig)(_.queryStringsConfig(_))
        .build

    def originRequestPolicyCookiesConfig(
      cookieBehavior: Option[String] = None,
      cookies: Option[CookieNames] = None
    ): OriginRequestPolicyCookiesConfig =
      OriginRequestPolicyCookiesConfig
        .builder
        .ifSome(cookieBehavior)(_.cookieBehavior(_))
        .ifSome(cookies)(_.cookies(_))
        .build

    def originRequestPolicyHeadersConfig(
      headerBehavior: Option[String] = None,
      headers: Option[Headers] = None
    ): OriginRequestPolicyHeadersConfig =
      OriginRequestPolicyHeadersConfig
        .builder
        .ifSome(headerBehavior)(_.headerBehavior(_))
        .ifSome(headers)(_.headers(_))
        .build

    def originRequestPolicyInUse(
      message: Option[String] = None
    ): OriginRequestPolicyInUse =
      OriginRequestPolicyInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def originRequestPolicyList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[OriginRequestPolicySummary]] = None
    ): OriginRequestPolicyList =
      OriginRequestPolicyList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def originRequestPolicyQueryStringsConfig(
      queryStringBehavior: Option[String] = None,
      queryStrings: Option[QueryStringNames] = None
    ): OriginRequestPolicyQueryStringsConfig =
      OriginRequestPolicyQueryStringsConfig
        .builder
        .ifSome(queryStringBehavior)(_.queryStringBehavior(_))
        .ifSome(queryStrings)(_.queryStrings(_))
        .build

    def originRequestPolicySummary(
      `type`: Option[String] = None,
      originRequestPolicy: Option[OriginRequestPolicy] = None
    ): OriginRequestPolicySummary =
      OriginRequestPolicySummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(originRequestPolicy)(_.originRequestPolicy(_))
        .build

    def originShield(
      enabled: Option[Boolean] = None,
      originShieldRegion: Option[String] = None
    ): OriginShield =
      OriginShield
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(originShieldRegion)(_.originShieldRegion(_))
        .build

    def originSslProtocols(
      quantity: Option[Int] = None,
      items: Option[List[SslProtocol]] = None
    ): OriginSslProtocols =
      OriginSslProtocols
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def origins(
      quantity: Option[Int] = None,
      items: Option[List[Origin]] = None
    ): Origins =
      Origins
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def parametersInCacheKeyAndForwardedToOrigin(
      enableAcceptEncodingGzip: Option[Boolean] = None,
      enableAcceptEncodingBrotli: Option[Boolean] = None,
      headersConfig: Option[CachePolicyHeadersConfig] = None,
      cookiesConfig: Option[CachePolicyCookiesConfig] = None,
      queryStringsConfig: Option[CachePolicyQueryStringsConfig] = None
    ): ParametersInCacheKeyAndForwardedToOrigin =
      ParametersInCacheKeyAndForwardedToOrigin
        .builder
        .ifSome(enableAcceptEncodingGzip)(_.enableAcceptEncodingGzip(_))
        .ifSome(enableAcceptEncodingBrotli)(_.enableAcceptEncodingBrotli(_))
        .ifSome(headersConfig)(_.headersConfig(_))
        .ifSome(cookiesConfig)(_.cookiesConfig(_))
        .ifSome(queryStringsConfig)(_.queryStringsConfig(_))
        .build

    def paths(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): Paths =
      Paths
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def preconditionFailed(
      message: Option[String] = None
    ): PreconditionFailed =
      PreconditionFailed
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publicKey(
      id: Option[String] = None,
      createdTime: Option[timestamp] = None,
      publicKeyConfig: Option[PublicKeyConfig] = None
    ): PublicKey =
      PublicKey
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(publicKeyConfig)(_.publicKeyConfig(_))
        .build

    def publicKeyAlreadyExists(
      message: Option[String] = None
    ): PublicKeyAlreadyExists =
      PublicKeyAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publicKeyConfig(
      callerReference: Option[String] = None,
      name: Option[String] = None,
      encodedKey: Option[String] = None,
      comment: Option[String] = None
    ): PublicKeyConfig =
      PublicKeyConfig
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(name)(_.name(_))
        .ifSome(encodedKey)(_.encodedKey(_))
        .ifSome(comment)(_.comment(_))
        .build

    def publicKeyInUse(
      message: Option[String] = None
    ): PublicKeyInUse =
      PublicKeyInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publicKeyList(
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      quantity: Option[Int] = None,
      items: Option[List[PublicKeySummary]] = None
    ): PublicKeyList =
      PublicKeyList
        .builder
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def publicKeySummary(
      id: Option[String] = None,
      name: Option[String] = None,
      createdTime: Option[timestamp] = None,
      encodedKey: Option[String] = None,
      comment: Option[String] = None
    ): PublicKeySummary =
      PublicKeySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(encodedKey)(_.encodedKey(_))
        .ifSome(comment)(_.comment(_))
        .build

    def publishFunctionRequest(
      name: Option[String] = None,
      ifMatch: Option[String] = None
    ): PublishFunctionRequest =
      PublishFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def queryArgProfile(
      queryArg: Option[String] = None,
      profileId: Option[String] = None
    ): QueryArgProfile =
      QueryArgProfile
        .builder
        .ifSome(queryArg)(_.queryArg(_))
        .ifSome(profileId)(_.profileId(_))
        .build

    def queryArgProfileConfig(
      forwardWhenQueryArgProfileIsUnknown: Option[Boolean] = None,
      queryArgProfiles: Option[QueryArgProfiles] = None
    ): QueryArgProfileConfig =
      QueryArgProfileConfig
        .builder
        .ifSome(forwardWhenQueryArgProfileIsUnknown)(_.forwardWhenQueryArgProfileIsUnknown(_))
        .ifSome(queryArgProfiles)(_.queryArgProfiles(_))
        .build

    def queryArgProfileEmpty(
      message: Option[String] = None
    ): QueryArgProfileEmpty =
      QueryArgProfileEmpty
        .builder
        .ifSome(message)(_.message(_))
        .build

    def queryArgProfiles(
      quantity: Option[Int] = None,
      items: Option[List[QueryArgProfile]] = None
    ): QueryArgProfiles =
      QueryArgProfiles
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def queryStringCacheKeys(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): QueryStringCacheKeys =
      QueryStringCacheKeys
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def queryStringNames(
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): QueryStringNames =
      QueryStringNames
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def realtimeLogConfig(
      aRN: Option[String] = None,
      name: Option[String] = None,
      samplingRate: Option[long] = None,
      endPoints: Option[List[EndPoint]] = None,
      fields: Option[List[string]] = None
    ): RealtimeLogConfig =
      RealtimeLogConfig
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(samplingRate)(_.samplingRate(_))
        .ifSome(endPoints)(_.endPoints(_))
        .ifSome(fields)(_.fields(_))
        .build

    def realtimeLogConfigAlreadyExists(
      message: Option[String] = None
    ): RealtimeLogConfigAlreadyExists =
      RealtimeLogConfigAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def realtimeLogConfigInUse(
      message: Option[String] = None
    ): RealtimeLogConfigInUse =
      RealtimeLogConfigInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def realtimeLogConfigOwnerMismatch(
      message: Option[String] = None
    ): RealtimeLogConfigOwnerMismatch =
      RealtimeLogConfigOwnerMismatch
        .builder
        .ifSome(message)(_.message(_))
        .build

    def realtimeLogConfigs(
      maxItems: Option[Int] = None,
      items: Option[List[RealtimeLogConfig]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None,
      nextMarker: Option[String] = None
    ): RealtimeLogConfigs =
      RealtimeLogConfigs
        .builder
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(items)(_.items(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def realtimeMetricsSubscriptionConfig(
      realtimeMetricsSubscriptionStatus: Option[String] = None
    ): RealtimeMetricsSubscriptionConfig =
      RealtimeMetricsSubscriptionConfig
        .builder
        .ifSome(realtimeMetricsSubscriptionStatus)(_.realtimeMetricsSubscriptionStatus(_))
        .build

    def resourceInUse(
      message: Option[String] = None
    ): ResourceInUse =
      ResourceInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def restrictions(
      geoRestriction: Option[GeoRestriction] = None
    ): Restrictions =
      Restrictions
        .builder
        .ifSome(geoRestriction)(_.geoRestriction(_))
        .build

    def s3Origin(
      domainName: Option[String] = None,
      originAccessIdentity: Option[String] = None
    ): S3Origin =
      S3Origin
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(originAccessIdentity)(_.originAccessIdentity(_))
        .build

    def s3OriginConfig(
      originAccessIdentity: Option[String] = None
    ): S3OriginConfig =
      S3OriginConfig
        .builder
        .ifSome(originAccessIdentity)(_.originAccessIdentity(_))
        .build

    def signer(
      awsAccountNumber: Option[String] = None,
      keyPairIds: Option[KeyPairIds] = None
    ): Signer =
      Signer
        .builder
        .ifSome(awsAccountNumber)(_.awsAccountNumber(_))
        .ifSome(keyPairIds)(_.keyPairIds(_))
        .build

    def statusCodes(
      quantity: Option[Int] = None,
      items: Option[List[integer]] = None
    ): StatusCodes =
      StatusCodes
        .builder
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def streamingDistribution(
      id: Option[String] = None,
      aRN: Option[String] = None,
      status: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      domainName: Option[String] = None,
      activeTrustedSigners: Option[ActiveTrustedSigners] = None,
      streamingDistributionConfig: Option[StreamingDistributionConfig] = None
    ): StreamingDistribution =
      StreamingDistribution
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(activeTrustedSigners)(_.activeTrustedSigners(_))
        .ifSome(streamingDistributionConfig)(_.streamingDistributionConfig(_))
        .build

    def streamingDistributionAlreadyExists(
      message: Option[String] = None
    ): StreamingDistributionAlreadyExists =
      StreamingDistributionAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def streamingDistributionConfig(
      callerReference: Option[String] = None,
      s3Origin: Option[S3Origin] = None,
      aliases: Option[Aliases] = None,
      comment: Option[String] = None,
      logging: Option[StreamingLoggingConfig] = None,
      trustedSigners: Option[TrustedSigners] = None,
      priceClass: Option[String] = None,
      enabled: Option[Boolean] = None
    ): StreamingDistributionConfig =
      StreamingDistributionConfig
        .builder
        .ifSome(callerReference)(_.callerReference(_))
        .ifSome(s3Origin)(_.s3Origin(_))
        .ifSome(aliases)(_.aliases(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(trustedSigners)(_.trustedSigners(_))
        .ifSome(priceClass)(_.priceClass(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def streamingDistributionConfigWithTags(
      streamingDistributionConfig: Option[StreamingDistributionConfig] = None,
      tags: Option[Tags] = None
    ): StreamingDistributionConfigWithTags =
      StreamingDistributionConfigWithTags
        .builder
        .ifSome(streamingDistributionConfig)(_.streamingDistributionConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def streamingDistributionList(
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      maxItems: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[StreamingDistributionSummary]] = None
    ): StreamingDistributionList =
      StreamingDistributionList
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def streamingDistributionNotDisabled(
      message: Option[String] = None
    ): StreamingDistributionNotDisabled =
      StreamingDistributionNotDisabled
        .builder
        .ifSome(message)(_.message(_))
        .build

    def streamingDistributionSummary(
      id: Option[String] = None,
      aRN: Option[String] = None,
      status: Option[String] = None,
      lastModifiedTime: Option[timestamp] = None,
      domainName: Option[String] = None,
      s3Origin: Option[S3Origin] = None,
      aliases: Option[Aliases] = None,
      trustedSigners: Option[TrustedSigners] = None,
      comment: Option[String] = None,
      priceClass: Option[String] = None,
      enabled: Option[Boolean] = None
    ): StreamingDistributionSummary =
      StreamingDistributionSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(s3Origin)(_.s3Origin(_))
        .ifSome(aliases)(_.aliases(_))
        .ifSome(trustedSigners)(_.trustedSigners(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(priceClass)(_.priceClass(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def streamingLoggingConfig(
      enabled: Option[Boolean] = None,
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): StreamingLoggingConfig =
      StreamingLoggingConfig
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
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

    def tagKeys(
      items: Option[List[TagKey]] = None
    ): TagKeys =
      TagKeys
        .builder
        .ifSome(items)(_.items(_))
        .build

    def tagResourceRequest(
      resource: Option[String] = None,
      tags: Option[Tags] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tags(
      items: Option[List[Tag]] = None
    ): Tags =
      Tags
        .builder
        .ifSome(items)(_.items(_))
        .build

    def testFunctionFailed(
      message: Option[String] = None
    ): TestFunctionFailed =
      TestFunctionFailed
        .builder
        .ifSome(message)(_.message(_))
        .build

    def testFunctionRequest(
      name: Option[String] = None,
      ifMatch: Option[String] = None,
      stage: Option[String] = None,
      eventObject: Option[FunctionEventObject] = None
    ): TestFunctionRequest =
      TestFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(eventObject)(_.eventObject(_))
        .build

    def tooManyCacheBehaviors(
      message: Option[String] = None
    ): TooManyCacheBehaviors =
      TooManyCacheBehaviors
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyCachePolicies(
      message: Option[String] = None
    ): TooManyCachePolicies =
      TooManyCachePolicies
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyCertificates(
      message: Option[String] = None
    ): TooManyCertificates =
      TooManyCertificates
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyCloudFrontOriginAccessIdentities(
      message: Option[String] = None
    ): TooManyCloudFrontOriginAccessIdentities =
      TooManyCloudFrontOriginAccessIdentities
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyCookieNamesInWhiteList(
      message: Option[String] = None
    ): TooManyCookieNamesInWhiteList =
      TooManyCookieNamesInWhiteList
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyCookiesInCachePolicy(
      message: Option[String] = None
    ): TooManyCookiesInCachePolicy =
      TooManyCookiesInCachePolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyCookiesInOriginRequestPolicy(
      message: Option[String] = None
    ): TooManyCookiesInOriginRequestPolicy =
      TooManyCookiesInOriginRequestPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionCNAMEs(
      message: Option[String] = None
    ): TooManyDistributionCNAMEs =
      TooManyDistributionCNAMEs
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributions(
      message: Option[String] = None
    ): TooManyDistributions =
      TooManyDistributions
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsAssociatedToCachePolicy(
      message: Option[String] = None
    ): TooManyDistributionsAssociatedToCachePolicy =
      TooManyDistributionsAssociatedToCachePolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsAssociatedToFieldLevelEncryptionConfig(
      message: Option[String] = None
    ): TooManyDistributionsAssociatedToFieldLevelEncryptionConfig =
      TooManyDistributionsAssociatedToFieldLevelEncryptionConfig
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsAssociatedToKeyGroup(
      message: Option[String] = None
    ): TooManyDistributionsAssociatedToKeyGroup =
      TooManyDistributionsAssociatedToKeyGroup
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsAssociatedToOriginRequestPolicy(
      message: Option[String] = None
    ): TooManyDistributionsAssociatedToOriginRequestPolicy =
      TooManyDistributionsAssociatedToOriginRequestPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsWithFunctionAssociations(
      message: Option[String] = None
    ): TooManyDistributionsWithFunctionAssociations =
      TooManyDistributionsWithFunctionAssociations
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsWithLambdaAssociations(
      message: Option[String] = None
    ): TooManyDistributionsWithLambdaAssociations =
      TooManyDistributionsWithLambdaAssociations
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyDistributionsWithSingleFunctionARN(
      message: Option[String] = None
    ): TooManyDistributionsWithSingleFunctionARN =
      TooManyDistributionsWithSingleFunctionARN
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFieldLevelEncryptionConfigs(
      message: Option[String] = None
    ): TooManyFieldLevelEncryptionConfigs =
      TooManyFieldLevelEncryptionConfigs
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFieldLevelEncryptionContentTypeProfiles(
      message: Option[String] = None
    ): TooManyFieldLevelEncryptionContentTypeProfiles =
      TooManyFieldLevelEncryptionContentTypeProfiles
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFieldLevelEncryptionEncryptionEntities(
      message: Option[String] = None
    ): TooManyFieldLevelEncryptionEncryptionEntities =
      TooManyFieldLevelEncryptionEncryptionEntities
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFieldLevelEncryptionFieldPatterns(
      message: Option[String] = None
    ): TooManyFieldLevelEncryptionFieldPatterns =
      TooManyFieldLevelEncryptionFieldPatterns
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFieldLevelEncryptionProfiles(
      message: Option[String] = None
    ): TooManyFieldLevelEncryptionProfiles =
      TooManyFieldLevelEncryptionProfiles
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFieldLevelEncryptionQueryArgProfiles(
      message: Option[String] = None
    ): TooManyFieldLevelEncryptionQueryArgProfiles =
      TooManyFieldLevelEncryptionQueryArgProfiles
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFunctionAssociations(
      message: Option[String] = None
    ): TooManyFunctionAssociations =
      TooManyFunctionAssociations
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyFunctions(
      message: Option[String] = None
    ): TooManyFunctions =
      TooManyFunctions
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyHeadersInCachePolicy(
      message: Option[String] = None
    ): TooManyHeadersInCachePolicy =
      TooManyHeadersInCachePolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyHeadersInForwardedValues(
      message: Option[String] = None
    ): TooManyHeadersInForwardedValues =
      TooManyHeadersInForwardedValues
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyHeadersInOriginRequestPolicy(
      message: Option[String] = None
    ): TooManyHeadersInOriginRequestPolicy =
      TooManyHeadersInOriginRequestPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyInvalidationsInProgress(
      message: Option[String] = None
    ): TooManyInvalidationsInProgress =
      TooManyInvalidationsInProgress
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyKeyGroups(
      message: Option[String] = None
    ): TooManyKeyGroups =
      TooManyKeyGroups
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyKeyGroupsAssociatedToDistribution(
      message: Option[String] = None
    ): TooManyKeyGroupsAssociatedToDistribution =
      TooManyKeyGroupsAssociatedToDistribution
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyLambdaFunctionAssociations(
      message: Option[String] = None
    ): TooManyLambdaFunctionAssociations =
      TooManyLambdaFunctionAssociations
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyOriginCustomHeaders(
      message: Option[String] = None
    ): TooManyOriginCustomHeaders =
      TooManyOriginCustomHeaders
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyOriginGroupsPerDistribution(
      message: Option[String] = None
    ): TooManyOriginGroupsPerDistribution =
      TooManyOriginGroupsPerDistribution
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyOriginRequestPolicies(
      message: Option[String] = None
    ): TooManyOriginRequestPolicies =
      TooManyOriginRequestPolicies
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyOrigins(
      message: Option[String] = None
    ): TooManyOrigins =
      TooManyOrigins
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyPublicKeys(
      message: Option[String] = None
    ): TooManyPublicKeys =
      TooManyPublicKeys
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyPublicKeysInKeyGroup(
      message: Option[String] = None
    ): TooManyPublicKeysInKeyGroup =
      TooManyPublicKeysInKeyGroup
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyQueryStringParameters(
      message: Option[String] = None
    ): TooManyQueryStringParameters =
      TooManyQueryStringParameters
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyQueryStringsInCachePolicy(
      message: Option[String] = None
    ): TooManyQueryStringsInCachePolicy =
      TooManyQueryStringsInCachePolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyQueryStringsInOriginRequestPolicy(
      message: Option[String] = None
    ): TooManyQueryStringsInOriginRequestPolicy =
      TooManyQueryStringsInOriginRequestPolicy
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyRealtimeLogConfigs(
      message: Option[String] = None
    ): TooManyRealtimeLogConfigs =
      TooManyRealtimeLogConfigs
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyStreamingDistributionCNAMEs(
      message: Option[String] = None
    ): TooManyStreamingDistributionCNAMEs =
      TooManyStreamingDistributionCNAMEs
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyStreamingDistributions(
      message: Option[String] = None
    ): TooManyStreamingDistributions =
      TooManyStreamingDistributions
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTrustedSigners(
      message: Option[String] = None
    ): TooManyTrustedSigners =
      TooManyTrustedSigners
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trustedKeyGroupDoesNotExist(
      message: Option[String] = None
    ): TrustedKeyGroupDoesNotExist =
      TrustedKeyGroupDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trustedKeyGroups(
      enabled: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): TrustedKeyGroups =
      TrustedKeyGroups
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def trustedSignerDoesNotExist(
      message: Option[String] = None
    ): TrustedSignerDoesNotExist =
      TrustedSignerDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trustedSigners(
      enabled: Option[Boolean] = None,
      quantity: Option[Int] = None,
      items: Option[List[string]] = None
    ): TrustedSigners =
      TrustedSigners
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(items)(_.items(_))
        .build

    def unsupportedOperation(
      message: Option[String] = None
    ): UnsupportedOperation =
      UnsupportedOperation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resource: Option[String] = None,
      tagKeys: Option[TagKeys] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resource)(_.resource(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateCachePolicyRequest(
      cachePolicyConfig: Option[CachePolicyConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateCachePolicyRequest =
      UpdateCachePolicyRequest
        .builder
        .ifSome(cachePolicyConfig)(_.cachePolicyConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateCloudFrontOriginAccessIdentityRequest(
      cloudFrontOriginAccessIdentityConfig: Option[CloudFrontOriginAccessIdentityConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateCloudFrontOriginAccessIdentityRequest =
      UpdateCloudFrontOriginAccessIdentityRequest
        .builder
        .ifSome(cloudFrontOriginAccessIdentityConfig)(_.cloudFrontOriginAccessIdentityConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateDistributionRequest(
      distributionConfig: Option[DistributionConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateDistributionRequest =
      UpdateDistributionRequest
        .builder
        .ifSome(distributionConfig)(_.distributionConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateFieldLevelEncryptionConfigRequest(
      fieldLevelEncryptionConfig: Option[FieldLevelEncryptionConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateFieldLevelEncryptionConfigRequest =
      UpdateFieldLevelEncryptionConfigRequest
        .builder
        .ifSome(fieldLevelEncryptionConfig)(_.fieldLevelEncryptionConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateFieldLevelEncryptionProfileRequest(
      fieldLevelEncryptionProfileConfig: Option[FieldLevelEncryptionProfileConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateFieldLevelEncryptionProfileRequest =
      UpdateFieldLevelEncryptionProfileRequest
        .builder
        .ifSome(fieldLevelEncryptionProfileConfig)(_.fieldLevelEncryptionProfileConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateFunctionRequest(
      name: Option[String] = None,
      ifMatch: Option[String] = None,
      functionConfig: Option[FunctionConfig] = None,
      functionCode: Option[FunctionBlob] = None
    ): UpdateFunctionRequest =
      UpdateFunctionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .ifSome(functionConfig)(_.functionConfig(_))
        .ifSome(functionCode)(_.functionCode(_))
        .build

    def updateKeyGroupRequest(
      keyGroupConfig: Option[KeyGroupConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateKeyGroupRequest =
      UpdateKeyGroupRequest
        .builder
        .ifSome(keyGroupConfig)(_.keyGroupConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateOriginRequestPolicyRequest(
      originRequestPolicyConfig: Option[OriginRequestPolicyConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateOriginRequestPolicyRequest =
      UpdateOriginRequestPolicyRequest
        .builder
        .ifSome(originRequestPolicyConfig)(_.originRequestPolicyConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updatePublicKeyRequest(
      publicKeyConfig: Option[PublicKeyConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdatePublicKeyRequest =
      UpdatePublicKeyRequest
        .builder
        .ifSome(publicKeyConfig)(_.publicKeyConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def updateRealtimeLogConfigRequest(
      endPoints: Option[List[EndPoint]] = None,
      fields: Option[List[string]] = None,
      name: Option[String] = None,
      aRN: Option[String] = None,
      samplingRate: Option[long] = None
    ): UpdateRealtimeLogConfigRequest =
      UpdateRealtimeLogConfigRequest
        .builder
        .ifSome(endPoints)(_.endPoints(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(name)(_.name(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(samplingRate)(_.samplingRate(_))
        .build

    def updateStreamingDistributionRequest(
      streamingDistributionConfig: Option[StreamingDistributionConfig] = None,
      id: Option[String] = None,
      ifMatch: Option[String] = None
    ): UpdateStreamingDistributionRequest =
      UpdateStreamingDistributionRequest
        .builder
        .ifSome(streamingDistributionConfig)(_.streamingDistributionConfig(_))
        .ifSome(id)(_.id(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .build

    def viewerCertificate(
      cloudFrontDefaultCertificate: Option[Boolean] = None,
      iAMCertificateId: Option[String] = None,
      aCMCertificateArn: Option[String] = None,
      sSLSupportMethod: Option[String] = None,
      minimumProtocolVersion: Option[String] = None,
      certificate: Option[String] = None,
      certificateSource: Option[String] = None
    ): ViewerCertificate =
      ViewerCertificate
        .builder
        .ifSome(cloudFrontDefaultCertificate)(_.cloudFrontDefaultCertificate(_))
        .ifSome(iAMCertificateId)(_.iAMCertificateId(_))
        .ifSome(aCMCertificateArn)(_.aCMCertificateArn(_))
        .ifSome(sSLSupportMethod)(_.sSLSupportMethod(_))
        .ifSome(minimumProtocolVersion)(_.minimumProtocolVersion(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(certificateSource)(_.certificateSource(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
