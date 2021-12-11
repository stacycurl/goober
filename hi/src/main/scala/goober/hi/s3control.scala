package goober.hi

import goober.free.s3control.S3ControlIO
import software.amazon.awssdk.services.s3control.model._


object s3control {
  import goober.free.{s3control ⇒ free}

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

    def accessPoint(
      name: Option[String] = None,
      networkOrigin: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None,
      bucket: Option[String] = None,
      accessPointArn: Option[String] = None
    ): AccessPoint =
      AccessPoint
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(networkOrigin)(_.networkOrigin(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(accessPointArn)(_.accessPointArn(_))
        .build

    def accountLevel(
      activityMetrics: Option[ActivityMetrics] = None,
      bucketLevel: Option[BucketLevel] = None
    ): AccountLevel =
      AccountLevel
        .builder
        .ifSome(activityMetrics)(_.activityMetrics(_))
        .ifSome(bucketLevel)(_.bucketLevel(_))
        .build

    def activityMetrics(
      isEnabled: Option[Boolean] = None
    ): ActivityMetrics =
      ActivityMetrics
        .builder
        .ifSome(isEnabled)(_.isEnabled(_))
        .build

    def awsLambdaTransformation(
      functionArn: Option[String] = None,
      functionPayload: Option[String] = None
    ): AwsLambdaTransformation =
      AwsLambdaTransformation
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(functionPayload)(_.functionPayload(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
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

    def bucketLevel(
      activityMetrics: Option[ActivityMetrics] = None,
      prefixLevel: Option[PrefixLevel] = None
    ): BucketLevel =
      BucketLevel
        .builder
        .ifSome(activityMetrics)(_.activityMetrics(_))
        .ifSome(prefixLevel)(_.prefixLevel(_))
        .build

    def createAccessPointForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      configuration: Option[ObjectLambdaConfiguration] = None
    ): CreateAccessPointForObjectLambdaRequest =
      CreateAccessPointForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def createAccessPointRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      bucket: Option[String] = None,
      vpcConfiguration: Option[VpcConfiguration] = None,
      publicAccessBlockConfiguration: Option[PublicAccessBlockConfiguration] = None
    ): CreateAccessPointRequest =
      CreateAccessPointRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(publicAccessBlockConfiguration)(_.publicAccessBlockConfiguration(_))
        .build

    def createBucketConfiguration(
      locationConstraint: Option[String] = None
    ): CreateBucketConfiguration =
      CreateBucketConfiguration
        .builder
        .ifSome(locationConstraint)(_.locationConstraint(_))
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
      objectLockEnabledForBucket: Option[Boolean] = None,
      outpostId: Option[String] = None
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
        .ifSome(outpostId)(_.outpostId(_))
        .build

    def createJobRequest(
      accountId: Option[String] = None,
      confirmationRequired: Option[Boolean] = None,
      operation: Option[JobOperation] = None,
      report: Option[JobReport] = None,
      clientRequestToken: Option[String] = None,
      manifest: Option[JobManifest] = None,
      description: Option[String] = None,
      priority: Option[Int] = None,
      roleArn: Option[String] = None,
      tags: Option[List[S3Tag]] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(confirmationRequired)(_.confirmationRequired(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(report)(_.report(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(manifest)(_.manifest(_))
        .ifSome(description)(_.description(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteAccessPointForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): DeleteAccessPointForObjectLambdaRequest =
      DeleteAccessPointForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteAccessPointPolicyForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): DeleteAccessPointPolicyForObjectLambdaRequest =
      DeleteAccessPointPolicyForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteAccessPointPolicyRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): DeleteAccessPointPolicyRequest =
      DeleteAccessPointPolicyRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteAccessPointRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): DeleteAccessPointRequest =
      DeleteAccessPointRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteBucketLifecycleConfigurationRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): DeleteBucketLifecycleConfigurationRequest =
      DeleteBucketLifecycleConfigurationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def deleteBucketPolicyRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): DeleteBucketPolicyRequest =
      DeleteBucketPolicyRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def deleteBucketRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): DeleteBucketRequest =
      DeleteBucketRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def deleteBucketTaggingRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): DeleteBucketTaggingRequest =
      DeleteBucketTaggingRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def deleteJobTaggingRequest(
      accountId: Option[String] = None,
      jobId: Option[String] = None
    ): DeleteJobTaggingRequest =
      DeleteJobTaggingRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def deletePublicAccessBlockRequest(
      accountId: Option[String] = None
    ): DeletePublicAccessBlockRequest =
      DeletePublicAccessBlockRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def deleteStorageLensConfigurationRequest(
      configId: Option[String] = None,
      accountId: Option[String] = None
    ): DeleteStorageLensConfigurationRequest =
      DeleteStorageLensConfigurationRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def deleteStorageLensConfigurationTaggingRequest(
      configId: Option[String] = None,
      accountId: Option[String] = None
    ): DeleteStorageLensConfigurationTaggingRequest =
      DeleteStorageLensConfigurationTaggingRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def describeJobRequest(
      accountId: Option[String] = None,
      jobId: Option[String] = None
    ): DescribeJobRequest =
      DescribeJobRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def exclude(
      buckets: Option[List[S3BucketArnString]] = None,
      regions: Option[List[S3AWSRegion]] = None
    ): Exclude =
      Exclude
        .builder
        .ifSome(buckets)(_.buckets(_))
        .ifSome(regions)(_.regions(_))
        .build

    def getAccessPointConfigurationForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointConfigurationForObjectLambdaRequest =
      GetAccessPointConfigurationForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getAccessPointForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointForObjectLambdaRequest =
      GetAccessPointForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getAccessPointPolicyForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointPolicyForObjectLambdaRequest =
      GetAccessPointPolicyForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getAccessPointPolicyRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointPolicyRequest =
      GetAccessPointPolicyRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getAccessPointPolicyStatusForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointPolicyStatusForObjectLambdaRequest =
      GetAccessPointPolicyStatusForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getAccessPointPolicyStatusRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointPolicyStatusRequest =
      GetAccessPointPolicyStatusRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getAccessPointRequest(
      accountId: Option[String] = None,
      name: Option[String] = None
    ): GetAccessPointRequest =
      GetAccessPointRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .build

    def getBucketLifecycleConfigurationRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): GetBucketLifecycleConfigurationRequest =
      GetBucketLifecycleConfigurationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def getBucketPolicyRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): GetBucketPolicyRequest =
      GetBucketPolicyRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def getBucketRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): GetBucketRequest =
      GetBucketRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def getBucketTaggingRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None
    ): GetBucketTaggingRequest =
      GetBucketTaggingRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .build

    def getJobTaggingRequest(
      accountId: Option[String] = None,
      jobId: Option[String] = None
    ): GetJobTaggingRequest =
      GetJobTaggingRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def getPublicAccessBlockOutput(
      publicAccessBlockConfiguration: Option[PublicAccessBlockConfiguration] = None
    ): GetPublicAccessBlockOutput =
      GetPublicAccessBlockOutput
        .builder
        .ifSome(publicAccessBlockConfiguration)(_.publicAccessBlockConfiguration(_))
        .build

    def getPublicAccessBlockRequest(
      accountId: Option[String] = None
    ): GetPublicAccessBlockRequest =
      GetPublicAccessBlockRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def getStorageLensConfigurationRequest(
      configId: Option[String] = None,
      accountId: Option[String] = None
    ): GetStorageLensConfigurationRequest =
      GetStorageLensConfigurationRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def getStorageLensConfigurationTaggingRequest(
      configId: Option[String] = None,
      accountId: Option[String] = None
    ): GetStorageLensConfigurationTaggingRequest =
      GetStorageLensConfigurationTaggingRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def idempotencyException(
      message: Option[String] = None
    ): IdempotencyException =
      IdempotencyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def include(
      buckets: Option[List[S3BucketArnString]] = None,
      regions: Option[List[S3AWSRegion]] = None
    ): Include =
      Include
        .builder
        .ifSome(buckets)(_.buckets(_))
        .ifSome(regions)(_.regions(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jobDescriptor(
      jobId: Option[String] = None,
      confirmationRequired: Option[Boolean] = None,
      description: Option[String] = None,
      jobArn: Option[String] = None,
      status: Option[String] = None,
      manifest: Option[JobManifest] = None,
      operation: Option[JobOperation] = None,
      priority: Option[Int] = None,
      progressSummary: Option[JobProgressSummary] = None,
      statusUpdateReason: Option[String] = None,
      failureReasons: Option[List[JobFailure]] = None,
      report: Option[JobReport] = None,
      creationTime: Option[JobCreationTime] = None,
      terminationDate: Option[JobTerminationDate] = None,
      roleArn: Option[String] = None,
      suspendedDate: Option[SuspendedDate] = None,
      suspendedCause: Option[String] = None
    ): JobDescriptor =
      JobDescriptor
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(confirmationRequired)(_.confirmationRequired(_))
        .ifSome(description)(_.description(_))
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(manifest)(_.manifest(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(progressSummary)(_.progressSummary(_))
        .ifSome(statusUpdateReason)(_.statusUpdateReason(_))
        .ifSome(failureReasons)(_.failureReasons(_))
        .ifSome(report)(_.report(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(terminationDate)(_.terminationDate(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(suspendedDate)(_.suspendedDate(_))
        .ifSome(suspendedCause)(_.suspendedCause(_))
        .build

    def jobFailure(
      failureCode: Option[String] = None,
      failureReason: Option[String] = None
    ): JobFailure =
      JobFailure
        .builder
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def jobListDescriptor(
      jobId: Option[String] = None,
      description: Option[String] = None,
      operation: Option[String] = None,
      priority: Option[Int] = None,
      status: Option[String] = None,
      creationTime: Option[JobCreationTime] = None,
      terminationDate: Option[JobTerminationDate] = None,
      progressSummary: Option[JobProgressSummary] = None
    ): JobListDescriptor =
      JobListDescriptor
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(description)(_.description(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(terminationDate)(_.terminationDate(_))
        .ifSome(progressSummary)(_.progressSummary(_))
        .build

    def jobManifest(
      spec: Option[JobManifestSpec] = None,
      location: Option[JobManifestLocation] = None
    ): JobManifest =
      JobManifest
        .builder
        .ifSome(spec)(_.spec(_))
        .ifSome(location)(_.location(_))
        .build

    def jobManifestLocation(
      objectArn: Option[String] = None,
      objectVersionId: Option[String] = None,
      eTag: Option[String] = None
    ): JobManifestLocation =
      JobManifestLocation
        .builder
        .ifSome(objectArn)(_.objectArn(_))
        .ifSome(objectVersionId)(_.objectVersionId(_))
        .ifSome(eTag)(_.eTag(_))
        .build

    def jobManifestSpec(
      format: Option[String] = None,
      fields: Option[List[JobManifestFieldName]] = None
    ): JobManifestSpec =
      JobManifestSpec
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(fields)(_.fields(_))
        .build

    def jobOperation(
      lambdaInvoke: Option[LambdaInvokeOperation] = None,
      s3PutObjectCopy: Option[S3CopyObjectOperation] = None,
      s3PutObjectAcl: Option[S3SetObjectAclOperation] = None,
      s3PutObjectTagging: Option[S3SetObjectTaggingOperation] = None,
      s3DeleteObjectTagging: Option[S3DeleteObjectTaggingOperation] = None,
      s3InitiateRestoreObject: Option[S3InitiateRestoreObjectOperation] = None,
      s3PutObjectLegalHold: Option[S3SetObjectLegalHoldOperation] = None,
      s3PutObjectRetention: Option[S3SetObjectRetentionOperation] = None
    ): JobOperation =
      JobOperation
        .builder
        .ifSome(lambdaInvoke)(_.lambdaInvoke(_))
        .ifSome(s3PutObjectCopy)(_.s3PutObjectCopy(_))
        .ifSome(s3PutObjectAcl)(_.s3PutObjectAcl(_))
        .ifSome(s3PutObjectTagging)(_.s3PutObjectTagging(_))
        .ifSome(s3DeleteObjectTagging)(_.s3DeleteObjectTagging(_))
        .ifSome(s3InitiateRestoreObject)(_.s3InitiateRestoreObject(_))
        .ifSome(s3PutObjectLegalHold)(_.s3PutObjectLegalHold(_))
        .ifSome(s3PutObjectRetention)(_.s3PutObjectRetention(_))
        .build

    def jobProgressSummary(
      totalNumberOfTasks: Option[JobTotalNumberOfTasks] = None,
      numberOfTasksSucceeded: Option[JobNumberOfTasksSucceeded] = None,
      numberOfTasksFailed: Option[JobNumberOfTasksFailed] = None
    ): JobProgressSummary =
      JobProgressSummary
        .builder
        .ifSome(totalNumberOfTasks)(_.totalNumberOfTasks(_))
        .ifSome(numberOfTasksSucceeded)(_.numberOfTasksSucceeded(_))
        .ifSome(numberOfTasksFailed)(_.numberOfTasksFailed(_))
        .build

    def jobReport(
      bucket: Option[String] = None,
      format: Option[String] = None,
      enabled: Option[Boolean] = None,
      prefix: Option[String] = None,
      reportScope: Option[String] = None
    ): JobReport =
      JobReport
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(format)(_.format(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(reportScope)(_.reportScope(_))
        .build

    def jobStatusException(
      message: Option[String] = None
    ): JobStatusException =
      JobStatusException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lambdaInvokeOperation(
      functionArn: Option[String] = None
    ): LambdaInvokeOperation =
      LambdaInvokeOperation
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .build

    def lifecycleConfiguration(
      rules: Option[List[LifecycleRule]] = None
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
        .ifSome(filter)(_.filter(_))
        .ifSome(status)(_.status(_))
        .ifSome(transitions)(_.transitions(_))
        .ifSome(noncurrentVersionTransitions)(_.noncurrentVersionTransitions(_))
        .ifSome(noncurrentVersionExpiration)(_.noncurrentVersionExpiration(_))
        .ifSome(abortIncompleteMultipartUpload)(_.abortIncompleteMultipartUpload(_))
        .build

    def lifecycleRuleAndOperator(
      prefix: Option[String] = None,
      tags: Option[List[S3Tag]] = None
    ): LifecycleRuleAndOperator =
      LifecycleRuleAndOperator
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tags)(_.tags(_))
        .build

    def lifecycleRuleFilter(
      prefix: Option[String] = None,
      tag: Option[S3Tag] = None,
      and: Option[LifecycleRuleAndOperator] = None
    ): LifecycleRuleFilter =
      LifecycleRuleFilter
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(tag)(_.tag(_))
        .ifSome(and)(_.and(_))
        .build

    def listAccessPointsForObjectLambdaRequest(
      accountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccessPointsForObjectLambdaRequest =
      ListAccessPointsForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAccessPointsRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccessPointsRequest =
      ListAccessPointsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listJobsRequest(
      accountId: Option[String] = None,
      jobStatuses: Option[List[JobStatus]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobStatuses)(_.jobStatuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRegionalBucketsRequest(
      accountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      outpostId: Option[String] = None
    ): ListRegionalBucketsRequest =
      ListRegionalBucketsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(outpostId)(_.outpostId(_))
        .build

    def listStorageLensConfigurationEntry(
      id: Option[String] = None,
      storageLensArn: Option[String] = None,
      homeRegion: Option[String] = None,
      isEnabled: Option[Boolean] = None
    ): ListStorageLensConfigurationEntry =
      ListStorageLensConfigurationEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(storageLensArn)(_.storageLensArn(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(isEnabled)(_.isEnabled(_))
        .build

    def listStorageLensConfigurationsRequest(
      accountId: Option[String] = None,
      nextToken: Option[String] = None
    ): ListStorageLensConfigurationsRequest =
      ListStorageLensConfigurationsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def noSuchPublicAccessBlockConfiguration(
      message: Option[String] = None
    ): NoSuchPublicAccessBlockConfiguration =
      NoSuchPublicAccessBlockConfiguration
        .builder
        .ifSome(message)(_.message(_))
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

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def objectLambdaAccessPoint(
      name: Option[String] = None,
      objectLambdaAccessPointArn: Option[String] = None
    ): ObjectLambdaAccessPoint =
      ObjectLambdaAccessPoint
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(objectLambdaAccessPointArn)(_.objectLambdaAccessPointArn(_))
        .build

    def objectLambdaConfiguration(
      supportingAccessPoint: Option[String] = None,
      cloudWatchMetricsEnabled: Option[Boolean] = None,
      allowedFeatures: Option[List[ObjectLambdaAllowedFeature]] = None,
      transformationConfigurations: Option[List[ObjectLambdaTransformationConfiguration]] = None
    ): ObjectLambdaConfiguration =
      ObjectLambdaConfiguration
        .builder
        .ifSome(supportingAccessPoint)(_.supportingAccessPoint(_))
        .ifSome(cloudWatchMetricsEnabled)(_.cloudWatchMetricsEnabled(_))
        .ifSome(allowedFeatures)(_.allowedFeatures(_))
        .ifSome(transformationConfigurations)(_.transformationConfigurations(_))
        .build

    def objectLambdaContentTransformation(
      awsLambda: Option[AwsLambdaTransformation] = None
    ): ObjectLambdaContentTransformation =
      ObjectLambdaContentTransformation
        .builder
        .ifSome(awsLambda)(_.awsLambda(_))
        .build

    def objectLambdaTransformationConfiguration(
      actions: Option[List[ObjectLambdaTransformationConfigurationAction]] = None,
      contentTransformation: Option[ObjectLambdaContentTransformation] = None
    ): ObjectLambdaTransformationConfiguration =
      ObjectLambdaTransformationConfiguration
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(contentTransformation)(_.contentTransformation(_))
        .build

    def policyStatus(
      isPublic: Option[Boolean] = None
    ): PolicyStatus =
      PolicyStatus
        .builder
        .ifSome(isPublic)(_.isPublic(_))
        .build

    def prefixLevel(
      storageMetrics: Option[PrefixLevelStorageMetrics] = None
    ): PrefixLevel =
      PrefixLevel
        .builder
        .ifSome(storageMetrics)(_.storageMetrics(_))
        .build

    def prefixLevelStorageMetrics(
      isEnabled: Option[Boolean] = None,
      selectionCriteria: Option[SelectionCriteria] = None
    ): PrefixLevelStorageMetrics =
      PrefixLevelStorageMetrics
        .builder
        .ifSome(isEnabled)(_.isEnabled(_))
        .ifSome(selectionCriteria)(_.selectionCriteria(_))
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

    def putAccessPointConfigurationForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      configuration: Option[ObjectLambdaConfiguration] = None
    ): PutAccessPointConfigurationForObjectLambdaRequest =
      PutAccessPointConfigurationForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def putAccessPointPolicyForObjectLambdaRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      policy: Option[String] = None
    ): PutAccessPointPolicyForObjectLambdaRequest =
      PutAccessPointPolicyForObjectLambdaRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putAccessPointPolicyRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      policy: Option[String] = None
    ): PutAccessPointPolicyRequest =
      PutAccessPointPolicyRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putBucketLifecycleConfigurationRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None,
      lifecycleConfiguration: Option[LifecycleConfiguration] = None
    ): PutBucketLifecycleConfigurationRequest =
      PutBucketLifecycleConfigurationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(lifecycleConfiguration)(_.lifecycleConfiguration(_))
        .build

    def putBucketPolicyRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None,
      confirmRemoveSelfBucketAccess: Option[Boolean] = None,
      policy: Option[String] = None
    ): PutBucketPolicyRequest =
      PutBucketPolicyRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(confirmRemoveSelfBucketAccess)(_.confirmRemoveSelfBucketAccess(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putBucketTaggingRequest(
      accountId: Option[String] = None,
      bucket: Option[String] = None,
      tagging: Option[Tagging] = None
    ): PutBucketTaggingRequest =
      PutBucketTaggingRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucket)(_.bucket(_))
        .ifSome(tagging)(_.tagging(_))
        .build

    def putJobTaggingRequest(
      accountId: Option[String] = None,
      jobId: Option[String] = None,
      tags: Option[List[S3Tag]] = None
    ): PutJobTaggingRequest =
      PutJobTaggingRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putPublicAccessBlockRequest(
      publicAccessBlockConfiguration: Option[PublicAccessBlockConfiguration] = None,
      accountId: Option[String] = None
    ): PutPublicAccessBlockRequest =
      PutPublicAccessBlockRequest
        .builder
        .ifSome(publicAccessBlockConfiguration)(_.publicAccessBlockConfiguration(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def putStorageLensConfigurationRequest(
      configId: Option[String] = None,
      accountId: Option[String] = None,
      storageLensConfiguration: Option[StorageLensConfiguration] = None,
      tags: Option[List[StorageLensTag]] = None
    ): PutStorageLensConfigurationRequest =
      PutStorageLensConfigurationRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(storageLensConfiguration)(_.storageLensConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putStorageLensConfigurationTaggingRequest(
      configId: Option[String] = None,
      accountId: Option[String] = None,
      tags: Option[List[StorageLensTag]] = None
    ): PutStorageLensConfigurationTaggingRequest =
      PutStorageLensConfigurationTaggingRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def regionalBucket(
      bucket: Option[String] = None,
      bucketArn: Option[String] = None,
      publicAccessBlockEnabled: Option[Boolean] = None,
      creationDate: Option[CreationDate] = None,
      outpostId: Option[String] = None
    ): RegionalBucket =
      RegionalBucket
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(bucketArn)(_.bucketArn(_))
        .ifSome(publicAccessBlockEnabled)(_.publicAccessBlockEnabled(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(outpostId)(_.outpostId(_))
        .build

    def s3AccessControlList(
      owner: Option[S3ObjectOwner] = None,
      grants: Option[List[S3Grant]] = None
    ): S3AccessControlList =
      S3AccessControlList
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(grants)(_.grants(_))
        .build

    def s3AccessControlPolicy(
      accessControlList: Option[S3AccessControlList] = None,
      cannedAccessControlList: Option[String] = None
    ): S3AccessControlPolicy =
      S3AccessControlPolicy
        .builder
        .ifSome(accessControlList)(_.accessControlList(_))
        .ifSome(cannedAccessControlList)(_.cannedAccessControlList(_))
        .build

    def s3BucketDestination(
      format: Option[String] = None,
      outputSchemaVersion: Option[String] = None,
      accountId: Option[String] = None,
      arn: Option[String] = None,
      prefix: Option[String] = None,
      encryption: Option[StorageLensDataExportEncryption] = None
    ): S3BucketDestination =
      S3BucketDestination
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(outputSchemaVersion)(_.outputSchemaVersion(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def s3CopyObjectOperation(
      targetResource: Option[String] = None,
      cannedAccessControlList: Option[String] = None,
      accessControlGrants: Option[List[S3Grant]] = None,
      metadataDirective: Option[String] = None,
      modifiedSinceConstraint: Option[TimeStamp] = None,
      newObjectMetadata: Option[S3ObjectMetadata] = None,
      newObjectTagging: Option[List[S3Tag]] = None,
      redirectLocation: Option[String] = None,
      requesterPays: Option[Boolean] = None,
      storageClass: Option[String] = None,
      unModifiedSinceConstraint: Option[TimeStamp] = None,
      sSEAwsKmsKeyId: Option[String] = None,
      targetKeyPrefix: Option[String] = None,
      objectLockLegalHoldStatus: Option[String] = None,
      objectLockMode: Option[String] = None,
      objectLockRetainUntilDate: Option[TimeStamp] = None,
      bucketKeyEnabled: Option[Boolean] = None
    ): S3CopyObjectOperation =
      S3CopyObjectOperation
        .builder
        .ifSome(targetResource)(_.targetResource(_))
        .ifSome(cannedAccessControlList)(_.cannedAccessControlList(_))
        .ifSome(accessControlGrants)(_.accessControlGrants(_))
        .ifSome(metadataDirective)(_.metadataDirective(_))
        .ifSome(modifiedSinceConstraint)(_.modifiedSinceConstraint(_))
        .ifSome(newObjectMetadata)(_.newObjectMetadata(_))
        .ifSome(newObjectTagging)(_.newObjectTagging(_))
        .ifSome(redirectLocation)(_.redirectLocation(_))
        .ifSome(requesterPays)(_.requesterPays(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(unModifiedSinceConstraint)(_.unModifiedSinceConstraint(_))
        .ifSome(sSEAwsKmsKeyId)(_.sSEAwsKmsKeyId(_))
        .ifSome(targetKeyPrefix)(_.targetKeyPrefix(_))
        .ifSome(objectLockLegalHoldStatus)(_.objectLockLegalHoldStatus(_))
        .ifSome(objectLockMode)(_.objectLockMode(_))
        .ifSome(objectLockRetainUntilDate)(_.objectLockRetainUntilDate(_))
        .ifSome(bucketKeyEnabled)(_.bucketKeyEnabled(_))
        .build

    def s3DeleteObjectTaggingOperation(

    ): S3DeleteObjectTaggingOperation =
      S3DeleteObjectTaggingOperation
        .builder

        .build

    def s3Grant(
      grantee: Option[S3Grantee] = None,
      permission: Option[String] = None
    ): S3Grant =
      S3Grant
        .builder
        .ifSome(grantee)(_.grantee(_))
        .ifSome(permission)(_.permission(_))
        .build

    def s3Grantee(
      typeIdentifier: Option[String] = None,
      identifier: Option[String] = None,
      displayName: Option[String] = None
    ): S3Grantee =
      S3Grantee
        .builder
        .ifSome(typeIdentifier)(_.typeIdentifier(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def s3InitiateRestoreObjectOperation(
      expirationInDays: Option[Int] = None,
      glacierJobTier: Option[String] = None
    ): S3InitiateRestoreObjectOperation =
      S3InitiateRestoreObjectOperation
        .builder
        .ifSome(expirationInDays)(_.expirationInDays(_))
        .ifSome(glacierJobTier)(_.glacierJobTier(_))
        .build

    def s3ObjectLockLegalHold(
      status: Option[String] = None
    ): S3ObjectLockLegalHold =
      S3ObjectLockLegalHold
        .builder
        .ifSome(status)(_.status(_))
        .build

    def s3ObjectMetadata(
      cacheControl: Option[String] = None,
      contentDisposition: Option[String] = None,
      contentEncoding: Option[String] = None,
      contentLanguage: Option[String] = None,
      userMetadata: Option[S3UserMetadata] = None,
      contentLength: Option[S3ContentLength] = None,
      contentMD5: Option[String] = None,
      contentType: Option[String] = None,
      httpExpiresDate: Option[TimeStamp] = None,
      requesterCharged: Option[Boolean] = None,
      sSEAlgorithm: Option[String] = None
    ): S3ObjectMetadata =
      S3ObjectMetadata
        .builder
        .ifSome(cacheControl)(_.cacheControl(_))
        .ifSome(contentDisposition)(_.contentDisposition(_))
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(contentLanguage)(_.contentLanguage(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(contentMD5)(_.contentMD5(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(httpExpiresDate)(_.httpExpiresDate(_))
        .ifSome(requesterCharged)(_.requesterCharged(_))
        .ifSome(sSEAlgorithm)(_.sSEAlgorithm(_))
        .build

    def s3ObjectOwner(
      iD: Option[String] = None,
      displayName: Option[String] = None
    ): S3ObjectOwner =
      S3ObjectOwner
        .builder
        .ifSome(iD)(_.iD(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def s3Retention(
      retainUntilDate: Option[TimeStamp] = None,
      mode: Option[String] = None
    ): S3Retention =
      S3Retention
        .builder
        .ifSome(retainUntilDate)(_.retainUntilDate(_))
        .ifSome(mode)(_.mode(_))
        .build

    def s3SetObjectAclOperation(
      accessControlPolicy: Option[S3AccessControlPolicy] = None
    ): S3SetObjectAclOperation =
      S3SetObjectAclOperation
        .builder
        .ifSome(accessControlPolicy)(_.accessControlPolicy(_))
        .build

    def s3SetObjectLegalHoldOperation(
      legalHold: Option[S3ObjectLockLegalHold] = None
    ): S3SetObjectLegalHoldOperation =
      S3SetObjectLegalHoldOperation
        .builder
        .ifSome(legalHold)(_.legalHold(_))
        .build

    def s3SetObjectRetentionOperation(
      bypassGovernanceRetention: Option[Boolean] = None,
      retention: Option[S3Retention] = None
    ): S3SetObjectRetentionOperation =
      S3SetObjectRetentionOperation
        .builder
        .ifSome(bypassGovernanceRetention)(_.bypassGovernanceRetention(_))
        .ifSome(retention)(_.retention(_))
        .build

    def s3SetObjectTaggingOperation(
      tagSet: Option[List[S3Tag]] = None
    ): S3SetObjectTaggingOperation =
      S3SetObjectTaggingOperation
        .builder
        .ifSome(tagSet)(_.tagSet(_))
        .build

    def s3Tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): S3Tag =
      S3Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
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

    def selectionCriteria(
      delimiter: Option[String] = None,
      maxDepth: Option[Int] = None,
      minStorageBytesPercentage: Option[MinStorageBytesPercentage] = None
    ): SelectionCriteria =
      SelectionCriteria
        .builder
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(maxDepth)(_.maxDepth(_))
        .ifSome(minStorageBytesPercentage)(_.minStorageBytesPercentage(_))
        .build

    def storageLensAwsOrg(
      arn: Option[String] = None
    ): StorageLensAwsOrg =
      StorageLensAwsOrg
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def storageLensConfiguration(
      id: Option[String] = None,
      accountLevel: Option[AccountLevel] = None,
      include: Option[Include] = None,
      exclude: Option[Exclude] = None,
      dataExport: Option[StorageLensDataExport] = None,
      isEnabled: Option[Boolean] = None,
      awsOrg: Option[StorageLensAwsOrg] = None,
      storageLensArn: Option[String] = None
    ): StorageLensConfiguration =
      StorageLensConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(accountLevel)(_.accountLevel(_))
        .ifSome(include)(_.include(_))
        .ifSome(exclude)(_.exclude(_))
        .ifSome(dataExport)(_.dataExport(_))
        .ifSome(isEnabled)(_.isEnabled(_))
        .ifSome(awsOrg)(_.awsOrg(_))
        .ifSome(storageLensArn)(_.storageLensArn(_))
        .build

    def storageLensDataExport(
      s3BucketDestination: Option[S3BucketDestination] = None
    ): StorageLensDataExport =
      StorageLensDataExport
        .builder
        .ifSome(s3BucketDestination)(_.s3BucketDestination(_))
        .build

    def storageLensDataExportEncryption(
      sSES3: Option[SSES3] = None,
      sSEKMS: Option[SSEKMS] = None
    ): StorageLensDataExportEncryption =
      StorageLensDataExportEncryption
        .builder
        .ifSome(sSES3)(_.sSES3(_))
        .ifSome(sSEKMS)(_.sSEKMS(_))
        .build

    def storageLensTag(
      key: Option[String] = None,
      value: Option[String] = None
    ): StorageLensTag =
      StorageLensTag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagging(
      tagSet: Option[List[S3Tag]] = None
    ): Tagging =
      Tagging
        .builder
        .ifSome(tagSet)(_.tagSet(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateJobPriorityRequest(
      accountId: Option[String] = None,
      jobId: Option[String] = None,
      priority: Option[Int] = None
    ): UpdateJobPriorityRequest =
      UpdateJobPriorityRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(priority)(_.priority(_))
        .build

    def updateJobStatusRequest(
      accountId: Option[String] = None,
      jobId: Option[String] = None,
      requestedJobStatus: Option[String] = None,
      statusUpdateReason: Option[String] = None
    ): UpdateJobStatusRequest =
      UpdateJobStatusRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(requestedJobStatus)(_.requestedJobStatus(_))
        .ifSome(statusUpdateReason)(_.statusUpdateReason(_))
        .build

    def vpcConfiguration(
      vpcId: Option[String] = None
    ): VpcConfiguration =
      VpcConfiguration
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
