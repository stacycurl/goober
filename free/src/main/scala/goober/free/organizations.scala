package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.organizations.OrganizationsClient
import software.amazon.awssdk.services.organizations.model._


object organizations { module =>

  // Free monad over OrganizationsOp
  type OrganizationsIO[A] = FF[OrganizationsOp, A]

  sealed trait OrganizationsOp[A] {
    def visit[F[_]](visitor: OrganizationsOp.Visitor[F]): F[A]
  }

  object OrganizationsOp {
    // Given a OrganizationsClient we can embed a OrganizationsIO program in any algebra that understands embedding.
    implicit val OrganizationsOpEmbeddable: Embeddable[OrganizationsOp, OrganizationsClient] = new Embeddable[OrganizationsOp, OrganizationsClient] {
      def embed[A](client: OrganizationsClient, io: OrganizationsIO[A]): Embedded[A] = Embedded.Organizations(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends OrganizationsOp.Visitor[Kleisli[M, OrganizationsClient, *]] {
        def acceptHandshake(
          request: AcceptHandshakeRequest
        ): Kleisli[M, OrganizationsClient, AcceptHandshakeResponse] =
          primitive(_.acceptHandshake(request))

        def attachPolicy(
          request: AttachPolicyRequest
        ): Kleisli[M, OrganizationsClient, AttachPolicyResponse] =
          primitive(_.attachPolicy(request))

        def cancelHandshake(
          request: CancelHandshakeRequest
        ): Kleisli[M, OrganizationsClient, CancelHandshakeResponse] =
          primitive(_.cancelHandshake(request))

        def createAccount(
          request: CreateAccountRequest
        ): Kleisli[M, OrganizationsClient, CreateAccountResponse] =
          primitive(_.createAccount(request))

        def createGovCloudAccount(
          request: CreateGovCloudAccountRequest
        ): Kleisli[M, OrganizationsClient, CreateGovCloudAccountResponse] =
          primitive(_.createGovCloudAccount(request))

        def createOrganization(
          request: CreateOrganizationRequest
        ): Kleisli[M, OrganizationsClient, CreateOrganizationResponse] =
          primitive(_.createOrganization(request))

        def createOrganizationalUnit(
          request: CreateOrganizationalUnitRequest
        ): Kleisli[M, OrganizationsClient, CreateOrganizationalUnitResponse] =
          primitive(_.createOrganizationalUnit(request))

        def createPolicy(
          request: CreatePolicyRequest
        ): Kleisli[M, OrganizationsClient, CreatePolicyResponse] =
          primitive(_.createPolicy(request))

        def declineHandshake(
          request: DeclineHandshakeRequest
        ): Kleisli[M, OrganizationsClient, DeclineHandshakeResponse] =
          primitive(_.declineHandshake(request))

        def deleteOrganization(
          request: DeleteOrganizationRequest
        ): Kleisli[M, OrganizationsClient, DeleteOrganizationResponse] =
          primitive(_.deleteOrganization(request))

        def deleteOrganizationalUnit(
          request: DeleteOrganizationalUnitRequest
        ): Kleisli[M, OrganizationsClient, DeleteOrganizationalUnitResponse] =
          primitive(_.deleteOrganizationalUnit(request))

        def deletePolicy(
          request: DeletePolicyRequest
        ): Kleisli[M, OrganizationsClient, DeletePolicyResponse] =
          primitive(_.deletePolicy(request))

        def deregisterDelegatedAdministrator(
          request: DeregisterDelegatedAdministratorRequest
        ): Kleisli[M, OrganizationsClient, DeregisterDelegatedAdministratorResponse] =
          primitive(_.deregisterDelegatedAdministrator(request))

        def describeAccount(
          request: DescribeAccountRequest
        ): Kleisli[M, OrganizationsClient, DescribeAccountResponse] =
          primitive(_.describeAccount(request))

        def describeCreateAccountStatus(
          request: DescribeCreateAccountStatusRequest
        ): Kleisli[M, OrganizationsClient, DescribeCreateAccountStatusResponse] =
          primitive(_.describeCreateAccountStatus(request))

        def describeEffectivePolicy(
          request: DescribeEffectivePolicyRequest
        ): Kleisli[M, OrganizationsClient, DescribeEffectivePolicyResponse] =
          primitive(_.describeEffectivePolicy(request))

        def describeHandshake(
          request: DescribeHandshakeRequest
        ): Kleisli[M, OrganizationsClient, DescribeHandshakeResponse] =
          primitive(_.describeHandshake(request))

        def describeOrganization(
          request: DescribeOrganizationRequest
        ): Kleisli[M, OrganizationsClient, DescribeOrganizationResponse] =
          primitive(_.describeOrganization(request))

        def describeOrganizationalUnit(
          request: DescribeOrganizationalUnitRequest
        ): Kleisli[M, OrganizationsClient, DescribeOrganizationalUnitResponse] =
          primitive(_.describeOrganizationalUnit(request))

        def describePolicy(
          request: DescribePolicyRequest
        ): Kleisli[M, OrganizationsClient, DescribePolicyResponse] =
          primitive(_.describePolicy(request))

        def detachPolicy(
          request: DetachPolicyRequest
        ): Kleisli[M, OrganizationsClient, DetachPolicyResponse] =
          primitive(_.detachPolicy(request))

        def disableAWSServiceAccess(
          request: DisableAwsServiceAccessRequest
        ): Kleisli[M, OrganizationsClient, DisableAwsServiceAccessResponse] =
          primitive(_.disableAWSServiceAccess(request))

        def disablePolicyType(
          request: DisablePolicyTypeRequest
        ): Kleisli[M, OrganizationsClient, DisablePolicyTypeResponse] =
          primitive(_.disablePolicyType(request))

        def enableAWSServiceAccess(
          request: EnableAwsServiceAccessRequest
        ): Kleisli[M, OrganizationsClient, EnableAwsServiceAccessResponse] =
          primitive(_.enableAWSServiceAccess(request))

        def enableAllFeatures(
          request: EnableAllFeaturesRequest
        ): Kleisli[M, OrganizationsClient, EnableAllFeaturesResponse] =
          primitive(_.enableAllFeatures(request))

        def enablePolicyType(
          request: EnablePolicyTypeRequest
        ): Kleisli[M, OrganizationsClient, EnablePolicyTypeResponse] =
          primitive(_.enablePolicyType(request))

        def inviteAccountToOrganization(
          request: InviteAccountToOrganizationRequest
        ): Kleisli[M, OrganizationsClient, InviteAccountToOrganizationResponse] =
          primitive(_.inviteAccountToOrganization(request))

        def leaveOrganization(
          request: LeaveOrganizationRequest
        ): Kleisli[M, OrganizationsClient, LeaveOrganizationResponse] =
          primitive(_.leaveOrganization(request))

        def listAWSServiceAccessForOrganization(
          request: ListAwsServiceAccessForOrganizationRequest
        ): Kleisli[M, OrganizationsClient, ListAwsServiceAccessForOrganizationResponse] =
          primitive(_.listAWSServiceAccessForOrganization(request))

        def listAccounts(
          request: ListAccountsRequest
        ): Kleisli[M, OrganizationsClient, ListAccountsResponse] =
          primitive(_.listAccounts(request))

        def listAccountsForParent(
          request: ListAccountsForParentRequest
        ): Kleisli[M, OrganizationsClient, ListAccountsForParentResponse] =
          primitive(_.listAccountsForParent(request))

        def listChildren(
          request: ListChildrenRequest
        ): Kleisli[M, OrganizationsClient, ListChildrenResponse] =
          primitive(_.listChildren(request))

        def listCreateAccountStatus(
          request: ListCreateAccountStatusRequest
        ): Kleisli[M, OrganizationsClient, ListCreateAccountStatusResponse] =
          primitive(_.listCreateAccountStatus(request))

        def listDelegatedAdministrators(
          request: ListDelegatedAdministratorsRequest
        ): Kleisli[M, OrganizationsClient, ListDelegatedAdministratorsResponse] =
          primitive(_.listDelegatedAdministrators(request))

        def listDelegatedServicesForAccount(
          request: ListDelegatedServicesForAccountRequest
        ): Kleisli[M, OrganizationsClient, ListDelegatedServicesForAccountResponse] =
          primitive(_.listDelegatedServicesForAccount(request))

        def listHandshakesForAccount(
          request: ListHandshakesForAccountRequest
        ): Kleisli[M, OrganizationsClient, ListHandshakesForAccountResponse] =
          primitive(_.listHandshakesForAccount(request))

        def listHandshakesForOrganization(
          request: ListHandshakesForOrganizationRequest
        ): Kleisli[M, OrganizationsClient, ListHandshakesForOrganizationResponse] =
          primitive(_.listHandshakesForOrganization(request))

        def listOrganizationalUnitsForParent(
          request: ListOrganizationalUnitsForParentRequest
        ): Kleisli[M, OrganizationsClient, ListOrganizationalUnitsForParentResponse] =
          primitive(_.listOrganizationalUnitsForParent(request))

        def listParents(
          request: ListParentsRequest
        ): Kleisli[M, OrganizationsClient, ListParentsResponse] =
          primitive(_.listParents(request))

        def listPolicies(
          request: ListPoliciesRequest
        ): Kleisli[M, OrganizationsClient, ListPoliciesResponse] =
          primitive(_.listPolicies(request))

        def listPoliciesForTarget(
          request: ListPoliciesForTargetRequest
        ): Kleisli[M, OrganizationsClient, ListPoliciesForTargetResponse] =
          primitive(_.listPoliciesForTarget(request))

        def listRoots(
          request: ListRootsRequest
        ): Kleisli[M, OrganizationsClient, ListRootsResponse] =
          primitive(_.listRoots(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, OrganizationsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTargetsForPolicy(
          request: ListTargetsForPolicyRequest
        ): Kleisli[M, OrganizationsClient, ListTargetsForPolicyResponse] =
          primitive(_.listTargetsForPolicy(request))

        def moveAccount(
          request: MoveAccountRequest
        ): Kleisli[M, OrganizationsClient, MoveAccountResponse] =
          primitive(_.moveAccount(request))

        def registerDelegatedAdministrator(
          request: RegisterDelegatedAdministratorRequest
        ): Kleisli[M, OrganizationsClient, RegisterDelegatedAdministratorResponse] =
          primitive(_.registerDelegatedAdministrator(request))

        def removeAccountFromOrganization(
          request: RemoveAccountFromOrganizationRequest
        ): Kleisli[M, OrganizationsClient, RemoveAccountFromOrganizationResponse] =
          primitive(_.removeAccountFromOrganization(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, OrganizationsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, OrganizationsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateOrganizationalUnit(
          request: UpdateOrganizationalUnitRequest
        ): Kleisli[M, OrganizationsClient, UpdateOrganizationalUnitResponse] =
          primitive(_.updateOrganizationalUnit(request))

        def updatePolicy(
          request: UpdatePolicyRequest
        ): Kleisli[M, OrganizationsClient, UpdatePolicyResponse] =
          primitive(_.updatePolicy(request))

        def primitive[A](
          f: OrganizationsClient => A
        ): Kleisli[M, OrganizationsClient, A]
      }
    }

    trait Visitor[F[_]] extends (OrganizationsOp ~> F) {
      final def apply[A](op: OrganizationsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptHandshake(
        request: AcceptHandshakeRequest
      ): F[AcceptHandshakeResponse]

      def attachPolicy(
        request: AttachPolicyRequest
      ): F[AttachPolicyResponse]

      def cancelHandshake(
        request: CancelHandshakeRequest
      ): F[CancelHandshakeResponse]

      def createAccount(
        request: CreateAccountRequest
      ): F[CreateAccountResponse]

      def createGovCloudAccount(
        request: CreateGovCloudAccountRequest
      ): F[CreateGovCloudAccountResponse]

      def createOrganization(
        request: CreateOrganizationRequest
      ): F[CreateOrganizationResponse]

      def createOrganizationalUnit(
        request: CreateOrganizationalUnitRequest
      ): F[CreateOrganizationalUnitResponse]

      def createPolicy(
        request: CreatePolicyRequest
      ): F[CreatePolicyResponse]

      def declineHandshake(
        request: DeclineHandshakeRequest
      ): F[DeclineHandshakeResponse]

      def deleteOrganization(
        request: DeleteOrganizationRequest
      ): F[DeleteOrganizationResponse]

      def deleteOrganizationalUnit(
        request: DeleteOrganizationalUnitRequest
      ): F[DeleteOrganizationalUnitResponse]

      def deletePolicy(
        request: DeletePolicyRequest
      ): F[DeletePolicyResponse]

      def deregisterDelegatedAdministrator(
        request: DeregisterDelegatedAdministratorRequest
      ): F[DeregisterDelegatedAdministratorResponse]

      def describeAccount(
        request: DescribeAccountRequest
      ): F[DescribeAccountResponse]

      def describeCreateAccountStatus(
        request: DescribeCreateAccountStatusRequest
      ): F[DescribeCreateAccountStatusResponse]

      def describeEffectivePolicy(
        request: DescribeEffectivePolicyRequest
      ): F[DescribeEffectivePolicyResponse]

      def describeHandshake(
        request: DescribeHandshakeRequest
      ): F[DescribeHandshakeResponse]

      def describeOrganization(
        request: DescribeOrganizationRequest
      ): F[DescribeOrganizationResponse]

      def describeOrganizationalUnit(
        request: DescribeOrganizationalUnitRequest
      ): F[DescribeOrganizationalUnitResponse]

      def describePolicy(
        request: DescribePolicyRequest
      ): F[DescribePolicyResponse]

      def detachPolicy(
        request: DetachPolicyRequest
      ): F[DetachPolicyResponse]

      def disableAWSServiceAccess(
        request: DisableAwsServiceAccessRequest
      ): F[DisableAwsServiceAccessResponse]

      def disablePolicyType(
        request: DisablePolicyTypeRequest
      ): F[DisablePolicyTypeResponse]

      def enableAWSServiceAccess(
        request: EnableAwsServiceAccessRequest
      ): F[EnableAwsServiceAccessResponse]

      def enableAllFeatures(
        request: EnableAllFeaturesRequest
      ): F[EnableAllFeaturesResponse]

      def enablePolicyType(
        request: EnablePolicyTypeRequest
      ): F[EnablePolicyTypeResponse]

      def inviteAccountToOrganization(
        request: InviteAccountToOrganizationRequest
      ): F[InviteAccountToOrganizationResponse]

      def leaveOrganization(
        request: LeaveOrganizationRequest
      ): F[LeaveOrganizationResponse]

      def listAWSServiceAccessForOrganization(
        request: ListAwsServiceAccessForOrganizationRequest
      ): F[ListAwsServiceAccessForOrganizationResponse]

      def listAccounts(
        request: ListAccountsRequest
      ): F[ListAccountsResponse]

      def listAccountsForParent(
        request: ListAccountsForParentRequest
      ): F[ListAccountsForParentResponse]

      def listChildren(
        request: ListChildrenRequest
      ): F[ListChildrenResponse]

      def listCreateAccountStatus(
        request: ListCreateAccountStatusRequest
      ): F[ListCreateAccountStatusResponse]

      def listDelegatedAdministrators(
        request: ListDelegatedAdministratorsRequest
      ): F[ListDelegatedAdministratorsResponse]

      def listDelegatedServicesForAccount(
        request: ListDelegatedServicesForAccountRequest
      ): F[ListDelegatedServicesForAccountResponse]

      def listHandshakesForAccount(
        request: ListHandshakesForAccountRequest
      ): F[ListHandshakesForAccountResponse]

      def listHandshakesForOrganization(
        request: ListHandshakesForOrganizationRequest
      ): F[ListHandshakesForOrganizationResponse]

      def listOrganizationalUnitsForParent(
        request: ListOrganizationalUnitsForParentRequest
      ): F[ListOrganizationalUnitsForParentResponse]

      def listParents(
        request: ListParentsRequest
      ): F[ListParentsResponse]

      def listPolicies(
        request: ListPoliciesRequest
      ): F[ListPoliciesResponse]

      def listPoliciesForTarget(
        request: ListPoliciesForTargetRequest
      ): F[ListPoliciesForTargetResponse]

      def listRoots(
        request: ListRootsRequest
      ): F[ListRootsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTargetsForPolicy(
        request: ListTargetsForPolicyRequest
      ): F[ListTargetsForPolicyResponse]

      def moveAccount(
        request: MoveAccountRequest
      ): F[MoveAccountResponse]

      def registerDelegatedAdministrator(
        request: RegisterDelegatedAdministratorRequest
      ): F[RegisterDelegatedAdministratorResponse]

      def removeAccountFromOrganization(
        request: RemoveAccountFromOrganizationRequest
      ): F[RemoveAccountFromOrganizationResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateOrganizationalUnit(
        request: UpdateOrganizationalUnitRequest
      ): F[UpdateOrganizationalUnitResponse]

      def updatePolicy(
        request: UpdatePolicyRequest
      ): F[UpdatePolicyResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends OrganizationsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptHandshakeOp(
      request: AcceptHandshakeRequest
    ) extends OrganizationsOp[AcceptHandshakeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptHandshakeResponse] =
        visitor.acceptHandshake(request)
    }

    final case class AttachPolicyOp(
      request: AttachPolicyRequest
    ) extends OrganizationsOp[AttachPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachPolicyResponse] =
        visitor.attachPolicy(request)
    }

    final case class CancelHandshakeOp(
      request: CancelHandshakeRequest
    ) extends OrganizationsOp[CancelHandshakeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelHandshakeResponse] =
        visitor.cancelHandshake(request)
    }

    final case class CreateAccountOp(
      request: CreateAccountRequest
    ) extends OrganizationsOp[CreateAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccountResponse] =
        visitor.createAccount(request)
    }

    final case class CreateGovCloudAccountOp(
      request: CreateGovCloudAccountRequest
    ) extends OrganizationsOp[CreateGovCloudAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGovCloudAccountResponse] =
        visitor.createGovCloudAccount(request)
    }

    final case class CreateOrganizationOp(
      request: CreateOrganizationRequest
    ) extends OrganizationsOp[CreateOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOrganizationResponse] =
        visitor.createOrganization(request)
    }

    final case class CreateOrganizationalUnitOp(
      request: CreateOrganizationalUnitRequest
    ) extends OrganizationsOp[CreateOrganizationalUnitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOrganizationalUnitResponse] =
        visitor.createOrganizationalUnit(request)
    }

    final case class CreatePolicyOp(
      request: CreatePolicyRequest
    ) extends OrganizationsOp[CreatePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePolicyResponse] =
        visitor.createPolicy(request)
    }

    final case class DeclineHandshakeOp(
      request: DeclineHandshakeRequest
    ) extends OrganizationsOp[DeclineHandshakeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeclineHandshakeResponse] =
        visitor.declineHandshake(request)
    }

    final case class DeleteOrganizationOp(
      request: DeleteOrganizationRequest
    ) extends OrganizationsOp[DeleteOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOrganizationResponse] =
        visitor.deleteOrganization(request)
    }

