package goober.hi

import goober.free.route53domains.Route53DomainsIO
import software.amazon.awssdk.services.route53domains.model._


object route53domains {
  import goober.free.{route53domains ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptDomainTransferFromAnotherAwsAccountRequest(
      domainName: Option[String] = None,
      password: Option[String] = None
    ): AcceptDomainTransferFromAnotherAwsAccountRequest =
      AcceptDomainTransferFromAnotherAwsAccountRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(password)(_.password(_))
        .build

    def acceptDomainTransferFromAnotherAwsAccountResponse(
      operationId: Option[String] = None
    ): AcceptDomainTransferFromAnotherAwsAccountResponse =
      AcceptDomainTransferFromAnotherAwsAccountResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def billingRecord(
      domainName: Option[String] = None,
      operation: Option[String] = None,
      invoiceId: Option[String] = None,
      billDate: Option[Timestamp] = None,
      price: Option[Price] = None
    ): BillingRecord =
      BillingRecord
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(invoiceId)(_.invoiceId(_))
        .ifSome(billDate)(_.billDate(_))
        .ifSome(price)(_.price(_))
        .build

    def cancelDomainTransferToAnotherAwsAccountRequest(
      domainName: Option[String] = None
    ): CancelDomainTransferToAnotherAwsAccountRequest =
      CancelDomainTransferToAnotherAwsAccountRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def cancelDomainTransferToAnotherAwsAccountResponse(
      operationId: Option[String] = None
    ): CancelDomainTransferToAnotherAwsAccountResponse =
      CancelDomainTransferToAnotherAwsAccountResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def checkDomainAvailabilityRequest(
      domainName: Option[String] = None,
      idnLangCode: Option[String] = None
    ): CheckDomainAvailabilityRequest =
      CheckDomainAvailabilityRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(idnLangCode)(_.idnLangCode(_))
        .build

    def checkDomainAvailabilityResponse(
      availability: Option[String] = None
    ): CheckDomainAvailabilityResponse =
      CheckDomainAvailabilityResponse
        .builder
        .ifSome(availability)(_.availability(_))
        .build

    def checkDomainTransferabilityRequest(
      domainName: Option[String] = None,
      authCode: Option[String] = None
    ): CheckDomainTransferabilityRequest =
      CheckDomainTransferabilityRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(authCode)(_.authCode(_))
        .build

    def checkDomainTransferabilityResponse(
      transferability: Option[DomainTransferability] = None
    ): CheckDomainTransferabilityResponse =
      CheckDomainTransferabilityResponse
        .builder
        .ifSome(transferability)(_.transferability(_))
        .build

    def contactDetail(
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      contactType: Option[String] = None,
      organizationName: Option[String] = None,
      addressLine1: Option[String] = None,
      addressLine2: Option[String] = None,
      city: Option[String] = None,
      state: Option[String] = None,
      countryCode: Option[String] = None,
      zipCode: Option[String] = None,
      phoneNumber: Option[String] = None,
      email: Option[String] = None,
      fax: Option[String] = None,
      extraParams: Option[List[ExtraParam]] = None
    ): ContactDetail =
      ContactDetail
        .builder
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(contactType)(_.contactType(_))
        .ifSome(organizationName)(_.organizationName(_))
        .ifSome(addressLine1)(_.addressLine1(_))
        .ifSome(addressLine2)(_.addressLine2(_))
        .ifSome(city)(_.city(_))
        .ifSome(state)(_.state(_))
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(zipCode)(_.zipCode(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(email)(_.email(_))
        .ifSome(fax)(_.fax(_))
        .ifSome(extraParams)(_.extraParams(_))
        .build

    def deleteTagsForDomainRequest(
      domainName: Option[String] = None,
      tagsToDelete: Option[List[TagKey]] = None
    ): DeleteTagsForDomainRequest =
      DeleteTagsForDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(tagsToDelete)(_.tagsToDelete(_))
        .build

    def deleteTagsForDomainResponse(

    ): DeleteTagsForDomainResponse =
      DeleteTagsForDomainResponse
        .builder

        .build

    def disableDomainAutoRenewRequest(
      domainName: Option[String] = None
    ): DisableDomainAutoRenewRequest =
      DisableDomainAutoRenewRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def disableDomainAutoRenewResponse(

    ): DisableDomainAutoRenewResponse =
      DisableDomainAutoRenewResponse
        .builder

        .build

    def disableDomainTransferLockRequest(
      domainName: Option[String] = None
    ): DisableDomainTransferLockRequest =
      DisableDomainTransferLockRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def disableDomainTransferLockResponse(
      operationId: Option[String] = None
    ): DisableDomainTransferLockResponse =
      DisableDomainTransferLockResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def domainLimitExceeded(
      message: Option[String] = None
    ): DomainLimitExceeded =
      DomainLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def domainSuggestion(
      domainName: Option[String] = None,
      availability: Option[String] = None
    ): DomainSuggestion =
      DomainSuggestion
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(availability)(_.availability(_))
        .build

    def domainSummary(
      domainName: Option[String] = None,
      autoRenew: Option[Boolean] = None,
      transferLock: Option[Boolean] = None,
      expiry: Option[Timestamp] = None
    ): DomainSummary =
      DomainSummary
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(autoRenew)(_.autoRenew(_))
        .ifSome(transferLock)(_.transferLock(_))
        .ifSome(expiry)(_.expiry(_))
        .build

    def domainTransferability(
      transferable: Option[String] = None
    ): DomainTransferability =
      DomainTransferability
        .builder
        .ifSome(transferable)(_.transferable(_))
        .build

    def duplicateRequest(
      message: Option[String] = None
    ): DuplicateRequest =
      DuplicateRequest
        .builder
        .ifSome(message)(_.message(_))
        .build

    def enableDomainAutoRenewRequest(
      domainName: Option[String] = None
    ): EnableDomainAutoRenewRequest =
      EnableDomainAutoRenewRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def enableDomainAutoRenewResponse(

    ): EnableDomainAutoRenewResponse =
      EnableDomainAutoRenewResponse
        .builder

        .build

    def enableDomainTransferLockRequest(
      domainName: Option[String] = None
    ): EnableDomainTransferLockRequest =
      EnableDomainTransferLockRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def enableDomainTransferLockResponse(
      operationId: Option[String] = None
    ): EnableDomainTransferLockResponse =
      EnableDomainTransferLockResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def extraParam(
      name: Option[String] = None,
      value: Option[String] = None
    ): ExtraParam =
      ExtraParam
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def getContactReachabilityStatusRequest(
      domainName: Option[String] = None
    ): GetContactReachabilityStatusRequest =
      GetContactReachabilityStatusRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getContactReachabilityStatusResponse(
      domainName: Option[String] = None,
      status: Option[String] = None
    ): GetContactReachabilityStatusResponse =
      GetContactReachabilityStatusResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(status)(_.status(_))
        .build

    def getDomainDetailRequest(
      domainName: Option[String] = None
    ): GetDomainDetailRequest =
      GetDomainDetailRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getDomainDetailResponse(
      domainName: Option[String] = None,
      nameservers: Option[List[Nameserver]] = None,
      autoRenew: Option[Boolean] = None,
      adminContact: Option[ContactDetail] = None,
      registrantContact: Option[ContactDetail] = None,
      techContact: Option[ContactDetail] = None,
      adminPrivacy: Option[Boolean] = None,
      registrantPrivacy: Option[Boolean] = None,
      techPrivacy: Option[Boolean] = None,
      registrarName: Option[String] = None,
      whoIsServer: Option[String] = None,
      registrarUrl: Option[String] = None,
      abuseContactEmail: Option[String] = None,
      abuseContactPhone: Option[String] = None,
      registryDomainId: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      updatedDate: Option[Timestamp] = None,
      expirationDate: Option[Timestamp] = None,
      reseller: Option[String] = None,
      dnsSec: Option[String] = None,
      statusList: Option[List[DomainStatus]] = None
    ): GetDomainDetailResponse =
      GetDomainDetailResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(nameservers)(_.nameservers(_))
        .ifSome(autoRenew)(_.autoRenew(_))
        .ifSome(adminContact)(_.adminContact(_))
        .ifSome(registrantContact)(_.registrantContact(_))
        .ifSome(techContact)(_.techContact(_))
        .ifSome(adminPrivacy)(_.adminPrivacy(_))
        .ifSome(registrantPrivacy)(_.registrantPrivacy(_))
        .ifSome(techPrivacy)(_.techPrivacy(_))
        .ifSome(registrarName)(_.registrarName(_))
        .ifSome(whoIsServer)(_.whoIsServer(_))
        .ifSome(registrarUrl)(_.registrarUrl(_))
        .ifSome(abuseContactEmail)(_.abuseContactEmail(_))
        .ifSome(abuseContactPhone)(_.abuseContactPhone(_))
        .ifSome(registryDomainId)(_.registryDomainId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(reseller)(_.reseller(_))
        .ifSome(dnsSec)(_.dnsSec(_))
        .ifSome(statusList)(_.statusList(_))
        .build

    def getDomainSuggestionsRequest(
      domainName: Option[String] = None,
      suggestionCount: Option[Int] = None,
      onlyAvailable: Option[Boolean] = None
    ): GetDomainSuggestionsRequest =
      GetDomainSuggestionsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(suggestionCount)(_.suggestionCount(_))
        .ifSome(onlyAvailable)(_.onlyAvailable(_))
        .build

    def getDomainSuggestionsResponse(
      suggestionsList: Option[List[DomainSuggestion]] = None
    ): GetDomainSuggestionsResponse =
      GetDomainSuggestionsResponse
        .builder
        .ifSome(suggestionsList)(_.suggestionsList(_))
        .build

    def getOperationDetailRequest(
      operationId: Option[String] = None
    ): GetOperationDetailRequest =
      GetOperationDetailRequest
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def getOperationDetailResponse(
      operationId: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      domainName: Option[String] = None,
      `type`: Option[String] = None,
      submittedDate: Option[Timestamp] = None
    ): GetOperationDetailResponse =
      GetOperationDetailResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(submittedDate)(_.submittedDate(_))
        .build

    def invalidInput(
      message: Option[String] = None
    ): InvalidInput =
      InvalidInput
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDomainsRequest(
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListDomainsRequest =
      ListDomainsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listDomainsResponse(
      domains: Option[List[DomainSummary]] = None,
      nextPageMarker: Option[String] = None
    ): ListDomainsResponse =
      ListDomainsResponse
        .builder
        .ifSome(domains)(_.domains(_))
        .ifSome(nextPageMarker)(_.nextPageMarker(_))
        .build

    def listOperationsRequest(
      submittedSince: Option[Timestamp] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListOperationsRequest =
      ListOperationsRequest
        .builder
        .ifSome(submittedSince)(_.submittedSince(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listOperationsResponse(
      operations: Option[List[OperationSummary]] = None,
      nextPageMarker: Option[String] = None
    ): ListOperationsResponse =
      ListOperationsResponse
        .builder
        .ifSome(operations)(_.operations(_))
        .ifSome(nextPageMarker)(_.nextPageMarker(_))
        .build

    def listTagsForDomainRequest(
      domainName: Option[String] = None
    ): ListTagsForDomainRequest =
      ListTagsForDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def listTagsForDomainResponse(
      tagList: Option[List[Tag]] = None
    ): ListTagsForDomainResponse =
      ListTagsForDomainResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def nameserver(
      name: Option[String] = None,
      glueIps: Option[List[GlueIp]] = None
    ): Nameserver =
      Nameserver
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(glueIps)(_.glueIps(_))
        .build

    def operationLimitExceeded(
      message: Option[String] = None
    ): OperationLimitExceeded =
      OperationLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def operationSummary(
      operationId: Option[String] = None,
      status: Option[String] = None,
      `type`: Option[String] = None,
      submittedDate: Option[Timestamp] = None
    ): OperationSummary =
      OperationSummary
        .builder
        .ifSome(operationId)(_.operationId(_))
        .ifSome(status)(_.status(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(submittedDate)(_.submittedDate(_))
        .build

    def registerDomainRequest(
      domainName: Option[String] = None,
      idnLangCode: Option[String] = None,
      durationInYears: Option[Int] = None,
      autoRenew: Option[Boolean] = None,
      adminContact: Option[ContactDetail] = None,
      registrantContact: Option[ContactDetail] = None,
      techContact: Option[ContactDetail] = None,
      privacyProtectAdminContact: Option[Boolean] = None,
      privacyProtectRegistrantContact: Option[Boolean] = None,
      privacyProtectTechContact: Option[Boolean] = None
    ): RegisterDomainRequest =
      RegisterDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(idnLangCode)(_.idnLangCode(_))
        .ifSome(durationInYears)(_.durationInYears(_))
        .ifSome(autoRenew)(_.autoRenew(_))
        .ifSome(adminContact)(_.adminContact(_))
        .ifSome(registrantContact)(_.registrantContact(_))
        .ifSome(techContact)(_.techContact(_))
        .ifSome(privacyProtectAdminContact)(_.privacyProtectAdminContact(_))
        .ifSome(privacyProtectRegistrantContact)(_.privacyProtectRegistrantContact(_))
        .ifSome(privacyProtectTechContact)(_.privacyProtectTechContact(_))
        .build

    def registerDomainResponse(
      operationId: Option[String] = None
    ): RegisterDomainResponse =
      RegisterDomainResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def rejectDomainTransferFromAnotherAwsAccountRequest(
      domainName: Option[String] = None
    ): RejectDomainTransferFromAnotherAwsAccountRequest =
      RejectDomainTransferFromAnotherAwsAccountRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def rejectDomainTransferFromAnotherAwsAccountResponse(
      operationId: Option[String] = None
    ): RejectDomainTransferFromAnotherAwsAccountResponse =
      RejectDomainTransferFromAnotherAwsAccountResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def renewDomainRequest(
      domainName: Option[String] = None,
      durationInYears: Option[Int] = None,
      currentExpiryYear: Option[Int] = None
    ): RenewDomainRequest =
      RenewDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(durationInYears)(_.durationInYears(_))
        .ifSome(currentExpiryYear)(_.currentExpiryYear(_))
        .build

    def renewDomainResponse(
      operationId: Option[String] = None
    ): RenewDomainResponse =
      RenewDomainResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def resendContactReachabilityEmailRequest(
      domainName: Option[String] = None
    ): ResendContactReachabilityEmailRequest =
      ResendContactReachabilityEmailRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def resendContactReachabilityEmailResponse(
      domainName: Option[String] = None,
      emailAddress: Option[String] = None,
      isAlreadyVerified: Option[Boolean] = None
    ): ResendContactReachabilityEmailResponse =
      ResendContactReachabilityEmailResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(isAlreadyVerified)(_.isAlreadyVerified(_))
        .build

    def retrieveDomainAuthCodeRequest(
      domainName: Option[String] = None
    ): RetrieveDomainAuthCodeRequest =
      RetrieveDomainAuthCodeRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def retrieveDomainAuthCodeResponse(
      authCode: Option[String] = None
    ): RetrieveDomainAuthCodeResponse =
      RetrieveDomainAuthCodeResponse
        .builder
        .ifSome(authCode)(_.authCode(_))
        .build

    def tLDRulesViolation(
      message: Option[String] = None
    ): TLDRulesViolation =
      TLDRulesViolation
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

    def transferDomainRequest(
      domainName: Option[String] = None,
      idnLangCode: Option[String] = None,
      durationInYears: Option[Int] = None,
      nameservers: Option[List[Nameserver]] = None,
      authCode: Option[String] = None,
      autoRenew: Option[Boolean] = None,
      adminContact: Option[ContactDetail] = None,
      registrantContact: Option[ContactDetail] = None,
      techContact: Option[ContactDetail] = None,
      privacyProtectAdminContact: Option[Boolean] = None,
      privacyProtectRegistrantContact: Option[Boolean] = None,
      privacyProtectTechContact: Option[Boolean] = None
    ): TransferDomainRequest =
      TransferDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(idnLangCode)(_.idnLangCode(_))
        .ifSome(durationInYears)(_.durationInYears(_))
        .ifSome(nameservers)(_.nameservers(_))
        .ifSome(authCode)(_.authCode(_))
        .ifSome(autoRenew)(_.autoRenew(_))
        .ifSome(adminContact)(_.adminContact(_))
        .ifSome(registrantContact)(_.registrantContact(_))
        .ifSome(techContact)(_.techContact(_))
        .ifSome(privacyProtectAdminContact)(_.privacyProtectAdminContact(_))
        .ifSome(privacyProtectRegistrantContact)(_.privacyProtectRegistrantContact(_))
        .ifSome(privacyProtectTechContact)(_.privacyProtectTechContact(_))
        .build

    def transferDomainResponse(
      operationId: Option[String] = None
    ): TransferDomainResponse =
      TransferDomainResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def transferDomainToAnotherAwsAccountRequest(
      domainName: Option[String] = None,
      accountId: Option[String] = None
    ): TransferDomainToAnotherAwsAccountRequest =
      TransferDomainToAnotherAwsAccountRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def transferDomainToAnotherAwsAccountResponse(
      operationId: Option[String] = None,
      password: Option[String] = None
    ): TransferDomainToAnotherAwsAccountResponse =
      TransferDomainToAnotherAwsAccountResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .ifSome(password)(_.password(_))
        .build

    def unsupportedTLD(
      message: Option[String] = None
    ): UnsupportedTLD =
      UnsupportedTLD
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateDomainContactPrivacyRequest(
      domainName: Option[String] = None,
      adminPrivacy: Option[Boolean] = None,
      registrantPrivacy: Option[Boolean] = None,
      techPrivacy: Option[Boolean] = None
    ): UpdateDomainContactPrivacyRequest =
      UpdateDomainContactPrivacyRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(adminPrivacy)(_.adminPrivacy(_))
        .ifSome(registrantPrivacy)(_.registrantPrivacy(_))
        .ifSome(techPrivacy)(_.techPrivacy(_))
        .build

    def updateDomainContactPrivacyResponse(
      operationId: Option[String] = None
    ): UpdateDomainContactPrivacyResponse =
      UpdateDomainContactPrivacyResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def updateDomainContactRequest(
      domainName: Option[String] = None,
      adminContact: Option[ContactDetail] = None,
      registrantContact: Option[ContactDetail] = None,
      techContact: Option[ContactDetail] = None
    ): UpdateDomainContactRequest =
      UpdateDomainContactRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(adminContact)(_.adminContact(_))
        .ifSome(registrantContact)(_.registrantContact(_))
        .ifSome(techContact)(_.techContact(_))
        .build

    def updateDomainContactResponse(
      operationId: Option[String] = None
    ): UpdateDomainContactResponse =
      UpdateDomainContactResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def updateDomainNameserversRequest(
      domainName: Option[String] = None,
      fIAuthKey: Option[String] = None,
      nameservers: Option[List[Nameserver]] = None
    ): UpdateDomainNameserversRequest =
      UpdateDomainNameserversRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(fIAuthKey)(_.fIAuthKey(_))
        .ifSome(nameservers)(_.nameservers(_))
        .build

    def updateDomainNameserversResponse(
      operationId: Option[String] = None
    ): UpdateDomainNameserversResponse =
      UpdateDomainNameserversResponse
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def updateTagsForDomainRequest(
      domainName: Option[String] = None,
      tagsToUpdate: Option[List[Tag]] = None
    ): UpdateTagsForDomainRequest =
      UpdateTagsForDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(tagsToUpdate)(_.tagsToUpdate(_))
        .build

    def updateTagsForDomainResponse(

    ): UpdateTagsForDomainResponse =
      UpdateTagsForDomainResponse
        .builder

        .build

    def viewBillingRequest(
      start: Option[Timestamp] = None,
      end: Option[Timestamp] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ViewBillingRequest =
      ViewBillingRequest
        .builder
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def viewBillingResponse(
      nextPageMarker: Option[String] = None,
      billingRecords: Option[List[BillingRecord]] = None
    ): ViewBillingResponse =
      ViewBillingResponse
        .builder
        .ifSome(nextPageMarker)(_.nextPageMarker(_))
        .ifSome(billingRecords)(_.billingRecords(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
