package goober.hi

import goober.free.licensemanager.LicenseManagerIO
import software.amazon.awssdk.services.licensemanager.model._


object licensemanager {
  import goober.free.{licensemanager ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptGrantRequest(
      grantArn: Option[String] = None
    ): AcceptGrantRequest =
      AcceptGrantRequest
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .build

    def acceptGrantResponse(
      grantArn: Option[String] = None,
      status: Option[String] = None,
      version: Option[String] = None
    ): AcceptGrantResponse =
      AcceptGrantResponse
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(version)(_.version(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def authorizationException(
      message: Option[String] = None
    ): AuthorizationException =
      AuthorizationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automatedDiscoveryInformation(
      lastRunTime: Option[DateTime] = None
    ): AutomatedDiscoveryInformation =
      AutomatedDiscoveryInformation
        .builder
        .ifSome(lastRunTime)(_.lastRunTime(_))
        .build

    def borrowConfiguration(
      allowEarlyCheckIn: Option[Boolean] = None,
      maxTimeToLiveInMinutes: Option[Int] = None
    ): BorrowConfiguration =
      BorrowConfiguration
        .builder
        .ifSome(allowEarlyCheckIn)(_.allowEarlyCheckIn(_))
        .ifSome(maxTimeToLiveInMinutes)(_.maxTimeToLiveInMinutes(_))
        .build

    def checkInLicenseRequest(
      licenseConsumptionToken: Option[String] = None,
      beneficiary: Option[String] = None
    ): CheckInLicenseRequest =
      CheckInLicenseRequest
        .builder
        .ifSome(licenseConsumptionToken)(_.licenseConsumptionToken(_))
        .ifSome(beneficiary)(_.beneficiary(_))
        .build

    def checkInLicenseResponse(

    ): CheckInLicenseResponse =
      CheckInLicenseResponse
        .builder

        .build

    def checkoutBorrowLicenseRequest(
      licenseArn: Option[String] = None,
      entitlements: Option[List[EntitlementData]] = None,
      digitalSignatureMethod: Option[String] = None,
      nodeId: Option[String] = None,
      checkoutMetadata: Option[List[Metadata]] = None,
      clientToken: Option[String] = None
    ): CheckoutBorrowLicenseRequest =
      CheckoutBorrowLicenseRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(digitalSignatureMethod)(_.digitalSignatureMethod(_))
        .ifSome(nodeId)(_.nodeId(_))
        .ifSome(checkoutMetadata)(_.checkoutMetadata(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def checkoutBorrowLicenseResponse(
      licenseArn: Option[String] = None,
      licenseConsumptionToken: Option[String] = None,
      entitlementsAllowed: Option[List[EntitlementData]] = None,
      nodeId: Option[String] = None,
      signedToken: Option[String] = None,
      issuedAt: Option[String] = None,
      expiration: Option[String] = None,
      checkoutMetadata: Option[List[Metadata]] = None
    ): CheckoutBorrowLicenseResponse =
      CheckoutBorrowLicenseResponse
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(licenseConsumptionToken)(_.licenseConsumptionToken(_))
        .ifSome(entitlementsAllowed)(_.entitlementsAllowed(_))
        .ifSome(nodeId)(_.nodeId(_))
        .ifSome(signedToken)(_.signedToken(_))
        .ifSome(issuedAt)(_.issuedAt(_))
        .ifSome(expiration)(_.expiration(_))
        .ifSome(checkoutMetadata)(_.checkoutMetadata(_))
        .build

    def checkoutLicenseRequest(
      productSKU: Option[String] = None,
      checkoutType: Option[String] = None,
      keyFingerprint: Option[String] = None,
      entitlements: Option[List[EntitlementData]] = None,
      clientToken: Option[String] = None,
      beneficiary: Option[String] = None,
      nodeId: Option[String] = None
    ): CheckoutLicenseRequest =
      CheckoutLicenseRequest
        .builder
        .ifSome(productSKU)(_.productSKU(_))
        .ifSome(checkoutType)(_.checkoutType(_))
        .ifSome(keyFingerprint)(_.keyFingerprint(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(beneficiary)(_.beneficiary(_))
        .ifSome(nodeId)(_.nodeId(_))
        .build

    def checkoutLicenseResponse(
      checkoutType: Option[String] = None,
      licenseConsumptionToken: Option[String] = None,
      entitlementsAllowed: Option[List[EntitlementData]] = None,
      signedToken: Option[String] = None,
      nodeId: Option[String] = None,
      issuedAt: Option[String] = None,
      expiration: Option[String] = None
    ): CheckoutLicenseResponse =
      CheckoutLicenseResponse
        .builder
        .ifSome(checkoutType)(_.checkoutType(_))
        .ifSome(licenseConsumptionToken)(_.licenseConsumptionToken(_))
        .ifSome(entitlementsAllowed)(_.entitlementsAllowed(_))
        .ifSome(signedToken)(_.signedToken(_))
        .ifSome(nodeId)(_.nodeId(_))
        .ifSome(issuedAt)(_.issuedAt(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def consumedLicenseSummary(
      resourceType: Option[String] = None,
      consumedLicenses: Option[BoxLong] = None
    ): ConsumedLicenseSummary =
      ConsumedLicenseSummary
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(consumedLicenses)(_.consumedLicenses(_))
        .build

    def consumptionConfiguration(
      renewType: Option[String] = None,
      provisionalConfiguration: Option[ProvisionalConfiguration] = None,
      borrowConfiguration: Option[BorrowConfiguration] = None
    ): ConsumptionConfiguration =
      ConsumptionConfiguration
        .builder
        .ifSome(renewType)(_.renewType(_))
        .ifSome(provisionalConfiguration)(_.provisionalConfiguration(_))
        .ifSome(borrowConfiguration)(_.borrowConfiguration(_))
        .build

    def createGrantRequest(
      clientToken: Option[String] = None,
      grantName: Option[String] = None,
      licenseArn: Option[String] = None,
      principals: Option[List[Arn]] = None,
      homeRegion: Option[String] = None,
      allowedOperations: Option[List[AllowedOperation]] = None
    ): CreateGrantRequest =
      CreateGrantRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(grantName)(_.grantName(_))
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(allowedOperations)(_.allowedOperations(_))
        .build

    def createGrantResponse(
      grantArn: Option[String] = None,
      status: Option[String] = None,
      version: Option[String] = None
    ): CreateGrantResponse =
      CreateGrantResponse
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(version)(_.version(_))
        .build

    def createGrantVersionRequest(
      clientToken: Option[String] = None,
      grantArn: Option[String] = None,
      grantName: Option[String] = None,
      allowedOperations: Option[List[AllowedOperation]] = None,
      status: Option[String] = None,
      sourceVersion: Option[String] = None
    ): CreateGrantVersionRequest =
      CreateGrantVersionRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(grantName)(_.grantName(_))
        .ifSome(allowedOperations)(_.allowedOperations(_))
        .ifSome(status)(_.status(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .build

    def createGrantVersionResponse(
      grantArn: Option[String] = None,
      status: Option[String] = None,
      version: Option[String] = None
    ): CreateGrantVersionResponse =
      CreateGrantVersionResponse
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(version)(_.version(_))
        .build

    def createLicenseConfigurationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      licenseCountingType: Option[String] = None,
      licenseCount: Option[BoxLong] = None,
      licenseCountHardLimit: Option[Boolean] = None,
      licenseRules: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      disassociateWhenNotFound: Option[Boolean] = None,
      productInformationList: Option[List[ProductInformation]] = None
    ): CreateLicenseConfigurationRequest =
      CreateLicenseConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(licenseCountingType)(_.licenseCountingType(_))
        .ifSome(licenseCount)(_.licenseCount(_))
        .ifSome(licenseCountHardLimit)(_.licenseCountHardLimit(_))
        .ifSome(licenseRules)(_.licenseRules(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(disassociateWhenNotFound)(_.disassociateWhenNotFound(_))
        .ifSome(productInformationList)(_.productInformationList(_))
        .build

    def createLicenseConfigurationResponse(
      licenseConfigurationArn: Option[String] = None
    ): CreateLicenseConfigurationResponse =
      CreateLicenseConfigurationResponse
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def createLicenseManagerReportGeneratorRequest(
      reportGeneratorName: Option[String] = None,
      `type`: Option[List[ReportType]] = None,
      reportContext: Option[ReportContext] = None,
      reportFrequency: Option[ReportFrequency] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateLicenseManagerReportGeneratorRequest =
      CreateLicenseManagerReportGeneratorRequest
        .builder
        .ifSome(reportGeneratorName)(_.reportGeneratorName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(reportContext)(_.reportContext(_))
        .ifSome(reportFrequency)(_.reportFrequency(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLicenseManagerReportGeneratorResponse(
      licenseManagerReportGeneratorArn: Option[String] = None
    ): CreateLicenseManagerReportGeneratorResponse =
      CreateLicenseManagerReportGeneratorResponse
        .builder
        .ifSome(licenseManagerReportGeneratorArn)(_.licenseManagerReportGeneratorArn(_))
        .build

    def createLicenseRequest(
      licenseName: Option[String] = None,
      productName: Option[String] = None,
      productSKU: Option[String] = None,
      issuer: Option[Issuer] = None,
      homeRegion: Option[String] = None,
      validity: Option[DatetimeRange] = None,
      entitlements: Option[List[Entitlement]] = None,
      beneficiary: Option[String] = None,
      consumptionConfiguration: Option[ConsumptionConfiguration] = None,
      licenseMetadata: Option[List[Metadata]] = None,
      clientToken: Option[String] = None
    ): CreateLicenseRequest =
      CreateLicenseRequest
        .builder
        .ifSome(licenseName)(_.licenseName(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(productSKU)(_.productSKU(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(beneficiary)(_.beneficiary(_))
        .ifSome(consumptionConfiguration)(_.consumptionConfiguration(_))
        .ifSome(licenseMetadata)(_.licenseMetadata(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createLicenseResponse(
      licenseArn: Option[String] = None,
      status: Option[String] = None,
      version: Option[String] = None
    ): CreateLicenseResponse =
      CreateLicenseResponse
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(version)(_.version(_))
        .build

    def createLicenseVersionRequest(
      licenseArn: Option[String] = None,
      licenseName: Option[String] = None,
      productName: Option[String] = None,
      issuer: Option[Issuer] = None,
      homeRegion: Option[String] = None,
      validity: Option[DatetimeRange] = None,
      licenseMetadata: Option[List[Metadata]] = None,
      entitlements: Option[List[Entitlement]] = None,
      consumptionConfiguration: Option[ConsumptionConfiguration] = None,
      status: Option[String] = None,
      clientToken: Option[String] = None,
      sourceVersion: Option[String] = None
    ): CreateLicenseVersionRequest =
      CreateLicenseVersionRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(licenseName)(_.licenseName(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(licenseMetadata)(_.licenseMetadata(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(consumptionConfiguration)(_.consumptionConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .build

    def createLicenseVersionResponse(
      licenseArn: Option[String] = None,
      version: Option[String] = None,
      status: Option[String] = None
    ): CreateLicenseVersionResponse =
      CreateLicenseVersionResponse
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .build

    def createTokenRequest(
      licenseArn: Option[String] = None,
      roleArns: Option[List[Arn]] = None,
      expirationInDays: Option[Int] = None,
      tokenProperties: Option[List[String]] = None,
      clientToken: Option[String] = None
    ): CreateTokenRequest =
      CreateTokenRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(roleArns)(_.roleArns(_))
        .ifSome(expirationInDays)(_.expirationInDays(_))
        .ifSome(tokenProperties)(_.tokenProperties(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createTokenResponse(
      tokenId: Option[String] = None,
      tokenType: Option[String] = None,
      token: Option[String] = None
    ): CreateTokenResponse =
      CreateTokenResponse
        .builder
        .ifSome(tokenId)(_.tokenId(_))
        .ifSome(tokenType)(_.tokenType(_))
        .ifSome(token)(_.token(_))
        .build

    def datetimeRange(
      begin: Option[String] = None,
      end: Option[String] = None
    ): DatetimeRange =
      DatetimeRange
        .builder
        .ifSome(begin)(_.begin(_))
        .ifSome(end)(_.end(_))
        .build

    def deleteGrantRequest(
      grantArn: Option[String] = None,
      version: Option[String] = None
    ): DeleteGrantRequest =
      DeleteGrantRequest
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteGrantResponse(
      grantArn: Option[String] = None,
      status: Option[String] = None,
      version: Option[String] = None
    ): DeleteGrantResponse =
      DeleteGrantResponse
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(version)(_.version(_))
        .build

    def deleteLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None
    ): DeleteLicenseConfigurationRequest =
      DeleteLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def deleteLicenseConfigurationResponse(

    ): DeleteLicenseConfigurationResponse =
      DeleteLicenseConfigurationResponse
        .builder

        .build

    def deleteLicenseManagerReportGeneratorRequest(
      licenseManagerReportGeneratorArn: Option[String] = None
    ): DeleteLicenseManagerReportGeneratorRequest =
      DeleteLicenseManagerReportGeneratorRequest
        .builder
        .ifSome(licenseManagerReportGeneratorArn)(_.licenseManagerReportGeneratorArn(_))
        .build

    def deleteLicenseManagerReportGeneratorResponse(

    ): DeleteLicenseManagerReportGeneratorResponse =
      DeleteLicenseManagerReportGeneratorResponse
        .builder

        .build

    def deleteLicenseRequest(
      licenseArn: Option[String] = None,
      sourceVersion: Option[String] = None
    ): DeleteLicenseRequest =
      DeleteLicenseRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .build

    def deleteLicenseResponse(
      status: Option[String] = None,
      deletionDate: Option[String] = None
    ): DeleteLicenseResponse =
      DeleteLicenseResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .build

    def deleteTokenRequest(
      tokenId: Option[String] = None
    ): DeleteTokenRequest =
      DeleteTokenRequest
        .builder
        .ifSome(tokenId)(_.tokenId(_))
        .build

    def deleteTokenResponse(

    ): DeleteTokenResponse =
      DeleteTokenResponse
        .builder

        .build

    def entitlement(
      name: Option[String] = None,
      value: Option[String] = None,
      maxCount: Option[Long] = None,
      overage: Option[Boolean] = None,
      unit: Option[String] = None,
      allowCheckIn: Option[Boolean] = None
    ): Entitlement =
      Entitlement
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(maxCount)(_.maxCount(_))
        .ifSome(overage)(_.overage(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(allowCheckIn)(_.allowCheckIn(_))
        .build

    def entitlementData(
      name: Option[String] = None,
      value: Option[String] = None,
      unit: Option[String] = None
    ): EntitlementData =
      EntitlementData
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(unit)(_.unit(_))
        .build

    def entitlementNotAllowedException(
      message: Option[String] = None
    ): EntitlementNotAllowedException =
      EntitlementNotAllowedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entitlementUsage(
      name: Option[String] = None,
      consumedValue: Option[String] = None,
      maxCount: Option[String] = None,
      unit: Option[String] = None
    ): EntitlementUsage =
      EntitlementUsage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(consumedValue)(_.consumedValue(_))
        .ifSome(maxCount)(_.maxCount(_))
        .ifSome(unit)(_.unit(_))
        .build

    def extendLicenseConsumptionRequest(
      licenseConsumptionToken: Option[String] = None
    ): ExtendLicenseConsumptionRequest =
      ExtendLicenseConsumptionRequest
        .builder
        .ifSome(licenseConsumptionToken)(_.licenseConsumptionToken(_))
        .build

    def extendLicenseConsumptionResponse(
      licenseConsumptionToken: Option[String] = None,
      expiration: Option[String] = None
    ): ExtendLicenseConsumptionResponse =
      ExtendLicenseConsumptionResponse
        .builder
        .ifSome(licenseConsumptionToken)(_.licenseConsumptionToken(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def failedDependencyException(
      message: Option[String] = None,
      errorCode: Option[String] = None
    ): FailedDependencyException =
      FailedDependencyException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def filterLimitExceededException(
      message: Option[String] = None
    ): FilterLimitExceededException =
      FilterLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getAccessTokenRequest(
      token: Option[String] = None,
      tokenProperties: Option[List[String]] = None
    ): GetAccessTokenRequest =
      GetAccessTokenRequest
        .builder
        .ifSome(token)(_.token(_))
        .ifSome(tokenProperties)(_.tokenProperties(_))
        .build

    def getAccessTokenResponse(
      accessToken: Option[String] = None
    ): GetAccessTokenResponse =
      GetAccessTokenResponse
        .builder
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def getGrantRequest(
      grantArn: Option[String] = None,
      version: Option[String] = None
    ): GetGrantRequest =
      GetGrantRequest
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(version)(_.version(_))
        .build

    def getGrantResponse(
      grant: Option[Grant] = None
    ): GetGrantResponse =
      GetGrantResponse
        .builder
        .ifSome(grant)(_.grant(_))
        .build

    def getLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None
    ): GetLicenseConfigurationRequest =
      GetLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .build

    def getLicenseConfigurationResponse(
      licenseConfigurationId: Option[String] = None,
      licenseConfigurationArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      licenseCountingType: Option[String] = None,
      licenseRules: Option[List[String]] = None,
      licenseCount: Option[BoxLong] = None,
      licenseCountHardLimit: Option[Boolean] = None,
      consumedLicenses: Option[BoxLong] = None,
      status: Option[String] = None,
      ownerAccountId: Option[String] = None,
      consumedLicenseSummaryList: Option[List[ConsumedLicenseSummary]] = None,
      managedResourceSummaryList: Option[List[ManagedResourceSummary]] = None,
      tags: Option[List[Tag]] = None,
      productInformationList: Option[List[ProductInformation]] = None,
      automatedDiscoveryInformation: Option[AutomatedDiscoveryInformation] = None,
      disassociateWhenNotFound: Option[Boolean] = None
    ): GetLicenseConfigurationResponse =
      GetLicenseConfigurationResponse
        .builder
        .ifSome(licenseConfigurationId)(_.licenseConfigurationId(_))
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(licenseCountingType)(_.licenseCountingType(_))
        .ifSome(licenseRules)(_.licenseRules(_))
        .ifSome(licenseCount)(_.licenseCount(_))
        .ifSome(licenseCountHardLimit)(_.licenseCountHardLimit(_))
        .ifSome(consumedLicenses)(_.consumedLicenses(_))
        .ifSome(status)(_.status(_))
        .ifSome(ownerAccountId)(_.ownerAccountId(_))
        .ifSome(consumedLicenseSummaryList)(_.consumedLicenseSummaryList(_))
        .ifSome(managedResourceSummaryList)(_.managedResourceSummaryList(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(productInformationList)(_.productInformationList(_))
        .ifSome(automatedDiscoveryInformation)(_.automatedDiscoveryInformation(_))
        .ifSome(disassociateWhenNotFound)(_.disassociateWhenNotFound(_))
        .build

    def getLicenseManagerReportGeneratorRequest(
      licenseManagerReportGeneratorArn: Option[String] = None
    ): GetLicenseManagerReportGeneratorRequest =
      GetLicenseManagerReportGeneratorRequest
        .builder
        .ifSome(licenseManagerReportGeneratorArn)(_.licenseManagerReportGeneratorArn(_))
        .build

    def getLicenseManagerReportGeneratorResponse(
      reportGenerator: Option[ReportGenerator] = None
    ): GetLicenseManagerReportGeneratorResponse =
      GetLicenseManagerReportGeneratorResponse
        .builder
        .ifSome(reportGenerator)(_.reportGenerator(_))
        .build

    def getLicenseRequest(
      licenseArn: Option[String] = None,
      version: Option[String] = None
    ): GetLicenseRequest =
      GetLicenseRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(version)(_.version(_))
        .build

    def getLicenseResponse(
      license: Option[License] = None
    ): GetLicenseResponse =
      GetLicenseResponse
        .builder
        .ifSome(license)(_.license(_))
        .build

    def getLicenseUsageRequest(
      licenseArn: Option[String] = None
    ): GetLicenseUsageRequest =
      GetLicenseUsageRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .build

    def getLicenseUsageResponse(
      licenseUsage: Option[LicenseUsage] = None
    ): GetLicenseUsageResponse =
      GetLicenseUsageResponse
        .builder
        .ifSome(licenseUsage)(_.licenseUsage(_))
        .build

    def getServiceSettingsRequest(

    ): GetServiceSettingsRequest =
      GetServiceSettingsRequest
        .builder

        .build

    def getServiceSettingsResponse(
      s3BucketArn: Option[String] = None,
      snsTopicArn: Option[String] = None,
      organizationConfiguration: Option[OrganizationConfiguration] = None,
      enableCrossAccountsDiscovery: Option[Boolean] = None,
      licenseManagerResourceShareArn: Option[String] = None
    ): GetServiceSettingsResponse =
      GetServiceSettingsResponse
        .builder
        .ifSome(s3BucketArn)(_.s3BucketArn(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(organizationConfiguration)(_.organizationConfiguration(_))
        .ifSome(enableCrossAccountsDiscovery)(_.enableCrossAccountsDiscovery(_))
        .ifSome(licenseManagerResourceShareArn)(_.licenseManagerResourceShareArn(_))
        .build

    def grant(
      grantArn: Option[String] = None,
      grantName: Option[String] = None,
      parentArn: Option[String] = None,
      licenseArn: Option[String] = None,
      granteePrincipalArn: Option[String] = None,
      homeRegion: Option[String] = None,
      grantStatus: Option[String] = None,
      statusReason: Option[String] = None,
      version: Option[String] = None,
      grantedOperations: Option[List[AllowedOperation]] = None
    ): Grant =
      Grant
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(grantName)(_.grantName(_))
        .ifSome(parentArn)(_.parentArn(_))
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(granteePrincipalArn)(_.granteePrincipalArn(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(grantStatus)(_.grantStatus(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(version)(_.version(_))
        .ifSome(grantedOperations)(_.grantedOperations(_))
        .build

    def grantedLicense(
      licenseArn: Option[String] = None,
      licenseName: Option[String] = None,
      productName: Option[String] = None,
      productSKU: Option[String] = None,
      issuer: Option[IssuerDetails] = None,
      homeRegion: Option[String] = None,
      status: Option[String] = None,
      validity: Option[DatetimeRange] = None,
      beneficiary: Option[String] = None,
      entitlements: Option[List[Entitlement]] = None,
      consumptionConfiguration: Option[ConsumptionConfiguration] = None,
      licenseMetadata: Option[List[Metadata]] = None,
      createTime: Option[String] = None,
      version: Option[String] = None,
      receivedMetadata: Option[ReceivedMetadata] = None
    ): GrantedLicense =
      GrantedLicense
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(licenseName)(_.licenseName(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(productSKU)(_.productSKU(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(status)(_.status(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(beneficiary)(_.beneficiary(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(consumptionConfiguration)(_.consumptionConfiguration(_))
        .ifSome(licenseMetadata)(_.licenseMetadata(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(version)(_.version(_))
        .ifSome(receivedMetadata)(_.receivedMetadata(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResourceStateException(
      message: Option[String] = None
    ): InvalidResourceStateException =
      InvalidResourceStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def inventoryFilter(
      name: Option[String] = None,
      condition: Option[String] = None,
      value: Option[String] = None
    ): InventoryFilter =
      InventoryFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(condition)(_.condition(_))
        .ifSome(value)(_.value(_))
        .build

    def issuer(
      name: Option[String] = None,
      signKey: Option[String] = None
    ): Issuer =
      Issuer
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(signKey)(_.signKey(_))
        .build

    def issuerDetails(
      name: Option[String] = None,
      signKey: Option[String] = None,
      keyFingerprint: Option[String] = None
    ): IssuerDetails =
      IssuerDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(signKey)(_.signKey(_))
        .ifSome(keyFingerprint)(_.keyFingerprint(_))
        .build

    def license(
      licenseArn: Option[String] = None,
      licenseName: Option[String] = None,
      productName: Option[String] = None,
      productSKU: Option[String] = None,
      issuer: Option[IssuerDetails] = None,
      homeRegion: Option[String] = None,
      status: Option[String] = None,
      validity: Option[DatetimeRange] = None,
      beneficiary: Option[String] = None,
      entitlements: Option[List[Entitlement]] = None,
      consumptionConfiguration: Option[ConsumptionConfiguration] = None,
      licenseMetadata: Option[List[Metadata]] = None,
      createTime: Option[String] = None,
      version: Option[String] = None
    ): License =
      License
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(licenseName)(_.licenseName(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(productSKU)(_.productSKU(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(status)(_.status(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(beneficiary)(_.beneficiary(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(consumptionConfiguration)(_.consumptionConfiguration(_))
        .ifSome(licenseMetadata)(_.licenseMetadata(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(version)(_.version(_))
        .build

    def licenseConfiguration(
      licenseConfigurationId: Option[String] = None,
      licenseConfigurationArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      licenseCountingType: Option[String] = None,
      licenseRules: Option[List[String]] = None,
      licenseCount: Option[BoxLong] = None,
      licenseCountHardLimit: Option[Boolean] = None,
      disassociateWhenNotFound: Option[Boolean] = None,
      consumedLicenses: Option[BoxLong] = None,
      status: Option[String] = None,
      ownerAccountId: Option[String] = None,
      consumedLicenseSummaryList: Option[List[ConsumedLicenseSummary]] = None,
      managedResourceSummaryList: Option[List[ManagedResourceSummary]] = None,
      productInformationList: Option[List[ProductInformation]] = None,
      automatedDiscoveryInformation: Option[AutomatedDiscoveryInformation] = None
    ): LicenseConfiguration =
      LicenseConfiguration
        .builder
        .ifSome(licenseConfigurationId)(_.licenseConfigurationId(_))
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(licenseCountingType)(_.licenseCountingType(_))
        .ifSome(licenseRules)(_.licenseRules(_))
        .ifSome(licenseCount)(_.licenseCount(_))
        .ifSome(licenseCountHardLimit)(_.licenseCountHardLimit(_))
        .ifSome(disassociateWhenNotFound)(_.disassociateWhenNotFound(_))
        .ifSome(consumedLicenses)(_.consumedLicenses(_))
        .ifSome(status)(_.status(_))
        .ifSome(ownerAccountId)(_.ownerAccountId(_))
        .ifSome(consumedLicenseSummaryList)(_.consumedLicenseSummaryList(_))
        .ifSome(managedResourceSummaryList)(_.managedResourceSummaryList(_))
        .ifSome(productInformationList)(_.productInformationList(_))
        .ifSome(automatedDiscoveryInformation)(_.automatedDiscoveryInformation(_))
        .build

    def licenseConfigurationAssociation(
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      associationTime: Option[DateTime] = None,
      amiAssociationScope: Option[String] = None
    ): LicenseConfigurationAssociation =
      LicenseConfigurationAssociation
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(associationTime)(_.associationTime(_))
        .ifSome(amiAssociationScope)(_.amiAssociationScope(_))
        .build

    def licenseConfigurationUsage(
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      resourceStatus: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      associationTime: Option[DateTime] = None,
      consumedLicenses: Option[BoxLong] = None
    ): LicenseConfigurationUsage =
      LicenseConfigurationUsage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceStatus)(_.resourceStatus(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(associationTime)(_.associationTime(_))
        .ifSome(consumedLicenses)(_.consumedLicenses(_))
        .build

    def licenseOperationFailure(
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      errorMessage: Option[String] = None,
      failureTime: Option[DateTime] = None,
      operationName: Option[String] = None,
      resourceOwnerId: Option[String] = None,
      operationRequestedBy: Option[String] = None,
      metadataList: Option[List[Metadata]] = None
    ): LicenseOperationFailure =
      LicenseOperationFailure
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(failureTime)(_.failureTime(_))
        .ifSome(operationName)(_.operationName(_))
        .ifSome(resourceOwnerId)(_.resourceOwnerId(_))
        .ifSome(operationRequestedBy)(_.operationRequestedBy(_))
        .ifSome(metadataList)(_.metadataList(_))
        .build

    def licenseSpecification(
      licenseConfigurationArn: Option[String] = None,
      amiAssociationScope: Option[String] = None
    ): LicenseSpecification =
      LicenseSpecification
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(amiAssociationScope)(_.amiAssociationScope(_))
        .build

    def licenseUsage(
      entitlementUsages: Option[List[EntitlementUsage]] = None
    ): LicenseUsage =
      LicenseUsage
        .builder
        .ifSome(entitlementUsages)(_.entitlementUsages(_))
        .build

    def licenseUsageException(
      message: Option[String] = None
    ): LicenseUsageException =
      LicenseUsageException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAssociationsForLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAssociationsForLicenseConfigurationRequest =
      ListAssociationsForLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociationsForLicenseConfigurationResponse(
      licenseConfigurationAssociations: Option[List[LicenseConfigurationAssociation]] = None,
      nextToken: Option[String] = None
    ): ListAssociationsForLicenseConfigurationResponse =
      ListAssociationsForLicenseConfigurationResponse
        .builder
        .ifSome(licenseConfigurationAssociations)(_.licenseConfigurationAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDistributedGrantsRequest(
      grantArns: Option[List[Arn]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDistributedGrantsRequest =
      ListDistributedGrantsRequest
        .builder
        .ifSome(grantArns)(_.grantArns(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDistributedGrantsResponse(
      grants: Option[List[Grant]] = None,
      nextToken: Option[String] = None
    ): ListDistributedGrantsResponse =
      ListDistributedGrantsResponse
        .builder
        .ifSome(grants)(_.grants(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFailuresForLicenseConfigurationOperationsRequest(
      licenseConfigurationArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFailuresForLicenseConfigurationOperationsRequest =
      ListFailuresForLicenseConfigurationOperationsRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFailuresForLicenseConfigurationOperationsResponse(
      licenseOperationFailureList: Option[List[LicenseOperationFailure]] = None,
      nextToken: Option[String] = None
    ): ListFailuresForLicenseConfigurationOperationsResponse =
      ListFailuresForLicenseConfigurationOperationsResponse
        .builder
        .ifSome(licenseOperationFailureList)(_.licenseOperationFailureList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLicenseConfigurationsRequest(
      licenseConfigurationArns: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListLicenseConfigurationsRequest =
      ListLicenseConfigurationsRequest
        .builder
        .ifSome(licenseConfigurationArns)(_.licenseConfigurationArns(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listLicenseConfigurationsResponse(
      licenseConfigurations: Option[List[LicenseConfiguration]] = None,
      nextToken: Option[String] = None
    ): ListLicenseConfigurationsResponse =
      ListLicenseConfigurationsResponse
        .builder
        .ifSome(licenseConfigurations)(_.licenseConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLicenseManagerReportGeneratorsRequest(
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLicenseManagerReportGeneratorsRequest =
      ListLicenseManagerReportGeneratorsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLicenseManagerReportGeneratorsResponse(
      reportGenerators: Option[List[ReportGenerator]] = None,
      nextToken: Option[String] = None
    ): ListLicenseManagerReportGeneratorsResponse =
      ListLicenseManagerReportGeneratorsResponse
        .builder
        .ifSome(reportGenerators)(_.reportGenerators(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLicenseSpecificationsForResourceRequest(
      resourceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListLicenseSpecificationsForResourceRequest =
      ListLicenseSpecificationsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLicenseSpecificationsForResourceResponse(
      licenseSpecifications: Option[List[LicenseSpecification]] = None,
      nextToken: Option[String] = None
    ): ListLicenseSpecificationsForResourceResponse =
      ListLicenseSpecificationsForResourceResponse
        .builder
        .ifSome(licenseSpecifications)(_.licenseSpecifications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLicenseVersionsRequest(
      licenseArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLicenseVersionsRequest =
      ListLicenseVersionsRequest
        .builder
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLicenseVersionsResponse(
      licenses: Option[List[License]] = None,
      nextToken: Option[String] = None
    ): ListLicenseVersionsResponse =
      ListLicenseVersionsResponse
        .builder
        .ifSome(licenses)(_.licenses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLicensesRequest(
      licenseArns: Option[List[Arn]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListLicensesRequest =
      ListLicensesRequest
        .builder
        .ifSome(licenseArns)(_.licenseArns(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listLicensesResponse(
      licenses: Option[List[License]] = None,
      nextToken: Option[String] = None
    ): ListLicensesResponse =
      ListLicensesResponse
        .builder
        .ifSome(licenses)(_.licenses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReceivedGrantsRequest(
      grantArns: Option[List[Arn]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListReceivedGrantsRequest =
      ListReceivedGrantsRequest
        .builder
        .ifSome(grantArns)(_.grantArns(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listReceivedGrantsResponse(
      grants: Option[List[Grant]] = None,
      nextToken: Option[String] = None
    ): ListReceivedGrantsResponse =
      ListReceivedGrantsResponse
        .builder
        .ifSome(grants)(_.grants(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReceivedLicensesRequest(
      licenseArns: Option[List[Arn]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListReceivedLicensesRequest =
      ListReceivedLicensesRequest
        .builder
        .ifSome(licenseArns)(_.licenseArns(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listReceivedLicensesResponse(
      licenses: Option[List[GrantedLicense]] = None,
      nextToken: Option[String] = None
    ): ListReceivedLicensesResponse =
      ListReceivedLicensesResponse
        .builder
        .ifSome(licenses)(_.licenses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceInventoryRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[InventoryFilter]] = None
    ): ListResourceInventoryRequest =
      ListResourceInventoryRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listResourceInventoryResponse(
      resourceInventoryList: Option[List[ResourceInventory]] = None,
      nextToken: Option[String] = None
    ): ListResourceInventoryResponse =
      ListResourceInventoryResponse
        .builder
        .ifSome(resourceInventoryList)(_.resourceInventoryList(_))
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
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listTokensRequest(
      tokenIds: Option[List[String]] = None,
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTokensRequest =
      ListTokensRequest
        .builder
        .ifSome(tokenIds)(_.tokenIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTokensResponse(
      tokens: Option[List[TokenData]] = None,
      nextToken: Option[String] = None
    ): ListTokensResponse =
      ListTokensResponse
        .builder
        .ifSome(tokens)(_.tokens(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsageForLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListUsageForLicenseConfigurationRequest =
      ListUsageForLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listUsageForLicenseConfigurationResponse(
      licenseConfigurationUsageList: Option[List[LicenseConfigurationUsage]] = None,
      nextToken: Option[String] = None
    ): ListUsageForLicenseConfigurationResponse =
      ListUsageForLicenseConfigurationResponse
        .builder
        .ifSome(licenseConfigurationUsageList)(_.licenseConfigurationUsageList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def managedResourceSummary(
      resourceType: Option[String] = None,
      associationCount: Option[BoxLong] = None
    ): ManagedResourceSummary =
      ManagedResourceSummary
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(associationCount)(_.associationCount(_))
        .build

    def metadata(
      name: Option[String] = None,
      value: Option[String] = None
    ): Metadata =
      Metadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def noEntitlementsAllowedException(
      message: Option[String] = None
    ): NoEntitlementsAllowedException =
      NoEntitlementsAllowedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationConfiguration(
      enableIntegration: Option[Boolean] = None
    ): OrganizationConfiguration =
      OrganizationConfiguration
        .builder
        .ifSome(enableIntegration)(_.enableIntegration(_))
        .build

    def productInformation(
      resourceType: Option[String] = None,
      productInformationFilterList: Option[List[ProductInformationFilter]] = None
    ): ProductInformation =
      ProductInformation
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(productInformationFilterList)(_.productInformationFilterList(_))
        .build

    def productInformationFilter(
      productInformationFilterName: Option[String] = None,
      productInformationFilterValue: Option[List[String]] = None,
      productInformationFilterComparator: Option[String] = None
    ): ProductInformationFilter =
      ProductInformationFilter
        .builder
        .ifSome(productInformationFilterName)(_.productInformationFilterName(_))
        .ifSome(productInformationFilterValue)(_.productInformationFilterValue(_))
        .ifSome(productInformationFilterComparator)(_.productInformationFilterComparator(_))
        .build

    def provisionalConfiguration(
      maxTimeToLiveInMinutes: Option[Int] = None
    ): ProvisionalConfiguration =
      ProvisionalConfiguration
        .builder
        .ifSome(maxTimeToLiveInMinutes)(_.maxTimeToLiveInMinutes(_))
        .build

    def rateLimitExceededException(
      message: Option[String] = None
    ): RateLimitExceededException =
      RateLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def receivedMetadata(
      receivedStatus: Option[String] = None,
      allowedOperations: Option[List[AllowedOperation]] = None
    ): ReceivedMetadata =
      ReceivedMetadata
        .builder
        .ifSome(receivedStatus)(_.receivedStatus(_))
        .ifSome(allowedOperations)(_.allowedOperations(_))
        .build

    def redirectException(
      location: Option[String] = None,
      message: Option[String] = None
    ): RedirectException =
      RedirectException
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(message)(_.message(_))
        .build

    def rejectGrantRequest(
      grantArn: Option[String] = None
    ): RejectGrantRequest =
      RejectGrantRequest
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .build

    def rejectGrantResponse(
      grantArn: Option[String] = None,
      status: Option[String] = None,
      version: Option[String] = None
    ): RejectGrantResponse =
      RejectGrantResponse
        .builder
        .ifSome(grantArn)(_.grantArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(version)(_.version(_))
        .build

    def reportContext(
      licenseConfigurationArns: Option[List[Arn]] = None
    ): ReportContext =
      ReportContext
        .builder
        .ifSome(licenseConfigurationArns)(_.licenseConfigurationArns(_))
        .build

    def reportFrequency(
      value: Option[Int] = None,
      period: Option[String] = None
    ): ReportFrequency =
      ReportFrequency
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(period)(_.period(_))
        .build

    def reportGenerator(
      reportGeneratorName: Option[String] = None,
      reportType: Option[List[ReportType]] = None,
      reportContext: Option[ReportContext] = None,
      reportFrequency: Option[ReportFrequency] = None,
      licenseManagerReportGeneratorArn: Option[String] = None,
      lastRunStatus: Option[String] = None,
      lastRunFailureReason: Option[String] = None,
      lastReportGenerationTime: Option[String] = None,
      reportCreatorAccount: Option[String] = None,
      description: Option[String] = None,
      s3Location: Option[S3Location] = None,
      createTime: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ReportGenerator =
      ReportGenerator
        .builder
        .ifSome(reportGeneratorName)(_.reportGeneratorName(_))
        .ifSome(reportType)(_.reportType(_))
        .ifSome(reportContext)(_.reportContext(_))
        .ifSome(reportFrequency)(_.reportFrequency(_))
        .ifSome(licenseManagerReportGeneratorArn)(_.licenseManagerReportGeneratorArn(_))
        .ifSome(lastRunStatus)(_.lastRunStatus(_))
        .ifSome(lastRunFailureReason)(_.lastRunFailureReason(_))
        .ifSome(lastReportGenerationTime)(_.lastReportGenerationTime(_))
        .ifSome(reportCreatorAccount)(_.reportCreatorAccount(_))
        .ifSome(description)(_.description(_))
        .ifSome(s3Location)(_.s3Location(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceInventory(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceArn: Option[String] = None,
      platform: Option[String] = None,
      platformVersion: Option[String] = None,
      resourceOwningAccountId: Option[String] = None
    ): ResourceInventory =
      ResourceInventory
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(resourceOwningAccountId)(_.resourceOwningAccountId(_))
        .build

    def resourceLimitExceededException(
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
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

    def s3Location(
      bucket: Option[String] = None,
      keyPrefix: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .build

    def serverInternalException(
      message: Option[String] = None
    ): ServerInternalException =
      ServerInternalException
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

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def tokenData(
      tokenId: Option[String] = None,
      tokenType: Option[String] = None,
      licenseArn: Option[String] = None,
      expirationTime: Option[String] = None,
      tokenProperties: Option[List[String]] = None,
      roleArns: Option[List[Arn]] = None,
      status: Option[String] = None
    ): TokenData =
      TokenData
        .builder
        .ifSome(tokenId)(_.tokenId(_))
        .ifSome(tokenType)(_.tokenType(_))
        .ifSome(licenseArn)(_.licenseArn(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(tokenProperties)(_.tokenProperties(_))
        .ifSome(roleArns)(_.roleArns(_))
        .ifSome(status)(_.status(_))
        .build

    def unsupportedDigitalSignatureMethodException(
      message: Option[String] = None
    ): UnsupportedDigitalSignatureMethodException =
      UnsupportedDigitalSignatureMethodException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
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

    def updateLicenseConfigurationRequest(
      licenseConfigurationArn: Option[String] = None,
      licenseConfigurationStatus: Option[String] = None,
      licenseRules: Option[List[String]] = None,
      licenseCount: Option[BoxLong] = None,
      licenseCountHardLimit: Option[Boolean] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      productInformationList: Option[List[ProductInformation]] = None,
      disassociateWhenNotFound: Option[Boolean] = None
    ): UpdateLicenseConfigurationRequest =
      UpdateLicenseConfigurationRequest
        .builder
        .ifSome(licenseConfigurationArn)(_.licenseConfigurationArn(_))
        .ifSome(licenseConfigurationStatus)(_.licenseConfigurationStatus(_))
        .ifSome(licenseRules)(_.licenseRules(_))
        .ifSome(licenseCount)(_.licenseCount(_))
        .ifSome(licenseCountHardLimit)(_.licenseCountHardLimit(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(productInformationList)(_.productInformationList(_))
        .ifSome(disassociateWhenNotFound)(_.disassociateWhenNotFound(_))
        .build

    def updateLicenseConfigurationResponse(

    ): UpdateLicenseConfigurationResponse =
      UpdateLicenseConfigurationResponse
        .builder

        .build

    def updateLicenseManagerReportGeneratorRequest(
      licenseManagerReportGeneratorArn: Option[String] = None,
      reportGeneratorName: Option[String] = None,
      `type`: Option[List[ReportType]] = None,
      reportContext: Option[ReportContext] = None,
      reportFrequency: Option[ReportFrequency] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None
    ): UpdateLicenseManagerReportGeneratorRequest =
      UpdateLicenseManagerReportGeneratorRequest
        .builder
        .ifSome(licenseManagerReportGeneratorArn)(_.licenseManagerReportGeneratorArn(_))
        .ifSome(reportGeneratorName)(_.reportGeneratorName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(reportContext)(_.reportContext(_))
        .ifSome(reportFrequency)(_.reportFrequency(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .build

    def updateLicenseManagerReportGeneratorResponse(

    ): UpdateLicenseManagerReportGeneratorResponse =
      UpdateLicenseManagerReportGeneratorResponse
        .builder

        .build

    def updateLicenseSpecificationsForResourceRequest(
      resourceArn: Option[String] = None,
      addLicenseSpecifications: Option[List[LicenseSpecification]] = None,
      removeLicenseSpecifications: Option[List[LicenseSpecification]] = None
    ): UpdateLicenseSpecificationsForResourceRequest =
      UpdateLicenseSpecificationsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(addLicenseSpecifications)(_.addLicenseSpecifications(_))
        .ifSome(removeLicenseSpecifications)(_.removeLicenseSpecifications(_))
        .build

    def updateLicenseSpecificationsForResourceResponse(

    ): UpdateLicenseSpecificationsForResourceResponse =
      UpdateLicenseSpecificationsForResourceResponse
        .builder

        .build

    def updateServiceSettingsRequest(
      s3BucketArn: Option[String] = None,
      snsTopicArn: Option[String] = None,
      organizationConfiguration: Option[OrganizationConfiguration] = None,
      enableCrossAccountsDiscovery: Option[Boolean] = None
    ): UpdateServiceSettingsRequest =
      UpdateServiceSettingsRequest
        .builder
        .ifSome(s3BucketArn)(_.s3BucketArn(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(organizationConfiguration)(_.organizationConfiguration(_))
        .ifSome(enableCrossAccountsDiscovery)(_.enableCrossAccountsDiscovery(_))
        .build

    def updateServiceSettingsResponse(

    ): UpdateServiceSettingsResponse =
      UpdateServiceSettingsResponse
        .builder

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
