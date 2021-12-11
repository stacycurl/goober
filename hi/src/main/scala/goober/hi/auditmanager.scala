package goober.hi

import goober.free.auditmanager.AuditManagerIO
import software.amazon.awssdk.services.auditmanager.model._


object auditmanager {
  import goober.free.{auditmanager ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aWSAccount(
      id: Option[String] = None,
      emailAddress: Option[String] = None,
      name: Option[String] = None
    ): AWSAccount =
      AWSAccount
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(name)(_.name(_))
        .build

    def aWSService(
      serviceName: Option[String] = None
    ): AWSService =
      AWSService
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def assessment(
      arn: Option[String] = None,
      awsAccount: Option[AWSAccount] = None,
      metadata: Option[AssessmentMetadata] = None,
      framework: Option[AssessmentFramework] = None,
      tags: Option[TagMap] = None
    ): Assessment =
      Assessment
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(awsAccount)(_.awsAccount(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(tags)(_.tags(_))
        .build

    def assessmentControl(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      response: Option[String] = None,
      comments: Option[List[ControlComment]] = None,
      evidenceSources: Option[List[NonEmptyString]] = None,
      evidenceCount: Option[Int] = None,
      assessmentReportEvidenceCount: Option[Int] = None
    ): AssessmentControl =
      AssessmentControl
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(response)(_.response(_))
        .ifSome(comments)(_.comments(_))
        .ifSome(evidenceSources)(_.evidenceSources(_))
        .ifSome(evidenceCount)(_.evidenceCount(_))
        .ifSome(assessmentReportEvidenceCount)(_.assessmentReportEvidenceCount(_))
        .build

    def assessmentControlSet(
      id: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      roles: Option[List[Role]] = None,
      controls: Option[List[AssessmentControl]] = None,
      delegations: Option[List[Delegation]] = None,
      systemEvidenceCount: Option[Int] = None,
      manualEvidenceCount: Option[Int] = None
    ): AssessmentControlSet =
      AssessmentControlSet
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(controls)(_.controls(_))
        .ifSome(delegations)(_.delegations(_))
        .ifSome(systemEvidenceCount)(_.systemEvidenceCount(_))
        .ifSome(manualEvidenceCount)(_.manualEvidenceCount(_))
        .build

    def assessmentEvidenceFolder(
      name: Option[String] = None,
      date: Option[Timestamp] = None,
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      controlId: Option[String] = None,
      id: Option[String] = None,
      dataSource: Option[String] = None,
      author: Option[String] = None,
      totalEvidence: Option[Int] = None,
      assessmentReportSelectionCount: Option[Int] = None,
      controlName: Option[String] = None,
      evidenceResourcesIncludedCount: Option[Int] = None,
      evidenceByTypeConfigurationDataCount: Option[Int] = None,
      evidenceByTypeManualCount: Option[Int] = None,
      evidenceByTypeComplianceCheckCount: Option[Int] = None,
      evidenceByTypeComplianceCheckIssuesCount: Option[Int] = None,
      evidenceByTypeUserActivityCount: Option[Int] = None,
      evidenceAwsServiceSourceCount: Option[Int] = None
    ): AssessmentEvidenceFolder =
      AssessmentEvidenceFolder
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(date)(_.date(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(controlId)(_.controlId(_))
        .ifSome(id)(_.id(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(author)(_.author(_))
        .ifSome(totalEvidence)(_.totalEvidence(_))
        .ifSome(assessmentReportSelectionCount)(_.assessmentReportSelectionCount(_))
        .ifSome(controlName)(_.controlName(_))
        .ifSome(evidenceResourcesIncludedCount)(_.evidenceResourcesIncludedCount(_))
        .ifSome(evidenceByTypeConfigurationDataCount)(_.evidenceByTypeConfigurationDataCount(_))
        .ifSome(evidenceByTypeManualCount)(_.evidenceByTypeManualCount(_))
        .ifSome(evidenceByTypeComplianceCheckCount)(_.evidenceByTypeComplianceCheckCount(_))
        .ifSome(evidenceByTypeComplianceCheckIssuesCount)(_.evidenceByTypeComplianceCheckIssuesCount(_))
        .ifSome(evidenceByTypeUserActivityCount)(_.evidenceByTypeUserActivityCount(_))
        .ifSome(evidenceAwsServiceSourceCount)(_.evidenceAwsServiceSourceCount(_))
        .build

    def assessmentFramework(
      id: Option[String] = None,
      arn: Option[String] = None,
      metadata: Option[FrameworkMetadata] = None,
      controlSets: Option[List[AssessmentControlSet]] = None
    ): AssessmentFramework =
      AssessmentFramework
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(controlSets)(_.controlSets(_))
        .build

    def assessmentFrameworkMetadata(
      arn: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      logo: Option[String] = None,
      complianceType: Option[String] = None,
      controlsCount: Option[Int] = None,
      controlSetsCount: Option[Int] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None
    ): AssessmentFrameworkMetadata =
      AssessmentFrameworkMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(logo)(_.logo(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(controlsCount)(_.controlsCount(_))
        .ifSome(controlSetsCount)(_.controlSetsCount(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def assessmentMetadata(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      complianceType: Option[String] = None,
      status: Option[String] = None,
      assessmentReportsDestination: Option[AssessmentReportsDestination] = None,
      scope: Option[Scope] = None,
      roles: Option[List[Role]] = None,
      delegations: Option[List[Delegation]] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None
    ): AssessmentMetadata =
      AssessmentMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(status)(_.status(_))
        .ifSome(assessmentReportsDestination)(_.assessmentReportsDestination(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(delegations)(_.delegations(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .build

    def assessmentMetadataItem(
      name: Option[String] = None,
      id: Option[String] = None,
      complianceType: Option[String] = None,
      status: Option[String] = None,
      roles: Option[List[Role]] = None,
      delegations: Option[List[Delegation]] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None
    ): AssessmentMetadataItem =
      AssessmentMetadataItem
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(status)(_.status(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(delegations)(_.delegations(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .build

    def assessmentReport(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      awsAccountId: Option[String] = None,
      assessmentId: Option[String] = None,
      assessmentName: Option[String] = None,
      author: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): AssessmentReport =
      AssessmentReport
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(assessmentName)(_.assessmentName(_))
        .ifSome(author)(_.author(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def assessmentReportEvidenceError(
      evidenceId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): AssessmentReportEvidenceError =
      AssessmentReportEvidenceError
        .builder
        .ifSome(evidenceId)(_.evidenceId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def assessmentReportMetadata(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      assessmentId: Option[String] = None,
      assessmentName: Option[String] = None,
      author: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): AssessmentReportMetadata =
      AssessmentReportMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(assessmentName)(_.assessmentName(_))
        .ifSome(author)(_.author(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def assessmentReportsDestination(
      destinationType: Option[String] = None,
      destination: Option[String] = None
    ): AssessmentReportsDestination =
      AssessmentReportsDestination
        .builder
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(destination)(_.destination(_))
        .build

    def associateAssessmentReportEvidenceFolderRequest(
      assessmentId: Option[String] = None,
      evidenceFolderId: Option[String] = None
    ): AssociateAssessmentReportEvidenceFolderRequest =
      AssociateAssessmentReportEvidenceFolderRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .build

    def associateAssessmentReportEvidenceFolderResponse(

    ): AssociateAssessmentReportEvidenceFolderResponse =
      AssociateAssessmentReportEvidenceFolderResponse
        .builder

        .build

    def batchAssociateAssessmentReportEvidenceRequest(
      assessmentId: Option[String] = None,
      evidenceFolderId: Option[String] = None,
      evidenceIds: Option[List[UUID]] = None
    ): BatchAssociateAssessmentReportEvidenceRequest =
      BatchAssociateAssessmentReportEvidenceRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .ifSome(evidenceIds)(_.evidenceIds(_))
        .build

    def batchAssociateAssessmentReportEvidenceResponse(
      evidenceIds: Option[List[UUID]] = None,
      errors: Option[List[AssessmentReportEvidenceError]] = None
    ): BatchAssociateAssessmentReportEvidenceResponse =
      BatchAssociateAssessmentReportEvidenceResponse
        .builder
        .ifSome(evidenceIds)(_.evidenceIds(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchCreateDelegationByAssessmentError(
      createDelegationRequest: Option[CreateDelegationRequest] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchCreateDelegationByAssessmentError =
      BatchCreateDelegationByAssessmentError
        .builder
        .ifSome(createDelegationRequest)(_.createDelegationRequest(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchCreateDelegationByAssessmentRequest(
      createDelegationRequests: Option[List[CreateDelegationRequest]] = None,
      assessmentId: Option[String] = None
    ): BatchCreateDelegationByAssessmentRequest =
      BatchCreateDelegationByAssessmentRequest
        .builder
        .ifSome(createDelegationRequests)(_.createDelegationRequests(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .build

    def batchCreateDelegationByAssessmentResponse(
      delegations: Option[List[Delegation]] = None,
      errors: Option[List[BatchCreateDelegationByAssessmentError]] = None
    ): BatchCreateDelegationByAssessmentResponse =
      BatchCreateDelegationByAssessmentResponse
        .builder
        .ifSome(delegations)(_.delegations(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeleteDelegationByAssessmentError(
      delegationId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchDeleteDelegationByAssessmentError =
      BatchDeleteDelegationByAssessmentError
        .builder
        .ifSome(delegationId)(_.delegationId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchDeleteDelegationByAssessmentRequest(
      delegationIds: Option[List[UUID]] = None,
      assessmentId: Option[String] = None
    ): BatchDeleteDelegationByAssessmentRequest =
      BatchDeleteDelegationByAssessmentRequest
        .builder
        .ifSome(delegationIds)(_.delegationIds(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .build

    def batchDeleteDelegationByAssessmentResponse(
      errors: Option[List[BatchDeleteDelegationByAssessmentError]] = None
    ): BatchDeleteDelegationByAssessmentResponse =
      BatchDeleteDelegationByAssessmentResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDisassociateAssessmentReportEvidenceRequest(
      assessmentId: Option[String] = None,
      evidenceFolderId: Option[String] = None,
      evidenceIds: Option[List[UUID]] = None
    ): BatchDisassociateAssessmentReportEvidenceRequest =
      BatchDisassociateAssessmentReportEvidenceRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .ifSome(evidenceIds)(_.evidenceIds(_))
        .build

    def batchDisassociateAssessmentReportEvidenceResponse(
      evidenceIds: Option[List[UUID]] = None,
      errors: Option[List[AssessmentReportEvidenceError]] = None
    ): BatchDisassociateAssessmentReportEvidenceResponse =
      BatchDisassociateAssessmentReportEvidenceResponse
        .builder
        .ifSome(evidenceIds)(_.evidenceIds(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchImportEvidenceToAssessmentControlError(
      manualEvidence: Option[ManualEvidence] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchImportEvidenceToAssessmentControlError =
      BatchImportEvidenceToAssessmentControlError
        .builder
        .ifSome(manualEvidence)(_.manualEvidence(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchImportEvidenceToAssessmentControlRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      controlId: Option[String] = None,
      manualEvidence: Option[List[ManualEvidence]] = None
    ): BatchImportEvidenceToAssessmentControlRequest =
      BatchImportEvidenceToAssessmentControlRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(controlId)(_.controlId(_))
        .ifSome(manualEvidence)(_.manualEvidence(_))
        .build

    def batchImportEvidenceToAssessmentControlResponse(
      errors: Option[List[BatchImportEvidenceToAssessmentControlError]] = None
    ): BatchImportEvidenceToAssessmentControlResponse =
      BatchImportEvidenceToAssessmentControlResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def changeLog(
      objectType: Option[String] = None,
      objectName: Option[String] = None,
      action: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      createdBy: Option[String] = None
    ): ChangeLog =
      ChangeLog
        .builder
        .ifSome(objectType)(_.objectType(_))
        .ifSome(objectName)(_.objectName(_))
        .ifSome(action)(_.action(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def control(
      arn: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      testingInformation: Option[String] = None,
      actionPlanTitle: Option[String] = None,
      actionPlanInstructions: Option[String] = None,
      controlSources: Option[String] = None,
      controlMappingSources: Option[List[ControlMappingSource]] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      lastUpdatedBy: Option[String] = None,
      tags: Option[TagMap] = None
    ): Control =
      Control
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(testingInformation)(_.testingInformation(_))
        .ifSome(actionPlanTitle)(_.actionPlanTitle(_))
        .ifSome(actionPlanInstructions)(_.actionPlanInstructions(_))
        .ifSome(controlSources)(_.controlSources(_))
        .ifSome(controlMappingSources)(_.controlMappingSources(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def controlComment(
      authorName: Option[String] = None,
      commentBody: Option[String] = None,
      postedDate: Option[Timestamp] = None
    ): ControlComment =
      ControlComment
        .builder
        .ifSome(authorName)(_.authorName(_))
        .ifSome(commentBody)(_.commentBody(_))
        .ifSome(postedDate)(_.postedDate(_))
        .build

    def controlMappingSource(
      sourceId: Option[String] = None,
      sourceName: Option[String] = None,
      sourceDescription: Option[String] = None,
      sourceSetUpOption: Option[String] = None,
      sourceType: Option[String] = None,
      sourceKeyword: Option[SourceKeyword] = None,
      sourceFrequency: Option[String] = None,
      troubleshootingText: Option[String] = None
    ): ControlMappingSource =
      ControlMappingSource
        .builder
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(sourceDescription)(_.sourceDescription(_))
        .ifSome(sourceSetUpOption)(_.sourceSetUpOption(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceKeyword)(_.sourceKeyword(_))
        .ifSome(sourceFrequency)(_.sourceFrequency(_))
        .ifSome(troubleshootingText)(_.troubleshootingText(_))
        .build

    def controlMetadata(
      arn: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      controlSources: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None
    ): ControlMetadata =
      ControlMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(controlSources)(_.controlSources(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def controlSet(
      id: Option[String] = None,
      name: Option[String] = None,
      controls: Option[List[Control]] = None
    ): ControlSet =
      ControlSet
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(controls)(_.controls(_))
        .build

    def createAssessmentFrameworkControl(
      id: Option[String] = None
    ): CreateAssessmentFrameworkControl =
      CreateAssessmentFrameworkControl
        .builder
        .ifSome(id)(_.id(_))
        .build

    def createAssessmentFrameworkControlSet(
      name: Option[String] = None,
      controls: Option[List[CreateAssessmentFrameworkControl]] = None
    ): CreateAssessmentFrameworkControlSet =
      CreateAssessmentFrameworkControlSet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(controls)(_.controls(_))
        .build

    def createAssessmentFrameworkRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      complianceType: Option[String] = None,
      controlSets: Option[List[CreateAssessmentFrameworkControlSet]] = None,
      tags: Option[TagMap] = None
    ): CreateAssessmentFrameworkRequest =
      CreateAssessmentFrameworkRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(controlSets)(_.controlSets(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssessmentFrameworkResponse(
      framework: Option[Framework] = None
    ): CreateAssessmentFrameworkResponse =
      CreateAssessmentFrameworkResponse
        .builder
        .ifSome(framework)(_.framework(_))
        .build

    def createAssessmentReportRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      assessmentId: Option[String] = None
    ): CreateAssessmentReportRequest =
      CreateAssessmentReportRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .build

    def createAssessmentReportResponse(
      assessmentReport: Option[AssessmentReport] = None
    ): CreateAssessmentReportResponse =
      CreateAssessmentReportResponse
        .builder
        .ifSome(assessmentReport)(_.assessmentReport(_))
        .build

    def createAssessmentRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      assessmentReportsDestination: Option[AssessmentReportsDestination] = None,
      scope: Option[Scope] = None,
      roles: Option[List[Role]] = None,
      frameworkId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateAssessmentRequest =
      CreateAssessmentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(assessmentReportsDestination)(_.assessmentReportsDestination(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(frameworkId)(_.frameworkId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssessmentResponse(
      assessment: Option[Assessment] = None
    ): CreateAssessmentResponse =
      CreateAssessmentResponse
        .builder
        .ifSome(assessment)(_.assessment(_))
        .build

    def createControlMappingSource(
      sourceName: Option[String] = None,
      sourceDescription: Option[String] = None,
      sourceSetUpOption: Option[String] = None,
      sourceType: Option[String] = None,
      sourceKeyword: Option[SourceKeyword] = None,
      sourceFrequency: Option[String] = None,
      troubleshootingText: Option[String] = None
    ): CreateControlMappingSource =
      CreateControlMappingSource
        .builder
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(sourceDescription)(_.sourceDescription(_))
        .ifSome(sourceSetUpOption)(_.sourceSetUpOption(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceKeyword)(_.sourceKeyword(_))
        .ifSome(sourceFrequency)(_.sourceFrequency(_))
        .ifSome(troubleshootingText)(_.troubleshootingText(_))
        .build

    def createControlRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      testingInformation: Option[String] = None,
      actionPlanTitle: Option[String] = None,
      actionPlanInstructions: Option[String] = None,
      controlMappingSources: Option[List[CreateControlMappingSource]] = None,
      tags: Option[TagMap] = None
    ): CreateControlRequest =
      CreateControlRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(testingInformation)(_.testingInformation(_))
        .ifSome(actionPlanTitle)(_.actionPlanTitle(_))
        .ifSome(actionPlanInstructions)(_.actionPlanInstructions(_))
        .ifSome(controlMappingSources)(_.controlMappingSources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createControlResponse(
      control: Option[Control] = None
    ): CreateControlResponse =
      CreateControlResponse
        .builder
        .ifSome(control)(_.control(_))
        .build

    def createDelegationRequest(
      comment: Option[String] = None,
      controlSetId: Option[String] = None,
      roleArn: Option[String] = None,
      roleType: Option[String] = None
    ): CreateDelegationRequest =
      CreateDelegationRequest
        .builder
        .ifSome(comment)(_.comment(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(roleType)(_.roleType(_))
        .build

    def delegation(
      id: Option[String] = None,
      assessmentName: Option[String] = None,
      assessmentId: Option[String] = None,
      status: Option[String] = None,
      roleArn: Option[String] = None,
      roleType: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None,
      controlSetId: Option[String] = None,
      comment: Option[String] = None,
      createdBy: Option[String] = None
    ): Delegation =
      Delegation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(assessmentName)(_.assessmentName(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(status)(_.status(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(roleType)(_.roleType(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def delegationMetadata(
      id: Option[String] = None,
      assessmentName: Option[String] = None,
      assessmentId: Option[String] = None,
      status: Option[String] = None,
      roleArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      controlSetName: Option[String] = None
    ): DelegationMetadata =
      DelegationMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(assessmentName)(_.assessmentName(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(status)(_.status(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(controlSetName)(_.controlSetName(_))
        .build

    def deleteAssessmentFrameworkRequest(
      frameworkId: Option[String] = None
    ): DeleteAssessmentFrameworkRequest =
      DeleteAssessmentFrameworkRequest
        .builder
        .ifSome(frameworkId)(_.frameworkId(_))
        .build

    def deleteAssessmentFrameworkResponse(

    ): DeleteAssessmentFrameworkResponse =
      DeleteAssessmentFrameworkResponse
        .builder

        .build

    def deleteAssessmentReportRequest(
      assessmentId: Option[String] = None,
      assessmentReportId: Option[String] = None
    ): DeleteAssessmentReportRequest =
      DeleteAssessmentReportRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(assessmentReportId)(_.assessmentReportId(_))
        .build

    def deleteAssessmentReportResponse(

    ): DeleteAssessmentReportResponse =
      DeleteAssessmentReportResponse
        .builder

        .build

    def deleteAssessmentRequest(
      assessmentId: Option[String] = None
    ): DeleteAssessmentRequest =
      DeleteAssessmentRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .build

    def deleteAssessmentResponse(

    ): DeleteAssessmentResponse =
      DeleteAssessmentResponse
        .builder

        .build

    def deleteControlRequest(
      controlId: Option[String] = None
    ): DeleteControlRequest =
      DeleteControlRequest
        .builder
        .ifSome(controlId)(_.controlId(_))
        .build

    def deleteControlResponse(

    ): DeleteControlResponse =
      DeleteControlResponse
        .builder

        .build

    def deregisterAccountRequest(

    ): DeregisterAccountRequest =
      DeregisterAccountRequest
        .builder

        .build

    def deregisterAccountResponse(
      status: Option[String] = None
    ): DeregisterAccountResponse =
      DeregisterAccountResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def deregisterOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): DeregisterOrganizationAdminAccountRequest =
      DeregisterOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def deregisterOrganizationAdminAccountResponse(

    ): DeregisterOrganizationAdminAccountResponse =
      DeregisterOrganizationAdminAccountResponse
        .builder

        .build

    def disassociateAssessmentReportEvidenceFolderRequest(
      assessmentId: Option[String] = None,
      evidenceFolderId: Option[String] = None
    ): DisassociateAssessmentReportEvidenceFolderRequest =
      DisassociateAssessmentReportEvidenceFolderRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .build

    def disassociateAssessmentReportEvidenceFolderResponse(

    ): DisassociateAssessmentReportEvidenceFolderResponse =
      DisassociateAssessmentReportEvidenceFolderResponse
        .builder

        .build

    def evidence(
      dataSource: Option[String] = None,
      evidenceAwsAccountId: Option[String] = None,
      time: Option[Timestamp] = None,
      eventSource: Option[String] = None,
      eventName: Option[String] = None,
      evidenceByType: Option[String] = None,
      resourcesIncluded: Option[List[Resource]] = None,
      attributes: Option[EvidenceAttributes] = None,
      iamId: Option[String] = None,
      complianceCheck: Option[String] = None,
      awsOrganization: Option[String] = None,
      awsAccountId: Option[String] = None,
      evidenceFolderId: Option[String] = None,
      id: Option[String] = None,
      assessmentReportSelection: Option[String] = None
    ): Evidence =
      Evidence
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(evidenceAwsAccountId)(_.evidenceAwsAccountId(_))
        .ifSome(time)(_.time(_))
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(eventName)(_.eventName(_))
        .ifSome(evidenceByType)(_.evidenceByType(_))
        .ifSome(resourcesIncluded)(_.resourcesIncluded(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(iamId)(_.iamId(_))
        .ifSome(complianceCheck)(_.complianceCheck(_))
        .ifSome(awsOrganization)(_.awsOrganization(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .ifSome(id)(_.id(_))
        .ifSome(assessmentReportSelection)(_.assessmentReportSelection(_))
        .build

    def framework(
      arn: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      complianceType: Option[String] = None,
      description: Option[String] = None,
      logo: Option[String] = None,
      controlSources: Option[String] = None,
      controlSets: Option[List[ControlSet]] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      lastUpdatedBy: Option[String] = None,
      tags: Option[TagMap] = None
    ): Framework =
      Framework
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(description)(_.description(_))
        .ifSome(logo)(_.logo(_))
        .ifSome(controlSources)(_.controlSources(_))
        .ifSome(controlSets)(_.controlSets(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def frameworkMetadata(
      name: Option[String] = None,
      description: Option[String] = None,
      logo: Option[String] = None,
      complianceType: Option[String] = None
    ): FrameworkMetadata =
      FrameworkMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(logo)(_.logo(_))
        .ifSome(complianceType)(_.complianceType(_))
        .build

    def getAccountStatusRequest(

    ): GetAccountStatusRequest =
      GetAccountStatusRequest
        .builder

        .build

    def getAccountStatusResponse(
      status: Option[String] = None
    ): GetAccountStatusResponse =
      GetAccountStatusResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def getAssessmentFrameworkRequest(
      frameworkId: Option[String] = None
    ): GetAssessmentFrameworkRequest =
      GetAssessmentFrameworkRequest
        .builder
        .ifSome(frameworkId)(_.frameworkId(_))
        .build

    def getAssessmentFrameworkResponse(
      framework: Option[Framework] = None
    ): GetAssessmentFrameworkResponse =
      GetAssessmentFrameworkResponse
        .builder
        .ifSome(framework)(_.framework(_))
        .build

    def getAssessmentReportUrlRequest(
      assessmentReportId: Option[String] = None,
      assessmentId: Option[String] = None
    ): GetAssessmentReportUrlRequest =
      GetAssessmentReportUrlRequest
        .builder
        .ifSome(assessmentReportId)(_.assessmentReportId(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .build

    def getAssessmentReportUrlResponse(
      preSignedUrl: Option[URL] = None
    ): GetAssessmentReportUrlResponse =
      GetAssessmentReportUrlResponse
        .builder
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .build

    def getAssessmentRequest(
      assessmentId: Option[String] = None
    ): GetAssessmentRequest =
      GetAssessmentRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .build

    def getAssessmentResponse(
      assessment: Option[Assessment] = None,
      userRole: Option[Role] = None
    ): GetAssessmentResponse =
      GetAssessmentResponse
        .builder
        .ifSome(assessment)(_.assessment(_))
        .ifSome(userRole)(_.userRole(_))
        .build

    def getChangeLogsRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      controlId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetChangeLogsRequest =
      GetChangeLogsRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(controlId)(_.controlId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getChangeLogsResponse(
      changeLogs: Option[List[ChangeLog]] = None,
      nextToken: Option[String] = None
    ): GetChangeLogsResponse =
      GetChangeLogsResponse
        .builder
        .ifSome(changeLogs)(_.changeLogs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getControlRequest(
      controlId: Option[String] = None
    ): GetControlRequest =
      GetControlRequest
        .builder
        .ifSome(controlId)(_.controlId(_))
        .build

    def getControlResponse(
      control: Option[Control] = None
    ): GetControlResponse =
      GetControlResponse
        .builder
        .ifSome(control)(_.control(_))
        .build

    def getDelegationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetDelegationsRequest =
      GetDelegationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getDelegationsResponse(
      delegations: Option[List[DelegationMetadata]] = None,
      nextToken: Option[String] = None
    ): GetDelegationsResponse =
      GetDelegationsResponse
        .builder
        .ifSome(delegations)(_.delegations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getEvidenceByEvidenceFolderRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      evidenceFolderId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEvidenceByEvidenceFolderRequest =
      GetEvidenceByEvidenceFolderRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEvidenceByEvidenceFolderResponse(
      evidence: Option[List[Evidence]] = None,
      nextToken: Option[String] = None
    ): GetEvidenceByEvidenceFolderResponse =
      GetEvidenceByEvidenceFolderResponse
        .builder
        .ifSome(evidence)(_.evidence(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getEvidenceFolderRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      evidenceFolderId: Option[String] = None
    ): GetEvidenceFolderRequest =
      GetEvidenceFolderRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .build

    def getEvidenceFolderResponse(
      evidenceFolder: Option[AssessmentEvidenceFolder] = None
    ): GetEvidenceFolderResponse =
      GetEvidenceFolderResponse
        .builder
        .ifSome(evidenceFolder)(_.evidenceFolder(_))
        .build

    def getEvidenceFoldersByAssessmentControlRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      controlId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEvidenceFoldersByAssessmentControlRequest =
      GetEvidenceFoldersByAssessmentControlRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(controlId)(_.controlId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEvidenceFoldersByAssessmentControlResponse(
      evidenceFolders: Option[List[AssessmentEvidenceFolder]] = None,
      nextToken: Option[String] = None
    ): GetEvidenceFoldersByAssessmentControlResponse =
      GetEvidenceFoldersByAssessmentControlResponse
        .builder
        .ifSome(evidenceFolders)(_.evidenceFolders(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getEvidenceFoldersByAssessmentRequest(
      assessmentId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEvidenceFoldersByAssessmentRequest =
      GetEvidenceFoldersByAssessmentRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEvidenceFoldersByAssessmentResponse(
      evidenceFolders: Option[List[AssessmentEvidenceFolder]] = None,
      nextToken: Option[String] = None
    ): GetEvidenceFoldersByAssessmentResponse =
      GetEvidenceFoldersByAssessmentResponse
        .builder
        .ifSome(evidenceFolders)(_.evidenceFolders(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getEvidenceRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      evidenceFolderId: Option[String] = None,
      evidenceId: Option[String] = None
    ): GetEvidenceRequest =
      GetEvidenceRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(evidenceFolderId)(_.evidenceFolderId(_))
        .ifSome(evidenceId)(_.evidenceId(_))
        .build

    def getEvidenceResponse(
      evidence: Option[Evidence] = None
    ): GetEvidenceResponse =
      GetEvidenceResponse
        .builder
        .ifSome(evidence)(_.evidence(_))
        .build

    def getOrganizationAdminAccountRequest(

    ): GetOrganizationAdminAccountRequest =
      GetOrganizationAdminAccountRequest
        .builder

        .build

    def getOrganizationAdminAccountResponse(
      adminAccountId: Option[String] = None,
      organizationId: Option[String] = None
    ): GetOrganizationAdminAccountResponse =
      GetOrganizationAdminAccountResponse
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def getServicesInScopeRequest(

    ): GetServicesInScopeRequest =
      GetServicesInScopeRequest
        .builder

        .build

    def getServicesInScopeResponse(
      serviceMetadata: Option[List[ServiceMetadata]] = None
    ): GetServicesInScopeResponse =
      GetServicesInScopeResponse
        .builder
        .ifSome(serviceMetadata)(_.serviceMetadata(_))
        .build

    def getSettingsRequest(
      attribute: Option[String] = None
    ): GetSettingsRequest =
      GetSettingsRequest
        .builder
        .ifSome(attribute)(_.attribute(_))
        .build

    def getSettingsResponse(
      settings: Option[Settings] = None
    ): GetSettingsResponse =
      GetSettingsResponse
        .builder
        .ifSome(settings)(_.settings(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAssessmentFrameworksRequest(
      frameworkType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentFrameworksRequest =
      ListAssessmentFrameworksRequest
        .builder
        .ifSome(frameworkType)(_.frameworkType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentFrameworksResponse(
      frameworkMetadataList: Option[List[AssessmentFrameworkMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentFrameworksResponse =
      ListAssessmentFrameworksResponse
        .builder
        .ifSome(frameworkMetadataList)(_.frameworkMetadataList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssessmentReportsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentReportsRequest =
      ListAssessmentReportsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentReportsResponse(
      assessmentReports: Option[List[AssessmentReportMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentReportsResponse =
      ListAssessmentReportsResponse
        .builder
        .ifSome(assessmentReports)(_.assessmentReports(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssessmentsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssessmentsRequest =
      ListAssessmentsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssessmentsResponse(
      assessmentMetadata: Option[List[AssessmentMetadataItem]] = None,
      nextToken: Option[String] = None
    ): ListAssessmentsResponse =
      ListAssessmentsResponse
        .builder
        .ifSome(assessmentMetadata)(_.assessmentMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listControlsRequest(
      controlType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListControlsRequest =
      ListControlsRequest
        .builder
        .ifSome(controlType)(_.controlType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listControlsResponse(
      controlMetadataList: Option[List[ControlMetadata]] = None,
      nextToken: Option[String] = None
    ): ListControlsResponse =
      ListControlsResponse
        .builder
        .ifSome(controlMetadataList)(_.controlMetadataList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listKeywordsForDataSourceRequest(
      source: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListKeywordsForDataSourceRequest =
      ListKeywordsForDataSourceRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listKeywordsForDataSourceResponse(
      keywords: Option[List[KeywordValue]] = None,
      nextToken: Option[String] = None
    ): ListKeywordsForDataSourceResponse =
      ListKeywordsForDataSourceResponse
        .builder
        .ifSome(keywords)(_.keywords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNotificationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListNotificationsRequest =
      ListNotificationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listNotificationsResponse(
      notifications: Option[List[Notification]] = None,
      nextToken: Option[String] = None
    ): ListNotificationsResponse =
      ListNotificationsResponse
        .builder
        .ifSome(notifications)(_.notifications(_))
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

    def manualEvidence(
      s3ResourcePath: Option[String] = None
    ): ManualEvidence =
      ManualEvidence
        .builder
        .ifSome(s3ResourcePath)(_.s3ResourcePath(_))
        .build

    def notification(
      id: Option[String] = None,
      assessmentId: Option[String] = None,
      assessmentName: Option[String] = None,
      controlSetId: Option[String] = None,
      controlSetName: Option[String] = None,
      description: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      source: Option[String] = None
    ): Notification =
      Notification
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(assessmentName)(_.assessmentName(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(controlSetName)(_.controlSetName(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(source)(_.source(_))
        .build

    def registerAccountRequest(
      kmsKey: Option[String] = None,
      delegatedAdminAccount: Option[String] = None
    ): RegisterAccountRequest =
      RegisterAccountRequest
        .builder
        .ifSome(kmsKey)(_.kmsKey(_))
        .ifSome(delegatedAdminAccount)(_.delegatedAdminAccount(_))
        .build

    def registerAccountResponse(
      status: Option[String] = None
    ): RegisterAccountResponse =
      RegisterAccountResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def registerOrganizationAdminAccountRequest(
      adminAccountId: Option[String] = None
    ): RegisterOrganizationAdminAccountRequest =
      RegisterOrganizationAdminAccountRequest
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .build

    def registerOrganizationAdminAccountResponse(
      adminAccountId: Option[String] = None,
      organizationId: Option[String] = None
    ): RegisterOrganizationAdminAccountResponse =
      RegisterOrganizationAdminAccountResponse
        .builder
        .ifSome(adminAccountId)(_.adminAccountId(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def resource(
      arn: Option[String] = None,
      value: Option[String] = None
    ): Resource =
      Resource
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(value)(_.value(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def role(
      roleType: Option[String] = None,
      roleArn: Option[String] = None
    ): Role =
      Role
        .builder
        .ifSome(roleType)(_.roleType(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def scope(
      awsAccounts: Option[List[AWSAccount]] = None,
      awsServices: Option[List[AWSService]] = None
    ): Scope =
      Scope
        .builder
        .ifSome(awsAccounts)(_.awsAccounts(_))
        .ifSome(awsServices)(_.awsServices(_))
        .build

    def serviceMetadata(
      name: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      category: Option[String] = None
    ): ServiceMetadata =
      ServiceMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(category)(_.category(_))
        .build

    def settings(
      isAwsOrgEnabled: Option[Boolean] = None,
      snsTopic: Option[String] = None,
      defaultAssessmentReportsDestination: Option[AssessmentReportsDestination] = None,
      defaultProcessOwners: Option[List[Role]] = None,
      kmsKey: Option[String] = None
    ): Settings =
      Settings
        .builder
        .ifSome(isAwsOrgEnabled)(_.isAwsOrgEnabled(_))
        .ifSome(snsTopic)(_.snsTopic(_))
        .ifSome(defaultAssessmentReportsDestination)(_.defaultAssessmentReportsDestination(_))
        .ifSome(defaultProcessOwners)(_.defaultProcessOwners(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .build

    def sourceKeyword(
      keywordInputType: Option[String] = None,
      keywordValue: Option[String] = None
    ): SourceKeyword =
      SourceKeyword
        .builder
        .ifSome(keywordInputType)(_.keywordInputType(_))
        .ifSome(keywordValue)(_.keywordValue(_))
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

    def uRL(
      hyperlinkName: Option[String] = None,
      link: Option[String] = None
    ): URL =
      URL
        .builder
        .ifSome(hyperlinkName)(_.hyperlinkName(_))
        .ifSome(link)(_.link(_))
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

    def updateAssessmentControlRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      controlId: Option[String] = None,
      controlStatus: Option[String] = None,
      commentBody: Option[String] = None
    ): UpdateAssessmentControlRequest =
      UpdateAssessmentControlRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(controlId)(_.controlId(_))
        .ifSome(controlStatus)(_.controlStatus(_))
        .ifSome(commentBody)(_.commentBody(_))
        .build

    def updateAssessmentControlResponse(
      control: Option[AssessmentControl] = None
    ): UpdateAssessmentControlResponse =
      UpdateAssessmentControlResponse
        .builder
        .ifSome(control)(_.control(_))
        .build

    def updateAssessmentControlSetStatusRequest(
      assessmentId: Option[String] = None,
      controlSetId: Option[String] = None,
      status: Option[String] = None,
      comment: Option[String] = None
    ): UpdateAssessmentControlSetStatusRequest =
      UpdateAssessmentControlSetStatusRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(controlSetId)(_.controlSetId(_))
        .ifSome(status)(_.status(_))
        .ifSome(comment)(_.comment(_))
        .build

    def updateAssessmentControlSetStatusResponse(
      controlSet: Option[AssessmentControlSet] = None
    ): UpdateAssessmentControlSetStatusResponse =
      UpdateAssessmentControlSetStatusResponse
        .builder
        .ifSome(controlSet)(_.controlSet(_))
        .build

    def updateAssessmentFrameworkControlSet(
      id: Option[String] = None,
      name: Option[String] = None,
      controls: Option[List[CreateAssessmentFrameworkControl]] = None
    ): UpdateAssessmentFrameworkControlSet =
      UpdateAssessmentFrameworkControlSet
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(controls)(_.controls(_))
        .build

    def updateAssessmentFrameworkRequest(
      frameworkId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      complianceType: Option[String] = None,
      controlSets: Option[List[UpdateAssessmentFrameworkControlSet]] = None
    ): UpdateAssessmentFrameworkRequest =
      UpdateAssessmentFrameworkRequest
        .builder
        .ifSome(frameworkId)(_.frameworkId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(complianceType)(_.complianceType(_))
        .ifSome(controlSets)(_.controlSets(_))
        .build

    def updateAssessmentFrameworkResponse(
      framework: Option[Framework] = None
    ): UpdateAssessmentFrameworkResponse =
      UpdateAssessmentFrameworkResponse
        .builder
        .ifSome(framework)(_.framework(_))
        .build

    def updateAssessmentRequest(
      assessmentId: Option[String] = None,
      assessmentName: Option[String] = None,
      assessmentDescription: Option[String] = None,
      scope: Option[Scope] = None,
      assessmentReportsDestination: Option[AssessmentReportsDestination] = None,
      roles: Option[List[Role]] = None
    ): UpdateAssessmentRequest =
      UpdateAssessmentRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(assessmentName)(_.assessmentName(_))
        .ifSome(assessmentDescription)(_.assessmentDescription(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(assessmentReportsDestination)(_.assessmentReportsDestination(_))
        .ifSome(roles)(_.roles(_))
        .build

    def updateAssessmentResponse(
      assessment: Option[Assessment] = None
    ): UpdateAssessmentResponse =
      UpdateAssessmentResponse
        .builder
        .ifSome(assessment)(_.assessment(_))
        .build

    def updateAssessmentStatusRequest(
      assessmentId: Option[String] = None,
      status: Option[String] = None
    ): UpdateAssessmentStatusRequest =
      UpdateAssessmentStatusRequest
        .builder
        .ifSome(assessmentId)(_.assessmentId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAssessmentStatusResponse(
      assessment: Option[Assessment] = None
    ): UpdateAssessmentStatusResponse =
      UpdateAssessmentStatusResponse
        .builder
        .ifSome(assessment)(_.assessment(_))
        .build

    def updateControlRequest(
      controlId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      testingInformation: Option[String] = None,
      actionPlanTitle: Option[String] = None,
      actionPlanInstructions: Option[String] = None,
      controlMappingSources: Option[List[ControlMappingSource]] = None
    ): UpdateControlRequest =
      UpdateControlRequest
        .builder
        .ifSome(controlId)(_.controlId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(testingInformation)(_.testingInformation(_))
        .ifSome(actionPlanTitle)(_.actionPlanTitle(_))
        .ifSome(actionPlanInstructions)(_.actionPlanInstructions(_))
        .ifSome(controlMappingSources)(_.controlMappingSources(_))
        .build

    def updateControlResponse(
      control: Option[Control] = None
    ): UpdateControlResponse =
      UpdateControlResponse
        .builder
        .ifSome(control)(_.control(_))
        .build

    def updateSettingsRequest(
      snsTopic: Option[String] = None,
      defaultAssessmentReportsDestination: Option[AssessmentReportsDestination] = None,
      defaultProcessOwners: Option[List[Role]] = None,
      kmsKey: Option[String] = None
    ): UpdateSettingsRequest =
      UpdateSettingsRequest
        .builder
        .ifSome(snsTopic)(_.snsTopic(_))
        .ifSome(defaultAssessmentReportsDestination)(_.defaultAssessmentReportsDestination(_))
        .ifSome(defaultProcessOwners)(_.defaultProcessOwners(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .build

    def updateSettingsResponse(
      settings: Option[Settings] = None
    ): UpdateSettingsResponse =
      UpdateSettingsResponse
        .builder
        .ifSome(settings)(_.settings(_))
        .build

    def validateAssessmentReportIntegrityRequest(
      s3RelativePath: Option[String] = None
    ): ValidateAssessmentReportIntegrityRequest =
      ValidateAssessmentReportIntegrityRequest
        .builder
        .ifSome(s3RelativePath)(_.s3RelativePath(_))
        .build

    def validateAssessmentReportIntegrityResponse(
      signatureValid: Option[Boolean] = None,
      signatureAlgorithm: Option[String] = None,
      signatureDateTime: Option[String] = None,
      signatureKeyId: Option[String] = None,
      validationErrors: Option[List[NonEmptyString]] = None
    ): ValidateAssessmentReportIntegrityResponse =
      ValidateAssessmentReportIntegrityResponse
        .builder
        .ifSome(signatureValid)(_.signatureValid(_))
        .ifSome(signatureAlgorithm)(_.signatureAlgorithm(_))
        .ifSome(signatureDateTime)(_.signatureDateTime(_))
        .ifSome(signatureKeyId)(_.signatureKeyId(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None,
      fields: Option[List[ValidationExceptionField]] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(fields)(_.fields(_))
        .build

    def validationExceptionField(
      name: Option[String] = None,
      message: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
