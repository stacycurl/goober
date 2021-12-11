package goober.hi

import goober.free.codecommit.CodeCommitIO
import software.amazon.awssdk.services.codecommit.model._


object codecommit {
  import goober.free.{codecommit ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def actorDoesNotExistException(

    ): ActorDoesNotExistException =
      ActorDoesNotExistException
        .builder

        .build

    def approval(
      userArn: Option[String] = None,
      approvalState: Option[String] = None
    ): Approval =
      Approval
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(approvalState)(_.approvalState(_))
        .build

    def approvalRule(
      approvalRuleId: Option[String] = None,
      approvalRuleName: Option[String] = None,
      approvalRuleContent: Option[String] = None,
      ruleContentSha256: Option[String] = None,
      lastModifiedDate: Option[LastModifiedDate] = None,
      creationDate: Option[CreationDate] = None,
      lastModifiedUser: Option[String] = None,
      originApprovalRuleTemplate: Option[OriginApprovalRuleTemplate] = None
    ): ApprovalRule =
      ApprovalRule
        .builder
        .ifSome(approvalRuleId)(_.approvalRuleId(_))
        .ifSome(approvalRuleName)(_.approvalRuleName(_))
        .ifSome(approvalRuleContent)(_.approvalRuleContent(_))
        .ifSome(ruleContentSha256)(_.ruleContentSha256(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedUser)(_.lastModifiedUser(_))
        .ifSome(originApprovalRuleTemplate)(_.originApprovalRuleTemplate(_))
        .build

    def approvalRuleContentRequiredException(

    ): ApprovalRuleContentRequiredException =
      ApprovalRuleContentRequiredException
        .builder

        .build

    def approvalRuleDoesNotExistException(

    ): ApprovalRuleDoesNotExistException =
      ApprovalRuleDoesNotExistException
        .builder

        .build

    def approvalRuleEventMetadata(
      approvalRuleName: Option[String] = None,
      approvalRuleId: Option[String] = None,
      approvalRuleContent: Option[String] = None
    ): ApprovalRuleEventMetadata =
      ApprovalRuleEventMetadata
        .builder
        .ifSome(approvalRuleName)(_.approvalRuleName(_))
        .ifSome(approvalRuleId)(_.approvalRuleId(_))
        .ifSome(approvalRuleContent)(_.approvalRuleContent(_))
        .build

    def approvalRuleNameAlreadyExistsException(

    ): ApprovalRuleNameAlreadyExistsException =
      ApprovalRuleNameAlreadyExistsException
        .builder

        .build

    def approvalRuleNameRequiredException(

    ): ApprovalRuleNameRequiredException =
      ApprovalRuleNameRequiredException
        .builder

        .build

    def approvalRuleOverriddenEventMetadata(
      revisionId: Option[String] = None,
      overrideStatus: Option[String] = None
    ): ApprovalRuleOverriddenEventMetadata =
      ApprovalRuleOverriddenEventMetadata
        .builder
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(overrideStatus)(_.overrideStatus(_))
        .build

    def approvalRuleTemplate(
      approvalRuleTemplateId: Option[String] = None,
      approvalRuleTemplateName: Option[String] = None,
      approvalRuleTemplateDescription: Option[String] = None,
      approvalRuleTemplateContent: Option[String] = None,
      ruleContentSha256: Option[String] = None,
      lastModifiedDate: Option[LastModifiedDate] = None,
      creationDate: Option[CreationDate] = None,
      lastModifiedUser: Option[String] = None
    ): ApprovalRuleTemplate =
      ApprovalRuleTemplate
        .builder
        .ifSome(approvalRuleTemplateId)(_.approvalRuleTemplateId(_))
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(approvalRuleTemplateDescription)(_.approvalRuleTemplateDescription(_))
        .ifSome(approvalRuleTemplateContent)(_.approvalRuleTemplateContent(_))
        .ifSome(ruleContentSha256)(_.ruleContentSha256(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedUser)(_.lastModifiedUser(_))
        .build

    def approvalRuleTemplateContentRequiredException(

    ): ApprovalRuleTemplateContentRequiredException =
      ApprovalRuleTemplateContentRequiredException
        .builder

        .build

    def approvalRuleTemplateDoesNotExistException(

    ): ApprovalRuleTemplateDoesNotExistException =
      ApprovalRuleTemplateDoesNotExistException
        .builder

        .build

    def approvalRuleTemplateInUseException(

    ): ApprovalRuleTemplateInUseException =
      ApprovalRuleTemplateInUseException
        .builder

        .build

    def approvalRuleTemplateNameAlreadyExistsException(

    ): ApprovalRuleTemplateNameAlreadyExistsException =
      ApprovalRuleTemplateNameAlreadyExistsException
        .builder

        .build

    def approvalRuleTemplateNameRequiredException(

    ): ApprovalRuleTemplateNameRequiredException =
      ApprovalRuleTemplateNameRequiredException
        .builder

        .build

    def approvalStateChangedEventMetadata(
      revisionId: Option[String] = None,
      approvalStatus: Option[String] = None
    ): ApprovalStateChangedEventMetadata =
      ApprovalStateChangedEventMetadata
        .builder
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(approvalStatus)(_.approvalStatus(_))
        .build

    def approvalStateRequiredException(

    ): ApprovalStateRequiredException =
      ApprovalStateRequiredException
        .builder

        .build

    def associateApprovalRuleTemplateWithRepositoryInput(
      approvalRuleTemplateName: Option[String] = None,
      repositoryName: Option[String] = None
    ): AssociateApprovalRuleTemplateWithRepositoryInput =
      AssociateApprovalRuleTemplateWithRepositoryInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def authorDoesNotExistException(

    ): AuthorDoesNotExistException =
      AuthorDoesNotExistException
        .builder

        .build

    def batchAssociateApprovalRuleTemplateWithRepositoriesError(
      repositoryName: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchAssociateApprovalRuleTemplateWithRepositoriesError =
      BatchAssociateApprovalRuleTemplateWithRepositoriesError
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchAssociateApprovalRuleTemplateWithRepositoriesInput(
      approvalRuleTemplateName: Option[String] = None,
      repositoryNames: Option[List[RepositoryName]] = None
    ): BatchAssociateApprovalRuleTemplateWithRepositoriesInput =
      BatchAssociateApprovalRuleTemplateWithRepositoriesInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(repositoryNames)(_.repositoryNames(_))
        .build

    def batchAssociateApprovalRuleTemplateWithRepositoriesOutput(
      associatedRepositoryNames: Option[List[RepositoryName]] = None,
      errors: Option[List[BatchAssociateApprovalRuleTemplateWithRepositoriesError]] = None
    ): BatchAssociateApprovalRuleTemplateWithRepositoriesOutput =
      BatchAssociateApprovalRuleTemplateWithRepositoriesOutput
        .builder
        .ifSome(associatedRepositoryNames)(_.associatedRepositoryNames(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchDescribeMergeConflictsError(
      filePath: Option[String] = None,
      exceptionName: Option[String] = None,
      message: Option[String] = None
    ): BatchDescribeMergeConflictsError =
      BatchDescribeMergeConflictsError
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(exceptionName)(_.exceptionName(_))
        .ifSome(message)(_.message(_))
        .build

    def batchDescribeMergeConflictsInput(
      repositoryName: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      mergeOption: Option[String] = None,
      maxMergeHunks: Option[Int] = None,
      maxConflictFiles: Option[Int] = None,
      filePaths: Option[List[Path]] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      nextToken: Option[String] = None
    ): BatchDescribeMergeConflictsInput =
      BatchDescribeMergeConflictsInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(mergeOption)(_.mergeOption(_))
        .ifSome(maxMergeHunks)(_.maxMergeHunks(_))
        .ifSome(maxConflictFiles)(_.maxConflictFiles(_))
        .ifSome(filePaths)(_.filePaths(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def batchDescribeMergeConflictsOutput(
      conflicts: Option[List[Conflict]] = None,
      nextToken: Option[String] = None,
      errors: Option[List[BatchDescribeMergeConflictsError]] = None,
      destinationCommitId: Option[String] = None,
      sourceCommitId: Option[String] = None,
      baseCommitId: Option[String] = None
    ): BatchDescribeMergeConflictsOutput =
      BatchDescribeMergeConflictsOutput
        .builder
        .ifSome(conflicts)(_.conflicts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(destinationCommitId)(_.destinationCommitId(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(baseCommitId)(_.baseCommitId(_))
        .build

    def batchDisassociateApprovalRuleTemplateFromRepositoriesError(
      repositoryName: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchDisassociateApprovalRuleTemplateFromRepositoriesError =
      BatchDisassociateApprovalRuleTemplateFromRepositoriesError
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchDisassociateApprovalRuleTemplateFromRepositoriesInput(
      approvalRuleTemplateName: Option[String] = None,
      repositoryNames: Option[List[RepositoryName]] = None
    ): BatchDisassociateApprovalRuleTemplateFromRepositoriesInput =
      BatchDisassociateApprovalRuleTemplateFromRepositoriesInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(repositoryNames)(_.repositoryNames(_))
        .build

    def batchDisassociateApprovalRuleTemplateFromRepositoriesOutput(
      disassociatedRepositoryNames: Option[List[RepositoryName]] = None,
      errors: Option[List[BatchDisassociateApprovalRuleTemplateFromRepositoriesError]] = None
    ): BatchDisassociateApprovalRuleTemplateFromRepositoriesOutput =
      BatchDisassociateApprovalRuleTemplateFromRepositoriesOutput
        .builder
        .ifSome(disassociatedRepositoryNames)(_.disassociatedRepositoryNames(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchGetCommitsError(
      commitId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchGetCommitsError =
      BatchGetCommitsError
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchGetCommitsInput(
      commitIds: Option[List[ObjectId]] = None,
      repositoryName: Option[String] = None
    ): BatchGetCommitsInput =
      BatchGetCommitsInput
        .builder
        .ifSome(commitIds)(_.commitIds(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def batchGetCommitsOutput(
      commits: Option[List[Commit]] = None,
      errors: Option[List[BatchGetCommitsError]] = None
    ): BatchGetCommitsOutput =
      BatchGetCommitsOutput
        .builder
        .ifSome(commits)(_.commits(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchGetRepositoriesInput(
      repositoryNames: Option[List[RepositoryName]] = None
    ): BatchGetRepositoriesInput =
      BatchGetRepositoriesInput
        .builder
        .ifSome(repositoryNames)(_.repositoryNames(_))
        .build

    def batchGetRepositoriesOutput(
      repositories: Option[List[RepositoryMetadata]] = None,
      repositoriesNotFound: Option[List[RepositoryName]] = None
    ): BatchGetRepositoriesOutput =
      BatchGetRepositoriesOutput
        .builder
        .ifSome(repositories)(_.repositories(_))
        .ifSome(repositoriesNotFound)(_.repositoriesNotFound(_))
        .build

    def beforeCommitIdAndAfterCommitIdAreSameException(

    ): BeforeCommitIdAndAfterCommitIdAreSameException =
      BeforeCommitIdAndAfterCommitIdAreSameException
        .builder

        .build

    def blobIdDoesNotExistException(

    ): BlobIdDoesNotExistException =
      BlobIdDoesNotExistException
        .builder

        .build

    def blobIdRequiredException(

    ): BlobIdRequiredException =
      BlobIdRequiredException
        .builder

        .build

    def blobMetadata(
      blobId: Option[String] = None,
      path: Option[String] = None,
      mode: Option[String] = None
    ): BlobMetadata =
      BlobMetadata
        .builder
        .ifSome(blobId)(_.blobId(_))
        .ifSome(path)(_.path(_))
        .ifSome(mode)(_.mode(_))
        .build

    def branchDoesNotExistException(

    ): BranchDoesNotExistException =
      BranchDoesNotExistException
        .builder

        .build

    def branchInfo(
      branchName: Option[String] = None,
      commitId: Option[String] = None
    ): BranchInfo =
      BranchInfo
        .builder
        .ifSome(branchName)(_.branchName(_))
        .ifSome(commitId)(_.commitId(_))
        .build

    def branchNameExistsException(

    ): BranchNameExistsException =
      BranchNameExistsException
        .builder

        .build

    def branchNameIsTagNameException(

    ): BranchNameIsTagNameException =
      BranchNameIsTagNameException
        .builder

        .build

    def branchNameRequiredException(

    ): BranchNameRequiredException =
      BranchNameRequiredException
        .builder

        .build

    def cannotDeleteApprovalRuleFromTemplateException(

    ): CannotDeleteApprovalRuleFromTemplateException =
      CannotDeleteApprovalRuleFromTemplateException
        .builder

        .build

    def cannotModifyApprovalRuleFromTemplateException(

    ): CannotModifyApprovalRuleFromTemplateException =
      CannotModifyApprovalRuleFromTemplateException
        .builder

        .build

    def clientRequestTokenRequiredException(

    ): ClientRequestTokenRequiredException =
      ClientRequestTokenRequiredException
        .builder

        .build

    def comment(
      commentId: Option[String] = None,
      content: Option[String] = None,
      inReplyTo: Option[String] = None,
      creationDate: Option[CreationDate] = None,
      lastModifiedDate: Option[LastModifiedDate] = None,
      authorArn: Option[String] = None,
      deleted: Option[Boolean] = None,
      clientRequestToken: Option[String] = None,
      callerReactions: Option[List[ReactionValue]] = None,
      reactionCounts: Option[ReactionCountsMap] = None
    ): Comment =
      Comment
        .builder
        .ifSome(commentId)(_.commentId(_))
        .ifSome(content)(_.content(_))
        .ifSome(inReplyTo)(_.inReplyTo(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(authorArn)(_.authorArn(_))
        .ifSome(deleted)(_.deleted(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(callerReactions)(_.callerReactions(_))
        .ifSome(reactionCounts)(_.reactionCounts(_))
        .build

    def commentContentRequiredException(

    ): CommentContentRequiredException =
      CommentContentRequiredException
        .builder

        .build

    def commentContentSizeLimitExceededException(

    ): CommentContentSizeLimitExceededException =
      CommentContentSizeLimitExceededException
        .builder

        .build

    def commentDeletedException(

    ): CommentDeletedException =
      CommentDeletedException
        .builder

        .build

    def commentDoesNotExistException(

    ): CommentDoesNotExistException =
      CommentDoesNotExistException
        .builder

        .build

    def commentIdRequiredException(

    ): CommentIdRequiredException =
      CommentIdRequiredException
        .builder

        .build

    def commentNotCreatedByCallerException(

    ): CommentNotCreatedByCallerException =
      CommentNotCreatedByCallerException
        .builder

        .build

    def commentsForComparedCommit(
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      beforeBlobId: Option[String] = None,
      afterBlobId: Option[String] = None,
      location: Option[Location] = None,
      comments: Option[List[Comment]] = None
    ): CommentsForComparedCommit =
      CommentsForComparedCommit
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(beforeBlobId)(_.beforeBlobId(_))
        .ifSome(afterBlobId)(_.afterBlobId(_))
        .ifSome(location)(_.location(_))
        .ifSome(comments)(_.comments(_))
        .build

    def commentsForPullRequest(
      pullRequestId: Option[String] = None,
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      beforeBlobId: Option[String] = None,
      afterBlobId: Option[String] = None,
      location: Option[Location] = None,
      comments: Option[List[Comment]] = None
    ): CommentsForPullRequest =
      CommentsForPullRequest
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(beforeBlobId)(_.beforeBlobId(_))
        .ifSome(afterBlobId)(_.afterBlobId(_))
        .ifSome(location)(_.location(_))
        .ifSome(comments)(_.comments(_))
        .build

    def commit(
      commitId: Option[String] = None,
      treeId: Option[String] = None,
      parents: Option[List[ObjectId]] = None,
      message: Option[String] = None,
      author: Option[UserInfo] = None,
      committer: Option[UserInfo] = None,
      additionalData: Option[String] = None
    ): Commit =
      Commit
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(treeId)(_.treeId(_))
        .ifSome(parents)(_.parents(_))
        .ifSome(message)(_.message(_))
        .ifSome(author)(_.author(_))
        .ifSome(committer)(_.committer(_))
        .ifSome(additionalData)(_.additionalData(_))
        .build

    def commitDoesNotExistException(

    ): CommitDoesNotExistException =
      CommitDoesNotExistException
        .builder

        .build

    def commitIdDoesNotExistException(

    ): CommitIdDoesNotExistException =
      CommitIdDoesNotExistException
        .builder

        .build

    def commitIdRequiredException(

    ): CommitIdRequiredException =
      CommitIdRequiredException
        .builder

        .build

    def commitIdsLimitExceededException(

    ): CommitIdsLimitExceededException =
      CommitIdsLimitExceededException
        .builder

        .build

    def commitIdsListRequiredException(

    ): CommitIdsListRequiredException =
      CommitIdsListRequiredException
        .builder

        .build

    def commitMessageLengthExceededException(

    ): CommitMessageLengthExceededException =
      CommitMessageLengthExceededException
        .builder

        .build

    def commitRequiredException(

    ): CommitRequiredException =
      CommitRequiredException
        .builder

        .build

    def concurrentReferenceUpdateException(

    ): ConcurrentReferenceUpdateException =
      ConcurrentReferenceUpdateException
        .builder

        .build

    def conflict(
      conflictMetadata: Option[ConflictMetadata] = None,
      mergeHunks: Option[List[MergeHunk]] = None
    ): Conflict =
      Conflict
        .builder
        .ifSome(conflictMetadata)(_.conflictMetadata(_))
        .ifSome(mergeHunks)(_.mergeHunks(_))
        .build

    def conflictMetadata(
      filePath: Option[String] = None,
      fileSizes: Option[FileSizes] = None,
      fileModes: Option[FileModes] = None,
      objectTypes: Option[ObjectTypes] = None,
      numberOfConflicts: Option[Int] = None,
      isBinaryFile: Option[IsBinaryFile] = None,
      contentConflict: Option[Boolean] = None,
      fileModeConflict: Option[Boolean] = None,
      objectTypeConflict: Option[Boolean] = None,
      mergeOperations: Option[MergeOperations] = None
    ): ConflictMetadata =
      ConflictMetadata
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(fileSizes)(_.fileSizes(_))
        .ifSome(fileModes)(_.fileModes(_))
        .ifSome(objectTypes)(_.objectTypes(_))
        .ifSome(numberOfConflicts)(_.numberOfConflicts(_))
        .ifSome(isBinaryFile)(_.isBinaryFile(_))
        .ifSome(contentConflict)(_.contentConflict(_))
        .ifSome(fileModeConflict)(_.fileModeConflict(_))
        .ifSome(objectTypeConflict)(_.objectTypeConflict(_))
        .ifSome(mergeOperations)(_.mergeOperations(_))
        .build

    def conflictResolution(
      replaceContents: Option[List[ReplaceContentEntry]] = None,
      deleteFiles: Option[List[DeleteFileEntry]] = None,
      setFileModes: Option[List[SetFileModeEntry]] = None
    ): ConflictResolution =
      ConflictResolution
        .builder
        .ifSome(replaceContents)(_.replaceContents(_))
        .ifSome(deleteFiles)(_.deleteFiles(_))
        .ifSome(setFileModes)(_.setFileModes(_))
        .build

    def createApprovalRuleTemplateInput(
      approvalRuleTemplateName: Option[String] = None,
      approvalRuleTemplateContent: Option[String] = None,
      approvalRuleTemplateDescription: Option[String] = None
    ): CreateApprovalRuleTemplateInput =
      CreateApprovalRuleTemplateInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(approvalRuleTemplateContent)(_.approvalRuleTemplateContent(_))
        .ifSome(approvalRuleTemplateDescription)(_.approvalRuleTemplateDescription(_))
        .build

    def createApprovalRuleTemplateOutput(
      approvalRuleTemplate: Option[ApprovalRuleTemplate] = None
    ): CreateApprovalRuleTemplateOutput =
      CreateApprovalRuleTemplateOutput
        .builder
        .ifSome(approvalRuleTemplate)(_.approvalRuleTemplate(_))
        .build

    def createBranchInput(
      repositoryName: Option[String] = None,
      branchName: Option[String] = None,
      commitId: Option[String] = None
    ): CreateBranchInput =
      CreateBranchInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(commitId)(_.commitId(_))
        .build

    def createCommitInput(
      repositoryName: Option[String] = None,
      branchName: Option[String] = None,
      parentCommitId: Option[String] = None,
      authorName: Option[String] = None,
      email: Option[String] = None,
      commitMessage: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      putFiles: Option[List[PutFileEntry]] = None,
      deleteFiles: Option[List[DeleteFileEntry]] = None,
      setFileModes: Option[List[SetFileModeEntry]] = None
    ): CreateCommitInput =
      CreateCommitInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(parentCommitId)(_.parentCommitId(_))
        .ifSome(authorName)(_.authorName(_))
        .ifSome(email)(_.email(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(putFiles)(_.putFiles(_))
        .ifSome(deleteFiles)(_.deleteFiles(_))
        .ifSome(setFileModes)(_.setFileModes(_))
        .build

    def createCommitOutput(
      commitId: Option[String] = None,
      treeId: Option[String] = None,
      filesAdded: Option[List[FileMetadata]] = None,
      filesUpdated: Option[List[FileMetadata]] = None,
      filesDeleted: Option[List[FileMetadata]] = None
    ): CreateCommitOutput =
      CreateCommitOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(treeId)(_.treeId(_))
        .ifSome(filesAdded)(_.filesAdded(_))
        .ifSome(filesUpdated)(_.filesUpdated(_))
        .ifSome(filesDeleted)(_.filesDeleted(_))
        .build

    def createPullRequestApprovalRuleInput(
      pullRequestId: Option[String] = None,
      approvalRuleName: Option[String] = None,
      approvalRuleContent: Option[String] = None
    ): CreatePullRequestApprovalRuleInput =
      CreatePullRequestApprovalRuleInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(approvalRuleName)(_.approvalRuleName(_))
        .ifSome(approvalRuleContent)(_.approvalRuleContent(_))
        .build

    def createPullRequestApprovalRuleOutput(
      approvalRule: Option[ApprovalRule] = None
    ): CreatePullRequestApprovalRuleOutput =
      CreatePullRequestApprovalRuleOutput
        .builder
        .ifSome(approvalRule)(_.approvalRule(_))
        .build

    def createPullRequestInput(
      title: Option[String] = None,
      description: Option[String] = None,
      targets: Option[List[Target]] = None,
      clientRequestToken: Option[String] = None
    ): CreatePullRequestInput =
      CreatePullRequestInput
        .builder
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createPullRequestOutput(
      pullRequest: Option[PullRequest] = None
    ): CreatePullRequestOutput =
      CreatePullRequestOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def createRepositoryInput(
      repositoryName: Option[String] = None,
      repositoryDescription: Option[String] = None,
      tags: Option[TagsMap] = None
    ): CreateRepositoryInput =
      CreateRepositoryInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(repositoryDescription)(_.repositoryDescription(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRepositoryOutput(
      repositoryMetadata: Option[RepositoryMetadata] = None
    ): CreateRepositoryOutput =
      CreateRepositoryOutput
        .builder
        .ifSome(repositoryMetadata)(_.repositoryMetadata(_))
        .build

    def createUnreferencedMergeCommitInput(
      repositoryName: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      mergeOption: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      authorName: Option[String] = None,
      email: Option[String] = None,
      commitMessage: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      conflictResolution: Option[ConflictResolution] = None
    ): CreateUnreferencedMergeCommitInput =
      CreateUnreferencedMergeCommitInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(mergeOption)(_.mergeOption(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(authorName)(_.authorName(_))
        .ifSome(email)(_.email(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(conflictResolution)(_.conflictResolution(_))
        .build

    def createUnreferencedMergeCommitOutput(
      commitId: Option[String] = None,
      treeId: Option[String] = None
    ): CreateUnreferencedMergeCommitOutput =
      CreateUnreferencedMergeCommitOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(treeId)(_.treeId(_))
        .build

    def defaultBranchCannotBeDeletedException(

    ): DefaultBranchCannotBeDeletedException =
      DefaultBranchCannotBeDeletedException
        .builder

        .build

    def deleteApprovalRuleTemplateInput(
      approvalRuleTemplateName: Option[String] = None
    ): DeleteApprovalRuleTemplateInput =
      DeleteApprovalRuleTemplateInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .build

    def deleteApprovalRuleTemplateOutput(
      approvalRuleTemplateId: Option[String] = None
    ): DeleteApprovalRuleTemplateOutput =
      DeleteApprovalRuleTemplateOutput
        .builder
        .ifSome(approvalRuleTemplateId)(_.approvalRuleTemplateId(_))
        .build

    def deleteBranchInput(
      repositoryName: Option[String] = None,
      branchName: Option[String] = None
    ): DeleteBranchInput =
      DeleteBranchInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(branchName)(_.branchName(_))
        .build

    def deleteBranchOutput(
      deletedBranch: Option[BranchInfo] = None
    ): DeleteBranchOutput =
      DeleteBranchOutput
        .builder
        .ifSome(deletedBranch)(_.deletedBranch(_))
        .build

    def deleteCommentContentInput(
      commentId: Option[String] = None
    ): DeleteCommentContentInput =
      DeleteCommentContentInput
        .builder
        .ifSome(commentId)(_.commentId(_))
        .build

    def deleteCommentContentOutput(
      comment: Option[Comment] = None
    ): DeleteCommentContentOutput =
      DeleteCommentContentOutput
        .builder
        .ifSome(comment)(_.comment(_))
        .build

    def deleteFileEntry(
      filePath: Option[String] = None
    ): DeleteFileEntry =
      DeleteFileEntry
        .builder
        .ifSome(filePath)(_.filePath(_))
        .build

    def deleteFileInput(
      repositoryName: Option[String] = None,
      branchName: Option[String] = None,
      filePath: Option[String] = None,
      parentCommitId: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      commitMessage: Option[String] = None,
      name: Option[String] = None,
      email: Option[String] = None
    ): DeleteFileInput =
      DeleteFileInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(filePath)(_.filePath(_))
        .ifSome(parentCommitId)(_.parentCommitId(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(name)(_.name(_))
        .ifSome(email)(_.email(_))
        .build

    def deleteFileOutput(
      commitId: Option[String] = None,
      blobId: Option[String] = None,
      treeId: Option[String] = None,
      filePath: Option[String] = None
    ): DeleteFileOutput =
      DeleteFileOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(blobId)(_.blobId(_))
        .ifSome(treeId)(_.treeId(_))
        .ifSome(filePath)(_.filePath(_))
        .build

    def deletePullRequestApprovalRuleInput(
      pullRequestId: Option[String] = None,
      approvalRuleName: Option[String] = None
    ): DeletePullRequestApprovalRuleInput =
      DeletePullRequestApprovalRuleInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(approvalRuleName)(_.approvalRuleName(_))
        .build

    def deletePullRequestApprovalRuleOutput(
      approvalRuleId: Option[String] = None
    ): DeletePullRequestApprovalRuleOutput =
      DeletePullRequestApprovalRuleOutput
        .builder
        .ifSome(approvalRuleId)(_.approvalRuleId(_))
        .build

    def deleteRepositoryInput(
      repositoryName: Option[String] = None
    ): DeleteRepositoryInput =
      DeleteRepositoryInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def deleteRepositoryOutput(
      repositoryId: Option[String] = None
    ): DeleteRepositoryOutput =
      DeleteRepositoryOutput
        .builder
        .ifSome(repositoryId)(_.repositoryId(_))
        .build

    def describeMergeConflictsInput(
      repositoryName: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      mergeOption: Option[String] = None,
      maxMergeHunks: Option[Int] = None,
      filePath: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeMergeConflictsInput =
      DescribeMergeConflictsInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(mergeOption)(_.mergeOption(_))
        .ifSome(maxMergeHunks)(_.maxMergeHunks(_))
        .ifSome(filePath)(_.filePath(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMergeConflictsOutput(
      conflictMetadata: Option[ConflictMetadata] = None,
      mergeHunks: Option[List[MergeHunk]] = None,
      nextToken: Option[String] = None,
      destinationCommitId: Option[String] = None,
      sourceCommitId: Option[String] = None,
      baseCommitId: Option[String] = None
    ): DescribeMergeConflictsOutput =
      DescribeMergeConflictsOutput
        .builder
        .ifSome(conflictMetadata)(_.conflictMetadata(_))
        .ifSome(mergeHunks)(_.mergeHunks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(destinationCommitId)(_.destinationCommitId(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(baseCommitId)(_.baseCommitId(_))
        .build

    def describePullRequestEventsInput(
      pullRequestId: Option[String] = None,
      pullRequestEventType: Option[String] = None,
      actorArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribePullRequestEventsInput =
      DescribePullRequestEventsInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(pullRequestEventType)(_.pullRequestEventType(_))
        .ifSome(actorArn)(_.actorArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describePullRequestEventsOutput(
      pullRequestEvents: Option[List[PullRequestEvent]] = None,
      nextToken: Option[String] = None
    ): DescribePullRequestEventsOutput =
      DescribePullRequestEventsOutput
        .builder
        .ifSome(pullRequestEvents)(_.pullRequestEvents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def difference(
      beforeBlob: Option[BlobMetadata] = None,
      afterBlob: Option[BlobMetadata] = None,
      changeType: Option[String] = None
    ): Difference =
      Difference
        .builder
        .ifSome(beforeBlob)(_.beforeBlob(_))
        .ifSome(afterBlob)(_.afterBlob(_))
        .ifSome(changeType)(_.changeType(_))
        .build

    def directoryNameConflictsWithFileNameException(

    ): DirectoryNameConflictsWithFileNameException =
      DirectoryNameConflictsWithFileNameException
        .builder

        .build

    def disassociateApprovalRuleTemplateFromRepositoryInput(
      approvalRuleTemplateName: Option[String] = None,
      repositoryName: Option[String] = None
    ): DisassociateApprovalRuleTemplateFromRepositoryInput =
      DisassociateApprovalRuleTemplateFromRepositoryInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def encryptionIntegrityChecksFailedException(

    ): EncryptionIntegrityChecksFailedException =
      EncryptionIntegrityChecksFailedException
        .builder

        .build

    def encryptionKeyAccessDeniedException(

    ): EncryptionKeyAccessDeniedException =
      EncryptionKeyAccessDeniedException
        .builder

        .build

    def encryptionKeyDisabledException(

    ): EncryptionKeyDisabledException =
      EncryptionKeyDisabledException
        .builder

        .build

    def encryptionKeyNotFoundException(

    ): EncryptionKeyNotFoundException =
      EncryptionKeyNotFoundException
        .builder

        .build

    def encryptionKeyUnavailableException(

    ): EncryptionKeyUnavailableException =
      EncryptionKeyUnavailableException
        .builder

        .build

    def evaluatePullRequestApprovalRulesInput(
      pullRequestId: Option[String] = None,
      revisionId: Option[String] = None
    ): EvaluatePullRequestApprovalRulesInput =
      EvaluatePullRequestApprovalRulesInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def evaluatePullRequestApprovalRulesOutput(
      evaluation: Option[Evaluation] = None
    ): EvaluatePullRequestApprovalRulesOutput =
      EvaluatePullRequestApprovalRulesOutput
        .builder
        .ifSome(evaluation)(_.evaluation(_))
        .build

    def evaluation(
      approved: Option[Boolean] = None,
      overridden: Option[Boolean] = None,
      approvalRulesSatisfied: Option[List[ApprovalRuleName]] = None,
      approvalRulesNotSatisfied: Option[List[ApprovalRuleName]] = None
    ): Evaluation =
      Evaluation
        .builder
        .ifSome(approved)(_.approved(_))
        .ifSome(overridden)(_.overridden(_))
        .ifSome(approvalRulesSatisfied)(_.approvalRulesSatisfied(_))
        .ifSome(approvalRulesNotSatisfied)(_.approvalRulesNotSatisfied(_))
        .build

    def file(
      blobId: Option[String] = None,
      absolutePath: Option[String] = None,
      relativePath: Option[String] = None,
      fileMode: Option[String] = None
    ): File =
      File
        .builder
        .ifSome(blobId)(_.blobId(_))
        .ifSome(absolutePath)(_.absolutePath(_))
        .ifSome(relativePath)(_.relativePath(_))
        .ifSome(fileMode)(_.fileMode(_))
        .build

    def fileContentAndSourceFileSpecifiedException(

    ): FileContentAndSourceFileSpecifiedException =
      FileContentAndSourceFileSpecifiedException
        .builder

        .build

    def fileContentRequiredException(

    ): FileContentRequiredException =
      FileContentRequiredException
        .builder

        .build

    def fileContentSizeLimitExceededException(

    ): FileContentSizeLimitExceededException =
      FileContentSizeLimitExceededException
        .builder

        .build

    def fileDoesNotExistException(

    ): FileDoesNotExistException =
      FileDoesNotExistException
        .builder

        .build

    def fileEntryRequiredException(

    ): FileEntryRequiredException =
      FileEntryRequiredException
        .builder

        .build

    def fileMetadata(
      absolutePath: Option[String] = None,
      blobId: Option[String] = None,
      fileMode: Option[String] = None
    ): FileMetadata =
      FileMetadata
        .builder
        .ifSome(absolutePath)(_.absolutePath(_))
        .ifSome(blobId)(_.blobId(_))
        .ifSome(fileMode)(_.fileMode(_))
        .build

    def fileModeRequiredException(

    ): FileModeRequiredException =
      FileModeRequiredException
        .builder

        .build

    def fileModes(
      source: Option[String] = None,
      destination: Option[String] = None,
      base: Option[String] = None
    ): FileModes =
      FileModes
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(base)(_.base(_))
        .build

    def fileNameConflictsWithDirectoryNameException(

    ): FileNameConflictsWithDirectoryNameException =
      FileNameConflictsWithDirectoryNameException
        .builder

        .build

    def filePathConflictsWithSubmodulePathException(

    ): FilePathConflictsWithSubmodulePathException =
      FilePathConflictsWithSubmodulePathException
        .builder

        .build

    def fileSizes(
      source: Option[FileSize] = None,
      destination: Option[FileSize] = None,
      base: Option[FileSize] = None
    ): FileSizes =
      FileSizes
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(base)(_.base(_))
        .build

    def fileTooLargeException(

    ): FileTooLargeException =
      FileTooLargeException
        .builder

        .build

    def folder(
      treeId: Option[String] = None,
      absolutePath: Option[String] = None,
      relativePath: Option[String] = None
    ): Folder =
      Folder
        .builder
        .ifSome(treeId)(_.treeId(_))
        .ifSome(absolutePath)(_.absolutePath(_))
        .ifSome(relativePath)(_.relativePath(_))
        .build

    def folderContentSizeLimitExceededException(

    ): FolderContentSizeLimitExceededException =
      FolderContentSizeLimitExceededException
        .builder

        .build

    def folderDoesNotExistException(

    ): FolderDoesNotExistException =
      FolderDoesNotExistException
        .builder

        .build

    def getApprovalRuleTemplateInput(
      approvalRuleTemplateName: Option[String] = None
    ): GetApprovalRuleTemplateInput =
      GetApprovalRuleTemplateInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .build

    def getApprovalRuleTemplateOutput(
      approvalRuleTemplate: Option[ApprovalRuleTemplate] = None
    ): GetApprovalRuleTemplateOutput =
      GetApprovalRuleTemplateOutput
        .builder
        .ifSome(approvalRuleTemplate)(_.approvalRuleTemplate(_))
        .build

    def getBlobInput(
      repositoryName: Option[String] = None,
      blobId: Option[String] = None
    ): GetBlobInput =
      GetBlobInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(blobId)(_.blobId(_))
        .build

    def getBlobOutput(
      content: Option[blob] = None
    ): GetBlobOutput =
      GetBlobOutput
        .builder
        .ifSome(content)(_.content(_))
        .build

    def getBranchInput(
      repositoryName: Option[String] = None,
      branchName: Option[String] = None
    ): GetBranchInput =
      GetBranchInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(branchName)(_.branchName(_))
        .build

    def getBranchOutput(
      branch: Option[BranchInfo] = None
    ): GetBranchOutput =
      GetBranchOutput
        .builder
        .ifSome(branch)(_.branch(_))
        .build

    def getCommentInput(
      commentId: Option[String] = None
    ): GetCommentInput =
      GetCommentInput
        .builder
        .ifSome(commentId)(_.commentId(_))
        .build

    def getCommentOutput(
      comment: Option[Comment] = None
    ): GetCommentOutput =
      GetCommentOutput
        .builder
        .ifSome(comment)(_.comment(_))
        .build

    def getCommentReactionsInput(
      commentId: Option[String] = None,
      reactionUserArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetCommentReactionsInput =
      GetCommentReactionsInput
        .builder
        .ifSome(commentId)(_.commentId(_))
        .ifSome(reactionUserArn)(_.reactionUserArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCommentReactionsOutput(
      reactionsForComment: Option[List[ReactionForComment]] = None,
      nextToken: Option[String] = None
    ): GetCommentReactionsOutput =
      GetCommentReactionsOutput
        .builder
        .ifSome(reactionsForComment)(_.reactionsForComment(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCommentsForComparedCommitInput(
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetCommentsForComparedCommitInput =
      GetCommentsForComparedCommitInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCommentsForComparedCommitOutput(
      commentsForComparedCommitData: Option[List[CommentsForComparedCommit]] = None,
      nextToken: Option[String] = None
    ): GetCommentsForComparedCommitOutput =
      GetCommentsForComparedCommitOutput
        .builder
        .ifSome(commentsForComparedCommitData)(_.commentsForComparedCommitData(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCommentsForPullRequestInput(
      pullRequestId: Option[String] = None,
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetCommentsForPullRequestInput =
      GetCommentsForPullRequestInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCommentsForPullRequestOutput(
      commentsForPullRequestData: Option[List[CommentsForPullRequest]] = None,
      nextToken: Option[String] = None
    ): GetCommentsForPullRequestOutput =
      GetCommentsForPullRequestOutput
        .builder
        .ifSome(commentsForPullRequestData)(_.commentsForPullRequestData(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCommitInput(
      repositoryName: Option[String] = None,
      commitId: Option[String] = None
    ): GetCommitInput =
      GetCommitInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(commitId)(_.commitId(_))
        .build

    def getCommitOutput(
      commit: Option[Commit] = None
    ): GetCommitOutput =
      GetCommitOutput
        .builder
        .ifSome(commit)(_.commit(_))
        .build

    def getDifferencesInput(
      repositoryName: Option[String] = None,
      beforeCommitSpecifier: Option[String] = None,
      afterCommitSpecifier: Option[String] = None,
      beforePath: Option[String] = None,
      afterPath: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetDifferencesInput =
      GetDifferencesInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitSpecifier)(_.beforeCommitSpecifier(_))
        .ifSome(afterCommitSpecifier)(_.afterCommitSpecifier(_))
        .ifSome(beforePath)(_.beforePath(_))
        .ifSome(afterPath)(_.afterPath(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDifferencesOutput(
      differences: Option[List[Difference]] = None,
      nextToken: Option[String] = None
    ): GetDifferencesOutput =
      GetDifferencesOutput
        .builder
        .ifSome(differences)(_.differences(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getFileInput(
      repositoryName: Option[String] = None,
      commitSpecifier: Option[String] = None,
      filePath: Option[String] = None
    ): GetFileInput =
      GetFileInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(commitSpecifier)(_.commitSpecifier(_))
        .ifSome(filePath)(_.filePath(_))
        .build

    def getFileOutput(
      commitId: Option[String] = None,
      blobId: Option[String] = None,
      filePath: Option[String] = None,
      fileMode: Option[String] = None,
      fileSize: Option[ObjectSize] = None,
      fileContent: Option[FileContent] = None
    ): GetFileOutput =
      GetFileOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(blobId)(_.blobId(_))
        .ifSome(filePath)(_.filePath(_))
        .ifSome(fileMode)(_.fileMode(_))
        .ifSome(fileSize)(_.fileSize(_))
        .ifSome(fileContent)(_.fileContent(_))
        .build

    def getFolderInput(
      repositoryName: Option[String] = None,
      commitSpecifier: Option[String] = None,
      folderPath: Option[String] = None
    ): GetFolderInput =
      GetFolderInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(commitSpecifier)(_.commitSpecifier(_))
        .ifSome(folderPath)(_.folderPath(_))
        .build

    def getFolderOutput(
      commitId: Option[String] = None,
      folderPath: Option[String] = None,
      treeId: Option[String] = None,
      subFolders: Option[List[Folder]] = None,
      files: Option[List[File]] = None,
      symbolicLinks: Option[List[SymbolicLink]] = None,
      subModules: Option[List[SubModule]] = None
    ): GetFolderOutput =
      GetFolderOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(folderPath)(_.folderPath(_))
        .ifSome(treeId)(_.treeId(_))
        .ifSome(subFolders)(_.subFolders(_))
        .ifSome(files)(_.files(_))
        .ifSome(symbolicLinks)(_.symbolicLinks(_))
        .ifSome(subModules)(_.subModules(_))
        .build

    def getMergeCommitInput(
      repositoryName: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None
    ): GetMergeCommitInput =
      GetMergeCommitInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .build

    def getMergeCommitOutput(
      sourceCommitId: Option[String] = None,
      destinationCommitId: Option[String] = None,
      baseCommitId: Option[String] = None,
      mergedCommitId: Option[String] = None
    ): GetMergeCommitOutput =
      GetMergeCommitOutput
        .builder
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(destinationCommitId)(_.destinationCommitId(_))
        .ifSome(baseCommitId)(_.baseCommitId(_))
        .ifSome(mergedCommitId)(_.mergedCommitId(_))
        .build

    def getMergeConflictsInput(
      repositoryName: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      mergeOption: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      maxConflictFiles: Option[Int] = None,
      conflictResolutionStrategy: Option[String] = None,
      nextToken: Option[String] = None
    ): GetMergeConflictsInput =
      GetMergeConflictsInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(mergeOption)(_.mergeOption(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(maxConflictFiles)(_.maxConflictFiles(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getMergeConflictsOutput(
      mergeable: Option[Boolean] = None,
      destinationCommitId: Option[String] = None,
      sourceCommitId: Option[String] = None,
      baseCommitId: Option[String] = None,
      conflictMetadataList: Option[List[ConflictMetadata]] = None,
      nextToken: Option[String] = None
    ): GetMergeConflictsOutput =
      GetMergeConflictsOutput
        .builder
        .ifSome(mergeable)(_.mergeable(_))
        .ifSome(destinationCommitId)(_.destinationCommitId(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(baseCommitId)(_.baseCommitId(_))
        .ifSome(conflictMetadataList)(_.conflictMetadataList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getMergeOptionsInput(
      repositoryName: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None
    ): GetMergeOptionsInput =
      GetMergeOptionsInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .build

    def getMergeOptionsOutput(
      mergeOptions: Option[List[MergeOptionTypeEnum]] = None,
      sourceCommitId: Option[String] = None,
      destinationCommitId: Option[String] = None,
      baseCommitId: Option[String] = None
    ): GetMergeOptionsOutput =
      GetMergeOptionsOutput
        .builder
        .ifSome(mergeOptions)(_.mergeOptions(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(destinationCommitId)(_.destinationCommitId(_))
        .ifSome(baseCommitId)(_.baseCommitId(_))
        .build

    def getPullRequestApprovalStatesInput(
      pullRequestId: Option[String] = None,
      revisionId: Option[String] = None
    ): GetPullRequestApprovalStatesInput =
      GetPullRequestApprovalStatesInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getPullRequestApprovalStatesOutput(
      approvals: Option[List[Approval]] = None
    ): GetPullRequestApprovalStatesOutput =
      GetPullRequestApprovalStatesOutput
        .builder
        .ifSome(approvals)(_.approvals(_))
        .build

    def getPullRequestInput(
      pullRequestId: Option[String] = None
    ): GetPullRequestInput =
      GetPullRequestInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .build

    def getPullRequestOutput(
      pullRequest: Option[PullRequest] = None
    ): GetPullRequestOutput =
      GetPullRequestOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def getPullRequestOverrideStateInput(
      pullRequestId: Option[String] = None,
      revisionId: Option[String] = None
    ): GetPullRequestOverrideStateInput =
      GetPullRequestOverrideStateInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def getPullRequestOverrideStateOutput(
      overridden: Option[Boolean] = None,
      overrider: Option[String] = None
    ): GetPullRequestOverrideStateOutput =
      GetPullRequestOverrideStateOutput
        .builder
        .ifSome(overridden)(_.overridden(_))
        .ifSome(overrider)(_.overrider(_))
        .build

    def getRepositoryInput(
      repositoryName: Option[String] = None
    ): GetRepositoryInput =
      GetRepositoryInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def getRepositoryOutput(
      repositoryMetadata: Option[RepositoryMetadata] = None
    ): GetRepositoryOutput =
      GetRepositoryOutput
        .builder
        .ifSome(repositoryMetadata)(_.repositoryMetadata(_))
        .build

    def getRepositoryTriggersInput(
      repositoryName: Option[String] = None
    ): GetRepositoryTriggersInput =
      GetRepositoryTriggersInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .build

    def getRepositoryTriggersOutput(
      configurationId: Option[String] = None,
      triggers: Option[List[RepositoryTrigger]] = None
    ): GetRepositoryTriggersOutput =
      GetRepositoryTriggersOutput
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(triggers)(_.triggers(_))
        .build

    def idempotencyParameterMismatchException(

    ): IdempotencyParameterMismatchException =
      IdempotencyParameterMismatchException
        .builder

        .build

    def invalidActorArnException(

    ): InvalidActorArnException =
      InvalidActorArnException
        .builder

        .build

    def invalidApprovalRuleContentException(

    ): InvalidApprovalRuleContentException =
      InvalidApprovalRuleContentException
        .builder

        .build

    def invalidApprovalRuleNameException(

    ): InvalidApprovalRuleNameException =
      InvalidApprovalRuleNameException
        .builder

        .build

    def invalidApprovalRuleTemplateContentException(

    ): InvalidApprovalRuleTemplateContentException =
      InvalidApprovalRuleTemplateContentException
        .builder

        .build

    def invalidApprovalRuleTemplateDescriptionException(

    ): InvalidApprovalRuleTemplateDescriptionException =
      InvalidApprovalRuleTemplateDescriptionException
        .builder

        .build

    def invalidApprovalRuleTemplateNameException(

    ): InvalidApprovalRuleTemplateNameException =
      InvalidApprovalRuleTemplateNameException
        .builder

        .build

    def invalidApprovalStateException(

    ): InvalidApprovalStateException =
      InvalidApprovalStateException
        .builder

        .build

    def invalidAuthorArnException(

    ): InvalidAuthorArnException =
      InvalidAuthorArnException
        .builder

        .build

    def invalidBlobIdException(

    ): InvalidBlobIdException =
      InvalidBlobIdException
        .builder

        .build

    def invalidBranchNameException(

    ): InvalidBranchNameException =
      InvalidBranchNameException
        .builder

        .build

    def invalidClientRequestTokenException(

    ): InvalidClientRequestTokenException =
      InvalidClientRequestTokenException
        .builder

        .build

    def invalidCommentIdException(

    ): InvalidCommentIdException =
      InvalidCommentIdException
        .builder

        .build

    def invalidCommitException(

    ): InvalidCommitException =
      InvalidCommitException
        .builder

        .build

    def invalidCommitIdException(

    ): InvalidCommitIdException =
      InvalidCommitIdException
        .builder

        .build

    def invalidConflictDetailLevelException(

    ): InvalidConflictDetailLevelException =
      InvalidConflictDetailLevelException
        .builder

        .build

    def invalidConflictResolutionException(

    ): InvalidConflictResolutionException =
      InvalidConflictResolutionException
        .builder

        .build

    def invalidConflictResolutionStrategyException(

    ): InvalidConflictResolutionStrategyException =
      InvalidConflictResolutionStrategyException
        .builder

        .build

    def invalidContinuationTokenException(

    ): InvalidContinuationTokenException =
      InvalidContinuationTokenException
        .builder

        .build

    def invalidDeletionParameterException(

    ): InvalidDeletionParameterException =
      InvalidDeletionParameterException
        .builder

        .build

    def invalidDescriptionException(

    ): InvalidDescriptionException =
      InvalidDescriptionException
        .builder

        .build

    def invalidDestinationCommitSpecifierException(

    ): InvalidDestinationCommitSpecifierException =
      InvalidDestinationCommitSpecifierException
        .builder

        .build

    def invalidEmailException(

    ): InvalidEmailException =
      InvalidEmailException
        .builder

        .build

    def invalidFileLocationException(

    ): InvalidFileLocationException =
      InvalidFileLocationException
        .builder

        .build

    def invalidFileModeException(

    ): InvalidFileModeException =
      InvalidFileModeException
        .builder

        .build

    def invalidFilePositionException(

    ): InvalidFilePositionException =
      InvalidFilePositionException
        .builder

        .build

    def invalidMaxConflictFilesException(

    ): InvalidMaxConflictFilesException =
      InvalidMaxConflictFilesException
        .builder

        .build

    def invalidMaxMergeHunksException(

    ): InvalidMaxMergeHunksException =
      InvalidMaxMergeHunksException
        .builder

        .build

    def invalidMaxResultsException(

    ): InvalidMaxResultsException =
      InvalidMaxResultsException
        .builder

        .build

    def invalidMergeOptionException(

    ): InvalidMergeOptionException =
      InvalidMergeOptionException
        .builder

        .build

    def invalidOrderException(

    ): InvalidOrderException =
      InvalidOrderException
        .builder

        .build

    def invalidOverrideStatusException(

    ): InvalidOverrideStatusException =
      InvalidOverrideStatusException
        .builder

        .build

    def invalidParentCommitIdException(

    ): InvalidParentCommitIdException =
      InvalidParentCommitIdException
        .builder

        .build

    def invalidPathException(

    ): InvalidPathException =
      InvalidPathException
        .builder

        .build

    def invalidPullRequestEventTypeException(

    ): InvalidPullRequestEventTypeException =
      InvalidPullRequestEventTypeException
        .builder

        .build

    def invalidPullRequestIdException(

    ): InvalidPullRequestIdException =
      InvalidPullRequestIdException
        .builder

        .build

    def invalidPullRequestStatusException(

    ): InvalidPullRequestStatusException =
      InvalidPullRequestStatusException
        .builder

        .build

    def invalidPullRequestStatusUpdateException(

    ): InvalidPullRequestStatusUpdateException =
      InvalidPullRequestStatusUpdateException
        .builder

        .build

    def invalidReactionUserArnException(

    ): InvalidReactionUserArnException =
      InvalidReactionUserArnException
        .builder

        .build

    def invalidReactionValueException(

    ): InvalidReactionValueException =
      InvalidReactionValueException
        .builder

        .build

    def invalidReferenceNameException(

    ): InvalidReferenceNameException =
      InvalidReferenceNameException
        .builder

        .build

    def invalidRelativeFileVersionEnumException(

    ): InvalidRelativeFileVersionEnumException =
      InvalidRelativeFileVersionEnumException
        .builder

        .build

    def invalidReplacementContentException(

    ): InvalidReplacementContentException =
      InvalidReplacementContentException
        .builder

        .build

    def invalidReplacementTypeException(

    ): InvalidReplacementTypeException =
      InvalidReplacementTypeException
        .builder

        .build

    def invalidRepositoryDescriptionException(

    ): InvalidRepositoryDescriptionException =
      InvalidRepositoryDescriptionException
        .builder

        .build

    def invalidRepositoryNameException(

    ): InvalidRepositoryNameException =
      InvalidRepositoryNameException
        .builder

        .build

    def invalidRepositoryTriggerBranchNameException(

    ): InvalidRepositoryTriggerBranchNameException =
      InvalidRepositoryTriggerBranchNameException
        .builder

        .build

    def invalidRepositoryTriggerCustomDataException(

    ): InvalidRepositoryTriggerCustomDataException =
      InvalidRepositoryTriggerCustomDataException
        .builder

        .build

    def invalidRepositoryTriggerDestinationArnException(

    ): InvalidRepositoryTriggerDestinationArnException =
      InvalidRepositoryTriggerDestinationArnException
        .builder

        .build

    def invalidRepositoryTriggerEventsException(

    ): InvalidRepositoryTriggerEventsException =
      InvalidRepositoryTriggerEventsException
        .builder

        .build

    def invalidRepositoryTriggerNameException(

    ): InvalidRepositoryTriggerNameException =
      InvalidRepositoryTriggerNameException
        .builder

        .build

    def invalidRepositoryTriggerRegionException(

    ): InvalidRepositoryTriggerRegionException =
      InvalidRepositoryTriggerRegionException
        .builder

        .build

    def invalidResourceArnException(

    ): InvalidResourceArnException =
      InvalidResourceArnException
        .builder

        .build

    def invalidRevisionIdException(

    ): InvalidRevisionIdException =
      InvalidRevisionIdException
        .builder

        .build

    def invalidRuleContentSha256Exception(

    ): InvalidRuleContentSha256Exception =
      InvalidRuleContentSha256Exception
        .builder

        .build

    def invalidSortByException(

    ): InvalidSortByException =
      InvalidSortByException
        .builder

        .build

    def invalidSourceCommitSpecifierException(

    ): InvalidSourceCommitSpecifierException =
      InvalidSourceCommitSpecifierException
        .builder

        .build

    def invalidSystemTagUsageException(

    ): InvalidSystemTagUsageException =
      InvalidSystemTagUsageException
        .builder

        .build

    def invalidTagKeysListException(

    ): InvalidTagKeysListException =
      InvalidTagKeysListException
        .builder

        .build

    def invalidTagsMapException(

    ): InvalidTagsMapException =
      InvalidTagsMapException
        .builder

        .build

    def invalidTargetBranchException(

    ): InvalidTargetBranchException =
      InvalidTargetBranchException
        .builder

        .build

    def invalidTargetException(

    ): InvalidTargetException =
      InvalidTargetException
        .builder

        .build

    def invalidTargetsException(

    ): InvalidTargetsException =
      InvalidTargetsException
        .builder

        .build

    def invalidTitleException(

    ): InvalidTitleException =
      InvalidTitleException
        .builder

        .build

    def isBinaryFile(
      source: Option[Boolean] = None,
      destination: Option[Boolean] = None,
      base: Option[Boolean] = None
    ): IsBinaryFile =
      IsBinaryFile
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(base)(_.base(_))
        .build

    def listApprovalRuleTemplatesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListApprovalRuleTemplatesInput =
      ListApprovalRuleTemplatesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listApprovalRuleTemplatesOutput(
      approvalRuleTemplateNames: Option[List[ApprovalRuleTemplateName]] = None,
      nextToken: Option[String] = None
    ): ListApprovalRuleTemplatesOutput =
      ListApprovalRuleTemplatesOutput
        .builder
        .ifSome(approvalRuleTemplateNames)(_.approvalRuleTemplateNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociatedApprovalRuleTemplatesForRepositoryInput(
      repositoryName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssociatedApprovalRuleTemplatesForRepositoryInput =
      ListAssociatedApprovalRuleTemplatesForRepositoryInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssociatedApprovalRuleTemplatesForRepositoryOutput(
      approvalRuleTemplateNames: Option[List[ApprovalRuleTemplateName]] = None,
      nextToken: Option[String] = None
    ): ListAssociatedApprovalRuleTemplatesForRepositoryOutput =
      ListAssociatedApprovalRuleTemplatesForRepositoryOutput
        .builder
        .ifSome(approvalRuleTemplateNames)(_.approvalRuleTemplateNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBranchesInput(
      repositoryName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBranchesInput =
      ListBranchesInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBranchesOutput(
      branches: Option[List[BranchName]] = None,
      nextToken: Option[String] = None
    ): ListBranchesOutput =
      ListBranchesOutput
        .builder
        .ifSome(branches)(_.branches(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPullRequestsInput(
      repositoryName: Option[String] = None,
      authorArn: Option[String] = None,
      pullRequestStatus: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPullRequestsInput =
      ListPullRequestsInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(authorArn)(_.authorArn(_))
        .ifSome(pullRequestStatus)(_.pullRequestStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPullRequestsOutput(
      pullRequestIds: Option[List[PullRequestId]] = None,
      nextToken: Option[String] = None
    ): ListPullRequestsOutput =
      ListPullRequestsOutput
        .builder
        .ifSome(pullRequestIds)(_.pullRequestIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRepositoriesForApprovalRuleTemplateInput(
      approvalRuleTemplateName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRepositoriesForApprovalRuleTemplateInput =
      ListRepositoriesForApprovalRuleTemplateInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRepositoriesForApprovalRuleTemplateOutput(
      repositoryNames: Option[List[RepositoryName]] = None,
      nextToken: Option[String] = None
    ): ListRepositoriesForApprovalRuleTemplateOutput =
      ListRepositoriesForApprovalRuleTemplateOutput
        .builder
        .ifSome(repositoryNames)(_.repositoryNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRepositoriesInput(
      nextToken: Option[String] = None,
      sortBy: Option[String] = None,
      order: Option[String] = None
    ): ListRepositoriesInput =
      ListRepositoriesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(order)(_.order(_))
        .build

    def listRepositoriesOutput(
      repositories: Option[List[RepositoryNameIdPair]] = None,
      nextToken: Option[String] = None
    ): ListRepositoriesOutput =
      ListRepositoriesOutput
        .builder
        .ifSome(repositories)(_.repositories(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[TagsMap] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def location(
      filePath: Option[String] = None,
      filePosition: Option[Position] = None,
      relativeFileVersion: Option[String] = None
    ): Location =
      Location
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(filePosition)(_.filePosition(_))
        .ifSome(relativeFileVersion)(_.relativeFileVersion(_))
        .build

    def manualMergeRequiredException(

    ): ManualMergeRequiredException =
      ManualMergeRequiredException
        .builder

        .build

    def maximumBranchesExceededException(

    ): MaximumBranchesExceededException =
      MaximumBranchesExceededException
        .builder

        .build

    def maximumConflictResolutionEntriesExceededException(

    ): MaximumConflictResolutionEntriesExceededException =
      MaximumConflictResolutionEntriesExceededException
        .builder

        .build

    def maximumFileContentToLoadExceededException(

    ): MaximumFileContentToLoadExceededException =
      MaximumFileContentToLoadExceededException
        .builder

        .build

    def maximumFileEntriesExceededException(

    ): MaximumFileEntriesExceededException =
      MaximumFileEntriesExceededException
        .builder

        .build

    def maximumItemsToCompareExceededException(

    ): MaximumItemsToCompareExceededException =
      MaximumItemsToCompareExceededException
        .builder

        .build

    def maximumNumberOfApprovalsExceededException(

    ): MaximumNumberOfApprovalsExceededException =
      MaximumNumberOfApprovalsExceededException
        .builder

        .build

    def maximumOpenPullRequestsExceededException(

    ): MaximumOpenPullRequestsExceededException =
      MaximumOpenPullRequestsExceededException
        .builder

        .build

    def maximumRepositoryNamesExceededException(

    ): MaximumRepositoryNamesExceededException =
      MaximumRepositoryNamesExceededException
        .builder

        .build

    def maximumRepositoryTriggersExceededException(

    ): MaximumRepositoryTriggersExceededException =
      MaximumRepositoryTriggersExceededException
        .builder

        .build

    def maximumRuleTemplatesAssociatedWithRepositoryException(

    ): MaximumRuleTemplatesAssociatedWithRepositoryException =
      MaximumRuleTemplatesAssociatedWithRepositoryException
        .builder

        .build

    def mergeBranchesByFastForwardInput(
      repositoryName: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      targetBranch: Option[String] = None
    ): MergeBranchesByFastForwardInput =
      MergeBranchesByFastForwardInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(targetBranch)(_.targetBranch(_))
        .build

    def mergeBranchesByFastForwardOutput(
      commitId: Option[String] = None,
      treeId: Option[String] = None
    ): MergeBranchesByFastForwardOutput =
      MergeBranchesByFastForwardOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(treeId)(_.treeId(_))
        .build

    def mergeBranchesBySquashInput(
      repositoryName: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      targetBranch: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      authorName: Option[String] = None,
      email: Option[String] = None,
      commitMessage: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      conflictResolution: Option[ConflictResolution] = None
    ): MergeBranchesBySquashInput =
      MergeBranchesBySquashInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(targetBranch)(_.targetBranch(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(authorName)(_.authorName(_))
        .ifSome(email)(_.email(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(conflictResolution)(_.conflictResolution(_))
        .build

    def mergeBranchesBySquashOutput(
      commitId: Option[String] = None,
      treeId: Option[String] = None
    ): MergeBranchesBySquashOutput =
      MergeBranchesBySquashOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(treeId)(_.treeId(_))
        .build

    def mergeBranchesByThreeWayInput(
      repositoryName: Option[String] = None,
      sourceCommitSpecifier: Option[String] = None,
      destinationCommitSpecifier: Option[String] = None,
      targetBranch: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      authorName: Option[String] = None,
      email: Option[String] = None,
      commitMessage: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      conflictResolution: Option[ConflictResolution] = None
    ): MergeBranchesByThreeWayInput =
      MergeBranchesByThreeWayInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitSpecifier)(_.sourceCommitSpecifier(_))
        .ifSome(destinationCommitSpecifier)(_.destinationCommitSpecifier(_))
        .ifSome(targetBranch)(_.targetBranch(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(authorName)(_.authorName(_))
        .ifSome(email)(_.email(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(conflictResolution)(_.conflictResolution(_))
        .build

    def mergeBranchesByThreeWayOutput(
      commitId: Option[String] = None,
      treeId: Option[String] = None
    ): MergeBranchesByThreeWayOutput =
      MergeBranchesByThreeWayOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(treeId)(_.treeId(_))
        .build

    def mergeHunk(
      isConflict: Option[Boolean] = None,
      source: Option[MergeHunkDetail] = None,
      destination: Option[MergeHunkDetail] = None,
      base: Option[MergeHunkDetail] = None
    ): MergeHunk =
      MergeHunk
        .builder
        .ifSome(isConflict)(_.isConflict(_))
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(base)(_.base(_))
        .build

    def mergeHunkDetail(
      startLine: Option[Int] = None,
      endLine: Option[Int] = None,
      hunkContent: Option[String] = None
    ): MergeHunkDetail =
      MergeHunkDetail
        .builder
        .ifSome(startLine)(_.startLine(_))
        .ifSome(endLine)(_.endLine(_))
        .ifSome(hunkContent)(_.hunkContent(_))
        .build

    def mergeMetadata(
      isMerged: Option[Boolean] = None,
      mergedBy: Option[String] = None,
      mergeCommitId: Option[String] = None,
      mergeOption: Option[String] = None
    ): MergeMetadata =
      MergeMetadata
        .builder
        .ifSome(isMerged)(_.isMerged(_))
        .ifSome(mergedBy)(_.mergedBy(_))
        .ifSome(mergeCommitId)(_.mergeCommitId(_))
        .ifSome(mergeOption)(_.mergeOption(_))
        .build

    def mergeOperations(
      source: Option[String] = None,
      destination: Option[String] = None
    ): MergeOperations =
      MergeOperations
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .build

    def mergeOptionRequiredException(

    ): MergeOptionRequiredException =
      MergeOptionRequiredException
        .builder

        .build

    def mergePullRequestByFastForwardInput(
      pullRequestId: Option[String] = None,
      repositoryName: Option[String] = None,
      sourceCommitId: Option[String] = None
    ): MergePullRequestByFastForwardInput =
      MergePullRequestByFastForwardInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .build

    def mergePullRequestByFastForwardOutput(
      pullRequest: Option[PullRequest] = None
    ): MergePullRequestByFastForwardOutput =
      MergePullRequestByFastForwardOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def mergePullRequestBySquashInput(
      pullRequestId: Option[String] = None,
      repositoryName: Option[String] = None,
      sourceCommitId: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      commitMessage: Option[String] = None,
      authorName: Option[String] = None,
      email: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      conflictResolution: Option[ConflictResolution] = None
    ): MergePullRequestBySquashInput =
      MergePullRequestBySquashInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(authorName)(_.authorName(_))
        .ifSome(email)(_.email(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(conflictResolution)(_.conflictResolution(_))
        .build

    def mergePullRequestBySquashOutput(
      pullRequest: Option[PullRequest] = None
    ): MergePullRequestBySquashOutput =
      MergePullRequestBySquashOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def mergePullRequestByThreeWayInput(
      pullRequestId: Option[String] = None,
      repositoryName: Option[String] = None,
      sourceCommitId: Option[String] = None,
      conflictDetailLevel: Option[String] = None,
      conflictResolutionStrategy: Option[String] = None,
      commitMessage: Option[String] = None,
      authorName: Option[String] = None,
      email: Option[String] = None,
      keepEmptyFolders: Option[Boolean] = None,
      conflictResolution: Option[ConflictResolution] = None
    ): MergePullRequestByThreeWayInput =
      MergePullRequestByThreeWayInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(conflictDetailLevel)(_.conflictDetailLevel(_))
        .ifSome(conflictResolutionStrategy)(_.conflictResolutionStrategy(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(authorName)(_.authorName(_))
        .ifSome(email)(_.email(_))
        .ifSome(keepEmptyFolders)(_.keepEmptyFolders(_))
        .ifSome(conflictResolution)(_.conflictResolution(_))
        .build

    def mergePullRequestByThreeWayOutput(
      pullRequest: Option[PullRequest] = None
    ): MergePullRequestByThreeWayOutput =
      MergePullRequestByThreeWayOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def multipleConflictResolutionEntriesException(

    ): MultipleConflictResolutionEntriesException =
      MultipleConflictResolutionEntriesException
        .builder

        .build

    def multipleRepositoriesInPullRequestException(

    ): MultipleRepositoriesInPullRequestException =
      MultipleRepositoriesInPullRequestException
        .builder

        .build

    def nameLengthExceededException(

    ): NameLengthExceededException =
      NameLengthExceededException
        .builder

        .build

    def noChangeException(

    ): NoChangeException =
      NoChangeException
        .builder

        .build

    def numberOfRuleTemplatesExceededException(

    ): NumberOfRuleTemplatesExceededException =
      NumberOfRuleTemplatesExceededException
        .builder

        .build

    def numberOfRulesExceededException(

    ): NumberOfRulesExceededException =
      NumberOfRulesExceededException
        .builder

        .build

    def objectTypes(
      source: Option[String] = None,
      destination: Option[String] = None,
      base: Option[String] = None
    ): ObjectTypes =
      ObjectTypes
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(base)(_.base(_))
        .build

    def originApprovalRuleTemplate(
      approvalRuleTemplateId: Option[String] = None,
      approvalRuleTemplateName: Option[String] = None
    ): OriginApprovalRuleTemplate =
      OriginApprovalRuleTemplate
        .builder
        .ifSome(approvalRuleTemplateId)(_.approvalRuleTemplateId(_))
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .build

    def overrideAlreadySetException(

    ): OverrideAlreadySetException =
      OverrideAlreadySetException
        .builder

        .build

    def overridePullRequestApprovalRulesInput(
      pullRequestId: Option[String] = None,
      revisionId: Option[String] = None,
      overrideStatus: Option[String] = None
    ): OverridePullRequestApprovalRulesInput =
      OverridePullRequestApprovalRulesInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(overrideStatus)(_.overrideStatus(_))
        .build

    def overrideStatusRequiredException(

    ): OverrideStatusRequiredException =
      OverrideStatusRequiredException
        .builder

        .build

    def parentCommitDoesNotExistException(

    ): ParentCommitDoesNotExistException =
      ParentCommitDoesNotExistException
        .builder

        .build

    def parentCommitIdOutdatedException(

    ): ParentCommitIdOutdatedException =
      ParentCommitIdOutdatedException
        .builder

        .build

    def parentCommitIdRequiredException(

    ): ParentCommitIdRequiredException =
      ParentCommitIdRequiredException
        .builder

        .build

    def pathDoesNotExistException(

    ): PathDoesNotExistException =
      PathDoesNotExistException
        .builder

        .build

    def pathRequiredException(

    ): PathRequiredException =
      PathRequiredException
        .builder

        .build

    def postCommentForComparedCommitInput(
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      location: Option[Location] = None,
      content: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): PostCommentForComparedCommitInput =
      PostCommentForComparedCommitInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(location)(_.location(_))
        .ifSome(content)(_.content(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def postCommentForComparedCommitOutput(
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      beforeBlobId: Option[String] = None,
      afterBlobId: Option[String] = None,
      location: Option[Location] = None,
      comment: Option[Comment] = None
    ): PostCommentForComparedCommitOutput =
      PostCommentForComparedCommitOutput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(beforeBlobId)(_.beforeBlobId(_))
        .ifSome(afterBlobId)(_.afterBlobId(_))
        .ifSome(location)(_.location(_))
        .ifSome(comment)(_.comment(_))
        .build

    def postCommentForPullRequestInput(
      pullRequestId: Option[String] = None,
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      location: Option[Location] = None,
      content: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): PostCommentForPullRequestInput =
      PostCommentForPullRequestInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(location)(_.location(_))
        .ifSome(content)(_.content(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def postCommentForPullRequestOutput(
      repositoryName: Option[String] = None,
      pullRequestId: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      beforeBlobId: Option[String] = None,
      afterBlobId: Option[String] = None,
      location: Option[Location] = None,
      comment: Option[Comment] = None
    ): PostCommentForPullRequestOutput =
      PostCommentForPullRequestOutput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(beforeBlobId)(_.beforeBlobId(_))
        .ifSome(afterBlobId)(_.afterBlobId(_))
        .ifSome(location)(_.location(_))
        .ifSome(comment)(_.comment(_))
        .build

    def postCommentReplyInput(
      inReplyTo: Option[String] = None,
      clientRequestToken: Option[String] = None,
      content: Option[String] = None
    ): PostCommentReplyInput =
      PostCommentReplyInput
        .builder
        .ifSome(inReplyTo)(_.inReplyTo(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(content)(_.content(_))
        .build

    def postCommentReplyOutput(
      comment: Option[Comment] = None
    ): PostCommentReplyOutput =
      PostCommentReplyOutput
        .builder
        .ifSome(comment)(_.comment(_))
        .build

    def pullRequest(
      pullRequestId: Option[String] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      lastActivityDate: Option[LastModifiedDate] = None,
      creationDate: Option[CreationDate] = None,
      pullRequestStatus: Option[String] = None,
      authorArn: Option[String] = None,
      pullRequestTargets: Option[List[PullRequestTarget]] = None,
      clientRequestToken: Option[String] = None,
      revisionId: Option[String] = None,
      approvalRules: Option[List[ApprovalRule]] = None
    ): PullRequest =
      PullRequest
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastActivityDate)(_.lastActivityDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(pullRequestStatus)(_.pullRequestStatus(_))
        .ifSome(authorArn)(_.authorArn(_))
        .ifSome(pullRequestTargets)(_.pullRequestTargets(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(approvalRules)(_.approvalRules(_))
        .build

    def pullRequestAlreadyClosedException(

    ): PullRequestAlreadyClosedException =
      PullRequestAlreadyClosedException
        .builder

        .build

    def pullRequestApprovalRulesNotSatisfiedException(

    ): PullRequestApprovalRulesNotSatisfiedException =
      PullRequestApprovalRulesNotSatisfiedException
        .builder

        .build

    def pullRequestCannotBeApprovedByAuthorException(

    ): PullRequestCannotBeApprovedByAuthorException =
      PullRequestCannotBeApprovedByAuthorException
        .builder

        .build

    def pullRequestCreatedEventMetadata(
      repositoryName: Option[String] = None,
      sourceCommitId: Option[String] = None,
      destinationCommitId: Option[String] = None,
      mergeBase: Option[String] = None
    ): PullRequestCreatedEventMetadata =
      PullRequestCreatedEventMetadata
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceCommitId)(_.sourceCommitId(_))
        .ifSome(destinationCommitId)(_.destinationCommitId(_))
        .ifSome(mergeBase)(_.mergeBase(_))
        .build

    def pullRequestDoesNotExistException(

    ): PullRequestDoesNotExistException =
      PullRequestDoesNotExistException
        .builder

        .build

    def pullRequestEvent(
      pullRequestId: Option[String] = None,
      eventDate: Option[EventDate] = None,
      pullRequestEventType: Option[String] = None,
      actorArn: Option[String] = None,
      pullRequestCreatedEventMetadata: Option[PullRequestCreatedEventMetadata] = None,
      pullRequestStatusChangedEventMetadata: Option[PullRequestStatusChangedEventMetadata] = None,
      pullRequestSourceReferenceUpdatedEventMetadata: Option[PullRequestSourceReferenceUpdatedEventMetadata] = None,
      pullRequestMergedStateChangedEventMetadata: Option[PullRequestMergedStateChangedEventMetadata] = None,
      approvalRuleEventMetadata: Option[ApprovalRuleEventMetadata] = None,
      approvalStateChangedEventMetadata: Option[ApprovalStateChangedEventMetadata] = None,
      approvalRuleOverriddenEventMetadata: Option[ApprovalRuleOverriddenEventMetadata] = None
    ): PullRequestEvent =
      PullRequestEvent
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(eventDate)(_.eventDate(_))
        .ifSome(pullRequestEventType)(_.pullRequestEventType(_))
        .ifSome(actorArn)(_.actorArn(_))
        .ifSome(pullRequestCreatedEventMetadata)(_.pullRequestCreatedEventMetadata(_))
        .ifSome(pullRequestStatusChangedEventMetadata)(_.pullRequestStatusChangedEventMetadata(_))
        .ifSome(pullRequestSourceReferenceUpdatedEventMetadata)(_.pullRequestSourceReferenceUpdatedEventMetadata(_))
        .ifSome(pullRequestMergedStateChangedEventMetadata)(_.pullRequestMergedStateChangedEventMetadata(_))
        .ifSome(approvalRuleEventMetadata)(_.approvalRuleEventMetadata(_))
        .ifSome(approvalStateChangedEventMetadata)(_.approvalStateChangedEventMetadata(_))
        .ifSome(approvalRuleOverriddenEventMetadata)(_.approvalRuleOverriddenEventMetadata(_))
        .build

    def pullRequestIdRequiredException(

    ): PullRequestIdRequiredException =
      PullRequestIdRequiredException
        .builder

        .build

    def pullRequestMergedStateChangedEventMetadata(
      repositoryName: Option[String] = None,
      destinationReference: Option[String] = None,
      mergeMetadata: Option[MergeMetadata] = None
    ): PullRequestMergedStateChangedEventMetadata =
      PullRequestMergedStateChangedEventMetadata
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(destinationReference)(_.destinationReference(_))
        .ifSome(mergeMetadata)(_.mergeMetadata(_))
        .build

    def pullRequestSourceReferenceUpdatedEventMetadata(
      repositoryName: Option[String] = None,
      beforeCommitId: Option[String] = None,
      afterCommitId: Option[String] = None,
      mergeBase: Option[String] = None
    ): PullRequestSourceReferenceUpdatedEventMetadata =
      PullRequestSourceReferenceUpdatedEventMetadata
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(beforeCommitId)(_.beforeCommitId(_))
        .ifSome(afterCommitId)(_.afterCommitId(_))
        .ifSome(mergeBase)(_.mergeBase(_))
        .build

    def pullRequestStatusChangedEventMetadata(
      pullRequestStatus: Option[String] = None
    ): PullRequestStatusChangedEventMetadata =
      PullRequestStatusChangedEventMetadata
        .builder
        .ifSome(pullRequestStatus)(_.pullRequestStatus(_))
        .build

    def pullRequestStatusRequiredException(

    ): PullRequestStatusRequiredException =
      PullRequestStatusRequiredException
        .builder

        .build

    def pullRequestTarget(
      repositoryName: Option[String] = None,
      sourceReference: Option[String] = None,
      destinationReference: Option[String] = None,
      destinationCommit: Option[String] = None,
      sourceCommit: Option[String] = None,
      mergeBase: Option[String] = None,
      mergeMetadata: Option[MergeMetadata] = None
    ): PullRequestTarget =
      PullRequestTarget
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceReference)(_.sourceReference(_))
        .ifSome(destinationReference)(_.destinationReference(_))
        .ifSome(destinationCommit)(_.destinationCommit(_))
        .ifSome(sourceCommit)(_.sourceCommit(_))
        .ifSome(mergeBase)(_.mergeBase(_))
        .ifSome(mergeMetadata)(_.mergeMetadata(_))
        .build

    def putCommentReactionInput(
      commentId: Option[String] = None,
      reactionValue: Option[String] = None
    ): PutCommentReactionInput =
      PutCommentReactionInput
        .builder
        .ifSome(commentId)(_.commentId(_))
        .ifSome(reactionValue)(_.reactionValue(_))
        .build

    def putFileEntry(
      filePath: Option[String] = None,
      fileMode: Option[String] = None,
      fileContent: Option[FileContent] = None,
      sourceFile: Option[SourceFileSpecifier] = None
    ): PutFileEntry =
      PutFileEntry
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(fileMode)(_.fileMode(_))
        .ifSome(fileContent)(_.fileContent(_))
        .ifSome(sourceFile)(_.sourceFile(_))
        .build

    def putFileEntryConflictException(

    ): PutFileEntryConflictException =
      PutFileEntryConflictException
        .builder

        .build

    def putFileInput(
      repositoryName: Option[String] = None,
      branchName: Option[String] = None,
      fileContent: Option[FileContent] = None,
      filePath: Option[String] = None,
      fileMode: Option[String] = None,
      parentCommitId: Option[String] = None,
      commitMessage: Option[String] = None,
      name: Option[String] = None,
      email: Option[String] = None
    ): PutFileInput =
      PutFileInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(fileContent)(_.fileContent(_))
        .ifSome(filePath)(_.filePath(_))
        .ifSome(fileMode)(_.fileMode(_))
        .ifSome(parentCommitId)(_.parentCommitId(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(name)(_.name(_))
        .ifSome(email)(_.email(_))
        .build

    def putFileOutput(
      commitId: Option[String] = None,
      blobId: Option[String] = None,
      treeId: Option[String] = None
    ): PutFileOutput =
      PutFileOutput
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(blobId)(_.blobId(_))
        .ifSome(treeId)(_.treeId(_))
        .build

    def putRepositoryTriggersInput(
      repositoryName: Option[String] = None,
      triggers: Option[List[RepositoryTrigger]] = None
    ): PutRepositoryTriggersInput =
      PutRepositoryTriggersInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(triggers)(_.triggers(_))
        .build

    def putRepositoryTriggersOutput(
      configurationId: Option[String] = None
    ): PutRepositoryTriggersOutput =
      PutRepositoryTriggersOutput
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .build

    def reactionForComment(
      reaction: Option[ReactionValueFormats] = None,
      reactionUsers: Option[List[Arn]] = None,
      reactionsFromDeletedUsersCount: Option[Int] = None
    ): ReactionForComment =
      ReactionForComment
        .builder
        .ifSome(reaction)(_.reaction(_))
        .ifSome(reactionUsers)(_.reactionUsers(_))
        .ifSome(reactionsFromDeletedUsersCount)(_.reactionsFromDeletedUsersCount(_))
        .build

    def reactionLimitExceededException(

    ): ReactionLimitExceededException =
      ReactionLimitExceededException
        .builder

        .build

    def reactionValueFormats(
      emoji: Option[String] = None,
      shortCode: Option[String] = None,
      unicode: Option[String] = None
    ): ReactionValueFormats =
      ReactionValueFormats
        .builder
        .ifSome(emoji)(_.emoji(_))
        .ifSome(shortCode)(_.shortCode(_))
        .ifSome(unicode)(_.unicode(_))
        .build

    def reactionValueRequiredException(

    ): ReactionValueRequiredException =
      ReactionValueRequiredException
        .builder

        .build

    def referenceDoesNotExistException(

    ): ReferenceDoesNotExistException =
      ReferenceDoesNotExistException
        .builder

        .build

    def referenceNameRequiredException(

    ): ReferenceNameRequiredException =
      ReferenceNameRequiredException
        .builder

        .build

    def referenceTypeNotSupportedException(

    ): ReferenceTypeNotSupportedException =
      ReferenceTypeNotSupportedException
        .builder

        .build

    def replaceContentEntry(
      filePath: Option[String] = None,
      replacementType: Option[String] = None,
      content: Option[FileContent] = None,
      fileMode: Option[String] = None
    ): ReplaceContentEntry =
      ReplaceContentEntry
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(replacementType)(_.replacementType(_))
        .ifSome(content)(_.content(_))
        .ifSome(fileMode)(_.fileMode(_))
        .build

    def replacementContentRequiredException(

    ): ReplacementContentRequiredException =
      ReplacementContentRequiredException
        .builder

        .build

    def replacementTypeRequiredException(

    ): ReplacementTypeRequiredException =
      ReplacementTypeRequiredException
        .builder

        .build

    def repositoryDoesNotExistException(

    ): RepositoryDoesNotExistException =
      RepositoryDoesNotExistException
        .builder

        .build

    def repositoryLimitExceededException(

    ): RepositoryLimitExceededException =
      RepositoryLimitExceededException
        .builder

        .build

    def repositoryMetadata(
      accountId: Option[String] = None,
      repositoryId: Option[String] = None,
      repositoryName: Option[String] = None,
      repositoryDescription: Option[String] = None,
      defaultBranch: Option[String] = None,
      lastModifiedDate: Option[LastModifiedDate] = None,
      creationDate: Option[CreationDate] = None,
      cloneUrlHttp: Option[String] = None,
      cloneUrlSsh: Option[String] = None,
      arn: Option[String] = None
    ): RepositoryMetadata =
      RepositoryMetadata
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(repositoryId)(_.repositoryId(_))
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(repositoryDescription)(_.repositoryDescription(_))
        .ifSome(defaultBranch)(_.defaultBranch(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(cloneUrlHttp)(_.cloneUrlHttp(_))
        .ifSome(cloneUrlSsh)(_.cloneUrlSsh(_))
        .ifSome(arn)(_.arn(_))
        .build

    def repositoryNameExistsException(

    ): RepositoryNameExistsException =
      RepositoryNameExistsException
        .builder

        .build

    def repositoryNameIdPair(
      repositoryName: Option[String] = None,
      repositoryId: Option[String] = None
    ): RepositoryNameIdPair =
      RepositoryNameIdPair
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(repositoryId)(_.repositoryId(_))
        .build

    def repositoryNameRequiredException(

    ): RepositoryNameRequiredException =
      RepositoryNameRequiredException
        .builder

        .build

    def repositoryNamesRequiredException(

    ): RepositoryNamesRequiredException =
      RepositoryNamesRequiredException
        .builder

        .build

    def repositoryNotAssociatedWithPullRequestException(

    ): RepositoryNotAssociatedWithPullRequestException =
      RepositoryNotAssociatedWithPullRequestException
        .builder

        .build

    def repositoryTrigger(
      name: Option[String] = None,
      destinationArn: Option[String] = None,
      customData: Option[String] = None,
      branches: Option[List[BranchName]] = None,
      events: Option[List[RepositoryTriggerEventEnum]] = None
    ): RepositoryTrigger =
      RepositoryTrigger
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(customData)(_.customData(_))
        .ifSome(branches)(_.branches(_))
        .ifSome(events)(_.events(_))
        .build

    def repositoryTriggerBranchNameListRequiredException(

    ): RepositoryTriggerBranchNameListRequiredException =
      RepositoryTriggerBranchNameListRequiredException
        .builder

        .build

    def repositoryTriggerDestinationArnRequiredException(

    ): RepositoryTriggerDestinationArnRequiredException =
      RepositoryTriggerDestinationArnRequiredException
        .builder

        .build

    def repositoryTriggerEventsListRequiredException(

    ): RepositoryTriggerEventsListRequiredException =
      RepositoryTriggerEventsListRequiredException
        .builder

        .build

    def repositoryTriggerExecutionFailure(
      trigger: Option[String] = None,
      failureMessage: Option[String] = None
    ): RepositoryTriggerExecutionFailure =
      RepositoryTriggerExecutionFailure
        .builder
        .ifSome(trigger)(_.trigger(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .build

    def repositoryTriggerNameRequiredException(

    ): RepositoryTriggerNameRequiredException =
      RepositoryTriggerNameRequiredException
        .builder

        .build

    def repositoryTriggersListRequiredException(

    ): RepositoryTriggersListRequiredException =
      RepositoryTriggersListRequiredException
        .builder

        .build

    def resourceArnRequiredException(

    ): ResourceArnRequiredException =
      ResourceArnRequiredException
        .builder

        .build

    def restrictedSourceFileException(

    ): RestrictedSourceFileException =
      RestrictedSourceFileException
        .builder

        .build

    def revisionIdRequiredException(

    ): RevisionIdRequiredException =
      RevisionIdRequiredException
        .builder

        .build

    def revisionNotCurrentException(

    ): RevisionNotCurrentException =
      RevisionNotCurrentException
        .builder

        .build

    def sameFileContentException(

    ): SameFileContentException =
      SameFileContentException
        .builder

        .build

    def samePathRequestException(

    ): SamePathRequestException =
      SamePathRequestException
        .builder

        .build

    def setFileModeEntry(
      filePath: Option[String] = None,
      fileMode: Option[String] = None
    ): SetFileModeEntry =
      SetFileModeEntry
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(fileMode)(_.fileMode(_))
        .build

    def sourceAndDestinationAreSameException(

    ): SourceAndDestinationAreSameException =
      SourceAndDestinationAreSameException
        .builder

        .build

    def sourceFileOrContentRequiredException(

    ): SourceFileOrContentRequiredException =
      SourceFileOrContentRequiredException
        .builder

        .build

    def sourceFileSpecifier(
      filePath: Option[String] = None,
      isMove: Option[Boolean] = None
    ): SourceFileSpecifier =
      SourceFileSpecifier
        .builder
        .ifSome(filePath)(_.filePath(_))
        .ifSome(isMove)(_.isMove(_))
        .build

    def subModule(
      commitId: Option[String] = None,
      absolutePath: Option[String] = None,
      relativePath: Option[String] = None
    ): SubModule =
      SubModule
        .builder
        .ifSome(commitId)(_.commitId(_))
        .ifSome(absolutePath)(_.absolutePath(_))
        .ifSome(relativePath)(_.relativePath(_))
        .build

    def symbolicLink(
      blobId: Option[String] = None,
      absolutePath: Option[String] = None,
      relativePath: Option[String] = None,
      fileMode: Option[String] = None
    ): SymbolicLink =
      SymbolicLink
        .builder
        .ifSome(blobId)(_.blobId(_))
        .ifSome(absolutePath)(_.absolutePath(_))
        .ifSome(relativePath)(_.relativePath(_))
        .ifSome(fileMode)(_.fileMode(_))
        .build

    def tagKeysListRequiredException(

    ): TagKeysListRequiredException =
      TagKeysListRequiredException
        .builder

        .build

    def tagPolicyException(

    ): TagPolicyException =
      TagPolicyException
        .builder

        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[TagsMap] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagsMapRequiredException(

    ): TagsMapRequiredException =
      TagsMapRequiredException
        .builder

        .build

    def target(
      repositoryName: Option[String] = None,
      sourceReference: Option[String] = None,
      destinationReference: Option[String] = None
    ): Target =
      Target
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(sourceReference)(_.sourceReference(_))
        .ifSome(destinationReference)(_.destinationReference(_))
        .build

    def targetRequiredException(

    ): TargetRequiredException =
      TargetRequiredException
        .builder

        .build

    def targetsRequiredException(

    ): TargetsRequiredException =
      TargetsRequiredException
        .builder

        .build

    def testRepositoryTriggersInput(
      repositoryName: Option[String] = None,
      triggers: Option[List[RepositoryTrigger]] = None
    ): TestRepositoryTriggersInput =
      TestRepositoryTriggersInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(triggers)(_.triggers(_))
        .build

    def testRepositoryTriggersOutput(
      successfulExecutions: Option[List[RepositoryTriggerName]] = None,
      failedExecutions: Option[List[RepositoryTriggerExecutionFailure]] = None
    ): TestRepositoryTriggersOutput =
      TestRepositoryTriggersOutput
        .builder
        .ifSome(successfulExecutions)(_.successfulExecutions(_))
        .ifSome(failedExecutions)(_.failedExecutions(_))
        .build

    def tipOfSourceReferenceIsDifferentException(

    ): TipOfSourceReferenceIsDifferentException =
      TipOfSourceReferenceIsDifferentException
        .builder

        .build

    def tipsDivergenceExceededException(

    ): TipsDivergenceExceededException =
      TipsDivergenceExceededException
        .builder

        .build

    def titleRequiredException(

    ): TitleRequiredException =
      TitleRequiredException
        .builder

        .build

    def tooManyTagsException(

    ): TooManyTagsException =
      TooManyTagsException
        .builder

        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateApprovalRuleTemplateContentInput(
      approvalRuleTemplateName: Option[String] = None,
      newRuleContent: Option[String] = None,
      existingRuleContentSha256: Option[String] = None
    ): UpdateApprovalRuleTemplateContentInput =
      UpdateApprovalRuleTemplateContentInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(newRuleContent)(_.newRuleContent(_))
        .ifSome(existingRuleContentSha256)(_.existingRuleContentSha256(_))
        .build

    def updateApprovalRuleTemplateContentOutput(
      approvalRuleTemplate: Option[ApprovalRuleTemplate] = None
    ): UpdateApprovalRuleTemplateContentOutput =
      UpdateApprovalRuleTemplateContentOutput
        .builder
        .ifSome(approvalRuleTemplate)(_.approvalRuleTemplate(_))
        .build

    def updateApprovalRuleTemplateDescriptionInput(
      approvalRuleTemplateName: Option[String] = None,
      approvalRuleTemplateDescription: Option[String] = None
    ): UpdateApprovalRuleTemplateDescriptionInput =
      UpdateApprovalRuleTemplateDescriptionInput
        .builder
        .ifSome(approvalRuleTemplateName)(_.approvalRuleTemplateName(_))
        .ifSome(approvalRuleTemplateDescription)(_.approvalRuleTemplateDescription(_))
        .build

    def updateApprovalRuleTemplateDescriptionOutput(
      approvalRuleTemplate: Option[ApprovalRuleTemplate] = None
    ): UpdateApprovalRuleTemplateDescriptionOutput =
      UpdateApprovalRuleTemplateDescriptionOutput
        .builder
        .ifSome(approvalRuleTemplate)(_.approvalRuleTemplate(_))
        .build

    def updateApprovalRuleTemplateNameInput(
      oldApprovalRuleTemplateName: Option[String] = None,
      newApprovalRuleTemplateName: Option[String] = None
    ): UpdateApprovalRuleTemplateNameInput =
      UpdateApprovalRuleTemplateNameInput
        .builder
        .ifSome(oldApprovalRuleTemplateName)(_.oldApprovalRuleTemplateName(_))
        .ifSome(newApprovalRuleTemplateName)(_.newApprovalRuleTemplateName(_))
        .build

    def updateApprovalRuleTemplateNameOutput(
      approvalRuleTemplate: Option[ApprovalRuleTemplate] = None
    ): UpdateApprovalRuleTemplateNameOutput =
      UpdateApprovalRuleTemplateNameOutput
        .builder
        .ifSome(approvalRuleTemplate)(_.approvalRuleTemplate(_))
        .build

    def updateCommentInput(
      commentId: Option[String] = None,
      content: Option[String] = None
    ): UpdateCommentInput =
      UpdateCommentInput
        .builder
        .ifSome(commentId)(_.commentId(_))
        .ifSome(content)(_.content(_))
        .build

    def updateCommentOutput(
      comment: Option[Comment] = None
    ): UpdateCommentOutput =
      UpdateCommentOutput
        .builder
        .ifSome(comment)(_.comment(_))
        .build

    def updateDefaultBranchInput(
      repositoryName: Option[String] = None,
      defaultBranchName: Option[String] = None
    ): UpdateDefaultBranchInput =
      UpdateDefaultBranchInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(defaultBranchName)(_.defaultBranchName(_))
        .build

    def updatePullRequestApprovalRuleContentInput(
      pullRequestId: Option[String] = None,
      approvalRuleName: Option[String] = None,
      existingRuleContentSha256: Option[String] = None,
      newRuleContent: Option[String] = None
    ): UpdatePullRequestApprovalRuleContentInput =
      UpdatePullRequestApprovalRuleContentInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(approvalRuleName)(_.approvalRuleName(_))
        .ifSome(existingRuleContentSha256)(_.existingRuleContentSha256(_))
        .ifSome(newRuleContent)(_.newRuleContent(_))
        .build

    def updatePullRequestApprovalRuleContentOutput(
      approvalRule: Option[ApprovalRule] = None
    ): UpdatePullRequestApprovalRuleContentOutput =
      UpdatePullRequestApprovalRuleContentOutput
        .builder
        .ifSome(approvalRule)(_.approvalRule(_))
        .build

    def updatePullRequestApprovalStateInput(
      pullRequestId: Option[String] = None,
      revisionId: Option[String] = None,
      approvalState: Option[String] = None
    ): UpdatePullRequestApprovalStateInput =
      UpdatePullRequestApprovalStateInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(approvalState)(_.approvalState(_))
        .build

    def updatePullRequestDescriptionInput(
      pullRequestId: Option[String] = None,
      description: Option[String] = None
    ): UpdatePullRequestDescriptionInput =
      UpdatePullRequestDescriptionInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(description)(_.description(_))
        .build

    def updatePullRequestDescriptionOutput(
      pullRequest: Option[PullRequest] = None
    ): UpdatePullRequestDescriptionOutput =
      UpdatePullRequestDescriptionOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def updatePullRequestStatusInput(
      pullRequestId: Option[String] = None,
      pullRequestStatus: Option[String] = None
    ): UpdatePullRequestStatusInput =
      UpdatePullRequestStatusInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(pullRequestStatus)(_.pullRequestStatus(_))
        .build

    def updatePullRequestStatusOutput(
      pullRequest: Option[PullRequest] = None
    ): UpdatePullRequestStatusOutput =
      UpdatePullRequestStatusOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def updatePullRequestTitleInput(
      pullRequestId: Option[String] = None,
      title: Option[String] = None
    ): UpdatePullRequestTitleInput =
      UpdatePullRequestTitleInput
        .builder
        .ifSome(pullRequestId)(_.pullRequestId(_))
        .ifSome(title)(_.title(_))
        .build

    def updatePullRequestTitleOutput(
      pullRequest: Option[PullRequest] = None
    ): UpdatePullRequestTitleOutput =
      UpdatePullRequestTitleOutput
        .builder
        .ifSome(pullRequest)(_.pullRequest(_))
        .build

    def updateRepositoryDescriptionInput(
      repositoryName: Option[String] = None,
      repositoryDescription: Option[String] = None
    ): UpdateRepositoryDescriptionInput =
      UpdateRepositoryDescriptionInput
        .builder
        .ifSome(repositoryName)(_.repositoryName(_))
        .ifSome(repositoryDescription)(_.repositoryDescription(_))
        .build

    def updateRepositoryNameInput(
      oldName: Option[String] = None,
      newName: Option[String] = None
    ): UpdateRepositoryNameInput =
      UpdateRepositoryNameInput
        .builder
        .ifSome(oldName)(_.oldName(_))
        .ifSome(newName)(_.newName(_))
        .build

    def userInfo(
      name: Option[String] = None,
      email: Option[String] = None,
      date: Option[String] = None
    ): UserInfo =
      UserInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(email)(_.email(_))
        .ifSome(date)(_.date(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
