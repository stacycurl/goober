package goober.hi

import goober.free.cognitoidentityprovider.CognitoIdentityProviderIO
import software.amazon.awssdk.services.cognitoidentityprovider.model._


object cognitoidentityprovider {
  import goober.free.{cognitoidentityprovider ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountRecoverySettingType(
      recoveryMechanisms: Option[List[RecoveryOptionType]] = None
    ): AccountRecoverySettingType =
      AccountRecoverySettingType
        .builder
        .ifSome(recoveryMechanisms)(_.recoveryMechanisms(_))
        .build

    def accountTakeoverActionType(
      notify: Option[Boolean] = None,
      eventAction: Option[String] = None
    ): AccountTakeoverActionType =
      AccountTakeoverActionType
        .builder
        .ifSome(notify)(_.notify(_))
        .ifSome(eventAction)(_.eventAction(_))
        .build

    def accountTakeoverActionsType(
      lowAction: Option[AccountTakeoverActionType] = None,
      mediumAction: Option[AccountTakeoverActionType] = None,
      highAction: Option[AccountTakeoverActionType] = None
    ): AccountTakeoverActionsType =
      AccountTakeoverActionsType
        .builder
        .ifSome(lowAction)(_.lowAction(_))
        .ifSome(mediumAction)(_.mediumAction(_))
        .ifSome(highAction)(_.highAction(_))
        .build

    def accountTakeoverRiskConfigurationType(
      notifyConfiguration: Option[NotifyConfigurationType] = None,
      actions: Option[AccountTakeoverActionsType] = None
    ): AccountTakeoverRiskConfigurationType =
      AccountTakeoverRiskConfigurationType
        .builder
        .ifSome(notifyConfiguration)(_.notifyConfiguration(_))
        .ifSome(actions)(_.actions(_))
        .build

    def addCustomAttributesRequest(
      userPoolId: Option[String] = None,
      customAttributes: Option[List[SchemaAttributeType]] = None
    ): AddCustomAttributesRequest =
      AddCustomAttributesRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(customAttributes)(_.customAttributes(_))
        .build

    def addCustomAttributesResponse(

    ): AddCustomAttributesResponse =
      AddCustomAttributesResponse
        .builder

        .build

    def adminAddUserToGroupRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      groupName: Option[String] = None
    ): AdminAddUserToGroupRequest =
      AdminAddUserToGroupRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def adminConfirmSignUpRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): AdminConfirmSignUpRequest =
      AdminConfirmSignUpRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def adminConfirmSignUpResponse(

    ): AdminConfirmSignUpResponse =
      AdminConfirmSignUpResponse
        .builder

        .build

    def adminCreateUserConfigType(
      allowAdminCreateUserOnly: Option[Boolean] = None,
      unusedAccountValidityDays: Option[Int] = None,
      inviteMessageTemplate: Option[MessageTemplateType] = None
    ): AdminCreateUserConfigType =
      AdminCreateUserConfigType
        .builder
        .ifSome(allowAdminCreateUserOnly)(_.allowAdminCreateUserOnly(_))
        .ifSome(unusedAccountValidityDays)(_.unusedAccountValidityDays(_))
        .ifSome(inviteMessageTemplate)(_.inviteMessageTemplate(_))
        .build

    def adminCreateUserRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      userAttributes: Option[List[AttributeType]] = None,
      validationData: Option[List[AttributeType]] = None,
      temporaryPassword: Option[String] = None,
      forceAliasCreation: Option[Boolean] = None,
      messageAction: Option[String] = None,
      desiredDeliveryMediums: Option[List[DeliveryMediumType]] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): AdminCreateUserRequest =
      AdminCreateUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(validationData)(_.validationData(_))
        .ifSome(temporaryPassword)(_.temporaryPassword(_))
        .ifSome(forceAliasCreation)(_.forceAliasCreation(_))
        .ifSome(messageAction)(_.messageAction(_))
        .ifSome(desiredDeliveryMediums)(_.desiredDeliveryMediums(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def adminCreateUserResponse(
      user: Option[UserType] = None
    ): AdminCreateUserResponse =
      AdminCreateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def adminDeleteUserAttributesRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      userAttributeNames: Option[List[AttributeNameType]] = None
    ): AdminDeleteUserAttributesRequest =
      AdminDeleteUserAttributesRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(userAttributeNames)(_.userAttributeNames(_))
        .build

    def adminDeleteUserAttributesResponse(

    ): AdminDeleteUserAttributesResponse =
      AdminDeleteUserAttributesResponse
        .builder

        .build

    def adminDeleteUserRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None
    ): AdminDeleteUserRequest =
      AdminDeleteUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .build

    def adminDisableProviderForUserRequest(
      userPoolId: Option[String] = None,
      user: Option[ProviderUserIdentifierType] = None
    ): AdminDisableProviderForUserRequest =
      AdminDisableProviderForUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(user)(_.user(_))
        .build

    def adminDisableProviderForUserResponse(

    ): AdminDisableProviderForUserResponse =
      AdminDisableProviderForUserResponse
        .builder

        .build

    def adminDisableUserRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None
    ): AdminDisableUserRequest =
      AdminDisableUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .build

    def adminDisableUserResponse(

    ): AdminDisableUserResponse =
      AdminDisableUserResponse
        .builder

        .build

    def adminEnableUserRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None
    ): AdminEnableUserRequest =
      AdminEnableUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .build

    def adminEnableUserResponse(

    ): AdminEnableUserResponse =
      AdminEnableUserResponse
        .builder

        .build

    def adminForgetDeviceRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      deviceKey: Option[String] = None
    ): AdminForgetDeviceRequest =
      AdminForgetDeviceRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(deviceKey)(_.deviceKey(_))
        .build

    def adminGetDeviceRequest(
      deviceKey: Option[String] = None,
      userPoolId: Option[String] = None,
      username: Option[String] = None
    ): AdminGetDeviceRequest =
      AdminGetDeviceRequest
        .builder
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .build

    def adminGetDeviceResponse(
      device: Option[DeviceType] = None
    ): AdminGetDeviceResponse =
      AdminGetDeviceResponse
        .builder
        .ifSome(device)(_.device(_))
        .build

    def adminGetUserRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None
    ): AdminGetUserRequest =
      AdminGetUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .build

    def adminGetUserResponse(
      username: Option[String] = None,
      userAttributes: Option[List[AttributeType]] = None,
      userCreateDate: Option[DateType] = None,
      userLastModifiedDate: Option[DateType] = None,
      enabled: Option[Boolean] = None,
      userStatus: Option[String] = None,
      mFAOptions: Option[List[MFAOptionType]] = None,
      preferredMfaSetting: Option[String] = None,
      userMFASettingList: Option[List[StringType]] = None
    ): AdminGetUserResponse =
      AdminGetUserResponse
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(userCreateDate)(_.userCreateDate(_))
        .ifSome(userLastModifiedDate)(_.userLastModifiedDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(userStatus)(_.userStatus(_))
        .ifSome(mFAOptions)(_.mFAOptions(_))
        .ifSome(preferredMfaSetting)(_.preferredMfaSetting(_))
        .ifSome(userMFASettingList)(_.userMFASettingList(_))
        .build

    def adminInitiateAuthRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      authFlow: Option[String] = None,
      authParameters: Option[AuthParametersType] = None,
      clientMetadata: Option[ClientMetadataType] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      contextData: Option[ContextDataType] = None
    ): AdminInitiateAuthRequest =
      AdminInitiateAuthRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(authFlow)(_.authFlow(_))
        .ifSome(authParameters)(_.authParameters(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(contextData)(_.contextData(_))
        .build

    def adminInitiateAuthResponse(
      challengeName: Option[String] = None,
      session: Option[String] = None,
      challengeParameters: Option[ChallengeParametersType] = None,
      authenticationResult: Option[AuthenticationResultType] = None
    ): AdminInitiateAuthResponse =
      AdminInitiateAuthResponse
        .builder
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(session)(_.session(_))
        .ifSome(challengeParameters)(_.challengeParameters(_))
        .ifSome(authenticationResult)(_.authenticationResult(_))
        .build

    def adminLinkProviderForUserRequest(
      userPoolId: Option[String] = None,
      destinationUser: Option[ProviderUserIdentifierType] = None,
      sourceUser: Option[ProviderUserIdentifierType] = None
    ): AdminLinkProviderForUserRequest =
      AdminLinkProviderForUserRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(destinationUser)(_.destinationUser(_))
        .ifSome(sourceUser)(_.sourceUser(_))
        .build

    def adminLinkProviderForUserResponse(

    ): AdminLinkProviderForUserResponse =
      AdminLinkProviderForUserResponse
        .builder

        .build

    def adminListDevicesRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      limit: Option[Int] = None,
      paginationToken: Option[String] = None
    ): AdminListDevicesRequest =
      AdminListDevicesRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def adminListDevicesResponse(
      devices: Option[List[DeviceType]] = None,
      paginationToken: Option[String] = None
    ): AdminListDevicesResponse =
      AdminListDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def adminListGroupsForUserRequest(
      username: Option[String] = None,
      userPoolId: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): AdminListGroupsForUserRequest =
      AdminListGroupsForUserRequest
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def adminListGroupsForUserResponse(
      groups: Option[List[GroupType]] = None,
      nextToken: Option[String] = None
    ): AdminListGroupsForUserResponse =
      AdminListGroupsForUserResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def adminListUserAuthEventsRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): AdminListUserAuthEventsRequest =
      AdminListUserAuthEventsRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def adminListUserAuthEventsResponse(
      authEvents: Option[List[AuthEventType]] = None,
      nextToken: Option[String] = None
    ): AdminListUserAuthEventsResponse =
      AdminListUserAuthEventsResponse
        .builder
        .ifSome(authEvents)(_.authEvents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def adminRemoveUserFromGroupRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      groupName: Option[String] = None
    ): AdminRemoveUserFromGroupRequest =
      AdminRemoveUserFromGroupRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def adminResetUserPasswordRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): AdminResetUserPasswordRequest =
      AdminResetUserPasswordRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def adminResetUserPasswordResponse(

    ): AdminResetUserPasswordResponse =
      AdminResetUserPasswordResponse
        .builder

        .build

    def adminRespondToAuthChallengeRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      challengeName: Option[String] = None,
      challengeResponses: Option[ChallengeResponsesType] = None,
      session: Option[String] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      contextData: Option[ContextDataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): AdminRespondToAuthChallengeRequest =
      AdminRespondToAuthChallengeRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(challengeResponses)(_.challengeResponses(_))
        .ifSome(session)(_.session(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(contextData)(_.contextData(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def adminRespondToAuthChallengeResponse(
      challengeName: Option[String] = None,
      session: Option[String] = None,
      challengeParameters: Option[ChallengeParametersType] = None,
      authenticationResult: Option[AuthenticationResultType] = None
    ): AdminRespondToAuthChallengeResponse =
      AdminRespondToAuthChallengeResponse
        .builder
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(session)(_.session(_))
        .ifSome(challengeParameters)(_.challengeParameters(_))
        .ifSome(authenticationResult)(_.authenticationResult(_))
        .build

    def adminSetUserMFAPreferenceRequest(
      sMSMfaSettings: Option[SMSMfaSettingsType] = None,
      softwareTokenMfaSettings: Option[SoftwareTokenMfaSettingsType] = None,
      username: Option[String] = None,
      userPoolId: Option[String] = None
    ): AdminSetUserMFAPreferenceRequest =
      AdminSetUserMFAPreferenceRequest
        .builder
        .ifSome(sMSMfaSettings)(_.sMSMfaSettings(_))
        .ifSome(softwareTokenMfaSettings)(_.softwareTokenMfaSettings(_))
        .ifSome(username)(_.username(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def adminSetUserMFAPreferenceResponse(

    ): AdminSetUserMFAPreferenceResponse =
      AdminSetUserMFAPreferenceResponse
        .builder

        .build

    def adminSetUserPasswordRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      permanent: Option[Boolean] = None
    ): AdminSetUserPasswordRequest =
      AdminSetUserPasswordRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(permanent)(_.permanent(_))
        .build

    def adminSetUserPasswordResponse(

    ): AdminSetUserPasswordResponse =
      AdminSetUserPasswordResponse
        .builder

        .build

    def adminSetUserSettingsRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      mFAOptions: Option[List[MFAOptionType]] = None
    ): AdminSetUserSettingsRequest =
      AdminSetUserSettingsRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(mFAOptions)(_.mFAOptions(_))
        .build

    def adminSetUserSettingsResponse(

    ): AdminSetUserSettingsResponse =
      AdminSetUserSettingsResponse
        .builder

        .build

    def adminUpdateAuthEventFeedbackRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      eventId: Option[String] = None,
      feedbackValue: Option[String] = None
    ): AdminUpdateAuthEventFeedbackRequest =
      AdminUpdateAuthEventFeedbackRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(feedbackValue)(_.feedbackValue(_))
        .build

    def adminUpdateAuthEventFeedbackResponse(

    ): AdminUpdateAuthEventFeedbackResponse =
      AdminUpdateAuthEventFeedbackResponse
        .builder

        .build

    def adminUpdateDeviceStatusRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      deviceKey: Option[String] = None,
      deviceRememberedStatus: Option[String] = None
    ): AdminUpdateDeviceStatusRequest =
      AdminUpdateDeviceStatusRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(deviceRememberedStatus)(_.deviceRememberedStatus(_))
        .build

    def adminUpdateDeviceStatusResponse(

    ): AdminUpdateDeviceStatusResponse =
      AdminUpdateDeviceStatusResponse
        .builder

        .build

    def adminUpdateUserAttributesRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      userAttributes: Option[List[AttributeType]] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): AdminUpdateUserAttributesRequest =
      AdminUpdateUserAttributesRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def adminUpdateUserAttributesResponse(

    ): AdminUpdateUserAttributesResponse =
      AdminUpdateUserAttributesResponse
        .builder

        .build

    def adminUserGlobalSignOutRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None
    ): AdminUserGlobalSignOutRequest =
      AdminUserGlobalSignOutRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .build

    def adminUserGlobalSignOutResponse(

    ): AdminUserGlobalSignOutResponse =
      AdminUserGlobalSignOutResponse
        .builder

        .build

    def aliasExistsException(
      message: Option[String] = None
    ): AliasExistsException =
      AliasExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def analyticsConfigurationType(
      applicationId: Option[String] = None,
      applicationArn: Option[String] = None,
      roleArn: Option[String] = None,
      externalId: Option[String] = None,
      userDataShared: Option[Boolean] = None
    ): AnalyticsConfigurationType =
      AnalyticsConfigurationType
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(userDataShared)(_.userDataShared(_))
        .build

    def analyticsMetadataType(
      analyticsEndpointId: Option[String] = None
    ): AnalyticsMetadataType =
      AnalyticsMetadataType
        .builder
        .ifSome(analyticsEndpointId)(_.analyticsEndpointId(_))
        .build

    def associateSoftwareTokenRequest(
      accessToken: Option[String] = None,
      session: Option[String] = None
    ): AssociateSoftwareTokenRequest =
      AssociateSoftwareTokenRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(session)(_.session(_))
        .build

    def associateSoftwareTokenResponse(
      secretCode: Option[String] = None,
      session: Option[String] = None
    ): AssociateSoftwareTokenResponse =
      AssociateSoftwareTokenResponse
        .builder
        .ifSome(secretCode)(_.secretCode(_))
        .ifSome(session)(_.session(_))
        .build

    def attributeType(
      name: Option[String] = None,
      value: Option[String] = None
    ): AttributeType =
      AttributeType
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def authEventType(
      eventId: Option[String] = None,
      eventType: Option[String] = None,
      creationDate: Option[DateType] = None,
      eventResponse: Option[String] = None,
      eventRisk: Option[EventRiskType] = None,
      challengeResponses: Option[List[ChallengeResponseType]] = None,
      eventContextData: Option[EventContextDataType] = None,
      eventFeedback: Option[EventFeedbackType] = None
    ): AuthEventType =
      AuthEventType
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(eventResponse)(_.eventResponse(_))
        .ifSome(eventRisk)(_.eventRisk(_))
        .ifSome(challengeResponses)(_.challengeResponses(_))
        .ifSome(eventContextData)(_.eventContextData(_))
        .ifSome(eventFeedback)(_.eventFeedback(_))
        .build

    def authenticationResultType(
      accessToken: Option[String] = None,
      expiresIn: Option[Int] = None,
      tokenType: Option[String] = None,
      refreshToken: Option[String] = None,
      idToken: Option[String] = None,
      newDeviceMetadata: Option[NewDeviceMetadataType] = None
    ): AuthenticationResultType =
      AuthenticationResultType
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(expiresIn)(_.expiresIn(_))
        .ifSome(tokenType)(_.tokenType(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(idToken)(_.idToken(_))
        .ifSome(newDeviceMetadata)(_.newDeviceMetadata(_))
        .build

    def challengeResponseType(
      challengeName: Option[String] = None,
      challengeResponse: Option[String] = None
    ): ChallengeResponseType =
      ChallengeResponseType
        .builder
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(challengeResponse)(_.challengeResponse(_))
        .build

    def changePasswordRequest(
      previousPassword: Option[String] = None,
      proposedPassword: Option[String] = None,
      accessToken: Option[String] = None
    ): ChangePasswordRequest =
      ChangePasswordRequest
        .builder
        .ifSome(previousPassword)(_.previousPassword(_))
        .ifSome(proposedPassword)(_.proposedPassword(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def changePasswordResponse(

    ): ChangePasswordResponse =
      ChangePasswordResponse
        .builder

        .build

    def codeDeliveryDetailsType(
      destination: Option[String] = None,
      deliveryMedium: Option[String] = None,
      attributeName: Option[String] = None
    ): CodeDeliveryDetailsType =
      CodeDeliveryDetailsType
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(deliveryMedium)(_.deliveryMedium(_))
        .ifSome(attributeName)(_.attributeName(_))
        .build

    def codeDeliveryFailureException(
      message: Option[String] = None
    ): CodeDeliveryFailureException =
      CodeDeliveryFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def codeMismatchException(
      message: Option[String] = None
    ): CodeMismatchException =
      CodeMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def compromisedCredentialsActionsType(
      eventAction: Option[String] = None
    ): CompromisedCredentialsActionsType =
      CompromisedCredentialsActionsType
        .builder
        .ifSome(eventAction)(_.eventAction(_))
        .build

    def compromisedCredentialsRiskConfigurationType(
      eventFilter: Option[List[EventFilterType]] = None,
      actions: Option[CompromisedCredentialsActionsType] = None
    ): CompromisedCredentialsRiskConfigurationType =
      CompromisedCredentialsRiskConfigurationType
        .builder
        .ifSome(eventFilter)(_.eventFilter(_))
        .ifSome(actions)(_.actions(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def confirmDeviceRequest(
      accessToken: Option[String] = None,
      deviceKey: Option[String] = None,
      deviceSecretVerifierConfig: Option[DeviceSecretVerifierConfigType] = None,
      deviceName: Option[String] = None
    ): ConfirmDeviceRequest =
      ConfirmDeviceRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(deviceSecretVerifierConfig)(_.deviceSecretVerifierConfig(_))
        .ifSome(deviceName)(_.deviceName(_))
        .build

    def confirmDeviceResponse(
      userConfirmationNecessary: Option[Boolean] = None
    ): ConfirmDeviceResponse =
      ConfirmDeviceResponse
        .builder
        .ifSome(userConfirmationNecessary)(_.userConfirmationNecessary(_))
        .build

    def confirmForgotPasswordRequest(
      clientId: Option[String] = None,
      secretHash: Option[String] = None,
      username: Option[String] = None,
      confirmationCode: Option[String] = None,
      password: Option[String] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      userContextData: Option[UserContextDataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): ConfirmForgotPasswordRequest =
      ConfirmForgotPasswordRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(secretHash)(_.secretHash(_))
        .ifSome(username)(_.username(_))
        .ifSome(confirmationCode)(_.confirmationCode(_))
        .ifSome(password)(_.password(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(userContextData)(_.userContextData(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def confirmForgotPasswordResponse(

    ): ConfirmForgotPasswordResponse =
      ConfirmForgotPasswordResponse
        .builder

        .build

    def confirmSignUpRequest(
      clientId: Option[String] = None,
      secretHash: Option[String] = None,
      username: Option[String] = None,
      confirmationCode: Option[String] = None,
      forceAliasCreation: Option[Boolean] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      userContextData: Option[UserContextDataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): ConfirmSignUpRequest =
      ConfirmSignUpRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(secretHash)(_.secretHash(_))
        .ifSome(username)(_.username(_))
        .ifSome(confirmationCode)(_.confirmationCode(_))
        .ifSome(forceAliasCreation)(_.forceAliasCreation(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(userContextData)(_.userContextData(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def confirmSignUpResponse(

    ): ConfirmSignUpResponse =
      ConfirmSignUpResponse
        .builder

        .build

    def contextDataType(
      ipAddress: Option[String] = None,
      serverName: Option[String] = None,
      serverPath: Option[String] = None,
      httpHeaders: Option[List[HttpHeader]] = None,
      encodedData: Option[String] = None
    ): ContextDataType =
      ContextDataType
        .builder
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(serverPath)(_.serverPath(_))
        .ifSome(httpHeaders)(_.httpHeaders(_))
        .ifSome(encodedData)(_.encodedData(_))
        .build

    def createGroupRequest(
      groupName: Option[String] = None,
      userPoolId: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      precedence: Option[Int] = None
    ): CreateGroupRequest =
      CreateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(precedence)(_.precedence(_))
        .build

    def createGroupResponse(
      group: Option[GroupType] = None
    ): CreateGroupResponse =
      CreateGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .build

    def createIdentityProviderRequest(
      userPoolId: Option[String] = None,
      providerName: Option[String] = None,
      providerType: Option[String] = None,
      providerDetails: Option[ProviderDetailsType] = None,
      attributeMapping: Option[AttributeMappingType] = None,
      idpIdentifiers: Option[List[IdpIdentifierType]] = None
    ): CreateIdentityProviderRequest =
      CreateIdentityProviderRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(providerDetails)(_.providerDetails(_))
        .ifSome(attributeMapping)(_.attributeMapping(_))
        .ifSome(idpIdentifiers)(_.idpIdentifiers(_))
        .build

    def createIdentityProviderResponse(
      identityProvider: Option[IdentityProviderType] = None
    ): CreateIdentityProviderResponse =
      CreateIdentityProviderResponse
        .builder
        .ifSome(identityProvider)(_.identityProvider(_))
        .build

    def createResourceServerRequest(
      userPoolId: Option[String] = None,
      identifier: Option[String] = None,
      name: Option[String] = None,
      scopes: Option[List[ResourceServerScopeType]] = None
    ): CreateResourceServerRequest =
      CreateResourceServerRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(name)(_.name(_))
        .ifSome(scopes)(_.scopes(_))
        .build

    def createResourceServerResponse(
      resourceServer: Option[ResourceServerType] = None
    ): CreateResourceServerResponse =
      CreateResourceServerResponse
        .builder
        .ifSome(resourceServer)(_.resourceServer(_))
        .build

    def createUserImportJobRequest(
      jobName: Option[String] = None,
      userPoolId: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None
    ): CreateUserImportJobRequest =
      CreateUserImportJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .build

    def createUserImportJobResponse(
      userImportJob: Option[UserImportJobType] = None
    ): CreateUserImportJobResponse =
      CreateUserImportJobResponse
        .builder
        .ifSome(userImportJob)(_.userImportJob(_))
        .build

    def createUserPoolClientRequest(
      userPoolId: Option[String] = None,
      clientName: Option[String] = None,
      generateSecret: Option[Boolean] = None,
      refreshTokenValidity: Option[Int] = None,
      accessTokenValidity: Option[Int] = None,
      idTokenValidity: Option[Int] = None,
      tokenValidityUnits: Option[TokenValidityUnitsType] = None,
      readAttributes: Option[List[ClientPermissionType]] = None,
      writeAttributes: Option[List[ClientPermissionType]] = None,
      explicitAuthFlows: Option[List[ExplicitAuthFlowsType]] = None,
      supportedIdentityProviders: Option[List[ProviderNameType]] = None,
      callbackURLs: Option[List[RedirectUrlType]] = None,
      logoutURLs: Option[List[RedirectUrlType]] = None,
      defaultRedirectURI: Option[String] = None,
      allowedOAuthFlows: Option[List[OAuthFlowType]] = None,
      allowedOAuthScopes: Option[List[ScopeType]] = None,
      allowedOAuthFlowsUserPoolClient: Option[Boolean] = None,
      analyticsConfiguration: Option[AnalyticsConfigurationType] = None,
      preventUserExistenceErrors: Option[String] = None,
      enableTokenRevocation: Option[Boolean] = None
    ): CreateUserPoolClientRequest =
      CreateUserPoolClientRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientName)(_.clientName(_))
        .ifSome(generateSecret)(_.generateSecret(_))
        .ifSome(refreshTokenValidity)(_.refreshTokenValidity(_))
        .ifSome(accessTokenValidity)(_.accessTokenValidity(_))
        .ifSome(idTokenValidity)(_.idTokenValidity(_))
        .ifSome(tokenValidityUnits)(_.tokenValidityUnits(_))
        .ifSome(readAttributes)(_.readAttributes(_))
        .ifSome(writeAttributes)(_.writeAttributes(_))
        .ifSome(explicitAuthFlows)(_.explicitAuthFlows(_))
        .ifSome(supportedIdentityProviders)(_.supportedIdentityProviders(_))
        .ifSome(callbackURLs)(_.callbackURLs(_))
        .ifSome(logoutURLs)(_.logoutURLs(_))
        .ifSome(defaultRedirectURI)(_.defaultRedirectURI(_))
        .ifSome(allowedOAuthFlows)(_.allowedOAuthFlows(_))
        .ifSome(allowedOAuthScopes)(_.allowedOAuthScopes(_))
        .ifSome(allowedOAuthFlowsUserPoolClient)(_.allowedOAuthFlowsUserPoolClient(_))
        .ifSome(analyticsConfiguration)(_.analyticsConfiguration(_))
        .ifSome(preventUserExistenceErrors)(_.preventUserExistenceErrors(_))
        .ifSome(enableTokenRevocation)(_.enableTokenRevocation(_))
        .build

    def createUserPoolClientResponse(
      userPoolClient: Option[UserPoolClientType] = None
    ): CreateUserPoolClientResponse =
      CreateUserPoolClientResponse
        .builder
        .ifSome(userPoolClient)(_.userPoolClient(_))
        .build

    def createUserPoolDomainRequest(
      domain: Option[String] = None,
      userPoolId: Option[String] = None,
      customDomainConfig: Option[CustomDomainConfigType] = None
    ): CreateUserPoolDomainRequest =
      CreateUserPoolDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(customDomainConfig)(_.customDomainConfig(_))
        .build

    def createUserPoolDomainResponse(
      cloudFrontDomain: Option[String] = None
    ): CreateUserPoolDomainResponse =
      CreateUserPoolDomainResponse
        .builder
        .ifSome(cloudFrontDomain)(_.cloudFrontDomain(_))
        .build

    def createUserPoolRequest(
      poolName: Option[String] = None,
      policies: Option[UserPoolPolicyType] = None,
      lambdaConfig: Option[LambdaConfigType] = None,
      autoVerifiedAttributes: Option[List[VerifiedAttributeType]] = None,
      aliasAttributes: Option[List[AliasAttributeType]] = None,
      usernameAttributes: Option[List[UsernameAttributeType]] = None,
      smsVerificationMessage: Option[String] = None,
      emailVerificationMessage: Option[String] = None,
      emailVerificationSubject: Option[String] = None,
      verificationMessageTemplate: Option[VerificationMessageTemplateType] = None,
      smsAuthenticationMessage: Option[String] = None,
      mfaConfiguration: Option[String] = None,
      deviceConfiguration: Option[DeviceConfigurationType] = None,
      emailConfiguration: Option[EmailConfigurationType] = None,
      smsConfiguration: Option[SmsConfigurationType] = None,
      userPoolTags: Option[UserPoolTagsType] = None,
      adminCreateUserConfig: Option[AdminCreateUserConfigType] = None,
      schema: Option[List[SchemaAttributeType]] = None,
      userPoolAddOns: Option[UserPoolAddOnsType] = None,
      usernameConfiguration: Option[UsernameConfigurationType] = None,
      accountRecoverySetting: Option[AccountRecoverySettingType] = None
    ): CreateUserPoolRequest =
      CreateUserPoolRequest
        .builder
        .ifSome(poolName)(_.poolName(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(autoVerifiedAttributes)(_.autoVerifiedAttributes(_))
        .ifSome(aliasAttributes)(_.aliasAttributes(_))
        .ifSome(usernameAttributes)(_.usernameAttributes(_))
        .ifSome(smsVerificationMessage)(_.smsVerificationMessage(_))
        .ifSome(emailVerificationMessage)(_.emailVerificationMessage(_))
        .ifSome(emailVerificationSubject)(_.emailVerificationSubject(_))
        .ifSome(verificationMessageTemplate)(_.verificationMessageTemplate(_))
        .ifSome(smsAuthenticationMessage)(_.smsAuthenticationMessage(_))
        .ifSome(mfaConfiguration)(_.mfaConfiguration(_))
        .ifSome(deviceConfiguration)(_.deviceConfiguration(_))
        .ifSome(emailConfiguration)(_.emailConfiguration(_))
        .ifSome(smsConfiguration)(_.smsConfiguration(_))
        .ifSome(userPoolTags)(_.userPoolTags(_))
        .ifSome(adminCreateUserConfig)(_.adminCreateUserConfig(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(userPoolAddOns)(_.userPoolAddOns(_))
        .ifSome(usernameConfiguration)(_.usernameConfiguration(_))
        .ifSome(accountRecoverySetting)(_.accountRecoverySetting(_))
        .build

    def createUserPoolResponse(
      userPool: Option[UserPoolType] = None
    ): CreateUserPoolResponse =
      CreateUserPoolResponse
        .builder
        .ifSome(userPool)(_.userPool(_))
        .build

    def customDomainConfigType(
      certificateArn: Option[String] = None
    ): CustomDomainConfigType =
      CustomDomainConfigType
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def customEmailLambdaVersionConfigType(
      lambdaVersion: Option[String] = None,
      lambdaArn: Option[String] = None
    ): CustomEmailLambdaVersionConfigType =
      CustomEmailLambdaVersionConfigType
        .builder
        .ifSome(lambdaVersion)(_.lambdaVersion(_))
        .ifSome(lambdaArn)(_.lambdaArn(_))
        .build

    def customSMSLambdaVersionConfigType(
      lambdaVersion: Option[String] = None,
      lambdaArn: Option[String] = None
    ): CustomSMSLambdaVersionConfigType =
      CustomSMSLambdaVersionConfigType
        .builder
        .ifSome(lambdaVersion)(_.lambdaVersion(_))
        .ifSome(lambdaArn)(_.lambdaArn(_))
        .build

    def deleteGroupRequest(
      groupName: Option[String] = None,
      userPoolId: Option[String] = None
    ): DeleteGroupRequest =
      DeleteGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def deleteIdentityProviderRequest(
      userPoolId: Option[String] = None,
      providerName: Option[String] = None
    ): DeleteIdentityProviderRequest =
      DeleteIdentityProviderRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def deleteResourceServerRequest(
      userPoolId: Option[String] = None,
      identifier: Option[String] = None
    ): DeleteResourceServerRequest =
      DeleteResourceServerRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(identifier)(_.identifier(_))
        .build

    def deleteUserAttributesRequest(
      userAttributeNames: Option[List[AttributeNameType]] = None,
      accessToken: Option[String] = None
    ): DeleteUserAttributesRequest =
      DeleteUserAttributesRequest
        .builder
        .ifSome(userAttributeNames)(_.userAttributeNames(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def deleteUserAttributesResponse(

    ): DeleteUserAttributesResponse =
      DeleteUserAttributesResponse
        .builder

        .build

    def deleteUserPoolClientRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None
    ): DeleteUserPoolClientRequest =
      DeleteUserPoolClientRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def deleteUserPoolDomainRequest(
      domain: Option[String] = None,
      userPoolId: Option[String] = None
    ): DeleteUserPoolDomainRequest =
      DeleteUserPoolDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def deleteUserPoolDomainResponse(

    ): DeleteUserPoolDomainResponse =
      DeleteUserPoolDomainResponse
        .builder

        .build

    def deleteUserPoolRequest(
      userPoolId: Option[String] = None
    ): DeleteUserPoolRequest =
      DeleteUserPoolRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def deleteUserRequest(
      accessToken: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def describeIdentityProviderRequest(
      userPoolId: Option[String] = None,
      providerName: Option[String] = None
    ): DescribeIdentityProviderRequest =
      DescribeIdentityProviderRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def describeIdentityProviderResponse(
      identityProvider: Option[IdentityProviderType] = None
    ): DescribeIdentityProviderResponse =
      DescribeIdentityProviderResponse
        .builder
        .ifSome(identityProvider)(_.identityProvider(_))
        .build

    def describeResourceServerRequest(
      userPoolId: Option[String] = None,
      identifier: Option[String] = None
    ): DescribeResourceServerRequest =
      DescribeResourceServerRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(identifier)(_.identifier(_))
        .build

    def describeResourceServerResponse(
      resourceServer: Option[ResourceServerType] = None
    ): DescribeResourceServerResponse =
      DescribeResourceServerResponse
        .builder
        .ifSome(resourceServer)(_.resourceServer(_))
        .build

    def describeRiskConfigurationRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None
    ): DescribeRiskConfigurationRequest =
      DescribeRiskConfigurationRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def describeRiskConfigurationResponse(
      riskConfiguration: Option[RiskConfigurationType] = None
    ): DescribeRiskConfigurationResponse =
      DescribeRiskConfigurationResponse
        .builder
        .ifSome(riskConfiguration)(_.riskConfiguration(_))
        .build

    def describeUserImportJobRequest(
      userPoolId: Option[String] = None,
      jobId: Option[String] = None
    ): DescribeUserImportJobRequest =
      DescribeUserImportJobRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeUserImportJobResponse(
      userImportJob: Option[UserImportJobType] = None
    ): DescribeUserImportJobResponse =
      DescribeUserImportJobResponse
        .builder
        .ifSome(userImportJob)(_.userImportJob(_))
        .build

    def describeUserPoolClientRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None
    ): DescribeUserPoolClientRequest =
      DescribeUserPoolClientRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def describeUserPoolClientResponse(
      userPoolClient: Option[UserPoolClientType] = None
    ): DescribeUserPoolClientResponse =
      DescribeUserPoolClientResponse
        .builder
        .ifSome(userPoolClient)(_.userPoolClient(_))
        .build

    def describeUserPoolDomainRequest(
      domain: Option[String] = None
    ): DescribeUserPoolDomainRequest =
      DescribeUserPoolDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def describeUserPoolDomainResponse(
      domainDescription: Option[DomainDescriptionType] = None
    ): DescribeUserPoolDomainResponse =
      DescribeUserPoolDomainResponse
        .builder
        .ifSome(domainDescription)(_.domainDescription(_))
        .build

    def describeUserPoolRequest(
      userPoolId: Option[String] = None
    ): DescribeUserPoolRequest =
      DescribeUserPoolRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def describeUserPoolResponse(
      userPool: Option[UserPoolType] = None
    ): DescribeUserPoolResponse =
      DescribeUserPoolResponse
        .builder
        .ifSome(userPool)(_.userPool(_))
        .build

    def deviceConfigurationType(
      challengeRequiredOnNewDevice: Option[Boolean] = None,
      deviceOnlyRememberedOnUserPrompt: Option[Boolean] = None
    ): DeviceConfigurationType =
      DeviceConfigurationType
        .builder
        .ifSome(challengeRequiredOnNewDevice)(_.challengeRequiredOnNewDevice(_))
        .ifSome(deviceOnlyRememberedOnUserPrompt)(_.deviceOnlyRememberedOnUserPrompt(_))
        .build

    def deviceSecretVerifierConfigType(
      passwordVerifier: Option[String] = None,
      salt: Option[String] = None
    ): DeviceSecretVerifierConfigType =
      DeviceSecretVerifierConfigType
        .builder
        .ifSome(passwordVerifier)(_.passwordVerifier(_))
        .ifSome(salt)(_.salt(_))
        .build

    def deviceType(
      deviceKey: Option[String] = None,
      deviceAttributes: Option[List[AttributeType]] = None,
      deviceCreateDate: Option[DateType] = None,
      deviceLastModifiedDate: Option[DateType] = None,
      deviceLastAuthenticatedDate: Option[DateType] = None
    ): DeviceType =
      DeviceType
        .builder
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(deviceAttributes)(_.deviceAttributes(_))
        .ifSome(deviceCreateDate)(_.deviceCreateDate(_))
        .ifSome(deviceLastModifiedDate)(_.deviceLastModifiedDate(_))
        .ifSome(deviceLastAuthenticatedDate)(_.deviceLastAuthenticatedDate(_))
        .build

    def domainDescriptionType(
      userPoolId: Option[String] = None,
      aWSAccountId: Option[String] = None,
      domain: Option[String] = None,
      s3Bucket: Option[String] = None,
      cloudFrontDistribution: Option[String] = None,
      version: Option[String] = None,
      status: Option[String] = None,
      customDomainConfig: Option[CustomDomainConfigType] = None
    ): DomainDescriptionType =
      DomainDescriptionType
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(aWSAccountId)(_.aWSAccountId(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(cloudFrontDistribution)(_.cloudFrontDistribution(_))
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .ifSome(customDomainConfig)(_.customDomainConfig(_))
        .build

    def duplicateProviderException(
      message: Option[String] = None
    ): DuplicateProviderException =
      DuplicateProviderException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def emailConfigurationType(
      sourceArn: Option[String] = None,
      replyToEmailAddress: Option[String] = None,
      emailSendingAccount: Option[String] = None,
      from: Option[String] = None,
      configurationSet: Option[String] = None
    ): EmailConfigurationType =
      EmailConfigurationType
        .builder
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(replyToEmailAddress)(_.replyToEmailAddress(_))
        .ifSome(emailSendingAccount)(_.emailSendingAccount(_))
        .ifSome(from)(_.from(_))
        .ifSome(configurationSet)(_.configurationSet(_))
        .build

    def enableSoftwareTokenMFAException(
      message: Option[String] = None
    ): EnableSoftwareTokenMFAException =
      EnableSoftwareTokenMFAException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def eventContextDataType(
      ipAddress: Option[String] = None,
      deviceName: Option[String] = None,
      timezone: Option[String] = None,
      city: Option[String] = None,
      country: Option[String] = None
    ): EventContextDataType =
      EventContextDataType
        .builder
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(city)(_.city(_))
        .ifSome(country)(_.country(_))
        .build

    def eventFeedbackType(
      feedbackValue: Option[String] = None,
      provider: Option[String] = None,
      feedbackDate: Option[DateType] = None
    ): EventFeedbackType =
      EventFeedbackType
        .builder
        .ifSome(feedbackValue)(_.feedbackValue(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(feedbackDate)(_.feedbackDate(_))
        .build

    def eventRiskType(
      riskDecision: Option[String] = None,
      riskLevel: Option[String] = None,
      compromisedCredentialsDetected: Option[Boolean] = None
    ): EventRiskType =
      EventRiskType
        .builder
        .ifSome(riskDecision)(_.riskDecision(_))
        .ifSome(riskLevel)(_.riskLevel(_))
        .ifSome(compromisedCredentialsDetected)(_.compromisedCredentialsDetected(_))
        .build

    def expiredCodeException(
      message: Option[String] = None
    ): ExpiredCodeException =
      ExpiredCodeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def forgetDeviceRequest(
      accessToken: Option[String] = None,
      deviceKey: Option[String] = None
    ): ForgetDeviceRequest =
      ForgetDeviceRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(deviceKey)(_.deviceKey(_))
        .build

    def forgotPasswordRequest(
      clientId: Option[String] = None,
      secretHash: Option[String] = None,
      userContextData: Option[UserContextDataType] = None,
      username: Option[String] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): ForgotPasswordRequest =
      ForgotPasswordRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(secretHash)(_.secretHash(_))
        .ifSome(userContextData)(_.userContextData(_))
        .ifSome(username)(_.username(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def forgotPasswordResponse(
      codeDeliveryDetails: Option[CodeDeliveryDetailsType] = None
    ): ForgotPasswordResponse =
      ForgotPasswordResponse
        .builder
        .ifSome(codeDeliveryDetails)(_.codeDeliveryDetails(_))
        .build

    def getCSVHeaderRequest(
      userPoolId: Option[String] = None
    ): GetCSVHeaderRequest =
      GetCSVHeaderRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def getCSVHeaderResponse(
      userPoolId: Option[String] = None,
      cSVHeader: Option[List[StringType]] = None
    ): GetCSVHeaderResponse =
      GetCSVHeaderResponse
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(cSVHeader)(_.cSVHeader(_))
        .build

    def getDeviceRequest(
      deviceKey: Option[String] = None,
      accessToken: Option[String] = None
    ): GetDeviceRequest =
      GetDeviceRequest
        .builder
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def getDeviceResponse(
      device: Option[DeviceType] = None
    ): GetDeviceResponse =
      GetDeviceResponse
        .builder
        .ifSome(device)(_.device(_))
        .build

    def getGroupRequest(
      groupName: Option[String] = None,
      userPoolId: Option[String] = None
    ): GetGroupRequest =
      GetGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def getGroupResponse(
      group: Option[GroupType] = None
    ): GetGroupResponse =
      GetGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .build

    def getIdentityProviderByIdentifierRequest(
      userPoolId: Option[String] = None,
      idpIdentifier: Option[String] = None
    ): GetIdentityProviderByIdentifierRequest =
      GetIdentityProviderByIdentifierRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(idpIdentifier)(_.idpIdentifier(_))
        .build

    def getIdentityProviderByIdentifierResponse(
      identityProvider: Option[IdentityProviderType] = None
    ): GetIdentityProviderByIdentifierResponse =
      GetIdentityProviderByIdentifierResponse
        .builder
        .ifSome(identityProvider)(_.identityProvider(_))
        .build

    def getSigningCertificateRequest(
      userPoolId: Option[String] = None
    ): GetSigningCertificateRequest =
      GetSigningCertificateRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def getSigningCertificateResponse(
      certificate: Option[String] = None
    ): GetSigningCertificateResponse =
      GetSigningCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .build

    def getUICustomizationRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None
    ): GetUICustomizationRequest =
      GetUICustomizationRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def getUICustomizationResponse(
      uICustomization: Option[UICustomizationType] = None
    ): GetUICustomizationResponse =
      GetUICustomizationResponse
        .builder
        .ifSome(uICustomization)(_.uICustomization(_))
        .build

    def getUserAttributeVerificationCodeRequest(
      accessToken: Option[String] = None,
      attributeName: Option[String] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): GetUserAttributeVerificationCodeRequest =
      GetUserAttributeVerificationCodeRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def getUserAttributeVerificationCodeResponse(
      codeDeliveryDetails: Option[CodeDeliveryDetailsType] = None
    ): GetUserAttributeVerificationCodeResponse =
      GetUserAttributeVerificationCodeResponse
        .builder
        .ifSome(codeDeliveryDetails)(_.codeDeliveryDetails(_))
        .build

    def getUserPoolMfaConfigRequest(
      userPoolId: Option[String] = None
    ): GetUserPoolMfaConfigRequest =
      GetUserPoolMfaConfigRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .build

    def getUserPoolMfaConfigResponse(
      smsMfaConfiguration: Option[SmsMfaConfigType] = None,
      softwareTokenMfaConfiguration: Option[SoftwareTokenMfaConfigType] = None,
      mfaConfiguration: Option[String] = None
    ): GetUserPoolMfaConfigResponse =
      GetUserPoolMfaConfigResponse
        .builder
        .ifSome(smsMfaConfiguration)(_.smsMfaConfiguration(_))
        .ifSome(softwareTokenMfaConfiguration)(_.softwareTokenMfaConfiguration(_))
        .ifSome(mfaConfiguration)(_.mfaConfiguration(_))
        .build

    def getUserRequest(
      accessToken: Option[String] = None
    ): GetUserRequest =
      GetUserRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def getUserResponse(
      username: Option[String] = None,
      userAttributes: Option[List[AttributeType]] = None,
      mFAOptions: Option[List[MFAOptionType]] = None,
      preferredMfaSetting: Option[String] = None,
      userMFASettingList: Option[List[StringType]] = None
    ): GetUserResponse =
      GetUserResponse
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(mFAOptions)(_.mFAOptions(_))
        .ifSome(preferredMfaSetting)(_.preferredMfaSetting(_))
        .ifSome(userMFASettingList)(_.userMFASettingList(_))
        .build

    def globalSignOutRequest(
      accessToken: Option[String] = None
    ): GlobalSignOutRequest =
      GlobalSignOutRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def globalSignOutResponse(

    ): GlobalSignOutResponse =
      GlobalSignOutResponse
        .builder

        .build

    def groupExistsException(
      message: Option[String] = None
    ): GroupExistsException =
      GroupExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def groupType(
      groupName: Option[String] = None,
      userPoolId: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      precedence: Option[Int] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None
    ): GroupType =
      GroupType
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(precedence)(_.precedence(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def httpHeader(
      headerName: Option[String] = None,
      headerValue: Option[String] = None
    ): HttpHeader =
      HttpHeader
        .builder
        .ifSome(headerName)(_.headerName(_))
        .ifSome(headerValue)(_.headerValue(_))
        .build

    def identityProviderType(
      userPoolId: Option[String] = None,
      providerName: Option[String] = None,
      providerType: Option[String] = None,
      providerDetails: Option[ProviderDetailsType] = None,
      attributeMapping: Option[AttributeMappingType] = None,
      idpIdentifiers: Option[List[IdpIdentifierType]] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None
    ): IdentityProviderType =
      IdentityProviderType
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(providerDetails)(_.providerDetails(_))
        .ifSome(attributeMapping)(_.attributeMapping(_))
        .ifSome(idpIdentifiers)(_.idpIdentifiers(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def initiateAuthRequest(
      authFlow: Option[String] = None,
      authParameters: Option[AuthParametersType] = None,
      clientMetadata: Option[ClientMetadataType] = None,
      clientId: Option[String] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      userContextData: Option[UserContextDataType] = None
    ): InitiateAuthRequest =
      InitiateAuthRequest
        .builder
        .ifSome(authFlow)(_.authFlow(_))
        .ifSome(authParameters)(_.authParameters(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(userContextData)(_.userContextData(_))
        .build

    def initiateAuthResponse(
      challengeName: Option[String] = None,
      session: Option[String] = None,
      challengeParameters: Option[ChallengeParametersType] = None,
      authenticationResult: Option[AuthenticationResultType] = None
    ): InitiateAuthResponse =
      InitiateAuthResponse
        .builder
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(session)(_.session(_))
        .ifSome(challengeParameters)(_.challengeParameters(_))
        .ifSome(authenticationResult)(_.authenticationResult(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidEmailRoleAccessPolicyException(
      message: Option[String] = None
    ): InvalidEmailRoleAccessPolicyException =
      InvalidEmailRoleAccessPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidLambdaResponseException(
      message: Option[String] = None
    ): InvalidLambdaResponseException =
      InvalidLambdaResponseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOAuthFlowException(
      message: Option[String] = None
    ): InvalidOAuthFlowException =
      InvalidOAuthFlowException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPasswordException(
      message: Option[String] = None
    ): InvalidPasswordException =
      InvalidPasswordException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSmsRoleAccessPolicyException(
      message: Option[String] = None
    ): InvalidSmsRoleAccessPolicyException =
      InvalidSmsRoleAccessPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSmsRoleTrustRelationshipException(
      message: Option[String] = None
    ): InvalidSmsRoleTrustRelationshipException =
      InvalidSmsRoleTrustRelationshipException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidUserPoolConfigurationException(
      message: Option[String] = None
    ): InvalidUserPoolConfigurationException =
      InvalidUserPoolConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lambdaConfigType(
      preSignUp: Option[String] = None,
      customMessage: Option[String] = None,
      postConfirmation: Option[String] = None,
      preAuthentication: Option[String] = None,
      postAuthentication: Option[String] = None,
      defineAuthChallenge: Option[String] = None,
      createAuthChallenge: Option[String] = None,
      verifyAuthChallengeResponse: Option[String] = None,
      preTokenGeneration: Option[String] = None,
      userMigration: Option[String] = None,
      customSMSSender: Option[CustomSMSLambdaVersionConfigType] = None,
      customEmailSender: Option[CustomEmailLambdaVersionConfigType] = None,
      kMSKeyID: Option[String] = None
    ): LambdaConfigType =
      LambdaConfigType
        .builder
        .ifSome(preSignUp)(_.preSignUp(_))
        .ifSome(customMessage)(_.customMessage(_))
        .ifSome(postConfirmation)(_.postConfirmation(_))
        .ifSome(preAuthentication)(_.preAuthentication(_))
        .ifSome(postAuthentication)(_.postAuthentication(_))
        .ifSome(defineAuthChallenge)(_.defineAuthChallenge(_))
        .ifSome(createAuthChallenge)(_.createAuthChallenge(_))
        .ifSome(verifyAuthChallengeResponse)(_.verifyAuthChallengeResponse(_))
        .ifSome(preTokenGeneration)(_.preTokenGeneration(_))
        .ifSome(userMigration)(_.userMigration(_))
        .ifSome(customSMSSender)(_.customSMSSender(_))
        .ifSome(customEmailSender)(_.customEmailSender(_))
        .ifSome(kMSKeyID)(_.kMSKeyID(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDevicesRequest(
      accessToken: Option[String] = None,
      limit: Option[Int] = None,
      paginationToken: Option[String] = None
    ): ListDevicesRequest =
      ListDevicesRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def listDevicesResponse(
      devices: Option[List[DeviceType]] = None,
      paginationToken: Option[String] = None
    ): ListDevicesResponse =
      ListDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def listGroupsRequest(
      userPoolId: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListGroupsRequest =
      ListGroupsRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupsResponse(
      groups: Option[List[GroupType]] = None,
      nextToken: Option[String] = None
    ): ListGroupsResponse =
      ListGroupsResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityProvidersRequest(
      userPoolId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIdentityProvidersRequest =
      ListIdentityProvidersRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityProvidersResponse(
      providers: Option[List[ProviderDescription]] = None,
      nextToken: Option[String] = None
    ): ListIdentityProvidersResponse =
      ListIdentityProvidersResponse
        .builder
        .ifSome(providers)(_.providers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceServersRequest(
      userPoolId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListResourceServersRequest =
      ListResourceServersRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceServersResponse(
      resourceServers: Option[List[ResourceServerType]] = None,
      nextToken: Option[String] = None
    ): ListResourceServersResponse =
      ListResourceServersResponse
        .builder
        .ifSome(resourceServers)(_.resourceServers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[UserPoolTagsType] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listUserImportJobsRequest(
      userPoolId: Option[String] = None,
      maxResults: Option[Int] = None,
      paginationToken: Option[String] = None
    ): ListUserImportJobsRequest =
      ListUserImportJobsRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def listUserImportJobsResponse(
      userImportJobs: Option[List[UserImportJobType]] = None,
      paginationToken: Option[String] = None
    ): ListUserImportJobsResponse =
      ListUserImportJobsResponse
        .builder
        .ifSome(userImportJobs)(_.userImportJobs(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def listUserPoolClientsRequest(
      userPoolId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListUserPoolClientsRequest =
      ListUserPoolClientsRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUserPoolClientsResponse(
      userPoolClients: Option[List[UserPoolClientDescription]] = None,
      nextToken: Option[String] = None
    ): ListUserPoolClientsResponse =
      ListUserPoolClientsResponse
        .builder
        .ifSome(userPoolClients)(_.userPoolClients(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUserPoolsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUserPoolsRequest =
      ListUserPoolsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUserPoolsResponse(
      userPools: Option[List[UserPoolDescriptionType]] = None,
      nextToken: Option[String] = None
    ): ListUserPoolsResponse =
      ListUserPoolsResponse
        .builder
        .ifSome(userPools)(_.userPools(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersInGroupRequest(
      userPoolId: Option[String] = None,
      groupName: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListUsersInGroupRequest =
      ListUsersInGroupRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersInGroupResponse(
      users: Option[List[UserType]] = None,
      nextToken: Option[String] = None
    ): ListUsersInGroupResponse =
      ListUsersInGroupResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersRequest(
      userPoolId: Option[String] = None,
      attributesToGet: Option[List[AttributeNameType]] = None,
      limit: Option[Int] = None,
      paginationToken: Option[String] = None,
      filter: Option[String] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(attributesToGet)(_.attributesToGet(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listUsersResponse(
      users: Option[List[UserType]] = None,
      paginationToken: Option[String] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def mFAMethodNotFoundException(
      message: Option[String] = None
    ): MFAMethodNotFoundException =
      MFAMethodNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def mFAOptionType(
      deliveryMedium: Option[String] = None,
      attributeName: Option[String] = None
    ): MFAOptionType =
      MFAOptionType
        .builder
        .ifSome(deliveryMedium)(_.deliveryMedium(_))
        .ifSome(attributeName)(_.attributeName(_))
        .build

    def messageTemplateType(
      sMSMessage: Option[String] = None,
      emailMessage: Option[String] = None,
      emailSubject: Option[String] = None
    ): MessageTemplateType =
      MessageTemplateType
        .builder
        .ifSome(sMSMessage)(_.sMSMessage(_))
        .ifSome(emailMessage)(_.emailMessage(_))
        .ifSome(emailSubject)(_.emailSubject(_))
        .build

    def newDeviceMetadataType(
      deviceKey: Option[String] = None,
      deviceGroupKey: Option[String] = None
    ): NewDeviceMetadataType =
      NewDeviceMetadataType
        .builder
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(deviceGroupKey)(_.deviceGroupKey(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notifyConfigurationType(
      from: Option[String] = None,
      replyTo: Option[String] = None,
      sourceArn: Option[String] = None,
      blockEmail: Option[NotifyEmailType] = None,
      noActionEmail: Option[NotifyEmailType] = None,
      mfaEmail: Option[NotifyEmailType] = None
    ): NotifyConfigurationType =
      NotifyConfigurationType
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(replyTo)(_.replyTo(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(blockEmail)(_.blockEmail(_))
        .ifSome(noActionEmail)(_.noActionEmail(_))
        .ifSome(mfaEmail)(_.mfaEmail(_))
        .build

    def notifyEmailType(
      subject: Option[String] = None,
      htmlBody: Option[String] = None,
      textBody: Option[String] = None
    ): NotifyEmailType =
      NotifyEmailType
        .builder
        .ifSome(subject)(_.subject(_))
        .ifSome(htmlBody)(_.htmlBody(_))
        .ifSome(textBody)(_.textBody(_))
        .build

    def numberAttributeConstraintsType(
      minValue: Option[String] = None,
      maxValue: Option[String] = None
    ): NumberAttributeConstraintsType =
      NumberAttributeConstraintsType
        .builder
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .build

    def passwordPolicyType(
      minimumLength: Option[Int] = None,
      requireUppercase: Option[Boolean] = None,
      requireLowercase: Option[Boolean] = None,
      requireNumbers: Option[Boolean] = None,
      requireSymbols: Option[Boolean] = None,
      temporaryPasswordValidityDays: Option[Int] = None
    ): PasswordPolicyType =
      PasswordPolicyType
        .builder
        .ifSome(minimumLength)(_.minimumLength(_))
        .ifSome(requireUppercase)(_.requireUppercase(_))
        .ifSome(requireLowercase)(_.requireLowercase(_))
        .ifSome(requireNumbers)(_.requireNumbers(_))
        .ifSome(requireSymbols)(_.requireSymbols(_))
        .ifSome(temporaryPasswordValidityDays)(_.temporaryPasswordValidityDays(_))
        .build

    def passwordResetRequiredException(
      message: Option[String] = None
    ): PasswordResetRequiredException =
      PasswordResetRequiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def preconditionNotMetException(
      message: Option[String] = None
    ): PreconditionNotMetException =
      PreconditionNotMetException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def providerDescription(
      providerName: Option[String] = None,
      providerType: Option[String] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None
    ): ProviderDescription =
      ProviderDescription
        .builder
        .ifSome(providerName)(_.providerName(_))
        .ifSome(providerType)(_.providerType(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def providerUserIdentifierType(
      providerName: Option[String] = None,
      providerAttributeName: Option[String] = None,
      providerAttributeValue: Option[String] = None
    ): ProviderUserIdentifierType =
      ProviderUserIdentifierType
        .builder
        .ifSome(providerName)(_.providerName(_))
        .ifSome(providerAttributeName)(_.providerAttributeName(_))
        .ifSome(providerAttributeValue)(_.providerAttributeValue(_))
        .build

    def recoveryOptionType(
      priority: Option[Int] = None,
      name: Option[String] = None
    ): RecoveryOptionType =
      RecoveryOptionType
        .builder
        .ifSome(priority)(_.priority(_))
        .ifSome(name)(_.name(_))
        .build

    def resendConfirmationCodeRequest(
      clientId: Option[String] = None,
      secretHash: Option[String] = None,
      userContextData: Option[UserContextDataType] = None,
      username: Option[String] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): ResendConfirmationCodeRequest =
      ResendConfirmationCodeRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(secretHash)(_.secretHash(_))
        .ifSome(userContextData)(_.userContextData(_))
        .ifSome(username)(_.username(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def resendConfirmationCodeResponse(
      codeDeliveryDetails: Option[CodeDeliveryDetailsType] = None
    ): ResendConfirmationCodeResponse =
      ResendConfirmationCodeResponse
        .builder
        .ifSome(codeDeliveryDetails)(_.codeDeliveryDetails(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceServerScopeType(
      scopeName: Option[String] = None,
      scopeDescription: Option[String] = None
    ): ResourceServerScopeType =
      ResourceServerScopeType
        .builder
        .ifSome(scopeName)(_.scopeName(_))
        .ifSome(scopeDescription)(_.scopeDescription(_))
        .build

    def resourceServerType(
      userPoolId: Option[String] = None,
      identifier: Option[String] = None,
      name: Option[String] = None,
      scopes: Option[List[ResourceServerScopeType]] = None
    ): ResourceServerType =
      ResourceServerType
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(name)(_.name(_))
        .ifSome(scopes)(_.scopes(_))
        .build

    def respondToAuthChallengeRequest(
      clientId: Option[String] = None,
      challengeName: Option[String] = None,
      session: Option[String] = None,
      challengeResponses: Option[ChallengeResponsesType] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      userContextData: Option[UserContextDataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): RespondToAuthChallengeRequest =
      RespondToAuthChallengeRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(session)(_.session(_))
        .ifSome(challengeResponses)(_.challengeResponses(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(userContextData)(_.userContextData(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def respondToAuthChallengeResponse(
      challengeName: Option[String] = None,
      session: Option[String] = None,
      challengeParameters: Option[ChallengeParametersType] = None,
      authenticationResult: Option[AuthenticationResultType] = None
    ): RespondToAuthChallengeResponse =
      RespondToAuthChallengeResponse
        .builder
        .ifSome(challengeName)(_.challengeName(_))
        .ifSome(session)(_.session(_))
        .ifSome(challengeParameters)(_.challengeParameters(_))
        .ifSome(authenticationResult)(_.authenticationResult(_))
        .build

    def revokeTokenRequest(
      token: Option[String] = None,
      clientId: Option[String] = None,
      clientSecret: Option[String] = None
    ): RevokeTokenRequest =
      RevokeTokenRequest
        .builder
        .ifSome(token)(_.token(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .build

    def revokeTokenResponse(

    ): RevokeTokenResponse =
      RevokeTokenResponse
        .builder

        .build

    def riskConfigurationType(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      compromisedCredentialsRiskConfiguration: Option[CompromisedCredentialsRiskConfigurationType] = None,
      accountTakeoverRiskConfiguration: Option[AccountTakeoverRiskConfigurationType] = None,
      riskExceptionConfiguration: Option[RiskExceptionConfigurationType] = None,
      lastModifiedDate: Option[DateType] = None
    ): RiskConfigurationType =
      RiskConfigurationType
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(compromisedCredentialsRiskConfiguration)(_.compromisedCredentialsRiskConfiguration(_))
        .ifSome(accountTakeoverRiskConfiguration)(_.accountTakeoverRiskConfiguration(_))
        .ifSome(riskExceptionConfiguration)(_.riskExceptionConfiguration(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def riskExceptionConfigurationType(
      blockedIPRangeList: Option[List[StringType]] = None,
      skippedIPRangeList: Option[List[StringType]] = None
    ): RiskExceptionConfigurationType =
      RiskExceptionConfigurationType
        .builder
        .ifSome(blockedIPRangeList)(_.blockedIPRangeList(_))
        .ifSome(skippedIPRangeList)(_.skippedIPRangeList(_))
        .build

    def sMSMfaSettingsType(
      enabled: Option[Boolean] = None,
      preferredMfa: Option[Boolean] = None
    ): SMSMfaSettingsType =
      SMSMfaSettingsType
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(preferredMfa)(_.preferredMfa(_))
        .build

    def schemaAttributeType(
      name: Option[String] = None,
      attributeDataType: Option[String] = None,
      developerOnlyAttribute: Option[Boolean] = None,
      mutable: Option[Boolean] = None,
      required: Option[Boolean] = None,
      numberAttributeConstraints: Option[NumberAttributeConstraintsType] = None,
      stringAttributeConstraints: Option[StringAttributeConstraintsType] = None
    ): SchemaAttributeType =
      SchemaAttributeType
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributeDataType)(_.attributeDataType(_))
        .ifSome(developerOnlyAttribute)(_.developerOnlyAttribute(_))
        .ifSome(mutable)(_.mutable(_))
        .ifSome(required)(_.required(_))
        .ifSome(numberAttributeConstraints)(_.numberAttributeConstraints(_))
        .ifSome(stringAttributeConstraints)(_.stringAttributeConstraints(_))
        .build

    def scopeDoesNotExistException(
      message: Option[String] = None
    ): ScopeDoesNotExistException =
      ScopeDoesNotExistException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def setRiskConfigurationRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      compromisedCredentialsRiskConfiguration: Option[CompromisedCredentialsRiskConfigurationType] = None,
      accountTakeoverRiskConfiguration: Option[AccountTakeoverRiskConfigurationType] = None,
      riskExceptionConfiguration: Option[RiskExceptionConfigurationType] = None
    ): SetRiskConfigurationRequest =
      SetRiskConfigurationRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(compromisedCredentialsRiskConfiguration)(_.compromisedCredentialsRiskConfiguration(_))
        .ifSome(accountTakeoverRiskConfiguration)(_.accountTakeoverRiskConfiguration(_))
        .ifSome(riskExceptionConfiguration)(_.riskExceptionConfiguration(_))
        .build

    def setRiskConfigurationResponse(
      riskConfiguration: Option[RiskConfigurationType] = None
    ): SetRiskConfigurationResponse =
      SetRiskConfigurationResponse
        .builder
        .ifSome(riskConfiguration)(_.riskConfiguration(_))
        .build

    def setUICustomizationRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      cSS: Option[String] = None,
      imageFile: Option[ImageFileType] = None
    ): SetUICustomizationRequest =
      SetUICustomizationRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(cSS)(_.cSS(_))
        .ifSome(imageFile)(_.imageFile(_))
        .build

    def setUICustomizationResponse(
      uICustomization: Option[UICustomizationType] = None
    ): SetUICustomizationResponse =
      SetUICustomizationResponse
        .builder
        .ifSome(uICustomization)(_.uICustomization(_))
        .build

    def setUserMFAPreferenceRequest(
      sMSMfaSettings: Option[SMSMfaSettingsType] = None,
      softwareTokenMfaSettings: Option[SoftwareTokenMfaSettingsType] = None,
      accessToken: Option[String] = None
    ): SetUserMFAPreferenceRequest =
      SetUserMFAPreferenceRequest
        .builder
        .ifSome(sMSMfaSettings)(_.sMSMfaSettings(_))
        .ifSome(softwareTokenMfaSettings)(_.softwareTokenMfaSettings(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def setUserMFAPreferenceResponse(

    ): SetUserMFAPreferenceResponse =
      SetUserMFAPreferenceResponse
        .builder

        .build

    def setUserPoolMfaConfigRequest(
      userPoolId: Option[String] = None,
      smsMfaConfiguration: Option[SmsMfaConfigType] = None,
      softwareTokenMfaConfiguration: Option[SoftwareTokenMfaConfigType] = None,
      mfaConfiguration: Option[String] = None
    ): SetUserPoolMfaConfigRequest =
      SetUserPoolMfaConfigRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(smsMfaConfiguration)(_.smsMfaConfiguration(_))
        .ifSome(softwareTokenMfaConfiguration)(_.softwareTokenMfaConfiguration(_))
        .ifSome(mfaConfiguration)(_.mfaConfiguration(_))
        .build

    def setUserPoolMfaConfigResponse(
      smsMfaConfiguration: Option[SmsMfaConfigType] = None,
      softwareTokenMfaConfiguration: Option[SoftwareTokenMfaConfigType] = None,
      mfaConfiguration: Option[String] = None
    ): SetUserPoolMfaConfigResponse =
      SetUserPoolMfaConfigResponse
        .builder
        .ifSome(smsMfaConfiguration)(_.smsMfaConfiguration(_))
        .ifSome(softwareTokenMfaConfiguration)(_.softwareTokenMfaConfiguration(_))
        .ifSome(mfaConfiguration)(_.mfaConfiguration(_))
        .build

    def setUserSettingsRequest(
      accessToken: Option[String] = None,
      mFAOptions: Option[List[MFAOptionType]] = None
    ): SetUserSettingsRequest =
      SetUserSettingsRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(mFAOptions)(_.mFAOptions(_))
        .build

    def setUserSettingsResponse(

    ): SetUserSettingsResponse =
      SetUserSettingsResponse
        .builder

        .build

    def signUpRequest(
      clientId: Option[String] = None,
      secretHash: Option[String] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      userAttributes: Option[List[AttributeType]] = None,
      validationData: Option[List[AttributeType]] = None,
      analyticsMetadata: Option[AnalyticsMetadataType] = None,
      userContextData: Option[UserContextDataType] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): SignUpRequest =
      SignUpRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(secretHash)(_.secretHash(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(validationData)(_.validationData(_))
        .ifSome(analyticsMetadata)(_.analyticsMetadata(_))
        .ifSome(userContextData)(_.userContextData(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def signUpResponse(
      userConfirmed: Option[Boolean] = None,
      codeDeliveryDetails: Option[CodeDeliveryDetailsType] = None,
      userSub: Option[String] = None
    ): SignUpResponse =
      SignUpResponse
        .builder
        .ifSome(userConfirmed)(_.userConfirmed(_))
        .ifSome(codeDeliveryDetails)(_.codeDeliveryDetails(_))
        .ifSome(userSub)(_.userSub(_))
        .build

    def smsConfigurationType(
      snsCallerArn: Option[String] = None,
      externalId: Option[String] = None
    ): SmsConfigurationType =
      SmsConfigurationType
        .builder
        .ifSome(snsCallerArn)(_.snsCallerArn(_))
        .ifSome(externalId)(_.externalId(_))
        .build

    def smsMfaConfigType(
      smsAuthenticationMessage: Option[String] = None,
      smsConfiguration: Option[SmsConfigurationType] = None
    ): SmsMfaConfigType =
      SmsMfaConfigType
        .builder
        .ifSome(smsAuthenticationMessage)(_.smsAuthenticationMessage(_))
        .ifSome(smsConfiguration)(_.smsConfiguration(_))
        .build

    def softwareTokenMFANotFoundException(
      message: Option[String] = None
    ): SoftwareTokenMFANotFoundException =
      SoftwareTokenMFANotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def softwareTokenMfaConfigType(
      enabled: Option[Boolean] = None
    ): SoftwareTokenMfaConfigType =
      SoftwareTokenMfaConfigType
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def softwareTokenMfaSettingsType(
      enabled: Option[Boolean] = None,
      preferredMfa: Option[Boolean] = None
    ): SoftwareTokenMfaSettingsType =
      SoftwareTokenMfaSettingsType
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(preferredMfa)(_.preferredMfa(_))
        .build

    def startUserImportJobRequest(
      userPoolId: Option[String] = None,
      jobId: Option[String] = None
    ): StartUserImportJobRequest =
      StartUserImportJobRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def startUserImportJobResponse(
      userImportJob: Option[UserImportJobType] = None
    ): StartUserImportJobResponse =
      StartUserImportJobResponse
        .builder
        .ifSome(userImportJob)(_.userImportJob(_))
        .build

    def stopUserImportJobRequest(
      userPoolId: Option[String] = None,
      jobId: Option[String] = None
    ): StopUserImportJobRequest =
      StopUserImportJobRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopUserImportJobResponse(
      userImportJob: Option[UserImportJobType] = None
    ): StopUserImportJobResponse =
      StopUserImportJobResponse
        .builder
        .ifSome(userImportJob)(_.userImportJob(_))
        .build

    def stringAttributeConstraintsType(
      minLength: Option[String] = None,
      maxLength: Option[String] = None
    ): StringAttributeConstraintsType =
      StringAttributeConstraintsType
        .builder
        .ifSome(minLength)(_.minLength(_))
        .ifSome(maxLength)(_.maxLength(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[UserPoolTagsType] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tokenValidityUnitsType(
      accessToken: Option[String] = None,
      idToken: Option[String] = None,
      refreshToken: Option[String] = None
    ): TokenValidityUnitsType =
      TokenValidityUnitsType
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(idToken)(_.idToken(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .build

    def tooManyFailedAttemptsException(
      message: Option[String] = None
    ): TooManyFailedAttemptsException =
      TooManyFailedAttemptsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def uICustomizationType(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      imageUrl: Option[String] = None,
      cSS: Option[String] = None,
      cSSVersion: Option[String] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None
    ): UICustomizationType =
      UICustomizationType
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(imageUrl)(_.imageUrl(_))
        .ifSome(cSS)(_.cSS(_))
        .ifSome(cSSVersion)(_.cSSVersion(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unexpectedLambdaException(
      message: Option[String] = None
    ): UnexpectedLambdaException =
      UnexpectedLambdaException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedIdentityProviderException(
      message: Option[String] = None
    ): UnsupportedIdentityProviderException =
      UnsupportedIdentityProviderException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedTokenTypeException(
      message: Option[String] = None
    ): UnsupportedTokenTypeException =
      UnsupportedTokenTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedUserStateException(
      message: Option[String] = None
    ): UnsupportedUserStateException =
      UnsupportedUserStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKeysType]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateAuthEventFeedbackRequest(
      userPoolId: Option[String] = None,
      username: Option[String] = None,
      eventId: Option[String] = None,
      feedbackToken: Option[String] = None,
      feedbackValue: Option[String] = None
    ): UpdateAuthEventFeedbackRequest =
      UpdateAuthEventFeedbackRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(username)(_.username(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(feedbackToken)(_.feedbackToken(_))
        .ifSome(feedbackValue)(_.feedbackValue(_))
        .build

    def updateAuthEventFeedbackResponse(

    ): UpdateAuthEventFeedbackResponse =
      UpdateAuthEventFeedbackResponse
        .builder

        .build

    def updateDeviceStatusRequest(
      accessToken: Option[String] = None,
      deviceKey: Option[String] = None,
      deviceRememberedStatus: Option[String] = None
    ): UpdateDeviceStatusRequest =
      UpdateDeviceStatusRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(deviceKey)(_.deviceKey(_))
        .ifSome(deviceRememberedStatus)(_.deviceRememberedStatus(_))
        .build

    def updateDeviceStatusResponse(

    ): UpdateDeviceStatusResponse =
      UpdateDeviceStatusResponse
        .builder

        .build

    def updateGroupRequest(
      groupName: Option[String] = None,
      userPoolId: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      precedence: Option[Int] = None
    ): UpdateGroupRequest =
      UpdateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(precedence)(_.precedence(_))
        .build

    def updateGroupResponse(
      group: Option[GroupType] = None
    ): UpdateGroupResponse =
      UpdateGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .build

    def updateIdentityProviderRequest(
      userPoolId: Option[String] = None,
      providerName: Option[String] = None,
      providerDetails: Option[ProviderDetailsType] = None,
      attributeMapping: Option[AttributeMappingType] = None,
      idpIdentifiers: Option[List[IdpIdentifierType]] = None
    ): UpdateIdentityProviderRequest =
      UpdateIdentityProviderRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(providerDetails)(_.providerDetails(_))
        .ifSome(attributeMapping)(_.attributeMapping(_))
        .ifSome(idpIdentifiers)(_.idpIdentifiers(_))
        .build

    def updateIdentityProviderResponse(
      identityProvider: Option[IdentityProviderType] = None
    ): UpdateIdentityProviderResponse =
      UpdateIdentityProviderResponse
        .builder
        .ifSome(identityProvider)(_.identityProvider(_))
        .build

    def updateResourceServerRequest(
      userPoolId: Option[String] = None,
      identifier: Option[String] = None,
      name: Option[String] = None,
      scopes: Option[List[ResourceServerScopeType]] = None
    ): UpdateResourceServerRequest =
      UpdateResourceServerRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(name)(_.name(_))
        .ifSome(scopes)(_.scopes(_))
        .build

    def updateResourceServerResponse(
      resourceServer: Option[ResourceServerType] = None
    ): UpdateResourceServerResponse =
      UpdateResourceServerResponse
        .builder
        .ifSome(resourceServer)(_.resourceServer(_))
        .build

    def updateUserAttributesRequest(
      userAttributes: Option[List[AttributeType]] = None,
      accessToken: Option[String] = None,
      clientMetadata: Option[ClientMetadataType] = None
    ): UpdateUserAttributesRequest =
      UpdateUserAttributesRequest
        .builder
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(clientMetadata)(_.clientMetadata(_))
        .build

    def updateUserAttributesResponse(
      codeDeliveryDetailsList: Option[List[CodeDeliveryDetailsType]] = None
    ): UpdateUserAttributesResponse =
      UpdateUserAttributesResponse
        .builder
        .ifSome(codeDeliveryDetailsList)(_.codeDeliveryDetailsList(_))
        .build

    def updateUserPoolClientRequest(
      userPoolId: Option[String] = None,
      clientId: Option[String] = None,
      clientName: Option[String] = None,
      refreshTokenValidity: Option[Int] = None,
      accessTokenValidity: Option[Int] = None,
      idTokenValidity: Option[Int] = None,
      tokenValidityUnits: Option[TokenValidityUnitsType] = None,
      readAttributes: Option[List[ClientPermissionType]] = None,
      writeAttributes: Option[List[ClientPermissionType]] = None,
      explicitAuthFlows: Option[List[ExplicitAuthFlowsType]] = None,
      supportedIdentityProviders: Option[List[ProviderNameType]] = None,
      callbackURLs: Option[List[RedirectUrlType]] = None,
      logoutURLs: Option[List[RedirectUrlType]] = None,
      defaultRedirectURI: Option[String] = None,
      allowedOAuthFlows: Option[List[OAuthFlowType]] = None,
      allowedOAuthScopes: Option[List[ScopeType]] = None,
      allowedOAuthFlowsUserPoolClient: Option[Boolean] = None,
      analyticsConfiguration: Option[AnalyticsConfigurationType] = None,
      preventUserExistenceErrors: Option[String] = None,
      enableTokenRevocation: Option[Boolean] = None
    ): UpdateUserPoolClientRequest =
      UpdateUserPoolClientRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientName)(_.clientName(_))
        .ifSome(refreshTokenValidity)(_.refreshTokenValidity(_))
        .ifSome(accessTokenValidity)(_.accessTokenValidity(_))
        .ifSome(idTokenValidity)(_.idTokenValidity(_))
        .ifSome(tokenValidityUnits)(_.tokenValidityUnits(_))
        .ifSome(readAttributes)(_.readAttributes(_))
        .ifSome(writeAttributes)(_.writeAttributes(_))
        .ifSome(explicitAuthFlows)(_.explicitAuthFlows(_))
        .ifSome(supportedIdentityProviders)(_.supportedIdentityProviders(_))
        .ifSome(callbackURLs)(_.callbackURLs(_))
        .ifSome(logoutURLs)(_.logoutURLs(_))
        .ifSome(defaultRedirectURI)(_.defaultRedirectURI(_))
        .ifSome(allowedOAuthFlows)(_.allowedOAuthFlows(_))
        .ifSome(allowedOAuthScopes)(_.allowedOAuthScopes(_))
        .ifSome(allowedOAuthFlowsUserPoolClient)(_.allowedOAuthFlowsUserPoolClient(_))
        .ifSome(analyticsConfiguration)(_.analyticsConfiguration(_))
        .ifSome(preventUserExistenceErrors)(_.preventUserExistenceErrors(_))
        .ifSome(enableTokenRevocation)(_.enableTokenRevocation(_))
        .build

    def updateUserPoolClientResponse(
      userPoolClient: Option[UserPoolClientType] = None
    ): UpdateUserPoolClientResponse =
      UpdateUserPoolClientResponse
        .builder
        .ifSome(userPoolClient)(_.userPoolClient(_))
        .build

    def updateUserPoolDomainRequest(
      domain: Option[String] = None,
      userPoolId: Option[String] = None,
      customDomainConfig: Option[CustomDomainConfigType] = None
    ): UpdateUserPoolDomainRequest =
      UpdateUserPoolDomainRequest
        .builder
        .ifSome(domain)(_.domain(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(customDomainConfig)(_.customDomainConfig(_))
        .build

    def updateUserPoolDomainResponse(
      cloudFrontDomain: Option[String] = None
    ): UpdateUserPoolDomainResponse =
      UpdateUserPoolDomainResponse
        .builder
        .ifSome(cloudFrontDomain)(_.cloudFrontDomain(_))
        .build

    def updateUserPoolRequest(
      userPoolId: Option[String] = None,
      policies: Option[UserPoolPolicyType] = None,
      lambdaConfig: Option[LambdaConfigType] = None,
      autoVerifiedAttributes: Option[List[VerifiedAttributeType]] = None,
      smsVerificationMessage: Option[String] = None,
      emailVerificationMessage: Option[String] = None,
      emailVerificationSubject: Option[String] = None,
      verificationMessageTemplate: Option[VerificationMessageTemplateType] = None,
      smsAuthenticationMessage: Option[String] = None,
      mfaConfiguration: Option[String] = None,
      deviceConfiguration: Option[DeviceConfigurationType] = None,
      emailConfiguration: Option[EmailConfigurationType] = None,
      smsConfiguration: Option[SmsConfigurationType] = None,
      userPoolTags: Option[UserPoolTagsType] = None,
      adminCreateUserConfig: Option[AdminCreateUserConfigType] = None,
      userPoolAddOns: Option[UserPoolAddOnsType] = None,
      accountRecoverySetting: Option[AccountRecoverySettingType] = None
    ): UpdateUserPoolRequest =
      UpdateUserPoolRequest
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(autoVerifiedAttributes)(_.autoVerifiedAttributes(_))
        .ifSome(smsVerificationMessage)(_.smsVerificationMessage(_))
        .ifSome(emailVerificationMessage)(_.emailVerificationMessage(_))
        .ifSome(emailVerificationSubject)(_.emailVerificationSubject(_))
        .ifSome(verificationMessageTemplate)(_.verificationMessageTemplate(_))
        .ifSome(smsAuthenticationMessage)(_.smsAuthenticationMessage(_))
        .ifSome(mfaConfiguration)(_.mfaConfiguration(_))
        .ifSome(deviceConfiguration)(_.deviceConfiguration(_))
        .ifSome(emailConfiguration)(_.emailConfiguration(_))
        .ifSome(smsConfiguration)(_.smsConfiguration(_))
        .ifSome(userPoolTags)(_.userPoolTags(_))
        .ifSome(adminCreateUserConfig)(_.adminCreateUserConfig(_))
        .ifSome(userPoolAddOns)(_.userPoolAddOns(_))
        .ifSome(accountRecoverySetting)(_.accountRecoverySetting(_))
        .build

    def updateUserPoolResponse(

    ): UpdateUserPoolResponse =
      UpdateUserPoolResponse
        .builder

        .build

    def userContextDataType(
      encodedData: Option[String] = None
    ): UserContextDataType =
      UserContextDataType
        .builder
        .ifSome(encodedData)(_.encodedData(_))
        .build

    def userImportInProgressException(
      message: Option[String] = None
    ): UserImportInProgressException =
      UserImportInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userImportJobType(
      jobName: Option[String] = None,
      jobId: Option[String] = None,
      userPoolId: Option[String] = None,
      preSignedUrl: Option[String] = None,
      creationDate: Option[DateType] = None,
      startDate: Option[DateType] = None,
      completionDate: Option[DateType] = None,
      status: Option[String] = None,
      cloudWatchLogsRoleArn: Option[String] = None,
      importedUsers: Option[LongType] = None,
      skippedUsers: Option[LongType] = None,
      failedUsers: Option[LongType] = None,
      completionMessage: Option[String] = None
    ): UserImportJobType =
      UserImportJobType
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(cloudWatchLogsRoleArn)(_.cloudWatchLogsRoleArn(_))
        .ifSome(importedUsers)(_.importedUsers(_))
        .ifSome(skippedUsers)(_.skippedUsers(_))
        .ifSome(failedUsers)(_.failedUsers(_))
        .ifSome(completionMessage)(_.completionMessage(_))
        .build

    def userLambdaValidationException(
      message: Option[String] = None
    ): UserLambdaValidationException =
      UserLambdaValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userNotConfirmedException(
      message: Option[String] = None
    ): UserNotConfirmedException =
      UserNotConfirmedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userNotFoundException(
      message: Option[String] = None
    ): UserNotFoundException =
      UserNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userPoolAddOnNotEnabledException(
      message: Option[String] = None
    ): UserPoolAddOnNotEnabledException =
      UserPoolAddOnNotEnabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userPoolAddOnsType(
      advancedSecurityMode: Option[String] = None
    ): UserPoolAddOnsType =
      UserPoolAddOnsType
        .builder
        .ifSome(advancedSecurityMode)(_.advancedSecurityMode(_))
        .build

    def userPoolClientDescription(
      clientId: Option[String] = None,
      userPoolId: Option[String] = None,
      clientName: Option[String] = None
    ): UserPoolClientDescription =
      UserPoolClientDescription
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientName)(_.clientName(_))
        .build

    def userPoolClientType(
      userPoolId: Option[String] = None,
      clientName: Option[String] = None,
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None,
      refreshTokenValidity: Option[Int] = None,
      accessTokenValidity: Option[Int] = None,
      idTokenValidity: Option[Int] = None,
      tokenValidityUnits: Option[TokenValidityUnitsType] = None,
      readAttributes: Option[List[ClientPermissionType]] = None,
      writeAttributes: Option[List[ClientPermissionType]] = None,
      explicitAuthFlows: Option[List[ExplicitAuthFlowsType]] = None,
      supportedIdentityProviders: Option[List[ProviderNameType]] = None,
      callbackURLs: Option[List[RedirectUrlType]] = None,
      logoutURLs: Option[List[RedirectUrlType]] = None,
      defaultRedirectURI: Option[String] = None,
      allowedOAuthFlows: Option[List[OAuthFlowType]] = None,
      allowedOAuthScopes: Option[List[ScopeType]] = None,
      allowedOAuthFlowsUserPoolClient: Option[Boolean] = None,
      analyticsConfiguration: Option[AnalyticsConfigurationType] = None,
      preventUserExistenceErrors: Option[String] = None,
      enableTokenRevocation: Option[Boolean] = None
    ): UserPoolClientType =
      UserPoolClientType
        .builder
        .ifSome(userPoolId)(_.userPoolId(_))
        .ifSome(clientName)(_.clientName(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(refreshTokenValidity)(_.refreshTokenValidity(_))
        .ifSome(accessTokenValidity)(_.accessTokenValidity(_))
        .ifSome(idTokenValidity)(_.idTokenValidity(_))
        .ifSome(tokenValidityUnits)(_.tokenValidityUnits(_))
        .ifSome(readAttributes)(_.readAttributes(_))
        .ifSome(writeAttributes)(_.writeAttributes(_))
        .ifSome(explicitAuthFlows)(_.explicitAuthFlows(_))
        .ifSome(supportedIdentityProviders)(_.supportedIdentityProviders(_))
        .ifSome(callbackURLs)(_.callbackURLs(_))
        .ifSome(logoutURLs)(_.logoutURLs(_))
        .ifSome(defaultRedirectURI)(_.defaultRedirectURI(_))
        .ifSome(allowedOAuthFlows)(_.allowedOAuthFlows(_))
        .ifSome(allowedOAuthScopes)(_.allowedOAuthScopes(_))
        .ifSome(allowedOAuthFlowsUserPoolClient)(_.allowedOAuthFlowsUserPoolClient(_))
        .ifSome(analyticsConfiguration)(_.analyticsConfiguration(_))
        .ifSome(preventUserExistenceErrors)(_.preventUserExistenceErrors(_))
        .ifSome(enableTokenRevocation)(_.enableTokenRevocation(_))
        .build

    def userPoolDescriptionType(
      id: Option[String] = None,
      name: Option[String] = None,
      lambdaConfig: Option[LambdaConfigType] = None,
      status: Option[String] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None
    ): UserPoolDescriptionType =
      UserPoolDescriptionType
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def userPoolPolicyType(
      passwordPolicy: Option[PasswordPolicyType] = None
    ): UserPoolPolicyType =
      UserPoolPolicyType
        .builder
        .ifSome(passwordPolicy)(_.passwordPolicy(_))
        .build

    def userPoolTaggingException(
      message: Option[String] = None
    ): UserPoolTaggingException =
      UserPoolTaggingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def userPoolType(
      id: Option[String] = None,
      name: Option[String] = None,
      policies: Option[UserPoolPolicyType] = None,
      lambdaConfig: Option[LambdaConfigType] = None,
      status: Option[String] = None,
      lastModifiedDate: Option[DateType] = None,
      creationDate: Option[DateType] = None,
      schemaAttributes: Option[List[SchemaAttributeType]] = None,
      autoVerifiedAttributes: Option[List[VerifiedAttributeType]] = None,
      aliasAttributes: Option[List[AliasAttributeType]] = None,
      usernameAttributes: Option[List[UsernameAttributeType]] = None,
      smsVerificationMessage: Option[String] = None,
      emailVerificationMessage: Option[String] = None,
      emailVerificationSubject: Option[String] = None,
      verificationMessageTemplate: Option[VerificationMessageTemplateType] = None,
      smsAuthenticationMessage: Option[String] = None,
      mfaConfiguration: Option[String] = None,
      deviceConfiguration: Option[DeviceConfigurationType] = None,
      estimatedNumberOfUsers: Option[Int] = None,
      emailConfiguration: Option[EmailConfigurationType] = None,
      smsConfiguration: Option[SmsConfigurationType] = None,
      userPoolTags: Option[UserPoolTagsType] = None,
      smsConfigurationFailure: Option[String] = None,
      emailConfigurationFailure: Option[String] = None,
      domain: Option[String] = None,
      customDomain: Option[String] = None,
      adminCreateUserConfig: Option[AdminCreateUserConfigType] = None,
      userPoolAddOns: Option[UserPoolAddOnsType] = None,
      usernameConfiguration: Option[UsernameConfigurationType] = None,
      arn: Option[String] = None,
      accountRecoverySetting: Option[AccountRecoverySettingType] = None
    ): UserPoolType =
      UserPoolType
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(lambdaConfig)(_.lambdaConfig(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(schemaAttributes)(_.schemaAttributes(_))
        .ifSome(autoVerifiedAttributes)(_.autoVerifiedAttributes(_))
        .ifSome(aliasAttributes)(_.aliasAttributes(_))
        .ifSome(usernameAttributes)(_.usernameAttributes(_))
        .ifSome(smsVerificationMessage)(_.smsVerificationMessage(_))
        .ifSome(emailVerificationMessage)(_.emailVerificationMessage(_))
        .ifSome(emailVerificationSubject)(_.emailVerificationSubject(_))
        .ifSome(verificationMessageTemplate)(_.verificationMessageTemplate(_))
        .ifSome(smsAuthenticationMessage)(_.smsAuthenticationMessage(_))
        .ifSome(mfaConfiguration)(_.mfaConfiguration(_))
        .ifSome(deviceConfiguration)(_.deviceConfiguration(_))
        .ifSome(estimatedNumberOfUsers)(_.estimatedNumberOfUsers(_))
        .ifSome(emailConfiguration)(_.emailConfiguration(_))
        .ifSome(smsConfiguration)(_.smsConfiguration(_))
        .ifSome(userPoolTags)(_.userPoolTags(_))
        .ifSome(smsConfigurationFailure)(_.smsConfigurationFailure(_))
        .ifSome(emailConfigurationFailure)(_.emailConfigurationFailure(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(customDomain)(_.customDomain(_))
        .ifSome(adminCreateUserConfig)(_.adminCreateUserConfig(_))
        .ifSome(userPoolAddOns)(_.userPoolAddOns(_))
        .ifSome(usernameConfiguration)(_.usernameConfiguration(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(accountRecoverySetting)(_.accountRecoverySetting(_))
        .build

    def userType(
      username: Option[String] = None,
      attributes: Option[List[AttributeType]] = None,
      userCreateDate: Option[DateType] = None,
      userLastModifiedDate: Option[DateType] = None,
      enabled: Option[Boolean] = None,
      userStatus: Option[String] = None,
      mFAOptions: Option[List[MFAOptionType]] = None
    ): UserType =
      UserType
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(userCreateDate)(_.userCreateDate(_))
        .ifSome(userLastModifiedDate)(_.userLastModifiedDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(userStatus)(_.userStatus(_))
        .ifSome(mFAOptions)(_.mFAOptions(_))
        .build

    def usernameConfigurationType(
      caseSensitive: Option[Boolean] = None
    ): UsernameConfigurationType =
      UsernameConfigurationType
        .builder
        .ifSome(caseSensitive)(_.caseSensitive(_))
        .build

    def usernameExistsException(
      message: Option[String] = None
    ): UsernameExistsException =
      UsernameExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def verificationMessageTemplateType(
      smsMessage: Option[String] = None,
      emailMessage: Option[String] = None,
      emailSubject: Option[String] = None,
      emailMessageByLink: Option[String] = None,
      emailSubjectByLink: Option[String] = None,
      defaultEmailOption: Option[String] = None
    ): VerificationMessageTemplateType =
      VerificationMessageTemplateType
        .builder
        .ifSome(smsMessage)(_.smsMessage(_))
        .ifSome(emailMessage)(_.emailMessage(_))
        .ifSome(emailSubject)(_.emailSubject(_))
        .ifSome(emailMessageByLink)(_.emailMessageByLink(_))
        .ifSome(emailSubjectByLink)(_.emailSubjectByLink(_))
        .ifSome(defaultEmailOption)(_.defaultEmailOption(_))
        .build

    def verifySoftwareTokenRequest(
      accessToken: Option[String] = None,
      session: Option[String] = None,
      userCode: Option[String] = None,
      friendlyDeviceName: Option[String] = None
    ): VerifySoftwareTokenRequest =
      VerifySoftwareTokenRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(session)(_.session(_))
        .ifSome(userCode)(_.userCode(_))
        .ifSome(friendlyDeviceName)(_.friendlyDeviceName(_))
        .build

    def verifySoftwareTokenResponse(
      status: Option[String] = None,
      session: Option[String] = None
    ): VerifySoftwareTokenResponse =
      VerifySoftwareTokenResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(session)(_.session(_))
        .build

    def verifyUserAttributeRequest(
      accessToken: Option[String] = None,
      attributeName: Option[String] = None,
      code: Option[String] = None
    ): VerifyUserAttributeRequest =
      VerifyUserAttributeRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(code)(_.code(_))
        .build

    def verifyUserAttributeResponse(

    ): VerifyUserAttributeResponse =
      VerifyUserAttributeResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
