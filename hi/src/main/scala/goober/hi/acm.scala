package goober.hi

import goober.free.acm.AcmIO
import software.amazon.awssdk.services.acm.model._


object acm {
  import goober.free.{acm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def addTagsToCertificateRequest(
      certificateArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsToCertificateRequest =
      AddTagsToCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    someRequest(
      someArg = 123,
      anotherArg = "abc"
    )

    def someRequest(
      someArg: Int = null,
      anotherArg: String = null,
      thirdArg: Boolean = null
    ): SomeRequest = {
      SomeRequest
        .builder()
        .ifSome(Option(someArg))(_.someArg(_))
        .ifSome(Option(anotherArg))(_.anotherArg(_))
        .ifSome(Option(thirdArg))(_.thirdArg(_))
        .build()
    }

    object SomeRequest {
      def builder(): SomeRequest = SomeRequest(None, None, None)
    }

    case class SomeRequest(
      someArgOpt: Option[Int],
      anotherArgOPt: Option[String],
      thirdArgOpt: Option[Boolean]
    ) {

      def someArg(value: Int): SomeRequest = this
      def anotherArg(value: Int): SomeRequest = this
      def thirdArg(value: Int): SomeRequest = this

    }

    def certificateDetail(
      certificateArn: Option[String] = None,
      domainName: Option[String] = None,
      subjectAlternativeNames: Option[List[DomainNameString]] = None,
      domainValidationOptions: Option[List[DomainValidation]] = None,
      serial: Option[String] = None,
      subject: Option[String] = None,
      issuer: Option[String] = None,
      createdAt: Option[TStamp] = None,
      issuedAt: Option[TStamp] = None,
      importedAt: Option[TStamp] = None,
      status: Option[String] = None,
      revokedAt: Option[TStamp] = None,
      revocationReason: Option[String] = None,
      notBefore: Option[TStamp] = None,
      notAfter: Option[TStamp] = None,
      keyAlgorithm: Option[String] = None,
      signatureAlgorithm: Option[String] = None,
      inUseBy: Option[List[String]] = None,
      failureReason: Option[String] = None,
      `type`: Option[String] = None,
      renewalSummary: Option[RenewalSummary] = None,
      keyUsages: Option[List[KeyUsage]] = None,
      extendedKeyUsages: Option[List[ExtendedKeyUsage]] = None,
      certificateAuthorityArn: Option[String] = None,
      renewalEligibility: Option[String] = None,
      options: Option[CertificateOptions] = None
    ): CertificateDetail =
      CertificateDetail
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(domainValidationOptions)(_.domainValidationOptions(_))
        .ifSome(serial)(_.serial(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(issuedAt)(_.issuedAt(_))
        .ifSome(importedAt)(_.importedAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(revokedAt)(_.revokedAt(_))
        .ifSome(revocationReason)(_.revocationReason(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(keyAlgorithm)(_.keyAlgorithm(_))
        .ifSome(signatureAlgorithm)(_.signatureAlgorithm(_))
        .ifSome(inUseBy)(_.inUseBy(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(renewalSummary)(_.renewalSummary(_))
        .ifSome(keyUsages)(_.keyUsages(_))
        .ifSome(extendedKeyUsages)(_.extendedKeyUsages(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(renewalEligibility)(_.renewalEligibility(_))
        .ifSome(options)(_.options(_))
        .build

    def certificateOptions(
      certificateTransparencyLoggingPreference: Option[String] = None
    ): CertificateOptions =
      CertificateOptions
        .builder
        .ifSome(certificateTransparencyLoggingPreference)(_.certificateTransparencyLoggingPreference(_))
        .build

    def certificateSummary(
      certificateArn: Option[String] = None,
      domainName: Option[String] = None
    ): CertificateSummary =
      CertificateSummary
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteCertificateRequest(
      certificateArn: Option[String] = None
    ): DeleteCertificateRequest =
      DeleteCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def describeCertificateRequest(
      certificateArn: Option[String] = None
    ): DescribeCertificateRequest =
      DescribeCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def describeCertificateResponse(
      certificate: Option[CertificateDetail] = None
    ): DescribeCertificateResponse =
      DescribeCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .build

    def domainValidation(
      domainName: Option[String] = None,
      validationEmails: Option[List[String]] = None,
      validationDomain: Option[String] = None,
      validationStatus: Option[String] = None,
      resourceRecord: Option[ResourceRecord] = None,
      validationMethod: Option[String] = None
    ): DomainValidation =
      DomainValidation
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(validationEmails)(_.validationEmails(_))
        .ifSome(validationDomain)(_.validationDomain(_))
        .ifSome(validationStatus)(_.validationStatus(_))
        .ifSome(resourceRecord)(_.resourceRecord(_))
        .ifSome(validationMethod)(_.validationMethod(_))
        .build

    def domainValidationOption(
      domainName: Option[String] = None,
      validationDomain: Option[String] = None
    ): DomainValidationOption =
      DomainValidationOption
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(validationDomain)(_.validationDomain(_))
        .build

    def expiryEventsConfiguration(
      daysBeforeExpiry: Option[Int] = None
    ): ExpiryEventsConfiguration =
      ExpiryEventsConfiguration
        .builder
        .ifSome(daysBeforeExpiry)(_.daysBeforeExpiry(_))
        .build

    def exportCertificateRequest(
      certificateArn: Option[String] = None,
      passphrase: Option[PassphraseBlob] = None
    ): ExportCertificateRequest =
      ExportCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(passphrase)(_.passphrase(_))
        .build

    def exportCertificateResponse(
      certificate: Option[String] = None,
      certificateChain: Option[String] = None,
      privateKey: Option[String] = None
    ): ExportCertificateResponse =
      ExportCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(privateKey)(_.privateKey(_))
        .build

    def extendedKeyUsage(
      name: Option[String] = None,
      oID: Option[String] = None
    ): ExtendedKeyUsage =
      ExtendedKeyUsage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(oID)(_.oID(_))
        .build

    def filters(
      extendedKeyUsage: Option[List[ExtendedKeyUsageName]] = None,
      keyUsage: Option[List[KeyUsageName]] = None,
      keyTypes: Option[List[KeyAlgorithm]] = None
    ): Filters =
      Filters
        .builder
        .ifSome(extendedKeyUsage)(_.extendedKeyUsage(_))
        .ifSome(keyUsage)(_.keyUsage(_))
        .ifSome(keyTypes)(_.keyTypes(_))
        .build

    def getAccountConfigurationResponse(
      expiryEvents: Option[ExpiryEventsConfiguration] = None
    ): GetAccountConfigurationResponse =
      GetAccountConfigurationResponse
        .builder
        .ifSome(expiryEvents)(_.expiryEvents(_))
        .build

    def getCertificateRequest(
      certificateArn: Option[String] = None
    ): GetCertificateRequest =
      GetCertificateRequest
        .builder
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

    def importCertificateRequest(
      certificateArn: Option[String] = None,
      certificate: Option[CertificateBodyBlob] = None,
      privateKey: Option[PrivateKeyBlob] = None,
      certificateChain: Option[CertificateChainBlob] = None,
      tags: Option[List[Tag]] = None
    ): ImportCertificateRequest =
      ImportCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(tags)(_.tags(_))
        .build

    def importCertificateResponse(
      certificateArn: Option[String] = None
    ): ImportCertificateResponse =
      ImportCertificateResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
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

    def invalidDomainValidationOptionsException(
      message: Option[String] = None
    ): InvalidDomainValidationOptionsException =
      InvalidDomainValidationOptionsException
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

    def keyUsage(
      name: Option[String] = None
    ): KeyUsage =
      KeyUsage
        .builder
        .ifSome(name)(_.name(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listCertificatesRequest(
      certificateStatuses: Option[List[CertificateStatus]] = None,
      includes: Option[Filters] = None,
      nextToken: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListCertificatesRequest =
      ListCertificatesRequest
        .builder
        .ifSome(certificateStatuses)(_.certificateStatuses(_))
        .ifSome(includes)(_.includes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listCertificatesResponse(
      nextToken: Option[String] = None,
      certificateSummaryList: Option[List[CertificateSummary]] = None
    ): ListCertificatesResponse =
      ListCertificatesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(certificateSummaryList)(_.certificateSummaryList(_))
        .build

    def listTagsForCertificateRequest(
      certificateArn: Option[String] = None
    ): ListTagsForCertificateRequest =
      ListTagsForCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def listTagsForCertificateResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForCertificateResponse =
      ListTagsForCertificateResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def putAccountConfigurationRequest(
      expiryEvents: Option[ExpiryEventsConfiguration] = None,
      idempotencyToken: Option[String] = None
    ): PutAccountConfigurationRequest =
      PutAccountConfigurationRequest
        .builder
        .ifSome(expiryEvents)(_.expiryEvents(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def removeTagsFromCertificateRequest(
      certificateArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): RemoveTagsFromCertificateRequest =
      RemoveTagsFromCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def renewCertificateRequest(
      certificateArn: Option[String] = None
    ): RenewCertificateRequest =
      RenewCertificateRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def renewalSummary(
      renewalStatus: Option[String] = None,
      domainValidationOptions: Option[List[DomainValidation]] = None,
      renewalStatusReason: Option[String] = None,
      updatedAt: Option[TStamp] = None
    ): RenewalSummary =
      RenewalSummary
        .builder
        .ifSome(renewalStatus)(_.renewalStatus(_))
        .ifSome(domainValidationOptions)(_.domainValidationOptions(_))
        .ifSome(renewalStatusReason)(_.renewalStatusReason(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def requestCertificateRequest(
      domainName: Option[String] = None,
      validationMethod: Option[String] = None,
      subjectAlternativeNames: Option[List[DomainNameString]] = None,
      idempotencyToken: Option[String] = None,
      domainValidationOptions: Option[List[DomainValidationOption]] = None,
      options: Option[CertificateOptions] = None,
      certificateAuthorityArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): RequestCertificateRequest =
      RequestCertificateRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(validationMethod)(_.validationMethod(_))
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(domainValidationOptions)(_.domainValidationOptions(_))
        .ifSome(options)(_.options(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def requestCertificateResponse(
      certificateArn: Option[String] = None
    ): RequestCertificateResponse =
      RequestCertificateResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def requestInProgressException(
      message: Option[String] = None
    ): RequestInProgressException =
      RequestInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resendValidationEmailRequest(
      certificateArn: Option[String] = None,
      domain: Option[String] = None,
      validationDomain: Option[String] = None
    ): ResendValidationEmailRequest =
      ResendValidationEmailRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(validationDomain)(_.validationDomain(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
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

    def resourceRecord(
      name: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None
    ): ResourceRecord =
      ResourceRecord
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
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

    def tagPolicyException(
      message: Option[String] = None
    ): TagPolicyException =
      TagPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateCertificateOptionsRequest(
      certificateArn: Option[String] = None,
      options: Option[CertificateOptions] = None
    ): UpdateCertificateOptionsRequest =
      UpdateCertificateOptionsRequest
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(options)(_.options(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
