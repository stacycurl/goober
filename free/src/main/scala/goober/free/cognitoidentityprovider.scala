package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient
import software.amazon.awssdk.services.cognitoidentityprovider.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cognitoidentityprovider { module =>

  // Free monad over CognitoIdentityProviderOp
  type CognitoIdentityProviderIO[A] = FF[CognitoIdentityProviderOp, A]

  sealed trait CognitoIdentityProviderOp[A] {
    def visit[F[_]](visitor: CognitoIdentityProviderOp.Visitor[F]): F[A]
  }

  object CognitoIdentityProviderOp {
    // Given a CognitoIdentityProviderClient we can embed a CognitoIdentityProviderIO program in any algebra that understands embedding.
    implicit val CognitoIdentityProviderOpEmbeddable: Embeddable[CognitoIdentityProviderOp, CognitoIdentityProviderClient] = new Embeddable[CognitoIdentityProviderOp, CognitoIdentityProviderClient] {
      def embed[A](client: CognitoIdentityProviderClient, io: CognitoIdentityProviderIO[A]): Embedded[A] = Embedded.CognitoIdentityProvider(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CognitoIdentityProviderOp.Visitor[Kleisli[M, CognitoIdentityProviderClient, *]] {
        def addCustomAttributes(
          request: AddCustomAttributesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AddCustomAttributesResponse] =
          primitive(_.addCustomAttributes(request))

        def adminAddUserToGroup(
          request: AdminAddUserToGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminAddUserToGroupResponse] =
          primitive(_.adminAddUserToGroup(request))

        def adminConfirmSignUp(
          request: AdminConfirmSignUpRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminConfirmSignUpResponse] =
          primitive(_.adminConfirmSignUp(request))

        def adminCreateUser(
          request: AdminCreateUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminCreateUserResponse] =
          primitive(_.adminCreateUser(request))

        def adminDeleteUser(
          request: AdminDeleteUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminDeleteUserResponse] =
          primitive(_.adminDeleteUser(request))

        def adminDeleteUserAttributes(
          request: AdminDeleteUserAttributesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminDeleteUserAttributesResponse] =
          primitive(_.adminDeleteUserAttributes(request))

        def adminDisableProviderForUser(
          request: AdminDisableProviderForUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminDisableProviderForUserResponse] =
          primitive(_.adminDisableProviderForUser(request))

        def adminDisableUser(
          request: AdminDisableUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminDisableUserResponse] =
          primitive(_.adminDisableUser(request))

        def adminEnableUser(
          request: AdminEnableUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminEnableUserResponse] =
          primitive(_.adminEnableUser(request))

        def adminForgetDevice(
          request: AdminForgetDeviceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminForgetDeviceResponse] =
          primitive(_.adminForgetDevice(request))

        def adminGetDevice(
          request: AdminGetDeviceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminGetDeviceResponse] =
          primitive(_.adminGetDevice(request))

        def adminGetUser(
          request: AdminGetUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminGetUserResponse] =
          primitive(_.adminGetUser(request))

        def adminInitiateAuth(
          request: AdminInitiateAuthRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminInitiateAuthResponse] =
          primitive(_.adminInitiateAuth(request))

        def adminLinkProviderForUser(
          request: AdminLinkProviderForUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminLinkProviderForUserResponse] =
          primitive(_.adminLinkProviderForUser(request))

        def adminListDevices(
          request: AdminListDevicesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminListDevicesResponse] =
          primitive(_.adminListDevices(request))

        def adminListGroupsForUser(
          request: AdminListGroupsForUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminListGroupsForUserResponse] =
          primitive(_.adminListGroupsForUser(request))

        def adminListUserAuthEvents(
          request: AdminListUserAuthEventsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminListUserAuthEventsResponse] =
          primitive(_.adminListUserAuthEvents(request))

        def adminRemoveUserFromGroup(
          request: AdminRemoveUserFromGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminRemoveUserFromGroupResponse] =
          primitive(_.adminRemoveUserFromGroup(request))

        def adminResetUserPassword(
          request: AdminResetUserPasswordRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminResetUserPasswordResponse] =
          primitive(_.adminResetUserPassword(request))

        def adminRespondToAuthChallenge(
          request: AdminRespondToAuthChallengeRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminRespondToAuthChallengeResponse] =
          primitive(_.adminRespondToAuthChallenge(request))

        def adminSetUserMFAPreference(
          request: AdminSetUserMfaPreferenceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminSetUserMfaPreferenceResponse] =
          primitive(_.adminSetUserMFAPreference(request))

        def adminSetUserPassword(
          request: AdminSetUserPasswordRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminSetUserPasswordResponse] =
          primitive(_.adminSetUserPassword(request))

        def adminSetUserSettings(
          request: AdminSetUserSettingsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminSetUserSettingsResponse] =
          primitive(_.adminSetUserSettings(request))

        def adminUpdateAuthEventFeedback(
          request: AdminUpdateAuthEventFeedbackRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminUpdateAuthEventFeedbackResponse] =
          primitive(_.adminUpdateAuthEventFeedback(request))

        def adminUpdateDeviceStatus(
          request: AdminUpdateDeviceStatusRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminUpdateDeviceStatusResponse] =
          primitive(_.adminUpdateDeviceStatus(request))

        def adminUpdateUserAttributes(
          request: AdminUpdateUserAttributesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminUpdateUserAttributesResponse] =
          primitive(_.adminUpdateUserAttributes(request))

        def adminUserGlobalSignOut(
          request: AdminUserGlobalSignOutRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AdminUserGlobalSignOutResponse] =
          primitive(_.adminUserGlobalSignOut(request))

        def associateSoftwareToken(
          request: AssociateSoftwareTokenRequest
        ): Kleisli[M, CognitoIdentityProviderClient, AssociateSoftwareTokenResponse] =
          primitive(_.associateSoftwareToken(request))

        def changePassword(
          request: ChangePasswordRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ChangePasswordResponse] =
          primitive(_.changePassword(request))

        def confirmDevice(
          request: ConfirmDeviceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ConfirmDeviceResponse] =
          primitive(_.confirmDevice(request))

        def confirmForgotPassword(
          request: ConfirmForgotPasswordRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ConfirmForgotPasswordResponse] =
          primitive(_.confirmForgotPassword(request))

        def confirmSignUp(
          request: ConfirmSignUpRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ConfirmSignUpResponse] =
          primitive(_.confirmSignUp(request))

        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def createIdentityProvider(
          request: CreateIdentityProviderRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateIdentityProviderResponse] =
          primitive(_.createIdentityProvider(request))

        def createResourceServer(
          request: CreateResourceServerRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateResourceServerResponse] =
          primitive(_.createResourceServer(request))

        def createUserImportJob(
          request: CreateUserImportJobRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateUserImportJobResponse] =
          primitive(_.createUserImportJob(request))

        def createUserPool(
          request: CreateUserPoolRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateUserPoolResponse] =
          primitive(_.createUserPool(request))

        def createUserPoolClient(
          request: CreateUserPoolClientRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateUserPoolClientResponse] =
          primitive(_.createUserPoolClient(request))

        def createUserPoolDomain(
          request: CreateUserPoolDomainRequest
        ): Kleisli[M, CognitoIdentityProviderClient, CreateUserPoolDomainResponse] =
          primitive(_.createUserPoolDomain(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def deleteIdentityProvider(
          request: DeleteIdentityProviderRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteIdentityProviderResponse] =
          primitive(_.deleteIdentityProvider(request))

        def deleteResourceServer(
          request: DeleteResourceServerRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteResourceServerResponse] =
          primitive(_.deleteResourceServer(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def deleteUserAttributes(
          request: DeleteUserAttributesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteUserAttributesResponse] =
          primitive(_.deleteUserAttributes(request))

        def deleteUserPool(
          request: DeleteUserPoolRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteUserPoolResponse] =
          primitive(_.deleteUserPool(request))

        def deleteUserPoolClient(
          request: DeleteUserPoolClientRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteUserPoolClientResponse] =
          primitive(_.deleteUserPoolClient(request))

        def deleteUserPoolDomain(
          request: DeleteUserPoolDomainRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DeleteUserPoolDomainResponse] =
          primitive(_.deleteUserPoolDomain(request))

        def describeIdentityProvider(
          request: DescribeIdentityProviderRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeIdentityProviderResponse] =
          primitive(_.describeIdentityProvider(request))

        def describeResourceServer(
          request: DescribeResourceServerRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeResourceServerResponse] =
          primitive(_.describeResourceServer(request))

        def describeRiskConfiguration(
          request: DescribeRiskConfigurationRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeRiskConfigurationResponse] =
          primitive(_.describeRiskConfiguration(request))

        def describeUserImportJob(
          request: DescribeUserImportJobRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeUserImportJobResponse] =
          primitive(_.describeUserImportJob(request))

        def describeUserPool(
          request: DescribeUserPoolRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeUserPoolResponse] =
          primitive(_.describeUserPool(request))

        def describeUserPoolClient(
          request: DescribeUserPoolClientRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeUserPoolClientResponse] =
          primitive(_.describeUserPoolClient(request))

        def describeUserPoolDomain(
          request: DescribeUserPoolDomainRequest
        ): Kleisli[M, CognitoIdentityProviderClient, DescribeUserPoolDomainResponse] =
          primitive(_.describeUserPoolDomain(request))

        def forgetDevice(
          request: ForgetDeviceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ForgetDeviceResponse] =
          primitive(_.forgetDevice(request))

        def forgotPassword(
          request: ForgotPasswordRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ForgotPasswordResponse] =
          primitive(_.forgotPassword(request))

        def getCSVHeader(
          request: GetCsvHeaderRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetCsvHeaderResponse] =
          primitive(_.getCSVHeader(request))

        def getDevice(
          request: GetDeviceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetDeviceResponse] =
          primitive(_.getDevice(request))

        def getGroup(
          request: GetGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetGroupResponse] =
          primitive(_.getGroup(request))

        def getIdentityProviderByIdentifier(
          request: GetIdentityProviderByIdentifierRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetIdentityProviderByIdentifierResponse] =
          primitive(_.getIdentityProviderByIdentifier(request))

        def getSigningCertificate(
          request: GetSigningCertificateRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetSigningCertificateResponse] =
          primitive(_.getSigningCertificate(request))

        def getUICustomization(
          request: GetUiCustomizationRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetUiCustomizationResponse] =
          primitive(_.getUICustomization(request))

        def getUser(
          request: GetUserRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetUserResponse] =
          primitive(_.getUser(request))

        def getUserAttributeVerificationCode(
          request: GetUserAttributeVerificationCodeRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetUserAttributeVerificationCodeResponse] =
          primitive(_.getUserAttributeVerificationCode(request))

        def getUserPoolMfaConfig(
          request: GetUserPoolMfaConfigRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GetUserPoolMfaConfigResponse] =
          primitive(_.getUserPoolMfaConfig(request))

        def globalSignOut(
          request: GlobalSignOutRequest
        ): Kleisli[M, CognitoIdentityProviderClient, GlobalSignOutResponse] =
          primitive(_.globalSignOut(request))

        def initiateAuth(
          request: InitiateAuthRequest
        ): Kleisli[M, CognitoIdentityProviderClient, InitiateAuthResponse] =
          primitive(_.initiateAuth(request))

        def listDevices(
          request: ListDevicesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListDevicesResponse] =
          primitive(_.listDevices(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def listIdentityProviders(
          request: ListIdentityProvidersRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListIdentityProvidersResponse] =
          primitive(_.listIdentityProviders(request))

        def listResourceServers(
          request: ListResourceServersRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListResourceServersResponse] =
          primitive(_.listResourceServers(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listUserImportJobs(
          request: ListUserImportJobsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListUserImportJobsResponse] =
          primitive(_.listUserImportJobs(request))

        def listUserPoolClients(
          request: ListUserPoolClientsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListUserPoolClientsResponse] =
          primitive(_.listUserPoolClients(request))

        def listUserPools(
          request: ListUserPoolsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListUserPoolsResponse] =
          primitive(_.listUserPools(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def listUsersInGroup(
          request: ListUsersInGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ListUsersInGroupResponse] =
          primitive(_.listUsersInGroup(request))

        def resendConfirmationCode(
          request: ResendConfirmationCodeRequest
        ): Kleisli[M, CognitoIdentityProviderClient, ResendConfirmationCodeResponse] =
          primitive(_.resendConfirmationCode(request))

        def respondToAuthChallenge(
          request: RespondToAuthChallengeRequest
        ): Kleisli[M, CognitoIdentityProviderClient, RespondToAuthChallengeResponse] =
          primitive(_.respondToAuthChallenge(request))

        def revokeToken(
          request: RevokeTokenRequest
        ): Kleisli[M, CognitoIdentityProviderClient, RevokeTokenResponse] =
          primitive(_.revokeToken(request))

        def setRiskConfiguration(
          request: SetRiskConfigurationRequest
        ): Kleisli[M, CognitoIdentityProviderClient, SetRiskConfigurationResponse] =
          primitive(_.setRiskConfiguration(request))

        def setUICustomization(
          request: SetUiCustomizationRequest
        ): Kleisli[M, CognitoIdentityProviderClient, SetUiCustomizationResponse] =
          primitive(_.setUICustomization(request))

        def setUserMFAPreference(
          request: SetUserMfaPreferenceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, SetUserMfaPreferenceResponse] =
          primitive(_.setUserMFAPreference(request))

        def setUserPoolMfaConfig(
          request: SetUserPoolMfaConfigRequest
        ): Kleisli[M, CognitoIdentityProviderClient, SetUserPoolMfaConfigResponse] =
          primitive(_.setUserPoolMfaConfig(request))

        def setUserSettings(
          request: SetUserSettingsRequest
        ): Kleisli[M, CognitoIdentityProviderClient, SetUserSettingsResponse] =
          primitive(_.setUserSettings(request))

        def signUp(
          request: SignUpRequest
        ): Kleisli[M, CognitoIdentityProviderClient, SignUpResponse] =
          primitive(_.signUp(request))

        def startUserImportJob(
          request: StartUserImportJobRequest
        ): Kleisli[M, CognitoIdentityProviderClient, StartUserImportJobResponse] =
          primitive(_.startUserImportJob(request))

        def stopUserImportJob(
          request: StopUserImportJobRequest
        ): Kleisli[M, CognitoIdentityProviderClient, StopUserImportJobResponse] =
          primitive(_.stopUserImportJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAuthEventFeedback(
          request: UpdateAuthEventFeedbackRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateAuthEventFeedbackResponse] =
          primitive(_.updateAuthEventFeedback(request))

        def updateDeviceStatus(
          request: UpdateDeviceStatusRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateDeviceStatusResponse] =
          primitive(_.updateDeviceStatus(request))

        def updateGroup(
          request: UpdateGroupRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateGroupResponse] =
          primitive(_.updateGroup(request))

        def updateIdentityProvider(
          request: UpdateIdentityProviderRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateIdentityProviderResponse] =
          primitive(_.updateIdentityProvider(request))

        def updateResourceServer(
          request: UpdateResourceServerRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateResourceServerResponse] =
          primitive(_.updateResourceServer(request))

        def updateUserAttributes(
          request: UpdateUserAttributesRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateUserAttributesResponse] =
          primitive(_.updateUserAttributes(request))

        def updateUserPool(
          request: UpdateUserPoolRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateUserPoolResponse] =
          primitive(_.updateUserPool(request))

        def updateUserPoolClient(
          request: UpdateUserPoolClientRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateUserPoolClientResponse] =
          primitive(_.updateUserPoolClient(request))

        def updateUserPoolDomain(
          request: UpdateUserPoolDomainRequest
        ): Kleisli[M, CognitoIdentityProviderClient, UpdateUserPoolDomainResponse] =
          primitive(_.updateUserPoolDomain(request))

        def verifySoftwareToken(
          request: VerifySoftwareTokenRequest
        ): Kleisli[M, CognitoIdentityProviderClient, VerifySoftwareTokenResponse] =
          primitive(_.verifySoftwareToken(request))

        def verifyUserAttribute(
          request: VerifyUserAttributeRequest
        ): Kleisli[M, CognitoIdentityProviderClient, VerifyUserAttributeResponse] =
          primitive(_.verifyUserAttribute(request))

        def primitive[A](
          f: CognitoIdentityProviderClient => A
        ): Kleisli[M, CognitoIdentityProviderClient, A]
      }
    }

    trait Visitor[F[_]] extends (CognitoIdentityProviderOp ~> F) {
      final def apply[A](op: CognitoIdentityProviderOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addCustomAttributes(
        request: AddCustomAttributesRequest
      ): F[AddCustomAttributesResponse]

      def adminAddUserToGroup(
        request: AdminAddUserToGroupRequest
      ): F[AdminAddUserToGroupResponse]

      def adminConfirmSignUp(
        request: AdminConfirmSignUpRequest
      ): F[AdminConfirmSignUpResponse]

      def adminCreateUser(
        request: AdminCreateUserRequest
      ): F[AdminCreateUserResponse]

      def adminDeleteUser(
        request: AdminDeleteUserRequest
      ): F[AdminDeleteUserResponse]

      def adminDeleteUserAttributes(
        request: AdminDeleteUserAttributesRequest
      ): F[AdminDeleteUserAttributesResponse]

      def adminDisableProviderForUser(
        request: AdminDisableProviderForUserRequest
      ): F[AdminDisableProviderForUserResponse]

      def adminDisableUser(
        request: AdminDisableUserRequest
      ): F[AdminDisableUserResponse]

      def adminEnableUser(
        request: AdminEnableUserRequest
      ): F[AdminEnableUserResponse]

      def adminForgetDevice(
        request: AdminForgetDeviceRequest
      ): F[AdminForgetDeviceResponse]

      def adminGetDevice(
        request: AdminGetDeviceRequest
      ): F[AdminGetDeviceResponse]

      def adminGetUser(
        request: AdminGetUserRequest
      ): F[AdminGetUserResponse]

      def adminInitiateAuth(
        request: AdminInitiateAuthRequest
      ): F[AdminInitiateAuthResponse]

      def adminLinkProviderForUser(
        request: AdminLinkProviderForUserRequest
      ): F[AdminLinkProviderForUserResponse]

      def adminListDevices(
        request: AdminListDevicesRequest
      ): F[AdminListDevicesResponse]

      def adminListGroupsForUser(
        request: AdminListGroupsForUserRequest
      ): F[AdminListGroupsForUserResponse]

      def adminListUserAuthEvents(
        request: AdminListUserAuthEventsRequest
      ): F[AdminListUserAuthEventsResponse]

      def adminRemoveUserFromGroup(
        request: AdminRemoveUserFromGroupRequest
      ): F[AdminRemoveUserFromGroupResponse]

      def adminResetUserPassword(
        request: AdminResetUserPasswordRequest
      ): F[AdminResetUserPasswordResponse]

      def adminRespondToAuthChallenge(
        request: AdminRespondToAuthChallengeRequest
      ): F[AdminRespondToAuthChallengeResponse]

      def adminSetUserMFAPreference(
        request: AdminSetUserMfaPreferenceRequest
      ): F[AdminSetUserMfaPreferenceResponse]

      def adminSetUserPassword(
        request: AdminSetUserPasswordRequest
      ): F[AdminSetUserPasswordResponse]

      def adminSetUserSettings(
        request: AdminSetUserSettingsRequest
      ): F[AdminSetUserSettingsResponse]

      def adminUpdateAuthEventFeedback(
        request: AdminUpdateAuthEventFeedbackRequest
      ): F[AdminUpdateAuthEventFeedbackResponse]

      def adminUpdateDeviceStatus(
        request: AdminUpdateDeviceStatusRequest
      ): F[AdminUpdateDeviceStatusResponse]

      def adminUpdateUserAttributes(
        request: AdminUpdateUserAttributesRequest
      ): F[AdminUpdateUserAttributesResponse]

      def adminUserGlobalSignOut(
        request: AdminUserGlobalSignOutRequest
      ): F[AdminUserGlobalSignOutResponse]

      def associateSoftwareToken(
        request: AssociateSoftwareTokenRequest
      ): F[AssociateSoftwareTokenResponse]

      def changePassword(
        request: ChangePasswordRequest
      ): F[ChangePasswordResponse]

      def confirmDevice(
        request: ConfirmDeviceRequest
      ): F[ConfirmDeviceResponse]

      def confirmForgotPassword(
        request: ConfirmForgotPasswordRequest
      ): F[ConfirmForgotPasswordResponse]

      def confirmSignUp(
        request: ConfirmSignUpRequest
      ): F[ConfirmSignUpResponse]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def createIdentityProvider(
        request: CreateIdentityProviderRequest
      ): F[CreateIdentityProviderResponse]

      def createResourceServer(
        request: CreateResourceServerRequest
      ): F[CreateResourceServerResponse]

      def createUserImportJob(
        request: CreateUserImportJobRequest
      ): F[CreateUserImportJobResponse]

      def createUserPool(
        request: CreateUserPoolRequest
      ): F[CreateUserPoolResponse]

      def createUserPoolClient(
        request: CreateUserPoolClientRequest
      ): F[CreateUserPoolClientResponse]

      def createUserPoolDomain(
        request: CreateUserPoolDomainRequest
      ): F[CreateUserPoolDomainResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def deleteIdentityProvider(
        request: DeleteIdentityProviderRequest
      ): F[DeleteIdentityProviderResponse]

      def deleteResourceServer(
        request: DeleteResourceServerRequest
      ): F[DeleteResourceServerResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def deleteUserAttributes(
        request: DeleteUserAttributesRequest
      ): F[DeleteUserAttributesResponse]

      def deleteUserPool(
        request: DeleteUserPoolRequest
      ): F[DeleteUserPoolResponse]

      def deleteUserPoolClient(
        request: DeleteUserPoolClientRequest
      ): F[DeleteUserPoolClientResponse]

      def deleteUserPoolDomain(
        request: DeleteUserPoolDomainRequest
      ): F[DeleteUserPoolDomainResponse]

      def describeIdentityProvider(
        request: DescribeIdentityProviderRequest
      ): F[DescribeIdentityProviderResponse]

      def describeResourceServer(
        request: DescribeResourceServerRequest
      ): F[DescribeResourceServerResponse]

      def describeRiskConfiguration(
        request: DescribeRiskConfigurationRequest
      ): F[DescribeRiskConfigurationResponse]

      def describeUserImportJob(
        request: DescribeUserImportJobRequest
      ): F[DescribeUserImportJobResponse]

      def describeUserPool(
        request: DescribeUserPoolRequest
      ): F[DescribeUserPoolResponse]

      def describeUserPoolClient(
        request: DescribeUserPoolClientRequest
      ): F[DescribeUserPoolClientResponse]

      def describeUserPoolDomain(
        request: DescribeUserPoolDomainRequest
      ): F[DescribeUserPoolDomainResponse]

      def forgetDevice(
        request: ForgetDeviceRequest
      ): F[ForgetDeviceResponse]

      def forgotPassword(
        request: ForgotPasswordRequest
      ): F[ForgotPasswordResponse]

      def getCSVHeader(
        request: GetCsvHeaderRequest
      ): F[GetCsvHeaderResponse]

      def getDevice(
        request: GetDeviceRequest
      ): F[GetDeviceResponse]

      def getGroup(
        request: GetGroupRequest
      ): F[GetGroupResponse]

      def getIdentityProviderByIdentifier(
        request: GetIdentityProviderByIdentifierRequest
      ): F[GetIdentityProviderByIdentifierResponse]

      def getSigningCertificate(
        request: GetSigningCertificateRequest
      ): F[GetSigningCertificateResponse]

      def getUICustomization(
        request: GetUiCustomizationRequest
      ): F[GetUiCustomizationResponse]

      def getUser(
        request: GetUserRequest
      ): F[GetUserResponse]

      def getUserAttributeVerificationCode(
        request: GetUserAttributeVerificationCodeRequest
      ): F[GetUserAttributeVerificationCodeResponse]

      def getUserPoolMfaConfig(
        request: GetUserPoolMfaConfigRequest
      ): F[GetUserPoolMfaConfigResponse]

      def globalSignOut(
        request: GlobalSignOutRequest
      ): F[GlobalSignOutResponse]

      def initiateAuth(
        request: InitiateAuthRequest
      ): F[InitiateAuthResponse]

      def listDevices(
        request: ListDevicesRequest
      ): F[ListDevicesResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def listIdentityProviders(
        request: ListIdentityProvidersRequest
      ): F[ListIdentityProvidersResponse]

      def listResourceServers(
        request: ListResourceServersRequest
      ): F[ListResourceServersResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listUserImportJobs(
        request: ListUserImportJobsRequest
      ): F[ListUserImportJobsResponse]

      def listUserPoolClients(
        request: ListUserPoolClientsRequest
      ): F[ListUserPoolClientsResponse]

      def listUserPools(
        request: ListUserPoolsRequest
      ): F[ListUserPoolsResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def listUsersInGroup(
        request: ListUsersInGroupRequest
      ): F[ListUsersInGroupResponse]

      def resendConfirmationCode(
        request: ResendConfirmationCodeRequest
      ): F[ResendConfirmationCodeResponse]

      def respondToAuthChallenge(
        request: RespondToAuthChallengeRequest
      ): F[RespondToAuthChallengeResponse]

      def revokeToken(
        request: RevokeTokenRequest
      ): F[RevokeTokenResponse]

      def setRiskConfiguration(
        request: SetRiskConfigurationRequest
      ): F[SetRiskConfigurationResponse]

      def setUICustomization(
        request: SetUiCustomizationRequest
      ): F[SetUiCustomizationResponse]

      def setUserMFAPreference(
        request: SetUserMfaPreferenceRequest
      ): F[SetUserMfaPreferenceResponse]

      def setUserPoolMfaConfig(
        request: SetUserPoolMfaConfigRequest
      ): F[SetUserPoolMfaConfigResponse]

      def setUserSettings(
        request: SetUserSettingsRequest
      ): F[SetUserSettingsResponse]

      def signUp(
        request: SignUpRequest
      ): F[SignUpResponse]

      def startUserImportJob(
        request: StartUserImportJobRequest
      ): F[StartUserImportJobResponse]

      def stopUserImportJob(
        request: StopUserImportJobRequest
      ): F[StopUserImportJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAuthEventFeedback(
        request: UpdateAuthEventFeedbackRequest
      ): F[UpdateAuthEventFeedbackResponse]

      def updateDeviceStatus(
        request: UpdateDeviceStatusRequest
      ): F[UpdateDeviceStatusResponse]

      def updateGroup(
        request: UpdateGroupRequest
      ): F[UpdateGroupResponse]

      def updateIdentityProvider(
        request: UpdateIdentityProviderRequest
      ): F[UpdateIdentityProviderResponse]

      def updateResourceServer(
        request: UpdateResourceServerRequest
      ): F[UpdateResourceServerResponse]

      def updateUserAttributes(
        request: UpdateUserAttributesRequest
      ): F[UpdateUserAttributesResponse]

      def updateUserPool(
        request: UpdateUserPoolRequest
      ): F[UpdateUserPoolResponse]

      def updateUserPoolClient(
        request: UpdateUserPoolClientRequest
      ): F[UpdateUserPoolClientResponse]

      def updateUserPoolDomain(
        request: UpdateUserPoolDomainRequest
      ): F[UpdateUserPoolDomainResponse]

      def verifySoftwareToken(
        request: VerifySoftwareTokenRequest
      ): F[VerifySoftwareTokenResponse]

      def verifyUserAttribute(
        request: VerifyUserAttributeRequest
      ): F[VerifyUserAttributeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CognitoIdentityProviderOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddCustomAttributesOp(
      request: AddCustomAttributesRequest
    ) extends CognitoIdentityProviderOp[AddCustomAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddCustomAttributesResponse] =
        visitor.addCustomAttributes(request)
    }

    final case class AdminAddUserToGroupOp(
      request: AdminAddUserToGroupRequest
    ) extends CognitoIdentityProviderOp[AdminAddUserToGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminAddUserToGroupResponse] =
        visitor.adminAddUserToGroup(request)
    }

    final case class AdminConfirmSignUpOp(
      request: AdminConfirmSignUpRequest
    ) extends CognitoIdentityProviderOp[AdminConfirmSignUpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminConfirmSignUpResponse] =
        visitor.adminConfirmSignUp(request)
    }

    final case class AdminCreateUserOp(
      request: AdminCreateUserRequest
    ) extends CognitoIdentityProviderOp[AdminCreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminCreateUserResponse] =
        visitor.adminCreateUser(request)
    }

    final case class AdminDeleteUserOp(
      request: AdminDeleteUserRequest
    ) extends CognitoIdentityProviderOp[AdminDeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminDeleteUserResponse] =
        visitor.adminDeleteUser(request)
    }

    final case class AdminDeleteUserAttributesOp(
      request: AdminDeleteUserAttributesRequest
    ) extends CognitoIdentityProviderOp[AdminDeleteUserAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminDeleteUserAttributesResponse] =
        visitor.adminDeleteUserAttributes(request)
    }

    final case class AdminDisableProviderForUserOp(
      request: AdminDisableProviderForUserRequest
    ) extends CognitoIdentityProviderOp[AdminDisableProviderForUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminDisableProviderForUserResponse] =
        visitor.adminDisableProviderForUser(request)
    }

    final case class AdminDisableUserOp(
      request: AdminDisableUserRequest
    ) extends CognitoIdentityProviderOp[AdminDisableUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminDisableUserResponse] =
        visitor.adminDisableUser(request)
    }

    final case class AdminEnableUserOp(
      request: AdminEnableUserRequest
    ) extends CognitoIdentityProviderOp[AdminEnableUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminEnableUserResponse] =
        visitor.adminEnableUser(request)
    }

    final case class AdminForgetDeviceOp(
      request: AdminForgetDeviceRequest
    ) extends CognitoIdentityProviderOp[AdminForgetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminForgetDeviceResponse] =
        visitor.adminForgetDevice(request)
    }

    final case class AdminGetDeviceOp(
      request: AdminGetDeviceRequest
    ) extends CognitoIdentityProviderOp[AdminGetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminGetDeviceResponse] =
        visitor.adminGetDevice(request)
    }

    final case class AdminGetUserOp(
      request: AdminGetUserRequest
    ) extends CognitoIdentityProviderOp[AdminGetUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminGetUserResponse] =
        visitor.adminGetUser(request)
    }

    final case class AdminInitiateAuthOp(
      request: AdminInitiateAuthRequest
    ) extends CognitoIdentityProviderOp[AdminInitiateAuthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminInitiateAuthResponse] =
        visitor.adminInitiateAuth(request)
    }

    final case class AdminLinkProviderForUserOp(
      request: AdminLinkProviderForUserRequest
    ) extends CognitoIdentityProviderOp[AdminLinkProviderForUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminLinkProviderForUserResponse] =
        visitor.adminLinkProviderForUser(request)
    }

    final case class AdminListDevicesOp(
      request: AdminListDevicesRequest
    ) extends CognitoIdentityProviderOp[AdminListDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminListDevicesResponse] =
        visitor.adminListDevices(request)
    }

    final case class AdminListGroupsForUserOp(
      request: AdminListGroupsForUserRequest
    ) extends CognitoIdentityProviderOp[AdminListGroupsForUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminListGroupsForUserResponse] =
        visitor.adminListGroupsForUser(request)
    }

    final case class AdminListUserAuthEventsOp(
      request: AdminListUserAuthEventsRequest
    ) extends CognitoIdentityProviderOp[AdminListUserAuthEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminListUserAuthEventsResponse] =
        visitor.adminListUserAuthEvents(request)
    }

    final case class AdminRemoveUserFromGroupOp(
      request: AdminRemoveUserFromGroupRequest
    ) extends CognitoIdentityProviderOp[AdminRemoveUserFromGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminRemoveUserFromGroupResponse] =
        visitor.adminRemoveUserFromGroup(request)
    }

    final case class AdminResetUserPasswordOp(
      request: AdminResetUserPasswordRequest
    ) extends CognitoIdentityProviderOp[AdminResetUserPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminResetUserPasswordResponse] =
        visitor.adminResetUserPassword(request)
    }

    final case class AdminRespondToAuthChallengeOp(
      request: AdminRespondToAuthChallengeRequest
    ) extends CognitoIdentityProviderOp[AdminRespondToAuthChallengeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminRespondToAuthChallengeResponse] =
        visitor.adminRespondToAuthChallenge(request)
    }

    final case class AdminSetUserMFAPreferenceOp(
      request: AdminSetUserMfaPreferenceRequest
    ) extends CognitoIdentityProviderOp[AdminSetUserMfaPreferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminSetUserMfaPreferenceResponse] =
        visitor.adminSetUserMFAPreference(request)
    }

    final case class AdminSetUserPasswordOp(
      request: AdminSetUserPasswordRequest
    ) extends CognitoIdentityProviderOp[AdminSetUserPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminSetUserPasswordResponse] =
        visitor.adminSetUserPassword(request)
    }

    final case class AdminSetUserSettingsOp(
      request: AdminSetUserSettingsRequest
    ) extends CognitoIdentityProviderOp[AdminSetUserSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminSetUserSettingsResponse] =
        visitor.adminSetUserSettings(request)
    }

    final case class AdminUpdateAuthEventFeedbackOp(
      request: AdminUpdateAuthEventFeedbackRequest
    ) extends CognitoIdentityProviderOp[AdminUpdateAuthEventFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminUpdateAuthEventFeedbackResponse] =
        visitor.adminUpdateAuthEventFeedback(request)
    }

    final case class AdminUpdateDeviceStatusOp(
      request: AdminUpdateDeviceStatusRequest
    ) extends CognitoIdentityProviderOp[AdminUpdateDeviceStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminUpdateDeviceStatusResponse] =
        visitor.adminUpdateDeviceStatus(request)
    }

    final case class AdminUpdateUserAttributesOp(
      request: AdminUpdateUserAttributesRequest
    ) extends CognitoIdentityProviderOp[AdminUpdateUserAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminUpdateUserAttributesResponse] =
        visitor.adminUpdateUserAttributes(request)
    }

    final case class AdminUserGlobalSignOutOp(
      request: AdminUserGlobalSignOutRequest
    ) extends CognitoIdentityProviderOp[AdminUserGlobalSignOutResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdminUserGlobalSignOutResponse] =
        visitor.adminUserGlobalSignOut(request)
    }

    final case class AssociateSoftwareTokenOp(
      request: AssociateSoftwareTokenRequest
    ) extends CognitoIdentityProviderOp[AssociateSoftwareTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSoftwareTokenResponse] =
        visitor.associateSoftwareToken(request)
    }

    final case class ChangePasswordOp(
      request: ChangePasswordRequest
    ) extends CognitoIdentityProviderOp[ChangePasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangePasswordResponse] =
        visitor.changePassword(request)
    }

    final case class ConfirmDeviceOp(
      request: ConfirmDeviceRequest
    ) extends CognitoIdentityProviderOp[ConfirmDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmDeviceResponse] =
        visitor.confirmDevice(request)
    }

    final case class ConfirmForgotPasswordOp(
      request: ConfirmForgotPasswordRequest
    ) extends CognitoIdentityProviderOp[ConfirmForgotPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmForgotPasswordResponse] =
        visitor.confirmForgotPassword(request)
    }

    final case class ConfirmSignUpOp(
      request: ConfirmSignUpRequest
    ) extends CognitoIdentityProviderOp[ConfirmSignUpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfirmSignUpResponse] =
        visitor.confirmSignUp(request)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends CognitoIdentityProviderOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class CreateIdentityProviderOp(
      request: CreateIdentityProviderRequest
    ) extends CognitoIdentityProviderOp[CreateIdentityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIdentityProviderResponse] =
        visitor.createIdentityProvider(request)
    }

    final case class CreateResourceServerOp(
      request: CreateResourceServerRequest
    ) extends CognitoIdentityProviderOp[CreateResourceServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceServerResponse] =
        visitor.createResourceServer(request)
    }

    final case class CreateUserImportJobOp(
      request: CreateUserImportJobRequest
    ) extends CognitoIdentityProviderOp[CreateUserImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserImportJobResponse] =
        visitor.createUserImportJob(request)
    }

    final case class CreateUserPoolOp(
      request: CreateUserPoolRequest
    ) extends CognitoIdentityProviderOp[CreateUserPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserPoolResponse] =
        visitor.createUserPool(request)
    }

    final case class CreateUserPoolClientOp(
      request: CreateUserPoolClientRequest
    ) extends CognitoIdentityProviderOp[CreateUserPoolClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserPoolClientResponse] =
        visitor.createUserPoolClient(request)
    }

    final case class CreateUserPoolDomainOp(
      request: CreateUserPoolDomainRequest
    ) extends CognitoIdentityProviderOp[CreateUserPoolDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserPoolDomainResponse] =
        visitor.createUserPoolDomain(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends CognitoIdentityProviderOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class DeleteIdentityProviderOp(
      request: DeleteIdentityProviderRequest
    ) extends CognitoIdentityProviderOp[DeleteIdentityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIdentityProviderResponse] =
        visitor.deleteIdentityProvider(request)
    }

    final case class DeleteResourceServerOp(
      request: DeleteResourceServerRequest
    ) extends CognitoIdentityProviderOp[DeleteResourceServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceServerResponse] =
        visitor.deleteResourceServer(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends CognitoIdentityProviderOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DeleteUserAttributesOp(
      request: DeleteUserAttributesRequest
    ) extends CognitoIdentityProviderOp[DeleteUserAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserAttributesResponse] =
        visitor.deleteUserAttributes(request)
    }

    final case class DeleteUserPoolOp(
      request: DeleteUserPoolRequest
    ) extends CognitoIdentityProviderOp[DeleteUserPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserPoolResponse] =
        visitor.deleteUserPool(request)
    }

    final case class DeleteUserPoolClientOp(
      request: DeleteUserPoolClientRequest
    ) extends CognitoIdentityProviderOp[DeleteUserPoolClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserPoolClientResponse] =
        visitor.deleteUserPoolClient(request)
    }

    final case class DeleteUserPoolDomainOp(
      request: DeleteUserPoolDomainRequest
    ) extends CognitoIdentityProviderOp[DeleteUserPoolDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserPoolDomainResponse] =
        visitor.deleteUserPoolDomain(request)
    }

    final case class DescribeIdentityProviderOp(
      request: DescribeIdentityProviderRequest
    ) extends CognitoIdentityProviderOp[DescribeIdentityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIdentityProviderResponse] =
        visitor.describeIdentityProvider(request)
    }

    final case class DescribeResourceServerOp(
      request: DescribeResourceServerRequest
    ) extends CognitoIdentityProviderOp[DescribeResourceServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourceServerResponse] =
        visitor.describeResourceServer(request)
    }

    final case class DescribeRiskConfigurationOp(
      request: DescribeRiskConfigurationRequest
    ) extends CognitoIdentityProviderOp[DescribeRiskConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRiskConfigurationResponse] =
        visitor.describeRiskConfiguration(request)
    }

    final case class DescribeUserImportJobOp(
      request: DescribeUserImportJobRequest
    ) extends CognitoIdentityProviderOp[DescribeUserImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserImportJobResponse] =
        visitor.describeUserImportJob(request)
    }

    final case class DescribeUserPoolOp(
      request: DescribeUserPoolRequest
    ) extends CognitoIdentityProviderOp[DescribeUserPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserPoolResponse] =
        visitor.describeUserPool(request)
    }

    final case class DescribeUserPoolClientOp(
      request: DescribeUserPoolClientRequest
    ) extends CognitoIdentityProviderOp[DescribeUserPoolClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserPoolClientResponse] =
        visitor.describeUserPoolClient(request)
    }

    final case class DescribeUserPoolDomainOp(
      request: DescribeUserPoolDomainRequest
    ) extends CognitoIdentityProviderOp[DescribeUserPoolDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserPoolDomainResponse] =
        visitor.describeUserPoolDomain(request)
    }

    final case class ForgetDeviceOp(
      request: ForgetDeviceRequest
    ) extends CognitoIdentityProviderOp[ForgetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ForgetDeviceResponse] =
        visitor.forgetDevice(request)
    }

    final case class ForgotPasswordOp(
      request: ForgotPasswordRequest
    ) extends CognitoIdentityProviderOp[ForgotPasswordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ForgotPasswordResponse] =
        visitor.forgotPassword(request)
    }

    final case class GetCSVHeaderOp(
      request: GetCsvHeaderRequest
    ) extends CognitoIdentityProviderOp[GetCsvHeaderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCsvHeaderResponse] =
        visitor.getCSVHeader(request)
    }

    final case class GetDeviceOp(
      request: GetDeviceRequest
    ) extends CognitoIdentityProviderOp[GetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceResponse] =
        visitor.getDevice(request)
    }

    final case class GetGroupOp(
      request: GetGroupRequest
    ) extends CognitoIdentityProviderOp[GetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupResponse] =
        visitor.getGroup(request)
    }

    final case class GetIdentityProviderByIdentifierOp(
      request: GetIdentityProviderByIdentifierRequest
    ) extends CognitoIdentityProviderOp[GetIdentityProviderByIdentifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetIdentityProviderByIdentifierResponse] =
        visitor.getIdentityProviderByIdentifier(request)
    }

    final case class GetSigningCertificateOp(
      request: GetSigningCertificateRequest
    ) extends CognitoIdentityProviderOp[GetSigningCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSigningCertificateResponse] =
        visitor.getSigningCertificate(request)
    }

    final case class GetUICustomizationOp(
      request: GetUiCustomizationRequest
    ) extends CognitoIdentityProviderOp[GetUiCustomizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUiCustomizationResponse] =
        visitor.getUICustomization(request)
    }

    final case class GetUserOp(
      request: GetUserRequest
    ) extends CognitoIdentityProviderOp[GetUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserResponse] =
        visitor.getUser(request)
    }

    final case class GetUserAttributeVerificationCodeOp(
      request: GetUserAttributeVerificationCodeRequest
    ) extends CognitoIdentityProviderOp[GetUserAttributeVerificationCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserAttributeVerificationCodeResponse] =
        visitor.getUserAttributeVerificationCode(request)
    }

    final case class GetUserPoolMfaConfigOp(
      request: GetUserPoolMfaConfigRequest
    ) extends CognitoIdentityProviderOp[GetUserPoolMfaConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserPoolMfaConfigResponse] =
        visitor.getUserPoolMfaConfig(request)
    }

    final case class GlobalSignOutOp(
      request: GlobalSignOutRequest
    ) extends CognitoIdentityProviderOp[GlobalSignOutResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GlobalSignOutResponse] =
        visitor.globalSignOut(request)
    }

    final case class InitiateAuthOp(
      request: InitiateAuthRequest
    ) extends CognitoIdentityProviderOp[InitiateAuthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateAuthResponse] =
        visitor.initiateAuth(request)
    }

    final case class ListDevicesOp(
      request: ListDevicesRequest
    ) extends CognitoIdentityProviderOp[ListDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicesResponse] =
        visitor.listDevices(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends CognitoIdentityProviderOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class ListIdentityProvidersOp(
      request: ListIdentityProvidersRequest
    ) extends CognitoIdentityProviderOp[ListIdentityProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIdentityProvidersResponse] =
        visitor.listIdentityProviders(request)
    }

    final case class ListResourceServersOp(
      request: ListResourceServersRequest
    ) extends CognitoIdentityProviderOp[ListResourceServersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceServersResponse] =
        visitor.listResourceServers(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CognitoIdentityProviderOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListUserImportJobsOp(
      request: ListUserImportJobsRequest
    ) extends CognitoIdentityProviderOp[ListUserImportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserImportJobsResponse] =
        visitor.listUserImportJobs(request)
    }

    final case class ListUserPoolClientsOp(
      request: ListUserPoolClientsRequest
    ) extends CognitoIdentityProviderOp[ListUserPoolClientsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserPoolClientsResponse] =
        visitor.listUserPoolClients(request)
    }

    final case class ListUserPoolsOp(
      request: ListUserPoolsRequest
    ) extends CognitoIdentityProviderOp[ListUserPoolsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserPoolsResponse] =
        visitor.listUserPools(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends CognitoIdentityProviderOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class ListUsersInGroupOp(
      request: ListUsersInGroupRequest
    ) extends CognitoIdentityProviderOp[ListUsersInGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersInGroupResponse] =
        visitor.listUsersInGroup(request)
    }

    final case class ResendConfirmationCodeOp(
      request: ResendConfirmationCodeRequest
    ) extends CognitoIdentityProviderOp[ResendConfirmationCodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResendConfirmationCodeResponse] =
        visitor.resendConfirmationCode(request)
    }

    final case class RespondToAuthChallengeOp(
      request: RespondToAuthChallengeRequest
    ) extends CognitoIdentityProviderOp[RespondToAuthChallengeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RespondToAuthChallengeResponse] =
        visitor.respondToAuthChallenge(request)
    }

    final case class RevokeTokenOp(
      request: RevokeTokenRequest
    ) extends CognitoIdentityProviderOp[RevokeTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeTokenResponse] =
        visitor.revokeToken(request)
    }

    final case class SetRiskConfigurationOp(
      request: SetRiskConfigurationRequest
    ) extends CognitoIdentityProviderOp[SetRiskConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetRiskConfigurationResponse] =
        visitor.setRiskConfiguration(request)
    }

    final case class SetUICustomizationOp(
      request: SetUiCustomizationRequest
    ) extends CognitoIdentityProviderOp[SetUiCustomizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetUiCustomizationResponse] =
        visitor.setUICustomization(request)
    }

    final case class SetUserMFAPreferenceOp(
      request: SetUserMfaPreferenceRequest
    ) extends CognitoIdentityProviderOp[SetUserMfaPreferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetUserMfaPreferenceResponse] =
        visitor.setUserMFAPreference(request)
    }

    final case class SetUserPoolMfaConfigOp(
      request: SetUserPoolMfaConfigRequest
    ) extends CognitoIdentityProviderOp[SetUserPoolMfaConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetUserPoolMfaConfigResponse] =
        visitor.setUserPoolMfaConfig(request)
    }

    final case class SetUserSettingsOp(
      request: SetUserSettingsRequest
    ) extends CognitoIdentityProviderOp[SetUserSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetUserSettingsResponse] =
        visitor.setUserSettings(request)
    }

    final case class SignUpOp(
      request: SignUpRequest
    ) extends CognitoIdentityProviderOp[SignUpResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SignUpResponse] =
        visitor.signUp(request)
    }

    final case class StartUserImportJobOp(
      request: StartUserImportJobRequest
    ) extends CognitoIdentityProviderOp[StartUserImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartUserImportJobResponse] =
        visitor.startUserImportJob(request)
    }

    final case class StopUserImportJobOp(
      request: StopUserImportJobRequest
    ) extends CognitoIdentityProviderOp[StopUserImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopUserImportJobResponse] =
        visitor.stopUserImportJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CognitoIdentityProviderOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CognitoIdentityProviderOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAuthEventFeedbackOp(
      request: UpdateAuthEventFeedbackRequest
    ) extends CognitoIdentityProviderOp[UpdateAuthEventFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAuthEventFeedbackResponse] =
        visitor.updateAuthEventFeedback(request)
    }

    final case class UpdateDeviceStatusOp(
      request: UpdateDeviceStatusRequest
    ) extends CognitoIdentityProviderOp[UpdateDeviceStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceStatusResponse] =
        visitor.updateDeviceStatus(request)
    }

    final case class UpdateGroupOp(
      request: UpdateGroupRequest
    ) extends CognitoIdentityProviderOp[UpdateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupResponse] =
        visitor.updateGroup(request)
    }

    final case class UpdateIdentityProviderOp(
      request: UpdateIdentityProviderRequest
    ) extends CognitoIdentityProviderOp[UpdateIdentityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIdentityProviderResponse] =
        visitor.updateIdentityProvider(request)
    }

    final case class UpdateResourceServerOp(
      request: UpdateResourceServerRequest
    ) extends CognitoIdentityProviderOp[UpdateResourceServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceServerResponse] =
        visitor.updateResourceServer(request)
    }

    final case class UpdateUserAttributesOp(
      request: UpdateUserAttributesRequest
    ) extends CognitoIdentityProviderOp[UpdateUserAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserAttributesResponse] =
        visitor.updateUserAttributes(request)
    }

    final case class UpdateUserPoolOp(
      request: UpdateUserPoolRequest
    ) extends CognitoIdentityProviderOp[UpdateUserPoolResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserPoolResponse] =
        visitor.updateUserPool(request)
    }

    final case class UpdateUserPoolClientOp(
      request: UpdateUserPoolClientRequest
    ) extends CognitoIdentityProviderOp[UpdateUserPoolClientResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserPoolClientResponse] =
        visitor.updateUserPoolClient(request)
    }

    final case class UpdateUserPoolDomainOp(
      request: UpdateUserPoolDomainRequest
    ) extends CognitoIdentityProviderOp[UpdateUserPoolDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserPoolDomainResponse] =
        visitor.updateUserPoolDomain(request)
    }

    final case class VerifySoftwareTokenOp(
      request: VerifySoftwareTokenRequest
    ) extends CognitoIdentityProviderOp[VerifySoftwareTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifySoftwareTokenResponse] =
        visitor.verifySoftwareToken(request)
    }

    final case class VerifyUserAttributeOp(
      request: VerifyUserAttributeRequest
    ) extends CognitoIdentityProviderOp[VerifyUserAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[VerifyUserAttributeResponse] =
        visitor.verifyUserAttribute(request)
    }
  }

  import CognitoIdentityProviderOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CognitoIdentityProviderOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addCustomAttributes(
    request: AddCustomAttributesRequest
  ): CognitoIdentityProviderIO[AddCustomAttributesResponse] =
    FF.liftF(AddCustomAttributesOp(request))

  def adminAddUserToGroup(
    request: AdminAddUserToGroupRequest
  ): CognitoIdentityProviderIO[AdminAddUserToGroupResponse] =
    FF.liftF(AdminAddUserToGroupOp(request))

  def adminConfirmSignUp(
    request: AdminConfirmSignUpRequest
  ): CognitoIdentityProviderIO[AdminConfirmSignUpResponse] =
    FF.liftF(AdminConfirmSignUpOp(request))

  def adminCreateUser(
    request: AdminCreateUserRequest
  ): CognitoIdentityProviderIO[AdminCreateUserResponse] =
    FF.liftF(AdminCreateUserOp(request))

  def adminDeleteUser(
    request: AdminDeleteUserRequest
  ): CognitoIdentityProviderIO[AdminDeleteUserResponse] =
    FF.liftF(AdminDeleteUserOp(request))

  def adminDeleteUserAttributes(
    request: AdminDeleteUserAttributesRequest
  ): CognitoIdentityProviderIO[AdminDeleteUserAttributesResponse] =
    FF.liftF(AdminDeleteUserAttributesOp(request))

  def adminDisableProviderForUser(
    request: AdminDisableProviderForUserRequest
  ): CognitoIdentityProviderIO[AdminDisableProviderForUserResponse] =
    FF.liftF(AdminDisableProviderForUserOp(request))

  def adminDisableUser(
    request: AdminDisableUserRequest
  ): CognitoIdentityProviderIO[AdminDisableUserResponse] =
    FF.liftF(AdminDisableUserOp(request))

  def adminEnableUser(
    request: AdminEnableUserRequest
  ): CognitoIdentityProviderIO[AdminEnableUserResponse] =
    FF.liftF(AdminEnableUserOp(request))

  def adminForgetDevice(
    request: AdminForgetDeviceRequest
  ): CognitoIdentityProviderIO[AdminForgetDeviceResponse] =
    FF.liftF(AdminForgetDeviceOp(request))

  def adminGetDevice(
    request: AdminGetDeviceRequest
  ): CognitoIdentityProviderIO[AdminGetDeviceResponse] =
    FF.liftF(AdminGetDeviceOp(request))

  def adminGetUser(
    request: AdminGetUserRequest
  ): CognitoIdentityProviderIO[AdminGetUserResponse] =
    FF.liftF(AdminGetUserOp(request))

  def adminInitiateAuth(
    request: AdminInitiateAuthRequest
  ): CognitoIdentityProviderIO[AdminInitiateAuthResponse] =
    FF.liftF(AdminInitiateAuthOp(request))

  def adminLinkProviderForUser(
    request: AdminLinkProviderForUserRequest
  ): CognitoIdentityProviderIO[AdminLinkProviderForUserResponse] =
    FF.liftF(AdminLinkProviderForUserOp(request))

  def adminListDevices(
    request: AdminListDevicesRequest
  ): CognitoIdentityProviderIO[AdminListDevicesResponse] =
    FF.liftF(AdminListDevicesOp(request))

  def adminListGroupsForUser(
    request: AdminListGroupsForUserRequest
  ): CognitoIdentityProviderIO[AdminListGroupsForUserResponse] =
    FF.liftF(AdminListGroupsForUserOp(request))

  def adminListUserAuthEvents(
    request: AdminListUserAuthEventsRequest
  ): CognitoIdentityProviderIO[AdminListUserAuthEventsResponse] =
    FF.liftF(AdminListUserAuthEventsOp(request))

  def adminRemoveUserFromGroup(
    request: AdminRemoveUserFromGroupRequest
  ): CognitoIdentityProviderIO[AdminRemoveUserFromGroupResponse] =
    FF.liftF(AdminRemoveUserFromGroupOp(request))

  def adminResetUserPassword(
    request: AdminResetUserPasswordRequest
  ): CognitoIdentityProviderIO[AdminResetUserPasswordResponse] =
    FF.liftF(AdminResetUserPasswordOp(request))

  def adminRespondToAuthChallenge(
    request: AdminRespondToAuthChallengeRequest
  ): CognitoIdentityProviderIO[AdminRespondToAuthChallengeResponse] =
    FF.liftF(AdminRespondToAuthChallengeOp(request))

  def adminSetUserMFAPreference(
    request: AdminSetUserMfaPreferenceRequest
  ): CognitoIdentityProviderIO[AdminSetUserMfaPreferenceResponse] =
    FF.liftF(AdminSetUserMFAPreferenceOp(request))

  def adminSetUserPassword(
    request: AdminSetUserPasswordRequest
  ): CognitoIdentityProviderIO[AdminSetUserPasswordResponse] =
    FF.liftF(AdminSetUserPasswordOp(request))

  def adminSetUserSettings(
    request: AdminSetUserSettingsRequest
  ): CognitoIdentityProviderIO[AdminSetUserSettingsResponse] =
    FF.liftF(AdminSetUserSettingsOp(request))

  def adminUpdateAuthEventFeedback(
    request: AdminUpdateAuthEventFeedbackRequest
  ): CognitoIdentityProviderIO[AdminUpdateAuthEventFeedbackResponse] =
    FF.liftF(AdminUpdateAuthEventFeedbackOp(request))

  def adminUpdateDeviceStatus(
    request: AdminUpdateDeviceStatusRequest
  ): CognitoIdentityProviderIO[AdminUpdateDeviceStatusResponse] =
    FF.liftF(AdminUpdateDeviceStatusOp(request))

  def adminUpdateUserAttributes(
    request: AdminUpdateUserAttributesRequest
  ): CognitoIdentityProviderIO[AdminUpdateUserAttributesResponse] =
    FF.liftF(AdminUpdateUserAttributesOp(request))

  def adminUserGlobalSignOut(
    request: AdminUserGlobalSignOutRequest
  ): CognitoIdentityProviderIO[AdminUserGlobalSignOutResponse] =
    FF.liftF(AdminUserGlobalSignOutOp(request))

  def associateSoftwareToken(
    request: AssociateSoftwareTokenRequest
  ): CognitoIdentityProviderIO[AssociateSoftwareTokenResponse] =
    FF.liftF(AssociateSoftwareTokenOp(request))

  def changePassword(
    request: ChangePasswordRequest
  ): CognitoIdentityProviderIO[ChangePasswordResponse] =
    FF.liftF(ChangePasswordOp(request))

  def confirmDevice(
    request: ConfirmDeviceRequest
  ): CognitoIdentityProviderIO[ConfirmDeviceResponse] =
    FF.liftF(ConfirmDeviceOp(request))

  def confirmForgotPassword(
    request: ConfirmForgotPasswordRequest
  ): CognitoIdentityProviderIO[ConfirmForgotPasswordResponse] =
    FF.liftF(ConfirmForgotPasswordOp(request))

  def confirmSignUp(
    request: ConfirmSignUpRequest
  ): CognitoIdentityProviderIO[ConfirmSignUpResponse] =
    FF.liftF(ConfirmSignUpOp(request))

  def createGroup(
    request: CreateGroupRequest
  ): CognitoIdentityProviderIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def createIdentityProvider(
    request: CreateIdentityProviderRequest
  ): CognitoIdentityProviderIO[CreateIdentityProviderResponse] =
    FF.liftF(CreateIdentityProviderOp(request))

  def createResourceServer(
    request: CreateResourceServerRequest
  ): CognitoIdentityProviderIO[CreateResourceServerResponse] =
    FF.liftF(CreateResourceServerOp(request))

  def createUserImportJob(
    request: CreateUserImportJobRequest
  ): CognitoIdentityProviderIO[CreateUserImportJobResponse] =
    FF.liftF(CreateUserImportJobOp(request))

  def createUserPool(
    request: CreateUserPoolRequest
  ): CognitoIdentityProviderIO[CreateUserPoolResponse] =
    FF.liftF(CreateUserPoolOp(request))

  def createUserPoolClient(
    request: CreateUserPoolClientRequest
  ): CognitoIdentityProviderIO[CreateUserPoolClientResponse] =
    FF.liftF(CreateUserPoolClientOp(request))

  def createUserPoolDomain(
    request: CreateUserPoolDomainRequest
  ): CognitoIdentityProviderIO[CreateUserPoolDomainResponse] =
    FF.liftF(CreateUserPoolDomainOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): CognitoIdentityProviderIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def deleteIdentityProvider(
    request: DeleteIdentityProviderRequest
  ): CognitoIdentityProviderIO[DeleteIdentityProviderResponse] =
    FF.liftF(DeleteIdentityProviderOp(request))

  def deleteResourceServer(
    request: DeleteResourceServerRequest
  ): CognitoIdentityProviderIO[DeleteResourceServerResponse] =
    FF.liftF(DeleteResourceServerOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): CognitoIdentityProviderIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def deleteUserAttributes(
    request: DeleteUserAttributesRequest
  ): CognitoIdentityProviderIO[DeleteUserAttributesResponse] =
    FF.liftF(DeleteUserAttributesOp(request))

  def deleteUserPool(
    request: DeleteUserPoolRequest
  ): CognitoIdentityProviderIO[DeleteUserPoolResponse] =
    FF.liftF(DeleteUserPoolOp(request))

  def deleteUserPoolClient(
    request: DeleteUserPoolClientRequest
  ): CognitoIdentityProviderIO[DeleteUserPoolClientResponse] =
    FF.liftF(DeleteUserPoolClientOp(request))

  def deleteUserPoolDomain(
    request: DeleteUserPoolDomainRequest
  ): CognitoIdentityProviderIO[DeleteUserPoolDomainResponse] =
    FF.liftF(DeleteUserPoolDomainOp(request))

  def describeIdentityProvider(
    request: DescribeIdentityProviderRequest
  ): CognitoIdentityProviderIO[DescribeIdentityProviderResponse] =
    FF.liftF(DescribeIdentityProviderOp(request))

  def describeResourceServer(
    request: DescribeResourceServerRequest
  ): CognitoIdentityProviderIO[DescribeResourceServerResponse] =
    FF.liftF(DescribeResourceServerOp(request))

  def describeRiskConfiguration(
    request: DescribeRiskConfigurationRequest
  ): CognitoIdentityProviderIO[DescribeRiskConfigurationResponse] =
    FF.liftF(DescribeRiskConfigurationOp(request))

  def describeUserImportJob(
    request: DescribeUserImportJobRequest
  ): CognitoIdentityProviderIO[DescribeUserImportJobResponse] =
    FF.liftF(DescribeUserImportJobOp(request))

  def describeUserPool(
    request: DescribeUserPoolRequest
  ): CognitoIdentityProviderIO[DescribeUserPoolResponse] =
    FF.liftF(DescribeUserPoolOp(request))

  def describeUserPoolClient(
    request: DescribeUserPoolClientRequest
  ): CognitoIdentityProviderIO[DescribeUserPoolClientResponse] =
    FF.liftF(DescribeUserPoolClientOp(request))

  def describeUserPoolDomain(
    request: DescribeUserPoolDomainRequest
  ): CognitoIdentityProviderIO[DescribeUserPoolDomainResponse] =
    FF.liftF(DescribeUserPoolDomainOp(request))

  def forgetDevice(
    request: ForgetDeviceRequest
  ): CognitoIdentityProviderIO[ForgetDeviceResponse] =
    FF.liftF(ForgetDeviceOp(request))

  def forgotPassword(
    request: ForgotPasswordRequest
  ): CognitoIdentityProviderIO[ForgotPasswordResponse] =
    FF.liftF(ForgotPasswordOp(request))

  def getCSVHeader(
    request: GetCsvHeaderRequest
  ): CognitoIdentityProviderIO[GetCsvHeaderResponse] =
    FF.liftF(GetCSVHeaderOp(request))

  def getDevice(
    request: GetDeviceRequest
  ): CognitoIdentityProviderIO[GetDeviceResponse] =
    FF.liftF(GetDeviceOp(request))

  def getGroup(
    request: GetGroupRequest
  ): CognitoIdentityProviderIO[GetGroupResponse] =
    FF.liftF(GetGroupOp(request))

  def getIdentityProviderByIdentifier(
    request: GetIdentityProviderByIdentifierRequest
  ): CognitoIdentityProviderIO[GetIdentityProviderByIdentifierResponse] =
    FF.liftF(GetIdentityProviderByIdentifierOp(request))

  def getSigningCertificate(
    request: GetSigningCertificateRequest
  ): CognitoIdentityProviderIO[GetSigningCertificateResponse] =
    FF.liftF(GetSigningCertificateOp(request))

  def getUICustomization(
    request: GetUiCustomizationRequest
  ): CognitoIdentityProviderIO[GetUiCustomizationResponse] =
    FF.liftF(GetUICustomizationOp(request))

  def getUser(
    request: GetUserRequest
  ): CognitoIdentityProviderIO[GetUserResponse] =
    FF.liftF(GetUserOp(request))

  def getUserAttributeVerificationCode(
    request: GetUserAttributeVerificationCodeRequest
  ): CognitoIdentityProviderIO[GetUserAttributeVerificationCodeResponse] =
    FF.liftF(GetUserAttributeVerificationCodeOp(request))

  def getUserPoolMfaConfig(
    request: GetUserPoolMfaConfigRequest
  ): CognitoIdentityProviderIO[GetUserPoolMfaConfigResponse] =
    FF.liftF(GetUserPoolMfaConfigOp(request))

  def globalSignOut(
    request: GlobalSignOutRequest
  ): CognitoIdentityProviderIO[GlobalSignOutResponse] =
    FF.liftF(GlobalSignOutOp(request))

  def initiateAuth(
    request: InitiateAuthRequest
  ): CognitoIdentityProviderIO[InitiateAuthResponse] =
    FF.liftF(InitiateAuthOp(request))

  def listDevices(
    request: ListDevicesRequest
  ): CognitoIdentityProviderIO[ListDevicesResponse] =
    FF.liftF(ListDevicesOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): CognitoIdentityProviderIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def listIdentityProviders(
    request: ListIdentityProvidersRequest
  ): CognitoIdentityProviderIO[ListIdentityProvidersResponse] =
    FF.liftF(ListIdentityProvidersOp(request))

  def listResourceServers(
    request: ListResourceServersRequest
  ): CognitoIdentityProviderIO[ListResourceServersResponse] =
    FF.liftF(ListResourceServersOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CognitoIdentityProviderIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listUserImportJobs(
    request: ListUserImportJobsRequest
  ): CognitoIdentityProviderIO[ListUserImportJobsResponse] =
    FF.liftF(ListUserImportJobsOp(request))

  def listUserPoolClients(
    request: ListUserPoolClientsRequest
  ): CognitoIdentityProviderIO[ListUserPoolClientsResponse] =
    FF.liftF(ListUserPoolClientsOp(request))

  def listUserPools(
    request: ListUserPoolsRequest
  ): CognitoIdentityProviderIO[ListUserPoolsResponse] =
    FF.liftF(ListUserPoolsOp(request))

  def listUsers(
    request: ListUsersRequest
  ): CognitoIdentityProviderIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def listUsersInGroup(
    request: ListUsersInGroupRequest
  ): CognitoIdentityProviderIO[ListUsersInGroupResponse] =
    FF.liftF(ListUsersInGroupOp(request))

  def resendConfirmationCode(
    request: ResendConfirmationCodeRequest
  ): CognitoIdentityProviderIO[ResendConfirmationCodeResponse] =
    FF.liftF(ResendConfirmationCodeOp(request))

  def respondToAuthChallenge(
    request: RespondToAuthChallengeRequest
  ): CognitoIdentityProviderIO[RespondToAuthChallengeResponse] =
    FF.liftF(RespondToAuthChallengeOp(request))

  def revokeToken(
    request: RevokeTokenRequest
  ): CognitoIdentityProviderIO[RevokeTokenResponse] =
    FF.liftF(RevokeTokenOp(request))

  def setRiskConfiguration(
    request: SetRiskConfigurationRequest
  ): CognitoIdentityProviderIO[SetRiskConfigurationResponse] =
    FF.liftF(SetRiskConfigurationOp(request))

  def setUICustomization(
    request: SetUiCustomizationRequest
  ): CognitoIdentityProviderIO[SetUiCustomizationResponse] =
    FF.liftF(SetUICustomizationOp(request))

  def setUserMFAPreference(
    request: SetUserMfaPreferenceRequest
  ): CognitoIdentityProviderIO[SetUserMfaPreferenceResponse] =
    FF.liftF(SetUserMFAPreferenceOp(request))

  def setUserPoolMfaConfig(
    request: SetUserPoolMfaConfigRequest
  ): CognitoIdentityProviderIO[SetUserPoolMfaConfigResponse] =
    FF.liftF(SetUserPoolMfaConfigOp(request))

  def setUserSettings(
    request: SetUserSettingsRequest
  ): CognitoIdentityProviderIO[SetUserSettingsResponse] =
    FF.liftF(SetUserSettingsOp(request))

  def signUp(
    request: SignUpRequest
  ): CognitoIdentityProviderIO[SignUpResponse] =
    FF.liftF(SignUpOp(request))

  def startUserImportJob(
    request: StartUserImportJobRequest
  ): CognitoIdentityProviderIO[StartUserImportJobResponse] =
    FF.liftF(StartUserImportJobOp(request))

  def stopUserImportJob(
    request: StopUserImportJobRequest
  ): CognitoIdentityProviderIO[StopUserImportJobResponse] =
    FF.liftF(StopUserImportJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CognitoIdentityProviderIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CognitoIdentityProviderIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAuthEventFeedback(
    request: UpdateAuthEventFeedbackRequest
  ): CognitoIdentityProviderIO[UpdateAuthEventFeedbackResponse] =
    FF.liftF(UpdateAuthEventFeedbackOp(request))

  def updateDeviceStatus(
    request: UpdateDeviceStatusRequest
  ): CognitoIdentityProviderIO[UpdateDeviceStatusResponse] =
    FF.liftF(UpdateDeviceStatusOp(request))

  def updateGroup(
    request: UpdateGroupRequest
  ): CognitoIdentityProviderIO[UpdateGroupResponse] =
    FF.liftF(UpdateGroupOp(request))

  def updateIdentityProvider(
    request: UpdateIdentityProviderRequest
  ): CognitoIdentityProviderIO[UpdateIdentityProviderResponse] =
    FF.liftF(UpdateIdentityProviderOp(request))

  def updateResourceServer(
    request: UpdateResourceServerRequest
  ): CognitoIdentityProviderIO[UpdateResourceServerResponse] =
    FF.liftF(UpdateResourceServerOp(request))

  def updateUserAttributes(
    request: UpdateUserAttributesRequest
  ): CognitoIdentityProviderIO[UpdateUserAttributesResponse] =
    FF.liftF(UpdateUserAttributesOp(request))

  def updateUserPool(
    request: UpdateUserPoolRequest
  ): CognitoIdentityProviderIO[UpdateUserPoolResponse] =
    FF.liftF(UpdateUserPoolOp(request))

  def updateUserPoolClient(
    request: UpdateUserPoolClientRequest
  ): CognitoIdentityProviderIO[UpdateUserPoolClientResponse] =
    FF.liftF(UpdateUserPoolClientOp(request))

  def updateUserPoolDomain(
    request: UpdateUserPoolDomainRequest
  ): CognitoIdentityProviderIO[UpdateUserPoolDomainResponse] =
    FF.liftF(UpdateUserPoolDomainOp(request))

  def verifySoftwareToken(
    request: VerifySoftwareTokenRequest
  ): CognitoIdentityProviderIO[VerifySoftwareTokenResponse] =
    FF.liftF(VerifySoftwareTokenOp(request))

  def verifyUserAttribute(
    request: VerifyUserAttributeRequest
  ): CognitoIdentityProviderIO[VerifyUserAttributeResponse] =
    FF.liftF(VerifyUserAttributeOp(request))
}
