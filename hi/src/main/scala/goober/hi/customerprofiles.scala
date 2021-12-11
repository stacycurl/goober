package goober.hi

import goober.free.customerprofiles.CustomerProfilesIO
import software.amazon.awssdk.services.customerprofiles.model._


object customerprofiles {
  import goober.free.{customerprofiles ⇒ free}

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

    def addProfileKeyRequest(
      profileId: Option[String] = None,
      keyName: Option[String] = None,
      values: Option[List[string1To255]] = None,
      domainName: Option[String] = None
    ): AddProfileKeyRequest =
      AddProfileKeyRequest
        .builder
        .ifSome(profileId)(_.profileId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(values)(_.values(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def addProfileKeyResponse(
      keyName: Option[String] = None,
      values: Option[List[string1To255]] = None
    ): AddProfileKeyResponse =
      AddProfileKeyResponse
        .builder
        .ifSome(keyName)(_.keyName(_))
        .ifSome(values)(_.values(_))
        .build

    def address(
      address1: Option[String] = None,
      address2: Option[String] = None,
      address3: Option[String] = None,
      address4: Option[String] = None,
      city: Option[String] = None,
      county: Option[String] = None,
      state: Option[String] = None,
      province: Option[String] = None,
      country: Option[String] = None,
      postalCode: Option[String] = None
    ): Address =
      Address
        .builder
        .ifSome(address1)(_.address1(_))
        .ifSome(address2)(_.address2(_))
        .ifSome(address3)(_.address3(_))
        .ifSome(address4)(_.address4(_))
        .ifSome(city)(_.city(_))
        .ifSome(county)(_.county(_))
        .ifSome(state)(_.state(_))
        .ifSome(province)(_.province(_))
        .ifSome(country)(_.country(_))
        .ifSome(postalCode)(_.postalCode(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connectorOperator(
      marketo: Option[String] = None,
      s3: Option[String] = None,
      salesforce: Option[String] = None,
      serviceNow: Option[String] = None,
      zendesk: Option[String] = None
    ): ConnectorOperator =
      ConnectorOperator
        .builder
        .ifSome(marketo)(_.marketo(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def createDomainRequest(
      domainName: Option[String] = None,
      defaultExpirationDays: Option[Int] = None,
      defaultEncryptionKey: Option[String] = None,
      deadLetterQueueUrl: Option[String] = None,
      matching: Option[MatchingRequest] = None,
      tags: Option[TagMap] = None
    ): CreateDomainRequest =
      CreateDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(defaultExpirationDays)(_.defaultExpirationDays(_))
        .ifSome(defaultEncryptionKey)(_.defaultEncryptionKey(_))
        .ifSome(deadLetterQueueUrl)(_.deadLetterQueueUrl(_))
        .ifSome(matching)(_.matching(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDomainResponse(
      domainName: Option[String] = None,
      defaultExpirationDays: Option[Int] = None,
      defaultEncryptionKey: Option[String] = None,
      deadLetterQueueUrl: Option[String] = None,
      matching: Option[MatchingResponse] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): CreateDomainResponse =
      CreateDomainResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(defaultExpirationDays)(_.defaultExpirationDays(_))
        .ifSome(defaultEncryptionKey)(_.defaultEncryptionKey(_))
        .ifSome(deadLetterQueueUrl)(_.deadLetterQueueUrl(_))
        .ifSome(matching)(_.matching(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProfileRequest(
      domainName: Option[String] = None,
      accountNumber: Option[String] = None,
      additionalInformation: Option[String] = None,
      partyType: Option[String] = None,
      businessName: Option[String] = None,
      firstName: Option[String] = None,
      middleName: Option[String] = None,
      lastName: Option[String] = None,
      birthDate: Option[String] = None,
      gender: Option[String] = None,
      phoneNumber: Option[String] = None,
      mobilePhoneNumber: Option[String] = None,
      homePhoneNumber: Option[String] = None,
      businessPhoneNumber: Option[String] = None,
      emailAddress: Option[String] = None,
      personalEmailAddress: Option[String] = None,
      businessEmailAddress: Option[String] = None,
      address: Option[Address] = None,
      shippingAddress: Option[Address] = None,
      mailingAddress: Option[Address] = None,
      billingAddress: Option[Address] = None,
      attributes: Option[Attributes] = None
    ): CreateProfileRequest =
      CreateProfileRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(accountNumber)(_.accountNumber(_))
        .ifSome(additionalInformation)(_.additionalInformation(_))
        .ifSome(partyType)(_.partyType(_))
        .ifSome(businessName)(_.businessName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(middleName)(_.middleName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(birthDate)(_.birthDate(_))
        .ifSome(gender)(_.gender(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(mobilePhoneNumber)(_.mobilePhoneNumber(_))
        .ifSome(homePhoneNumber)(_.homePhoneNumber(_))
        .ifSome(businessPhoneNumber)(_.businessPhoneNumber(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(personalEmailAddress)(_.personalEmailAddress(_))
        .ifSome(businessEmailAddress)(_.businessEmailAddress(_))
        .ifSome(address)(_.address(_))
        .ifSome(shippingAddress)(_.shippingAddress(_))
        .ifSome(mailingAddress)(_.mailingAddress(_))
        .ifSome(billingAddress)(_.billingAddress(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def createProfileResponse(
      profileId: Option[String] = None
    ): CreateProfileResponse =
      CreateProfileResponse
        .builder
        .ifSome(profileId)(_.profileId(_))
        .build

    def deleteDomainRequest(
      domainName: Option[String] = None
    ): DeleteDomainRequest =
      DeleteDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteDomainResponse(
      message: Option[String] = None
    ): DeleteDomainResponse =
      DeleteDomainResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteIntegrationRequest(
      domainName: Option[String] = None,
      uri: Option[String] = None
    ): DeleteIntegrationRequest =
      DeleteIntegrationRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(uri)(_.uri(_))
        .build

    def deleteIntegrationResponse(
      message: Option[String] = None
    ): DeleteIntegrationResponse =
      DeleteIntegrationResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteProfileKeyRequest(
      profileId: Option[String] = None,
      keyName: Option[String] = None,
      values: Option[List[string1To255]] = None,
      domainName: Option[String] = None
    ): DeleteProfileKeyRequest =
      DeleteProfileKeyRequest
        .builder
        .ifSome(profileId)(_.profileId(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(values)(_.values(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteProfileKeyResponse(
      message: Option[String] = None
    ): DeleteProfileKeyResponse =
      DeleteProfileKeyResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteProfileObjectRequest(
      profileId: Option[String] = None,
      profileObjectUniqueKey: Option[String] = None,
      objectTypeName: Option[String] = None,
      domainName: Option[String] = None
    ): DeleteProfileObjectRequest =
      DeleteProfileObjectRequest
        .builder
        .ifSome(profileId)(_.profileId(_))
        .ifSome(profileObjectUniqueKey)(_.profileObjectUniqueKey(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteProfileObjectResponse(
      message: Option[String] = None
    ): DeleteProfileObjectResponse =
      DeleteProfileObjectResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteProfileObjectTypeRequest(
      domainName: Option[String] = None,
      objectTypeName: Option[String] = None
    ): DeleteProfileObjectTypeRequest =
      DeleteProfileObjectTypeRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .build

    def deleteProfileObjectTypeResponse(
      message: Option[String] = None
    ): DeleteProfileObjectTypeResponse =
      DeleteProfileObjectTypeResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteProfileRequest(
      profileId: Option[String] = None,
      domainName: Option[String] = None
    ): DeleteProfileRequest =
      DeleteProfileRequest
        .builder
        .ifSome(profileId)(_.profileId(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteProfileResponse(
      message: Option[String] = None
    ): DeleteProfileResponse =
      DeleteProfileResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def domainStats(
      profileCount: Option[long] = None,
      meteringProfileCount: Option[long] = None,
      objectCount: Option[long] = None,
      totalSize: Option[long] = None
    ): DomainStats =
      DomainStats
        .builder
        .ifSome(profileCount)(_.profileCount(_))
        .ifSome(meteringProfileCount)(_.meteringProfileCount(_))
        .ifSome(objectCount)(_.objectCount(_))
        .ifSome(totalSize)(_.totalSize(_))
        .build

    def fieldSourceProfileIds(
      accountNumber: Option[String] = None,
      additionalInformation: Option[String] = None,
      partyType: Option[String] = None,
      businessName: Option[String] = None,
      firstName: Option[String] = None,
      middleName: Option[String] = None,
      lastName: Option[String] = None,
      birthDate: Option[String] = None,
      gender: Option[String] = None,
      phoneNumber: Option[String] = None,
      mobilePhoneNumber: Option[String] = None,
      homePhoneNumber: Option[String] = None,
      businessPhoneNumber: Option[String] = None,
      emailAddress: Option[String] = None,
      personalEmailAddress: Option[String] = None,
      businessEmailAddress: Option[String] = None,
      address: Option[String] = None,
      shippingAddress: Option[String] = None,
      mailingAddress: Option[String] = None,
      billingAddress: Option[String] = None,
      attributes: Option[AttributeSourceIdMap] = None
    ): FieldSourceProfileIds =
      FieldSourceProfileIds
        .builder
        .ifSome(accountNumber)(_.accountNumber(_))
        .ifSome(additionalInformation)(_.additionalInformation(_))
        .ifSome(partyType)(_.partyType(_))
        .ifSome(businessName)(_.businessName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(middleName)(_.middleName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(birthDate)(_.birthDate(_))
        .ifSome(gender)(_.gender(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(mobilePhoneNumber)(_.mobilePhoneNumber(_))
        .ifSome(homePhoneNumber)(_.homePhoneNumber(_))
        .ifSome(businessPhoneNumber)(_.businessPhoneNumber(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(personalEmailAddress)(_.personalEmailAddress(_))
        .ifSome(businessEmailAddress)(_.businessEmailAddress(_))
        .ifSome(address)(_.address(_))
        .ifSome(shippingAddress)(_.shippingAddress(_))
        .ifSome(mailingAddress)(_.mailingAddress(_))
        .ifSome(billingAddress)(_.billingAddress(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def flowDefinition(
      description: Option[String] = None,
      flowName: Option[String] = None,
      kmsArn: Option[String] = None,
      sourceFlowConfig: Option[SourceFlowConfig] = None,
      tasks: Option[List[Task]] = None,
      triggerConfig: Option[TriggerConfig] = None
    ): FlowDefinition =
      FlowDefinition
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(flowName)(_.flowName(_))
        .ifSome(kmsArn)(_.kmsArn(_))
        .ifSome(sourceFlowConfig)(_.sourceFlowConfig(_))
        .ifSome(tasks)(_.tasks(_))
        .ifSome(triggerConfig)(_.triggerConfig(_))
        .build

    def getDomainRequest(
      domainName: Option[String] = None
    ): GetDomainRequest =
      GetDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .build

    def getDomainResponse(
      domainName: Option[String] = None,
      defaultExpirationDays: Option[Int] = None,
      defaultEncryptionKey: Option[String] = None,
      deadLetterQueueUrl: Option[String] = None,
      stats: Option[DomainStats] = None,
      matching: Option[MatchingResponse] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): GetDomainResponse =
      GetDomainResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(defaultExpirationDays)(_.defaultExpirationDays(_))
        .ifSome(defaultEncryptionKey)(_.defaultEncryptionKey(_))
        .ifSome(deadLetterQueueUrl)(_.deadLetterQueueUrl(_))
        .ifSome(stats)(_.stats(_))
        .ifSome(matching)(_.matching(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getIntegrationRequest(
      domainName: Option[String] = None,
      uri: Option[String] = None
    ): GetIntegrationRequest =
      GetIntegrationRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(uri)(_.uri(_))
        .build

    def getIntegrationResponse(
      domainName: Option[String] = None,
      uri: Option[String] = None,
      objectTypeName: Option[String] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): GetIntegrationResponse =
      GetIntegrationResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getMatchesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      domainName: Option[String] = None
    ): GetMatchesRequest =
      GetMatchesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def getMatchesResponse(
      nextToken: Option[String] = None,
      matchGenerationDate: Option[timestamp] = None,
      potentialMatches: Option[Int] = None,
      matches: Option[List[MatchItem]] = None
    ): GetMatchesResponse =
      GetMatchesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(matchGenerationDate)(_.matchGenerationDate(_))
        .ifSome(potentialMatches)(_.potentialMatches(_))
        .ifSome(matches)(_.matches(_))
        .build

    def getProfileObjectTypeRequest(
      domainName: Option[String] = None,
      objectTypeName: Option[String] = None
    ): GetProfileObjectTypeRequest =
      GetProfileObjectTypeRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .build

    def getProfileObjectTypeResponse(
      objectTypeName: Option[String] = None,
      description: Option[String] = None,
      templateId: Option[String] = None,
      expirationDays: Option[Int] = None,
      encryptionKey: Option[String] = None,
      allowProfileCreation: Option[Boolean] = None,
      fields: Option[FieldMap] = None,
      keys: Option[KeyMap] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): GetProfileObjectTypeResponse =
      GetProfileObjectTypeResponse
        .builder
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(expirationDays)(_.expirationDays(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(allowProfileCreation)(_.allowProfileCreation(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getProfileObjectTypeTemplateRequest(
      templateId: Option[String] = None
    ): GetProfileObjectTypeTemplateRequest =
      GetProfileObjectTypeTemplateRequest
        .builder
        .ifSome(templateId)(_.templateId(_))
        .build

    def getProfileObjectTypeTemplateResponse(
      templateId: Option[String] = None,
      sourceName: Option[String] = None,
      sourceObject: Option[String] = None,
      allowProfileCreation: Option[Boolean] = None,
      fields: Option[FieldMap] = None,
      keys: Option[KeyMap] = None
    ): GetProfileObjectTypeTemplateResponse =
      GetProfileObjectTypeTemplateResponse
        .builder
        .ifSome(templateId)(_.templateId(_))
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(sourceObject)(_.sourceObject(_))
        .ifSome(allowProfileCreation)(_.allowProfileCreation(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(keys)(_.keys(_))
        .build

    def incrementalPullConfig(
      datetimeTypeFieldName: Option[String] = None
    ): IncrementalPullConfig =
      IncrementalPullConfig
        .builder
        .ifSome(datetimeTypeFieldName)(_.datetimeTypeFieldName(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAccountIntegrationsRequest(
      uri: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccountIntegrationsRequest =
      ListAccountIntegrationsRequest
        .builder
        .ifSome(uri)(_.uri(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAccountIntegrationsResponse(
      items: Option[List[ListIntegrationItem]] = None,
      nextToken: Option[String] = None
    ): ListAccountIntegrationsResponse =
      ListAccountIntegrationsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDomainItem(
      domainName: Option[String] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): ListDomainItem =
      ListDomainItem
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listDomainsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDomainsRequest =
      ListDomainsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDomainsResponse(
      items: Option[List[ListDomainItem]] = None,
      nextToken: Option[String] = None
    ): ListDomainsResponse =
      ListDomainsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIntegrationItem(
      domainName: Option[String] = None,
      uri: Option[String] = None,
      objectTypeName: Option[String] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): ListIntegrationItem =
      ListIntegrationItem
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listIntegrationsRequest(
      domainName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIntegrationsRequest =
      ListIntegrationsRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIntegrationsResponse(
      items: Option[List[ListIntegrationItem]] = None,
      nextToken: Option[String] = None
    ): ListIntegrationsResponse =
      ListIntegrationsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProfileObjectTypeItem(
      objectTypeName: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): ListProfileObjectTypeItem =
      ListProfileObjectTypeItem
        .builder
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listProfileObjectTypeTemplateItem(
      templateId: Option[String] = None,
      sourceName: Option[String] = None,
      sourceObject: Option[String] = None
    ): ListProfileObjectTypeTemplateItem =
      ListProfileObjectTypeTemplateItem
        .builder
        .ifSome(templateId)(_.templateId(_))
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(sourceObject)(_.sourceObject(_))
        .build

    def listProfileObjectTypeTemplatesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProfileObjectTypeTemplatesRequest =
      ListProfileObjectTypeTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProfileObjectTypeTemplatesResponse(
      items: Option[List[ListProfileObjectTypeTemplateItem]] = None,
      nextToken: Option[String] = None
    ): ListProfileObjectTypeTemplatesResponse =
      ListProfileObjectTypeTemplatesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProfileObjectTypesRequest(
      domainName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProfileObjectTypesRequest =
      ListProfileObjectTypesRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProfileObjectTypesResponse(
      items: Option[List[ListProfileObjectTypeItem]] = None,
      nextToken: Option[String] = None
    ): ListProfileObjectTypesResponse =
      ListProfileObjectTypesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProfileObjectsItem(
      objectTypeName: Option[String] = None,
      profileObjectUniqueKey: Option[String] = None,
      object: Option[String] = None
    ): ListProfileObjectsItem =
      ListProfileObjectsItem
        .builder
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(profileObjectUniqueKey)(_.profileObjectUniqueKey(_))
        .ifSome(object)(_.object(_))
        .build

    def listProfileObjectsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      domainName: Option[String] = None,
      objectTypeName: Option[String] = None,
      profileId: Option[String] = None
    ): ListProfileObjectsRequest =
      ListProfileObjectsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(profileId)(_.profileId(_))
        .build

    def listProfileObjectsResponse(
      items: Option[List[ListProfileObjectsItem]] = None,
      nextToken: Option[String] = None
    ): ListProfileObjectsResponse =
      ListProfileObjectsResponse
        .builder
        .ifSome(items)(_.items(_))
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def marketoSourceProperties(
      object: Option[String] = None
    ): MarketoSourceProperties =
      MarketoSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def matchItem(
      matchId: Option[String] = None,
      profileIds: Option[List[uuid]] = None
    ): MatchItem =
      MatchItem
        .builder
        .ifSome(matchId)(_.matchId(_))
        .ifSome(profileIds)(_.profileIds(_))
        .build

    def matchingRequest(
      enabled: Option[Boolean] = None
    ): MatchingRequest =
      MatchingRequest
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def matchingResponse(
      enabled: Option[Boolean] = None
    ): MatchingResponse =
      MatchingResponse
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def mergeProfilesRequest(
      domainName: Option[String] = None,
      mainProfileId: Option[String] = None,
      profileIdsToBeMerged: Option[List[uuid]] = None,
      fieldSourceProfileIds: Option[FieldSourceProfileIds] = None
    ): MergeProfilesRequest =
      MergeProfilesRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(mainProfileId)(_.mainProfileId(_))
        .ifSome(profileIdsToBeMerged)(_.profileIdsToBeMerged(_))
        .ifSome(fieldSourceProfileIds)(_.fieldSourceProfileIds(_))
        .build

    def mergeProfilesResponse(
      message: Option[String] = None
    ): MergeProfilesResponse =
      MergeProfilesResponse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def objectTypeField(
      source: Option[String] = None,
      target: Option[String] = None,
      contentType: Option[String] = None
    ): ObjectTypeField =
      ObjectTypeField
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(target)(_.target(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def objectTypeKey(
      standardIdentifiers: Option[List[StandardIdentifier]] = None,
      fieldNames: Option[List[name]] = None
    ): ObjectTypeKey =
      ObjectTypeKey
        .builder
        .ifSome(standardIdentifiers)(_.standardIdentifiers(_))
        .ifSome(fieldNames)(_.fieldNames(_))
        .build

    def profile(
      profileId: Option[String] = None,
      accountNumber: Option[String] = None,
      additionalInformation: Option[String] = None,
      partyType: Option[String] = None,
      businessName: Option[String] = None,
      firstName: Option[String] = None,
      middleName: Option[String] = None,
      lastName: Option[String] = None,
      birthDate: Option[String] = None,
      gender: Option[String] = None,
      phoneNumber: Option[String] = None,
      mobilePhoneNumber: Option[String] = None,
      homePhoneNumber: Option[String] = None,
      businessPhoneNumber: Option[String] = None,
      emailAddress: Option[String] = None,
      personalEmailAddress: Option[String] = None,
      businessEmailAddress: Option[String] = None,
      address: Option[Address] = None,
      shippingAddress: Option[Address] = None,
      mailingAddress: Option[Address] = None,
      billingAddress: Option[Address] = None,
      attributes: Option[Attributes] = None
    ): Profile =
      Profile
        .builder
        .ifSome(profileId)(_.profileId(_))
        .ifSome(accountNumber)(_.accountNumber(_))
        .ifSome(additionalInformation)(_.additionalInformation(_))
        .ifSome(partyType)(_.partyType(_))
        .ifSome(businessName)(_.businessName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(middleName)(_.middleName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(birthDate)(_.birthDate(_))
        .ifSome(gender)(_.gender(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(mobilePhoneNumber)(_.mobilePhoneNumber(_))
        .ifSome(homePhoneNumber)(_.homePhoneNumber(_))
        .ifSome(businessPhoneNumber)(_.businessPhoneNumber(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(personalEmailAddress)(_.personalEmailAddress(_))
        .ifSome(businessEmailAddress)(_.businessEmailAddress(_))
        .ifSome(address)(_.address(_))
        .ifSome(shippingAddress)(_.shippingAddress(_))
        .ifSome(mailingAddress)(_.mailingAddress(_))
        .ifSome(billingAddress)(_.billingAddress(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def putIntegrationRequest(
      domainName: Option[String] = None,
      uri: Option[String] = None,
      objectTypeName: Option[String] = None,
      tags: Option[TagMap] = None,
      flowDefinition: Option[FlowDefinition] = None
    ): PutIntegrationRequest =
      PutIntegrationRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(flowDefinition)(_.flowDefinition(_))
        .build

    def putIntegrationResponse(
      domainName: Option[String] = None,
      uri: Option[String] = None,
      objectTypeName: Option[String] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): PutIntegrationResponse =
      PutIntegrationResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putProfileObjectRequest(
      objectTypeName: Option[String] = None,
      object: Option[String] = None,
      domainName: Option[String] = None
    ): PutProfileObjectRequest =
      PutProfileObjectRequest
        .builder
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(object)(_.object(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def putProfileObjectResponse(
      profileObjectUniqueKey: Option[String] = None
    ): PutProfileObjectResponse =
      PutProfileObjectResponse
        .builder
        .ifSome(profileObjectUniqueKey)(_.profileObjectUniqueKey(_))
        .build

    def putProfileObjectTypeRequest(
      domainName: Option[String] = None,
      objectTypeName: Option[String] = None,
      description: Option[String] = None,
      templateId: Option[String] = None,
      expirationDays: Option[Int] = None,
      encryptionKey: Option[String] = None,
      allowProfileCreation: Option[Boolean] = None,
      fields: Option[FieldMap] = None,
      keys: Option[KeyMap] = None,
      tags: Option[TagMap] = None
    ): PutProfileObjectTypeRequest =
      PutProfileObjectTypeRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(expirationDays)(_.expirationDays(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(allowProfileCreation)(_.allowProfileCreation(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putProfileObjectTypeResponse(
      objectTypeName: Option[String] = None,
      description: Option[String] = None,
      templateId: Option[String] = None,
      expirationDays: Option[Int] = None,
      encryptionKey: Option[String] = None,
      allowProfileCreation: Option[Boolean] = None,
      fields: Option[FieldMap] = None,
      keys: Option[KeyMap] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): PutProfileObjectTypeResponse =
      PutProfileObjectTypeResponse
        .builder
        .ifSome(objectTypeName)(_.objectTypeName(_))
        .ifSome(description)(_.description(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(expirationDays)(_.expirationDays(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(allowProfileCreation)(_.allowProfileCreation(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3SourceProperties(
      bucketName: Option[String] = None,
      bucketPrefix: Option[String] = None
    ): S3SourceProperties =
      S3SourceProperties
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(bucketPrefix)(_.bucketPrefix(_))
        .build

    def salesforceSourceProperties(
      object: Option[String] = None,
      enableDynamicFieldUpdate: Option[Boolean] = None,
      includeDeletedRecords: Option[Boolean] = None
    ): SalesforceSourceProperties =
      SalesforceSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .ifSome(enableDynamicFieldUpdate)(_.enableDynamicFieldUpdate(_))
        .ifSome(includeDeletedRecords)(_.includeDeletedRecords(_))
        .build

    def scheduledTriggerProperties(
      scheduleExpression: Option[String] = None,
      dataPullMode: Option[String] = None,
      scheduleStartTime: Option[Date] = None,
      scheduleEndTime: Option[Date] = None,
      timezone: Option[String] = None,
      scheduleOffset: Option[ScheduleOffset] = None,
      firstExecutionFrom: Option[Date] = None
    ): ScheduledTriggerProperties =
      ScheduledTriggerProperties
        .builder
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(dataPullMode)(_.dataPullMode(_))
        .ifSome(scheduleStartTime)(_.scheduleStartTime(_))
        .ifSome(scheduleEndTime)(_.scheduleEndTime(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(scheduleOffset)(_.scheduleOffset(_))
        .ifSome(firstExecutionFrom)(_.firstExecutionFrom(_))
        .build

    def searchProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      domainName: Option[String] = None,
      keyName: Option[String] = None,
      values: Option[List[string1To255]] = None
    ): SearchProfilesRequest =
      SearchProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(keyName)(_.keyName(_))
        .ifSome(values)(_.values(_))
        .build

    def searchProfilesResponse(
      items: Option[List[Profile]] = None,
      nextToken: Option[String] = None
    ): SearchProfilesResponse =
      SearchProfilesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def serviceNowSourceProperties(
      object: Option[String] = None
    ): ServiceNowSourceProperties =
      ServiceNowSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

    def sourceConnectorProperties(
      marketo: Option[MarketoSourceProperties] = None,
      s3: Option[S3SourceProperties] = None,
      salesforce: Option[SalesforceSourceProperties] = None,
      serviceNow: Option[ServiceNowSourceProperties] = None,
      zendesk: Option[ZendeskSourceProperties] = None
    ): SourceConnectorProperties =
      SourceConnectorProperties
        .builder
        .ifSome(marketo)(_.marketo(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(serviceNow)(_.serviceNow(_))
        .ifSome(zendesk)(_.zendesk(_))
        .build

    def sourceFlowConfig(
      connectorProfileName: Option[String] = None,
      connectorType: Option[String] = None,
      incrementalPullConfig: Option[IncrementalPullConfig] = None,
      sourceConnectorProperties: Option[SourceConnectorProperties] = None
    ): SourceFlowConfig =
      SourceFlowConfig
        .builder
        .ifSome(connectorProfileName)(_.connectorProfileName(_))
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(incrementalPullConfig)(_.incrementalPullConfig(_))
        .ifSome(sourceConnectorProperties)(_.sourceConnectorProperties(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def task(
      connectorOperator: Option[ConnectorOperator] = None,
      destinationField: Option[String] = None,
      sourceFields: Option[List[stringTo2048]] = None,
      taskProperties: Option[TaskPropertiesMap] = None,
      taskType: Option[String] = None
    ): Task =
      Task
        .builder
        .ifSome(connectorOperator)(_.connectorOperator(_))
        .ifSome(destinationField)(_.destinationField(_))
        .ifSome(sourceFields)(_.sourceFields(_))
        .ifSome(taskProperties)(_.taskProperties(_))
        .ifSome(taskType)(_.taskType(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def triggerConfig(
      triggerType: Option[String] = None,
      triggerProperties: Option[TriggerProperties] = None
    ): TriggerConfig =
      TriggerConfig
        .builder
        .ifSome(triggerType)(_.triggerType(_))
        .ifSome(triggerProperties)(_.triggerProperties(_))
        .build

    def triggerProperties(
      scheduled: Option[ScheduledTriggerProperties] = None
    ): TriggerProperties =
      TriggerProperties
        .builder
        .ifSome(scheduled)(_.scheduled(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
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

    def updateAddress(
      address1: Option[String] = None,
      address2: Option[String] = None,
      address3: Option[String] = None,
      address4: Option[String] = None,
      city: Option[String] = None,
      county: Option[String] = None,
      state: Option[String] = None,
      province: Option[String] = None,
      country: Option[String] = None,
      postalCode: Option[String] = None
    ): UpdateAddress =
      UpdateAddress
        .builder
        .ifSome(address1)(_.address1(_))
        .ifSome(address2)(_.address2(_))
        .ifSome(address3)(_.address3(_))
        .ifSome(address4)(_.address4(_))
        .ifSome(city)(_.city(_))
        .ifSome(county)(_.county(_))
        .ifSome(state)(_.state(_))
        .ifSome(province)(_.province(_))
        .ifSome(country)(_.country(_))
        .ifSome(postalCode)(_.postalCode(_))
        .build

    def updateDomainRequest(
      domainName: Option[String] = None,
      defaultExpirationDays: Option[Int] = None,
      defaultEncryptionKey: Option[String] = None,
      deadLetterQueueUrl: Option[String] = None,
      matching: Option[MatchingRequest] = None,
      tags: Option[TagMap] = None
    ): UpdateDomainRequest =
      UpdateDomainRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(defaultExpirationDays)(_.defaultExpirationDays(_))
        .ifSome(defaultEncryptionKey)(_.defaultEncryptionKey(_))
        .ifSome(deadLetterQueueUrl)(_.deadLetterQueueUrl(_))
        .ifSome(matching)(_.matching(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateDomainResponse(
      domainName: Option[String] = None,
      defaultExpirationDays: Option[Int] = None,
      defaultEncryptionKey: Option[String] = None,
      deadLetterQueueUrl: Option[String] = None,
      matching: Option[MatchingResponse] = None,
      createdAt: Option[timestamp] = None,
      lastUpdatedAt: Option[timestamp] = None,
      tags: Option[TagMap] = None
    ): UpdateDomainResponse =
      UpdateDomainResponse
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(defaultExpirationDays)(_.defaultExpirationDays(_))
        .ifSome(defaultEncryptionKey)(_.defaultEncryptionKey(_))
        .ifSome(deadLetterQueueUrl)(_.deadLetterQueueUrl(_))
        .ifSome(matching)(_.matching(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateProfileRequest(
      domainName: Option[String] = None,
      profileId: Option[String] = None,
      additionalInformation: Option[String] = None,
      accountNumber: Option[String] = None,
      partyType: Option[String] = None,
      businessName: Option[String] = None,
      firstName: Option[String] = None,
      middleName: Option[String] = None,
      lastName: Option[String] = None,
      birthDate: Option[String] = None,
      gender: Option[String] = None,
      phoneNumber: Option[String] = None,
      mobilePhoneNumber: Option[String] = None,
      homePhoneNumber: Option[String] = None,
      businessPhoneNumber: Option[String] = None,
      emailAddress: Option[String] = None,
      personalEmailAddress: Option[String] = None,
      businessEmailAddress: Option[String] = None,
      address: Option[UpdateAddress] = None,
      shippingAddress: Option[UpdateAddress] = None,
      mailingAddress: Option[UpdateAddress] = None,
      billingAddress: Option[UpdateAddress] = None,
      attributes: Option[UpdateAttributes] = None
    ): UpdateProfileRequest =
      UpdateProfileRequest
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(profileId)(_.profileId(_))
        .ifSome(additionalInformation)(_.additionalInformation(_))
        .ifSome(accountNumber)(_.accountNumber(_))
        .ifSome(partyType)(_.partyType(_))
        .ifSome(businessName)(_.businessName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(middleName)(_.middleName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(birthDate)(_.birthDate(_))
        .ifSome(gender)(_.gender(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(mobilePhoneNumber)(_.mobilePhoneNumber(_))
        .ifSome(homePhoneNumber)(_.homePhoneNumber(_))
        .ifSome(businessPhoneNumber)(_.businessPhoneNumber(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(personalEmailAddress)(_.personalEmailAddress(_))
        .ifSome(businessEmailAddress)(_.businessEmailAddress(_))
        .ifSome(address)(_.address(_))
        .ifSome(shippingAddress)(_.shippingAddress(_))
        .ifSome(mailingAddress)(_.mailingAddress(_))
        .ifSome(billingAddress)(_.billingAddress(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def updateProfileResponse(
      profileId: Option[String] = None
    ): UpdateProfileResponse =
      UpdateProfileResponse
        .builder
        .ifSome(profileId)(_.profileId(_))
        .build

    def zendeskSourceProperties(
      object: Option[String] = None
    ): ZendeskSourceProperties =
      ZendeskSourceProperties
        .builder
        .ifSome(object)(_.object(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
