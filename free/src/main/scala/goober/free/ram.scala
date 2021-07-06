package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ram.RamClient
import software.amazon.awssdk.services.ram.model._


object ram { module =>

  // Free monad over RamOp
  type RamIO[A] = FF[RamOp, A]

  sealed trait RamOp[A] {
    def visit[F[_]](visitor: RamOp.Visitor[F]): F[A]
  }

  object RamOp {
    // Given a RamClient we can embed a RamIO program in any algebra that understands embedding.
    implicit val RamOpEmbeddable: Embeddable[RamOp, RamClient] = new Embeddable[RamOp, RamClient] {
      def embed[A](client: RamClient, io: RamIO[A]): Embedded[A] = Embedded.Ram(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RamOp.Visitor[Kleisli[M, RamClient, *]] {
        def acceptResourceShareInvitation(
          request: AcceptResourceShareInvitationRequest
        ): Kleisli[M, RamClient, AcceptResourceShareInvitationResponse] =
          primitive(_.acceptResourceShareInvitation(request))

        def associateResourceShare(
          request: AssociateResourceShareRequest
        ): Kleisli[M, RamClient, AssociateResourceShareResponse] =
          primitive(_.associateResourceShare(request))

        def associateResourceSharePermission(
          request: AssociateResourceSharePermissionRequest
        ): Kleisli[M, RamClient, AssociateResourceSharePermissionResponse] =
          primitive(_.associateResourceSharePermission(request))

        def createResourceShare(
          request: CreateResourceShareRequest
        ): Kleisli[M, RamClient, CreateResourceShareResponse] =
          primitive(_.createResourceShare(request))

        def deleteResourceShare(
          request: DeleteResourceShareRequest
        ): Kleisli[M, RamClient, DeleteResourceShareResponse] =
          primitive(_.deleteResourceShare(request))

        def disassociateResourceShare(
          request: DisassociateResourceShareRequest
        ): Kleisli[M, RamClient, DisassociateResourceShareResponse] =
          primitive(_.disassociateResourceShare(request))

        def disassociateResourceSharePermission(
          request: DisassociateResourceSharePermissionRequest
        ): Kleisli[M, RamClient, DisassociateResourceSharePermissionResponse] =
          primitive(_.disassociateResourceSharePermission(request))

        def enableSharingWithAwsOrganization(
          request: EnableSharingWithAwsOrganizationRequest
        ): Kleisli[M, RamClient, EnableSharingWithAwsOrganizationResponse] =
          primitive(_.enableSharingWithAwsOrganization(request))

        def getPermission(
          request: GetPermissionRequest
        ): Kleisli[M, RamClient, GetPermissionResponse] =
          primitive(_.getPermission(request))

        def getResourcePolicies(
          request: GetResourcePoliciesRequest
        ): Kleisli[M, RamClient, GetResourcePoliciesResponse] =
          primitive(_.getResourcePolicies(request))

        def getResourceShareAssociations(
          request: GetResourceShareAssociationsRequest
        ): Kleisli[M, RamClient, GetResourceShareAssociationsResponse] =
          primitive(_.getResourceShareAssociations(request))

        def getResourceShareInvitations(
          request: GetResourceShareInvitationsRequest
        ): Kleisli[M, RamClient, GetResourceShareInvitationsResponse] =
          primitive(_.getResourceShareInvitations(request))

        def getResourceShares(
          request: GetResourceSharesRequest
        ): Kleisli[M, RamClient, GetResourceSharesResponse] =
          primitive(_.getResourceShares(request))

        def listPendingInvitationResources(
          request: ListPendingInvitationResourcesRequest
        ): Kleisli[M, RamClient, ListPendingInvitationResourcesResponse] =
          primitive(_.listPendingInvitationResources(request))

        def listPermissions(
          request: ListPermissionsRequest
        ): Kleisli[M, RamClient, ListPermissionsResponse] =
          primitive(_.listPermissions(request))

        def listPrincipals(
          request: ListPrincipalsRequest
        ): Kleisli[M, RamClient, ListPrincipalsResponse] =
          primitive(_.listPrincipals(request))

        def listResourceSharePermissions(
          request: ListResourceSharePermissionsRequest
        ): Kleisli[M, RamClient, ListResourceSharePermissionsResponse] =
          primitive(_.listResourceSharePermissions(request))

        def listResourceTypes(
          request: ListResourceTypesRequest
        ): Kleisli[M, RamClient, ListResourceTypesResponse] =
          primitive(_.listResourceTypes(request))

        def listResources(
          request: ListResourcesRequest
        ): Kleisli[M, RamClient, ListResourcesResponse] =
          primitive(_.listResources(request))

        def promoteResourceShareCreatedFromPolicy(
          request: PromoteResourceShareCreatedFromPolicyRequest
        ): Kleisli[M, RamClient, PromoteResourceShareCreatedFromPolicyResponse] =
          primitive(_.promoteResourceShareCreatedFromPolicy(request))

        def rejectResourceShareInvitation(
          request: RejectResourceShareInvitationRequest
        ): Kleisli[M, RamClient, RejectResourceShareInvitationResponse] =
          primitive(_.rejectResourceShareInvitation(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, RamClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, RamClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateResourceShare(
          request: UpdateResourceShareRequest
        ): Kleisli[M, RamClient, UpdateResourceShareResponse] =
          primitive(_.updateResourceShare(request))

        def primitive[A](
          f: RamClient => A
        ): Kleisli[M, RamClient, A]
      }
    }

    trait Visitor[F[_]] extends (RamOp ~> F) {
      final def apply[A](op: RamOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptResourceShareInvitation(
        request: AcceptResourceShareInvitationRequest
      ): F[AcceptResourceShareInvitationResponse]

      def associateResourceShare(
        request: AssociateResourceShareRequest
      ): F[AssociateResourceShareResponse]

      def associateResourceSharePermission(
        request: AssociateResourceSharePermissionRequest
      ): F[AssociateResourceSharePermissionResponse]

      def createResourceShare(
        request: CreateResourceShareRequest
      ): F[CreateResourceShareResponse]

      def deleteResourceShare(
        request: DeleteResourceShareRequest
      ): F[DeleteResourceShareResponse]

      def disassociateResourceShare(
        request: DisassociateResourceShareRequest
      ): F[DisassociateResourceShareResponse]

      def disassociateResourceSharePermission(
        request: DisassociateResourceSharePermissionRequest
      ): F[DisassociateResourceSharePermissionResponse]

      def enableSharingWithAwsOrganization(
        request: EnableSharingWithAwsOrganizationRequest
      ): F[EnableSharingWithAwsOrganizationResponse]

      def getPermission(
        request: GetPermissionRequest
      ): F[GetPermissionResponse]

      def getResourcePolicies(
        request: GetResourcePoliciesRequest
      ): F[GetResourcePoliciesResponse]

      def getResourceShareAssociations(
        request: GetResourceShareAssociationsRequest
      ): F[GetResourceShareAssociationsResponse]

      def getResourceShareInvitations(
        request: GetResourceShareInvitationsRequest
      ): F[GetResourceShareInvitationsResponse]

      def getResourceShares(
        request: GetResourceSharesRequest
      ): F[GetResourceSharesResponse]

      def listPendingInvitationResources(
        request: ListPendingInvitationResourcesRequest
      ): F[ListPendingInvitationResourcesResponse]

      def listPermissions(
        request: ListPermissionsRequest
      ): F[ListPermissionsResponse]

      def listPrincipals(
        request: ListPrincipalsRequest
      ): F[ListPrincipalsResponse]

      def listResourceSharePermissions(
        request: ListResourceSharePermissionsRequest
      ): F[ListResourceSharePermissionsResponse]

      def listResourceTypes(
        request: ListResourceTypesRequest
      ): F[ListResourceTypesResponse]

      def listResources(
        request: ListResourcesRequest
      ): F[ListResourcesResponse]

      def promoteResourceShareCreatedFromPolicy(
        request: PromoteResourceShareCreatedFromPolicyRequest
      ): F[PromoteResourceShareCreatedFromPolicyResponse]

      def rejectResourceShareInvitation(
        request: RejectResourceShareInvitationRequest
      ): F[RejectResourceShareInvitationResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateResourceShare(
        request: UpdateResourceShareRequest
      ): F[UpdateResourceShareResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RamOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptResourceShareInvitationOp(
      request: AcceptResourceShareInvitationRequest
    ) extends RamOp[AcceptResourceShareInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptResourceShareInvitationResponse] =
        visitor.acceptResourceShareInvitation(request)
    }

    final case class AssociateResourceShareOp(
      request: AssociateResourceShareRequest
    ) extends RamOp[AssociateResourceShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateResourceShareResponse] =
        visitor.associateResourceShare(request)
    }

    final case class AssociateResourceSharePermissionOp(
      request: AssociateResourceSharePermissionRequest
    ) extends RamOp[AssociateResourceSharePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateResourceSharePermissionResponse] =
        visitor.associateResourceSharePermission(request)
    }

    final case class CreateResourceShareOp(
      request: CreateResourceShareRequest
    ) extends RamOp[CreateResourceShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceShareResponse] =
        visitor.createResourceShare(request)
    }

    final case class DeleteResourceShareOp(
      request: DeleteResourceShareRequest
    ) extends RamOp[DeleteResourceShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceShareResponse] =
        visitor.deleteResourceShare(request)
    }

    final case class DisassociateResourceShareOp(
      request: DisassociateResourceShareRequest
    ) extends RamOp[DisassociateResourceShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateResourceShareResponse] =
        visitor.disassociateResourceShare(request)
    }

    final case class DisassociateResourceSharePermissionOp(
      request: DisassociateResourceSharePermissionRequest
    ) extends RamOp[DisassociateResourceSharePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateResourceSharePermissionResponse] =
        visitor.disassociateResourceSharePermission(request)
    }

