package goober.hi

import goober.free.guardduty.GuardDutyIO
import software.amazon.awssdk.services.guardduty.model._


object guardduty {
  import goober.free.{guardduty ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptInvitationRequest(
      detectorId: Option[String] = None,
      masterId: Option[String] = None,
      invitationId: Option[String] = None
    ): AcceptInvitationRequest =
      AcceptInvitationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(masterId)(_.masterId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .build

    def acceptInvitationResponse(

    ): AcceptInvitationResponse =
      AcceptInvitationResponse
        .builder

        .build

    def accessControlList(
      allowsPublicReadAccess: Option[Boolean] = None,
      allowsPublicWriteAccess: Option[Boolean] = None
    ): AccessControlList =
      AccessControlList
        .builder
        .ifSome(allowsPublicReadAccess)(_.allowsPublicReadAccess(_))
        .ifSome(allowsPublicWriteAccess)(_.allowsPublicWriteAccess(_))
        .build

    def accessKeyDetails(
      accessKeyId: Option[String] = None,
      principalId: Option[String] = None,
      userName: Option[String] = None,
      userType: Option[String] = None
    ): AccessKeyDetails =
      AccessKeyDetails
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(userType)(_.userType(_))
        .build

    def accountDetail(
      accountId: Option[String] = None,
      email: Option[String] = None
    ): AccountDetail =
      AccountDetail
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(email)(_.email(_))
        .build

    def accountLevelPermissions(
      blockPublicAccess: Option[BlockPublicAccess] = None
    ): AccountLevelPermissions =
      AccountLevelPermissions
        .builder
        .ifSome(blockPublicAccess)(_.blockPublicAccess(_))
        .build

    def action(
      actionType: Option[String] = None,
      awsApiCallAction: Option[AwsApiCallAction] = None,
      dnsRequestAction: Option[DnsRequestAction] = None,
      networkConnectionAction: Option[NetworkConnectionAction] = None,
      portProbeAction: Option[PortProbeAction] = None
    ): Action =
      Action
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(awsApiCallAction)(_.awsApiCallAction(_))
        .ifSome(dnsRequestAction)(_.dnsRequestAction(_))
        .ifSome(networkConnectionAction)(_.networkConnectionAction(_))
        .ifSome(portProbeAction)(_.portProbeAction(_))
        .build

    def adminAccount(
      adminAccountId: Option[String] = None,
      adminStatus: Option[String] = None
    ): AdminAccount =
      AdminAccount
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .ifSome(adminStatus)(_.adminStatus(_))
        .build

    def archiveFindingsRequest(
      detectorId: Option[String] = None,
      findingIds: Option[List[FindingId]] = None
    ): ArchiveFindingsRequest =
      ArchiveFindingsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingIds)(_.findingIds(_))
        .build

    def archiveFindingsResponse(

    ): ArchiveFindingsResponse =
      ArchiveFindingsResponse
        .builder

        .build

    def awsApiCallAction(
      api: Option[String] = None,
      callerType: Option[String] = None,
      domainDetails: Option[DomainDetails] = None,
      errorCode: Option[String] = None,
      remoteIpDetails: Option[RemoteIpDetails] = None,
      serviceName: Option[String] = None
    ): AwsApiCallAction =
      AwsApiCallAction
        .builder
        .ifSome(api)(_.api(_))
        .ifSome(callerType)(_.callerType(_))
        .ifSome(domainDetails)(_.domainDetails(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(remoteIpDetails)(_.remoteIpDetails(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def badRequestException(
      message: Option[String] = None,
      `type`: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def blockPublicAccess(
      ignorePublicAcls: Option[Boolean] = None,
      restrictPublicBuckets: Option[Boolean] = None,
      blockPublicAcls: Option[Boolean] = None,
      blockPublicPolicy: Option[Boolean] = None
    ): BlockPublicAccess =
      BlockPublicAccess
        .builder
        .ifSome(ignorePublicAcls)(_.ignorePublicAcls(_))
        .ifSome(restrictPublicBuckets)(_.restrictPublicBuckets(_))
        .ifSome(blockPublicAcls)(_.blockPublicAcls(_))
        .ifSome(blockPublicPolicy)(_.blockPublicPolicy(_))
        .build

    def bucketLevelPermissions(
      accessControlList: Option[AccessControlList] = None,
      bucketPolicy: Option[BucketPolicy] = None,
      blockPublicAccess: Option[BlockPublicAccess] = None
    ): BucketLevelPermissions =
      BucketLevelPermissions
        .builder
        .ifSome(accessControlList)(_.accessControlList(_))
        .ifSome(bucketPolicy)(_.bucketPolicy(_))
        .ifSome(blockPublicAccess)(_.blockPublicAccess(_))
        .build

    def bucketPolicy(
      allowsPublicReadAccess: Option[Boolean] = None,
      allowsPublicWriteAccess: Option[Boolean] = None
    ): BucketPolicy =
      BucketPolicy
        .builder
        .ifSome(allowsPublicReadAccess)(_.allowsPublicReadAccess(_))
        .ifSome(allowsPublicWriteAccess)(_.allowsPublicWriteAccess(_))
        .build

    def city(
      cityName: Option[String] = None
    ): City =
      City
        .builder
        .ifSome(cityName)(_.cityName(_))
        .build

    def condition(
      eq: Option[List[String]] = None,
      neq: Option[List[String]] = None,
      gt: Option[Int] = None,
      gte: Option[Int] = None,
      lt: Option[Int] = None,
      lte: Option[Int] = None,
      equals: Option[List[String]] = None,
      notEquals: Option[List[String]] = None,
      greaterThan: Option[Long] = None,
      greaterThanOrEqual: Option[Long] = None,
      lessThan: Option[Long] = None,
      lessThanOrEqual: Option[Long] = None
    ): Condition =
      Condition
        .builder
        .ifSome(eq)(_.eq(_))
        .ifSome(neq)(_.neq(_))
        .ifSome(gt)(_.gt(_))
        .ifSome(gte)(_.gte(_))
        .ifSome(lt)(_.lt(_))
        .ifSome(lte)(_.lte(_))
        .ifSome(equals)(_.equals(_))
        .ifSome(notEquals)(_.notEquals(_))
        .ifSome(greaterThan)(_.greaterThan(_))
        .ifSome(greaterThanOrEqual)(_.greaterThanOrEqual(_))
        .ifSome(lessThan)(_.lessThan(_))
        .ifSome(lessThanOrEqual)(_.lessThanOrEqual(_))
        .build

    def country(
      countryCode: Option[String] = None,
      countryName: Option[String] = None
    ): Country =
      Country
        .builder
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(countryName)(_.countryName(_))
        .build

    def createDetectorRequest(
      enable: Option[Boolean] = None,
      clientToken: Option[String] = None,
      findingPublishingFrequency: Option[String] = None,
      dataSources: Option[DataSourceConfigurations] = None,
      tags: Option[TagMap] = None
    ): CreateDetectorRequest =
      CreateDetectorRequest
        .builder
        .ifSome(enable)(_.enable(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(findingPublishingFrequency)(_.findingPublishingFrequency(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDetectorResponse(
      detectorId: Option[String] = None
    ): CreateDetectorResponse =
      CreateDetectorResponse
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def createFilterRequest(
      detectorId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      action: Option[String] = None,
      rank: Option[Int] = None,
      findingCriteria: Option[FindingCriteria] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateFilterRequest =
      CreateFilterRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(action)(_.action(_))
        .ifSome(rank)(_.rank(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFilterResponse(
      name: Option[String] = None
    ): CreateFilterResponse =
      CreateFilterResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createIPSetRequest(
      detectorId: Option[String] = None,
      name: Option[String] = None,
      format: Option[String] = None,
      location: Option[String] = None,
      activate: Option[Boolean] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateIPSetRequest =
      CreateIPSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(location)(_.location(_))
        .ifSome(activate)(_.activate(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createIPSetResponse(
      ipSetId: Option[String] = None
    ): CreateIPSetResponse =
      CreateIPSetResponse
        .builder
        .ifSome(ipSetId)(_.ipSetId(_))
        .build

    def createMembersRequest(
      detectorId: Option[String] = None,
      accountDetails: Option[List[AccountDetail]] = None
    ): CreateMembersRequest =
      CreateMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountDetails)(_.accountDetails(_))
        .build

    def createMembersResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): CreateMembersResponse =
      CreateMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def createPublishingDestinationRequest(
      detectorId: Option[String] = None,
      destinationType: Option[String] = None,
      destinationProperties: Option[DestinationProperties] = None,
      clientToken: Option[String] = None
    ): CreatePublishingDestinationRequest =
      CreatePublishingDestinationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(destinationProperties)(_.destinationProperties(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createPublishingDestinationResponse(
      destinationId: Option[String] = None
    ): CreatePublishingDestinationResponse =
      CreatePublishingDestinationResponse
        .builder
        .ifSome(destinationId)(_.destinationId(_))
        .build

    def createSampleFindingsRequest(
      detectorId: Option[String] = None,
      findingTypes: Option[List[FindingType]] = None
    ): CreateSampleFindingsRequest =
      CreateSampleFindingsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingTypes)(_.findingTypes(_))
        .build

    def createSampleFindingsResponse(

    ): CreateSampleFindingsResponse =
      CreateSampleFindingsResponse
        .builder

        .build

    def createThreatIntelSetRequest(
      detectorId: Option[String] = None,
      name: Option[String] = None,
      format: Option[String] = None,
      location: Option[String] = None,
      activate: Option[Boolean] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateThreatIntelSetRequest =
      CreateThreatIntelSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(location)(_.location(_))
        .ifSome(activate)(_.activate(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createThreatIntelSetResponse(
      threatIntelSetId: Option[String] = None
    ): CreateThreatIntelSetResponse =
      CreateThreatIntelSetResponse
        .builder
        .ifSome(threatIntelSetId)(_.threatIntelSetId(_))
        .build

    def dataSourceConfigurations(
      s3Logs: Option[S3LogsConfiguration] = None
    ): DataSourceConfigurations =
      DataSourceConfigurations
        .builder
        .ifSome(s3Logs)(_.s3Logs(_))
        .build

    def declineInvitationsRequest(
      accountIds: Option[List[AccountId]] = None
    ): DeclineInvitationsRequest =
      DeclineInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def declineInvitationsResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DeclineInvitationsResponse =
      DeclineInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def defaultServerSideEncryption(
      encryptionType: Option[String] = None,
      kmsMasterKeyArn: Option[String] = None
    ): DefaultServerSideEncryption =
      DefaultServerSideEncryption
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsMasterKeyArn)(_.kmsMasterKeyArn(_))
        .build

    def deleteDetectorRequest(
      detectorId: Option[String] = None
    ): DeleteDetectorRequest =
      DeleteDetectorRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def deleteDetectorResponse(

    ): DeleteDetectorResponse =
      DeleteDetectorResponse
        .builder

        .build

    def deleteFilterRequest(
      detectorId: Option[String] = None,
      filterName: Option[String] = None
    ): DeleteFilterRequest =
      DeleteFilterRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(filterName)(_.filterName(_))
        .build

    def deleteFilterResponse(

    ): DeleteFilterResponse =
      DeleteFilterResponse
        .builder

        .build

    def deleteIPSetRequest(
      detectorId: Option[String] = None,
      ipSetId: Option[String] = None
    ): DeleteIPSetRequest =
      DeleteIPSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(ipSetId)(_.ipSetId(_))
        .build

    def deleteIPSetResponse(

    ): DeleteIPSetResponse =
      DeleteIPSetResponse
        .builder

        .build

    def deleteInvitationsRequest(
      accountIds: Option[List[AccountId]] = None
    ): DeleteInvitationsRequest =
      DeleteInvitationsRequest
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def deleteInvitationsResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DeleteInvitationsResponse =
      DeleteInvitationsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def deleteMembersRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): DeleteMembersRequest =
      DeleteMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def deleteMembersResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DeleteMembersResponse =
      DeleteMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def deletePublishingDestinationRequest(
      detectorId: Option[String] = None,
      destinationId: Option[String] = None
    ): DeletePublishingDestinationRequest =
      DeletePublishingDestinationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(destinationId)(_.destinationId(_))
        .build

    def deletePublishingDestinationResponse(

    ): DeletePublishingDestinationResponse =
      DeletePublishingDestinationResponse
        .builder

        .build

    def deleteThreatIntelSetRequest(
      detectorId: Option[String] = None,
      threatIntelSetId: Option[String] = None
    ): DeleteThreatIntelSetRequest =
      DeleteThreatIntelSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(threatIntelSetId)(_.threatIntelSetId(_))
        .build

    def deleteThreatIntelSetResponse(

    ): DeleteThreatIntelSetResponse =
      DeleteThreatIntelSetResponse
        .builder

        .build

    def describeOrganizationConfigurationRequest(
      detectorId: Option[String] = None
    ): DescribeOrganizationConfigurationRequest =
      DescribeOrganizationConfigurationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def describeOrganizationConfigurationResponse(
      autoEnable: Option[Boolean] = None,
      memberAccountLimitReached: Option[Boolean] = None,
      dataSources: Option[OrganizationDataSourceConfigurationsResult] = None
    ): DescribeOrganizationConfigurationResponse =
      DescribeOrganizationConfigurationResponse
        .builder
        .ifSome(autoEnable)(_.autoEnable(_))
        .ifSome(memberAccountLimitReached)(_.memberAccountLimitReached(_))
        .ifSome(dataSources)(_.dataSources(_))
        .build

    def describePublishingDestinationRequest(
      detectorId: Option[String] = None,
      destinationId: Option[String] = None
    ): DescribePublishingDestinationRequest =
      DescribePublishingDestinationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(destinationId)(_.destinationId(_))
        .build

    def describePublishingDestinationResponse(
      destinationId: Option[String] = None,
      destinationType: Option[String] = None,
      status: Option[String] = None,
      publishingFailureStartTimestamp: Option[Long] = None,
      destinationProperties: Option[DestinationProperties] = None
    ): DescribePublishingDestinationResponse =
      DescribePublishingDestinationResponse
        .builder
        .ifSome(destinationId)(_.destinationId(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(status)(_.status(_))
        .ifSome(publishingFailureStartTimestamp)(_.publishingFailureStartTimestamp(_))
        .ifSome(destinationProperties)(_.destinationProperties(_))
        .build

    def destination(
      destinationId: Option[String] = None,
      destinationType: Option[String] = None,
      status: Option[String] = None
    ): Destination =
      Destination
        .builder
        .ifSome(destinationId)(_.destinationId(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(status)(_.status(_))
        .build

    def destinationProperties(
      destinationArn: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): DestinationProperties =
      DestinationProperties
        .builder
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def disableOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): DisableOrganizationAdminAccountRequest =
      DisableOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def disableOrganizationAdminAccountResponse(

    ): DisableOrganizationAdminAccountResponse =
      DisableOrganizationAdminAccountResponse
        .builder

        .build

    def disassociateFromMasterAccountRequest(
      detectorId: Option[String] = None
    ): DisassociateFromMasterAccountRequest =
      DisassociateFromMasterAccountRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def disassociateFromMasterAccountResponse(

    ): DisassociateFromMasterAccountResponse =
      DisassociateFromMasterAccountResponse
        .builder

        .build

    def disassociateMembersRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): DisassociateMembersRequest =
      DisassociateMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def disassociateMembersResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DisassociateMembersResponse =
      DisassociateMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def dnsRequestAction(
      domain: Option[String] = None
    ): DnsRequestAction =
      DnsRequestAction
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def domainDetails(
      domain: Option[String] = None
    ): DomainDetails =
      DomainDetails
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def enableOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): EnableOrganizationAdminAccountRequest =
      EnableOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def enableOrganizationAdminAccountResponse(

    ): EnableOrganizationAdminAccountResponse =
      EnableOrganizationAdminAccountResponse
        .builder

        .build

    def evidence(
      threatIntelligenceDetails: Option[List[ThreatIntelligenceDetail]] = None
    ): Evidence =
      Evidence
        .builder
        .ifSome(threatIntelligenceDetails)(_.threatIntelligenceDetails(_))
        .build

    def finding(
      accountId: Option[String] = None,
      arn: Option[String] = None,
      confidence: Option[Double] = None,
      createdAt: Option[String] = None,
      description: Option[String] = None,
      id: Option[String] = None,
      partition: Option[String] = None,
      region: Option[String] = None,
      resource: Option[Resource] = None,
      schemaVersion: Option[String] = None,
      service: Option[Service] = None,
      severity: Option[Double] = None,
      title: Option[String] = None,
      `type`: Option[String] = None,
      updatedAt: Option[String] = None
    ): Finding =
      Finding
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(partition)(_.partition(_))
        .ifSome(region)(_.region(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(service)(_.service(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(title)(_.title(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def findingCriteria(
      criterion: Option[Criterion] = None
    ): FindingCriteria =
      FindingCriteria
        .builder
        .ifSome(criterion)(_.criterion(_))
        .build

    def findingStatistics(
      countBySeverity: Option[CountBySeverity] = None
    ): FindingStatistics =
      FindingStatistics
        .builder
        .ifSome(countBySeverity)(_.countBySeverity(_))
        .build

    def geoLocation(
      lat: Option[Double] = None,
      lon: Option[Double] = None
    ): GeoLocation =
      GeoLocation
        .builder
        .ifSome(lat)(_.lat(_))
        .ifSome(lon)(_.lon(_))
        .build

    def getDetectorRequest(
      detectorId: Option[String] = None
    ): GetDetectorRequest =
      GetDetectorRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def getDetectorResponse(
      createdAt: Option[String] = None,
      findingPublishingFrequency: Option[String] = None,
      serviceRole: Option[String] = None,
      status: Option[String] = None,
      updatedAt: Option[String] = None,
      dataSources: Option[DataSourceConfigurationsResult] = None,
      tags: Option[TagMap] = None
    ): GetDetectorResponse =
      GetDetectorResponse
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(findingPublishingFrequency)(_.findingPublishingFrequency(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getFilterRequest(
      detectorId: Option[String] = None,
      filterName: Option[String] = None
    ): GetFilterRequest =
      GetFilterRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(filterName)(_.filterName(_))
        .build

    def getFilterResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      action: Option[String] = None,
      rank: Option[Int] = None,
      findingCriteria: Option[FindingCriteria] = None,
      tags: Option[TagMap] = None
    ): GetFilterResponse =
      GetFilterResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(action)(_.action(_))
        .ifSome(rank)(_.rank(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getFindingsRequest(
      detectorId: Option[String] = None,
      findingIds: Option[List[FindingId]] = None,
      sortCriteria: Option[SortCriteria] = None
    ): GetFindingsRequest =
      GetFindingsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingIds)(_.findingIds(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def getFindingsResponse(
      findings: Option[List[Finding]] = None
    ): GetFindingsResponse =
      GetFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .build

    def getFindingsStatisticsRequest(
      detectorId: Option[String] = None,
      findingStatisticTypes: Option[List[FindingStatisticType]] = None,
      findingCriteria: Option[FindingCriteria] = None
    ): GetFindingsStatisticsRequest =
      GetFindingsStatisticsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingStatisticTypes)(_.findingStatisticTypes(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .build

    def getFindingsStatisticsResponse(
      findingStatistics: Option[FindingStatistics] = None
    ): GetFindingsStatisticsResponse =
      GetFindingsStatisticsResponse
        .builder
        .ifSome(findingStatistics)(_.findingStatistics(_))
        .build

    def getIPSetRequest(
      detectorId: Option[String] = None,
      ipSetId: Option[String] = None
    ): GetIPSetRequest =
      GetIPSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(ipSetId)(_.ipSetId(_))
        .build

    def getIPSetResponse(
      name: Option[String] = None,
      format: Option[String] = None,
      location: Option[String] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None
    ): GetIPSetResponse =
      GetIPSetResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(location)(_.location(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getInvitationsCountRequest(

    ): GetInvitationsCountRequest =
      GetInvitationsCountRequest
        .builder

        .build

    def getInvitationsCountResponse(
      invitationsCount: Option[Int] = None
    ): GetInvitationsCountResponse =
      GetInvitationsCountResponse
        .builder
        .ifSome(invitationsCount)(_.invitationsCount(_))
        .build

    def getMasterAccountRequest(
      detectorId: Option[String] = None
    ): GetMasterAccountRequest =
      GetMasterAccountRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .build

    def getMasterAccountResponse(
      master: Option[Master] = None
    ): GetMasterAccountResponse =
      GetMasterAccountResponse
        .builder
        .ifSome(master)(_.master(_))
        .build

    def getMemberDetectorsRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): GetMemberDetectorsRequest =
      GetMemberDetectorsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def getMemberDetectorsResponse(
      memberDataSourceConfigurations: Option[List[MemberDataSourceConfiguration]] = None,
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): GetMemberDetectorsResponse =
      GetMemberDetectorsResponse
        .builder
        .ifSome(memberDataSourceConfigurations)(_.memberDataSourceConfigurations(_))
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def getMembersRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): GetMembersRequest =
      GetMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def getMembersResponse(
      members: Option[List[Member]] = None,
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): GetMembersResponse =
      GetMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def getThreatIntelSetRequest(
      detectorId: Option[String] = None,
      threatIntelSetId: Option[String] = None
    ): GetThreatIntelSetRequest =
      GetThreatIntelSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(threatIntelSetId)(_.threatIntelSetId(_))
        .build

    def getThreatIntelSetResponse(
      name: Option[String] = None,
      format: Option[String] = None,
      location: Option[String] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None
    ): GetThreatIntelSetResponse =
      GetThreatIntelSetResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(location)(_.location(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getUsageStatisticsRequest(
      detectorId: Option[String] = None,
      usageStatisticType: Option[String] = None,
      usageCriteria: Option[UsageCriteria] = None,
      unit: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetUsageStatisticsRequest =
      GetUsageStatisticsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(usageStatisticType)(_.usageStatisticType(_))
        .ifSome(usageCriteria)(_.usageCriteria(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUsageStatisticsResponse(
      usageStatistics: Option[UsageStatistics] = None,
      nextToken: Option[String] = None
    ): GetUsageStatisticsResponse =
      GetUsageStatisticsResponse
        .builder
        .ifSome(usageStatistics)(_.usageStatistics(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def iamInstanceProfile(
      arn: Option[String] = None,
      id: Option[String] = None
    ): IamInstanceProfile =
      IamInstanceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def instanceDetails(
      availabilityZone: Option[String] = None,
      iamInstanceProfile: Option[IamInstanceProfile] = None,
      imageDescription: Option[String] = None,
      imageId: Option[String] = None,
      instanceId: Option[String] = None,
      instanceState: Option[String] = None,
      instanceType: Option[String] = None,
      outpostArn: Option[String] = None,
      launchTime: Option[String] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None,
      platform: Option[String] = None,
      productCodes: Option[List[ProductCode]] = None,
      tags: Option[List[Tag]] = None
    ): InstanceDetails =
      InstanceDetails
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(iamInstanceProfile)(_.iamInstanceProfile(_))
        .ifSome(imageDescription)(_.imageDescription(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceState)(_.instanceState(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(launchTime)(_.launchTime(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(productCodes)(_.productCodes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None,
      `type`: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def invitation(
      accountId: Option[String] = None,
      invitationId: Option[String] = None,
      relationshipStatus: Option[String] = None,
      invitedAt: Option[String] = None
    ): Invitation =
      Invitation
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(relationshipStatus)(_.relationshipStatus(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .build

    def inviteMembersRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None,
      disableEmailNotification: Option[Boolean] = None,
      message: Option[String] = None
    ): InviteMembersRequest =
      InviteMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(disableEmailNotification)(_.disableEmailNotification(_))
        .ifSome(message)(_.message(_))
        .build

    def inviteMembersResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): InviteMembersResponse =
      InviteMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def listDetectorsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDetectorsRequest =
      ListDetectorsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectorsResponse(
      detectorIds: Option[List[DetectorId]] = None,
      nextToken: Option[String] = None
    ): ListDetectorsResponse =
      ListDetectorsResponse
        .builder
        .ifSome(detectorIds)(_.detectorIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFiltersRequest(
      detectorId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFiltersRequest =
      ListFiltersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFiltersResponse(
      filterNames: Option[List[FilterName]] = None,
      nextToken: Option[String] = None
    ): ListFiltersResponse =
      ListFiltersResponse
        .builder
        .ifSome(filterNames)(_.filterNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsRequest(
      detectorId: Option[String] = None,
      findingCriteria: Option[FindingCriteria] = None,
      sortCriteria: Option[SortCriteria] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFindingsRequest =
      ListFindingsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsResponse(
      findingIds: Option[List[FindingId]] = None,
      nextToken: Option[String] = None
    ): ListFindingsResponse =
      ListFindingsResponse
        .builder
        .ifSome(findingIds)(_.findingIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIPSetsRequest(
      detectorId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIPSetsRequest =
      ListIPSetsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIPSetsResponse(
      ipSetIds: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListIPSetsResponse =
      ListIPSetsResponse
        .builder
        .ifSome(ipSetIds)(_.ipSetIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInvitationsRequest =
      ListInvitationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsResponse(
      invitations: Option[List[Invitation]] = None,
      nextToken: Option[String] = None
    ): ListInvitationsResponse =
      ListInvitationsResponse
        .builder
        .ifSome(invitations)(_.invitations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMembersRequest(
      detectorId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      onlyAssociated: Option[String] = None
    ): ListMembersRequest =
      ListMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(onlyAssociated)(_.onlyAssociated(_))
        .build

    def listMembersResponse(
      members: Option[List[Member]] = None,
      nextToken: Option[String] = None
    ): ListMembersResponse =
      ListMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationAdminAccountsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOrganizationAdminAccountsRequest =
      ListOrganizationAdminAccountsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationAdminAccountsResponse(
      adminAccounts: Option[List[AdminAccount]] = None,
      nextToken: Option[String] = None
    ): ListOrganizationAdminAccountsResponse =
      ListOrganizationAdminAccountsResponse
        .builder
        .ifSome(adminAccounts)(_.adminAccounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPublishingDestinationsRequest(
      detectorId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPublishingDestinationsRequest =
      ListPublishingDestinationsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPublishingDestinationsResponse(
      destinations: Option[List[Destination]] = None,
      nextToken: Option[String] = None
    ): ListPublishingDestinationsResponse =
      ListPublishingDestinationsResponse
        .builder
        .ifSome(destinations)(_.destinations(_))
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

    def listThreatIntelSetsRequest(
      detectorId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListThreatIntelSetsRequest =
      ListThreatIntelSetsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThreatIntelSetsResponse(
      threatIntelSetIds: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListThreatIntelSetsResponse =
      ListThreatIntelSetsResponse
        .builder
        .ifSome(threatIntelSetIds)(_.threatIntelSetIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def localIpDetails(
      ipAddressV4: Option[String] = None
    ): LocalIpDetails =
      LocalIpDetails
        .builder
        .ifSome(ipAddressV4)(_.ipAddressV4(_))
        .build

    def localPortDetails(
      port: Option[Int] = None,
      portName: Option[String] = None
    ): LocalPortDetails =
      LocalPortDetails
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(portName)(_.portName(_))
        .build

    def master(
      accountId: Option[String] = None,
      invitationId: Option[String] = None,
      relationshipStatus: Option[String] = None,
      invitedAt: Option[String] = None
    ): Master =
      Master
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(relationshipStatus)(_.relationshipStatus(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .build

    def member(
      accountId: Option[String] = None,
      detectorId: Option[String] = None,
      masterId: Option[String] = None,
      email: Option[String] = None,
      relationshipStatus: Option[String] = None,
      invitedAt: Option[String] = None,
      updatedAt: Option[String] = None
    ): Member =
      Member
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(masterId)(_.masterId(_))
        .ifSome(email)(_.email(_))
        .ifSome(relationshipStatus)(_.relationshipStatus(_))
        .ifSome(invitedAt)(_.invitedAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def memberDataSourceConfiguration(
      accountId: Option[String] = None,
      dataSources: Option[DataSourceConfigurationsResult] = None
    ): MemberDataSourceConfiguration =
      MemberDataSourceConfiguration
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(dataSources)(_.dataSources(_))
        .build

    def networkConnectionAction(
      blocked: Option[Boolean] = None,
      connectionDirection: Option[String] = None,
      localPortDetails: Option[LocalPortDetails] = None,
      protocol: Option[String] = None,
      localIpDetails: Option[LocalIpDetails] = None,
      remoteIpDetails: Option[RemoteIpDetails] = None,
      remotePortDetails: Option[RemotePortDetails] = None
    ): NetworkConnectionAction =
      NetworkConnectionAction
        .builder
        .ifSome(blocked)(_.blocked(_))
        .ifSome(connectionDirection)(_.connectionDirection(_))
        .ifSome(localPortDetails)(_.localPortDetails(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(localIpDetails)(_.localIpDetails(_))
        .ifSome(remoteIpDetails)(_.remoteIpDetails(_))
        .ifSome(remotePortDetails)(_.remotePortDetails(_))
        .build

    def networkInterface(
      ipv6Addresses: Option[List[String]] = None,
      networkInterfaceId: Option[String] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[PrivateIpAddressDetails]] = None,
      publicDnsName: Option[String] = None,
      publicIp: Option[String] = None,
      securityGroups: Option[List[SecurityGroup]] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def organization(
      asn: Option[String] = None,
      asnOrg: Option[String] = None,
      isp: Option[String] = None,
      org: Option[String] = None
    ): Organization =
      Organization
        .builder
        .ifSome(asn)(_.asn(_))
        .ifSome(asnOrg)(_.asnOrg(_))
        .ifSome(isp)(_.isp(_))
        .ifSome(org)(_.org(_))
        .build

    def organizationDataSourceConfigurations(
      s3Logs: Option[OrganizationS3LogsConfiguration] = None
    ): OrganizationDataSourceConfigurations =
      OrganizationDataSourceConfigurations
        .builder
        .ifSome(s3Logs)(_.s3Logs(_))
        .build

    def organizationS3LogsConfiguration(
      autoEnable: Option[Boolean] = None
    ): OrganizationS3LogsConfiguration =
      OrganizationS3LogsConfiguration
        .builder
        .ifSome(autoEnable)(_.autoEnable(_))
        .build

    def owner(
      id: Option[String] = None
    ): Owner =
      Owner
        .builder
        .ifSome(id)(_.id(_))
        .build

    def permissionConfiguration(
      bucketLevelPermissions: Option[BucketLevelPermissions] = None,
      accountLevelPermissions: Option[AccountLevelPermissions] = None
    ): PermissionConfiguration =
      PermissionConfiguration
        .builder
        .ifSome(bucketLevelPermissions)(_.bucketLevelPermissions(_))
        .ifSome(accountLevelPermissions)(_.accountLevelPermissions(_))
        .build

    def portProbeAction(
      blocked: Option[Boolean] = None,
      portProbeDetails: Option[List[PortProbeDetail]] = None
    ): PortProbeAction =
      PortProbeAction
        .builder
        .ifSome(blocked)(_.blocked(_))
        .ifSome(portProbeDetails)(_.portProbeDetails(_))
        .build

    def portProbeDetail(
      localPortDetails: Option[LocalPortDetails] = None,
      localIpDetails: Option[LocalIpDetails] = None,
      remoteIpDetails: Option[RemoteIpDetails] = None
    ): PortProbeDetail =
      PortProbeDetail
        .builder
        .ifSome(localPortDetails)(_.localPortDetails(_))
        .ifSome(localIpDetails)(_.localIpDetails(_))
        .ifSome(remoteIpDetails)(_.remoteIpDetails(_))
        .build

    def privateIpAddressDetails(
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None
    ): PrivateIpAddressDetails =
      PrivateIpAddressDetails
        .builder
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def productCode(
      code: Option[String] = None,
      productType: Option[String] = None
    ): ProductCode =
      ProductCode
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(productType)(_.productType(_))
        .build

    def publicAccess(
      permissionConfiguration: Option[PermissionConfiguration] = None,
      effectivePermission: Option[String] = None
    ): PublicAccess =
      PublicAccess
        .builder
        .ifSome(permissionConfiguration)(_.permissionConfiguration(_))
        .ifSome(effectivePermission)(_.effectivePermission(_))
        .build

    def remoteIpDetails(
      city: Option[City] = None,
      country: Option[Country] = None,
      geoLocation: Option[GeoLocation] = None,
      ipAddressV4: Option[String] = None,
      organization: Option[Organization] = None
    ): RemoteIpDetails =
      RemoteIpDetails
        .builder
        .ifSome(city)(_.city(_))
        .ifSome(country)(_.country(_))
        .ifSome(geoLocation)(_.geoLocation(_))
        .ifSome(ipAddressV4)(_.ipAddressV4(_))
        .ifSome(organization)(_.organization(_))
        .build

    def remotePortDetails(
      port: Option[Int] = None,
      portName: Option[String] = None
    ): RemotePortDetails =
      RemotePortDetails
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(portName)(_.portName(_))
        .build

    def resource(
      accessKeyDetails: Option[AccessKeyDetails] = None,
      s3BucketDetails: Option[List[S3BucketDetail]] = None,
      instanceDetails: Option[InstanceDetails] = None,
      resourceType: Option[String] = None
    ): Resource =
      Resource
        .builder
        .ifSome(accessKeyDetails)(_.accessKeyDetails(_))
        .ifSome(s3BucketDetails)(_.s3BucketDetails(_))
        .ifSome(instanceDetails)(_.instanceDetails(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def s3BucketDetail(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      owner: Option[Owner] = None,
      tags: Option[List[Tag]] = None,
      defaultServerSideEncryption: Option[DefaultServerSideEncryption] = None,
      publicAccess: Option[PublicAccess] = None
    ): S3BucketDetail =
      S3BucketDetail
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(defaultServerSideEncryption)(_.defaultServerSideEncryption(_))
        .ifSome(publicAccess)(_.publicAccess(_))
        .build

    def s3LogsConfiguration(
      enable: Option[Boolean] = None
    ): S3LogsConfiguration =
      S3LogsConfiguration
        .builder
        .ifSome(enable)(_.enable(_))
        .build

    def securityGroup(
      groupId: Option[String] = None,
      groupName: Option[String] = None
    ): SecurityGroup =
      SecurityGroup
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def service(
      action: Option[Action] = None,
      evidence: Option[Evidence] = None,
      archived: Option[Boolean] = None,
      count: Option[Int] = None,
      detectorId: Option[String] = None,
      eventFirstSeen: Option[String] = None,
      eventLastSeen: Option[String] = None,
      resourceRole: Option[String] = None,
      serviceName: Option[String] = None,
      userFeedback: Option[String] = None
    ): Service =
      Service
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(evidence)(_.evidence(_))
        .ifSome(archived)(_.archived(_))
        .ifSome(count)(_.count(_))
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(eventFirstSeen)(_.eventFirstSeen(_))
        .ifSome(eventLastSeen)(_.eventLastSeen(_))
        .ifSome(resourceRole)(_.resourceRole(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(userFeedback)(_.userFeedback(_))
        .build

    def sortCriteria(
      attributeName: Option[String] = None,
      orderBy: Option[String] = None
    ): SortCriteria =
      SortCriteria
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(orderBy)(_.orderBy(_))
        .build

    def startMonitoringMembersRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): StartMonitoringMembersRequest =
      StartMonitoringMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def startMonitoringMembersResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): StartMonitoringMembersResponse =
      StartMonitoringMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def stopMonitoringMembersRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): StopMonitoringMembersRequest =
      StopMonitoringMembersRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def stopMonitoringMembersResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): StopMonitoringMembersResponse =
      StopMonitoringMembersResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
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

    def threatIntelligenceDetail(
      threatListName: Option[String] = None,
      threatNames: Option[List[String]] = None
    ): ThreatIntelligenceDetail =
      ThreatIntelligenceDetail
        .builder
        .ifSome(threatListName)(_.threatListName(_))
        .ifSome(threatNames)(_.threatNames(_))
        .build

    def total(
      amount: Option[String] = None,
      unit: Option[String] = None
    ): Total =
      Total
        .builder
        .ifSome(amount)(_.amount(_))
        .ifSome(unit)(_.unit(_))
        .build

    def unarchiveFindingsRequest(
      detectorId: Option[String] = None,
      findingIds: Option[List[FindingId]] = None
    ): UnarchiveFindingsRequest =
      UnarchiveFindingsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingIds)(_.findingIds(_))
        .build

    def unarchiveFindingsResponse(

    ): UnarchiveFindingsResponse =
      UnarchiveFindingsResponse
        .builder

        .build

    def unprocessedAccount(
      accountId: Option[String] = None,
      result: Option[String] = None
    ): UnprocessedAccount =
      UnprocessedAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(result)(_.result(_))
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

    def updateDetectorRequest(
      detectorId: Option[String] = None,
      enable: Option[Boolean] = None,
      findingPublishingFrequency: Option[String] = None,
      dataSources: Option[DataSourceConfigurations] = None
    ): UpdateDetectorRequest =
      UpdateDetectorRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(enable)(_.enable(_))
        .ifSome(findingPublishingFrequency)(_.findingPublishingFrequency(_))
        .ifSome(dataSources)(_.dataSources(_))
        .build

    def updateDetectorResponse(

    ): UpdateDetectorResponse =
      UpdateDetectorResponse
        .builder

        .build

    def updateFilterRequest(
      detectorId: Option[String] = None,
      filterName: Option[String] = None,
      description: Option[String] = None,
      action: Option[String] = None,
      rank: Option[Int] = None,
      findingCriteria: Option[FindingCriteria] = None
    ): UpdateFilterRequest =
      UpdateFilterRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(filterName)(_.filterName(_))
        .ifSome(description)(_.description(_))
        .ifSome(action)(_.action(_))
        .ifSome(rank)(_.rank(_))
        .ifSome(findingCriteria)(_.findingCriteria(_))
        .build

    def updateFilterResponse(
      name: Option[String] = None
    ): UpdateFilterResponse =
      UpdateFilterResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateFindingsFeedbackRequest(
      detectorId: Option[String] = None,
      findingIds: Option[List[FindingId]] = None,
      feedback: Option[String] = None,
      comments: Option[String] = None
    ): UpdateFindingsFeedbackRequest =
      UpdateFindingsFeedbackRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(findingIds)(_.findingIds(_))
        .ifSome(feedback)(_.feedback(_))
        .ifSome(comments)(_.comments(_))
        .build

    def updateFindingsFeedbackResponse(

    ): UpdateFindingsFeedbackResponse =
      UpdateFindingsFeedbackResponse
        .builder

        .build

    def updateIPSetRequest(
      detectorId: Option[String] = None,
      ipSetId: Option[String] = None,
      name: Option[String] = None,
      location: Option[String] = None,
      activate: Option[Boolean] = None
    ): UpdateIPSetRequest =
      UpdateIPSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(ipSetId)(_.ipSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(location)(_.location(_))
        .ifSome(activate)(_.activate(_))
        .build

    def updateIPSetResponse(

    ): UpdateIPSetResponse =
      UpdateIPSetResponse
        .builder

        .build

    def updateMemberDetectorsRequest(
      detectorId: Option[String] = None,
      accountIds: Option[List[AccountId]] = None,
      dataSources: Option[DataSourceConfigurations] = None
    ): UpdateMemberDetectorsRequest =
      UpdateMemberDetectorsRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(dataSources)(_.dataSources(_))
        .build

    def updateMemberDetectorsResponse(
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): UpdateMemberDetectorsResponse =
      UpdateMemberDetectorsResponse
        .builder
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def updateOrganizationConfigurationRequest(
      detectorId: Option[String] = None,
      autoEnable: Option[Boolean] = None,
      dataSources: Option[OrganizationDataSourceConfigurations] = None
    ): UpdateOrganizationConfigurationRequest =
      UpdateOrganizationConfigurationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(autoEnable)(_.autoEnable(_))
        .ifSome(dataSources)(_.dataSources(_))
        .build

    def updateOrganizationConfigurationResponse(

    ): UpdateOrganizationConfigurationResponse =
      UpdateOrganizationConfigurationResponse
        .builder

        .build

    def updatePublishingDestinationRequest(
      detectorId: Option[String] = None,
      destinationId: Option[String] = None,
      destinationProperties: Option[DestinationProperties] = None
    ): UpdatePublishingDestinationRequest =
      UpdatePublishingDestinationRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(destinationId)(_.destinationId(_))
        .ifSome(destinationProperties)(_.destinationProperties(_))
        .build

    def updatePublishingDestinationResponse(

    ): UpdatePublishingDestinationResponse =
      UpdatePublishingDestinationResponse
        .builder

        .build

    def updateThreatIntelSetRequest(
      detectorId: Option[String] = None,
      threatIntelSetId: Option[String] = None,
      name: Option[String] = None,
      location: Option[String] = None,
      activate: Option[Boolean] = None
    ): UpdateThreatIntelSetRequest =
      UpdateThreatIntelSetRequest
        .builder
        .ifSome(detectorId)(_.detectorId(_))
        .ifSome(threatIntelSetId)(_.threatIntelSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(location)(_.location(_))
        .ifSome(activate)(_.activate(_))
        .build

    def updateThreatIntelSetResponse(

    ): UpdateThreatIntelSetResponse =
      UpdateThreatIntelSetResponse
        .builder

        .build

    def usageCriteria(
      accountIds: Option[List[AccountId]] = None,
      dataSources: Option[List[DataSource]] = None,
      resources: Option[List[String]] = None
    ): UsageCriteria =
      UsageCriteria
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(resources)(_.resources(_))
        .build

    def usageStatistics(
      sumByAccount: Option[List[UsageAccountResult]] = None,
      sumByDataSource: Option[List[UsageDataSourceResult]] = None,
      sumByResource: Option[List[UsageResourceResult]] = None,
      topResources: Option[List[UsageResourceResult]] = None
    ): UsageStatistics =
      UsageStatistics
        .builder
        .ifSome(sumByAccount)(_.sumByAccount(_))
        .ifSome(sumByDataSource)(_.sumByDataSource(_))
        .ifSome(sumByResource)(_.sumByResource(_))
        .ifSome(topResources)(_.topResources(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
