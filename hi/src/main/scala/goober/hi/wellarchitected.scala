package goober.hi

import goober.free.wellarchitected.WellArchitectedIO
import software.amazon.awssdk.services.wellarchitected.model._


object wellarchitected {
  import goober.free.{wellarchitected ⇒ free}

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

    def answer(
      questionId: Option[String] = None,
      pillarId: Option[String] = None,
      questionTitle: Option[String] = None,
      questionDescription: Option[String] = None,
      improvementPlanUrl: Option[String] = None,
      helpfulResourceUrl: Option[String] = None,
      choices: Option[List[Choice]] = None,
      selectedChoices: Option[List[ChoiceId]] = None,
      isApplicable: Option[Boolean] = None,
      risk: Option[String] = None,
      notes: Option[String] = None
    ): Answer =
      Answer
        .builder
        .ifSome(questionId)(_.questionId(_))
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(questionTitle)(_.questionTitle(_))
        .ifSome(questionDescription)(_.questionDescription(_))
        .ifSome(improvementPlanUrl)(_.improvementPlanUrl(_))
        .ifSome(helpfulResourceUrl)(_.helpfulResourceUrl(_))
        .ifSome(choices)(_.choices(_))
        .ifSome(selectedChoices)(_.selectedChoices(_))
        .ifSome(isApplicable)(_.isApplicable(_))
        .ifSome(risk)(_.risk(_))
        .ifSome(notes)(_.notes(_))
        .build

    def answerSummary(
      questionId: Option[String] = None,
      pillarId: Option[String] = None,
      questionTitle: Option[String] = None,
      choices: Option[List[Choice]] = None,
      selectedChoices: Option[List[ChoiceId]] = None,
      isApplicable: Option[Boolean] = None,
      risk: Option[String] = None
    ): AnswerSummary =
      AnswerSummary
        .builder
        .ifSome(questionId)(_.questionId(_))
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(questionTitle)(_.questionTitle(_))
        .ifSome(choices)(_.choices(_))
        .ifSome(selectedChoices)(_.selectedChoices(_))
        .ifSome(isApplicable)(_.isApplicable(_))
        .ifSome(risk)(_.risk(_))
        .build

