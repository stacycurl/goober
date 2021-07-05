package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.route53domains.Route53DomainsClient
import software.amazon.awssdk.services.route53domains.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object route53domains { module =>

  // Free monad over Route53DomainsOp
  type Route53DomainsIO[A] = FF[Route53DomainsOp, A]

  sealed trait Route53DomainsOp[A] {
    def visit[F[_]](visitor: Route53DomainsOp.Visitor[F]): F[A]
  }

  object Route53DomainsOp {
    // Given a Route53DomainsClient we can embed a Route53DomainsIO program in any algebra that understands embedding.
    implicit val Route53DomainsOpEmbeddable: Embeddable[Route53DomainsOp, Route53DomainsClient] = new Embeddable[Route53DomainsOp, Route53DomainsClient] {
      def embed[A](client: Route53DomainsClient, io: Route53DomainsIO[A]): Embedded[A] = Embedded.Route53Domains(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Route53DomainsOp.Visitor[Kleisli[M, Route53DomainsClient, *]] {
        def acceptDomainTransferFromAnotherAwsAccount(
          request: AcceptDomainTransferFromAnotherAwsAccountRequest
        ): Kleisli[M, Route53DomainsClient, AcceptDomainTransferFromAnotherAwsAccountResponse] =
          primitive(_.acceptDomainTransferFromAnotherAwsAccount(request))

        def cancelDomainTransferToAnotherAwsAccount(
          request: CancelDomainTransferToAnotherAwsAccountRequest
        ): Kleisli[M, Route53DomainsClient, CancelDomainTransferToAnotherAwsAccountResponse] =
          primitive(_.cancelDomainTransferToAnotherAwsAccount(request))

        def checkDomainAvailability(
          request: CheckDomainAvailabilityRequest
        ): Kleisli[M, Route53DomainsClient, CheckDomainAvailabilityResponse] =
          primitive(_.checkDomainAvailability(request))

        def checkDomainTransferability(
          request: CheckDomainTransferabilityRequest
        ): Kleisli[M, Route53DomainsClient, CheckDomainTransferabilityResponse] =
          primitive(_.checkDomainTransferability(request))

        def deleteTagsForDomain(
          request: DeleteTagsForDomainRequest
        ): Kleisli[M, Route53DomainsClient, DeleteTagsForDomainResponse] =
          primitive(_.deleteTagsForDomain(request))

        def disableDomainAutoRenew(
          request: DisableDomainAutoRenewRequest
        ): Kleisli[M, Route53DomainsClient, DisableDomainAutoRenewResponse] =
          primitive(_.disableDomainAutoRenew(request))

        def disableDomainTransferLock(
          request: DisableDomainTransferLockRequest
        ): Kleisli[M, Route53DomainsClient, DisableDomainTransferLockResponse] =
          primitive(_.disableDomainTransferLock(request))

        def enableDomainAutoRenew(
          request: EnableDomainAutoRenewRequest
        ): Kleisli[M, Route53DomainsClient, EnableDomainAutoRenewResponse] =
          primitive(_.enableDomainAutoRenew(request))

        def enableDomainTransferLock(
          request: EnableDomainTransferLockRequest
        ): Kleisli[M, Route53DomainsClient, EnableDomainTransferLockResponse] =
          primitive(_.enableDomainTransferLock(request))

        def getContactReachabilityStatus(
          request: GetContactReachabilityStatusRequest
        ): Kleisli[M, Route53DomainsClient, GetContactReachabilityStatusResponse] =
          primitive(_.getContactReachabilityStatus(request))

        def getDomainDetail(
          request: GetDomainDetailRequest
        ): Kleisli[M, Route53DomainsClient, GetDomainDetailResponse] =
          primitive(_.getDomainDetail(request))

        def getDomainSuggestions(
          request: GetDomainSuggestionsRequest
        ): Kleisli[M, Route53DomainsClient, GetDomainSuggestionsResponse] =
          primitive(_.getDomainSuggestions(request))

        def getOperationDetail(
          request: GetOperationDetailRequest
        ): Kleisli[M, Route53DomainsClient, GetOperationDetailResponse] =
          primitive(_.getOperationDetail(request))

        def listDomains(
          request: ListDomainsRequest
        ): Kleisli[M, Route53DomainsClient, ListDomainsResponse] =
          primitive(_.listDomains(request))

        def listOperations(
          request: ListOperationsRequest
        ): Kleisli[M, Route53DomainsClient, ListOperationsResponse] =
          primitive(_.listOperations(request))

        def listTagsForDomain(
          request: ListTagsForDomainRequest
        ): Kleisli[M, Route53DomainsClient, ListTagsForDomainResponse] =
          primitive(_.listTagsForDomain(request))

        def registerDomain(
          request: RegisterDomainRequest
        ): Kleisli[M, Route53DomainsClient, RegisterDomainResponse] =
          primitive(_.registerDomain(request))

        def rejectDomainTransferFromAnotherAwsAccount(
          request: RejectDomainTransferFromAnotherAwsAccountRequest
        ): Kleisli[M, Route53DomainsClient, RejectDomainTransferFromAnotherAwsAccountResponse] =
          primitive(_.rejectDomainTransferFromAnotherAwsAccount(request))

        def renewDomain(
          request: RenewDomainRequest
        ): Kleisli[M, Route53DomainsClient, RenewDomainResponse] =
          primitive(_.renewDomain(request))

        def resendContactReachabilityEmail(
          request: ResendContactReachabilityEmailRequest
        ): Kleisli[M, Route53DomainsClient, ResendContactReachabilityEmailResponse] =
          primitive(_.resendContactReachabilityEmail(request))

        def retrieveDomainAuthCode(
          request: RetrieveDomainAuthCodeRequest
        ): Kleisli[M, Route53DomainsClient, RetrieveDomainAuthCodeResponse] =
          primitive(_.retrieveDomainAuthCode(request))

        def transferDomain(
          request: TransferDomainRequest
        ): Kleisli[M, Route53DomainsClient, TransferDomainResponse] =
          primitive(_.transferDomain(request))

        def transferDomainToAnotherAwsAccount(
          request: TransferDomainToAnotherAwsAccountRequest
        ): Kleisli[M, Route53DomainsClient, TransferDomainToAnotherAwsAccountResponse] =
          primitive(_.transferDomainToAnotherAwsAccount(request))

        def updateDomainContact(
          request: UpdateDomainContactRequest
        ): Kleisli[M, Route53DomainsClient, UpdateDomainContactResponse] =
          primitive(_.updateDomainContact(request))

        def updateDomainContactPrivacy(
          request: UpdateDomainContactPrivacyRequest
        ): Kleisli[M, Route53DomainsClient, UpdateDomainContactPrivacyResponse] =
          primitive(_.updateDomainContactPrivacy(request))

        def updateDomainNameservers(
          request: UpdateDomainNameserversRequest
        ): Kleisli[M, Route53DomainsClient, UpdateDomainNameserversResponse] =
          primitive(_.updateDomainNameservers(request))

        def updateTagsForDomain(
          request: UpdateTagsForDomainRequest
        ): Kleisli[M, Route53DomainsClient, UpdateTagsForDomainResponse] =
          primitive(_.updateTagsForDomain(request))

        def viewBilling(
          request: ViewBillingRequest
        ): Kleisli[M, Route53DomainsClient, ViewBillingResponse] =
          primitive(_.viewBilling(request))

        def primitive[A](
          f: Route53DomainsClient => A
        ): Kleisli[M, Route53DomainsClient, A]
      }
    }

    trait Visitor[F[_]] extends (Route53DomainsOp ~> F) {
      final def apply[A](op: Route53DomainsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptDomainTransferFromAnotherAwsAccount(
        request: AcceptDomainTransferFromAnotherAwsAccountRequest
      ): F[AcceptDomainTransferFromAnotherAwsAccountResponse]

      def cancelDomainTransferToAnotherAwsAccount(
        request: CancelDomainTransferToAnotherAwsAccountRequest
      ): F[CancelDomainTransferToAnotherAwsAccountResponse]

      def checkDomainAvailability(
        request: CheckDomainAvailabilityRequest
      ): F[CheckDomainAvailabilityResponse]

      def checkDomainTransferability(
        request: CheckDomainTransferabilityRequest
      ): F[CheckDomainTransferabilityResponse]

      def deleteTagsForDomain(
        request: DeleteTagsForDomainRequest
      ): F[DeleteTagsForDomainResponse]

      def disableDomainAutoRenew(
        request: DisableDomainAutoRenewRequest
      ): F[DisableDomainAutoRenewResponse]

      def disableDomainTransferLock(
        request: DisableDomainTransferLockRequest
      ): F[DisableDomainTransferLockResponse]

      def enableDomainAutoRenew(
        request: EnableDomainAutoRenewRequest
      ): F[EnableDomainAutoRenewResponse]

      def enableDomainTransferLock(
        request: EnableDomainTransferLockRequest
      ): F[EnableDomainTransferLockResponse]

      def getContactReachabilityStatus(
        request: GetContactReachabilityStatusRequest
      ): F[GetContactReachabilityStatusResponse]

      def getDomainDetail(
        request: GetDomainDetailRequest
      ): F[GetDomainDetailResponse]

      def getDomainSuggestions(
        request: GetDomainSuggestionsRequest
      ): F[GetDomainSuggestionsResponse]

      def getOperationDetail(
        request: GetOperationDetailRequest
      ): F[GetOperationDetailResponse]

      def listDomains(
        request: ListDomainsRequest
      ): F[ListDomainsResponse]

      def listOperations(
        request: ListOperationsRequest
      ): F[ListOperationsResponse]

      def listTagsForDomain(
        request: ListTagsForDomainRequest
      ): F[ListTagsForDomainResponse]

      def registerDomain(
        request: RegisterDomainRequest
      ): F[RegisterDomainResponse]

      def rejectDomainTransferFromAnotherAwsAccount(
        request: RejectDomainTransferFromAnotherAwsAccountRequest
      ): F[RejectDomainTransferFromAnotherAwsAccountResponse]

      def renewDomain(
        request: RenewDomainRequest
      ): F[RenewDomainResponse]

      def resendContactReachabilityEmail(
        request: ResendContactReachabilityEmailRequest
      ): F[ResendContactReachabilityEmailResponse]

      def retrieveDomainAuthCode(
        request: RetrieveDomainAuthCodeRequest
      ): F[RetrieveDomainAuthCodeResponse]

      def transferDomain(
        request: TransferDomainRequest
      ): F[TransferDomainResponse]

      def transferDomainToAnotherAwsAccount(
        request: TransferDomainToAnotherAwsAccountRequest
      ): F[TransferDomainToAnotherAwsAccountResponse]

      def updateDomainContact(
        request: UpdateDomainContactRequest
      ): F[UpdateDomainContactResponse]

      def updateDomainContactPrivacy(
        request: UpdateDomainContactPrivacyRequest
      ): F[UpdateDomainContactPrivacyResponse]

      def updateDomainNameservers(
        request: UpdateDomainNameserversRequest
      ): F[UpdateDomainNameserversResponse]

      def updateTagsForDomain(
        request: UpdateTagsForDomainRequest
      ): F[UpdateTagsForDomainResponse]

      def viewBilling(
        request: ViewBillingRequest
      ): F[ViewBillingResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Route53DomainsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptDomainTransferFromAnotherAwsAccountOp(
      request: AcceptDomainTransferFromAnotherAwsAccountRequest
    ) extends Route53DomainsOp[AcceptDomainTransferFromAnotherAwsAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptDomainTransferFromAnotherAwsAccountResponse] =
        visitor.acceptDomainTransferFromAnotherAwsAccount(request)
    }

    final case class CancelDomainTransferToAnotherAwsAccountOp(
      request: CancelDomainTransferToAnotherAwsAccountRequest
    ) extends Route53DomainsOp[CancelDomainTransferToAnotherAwsAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelDomainTransferToAnotherAwsAccountResponse] =
        visitor.cancelDomainTransferToAnotherAwsAccount(request)
    }

    final case class CheckDomainAvailabilityOp(
      request: CheckDomainAvailabilityRequest
    ) extends Route53DomainsOp[CheckDomainAvailabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckDomainAvailabilityResponse] =
        visitor.checkDomainAvailability(request)
    }

    final case class CheckDomainTransferabilityOp(
      request: CheckDomainTransferabilityRequest
    ) extends Route53DomainsOp[CheckDomainTransferabilityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CheckDomainTransferabilityResponse] =
        visitor.checkDomainTransferability(request)
    }

    final case class DeleteTagsForDomainOp(
      request: DeleteTagsForDomainRequest
    ) extends Route53DomainsOp[DeleteTagsForDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsForDomainResponse] =
        visitor.deleteTagsForDomain(request)
    }

    final case class DisableDomainAutoRenewOp(
      request: DisableDomainAutoRenewRequest
    ) extends Route53DomainsOp[DisableDomainAutoRenewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableDomainAutoRenewResponse] =
        visitor.disableDomainAutoRenew(request)
    }

    final case class DisableDomainTransferLockOp(
      request: DisableDomainTransferLockRequest
    ) extends Route53DomainsOp[DisableDomainTransferLockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableDomainTransferLockResponse] =
        visitor.disableDomainTransferLock(request)
    }

    final case class EnableDomainAutoRenewOp(
      request: EnableDomainAutoRenewRequest
    ) extends Route53DomainsOp[EnableDomainAutoRenewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableDomainAutoRenewResponse] =
        visitor.enableDomainAutoRenew(request)
    }

    final case class EnableDomainTransferLockOp(
      request: EnableDomainTransferLockRequest
    ) extends Route53DomainsOp[EnableDomainTransferLockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableDomainTransferLockResponse] =
        visitor.enableDomainTransferLock(request)
    }

    final case class GetContactReachabilityStatusOp(
      request: GetContactReachabilityStatusRequest
    ) extends Route53DomainsOp[GetContactReachabilityStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactReachabilityStatusResponse] =
        visitor.getContactReachabilityStatus(request)
    }

    final case class GetDomainDetailOp(
      request: GetDomainDetailRequest
    ) extends Route53DomainsOp[GetDomainDetailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainDetailResponse] =
        visitor.getDomainDetail(request)
    }

    final case class GetDomainSuggestionsOp(
      request: GetDomainSuggestionsRequest
    ) extends Route53DomainsOp[GetDomainSuggestionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainSuggestionsResponse] =
        visitor.getDomainSuggestions(request)
    }

    final case class GetOperationDetailOp(
      request: GetOperationDetailRequest
    ) extends Route53DomainsOp[GetOperationDetailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOperationDetailResponse] =
        visitor.getOperationDetail(request)
    }

    final case class ListDomainsOp(
      request: ListDomainsRequest
    ) extends Route53DomainsOp[ListDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainsResponse] =
        visitor.listDomains(request)
    }

    final case class ListOperationsOp(
      request: ListOperationsRequest
    ) extends Route53DomainsOp[ListOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOperationsResponse] =
        visitor.listOperations(request)
    }

    final case class ListTagsForDomainOp(
      request: ListTagsForDomainRequest
    ) extends Route53DomainsOp[ListTagsForDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForDomainResponse] =
        visitor.listTagsForDomain(request)
    }

    final case class RegisterDomainOp(
      request: RegisterDomainRequest
    ) extends Route53DomainsOp[RegisterDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDomainResponse] =
        visitor.registerDomain(request)
    }

    final case class RejectDomainTransferFromAnotherAwsAccountOp(
      request: RejectDomainTransferFromAnotherAwsAccountRequest
    ) extends Route53DomainsOp[RejectDomainTransferFromAnotherAwsAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectDomainTransferFromAnotherAwsAccountResponse] =
        visitor.rejectDomainTransferFromAnotherAwsAccount(request)
    }

    final case class RenewDomainOp(
      request: RenewDomainRequest
    ) extends Route53DomainsOp[RenewDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RenewDomainResponse] =
        visitor.renewDomain(request)
    }

    final case class ResendContactReachabilityEmailOp(
      request: ResendContactReachabilityEmailRequest
    ) extends Route53DomainsOp[ResendContactReachabilityEmailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResendContactReachabilityEmailResponse] =
        visitor.resendContactReachabilityEmail(request)
    }

    final case class RetrieveDomainAuthCodeOp(
      request: RetrieveDomainAuthCodeRequest
    ) extends Route53DomainsOp[RetrieveDomainAuthCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetrieveDomainAuthCodeResponse] =
        visitor.retrieveDomainAuthCode(request)
    }

    final case class TransferDomainOp(
      request: TransferDomainRequest
    ) extends Route53DomainsOp[TransferDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TransferDomainResponse] =
        visitor.transferDomain(request)
    }

    final case class TransferDomainToAnotherAwsAccountOp(
      request: TransferDomainToAnotherAwsAccountRequest
    ) extends Route53DomainsOp[TransferDomainToAnotherAwsAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TransferDomainToAnotherAwsAccountResponse] =
        visitor.transferDomainToAnotherAwsAccount(request)
    }

    final case class UpdateDomainContactOp(
      request: UpdateDomainContactRequest
    ) extends Route53DomainsOp[UpdateDomainContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainContactResponse] =
        visitor.updateDomainContact(request)
    }

    final case class UpdateDomainContactPrivacyOp(
      request: UpdateDomainContactPrivacyRequest
    ) extends Route53DomainsOp[UpdateDomainContactPrivacyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainContactPrivacyResponse] =
        visitor.updateDomainContactPrivacy(request)
    }

    final case class UpdateDomainNameserversOp(
      request: UpdateDomainNameserversRequest
    ) extends Route53DomainsOp[UpdateDomainNameserversResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainNameserversResponse] =
        visitor.updateDomainNameservers(request)
    }

    final case class UpdateTagsForDomainOp(
      request: UpdateTagsForDomainRequest
    ) extends Route53DomainsOp[UpdateTagsForDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTagsForDomainResponse] =
        visitor.updateTagsForDomain(request)
    }

    final case class ViewBillingOp(
      request: ViewBillingRequest
    ) extends Route53DomainsOp[ViewBillingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ViewBillingResponse] =
        visitor.viewBilling(request)
    }
  }

  import Route53DomainsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Route53DomainsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptDomainTransferFromAnotherAwsAccount(
    request: AcceptDomainTransferFromAnotherAwsAccountRequest
  ): Route53DomainsIO[AcceptDomainTransferFromAnotherAwsAccountResponse] =
    FF.liftF(AcceptDomainTransferFromAnotherAwsAccountOp(request))

  def cancelDomainTransferToAnotherAwsAccount(
    request: CancelDomainTransferToAnotherAwsAccountRequest
  ): Route53DomainsIO[CancelDomainTransferToAnotherAwsAccountResponse] =
    FF.liftF(CancelDomainTransferToAnotherAwsAccountOp(request))

  def checkDomainAvailability(
    request: CheckDomainAvailabilityRequest
  ): Route53DomainsIO[CheckDomainAvailabilityResponse] =
    FF.liftF(CheckDomainAvailabilityOp(request))

  def checkDomainTransferability(
    request: CheckDomainTransferabilityRequest
  ): Route53DomainsIO[CheckDomainTransferabilityResponse] =
    FF.liftF(CheckDomainTransferabilityOp(request))

  def deleteTagsForDomain(
    request: DeleteTagsForDomainRequest
  ): Route53DomainsIO[DeleteTagsForDomainResponse] =
    FF.liftF(DeleteTagsForDomainOp(request))

  def disableDomainAutoRenew(
    request: DisableDomainAutoRenewRequest
  ): Route53DomainsIO[DisableDomainAutoRenewResponse] =
    FF.liftF(DisableDomainAutoRenewOp(request))

  def disableDomainTransferLock(
    request: DisableDomainTransferLockRequest
  ): Route53DomainsIO[DisableDomainTransferLockResponse] =
    FF.liftF(DisableDomainTransferLockOp(request))

  def enableDomainAutoRenew(
    request: EnableDomainAutoRenewRequest
  ): Route53DomainsIO[EnableDomainAutoRenewResponse] =
    FF.liftF(EnableDomainAutoRenewOp(request))

  def enableDomainTransferLock(
    request: EnableDomainTransferLockRequest
  ): Route53DomainsIO[EnableDomainTransferLockResponse] =
    FF.liftF(EnableDomainTransferLockOp(request))

  def getContactReachabilityStatus(
    request: GetContactReachabilityStatusRequest
  ): Route53DomainsIO[GetContactReachabilityStatusResponse] =
    FF.liftF(GetContactReachabilityStatusOp(request))

  def getDomainDetail(
    request: GetDomainDetailRequest
  ): Route53DomainsIO[GetDomainDetailResponse] =
    FF.liftF(GetDomainDetailOp(request))

  def getDomainSuggestions(
    request: GetDomainSuggestionsRequest
  ): Route53DomainsIO[GetDomainSuggestionsResponse] =
    FF.liftF(GetDomainSuggestionsOp(request))

  def getOperationDetail(
    request: GetOperationDetailRequest
  ): Route53DomainsIO[GetOperationDetailResponse] =
    FF.liftF(GetOperationDetailOp(request))

  def listDomains(
    request: ListDomainsRequest
  ): Route53DomainsIO[ListDomainsResponse] =
    FF.liftF(ListDomainsOp(request))

  def listOperations(
    request: ListOperationsRequest
  ): Route53DomainsIO[ListOperationsResponse] =
    FF.liftF(ListOperationsOp(request))

  def listTagsForDomain(
    request: ListTagsForDomainRequest
  ): Route53DomainsIO[ListTagsForDomainResponse] =
    FF.liftF(ListTagsForDomainOp(request))

  def registerDomain(
    request: RegisterDomainRequest
  ): Route53DomainsIO[RegisterDomainResponse] =
    FF.liftF(RegisterDomainOp(request))

  def rejectDomainTransferFromAnotherAwsAccount(
    request: RejectDomainTransferFromAnotherAwsAccountRequest
  ): Route53DomainsIO[RejectDomainTransferFromAnotherAwsAccountResponse] =
    FF.liftF(RejectDomainTransferFromAnotherAwsAccountOp(request))

  def renewDomain(
    request: RenewDomainRequest
  ): Route53DomainsIO[RenewDomainResponse] =
    FF.liftF(RenewDomainOp(request))

  def resendContactReachabilityEmail(
    request: ResendContactReachabilityEmailRequest
  ): Route53DomainsIO[ResendContactReachabilityEmailResponse] =
    FF.liftF(ResendContactReachabilityEmailOp(request))

  def retrieveDomainAuthCode(
    request: RetrieveDomainAuthCodeRequest
  ): Route53DomainsIO[RetrieveDomainAuthCodeResponse] =
    FF.liftF(RetrieveDomainAuthCodeOp(request))

  def transferDomain(
    request: TransferDomainRequest
  ): Route53DomainsIO[TransferDomainResponse] =
    FF.liftF(TransferDomainOp(request))

  def transferDomainToAnotherAwsAccount(
    request: TransferDomainToAnotherAwsAccountRequest
  ): Route53DomainsIO[TransferDomainToAnotherAwsAccountResponse] =
    FF.liftF(TransferDomainToAnotherAwsAccountOp(request))

  def updateDomainContact(
    request: UpdateDomainContactRequest
  ): Route53DomainsIO[UpdateDomainContactResponse] =
    FF.liftF(UpdateDomainContactOp(request))

  def updateDomainContactPrivacy(
    request: UpdateDomainContactPrivacyRequest
  ): Route53DomainsIO[UpdateDomainContactPrivacyResponse] =
    FF.liftF(UpdateDomainContactPrivacyOp(request))

  def updateDomainNameservers(
    request: UpdateDomainNameserversRequest
  ): Route53DomainsIO[UpdateDomainNameserversResponse] =
    FF.liftF(UpdateDomainNameserversOp(request))

  def updateTagsForDomain(
    request: UpdateTagsForDomainRequest
  ): Route53DomainsIO[UpdateTagsForDomainResponse] =
    FF.liftF(UpdateTagsForDomainOp(request))

  def viewBilling(
    request: ViewBillingRequest
  ): Route53DomainsIO[ViewBillingResponse] =
    FF.liftF(ViewBillingOp(request))
}
