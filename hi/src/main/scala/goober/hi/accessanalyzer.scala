package goober.hi

import goober.free.accessanalyzer.AccessAnalyzerIO
import software.amazon.awssdk.services.accessanalyzer.model._


object accessanalyzer {
  import goober.free.{accessanalyzer ⇒ free}

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

    def accessPreview(
      analyzerArn: Option[String] = None,
      configurations: Option[ConfigurationsMap] = None,
      createdAt: Option[Timestamp] = None,
      id: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[AccessPreviewStatusReason] = None
    ): AccessPreview =
      AccessPreview
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .build

    def accessPreviewFinding(
      action: Option[List[String]] = None,
      changeType: Option[String] = None,
      condition: Option[ConditionKeyMap] = None,
      createdAt: Option[Timestamp] = None,
      error: Option[String] = None,
      existingFindingId: Option[String] = None,
      existingFindingStatus: Option[String] = None,
      id: Option[String] = None,
      isPublic: Option[Boolean] = None,
      principal: Option[PrincipalMap] = None,
      resource: Option[String] = None,
      resourceOwnerAccount: Option[String] = None,
      resourceType: Option[String] = None,
      sources: Option[List[FindingSource]] = None,
      status: Option[String] = None
    ): AccessPreviewFinding =
      AccessPreviewFinding
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(changeType)(_.changeType(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(error)(_.error(_))
        .ifSome(existingFindingId)(_.existingFindingId(_))
        .ifSome(existingFindingStatus)(_.existingFindingStatus(_))
        .ifSome(id)(_.id(_))
        .ifSome(isPublic)(_.isPublic(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(resourceOwnerAccount)(_.resourceOwnerAccount(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(status)(_.status(_))
        .build

    def accessPreviewStatusReason(
      code: Option[String] = None
    ): AccessPreviewStatusReason =
      AccessPreviewStatusReason
        .builder
        .ifSome(code)(_.code(_))
        .build

    def accessPreviewSummary(
      analyzerArn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      id: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[AccessPreviewStatusReason] = None
    ): AccessPreviewSummary =
      AccessPreviewSummary
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .build

    def aclGrantee(
      id: Option[String] = None,
      uri: Option[String] = None
    ): AclGrantee =
      AclGrantee
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(uri)(_.uri(_))
        .build

    def analyzedResource(
      actions: Option[List[String]] = None,
      analyzedAt: Option[Timestamp] = None,
      createdAt: Option[Timestamp] = None,
      error: Option[String] = None,
      isPublic: Option[Boolean] = None,
      resourceArn: Option[String] = None,
      resourceOwnerAccount: Option[String] = None,
      resourceType: Option[String] = None,
      sharedVia: Option[List[String]] = None,
      status: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): AnalyzedResource =
      AnalyzedResource
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(analyzedAt)(_.analyzedAt(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(error)(_.error(_))
        .ifSome(isPublic)(_.isPublic(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceOwnerAccount)(_.resourceOwnerAccount(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(sharedVia)(_.sharedVia(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def analyzedResourceSummary(
      resourceArn: Option[String] = None,
      resourceOwnerAccount: Option[String] = None,
      resourceType: Option[String] = None
    ): AnalyzedResourceSummary =
      AnalyzedResourceSummary
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceOwnerAccount)(_.resourceOwnerAccount(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def analyzerSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastResourceAnalyzed: Option[String] = None,
      lastResourceAnalyzedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[StatusReason] = None,
      tags: Option[TagsMap] = None,
      `type`: Option[String] = None
    ): AnalyzerSummary =
      AnalyzerSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastResourceAnalyzed)(_.lastResourceAnalyzed(_))
        .ifSome(lastResourceAnalyzedAt)(_.lastResourceAnalyzedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def applyArchiveRuleRequest(
      analyzerArn: Option[String] = None,
      clientToken: Option[String] = None,
      ruleName: Option[String] = None
    ): ApplyArchiveRuleRequest =
      ApplyArchiveRuleRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def archiveRuleSummary(
      createdAt: Option[Timestamp] = None,
      filter: Option[FilterCriteriaMap] = None,
      ruleName: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): ArchiveRuleSummary =
      ArchiveRuleSummary
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def cancelPolicyGenerationRequest(
      jobId: Option[String] = None
    ): CancelPolicyGenerationRequest =
      CancelPolicyGenerationRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def cancelPolicyGenerationResponse(

    ): CancelPolicyGenerationResponse =
      CancelPolicyGenerationResponse
        .builder

        .build

    def cloudTrailDetails(
      accessRole: Option[String] = None,
      endTime: Option[Timestamp] = None,
      startTime: Option[Timestamp] = None,
      trails: Option[List[Trail]] = None
    ): CloudTrailDetails =
      CloudTrailDetails
        .builder
        .ifSome(accessRole)(_.accessRole(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(trails)(_.trails(_))
        .build

    def cloudTrailProperties(
      endTime: Option[Timestamp] = None,
      startTime: Option[Timestamp] = None,
      trailProperties: Option[List[TrailProperties]] = None
    ): CloudTrailProperties =
      CloudTrailProperties
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(trailProperties)(_.trailProperties(_))
        .build

    def configuration(
      iamRole: Option[IamRoleConfiguration] = None,
      kmsKey: Option[KmsKeyConfiguration] = None,
      s3Bucket: Option[S3BucketConfiguration] = None,
      secretsManagerSecret: Option[SecretsManagerSecretConfiguration] = None,
      sqsQueue: Option[SqsQueueConfiguration] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(secretsManagerSecret)(_.secretsManagerSecret(_))
        .ifSome(sqsQueue)(_.sqsQueue(_))
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

    def createAccessPreviewRequest(
      analyzerArn: Option[String] = None,
      clientToken: Option[String] = None,
      configurations: Option[ConfigurationsMap] = None
    ): CreateAccessPreviewRequest =
      CreateAccessPreviewRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(configurations)(_.configurations(_))
        .build

    def createAccessPreviewResponse(
      id: Option[String] = None
    ): CreateAccessPreviewResponse =
      CreateAccessPreviewResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def createAnalyzerRequest(
      analyzerName: Option[String] = None,
      archiveRules: Option[List[InlineArchiveRule]] = None,
      clientToken: Option[String] = None,
      tags: Option[TagsMap] = None,
      `type`: Option[String] = None
    ): CreateAnalyzerRequest =
      CreateAnalyzerRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(archiveRules)(_.archiveRules(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createAnalyzerResponse(
      arn: Option[String] = None
    ): CreateAnalyzerResponse =
      CreateAnalyzerResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def createArchiveRuleRequest(
      analyzerName: Option[String] = None,
      clientToken: Option[String] = None,
      filter: Option[FilterCriteriaMap] = None,
      ruleName: Option[String] = None
    ): CreateArchiveRuleRequest =
      CreateArchiveRuleRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def criterion(
      contains: Option[List[String]] = None,
      eq: Option[List[String]] = None,
      exists: Option[Boolean] = None,
      neq: Option[List[String]] = None
    ): Criterion =
      Criterion
        .builder
        .ifSome(contains)(_.contains(_))
        .ifSome(eq)(_.eq(_))
        .ifSome(exists)(_.exists(_))
        .ifSome(neq)(_.neq(_))
        .build

    def deleteAnalyzerRequest(
      analyzerName: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteAnalyzerRequest =
      DeleteAnalyzerRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteArchiveRuleRequest(
      analyzerName: Option[String] = None,
      clientToken: Option[String] = None,
      ruleName: Option[String] = None
    ): DeleteArchiveRuleRequest =
      DeleteArchiveRuleRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def finding(
      action: Option[List[String]] = None,
      analyzedAt: Option[Timestamp] = None,
      condition: Option[ConditionKeyMap] = None,
      createdAt: Option[Timestamp] = None,
      error: Option[String] = None,
      id: Option[String] = None,
      isPublic: Option[Boolean] = None,
      principal: Option[PrincipalMap] = None,
      resource: Option[String] = None,
      resourceOwnerAccount: Option[String] = None,
      resourceType: Option[String] = None,
      sources: Option[List[FindingSource]] = None,
      status: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): Finding =
      Finding
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(analyzedAt)(_.analyzedAt(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(error)(_.error(_))
        .ifSome(id)(_.id(_))
        .ifSome(isPublic)(_.isPublic(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(resourceOwnerAccount)(_.resourceOwnerAccount(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def findingSource(
      detail: Option[FindingSourceDetail] = None,
      `type`: Option[String] = None
    ): FindingSource =
      FindingSource
        .builder
        .ifSome(detail)(_.detail(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def findingSourceDetail(
      accessPointArn: Option[String] = None
    ): FindingSourceDetail =
      FindingSourceDetail
        .builder
        .ifSome(accessPointArn)(_.accessPointArn(_))
        .build

    def findingSummary(
      action: Option[List[String]] = None,
      analyzedAt: Option[Timestamp] = None,
      condition: Option[ConditionKeyMap] = None,
      createdAt: Option[Timestamp] = None,
      error: Option[String] = None,
      id: Option[String] = None,
      isPublic: Option[Boolean] = None,
      principal: Option[PrincipalMap] = None,
      resource: Option[String] = None,
      resourceOwnerAccount: Option[String] = None,
      resourceType: Option[String] = None,
      sources: Option[List[FindingSource]] = None,
      status: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): FindingSummary =
      FindingSummary
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(analyzedAt)(_.analyzedAt(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(error)(_.error(_))
        .ifSome(id)(_.id(_))
        .ifSome(isPublic)(_.isPublic(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(resourceOwnerAccount)(_.resourceOwnerAccount(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def generatedPolicy(
      policy: Option[String] = None
    ): GeneratedPolicy =
      GeneratedPolicy
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def generatedPolicyProperties(
      cloudTrailProperties: Option[CloudTrailProperties] = None,
      isComplete: Option[Boolean] = None,
      principalArn: Option[String] = None
    ): GeneratedPolicyProperties =
      GeneratedPolicyProperties
        .builder
        .ifSome(cloudTrailProperties)(_.cloudTrailProperties(_))
        .ifSome(isComplete)(_.isComplete(_))
        .ifSome(principalArn)(_.principalArn(_))
        .build

    def getAccessPreviewRequest(
      accessPreviewId: Option[String] = None,
      analyzerArn: Option[String] = None
    ): GetAccessPreviewRequest =
      GetAccessPreviewRequest
        .builder
        .ifSome(accessPreviewId)(_.accessPreviewId(_))
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .build

    def getAccessPreviewResponse(
      accessPreview: Option[AccessPreview] = None
    ): GetAccessPreviewResponse =
      GetAccessPreviewResponse
        .builder
        .ifSome(accessPreview)(_.accessPreview(_))
        .build

    def getAnalyzedResourceRequest(
      analyzerArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): GetAnalyzedResourceRequest =
      GetAnalyzedResourceRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getAnalyzedResourceResponse(
      resource: Option[AnalyzedResource] = None
    ): GetAnalyzedResourceResponse =
      GetAnalyzedResourceResponse
        .builder
        .ifSome(resource)(_.resource(_))
        .build

    def getAnalyzerRequest(
      analyzerName: Option[String] = None
    ): GetAnalyzerRequest =
      GetAnalyzerRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .build

    def getAnalyzerResponse(
      analyzer: Option[AnalyzerSummary] = None
    ): GetAnalyzerResponse =
      GetAnalyzerResponse
        .builder
        .ifSome(analyzer)(_.analyzer(_))
        .build

    def getArchiveRuleRequest(
      analyzerName: Option[String] = None,
      ruleName: Option[String] = None
    ): GetArchiveRuleRequest =
      GetArchiveRuleRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def getArchiveRuleResponse(
      archiveRule: Option[ArchiveRuleSummary] = None
    ): GetArchiveRuleResponse =
      GetArchiveRuleResponse
        .builder
        .ifSome(archiveRule)(_.archiveRule(_))
        .build

    def getFindingRequest(
      analyzerArn: Option[String] = None,
      id: Option[String] = None
    ): GetFindingRequest =
      GetFindingRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(id)(_.id(_))
        .build

    def getFindingResponse(
      finding: Option[Finding] = None
    ): GetFindingResponse =
      GetFindingResponse
        .builder
        .ifSome(finding)(_.finding(_))
        .build

    def getGeneratedPolicyRequest(
      includeResourcePlaceholders: Option[Boolean] = None,
      includeServiceLevelTemplate: Option[Boolean] = None,
      jobId: Option[String] = None
    ): GetGeneratedPolicyRequest =
      GetGeneratedPolicyRequest
        .builder
        .ifSome(includeResourcePlaceholders)(_.includeResourcePlaceholders(_))
        .ifSome(includeServiceLevelTemplate)(_.includeServiceLevelTemplate(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def getGeneratedPolicyResponse(
      generatedPolicyResult: Option[GeneratedPolicyResult] = None,
      jobDetails: Option[JobDetails] = None
    ): GetGeneratedPolicyResponse =
      GetGeneratedPolicyResponse
        .builder
        .ifSome(generatedPolicyResult)(_.generatedPolicyResult(_))
        .ifSome(jobDetails)(_.jobDetails(_))
        .build

    def iamRoleConfiguration(
      trustPolicy: Option[String] = None
    ): IamRoleConfiguration =
      IamRoleConfiguration
        .builder
        .ifSome(trustPolicy)(_.trustPolicy(_))
        .build

    def inlineArchiveRule(
      filter: Option[FilterCriteriaMap] = None,
      ruleName: Option[String] = None
    ): InlineArchiveRule =
      InlineArchiveRule
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(ruleName)(_.ruleName(_))
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

    def internetConfiguration(

    ): InternetConfiguration =
      InternetConfiguration
        .builder

        .build

    def jobDetails(
      completedOn: Option[Timestamp] = None,
      jobError: Option[JobError] = None,
      jobId: Option[String] = None,
      startedOn: Option[Timestamp] = None,
      status: Option[String] = None
    ): JobDetails =
      JobDetails
        .builder
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(jobError)(_.jobError(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(status)(_.status(_))
        .build

    def jobError(
      code: Option[String] = None,
      message: Option[String] = None
    ): JobError =
      JobError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def kmsGrantConfiguration(
      constraints: Option[KmsGrantConstraints] = None,
      granteePrincipal: Option[String] = None,
      issuingAccount: Option[String] = None,
      operations: Option[List[KmsGrantOperation]] = None,
      retiringPrincipal: Option[String] = None
    ): KmsGrantConfiguration =
      KmsGrantConfiguration
        .builder
        .ifSome(constraints)(_.constraints(_))
        .ifSome(granteePrincipal)(_.granteePrincipal(_))
        .ifSome(issuingAccount)(_.issuingAccount(_))
        .ifSome(operations)(_.operations(_))
        .ifSome(retiringPrincipal)(_.retiringPrincipal(_))
        .build

    def kmsGrantConstraints(
      encryptionContextEquals: Option[KmsConstraintsMap] = None,
      encryptionContextSubset: Option[KmsConstraintsMap] = None
    ): KmsGrantConstraints =
      KmsGrantConstraints
        .builder
        .ifSome(encryptionContextEquals)(_.encryptionContextEquals(_))
        .ifSome(encryptionContextSubset)(_.encryptionContextSubset(_))
        .build

    def kmsKeyConfiguration(
      grants: Option[List[KmsGrantConfiguration]] = None,
      keyPolicies: Option[KmsKeyPoliciesMap] = None
    ): KmsKeyConfiguration =
      KmsKeyConfiguration
        .builder
        .ifSome(grants)(_.grants(_))
        .ifSome(keyPolicies)(_.keyPolicies(_))
        .build

    def listAccessPreviewFindingsRequest(
      accessPreviewId: Option[String] = None,
      analyzerArn: Option[String] = None,
      filter: Option[FilterCriteriaMap] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAccessPreviewFindingsRequest =
      ListAccessPreviewFindingsRequest
        .builder
        .ifSome(accessPreviewId)(_.accessPreviewId(_))
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccessPreviewFindingsResponse(
      findings: Option[List[AccessPreviewFinding]] = None,
      nextToken: Option[String] = None
    ): ListAccessPreviewFindingsResponse =
      ListAccessPreviewFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccessPreviewsRequest(
      analyzerArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAccessPreviewsRequest =
      ListAccessPreviewsRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccessPreviewsResponse(
      accessPreviews: Option[List[AccessPreviewSummary]] = None,
      nextToken: Option[String] = None
    ): ListAccessPreviewsResponse =
      ListAccessPreviewsResponse
        .builder
        .ifSome(accessPreviews)(_.accessPreviews(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnalyzedResourcesRequest(
      analyzerArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      resourceType: Option[String] = None
    ): ListAnalyzedResourcesRequest =
      ListAnalyzedResourcesRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listAnalyzedResourcesResponse(
      analyzedResources: Option[List[AnalyzedResourceSummary]] = None,
      nextToken: Option[String] = None
    ): ListAnalyzedResourcesResponse =
      ListAnalyzedResourcesResponse
        .builder
        .ifSome(analyzedResources)(_.analyzedResources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAnalyzersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      `type`: Option[String] = None
    ): ListAnalyzersRequest =
      ListAnalyzersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def listAnalyzersResponse(
      analyzers: Option[List[AnalyzerSummary]] = None,
      nextToken: Option[String] = None
    ): ListAnalyzersResponse =
      ListAnalyzersResponse
        .builder
        .ifSome(analyzers)(_.analyzers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listArchiveRulesRequest(
      analyzerName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListArchiveRulesRequest =
      ListArchiveRulesRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listArchiveRulesResponse(
      archiveRules: Option[List[ArchiveRuleSummary]] = None,
      nextToken: Option[String] = None
    ): ListArchiveRulesResponse =
      ListArchiveRulesResponse
        .builder
        .ifSome(archiveRules)(_.archiveRules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsRequest(
      analyzerArn: Option[String] = None,
      filter: Option[FilterCriteriaMap] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sort: Option[SortCriteria] = None
    ): ListFindingsRequest =
      ListFindingsRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sort)(_.sort(_))
        .build

    def listFindingsResponse(
      findings: Option[List[FindingSummary]] = None,
      nextToken: Option[String] = None
    ): ListFindingsResponse =
      ListFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPolicyGenerationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      principalArn: Option[String] = None
    ): ListPolicyGenerationsRequest =
      ListPolicyGenerationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(principalArn)(_.principalArn(_))
        .build

    def listPolicyGenerationsResponse(
      nextToken: Option[String] = None,
      policyGenerations: Option[List[PolicyGeneration]] = None
    ): ListPolicyGenerationsResponse =
      ListPolicyGenerationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(policyGenerations)(_.policyGenerations(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagsMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def location(
      path: Option[List[PathElement]] = None,
      span: Option[Span] = None
    ): Location =
      Location
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(span)(_.span(_))
        .build

    def networkOriginConfiguration(
      internetConfiguration: Option[InternetConfiguration] = None,
      vpcConfiguration: Option[VpcConfiguration] = None
    ): NetworkOriginConfiguration =
      NetworkOriginConfiguration
        .builder
        .ifSome(internetConfiguration)(_.internetConfiguration(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def pathElement(
      index: Option[Int] = None,
      key: Option[String] = None,
      substring: Option[Substring] = None,
      value: Option[String] = None
    ): PathElement =
      PathElement
        .builder
        .ifSome(index)(_.index(_))
        .ifSome(key)(_.key(_))
        .ifSome(substring)(_.substring(_))
        .ifSome(value)(_.value(_))
        .build

    def policyGeneration(
      completedOn: Option[Timestamp] = None,
      jobId: Option[String] = None,
      principalArn: Option[String] = None,
      startedOn: Option[Timestamp] = None,
      status: Option[String] = None
    ): PolicyGeneration =
      PolicyGeneration
        .builder
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(principalArn)(_.principalArn(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(status)(_.status(_))
        .build

    def policyGenerationDetails(
      principalArn: Option[String] = None
    ): PolicyGenerationDetails =
      PolicyGenerationDetails
        .builder
        .ifSome(principalArn)(_.principalArn(_))
        .build

    def position(
      column: Option[Int] = None,
      line: Option[Int] = None,
      offset: Option[Int] = None
    ): Position =
      Position
        .builder
        .ifSome(column)(_.column(_))
        .ifSome(line)(_.line(_))
        .ifSome(offset)(_.offset(_))
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

    def s3AccessPointConfiguration(
      accessPointPolicy: Option[String] = None,
      networkOrigin: Option[NetworkOriginConfiguration] = None,
      publicAccessBlock: Option[S3PublicAccessBlockConfiguration] = None
    ): S3AccessPointConfiguration =
      S3AccessPointConfiguration
        .builder
        .ifSome(accessPointPolicy)(_.accessPointPolicy(_))
        .ifSome(networkOrigin)(_.networkOrigin(_))
        .ifSome(publicAccessBlock)(_.publicAccessBlock(_))
        .build

    def s3BucketAclGrantConfiguration(
      grantee: Option[AclGrantee] = None,
      permission: Option[String] = None
    ): S3BucketAclGrantConfiguration =
      S3BucketAclGrantConfiguration
        .builder
        .ifSome(grantee)(_.grantee(_))
        .ifSome(permission)(_.permission(_))
        .build

    def s3BucketConfiguration(
      accessPoints: Option[S3AccessPointConfigurationsMap] = None,
      bucketAclGrants: Option[List[S3BucketAclGrantConfiguration]] = None,
      bucketPolicy: Option[String] = None,
      bucketPublicAccessBlock: Option[S3PublicAccessBlockConfiguration] = None
    ): S3BucketConfiguration =
      S3BucketConfiguration
        .builder
        .ifSome(accessPoints)(_.accessPoints(_))
        .ifSome(bucketAclGrants)(_.bucketAclGrants(_))
        .ifSome(bucketPolicy)(_.bucketPolicy(_))
        .ifSome(bucketPublicAccessBlock)(_.bucketPublicAccessBlock(_))
        .build

    def s3PublicAccessBlockConfiguration(
      ignorePublicAcls: Option[Boolean] = None,
      restrictPublicBuckets: Option[Boolean] = None
    ): S3PublicAccessBlockConfiguration =
      S3PublicAccessBlockConfiguration
        .builder
        .ifSome(ignorePublicAcls)(_.ignorePublicAcls(_))
        .ifSome(restrictPublicBuckets)(_.restrictPublicBuckets(_))
        .build

    def secretsManagerSecretConfiguration(
      kmsKeyId: Option[String] = None,
      secretPolicy: Option[String] = None
    ): SecretsManagerSecretConfiguration =
      SecretsManagerSecretConfiguration
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(secretPolicy)(_.secretPolicy(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
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

    def span(
      end: Option[Position] = None,
      start: Option[Position] = None
    ): Span =
      Span
        .builder
        .ifSome(end)(_.end(_))
        .ifSome(start)(_.start(_))
        .build

    def sqsQueueConfiguration(
      queuePolicy: Option[String] = None
    ): SqsQueueConfiguration =
      SqsQueueConfiguration
        .builder
        .ifSome(queuePolicy)(_.queuePolicy(_))
        .build

    def startPolicyGenerationRequest(
      clientToken: Option[String] = None,
      cloudTrailDetails: Option[CloudTrailDetails] = None,
      policyGenerationDetails: Option[PolicyGenerationDetails] = None
    ): StartPolicyGenerationRequest =
      StartPolicyGenerationRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(cloudTrailDetails)(_.cloudTrailDetails(_))
        .ifSome(policyGenerationDetails)(_.policyGenerationDetails(_))
        .build

    def startPolicyGenerationResponse(
      jobId: Option[String] = None
    ): StartPolicyGenerationResponse =
      StartPolicyGenerationResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startResourceScanRequest(
      analyzerArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): StartResourceScanRequest =
      StartResourceScanRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def statusReason(
      code: Option[String] = None
    ): StatusReason =
      StatusReason
        .builder
        .ifSome(code)(_.code(_))
        .build

    def substring(
      length: Option[Int] = None,
      start: Option[Int] = None
    ): Substring =
      Substring
        .builder
        .ifSome(length)(_.length(_))
        .ifSome(start)(_.start(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagsMap] = None
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
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def trail(
      allRegions: Option[Boolean] = None,
      cloudTrailArn: Option[String] = None,
      regions: Option[List[String]] = None
    ): Trail =
      Trail
        .builder
        .ifSome(allRegions)(_.allRegions(_))
        .ifSome(cloudTrailArn)(_.cloudTrailArn(_))
        .ifSome(regions)(_.regions(_))
        .build

    def trailProperties(
      allRegions: Option[Boolean] = None,
      cloudTrailArn: Option[String] = None,
      regions: Option[List[String]] = None
    ): TrailProperties =
      TrailProperties
        .builder
        .ifSome(allRegions)(_.allRegions(_))
        .ifSome(cloudTrailArn)(_.cloudTrailArn(_))
        .ifSome(regions)(_.regions(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
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

    def updateArchiveRuleRequest(
      analyzerName: Option[String] = None,
      clientToken: Option[String] = None,
      filter: Option[FilterCriteriaMap] = None,
      ruleName: Option[String] = None
    ): UpdateArchiveRuleRequest =
      UpdateArchiveRuleRequest
        .builder
        .ifSome(analyzerName)(_.analyzerName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def updateFindingsRequest(
      analyzerArn: Option[String] = None,
      clientToken: Option[String] = None,
      ids: Option[List[FindingId]] = None,
      resourceArn: Option[String] = None,
      status: Option[String] = None
    ): UpdateFindingsRequest =
      UpdateFindingsRequest
        .builder
        .ifSome(analyzerArn)(_.analyzerArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(ids)(_.ids(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(status)(_.status(_))
        .build

    def validatePolicyFinding(
      findingDetails: Option[String] = None,
      findingType: Option[String] = None,
      issueCode: Option[String] = None,
      learnMoreLink: Option[String] = None,
      locations: Option[List[Location]] = None
    ): ValidatePolicyFinding =
      ValidatePolicyFinding
        .builder
        .ifSome(findingDetails)(_.findingDetails(_))
        .ifSome(findingType)(_.findingType(_))
        .ifSome(issueCode)(_.issueCode(_))
        .ifSome(learnMoreLink)(_.learnMoreLink(_))
        .ifSome(locations)(_.locations(_))
        .build

    def validatePolicyRequest(
      locale: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      policyDocument: Option[String] = None,
      policyType: Option[String] = None
    ): ValidatePolicyRequest =
      ValidatePolicyRequest
        .builder
        .ifSome(locale)(_.locale(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(policyType)(_.policyType(_))
        .build

    def validatePolicyResponse(
      findings: Option[List[ValidatePolicyFinding]] = None,
      nextToken: Option[String] = None
    ): ValidatePolicyResponse =
      ValidatePolicyResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def validationException(
      fieldList: Option[List[ValidationExceptionField]] = None,
      message: Option[String] = None,
      reason: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(fieldList)(_.fieldList(_))
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def validationExceptionField(
      message: Option[String] = None,
      name: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(name)(_.name(_))
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
