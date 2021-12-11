package goober.hi

import goober.free.s3.S3IO
import software.amazon.awssdk.services.s3.model._


object s3 {
  import goober.free.{s3 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abortIncompleteMultipartUpload(
      daysAfterInitiation: Option[Int] = None
    ): AbortIncompleteMultipartUpload =
      AbortIncompleteMultipartUpload
        .builder
        .ifSome(daysAfterInitiation)(_.daysAfterInitiation(_))
        .build

    def abortMultipartUploadOutput(
      requestCharged: Option[String] = None
    ): AbortMultipartUploadOutput =
      AbortMultipartUploadOutput
        .builder
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def abortMultipartUploadRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      uploadId: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): AbortMultipartUploadRequest =
      AbortMultipartUploadRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def accelerateConfiguration(
      status: Option[String] = None
    ): AccelerateConfiguration =
      AccelerateConfiguration
        .builder
        .ifSome(status)(_.status(_))
        .build

    def accessControlPolicy(
      grants: Option[List[Grant]] = None,
      owner: Option[Owner] = None
    ): AccessControlPolicy =
      AccessControlPolicy
        .builder
        .ifSome(grants)(_.grants(_))
        .ifSome(owner)(_.owner(_))
        .build

    def accessControlTranslation(
      owner: Option[String] = None
    ): AccessControlTranslation =
      AccessControlTranslation
        .builder
        .ifSome(owner)(_.owner(_))
        .build

    def analyticsAndOperator(
      prefix: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AnalyticsAndOperator =
      AnalyticsAndOperator
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tags)(_.tags(_))
        .build

    def analyticsConfiguration(
      id: Option[String] = None,
      filter: Option[AnalyticsFilter] = None,
      storageClassAnalysis: Option[StorageClassAnalysis] = None
    ): AnalyticsConfiguration =
      AnalyticsConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(storageClassAnalysis)(_.storageClassAnalysis(_))
        .build

    def analyticsExportDestination(
      s3BucketDestination: Option[AnalyticsS3BucketDestination] = None
    ): AnalyticsExportDestination =
      AnalyticsExportDestination
        .builder
        .ifSome(s3BucketDestination)(_.s3BucketDestination(_))
        .build

