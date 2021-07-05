package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mturk.MTurkClient
import software.amazon.awssdk.services.mturk.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object mturk { module =>

  // Free monad over MTurkOp
  type MTurkIO[A] = FF[MTurkOp, A]

  sealed trait MTurkOp[A] {
    def visit[F[_]](visitor: MTurkOp.Visitor[F]): F[A]
  }

  object MTurkOp {
    // Given a MTurkClient we can embed a MTurkIO program in any algebra that understands embedding.
    implicit val MTurkOpEmbeddable: Embeddable[MTurkOp, MTurkClient] = new Embeddable[MTurkOp, MTurkClient] {
      def embed[A](client: MTurkClient, io: MTurkIO[A]): Embedded[A] = Embedded.MTurk(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MTurkOp.Visitor[Kleisli[M, MTurkClient, *]] {
        def acceptQualificationRequest(
          request: AcceptQualificationRequestRequest
        ): Kleisli[M, MTurkClient, AcceptQualificationRequestResponse] =
          primitive(_.acceptQualificationRequest(request))

        def approveAssignment(
          request: ApproveAssignmentRequest
        ): Kleisli[M, MTurkClient, ApproveAssignmentResponse] =
          primitive(_.approveAssignment(request))

        def associateQualificationWithWorker(
          request: AssociateQualificationWithWorkerRequest
        ): Kleisli[M, MTurkClient, AssociateQualificationWithWorkerResponse] =
          primitive(_.associateQualificationWithWorker(request))

        def createAdditionalAssignmentsForHIT(
          request: CreateAdditionalAssignmentsForHitRequest
        ): Kleisli[M, MTurkClient, CreateAdditionalAssignmentsForHitResponse] =
          primitive(_.createAdditionalAssignmentsForHIT(request))

        def createHIT(
          request: CreateHitRequest
        ): Kleisli[M, MTurkClient, CreateHitResponse] =
          primitive(_.createHIT(request))

        def createHITType(
          request: CreateHitTypeRequest
        ): Kleisli[M, MTurkClient, CreateHitTypeResponse] =
          primitive(_.createHITType(request))

        def createHITWithHITType(
          request: CreateHitWithHitTypeRequest
        ): Kleisli[M, MTurkClient, CreateHitWithHitTypeResponse] =
          primitive(_.createHITWithHITType(request))

        def createQualificationType(
          request: CreateQualificationTypeRequest
        ): Kleisli[M, MTurkClient, CreateQualificationTypeResponse] =
          primitive(_.createQualificationType(request))

        def createWorkerBlock(
          request: CreateWorkerBlockRequest
        ): Kleisli[M, MTurkClient, CreateWorkerBlockResponse] =
          primitive(_.createWorkerBlock(request))

        def deleteHIT(
          request: DeleteHitRequest
        ): Kleisli[M, MTurkClient, DeleteHitResponse] =
          primitive(_.deleteHIT(request))

        def deleteQualificationType(
          request: DeleteQualificationTypeRequest
        ): Kleisli[M, MTurkClient, DeleteQualificationTypeResponse] =
          primitive(_.deleteQualificationType(request))

        def deleteWorkerBlock(
          request: DeleteWorkerBlockRequest
        ): Kleisli[M, MTurkClient, DeleteWorkerBlockResponse] =
          primitive(_.deleteWorkerBlock(request))

        def disassociateQualificationFromWorker(
          request: DisassociateQualificationFromWorkerRequest
        ): Kleisli[M, MTurkClient, DisassociateQualificationFromWorkerResponse] =
          primitive(_.disassociateQualificationFromWorker(request))

        def getAccountBalance(
          request: GetAccountBalanceRequest
        ): Kleisli[M, MTurkClient, GetAccountBalanceResponse] =
          primitive(_.getAccountBalance(request))

        def getAssignment(
          request: GetAssignmentRequest
        ): Kleisli[M, MTurkClient, GetAssignmentResponse] =
          primitive(_.getAssignment(request))

        def getFileUploadURL(
          request: GetFileUploadUrlRequest
        ): Kleisli[M, MTurkClient, GetFileUploadUrlResponse] =
          primitive(_.getFileUploadURL(request))

        def getHIT(
          request: GetHitRequest
        ): Kleisli[M, MTurkClient, GetHitResponse] =
          primitive(_.getHIT(request))

        def getQualificationScore(
          request: GetQualificationScoreRequest
        ): Kleisli[M, MTurkClient, GetQualificationScoreResponse] =
          primitive(_.getQualificationScore(request))

        def getQualificationType(
          request: GetQualificationTypeRequest
        ): Kleisli[M, MTurkClient, GetQualificationTypeResponse] =
          primitive(_.getQualificationType(request))

        def listAssignmentsForHIT(
          request: ListAssignmentsForHitRequest
        ): Kleisli[M, MTurkClient, ListAssignmentsForHitResponse] =
          primitive(_.listAssignmentsForHIT(request))

        def listBonusPayments(
          request: ListBonusPaymentsRequest
        ): Kleisli[M, MTurkClient, ListBonusPaymentsResponse] =
          primitive(_.listBonusPayments(request))

        def listHITs(
          request: ListHiTsRequest
        ): Kleisli[M, MTurkClient, ListHiTsResponse] =
          primitive(_.listHITs(request))

        def listHITsForQualificationType(
          request: ListHiTsForQualificationTypeRequest
        ): Kleisli[M, MTurkClient, ListHiTsForQualificationTypeResponse] =
          primitive(_.listHITsForQualificationType(request))

        def listQualificationRequests(
          request: ListQualificationRequestsRequest
        ): Kleisli[M, MTurkClient, ListQualificationRequestsResponse] =
          primitive(_.listQualificationRequests(request))

        def listQualificationTypes(
          request: ListQualificationTypesRequest
        ): Kleisli[M, MTurkClient, ListQualificationTypesResponse] =
          primitive(_.listQualificationTypes(request))

        def listReviewPolicyResultsForHIT(
          request: ListReviewPolicyResultsForHitRequest
        ): Kleisli[M, MTurkClient, ListReviewPolicyResultsForHitResponse] =
          primitive(_.listReviewPolicyResultsForHIT(request))

        def listReviewableHITs(
          request: ListReviewableHiTsRequest
        ): Kleisli[M, MTurkClient, ListReviewableHiTsResponse] =
          primitive(_.listReviewableHITs(request))

        def listWorkerBlocks(
          request: ListWorkerBlocksRequest
        ): Kleisli[M, MTurkClient, ListWorkerBlocksResponse] =
          primitive(_.listWorkerBlocks(request))

        def listWorkersWithQualificationType(
          request: ListWorkersWithQualificationTypeRequest
        ): Kleisli[M, MTurkClient, ListWorkersWithQualificationTypeResponse] =
          primitive(_.listWorkersWithQualificationType(request))

        def notifyWorkers(
          request: NotifyWorkersRequest
        ): Kleisli[M, MTurkClient, NotifyWorkersResponse] =
          primitive(_.notifyWorkers(request))

        def rejectAssignment(
          request: RejectAssignmentRequest
        ): Kleisli[M, MTurkClient, RejectAssignmentResponse] =
          primitive(_.rejectAssignment(request))

        def rejectQualificationRequest(
          request: RejectQualificationRequestRequest
        ): Kleisli[M, MTurkClient, RejectQualificationRequestResponse] =
          primitive(_.rejectQualificationRequest(request))

        def sendBonus(
          request: SendBonusRequest
        ): Kleisli[M, MTurkClient, SendBonusResponse] =
          primitive(_.sendBonus(request))

        def sendTestEventNotification(
          request: SendTestEventNotificationRequest
        ): Kleisli[M, MTurkClient, SendTestEventNotificationResponse] =
          primitive(_.sendTestEventNotification(request))

        def updateExpirationForHIT(
          request: UpdateExpirationForHitRequest
        ): Kleisli[M, MTurkClient, UpdateExpirationForHitResponse] =
          primitive(_.updateExpirationForHIT(request))

        def updateHITReviewStatus(
          request: UpdateHitReviewStatusRequest
        ): Kleisli[M, MTurkClient, UpdateHitReviewStatusResponse] =
          primitive(_.updateHITReviewStatus(request))

        def updateHITTypeOfHIT(
          request: UpdateHitTypeOfHitRequest
        ): Kleisli[M, MTurkClient, UpdateHitTypeOfHitResponse] =
          primitive(_.updateHITTypeOfHIT(request))

        def updateNotificationSettings(
          request: UpdateNotificationSettingsRequest
        ): Kleisli[M, MTurkClient, UpdateNotificationSettingsResponse] =
          primitive(_.updateNotificationSettings(request))

        def updateQualificationType(
          request: UpdateQualificationTypeRequest
        ): Kleisli[M, MTurkClient, UpdateQualificationTypeResponse] =
          primitive(_.updateQualificationType(request))

        def primitive[A](
          f: MTurkClient => A
        ): Kleisli[M, MTurkClient, A]
      }
    }

    trait Visitor[F[_]] extends (MTurkOp ~> F) {
      final def apply[A](op: MTurkOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptQualificationRequest(
        request: AcceptQualificationRequestRequest
      ): F[AcceptQualificationRequestResponse]

      def approveAssignment(
        request: ApproveAssignmentRequest
      ): F[ApproveAssignmentResponse]

      def associateQualificationWithWorker(
        request: AssociateQualificationWithWorkerRequest
      ): F[AssociateQualificationWithWorkerResponse]

      def createAdditionalAssignmentsForHIT(
        request: CreateAdditionalAssignmentsForHitRequest
      ): F[CreateAdditionalAssignmentsForHitResponse]

      def createHIT(
        request: CreateHitRequest
      ): F[CreateHitResponse]

      def createHITType(
        request: CreateHitTypeRequest
      ): F[CreateHitTypeResponse]

      def createHITWithHITType(
        request: CreateHitWithHitTypeRequest
      ): F[CreateHitWithHitTypeResponse]

      def createQualificationType(
        request: CreateQualificationTypeRequest
      ): F[CreateQualificationTypeResponse]

      def createWorkerBlock(
        request: CreateWorkerBlockRequest
      ): F[CreateWorkerBlockResponse]

      def deleteHIT(
        request: DeleteHitRequest
      ): F[DeleteHitResponse]

      def deleteQualificationType(
        request: DeleteQualificationTypeRequest
      ): F[DeleteQualificationTypeResponse]

      def deleteWorkerBlock(
        request: DeleteWorkerBlockRequest
      ): F[DeleteWorkerBlockResponse]

      def disassociateQualificationFromWorker(
        request: DisassociateQualificationFromWorkerRequest
      ): F[DisassociateQualificationFromWorkerResponse]

      def getAccountBalance(
        request: GetAccountBalanceRequest
      ): F[GetAccountBalanceResponse]

      def getAssignment(
        request: GetAssignmentRequest
      ): F[GetAssignmentResponse]

      def getFileUploadURL(
        request: GetFileUploadUrlRequest
      ): F[GetFileUploadUrlResponse]

      def getHIT(
        request: GetHitRequest
      ): F[GetHitResponse]

      def getQualificationScore(
        request: GetQualificationScoreRequest
      ): F[GetQualificationScoreResponse]

      def getQualificationType(
        request: GetQualificationTypeRequest
      ): F[GetQualificationTypeResponse]

      def listAssignmentsForHIT(
        request: ListAssignmentsForHitRequest
      ): F[ListAssignmentsForHitResponse]

      def listBonusPayments(
        request: ListBonusPaymentsRequest
      ): F[ListBonusPaymentsResponse]

      def listHITs(
        request: ListHiTsRequest
      ): F[ListHiTsResponse]

      def listHITsForQualificationType(
        request: ListHiTsForQualificationTypeRequest
      ): F[ListHiTsForQualificationTypeResponse]

      def listQualificationRequests(
        request: ListQualificationRequestsRequest
      ): F[ListQualificationRequestsResponse]

      def listQualificationTypes(
        request: ListQualificationTypesRequest
      ): F[ListQualificationTypesResponse]

      def listReviewPolicyResultsForHIT(
        request: ListReviewPolicyResultsForHitRequest
      ): F[ListReviewPolicyResultsForHitResponse]

      def listReviewableHITs(
        request: ListReviewableHiTsRequest
      ): F[ListReviewableHiTsResponse]

      def listWorkerBlocks(
        request: ListWorkerBlocksRequest
      ): F[ListWorkerBlocksResponse]

      def listWorkersWithQualificationType(
        request: ListWorkersWithQualificationTypeRequest
      ): F[ListWorkersWithQualificationTypeResponse]

      def notifyWorkers(
        request: NotifyWorkersRequest
      ): F[NotifyWorkersResponse]

      def rejectAssignment(
        request: RejectAssignmentRequest
      ): F[RejectAssignmentResponse]

      def rejectQualificationRequest(
        request: RejectQualificationRequestRequest
      ): F[RejectQualificationRequestResponse]

      def sendBonus(
        request: SendBonusRequest
      ): F[SendBonusResponse]

      def sendTestEventNotification(
        request: SendTestEventNotificationRequest
      ): F[SendTestEventNotificationResponse]

      def updateExpirationForHIT(
        request: UpdateExpirationForHitRequest
      ): F[UpdateExpirationForHitResponse]

      def updateHITReviewStatus(
        request: UpdateHitReviewStatusRequest
      ): F[UpdateHitReviewStatusResponse]

      def updateHITTypeOfHIT(
        request: UpdateHitTypeOfHitRequest
      ): F[UpdateHitTypeOfHitResponse]

      def updateNotificationSettings(
        request: UpdateNotificationSettingsRequest
      ): F[UpdateNotificationSettingsResponse]

      def updateQualificationType(
        request: UpdateQualificationTypeRequest
      ): F[UpdateQualificationTypeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MTurkOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptQualificationRequestOp(
      request: AcceptQualificationRequestRequest
    ) extends MTurkOp[AcceptQualificationRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptQualificationRequestResponse] =
        visitor.acceptQualificationRequest(request)
    }

    final case class ApproveAssignmentOp(
      request: ApproveAssignmentRequest
    ) extends MTurkOp[ApproveAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApproveAssignmentResponse] =
        visitor.approveAssignment(request)
    }

    final case class AssociateQualificationWithWorkerOp(
      request: AssociateQualificationWithWorkerRequest
    ) extends MTurkOp[AssociateQualificationWithWorkerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateQualificationWithWorkerResponse] =
        visitor.associateQualificationWithWorker(request)
    }

    final case class CreateAdditionalAssignmentsForHITOp(
      request: CreateAdditionalAssignmentsForHitRequest
    ) extends MTurkOp[CreateAdditionalAssignmentsForHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAdditionalAssignmentsForHitResponse] =
        visitor.createAdditionalAssignmentsForHIT(request)
    }

    final case class CreateHITOp(
      request: CreateHitRequest
    ) extends MTurkOp[CreateHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHitResponse] =
        visitor.createHIT(request)
    }

    final case class CreateHITTypeOp(
      request: CreateHitTypeRequest
    ) extends MTurkOp[CreateHitTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHitTypeResponse] =
        visitor.createHITType(request)
    }

    final case class CreateHITWithHITTypeOp(
      request: CreateHitWithHitTypeRequest
    ) extends MTurkOp[CreateHitWithHitTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHitWithHitTypeResponse] =
        visitor.createHITWithHITType(request)
    }

    final case class CreateQualificationTypeOp(
      request: CreateQualificationTypeRequest
    ) extends MTurkOp[CreateQualificationTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQualificationTypeResponse] =
        visitor.createQualificationType(request)
    }

    final case class CreateWorkerBlockOp(
      request: CreateWorkerBlockRequest
    ) extends MTurkOp[CreateWorkerBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkerBlockResponse] =
        visitor.createWorkerBlock(request)
    }

    final case class DeleteHITOp(
      request: DeleteHitRequest
    ) extends MTurkOp[DeleteHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHitResponse] =
        visitor.deleteHIT(request)
    }

    final case class DeleteQualificationTypeOp(
      request: DeleteQualificationTypeRequest
    ) extends MTurkOp[DeleteQualificationTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQualificationTypeResponse] =
        visitor.deleteQualificationType(request)
    }

    final case class DeleteWorkerBlockOp(
      request: DeleteWorkerBlockRequest
    ) extends MTurkOp[DeleteWorkerBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkerBlockResponse] =
        visitor.deleteWorkerBlock(request)
    }

    final case class DisassociateQualificationFromWorkerOp(
      request: DisassociateQualificationFromWorkerRequest
    ) extends MTurkOp[DisassociateQualificationFromWorkerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateQualificationFromWorkerResponse] =
        visitor.disassociateQualificationFromWorker(request)
    }

    final case class GetAccountBalanceOp(
      request: GetAccountBalanceRequest
    ) extends MTurkOp[GetAccountBalanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountBalanceResponse] =
        visitor.getAccountBalance(request)
    }

    final case class GetAssignmentOp(
      request: GetAssignmentRequest
    ) extends MTurkOp[GetAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssignmentResponse] =
        visitor.getAssignment(request)
    }

    final case class GetFileUploadURLOp(
      request: GetFileUploadUrlRequest
    ) extends MTurkOp[GetFileUploadUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFileUploadUrlResponse] =
        visitor.getFileUploadURL(request)
    }

    final case class GetHITOp(
      request: GetHitRequest
    ) extends MTurkOp[GetHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHitResponse] =
        visitor.getHIT(request)
    }

    final case class GetQualificationScoreOp(
      request: GetQualificationScoreRequest
    ) extends MTurkOp[GetQualificationScoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQualificationScoreResponse] =
        visitor.getQualificationScore(request)
    }

    final case class GetQualificationTypeOp(
      request: GetQualificationTypeRequest
    ) extends MTurkOp[GetQualificationTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQualificationTypeResponse] =
        visitor.getQualificationType(request)
    }

    final case class ListAssignmentsForHITOp(
      request: ListAssignmentsForHitRequest
    ) extends MTurkOp[ListAssignmentsForHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssignmentsForHitResponse] =
        visitor.listAssignmentsForHIT(request)
    }

    final case class ListBonusPaymentsOp(
      request: ListBonusPaymentsRequest
    ) extends MTurkOp[ListBonusPaymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBonusPaymentsResponse] =
        visitor.listBonusPayments(request)
    }

    final case class ListHITsOp(
      request: ListHiTsRequest
    ) extends MTurkOp[ListHiTsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHiTsResponse] =
        visitor.listHITs(request)
    }

    final case class ListHITsForQualificationTypeOp(
      request: ListHiTsForQualificationTypeRequest
    ) extends MTurkOp[ListHiTsForQualificationTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHiTsForQualificationTypeResponse] =
        visitor.listHITsForQualificationType(request)
    }

    final case class ListQualificationRequestsOp(
      request: ListQualificationRequestsRequest
    ) extends MTurkOp[ListQualificationRequestsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQualificationRequestsResponse] =
        visitor.listQualificationRequests(request)
    }

    final case class ListQualificationTypesOp(
      request: ListQualificationTypesRequest
    ) extends MTurkOp[ListQualificationTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQualificationTypesResponse] =
        visitor.listQualificationTypes(request)
    }

    final case class ListReviewPolicyResultsForHITOp(
      request: ListReviewPolicyResultsForHitRequest
    ) extends MTurkOp[ListReviewPolicyResultsForHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReviewPolicyResultsForHitResponse] =
        visitor.listReviewPolicyResultsForHIT(request)
    }

    final case class ListReviewableHITsOp(
      request: ListReviewableHiTsRequest
    ) extends MTurkOp[ListReviewableHiTsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReviewableHiTsResponse] =
        visitor.listReviewableHITs(request)
    }

    final case class ListWorkerBlocksOp(
      request: ListWorkerBlocksRequest
    ) extends MTurkOp[ListWorkerBlocksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkerBlocksResponse] =
        visitor.listWorkerBlocks(request)
    }

    final case class ListWorkersWithQualificationTypeOp(
      request: ListWorkersWithQualificationTypeRequest
    ) extends MTurkOp[ListWorkersWithQualificationTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorkersWithQualificationTypeResponse] =
        visitor.listWorkersWithQualificationType(request)
    }

    final case class NotifyWorkersOp(
      request: NotifyWorkersRequest
    ) extends MTurkOp[NotifyWorkersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[NotifyWorkersResponse] =
        visitor.notifyWorkers(request)
    }

    final case class RejectAssignmentOp(
      request: RejectAssignmentRequest
    ) extends MTurkOp[RejectAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectAssignmentResponse] =
        visitor.rejectAssignment(request)
    }

    final case class RejectQualificationRequestOp(
      request: RejectQualificationRequestRequest
    ) extends MTurkOp[RejectQualificationRequestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectQualificationRequestResponse] =
        visitor.rejectQualificationRequest(request)
    }

    final case class SendBonusOp(
      request: SendBonusRequest
    ) extends MTurkOp[SendBonusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendBonusResponse] =
        visitor.sendBonus(request)
    }

    final case class SendTestEventNotificationOp(
      request: SendTestEventNotificationRequest
    ) extends MTurkOp[SendTestEventNotificationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendTestEventNotificationResponse] =
        visitor.sendTestEventNotification(request)
    }

    final case class UpdateExpirationForHITOp(
      request: UpdateExpirationForHitRequest
    ) extends MTurkOp[UpdateExpirationForHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateExpirationForHitResponse] =
        visitor.updateExpirationForHIT(request)
    }

    final case class UpdateHITReviewStatusOp(
      request: UpdateHitReviewStatusRequest
    ) extends MTurkOp[UpdateHitReviewStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateHitReviewStatusResponse] =
        visitor.updateHITReviewStatus(request)
    }

    final case class UpdateHITTypeOfHITOp(
      request: UpdateHitTypeOfHitRequest
    ) extends MTurkOp[UpdateHitTypeOfHitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateHitTypeOfHitResponse] =
        visitor.updateHITTypeOfHIT(request)
    }

    final case class UpdateNotificationSettingsOp(
      request: UpdateNotificationSettingsRequest
    ) extends MTurkOp[UpdateNotificationSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNotificationSettingsResponse] =
        visitor.updateNotificationSettings(request)
    }

    final case class UpdateQualificationTypeOp(
      request: UpdateQualificationTypeRequest
    ) extends MTurkOp[UpdateQualificationTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQualificationTypeResponse] =
        visitor.updateQualificationType(request)
    }
  }

  import MTurkOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MTurkOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptQualificationRequest(
    request: AcceptQualificationRequestRequest
  ): MTurkIO[AcceptQualificationRequestResponse] =
    FF.liftF(AcceptQualificationRequestOp(request))

  def approveAssignment(
    request: ApproveAssignmentRequest
  ): MTurkIO[ApproveAssignmentResponse] =
    FF.liftF(ApproveAssignmentOp(request))

  def associateQualificationWithWorker(
    request: AssociateQualificationWithWorkerRequest
  ): MTurkIO[AssociateQualificationWithWorkerResponse] =
    FF.liftF(AssociateQualificationWithWorkerOp(request))

  def createAdditionalAssignmentsForHIT(
    request: CreateAdditionalAssignmentsForHitRequest
  ): MTurkIO[CreateAdditionalAssignmentsForHitResponse] =
    FF.liftF(CreateAdditionalAssignmentsForHITOp(request))

  def createHIT(
    request: CreateHitRequest
  ): MTurkIO[CreateHitResponse] =
    FF.liftF(CreateHITOp(request))

  def createHITType(
    request: CreateHitTypeRequest
  ): MTurkIO[CreateHitTypeResponse] =
    FF.liftF(CreateHITTypeOp(request))

  def createHITWithHITType(
    request: CreateHitWithHitTypeRequest
  ): MTurkIO[CreateHitWithHitTypeResponse] =
    FF.liftF(CreateHITWithHITTypeOp(request))

  def createQualificationType(
    request: CreateQualificationTypeRequest
  ): MTurkIO[CreateQualificationTypeResponse] =
    FF.liftF(CreateQualificationTypeOp(request))

  def createWorkerBlock(
    request: CreateWorkerBlockRequest
  ): MTurkIO[CreateWorkerBlockResponse] =
    FF.liftF(CreateWorkerBlockOp(request))

  def deleteHIT(
    request: DeleteHitRequest
  ): MTurkIO[DeleteHitResponse] =
    FF.liftF(DeleteHITOp(request))

  def deleteQualificationType(
    request: DeleteQualificationTypeRequest
  ): MTurkIO[DeleteQualificationTypeResponse] =
    FF.liftF(DeleteQualificationTypeOp(request))

  def deleteWorkerBlock(
    request: DeleteWorkerBlockRequest
  ): MTurkIO[DeleteWorkerBlockResponse] =
    FF.liftF(DeleteWorkerBlockOp(request))

  def disassociateQualificationFromWorker(
    request: DisassociateQualificationFromWorkerRequest
  ): MTurkIO[DisassociateQualificationFromWorkerResponse] =
    FF.liftF(DisassociateQualificationFromWorkerOp(request))

  def getAccountBalance(
    request: GetAccountBalanceRequest
  ): MTurkIO[GetAccountBalanceResponse] =
    FF.liftF(GetAccountBalanceOp(request))

  def getAssignment(
    request: GetAssignmentRequest
  ): MTurkIO[GetAssignmentResponse] =
    FF.liftF(GetAssignmentOp(request))

  def getFileUploadURL(
    request: GetFileUploadUrlRequest
  ): MTurkIO[GetFileUploadUrlResponse] =
    FF.liftF(GetFileUploadURLOp(request))

  def getHIT(
    request: GetHitRequest
  ): MTurkIO[GetHitResponse] =
    FF.liftF(GetHITOp(request))

  def getQualificationScore(
    request: GetQualificationScoreRequest
  ): MTurkIO[GetQualificationScoreResponse] =
    FF.liftF(GetQualificationScoreOp(request))

  def getQualificationType(
    request: GetQualificationTypeRequest
  ): MTurkIO[GetQualificationTypeResponse] =
    FF.liftF(GetQualificationTypeOp(request))

  def listAssignmentsForHIT(
    request: ListAssignmentsForHitRequest
  ): MTurkIO[ListAssignmentsForHitResponse] =
    FF.liftF(ListAssignmentsForHITOp(request))

  def listBonusPayments(
    request: ListBonusPaymentsRequest
  ): MTurkIO[ListBonusPaymentsResponse] =
    FF.liftF(ListBonusPaymentsOp(request))

  def listHITs(
    request: ListHiTsRequest
  ): MTurkIO[ListHiTsResponse] =
    FF.liftF(ListHITsOp(request))

  def listHITsForQualificationType(
    request: ListHiTsForQualificationTypeRequest
  ): MTurkIO[ListHiTsForQualificationTypeResponse] =
    FF.liftF(ListHITsForQualificationTypeOp(request))

  def listQualificationRequests(
    request: ListQualificationRequestsRequest
  ): MTurkIO[ListQualificationRequestsResponse] =
    FF.liftF(ListQualificationRequestsOp(request))

  def listQualificationTypes(
    request: ListQualificationTypesRequest
  ): MTurkIO[ListQualificationTypesResponse] =
    FF.liftF(ListQualificationTypesOp(request))

  def listReviewPolicyResultsForHIT(
    request: ListReviewPolicyResultsForHitRequest
  ): MTurkIO[ListReviewPolicyResultsForHitResponse] =
    FF.liftF(ListReviewPolicyResultsForHITOp(request))

  def listReviewableHITs(
    request: ListReviewableHiTsRequest
  ): MTurkIO[ListReviewableHiTsResponse] =
    FF.liftF(ListReviewableHITsOp(request))

  def listWorkerBlocks(
    request: ListWorkerBlocksRequest
  ): MTurkIO[ListWorkerBlocksResponse] =
    FF.liftF(ListWorkerBlocksOp(request))

  def listWorkersWithQualificationType(
    request: ListWorkersWithQualificationTypeRequest
  ): MTurkIO[ListWorkersWithQualificationTypeResponse] =
    FF.liftF(ListWorkersWithQualificationTypeOp(request))

  def notifyWorkers(
    request: NotifyWorkersRequest
  ): MTurkIO[NotifyWorkersResponse] =
    FF.liftF(NotifyWorkersOp(request))

  def rejectAssignment(
    request: RejectAssignmentRequest
  ): MTurkIO[RejectAssignmentResponse] =
    FF.liftF(RejectAssignmentOp(request))

  def rejectQualificationRequest(
    request: RejectQualificationRequestRequest
  ): MTurkIO[RejectQualificationRequestResponse] =
    FF.liftF(RejectQualificationRequestOp(request))

  def sendBonus(
    request: SendBonusRequest
  ): MTurkIO[SendBonusResponse] =
    FF.liftF(SendBonusOp(request))

  def sendTestEventNotification(
    request: SendTestEventNotificationRequest
  ): MTurkIO[SendTestEventNotificationResponse] =
    FF.liftF(SendTestEventNotificationOp(request))

  def updateExpirationForHIT(
    request: UpdateExpirationForHitRequest
  ): MTurkIO[UpdateExpirationForHitResponse] =
    FF.liftF(UpdateExpirationForHITOp(request))

  def updateHITReviewStatus(
    request: UpdateHitReviewStatusRequest
  ): MTurkIO[UpdateHitReviewStatusResponse] =
    FF.liftF(UpdateHITReviewStatusOp(request))

  def updateHITTypeOfHIT(
    request: UpdateHitTypeOfHitRequest
  ): MTurkIO[UpdateHitTypeOfHitResponse] =
    FF.liftF(UpdateHITTypeOfHITOp(request))

  def updateNotificationSettings(
    request: UpdateNotificationSettingsRequest
  ): MTurkIO[UpdateNotificationSettingsResponse] =
    FF.liftF(UpdateNotificationSettingsOp(request))

  def updateQualificationType(
    request: UpdateQualificationTypeRequest
  ): MTurkIO[UpdateQualificationTypeResponse] =
    FF.liftF(UpdateQualificationTypeOp(request))
}
