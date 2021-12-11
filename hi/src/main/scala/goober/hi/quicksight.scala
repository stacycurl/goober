package goober.hi

import goober.free.quicksight.QuickSightIO
import software.amazon.awssdk.services.quicksight.model._


object quicksight {
  import goober.free.{quicksight ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def accountCustomization(
      defaultTheme: Option[String] = None
    ): AccountCustomization =
      AccountCustomization
        .builder
        .ifSome(defaultTheme)(_.defaultTheme(_))
        .build

    def accountSettings(
      accountName: Option[String] = None,
      edition: Option[String] = None,
      defaultNamespace: Option[String] = None,
      notificationEmail: Option[String] = None
    ): AccountSettings =
      AccountSettings
        .builder
        .ifSome(accountName)(_.accountName(_))
        .ifSome(edition)(_.edition(_))
        .ifSome(defaultNamespace)(_.defaultNamespace(_))
        .ifSome(notificationEmail)(_.notificationEmail(_))
        .build

    def activeIAMPolicyAssignment(
      assignmentName: Option[String] = None,
      policyArn: Option[String] = None
    ): ActiveIAMPolicyAssignment =
      ActiveIAMPolicyAssignment
        .builder
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def adHocFilteringOption(
      availabilityStatus: Option[String] = None
    ): AdHocFilteringOption =
      AdHocFilteringOption
        .builder
        .ifSome(availabilityStatus)(_.availabilityStatus(_))
        .build

    def amazonElasticsearchParameters(
      domain: Option[String] = None
    ): AmazonElasticsearchParameters =
      AmazonElasticsearchParameters
        .builder
        .ifSome(domain)(_.domain(_))
        .build

    def analysis(
      analysisId: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      errors: Option[List[AnalysisError]] = None,
      dataSetArns: Option[List[Arn]] = None,
      themeArn: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      sheets: Option[List[Sheet]] = None
    ): Analysis =
      Analysis
        .builder
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(dataSetArns)(_.dataSetArns(_))
        .ifSome(themeArn)(_.themeArn(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(sheets)(_.sheets(_))
        .build

    def analysisError(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): AnalysisError =
      AnalysisError
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def analysisSearchFilter(
      operator: Option[String] = None,
      name: Option[String] = None,
      value: Option[String] = None
    ): AnalysisSearchFilter =
      AnalysisSearchFilter
        .builder
        .ifSome(operator)(_.operator(_))
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def analysisSourceEntity(
      sourceTemplate: Option[AnalysisSourceTemplate] = None
    ): AnalysisSourceEntity =
      AnalysisSourceEntity
        .builder
        .ifSome(sourceTemplate)(_.sourceTemplate(_))
        .build

    def analysisSourceTemplate(
      dataSetReferences: Option[List[DataSetReference]] = None,
      arn: Option[String] = None
    ): AnalysisSourceTemplate =
      AnalysisSourceTemplate
        .builder
        .ifSome(dataSetReferences)(_.dataSetReferences(_))
        .ifSome(arn)(_.arn(_))
        .build

    def analysisSummary(
      arn: Option[String] = None,
      analysisId: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): AnalysisSummary =
      AnalysisSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def athenaParameters(
      workGroup: Option[String] = None
    ): AthenaParameters =
      AthenaParameters
        .builder
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def auroraParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): AuroraParameters =
      AuroraParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def auroraPostgreSqlParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): AuroraPostgreSqlParameters =
      AuroraPostgreSqlParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def awsIotAnalyticsParameters(
      dataSetName: Option[String] = None
    ): AwsIotAnalyticsParameters =
      AwsIotAnalyticsParameters
        .builder
        .ifSome(dataSetName)(_.dataSetName(_))
        .build

    def borderStyle(
      show: Option[Boolean] = None
    ): BorderStyle =
      BorderStyle
        .builder
        .ifSome(show)(_.show(_))
        .build

    def calculatedColumn(
      columnName: Option[String] = None,
      columnId: Option[String] = None,
      expression: Option[String] = None
    ): CalculatedColumn =
      CalculatedColumn
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(columnId)(_.columnId(_))
        .ifSome(expression)(_.expression(_))
        .build

    def cancelIngestionRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None,
      ingestionId: Option[String] = None
    ): CancelIngestionRequest =
      CancelIngestionRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .build