    def associateLensesInput(
      workloadId: Option[String] = None,
      lensAliases: Option[List[LensAlias]] = None
    ): AssociateLensesInput =
      AssociateLensesInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAliases)(_.lensAliases(_))
        .build

    def choice(
      choiceId: Option[String] = None,
      title: Option[String] = None,
      description: Option[String] = None
    ): Choice =
      Choice
        .builder
        .ifSome(choiceId)(_.choiceId(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
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

    def createMilestoneInput(
      workloadId: Option[String] = None,
      milestoneName: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): CreateMilestoneInput =
      CreateMilestoneInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneName)(_.milestoneName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createMilestoneOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None
    ): CreateMilestoneOutput =
      CreateMilestoneOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .build

    def createWorkloadInput(
      workloadName: Option[String] = None,
      description: Option[String] = None,
      environment: Option[String] = None,
      accountIds: Option[List[AwsAccountId]] = None,
      awsRegions: Option[List[AwsRegion]] = None,
      nonAwsRegions: Option[List[WorkloadNonAwsRegion]] = None,
      pillarPriorities: Option[List[PillarId]] = None,
      architecturalDesign: Option[String] = None,
      reviewOwner: Option[String] = None,
      industryType: Option[String] = None,
      industry: Option[String] = None,
      lenses: Option[List[LensAlias]] = None,
      notes: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateWorkloadInput =
      CreateWorkloadInput
        .builder
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(description)(_.description(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(awsRegions)(_.awsRegions(_))
        .ifSome(nonAwsRegions)(_.nonAwsRegions(_))
        .ifSome(pillarPriorities)(_.pillarPriorities(_))
        .ifSome(architecturalDesign)(_.architecturalDesign(_))
        .ifSome(reviewOwner)(_.reviewOwner(_))
        .ifSome(industryType)(_.industryType(_))
        .ifSome(industry)(_.industry(_))
        .ifSome(lenses)(_.lenses(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorkloadOutput(
      workloadId: Option[String] = None,
      workloadArn: Option[String] = None
    ): CreateWorkloadOutput =
      CreateWorkloadOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadArn)(_.workloadArn(_))
        .build

    def createWorkloadShareInput(
      workloadId: Option[String] = None,
      sharedWith: Option[String] = None,
      permissionType: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): CreateWorkloadShareInput =
      CreateWorkloadShareInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(sharedWith)(_.sharedWith(_))
        .ifSome(permissionType)(_.permissionType(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createWorkloadShareOutput(
      workloadId: Option[String] = None,
      shareId: Option[String] = None
    ): CreateWorkloadShareOutput =
      CreateWorkloadShareOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(shareId)(_.shareId(_))
        .build

    def deleteWorkloadInput(
      workloadId: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): DeleteWorkloadInput =
      DeleteWorkloadInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def deleteWorkloadShareInput(
      shareId: Option[String] = None,
      workloadId: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): DeleteWorkloadShareInput =
      DeleteWorkloadShareInput
        .builder
        .ifSome(shareId)(_.shareId(_))
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def disassociateLensesInput(
      workloadId: Option[String] = None,
      lensAliases: Option[List[LensAlias]] = None
    ): DisassociateLensesInput =
      DisassociateLensesInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAliases)(_.lensAliases(_))
        .build

    def getAnswerInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      questionId: Option[String] = None,
      milestoneNumber: Option[Int] = None
    ): GetAnswerInput =
      GetAnswerInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(questionId)(_.questionId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .build

    def getAnswerOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      lensAlias: Option[String] = None,
      answer: Option[Answer] = None
    ): GetAnswerOutput =
      GetAnswerOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(answer)(_.answer(_))
        .build

    def getLensReviewInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      milestoneNumber: Option[Int] = None
    ): GetLensReviewInput =
      GetLensReviewInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .build

    def getLensReviewOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      lensReview: Option[LensReview] = None
    ): GetLensReviewOutput =
      GetLensReviewOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(lensReview)(_.lensReview(_))
        .build

    def getLensReviewReportInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      milestoneNumber: Option[Int] = None
    ): GetLensReviewReportInput =
      GetLensReviewReportInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .build

    def getLensReviewReportOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      lensReviewReport: Option[LensReviewReport] = None
    ): GetLensReviewReportOutput =
      GetLensReviewReportOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(lensReviewReport)(_.lensReviewReport(_))
        .build

    def getLensVersionDifferenceInput(
      lensAlias: Option[String] = None,
      baseLensVersion: Option[String] = None
    ): GetLensVersionDifferenceInput =
      GetLensVersionDifferenceInput
        .builder
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(baseLensVersion)(_.baseLensVersion(_))
        .build

    def getLensVersionDifferenceOutput(
      lensAlias: Option[String] = None,
      baseLensVersion: Option[String] = None,
      latestLensVersion: Option[String] = None,
      versionDifferences: Option[VersionDifferences] = None
    ): GetLensVersionDifferenceOutput =
      GetLensVersionDifferenceOutput
        .builder
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(baseLensVersion)(_.baseLensVersion(_))
        .ifSome(latestLensVersion)(_.latestLensVersion(_))
        .ifSome(versionDifferences)(_.versionDifferences(_))
        .build

    def getMilestoneInput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None
    ): GetMilestoneInput =
      GetMilestoneInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .build

    def getMilestoneOutput(
      workloadId: Option[String] = None,
      milestone: Option[Milestone] = None
    ): GetMilestoneOutput =
      GetMilestoneOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestone)(_.milestone(_))
        .build

    def getWorkloadInput(
      workloadId: Option[String] = None
    ): GetWorkloadInput =
      GetWorkloadInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .build

    def getWorkloadOutput(
      workload: Option[Workload] = None
    ): GetWorkloadOutput =
      GetWorkloadOutput
        .builder
        .ifSome(workload)(_.workload(_))
        .build

    def improvementSummary(
      questionId: Option[String] = None,
      pillarId: Option[String] = None,
      questionTitle: Option[String] = None,
      risk: Option[String] = None,
      improvementPlanUrl: Option[String] = None
    ): ImprovementSummary =
      ImprovementSummary
        .builder
        .ifSome(questionId)(_.questionId(_))
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(questionTitle)(_.questionTitle(_))
        .ifSome(risk)(_.risk(_))
        .ifSome(improvementPlanUrl)(_.improvementPlanUrl(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lensReview(
      lensAlias: Option[String] = None,
      lensVersion: Option[String] = None,
      lensName: Option[String] = None,
      lensStatus: Option[String] = None,
      pillarReviewSummaries: Option[List[PillarReviewSummary]] = None,
      updatedAt: Option[Timestamp] = None,
      notes: Option[String] = None,
      riskCounts: Option[RiskCounts] = None,
      nextToken: Option[String] = None
    ): LensReview =
      LensReview
        .builder
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(lensVersion)(_.lensVersion(_))
        .ifSome(lensName)(_.lensName(_))
        .ifSome(lensStatus)(_.lensStatus(_))
        .ifSome(pillarReviewSummaries)(_.pillarReviewSummaries(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(riskCounts)(_.riskCounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lensReviewReport(
      lensAlias: Option[String] = None,
      base64String: Option[String] = None
    ): LensReviewReport =
      LensReviewReport
        .builder
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(base64String)(_.base64String(_))
        .build

    def lensReviewSummary(
      lensAlias: Option[String] = None,
      lensVersion: Option[String] = None,
      lensName: Option[String] = None,
      lensStatus: Option[String] = None,
      updatedAt: Option[Timestamp] = None,
      riskCounts: Option[RiskCounts] = None
    ): LensReviewSummary =
      LensReviewSummary
        .builder
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(lensVersion)(_.lensVersion(_))
        .ifSome(lensName)(_.lensName(_))
        .ifSome(lensStatus)(_.lensStatus(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(riskCounts)(_.riskCounts(_))
        .build

    def lensSummary(
      lensAlias: Option[String] = None,
      lensVersion: Option[String] = None,
      lensName: Option[String] = None,
      description: Option[String] = None
    ): LensSummary =
      LensSummary
        .builder
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(lensVersion)(_.lensVersion(_))
        .ifSome(lensName)(_.lensName(_))
        .ifSome(description)(_.description(_))
        .build

    def lensUpgradeSummary(
      workloadId: Option[String] = None,
      workloadName: Option[String] = None,
      lensAlias: Option[String] = None,
      currentLensVersion: Option[String] = None,
      latestLensVersion: Option[String] = None
    ): LensUpgradeSummary =
      LensUpgradeSummary
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(currentLensVersion)(_.currentLensVersion(_))
        .ifSome(latestLensVersion)(_.latestLensVersion(_))
        .build

    def listAnswersInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      pillarId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAnswersInput =
      ListAnswersInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAnswersOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      lensAlias: Option[String] = None,
      answerSummaries: Option[List[AnswerSummary]] = None,
      nextToken: Option[String] = None
    ): ListAnswersOutput =
      ListAnswersOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(answerSummaries)(_.answerSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLensReviewImprovementsInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      pillarId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLensReviewImprovementsInput =
      ListLensReviewImprovementsInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLensReviewImprovementsOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      lensAlias: Option[String] = None,
      improvementSummaries: Option[List[ImprovementSummary]] = None,
      nextToken: Option[String] = None
    ): ListLensReviewImprovementsOutput =
      ListLensReviewImprovementsOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(improvementSummaries)(_.improvementSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLensReviewsInput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLensReviewsInput =
      ListLensReviewsInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLensReviewsOutput(
      workloadId: Option[String] = None,
      milestoneNumber: Option[Int] = None,
      lensReviewSummaries: Option[List[LensReviewSummary]] = None,
      nextToken: Option[String] = None
    ): ListLensReviewsOutput =
      ListLensReviewsOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(lensReviewSummaries)(_.lensReviewSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLensesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLensesInput =
      ListLensesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLensesOutput(
      lensSummaries: Option[List[LensSummary]] = None,
      nextToken: Option[String] = None
    ): ListLensesOutput =
      ListLensesOutput
        .builder
        .ifSome(lensSummaries)(_.lensSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMilestonesInput(
      workloadId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMilestonesInput =
      ListMilestonesInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMilestonesOutput(
      workloadId: Option[String] = None,
      milestoneSummaries: Option[List[MilestoneSummary]] = None,
      nextToken: Option[String] = None
    ): ListMilestonesOutput =
      ListMilestonesOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(milestoneSummaries)(_.milestoneSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNotificationsInput(
      workloadId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListNotificationsInput =
      ListNotificationsInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listNotificationsOutput(
      notificationSummaries: Option[List[NotificationSummary]] = None,
      nextToken: Option[String] = None
    ): ListNotificationsOutput =
      ListNotificationsOutput
        .builder
        .ifSome(notificationSummaries)(_.notificationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listShareInvitationsInput(
      workloadNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListShareInvitationsInput =
      ListShareInvitationsInput
        .builder
        .ifSome(workloadNamePrefix)(_.workloadNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listShareInvitationsOutput(
      shareInvitationSummaries: Option[List[ShareInvitationSummary]] = None,
      nextToken: Option[String] = None
    ): ListShareInvitationsOutput =
      ListShareInvitationsOutput
        .builder
        .ifSome(shareInvitationSummaries)(_.shareInvitationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      workloadArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(workloadArn)(_.workloadArn(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[TagMap] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listWorkloadSharesInput(
      workloadId: Option[String] = None,
      sharedWithPrefix: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkloadSharesInput =
      ListWorkloadSharesInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(sharedWithPrefix)(_.sharedWithPrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkloadSharesOutput(
      workloadId: Option[String] = None,
      workloadShareSummaries: Option[List[WorkloadShareSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorkloadSharesOutput =
      ListWorkloadSharesOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadShareSummaries)(_.workloadShareSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorkloadsInput(
      workloadNamePrefix: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkloadsInput =
      ListWorkloadsInput
        .builder
        .ifSome(workloadNamePrefix)(_.workloadNamePrefix(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkloadsOutput(
      workloadSummaries: Option[List[WorkloadSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorkloadsOutput =
      ListWorkloadsOutput
        .builder
        .ifSome(workloadSummaries)(_.workloadSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def milestone(
      milestoneNumber: Option[Int] = None,
      milestoneName: Option[String] = None,
      recordedAt: Option[Timestamp] = None,
      workload: Option[Workload] = None
    ): Milestone =
      Milestone
        .builder
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(milestoneName)(_.milestoneName(_))
        .ifSome(recordedAt)(_.recordedAt(_))
        .ifSome(workload)(_.workload(_))
        .build

    def milestoneSummary(
      milestoneNumber: Option[Int] = None,
      milestoneName: Option[String] = None,
      recordedAt: Option[Timestamp] = None,
      workloadSummary: Option[WorkloadSummary] = None
    ): MilestoneSummary =
      MilestoneSummary
        .builder
        .ifSome(milestoneNumber)(_.milestoneNumber(_))
        .ifSome(milestoneName)(_.milestoneName(_))
        .ifSome(recordedAt)(_.recordedAt(_))
        .ifSome(workloadSummary)(_.workloadSummary(_))
        .build

    def notificationSummary(
      `type`: Option[String] = None,
      lensUpgradeSummary: Option[LensUpgradeSummary] = None
    ): NotificationSummary =
      NotificationSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(lensUpgradeSummary)(_.lensUpgradeSummary(_))
        .build

    def pillarDifference(
      pillarId: Option[String] = None,
      differenceStatus: Option[String] = None,
      questionDifferences: Option[List[QuestionDifference]] = None
    ): PillarDifference =
      PillarDifference
        .builder
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(differenceStatus)(_.differenceStatus(_))
        .ifSome(questionDifferences)(_.questionDifferences(_))
        .build

    def pillarReviewSummary(
      pillarId: Option[String] = None,
      pillarName: Option[String] = None,
      notes: Option[String] = None,
      riskCounts: Option[RiskCounts] = None
    ): PillarReviewSummary =
      PillarReviewSummary
        .builder
        .ifSome(pillarId)(_.pillarId(_))
        .ifSome(pillarName)(_.pillarName(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(riskCounts)(_.riskCounts(_))
        .build

    def questionDifference(
      questionId: Option[String] = None,
      questionTitle: Option[String] = None,
      differenceStatus: Option[String] = None
    ): QuestionDifference =
      QuestionDifference
        .builder
        .ifSome(questionId)(_.questionId(_))
        .ifSome(questionTitle)(_.questionTitle(_))
        .ifSome(differenceStatus)(_.differenceStatus(_))
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

    def serviceQuotaExceededException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def shareInvitation(
      shareInvitationId: Option[String] = None,
      workloadId: Option[String] = None
    ): ShareInvitation =
      ShareInvitation
        .builder
        .ifSome(shareInvitationId)(_.shareInvitationId(_))
        .ifSome(workloadId)(_.workloadId(_))
        .build

    def shareInvitationSummary(
      shareInvitationId: Option[String] = None,
      sharedBy: Option[String] = None,
      sharedWith: Option[String] = None,
      permissionType: Option[String] = None,
      workloadName: Option[String] = None,
      workloadId: Option[String] = None
    ): ShareInvitationSummary =
      ShareInvitationSummary
        .builder
        .ifSome(shareInvitationId)(_.shareInvitationId(_))
        .ifSome(sharedBy)(_.sharedBy(_))
        .ifSome(sharedWith)(_.sharedWith(_))
        .ifSome(permissionType)(_.permissionType(_))
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(workloadId)(_.workloadId(_))
        .build

    def tagResourceInput(
      workloadArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(workloadArn)(_.workloadArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def throttlingException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def untagResourceInput(
      workloadArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(workloadArn)(_.workloadArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateAnswerInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      questionId: Option[String] = None,
      selectedChoices: Option[List[ChoiceId]] = None,
      notes: Option[String] = None,
      isApplicable: Option[Boolean] = None
    ): UpdateAnswerInput =
      UpdateAnswerInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(questionId)(_.questionId(_))
        .ifSome(selectedChoices)(_.selectedChoices(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(isApplicable)(_.isApplicable(_))
        .build

    def updateAnswerOutput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      answer: Option[Answer] = None
    ): UpdateAnswerOutput =
      UpdateAnswerOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(answer)(_.answer(_))
        .build

    def updateLensReviewInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      lensNotes: Option[String] = None,
      pillarNotes: Option[PillarNotes] = None
    ): UpdateLensReviewInput =
      UpdateLensReviewInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(lensNotes)(_.lensNotes(_))
        .ifSome(pillarNotes)(_.pillarNotes(_))
        .build

    def updateLensReviewOutput(
      workloadId: Option[String] = None,
      lensReview: Option[LensReview] = None
    ): UpdateLensReviewOutput =
      UpdateLensReviewOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensReview)(_.lensReview(_))
        .build

    def updateShareInvitationInput(
      shareInvitationId: Option[String] = None,
      shareInvitationAction: Option[String] = None
    ): UpdateShareInvitationInput =
      UpdateShareInvitationInput
        .builder
        .ifSome(shareInvitationId)(_.shareInvitationId(_))
        .ifSome(shareInvitationAction)(_.shareInvitationAction(_))
        .build

    def updateShareInvitationOutput(
      shareInvitation: Option[ShareInvitation] = None
    ): UpdateShareInvitationOutput =
      UpdateShareInvitationOutput
        .builder
        .ifSome(shareInvitation)(_.shareInvitation(_))
        .build

    def updateWorkloadInput(
      workloadId: Option[String] = None,
      workloadName: Option[String] = None,
      description: Option[String] = None,
      environment: Option[String] = None,
      accountIds: Option[List[AwsAccountId]] = None,
      awsRegions: Option[List[AwsRegion]] = None,
      nonAwsRegions: Option[List[WorkloadNonAwsRegion]] = None,
      pillarPriorities: Option[List[PillarId]] = None,
      architecturalDesign: Option[String] = None,
      reviewOwner: Option[String] = None,
      isReviewOwnerUpdateAcknowledged: Option[Boolean] = None,
      industryType: Option[String] = None,
      industry: Option[String] = None,
      notes: Option[String] = None,
      improvementStatus: Option[String] = None
    ): UpdateWorkloadInput =
      UpdateWorkloadInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(description)(_.description(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(awsRegions)(_.awsRegions(_))
        .ifSome(nonAwsRegions)(_.nonAwsRegions(_))
        .ifSome(pillarPriorities)(_.pillarPriorities(_))
        .ifSome(architecturalDesign)(_.architecturalDesign(_))
        .ifSome(reviewOwner)(_.reviewOwner(_))
        .ifSome(isReviewOwnerUpdateAcknowledged)(_.isReviewOwnerUpdateAcknowledged(_))
        .ifSome(industryType)(_.industryType(_))
        .ifSome(industry)(_.industry(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(improvementStatus)(_.improvementStatus(_))
        .build

    def updateWorkloadOutput(
      workload: Option[Workload] = None
    ): UpdateWorkloadOutput =
      UpdateWorkloadOutput
        .builder
        .ifSome(workload)(_.workload(_))
        .build

    def updateWorkloadShareInput(
      shareId: Option[String] = None,
      workloadId: Option[String] = None,
      permissionType: Option[String] = None
    ): UpdateWorkloadShareInput =
      UpdateWorkloadShareInput
        .builder
        .ifSome(shareId)(_.shareId(_))
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(permissionType)(_.permissionType(_))
        .build

    def updateWorkloadShareOutput(
      workloadId: Option[String] = None,
      workloadShare: Option[WorkloadShare] = None
    ): UpdateWorkloadShareOutput =
      UpdateWorkloadShareOutput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadShare)(_.workloadShare(_))
        .build

    def upgradeLensReviewInput(
      workloadId: Option[String] = None,
      lensAlias: Option[String] = None,
      milestoneName: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): UpgradeLensReviewInput =
      UpgradeLensReviewInput
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(lensAlias)(_.lensAlias(_))
        .ifSome(milestoneName)(_.milestoneName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
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

    def versionDifferences(
      pillarDifferences: Option[List[PillarDifference]] = None
    ): VersionDifferences =
      VersionDifferences
        .builder
        .ifSome(pillarDifferences)(_.pillarDifferences(_))
        .build

    def workload(
      workloadId: Option[String] = None,
      workloadArn: Option[String] = None,
      workloadName: Option[String] = None,
      description: Option[String] = None,
      environment: Option[String] = None,
      updatedAt: Option[Timestamp] = None,
      accountIds: Option[List[AwsAccountId]] = None,
      awsRegions: Option[List[AwsRegion]] = None,
      nonAwsRegions: Option[List[WorkloadNonAwsRegion]] = None,
      architecturalDesign: Option[String] = None,
      reviewOwner: Option[String] = None,
      reviewRestrictionDate: Option[Timestamp] = None,
      isReviewOwnerUpdateAcknowledged: Option[Boolean] = None,
      industryType: Option[String] = None,
      industry: Option[String] = None,
      notes: Option[String] = None,
      improvementStatus: Option[String] = None,
      riskCounts: Option[RiskCounts] = None,
      pillarPriorities: Option[List[PillarId]] = None,
      lenses: Option[List[LensAlias]] = None,
      owner: Option[String] = None,
      shareInvitationId: Option[String] = None,
      tags: Option[TagMap] = None
    ): Workload =
      Workload
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadArn)(_.workloadArn(_))
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(description)(_.description(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(awsRegions)(_.awsRegions(_))
        .ifSome(nonAwsRegions)(_.nonAwsRegions(_))
        .ifSome(architecturalDesign)(_.architecturalDesign(_))
        .ifSome(reviewOwner)(_.reviewOwner(_))
        .ifSome(reviewRestrictionDate)(_.reviewRestrictionDate(_))
        .ifSome(isReviewOwnerUpdateAcknowledged)(_.isReviewOwnerUpdateAcknowledged(_))
        .ifSome(industryType)(_.industryType(_))
        .ifSome(industry)(_.industry(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(improvementStatus)(_.improvementStatus(_))
        .ifSome(riskCounts)(_.riskCounts(_))
        .ifSome(pillarPriorities)(_.pillarPriorities(_))
        .ifSome(lenses)(_.lenses(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(shareInvitationId)(_.shareInvitationId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def workloadShare(
      shareId: Option[String] = None,
      sharedBy: Option[String] = None,
      sharedWith: Option[String] = None,
      permissionType: Option[String] = None,
      status: Option[String] = None,
      workloadName: Option[String] = None,
      workloadId: Option[String] = None
    ): WorkloadShare =
      WorkloadShare
        .builder
        .ifSome(shareId)(_.shareId(_))
        .ifSome(sharedBy)(_.sharedBy(_))
        .ifSome(sharedWith)(_.sharedWith(_))
        .ifSome(permissionType)(_.permissionType(_))
        .ifSome(status)(_.status(_))
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(workloadId)(_.workloadId(_))
        .build

    def workloadShareSummary(
      shareId: Option[String] = None,
      sharedWith: Option[String] = None,
      permissionType: Option[String] = None,
      status: Option[String] = None
    ): WorkloadShareSummary =
      WorkloadShareSummary
        .builder
        .ifSome(shareId)(_.shareId(_))
        .ifSome(sharedWith)(_.sharedWith(_))
        .ifSome(permissionType)(_.permissionType(_))
        .ifSome(status)(_.status(_))
        .build

    def workloadSummary(
      workloadId: Option[String] = None,
      workloadArn: Option[String] = None,
      workloadName: Option[String] = None,
      owner: Option[String] = None,
      updatedAt: Option[Timestamp] = None,
      lenses: Option[List[LensAlias]] = None,
      riskCounts: Option[RiskCounts] = None,
      improvementStatus: Option[String] = None
    ): WorkloadSummary =
      WorkloadSummary
        .builder
        .ifSome(workloadId)(_.workloadId(_))
        .ifSome(workloadArn)(_.workloadArn(_))
        .ifSome(workloadName)(_.workloadName(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(lenses)(_.lenses(_))
        .ifSome(riskCounts)(_.riskCounts(_))
        .ifSome(improvementStatus)(_.improvementStatus(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
