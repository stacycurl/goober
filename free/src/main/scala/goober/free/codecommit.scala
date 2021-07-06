package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codecommit.CodeCommitClient
import software.amazon.awssdk.services.codecommit.model._


object codecommit { module =>

  // Free monad over CodeCommitOp
  type CodeCommitIO[A] = FF[CodeCommitOp, A]

  sealed trait CodeCommitOp[A] {
    def visit[F[_]](visitor: CodeCommitOp.Visitor[F]): F[A]
  }

  object CodeCommitOp {
    // Given a CodeCommitClient we can embed a CodeCommitIO program in any algebra that understands embedding.
    implicit val CodeCommitOpEmbeddable: Embeddable[CodeCommitOp, CodeCommitClient] = new Embeddable[CodeCommitOp, CodeCommitClient] {
      def embed[A](client: CodeCommitClient, io: CodeCommitIO[A]): Embedded[A] = Embedded.CodeCommit(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeCommitOp.Visitor[Kleisli[M, CodeCommitClient, *]] {
        def associateApprovalRuleTemplateWithRepository(
          request: AssociateApprovalRuleTemplateWithRepositoryRequest
        ): Kleisli[M, CodeCommitClient, AssociateApprovalRuleTemplateWithRepositoryResponse] =
          primitive(_.associateApprovalRuleTemplateWithRepository(request))

        def batchAssociateApprovalRuleTemplateWithRepositories(
          request: BatchAssociateApprovalRuleTemplateWithRepositoriesRequest
        ): Kleisli[M, CodeCommitClient, BatchAssociateApprovalRuleTemplateWithRepositoriesResponse] =
          primitive(_.batchAssociateApprovalRuleTemplateWithRepositories(request))

        def batchDescribeMergeConflicts(
          request: BatchDescribeMergeConflictsRequest
        ): Kleisli[M, CodeCommitClient, BatchDescribeMergeConflictsResponse] =
          primitive(_.batchDescribeMergeConflicts(request))

        def batchDisassociateApprovalRuleTemplateFromRepositories(
          request: BatchDisassociateApprovalRuleTemplateFromRepositoriesRequest
        ): Kleisli[M, CodeCommitClient, BatchDisassociateApprovalRuleTemplateFromRepositoriesResponse] =
          primitive(_.batchDisassociateApprovalRuleTemplateFromRepositories(request))

        def batchGetCommits(
          request: BatchGetCommitsRequest
        ): Kleisli[M, CodeCommitClient, BatchGetCommitsResponse] =
          primitive(_.batchGetCommits(request))

        def batchGetRepositories(
          request: BatchGetRepositoriesRequest
        ): Kleisli[M, CodeCommitClient, BatchGetRepositoriesResponse] =
          primitive(_.batchGetRepositories(request))

        def createApprovalRuleTemplate(
          request: CreateApprovalRuleTemplateRequest
        ): Kleisli[M, CodeCommitClient, CreateApprovalRuleTemplateResponse] =
          primitive(_.createApprovalRuleTemplate(request))

        def createBranch(
          request: CreateBranchRequest
        ): Kleisli[M, CodeCommitClient, CreateBranchResponse] =
          primitive(_.createBranch(request))

        def createCommit(
          request: CreateCommitRequest
        ): Kleisli[M, CodeCommitClient, CreateCommitResponse] =
          primitive(_.createCommit(request))

        def createPullRequest(
          request: CreatePullRequestRequest
        ): Kleisli[M, CodeCommitClient, CreatePullRequestResponse] =
          primitive(_.createPullRequest(request))

        def createPullRequestApprovalRule(
          request: CreatePullRequestApprovalRuleRequest
        ): Kleisli[M, CodeCommitClient, CreatePullRequestApprovalRuleResponse] =
          primitive(_.createPullRequestApprovalRule(request))

        def createRepository(
          request: CreateRepositoryRequest
        ): Kleisli[M, CodeCommitClient, CreateRepositoryResponse] =
          primitive(_.createRepository(request))

        def createUnreferencedMergeCommit(
          request: CreateUnreferencedMergeCommitRequest
        ): Kleisli[M, CodeCommitClient, CreateUnreferencedMergeCommitResponse] =
          primitive(_.createUnreferencedMergeCommit(request))

        def deleteApprovalRuleTemplate(
          request: DeleteApprovalRuleTemplateRequest
        ): Kleisli[M, CodeCommitClient, DeleteApprovalRuleTemplateResponse] =
          primitive(_.deleteApprovalRuleTemplate(request))

        def deleteBranch(
          request: DeleteBranchRequest
        ): Kleisli[M, CodeCommitClient, DeleteBranchResponse] =
          primitive(_.deleteBranch(request))

        def deleteCommentContent(
          request: DeleteCommentContentRequest
        ): Kleisli[M, CodeCommitClient, DeleteCommentContentResponse] =
          primitive(_.deleteCommentContent(request))

        def deleteFile(
          request: DeleteFileRequest
        ): Kleisli[M, CodeCommitClient, DeleteFileResponse] =
          primitive(_.deleteFile(request))

        def deletePullRequestApprovalRule(
          request: DeletePullRequestApprovalRuleRequest
        ): Kleisli[M, CodeCommitClient, DeletePullRequestApprovalRuleResponse] =
          primitive(_.deletePullRequestApprovalRule(request))

        def deleteRepository(
          request: DeleteRepositoryRequest
        ): Kleisli[M, CodeCommitClient, DeleteRepositoryResponse] =
          primitive(_.deleteRepository(request))

        def describeMergeConflicts(
          request: DescribeMergeConflictsRequest
        ): Kleisli[M, CodeCommitClient, DescribeMergeConflictsResponse] =
          primitive(_.describeMergeConflicts(request))

        def describePullRequestEvents(
          request: DescribePullRequestEventsRequest
        ): Kleisli[M, CodeCommitClient, DescribePullRequestEventsResponse] =
          primitive(_.describePullRequestEvents(request))

        def disassociateApprovalRuleTemplateFromRepository(
          request: DisassociateApprovalRuleTemplateFromRepositoryRequest
        ): Kleisli[M, CodeCommitClient, DisassociateApprovalRuleTemplateFromRepositoryResponse] =
          primitive(_.disassociateApprovalRuleTemplateFromRepository(request))

        def evaluatePullRequestApprovalRules(
          request: EvaluatePullRequestApprovalRulesRequest
        ): Kleisli[M, CodeCommitClient, EvaluatePullRequestApprovalRulesResponse] =
          primitive(_.evaluatePullRequestApprovalRules(request))

        def getApprovalRuleTemplate(
          request: GetApprovalRuleTemplateRequest
        ): Kleisli[M, CodeCommitClient, GetApprovalRuleTemplateResponse] =
          primitive(_.getApprovalRuleTemplate(request))

        def getBlob(
          request: GetBlobRequest
        ): Kleisli[M, CodeCommitClient, GetBlobResponse] =
          primitive(_.getBlob(request))

        def getBranch(
          request: GetBranchRequest
        ): Kleisli[M, CodeCommitClient, GetBranchResponse] =
          primitive(_.getBranch(request))

        def getComment(
          request: GetCommentRequest
        ): Kleisli[M, CodeCommitClient, GetCommentResponse] =
          primitive(_.getComment(request))

        def getCommentReactions(
          request: GetCommentReactionsRequest
        ): Kleisli[M, CodeCommitClient, GetCommentReactionsResponse] =
          primitive(_.getCommentReactions(request))

        def getCommentsForComparedCommit(
          request: GetCommentsForComparedCommitRequest
        ): Kleisli[M, CodeCommitClient, GetCommentsForComparedCommitResponse] =
          primitive(_.getCommentsForComparedCommit(request))

        def getCommentsForPullRequest(
          request: GetCommentsForPullRequestRequest
        ): Kleisli[M, CodeCommitClient, GetCommentsForPullRequestResponse] =
          primitive(_.getCommentsForPullRequest(request))

        def getCommit(
          request: GetCommitRequest
        ): Kleisli[M, CodeCommitClient, GetCommitResponse] =
          primitive(_.getCommit(request))

        def getDifferences(
          request: GetDifferencesRequest
        ): Kleisli[M, CodeCommitClient, GetDifferencesResponse] =
          primitive(_.getDifferences(request))

        def getFile(
          request: GetFileRequest
        ): Kleisli[M, CodeCommitClient, GetFileResponse] =
          primitive(_.getFile(request))

        def getFolder(
          request: GetFolderRequest
        ): Kleisli[M, CodeCommitClient, GetFolderResponse] =
          primitive(_.getFolder(request))

        def getMergeCommit(
          request: GetMergeCommitRequest
        ): Kleisli[M, CodeCommitClient, GetMergeCommitResponse] =
          primitive(_.getMergeCommit(request))

        def getMergeConflicts(
          request: GetMergeConflictsRequest
        ): Kleisli[M, CodeCommitClient, GetMergeConflictsResponse] =
          primitive(_.getMergeConflicts(request))

        def getMergeOptions(
          request: GetMergeOptionsRequest
        ): Kleisli[M, CodeCommitClient, GetMergeOptionsResponse] =
          primitive(_.getMergeOptions(request))

        def getPullRequest(
          request: GetPullRequestRequest
        ): Kleisli[M, CodeCommitClient, GetPullRequestResponse] =
          primitive(_.getPullRequest(request))

        def getPullRequestApprovalStates(
          request: GetPullRequestApprovalStatesRequest
        ): Kleisli[M, CodeCommitClient, GetPullRequestApprovalStatesResponse] =
          primitive(_.getPullRequestApprovalStates(request))

        def getPullRequestOverrideState(
          request: GetPullRequestOverrideStateRequest
        ): Kleisli[M, CodeCommitClient, GetPullRequestOverrideStateResponse] =
          primitive(_.getPullRequestOverrideState(request))

        def getRepository(
          request: GetRepositoryRequest
        ): Kleisli[M, CodeCommitClient, GetRepositoryResponse] =
          primitive(_.getRepository(request))

        def getRepositoryTriggers(
          request: GetRepositoryTriggersRequest
        ): Kleisli[M, CodeCommitClient, GetRepositoryTriggersResponse] =
          primitive(_.getRepositoryTriggers(request))

        def listApprovalRuleTemplates(
          request: ListApprovalRuleTemplatesRequest
        ): Kleisli[M, CodeCommitClient, ListApprovalRuleTemplatesResponse] =
          primitive(_.listApprovalRuleTemplates(request))

        def listAssociatedApprovalRuleTemplatesForRepository(
          request: ListAssociatedApprovalRuleTemplatesForRepositoryRequest
        ): Kleisli[M, CodeCommitClient, ListAssociatedApprovalRuleTemplatesForRepositoryResponse] =
          primitive(_.listAssociatedApprovalRuleTemplatesForRepository(request))

        def listBranches(
          request: ListBranchesRequest
        ): Kleisli[M, CodeCommitClient, ListBranchesResponse] =
          primitive(_.listBranches(request))

        def listPullRequests(
          request: ListPullRequestsRequest
        ): Kleisli[M, CodeCommitClient, ListPullRequestsResponse] =
          primitive(_.listPullRequests(request))

        def listRepositories(
          request: ListRepositoriesRequest
        ): Kleisli[M, CodeCommitClient, ListRepositoriesResponse] =
          primitive(_.listRepositories(request))

        def listRepositoriesForApprovalRuleTemplate(
          request: ListRepositoriesForApprovalRuleTemplateRequest
        ): Kleisli[M, CodeCommitClient, ListRepositoriesForApprovalRuleTemplateResponse] =
          primitive(_.listRepositoriesForApprovalRuleTemplate(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodeCommitClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def mergeBranchesByFastForward(
          request: MergeBranchesByFastForwardRequest
        ): Kleisli[M, CodeCommitClient, MergeBranchesByFastForwardResponse] =
          primitive(_.mergeBranchesByFastForward(request))

        def mergeBranchesBySquash(
          request: MergeBranchesBySquashRequest
        ): Kleisli[M, CodeCommitClient, MergeBranchesBySquashResponse] =
          primitive(_.mergeBranchesBySquash(request))

        def mergeBranchesByThreeWay(
          request: MergeBranchesByThreeWayRequest
        ): Kleisli[M, CodeCommitClient, MergeBranchesByThreeWayResponse] =
          primitive(_.mergeBranchesByThreeWay(request))

        def mergePullRequestByFastForward(
          request: MergePullRequestByFastForwardRequest
        ): Kleisli[M, CodeCommitClient, MergePullRequestByFastForwardResponse] =
          primitive(_.mergePullRequestByFastForward(request))

        def mergePullRequestBySquash(
          request: MergePullRequestBySquashRequest
        ): Kleisli[M, CodeCommitClient, MergePullRequestBySquashResponse] =
          primitive(_.mergePullRequestBySquash(request))

        def mergePullRequestByThreeWay(
          request: MergePullRequestByThreeWayRequest
        ): Kleisli[M, CodeCommitClient, MergePullRequestByThreeWayResponse] =
          primitive(_.mergePullRequestByThreeWay(request))

        def overridePullRequestApprovalRules(
          request: OverridePullRequestApprovalRulesRequest
        ): Kleisli[M, CodeCommitClient, OverridePullRequestApprovalRulesResponse] =
          primitive(_.overridePullRequestApprovalRules(request))

        def postCommentForComparedCommit(
          request: PostCommentForComparedCommitRequest
        ): Kleisli[M, CodeCommitClient, PostCommentForComparedCommitResponse] =
          primitive(_.postCommentForComparedCommit(request))

        def postCommentForPullRequest(
          request: PostCommentForPullRequestRequest
        ): Kleisli[M, CodeCommitClient, PostCommentForPullRequestResponse] =
          primitive(_.postCommentForPullRequest(request))

        def postCommentReply(
          request: PostCommentReplyRequest
        ): Kleisli[M, CodeCommitClient, PostCommentReplyResponse] =
          primitive(_.postCommentReply(request))

        def putCommentReaction(
          request: PutCommentReactionRequest
        ): Kleisli[M, CodeCommitClient, PutCommentReactionResponse] =
          primitive(_.putCommentReaction(request))

        def putFile(
          request: PutFileRequest
        ): Kleisli[M, CodeCommitClient, PutFileResponse] =
          primitive(_.putFile(request))

        def putRepositoryTriggers(
          request: PutRepositoryTriggersRequest
        ): Kleisli[M, CodeCommitClient, PutRepositoryTriggersResponse] =
          primitive(_.putRepositoryTriggers(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodeCommitClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testRepositoryTriggers(
          request: TestRepositoryTriggersRequest
        ): Kleisli[M, CodeCommitClient, TestRepositoryTriggersResponse] =
          primitive(_.testRepositoryTriggers(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodeCommitClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApprovalRuleTemplateContent(
          request: UpdateApprovalRuleTemplateContentRequest
        ): Kleisli[M, CodeCommitClient, UpdateApprovalRuleTemplateContentResponse] =
          primitive(_.updateApprovalRuleTemplateContent(request))

        def updateApprovalRuleTemplateDescription(
          request: UpdateApprovalRuleTemplateDescriptionRequest
        ): Kleisli[M, CodeCommitClient, UpdateApprovalRuleTemplateDescriptionResponse] =
          primitive(_.updateApprovalRuleTemplateDescription(request))

        def updateApprovalRuleTemplateName(
          request: UpdateApprovalRuleTemplateNameRequest
        ): Kleisli[M, CodeCommitClient, UpdateApprovalRuleTemplateNameResponse] =
          primitive(_.updateApprovalRuleTemplateName(request))

        def updateComment(
          request: UpdateCommentRequest
        ): Kleisli[M, CodeCommitClient, UpdateCommentResponse] =
          primitive(_.updateComment(request))

        def updateDefaultBranch(
          request: UpdateDefaultBranchRequest
        ): Kleisli[M, CodeCommitClient, UpdateDefaultBranchResponse] =
          primitive(_.updateDefaultBranch(request))

        def updatePullRequestApprovalRuleContent(
          request: UpdatePullRequestApprovalRuleContentRequest
        ): Kleisli[M, CodeCommitClient, UpdatePullRequestApprovalRuleContentResponse] =
          primitive(_.updatePullRequestApprovalRuleContent(request))

        def updatePullRequestApprovalState(
          request: UpdatePullRequestApprovalStateRequest
        ): Kleisli[M, CodeCommitClient, UpdatePullRequestApprovalStateResponse] =
          primitive(_.updatePullRequestApprovalState(request))

        def updatePullRequestDescription(
          request: UpdatePullRequestDescriptionRequest
        ): Kleisli[M, CodeCommitClient, UpdatePullRequestDescriptionResponse] =
          primitive(_.updatePullRequestDescription(request))

        def updatePullRequestStatus(
          request: UpdatePullRequestStatusRequest
        ): Kleisli[M, CodeCommitClient, UpdatePullRequestStatusResponse] =
          primitive(_.updatePullRequestStatus(request))

        def updatePullRequestTitle(
          request: UpdatePullRequestTitleRequest
        ): Kleisli[M, CodeCommitClient, UpdatePullRequestTitleResponse] =
          primitive(_.updatePullRequestTitle(request))

        def updateRepositoryDescription(
          request: UpdateRepositoryDescriptionRequest
        ): Kleisli[M, CodeCommitClient, UpdateRepositoryDescriptionResponse] =
          primitive(_.updateRepositoryDescription(request))

        def updateRepositoryName(
          request: UpdateRepositoryNameRequest
        ): Kleisli[M, CodeCommitClient, UpdateRepositoryNameResponse] =
          primitive(_.updateRepositoryName(request))

        def primitive[A](
          f: CodeCommitClient => A
        ): Kleisli[M, CodeCommitClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeCommitOp ~> F) {
      final def apply[A](op: CodeCommitOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateApprovalRuleTemplateWithRepository(
        request: AssociateApprovalRuleTemplateWithRepositoryRequest
      ): F[AssociateApprovalRuleTemplateWithRepositoryResponse]

      def batchAssociateApprovalRuleTemplateWithRepositories(
        request: BatchAssociateApprovalRuleTemplateWithRepositoriesRequest
      ): F[BatchAssociateApprovalRuleTemplateWithRepositoriesResponse]

      def batchDescribeMergeConflicts(
        request: BatchDescribeMergeConflictsRequest
      ): F[BatchDescribeMergeConflictsResponse]

      def batchDisassociateApprovalRuleTemplateFromRepositories(
        request: BatchDisassociateApprovalRuleTemplateFromRepositoriesRequest
      ): F[BatchDisassociateApprovalRuleTemplateFromRepositoriesResponse]

      def batchGetCommits(
        request: BatchGetCommitsRequest
      ): F[BatchGetCommitsResponse]

      def batchGetRepositories(
        request: BatchGetRepositoriesRequest
      ): F[BatchGetRepositoriesResponse]

      def createApprovalRuleTemplate(
        request: CreateApprovalRuleTemplateRequest
      ): F[CreateApprovalRuleTemplateResponse]

      def createBranch(
        request: CreateBranchRequest
      ): F[CreateBranchResponse]

      def createCommit(
        request: CreateCommitRequest
      ): F[CreateCommitResponse]

      def createPullRequest(
        request: CreatePullRequestRequest
      ): F[CreatePullRequestResponse]

      def createPullRequestApprovalRule(
        request: CreatePullRequestApprovalRuleRequest
      ): F[CreatePullRequestApprovalRuleResponse]

      def createRepository(
        request: CreateRepositoryRequest
      ): F[CreateRepositoryResponse]

      def createUnreferencedMergeCommit(
        request: CreateUnreferencedMergeCommitRequest
      ): F[CreateUnreferencedMergeCommitResponse]

      def deleteApprovalRuleTemplate(
        request: DeleteApprovalRuleTemplateRequest
      ): F[DeleteApprovalRuleTemplateResponse]

      def deleteBranch(
        request: DeleteBranchRequest
      ): F[DeleteBranchResponse]

      def deleteCommentContent(
        request: DeleteCommentContentRequest
      ): F[DeleteCommentContentResponse]

      def deleteFile(
        request: DeleteFileRequest
      ): F[DeleteFileResponse]

      def deletePullRequestApprovalRule(
        request: DeletePullRequestApprovalRuleRequest
      ): F[DeletePullRequestApprovalRuleResponse]

      def deleteRepository(
        request: DeleteRepositoryRequest
      ): F[DeleteRepositoryResponse]

      def describeMergeConflicts(
        request: DescribeMergeConflictsRequest
      ): F[DescribeMergeConflictsResponse]

      def describePullRequestEvents(
        request: DescribePullRequestEventsRequest
      ): F[DescribePullRequestEventsResponse]

      def disassociateApprovalRuleTemplateFromRepository(
        request: DisassociateApprovalRuleTemplateFromRepositoryRequest
      ): F[DisassociateApprovalRuleTemplateFromRepositoryResponse]

      def evaluatePullRequestApprovalRules(
        request: EvaluatePullRequestApprovalRulesRequest
      ): F[EvaluatePullRequestApprovalRulesResponse]

      def getApprovalRuleTemplate(
        request: GetApprovalRuleTemplateRequest
      ): F[GetApprovalRuleTemplateResponse]

      def getBlob(
        request: GetBlobRequest
      ): F[GetBlobResponse]

      def getBranch(
        request: GetBranchRequest
      ): F[GetBranchResponse]

      def getComment(
        request: GetCommentRequest
      ): F[GetCommentResponse]

      def getCommentReactions(
        request: GetCommentReactionsRequest
      ): F[GetCommentReactionsResponse]

      def getCommentsForComparedCommit(
        request: GetCommentsForComparedCommitRequest
      ): F[GetCommentsForComparedCommitResponse]

      def getCommentsForPullRequest(
        request: GetCommentsForPullRequestRequest
      ): F[GetCommentsForPullRequestResponse]

      def getCommit(
        request: GetCommitRequest
      ): F[GetCommitResponse]

      def getDifferences(
        request: GetDifferencesRequest
      ): F[GetDifferencesResponse]

      def getFile(
        request: GetFileRequest
      ): F[GetFileResponse]

      def getFolder(
        request: GetFolderRequest
      ): F[GetFolderResponse]

      def getMergeCommit(
        request: GetMergeCommitRequest
      ): F[GetMergeCommitResponse]

      def getMergeConflicts(
        request: GetMergeConflictsRequest
      ): F[GetMergeConflictsResponse]

      def getMergeOptions(
        request: GetMergeOptionsRequest
      ): F[GetMergeOptionsResponse]

      def getPullRequest(
        request: GetPullRequestRequest
      ): F[GetPullRequestResponse]

      def getPullRequestApprovalStates(
        request: GetPullRequestApprovalStatesRequest
      ): F[GetPullRequestApprovalStatesResponse]

      def getPullRequestOverrideState(
        request: GetPullRequestOverrideStateRequest
      ): F[GetPullRequestOverrideStateResponse]

      def getRepository(
        request: GetRepositoryRequest
      ): F[GetRepositoryResponse]

      def getRepositoryTriggers(
        request: GetRepositoryTriggersRequest
      ): F[GetRepositoryTriggersResponse]

      def listApprovalRuleTemplates(
        request: ListApprovalRuleTemplatesRequest
      ): F[ListApprovalRuleTemplatesResponse]

      def listAssociatedApprovalRuleTemplatesForRepository(
        request: ListAssociatedApprovalRuleTemplatesForRepositoryRequest
      ): F[ListAssociatedApprovalRuleTemplatesForRepositoryResponse]

      def listBranches(
        request: ListBranchesRequest
      ): F[ListBranchesResponse]

      def listPullRequests(
        request: ListPullRequestsRequest
      ): F[ListPullRequestsResponse]

      def listRepositories(
        request: ListRepositoriesRequest
      ): F[ListRepositoriesResponse]

      def listRepositoriesForApprovalRuleTemplate(
        request: ListRepositoriesForApprovalRuleTemplateRequest
      ): F[ListRepositoriesForApprovalRuleTemplateResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def mergeBranchesByFastForward(
        request: MergeBranchesByFastForwardRequest
      ): F[MergeBranchesByFastForwardResponse]

      def mergeBranchesBySquash(
        request: MergeBranchesBySquashRequest
      ): F[MergeBranchesBySquashResponse]

      def mergeBranchesByThreeWay(
        request: MergeBranchesByThreeWayRequest
      ): F[MergeBranchesByThreeWayResponse]

      def mergePullRequestByFastForward(
        request: MergePullRequestByFastForwardRequest
      ): F[MergePullRequestByFastForwardResponse]

      def mergePullRequestBySquash(
        request: MergePullRequestBySquashRequest
      ): F[MergePullRequestBySquashResponse]

      def mergePullRequestByThreeWay(
        request: MergePullRequestByThreeWayRequest
      ): F[MergePullRequestByThreeWayResponse]

      def overridePullRequestApprovalRules(
        request: OverridePullRequestApprovalRulesRequest
      ): F[OverridePullRequestApprovalRulesResponse]

      def postCommentForComparedCommit(
        request: PostCommentForComparedCommitRequest
      ): F[PostCommentForComparedCommitResponse]

      def postCommentForPullRequest(
        request: PostCommentForPullRequestRequest
      ): F[PostCommentForPullRequestResponse]

      def postCommentReply(
        request: PostCommentReplyRequest
      ): F[PostCommentReplyResponse]

      def putCommentReaction(
        request: PutCommentReactionRequest
      ): F[PutCommentReactionResponse]

      def putFile(
        request: PutFileRequest
      ): F[PutFileResponse]

      def putRepositoryTriggers(
        request: PutRepositoryTriggersRequest
      ): F[PutRepositoryTriggersResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testRepositoryTriggers(
        request: TestRepositoryTriggersRequest
      ): F[TestRepositoryTriggersResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApprovalRuleTemplateContent(
        request: UpdateApprovalRuleTemplateContentRequest
      ): F[UpdateApprovalRuleTemplateContentResponse]

      def updateApprovalRuleTemplateDescription(
        request: UpdateApprovalRuleTemplateDescriptionRequest
      ): F[UpdateApprovalRuleTemplateDescriptionResponse]

      def updateApprovalRuleTemplateName(
        request: UpdateApprovalRuleTemplateNameRequest
      ): F[UpdateApprovalRuleTemplateNameResponse]

      def updateComment(
        request: UpdateCommentRequest
      ): F[UpdateCommentResponse]

      def updateDefaultBranch(
        request: UpdateDefaultBranchRequest
      ): F[UpdateDefaultBranchResponse]

      def updatePullRequestApprovalRuleContent(
        request: UpdatePullRequestApprovalRuleContentRequest
      ): F[UpdatePullRequestApprovalRuleContentResponse]

      def updatePullRequestApprovalState(
        request: UpdatePullRequestApprovalStateRequest
      ): F[UpdatePullRequestApprovalStateResponse]

      def updatePullRequestDescription(
        request: UpdatePullRequestDescriptionRequest
      ): F[UpdatePullRequestDescriptionResponse]

      def updatePullRequestStatus(
        request: UpdatePullRequestStatusRequest
      ): F[UpdatePullRequestStatusResponse]

      def updatePullRequestTitle(
        request: UpdatePullRequestTitleRequest
      ): F[UpdatePullRequestTitleResponse]

      def updateRepositoryDescription(
        request: UpdateRepositoryDescriptionRequest
      ): F[UpdateRepositoryDescriptionResponse]

      def updateRepositoryName(
        request: UpdateRepositoryNameRequest
      ): F[UpdateRepositoryNameResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeCommitOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateApprovalRuleTemplateWithRepositoryOp(
      request: AssociateApprovalRuleTemplateWithRepositoryRequest
    ) extends CodeCommitOp[AssociateApprovalRuleTemplateWithRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateApprovalRuleTemplateWithRepositoryResponse] =
        visitor.associateApprovalRuleTemplateWithRepository(request)
    }

    final case class BatchAssociateApprovalRuleTemplateWithRepositoriesOp(
      request: BatchAssociateApprovalRuleTemplateWithRepositoriesRequest
    ) extends CodeCommitOp[BatchAssociateApprovalRuleTemplateWithRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateApprovalRuleTemplateWithRepositoriesResponse] =
        visitor.batchAssociateApprovalRuleTemplateWithRepositories(request)
    }

    final case class BatchDescribeMergeConflictsOp(
      request: BatchDescribeMergeConflictsRequest
    ) extends CodeCommitOp[BatchDescribeMergeConflictsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDescribeMergeConflictsResponse] =
        visitor.batchDescribeMergeConflicts(request)
    }

    final case class BatchDisassociateApprovalRuleTemplateFromRepositoriesOp(
      request: BatchDisassociateApprovalRuleTemplateFromRepositoriesRequest
    ) extends CodeCommitOp[BatchDisassociateApprovalRuleTemplateFromRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateApprovalRuleTemplateFromRepositoriesResponse] =
        visitor.batchDisassociateApprovalRuleTemplateFromRepositories(request)
    }

    final case class BatchGetCommitsOp(
      request: BatchGetCommitsRequest
    ) extends CodeCommitOp[BatchGetCommitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetCommitsResponse] =
        visitor.batchGetCommits(request)
    }

    final case class BatchGetRepositoriesOp(
      request: BatchGetRepositoriesRequest
    ) extends CodeCommitOp[BatchGetRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetRepositoriesResponse] =
        visitor.batchGetRepositories(request)
    }

    final case class CreateApprovalRuleTemplateOp(
      request: CreateApprovalRuleTemplateRequest
    ) extends CodeCommitOp[CreateApprovalRuleTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApprovalRuleTemplateResponse] =
        visitor.createApprovalRuleTemplate(request)
    }

    final case class CreateBranchOp(
      request: CreateBranchRequest
    ) extends CodeCommitOp[CreateBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBranchResponse] =
        visitor.createBranch(request)
    }

    final case class CreateCommitOp(
      request: CreateCommitRequest
    ) extends CodeCommitOp[CreateCommitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCommitResponse] =
        visitor.createCommit(request)
    }

    final case class CreatePullRequestOp(
      request: CreatePullRequestRequest
    ) extends CodeCommitOp[CreatePullRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePullRequestResponse] =
        visitor.createPullRequest(request)
    }

    final case class CreatePullRequestApprovalRuleOp(
      request: CreatePullRequestApprovalRuleRequest
    ) extends CodeCommitOp[CreatePullRequestApprovalRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePullRequestApprovalRuleResponse] =
        visitor.createPullRequestApprovalRule(request)
    }

    final case class CreateRepositoryOp(
      request: CreateRepositoryRequest
    ) extends CodeCommitOp[CreateRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRepositoryResponse] =
        visitor.createRepository(request)
    }

    final case class CreateUnreferencedMergeCommitOp(
      request: CreateUnreferencedMergeCommitRequest
    ) extends CodeCommitOp[CreateUnreferencedMergeCommitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUnreferencedMergeCommitResponse] =
        visitor.createUnreferencedMergeCommit(request)
    }

    final case class DeleteApprovalRuleTemplateOp(
      request: DeleteApprovalRuleTemplateRequest
    ) extends CodeCommitOp[DeleteApprovalRuleTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApprovalRuleTemplateResponse] =
        visitor.deleteApprovalRuleTemplate(request)
    }

    final case class DeleteBranchOp(
      request: DeleteBranchRequest
    ) extends CodeCommitOp[DeleteBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBranchResponse] =
        visitor.deleteBranch(request)
    }

