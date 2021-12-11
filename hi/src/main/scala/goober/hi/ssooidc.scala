package goober.hi

import goober.free.ssooidc.SsoOidcIO
import software.amazon.awssdk.services.ssooidc.model._


object ssooidc {
  import goober.free.{ssooidc ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def authorizationPendingException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): AuthorizationPendingException =
      AuthorizationPendingException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def createTokenRequest(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      grantType: Option[String] = None,
      deviceCode: Option[String] = None,
      code: Option[String] = None,
      refreshToken: Option[String] = None,
      scope: Option[List[Scope]] = None,
      redirectUri: Option[String] = None
    ): CreateTokenRequest =
      CreateTokenRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(grantType)(_.grantType(_))
        .ifSome(deviceCode)(_.deviceCode(_))
        .ifSome(code)(_.code(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(redirectUri)(_.redirectUri(_))
        .build

    def createTokenResponse(
      accessToken: Option[String] = None,
      tokenType: Option[String] = None,
      expiresIn: Option[Int] = None,
      refreshToken: Option[String] = None,
      idToken: Option[String] = None
    ): CreateTokenResponse =
      CreateTokenResponse
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(tokenType)(_.tokenType(_))
        .ifSome(expiresIn)(_.expiresIn(_))
        .ifSome(refreshToken)(_.refreshToken(_))
        .ifSome(idToken)(_.idToken(_))
        .build

    def expiredTokenException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): ExpiredTokenException =
      ExpiredTokenException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def internalServerException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def invalidClientException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): InvalidClientException =
      InvalidClientException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def invalidClientMetadataException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): InvalidClientMetadataException =
      InvalidClientMetadataException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def invalidGrantException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): InvalidGrantException =
      InvalidGrantException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def invalidRequestException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def invalidScopeException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): InvalidScopeException =
      InvalidScopeException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def registerClientRequest(
      clientName: Option[String] = None,
      clientType: Option[String] = None,
      scopes: Option[List[Scope]] = None
    ): RegisterClientRequest =
      RegisterClientRequest
        .builder
        .ifSome(clientName)(_.clientName(_))
        .ifSome(clientType)(_.clientType(_))
        .ifSome(scopes)(_.scopes(_))
        .build

    def registerClientResponse(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      clientIdIssuedAt: Option[LongTimeStampType] = None,
      clientSecretExpiresAt: Option[LongTimeStampType] = None,
      authorizationEndpoint: Option[String] = None,
      tokenEndpoint: Option[String] = None
    ): RegisterClientResponse =
      RegisterClientResponse
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(clientIdIssuedAt)(_.clientIdIssuedAt(_))
        .ifSome(clientSecretExpiresAt)(_.clientSecretExpiresAt(_))
        .ifSome(authorizationEndpoint)(_.authorizationEndpoint(_))
        .ifSome(tokenEndpoint)(_.tokenEndpoint(_))
        .build

    def slowDownException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): SlowDownException =
      SlowDownException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def startDeviceAuthorizationRequest(
      clientId: Option[String] = None,
      clientSecret: Option[String] = None,
      startUrl: Option[String] = None
    ): StartDeviceAuthorizationRequest =
      StartDeviceAuthorizationRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(clientSecret)(_.clientSecret(_))
        .ifSome(startUrl)(_.startUrl(_))
        .build

    def startDeviceAuthorizationResponse(
      deviceCode: Option[String] = None,
      userCode: Option[String] = None,
      verificationUri: Option[String] = None,
      verificationUriComplete: Option[String] = None,
      expiresIn: Option[Int] = None,
      interval: Option[Int] = None
    ): StartDeviceAuthorizationResponse =
      StartDeviceAuthorizationResponse
        .builder
        .ifSome(deviceCode)(_.deviceCode(_))
        .ifSome(userCode)(_.userCode(_))
        .ifSome(verificationUri)(_.verificationUri(_))
        .ifSome(verificationUriComplete)(_.verificationUriComplete(_))
        .ifSome(expiresIn)(_.expiresIn(_))
        .ifSome(interval)(_.interval(_))
        .build

    def unauthorizedClientException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): UnauthorizedClientException =
      UnauthorizedClientException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

    def unsupportedGrantTypeException(
      error: Option[String] = None,
      error_description: Option[String] = None
    ): UnsupportedGrantTypeException =
      UnsupportedGrantTypeException
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(error_description)(_.error_description(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
