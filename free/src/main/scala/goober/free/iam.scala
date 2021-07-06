package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iam.IamClient
import software.amazon.awssdk.services.iam.model._


object iam { module =>

  // Free monad over IamOp
  type IamIO[A] = FF[IamOp, A]

  sealed trait IamOp[A] {
    def visit[F[_]](visitor: IamOp.Visitor[F]): F[A]
  }

  object IamOp {
    // Given a IamClient we can embed a IamIO program in any algebra that understands embedding.
    implicit val IamOpEmbeddable: Embeddable[IamOp, IamClient] = new Embeddable[IamOp, IamClient] {
      def embed[A](client: IamClient, io: IamIO[A]): Embedded[A] = Embedded.Iam(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IamOp.Visitor[Kleisli[M, IamClient, *]] {
        def addClientIDToOpenIDConnectProvider(
          request: AddClientIdToOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, AddClientIdToOpenIdConnectProviderResponse] =
          primitive(_.addClientIDToOpenIDConnectProvider(request))

        def addRoleToInstanceProfile(
          request: AddRoleToInstanceProfileRequest
        ): Kleisli[M, IamClient, AddRoleToInstanceProfileResponse] =
          primitive(_.addRoleToInstanceProfile(request))

        def addUserToGroup(
          request: AddUserToGroupRequest
        ): Kleisli[M, IamClient, AddUserToGroupResponse] =
          primitive(_.addUserToGroup(request))

        def attachGroupPolicy(
          request: AttachGroupPolicyRequest
        ): Kleisli[M, IamClient, AttachGroupPolicyResponse] =
          primitive(_.attachGroupPolicy(request))

        def attachRolePolicy(
          request: AttachRolePolicyRequest
        ): Kleisli[M, IamClient, AttachRolePolicyResponse] =
          primitive(_.attachRolePolicy(request))

        def attachUserPolicy(
          request: AttachUserPolicyRequest
        ): Kleisli[M, IamClient, AttachUserPolicyResponse] =
          primitive(_.attachUserPolicy(request))

        def changePassword(
          request: ChangePasswordRequest
        ): Kleisli[M, IamClient, ChangePasswordResponse] =
          primitive(_.changePassword(request))

        def createAccessKey(
          request: CreateAccessKeyRequest
        ): Kleisli[M, IamClient, CreateAccessKeyResponse] =
          primitive(_.createAccessKey(request))

        def createAccountAlias(
          request: CreateAccountAliasRequest
        ): Kleisli[M, IamClient, CreateAccountAliasResponse] =
          primitive(_.createAccountAlias(request))

        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, IamClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def createInstanceProfile(
          request: CreateInstanceProfileRequest
        ): Kleisli[M, IamClient, CreateInstanceProfileResponse] =
          primitive(_.createInstanceProfile(request))

        def createLoginProfile(
          request: CreateLoginProfileRequest
        ): Kleisli[M, IamClient, CreateLoginProfileResponse] =
          primitive(_.createLoginProfile(request))

        def createOpenIDConnectProvider(
          request: CreateOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, CreateOpenIdConnectProviderResponse] =
          primitive(_.createOpenIDConnectProvider(request))

        def createPolicy(
          request: CreatePolicyRequest
        ): Kleisli[M, IamClient, CreatePolicyResponse] =
          primitive(_.createPolicy(request))

        def createPolicyVersion(
          request: CreatePolicyVersionRequest
        ): Kleisli[M, IamClient, CreatePolicyVersionResponse] =
          primitive(_.createPolicyVersion(request))

        def createRole(
          request: CreateRoleRequest
        ): Kleisli[M, IamClient, CreateRoleResponse] =
          primitive(_.createRole(request))

        def createSAMLProvider(
          request: CreateSamlProviderRequest
        ): Kleisli[M, IamClient, CreateSamlProviderResponse] =
          primitive(_.createSAMLProvider(request))

        def createServiceLinkedRole(
          request: CreateServiceLinkedRoleRequest
        ): Kleisli[M, IamClient, CreateServiceLinkedRoleResponse] =
          primitive(_.createServiceLinkedRole(request))

        def createServiceSpecificCredential(
          request: CreateServiceSpecificCredentialRequest
        ): Kleisli[M, IamClient, CreateServiceSpecificCredentialResponse] =
          primitive(_.createServiceSpecificCredential(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, IamClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def createVirtualMFADevice(
          request: CreateVirtualMfaDeviceRequest
        ): Kleisli[M, IamClient, CreateVirtualMfaDeviceResponse] =
          primitive(_.createVirtualMFADevice(request))

        def deactivateMFADevice(
          request: DeactivateMfaDeviceRequest
        ): Kleisli[M, IamClient, DeactivateMfaDeviceResponse] =
          primitive(_.deactivateMFADevice(request))

        def deleteAccessKey(
          request: DeleteAccessKeyRequest
        ): Kleisli[M, IamClient, DeleteAccessKeyResponse] =
          primitive(_.deleteAccessKey(request))

        def deleteAccountAlias(
          request: DeleteAccountAliasRequest
        ): Kleisli[M, IamClient, DeleteAccountAliasResponse] =
          primitive(_.deleteAccountAlias(request))

        def deleteAccountPasswordPolicy(
          request: DeleteAccountPasswordPolicyRequest
        ): Kleisli[M, IamClient, DeleteAccountPasswordPolicyResponse] =
          primitive(_.deleteAccountPasswordPolicy(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, IamClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def deleteGroupPolicy(
          request: DeleteGroupPolicyRequest
        ): Kleisli[M, IamClient, DeleteGroupPolicyResponse] =
          primitive(_.deleteGroupPolicy(request))

        def deleteInstanceProfile(
          request: DeleteInstanceProfileRequest
        ): Kleisli[M, IamClient, DeleteInstanceProfileResponse] =
          primitive(_.deleteInstanceProfile(request))

        def deleteLoginProfile(
          request: DeleteLoginProfileRequest
        ): Kleisli[M, IamClient, DeleteLoginProfileResponse] =
          primitive(_.deleteLoginProfile(request))

        def deleteOpenIDConnectProvider(
          request: DeleteOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, DeleteOpenIdConnectProviderResponse] =
          primitive(_.deleteOpenIDConnectProvider(request))

        def deletePolicy(
          request: DeletePolicyRequest
        ): Kleisli[M, IamClient, DeletePolicyResponse] =
          primitive(_.deletePolicy(request))

        def deletePolicyVersion(
          request: DeletePolicyVersionRequest
        ): Kleisli[M, IamClient, DeletePolicyVersionResponse] =
          primitive(_.deletePolicyVersion(request))

        def deleteRole(
          request: DeleteRoleRequest
        ): Kleisli[M, IamClient, DeleteRoleResponse] =
          primitive(_.deleteRole(request))

        def deleteRolePermissionsBoundary(
          request: DeleteRolePermissionsBoundaryRequest
        ): Kleisli[M, IamClient, DeleteRolePermissionsBoundaryResponse] =
          primitive(_.deleteRolePermissionsBoundary(request))

        def deleteRolePolicy(
          request: DeleteRolePolicyRequest
        ): Kleisli[M, IamClient, DeleteRolePolicyResponse] =
          primitive(_.deleteRolePolicy(request))

        def deleteSAMLProvider(
          request: DeleteSamlProviderRequest
        ): Kleisli[M, IamClient, DeleteSamlProviderResponse] =
          primitive(_.deleteSAMLProvider(request))

        def deleteSSHPublicKey(
          request: DeleteSshPublicKeyRequest
        ): Kleisli[M, IamClient, DeleteSshPublicKeyResponse] =
          primitive(_.deleteSSHPublicKey(request))

        def deleteServerCertificate(
          request: DeleteServerCertificateRequest
        ): Kleisli[M, IamClient, DeleteServerCertificateResponse] =
          primitive(_.deleteServerCertificate(request))

        def deleteServiceLinkedRole(
          request: DeleteServiceLinkedRoleRequest
        ): Kleisli[M, IamClient, DeleteServiceLinkedRoleResponse] =
          primitive(_.deleteServiceLinkedRole(request))

        def deleteServiceSpecificCredential(
          request: DeleteServiceSpecificCredentialRequest
        ): Kleisli[M, IamClient, DeleteServiceSpecificCredentialResponse] =
          primitive(_.deleteServiceSpecificCredential(request))

        def deleteSigningCertificate(
          request: DeleteSigningCertificateRequest
        ): Kleisli[M, IamClient, DeleteSigningCertificateResponse] =
          primitive(_.deleteSigningCertificate(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, IamClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def deleteUserPermissionsBoundary(
          request: DeleteUserPermissionsBoundaryRequest
        ): Kleisli[M, IamClient, DeleteUserPermissionsBoundaryResponse] =
          primitive(_.deleteUserPermissionsBoundary(request))

        def deleteUserPolicy(
          request: DeleteUserPolicyRequest
        ): Kleisli[M, IamClient, DeleteUserPolicyResponse] =
          primitive(_.deleteUserPolicy(request))

        def deleteVirtualMFADevice(
          request: DeleteVirtualMfaDeviceRequest
        ): Kleisli[M, IamClient, DeleteVirtualMfaDeviceResponse] =
          primitive(_.deleteVirtualMFADevice(request))

        def detachGroupPolicy(
          request: DetachGroupPolicyRequest
        ): Kleisli[M, IamClient, DetachGroupPolicyResponse] =
          primitive(_.detachGroupPolicy(request))

        def detachRolePolicy(
          request: DetachRolePolicyRequest
        ): Kleisli[M, IamClient, DetachRolePolicyResponse] =
          primitive(_.detachRolePolicy(request))

        def detachUserPolicy(
          request: DetachUserPolicyRequest
        ): Kleisli[M, IamClient, DetachUserPolicyResponse] =
          primitive(_.detachUserPolicy(request))

        def enableMFADevice(
          request: EnableMfaDeviceRequest
        ): Kleisli[M, IamClient, EnableMfaDeviceResponse] =
          primitive(_.enableMFADevice(request))

        def generateCredentialReport(
          request: GenerateCredentialReportRequest
        ): Kleisli[M, IamClient, GenerateCredentialReportResponse] =
          primitive(_.generateCredentialReport(request))

        def generateOrganizationsAccessReport(
          request: GenerateOrganizationsAccessReportRequest
        ): Kleisli[M, IamClient, GenerateOrganizationsAccessReportResponse] =
          primitive(_.generateOrganizationsAccessReport(request))

        def generateServiceLastAccessedDetails(
          request: GenerateServiceLastAccessedDetailsRequest
        ): Kleisli[M, IamClient, GenerateServiceLastAccessedDetailsResponse] =
          primitive(_.generateServiceLastAccessedDetails(request))

        def getAccessKeyLastUsed(
          request: GetAccessKeyLastUsedRequest
        ): Kleisli[M, IamClient, GetAccessKeyLastUsedResponse] =
          primitive(_.getAccessKeyLastUsed(request))

        def getAccountAuthorizationDetails(
          request: GetAccountAuthorizationDetailsRequest
        ): Kleisli[M, IamClient, GetAccountAuthorizationDetailsResponse] =
          primitive(_.getAccountAuthorizationDetails(request))

        def getAccountPasswordPolicy(
          request: GetAccountPasswordPolicyRequest
        ): Kleisli[M, IamClient, GetAccountPasswordPolicyResponse] =
          primitive(_.getAccountPasswordPolicy(request))

        def getAccountSummary(
          request: GetAccountSummaryRequest
        ): Kleisli[M, IamClient, GetAccountSummaryResponse] =
          primitive(_.getAccountSummary(request))

        def getContextKeysForCustomPolicy(
          request: GetContextKeysForCustomPolicyRequest
        ): Kleisli[M, IamClient, GetContextKeysForCustomPolicyResponse] =
          primitive(_.getContextKeysForCustomPolicy(request))

        def getContextKeysForPrincipalPolicy(
          request: GetContextKeysForPrincipalPolicyRequest
        ): Kleisli[M, IamClient, GetContextKeysForPrincipalPolicyResponse] =
          primitive(_.getContextKeysForPrincipalPolicy(request))

        def getCredentialReport(
          request: GetCredentialReportRequest
        ): Kleisli[M, IamClient, GetCredentialReportResponse] =
          primitive(_.getCredentialReport(request))

        def getGroup(
          request: GetGroupRequest
        ): Kleisli[M, IamClient, GetGroupResponse] =
          primitive(_.getGroup(request))

        def getGroupPolicy(
          request: GetGroupPolicyRequest
        ): Kleisli[M, IamClient, GetGroupPolicyResponse] =
          primitive(_.getGroupPolicy(request))

        def getInstanceProfile(
          request: GetInstanceProfileRequest
        ): Kleisli[M, IamClient, GetInstanceProfileResponse] =
          primitive(_.getInstanceProfile(request))

        def getLoginProfile(
          request: GetLoginProfileRequest
        ): Kleisli[M, IamClient, GetLoginProfileResponse] =
          primitive(_.getLoginProfile(request))

        def getOpenIDConnectProvider(
          request: GetOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, GetOpenIdConnectProviderResponse] =
          primitive(_.getOpenIDConnectProvider(request))

        def getOrganizationsAccessReport(
          request: GetOrganizationsAccessReportRequest
        ): Kleisli[M, IamClient, GetOrganizationsAccessReportResponse] =
          primitive(_.getOrganizationsAccessReport(request))

        def getPolicy(
          request: GetPolicyRequest
        ): Kleisli[M, IamClient, GetPolicyResponse] =
          primitive(_.getPolicy(request))

        def getPolicyVersion(
          request: GetPolicyVersionRequest
        ): Kleisli[M, IamClient, GetPolicyVersionResponse] =
          primitive(_.getPolicyVersion(request))

        def getRole(
          request: GetRoleRequest
        ): Kleisli[M, IamClient, GetRoleResponse] =
          primitive(_.getRole(request))

        def getRolePolicy(
          request: GetRolePolicyRequest
        ): Kleisli[M, IamClient, GetRolePolicyResponse] =
          primitive(_.getRolePolicy(request))

        def getSAMLProvider(
          request: GetSamlProviderRequest
        ): Kleisli[M, IamClient, GetSamlProviderResponse] =
          primitive(_.getSAMLProvider(request))

        def getSSHPublicKey(
          request: GetSshPublicKeyRequest
        ): Kleisli[M, IamClient, GetSshPublicKeyResponse] =
          primitive(_.getSSHPublicKey(request))

        def getServerCertificate(
          request: GetServerCertificateRequest
        ): Kleisli[M, IamClient, GetServerCertificateResponse] =
          primitive(_.getServerCertificate(request))

        def getServiceLastAccessedDetails(
          request: GetServiceLastAccessedDetailsRequest
        ): Kleisli[M, IamClient, GetServiceLastAccessedDetailsResponse] =
          primitive(_.getServiceLastAccessedDetails(request))

        def getServiceLastAccessedDetailsWithEntities(
          request: GetServiceLastAccessedDetailsWithEntitiesRequest
        ): Kleisli[M, IamClient, GetServiceLastAccessedDetailsWithEntitiesResponse] =
          primitive(_.getServiceLastAccessedDetailsWithEntities(request))

        def getServiceLinkedRoleDeletionStatus(
          request: GetServiceLinkedRoleDeletionStatusRequest
        ): Kleisli[M, IamClient, GetServiceLinkedRoleDeletionStatusResponse] =
          primitive(_.getServiceLinkedRoleDeletionStatus(request))

        def getUser(
          request: GetUserRequest
        ): Kleisli[M, IamClient, GetUserResponse] =
          primitive(_.getUser(request))

        def getUserPolicy(
          request: GetUserPolicyRequest
        ): Kleisli[M, IamClient, GetUserPolicyResponse] =
          primitive(_.getUserPolicy(request))

        def listAccessKeys(
          request: ListAccessKeysRequest
        ): Kleisli[M, IamClient, ListAccessKeysResponse] =
          primitive(_.listAccessKeys(request))

        def listAccountAliases(
          request: ListAccountAliasesRequest
        ): Kleisli[M, IamClient, ListAccountAliasesResponse] =
          primitive(_.listAccountAliases(request))

        def listAttachedGroupPolicies(
          request: ListAttachedGroupPoliciesRequest
        ): Kleisli[M, IamClient, ListAttachedGroupPoliciesResponse] =
          primitive(_.listAttachedGroupPolicies(request))

        def listAttachedRolePolicies(
          request: ListAttachedRolePoliciesRequest
        ): Kleisli[M, IamClient, ListAttachedRolePoliciesResponse] =
          primitive(_.listAttachedRolePolicies(request))

        def listAttachedUserPolicies(
          request: ListAttachedUserPoliciesRequest
        ): Kleisli[M, IamClient, ListAttachedUserPoliciesResponse] =
          primitive(_.listAttachedUserPolicies(request))

        def listEntitiesForPolicy(
          request: ListEntitiesForPolicyRequest
        ): Kleisli[M, IamClient, ListEntitiesForPolicyResponse] =
          primitive(_.listEntitiesForPolicy(request))

        def listGroupPolicies(
          request: ListGroupPoliciesRequest
        ): Kleisli[M, IamClient, ListGroupPoliciesResponse] =
          primitive(_.listGroupPolicies(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, IamClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def listGroupsForUser(
          request: ListGroupsForUserRequest
        ): Kleisli[M, IamClient, ListGroupsForUserResponse] =
          primitive(_.listGroupsForUser(request))

        def listInstanceProfileTags(
          request: ListInstanceProfileTagsRequest
        ): Kleisli[M, IamClient, ListInstanceProfileTagsResponse] =
          primitive(_.listInstanceProfileTags(request))

        def listInstanceProfiles(
          request: ListInstanceProfilesRequest
        ): Kleisli[M, IamClient, ListInstanceProfilesResponse] =
          primitive(_.listInstanceProfiles(request))

        def listInstanceProfilesForRole(
          request: ListInstanceProfilesForRoleRequest
        ): Kleisli[M, IamClient, ListInstanceProfilesForRoleResponse] =
          primitive(_.listInstanceProfilesForRole(request))

        def listMFADeviceTags(
          request: ListMfaDeviceTagsRequest
        ): Kleisli[M, IamClient, ListMfaDeviceTagsResponse] =
          primitive(_.listMFADeviceTags(request))

        def listMFADevices(
          request: ListMfaDevicesRequest
        ): Kleisli[M, IamClient, ListMfaDevicesResponse] =
          primitive(_.listMFADevices(request))

        def listOpenIDConnectProviderTags(
          request: ListOpenIdConnectProviderTagsRequest
        ): Kleisli[M, IamClient, ListOpenIdConnectProviderTagsResponse] =
          primitive(_.listOpenIDConnectProviderTags(request))

        def listOpenIDConnectProviders(
          request: ListOpenIdConnectProvidersRequest
        ): Kleisli[M, IamClient, ListOpenIdConnectProvidersResponse] =
          primitive(_.listOpenIDConnectProviders(request))

        def listPolicies(
          request: ListPoliciesRequest
        ): Kleisli[M, IamClient, ListPoliciesResponse] =
          primitive(_.listPolicies(request))

        def listPoliciesGrantingServiceAccess(
          request: ListPoliciesGrantingServiceAccessRequest
        ): Kleisli[M, IamClient, ListPoliciesGrantingServiceAccessResponse] =
          primitive(_.listPoliciesGrantingServiceAccess(request))

        def listPolicyTags(
          request: ListPolicyTagsRequest
        ): Kleisli[M, IamClient, ListPolicyTagsResponse] =
          primitive(_.listPolicyTags(request))

        def listPolicyVersions(
          request: ListPolicyVersionsRequest
        ): Kleisli[M, IamClient, ListPolicyVersionsResponse] =
          primitive(_.listPolicyVersions(request))

        def listRolePolicies(
          request: ListRolePoliciesRequest
        ): Kleisli[M, IamClient, ListRolePoliciesResponse] =
          primitive(_.listRolePolicies(request))

        def listRoleTags(
          request: ListRoleTagsRequest
        ): Kleisli[M, IamClient, ListRoleTagsResponse] =
          primitive(_.listRoleTags(request))

        def listRoles(
          request: ListRolesRequest
        ): Kleisli[M, IamClient, ListRolesResponse] =
          primitive(_.listRoles(request))

        def listSAMLProviderTags(
          request: ListSamlProviderTagsRequest
        ): Kleisli[M, IamClient, ListSamlProviderTagsResponse] =
          primitive(_.listSAMLProviderTags(request))

        def listSAMLProviders(
          request: ListSamlProvidersRequest
        ): Kleisli[M, IamClient, ListSamlProvidersResponse] =
          primitive(_.listSAMLProviders(request))

        def listSSHPublicKeys(
          request: ListSshPublicKeysRequest
        ): Kleisli[M, IamClient, ListSshPublicKeysResponse] =
          primitive(_.listSSHPublicKeys(request))

        def listServerCertificateTags(
          request: ListServerCertificateTagsRequest
        ): Kleisli[M, IamClient, ListServerCertificateTagsResponse] =
          primitive(_.listServerCertificateTags(request))

        def listServerCertificates(
          request: ListServerCertificatesRequest
        ): Kleisli[M, IamClient, ListServerCertificatesResponse] =
          primitive(_.listServerCertificates(request))

        def listServiceSpecificCredentials(
          request: ListServiceSpecificCredentialsRequest
        ): Kleisli[M, IamClient, ListServiceSpecificCredentialsResponse] =
          primitive(_.listServiceSpecificCredentials(request))

        def listSigningCertificates(
          request: ListSigningCertificatesRequest
        ): Kleisli[M, IamClient, ListSigningCertificatesResponse] =
          primitive(_.listSigningCertificates(request))

        def listUserPolicies(
          request: ListUserPoliciesRequest
        ): Kleisli[M, IamClient, ListUserPoliciesResponse] =
          primitive(_.listUserPolicies(request))

        def listUserTags(
          request: ListUserTagsRequest
        ): Kleisli[M, IamClient, ListUserTagsResponse] =
          primitive(_.listUserTags(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, IamClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def listVirtualMFADevices(
          request: ListVirtualMfaDevicesRequest
        ): Kleisli[M, IamClient, ListVirtualMfaDevicesResponse] =
          primitive(_.listVirtualMFADevices(request))

        def putGroupPolicy(
          request: PutGroupPolicyRequest
        ): Kleisli[M, IamClient, PutGroupPolicyResponse] =
          primitive(_.putGroupPolicy(request))

        def putRolePermissionsBoundary(
          request: PutRolePermissionsBoundaryRequest
        ): Kleisli[M, IamClient, PutRolePermissionsBoundaryResponse] =
          primitive(_.putRolePermissionsBoundary(request))

        def putRolePolicy(
          request: PutRolePolicyRequest
        ): Kleisli[M, IamClient, PutRolePolicyResponse] =
          primitive(_.putRolePolicy(request))

        def putUserPermissionsBoundary(
          request: PutUserPermissionsBoundaryRequest
        ): Kleisli[M, IamClient, PutUserPermissionsBoundaryResponse] =
          primitive(_.putUserPermissionsBoundary(request))

        def putUserPolicy(
          request: PutUserPolicyRequest
        ): Kleisli[M, IamClient, PutUserPolicyResponse] =
          primitive(_.putUserPolicy(request))

        def removeClientIDFromOpenIDConnectProvider(
          request: RemoveClientIdFromOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, RemoveClientIdFromOpenIdConnectProviderResponse] =
          primitive(_.removeClientIDFromOpenIDConnectProvider(request))

        def removeRoleFromInstanceProfile(
          request: RemoveRoleFromInstanceProfileRequest
        ): Kleisli[M, IamClient, RemoveRoleFromInstanceProfileResponse] =
          primitive(_.removeRoleFromInstanceProfile(request))

        def removeUserFromGroup(
          request: RemoveUserFromGroupRequest
        ): Kleisli[M, IamClient, RemoveUserFromGroupResponse] =
          primitive(_.removeUserFromGroup(request))

        def resetServiceSpecificCredential(
          request: ResetServiceSpecificCredentialRequest
        ): Kleisli[M, IamClient, ResetServiceSpecificCredentialResponse] =
          primitive(_.resetServiceSpecificCredential(request))

        def resyncMFADevice(
          request: ResyncMfaDeviceRequest
        ): Kleisli[M, IamClient, ResyncMfaDeviceResponse] =
          primitive(_.resyncMFADevice(request))

        def setDefaultPolicyVersion(
          request: SetDefaultPolicyVersionRequest
        ): Kleisli[M, IamClient, SetDefaultPolicyVersionResponse] =
          primitive(_.setDefaultPolicyVersion(request))

        def setSecurityTokenServicePreferences(
          request: SetSecurityTokenServicePreferencesRequest
        ): Kleisli[M, IamClient, SetSecurityTokenServicePreferencesResponse] =
          primitive(_.setSecurityTokenServicePreferences(request))

        def simulateCustomPolicy(
          request: SimulateCustomPolicyRequest
        ): Kleisli[M, IamClient, SimulateCustomPolicyResponse] =
          primitive(_.simulateCustomPolicy(request))

        def simulatePrincipalPolicy(
          request: SimulatePrincipalPolicyRequest
        ): Kleisli[M, IamClient, SimulatePrincipalPolicyResponse] =
          primitive(_.simulatePrincipalPolicy(request))

        def tagInstanceProfile(
          request: TagInstanceProfileRequest
        ): Kleisli[M, IamClient, TagInstanceProfileResponse] =
          primitive(_.tagInstanceProfile(request))

        def tagMFADevice(
          request: TagMfaDeviceRequest
        ): Kleisli[M, IamClient, TagMfaDeviceResponse] =
          primitive(_.tagMFADevice(request))

        def tagOpenIDConnectProvider(
          request: TagOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, TagOpenIdConnectProviderResponse] =
          primitive(_.tagOpenIDConnectProvider(request))

        def tagPolicy(
          request: TagPolicyRequest
        ): Kleisli[M, IamClient, TagPolicyResponse] =
          primitive(_.tagPolicy(request))

        def tagRole(
          request: TagRoleRequest
        ): Kleisli[M, IamClient, TagRoleResponse] =
          primitive(_.tagRole(request))

        def tagSAMLProvider(
          request: TagSamlProviderRequest
        ): Kleisli[M, IamClient, TagSamlProviderResponse] =
          primitive(_.tagSAMLProvider(request))

        def tagServerCertificate(
          request: TagServerCertificateRequest
        ): Kleisli[M, IamClient, TagServerCertificateResponse] =
          primitive(_.tagServerCertificate(request))

        def tagUser(
          request: TagUserRequest
        ): Kleisli[M, IamClient, TagUserResponse] =
          primitive(_.tagUser(request))

        def untagInstanceProfile(
          request: UntagInstanceProfileRequest
        ): Kleisli[M, IamClient, UntagInstanceProfileResponse] =
          primitive(_.untagInstanceProfile(request))

        def untagMFADevice(
          request: UntagMfaDeviceRequest
        ): Kleisli[M, IamClient, UntagMfaDeviceResponse] =
          primitive(_.untagMFADevice(request))

        def untagOpenIDConnectProvider(
          request: UntagOpenIdConnectProviderRequest
        ): Kleisli[M, IamClient, UntagOpenIdConnectProviderResponse] =
          primitive(_.untagOpenIDConnectProvider(request))

        def untagPolicy(
          request: UntagPolicyRequest
        ): Kleisli[M, IamClient, UntagPolicyResponse] =
          primitive(_.untagPolicy(request))

        def untagRole(
          request: UntagRoleRequest
        ): Kleisli[M, IamClient, UntagRoleResponse] =
          primitive(_.untagRole(request))

        def untagSAMLProvider(
          request: UntagSamlProviderRequest
        ): Kleisli[M, IamClient, UntagSamlProviderResponse] =
          primitive(_.untagSAMLProvider(request))

        def untagServerCertificate(
          request: UntagServerCertificateRequest
        ): Kleisli[M, IamClient, UntagServerCertificateResponse] =
          primitive(_.untagServerCertificate(request))

        def untagUser(
          request: UntagUserRequest
        ): Kleisli[M, IamClient, UntagUserResponse] =
          primitive(_.untagUser(request))

        def updateAccessKey(
          request: UpdateAccessKeyRequest
        ): Kleisli[M, IamClient, UpdateAccessKeyResponse] =
          primitive(_.updateAccessKey(request))

        def updateAccountPasswordPolicy(
          request: UpdateAccountPasswordPolicyRequest
        ): Kleisli[M, IamClient, UpdateAccountPasswordPolicyResponse] =
          primitive(_.updateAccountPasswordPolicy(request))

        def updateAssumeRolePolicy(
          request: UpdateAssumeRolePolicyRequest
        ): Kleisli[M, IamClient, UpdateAssumeRolePolicyResponse] =
          primitive(_.updateAssumeRolePolicy(request))

        def updateGroup(
          request: UpdateGroupRequest
        ): Kleisli[M, IamClient, UpdateGroupResponse] =
          primitive(_.updateGroup(request))

        def updateLoginProfile(
          request: UpdateLoginProfileRequest
        ): Kleisli[M, IamClient, UpdateLoginProfileResponse] =
          primitive(_.updateLoginProfile(request))

        def updateOpenIDConnectProviderThumbprint(
          request: UpdateOpenIdConnectProviderThumbprintRequest
        ): Kleisli[M, IamClient, UpdateOpenIdConnectProviderThumbprintResponse] =
          primitive(_.updateOpenIDConnectProviderThumbprint(request))

        def updateRole(
          request: UpdateRoleRequest
        ): Kleisli[M, IamClient, UpdateRoleResponse] =
          primitive(_.updateRole(request))

        def updateRoleDescription(
          request: UpdateRoleDescriptionRequest
        ): Kleisli[M, IamClient, UpdateRoleDescriptionResponse] =
          primitive(_.updateRoleDescription(request))

        def updateSAMLProvider(
          request: UpdateSamlProviderRequest
        ): Kleisli[M, IamClient, UpdateSamlProviderResponse] =
          primitive(_.updateSAMLProvider(request))

        def updateSSHPublicKey(
          request: UpdateSshPublicKeyRequest
        ): Kleisli[M, IamClient, UpdateSshPublicKeyResponse] =
          primitive(_.updateSSHPublicKey(request))

        def updateServerCertificate(
          request: UpdateServerCertificateRequest
        ): Kleisli[M, IamClient, UpdateServerCertificateResponse] =
          primitive(_.updateServerCertificate(request))

        def updateServiceSpecificCredential(
          request: UpdateServiceSpecificCredentialRequest
        ): Kleisli[M, IamClient, UpdateServiceSpecificCredentialResponse] =
          primitive(_.updateServiceSpecificCredential(request))

        def updateSigningCertificate(
          request: UpdateSigningCertificateRequest
        ): Kleisli[M, IamClient, UpdateSigningCertificateResponse] =
          primitive(_.updateSigningCertificate(request))

        def updateUser(
          request: UpdateUserRequest
        ): Kleisli[M, IamClient, UpdateUserResponse] =
          primitive(_.updateUser(request))

        def uploadSSHPublicKey(
          request: UploadSshPublicKeyRequest
        ): Kleisli[M, IamClient, UploadSshPublicKeyResponse] =
          primitive(_.uploadSSHPublicKey(request))

        def uploadServerCertificate(
          request: UploadServerCertificateRequest
        ): Kleisli[M, IamClient, UploadServerCertificateResponse] =
          primitive(_.uploadServerCertificate(request))

        def uploadSigningCertificate(
          request: UploadSigningCertificateRequest
        ): Kleisli[M, IamClient, UploadSigningCertificateResponse] =
          primitive(_.uploadSigningCertificate(request))

        def primitive[A](
          f: IamClient => A
        ): Kleisli[M, IamClient, A]
      }
    }

    trait Visitor[F[_]] extends (IamOp ~> F) {
      final def apply[A](op: IamOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addClientIDToOpenIDConnectProvider(
        request: AddClientIdToOpenIdConnectProviderRequest
      ): F[AddClientIdToOpenIdConnectProviderResponse]

      def addRoleToInstanceProfile(
        request: AddRoleToInstanceProfileRequest
      ): F[AddRoleToInstanceProfileResponse]

      def addUserToGroup(
        request: AddUserToGroupRequest
      ): F[AddUserToGroupResponse]

      def attachGroupPolicy(
        request: AttachGroupPolicyRequest
      ): F[AttachGroupPolicyResponse]

      def attachRolePolicy(
        request: AttachRolePolicyRequest
      ): F[AttachRolePolicyResponse]

      def attachUserPolicy(
        request: AttachUserPolicyRequest
      ): F[AttachUserPolicyResponse]

      def changePassword(
        request: ChangePasswordRequest
      ): F[ChangePasswordResponse]

      def createAccessKey(
        request: CreateAccessKeyRequest
      ): F[CreateAccessKeyResponse]

      def createAccountAlias(
        request: CreateAccountAliasRequest
      ): F[CreateAccountAliasResponse]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def createInstanceProfile(
        request: CreateInstanceProfileRequest
      ): F[CreateInstanceProfileResponse]

      def createLoginProfile(
        request: CreateLoginProfileRequest
      ): F[CreateLoginProfileResponse]

      def createOpenIDConnectProvider(
        request: CreateOpenIdConnectProviderRequest
      ): F[CreateOpenIdConnectProviderResponse]

      def createPolicy(
        request: CreatePolicyRequest
      ): F[CreatePolicyResponse]

      def createPolicyVersion(
        request: CreatePolicyVersionRequest
      ): F[CreatePolicyVersionResponse]

      def createRole(
        request: CreateRoleRequest
      ): F[CreateRoleResponse]

      def createSAMLProvider(
        request: CreateSamlProviderRequest
      ): F[CreateSamlProviderResponse]

      def createServiceLinkedRole(
        request: CreateServiceLinkedRoleRequest
      ): F[CreateServiceLinkedRoleResponse]

      def createServiceSpecificCredential(
        request: CreateServiceSpecificCredentialRequest
      ): F[CreateServiceSpecificCredentialResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def createVirtualMFADevice(
        request: CreateVirtualMfaDeviceRequest
      ): F[CreateVirtualMfaDeviceResponse]

      def deactivateMFADevice(
        request: DeactivateMfaDeviceRequest
      ): F[DeactivateMfaDeviceResponse]

      def deleteAccessKey(
        request: DeleteAccessKeyRequest
      ): F[DeleteAccessKeyResponse]

      def deleteAccountAlias(
        request: DeleteAccountAliasRequest
      ): F[DeleteAccountAliasResponse]

      def deleteAccountPasswordPolicy(
        request: DeleteAccountPasswordPolicyRequest
      ): F[DeleteAccountPasswordPolicyResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def deleteGroupPolicy(
        request: DeleteGroupPolicyRequest
      ): F[DeleteGroupPolicyResponse]

      def deleteInstanceProfile(
        request: DeleteInstanceProfileRequest
      ): F[DeleteInstanceProfileResponse]

      def deleteLoginProfile(
        request: DeleteLoginProfileRequest
      ): F[DeleteLoginProfileResponse]

      def deleteOpenIDConnectProvider(
        request: DeleteOpenIdConnectProviderRequest
      ): F[DeleteOpenIdConnectProviderResponse]

      def deletePolicy(
        request: DeletePolicyRequest
      ): F[DeletePolicyResponse]

      def deletePolicyVersion(
        request: DeletePolicyVersionRequest
      ): F[DeletePolicyVersionResponse]

      def deleteRole(
        request: DeleteRoleRequest
      ): F[DeleteRoleResponse]

      def deleteRolePermissionsBoundary(
        request: DeleteRolePermissionsBoundaryRequest
      ): F[DeleteRolePermissionsBoundaryResponse]

      def deleteRolePolicy(
        request: DeleteRolePolicyRequest
      ): F[DeleteRolePolicyResponse]

      def deleteSAMLProvider(
        request: DeleteSamlProviderRequest
      ): F[DeleteSamlProviderResponse]

      def deleteSSHPublicKey(
        request: DeleteSshPublicKeyRequest
      ): F[DeleteSshPublicKeyResponse]

      def deleteServerCertificate(
        request: DeleteServerCertificateRequest
      ): F[DeleteServerCertificateResponse]

      def deleteServiceLinkedRole(
        request: DeleteServiceLinkedRoleRequest
      ): F[DeleteServiceLinkedRoleResponse]

      def deleteServiceSpecificCredential(
        request: DeleteServiceSpecificCredentialRequest
      ): F[DeleteServiceSpecificCredentialResponse]

      def deleteSigningCertificate(
        request: DeleteSigningCertificateRequest
      ): F[DeleteSigningCertificateResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def deleteUserPermissionsBoundary(
        request: DeleteUserPermissionsBoundaryRequest
      ): F[DeleteUserPermissionsBoundaryResponse]

      def deleteUserPolicy(
        request: DeleteUserPolicyRequest
      ): F[DeleteUserPolicyResponse]

      def deleteVirtualMFADevice(
        request: DeleteVirtualMfaDeviceRequest
      ): F[DeleteVirtualMfaDeviceResponse]

      def detachGroupPolicy(
        request: DetachGroupPolicyRequest
      ): F[DetachGroupPolicyResponse]

      def detachRolePolicy(
        request: DetachRolePolicyRequest
      ): F[DetachRolePolicyResponse]

      def detachUserPolicy(
        request: DetachUserPolicyRequest
      ): F[DetachUserPolicyResponse]

      def enableMFADevice(
        request: EnableMfaDeviceRequest
      ): F[EnableMfaDeviceResponse]

      def generateCredentialReport(
        request: GenerateCredentialReportRequest
      ): F[GenerateCredentialReportResponse]

      def generateOrganizationsAccessReport(
        request: GenerateOrganizationsAccessReportRequest
      ): F[GenerateOrganizationsAccessReportResponse]

      def generateServiceLastAccessedDetails(
        request: GenerateServiceLastAccessedDetailsRequest
      ): F[GenerateServiceLastAccessedDetailsResponse]

      def getAccessKeyLastUsed(
        request: GetAccessKeyLastUsedRequest
      ): F[GetAccessKeyLastUsedResponse]

      def getAccountAuthorizationDetails(
        request: GetAccountAuthorizationDetailsRequest
      ): F[GetAccountAuthorizationDetailsResponse]

      def getAccountPasswordPolicy(
        request: GetAccountPasswordPolicyRequest
      ): F[GetAccountPasswordPolicyResponse]

      def getAccountSummary(
        request: GetAccountSummaryRequest
      ): F[GetAccountSummaryResponse]

      def getContextKeysForCustomPolicy(
        request: GetContextKeysForCustomPolicyRequest
      ): F[GetContextKeysForCustomPolicyResponse]

      def getContextKeysForPrincipalPolicy(
        request: GetContextKeysForPrincipalPolicyRequest
      ): F[GetContextKeysForPrincipalPolicyResponse]

      def getCredentialReport(
        request: GetCredentialReportRequest
      ): F[GetCredentialReportResponse]

      def getGroup(
        request: GetGroupRequest
      ): F[GetGroupResponse]

      def getGroupPolicy(
        request: GetGroupPolicyRequest
      ): F[GetGroupPolicyResponse]

      def getInstanceProfile(
        request: GetInstanceProfileRequest
      ): F[GetInstanceProfileResponse]

      def getLoginProfile(
        request: GetLoginProfileRequest
      ): F[GetLoginProfileResponse]

      def getOpenIDConnectProvider(
        request: GetOpenIdConnectProviderRequest
      ): F[GetOpenIdConnectProviderResponse]

      def getOrganizationsAccessReport(
        request: GetOrganizationsAccessReportRequest
      ): F[GetOrganizationsAccessReportResponse]

      def getPolicy(
        request: GetPolicyRequest
      ): F[GetPolicyResponse]

      def getPolicyVersion(
        request: GetPolicyVersionRequest
      ): F[GetPolicyVersionResponse]

      def getRole(
        request: GetRoleRequest
      ): F[GetRoleResponse]

      def getRolePolicy(
        request: GetRolePolicyRequest
      ): F[GetRolePolicyResponse]

      def getSAMLProvider(
        request: GetSamlProviderRequest
      ): F[GetSamlProviderResponse]

      def getSSHPublicKey(
        request: GetSshPublicKeyRequest
      ): F[GetSshPublicKeyResponse]

      def getServerCertificate(
        request: GetServerCertificateRequest
      ): F[GetServerCertificateResponse]

      def getServiceLastAccessedDetails(
        request: GetServiceLastAccessedDetailsRequest
      ): F[GetServiceLastAccessedDetailsResponse]

      def getServiceLastAccessedDetailsWithEntities(
        request: GetServiceLastAccessedDetailsWithEntitiesRequest
      ): F[GetServiceLastAccessedDetailsWithEntitiesResponse]

      def getServiceLinkedRoleDeletionStatus(
        request: GetServiceLinkedRoleDeletionStatusRequest
      ): F[GetServiceLinkedRoleDeletionStatusResponse]

      def getUser(
        request: GetUserRequest
      ): F[GetUserResponse]

      def getUserPolicy(
        request: GetUserPolicyRequest
      ): F[GetUserPolicyResponse]

      def listAccessKeys(
        request: ListAccessKeysRequest
      ): F[ListAccessKeysResponse]

      def listAccountAliases(
        request: ListAccountAliasesRequest
      ): F[ListAccountAliasesResponse]

      def listAttachedGroupPolicies(
        request: ListAttachedGroupPoliciesRequest
      ): F[ListAttachedGroupPoliciesResponse]

      def listAttachedRolePolicies(
        request: ListAttachedRolePoliciesRequest
      ): F[ListAttachedRolePoliciesResponse]

      def listAttachedUserPolicies(
        request: ListAttachedUserPoliciesRequest
      ): F[ListAttachedUserPoliciesResponse]

      def listEntitiesForPolicy(
        request: ListEntitiesForPolicyRequest
      ): F[ListEntitiesForPolicyResponse]

      def listGroupPolicies(
        request: ListGroupPoliciesRequest
      ): F[ListGroupPoliciesResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def listGroupsForUser(
        request: ListGroupsForUserRequest
      ): F[ListGroupsForUserResponse]

      def listInstanceProfileTags(
        request: ListInstanceProfileTagsRequest
      ): F[ListInstanceProfileTagsResponse]

      def listInstanceProfiles(
        request: ListInstanceProfilesRequest
      ): F[ListInstanceProfilesResponse]

      def listInstanceProfilesForRole(
        request: ListInstanceProfilesForRoleRequest
      ): F[ListInstanceProfilesForRoleResponse]

      def listMFADeviceTags(
        request: ListMfaDeviceTagsRequest
      ): F[ListMfaDeviceTagsResponse]

      def listMFADevices(
        request: ListMfaDevicesRequest
      ): F[ListMfaDevicesResponse]

      def listOpenIDConnectProviderTags(
        request: ListOpenIdConnectProviderTagsRequest
      ): F[ListOpenIdConnectProviderTagsResponse]

      def listOpenIDConnectProviders(
        request: ListOpenIdConnectProvidersRequest
      ): F[ListOpenIdConnectProvidersResponse]

      def listPolicies(
        request: ListPoliciesRequest
      ): F[ListPoliciesResponse]

      def listPoliciesGrantingServiceAccess(
        request: ListPoliciesGrantingServiceAccessRequest
      ): F[ListPoliciesGrantingServiceAccessResponse]

      def listPolicyTags(
        request: ListPolicyTagsRequest
      ): F[ListPolicyTagsResponse]

      def listPolicyVersions(
        request: ListPolicyVersionsRequest
      ): F[ListPolicyVersionsResponse]

      def listRolePolicies(
        request: ListRolePoliciesRequest
      ): F[ListRolePoliciesResponse]

      def listRoleTags(
        request: ListRoleTagsRequest
      ): F[ListRoleTagsResponse]

      def listRoles(
        request: ListRolesRequest
      ): F[ListRolesResponse]

      def listSAMLProviderTags(
        request: ListSamlProviderTagsRequest
      ): F[ListSamlProviderTagsResponse]

      def listSAMLProviders(
        request: ListSamlProvidersRequest
      ): F[ListSamlProvidersResponse]

      def listSSHPublicKeys(
        request: ListSshPublicKeysRequest
      ): F[ListSshPublicKeysResponse]

      def listServerCertificateTags(
        request: ListServerCertificateTagsRequest
      ): F[ListServerCertificateTagsResponse]

      def listServerCertificates(
        request: ListServerCertificatesRequest
      ): F[ListServerCertificatesResponse]

      def listServiceSpecificCredentials(
        request: ListServiceSpecificCredentialsRequest
      ): F[ListServiceSpecificCredentialsResponse]

      def listSigningCertificates(
        request: ListSigningCertificatesRequest
      ): F[ListSigningCertificatesResponse]

      def listUserPolicies(
        request: ListUserPoliciesRequest
      ): F[ListUserPoliciesResponse]

      def listUserTags(
        request: ListUserTagsRequest
      ): F[ListUserTagsResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def listVirtualMFADevices(
        request: ListVirtualMfaDevicesRequest
      ): F[ListVirtualMfaDevicesResponse]

      def putGroupPolicy(
        request: PutGroupPolicyRequest
      ): F[PutGroupPolicyResponse]

      def putRolePermissionsBoundary(
        request: PutRolePermissionsBoundaryRequest
      ): F[PutRolePermissionsBoundaryResponse]

      def putRolePolicy(
        request: PutRolePolicyRequest
      ): F[PutRolePolicyResponse]

      def putUserPermissionsBoundary(
        request: PutUserPermissionsBoundaryRequest
      ): F[PutUserPermissionsBoundaryResponse]

      def putUserPolicy(
        request: PutUserPolicyRequest
      ): F[PutUserPolicyResponse]

      def removeClientIDFromOpenIDConnectProvider(
        request: RemoveClientIdFromOpenIdConnectProviderRequest
      ): F[RemoveClientIdFromOpenIdConnectProviderResponse]

      def removeRoleFromInstanceProfile(
        request: RemoveRoleFromInstanceProfileRequest
      ): F[RemoveRoleFromInstanceProfileResponse]

      def removeUserFromGroup(
        request: RemoveUserFromGroupRequest
      ): F[RemoveUserFromGroupResponse]

      def resetServiceSpecificCredential(
        request: ResetServiceSpecificCredentialRequest
      ): F[ResetServiceSpecificCredentialResponse]

      def resyncMFADevice(
        request: ResyncMfaDeviceRequest
      ): F[ResyncMfaDeviceResponse]

      def setDefaultPolicyVersion(
        request: SetDefaultPolicyVersionRequest
      ): F[SetDefaultPolicyVersionResponse]

      def setSecurityTokenServicePreferences(
        request: SetSecurityTokenServicePreferencesRequest
      ): F[SetSecurityTokenServicePreferencesResponse]

      def simulateCustomPolicy(
        request: SimulateCustomPolicyRequest
      ): F[SimulateCustomPolicyResponse]

      def simulatePrincipalPolicy(
        request: SimulatePrincipalPolicyRequest
      ): F[SimulatePrincipalPolicyResponse]

      def tagInstanceProfile(
        request: TagInstanceProfileRequest
      ): F[TagInstanceProfileResponse]

      def tagMFADevice(
        request: TagMfaDeviceRequest
      ): F[TagMfaDeviceResponse]

      def tagOpenIDConnectProvider(
        request: TagOpenIdConnectProviderRequest
      ): F[TagOpenIdConnectProviderResponse]

      def tagPolicy(
        request: TagPolicyRequest
      ): F[TagPolicyResponse]

      def tagRole(
        request: TagRoleRequest
      ): F[TagRoleResponse]

      def tagSAMLProvider(
        request: TagSamlProviderRequest
      ): F[TagSamlProviderResponse]

      def tagServerCertificate(
        request: TagServerCertificateRequest
      ): F[TagServerCertificateResponse]

      def tagUser(
        request: TagUserRequest
      ): F[TagUserResponse]

      def untagInstanceProfile(
        request: UntagInstanceProfileRequest
      ): F[UntagInstanceProfileResponse]

      def untagMFADevice(
        request: UntagMfaDeviceRequest
      ): F[UntagMfaDeviceResponse]

      def untagOpenIDConnectProvider(
        request: UntagOpenIdConnectProviderRequest
      ): F[UntagOpenIdConnectProviderResponse]

      def untagPolicy(
        request: UntagPolicyRequest
      ): F[UntagPolicyResponse]

      def untagRole(
        request: UntagRoleRequest
      ): F[UntagRoleResponse]

      def untagSAMLProvider(
        request: UntagSamlProviderRequest
      ): F[UntagSamlProviderResponse]

      def untagServerCertificate(
        request: UntagServerCertificateRequest
      ): F[UntagServerCertificateResponse]

      def untagUser(
        request: UntagUserRequest
      ): F[UntagUserResponse]

      def updateAccessKey(
        request: UpdateAccessKeyRequest
      ): F[UpdateAccessKeyResponse]

      def updateAccountPasswordPolicy(
        request: UpdateAccountPasswordPolicyRequest
      ): F[UpdateAccountPasswordPolicyResponse]

      def updateAssumeRolePolicy(
        request: UpdateAssumeRolePolicyRequest
      ): F[UpdateAssumeRolePolicyResponse]

      def updateGroup(
        request: UpdateGroupRequest
      ): F[UpdateGroupResponse]

      def updateLoginProfile(
        request: UpdateLoginProfileRequest
      ): F[UpdateLoginProfileResponse]

      def updateOpenIDConnectProviderThumbprint(
        request: UpdateOpenIdConnectProviderThumbprintRequest
      ): F[UpdateOpenIdConnectProviderThumbprintResponse]

      def updateRole(
        request: UpdateRoleRequest
      ): F[UpdateRoleResponse]

      def updateRoleDescription(
        request: UpdateRoleDescriptionRequest
      ): F[UpdateRoleDescriptionResponse]

      def updateSAMLProvider(
        request: UpdateSamlProviderRequest
      ): F[UpdateSamlProviderResponse]

      def updateSSHPublicKey(
        request: UpdateSshPublicKeyRequest
      ): F[UpdateSshPublicKeyResponse]

      def updateServerCertificate(
        request: UpdateServerCertificateRequest
      ): F[UpdateServerCertificateResponse]

      def updateServiceSpecificCredential(
        request: UpdateServiceSpecificCredentialRequest
      ): F[UpdateServiceSpecificCredentialResponse]

      def updateSigningCertificate(
        request: UpdateSigningCertificateRequest
      ): F[UpdateSigningCertificateResponse]

      def updateUser(
        request: UpdateUserRequest
      ): F[UpdateUserResponse]

      def uploadSSHPublicKey(
        request: UploadSshPublicKeyRequest
      ): F[UploadSshPublicKeyResponse]

      def uploadServerCertificate(
        request: UploadServerCertificateRequest
      ): F[UploadServerCertificateResponse]

      def uploadSigningCertificate(
        request: UploadSigningCertificateRequest
      ): F[UploadSigningCertificateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IamOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddClientIDToOpenIDConnectProviderOp(
      request: AddClientIdToOpenIdConnectProviderRequest
    ) extends IamOp[AddClientIdToOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddClientIdToOpenIdConnectProviderResponse] =
        visitor.addClientIDToOpenIDConnectProvider(request)
    }

    final case class AddRoleToInstanceProfileOp(
      request: AddRoleToInstanceProfileRequest
    ) extends IamOp[AddRoleToInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddRoleToInstanceProfileResponse] =
        visitor.addRoleToInstanceProfile(request)
    }

    final case class AddUserToGroupOp(
      request: AddUserToGroupRequest
    ) extends IamOp[AddUserToGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddUserToGroupResponse] =
        visitor.addUserToGroup(request)
    }

    final case class AttachGroupPolicyOp(
      request: AttachGroupPolicyRequest
    ) extends IamOp[AttachGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachGroupPolicyResponse] =
        visitor.attachGroupPolicy(request)
    }

    final case class AttachRolePolicyOp(
      request: AttachRolePolicyRequest
    ) extends IamOp[AttachRolePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachRolePolicyResponse] =
        visitor.attachRolePolicy(request)
    }

    final case class AttachUserPolicyOp(
      request: AttachUserPolicyRequest
    ) extends IamOp[AttachUserPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AttachUserPolicyResponse] =
        visitor.attachUserPolicy(request)
    }

    final case class ChangePasswordOp(
      request: ChangePasswordRequest
    ) extends IamOp[ChangePasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangePasswordResponse] =
        visitor.changePassword(request)
    }

    final case class CreateAccessKeyOp(
      request: CreateAccessKeyRequest
    ) extends IamOp[CreateAccessKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessKeyResponse] =
        visitor.createAccessKey(request)
    }

    final case class CreateAccountAliasOp(
      request: CreateAccountAliasRequest
    ) extends IamOp[CreateAccountAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccountAliasResponse] =
        visitor.createAccountAlias(request)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends IamOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class CreateInstanceProfileOp(
      request: CreateInstanceProfileRequest
    ) extends IamOp[CreateInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceProfileResponse] =
        visitor.createInstanceProfile(request)
    }

    final case class CreateLoginProfileOp(
      request: CreateLoginProfileRequest
    ) extends IamOp[CreateLoginProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoginProfileResponse] =
        visitor.createLoginProfile(request)
    }

    final case class CreateOpenIDConnectProviderOp(
      request: CreateOpenIdConnectProviderRequest
    ) extends IamOp[CreateOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateOpenIdConnectProviderResponse] =
        visitor.createOpenIDConnectProvider(request)
    }

    final case class CreatePolicyOp(
      request: CreatePolicyRequest
    ) extends IamOp[CreatePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePolicyResponse] =
        visitor.createPolicy(request)
    }

    final case class CreatePolicyVersionOp(
      request: CreatePolicyVersionRequest
    ) extends IamOp[CreatePolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePolicyVersionResponse] =
        visitor.createPolicyVersion(request)
    }

    final case class CreateRoleOp(
      request: CreateRoleRequest
    ) extends IamOp[CreateRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRoleResponse] =
        visitor.createRole(request)
    }

    final case class CreateSAMLProviderOp(
      request: CreateSamlProviderRequest
    ) extends IamOp[CreateSamlProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSamlProviderResponse] =
        visitor.createSAMLProvider(request)
    }

    final case class CreateServiceLinkedRoleOp(
      request: CreateServiceLinkedRoleRequest
    ) extends IamOp[CreateServiceLinkedRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceLinkedRoleResponse] =
        visitor.createServiceLinkedRole(request)
    }

    final case class CreateServiceSpecificCredentialOp(
      request: CreateServiceSpecificCredentialRequest
    ) extends IamOp[CreateServiceSpecificCredentialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceSpecificCredentialResponse] =
        visitor.createServiceSpecificCredential(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends IamOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class CreateVirtualMFADeviceOp(
      request: CreateVirtualMfaDeviceRequest
    ) extends IamOp[CreateVirtualMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVirtualMfaDeviceResponse] =
        visitor.createVirtualMFADevice(request)
    }

    final case class DeactivateMFADeviceOp(
      request: DeactivateMfaDeviceRequest
    ) extends IamOp[DeactivateMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeactivateMfaDeviceResponse] =
        visitor.deactivateMFADevice(request)
    }

    final case class DeleteAccessKeyOp(
      request: DeleteAccessKeyRequest
    ) extends IamOp[DeleteAccessKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessKeyResponse] =
        visitor.deleteAccessKey(request)
    }

    final case class DeleteAccountAliasOp(
      request: DeleteAccountAliasRequest
    ) extends IamOp[DeleteAccountAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountAliasResponse] =
        visitor.deleteAccountAlias(request)
    }