    final case class EnableSharingWithAwsOrganizationOp(
      request: EnableSharingWithAwsOrganizationRequest
    ) extends RamOp[EnableSharingWithAwsOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableSharingWithAwsOrganizationResponse] =
        visitor.enableSharingWithAwsOrganization(request)
    }

    final case class GetPermissionOp(
      request: GetPermissionRequest
    ) extends RamOp[GetPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPermissionResponse] =
        visitor.getPermission(request)
    }

    final case class GetResourcePoliciesOp(
      request: GetResourcePoliciesRequest
    ) extends RamOp[GetResourcePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePoliciesResponse] =
        visitor.getResourcePolicies(request)
    }

    final case class GetResourceShareAssociationsOp(
      request: GetResourceShareAssociationsRequest
    ) extends RamOp[GetResourceShareAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceShareAssociationsResponse] =
        visitor.getResourceShareAssociations(request)
    }

    final case class GetResourceShareInvitationsOp(
      request: GetResourceShareInvitationsRequest
    ) extends RamOp[GetResourceShareInvitationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceShareInvitationsResponse] =
        visitor.getResourceShareInvitations(request)
    }

    final case class GetResourceSharesOp(
      request: GetResourceSharesRequest
    ) extends RamOp[GetResourceSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceSharesResponse] =
        visitor.getResourceShares(request)
    }

    final case class ListPendingInvitationResourcesOp(
      request: ListPendingInvitationResourcesRequest
    ) extends RamOp[ListPendingInvitationResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPendingInvitationResourcesResponse] =
        visitor.listPendingInvitationResources(request)
    }

    final case class ListPermissionsOp(
      request: ListPermissionsRequest
    ) extends RamOp[ListPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPermissionsResponse] =
        visitor.listPermissions(request)
    }

    final case class ListPrincipalsOp(
      request: ListPrincipalsRequest
    ) extends RamOp[ListPrincipalsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPrincipalsResponse] =
        visitor.listPrincipals(request)
    }

    final case class ListResourceSharePermissionsOp(
      request: ListResourceSharePermissionsRequest
    ) extends RamOp[ListResourceSharePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceSharePermissionsResponse] =
        visitor.listResourceSharePermissions(request)
    }

    final case class ListResourceTypesOp(
      request: ListResourceTypesRequest
    ) extends RamOp[ListResourceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceTypesResponse] =
        visitor.listResourceTypes(request)
    }

    final case class ListResourcesOp(
      request: ListResourcesRequest
    ) extends RamOp[ListResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesResponse] =
        visitor.listResources(request)
    }

    final case class PromoteResourceShareCreatedFromPolicyOp(
      request: PromoteResourceShareCreatedFromPolicyRequest
    ) extends RamOp[PromoteResourceShareCreatedFromPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PromoteResourceShareCreatedFromPolicyResponse] =
        visitor.promoteResourceShareCreatedFromPolicy(request)
    }

    final case class RejectResourceShareInvitationOp(
      request: RejectResourceShareInvitationRequest
    ) extends RamOp[RejectResourceShareInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectResourceShareInvitationResponse] =
        visitor.rejectResourceShareInvitation(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends RamOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends RamOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateResourceShareOp(
      request: UpdateResourceShareRequest
    ) extends RamOp[UpdateResourceShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceShareResponse] =
        visitor.updateResourceShare(request)
    }
  }

  import RamOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RamOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptResourceShareInvitation(
    request: AcceptResourceShareInvitationRequest
  ): RamIO[AcceptResourceShareInvitationResponse] =
    FF.liftF(AcceptResourceShareInvitationOp(request))

  def associateResourceShare(
    request: AssociateResourceShareRequest
  ): RamIO[AssociateResourceShareResponse] =
    FF.liftF(AssociateResourceShareOp(request))

  def associateResourceSharePermission(
    request: AssociateResourceSharePermissionRequest
  ): RamIO[AssociateResourceSharePermissionResponse] =
    FF.liftF(AssociateResourceSharePermissionOp(request))

  def createResourceShare(
    request: CreateResourceShareRequest
  ): RamIO[CreateResourceShareResponse] =
    FF.liftF(CreateResourceShareOp(request))

  def deleteResourceShare(
    request: DeleteResourceShareRequest
  ): RamIO[DeleteResourceShareResponse] =
    FF.liftF(DeleteResourceShareOp(request))

  def disassociateResourceShare(
    request: DisassociateResourceShareRequest
  ): RamIO[DisassociateResourceShareResponse] =
    FF.liftF(DisassociateResourceShareOp(request))

  def disassociateResourceSharePermission(
    request: DisassociateResourceSharePermissionRequest
  ): RamIO[DisassociateResourceSharePermissionResponse] =
    FF.liftF(DisassociateResourceSharePermissionOp(request))

  def enableSharingWithAwsOrganization(
    request: EnableSharingWithAwsOrganizationRequest
  ): RamIO[EnableSharingWithAwsOrganizationResponse] =
    FF.liftF(EnableSharingWithAwsOrganizationOp(request))

  def getPermission(
    request: GetPermissionRequest
  ): RamIO[GetPermissionResponse] =
    FF.liftF(GetPermissionOp(request))

  def getResourcePolicies(
    request: GetResourcePoliciesRequest
  ): RamIO[GetResourcePoliciesResponse] =
    FF.liftF(GetResourcePoliciesOp(request))

  def getResourceShareAssociations(
    request: GetResourceShareAssociationsRequest
  ): RamIO[GetResourceShareAssociationsResponse] =
    FF.liftF(GetResourceShareAssociationsOp(request))

  def getResourceShareInvitations(
    request: GetResourceShareInvitationsRequest
  ): RamIO[GetResourceShareInvitationsResponse] =
    FF.liftF(GetResourceShareInvitationsOp(request))

  def getResourceShares(
    request: GetResourceSharesRequest
  ): RamIO[GetResourceSharesResponse] =
    FF.liftF(GetResourceSharesOp(request))

  def listPendingInvitationResources(
    request: ListPendingInvitationResourcesRequest
  ): RamIO[ListPendingInvitationResourcesResponse] =
    FF.liftF(ListPendingInvitationResourcesOp(request))

  def listPermissions(
    request: ListPermissionsRequest
  ): RamIO[ListPermissionsResponse] =
    FF.liftF(ListPermissionsOp(request))

  def listPrincipals(
    request: ListPrincipalsRequest
  ): RamIO[ListPrincipalsResponse] =
    FF.liftF(ListPrincipalsOp(request))

  def listResourceSharePermissions(
    request: ListResourceSharePermissionsRequest
  ): RamIO[ListResourceSharePermissionsResponse] =
    FF.liftF(ListResourceSharePermissionsOp(request))

  def listResourceTypes(
    request: ListResourceTypesRequest
  ): RamIO[ListResourceTypesResponse] =
    FF.liftF(ListResourceTypesOp(request))

  def listResources(
    request: ListResourcesRequest
  ): RamIO[ListResourcesResponse] =
    FF.liftF(ListResourcesOp(request))

  def promoteResourceShareCreatedFromPolicy(
    request: PromoteResourceShareCreatedFromPolicyRequest
  ): RamIO[PromoteResourceShareCreatedFromPolicyResponse] =
    FF.liftF(PromoteResourceShareCreatedFromPolicyOp(request))

  def rejectResourceShareInvitation(
    request: RejectResourceShareInvitationRequest
  ): RamIO[RejectResourceShareInvitationResponse] =
    FF.liftF(RejectResourceShareInvitationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): RamIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): RamIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateResourceShare(
    request: UpdateResourceShareRequest
  ): RamIO[UpdateResourceShareResponse] =
    FF.liftF(UpdateResourceShareOp(request))
}
