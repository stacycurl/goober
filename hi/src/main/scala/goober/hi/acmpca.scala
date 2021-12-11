package goober.hi

import goober.free.acmpca.AcmPcaIO
import software.amazon.awssdk.services.acmpca.model._


object acmpca {
  import goober.free.{acmpca ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aSN1Subject(
      country: Option[String] = None,
      organization: Option[String] = None,
      organizationalUnit: Option[String] = None,
      distinguishedNameQualifier: Option[String] = None,
      state: Option[String] = None,
      commonName: Option[String] = None,
      serialNumber: Option[String] = None,
      locality: Option[String] = None,
      title: Option[String] = None,
      surname: Option[String] = None,
      givenName: Option[String] = None,
      initials: Option[String] = None,
      pseudonym: Option[String] = None,
      generationQualifier: Option[String] = None
    ): ASN1Subject =
      ASN1Subject
        .builder
        .ifSome(country)(_.country(_))
        .ifSome(organization)(_.organization(_))
        .ifSome(organizationalUnit)(_.organizationalUnit(_))
        .ifSome(distinguishedNameQualifier)(_.distinguishedNameQualifier(_))
        .ifSome(state)(_.state(_))
        .ifSome(commonName)(_.commonName(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(locality)(_.locality(_))
        .ifSome(title)(_.title(_))
        .ifSome(surname)(_.surname(_))
        .ifSome(givenName)(_.givenName(_))
        .ifSome(initials)(_.initials(_))
        .ifSome(pseudonym)(_.pseudonym(_))
        .ifSome(generationQualifier)(_.generationQualifier(_))
        .build

    def accessDescription(
      accessMethod: Option[AccessMethod] = None,
      accessLocation: Option[GeneralName] = None
    ): AccessDescription =
      AccessDescription
        .builder
        .ifSome(accessMethod)(_.accessMethod(_))
        .ifSome(accessLocation)(_.accessLocation(_))
        .build

    def accessMethod(
      customObjectIdentifier: Option[String] = None,
      accessMethodType: Option[String] = None
    ): AccessMethod =
      AccessMethod
        .builder
        .ifSome(customObjectIdentifier)(_.customObjectIdentifier(_))
        .ifSome(accessMethodType)(_.accessMethodType(_))
        .build

    def apiPassthrough(
      extensions: Option[Extensions] = None,
      subject: Option[ASN1Subject] = None
    ): ApiPassthrough =
      ApiPassthrough
        .builder
        .ifSome(extensions)(_.extensions(_))
        .ifSome(subject)(_.subject(_))
        .build

    def certificateAuthority(
      arn: Option[String] = None,
      ownerAccount: Option[String] = None,
      createdAt: Option[TStamp] = None,
      lastStateChangeAt: Option[TStamp] = None,
      `type`: Option[String] = None,
      serial: Option[String] = None,
      status: Option[String] = None,
      notBefore: Option[TStamp] = None,
      notAfter: Option[TStamp] = None,
      failureReason: Option[String] = None,
      certificateAuthorityConfiguration: Option[CertificateAuthorityConfiguration] = None,
      revocationConfiguration: Option[RevocationConfiguration] = None,
      restorableUntil: Option[TStamp] = None,
      keyStorageSecurityStandard: Option[String] = None
    ): CertificateAuthority =
      CertificateAuthority
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(ownerAccount)(_.ownerAccount(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastStateChangeAt)(_.lastStateChangeAt(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(serial)(_.serial(_))
        .ifSome(status)(_.status(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(certificateAuthorityConfiguration)(_.certificateAuthorityConfiguration(_))
        .ifSome(revocationConfiguration)(_.revocationConfiguration(_))
        .ifSome(restorableUntil)(_.restorableUntil(_))
        .ifSome(keyStorageSecurityStandard)(_.keyStorageSecurityStandard(_))
        .build

    def certificateAuthorityConfiguration(
      keyAlgorithm: Option[String] = None,
      signingAlgorithm: Option[String] = None,
      subject: Option[ASN1Subject] = None,
      csrExtensions: Option[CsrExtensions] = None
    ): CertificateAuthorityConfiguration =
      CertificateAuthorityConfiguration
        .builder
        .ifSome(keyAlgorithm)(_.keyAlgorithm(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(csrExtensions)(_.csrExtensions(_))
        .build

    def certificateMismatchException(
      message: Option[String] = None
    ): CertificateMismatchException =
      CertificateMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createCertificateAuthorityAuditReportRequest(
      certificateAuthorityArn: Option[String] = None,
      s3BucketName: Option[String] = None,
      auditReportResponseFormat: Option[String] = None
    ): CreateCertificateAuthorityAuditReportRequest =
      CreateCertificateAuthorityAuditReportRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(auditReportResponseFormat)(_.auditReportResponseFormat(_))
        .build

    def createCertificateAuthorityAuditReportResponse(
      auditReportId: Option[String] = None,
      s3Key: Option[String] = None
    ): CreateCertificateAuthorityAuditReportResponse =
      CreateCertificateAuthorityAuditReportResponse
        .builder
        .ifSome(auditReportId)(_.auditReportId(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def createCertificateAuthorityRequest(
      certificateAuthorityConfiguration: Option[CertificateAuthorityConfiguration] = None,
      revocationConfiguration: Option[RevocationConfiguration] = None,
      certificateAuthorityType: Option[String] = None,
      idempotencyToken: Option[String] = None,
      keyStorageSecurityStandard: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateCertificateAuthorityRequest =
      CreateCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityConfiguration)(_.certificateAuthorityConfiguration(_))
        .ifSome(revocationConfiguration)(_.revocationConfiguration(_))
        .ifSome(certificateAuthorityType)(_.certificateAuthorityType(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(keyStorageSecurityStandard)(_.keyStorageSecurityStandard(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCertificateAuthorityResponse(
      certificateAuthorityArn: Option[String] = None
    ): CreateCertificateAuthorityResponse =
      CreateCertificateAuthorityResponse
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .build

    def createPermissionRequest(
      certificateAuthorityArn: Option[String] = None,
      principal: Option[String] = None,
      sourceAccount: Option[String] = None,
      actions: Option[List[ActionType]] = None
    ): CreatePermissionRequest =
      CreatePermissionRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(sourceAccount)(_.sourceAccount(_))
        .ifSome(actions)(_.actions(_))
        .build

    def crlConfiguration(
      enabled: Option[Boolean] = None,
      expirationInDays: Option[Int] = None,
      customCname: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3ObjectAcl: Option[String] = None
    ): CrlConfiguration =
      CrlConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(expirationInDays)(_.expirationInDays(_))
        .ifSome(customCname)(_.customCname(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3ObjectAcl)(_.s3ObjectAcl(_))
        .build

    def csrExtensions(
      keyUsage: Option[KeyUsage] = None,
      subjectInformationAccess: Option[List[AccessDescription]] = None
    ): CsrExtensions =
      CsrExtensions
        .builder
        .ifSome(keyUsage)(_.keyUsage(_))
        .ifSome(subjectInformationAccess)(_.subjectInformationAccess(_))
        .build

    def deleteCertificateAuthorityRequest(
      certificateAuthorityArn: Option[String] = None,
      permanentDeletionTimeInDays: Option[Int] = None
    ): DeleteCertificateAuthorityRequest =
      DeleteCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(permanentDeletionTimeInDays)(_.permanentDeletionTimeInDays(_))
        .build

    def deletePermissionRequest(
      certificateAuthorityArn: Option[String] = None,
      principal: Option[String] = None,
      sourceAccount: Option[String] = None
    ): DeletePermissionRequest =
      DeletePermissionRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(sourceAccount)(_.sourceAccount(_))
        .build

    def deletePolicyRequest(
      resourceArn: Option[String] = None
    ): DeletePolicyRequest =
      DeletePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeCertificateAuthorityAuditReportRequest(
      certificateAuthorityArn: Option[String] = None,
      auditReportId: Option[String] = None
    ): DescribeCertificateAuthorityAuditReportRequest =
      DescribeCertificateAuthorityAuditReportRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(auditReportId)(_.auditReportId(_))
        .build

    def describeCertificateAuthorityAuditReportResponse(
      auditReportStatus: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3Key: Option[String] = None,
      createdAt: Option[TStamp] = None
    ): DescribeCertificateAuthorityAuditReportResponse =
      DescribeCertificateAuthorityAuditReportResponse
        .builder
        .ifSome(auditReportStatus)(_.auditReportStatus(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def describeCertificateAuthorityRequest(
      certificateAuthorityArn: Option[String] = None
    ): DescribeCertificateAuthorityRequest =
      DescribeCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .build

    def describeCertificateAuthorityResponse(
      certificateAuthority: Option[CertificateAuthority] = None
    ): DescribeCertificateAuthorityResponse =
      DescribeCertificateAuthorityResponse
        .builder
        .ifSome(certificateAuthority)(_.certificateAuthority(_))
        .build

    def ediPartyName(
      partyName: Option[String] = None,
      nameAssigner: Option[String] = None
    ): EdiPartyName =
      EdiPartyName
        .builder
        .ifSome(partyName)(_.partyName(_))
        .ifSome(nameAssigner)(_.nameAssigner(_))
        .build

    def extendedKeyUsage(
      extendedKeyUsageType: Option[String] = None,
      extendedKeyUsageObjectIdentifier: Option[String] = None
    ): ExtendedKeyUsage =
      ExtendedKeyUsage
        .builder
        .ifSome(extendedKeyUsageType)(_.extendedKeyUsageType(_))
        .ifSome(extendedKeyUsageObjectIdentifier)(_.extendedKeyUsageObjectIdentifier(_))
        .build

    def extensions(
      certificatePolicies: Option[List[PolicyInformation]] = None,
      extendedKeyUsage: Option[List[ExtendedKeyUsage]] = None,
      keyUsage: Option[KeyUsage] = None,
      subjectAlternativeNames: Option[List[GeneralName]] = None
    ): Extensions =
      Extensions
        .builder
        .ifSome(certificatePolicies)(_.certificatePolicies(_))
        .ifSome(extendedKeyUsage)(_.extendedKeyUsage(_))
        .ifSome(keyUsage)(_.keyUsage(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .build

    def generalName(
      otherName: Option[OtherName] = None,
      rfc822Name: Option[String] = None,
      dnsName: Option[String] = None,
      directoryName: Option[ASN1Subject] = None,
      ediPartyName: Option[EdiPartyName] = None,
      uniformResourceIdentifier: Option[String] = None,
      ipAddress: Option[String] = None,
      registeredId: Option[String] = None
    ): GeneralName =
      GeneralName
        .builder
        .ifSome(otherName)(_.otherName(_))
        .ifSome(rfc822Name)(_.rfc822Name(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(ediPartyName)(_.ediPartyName(_))
        .ifSome(uniformResourceIdentifier)(_.uniformResourceIdentifier(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(registeredId)(_.registeredId(_))
        .build

    def getCertificateAuthorityCertificateRequest(
      certificateAuthorityArn: Option[String] = None
    ): GetCertificateAuthorityCertificateRequest =
      GetCertificateAuthorityCertificateRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .build

    def getCertificateAuthorityCertificateResponse(
      certificate: Option[String] = None,
      certificateChain: Option[String] = None
    ): GetCertificateAuthorityCertificateResponse =
      GetCertificateAuthorityCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .build

    def getCertificateAuthorityCsrRequest(
      certificateAuthorityArn: Option[String] = None
    ): GetCertificateAuthorityCsrRequest =
      GetCertificateAuthorityCsrRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .build

    def getCertificateAuthorityCsrResponse(
      csr: Option[String] = None
    ): GetCertificateAuthorityCsrResponse =
      GetCertificateAuthorityCsrResponse
        .builder
        .ifSome(csr)(_.csr(_))
        .build

    def getCertificateRequest(
      certificateAuthorityArn: Option[String] = None,
      certificateArn: Option[String] = None
    ): GetCertificateRequest =
      GetCertificateRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def getCertificateResponse(
      certificate: Option[String] = None,
      certificateChain: Option[String] = None
    ): GetCertificateResponse =
      GetCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .build

    def getPolicyRequest(
      resourceArn: Option[String] = None
    ): GetPolicyRequest =
      GetPolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getPolicyResponse(
      policy: Option[String] = None
    ): GetPolicyResponse =
      GetPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def importCertificateAuthorityCertificateRequest(
      certificateAuthorityArn: Option[String] = None,
      certificate: Option[CertificateBodyBlob] = None,
      certificateChain: Option[CertificateChainBlob] = None
    ): ImportCertificateAuthorityCertificateRequest =
      ImportCertificateAuthorityCertificateRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .build

    def invalidArgsException(
      message: Option[String] = None
    ): InvalidArgsException =
      InvalidArgsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArnException(
      message: Option[String] = None
    ): InvalidArnException =
      InvalidArnException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPolicyException(
      message: Option[String] = None
    ): InvalidPolicyException =
      InvalidPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidStateException(
      message: Option[String] = None
    ): InvalidStateException =
      InvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTagException(
      message: Option[String] = None
    ): InvalidTagException =
      InvalidTagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def issueCertificateRequest(
      apiPassthrough: Option[ApiPassthrough] = None,
      certificateAuthorityArn: Option[String] = None,
      csr: Option[CsrBlob] = None,
      signingAlgorithm: Option[String] = None,
      templateArn: Option[String] = None,
      validity: Option[Validity] = None,
      validityNotBefore: Option[Validity] = None,
      idempotencyToken: Option[String] = None
    ): IssueCertificateRequest =
      IssueCertificateRequest
        .builder
        .ifSome(apiPassthrough)(_.apiPassthrough(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(csr)(_.csr(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(validityNotBefore)(_.validityNotBefore(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def issueCertificateResponse(
      certificateArn: Option[String] = None
    ): IssueCertificateResponse =
      IssueCertificateResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def keyUsage(
      digitalSignature: Option[Boolean] = None,
      nonRepudiation: Option[Boolean] = None,
      keyEncipherment: Option[Boolean] = None,
      dataEncipherment: Option[Boolean] = None,
      keyAgreement: Option[Boolean] = None,
      keyCertSign: Option[Boolean] = None,
      cRLSign: Option[Boolean] = None,
      encipherOnly: Option[Boolean] = None,
      decipherOnly: Option[Boolean] = None
    ): KeyUsage =
      KeyUsage
        .builder
        .ifSome(digitalSignature)(_.digitalSignature(_))
        .ifSome(nonRepudiation)(_.nonRepudiation(_))
        .ifSome(keyEncipherment)(_.keyEncipherment(_))
        .ifSome(dataEncipherment)(_.dataEncipherment(_))
        .ifSome(keyAgreement)(_.keyAgreement(_))
        .ifSome(keyCertSign)(_.keyCertSign(_))
        .ifSome(cRLSign)(_.cRLSign(_))
        .ifSome(encipherOnly)(_.encipherOnly(_))
        .ifSome(decipherOnly)(_.decipherOnly(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listCertificateAuthoritiesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resourceOwner: Option[String] = None
    ): ListCertificateAuthoritiesRequest =
      ListCertificateAuthoritiesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .build

    def listCertificateAuthoritiesResponse(
      certificateAuthorities: Option[List[CertificateAuthority]] = None,
      nextToken: Option[String] = None
    ): ListCertificateAuthoritiesResponse =
      ListCertificateAuthoritiesResponse
        .builder
        .ifSome(certificateAuthorities)(_.certificateAuthorities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPermissionsRequest(
      certificateAuthorityArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPermissionsRequest =
      ListPermissionsRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPermissionsResponse(
      permissions: Option[List[Permission]] = None,
      nextToken: Option[String] = None
    ): ListPermissionsResponse =
      ListPermissionsResponse
        .builder
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsRequest(
      certificateAuthorityArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lockoutPreventedException(
      message: Option[String] = None
    ): LockoutPreventedException =
      LockoutPreventedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def malformedCSRException(
      message: Option[String] = None
    ): MalformedCSRException =
      MalformedCSRException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def malformedCertificateException(
      message: Option[String] = None
    ): MalformedCertificateException =
      MalformedCertificateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def otherName(
      typeId: Option[String] = None,
      value: Option[String] = None
    ): OtherName =
      OtherName
        .builder
        .ifSome(typeId)(_.typeId(_))
        .ifSome(value)(_.value(_))
        .build

    def permission(
      certificateAuthorityArn: Option[String] = None,
      createdAt: Option[TStamp] = None,
      principal: Option[String] = None,
      sourceAccount: Option[String] = None,
      actions: Option[List[ActionType]] = None,
      policy: Option[String] = None
    ): Permission =
      Permission
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(sourceAccount)(_.sourceAccount(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(policy)(_.policy(_))
        .build

    def permissionAlreadyExistsException(
      message: Option[String] = None
    ): PermissionAlreadyExistsException =
      PermissionAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyInformation(
      certPolicyId: Option[String] = None,
      policyQualifiers: Option[List[PolicyQualifierInfo]] = None
    ): PolicyInformation =
      PolicyInformation
        .builder
        .ifSome(certPolicyId)(_.certPolicyId(_))
        .ifSome(policyQualifiers)(_.policyQualifiers(_))
        .build

    def policyQualifierInfo(
      policyQualifierId: Option[String] = None,
      qualifier: Option[Qualifier] = None
    ): PolicyQualifierInfo =
      PolicyQualifierInfo
        .builder
        .ifSome(policyQualifierId)(_.policyQualifierId(_))
        .ifSome(qualifier)(_.qualifier(_))
        .build

    def putPolicyRequest(
      resourceArn: Option[String] = None,
      policy: Option[String] = None
    ): PutPolicyRequest =
      PutPolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def qualifier(
      cpsUri: Option[String] = None
    ): Qualifier =
      Qualifier
        .builder
        .ifSome(cpsUri)(_.cpsUri(_))
        .build

    def requestAlreadyProcessedException(
      message: Option[String] = None
    ): RequestAlreadyProcessedException =
      RequestAlreadyProcessedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def requestFailedException(
      message: Option[String] = None
    ): RequestFailedException =
      RequestFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def requestInProgressException(
      message: Option[String] = None
    ): RequestInProgressException =
      RequestInProgressException
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

    def restoreCertificateAuthorityRequest(
      certificateAuthorityArn: Option[String] = None
    ): RestoreCertificateAuthorityRequest =
      RestoreCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .build

    def revocationConfiguration(
      crlConfiguration: Option[CrlConfiguration] = None
    ): RevocationConfiguration =
      RevocationConfiguration
        .builder
        .ifSome(crlConfiguration)(_.crlConfiguration(_))
        .build

    def revokeCertificateRequest(
      certificateAuthorityArn: Option[String] = None,
      certificateSerial: Option[String] = None,
      revocationReason: Option[String] = None
    ): RevokeCertificateRequest =
      RevokeCertificateRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(certificateSerial)(_.certificateSerial(_))
        .ifSome(revocationReason)(_.revocationReason(_))
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

    def tagCertificateAuthorityRequest(
      certificateAuthorityArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagCertificateAuthorityRequest =
      TagCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagCertificateAuthorityRequest(
      certificateAuthorityArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): UntagCertificateAuthorityRequest =
      UntagCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateCertificateAuthorityRequest(
      certificateAuthorityArn: Option[String] = None,
      revocationConfiguration: Option[RevocationConfiguration] = None,
      status: Option[String] = None
    ): UpdateCertificateAuthorityRequest =
      UpdateCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(revocationConfiguration)(_.revocationConfiguration(_))
        .ifSome(status)(_.status(_))
        .build

    def validity(
      value: Option[PositiveLong] = None,
      `type`: Option[String] = None
    ): Validity =
      Validity
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