    final case class DeleteCommentContentOp(
      request: DeleteCommentContentRequest
    ) extends CodeCommitOp[DeleteCommentContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCommentContentResponse] =
        visitor.deleteCommentContent(request)
    }

    final case class DeleteFileOp(
      request: DeleteFileRequest
    ) extends CodeCommitOp[DeleteFileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFileResponse] =
        visitor.deleteFile(request)
    }

    final case class DeletePullRequestApprovalRuleOp(
      request: DeletePullRequestApprovalRuleRequest
    ) extends CodeCommitOp[DeletePullRequestApprovalRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePullRequestApprovalRuleResponse] =
        visitor.deletePullRequestApprovalRule(request)
    }

    final case class DeleteRepositoryOp(
      request: DeleteRepositoryRequest
    ) extends CodeCommitOp[DeleteRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRepositoryResponse] =
        visitor.deleteRepository(request)
    }

    final case class DescribeMergeConflictsOp(
      request: DescribeMergeConflictsRequest
    ) extends CodeCommitOp[DescribeMergeConflictsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMergeConflictsResponse] =
        visitor.describeMergeConflicts(request)
    }

    final case class DescribePullRequestEventsOp(
      request: DescribePullRequestEventsRequest
    ) extends CodeCommitOp[DescribePullRequestEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePullRequestEventsResponse] =
        visitor.describePullRequestEvents(request)
    }

    final case class DisassociateApprovalRuleTemplateFromRepositoryOp(
      request: DisassociateApprovalRuleTemplateFromRepositoryRequest
    ) extends CodeCommitOp[DisassociateApprovalRuleTemplateFromRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateApprovalRuleTemplateFromRepositoryResponse] =
        visitor.disassociateApprovalRuleTemplateFromRepository(request)
    }

    final case class EvaluatePullRequestApprovalRulesOp(
      request: EvaluatePullRequestApprovalRulesRequest
    ) extends CodeCommitOp[EvaluatePullRequestApprovalRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EvaluatePullRequestApprovalRulesResponse] =
        visitor.evaluatePullRequestApprovalRules(request)
    }

    final case class GetApprovalRuleTemplateOp(
      request: GetApprovalRuleTemplateRequest
    ) extends CodeCommitOp[GetApprovalRuleTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApprovalRuleTemplateResponse] =
        visitor.getApprovalRuleTemplate(request)
    }

    final case class GetBlobOp(
      request: GetBlobRequest
    ) extends CodeCommitOp[GetBlobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBlobResponse] =
        visitor.getBlob(request)
    }

    final case class GetBranchOp(
      request: GetBranchRequest
    ) extends CodeCommitOp[GetBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBranchResponse] =
        visitor.getBranch(request)
    }

    final case class GetCommentOp(
      request: GetCommentRequest
    ) extends CodeCommitOp[GetCommentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCommentResponse] =
        visitor.getComment(request)
    }

    final case class GetCommentReactionsOp(
      request: GetCommentReactionsRequest
    ) extends CodeCommitOp[GetCommentReactionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCommentReactionsResponse] =
        visitor.getCommentReactions(request)
    }

    final case class GetCommentsForComparedCommitOp(
      request: GetCommentsForComparedCommitRequest
    ) extends CodeCommitOp[GetCommentsForComparedCommitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCommentsForComparedCommitResponse] =
        visitor.getCommentsForComparedCommit(request)
    }

    final case class GetCommentsForPullRequestOp(
      request: GetCommentsForPullRequestRequest
    ) extends CodeCommitOp[GetCommentsForPullRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCommentsForPullRequestResponse] =
        visitor.getCommentsForPullRequest(request)
    }

    final case class GetCommitOp(
      request: GetCommitRequest
    ) extends CodeCommitOp[GetCommitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCommitResponse] =
        visitor.getCommit(request)
    }

    final case class GetDifferencesOp(
      request: GetDifferencesRequest
    ) extends CodeCommitOp[GetDifferencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDifferencesResponse] =
        visitor.getDifferences(request)
    }

    final case class GetFileOp(
      request: GetFileRequest
    ) extends CodeCommitOp[GetFileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFileResponse] =
        visitor.getFile(request)
    }

    final case class GetFolderOp(
      request: GetFolderRequest
    ) extends CodeCommitOp[GetFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFolderResponse] =
        visitor.getFolder(request)
    }

    final case class GetMergeCommitOp(
      request: GetMergeCommitRequest
    ) extends CodeCommitOp[GetMergeCommitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMergeCommitResponse] =
        visitor.getMergeCommit(request)
    }

    final case class GetMergeConflictsOp(
      request: GetMergeConflictsRequest
    ) extends CodeCommitOp[GetMergeConflictsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMergeConflictsResponse] =
        visitor.getMergeConflicts(request)
    }

    final case class GetMergeOptionsOp(
      request: GetMergeOptionsRequest
    ) extends CodeCommitOp[GetMergeOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMergeOptionsResponse] =
        visitor.getMergeOptions(request)
    }

    final case class GetPullRequestOp(
      request: GetPullRequestRequest
    ) extends CodeCommitOp[GetPullRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPullRequestResponse] =
        visitor.getPullRequest(request)
    }

    final case class GetPullRequestApprovalStatesOp(
      request: GetPullRequestApprovalStatesRequest
    ) extends CodeCommitOp[GetPullRequestApprovalStatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPullRequestApprovalStatesResponse] =
        visitor.getPullRequestApprovalStates(request)
    }

    final case class GetPullRequestOverrideStateOp(
      request: GetPullRequestOverrideStateRequest
    ) extends CodeCommitOp[GetPullRequestOverrideStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPullRequestOverrideStateResponse] =
        visitor.getPullRequestOverrideState(request)
    }

    final case class GetRepositoryOp(
      request: GetRepositoryRequest
    ) extends CodeCommitOp[GetRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryResponse] =
        visitor.getRepository(request)
    }

    final case class GetRepositoryTriggersOp(
      request: GetRepositoryTriggersRequest
    ) extends CodeCommitOp[GetRepositoryTriggersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRepositoryTriggersResponse] =
        visitor.getRepositoryTriggers(request)
    }

    final case class ListApprovalRuleTemplatesOp(
      request: ListApprovalRuleTemplatesRequest
    ) extends CodeCommitOp[ListApprovalRuleTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApprovalRuleTemplatesResponse] =
        visitor.listApprovalRuleTemplates(request)
    }

    final case class ListAssociatedApprovalRuleTemplatesForRepositoryOp(
      request: ListAssociatedApprovalRuleTemplatesForRepositoryRequest
    ) extends CodeCommitOp[ListAssociatedApprovalRuleTemplatesForRepositoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociatedApprovalRuleTemplatesForRepositoryResponse] =
        visitor.listAssociatedApprovalRuleTemplatesForRepository(request)
    }

    final case class ListBranchesOp(
      request: ListBranchesRequest
    ) extends CodeCommitOp[ListBranchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBranchesResponse] =
        visitor.listBranches(request)
    }

    final case class ListPullRequestsOp(
      request: ListPullRequestsRequest
    ) extends CodeCommitOp[ListPullRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPullRequestsResponse] =
        visitor.listPullRequests(request)
    }

    final case class ListRepositoriesOp(
      request: ListRepositoriesRequest
    ) extends CodeCommitOp[ListRepositoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRepositoriesResponse] =
        visitor.listRepositories(request)
    }

    final case class ListRepositoriesForApprovalRuleTemplateOp(
      request: ListRepositoriesForApprovalRuleTemplateRequest
    ) extends CodeCommitOp[ListRepositoriesForApprovalRuleTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRepositoriesForApprovalRuleTemplateResponse] =
        visitor.listRepositoriesForApprovalRuleTemplate(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodeCommitOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class MergeBranchesByFastForwardOp(
      request: MergeBranchesByFastForwardRequest
    ) extends CodeCommitOp[MergeBranchesByFastForwardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergeBranchesByFastForwardResponse] =
        visitor.mergeBranchesByFastForward(request)
    }

    final case class MergeBranchesBySquashOp(
      request: MergeBranchesBySquashRequest
    ) extends CodeCommitOp[MergeBranchesBySquashResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergeBranchesBySquashResponse] =
        visitor.mergeBranchesBySquash(request)
    }

    final case class MergeBranchesByThreeWayOp(
      request: MergeBranchesByThreeWayRequest
    ) extends CodeCommitOp[MergeBranchesByThreeWayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergeBranchesByThreeWayResponse] =
        visitor.mergeBranchesByThreeWay(request)
    }

    final case class MergePullRequestByFastForwardOp(
      request: MergePullRequestByFastForwardRequest
    ) extends CodeCommitOp[MergePullRequestByFastForwardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergePullRequestByFastForwardResponse] =
        visitor.mergePullRequestByFastForward(request)
    }

    final case class MergePullRequestBySquashOp(
      request: MergePullRequestBySquashRequest
    ) extends CodeCommitOp[MergePullRequestBySquashResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergePullRequestBySquashResponse] =
        visitor.mergePullRequestBySquash(request)
    }

    final case class MergePullRequestByThreeWayOp(
      request: MergePullRequestByThreeWayRequest
    ) extends CodeCommitOp[MergePullRequestByThreeWayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MergePullRequestByThreeWayResponse] =
        visitor.mergePullRequestByThreeWay(request)
    }

    final case class OverridePullRequestApprovalRulesOp(
      request: OverridePullRequestApprovalRulesRequest
    ) extends CodeCommitOp[OverridePullRequestApprovalRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[OverridePullRequestApprovalRulesResponse] =
        visitor.overridePullRequestApprovalRules(request)
    }

    final case class PostCommentForComparedCommitOp(
      request: PostCommentForComparedCommitRequest
    ) extends CodeCommitOp[PostCommentForComparedCommitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostCommentForComparedCommitResponse] =
        visitor.postCommentForComparedCommit(request)
    }

    final case class PostCommentForPullRequestOp(
      request: PostCommentForPullRequestRequest
    ) extends CodeCommitOp[PostCommentForPullRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostCommentForPullRequestResponse] =
        visitor.postCommentForPullRequest(request)
    }

    final case class PostCommentReplyOp(
      request: PostCommentReplyRequest
    ) extends CodeCommitOp[PostCommentReplyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PostCommentReplyResponse] =
        visitor.postCommentReply(request)
    }

    final case class PutCommentReactionOp(
      request: PutCommentReactionRequest
    ) extends CodeCommitOp[PutCommentReactionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutCommentReactionResponse] =
        visitor.putCommentReaction(request)
    }

    final case class PutFileOp(
      request: PutFileRequest
    ) extends CodeCommitOp[PutFileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFileResponse] =
        visitor.putFile(request)
    }

    final case class PutRepositoryTriggersOp(
      request: PutRepositoryTriggersRequest
    ) extends CodeCommitOp[PutRepositoryTriggersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRepositoryTriggersResponse] =
        visitor.putRepositoryTriggers(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodeCommitOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestRepositoryTriggersOp(
      request: TestRepositoryTriggersRequest
    ) extends CodeCommitOp[TestRepositoryTriggersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestRepositoryTriggersResponse] =
        visitor.testRepositoryTriggers(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodeCommitOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApprovalRuleTemplateContentOp(
      request: UpdateApprovalRuleTemplateContentRequest
    ) extends CodeCommitOp[UpdateApprovalRuleTemplateContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApprovalRuleTemplateContentResponse] =
        visitor.updateApprovalRuleTemplateContent(request)
    }

    final case class UpdateApprovalRuleTemplateDescriptionOp(
      request: UpdateApprovalRuleTemplateDescriptionRequest
    ) extends CodeCommitOp[UpdateApprovalRuleTemplateDescriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApprovalRuleTemplateDescriptionResponse] =
        visitor.updateApprovalRuleTemplateDescription(request)
    }

    final case class UpdateApprovalRuleTemplateNameOp(
      request: UpdateApprovalRuleTemplateNameRequest
    ) extends CodeCommitOp[UpdateApprovalRuleTemplateNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApprovalRuleTemplateNameResponse] =
        visitor.updateApprovalRuleTemplateName(request)
    }

    final case class UpdateCommentOp(
      request: UpdateCommentRequest
    ) extends CodeCommitOp[UpdateCommentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCommentResponse] =
        visitor.updateComment(request)
    }

    final case class UpdateDefaultBranchOp(
      request: UpdateDefaultBranchRequest
    ) extends CodeCommitOp[UpdateDefaultBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDefaultBranchResponse] =
        visitor.updateDefaultBranch(request)
    }

    final case class UpdatePullRequestApprovalRuleContentOp(
      request: UpdatePullRequestApprovalRuleContentRequest
    ) extends CodeCommitOp[UpdatePullRequestApprovalRuleContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePullRequestApprovalRuleContentResponse] =
        visitor.updatePullRequestApprovalRuleContent(request)
    }

    final case class UpdatePullRequestApprovalStateOp(
      request: UpdatePullRequestApprovalStateRequest
    ) extends CodeCommitOp[UpdatePullRequestApprovalStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePullRequestApprovalStateResponse] =
        visitor.updatePullRequestApprovalState(request)
    }

    final case class UpdatePullRequestDescriptionOp(
      request: UpdatePullRequestDescriptionRequest
    ) extends CodeCommitOp[UpdatePullRequestDescriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePullRequestDescriptionResponse] =
        visitor.updatePullRequestDescription(request)
    }

    final case class UpdatePullRequestStatusOp(
      request: UpdatePullRequestStatusRequest
    ) extends CodeCommitOp[UpdatePullRequestStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePullRequestStatusResponse] =
        visitor.updatePullRequestStatus(request)
    }

    final case class UpdatePullRequestTitleOp(
      request: UpdatePullRequestTitleRequest
    ) extends CodeCommitOp[UpdatePullRequestTitleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePullRequestTitleResponse] =
        visitor.updatePullRequestTitle(request)
    }

    final case class UpdateRepositoryDescriptionOp(
      request: UpdateRepositoryDescriptionRequest
    ) extends CodeCommitOp[UpdateRepositoryDescriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRepositoryDescriptionResponse] =
        visitor.updateRepositoryDescription(request)
    }

    final case class UpdateRepositoryNameOp(
      request: UpdateRepositoryNameRequest
    ) extends CodeCommitOp[UpdateRepositoryNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRepositoryNameResponse] =
        visitor.updateRepositoryName(request)
    }
  }

  import CodeCommitOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeCommitOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateApprovalRuleTemplateWithRepository(
    request: AssociateApprovalRuleTemplateWithRepositoryRequest
  ): CodeCommitIO[AssociateApprovalRuleTemplateWithRepositoryResponse] =
    FF.liftF(AssociateApprovalRuleTemplateWithRepositoryOp(request))

  def batchAssociateApprovalRuleTemplateWithRepositories(
    request: BatchAssociateApprovalRuleTemplateWithRepositoriesRequest
  ): CodeCommitIO[BatchAssociateApprovalRuleTemplateWithRepositoriesResponse] =
    FF.liftF(BatchAssociateApprovalRuleTemplateWithRepositoriesOp(request))

  def batchDescribeMergeConflicts(
    request: BatchDescribeMergeConflictsRequest
  ): CodeCommitIO[BatchDescribeMergeConflictsResponse] =
    FF.liftF(BatchDescribeMergeConflictsOp(request))

  def batchDisassociateApprovalRuleTemplateFromRepositories(
    request: BatchDisassociateApprovalRuleTemplateFromRepositoriesRequest
  ): CodeCommitIO[BatchDisassociateApprovalRuleTemplateFromRepositoriesResponse] =
    FF.liftF(BatchDisassociateApprovalRuleTemplateFromRepositoriesOp(request))

  def batchGetCommits(
    request: BatchGetCommitsRequest
  ): CodeCommitIO[BatchGetCommitsResponse] =
    FF.liftF(BatchGetCommitsOp(request))

  def batchGetRepositories(
    request: BatchGetRepositoriesRequest
  ): CodeCommitIO[BatchGetRepositoriesResponse] =
    FF.liftF(BatchGetRepositoriesOp(request))

  def createApprovalRuleTemplate(
    request: CreateApprovalRuleTemplateRequest
  ): CodeCommitIO[CreateApprovalRuleTemplateResponse] =
    FF.liftF(CreateApprovalRuleTemplateOp(request))

  def createBranch(
    request: CreateBranchRequest
  ): CodeCommitIO[CreateBranchResponse] =
    FF.liftF(CreateBranchOp(request))

  def createCommit(
    request: CreateCommitRequest
  ): CodeCommitIO[CreateCommitResponse] =
    FF.liftF(CreateCommitOp(request))

  def createPullRequest(
    request: CreatePullRequestRequest
  ): CodeCommitIO[CreatePullRequestResponse] =
    FF.liftF(CreatePullRequestOp(request))

  def createPullRequestApprovalRule(
    request: CreatePullRequestApprovalRuleRequest
  ): CodeCommitIO[CreatePullRequestApprovalRuleResponse] =
    FF.liftF(CreatePullRequestApprovalRuleOp(request))

  def createRepository(
    request: CreateRepositoryRequest
  ): CodeCommitIO[CreateRepositoryResponse] =
    FF.liftF(CreateRepositoryOp(request))

  def createUnreferencedMergeCommit(
    request: CreateUnreferencedMergeCommitRequest
  ): CodeCommitIO[CreateUnreferencedMergeCommitResponse] =
    FF.liftF(CreateUnreferencedMergeCommitOp(request))

  def deleteApprovalRuleTemplate(
    request: DeleteApprovalRuleTemplateRequest
  ): CodeCommitIO[DeleteApprovalRuleTemplateResponse] =
    FF.liftF(DeleteApprovalRuleTemplateOp(request))

  def deleteBranch(
    request: DeleteBranchRequest
  ): CodeCommitIO[DeleteBranchResponse] =
    FF.liftF(DeleteBranchOp(request))

  def deleteCommentContent(
    request: DeleteCommentContentRequest
  ): CodeCommitIO[DeleteCommentContentResponse] =
    FF.liftF(DeleteCommentContentOp(request))

  def deleteFile(
    request: DeleteFileRequest
  ): CodeCommitIO[DeleteFileResponse] =
    FF.liftF(DeleteFileOp(request))

  def deletePullRequestApprovalRule(
    request: DeletePullRequestApprovalRuleRequest
  ): CodeCommitIO[DeletePullRequestApprovalRuleResponse] =
    FF.liftF(DeletePullRequestApprovalRuleOp(request))

  def deleteRepository(
    request: DeleteRepositoryRequest
  ): CodeCommitIO[DeleteRepositoryResponse] =
    FF.liftF(DeleteRepositoryOp(request))

  def describeMergeConflicts(
    request: DescribeMergeConflictsRequest
  ): CodeCommitIO[DescribeMergeConflictsResponse] =
    FF.liftF(DescribeMergeConflictsOp(request))

  def describePullRequestEvents(
    request: DescribePullRequestEventsRequest
  ): CodeCommitIO[DescribePullRequestEventsResponse] =
    FF.liftF(DescribePullRequestEventsOp(request))

  def disassociateApprovalRuleTemplateFromRepository(
    request: DisassociateApprovalRuleTemplateFromRepositoryRequest
  ): CodeCommitIO[DisassociateApprovalRuleTemplateFromRepositoryResponse] =
    FF.liftF(DisassociateApprovalRuleTemplateFromRepositoryOp(request))

  def evaluatePullRequestApprovalRules(
    request: EvaluatePullRequestApprovalRulesRequest
  ): CodeCommitIO[EvaluatePullRequestApprovalRulesResponse] =
    FF.liftF(EvaluatePullRequestApprovalRulesOp(request))

  def getApprovalRuleTemplate(
    request: GetApprovalRuleTemplateRequest
  ): CodeCommitIO[GetApprovalRuleTemplateResponse] =
    FF.liftF(GetApprovalRuleTemplateOp(request))

  def getBlob(
    request: GetBlobRequest
  ): CodeCommitIO[GetBlobResponse] =
    FF.liftF(GetBlobOp(request))

  def getBranch(
    request: GetBranchRequest
  ): CodeCommitIO[GetBranchResponse] =
    FF.liftF(GetBranchOp(request))

  def getComment(
    request: GetCommentRequest
  ): CodeCommitIO[GetCommentResponse] =
    FF.liftF(GetCommentOp(request))

  def getCommentReactions(
    request: GetCommentReactionsRequest
  ): CodeCommitIO[GetCommentReactionsResponse] =
    FF.liftF(GetCommentReactionsOp(request))

  def getCommentsForComparedCommit(
    request: GetCommentsForComparedCommitRequest
  ): CodeCommitIO[GetCommentsForComparedCommitResponse] =
    FF.liftF(GetCommentsForComparedCommitOp(request))

  def getCommentsForPullRequest(
    request: GetCommentsForPullRequestRequest
  ): CodeCommitIO[GetCommentsForPullRequestResponse] =
    FF.liftF(GetCommentsForPullRequestOp(request))

  def getCommit(
    request: GetCommitRequest
  ): CodeCommitIO[GetCommitResponse] =
    FF.liftF(GetCommitOp(request))

  def getDifferences(
    request: GetDifferencesRequest
  ): CodeCommitIO[GetDifferencesResponse] =
    FF.liftF(GetDifferencesOp(request))

  def getFile(
    request: GetFileRequest
  ): CodeCommitIO[GetFileResponse] =
    FF.liftF(GetFileOp(request))

  def getFolder(
    request: GetFolderRequest
  ): CodeCommitIO[GetFolderResponse] =
    FF.liftF(GetFolderOp(request))

  def getMergeCommit(
    request: GetMergeCommitRequest
  ): CodeCommitIO[GetMergeCommitResponse] =
    FF.liftF(GetMergeCommitOp(request))

  def getMergeConflicts(
    request: GetMergeConflictsRequest
  ): CodeCommitIO[GetMergeConflictsResponse] =
    FF.liftF(GetMergeConflictsOp(request))

  def getMergeOptions(
    request: GetMergeOptionsRequest
  ): CodeCommitIO[GetMergeOptionsResponse] =
    FF.liftF(GetMergeOptionsOp(request))

  def getPullRequest(
    request: GetPullRequestRequest
  ): CodeCommitIO[GetPullRequestResponse] =
    FF.liftF(GetPullRequestOp(request))

  def getPullRequestApprovalStates(
    request: GetPullRequestApprovalStatesRequest
  ): CodeCommitIO[GetPullRequestApprovalStatesResponse] =
    FF.liftF(GetPullRequestApprovalStatesOp(request))

  def getPullRequestOverrideState(
    request: GetPullRequestOverrideStateRequest
  ): CodeCommitIO[GetPullRequestOverrideStateResponse] =
    FF.liftF(GetPullRequestOverrideStateOp(request))

  def getRepository(
    request: GetRepositoryRequest
  ): CodeCommitIO[GetRepositoryResponse] =
    FF.liftF(GetRepositoryOp(request))

  def getRepositoryTriggers(
    request: GetRepositoryTriggersRequest
  ): CodeCommitIO[GetRepositoryTriggersResponse] =
    FF.liftF(GetRepositoryTriggersOp(request))

  def listApprovalRuleTemplates(
    request: ListApprovalRuleTemplatesRequest
  ): CodeCommitIO[ListApprovalRuleTemplatesResponse] =
    FF.liftF(ListApprovalRuleTemplatesOp(request))

  def listAssociatedApprovalRuleTemplatesForRepository(
    request: ListAssociatedApprovalRuleTemplatesForRepositoryRequest
  ): CodeCommitIO[ListAssociatedApprovalRuleTemplatesForRepositoryResponse] =
    FF.liftF(ListAssociatedApprovalRuleTemplatesForRepositoryOp(request))

  def listBranches(
    request: ListBranchesRequest
  ): CodeCommitIO[ListBranchesResponse] =
    FF.liftF(ListBranchesOp(request))

  def listPullRequests(
    request: ListPullRequestsRequest
  ): CodeCommitIO[ListPullRequestsResponse] =
    FF.liftF(ListPullRequestsOp(request))

  def listRepositories(
    request: ListRepositoriesRequest
  ): CodeCommitIO[ListRepositoriesResponse] =
    FF.liftF(ListRepositoriesOp(request))

  def listRepositoriesForApprovalRuleTemplate(
    request: ListRepositoriesForApprovalRuleTemplateRequest
  ): CodeCommitIO[ListRepositoriesForApprovalRuleTemplateResponse] =
    FF.liftF(ListRepositoriesForApprovalRuleTemplateOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodeCommitIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def mergeBranchesByFastForward(
    request: MergeBranchesByFastForwardRequest
  ): CodeCommitIO[MergeBranchesByFastForwardResponse] =
    FF.liftF(MergeBranchesByFastForwardOp(request))

  def mergeBranchesBySquash(
    request: MergeBranchesBySquashRequest
  ): CodeCommitIO[MergeBranchesBySquashResponse] =
    FF.liftF(MergeBranchesBySquashOp(request))

  def mergeBranchesByThreeWay(
    request: MergeBranchesByThreeWayRequest
  ): CodeCommitIO[MergeBranchesByThreeWayResponse] =
    FF.liftF(MergeBranchesByThreeWayOp(request))

  def mergePullRequestByFastForward(
    request: MergePullRequestByFastForwardRequest
  ): CodeCommitIO[MergePullRequestByFastForwardResponse] =
    FF.liftF(MergePullRequestByFastForwardOp(request))

  def mergePullRequestBySquash(
    request: MergePullRequestBySquashRequest
  ): CodeCommitIO[MergePullRequestBySquashResponse] =
    FF.liftF(MergePullRequestBySquashOp(request))

  def mergePullRequestByThreeWay(
    request: MergePullRequestByThreeWayRequest
  ): CodeCommitIO[MergePullRequestByThreeWayResponse] =
    FF.liftF(MergePullRequestByThreeWayOp(request))

  def overridePullRequestApprovalRules(
    request: OverridePullRequestApprovalRulesRequest
  ): CodeCommitIO[OverridePullRequestApprovalRulesResponse] =
    FF.liftF(OverridePullRequestApprovalRulesOp(request))

  def postCommentForComparedCommit(
    request: PostCommentForComparedCommitRequest
  ): CodeCommitIO[PostCommentForComparedCommitResponse] =
    FF.liftF(PostCommentForComparedCommitOp(request))

  def postCommentForPullRequest(
    request: PostCommentForPullRequestRequest
  ): CodeCommitIO[PostCommentForPullRequestResponse] =
    FF.liftF(PostCommentForPullRequestOp(request))

  def postCommentReply(
    request: PostCommentReplyRequest
  ): CodeCommitIO[PostCommentReplyResponse] =
    FF.liftF(PostCommentReplyOp(request))

  def putCommentReaction(
    request: PutCommentReactionRequest
  ): CodeCommitIO[PutCommentReactionResponse] =
    FF.liftF(PutCommentReactionOp(request))

  def putFile(
    request: PutFileRequest
  ): CodeCommitIO[PutFileResponse] =
    FF.liftF(PutFileOp(request))

  def putRepositoryTriggers(
    request: PutRepositoryTriggersRequest
  ): CodeCommitIO[PutRepositoryTriggersResponse] =
    FF.liftF(PutRepositoryTriggersOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodeCommitIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testRepositoryTriggers(
    request: TestRepositoryTriggersRequest
  ): CodeCommitIO[TestRepositoryTriggersResponse] =
    FF.liftF(TestRepositoryTriggersOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodeCommitIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApprovalRuleTemplateContent(
    request: UpdateApprovalRuleTemplateContentRequest
  ): CodeCommitIO[UpdateApprovalRuleTemplateContentResponse] =
    FF.liftF(UpdateApprovalRuleTemplateContentOp(request))

  def updateApprovalRuleTemplateDescription(
    request: UpdateApprovalRuleTemplateDescriptionRequest
  ): CodeCommitIO[UpdateApprovalRuleTemplateDescriptionResponse] =
    FF.liftF(UpdateApprovalRuleTemplateDescriptionOp(request))

  def updateApprovalRuleTemplateName(
    request: UpdateApprovalRuleTemplateNameRequest
  ): CodeCommitIO[UpdateApprovalRuleTemplateNameResponse] =
    FF.liftF(UpdateApprovalRuleTemplateNameOp(request))

  def updateComment(
    request: UpdateCommentRequest
  ): CodeCommitIO[UpdateCommentResponse] =
    FF.liftF(UpdateCommentOp(request))

  def updateDefaultBranch(
    request: UpdateDefaultBranchRequest
  ): CodeCommitIO[UpdateDefaultBranchResponse] =
    FF.liftF(UpdateDefaultBranchOp(request))

  def updatePullRequestApprovalRuleContent(
    request: UpdatePullRequestApprovalRuleContentRequest
  ): CodeCommitIO[UpdatePullRequestApprovalRuleContentResponse] =
    FF.liftF(UpdatePullRequestApprovalRuleContentOp(request))

  def updatePullRequestApprovalState(
    request: UpdatePullRequestApprovalStateRequest
  ): CodeCommitIO[UpdatePullRequestApprovalStateResponse] =
    FF.liftF(UpdatePullRequestApprovalStateOp(request))

  def updatePullRequestDescription(
    request: UpdatePullRequestDescriptionRequest
  ): CodeCommitIO[UpdatePullRequestDescriptionResponse] =
    FF.liftF(UpdatePullRequestDescriptionOp(request))

  def updatePullRequestStatus(
    request: UpdatePullRequestStatusRequest
  ): CodeCommitIO[UpdatePullRequestStatusResponse] =
    FF.liftF(UpdatePullRequestStatusOp(request))

  def updatePullRequestTitle(
    request: UpdatePullRequestTitleRequest
  ): CodeCommitIO[UpdatePullRequestTitleResponse] =
    FF.liftF(UpdatePullRequestTitleOp(request))

  def updateRepositoryDescription(
    request: UpdateRepositoryDescriptionRequest
  ): CodeCommitIO[UpdateRepositoryDescriptionResponse] =
    FF.liftF(UpdateRepositoryDescriptionOp(request))

  def updateRepositoryName(
    request: UpdateRepositoryNameRequest
  ): CodeCommitIO[UpdateRepositoryNameResponse] =
    FF.liftF(UpdateRepositoryNameOp(request))
}
