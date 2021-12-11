package goober.hi

import goober.free.ssm.SsmIO
import software.amazon.awssdk.services.ssm.model._


object ssm {
  import goober.free.{ssm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountSharingInfo(
      accountId: Option[String] = None,
      sharedDocumentVersion: Option[String] = None
    ): AccountSharingInfo =
      AccountSharingInfo
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(sharedDocumentVersion)(_.sharedDocumentVersion(_))
        .build

    def activation(
      activationId: Option[String] = None,
      description: Option[String] = None,
      defaultInstanceName: Option[String] = None,
      iamRole: Option[String] = None,
      registrationLimit: Option[Int] = None,
      registrationsCount: Option[Int] = None,
      expirationDate: Option[ExpirationDate] = None,
      expired: Option[Boolean] = None,
      createdDate: Option[CreatedDate] = None,
      tags: Option[List[Tag]] = None
    ): Activation =
      Activation
        .builder
        .ifSome(activationId)(_.activationId(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultInstanceName)(_.defaultInstanceName(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(registrationLimit)(_.registrationLimit(_))
        .ifSome(registrationsCount)(_.registrationsCount(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(expired)(_.expired(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsToResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsToResourceRequest =
      AddTagsToResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def alreadyExistsException(
      message: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associateOpsItemRelatedItemRequest(
      opsItemId: Option[String] = None,
      associationType: Option[String] = None,
      resourceType: Option[String] = None,
      resourceUri: Option[String] = None
    ): AssociateOpsItemRelatedItemRequest =
      AssociateOpsItemRelatedItemRequest
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(associationType)(_.associationType(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceUri)(_.resourceUri(_))
        .build

    def associateOpsItemRelatedItemResponse(
      associationId: Option[String] = None
    ): AssociateOpsItemRelatedItemResponse =
      AssociateOpsItemRelatedItemResponse
        .builder
        .ifSome(associationId)(_.associationId(_))
        .build

    def associatedInstances(

    ): AssociatedInstances =
      AssociatedInstances
        .builder

        .build

    def association(
      name: Option[String] = None,
      instanceId: Option[String] = None,
      associationId: Option[String] = None,
      associationVersion: Option[String] = None,
      documentVersion: Option[String] = None,
      targets: Option[List[Target]] = None,
      lastExecutionDate: Option[DateTime] = None,
      overview: Option[AssociationOverview] = None,
      scheduleExpression: Option[String] = None,
      associationName: Option[String] = None
    ): Association =
      Association
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(lastExecutionDate)(_.lastExecutionDate(_))
        .ifSome(overview)(_.overview(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(associationName)(_.associationName(_))
        .build

    def associationAlreadyExists(

    ): AssociationAlreadyExists =
      AssociationAlreadyExists
        .builder

        .build

    def associationDescription(
      name: Option[String] = None,
      instanceId: Option[String] = None,
      associationVersion: Option[String] = None,
      date: Option[DateTime] = None,
      lastUpdateAssociationDate: Option[DateTime] = None,
      status: Option[AssociationStatus] = None,
      overview: Option[AssociationOverview] = None,
      documentVersion: Option[String] = None,
      automationTargetParameterName: Option[String] = None,
      parameters: Option[Parameters] = None,
      associationId: Option[String] = None,
      targets: Option[List[Target]] = None,
      scheduleExpression: Option[String] = None,
      outputLocation: Option[InstanceAssociationOutputLocation] = None,
      lastExecutionDate: Option[DateTime] = None,
      lastSuccessfulExecutionDate: Option[DateTime] = None,
      associationName: Option[String] = None,
      maxErrors: Option[String] = None,
      maxConcurrency: Option[String] = None,
      complianceSeverity: Option[String] = None,
      syncCompliance: Option[String] = None,
      applyOnlyAtCronInterval: Option[Boolean] = None,
      calendarNames: Option[List[CalendarNameOrARN]] = None,
      targetLocations: Option[List[TargetLocation]] = None
    ): AssociationDescription =
      AssociationDescription
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(date)(_.date(_))
        .ifSome(lastUpdateAssociationDate)(_.lastUpdateAssociationDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(overview)(_.overview(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(automationTargetParameterName)(_.automationTargetParameterName(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(lastExecutionDate)(_.lastExecutionDate(_))
        .ifSome(lastSuccessfulExecutionDate)(_.lastSuccessfulExecutionDate(_))
        .ifSome(associationName)(_.associationName(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(complianceSeverity)(_.complianceSeverity(_))
        .ifSome(syncCompliance)(_.syncCompliance(_))
        .ifSome(applyOnlyAtCronInterval)(_.applyOnlyAtCronInterval(_))
        .ifSome(calendarNames)(_.calendarNames(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .build

    def associationDoesNotExist(
      message: Option[String] = None
    ): AssociationDoesNotExist =
      AssociationDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associationExecution(
      associationId: Option[String] = None,
      associationVersion: Option[String] = None,
      executionId: Option[String] = None,
      status: Option[String] = None,
      detailedStatus: Option[String] = None,
      createdTime: Option[DateTime] = None,
      lastExecutionDate: Option[DateTime] = None,
      resourceCountByStatus: Option[String] = None
    ): AssociationExecution =
      AssociationExecution
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(executionId)(_.executionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(detailedStatus)(_.detailedStatus(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastExecutionDate)(_.lastExecutionDate(_))
        .ifSome(resourceCountByStatus)(_.resourceCountByStatus(_))
        .build

    def associationExecutionDoesNotExist(
      message: Option[String] = None
    ): AssociationExecutionDoesNotExist =
      AssociationExecutionDoesNotExist
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associationExecutionFilter(
      key: Option[String] = None,
      value: Option[String] = None,
      `type`: Option[String] = None
    ): AssociationExecutionFilter =
      AssociationExecutionFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def associationExecutionTarget(
      associationId: Option[String] = None,
      associationVersion: Option[String] = None,
      executionId: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      status: Option[String] = None,
      detailedStatus: Option[String] = None,
      lastExecutionDate: Option[DateTime] = None,
      outputSource: Option[OutputSource] = None
    ): AssociationExecutionTarget =
      AssociationExecutionTarget
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(executionId)(_.executionId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(status)(_.status(_))
        .ifSome(detailedStatus)(_.detailedStatus(_))
        .ifSome(lastExecutionDate)(_.lastExecutionDate(_))
        .ifSome(outputSource)(_.outputSource(_))
        .build

    def associationExecutionTargetsFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): AssociationExecutionTargetsFilter =
      AssociationExecutionTargetsFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def associationFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): AssociationFilter =
      AssociationFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def associationLimitExceeded(

    ): AssociationLimitExceeded =
      AssociationLimitExceeded
        .builder

        .build

    def associationOverview(
      status: Option[String] = None,
      detailedStatus: Option[String] = None,
      associationStatusAggregatedCount: Option[AssociationStatusAggregatedCount] = None
    ): AssociationOverview =
      AssociationOverview
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(detailedStatus)(_.detailedStatus(_))
        .ifSome(associationStatusAggregatedCount)(_.associationStatusAggregatedCount(_))
        .build

    def associationStatus(
      date: Option[DateTime] = None,
      name: Option[String] = None,
      message: Option[String] = None,
      additionalInfo: Option[String] = None
    ): AssociationStatus =
      AssociationStatus
        .builder
        .ifSome(date)(_.date(_))
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .build

    def associationVersionInfo(
      associationId: Option[String] = None,
      associationVersion: Option[String] = None,
      createdDate: Option[DateTime] = None,
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      parameters: Option[Parameters] = None,
      targets: Option[List[Target]] = None,
      scheduleExpression: Option[String] = None,
      outputLocation: Option[InstanceAssociationOutputLocation] = None,
      associationName: Option[String] = None,
      maxErrors: Option[String] = None,
      maxConcurrency: Option[String] = None,
      complianceSeverity: Option[String] = None,
      syncCompliance: Option[String] = None,
      applyOnlyAtCronInterval: Option[Boolean] = None,
      calendarNames: Option[List[CalendarNameOrARN]] = None,
      targetLocations: Option[List[TargetLocation]] = None
    ): AssociationVersionInfo =
      AssociationVersionInfo
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(associationName)(_.associationName(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(complianceSeverity)(_.complianceSeverity(_))
        .ifSome(syncCompliance)(_.syncCompliance(_))
        .ifSome(applyOnlyAtCronInterval)(_.applyOnlyAtCronInterval(_))
        .ifSome(calendarNames)(_.calendarNames(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .build

    def associationVersionLimitExceeded(
      message: Option[String] = None
    ): AssociationVersionLimitExceeded =
      AssociationVersionLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachmentContent(
      name: Option[String] = None,
      size: Option[ContentLength] = None,
      hash: Option[String] = None,
      hashType: Option[String] = None,
      url: Option[String] = None
    ): AttachmentContent =
      AttachmentContent
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(size)(_.size(_))
        .ifSome(hash)(_.hash(_))
        .ifSome(hashType)(_.hashType(_))
        .ifSome(url)(_.url(_))
        .build

    def attachmentInformation(
      name: Option[String] = None
    ): AttachmentInformation =
      AttachmentInformation
        .builder
        .ifSome(name)(_.name(_))
        .build

    def attachmentsSource(
      key: Option[String] = None,
      values: Option[List[AttachmentsSourceValue]] = None,
      name: Option[String] = None
    ): AttachmentsSource =
      AttachmentsSource
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(name)(_.name(_))
        .build

    def automationDefinitionNotApprovedException(
      message: Option[String] = None
    ): AutomationDefinitionNotApprovedException =
      AutomationDefinitionNotApprovedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automationDefinitionNotFoundException(
      message: Option[String] = None
    ): AutomationDefinitionNotFoundException =
      AutomationDefinitionNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automationDefinitionVersionNotFoundException(
      message: Option[String] = None
    ): AutomationDefinitionVersionNotFoundException =
      AutomationDefinitionVersionNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automationExecution(
      automationExecutionId: Option[String] = None,
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      executionStartTime: Option[DateTime] = None,
      executionEndTime: Option[DateTime] = None,
      automationExecutionStatus: Option[String] = None,
      stepExecutions: Option[List[StepExecution]] = None,
      stepExecutionsTruncated: Option[Boolean] = None,
      parameters: Option[AutomationParameterMap] = None,
      outputs: Option[AutomationParameterMap] = None,
      failureMessage: Option[String] = None,
      mode: Option[String] = None,
      parentAutomationExecutionId: Option[String] = None,
      executedBy: Option[String] = None,
      currentStepName: Option[String] = None,
      currentAction: Option[String] = None,
      targetParameterName: Option[String] = None,
      targets: Option[List[Target]] = None,
      targetMaps: Option[List[TargetMap]] = None,
      resolvedTargets: Option[ResolvedTargets] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      target: Option[String] = None,
      targetLocations: Option[List[TargetLocation]] = None,
      progressCounters: Option[ProgressCounters] = None,
      automationSubtype: Option[String] = None,
      scheduledTime: Option[DateTime] = None,
      runbooks: Option[List[Runbook]] = None,
      opsItemId: Option[String] = None,
      associationId: Option[String] = None,
      changeRequestName: Option[String] = None
    ): AutomationExecution =
      AutomationExecution
        .builder
        .ifSome(automationExecutionId)(_.automationExecutionId(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(executionStartTime)(_.executionStartTime(_))
        .ifSome(executionEndTime)(_.executionEndTime(_))
        .ifSome(automationExecutionStatus)(_.automationExecutionStatus(_))
        .ifSome(stepExecutions)(_.stepExecutions(_))
        .ifSome(stepExecutionsTruncated)(_.stepExecutionsTruncated(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(parentAutomationExecutionId)(_.parentAutomationExecutionId(_))
        .ifSome(executedBy)(_.executedBy(_))
        .ifSome(currentStepName)(_.currentStepName(_))
        .ifSome(currentAction)(_.currentAction(_))
        .ifSome(targetParameterName)(_.targetParameterName(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(targetMaps)(_.targetMaps(_))
        .ifSome(resolvedTargets)(_.resolvedTargets(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(target)(_.target(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .ifSome(progressCounters)(_.progressCounters(_))
        .ifSome(automationSubtype)(_.automationSubtype(_))
        .ifSome(scheduledTime)(_.scheduledTime(_))
        .ifSome(runbooks)(_.runbooks(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(changeRequestName)(_.changeRequestName(_))
        .build

    def automationExecutionFilter(
      key: Option[String] = None,
      values: Option[List[AutomationExecutionFilterValue]] = None
    ): AutomationExecutionFilter =
      AutomationExecutionFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def automationExecutionLimitExceededException(
      message: Option[String] = None
    ): AutomationExecutionLimitExceededException =
      AutomationExecutionLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automationExecutionMetadata(
      automationExecutionId: Option[String] = None,
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      automationExecutionStatus: Option[String] = None,
      executionStartTime: Option[DateTime] = None,
      executionEndTime: Option[DateTime] = None,
      executedBy: Option[String] = None,
      logFile: Option[String] = None,
      outputs: Option[AutomationParameterMap] = None,
      mode: Option[String] = None,
      parentAutomationExecutionId: Option[String] = None,
      currentStepName: Option[String] = None,
      currentAction: Option[String] = None,
      failureMessage: Option[String] = None,
      targetParameterName: Option[String] = None,
      targets: Option[List[Target]] = None,
      targetMaps: Option[List[TargetMap]] = None,
      resolvedTargets: Option[ResolvedTargets] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      target: Option[String] = None,
      automationType: Option[String] = None,
      automationSubtype: Option[String] = None,
      scheduledTime: Option[DateTime] = None,
      runbooks: Option[List[Runbook]] = None,
      opsItemId: Option[String] = None,
      associationId: Option[String] = None,
      changeRequestName: Option[String] = None
    ): AutomationExecutionMetadata =
      AutomationExecutionMetadata
        .builder
        .ifSome(automationExecutionId)(_.automationExecutionId(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(automationExecutionStatus)(_.automationExecutionStatus(_))
        .ifSome(executionStartTime)(_.executionStartTime(_))
        .ifSome(executionEndTime)(_.executionEndTime(_))
        .ifSome(executedBy)(_.executedBy(_))
        .ifSome(logFile)(_.logFile(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(parentAutomationExecutionId)(_.parentAutomationExecutionId(_))
        .ifSome(currentStepName)(_.currentStepName(_))
        .ifSome(currentAction)(_.currentAction(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(targetParameterName)(_.targetParameterName(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(targetMaps)(_.targetMaps(_))
        .ifSome(resolvedTargets)(_.resolvedTargets(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(target)(_.target(_))
        .ifSome(automationType)(_.automationType(_))
        .ifSome(automationSubtype)(_.automationSubtype(_))
        .ifSome(scheduledTime)(_.scheduledTime(_))
        .ifSome(runbooks)(_.runbooks(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(changeRequestName)(_.changeRequestName(_))
        .build

    def automationExecutionNotFoundException(
      message: Option[String] = None
    ): AutomationExecutionNotFoundException =
      AutomationExecutionNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automationStepNotFoundException(
      message: Option[String] = None
    ): AutomationStepNotFoundException =
      AutomationStepNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def baselineOverride(
      operatingSystem: Option[String] = None,
      globalFilters: Option[PatchFilterGroup] = None,
      approvalRules: Option[PatchRuleGroup] = None,
      approvedPatches: Option[List[PatchId]] = None,
      approvedPatchesComplianceLevel: Option[String] = None,
      rejectedPatches: Option[List[PatchId]] = None,
      rejectedPatchesAction: Option[String] = None,
      approvedPatchesEnableNonSecurity: Option[Boolean] = None,
      sources: Option[List[PatchSource]] = None
    ): BaselineOverride =
      BaselineOverride
        .builder
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(globalFilters)(_.globalFilters(_))
        .ifSome(approvalRules)(_.approvalRules(_))
        .ifSome(approvedPatches)(_.approvedPatches(_))
        .ifSome(approvedPatchesComplianceLevel)(_.approvedPatchesComplianceLevel(_))
        .ifSome(rejectedPatches)(_.rejectedPatches(_))
        .ifSome(rejectedPatchesAction)(_.rejectedPatchesAction(_))
        .ifSome(approvedPatchesEnableNonSecurity)(_.approvedPatchesEnableNonSecurity(_))
        .ifSome(sources)(_.sources(_))
        .build

    def cancelCommandRequest(
      commandId: Option[String] = None,
      instanceIds: Option[List[InstanceId]] = None
    ): CancelCommandRequest =
      CancelCommandRequest
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .build

    def cancelMaintenanceWindowExecutionRequest(
      windowExecutionId: Option[String] = None
    ): CancelMaintenanceWindowExecutionRequest =
      CancelMaintenanceWindowExecutionRequest
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .build

    def cloudWatchOutputConfig(
      cloudWatchLogGroupName: Option[String] = None,
      cloudWatchOutputEnabled: Option[Boolean] = None
    ): CloudWatchOutputConfig =
      CloudWatchOutputConfig
        .builder
        .ifSome(cloudWatchLogGroupName)(_.cloudWatchLogGroupName(_))
        .ifSome(cloudWatchOutputEnabled)(_.cloudWatchOutputEnabled(_))
        .build

    def command(
      commandId: Option[String] = None,
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      comment: Option[String] = None,
      expiresAfter: Option[DateTime] = None,
      parameters: Option[Parameters] = None,
      instanceIds: Option[List[InstanceId]] = None,
      targets: Option[List[Target]] = None,
      requestedDateTime: Option[DateTime] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      outputS3Region: Option[String] = None,
      outputS3BucketName: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      targetCount: Option[Int] = None,
      completedCount: Option[Int] = None,
      errorCount: Option[Int] = None,
      deliveryTimedOutCount: Option[Int] = None,
      serviceRole: Option[String] = None,
      notificationConfig: Option[NotificationConfig] = None,
      cloudWatchOutputConfig: Option[CloudWatchOutputConfig] = None,
      timeoutSeconds: Option[Int] = None
    ): Command =
      Command
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(expiresAfter)(_.expiresAfter(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(requestedDateTime)(_.requestedDateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(outputS3Region)(_.outputS3Region(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(targetCount)(_.targetCount(_))
        .ifSome(completedCount)(_.completedCount(_))
        .ifSome(errorCount)(_.errorCount(_))
        .ifSome(deliveryTimedOutCount)(_.deliveryTimedOutCount(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(notificationConfig)(_.notificationConfig(_))
        .ifSome(cloudWatchOutputConfig)(_.cloudWatchOutputConfig(_))
        .ifSome(timeoutSeconds)(_.timeoutSeconds(_))
        .build

    def commandFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): CommandFilter =
      CommandFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def commandInvocation(
      commandId: Option[String] = None,
      instanceId: Option[String] = None,
      instanceName: Option[String] = None,
      comment: Option[String] = None,
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      requestedDateTime: Option[DateTime] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      traceOutput: Option[String] = None,
      standardOutputUrl: Option[String] = None,
      standardErrorUrl: Option[String] = None,
      commandPlugins: Option[List[CommandPlugin]] = None,
      serviceRole: Option[String] = None,
      notificationConfig: Option[NotificationConfig] = None,
      cloudWatchOutputConfig: Option[CloudWatchOutputConfig] = None
    ): CommandInvocation =
      CommandInvocation
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceName)(_.instanceName(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(requestedDateTime)(_.requestedDateTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(traceOutput)(_.traceOutput(_))
        .ifSome(standardOutputUrl)(_.standardOutputUrl(_))
        .ifSome(standardErrorUrl)(_.standardErrorUrl(_))
        .ifSome(commandPlugins)(_.commandPlugins(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(notificationConfig)(_.notificationConfig(_))
        .ifSome(cloudWatchOutputConfig)(_.cloudWatchOutputConfig(_))
        .build

    def commandPlugin(
      name: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      responseCode: Option[Int] = None,
      responseStartDateTime: Option[DateTime] = None,
      responseFinishDateTime: Option[DateTime] = None,
      output: Option[String] = None,
      standardOutputUrl: Option[String] = None,
      standardErrorUrl: Option[String] = None,
      outputS3Region: Option[String] = None,
      outputS3BucketName: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None
    ): CommandPlugin =
      CommandPlugin
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(responseCode)(_.responseCode(_))
        .ifSome(responseStartDateTime)(_.responseStartDateTime(_))
        .ifSome(responseFinishDateTime)(_.responseFinishDateTime(_))
        .ifSome(output)(_.output(_))
        .ifSome(standardOutputUrl)(_.standardOutputUrl(_))
        .ifSome(standardErrorUrl)(_.standardErrorUrl(_))
        .ifSome(outputS3Region)(_.outputS3Region(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .build

    def complianceExecutionSummary(
      executionTime: Option[DateTime] = None,
      executionId: Option[String] = None,
      executionType: Option[String] = None
    ): ComplianceExecutionSummary =
      ComplianceExecutionSummary
        .builder
        .ifSome(executionTime)(_.executionTime(_))
        .ifSome(executionId)(_.executionId(_))
        .ifSome(executionType)(_.executionType(_))
        .build

    def complianceItem(
      complianceType: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      id: Option[String] = None,
      title: Option[String] = None,
      status: Option[String] = None,
      severity: Option[String] = None,
      executionSummary: Option[ComplianceExecutionSummary] = None,
      details: Option[ComplianceItemDetails] = None
    ): ComplianceItem =
      ComplianceItem
        .builder
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(id)(_.id(_))
        .ifSome(title)(_.title(_))
        .ifSome(status)(_.status(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(executionSummary)(_.executionSummary(_))
        .ifSome(details)(_.details(_))
        .build

    def complianceItemEntry(
      id: Option[String] = None,
      title: Option[String] = None,
      severity: Option[String] = None,
      status: Option[String] = None,
      details: Option[ComplianceItemDetails] = None
    ): ComplianceItemEntry =
      ComplianceItemEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(title)(_.title(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(status)(_.status(_))
        .ifSome(details)(_.details(_))
        .build

    def complianceStringFilter(
      key: Option[String] = None,
      values: Option[List[ComplianceFilterValue]] = None,
      `type`: Option[String] = None
    ): ComplianceStringFilter =
      ComplianceStringFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def complianceSummaryItem(
      complianceType: Option[String] = None,
      compliantSummary: Option[CompliantSummary] = None,
      nonCompliantSummary: Option[NonCompliantSummary] = None
    ): ComplianceSummaryItem =
      ComplianceSummaryItem
        .builder
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(compliantSummary)(_.compliantSummary(_))
        .ifSome(nonCompliantSummary)(_.nonCompliantSummary(_))
        .build

    def complianceTypeCountLimitExceededException(
      message: Option[String] = None
    ): ComplianceTypeCountLimitExceededException =
      ComplianceTypeCountLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def compliantSummary(
      compliantCount: Option[Int] = None,
      severitySummary: Option[SeveritySummary] = None
    ): CompliantSummary =
      CompliantSummary
        .builder
        .ifSome(compliantCount)(_.compliantCount(_))
        .ifSome(severitySummary)(_.severitySummary(_))
        .build

    def createActivationRequest(
      description: Option[String] = None,
      defaultInstanceName: Option[String] = None,
      iamRole: Option[String] = None,
      registrationLimit: Option[Int] = None,
      expirationDate: Option[ExpirationDate] = None,
      tags: Option[List[Tag]] = None
    ): CreateActivationRequest =
      CreateActivationRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(defaultInstanceName)(_.defaultInstanceName(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(registrationLimit)(_.registrationLimit(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssociationBatchRequest(
      entries: Option[List[CreateAssociationBatchRequestEntry]] = None
    ): CreateAssociationBatchRequest =
      CreateAssociationBatchRequest
        .builder
        .ifSome(entries)(_.entries(_))
        .build

    def createAssociationBatchRequestEntry(
      name: Option[String] = None,
      instanceId: Option[String] = None,
      parameters: Option[Parameters] = None,
      automationTargetParameterName: Option[String] = None,
      documentVersion: Option[String] = None,
      targets: Option[List[Target]] = None,
      scheduleExpression: Option[String] = None,
      outputLocation: Option[InstanceAssociationOutputLocation] = None,
      associationName: Option[String] = None,
      maxErrors: Option[String] = None,
      maxConcurrency: Option[String] = None,
      complianceSeverity: Option[String] = None,
      syncCompliance: Option[String] = None,
      applyOnlyAtCronInterval: Option[Boolean] = None,
      calendarNames: Option[List[CalendarNameOrARN]] = None,
      targetLocations: Option[List[TargetLocation]] = None
    ): CreateAssociationBatchRequestEntry =
      CreateAssociationBatchRequestEntry
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(automationTargetParameterName)(_.automationTargetParameterName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(associationName)(_.associationName(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(complianceSeverity)(_.complianceSeverity(_))
        .ifSome(syncCompliance)(_.syncCompliance(_))
        .ifSome(applyOnlyAtCronInterval)(_.applyOnlyAtCronInterval(_))
        .ifSome(calendarNames)(_.calendarNames(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .build

    def createAssociationRequest(
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      instanceId: Option[String] = None,
      parameters: Option[Parameters] = None,
      targets: Option[List[Target]] = None,
      scheduleExpression: Option[String] = None,
      outputLocation: Option[InstanceAssociationOutputLocation] = None,
      associationName: Option[String] = None,
      automationTargetParameterName: Option[String] = None,
      maxErrors: Option[String] = None,
      maxConcurrency: Option[String] = None,
      complianceSeverity: Option[String] = None,
      syncCompliance: Option[String] = None,
      applyOnlyAtCronInterval: Option[Boolean] = None,
      calendarNames: Option[List[CalendarNameOrARN]] = None,
      targetLocations: Option[List[TargetLocation]] = None
    ): CreateAssociationRequest =
      CreateAssociationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(associationName)(_.associationName(_))
        .ifSome(automationTargetParameterName)(_.automationTargetParameterName(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(complianceSeverity)(_.complianceSeverity(_))
        .ifSome(syncCompliance)(_.syncCompliance(_))
        .ifSome(applyOnlyAtCronInterval)(_.applyOnlyAtCronInterval(_))
        .ifSome(calendarNames)(_.calendarNames(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .build

    def createDocumentRequest(
      content: Option[String] = None,
      requires: Option[List[DocumentRequires]] = None,
      attachments: Option[List[AttachmentsSource]] = None,
      name: Option[String] = None,
      displayName: Option[String] = None,
      versionName: Option[String] = None,
      documentType: Option[String] = None,
      documentFormat: Option[String] = None,
      targetType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDocumentRequest =
      CreateDocumentRequest
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(requires)(_.requires(_))
        .ifSome(attachments)(_.attachments(_))
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(documentType)(_.documentType(_))
        .ifSome(documentFormat)(_.documentFormat(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMaintenanceWindowRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      schedule: Option[String] = None,
      scheduleTimezone: Option[String] = None,
      scheduleOffset: Option[Int] = None,
      duration: Option[Int] = None,
      cutoff: Option[Int] = None,
      allowUnassociatedTargets: Option[Boolean] = None,
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateMaintenanceWindowRequest =
      CreateMaintenanceWindowRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(scheduleTimezone)(_.scheduleTimezone(_))
        .ifSome(scheduleOffset)(_.scheduleOffset(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(cutoff)(_.cutoff(_))
        .ifSome(allowUnassociatedTargets)(_.allowUnassociatedTargets(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createOpsItemRequest(
      description: Option[String] = None,
      opsItemType: Option[String] = None,
      operationalData: Option[OpsItemOperationalData] = None,
      notifications: Option[List[OpsItemNotification]] = None,
      priority: Option[Int] = None,
      relatedOpsItems: Option[List[RelatedOpsItem]] = None,
      source: Option[String] = None,
      title: Option[String] = None,
      tags: Option[List[Tag]] = None,
      category: Option[String] = None,
      severity: Option[String] = None,
      actualStartTime: Option[DateTime] = None,
      actualEndTime: Option[DateTime] = None,
      plannedStartTime: Option[DateTime] = None,
      plannedEndTime: Option[DateTime] = None
    ): CreateOpsItemRequest =
      CreateOpsItemRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(opsItemType)(_.opsItemType(_))
        .ifSome(operationalData)(_.operationalData(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(relatedOpsItems)(_.relatedOpsItems(_))
        .ifSome(source)(_.source(_))
        .ifSome(title)(_.title(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(category)(_.category(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(actualStartTime)(_.actualStartTime(_))
        .ifSome(actualEndTime)(_.actualEndTime(_))
        .ifSome(plannedStartTime)(_.plannedStartTime(_))
        .ifSome(plannedEndTime)(_.plannedEndTime(_))
        .build

    def createOpsItemResponse(
      opsItemId: Option[String] = None
    ): CreateOpsItemResponse =
      CreateOpsItemResponse
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .build

    def createOpsMetadataRequest(
      resourceId: Option[String] = None,
      metadata: Option[MetadataMap] = None,
      tags: Option[List[Tag]] = None
    ): CreateOpsMetadataRequest =
      CreateOpsMetadataRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPatchBaselineRequest(
      operatingSystem: Option[String] = None,
      name: Option[String] = None,
      globalFilters: Option[PatchFilterGroup] = None,
      approvalRules: Option[PatchRuleGroup] = None,
      approvedPatches: Option[List[PatchId]] = None,
      approvedPatchesComplianceLevel: Option[String] = None,
      approvedPatchesEnableNonSecurity: Option[Boolean] = None,
      rejectedPatches: Option[List[PatchId]] = None,
      rejectedPatchesAction: Option[String] = None,
      description: Option[String] = None,
      sources: Option[List[PatchSource]] = None,
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePatchBaselineRequest =
      CreatePatchBaselineRequest
        .builder
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(name)(_.name(_))
        .ifSome(globalFilters)(_.globalFilters(_))
        .ifSome(approvalRules)(_.approvalRules(_))
        .ifSome(approvedPatches)(_.approvedPatches(_))
        .ifSome(approvedPatchesComplianceLevel)(_.approvedPatchesComplianceLevel(_))
        .ifSome(approvedPatchesEnableNonSecurity)(_.approvedPatchesEnableNonSecurity(_))
        .ifSome(rejectedPatches)(_.rejectedPatches(_))
        .ifSome(rejectedPatchesAction)(_.rejectedPatchesAction(_))
        .ifSome(description)(_.description(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createResourceDataSyncRequest(
      syncName: Option[String] = None,
      s3Destination: Option[ResourceDataSyncS3Destination] = None,
      syncType: Option[String] = None,
      syncSource: Option[ResourceDataSyncSource] = None
    ): CreateResourceDataSyncRequest =
      CreateResourceDataSyncRequest
        .builder
        .ifSome(syncName)(_.syncName(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(syncType)(_.syncType(_))
        .ifSome(syncSource)(_.syncSource(_))
        .build

    def customSchemaCountLimitExceededException(
      message: Option[String] = None
    ): CustomSchemaCountLimitExceededException =
      CustomSchemaCountLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteActivationRequest(
      activationId: Option[String] = None
    ): DeleteActivationRequest =
      DeleteActivationRequest
        .builder
        .ifSome(activationId)(_.activationId(_))
        .build

    def deleteAssociationRequest(
      name: Option[String] = None,
      instanceId: Option[String] = None,
      associationId: Option[String] = None
    ): DeleteAssociationRequest =
      DeleteAssociationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .build

    def deleteDocumentRequest(
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      versionName: Option[String] = None,
      force: Option[Boolean] = None
    ): DeleteDocumentRequest =
      DeleteDocumentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(force)(_.force(_))
        .build

    def deleteInventoryRequest(
      typeName: Option[String] = None,
      schemaDeleteOption: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteInventoryRequest =
      DeleteInventoryRequest
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(schemaDeleteOption)(_.schemaDeleteOption(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteMaintenanceWindowRequest(
      windowId: Option[String] = None
    ): DeleteMaintenanceWindowRequest =
      DeleteMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .build

    def deleteOpsMetadataRequest(
      opsMetadataArn: Option[String] = None
    ): DeleteOpsMetadataRequest =
      DeleteOpsMetadataRequest
        .builder
        .ifSome(opsMetadataArn)(_.opsMetadataArn(_))
        .build

    def deleteParameterRequest(
      name: Option[String] = None
    ): DeleteParameterRequest =
      DeleteParameterRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteParametersRequest(
      names: Option[List[PSParameterName]] = None
    ): DeleteParametersRequest =
      DeleteParametersRequest
        .builder
        .ifSome(names)(_.names(_))
        .build

    def deletePatchBaselineRequest(
      baselineId: Option[String] = None
    ): DeletePatchBaselineRequest =
      DeletePatchBaselineRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .build

    def deleteResourceDataSyncRequest(
      syncName: Option[String] = None,
      syncType: Option[String] = None
    ): DeleteResourceDataSyncRequest =
      DeleteResourceDataSyncRequest
        .builder
        .ifSome(syncName)(_.syncName(_))
        .ifSome(syncType)(_.syncType(_))
        .build

    def deregisterManagedInstanceRequest(
      instanceId: Option[String] = None
    ): DeregisterManagedInstanceRequest =
      DeregisterManagedInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def deregisterPatchBaselineForPatchGroupRequest(
      baselineId: Option[String] = None,
      patchGroup: Option[String] = None
    ): DeregisterPatchBaselineForPatchGroupRequest =
      DeregisterPatchBaselineForPatchGroupRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .ifSome(patchGroup)(_.patchGroup(_))
        .build

    def deregisterTargetFromMaintenanceWindowRequest(
      windowId: Option[String] = None,
      windowTargetId: Option[String] = None,
      safe: Option[Boolean] = None
    ): DeregisterTargetFromMaintenanceWindowRequest =
      DeregisterTargetFromMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTargetId)(_.windowTargetId(_))
        .ifSome(safe)(_.safe(_))
        .build

    def deregisterTaskFromMaintenanceWindowRequest(
      windowId: Option[String] = None,
      windowTaskId: Option[String] = None
    ): DeregisterTaskFromMaintenanceWindowRequest =
      DeregisterTaskFromMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTaskId)(_.windowTaskId(_))
        .build

    def describeActivationsFilter(
      filterKey: Option[String] = None,
      filterValues: Option[List[String]] = None
    ): DescribeActivationsFilter =
      DescribeActivationsFilter
        .builder
        .ifSome(filterKey)(_.filterKey(_))
        .ifSome(filterValues)(_.filterValues(_))
        .build

    def describeActivationsRequest(
      filters: Option[List[DescribeActivationsFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeActivationsRequest =
      DescribeActivationsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAssociationExecutionTargetsRequest(
      associationId: Option[String] = None,
      executionId: Option[String] = None,
      filters: Option[List[AssociationExecutionTargetsFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAssociationExecutionTargetsRequest =
      DescribeAssociationExecutionTargetsRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(executionId)(_.executionId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAssociationExecutionsRequest(
      associationId: Option[String] = None,
      filters: Option[List[AssociationExecutionFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAssociationExecutionsRequest =
      DescribeAssociationExecutionsRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAssociationRequest(
      name: Option[String] = None,
      instanceId: Option[String] = None,
      associationId: Option[String] = None,
      associationVersion: Option[String] = None
    ): DescribeAssociationRequest =
      DescribeAssociationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .build

    def describeAutomationExecutionsRequest(
      filters: Option[List[AutomationExecutionFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAutomationExecutionsRequest =
      DescribeAutomationExecutionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAutomationStepExecutionsRequest(
      automationExecutionId: Option[String] = None,
      filters: Option[List[StepExecutionFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      reverseOrder: Option[Boolean] = None
    ): DescribeAutomationStepExecutionsRequest =
      DescribeAutomationStepExecutionsRequest
        .builder
        .ifSome(automationExecutionId)(_.automationExecutionId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(reverseOrder)(_.reverseOrder(_))
        .build

    def describeAvailablePatchesRequest(
      filters: Option[List[PatchOrchestratorFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAvailablePatchesRequest =
      DescribeAvailablePatchesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDocumentPermissionRequest(
      name: Option[String] = None,
      permissionType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDocumentPermissionRequest =
      DescribeDocumentPermissionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(permissionType)(_.permissionType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDocumentPermissionResponse(
      accountIds: Option[List[AccountId]] = None,
      accountSharingInfoList: Option[List[AccountSharingInfo]] = None,
      nextToken: Option[String] = None
    ): DescribeDocumentPermissionResponse =
      DescribeDocumentPermissionResponse
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(accountSharingInfoList)(_.accountSharingInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDocumentRequest(
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      versionName: Option[String] = None
    ): DescribeDocumentRequest =
      DescribeDocumentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(versionName)(_.versionName(_))
        .build

    def describeEffectiveInstanceAssociationsRequest(
      instanceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeEffectiveInstanceAssociationsRequest =
      DescribeEffectiveInstanceAssociationsRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEffectivePatchesForPatchBaselineRequest(
      baselineId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeEffectivePatchesForPatchBaselineRequest =
      DescribeEffectivePatchesForPatchBaselineRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstanceAssociationsStatusRequest(
      instanceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInstanceAssociationsStatusRequest =
      DescribeInstanceAssociationsStatusRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstanceInformationRequest(
      instanceInformationFilterList: Option[List[InstanceInformationFilter]] = None,
      filters: Option[List[InstanceInformationStringFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeInstanceInformationRequest =
      DescribeInstanceInformationRequest
        .builder
        .ifSome(instanceInformationFilterList)(_.instanceInformationFilterList(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstancePatchStatesForPatchGroupRequest(
      patchGroup: Option[String] = None,
      filters: Option[List[InstancePatchStateFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeInstancePatchStatesForPatchGroupRequest =
      DescribeInstancePatchStatesForPatchGroupRequest
        .builder
        .ifSome(patchGroup)(_.patchGroup(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeInstancePatchStatesRequest(
      instanceIds: Option[List[InstanceId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeInstancePatchStatesRequest =
      DescribeInstancePatchStatesRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeInstancePatchesRequest(
      instanceId: Option[String] = None,
      filters: Option[List[PatchOrchestratorFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeInstancePatchesRequest =
      DescribeInstancePatchesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeInventoryDeletionsRequest(
      deletionId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeInventoryDeletionsRequest =
      DescribeInventoryDeletionsRequest
        .builder
        .ifSome(deletionId)(_.deletionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeMaintenanceWindowExecutionTaskInvocationsRequest(
      windowExecutionId: Option[String] = None,
      taskId: Option[String] = None,
      filters: Option[List[MaintenanceWindowFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowExecutionTaskInvocationsRequest =
      DescribeMaintenanceWindowExecutionTaskInvocationsRequest
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(taskId)(_.taskId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowExecutionTasksRequest(
      windowExecutionId: Option[String] = None,
      filters: Option[List[MaintenanceWindowFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowExecutionTasksRequest =
      DescribeMaintenanceWindowExecutionTasksRequest
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowExecutionsRequest(
      windowId: Option[String] = None,
      filters: Option[List[MaintenanceWindowFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowExecutionsRequest =
      DescribeMaintenanceWindowExecutionsRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowScheduleRequest(
      windowId: Option[String] = None,
      targets: Option[List[Target]] = None,
      resourceType: Option[String] = None,
      filters: Option[List[PatchOrchestratorFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowScheduleRequest =
      DescribeMaintenanceWindowScheduleRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowTargetsRequest(
      windowId: Option[String] = None,
      filters: Option[List[MaintenanceWindowFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowTargetsRequest =
      DescribeMaintenanceWindowTargetsRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowTasksRequest(
      windowId: Option[String] = None,
      filters: Option[List[MaintenanceWindowFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowTasksRequest =
      DescribeMaintenanceWindowTasksRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowsForTargetRequest(
      targets: Option[List[Target]] = None,
      resourceType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowsForTargetRequest =
      DescribeMaintenanceWindowsForTargetRequest
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMaintenanceWindowsRequest(
      filters: Option[List[MaintenanceWindowFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMaintenanceWindowsRequest =
      DescribeMaintenanceWindowsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOpsItemsRequest(
      opsItemFilters: Option[List[OpsItemFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeOpsItemsRequest =
      DescribeOpsItemsRequest
        .builder
        .ifSome(opsItemFilters)(_.opsItemFilters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeOpsItemsResponse(
      nextToken: Option[String] = None,
      opsItemSummaries: Option[List[OpsItemSummary]] = None
    ): DescribeOpsItemsResponse =
      DescribeOpsItemsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(opsItemSummaries)(_.opsItemSummaries(_))
        .build

    def describeParametersRequest(
      filters: Option[List[ParametersFilter]] = None,
      parameterFilters: Option[List[ParameterStringFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeParametersRequest =
      DescribeParametersRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(parameterFilters)(_.parameterFilters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePatchBaselinesRequest(
      filters: Option[List[PatchOrchestratorFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribePatchBaselinesRequest =
      DescribePatchBaselinesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePatchGroupStateRequest(
      patchGroup: Option[String] = None
    ): DescribePatchGroupStateRequest =
      DescribePatchGroupStateRequest
        .builder
        .ifSome(patchGroup)(_.patchGroup(_))
        .build

    def describePatchGroupsRequest(
      maxResults: Option[Int] = None,
      filters: Option[List[PatchOrchestratorFilter]] = None,
      nextToken: Option[String] = None
    ): DescribePatchGroupsRequest =
      DescribePatchGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePatchPropertiesRequest(
      operatingSystem: Option[String] = None,
      property: Option[String] = None,
      patchSet: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribePatchPropertiesRequest =
      DescribePatchPropertiesRequest
        .builder
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(property)(_.property(_))
        .ifSome(patchSet)(_.patchSet(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSessionsRequest(
      state: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[SessionFilter]] = None
    ): DescribeSessionsRequest =
      DescribeSessionsRequest
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeSessionsResponse(
      sessions: Option[List[Session]] = None,
      nextToken: Option[String] = None
    ): DescribeSessionsResponse =
      DescribeSessionsResponse
        .builder
        .ifSome(sessions)(_.sessions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disassociateOpsItemRelatedItemRequest(
      opsItemId: Option[String] = None,
      associationId: Option[String] = None
    ): DisassociateOpsItemRelatedItemRequest =
      DisassociateOpsItemRelatedItemRequest
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(associationId)(_.associationId(_))
        .build

    def disassociateOpsItemRelatedItemResponse(

    ): DisassociateOpsItemRelatedItemResponse =
      DisassociateOpsItemRelatedItemResponse
        .builder

        .build

    def documentAlreadyExists(
      message: Option[String] = None
    ): DocumentAlreadyExists =
      DocumentAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def documentDefaultVersionDescription(
      name: Option[String] = None,
      defaultVersion: Option[String] = None,
      defaultVersionName: Option[String] = None
    ): DocumentDefaultVersionDescription =
      DocumentDefaultVersionDescription
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .ifSome(defaultVersionName)(_.defaultVersionName(_))
        .build

    def documentDescription(
      sha1: Option[String] = None,
      hash: Option[String] = None,
      hashType: Option[String] = None,
      name: Option[String] = None,
      displayName: Option[String] = None,
      versionName: Option[String] = None,
      owner: Option[String] = None,
      createdDate: Option[DateTime] = None,
      status: Option[String] = None,
      statusInformation: Option[String] = None,
      documentVersion: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[List[DocumentParameter]] = None,
      platformTypes: Option[List[PlatformType]] = None,
      documentType: Option[String] = None,
      schemaVersion: Option[String] = None,
      latestVersion: Option[String] = None,
      defaultVersion: Option[String] = None,
      documentFormat: Option[String] = None,
      targetType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      attachmentsInformation: Option[List[AttachmentInformation]] = None,
      requires: Option[List[DocumentRequires]] = None,
      author: Option[String] = None,
      reviewInformation: Option[List[ReviewInformation]] = None,
      approvedVersion: Option[String] = None,
      pendingReviewVersion: Option[String] = None,
      reviewStatus: Option[String] = None
    ): DocumentDescription =
      DocumentDescription
        .builder
        .ifSome(sha1)(_.sha1(_))
        .ifSome(hash)(_.hash(_))
        .ifSome(hashType)(_.hashType(_))
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusInformation)(_.statusInformation(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(platformTypes)(_.platformTypes(_))
        .ifSome(documentType)(_.documentType(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .ifSome(documentFormat)(_.documentFormat(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(attachmentsInformation)(_.attachmentsInformation(_))
        .ifSome(requires)(_.requires(_))
        .ifSome(author)(_.author(_))
        .ifSome(reviewInformation)(_.reviewInformation(_))
        .ifSome(approvedVersion)(_.approvedVersion(_))
        .ifSome(pendingReviewVersion)(_.pendingReviewVersion(_))
        .ifSome(reviewStatus)(_.reviewStatus(_))
        .build

    def documentFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): DocumentFilter =
      DocumentFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def documentIdentifier(
      name: Option[String] = None,
      createdDate: Option[DateTime] = None,
      displayName: Option[String] = None,
      owner: Option[String] = None,
      versionName: Option[String] = None,
      platformTypes: Option[List[PlatformType]] = None,
      documentVersion: Option[String] = None,
      documentType: Option[String] = None,
      schemaVersion: Option[String] = None,
      documentFormat: Option[String] = None,
      targetType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      requires: Option[List[DocumentRequires]] = None,
      reviewStatus: Option[String] = None,
      author: Option[String] = None
    ): DocumentIdentifier =
      DocumentIdentifier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(platformTypes)(_.platformTypes(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(documentType)(_.documentType(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(documentFormat)(_.documentFormat(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(requires)(_.requires(_))
        .ifSome(reviewStatus)(_.reviewStatus(_))
        .ifSome(author)(_.author(_))
        .build

    def documentKeyValuesFilter(
      key: Option[String] = None,
      values: Option[List[DocumentKeyValuesFilterValue]] = None
    ): DocumentKeyValuesFilter =
      DocumentKeyValuesFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def documentLimitExceeded(
      message: Option[String] = None
    ): DocumentLimitExceeded =
      DocumentLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def documentMetadataResponseInfo(
      reviewerResponse: Option[List[DocumentReviewerResponseSource]] = None
    ): DocumentMetadataResponseInfo =
      DocumentMetadataResponseInfo
        .builder
        .ifSome(reviewerResponse)(_.reviewerResponse(_))
        .build

    def documentParameter(
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      defaultValue: Option[String] = None
    ): DocumentParameter =
      DocumentParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def documentPermissionLimit(
      message: Option[String] = None
    ): DocumentPermissionLimit =
      DocumentPermissionLimit
        .builder
        .ifSome(message)(_.message(_))
        .build

    def documentRequires(
      name: Option[String] = None,
      version: Option[String] = None
    ): DocumentRequires =
      DocumentRequires
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def documentReviewCommentSource(
      `type`: Option[String] = None,
      content: Option[String] = None
    ): DocumentReviewCommentSource =
      DocumentReviewCommentSource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(content)(_.content(_))
        .build

    def documentReviewerResponseSource(
      createTime: Option[DateTime] = None,
      updatedTime: Option[DateTime] = None,
      reviewStatus: Option[String] = None,
      comment: Option[List[DocumentReviewCommentSource]] = None,
      reviewer: Option[String] = None
    ): DocumentReviewerResponseSource =
      DocumentReviewerResponseSource
        .builder
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .ifSome(reviewStatus)(_.reviewStatus(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(reviewer)(_.reviewer(_))
        .build

    def documentReviews(
      action: Option[String] = None,
      comment: Option[List[DocumentReviewCommentSource]] = None
    ): DocumentReviews =
      DocumentReviews
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(comment)(_.comment(_))
        .build

    def documentVersionInfo(
      name: Option[String] = None,
      displayName: Option[String] = None,
      documentVersion: Option[String] = None,
      versionName: Option[String] = None,
      createdDate: Option[DateTime] = None,
      isDefaultVersion: Option[Boolean] = None,
      documentFormat: Option[String] = None,
      status: Option[String] = None,
      statusInformation: Option[String] = None,
      reviewStatus: Option[String] = None
    ): DocumentVersionInfo =
      DocumentVersionInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(documentFormat)(_.documentFormat(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusInformation)(_.statusInformation(_))
        .ifSome(reviewStatus)(_.reviewStatus(_))
        .build

    def documentVersionLimitExceeded(
      message: Option[String] = None
    ): DocumentVersionLimitExceeded =
      DocumentVersionLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def doesNotExistException(
      message: Option[String] = None
    ): DoesNotExistException =
      DoesNotExistException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateDocumentContent(
      message: Option[String] = None
    ): DuplicateDocumentContent =
      DuplicateDocumentContent
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateDocumentVersionName(
      message: Option[String] = None
    ): DuplicateDocumentVersionName =
      DuplicateDocumentVersionName
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateInstanceId(

    ): DuplicateInstanceId =
      DuplicateInstanceId
        .builder

        .build

    def effectivePatch(
      patch: Option[Patch] = None,
      patchStatus: Option[PatchStatus] = None
    ): EffectivePatch =
      EffectivePatch
        .builder
        .ifSome(patch)(_.patch(_))
        .ifSome(patchStatus)(_.patchStatus(_))
        .build

    def failedCreateAssociation(
      entry: Option[CreateAssociationBatchRequestEntry] = None,
      message: Option[String] = None,
      fault: Option[String] = None
    ): FailedCreateAssociation =
      FailedCreateAssociation
        .builder
        .ifSome(entry)(_.entry(_))
        .ifSome(message)(_.message(_))
        .ifSome(fault)(_.fault(_))
        .build

    def failureDetails(
      failureStage: Option[String] = None,
      failureType: Option[String] = None,
      details: Option[AutomationParameterMap] = None
    ): FailureDetails =
      FailureDetails
        .builder
        .ifSome(failureStage)(_.failureStage(_))
        .ifSome(failureType)(_.failureType(_))
        .ifSome(details)(_.details(_))
        .build

    def featureNotAvailableException(
      message: Option[String] = None
    ): FeatureNotAvailableException =
      FeatureNotAvailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getAutomationExecutionRequest(
      automationExecutionId: Option[String] = None
    ): GetAutomationExecutionRequest =
      GetAutomationExecutionRequest
        .builder
        .ifSome(automationExecutionId)(_.automationExecutionId(_))
        .build

    def getCalendarStateRequest(
      calendarNames: Option[List[CalendarNameOrARN]] = None,
      atTime: Option[String] = None
    ): GetCalendarStateRequest =
      GetCalendarStateRequest
        .builder
        .ifSome(calendarNames)(_.calendarNames(_))
        .ifSome(atTime)(_.atTime(_))
        .build

    def getCalendarStateResponse(
      state: Option[String] = None,
      atTime: Option[String] = None,
      nextTransitionTime: Option[String] = None
    ): GetCalendarStateResponse =
      GetCalendarStateResponse
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(atTime)(_.atTime(_))
        .ifSome(nextTransitionTime)(_.nextTransitionTime(_))
        .build

    def getCommandInvocationRequest(
      commandId: Option[String] = None,
      instanceId: Option[String] = None,
      pluginName: Option[String] = None
    ): GetCommandInvocationRequest =
      GetCommandInvocationRequest
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(pluginName)(_.pluginName(_))
        .build

    def getConnectionStatusRequest(
      target: Option[String] = None
    ): GetConnectionStatusRequest =
      GetConnectionStatusRequest
        .builder
        .ifSome(target)(_.target(_))
        .build

    def getConnectionStatusResponse(
      target: Option[String] = None,
      status: Option[String] = None
    ): GetConnectionStatusResponse =
      GetConnectionStatusResponse
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(status)(_.status(_))
        .build

    def getDefaultPatchBaselineRequest(
      operatingSystem: Option[String] = None
    ): GetDefaultPatchBaselineRequest =
      GetDefaultPatchBaselineRequest
        .builder
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .build

    def getDeployablePatchSnapshotForInstanceRequest(
      instanceId: Option[String] = None,
      snapshotId: Option[String] = None,
      baselineOverride: Option[BaselineOverride] = None
    ): GetDeployablePatchSnapshotForInstanceRequest =
      GetDeployablePatchSnapshotForInstanceRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(baselineOverride)(_.baselineOverride(_))
        .build

    def getDocumentRequest(
      name: Option[String] = None,
      versionName: Option[String] = None,
      documentVersion: Option[String] = None,
      documentFormat: Option[String] = None
    ): GetDocumentRequest =
      GetDocumentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(documentFormat)(_.documentFormat(_))
        .build

    def getInventoryRequest(
      filters: Option[List[InventoryFilter]] = None,
      aggregators: Option[List[InventoryAggregator]] = None,
      resultAttributes: Option[List[ResultAttribute]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetInventoryRequest =
      GetInventoryRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(aggregators)(_.aggregators(_))
        .ifSome(resultAttributes)(_.resultAttributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getInventorySchemaRequest(
      typeName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      aggregator: Option[Boolean] = None,
      subType: Option[Boolean] = None
    ): GetInventorySchemaRequest =
      GetInventorySchemaRequest
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(aggregator)(_.aggregator(_))
        .ifSome(subType)(_.subType(_))
        .build

    def getMaintenanceWindowExecutionRequest(
      windowExecutionId: Option[String] = None
    ): GetMaintenanceWindowExecutionRequest =
      GetMaintenanceWindowExecutionRequest
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .build

    def getMaintenanceWindowExecutionTaskInvocationRequest(
      windowExecutionId: Option[String] = None,
      taskId: Option[String] = None,
      invocationId: Option[String] = None
    ): GetMaintenanceWindowExecutionTaskInvocationRequest =
      GetMaintenanceWindowExecutionTaskInvocationRequest
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(taskId)(_.taskId(_))
        .ifSome(invocationId)(_.invocationId(_))
        .build

    def getMaintenanceWindowExecutionTaskRequest(
      windowExecutionId: Option[String] = None,
      taskId: Option[String] = None
    ): GetMaintenanceWindowExecutionTaskRequest =
      GetMaintenanceWindowExecutionTaskRequest
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(taskId)(_.taskId(_))
        .build

    def getMaintenanceWindowRequest(
      windowId: Option[String] = None
    ): GetMaintenanceWindowRequest =
      GetMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .build

    def getMaintenanceWindowTaskRequest(
      windowId: Option[String] = None,
      windowTaskId: Option[String] = None
    ): GetMaintenanceWindowTaskRequest =
      GetMaintenanceWindowTaskRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTaskId)(_.windowTaskId(_))
        .build

    def getOpsItemRequest(
      opsItemId: Option[String] = None
    ): GetOpsItemRequest =
      GetOpsItemRequest
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .build

    def getOpsItemResponse(
      opsItem: Option[OpsItem] = None
    ): GetOpsItemResponse =
      GetOpsItemResponse
        .builder
        .ifSome(opsItem)(_.opsItem(_))
        .build

    def getOpsMetadataRequest(
      opsMetadataArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetOpsMetadataRequest =
      GetOpsMetadataRequest
        .builder
        .ifSome(opsMetadataArn)(_.opsMetadataArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getOpsSummaryRequest(
      syncName: Option[String] = None,
      filters: Option[List[OpsFilter]] = None,
      aggregators: Option[List[OpsAggregator]] = None,
      resultAttributes: Option[List[OpsResultAttribute]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetOpsSummaryRequest =
      GetOpsSummaryRequest
        .builder
        .ifSome(syncName)(_.syncName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(aggregators)(_.aggregators(_))
        .ifSome(resultAttributes)(_.resultAttributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getParameterHistoryRequest(
      name: Option[String] = None,
      withDecryption: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetParameterHistoryRequest =
      GetParameterHistoryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(withDecryption)(_.withDecryption(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getParameterRequest(
      name: Option[String] = None,
      withDecryption: Option[Boolean] = None
    ): GetParameterRequest =
      GetParameterRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(withDecryption)(_.withDecryption(_))
        .build

    def getParametersByPathRequest(
      path: Option[String] = None,
      recursive: Option[Boolean] = None,
      parameterFilters: Option[List[ParameterStringFilter]] = None,
      withDecryption: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetParametersByPathRequest =
      GetParametersByPathRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(recursive)(_.recursive(_))
        .ifSome(parameterFilters)(_.parameterFilters(_))
        .ifSome(withDecryption)(_.withDecryption(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getParametersRequest(
      names: Option[List[PSParameterName]] = None,
      withDecryption: Option[Boolean] = None
    ): GetParametersRequest =
      GetParametersRequest
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(withDecryption)(_.withDecryption(_))
        .build

    def getPatchBaselineForPatchGroupRequest(
      patchGroup: Option[String] = None,
      operatingSystem: Option[String] = None
    ): GetPatchBaselineForPatchGroupRequest =
      GetPatchBaselineForPatchGroupRequest
        .builder
        .ifSome(patchGroup)(_.patchGroup(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .build

    def getPatchBaselineRequest(
      baselineId: Option[String] = None
    ): GetPatchBaselineRequest =
      GetPatchBaselineRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .build

    def getServiceSettingRequest(
      settingId: Option[String] = None
    ): GetServiceSettingRequest =
      GetServiceSettingRequest
        .builder
        .ifSome(settingId)(_.settingId(_))
        .build

    def hierarchyLevelLimitExceededException(
      message: Option[String] = None
    ): HierarchyLevelLimitExceededException =
      HierarchyLevelLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hierarchyTypeMismatchException(
      message: Option[String] = None
    ): HierarchyTypeMismatchException =
      HierarchyTypeMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def idempotentParameterMismatch(
      message: Option[String] = None
    ): IdempotentParameterMismatch =
      IdempotentParameterMismatch
        .builder
        .ifSome(message)(_.message(_))
        .build

    def incompatiblePolicyException(
      message: Option[String] = None
    ): IncompatiblePolicyException =
      IncompatiblePolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def instanceAggregatedAssociationOverview(
      detailedStatus: Option[String] = None,
      instanceAssociationStatusAggregatedCount: Option[InstanceAssociationStatusAggregatedCount] = None
    ): InstanceAggregatedAssociationOverview =
      InstanceAggregatedAssociationOverview
        .builder
        .ifSome(detailedStatus)(_.detailedStatus(_))
        .ifSome(instanceAssociationStatusAggregatedCount)(_.instanceAssociationStatusAggregatedCount(_))
        .build

    def instanceAssociation(
      associationId: Option[String] = None,
      instanceId: Option[String] = None,
      content: Option[String] = None,
      associationVersion: Option[String] = None
    ): InstanceAssociation =
      InstanceAssociation
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(content)(_.content(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .build

    def instanceAssociationOutputLocation(
      s3Location: Option[S3OutputLocation] = None
    ): InstanceAssociationOutputLocation =
      InstanceAssociationOutputLocation
        .builder
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def instanceAssociationOutputUrl(
      s3OutputUrl: Option[S3OutputUrl] = None
    ): InstanceAssociationOutputUrl =
      InstanceAssociationOutputUrl
        .builder
        .ifSome(s3OutputUrl)(_.s3OutputUrl(_))
        .build

    def instanceAssociationStatusInfo(
      associationId: Option[String] = None,
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      associationVersion: Option[String] = None,
      instanceId: Option[String] = None,
      executionDate: Option[DateTime] = None,
      status: Option[String] = None,
      detailedStatus: Option[String] = None,
      executionSummary: Option[String] = None,
      errorCode: Option[String] = None,
      outputUrl: Option[InstanceAssociationOutputUrl] = None,
      associationName: Option[String] = None
    ): InstanceAssociationStatusInfo =
      InstanceAssociationStatusInfo
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(executionDate)(_.executionDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(detailedStatus)(_.detailedStatus(_))
        .ifSome(executionSummary)(_.executionSummary(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(outputUrl)(_.outputUrl(_))
        .ifSome(associationName)(_.associationName(_))
        .build

    def instanceInformation(
      instanceId: Option[String] = None,
      pingStatus: Option[String] = None,
      lastPingDateTime: Option[DateTime] = None,
      agentVersion: Option[String] = None,
      isLatestVersion: Option[Boolean] = None,
      platformType: Option[String] = None,
      platformName: Option[String] = None,
      platformVersion: Option[String] = None,
      activationId: Option[String] = None,
      iamRole: Option[String] = None,
      registrationDate: Option[DateTime] = None,
      resourceType: Option[String] = None,
      name: Option[String] = None,
      iPAddress: Option[String] = None,
      computerName: Option[String] = None,
      associationStatus: Option[String] = None,
      lastAssociationExecutionDate: Option[DateTime] = None,
      lastSuccessfulAssociationExecutionDate: Option[DateTime] = None,
      associationOverview: Option[InstanceAggregatedAssociationOverview] = None
    ): InstanceInformation =
      InstanceInformation
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(pingStatus)(_.pingStatus(_))
        .ifSome(lastPingDateTime)(_.lastPingDateTime(_))
        .ifSome(agentVersion)(_.agentVersion(_))
        .ifSome(isLatestVersion)(_.isLatestVersion(_))
        .ifSome(platformType)(_.platformType(_))
        .ifSome(platformName)(_.platformName(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(activationId)(_.activationId(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(registrationDate)(_.registrationDate(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(name)(_.name(_))
        .ifSome(iPAddress)(_.iPAddress(_))
        .ifSome(computerName)(_.computerName(_))
        .ifSome(associationStatus)(_.associationStatus(_))
        .ifSome(lastAssociationExecutionDate)(_.lastAssociationExecutionDate(_))
        .ifSome(lastSuccessfulAssociationExecutionDate)(_.lastSuccessfulAssociationExecutionDate(_))
        .ifSome(associationOverview)(_.associationOverview(_))
        .build

    def instanceInformationFilter(
      key: Option[String] = None,
      valueSet: Option[List[InstanceInformationFilterValue]] = None
    ): InstanceInformationFilter =
      InstanceInformationFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(valueSet)(_.valueSet(_))
        .build

    def instanceInformationStringFilter(
      key: Option[String] = None,
      values: Option[List[InstanceInformationFilterValue]] = None
    ): InstanceInformationStringFilter =
      InstanceInformationStringFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def instancePatchState(
      instanceId: Option[String] = None,
      patchGroup: Option[String] = None,
      baselineId: Option[String] = None,
      snapshotId: Option[String] = None,
      installOverrideList: Option[String] = None,
      ownerInformation: Option[String] = None,
      installedCount: Option[Int] = None,
      installedOtherCount: Option[Int] = None,
      installedPendingRebootCount: Option[Int] = None,
      installedRejectedCount: Option[Int] = None,
      missingCount: Option[Int] = None,
      failedCount: Option[Int] = None,
      unreportedNotApplicableCount: Option[Int] = None,
      notApplicableCount: Option[Int] = None,
      operationStartTime: Option[DateTime] = None,
      operationEndTime: Option[DateTime] = None,
      operation: Option[String] = None,
      lastNoRebootInstallOperationTime: Option[DateTime] = None,
      rebootOption: Option[String] = None,
      criticalNonCompliantCount: Option[Int] = None,
      securityNonCompliantCount: Option[Int] = None,
      otherNonCompliantCount: Option[Int] = None
    ): InstancePatchState =
      InstancePatchState
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(patchGroup)(_.patchGroup(_))
        .ifSome(baselineId)(_.baselineId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(installOverrideList)(_.installOverrideList(_))
        .ifSome(ownerInformation)(_.ownerInformation(_))
        .ifSome(installedCount)(_.installedCount(_))
        .ifSome(installedOtherCount)(_.installedOtherCount(_))
        .ifSome(installedPendingRebootCount)(_.installedPendingRebootCount(_))
        .ifSome(installedRejectedCount)(_.installedRejectedCount(_))
        .ifSome(missingCount)(_.missingCount(_))
        .ifSome(failedCount)(_.failedCount(_))
        .ifSome(unreportedNotApplicableCount)(_.unreportedNotApplicableCount(_))
        .ifSome(notApplicableCount)(_.notApplicableCount(_))
        .ifSome(operationStartTime)(_.operationStartTime(_))
        .ifSome(operationEndTime)(_.operationEndTime(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(lastNoRebootInstallOperationTime)(_.lastNoRebootInstallOperationTime(_))
        .ifSome(rebootOption)(_.rebootOption(_))
        .ifSome(criticalNonCompliantCount)(_.criticalNonCompliantCount(_))
        .ifSome(securityNonCompliantCount)(_.securityNonCompliantCount(_))
        .ifSome(otherNonCompliantCount)(_.otherNonCompliantCount(_))
        .build

    def instancePatchStateFilter(
      key: Option[String] = None,
      values: Option[List[InstancePatchStateFilterValue]] = None,
      `type`: Option[String] = None
    ): InstancePatchStateFilter =
      InstancePatchStateFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidActivation(
      message: Option[String] = None
    ): InvalidActivation =
      InvalidActivation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidActivationId(
      message: Option[String] = None
    ): InvalidActivationId =
      InvalidActivationId
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAggregatorException(
      message: Option[String] = None
    ): InvalidAggregatorException =
      InvalidAggregatorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAllowedPatternException(
      message: Option[String] = None
    ): InvalidAllowedPatternException =
      InvalidAllowedPatternException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAssociation(
      message: Option[String] = None
    ): InvalidAssociation =
      InvalidAssociation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAssociationVersion(
      message: Option[String] = None
    ): InvalidAssociationVersion =
      InvalidAssociationVersion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAutomationExecutionParametersException(
      message: Option[String] = None
    ): InvalidAutomationExecutionParametersException =
      InvalidAutomationExecutionParametersException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAutomationSignalException(
      message: Option[String] = None
    ): InvalidAutomationSignalException =
      InvalidAutomationSignalException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAutomationStatusUpdateException(
      message: Option[String] = None
    ): InvalidAutomationStatusUpdateException =
      InvalidAutomationStatusUpdateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCommandId(

    ): InvalidCommandId =
      InvalidCommandId
        .builder

        .build

    def invalidDeleteInventoryParametersException(
      message: Option[String] = None
    ): InvalidDeleteInventoryParametersException =
      InvalidDeleteInventoryParametersException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDeletionIdException(
      message: Option[String] = None
    ): InvalidDeletionIdException =
      InvalidDeletionIdException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDocument(
      message: Option[String] = None
    ): InvalidDocument =
      InvalidDocument
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDocumentContent(
      message: Option[String] = None
    ): InvalidDocumentContent =
      InvalidDocumentContent
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDocumentOperation(
      message: Option[String] = None
    ): InvalidDocumentOperation =
      InvalidDocumentOperation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDocumentSchemaVersion(
      message: Option[String] = None
    ): InvalidDocumentSchemaVersion =
      InvalidDocumentSchemaVersion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDocumentType(
      message: Option[String] = None
    ): InvalidDocumentType =
      InvalidDocumentType
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDocumentVersion(
      message: Option[String] = None
    ): InvalidDocumentVersion =
      InvalidDocumentVersion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFilter(
      message: Option[String] = None
    ): InvalidFilter =
      InvalidFilter
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFilterKey(

    ): InvalidFilterKey =
      InvalidFilterKey
        .builder

        .build

    def invalidFilterOption(
      message: Option[String] = None
    ): InvalidFilterOption =
      InvalidFilterOption
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFilterValue(
      message: Option[String] = None
    ): InvalidFilterValue =
      InvalidFilterValue
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInstanceId(
      message: Option[String] = None
    ): InvalidInstanceId =
      InvalidInstanceId
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInstanceInformationFilterValue(
      message: Option[String] = None
    ): InvalidInstanceInformationFilterValue =
      InvalidInstanceInformationFilterValue
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInventoryGroupException(
      message: Option[String] = None
    ): InvalidInventoryGroupException =
      InvalidInventoryGroupException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInventoryItemContextException(
      message: Option[String] = None
    ): InvalidInventoryItemContextException =
      InvalidInventoryItemContextException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInventoryRequestException(
      message: Option[String] = None
    ): InvalidInventoryRequestException =
      InvalidInventoryRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidItemContentException(
      typeName: Option[String] = None,
      message: Option[String] = None
    ): InvalidItemContentException =
      InvalidItemContentException
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidKeyId(
      message: Option[String] = None
    ): InvalidKeyId =
      InvalidKeyId
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextToken(
      message: Option[String] = None
    ): InvalidNextToken =
      InvalidNextToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNotificationConfig(
      message: Option[String] = None
    ): InvalidNotificationConfig =
      InvalidNotificationConfig
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOptionException(
      message: Option[String] = None
    ): InvalidOptionException =
      InvalidOptionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOutputFolder(

    ): InvalidOutputFolder =
      InvalidOutputFolder
        .builder

        .build

    def invalidOutputLocation(

    ): InvalidOutputLocation =
      InvalidOutputLocation
        .builder

        .build

    def invalidParameters(
      message: Option[String] = None
    ): InvalidParameters =
      InvalidParameters
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPermissionType(
      message: Option[String] = None
    ): InvalidPermissionType =
      InvalidPermissionType
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPluginName(

    ): InvalidPluginName =
      InvalidPluginName
        .builder

        .build

    def invalidPolicyAttributeException(
      message: Option[String] = None
    ): InvalidPolicyAttributeException =
      InvalidPolicyAttributeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPolicyTypeException(
      message: Option[String] = None
    ): InvalidPolicyTypeException =
      InvalidPolicyTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResourceId(

    ): InvalidResourceId =
      InvalidResourceId
        .builder

        .build

    def invalidResourceType(

    ): InvalidResourceType =
      InvalidResourceType
        .builder

        .build

    def invalidResultAttributeException(
      message: Option[String] = None
    ): InvalidResultAttributeException =
      InvalidResultAttributeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRole(
      message: Option[String] = None
    ): InvalidRole =
      InvalidRole
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSchedule(
      message: Option[String] = None
    ): InvalidSchedule =
      InvalidSchedule
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTarget(
      message: Option[String] = None
    ): InvalidTarget =
      InvalidTarget
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTypeNameException(
      message: Option[String] = None
    ): InvalidTypeNameException =
      InvalidTypeNameException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidUpdate(
      message: Option[String] = None
    ): InvalidUpdate =
      InvalidUpdate
        .builder
        .ifSome(message)(_.message(_))
        .build

    def inventoryAggregator(
      expression: Option[String] = None,
      aggregators: Option[List[InventoryAggregator]] = None,
      groups: Option[List[InventoryGroup]] = None
    ): InventoryAggregator =
      InventoryAggregator
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(aggregators)(_.aggregators(_))
        .ifSome(groups)(_.groups(_))
        .build

    def inventoryDeletionStatusItem(
      deletionId: Option[String] = None,
      typeName: Option[String] = None,
      deletionStartTime: Option[InventoryDeletionStartTime] = None,
      lastStatus: Option[String] = None,
      lastStatusMessage: Option[String] = None,
      deletionSummary: Option[InventoryDeletionSummary] = None,
      lastStatusUpdateTime: Option[InventoryDeletionLastStatusUpdateTime] = None
    ): InventoryDeletionStatusItem =
      InventoryDeletionStatusItem
        .builder
        .ifSome(deletionId)(_.deletionId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(deletionStartTime)(_.deletionStartTime(_))
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(lastStatusMessage)(_.lastStatusMessage(_))
        .ifSome(deletionSummary)(_.deletionSummary(_))
        .ifSome(lastStatusUpdateTime)(_.lastStatusUpdateTime(_))
        .build

    def inventoryDeletionSummary(
      totalCount: Option[Int] = None,
      remainingCount: Option[Int] = None,
      summaryItems: Option[List[InventoryDeletionSummaryItem]] = None
    ): InventoryDeletionSummary =
      InventoryDeletionSummary
        .builder
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(remainingCount)(_.remainingCount(_))
        .ifSome(summaryItems)(_.summaryItems(_))
        .build

    def inventoryDeletionSummaryItem(
      version: Option[String] = None,
      count: Option[Int] = None,
      remainingCount: Option[Int] = None
    ): InventoryDeletionSummaryItem =
      InventoryDeletionSummaryItem
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(count)(_.count(_))
        .ifSome(remainingCount)(_.remainingCount(_))
        .build

    def inventoryFilter(
      key: Option[String] = None,
      values: Option[List[InventoryFilterValue]] = None,
      `type`: Option[String] = None
    ): InventoryFilter =
      InventoryFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def inventoryGroup(
      name: Option[String] = None,
      filters: Option[List[InventoryFilter]] = None
    ): InventoryGroup =
      InventoryGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(filters)(_.filters(_))
        .build

    def inventoryItem(
      typeName: Option[String] = None,
      schemaVersion: Option[String] = None,
      captureTime: Option[String] = None,
      contentHash: Option[String] = None,
      content: Option[List[InventoryItemEntry]] = None,
      context: Option[InventoryItemContentContext] = None
    ): InventoryItem =
      InventoryItem
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(captureTime)(_.captureTime(_))
        .ifSome(contentHash)(_.contentHash(_))
        .ifSome(content)(_.content(_))
        .ifSome(context)(_.context(_))
        .build

    def inventoryItemAttribute(
      name: Option[String] = None,
      dataType: Option[String] = None
    ): InventoryItemAttribute =
      InventoryItemAttribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def inventoryItemSchema(
      typeName: Option[String] = None,
      version: Option[String] = None,
      attributes: Option[List[InventoryItemAttribute]] = None,
      displayName: Option[String] = None
    ): InventoryItemSchema =
      InventoryItemSchema
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(version)(_.version(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def inventoryResultEntity(
      id: Option[String] = None,
      data: Option[InventoryResultItemMap] = None
    ): InventoryResultEntity =
      InventoryResultEntity
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(data)(_.data(_))
        .build

    def inventoryResultItem(
      typeName: Option[String] = None,
      schemaVersion: Option[String] = None,
      captureTime: Option[String] = None,
      contentHash: Option[String] = None,
      content: Option[List[InventoryItemEntry]] = None
    ): InventoryResultItem =
      InventoryResultItem
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(schemaVersion)(_.schemaVersion(_))
        .ifSome(captureTime)(_.captureTime(_))
        .ifSome(contentHash)(_.contentHash(_))
        .ifSome(content)(_.content(_))
        .build

    def invocationDoesNotExist(

    ): InvocationDoesNotExist =
      InvocationDoesNotExist
        .builder

        .build

    def itemContentMismatchException(
      typeName: Option[String] = None,
      message: Option[String] = None
    ): ItemContentMismatchException =
      ItemContentMismatchException
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(message)(_.message(_))
        .build

    def itemSizeLimitExceededException(
      typeName: Option[String] = None,
      message: Option[String] = None
    ): ItemSizeLimitExceededException =
      ItemSizeLimitExceededException
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(message)(_.message(_))
        .build

    def labelParameterVersionRequest(
      name: Option[String] = None,
      parameterVersion: Option[PSParameterVersion] = None,
      labels: Option[List[ParameterLabel]] = None
    ): LabelParameterVersionRequest =
      LabelParameterVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(parameterVersion)(_.parameterVersion(_))
        .ifSome(labels)(_.labels(_))
        .build

    def listAssociationVersionsRequest(
      associationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAssociationVersionsRequest =
      ListAssociationVersionsRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociationsRequest(
      associationFilterList: Option[List[AssociationFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAssociationsRequest =
      ListAssociationsRequest
        .builder
        .ifSome(associationFilterList)(_.associationFilterList(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCommandInvocationsRequest(
      commandId: Option[String] = None,
      instanceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[CommandFilter]] = None,
      details: Option[Boolean] = None
    ): ListCommandInvocationsRequest =
      ListCommandInvocationsRequest
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(details)(_.details(_))
        .build

    def listCommandsRequest(
      commandId: Option[String] = None,
      instanceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[CommandFilter]] = None
    ): ListCommandsRequest =
      ListCommandsRequest
        .builder
        .ifSome(commandId)(_.commandId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listComplianceItemsRequest(
      filters: Option[List[ComplianceStringFilter]] = None,
      resourceIds: Option[List[ComplianceResourceId]] = None,
      resourceTypes: Option[List[ComplianceResourceType]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListComplianceItemsRequest =
      ListComplianceItemsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(resourceIds)(_.resourceIds(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listComplianceSummariesRequest(
      filters: Option[List[ComplianceStringFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListComplianceSummariesRequest =
      ListComplianceSummariesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDocumentMetadataHistoryRequest(
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      metadata: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDocumentMetadataHistoryRequest =
      ListDocumentMetadataHistoryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDocumentMetadataHistoryResponse(
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      author: Option[String] = None,
      metadata: Option[DocumentMetadataResponseInfo] = None,
      nextToken: Option[String] = None
    ): ListDocumentMetadataHistoryResponse =
      ListDocumentMetadataHistoryResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(author)(_.author(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDocumentVersionsRequest(
      name: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDocumentVersionsRequest =
      ListDocumentVersionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDocumentsRequest(
      documentFilterList: Option[List[DocumentFilter]] = None,
      filters: Option[List[DocumentKeyValuesFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDocumentsRequest =
      ListDocumentsRequest
        .builder
        .ifSome(documentFilterList)(_.documentFilterList(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInventoryEntriesRequest(
      instanceId: Option[String] = None,
      typeName: Option[String] = None,
      filters: Option[List[InventoryFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInventoryEntriesRequest =
      ListInventoryEntriesRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listOpsItemEventsRequest(
      filters: Option[List[OpsItemEventFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOpsItemEventsRequest =
      ListOpsItemEventsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOpsItemEventsResponse(
      nextToken: Option[String] = None,
      summaries: Option[List[OpsItemEventSummary]] = None
    ): ListOpsItemEventsResponse =
      ListOpsItemEventsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(summaries)(_.summaries(_))
        .build

    def listOpsItemRelatedItemsRequest(
      opsItemId: Option[String] = None,
      filters: Option[List[OpsItemRelatedItemsFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOpsItemRelatedItemsRequest =
      ListOpsItemRelatedItemsRequest
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOpsItemRelatedItemsResponse(
      nextToken: Option[String] = None,
      summaries: Option[List[OpsItemRelatedItemSummary]] = None
    ): ListOpsItemRelatedItemsResponse =
      ListOpsItemRelatedItemsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(summaries)(_.summaries(_))
        .build

    def listOpsMetadataRequest(
      filters: Option[List[OpsMetadataFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOpsMetadataRequest =
      ListOpsMetadataRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceComplianceSummariesRequest(
      filters: Option[List[ComplianceStringFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourceComplianceSummariesRequest =
      ListResourceComplianceSummariesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourceDataSyncRequest(
      syncType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourceDataSyncRequest =
      ListResourceDataSyncRequest
        .builder
        .ifSome(syncType)(_.syncType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def loggingInfo(
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      s3Region: Option[String] = None
    ): LoggingInfo =
      LoggingInfo
        .builder
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(s3Region)(_.s3Region(_))
        .build

    def maintenanceWindowAutomationParameters(
      documentVersion: Option[String] = None,
      parameters: Option[AutomationParameterMap] = None
    ): MaintenanceWindowAutomationParameters =
      MaintenanceWindowAutomationParameters
        .builder
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def maintenanceWindowExecution(
      windowId: Option[String] = None,
      windowExecutionId: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      startTime: Option[DateTime] = None,
      endTime: Option[DateTime] = None
    ): MaintenanceWindowExecution =
      MaintenanceWindowExecution
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def maintenanceWindowExecutionTaskIdentity(
      windowExecutionId: Option[String] = None,
      taskExecutionId: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      startTime: Option[DateTime] = None,
      endTime: Option[DateTime] = None,
      taskArn: Option[String] = None,
      taskType: Option[String] = None
    ): MaintenanceWindowExecutionTaskIdentity =
      MaintenanceWindowExecutionTaskIdentity
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(taskExecutionId)(_.taskExecutionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(taskType)(_.taskType(_))
        .build

    def maintenanceWindowExecutionTaskInvocationIdentity(
      windowExecutionId: Option[String] = None,
      taskExecutionId: Option[String] = None,
      invocationId: Option[String] = None,
      executionId: Option[String] = None,
      taskType: Option[String] = None,
      parameters: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[String] = None,
      startTime: Option[DateTime] = None,
      endTime: Option[DateTime] = None,
      ownerInformation: Option[String] = None,
      windowTargetId: Option[String] = None
    ): MaintenanceWindowExecutionTaskInvocationIdentity =
      MaintenanceWindowExecutionTaskInvocationIdentity
        .builder
        .ifSome(windowExecutionId)(_.windowExecutionId(_))
        .ifSome(taskExecutionId)(_.taskExecutionId(_))
        .ifSome(invocationId)(_.invocationId(_))
        .ifSome(executionId)(_.executionId(_))
        .ifSome(taskType)(_.taskType(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(ownerInformation)(_.ownerInformation(_))
        .ifSome(windowTargetId)(_.windowTargetId(_))
        .build

    def maintenanceWindowFilter(
      key: Option[String] = None,
      values: Option[List[MaintenanceWindowFilterValue]] = None
    ): MaintenanceWindowFilter =
      MaintenanceWindowFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def maintenanceWindowIdentity(
      windowId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      enabled: Option[Boolean] = None,
      duration: Option[Int] = None,
      cutoff: Option[Int] = None,
      schedule: Option[String] = None,
      scheduleTimezone: Option[String] = None,
      scheduleOffset: Option[Int] = None,
      endDate: Option[String] = None,
      startDate: Option[String] = None,
      nextExecutionTime: Option[String] = None
    ): MaintenanceWindowIdentity =
      MaintenanceWindowIdentity
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(cutoff)(_.cutoff(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(scheduleTimezone)(_.scheduleTimezone(_))
        .ifSome(scheduleOffset)(_.scheduleOffset(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(nextExecutionTime)(_.nextExecutionTime(_))
        .build

    def maintenanceWindowIdentityForTarget(
      windowId: Option[String] = None,
      name: Option[String] = None
    ): MaintenanceWindowIdentityForTarget =
      MaintenanceWindowIdentityForTarget
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(name)(_.name(_))
        .build

    def maintenanceWindowLambdaParameters(
      clientContext: Option[String] = None,
      qualifier: Option[String] = None,
      payload: Option[MaintenanceWindowLambdaPayload] = None
    ): MaintenanceWindowLambdaParameters =
      MaintenanceWindowLambdaParameters
        .builder
        .ifSome(clientContext)(_.clientContext(_))
        .ifSome(qualifier)(_.qualifier(_))
        .ifSome(payload)(_.payload(_))
        .build

    def maintenanceWindowRunCommandParameters(
      comment: Option[String] = None,
      cloudWatchOutputConfig: Option[CloudWatchOutputConfig] = None,
      documentHash: Option[String] = None,
      documentHashType: Option[String] = None,
      documentVersion: Option[String] = None,
      notificationConfig: Option[NotificationConfig] = None,
      outputS3BucketName: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None,
      parameters: Option[Parameters] = None,
      serviceRoleArn: Option[String] = None,
      timeoutSeconds: Option[Int] = None
    ): MaintenanceWindowRunCommandParameters =
      MaintenanceWindowRunCommandParameters
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(cloudWatchOutputConfig)(_.cloudWatchOutputConfig(_))
        .ifSome(documentHash)(_.documentHash(_))
        .ifSome(documentHashType)(_.documentHashType(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(notificationConfig)(_.notificationConfig(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(timeoutSeconds)(_.timeoutSeconds(_))
        .build

    def maintenanceWindowStepFunctionsParameters(
      input: Option[String] = None,
      name: Option[String] = None
    ): MaintenanceWindowStepFunctionsParameters =
      MaintenanceWindowStepFunctionsParameters
        .builder
        .ifSome(input)(_.input(_))
        .ifSome(name)(_.name(_))
        .build

    def maintenanceWindowTarget(
      windowId: Option[String] = None,
      windowTargetId: Option[String] = None,
      resourceType: Option[String] = None,
      targets: Option[List[Target]] = None,
      ownerInformation: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): MaintenanceWindowTarget =
      MaintenanceWindowTarget
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTargetId)(_.windowTargetId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(ownerInformation)(_.ownerInformation(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def maintenanceWindowTask(
      windowId: Option[String] = None,
      windowTaskId: Option[String] = None,
      taskArn: Option[String] = None,
      `type`: Option[String] = None,
      targets: Option[List[Target]] = None,
      taskParameters: Option[MaintenanceWindowTaskParameters] = None,
      priority: Option[Int] = None,
      loggingInfo: Option[LoggingInfo] = None,
      serviceRoleArn: Option[String] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): MaintenanceWindowTask =
      MaintenanceWindowTask
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTaskId)(_.windowTaskId(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(taskParameters)(_.taskParameters(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def maintenanceWindowTaskInvocationParameters(
      runCommand: Option[MaintenanceWindowRunCommandParameters] = None,
      automation: Option[MaintenanceWindowAutomationParameters] = None,
      stepFunctions: Option[MaintenanceWindowStepFunctionsParameters] = None,
      lambda: Option[MaintenanceWindowLambdaParameters] = None
    ): MaintenanceWindowTaskInvocationParameters =
      MaintenanceWindowTaskInvocationParameters
        .builder
        .ifSome(runCommand)(_.runCommand(_))
        .ifSome(automation)(_.automation(_))
        .ifSome(stepFunctions)(_.stepFunctions(_))
        .ifSome(lambda)(_.lambda(_))
        .build

    def maintenanceWindowTaskParameterValueExpression(
      values: Option[List[MaintenanceWindowTaskParameterValue]] = None
    ): MaintenanceWindowTaskParameterValueExpression =
      MaintenanceWindowTaskParameterValueExpression
        .builder
        .ifSome(values)(_.values(_))
        .build

    def maxDocumentSizeExceeded(
      message: Option[String] = None
    ): MaxDocumentSizeExceeded =
      MaxDocumentSizeExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def metadataValue(
      value: Option[String] = None
    ): MetadataValue =
      MetadataValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def modifyDocumentPermissionRequest(
      name: Option[String] = None,
      permissionType: Option[String] = None,
      accountIdsToAdd: Option[List[AccountId]] = None,
      accountIdsToRemove: Option[List[AccountId]] = None,
      sharedDocumentVersion: Option[String] = None
    ): ModifyDocumentPermissionRequest =
      ModifyDocumentPermissionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(permissionType)(_.permissionType(_))
        .ifSome(accountIdsToAdd)(_.accountIdsToAdd(_))
        .ifSome(accountIdsToRemove)(_.accountIdsToRemove(_))
        .ifSome(sharedDocumentVersion)(_.sharedDocumentVersion(_))
        .build

    def modifyDocumentPermissionResponse(

    ): ModifyDocumentPermissionResponse =
      ModifyDocumentPermissionResponse
        .builder

        .build

    def nonCompliantSummary(
      nonCompliantCount: Option[Int] = None,
      severitySummary: Option[SeveritySummary] = None
    ): NonCompliantSummary =
      NonCompliantSummary
        .builder
        .ifSome(nonCompliantCount)(_.nonCompliantCount(_))
        .ifSome(severitySummary)(_.severitySummary(_))
        .build

    def notificationConfig(
      notificationArn: Option[String] = None,
      notificationEvents: Option[List[NotificationEvent]] = None,
      notificationType: Option[String] = None
    ): NotificationConfig =
      NotificationConfig
        .builder
        .ifSome(notificationArn)(_.notificationArn(_))
        .ifSome(notificationEvents)(_.notificationEvents(_))
        .ifSome(notificationType)(_.notificationType(_))
        .build

    def opsAggregator(
      aggregatorType: Option[String] = None,
      typeName: Option[String] = None,
      attributeName: Option[String] = None,
      values: Option[OpsAggregatorValueMap] = None,
      filters: Option[List[OpsFilter]] = None,
      aggregators: Option[List[OpsAggregator]] = None
    ): OpsAggregator =
      OpsAggregator
        .builder
        .ifSome(aggregatorType)(_.aggregatorType(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(values)(_.values(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(aggregators)(_.aggregators(_))
        .build

    def opsEntity(
      id: Option[String] = None,
      data: Option[OpsEntityItemMap] = None
    ): OpsEntity =
      OpsEntity
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(data)(_.data(_))
        .build

    def opsEntityItem(
      captureTime: Option[String] = None,
      content: Option[List[OpsEntityItemEntry]] = None
    ): OpsEntityItem =
      OpsEntityItem
        .builder
        .ifSome(captureTime)(_.captureTime(_))
        .ifSome(content)(_.content(_))
        .build

    def opsFilter(
      key: Option[String] = None,
      values: Option[List[OpsFilterValue]] = None,
      `type`: Option[String] = None
    ): OpsFilter =
      OpsFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def opsItem(
      createdBy: Option[String] = None,
      opsItemType: Option[String] = None,
      createdTime: Option[DateTime] = None,
      description: Option[String] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      notifications: Option[List[OpsItemNotification]] = None,
      priority: Option[Int] = None,
      relatedOpsItems: Option[List[RelatedOpsItem]] = None,
      status: Option[String] = None,
      opsItemId: Option[String] = None,
      version: Option[String] = None,
      title: Option[String] = None,
      source: Option[String] = None,
      operationalData: Option[OpsItemOperationalData] = None,
      category: Option[String] = None,
      severity: Option[String] = None,
      actualStartTime: Option[DateTime] = None,
      actualEndTime: Option[DateTime] = None,
      plannedStartTime: Option[DateTime] = None,
      plannedEndTime: Option[DateTime] = None
    ): OpsItem =
      OpsItem
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(opsItemType)(_.opsItemType(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(relatedOpsItems)(_.relatedOpsItems(_))
        .ifSome(status)(_.status(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(version)(_.version(_))
        .ifSome(title)(_.title(_))
        .ifSome(source)(_.source(_))
        .ifSome(operationalData)(_.operationalData(_))
        .ifSome(category)(_.category(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(actualStartTime)(_.actualStartTime(_))
        .ifSome(actualEndTime)(_.actualEndTime(_))
        .ifSome(plannedStartTime)(_.plannedStartTime(_))
        .ifSome(plannedEndTime)(_.plannedEndTime(_))
        .build

    def opsItemAlreadyExistsException(
      message: Option[String] = None,
      opsItemId: Option[String] = None
    ): OpsItemAlreadyExistsException =
      OpsItemAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .build

    def opsItemDataValue(
      value: Option[String] = None,
      `type`: Option[String] = None
    ): OpsItemDataValue =
      OpsItemDataValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def opsItemEventFilter(
      key: Option[String] = None,
      values: Option[List[OpsItemEventFilterValue]] = None,
      operator: Option[String] = None
    ): OpsItemEventFilter =
      OpsItemEventFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def opsItemEventSummary(
      opsItemId: Option[String] = None,
      eventId: Option[String] = None,
      source: Option[String] = None,
      detailType: Option[String] = None,
      detail: Option[String] = None,
      createdBy: Option[OpsItemIdentity] = None,
      createdTime: Option[DateTime] = None
    ): OpsItemEventSummary =
      OpsItemEventSummary
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(source)(_.source(_))
        .ifSome(detailType)(_.detailType(_))
        .ifSome(detail)(_.detail(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def opsItemFilter(
      key: Option[String] = None,
      values: Option[List[OpsItemFilterValue]] = None,
      operator: Option[String] = None
    ): OpsItemFilter =
      OpsItemFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def opsItemIdentity(
      arn: Option[String] = None
    ): OpsItemIdentity =
      OpsItemIdentity
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def opsItemInvalidParameterException(
      parameterNames: Option[List[String]] = None,
      message: Option[String] = None
    ): OpsItemInvalidParameterException =
      OpsItemInvalidParameterException
        .builder
        .ifSome(parameterNames)(_.parameterNames(_))
        .ifSome(message)(_.message(_))
        .build

    def opsItemLimitExceededException(
      resourceTypes: Option[List[String]] = None,
      limit: Option[Int] = None,
      limitType: Option[String] = None,
      message: Option[String] = None
    ): OpsItemLimitExceededException =
      OpsItemLimitExceededException
        .builder
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(limitType)(_.limitType(_))
        .ifSome(message)(_.message(_))
        .build

    def opsItemNotFoundException(
      message: Option[String] = None
    ): OpsItemNotFoundException =
      OpsItemNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsItemNotification(
      arn: Option[String] = None
    ): OpsItemNotification =
      OpsItemNotification
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def opsItemRelatedItemAlreadyExistsException(
      message: Option[String] = None,
      resourceUri: Option[String] = None,
      opsItemId: Option[String] = None
    ): OpsItemRelatedItemAlreadyExistsException =
      OpsItemRelatedItemAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceUri)(_.resourceUri(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .build

    def opsItemRelatedItemAssociationNotFoundException(
      message: Option[String] = None
    ): OpsItemRelatedItemAssociationNotFoundException =
      OpsItemRelatedItemAssociationNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsItemRelatedItemSummary(
      opsItemId: Option[String] = None,
      associationId: Option[String] = None,
      resourceType: Option[String] = None,
      associationType: Option[String] = None,
      resourceUri: Option[String] = None,
      createdBy: Option[OpsItemIdentity] = None,
      createdTime: Option[DateTime] = None,
      lastModifiedBy: Option[OpsItemIdentity] = None,
      lastModifiedTime: Option[DateTime] = None
    ): OpsItemRelatedItemSummary =
      OpsItemRelatedItemSummary
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(associationId)(_.associationId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(associationType)(_.associationType(_))
        .ifSome(resourceUri)(_.resourceUri(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def opsItemRelatedItemsFilter(
      key: Option[String] = None,
      values: Option[List[OpsItemRelatedItemsFilterValue]] = None,
      operator: Option[String] = None
    ): OpsItemRelatedItemsFilter =
      OpsItemRelatedItemsFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .ifSome(operator)(_.operator(_))
        .build

    def opsItemSummary(
      createdBy: Option[String] = None,
      createdTime: Option[DateTime] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedTime: Option[DateTime] = None,
      priority: Option[Int] = None,
      source: Option[String] = None,
      status: Option[String] = None,
      opsItemId: Option[String] = None,
      title: Option[String] = None,
      operationalData: Option[OpsItemOperationalData] = None,
      category: Option[String] = None,
      severity: Option[String] = None,
      opsItemType: Option[String] = None,
      actualStartTime: Option[DateTime] = None,
      actualEndTime: Option[DateTime] = None,
      plannedStartTime: Option[DateTime] = None,
      plannedEndTime: Option[DateTime] = None
    ): OpsItemSummary =
      OpsItemSummary
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(source)(_.source(_))
        .ifSome(status)(_.status(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(title)(_.title(_))
        .ifSome(operationalData)(_.operationalData(_))
        .ifSome(category)(_.category(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(opsItemType)(_.opsItemType(_))
        .ifSome(actualStartTime)(_.actualStartTime(_))
        .ifSome(actualEndTime)(_.actualEndTime(_))
        .ifSome(plannedStartTime)(_.plannedStartTime(_))
        .ifSome(plannedEndTime)(_.plannedEndTime(_))
        .build

    def opsMetadata(
      resourceId: Option[String] = None,
      opsMetadataArn: Option[String] = None,
      lastModifiedDate: Option[DateTime] = None,
      lastModifiedUser: Option[String] = None,
      creationDate: Option[DateTime] = None
    ): OpsMetadata =
      OpsMetadata
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(opsMetadataArn)(_.opsMetadataArn(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedUser)(_.lastModifiedUser(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def opsMetadataAlreadyExistsException(
      message: Option[String] = None
    ): OpsMetadataAlreadyExistsException =
      OpsMetadataAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsMetadataFilter(
      key: Option[String] = None,
      values: Option[List[OpsMetadataFilterValue]] = None
    ): OpsMetadataFilter =
      OpsMetadataFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def opsMetadataInvalidArgumentException(
      message: Option[String] = None
    ): OpsMetadataInvalidArgumentException =
      OpsMetadataInvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsMetadataKeyLimitExceededException(
      message: Option[String] = None
    ): OpsMetadataKeyLimitExceededException =
      OpsMetadataKeyLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsMetadataLimitExceededException(
      message: Option[String] = None
    ): OpsMetadataLimitExceededException =
      OpsMetadataLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsMetadataNotFoundException(
      message: Option[String] = None
    ): OpsMetadataNotFoundException =
      OpsMetadataNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsMetadataTooManyUpdatesException(
      message: Option[String] = None
    ): OpsMetadataTooManyUpdatesException =
      OpsMetadataTooManyUpdatesException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opsResultAttribute(
      typeName: Option[String] = None
    ): OpsResultAttribute =
      OpsResultAttribute
        .builder
        .ifSome(typeName)(_.typeName(_))
        .build

    def outputSource(
      outputSourceId: Option[String] = None,
      outputSourceType: Option[String] = None
    ): OutputSource =
      OutputSource
        .builder
        .ifSome(outputSourceId)(_.outputSourceId(_))
        .ifSome(outputSourceType)(_.outputSourceType(_))
        .build

    def parameter(
      name: Option[String] = None,
      `type`: Option[String] = None,
      value: Option[String] = None,
      version: Option[PSParameterVersion] = None,
      selector: Option[String] = None,
      sourceResult: Option[String] = None,
      lastModifiedDate: Option[DateTime] = None,
      aRN: Option[String] = None,
      dataType: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(version)(_.version(_))
        .ifSome(selector)(_.selector(_))
        .ifSome(sourceResult)(_.sourceResult(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def parameterAlreadyExists(
      message: Option[String] = None
    ): ParameterAlreadyExists =
      ParameterAlreadyExists
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parameterHistory(
      name: Option[String] = None,
      `type`: Option[String] = None,
      keyId: Option[String] = None,
      lastModifiedDate: Option[DateTime] = None,
      lastModifiedUser: Option[String] = None,
      description: Option[String] = None,
      value: Option[String] = None,
      allowedPattern: Option[String] = None,
      version: Option[PSParameterVersion] = None,
      labels: Option[List[ParameterLabel]] = None,
      tier: Option[String] = None,
      policies: Option[List[ParameterInlinePolicy]] = None,
      dataType: Option[String] = None
    ): ParameterHistory =
      ParameterHistory
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedUser)(_.lastModifiedUser(_))
        .ifSome(description)(_.description(_))
        .ifSome(value)(_.value(_))
        .ifSome(allowedPattern)(_.allowedPattern(_))
        .ifSome(version)(_.version(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def parameterInlinePolicy(
      policyText: Option[String] = None,
      policyType: Option[String] = None,
      policyStatus: Option[String] = None
    ): ParameterInlinePolicy =
      ParameterInlinePolicy
        .builder
        .ifSome(policyText)(_.policyText(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(policyStatus)(_.policyStatus(_))
        .build

    def parameterLimitExceeded(
      message: Option[String] = None
    ): ParameterLimitExceeded =
      ParameterLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parameterMaxVersionLimitExceeded(
      message: Option[String] = None
    ): ParameterMaxVersionLimitExceeded =
      ParameterMaxVersionLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parameterMetadata(
      name: Option[String] = None,
      `type`: Option[String] = None,
      keyId: Option[String] = None,
      lastModifiedDate: Option[DateTime] = None,
      lastModifiedUser: Option[String] = None,
      description: Option[String] = None,
      allowedPattern: Option[String] = None,
      version: Option[PSParameterVersion] = None,
      tier: Option[String] = None,
      policies: Option[List[ParameterInlinePolicy]] = None,
      dataType: Option[String] = None
    ): ParameterMetadata =
      ParameterMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedUser)(_.lastModifiedUser(_))
        .ifSome(description)(_.description(_))
        .ifSome(allowedPattern)(_.allowedPattern(_))
        .ifSome(version)(_.version(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def parameterNotFound(
      message: Option[String] = None
    ): ParameterNotFound =
      ParameterNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parameterPatternMismatchException(
      message: Option[String] = None
    ): ParameterPatternMismatchException =
      ParameterPatternMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parameterStringFilter(
      key: Option[String] = None,
      option: Option[String] = None,
      values: Option[List[ParameterStringFilterValue]] = None
    ): ParameterStringFilter =
      ParameterStringFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(option)(_.option(_))
        .ifSome(values)(_.values(_))
        .build

    def parameterVersionLabelLimitExceeded(
      message: Option[String] = None
    ): ParameterVersionLabelLimitExceeded =
      ParameterVersionLabelLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parameterVersionNotFound(
      message: Option[String] = None
    ): ParameterVersionNotFound =
      ParameterVersionNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parametersFilter(
      key: Option[String] = None,
      values: Option[List[ParametersFilterValue]] = None
    ): ParametersFilter =
      ParametersFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def patch(
      id: Option[String] = None,
      releaseDate: Option[DateTime] = None,
      title: Option[String] = None,
      description: Option[String] = None,
      contentUrl: Option[String] = None,
      vendor: Option[String] = None,
      productFamily: Option[String] = None,
      product: Option[String] = None,
      classification: Option[String] = None,
      msrcSeverity: Option[String] = None,
      kbNumber: Option[String] = None,
      msrcNumber: Option[String] = None,
      language: Option[String] = None,
      advisoryIds: Option[List[PatchAdvisoryId]] = None,
      bugzillaIds: Option[List[PatchBugzillaId]] = None,
      cVEIds: Option[List[PatchCVEId]] = None,
      name: Option[String] = None,
      epoch: Option[Int] = None,
      version: Option[String] = None,
      release: Option[String] = None,
      arch: Option[String] = None,
      severity: Option[String] = None,
      repository: Option[String] = None
    ): Patch =
      Patch
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(releaseDate)(_.releaseDate(_))
        .ifSome(title)(_.title(_))
        .ifSome(description)(_.description(_))
        .ifSome(contentUrl)(_.contentUrl(_))
        .ifSome(vendor)(_.vendor(_))
        .ifSome(productFamily)(_.productFamily(_))
        .ifSome(product)(_.product(_))
        .ifSome(classification)(_.classification(_))
        .ifSome(msrcSeverity)(_.msrcSeverity(_))
        .ifSome(kbNumber)(_.kbNumber(_))
        .ifSome(msrcNumber)(_.msrcNumber(_))
        .ifSome(language)(_.language(_))
        .ifSome(advisoryIds)(_.advisoryIds(_))
        .ifSome(bugzillaIds)(_.bugzillaIds(_))
        .ifSome(cVEIds)(_.cVEIds(_))
        .ifSome(name)(_.name(_))
        .ifSome(epoch)(_.epoch(_))
        .ifSome(version)(_.version(_))
        .ifSome(release)(_.release(_))
        .ifSome(arch)(_.arch(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(repository)(_.repository(_))
        .build

    def patchBaselineIdentity(
      baselineId: Option[String] = None,
      baselineName: Option[String] = None,
      operatingSystem: Option[String] = None,
      baselineDescription: Option[String] = None,
      defaultBaseline: Option[Boolean] = None
    ): PatchBaselineIdentity =
      PatchBaselineIdentity
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .ifSome(baselineName)(_.baselineName(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(baselineDescription)(_.baselineDescription(_))
        .ifSome(defaultBaseline)(_.defaultBaseline(_))
        .build

    def patchComplianceData(
      title: Option[String] = None,
      kBId: Option[String] = None,
      classification: Option[String] = None,
      severity: Option[String] = None,
      state: Option[String] = None,
      installedTime: Option[DateTime] = None,
      cVEIds: Option[String] = None
    ): PatchComplianceData =
      PatchComplianceData
        .builder
        .ifSome(title)(_.title(_))
        .ifSome(kBId)(_.kBId(_))
        .ifSome(classification)(_.classification(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(state)(_.state(_))
        .ifSome(installedTime)(_.installedTime(_))
        .ifSome(cVEIds)(_.cVEIds(_))
        .build

    def patchFilter(
      key: Option[String] = None,
      values: Option[List[PatchFilterValue]] = None
    ): PatchFilter =
      PatchFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def patchFilterGroup(
      patchFilters: Option[List[PatchFilter]] = None
    ): PatchFilterGroup =
      PatchFilterGroup
        .builder
        .ifSome(patchFilters)(_.patchFilters(_))
        .build

    def patchGroupPatchBaselineMapping(
      patchGroup: Option[String] = None,
      baselineIdentity: Option[PatchBaselineIdentity] = None
    ): PatchGroupPatchBaselineMapping =
      PatchGroupPatchBaselineMapping
        .builder
        .ifSome(patchGroup)(_.patchGroup(_))
        .ifSome(baselineIdentity)(_.baselineIdentity(_))
        .build

    def patchOrchestratorFilter(
      key: Option[String] = None,
      values: Option[List[PatchOrchestratorFilterValue]] = None
    ): PatchOrchestratorFilter =
      PatchOrchestratorFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def patchRule(
      patchFilterGroup: Option[PatchFilterGroup] = None,
      complianceLevel: Option[String] = None,
      approveAfterDays: Option[Int] = None,
      approveUntilDate: Option[String] = None,
      enableNonSecurity: Option[Boolean] = None
    ): PatchRule =
      PatchRule
        .builder
        .ifSome(patchFilterGroup)(_.patchFilterGroup(_))
        .ifSome(complianceLevel)(_.complianceLevel(_))
        .ifSome(approveAfterDays)(_.approveAfterDays(_))
        .ifSome(approveUntilDate)(_.approveUntilDate(_))
        .ifSome(enableNonSecurity)(_.enableNonSecurity(_))
        .build

    def patchRuleGroup(
      patchRules: Option[List[PatchRule]] = None
    ): PatchRuleGroup =
      PatchRuleGroup
        .builder
        .ifSome(patchRules)(_.patchRules(_))
        .build

    def patchSource(
      name: Option[String] = None,
      products: Option[List[PatchSourceProduct]] = None,
      configuration: Option[String] = None
    ): PatchSource =
      PatchSource
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(products)(_.products(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def patchStatus(
      deploymentStatus: Option[String] = None,
      complianceLevel: Option[String] = None,
      approvalDate: Option[DateTime] = None
    ): PatchStatus =
      PatchStatus
        .builder
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(complianceLevel)(_.complianceLevel(_))
        .ifSome(approvalDate)(_.approvalDate(_))
        .build

    def policiesLimitExceededException(
      message: Option[String] = None
    ): PoliciesLimitExceededException =
      PoliciesLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def progressCounters(
      totalSteps: Option[Int] = None,
      successSteps: Option[Int] = None,
      failedSteps: Option[Int] = None,
      cancelledSteps: Option[Int] = None,
      timedOutSteps: Option[Int] = None
    ): ProgressCounters =
      ProgressCounters
        .builder
        .ifSome(totalSteps)(_.totalSteps(_))
        .ifSome(successSteps)(_.successSteps(_))
        .ifSome(failedSteps)(_.failedSteps(_))
        .ifSome(cancelledSteps)(_.cancelledSteps(_))
        .ifSome(timedOutSteps)(_.timedOutSteps(_))
        .build

    def putComplianceItemsRequest(
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      complianceType: Option[String] = None,
      executionSummary: Option[ComplianceExecutionSummary] = None,
      items: Option[List[ComplianceItemEntry]] = None,
      itemContentHash: Option[String] = None,
      uploadType: Option[String] = None
    ): PutComplianceItemsRequest =
      PutComplianceItemsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(executionSummary)(_.executionSummary(_))
        .ifSome(items)(_.items(_))
        .ifSome(itemContentHash)(_.itemContentHash(_))
        .ifSome(uploadType)(_.uploadType(_))
        .build

    def putInventoryRequest(
      instanceId: Option[String] = None,
      items: Option[List[InventoryItem]] = None
    ): PutInventoryRequest =
      PutInventoryRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(items)(_.items(_))
        .build

    def putParameterRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      value: Option[String] = None,
      `type`: Option[String] = None,
      keyId: Option[String] = None,
      overwrite: Option[Boolean] = None,
      allowedPattern: Option[String] = None,
      tags: Option[List[Tag]] = None,
      tier: Option[String] = None,
      policies: Option[String] = None,
      dataType: Option[String] = None
    ): PutParameterRequest =
      PutParameterRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(overwrite)(_.overwrite(_))
        .ifSome(allowedPattern)(_.allowedPattern(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def registerDefaultPatchBaselineRequest(
      baselineId: Option[String] = None
    ): RegisterDefaultPatchBaselineRequest =
      RegisterDefaultPatchBaselineRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .build

    def registerPatchBaselineForPatchGroupRequest(
      baselineId: Option[String] = None,
      patchGroup: Option[String] = None
    ): RegisterPatchBaselineForPatchGroupRequest =
      RegisterPatchBaselineForPatchGroupRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .ifSome(patchGroup)(_.patchGroup(_))
        .build

    def registerTargetWithMaintenanceWindowRequest(
      windowId: Option[String] = None,
      resourceType: Option[String] = None,
      targets: Option[List[Target]] = None,
      ownerInformation: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None
    ): RegisterTargetWithMaintenanceWindowRequest =
      RegisterTargetWithMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(ownerInformation)(_.ownerInformation(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def registerTaskWithMaintenanceWindowRequest(
      windowId: Option[String] = None,
      targets: Option[List[Target]] = None,
      taskArn: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      taskType: Option[String] = None,
      taskParameters: Option[MaintenanceWindowTaskParameters] = None,
      taskInvocationParameters: Option[MaintenanceWindowTaskInvocationParameters] = None,
      priority: Option[Int] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      loggingInfo: Option[LoggingInfo] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None
    ): RegisterTaskWithMaintenanceWindowRequest =
      RegisterTaskWithMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(taskType)(_.taskType(_))
        .ifSome(taskParameters)(_.taskParameters(_))
        .ifSome(taskInvocationParameters)(_.taskInvocationParameters(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def relatedOpsItem(
      opsItemId: Option[String] = None
    ): RelatedOpsItem =
      RelatedOpsItem
        .builder
        .ifSome(opsItemId)(_.opsItemId(_))
        .build

    def removeTagsFromResourceRequest(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): RemoveTagsFromResourceRequest =
      RemoveTagsFromResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def resetServiceSettingRequest(
      settingId: Option[String] = None
    ): ResetServiceSettingRequest =
      ResetServiceSettingRequest
        .builder
        .ifSome(settingId)(_.settingId(_))
        .build

    def resolvedTargets(
      parameterValues: Option[List[ParameterValue]] = None,
      truncated: Option[Boolean] = None
    ): ResolvedTargets =
      ResolvedTargets
        .builder
        .ifSome(parameterValues)(_.parameterValues(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def resourceComplianceSummaryItem(
      complianceType: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      status: Option[String] = None,
      overallSeverity: Option[String] = None,
      executionSummary: Option[ComplianceExecutionSummary] = None,
      compliantSummary: Option[CompliantSummary] = None,
      nonCompliantSummary: Option[NonCompliantSummary] = None
    ): ResourceComplianceSummaryItem =
      ResourceComplianceSummaryItem
        .builder
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(status)(_.status(_))
        .ifSome(overallSeverity)(_.overallSeverity(_))
        .ifSome(executionSummary)(_.executionSummary(_))
        .ifSome(compliantSummary)(_.compliantSummary(_))
        .ifSome(nonCompliantSummary)(_.nonCompliantSummary(_))
        .build

    def resourceDataSyncAlreadyExistsException(
      syncName: Option[String] = None
    ): ResourceDataSyncAlreadyExistsException =
      ResourceDataSyncAlreadyExistsException
        .builder
        .ifSome(syncName)(_.syncName(_))
        .build

    def resourceDataSyncAwsOrganizationsSource(
      organizationSourceType: Option[String] = None,
      organizationalUnits: Option[List[ResourceDataSyncOrganizationalUnit]] = None
    ): ResourceDataSyncAwsOrganizationsSource =
      ResourceDataSyncAwsOrganizationsSource
        .builder
        .ifSome(organizationSourceType)(_.organizationSourceType(_))
        .ifSome(organizationalUnits)(_.organizationalUnits(_))
        .build

    def resourceDataSyncConflictException(
      message: Option[String] = None
    ): ResourceDataSyncConflictException =
      ResourceDataSyncConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceDataSyncCountExceededException(
      message: Option[String] = None
    ): ResourceDataSyncCountExceededException =
      ResourceDataSyncCountExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceDataSyncDestinationDataSharing(
      destinationDataSharingType: Option[String] = None
    ): ResourceDataSyncDestinationDataSharing =
      ResourceDataSyncDestinationDataSharing
        .builder
        .ifSome(destinationDataSharingType)(_.destinationDataSharingType(_))
        .build

    def resourceDataSyncInvalidConfigurationException(
      message: Option[String] = None
    ): ResourceDataSyncInvalidConfigurationException =
      ResourceDataSyncInvalidConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceDataSyncItem(
      syncName: Option[String] = None,
      syncType: Option[String] = None,
      syncSource: Option[ResourceDataSyncSourceWithState] = None,
      s3Destination: Option[ResourceDataSyncS3Destination] = None,
      lastSyncTime: Option[LastResourceDataSyncTime] = None,
      lastSuccessfulSyncTime: Option[LastSuccessfulResourceDataSyncTime] = None,
      syncLastModifiedTime: Option[ResourceDataSyncLastModifiedTime] = None,
      lastStatus: Option[String] = None,
      syncCreatedTime: Option[ResourceDataSyncCreatedTime] = None,
      lastSyncStatusMessage: Option[String] = None
    ): ResourceDataSyncItem =
      ResourceDataSyncItem
        .builder
        .ifSome(syncName)(_.syncName(_))
        .ifSome(syncType)(_.syncType(_))
        .ifSome(syncSource)(_.syncSource(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(lastSyncTime)(_.lastSyncTime(_))
        .ifSome(lastSuccessfulSyncTime)(_.lastSuccessfulSyncTime(_))
        .ifSome(syncLastModifiedTime)(_.syncLastModifiedTime(_))
        .ifSome(lastStatus)(_.lastStatus(_))
        .ifSome(syncCreatedTime)(_.syncCreatedTime(_))
        .ifSome(lastSyncStatusMessage)(_.lastSyncStatusMessage(_))
        .build

    def resourceDataSyncNotFoundException(
      syncName: Option[String] = None,
      syncType: Option[String] = None,
      message: Option[String] = None
    ): ResourceDataSyncNotFoundException =
      ResourceDataSyncNotFoundException
        .builder
        .ifSome(syncName)(_.syncName(_))
        .ifSome(syncType)(_.syncType(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceDataSyncOrganizationalUnit(
      organizationalUnitId: Option[String] = None
    ): ResourceDataSyncOrganizationalUnit =
      ResourceDataSyncOrganizationalUnit
        .builder
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .build

    def resourceDataSyncS3Destination(
      bucketName: Option[String] = None,
      prefix: Option[String] = None,
      syncFormat: Option[String] = None,
      region: Option[String] = None,
      aWSKMSKeyARN: Option[String] = None,
      destinationDataSharing: Option[ResourceDataSyncDestinationDataSharing] = None
    ): ResourceDataSyncS3Destination =
      ResourceDataSyncS3Destination
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(syncFormat)(_.syncFormat(_))
        .ifSome(region)(_.region(_))
        .ifSome(aWSKMSKeyARN)(_.aWSKMSKeyARN(_))
        .ifSome(destinationDataSharing)(_.destinationDataSharing(_))
        .build

    def resourceDataSyncSource(
      sourceType: Option[String] = None,
      awsOrganizationsSource: Option[ResourceDataSyncAwsOrganizationsSource] = None,
      sourceRegions: Option[List[ResourceDataSyncSourceRegion]] = None,
      includeFutureRegions: Option[Boolean] = None,
      enableAllOpsDataSources: Option[Boolean] = None
    ): ResourceDataSyncSource =
      ResourceDataSyncSource
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(awsOrganizationsSource)(_.awsOrganizationsSource(_))
        .ifSome(sourceRegions)(_.sourceRegions(_))
        .ifSome(includeFutureRegions)(_.includeFutureRegions(_))
        .ifSome(enableAllOpsDataSources)(_.enableAllOpsDataSources(_))
        .build

    def resourceDataSyncSourceWithState(
      sourceType: Option[String] = None,
      awsOrganizationsSource: Option[ResourceDataSyncAwsOrganizationsSource] = None,
      sourceRegions: Option[List[ResourceDataSyncSourceRegion]] = None,
      includeFutureRegions: Option[Boolean] = None,
      state: Option[String] = None,
      enableAllOpsDataSources: Option[Boolean] = None
    ): ResourceDataSyncSourceWithState =
      ResourceDataSyncSourceWithState
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(awsOrganizationsSource)(_.awsOrganizationsSource(_))
        .ifSome(sourceRegions)(_.sourceRegions(_))
        .ifSome(includeFutureRegions)(_.includeFutureRegions(_))
        .ifSome(state)(_.state(_))
        .ifSome(enableAllOpsDataSources)(_.enableAllOpsDataSources(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceededException(
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resultAttribute(
      typeName: Option[String] = None
    ): ResultAttribute =
      ResultAttribute
        .builder
        .ifSome(typeName)(_.typeName(_))
        .build

    def resumeSessionRequest(
      sessionId: Option[String] = None
    ): ResumeSessionRequest =
      ResumeSessionRequest
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def resumeSessionResponse(
      sessionId: Option[String] = None,
      tokenValue: Option[String] = None,
      streamUrl: Option[String] = None
    ): ResumeSessionResponse =
      ResumeSessionResponse
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(tokenValue)(_.tokenValue(_))
        .ifSome(streamUrl)(_.streamUrl(_))
        .build

    def reviewInformation(
      reviewedTime: Option[DateTime] = None,
      status: Option[String] = None,
      reviewer: Option[String] = None
    ): ReviewInformation =
      ReviewInformation
        .builder
        .ifSome(reviewedTime)(_.reviewedTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(reviewer)(_.reviewer(_))
        .build

    def runbook(
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      parameters: Option[AutomationParameterMap] = None,
      targetParameterName: Option[String] = None,
      targets: Option[List[Target]] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      targetLocations: Option[List[TargetLocation]] = None
    ): Runbook =
      Runbook
        .builder
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targetParameterName)(_.targetParameterName(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .build

    def s3OutputLocation(
      outputS3Region: Option[String] = None,
      outputS3BucketName: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None
    ): S3OutputLocation =
      S3OutputLocation
        .builder
        .ifSome(outputS3Region)(_.outputS3Region(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .build

    def s3OutputUrl(
      outputUrl: Option[String] = None
    ): S3OutputUrl =
      S3OutputUrl
        .builder
        .ifSome(outputUrl)(_.outputUrl(_))
        .build

    def scheduledWindowExecution(
      windowId: Option[String] = None,
      name: Option[String] = None,
      executionTime: Option[String] = None
    ): ScheduledWindowExecution =
      ScheduledWindowExecution
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(name)(_.name(_))
        .ifSome(executionTime)(_.executionTime(_))
        .build

    def sendAutomationSignalRequest(
      automationExecutionId: Option[String] = None,
      signalType: Option[String] = None,
      payload: Option[AutomationParameterMap] = None
    ): SendAutomationSignalRequest =
      SendAutomationSignalRequest
        .builder
        .ifSome(automationExecutionId)(_.automationExecutionId(_))
        .ifSome(signalType)(_.signalType(_))
        .ifSome(payload)(_.payload(_))
        .build

    def sendCommandRequest(
      instanceIds: Option[List[InstanceId]] = None,
      targets: Option[List[Target]] = None,
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      documentHash: Option[String] = None,
      documentHashType: Option[String] = None,
      timeoutSeconds: Option[Int] = None,
      comment: Option[String] = None,
      parameters: Option[Parameters] = None,
      outputS3Region: Option[String] = None,
      outputS3BucketName: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      notificationConfig: Option[NotificationConfig] = None,
      cloudWatchOutputConfig: Option[CloudWatchOutputConfig] = None
    ): SendCommandRequest =
      SendCommandRequest
        .builder
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(documentHash)(_.documentHash(_))
        .ifSome(documentHashType)(_.documentHashType(_))
        .ifSome(timeoutSeconds)(_.timeoutSeconds(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(outputS3Region)(_.outputS3Region(_))
        .ifSome(outputS3BucketName)(_.outputS3BucketName(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(notificationConfig)(_.notificationConfig(_))
        .ifSome(cloudWatchOutputConfig)(_.cloudWatchOutputConfig(_))
        .build

    def serviceSetting(
      settingId: Option[String] = None,
      settingValue: Option[String] = None,
      lastModifiedDate: Option[DateTime] = None,
      lastModifiedUser: Option[String] = None,
      aRN: Option[String] = None,
      status: Option[String] = None
    ): ServiceSetting =
      ServiceSetting
        .builder
        .ifSome(settingId)(_.settingId(_))
        .ifSome(settingValue)(_.settingValue(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedUser)(_.lastModifiedUser(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(status)(_.status(_))
        .build

    def serviceSettingNotFound(
      message: Option[String] = None
    ): ServiceSettingNotFound =
      ServiceSettingNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def session(
      sessionId: Option[String] = None,
      target: Option[String] = None,
      status: Option[String] = None,
      startDate: Option[DateTime] = None,
      endDate: Option[DateTime] = None,
      documentName: Option[String] = None,
      owner: Option[String] = None,
      details: Option[String] = None,
      outputUrl: Option[SessionManagerOutputUrl] = None
    ): Session =
      Session
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(target)(_.target(_))
        .ifSome(status)(_.status(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(details)(_.details(_))
        .ifSome(outputUrl)(_.outputUrl(_))
        .build

    def sessionFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): SessionFilter =
      SessionFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def sessionManagerOutputUrl(
      s3OutputUrl: Option[String] = None,
      cloudWatchOutputUrl: Option[String] = None
    ): SessionManagerOutputUrl =
      SessionManagerOutputUrl
        .builder
        .ifSome(s3OutputUrl)(_.s3OutputUrl(_))
        .ifSome(cloudWatchOutputUrl)(_.cloudWatchOutputUrl(_))
        .build

    def severitySummary(
      criticalCount: Option[Int] = None,
      highCount: Option[Int] = None,
      mediumCount: Option[Int] = None,
      lowCount: Option[Int] = None,
      informationalCount: Option[Int] = None,
      unspecifiedCount: Option[Int] = None
    ): SeveritySummary =
      SeveritySummary
        .builder
        .ifSome(criticalCount)(_.criticalCount(_))
        .ifSome(highCount)(_.highCount(_))
        .ifSome(mediumCount)(_.mediumCount(_))
        .ifSome(lowCount)(_.lowCount(_))
        .ifSome(informationalCount)(_.informationalCount(_))
        .ifSome(unspecifiedCount)(_.unspecifiedCount(_))
        .build

    def startAssociationsOnceRequest(
      associationIds: Option[List[AssociationId]] = None
    ): StartAssociationsOnceRequest =
      StartAssociationsOnceRequest
        .builder
        .ifSome(associationIds)(_.associationIds(_))
        .build

    def startAutomationExecutionRequest(
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      parameters: Option[AutomationParameterMap] = None,
      clientToken: Option[String] = None,
      mode: Option[String] = None,
      targetParameterName: Option[String] = None,
      targets: Option[List[Target]] = None,
      targetMaps: Option[List[TargetMap]] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      targetLocations: Option[List[TargetLocation]] = None,
      tags: Option[List[Tag]] = None
    ): StartAutomationExecutionRequest =
      StartAutomationExecutionRequest
        .builder
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(targetParameterName)(_.targetParameterName(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(targetMaps)(_.targetMaps(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startChangeRequestExecutionRequest(
      scheduledTime: Option[DateTime] = None,
      documentName: Option[String] = None,
      documentVersion: Option[String] = None,
      parameters: Option[AutomationParameterMap] = None,
      changeRequestName: Option[String] = None,
      clientToken: Option[String] = None,
      runbooks: Option[List[Runbook]] = None,
      tags: Option[List[Tag]] = None,
      scheduledEndTime: Option[DateTime] = None,
      changeDetails: Option[String] = None
    ): StartChangeRequestExecutionRequest =
      StartChangeRequestExecutionRequest
        .builder
        .ifSome(scheduledTime)(_.scheduledTime(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(changeRequestName)(_.changeRequestName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(runbooks)(_.runbooks(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(scheduledEndTime)(_.scheduledEndTime(_))
        .ifSome(changeDetails)(_.changeDetails(_))
        .build

    def startSessionRequest(
      target: Option[String] = None,
      documentName: Option[String] = None,
      parameters: Option[SessionManagerParameters] = None
    ): StartSessionRequest =
      StartSessionRequest
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(documentName)(_.documentName(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def startSessionResponse(
      sessionId: Option[String] = None,
      tokenValue: Option[String] = None,
      streamUrl: Option[String] = None
    ): StartSessionResponse =
      StartSessionResponse
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(tokenValue)(_.tokenValue(_))
        .ifSome(streamUrl)(_.streamUrl(_))
        .build

    def statusUnchanged(

    ): StatusUnchanged =
      StatusUnchanged
        .builder

        .build

    def stepExecution(
      stepName: Option[String] = None,
      action: Option[String] = None,
      timeoutSeconds: Option[Long] = None,
      onFailure: Option[String] = None,
      maxAttempts: Option[Int] = None,
      executionStartTime: Option[DateTime] = None,
      executionEndTime: Option[DateTime] = None,
      stepStatus: Option[String] = None,
      responseCode: Option[String] = None,
      inputs: Option[NormalStringMap] = None,
      outputs: Option[AutomationParameterMap] = None,
      response: Option[String] = None,
      failureMessage: Option[String] = None,
      failureDetails: Option[FailureDetails] = None,
      stepExecutionId: Option[String] = None,
      overriddenParameters: Option[AutomationParameterMap] = None,
      isEnd: Option[Boolean] = None,
      nextStep: Option[String] = None,
      isCritical: Option[Boolean] = None,
      validNextSteps: Option[List[ValidNextStep]] = None,
      targets: Option[List[Target]] = None,
      targetLocation: Option[TargetLocation] = None
    ): StepExecution =
      StepExecution
        .builder
        .ifSome(stepName)(_.stepName(_))
        .ifSome(action)(_.action(_))
        .ifSome(timeoutSeconds)(_.timeoutSeconds(_))
        .ifSome(onFailure)(_.onFailure(_))
        .ifSome(maxAttempts)(_.maxAttempts(_))
        .ifSome(executionStartTime)(_.executionStartTime(_))
        .ifSome(executionEndTime)(_.executionEndTime(_))
        .ifSome(stepStatus)(_.stepStatus(_))
        .ifSome(responseCode)(_.responseCode(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(response)(_.response(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .ifSome(stepExecutionId)(_.stepExecutionId(_))
        .ifSome(overriddenParameters)(_.overriddenParameters(_))
        .ifSome(isEnd)(_.isEnd(_))
        .ifSome(nextStep)(_.nextStep(_))
        .ifSome(isCritical)(_.isCritical(_))
        .ifSome(validNextSteps)(_.validNextSteps(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(targetLocation)(_.targetLocation(_))
        .build

    def stepExecutionFilter(
      key: Option[String] = None,
      values: Option[List[StepExecutionFilterValue]] = None
    ): StepExecutionFilter =
      StepExecutionFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def stopAutomationExecutionRequest(
      automationExecutionId: Option[String] = None,
      `type`: Option[String] = None
    ): StopAutomationExecutionRequest =
      StopAutomationExecutionRequest
        .builder
        .ifSome(automationExecutionId)(_.automationExecutionId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def subTypeCountLimitExceededException(
      message: Option[String] = None
    ): SubTypeCountLimitExceededException =
      SubTypeCountLimitExceededException
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

    def target(
      key: Option[String] = None,
      values: Option[List[TargetValue]] = None
    ): Target =
      Target
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def targetInUseException(
      message: Option[String] = None
    ): TargetInUseException =
      TargetInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def targetLocation(
      accounts: Option[List[Account]] = None,
      regions: Option[List[Region]] = None,
      targetLocationMaxConcurrency: Option[String] = None,
      targetLocationMaxErrors: Option[String] = None,
      executionRoleName: Option[String] = None
    ): TargetLocation =
      TargetLocation
        .builder
        .ifSome(accounts)(_.accounts(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(targetLocationMaxConcurrency)(_.targetLocationMaxConcurrency(_))
        .ifSome(targetLocationMaxErrors)(_.targetLocationMaxErrors(_))
        .ifSome(executionRoleName)(_.executionRoleName(_))
        .build

    def targetNotConnected(
      message: Option[String] = None
    ): TargetNotConnected =
      TargetNotConnected
        .builder
        .ifSome(message)(_.message(_))
        .build

    def terminateSessionRequest(
      sessionId: Option[String] = None
    ): TerminateSessionRequest =
      TerminateSessionRequest
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def terminateSessionResponse(
      sessionId: Option[String] = None
    ): TerminateSessionResponse =
      TerminateSessionResponse
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def tooManyTagsError(

    ): TooManyTagsError =
      TooManyTagsError
        .builder

        .build

    def tooManyUpdates(
      message: Option[String] = None
    ): TooManyUpdates =
      TooManyUpdates
        .builder
        .ifSome(message)(_.message(_))
        .build

    def totalSizeLimitExceededException(
      message: Option[String] = None
    ): TotalSizeLimitExceededException =
      TotalSizeLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unlabelParameterVersionRequest(
      name: Option[String] = None,
      parameterVersion: Option[PSParameterVersion] = None,
      labels: Option[List[ParameterLabel]] = None
    ): UnlabelParameterVersionRequest =
      UnlabelParameterVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(parameterVersion)(_.parameterVersion(_))
        .ifSome(labels)(_.labels(_))
        .build

    def unsupportedCalendarException(
      message: Option[String] = None
    ): UnsupportedCalendarException =
      UnsupportedCalendarException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedFeatureRequiredException(
      message: Option[String] = None
    ): UnsupportedFeatureRequiredException =
      UnsupportedFeatureRequiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedInventoryItemContextException(
      typeName: Option[String] = None,
      message: Option[String] = None
    ): UnsupportedInventoryItemContextException =
      UnsupportedInventoryItemContextException
        .builder
        .ifSome(typeName)(_.typeName(_))
        .ifSome(message)(_.message(_))
        .build

    def unsupportedInventorySchemaVersionException(
      message: Option[String] = None
    ): UnsupportedInventorySchemaVersionException =
      UnsupportedInventorySchemaVersionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedOperatingSystem(
      message: Option[String] = None
    ): UnsupportedOperatingSystem =
      UnsupportedOperatingSystem
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedParameterType(
      message: Option[String] = None
    ): UnsupportedParameterType =
      UnsupportedParameterType
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedPlatformType(
      message: Option[String] = None
    ): UnsupportedPlatformType =
      UnsupportedPlatformType
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateAssociationRequest(
      associationId: Option[String] = None,
      parameters: Option[Parameters] = None,
      documentVersion: Option[String] = None,
      scheduleExpression: Option[String] = None,
      outputLocation: Option[InstanceAssociationOutputLocation] = None,
      name: Option[String] = None,
      targets: Option[List[Target]] = None,
      associationName: Option[String] = None,
      associationVersion: Option[String] = None,
      automationTargetParameterName: Option[String] = None,
      maxErrors: Option[String] = None,
      maxConcurrency: Option[String] = None,
      complianceSeverity: Option[String] = None,
      syncCompliance: Option[String] = None,
      applyOnlyAtCronInterval: Option[Boolean] = None,
      calendarNames: Option[List[CalendarNameOrARN]] = None,
      targetLocations: Option[List[TargetLocation]] = None
    ): UpdateAssociationRequest =
      UpdateAssociationRequest
        .builder
        .ifSome(associationId)(_.associationId(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(name)(_.name(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(associationName)(_.associationName(_))
        .ifSome(associationVersion)(_.associationVersion(_))
        .ifSome(automationTargetParameterName)(_.automationTargetParameterName(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(complianceSeverity)(_.complianceSeverity(_))
        .ifSome(syncCompliance)(_.syncCompliance(_))
        .ifSome(applyOnlyAtCronInterval)(_.applyOnlyAtCronInterval(_))
        .ifSome(calendarNames)(_.calendarNames(_))
        .ifSome(targetLocations)(_.targetLocations(_))
        .build

    def updateAssociationStatusRequest(
      name: Option[String] = None,
      instanceId: Option[String] = None,
      associationStatus: Option[AssociationStatus] = None
    ): UpdateAssociationStatusRequest =
      UpdateAssociationStatusRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(associationStatus)(_.associationStatus(_))
        .build

    def updateDocumentDefaultVersionRequest(
      name: Option[String] = None,
      documentVersion: Option[String] = None
    ): UpdateDocumentDefaultVersionRequest =
      UpdateDocumentDefaultVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .build

    def updateDocumentMetadataRequest(
      name: Option[String] = None,
      documentVersion: Option[String] = None,
      documentReviews: Option[DocumentReviews] = None
    ): UpdateDocumentMetadataRequest =
      UpdateDocumentMetadataRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(documentReviews)(_.documentReviews(_))
        .build

    def updateDocumentMetadataResponse(

    ): UpdateDocumentMetadataResponse =
      UpdateDocumentMetadataResponse
        .builder

        .build

    def updateDocumentRequest(
      content: Option[String] = None,
      attachments: Option[List[AttachmentsSource]] = None,
      name: Option[String] = None,
      displayName: Option[String] = None,
      versionName: Option[String] = None,
      documentVersion: Option[String] = None,
      documentFormat: Option[String] = None,
      targetType: Option[String] = None
    ): UpdateDocumentRequest =
      UpdateDocumentRequest
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(attachments)(_.attachments(_))
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(documentVersion)(_.documentVersion(_))
        .ifSome(documentFormat)(_.documentFormat(_))
        .ifSome(targetType)(_.targetType(_))
        .build

    def updateMaintenanceWindowRequest(
      windowId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      startDate: Option[String] = None,
      endDate: Option[String] = None,
      schedule: Option[String] = None,
      scheduleTimezone: Option[String] = None,
      scheduleOffset: Option[Int] = None,
      duration: Option[Int] = None,
      cutoff: Option[Int] = None,
      allowUnassociatedTargets: Option[Boolean] = None,
      enabled: Option[Boolean] = None,
      replace: Option[Boolean] = None
    ): UpdateMaintenanceWindowRequest =
      UpdateMaintenanceWindowRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(scheduleTimezone)(_.scheduleTimezone(_))
        .ifSome(scheduleOffset)(_.scheduleOffset(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(cutoff)(_.cutoff(_))
        .ifSome(allowUnassociatedTargets)(_.allowUnassociatedTargets(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(replace)(_.replace(_))
        .build

    def updateMaintenanceWindowTargetRequest(
      windowId: Option[String] = None,
      windowTargetId: Option[String] = None,
      targets: Option[List[Target]] = None,
      ownerInformation: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      replace: Option[Boolean] = None
    ): UpdateMaintenanceWindowTargetRequest =
      UpdateMaintenanceWindowTargetRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTargetId)(_.windowTargetId(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(ownerInformation)(_.ownerInformation(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(replace)(_.replace(_))
        .build

    def updateMaintenanceWindowTaskRequest(
      windowId: Option[String] = None,
      windowTaskId: Option[String] = None,
      targets: Option[List[Target]] = None,
      taskArn: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      taskParameters: Option[MaintenanceWindowTaskParameters] = None,
      taskInvocationParameters: Option[MaintenanceWindowTaskInvocationParameters] = None,
      priority: Option[Int] = None,
      maxConcurrency: Option[String] = None,
      maxErrors: Option[String] = None,
      loggingInfo: Option[LoggingInfo] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      replace: Option[Boolean] = None
    ): UpdateMaintenanceWindowTaskRequest =
      UpdateMaintenanceWindowTaskRequest
        .builder
        .ifSome(windowId)(_.windowId(_))
        .ifSome(windowTaskId)(_.windowTaskId(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(taskArn)(_.taskArn(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(taskParameters)(_.taskParameters(_))
        .ifSome(taskInvocationParameters)(_.taskInvocationParameters(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .ifSome(maxErrors)(_.maxErrors(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(replace)(_.replace(_))
        .build

    def updateManagedInstanceRoleRequest(
      instanceId: Option[String] = None,
      iamRole: Option[String] = None
    ): UpdateManagedInstanceRoleRequest =
      UpdateManagedInstanceRoleRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(iamRole)(_.iamRole(_))
        .build

    def updateOpsItemRequest(
      description: Option[String] = None,
      operationalData: Option[OpsItemOperationalData] = None,
      operationalDataToDelete: Option[List[String]] = None,
      notifications: Option[List[OpsItemNotification]] = None,
      priority: Option[Int] = None,
      relatedOpsItems: Option[List[RelatedOpsItem]] = None,
      status: Option[String] = None,
      opsItemId: Option[String] = None,
      title: Option[String] = None,
      category: Option[String] = None,
      severity: Option[String] = None,
      actualStartTime: Option[DateTime] = None,
      actualEndTime: Option[DateTime] = None,
      plannedStartTime: Option[DateTime] = None,
      plannedEndTime: Option[DateTime] = None
    ): UpdateOpsItemRequest =
      UpdateOpsItemRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(operationalData)(_.operationalData(_))
        .ifSome(operationalDataToDelete)(_.operationalDataToDelete(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(relatedOpsItems)(_.relatedOpsItems(_))
        .ifSome(status)(_.status(_))
        .ifSome(opsItemId)(_.opsItemId(_))
        .ifSome(title)(_.title(_))
        .ifSome(category)(_.category(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(actualStartTime)(_.actualStartTime(_))
        .ifSome(actualEndTime)(_.actualEndTime(_))
        .ifSome(plannedStartTime)(_.plannedStartTime(_))
        .ifSome(plannedEndTime)(_.plannedEndTime(_))
        .build

    def updateOpsItemResponse(

    ): UpdateOpsItemResponse =
      UpdateOpsItemResponse
        .builder

        .build

    def updateOpsMetadataRequest(
      opsMetadataArn: Option[String] = None,
      metadataToUpdate: Option[MetadataMap] = None,
      keysToDelete: Option[List[MetadataKey]] = None
    ): UpdateOpsMetadataRequest =
      UpdateOpsMetadataRequest
        .builder
        .ifSome(opsMetadataArn)(_.opsMetadataArn(_))
        .ifSome(metadataToUpdate)(_.metadataToUpdate(_))
        .ifSome(keysToDelete)(_.keysToDelete(_))
        .build

    def updatePatchBaselineRequest(
      baselineId: Option[String] = None,
      name: Option[String] = None,
      globalFilters: Option[PatchFilterGroup] = None,
      approvalRules: Option[PatchRuleGroup] = None,
      approvedPatches: Option[List[PatchId]] = None,
      approvedPatchesComplianceLevel: Option[String] = None,
      approvedPatchesEnableNonSecurity: Option[Boolean] = None,
      rejectedPatches: Option[List[PatchId]] = None,
      rejectedPatchesAction: Option[String] = None,
      description: Option[String] = None,
      sources: Option[List[PatchSource]] = None,
      replace: Option[Boolean] = None
    ): UpdatePatchBaselineRequest =
      UpdatePatchBaselineRequest
        .builder
        .ifSome(baselineId)(_.baselineId(_))
        .ifSome(name)(_.name(_))
        .ifSome(globalFilters)(_.globalFilters(_))
        .ifSome(approvalRules)(_.approvalRules(_))
        .ifSome(approvedPatches)(_.approvedPatches(_))
        .ifSome(approvedPatchesComplianceLevel)(_.approvedPatchesComplianceLevel(_))
        .ifSome(approvedPatchesEnableNonSecurity)(_.approvedPatchesEnableNonSecurity(_))
        .ifSome(rejectedPatches)(_.rejectedPatches(_))
        .ifSome(rejectedPatchesAction)(_.rejectedPatchesAction(_))
        .ifSome(description)(_.description(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(replace)(_.replace(_))
        .build

    def updateResourceDataSyncRequest(
      syncName: Option[String] = None,
      syncType: Option[String] = None,
      syncSource: Option[ResourceDataSyncSource] = None
    ): UpdateResourceDataSyncRequest =
      UpdateResourceDataSyncRequest
        .builder
        .ifSome(syncName)(_.syncName(_))
        .ifSome(syncType)(_.syncType(_))
        .ifSome(syncSource)(_.syncSource(_))
        .build

    def updateServiceSettingRequest(
      settingId: Option[String] = None,
      settingValue: Option[String] = None
    ): UpdateServiceSettingRequest =
      UpdateServiceSettingRequest
        .builder
        .ifSome(settingId)(_.settingId(_))
        .ifSome(settingValue)(_.settingValue(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
