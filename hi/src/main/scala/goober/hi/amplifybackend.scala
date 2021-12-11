package goober.hi

import goober.free.amplifybackend.AmplifyBackendIO
import software.amazon.awssdk.services.amplifybackend.model._


object amplifybackend {
  import goober.free.{amplifybackend ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def backendAPIAppSyncAuthSettings(
      cognitoUserPoolId: Option[String] = None,
      description: Option[String] = None,
      expirationTime: Option[__double] = None,
      openIDAuthTTL: Option[String] = None,
      openIDClientId: Option[String] = None,
      openIDIatTTL: Option[String] = None,
      openIDIssueURL: Option[String] = None,
      openIDProviderName: Option[String] = None
    ): BackendAPIAppSyncAuthSettings =
      BackendAPIAppSyncAuthSettings
        .builder
        .ifSome(cognitoUserPoolId)(_.cognitoUserPoolId(_))
        .ifSome(description)(_.description(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(openIDAuthTTL)(_.openIDAuthTTL(_))
        .ifSome(openIDClientId)(_.openIDClientId(_))
        .ifSome(openIDIatTTL)(_.openIDIatTTL(_))
        .ifSome(openIDIssueURL)(_.openIDIssueURL(_))
        .ifSome(openIDProviderName)(_.openIDProviderName(_))
        .build

    def backendAPIAuthType(
      mode: Option[String] = None,
      settings: Option[BackendAPIAppSyncAuthSettings] = None
    ): BackendAPIAuthType =
      BackendAPIAuthType
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(settings)(_.settings(_))
        .build

    def backendAPICodegenReqObj(
      resourceName: Option[String] = None
    ): BackendAPICodegenReqObj =
      BackendAPICodegenReqObj
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def backendAPICodegenRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): BackendAPICodegenRespObj =
      BackendAPICodegenRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def backendAPIConflictResolution(
      resolutionStrategy: Option[String] = None
    ): BackendAPIConflictResolution =
      BackendAPIConflictResolution
        .builder
        .ifSome(resolutionStrategy)(_.resolutionStrategy(_))
        .build

    def backendAPIReqObj(
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): BackendAPIReqObj =
      BackendAPIReqObj
        .builder
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def backendAPIResourceConfig(
      additionalAuthTypes: Option[List[BackendAPIAuthType]] = None,
      apiName: Option[String] = None,
      conflictResolution: Option[BackendAPIConflictResolution] = None,
      defaultAuthType: Option[BackendAPIAuthType] = None,
      service: Option[String] = None,
      transformSchema: Option[String] = None
    ): BackendAPIResourceConfig =
      BackendAPIResourceConfig
        .builder
        .ifSome(additionalAuthTypes)(_.additionalAuthTypes(_))
        .ifSome(apiName)(_.apiName(_))
        .ifSome(conflictResolution)(_.conflictResolution(_))
        .ifSome(defaultAuthType)(_.defaultAuthType(_))
        .ifSome(service)(_.service(_))
        .ifSome(transformSchema)(_.transformSchema(_))
        .build

    def backendAPIRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): BackendAPIRespObj =
      BackendAPIRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def backendAuthRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): BackendAuthRespObj =
      BackendAuthRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def backendAuthSocialProviderConfig(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None
    ): BackendAuthSocialProviderConfig =
      BackendAuthSocialProviderConfig
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .build

