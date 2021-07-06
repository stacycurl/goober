package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ssoadmin.SsoAdminClient
import software.amazon.awssdk.services.ssoadmin.model._


object ssoadmin { module =>

  // Free monad over SsoAdminOp
  type SsoAdminIO[A] = FF[SsoAdminOp, A]

  sealed trait SsoAdminOp[A] {
    def visit[F[_]](visitor: SsoAdminOp.Visitor[F]): F[A]
  }

  object SsoAdminOp {
    // Given a SsoAdminClient we can embed a SsoAdminIO program in any algebra that understands embedding.
    implicit val SsoAdminOpEmbeddable: Embeddable[SsoAdminOp, SsoAdminClient] = new Embeddable[SsoAdminOp, SsoAdminClient] {
      def embed[A](client: SsoAdminClient, io: SsoAdminIO[A]): Embedded[A] = Embedded.SsoAdmin(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SsoAdminOp.Visitor[Kleisli[M, SsoAdminClient, *]] {
        def attachManagedPolicyToPermissionSet(
          request: AttachManagedPolicyToPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, AttachManagedPolicyToPermissionSetResponse] =
          primitive(_.attachManagedPolicyToPermissionSet(request))

        def createAccountAssignment(
          request: CreateAccountAssignmentRequest
        ): Kleisli[M, SsoAdminClient, CreateAccountAssignmentResponse] =
          primitive(_.createAccountAssignment(request))

        def createInstanceAccessControlAttributeConfiguration(
          request: CreateInstanceAccessControlAttributeConfigurationRequest
        ): Kleisli[M, SsoAdminClient, CreateInstanceAccessControlAttributeConfigurationResponse] =
          primitive(_.createInstanceAccessControlAttributeConfiguration(request))

        def createPermissionSet(
          request: CreatePermissionSetRequest
        ): Kleisli[M, SsoAdminClient, CreatePermissionSetResponse] =
          primitive(_.createPermissionSet(request))

        def deleteAccountAssignment(
          request: DeleteAccountAssignmentRequest
        ): Kleisli[M, SsoAdminClient, DeleteAccountAssignmentResponse] =
          primitive(_.deleteAccountAssignment(request))

        def deleteInlinePolicyFromPermissionSet(
          request: DeleteInlinePolicyFromPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, DeleteInlinePolicyFromPermissionSetResponse] =
          primitive(_.deleteInlinePolicyFromPermissionSet(request))

        def deleteInstanceAccessControlAttributeConfiguration(
          request: DeleteInstanceAccessControlAttributeConfigurationRequest
        ): Kleisli[M, SsoAdminClient, DeleteInstanceAccessControlAttributeConfigurationResponse] =
          primitive(_.deleteInstanceAccessControlAttributeConfiguration(request))

        def deletePermissionSet(
          request: DeletePermissionSetRequest
        ): Kleisli[M, SsoAdminClient, DeletePermissionSetResponse] =
          primitive(_.deletePermissionSet(request))

        def describeAccountAssignmentCreationStatus(
          request: DescribeAccountAssignmentCreationStatusRequest
        ): Kleisli[M, SsoAdminClient, DescribeAccountAssignmentCreationStatusResponse] =
          primitive(_.describeAccountAssignmentCreationStatus(request))

        def describeAccountAssignmentDeletionStatus(
          request: DescribeAccountAssignmentDeletionStatusRequest
        ): Kleisli[M, SsoAdminClient, DescribeAccountAssignmentDeletionStatusResponse] =
          primitive(_.describeAccountAssignmentDeletionStatus(request))

        def describeInstanceAccessControlAttributeConfiguration(
          request: DescribeInstanceAccessControlAttributeConfigurationRequest
        ): Kleisli[M, SsoAdminClient, DescribeInstanceAccessControlAttributeConfigurationResponse] =
          primitive(_.describeInstanceAccessControlAttributeConfiguration(request))

        def describePermissionSet(
          request: DescribePermissionSetRequest
        ): Kleisli[M, SsoAdminClient, DescribePermissionSetResponse] =
          primitive(_.describePermissionSet(request))

        def describePermissionSetProvisioningStatus(
          request: DescribePermissionSetProvisioningStatusRequest
        ): Kleisli[M, SsoAdminClient, DescribePermissionSetProvisioningStatusResponse] =
          primitive(_.describePermissionSetProvisioningStatus(request))

        def detachManagedPolicyFromPermissionSet(
          request: DetachManagedPolicyFromPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, DetachManagedPolicyFromPermissionSetResponse] =
          primitive(_.detachManagedPolicyFromPermissionSet(request))

        def getInlinePolicyForPermissionSet(
          request: GetInlinePolicyForPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, GetInlinePolicyForPermissionSetResponse] =
          primitive(_.getInlinePolicyForPermissionSet(request))

        def listAccountAssignmentCreationStatus(
          request: ListAccountAssignmentCreationStatusRequest
        ): Kleisli[M, SsoAdminClient, ListAccountAssignmentCreationStatusResponse] =
          primitive(_.listAccountAssignmentCreationStatus(request))

        def listAccountAssignmentDeletionStatus(
          request: ListAccountAssignmentDeletionStatusRequest
        ): Kleisli[M, SsoAdminClient, ListAccountAssignmentDeletionStatusResponse] =
          primitive(_.listAccountAssignmentDeletionStatus(request))

        def listAccountAssignments(
          request: ListAccountAssignmentsRequest
        ): Kleisli[M, SsoAdminClient, ListAccountAssignmentsResponse] =
          primitive(_.listAccountAssignments(request))

        def listAccountsForProvisionedPermissionSet(
          request: ListAccountsForProvisionedPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, ListAccountsForProvisionedPermissionSetResponse] =
          primitive(_.listAccountsForProvisionedPermissionSet(request))

        def listInstances(
          request: ListInstancesRequest
        ): Kleisli[M, SsoAdminClient, ListInstancesResponse] =
          primitive(_.listInstances(request))

        def listManagedPoliciesInPermissionSet(
          request: ListManagedPoliciesInPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, ListManagedPoliciesInPermissionSetResponse] =
          primitive(_.listManagedPoliciesInPermissionSet(request))

        def listPermissionSetProvisioningStatus(
          request: ListPermissionSetProvisioningStatusRequest
        ): Kleisli[M, SsoAdminClient, ListPermissionSetProvisioningStatusResponse] =
          primitive(_.listPermissionSetProvisioningStatus(request))

        def listPermissionSets(
          request: ListPermissionSetsRequest
        ): Kleisli[M, SsoAdminClient, ListPermissionSetsResponse] =
          primitive(_.listPermissionSets(request))

        def listPermissionSetsProvisionedToAccount(
          request: ListPermissionSetsProvisionedToAccountRequest
        ): Kleisli[M, SsoAdminClient, ListPermissionSetsProvisionedToAccountResponse] =
          primitive(_.listPermissionSetsProvisionedToAccount(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SsoAdminClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def provisionPermissionSet(
          request: ProvisionPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, ProvisionPermissionSetResponse] =
          primitive(_.provisionPermissionSet(request))

        def putInlinePolicyToPermissionSet(
          request: PutInlinePolicyToPermissionSetRequest
        ): Kleisli[M, SsoAdminClient, PutInlinePolicyToPermissionSetResponse] =
          primitive(_.putInlinePolicyToPermissionSet(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SsoAdminClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SsoAdminClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateInstanceAccessControlAttributeConfiguration(
          request: UpdateInstanceAccessControlAttributeConfigurationRequest
        ): Kleisli[M, SsoAdminClient, UpdateInstanceAccessControlAttributeConfigurationResponse] =
          primitive(_.updateInstanceAccessControlAttributeConfiguration(request))

        def updatePermissionSet(
          request: UpdatePermissionSetRequest
        ): Kleisli[M, SsoAdminClient, UpdatePermissionSetResponse] =
          primitive(_.updatePermissionSet(request))

        def primitive[A](
          f: SsoAdminClient => A
        ): Kleisli[M, SsoAdminClient, A]
      }
    }

    trait Visitor[F[_]] extends (SsoAdminOp ~> F) {
      final def apply[A](op: SsoAdminOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def attachManagedPolicyToPermissionSet(
        request: AttachManagedPolicyToPermissionSetRequest
      ): F[AttachManagedPolicyToPermissionSetResponse]

      def createAccountAssignment(
        request: CreateAccountAssignmentRequest
      ): F[CreateAccountAssignmentResponse]

      def createInstanceAccessControlAttributeConfiguration(
        request: CreateInstanceAccessControlAttributeConfigurationRequest
      ): F[CreateInstanceAccessControlAttributeConfigurationResponse]

      def createPermissionSet(
        request: CreatePermissionSetRequest
      ): F[CreatePermissionSetResponse]

      def deleteAccountAssignment(
        request: DeleteAccountAssignmentRequest
      ): F[DeleteAccountAssignmentResponse]

      def deleteInlinePolicyFromPermissionSet(
        request: DeleteInlinePolicyFromPermissionSetRequest
      ): F[DeleteInlinePolicyFromPermissionSetResponse]

      def deleteInstanceAccessControlAttributeConfiguration(
        request: DeleteInstanceAccessControlAttributeConfigurationRequest
      ): F[DeleteInstanceAccessControlAttributeConfigurationResponse]

      def deletePermissionSet(
        request: DeletePermissionSetRequest
      ): F[DeletePermissionSetResponse]

      def describeAccountAssignmentCreationStatus(
        request: DescribeAccountAssignmentCreationStatusRequest
      ): F[DescribeAccountAssignmentCreationStatusResponse]

      def describeAccountAssignmentDeletionStatus(
        request: DescribeAccountAssignmentDeletionStatusRequest
      ): F[DescribeAccountAssignmentDeletionStatusResponse]

      def describeInstanceAccessControlAttributeConfiguration(
        request: DescribeInstanceAccessControlAttributeConfigurationRequest
      ): F[DescribeInstanceAccessControlAttributeConfigurationResponse]

      def describePermissionSet(
        request: DescribePermissionSetRequest
      ): F[DescribePermissionSetResponse]

      def describePermissionSetProvisioningStatus(
        request: DescribePermissionSetProvisioningStatusRequest
      ): F[DescribePermissionSetProvisioningStatusResponse]

      def detachManagedPolicyFromPermissionSet(
        request: DetachManagedPolicyFromPermissionSetRequest
      ): F[DetachManagedPolicyFromPermissionSetResponse]

      def getInlinePolicyForPermissionSet(
        request: GetInlinePolicyForPermissionSetRequest
      ): F[GetInlinePolicyForPermissionSetResponse]

      def listAccountAssignmentCreationStatus(
        request: ListAccountAssignmentCreationStatusRequest
      ): F[ListAccountAssignmentCreationStatusResponse]

      def listAccountAssignmentDeletionStatus(
        request: ListAccountAssignmentDeletionStatusRequest
      ): F[ListAccountAssignmentDeletionStatusResponse]

      def listAccountAssignments(
        request: ListAccountAssignmentsRequest
      ): F[ListAccountAssignmentsResponse]

      def listAccountsForProvisionedPermissionSet(
        request: ListAccountsForProvisionedPermissionSetRequest
      ): F[ListAccountsForProvisionedPermissionSetResponse]

      def listInstances(
        request: ListInstancesRequest
      ): F[ListInstancesResponse]

      def listManagedPoliciesInPermissionSet(
        request: ListManagedPoliciesInPermissionSetRequest
      ): F[ListManagedPoliciesInPermissionSetResponse]

      def listPermissionSetProvisioningStatus(
        request: ListPermissionSetProvisioningStatusRequest
      ): F[ListPermissionSetProvisioningStatusResponse]

      def listPermissionSets(
        request: ListPermissionSetsRequest
      ): F[ListPermissionSetsResponse]

      def listPermissionSetsProvisionedToAccount(
        request: ListPermissionSetsProvisionedToAccountRequest
      ): F[ListPermissionSetsProvisionedToAccountResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def provisionPermissionSet(
        request: ProvisionPermissionSetRequest
      ): F[ProvisionPermissionSetResponse]

      def putInlinePolicyToPermissionSet(
        request: PutInlinePolicyToPermissionSetRequest
      ): F[PutInlinePolicyToPermissionSetResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateInstanceAccessControlAttributeConfiguration(
        request: UpdateInstanceAccessControlAttributeConfigurationRequest
      ): F[UpdateInstanceAccessControlAttributeConfigurationResponse]

      def updatePermissionSet(
        request: UpdatePermissionSetRequest
      ): F[UpdatePermissionSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SsoAdminOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AttachManagedPolicyToPermissionSetOp(
      request: AttachManagedPolicyToPermissionSetRequest
    ) extends SsoAdminOp[AttachManagedPolicyToPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachManagedPolicyToPermissionSetResponse] =
        visitor.attachManagedPolicyToPermissionSet(request)
    }

    final case class CreateAccountAssignmentOp(
      request: CreateAccountAssignmentRequest
    ) extends SsoAdminOp[CreateAccountAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccountAssignmentResponse] =
        visitor.createAccountAssignment(request)
    }

    final case class CreateInstanceAccessControlAttributeConfigurationOp(
      request: CreateInstanceAccessControlAttributeConfigurationRequest
    ) extends SsoAdminOp[CreateInstanceAccessControlAttributeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceAccessControlAttributeConfigurationResponse] =
        visitor.createInstanceAccessControlAttributeConfiguration(request)
    }

    final case class CreatePermissionSetOp(
      request: CreatePermissionSetRequest
    ) extends SsoAdminOp[CreatePermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePermissionSetResponse] =
        visitor.createPermissionSet(request)
    }

    final case class DeleteAccountAssignmentOp(
      request: DeleteAccountAssignmentRequest
    ) extends SsoAdminOp[DeleteAccountAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountAssignmentResponse] =
        visitor.deleteAccountAssignment(request)
    }

    final case class DeleteInlinePolicyFromPermissionSetOp(
      request: DeleteInlinePolicyFromPermissionSetRequest
    ) extends SsoAdminOp[DeleteInlinePolicyFromPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInlinePolicyFromPermissionSetResponse] =
        visitor.deleteInlinePolicyFromPermissionSet(request)
    }

    final case class DeleteInstanceAccessControlAttributeConfigurationOp(
      request: DeleteInstanceAccessControlAttributeConfigurationRequest
    ) extends SsoAdminOp[DeleteInstanceAccessControlAttributeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceAccessControlAttributeConfigurationResponse] =
        visitor.deleteInstanceAccessControlAttributeConfiguration(request)
    }

    final case class DeletePermissionSetOp(
      request: DeletePermissionSetRequest
    ) extends SsoAdminOp[DeletePermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePermissionSetResponse] =
        visitor.deletePermissionSet(request)
    }

    final case class DescribeAccountAssignmentCreationStatusOp(
      request: DescribeAccountAssignmentCreationStatusRequest
    ) extends SsoAdminOp[DescribeAccountAssignmentCreationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAssignmentCreationStatusResponse] =
        visitor.describeAccountAssignmentCreationStatus(request)
    }

    final case class DescribeAccountAssignmentDeletionStatusOp(
      request: DescribeAccountAssignmentDeletionStatusRequest
    ) extends SsoAdminOp[DescribeAccountAssignmentDeletionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountAssignmentDeletionStatusResponse] =
        visitor.describeAccountAssignmentDeletionStatus(request)
    }

