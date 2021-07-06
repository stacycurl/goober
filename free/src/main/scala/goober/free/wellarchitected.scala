package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.wellarchitected.WellArchitectedClient
import software.amazon.awssdk.services.wellarchitected.model._


object wellarchitected { module =>

  // Free monad over WellArchitectedOp
  type WellArchitectedIO[A] = FF[WellArchitectedOp, A]

  sealed trait WellArchitectedOp[A] {
    def visit[F[_]](visitor: WellArchitectedOp.Visitor[F]): F[A]
  }

  object WellArchitectedOp {
    // Given a WellArchitectedClient we can embed a WellArchitectedIO program in any algebra that understands embedding.
    implicit val WellArchitectedOpEmbeddable: Embeddable[WellArchitectedOp, WellArchitectedClient] = new Embeddable[WellArchitectedOp, WellArchitectedClient] {
      def embed[A](client: WellArchitectedClient, io: WellArchitectedIO[A]): Embedded[A] = Embedded.WellArchitected(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WellArchitectedOp.Visitor[Kleisli[M, WellArchitectedClient, *]] {
        def associateLenses(
          request: AssociateLensesRequest
        ): Kleisli[M, WellArchitectedClient, AssociateLensesResponse] =
          primitive(_.associateLenses(request))

        def createMilestone(
          request: CreateMilestoneRequest
        ): Kleisli[M, WellArchitectedClient, CreateMilestoneResponse] =
          primitive(_.createMilestone(request))

        def createWorkload(
          request: CreateWorkloadRequest
        ): Kleisli[M, WellArchitectedClient, CreateWorkloadResponse] =
          primitive(_.createWorkload(request))

        def createWorkloadShare(
          request: CreateWorkloadShareRequest
        ): Kleisli[M, WellArchitectedClient, CreateWorkloadShareResponse] =
          primitive(_.createWorkloadShare(request))

        def deleteWorkload(
          request: DeleteWorkloadRequest
        ): Kleisli[M, WellArchitectedClient, DeleteWorkloadResponse] =
          primitive(_.deleteWorkload(request))

        def deleteWorkloadShare(
          request: DeleteWorkloadShareRequest
        ): Kleisli[M, WellArchitectedClient, DeleteWorkloadShareResponse] =
          primitive(_.deleteWorkloadShare(request))

        def disassociateLenses(
          request: DisassociateLensesRequest
        ): Kleisli[M, WellArchitectedClient, DisassociateLensesResponse] =
          primitive(_.disassociateLenses(request))

        def getAnswer(
          request: GetAnswerRequest
        ): Kleisli[M, WellArchitectedClient, GetAnswerResponse] =
          primitive(_.getAnswer(request))

        def getLensReview(
          request: GetLensReviewRequest
        ): Kleisli[M, WellArchitectedClient, GetLensReviewResponse] =
          primitive(_.getLensReview(request))

        def getLensReviewReport(
          request: GetLensReviewReportRequest
        ): Kleisli[M, WellArchitectedClient, GetLensReviewReportResponse] =
          primitive(_.getLensReviewReport(request))

        def getLensVersionDifference(
          request: GetLensVersionDifferenceRequest
        ): Kleisli[M, WellArchitectedClient, GetLensVersionDifferenceResponse] =
          primitive(_.getLensVersionDifference(request))

        def getMilestone(
          request: GetMilestoneRequest
        ): Kleisli[M, WellArchitectedClient, GetMilestoneResponse] =
          primitive(_.getMilestone(request))

        def getWorkload(
          request: GetWorkloadRequest
        ): Kleisli[M, WellArchitectedClient, GetWorkloadResponse] =
          primitive(_.getWorkload(request))

        def listAnswers(
          request: ListAnswersRequest
        ): Kleisli[M, WellArchitectedClient, ListAnswersResponse] =
          primitive(_.listAnswers(request))

        def listLensReviewImprovements(
          request: ListLensReviewImprovementsRequest
        ): Kleisli[M, WellArchitectedClient, ListLensReviewImprovementsResponse] =
          primitive(_.listLensReviewImprovements(request))

        def listLensReviews(
          request: ListLensReviewsRequest
        ): Kleisli[M, WellArchitectedClient, ListLensReviewsResponse] =
          primitive(_.listLensReviews(request))

        def listLenses(
          request: ListLensesRequest
        ): Kleisli[M, WellArchitectedClient, ListLensesResponse] =
          primitive(_.listLenses(request))

        def listMilestones(
          request: ListMilestonesRequest
        ): Kleisli[M, WellArchitectedClient, ListMilestonesResponse] =
          primitive(_.listMilestones(request))

        def listNotifications(
          request: ListNotificationsRequest
        ): Kleisli[M, WellArchitectedClient, ListNotificationsResponse] =
          primitive(_.listNotifications(request))

        def listShareInvitations(
          request: ListShareInvitationsRequest
        ): Kleisli[M, WellArchitectedClient, ListShareInvitationsResponse] =
          primitive(_.listShareInvitations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, WellArchitectedClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWorkloadShares(
          request: ListWorkloadSharesRequest
        ): Kleisli[M, WellArchitectedClient, ListWorkloadSharesResponse] =
          primitive(_.listWorkloadShares(request))

        def listWorkloads(
          request: ListWorkloadsRequest
        ): Kleisli[M, WellArchitectedClient, ListWorkloadsResponse] =
          primitive(_.listWorkloads(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, WellArchitectedClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, WellArchitectedClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAnswer(
          request: UpdateAnswerRequest
        ): Kleisli[M, WellArchitectedClient, UpdateAnswerResponse] =
          primitive(_.updateAnswer(request))

        def updateLensReview(
          request: UpdateLensReviewRequest
        ): Kleisli[M, WellArchitectedClient, UpdateLensReviewResponse] =
          primitive(_.updateLensReview(request))

        def updateShareInvitation(
          request: UpdateShareInvitationRequest
        ): Kleisli[M, WellArchitectedClient, UpdateShareInvitationResponse] =
          primitive(_.updateShareInvitation(request))

        def updateWorkload(
          request: UpdateWorkloadRequest
        ): Kleisli[M, WellArchitectedClient, UpdateWorkloadResponse] =
          primitive(_.updateWorkload(request))

        def updateWorkloadShare(
          request: UpdateWorkloadShareRequest
        ): Kleisli[M, WellArchitectedClient, UpdateWorkloadShareResponse] =
          primitive(_.updateWorkloadShare(request))

        def upgradeLensReview(
          request: UpgradeLensReviewRequest
        ): Kleisli[M, WellArchitectedClient, UpgradeLensReviewResponse] =
          primitive(_.upgradeLensReview(request))

        def primitive[A](
          f: WellArchitectedClient => A
        ): Kleisli[M, WellArchitectedClient, A]
      }
    }

    trait Visitor[F[_]] extends (WellArchitectedOp ~> F) {
      final def apply[A](op: WellArchitectedOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateLenses(
        request: AssociateLensesRequest
      ): F[AssociateLensesResponse]

      def createMilestone(
        request: CreateMilestoneRequest
      ): F[CreateMilestoneResponse]

      def createWorkload(
        request: CreateWorkloadRequest
      ): F[CreateWorkloadResponse]

      def createWorkloadShare(
        request: CreateWorkloadShareRequest
      ): F[CreateWorkloadShareResponse]

      def deleteWorkload(
        request: DeleteWorkloadRequest
      ): F[DeleteWorkloadResponse]

      def deleteWorkloadShare(
        request: DeleteWorkloadShareRequest
      ): F[DeleteWorkloadShareResponse]

      def disassociateLenses(
        request: DisassociateLensesRequest
      ): F[DisassociateLensesResponse]

      def getAnswer(
        request: GetAnswerRequest
      ): F[GetAnswerResponse]

      def getLensReview(
        request: GetLensReviewRequest
      ): F[GetLensReviewResponse]

      def getLensReviewReport(
        request: GetLensReviewReportRequest
      ): F[GetLensReviewReportResponse]

      def getLensVersionDifference(
        request: GetLensVersionDifferenceRequest
      ): F[GetLensVersionDifferenceResponse]

      def getMilestone(
        request: GetMilestoneRequest
      ): F[GetMilestoneResponse]

      def getWorkload(
        request: GetWorkloadRequest
      ): F[GetWorkloadResponse]

      def listAnswers(
        request: ListAnswersRequest
      ): F[ListAnswersResponse]

      def listLensReviewImprovements(
        request: ListLensReviewImprovementsRequest
      ): F[ListLensReviewImprovementsResponse]

      def listLensReviews(
        request: ListLensReviewsRequest
      ): F[ListLensReviewsResponse]

      def listLenses(
        request: ListLensesRequest
      ): F[ListLensesResponse]

      def listMilestones(
        request: ListMilestonesRequest
      ): F[ListMilestonesResponse]

      def listNotifications(
        request: ListNotificationsRequest
      ): F[ListNotificationsResponse]

      def listShareInvitations(
        request: ListShareInvitationsRequest
      ): F[ListShareInvitationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWorkloadShares(
        request: ListWorkloadSharesRequest
      ): F[ListWorkloadSharesResponse]

      def listWorkloads(
        request: ListWorkloadsRequest
      ): F[ListWorkloadsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAnswer(
        request: UpdateAnswerRequest
      ): F[UpdateAnswerResponse]

      def updateLensReview(
        request: UpdateLensReviewRequest
      ): F[UpdateLensReviewResponse]

      def updateShareInvitation(
        request: UpdateShareInvitationRequest
      ): F[UpdateShareInvitationResponse]

      def updateWorkload(
        request: UpdateWorkloadRequest
      ): F[UpdateWorkloadResponse]

      def updateWorkloadShare(
        request: UpdateWorkloadShareRequest
      ): F[UpdateWorkloadShareResponse]

      def upgradeLensReview(
        request: UpgradeLensReviewRequest
      ): F[UpgradeLensReviewResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WellArchitectedOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateLensesOp(
      request: AssociateLensesRequest
    ) extends WellArchitectedOp[AssociateLensesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateLensesResponse] =
        visitor.associateLenses(request)
    }

    final case class CreateMilestoneOp(
      request: CreateMilestoneRequest
    ) extends WellArchitectedOp[CreateMilestoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMilestoneResponse] =
        visitor.createMilestone(request)
    }

    final case class CreateWorkloadOp(
      request: CreateWorkloadRequest
    ) extends WellArchitectedOp[CreateWorkloadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkloadResponse] =
        visitor.createWorkload(request)
    }

    final case class CreateWorkloadShareOp(
      request: CreateWorkloadShareRequest
    ) extends WellArchitectedOp[CreateWorkloadShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkloadShareResponse] =
        visitor.createWorkloadShare(request)
    }

    final case class DeleteWorkloadOp(
      request: DeleteWorkloadRequest
    ) extends WellArchitectedOp[DeleteWorkloadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkloadResponse] =
        visitor.deleteWorkload(request)
    }

    final case class DeleteWorkloadShareOp(
      request: DeleteWorkloadShareRequest
    ) extends WellArchitectedOp[DeleteWorkloadShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkloadShareResponse] =
        visitor.deleteWorkloadShare(request)
    }

    final case class DisassociateLensesOp(
      request: DisassociateLensesRequest
    ) extends WellArchitectedOp[DisassociateLensesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateLensesResponse] =
        visitor.disassociateLenses(request)
    }

    final case class GetAnswerOp(
      request: GetAnswerRequest
    ) extends WellArchitectedOp[GetAnswerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnswerResponse] =
        visitor.getAnswer(request)
    }

    final case class GetLensReviewOp(
      request: GetLensReviewRequest
    ) extends WellArchitectedOp[GetLensReviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLensReviewResponse] =
        visitor.getLensReview(request)
    }

