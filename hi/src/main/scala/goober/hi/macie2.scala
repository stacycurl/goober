package goober.hi

import goober.free.macie2.Macie2IO
import software.amazon.awssdk.services.macie2.model._


object macie2 {
  import goober.free.{macie2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptInvitationRequest(
      administratorAccountId: Option[String] = None,
      invitationId: Option[String] = None,
      masterAccount: Option[String] = None
    ): AcceptInvitationRequest =
      AcceptInvitationRequest
        .builder
        .ifSome(administratorAccountId)(_.administratorAccountId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(masterAccount)(_.masterAccount(_))
        .build

    def acceptInvitationResponse(

    ): AcceptInvitationResponse =
      AcceptInvitationResponse
        .builder

        .build

    def accessControlList(
      allowsPublicReadAccess: Option[Boolean] = None,
      allowsPublicWriteAccess: Option[Boolean] = None
    ): AccessControlList =
      AccessControlList
        .builder
        .ifSome(allowsPublicReadAccess)(_.allowsPublicReadAccess(_))
        .ifSome(allowsPublicWriteAccess)(_.allowsPublicWriteAccess(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountDetail(
      accountId: Option[String] = None,
      email: Option[String] = None
    ): AccountDetail =
      AccountDetail
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(email)(_.email(_))
        .build

    def accountLevelPermissions(
      blockPublicAccess: Option[BlockPublicAccess] = None
    ): AccountLevelPermissions =
      AccountLevelPermissions
        .builder
        .ifSome(blockPublicAccess)(_.blockPublicAccess(_))
        .build

    def adminAccount(
      accountId: Option[String] = None,
      status: Option[String] = None
    ): AdminAccount =
      AdminAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(status)(_.status(_))
        .build

    def apiCallDetails(
      api: Option[String] = None,
      apiServiceName: Option[String] = None,
      firstSeen: Option[__timestampIso8601] = None,
      lastSeen: Option[__timestampIso8601] = None
    ): ApiCallDetails =
      ApiCallDetails
        .builder
        .ifSome(api)(_.api(_))
        .ifSome(apiServiceName)(_.apiServiceName(_))
        .ifSome(firstSeen)(_.firstSeen(_))
        .ifSome(lastSeen)(_.lastSeen(_))
        .build

    def assumedRole(
      accessKeyId: Option[String] = None,
      accountId: Option[String] = None,
      arn: Option[String] = None,
      principalId: Option[String] = None,
      sessionContext: Option[SessionContext] = None
    ): AssumedRole =
      AssumedRole
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(sessionContext)(_.sessionContext(_))
        .build

    def awsAccount(
      accountId: Option[String] = None,
      principalId: Option[String] = None
    ): AwsAccount =
      AwsAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def awsService(
      invokedBy: Option[String] = None
    ): AwsService =
      AwsService
        .builder
        .ifSome(invokedBy)(_.invokedBy(_))
        .build

    def batchGetCustomDataIdentifierSummary(
      arn: Option[String] = None,
      createdAt: Option[__timestampIso8601] = None,
      deleted: Option[Boolean] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None
    ): BatchGetCustomDataIdentifierSummary =
      BatchGetCustomDataIdentifierSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deleted)(_.deleted(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def batchGetCustomDataIdentifiersRequest(
      ids: Option[List[__string]] = None
    ): BatchGetCustomDataIdentifiersRequest =
      BatchGetCustomDataIdentifiersRequest
        .builder
        .ifSome(ids)(_.ids(_))
        .build

    def batchGetCustomDataIdentifiersResponse(
      customDataIdentifiers: Option[List[BatchGetCustomDataIdentifierSummary]] = None,
      notFoundIdentifierIds: Option[List[__string]] = None
    ): BatchGetCustomDataIdentifiersResponse =
      BatchGetCustomDataIdentifiersResponse
        .builder
        .ifSome(customDataIdentifiers)(_.customDataIdentifiers(_))
        .ifSome(notFoundIdentifierIds)(_.notFoundIdentifierIds(_))
        .build

    def blockPublicAccess(
      blockPublicAcls: Option[Boolean] = None,
      blockPublicPolicy: Option[Boolean] = None,
      ignorePublicAcls: Option[Boolean] = None,
      restrictPublicBuckets: Option[Boolean] = None
    ): BlockPublicAccess =
      BlockPublicAccess
        .builder
        .ifSome(blockPublicAcls)(_.blockPublicAcls(_))
        .ifSome(blockPublicPolicy)(_.blockPublicPolicy(_))
        .ifSome(ignorePublicAcls)(_.ignorePublicAcls(_))
        .ifSome(restrictPublicBuckets)(_.restrictPublicBuckets(_))
        .build

    def bucketCountByEffectivePermission(
      publiclyAccessible: Option[__long] = None,
      publiclyReadable: Option[__long] = None,
      publiclyWritable: Option[__long] = None,
      unknown: Option[__long] = None
    ): BucketCountByEffectivePermission =
      BucketCountByEffectivePermission
        .builder
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(publiclyReadable)(_.publiclyReadable(_))
        .ifSome(publiclyWritable)(_.publiclyWritable(_))
        .ifSome(unknown)(_.unknown(_))
        .build

    def bucketCountByEncryptionType(
      kmsManaged: Option[__long] = None,
      s3Managed: Option[__long] = None,
      unencrypted: Option[__long] = None,
      unknown: Option[__long] = None
    ): BucketCountByEncryptionType =
      BucketCountByEncryptionType
        .builder
        .ifSome(kmsManaged)(_.kmsManaged(_))
        .ifSome(s3Managed)(_.s3Managed(_))
        .ifSome(unencrypted)(_.unencrypted(_))
        .ifSome(unknown)(_.unknown(_))
        .build

    def bucketCountBySharedAccessType(
      external: Option[__long] = None,
      internal: Option[__long] = None,
      notShared: Option[__long] = None,
      unknown: Option[__long] = None
    ): BucketCountBySharedAccessType =
      BucketCountBySharedAccessType
        .builder
        .ifSome(external)(_.external(_))
        .ifSome(internal)(_.internal(_))
        .ifSome(notShared)(_.notShared(_))
        .ifSome(unknown)(_.unknown(_))
        .build

    def bucketCountPolicyAllowsUnencryptedObjectUploads(
      allowsUnencryptedObjectUploads: Option[__long] = None,
      deniesUnencryptedObjectUploads: Option[__long] = None,
      unknown: Option[__long] = None
    ): BucketCountPolicyAllowsUnencryptedObjectUploads =
      BucketCountPolicyAllowsUnencryptedObjectUploads
        .builder
        .ifSome(allowsUnencryptedObjectUploads)(_.allowsUnencryptedObjectUploads(_))
        .ifSome(deniesUnencryptedObjectUploads)(_.deniesUnencryptedObjectUploads(_))
        .ifSome(unknown)(_.unknown(_))
        .build

    def bucketCriteriaAdditionalProperties(
      eq: Option[List[__string]] = None,
      gt: Option[__long] = None,
      gte: Option[__long] = None,
      lt: Option[__long] = None,
      lte: Option[__long] = None,
      neq: Option[List[__string]] = None,
      prefix: Option[String] = None
    ): BucketCriteriaAdditionalProperties =
      BucketCriteriaAdditionalProperties
        .builder
        .ifSome(eq)(_.eq(_))
        .ifSome(gt)(_.gt(_))
        .ifSome(gte)(_.gte(_))
        .ifSome(lt)(_.lt(_))
        .ifSome(lte)(_.lte(_))
        .ifSome(neq)(_.neq(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def bucketLevelPermissions(
      accessControlList: Option[AccessControlList] = None,
      blockPublicAccess: Option[BlockPublicAccess] = None,
      bucketPolicy: Option[BucketPolicy] = None
    ): BucketLevelPermissions =
      BucketLevelPermissions
        .builder
        .ifSome(accessControlList)(_.accessControlList(_))
        .ifSome(blockPublicAccess)(_.blockPublicAccess(_))
        .ifSome(bucketPolicy)(_.bucketPolicy(_))
        .build

    def bucketMetadata(
      accountId: Option[String] = None,
      allowsUnencryptedObjectUploads: Option[String] = None,
      bucketArn: Option[String] = None,
      bucketCreatedAt: Option[__timestampIso8601] = None,
      bucketName: Option[String] = None,
      classifiableObjectCount: Option[__long] = None,
      classifiableSizeInBytes: Option[__long] = None,
      jobDetails: Option[JobDetails] = None,
      lastUpdated: Option[__timestampIso8601] = None,
      objectCount: Option[__long] = None,
      objectCountByEncryptionType: Option[ObjectCountByEncryptionType] = None,
      publicAccess: Option[BucketPublicAccess] = None,
      region: Option[String] = None,
      replicationDetails: Option[ReplicationDetails] = None,
      serverSideEncryption: Option[BucketServerSideEncryption] = None,
      sharedAccess: Option[String] = None,
      sizeInBytes: Option[__long] = None,
      sizeInBytesCompressed: Option[__long] = None,
      tags: Option[List[KeyValuePair]] = None,
      unclassifiableObjectCount: Option[ObjectLevelStatistics] = None,
      unclassifiableObjectSizeInBytes: Option[ObjectLevelStatistics] = None,
      versioning: Option[Boolean] = None
    ): BucketMetadata =
      BucketMetadata
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(allowsUnencryptedObjectUploads)(_.allowsUnencryptedObjectUploads(_))
        .ifSome(bucketArn)(_.bucketArn(_))
        .ifSome(bucketCreatedAt)(_.bucketCreatedAt(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(classifiableObjectCount)(_.classifiableObjectCount(_))
        .ifSome(classifiableSizeInBytes)(_.classifiableSizeInBytes(_))
        .ifSome(jobDetails)(_.jobDetails(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(objectCount)(_.objectCount(_))
        .ifSome(objectCountByEncryptionType)(_.objectCountByEncryptionType(_))
        .ifSome(publicAccess)(_.publicAccess(_))
        .ifSome(region)(_.region(_))
        .ifSome(replicationDetails)(_.replicationDetails(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(sharedAccess)(_.sharedAccess(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .ifSome(sizeInBytesCompressed)(_.sizeInBytesCompressed(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(unclassifiableObjectCount)(_.unclassifiableObjectCount(_))
        .ifSome(unclassifiableObjectSizeInBytes)(_.unclassifiableObjectSizeInBytes(_))
        .ifSome(versioning)(_.versioning(_))
        .build

    def bucketPermissionConfiguration(
      accountLevelPermissions: Option[AccountLevelPermissions] = None,
      bucketLevelPermissions: Option[BucketLevelPermissions] = None
    ): BucketPermissionConfiguration =
      BucketPermissionConfiguration
        .builder
        .ifSome(accountLevelPermissions)(_.accountLevelPermissions(_))
        .ifSome(bucketLevelPermissions)(_.bucketLevelPermissions(_))
        .build

    def bucketPolicy(
      allowsPublicReadAccess: Option[Boolean] = None,
      allowsPublicWriteAccess: Option[Boolean] = None
    ): BucketPolicy =
      BucketPolicy
        .builder
        .ifSome(allowsPublicReadAccess)(_.allowsPublicReadAccess(_))
        .ifSome(allowsPublicWriteAccess)(_.allowsPublicWriteAccess(_))
        .build

    def bucketPublicAccess(
      effectivePermission: Option[String] = None,
      permissionConfiguration: Option[BucketPermissionConfiguration] = None
    ): BucketPublicAccess =
      BucketPublicAccess
        .builder
        .ifSome(effectivePermission)(_.effectivePermission(_))
        .ifSome(permissionConfiguration)(_.permissionConfiguration(_))
        .build

    def bucketServerSideEncryption(
      kmsMasterKeyId: Option[String] = None,
      `type`: Option[String] = None
    ): BucketServerSideEncryption =
      BucketServerSideEncryption
        .builder
        .ifSome(kmsMasterKeyId)(_.kmsMasterKeyId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def bucketSortCriteria(
      attributeName: Option[String] = None,
      orderBy: Option[String] = None
    ): BucketSortCriteria =
      BucketSortCriteria
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def cell(
      cellReference: Option[String] = None,
      column: Option[__long] = None,
      columnName: Option[String] = None,
      row: Option[__long] = None
    ): Cell =
      Cell
        .builder
        .ifSome(cellReference)(_.cellReference(_))
        .ifSome(column)(_.column(_))
        .ifSome(columnName)(_.columnName(_))
        .ifSome(row)(_.row(_))
        .build

    def classificationDetails(
      detailedResultsLocation: Option[String] = None,
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      result: Option[ClassificationResult] = None
    ): ClassificationDetails =
      ClassificationDetails
        .builder
        .ifSome(detailedResultsLocation)(_.detailedResultsLocation(_))
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(result)(_.result(_))
        .build

    def classificationExportConfiguration(
      s3Destination: Option[S3Destination] = None
    ): ClassificationExportConfiguration =
      ClassificationExportConfiguration
        .builder
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def classificationResultStatus(
      code: Option[String] = None,
      reason: Option[String] = None
    ): ClassificationResultStatus =
      ClassificationResultStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(reason)(_.reason(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createClassificationJobRequest(
      clientToken: Option[String] = None,
      customDataIdentifierIds: Option[List[__string]] = None,
      description: Option[String] = None,
      initialRun: Option[Boolean] = None,
      jobType: Option[String] = None,
      name: Option[String] = None,
      s3JobDefinition: Option[S3JobDefinition] = None,
      samplingPercentage: Option[Int] = None,
      scheduleFrequency: Option[JobScheduleFrequency] = None,
      tags: Option[TagMap] = None
    ): CreateClassificationJobRequest =
      CreateClassificationJobRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(customDataIdentifierIds)(_.customDataIdentifierIds(_))
        .ifSome(description)(_.description(_))
        .ifSome(initialRun)(_.initialRun(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(name)(_.name(_))
        .ifSome(s3JobDefinition)(_.s3JobDefinition(_))
        .ifSome(samplingPercentage)(_.samplingPercentage(_))
        .ifSome(scheduleFrequency)(_.scheduleFrequency(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createClassificationJobResponse(
      jobArn: Option[String] = None,
      jobId: Option[String] = None
    ): CreateClassificationJobResponse =
      CreateClassificationJobResponse
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def createCustomDataIdentifierRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      ignoreWords: Option[List[__string]] = None,
      keywords: Option[List[__string]] = None,
      maximumMatchDistance: Option[Int] = None,
      name: Option[String] = None,
      regex: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateCustomDataIdentifierRequest =
      CreateCustomDataIdentifierRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(ignoreWords)(_.ignoreWords(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(maximumMatchDistance)(_.maximumMatchDistance(_))
        .ifSome(name)(_.name(_))
        .ifSome(regex)(_.regex(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCustomDataIdentifierResponse(
      customDataIdentifierId: Option[String] = None
    ): CreateCustomDataIdentifierResponse =
      CreateCustomDataIdentifierResponse
        .builder
        .ifSome(customDataIdentifierId)(_.customDataIdentifierId(_))
        .build

    def createFindingsFilterRequest(
      action: Option[String] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      findingCriteria: Option[FindingCriteria] = None,
      name: Option[String] = None,
      position: Option[Int] = None,
      tags: Option[TagMap] = None
    ): CreateFindingsFilterRequest =
      CreateFindingsFilterRequest
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(name)(_.name(_))
        .ifSome(position)(_.position(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFindingsFilterResponse(
      arn: Option[String] = None,
      id: Option[String] = None
    ): CreateFindingsFilterResponse =
      CreateFindingsFilterResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def createInvitationsRequest(
      accountIds: Option[List[__string]] = None,
      disableEmailNotification: Option[Boolean] = None,
      message: Option[String] = None
    ): CreateInvitationsRequest =
      CreateInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(disableEmailNotification)(_.disableEmailNotification(_))
        .ifSome(message)(_.message(_))
        .build

    def createInvitationsResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): CreateInvitationsResponse =
      CreateInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def createMemberRequest(
      account: Option[AccountDetail] = None,
      tags: Option[TagMap] = None
    ): CreateMemberRequest =
      CreateMemberRequest
        .builder
        .ifSome(account)(_.account(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMemberResponse(
      arn: Option[String] = None
    ): CreateMemberResponse =
      CreateMemberResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def createSampleFindingsRequest(
      findingTypes: Option[List[FindingType]] = None
    ): CreateSampleFindingsRequest =
      CreateSampleFindingsRequest
        .builder
        .ifSome(findingTypes)(_.findingTypes(_))
        .build

    def createSampleFindingsResponse(

    ): CreateSampleFindingsResponse =
      CreateSampleFindingsResponse
        .builder

        .build

    def criteriaBlockForJob(
      and: Option[List[CriteriaForJob]] = None
    ): CriteriaBlockForJob =
      CriteriaBlockForJob
        .builder
        .ifSome(and)(_.and(_))
        .build

    def criteriaForJob(
      simpleCriterion: Option[SimpleCriterionForJob] = None,
      tagCriterion: Option[TagCriterionForJob] = None
    ): CriteriaForJob =
      CriteriaForJob
        .builder
        .ifSome(simpleCriterion)(_.simpleCriterion(_))
        .ifSome(tagCriterion)(_.tagCriterion(_))
        .build

    def criterionAdditionalProperties(
      eq: Option[List[__string]] = None,
      eqExactMatch: Option[List[__string]] = None,
      gt: Option[__long] = None,
      gte: Option[__long] = None,
      lt: Option[__long] = None,
      lte: Option[__long] = None,
      neq: Option[List[__string]] = None
    ): CriterionAdditionalProperties =
      CriterionAdditionalProperties
        .builder
        .ifSome(eq)(_.eq(_))
        .ifSome(eqExactMatch)(_.eqExactMatch(_))
        .ifSome(gt)(_.gt(_))
        .ifSome(gte)(_.gte(_))
        .ifSome(lt)(_.lt(_))
        .ifSome(lte)(_.lte(_))
        .ifSome(neq)(_.neq(_))
        .build

    def customDataIdentifierSummary(
      arn: Option[String] = None,
      createdAt: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None
    ): CustomDataIdentifierSummary =
      CustomDataIdentifierSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def customDataIdentifiers(
      detections: Option[List[CustomDetection]] = None,
      totalCount: Option[__long] = None
    ): CustomDataIdentifiers =
      CustomDataIdentifiers
        .builder
        .ifSome(detections)(_.detections(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def customDetection(
      arn: Option[String] = None,
      count: Option[__long] = None,
      name: Option[String] = None,
      occurrences: Option[Occurrences] = None
    ): CustomDetection =
      CustomDetection
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(count)(_.count(_))
        .ifSome(name)(_.name(_))
        .ifSome(occurrences)(_.occurrences(_))
        .build

    def dailySchedule(

    ): DailySchedule =
      DailySchedule
        .builder

        .build

    def declineInvitationsRequest(
      accountIds: Option[List[__string]] = None
    ): DeclineInvitationsRequest =
      DeclineInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def declineInvitationsResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DeclineInvitationsResponse =
      DeclineInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def defaultDetection(
      count: Option[__long] = None,
      occurrences: Option[Occurrences] = None,
      `type`: Option[String] = None
    ): DefaultDetection =
      DefaultDetection
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(occurrences)(_.occurrences(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def deleteCustomDataIdentifierRequest(
      id: Option[String] = None
    ): DeleteCustomDataIdentifierRequest =
      DeleteCustomDataIdentifierRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteCustomDataIdentifierResponse(

    ): DeleteCustomDataIdentifierResponse =
      DeleteCustomDataIdentifierResponse
        .builder

        .build

    def deleteFindingsFilterRequest(
      id: Option[String] = None
    ): DeleteFindingsFilterRequest =
      DeleteFindingsFilterRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteFindingsFilterResponse(

    ): DeleteFindingsFilterResponse =
      DeleteFindingsFilterResponse
        .builder

        .build

    def deleteInvitationsRequest(
      accountIds: Option[List[__string]] = None
    ): DeleteInvitationsRequest =
      DeleteInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def deleteInvitationsResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DeleteInvitationsResponse =
      DeleteInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def deleteMemberRequest(
      id: Option[String] = None
    ): DeleteMemberRequest =
      DeleteMemberRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteMemberResponse(

    ): DeleteMemberResponse =
      DeleteMemberResponse
        .builder

        .build

    def describeBucketsRequest(
      criteria: Option[BucketCriteria] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortCriteria: Option[BucketSortCriteria] = None
    ): DescribeBucketsRequest =
      DescribeBucketsRequest
        .builder
        .ifSome(criteria)(_.criteria(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def describeBucketsResponse(
      buckets: Option[List[BucketMetadata]] = None,
      nextToken: Option[String] = None
    ): DescribeBucketsResponse =
      DescribeBucketsResponse
        .builder
        .ifSome(buckets)(_.buckets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClassificationJobRequest(
      jobId: Option[String] = None
    ): DescribeClassificationJobRequest =
      DescribeClassificationJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeClassificationJobResponse(
      clientToken: Option[String] = None,
      createdAt: Option[__timestampIso8601] = None,
      customDataIdentifierIds: Option[List[__string]] = None,
      description: Option[String] = None,
      initialRun: Option[Boolean] = None,
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      jobStatus: Option[String] = None,
      jobType: Option[String] = None,
      lastRunErrorStatus: Option[LastRunErrorStatus] = None,
      lastRunTime: Option[__timestampIso8601] = None,
      name: Option[String] = None,
      s3JobDefinition: Option[S3JobDefinition] = None,
      samplingPercentage: Option[Int] = None,
      scheduleFrequency: Option[JobScheduleFrequency] = None,
      statistics: Option[Statistics] = None,
      tags: Option[TagMap] = None,
      userPausedDetails: Option[UserPausedDetails] = None
    ): DescribeClassificationJobResponse =
      DescribeClassificationJobResponse
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(customDataIdentifierIds)(_.customDataIdentifierIds(_))
        .ifSome(description)(_.description(_))
        .ifSome(initialRun)(_.initialRun(_))
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(lastRunErrorStatus)(_.lastRunErrorStatus(_))
        .ifSome(lastRunTime)(_.lastRunTime(_))
        .ifSome(name)(_.name(_))
        .ifSome(s3JobDefinition)(_.s3JobDefinition(_))
        .ifSome(samplingPercentage)(_.samplingPercentage(_))
        .ifSome(scheduleFrequency)(_.scheduleFrequency(_))
        .ifSome(statistics)(_.statistics(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userPausedDetails)(_.userPausedDetails(_))
        .build

    def describeOrganizationConfigurationRequest(

    ): DescribeOrganizationConfigurationRequest =
      DescribeOrganizationConfigurationRequest
        .builder

        .build

    def describeOrganizationConfigurationResponse(
      autoEnable: Option[Boolean] = None,
      maxAccountLimitReached: Option[Boolean] = None
    ): DescribeOrganizationConfigurationResponse =
      DescribeOrganizationConfigurationResponse
        .builder
        .ifSome(autoEnable)(_.autoEnable(_))
        .ifSome(maxAccountLimitReached)(_.maxAccountLimitReached(_))
        .build

    def disableMacieRequest(

    ): DisableMacieRequest =
      DisableMacieRequest
        .builder

        .build

    def disableMacieResponse(

    ): DisableMacieResponse =
      DisableMacieResponse
        .builder

        .build

    def disableOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): DisableOrganizationAdminAccountRequest =
      DisableOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def disableOrganizationAdminAccountResponse(

    ): DisableOrganizationAdminAccountResponse =
      DisableOrganizationAdminAccountResponse
        .builder

        .build

    def disassociateFromAdministratorAccountRequest(

    ): DisassociateFromAdministratorAccountRequest =
      DisassociateFromAdministratorAccountRequest
        .builder

        .build

    def disassociateFromAdministratorAccountResponse(

    ): DisassociateFromAdministratorAccountResponse =
      DisassociateFromAdministratorAccountResponse
        .builder

        .build

    def disassociateFromMasterAccountRequest(

    ): DisassociateFromMasterAccountRequest =
      DisassociateFromMasterAccountRequest
        .builder

        .build

    def disassociateFromMasterAccountResponse(

    ): DisassociateFromMasterAccountResponse =
      DisassociateFromMasterAccountResponse
        .builder

        .build

    def disassociateMemberRequest(
      id: Option[String] = None
    ): DisassociateMemberRequest =
      DisassociateMemberRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def disassociateMemberResponse(

    ): DisassociateMemberResponse =
      DisassociateMemberResponse
        .builder

        .build

    def domainDetails(
      domainName: Option[String] = None
    ): DomainDetails =
      DomainDetails
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def empty(

    ): Empty =
      Empty
        .builder

        .build

    def enableMacieRequest(
      clientToken: Option[String] = None,
      findingPublishingFrequency: Option[String] = None,
      status: Option[String] = None
    ): EnableMacieRequest =
      EnableMacieRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(findingPublishingFrequency)(_.findingPublishingFrequency(_))
        .ifSome(status)(_.status(_))
        .build

    def enableMacieResponse(

    ): EnableMacieResponse =
      EnableMacieResponse
        .builder

        .build

    def enableOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None,
      clientToken: Option[String] = None
    ): EnableOrganizationAdminAccountRequest =
      EnableOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def enableOrganizationAdminAccountResponse(

    ): EnableOrganizationAdminAccountResponse =
      EnableOrganizationAdminAccountResponse
        .builder

        .build

    def federatedUser(
      accessKeyId: Option[String] = None,
      accountId: Option[String] = None,
      arn: Option[String] = None,
      principalId: Option[String] = None,
      sessionContext: Option[SessionContext] = None
    ): FederatedUser =
      FederatedUser
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(sessionContext)(_.sessionContext(_))
        .build

    def finding(
      accountId: Option[String] = None,
      archived: Option[Boolean] = None,
      category: Option[String] = None,
      classificationDetails: Option[ClassificationDetails] = None,
      count: Option[__long] = None,
      createdAt: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      partition: Option[String] = None,
      policyDetails: Option[PolicyDetails] = None,
      region: Option[String] = None,
      resourcesAffected: Option[ResourcesAffected] = None,
      sample: Option[Boolean] = None,
      schemaVersion: Option[String] = None,
      severity: Option[Severity] = None,
      title: Option[String] = None,
      `type`: Option[String] = None,
      updatedAt: Option[__timestampIso8601] = None
    ): Finding =
      Finding
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(archived)(_.archived(_))
        .ifSome(category)(_.category(_))
        .ifSome(classificationDetails)(_.classificationDetails(_))
        .ifSome(count)(_.count(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(partition)(_.partition(_))
        .ifSome(policyDetails)(_.policyDetails(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourcesAffected)(_.resourcesAffected(_))
        .ifSome(sample)(_.sample(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(title)(_.title(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def findingAction(
      actionType: Option[String] = None,
      apiCallDetails: Option[ApiCallDetails] = None
    ): FindingAction =
      FindingAction
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(apiCallDetails)(_.apiCallDetails(_))
        .build

    def findingActor(
      domainDetails: Option[DomainDetails] = None,
      ipAddressDetails: Option[IpAddressDetails] = None,
      userIdentity: Option[UserIdentity] = None
    ): FindingActor =
      FindingActor
        .builder
        .ifSome(domainDetails)(_.domainDetails(_))
        .ifSome(ipAddressDetails)(_.ipAddressDetails(_))
        .ifSome(userIdentity)(_.userIdentity(_))
        .build

    def findingCriteria(
      criterion: Option[Criterion] = None
    ): FindingCriteria =
      FindingCriteria
        .builder
        .ifSome(criterion)(_.criterion(_))
        .build

    def findingStatisticsSortCriteria(
      attributeName: Option[String] = None,
      orderBy: Option[String] = None
    ): FindingStatisticsSortCriteria =
      FindingStatisticsSortCriteria
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def findingsFilterListItem(
      action: Option[String] = None,
      arn: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      tags: Option[TagMap] = None
    ): FindingsFilterListItem =
      FindingsFilterListItem
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getAdministratorAccountRequest(

    ): GetAdministratorAccountRequest =
      GetAdministratorAccountRequest
        .builder

        .build

    def getAdministratorAccountResponse(
      administrator: Option[Invitation] = None
    ): GetAdministratorAccountResponse =
      GetAdministratorAccountResponse
        .builder
        .ifSome(administrator)(_.administrator(_))
        .build

    def getBucketStatisticsRequest(
      accountId: Option[String] = None
    ): GetBucketStatisticsRequest =
      GetBucketStatisticsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def getBucketStatisticsResponse(
      bucketCount: Option[__long] = None,
      bucketCountByEffectivePermission: Option[BucketCountByEffectivePermission] = None,
      bucketCountByEncryptionType: Option[BucketCountByEncryptionType] = None,
      bucketCountByObjectEncryptionRequirement: Option[BucketCountPolicyAllowsUnencryptedObjectUploads] = None,
      bucketCountBySharedAccessType: Option[BucketCountBySharedAccessType] = None,
      classifiableObjectCount: Option[__long] = None,
      classifiableSizeInBytes: Option[__long] = None,
      lastUpdated: Option[__timestampIso8601] = None,
      objectCount: Option[__long] = None,
      sizeInBytes: Option[__long] = None,
      sizeInBytesCompressed: Option[__long] = None,
      unclassifiableObjectCount: Option[ObjectLevelStatistics] = None,
      unclassifiableObjectSizeInBytes: Option[ObjectLevelStatistics] = None
    ): GetBucketStatisticsResponse =
      GetBucketStatisticsResponse
        .builder
        .ifSome(bucketCount)(_.bucketCount(_))
        .ifSome(bucketCountByEffectivePermission)(_.bucketCountByEffectivePermission(_))
        .ifSome(bucketCountByEncryptionType)(_.bucketCountByEncryptionType(_))
        .ifSome(bucketCountByObjectEncryptionRequirement)(_.bucketCountByObjectEncryptionRequirement(_))
        .ifSome(bucketCountBySharedAccessType)(_.bucketCountBySharedAccessType(_))
        .ifSome(classifiableObjectCount)(_.classifiableObjectCount(_))
        .ifSome(classifiableSizeInBytes)(_.classifiableSizeInBytes(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(objectCount)(_.objectCount(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .ifSome(sizeInBytesCompressed)(_.sizeInBytesCompressed(_))
        .ifSome(unclassifiableObjectCount)(_.unclassifiableObjectCount(_))
        .ifSome(unclassifiableObjectSizeInBytes)(_.unclassifiableObjectSizeInBytes(_))
        .build

    def getClassificationExportConfigurationRequest(

    ): GetClassificationExportConfigurationRequest =
      GetClassificationExportConfigurationRequest
        .builder

        .build

    def getClassificationExportConfigurationResponse(
      configuration: Option[ClassificationExportConfiguration] = None
    ): GetClassificationExportConfigurationResponse =
      GetClassificationExportConfigurationResponse
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def getCustomDataIdentifierRequest(
      id: Option[String] = None
    ): GetCustomDataIdentifierRequest =
      GetCustomDataIdentifierRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getCustomDataIdentifierResponse(
      arn: Option[String] = None,
      createdAt: Option[__timestampIso8601] = None,
      deleted: Option[Boolean] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      ignoreWords: Option[List[__string]] = None,
      keywords: Option[List[__string]] = None,
      maximumMatchDistance: Option[Int] = None,
      name: Option[String] = None,
      regex: Option[String] = None,
      tags: Option[TagMap] = None
    ): GetCustomDataIdentifierResponse =
      GetCustomDataIdentifierResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deleted)(_.deleted(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(ignoreWords)(_.ignoreWords(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(maximumMatchDistance)(_.maximumMatchDistance(_))
        .ifSome(name)(_.name(_))
        .ifSome(regex)(_.regex(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getFindingStatisticsRequest(
      findingCriteria: Option[FindingCriteria] = None,
      groupBy: Option[String] = None,
      size: Option[Int] = None,
      sortCriteria: Option[FindingStatisticsSortCriteria] = None
    ): GetFindingStatisticsRequest =
      GetFindingStatisticsRequest
        .builder
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(size)(_.size(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def getFindingStatisticsResponse(
      countsByGroup: Option[List[GroupCount]] = None
    ): GetFindingStatisticsResponse =
      GetFindingStatisticsResponse
        .builder
        .ifSome(countsByGroup)(_.countsByGroup(_))
        .build

    def getFindingsFilterRequest(
      id: Option[String] = None
    ): GetFindingsFilterRequest =
      GetFindingsFilterRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getFindingsFilterResponse(
      action: Option[String] = None,
      arn: Option[String] = None,
      description: Option[String] = None,
      findingCriteria: Option[FindingCriteria] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      position: Option[Int] = None,
      tags: Option[TagMap] = None
    ): GetFindingsFilterResponse =
      GetFindingsFilterResponse
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(position)(_.position(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getFindingsPublicationConfigurationRequest(

    ): GetFindingsPublicationConfigurationRequest =
      GetFindingsPublicationConfigurationRequest
        .builder

        .build

    def getFindingsPublicationConfigurationResponse(
      securityHubConfiguration: Option[SecurityHubConfiguration] = None
    ): GetFindingsPublicationConfigurationResponse =
      GetFindingsPublicationConfigurationResponse
        .builder
        .ifSome(securityHubConfiguration)(_.securityHubConfiguration(_))
        .build

    def getFindingsRequest(
      findingIds: Option[List[__string]] = None,
      sortCriteria: Option[SortCriteria] = None
    ): GetFindingsRequest =
      GetFindingsRequest
        .builder
        .ifSome(findingIds)(_.findingIds(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def getFindingsResponse(
      findings: Option[List[Finding]] = None
    ): GetFindingsResponse =
      GetFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .build

    def getInvitationsCountRequest(

    ): GetInvitationsCountRequest =
      GetInvitationsCountRequest
        .builder

        .build

    def getInvitationsCountResponse(
      invitationsCount: Option[__long] = None
    ): GetInvitationsCountResponse =
      GetInvitationsCountResponse
        .builder
        .ifSome(invitationsCount)(_.invitationsCount(_))
        .build

    def getMacieSessionRequest(

    ): GetMacieSessionRequest =
      GetMacieSessionRequest
        .builder

        .build

    def getMacieSessionResponse(
      createdAt: Option[__timestampIso8601] = None,
      findingPublishingFrequency: Option[String] = None,
      serviceRole: Option[String] = None,
      status: Option[String] = None,
      updatedAt: Option[__timestampIso8601] = None
    ): GetMacieSessionResponse =
      GetMacieSessionResponse
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(findingPublishingFrequency)(_.findingPublishingFrequency(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def getMasterAccountRequest(

    ): GetMasterAccountRequest =
      GetMasterAccountRequest
        .builder

        .build

    def getMasterAccountResponse(
      master: Option[Invitation] = None
    ): GetMasterAccountResponse =
      GetMasterAccountResponse
        .builder
        .ifSome(master)(_.master(_))
        .build

    def getMemberRequest(
      id: Option[String] = None
    ): GetMemberRequest =
      GetMemberRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getMemberResponse(
      accountId: Option[String] = None,
      administratorAccountId: Option[String] = None,
      arn: Option[String] = None,
      email: Option[String] = None,
      invitedAt: Option[__timestampIso8601] = None,
      masterAccountId: Option[String] = None,
      relationshipStatus: Option[String] = None,
      tags: Option[TagMap] = None,
      updatedAt: Option[__timestampIso8601] = None
    ): GetMemberResponse =
      GetMemberResponse
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(administratorAccountId)(_.administratorAccountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(email)(_.email(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .ifSome(masterAccountId)(_.masterAccountId(_))
        .ifSome(relationshipStatus)(_.relationshipStatus(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def getUsageStatisticsRequest(
      filterBy: Option[List[UsageStatisticsFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[UsageStatisticsSortBy] = None,
      timeRange: Option[String] = None
    ): GetUsageStatisticsRequest =
      GetUsageStatisticsRequest
        .builder
        .ifSome(filterBy)(_.filterBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(timeRange)(_.timeRange(_))
        .build

    def getUsageStatisticsResponse(
      nextToken: Option[String] = None,
      records: Option[List[UsageRecord]] = None,
      timeRange: Option[String] = None
    ): GetUsageStatisticsResponse =
      GetUsageStatisticsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(records)(_.records(_))
        .ifSome(timeRange)(_.timeRange(_))
        .build

    def getUsageTotalsRequest(
      timeRange: Option[String] = None
    ): GetUsageTotalsRequest =
      GetUsageTotalsRequest
        .builder
        .ifSome(timeRange)(_.timeRange(_))
        .build

    def getUsageTotalsResponse(
      timeRange: Option[String] = None,
      usageTotals: Option[List[UsageTotal]] = None
    ): GetUsageTotalsResponse =
      GetUsageTotalsResponse
        .builder
        .ifSome(timeRange)(_.timeRange(_))
        .ifSome(usageTotals)(_.usageTotals(_))
        .build

    def groupCount(
      count: Option[__long] = None,
      groupKey: Option[String] = None
    ): GroupCount =
      GroupCount
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(groupKey)(_.groupKey(_))
        .build

    def iamUser(
      accountId: Option[String] = None,
      arn: Option[String] = None,
      principalId: Option[String] = None,
      userName: Option[String] = None
    ): IamUser =
      IamUser
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(userName)(_.userName(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invitation(
      accountId: Option[String] = None,
      invitationId: Option[String] = None,
      invitedAt: Option[__timestampIso8601] = None,
      relationshipStatus: Option[String] = None
    ): Invitation =
      Invitation
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .ifSome(relationshipStatus)(_.relationshipStatus(_))
        .build

    def ipAddressDetails(
      ipAddressV4: Option[String] = None,
      ipCity: Option[IpCity] = None,
      ipCountry: Option[IpCountry] = None,
      ipGeoLocation: Option[IpGeoLocation] = None,
      ipOwner: Option[IpOwner] = None
    ): IpAddressDetails =
      IpAddressDetails
        .builder
        .ifSome(ipAddressV4)(_.ipAddressV4(_))
        .ifSome(ipCity)(_.ipCity(_))
        .ifSome(ipCountry)(_.ipCountry(_))
        .ifSome(ipGeoLocation)(_.ipGeoLocation(_))
        .ifSome(ipOwner)(_.ipOwner(_))
        .build

    def ipCity(
      name: Option[String] = None
    ): IpCity =
      IpCity
        .builder
        .ifSome(name)(_.name(_))
        .build

    def ipCountry(
      code: Option[String] = None,
      name: Option[String] = None
    ): IpCountry =
      IpCountry
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(name)(_.name(_))
        .build

    def ipGeoLocation(
      lat: Option[__double] = None,
      lon: Option[__double] = None
    ): IpGeoLocation =
      IpGeoLocation
        .builder
        .ifSome(lat)(_.lat(_))
        .ifSome(lon)(_.lon(_))
        .build

    def ipOwner(
      asn: Option[String] = None,
      asnOrg: Option[String] = None,
      isp: Option[String] = None,
      org: Option[String] = None
    ): IpOwner =
      IpOwner
        .builder
        .ifSome(asn)(_.asn(_))
        .ifSome(asnOrg)(_.asnOrg(_))
        .ifSome(isp)(_.isp(_))
        .ifSome(org)(_.org(_))
        .build

    def jobDetails(
      isDefinedInJob: Option[String] = None,
      isMonitoredByJob: Option[String] = None,
      lastJobId: Option[String] = None,
      lastJobRunTime: Option[__timestampIso8601] = None
    ): JobDetails =
      JobDetails
        .builder
        .ifSome(isDefinedInJob)(_.isDefinedInJob(_))
        .ifSome(isMonitoredByJob)(_.isMonitoredByJob(_))
        .ifSome(lastJobId)(_.lastJobId(_))
        .ifSome(lastJobRunTime)(_.lastJobRunTime(_))
        .build

    def jobScheduleFrequency(
      dailySchedule: Option[DailySchedule] = None,
      monthlySchedule: Option[MonthlySchedule] = None,
      weeklySchedule: Option[WeeklySchedule] = None
    ): JobScheduleFrequency =
      JobScheduleFrequency
        .builder
        .ifSome(dailySchedule)(_.dailySchedule(_))
        .ifSome(monthlySchedule)(_.monthlySchedule(_))
        .ifSome(weeklySchedule)(_.weeklySchedule(_))
        .build

    def jobScopeTerm(
      simpleScopeTerm: Option[SimpleScopeTerm] = None,
      tagScopeTerm: Option[TagScopeTerm] = None
    ): JobScopeTerm =
      JobScopeTerm
        .builder
        .ifSome(simpleScopeTerm)(_.simpleScopeTerm(_))
        .ifSome(tagScopeTerm)(_.tagScopeTerm(_))
        .build

    def jobScopingBlock(
      and: Option[List[JobScopeTerm]] = None
    ): JobScopingBlock =
      JobScopingBlock
        .builder
        .ifSome(and)(_.and(_))
        .build

    def jobSummary(
      bucketDefinitions: Option[List[S3BucketDefinitionForJob]] = None,
      createdAt: Option[__timestampIso8601] = None,
      jobId: Option[String] = None,
      jobStatus: Option[String] = None,
      jobType: Option[String] = None,
      lastRunErrorStatus: Option[LastRunErrorStatus] = None,
      name: Option[String] = None,
      userPausedDetails: Option[UserPausedDetails] = None,
      bucketCriteria: Option[S3BucketCriteriaForJob] = None
    ): JobSummary =
      JobSummary
        .builder
        .ifSome(bucketDefinitions)(_.bucketDefinitions(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(lastRunErrorStatus)(_.lastRunErrorStatus(_))
        .ifSome(name)(_.name(_))
        .ifSome(userPausedDetails)(_.userPausedDetails(_))
        .ifSome(bucketCriteria)(_.bucketCriteria(_))
        .build

    def keyValuePair(
      key: Option[String] = None,
      value: Option[String] = None
    ): KeyValuePair =
      KeyValuePair
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def lastRunErrorStatus(
      code: Option[String] = None
    ): LastRunErrorStatus =
      LastRunErrorStatus
        .builder
        .ifSome(code)(_.code(_))
        .build

    def listClassificationJobsRequest(
      filterCriteria: Option[ListJobsFilterCriteria] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortCriteria: Option[ListJobsSortCriteria] = None
    ): ListClassificationJobsRequest =
      ListClassificationJobsRequest
        .builder
        .ifSome(filterCriteria)(_.filterCriteria(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def listClassificationJobsResponse(
      items: Option[List[JobSummary]] = None,
      nextToken: Option[String] = None
    ): ListClassificationJobsResponse =
      ListClassificationJobsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomDataIdentifiersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCustomDataIdentifiersRequest =
      ListCustomDataIdentifiersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCustomDataIdentifiersResponse(
      items: Option[List[CustomDataIdentifierSummary]] = None,
      nextToken: Option[String] = None
    ): ListCustomDataIdentifiersResponse =
      ListCustomDataIdentifiersResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsFiltersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFindingsFiltersRequest =
      ListFindingsFiltersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsFiltersResponse(
      findingsFilterListItems: Option[List[FindingsFilterListItem]] = None,
      nextToken: Option[String] = None
    ): ListFindingsFiltersResponse =
      ListFindingsFiltersResponse
        .builder
        .ifSome(findingsFilterListItems)(_.findingsFilterListItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsRequest(
      findingCriteria: Option[FindingCriteria] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortCriteria: Option[SortCriteria] = None
    ): ListFindingsRequest =
      ListFindingsRequest
        .builder
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def listFindingsResponse(
      findingIds: Option[List[__string]] = None,
      nextToken: Option[String] = None
    ): ListFindingsResponse =
      ListFindingsResponse
        .builder
        .ifSome(findingIds)(_.findingIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInvitationsRequest =
      ListInvitationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsResponse(
      invitations: Option[List[Invitation]] = None,
      nextToken: Option[String] = None
    ): ListInvitationsResponse =
      ListInvitationsResponse
        .builder
        .ifSome(invitations)(_.invitations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsFilterCriteria(
      excludes: Option[List[ListJobsFilterTerm]] = None,
      includes: Option[List[ListJobsFilterTerm]] = None
    ): ListJobsFilterCriteria =
      ListJobsFilterCriteria
        .builder
        .ifSome(excludes)(_.excludes(_))
        .ifSome(includes)(_.includes(_))
        .build

    def listJobsFilterTerm(
      comparator: Option[String] = None,
      key: Option[String] = None,
      values: Option[List[__string]] = None
    ): ListJobsFilterTerm =
      ListJobsFilterTerm
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def listJobsSortCriteria(
      attributeName: Option[String] = None,
      orderBy: Option[String] = None
    ): ListJobsSortCriteria =
      ListJobsSortCriteria
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def listMembersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      onlyAssociated: Option[String] = None
    ): ListMembersRequest =
      ListMembersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(onlyAssociated)(_.onlyAssociated(_))
        .build

    def listMembersResponse(
      members: Option[List[Member]] = None,
      nextToken: Option[String] = None
    ): ListMembersResponse =
      ListMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationAdminAccountsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOrganizationAdminAccountsRequest =
      ListOrganizationAdminAccountsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationAdminAccountsResponse(
      adminAccounts: Option[List[AdminAccount]] = None,
      nextToken: Option[String] = None
    ): ListOrganizationAdminAccountsResponse =
      ListOrganizationAdminAccountsResponse
        .builder
        .ifSome(adminAccounts)(_.adminAccounts(_))
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

    def matchingBucket(
      accountId: Option[String] = None,
      bucketName: Option[String] = None,
      classifiableObjectCount: Option[__long] = None,
      classifiableSizeInBytes: Option[__long] = None,
      jobDetails: Option[JobDetails] = None,
      objectCount: Option[__long] = None,
      objectCountByEncryptionType: Option[ObjectCountByEncryptionType] = None,
      sizeInBytes: Option[__long] = None,
      sizeInBytesCompressed: Option[__long] = None,
      unclassifiableObjectCount: Option[ObjectLevelStatistics] = None,
      unclassifiableObjectSizeInBytes: Option[ObjectLevelStatistics] = None
    ): MatchingBucket =
      MatchingBucket
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(classifiableObjectCount)(_.classifiableObjectCount(_))
        .ifSome(classifiableSizeInBytes)(_.classifiableSizeInBytes(_))
        .ifSome(jobDetails)(_.jobDetails(_))
        .ifSome(objectCount)(_.objectCount(_))
        .ifSome(objectCountByEncryptionType)(_.objectCountByEncryptionType(_))
        .ifSome(sizeInBytes)(_.sizeInBytes(_))
        .ifSome(sizeInBytesCompressed)(_.sizeInBytesCompressed(_))
        .ifSome(unclassifiableObjectCount)(_.unclassifiableObjectCount(_))
        .ifSome(unclassifiableObjectSizeInBytes)(_.unclassifiableObjectSizeInBytes(_))
        .build

    def matchingResource(
      matchingBucket: Option[MatchingBucket] = None
    ): MatchingResource =
      MatchingResource
        .builder
        .ifSome(matchingBucket)(_.matchingBucket(_))
        .build

    def member(
      accountId: Option[String] = None,
      administratorAccountId: Option[String] = None,
      arn: Option[String] = None,
      email: Option[String] = None,
      invitedAt: Option[__timestampIso8601] = None,
      masterAccountId: Option[String] = None,
      relationshipStatus: Option[String] = None,
      tags: Option[TagMap] = None,
      updatedAt: Option[__timestampIso8601] = None
    ): Member =
      Member
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(administratorAccountId)(_.administratorAccountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(email)(_.email(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .ifSome(masterAccountId)(_.masterAccountId(_))
        .ifSome(relationshipStatus)(_.relationshipStatus(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def monthlySchedule(
      dayOfMonth: Option[Int] = None
    ): MonthlySchedule =
      MonthlySchedule
        .builder
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .build

    def objectCountByEncryptionType(
      customerManaged: Option[__long] = None,
      kmsManaged: Option[__long] = None,
      s3Managed: Option[__long] = None,
      unencrypted: Option[__long] = None,
      unknown: Option[__long] = None
    ): ObjectCountByEncryptionType =
      ObjectCountByEncryptionType
        .builder
        .ifSome(customerManaged)(_.customerManaged(_))
        .ifSome(kmsManaged)(_.kmsManaged(_))
        .ifSome(s3Managed)(_.s3Managed(_))
        .ifSome(unencrypted)(_.unencrypted(_))
        .ifSome(unknown)(_.unknown(_))
        .build

    def objectLevelStatistics(
      fileType: Option[__long] = None,
      storageClass: Option[__long] = None,
      total: Option[__long] = None
    ): ObjectLevelStatistics =
      ObjectLevelStatistics
        .builder
        .ifSome(fileType)(_.fileType(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(total)(_.total(_))
        .build

    def occurrences(
      cells: Option[List[Cell]] = None,
      lineRanges: Option[List[Range]] = None,
      offsetRanges: Option[List[Range]] = None,
      pages: Option[List[Page]] = None,
      records: Option[List[Record]] = None
    ): Occurrences =
      Occurrences
        .builder
        .ifSome(cells)(_.cells(_))
        .ifSome(lineRanges)(_.lineRanges(_))
        .ifSome(offsetRanges)(_.offsetRanges(_))
        .ifSome(pages)(_.pages(_))
        .ifSome(records)(_.records(_))
        .build

    def page(
      lineRange: Option[Range] = None,
      offsetRange: Option[Range] = None,
      pageNumber: Option[__long] = None
    ): Page =
      Page
        .builder
        .ifSome(lineRange)(_.lineRange(_))
        .ifSome(offsetRange)(_.offsetRange(_))
        .ifSome(pageNumber)(_.pageNumber(_))
        .build

    def policyDetails(
      action: Option[FindingAction] = None,
      actor: Option[FindingActor] = None
    ): PolicyDetails =
      PolicyDetails
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(actor)(_.actor(_))
        .build

    def putClassificationExportConfigurationRequest(
      configuration: Option[ClassificationExportConfiguration] = None
    ): PutClassificationExportConfigurationRequest =
      PutClassificationExportConfigurationRequest
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def putClassificationExportConfigurationResponse(
      configuration: Option[ClassificationExportConfiguration] = None
    ): PutClassificationExportConfigurationResponse =
      PutClassificationExportConfigurationResponse
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def putFindingsPublicationConfigurationRequest(
      clientToken: Option[String] = None,
      securityHubConfiguration: Option[SecurityHubConfiguration] = None
    ): PutFindingsPublicationConfigurationRequest =
      PutFindingsPublicationConfigurationRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(securityHubConfiguration)(_.securityHubConfiguration(_))
        .build

    def putFindingsPublicationConfigurationResponse(

    ): PutFindingsPublicationConfigurationResponse =
      PutFindingsPublicationConfigurationResponse
        .builder

        .build

    def range(
      end: Option[__long] = None,
      start: Option[__long] = None,
      startColumn: Option[__long] = None
    ): Range =
      Range
        .builder
        .ifSome(end)(_.end(_))
        .ifSome(start)(_.start(_))
        .ifSome(startColumn)(_.startColumn(_))
        .build

    def record(
      jsonPath: Option[String] = None,
      recordIndex: Option[__long] = None
    ): Record =
      Record
        .builder
        .ifSome(jsonPath)(_.jsonPath(_))
        .ifSome(recordIndex)(_.recordIndex(_))
        .build

    def replicationDetails(
      replicated: Option[Boolean] = None,
      replicatedExternally: Option[Boolean] = None,
      replicationAccounts: Option[List[__string]] = None
    ): ReplicationDetails =
      ReplicationDetails
        .builder
        .ifSome(replicated)(_.replicated(_))
        .ifSome(replicatedExternally)(_.replicatedExternally(_))
        .ifSome(replicationAccounts)(_.replicationAccounts(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourcesAffected(
      s3Bucket: Option[S3Bucket] = None,
      s3Object: Option[S3Object] = None
    ): ResourcesAffected =
      ResourcesAffected
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def s3Bucket(
      allowsUnencryptedObjectUploads: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[__timestampIso8601] = None,
      defaultServerSideEncryption: Option[ServerSideEncryption] = None,
      name: Option[String] = None,
      owner: Option[S3BucketOwner] = None,
      publicAccess: Option[BucketPublicAccess] = None,
      tags: Option[List[KeyValuePair]] = None
    ): S3Bucket =
      S3Bucket
        .builder
        .ifSome(allowsUnencryptedObjectUploads)(_.allowsUnencryptedObjectUploads(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(defaultServerSideEncryption)(_.defaultServerSideEncryption(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(publicAccess)(_.publicAccess(_))
        .ifSome(tags)(_.tags(_))
        .build

    def s3BucketCriteriaForJob(
      excludes: Option[CriteriaBlockForJob] = None,
      includes: Option[CriteriaBlockForJob] = None
    ): S3BucketCriteriaForJob =
      S3BucketCriteriaForJob
        .builder
        .ifSome(excludes)(_.excludes(_))
        .ifSome(includes)(_.includes(_))
        .build

    def s3BucketDefinitionForJob(
      accountId: Option[String] = None,
      buckets: Option[List[__string]] = None
    ): S3BucketDefinitionForJob =
      S3BucketDefinitionForJob
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(buckets)(_.buckets(_))
        .build

    def s3BucketOwner(
      displayName: Option[String] = None,
      id: Option[String] = None
    ): S3BucketOwner =
      S3BucketOwner
        .builder
        .ifSome(displayName)(_.displayName(_))
        .ifSome(id)(_.id(_))
        .build

    def s3Destination(
      bucketName: Option[String] = None,
      keyPrefix: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): S3Destination =
      S3Destination
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def s3JobDefinition(
      bucketDefinitions: Option[List[S3BucketDefinitionForJob]] = None,
      scoping: Option[Scoping] = None,
      bucketCriteria: Option[S3BucketCriteriaForJob] = None
    ): S3JobDefinition =
      S3JobDefinition
        .builder
        .ifSome(bucketDefinitions)(_.bucketDefinitions(_))
        .ifSome(scoping)(_.scoping(_))
        .ifSome(bucketCriteria)(_.bucketCriteria(_))
        .build

    def s3Object(
      bucketArn: Option[String] = None,
      eTag: Option[String] = None,
      extension: Option[String] = None,
      key: Option[String] = None,
      lastModified: Option[__timestampIso8601] = None,
      path: Option[String] = None,
      publicAccess: Option[Boolean] = None,
      serverSideEncryption: Option[ServerSideEncryption] = None,
      size: Option[__long] = None,
      storageClass: Option[String] = None,
      tags: Option[List[KeyValuePair]] = None,
      versionId: Option[String] = None
    ): S3Object =
      S3Object
        .builder
        .ifSome(bucketArn)(_.bucketArn(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(extension)(_.extension(_))
        .ifSome(key)(_.key(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(path)(_.path(_))
        .ifSome(publicAccess)(_.publicAccess(_))
        .ifSome(serverSideEncryption)(_.serverSideEncryption(_))
        .ifSome(size)(_.size(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def scoping(
      excludes: Option[JobScopingBlock] = None,
      includes: Option[JobScopingBlock] = None
    ): Scoping =
      Scoping
        .builder
        .ifSome(excludes)(_.excludes(_))
        .ifSome(includes)(_.includes(_))
        .build

    def searchResourcesBucketCriteria(
      excludes: Option[SearchResourcesCriteriaBlock] = None,
      includes: Option[SearchResourcesCriteriaBlock] = None
    ): SearchResourcesBucketCriteria =
      SearchResourcesBucketCriteria
        .builder
        .ifSome(excludes)(_.excludes(_))
        .ifSome(includes)(_.includes(_))
        .build

    def searchResourcesCriteria(
      simpleCriterion: Option[SearchResourcesSimpleCriterion] = None,
      tagCriterion: Option[SearchResourcesTagCriterion] = None
    ): SearchResourcesCriteria =
      SearchResourcesCriteria
        .builder
        .ifSome(simpleCriterion)(_.simpleCriterion(_))
        .ifSome(tagCriterion)(_.tagCriterion(_))
        .build

    def searchResourcesCriteriaBlock(
      and: Option[List[SearchResourcesCriteria]] = None
    ): SearchResourcesCriteriaBlock =
      SearchResourcesCriteriaBlock
        .builder
        .ifSome(and)(_.and(_))
        .build

    def searchResourcesRequest(
      bucketCriteria: Option[SearchResourcesBucketCriteria] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortCriteria: Option[SearchResourcesSortCriteria] = None
    ): SearchResourcesRequest =
      SearchResourcesRequest
        .builder
        .ifSome(bucketCriteria)(_.bucketCriteria(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchResourcesResponse(
      matchingResources: Option[List[MatchingResource]] = None,
      nextToken: Option[String] = None
    ): SearchResourcesResponse =
      SearchResourcesResponse
        .builder
        .ifSome(matchingResources)(_.matchingResources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchResourcesSimpleCriterion(
      comparator: Option[String] = None,
      key: Option[String] = None,
      values: Option[List[__string]] = None
    ): SearchResourcesSimpleCriterion =
      SearchResourcesSimpleCriterion
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def searchResourcesSortCriteria(
      attributeName: Option[String] = None,
      orderBy: Option[String] = None
    ): SearchResourcesSortCriteria =
      SearchResourcesSortCriteria
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def searchResourcesTagCriterion(
      comparator: Option[String] = None,
      tagValues: Option[List[SearchResourcesTagCriterionPair]] = None
    ): SearchResourcesTagCriterion =
      SearchResourcesTagCriterion
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def searchResourcesTagCriterionPair(
      key: Option[String] = None,
      value: Option[String] = None
    ): SearchResourcesTagCriterionPair =
      SearchResourcesTagCriterionPair
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def securityHubConfiguration(
      publishClassificationFindings: Option[Boolean] = None,
      publishPolicyFindings: Option[Boolean] = None
    ): SecurityHubConfiguration =
      SecurityHubConfiguration
        .builder
        .ifSome(publishClassificationFindings)(_.publishClassificationFindings(_))
        .ifSome(publishPolicyFindings)(_.publishPolicyFindings(_))
        .build

    def sensitiveDataItem(
      category: Option[String] = None,
      detections: Option[List[DefaultDetection]] = None,
      totalCount: Option[__long] = None
    ): SensitiveDataItem =
      SensitiveDataItem
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(detections)(_.detections(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def serverSideEncryption(
      encryptionType: Option[String] = None,
      kmsMasterKeyId: Option[String] = None
    ): ServerSideEncryption =
      ServerSideEncryption
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsMasterKeyId)(_.kmsMasterKeyId(_))
        .build

    def serviceLimit(
      isServiceLimited: Option[Boolean] = None,
      unit: Option[String] = None,
      value: Option[__long] = None
    ): ServiceLimit =
      ServiceLimit
        .builder
        .ifSome(isServiceLimited)(_.isServiceLimited(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(value)(_.value(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sessionContext(
      attributes: Option[SessionContextAttributes] = None,
      sessionIssuer: Option[SessionIssuer] = None
    ): SessionContext =
      SessionContext
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(sessionIssuer)(_.sessionIssuer(_))
        .build

    def sessionContextAttributes(
      creationDate: Option[__timestampIso8601] = None,
      mfaAuthenticated: Option[Boolean] = None
    ): SessionContextAttributes =
      SessionContextAttributes
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(mfaAuthenticated)(_.mfaAuthenticated(_))
        .build

    def sessionIssuer(
      accountId: Option[String] = None,
      arn: Option[String] = None,
      principalId: Option[String] = None,
      `type`: Option[String] = None,
      userName: Option[String] = None
    ): SessionIssuer =
      SessionIssuer
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(userName)(_.userName(_))
        .build

    def severity(
      description: Option[String] = None,
      score: Option[__long] = None
    ): Severity =
      Severity
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(score)(_.score(_))
        .build

    def simpleCriterionForJob(
      comparator: Option[String] = None,
      key: Option[String] = None,
      values: Option[List[__string]] = None
    ): SimpleCriterionForJob =
      SimpleCriterionForJob
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def simpleScopeTerm(
      comparator: Option[String] = None,
      key: Option[String] = None,
      values: Option[List[__string]] = None
    ): SimpleScopeTerm =
      SimpleScopeTerm
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def sortCriteria(
      attributeName: Option[String] = None,
      orderBy: Option[String] = None
    ): SortCriteria =
      SortCriteria
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def statistics(
      approximateNumberOfObjectsToProcess: Option[__double] = None,
      numberOfRuns: Option[__double] = None
    ): Statistics =
      Statistics
        .builder
        .ifSome(approximateNumberOfObjectsToProcess)(_.approximateNumberOfObjectsToProcess(_))
        .ifSome(numberOfRuns)(_.numberOfRuns(_))
        .build

    def tagCriterionForJob(
      comparator: Option[String] = None,
      tagValues: Option[List[TagCriterionPairForJob]] = None
    ): TagCriterionForJob =
      TagCriterionForJob
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def tagCriterionPairForJob(
      key: Option[String] = None,
      value: Option[String] = None
    ): TagCriterionPairForJob =
      TagCriterionPairForJob
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
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

    def tagScopeTerm(
      comparator: Option[String] = None,
      key: Option[String] = None,
      tagValues: Option[List[TagValuePair]] = None,
      target: Option[String] = None
    ): TagScopeTerm =
      TagScopeTerm
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(key)(_.key(_))
        .ifSome(tagValues)(_.tagValues(_))
        .ifSome(target)(_.target(_))
        .build

    def tagValuePair(
      key: Option[String] = None,
      value: Option[String] = None
    ): TagValuePair =
      TagValuePair
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def testCustomDataIdentifierRequest(
      ignoreWords: Option[List[__string]] = None,
      keywords: Option[List[__string]] = None,
      maximumMatchDistance: Option[Int] = None,
      regex: Option[String] = None,
      sampleText: Option[String] = None
    ): TestCustomDataIdentifierRequest =
      TestCustomDataIdentifierRequest
        .builder
        .ifSome(ignoreWords)(_.ignoreWords(_))
        .ifSome(keywords)(_.keywords(_))
        .ifSome(maximumMatchDistance)(_.maximumMatchDistance(_))
        .ifSome(regex)(_.regex(_))
        .ifSome(sampleText)(_.sampleText(_))
        .build

    def testCustomDataIdentifierResponse(
      matchCount: Option[Int] = None
    ): TestCustomDataIdentifierResponse =
      TestCustomDataIdentifierResponse
        .builder
        .ifSome(matchCount)(_.matchCount(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unprocessedAccount(
      accountId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): UnprocessedAccount =
      UnprocessedAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
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

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateClassificationJobRequest(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): UpdateClassificationJobRequest =
      UpdateClassificationJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def updateClassificationJobResponse(

    ): UpdateClassificationJobResponse =
      UpdateClassificationJobResponse
        .builder

        .build

    def updateFindingsFilterRequest(
      action: Option[String] = None,
      description: Option[String] = None,
      findingCriteria: Option[FindingCriteria] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      position: Option[Int] = None,
      clientToken: Option[String] = None
    ): UpdateFindingsFilterRequest =
      UpdateFindingsFilterRequest
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(description)(_.description(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(position)(_.position(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateFindingsFilterResponse(
      arn: Option[String] = None,
      id: Option[String] = None
    ): UpdateFindingsFilterResponse =
      UpdateFindingsFilterResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def updateMacieSessionRequest(
      findingPublishingFrequency: Option[String] = None,
      status: Option[String] = None
    ): UpdateMacieSessionRequest =
      UpdateMacieSessionRequest
        .builder
        .ifSome(findingPublishingFrequency)(_.findingPublishingFrequency(_))
        .ifSome(status)(_.status(_))
        .build

    def updateMacieSessionResponse(

    ): UpdateMacieSessionResponse =
      UpdateMacieSessionResponse
        .builder

        .build

    def updateMemberSessionRequest(
      id: Option[String] = None,
      status: Option[String] = None
    ): UpdateMemberSessionRequest =
      UpdateMemberSessionRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .build

    def updateMemberSessionResponse(

    ): UpdateMemberSessionResponse =
      UpdateMemberSessionResponse
        .builder

        .build

    def updateOrganizationConfigurationRequest(
      autoEnable: Option[Boolean] = None
    ): UpdateOrganizationConfigurationRequest =
      UpdateOrganizationConfigurationRequest
        .builder
        .ifSome(autoEnable)(_.autoEnable(_))
        .build

    def updateOrganizationConfigurationResponse(

    ): UpdateOrganizationConfigurationResponse =
      UpdateOrganizationConfigurationResponse
        .builder

        .build

    def usageByAccount(
      currency: Option[String] = None,
      estimatedCost: Option[String] = None,
      serviceLimit: Option[ServiceLimit] = None,
      `type`: Option[String] = None
    ): UsageByAccount =
      UsageByAccount
        .builder
        .ifSome(currency)(_.currency(_))
        .ifSome(estimatedCost)(_.estimatedCost(_))
        .ifSome(serviceLimit)(_.serviceLimit(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def usageRecord(
      accountId: Option[String] = None,
      freeTrialStartDate: Option[__timestampIso8601] = None,
      usage: Option[List[UsageByAccount]] = None
    ): UsageRecord =
      UsageRecord
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(freeTrialStartDate)(_.freeTrialStartDate(_))
        .ifSome(usage)(_.usage(_))
        .build

    def usageStatisticsFilter(
      comparator: Option[String] = None,
      key: Option[String] = None,
      values: Option[List[__string]] = None
    ): UsageStatisticsFilter =
      UsageStatisticsFilter
        .builder
        .ifSome(comparator)(_.comparator(_))
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def usageStatisticsSortBy(
      key: Option[String] = None,
      orderBy: Option[String] = None
    ): UsageStatisticsSortBy =
      UsageStatisticsSortBy
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def usageTotal(
      currency: Option[String] = None,
      estimatedCost: Option[String] = None,
      `type`: Option[String] = None
    ): UsageTotal =
      UsageTotal
        .builder
        .ifSome(currency)(_.currency(_))
        .ifSome(estimatedCost)(_.estimatedCost(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def userIdentity(
      assumedRole: Option[AssumedRole] = None,
      awsAccount: Option[AwsAccount] = None,
      awsService: Option[AwsService] = None,
      federatedUser: Option[FederatedUser] = None,
      iamUser: Option[IamUser] = None,
      root: Option[UserIdentityRoot] = None,
      `type`: Option[String] = None
    ): UserIdentity =
      UserIdentity
        .builder
        .ifSome(assumedRole)(_.assumedRole(_))
        .ifSome(awsAccount)(_.awsAccount(_))
        .ifSome(awsService)(_.awsService(_))
        .ifSome(federatedUser)(_.federatedUser(_))
        .ifSome(iamUser)(_.iamUser(_))
        .ifSome(root)(_.root(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def userIdentityRoot(
      accountId: Option[String] = None,
      arn: Option[String] = None,
      principalId: Option[String] = None
    ): UserIdentityRoot =
      UserIdentityRoot
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def userPausedDetails(
      jobExpiresAt: Option[__timestampIso8601] = None,
      jobImminentExpirationHealthEventArn: Option[String] = None,
      jobPausedAt: Option[__timestampIso8601] = None
    ): UserPausedDetails =
      UserPausedDetails
        .builder
        .ifSome(jobExpiresAt)(_.jobExpiresAt(_))
        .ifSome(jobImminentExpirationHealthEventArn)(_.jobImminentExpirationHealthEventArn(_))
        .ifSome(jobPausedAt)(_.jobPausedAt(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def weeklySchedule(
      dayOfWeek: Option[String] = None
    ): WeeklySchedule =
      WeeklySchedule
        .builder
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