    final case class DescribeInstanceAccessControlAttributeConfigurationOp(
      request: DescribeInstanceAccessControlAttributeConfigurationRequest
    ) extends SsoAdminOp[DescribeInstanceAccessControlAttributeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceAccessControlAttributeConfigurationResponse] =
        visitor.describeInstanceAccessControlAttributeConfiguration(request)
    }

    final case class DescribePermissionSetOp(
      request: DescribePermissionSetRequest
    ) extends SsoAdminOp[DescribePermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePermissionSetResponse] =
        visitor.describePermissionSet(request)
    }

    final case class DescribePermissionSetProvisioningStatusOp(
      request: DescribePermissionSetProvisioningStatusRequest
    ) extends SsoAdminOp[DescribePermissionSetProvisioningStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePermissionSetProvisioningStatusResponse] =
        visitor.describePermissionSetProvisioningStatus(request)
    }

    final case class DetachManagedPolicyFromPermissionSetOp(
      request: DetachManagedPolicyFromPermissionSetRequest
    ) extends SsoAdminOp[DetachManagedPolicyFromPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachManagedPolicyFromPermissionSetResponse] =
        visitor.detachManagedPolicyFromPermissionSet(request)
    }

    final case class GetInlinePolicyForPermissionSetOp(
      request: GetInlinePolicyForPermissionSetRequest
    ) extends SsoAdminOp[GetInlinePolicyForPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInlinePolicyForPermissionSetResponse] =
        visitor.getInlinePolicyForPermissionSet(request)
    }

    final case class ListAccountAssignmentCreationStatusOp(
      request: ListAccountAssignmentCreationStatusRequest
    ) extends SsoAdminOp[ListAccountAssignmentCreationStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountAssignmentCreationStatusResponse] =
        visitor.listAccountAssignmentCreationStatus(request)
    }

    final case class ListAccountAssignmentDeletionStatusOp(
      request: ListAccountAssignmentDeletionStatusRequest
    ) extends SsoAdminOp[ListAccountAssignmentDeletionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountAssignmentDeletionStatusResponse] =
        visitor.listAccountAssignmentDeletionStatus(request)
    }

    final case class ListAccountAssignmentsOp(
      request: ListAccountAssignmentsRequest
    ) extends SsoAdminOp[ListAccountAssignmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountAssignmentsResponse] =
        visitor.listAccountAssignments(request)
    }

    final case class ListAccountsForProvisionedPermissionSetOp(
      request: ListAccountsForProvisionedPermissionSetRequest
    ) extends SsoAdminOp[ListAccountsForProvisionedPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountsForProvisionedPermissionSetResponse] =
        visitor.listAccountsForProvisionedPermissionSet(request)
    }

    final case class ListInstancesOp(
      request: ListInstancesRequest
    ) extends SsoAdminOp[ListInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstancesResponse] =
        visitor.listInstances(request)
    }

    final case class ListManagedPoliciesInPermissionSetOp(
      request: ListManagedPoliciesInPermissionSetRequest
    ) extends SsoAdminOp[ListManagedPoliciesInPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListManagedPoliciesInPermissionSetResponse] =
        visitor.listManagedPoliciesInPermissionSet(request)
    }

    final case class ListPermissionSetProvisioningStatusOp(
      request: ListPermissionSetProvisioningStatusRequest
    ) extends SsoAdminOp[ListPermissionSetProvisioningStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPermissionSetProvisioningStatusResponse] =
        visitor.listPermissionSetProvisioningStatus(request)
    }

    final case class ListPermissionSetsOp(
      request: ListPermissionSetsRequest
    ) extends SsoAdminOp[ListPermissionSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPermissionSetsResponse] =
        visitor.listPermissionSets(request)
    }

    final case class ListPermissionSetsProvisionedToAccountOp(
      request: ListPermissionSetsProvisionedToAccountRequest
    ) extends SsoAdminOp[ListPermissionSetsProvisionedToAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPermissionSetsProvisionedToAccountResponse] =
        visitor.listPermissionSetsProvisionedToAccount(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SsoAdminOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ProvisionPermissionSetOp(
      request: ProvisionPermissionSetRequest
    ) extends SsoAdminOp[ProvisionPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ProvisionPermissionSetResponse] =
        visitor.provisionPermissionSet(request)
    }

    final case class PutInlinePolicyToPermissionSetOp(
      request: PutInlinePolicyToPermissionSetRequest
    ) extends SsoAdminOp[PutInlinePolicyToPermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutInlinePolicyToPermissionSetResponse] =
        visitor.putInlinePolicyToPermissionSet(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SsoAdminOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SsoAdminOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateInstanceAccessControlAttributeConfigurationOp(
      request: UpdateInstanceAccessControlAttributeConfigurationRequest
    ) extends SsoAdminOp[UpdateInstanceAccessControlAttributeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInstanceAccessControlAttributeConfigurationResponse] =
        visitor.updateInstanceAccessControlAttributeConfiguration(request)
    }

    final case class UpdatePermissionSetOp(
      request: UpdatePermissionSetRequest
    ) extends SsoAdminOp[UpdatePermissionSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePermissionSetResponse] =
        visitor.updatePermissionSet(request)
    }
  }

  import SsoAdminOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SsoAdminOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def attachManagedPolicyToPermissionSet(
    request: AttachManagedPolicyToPermissionSetRequest
  ): SsoAdminIO[AttachManagedPolicyToPermissionSetResponse] =
    FF.liftF(AttachManagedPolicyToPermissionSetOp(request))

  def createAccountAssignment(
    request: CreateAccountAssignmentRequest
  ): SsoAdminIO[CreateAccountAssignmentResponse] =
    FF.liftF(CreateAccountAssignmentOp(request))

  def createInstanceAccessControlAttributeConfiguration(
    request: CreateInstanceAccessControlAttributeConfigurationRequest
  ): SsoAdminIO[CreateInstanceAccessControlAttributeConfigurationResponse] =
    FF.liftF(CreateInstanceAccessControlAttributeConfigurationOp(request))

  def createPermissionSet(
    request: CreatePermissionSetRequest
  ): SsoAdminIO[CreatePermissionSetResponse] =
    FF.liftF(CreatePermissionSetOp(request))

  def deleteAccountAssignment(
    request: DeleteAccountAssignmentRequest
  ): SsoAdminIO[DeleteAccountAssignmentResponse] =
    FF.liftF(DeleteAccountAssignmentOp(request))

  def deleteInlinePolicyFromPermissionSet(
    request: DeleteInlinePolicyFromPermissionSetRequest
  ): SsoAdminIO[DeleteInlinePolicyFromPermissionSetResponse] =
    FF.liftF(DeleteInlinePolicyFromPermissionSetOp(request))

  def deleteInstanceAccessControlAttributeConfiguration(
    request: DeleteInstanceAccessControlAttributeConfigurationRequest
  ): SsoAdminIO[DeleteInstanceAccessControlAttributeConfigurationResponse] =
    FF.liftF(DeleteInstanceAccessControlAttributeConfigurationOp(request))

  def deletePermissionSet(
    request: DeletePermissionSetRequest
  ): SsoAdminIO[DeletePermissionSetResponse] =
    FF.liftF(DeletePermissionSetOp(request))

  def describeAccountAssignmentCreationStatus(
    request: DescribeAccountAssignmentCreationStatusRequest
  ): SsoAdminIO[DescribeAccountAssignmentCreationStatusResponse] =
    FF.liftF(DescribeAccountAssignmentCreationStatusOp(request))

  def describeAccountAssignmentDeletionStatus(
    request: DescribeAccountAssignmentDeletionStatusRequest
  ): SsoAdminIO[DescribeAccountAssignmentDeletionStatusResponse] =
    FF.liftF(DescribeAccountAssignmentDeletionStatusOp(request))

  def describeInstanceAccessControlAttributeConfiguration(
    request: DescribeInstanceAccessControlAttributeConfigurationRequest
  ): SsoAdminIO[DescribeInstanceAccessControlAttributeConfigurationResponse] =
    FF.liftF(DescribeInstanceAccessControlAttributeConfigurationOp(request))

  def describePermissionSet(
    request: DescribePermissionSetRequest
  ): SsoAdminIO[DescribePermissionSetResponse] =
    FF.liftF(DescribePermissionSetOp(request))

  def describePermissionSetProvisioningStatus(
    request: DescribePermissionSetProvisioningStatusRequest
  ): SsoAdminIO[DescribePermissionSetProvisioningStatusResponse] =
    FF.liftF(DescribePermissionSetProvisioningStatusOp(request))

  def detachManagedPolicyFromPermissionSet(
    request: DetachManagedPolicyFromPermissionSetRequest
  ): SsoAdminIO[DetachManagedPolicyFromPermissionSetResponse] =
    FF.liftF(DetachManagedPolicyFromPermissionSetOp(request))

  def getInlinePolicyForPermissionSet(
    request: GetInlinePolicyForPermissionSetRequest
  ): SsoAdminIO[GetInlinePolicyForPermissionSetResponse] =
    FF.liftF(GetInlinePolicyForPermissionSetOp(request))

  def listAccountAssignmentCreationStatus(
    request: ListAccountAssignmentCreationStatusRequest
  ): SsoAdminIO[ListAccountAssignmentCreationStatusResponse] =
    FF.liftF(ListAccountAssignmentCreationStatusOp(request))

  def listAccountAssignmentDeletionStatus(
    request: ListAccountAssignmentDeletionStatusRequest
  ): SsoAdminIO[ListAccountAssignmentDeletionStatusResponse] =
    FF.liftF(ListAccountAssignmentDeletionStatusOp(request))

  def listAccountAssignments(
    request: ListAccountAssignmentsRequest
  ): SsoAdminIO[ListAccountAssignmentsResponse] =
    FF.liftF(ListAccountAssignmentsOp(request))

  def listAccountsForProvisionedPermissionSet(
    request: ListAccountsForProvisionedPermissionSetRequest
  ): SsoAdminIO[ListAccountsForProvisionedPermissionSetResponse] =
    FF.liftF(ListAccountsForProvisionedPermissionSetOp(request))

  def listInstances(
    request: ListInstancesRequest
  ): SsoAdminIO[ListInstancesResponse] =
    FF.liftF(ListInstancesOp(request))

  def listManagedPoliciesInPermissionSet(
    request: ListManagedPoliciesInPermissionSetRequest
  ): SsoAdminIO[ListManagedPoliciesInPermissionSetResponse] =
    FF.liftF(ListManagedPoliciesInPermissionSetOp(request))

  def listPermissionSetProvisioningStatus(
    request: ListPermissionSetProvisioningStatusRequest
  ): SsoAdminIO[ListPermissionSetProvisioningStatusResponse] =
    FF.liftF(ListPermissionSetProvisioningStatusOp(request))

  def listPermissionSets(
    request: ListPermissionSetsRequest
  ): SsoAdminIO[ListPermissionSetsResponse] =
    FF.liftF(ListPermissionSetsOp(request))

  def listPermissionSetsProvisionedToAccount(
    request: ListPermissionSetsProvisionedToAccountRequest
  ): SsoAdminIO[ListPermissionSetsProvisionedToAccountResponse] =
    FF.liftF(ListPermissionSetsProvisionedToAccountOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SsoAdminIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def provisionPermissionSet(
    request: ProvisionPermissionSetRequest
  ): SsoAdminIO[ProvisionPermissionSetResponse] =
    FF.liftF(ProvisionPermissionSetOp(request))

  def putInlinePolicyToPermissionSet(
    request: PutInlinePolicyToPermissionSetRequest
  ): SsoAdminIO[PutInlinePolicyToPermissionSetResponse] =
    FF.liftF(PutInlinePolicyToPermissionSetOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SsoAdminIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SsoAdminIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateInstanceAccessControlAttributeConfiguration(
    request: UpdateInstanceAccessControlAttributeConfigurationRequest
  ): SsoAdminIO[UpdateInstanceAccessControlAttributeConfigurationResponse] =
    FF.liftF(UpdateInstanceAccessControlAttributeConfigurationOp(request))

  def updatePermissionSet(
    request: UpdatePermissionSetRequest
  ): SsoAdminIO[UpdatePermissionSetResponse] =
    FF.liftF(UpdatePermissionSetOp(request))
}
