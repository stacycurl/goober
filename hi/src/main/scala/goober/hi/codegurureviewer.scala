package goober.hi

import goober.free.codegurureviewer.CodeGuruReviewerIO
import software.amazon.awssdk.services.codegurureviewer.model._


object codegurureviewer {
  import goober.free.{codegurureviewer ⇒ free}

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

    def associateRepositoryRequest(
      repository: Option[Repository] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[TagMap] = None,
      kMSKeyDetails: Option[KMSKeyDetails] = None
    ): AssociateRepositoryRequest =
      AssociateRepositoryRequest
        .builder
        .ifSome(repository)(_.repository(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kMSKeyDetails)(_.kMSKeyDetails(_))
        .build

    def associateRepositoryResponse(
      repositoryAssociation: Option[RepositoryAssociation] = None,
      tags: Option[TagMap] = None
    ): AssociateRepositoryResponse =
      AssociateRepositoryResponse
        .builder
        .ifSome(repositoryAssociation)(_.repositoryAssociation(_))
        .ifSome(tags)(_.tags(_))
        .build

    def codeCommitRepository(
      name: Option[String] = None
    ): CodeCommitRepository =
      CodeCommitRepository
        .builder
        .ifSome(name)(_.name(_))
        .build

    def codeReview(
      name: Option[String] = None,
      codeReviewArn: Option[String] = None,
      repositoryName: Option[String] = None,
      owner: Option[String] = None,
      providerType: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      createdTimeStamp: Option[TimeStamp] = None,
      lastUpdatedTimeStamp: Option[TimeStamp] = None,
      `type`: Option[String] = None,
      pullRequestId: Option[String] = None,
      sourceCodeType: Option[SourceCodeType] = None,
      associationArn: Option[String] = None,
      metrics: Option[Metrics] = None
    ): CodeReview =
      CodeReview
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(createdTimeStamp)(_.createdTimeStamp(_))
        .ifSome(lastUpdatedTimeStamp)(_.lastUpdatedTimeStamp(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(sourceCodeType)(_.sourceCodeType(_))
        .ifSome(associationArn)(_.associationArn(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def codeReviewSummary(
      name: Option[String] = None,
      codeReviewArn: Option[String] = None,
      repositoryName: Option[String] = None,
      owner: Option[String] = None,
      providerType: Option[String] = None,
      state: Option[String] = None,
      createdTimeStamp: Option[TimeStamp] = None,
      lastUpdatedTimeStamp: Option[TimeStamp] = None,
      `type`: Option[String] = None,
      pullRequestId: Option[String] = None,
      metricsSummary: Option[MetricsSummary] = None
    ): CodeReviewSummary =
      CodeReviewSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(state)(_.state(_))
        .ifSome(createdTimeStamp)(_.createdTimeStamp(_))
        .ifSome(lastUpdatedTimeStamp)(_.lastUpdatedTimeStamp(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(metricsSummary)(_.metricsSummary(_))
        .build

    def codeReviewType(
      repositoryAnalysis: Option[RepositoryAnalysis] = None
    ): CodeReviewType =
      CodeReviewType
        .builder
        .ifSome(repositoryAnalysis)(_.repositoryAnalysis(_))
        .build

    def commitDiffSourceCodeType(
      sourceCommit: Option[String] = None,
      destinationCommit: Option[String] = None
    ): CommitDiffSourceCodeType =
      CommitDiffSourceCodeType
        .builder
        .ifSome(sourceCommit)(_.sourceCommit(_))
        .ifSome(destinationCommit)(_.destinationCommit(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createCodeReviewRequest(
      name: Option[String] = None,
      repositoryAssociationArn: Option[String] = None,
      `type`: Option[CodeReviewType] = None,
      clientRequestToken: Option[String] = None
    ): CreateCodeReviewRequest =
      CreateCodeReviewRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(repositoryAssociationArn)(_.repositoryAssociationArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createCodeReviewResponse(
      codeReview: Option[CodeReview] = None
    ): CreateCodeReviewResponse =
      CreateCodeReviewResponse
        .builder
        .ifSome(codeReview)(_.codeReview(_))
        .build

    def describeCodeReviewRequest(
      codeReviewArn: Option[String] = None
    ): DescribeCodeReviewRequest =
      DescribeCodeReviewRequest
        .builder
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .build

    def describeCodeReviewResponse(
      codeReview: Option[CodeReview] = None
    ): DescribeCodeReviewResponse =
      DescribeCodeReviewResponse
        .builder
        .ifSome(codeReview)(_.codeReview(_))
        .build

    def describeRecommendationFeedbackRequest(
      codeReviewArn: Option[String] = None,
      recommendationId: Option[String] = None,
      userId: Option[String] = None
    ): DescribeRecommendationFeedbackRequest =
      DescribeRecommendationFeedbackRequest
        .builder
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def describeRecommendationFeedbackResponse(
      recommendationFeedback: Option[RecommendationFeedback] = None
    ): DescribeRecommendationFeedbackResponse =
      DescribeRecommendationFeedbackResponse
        .builder
        .ifSome(recommendationFeedback)(_.recommendationFeedback(_))
        .build

    def describeRepositoryAssociationRequest(
      associationArn: Option[String] = None
    ): DescribeRepositoryAssociationRequest =
      DescribeRepositoryAssociationRequest
        .builder
        .ifSome(associationArn)(_.associationArn(_))
        .build

    def describeRepositoryAssociationResponse(
      repositoryAssociation: Option[RepositoryAssociation] = None,
      tags: Option[TagMap] = None
    ): DescribeRepositoryAssociationResponse =
      DescribeRepositoryAssociationResponse
        .builder
        .ifSome(repositoryAssociation)(_.repositoryAssociation(_))
        .ifSome(tags)(_.tags(_))
        .build

    def disassociateRepositoryRequest(
      associationArn: Option[String] = None
    ): DisassociateRepositoryRequest =
      DisassociateRepositoryRequest
        .builder
        .ifSome(associationArn)(_.associationArn(_))
        .build

    def disassociateRepositoryResponse(
      repositoryAssociation: Option[RepositoryAssociation] = None,
      tags: Option[TagMap] = None
    ): DisassociateRepositoryResponse =
      DisassociateRepositoryResponse
        .builder
        .ifSome(repositoryAssociation)(_.repositoryAssociation(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSKeyDetails(
      kMSKeyId: Option[String] = None,
      encryptionOption: Option[String] = None
    ): KMSKeyDetails =
      KMSKeyDetails
        .builder
        .ifSome(kMSKeyId)(_.kMSKeyId(_))
        .ifSome(encryptionOption)(_.encryptionOption(_))
        .build

    def listCodeReviewsRequest(
      providerTypes: Option[List[ProviderType]] = None,
      states: Option[List[JobState]] = None,
      repositoryNames: Option[List[Name]] = None,
      `type`: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListCodeReviewsRequest =
      ListCodeReviewsRequest
        .builder
        .ifSome(providerTypes)(_.providerTypes(_))
        .ifSome(states)(_.states(_))
        .ifSome(repositoryNames)(_.repositoryNames(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCodeReviewsResponse(
      codeReviewSummaries: Option[List[CodeReviewSummary]] = None,
      nextToken: Option[String] = None
    ): ListCodeReviewsResponse =
      ListCodeReviewsResponse
        .builder
        .ifSome(codeReviewSummaries)(_.codeReviewSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecommendationFeedbackRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      codeReviewArn: Option[String] = None,
      userIds: Option[List[UserId]] = None,
      recommendationIds: Option[List[RecommendationId]] = None
    ): ListRecommendationFeedbackRequest =
      ListRecommendationFeedbackRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(recommendationIds)(_.recommendationIds(_))
        .build

    def listRecommendationFeedbackResponse(
      recommendationFeedbackSummaries: Option[List[RecommendationFeedbackSummary]] = None,
      nextToken: Option[String] = None
    ): ListRecommendationFeedbackResponse =
      ListRecommendationFeedbackResponse
        .builder
        .ifSome(recommendationFeedbackSummaries)(_.recommendationFeedbackSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecommendationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      codeReviewArn: Option[String] = None
    ): ListRecommendationsRequest =
      ListRecommendationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .build

    def listRecommendationsResponse(
      recommendationSummaries: Option[List[RecommendationSummary]] = None,
      nextToken: Option[String] = None
    ): ListRecommendationsResponse =
      ListRecommendationsResponse
        .builder
        .ifSome(recommendationSummaries)(_.recommendationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRepositoryAssociationsRequest(
      providerTypes: Option[List[ProviderType]] = None,
      states: Option[List[RepositoryAssociationState]] = None,
      names: Option[List[Name]] = None,
      owners: Option[List[Owner]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRepositoryAssociationsRequest =
      ListRepositoryAssociationsRequest
        .builder
        .ifSome(providerTypes)(_.providerTypes(_))
        .ifSome(states)(_.states(_))
        .ifSome(names)(_.names(_))
        .ifSome(owners)(_.owners(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRepositoryAssociationsResponse(
      repositoryAssociationSummaries: Option[List[RepositoryAssociationSummary]] = None,
      nextToken: Option[String] = None
    ): ListRepositoryAssociationsResponse =
      ListRepositoryAssociationsResponse
        .builder
        .ifSome(repositoryAssociationSummaries)(_.repositoryAssociationSummaries(_))
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

    def metrics(
      meteredLinesOfCodeCount: Option[MeteredLinesOfCodeCount] = None,
      findingsCount: Option[FindingsCount] = None
    ): Metrics =
      Metrics
        .builder
        .ifSome(meteredLinesOfCodeCount)(_.meteredLinesOfCodeCount(_))
        .ifSome(findingsCount)(_.findingsCount(_))
        .build

    def metricsSummary(
      meteredLinesOfCodeCount: Option[MeteredLinesOfCodeCount] = None,
      findingsCount: Option[FindingsCount] = None
    ): MetricsSummary =
      MetricsSummary
        .builder
        .ifSome(meteredLinesOfCodeCount)(_.meteredLinesOfCodeCount(_))
        .ifSome(findingsCount)(_.findingsCount(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putRecommendationFeedbackRequest(
      codeReviewArn: Option[String] = None,
      recommendationId: Option[String] = None,
      reactions: Option[List[Reaction]] = None
    ): PutRecommendationFeedbackRequest =
      PutRecommendationFeedbackRequest
        .builder
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(reactions)(_.reactions(_))
        .build

    def putRecommendationFeedbackResponse(

    ): PutRecommendationFeedbackResponse =
      PutRecommendationFeedbackResponse
        .builder

        .build

    def recommendationFeedback(
      codeReviewArn: Option[String] = None,
      recommendationId: Option[String] = None,
      reactions: Option[List[Reaction]] = None,
      userId: Option[String] = None,
      createdTimeStamp: Option[TimeStamp] = None,
      lastUpdatedTimeStamp: Option[TimeStamp] = None
    ): RecommendationFeedback =
      RecommendationFeedback
        .builder
        .ifSome(codeReviewArn)(_.codeReviewArn(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(reactions)(_.reactions(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(createdTimeStamp)(_.createdTimeStamp(_))
        .ifSome(lastUpdatedTimeStamp)(_.lastUpdatedTimeStamp(_))
        .build

    def recommendationFeedbackSummary(
      recommendationId: Option[String] = None,
      reactions: Option[List[Reaction]] = None,
      userId: Option[String] = None
    ): RecommendationFeedbackSummary =
      RecommendationFeedbackSummary
        .builder
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(reactions)(_.reactions(_))
        .ifSome(userId)(_.userId(_))
        .build

    def recommendationSummary(
      filePath: Option[String] = None,
      recommendationId: Option[String] = None,
      startLine: Option[Int] = None,
      endLine: Option[Int] = None,
      description: Option[String] = None
    ): RecommendationSummary =
      RecommendationSummary
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(startLine)(_.startLine(_))
        .ifSome(endLine)(_.endLine(_))
        .ifSome(description)(_.description(_))
        .build

    def repository(
      codeCommit: Option[CodeCommitRepository] = None,
      bitbucket: Option[ThirdPartySourceRepository] = None,
      gitHubEnterpriseServer: Option[ThirdPartySourceRepository] = None
    ): Repository =
      Repository
        .builder
        .ifSome(codeCommit)(_.codeCommit(_))
        .ifSome(bitbucket)(_.bitbucket(_))
        .ifSome(gitHubEnterpriseServer)(_.gitHubEnterpriseServer(_))
        .build

    def repositoryAnalysis(
      repositoryHead: Option[RepositoryHeadSourceCodeType] = None
    ): RepositoryAnalysis =
      RepositoryAnalysis
        .builder
        .ifSome(repositoryHead)(_.repositoryHead(_))
        .build

    def repositoryAssociation(
      associationId: Option[String] = None,
      associationArn: Option[String] = None,
      connectionArn: Option[String] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      providerType: Option[String] = None,
      state: Option[String] = None,
      stateReason: Option[String] = None,
      lastUpdatedTimeStamp: Option[TimeStamp] = None,
      createdTimeStamp: Option[TimeStamp] = None,
      kMSKeyDetails: Option[KMSKeyDetails] = None
    ): RepositoryAssociation =
      RepositoryAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associationArn)(_.associationArn(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(lastUpdatedTimeStamp)(_.lastUpdatedTimeStamp(_))
        .ifSome(createdTimeStamp)(_.createdTimeStamp(_))
        .ifSome(kMSKeyDetails)(_.kMSKeyDetails(_))
        .build

    def repositoryAssociationSummary(
      associationArn: Option[String] = None,
      connectionArn: Option[String] = None,
      lastUpdatedTimeStamp: Option[TimeStamp] = None,
      associationId: Option[String] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      providerType: Option[String] = None,
      state: Option[String] = None
    ): RepositoryAssociationSummary =
      RepositoryAssociationSummary
        .builder
        .ifSome(associationArn)(_.associationArn(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(lastUpdatedTimeStamp)(_.lastUpdatedTimeStamp(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(state)(_.state(_))
        .build

    def repositoryHeadSourceCodeType(
      branchName: Option[String] = None
    ): RepositoryHeadSourceCodeType =
      RepositoryHeadSourceCodeType
        .builder
        .ifSome(branchName)(_.branchName(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sourceCodeType(
      commitDiff: Option[CommitDiffSourceCodeType] = None,
      repositoryHead: Option[RepositoryHeadSourceCodeType] = None
    ): SourceCodeType =
      SourceCodeType
        .builder
        .ifSome(commitDiff)(_.commitDiff(_))
        .ifSome(repositoryHead)(_.repositoryHead(_))
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

    def thirdPartySourceRepository(
      name: Option[String] = None,
      connectionArn: Option[String] = None,
      owner: Option[String] = None
    ): ThirdPartySourceRepository =
      ThirdPartySourceRepository
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(connectionArn)(_.connectionArn(_))
        .ifSome(owner)(_.owner(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
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
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
