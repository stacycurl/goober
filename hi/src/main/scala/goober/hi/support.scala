package goober.hi

import goober.free.support.SupportIO
import software.amazon.awssdk.services.support.model._


object support {
  import goober.free.{support ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addAttachmentsToSetRequest(
      attachmentSetId: Option[String] = None,
      attachments: Option[List[Attachment]] = None
    ): AddAttachmentsToSetRequest =
      AddAttachmentsToSetRequest
        .builder
        .ifSome(attachmentSetId)(_.attachmentSetId(_))
        .ifSome(attachments)(_.attachments(_))
        .build

    def addAttachmentsToSetResponse(
      attachmentSetId: Option[String] = None,
      expiryTime: Option[String] = None
    ): AddAttachmentsToSetResponse =
      AddAttachmentsToSetResponse
        .builder
        .ifSome(attachmentSetId)(_.attachmentSetId(_))
        .ifSome(expiryTime)(_.expiryTime(_))
        .build

    def addCommunicationToCaseRequest(
      caseId: Option[String] = None,
      communicationBody: Option[String] = None,
      ccEmailAddresses: Option[List[CcEmailAddress]] = None,
      attachmentSetId: Option[String] = None
    ): AddCommunicationToCaseRequest =
      AddCommunicationToCaseRequest
        .builder
        .ifSome(caseId)(_.caseId(_))
        .ifSome(communicationBody)(_.communicationBody(_))
        .ifSome(ccEmailAddresses)(_.ccEmailAddresses(_))
        .ifSome(attachmentSetId)(_.attachmentSetId(_))
        .build

    def addCommunicationToCaseResponse(
      result: Option[Boolean] = None
    ): AddCommunicationToCaseResponse =
      AddCommunicationToCaseResponse
        .builder
        .ifSome(result)(_.result(_))
        .build

    def attachment(
      fileName: Option[String] = None,
      data: Option[Data] = None
    ): Attachment =
      Attachment
        .builder
        .ifSome(fileName)(_.fileName(_))
        .ifSome(data)(_.data(_))
        .build

    def attachmentDetails(
      attachmentId: Option[String] = None,
      fileName: Option[String] = None
    ): AttachmentDetails =
      AttachmentDetails
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .ifSome(fileName)(_.fileName(_))
        .build

    def attachmentIdNotFound(
      message: Option[String] = None
    ): AttachmentIdNotFound =
      AttachmentIdNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachmentLimitExceeded(
      message: Option[String] = None
    ): AttachmentLimitExceeded =
      AttachmentLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachmentSetExpired(
      message: Option[String] = None
    ): AttachmentSetExpired =
      AttachmentSetExpired
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachmentSetIdNotFound(
      message: Option[String] = None
    ): AttachmentSetIdNotFound =
      AttachmentSetIdNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachmentSetSizeLimitExceeded(
      message: Option[String] = None
    ): AttachmentSetSizeLimitExceeded =
      AttachmentSetSizeLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def caseCreationLimitExceeded(
      message: Option[String] = None
    ): CaseCreationLimitExceeded =
      CaseCreationLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def caseDetails(
      caseId: Option[String] = None,
      displayId: Option[String] = None,
      subject: Option[String] = None,
      status: Option[String] = None,
      serviceCode: Option[String] = None,
      categoryCode: Option[String] = None,
      severityCode: Option[String] = None,
      submittedBy: Option[String] = None,
      timeCreated: Option[String] = None,
      recentCommunications: Option[RecentCaseCommunications] = None,
      ccEmailAddresses: Option[List[CcEmailAddress]] = None,
      language: Option[String] = None
    ): CaseDetails =
      CaseDetails
        .builder
        .ifSome(caseId)(_.caseId(_))
        .ifSome(displayId)(_.displayId(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(status)(_.status(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(categoryCode)(_.categoryCode(_))
        .ifSome(severityCode)(_.severityCode(_))
        .ifSome(submittedBy)(_.submittedBy(_))
        .ifSome(timeCreated)(_.timeCreated(_))
        .ifSome(recentCommunications)(_.recentCommunications(_))
        .ifSome(ccEmailAddresses)(_.ccEmailAddresses(_))
        .ifSome(language)(_.language(_))
        .build

    def caseIdNotFound(
      message: Option[String] = None
    ): CaseIdNotFound =
      CaseIdNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def category(
      code: Option[String] = None,
      name: Option[String] = None
    ): Category =
      Category
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(name)(_.name(_))
        .build

    def communication(
      caseId: Option[String] = None,
      body: Option[String] = None,
      submittedBy: Option[String] = None,
      timeCreated: Option[String] = None,
      attachmentSet: Option[List[AttachmentDetails]] = None
    ): Communication =
      Communication
        .builder
        .ifSome(caseId)(_.caseId(_))
        .ifSome(body)(_.body(_))
        .ifSome(submittedBy)(_.submittedBy(_))
        .ifSome(timeCreated)(_.timeCreated(_))
        .ifSome(attachmentSet)(_.attachmentSet(_))
        .build

    def createCaseRequest(
      subject: Option[String] = None,
      serviceCode: Option[String] = None,
      severityCode: Option[String] = None,
      categoryCode: Option[String] = None,
      communicationBody: Option[String] = None,
      ccEmailAddresses: Option[List[CcEmailAddress]] = None,
      language: Option[String] = None,
      issueType: Option[String] = None,
      attachmentSetId: Option[String] = None
    ): CreateCaseRequest =
      CreateCaseRequest
        .builder
        .ifSome(subject)(_.subject(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(severityCode)(_.severityCode(_))
        .ifSome(categoryCode)(_.categoryCode(_))
        .ifSome(communicationBody)(_.communicationBody(_))
        .ifSome(ccEmailAddresses)(_.ccEmailAddresses(_))
        .ifSome(language)(_.language(_))
        .ifSome(issueType)(_.issueType(_))
        .ifSome(attachmentSetId)(_.attachmentSetId(_))
        .build

    def createCaseResponse(
      caseId: Option[String] = None
    ): CreateCaseResponse =
      CreateCaseResponse
        .builder
        .ifSome(caseId)(_.caseId(_))
        .build

    def describeAttachmentLimitExceeded(
      message: Option[String] = None
    ): DescribeAttachmentLimitExceeded =
      DescribeAttachmentLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def describeAttachmentRequest(
      attachmentId: Option[String] = None
    ): DescribeAttachmentRequest =
      DescribeAttachmentRequest
        .builder
        .ifSome(attachmentId)(_.attachmentId(_))
        .build

    def describeAttachmentResponse(
      attachment: Option[Attachment] = None
    ): DescribeAttachmentResponse =
      DescribeAttachmentResponse
        .builder
        .ifSome(attachment)(_.attachment(_))
        .build

    def describeCasesRequest(
      caseIdList: Option[List[CaseId]] = None,
      displayId: Option[String] = None,
      afterTime: Option[String] = None,
      beforeTime: Option[String] = None,
      includeResolvedCases: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      language: Option[String] = None,
      includeCommunications: Option[Boolean] = None
    ): DescribeCasesRequest =
      DescribeCasesRequest
        .builder
        .ifSome(caseIdList)(_.caseIdList(_))
        .ifSome(displayId)(_.displayId(_))
        .ifSome(afterTime)(_.afterTime(_))
        .ifSome(beforeTime)(_.beforeTime(_))
        .ifSome(includeResolvedCases)(_.includeResolvedCases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(language)(_.language(_))
        .ifSome(includeCommunications)(_.includeCommunications(_))
        .build

    def describeCasesResponse(
      cases: Option[List[CaseDetails]] = None,
      nextToken: Option[String] = None
    ): DescribeCasesResponse =
      DescribeCasesResponse
        .builder
        .ifSome(cases)(_.cases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeCommunicationsRequest(
      caseId: Option[String] = None,
      beforeTime: Option[String] = None,
      afterTime: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeCommunicationsRequest =
      DescribeCommunicationsRequest
        .builder
        .ifSome(caseId)(_.caseId(_))
        .ifSome(beforeTime)(_.beforeTime(_))
        .ifSome(afterTime)(_.afterTime(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeCommunicationsResponse(
      communications: Option[List[Communication]] = None,
      nextToken: Option[String] = None
    ): DescribeCommunicationsResponse =
      DescribeCommunicationsResponse
        .builder
        .ifSome(communications)(_.communications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeServicesRequest(
      serviceCodeList: Option[List[ServiceCode]] = None,
      language: Option[String] = None
    ): DescribeServicesRequest =
      DescribeServicesRequest
        .builder
        .ifSome(serviceCodeList)(_.serviceCodeList(_))
        .ifSome(language)(_.language(_))
        .build

    def describeServicesResponse(
      services: Option[List[Service]] = None
    ): DescribeServicesResponse =
      DescribeServicesResponse
        .builder
        .ifSome(services)(_.services(_))
        .build

    def describeSeverityLevelsRequest(
      language: Option[String] = None
    ): DescribeSeverityLevelsRequest =
      DescribeSeverityLevelsRequest
        .builder
        .ifSome(language)(_.language(_))
        .build

    def describeSeverityLevelsResponse(
      severityLevels: Option[List[SeverityLevel]] = None
    ): DescribeSeverityLevelsResponse =
      DescribeSeverityLevelsResponse
        .builder
        .ifSome(severityLevels)(_.severityLevels(_))
        .build

    def describeTrustedAdvisorCheckRefreshStatusesRequest(
      checkIds: Option[List[String]] = None
    ): DescribeTrustedAdvisorCheckRefreshStatusesRequest =
      DescribeTrustedAdvisorCheckRefreshStatusesRequest
        .builder
        .ifSome(checkIds)(_.checkIds(_))
        .build

    def describeTrustedAdvisorCheckRefreshStatusesResponse(
      statuses: Option[List[TrustedAdvisorCheckRefreshStatus]] = None
    ): DescribeTrustedAdvisorCheckRefreshStatusesResponse =
      DescribeTrustedAdvisorCheckRefreshStatusesResponse
        .builder
        .ifSome(statuses)(_.statuses(_))
        .build

    def describeTrustedAdvisorCheckResultRequest(
      checkId: Option[String] = None,
      language: Option[String] = None
    ): DescribeTrustedAdvisorCheckResultRequest =
      DescribeTrustedAdvisorCheckResultRequest
        .builder
        .ifSome(checkId)(_.checkId(_))
        .ifSome(language)(_.language(_))
        .build

    def describeTrustedAdvisorCheckResultResponse(
      result: Option[TrustedAdvisorCheckResult] = None
    ): DescribeTrustedAdvisorCheckResultResponse =
      DescribeTrustedAdvisorCheckResultResponse
        .builder
        .ifSome(result)(_.result(_))
        .build

    def describeTrustedAdvisorCheckSummariesRequest(
      checkIds: Option[List[String]] = None
    ): DescribeTrustedAdvisorCheckSummariesRequest =
      DescribeTrustedAdvisorCheckSummariesRequest
        .builder
        .ifSome(checkIds)(_.checkIds(_))
        .build

    def describeTrustedAdvisorCheckSummariesResponse(
      summaries: Option[List[TrustedAdvisorCheckSummary]] = None
    ): DescribeTrustedAdvisorCheckSummariesResponse =
      DescribeTrustedAdvisorCheckSummariesResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .build

    def describeTrustedAdvisorChecksRequest(
      language: Option[String] = None
    ): DescribeTrustedAdvisorChecksRequest =
      DescribeTrustedAdvisorChecksRequest
        .builder
        .ifSome(language)(_.language(_))
        .build

    def describeTrustedAdvisorChecksResponse(
      checks: Option[List[TrustedAdvisorCheckDescription]] = None
    ): DescribeTrustedAdvisorChecksResponse =
      DescribeTrustedAdvisorChecksResponse
        .builder
        .ifSome(checks)(_.checks(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def recentCaseCommunications(
      communications: Option[List[Communication]] = None,
      nextToken: Option[String] = None
    ): RecentCaseCommunications =
      RecentCaseCommunications
        .builder
        .ifSome(communications)(_.communications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def refreshTrustedAdvisorCheckRequest(
      checkId: Option[String] = None
    ): RefreshTrustedAdvisorCheckRequest =
      RefreshTrustedAdvisorCheckRequest
        .builder
        .ifSome(checkId)(_.checkId(_))
        .build

    def refreshTrustedAdvisorCheckResponse(
      status: Option[TrustedAdvisorCheckRefreshStatus] = None
    ): RefreshTrustedAdvisorCheckResponse =
      RefreshTrustedAdvisorCheckResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def resolveCaseRequest(
      caseId: Option[String] = None
    ): ResolveCaseRequest =
      ResolveCaseRequest
        .builder
        .ifSome(caseId)(_.caseId(_))
        .build

    def resolveCaseResponse(
      initialCaseStatus: Option[String] = None,
      finalCaseStatus: Option[String] = None
    ): ResolveCaseResponse =
      ResolveCaseResponse
        .builder
        .ifSome(initialCaseStatus)(_.initialCaseStatus(_))
        .ifSome(finalCaseStatus)(_.finalCaseStatus(_))
        .build

    def service(
      code: Option[String] = None,
      name: Option[String] = None,
      categories: Option[List[Category]] = None
    ): Service =
      Service
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(name)(_.name(_))
        .ifSome(categories)(_.categories(_))
        .build

    def severityLevel(
      code: Option[String] = None,
      name: Option[String] = None
    ): SeverityLevel =
      SeverityLevel
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(name)(_.name(_))
        .build

    def trustedAdvisorCategorySpecificSummary(
      costOptimizing: Option[TrustedAdvisorCostOptimizingSummary] = None
    ): TrustedAdvisorCategorySpecificSummary =
      TrustedAdvisorCategorySpecificSummary
        .builder
        .ifSome(costOptimizing)(_.costOptimizing(_))
        .build

    def trustedAdvisorCheckDescription(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      category: Option[String] = None,
      metadata: Option[List[String]] = None
    ): TrustedAdvisorCheckDescription =
      TrustedAdvisorCheckDescription
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(category)(_.category(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def trustedAdvisorCheckRefreshStatus(
      checkId: Option[String] = None,
      status: Option[String] = None,
      millisUntilNextRefreshable: Option[Long] = None
    ): TrustedAdvisorCheckRefreshStatus =
      TrustedAdvisorCheckRefreshStatus
        .builder
        .ifSome(checkId)(_.checkId(_))
        .ifSome(status)(_.status(_))
        .ifSome(millisUntilNextRefreshable)(_.millisUntilNextRefreshable(_))
        .build

    def trustedAdvisorCheckSummary(
      checkId: Option[String] = None,
      timestamp: Option[String] = None,
      status: Option[String] = None,
      hasFlaggedResources: Option[Boolean] = None,
      resourcesSummary: Option[TrustedAdvisorResourcesSummary] = None,
      categorySpecificSummary: Option[TrustedAdvisorCategorySpecificSummary] = None
    ): TrustedAdvisorCheckSummary =
      TrustedAdvisorCheckSummary
        .builder
        .ifSome(checkId)(_.checkId(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(hasFlaggedResources)(_.hasFlaggedResources(_))
        .ifSome(resourcesSummary)(_.resourcesSummary(_))
        .ifSome(categorySpecificSummary)(_.categorySpecificSummary(_))
        .build

    def trustedAdvisorCostOptimizingSummary(
      estimatedMonthlySavings: Option[Double] = None,
      estimatedPercentMonthlySavings: Option[Double] = None
    ): TrustedAdvisorCostOptimizingSummary =
      TrustedAdvisorCostOptimizingSummary
        .builder
        .ifSome(estimatedMonthlySavings)(_.estimatedMonthlySavings(_))
        .ifSome(estimatedPercentMonthlySavings)(_.estimatedPercentMonthlySavings(_))
        .build

    def trustedAdvisorResourceDetail(
      status: Option[String] = None,
      region: Option[String] = None,
      resourceId: Option[String] = None,
      isSuppressed: Option[Boolean] = None,
      metadata: Option[List[String]] = None
    ): TrustedAdvisorResourceDetail =
      TrustedAdvisorResourceDetail
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(isSuppressed)(_.isSuppressed(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def trustedAdvisorResourcesSummary(
      resourcesProcessed: Option[Long] = None,
      resourcesFlagged: Option[Long] = None,
      resourcesIgnored: Option[Long] = None,
      resourcesSuppressed: Option[Long] = None
    ): TrustedAdvisorResourcesSummary =
      TrustedAdvisorResourcesSummary
        .builder
        .ifSome(resourcesProcessed)(_.resourcesProcessed(_))
        .ifSome(resourcesFlagged)(_.resourcesFlagged(_))
        .ifSome(resourcesIgnored)(_.resourcesIgnored(_))
        .ifSome(resourcesSuppressed)(_.resourcesSuppressed(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
