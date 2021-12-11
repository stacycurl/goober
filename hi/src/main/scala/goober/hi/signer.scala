package goober.hi

import goober.free.signer.SignerIO
import software.amazon.awssdk.services.signer.model._


object signer {
  import goober.free.{signer ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None,
      code: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def addProfilePermissionRequest(
      profileName: Option[String] = None,
      profileVersion: Option[String] = None,
      action: Option[String] = None,
      principal: Option[String] = None,
      revisionId: Option[String] = None,
      statementId: Option[String] = None
    ): AddProfilePermissionRequest =
      AddProfilePermissionRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(action)(_.action(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(statementId)(_.statementId(_))
        .build

    def addProfilePermissionResponse(
      revisionId: Option[String] = None
    ): AddProfilePermissionResponse =
      AddProfilePermissionResponse
        .builder
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def badRequestException(
      message: Option[String] = None,
      code: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def cancelSigningProfileRequest(
      profileName: Option[String] = None
    ): CancelSigningProfileRequest =
      CancelSigningProfileRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .build

    def conflictException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def describeSigningJobRequest(
      jobId: Option[String] = None
    ): DescribeSigningJobRequest =
      DescribeSigningJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeSigningJobResponse(
      jobId: Option[String] = None,
      source: Option[Source] = None,
      signingMaterial: Option[SigningMaterial] = None,
      platformId: Option[String] = None,
      platformDisplayName: Option[String] = None,
      profileName: Option[String] = None,
      profileVersion: Option[String] = None,
      overrides: Option[SigningPlatformOverrides] = None,
      signingParameters: Option[SigningParameters] = None,
      createdAt: Option[Timestamp] = None,
      completedAt: Option[Timestamp] = None,
      signatureExpiresAt: Option[Timestamp] = None,
      requestedBy: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      revocationRecord: Option[SigningJobRevocationRecord] = None,
      signedObject: Option[SignedObject] = None,
      jobOwner: Option[String] = None,
      jobInvoker: Option[String] = None
    ): DescribeSigningJobResponse =
      DescribeSigningJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(source)(_.source(_))
        .ifSome(signingMaterial)(_.signingMaterial(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(platformDisplayName)(_.platformDisplayName(_))
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(overrides)(_.overrides(_))
        .ifSome(signingParameters)(_.signingParameters(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .ifSome(signatureExpiresAt)(_.signatureExpiresAt(_))
        .ifSome(requestedBy)(_.requestedBy(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(revocationRecord)(_.revocationRecord(_))
        .ifSome(signedObject)(_.signedObject(_))
        .ifSome(jobOwner)(_.jobOwner(_))
        .ifSome(jobInvoker)(_.jobInvoker(_))
        .build

    def destination(
      s3: Option[S3Destination] = None
    ): Destination =
      Destination
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def encryptionAlgorithmOptions(
      allowedValues: Option[List[EncryptionAlgorithm]] = None,
      defaultValue: Option[String] = None
    ): EncryptionAlgorithmOptions =
      EncryptionAlgorithmOptions
        .builder
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def getSigningPlatformRequest(
      platformId: Option[String] = None
    ): GetSigningPlatformRequest =
      GetSigningPlatformRequest
        .builder
        .ifSome(platformId)(_.platformId(_))
        .build

    def getSigningPlatformResponse(
      platformId: Option[String] = None,
      displayName: Option[String] = None,
      partner: Option[String] = None,
      target: Option[String] = None,
      category: Option[String] = None,
      signingConfiguration: Option[SigningConfiguration] = None,
      signingImageFormat: Option[SigningImageFormat] = None,
      maxSizeInMB: Option[Int] = None,
      revocationSupported: Option[Boolean] = None
    ): GetSigningPlatformResponse =
      GetSigningPlatformResponse
        .builder
        .ifSome(platformId)(_.platformId(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(partner)(_.partner(_))
        .ifSome(target)(_.target(_))
        .ifSome(category)(_.category(_))
        .ifSome(signingConfiguration)(_.signingConfiguration(_))
        .ifSome(signingImageFormat)(_.signingImageFormat(_))
        .ifSome(maxSizeInMB)(_.maxSizeInMB(_))
        .ifSome(revocationSupported)(_.revocationSupported(_))
        .build

    def getSigningProfileRequest(
      profileName: Option[String] = None,
      profileOwner: Option[String] = None
    ): GetSigningProfileRequest =
      GetSigningProfileRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileOwner)(_.profileOwner(_))
        .build

    def getSigningProfileResponse(
      profileName: Option[String] = None,
      profileVersion: Option[String] = None,
      profileVersionArn: Option[String] = None,
      revocationRecord: Option[SigningProfileRevocationRecord] = None,
      signingMaterial: Option[SigningMaterial] = None,
      platformId: Option[String] = None,
      platformDisplayName: Option[String] = None,
      signatureValidityPeriod: Option[SignatureValidityPeriod] = None,
      overrides: Option[SigningPlatformOverrides] = None,
      signingParameters: Option[SigningParameters] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      arn: Option[String] = None,
      tags: Option[TagMap] = None
    ): GetSigningProfileResponse =
      GetSigningProfileResponse
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(profileVersionArn)(_.profileVersionArn(_))
        .ifSome(revocationRecord)(_.revocationRecord(_))
        .ifSome(signingMaterial)(_.signingMaterial(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(platformDisplayName)(_.platformDisplayName(_))
        .ifSome(signatureValidityPeriod)(_.signatureValidityPeriod(_))
        .ifSome(overrides)(_.overrides(_))
        .ifSome(signingParameters)(_.signingParameters(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def hashAlgorithmOptions(
      allowedValues: Option[List[HashAlgorithm]] = None,
      defaultValue: Option[String] = None
    ): HashAlgorithmOptions =
      HashAlgorithmOptions
        .builder
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None,
      code: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def listProfilePermissionsRequest(
      profileName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListProfilePermissionsRequest =
      ListProfilePermissionsRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProfilePermissionsResponse(
      revisionId: Option[String] = None,
      policySizeBytes: Option[Int] = None,
      permissions: Option[List[Permission]] = None,
      nextToken: Option[String] = None
    ): ListProfilePermissionsResponse =
      ListProfilePermissionsResponse
        .builder
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(policySizeBytes)(_.policySizeBytes(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSigningJobsRequest(
      status: Option[String] = None,
      platformId: Option[String] = None,
      requestedBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      isRevoked: Option[Boolean] = None,
      signatureExpiresBefore: Option[Timestamp] = None,
      signatureExpiresAfter: Option[Timestamp] = None,
      jobInvoker: Option[String] = None
    ): ListSigningJobsRequest =
      ListSigningJobsRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(requestedBy)(_.requestedBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(isRevoked)(_.isRevoked(_))
        .ifSome(signatureExpiresBefore)(_.signatureExpiresBefore(_))
        .ifSome(signatureExpiresAfter)(_.signatureExpiresAfter(_))
        .ifSome(jobInvoker)(_.jobInvoker(_))
        .build

    def listSigningJobsResponse(
      jobs: Option[List[SigningJob]] = None,
      nextToken: Option[String] = None
    ): ListSigningJobsResponse =
      ListSigningJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSigningPlatformsRequest(
      category: Option[String] = None,
      partner: Option[String] = None,
      target: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSigningPlatformsRequest =
      ListSigningPlatformsRequest
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(partner)(_.partner(_))
        .ifSome(target)(_.target(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSigningPlatformsResponse(
      platforms: Option[List[SigningPlatform]] = None,
      nextToken: Option[String] = None
    ): ListSigningPlatformsResponse =
      ListSigningPlatformsResponse
        .builder
        .ifSome(platforms)(_.platforms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSigningProfilesRequest(
      includeCanceled: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      platformId: Option[String] = None,
      statuses: Option[List[SigningProfileStatus]] = None
    ): ListSigningProfilesRequest =
      ListSigningProfilesRequest
        .builder
        .ifSome(includeCanceled)(_.includeCanceled(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(statuses)(_.statuses(_))
        .build

    def listSigningProfilesResponse(
      profiles: Option[List[SigningProfile]] = None,
      nextToken: Option[String] = None
    ): ListSigningProfilesResponse =
      ListSigningProfilesResponse
        .builder
        .ifSome(profiles)(_.profiles(_))
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def notFoundException(
      message: Option[String] = None,
      code: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def permission(
      action: Option[String] = None,
      principal: Option[String] = None,
      statementId: Option[String] = None,
      profileVersion: Option[String] = None
    ): Permission =
      Permission
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(statementId)(_.statementId(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .build

    def putSigningProfileRequest(
      profileName: Option[String] = None,
      signingMaterial: Option[SigningMaterial] = None,
      signatureValidityPeriod: Option[SignatureValidityPeriod] = None,
      platformId: Option[String] = None,
      overrides: Option[SigningPlatformOverrides] = None,
      signingParameters: Option[SigningParameters] = None,
      tags: Option[TagMap] = None
    ): PutSigningProfileRequest =
      PutSigningProfileRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(signingMaterial)(_.signingMaterial(_))
        .ifSome(signatureValidityPeriod)(_.signatureValidityPeriod(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(overrides)(_.overrides(_))
        .ifSome(signingParameters)(_.signingParameters(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putSigningProfileResponse(
      arn: Option[String] = None,
      profileVersion: Option[String] = None,
      profileVersionArn: Option[String] = None
    ): PutSigningProfileResponse =
      PutSigningProfileResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(profileVersionArn)(_.profileVersionArn(_))
        .build

    def removeProfilePermissionRequest(
      profileName: Option[String] = None,
      revisionId: Option[String] = None,
      statementId: Option[String] = None
    ): RemoveProfilePermissionRequest =
      RemoveProfilePermissionRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(statementId)(_.statementId(_))
        .build

    def removeProfilePermissionResponse(
      revisionId: Option[String] = None
    ): RemoveProfilePermissionResponse =
      RemoveProfilePermissionResponse
        .builder
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def revokeSignatureRequest(
      jobId: Option[String] = None,
      jobOwner: Option[String] = None,
      reason: Option[String] = None
    ): RevokeSignatureRequest =
      RevokeSignatureRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobOwner)(_.jobOwner(_))
        .ifSome(reason)(_.reason(_))
        .build

    def revokeSigningProfileRequest(
      profileName: Option[String] = None,
      profileVersion: Option[String] = None,
      reason: Option[String] = None,
      effectiveTime: Option[Timestamp] = None
    ): RevokeSigningProfileRequest =
      RevokeSigningProfileRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(effectiveTime)(_.effectiveTime(_))
        .build

    def s3Destination(
      bucketName: Option[String] = None,
      prefix: Option[String] = None
    ): S3Destination =
      S3Destination
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def s3SignedObject(
      bucketName: Option[String] = None,
      key: Option[String] = None
    ): S3SignedObject =
      S3SignedObject
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(key)(_.key(_))
        .build

    def s3Source(
      bucketName: Option[String] = None,
      key: Option[String] = None,
      version: Option[String] = None
    ): S3Source =
      S3Source
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(key)(_.key(_))
        .ifSome(version)(_.version(_))
        .build

    def serviceLimitExceededException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ServiceLimitExceededException =
      ServiceLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def signatureValidityPeriod(
      value: Option[Int] = None,
      `type`: Option[String] = None
    ): SignatureValidityPeriod =
      SignatureValidityPeriod
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def signedObject(
      s3: Option[S3SignedObject] = None
    ): SignedObject =
      SignedObject
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def signingConfiguration(
      encryptionAlgorithmOptions: Option[EncryptionAlgorithmOptions] = None,
      hashAlgorithmOptions: Option[HashAlgorithmOptions] = None
    ): SigningConfiguration =
      SigningConfiguration
        .builder
        .ifSome(encryptionAlgorithmOptions)(_.encryptionAlgorithmOptions(_))
        .ifSome(hashAlgorithmOptions)(_.hashAlgorithmOptions(_))
        .build

    def signingConfigurationOverrides(
      encryptionAlgorithm: Option[String] = None,
      hashAlgorithm: Option[String] = None
    ): SigningConfigurationOverrides =
      SigningConfigurationOverrides
        .builder
        .ifSome(encryptionAlgorithm)(_.encryptionAlgorithm(_))
        .ifSome(hashAlgorithm)(_.hashAlgorithm(_))
        .build

    def signingImageFormat(
      supportedFormats: Option[List[ImageFormat]] = None,
      defaultFormat: Option[String] = None
    ): SigningImageFormat =
      SigningImageFormat
        .builder
        .ifSome(supportedFormats)(_.supportedFormats(_))
        .ifSome(defaultFormat)(_.defaultFormat(_))
        .build

    def signingJob(
      jobId: Option[String] = None,
      source: Option[Source] = None,
      signedObject: Option[SignedObject] = None,
      signingMaterial: Option[SigningMaterial] = None,
      createdAt: Option[Timestamp] = None,
      status: Option[String] = None,
      isRevoked: Option[Boolean] = None,
      profileName: Option[String] = None,
      profileVersion: Option[String] = None,
      platformId: Option[String] = None,
      platformDisplayName: Option[String] = None,
      signatureExpiresAt: Option[Timestamp] = None,
      jobOwner: Option[String] = None,
      jobInvoker: Option[String] = None
    ): SigningJob =
      SigningJob
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(source)(_.source(_))
        .ifSome(signedObject)(_.signedObject(_))
        .ifSome(signingMaterial)(_.signingMaterial(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(isRevoked)(_.isRevoked(_))
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(platformDisplayName)(_.platformDisplayName(_))
        .ifSome(signatureExpiresAt)(_.signatureExpiresAt(_))
        .ifSome(jobOwner)(_.jobOwner(_))
        .ifSome(jobInvoker)(_.jobInvoker(_))
        .build

    def signingJobRevocationRecord(
      reason: Option[String] = None,
      revokedAt: Option[Timestamp] = None,
      revokedBy: Option[String] = None
    ): SigningJobRevocationRecord =
      SigningJobRevocationRecord
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(revokedAt)(_.revokedAt(_))
        .ifSome(revokedBy)(_.revokedBy(_))
        .build

    def signingMaterial(
      certificateArn: Option[String] = None
    ): SigningMaterial =
      SigningMaterial
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def signingPlatform(
      platformId: Option[String] = None,
      displayName: Option[String] = None,
      partner: Option[String] = None,
      target: Option[String] = None,
      category: Option[String] = None,
      signingConfiguration: Option[SigningConfiguration] = None,
      signingImageFormat: Option[SigningImageFormat] = None,
      maxSizeInMB: Option[Int] = None,
      revocationSupported: Option[Boolean] = None
    ): SigningPlatform =
      SigningPlatform
        .builder
        .ifSome(platformId)(_.platformId(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(partner)(_.partner(_))
        .ifSome(target)(_.target(_))
        .ifSome(category)(_.category(_))
        .ifSome(signingConfiguration)(_.signingConfiguration(_))
        .ifSome(signingImageFormat)(_.signingImageFormat(_))
        .ifSome(maxSizeInMB)(_.maxSizeInMB(_))
        .ifSome(revocationSupported)(_.revocationSupported(_))
        .build

    def signingPlatformOverrides(
      signingConfiguration: Option[SigningConfigurationOverrides] = None,
      signingImageFormat: Option[String] = None
    ): SigningPlatformOverrides =
      SigningPlatformOverrides
        .builder
        .ifSome(signingConfiguration)(_.signingConfiguration(_))
        .ifSome(signingImageFormat)(_.signingImageFormat(_))
        .build

    def signingProfile(
      profileName: Option[String] = None,
      profileVersion: Option[String] = None,
      profileVersionArn: Option[String] = None,
      signingMaterial: Option[SigningMaterial] = None,
      signatureValidityPeriod: Option[SignatureValidityPeriod] = None,
      platformId: Option[String] = None,
      platformDisplayName: Option[String] = None,
      signingParameters: Option[SigningParameters] = None,
      status: Option[String] = None,
      arn: Option[String] = None,
      tags: Option[TagMap] = None
    ): SigningProfile =
      SigningProfile
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(profileVersion)(_.profileVersion(_))
        .ifSome(profileVersionArn)(_.profileVersionArn(_))
        .ifSome(signingMaterial)(_.signingMaterial(_))
        .ifSome(signatureValidityPeriod)(_.signatureValidityPeriod(_))
        .ifSome(platformId)(_.platformId(_))
        .ifSome(platformDisplayName)(_.platformDisplayName(_))
        .ifSome(signingParameters)(_.signingParameters(_))
        .ifSome(status)(_.status(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def signingProfileRevocationRecord(
      revocationEffectiveFrom: Option[Timestamp] = None,
      revokedAt: Option[Timestamp] = None,
      revokedBy: Option[String] = None
    ): SigningProfileRevocationRecord =
      SigningProfileRevocationRecord
        .builder
        .ifSome(revocationEffectiveFrom)(_.revocationEffectiveFrom(_))
        .ifSome(revokedAt)(_.revokedAt(_))
        .ifSome(revokedBy)(_.revokedBy(_))
        .build

    def source(
      s3: Option[S3Source] = None
    ): Source =
      Source
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def startSigningJobRequest(
      source: Option[Source] = None,
      destination: Option[Destination] = None,
      profileName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      profileOwner: Option[String] = None
    ): StartSigningJobRequest =
      StartSigningJobRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(profileName)(_.profileName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(profileOwner)(_.profileOwner(_))
        .build

    def startSigningJobResponse(
      jobId: Option[String] = None,
      jobOwner: Option[String] = None
    ): StartSigningJobResponse =
      StartSigningJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobOwner)(_.jobOwner(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def throttlingException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None,
      code: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
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

    def validationException(
      message: Option[String] = None,
      code: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