    def cancelIngestionResponse(
      arn: Option[String] = None,
      ingestionId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CancelIngestionResponse =
      CancelIngestionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def castColumnTypeOperation(
      columnName: Option[String] = None,
      newColumnType: Option[String] = None,
      format: Option[String] = None
    ): CastColumnTypeOperation =
      CastColumnTypeOperation
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(newColumnType)(_.newColumnType(_))
        .ifSome(format)(_.format(_))
        .build

    def columnDescription(
      text: Option[String] = None
    ): ColumnDescription =
      ColumnDescription
        .builder
        .ifSome(text)(_.text(_))
        .build

    def columnGroup(
      geoSpatialColumnGroup: Option[GeoSpatialColumnGroup] = None
    ): ColumnGroup =
      ColumnGroup
        .builder
        .ifSome(geoSpatialColumnGroup)(_.geoSpatialColumnGroup(_))
        .build

    def columnGroupColumnSchema(
      name: Option[String] = None
    ): ColumnGroupColumnSchema =
      ColumnGroupColumnSchema
        .builder
        .ifSome(name)(_.name(_))
        .build

    def columnGroupSchema(
      name: Option[String] = None,
      columnGroupColumnSchemaList: Option[List[ColumnGroupColumnSchema]] = None
    ): ColumnGroupSchema =
      ColumnGroupSchema
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(columnGroupColumnSchemaList)(_.columnGroupColumnSchemaList(_))
        .build

    def columnLevelPermissionRule(
      principals: Option[List[String]] = None,
      columnNames: Option[List[String]] = None
    ): ColumnLevelPermissionRule =
      ColumnLevelPermissionRule
        .builder
        .ifSome(principals)(_.principals(_))
        .ifSome(columnNames)(_.columnNames(_))
        .build

    def columnSchema(
      name: Option[String] = None,
      dataType: Option[String] = None,
      geographicRole: Option[String] = None
    ): ColumnSchema =
      ColumnSchema
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(geographicRole)(_.geographicRole(_))
        .build

    def columnTag(
      columnGeographicRole: Option[String] = None,
      columnDescription: Option[ColumnDescription] = None
    ): ColumnTag =
      ColumnTag
        .builder
        .ifSome(columnGeographicRole)(_.columnGeographicRole(_))
        .ifSome(columnDescription)(_.columnDescription(_))
        .build

    def concurrentUpdatingException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ConcurrentUpdatingException =
      ConcurrentUpdatingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def conflictException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createAccountCustomizationRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      accountCustomization: Option[AccountCustomization] = None,
      tags: Option[List[Tag]] = None
    ): CreateAccountCustomizationRequest =
      CreateAccountCustomizationRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(accountCustomization)(_.accountCustomization(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAccountCustomizationResponse(
      arn: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      accountCustomization: Option[AccountCustomization] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateAccountCustomizationResponse =
      CreateAccountCustomizationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(accountCustomization)(_.accountCustomization(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createAnalysisRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None,
      name: Option[String] = None,
      parameters: Option[Parameters] = None,
      permissions: Option[List[ResourcePermission]] = None,
      sourceEntity: Option[AnalysisSourceEntity] = None,
      themeArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAnalysisRequest =
      CreateAnalysisRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(name)(_.name(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(sourceEntity)(_.sourceEntity(_))
        .ifSome(themeArn)(_.themeArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAnalysisResponse(
      arn: Option[String] = None,
      analysisId: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): CreateAnalysisResponse =
      CreateAnalysisResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createColumnsOperation(
      columns: Option[List[CalculatedColumn]] = None
    ): CreateColumnsOperation =
      CreateColumnsOperation
        .builder
        .ifSome(columns)(_.columns(_))
        .build

    def createDashboardRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      name: Option[String] = None,
      parameters: Option[Parameters] = None,
      permissions: Option[List[ResourcePermission]] = None,
      sourceEntity: Option[DashboardSourceEntity] = None,
      tags: Option[List[Tag]] = None,
      versionDescription: Option[String] = None,
      dashboardPublishOptions: Option[DashboardPublishOptions] = None,
      themeArn: Option[String] = None
    ): CreateDashboardRequest =
      CreateDashboardRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(name)(_.name(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(sourceEntity)(_.sourceEntity(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(dashboardPublishOptions)(_.dashboardPublishOptions(_))
        .ifSome(themeArn)(_.themeArn(_))
        .build

    def createDashboardResponse(
      arn: Option[String] = None,
      versionArn: Option[String] = None,
      dashboardId: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): CreateDashboardResponse =
      CreateDashboardResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(versionArn)(_.versionArn(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createDataSetRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None,
      name: Option[String] = None,
      physicalTableMap: Option[PhysicalTableMap] = None,
      logicalTableMap: Option[LogicalTableMap] = None,
      importMode: Option[String] = None,
      columnGroups: Option[List[ColumnGroup]] = None,
      fieldFolders: Option[FieldFolderMap] = None,
      permissions: Option[List[ResourcePermission]] = None,
      rowLevelPermissionDataSet: Option[RowLevelPermissionDataSet] = None,
      columnLevelPermissionRules: Option[List[ColumnLevelPermissionRule]] = None,
      tags: Option[List[Tag]] = None
    ): CreateDataSetRequest =
      CreateDataSetRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(physicalTableMap)(_.physicalTableMap(_))
        .ifSome(logicalTableMap)(_.logicalTableMap(_))
        .ifSome(importMode)(_.importMode(_))
        .ifSome(columnGroups)(_.columnGroups(_))
        .ifSome(fieldFolders)(_.fieldFolders(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(rowLevelPermissionDataSet)(_.rowLevelPermissionDataSet(_))
        .ifSome(columnLevelPermissionRules)(_.columnLevelPermissionRules(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataSetResponse(
      arn: Option[String] = None,
      dataSetId: Option[String] = None,
      ingestionArn: Option[String] = None,
      ingestionId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateDataSetResponse =
      CreateDataSetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(ingestionArn)(_.ingestionArn(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createDataSourceRequest(
      awsAccountId: Option[String] = None,
      dataSourceId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      dataSourceParameters: Option[DataSourceParameters] = None,
      credentials: Option[DataSourceCredentials] = None,
      permissions: Option[List[ResourcePermission]] = None,
      vpcConnectionProperties: Option[VpcConnectionProperties] = None,
      sslProperties: Option[SslProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateDataSourceRequest =
      CreateDataSourceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(dataSourceParameters)(_.dataSourceParameters(_))
        .ifSome(credentials)(_.credentials(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(vpcConnectionProperties)(_.vpcConnectionProperties(_))
        .ifSome(sslProperties)(_.sslProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataSourceResponse(
      arn: Option[String] = None,
      dataSourceId: Option[String] = None,
      creationStatus: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateDataSourceResponse =
      CreateDataSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createGroupMembershipRequest(
      memberName: Option[String] = None,
      groupName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): CreateGroupMembershipRequest =
      CreateGroupMembershipRequest
        .builder
        .ifSome(memberName)(_.memberName(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def createGroupMembershipResponse(
      groupMember: Option[GroupMember] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateGroupMembershipResponse =
      CreateGroupMembershipResponse
        .builder
        .ifSome(groupMember)(_.groupMember(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createGroupRequest(
      groupName: Option[String] = None,
      description: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): CreateGroupRequest =
      CreateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def createGroupResponse(
      group: Option[Group] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateGroupResponse =
      CreateGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createIAMPolicyAssignmentRequest(
      awsAccountId: Option[String] = None,
      assignmentName: Option[String] = None,
      assignmentStatus: Option[String] = None,
      policyArn: Option[String] = None,
      identities: Option[IdentityMap] = None,
      namespace: Option[String] = None
    ): CreateIAMPolicyAssignmentRequest =
      CreateIAMPolicyAssignmentRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(identities)(_.identities(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def createIAMPolicyAssignmentResponse(
      assignmentName: Option[String] = None,
      assignmentId: Option[String] = None,
      assignmentStatus: Option[String] = None,
      policyArn: Option[String] = None,
      identities: Option[IdentityMap] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateIAMPolicyAssignmentResponse =
      CreateIAMPolicyAssignmentResponse
        .builder
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(identities)(_.identities(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createIngestionRequest(
      dataSetId: Option[String] = None,
      ingestionId: Option[String] = None,
      awsAccountId: Option[String] = None
    ): CreateIngestionRequest =
      CreateIngestionRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .build

    def createIngestionResponse(
      arn: Option[String] = None,
      ingestionId: Option[String] = None,
      ingestionStatus: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateIngestionResponse =
      CreateIngestionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .ifSome(ingestionStatus)(_.ingestionStatus(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createNamespaceRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      identityStore: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateNamespaceRequest =
      CreateNamespaceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(identityStore)(_.identityStore(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createNamespaceResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      capacityRegion: Option[String] = None,
      creationStatus: Option[String] = None,
      identityStore: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): CreateNamespaceResponse =
      CreateNamespaceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(capacityRegion)(_.capacityRegion(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(identityStore)(_.identityStore(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def createTemplateAliasRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      aliasName: Option[String] = None,
      templateVersionNumber: Option[VersionNumber] = None
    ): CreateTemplateAliasRequest =
      CreateTemplateAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(templateVersionNumber)(_.templateVersionNumber(_))
        .build

    def createTemplateAliasResponse(
      templateAlias: Option[TemplateAlias] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): CreateTemplateAliasResponse =
      CreateTemplateAliasResponse
        .builder
        .ifSome(templateAlias)(_.templateAlias(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createTemplateRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      name: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      sourceEntity: Option[TemplateSourceEntity] = None,
      tags: Option[List[Tag]] = None,
      versionDescription: Option[String] = None
    ): CreateTemplateRequest =
      CreateTemplateRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(name)(_.name(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(sourceEntity)(_.sourceEntity(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .build

    def createTemplateResponse(
      arn: Option[String] = None,
      versionArn: Option[String] = None,
      templateId: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): CreateTemplateResponse =
      CreateTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(versionArn)(_.versionArn(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createThemeAliasRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      aliasName: Option[String] = None,
      themeVersionNumber: Option[VersionNumber] = None
    ): CreateThemeAliasRequest =
      CreateThemeAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(themeVersionNumber)(_.themeVersionNumber(_))
        .build

    def createThemeAliasResponse(
      themeAlias: Option[ThemeAlias] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): CreateThemeAliasResponse =
      CreateThemeAliasResponse
        .builder
        .ifSome(themeAlias)(_.themeAlias(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createThemeRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      name: Option[String] = None,
      baseThemeId: Option[String] = None,
      versionDescription: Option[String] = None,
      configuration: Option[ThemeConfiguration] = None,
      permissions: Option[List[ResourcePermission]] = None,
      tags: Option[List[Tag]] = None
    ): CreateThemeRequest =
      CreateThemeRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(name)(_.name(_))
        .ifSome(baseThemeId)(_.baseThemeId(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createThemeResponse(
      arn: Option[String] = None,
      versionArn: Option[String] = None,
      themeId: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): CreateThemeResponse =
      CreateThemeResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(versionArn)(_.versionArn(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def credentialPair(
      username: Option[String] = None,
      password: Option[String] = None,
      alternateDataSourceParameters: Option[List[DataSourceParameters]] = None
    ): CredentialPair =
      CredentialPair
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(alternateDataSourceParameters)(_.alternateDataSourceParameters(_))
        .build

    def customSql(
      dataSourceArn: Option[String] = None,
      name: Option[String] = None,
      sqlQuery: Option[String] = None,
      columns: Option[List[InputColumn]] = None
    ): CustomSql =
      CustomSql
        .builder
        .ifSome(dataSourceArn)(_.dataSourceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(sqlQuery)(_.sqlQuery(_))
        .ifSome(columns)(_.columns(_))
        .build

    def dashboard(
      dashboardId: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[DashboardVersion] = None,
      createdTime: Option[Timestamp] = None,
      lastPublishedTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): Dashboard =
      Dashboard
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastPublishedTime)(_.lastPublishedTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def dashboardError(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): DashboardError =
      DashboardError
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def dashboardPublishOptions(
      adHocFilteringOption: Option[AdHocFilteringOption] = None,
      exportToCSVOption: Option[ExportToCSVOption] = None,
      sheetControlsOption: Option[SheetControlsOption] = None
    ): DashboardPublishOptions =
      DashboardPublishOptions
        .builder
        .ifSome(adHocFilteringOption)(_.adHocFilteringOption(_))
        .ifSome(exportToCSVOption)(_.exportToCSVOption(_))
        .ifSome(sheetControlsOption)(_.sheetControlsOption(_))
        .build

    def dashboardSearchFilter(
      operator: Option[String] = None,
      name: Option[String] = None,
      value: Option[String] = None
    ): DashboardSearchFilter =
      DashboardSearchFilter
        .builder
        .ifSome(operator)(_.operator(_))
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def dashboardSourceEntity(
      sourceTemplate: Option[DashboardSourceTemplate] = None
    ): DashboardSourceEntity =
      DashboardSourceEntity
        .builder
        .ifSome(sourceTemplate)(_.sourceTemplate(_))
        .build

    def dashboardSourceTemplate(
      dataSetReferences: Option[List[DataSetReference]] = None,
      arn: Option[String] = None
    ): DashboardSourceTemplate =
      DashboardSourceTemplate
        .builder
        .ifSome(dataSetReferences)(_.dataSetReferences(_))
        .ifSome(arn)(_.arn(_))
        .build

    def dashboardSummary(
      arn: Option[String] = None,
      dashboardId: Option[String] = None,
      name: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      publishedVersionNumber: Option[VersionNumber] = None,
      lastPublishedTime: Option[Timestamp] = None
    ): DashboardSummary =
      DashboardSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(publishedVersionNumber)(_.publishedVersionNumber(_))
        .ifSome(lastPublishedTime)(_.lastPublishedTime(_))
        .build

    def dashboardVersion(
      createdTime: Option[Timestamp] = None,
      errors: Option[List[DashboardError]] = None,
      versionNumber: Option[VersionNumber] = None,
      status: Option[String] = None,
      arn: Option[String] = None,
      sourceEntityArn: Option[String] = None,
      dataSetArns: Option[List[Arn]] = None,
      description: Option[String] = None,
      themeArn: Option[String] = None,
      sheets: Option[List[Sheet]] = None
    ): DashboardVersion =
      DashboardVersion
        .builder
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(sourceEntityArn)(_.sourceEntityArn(_))
        .ifSome(dataSetArns)(_.dataSetArns(_))
        .ifSome(description)(_.description(_))
        .ifSome(themeArn)(_.themeArn(_))
        .ifSome(sheets)(_.sheets(_))
        .build

    def dashboardVersionSummary(
      arn: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      versionNumber: Option[VersionNumber] = None,
      status: Option[String] = None,
      sourceEntityArn: Option[String] = None,
      description: Option[String] = None
    ): DashboardVersionSummary =
      DashboardVersionSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(sourceEntityArn)(_.sourceEntityArn(_))
        .ifSome(description)(_.description(_))
        .build

    def dataColorPalette(
      colors: Option[List[HexColor]] = None,
      minMaxGradient: Option[List[HexColor]] = None,
      emptyFillColor: Option[String] = None
    ): DataColorPalette =
      DataColorPalette
        .builder
        .ifSome(colors)(_.colors(_))
        .ifSome(minMaxGradient)(_.minMaxGradient(_))
        .ifSome(emptyFillColor)(_.emptyFillColor(_))
        .build

    def dataSet(
      arn: Option[String] = None,
      dataSetId: Option[String] = None,
      name: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      physicalTableMap: Option[PhysicalTableMap] = None,
      logicalTableMap: Option[LogicalTableMap] = None,
      outputColumns: Option[List[OutputColumn]] = None,
      importMode: Option[String] = None,
      consumedSpiceCapacityInBytes: Option[Long] = None,
      columnGroups: Option[List[ColumnGroup]] = None,
      fieldFolders: Option[FieldFolderMap] = None,
      rowLevelPermissionDataSet: Option[RowLevelPermissionDataSet] = None,
      columnLevelPermissionRules: Option[List[ColumnLevelPermissionRule]] = None
    ): DataSet =
      DataSet
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(physicalTableMap)(_.physicalTableMap(_))
        .ifSome(logicalTableMap)(_.logicalTableMap(_))
        .ifSome(outputColumns)(_.outputColumns(_))
        .ifSome(importMode)(_.importMode(_))
        .ifSome(consumedSpiceCapacityInBytes)(_.consumedSpiceCapacityInBytes(_))
        .ifSome(columnGroups)(_.columnGroups(_))
        .ifSome(fieldFolders)(_.fieldFolders(_))
        .ifSome(rowLevelPermissionDataSet)(_.rowLevelPermissionDataSet(_))
        .ifSome(columnLevelPermissionRules)(_.columnLevelPermissionRules(_))
        .build

    def dataSetConfiguration(
      placeholder: Option[String] = None,
      dataSetSchema: Option[DataSetSchema] = None,
      columnGroupSchemaList: Option[List[ColumnGroupSchema]] = None
    ): DataSetConfiguration =
      DataSetConfiguration
        .builder
        .ifSome(placeholder)(_.placeholder(_))
        .ifSome(dataSetSchema)(_.dataSetSchema(_))
        .ifSome(columnGroupSchemaList)(_.columnGroupSchemaList(_))
        .build

    def dataSetReference(
      dataSetPlaceholder: Option[String] = None,
      dataSetArn: Option[String] = None
    ): DataSetReference =
      DataSetReference
        .builder
        .ifSome(dataSetPlaceholder)(_.dataSetPlaceholder(_))
        .ifSome(dataSetArn)(_.dataSetArn(_))
        .build

    def dataSetSchema(
      columnSchemaList: Option[List[ColumnSchema]] = None
    ): DataSetSchema =
      DataSetSchema
        .builder
        .ifSome(columnSchemaList)(_.columnSchemaList(_))
        .build

    def dataSetSummary(
      arn: Option[String] = None,
      dataSetId: Option[String] = None,
      name: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      importMode: Option[String] = None,
      rowLevelPermissionDataSet: Option[RowLevelPermissionDataSet] = None,
      columnLevelPermissionRulesApplied: Option[Boolean] = None
    ): DataSetSummary =
      DataSetSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(importMode)(_.importMode(_))
        .ifSome(rowLevelPermissionDataSet)(_.rowLevelPermissionDataSet(_))
        .ifSome(columnLevelPermissionRulesApplied)(_.columnLevelPermissionRulesApplied(_))
        .build

    def dataSource(
      arn: Option[String] = None,
      dataSourceId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      dataSourceParameters: Option[DataSourceParameters] = None,
      alternateDataSourceParameters: Option[List[DataSourceParameters]] = None,
      vpcConnectionProperties: Option[VpcConnectionProperties] = None,
      sslProperties: Option[SslProperties] = None,
      errorInfo: Option[DataSourceErrorInfo] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(dataSourceParameters)(_.dataSourceParameters(_))
        .ifSome(alternateDataSourceParameters)(_.alternateDataSourceParameters(_))
        .ifSome(vpcConnectionProperties)(_.vpcConnectionProperties(_))
        .ifSome(sslProperties)(_.sslProperties(_))
        .ifSome(errorInfo)(_.errorInfo(_))
        .build

    def dataSourceCredentials(
      credentialPair: Option[CredentialPair] = None,
      copySourceArn: Option[String] = None
    ): DataSourceCredentials =
      DataSourceCredentials
        .builder
        .ifSome(credentialPair)(_.credentialPair(_))
        .ifSome(copySourceArn)(_.copySourceArn(_))
        .build

    def dataSourceErrorInfo(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): DataSourceErrorInfo =
      DataSourceErrorInfo
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def dataSourceParameters(
      amazonElasticsearchParameters: Option[AmazonElasticsearchParameters] = None,
      athenaParameters: Option[AthenaParameters] = None,
      auroraParameters: Option[AuroraParameters] = None,
      auroraPostgreSqlParameters: Option[AuroraPostgreSqlParameters] = None,
      awsIotAnalyticsParameters: Option[AwsIotAnalyticsParameters] = None,
      jiraParameters: Option[JiraParameters] = None,
      mariaDbParameters: Option[MariaDbParameters] = None,
      mySqlParameters: Option[MySqlParameters] = None,
      oracleParameters: Option[OracleParameters] = None,
      postgreSqlParameters: Option[PostgreSqlParameters] = None,
      prestoParameters: Option[PrestoParameters] = None,
      rdsParameters: Option[RdsParameters] = None,
      redshiftParameters: Option[RedshiftParameters] = None,
      s3Parameters: Option[S3Parameters] = None,
      serviceNowParameters: Option[ServiceNowParameters] = None,
      snowflakeParameters: Option[SnowflakeParameters] = None,
      sparkParameters: Option[SparkParameters] = None,
      sqlServerParameters: Option[SqlServerParameters] = None,
      teradataParameters: Option[TeradataParameters] = None,
      twitterParameters: Option[TwitterParameters] = None
    ): DataSourceParameters =
      DataSourceParameters
        .builder
        .ifSome(amazonElasticsearchParameters)(_.amazonElasticsearchParameters(_))
        .ifSome(athenaParameters)(_.athenaParameters(_))
        .ifSome(auroraParameters)(_.auroraParameters(_))
        .ifSome(auroraPostgreSqlParameters)(_.auroraPostgreSqlParameters(_))
        .ifSome(awsIotAnalyticsParameters)(_.awsIotAnalyticsParameters(_))
        .ifSome(jiraParameters)(_.jiraParameters(_))
        .ifSome(mariaDbParameters)(_.mariaDbParameters(_))
        .ifSome(mySqlParameters)(_.mySqlParameters(_))
        .ifSome(oracleParameters)(_.oracleParameters(_))
        .ifSome(postgreSqlParameters)(_.postgreSqlParameters(_))
        .ifSome(prestoParameters)(_.prestoParameters(_))
        .ifSome(rdsParameters)(_.rdsParameters(_))
        .ifSome(redshiftParameters)(_.redshiftParameters(_))
        .ifSome(s3Parameters)(_.s3Parameters(_))
        .ifSome(serviceNowParameters)(_.serviceNowParameters(_))
        .ifSome(snowflakeParameters)(_.snowflakeParameters(_))
        .ifSome(sparkParameters)(_.sparkParameters(_))
        .ifSome(sqlServerParameters)(_.sqlServerParameters(_))
        .ifSome(teradataParameters)(_.teradataParameters(_))
        .ifSome(twitterParameters)(_.twitterParameters(_))
        .build

    def dateTimeParameter(
      name: Option[String] = None,
      values: Option[List[Timestamp]] = None
    ): DateTimeParameter =
      DateTimeParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def decimalParameter(
      name: Option[String] = None,
      values: Option[List[Double]] = None
    ): DecimalParameter =
      DecimalParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def deleteAccountCustomizationRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteAccountCustomizationRequest =
      DeleteAccountCustomizationRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteAccountCustomizationResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteAccountCustomizationResponse =
      DeleteAccountCustomizationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteAnalysisRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None,
      recoveryWindowInDays: Option[RecoveryWindowInDays] = None,
      forceDeleteWithoutRecovery: Option[Boolean] = None
    ): DeleteAnalysisRequest =
      DeleteAnalysisRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(recoveryWindowInDays)(_.recoveryWindowInDays(_))
        .ifSome(forceDeleteWithoutRecovery)(_.forceDeleteWithoutRecovery(_))
        .build

    def deleteAnalysisResponse(
      status: Option[Int] = None,
      arn: Option[String] = None,
      analysisId: Option[String] = None,
      deletionTime: Option[Timestamp] = None,
      requestId: Option[String] = None
    ): DeleteAnalysisResponse =
      DeleteAnalysisResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(deletionTime)(_.deletionTime(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def deleteDashboardRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None
    ): DeleteDashboardRequest =
      DeleteDashboardRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def deleteDashboardResponse(
      status: Option[Int] = None,
      arn: Option[String] = None,
      dashboardId: Option[String] = None,
      requestId: Option[String] = None
    ): DeleteDashboardResponse =
      DeleteDashboardResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def deleteDataSetRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None
    ): DeleteDataSetRequest =
      DeleteDataSetRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .build

    def deleteDataSetResponse(
      arn: Option[String] = None,
      dataSetId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteDataSetResponse =
      DeleteDataSetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteDataSourceRequest(
      awsAccountId: Option[String] = None,
      dataSourceId: Option[String] = None
    ): DeleteDataSourceRequest =
      DeleteDataSourceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def deleteDataSourceResponse(
      arn: Option[String] = None,
      dataSourceId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteDataSourceResponse =
      DeleteDataSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteGroupMembershipRequest(
      memberName: Option[String] = None,
      groupName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteGroupMembershipRequest =
      DeleteGroupMembershipRequest
        .builder
        .ifSome(memberName)(_.memberName(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteGroupMembershipResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteGroupMembershipResponse =
      DeleteGroupMembershipResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteGroupRequest(
      groupName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteGroupRequest =
      DeleteGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteGroupResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteGroupResponse =
      DeleteGroupResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteIAMPolicyAssignmentRequest(
      awsAccountId: Option[String] = None,
      assignmentName: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteIAMPolicyAssignmentRequest =
      DeleteIAMPolicyAssignmentRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteIAMPolicyAssignmentResponse(
      assignmentName: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteIAMPolicyAssignmentResponse =
      DeleteIAMPolicyAssignmentResponse
        .builder
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteNamespaceRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteNamespaceRequest =
      DeleteNamespaceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteNamespaceResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteNamespaceResponse =
      DeleteNamespaceResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteTemplateAliasRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      aliasName: Option[String] = None
    ): DeleteTemplateAliasRequest =
      DeleteTemplateAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def deleteTemplateAliasResponse(
      status: Option[Int] = None,
      templateId: Option[String] = None,
      aliasName: Option[String] = None,
      arn: Option[String] = None,
      requestId: Option[String] = None
    ): DeleteTemplateAliasResponse =
      DeleteTemplateAliasResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def deleteTemplateRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None
    ): DeleteTemplateRequest =
      DeleteTemplateRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def deleteTemplateResponse(
      requestId: Option[String] = None,
      arn: Option[String] = None,
      templateId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteTemplateResponse =
      DeleteTemplateResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteThemeAliasRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      aliasName: Option[String] = None
    ): DeleteThemeAliasRequest =
      DeleteThemeAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def deleteThemeAliasResponse(
      aliasName: Option[String] = None,
      arn: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None,
      themeId: Option[String] = None
    ): DeleteThemeAliasResponse =
      DeleteThemeAliasResponse
        .builder
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .ifSome(themeId)(_.themeId(_))
        .build

    def deleteThemeRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None
    ): DeleteThemeRequest =
      DeleteThemeRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def deleteThemeResponse(
      arn: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None,
      themeId: Option[String] = None
    ): DeleteThemeResponse =
      DeleteThemeResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .ifSome(themeId)(_.themeId(_))
        .build

    def deleteUserByPrincipalIdRequest(
      principalId: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteUserByPrincipalIdRequest =
      DeleteUserByPrincipalIdRequest
        .builder
        .ifSome(principalId)(_.principalId(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteUserByPrincipalIdResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteUserByPrincipalIdResponse =
      DeleteUserByPrincipalIdResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteUserRequest(
      userName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def deleteUserResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DeleteUserResponse =
      DeleteUserResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeAccountCustomizationRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      resolved: Option[Boolean] = None
    ): DescribeAccountCustomizationRequest =
      DescribeAccountCustomizationRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(resolved)(_.resolved(_))
        .build

    def describeAccountCustomizationResponse(
      arn: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      accountCustomization: Option[AccountCustomization] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeAccountCustomizationResponse =
      DescribeAccountCustomizationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(accountCustomization)(_.accountCustomization(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeAccountSettingsRequest(
      awsAccountId: Option[String] = None
    ): DescribeAccountSettingsRequest =
      DescribeAccountSettingsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .build

    def describeAccountSettingsResponse(
      accountSettings: Option[AccountSettings] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeAccountSettingsResponse =
      DescribeAccountSettingsResponse
        .builder
        .ifSome(accountSettings)(_.accountSettings(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeAnalysisPermissionsRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None
    ): DescribeAnalysisPermissionsRequest =
      DescribeAnalysisPermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .build

    def describeAnalysisPermissionsResponse(
      analysisId: Option[String] = None,
      analysisArn: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeAnalysisPermissionsResponse =
      DescribeAnalysisPermissionsResponse
        .builder
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(analysisArn)(_.analysisArn(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeAnalysisRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None
    ): DescribeAnalysisRequest =
      DescribeAnalysisRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .build

    def describeAnalysisResponse(
      analysis: Option[Analysis] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeAnalysisResponse =
      DescribeAnalysisResponse
        .builder
        .ifSome(analysis)(_.analysis(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeDashboardPermissionsRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None
    ): DescribeDashboardPermissionsRequest =
      DescribeDashboardPermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .build

    def describeDashboardPermissionsResponse(
      dashboardId: Option[String] = None,
      dashboardArn: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeDashboardPermissionsResponse =
      DescribeDashboardPermissionsResponse
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeDashboardRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None,
      aliasName: Option[String] = None
    ): DescribeDashboardRequest =
      DescribeDashboardRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def describeDashboardResponse(
      dashboard: Option[Dashboard] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeDashboardResponse =
      DescribeDashboardResponse
        .builder
        .ifSome(dashboard)(_.dashboard(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeDataSetPermissionsRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None
    ): DescribeDataSetPermissionsRequest =
      DescribeDataSetPermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .build

    def describeDataSetPermissionsResponse(
      dataSetArn: Option[String] = None,
      dataSetId: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeDataSetPermissionsResponse =
      DescribeDataSetPermissionsResponse
        .builder
        .ifSome(dataSetArn)(_.dataSetArn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeDataSetRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None
    ): DescribeDataSetRequest =
      DescribeDataSetRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .build

    def describeDataSetResponse(
      dataSet: Option[DataSet] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeDataSetResponse =
      DescribeDataSetResponse
        .builder
        .ifSome(dataSet)(_.dataSet(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeDataSourcePermissionsRequest(
      awsAccountId: Option[String] = None,
      dataSourceId: Option[String] = None
    ): DescribeDataSourcePermissionsRequest =
      DescribeDataSourcePermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def describeDataSourcePermissionsResponse(
      dataSourceArn: Option[String] = None,
      dataSourceId: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeDataSourcePermissionsResponse =
      DescribeDataSourcePermissionsResponse
        .builder
        .ifSome(dataSourceArn)(_.dataSourceArn(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeDataSourceRequest(
      awsAccountId: Option[String] = None,
      dataSourceId: Option[String] = None
    ): DescribeDataSourceRequest =
      DescribeDataSourceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .build

    def describeDataSourceResponse(
      dataSource: Option[DataSource] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeDataSourceResponse =
      DescribeDataSourceResponse
        .builder
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeGroupRequest(
      groupName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DescribeGroupRequest =
      DescribeGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def describeGroupResponse(
      group: Option[Group] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeGroupResponse =
      DescribeGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeIAMPolicyAssignmentRequest(
      awsAccountId: Option[String] = None,
      assignmentName: Option[String] = None,
      namespace: Option[String] = None
    ): DescribeIAMPolicyAssignmentRequest =
      DescribeIAMPolicyAssignmentRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def describeIAMPolicyAssignmentResponse(
      iAMPolicyAssignment: Option[IAMPolicyAssignment] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeIAMPolicyAssignmentResponse =
      DescribeIAMPolicyAssignmentResponse
        .builder
        .ifSome(iAMPolicyAssignment)(_.iAMPolicyAssignment(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeIngestionRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None,
      ingestionId: Option[String] = None
    ): DescribeIngestionRequest =
      DescribeIngestionRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .build

    def describeIngestionResponse(
      ingestion: Option[Ingestion] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeIngestionResponse =
      DescribeIngestionResponse
        .builder
        .ifSome(ingestion)(_.ingestion(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeNamespaceRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DescribeNamespaceRequest =
      DescribeNamespaceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def describeNamespaceResponse(
      namespace: Option[NamespaceInfoV2] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeNamespaceResponse =
      DescribeNamespaceResponse
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeTemplateAliasRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      aliasName: Option[String] = None
    ): DescribeTemplateAliasRequest =
      DescribeTemplateAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def describeTemplateAliasResponse(
      templateAlias: Option[TemplateAlias] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeTemplateAliasResponse =
      DescribeTemplateAliasResponse
        .builder
        .ifSome(templateAlias)(_.templateAlias(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeTemplatePermissionsRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None
    ): DescribeTemplatePermissionsRequest =
      DescribeTemplatePermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def describeTemplatePermissionsResponse(
      templateId: Option[String] = None,
      templateArn: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeTemplatePermissionsResponse =
      DescribeTemplatePermissionsResponse
        .builder
        .ifSome(templateId)(_.templateId(_))
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeTemplateRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None,
      aliasName: Option[String] = None
    ): DescribeTemplateRequest =
      DescribeTemplateRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def describeTemplateResponse(
      template: Option[Template] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeTemplateResponse =
      DescribeTemplateResponse
        .builder
        .ifSome(template)(_.template(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeThemeAliasRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      aliasName: Option[String] = None
    ): DescribeThemeAliasRequest =
      DescribeThemeAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def describeThemeAliasResponse(
      themeAlias: Option[ThemeAlias] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeThemeAliasResponse =
      DescribeThemeAliasResponse
        .builder
        .ifSome(themeAlias)(_.themeAlias(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeThemePermissionsRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None
    ): DescribeThemePermissionsRequest =
      DescribeThemePermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .build

    def describeThemePermissionsResponse(
      themeId: Option[String] = None,
      themeArn: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeThemePermissionsResponse =
      DescribeThemePermissionsResponse
        .builder
        .ifSome(themeId)(_.themeId(_))
        .ifSome(themeArn)(_.themeArn(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeThemeRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None,
      aliasName: Option[String] = None
    ): DescribeThemeRequest =
      DescribeThemeRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def describeThemeResponse(
      theme: Option[Theme] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): DescribeThemeResponse =
      DescribeThemeResponse
        .builder
        .ifSome(theme)(_.theme(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeUserRequest(
      userName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): DescribeUserRequest =
      DescribeUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def describeUserResponse(
      user: Option[User] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): DescribeUserResponse =
      DescribeUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def domainNotWhitelistedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): DomainNotWhitelistedException =
      DomainNotWhitelistedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def errorInfo(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ErrorInfo =
      ErrorInfo
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def exportToCSVOption(
      availabilityStatus: Option[String] = None
    ): ExportToCSVOption =
      ExportToCSVOption
        .builder
        .ifSome(availabilityStatus)(_.availabilityStatus(_))
        .build

    def fieldFolder(
      description: Option[String] = None,
      columns: Option[List[String]] = None
    ): FieldFolder =
      FieldFolder
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(columns)(_.columns(_))
        .build

    def filterOperation(
      conditionExpression: Option[String] = None
    ): FilterOperation =
      FilterOperation
        .builder
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .build

    def geoSpatialColumnGroup(
      name: Option[String] = None,
      countryCode: Option[String] = None,
      columns: Option[List[ColumnName]] = None
    ): GeoSpatialColumnGroup =
      GeoSpatialColumnGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(columns)(_.columns(_))
        .build

    def getDashboardEmbedUrlRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      identityType: Option[String] = None,
      sessionLifetimeInMinutes: Option[SessionLifetimeInMinutes] = None,
      undoRedoDisabled: Option[Boolean] = None,
      resetDisabled: Option[Boolean] = None,
      statePersistenceEnabled: Option[Boolean] = None,
      userArn: Option[String] = None,
      namespace: Option[String] = None,
      additionalDashboardIds: Option[List[RestrictiveResourceId]] = None
    ): GetDashboardEmbedUrlRequest =
      GetDashboardEmbedUrlRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(sessionLifetimeInMinutes)(_.sessionLifetimeInMinutes(_))
        .ifSome(undoRedoDisabled)(_.undoRedoDisabled(_))
        .ifSome(resetDisabled)(_.resetDisabled(_))
        .ifSome(statePersistenceEnabled)(_.statePersistenceEnabled(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(additionalDashboardIds)(_.additionalDashboardIds(_))
        .build

    def getDashboardEmbedUrlResponse(
      embedUrl: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): GetDashboardEmbedUrlResponse =
      GetDashboardEmbedUrlResponse
        .builder
        .ifSome(embedUrl)(_.embedUrl(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def getSessionEmbedUrlRequest(
      awsAccountId: Option[String] = None,
      entryPoint: Option[String] = None,
      sessionLifetimeInMinutes: Option[SessionLifetimeInMinutes] = None,
      userArn: Option[String] = None
    ): GetSessionEmbedUrlRequest =
      GetSessionEmbedUrlRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(entryPoint)(_.entryPoint(_))
        .ifSome(sessionLifetimeInMinutes)(_.sessionLifetimeInMinutes(_))
        .ifSome(userArn)(_.userArn(_))
        .build

    def getSessionEmbedUrlResponse(
      embedUrl: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): GetSessionEmbedUrlResponse =
      GetSessionEmbedUrlResponse
        .builder
        .ifSome(embedUrl)(_.embedUrl(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def group(
      arn: Option[String] = None,
      groupName: Option[String] = None,
      description: Option[String] = None,
      principalId: Option[String] = None
    ): Group =
      Group
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def groupMember(
      arn: Option[String] = None,
      memberName: Option[String] = None
    ): GroupMember =
      GroupMember
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(memberName)(_.memberName(_))
        .build

    def gutterStyle(
      show: Option[Boolean] = None
    ): GutterStyle =
      GutterStyle
        .builder
        .ifSome(show)(_.show(_))
        .build

    def iAMPolicyAssignment(
      awsAccountId: Option[String] = None,
      assignmentId: Option[String] = None,
      assignmentName: Option[String] = None,
      policyArn: Option[String] = None,
      identities: Option[IdentityMap] = None,
      assignmentStatus: Option[String] = None
    ): IAMPolicyAssignment =
      IAMPolicyAssignment
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(identities)(_.identities(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .build

    def iAMPolicyAssignmentSummary(
      assignmentName: Option[String] = None,
      assignmentStatus: Option[String] = None
    ): IAMPolicyAssignmentSummary =
      IAMPolicyAssignmentSummary
        .builder
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .build

    def identityTypeNotSupportedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): IdentityTypeNotSupportedException =
      IdentityTypeNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def ingestion(
      arn: Option[String] = None,
      ingestionId: Option[String] = None,
      ingestionStatus: Option[String] = None,
      errorInfo: Option[ErrorInfo] = None,
      rowInfo: Option[RowInfo] = None,
      queueInfo: Option[QueueInfo] = None,
      createdTime: Option[timestamp] = None,
      ingestionTimeInSeconds: Option[long] = None,
      ingestionSizeInBytes: Option[long] = None,
      requestSource: Option[String] = None,
      requestType: Option[String] = None
    ): Ingestion =
      Ingestion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .ifSome(ingestionStatus)(_.ingestionStatus(_))
        .ifSome(errorInfo)(_.errorInfo(_))
        .ifSome(rowInfo)(_.rowInfo(_))
        .ifSome(queueInfo)(_.queueInfo(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(ingestionTimeInSeconds)(_.ingestionTimeInSeconds(_))
        .ifSome(ingestionSizeInBytes)(_.ingestionSizeInBytes(_))
        .ifSome(requestSource)(_.requestSource(_))
        .ifSome(requestType)(_.requestType(_))
        .build

    def inputColumn(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): InputColumn =
      InputColumn
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def integerParameter(
      name: Option[String] = None,
      values: Option[List[Long]] = None
    ): IntegerParameter =
      IntegerParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def internalFailureException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def jiraParameters(
      siteBaseUrl: Option[String] = None
    ): JiraParameters =
      JiraParameters
        .builder
        .ifSome(siteBaseUrl)(_.siteBaseUrl(_))
        .build

    def joinInstruction(
      leftOperand: Option[String] = None,
      rightOperand: Option[String] = None,
      leftJoinKeyProperties: Option[JoinKeyProperties] = None,
      rightJoinKeyProperties: Option[JoinKeyProperties] = None,
      `type`: Option[String] = None,
      onClause: Option[String] = None
    ): JoinInstruction =
      JoinInstruction
        .builder
        .ifSome(leftOperand)(_.leftOperand(_))
        .ifSome(rightOperand)(_.rightOperand(_))
        .ifSome(leftJoinKeyProperties)(_.leftJoinKeyProperties(_))
        .ifSome(rightJoinKeyProperties)(_.rightJoinKeyProperties(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(onClause)(_.onClause(_))
        .build

    def joinKeyProperties(
      uniqueKey: Option[Boolean] = None
    ): JoinKeyProperties =
      JoinKeyProperties
        .builder
        .ifSome(uniqueKey)(_.uniqueKey(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      requestId: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listAnalysesRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAnalysesRequest =
      ListAnalysesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAnalysesResponse(
      analysisSummaryList: Option[List[AnalysisSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListAnalysesResponse =
      ListAnalysesResponse
        .builder
        .ifSome(analysisSummaryList)(_.analysisSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listDashboardVersionsRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDashboardVersionsRequest =
      ListDashboardVersionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDashboardVersionsResponse(
      dashboardVersionSummaryList: Option[List[DashboardVersionSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListDashboardVersionsResponse =
      ListDashboardVersionsResponse
        .builder
        .ifSome(dashboardVersionSummaryList)(_.dashboardVersionSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listDashboardsRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDashboardsRequest =
      ListDashboardsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDashboardsResponse(
      dashboardSummaryList: Option[List[DashboardSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListDashboardsResponse =
      ListDashboardsResponse
        .builder
        .ifSome(dashboardSummaryList)(_.dashboardSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listDataSetsRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDataSetsRequest =
      ListDataSetsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDataSetsResponse(
      dataSetSummaries: Option[List[DataSetSummary]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListDataSetsResponse =
      ListDataSetsResponse
        .builder
        .ifSome(dataSetSummaries)(_.dataSetSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listDataSourcesRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDataSourcesRequest =
      ListDataSourcesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDataSourcesResponse(
      dataSources: Option[List[DataSource]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListDataSourcesResponse =
      ListDataSourcesResponse
        .builder
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listGroupMembershipsRequest(
      groupName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): ListGroupMembershipsRequest =
      ListGroupMembershipsRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def listGroupMembershipsResponse(
      groupMemberList: Option[List[GroupMember]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListGroupMembershipsResponse =
      ListGroupMembershipsResponse
        .builder
        .ifSome(groupMemberList)(_.groupMemberList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listGroupsRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namespace: Option[String] = None
    ): ListGroupsRequest =
      ListGroupsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def listGroupsResponse(
      groupList: Option[List[Group]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListGroupsResponse =
      ListGroupsResponse
        .builder
        .ifSome(groupList)(_.groupList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listIAMPolicyAssignmentsForUserRequest(
      awsAccountId: Option[String] = None,
      userName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namespace: Option[String] = None
    ): ListIAMPolicyAssignmentsForUserRequest =
      ListIAMPolicyAssignmentsForUserRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def listIAMPolicyAssignmentsForUserResponse(
      activeAssignments: Option[List[ActiveIAMPolicyAssignment]] = None,
      requestId: Option[String] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None
    ): ListIAMPolicyAssignmentsForUserResponse =
      ListIAMPolicyAssignmentsForUserResponse
        .builder
        .ifSome(activeAssignments)(_.activeAssignments(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .build

    def listIAMPolicyAssignmentsRequest(
      awsAccountId: Option[String] = None,
      assignmentStatus: Option[String] = None,
      namespace: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIAMPolicyAssignmentsRequest =
      ListIAMPolicyAssignmentsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIAMPolicyAssignmentsResponse(
      iAMPolicyAssignments: Option[List[IAMPolicyAssignmentSummary]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListIAMPolicyAssignmentsResponse =
      ListIAMPolicyAssignmentsResponse
        .builder
        .ifSome(iAMPolicyAssignments)(_.iAMPolicyAssignments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listIngestionsRequest(
      dataSetId: Option[String] = None,
      nextToken: Option[String] = None,
      awsAccountId: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIngestionsRequest =
      ListIngestionsRequest
        .builder
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIngestionsResponse(
      ingestions: Option[List[Ingestion]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListIngestionsResponse =
      ListIngestionsResponse
        .builder
        .ifSome(ingestions)(_.ingestions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listNamespacesRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListNamespacesRequest =
      ListNamespacesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listNamespacesResponse(
      namespaces: Option[List[NamespaceInfoV2]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListNamespacesResponse =
      ListNamespacesResponse
        .builder
        .ifSome(namespaces)(_.namespaces(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listTemplateAliasesRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTemplateAliasesRequest =
      ListTemplateAliasesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTemplateAliasesResponse(
      templateAliasList: Option[List[TemplateAlias]] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTemplateAliasesResponse =
      ListTemplateAliasesResponse
        .builder
        .ifSome(templateAliasList)(_.templateAliasList(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTemplateVersionsRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTemplateVersionsRequest =
      ListTemplateVersionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTemplateVersionsResponse(
      templateVersionSummaryList: Option[List[TemplateVersionSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListTemplateVersionsResponse =
      ListTemplateVersionsResponse
        .builder
        .ifSome(templateVersionSummaryList)(_.templateVersionSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listTemplatesRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTemplatesRequest =
      ListTemplatesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTemplatesResponse(
      templateSummaryList: Option[List[TemplateSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListTemplatesResponse =
      ListTemplatesResponse
        .builder
        .ifSome(templateSummaryList)(_.templateSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listThemeAliasesRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThemeAliasesRequest =
      ListThemeAliasesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThemeAliasesResponse(
      themeAliasList: Option[List[ThemeAlias]] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None,
      nextToken: Option[String] = None
    ): ListThemeAliasesResponse =
      ListThemeAliasesResponse
        .builder
        .ifSome(themeAliasList)(_.themeAliasList(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThemeVersionsRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThemeVersionsRequest =
      ListThemeVersionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThemeVersionsResponse(
      themeVersionSummaryList: Option[List[ThemeVersionSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListThemeVersionsResponse =
      ListThemeVersionsResponse
        .builder
        .ifSome(themeVersionSummaryList)(_.themeVersionSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listThemesRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      `type`: Option[String] = None
    ): ListThemesRequest =
      ListThemesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def listThemesResponse(
      themeSummaryList: Option[List[ThemeSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): ListThemesResponse =
      ListThemesResponse
        .builder
        .ifSome(themeSummaryList)(_.themeSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listUserGroupsRequest(
      userName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUserGroupsRequest =
      ListUserGroupsRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listUserGroupsResponse(
      groupList: Option[List[Group]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListUserGroupsResponse =
      ListUserGroupsResponse
        .builder
        .ifSome(groupList)(_.groupList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def listUsersRequest(
      awsAccountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namespace: Option[String] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def listUsersResponse(
      userList: Option[List[User]] = None,
      nextToken: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(userList)(_.userList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def logicalTable(
      alias: Option[String] = None,
      dataTransforms: Option[List[TransformOperation]] = None,
      source: Option[LogicalTableSource] = None
    ): LogicalTable =
      LogicalTable
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(dataTransforms)(_.dataTransforms(_))
        .ifSome(source)(_.source(_))
        .build

    def logicalTableSource(
      joinInstruction: Option[JoinInstruction] = None,
      physicalTableId: Option[String] = None
    ): LogicalTableSource =
      LogicalTableSource
        .builder
        .ifSome(joinInstruction)(_.joinInstruction(_))
        .ifSome(physicalTableId)(_.physicalTableId(_))
        .build

    def manifestFileLocation(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): ManifestFileLocation =
      ManifestFileLocation
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def marginStyle(
      show: Option[Boolean] = None
    ): MarginStyle =
      MarginStyle
        .builder
        .ifSome(show)(_.show(_))
        .build

    def mariaDbParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): MariaDbParameters =
      MariaDbParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def mySqlParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): MySqlParameters =
      MySqlParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def namespaceError(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): NamespaceError =
      NamespaceError
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def namespaceInfoV2(
      name: Option[String] = None,
      arn: Option[String] = None,
      capacityRegion: Option[String] = None,
      creationStatus: Option[String] = None,
      identityStore: Option[String] = None,
      namespaceError: Option[NamespaceError] = None
    ): NamespaceInfoV2 =
      NamespaceInfoV2
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(capacityRegion)(_.capacityRegion(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(identityStore)(_.identityStore(_))
        .ifSome(namespaceError)(_.namespaceError(_))
        .build

    def oracleParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): OracleParameters =
      OracleParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def outputColumn(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None
    ): OutputColumn =
      OutputColumn
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def parameters(
      stringParameters: Option[List[StringParameter]] = None,
      integerParameters: Option[List[IntegerParameter]] = None,
      decimalParameters: Option[List[DecimalParameter]] = None,
      dateTimeParameters: Option[List[DateTimeParameter]] = None
    ): Parameters =
      Parameters
        .builder
        .ifSome(stringParameters)(_.stringParameters(_))
        .ifSome(integerParameters)(_.integerParameters(_))
        .ifSome(decimalParameters)(_.decimalParameters(_))
        .ifSome(dateTimeParameters)(_.dateTimeParameters(_))
        .build

    def physicalTable(
      relationalTable: Option[RelationalTable] = None,
      customSql: Option[CustomSql] = None,
      s3Source: Option[S3Source] = None
    ): PhysicalTable =
      PhysicalTable
        .builder
        .ifSome(relationalTable)(_.relationalTable(_))
        .ifSome(customSql)(_.customSql(_))
        .ifSome(s3Source)(_.s3Source(_))
        .build

    def postgreSqlParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): PostgreSqlParameters =
      PostgreSqlParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def preconditionNotMetException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): PreconditionNotMetException =
      PreconditionNotMetException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def prestoParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      catalog: Option[String] = None
    ): PrestoParameters =
      PrestoParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(catalog)(_.catalog(_))
        .build

    def projectOperation(
      projectedColumns: Option[List[String]] = None
    ): ProjectOperation =
      ProjectOperation
        .builder
        .ifSome(projectedColumns)(_.projectedColumns(_))
        .build

    def queueInfo(
      waitingOnIngestion: Option[String] = None,
      queuedIngestion: Option[String] = None
    ): QueueInfo =
      QueueInfo
        .builder
        .ifSome(waitingOnIngestion)(_.waitingOnIngestion(_))
        .ifSome(queuedIngestion)(_.queuedIngestion(_))
        .build

    def quickSightUserNotFoundException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): QuickSightUserNotFoundException =
      QuickSightUserNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def rdsParameters(
      instanceId: Option[String] = None,
      database: Option[String] = None
    ): RdsParameters =
      RdsParameters
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(database)(_.database(_))
        .build

    def redshiftParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None,
      clusterId: Option[String] = None
    ): RedshiftParameters =
      RedshiftParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .ifSome(clusterId)(_.clusterId(_))
        .build

    def registerUserRequest(
      identityType: Option[String] = None,
      email: Option[String] = None,
      userRole: Option[String] = None,
      iamArn: Option[String] = None,
      sessionName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      userName: Option[String] = None,
      customPermissionsName: Option[String] = None,
      externalLoginFederationProviderType: Option[String] = None,
      customFederationProviderUrl: Option[String] = None,
      externalLoginId: Option[String] = None
    ): RegisterUserRequest =
      RegisterUserRequest
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(email)(_.email(_))
        .ifSome(userRole)(_.userRole(_))
        .ifSome(iamArn)(_.iamArn(_))
        .ifSome(sessionName)(_.sessionName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(customPermissionsName)(_.customPermissionsName(_))
        .ifSome(externalLoginFederationProviderType)(_.externalLoginFederationProviderType(_))
        .ifSome(customFederationProviderUrl)(_.customFederationProviderUrl(_))
        .ifSome(externalLoginId)(_.externalLoginId(_))
        .build

    def registerUserResponse(
      user: Option[User] = None,
      userInvitationUrl: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): RegisterUserResponse =
      RegisterUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .ifSome(userInvitationUrl)(_.userInvitationUrl(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def relationalTable(
      dataSourceArn: Option[String] = None,
      catalog: Option[String] = None,
      schema: Option[String] = None,
      name: Option[String] = None,
      inputColumns: Option[List[InputColumn]] = None
    ): RelationalTable =
      RelationalTable
        .builder
        .ifSome(dataSourceArn)(_.dataSourceArn(_))
        .ifSome(catalog)(_.catalog(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(name)(_.name(_))
        .ifSome(inputColumns)(_.inputColumns(_))
        .build

    def renameColumnOperation(
      columnName: Option[String] = None,
      newColumnName: Option[String] = None
    ): RenameColumnOperation =
      RenameColumnOperation
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(newColumnName)(_.newColumnName(_))
        .build

    def resourceExistsException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      requestId: Option[String] = None
    ): ResourceExistsException =
      ResourceExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      requestId: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def resourcePermission(
      principal: Option[String] = None,
      actions: Option[List[String]] = None
    ): ResourcePermission =
      ResourcePermission
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(actions)(_.actions(_))
        .build

    def resourceUnavailableException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      requestId: Option[String] = None
    ): ResourceUnavailableException =
      ResourceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def restoreAnalysisRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None
    ): RestoreAnalysisRequest =
      RestoreAnalysisRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .build

    def restoreAnalysisResponse(
      status: Option[Int] = None,
      arn: Option[String] = None,
      analysisId: Option[String] = None,
      requestId: Option[String] = None
    ): RestoreAnalysisResponse =
      RestoreAnalysisResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def rowInfo(
      rowsIngested: Option[long] = None,
      rowsDropped: Option[long] = None
    ): RowInfo =
      RowInfo
        .builder
        .ifSome(rowsIngested)(_.rowsIngested(_))
        .ifSome(rowsDropped)(_.rowsDropped(_))
        .build

    def rowLevelPermissionDataSet(
      namespace: Option[String] = None,
      arn: Option[String] = None,
      permissionPolicy: Option[String] = None,
      formatVersion: Option[String] = None
    ): RowLevelPermissionDataSet =
      RowLevelPermissionDataSet
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(permissionPolicy)(_.permissionPolicy(_))
        .ifSome(formatVersion)(_.formatVersion(_))
        .build

    def s3Parameters(
      manifestFileLocation: Option[ManifestFileLocation] = None
    ): S3Parameters =
      S3Parameters
        .builder
        .ifSome(manifestFileLocation)(_.manifestFileLocation(_))
        .build

    def s3Source(
      dataSourceArn: Option[String] = None,
      uploadSettings: Option[UploadSettings] = None,
      inputColumns: Option[List[InputColumn]] = None
    ): S3Source =
      S3Source
        .builder
        .ifSome(dataSourceArn)(_.dataSourceArn(_))
        .ifSome(uploadSettings)(_.uploadSettings(_))
        .ifSome(inputColumns)(_.inputColumns(_))
        .build

    def searchAnalysesRequest(
      awsAccountId: Option[String] = None,
      filters: Option[List[AnalysisSearchFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchAnalysesRequest =
      SearchAnalysesRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchAnalysesResponse(
      analysisSummaryList: Option[List[AnalysisSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): SearchAnalysesResponse =
      SearchAnalysesResponse
        .builder
        .ifSome(analysisSummaryList)(_.analysisSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def searchDashboardsRequest(
      awsAccountId: Option[String] = None,
      filters: Option[List[DashboardSearchFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchDashboardsRequest =
      SearchDashboardsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchDashboardsResponse(
      dashboardSummaryList: Option[List[DashboardSummary]] = None,
      nextToken: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): SearchDashboardsResponse =
      SearchDashboardsResponse
        .builder
        .ifSome(dashboardSummaryList)(_.dashboardSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def serviceNowParameters(
      siteBaseUrl: Option[String] = None
    ): ServiceNowParameters =
      ServiceNowParameters
        .builder
        .ifSome(siteBaseUrl)(_.siteBaseUrl(_))
        .build

    def sessionLifetimeInMinutesInvalidException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): SessionLifetimeInMinutesInvalidException =
      SessionLifetimeInMinutesInvalidException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def sheet(
      sheetId: Option[String] = None,
      name: Option[String] = None
    ): Sheet =
      Sheet
        .builder
        .ifSome(sheetId)(_.sheetId(_))
        .ifSome(name)(_.name(_))
        .build

    def sheetControlsOption(
      visibilityState: Option[String] = None
    ): SheetControlsOption =
      SheetControlsOption
        .builder
        .ifSome(visibilityState)(_.visibilityState(_))
        .build

    def sheetStyle(
      tile: Option[TileStyle] = None,
      tileLayout: Option[TileLayoutStyle] = None
    ): SheetStyle =
      SheetStyle
        .builder
        .ifSome(tile)(_.tile(_))
        .ifSome(tileLayout)(_.tileLayout(_))
        .build

    def snowflakeParameters(
      host: Option[String] = None,
      database: Option[String] = None,
      warehouse: Option[String] = None
    ): SnowflakeParameters =
      SnowflakeParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(database)(_.database(_))
        .ifSome(warehouse)(_.warehouse(_))
        .build

    def sparkParameters(
      host: Option[String] = None,
      port: Option[Int] = None
    ): SparkParameters =
      SparkParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .build

    def sqlServerParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): SqlServerParameters =
      SqlServerParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def sslProperties(
      disableSsl: Option[Boolean] = None
    ): SslProperties =
      SslProperties
        .builder
        .ifSome(disableSsl)(_.disableSsl(_))
        .build

    def stringParameter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): StringParameter =
      StringParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
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

    def tagColumnOperation(
      columnName: Option[String] = None,
      tags: Option[List[ColumnTag]] = None
    ): TagColumnOperation =
      TagColumnOperation
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(tags)(_.tags(_))
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
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): TagResourceResponse =
      TagResourceResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def template(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[TemplateVersion] = None,
      templateId: Option[String] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      createdTime: Option[Timestamp] = None
    ): Template =
      Template
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def templateAlias(
      aliasName: Option[String] = None,
      arn: Option[String] = None,
      templateVersionNumber: Option[VersionNumber] = None
    ): TemplateAlias =
      TemplateAlias
        .builder
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(templateVersionNumber)(_.templateVersionNumber(_))
        .build

    def templateError(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): TemplateError =
      TemplateError
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def templateSourceAnalysis(
      arn: Option[String] = None,
      dataSetReferences: Option[List[DataSetReference]] = None
    ): TemplateSourceAnalysis =
      TemplateSourceAnalysis
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSetReferences)(_.dataSetReferences(_))
        .build

    def templateSourceEntity(
      sourceAnalysis: Option[TemplateSourceAnalysis] = None,
      sourceTemplate: Option[TemplateSourceTemplate] = None
    ): TemplateSourceEntity =
      TemplateSourceEntity
        .builder
        .ifSome(sourceAnalysis)(_.sourceAnalysis(_))
        .ifSome(sourceTemplate)(_.sourceTemplate(_))
        .build

    def templateSourceTemplate(
      arn: Option[String] = None
    ): TemplateSourceTemplate =
      TemplateSourceTemplate
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def templateSummary(
      arn: Option[String] = None,
      templateId: Option[String] = None,
      name: Option[String] = None,
      latestVersionNumber: Option[VersionNumber] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): TemplateSummary =
      TemplateSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(name)(_.name(_))
        .ifSome(latestVersionNumber)(_.latestVersionNumber(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def templateVersion(
      createdTime: Option[Timestamp] = None,
      errors: Option[List[TemplateError]] = None,
      versionNumber: Option[VersionNumber] = None,
      status: Option[String] = None,
      dataSetConfigurations: Option[List[DataSetConfiguration]] = None,
      description: Option[String] = None,
      sourceEntityArn: Option[String] = None,
      themeArn: Option[String] = None,
      sheets: Option[List[Sheet]] = None
    ): TemplateVersion =
      TemplateVersion
        .builder
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(dataSetConfigurations)(_.dataSetConfigurations(_))
        .ifSome(description)(_.description(_))
        .ifSome(sourceEntityArn)(_.sourceEntityArn(_))
        .ifSome(themeArn)(_.themeArn(_))
        .ifSome(sheets)(_.sheets(_))
        .build

    def templateVersionSummary(
      arn: Option[String] = None,
      versionNumber: Option[VersionNumber] = None,
      createdTime: Option[Timestamp] = None,
      status: Option[String] = None,
      description: Option[String] = None
    ): TemplateVersionSummary =
      TemplateVersionSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .build

    def teradataParameters(
      host: Option[String] = None,
      port: Option[Int] = None,
      database: Option[String] = None
    ): TeradataParameters =
      TeradataParameters
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(database)(_.database(_))
        .build

    def theme(
      arn: Option[String] = None,
      name: Option[String] = None,
      themeId: Option[String] = None,
      version: Option[ThemeVersion] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      `type`: Option[String] = None
    ): Theme =
      Theme
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(version)(_.version(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def themeAlias(
      arn: Option[String] = None,
      aliasName: Option[String] = None,
      themeVersionNumber: Option[VersionNumber] = None
    ): ThemeAlias =
      ThemeAlias
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(themeVersionNumber)(_.themeVersionNumber(_))
        .build

    def themeConfiguration(
      dataColorPalette: Option[DataColorPalette] = None,
      uIColorPalette: Option[UIColorPalette] = None,
      sheet: Option[SheetStyle] = None
    ): ThemeConfiguration =
      ThemeConfiguration
        .builder
        .ifSome(dataColorPalette)(_.dataColorPalette(_))
        .ifSome(uIColorPalette)(_.uIColorPalette(_))
        .ifSome(sheet)(_.sheet(_))
        .build

    def themeError(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ThemeError =
      ThemeError
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def themeSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      themeId: Option[String] = None,
      latestVersionNumber: Option[VersionNumber] = None,
      createdTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): ThemeSummary =
      ThemeSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(latestVersionNumber)(_.latestVersionNumber(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def themeVersion(
      versionNumber: Option[VersionNumber] = None,
      arn: Option[String] = None,
      description: Option[String] = None,
      baseThemeId: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      configuration: Option[ThemeConfiguration] = None,
      errors: Option[List[ThemeError]] = None,
      status: Option[String] = None
    ): ThemeVersion =
      ThemeVersion
        .builder
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(baseThemeId)(_.baseThemeId(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(errors)(_.errors(_))
        .ifSome(status)(_.status(_))
        .build

    def themeVersionSummary(
      versionNumber: Option[VersionNumber] = None,
      arn: Option[String] = None,
      description: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      status: Option[String] = None
    ): ThemeVersionSummary =
      ThemeVersionSummary
        .builder
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(status)(_.status(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def tileLayoutStyle(
      gutter: Option[GutterStyle] = None,
      margin: Option[MarginStyle] = None
    ): TileLayoutStyle =
      TileLayoutStyle
        .builder
        .ifSome(gutter)(_.gutter(_))
        .ifSome(margin)(_.margin(_))
        .build

    def tileStyle(
      border: Option[BorderStyle] = None
    ): TileStyle =
      TileStyle
        .builder
        .ifSome(border)(_.border(_))
        .build

    def transformOperation(
      projectOperation: Option[ProjectOperation] = None,
      filterOperation: Option[FilterOperation] = None,
      createColumnsOperation: Option[CreateColumnsOperation] = None,
      renameColumnOperation: Option[RenameColumnOperation] = None,
      castColumnTypeOperation: Option[CastColumnTypeOperation] = None,
      tagColumnOperation: Option[TagColumnOperation] = None
    ): TransformOperation =
      TransformOperation
        .builder
        .ifSome(projectOperation)(_.projectOperation(_))
        .ifSome(filterOperation)(_.filterOperation(_))
        .ifSome(createColumnsOperation)(_.createColumnsOperation(_))
        .ifSome(renameColumnOperation)(_.renameColumnOperation(_))
        .ifSome(castColumnTypeOperation)(_.castColumnTypeOperation(_))
        .ifSome(tagColumnOperation)(_.tagColumnOperation(_))
        .build

    def twitterParameters(
      query: Option[String] = None,
      maxRows: Option[Int] = None
    ): TwitterParameters =
      TwitterParameters
        .builder
        .ifSome(query)(_.query(_))
        .ifSome(maxRows)(_.maxRows(_))
        .build

    def uIColorPalette(
      primaryForeground: Option[String] = None,
      primaryBackground: Option[String] = None,
      secondaryForeground: Option[String] = None,
      secondaryBackground: Option[String] = None,
      accent: Option[String] = None,
      accentForeground: Option[String] = None,
      danger: Option[String] = None,
      dangerForeground: Option[String] = None,
      warning: Option[String] = None,
      warningForeground: Option[String] = None,
      success: Option[String] = None,
      successForeground: Option[String] = None,
      dimension: Option[String] = None,
      dimensionForeground: Option[String] = None,
      measure: Option[String] = None,
      measureForeground: Option[String] = None
    ): UIColorPalette =
      UIColorPalette
        .builder
        .ifSome(primaryForeground)(_.primaryForeground(_))
        .ifSome(primaryBackground)(_.primaryBackground(_))
        .ifSome(secondaryForeground)(_.secondaryForeground(_))
        .ifSome(secondaryBackground)(_.secondaryBackground(_))
        .ifSome(accent)(_.accent(_))
        .ifSome(accentForeground)(_.accentForeground(_))
        .ifSome(danger)(_.danger(_))
        .ifSome(dangerForeground)(_.dangerForeground(_))
        .ifSome(warning)(_.warning(_))
        .ifSome(warningForeground)(_.warningForeground(_))
        .ifSome(success)(_.success(_))
        .ifSome(successForeground)(_.successForeground(_))
        .ifSome(dimension)(_.dimension(_))
        .ifSome(dimensionForeground)(_.dimensionForeground(_))
        .ifSome(measure)(_.measure(_))
        .ifSome(measureForeground)(_.measureForeground(_))
        .build

    def unsupportedPricingPlanException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): UnsupportedPricingPlanException =
      UnsupportedPricingPlanException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def unsupportedUserEditionException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): UnsupportedUserEditionException =
      UnsupportedUserEditionException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
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
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UntagResourceResponse =
      UntagResourceResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAccountCustomizationRequest(
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      accountCustomization: Option[AccountCustomization] = None
    ): UpdateAccountCustomizationRequest =
      UpdateAccountCustomizationRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(accountCustomization)(_.accountCustomization(_))
        .build

    def updateAccountCustomizationResponse(
      arn: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      accountCustomization: Option[AccountCustomization] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateAccountCustomizationResponse =
      UpdateAccountCustomizationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(accountCustomization)(_.accountCustomization(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAccountSettingsRequest(
      awsAccountId: Option[String] = None,
      defaultNamespace: Option[String] = None,
      notificationEmail: Option[String] = None
    ): UpdateAccountSettingsRequest =
      UpdateAccountSettingsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(defaultNamespace)(_.defaultNamespace(_))
        .ifSome(notificationEmail)(_.notificationEmail(_))
        .build

    def updateAccountSettingsResponse(
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateAccountSettingsResponse =
      UpdateAccountSettingsResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAnalysisPermissionsRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None,
      grantPermissions: Option[List[ResourcePermission]] = None,
      revokePermissions: Option[List[ResourcePermission]] = None
    ): UpdateAnalysisPermissionsRequest =
      UpdateAnalysisPermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(grantPermissions)(_.grantPermissions(_))
        .ifSome(revokePermissions)(_.revokePermissions(_))
        .build

    def updateAnalysisPermissionsResponse(
      analysisArn: Option[String] = None,
      analysisId: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateAnalysisPermissionsResponse =
      UpdateAnalysisPermissionsResponse
        .builder
        .ifSome(analysisArn)(_.analysisArn(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAnalysisRequest(
      awsAccountId: Option[String] = None,
      analysisId: Option[String] = None,
      name: Option[String] = None,
      parameters: Option[Parameters] = None,
      sourceEntity: Option[AnalysisSourceEntity] = None,
      themeArn: Option[String] = None
    ): UpdateAnalysisRequest =
      UpdateAnalysisRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(name)(_.name(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(sourceEntity)(_.sourceEntity(_))
        .ifSome(themeArn)(_.themeArn(_))
        .build

    def updateAnalysisResponse(
      arn: Option[String] = None,
      analysisId: Option[String] = None,
      updateStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateAnalysisResponse =
      UpdateAnalysisResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(analysisId)(_.analysisId(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateDashboardPermissionsRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      grantPermissions: Option[List[ResourcePermission]] = None,
      revokePermissions: Option[List[ResourcePermission]] = None
    ): UpdateDashboardPermissionsRequest =
      UpdateDashboardPermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(grantPermissions)(_.grantPermissions(_))
        .ifSome(revokePermissions)(_.revokePermissions(_))
        .build

    def updateDashboardPermissionsResponse(
      dashboardArn: Option[String] = None,
      dashboardId: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateDashboardPermissionsResponse =
      UpdateDashboardPermissionsResponse
        .builder
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateDashboardPublishedVersionRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      versionNumber: Option[VersionNumber] = None
    ): UpdateDashboardPublishedVersionRequest =
      UpdateDashboardPublishedVersionRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def updateDashboardPublishedVersionResponse(
      dashboardId: Option[String] = None,
      dashboardArn: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateDashboardPublishedVersionResponse =
      UpdateDashboardPublishedVersionResponse
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateDashboardRequest(
      awsAccountId: Option[String] = None,
      dashboardId: Option[String] = None,
      name: Option[String] = None,
      sourceEntity: Option[DashboardSourceEntity] = None,
      parameters: Option[Parameters] = None,
      versionDescription: Option[String] = None,
      dashboardPublishOptions: Option[DashboardPublishOptions] = None,
      themeArn: Option[String] = None
    ): UpdateDashboardRequest =
      UpdateDashboardRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceEntity)(_.sourceEntity(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(dashboardPublishOptions)(_.dashboardPublishOptions(_))
        .ifSome(themeArn)(_.themeArn(_))
        .build

    def updateDashboardResponse(
      arn: Option[String] = None,
      versionArn: Option[String] = None,
      dashboardId: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateDashboardResponse =
      UpdateDashboardResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(versionArn)(_.versionArn(_))
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateDataSetPermissionsRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None,
      grantPermissions: Option[List[ResourcePermission]] = None,
      revokePermissions: Option[List[ResourcePermission]] = None
    ): UpdateDataSetPermissionsRequest =
      UpdateDataSetPermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(grantPermissions)(_.grantPermissions(_))
        .ifSome(revokePermissions)(_.revokePermissions(_))
        .build

    def updateDataSetPermissionsResponse(
      dataSetArn: Option[String] = None,
      dataSetId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateDataSetPermissionsResponse =
      UpdateDataSetPermissionsResponse
        .builder
        .ifSome(dataSetArn)(_.dataSetArn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateDataSetRequest(
      awsAccountId: Option[String] = None,
      dataSetId: Option[String] = None,
      name: Option[String] = None,
      physicalTableMap: Option[PhysicalTableMap] = None,
      logicalTableMap: Option[LogicalTableMap] = None,
      importMode: Option[String] = None,
      columnGroups: Option[List[ColumnGroup]] = None,
      fieldFolders: Option[FieldFolderMap] = None,
      rowLevelPermissionDataSet: Option[RowLevelPermissionDataSet] = None,
      columnLevelPermissionRules: Option[List[ColumnLevelPermissionRule]] = None
    ): UpdateDataSetRequest =
      UpdateDataSetRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(physicalTableMap)(_.physicalTableMap(_))
        .ifSome(logicalTableMap)(_.logicalTableMap(_))
        .ifSome(importMode)(_.importMode(_))
        .ifSome(columnGroups)(_.columnGroups(_))
        .ifSome(fieldFolders)(_.fieldFolders(_))
        .ifSome(rowLevelPermissionDataSet)(_.rowLevelPermissionDataSet(_))
        .ifSome(columnLevelPermissionRules)(_.columnLevelPermissionRules(_))
        .build

    def updateDataSetResponse(
      arn: Option[String] = None,
      dataSetId: Option[String] = None,
      ingestionArn: Option[String] = None,
      ingestionId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateDataSetResponse =
      UpdateDataSetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSetId)(_.dataSetId(_))
        .ifSome(ingestionArn)(_.ingestionArn(_))
        .ifSome(ingestionId)(_.ingestionId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateDataSourcePermissionsRequest(
      awsAccountId: Option[String] = None,
      dataSourceId: Option[String] = None,
      grantPermissions: Option[List[ResourcePermission]] = None,
      revokePermissions: Option[List[ResourcePermission]] = None
    ): UpdateDataSourcePermissionsRequest =
      UpdateDataSourcePermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(grantPermissions)(_.grantPermissions(_))
        .ifSome(revokePermissions)(_.revokePermissions(_))
        .build

    def updateDataSourcePermissionsResponse(
      dataSourceArn: Option[String] = None,
      dataSourceId: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateDataSourcePermissionsResponse =
      UpdateDataSourcePermissionsResponse
        .builder
        .ifSome(dataSourceArn)(_.dataSourceArn(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateDataSourceRequest(
      awsAccountId: Option[String] = None,
      dataSourceId: Option[String] = None,
      name: Option[String] = None,
      dataSourceParameters: Option[DataSourceParameters] = None,
      credentials: Option[DataSourceCredentials] = None,
      vpcConnectionProperties: Option[VpcConnectionProperties] = None,
      sslProperties: Option[SslProperties] = None
    ): UpdateDataSourceRequest =
      UpdateDataSourceRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(dataSourceParameters)(_.dataSourceParameters(_))
        .ifSome(credentials)(_.credentials(_))
        .ifSome(vpcConnectionProperties)(_.vpcConnectionProperties(_))
        .ifSome(sslProperties)(_.sslProperties(_))
        .build

    def updateDataSourceResponse(
      arn: Option[String] = None,
      dataSourceId: Option[String] = None,
      updateStatus: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateDataSourceResponse =
      UpdateDataSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateGroupRequest(
      groupName: Option[String] = None,
      description: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None
    ): UpdateGroupRequest =
      UpdateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .build

    def updateGroupResponse(
      group: Option[Group] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateGroupResponse =
      UpdateGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateIAMPolicyAssignmentRequest(
      awsAccountId: Option[String] = None,
      assignmentName: Option[String] = None,
      namespace: Option[String] = None,
      assignmentStatus: Option[String] = None,
      policyArn: Option[String] = None,
      identities: Option[IdentityMap] = None
    ): UpdateIAMPolicyAssignmentRequest =
      UpdateIAMPolicyAssignmentRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(identities)(_.identities(_))
        .build

    def updateIAMPolicyAssignmentResponse(
      assignmentName: Option[String] = None,
      assignmentId: Option[String] = None,
      policyArn: Option[String] = None,
      identities: Option[IdentityMap] = None,
      assignmentStatus: Option[String] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateIAMPolicyAssignmentResponse =
      UpdateIAMPolicyAssignmentResponse
        .builder
        .ifSome(assignmentName)(_.assignmentName(_))
        .ifSome(assignmentId)(_.assignmentId(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(identities)(_.identities(_))
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateTemplateAliasRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      aliasName: Option[String] = None,
      templateVersionNumber: Option[VersionNumber] = None
    ): UpdateTemplateAliasRequest =
      UpdateTemplateAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(templateVersionNumber)(_.templateVersionNumber(_))
        .build

    def updateTemplateAliasResponse(
      templateAlias: Option[TemplateAlias] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateTemplateAliasResponse =
      UpdateTemplateAliasResponse
        .builder
        .ifSome(templateAlias)(_.templateAlias(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateTemplatePermissionsRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      grantPermissions: Option[List[ResourcePermission]] = None,
      revokePermissions: Option[List[ResourcePermission]] = None
    ): UpdateTemplatePermissionsRequest =
      UpdateTemplatePermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(grantPermissions)(_.grantPermissions(_))
        .ifSome(revokePermissions)(_.revokePermissions(_))
        .build

    def updateTemplatePermissionsResponse(
      templateId: Option[String] = None,
      templateArn: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateTemplatePermissionsResponse =
      UpdateTemplatePermissionsResponse
        .builder
        .ifSome(templateId)(_.templateId(_))
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateTemplateRequest(
      awsAccountId: Option[String] = None,
      templateId: Option[String] = None,
      sourceEntity: Option[TemplateSourceEntity] = None,
      versionDescription: Option[String] = None,
      name: Option[String] = None
    ): UpdateTemplateRequest =
      UpdateTemplateRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(sourceEntity)(_.sourceEntity(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(name)(_.name(_))
        .build

    def updateTemplateResponse(
      templateId: Option[String] = None,
      arn: Option[String] = None,
      versionArn: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateTemplateResponse =
      UpdateTemplateResponse
        .builder
        .ifSome(templateId)(_.templateId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(versionArn)(_.versionArn(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateThemeAliasRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      aliasName: Option[String] = None,
      themeVersionNumber: Option[VersionNumber] = None
    ): UpdateThemeAliasRequest =
      UpdateThemeAliasRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(themeVersionNumber)(_.themeVersionNumber(_))
        .build

    def updateThemeAliasResponse(
      themeAlias: Option[ThemeAlias] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateThemeAliasResponse =
      UpdateThemeAliasResponse
        .builder
        .ifSome(themeAlias)(_.themeAlias(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateThemePermissionsRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      grantPermissions: Option[List[ResourcePermission]] = None,
      revokePermissions: Option[List[ResourcePermission]] = None
    ): UpdateThemePermissionsRequest =
      UpdateThemePermissionsRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(grantPermissions)(_.grantPermissions(_))
        .ifSome(revokePermissions)(_.revokePermissions(_))
        .build

    def updateThemePermissionsResponse(
      themeId: Option[String] = None,
      themeArn: Option[String] = None,
      permissions: Option[List[ResourcePermission]] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateThemePermissionsResponse =
      UpdateThemePermissionsResponse
        .builder
        .ifSome(themeId)(_.themeId(_))
        .ifSome(themeArn)(_.themeArn(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateThemeRequest(
      awsAccountId: Option[String] = None,
      themeId: Option[String] = None,
      name: Option[String] = None,
      baseThemeId: Option[String] = None,
      versionDescription: Option[String] = None,
      configuration: Option[ThemeConfiguration] = None
    ): UpdateThemeRequest =
      UpdateThemeRequest
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(themeId)(_.themeId(_))
        .ifSome(name)(_.name(_))
        .ifSome(baseThemeId)(_.baseThemeId(_))
        .ifSome(versionDescription)(_.versionDescription(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def updateThemeResponse(
      themeId: Option[String] = None,
      arn: Option[String] = None,
      versionArn: Option[String] = None,
      creationStatus: Option[String] = None,
      status: Option[Int] = None,
      requestId: Option[String] = None
    ): UpdateThemeResponse =
      UpdateThemeResponse
        .builder
        .ifSome(themeId)(_.themeId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(versionArn)(_.versionArn(_))
        .ifSome(creationStatus)(_.creationStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def updateUserRequest(
      userName: Option[String] = None,
      awsAccountId: Option[String] = None,
      namespace: Option[String] = None,
      email: Option[String] = None,
      role: Option[String] = None,
      customPermissionsName: Option[String] = None,
      unapplyCustomPermissions: Option[Boolean] = None,
      externalLoginFederationProviderType: Option[String] = None,
      customFederationProviderUrl: Option[String] = None,
      externalLoginId: Option[String] = None
    ): UpdateUserRequest =
      UpdateUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(email)(_.email(_))
        .ifSome(role)(_.role(_))
        .ifSome(customPermissionsName)(_.customPermissionsName(_))
        .ifSome(unapplyCustomPermissions)(_.unapplyCustomPermissions(_))
        .ifSome(externalLoginFederationProviderType)(_.externalLoginFederationProviderType(_))
        .ifSome(customFederationProviderUrl)(_.customFederationProviderUrl(_))
        .ifSome(externalLoginId)(_.externalLoginId(_))
        .build

    def updateUserResponse(
      user: Option[User] = None,
      requestId: Option[String] = None,
      status: Option[Int] = None
    ): UpdateUserResponse =
      UpdateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(status)(_.status(_))
        .build

    def uploadSettings(
      format: Option[String] = None,
      startFromRow: Option[Int] = None,
      containsHeader: Option[Boolean] = None,
      textQualifier: Option[String] = None,
      delimiter: Option[String] = None
    ): UploadSettings =
      UploadSettings
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(startFromRow)(_.startFromRow(_))
        .ifSome(containsHeader)(_.containsHeader(_))
        .ifSome(textQualifier)(_.textQualifier(_))
        .ifSome(delimiter)(_.delimiter(_))
        .build

    def user(
      arn: Option[String] = None,
      userName: Option[String] = None,
      email: Option[String] = None,
      role: Option[String] = None,
      identityType: Option[String] = None,
      active: Option[Boolean] = None,
      principalId: Option[String] = None,
      customPermissionsName: Option[String] = None,
      externalLoginFederationProviderType: Option[String] = None,
      externalLoginFederationProviderUrl: Option[String] = None,
      externalLoginId: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(email)(_.email(_))
        .ifSome(role)(_.role(_))
        .ifSome(identityType)(_.identityType(_))
        .ifSome(active)(_.active(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(customPermissionsName)(_.customPermissionsName(_))
        .ifSome(externalLoginFederationProviderType)(_.externalLoginFederationProviderType(_))
        .ifSome(externalLoginFederationProviderUrl)(_.externalLoginFederationProviderUrl(_))
        .ifSome(externalLoginId)(_.externalLoginId(_))
        .build

    def vpcConnectionProperties(
      vpcConnectionArn: Option[String] = None
    ): VpcConnectionProperties =
      VpcConnectionProperties
        .builder
        .ifSome(vpcConnectionArn)(_.vpcConnectionArn(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
