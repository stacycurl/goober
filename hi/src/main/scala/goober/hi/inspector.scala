package goober.hi

import goober.free.inspector.InspectorIO
import software.amazon.awssdk.services.inspector.model._


object inspector {
  import goober.free.{inspector ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None,
      errorCode: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def addAttributesToFindingsRequest(
      findingArns: Option[List[Arn]] = None,
      attributes: Option[List[Attribute]] = None
    ): AddAttributesToFindingsRequest =
      AddAttributesToFindingsRequest
        .builder
        .ifSome(findingArns)(_.findingArns(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def addAttributesToFindingsResponse(
      failedItems: Option[FailedItems] = None
    ): AddAttributesToFindingsResponse =
      AddAttributesToFindingsResponse
        .builder
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def agentAlreadyRunningAssessment(
      agentId: Option[String] = None,
      assessmentRunArn: Option[String] = None
    ): AgentAlreadyRunningAssessment =
      AgentAlreadyRunningAssessment
        .builder
        .ifSome(agentId)(_.agentId(_))
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .build

    def agentFilter(
      agentHealths: Option[List[AgentHealth]] = None,
      agentHealthCodes: Option[List[AgentHealthCode]] = None
    ): AgentFilter =
      AgentFilter
        .builder
        .ifSome(agentHealths)(_.agentHealths(_))
        .ifSome(agentHealthCodes)(_.agentHealthCodes(_))
        .build

    def agentPreview(
      hostname: Option[String] = None,
      agentId: Option[String] = None,
      autoScalingGroup: Option[String] = None,
      agentHealth: Option[String] = None,
      agentVersion: Option[String] = None,
      operatingSystem: Option[String] = None,
      kernelVersion: Option[String] = None,
      ipv4Address: Option[String] = None
    ): AgentPreview =
      AgentPreview
        .builder
        .ifSome(hostname)(_.hostname(_))
        .ifSome(agentId)(_.agentId(_))
        .ifSome(autoScalingGroup)(_.autoScalingGroup(_))
        .ifSome(agentHealth)(_.agentHealth(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(kernelVersion)(_.kernelVersion(_))
        .ifSome(ipv4Address)(_.ipv4Address(_))
        .build

    def agentsAlreadyRunningAssessmentException(
      message: Option[String] = None,
      agents: Option[List[AgentAlreadyRunningAssessment]] = None,
      agentsTruncated: Option[Boolean] = None,
      canRetry: Option[Boolean] = None
    ): AgentsAlreadyRunningAssessmentException =
      AgentsAlreadyRunningAssessmentException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(agents)(_.agents(_))
        .ifSome(agentsTruncated)(_.agentsTruncated(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def assessmentRun(
      arn: Option[String] = None,
      name: Option[String] = None,
      assessmentTemplateArn: Option[String] = None,
      state: Option[String] = None,
      durationInSeconds: Option[Int] = None,
      rulesPackageArns: Option[List[Arn]] = None,
      userAttributesForFindings: Option[List[Attribute]] = None,
      createdAt: Option[Timestamp] = None,
      startedAt: Option[Timestamp] = None,
      completedAt: Option[Timestamp] = None,
      stateChangedAt: Option[Timestamp] = None,
      dataCollected: Option[Boolean] = None,
      stateChanges: Option[List[AssessmentRunStateChange]] = None,
      notifications: Option[List[AssessmentRunNotification]] = None,
      findingCounts: Option[AssessmentRunFindingCounts] = None
    ): AssessmentRun =
      AssessmentRun
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(assessmentTemplateArn)(_.assessmentTemplateArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .ifSome(userAttributesForFindings)(_.userAttributesForFindings(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .ifSome(stateChangedAt)(_.stateChangedAt(_))
        .ifSome(dataCollected)(_.dataCollected(_))
        .ifSome(stateChanges)(_.stateChanges(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(findingCounts)(_.findingCounts(_))
        .build

    def assessmentRunAgent(
      agentId: Option[String] = None,
      assessmentRunArn: Option[String] = None,
      agentHealth: Option[String] = None,
      agentHealthCode: Option[String] = None,
      agentHealthDetails: Option[String] = None,
      autoScalingGroup: Option[String] = None,
      telemetryMetadata: Option[List[TelemetryMetadata]] = None
    ): AssessmentRunAgent =
      AssessmentRunAgent
        .builder
        .ifSome(agentId)(_.agentId(_))
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .ifSome(agentHealth)(_.agentHealth(_))
        .ifSome(agentHealthCode)(_.agentHealthCode(_))
        .ifSome(agentHealthDetails)(_.agentHealthDetails(_))
        .ifSome(autoScalingGroup)(_.autoScalingGroup(_))
        .ifSome(telemetryMetadata)(_.telemetryMetadata(_))
        .build

    def assessmentRunFilter(
      namePattern: Option[String] = None,
      states: Option[List[AssessmentRunState]] = None,
      durationRange: Option[DurationRange] = None,
      rulesPackageArns: Option[List[Arn]] = None,
      startTimeRange: Option[TimestampRange] = None,
      completionTimeRange: Option[TimestampRange] = None,
      stateChangeTimeRange: Option[TimestampRange] = None
    ): AssessmentRunFilter =
      AssessmentRunFilter
        .builder
        .ifSome(namePattern)(_.namePattern(_))
        .ifSome(states)(_.states(_))
        .ifSome(durationRange)(_.durationRange(_))
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .ifSome(startTimeRange)(_.startTimeRange(_))
        .ifSome(completionTimeRange)(_.completionTimeRange(_))
        .ifSome(stateChangeTimeRange)(_.stateChangeTimeRange(_))
        .build

    def assessmentRunInProgressException(
      message: Option[String] = None,
      assessmentRunArns: Option[List[Arn]] = None,
      assessmentRunArnsTruncated: Option[Boolean] = None,
      canRetry: Option[Boolean] = None
    ): AssessmentRunInProgressException =
      AssessmentRunInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(assessmentRunArns)(_.assessmentRunArns(_))
        .ifSome(assessmentRunArnsTruncated)(_.assessmentRunArnsTruncated(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def assessmentRunNotification(
      date: Option[Timestamp] = None,
      event: Option[String] = None,
      message: Option[String] = None,
      error: Option[Boolean] = None,
      snsTopicArn: Option[String] = None,
      snsPublishStatusCode: Option[String] = None
    ): AssessmentRunNotification =
      AssessmentRunNotification
        .builder
        .ifSome(date)(_.date(_))
        .ifSome(event)(_.event(_))
        .ifSome(message)(_.message(_))
        .ifSome(error)(_.error(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(snsPublishStatusCode)(_.snsPublishStatusCode(_))
        .build

    def assessmentRunStateChange(
      stateChangedAt: Option[Timestamp] = None,
      state: Option[String] = None
    ): AssessmentRunStateChange =
      AssessmentRunStateChange
        .builder
        .ifSome(stateChangedAt)(_.stateChangedAt(_))
        .ifSome(state)(_.state(_))
        .build

    def assessmentTarget(
      arn: Option[String] = None,
      name: Option[String] = None,
      resourceGroupArn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None
    ): AssessmentTarget =
      AssessmentTarget
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceGroupArn)(_.resourceGroupArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def assessmentTargetFilter(
      assessmentTargetNamePattern: Option[String] = None
    ): AssessmentTargetFilter =
      AssessmentTargetFilter
        .builder
        .ifSome(assessmentTargetNamePattern)(_.assessmentTargetNamePattern(_))
        .build

    def assessmentTemplate(
      arn: Option[String] = None,
      name: Option[String] = None,
      assessmentTargetArn: Option[String] = None,
      durationInSeconds: Option[Int] = None,
      rulesPackageArns: Option[List[Arn]] = None,
      userAttributesForFindings: Option[List[Attribute]] = None,
      lastAssessmentRunArn: Option[String] = None,
      assessmentRunCount: Option[Int] = None,
      createdAt: Option[Timestamp] = None
    ): AssessmentTemplate =
      AssessmentTemplate
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(assessmentTargetArn)(_.assessmentTargetArn(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .ifSome(userAttributesForFindings)(_.userAttributesForFindings(_))
        .ifSome(lastAssessmentRunArn)(_.lastAssessmentRunArn(_))
        .ifSome(assessmentRunCount)(_.assessmentRunCount(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def assessmentTemplateFilter(
      namePattern: Option[String] = None,
      durationRange: Option[DurationRange] = None,
      rulesPackageArns: Option[List[Arn]] = None
    ): AssessmentTemplateFilter =
      AssessmentTemplateFilter
        .builder
        .ifSome(namePattern)(_.namePattern(_))
        .ifSome(durationRange)(_.durationRange(_))
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .build

    def assetAttributes(
      schemaVersion: Option[Int] = None,
      agentId: Option[String] = None,
      autoScalingGroup: Option[String] = None,
      amiId: Option[String] = None,
      hostname: Option[String] = None,
      ipv4Addresses: Option[List[Ipv4Address]] = None,
      tags: Option[List[Tag]] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None
    ): AssetAttributes =
      AssetAttributes
        .builder
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(agentId)(_.agentId(_))
        .ifSome(autoScalingGroup)(_.autoScalingGroup(_))
        .ifSome(amiId)(_.amiId(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(ipv4Addresses)(_.ipv4Addresses(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .build

    def attribute(
      key: Option[String] = None,
      value: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def createAssessmentTargetRequest(
      assessmentTargetName: Option[String] = None,
      resourceGroupArn: Option[String] = None
    ): CreateAssessmentTargetRequest =
      CreateAssessmentTargetRequest
        .builder
        .ifSome(assessmentTargetName)(_.assessmentTargetName(_))
        .ifSome(resourceGroupArn)(_.resourceGroupArn(_))
        .build

    def createAssessmentTargetResponse(
      assessmentTargetArn: Option[String] = None
    ): CreateAssessmentTargetResponse =
      CreateAssessmentTargetResponse
        .builder
        .ifSome(assessmentTargetArn)(_.assessmentTargetArn(_))
        .build

    def createAssessmentTemplateRequest(
      assessmentTargetArn: Option[String] = None,
      assessmentTemplateName: Option[String] = None,
      durationInSeconds: Option[Int] = None,
      rulesPackageArns: Option[List[Arn]] = None,
      userAttributesForFindings: Option[List[Attribute]] = None
    ): CreateAssessmentTemplateRequest =
      CreateAssessmentTemplateRequest
        .builder
        .ifSome(assessmentTargetArn)(_.assessmentTargetArn(_))
        .ifSome(assessmentTemplateName)(_.assessmentTemplateName(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .ifSome(userAttributesForFindings)(_.userAttributesForFindings(_))
        .build

    def createAssessmentTemplateResponse(
      assessmentTemplateArn: Option[String] = None
    ): CreateAssessmentTemplateResponse =
      CreateAssessmentTemplateResponse
        .builder
        .ifSome(assessmentTemplateArn)(_.assessmentTemplateArn(_))
        .build

    def createExclusionsPreviewRequest(
      assessmentTemplateArn: Option[String] = None
    ): CreateExclusionsPreviewRequest =
      CreateExclusionsPreviewRequest
        .builder
        .ifSome(assessmentTemplateArn)(_.assessmentTemplateArn(_))
        .build

    def createExclusionsPreviewResponse(
      previewToken: Option[String] = None
    ): CreateExclusionsPreviewResponse =
      CreateExclusionsPreviewResponse
        .builder
        .ifSome(previewToken)(_.previewToken(_))
        .build

    def createResourceGroupRequest(
      resourceGroupTags: Option[List[ResourceGroupTag]] = None
    ): CreateResourceGroupRequest =
      CreateResourceGroupRequest
        .builder
        .ifSome(resourceGroupTags)(_.resourceGroupTags(_))
        .build

    def createResourceGroupResponse(
      resourceGroupArn: Option[String] = None
    ): CreateResourceGroupResponse =
      CreateResourceGroupResponse
        .builder
        .ifSome(resourceGroupArn)(_.resourceGroupArn(_))
        .build

    def deleteAssessmentRunRequest(
      assessmentRunArn: Option[String] = None
    ): DeleteAssessmentRunRequest =
      DeleteAssessmentRunRequest
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .build

    def deleteAssessmentTargetRequest(
      assessmentTargetArn: Option[String] = None
    ): DeleteAssessmentTargetRequest =
      DeleteAssessmentTargetRequest
        .builder
        .ifSome(assessmentTargetArn)(_.assessmentTargetArn(_))
        .build

    def deleteAssessmentTemplateRequest(
      assessmentTemplateArn: Option[String] = None
    ): DeleteAssessmentTemplateRequest =
      DeleteAssessmentTemplateRequest
        .builder
        .ifSome(assessmentTemplateArn)(_.assessmentTemplateArn(_))
        .build

    def describeAssessmentRunsRequest(
      assessmentRunArns: Option[List[Arn]] = None
    ): DescribeAssessmentRunsRequest =
      DescribeAssessmentRunsRequest
        .builder
        .ifSome(assessmentRunArns)(_.assessmentRunArns(_))
        .build

    def describeAssessmentRunsResponse(
      assessmentRuns: Option[List[AssessmentRun]] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeAssessmentRunsResponse =
      DescribeAssessmentRunsResponse
        .builder
        .ifSome(assessmentRuns)(_.assessmentRuns(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def describeAssessmentTargetsRequest(
      assessmentTargetArns: Option[List[Arn]] = None
    ): DescribeAssessmentTargetsRequest =
      DescribeAssessmentTargetsRequest
        .builder
        .ifSome(assessmentTargetArns)(_.assessmentTargetArns(_))
        .build

    def describeAssessmentTargetsResponse(
      assessmentTargets: Option[List[AssessmentTarget]] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeAssessmentTargetsResponse =
      DescribeAssessmentTargetsResponse
        .builder
        .ifSome(assessmentTargets)(_.assessmentTargets(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def describeAssessmentTemplatesRequest(
      assessmentTemplateArns: Option[List[Arn]] = None
    ): DescribeAssessmentTemplatesRequest =
      DescribeAssessmentTemplatesRequest
        .builder
        .ifSome(assessmentTemplateArns)(_.assessmentTemplateArns(_))
        .build

    def describeAssessmentTemplatesResponse(
      assessmentTemplates: Option[List[AssessmentTemplate]] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeAssessmentTemplatesResponse =
      DescribeAssessmentTemplatesResponse
        .builder
        .ifSome(assessmentTemplates)(_.assessmentTemplates(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def describeCrossAccountAccessRoleResponse(
      roleArn: Option[String] = None,
      valid: Option[Boolean] = None,
      registeredAt: Option[Timestamp] = None
    ): DescribeCrossAccountAccessRoleResponse =
      DescribeCrossAccountAccessRoleResponse
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(valid)(_.valid(_))
        .ifSome(registeredAt)(_.registeredAt(_))
        .build

    def describeExclusionsRequest(
      exclusionArns: Option[List[Arn]] = None,
      locale: Option[String] = None
    ): DescribeExclusionsRequest =
      DescribeExclusionsRequest
        .builder
        .ifSome(exclusionArns)(_.exclusionArns(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeExclusionsResponse(
      exclusions: Option[ExclusionMap] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeExclusionsResponse =
      DescribeExclusionsResponse
        .builder
        .ifSome(exclusions)(_.exclusions(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def describeFindingsRequest(
      findingArns: Option[List[Arn]] = None,
      locale: Option[String] = None
    ): DescribeFindingsRequest =
      DescribeFindingsRequest
        .builder
        .ifSome(findingArns)(_.findingArns(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeFindingsResponse(
      findings: Option[List[Finding]] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeFindingsResponse =
      DescribeFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def describeResourceGroupsRequest(
      resourceGroupArns: Option[List[Arn]] = None
    ): DescribeResourceGroupsRequest =
      DescribeResourceGroupsRequest
        .builder
        .ifSome(resourceGroupArns)(_.resourceGroupArns(_))
        .build

    def describeResourceGroupsResponse(
      resourceGroups: Option[List[ResourceGroup]] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeResourceGroupsResponse =
      DescribeResourceGroupsResponse
        .builder
        .ifSome(resourceGroups)(_.resourceGroups(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def describeRulesPackagesRequest(
      rulesPackageArns: Option[List[Arn]] = None,
      locale: Option[String] = None
    ): DescribeRulesPackagesRequest =
      DescribeRulesPackagesRequest
        .builder
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeRulesPackagesResponse(
      rulesPackages: Option[List[RulesPackage]] = None,
      failedItems: Option[FailedItems] = None
    ): DescribeRulesPackagesResponse =
      DescribeRulesPackagesResponse
        .builder
        .ifSome(rulesPackages)(_.rulesPackages(_))
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def durationRange(
      minSeconds: Option[Int] = None,
      maxSeconds: Option[Int] = None
    ): DurationRange =
      DurationRange
        .builder
        .ifSome(minSeconds)(_.minSeconds(_))
        .ifSome(maxSeconds)(_.maxSeconds(_))
        .build

    def eventSubscription(
      event: Option[String] = None,
      subscribedAt: Option[Timestamp] = None
    ): EventSubscription =
      EventSubscription
        .builder
        .ifSome(event)(_.event(_))
        .ifSome(subscribedAt)(_.subscribedAt(_))
        .build

    def exclusion(
      arn: Option[String] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      recommendation: Option[String] = None,
      scopes: Option[List[Scope]] = None,
      attributes: Option[List[Attribute]] = None
    ): Exclusion =
      Exclusion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(recommendation)(_.recommendation(_))
        .ifSome(scopes)(_.scopes(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def exclusionPreview(
      title: Option[String] = None,
      description: Option[String] = None,
      recommendation: Option[String] = None,
      scopes: Option[List[Scope]] = None,
      attributes: Option[List[Attribute]] = None
    ): ExclusionPreview =
      ExclusionPreview
        .builder
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(recommendation)(_.recommendation(_))
        .ifSome(scopes)(_.scopes(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def failedItemDetails(
      failureCode: Option[String] = None,
      retryable: Option[Boolean] = None
    ): FailedItemDetails =
      FailedItemDetails
        .builder
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(retryable)(_.retryable(_))
        .build

    def finding(
      arn: Option[String] = None,
      schemaVersion: Option[Int] = None,
      service: Option[String] = None,
      serviceAttributes: Option[InspectorServiceAttributes] = None,
      assetType: Option[String] = None,
      assetAttributes: Option[AssetAttributes] = None,
      id: Option[String] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      recommendation: Option[String] = None,
      severity: Option[String] = None,
      numericSeverity: Option[NumericSeverity] = None,
      confidence: Option[Int] = None,
      indicatorOfCompromise: Option[Boolean] = None,
      attributes: Option[List[Attribute]] = None,
      userAttributes: Option[List[Attribute]] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None
    ): Finding =
      Finding
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(service)(_.service(_))
        .ifSome(serviceAttributes)(_.serviceAttributes(_))
        .ifSome(assetType)(_.assetType(_))
        .ifSome(assetAttributes)(_.assetAttributes(_))
        .ifSome(id)(_.id(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(recommendation)(_.recommendation(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(numericSeverity)(_.numericSeverity(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(indicatorOfCompromise)(_.indicatorOfCompromise(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def findingFilter(
      agentIds: Option[List[AgentId]] = None,
      autoScalingGroups: Option[List[AutoScalingGroup]] = None,
      ruleNames: Option[List[RuleName]] = None,
      severities: Option[List[Severity]] = None,
      rulesPackageArns: Option[List[Arn]] = None,
      attributes: Option[List[Attribute]] = None,
      userAttributes: Option[List[Attribute]] = None,
      creationTimeRange: Option[TimestampRange] = None
    ): FindingFilter =
      FindingFilter
        .builder
        .ifSome(agentIds)(_.agentIds(_))
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(ruleNames)(_.ruleNames(_))
        .ifSome(severities)(_.severities(_))
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(userAttributes)(_.userAttributes(_))
        .ifSome(creationTimeRange)(_.creationTimeRange(_))
        .build

    def getAssessmentReportRequest(
      assessmentRunArn: Option[String] = None,
      reportFileFormat: Option[String] = None,
      reportType: Option[String] = None
    ): GetAssessmentReportRequest =
      GetAssessmentReportRequest
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .ifSome(reportFileFormat)(_.reportFileFormat(_))
        .ifSome(reportType)(_.reportType(_))
        .build

    def getAssessmentReportResponse(
      status: Option[String] = None,
      url: Option[String] = None
    ): GetAssessmentReportResponse =
      GetAssessmentReportResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(url)(_.url(_))
        .build

    def getExclusionsPreviewRequest(
      assessmentTemplateArn: Option[String] = None,
      previewToken: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      locale: Option[String] = None
    ): GetExclusionsPreviewRequest =
      GetExclusionsPreviewRequest
        .builder
        .ifSome(assessmentTemplateArn)(_.assessmentTemplateArn(_))
        .ifSome(previewToken)(_.previewToken(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(locale)(_.locale(_))
        .build

    def getExclusionsPreviewResponse(
      previewStatus: Option[String] = None,
      exclusionPreviews: Option[List[ExclusionPreview]] = None,
      nextToken: Option[String] = None
    ): GetExclusionsPreviewResponse =
      GetExclusionsPreviewResponse
        .builder
        .ifSome(previewStatus)(_.previewStatus(_))
        .ifSome(exclusionPreviews)(_.exclusionPreviews(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTelemetryMetadataRequest(
      assessmentRunArn: Option[String] = None
    ): GetTelemetryMetadataRequest =
      GetTelemetryMetadataRequest
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .build

    def getTelemetryMetadataResponse(
      telemetryMetadata: Option[List[TelemetryMetadata]] = None
    ): GetTelemetryMetadataResponse =
      GetTelemetryMetadataResponse
        .builder
        .ifSome(telemetryMetadata)(_.telemetryMetadata(_))
        .build

    def inspectorServiceAttributes(
      schemaVersion: Option[Int] = None,
      assessmentRunArn: Option[String] = None,
      rulesPackageArn: Option[String] = None
    ): InspectorServiceAttributes =
      InspectorServiceAttributes
        .builder
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .ifSome(rulesPackageArn)(_.rulesPackageArn(_))
        .build

    def internalException(
      message: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): InternalException =
      InternalException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def invalidCrossAccountRoleException(
      message: Option[String] = None,
      errorCode: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): InvalidCrossAccountRoleException =
      InvalidCrossAccountRoleException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def invalidInputException(
      message: Option[String] = None,
      errorCode: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      errorCode: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def listAssessmentRunAgentsRequest(
      assessmentRunArn: Option[String] = None,
      filter: Option[AgentFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentRunAgentsRequest =
      ListAssessmentRunAgentsRequest
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentRunAgentsResponse(
      assessmentRunAgents: Option[List[AssessmentRunAgent]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentRunAgentsResponse =
      ListAssessmentRunAgentsResponse
        .builder
        .ifSome(assessmentRunAgents)(_.assessmentRunAgents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssessmentRunsRequest(
      assessmentTemplateArns: Option[List[Arn]] = None,
      filter: Option[AssessmentRunFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentRunsRequest =
      ListAssessmentRunsRequest
        .builder
        .ifSome(assessmentTemplateArns)(_.assessmentTemplateArns(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentRunsResponse(
      assessmentRunArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentRunsResponse =
      ListAssessmentRunsResponse
        .builder
        .ifSome(assessmentRunArns)(_.assessmentRunArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssessmentTargetsRequest(
      filter: Option[AssessmentTargetFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentTargetsRequest =
      ListAssessmentTargetsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentTargetsResponse(
      assessmentTargetArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentTargetsResponse =
      ListAssessmentTargetsResponse
        .builder
        .ifSome(assessmentTargetArns)(_.assessmentTargetArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssessmentTemplatesRequest(
      assessmentTargetArns: Option[List[Arn]] = None,
      filter: Option[AssessmentTemplateFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentTemplatesRequest =
      ListAssessmentTemplatesRequest
        .builder
        .ifSome(assessmentTargetArns)(_.assessmentTargetArns(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentTemplatesResponse(
      assessmentTemplateArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentTemplatesResponse =
      ListAssessmentTemplatesResponse
        .builder
        .ifSome(assessmentTemplateArns)(_.assessmentTemplateArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventSubscriptionsRequest(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEventSubscriptionsRequest =
      ListEventSubscriptionsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEventSubscriptionsResponse(
      subscriptions: Option[List[Subscription]] = None,
      nextToken: Option[String] = None
    ): ListEventSubscriptionsResponse =
      ListEventSubscriptionsResponse
        .builder
        .ifSome(subscriptions)(_.subscriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExclusionsRequest(
      assessmentRunArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListExclusionsRequest =
      ListExclusionsRequest
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listExclusionsResponse(
      exclusionArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListExclusionsResponse =
      ListExclusionsResponse
        .builder
        .ifSome(exclusionArns)(_.exclusionArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFindingsRequest(
      assessmentRunArns: Option[List[Arn]] = None,
      filter: Option[FindingFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFindingsRequest =
      ListFindingsRequest
        .builder
        .ifSome(assessmentRunArns)(_.assessmentRunArns(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFindingsResponse(
      findingArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListFindingsResponse =
      ListFindingsResponse
        .builder
        .ifSome(findingArns)(_.findingArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRulesPackagesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRulesPackagesRequest =
      ListRulesPackagesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRulesPackagesResponse(
      rulesPackageArns: Option[List[Arn]] = None,
      nextToken: Option[String] = None
    ): ListRulesPackagesResponse =
      ListRulesPackagesResponse
        .builder
        .ifSome(rulesPackageArns)(_.rulesPackageArns(_))
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

    def networkInterface(
      networkInterfaceId: Option[String] = None,
      subnetId: Option[String] = None,
      vpcId: Option[String] = None,
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None,
      privateIpAddresses: Option[List[PrivateIp]] = None,
      publicDnsName: Option[String] = None,
      publicIp: Option[String] = None,
      ipv6Addresses: Option[List[Text]] = None,
      securityGroups: Option[List[SecurityGroup]] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(privateIpAddresses)(_.privateIpAddresses(_))
        .ifSome(publicDnsName)(_.publicDnsName(_))
        .ifSome(publicIp)(_.publicIp(_))
        .ifSome(ipv6Addresses)(_.ipv6Addresses(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def noSuchEntityException(
      message: Option[String] = None,
      errorCode: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): NoSuchEntityException =
      NoSuchEntityException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def previewAgentsRequest(
      previewAgentsArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): PreviewAgentsRequest =
      PreviewAgentsRequest
        .builder
        .ifSome(previewAgentsArn)(_.previewAgentsArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def previewAgentsResponse(
      agentPreviews: Option[List[AgentPreview]] = None,
      nextToken: Option[String] = None
    ): PreviewAgentsResponse =
      PreviewAgentsResponse
        .builder
        .ifSome(agentPreviews)(_.agentPreviews(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def previewGenerationInProgressException(
      message: Option[String] = None
    ): PreviewGenerationInProgressException =
      PreviewGenerationInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def privateIp(
      privateDnsName: Option[String] = None,
      privateIpAddress: Option[String] = None
    ): PrivateIp =
      PrivateIp
        .builder
        .ifSome(privateDnsName)(_.privateDnsName(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .build

    def registerCrossAccountAccessRoleRequest(
      roleArn: Option[String] = None
    ): RegisterCrossAccountAccessRoleRequest =
      RegisterCrossAccountAccessRoleRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def removeAttributesFromFindingsRequest(
      findingArns: Option[List[Arn]] = None,
      attributeKeys: Option[List[AttributeKey]] = None
    ): RemoveAttributesFromFindingsRequest =
      RemoveAttributesFromFindingsRequest
        .builder
        .ifSome(findingArns)(_.findingArns(_))
        .ifSome(attributeKeys)(_.attributeKeys(_))
        .build

    def removeAttributesFromFindingsResponse(
      failedItems: Option[FailedItems] = None
    ): RemoveAttributesFromFindingsResponse =
      RemoveAttributesFromFindingsResponse
        .builder
        .ifSome(failedItems)(_.failedItems(_))
        .build

    def resourceGroup(
      arn: Option[String] = None,
      tags: Option[List[ResourceGroupTag]] = None,
      createdAt: Option[Timestamp] = None
    ): ResourceGroup =
      ResourceGroup
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def resourceGroupTag(
      key: Option[String] = None,
      value: Option[String] = None
    ): ResourceGroupTag =
      ResourceGroupTag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def rulesPackage(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      provider: Option[String] = None,
      description: Option[String] = None
    ): RulesPackage =
      RulesPackage
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(provider)(_.provider(_))
        .ifSome(description)(_.description(_))
        .build

    def scope(
      key: Option[String] = None,
      value: Option[String] = None
    ): Scope =
      Scope
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def securityGroup(
      groupName: Option[String] = None,
      groupId: Option[String] = None
    ): SecurityGroup =
      SecurityGroup
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def serviceTemporarilyUnavailableException(
      message: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): ServiceTemporarilyUnavailableException =
      ServiceTemporarilyUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def setTagsForResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): SetTagsForResourceRequest =
      SetTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startAssessmentRunRequest(
      assessmentTemplateArn: Option[String] = None,
      assessmentRunName: Option[String] = None
    ): StartAssessmentRunRequest =
      StartAssessmentRunRequest
        .builder
        .ifSome(assessmentTemplateArn)(_.assessmentTemplateArn(_))
        .ifSome(assessmentRunName)(_.assessmentRunName(_))
        .build

    def startAssessmentRunResponse(
      assessmentRunArn: Option[String] = None
    ): StartAssessmentRunResponse =
      StartAssessmentRunResponse
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .build

    def stopAssessmentRunRequest(
      assessmentRunArn: Option[String] = None,
      stopAction: Option[String] = None
    ): StopAssessmentRunRequest =
      StopAssessmentRunRequest
        .builder
        .ifSome(assessmentRunArn)(_.assessmentRunArn(_))
        .ifSome(stopAction)(_.stopAction(_))
        .build

    def subscribeToEventRequest(
      resourceArn: Option[String] = None,
      event: Option[String] = None,
      topicArn: Option[String] = None
    ): SubscribeToEventRequest =
      SubscribeToEventRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(event)(_.event(_))
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def subscription(
      resourceArn: Option[String] = None,
      topicArn: Option[String] = None,
      eventSubscriptions: Option[List[EventSubscription]] = None
    ): Subscription =
      Subscription
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(eventSubscriptions)(_.eventSubscriptions(_))
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

    def telemetryMetadata(
      messageType: Option[String] = None,
      count: Option[Long] = None,
      dataSize: Option[Long] = None
    ): TelemetryMetadata =
      TelemetryMetadata
        .builder
        .ifSome(messageType)(_.messageType(_))
        .ifSome(count)(_.count(_))
        .ifSome(dataSize)(_.dataSize(_))
        .build

    def timestampRange(
      beginDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None
    ): TimestampRange =
      TimestampRange
        .builder
        .ifSome(beginDate)(_.beginDate(_))
        .ifSome(endDate)(_.endDate(_))
        .build

    def unsubscribeFromEventRequest(
      resourceArn: Option[String] = None,
      event: Option[String] = None,
      topicArn: Option[String] = None
    ): UnsubscribeFromEventRequest =
      UnsubscribeFromEventRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(event)(_.event(_))
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def unsupportedFeatureException(
      message: Option[String] = None,
      canRetry: Option[Boolean] = None
    ): UnsupportedFeatureException =
      UnsupportedFeatureException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(canRetry)(_.canRetry(_))
        .build

    def updateAssessmentTargetRequest(
      assessmentTargetArn: Option[String] = None,
      assessmentTargetName: Option[String] = None,
      resourceGroupArn: Option[String] = None
    ): UpdateAssessmentTargetRequest =
      UpdateAssessmentTargetRequest
        .builder
        .ifSome(assessmentTargetArn)(_.assessmentTargetArn(_))
        .ifSome(assessmentTargetName)(_.assessmentTargetName(_))
        .ifSome(resourceGroupArn)(_.resourceGroupArn(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
