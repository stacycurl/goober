package goober.hi

import goober.free.config.ConfigIO
import software.amazon.awssdk.services.config.model._


object config {
  import goober.free.{config ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountAggregationSource(
      accountIds: Option[List[AccountId]] = None,
      allAwsRegions: Option[Boolean] = None,
      awsRegions: Option[List[String]] = None
    ): AccountAggregationSource =
      AccountAggregationSource
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(allAwsRegions)(_.allAwsRegions(_))
        .ifSome(awsRegions)(_.awsRegions(_))
        .build

    def aggregateComplianceByConfigRule(
      configRuleName: Option[String] = None,
      compliance: Option[Compliance] = None,
      accountId: Option[String] = None,
      awsRegion: Option[String] = None
    ): AggregateComplianceByConfigRule =
      AggregateComplianceByConfigRule
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(compliance)(_.compliance(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def aggregateComplianceByConformancePack(
      conformancePackName: Option[String] = None,
      compliance: Option[AggregateConformancePackCompliance] = None,
      accountId: Option[String] = None,
      awsRegion: Option[String] = None
    ): AggregateComplianceByConformancePack =
      AggregateComplianceByConformancePack
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(compliance)(_.compliance(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def aggregateComplianceCount(
      groupName: Option[String] = None,
      complianceSummary: Option[ComplianceSummary] = None
    ): AggregateComplianceCount =
      AggregateComplianceCount
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(complianceSummary)(_.complianceSummary(_))
        .build

    def aggregateConformancePackCompliance(
      complianceType: Option[String] = None,
      compliantRuleCount: Option[Int] = None,
      nonCompliantRuleCount: Option[Int] = None,
      totalRuleCount: Option[Int] = None
    ): AggregateConformancePackCompliance =
      AggregateConformancePackCompliance
        .builder
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(compliantRuleCount)(_.compliantRuleCount(_))
        .ifSome(nonCompliantRuleCount)(_.nonCompliantRuleCount(_))
        .ifSome(totalRuleCount)(_.totalRuleCount(_))
        .build

    def aggregateConformancePackComplianceCount(
      compliantConformancePackCount: Option[Int] = None,
      nonCompliantConformancePackCount: Option[Int] = None
    ): AggregateConformancePackComplianceCount =
      AggregateConformancePackComplianceCount
        .builder
        .ifSome(compliantConformancePackCount)(_.compliantConformancePackCount(_))
        .ifSome(nonCompliantConformancePackCount)(_.nonCompliantConformancePackCount(_))
        .build

    def aggregateConformancePackComplianceFilters(
      conformancePackName: Option[String] = None,
      complianceType: Option[String] = None,
      accountId: Option[String] = None,
      awsRegion: Option[String] = None
    ): AggregateConformancePackComplianceFilters =
      AggregateConformancePackComplianceFilters
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def aggregateConformancePackComplianceSummary(
      complianceSummary: Option[AggregateConformancePackComplianceCount] = None,
      groupName: Option[String] = None
    ): AggregateConformancePackComplianceSummary =
      AggregateConformancePackComplianceSummary
        .builder
        .ifSome(complianceSummary)(_.complianceSummary(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def aggregateConformancePackComplianceSummaryFilters(
      accountId: Option[String] = None,
      awsRegion: Option[String] = None
    ): AggregateConformancePackComplianceSummaryFilters =
      AggregateConformancePackComplianceSummaryFilters
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def aggregateResourceIdentifier(
      sourceAccountId: Option[String] = None,
      sourceRegion: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceName: Option[String] = None
    ): AggregateResourceIdentifier =
      AggregateResourceIdentifier
        .builder
        .ifSome(sourceAccountId)(_.sourceAccountId(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def aggregatedSourceStatus(
      sourceId: Option[String] = None,
      sourceType: Option[String] = None,
      awsRegion: Option[String] = None,
      lastUpdateStatus: Option[String] = None,
      lastUpdateTime: Option[Date] = None,
      lastErrorCode: Option[String] = None,
      lastErrorMessage: Option[String] = None
    ): AggregatedSourceStatus =
      AggregatedSourceStatus
        .builder
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(lastUpdateStatus)(_.lastUpdateStatus(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(lastErrorCode)(_.lastErrorCode(_))
        .ifSome(lastErrorMessage)(_.lastErrorMessage(_))
        .build

    def aggregationAuthorization(
      aggregationAuthorizationArn: Option[String] = None,
      authorizedAccountId: Option[String] = None,
      authorizedAwsRegion: Option[String] = None,
      creationTime: Option[Date] = None
    ): AggregationAuthorization =
      AggregationAuthorization
        .builder
        .ifSome(aggregationAuthorizationArn)(_.aggregationAuthorizationArn(_))
        .ifSome(authorizedAccountId)(_.authorizedAccountId(_))
        .ifSome(authorizedAwsRegion)(_.authorizedAwsRegion(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def baseConfigurationItem(
      version: Option[String] = None,
      accountId: Option[String] = None,
      configurationItemCaptureTime: Option[ConfigurationItemCaptureTime] = None,
      configurationItemStatus: Option[String] = None,
      configurationStateId: Option[String] = None,
      arn: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      resourceName: Option[String] = None,
      awsRegion: Option[String] = None,
      availabilityZone: Option[String] = None,
      resourceCreationTime: Option[ResourceCreationTime] = None,
      configuration: Option[String] = None,
      supplementaryConfiguration: Option[SupplementaryConfiguration] = None
    ): BaseConfigurationItem =
      BaseConfigurationItem
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(configurationItemCaptureTime)(_.configurationItemCaptureTime(_))
        .ifSome(configurationItemStatus)(_.configurationItemStatus(_))
        .ifSome(configurationStateId)(_.configurationStateId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(resourceCreationTime)(_.resourceCreationTime(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(supplementaryConfiguration)(_.supplementaryConfiguration(_))
        .build

    def batchGetAggregateResourceConfigRequest(
      configurationAggregatorName: Option[String] = None,
      resourceIdentifiers: Option[List[AggregateResourceIdentifier]] = None
    ): BatchGetAggregateResourceConfigRequest =
      BatchGetAggregateResourceConfigRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(resourceIdentifiers)(_.resourceIdentifiers(_))
        .build

    def batchGetAggregateResourceConfigResponse(
      baseConfigurationItems: Option[List[BaseConfigurationItem]] = None,
      unprocessedResourceIdentifiers: Option[List[AggregateResourceIdentifier]] = None
    ): BatchGetAggregateResourceConfigResponse =
      BatchGetAggregateResourceConfigResponse
        .builder
        .ifSome(baseConfigurationItems)(_.baseConfigurationItems(_))
        .ifSome(unprocessedResourceIdentifiers)(_.unprocessedResourceIdentifiers(_))
        .build

    def batchGetResourceConfigRequest(
      resourceKeys: Option[List[ResourceKey]] = None
    ): BatchGetResourceConfigRequest =
      BatchGetResourceConfigRequest
        .builder
        .ifSome(resourceKeys)(_.resourceKeys(_))
        .build

    def batchGetResourceConfigResponse(
      baseConfigurationItems: Option[List[BaseConfigurationItem]] = None,
      unprocessedResourceKeys: Option[List[ResourceKey]] = None
    ): BatchGetResourceConfigResponse =
      BatchGetResourceConfigResponse
        .builder
        .ifSome(baseConfigurationItems)(_.baseConfigurationItems(_))
        .ifSome(unprocessedResourceKeys)(_.unprocessedResourceKeys(_))
        .build

    def compliance(
      complianceType: Option[String] = None,
      complianceContributorCount: Option[ComplianceContributorCount] = None
    ): Compliance =
      Compliance
        .builder
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(complianceContributorCount)(_.complianceContributorCount(_))
        .build

    def complianceByConfigRule(
      configRuleName: Option[String] = None,
      compliance: Option[Compliance] = None
    ): ComplianceByConfigRule =
      ComplianceByConfigRule
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(compliance)(_.compliance(_))
        .build

    def complianceByResource(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      compliance: Option[Compliance] = None
    ): ComplianceByResource =
      ComplianceByResource
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(compliance)(_.compliance(_))
        .build

    def complianceContributorCount(
      cappedCount: Option[Int] = None,
      capExceeded: Option[Boolean] = None
    ): ComplianceContributorCount =
      ComplianceContributorCount
        .builder
        .ifSome(cappedCount)(_.cappedCount(_))
        .ifSome(capExceeded)(_.capExceeded(_))
        .build

    def complianceSummary(
      compliantResourceCount: Option[ComplianceContributorCount] = None,
      nonCompliantResourceCount: Option[ComplianceContributorCount] = None,
      complianceSummaryTimestamp: Option[Date] = None
    ): ComplianceSummary =
      ComplianceSummary
        .builder
        .ifSome(compliantResourceCount)(_.compliantResourceCount(_))
        .ifSome(nonCompliantResourceCount)(_.nonCompliantResourceCount(_))
        .ifSome(complianceSummaryTimestamp)(_.complianceSummaryTimestamp(_))
        .build

    def complianceSummaryByResourceType(
      resourceType: Option[String] = None,
      complianceSummary: Option[ComplianceSummary] = None
    ): ComplianceSummaryByResourceType =
      ComplianceSummaryByResourceType
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(complianceSummary)(_.complianceSummary(_))
        .build

    def configExportDeliveryInfo(
      lastStatus: Option[String] = None,
      lastErrorCode: Option[String] = None,
      lastErrorMessage: Option[String] = None,
      lastAttemptTime: Option[Date] = None,
      lastSuccessfulTime: Option[Date] = None,
      nextDeliveryTime: Option[Date] = None
    ): ConfigExportDeliveryInfo =
      ConfigExportDeliveryInfo
        .builder
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(lastErrorCode)(_.lastErrorCode(_))
        .ifSome(lastErrorMessage)(_.lastErrorMessage(_))
        .ifSome(lastAttemptTime)(_.lastAttemptTime(_))
        .ifSome(lastSuccessfulTime)(_.lastSuccessfulTime(_))
        .ifSome(nextDeliveryTime)(_.nextDeliveryTime(_))
        .build

    def configRule(
      configRuleName: Option[String] = None,
      configRuleArn: Option[String] = None,
      configRuleId: Option[String] = None,
      description: Option[String] = None,
      scope: Option[Scope] = None,
      source: Option[Source] = None,
      inputParameters: Option[String] = None,
      maximumExecutionFrequency: Option[String] = None,
      configRuleState: Option[String] = None,
      createdBy: Option[String] = None
    ): ConfigRule =
      ConfigRule
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(configRuleArn)(_.configRuleArn(_))
        .ifSome(configRuleId)(_.configRuleId(_))
        .ifSome(description)(_.description(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(source)(_.source(_))
        .ifSome(inputParameters)(_.inputParameters(_))
        .ifSome(maximumExecutionFrequency)(_.maximumExecutionFrequency(_))
        .ifSome(configRuleState)(_.configRuleState(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def configRuleComplianceFilters(
      configRuleName: Option[String] = None,
      complianceType: Option[String] = None,
      accountId: Option[String] = None,
      awsRegion: Option[String] = None
    ): ConfigRuleComplianceFilters =
      ConfigRuleComplianceFilters
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def configRuleComplianceSummaryFilters(
      accountId: Option[String] = None,
      awsRegion: Option[String] = None
    ): ConfigRuleComplianceSummaryFilters =
      ConfigRuleComplianceSummaryFilters
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def configRuleEvaluationStatus(
      configRuleName: Option[String] = None,
      configRuleArn: Option[String] = None,
      configRuleId: Option[String] = None,
      lastSuccessfulInvocationTime: Option[Date] = None,
      lastFailedInvocationTime: Option[Date] = None,
      lastSuccessfulEvaluationTime: Option[Date] = None,
      lastFailedEvaluationTime: Option[Date] = None,
      firstActivatedTime: Option[Date] = None,
      lastDeactivatedTime: Option[Date] = None,
      lastErrorCode: Option[String] = None,
      lastErrorMessage: Option[String] = None,
      firstEvaluationStarted: Option[Boolean] = None
    ): ConfigRuleEvaluationStatus =
      ConfigRuleEvaluationStatus
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(configRuleArn)(_.configRuleArn(_))
        .ifSome(configRuleId)(_.configRuleId(_))
        .ifSome(lastSuccessfulInvocationTime)(_.lastSuccessfulInvocationTime(_))
        .ifSome(lastFailedInvocationTime)(_.lastFailedInvocationTime(_))
        .ifSome(lastSuccessfulEvaluationTime)(_.lastSuccessfulEvaluationTime(_))
        .ifSome(lastFailedEvaluationTime)(_.lastFailedEvaluationTime(_))
        .ifSome(firstActivatedTime)(_.firstActivatedTime(_))
        .ifSome(lastDeactivatedTime)(_.lastDeactivatedTime(_))
        .ifSome(lastErrorCode)(_.lastErrorCode(_))
        .ifSome(lastErrorMessage)(_.lastErrorMessage(_))
        .ifSome(firstEvaluationStarted)(_.firstEvaluationStarted(_))
        .build

    def configSnapshotDeliveryProperties(
      deliveryFrequency: Option[String] = None
    ): ConfigSnapshotDeliveryProperties =
      ConfigSnapshotDeliveryProperties
        .builder
        .ifSome(deliveryFrequency)(_.deliveryFrequency(_))
        .build

    def configStreamDeliveryInfo(
      lastStatus: Option[String] = None,
      lastErrorCode: Option[String] = None,
      lastErrorMessage: Option[String] = None,
      lastStatusChangeTime: Option[Date] = None
    ): ConfigStreamDeliveryInfo =
      ConfigStreamDeliveryInfo
        .builder
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(lastErrorCode)(_.lastErrorCode(_))
        .ifSome(lastErrorMessage)(_.lastErrorMessage(_))
        .ifSome(lastStatusChangeTime)(_.lastStatusChangeTime(_))
        .build

    def configurationAggregator(
      configurationAggregatorName: Option[String] = None,
      configurationAggregatorArn: Option[String] = None,
      accountAggregationSources: Option[List[AccountAggregationSource]] = None,
      organizationAggregationSource: Option[OrganizationAggregationSource] = None,
      creationTime: Option[Date] = None,
      lastUpdatedTime: Option[Date] = None,
      createdBy: Option[String] = None
    ): ConfigurationAggregator =
      ConfigurationAggregator
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(configurationAggregatorArn)(_.configurationAggregatorArn(_))
        .ifSome(accountAggregationSources)(_.accountAggregationSources(_))
        .ifSome(organizationAggregationSource)(_.organizationAggregationSource(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def configurationItem(
      version: Option[String] = None,
      accountId: Option[String] = None,
      configurationItemCaptureTime: Option[ConfigurationItemCaptureTime] = None,
      configurationItemStatus: Option[String] = None,
      configurationStateId: Option[String] = None,
      configurationItemMD5Hash: Option[String] = None,
      arn: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      resourceName: Option[String] = None,
      awsRegion: Option[String] = None,
      availabilityZone: Option[String] = None,
      resourceCreationTime: Option[ResourceCreationTime] = None,
      tags: Option[Tags] = None,
      relatedEvents: Option[List[RelatedEvent]] = None,
      relationships: Option[List[Relationship]] = None,
      configuration: Option[String] = None,
      supplementaryConfiguration: Option[SupplementaryConfiguration] = None
    ): ConfigurationItem =
      ConfigurationItem
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(configurationItemCaptureTime)(_.configurationItemCaptureTime(_))
        .ifSome(configurationItemStatus)(_.configurationItemStatus(_))
        .ifSome(configurationStateId)(_.configurationStateId(_))
        .ifSome(configurationItemMD5Hash)(_.configurationItemMD5Hash(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(resourceCreationTime)(_.resourceCreationTime(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(relatedEvents)(_.relatedEvents(_))
        .ifSome(relationships)(_.relationships(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(supplementaryConfiguration)(_.supplementaryConfiguration(_))
        .build

    def configurationRecorder(
      name: Option[String] = None,
      roleARN: Option[String] = None,
      recordingGroup: Option[RecordingGroup] = None
    ): ConfigurationRecorder =
      ConfigurationRecorder
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(recordingGroup)(_.recordingGroup(_))
        .build

    def configurationRecorderStatus(
      name: Option[String] = None,
      lastStartTime: Option[Date] = None,
      lastStopTime: Option[Date] = None,
      recording: Option[Boolean] = None,
      lastStatus: Option[String] = None,
      lastErrorCode: Option[String] = None,
      lastErrorMessage: Option[String] = None,
      lastStatusChangeTime: Option[Date] = None
    ): ConfigurationRecorderStatus =
      ConfigurationRecorderStatus
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(lastStartTime)(_.lastStartTime(_))
        .ifSome(lastStopTime)(_.lastStopTime(_))
        .ifSome(recording)(_.recording(_))
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(lastErrorCode)(_.lastErrorCode(_))
        .ifSome(lastErrorMessage)(_.lastErrorMessage(_))
        .ifSome(lastStatusChangeTime)(_.lastStatusChangeTime(_))
        .build

    def conformancePackComplianceFilters(
      configRuleNames: Option[List[StringWithCharLimit64]] = None,
      complianceType: Option[String] = None
    ): ConformancePackComplianceFilters =
      ConformancePackComplianceFilters
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .ifSome(complianceType)(_.complianceType(_))
        .build

    def conformancePackComplianceSummary(
      conformancePackName: Option[String] = None,
      conformancePackComplianceStatus: Option[String] = None
    ): ConformancePackComplianceSummary =
      ConformancePackComplianceSummary
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(conformancePackComplianceStatus)(_.conformancePackComplianceStatus(_))
        .build

    def conformancePackDetail(
      conformancePackName: Option[String] = None,
      conformancePackArn: Option[String] = None,
      conformancePackId: Option[String] = None,
      deliveryS3Bucket: Option[String] = None,
      deliveryS3KeyPrefix: Option[String] = None,
      conformancePackInputParameters: Option[List[ConformancePackInputParameter]] = None,
      lastUpdateRequestedTime: Option[Date] = None,
      createdBy: Option[String] = None
    ): ConformancePackDetail =
      ConformancePackDetail
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(conformancePackArn)(_.conformancePackArn(_))
        .ifSome(conformancePackId)(_.conformancePackId(_))
        .ifSome(deliveryS3Bucket)(_.deliveryS3Bucket(_))
        .ifSome(deliveryS3KeyPrefix)(_.deliveryS3KeyPrefix(_))
        .ifSome(conformancePackInputParameters)(_.conformancePackInputParameters(_))
        .ifSome(lastUpdateRequestedTime)(_.lastUpdateRequestedTime(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def conformancePackEvaluationFilters(
      configRuleNames: Option[List[StringWithCharLimit64]] = None,
      complianceType: Option[String] = None,
      resourceType: Option[String] = None,
      resourceIds: Option[List[StringWithCharLimit256]] = None
    ): ConformancePackEvaluationFilters =
      ConformancePackEvaluationFilters
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .build

    def conformancePackInputParameter(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None
    ): ConformancePackInputParameter =
      ConformancePackInputParameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .build

    def conformancePackRuleCompliance(
      configRuleName: Option[String] = None,
      complianceType: Option[String] = None,
      controls: Option[List[StringWithCharLimit128]] = None
    ): ConformancePackRuleCompliance =
      ConformancePackRuleCompliance
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(controls)(_.controls(_))
        .build

    def conformancePackStatusDetail(
      conformancePackName: Option[String] = None,
      conformancePackId: Option[String] = None,
      conformancePackArn: Option[String] = None,
      conformancePackState: Option[String] = None,
      stackArn: Option[String] = None,
      conformancePackStatusReason: Option[String] = None,
      lastUpdateRequestedTime: Option[Date] = None,
      lastUpdateCompletedTime: Option[Date] = None
    ): ConformancePackStatusDetail =
      ConformancePackStatusDetail
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(conformancePackId)(_.conformancePackId(_))
        .ifSome(conformancePackArn)(_.conformancePackArn(_))
        .ifSome(conformancePackState)(_.conformancePackState(_))
        .ifSome(stackArn)(_.stackArn(_))
        .ifSome(conformancePackStatusReason)(_.conformancePackStatusReason(_))
        .ifSome(lastUpdateRequestedTime)(_.lastUpdateRequestedTime(_))
        .ifSome(lastUpdateCompletedTime)(_.lastUpdateCompletedTime(_))
        .build

    def conformancePackTemplateValidationException(

    ): ConformancePackTemplateValidationException =
      ConformancePackTemplateValidationException
        .builder

        .build

    def deleteAggregationAuthorizationRequest(
      authorizedAccountId: Option[String] = None,
      authorizedAwsRegion: Option[String] = None
    ): DeleteAggregationAuthorizationRequest =
      DeleteAggregationAuthorizationRequest
        .builder
        .ifSome(authorizedAccountId)(_.authorizedAccountId(_))
        .ifSome(authorizedAwsRegion)(_.authorizedAwsRegion(_))
        .build

    def deleteConfigRuleRequest(
      configRuleName: Option[String] = None
    ): DeleteConfigRuleRequest =
      DeleteConfigRuleRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .build

    def deleteConfigurationAggregatorRequest(
      configurationAggregatorName: Option[String] = None
    ): DeleteConfigurationAggregatorRequest =
      DeleteConfigurationAggregatorRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .build

    def deleteConfigurationRecorderRequest(
      configurationRecorderName: Option[String] = None
    ): DeleteConfigurationRecorderRequest =
      DeleteConfigurationRecorderRequest
        .builder
        .ifSome(configurationRecorderName)(_.configurationRecorderName(_))
        .build

    def deleteConformancePackRequest(
      conformancePackName: Option[String] = None
    ): DeleteConformancePackRequest =
      DeleteConformancePackRequest
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .build

    def deleteDeliveryChannelRequest(
      deliveryChannelName: Option[String] = None
    ): DeleteDeliveryChannelRequest =
      DeleteDeliveryChannelRequest
        .builder
        .ifSome(deliveryChannelName)(_.deliveryChannelName(_))
        .build

    def deleteEvaluationResultsRequest(
      configRuleName: Option[String] = None
    ): DeleteEvaluationResultsRequest =
      DeleteEvaluationResultsRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .build

    def deleteEvaluationResultsResponse(

    ): DeleteEvaluationResultsResponse =
      DeleteEvaluationResultsResponse
        .builder

        .build

    def deleteOrganizationConfigRuleRequest(
      organizationConfigRuleName: Option[String] = None
    ): DeleteOrganizationConfigRuleRequest =
      DeleteOrganizationConfigRuleRequest
        .builder
        .ifSome(organizationConfigRuleName)(_.organizationConfigRuleName(_))
        .build

    def deleteOrganizationConformancePackRequest(
      organizationConformancePackName: Option[String] = None
    ): DeleteOrganizationConformancePackRequest =
      DeleteOrganizationConformancePackRequest
        .builder
        .ifSome(organizationConformancePackName)(_.organizationConformancePackName(_))
        .build

    def deletePendingAggregationRequestRequest(
      requesterAccountId: Option[String] = None,
      requesterAwsRegion: Option[String] = None
    ): DeletePendingAggregationRequestRequest =
      DeletePendingAggregationRequestRequest
        .builder
        .ifSome(requesterAccountId)(_.requesterAccountId(_))
        .ifSome(requesterAwsRegion)(_.requesterAwsRegion(_))
        .build

    def deleteRemediationConfigurationRequest(
      configRuleName: Option[String] = None,
      resourceType: Option[String] = None
    ): DeleteRemediationConfigurationRequest =
      DeleteRemediationConfigurationRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def deleteRemediationConfigurationResponse(

    ): DeleteRemediationConfigurationResponse =
      DeleteRemediationConfigurationResponse
        .builder

        .build

    def deleteRemediationExceptionsRequest(
      configRuleName: Option[String] = None,
      resourceKeys: Option[List[RemediationExceptionResourceKey]] = None
    ): DeleteRemediationExceptionsRequest =
      DeleteRemediationExceptionsRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceKeys)(_.resourceKeys(_))
        .build

    def deleteRemediationExceptionsResponse(
      failedBatches: Option[List[FailedDeleteRemediationExceptionsBatch]] = None
    ): DeleteRemediationExceptionsResponse =
      DeleteRemediationExceptionsResponse
        .builder
        .ifSome(failedBatches)(_.failedBatches(_))
        .build

    def deleteResourceConfigRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): DeleteResourceConfigRequest =
      DeleteResourceConfigRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def deleteRetentionConfigurationRequest(
      retentionConfigurationName: Option[String] = None
    ): DeleteRetentionConfigurationRequest =
      DeleteRetentionConfigurationRequest
        .builder
        .ifSome(retentionConfigurationName)(_.retentionConfigurationName(_))
        .build

    def deleteStoredQueryRequest(
      queryName: Option[String] = None
    ): DeleteStoredQueryRequest =
      DeleteStoredQueryRequest
        .builder
        .ifSome(queryName)(_.queryName(_))
        .build

    def deleteStoredQueryResponse(

    ): DeleteStoredQueryResponse =
      DeleteStoredQueryResponse
        .builder

        .build

    def deliverConfigSnapshotRequest(
      deliveryChannelName: Option[String] = None
    ): DeliverConfigSnapshotRequest =
      DeliverConfigSnapshotRequest
        .builder
        .ifSome(deliveryChannelName)(_.deliveryChannelName(_))
        .build

    def deliverConfigSnapshotResponse(
      configSnapshotId: Option[String] = None
    ): DeliverConfigSnapshotResponse =
      DeliverConfigSnapshotResponse
        .builder
        .ifSome(configSnapshotId)(_.configSnapshotId(_))
        .build

    def deliveryChannel(
      name: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      s3KmsKeyArn: Option[String] = None,
      snsTopicARN: Option[String] = None,
      configSnapshotDeliveryProperties: Option[ConfigSnapshotDeliveryProperties] = None
    ): DeliveryChannel =
      DeliveryChannel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(s3KmsKeyArn)(_.s3KmsKeyArn(_))
        .ifSome(snsTopicARN)(_.snsTopicARN(_))
        .ifSome(configSnapshotDeliveryProperties)(_.configSnapshotDeliveryProperties(_))
        .build

    def deliveryChannelStatus(
      name: Option[String] = None,
      configSnapshotDeliveryInfo: Option[ConfigExportDeliveryInfo] = None,
      configHistoryDeliveryInfo: Option[ConfigExportDeliveryInfo] = None,
      configStreamDeliveryInfo: Option[ConfigStreamDeliveryInfo] = None
    ): DeliveryChannelStatus =
      DeliveryChannelStatus
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(configSnapshotDeliveryInfo)(_.configSnapshotDeliveryInfo(_))
        .ifSome(configHistoryDeliveryInfo)(_.configHistoryDeliveryInfo(_))
        .ifSome(configStreamDeliveryInfo)(_.configStreamDeliveryInfo(_))
        .build

    def describeAggregateComplianceByConfigRulesRequest(
      configurationAggregatorName: Option[String] = None,
      filters: Option[ConfigRuleComplianceFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAggregateComplianceByConfigRulesRequest =
      DescribeAggregateComplianceByConfigRulesRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAggregateComplianceByConfigRulesResponse(
      aggregateComplianceByConfigRules: Option[List[AggregateComplianceByConfigRule]] = None,
      nextToken: Option[String] = None
    ): DescribeAggregateComplianceByConfigRulesResponse =
      DescribeAggregateComplianceByConfigRulesResponse
        .builder
        .ifSome(aggregateComplianceByConfigRules)(_.aggregateComplianceByConfigRules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAggregateComplianceByConformancePacksRequest(
      configurationAggregatorName: Option[String] = None,
      filters: Option[AggregateConformancePackComplianceFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAggregateComplianceByConformancePacksRequest =
      DescribeAggregateComplianceByConformancePacksRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAggregateComplianceByConformancePacksResponse(
      aggregateComplianceByConformancePacks: Option[List[AggregateComplianceByConformancePack]] = None,
      nextToken: Option[String] = None
    ): DescribeAggregateComplianceByConformancePacksResponse =
      DescribeAggregateComplianceByConformancePacksResponse
        .builder
        .ifSome(aggregateComplianceByConformancePacks)(_.aggregateComplianceByConformancePacks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAggregationAuthorizationsRequest(
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAggregationAuthorizationsRequest =
      DescribeAggregationAuthorizationsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAggregationAuthorizationsResponse(
      aggregationAuthorizations: Option[List[AggregationAuthorization]] = None,
      nextToken: Option[String] = None
    ): DescribeAggregationAuthorizationsResponse =
      DescribeAggregationAuthorizationsResponse
        .builder
        .ifSome(aggregationAuthorizations)(_.aggregationAuthorizations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeComplianceByConfigRuleRequest(
      configRuleNames: Option[List[ConfigRuleName]] = None,
      complianceTypes: Option[List[ComplianceType]] = None,
      nextToken: Option[String] = None
    ): DescribeComplianceByConfigRuleRequest =
      DescribeComplianceByConfigRuleRequest
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .ifSome(complianceTypes)(_.complianceTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeComplianceByConfigRuleResponse(
      complianceByConfigRules: Option[List[ComplianceByConfigRule]] = None,
      nextToken: Option[String] = None
    ): DescribeComplianceByConfigRuleResponse =
      DescribeComplianceByConfigRuleResponse
        .builder
        .ifSome(complianceByConfigRules)(_.complianceByConfigRules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeComplianceByResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      complianceTypes: Option[List[ComplianceType]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeComplianceByResourceRequest =
      DescribeComplianceByResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(complianceTypes)(_.complianceTypes(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeComplianceByResourceResponse(
      complianceByResources: Option[List[ComplianceByResource]] = None,
      nextToken: Option[String] = None
    ): DescribeComplianceByResourceResponse =
      DescribeComplianceByResourceResponse
        .builder
        .ifSome(complianceByResources)(_.complianceByResources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigRuleEvaluationStatusRequest(
      configRuleNames: Option[List[ConfigRuleName]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeConfigRuleEvaluationStatusRequest =
      DescribeConfigRuleEvaluationStatusRequest
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeConfigRuleEvaluationStatusResponse(
      configRulesEvaluationStatus: Option[List[ConfigRuleEvaluationStatus]] = None,
      nextToken: Option[String] = None
    ): DescribeConfigRuleEvaluationStatusResponse =
      DescribeConfigRuleEvaluationStatusResponse
        .builder
        .ifSome(configRulesEvaluationStatus)(_.configRulesEvaluationStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigRulesRequest(
      configRuleNames: Option[List[ConfigRuleName]] = None,
      nextToken: Option[String] = None
    ): DescribeConfigRulesRequest =
      DescribeConfigRulesRequest
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigRulesResponse(
      configRules: Option[List[ConfigRule]] = None,
      nextToken: Option[String] = None
    ): DescribeConfigRulesResponse =
      DescribeConfigRulesResponse
        .builder
        .ifSome(configRules)(_.configRules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigurationAggregatorSourcesStatusRequest(
      configurationAggregatorName: Option[String] = None,
      updateStatus: Option[List[AggregatedSourceStatusType]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeConfigurationAggregatorSourcesStatusRequest =
      DescribeConfigurationAggregatorSourcesStatusRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeConfigurationAggregatorSourcesStatusResponse(
      aggregatedSourceStatusList: Option[List[AggregatedSourceStatus]] = None,
      nextToken: Option[String] = None
    ): DescribeConfigurationAggregatorSourcesStatusResponse =
      DescribeConfigurationAggregatorSourcesStatusResponse
        .builder
        .ifSome(aggregatedSourceStatusList)(_.aggregatedSourceStatusList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigurationAggregatorsRequest(
      configurationAggregatorNames: Option[List[ConfigurationAggregatorName]] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeConfigurationAggregatorsRequest =
      DescribeConfigurationAggregatorsRequest
        .builder
        .ifSome(configurationAggregatorNames)(_.configurationAggregatorNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeConfigurationAggregatorsResponse(
      configurationAggregators: Option[List[ConfigurationAggregator]] = None,
      nextToken: Option[String] = None
    ): DescribeConfigurationAggregatorsResponse =
      DescribeConfigurationAggregatorsResponse
        .builder
        .ifSome(configurationAggregators)(_.configurationAggregators(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConfigurationRecorderStatusRequest(
      configurationRecorderNames: Option[List[RecorderName]] = None
    ): DescribeConfigurationRecorderStatusRequest =
      DescribeConfigurationRecorderStatusRequest
        .builder
        .ifSome(configurationRecorderNames)(_.configurationRecorderNames(_))
        .build

    def describeConfigurationRecorderStatusResponse(
      configurationRecordersStatus: Option[List[ConfigurationRecorderStatus]] = None
    ): DescribeConfigurationRecorderStatusResponse =
      DescribeConfigurationRecorderStatusResponse
        .builder
        .ifSome(configurationRecordersStatus)(_.configurationRecordersStatus(_))
        .build

    def describeConfigurationRecordersRequest(
      configurationRecorderNames: Option[List[RecorderName]] = None
    ): DescribeConfigurationRecordersRequest =
      DescribeConfigurationRecordersRequest
        .builder
        .ifSome(configurationRecorderNames)(_.configurationRecorderNames(_))
        .build

    def describeConfigurationRecordersResponse(
      configurationRecorders: Option[List[ConfigurationRecorder]] = None
    ): DescribeConfigurationRecordersResponse =
      DescribeConfigurationRecordersResponse
        .builder
        .ifSome(configurationRecorders)(_.configurationRecorders(_))
        .build

    def describeConformancePackComplianceRequest(
      conformancePackName: Option[String] = None,
      filters: Option[ConformancePackComplianceFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeConformancePackComplianceRequest =
      DescribeConformancePackComplianceRequest
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConformancePackComplianceResponse(
      conformancePackName: Option[String] = None,
      conformancePackRuleComplianceList: Option[List[ConformancePackRuleCompliance]] = None,
      nextToken: Option[String] = None
    ): DescribeConformancePackComplianceResponse =
      DescribeConformancePackComplianceResponse
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(conformancePackRuleComplianceList)(_.conformancePackRuleComplianceList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConformancePackStatusRequest(
      conformancePackNames: Option[List[ConformancePackName]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeConformancePackStatusRequest =
      DescribeConformancePackStatusRequest
        .builder
        .ifSome(conformancePackNames)(_.conformancePackNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConformancePackStatusResponse(
      conformancePackStatusDetails: Option[List[ConformancePackStatusDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeConformancePackStatusResponse =
      DescribeConformancePackStatusResponse
        .builder
        .ifSome(conformancePackStatusDetails)(_.conformancePackStatusDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConformancePacksRequest(
      conformancePackNames: Option[List[ConformancePackName]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeConformancePacksRequest =
      DescribeConformancePacksRequest
        .builder
        .ifSome(conformancePackNames)(_.conformancePackNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeConformancePacksResponse(
      conformancePackDetails: Option[List[ConformancePackDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeConformancePacksResponse =
      DescribeConformancePacksResponse
        .builder
        .ifSome(conformancePackDetails)(_.conformancePackDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDeliveryChannelStatusRequest(
      deliveryChannelNames: Option[List[ChannelName]] = None
    ): DescribeDeliveryChannelStatusRequest =
      DescribeDeliveryChannelStatusRequest
        .builder
        .ifSome(deliveryChannelNames)(_.deliveryChannelNames(_))
        .build

    def describeDeliveryChannelStatusResponse(
      deliveryChannelsStatus: Option[List[DeliveryChannelStatus]] = None
    ): DescribeDeliveryChannelStatusResponse =
      DescribeDeliveryChannelStatusResponse
        .builder
        .ifSome(deliveryChannelsStatus)(_.deliveryChannelsStatus(_))
        .build

    def describeDeliveryChannelsRequest(
      deliveryChannelNames: Option[List[ChannelName]] = None
    ): DescribeDeliveryChannelsRequest =
      DescribeDeliveryChannelsRequest
        .builder
        .ifSome(deliveryChannelNames)(_.deliveryChannelNames(_))
        .build

    def describeDeliveryChannelsResponse(
      deliveryChannels: Option[List[DeliveryChannel]] = None
    ): DescribeDeliveryChannelsResponse =
      DescribeDeliveryChannelsResponse
        .builder
        .ifSome(deliveryChannels)(_.deliveryChannels(_))
        .build

    def describeOrganizationConfigRuleStatusesRequest(
      organizationConfigRuleNames: Option[List[StringWithCharLimit64]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConfigRuleStatusesRequest =
      DescribeOrganizationConfigRuleStatusesRequest
        .builder
        .ifSome(organizationConfigRuleNames)(_.organizationConfigRuleNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConfigRuleStatusesResponse(
      organizationConfigRuleStatuses: Option[List[OrganizationConfigRuleStatus]] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConfigRuleStatusesResponse =
      DescribeOrganizationConfigRuleStatusesResponse
        .builder
        .ifSome(organizationConfigRuleStatuses)(_.organizationConfigRuleStatuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConfigRulesRequest(
      organizationConfigRuleNames: Option[List[StringWithCharLimit64]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConfigRulesRequest =
      DescribeOrganizationConfigRulesRequest
        .builder
        .ifSome(organizationConfigRuleNames)(_.organizationConfigRuleNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConfigRulesResponse(
      organizationConfigRules: Option[List[OrganizationConfigRule]] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConfigRulesResponse =
      DescribeOrganizationConfigRulesResponse
        .builder
        .ifSome(organizationConfigRules)(_.organizationConfigRules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConformancePackStatusesRequest(
      organizationConformancePackNames: Option[List[OrganizationConformancePackName]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConformancePackStatusesRequest =
      DescribeOrganizationConformancePackStatusesRequest
        .builder
        .ifSome(organizationConformancePackNames)(_.organizationConformancePackNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConformancePackStatusesResponse(
      organizationConformancePackStatuses: Option[List[OrganizationConformancePackStatus]] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConformancePackStatusesResponse =
      DescribeOrganizationConformancePackStatusesResponse
        .builder
        .ifSome(organizationConformancePackStatuses)(_.organizationConformancePackStatuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConformancePacksRequest(
      organizationConformancePackNames: Option[List[OrganizationConformancePackName]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConformancePacksRequest =
      DescribeOrganizationConformancePacksRequest
        .builder
        .ifSome(organizationConformancePackNames)(_.organizationConformancePackNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOrganizationConformancePacksResponse(
      organizationConformancePacks: Option[List[OrganizationConformancePack]] = None,
      nextToken: Option[String] = None
    ): DescribeOrganizationConformancePacksResponse =
      DescribeOrganizationConformancePacksResponse
        .builder
        .ifSome(organizationConformancePacks)(_.organizationConformancePacks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePendingAggregationRequestsRequest(
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribePendingAggregationRequestsRequest =
      DescribePendingAggregationRequestsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePendingAggregationRequestsResponse(
      pendingAggregationRequests: Option[List[PendingAggregationRequest]] = None,
      nextToken: Option[String] = None
    ): DescribePendingAggregationRequestsResponse =
      DescribePendingAggregationRequestsResponse
        .builder
        .ifSome(pendingAggregationRequests)(_.pendingAggregationRequests(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRemediationConfigurationsRequest(
      configRuleNames: Option[List[ConfigRuleName]] = None
    ): DescribeRemediationConfigurationsRequest =
      DescribeRemediationConfigurationsRequest
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .build

    def describeRemediationConfigurationsResponse(
      remediationConfigurations: Option[List[RemediationConfiguration]] = None
    ): DescribeRemediationConfigurationsResponse =
      DescribeRemediationConfigurationsResponse
        .builder
        .ifSome(remediationConfigurations)(_.remediationConfigurations(_))
        .build

    def describeRemediationExceptionsRequest(
      configRuleName: Option[String] = None,
      resourceKeys: Option[List[RemediationExceptionResourceKey]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeRemediationExceptionsRequest =
      DescribeRemediationExceptionsRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceKeys)(_.resourceKeys(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRemediationExceptionsResponse(
      remediationExceptions: Option[List[RemediationException]] = None,
      nextToken: Option[String] = None
    ): DescribeRemediationExceptionsResponse =
      DescribeRemediationExceptionsResponse
        .builder
        .ifSome(remediationExceptions)(_.remediationExceptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRemediationExecutionStatusRequest(
      configRuleName: Option[String] = None,
      resourceKeys: Option[List[ResourceKey]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeRemediationExecutionStatusRequest =
      DescribeRemediationExecutionStatusRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceKeys)(_.resourceKeys(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRemediationExecutionStatusResponse(
      remediationExecutionStatuses: Option[List[RemediationExecutionStatus]] = None,
      nextToken: Option[String] = None
    ): DescribeRemediationExecutionStatusResponse =
      DescribeRemediationExecutionStatusResponse
        .builder
        .ifSome(remediationExecutionStatuses)(_.remediationExecutionStatuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRetentionConfigurationsRequest(
      retentionConfigurationNames: Option[List[RetentionConfigurationName]] = None,
      nextToken: Option[String] = None
    ): DescribeRetentionConfigurationsRequest =
      DescribeRetentionConfigurationsRequest
        .builder
        .ifSome(retentionConfigurationNames)(_.retentionConfigurationNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRetentionConfigurationsResponse(
      retentionConfigurations: Option[List[RetentionConfiguration]] = None,
      nextToken: Option[String] = None
    ): DescribeRetentionConfigurationsResponse =
      DescribeRetentionConfigurationsResponse
        .builder
        .ifSome(retentionConfigurations)(_.retentionConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def evaluation(
      complianceResourceType: Option[String] = None,
      complianceResourceId: Option[String] = None,
      complianceType: Option[String] = None,
      annotation: Option[String] = None,
      orderingTimestamp: Option[OrderingTimestamp] = None
    ): Evaluation =
      Evaluation
        .builder
        .ifSome(complianceResourceType)(_.complianceResourceType(_))
        .ifSome(complianceResourceId)(_.complianceResourceId(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(annotation)(_.annotation(_))
        .ifSome(orderingTimestamp)(_.orderingTimestamp(_))
        .build

    def evaluationResultIdentifier(
      evaluationResultQualifier: Option[EvaluationResultQualifier] = None,
      orderingTimestamp: Option[Date] = None
    ): EvaluationResultIdentifier =
      EvaluationResultIdentifier
        .builder
        .ifSome(evaluationResultQualifier)(_.evaluationResultQualifier(_))
        .ifSome(orderingTimestamp)(_.orderingTimestamp(_))
        .build

    def evaluationResultQualifier(
      configRuleName: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): EvaluationResultQualifier =
      EvaluationResultQualifier
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def executionControls(
      ssmControls: Option[SsmControls] = None
    ): ExecutionControls =
      ExecutionControls
        .builder
        .ifSome(ssmControls)(_.ssmControls(_))
        .build

    def externalEvaluation(
      complianceResourceType: Option[String] = None,
      complianceResourceId: Option[String] = None,
      complianceType: Option[String] = None,
      annotation: Option[String] = None,
      orderingTimestamp: Option[OrderingTimestamp] = None
    ): ExternalEvaluation =
      ExternalEvaluation
        .builder
        .ifSome(complianceResourceType)(_.complianceResourceType(_))
        .ifSome(complianceResourceId)(_.complianceResourceId(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(annotation)(_.annotation(_))
        .ifSome(orderingTimestamp)(_.orderingTimestamp(_))
        .build

    def failedDeleteRemediationExceptionsBatch(
      failureMessage: Option[String] = None,
      failedItems: Option[List[RemediationExceptionResourceKey]] = None
    ): FailedDeleteRemediationExceptionsBatch =
      FailedDeleteRemediationExceptionsBatch
        .builder
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def failedRemediationBatch(
      failureMessage: Option[String] = None,
      failedItems: Option[List[RemediationConfiguration]] = None
    ): FailedRemediationBatch =
      FailedRemediationBatch
        .builder
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def failedRemediationExceptionBatch(
      failureMessage: Option[String] = None,
      failedItems: Option[List[RemediationException]] = None
    ): FailedRemediationExceptionBatch =
      FailedRemediationExceptionBatch
        .builder
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def fieldInfo(
      name: Option[String] = None
    ): FieldInfo =
      FieldInfo
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getAggregateComplianceDetailsByConfigRuleRequest(
      configurationAggregatorName: Option[String] = None,
      configRuleName: Option[String] = None,
      accountId: Option[String] = None,
      awsRegion: Option[String] = None,
      complianceType: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetAggregateComplianceDetailsByConfigRuleRequest =
      GetAggregateComplianceDetailsByConfigRuleRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateComplianceDetailsByConfigRuleResponse(
      aggregateEvaluationResults: Option[List[AggregateEvaluationResult]] = None,
      nextToken: Option[String] = None
    ): GetAggregateComplianceDetailsByConfigRuleResponse =
      GetAggregateComplianceDetailsByConfigRuleResponse
        .builder
        .ifSome(aggregateEvaluationResults)(_.aggregateEvaluationResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateConfigRuleComplianceSummaryRequest(
      configurationAggregatorName: Option[String] = None,
      filters: Option[ConfigRuleComplianceSummaryFilters] = None,
      groupByKey: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetAggregateConfigRuleComplianceSummaryRequest =
      GetAggregateConfigRuleComplianceSummaryRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupByKey)(_.groupByKey(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateConfigRuleComplianceSummaryResponse(
      groupByKey: Option[String] = None,
      aggregateComplianceCounts: Option[List[AggregateComplianceCount]] = None,
      nextToken: Option[String] = None
    ): GetAggregateConfigRuleComplianceSummaryResponse =
      GetAggregateConfigRuleComplianceSummaryResponse
        .builder
        .ifSome(groupByKey)(_.groupByKey(_))
        .ifSome(aggregateComplianceCounts)(_.aggregateComplianceCounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateConformancePackComplianceSummaryRequest(
      configurationAggregatorName: Option[String] = None,
      filters: Option[AggregateConformancePackComplianceSummaryFilters] = None,
      groupByKey: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetAggregateConformancePackComplianceSummaryRequest =
      GetAggregateConformancePackComplianceSummaryRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupByKey)(_.groupByKey(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateConformancePackComplianceSummaryResponse(
      aggregateConformancePackComplianceSummaries: Option[List[AggregateConformancePackComplianceSummary]] = None,
      groupByKey: Option[String] = None,
      nextToken: Option[String] = None
    ): GetAggregateConformancePackComplianceSummaryResponse =
      GetAggregateConformancePackComplianceSummaryResponse
        .builder
        .ifSome(aggregateConformancePackComplianceSummaries)(_.aggregateConformancePackComplianceSummaries(_))
        .ifSome(groupByKey)(_.groupByKey(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateDiscoveredResourceCountsRequest(
      configurationAggregatorName: Option[String] = None,
      filters: Option[ResourceCountFilters] = None,
      groupByKey: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetAggregateDiscoveredResourceCountsRequest =
      GetAggregateDiscoveredResourceCountsRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(groupByKey)(_.groupByKey(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateDiscoveredResourceCountsResponse(
      totalDiscoveredResources: Option[Long] = None,
      groupByKey: Option[String] = None,
      groupedResourceCounts: Option[List[GroupedResourceCount]] = None,
      nextToken: Option[String] = None
    ): GetAggregateDiscoveredResourceCountsResponse =
      GetAggregateDiscoveredResourceCountsResponse
        .builder
        .ifSome(totalDiscoveredResources)(_.totalDiscoveredResources(_))
        .ifSome(groupByKey)(_.groupByKey(_))
        .ifSome(groupedResourceCounts)(_.groupedResourceCounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAggregateResourceConfigRequest(
      configurationAggregatorName: Option[String] = None,
      resourceIdentifier: Option[AggregateResourceIdentifier] = None
    ): GetAggregateResourceConfigRequest =
      GetAggregateResourceConfigRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .build

    def getAggregateResourceConfigResponse(
      configurationItem: Option[ConfigurationItem] = None
    ): GetAggregateResourceConfigResponse =
      GetAggregateResourceConfigResponse
        .builder
        .ifSome(configurationItem)(_.configurationItem(_))
        .build

    def getComplianceDetailsByConfigRuleRequest(
      configRuleName: Option[String] = None,
      complianceTypes: Option[List[ComplianceType]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetComplianceDetailsByConfigRuleRequest =
      GetComplianceDetailsByConfigRuleRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(complianceTypes)(_.complianceTypes(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getComplianceDetailsByConfigRuleResponse(
      evaluationResults: Option[List[EvaluationResult]] = None,
      nextToken: Option[String] = None
    ): GetComplianceDetailsByConfigRuleResponse =
      GetComplianceDetailsByConfigRuleResponse
        .builder
        .ifSome(evaluationResults)(_.evaluationResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getComplianceDetailsByResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      complianceTypes: Option[List[ComplianceType]] = None,
      nextToken: Option[String] = None
    ): GetComplianceDetailsByResourceRequest =
      GetComplianceDetailsByResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(complianceTypes)(_.complianceTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getComplianceDetailsByResourceResponse(
      evaluationResults: Option[List[EvaluationResult]] = None,
      nextToken: Option[String] = None
    ): GetComplianceDetailsByResourceResponse =
      GetComplianceDetailsByResourceResponse
        .builder
        .ifSome(evaluationResults)(_.evaluationResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getComplianceSummaryByConfigRuleResponse(
      complianceSummary: Option[ComplianceSummary] = None
    ): GetComplianceSummaryByConfigRuleResponse =
      GetComplianceSummaryByConfigRuleResponse
        .builder
        .ifSome(complianceSummary)(_.complianceSummary(_))
        .build

    def getComplianceSummaryByResourceTypeRequest(
      resourceTypes: Option[List[StringWithCharLimit256]] = None
    ): GetComplianceSummaryByResourceTypeRequest =
      GetComplianceSummaryByResourceTypeRequest
        .builder
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .build

    def getComplianceSummaryByResourceTypeResponse(
      complianceSummariesByResourceType: Option[List[ComplianceSummaryByResourceType]] = None
    ): GetComplianceSummaryByResourceTypeResponse =
      GetComplianceSummaryByResourceTypeResponse
        .builder
        .ifSome(complianceSummariesByResourceType)(_.complianceSummariesByResourceType(_))
        .build

    def getConformancePackComplianceDetailsRequest(
      conformancePackName: Option[String] = None,
      filters: Option[ConformancePackEvaluationFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetConformancePackComplianceDetailsRequest =
      GetConformancePackComplianceDetailsRequest
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getConformancePackComplianceDetailsResponse(
      conformancePackName: Option[String] = None,
      conformancePackRuleEvaluationResults: Option[List[ConformancePackEvaluationResult]] = None,
      nextToken: Option[String] = None
    ): GetConformancePackComplianceDetailsResponse =
      GetConformancePackComplianceDetailsResponse
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(conformancePackRuleEvaluationResults)(_.conformancePackRuleEvaluationResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getConformancePackComplianceSummaryRequest(
      conformancePackNames: Option[List[ConformancePackName]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetConformancePackComplianceSummaryRequest =
      GetConformancePackComplianceSummaryRequest
        .builder
        .ifSome(conformancePackNames)(_.conformancePackNames(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getConformancePackComplianceSummaryResponse(
      conformancePackComplianceSummaryList: Option[List[ConformancePackComplianceSummary]] = None,
      nextToken: Option[String] = None
    ): GetConformancePackComplianceSummaryResponse =
      GetConformancePackComplianceSummaryResponse
        .builder
        .ifSome(conformancePackComplianceSummaryList)(_.conformancePackComplianceSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDiscoveredResourceCountsRequest(
      resourceTypes: Option[List[StringWithCharLimit256]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetDiscoveredResourceCountsRequest =
      GetDiscoveredResourceCountsRequest
        .builder
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDiscoveredResourceCountsResponse(
      totalDiscoveredResources: Option[Long] = None,
      resourceCounts: Option[List[ResourceCount]] = None,
      nextToken: Option[String] = None
    ): GetDiscoveredResourceCountsResponse =
      GetDiscoveredResourceCountsResponse
        .builder
        .ifSome(totalDiscoveredResources)(_.totalDiscoveredResources(_))
        .ifSome(resourceCounts)(_.resourceCounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getOrganizationConfigRuleDetailedStatusRequest(
      organizationConfigRuleName: Option[String] = None,
      filters: Option[StatusDetailFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetOrganizationConfigRuleDetailedStatusRequest =
      GetOrganizationConfigRuleDetailedStatusRequest
        .builder
        .ifSome(organizationConfigRuleName)(_.organizationConfigRuleName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getOrganizationConfigRuleDetailedStatusResponse(
      organizationConfigRuleDetailedStatus: Option[List[MemberAccountStatus]] = None,
      nextToken: Option[String] = None
    ): GetOrganizationConfigRuleDetailedStatusResponse =
      GetOrganizationConfigRuleDetailedStatusResponse
        .builder
        .ifSome(organizationConfigRuleDetailedStatus)(_.organizationConfigRuleDetailedStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getOrganizationConformancePackDetailedStatusRequest(
      organizationConformancePackName: Option[String] = None,
      filters: Option[OrganizationResourceDetailedStatusFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetOrganizationConformancePackDetailedStatusRequest =
      GetOrganizationConformancePackDetailedStatusRequest
        .builder
        .ifSome(organizationConformancePackName)(_.organizationConformancePackName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getOrganizationConformancePackDetailedStatusResponse(
      organizationConformancePackDetailedStatuses: Option[List[OrganizationConformancePackDetailedStatus]] = None,
      nextToken: Option[String] = None
    ): GetOrganizationConformancePackDetailedStatusResponse =
      GetOrganizationConformancePackDetailedStatusResponse
        .builder
        .ifSome(organizationConformancePackDetailedStatuses)(_.organizationConformancePackDetailedStatuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceConfigHistoryRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      laterTime: Option[LaterTime] = None,
      earlierTime: Option[EarlierTime] = None,
      chronologicalOrder: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetResourceConfigHistoryRequest =
      GetResourceConfigHistoryRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(laterTime)(_.laterTime(_))
        .ifSome(earlierTime)(_.earlierTime(_))
        .ifSome(chronologicalOrder)(_.chronologicalOrder(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceConfigHistoryResponse(
      configurationItems: Option[List[ConfigurationItem]] = None,
      nextToken: Option[String] = None
    ): GetResourceConfigHistoryResponse =
      GetResourceConfigHistoryResponse
        .builder
        .ifSome(configurationItems)(_.configurationItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getStoredQueryRequest(
      queryName: Option[String] = None
    ): GetStoredQueryRequest =
      GetStoredQueryRequest
        .builder
        .ifSome(queryName)(_.queryName(_))
        .build

    def getStoredQueryResponse(
      storedQuery: Option[StoredQuery] = None
    ): GetStoredQueryResponse =
      GetStoredQueryResponse
        .builder
        .ifSome(storedQuery)(_.storedQuery(_))
        .build

    def groupedResourceCount(
      groupName: Option[String] = None,
      resourceCount: Option[Long] = None
    ): GroupedResourceCount =
      GroupedResourceCount
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(resourceCount)(_.resourceCount(_))
        .build

    def insufficientDeliveryPolicyException(

    ): InsufficientDeliveryPolicyException =
      InsufficientDeliveryPolicyException
        .builder

        .build

    def insufficientPermissionsException(

    ): InsufficientPermissionsException =
      InsufficientPermissionsException
        .builder

        .build

    def invalidConfigurationRecorderNameException(

    ): InvalidConfigurationRecorderNameException =
      InvalidConfigurationRecorderNameException
        .builder

        .build

    def invalidDeliveryChannelNameException(

    ): InvalidDeliveryChannelNameException =
      InvalidDeliveryChannelNameException
        .builder

        .build

    def invalidExpressionException(

    ): InvalidExpressionException =
      InvalidExpressionException
        .builder

        .build

    def invalidLimitException(

    ): InvalidLimitException =
      InvalidLimitException
        .builder

        .build

    def invalidNextTokenException(

    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder

        .build

    def invalidParameterValueException(

    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder

        .build

    def invalidRecordingGroupException(

    ): InvalidRecordingGroupException =
      InvalidRecordingGroupException
        .builder

        .build

    def invalidResultTokenException(

    ): InvalidResultTokenException =
      InvalidResultTokenException
        .builder

        .build

    def invalidRoleException(

    ): InvalidRoleException =
      InvalidRoleException
        .builder

        .build

    def invalidS3KeyPrefixException(

    ): InvalidS3KeyPrefixException =
      InvalidS3KeyPrefixException
        .builder

        .build

    def invalidS3KmsKeyArnException(

    ): InvalidS3KmsKeyArnException =
      InvalidS3KmsKeyArnException
        .builder

        .build

    def invalidSNSTopicARNException(

    ): InvalidSNSTopicARNException =
      InvalidSNSTopicARNException
        .builder

        .build

    def invalidTimeRangeException(

    ): InvalidTimeRangeException =
      InvalidTimeRangeException
        .builder

        .build

    def lastDeliveryChannelDeleteFailedException(

    ): LastDeliveryChannelDeleteFailedException =
      LastDeliveryChannelDeleteFailedException
        .builder

        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listAggregateDiscoveredResourcesRequest(
      configurationAggregatorName: Option[String] = None,
      resourceType: Option[String] = None,
      filters: Option[ResourceFilters] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAggregateDiscoveredResourcesRequest =
      ListAggregateDiscoveredResourcesRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAggregateDiscoveredResourcesResponse(
      resourceIdentifiers: Option[List[AggregateResourceIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListAggregateDiscoveredResourcesResponse =
      ListAggregateDiscoveredResourcesResponse
        .builder
        .ifSome(resourceIdentifiers)(_.resourceIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDiscoveredResourcesRequest(
      resourceType: Option[String] = None,
      resourceIds: Option[List[ResourceId]] = None,
      resourceName: Option[String] = None,
      limit: Option[Int] = None,
      includeDeletedResources: Option[Boolean] = None,
      nextToken: Option[String] = None
    ): ListDiscoveredResourcesRequest =
      ListDiscoveredResourcesRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(includeDeletedResources)(_.includeDeletedResources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDiscoveredResourcesResponse(
      resourceIdentifiers: Option[List[ResourceIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListDiscoveredResourcesResponse =
      ListDiscoveredResourcesResponse
        .builder
        .ifSome(resourceIdentifiers)(_.resourceIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStoredQueriesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListStoredQueriesRequest =
      ListStoredQueriesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listStoredQueriesResponse(
      storedQueryMetadata: Option[List[StoredQueryMetadata]] = None,
      nextToken: Option[String] = None
    ): ListStoredQueriesResponse =
      ListStoredQueriesResponse
        .builder
        .ifSome(storedQueryMetadata)(_.storedQueryMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def maxActiveResourcesExceededException(

    ): MaxActiveResourcesExceededException =
      MaxActiveResourcesExceededException
        .builder

        .build

    def maxNumberOfConfigRulesExceededException(

    ): MaxNumberOfConfigRulesExceededException =
      MaxNumberOfConfigRulesExceededException
        .builder

        .build

    def maxNumberOfConfigurationRecordersExceededException(

    ): MaxNumberOfConfigurationRecordersExceededException =
      MaxNumberOfConfigurationRecordersExceededException
        .builder

        .build

    def maxNumberOfConformancePacksExceededException(

    ): MaxNumberOfConformancePacksExceededException =
      MaxNumberOfConformancePacksExceededException
        .builder

        .build

    def maxNumberOfDeliveryChannelsExceededException(

    ): MaxNumberOfDeliveryChannelsExceededException =
      MaxNumberOfDeliveryChannelsExceededException
        .builder

        .build

    def maxNumberOfOrganizationConfigRulesExceededException(

    ): MaxNumberOfOrganizationConfigRulesExceededException =
      MaxNumberOfOrganizationConfigRulesExceededException
        .builder

        .build

    def maxNumberOfOrganizationConformancePacksExceededException(

    ): MaxNumberOfOrganizationConformancePacksExceededException =
      MaxNumberOfOrganizationConformancePacksExceededException
        .builder

        .build

    def maxNumberOfRetentionConfigurationsExceededException(

    ): MaxNumberOfRetentionConfigurationsExceededException =
      MaxNumberOfRetentionConfigurationsExceededException
        .builder

        .build

    def memberAccountStatus(
      accountId: Option[String] = None,
      configRuleName: Option[String] = None,
      memberAccountRuleStatus: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      lastUpdateTime: Option[Date] = None
    ): MemberAccountStatus =
      MemberAccountStatus
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(memberAccountRuleStatus)(_.memberAccountRuleStatus(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def noAvailableConfigurationRecorderException(

    ): NoAvailableConfigurationRecorderException =
      NoAvailableConfigurationRecorderException
        .builder

        .build

    def noAvailableDeliveryChannelException(

    ): NoAvailableDeliveryChannelException =
      NoAvailableDeliveryChannelException
        .builder

        .build

    def noAvailableOrganizationException(

    ): NoAvailableOrganizationException =
      NoAvailableOrganizationException
        .builder

        .build

    def noRunningConfigurationRecorderException(

    ): NoRunningConfigurationRecorderException =
      NoRunningConfigurationRecorderException
        .builder

        .build

    def noSuchBucketException(

    ): NoSuchBucketException =
      NoSuchBucketException
        .builder

        .build

    def noSuchConfigRuleException(

    ): NoSuchConfigRuleException =
      NoSuchConfigRuleException
        .builder

        .build

    def noSuchConfigRuleInConformancePackException(

    ): NoSuchConfigRuleInConformancePackException =
      NoSuchConfigRuleInConformancePackException
        .builder

        .build

    def noSuchConfigurationAggregatorException(

    ): NoSuchConfigurationAggregatorException =
      NoSuchConfigurationAggregatorException
        .builder

        .build

    def noSuchConfigurationRecorderException(

    ): NoSuchConfigurationRecorderException =
      NoSuchConfigurationRecorderException
        .builder

        .build

    def noSuchConformancePackException(

    ): NoSuchConformancePackException =
      NoSuchConformancePackException
        .builder

        .build

    def noSuchDeliveryChannelException(

    ): NoSuchDeliveryChannelException =
      NoSuchDeliveryChannelException
        .builder

        .build

    def noSuchOrganizationConfigRuleException(

    ): NoSuchOrganizationConfigRuleException =
      NoSuchOrganizationConfigRuleException
        .builder

        .build

    def noSuchOrganizationConformancePackException(

    ): NoSuchOrganizationConformancePackException =
      NoSuchOrganizationConformancePackException
        .builder

        .build

    def noSuchRemediationConfigurationException(

    ): NoSuchRemediationConfigurationException =
      NoSuchRemediationConfigurationException
        .builder

        .build

    def noSuchRemediationExceptionException(

    ): NoSuchRemediationExceptionException =
      NoSuchRemediationExceptionException
        .builder

        .build

    def noSuchRetentionConfigurationException(

    ): NoSuchRetentionConfigurationException =
      NoSuchRetentionConfigurationException
        .builder

        .build

    def organizationAccessDeniedException(

    ): OrganizationAccessDeniedException =
      OrganizationAccessDeniedException
        .builder

        .build

    def organizationAggregationSource(
      roleArn: Option[String] = None,
      awsRegions: Option[List[String]] = None,
      allAwsRegions: Option[Boolean] = None
    ): OrganizationAggregationSource =
      OrganizationAggregationSource
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(awsRegions)(_.awsRegions(_))
        .ifSome(allAwsRegions)(_.allAwsRegions(_))
        .build

    def organizationAllFeaturesNotEnabledException(

    ): OrganizationAllFeaturesNotEnabledException =
      OrganizationAllFeaturesNotEnabledException
        .builder

        .build

    def organizationConfigRule(
      organizationConfigRuleName: Option[String] = None,
      organizationConfigRuleArn: Option[String] = None,
      organizationManagedRuleMetadata: Option[OrganizationManagedRuleMetadata] = None,
      organizationCustomRuleMetadata: Option[OrganizationCustomRuleMetadata] = None,
      excludedAccounts: Option[List[AccountId]] = None,
      lastUpdateTime: Option[Date] = None
    ): OrganizationConfigRule =
      OrganizationConfigRule
        .builder
        .ifSome(organizationConfigRuleName)(_.organizationConfigRuleName(_))
        .ifSome(organizationConfigRuleArn)(_.organizationConfigRuleArn(_))
        .ifSome(organizationManagedRuleMetadata)(_.organizationManagedRuleMetadata(_))
        .ifSome(organizationCustomRuleMetadata)(_.organizationCustomRuleMetadata(_))
        .ifSome(excludedAccounts)(_.excludedAccounts(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def organizationConfigRuleStatus(
      organizationConfigRuleName: Option[String] = None,
      organizationRuleStatus: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      lastUpdateTime: Option[Date] = None
    ): OrganizationConfigRuleStatus =
      OrganizationConfigRuleStatus
        .builder
        .ifSome(organizationConfigRuleName)(_.organizationConfigRuleName(_))
        .ifSome(organizationRuleStatus)(_.organizationRuleStatus(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def organizationConformancePack(
      organizationConformancePackName: Option[String] = None,
      organizationConformancePackArn: Option[String] = None,
      deliveryS3Bucket: Option[String] = None,
      deliveryS3KeyPrefix: Option[String] = None,
      conformancePackInputParameters: Option[List[ConformancePackInputParameter]] = None,
      excludedAccounts: Option[List[AccountId]] = None,
      lastUpdateTime: Option[Date] = None
    ): OrganizationConformancePack =
      OrganizationConformancePack
        .builder
        .ifSome(organizationConformancePackName)(_.organizationConformancePackName(_))
        .ifSome(organizationConformancePackArn)(_.organizationConformancePackArn(_))
        .ifSome(deliveryS3Bucket)(_.deliveryS3Bucket(_))
        .ifSome(deliveryS3KeyPrefix)(_.deliveryS3KeyPrefix(_))
        .ifSome(conformancePackInputParameters)(_.conformancePackInputParameters(_))
        .ifSome(excludedAccounts)(_.excludedAccounts(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def organizationConformancePackDetailedStatus(
      accountId: Option[String] = None,
      conformancePackName: Option[String] = None,
      status: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      lastUpdateTime: Option[Date] = None
    ): OrganizationConformancePackDetailedStatus =
      OrganizationConformancePackDetailedStatus
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def organizationConformancePackStatus(
      organizationConformancePackName: Option[String] = None,
      status: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      lastUpdateTime: Option[Date] = None
    ): OrganizationConformancePackStatus =
      OrganizationConformancePackStatus
        .builder
        .ifSome(organizationConformancePackName)(_.organizationConformancePackName(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def organizationConformancePackTemplateValidationException(

    ): OrganizationConformancePackTemplateValidationException =
      OrganizationConformancePackTemplateValidationException
        .builder

        .build

    def organizationCustomRuleMetadata(
      description: Option[String] = None,
      lambdaFunctionArn: Option[String] = None,
      organizationConfigRuleTriggerTypes: Option[List[OrganizationConfigRuleTriggerType]] = None,
      inputParameters: Option[String] = None,
      maximumExecutionFrequency: Option[String] = None,
      resourceTypesScope: Option[List[StringWithCharLimit256]] = None,
      resourceIdScope: Option[String] = None,
      tagKeyScope: Option[String] = None,
      tagValueScope: Option[String] = None
    ): OrganizationCustomRuleMetadata =
      OrganizationCustomRuleMetadata
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .ifSome(organizationConfigRuleTriggerTypes)(_.organizationConfigRuleTriggerTypes(_))
        .ifSome(inputParameters)(_.inputParameters(_))
        .ifSome(maximumExecutionFrequency)(_.maximumExecutionFrequency(_))
        .ifSome(resourceTypesScope)(_.resourceTypesScope(_))
        .ifSome(resourceIdScope)(_.resourceIdScope(_))
        .ifSome(tagKeyScope)(_.tagKeyScope(_))
        .ifSome(tagValueScope)(_.tagValueScope(_))
        .build

    def organizationManagedRuleMetadata(
      description: Option[String] = None,
      ruleIdentifier: Option[String] = None,
      inputParameters: Option[String] = None,
      maximumExecutionFrequency: Option[String] = None,
      resourceTypesScope: Option[List[StringWithCharLimit256]] = None,
      resourceIdScope: Option[String] = None,
      tagKeyScope: Option[String] = None,
      tagValueScope: Option[String] = None
    ): OrganizationManagedRuleMetadata =
      OrganizationManagedRuleMetadata
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(ruleIdentifier)(_.ruleIdentifier(_))
        .ifSome(inputParameters)(_.inputParameters(_))
        .ifSome(maximumExecutionFrequency)(_.maximumExecutionFrequency(_))
        .ifSome(resourceTypesScope)(_.resourceTypesScope(_))
        .ifSome(resourceIdScope)(_.resourceIdScope(_))
        .ifSome(tagKeyScope)(_.tagKeyScope(_))
        .ifSome(tagValueScope)(_.tagValueScope(_))
        .build

    def organizationResourceDetailedStatusFilters(
      accountId: Option[String] = None,
      status: Option[String] = None
    ): OrganizationResourceDetailedStatusFilters =
      OrganizationResourceDetailedStatusFilters
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(status)(_.status(_))
        .build

    def oversizedConfigurationItemException(

    ): OversizedConfigurationItemException =
      OversizedConfigurationItemException
        .builder

        .build

    def pendingAggregationRequest(
      requesterAccountId: Option[String] = None,
      requesterAwsRegion: Option[String] = None
    ): PendingAggregationRequest =
      PendingAggregationRequest
        .builder
        .ifSome(requesterAccountId)(_.requesterAccountId(_))
        .ifSome(requesterAwsRegion)(_.requesterAwsRegion(_))
        .build

    def putAggregationAuthorizationRequest(
      authorizedAccountId: Option[String] = None,
      authorizedAwsRegion: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): PutAggregationAuthorizationRequest =
      PutAggregationAuthorizationRequest
        .builder
        .ifSome(authorizedAccountId)(_.authorizedAccountId(_))
        .ifSome(authorizedAwsRegion)(_.authorizedAwsRegion(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putAggregationAuthorizationResponse(
      aggregationAuthorization: Option[AggregationAuthorization] = None
    ): PutAggregationAuthorizationResponse =
      PutAggregationAuthorizationResponse
        .builder
        .ifSome(aggregationAuthorization)(_.aggregationAuthorization(_))
        .build

    def putConfigRuleRequest(
      configRule: Option[ConfigRule] = None,
      tags: Option[List[Tag]] = None
    ): PutConfigRuleRequest =
      PutConfigRuleRequest
        .builder
        .ifSome(configRule)(_.configRule(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putConfigurationAggregatorRequest(
      configurationAggregatorName: Option[String] = None,
      accountAggregationSources: Option[List[AccountAggregationSource]] = None,
      organizationAggregationSource: Option[OrganizationAggregationSource] = None,
      tags: Option[List[Tag]] = None
    ): PutConfigurationAggregatorRequest =
      PutConfigurationAggregatorRequest
        .builder
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(accountAggregationSources)(_.accountAggregationSources(_))
        .ifSome(organizationAggregationSource)(_.organizationAggregationSource(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putConfigurationAggregatorResponse(
      configurationAggregator: Option[ConfigurationAggregator] = None
    ): PutConfigurationAggregatorResponse =
      PutConfigurationAggregatorResponse
        .builder
        .ifSome(configurationAggregator)(_.configurationAggregator(_))
        .build

    def putConfigurationRecorderRequest(
      configurationRecorder: Option[ConfigurationRecorder] = None
    ): PutConfigurationRecorderRequest =
      PutConfigurationRecorderRequest
        .builder
        .ifSome(configurationRecorder)(_.configurationRecorder(_))
        .build

    def putConformancePackRequest(
      conformancePackName: Option[String] = None,
      templateS3Uri: Option[String] = None,
      templateBody: Option[String] = None,
      deliveryS3Bucket: Option[String] = None,
      deliveryS3KeyPrefix: Option[String] = None,
      conformancePackInputParameters: Option[List[ConformancePackInputParameter]] = None
    ): PutConformancePackRequest =
      PutConformancePackRequest
        .builder
        .ifSome(conformancePackName)(_.conformancePackName(_))
        .ifSome(templateS3Uri)(_.templateS3Uri(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(deliveryS3Bucket)(_.deliveryS3Bucket(_))
        .ifSome(deliveryS3KeyPrefix)(_.deliveryS3KeyPrefix(_))
        .ifSome(conformancePackInputParameters)(_.conformancePackInputParameters(_))
        .build

    def putConformancePackResponse(
      conformancePackArn: Option[String] = None
    ): PutConformancePackResponse =
      PutConformancePackResponse
        .builder
        .ifSome(conformancePackArn)(_.conformancePackArn(_))
        .build

    def putDeliveryChannelRequest(
      deliveryChannel: Option[DeliveryChannel] = None
    ): PutDeliveryChannelRequest =
      PutDeliveryChannelRequest
        .builder
        .ifSome(deliveryChannel)(_.deliveryChannel(_))
        .build

    def putEvaluationsRequest(
      evaluations: Option[List[Evaluation]] = None,
      resultToken: Option[String] = None,
      testMode: Option[Boolean] = None
    ): PutEvaluationsRequest =
      PutEvaluationsRequest
        .builder
        .ifSome(evaluations)(_.evaluations(_))
        .ifSome(resultToken)(_.resultToken(_))
        .ifSome(testMode)(_.testMode(_))
        .build

    def putEvaluationsResponse(
      failedEvaluations: Option[List[Evaluation]] = None
    ): PutEvaluationsResponse =
      PutEvaluationsResponse
        .builder
        .ifSome(failedEvaluations)(_.failedEvaluations(_))
        .build

    def putExternalEvaluationRequest(
      configRuleName: Option[String] = None,
      externalEvaluation: Option[ExternalEvaluation] = None
    ): PutExternalEvaluationRequest =
      PutExternalEvaluationRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(externalEvaluation)(_.externalEvaluation(_))
        .build

    def putExternalEvaluationResponse(

    ): PutExternalEvaluationResponse =
      PutExternalEvaluationResponse
        .builder

        .build

    def putOrganizationConfigRuleRequest(
      organizationConfigRuleName: Option[String] = None,
      organizationManagedRuleMetadata: Option[OrganizationManagedRuleMetadata] = None,
      organizationCustomRuleMetadata: Option[OrganizationCustomRuleMetadata] = None,
      excludedAccounts: Option[List[AccountId]] = None
    ): PutOrganizationConfigRuleRequest =
      PutOrganizationConfigRuleRequest
        .builder
        .ifSome(organizationConfigRuleName)(_.organizationConfigRuleName(_))
        .ifSome(organizationManagedRuleMetadata)(_.organizationManagedRuleMetadata(_))
        .ifSome(organizationCustomRuleMetadata)(_.organizationCustomRuleMetadata(_))
        .ifSome(excludedAccounts)(_.excludedAccounts(_))
        .build

    def putOrganizationConfigRuleResponse(
      organizationConfigRuleArn: Option[String] = None
    ): PutOrganizationConfigRuleResponse =
      PutOrganizationConfigRuleResponse
        .builder
        .ifSome(organizationConfigRuleArn)(_.organizationConfigRuleArn(_))
        .build

    def putOrganizationConformancePackRequest(
      organizationConformancePackName: Option[String] = None,
      templateS3Uri: Option[String] = None,
      templateBody: Option[String] = None,
      deliveryS3Bucket: Option[String] = None,
      deliveryS3KeyPrefix: Option[String] = None,
      conformancePackInputParameters: Option[List[ConformancePackInputParameter]] = None,
      excludedAccounts: Option[List[AccountId]] = None
    ): PutOrganizationConformancePackRequest =
      PutOrganizationConformancePackRequest
        .builder
        .ifSome(organizationConformancePackName)(_.organizationConformancePackName(_))
        .ifSome(templateS3Uri)(_.templateS3Uri(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(deliveryS3Bucket)(_.deliveryS3Bucket(_))
        .ifSome(deliveryS3KeyPrefix)(_.deliveryS3KeyPrefix(_))
        .ifSome(conformancePackInputParameters)(_.conformancePackInputParameters(_))
        .ifSome(excludedAccounts)(_.excludedAccounts(_))
        .build

    def putOrganizationConformancePackResponse(
      organizationConformancePackArn: Option[String] = None
    ): PutOrganizationConformancePackResponse =
      PutOrganizationConformancePackResponse
        .builder
        .ifSome(organizationConformancePackArn)(_.organizationConformancePackArn(_))
        .build

    def putRemediationConfigurationsRequest(
      remediationConfigurations: Option[List[RemediationConfiguration]] = None
    ): PutRemediationConfigurationsRequest =
      PutRemediationConfigurationsRequest
        .builder
        .ifSome(remediationConfigurations)(_.remediationConfigurations(_))
        .build

    def putRemediationConfigurationsResponse(
      failedBatches: Option[List[FailedRemediationBatch]] = None
    ): PutRemediationConfigurationsResponse =
      PutRemediationConfigurationsResponse
        .builder
        .ifSome(failedBatches)(_.failedBatches(_))
        .build

    def putRemediationExceptionsRequest(
      configRuleName: Option[String] = None,
      resourceKeys: Option[List[RemediationExceptionResourceKey]] = None,
      message: Option[String] = None,
      expirationTime: Option[Date] = None
    ): PutRemediationExceptionsRequest =
      PutRemediationExceptionsRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceKeys)(_.resourceKeys(_))
        .ifSome(message)(_.message(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .build

    def putRemediationExceptionsResponse(
      failedBatches: Option[List[FailedRemediationExceptionBatch]] = None
    ): PutRemediationExceptionsResponse =
      PutRemediationExceptionsResponse
        .builder
        .ifSome(failedBatches)(_.failedBatches(_))
        .build

    def putResourceConfigRequest(
      resourceType: Option[String] = None,
      schemaVersionId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceName: Option[String] = None,
      configuration: Option[String] = None,
      tags: Option[Tags] = None
    ): PutResourceConfigRequest =
      PutResourceConfigRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putRetentionConfigurationRequest(
      retentionPeriodInDays: Option[Int] = None
    ): PutRetentionConfigurationRequest =
      PutRetentionConfigurationRequest
        .builder
        .ifSome(retentionPeriodInDays)(_.retentionPeriodInDays(_))
        .build

    def putRetentionConfigurationResponse(
      retentionConfiguration: Option[RetentionConfiguration] = None
    ): PutRetentionConfigurationResponse =
      PutRetentionConfigurationResponse
        .builder
        .ifSome(retentionConfiguration)(_.retentionConfiguration(_))
        .build

    def putStoredQueryRequest(
      storedQuery: Option[StoredQuery] = None,
      tags: Option[List[Tag]] = None
    ): PutStoredQueryRequest =
      PutStoredQueryRequest
        .builder
        .ifSome(storedQuery)(_.storedQuery(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putStoredQueryResponse(
      queryArn: Option[String] = None
    ): PutStoredQueryResponse =
      PutStoredQueryResponse
        .builder
        .ifSome(queryArn)(_.queryArn(_))
        .build

    def queryInfo(
      selectFields: Option[List[FieldInfo]] = None
    ): QueryInfo =
      QueryInfo
        .builder
        .ifSome(selectFields)(_.selectFields(_))
        .build

    def recordingGroup(
      allSupported: Option[Boolean] = None,
      includeGlobalResourceTypes: Option[Boolean] = None,
      resourceTypes: Option[List[ResourceType]] = None
    ): RecordingGroup =
      RecordingGroup
        .builder
        .ifSome(allSupported)(_.allSupported(_))
        .ifSome(includeGlobalResourceTypes)(_.includeGlobalResourceTypes(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .build

    def relationship(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      resourceName: Option[String] = None,
      relationshipName: Option[String] = None
    ): Relationship =
      Relationship
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(relationshipName)(_.relationshipName(_))
        .build

    def remediationConfiguration(
      configRuleName: Option[String] = None,
      targetType: Option[String] = None,
      targetId: Option[String] = None,
      targetVersion: Option[String] = None,
      parameters: Option[RemediationParameters] = None,
      resourceType: Option[String] = None,
      automatic: Option[Boolean] = None,
      executionControls: Option[ExecutionControls] = None,
      maximumAutomaticAttempts: Option[Int] = None,
      retryAttemptSeconds: Option[AutoRemediationAttemptSeconds] = None,
      arn: Option[String] = None,
      createdByService: Option[String] = None
    ): RemediationConfiguration =
      RemediationConfiguration
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetVersion)(_.targetVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(automatic)(_.automatic(_))
        .ifSome(executionControls)(_.executionControls(_))
        .ifSome(maximumAutomaticAttempts)(_.maximumAutomaticAttempts(_))
        .ifSome(retryAttemptSeconds)(_.retryAttemptSeconds(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdByService)(_.createdByService(_))
        .build

    def remediationException(
      configRuleName: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      message: Option[String] = None,
      expirationTime: Option[Date] = None
    ): RemediationException =
      RemediationException
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(message)(_.message(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .build

    def remediationExceptionResourceKey(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): RemediationExceptionResourceKey =
      RemediationExceptionResourceKey
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def remediationExecutionStatus(
      resourceKey: Option[ResourceKey] = None,
      state: Option[String] = None,
      stepDetails: Option[List[RemediationExecutionStep]] = None,
      invocationTime: Option[Date] = None,
      lastUpdatedTime: Option[Date] = None
    ): RemediationExecutionStatus =
      RemediationExecutionStatus
        .builder
        .ifSome(resourceKey)(_.resourceKey(_))
        .ifSome(state)(_.state(_))
        .ifSome(stepDetails)(_.stepDetails(_))
        .ifSome(invocationTime)(_.invocationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def remediationExecutionStep(
      name: Option[String] = None,
      state: Option[String] = None,
      errorMessage: Option[String] = None,
      startTime: Option[Date] = None,
      stopTime: Option[Date] = None
    ): RemediationExecutionStep =
      RemediationExecutionStep
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(stopTime)(_.stopTime(_))
        .build

    def remediationInProgressException(

    ): RemediationInProgressException =
      RemediationInProgressException
        .builder

        .build

    def remediationParameterValue(
      resourceValue: Option[ResourceValue] = None,
      staticValue: Option[StaticValue] = None
    ): RemediationParameterValue =
      RemediationParameterValue
        .builder
        .ifSome(resourceValue)(_.resourceValue(_))
        .ifSome(staticValue)(_.staticValue(_))
        .build

    def resourceConcurrentModificationException(
      message: Option[String] = None
    ): ResourceConcurrentModificationException =
      ResourceConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceCount(
      resourceType: Option[String] = None,
      count: Option[Long] = None
    ): ResourceCount =
      ResourceCount
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(count)(_.count(_))
        .build

    def resourceCountFilters(
      resourceType: Option[String] = None,
      accountId: Option[String] = None,
      region: Option[String] = None
    ): ResourceCountFilters =
      ResourceCountFilters
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(region)(_.region(_))
        .build

    def resourceFilters(
      accountId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceName: Option[String] = None,
      region: Option[String] = None
    ): ResourceFilters =
      ResourceFilters
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(region)(_.region(_))
        .build

    def resourceIdentifier(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      resourceName: Option[String] = None,
      resourceDeletionTime: Option[ResourceDeletionTime] = None
    ): ResourceIdentifier =
      ResourceIdentifier
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(resourceDeletionTime)(_.resourceDeletionTime(_))
        .build

    def resourceInUseException(

    ): ResourceInUseException =
      ResourceInUseException
        .builder

        .build

    def resourceKey(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceKey =
      ResourceKey
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def resourceNotDiscoveredException(

    ): ResourceNotDiscoveredException =
      ResourceNotDiscoveredException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourceValue(
      value: Option[String] = None
    ): ResourceValue =
      ResourceValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def retentionConfiguration(
      name: Option[String] = None,
      retentionPeriodInDays: Option[Int] = None
    ): RetentionConfiguration =
      RetentionConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(retentionPeriodInDays)(_.retentionPeriodInDays(_))
        .build

    def scope(
      complianceResourceTypes: Option[List[StringWithCharLimit256]] = None,
      tagKey: Option[String] = None,
      tagValue: Option[String] = None,
      complianceResourceId: Option[String] = None
    ): Scope =
      Scope
        .builder
        .ifSome(complianceResourceTypes)(_.complianceResourceTypes(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValue)(_.tagValue(_))
        .ifSome(complianceResourceId)(_.complianceResourceId(_))
        .build

    def selectAggregateResourceConfigRequest(
      expression: Option[String] = None,
      configurationAggregatorName: Option[String] = None,
      limit: Option[Int] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SelectAggregateResourceConfigRequest =
      SelectAggregateResourceConfigRequest
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(configurationAggregatorName)(_.configurationAggregatorName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def selectAggregateResourceConfigResponse(
      results: Option[List[String]] = None,
      queryInfo: Option[QueryInfo] = None,
      nextToken: Option[String] = None
    ): SelectAggregateResourceConfigResponse =
      SelectAggregateResourceConfigResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(queryInfo)(_.queryInfo(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def selectResourceConfigRequest(
      expression: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): SelectResourceConfigRequest =
      SelectResourceConfigRequest
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def selectResourceConfigResponse(
      results: Option[List[String]] = None,
      queryInfo: Option[QueryInfo] = None,
      nextToken: Option[String] = None
    ): SelectResourceConfigResponse =
      SelectResourceConfigResponse
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(queryInfo)(_.queryInfo(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def source(
      owner: Option[String] = None,
      sourceIdentifier: Option[String] = None,
      sourceDetails: Option[List[SourceDetail]] = None
    ): Source =
      Source
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceDetails)(_.sourceDetails(_))
        .build

    def sourceDetail(
      eventSource: Option[String] = None,
      messageType: Option[String] = None,
      maximumExecutionFrequency: Option[String] = None
    ): SourceDetail =
      SourceDetail
        .builder
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(messageType)(_.messageType(_))
        .ifSome(maximumExecutionFrequency)(_.maximumExecutionFrequency(_))
        .build

    def ssmControls(
      concurrentExecutionRatePercentage: Option[Int] = None,
      errorPercentage: Option[Int] = None
    ): SsmControls =
      SsmControls
        .builder
        .ifSome(concurrentExecutionRatePercentage)(_.concurrentExecutionRatePercentage(_))
        .ifSome(errorPercentage)(_.errorPercentage(_))
        .build

    def startConfigRulesEvaluationRequest(
      configRuleNames: Option[List[ConfigRuleName]] = None
    ): StartConfigRulesEvaluationRequest =
      StartConfigRulesEvaluationRequest
        .builder
        .ifSome(configRuleNames)(_.configRuleNames(_))
        .build

    def startConfigRulesEvaluationResponse(

    ): StartConfigRulesEvaluationResponse =
      StartConfigRulesEvaluationResponse
        .builder

        .build

    def startConfigurationRecorderRequest(
      configurationRecorderName: Option[String] = None
    ): StartConfigurationRecorderRequest =
      StartConfigurationRecorderRequest
        .builder
        .ifSome(configurationRecorderName)(_.configurationRecorderName(_))
        .build

    def startRemediationExecutionRequest(
      configRuleName: Option[String] = None,
      resourceKeys: Option[List[ResourceKey]] = None
    ): StartRemediationExecutionRequest =
      StartRemediationExecutionRequest
        .builder
        .ifSome(configRuleName)(_.configRuleName(_))
        .ifSome(resourceKeys)(_.resourceKeys(_))
        .build

    def startRemediationExecutionResponse(
      failureMessage: Option[String] = None,
      failedItems: Option[List[ResourceKey]] = None
    ): StartRemediationExecutionResponse =
      StartRemediationExecutionResponse
        .builder
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def staticValue(
      values: Option[List[StringWithCharLimit256]] = None
    ): StaticValue =
      StaticValue
        .builder
        .ifSome(values)(_.values(_))
        .build

    def statusDetailFilters(
      accountId: Option[String] = None,
      memberAccountRuleStatus: Option[String] = None
    ): StatusDetailFilters =
      StatusDetailFilters
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(memberAccountRuleStatus)(_.memberAccountRuleStatus(_))
        .build

    def stopConfigurationRecorderRequest(
      configurationRecorderName: Option[String] = None
    ): StopConfigurationRecorderRequest =
      StopConfigurationRecorderRequest
        .builder
        .ifSome(configurationRecorderName)(_.configurationRecorderName(_))
        .build

    def storedQuery(
      queryId: Option[String] = None,
      queryArn: Option[String] = None,
      queryName: Option[String] = None,
      description: Option[String] = None,
      expression: Option[String] = None
    ): StoredQuery =
      StoredQuery
        .builder
        .ifSome(queryId)(_.queryId(_))
        .ifSome(queryArn)(_.queryArn(_))
        .ifSome(queryName)(_.queryName(_))
        .ifSome(description)(_.description(_))
        .ifSome(expression)(_.expression(_))
        .build

    def storedQueryMetadata(
      queryId: Option[String] = None,
      queryArn: Option[String] = None,
      queryName: Option[String] = None,
      description: Option[String] = None
    ): StoredQueryMetadata =
      StoredQueryMetadata
        .builder
        .ifSome(queryId)(_.queryId(_))
        .ifSome(queryArn)(_.queryArn(_))
        .ifSome(queryName)(_.queryName(_))
        .ifSome(description)(_.description(_))
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

    def tooManyTagsException(

    ): TooManyTagsException =
      TooManyTagsException
        .builder

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

    def validationException(

    ): ValidationException =
      ValidationException
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
