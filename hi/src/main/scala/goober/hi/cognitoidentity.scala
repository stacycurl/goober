package goober.hi

import goober.free.cognitoidentity.CognitoIdentityIO
import software.amazon.awssdk.services.cognitoidentity.model._


object cognitoidentity {
  import goober.free.{cognitoidentity ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def cognitoIdentityProvider(
      providerName: Option[String] = None,
      clientId: Option[String] = None,
      serverSideTokenCheck: Option[Boolean] = None
    ): CognitoIdentityProvider =
      CognitoIdentityProvider
        .builder
        .ifSome(providerName)(_.providerName(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(serverSideTokenCheck)(_.serverSideTokenCheck(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createIdentityPoolInput(
      identityPoolName: Option[String] = None,
      allowUnauthenticatedIdentities: Option[Boolean] = None,
      allowClassicFlow: Option[Boolean] = None,
      supportedLoginProviders: Option[IdentityProviders] = None,
      developerProviderName: Option[String] = None,
      openIdConnectProviderARNs: Option[List[ARNString]] = None,
      cognitoIdentityProviders: Option[List[CognitoIdentityProvider]] = None,
      samlProviderARNs: Option[List[ARNString]] = None,
      identityPoolTags: Option[IdentityPoolTagsType] = None
    ): CreateIdentityPoolInput =
      CreateIdentityPoolInput
        .builder
        .ifSome(identityPoolName)(_.identityPoolName(_))
        .ifSome(allowUnauthenticatedIdentities)(_.allowUnauthenticatedIdentities(_))
        .ifSome(allowClassicFlow)(_.allowClassicFlow(_))
        .ifSome(supportedLoginProviders)(_.supportedLoginProviders(_))
        .ifSome(developerProviderName)(_.developerProviderName(_))
        .ifSome(openIdConnectProviderARNs)(_.openIdConnectProviderARNs(_))
        .ifSome(cognitoIdentityProviders)(_.cognitoIdentityProviders(_))
        .ifSome(samlProviderARNs)(_.samlProviderARNs(_))
        .ifSome(identityPoolTags)(_.identityPoolTags(_))
        .build

    def credentials(
      accessKeyId: Option[String] = None,
      secretKey: Option[String] = None,
      sessionToken: Option[String] = None,
      expiration: Option[DateType] = None
    ): Credentials =
      Credentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(secretKey)(_.secretKey(_))
        .ifSome(sessionToken)(_.sessionToken(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def deleteIdentitiesInput(
      identityIdsToDelete: Option[List[IdentityId]] = None
    ): DeleteIdentitiesInput =
      DeleteIdentitiesInput
        .builder
        .ifSome(identityIdsToDelete)(_.identityIdsToDelete(_))
        .build

    def deleteIdentitiesResponse(
      unprocessedIdentityIds: Option[List[UnprocessedIdentityId]] = None
    ): DeleteIdentitiesResponse =
      DeleteIdentitiesResponse
        .builder
        .ifSome(unprocessedIdentityIds)(_.unprocessedIdentityIds(_))
        .build

    def deleteIdentityPoolInput(
      identityPoolId: Option[String] = None
    ): DeleteIdentityPoolInput =
      DeleteIdentityPoolInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def describeIdentityInput(
      identityId: Option[String] = None
    ): DescribeIdentityInput =
      DescribeIdentityInput
        .builder
        .ifSome(identityId)(_.identityId(_))
        .build

    def describeIdentityPoolInput(
      identityPoolId: Option[String] = None
    ): DescribeIdentityPoolInput =
      DescribeIdentityPoolInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def developerUserAlreadyRegisteredException(
      message: Option[String] = None
    ): DeveloperUserAlreadyRegisteredException =
      DeveloperUserAlreadyRegisteredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def externalServiceException(
      message: Option[String] = None
    ): ExternalServiceException =
      ExternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getCredentialsForIdentityInput(
      identityId: Option[String] = None,
      logins: Option[LoginsMap] = None,
      customRoleArn: Option[String] = None
    ): GetCredentialsForIdentityInput =
      GetCredentialsForIdentityInput
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(logins)(_.logins(_))
        .ifSome(customRoleArn)(_.customRoleArn(_))
        .build

    def getCredentialsForIdentityResponse(
      identityId: Option[String] = None,
      credentials: Option[Credentials] = None
    ): GetCredentialsForIdentityResponse =
      GetCredentialsForIdentityResponse
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(credentials)(_.credentials(_))
        .build

    def getIdInput(
      accountId: Option[String] = None,
      identityPoolId: Option[String] = None,
      logins: Option[LoginsMap] = None
    ): GetIdInput =
      GetIdInput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(logins)(_.logins(_))
        .build

    def getIdResponse(
      identityId: Option[String] = None
    ): GetIdResponse =
      GetIdResponse
        .builder
        .ifSome(identityId)(_.identityId(_))
        .build

    def getIdentityPoolRolesInput(
      identityPoolId: Option[String] = None
    ): GetIdentityPoolRolesInput =
      GetIdentityPoolRolesInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def getIdentityPoolRolesResponse(
      identityPoolId: Option[String] = None,
      roles: Option[RolesMap] = None,
      roleMappings: Option[RoleMappingMap] = None
    ): GetIdentityPoolRolesResponse =
      GetIdentityPoolRolesResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(roleMappings)(_.roleMappings(_))
        .build

    def getOpenIdTokenForDeveloperIdentityInput(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      logins: Option[LoginsMap] = None,
      principalTags: Option[PrincipalTags] = None,
      tokenDuration: Option[TokenDuration] = None
    ): GetOpenIdTokenForDeveloperIdentityInput =
      GetOpenIdTokenForDeveloperIdentityInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(logins)(_.logins(_))
        .ifSome(principalTags)(_.principalTags(_))
        .ifSome(tokenDuration)(_.tokenDuration(_))
        .build

    def getOpenIdTokenForDeveloperIdentityResponse(
      identityId: Option[String] = None,
      token: Option[String] = None
    ): GetOpenIdTokenForDeveloperIdentityResponse =
      GetOpenIdTokenForDeveloperIdentityResponse
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(token)(_.token(_))
        .build

    def getOpenIdTokenInput(
      identityId: Option[String] = None,
      logins: Option[LoginsMap] = None
    ): GetOpenIdTokenInput =
      GetOpenIdTokenInput
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(logins)(_.logins(_))
        .build

    def getOpenIdTokenResponse(
      identityId: Option[String] = None,
      token: Option[String] = None
    ): GetOpenIdTokenResponse =
      GetOpenIdTokenResponse
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(token)(_.token(_))
        .build

    def getPrincipalTagAttributeMapInput(
      identityPoolId: Option[String] = None,
      identityProviderName: Option[String] = None
    ): GetPrincipalTagAttributeMapInput =
      GetPrincipalTagAttributeMapInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityProviderName)(_.identityProviderName(_))
        .build

    def getPrincipalTagAttributeMapResponse(
      identityPoolId: Option[String] = None,
      identityProviderName: Option[String] = None,
      useDefaults: Option[Boolean] = None,
      principalTags: Option[PrincipalTags] = None
    ): GetPrincipalTagAttributeMapResponse =
      GetPrincipalTagAttributeMapResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityProviderName)(_.identityProviderName(_))
        .ifSome(useDefaults)(_.useDefaults(_))
        .ifSome(principalTags)(_.principalTags(_))
        .build

    def identityDescription(
      identityId: Option[String] = None,
      logins: Option[List[IdentityProviderName]] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None
    ): IdentityDescription =
      IdentityDescription
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(logins)(_.logins(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def identityPool(
      identityPoolId: Option[String] = None,
      identityPoolName: Option[String] = None,
      allowUnauthenticatedIdentities: Option[Boolean] = None,
      allowClassicFlow: Option[Boolean] = None,
      supportedLoginProviders: Option[IdentityProviders] = None,
      developerProviderName: Option[String] = None,
      openIdConnectProviderARNs: Option[List[ARNString]] = None,
      cognitoIdentityProviders: Option[List[CognitoIdentityProvider]] = None,
      samlProviderARNs: Option[List[ARNString]] = None,
      identityPoolTags: Option[IdentityPoolTagsType] = None
    ): IdentityPool =
      IdentityPool
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityPoolName)(_.identityPoolName(_))
        .ifSome(allowUnauthenticatedIdentities)(_.allowUnauthenticatedIdentities(_))
        .ifSome(allowClassicFlow)(_.allowClassicFlow(_))
        .ifSome(supportedLoginProviders)(_.supportedLoginProviders(_))
        .ifSome(developerProviderName)(_.developerProviderName(_))
        .ifSome(openIdConnectProviderARNs)(_.openIdConnectProviderARNs(_))
        .ifSome(cognitoIdentityProviders)(_.cognitoIdentityProviders(_))
        .ifSome(samlProviderARNs)(_.samlProviderARNs(_))
        .ifSome(identityPoolTags)(_.identityPoolTags(_))
        .build

    def identityPoolShortDescription(
      identityPoolId: Option[String] = None,
      identityPoolName: Option[String] = None
    ): IdentityPoolShortDescription =
      IdentityPoolShortDescription
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityPoolName)(_.identityPoolName(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidIdentityPoolConfigurationException(
      message: Option[String] = None
    ): InvalidIdentityPoolConfigurationException =
      InvalidIdentityPoolConfigurationException
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

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listIdentitiesInput(
      identityPoolId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      hideDisabled: Option[Boolean] = None
    ): ListIdentitiesInput =
      ListIdentitiesInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(hideDisabled)(_.hideDisabled(_))
        .build

    def listIdentitiesResponse(
      identityPoolId: Option[String] = None,
      identities: Option[List[IdentityDescription]] = None,
      nextToken: Option[String] = None
    ): ListIdentitiesResponse =
      ListIdentitiesResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identities)(_.identities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityPoolsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIdentityPoolsInput =
      ListIdentityPoolsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityPoolsResponse(
      identityPools: Option[List[IdentityPoolShortDescription]] = None,
      nextToken: Option[String] = None
    ): ListIdentityPoolsResponse =
      ListIdentityPoolsResponse
        .builder
        .ifSome(identityPools)(_.identityPools(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[IdentityPoolTagsType] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def lookupDeveloperIdentityInput(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      developerUserIdentifier: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): LookupDeveloperIdentityInput =
      LookupDeveloperIdentityInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(developerUserIdentifier)(_.developerUserIdentifier(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lookupDeveloperIdentityResponse(
      identityId: Option[String] = None,
      developerUserIdentifierList: Option[List[DeveloperUserIdentifier]] = None,
      nextToken: Option[String] = None
    ): LookupDeveloperIdentityResponse =
      LookupDeveloperIdentityResponse
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(developerUserIdentifierList)(_.developerUserIdentifierList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def mappingRule(
      claim: Option[String] = None,
      matchType: Option[String] = None,
      value: Option[String] = None,
      roleARN: Option[String] = None
    ): MappingRule =
      MappingRule
        .builder
        .ifSome(claim)(_.claim(_))
        .ifSome(matchType)(_.matchType(_))
        .ifSome(value)(_.value(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def mergeDeveloperIdentitiesInput(
      sourceUserIdentifier: Option[String] = None,
      destinationUserIdentifier: Option[String] = None,
      developerProviderName: Option[String] = None,
      identityPoolId: Option[String] = None
    ): MergeDeveloperIdentitiesInput =
      MergeDeveloperIdentitiesInput
        .builder
        .ifSome(sourceUserIdentifier)(_.sourceUserIdentifier(_))
        .ifSome(destinationUserIdentifier)(_.destinationUserIdentifier(_))
        .ifSome(developerProviderName)(_.developerProviderName(_))
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def mergeDeveloperIdentitiesResponse(
      identityId: Option[String] = None
    ): MergeDeveloperIdentitiesResponse =
      MergeDeveloperIdentitiesResponse
        .builder
        .ifSome(identityId)(_.identityId(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceConflictException(
      message: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def roleMapping(
      `type`: Option[String] = None,
      ambiguousRoleResolution: Option[String] = None,
      rulesConfiguration: Option[RulesConfigurationType] = None
    ): RoleMapping =
      RoleMapping
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(ambiguousRoleResolution)(_.ambiguousRoleResolution(_))
        .ifSome(rulesConfiguration)(_.rulesConfiguration(_))
        .build

    def rulesConfigurationType(
      rules: Option[List[MappingRule]] = None
    ): RulesConfigurationType =
      RulesConfigurationType
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def setIdentityPoolRolesInput(
      identityPoolId: Option[String] = None,
      roles: Option[RolesMap] = None,
      roleMappings: Option[RoleMappingMap] = None
    ): SetIdentityPoolRolesInput =
      SetIdentityPoolRolesInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(roleMappings)(_.roleMappings(_))
        .build

    def setPrincipalTagAttributeMapInput(
      identityPoolId: Option[String] = None,
      identityProviderName: Option[String] = None,
      useDefaults: Option[Boolean] = None,
      principalTags: Option[PrincipalTags] = None
    ): SetPrincipalTagAttributeMapInput =
      SetPrincipalTagAttributeMapInput
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityProviderName)(_.identityProviderName(_))
        .ifSome(useDefaults)(_.useDefaults(_))
        .ifSome(principalTags)(_.principalTags(_))
        .build

    def setPrincipalTagAttributeMapResponse(
      identityPoolId: Option[String] = None,
      identityProviderName: Option[String] = None,
      useDefaults: Option[Boolean] = None,
      principalTags: Option[PrincipalTags] = None
    ): SetPrincipalTagAttributeMapResponse =
      SetPrincipalTagAttributeMapResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityProviderName)(_.identityProviderName(_))
        .ifSome(useDefaults)(_.useDefaults(_))
        .ifSome(principalTags)(_.principalTags(_))
        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[IdentityPoolTagsType] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unlinkDeveloperIdentityInput(
      identityId: Option[String] = None,
      identityPoolId: Option[String] = None,
      developerProviderName: Option[String] = None,
      developerUserIdentifier: Option[String] = None
    ): UnlinkDeveloperIdentityInput =
      UnlinkDeveloperIdentityInput
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(developerProviderName)(_.developerProviderName(_))
        .ifSome(developerUserIdentifier)(_.developerUserIdentifier(_))
        .build

    def unlinkIdentityInput(
      identityId: Option[String] = None,
      logins: Option[LoginsMap] = None,
      loginsToRemove: Option[List[IdentityProviderName]] = None
    ): UnlinkIdentityInput =
      UnlinkIdentityInput
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(logins)(_.logins(_))
        .ifSome(loginsToRemove)(_.loginsToRemove(_))
        .build

    def unprocessedIdentityId(
      identityId: Option[String] = None,
      errorCode: Option[String] = None
    ): UnprocessedIdentityId =
      UnprocessedIdentityId
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKeysType]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