    def backendConfigRespObj(
      appId: Option[String] = None,
      backendManagerAppId: Option[String] = None,
      error: Option[String] = None,
      loginAuthConfig: Option[LoginAuthConfigReqObj] = None
    ): BackendConfigRespObj =
      BackendConfigRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendManagerAppId)(_.backendManagerAppId(_))
        .ifSome(error)(_.error(_))
        .ifSome(loginAuthConfig)(_.loginAuthConfig(_))
        .build

    def backendJobReqObj(
      operation: Option[String] = None,
      status: Option[String] = None
    ): BackendJobReqObj =
      BackendJobReqObj
        .builder
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def backendJobRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      createTime: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None,
      updateTime: Option[String] = None
    ): BackendJobRespObj =
      BackendJobRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloneBackendReqObj(
      targetEnvironmentName: Option[String] = None
    ): CloneBackendReqObj =
      CloneBackendReqObj
        .builder
        .ifSome(targetEnvironmentName)(_.targetEnvironmentName(_))
        .build

    def cloneBackendRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      targetEnvironmentName: Option[String] = None
    ): CloneBackendRequest =
      CloneBackendRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(targetEnvironmentName)(_.targetEnvironmentName(_))
        .build

    def cloneBackendRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): CloneBackendRespObj =
      CloneBackendRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def cloneBackendResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): CloneBackendResponse =
      CloneBackendResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def createBackendAPIReqObj(
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): CreateBackendAPIReqObj =
      CreateBackendAPIReqObj
        .builder
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def createBackendAPIRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): CreateBackendAPIRequest =
      CreateBackendAPIRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def createBackendAPIResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): CreateBackendAPIResponse =
      CreateBackendAPIResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def createBackendAuthForgotPasswordConfig(
      deliveryMethod: Option[String] = None,
      emailSettings: Option[EmailSettings] = None,
      smsSettings: Option[SmsSettings] = None
    ): CreateBackendAuthForgotPasswordConfig =
      CreateBackendAuthForgotPasswordConfig
        .builder
        .ifSome(deliveryMethod)(_.deliveryMethod(_))
        .ifSome(emailSettings)(_.emailSettings(_))
        .ifSome(smsSettings)(_.smsSettings(_))
        .build

    def createBackendAuthIdentityPoolConfig(
      identityPoolName: Option[String] = None,
      unauthenticatedLogin: Option[Boolean] = None
    ): CreateBackendAuthIdentityPoolConfig =
      CreateBackendAuthIdentityPoolConfig
        .builder
        .ifSome(identityPoolName)(_.identityPoolName(_))
        .ifSome(unauthenticatedLogin)(_.unauthenticatedLogin(_))
        .build

    def createBackendAuthMFAConfig(
      mFAMode: Option[String] = None,
      settings: Option[Settings] = None
    ): CreateBackendAuthMFAConfig =
      CreateBackendAuthMFAConfig
        .builder
        .ifSome(mFAMode)(_.mFAMode(_))
        .ifSome(settings)(_.settings(_))
        .build

    def createBackendAuthOAuthConfig(
      domainPrefix: Option[String] = None,
      oAuthGrantType: Option[String] = None,
      oAuthScopes: Option[List[OAuthScopesElement]] = None,
      redirectSignInURIs: Option[List[__string]] = None,
      redirectSignOutURIs: Option[List[__string]] = None,
      socialProviderSettings: Option[SocialProviderSettings] = None
    ): CreateBackendAuthOAuthConfig =
      CreateBackendAuthOAuthConfig
        .builder
        .ifSome(domainPrefix)(_.domainPrefix(_))
        .ifSome(oAuthGrantType)(_.oAuthGrantType(_))
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .ifSome(redirectSignInURIs)(_.redirectSignInURIs(_))
        .ifSome(redirectSignOutURIs)(_.redirectSignOutURIs(_))
        .ifSome(socialProviderSettings)(_.socialProviderSettings(_))
        .build

    def createBackendAuthPasswordPolicyConfig(
      additionalConstraints: Option[List[AdditionalConstraintsElement]] = None,
      minimumLength: Option[__double] = None
    ): CreateBackendAuthPasswordPolicyConfig =
      CreateBackendAuthPasswordPolicyConfig
        .builder
        .ifSome(additionalConstraints)(_.additionalConstraints(_))
        .ifSome(minimumLength)(_.minimumLength(_))
        .build

    def createBackendAuthReqObj(
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[CreateBackendAuthResourceConfig] = None,
      resourceName: Option[String] = None
    ): CreateBackendAuthReqObj =
      CreateBackendAuthReqObj
        .builder
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def createBackendAuthRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[CreateBackendAuthResourceConfig] = None,
      resourceName: Option[String] = None
    ): CreateBackendAuthRequest =
      CreateBackendAuthRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def createBackendAuthResourceConfig(
      authResources: Option[String] = None,
      identityPoolConfigs: Option[CreateBackendAuthIdentityPoolConfig] = None,
      service: Option[String] = None,
      userPoolConfigs: Option[CreateBackendAuthUserPoolConfig] = None
    ): CreateBackendAuthResourceConfig =
      CreateBackendAuthResourceConfig
        .builder
        .ifSome(authResources)(_.authResources(_))
        .ifSome(identityPoolConfigs)(_.identityPoolConfigs(_))
        .ifSome(service)(_.service(_))
        .ifSome(userPoolConfigs)(_.userPoolConfigs(_))
        .build

    def createBackendAuthResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): CreateBackendAuthResponse =
      CreateBackendAuthResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def createBackendAuthUserPoolConfig(
      forgotPassword: Option[CreateBackendAuthForgotPasswordConfig] = None,
      mfa: Option[CreateBackendAuthMFAConfig] = None,
      oAuth: Option[CreateBackendAuthOAuthConfig] = None,
      passwordPolicy: Option[CreateBackendAuthPasswordPolicyConfig] = None,
      requiredSignUpAttributes: Option[List[RequiredSignUpAttributesElement]] = None,
      signInMethod: Option[String] = None,
      userPoolName: Option[String] = None
    ): CreateBackendAuthUserPoolConfig =
      CreateBackendAuthUserPoolConfig
        .builder
        .ifSome(forgotPassword)(_.forgotPassword(_))
        .ifSome(mfa)(_.mfa(_))
        .ifSome(oAuth)(_.oAuth(_))
        .ifSome(passwordPolicy)(_.passwordPolicy(_))
        .ifSome(requiredSignUpAttributes)(_.requiredSignUpAttributes(_))
        .ifSome(signInMethod)(_.signInMethod(_))
        .ifSome(userPoolName)(_.userPoolName(_))
        .build

    def createBackendConfigReqObj(
      backendManagerAppId: Option[String] = None
    ): CreateBackendConfigReqObj =
      CreateBackendConfigReqObj
        .builder
        .ifSome(backendManagerAppId)(_.backendManagerAppId(_))
        .build

    def createBackendConfigRequest(
      appId: Option[String] = None,
      backendManagerAppId: Option[String] = None
    ): CreateBackendConfigRequest =
      CreateBackendConfigRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendManagerAppId)(_.backendManagerAppId(_))
        .build

    def createBackendConfigRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      jobId: Option[String] = None,
      status: Option[String] = None
    ): CreateBackendConfigRespObj =
      CreateBackendConfigRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(status)(_.status(_))
        .build

    def createBackendConfigResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      jobId: Option[String] = None,
      status: Option[String] = None
    ): CreateBackendConfigResponse =
      CreateBackendConfigResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(status)(_.status(_))
        .build

    def createBackendReqObj(
      appId: Option[String] = None,
      appName: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[ResourceConfig] = None,
      resourceName: Option[String] = None
    ): CreateBackendReqObj =
      CreateBackendReqObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def createBackendRequest(
      appId: Option[String] = None,
      appName: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[ResourceConfig] = None,
      resourceName: Option[String] = None
    ): CreateBackendRequest =
      CreateBackendRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def createBackendRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): CreateBackendRespObj =
      CreateBackendRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def createBackendResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): CreateBackendResponse =
      CreateBackendResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def createTokenRequest(
      appId: Option[String] = None
    ): CreateTokenRequest =
      CreateTokenRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def createTokenRespObj(
      appId: Option[String] = None,
      challengeCode: Option[String] = None,
      sessionId: Option[String] = None,
      ttl: Option[String] = None
    ): CreateTokenRespObj =
      CreateTokenRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(challengeCode)(_.challengeCode(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(ttl)(_.ttl(_))
        .build

    def createTokenResponse(
      appId: Option[String] = None,
      challengeCode: Option[String] = None,
      sessionId: Option[String] = None,
      ttl: Option[String] = None
    ): CreateTokenResponse =
      CreateTokenResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(challengeCode)(_.challengeCode(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(ttl)(_.ttl(_))
        .build

    def deleteBackendAPIRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): DeleteBackendAPIRequest =
      DeleteBackendAPIRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def deleteBackendAPIResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): DeleteBackendAPIResponse =
      DeleteBackendAPIResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteBackendAuthRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceName: Option[String] = None
    ): DeleteBackendAuthRequest =
      DeleteBackendAuthRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def deleteBackendAuthResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): DeleteBackendAuthResponse =
      DeleteBackendAuthResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteBackendRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None
    ): DeleteBackendRequest =
      DeleteBackendRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .build

    def deleteBackendRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): DeleteBackendRespObj =
      DeleteBackendRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteBackendResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): DeleteBackendResponse =
      DeleteBackendResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteTokenRequest(
      appId: Option[String] = None,
      sessionId: Option[String] = None
    ): DeleteTokenRequest =
      DeleteTokenRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def deleteTokenRespObj(
      isSuccess: Option[Boolean] = None
    ): DeleteTokenRespObj =
      DeleteTokenRespObj
        .builder
        .ifSome(isSuccess)(_.isSuccess(_))
        .build

    def deleteTokenResponse(
      isSuccess: Option[Boolean] = None
    ): DeleteTokenResponse =
      DeleteTokenResponse
        .builder
        .ifSome(isSuccess)(_.isSuccess(_))
        .build

    def emailSettings(
      emailMessage: Option[String] = None,
      emailSubject: Option[String] = None
    ): EmailSettings =
      EmailSettings
        .builder
        .ifSome(emailMessage)(_.emailMessage(_))
        .ifSome(emailSubject)(_.emailSubject(_))
        .build

    def gatewayTimeoutException(
      message: Option[String] = None
    ): GatewayTimeoutException =
      GatewayTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def generateBackendAPIModelsRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceName: Option[String] = None
    ): GenerateBackendAPIModelsRequest =
      GenerateBackendAPIModelsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def generateBackendAPIModelsResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): GenerateBackendAPIModelsResponse =
      GenerateBackendAPIModelsResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def getBackendAPICodegenRespObj(
      models: Option[String] = None,
      status: Option[String] = None
    ): GetBackendAPICodegenRespObj =
      GetBackendAPICodegenRespObj
        .builder
        .ifSome(models)(_.models(_))
        .ifSome(status)(_.status(_))
        .build

    def getBackendAPIModelsRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceName: Option[String] = None
    ): GetBackendAPIModelsRequest =
      GetBackendAPIModelsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAPIModelsResponse(
      models: Option[String] = None,
      status: Option[String] = None
    ): GetBackendAPIModelsResponse =
      GetBackendAPIModelsResponse
        .builder
        .ifSome(models)(_.models(_))
        .ifSome(status)(_.status(_))
        .build

    def getBackendAPIRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): GetBackendAPIRequest =
      GetBackendAPIRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAPIRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): GetBackendAPIRespObj =
      GetBackendAPIRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAPIResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): GetBackendAPIResponse =
      GetBackendAPIResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAuthReqObj(
      resourceName: Option[String] = None
    ): GetBackendAuthReqObj =
      GetBackendAuthReqObj
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAuthRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceName: Option[String] = None
    ): GetBackendAuthRequest =
      GetBackendAuthRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAuthRespObj(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      resourceConfig: Option[CreateBackendAuthResourceConfig] = None,
      resourceName: Option[String] = None
    ): GetBackendAuthRespObj =
      GetBackendAuthRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendAuthResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      resourceConfig: Option[CreateBackendAuthResourceConfig] = None,
      resourceName: Option[String] = None
    ): GetBackendAuthResponse =
      GetBackendAuthResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def getBackendJobRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      jobId: Option[String] = None
    ): GetBackendJobRequest =
      GetBackendJobRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def getBackendJobResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      createTime: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None,
      updateTime: Option[String] = None
    ): GetBackendJobResponse =
      GetBackendJobResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def getBackendReqObj(
      backendEnvironmentName: Option[String] = None
    ): GetBackendReqObj =
      GetBackendReqObj
        .builder
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .build

    def getBackendRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None
    ): GetBackendRequest =
      GetBackendRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .build

    def getBackendRespObj(
      amplifyMetaConfig: Option[String] = None,
      appId: Option[String] = None,
      appName: Option[String] = None,
      backendEnvironmentList: Option[List[__string]] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None
    ): GetBackendRespObj =
      GetBackendRespObj
        .builder
        .ifSome(amplifyMetaConfig)(_.amplifyMetaConfig(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(backendEnvironmentList)(_.backendEnvironmentList(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .build

    def getBackendResponse(
      amplifyMetaConfig: Option[String] = None,
      appId: Option[String] = None,
      appName: Option[String] = None,
      backendEnvironmentList: Option[List[__string]] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None
    ): GetBackendResponse =
      GetBackendResponse
        .builder
        .ifSome(amplifyMetaConfig)(_.amplifyMetaConfig(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(appName)(_.appName(_))
        .ifSome(backendEnvironmentList)(_.backendEnvironmentList(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .build

    def getTokenRequest(
      appId: Option[String] = None,
      sessionId: Option[String] = None
    ): GetTokenRequest =
      GetTokenRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def getTokenRespObj(
      appId: Option[String] = None,
      challengeCode: Option[String] = None,
      sessionId: Option[String] = None,
      ttl: Option[String] = None
    ): GetTokenRespObj =
      GetTokenRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(challengeCode)(_.challengeCode(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(ttl)(_.ttl(_))
        .build

    def getTokenResponse(
      appId: Option[String] = None,
      challengeCode: Option[String] = None,
      sessionId: Option[String] = None,
      ttl: Option[String] = None
    ): GetTokenResponse =
      GetTokenResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(challengeCode)(_.challengeCode(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(ttl)(_.ttl(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      limitType: Option[String] = None,
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(limitType)(_.limitType(_))
        .ifSome(message)(_.message(_))
        .build

    def listBackendJobReqObj(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): ListBackendJobReqObj =
      ListBackendJobReqObj
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def listBackendJobRespObj(
      jobs: Option[List[BackendJobRespObj]] = None,
      nextToken: Option[String] = None
    ): ListBackendJobRespObj =
      ListBackendJobRespObj
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBackendJobsRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): ListBackendJobsRequest =
      ListBackendJobsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def listBackendJobsResponse(
      jobs: Option[List[BackendJobRespObj]] = None,
      nextToken: Option[String] = None
    ): ListBackendJobsResponse =
      ListBackendJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loginAuthConfigReqObj(
      awsCognitoIdentityPoolId: Option[String] = None,
      awsCognitoRegion: Option[String] = None,
      awsUserPoolsId: Option[String] = None,
      awsUserPoolsWebClientId: Option[String] = None
    ): LoginAuthConfigReqObj =
      LoginAuthConfigReqObj
        .builder
        .ifSome(awsCognitoIdentityPoolId)(_.awsCognitoIdentityPoolId(_))
        .ifSome(awsCognitoRegion)(_.awsCognitoRegion(_))
        .ifSome(awsUserPoolsId)(_.awsUserPoolsId(_))
        .ifSome(awsUserPoolsWebClientId)(_.awsUserPoolsWebClientId(_))
        .build

    def notFoundException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def removeAllBackendsReqObj(
      cleanAmplifyApp: Option[Boolean] = None
    ): RemoveAllBackendsReqObj =
      RemoveAllBackendsReqObj
        .builder
        .ifSome(cleanAmplifyApp)(_.cleanAmplifyApp(_))
        .build

    def removeAllBackendsRequest(
      appId: Option[String] = None,
      cleanAmplifyApp: Option[Boolean] = None
    ): RemoveAllBackendsRequest =
      RemoveAllBackendsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(cleanAmplifyApp)(_.cleanAmplifyApp(_))
        .build

    def removeAllBackendsRespObj(
      appId: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): RemoveAllBackendsRespObj =
      RemoveAllBackendsRespObj
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def removeAllBackendsResponse(
      appId: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): RemoveAllBackendsResponse =
      RemoveAllBackendsResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def removeBackendAuthReqObj(
      resourceName: Option[String] = None
    ): RemoveBackendAuthReqObj =
      RemoveBackendAuthReqObj
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def removeBackendConfigRequest(
      appId: Option[String] = None
    ): RemoveBackendConfigRequest =
      RemoveBackendConfigRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def removeBackendConfigRespObj(
      error: Option[String] = None
    ): RemoveBackendConfigRespObj =
      RemoveBackendConfigRespObj
        .builder
        .ifSome(error)(_.error(_))
        .build

    def removeBackendConfigResponse(
      error: Option[String] = None
    ): RemoveBackendConfigResponse =
      RemoveBackendConfigResponse
        .builder
        .ifSome(error)(_.error(_))
        .build

    def resourceConfig(

    ): ResourceConfig =
      ResourceConfig
        .builder

        .build

    def settings(
      mfaTypes: Option[List[MfaTypesElement]] = None,
      smsMessage: Option[String] = None
    ): Settings =
      Settings
        .builder
        .ifSome(mfaTypes)(_.mfaTypes(_))
        .ifSome(smsMessage)(_.smsMessage(_))
        .build

    def smsSettings(
      smsMessage: Option[String] = None
    ): SmsSettings =
      SmsSettings
        .builder
        .ifSome(smsMessage)(_.smsMessage(_))
        .build

    def socialProviderSettings(
      facebook: Option[BackendAuthSocialProviderConfig] = None,
      google: Option[BackendAuthSocialProviderConfig] = None,
      loginWithAmazon: Option[BackendAuthSocialProviderConfig] = None
    ): SocialProviderSettings =
      SocialProviderSettings
        .builder
        .ifSome(facebook)(_.facebook(_))
        .ifSome(google)(_.google(_))
        .ifSome(loginWithAmazon)(_.loginWithAmazon(_))
        .build

    def tooManyRequestsException(
      limitType: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(limitType)(_.limitType(_))
        .ifSome(message)(_.message(_))
        .build

    def updateBackendAPIRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[BackendAPIResourceConfig] = None,
      resourceName: Option[String] = None
    ): UpdateBackendAPIRequest =
      UpdateBackendAPIRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def updateBackendAPIResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): UpdateBackendAPIResponse =
      UpdateBackendAPIResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def updateBackendAuthForgotPasswordConfig(
      deliveryMethod: Option[String] = None,
      emailSettings: Option[EmailSettings] = None,
      smsSettings: Option[SmsSettings] = None
    ): UpdateBackendAuthForgotPasswordConfig =
      UpdateBackendAuthForgotPasswordConfig
        .builder
        .ifSome(deliveryMethod)(_.deliveryMethod(_))
        .ifSome(emailSettings)(_.emailSettings(_))
        .ifSome(smsSettings)(_.smsSettings(_))
        .build

    def updateBackendAuthIdentityPoolConfig(
      unauthenticatedLogin: Option[Boolean] = None
    ): UpdateBackendAuthIdentityPoolConfig =
      UpdateBackendAuthIdentityPoolConfig
        .builder
        .ifSome(unauthenticatedLogin)(_.unauthenticatedLogin(_))
        .build

    def updateBackendAuthMFAConfig(
      mFAMode: Option[String] = None,
      settings: Option[Settings] = None
    ): UpdateBackendAuthMFAConfig =
      UpdateBackendAuthMFAConfig
        .builder
        .ifSome(mFAMode)(_.mFAMode(_))
        .ifSome(settings)(_.settings(_))
        .build

    def updateBackendAuthOAuthConfig(
      domainPrefix: Option[String] = None,
      oAuthGrantType: Option[String] = None,
      oAuthScopes: Option[List[OAuthScopesElement]] = None,
      redirectSignInURIs: Option[List[__string]] = None,
      redirectSignOutURIs: Option[List[__string]] = None,
      socialProviderSettings: Option[SocialProviderSettings] = None
    ): UpdateBackendAuthOAuthConfig =
      UpdateBackendAuthOAuthConfig
        .builder
        .ifSome(domainPrefix)(_.domainPrefix(_))
        .ifSome(oAuthGrantType)(_.oAuthGrantType(_))
        .ifSome(oAuthScopes)(_.oAuthScopes(_))
        .ifSome(redirectSignInURIs)(_.redirectSignInURIs(_))
        .ifSome(redirectSignOutURIs)(_.redirectSignOutURIs(_))
        .ifSome(socialProviderSettings)(_.socialProviderSettings(_))
        .build

    def updateBackendAuthPasswordPolicyConfig(
      additionalConstraints: Option[List[AdditionalConstraintsElement]] = None,
      minimumLength: Option[__double] = None
    ): UpdateBackendAuthPasswordPolicyConfig =
      UpdateBackendAuthPasswordPolicyConfig
        .builder
        .ifSome(additionalConstraints)(_.additionalConstraints(_))
        .ifSome(minimumLength)(_.minimumLength(_))
        .build

    def updateBackendAuthReqObj(
      resourceConfig: Option[UpdateBackendAuthResourceConfig] = None,
      resourceName: Option[String] = None
    ): UpdateBackendAuthReqObj =
      UpdateBackendAuthReqObj
        .builder
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def updateBackendAuthRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      resourceConfig: Option[UpdateBackendAuthResourceConfig] = None,
      resourceName: Option[String] = None
    ): UpdateBackendAuthRequest =
      UpdateBackendAuthRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(resourceConfig)(_.resourceConfig(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def updateBackendAuthResourceConfig(
      authResources: Option[String] = None,
      identityPoolConfigs: Option[UpdateBackendAuthIdentityPoolConfig] = None,
      service: Option[String] = None,
      userPoolConfigs: Option[UpdateBackendAuthUserPoolConfig] = None
    ): UpdateBackendAuthResourceConfig =
      UpdateBackendAuthResourceConfig
        .builder
        .ifSome(authResources)(_.authResources(_))
        .ifSome(identityPoolConfigs)(_.identityPoolConfigs(_))
        .ifSome(service)(_.service(_))
        .ifSome(userPoolConfigs)(_.userPoolConfigs(_))
        .build

    def updateBackendAuthResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): UpdateBackendAuthResponse =
      UpdateBackendAuthResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def updateBackendAuthUserPoolConfig(
      forgotPassword: Option[UpdateBackendAuthForgotPasswordConfig] = None,
      mfa: Option[UpdateBackendAuthMFAConfig] = None,
      oAuth: Option[UpdateBackendAuthOAuthConfig] = None,
      passwordPolicy: Option[UpdateBackendAuthPasswordPolicyConfig] = None
    ): UpdateBackendAuthUserPoolConfig =
      UpdateBackendAuthUserPoolConfig
        .builder
        .ifSome(forgotPassword)(_.forgotPassword(_))
        .ifSome(mfa)(_.mfa(_))
        .ifSome(oAuth)(_.oAuth(_))
        .ifSome(passwordPolicy)(_.passwordPolicy(_))
        .build

    def updateBackendConfigReqObj(
      loginAuthConfig: Option[LoginAuthConfigReqObj] = None
    ): UpdateBackendConfigReqObj =
      UpdateBackendConfigReqObj
        .builder
        .ifSome(loginAuthConfig)(_.loginAuthConfig(_))
        .build

    def updateBackendConfigRequest(
      appId: Option[String] = None,
      loginAuthConfig: Option[LoginAuthConfigReqObj] = None
    ): UpdateBackendConfigRequest =
      UpdateBackendConfigRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(loginAuthConfig)(_.loginAuthConfig(_))
        .build

    def updateBackendConfigResponse(
      appId: Option[String] = None,
      backendManagerAppId: Option[String] = None,
      error: Option[String] = None,
      loginAuthConfig: Option[LoginAuthConfigReqObj] = None
    ): UpdateBackendConfigResponse =
      UpdateBackendConfigResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendManagerAppId)(_.backendManagerAppId(_))
        .ifSome(error)(_.error(_))
        .ifSome(loginAuthConfig)(_.loginAuthConfig(_))
        .build

    def updateBackendJobRequest(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None
    ): UpdateBackendJobRequest =
      UpdateBackendJobRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .build

    def updateBackendJobResponse(
      appId: Option[String] = None,
      backendEnvironmentName: Option[String] = None,
      createTime: Option[String] = None,
      error: Option[String] = None,
      jobId: Option[String] = None,
      operation: Option[String] = None,
      status: Option[String] = None,
      updateTime: Option[String] = None
    ): UpdateBackendJobResponse =
      UpdateBackendJobResponse
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(backendEnvironmentName)(_.backendEnvironmentName(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(error)(_.error(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