    final case class GetLensReviewReportOp(
      request: GetLensReviewReportRequest
    ) extends WellArchitectedOp[GetLensReviewReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLensReviewReportResponse] =
        visitor.getLensReviewReport(request)
    }

    final case class GetLensVersionDifferenceOp(
      request: GetLensVersionDifferenceRequest
    ) extends WellArchitectedOp[GetLensVersionDifferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLensVersionDifferenceResponse] =
        visitor.getLensVersionDifference(request)
    }

    final case class GetMilestoneOp(
      request: GetMilestoneRequest
    ) extends WellArchitectedOp[GetMilestoneResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMilestoneResponse] =
        visitor.getMilestone(request)
    }

    final case class GetWorkloadOp(
      request: GetWorkloadRequest
    ) extends WellArchitectedOp[GetWorkloadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorkloadResponse] =
        visitor.getWorkload(request)
    }

    final case class ListAnswersOp(
      request: ListAnswersRequest
    ) extends WellArchitectedOp[ListAnswersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnswersResponse] =
        visitor.listAnswers(request)
    }

    final case class ListLensReviewImprovementsOp(
      request: ListLensReviewImprovementsRequest
    ) extends WellArchitectedOp[ListLensReviewImprovementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLensReviewImprovementsResponse] =
        visitor.listLensReviewImprovements(request)
    }

    final case class ListLensReviewsOp(
      request: ListLensReviewsRequest
    ) extends WellArchitectedOp[ListLensReviewsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLensReviewsResponse] =
        visitor.listLensReviews(request)
    }

    final case class ListLensesOp(
      request: ListLensesRequest
    ) extends WellArchitectedOp[ListLensesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLensesResponse] =
        visitor.listLenses(request)
    }

    final case class ListMilestonesOp(
      request: ListMilestonesRequest
    ) extends WellArchitectedOp[ListMilestonesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMilestonesResponse] =
        visitor.listMilestones(request)
    }

    final case class ListNotificationsOp(
      request: ListNotificationsRequest
    ) extends WellArchitectedOp[ListNotificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotificationsResponse] =
        visitor.listNotifications(request)
    }

    final case class ListShareInvitationsOp(
      request: ListShareInvitationsRequest
    ) extends WellArchitectedOp[ListShareInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListShareInvitationsResponse] =
        visitor.listShareInvitations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends WellArchitectedOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWorkloadSharesOp(
      request: ListWorkloadSharesRequest
    ) extends WellArchitectedOp[ListWorkloadSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkloadSharesResponse] =
        visitor.listWorkloadShares(request)
    }

    final case class ListWorkloadsOp(
      request: ListWorkloadsRequest
    ) extends WellArchitectedOp[ListWorkloadsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkloadsResponse] =
        visitor.listWorkloads(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends WellArchitectedOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends WellArchitectedOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAnswerOp(
      request: UpdateAnswerRequest
    ) extends WellArchitectedOp[UpdateAnswerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAnswerResponse] =
        visitor.updateAnswer(request)
    }

    final case class UpdateLensReviewOp(
      request: UpdateLensReviewRequest
    ) extends WellArchitectedOp[UpdateLensReviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLensReviewResponse] =
        visitor.updateLensReview(request)
    }

    final case class UpdateShareInvitationOp(
      request: UpdateShareInvitationRequest
    ) extends WellArchitectedOp[UpdateShareInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateShareInvitationResponse] =
        visitor.updateShareInvitation(request)
    }

    final case class UpdateWorkloadOp(
      request: UpdateWorkloadRequest
    ) extends WellArchitectedOp[UpdateWorkloadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkloadResponse] =
        visitor.updateWorkload(request)
    }

    final case class UpdateWorkloadShareOp(
      request: UpdateWorkloadShareRequest
    ) extends WellArchitectedOp[UpdateWorkloadShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkloadShareResponse] =
        visitor.updateWorkloadShare(request)
    }

    final case class UpgradeLensReviewOp(
      request: UpgradeLensReviewRequest
    ) extends WellArchitectedOp[UpgradeLensReviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpgradeLensReviewResponse] =
        visitor.upgradeLensReview(request)
    }
  }

  import WellArchitectedOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WellArchitectedOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateLenses(
    request: AssociateLensesRequest
  ): WellArchitectedIO[AssociateLensesResponse] =
    FF.liftF(AssociateLensesOp(request))

  def createMilestone(
    request: CreateMilestoneRequest
  ): WellArchitectedIO[CreateMilestoneResponse] =
    FF.liftF(CreateMilestoneOp(request))

  def createWorkload(
    request: CreateWorkloadRequest
  ): WellArchitectedIO[CreateWorkloadResponse] =
    FF.liftF(CreateWorkloadOp(request))

  def createWorkloadShare(
    request: CreateWorkloadShareRequest
  ): WellArchitectedIO[CreateWorkloadShareResponse] =
    FF.liftF(CreateWorkloadShareOp(request))

  def deleteWorkload(
    request: DeleteWorkloadRequest
  ): WellArchitectedIO[DeleteWorkloadResponse] =
    FF.liftF(DeleteWorkloadOp(request))

  def deleteWorkloadShare(
    request: DeleteWorkloadShareRequest
  ): WellArchitectedIO[DeleteWorkloadShareResponse] =
    FF.liftF(DeleteWorkloadShareOp(request))

  def disassociateLenses(
    request: DisassociateLensesRequest
  ): WellArchitectedIO[DisassociateLensesResponse] =
    FF.liftF(DisassociateLensesOp(request))

  def getAnswer(
    request: GetAnswerRequest
  ): WellArchitectedIO[GetAnswerResponse] =
    FF.liftF(GetAnswerOp(request))

  def getLensReview(
    request: GetLensReviewRequest
  ): WellArchitectedIO[GetLensReviewResponse] =
    FF.liftF(GetLensReviewOp(request))

  def getLensReviewReport(
    request: GetLensReviewReportRequest
  ): WellArchitectedIO[GetLensReviewReportResponse] =
    FF.liftF(GetLensReviewReportOp(request))

  def getLensVersionDifference(
    request: GetLensVersionDifferenceRequest
  ): WellArchitectedIO[GetLensVersionDifferenceResponse] =
    FF.liftF(GetLensVersionDifferenceOp(request))

  def getMilestone(
    request: GetMilestoneRequest
  ): WellArchitectedIO[GetMilestoneResponse] =
    FF.liftF(GetMilestoneOp(request))

  def getWorkload(
    request: GetWorkloadRequest
  ): WellArchitectedIO[GetWorkloadResponse] =
    FF.liftF(GetWorkloadOp(request))

  def listAnswers(
    request: ListAnswersRequest
  ): WellArchitectedIO[ListAnswersResponse] =
    FF.liftF(ListAnswersOp(request))

  def listLensReviewImprovements(
    request: ListLensReviewImprovementsRequest
  ): WellArchitectedIO[ListLensReviewImprovementsResponse] =
    FF.liftF(ListLensReviewImprovementsOp(request))

  def listLensReviews(
    request: ListLensReviewsRequest
  ): WellArchitectedIO[ListLensReviewsResponse] =
    FF.liftF(ListLensReviewsOp(request))

  def listLenses(
    request: ListLensesRequest
  ): WellArchitectedIO[ListLensesResponse] =
    FF.liftF(ListLensesOp(request))

  def listMilestones(
    request: ListMilestonesRequest
  ): WellArchitectedIO[ListMilestonesResponse] =
    FF.liftF(ListMilestonesOp(request))

  def listNotifications(
    request: ListNotificationsRequest
  ): WellArchitectedIO[ListNotificationsResponse] =
    FF.liftF(ListNotificationsOp(request))

  def listShareInvitations(
    request: ListShareInvitationsRequest
  ): WellArchitectedIO[ListShareInvitationsResponse] =
    FF.liftF(ListShareInvitationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): WellArchitectedIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWorkloadShares(
    request: ListWorkloadSharesRequest
  ): WellArchitectedIO[ListWorkloadSharesResponse] =
    FF.liftF(ListWorkloadSharesOp(request))

  def listWorkloads(
    request: ListWorkloadsRequest
  ): WellArchitectedIO[ListWorkloadsResponse] =
    FF.liftF(ListWorkloadsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): WellArchitectedIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): WellArchitectedIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAnswer(
    request: UpdateAnswerRequest
  ): WellArchitectedIO[UpdateAnswerResponse] =
    FF.liftF(UpdateAnswerOp(request))

  def updateLensReview(
    request: UpdateLensReviewRequest
  ): WellArchitectedIO[UpdateLensReviewResponse] =
    FF.liftF(UpdateLensReviewOp(request))

  def updateShareInvitation(
    request: UpdateShareInvitationRequest
  ): WellArchitectedIO[UpdateShareInvitationResponse] =
    FF.liftF(UpdateShareInvitationOp(request))

  def updateWorkload(
    request: UpdateWorkloadRequest
  ): WellArchitectedIO[UpdateWorkloadResponse] =
    FF.liftF(UpdateWorkloadOp(request))

  def updateWorkloadShare(
    request: UpdateWorkloadShareRequest
  ): WellArchitectedIO[UpdateWorkloadShareResponse] =
    FF.liftF(UpdateWorkloadShareOp(request))

  def upgradeLensReview(
    request: UpgradeLensReviewRequest
  ): WellArchitectedIO[UpgradeLensReviewResponse] =
    FF.liftF(UpgradeLensReviewOp(request))
}