    def analyticsFilter(
      prefix: Option[String] = None,
      tag: Option[Tag] = None,
      and: Option[AnalyticsAndOperator] = None
    ): AnalyticsFilter =
      AnalyticsFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tag)(_.tag(_))
        .ifSome(and)(_.and(_))
        .build

    def analyticsS3BucketDestination(
      format: Option[String] = None,
      bucketAccountId: Option[String] = None,
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): AnalyticsS3BucketDestination =
      AnalyticsS3BucketDestination
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(bucketAccountId)(_.bucketAccountId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def bucket(
      name: Option[String] = None,
      creationDate: Option[CreationDate] = None
    ): Bucket =
      Bucket
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def bucketAlreadyExists(

    ): BucketAlreadyExists =
      BucketAlreadyExists
        .builder

        .build

    def bucketAlreadyOwnedByYou(

    ): BucketAlreadyOwnedByYou =
      BucketAlreadyOwnedByYou
        .builder

        .build

    def bucketLifecycleConfiguration(
      rules: Option[List[LifecycleRule]] = None
    ): BucketLifecycleConfiguration =
      BucketLifecycleConfiguration
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def bucketLoggingStatus(
      loggingEnabled: Option[LoggingEnabled] = None
    ): BucketLoggingStatus =
      BucketLoggingStatus
        .builder
        .ifSome(loggingEnabled)(_.loggingEnabled(_))
        .build

    def cORSConfiguration(
      cORSRules: Option[List[CORSRule]] = None
    ): CORSConfiguration =
      CORSConfiguration
        .builder
        .ifSome(cORSRules)(_.cORSRules(_))
        .build

    def cORSRule(
      iD: Option[String] = None,
      allowedHeaders: Option[List[AllowedHeader]] = None,
      allowedMethods: Option[List[AllowedMethod]] = None,
      allowedOrigins: Option[List[AllowedOrigin]] = None,
      exposeHeaders: Option[List[ExposeHeader]] = None,
      maxAgeSeconds: Option[Int] = None
    ): CORSRule =
      CORSRule
        .builder
        .ifSome(iD)(_.iD(_))
        .ifSome(allowedHeaders)(_.allowedHeaders(_))
        .ifSome(allowedMethods)(_.allowedMethods(_))
        .ifSome(allowedOrigins)(_.allowedOrigins(_))
        .ifSome(exposeHeaders)(_.exposeHeaders(_))
        .ifSome(maxAgeSeconds)(_.maxAgeSeconds(_))
        .build

    def cSVInput(
      fileHeaderInfo: Option[String] = None,
      comments: Option[String] = None,
      quoteEscapeCharacter: Option[String] = None,
      recordDelimiter: Option[String] = None,
      fieldDelimiter: Option[String] = None,
      quoteCharacter: Option[String] = None,
      allowQuotedRecordDelimiter: Option[Boolean] = None
    ): CSVInput =
      CSVInput
        .builder
        .ifSome(fileHeaderInfo)(_.fileHeaderInfo(_))
        .ifSome(comments)(_.comments(_))
        .ifSome(quoteEscapeCharacter)(_.quoteEscapeCharacter(_))
        .ifSome(recordDelimiter)(_.recordDelimiter(_))
        .ifSome(fieldDelimiter)(_.fieldDelimiter(_))
        .ifSome(quoteCharacter)(_.quoteCharacter(_))
        .ifSome(allowQuotedRecordDelimiter)(_.allowQuotedRecordDelimiter(_))
        .build

    def cSVOutput(
      quoteFields: Option[String] = None,
      quoteEscapeCharacter: Option[String] = None,
      recordDelimiter: Option[String] = None,
      fieldDelimiter: Option[String] = None,
      quoteCharacter: Option[String] = None
    ): CSVOutput =
      CSVOutput
        .builder
        .ifSome(quoteFields)(_.quoteFields(_))
        .ifSome(quoteEscapeCharacter)(_.quoteEscapeCharacter(_))
        .ifSome(recordDelimiter)(_.recordDelimiter(_))
        .ifSome(fieldDelimiter)(_.fieldDelimiter(_))
        .ifSome(quoteCharacter)(_.quoteCharacter(_))
        .build

    def cloudFunctionConfiguration(
      id: Option[String] = None,
      event: Option[String] = None,
      events: Option[List[Event]] = None,
      cloudFunction: Option[String] = None,
      invocationRole: Option[String] = None
    ): CloudFunctionConfiguration =
      CloudFunctionConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(event)(_.event(_))
        .ifSome(events)(_.events(_))
        .ifSome(cloudFunction)(_.cloudFunction(_))
        .ifSome(invocationRole)(_.invocationRole(_))
        .build

    def commonPrefix(
      prefix: Option[String] = None
    ): CommonPrefix =
      CommonPrefix
        .builder
        .ifSome(prefix)(_.prefix(_))
        .build

    def completeMultipartUploadOutput(
      location: Option[String] = None,
      bucket: Option[String] = None,
      key: Option[String] = None,
      expiration: Option[String] = None,
      eTag: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      versionId: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestCharged: Option[String] = None
    ): CompleteMultipartUploadOutput =
      CompleteMultipartUploadOutput
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def completeMultipartUploadRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      multipartUpload: Option[CompletedMultipartUpload] = None,
      uploadId: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): CompleteMultipartUploadRequest =
      CompleteMultipartUploadRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(multipartUpload)(_.multipartUpload(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def completedMultipartUpload(
      parts: Option[List[CompletedPart]] = None
    ): CompletedMultipartUpload =
      CompletedMultipartUpload
        .builder
        .ifSome(parts)(_.parts(_))
        .build

    def completedPart(
      eTag: Option[String] = None,
      partNumber: Option[Int] = None
    ): CompletedPart =
      CompletedPart
        .builder
        .ifSome(eTag)(_.eTag(_))
        .ifSome(partNumber)(_.partNumber(_))
        .build

    def condition(
      httpErrorCodeReturnedEquals: Option[String] = None,
      keyPrefixEquals: Option[String] = None
    ): Condition =
      Condition
        .builder
        .ifSome(httpErrorCodeReturnedEquals)(_.httpErrorCodeReturnedEquals(_))
        .ifSome(keyPrefixEquals)(_.keyPrefixEquals(_))
        .build

    def continuationEvent(

    ): ContinuationEvent =
      ContinuationEvent
        .builder

        .build

    def copyObjectOutput(
      copyObjectResult: Option[CopyObjectResult] = None,
      expiration: Option[String] = None,
      copySourceVersionId: Option[String] = None,
      versionId: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSEKMSEncryptionContext: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestCharged: Option[String] = None
    ): CopyObjectOutput =
      CopyObjectOutput
        .builder
        .ifSome(copyObjectResult)(_.copyObjectResult(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(copySourceVersionId)(_.copySourceVersionId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSEKMSEncryptionContext)(_.sSEKMSEncryptionContext(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def copyObjectRequest(
      aCL: Option[String] = None,
      bucket: Option[String] = None,
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      contentType: Option[String] = None,
      copySource: Option[String] = None,
      copySourceIfMatch: Option[String] = None,
      copySourceIfModifiedSince: Option[CopySourceIfModifiedSince] = None,
      copySourceIfNoneMatch: Option[String] = None,
      copySourceIfUnmodifiedSince: Option[CopySourceIfUnmodifiedSince] = None,
      expires: Option[Expires] = None,
      grantFullControl: Option[String] = None,
      grantRead: Option[String] = None,
      grantReadACP: Option[String] = None,
      grantWriteACP: Option[String] = None,
      key: Option[String] = None,
      metadata: Option[Metadata] = None,
      metadataDirective: Option[String] = None,
      taggingDirective: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      storageClass: Option[String] = None,
      websiteRedirectLocation: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSEKMSEncryptionContext: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      copySourceSSECustomerAlgorithm: Option[String] = None,
      copySourceSSECustomerKey: Option[String] = None,
      copySourceSSECustomerKeyMD5: Option[String] = None,
      requestPayer: Option[String] = None,
      tagging: Option[String] = None,
      objectLockMode: Option[String] = None,
      objectLockRetainUntilDate: Option[ObjectLockRetainUntilDate] = None,
      objectLockLegalHoldStatus: Option[String] = None,
      expectedBucketOwner: Option[String] = None,
      expectedSourceBucketOwner: Option[String] = None
    ): CopyObjectRequest =
      CopyObjectRequest
        .builder
        .ifSome(aCL)(_.aCL(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(copySource)(_.copySource(_))
        .ifSome(copySourceIfMatch)(_.copySourceIfMatch(_))
        .ifSome(copySourceIfModifiedSince)(_.copySourceIfModifiedSince(_))
        .ifSome(copySourceIfNoneMatch)(_.copySourceIfNoneMatch(_))
        .ifSome(copySourceIfUnmodifiedSince)(_.copySourceIfUnmodifiedSince(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(grantFullControl)(_.grantFullControl(_))
        .ifSome(grantRead)(_.grantRead(_))
        .ifSome(grantReadACP)(_.grantReadACP(_))
        .ifSome(grantWriteACP)(_.grantWriteACP(_))
        .ifSome(key)(_.key(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(metadataDirective)(_.metadataDirective(_))
        .ifSome(taggingDirective)(_.taggingDirective(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(websiteRedirectLocation)(_.websiteRedirectLocation(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSEKMSEncryptionContext)(_.sSEKMSEncryptionContext(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(copySourceSSECustomerAlgorithm)(_.copySourceSSECustomerAlgorithm(_))
        .ifSome(copySourceSSECustomerKey)(_.copySourceSSECustomerKey(_))
        .ifSome(copySourceSSECustomerKeyMD5)(_.copySourceSSECustomerKeyMD5(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .ifSome(expectedSourceBucketOwner)(_.expectedSourceBucketOwner(_))
        .build

    def createBucketConfiguration(
      locationConstraint: Option[String] = None
    ): CreateBucketConfiguration =
      CreateBucketConfiguration
        .builder
        .ifSome(locationConstraint)(_.locationConstraint(_))
        .build

    def createBucketOutput(
      location: Option[String] = None
    ): CreateBucketOutput =
      CreateBucketOutput
        .builder
        .ifSome(location)(_.location(_))
        .build

    def createBucketRequest(
      aCL: Option[String] = None,
      bucket: Option[String] = None,
      createBucketConfiguration: Option[CreateBucketConfiguration] = None,
      grantFullControl: Option[String] = None,
      grantRead: Option[String] = None,
      grantReadACP: Option[String] = None,
      grantWrite: Option[String] = None,
      grantWriteACP: Option[String] = None,
      objectLockEnabledForBucket: Option[Boolean] = None
    ): CreateBucketRequest =
      CreateBucketRequest
        .builder
        .ifSome(aCL)(_.aCL(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(createBucketConfiguration)(_.createBucketConfiguration(_))
        .ifSome(grantFullControl)(_.grantFullControl(_))
        .ifSome(grantRead)(_.grantRead(_))
        .ifSome(grantReadACP)(_.grantReadACP(_))
        .ifSome(grantWrite)(_.grantWrite(_))
        .ifSome(grantWriteACP)(_.grantWriteACP(_))
        .ifSome(objectLockEnabledForBucket)(_.objectLockEnabledForBucket(_))
        .build

    def createMultipartUploadOutput(
      abortDate: Option[AbortDate] = None,
      abortRuleId: Option[String] = None,
      bucket: Option[String] = None,
      key: Option[String] = None,
      uploadId: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSEKMSEncryptionContext: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestCharged: Option[String] = None
    ): CreateMultipartUploadOutput =
      CreateMultipartUploadOutput
        .builder
        .ifSome(abortDate)(_.abortDate(_))
        .ifSome(abortRuleId)(_.abortRuleId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSEKMSEncryptionContext)(_.sSEKMSEncryptionContext(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def createMultipartUploadRequest(
      aCL: Option[String] = None,
      bucket: Option[String] = None,
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      contentType: Option[String] = None,
      expires: Option[Expires] = None,
      grantFullControl: Option[String] = None,
      grantRead: Option[String] = None,
      grantReadACP: Option[String] = None,
      grantWriteACP: Option[String] = None,
      key: Option[String] = None,
      metadata: Option[Metadata] = None,
      serverSideEncryption: Option[String] = None,
      storageClass: Option[String] = None,
      websiteRedirectLocation: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSEKMSEncryptionContext: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestPayer: Option[String] = None,
      tagging: Option[String] = None,
      objectLockMode: Option[String] = None,
      objectLockRetainUntilDate: Option[ObjectLockRetainUntilDate] = None,
      objectLockLegalHoldStatus: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): CreateMultipartUploadRequest =
      CreateMultipartUploadRequest
        .builder
        .ifSome(aCL)(_.aCL(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(grantFullControl)(_.grantFullControl(_))
        .ifSome(grantRead)(_.grantRead(_))
        .ifSome(grantReadACP)(_.grantReadACP(_))
        .ifSome(grantWriteACP)(_.grantWriteACP(_))
        .ifSome(key)(_.key(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(websiteRedirectLocation)(_.websiteRedirectLocation(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSEKMSEncryptionContext)(_.sSEKMSEncryptionContext(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def defaultRetention(
      mode: Option[String] = None,
      days: Option[Int] = None,
      years: Option[Int] = None
    ): DefaultRetention =
      DefaultRetention
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(days)(_.days(_))
        .ifSome(years)(_.years(_))
        .build

    def delete(
      objects: Option[List[ObjectIdentifier]] = None,
      quiet: Option[Boolean] = None
    ): Delete =
      Delete
        .builder
        .ifSome(objects)(_.objects(_))
        .ifSome(quiet)(_.quiet(_))
        .build

    def deleteBucketAnalyticsConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketAnalyticsConfigurationRequest =
      DeleteBucketAnalyticsConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketCorsRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketCorsRequest =
      DeleteBucketCorsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketEncryptionRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketEncryptionRequest =
      DeleteBucketEncryptionRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketIntelligentTieringConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None
    ): DeleteBucketIntelligentTieringConfigurationRequest =
      DeleteBucketIntelligentTieringConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .build

    def deleteBucketInventoryConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketInventoryConfigurationRequest =
      DeleteBucketInventoryConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketLifecycleRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketLifecycleRequest =
      DeleteBucketLifecycleRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketMetricsConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketMetricsConfigurationRequest =
      DeleteBucketMetricsConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketOwnershipControlsRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketOwnershipControlsRequest =
      DeleteBucketOwnershipControlsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketPolicyRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketPolicyRequest =
      DeleteBucketPolicyRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketReplicationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketReplicationRequest =
      DeleteBucketReplicationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketRequest =
      DeleteBucketRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketTaggingRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketTaggingRequest =
      DeleteBucketTaggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteBucketWebsiteRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteBucketWebsiteRequest =
      DeleteBucketWebsiteRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteMarkerEntry(
      owner: Option[Owner] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      isLatest: Option[Boolean] = None,
      lastModified: Option[LastModified] = None
    ): DeleteMarkerEntry =
      DeleteMarkerEntry
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isLatest)(_.isLatest(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def deleteMarkerReplication(
      status: Option[String] = None
    ): DeleteMarkerReplication =
      DeleteMarkerReplication
        .builder
        .ifSome(status)(_.status(_))
        .build

    def deleteObjectOutput(
      deleteMarker: Option[Boolean] = None,
      versionId: Option[String] = None,
      requestCharged: Option[String] = None
    ): DeleteObjectOutput =
      DeleteObjectOutput
        .builder
        .ifSome(deleteMarker)(_.deleteMarker(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def deleteObjectRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      mFA: Option[String] = None,
      versionId: Option[String] = None,
      requestPayer: Option[String] = None,
      bypassGovernanceRetention: Option[Boolean] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteObjectRequest =
      DeleteObjectRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(mFA)(_.mFA(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteObjectTaggingOutput(
      versionId: Option[String] = None
    ): DeleteObjectTaggingOutput =
      DeleteObjectTaggingOutput
        .builder
        .ifSome(versionId)(_.versionId(_))
        .build

    def deleteObjectTaggingRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteObjectTaggingRequest =
      DeleteObjectTaggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deleteObjectsOutput(
      deleted: Option[List[DeletedObject]] = None,
      requestCharged: Option[String] = None,
      errors: Option[List[Error]] = None
    ): DeleteObjectsOutput =
      DeleteObjectsOutput
        .builder
        .ifSome(deleted)(_.deleted(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .ifSome(errors)(_.errors(_))
        .build

    def deleteObjectsRequest(
      bucket: Option[String] = None,
      delete: Option[Delete] = None,
      mFA: Option[String] = None,
      requestPayer: Option[String] = None,
      bypassGovernanceRetention: Option[Boolean] = None,
      expectedBucketOwner: Option[String] = None
    ): DeleteObjectsRequest =
      DeleteObjectsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(delete)(_.delete(_))
        .ifSome(mFA)(_.mFA(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deletePublicAccessBlockRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): DeletePublicAccessBlockRequest =
      DeletePublicAccessBlockRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def deletedObject(
      key: Option[String] = None,
      versionId: Option[String] = None,
      deleteMarker: Option[Boolean] = None,
      deleteMarkerVersionId: Option[String] = None
    ): DeletedObject =
      DeletedObject
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(deleteMarker)(_.deleteMarker(_))
        .ifSome(deleteMarkerVersionId)(_.deleteMarkerVersionId(_))
        .build

    def destination(
      bucket: Option[String] = None,
      account: Option[String] = None,
      storageClass: Option[String] = None,
      accessControlTranslation: Option[AccessControlTranslation] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      replicationTime: Option[ReplicationTime] = None,
      metrics: Option[Metrics] = None
    ): Destination =
      Destination
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(account)(_.account(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(accessControlTranslation)(_.accessControlTranslation(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(replicationTime)(_.replicationTime(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def encryption(
      encryptionType: Option[String] = None,
      kMSKeyId: Option[String] = None,
      kMSContext: Option[String] = None
    ): Encryption =
      Encryption
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kMSKeyId)(_.kMSKeyId(_))
        .ifSome(kMSContext)(_.kMSContext(_))
        .build

    def encryptionConfiguration(
      replicaKmsKeyID: Option[String] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(replicaKmsKeyID)(_.replicaKmsKeyID(_))
        .build

    def endEvent(

    ): EndEvent =
      EndEvent
        .builder

        .build

    def error(
      key: Option[String] = None,
      versionId: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): Error =
      Error
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def errorDocument(
      key: Option[String] = None
    ): ErrorDocument =
      ErrorDocument
        .builder
        .ifSome(key)(_.key(_))
        .build

    def existingObjectReplication(
      status: Option[String] = None
    ): ExistingObjectReplication =
      ExistingObjectReplication
        .builder
        .ifSome(status)(_.status(_))
        .build

    def filterRule(
      name: Option[String] = None,
      value: Option[String] = None
    ): FilterRule =
      FilterRule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def getBucketAccelerateConfigurationOutput(
      status: Option[String] = None
    ): GetBucketAccelerateConfigurationOutput =
      GetBucketAccelerateConfigurationOutput
        .builder
        .ifSome(status)(_.status(_))
        .build

    def getBucketAccelerateConfigurationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketAccelerateConfigurationRequest =
      GetBucketAccelerateConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketAclOutput(
      owner: Option[Owner] = None,
      grants: Option[List[Grant]] = None
    ): GetBucketAclOutput =
      GetBucketAclOutput
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(grants)(_.grants(_))
        .build

    def getBucketAclRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketAclRequest =
      GetBucketAclRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketAnalyticsConfigurationOutput(
      analyticsConfiguration: Option[AnalyticsConfiguration] = None
    ): GetBucketAnalyticsConfigurationOutput =
      GetBucketAnalyticsConfigurationOutput
        .builder
        .ifSome(analyticsConfiguration)(_.analyticsConfiguration(_))
        .build

    def getBucketAnalyticsConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketAnalyticsConfigurationRequest =
      GetBucketAnalyticsConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketCorsOutput(
      cORSRules: Option[List[CORSRule]] = None
    ): GetBucketCorsOutput =
      GetBucketCorsOutput
        .builder
        .ifSome(cORSRules)(_.cORSRules(_))
        .build

    def getBucketCorsRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketCorsRequest =
      GetBucketCorsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketEncryptionOutput(
      serverSideEncryptionConfiguration: Option[ServerSideEncryptionConfiguration] = None
    ): GetBucketEncryptionOutput =
      GetBucketEncryptionOutput
        .builder
        .ifSome(serverSideEncryptionConfiguration)(_.serverSideEncryptionConfiguration(_))
        .build

    def getBucketEncryptionRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketEncryptionRequest =
      GetBucketEncryptionRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketIntelligentTieringConfigurationOutput(
      intelligentTieringConfiguration: Option[IntelligentTieringConfiguration] = None
    ): GetBucketIntelligentTieringConfigurationOutput =
      GetBucketIntelligentTieringConfigurationOutput
        .builder
        .ifSome(intelligentTieringConfiguration)(_.intelligentTieringConfiguration(_))
        .build

    def getBucketIntelligentTieringConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None
    ): GetBucketIntelligentTieringConfigurationRequest =
      GetBucketIntelligentTieringConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .build

    def getBucketInventoryConfigurationOutput(
      inventoryConfiguration: Option[InventoryConfiguration] = None
    ): GetBucketInventoryConfigurationOutput =
      GetBucketInventoryConfigurationOutput
        .builder
        .ifSome(inventoryConfiguration)(_.inventoryConfiguration(_))
        .build

    def getBucketInventoryConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketInventoryConfigurationRequest =
      GetBucketInventoryConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketLifecycleConfigurationOutput(
      rules: Option[List[LifecycleRule]] = None
    ): GetBucketLifecycleConfigurationOutput =
      GetBucketLifecycleConfigurationOutput
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def getBucketLifecycleConfigurationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketLifecycleConfigurationRequest =
      GetBucketLifecycleConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketLifecycleOutput(
      rules: Option[List[Rule]] = None
    ): GetBucketLifecycleOutput =
      GetBucketLifecycleOutput
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def getBucketLifecycleRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketLifecycleRequest =
      GetBucketLifecycleRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketLocationOutput(
      locationConstraint: Option[String] = None
    ): GetBucketLocationOutput =
      GetBucketLocationOutput
        .builder
        .ifSome(locationConstraint)(_.locationConstraint(_))
        .build

    def getBucketLocationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketLocationRequest =
      GetBucketLocationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketLoggingOutput(
      loggingEnabled: Option[LoggingEnabled] = None
    ): GetBucketLoggingOutput =
      GetBucketLoggingOutput
        .builder
        .ifSome(loggingEnabled)(_.loggingEnabled(_))
        .build

    def getBucketLoggingRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketLoggingRequest =
      GetBucketLoggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketMetricsConfigurationOutput(
      metricsConfiguration: Option[MetricsConfiguration] = None
    ): GetBucketMetricsConfigurationOutput =
      GetBucketMetricsConfigurationOutput
        .builder
        .ifSome(metricsConfiguration)(_.metricsConfiguration(_))
        .build

    def getBucketMetricsConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketMetricsConfigurationRequest =
      GetBucketMetricsConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketNotificationConfigurationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketNotificationConfigurationRequest =
      GetBucketNotificationConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketOwnershipControlsOutput(
      ownershipControls: Option[OwnershipControls] = None
    ): GetBucketOwnershipControlsOutput =
      GetBucketOwnershipControlsOutput
        .builder
        .ifSome(ownershipControls)(_.ownershipControls(_))
        .build

    def getBucketOwnershipControlsRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketOwnershipControlsRequest =
      GetBucketOwnershipControlsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketPolicyOutput(
      policy: Option[String] = None
    ): GetBucketPolicyOutput =
      GetBucketPolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getBucketPolicyRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketPolicyRequest =
      GetBucketPolicyRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketPolicyStatusOutput(
      policyStatus: Option[PolicyStatus] = None
    ): GetBucketPolicyStatusOutput =
      GetBucketPolicyStatusOutput
        .builder
        .ifSome(policyStatus)(_.policyStatus(_))
        .build

    def getBucketPolicyStatusRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketPolicyStatusRequest =
      GetBucketPolicyStatusRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketReplicationOutput(
      replicationConfiguration: Option[ReplicationConfiguration] = None
    ): GetBucketReplicationOutput =
      GetBucketReplicationOutput
        .builder
        .ifSome(replicationConfiguration)(_.replicationConfiguration(_))
        .build

    def getBucketReplicationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketReplicationRequest =
      GetBucketReplicationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketRequestPaymentOutput(
      payer: Option[String] = None
    ): GetBucketRequestPaymentOutput =
      GetBucketRequestPaymentOutput
        .builder
        .ifSome(payer)(_.payer(_))
        .build

    def getBucketRequestPaymentRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketRequestPaymentRequest =
      GetBucketRequestPaymentRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketTaggingOutput(
      tagSet: Option[List[Tag]] = None
    ): GetBucketTaggingOutput =
      GetBucketTaggingOutput
        .builder
        .ifSome(tagSet)(_.tagSet(_))
        .build

    def getBucketTaggingRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketTaggingRequest =
      GetBucketTaggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketVersioningOutput(
      status: Option[String] = None,
      mFADelete: Option[String] = None
    ): GetBucketVersioningOutput =
      GetBucketVersioningOutput
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(mFADelete)(_.mFADelete(_))
        .build

    def getBucketVersioningRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketVersioningRequest =
      GetBucketVersioningRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getBucketWebsiteOutput(
      redirectAllRequestsTo: Option[RedirectAllRequestsTo] = None,
      indexDocument: Option[IndexDocument] = None,
      errorDocument: Option[ErrorDocument] = None,
      routingRules: Option[List[RoutingRule]] = None
    ): GetBucketWebsiteOutput =
      GetBucketWebsiteOutput
        .builder
        .ifSome(redirectAllRequestsTo)(_.redirectAllRequestsTo(_))
        .ifSome(indexDocument)(_.indexDocument(_))
        .ifSome(errorDocument)(_.errorDocument(_))
        .ifSome(routingRules)(_.routingRules(_))
        .build

    def getBucketWebsiteRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetBucketWebsiteRequest =
      GetBucketWebsiteRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getObjectAclOutput(
      owner: Option[Owner] = None,
      grants: Option[List[Grant]] = None,
      requestCharged: Option[String] = None
    ): GetObjectAclOutput =
      GetObjectAclOutput
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(grants)(_.grants(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def getObjectAclRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetObjectAclRequest =
      GetObjectAclRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getObjectLegalHoldOutput(
      legalHold: Option[ObjectLockLegalHold] = None
    ): GetObjectLegalHoldOutput =
      GetObjectLegalHoldOutput
        .builder
        .ifSome(legalHold)(_.legalHold(_))
        .build

    def getObjectLegalHoldRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetObjectLegalHoldRequest =
      GetObjectLegalHoldRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getObjectLockConfigurationOutput(
      objectLockConfiguration: Option[ObjectLockConfiguration] = None
    ): GetObjectLockConfigurationOutput =
      GetObjectLockConfigurationOutput
        .builder
        .ifSome(objectLockConfiguration)(_.objectLockConfiguration(_))
        .build

    def getObjectLockConfigurationRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetObjectLockConfigurationRequest =
      GetObjectLockConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getObjectOutput(
      body: Option[Body] = None,
      deleteMarker: Option[Boolean] = None,
      acceptRanges: Option[String] = None,
      expiration: Option[String] = None,
      restore: Option[String] = None,
      lastModified: Option[LastModified] = None,
      contentLength: Option[ContentLength] = None,
      eTag: Option[String] = None,
      missingMeta: Option[Int] = None,
      versionId: Option[String] = None,
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      contentRange: Option[String] = None,
      contentType: Option[String] = None,
      expires: Option[Expires] = None,
      websiteRedirectLocation: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      metadata: Option[Metadata] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      storageClass: Option[String] = None,
      requestCharged: Option[String] = None,
      replicationStatus: Option[String] = None,
      partsCount: Option[Int] = None,
      tagCount: Option[Int] = None,
      objectLockMode: Option[String] = None,
      objectLockRetainUntilDate: Option[ObjectLockRetainUntilDate] = None,
      objectLockLegalHoldStatus: Option[String] = None
    ): GetObjectOutput =
      GetObjectOutput
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(deleteMarker)(_.deleteMarker(_))
        .ifSome(acceptRanges)(_.acceptRanges(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(restore)(_.restore(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(missingMeta)(_.missingMeta(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(contentRange)(_.contentRange(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(websiteRedirectLocation)(_.websiteRedirectLocation(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .ifSome(partsCount)(_.partsCount(_))
        .ifSome(tagCount)(_.tagCount(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .build

    def getObjectRequest(
      bucket: Option[String] = None,
      ifMatch: Option[String] = None,
      ifModifiedSince: Option[IfModifiedSince] = None,
      ifNoneMatch: Option[String] = None,
      ifUnmodifiedSince: Option[IfUnmodifiedSince] = None,
      key: Option[String] = None,
      range: Option[String] = None,
      responseCacheControl: Option[String] = None,
      responseContentDisposition: Option[String] = None,
      responseContentEncoding: Option[String] = None,
      responseContentLanguage: Option[String] = None,
      responseContentType: Option[String] = None,
      responseExpires: Option[ResponseExpires] = None,
      versionId: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      requestPayer: Option[String] = None,
      partNumber: Option[Int] = None,
      expectedBucketOwner: Option[String] = None
    ): GetObjectRequest =
      GetObjectRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .ifSome(ifModifiedSince)(_.ifModifiedSince(_))
        .ifSome(ifNoneMatch)(_.ifNoneMatch(_))
        .ifSome(ifUnmodifiedSince)(_.ifUnmodifiedSince(_))
        .ifSome(key)(_.key(_))
        .ifSome(range)(_.range(_))
        .ifSome(responseCacheControl)(_.responseCacheControl(_))
        .ifSome(responseContentDisposition)(_.responseContentDisposition(_))
        .ifSome(responseContentEncoding)(_.responseContentEncoding(_))
        .ifSome(responseContentLanguage)(_.responseContentLanguage(_))
        .ifSome(responseContentType)(_.responseContentType(_))
        .ifSome(responseExpires)(_.responseExpires(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(partNumber)(_.partNumber(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getObjectRetentionOutput(
      retention: Option[ObjectLockRetention] = None
    ): GetObjectRetentionOutput =
      GetObjectRetentionOutput
        .builder
        .ifSome(retention)(_.retention(_))
        .build

    def getObjectRetentionRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetObjectRetentionRequest =
      GetObjectRetentionRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getObjectTaggingOutput(
      versionId: Option[String] = None,
      tagSet: Option[List[Tag]] = None
    ): GetObjectTaggingOutput =
      GetObjectTaggingOutput
        .builder
        .ifSome(versionId)(_.versionId(_))
        .ifSome(tagSet)(_.tagSet(_))
        .build

    def getObjectTaggingRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      expectedBucketOwner: Option[String] = None,
      requestPayer: Option[String] = None
    ): GetObjectTaggingRequest =
      GetObjectTaggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .build

    def getObjectTorrentOutput(
      body: Option[Body] = None,
      requestCharged: Option[String] = None
    ): GetObjectTorrentOutput =
      GetObjectTorrentOutput
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def getObjectTorrentRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetObjectTorrentRequest =
      GetObjectTorrentRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def getPublicAccessBlockOutput(
      publicAccessBlockConfiguration: Option[PublicAccessBlockConfiguration] = None
    ): GetPublicAccessBlockOutput =
      GetPublicAccessBlockOutput
        .builder
        .ifSome(publicAccessBlockConfiguration)(_.publicAccessBlockConfiguration(_))
        .build

    def getPublicAccessBlockRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): GetPublicAccessBlockRequest =
      GetPublicAccessBlockRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def glacierJobParameters(
      tier: Option[String] = None
    ): GlacierJobParameters =
      GlacierJobParameters
        .builder
        .ifSome(tier)(_.tier(_))
        .build

    def grant(
      grantee: Option[Grantee] = None,
      permission: Option[String] = None
    ): Grant =
      Grant
        .builder
        .ifSome(grantee)(_.grantee(_))
        .ifSome(permission)(_.permission(_))
        .build

    def grantee(
      displayName: Option[String] = None,
      emailAddress: Option[String] = None,
      iD: Option[String] = None,
      `type`: Option[String] = None,
      uRI: Option[String] = None
    ): Grantee =
      Grantee
        .builder
        .ifSome(displayName)(_.displayName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(iD)(_.iD(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uRI)(_.uRI(_))
        .build

    def headBucketRequest(
      bucket: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): HeadBucketRequest =
      HeadBucketRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def headObjectOutput(
      deleteMarker: Option[Boolean] = None,
      acceptRanges: Option[String] = None,
      expiration: Option[String] = None,
      restore: Option[String] = None,
      archiveStatus: Option[String] = None,
      lastModified: Option[LastModified] = None,
      contentLength: Option[ContentLength] = None,
      eTag: Option[String] = None,
      missingMeta: Option[Int] = None,
      versionId: Option[String] = None,
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      contentType: Option[String] = None,
      expires: Option[Expires] = None,
      websiteRedirectLocation: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      metadata: Option[Metadata] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      storageClass: Option[String] = None,
      requestCharged: Option[String] = None,
      replicationStatus: Option[String] = None,
      partsCount: Option[Int] = None,
      objectLockMode: Option[String] = None,
      objectLockRetainUntilDate: Option[ObjectLockRetainUntilDate] = None,
      objectLockLegalHoldStatus: Option[String] = None
    ): HeadObjectOutput =
      HeadObjectOutput
        .builder
        .ifSome(deleteMarker)(_.deleteMarker(_))
        .ifSome(acceptRanges)(_.acceptRanges(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(restore)(_.restore(_))
        .ifSome(archiveStatus)(_.archiveStatus(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(missingMeta)(_.missingMeta(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(websiteRedirectLocation)(_.websiteRedirectLocation(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .ifSome(partsCount)(_.partsCount(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .build

    def headObjectRequest(
      bucket: Option[String] = None,
      ifMatch: Option[String] = None,
      ifModifiedSince: Option[IfModifiedSince] = None,
      ifNoneMatch: Option[String] = None,
      ifUnmodifiedSince: Option[IfUnmodifiedSince] = None,
      key: Option[String] = None,
      range: Option[String] = None,
      versionId: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      requestPayer: Option[String] = None,
      partNumber: Option[Int] = None,
      expectedBucketOwner: Option[String] = None
    ): HeadObjectRequest =
      HeadObjectRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(ifMatch)(_.ifMatch(_))
        .ifSome(ifModifiedSince)(_.ifModifiedSince(_))
        .ifSome(ifNoneMatch)(_.ifNoneMatch(_))
        .ifSome(ifUnmodifiedSince)(_.ifUnmodifiedSince(_))
        .ifSome(key)(_.key(_))
        .ifSome(range)(_.range(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(partNumber)(_.partNumber(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def indexDocument(
      suffix: Option[String] = None
    ): IndexDocument =
      IndexDocument
        .builder
        .ifSome(suffix)(_.suffix(_))
        .build

    def initiator(
      iD: Option[String] = None,
      displayName: Option[String] = None
    ): Initiator =
      Initiator
        .builder
        .ifSome(iD)(_.iD(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def inputSerialization(
      cSV: Option[CSVInput] = None,
      compressionType: Option[String] = None,
      jSON: Option[JSONInput] = None,
      parquet: Option[ParquetInput] = None
    ): InputSerialization =
      InputSerialization
        .builder
        .ifSome(cSV)(_.cSV(_))
        .ifSome(compressionType)(_.compressionType(_))
        .ifSome(jSON)(_.jSON(_))
        .ifSome(parquet)(_.parquet(_))
        .build

    def intelligentTieringAndOperator(
      prefix: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): IntelligentTieringAndOperator =
      IntelligentTieringAndOperator
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tags)(_.tags(_))
        .build

    def intelligentTieringConfiguration(
      id: Option[String] = None,
      filter: Option[IntelligentTieringFilter] = None,
      status: Option[String] = None,
      tierings: Option[List[Tiering]] = None
    ): IntelligentTieringConfiguration =
      IntelligentTieringConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(status)(_.status(_))
        .ifSome(tierings)(_.tierings(_))
        .build

    def intelligentTieringFilter(
      prefix: Option[String] = None,
      tag: Option[Tag] = None,
      and: Option[IntelligentTieringAndOperator] = None
    ): IntelligentTieringFilter =
      IntelligentTieringFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tag)(_.tag(_))
        .ifSome(and)(_.and(_))
        .build

    def invalidObjectState(
      storageClass: Option[String] = None,
      accessTier: Option[String] = None
    ): InvalidObjectState =
      InvalidObjectState
        .builder
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(accessTier)(_.accessTier(_))
        .build

    def inventoryConfiguration(
      destination: Option[InventoryDestination] = None,
      isEnabled: Option[Boolean] = None,
      filter: Option[InventoryFilter] = None,
      id: Option[String] = None,
      includedObjectVersions: Option[String] = None,
      optionalFields: Option[List[InventoryOptionalField]] = None,
      schedule: Option[InventorySchedule] = None
    ): InventoryConfiguration =
      InventoryConfiguration
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(isEnabled)(_.isEnabled(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(id)(_.id(_))
        .ifSome(includedObjectVersions)(_.includedObjectVersions(_))
        .ifSome(optionalFields)(_.optionalFields(_))
        .ifSome(schedule)(_.schedule(_))
        .build

    def inventoryDestination(
      s3BucketDestination: Option[InventoryS3BucketDestination] = None
    ): InventoryDestination =
      InventoryDestination
        .builder
        .ifSome(s3BucketDestination)(_.s3BucketDestination(_))
        .build

    def inventoryEncryption(
      sSES3: Option[SSES3] = None,
      sSEKMS: Option[SSEKMS] = None
    ): InventoryEncryption =
      InventoryEncryption
        .builder
        .ifSome(sSES3)(_.sSES3(_))
        .ifSome(sSEKMS)(_.sSEKMS(_))
        .build

    def inventoryFilter(
      prefix: Option[String] = None
    ): InventoryFilter =
      InventoryFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .build

    def inventoryS3BucketDestination(
      accountId: Option[String] = None,
      bucket: Option[String] = None,
      format: Option[String] = None,
      prefix: Option[String] = None,
      encryption: Option[InventoryEncryption] = None
    ): InventoryS3BucketDestination =
      InventoryS3BucketDestination
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(format)(_.format(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def inventorySchedule(
      frequency: Option[String] = None
    ): InventorySchedule =
      InventorySchedule
        .builder
        .ifSome(frequency)(_.frequency(_))
        .build

    def jSONInput(
      `type`: Option[String] = None
    ): JSONInput =
      JSONInput
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def jSONOutput(
      recordDelimiter: Option[String] = None
    ): JSONOutput =
      JSONOutput
        .builder
        .ifSome(recordDelimiter)(_.recordDelimiter(_))
        .build

    def lambdaFunctionConfiguration(
      id: Option[String] = None,
      lambdaFunctionArn: Option[String] = None,
      events: Option[List[Event]] = None,
      filter: Option[NotificationConfigurationFilter] = None
    ): LambdaFunctionConfiguration =
      LambdaFunctionConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .ifSome(events)(_.events(_))
        .ifSome(filter)(_.filter(_))
        .build

    def lifecycleConfiguration(
      rules: Option[List[Rule]] = None
    ): LifecycleConfiguration =
      LifecycleConfiguration
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def lifecycleExpiration(
      date: Option[Date] = None,
      days: Option[Int] = None,
      expiredObjectDeleteMarker: Option[Boolean] = None
    ): LifecycleExpiration =
      LifecycleExpiration
        .builder
        .ifSome(date)(_.date(_))
        .ifSome(days)(_.days(_))
        .ifSome(expiredObjectDeleteMarker)(_.expiredObjectDeleteMarker(_))
        .build

    def lifecycleRule(
      expiration: Option[LifecycleExpiration] = None,
      iD: Option[String] = None,
      prefix: Option[String] = None,
      filter: Option[LifecycleRuleFilter] = None,
      status: Option[String] = None,
      transitions: Option[List[Transition]] = None,
      noncurrentVersionTransitions: Option[List[NoncurrentVersionTransition]] = None,
      noncurrentVersionExpiration: Option[NoncurrentVersionExpiration] = None,
      abortIncompleteMultipartUpload: Option[AbortIncompleteMultipartUpload] = None
    ): LifecycleRule =
      LifecycleRule
        .builder
        .ifSome(expiration)(_.expiration(_))
        .ifSome(iD)(_.iD(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(status)(_.status(_))
        .ifSome(transitions)(_.transitions(_))
        .ifSome(noncurrentVersionTransitions)(_.noncurrentVersionTransitions(_))
        .ifSome(noncurrentVersionExpiration)(_.noncurrentVersionExpiration(_))
        .ifSome(abortIncompleteMultipartUpload)(_.abortIncompleteMultipartUpload(_))
        .build

    def lifecycleRuleAndOperator(
      prefix: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): LifecycleRuleAndOperator =
      LifecycleRuleAndOperator
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tags)(_.tags(_))
        .build

    def lifecycleRuleFilter(
      prefix: Option[String] = None,
      tag: Option[Tag] = None,
      and: Option[LifecycleRuleAndOperator] = None
    ): LifecycleRuleFilter =
      LifecycleRuleFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tag)(_.tag(_))
        .ifSome(and)(_.and(_))
        .build

    def listBucketAnalyticsConfigurationsOutput(
      isTruncated: Option[Boolean] = None,
      continuationToken: Option[String] = None,
      nextContinuationToken: Option[String] = None,
      analyticsConfigurationList: Option[List[AnalyticsConfiguration]] = None
    ): ListBucketAnalyticsConfigurationsOutput =
      ListBucketAnalyticsConfigurationsOutput
        .builder
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(nextContinuationToken)(_.nextContinuationToken(_))
        .ifSome(analyticsConfigurationList)(_.analyticsConfigurationList(_))
        .build

    def listBucketAnalyticsConfigurationsRequest(
      bucket: Option[String] = None,
      continuationToken: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListBucketAnalyticsConfigurationsRequest =
      ListBucketAnalyticsConfigurationsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listBucketIntelligentTieringConfigurationsOutput(
      isTruncated: Option[Boolean] = None,
      continuationToken: Option[String] = None,
      nextContinuationToken: Option[String] = None,
      intelligentTieringConfigurationList: Option[List[IntelligentTieringConfiguration]] = None
    ): ListBucketIntelligentTieringConfigurationsOutput =
      ListBucketIntelligentTieringConfigurationsOutput
        .builder
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(nextContinuationToken)(_.nextContinuationToken(_))
        .ifSome(intelligentTieringConfigurationList)(_.intelligentTieringConfigurationList(_))
        .build

    def listBucketIntelligentTieringConfigurationsRequest(
      bucket: Option[String] = None,
      continuationToken: Option[String] = None
    ): ListBucketIntelligentTieringConfigurationsRequest =
      ListBucketIntelligentTieringConfigurationsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .build

    def listBucketInventoryConfigurationsOutput(
      continuationToken: Option[String] = None,
      inventoryConfigurationList: Option[List[InventoryConfiguration]] = None,
      isTruncated: Option[Boolean] = None,
      nextContinuationToken: Option[String] = None
    ): ListBucketInventoryConfigurationsOutput =
      ListBucketInventoryConfigurationsOutput
        .builder
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(inventoryConfigurationList)(_.inventoryConfigurationList(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(nextContinuationToken)(_.nextContinuationToken(_))
        .build

    def listBucketInventoryConfigurationsRequest(
      bucket: Option[String] = None,
      continuationToken: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListBucketInventoryConfigurationsRequest =
      ListBucketInventoryConfigurationsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listBucketMetricsConfigurationsOutput(
      isTruncated: Option[Boolean] = None,
      continuationToken: Option[String] = None,
      nextContinuationToken: Option[String] = None,
      metricsConfigurationList: Option[List[MetricsConfiguration]] = None
    ): ListBucketMetricsConfigurationsOutput =
      ListBucketMetricsConfigurationsOutput
        .builder
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(nextContinuationToken)(_.nextContinuationToken(_))
        .ifSome(metricsConfigurationList)(_.metricsConfigurationList(_))
        .build

    def listBucketMetricsConfigurationsRequest(
      bucket: Option[String] = None,
      continuationToken: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListBucketMetricsConfigurationsRequest =
      ListBucketMetricsConfigurationsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listBucketsOutput(
      buckets: Option[List[Bucket]] = None,
      owner: Option[Owner] = None
    ): ListBucketsOutput =
      ListBucketsOutput
        .builder
        .ifSome(buckets)(_.buckets(_))
        .ifSome(owner)(_.owner(_))
        .build

    def listMultipartUploadsOutput(
      bucket: Option[String] = None,
      keyMarker: Option[String] = None,
      uploadIdMarker: Option[String] = None,
      nextKeyMarker: Option[String] = None,
      prefix: Option[String] = None,
      delimiter: Option[String] = None,
      nextUploadIdMarker: Option[String] = None,
      maxUploads: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      uploads: Option[List[MultipartUpload]] = None,
      commonPrefixes: Option[List[CommonPrefix]] = None,
      encodingType: Option[String] = None
    ): ListMultipartUploadsOutput =
      ListMultipartUploadsOutput
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyMarker)(_.keyMarker(_))
        .ifSome(uploadIdMarker)(_.uploadIdMarker(_))
        .ifSome(nextKeyMarker)(_.nextKeyMarker(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(nextUploadIdMarker)(_.nextUploadIdMarker(_))
        .ifSome(maxUploads)(_.maxUploads(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(uploads)(_.uploads(_))
        .ifSome(commonPrefixes)(_.commonPrefixes(_))
        .ifSome(encodingType)(_.encodingType(_))
        .build

    def listMultipartUploadsRequest(
      bucket: Option[String] = None,
      delimiter: Option[String] = None,
      encodingType: Option[String] = None,
      keyMarker: Option[String] = None,
      maxUploads: Option[Int] = None,
      prefix: Option[String] = None,
      uploadIdMarker: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListMultipartUploadsRequest =
      ListMultipartUploadsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(keyMarker)(_.keyMarker(_))
        .ifSome(maxUploads)(_.maxUploads(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(uploadIdMarker)(_.uploadIdMarker(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listObjectVersionsOutput(
      isTruncated: Option[Boolean] = None,
      keyMarker: Option[String] = None,
      versionIdMarker: Option[String] = None,
      nextKeyMarker: Option[String] = None,
      nextVersionIdMarker: Option[String] = None,
      versions: Option[List[ObjectVersion]] = None,
      deleteMarkers: Option[List[DeleteMarkerEntry]] = None,
      name: Option[String] = None,
      prefix: Option[String] = None,
      delimiter: Option[String] = None,
      maxKeys: Option[Int] = None,
      commonPrefixes: Option[List[CommonPrefix]] = None,
      encodingType: Option[String] = None
    ): ListObjectVersionsOutput =
      ListObjectVersionsOutput
        .builder
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(keyMarker)(_.keyMarker(_))
        .ifSome(versionIdMarker)(_.versionIdMarker(_))
        .ifSome(nextKeyMarker)(_.nextKeyMarker(_))
        .ifSome(nextVersionIdMarker)(_.nextVersionIdMarker(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(deleteMarkers)(_.deleteMarkers(_))
        .ifSome(name)(_.name(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(maxKeys)(_.maxKeys(_))
        .ifSome(commonPrefixes)(_.commonPrefixes(_))
        .ifSome(encodingType)(_.encodingType(_))
        .build

    def listObjectVersionsRequest(
      bucket: Option[String] = None,
      delimiter: Option[String] = None,
      encodingType: Option[String] = None,
      keyMarker: Option[String] = None,
      maxKeys: Option[Int] = None,
      prefix: Option[String] = None,
      versionIdMarker: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListObjectVersionsRequest =
      ListObjectVersionsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(keyMarker)(_.keyMarker(_))
        .ifSome(maxKeys)(_.maxKeys(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(versionIdMarker)(_.versionIdMarker(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listObjectsOutput(
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None,
      nextMarker: Option[String] = None,
      contents: Option[List[Object]] = None,
      name: Option[String] = None,
      prefix: Option[String] = None,
      delimiter: Option[String] = None,
      maxKeys: Option[Int] = None,
      commonPrefixes: Option[List[CommonPrefix]] = None,
      encodingType: Option[String] = None
    ): ListObjectsOutput =
      ListObjectsOutput
        .builder
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(contents)(_.contents(_))
        .ifSome(name)(_.name(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(maxKeys)(_.maxKeys(_))
        .ifSome(commonPrefixes)(_.commonPrefixes(_))
        .ifSome(encodingType)(_.encodingType(_))
        .build

    def listObjectsRequest(
      bucket: Option[String] = None,
      delimiter: Option[String] = None,
      encodingType: Option[String] = None,
      marker: Option[String] = None,
      maxKeys: Option[Int] = None,
      prefix: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListObjectsRequest =
      ListObjectsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxKeys)(_.maxKeys(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listObjectsV2Output(
      isTruncated: Option[Boolean] = None,
      contents: Option[List[Object]] = None,
      name: Option[String] = None,
      prefix: Option[String] = None,
      delimiter: Option[String] = None,
      maxKeys: Option[Int] = None,
      commonPrefixes: Option[List[CommonPrefix]] = None,
      encodingType: Option[String] = None,
      keyCount: Option[Int] = None,
      continuationToken: Option[String] = None,
      nextContinuationToken: Option[String] = None,
      startAfter: Option[String] = None
    ): ListObjectsV2Output =
      ListObjectsV2Output
        .builder
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(contents)(_.contents(_))
        .ifSome(name)(_.name(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(maxKeys)(_.maxKeys(_))
        .ifSome(commonPrefixes)(_.commonPrefixes(_))
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(keyCount)(_.keyCount(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(nextContinuationToken)(_.nextContinuationToken(_))
        .ifSome(startAfter)(_.startAfter(_))
        .build

    def listObjectsV2Request(
      bucket: Option[String] = None,
      delimiter: Option[String] = None,
      encodingType: Option[String] = None,
      maxKeys: Option[Int] = None,
      prefix: Option[String] = None,
      continuationToken: Option[String] = None,
      fetchOwner: Option[Boolean] = None,
      startAfter: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListObjectsV2Request =
      ListObjectsV2Request
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(maxKeys)(_.maxKeys(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(continuationToken)(_.continuationToken(_))
        .ifSome(fetchOwner)(_.fetchOwner(_))
        .ifSome(startAfter)(_.startAfter(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def listPartsOutput(
      abortDate: Option[AbortDate] = None,
      abortRuleId: Option[String] = None,
      bucket: Option[String] = None,
      key: Option[String] = None,
      uploadId: Option[String] = None,
      partNumberMarker: Option[Int] = None,
      nextPartNumberMarker: Option[Int] = None,
      maxParts: Option[Int] = None,
      isTruncated: Option[Boolean] = None,
      parts: Option[List[Part]] = None,
      initiator: Option[Initiator] = None,
      owner: Option[Owner] = None,
      storageClass: Option[String] = None,
      requestCharged: Option[String] = None
    ): ListPartsOutput =
      ListPartsOutput
        .builder
        .ifSome(abortDate)(_.abortDate(_))
        .ifSome(abortRuleId)(_.abortRuleId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(partNumberMarker)(_.partNumberMarker(_))
        .ifSome(nextPartNumberMarker)(_.nextPartNumberMarker(_))
        .ifSome(maxParts)(_.maxParts(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(parts)(_.parts(_))
        .ifSome(initiator)(_.initiator(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def listPartsRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      maxParts: Option[Int] = None,
      partNumberMarker: Option[Int] = None,
      uploadId: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): ListPartsRequest =
      ListPartsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(maxParts)(_.maxParts(_))
        .ifSome(partNumberMarker)(_.partNumberMarker(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def loggingEnabled(
      targetBucket: Option[String] = None,
      targetGrants: Option[List[TargetGrant]] = None,
      targetPrefix: Option[String] = None
    ): LoggingEnabled =
      LoggingEnabled
        .builder
        .ifSome(targetBucket)(_.targetBucket(_))
        .ifSome(targetGrants)(_.targetGrants(_))
        .ifSome(targetPrefix)(_.targetPrefix(_))
        .build

    def metadataEntry(
      name: Option[String] = None,
      value: Option[String] = None
    ): MetadataEntry =
      MetadataEntry
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def metrics(
      status: Option[String] = None,
      eventThreshold: Option[ReplicationTimeValue] = None
    ): Metrics =
      Metrics
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(eventThreshold)(_.eventThreshold(_))
        .build

    def metricsAndOperator(
      prefix: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): MetricsAndOperator =
      MetricsAndOperator
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tags)(_.tags(_))
        .build

    def metricsConfiguration(
      id: Option[String] = None,
      filter: Option[MetricsFilter] = None
    ): MetricsConfiguration =
      MetricsConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(filter)(_.filter(_))
        .build

    def metricsFilter(
      prefix: Option[String] = None,
      tag: Option[Tag] = None,
      and: Option[MetricsAndOperator] = None
    ): MetricsFilter =
      MetricsFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tag)(_.tag(_))
        .ifSome(and)(_.and(_))
        .build

    def multipartUpload(
      uploadId: Option[String] = None,
      key: Option[String] = None,
      initiated: Option[Initiated] = None,
      storageClass: Option[String] = None,
      owner: Option[Owner] = None,
      initiator: Option[Initiator] = None
    ): MultipartUpload =
      MultipartUpload
        .builder
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(key)(_.key(_))
        .ifSome(initiated)(_.initiated(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(initiator)(_.initiator(_))
        .build

    def noSuchBucket(

    ): NoSuchBucket =
      NoSuchBucket
        .builder

        .build

    def noSuchKey(

    ): NoSuchKey =
      NoSuchKey
        .builder

        .build

    def noSuchUpload(

    ): NoSuchUpload =
      NoSuchUpload
        .builder

        .build

    def noncurrentVersionExpiration(
      noncurrentDays: Option[Int] = None
    ): NoncurrentVersionExpiration =
      NoncurrentVersionExpiration
        .builder
        .ifSome(noncurrentDays)(_.noncurrentDays(_))
        .build

    def noncurrentVersionTransition(
      noncurrentDays: Option[Int] = None,
      storageClass: Option[String] = None
    ): NoncurrentVersionTransition =
      NoncurrentVersionTransition
        .builder
        .ifSome(noncurrentDays)(_.noncurrentDays(_))
        .ifSome(storageClass)(_.storageClass(_))
        .build

    def notificationConfiguration(
      topicConfigurations: Option[List[TopicConfiguration]] = None,
      queueConfigurations: Option[List[QueueConfiguration]] = None,
      lambdaFunctionConfigurations: Option[List[LambdaFunctionConfiguration]] = None
    ): NotificationConfiguration =
      NotificationConfiguration
        .builder
        .ifSome(topicConfigurations)(_.topicConfigurations(_))
        .ifSome(queueConfigurations)(_.queueConfigurations(_))
        .ifSome(lambdaFunctionConfigurations)(_.lambdaFunctionConfigurations(_))
        .build

    def notificationConfigurationDeprecated(
      topicConfiguration: Option[TopicConfigurationDeprecated] = None,
      queueConfiguration: Option[QueueConfigurationDeprecated] = None,
      cloudFunctionConfiguration: Option[CloudFunctionConfiguration] = None
    ): NotificationConfigurationDeprecated =
      NotificationConfigurationDeprecated
        .builder
        .ifSome(topicConfiguration)(_.topicConfiguration(_))
        .ifSome(queueConfiguration)(_.queueConfiguration(_))
        .ifSome(cloudFunctionConfiguration)(_.cloudFunctionConfiguration(_))
        .build

    def notificationConfigurationFilter(
      key: Option[S3KeyFilter] = None
    ): NotificationConfigurationFilter =
      NotificationConfigurationFilter
        .builder
        .ifSome(key)(_.key(_))
        .build

    def object(
      key: Option[String] = None,
      lastModified: Option[LastModified] = None,
      eTag: Option[String] = None,
      size: Option[Int] = None,
      storageClass: Option[String] = None,
      owner: Option[Owner] = None
    ): Object =
      Object
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(size)(_.size(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(owner)(_.owner(_))
        .build

    def objectAlreadyInActiveTierError(

    ): ObjectAlreadyInActiveTierError =
      ObjectAlreadyInActiveTierError
        .builder

        .build

    def objectIdentifier(
      key: Option[String] = None,
      versionId: Option[String] = None
    ): ObjectIdentifier =
      ObjectIdentifier
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def objectLockConfiguration(
      objectLockEnabled: Option[String] = None,
      rule: Option[ObjectLockRule] = None
    ): ObjectLockConfiguration =
      ObjectLockConfiguration
        .builder
        .ifSome(objectLockEnabled)(_.objectLockEnabled(_))
        .ifSome(rule)(_.rule(_))
        .build

    def objectLockLegalHold(
      status: Option[String] = None
    ): ObjectLockLegalHold =
      ObjectLockLegalHold
        .builder
        .ifSome(status)(_.status(_))
        .build

    def objectLockRetention(
      mode: Option[String] = None,
      retainUntilDate: Option[Date] = None
    ): ObjectLockRetention =
      ObjectLockRetention
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(retainUntilDate)(_.retainUntilDate(_))
        .build

    def objectLockRule(
      defaultRetention: Option[DefaultRetention] = None
    ): ObjectLockRule =
      ObjectLockRule
        .builder
        .ifSome(defaultRetention)(_.defaultRetention(_))
        .build

    def objectNotInActiveTierError(

    ): ObjectNotInActiveTierError =
      ObjectNotInActiveTierError
        .builder

        .build

    def objectVersion(
      eTag: Option[String] = None,
      size: Option[Int] = None,
      storageClass: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      isLatest: Option[Boolean] = None,
      lastModified: Option[LastModified] = None,
      owner: Option[Owner] = None
    ): ObjectVersion =
      ObjectVersion
        .builder
        .ifSome(eTag)(_.eTag(_))
        .ifSome(size)(_.size(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isLatest)(_.isLatest(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(owner)(_.owner(_))
        .build

    def outputLocation(
      s3: Option[S3Location] = None
    ): OutputLocation =
      OutputLocation
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def outputSerialization(
      cSV: Option[CSVOutput] = None,
      jSON: Option[JSONOutput] = None
    ): OutputSerialization =
      OutputSerialization
        .builder
        .ifSome(cSV)(_.cSV(_))
        .ifSome(jSON)(_.jSON(_))
        .build

    def owner(
      displayName: Option[String] = None,
      iD: Option[String] = None
    ): Owner =
      Owner
        .builder
        .ifSome(displayName)(_.displayName(_))
        .ifSome(iD)(_.iD(_))
        .build

    def ownershipControls(
      rules: Option[List[OwnershipControlsRule]] = None
    ): OwnershipControls =
      OwnershipControls
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def ownershipControlsRule(
      objectOwnership: Option[String] = None
    ): OwnershipControlsRule =
      OwnershipControlsRule
        .builder
        .ifSome(objectOwnership)(_.objectOwnership(_))
        .build

    def parquetInput(

    ): ParquetInput =
      ParquetInput
        .builder

        .build

    def part(
      partNumber: Option[Int] = None,
      lastModified: Option[LastModified] = None,
      eTag: Option[String] = None,
      size: Option[Int] = None
    ): Part =
      Part
        .builder
        .ifSome(partNumber)(_.partNumber(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(size)(_.size(_))
        .build

    def policyStatus(
      isPublic: Option[Boolean] = None
    ): PolicyStatus =
      PolicyStatus
        .builder
        .ifSome(isPublic)(_.isPublic(_))
        .build

    def progress(
      bytesScanned: Option[BytesScanned] = None,
      bytesProcessed: Option[BytesProcessed] = None,
      bytesReturned: Option[BytesReturned] = None
    ): Progress =
      Progress
        .builder
        .ifSome(bytesScanned)(_.bytesScanned(_))
        .ifSome(bytesProcessed)(_.bytesProcessed(_))
        .ifSome(bytesReturned)(_.bytesReturned(_))
        .build

    def progressEvent(
      details: Option[Progress] = None
    ): ProgressEvent =
      ProgressEvent
        .builder
        .ifSome(details)(_.details(_))
        .build

    def publicAccessBlockConfiguration(
      blockPublicAcls: Option[Boolean] = None,
      ignorePublicAcls: Option[Boolean] = None,
      blockPublicPolicy: Option[Boolean] = None,
      restrictPublicBuckets: Option[Boolean] = None
    ): PublicAccessBlockConfiguration =
      PublicAccessBlockConfiguration
        .builder
        .ifSome(blockPublicAcls)(_.blockPublicAcls(_))
        .ifSome(ignorePublicAcls)(_.ignorePublicAcls(_))
        .ifSome(blockPublicPolicy)(_.blockPublicPolicy(_))
        .ifSome(restrictPublicBuckets)(_.restrictPublicBuckets(_))
        .build

    def putBucketAccelerateConfigurationRequest(
      bucket: Option[String] = None,
      accelerateConfiguration: Option[AccelerateConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketAccelerateConfigurationRequest =
      PutBucketAccelerateConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(accelerateConfiguration)(_.accelerateConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketAclRequest(
      aCL: Option[String] = None,
      accessControlPolicy: Option[AccessControlPolicy] = None,
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      grantFullControl: Option[String] = None,
      grantRead: Option[String] = None,
      grantReadACP: Option[String] = None,
      grantWrite: Option[String] = None,
      grantWriteACP: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketAclRequest =
      PutBucketAclRequest
        .builder
        .ifSome(aCL)(_.aCL(_))
        .ifSome(accessControlPolicy)(_.accessControlPolicy(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(grantFullControl)(_.grantFullControl(_))
        .ifSome(grantRead)(_.grantRead(_))
        .ifSome(grantReadACP)(_.grantReadACP(_))
        .ifSome(grantWrite)(_.grantWrite(_))
        .ifSome(grantWriteACP)(_.grantWriteACP(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketAnalyticsConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      analyticsConfiguration: Option[AnalyticsConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketAnalyticsConfigurationRequest =
      PutBucketAnalyticsConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(analyticsConfiguration)(_.analyticsConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketCorsRequest(
      bucket: Option[String] = None,
      cORSConfiguration: Option[CORSConfiguration] = None,
      contentMD5: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketCorsRequest =
      PutBucketCorsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(cORSConfiguration)(_.cORSConfiguration(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketEncryptionRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      serverSideEncryptionConfiguration: Option[ServerSideEncryptionConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketEncryptionRequest =
      PutBucketEncryptionRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(serverSideEncryptionConfiguration)(_.serverSideEncryptionConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketIntelligentTieringConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      intelligentTieringConfiguration: Option[IntelligentTieringConfiguration] = None
    ): PutBucketIntelligentTieringConfigurationRequest =
      PutBucketIntelligentTieringConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(intelligentTieringConfiguration)(_.intelligentTieringConfiguration(_))
        .build

    def putBucketInventoryConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      inventoryConfiguration: Option[InventoryConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketInventoryConfigurationRequest =
      PutBucketInventoryConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(inventoryConfiguration)(_.inventoryConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketLifecycleConfigurationRequest(
      bucket: Option[String] = None,
      lifecycleConfiguration: Option[BucketLifecycleConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketLifecycleConfigurationRequest =
      PutBucketLifecycleConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(lifecycleConfiguration)(_.lifecycleConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketLifecycleRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      lifecycleConfiguration: Option[LifecycleConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketLifecycleRequest =
      PutBucketLifecycleRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(lifecycleConfiguration)(_.lifecycleConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketLoggingRequest(
      bucket: Option[String] = None,
      bucketLoggingStatus: Option[BucketLoggingStatus] = None,
      contentMD5: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketLoggingRequest =
      PutBucketLoggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(bucketLoggingStatus)(_.bucketLoggingStatus(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketMetricsConfigurationRequest(
      bucket: Option[String] = None,
      id: Option[String] = None,
      metricsConfiguration: Option[MetricsConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketMetricsConfigurationRequest =
      PutBucketMetricsConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(id)(_.id(_))
        .ifSome(metricsConfiguration)(_.metricsConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketNotificationConfigurationRequest(
      bucket: Option[String] = None,
      notificationConfiguration: Option[NotificationConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketNotificationConfigurationRequest =
      PutBucketNotificationConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketNotificationRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      notificationConfiguration: Option[NotificationConfigurationDeprecated] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketNotificationRequest =
      PutBucketNotificationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketOwnershipControlsRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      expectedBucketOwner: Option[String] = None,
      ownershipControls: Option[OwnershipControls] = None
    ): PutBucketOwnershipControlsRequest =
      PutBucketOwnershipControlsRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .ifSome(ownershipControls)(_.ownershipControls(_))
        .build

    def putBucketPolicyRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      confirmRemoveSelfBucketAccess: Option[Boolean] = None,
      policy: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketPolicyRequest =
      PutBucketPolicyRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(confirmRemoveSelfBucketAccess)(_.confirmRemoveSelfBucketAccess(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketReplicationRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      replicationConfiguration: Option[ReplicationConfiguration] = None,
      token: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketReplicationRequest =
      PutBucketReplicationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(replicationConfiguration)(_.replicationConfiguration(_))
        .ifSome(token)(_.token(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketRequestPaymentRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      requestPaymentConfiguration: Option[RequestPaymentConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketRequestPaymentRequest =
      PutBucketRequestPaymentRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(requestPaymentConfiguration)(_.requestPaymentConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketTaggingRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      tagging: Option[Tagging] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketTaggingRequest =
      PutBucketTaggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketVersioningRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      mFA: Option[String] = None,
      versioningConfiguration: Option[VersioningConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketVersioningRequest =
      PutBucketVersioningRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(mFA)(_.mFA(_))
        .ifSome(versioningConfiguration)(_.versioningConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putBucketWebsiteRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      websiteConfiguration: Option[WebsiteConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutBucketWebsiteRequest =
      PutBucketWebsiteRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(websiteConfiguration)(_.websiteConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putObjectAclOutput(
      requestCharged: Option[String] = None
    ): PutObjectAclOutput =
      PutObjectAclOutput
        .builder
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def putObjectAclRequest(
      aCL: Option[String] = None,
      accessControlPolicy: Option[AccessControlPolicy] = None,
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      grantFullControl: Option[String] = None,
      grantRead: Option[String] = None,
      grantReadACP: Option[String] = None,
      grantWrite: Option[String] = None,
      grantWriteACP: Option[String] = None,
      key: Option[String] = None,
      requestPayer: Option[String] = None,
      versionId: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutObjectAclRequest =
      PutObjectAclRequest
        .builder
        .ifSome(aCL)(_.aCL(_))
        .ifSome(accessControlPolicy)(_.accessControlPolicy(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(grantFullControl)(_.grantFullControl(_))
        .ifSome(grantRead)(_.grantRead(_))
        .ifSome(grantReadACP)(_.grantReadACP(_))
        .ifSome(grantWrite)(_.grantWrite(_))
        .ifSome(grantWriteACP)(_.grantWriteACP(_))
        .ifSome(key)(_.key(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putObjectLegalHoldOutput(
      requestCharged: Option[String] = None
    ): PutObjectLegalHoldOutput =
      PutObjectLegalHoldOutput
        .builder
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def putObjectLegalHoldRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      legalHold: Option[ObjectLockLegalHold] = None,
      requestPayer: Option[String] = None,
      versionId: Option[String] = None,
      contentMD5: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutObjectLegalHoldRequest =
      PutObjectLegalHoldRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(legalHold)(_.legalHold(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putObjectLockConfigurationOutput(
      requestCharged: Option[String] = None
    ): PutObjectLockConfigurationOutput =
      PutObjectLockConfigurationOutput
        .builder
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def putObjectLockConfigurationRequest(
      bucket: Option[String] = None,
      objectLockConfiguration: Option[ObjectLockConfiguration] = None,
      requestPayer: Option[String] = None,
      token: Option[String] = None,
      contentMD5: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutObjectLockConfigurationRequest =
      PutObjectLockConfigurationRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(objectLockConfiguration)(_.objectLockConfiguration(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(token)(_.token(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putObjectOutput(
      expiration: Option[String] = None,
      eTag: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      versionId: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSEKMSEncryptionContext: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestCharged: Option[String] = None
    ): PutObjectOutput =
      PutObjectOutput
        .builder
        .ifSome(expiration)(_.expiration(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSEKMSEncryptionContext)(_.sSEKMSEncryptionContext(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def putObjectRequest(
      aCL: Option[String] = None,
      body: Option[Body] = None,
      bucket: Option[String] = None,
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      contentLength: Option[ContentLength] = None,
      contentMD5: Option[String] = None,
      contentType: Option[String] = None,
      expires: Option[Expires] = None,
      grantFullControl: Option[String] = None,
      grantRead: Option[String] = None,
      grantReadACP: Option[String] = None,
      grantWriteACP: Option[String] = None,
      key: Option[String] = None,
      metadata: Option[Metadata] = None,
      serverSideEncryption: Option[String] = None,
      storageClass: Option[String] = None,
      websiteRedirectLocation: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSEKMSEncryptionContext: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestPayer: Option[String] = None,
      tagging: Option[String] = None,
      objectLockMode: Option[String] = None,
      objectLockRetainUntilDate: Option[ObjectLockRetainUntilDate] = None,
      objectLockLegalHoldStatus: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutObjectRequest =
      PutObjectRequest
        .builder
        .ifSome(aCL)(_.aCL(_))
        .ifSome(body)(_.body(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(grantFullControl)(_.grantFullControl(_))
        .ifSome(grantRead)(_.grantRead(_))
        .ifSome(grantReadACP)(_.grantReadACP(_))
        .ifSome(grantWriteACP)(_.grantWriteACP(_))
        .ifSome(key)(_.key(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(websiteRedirectLocation)(_.websiteRedirectLocation(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSEKMSEncryptionContext)(_.sSEKMSEncryptionContext(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putObjectRetentionOutput(
      requestCharged: Option[String] = None
    ): PutObjectRetentionOutput =
      PutObjectRetentionOutput
        .builder
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def putObjectRetentionRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      retention: Option[ObjectLockRetention] = None,
      requestPayer: Option[String] = None,
      versionId: Option[String] = None,
      bypassGovernanceRetention: Option[Boolean] = None,
      contentMD5: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): PutObjectRetentionRequest =
      PutObjectRetentionRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(retention)(_.retention(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def putObjectTaggingOutput(
      versionId: Option[String] = None
    ): PutObjectTaggingOutput =
      PutObjectTaggingOutput
        .builder
        .ifSome(versionId)(_.versionId(_))
        .build

    def putObjectTaggingRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      contentMD5: Option[String] = None,
      tagging: Option[Tagging] = None,
      expectedBucketOwner: Option[String] = None,
      requestPayer: Option[String] = None
    ): PutObjectTaggingRequest =
      PutObjectTaggingRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .build

    def putPublicAccessBlockRequest(
      bucket: Option[String] = None,
      contentMD5: Option[String] = None,
      publicAccessBlockConfiguration: Option[PublicAccessBlockConfiguration] = None,
      expectedBucketOwner: Option[String] = None
    ): PutPublicAccessBlockRequest =
      PutPublicAccessBlockRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(publicAccessBlockConfiguration)(_.publicAccessBlockConfiguration(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def queueConfiguration(
      id: Option[String] = None,
      queueArn: Option[String] = None,
      events: Option[List[Event]] = None,
      filter: Option[NotificationConfigurationFilter] = None
    ): QueueConfiguration =
      QueueConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(queueArn)(_.queueArn(_))
        .ifSome(events)(_.events(_))
        .ifSome(filter)(_.filter(_))
        .build

    def queueConfigurationDeprecated(
      id: Option[String] = None,
      event: Option[String] = None,
      events: Option[List[Event]] = None,
      queue: Option[String] = None
    ): QueueConfigurationDeprecated =
      QueueConfigurationDeprecated
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(event)(_.event(_))
        .ifSome(events)(_.events(_))
        .ifSome(queue)(_.queue(_))
        .build

    def recordsEvent(
      payload: Option[Body] = None
    ): RecordsEvent =
      RecordsEvent
        .builder
        .ifSome(payload)(_.payload(_))
        .build

    def redirect(
      hostName: Option[String] = None,
      httpRedirectCode: Option[String] = None,
      protocol: Option[String] = None,
      replaceKeyPrefixWith: Option[String] = None,
      replaceKeyWith: Option[String] = None
    ): Redirect =
      Redirect
        .builder
        .ifSome(hostName)(_.hostName(_))
        .ifSome(httpRedirectCode)(_.httpRedirectCode(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(replaceKeyPrefixWith)(_.replaceKeyPrefixWith(_))
        .ifSome(replaceKeyWith)(_.replaceKeyWith(_))
        .build

    def redirectAllRequestsTo(
      hostName: Option[String] = None,
      protocol: Option[String] = None
    ): RedirectAllRequestsTo =
      RedirectAllRequestsTo
        .builder
        .ifSome(hostName)(_.hostName(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def replicaModifications(
      status: Option[String] = None
    ): ReplicaModifications =
      ReplicaModifications
        .builder
        .ifSome(status)(_.status(_))
        .build

    def replicationConfiguration(
      role: Option[String] = None,
      rules: Option[List[ReplicationRule]] = None
    ): ReplicationConfiguration =
      ReplicationConfiguration
        .builder
        .ifSome(role)(_.role(_))
        .ifSome(rules)(_.rules(_))
        .build

    def replicationRule(
      iD: Option[String] = None,
      priority: Option[Int] = None,
      prefix: Option[String] = None,
      filter: Option[ReplicationRuleFilter] = None,
      status: Option[String] = None,
      sourceSelectionCriteria: Option[SourceSelectionCriteria] = None,
      existingObjectReplication: Option[ExistingObjectReplication] = None,
      destination: Option[Destination] = None,
      deleteMarkerReplication: Option[DeleteMarkerReplication] = None
    ): ReplicationRule =
      ReplicationRule
        .builder
        .ifSome(iD)(_.iD(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(status)(_.status(_))
        .ifSome(sourceSelectionCriteria)(_.sourceSelectionCriteria(_))
        .ifSome(existingObjectReplication)(_.existingObjectReplication(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(deleteMarkerReplication)(_.deleteMarkerReplication(_))
        .build

    def replicationRuleAndOperator(
      prefix: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ReplicationRuleAndOperator =
      ReplicationRuleAndOperator
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tags)(_.tags(_))
        .build

    def replicationRuleFilter(
      prefix: Option[String] = None,
      tag: Option[Tag] = None,
      and: Option[ReplicationRuleAndOperator] = None
    ): ReplicationRuleFilter =
      ReplicationRuleFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tag)(_.tag(_))
        .ifSome(and)(_.and(_))
        .build

    def replicationTime(
      status: Option[String] = None,
      time: Option[ReplicationTimeValue] = None
    ): ReplicationTime =
      ReplicationTime
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(time)(_.time(_))
        .build

    def replicationTimeValue(
      minutes: Option[Int] = None
    ): ReplicationTimeValue =
      ReplicationTimeValue
        .builder
        .ifSome(minutes)(_.minutes(_))
        .build

    def requestPaymentConfiguration(
      payer: Option[String] = None
    ): RequestPaymentConfiguration =
      RequestPaymentConfiguration
        .builder
        .ifSome(payer)(_.payer(_))
        .build

    def requestProgress(
      enabled: Option[Boolean] = None
    ): RequestProgress =
      RequestProgress
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def restoreObjectOutput(
      requestCharged: Option[String] = None,
      restoreOutputPath: Option[String] = None
    ): RestoreObjectOutput =
      RestoreObjectOutput
        .builder
        .ifSome(requestCharged)(_.requestCharged(_))
        .ifSome(restoreOutputPath)(_.restoreOutputPath(_))
        .build

    def restoreObjectRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      versionId: Option[String] = None,
      restoreRequest: Option[RestoreRequest] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): RestoreObjectRequest =
      RestoreObjectRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(restoreRequest)(_.restoreRequest(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def restoreRequest(
      days: Option[Int] = None,
      glacierJobParameters: Option[GlacierJobParameters] = None,
      `type`: Option[String] = None,
      tier: Option[String] = None,
      description: Option[String] = None,
      selectParameters: Option[SelectParameters] = None,
      outputLocation: Option[OutputLocation] = None
    ): RestoreRequest =
      RestoreRequest
        .builder
        .ifSome(days)(_.days(_))
        .ifSome(glacierJobParameters)(_.glacierJobParameters(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(description)(_.description(_))
        .ifSome(selectParameters)(_.selectParameters(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .build

    def routingRule(
      condition: Option[Condition] = None,
      redirect: Option[Redirect] = None
    ): RoutingRule =
      RoutingRule
        .builder
        .ifSome(condition)(_.condition(_))
        .ifSome(redirect)(_.redirect(_))
        .build

    def rule(
      expiration: Option[LifecycleExpiration] = None,
      iD: Option[String] = None,
      prefix: Option[String] = None,
      status: Option[String] = None,
      transition: Option[Transition] = None,
      noncurrentVersionTransition: Option[NoncurrentVersionTransition] = None,
      noncurrentVersionExpiration: Option[NoncurrentVersionExpiration] = None,
      abortIncompleteMultipartUpload: Option[AbortIncompleteMultipartUpload] = None
    ): Rule =
      Rule
        .builder
        .ifSome(expiration)(_.expiration(_))
        .ifSome(iD)(_.iD(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(status)(_.status(_))
        .ifSome(transition)(_.transition(_))
        .ifSome(noncurrentVersionTransition)(_.noncurrentVersionTransition(_))
        .ifSome(noncurrentVersionExpiration)(_.noncurrentVersionExpiration(_))
        .ifSome(abortIncompleteMultipartUpload)(_.abortIncompleteMultipartUpload(_))
        .build

    def s3KeyFilter(
      filterRules: Option[List[FilterRule]] = None
    ): S3KeyFilter =
      S3KeyFilter
        .builder
        .ifSome(filterRules)(_.filterRules(_))
        .build

    def s3Location(
      bucketName: Option[String] = None,
      prefix: Option[String] = None,
      encryption: Option[Encryption] = None,
      cannedACL: Option[String] = None,
      accessControlList: Option[List[Grant]] = None,
      tagging: Option[Tagging] = None,
      userMetadata: Option[List[MetadataEntry]] = None,
      storageClass: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(cannedACL)(_.cannedACL(_))
        .ifSome(accessControlList)(_.accessControlList(_))
        .ifSome(tagging)(_.tagging(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .ifSome(storageClass)(_.storageClass(_))
        .build

    def sSEKMS(
      keyId: Option[String] = None
    ): SSEKMS =
      SSEKMS
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def sSES3(

    ): SSES3 =
      SSES3
        .builder

        .build

    def scanRange(
      start: Option[Start] = None,
      end: Option[End] = None
    ): ScanRange =
      ScanRange
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .build

    def selectObjectContentEventStream(
      records: Option[RecordsEvent] = None,
      stats: Option[StatsEvent] = None,
      progress: Option[ProgressEvent] = None,
      cont: Option[ContinuationEvent] = None,
      end: Option[EndEvent] = None
    ): SelectObjectContentEventStream =
      SelectObjectContentEventStream
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(stats)(_.stats(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(cont)(_.cont(_))
        .ifSome(end)(_.end(_))
        .build

    def selectObjectContentOutput(
      payload: Option[SelectObjectContentEventStream] = None
    ): SelectObjectContentOutput =
      SelectObjectContentOutput
        .builder
        .ifSome(payload)(_.payload(_))
        .build

    def selectObjectContentRequest(
      bucket: Option[String] = None,
      key: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      expression: Option[String] = None,
      expressionType: Option[String] = None,
      requestProgress: Option[RequestProgress] = None,
      inputSerialization: Option[InputSerialization] = None,
      outputSerialization: Option[OutputSerialization] = None,
      scanRange: Option[ScanRange] = None,
      expectedBucketOwner: Option[String] = None
    ): SelectObjectContentRequest =
      SelectObjectContentRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(requestProgress)(_.requestProgress(_))
        .ifSome(inputSerialization)(_.inputSerialization(_))
        .ifSome(outputSerialization)(_.outputSerialization(_))
        .ifSome(scanRange)(_.scanRange(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def selectParameters(
      inputSerialization: Option[InputSerialization] = None,
      expressionType: Option[String] = None,
      expression: Option[String] = None,
      outputSerialization: Option[OutputSerialization] = None
    ): SelectParameters =
      SelectParameters
        .builder
        .ifSome(inputSerialization)(_.inputSerialization(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(outputSerialization)(_.outputSerialization(_))
        .build

    def serverSideEncryptionByDefault(
      sSEAlgorithm: Option[String] = None,
      kMSMasterKeyID: Option[String] = None
    ): ServerSideEncryptionByDefault =
      ServerSideEncryptionByDefault
        .builder
        .ifSome(sSEAlgorithm)(_.sSEAlgorithm(_))
        .ifSome(kMSMasterKeyID)(_.kMSMasterKeyID(_))
        .build

    def serverSideEncryptionConfiguration(
      rules: Option[List[ServerSideEncryptionRule]] = None
    ): ServerSideEncryptionConfiguration =
      ServerSideEncryptionConfiguration
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def serverSideEncryptionRule(
      applyServerSideEncryptionByDefault: Option[ServerSideEncryptionByDefault] = None,
      bucketKeyEnabled: Option[Boolean] = None
    ): ServerSideEncryptionRule =
      ServerSideEncryptionRule
        .builder
        .ifSome(applyServerSideEncryptionByDefault)(_.applyServerSideEncryptionByDefault(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .build

    def sourceSelectionCriteria(
      sseKmsEncryptedObjects: Option[SseKmsEncryptedObjects] = None,
      replicaModifications: Option[ReplicaModifications] = None
    ): SourceSelectionCriteria =
      SourceSelectionCriteria
        .builder
        .ifSome(sseKmsEncryptedObjects)(_.sseKmsEncryptedObjects(_))
        .ifSome(replicaModifications)(_.replicaModifications(_))
        .build

    def sseKmsEncryptedObjects(
      status: Option[String] = None
    ): SseKmsEncryptedObjects =
      SseKmsEncryptedObjects
        .builder
        .ifSome(status)(_.status(_))
        .build

    def stats(
      bytesScanned: Option[BytesScanned] = None,
      bytesProcessed: Option[BytesProcessed] = None,
      bytesReturned: Option[BytesReturned] = None
    ): Stats =
      Stats
        .builder
        .ifSome(bytesScanned)(_.bytesScanned(_))
        .ifSome(bytesProcessed)(_.bytesProcessed(_))
        .ifSome(bytesReturned)(_.bytesReturned(_))
        .build

    def statsEvent(
      details: Option[Stats] = None
    ): StatsEvent =
      StatsEvent
        .builder
        .ifSome(details)(_.details(_))
        .build

    def storageClassAnalysis(
      dataExport: Option[StorageClassAnalysisDataExport] = None
    ): StorageClassAnalysis =
      StorageClassAnalysis
        .builder
        .ifSome(dataExport)(_.dataExport(_))
        .build

    def storageClassAnalysisDataExport(
      outputSchemaVersion: Option[String] = None,
      destination: Option[AnalyticsExportDestination] = None
    ): StorageClassAnalysisDataExport =
      StorageClassAnalysisDataExport
        .builder
        .ifSome(outputSchemaVersion)(_.outputSchemaVersion(_))
        .ifSome(destination)(_.destination(_))
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

    def tagging(
      tagSet: Option[List[Tag]] = None
    ): Tagging =
      Tagging
        .builder
        .ifSome(tagSet)(_.tagSet(_))
        .build

    def targetGrant(
      grantee: Option[Grantee] = None,
      permission: Option[String] = None
    ): TargetGrant =
      TargetGrant
        .builder
        .ifSome(grantee)(_.grantee(_))
        .ifSome(permission)(_.permission(_))
        .build

    def tiering(
      days: Option[Int] = None,
      accessTier: Option[String] = None
    ): Tiering =
      Tiering
        .builder
        .ifSome(days)(_.days(_))
        .ifSome(accessTier)(_.accessTier(_))
        .build

    def topicConfiguration(
      id: Option[String] = None,
      topicArn: Option[String] = None,
      events: Option[List[Event]] = None,
      filter: Option[NotificationConfigurationFilter] = None
    ): TopicConfiguration =
      TopicConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(events)(_.events(_))
        .ifSome(filter)(_.filter(_))
        .build

    def topicConfigurationDeprecated(
      id: Option[String] = None,
      events: Option[List[Event]] = None,
      event: Option[String] = None,
      topic: Option[String] = None
    ): TopicConfigurationDeprecated =
      TopicConfigurationDeprecated
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(events)(_.events(_))
        .ifSome(event)(_.event(_))
        .ifSome(topic)(_.topic(_))
        .build

    def transition(
      date: Option[Date] = None,
      days: Option[Int] = None,
      storageClass: Option[String] = None
    ): Transition =
      Transition
        .builder
        .ifSome(date)(_.date(_))
        .ifSome(days)(_.days(_))
        .ifSome(storageClass)(_.storageClass(_))
        .build

    def uploadPartCopyOutput(
      copySourceVersionId: Option[String] = None,
      copyPartResult: Option[CopyPartResult] = None,
      serverSideEncryption: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestCharged: Option[String] = None
    ): UploadPartCopyOutput =
      UploadPartCopyOutput
        .builder
        .ifSome(copySourceVersionId)(_.copySourceVersionId(_))
        .ifSome(copyPartResult)(_.copyPartResult(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def uploadPartCopyRequest(
      bucket: Option[String] = None,
      copySource: Option[String] = None,
      copySourceIfMatch: Option[String] = None,
      copySourceIfModifiedSince: Option[CopySourceIfModifiedSince] = None,
      copySourceIfNoneMatch: Option[String] = None,
      copySourceIfUnmodifiedSince: Option[CopySourceIfUnmodifiedSince] = None,
      copySourceRange: Option[String] = None,
      key: Option[String] = None,
      partNumber: Option[Int] = None,
      uploadId: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      copySourceSSECustomerAlgorithm: Option[String] = None,
      copySourceSSECustomerKey: Option[String] = None,
      copySourceSSECustomerKeyMD5: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None,
      expectedSourceBucketOwner: Option[String] = None
    ): UploadPartCopyRequest =
      UploadPartCopyRequest
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(copySource)(_.copySource(_))
        .ifSome(copySourceIfMatch)(_.copySourceIfMatch(_))
        .ifSome(copySourceIfModifiedSince)(_.copySourceIfModifiedSince(_))
        .ifSome(copySourceIfNoneMatch)(_.copySourceIfNoneMatch(_))
        .ifSome(copySourceIfUnmodifiedSince)(_.copySourceIfUnmodifiedSince(_))
        .ifSome(copySourceRange)(_.copySourceRange(_))
        .ifSome(key)(_.key(_))
        .ifSome(partNumber)(_.partNumber(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(copySourceSSECustomerAlgorithm)(_.copySourceSSECustomerAlgorithm(_))
        .ifSome(copySourceSSECustomerKey)(_.copySourceSSECustomerKey(_))
        .ifSome(copySourceSSECustomerKeyMD5)(_.copySourceSSECustomerKeyMD5(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .ifSome(expectedSourceBucketOwner)(_.expectedSourceBucketOwner(_))
        .build

    def uploadPartOutput(
      serverSideEncryption: Option[String] = None,
      eTag: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None,
      requestCharged: Option[String] = None
    ): UploadPartOutput =
      UploadPartOutput
        .builder
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .build

    def uploadPartRequest(
      body: Option[Body] = None,
      bucket: Option[String] = None,
      contentLength: Option[ContentLength] = None,
      contentMD5: Option[String] = None,
      key: Option[String] = None,
      partNumber: Option[Int] = None,
      uploadId: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSECustomerKey: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      requestPayer: Option[String] = None,
      expectedBucketOwner: Option[String] = None
    ): UploadPartRequest =
      UploadPartRequest
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(key)(_.key(_))
        .ifSome(partNumber)(_.partNumber(_))
        .ifSome(uploadId)(_.uploadId(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSECustomerKey)(_.sSECustomerKey(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(requestPayer)(_.requestPayer(_))
        .ifSome(expectedBucketOwner)(_.expectedBucketOwner(_))
        .build

    def versioningConfiguration(
      mFADelete: Option[String] = None,
      status: Option[String] = None
    ): VersioningConfiguration =
      VersioningConfiguration
        .builder
        .ifSome(mFADelete)(_.mFADelete(_))
        .ifSome(status)(_.status(_))
        .build

    def websiteConfiguration(
      errorDocument: Option[ErrorDocument] = None,
      indexDocument: Option[IndexDocument] = None,
      redirectAllRequestsTo: Option[RedirectAllRequestsTo] = None,
      routingRules: Option[List[RoutingRule]] = None
    ): WebsiteConfiguration =
      WebsiteConfiguration
        .builder
        .ifSome(errorDocument)(_.errorDocument(_))
        .ifSome(indexDocument)(_.indexDocument(_))
        .ifSome(redirectAllRequestsTo)(_.redirectAllRequestsTo(_))
        .ifSome(routingRules)(_.routingRules(_))
        .build

    def writeGetObjectResponseRequest(
      requestRoute: Option[String] = None,
      requestToken: Option[String] = None,
      body: Option[Body] = None,
      statusCode: Option[Int] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      acceptRanges: Option[String] = None,
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      contentLength: Option[ContentLength] = None,
      contentRange: Option[String] = None,
      contentType: Option[String] = None,
      deleteMarker: Option[Boolean] = None,
      eTag: Option[String] = None,
      expires: Option[Expires] = None,
      expiration: Option[String] = None,
      lastModified: Option[LastModified] = None,
      missingMeta: Option[Int] = None,
      metadata: Option[Metadata] = None,
      objectLockMode: Option[String] = None,
      objectLockLegalHoldStatus: Option[String] = None,
      objectLockRetainUntilDate: Option[ObjectLockRetainUntilDate] = None,
      partsCount: Option[Int] = None,
      replicationStatus: Option[String] = None,
      requestCharged: Option[String] = None,
      restore: Option[String] = None,
      serverSideEncryption: Option[String] = None,
      sSECustomerAlgorithm: Option[String] = None,
      sSEKMSKeyId: Option[String] = None,
      sSECustomerKeyMD5: Option[String] = None,
      storageClass: Option[String] = None,
      tagCount: Option[Int] = None,
      versionId: Option[String] = None,
      bucketKeyEnabled: Option[Boolean] = None
    ): WriteGetObjectResponseRequest =
      WriteGetObjectResponseRequest
        .builder
        .ifSome(requestRoute)(_.requestRoute(_))
        .ifSome(requestToken)(_.requestToken(_))
        .ifSome(body)(_.body(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(acceptRanges)(_.acceptRanges(_))
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(contentRange)(_.contentRange(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(deleteMarker)(_.deleteMarker(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(missingMeta)(_.missingMeta(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(partsCount)(_.partsCount(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .ifSome(requestCharged)(_.requestCharged(_))
        .ifSome(restore)(_.restore(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(sSECustomerAlgorithm)(_.sSECustomerAlgorithm(_))
        .ifSome(sSEKMSKeyId)(_.sSEKMSKeyId(_))
        .ifSome(sSECustomerKeyMD5)(_.sSECustomerKeyMD5(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(tagCount)(_.tagCount(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