    final case class DeleteAccountPasswordPolicyOp(
      request: DeleteAccountPasswordPolicyRequest
    ) extends IamOp[DeleteAccountPasswordPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountPasswordPolicyResponse] =
        visitor.deleteAccountPasswordPolicy(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends IamOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class DeleteGroupPolicyOp(
      request: DeleteGroupPolicyRequest
    ) extends IamOp[DeleteGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupPolicyResponse] =
        visitor.deleteGroupPolicy(request)
    }

    final case class DeleteInstanceProfileOp(
      request: DeleteInstanceProfileRequest
    ) extends IamOp[DeleteInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceProfileResponse] =
        visitor.deleteInstanceProfile(request)
    }

    final case class DeleteLoginProfileOp(
      request: DeleteLoginProfileRequest
    ) extends IamOp[DeleteLoginProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoginProfileResponse] =
        visitor.deleteLoginProfile(request)
    }

    final case class DeleteOpenIDConnectProviderOp(
      request: DeleteOpenIdConnectProviderRequest
    ) extends IamOp[DeleteOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteOpenIdConnectProviderResponse] =
        visitor.deleteOpenIDConnectProvider(request)
    }

    final case class DeletePolicyOp(
      request: DeletePolicyRequest
    ) extends IamOp[DeletePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyResponse] =
        visitor.deletePolicy(request)
    }

    final case class DeletePolicyVersionOp(
      request: DeletePolicyVersionRequest
    ) extends IamOp[DeletePolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePolicyVersionResponse] =
        visitor.deletePolicyVersion(request)
    }

    final case class DeleteRoleOp(
      request: DeleteRoleRequest
    ) extends IamOp[DeleteRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRoleResponse] =
        visitor.deleteRole(request)
    }

    final case class DeleteRolePermissionsBoundaryOp(
      request: DeleteRolePermissionsBoundaryRequest
    ) extends IamOp[DeleteRolePermissionsBoundaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRolePermissionsBoundaryResponse] =
        visitor.deleteRolePermissionsBoundary(request)
    }

    final case class DeleteRolePolicyOp(
      request: DeleteRolePolicyRequest
    ) extends IamOp[DeleteRolePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRolePolicyResponse] =
        visitor.deleteRolePolicy(request)
    }

    final case class DeleteSAMLProviderOp(
      request: DeleteSamlProviderRequest
    ) extends IamOp[DeleteSamlProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSamlProviderResponse] =
        visitor.deleteSAMLProvider(request)
    }

    final case class DeleteSSHPublicKeyOp(
      request: DeleteSshPublicKeyRequest
    ) extends IamOp[DeleteSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSshPublicKeyResponse] =
        visitor.deleteSSHPublicKey(request)
    }

    final case class DeleteServerCertificateOp(
      request: DeleteServerCertificateRequest
    ) extends IamOp[DeleteServerCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServerCertificateResponse] =
        visitor.deleteServerCertificate(request)
    }

    final case class DeleteServiceLinkedRoleOp(
      request: DeleteServiceLinkedRoleRequest
    ) extends IamOp[DeleteServiceLinkedRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceLinkedRoleResponse] =
        visitor.deleteServiceLinkedRole(request)
    }

    final case class DeleteServiceSpecificCredentialOp(
      request: DeleteServiceSpecificCredentialRequest
    ) extends IamOp[DeleteServiceSpecificCredentialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceSpecificCredentialResponse] =
        visitor.deleteServiceSpecificCredential(request)
    }

    final case class DeleteSigningCertificateOp(
      request: DeleteSigningCertificateRequest
    ) extends IamOp[DeleteSigningCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSigningCertificateResponse] =
        visitor.deleteSigningCertificate(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends IamOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DeleteUserPermissionsBoundaryOp(
      request: DeleteUserPermissionsBoundaryRequest
    ) extends IamOp[DeleteUserPermissionsBoundaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserPermissionsBoundaryResponse] =
        visitor.deleteUserPermissionsBoundary(request)
    }

    final case class DeleteUserPolicyOp(
      request: DeleteUserPolicyRequest
    ) extends IamOp[DeleteUserPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserPolicyResponse] =
        visitor.deleteUserPolicy(request)
    }

    final case class DeleteVirtualMFADeviceOp(
      request: DeleteVirtualMfaDeviceRequest
    ) extends IamOp[DeleteVirtualMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualMfaDeviceResponse] =
        visitor.deleteVirtualMFADevice(request)
    }

    final case class DetachGroupPolicyOp(
      request: DetachGroupPolicyRequest
    ) extends IamOp[DetachGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachGroupPolicyResponse] =
        visitor.detachGroupPolicy(request)
    }

    final case class DetachRolePolicyOp(
      request: DetachRolePolicyRequest
    ) extends IamOp[DetachRolePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachRolePolicyResponse] =
        visitor.detachRolePolicy(request)
    }

    final case class DetachUserPolicyOp(
      request: DetachUserPolicyRequest
    ) extends IamOp[DetachUserPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetachUserPolicyResponse] =
        visitor.detachUserPolicy(request)
    }

    final case class EnableMFADeviceOp(
      request: EnableMfaDeviceRequest
    ) extends IamOp[EnableMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableMfaDeviceResponse] =
        visitor.enableMFADevice(request)
    }

    final case class GenerateCredentialReportOp(
      request: GenerateCredentialReportRequest
    ) extends IamOp[GenerateCredentialReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateCredentialReportResponse] =
        visitor.generateCredentialReport(request)
    }

    final case class GenerateOrganizationsAccessReportOp(
      request: GenerateOrganizationsAccessReportRequest
    ) extends IamOp[GenerateOrganizationsAccessReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateOrganizationsAccessReportResponse] =
        visitor.generateOrganizationsAccessReport(request)
    }

    final case class GenerateServiceLastAccessedDetailsOp(
      request: GenerateServiceLastAccessedDetailsRequest
    ) extends IamOp[GenerateServiceLastAccessedDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateServiceLastAccessedDetailsResponse] =
        visitor.generateServiceLastAccessedDetails(request)
    }

    final case class GetAccessKeyLastUsedOp(
      request: GetAccessKeyLastUsedRequest
    ) extends IamOp[GetAccessKeyLastUsedResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccessKeyLastUsedResponse] =
        visitor.getAccessKeyLastUsed(request)
    }

    final case class GetAccountAuthorizationDetailsOp(
      request: GetAccountAuthorizationDetailsRequest
    ) extends IamOp[GetAccountAuthorizationDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountAuthorizationDetailsResponse] =
        visitor.getAccountAuthorizationDetails(request)
    }

    final case class GetAccountPasswordPolicyOp(
      request: GetAccountPasswordPolicyRequest
    ) extends IamOp[GetAccountPasswordPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountPasswordPolicyResponse] =
        visitor.getAccountPasswordPolicy(request)
    }

    final case class GetAccountSummaryOp(
      request: GetAccountSummaryRequest
    ) extends IamOp[GetAccountSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountSummaryResponse] =
        visitor.getAccountSummary(request)
    }

    final case class GetContextKeysForCustomPolicyOp(
      request: GetContextKeysForCustomPolicyRequest
    ) extends IamOp[GetContextKeysForCustomPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContextKeysForCustomPolicyResponse] =
        visitor.getContextKeysForCustomPolicy(request)
    }

    final case class GetContextKeysForPrincipalPolicyOp(
      request: GetContextKeysForPrincipalPolicyRequest
    ) extends IamOp[GetContextKeysForPrincipalPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContextKeysForPrincipalPolicyResponse] =
        visitor.getContextKeysForPrincipalPolicy(request)
    }

    final case class GetCredentialReportOp(
      request: GetCredentialReportRequest
    ) extends IamOp[GetCredentialReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCredentialReportResponse] =
        visitor.getCredentialReport(request)
    }

    final case class GetGroupOp(
      request: GetGroupRequest
    ) extends IamOp[GetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupResponse] =
        visitor.getGroup(request)
    }

    final case class GetGroupPolicyOp(
      request: GetGroupPolicyRequest
    ) extends IamOp[GetGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupPolicyResponse] =
        visitor.getGroupPolicy(request)
    }

    final case class GetInstanceProfileOp(
      request: GetInstanceProfileRequest
    ) extends IamOp[GetInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceProfileResponse] =
        visitor.getInstanceProfile(request)
    }

    final case class GetLoginProfileOp(
      request: GetLoginProfileRequest
    ) extends IamOp[GetLoginProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoginProfileResponse] =
        visitor.getLoginProfile(request)
    }

    final case class GetOpenIDConnectProviderOp(
      request: GetOpenIdConnectProviderRequest
    ) extends IamOp[GetOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOpenIdConnectProviderResponse] =
        visitor.getOpenIDConnectProvider(request)
    }

    final case class GetOrganizationsAccessReportOp(
      request: GetOrganizationsAccessReportRequest
    ) extends IamOp[GetOrganizationsAccessReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOrganizationsAccessReportResponse] =
        visitor.getOrganizationsAccessReport(request)
    }

    final case class GetPolicyOp(
      request: GetPolicyRequest
    ) extends IamOp[GetPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyResponse] =
        visitor.getPolicy(request)
    }

    final case class GetPolicyVersionOp(
      request: GetPolicyVersionRequest
    ) extends IamOp[GetPolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPolicyVersionResponse] =
        visitor.getPolicyVersion(request)
    }

    final case class GetRoleOp(
      request: GetRoleRequest
    ) extends IamOp[GetRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRoleResponse] =
        visitor.getRole(request)
    }

    final case class GetRolePolicyOp(
      request: GetRolePolicyRequest
    ) extends IamOp[GetRolePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRolePolicyResponse] =
        visitor.getRolePolicy(request)
    }

    final case class GetSAMLProviderOp(
      request: GetSamlProviderRequest
    ) extends IamOp[GetSamlProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSamlProviderResponse] =
        visitor.getSAMLProvider(request)
    }

    final case class GetSSHPublicKeyOp(
      request: GetSshPublicKeyRequest
    ) extends IamOp[GetSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSshPublicKeyResponse] =
        visitor.getSSHPublicKey(request)
    }

    final case class GetServerCertificateOp(
      request: GetServerCertificateRequest
    ) extends IamOp[GetServerCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServerCertificateResponse] =
        visitor.getServerCertificate(request)
    }

    final case class GetServiceLastAccessedDetailsOp(
      request: GetServiceLastAccessedDetailsRequest
    ) extends IamOp[GetServiceLastAccessedDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceLastAccessedDetailsResponse] =
        visitor.getServiceLastAccessedDetails(request)
    }

    final case class GetServiceLastAccessedDetailsWithEntitiesOp(
      request: GetServiceLastAccessedDetailsWithEntitiesRequest
    ) extends IamOp[GetServiceLastAccessedDetailsWithEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceLastAccessedDetailsWithEntitiesResponse] =
        visitor.getServiceLastAccessedDetailsWithEntities(request)
    }

    final case class GetServiceLinkedRoleDeletionStatusOp(
      request: GetServiceLinkedRoleDeletionStatusRequest
    ) extends IamOp[GetServiceLinkedRoleDeletionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceLinkedRoleDeletionStatusResponse] =
        visitor.getServiceLinkedRoleDeletionStatus(request)
    }

    final case class GetUserOp(
      request: GetUserRequest
    ) extends IamOp[GetUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserResponse] =
        visitor.getUser(request)
    }

    final case class GetUserPolicyOp(
      request: GetUserPolicyRequest
    ) extends IamOp[GetUserPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserPolicyResponse] =
        visitor.getUserPolicy(request)
    }

    final case class ListAccessKeysOp(
      request: ListAccessKeysRequest
    ) extends IamOp[ListAccessKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessKeysResponse] =
        visitor.listAccessKeys(request)
    }

    final case class ListAccountAliasesOp(
      request: ListAccountAliasesRequest
    ) extends IamOp[ListAccountAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountAliasesResponse] =
        visitor.listAccountAliases(request)
    }

    final case class ListAttachedGroupPoliciesOp(
      request: ListAttachedGroupPoliciesRequest
    ) extends IamOp[ListAttachedGroupPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttachedGroupPoliciesResponse] =
        visitor.listAttachedGroupPolicies(request)
    }

    final case class ListAttachedRolePoliciesOp(
      request: ListAttachedRolePoliciesRequest
    ) extends IamOp[ListAttachedRolePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttachedRolePoliciesResponse] =
        visitor.listAttachedRolePolicies(request)
    }

    final case class ListAttachedUserPoliciesOp(
      request: ListAttachedUserPoliciesRequest
    ) extends IamOp[ListAttachedUserPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttachedUserPoliciesResponse] =
        visitor.listAttachedUserPolicies(request)
    }

    final case class ListEntitiesForPolicyOp(
      request: ListEntitiesForPolicyRequest
    ) extends IamOp[ListEntitiesForPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEntitiesForPolicyResponse] =
        visitor.listEntitiesForPolicy(request)
    }

    final case class ListGroupPoliciesOp(
      request: ListGroupPoliciesRequest
    ) extends IamOp[ListGroupPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupPoliciesResponse] =
        visitor.listGroupPolicies(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends IamOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class ListGroupsForUserOp(
      request: ListGroupsForUserRequest
    ) extends IamOp[ListGroupsForUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsForUserResponse] =
        visitor.listGroupsForUser(request)
    }

    final case class ListInstanceProfileTagsOp(
      request: ListInstanceProfileTagsRequest
    ) extends IamOp[ListInstanceProfileTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceProfileTagsResponse] =
        visitor.listInstanceProfileTags(request)
    }

    final case class ListInstanceProfilesOp(
      request: ListInstanceProfilesRequest
    ) extends IamOp[ListInstanceProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceProfilesResponse] =
        visitor.listInstanceProfiles(request)
    }

    final case class ListInstanceProfilesForRoleOp(
      request: ListInstanceProfilesForRoleRequest
    ) extends IamOp[ListInstanceProfilesForRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceProfilesForRoleResponse] =
        visitor.listInstanceProfilesForRole(request)
    }

    final case class ListMFADeviceTagsOp(
      request: ListMfaDeviceTagsRequest
    ) extends IamOp[ListMfaDeviceTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMfaDeviceTagsResponse] =
        visitor.listMFADeviceTags(request)
    }

    final case class ListMFADevicesOp(
      request: ListMfaDevicesRequest
    ) extends IamOp[ListMfaDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMfaDevicesResponse] =
        visitor.listMFADevices(request)
    }

    final case class ListOpenIDConnectProviderTagsOp(
      request: ListOpenIdConnectProviderTagsRequest
    ) extends IamOp[ListOpenIdConnectProviderTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOpenIdConnectProviderTagsResponse] =
        visitor.listOpenIDConnectProviderTags(request)
    }

    final case class ListOpenIDConnectProvidersOp(
      request: ListOpenIdConnectProvidersRequest
    ) extends IamOp[ListOpenIdConnectProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOpenIdConnectProvidersResponse] =
        visitor.listOpenIDConnectProviders(request)
    }

    final case class ListPoliciesOp(
      request: ListPoliciesRequest
    ) extends IamOp[ListPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPoliciesResponse] =
        visitor.listPolicies(request)
    }

    final case class ListPoliciesGrantingServiceAccessOp(
      request: ListPoliciesGrantingServiceAccessRequest
    ) extends IamOp[ListPoliciesGrantingServiceAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPoliciesGrantingServiceAccessResponse] =
        visitor.listPoliciesGrantingServiceAccess(request)
    }

    final case class ListPolicyTagsOp(
      request: ListPolicyTagsRequest
    ) extends IamOp[ListPolicyTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPolicyTagsResponse] =
        visitor.listPolicyTags(request)
    }

    final case class ListPolicyVersionsOp(
      request: ListPolicyVersionsRequest
    ) extends IamOp[ListPolicyVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPolicyVersionsResponse] =
        visitor.listPolicyVersions(request)
    }

    final case class ListRolePoliciesOp(
      request: ListRolePoliciesRequest
    ) extends IamOp[ListRolePoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRolePoliciesResponse] =
        visitor.listRolePolicies(request)
    }

    final case class ListRoleTagsOp(
      request: ListRoleTagsRequest
    ) extends IamOp[ListRoleTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoleTagsResponse] =
        visitor.listRoleTags(request)
    }

    final case class ListRolesOp(
      request: ListRolesRequest
    ) extends IamOp[ListRolesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRolesResponse] =
        visitor.listRoles(request)
    }

    final case class ListSAMLProviderTagsOp(
      request: ListSamlProviderTagsRequest
    ) extends IamOp[ListSamlProviderTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSamlProviderTagsResponse] =
        visitor.listSAMLProviderTags(request)
    }

    final case class ListSAMLProvidersOp(
      request: ListSamlProvidersRequest
    ) extends IamOp[ListSamlProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSamlProvidersResponse] =
        visitor.listSAMLProviders(request)
    }

    final case class ListSSHPublicKeysOp(
      request: ListSshPublicKeysRequest
    ) extends IamOp[ListSshPublicKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSshPublicKeysResponse] =
        visitor.listSSHPublicKeys(request)
    }

    final case class ListServerCertificateTagsOp(
      request: ListServerCertificateTagsRequest
    ) extends IamOp[ListServerCertificateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServerCertificateTagsResponse] =
        visitor.listServerCertificateTags(request)
    }

    final case class ListServerCertificatesOp(
      request: ListServerCertificatesRequest
    ) extends IamOp[ListServerCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServerCertificatesResponse] =
        visitor.listServerCertificates(request)
    }

    final case class ListServiceSpecificCredentialsOp(
      request: ListServiceSpecificCredentialsRequest
    ) extends IamOp[ListServiceSpecificCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceSpecificCredentialsResponse] =
        visitor.listServiceSpecificCredentials(request)
    }

    final case class ListSigningCertificatesOp(
      request: ListSigningCertificatesRequest
    ) extends IamOp[ListSigningCertificatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSigningCertificatesResponse] =
        visitor.listSigningCertificates(request)
    }

    final case class ListUserPoliciesOp(
      request: ListUserPoliciesRequest
    ) extends IamOp[ListUserPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserPoliciesResponse] =
        visitor.listUserPolicies(request)
    }

    final case class ListUserTagsOp(
      request: ListUserTagsRequest
    ) extends IamOp[ListUserTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserTagsResponse] =
        visitor.listUserTags(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends IamOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class ListVirtualMFADevicesOp(
      request: ListVirtualMfaDevicesRequest
    ) extends IamOp[ListVirtualMfaDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualMfaDevicesResponse] =
        visitor.listVirtualMFADevices(request)
    }

    final case class PutGroupPolicyOp(
      request: PutGroupPolicyRequest
    ) extends IamOp[PutGroupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutGroupPolicyResponse] =
        visitor.putGroupPolicy(request)
    }

    final case class PutRolePermissionsBoundaryOp(
      request: PutRolePermissionsBoundaryRequest
    ) extends IamOp[PutRolePermissionsBoundaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRolePermissionsBoundaryResponse] =
        visitor.putRolePermissionsBoundary(request)
    }

    final case class PutRolePolicyOp(
      request: PutRolePolicyRequest
    ) extends IamOp[PutRolePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRolePolicyResponse] =
        visitor.putRolePolicy(request)
    }

    final case class PutUserPermissionsBoundaryOp(
      request: PutUserPermissionsBoundaryRequest
    ) extends IamOp[PutUserPermissionsBoundaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutUserPermissionsBoundaryResponse] =
        visitor.putUserPermissionsBoundary(request)
    }

    final case class PutUserPolicyOp(
      request: PutUserPolicyRequest
    ) extends IamOp[PutUserPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutUserPolicyResponse] =
        visitor.putUserPolicy(request)
    }

    final case class RemoveClientIDFromOpenIDConnectProviderOp(
      request: RemoveClientIdFromOpenIdConnectProviderRequest
    ) extends IamOp[RemoveClientIdFromOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveClientIdFromOpenIdConnectProviderResponse] =
        visitor.removeClientIDFromOpenIDConnectProvider(request)
    }

    final case class RemoveRoleFromInstanceProfileOp(
      request: RemoveRoleFromInstanceProfileRequest
    ) extends IamOp[RemoveRoleFromInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveRoleFromInstanceProfileResponse] =
        visitor.removeRoleFromInstanceProfile(request)
    }

    final case class RemoveUserFromGroupOp(
      request: RemoveUserFromGroupRequest
    ) extends IamOp[RemoveUserFromGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveUserFromGroupResponse] =
        visitor.removeUserFromGroup(request)
    }

    final case class ResetServiceSpecificCredentialOp(
      request: ResetServiceSpecificCredentialRequest
    ) extends IamOp[ResetServiceSpecificCredentialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetServiceSpecificCredentialResponse] =
        visitor.resetServiceSpecificCredential(request)
    }

    final case class ResyncMFADeviceOp(
      request: ResyncMfaDeviceRequest
    ) extends IamOp[ResyncMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResyncMfaDeviceResponse] =
        visitor.resyncMFADevice(request)
    }

    final case class SetDefaultPolicyVersionOp(
      request: SetDefaultPolicyVersionRequest
    ) extends IamOp[SetDefaultPolicyVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetDefaultPolicyVersionResponse] =
        visitor.setDefaultPolicyVersion(request)
    }

    final case class SetSecurityTokenServicePreferencesOp(
      request: SetSecurityTokenServicePreferencesRequest
    ) extends IamOp[SetSecurityTokenServicePreferencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetSecurityTokenServicePreferencesResponse] =
        visitor.setSecurityTokenServicePreferences(request)
    }

    final case class SimulateCustomPolicyOp(
      request: SimulateCustomPolicyRequest
    ) extends IamOp[SimulateCustomPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SimulateCustomPolicyResponse] =
        visitor.simulateCustomPolicy(request)
    }

    final case class SimulatePrincipalPolicyOp(
      request: SimulatePrincipalPolicyRequest
    ) extends IamOp[SimulatePrincipalPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SimulatePrincipalPolicyResponse] =
        visitor.simulatePrincipalPolicy(request)
    }

    final case class TagInstanceProfileOp(
      request: TagInstanceProfileRequest
    ) extends IamOp[TagInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagInstanceProfileResponse] =
        visitor.tagInstanceProfile(request)
    }

    final case class TagMFADeviceOp(
      request: TagMfaDeviceRequest
    ) extends IamOp[TagMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagMfaDeviceResponse] =
        visitor.tagMFADevice(request)
    }

    final case class TagOpenIDConnectProviderOp(
      request: TagOpenIdConnectProviderRequest
    ) extends IamOp[TagOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagOpenIdConnectProviderResponse] =
        visitor.tagOpenIDConnectProvider(request)
    }

    final case class TagPolicyOp(
      request: TagPolicyRequest
    ) extends IamOp[TagPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagPolicyResponse] =
        visitor.tagPolicy(request)
    }

    final case class TagRoleOp(
      request: TagRoleRequest
    ) extends IamOp[TagRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagRoleResponse] =
        visitor.tagRole(request)
    }

    final case class TagSAMLProviderOp(
      request: TagSamlProviderRequest
    ) extends IamOp[TagSamlProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagSamlProviderResponse] =
        visitor.tagSAMLProvider(request)
    }

    final case class TagServerCertificateOp(
      request: TagServerCertificateRequest
    ) extends IamOp[TagServerCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagServerCertificateResponse] =
        visitor.tagServerCertificate(request)
    }

    final case class TagUserOp(
      request: TagUserRequest
    ) extends IamOp[TagUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagUserResponse] =
        visitor.tagUser(request)
    }

    final case class UntagInstanceProfileOp(
      request: UntagInstanceProfileRequest
    ) extends IamOp[UntagInstanceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagInstanceProfileResponse] =
        visitor.untagInstanceProfile(request)
    }

    final case class UntagMFADeviceOp(
      request: UntagMfaDeviceRequest
    ) extends IamOp[UntagMfaDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagMfaDeviceResponse] =
        visitor.untagMFADevice(request)
    }

    final case class UntagOpenIDConnectProviderOp(
      request: UntagOpenIdConnectProviderRequest
    ) extends IamOp[UntagOpenIdConnectProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagOpenIdConnectProviderResponse] =
        visitor.untagOpenIDConnectProvider(request)
    }

    final case class UntagPolicyOp(
      request: UntagPolicyRequest
    ) extends IamOp[UntagPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagPolicyResponse] =
        visitor.untagPolicy(request)
    }

    final case class UntagRoleOp(
      request: UntagRoleRequest
    ) extends IamOp[UntagRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagRoleResponse] =
        visitor.untagRole(request)
    }

    final case class UntagSAMLProviderOp(
      request: UntagSamlProviderRequest
    ) extends IamOp[UntagSamlProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagSamlProviderResponse] =
        visitor.untagSAMLProvider(request)
    }

    final case class UntagServerCertificateOp(
      request: UntagServerCertificateRequest
    ) extends IamOp[UntagServerCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagServerCertificateResponse] =
        visitor.untagServerCertificate(request)
    }

    final case class UntagUserOp(
      request: UntagUserRequest
    ) extends IamOp[UntagUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagUserResponse] =
        visitor.untagUser(request)
    }

    final case class UpdateAccessKeyOp(
      request: UpdateAccessKeyRequest
    ) extends IamOp[UpdateAccessKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccessKeyResponse] =
        visitor.updateAccessKey(request)
    }

    final case class UpdateAccountPasswordPolicyOp(
      request: UpdateAccountPasswordPolicyRequest
    ) extends IamOp[UpdateAccountPasswordPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountPasswordPolicyResponse] =
        visitor.updateAccountPasswordPolicy(request)
    }

    final case class UpdateAssumeRolePolicyOp(
      request: UpdateAssumeRolePolicyRequest
    ) extends IamOp[UpdateAssumeRolePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssumeRolePolicyResponse] =
        visitor.updateAssumeRolePolicy(request)
    }

    final case class UpdateGroupOp(
      request: UpdateGroupRequest
    ) extends IamOp[UpdateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupResponse] =
        visitor.updateGroup(request)
    }

    final case class UpdateLoginProfileOp(
      request: UpdateLoginProfileRequest
    ) extends IamOp[UpdateLoginProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLoginProfileResponse] =
        visitor.updateLoginProfile(request)
    }

    final case class UpdateOpenIDConnectProviderThumbprintOp(
      request: UpdateOpenIdConnectProviderThumbprintRequest
    ) extends IamOp[UpdateOpenIdConnectProviderThumbprintResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateOpenIdConnectProviderThumbprintResponse] =
        visitor.updateOpenIDConnectProviderThumbprint(request)
    }

    final case class UpdateRoleOp(
      request: UpdateRoleRequest
    ) extends IamOp[UpdateRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoleResponse] =
        visitor.updateRole(request)
    }

    final case class UpdateRoleDescriptionOp(
      request: UpdateRoleDescriptionRequest
    ) extends IamOp[UpdateRoleDescriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoleDescriptionResponse] =
        visitor.updateRoleDescription(request)
    }

    final case class UpdateSAMLProviderOp(
      request: UpdateSamlProviderRequest
    ) extends IamOp[UpdateSamlProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSamlProviderResponse] =
        visitor.updateSAMLProvider(request)
    }

    final case class UpdateSSHPublicKeyOp(
      request: UpdateSshPublicKeyRequest
    ) extends IamOp[UpdateSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSshPublicKeyResponse] =
        visitor.updateSSHPublicKey(request)
    }

    final case class UpdateServerCertificateOp(
      request: UpdateServerCertificateRequest
    ) extends IamOp[UpdateServerCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServerCertificateResponse] =
        visitor.updateServerCertificate(request)
    }

    final case class UpdateServiceSpecificCredentialOp(
      request: UpdateServiceSpecificCredentialRequest
    ) extends IamOp[UpdateServiceSpecificCredentialResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceSpecificCredentialResponse] =
        visitor.updateServiceSpecificCredential(request)
    }

    final case class UpdateSigningCertificateOp(
      request: UpdateSigningCertificateRequest
    ) extends IamOp[UpdateSigningCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSigningCertificateResponse] =
        visitor.updateSigningCertificate(request)
    }

    final case class UpdateUserOp(
      request: UpdateUserRequest
    ) extends IamOp[UpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserResponse] =
        visitor.updateUser(request)
    }

    final case class UploadSSHPublicKeyOp(
      request: UploadSshPublicKeyRequest
    ) extends IamOp[UploadSshPublicKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadSshPublicKeyResponse] =
        visitor.uploadSSHPublicKey(request)
    }

    final case class UploadServerCertificateOp(
      request: UploadServerCertificateRequest
    ) extends IamOp[UploadServerCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadServerCertificateResponse] =
        visitor.uploadServerCertificate(request)
    }

    final case class UploadSigningCertificateOp(
      request: UploadSigningCertificateRequest
    ) extends IamOp[UploadSigningCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UploadSigningCertificateResponse] =
        visitor.uploadSigningCertificate(request)
    }
  }

  import IamOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IamOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addClientIDToOpenIDConnectProvider(
    request: AddClientIdToOpenIdConnectProviderRequest
  ): IamIO[AddClientIdToOpenIdConnectProviderResponse] =
    FF.liftF(AddClientIDToOpenIDConnectProviderOp(request))

  def addRoleToInstanceProfile(
    request: AddRoleToInstanceProfileRequest
  ): IamIO[AddRoleToInstanceProfileResponse] =
    FF.liftF(AddRoleToInstanceProfileOp(request))

  def addUserToGroup(
    request: AddUserToGroupRequest
  ): IamIO[AddUserToGroupResponse] =
    FF.liftF(AddUserToGroupOp(request))

  def attachGroupPolicy(
    request: AttachGroupPolicyRequest
  ): IamIO[AttachGroupPolicyResponse] =
    FF.liftF(AttachGroupPolicyOp(request))

  def attachRolePolicy(
    request: AttachRolePolicyRequest
  ): IamIO[AttachRolePolicyResponse] =
    FF.liftF(AttachRolePolicyOp(request))

  def attachUserPolicy(
    request: AttachUserPolicyRequest
  ): IamIO[AttachUserPolicyResponse] =
    FF.liftF(AttachUserPolicyOp(request))

  def changePassword(
    request: ChangePasswordRequest
  ): IamIO[ChangePasswordResponse] =
    FF.liftF(ChangePasswordOp(request))

  def createAccessKey(
    request: CreateAccessKeyRequest
  ): IamIO[CreateAccessKeyResponse] =
    FF.liftF(CreateAccessKeyOp(request))

  def createAccountAlias(
    request: CreateAccountAliasRequest
  ): IamIO[CreateAccountAliasResponse] =
    FF.liftF(CreateAccountAliasOp(request))

  def createGroup(
    request: CreateGroupRequest
  ): IamIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def createInstanceProfile(
    request: CreateInstanceProfileRequest
  ): IamIO[CreateInstanceProfileResponse] =
    FF.liftF(CreateInstanceProfileOp(request))

  def createLoginProfile(
    request: CreateLoginProfileRequest
  ): IamIO[CreateLoginProfileResponse] =
    FF.liftF(CreateLoginProfileOp(request))

  def createOpenIDConnectProvider(
    request: CreateOpenIdConnectProviderRequest
  ): IamIO[CreateOpenIdConnectProviderResponse] =
    FF.liftF(CreateOpenIDConnectProviderOp(request))

  def createPolicy(
    request: CreatePolicyRequest
  ): IamIO[CreatePolicyResponse] =
    FF.liftF(CreatePolicyOp(request))

  def createPolicyVersion(
    request: CreatePolicyVersionRequest
  ): IamIO[CreatePolicyVersionResponse] =
    FF.liftF(CreatePolicyVersionOp(request))

  def createRole(
    request: CreateRoleRequest
  ): IamIO[CreateRoleResponse] =
    FF.liftF(CreateRoleOp(request))

  def createSAMLProvider(
    request: CreateSamlProviderRequest
  ): IamIO[CreateSamlProviderResponse] =
    FF.liftF(CreateSAMLProviderOp(request))

  def createServiceLinkedRole(
    request: CreateServiceLinkedRoleRequest
  ): IamIO[CreateServiceLinkedRoleResponse] =
    FF.liftF(CreateServiceLinkedRoleOp(request))

  def createServiceSpecificCredential(
    request: CreateServiceSpecificCredentialRequest
  ): IamIO[CreateServiceSpecificCredentialResponse] =
    FF.liftF(CreateServiceSpecificCredentialOp(request))

  def createUser(
    request: CreateUserRequest
  ): IamIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def createVirtualMFADevice(
    request: CreateVirtualMfaDeviceRequest
  ): IamIO[CreateVirtualMfaDeviceResponse] =
    FF.liftF(CreateVirtualMFADeviceOp(request))

  def deactivateMFADevice(
    request: DeactivateMfaDeviceRequest
  ): IamIO[DeactivateMfaDeviceResponse] =
    FF.liftF(DeactivateMFADeviceOp(request))

  def deleteAccessKey(
    request: DeleteAccessKeyRequest
  ): IamIO[DeleteAccessKeyResponse] =
    FF.liftF(DeleteAccessKeyOp(request))

  def deleteAccountAlias(
    request: DeleteAccountAliasRequest
  ): IamIO[DeleteAccountAliasResponse] =
    FF.liftF(DeleteAccountAliasOp(request))

  def deleteAccountPasswordPolicy(
    request: DeleteAccountPasswordPolicyRequest
  ): IamIO[DeleteAccountPasswordPolicyResponse] =
    FF.liftF(DeleteAccountPasswordPolicyOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): IamIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def deleteGroupPolicy(
    request: DeleteGroupPolicyRequest
  ): IamIO[DeleteGroupPolicyResponse] =
    FF.liftF(DeleteGroupPolicyOp(request))

  def deleteInstanceProfile(
    request: DeleteInstanceProfileRequest
  ): IamIO[DeleteInstanceProfileResponse] =
    FF.liftF(DeleteInstanceProfileOp(request))

  def deleteLoginProfile(
    request: DeleteLoginProfileRequest
  ): IamIO[DeleteLoginProfileResponse] =
    FF.liftF(DeleteLoginProfileOp(request))

  def deleteOpenIDConnectProvider(
    request: DeleteOpenIdConnectProviderRequest
  ): IamIO[DeleteOpenIdConnectProviderResponse] =
    FF.liftF(DeleteOpenIDConnectProviderOp(request))

  def deletePolicy(
    request: DeletePolicyRequest
  ): IamIO[DeletePolicyResponse] =
    FF.liftF(DeletePolicyOp(request))

  def deletePolicyVersion(
    request: DeletePolicyVersionRequest
  ): IamIO[DeletePolicyVersionResponse] =
    FF.liftF(DeletePolicyVersionOp(request))

  def deleteRole(
    request: DeleteRoleRequest
  ): IamIO[DeleteRoleResponse] =
    FF.liftF(DeleteRoleOp(request))

  def deleteRolePermissionsBoundary(
    request: DeleteRolePermissionsBoundaryRequest
  ): IamIO[DeleteRolePermissionsBoundaryResponse] =
    FF.liftF(DeleteRolePermissionsBoundaryOp(request))

  def deleteRolePolicy(
    request: DeleteRolePolicyRequest
  ): IamIO[DeleteRolePolicyResponse] =
    FF.liftF(DeleteRolePolicyOp(request))

  def deleteSAMLProvider(
    request: DeleteSamlProviderRequest
  ): IamIO[DeleteSamlProviderResponse] =
    FF.liftF(DeleteSAMLProviderOp(request))

  def deleteSSHPublicKey(
    request: DeleteSshPublicKeyRequest
  ): IamIO[DeleteSshPublicKeyResponse] =
    FF.liftF(DeleteSSHPublicKeyOp(request))

  def deleteServerCertificate(
    request: DeleteServerCertificateRequest
  ): IamIO[DeleteServerCertificateResponse] =
    FF.liftF(DeleteServerCertificateOp(request))

  def deleteServiceLinkedRole(
    request: DeleteServiceLinkedRoleRequest
  ): IamIO[DeleteServiceLinkedRoleResponse] =
    FF.liftF(DeleteServiceLinkedRoleOp(request))

  def deleteServiceSpecificCredential(
    request: DeleteServiceSpecificCredentialRequest
  ): IamIO[DeleteServiceSpecificCredentialResponse] =
    FF.liftF(DeleteServiceSpecificCredentialOp(request))

  def deleteSigningCertificate(
    request: DeleteSigningCertificateRequest
  ): IamIO[DeleteSigningCertificateResponse] =
    FF.liftF(DeleteSigningCertificateOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): IamIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def deleteUserPermissionsBoundary(
    request: DeleteUserPermissionsBoundaryRequest
  ): IamIO[DeleteUserPermissionsBoundaryResponse] =
    FF.liftF(DeleteUserPermissionsBoundaryOp(request))

  def deleteUserPolicy(
    request: DeleteUserPolicyRequest
  ): IamIO[DeleteUserPolicyResponse] =
    FF.liftF(DeleteUserPolicyOp(request))

  def deleteVirtualMFADevice(
    request: DeleteVirtualMfaDeviceRequest
  ): IamIO[DeleteVirtualMfaDeviceResponse] =
    FF.liftF(DeleteVirtualMFADeviceOp(request))

  def detachGroupPolicy(
    request: DetachGroupPolicyRequest
  ): IamIO[DetachGroupPolicyResponse] =
    FF.liftF(DetachGroupPolicyOp(request))

  def detachRolePolicy(
    request: DetachRolePolicyRequest
  ): IamIO[DetachRolePolicyResponse] =
    FF.liftF(DetachRolePolicyOp(request))

  def detachUserPolicy(
    request: DetachUserPolicyRequest
  ): IamIO[DetachUserPolicyResponse] =
    FF.liftF(DetachUserPolicyOp(request))

  def enableMFADevice(
    request: EnableMfaDeviceRequest
  ): IamIO[EnableMfaDeviceResponse] =
    FF.liftF(EnableMFADeviceOp(request))

  def generateCredentialReport(
    request: GenerateCredentialReportRequest
  ): IamIO[GenerateCredentialReportResponse] =
    FF.liftF(GenerateCredentialReportOp(request))

  def generateOrganizationsAccessReport(
    request: GenerateOrganizationsAccessReportRequest
  ): IamIO[GenerateOrganizationsAccessReportResponse] =
    FF.liftF(GenerateOrganizationsAccessReportOp(request))

  def generateServiceLastAccessedDetails(
    request: GenerateServiceLastAccessedDetailsRequest
  ): IamIO[GenerateServiceLastAccessedDetailsResponse] =
    FF.liftF(GenerateServiceLastAccessedDetailsOp(request))

  def getAccessKeyLastUsed(
    request: GetAccessKeyLastUsedRequest
  ): IamIO[GetAccessKeyLastUsedResponse] =
    FF.liftF(GetAccessKeyLastUsedOp(request))

  def getAccountAuthorizationDetails(
    request: GetAccountAuthorizationDetailsRequest
  ): IamIO[GetAccountAuthorizationDetailsResponse] =
    FF.liftF(GetAccountAuthorizationDetailsOp(request))

  def getAccountPasswordPolicy(
    request: GetAccountPasswordPolicyRequest
  ): IamIO[GetAccountPasswordPolicyResponse] =
    FF.liftF(GetAccountPasswordPolicyOp(request))

  def getAccountSummary(
    request: GetAccountSummaryRequest
  ): IamIO[GetAccountSummaryResponse] =
    FF.liftF(GetAccountSummaryOp(request))

  def getContextKeysForCustomPolicy(
    request: GetContextKeysForCustomPolicyRequest
  ): IamIO[GetContextKeysForCustomPolicyResponse] =
    FF.liftF(GetContextKeysForCustomPolicyOp(request))

  def getContextKeysForPrincipalPolicy(
    request: GetContextKeysForPrincipalPolicyRequest
  ): IamIO[GetContextKeysForPrincipalPolicyResponse] =
    FF.liftF(GetContextKeysForPrincipalPolicyOp(request))

  def getCredentialReport(
    request: GetCredentialReportRequest
  ): IamIO[GetCredentialReportResponse] =
    FF.liftF(GetCredentialReportOp(request))

  def getGroup(
    request: GetGroupRequest
  ): IamIO[GetGroupResponse] =
    FF.liftF(GetGroupOp(request))

  def getGroupPolicy(
    request: GetGroupPolicyRequest
  ): IamIO[GetGroupPolicyResponse] =
    FF.liftF(GetGroupPolicyOp(request))

  def getInstanceProfile(
    request: GetInstanceProfileRequest
  ): IamIO[GetInstanceProfileResponse] =
    FF.liftF(GetInstanceProfileOp(request))

  def getLoginProfile(
    request: GetLoginProfileRequest
  ): IamIO[GetLoginProfileResponse] =
    FF.liftF(GetLoginProfileOp(request))

  def getOpenIDConnectProvider(
    request: GetOpenIdConnectProviderRequest
  ): IamIO[GetOpenIdConnectProviderResponse] =
    FF.liftF(GetOpenIDConnectProviderOp(request))

  def getOrganizationsAccessReport(
    request: GetOrganizationsAccessReportRequest
  ): IamIO[GetOrganizationsAccessReportResponse] =
    FF.liftF(GetOrganizationsAccessReportOp(request))

  def getPolicy(
    request: GetPolicyRequest
  ): IamIO[GetPolicyResponse] =
    FF.liftF(GetPolicyOp(request))

  def getPolicyVersion(
    request: GetPolicyVersionRequest
  ): IamIO[GetPolicyVersionResponse] =
    FF.liftF(GetPolicyVersionOp(request))

  def getRole(
    request: GetRoleRequest
  ): IamIO[GetRoleResponse] =
    FF.liftF(GetRoleOp(request))

  def getRolePolicy(
    request: GetRolePolicyRequest
  ): IamIO[GetRolePolicyResponse] =
    FF.liftF(GetRolePolicyOp(request))

  def getSAMLProvider(
    request: GetSamlProviderRequest
  ): IamIO[GetSamlProviderResponse] =
    FF.liftF(GetSAMLProviderOp(request))

  def getSSHPublicKey(
    request: GetSshPublicKeyRequest
  ): IamIO[GetSshPublicKeyResponse] =
    FF.liftF(GetSSHPublicKeyOp(request))

  def getServerCertificate(
    request: GetServerCertificateRequest
  ): IamIO[GetServerCertificateResponse] =
    FF.liftF(GetServerCertificateOp(request))

  def getServiceLastAccessedDetails(
    request: GetServiceLastAccessedDetailsRequest
  ): IamIO[GetServiceLastAccessedDetailsResponse] =
    FF.liftF(GetServiceLastAccessedDetailsOp(request))

  def getServiceLastAccessedDetailsWithEntities(
    request: GetServiceLastAccessedDetailsWithEntitiesRequest
  ): IamIO[GetServiceLastAccessedDetailsWithEntitiesResponse] =
    FF.liftF(GetServiceLastAccessedDetailsWithEntitiesOp(request))

  def getServiceLinkedRoleDeletionStatus(
    request: GetServiceLinkedRoleDeletionStatusRequest
  ): IamIO[GetServiceLinkedRoleDeletionStatusResponse] =
    FF.liftF(GetServiceLinkedRoleDeletionStatusOp(request))

  def getUser(
    request: GetUserRequest
  ): IamIO[GetUserResponse] =
    FF.liftF(GetUserOp(request))

  def getUserPolicy(
    request: GetUserPolicyRequest
  ): IamIO[GetUserPolicyResponse] =
    FF.liftF(GetUserPolicyOp(request))

  def listAccessKeys(
    request: ListAccessKeysRequest
  ): IamIO[ListAccessKeysResponse] =
    FF.liftF(ListAccessKeysOp(request))

  def listAccountAliases(
    request: ListAccountAliasesRequest
  ): IamIO[ListAccountAliasesResponse] =
    FF.liftF(ListAccountAliasesOp(request))

  def listAttachedGroupPolicies(
    request: ListAttachedGroupPoliciesRequest
  ): IamIO[ListAttachedGroupPoliciesResponse] =
    FF.liftF(ListAttachedGroupPoliciesOp(request))

  def listAttachedRolePolicies(
    request: ListAttachedRolePoliciesRequest
  ): IamIO[ListAttachedRolePoliciesResponse] =
    FF.liftF(ListAttachedRolePoliciesOp(request))

  def listAttachedUserPolicies(
    request: ListAttachedUserPoliciesRequest
  ): IamIO[ListAttachedUserPoliciesResponse] =
    FF.liftF(ListAttachedUserPoliciesOp(request))

  def listEntitiesForPolicy(
    request: ListEntitiesForPolicyRequest
  ): IamIO[ListEntitiesForPolicyResponse] =
    FF.liftF(ListEntitiesForPolicyOp(request))

  def listGroupPolicies(
    request: ListGroupPoliciesRequest
  ): IamIO[ListGroupPoliciesResponse] =
    FF.liftF(ListGroupPoliciesOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): IamIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def listGroupsForUser(
    request: ListGroupsForUserRequest
  ): IamIO[ListGroupsForUserResponse] =
    FF.liftF(ListGroupsForUserOp(request))

  def listInstanceProfileTags(
    request: ListInstanceProfileTagsRequest
  ): IamIO[ListInstanceProfileTagsResponse] =
    FF.liftF(ListInstanceProfileTagsOp(request))

  def listInstanceProfiles(
    request: ListInstanceProfilesRequest
  ): IamIO[ListInstanceProfilesResponse] =
    FF.liftF(ListInstanceProfilesOp(request))

  def listInstanceProfilesForRole(
    request: ListInstanceProfilesForRoleRequest
  ): IamIO[ListInstanceProfilesForRoleResponse] =
    FF.liftF(ListInstanceProfilesForRoleOp(request))

  def listMFADeviceTags(
    request: ListMfaDeviceTagsRequest
  ): IamIO[ListMfaDeviceTagsResponse] =
    FF.liftF(ListMFADeviceTagsOp(request))

  def listMFADevices(
    request: ListMfaDevicesRequest
  ): IamIO[ListMfaDevicesResponse] =
    FF.liftF(ListMFADevicesOp(request))

  def listOpenIDConnectProviderTags(
    request: ListOpenIdConnectProviderTagsRequest
  ): IamIO[ListOpenIdConnectProviderTagsResponse] =
    FF.liftF(ListOpenIDConnectProviderTagsOp(request))

  def listOpenIDConnectProviders(
    request: ListOpenIdConnectProvidersRequest
  ): IamIO[ListOpenIdConnectProvidersResponse] =
    FF.liftF(ListOpenIDConnectProvidersOp(request))

  def listPolicies(
    request: ListPoliciesRequest
  ): IamIO[ListPoliciesResponse] =
    FF.liftF(ListPoliciesOp(request))

  def listPoliciesGrantingServiceAccess(
    request: ListPoliciesGrantingServiceAccessRequest
  ): IamIO[ListPoliciesGrantingServiceAccessResponse] =
    FF.liftF(ListPoliciesGrantingServiceAccessOp(request))

  def listPolicyTags(
    request: ListPolicyTagsRequest
  ): IamIO[ListPolicyTagsResponse] =
    FF.liftF(ListPolicyTagsOp(request))

  def listPolicyVersions(
    request: ListPolicyVersionsRequest
  ): IamIO[ListPolicyVersionsResponse] =
    FF.liftF(ListPolicyVersionsOp(request))

  def listRolePolicies(
    request: ListRolePoliciesRequest
  ): IamIO[ListRolePoliciesResponse] =
    FF.liftF(ListRolePoliciesOp(request))

  def listRoleTags(
    request: ListRoleTagsRequest
  ): IamIO[ListRoleTagsResponse] =
    FF.liftF(ListRoleTagsOp(request))

  def listRoles(
    request: ListRolesRequest
  ): IamIO[ListRolesResponse] =
    FF.liftF(ListRolesOp(request))

  def listSAMLProviderTags(
    request: ListSamlProviderTagsRequest
  ): IamIO[ListSamlProviderTagsResponse] =
    FF.liftF(ListSAMLProviderTagsOp(request))

  def listSAMLProviders(
    request: ListSamlProvidersRequest
  ): IamIO[ListSamlProvidersResponse] =
    FF.liftF(ListSAMLProvidersOp(request))

  def listSSHPublicKeys(
    request: ListSshPublicKeysRequest
  ): IamIO[ListSshPublicKeysResponse] =
    FF.liftF(ListSSHPublicKeysOp(request))

  def listServerCertificateTags(
    request: ListServerCertificateTagsRequest
  ): IamIO[ListServerCertificateTagsResponse] =
    FF.liftF(ListServerCertificateTagsOp(request))

  def listServerCertificates(
    request: ListServerCertificatesRequest
  ): IamIO[ListServerCertificatesResponse] =
    FF.liftF(ListServerCertificatesOp(request))

  def listServiceSpecificCredentials(
    request: ListServiceSpecificCredentialsRequest
  ): IamIO[ListServiceSpecificCredentialsResponse] =
    FF.liftF(ListServiceSpecificCredentialsOp(request))

  def listSigningCertificates(
    request: ListSigningCertificatesRequest
  ): IamIO[ListSigningCertificatesResponse] =
    FF.liftF(ListSigningCertificatesOp(request))

  def listUserPolicies(
    request: ListUserPoliciesRequest
  ): IamIO[ListUserPoliciesResponse] =
    FF.liftF(ListUserPoliciesOp(request))

  def listUserTags(
    request: ListUserTagsRequest
  ): IamIO[ListUserTagsResponse] =
    FF.liftF(ListUserTagsOp(request))

  def listUsers(
    request: ListUsersRequest
  ): IamIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def listVirtualMFADevices(
    request: ListVirtualMfaDevicesRequest
  ): IamIO[ListVirtualMfaDevicesResponse] =
    FF.liftF(ListVirtualMFADevicesOp(request))

  def putGroupPolicy(
    request: PutGroupPolicyRequest
  ): IamIO[PutGroupPolicyResponse] =
    FF.liftF(PutGroupPolicyOp(request))

  def putRolePermissionsBoundary(
    request: PutRolePermissionsBoundaryRequest
  ): IamIO[PutRolePermissionsBoundaryResponse] =
    FF.liftF(PutRolePermissionsBoundaryOp(request))

  def putRolePolicy(
    request: PutRolePolicyRequest
  ): IamIO[PutRolePolicyResponse] =
    FF.liftF(PutRolePolicyOp(request))

  def putUserPermissionsBoundary(
    request: PutUserPermissionsBoundaryRequest
  ): IamIO[PutUserPermissionsBoundaryResponse] =
    FF.liftF(PutUserPermissionsBoundaryOp(request))

  def putUserPolicy(
    request: PutUserPolicyRequest
  ): IamIO[PutUserPolicyResponse] =
    FF.liftF(PutUserPolicyOp(request))

  def removeClientIDFromOpenIDConnectProvider(
    request: RemoveClientIdFromOpenIdConnectProviderRequest
  ): IamIO[RemoveClientIdFromOpenIdConnectProviderResponse] =
    FF.liftF(RemoveClientIDFromOpenIDConnectProviderOp(request))

  def removeRoleFromInstanceProfile(
    request: RemoveRoleFromInstanceProfileRequest
  ): IamIO[RemoveRoleFromInstanceProfileResponse] =
    FF.liftF(RemoveRoleFromInstanceProfileOp(request))

  def removeUserFromGroup(
    request: RemoveUserFromGroupRequest
  ): IamIO[RemoveUserFromGroupResponse] =
    FF.liftF(RemoveUserFromGroupOp(request))

  def resetServiceSpecificCredential(
    request: ResetServiceSpecificCredentialRequest
  ): IamIO[ResetServiceSpecificCredentialResponse] =
    FF.liftF(ResetServiceSpecificCredentialOp(request))

  def resyncMFADevice(
    request: ResyncMfaDeviceRequest
  ): IamIO[ResyncMfaDeviceResponse] =
    FF.liftF(ResyncMFADeviceOp(request))

  def setDefaultPolicyVersion(
    request: SetDefaultPolicyVersionRequest
  ): IamIO[SetDefaultPolicyVersionResponse] =
    FF.liftF(SetDefaultPolicyVersionOp(request))

  def setSecurityTokenServicePreferences(
    request: SetSecurityTokenServicePreferencesRequest
  ): IamIO[SetSecurityTokenServicePreferencesResponse] =
    FF.liftF(SetSecurityTokenServicePreferencesOp(request))

  def simulateCustomPolicy(
    request: SimulateCustomPolicyRequest
  ): IamIO[SimulateCustomPolicyResponse] =
    FF.liftF(SimulateCustomPolicyOp(request))

  def simulatePrincipalPolicy(
    request: SimulatePrincipalPolicyRequest
  ): IamIO[SimulatePrincipalPolicyResponse] =
    FF.liftF(SimulatePrincipalPolicyOp(request))

  def tagInstanceProfile(
    request: TagInstanceProfileRequest
  ): IamIO[TagInstanceProfileResponse] =
    FF.liftF(TagInstanceProfileOp(request))

  def tagMFADevice(
    request: TagMfaDeviceRequest
  ): IamIO[TagMfaDeviceResponse] =
    FF.liftF(TagMFADeviceOp(request))

  def tagOpenIDConnectProvider(
    request: TagOpenIdConnectProviderRequest
  ): IamIO[TagOpenIdConnectProviderResponse] =
    FF.liftF(TagOpenIDConnectProviderOp(request))

  def tagPolicy(
    request: TagPolicyRequest
  ): IamIO[TagPolicyResponse] =
    FF.liftF(TagPolicyOp(request))

  def tagRole(
    request: TagRoleRequest
  ): IamIO[TagRoleResponse] =
    FF.liftF(TagRoleOp(request))

  def tagSAMLProvider(
    request: TagSamlProviderRequest
  ): IamIO[TagSamlProviderResponse] =
    FF.liftF(TagSAMLProviderOp(request))

  def tagServerCertificate(
    request: TagServerCertificateRequest
  ): IamIO[TagServerCertificateResponse] =
    FF.liftF(TagServerCertificateOp(request))

  def tagUser(
    request: TagUserRequest
  ): IamIO[TagUserResponse] =
    FF.liftF(TagUserOp(request))

  def untagInstanceProfile(
    request: UntagInstanceProfileRequest
  ): IamIO[UntagInstanceProfileResponse] =
    FF.liftF(UntagInstanceProfileOp(request))

  def untagMFADevice(
    request: UntagMfaDeviceRequest
  ): IamIO[UntagMfaDeviceResponse] =
    FF.liftF(UntagMFADeviceOp(request))

  def untagOpenIDConnectProvider(
    request: UntagOpenIdConnectProviderRequest
  ): IamIO[UntagOpenIdConnectProviderResponse] =
    FF.liftF(UntagOpenIDConnectProviderOp(request))

  def untagPolicy(
    request: UntagPolicyRequest
  ): IamIO[UntagPolicyResponse] =
    FF.liftF(UntagPolicyOp(request))

  def untagRole(
    request: UntagRoleRequest
  ): IamIO[UntagRoleResponse] =
    FF.liftF(UntagRoleOp(request))

  def untagSAMLProvider(
    request: UntagSamlProviderRequest
  ): IamIO[UntagSamlProviderResponse] =
    FF.liftF(UntagSAMLProviderOp(request))

  def untagServerCertificate(
    request: UntagServerCertificateRequest
  ): IamIO[UntagServerCertificateResponse] =
    FF.liftF(UntagServerCertificateOp(request))

  def untagUser(
    request: UntagUserRequest
  ): IamIO[UntagUserResponse] =
    FF.liftF(UntagUserOp(request))

  def updateAccessKey(
    request: UpdateAccessKeyRequest
  ): IamIO[UpdateAccessKeyResponse] =
    FF.liftF(UpdateAccessKeyOp(request))

  def updateAccountPasswordPolicy(
    request: UpdateAccountPasswordPolicyRequest
  ): IamIO[UpdateAccountPasswordPolicyResponse] =
    FF.liftF(UpdateAccountPasswordPolicyOp(request))

  def updateAssumeRolePolicy(
    request: UpdateAssumeRolePolicyRequest
  ): IamIO[UpdateAssumeRolePolicyResponse] =
    FF.liftF(UpdateAssumeRolePolicyOp(request))

  def updateGroup(
    request: UpdateGroupRequest
  ): IamIO[UpdateGroupResponse] =
    FF.liftF(UpdateGroupOp(request))

  def updateLoginProfile(
    request: UpdateLoginProfileRequest
  ): IamIO[UpdateLoginProfileResponse] =
    FF.liftF(UpdateLoginProfileOp(request))

  def updateOpenIDConnectProviderThumbprint(
    request: UpdateOpenIdConnectProviderThumbprintRequest
  ): IamIO[UpdateOpenIdConnectProviderThumbprintResponse] =
    FF.liftF(UpdateOpenIDConnectProviderThumbprintOp(request))

  def updateRole(
    request: UpdateRoleRequest
  ): IamIO[UpdateRoleResponse] =
    FF.liftF(UpdateRoleOp(request))

  def updateRoleDescription(
    request: UpdateRoleDescriptionRequest
  ): IamIO[UpdateRoleDescriptionResponse] =
    FF.liftF(UpdateRoleDescriptionOp(request))

  def updateSAMLProvider(
    request: UpdateSamlProviderRequest
  ): IamIO[UpdateSamlProviderResponse] =
    FF.liftF(UpdateSAMLProviderOp(request))

  def updateSSHPublicKey(
    request: UpdateSshPublicKeyRequest
  ): IamIO[UpdateSshPublicKeyResponse] =
    FF.liftF(UpdateSSHPublicKeyOp(request))

  def updateServerCertificate(
    request: UpdateServerCertificateRequest
  ): IamIO[UpdateServerCertificateResponse] =
    FF.liftF(UpdateServerCertificateOp(request))

  def updateServiceSpecificCredential(
    request: UpdateServiceSpecificCredentialRequest
  ): IamIO[UpdateServiceSpecificCredentialResponse] =
    FF.liftF(UpdateServiceSpecificCredentialOp(request))

  def updateSigningCertificate(
    request: UpdateSigningCertificateRequest
  ): IamIO[UpdateSigningCertificateResponse] =
    FF.liftF(UpdateSigningCertificateOp(request))

  def updateUser(
    request: UpdateUserRequest
  ): IamIO[UpdateUserResponse] =
    FF.liftF(UpdateUserOp(request))

  def uploadSSHPublicKey(
    request: UploadSshPublicKeyRequest
  ): IamIO[UploadSshPublicKeyResponse] =
    FF.liftF(UploadSSHPublicKeyOp(request))

  def uploadServerCertificate(
    request: UploadServerCertificateRequest
  ): IamIO[UploadServerCertificateResponse] =
    FF.liftF(UploadServerCertificateOp(request))

  def uploadSigningCertificate(
    request: UploadSigningCertificateRequest
  ): IamIO[UploadSigningCertificateResponse] =
    FF.liftF(UploadSigningCertificateOp(request))
}
