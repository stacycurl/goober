package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.workmail.WorkMailClient
import software.amazon.awssdk.services.workmail.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object workmail { module =>

  // Free monad over WorkMailOp
  type WorkMailIO[A] = FF[WorkMailOp, A]

  sealed trait WorkMailOp[A] {
    def visit[F[_]](visitor: WorkMailOp.Visitor[F]): F[A]
  }

  object WorkMailOp {
    // Given a WorkMailClient we can embed a WorkMailIO program in any algebra that understands embedding.
    implicit val WorkMailOpEmbeddable: Embeddable[WorkMailOp, WorkMailClient] = new Embeddable[WorkMailOp, WorkMailClient] {
      def embed[A](client: WorkMailClient, io: WorkMailIO[A]): Embedded[A] = Embedded.WorkMail(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WorkMailOp.Visitor[Kleisli[M, WorkMailClient, *]] {
        def associateDelegateToResource(
          request: AssociateDelegateToResourceRequest
        ): Kleisli[M, WorkMailClient, AssociateDelegateToResourceResponse] =
          primitive(_.associateDelegateToResource(request))

        def associateMemberToGroup(
          request: AssociateMemberToGroupRequest
        ): Kleisli[M, WorkMailClient, AssociateMemberToGroupResponse] =
          primitive(_.associateMemberToGroup(request))

        def cancelMailboxExportJob(
          request: CancelMailboxExportJobRequest
        ): Kleisli[M, WorkMailClient, CancelMailboxExportJobResponse] =
          primitive(_.cancelMailboxExportJob(request))

        def createAlias(
          request: CreateAliasRequest
        ): Kleisli[M, WorkMailClient, CreateAliasResponse] =
          primitive(_.createAlias(request))

        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, WorkMailClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def createMobileDeviceAccessRule(
          request: CreateMobileDeviceAccessRuleRequest
        ): Kleisli[M, WorkMailClient, CreateMobileDeviceAccessRuleResponse] =
          primitive(_.createMobileDeviceAccessRule(request))

        def createOrganization(
          request: CreateOrganizationRequest
        ): Kleisli[M, WorkMailClient, CreateOrganizationResponse] =
          primitive(_.createOrganization(request))

        def createResource(
          request: CreateResourceRequest
        ): Kleisli[M, WorkMailClient, CreateResourceResponse] =
          primitive(_.createResource(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, WorkMailClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def deleteAccessControlRule(
          request: DeleteAccessControlRuleRequest
        ): Kleisli[M, WorkMailClient, DeleteAccessControlRuleResponse] =
          primitive(_.deleteAccessControlRule(request))

        def deleteAlias(
          request: DeleteAliasRequest
        ): Kleisli[M, WorkMailClient, DeleteAliasResponse] =
          primitive(_.deleteAlias(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, WorkMailClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def deleteMailboxPermissions(
          request: DeleteMailboxPermissionsRequest
        ): Kleisli[M, WorkMailClient, DeleteMailboxPermissionsResponse] =
          primitive(_.deleteMailboxPermissions(request))

        def deleteMobileDeviceAccessRule(
          request: DeleteMobileDeviceAccessRuleRequest
        ): Kleisli[M, WorkMailClient, DeleteMobileDeviceAccessRuleResponse] =
          primitive(_.deleteMobileDeviceAccessRule(request))

        def deleteOrganization(
          request: DeleteOrganizationRequest
        ): Kleisli[M, WorkMailClient, DeleteOrganizationResponse] =
          primitive(_.deleteOrganization(request))

        def deleteResource(
          request: DeleteResourceRequest
        ): Kleisli[M, WorkMailClient, DeleteResourceResponse] =
          primitive(_.deleteResource(request))

        def deleteRetentionPolicy(
          request: DeleteRetentionPolicyRequest
        ): Kleisli[M, WorkMailClient, DeleteRetentionPolicyResponse] =
          primitive(_.deleteRetentionPolicy(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, WorkMailClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def deregisterFromWorkMail(
          request: DeregisterFromWorkMailRequest
        ): Kleisli[M, WorkMailClient, DeregisterFromWorkMailResponse] =
          primitive(_.deregisterFromWorkMail(request))

        def describeGroup(
          request: DescribeGroupRequest
        ): Kleisli[M, WorkMailClient, DescribeGroupResponse] =
          primitive(_.describeGroup(request))

        def describeMailboxExportJob(
          request: DescribeMailboxExportJobRequest
        ): Kleisli[M, WorkMailClient, DescribeMailboxExportJobResponse] =
          primitive(_.describeMailboxExportJob(request))

        def describeOrganization(
          request: DescribeOrganizationRequest
        ): Kleisli[M, WorkMailClient, DescribeOrganizationResponse] =
          primitive(_.describeOrganization(request))

        def describeResource(
          request: DescribeResourceRequest
        ): Kleisli[M, WorkMailClient, DescribeResourceResponse] =
          primitive(_.describeResource(request))

        def describeUser(
          request: DescribeUserRequest
        ): Kleisli[M, WorkMailClient, DescribeUserResponse] =
          primitive(_.describeUser(request))

        def disassociateDelegateFromResource(
          request: DisassociateDelegateFromResourceRequest
        ): Kleisli[M, WorkMailClient, DisassociateDelegateFromResourceResponse] =
          primitive(_.disassociateDelegateFromResource(request))

        def disassociateMemberFromGroup(
          request: DisassociateMemberFromGroupRequest
        ): Kleisli[M, WorkMailClient, DisassociateMemberFromGroupResponse] =
          primitive(_.disassociateMemberFromGroup(request))

        def getAccessControlEffect(
          request: GetAccessControlEffectRequest
        ): Kleisli[M, WorkMailClient, GetAccessControlEffectResponse] =
          primitive(_.getAccessControlEffect(request))

        def getDefaultRetentionPolicy(
          request: GetDefaultRetentionPolicyRequest
        ): Kleisli[M, WorkMailClient, GetDefaultRetentionPolicyResponse] =
          primitive(_.getDefaultRetentionPolicy(request))

        def getMailboxDetails(
          request: GetMailboxDetailsRequest
        ): Kleisli[M, WorkMailClient, GetMailboxDetailsResponse] =
          primitive(_.getMailboxDetails(request))

        def getMobileDeviceAccessEffect(
          request: GetMobileDeviceAccessEffectRequest
        ): Kleisli[M, WorkMailClient, GetMobileDeviceAccessEffectResponse] =
          primitive(_.getMobileDeviceAccessEffect(request))

        def listAccessControlRules(
          request: ListAccessControlRulesRequest
        ): Kleisli[M, WorkMailClient, ListAccessControlRulesResponse] =
          primitive(_.listAccessControlRules(request))

        def listAliases(
          request: ListAliasesRequest
        ): Kleisli[M, WorkMailClient, ListAliasesResponse] =
          primitive(_.listAliases(request))

        def listGroupMembers(
          request: ListGroupMembersRequest
        ): Kleisli[M, WorkMailClient, ListGroupMembersResponse] =
          primitive(_.listGroupMembers(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, WorkMailClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def listMailboxExportJobs(
          request: ListMailboxExportJobsRequest
        ): Kleisli[M, WorkMailClient, ListMailboxExportJobsResponse] =
          primitive(_.listMailboxExportJobs(request))

        def listMailboxPermissions(
          request: ListMailboxPermissionsRequest
        ): Kleisli[M, WorkMailClient, ListMailboxPermissionsResponse] =
          primitive(_.listMailboxPermissions(request))

        def listMobileDeviceAccessRules(
          request: ListMobileDeviceAccessRulesRequest
        ): Kleisli[M, WorkMailClient, ListMobileDeviceAccessRulesResponse] =
          primitive(_.listMobileDeviceAccessRules(request))

        def listOrganizations(
          request: ListOrganizationsRequest
        ): Kleisli[M, WorkMailClient, ListOrganizationsResponse] =
          primitive(_.listOrganizations(request))

        def listResourceDelegates(
          request: ListResourceDelegatesRequest
        ): Kleisli[M, WorkMailClient, ListResourceDelegatesResponse] =
          primitive(_.listResourceDelegates(request))

        def listResources(
          request: ListResourcesRequest
        ): Kleisli[M, WorkMailClient, ListResourcesResponse] =
          primitive(_.listResources(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, WorkMailClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, WorkMailClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def putAccessControlRule(
          request: PutAccessControlRuleRequest
        ): Kleisli[M, WorkMailClient, PutAccessControlRuleResponse] =
          primitive(_.putAccessControlRule(request))

        def putMailboxPermissions(
          request: PutMailboxPermissionsRequest
        ): Kleisli[M, WorkMailClient, PutMailboxPermissionsResponse] =
          primitive(_.putMailboxPermissions(request))

        def putRetentionPolicy(
          request: PutRetentionPolicyRequest
        ): Kleisli[M, WorkMailClient, PutRetentionPolicyResponse] =
          primitive(_.putRetentionPolicy(request))

        def registerToWorkMail(
          request: RegisterToWorkMailRequest
        ): Kleisli[M, WorkMailClient, RegisterToWorkMailResponse] =
          primitive(_.registerToWorkMail(request))

        def resetPassword(
          request: ResetPasswordRequest
        ): Kleisli[M, WorkMailClient, ResetPasswordResponse] =
          primitive(_.resetPassword(request))

        def startMailboxExportJob(
          request: StartMailboxExportJobRequest
        ): Kleisli[M, WorkMailClient, StartMailboxExportJobResponse] =
          primitive(_.startMailboxExportJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, WorkMailClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, WorkMailClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateMailboxQuota(
          request: UpdateMailboxQuotaRequest
        ): Kleisli[M, WorkMailClient, UpdateMailboxQuotaResponse] =
          primitive(_.updateMailboxQuota(request))

        def updateMobileDeviceAccessRule(
          request: UpdateMobileDeviceAccessRuleRequest
        ): Kleisli[M, WorkMailClient, UpdateMobileDeviceAccessRuleResponse] =
          primitive(_.updateMobileDeviceAccessRule(request))

        def updatePrimaryEmailAddress(
          request: UpdatePrimaryEmailAddressRequest
        ): Kleisli[M, WorkMailClient, UpdatePrimaryEmailAddressResponse] =
          primitive(_.updatePrimaryEmailAddress(request))

        def updateResource(
          request: UpdateResourceRequest
        ): Kleisli[M, WorkMailClient, UpdateResourceResponse] =
          primitive(_.updateResource(request))

        def primitive[A](
          f: WorkMailClient => A
        ): Kleisli[M, WorkMailClient, A]
      }
    }

    trait Visitor[F[_]] extends (WorkMailOp ~> F) {
      final def apply[A](op: WorkMailOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateDelegateToResource(
        request: AssociateDelegateToResourceRequest
      ): F[AssociateDelegateToResourceResponse]

      def associateMemberToGroup(
        request: AssociateMemberToGroupRequest
      ): F[AssociateMemberToGroupResponse]

      def cancelMailboxExportJob(
        request: CancelMailboxExportJobRequest
      ): F[CancelMailboxExportJobResponse]

      def createAlias(
        request: CreateAliasRequest
      ): F[CreateAliasResponse]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def createMobileDeviceAccessRule(
        request: CreateMobileDeviceAccessRuleRequest
      ): F[CreateMobileDeviceAccessRuleResponse]

      def createOrganization(
        request: CreateOrganizationRequest
      ): F[CreateOrganizationResponse]

      def createResource(
        request: CreateResourceRequest
      ): F[CreateResourceResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def deleteAccessControlRule(
        request: DeleteAccessControlRuleRequest
      ): F[DeleteAccessControlRuleResponse]

      def deleteAlias(
        request: DeleteAliasRequest
      ): F[DeleteAliasResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def deleteMailboxPermissions(
        request: DeleteMailboxPermissionsRequest
      ): F[DeleteMailboxPermissionsResponse]

      def deleteMobileDeviceAccessRule(
        request: DeleteMobileDeviceAccessRuleRequest
      ): F[DeleteMobileDeviceAccessRuleResponse]

      def deleteOrganization(
        request: DeleteOrganizationRequest
      ): F[DeleteOrganizationResponse]

      def deleteResource(
        request: DeleteResourceRequest
      ): F[DeleteResourceResponse]

      def deleteRetentionPolicy(
        request: DeleteRetentionPolicyRequest
      ): F[DeleteRetentionPolicyResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def deregisterFromWorkMail(
        request: DeregisterFromWorkMailRequest
      ): F[DeregisterFromWorkMailResponse]

      def describeGroup(
        request: DescribeGroupRequest
      ): F[DescribeGroupResponse]

      def describeMailboxExportJob(
        request: DescribeMailboxExportJobRequest
      ): F[DescribeMailboxExportJobResponse]

      def describeOrganization(
        request: DescribeOrganizationRequest
      ): F[DescribeOrganizationResponse]

      def describeResource(
        request: DescribeResourceRequest
      ): F[DescribeResourceResponse]

      def describeUser(
        request: DescribeUserRequest
      ): F[DescribeUserResponse]

      def disassociateDelegateFromResource(
        request: DisassociateDelegateFromResourceRequest
      ): F[DisassociateDelegateFromResourceResponse]

      def disassociateMemberFromGroup(
        request: DisassociateMemberFromGroupRequest
      ): F[DisassociateMemberFromGroupResponse]

      def getAccessControlEffect(
        request: GetAccessControlEffectRequest
      ): F[GetAccessControlEffectResponse]

      def getDefaultRetentionPolicy(
        request: GetDefaultRetentionPolicyRequest
      ): F[GetDefaultRetentionPolicyResponse]

      def getMailboxDetails(
        request: GetMailboxDetailsRequest
      ): F[GetMailboxDetailsResponse]

      def getMobileDeviceAccessEffect(
        request: GetMobileDeviceAccessEffectRequest
      ): F[GetMobileDeviceAccessEffectResponse]

      def listAccessControlRules(
        request: ListAccessControlRulesRequest
      ): F[ListAccessControlRulesResponse]

      def listAliases(
        request: ListAliasesRequest
      ): F[ListAliasesResponse]

      def listGroupMembers(
        request: ListGroupMembersRequest
      ): F[ListGroupMembersResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def listMailboxExportJobs(
        request: ListMailboxExportJobsRequest
      ): F[ListMailboxExportJobsResponse]

      def listMailboxPermissions(
        request: ListMailboxPermissionsRequest
      ): F[ListMailboxPermissionsResponse]

      def listMobileDeviceAccessRules(
        request: ListMobileDeviceAccessRulesRequest
      ): F[ListMobileDeviceAccessRulesResponse]

      def listOrganizations(
        request: ListOrganizationsRequest
      ): F[ListOrganizationsResponse]

      def listResourceDelegates(
        request: ListResourceDelegatesRequest
      ): F[ListResourceDelegatesResponse]

      def listResources(
        request: ListResourcesRequest
      ): F[ListResourcesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def putAccessControlRule(
        request: PutAccessControlRuleRequest
      ): F[PutAccessControlRuleResponse]

      def putMailboxPermissions(
        request: PutMailboxPermissionsRequest
      ): F[PutMailboxPermissionsResponse]

      def putRetentionPolicy(
        request: PutRetentionPolicyRequest
      ): F[PutRetentionPolicyResponse]

      def registerToWorkMail(
        request: RegisterToWorkMailRequest
      ): F[RegisterToWorkMailResponse]

      def resetPassword(
        request: ResetPasswordRequest
      ): F[ResetPasswordResponse]

      def startMailboxExportJob(
        request: StartMailboxExportJobRequest
      ): F[StartMailboxExportJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateMailboxQuota(
        request: UpdateMailboxQuotaRequest
      ): F[UpdateMailboxQuotaResponse]

      def updateMobileDeviceAccessRule(
        request: UpdateMobileDeviceAccessRuleRequest
      ): F[UpdateMobileDeviceAccessRuleResponse]

      def updatePrimaryEmailAddress(
        request: UpdatePrimaryEmailAddressRequest
      ): F[UpdatePrimaryEmailAddressResponse]

      def updateResource(
        request: UpdateResourceRequest
      ): F[UpdateResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WorkMailOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateDelegateToResourceOp(
      request: AssociateDelegateToResourceRequest
    ) extends WorkMailOp[AssociateDelegateToResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDelegateToResourceResponse] =
        visitor.associateDelegateToResource(request)
    }

    final case class AssociateMemberToGroupOp(
      request: AssociateMemberToGroupRequest
    ) extends WorkMailOp[AssociateMemberToGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateMemberToGroupResponse] =
        visitor.associateMemberToGroup(request)
    }

    final case class CancelMailboxExportJobOp(
      request: CancelMailboxExportJobRequest
    ) extends WorkMailOp[CancelMailboxExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelMailboxExportJobResponse] =
        visitor.cancelMailboxExportJob(request)
    }

    final case class CreateAliasOp(
      request: CreateAliasRequest
    ) extends WorkMailOp[CreateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAliasResponse] =
        visitor.createAlias(request)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends WorkMailOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class CreateMobileDeviceAccessRuleOp(
      request: CreateMobileDeviceAccessRuleRequest
    ) extends WorkMailOp[CreateMobileDeviceAccessRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMobileDeviceAccessRuleResponse] =
        visitor.createMobileDeviceAccessRule(request)
    }

    final case class CreateOrganizationOp(
      request: CreateOrganizationRequest
    ) extends WorkMailOp[CreateOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOrganizationResponse] =
        visitor.createOrganization(request)
    }

    final case class CreateResourceOp(
      request: CreateResourceRequest
    ) extends WorkMailOp[CreateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceResponse] =
        visitor.createResource(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends WorkMailOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class DeleteAccessControlRuleOp(
      request: DeleteAccessControlRuleRequest
    ) extends WorkMailOp[DeleteAccessControlRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessControlRuleResponse] =
        visitor.deleteAccessControlRule(request)
    }

    final case class DeleteAliasOp(
      request: DeleteAliasRequest
    ) extends WorkMailOp[DeleteAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAliasResponse] =
        visitor.deleteAlias(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends WorkMailOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class DeleteMailboxPermissionsOp(
      request: DeleteMailboxPermissionsRequest
    ) extends WorkMailOp[DeleteMailboxPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMailboxPermissionsResponse] =
        visitor.deleteMailboxPermissions(request)
    }

    final case class DeleteMobileDeviceAccessRuleOp(
      request: DeleteMobileDeviceAccessRuleRequest
    ) extends WorkMailOp[DeleteMobileDeviceAccessRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMobileDeviceAccessRuleResponse] =
        visitor.deleteMobileDeviceAccessRule(request)
    }

    final case class DeleteOrganizationOp(
      request: DeleteOrganizationRequest
    ) extends WorkMailOp[DeleteOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOrganizationResponse] =
        visitor.deleteOrganization(request)
    }

    final case class DeleteResourceOp(
      request: DeleteResourceRequest
    ) extends WorkMailOp[DeleteResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceResponse] =
        visitor.deleteResource(request)
    }

    final case class DeleteRetentionPolicyOp(
      request: DeleteRetentionPolicyRequest
    ) extends WorkMailOp[DeleteRetentionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRetentionPolicyResponse] =
        visitor.deleteRetentionPolicy(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends WorkMailOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DeregisterFromWorkMailOp(
      request: DeregisterFromWorkMailRequest
    ) extends WorkMailOp[DeregisterFromWorkMailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterFromWorkMailResponse] =
        visitor.deregisterFromWorkMail(request)
    }

    final case class DescribeGroupOp(
      request: DescribeGroupRequest
    ) extends WorkMailOp[DescribeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGroupResponse] =
        visitor.describeGroup(request)
    }

    final case class DescribeMailboxExportJobOp(
      request: DescribeMailboxExportJobRequest
    ) extends WorkMailOp[DescribeMailboxExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMailboxExportJobResponse] =
        visitor.describeMailboxExportJob(request)
    }

    final case class DescribeOrganizationOp(
      request: DescribeOrganizationRequest
    ) extends WorkMailOp[DescribeOrganizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeOrganizationResponse] =
        visitor.describeOrganization(request)
    }

    final case class DescribeResourceOp(
      request: DescribeResourceRequest
    ) extends WorkMailOp[DescribeResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourceResponse] =
        visitor.describeResource(request)
    }

    final case class DescribeUserOp(
      request: DescribeUserRequest
    ) extends WorkMailOp[DescribeUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserResponse] =
        visitor.describeUser(request)
    }

    final case class DisassociateDelegateFromResourceOp(
      request: DisassociateDelegateFromResourceRequest
    ) extends WorkMailOp[DisassociateDelegateFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDelegateFromResourceResponse] =
        visitor.disassociateDelegateFromResource(request)
    }

    final case class DisassociateMemberFromGroupOp(
      request: DisassociateMemberFromGroupRequest
    ) extends WorkMailOp[DisassociateMemberFromGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateMemberFromGroupResponse] =
        visitor.disassociateMemberFromGroup(request)
    }

    final case class GetAccessControlEffectOp(
      request: GetAccessControlEffectRequest
    ) extends WorkMailOp[GetAccessControlEffectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessControlEffectResponse] =
        visitor.getAccessControlEffect(request)
    }

    final case class GetDefaultRetentionPolicyOp(
      request: GetDefaultRetentionPolicyRequest
    ) extends WorkMailOp[GetDefaultRetentionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDefaultRetentionPolicyResponse] =
        visitor.getDefaultRetentionPolicy(request)
    }

    final case class GetMailboxDetailsOp(
      request: GetMailboxDetailsRequest
    ) extends WorkMailOp[GetMailboxDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMailboxDetailsResponse] =
        visitor.getMailboxDetails(request)
    }

    final case class GetMobileDeviceAccessEffectOp(
      request: GetMobileDeviceAccessEffectRequest
    ) extends WorkMailOp[GetMobileDeviceAccessEffectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMobileDeviceAccessEffectResponse] =
        visitor.getMobileDeviceAccessEffect(request)
    }

    final case class ListAccessControlRulesOp(
      request: ListAccessControlRulesRequest
    ) extends WorkMailOp[ListAccessControlRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessControlRulesResponse] =
        visitor.listAccessControlRules(request)
    }

    final case class ListAliasesOp(
      request: ListAliasesRequest
    ) extends WorkMailOp[ListAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAliasesResponse] =
        visitor.listAliases(request)
    }

    final case class ListGroupMembersOp(
      request: ListGroupMembersRequest
    ) extends WorkMailOp[ListGroupMembersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupMembersResponse] =
        visitor.listGroupMembers(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends WorkMailOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class ListMailboxExportJobsOp(
      request: ListMailboxExportJobsRequest
    ) extends WorkMailOp[ListMailboxExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMailboxExportJobsResponse] =
        visitor.listMailboxExportJobs(request)
    }

    final case class ListMailboxPermissionsOp(
      request: ListMailboxPermissionsRequest
    ) extends WorkMailOp[ListMailboxPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMailboxPermissionsResponse] =
        visitor.listMailboxPermissions(request)
    }

    final case class ListMobileDeviceAccessRulesOp(
      request: ListMobileDeviceAccessRulesRequest
    ) extends WorkMailOp[ListMobileDeviceAccessRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMobileDeviceAccessRulesResponse] =
        visitor.listMobileDeviceAccessRules(request)
    }

    final case class ListOrganizationsOp(
      request: ListOrganizationsRequest
    ) extends WorkMailOp[ListOrganizationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOrganizationsResponse] =
        visitor.listOrganizations(request)
    }

    final case class ListResourceDelegatesOp(
      request: ListResourceDelegatesRequest
    ) extends WorkMailOp[ListResourceDelegatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceDelegatesResponse] =
        visitor.listResourceDelegates(request)
    }

    final case class ListResourcesOp(
      request: ListResourcesRequest
    ) extends WorkMailOp[ListResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesResponse] =
        visitor.listResources(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends WorkMailOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends WorkMailOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class PutAccessControlRuleOp(
      request: PutAccessControlRuleRequest
    ) extends WorkMailOp[PutAccessControlRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccessControlRuleResponse] =
        visitor.putAccessControlRule(request)
    }

    final case class PutMailboxPermissionsOp(
      request: PutMailboxPermissionsRequest
    ) extends WorkMailOp[PutMailboxPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutMailboxPermissionsResponse] =
        visitor.putMailboxPermissions(request)
    }

    final case class PutRetentionPolicyOp(
      request: PutRetentionPolicyRequest
    ) extends WorkMailOp[PutRetentionPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRetentionPolicyResponse] =
        visitor.putRetentionPolicy(request)
    }

    final case class RegisterToWorkMailOp(
      request: RegisterToWorkMailRequest
    ) extends WorkMailOp[RegisterToWorkMailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterToWorkMailResponse] =
        visitor.registerToWorkMail(request)
    }

    final case class ResetPasswordOp(
      request: ResetPasswordRequest
    ) extends WorkMailOp[ResetPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetPasswordResponse] =
        visitor.resetPassword(request)
    }

    final case class StartMailboxExportJobOp(
      request: StartMailboxExportJobRequest
    ) extends WorkMailOp[StartMailboxExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMailboxExportJobResponse] =
        visitor.startMailboxExportJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends WorkMailOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends WorkMailOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateMailboxQuotaOp(
      request: UpdateMailboxQuotaRequest
    ) extends WorkMailOp[UpdateMailboxQuotaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMailboxQuotaResponse] =
        visitor.updateMailboxQuota(request)
    }

    final case class UpdateMobileDeviceAccessRuleOp(
      request: UpdateMobileDeviceAccessRuleRequest
    ) extends WorkMailOp[UpdateMobileDeviceAccessRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMobileDeviceAccessRuleResponse] =
        visitor.updateMobileDeviceAccessRule(request)
    }

    final case class UpdatePrimaryEmailAddressOp(
      request: UpdatePrimaryEmailAddressRequest
    ) extends WorkMailOp[UpdatePrimaryEmailAddressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePrimaryEmailAddressResponse] =
        visitor.updatePrimaryEmailAddress(request)
    }

    final case class UpdateResourceOp(
      request: UpdateResourceRequest
    ) extends WorkMailOp[UpdateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceResponse] =
        visitor.updateResource(request)
    }
  }

  import WorkMailOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WorkMailOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateDelegateToResource(
    request: AssociateDelegateToResourceRequest
  ): WorkMailIO[AssociateDelegateToResourceResponse] =
    FF.liftF(AssociateDelegateToResourceOp(request))

  def associateMemberToGroup(
    request: AssociateMemberToGroupRequest
  ): WorkMailIO[AssociateMemberToGroupResponse] =
    FF.liftF(AssociateMemberToGroupOp(request))

  def cancelMailboxExportJob(
    request: CancelMailboxExportJobRequest
  ): WorkMailIO[CancelMailboxExportJobResponse] =
    FF.liftF(CancelMailboxExportJobOp(request))

  def createAlias(
    request: CreateAliasRequest
  ): WorkMailIO[CreateAliasResponse] =
    FF.liftF(CreateAliasOp(request))

  def createGroup(
    request: CreateGroupRequest
  ): WorkMailIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def createMobileDeviceAccessRule(
    request: CreateMobileDeviceAccessRuleRequest
  ): WorkMailIO[CreateMobileDeviceAccessRuleResponse] =
    FF.liftF(CreateMobileDeviceAccessRuleOp(request))

  def createOrganization(
    request: CreateOrganizationRequest
  ): WorkMailIO[CreateOrganizationResponse] =
    FF.liftF(CreateOrganizationOp(request))

  def createResource(
    request: CreateResourceRequest
  ): WorkMailIO[CreateResourceResponse] =
    FF.liftF(CreateResourceOp(request))

  def createUser(
    request: CreateUserRequest
  ): WorkMailIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def deleteAccessControlRule(
    request: DeleteAccessControlRuleRequest
  ): WorkMailIO[DeleteAccessControlRuleResponse] =
    FF.liftF(DeleteAccessControlRuleOp(request))

  def deleteAlias(
    request: DeleteAliasRequest
  ): WorkMailIO[DeleteAliasResponse] =
    FF.liftF(DeleteAliasOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): WorkMailIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def deleteMailboxPermissions(
    request: DeleteMailboxPermissionsRequest
  ): WorkMailIO[DeleteMailboxPermissionsResponse] =
    FF.liftF(DeleteMailboxPermissionsOp(request))

  def deleteMobileDeviceAccessRule(
    request: DeleteMobileDeviceAccessRuleRequest
  ): WorkMailIO[DeleteMobileDeviceAccessRuleResponse] =
    FF.liftF(DeleteMobileDeviceAccessRuleOp(request))

  def deleteOrganization(
    request: DeleteOrganizationRequest
  ): WorkMailIO[DeleteOrganizationResponse] =
    FF.liftF(DeleteOrganizationOp(request))

  def deleteResource(
    request: DeleteResourceRequest
  ): WorkMailIO[DeleteResourceResponse] =
    FF.liftF(DeleteResourceOp(request))

  def deleteRetentionPolicy(
    request: DeleteRetentionPolicyRequest
  ): WorkMailIO[DeleteRetentionPolicyResponse] =
    FF.liftF(DeleteRetentionPolicyOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): WorkMailIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def deregisterFromWorkMail(
    request: DeregisterFromWorkMailRequest
  ): WorkMailIO[DeregisterFromWorkMailResponse] =
    FF.liftF(DeregisterFromWorkMailOp(request))

  def describeGroup(
    request: DescribeGroupRequest
  ): WorkMailIO[DescribeGroupResponse] =
    FF.liftF(DescribeGroupOp(request))

  def describeMailboxExportJob(
    request: DescribeMailboxExportJobRequest
  ): WorkMailIO[DescribeMailboxExportJobResponse] =
    FF.liftF(DescribeMailboxExportJobOp(request))

  def describeOrganization(
    request: DescribeOrganizationRequest
  ): WorkMailIO[DescribeOrganizationResponse] =
    FF.liftF(DescribeOrganizationOp(request))

  def describeResource(
    request: DescribeResourceRequest
  ): WorkMailIO[DescribeResourceResponse] =
    FF.liftF(DescribeResourceOp(request))

  def describeUser(
    request: DescribeUserRequest
  ): WorkMailIO[DescribeUserResponse] =
    FF.liftF(DescribeUserOp(request))

  def disassociateDelegateFromResource(
    request: DisassociateDelegateFromResourceRequest
  ): WorkMailIO[DisassociateDelegateFromResourceResponse] =
    FF.liftF(DisassociateDelegateFromResourceOp(request))

  def disassociateMemberFromGroup(
    request: DisassociateMemberFromGroupRequest
  ): WorkMailIO[DisassociateMemberFromGroupResponse] =
    FF.liftF(DisassociateMemberFromGroupOp(request))

  def getAccessControlEffect(
    request: GetAccessControlEffectRequest
  ): WorkMailIO[GetAccessControlEffectResponse] =
    FF.liftF(GetAccessControlEffectOp(request))

  def getDefaultRetentionPolicy(
    request: GetDefaultRetentionPolicyRequest
  ): WorkMailIO[GetDefaultRetentionPolicyResponse] =
    FF.liftF(GetDefaultRetentionPolicyOp(request))

  def getMailboxDetails(
    request: GetMailboxDetailsRequest
  ): WorkMailIO[GetMailboxDetailsResponse] =
    FF.liftF(GetMailboxDetailsOp(request))

  def getMobileDeviceAccessEffect(
    request: GetMobileDeviceAccessEffectRequest
  ): WorkMailIO[GetMobileDeviceAccessEffectResponse] =
    FF.liftF(GetMobileDeviceAccessEffectOp(request))

  def listAccessControlRules(
    request: ListAccessControlRulesRequest
  ): WorkMailIO[ListAccessControlRulesResponse] =
    FF.liftF(ListAccessControlRulesOp(request))

  def listAliases(
    request: ListAliasesRequest
  ): WorkMailIO[ListAliasesResponse] =
    FF.liftF(ListAliasesOp(request))

  def listGroupMembers(
    request: ListGroupMembersRequest
  ): WorkMailIO[ListGroupMembersResponse] =
    FF.liftF(ListGroupMembersOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): WorkMailIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def listMailboxExportJobs(
    request: ListMailboxExportJobsRequest
  ): WorkMailIO[ListMailboxExportJobsResponse] =
    FF.liftF(ListMailboxExportJobsOp(request))

  def listMailboxPermissions(
    request: ListMailboxPermissionsRequest
  ): WorkMailIO[ListMailboxPermissionsResponse] =
    FF.liftF(ListMailboxPermissionsOp(request))

  def listMobileDeviceAccessRules(
    request: ListMobileDeviceAccessRulesRequest
  ): WorkMailIO[ListMobileDeviceAccessRulesResponse] =
    FF.liftF(ListMobileDeviceAccessRulesOp(request))

  def listOrganizations(
    request: ListOrganizationsRequest
  ): WorkMailIO[ListOrganizationsResponse] =
    FF.liftF(ListOrganizationsOp(request))

  def listResourceDelegates(
    request: ListResourceDelegatesRequest
  ): WorkMailIO[ListResourceDelegatesResponse] =
    FF.liftF(ListResourceDelegatesOp(request))

  def listResources(
    request: ListResourcesRequest
  ): WorkMailIO[ListResourcesResponse] =
    FF.liftF(ListResourcesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): WorkMailIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listUsers(
    request: ListUsersRequest
  ): WorkMailIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def putAccessControlRule(
    request: PutAccessControlRuleRequest
  ): WorkMailIO[PutAccessControlRuleResponse] =
    FF.liftF(PutAccessControlRuleOp(request))

  def putMailboxPermissions(
    request: PutMailboxPermissionsRequest
  ): WorkMailIO[PutMailboxPermissionsResponse] =
    FF.liftF(PutMailboxPermissionsOp(request))

  def putRetentionPolicy(
    request: PutRetentionPolicyRequest
  ): WorkMailIO[PutRetentionPolicyResponse] =
    FF.liftF(PutRetentionPolicyOp(request))

  def registerToWorkMail(
    request: RegisterToWorkMailRequest
  ): WorkMailIO[RegisterToWorkMailResponse] =
    FF.liftF(RegisterToWorkMailOp(request))

  def resetPassword(
    request: ResetPasswordRequest
  ): WorkMailIO[ResetPasswordResponse] =
    FF.liftF(ResetPasswordOp(request))

  def startMailboxExportJob(
    request: StartMailboxExportJobRequest
  ): WorkMailIO[StartMailboxExportJobResponse] =
    FF.liftF(StartMailboxExportJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): WorkMailIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): WorkMailIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateMailboxQuota(
    request: UpdateMailboxQuotaRequest
  ): WorkMailIO[UpdateMailboxQuotaResponse] =
    FF.liftF(UpdateMailboxQuotaOp(request))

  def updateMobileDeviceAccessRule(
    request: UpdateMobileDeviceAccessRuleRequest
  ): WorkMailIO[UpdateMobileDeviceAccessRuleResponse] =
    FF.liftF(UpdateMobileDeviceAccessRuleOp(request))

  def updatePrimaryEmailAddress(
    request: UpdatePrimaryEmailAddressRequest
  ): WorkMailIO[UpdatePrimaryEmailAddressResponse] =
    FF.liftF(UpdatePrimaryEmailAddressOp(request))

  def updateResource(
    request: UpdateResourceRequest
  ): WorkMailIO[UpdateResourceResponse] =
    FF.liftF(UpdateResourceOp(request))
}