    final case class DeleteOrganizationalUnitOp(
      request: DeleteOrganizationalUnitRequest
    ) extends OrganizationsOp[DeleteOrganizationalUnitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOrganizationalUnitResponse] =
        visitor.deleteOrganizationalUnit(request)
    }

    final case class DeletePolicyOp(
      request: DeletePolicyRequest
    ) extends OrganizationsOp[DeletePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyResponse] =
        visitor.deletePolicy(request)
    }

    final case class DeregisterDelegatedAdministratorOp(
      request: DeregisterDelegatedAdministratorRequest
    ) extends OrganizationsOp[DeregisterDelegatedAdministratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterDelegatedAdministratorResponse] =
        visitor.deregisterDelegatedAdministrator(request)
    }

    final case class DescribeAccountOp(
      request: DescribeAccountRequest
    ) extends OrganizationsOp[DescribeAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountResponse] =
        visitor.describeAccount(request)
    }

    final case class DescribeCreateAccountStatusOp(
      request: DescribeCreateAccountStatusRequest
    ) extends OrganizationsOp[DescribeCreateAccountStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCreateAccountStatusResponse] =
        visitor.describeCreateAccountStatus(request)
    }

    final case class DescribeEffectivePolicyOp(
      request: DescribeEffectivePolicyRequest
    ) extends OrganizationsOp[DescribeEffectivePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEffectivePolicyResponse] =
        visitor.describeEffectivePolicy(request)
    }

    final case class DescribeHandshakeOp(
      request: DescribeHandshakeRequest
    ) extends OrganizationsOp[DescribeHandshakeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHandshakeResponse] =
        visitor.describeHandshake(request)
    }

    final case class DescribeOrganizationOp(
      request: DescribeOrganizationRequest
    ) extends OrganizationsOp[DescribeOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationResponse] =
        visitor.describeOrganization(request)
    }

    final case class DescribeOrganizationalUnitOp(
      request: DescribeOrganizationalUnitRequest
    ) extends OrganizationsOp[DescribeOrganizationalUnitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationalUnitResponse] =
        visitor.describeOrganizationalUnit(request)
    }

    final case class DescribePolicyOp(
      request: DescribePolicyRequest
    ) extends OrganizationsOp[DescribePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePolicyResponse] =
        visitor.describePolicy(request)
    }

    final case class DetachPolicyOp(
      request: DetachPolicyRequest
    ) extends OrganizationsOp[DetachPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachPolicyResponse] =
        visitor.detachPolicy(request)
    }

    final case class DisableAWSServiceAccessOp(
      request: DisableAwsServiceAccessRequest
    ) extends OrganizationsOp[DisableAwsServiceAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableAwsServiceAccessResponse] =
        visitor.disableAWSServiceAccess(request)
    }

    final case class DisablePolicyTypeOp(
      request: DisablePolicyTypeRequest
    ) extends OrganizationsOp[DisablePolicyTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisablePolicyTypeResponse] =
        visitor.disablePolicyType(request)
    }

    final case class EnableAWSServiceAccessOp(
      request: EnableAwsServiceAccessRequest
    ) extends OrganizationsOp[EnableAwsServiceAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableAwsServiceAccessResponse] =
        visitor.enableAWSServiceAccess(request)
    }

    final case class EnableAllFeaturesOp(
      request: EnableAllFeaturesRequest
    ) extends OrganizationsOp[EnableAllFeaturesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableAllFeaturesResponse] =
        visitor.enableAllFeatures(request)
    }

    final case class EnablePolicyTypeOp(
      request: EnablePolicyTypeRequest
    ) extends OrganizationsOp[EnablePolicyTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnablePolicyTypeResponse] =
        visitor.enablePolicyType(request)
    }

    final case class InviteAccountToOrganizationOp(
      request: InviteAccountToOrganizationRequest
    ) extends OrganizationsOp[InviteAccountToOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InviteAccountToOrganizationResponse] =
        visitor.inviteAccountToOrganization(request)
    }

    final case class LeaveOrganizationOp(
      request: LeaveOrganizationRequest
    ) extends OrganizationsOp[LeaveOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LeaveOrganizationResponse] =
        visitor.leaveOrganization(request)
    }

    final case class ListAWSServiceAccessForOrganizationOp(
      request: ListAwsServiceAccessForOrganizationRequest
    ) extends OrganizationsOp[ListAwsServiceAccessForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAwsServiceAccessForOrganizationResponse] =
        visitor.listAWSServiceAccessForOrganization(request)
    }

    final case class ListAccountsOp(
      request: ListAccountsRequest
    ) extends OrganizationsOp[ListAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountsResponse] =
        visitor.listAccounts(request)
    }

    final case class ListAccountsForParentOp(
      request: ListAccountsForParentRequest
    ) extends OrganizationsOp[ListAccountsForParentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountsForParentResponse] =
        visitor.listAccountsForParent(request)
    }

    final case class ListChildrenOp(
      request: ListChildrenRequest
    ) extends OrganizationsOp[ListChildrenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChildrenResponse] =
        visitor.listChildren(request)
    }

    final case class ListCreateAccountStatusOp(
      request: ListCreateAccountStatusRequest
    ) extends OrganizationsOp[ListCreateAccountStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCreateAccountStatusResponse] =
        visitor.listCreateAccountStatus(request)
    }

    final case class ListDelegatedAdministratorsOp(
      request: ListDelegatedAdministratorsRequest
    ) extends OrganizationsOp[ListDelegatedAdministratorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDelegatedAdministratorsResponse] =
        visitor.listDelegatedAdministrators(request)
    }

    final case class ListDelegatedServicesForAccountOp(
      request: ListDelegatedServicesForAccountRequest
    ) extends OrganizationsOp[ListDelegatedServicesForAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDelegatedServicesForAccountResponse] =
        visitor.listDelegatedServicesForAccount(request)
    }

    final case class ListHandshakesForAccountOp(
      request: ListHandshakesForAccountRequest
    ) extends OrganizationsOp[ListHandshakesForAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHandshakesForAccountResponse] =
        visitor.listHandshakesForAccount(request)
    }

    final case class ListHandshakesForOrganizationOp(
      request: ListHandshakesForOrganizationRequest
    ) extends OrganizationsOp[ListHandshakesForOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHandshakesForOrganizationResponse] =
        visitor.listHandshakesForOrganization(request)
    }

    final case class ListOrganizationalUnitsForParentOp(
      request: ListOrganizationalUnitsForParentRequest
    ) extends OrganizationsOp[ListOrganizationalUnitsForParentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOrganizationalUnitsForParentResponse] =
        visitor.listOrganizationalUnitsForParent(request)
    }

    final case class ListParentsOp(
      request: ListParentsRequest
    ) extends OrganizationsOp[ListParentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListParentsResponse] =
        visitor.listParents(request)
    }

    final case class ListPoliciesOp(
      request: ListPoliciesRequest
    ) extends OrganizationsOp[ListPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPoliciesResponse] =
        visitor.listPolicies(request)
    }

    final case class ListPoliciesForTargetOp(
      request: ListPoliciesForTargetRequest
    ) extends OrganizationsOp[ListPoliciesForTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPoliciesForTargetResponse] =
        visitor.listPoliciesForTarget(request)
    }

    final case class ListRootsOp(
      request: ListRootsRequest
    ) extends OrganizationsOp[ListRootsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRootsResponse] =
        visitor.listRoots(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends OrganizationsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTargetsForPolicyOp(
      request: ListTargetsForPolicyRequest
    ) extends OrganizationsOp[ListTargetsForPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTargetsForPolicyResponse] =
        visitor.listTargetsForPolicy(request)
    }

    final case class MoveAccountOp(
      request: MoveAccountRequest
    ) extends OrganizationsOp[MoveAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MoveAccountResponse] =
        visitor.moveAccount(request)
    }

    final case class RegisterDelegatedAdministratorOp(
      request: RegisterDelegatedAdministratorRequest
    ) extends OrganizationsOp[RegisterDelegatedAdministratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterDelegatedAdministratorResponse] =
        visitor.registerDelegatedAdministrator(request)
    }

    final case class RemoveAccountFromOrganizationOp(
      request: RemoveAccountFromOrganizationRequest
    ) extends OrganizationsOp[RemoveAccountFromOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveAccountFromOrganizationResponse] =
        visitor.removeAccountFromOrganization(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends OrganizationsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends OrganizationsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateOrganizationalUnitOp(
      request: UpdateOrganizationalUnitRequest
    ) extends OrganizationsOp[UpdateOrganizationalUnitResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOrganizationalUnitResponse] =
        visitor.updateOrganizationalUnit(request)
    }

    final case class UpdatePolicyOp(
      request: UpdatePolicyRequest
    ) extends OrganizationsOp[UpdatePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePolicyResponse] =
        visitor.updatePolicy(request)
    }
  }

  import OrganizationsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[OrganizationsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptHandshake(
    request: AcceptHandshakeRequest
  ): OrganizationsIO[AcceptHandshakeResponse] =
    FF.liftF(AcceptHandshakeOp(request))

  def attachPolicy(
    request: AttachPolicyRequest
  ): OrganizationsIO[AttachPolicyResponse] =
    FF.liftF(AttachPolicyOp(request))

  def cancelHandshake(
    request: CancelHandshakeRequest
  ): OrganizationsIO[CancelHandshakeResponse] =
    FF.liftF(CancelHandshakeOp(request))

  def createAccount(
    request: CreateAccountRequest
  ): OrganizationsIO[CreateAccountResponse] =
    FF.liftF(CreateAccountOp(request))

  def createGovCloudAccount(
    request: CreateGovCloudAccountRequest
  ): OrganizationsIO[CreateGovCloudAccountResponse] =
    FF.liftF(CreateGovCloudAccountOp(request))

  def createOrganization(
    request: CreateOrganizationRequest
  ): OrganizationsIO[CreateOrganizationResponse] =
    FF.liftF(CreateOrganizationOp(request))

  def createOrganizationalUnit(
    request: CreateOrganizationalUnitRequest
  ): OrganizationsIO[CreateOrganizationalUnitResponse] =
    FF.liftF(CreateOrganizationalUnitOp(request))

  def createPolicy(
    request: CreatePolicyRequest
  ): OrganizationsIO[CreatePolicyResponse] =
    FF.liftF(CreatePolicyOp(request))

  def declineHandshake(
    request: DeclineHandshakeRequest
  ): OrganizationsIO[DeclineHandshakeResponse] =
    FF.liftF(DeclineHandshakeOp(request))

  def deleteOrganization(
    request: DeleteOrganizationRequest
  ): OrganizationsIO[DeleteOrganizationResponse] =
    FF.liftF(DeleteOrganizationOp(request))

  def deleteOrganizationalUnit(
    request: DeleteOrganizationalUnitRequest
  ): OrganizationsIO[DeleteOrganizationalUnitResponse] =
    FF.liftF(DeleteOrganizationalUnitOp(request))

  def deletePolicy(
    request: DeletePolicyRequest
  ): OrganizationsIO[DeletePolicyResponse] =
    FF.liftF(DeletePolicyOp(request))

  def deregisterDelegatedAdministrator(
    request: DeregisterDelegatedAdministratorRequest
  ): OrganizationsIO[DeregisterDelegatedAdministratorResponse] =
    FF.liftF(DeregisterDelegatedAdministratorOp(request))

  def describeAccount(
    request: DescribeAccountRequest
  ): OrganizationsIO[DescribeAccountResponse] =
    FF.liftF(DescribeAccountOp(request))

  def describeCreateAccountStatus(
    request: DescribeCreateAccountStatusRequest
  ): OrganizationsIO[DescribeCreateAccountStatusResponse] =
    FF.liftF(DescribeCreateAccountStatusOp(request))

  def describeEffectivePolicy(
    request: DescribeEffectivePolicyRequest
  ): OrganizationsIO[DescribeEffectivePolicyResponse] =
    FF.liftF(DescribeEffectivePolicyOp(request))

  def describeHandshake(
    request: DescribeHandshakeRequest
  ): OrganizationsIO[DescribeHandshakeResponse] =
    FF.liftF(DescribeHandshakeOp(request))

  def describeOrganization(
    request: DescribeOrganizationRequest
  ): OrganizationsIO[DescribeOrganizationResponse] =
    FF.liftF(DescribeOrganizationOp(request))

  def describeOrganizationalUnit(
    request: DescribeOrganizationalUnitRequest
  ): OrganizationsIO[DescribeOrganizationalUnitResponse] =
    FF.liftF(DescribeOrganizationalUnitOp(request))

  def describePolicy(
    request: DescribePolicyRequest
  ): OrganizationsIO[DescribePolicyResponse] =
    FF.liftF(DescribePolicyOp(request))

  def detachPolicy(
    request: DetachPolicyRequest
  ): OrganizationsIO[DetachPolicyResponse] =
    FF.liftF(DetachPolicyOp(request))

  def disableAWSServiceAccess(
    request: DisableAwsServiceAccessRequest
  ): OrganizationsIO[DisableAwsServiceAccessResponse] =
    FF.liftF(DisableAWSServiceAccessOp(request))

  def disablePolicyType(
    request: DisablePolicyTypeRequest
  ): OrganizationsIO[DisablePolicyTypeResponse] =
    FF.liftF(DisablePolicyTypeOp(request))

  def enableAWSServiceAccess(
    request: EnableAwsServiceAccessRequest
  ): OrganizationsIO[EnableAwsServiceAccessResponse] =
    FF.liftF(EnableAWSServiceAccessOp(request))

  def enableAllFeatures(
    request: EnableAllFeaturesRequest
  ): OrganizationsIO[EnableAllFeaturesResponse] =
    FF.liftF(EnableAllFeaturesOp(request))

  def enablePolicyType(
    request: EnablePolicyTypeRequest
  ): OrganizationsIO[EnablePolicyTypeResponse] =
    FF.liftF(EnablePolicyTypeOp(request))

  def inviteAccountToOrganization(
    request: InviteAccountToOrganizationRequest
  ): OrganizationsIO[InviteAccountToOrganizationResponse] =
    FF.liftF(InviteAccountToOrganizationOp(request))

  def leaveOrganization(
    request: LeaveOrganizationRequest
  ): OrganizationsIO[LeaveOrganizationResponse] =
    FF.liftF(LeaveOrganizationOp(request))

  def listAWSServiceAccessForOrganization(
    request: ListAwsServiceAccessForOrganizationRequest
  ): OrganizationsIO[ListAwsServiceAccessForOrganizationResponse] =
    FF.liftF(ListAWSServiceAccessForOrganizationOp(request))

  def listAccounts(
    request: ListAccountsRequest
  ): OrganizationsIO[ListAccountsResponse] =
    FF.liftF(ListAccountsOp(request))

  def listAccountsForParent(
    request: ListAccountsForParentRequest
  ): OrganizationsIO[ListAccountsForParentResponse] =
    FF.liftF(ListAccountsForParentOp(request))

  def listChildren(
    request: ListChildrenRequest
  ): OrganizationsIO[ListChildrenResponse] =
    FF.liftF(ListChildrenOp(request))

  def listCreateAccountStatus(
    request: ListCreateAccountStatusRequest
  ): OrganizationsIO[ListCreateAccountStatusResponse] =
    FF.liftF(ListCreateAccountStatusOp(request))

  def listDelegatedAdministrators(
    request: ListDelegatedAdministratorsRequest
  ): OrganizationsIO[ListDelegatedAdministratorsResponse] =
    FF.liftF(ListDelegatedAdministratorsOp(request))

  def listDelegatedServicesForAccount(
    request: ListDelegatedServicesForAccountRequest
  ): OrganizationsIO[ListDelegatedServicesForAccountResponse] =
    FF.liftF(ListDelegatedServicesForAccountOp(request))

  def listHandshakesForAccount(
    request: ListHandshakesForAccountRequest
  ): OrganizationsIO[ListHandshakesForAccountResponse] =
    FF.liftF(ListHandshakesForAccountOp(request))

  def listHandshakesForOrganization(
    request: ListHandshakesForOrganizationRequest
  ): OrganizationsIO[ListHandshakesForOrganizationResponse] =
    FF.liftF(ListHandshakesForOrganizationOp(request))

  def listOrganizationalUnitsForParent(
    request: ListOrganizationalUnitsForParentRequest
  ): OrganizationsIO[ListOrganizationalUnitsForParentResponse] =
    FF.liftF(ListOrganizationalUnitsForParentOp(request))

  def listParents(
    request: ListParentsRequest
  ): OrganizationsIO[ListParentsResponse] =
    FF.liftF(ListParentsOp(request))

  def listPolicies(
    request: ListPoliciesRequest
  ): OrganizationsIO[ListPoliciesResponse] =
    FF.liftF(ListPoliciesOp(request))

  def listPoliciesForTarget(
    request: ListPoliciesForTargetRequest
  ): OrganizationsIO[ListPoliciesForTargetResponse] =
    FF.liftF(ListPoliciesForTargetOp(request))

  def listRoots(
    request: ListRootsRequest
  ): OrganizationsIO[ListRootsResponse] =
    FF.liftF(ListRootsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): OrganizationsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTargetsForPolicy(
    request: ListTargetsForPolicyRequest
  ): OrganizationsIO[ListTargetsForPolicyResponse] =
    FF.liftF(ListTargetsForPolicyOp(request))

  def moveAccount(
    request: MoveAccountRequest
  ): OrganizationsIO[MoveAccountResponse] =
    FF.liftF(MoveAccountOp(request))

  def registerDelegatedAdministrator(
    request: RegisterDelegatedAdministratorRequest
  ): OrganizationsIO[RegisterDelegatedAdministratorResponse] =
    FF.liftF(RegisterDelegatedAdministratorOp(request))

  def removeAccountFromOrganization(
    request: RemoveAccountFromOrganizationRequest
  ): OrganizationsIO[RemoveAccountFromOrganizationResponse] =
    FF.liftF(RemoveAccountFromOrganizationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): OrganizationsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): OrganizationsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateOrganizationalUnit(
    request: UpdateOrganizationalUnitRequest
  ): OrganizationsIO[UpdateOrganizationalUnitResponse] =
    FF.liftF(UpdateOrganizationalUnitOp(request))

  def updatePolicy(
    request: UpdatePolicyRequest
  ): OrganizationsIO[UpdatePolicyResponse] =
    FF.liftF(UpdatePolicyOp(request))
}
