package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.fms.FmsClient
import software.amazon.awssdk.services.fms.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object fms { module =>

  // Free monad over FmsOp
  type FmsIO[A] = FF[FmsOp, A]

  sealed trait FmsOp[A] {
    def visit[F[_]](visitor: FmsOp.Visitor[F]): F[A]
  }

  object FmsOp {
    // Given a FmsClient we can embed a FmsIO program in any algebra that understands embedding.
    implicit val FmsOpEmbeddable: Embeddable[FmsOp, FmsClient] = new Embeddable[FmsOp, FmsClient] {
      def embed[A](client: FmsClient, io: FmsIO[A]): Embedded[A] = Embedded.Fms(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FmsOp.Visitor[Kleisli[M, FmsClient, *]] {
        def associateAdminAccount(
          request: AssociateAdminAccountRequest
        ): Kleisli[M, FmsClient, AssociateAdminAccountResponse] =
          primitive(_.associateAdminAccount(request))

        def deleteAppsList(
          request: DeleteAppsListRequest
        ): Kleisli[M, FmsClient, DeleteAppsListResponse] =
          primitive(_.deleteAppsList(request))

        def deleteNotificationChannel(
          request: DeleteNotificationChannelRequest
        ): Kleisli[M, FmsClient, DeleteNotificationChannelResponse] =
          primitive(_.deleteNotificationChannel(request))

        def deletePolicy(
          request: DeletePolicyRequest
        ): Kleisli[M, FmsClient, DeletePolicyResponse] =
          primitive(_.deletePolicy(request))

        def deleteProtocolsList(
          request: DeleteProtocolsListRequest
        ): Kleisli[M, FmsClient, DeleteProtocolsListResponse] =
          primitive(_.deleteProtocolsList(request))

        def disassociateAdminAccount(
          request: DisassociateAdminAccountRequest
        ): Kleisli[M, FmsClient, DisassociateAdminAccountResponse] =
          primitive(_.disassociateAdminAccount(request))

        def getAdminAccount(
          request: GetAdminAccountRequest
        ): Kleisli[M, FmsClient, GetAdminAccountResponse] =
          primitive(_.getAdminAccount(request))

        def getAppsList(
          request: GetAppsListRequest
        ): Kleisli[M, FmsClient, GetAppsListResponse] =
          primitive(_.getAppsList(request))

        def getComplianceDetail(
          request: GetComplianceDetailRequest
        ): Kleisli[M, FmsClient, GetComplianceDetailResponse] =
          primitive(_.getComplianceDetail(request))

        def getNotificationChannel(
          request: GetNotificationChannelRequest
        ): Kleisli[M, FmsClient, GetNotificationChannelResponse] =
          primitive(_.getNotificationChannel(request))

        def getPolicy(
          request: GetPolicyRequest
        ): Kleisli[M, FmsClient, GetPolicyResponse] =
          primitive(_.getPolicy(request))

        def getProtectionStatus(
          request: GetProtectionStatusRequest
        ): Kleisli[M, FmsClient, GetProtectionStatusResponse] =
          primitive(_.getProtectionStatus(request))

        def getProtocolsList(
          request: GetProtocolsListRequest
        ): Kleisli[M, FmsClient, GetProtocolsListResponse] =
          primitive(_.getProtocolsList(request))

        def getViolationDetails(
          request: GetViolationDetailsRequest
        ): Kleisli[M, FmsClient, GetViolationDetailsResponse] =
          primitive(_.getViolationDetails(request))

        def listAppsLists(
          request: ListAppsListsRequest
        ): Kleisli[M, FmsClient, ListAppsListsResponse] =
          primitive(_.listAppsLists(request))

        def listComplianceStatus(
          request: ListComplianceStatusRequest
        ): Kleisli[M, FmsClient, ListComplianceStatusResponse] =
          primitive(_.listComplianceStatus(request))

        def listMemberAccounts(
          request: ListMemberAccountsRequest
        ): Kleisli[M, FmsClient, ListMemberAccountsResponse] =
          primitive(_.listMemberAccounts(request))

        def listPolicies(
          request: ListPoliciesRequest
        ): Kleisli[M, FmsClient, ListPoliciesResponse] =
          primitive(_.listPolicies(request))

        def listProtocolsLists(
          request: ListProtocolsListsRequest
        ): Kleisli[M, FmsClient, ListProtocolsListsResponse] =
          primitive(_.listProtocolsLists(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, FmsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putAppsList(
          request: PutAppsListRequest
        ): Kleisli[M, FmsClient, PutAppsListResponse] =
          primitive(_.putAppsList(request))

        def putNotificationChannel(
          request: PutNotificationChannelRequest
        ): Kleisli[M, FmsClient, PutNotificationChannelResponse] =
          primitive(_.putNotificationChannel(request))

        def putPolicy(
          request: PutPolicyRequest
        ): Kleisli[M, FmsClient, PutPolicyResponse] =
          primitive(_.putPolicy(request))

        def putProtocolsList(
          request: PutProtocolsListRequest
        ): Kleisli[M, FmsClient, PutProtocolsListResponse] =
          primitive(_.putProtocolsList(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, FmsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, FmsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: FmsClient => A
        ): Kleisli[M, FmsClient, A]
      }
    }

    trait Visitor[F[_]] extends (FmsOp ~> F) {
      final def apply[A](op: FmsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateAdminAccount(
        request: AssociateAdminAccountRequest
      ): F[AssociateAdminAccountResponse]

      def deleteAppsList(
        request: DeleteAppsListRequest
      ): F[DeleteAppsListResponse]

      def deleteNotificationChannel(
        request: DeleteNotificationChannelRequest
      ): F[DeleteNotificationChannelResponse]

      def deletePolicy(
        request: DeletePolicyRequest
      ): F[DeletePolicyResponse]

      def deleteProtocolsList(
        request: DeleteProtocolsListRequest
      ): F[DeleteProtocolsListResponse]

      def disassociateAdminAccount(
        request: DisassociateAdminAccountRequest
      ): F[DisassociateAdminAccountResponse]

      def getAdminAccount(
        request: GetAdminAccountRequest
      ): F[GetAdminAccountResponse]

      def getAppsList(
        request: GetAppsListRequest
      ): F[GetAppsListResponse]

      def getComplianceDetail(
        request: GetComplianceDetailRequest
      ): F[GetComplianceDetailResponse]

      def getNotificationChannel(
        request: GetNotificationChannelRequest
      ): F[GetNotificationChannelResponse]

      def getPolicy(
        request: GetPolicyRequest
      ): F[GetPolicyResponse]

      def getProtectionStatus(
        request: GetProtectionStatusRequest
      ): F[GetProtectionStatusResponse]

      def getProtocolsList(
        request: GetProtocolsListRequest
      ): F[GetProtocolsListResponse]

      def getViolationDetails(
        request: GetViolationDetailsRequest
      ): F[GetViolationDetailsResponse]

      def listAppsLists(
        request: ListAppsListsRequest
      ): F[ListAppsListsResponse]

      def listComplianceStatus(
        request: ListComplianceStatusRequest
      ): F[ListComplianceStatusResponse]

      def listMemberAccounts(
        request: ListMemberAccountsRequest
      ): F[ListMemberAccountsResponse]

      def listPolicies(
        request: ListPoliciesRequest
      ): F[ListPoliciesResponse]

      def listProtocolsLists(
        request: ListProtocolsListsRequest
      ): F[ListProtocolsListsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putAppsList(
        request: PutAppsListRequest
      ): F[PutAppsListResponse]

      def putNotificationChannel(
        request: PutNotificationChannelRequest
      ): F[PutNotificationChannelResponse]

      def putPolicy(
        request: PutPolicyRequest
      ): F[PutPolicyResponse]

      def putProtocolsList(
        request: PutProtocolsListRequest
      ): F[PutProtocolsListResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends FmsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateAdminAccountOp(
      request: AssociateAdminAccountRequest
    ) extends FmsOp[AssociateAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateAdminAccountResponse] =
        visitor.associateAdminAccount(request)
    }

    final case class DeleteAppsListOp(
      request: DeleteAppsListRequest
    ) extends FmsOp[DeleteAppsListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppsListResponse] =
        visitor.deleteAppsList(request)
    }

    final case class DeleteNotificationChannelOp(
      request: DeleteNotificationChannelRequest
    ) extends FmsOp[DeleteNotificationChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotificationChannelResponse] =
        visitor.deleteNotificationChannel(request)
    }

    final case class DeletePolicyOp(
      request: DeletePolicyRequest
    ) extends FmsOp[DeletePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyResponse] =
        visitor.deletePolicy(request)
    }

    final case class DeleteProtocolsListOp(
      request: DeleteProtocolsListRequest
    ) extends FmsOp[DeleteProtocolsListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProtocolsListResponse] =
        visitor.deleteProtocolsList(request)
    }

    final case class DisassociateAdminAccountOp(
      request: DisassociateAdminAccountRequest
    ) extends FmsOp[DisassociateAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateAdminAccountResponse] =
        visitor.disassociateAdminAccount(request)
    }

    final case class GetAdminAccountOp(
      request: GetAdminAccountRequest
    ) extends FmsOp[GetAdminAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAdminAccountResponse] =
        visitor.getAdminAccount(request)
    }

    final case class GetAppsListOp(
      request: GetAppsListRequest
    ) extends FmsOp[GetAppsListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppsListResponse] =
        visitor.getAppsList(request)
    }

    final case class GetComplianceDetailOp(
      request: GetComplianceDetailRequest
    ) extends FmsOp[GetComplianceDetailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComplianceDetailResponse] =
        visitor.getComplianceDetail(request)
    }

    final case class GetNotificationChannelOp(
      request: GetNotificationChannelRequest
    ) extends FmsOp[GetNotificationChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNotificationChannelResponse] =
        visitor.getNotificationChannel(request)
    }

    final case class GetPolicyOp(
      request: GetPolicyRequest
    ) extends FmsOp[GetPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyResponse] =
        visitor.getPolicy(request)
    }

    final case class GetProtectionStatusOp(
      request: GetProtectionStatusRequest
    ) extends FmsOp[GetProtectionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProtectionStatusResponse] =
        visitor.getProtectionStatus(request)
    }

    final case class GetProtocolsListOp(
      request: GetProtocolsListRequest
    ) extends FmsOp[GetProtocolsListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProtocolsListResponse] =
        visitor.getProtocolsList(request)
    }

    final case class GetViolationDetailsOp(
      request: GetViolationDetailsRequest
    ) extends FmsOp[GetViolationDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetViolationDetailsResponse] =
        visitor.getViolationDetails(request)
    }

    final case class ListAppsListsOp(
      request: ListAppsListsRequest
    ) extends FmsOp[ListAppsListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppsListsResponse] =
        visitor.listAppsLists(request)
    }

    final case class ListComplianceStatusOp(
      request: ListComplianceStatusRequest
    ) extends FmsOp[ListComplianceStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComplianceStatusResponse] =
        visitor.listComplianceStatus(request)
    }

    final case class ListMemberAccountsOp(
      request: ListMemberAccountsRequest
    ) extends FmsOp[ListMemberAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMemberAccountsResponse] =
        visitor.listMemberAccounts(request)
    }

    final case class ListPoliciesOp(
      request: ListPoliciesRequest
    ) extends FmsOp[ListPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPoliciesResponse] =
        visitor.listPolicies(request)
    }

    final case class ListProtocolsListsOp(
      request: ListProtocolsListsRequest
    ) extends FmsOp[ListProtocolsListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProtocolsListsResponse] =
        visitor.listProtocolsLists(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends FmsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutAppsListOp(
      request: PutAppsListRequest
    ) extends FmsOp[PutAppsListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAppsListResponse] =
        visitor.putAppsList(request)
    }

    final case class PutNotificationChannelOp(
      request: PutNotificationChannelRequest
    ) extends FmsOp[PutNotificationChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutNotificationChannelResponse] =
        visitor.putNotificationChannel(request)
    }

    final case class PutPolicyOp(
      request: PutPolicyRequest
    ) extends FmsOp[PutPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPolicyResponse] =
        visitor.putPolicy(request)
    }

    final case class PutProtocolsListOp(
      request: PutProtocolsListRequest
    ) extends FmsOp[PutProtocolsListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutProtocolsListResponse] =
        visitor.putProtocolsList(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends FmsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends FmsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import FmsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FmsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateAdminAccount(
    request: AssociateAdminAccountRequest
  ): FmsIO[AssociateAdminAccountResponse] =
    FF.liftF(AssociateAdminAccountOp(request))

  def deleteAppsList(
    request: DeleteAppsListRequest
  ): FmsIO[DeleteAppsListResponse] =
    FF.liftF(DeleteAppsListOp(request))

  def deleteNotificationChannel(
    request: DeleteNotificationChannelRequest
  ): FmsIO[DeleteNotificationChannelResponse] =
    FF.liftF(DeleteNotificationChannelOp(request))

  def deletePolicy(
    request: DeletePolicyRequest
  ): FmsIO[DeletePolicyResponse] =
    FF.liftF(DeletePolicyOp(request))

  def deleteProtocolsList(
    request: DeleteProtocolsListRequest
  ): FmsIO[DeleteProtocolsListResponse] =
    FF.liftF(DeleteProtocolsListOp(request))

  def disassociateAdminAccount(
    request: DisassociateAdminAccountRequest
  ): FmsIO[DisassociateAdminAccountResponse] =
    FF.liftF(DisassociateAdminAccountOp(request))

  def getAdminAccount(
    request: GetAdminAccountRequest
  ): FmsIO[GetAdminAccountResponse] =
    FF.liftF(GetAdminAccountOp(request))

  def getAppsList(
    request: GetAppsListRequest
  ): FmsIO[GetAppsListResponse] =
    FF.liftF(GetAppsListOp(request))

  def getComplianceDetail(
    request: GetComplianceDetailRequest
  ): FmsIO[GetComplianceDetailResponse] =
    FF.liftF(GetComplianceDetailOp(request))

  def getNotificationChannel(
    request: GetNotificationChannelRequest
  ): FmsIO[GetNotificationChannelResponse] =
    FF.liftF(GetNotificationChannelOp(request))

  def getPolicy(
    request: GetPolicyRequest
  ): FmsIO[GetPolicyResponse] =
    FF.liftF(GetPolicyOp(request))

  def getProtectionStatus(
    request: GetProtectionStatusRequest
  ): FmsIO[GetProtectionStatusResponse] =
    FF.liftF(GetProtectionStatusOp(request))

  def getProtocolsList(
    request: GetProtocolsListRequest
  ): FmsIO[GetProtocolsListResponse] =
    FF.liftF(GetProtocolsListOp(request))

  def getViolationDetails(
    request: GetViolationDetailsRequest
  ): FmsIO[GetViolationDetailsResponse] =
    FF.liftF(GetViolationDetailsOp(request))

  def listAppsLists(
    request: ListAppsListsRequest
  ): FmsIO[ListAppsListsResponse] =
    FF.liftF(ListAppsListsOp(request))

  def listComplianceStatus(
    request: ListComplianceStatusRequest
  ): FmsIO[ListComplianceStatusResponse] =
    FF.liftF(ListComplianceStatusOp(request))

  def listMemberAccounts(
    request: ListMemberAccountsRequest
  ): FmsIO[ListMemberAccountsResponse] =
    FF.liftF(ListMemberAccountsOp(request))

  def listPolicies(
    request: ListPoliciesRequest
  ): FmsIO[ListPoliciesResponse] =
    FF.liftF(ListPoliciesOp(request))

  def listProtocolsLists(
    request: ListProtocolsListsRequest
  ): FmsIO[ListProtocolsListsResponse] =
    FF.liftF(ListProtocolsListsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): FmsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putAppsList(
    request: PutAppsListRequest
  ): FmsIO[PutAppsListResponse] =
    FF.liftF(PutAppsListOp(request))

  def putNotificationChannel(
    request: PutNotificationChannelRequest
  ): FmsIO[PutNotificationChannelResponse] =
    FF.liftF(PutNotificationChannelOp(request))

  def putPolicy(
    request: PutPolicyRequest
  ): FmsIO[PutPolicyResponse] =
    FF.liftF(PutPolicyOp(request))

  def putProtocolsList(
    request: PutProtocolsListRequest
  ): FmsIO[PutProtocolsListResponse] =
    FF.liftF(PutProtocolsListOp(request))

  def tagResource(
    request: TagResourceRequest
  ): FmsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): FmsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
