package goober.hi

import goober.free.sso.SsoIO
import software.amazon.awssdk.services.sso.model._


object sso {
  import goober.free.{sso ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountInfo(
      accountId: Option[String] = None,
      accountName: Option[String] = None,
      emailAddress: Option[String] = None
    ): AccountInfo =
      AccountInfo
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(accountName)(_.accountName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def getRoleCredentialsRequest(
      roleName: Option[String] = None,
      accountId: Option[String] = None,
      accessToken: Option[String] = None
    ): GetRoleCredentialsRequest =
      GetRoleCredentialsRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def getRoleCredentialsResponse(
      roleCredentials: Option[RoleCredentials] = None
    ): GetRoleCredentialsResponse =
      GetRoleCredentialsResponse
        .builder
        .ifSome(roleCredentials)(_.roleCredentials(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAccountRolesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      accessToken: Option[String] = None,
      accountId: Option[String] = None
    ): ListAccountRolesRequest =
      ListAccountRolesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def listAccountRolesResponse(
      nextToken: Option[String] = None,
      roleList: Option[List[RoleInfo]] = None
    ): ListAccountRolesResponse =
      ListAccountRolesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(roleList)(_.roleList(_))
        .build

    def listAccountsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      accessToken: Option[String] = None
    ): ListAccountsRequest =
      ListAccountsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def listAccountsResponse(
      nextToken: Option[String] = None,
      accountList: Option[List[AccountInfo]] = None
    ): ListAccountsResponse =
      ListAccountsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(accountList)(_.accountList(_))
        .build

    def logoutRequest(
      accessToken: Option[String] = None
    ): LogoutRequest =
      LogoutRequest
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def roleCredentials(
      accessKeyId: Option[String] = None,
      secretAccessKey: Option[String] = None,
      sessionToken: Option[String] = None,
      expiration: Option[ExpirationTimestampType] = None
    ): RoleCredentials =
      RoleCredentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(sessionToken)(_.sessionToken(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def roleInfo(
      roleName: Option[String] = None,
      accountId: Option[String] = None
    ): RoleInfo =
      RoleInfo
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
