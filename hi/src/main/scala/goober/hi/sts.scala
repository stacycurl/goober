package goober.hi

import goober.free.sts.StsIO
import software.amazon.awssdk.services.sts.model._


object sts {
  import goober.free.{sts ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def assumeRoleRequest(
      roleArn: Option[String] = None,
      roleSessionName: Option[String] = None,
      policyArns: Option[List[PolicyDescriptorType]] = None,
      policy: Option[String] = None,
      durationSeconds: Option[Int] = None,
      tags: Option[List[Tag]] = None,
      transitiveTagKeys: Option[List[tagKeyType]] = None,
      externalId: Option[String] = None,
      serialNumber: Option[String] = None,
      tokenCode: Option[String] = None,
      sourceIdentity: Option[String] = None
    ): AssumeRoleRequest =
      AssumeRoleRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(roleSessionName)(_.roleSessionName(_))
        .ifSome(policyArns)(_.policyArns(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(transitiveTagKeys)(_.transitiveTagKeys(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(tokenCode)(_.tokenCode(_))
        .ifSome(sourceIdentity)(_.sourceIdentity(_))
        .build

    def assumeRoleResponse(
      credentials: Option[Credentials] = None,
      assumedRoleUser: Option[AssumedRoleUser] = None,
      packedPolicySize: Option[Int] = None,
      sourceIdentity: Option[String] = None
    ): AssumeRoleResponse =
      AssumeRoleResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .ifSome(assumedRoleUser)(_.assumedRoleUser(_))
        .ifSome(packedPolicySize)(_.packedPolicySize(_))
        .ifSome(sourceIdentity)(_.sourceIdentity(_))
        .build

    def assumeRoleWithSAMLRequest(
      roleArn: Option[String] = None,
      principalArn: Option[String] = None,
      sAMLAssertion: Option[String] = None,
      policyArns: Option[List[PolicyDescriptorType]] = None,
      policy: Option[String] = None,
      durationSeconds: Option[Int] = None
    ): AssumeRoleWithSAMLRequest =
      AssumeRoleWithSAMLRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(principalArn)(_.principalArn(_))
        .ifSome(sAMLAssertion)(_.sAMLAssertion(_))
        .ifSome(policyArns)(_.policyArns(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .build

    def assumeRoleWithSAMLResponse(
      credentials: Option[Credentials] = None,
      assumedRoleUser: Option[AssumedRoleUser] = None,
      packedPolicySize: Option[Int] = None,
      subject: Option[String] = None,
      subjectType: Option[String] = None,
      issuer: Option[String] = None,
      audience: Option[String] = None,
      nameQualifier: Option[String] = None,
      sourceIdentity: Option[String] = None
    ): AssumeRoleWithSAMLResponse =
      AssumeRoleWithSAMLResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .ifSome(assumedRoleUser)(_.assumedRoleUser(_))
        .ifSome(packedPolicySize)(_.packedPolicySize(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(subjectType)(_.subjectType(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(audience)(_.audience(_))
        .ifSome(nameQualifier)(_.nameQualifier(_))
        .ifSome(sourceIdentity)(_.sourceIdentity(_))
        .build

    def assumeRoleWithWebIdentityRequest(
      roleArn: Option[String] = None,
      roleSessionName: Option[String] = None,
      webIdentityToken: Option[String] = None,
      providerId: Option[String] = None,
      policyArns: Option[List[PolicyDescriptorType]] = None,
      policy: Option[String] = None,
      durationSeconds: Option[Int] = None
    ): AssumeRoleWithWebIdentityRequest =
      AssumeRoleWithWebIdentityRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(roleSessionName)(_.roleSessionName(_))
        .ifSome(webIdentityToken)(_.webIdentityToken(_))
        .ifSome(providerId)(_.providerId(_))
        .ifSome(policyArns)(_.policyArns(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .build

    def assumeRoleWithWebIdentityResponse(
      credentials: Option[Credentials] = None,
      subjectFromWebIdentityToken: Option[String] = None,
      assumedRoleUser: Option[AssumedRoleUser] = None,
      packedPolicySize: Option[Int] = None,
      provider: Option[String] = None,
      audience: Option[String] = None,
      sourceIdentity: Option[String] = None
    ): AssumeRoleWithWebIdentityResponse =
      AssumeRoleWithWebIdentityResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .ifSome(subjectFromWebIdentityToken)(_.subjectFromWebIdentityToken(_))
        .ifSome(assumedRoleUser)(_.assumedRoleUser(_))
        .ifSome(packedPolicySize)(_.packedPolicySize(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(audience)(_.audience(_))
        .ifSome(sourceIdentity)(_.sourceIdentity(_))
        .build

    def assumedRoleUser(
      assumedRoleId: Option[String] = None,
      arn: Option[String] = None
    ): AssumedRoleUser =
      AssumedRoleUser
        .builder
        .ifSome(assumedRoleId)(_.assumedRoleId(_))
        .ifSome(arn)(_.arn(_))
        .build

    def credentials(
      accessKeyId: Option[String] = None,
      secretAccessKey: Option[String] = None,
      sessionToken: Option[String] = None,
      expiration: Option[dateType] = None
    ): Credentials =
      Credentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(sessionToken)(_.sessionToken(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def decodeAuthorizationMessageRequest(
      encodedMessage: Option[String] = None
    ): DecodeAuthorizationMessageRequest =
      DecodeAuthorizationMessageRequest
        .builder
        .ifSome(encodedMessage)(_.encodedMessage(_))
        .build

    def decodeAuthorizationMessageResponse(
      decodedMessage: Option[String] = None
    ): DecodeAuthorizationMessageResponse =
      DecodeAuthorizationMessageResponse
        .builder
        .ifSome(decodedMessage)(_.decodedMessage(_))
        .build

    def expiredTokenException(
      message: Option[String] = None
    ): ExpiredTokenException =
      ExpiredTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def federatedUser(
      federatedUserId: Option[String] = None,
      arn: Option[String] = None
    ): FederatedUser =
      FederatedUser
        .builder
        .ifSome(federatedUserId)(_.federatedUserId(_))
        .ifSome(arn)(_.arn(_))
        .build

    def getAccessKeyInfoRequest(
      accessKeyId: Option[String] = None
    ): GetAccessKeyInfoRequest =
      GetAccessKeyInfoRequest
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .build

    def getAccessKeyInfoResponse(
      account: Option[String] = None
    ): GetAccessKeyInfoResponse =
      GetAccessKeyInfoResponse
        .builder
        .ifSome(account)(_.account(_))
        .build

    def getCallerIdentityRequest(

    ): GetCallerIdentityRequest =
      GetCallerIdentityRequest
        .builder

        .build

    def getCallerIdentityResponse(
      userId: Option[String] = None,
      account: Option[String] = None,
      arn: Option[String] = None
    ): GetCallerIdentityResponse =
      GetCallerIdentityResponse
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(account)(_.account(_))
        .ifSome(arn)(_.arn(_))
        .build

    def getFederationTokenRequest(
      name: Option[String] = None,
      policy: Option[String] = None,
      policyArns: Option[List[PolicyDescriptorType]] = None,
      durationSeconds: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): GetFederationTokenRequest =
      GetFederationTokenRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(policyArns)(_.policyArns(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getFederationTokenResponse(
      credentials: Option[Credentials] = None,
      federatedUser: Option[FederatedUser] = None,
      packedPolicySize: Option[Int] = None
    ): GetFederationTokenResponse =
      GetFederationTokenResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .ifSome(federatedUser)(_.federatedUser(_))
        .ifSome(packedPolicySize)(_.packedPolicySize(_))
        .build

    def getSessionTokenRequest(
      durationSeconds: Option[Int] = None,
      serialNumber: Option[String] = None,
      tokenCode: Option[String] = None
    ): GetSessionTokenRequest =
      GetSessionTokenRequest
        .builder
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(tokenCode)(_.tokenCode(_))
        .build

    def getSessionTokenResponse(
      credentials: Option[Credentials] = None
    ): GetSessionTokenResponse =
      GetSessionTokenResponse
        .builder
        .ifSome(credentials)(_.credentials(_))
        .build

    def iDPCommunicationErrorException(
      message: Option[String] = None
    ): IDPCommunicationErrorException =
      IDPCommunicationErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def iDPRejectedClaimException(
      message: Option[String] = None
    ): IDPRejectedClaimException =
      IDPRejectedClaimException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAuthorizationMessageException(
      message: Option[String] = None
    ): InvalidAuthorizationMessageException =
      InvalidAuthorizationMessageException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidIdentityTokenException(
      message: Option[String] = None
    ): InvalidIdentityTokenException =
      InvalidIdentityTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def malformedPolicyDocumentException(
      message: Option[String] = None
    ): MalformedPolicyDocumentException =
      MalformedPolicyDocumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def packedPolicyTooLargeException(
      message: Option[String] = None
    ): PackedPolicyTooLargeException =
      PackedPolicyTooLargeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyDescriptorType(
      arn: Option[String] = None
    ): PolicyDescriptorType =
      PolicyDescriptorType
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def regionDisabledException(
      message: Option[String] = None
    ): RegionDisabledException =
      RegionDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
