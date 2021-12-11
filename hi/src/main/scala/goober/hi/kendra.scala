package goober.hi

import goober.free.kendra.KendraIO
import software.amazon.awssdk.services.kendra.model._


object kendra {
  import goober.free.{kendra ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessControlListConfiguration(
      keyPath: Option[String] = None
    ): AccessControlListConfiguration =
      AccessControlListConfiguration
        .builder
        .ifSome(keyPath)(_.keyPath(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def aclConfiguration(
      allowedGroupsColumnName: Option[String] = None
    ): AclConfiguration =
      AclConfiguration
        .builder
        .ifSome(allowedGroupsColumnName)(_.allowedGroupsColumnName(_))
        .build

    def additionalResultAttribute(
      key: Option[String] = None,
      valueType: Option[String] = None,
      value: Option[AdditionalResultAttributeValue] = None
    ): AdditionalResultAttribute =
      AdditionalResultAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(valueType)(_.valueType(_))
        .ifSome(value)(_.value(_))
        .build

    def additionalResultAttributeValue(
      textWithHighlightsValue: Option[TextWithHighlights] = None
    ): AdditionalResultAttributeValue =
      AdditionalResultAttributeValue
        .builder
        .ifSome(textWithHighlightsValue)(_.textWithHighlightsValue(_))
        .build

    def attributeFilter(
      andAllFilters: Option[List[AttributeFilter]] = None,
      orAllFilters: Option[List[AttributeFilter]] = None,
      notFilter: Option[AttributeFilter] = None,
      equalsTo: Option[DocumentAttribute] = None,
      containsAll: Option[DocumentAttribute] = None,
      containsAny: Option[DocumentAttribute] = None,
      greaterThan: Option[DocumentAttribute] = None,
      greaterThanOrEquals: Option[DocumentAttribute] = None,
      lessThan: Option[DocumentAttribute] = None,
      lessThanOrEquals: Option[DocumentAttribute] = None
    ): AttributeFilter =
      AttributeFilter
        .builder
        .ifSome(andAllFilters)(_.andAllFilters(_))
        .ifSome(orAllFilters)(_.orAllFilters(_))
        .ifSome(notFilter)(_.notFilter(_))
        .ifSome(equalsTo)(_.equalsTo(_))
        .ifSome(containsAll)(_.containsAll(_))
        .ifSome(containsAny)(_.containsAny(_))
        .ifSome(greaterThan)(_.greaterThan(_))
        .ifSome(greaterThanOrEquals)(_.greaterThanOrEquals(_))
        .ifSome(lessThan)(_.lessThan(_))
        .ifSome(lessThanOrEquals)(_.lessThanOrEquals(_))
        .build

    def batchDeleteDocumentRequest(
      indexId: Option[String] = None,
      documentIdList: Option[List[DocumentId]] = None,
      dataSourceSyncJobMetricTarget: Option[DataSourceSyncJobMetricTarget] = None
    ): BatchDeleteDocumentRequest =
      BatchDeleteDocumentRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(documentIdList)(_.documentIdList(_))
        .ifSome(dataSourceSyncJobMetricTarget)(_.dataSourceSyncJobMetricTarget(_))
        .build

    def batchDeleteDocumentResponse(
      failedDocuments: Option[List[BatchDeleteDocumentResponseFailedDocument]] = None
    ): BatchDeleteDocumentResponse =
      BatchDeleteDocumentResponse
        .builder
        .ifSome(failedDocuments)(_.failedDocuments(_))
        .build

    def batchDeleteDocumentResponseFailedDocument(
      id: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchDeleteDocumentResponseFailedDocument =
      BatchDeleteDocumentResponseFailedDocument
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchGetDocumentStatusRequest(
      indexId: Option[String] = None,
      documentInfoList: Option[List[DocumentInfo]] = None
    ): BatchGetDocumentStatusRequest =
      BatchGetDocumentStatusRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(documentInfoList)(_.documentInfoList(_))
        .build

    def batchGetDocumentStatusResponse(
      errors: Option[List[BatchGetDocumentStatusResponseError]] = None,
      documentStatusList: Option[List[Status]] = None
    ): BatchGetDocumentStatusResponse =
      BatchGetDocumentStatusResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .ifSome(documentStatusList)(_.documentStatusList(_))
        .build

    def batchGetDocumentStatusResponseError(
      documentId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchGetDocumentStatusResponseError =
      BatchGetDocumentStatusResponseError
        .builder
        .ifSome(documentId)(_.documentId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchPutDocumentRequest(
      indexId: Option[String] = None,
      roleArn: Option[String] = None,
      documents: Option[List[Document]] = None
    ): BatchPutDocumentRequest =
      BatchPutDocumentRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(documents)(_.documents(_))
        .build

    def batchPutDocumentResponse(
      failedDocuments: Option[List[BatchPutDocumentResponseFailedDocument]] = None
    ): BatchPutDocumentResponse =
      BatchPutDocumentResponse
        .builder
        .ifSome(failedDocuments)(_.failedDocuments(_))
        .build

    def batchPutDocumentResponseFailedDocument(
      id: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchPutDocumentResponseFailedDocument =
      BatchPutDocumentResponseFailedDocument
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def capacityUnitsConfiguration(
      storageCapacityUnits: Option[Int] = None,
      queryCapacityUnits: Option[Int] = None
    ): CapacityUnitsConfiguration =
      CapacityUnitsConfiguration
        .builder
        .ifSome(storageCapacityUnits)(_.storageCapacityUnits(_))
        .ifSome(queryCapacityUnits)(_.queryCapacityUnits(_))
        .build

    def clearQuerySuggestionsRequest(
      indexId: Option[String] = None
    ): ClearQuerySuggestionsRequest =
      ClearQuerySuggestionsRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .build

    def clickFeedback(
      resultId: Option[String] = None,
      clickTime: Option[Timestamp] = None
    ): ClickFeedback =
      ClickFeedback
        .builder
        .ifSome(resultId)(_.resultId(_))
        .ifSome(clickTime)(_.clickTime(_))
        .build

    def columnConfiguration(
      documentIdColumnName: Option[String] = None,
      documentDataColumnName: Option[String] = None,
      documentTitleColumnName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None,
      changeDetectingColumns: Option[List[ColumnName]] = None
    ): ColumnConfiguration =
      ColumnConfiguration
        .builder
        .ifSome(documentIdColumnName)(_.documentIdColumnName(_))
        .ifSome(documentDataColumnName)(_.documentDataColumnName(_))
        .ifSome(documentTitleColumnName)(_.documentTitleColumnName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .ifSome(changeDetectingColumns)(_.changeDetectingColumns(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def confluenceAttachmentConfiguration(
      crawlAttachments: Option[Boolean] = None,
      attachmentFieldMappings: Option[List[ConfluenceAttachmentToIndexFieldMapping]] = None
    ): ConfluenceAttachmentConfiguration =
      ConfluenceAttachmentConfiguration
        .builder
        .ifSome(crawlAttachments)(_.crawlAttachments(_))
        .ifSome(attachmentFieldMappings)(_.attachmentFieldMappings(_))
        .build

    def confluenceAttachmentToIndexFieldMapping(
      dataSourceFieldName: Option[String] = None,
      dateFieldFormat: Option[String] = None,
      indexFieldName: Option[String] = None
    ): ConfluenceAttachmentToIndexFieldMapping =
      ConfluenceAttachmentToIndexFieldMapping
        .builder
        .ifSome(dataSourceFieldName)(_.dataSourceFieldName(_))
        .ifSome(dateFieldFormat)(_.dateFieldFormat(_))
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .build

    def confluenceBlogConfiguration(
      blogFieldMappings: Option[List[ConfluenceBlogToIndexFieldMapping]] = None
    ): ConfluenceBlogConfiguration =
      ConfluenceBlogConfiguration
        .builder
        .ifSome(blogFieldMappings)(_.blogFieldMappings(_))
        .build

    def confluenceBlogToIndexFieldMapping(
      dataSourceFieldName: Option[String] = None,
      dateFieldFormat: Option[String] = None,
      indexFieldName: Option[String] = None
    ): ConfluenceBlogToIndexFieldMapping =
      ConfluenceBlogToIndexFieldMapping
        .builder
        .ifSome(dataSourceFieldName)(_.dataSourceFieldName(_))
        .ifSome(dateFieldFormat)(_.dateFieldFormat(_))
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .build

    def confluenceConfiguration(
      serverUrl: Option[String] = None,
      secretArn: Option[String] = None,
      version: Option[String] = None,
      spaceConfiguration: Option[ConfluenceSpaceConfiguration] = None,
      pageConfiguration: Option[ConfluencePageConfiguration] = None,
      blogConfiguration: Option[ConfluenceBlogConfiguration] = None,
      attachmentConfiguration: Option[ConfluenceAttachmentConfiguration] = None,
      vpcConfiguration: Option[DataSourceVpcConfiguration] = None,
      inclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      exclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None
    ): ConfluenceConfiguration =
      ConfluenceConfiguration
        .builder
        .ifSome(serverUrl)(_.serverUrl(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(spaceConfiguration)(_.spaceConfiguration(_))
        .ifSome(pageConfiguration)(_.pageConfiguration(_))
        .ifSome(blogConfiguration)(_.blogConfiguration(_))
        .ifSome(attachmentConfiguration)(_.attachmentConfiguration(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(inclusionPatterns)(_.inclusionPatterns(_))
        .ifSome(exclusionPatterns)(_.exclusionPatterns(_))
        .build

    def confluencePageConfiguration(
      pageFieldMappings: Option[List[ConfluencePageToIndexFieldMapping]] = None
    ): ConfluencePageConfiguration =
      ConfluencePageConfiguration
        .builder
        .ifSome(pageFieldMappings)(_.pageFieldMappings(_))
        .build

    def confluencePageToIndexFieldMapping(
      dataSourceFieldName: Option[String] = None,
      dateFieldFormat: Option[String] = None,
      indexFieldName: Option[String] = None
    ): ConfluencePageToIndexFieldMapping =
      ConfluencePageToIndexFieldMapping
        .builder
        .ifSome(dataSourceFieldName)(_.dataSourceFieldName(_))
        .ifSome(dateFieldFormat)(_.dateFieldFormat(_))
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .build

    def confluenceSpaceConfiguration(
      crawlPersonalSpaces: Option[Boolean] = None,
      crawlArchivedSpaces: Option[Boolean] = None,
      includeSpaces: Option[List[ConfluenceSpaceIdentifier]] = None,
      excludeSpaces: Option[List[ConfluenceSpaceIdentifier]] = None,
      spaceFieldMappings: Option[List[ConfluenceSpaceToIndexFieldMapping]] = None
    ): ConfluenceSpaceConfiguration =
      ConfluenceSpaceConfiguration
        .builder
        .ifSome(crawlPersonalSpaces)(_.crawlPersonalSpaces(_))
        .ifSome(crawlArchivedSpaces)(_.crawlArchivedSpaces(_))
        .ifSome(includeSpaces)(_.includeSpaces(_))
        .ifSome(excludeSpaces)(_.excludeSpaces(_))
        .ifSome(spaceFieldMappings)(_.spaceFieldMappings(_))
        .build

    def confluenceSpaceToIndexFieldMapping(
      dataSourceFieldName: Option[String] = None,
      dateFieldFormat: Option[String] = None,
      indexFieldName: Option[String] = None
    ): ConfluenceSpaceToIndexFieldMapping =
      ConfluenceSpaceToIndexFieldMapping
        .builder
        .ifSome(dataSourceFieldName)(_.dataSourceFieldName(_))
        .ifSome(dateFieldFormat)(_.dateFieldFormat(_))
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .build

    def connectionConfiguration(
      databaseHost: Option[String] = None,
      databasePort: Option[Int] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      secretArn: Option[String] = None
    ): ConnectionConfiguration =
      ConnectionConfiguration
        .builder
        .ifSome(databaseHost)(_.databaseHost(_))
        .ifSome(databasePort)(_.databasePort(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def createDataSourceRequest(
      name: Option[String] = None,
      indexId: Option[String] = None,
      `type`: Option[String] = None,
      configuration: Option[DataSourceConfiguration] = None,
      description: Option[String] = None,
      schedule: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      clientToken: Option[String] = None
    ): CreateDataSourceRequest =
      CreateDataSourceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createDataSourceResponse(
      id: Option[String] = None
    ): CreateDataSourceResponse =
      CreateDataSourceResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def createFaqRequest(
      indexId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      s3Path: Option[S3Path] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fileFormat: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateFaqRequest =
      CreateFaqRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(s3Path)(_.s3Path(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createFaqResponse(
      id: Option[String] = None
    ): CreateFaqResponse =
      CreateFaqResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def createIndexRequest(
      name: Option[String] = None,
      edition: Option[String] = None,
      roleArn: Option[String] = None,
      serverSideEncryptionConfiguration: Option[ServerSideEncryptionConfiguration] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[List[Tag]] = None,
      userTokenConfigurations: Option[List[UserTokenConfiguration]] = None,
      userContextPolicy: Option[String] = None
    ): CreateIndexRequest =
      CreateIndexRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(edition)(_.edition(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(serverSideEncryptionConfiguration)(_.serverSideEncryptionConfiguration(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userTokenConfigurations)(_.userTokenConfigurations(_))
        .ifSome(userContextPolicy)(_.userContextPolicy(_))
        .build

    def createIndexResponse(
      id: Option[String] = None
    ): CreateIndexResponse =
      CreateIndexResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def createQuerySuggestionsBlockListRequest(
      indexId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      sourceS3Path: Option[S3Path] = None,
      clientToken: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateQuerySuggestionsBlockListRequest =
      CreateQuerySuggestionsBlockListRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(sourceS3Path)(_.sourceS3Path(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createQuerySuggestionsBlockListResponse(
      id: Option[String] = None
    ): CreateQuerySuggestionsBlockListResponse =
      CreateQuerySuggestionsBlockListResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def createThesaurusRequest(
      indexId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      sourceS3Path: Option[S3Path] = None,
      clientToken: Option[String] = None
    ): CreateThesaurusRequest =
      CreateThesaurusRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(sourceS3Path)(_.sourceS3Path(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createThesaurusResponse(
      id: Option[String] = None
    ): CreateThesaurusResponse =
      CreateThesaurusResponse
        .builder
        .ifSome(id)(_.id(_))
        .build

    def dataSourceConfiguration(
      s3Configuration: Option[S3DataSourceConfiguration] = None,
      sharePointConfiguration: Option[SharePointConfiguration] = None,
      databaseConfiguration: Option[DatabaseConfiguration] = None,
      salesforceConfiguration: Option[SalesforceConfiguration] = None,
      oneDriveConfiguration: Option[OneDriveConfiguration] = None,
      serviceNowConfiguration: Option[ServiceNowConfiguration] = None,
      confluenceConfiguration: Option[ConfluenceConfiguration] = None,
      googleDriveConfiguration: Option[GoogleDriveConfiguration] = None
    ): DataSourceConfiguration =
      DataSourceConfiguration
        .builder
        .ifSome(s3Configuration)(_.s3Configuration(_))
        .ifSome(sharePointConfiguration)(_.sharePointConfiguration(_))
        .ifSome(databaseConfiguration)(_.databaseConfiguration(_))
        .ifSome(salesforceConfiguration)(_.salesforceConfiguration(_))
        .ifSome(oneDriveConfiguration)(_.oneDriveConfiguration(_))
        .ifSome(serviceNowConfiguration)(_.serviceNowConfiguration(_))
        .ifSome(confluenceConfiguration)(_.confluenceConfiguration(_))
        .ifSome(googleDriveConfiguration)(_.googleDriveConfiguration(_))
        .build

    def dataSourceSummary(
      name: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      status: Option[String] = None
    ): DataSourceSummary =
      DataSourceSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(status)(_.status(_))
        .build

    def dataSourceSyncJob(
      executionId: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      status: Option[String] = None,
      errorMessage: Option[String] = None,
      errorCode: Option[String] = None,
      dataSourceErrorCode: Option[String] = None,
      metrics: Option[DataSourceSyncJobMetrics] = None
    ): DataSourceSyncJob =
      DataSourceSyncJob
        .builder
        .ifSome(executionId)(_.executionId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(dataSourceErrorCode)(_.dataSourceErrorCode(_))
        .ifSome(metrics)(_.metrics(_))
        .build

    def dataSourceSyncJobMetricTarget(
      dataSourceId: Option[String] = None,
      dataSourceSyncJobId: Option[String] = None
    ): DataSourceSyncJobMetricTarget =
      DataSourceSyncJobMetricTarget
        .builder
        .ifSome(dataSourceId)(_.dataSourceId(_))
        .ifSome(dataSourceSyncJobId)(_.dataSourceSyncJobId(_))
        .build

    def dataSourceSyncJobMetrics(
      documentsAdded: Option[String] = None,
      documentsModified: Option[String] = None,
      documentsDeleted: Option[String] = None,
      documentsFailed: Option[String] = None,
      documentsScanned: Option[String] = None
    ): DataSourceSyncJobMetrics =
      DataSourceSyncJobMetrics
        .builder
        .ifSome(documentsAdded)(_.documentsAdded(_))
        .ifSome(documentsModified)(_.documentsModified(_))
        .ifSome(documentsDeleted)(_.documentsDeleted(_))
        .ifSome(documentsFailed)(_.documentsFailed(_))
        .ifSome(documentsScanned)(_.documentsScanned(_))
        .build

    def dataSourceToIndexFieldMapping(
      dataSourceFieldName: Option[String] = None,
      dateFieldFormat: Option[String] = None,
      indexFieldName: Option[String] = None
    ): DataSourceToIndexFieldMapping =
      DataSourceToIndexFieldMapping
        .builder
        .ifSome(dataSourceFieldName)(_.dataSourceFieldName(_))
        .ifSome(dateFieldFormat)(_.dateFieldFormat(_))
        .ifSome(indexFieldName)(_.indexFieldName(_))
        .build

    def dataSourceVpcConfiguration(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[VpcSecurityGroupId]] = None
    ): DataSourceVpcConfiguration =
      DataSourceVpcConfiguration
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def databaseConfiguration(
      databaseEngineType: Option[String] = None,
      connectionConfiguration: Option[ConnectionConfiguration] = None,
      vpcConfiguration: Option[DataSourceVpcConfiguration] = None,
      columnConfiguration: Option[ColumnConfiguration] = None,
      aclConfiguration: Option[AclConfiguration] = None,
      sqlConfiguration: Option[SqlConfiguration] = None
    ): DatabaseConfiguration =
      DatabaseConfiguration
        .builder
        .ifSome(databaseEngineType)(_.databaseEngineType(_))
        .ifSome(connectionConfiguration)(_.connectionConfiguration(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(columnConfiguration)(_.columnConfiguration(_))
        .ifSome(aclConfiguration)(_.aclConfiguration(_))
        .ifSome(sqlConfiguration)(_.sqlConfiguration(_))
        .build

    def deleteDataSourceRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): DeleteDataSourceRequest =
      DeleteDataSourceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def deleteFaqRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): DeleteFaqRequest =
      DeleteFaqRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def deleteIndexRequest(
      id: Option[String] = None
    ): DeleteIndexRequest =
      DeleteIndexRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteQuerySuggestionsBlockListRequest(
      indexId: Option[String] = None,
      id: Option[String] = None
    ): DeleteQuerySuggestionsBlockListRequest =
      DeleteQuerySuggestionsBlockListRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(id)(_.id(_))
        .build

    def deleteThesaurusRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): DeleteThesaurusRequest =
      DeleteThesaurusRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def describeDataSourceRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): DescribeDataSourceRequest =
      DescribeDataSourceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def describeDataSourceResponse(
      id: Option[String] = None,
      indexId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      configuration: Option[DataSourceConfiguration] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      schedule: Option[String] = None,
      roleArn: Option[String] = None,
      errorMessage: Option[String] = None
    ): DescribeDataSourceResponse =
      DescribeDataSourceResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def describeFaqRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): DescribeFaqRequest =
      DescribeFaqRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def describeFaqResponse(
      id: Option[String] = None,
      indexId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      s3Path: Option[S3Path] = None,
      status: Option[String] = None,
      roleArn: Option[String] = None,
      errorMessage: Option[String] = None,
      fileFormat: Option[String] = None
    ): DescribeFaqResponse =
      DescribeFaqResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(s3Path)(_.s3Path(_))
        .ifSome(status)(_.status(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .build

    def describeIndexRequest(
      id: Option[String] = None
    ): DescribeIndexRequest =
      DescribeIndexRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeIndexResponse(
      name: Option[String] = None,
      id: Option[String] = None,
      edition: Option[String] = None,
      roleArn: Option[String] = None,
      serverSideEncryptionConfiguration: Option[ServerSideEncryptionConfiguration] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      documentMetadataConfigurations: Option[List[DocumentMetadataConfiguration]] = None,
      indexStatistics: Option[IndexStatistics] = None,
      errorMessage: Option[String] = None,
      capacityUnits: Option[CapacityUnitsConfiguration] = None,
      userTokenConfigurations: Option[List[UserTokenConfiguration]] = None,
      userContextPolicy: Option[String] = None
    ): DescribeIndexResponse =
      DescribeIndexResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(edition)(_.edition(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(serverSideEncryptionConfiguration)(_.serverSideEncryptionConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(documentMetadataConfigurations)(_.documentMetadataConfigurations(_))
        .ifSome(indexStatistics)(_.indexStatistics(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(capacityUnits)(_.capacityUnits(_))
        .ifSome(userTokenConfigurations)(_.userTokenConfigurations(_))
        .ifSome(userContextPolicy)(_.userContextPolicy(_))
        .build

    def describeQuerySuggestionsBlockListRequest(
      indexId: Option[String] = None,
      id: Option[String] = None
    ): DescribeQuerySuggestionsBlockListRequest =
      DescribeQuerySuggestionsBlockListRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(id)(_.id(_))
        .build

    def describeQuerySuggestionsBlockListResponse(
      indexId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      errorMessage: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      sourceS3Path: Option[S3Path] = None,
      itemCount: Option[Int] = None,
      fileSizeBytes: Option[Long] = None,
      roleArn: Option[String] = None
    ): DescribeQuerySuggestionsBlockListResponse =
      DescribeQuerySuggestionsBlockListResponse
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(sourceS3Path)(_.sourceS3Path(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(fileSizeBytes)(_.fileSizeBytes(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def describeQuerySuggestionsConfigRequest(
      indexId: Option[String] = None
    ): DescribeQuerySuggestionsConfigRequest =
      DescribeQuerySuggestionsConfigRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .build

    def describeQuerySuggestionsConfigResponse(
      mode: Option[String] = None,
      status: Option[String] = None,
      queryLogLookBackWindowInDays: Option[Int] = None,
      includeQueriesWithoutUserInformation: Option[Boolean] = None,
      minimumNumberOfQueryingUsers: Option[Int] = None,
      minimumQueryCount: Option[Int] = None,
      lastSuggestionsBuildTime: Option[Timestamp] = None,
      lastClearTime: Option[Timestamp] = None,
      totalSuggestionsCount: Option[Int] = None
    ): DescribeQuerySuggestionsConfigResponse =
      DescribeQuerySuggestionsConfigResponse
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(status)(_.status(_))
        .ifSome(queryLogLookBackWindowInDays)(_.queryLogLookBackWindowInDays(_))
        .ifSome(includeQueriesWithoutUserInformation)(_.includeQueriesWithoutUserInformation(_))
        .ifSome(minimumNumberOfQueryingUsers)(_.minimumNumberOfQueryingUsers(_))
        .ifSome(minimumQueryCount)(_.minimumQueryCount(_))
        .ifSome(lastSuggestionsBuildTime)(_.lastSuggestionsBuildTime(_))
        .ifSome(lastClearTime)(_.lastClearTime(_))
        .ifSome(totalSuggestionsCount)(_.totalSuggestionsCount(_))
        .build

    def describeThesaurusRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): DescribeThesaurusRequest =
      DescribeThesaurusRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def describeThesaurusResponse(
      id: Option[String] = None,
      indexId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      errorMessage: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      sourceS3Path: Option[S3Path] = None,
      fileSizeBytes: Option[Long] = None,
      termCount: Option[Long] = None,
      synonymRuleCount: Option[Long] = None
    ): DescribeThesaurusResponse =
      DescribeThesaurusResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(sourceS3Path)(_.sourceS3Path(_))
        .ifSome(fileSizeBytes)(_.fileSizeBytes(_))
        .ifSome(termCount)(_.termCount(_))
        .ifSome(synonymRuleCount)(_.synonymRuleCount(_))
        .build

    def document(
      id: Option[String] = None,
      title: Option[String] = None,
      blob: Option[Blob] = None,
      s3Path: Option[S3Path] = None,
      attributes: Option[List[DocumentAttribute]] = None,
      accessControlList: Option[List[Principal]] = None,
      contentType: Option[String] = None
    ): Document =
      Document
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(title)(_.title(_))
        .ifSome(blob)(_.blob(_))
        .ifSome(s3Path)(_.s3Path(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(accessControlList)(_.accessControlList(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def documentAttribute(
      key: Option[String] = None,
      value: Option[DocumentAttributeValue] = None
    ): DocumentAttribute =
      DocumentAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def documentAttributeValue(
      stringValue: Option[String] = None,
      stringListValue: Option[List[String]] = None,
      longValue: Option[Long] = None,
      dateValue: Option[Timestamp] = None
    ): DocumentAttributeValue =
      DocumentAttributeValue
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(stringListValue)(_.stringListValue(_))
        .ifSome(longValue)(_.longValue(_))
        .ifSome(dateValue)(_.dateValue(_))
        .build

    def documentAttributeValueCountPair(
      documentAttributeValue: Option[DocumentAttributeValue] = None,
      count: Option[Int] = None
    ): DocumentAttributeValueCountPair =
      DocumentAttributeValueCountPair
        .builder
        .ifSome(documentAttributeValue)(_.documentAttributeValue(_))
        .ifSome(count)(_.count(_))
        .build

    def documentInfo(
      documentId: Option[String] = None,
      attributes: Option[List[DocumentAttribute]] = None
    ): DocumentInfo =
      DocumentInfo
        .builder
        .ifSome(documentId)(_.documentId(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def documentMetadataConfiguration(
      name: Option[String] = None,
      `type`: Option[String] = None,
      relevance: Option[Relevance] = None,
      search: Option[Search] = None
    ): DocumentMetadataConfiguration =
      DocumentMetadataConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(relevance)(_.relevance(_))
        .ifSome(search)(_.search(_))
        .build

    def documentRelevanceConfiguration(
      name: Option[String] = None,
      relevance: Option[Relevance] = None
    ): DocumentRelevanceConfiguration =
      DocumentRelevanceConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(relevance)(_.relevance(_))
        .build

    def documentsMetadataConfiguration(
      s3Prefix: Option[String] = None
    ): DocumentsMetadataConfiguration =
      DocumentsMetadataConfiguration
        .builder
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def facet(
      documentAttributeKey: Option[String] = None
    ): Facet =
      Facet
        .builder
        .ifSome(documentAttributeKey)(_.documentAttributeKey(_))
        .build

    def faqStatistics(
      indexedQuestionAnswersCount: Option[Int] = None
    ): FaqStatistics =
      FaqStatistics
        .builder
        .ifSome(indexedQuestionAnswersCount)(_.indexedQuestionAnswersCount(_))
        .build

    def faqSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      fileFormat: Option[String] = None
    ): FaqSummary =
      FaqSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(fileFormat)(_.fileFormat(_))
        .build

    def getQuerySuggestionsRequest(
      indexId: Option[String] = None,
      queryText: Option[String] = None,
      maxSuggestionsCount: Option[Int] = None
    ): GetQuerySuggestionsRequest =
      GetQuerySuggestionsRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(queryText)(_.queryText(_))
        .ifSome(maxSuggestionsCount)(_.maxSuggestionsCount(_))
        .build

    def getQuerySuggestionsResponse(
      querySuggestionsId: Option[String] = None,
      suggestions: Option[List[Suggestion]] = None
    ): GetQuerySuggestionsResponse =
      GetQuerySuggestionsResponse
        .builder
        .ifSome(querySuggestionsId)(_.querySuggestionsId(_))
        .ifSome(suggestions)(_.suggestions(_))
        .build

    def googleDriveConfiguration(
      secretArn: Option[String] = None,
      inclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      exclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None,
      excludeMimeTypes: Option[List[MimeType]] = None,
      excludeUserAccounts: Option[List[UserAccount]] = None,
      excludeSharedDrives: Option[List[SharedDriveId]] = None
    ): GoogleDriveConfiguration =
      GoogleDriveConfiguration
        .builder
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(inclusionPatterns)(_.inclusionPatterns(_))
        .ifSome(exclusionPatterns)(_.exclusionPatterns(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .ifSome(excludeMimeTypes)(_.excludeMimeTypes(_))
        .ifSome(excludeUserAccounts)(_.excludeUserAccounts(_))
        .ifSome(excludeSharedDrives)(_.excludeSharedDrives(_))
        .build

    def highlight(
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      topAnswer: Option[Boolean] = None,
      `type`: Option[String] = None
    ): Highlight =
      Highlight
        .builder
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(topAnswer)(_.topAnswer(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def indexConfigurationSummary(
      name: Option[String] = None,
      id: Option[String] = None,
      edition: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      status: Option[String] = None
    ): IndexConfigurationSummary =
      IndexConfigurationSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(edition)(_.edition(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(status)(_.status(_))
        .build

    def indexStatistics(
      faqStatistics: Option[FaqStatistics] = None,
      textDocumentStatistics: Option[TextDocumentStatistics] = None
    ): IndexStatistics =
      IndexStatistics
        .builder
        .ifSome(faqStatistics)(_.faqStatistics(_))
        .ifSome(textDocumentStatistics)(_.textDocumentStatistics(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jsonTokenTypeConfiguration(
      userNameAttributeField: Option[String] = None,
      groupAttributeField: Option[String] = None
    ): JsonTokenTypeConfiguration =
      JsonTokenTypeConfiguration
        .builder
        .ifSome(userNameAttributeField)(_.userNameAttributeField(_))
        .ifSome(groupAttributeField)(_.groupAttributeField(_))
        .build

    def jwtTokenTypeConfiguration(
      keyLocation: Option[String] = None,
      uRL: Option[String] = None,
      secretManagerArn: Option[String] = None,
      userNameAttributeField: Option[String] = None,
      groupAttributeField: Option[String] = None,
      issuer: Option[String] = None,
      claimRegex: Option[String] = None
    ): JwtTokenTypeConfiguration =
      JwtTokenTypeConfiguration
        .builder
        .ifSome(keyLocation)(_.keyLocation(_))
        .ifSome(uRL)(_.uRL(_))
        .ifSome(secretManagerArn)(_.secretManagerArn(_))
        .ifSome(userNameAttributeField)(_.userNameAttributeField(_))
        .ifSome(groupAttributeField)(_.groupAttributeField(_))
        .ifSome(issuer)(_.issuer(_))
        .ifSome(claimRegex)(_.claimRegex(_))
        .build

    def listDataSourceSyncJobsRequest(
      id: Option[String] = None,
      indexId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      startTimeFilter: Option[TimeRange] = None,
      statusFilter: Option[String] = None
    ): ListDataSourceSyncJobsRequest =
      ListDataSourceSyncJobsRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(startTimeFilter)(_.startTimeFilter(_))
        .ifSome(statusFilter)(_.statusFilter(_))
        .build

    def listDataSourceSyncJobsResponse(
      history: Option[List[DataSourceSyncJob]] = None,
      nextToken: Option[String] = None
    ): ListDataSourceSyncJobsResponse =
      ListDataSourceSyncJobsResponse
        .builder
        .ifSome(history)(_.history(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDataSourcesRequest(
      indexId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDataSourcesRequest =
      ListDataSourcesRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDataSourcesResponse(
      summaryItems: Option[List[DataSourceSummary]] = None,
      nextToken: Option[String] = None
    ): ListDataSourcesResponse =
      ListDataSourcesResponse
        .builder
        .ifSome(summaryItems)(_.summaryItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFaqsRequest(
      indexId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFaqsRequest =
      ListFaqsRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFaqsResponse(
      nextToken: Option[String] = None,
      faqSummaryItems: Option[List[FaqSummary]] = None
    ): ListFaqsResponse =
      ListFaqsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(faqSummaryItems)(_.faqSummaryItems(_))
        .build

    def listIndicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIndicesRequest =
      ListIndicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIndicesResponse(
      indexConfigurationSummaryItems: Option[List[IndexConfigurationSummary]] = None,
      nextToken: Option[String] = None
    ): ListIndicesResponse =
      ListIndicesResponse
        .builder
        .ifSome(indexConfigurationSummaryItems)(_.indexConfigurationSummaryItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listQuerySuggestionsBlockListsRequest(
      indexId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListQuerySuggestionsBlockListsRequest =
      ListQuerySuggestionsBlockListsRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listQuerySuggestionsBlockListsResponse(
      blockListSummaryItems: Option[List[QuerySuggestionsBlockListSummary]] = None,
      nextToken: Option[String] = None
    ): ListQuerySuggestionsBlockListsResponse =
      ListQuerySuggestionsBlockListsResponse
        .builder
        .ifSome(blockListSummaryItems)(_.blockListSummaryItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listThesauriRequest(
      indexId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThesauriRequest =
      ListThesauriRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThesauriResponse(
      nextToken: Option[String] = None,
      thesaurusSummaryItems: Option[List[ThesaurusSummary]] = None
    ): ListThesauriResponse =
      ListThesauriResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(thesaurusSummaryItems)(_.thesaurusSummaryItems(_))
        .build

    def oneDriveConfiguration(
      tenantDomain: Option[String] = None,
      secretArn: Option[String] = None,
      oneDriveUsers: Option[OneDriveUsers] = None,
      inclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      exclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None,
      disableLocalGroups: Option[Boolean] = None
    ): OneDriveConfiguration =
      OneDriveConfiguration
        .builder
        .ifSome(tenantDomain)(_.tenantDomain(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(oneDriveUsers)(_.oneDriveUsers(_))
        .ifSome(inclusionPatterns)(_.inclusionPatterns(_))
        .ifSome(exclusionPatterns)(_.exclusionPatterns(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .ifSome(disableLocalGroups)(_.disableLocalGroups(_))
        .build

    def oneDriveUsers(
      oneDriveUserList: Option[List[OneDriveUser]] = None,
      oneDriveUserS3Path: Option[S3Path] = None
    ): OneDriveUsers =
      OneDriveUsers
        .builder
        .ifSome(oneDriveUserList)(_.oneDriveUserList(_))
        .ifSome(oneDriveUserS3Path)(_.oneDriveUserS3Path(_))
        .build

    def principal(
      name: Option[String] = None,
      `type`: Option[String] = None,
      access: Option[String] = None
    ): Principal =
      Principal
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(access)(_.access(_))
        .build

    def queryRequest(
      indexId: Option[String] = None,
      queryText: Option[String] = None,
      attributeFilter: Option[AttributeFilter] = None,
      facets: Option[List[Facet]] = None,
      requestedDocumentAttributes: Option[List[DocumentAttributeKey]] = None,
      queryResultTypeFilter: Option[String] = None,
      documentRelevanceOverrideConfigurations: Option[List[DocumentRelevanceConfiguration]] = None,
      pageNumber: Option[Int] = None,
      pageSize: Option[Int] = None,
      sortingConfiguration: Option[SortingConfiguration] = None,
      userContext: Option[UserContext] = None,
      visitorId: Option[String] = None
    ): QueryRequest =
      QueryRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(queryText)(_.queryText(_))
        .ifSome(attributeFilter)(_.attributeFilter(_))
        .ifSome(facets)(_.facets(_))
        .ifSome(requestedDocumentAttributes)(_.requestedDocumentAttributes(_))
        .ifSome(queryResultTypeFilter)(_.queryResultTypeFilter(_))
        .ifSome(documentRelevanceOverrideConfigurations)(_.documentRelevanceOverrideConfigurations(_))
        .ifSome(pageNumber)(_.pageNumber(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(sortingConfiguration)(_.sortingConfiguration(_))
        .ifSome(userContext)(_.userContext(_))
        .ifSome(visitorId)(_.visitorId(_))
        .build

    def queryResultItem(
      id: Option[String] = None,
      `type`: Option[String] = None,
      additionalAttributes: Option[List[AdditionalResultAttribute]] = None,
      documentId: Option[String] = None,
      documentTitle: Option[TextWithHighlights] = None,
      documentExcerpt: Option[TextWithHighlights] = None,
      documentURI: Option[String] = None,
      documentAttributes: Option[List[DocumentAttribute]] = None,
      scoreAttributes: Option[ScoreAttributes] = None,
      feedbackToken: Option[String] = None
    ): QueryResultItem =
      QueryResultItem
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(additionalAttributes)(_.additionalAttributes(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(documentTitle)(_.documentTitle(_))
        .ifSome(documentExcerpt)(_.documentExcerpt(_))
        .ifSome(documentURI)(_.documentURI(_))
        .ifSome(documentAttributes)(_.documentAttributes(_))
        .ifSome(scoreAttributes)(_.scoreAttributes(_))
        .ifSome(feedbackToken)(_.feedbackToken(_))
        .build

    def querySuggestionsBlockListSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      itemCount: Option[Int] = None
    ): QuerySuggestionsBlockListSummary =
      QuerySuggestionsBlockListSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(itemCount)(_.itemCount(_))
        .build

    def relevance(
      freshness: Option[Boolean] = None,
      importance: Option[Int] = None,
      duration: Option[String] = None,
      rankOrder: Option[String] = None,
      valueImportanceMap: Option[ValueImportanceMap] = None
    ): Relevance =
      Relevance
        .builder
        .ifSome(freshness)(_.freshness(_))
        .ifSome(importance)(_.importance(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(rankOrder)(_.rankOrder(_))
        .ifSome(valueImportanceMap)(_.valueImportanceMap(_))
        .build

    def relevanceFeedback(
      resultId: Option[String] = None,
      relevanceValue: Option[String] = None
    ): RelevanceFeedback =
      RelevanceFeedback
        .builder
        .ifSome(resultId)(_.resultId(_))
        .ifSome(relevanceValue)(_.relevanceValue(_))
        .build

    def resourceAlreadyExistException(
      message: Option[String] = None
    ): ResourceAlreadyExistException =
      ResourceAlreadyExistException
        .builder
        .ifSome(message)(_.message(_))
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

    def resourceUnavailableException(
      message: Option[String] = None
    ): ResourceUnavailableException =
      ResourceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3DataSourceConfiguration(
      bucketName: Option[String] = None,
      inclusionPrefixes: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      inclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      exclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      documentsMetadataConfiguration: Option[DocumentsMetadataConfiguration] = None,
      accessControlListConfiguration: Option[AccessControlListConfiguration] = None
    ): S3DataSourceConfiguration =
      S3DataSourceConfiguration
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(inclusionPrefixes)(_.inclusionPrefixes(_))
        .ifSome(inclusionPatterns)(_.inclusionPatterns(_))
        .ifSome(exclusionPatterns)(_.exclusionPatterns(_))
        .ifSome(documentsMetadataConfiguration)(_.documentsMetadataConfiguration(_))
        .ifSome(accessControlListConfiguration)(_.accessControlListConfiguration(_))
        .build

    def s3Path(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): S3Path =
      S3Path
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def salesforceChatterFeedConfiguration(
      documentDataFieldName: Option[String] = None,
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None,
      includeFilterTypes: Option[List[SalesforceChatterFeedIncludeFilterType]] = None
    ): SalesforceChatterFeedConfiguration =
      SalesforceChatterFeedConfiguration
        .builder
        .ifSome(documentDataFieldName)(_.documentDataFieldName(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .ifSome(includeFilterTypes)(_.includeFilterTypes(_))
        .build

    def salesforceConfiguration(
      serverUrl: Option[String] = None,
      secretArn: Option[String] = None,
      standardObjectConfigurations: Option[List[SalesforceStandardObjectConfiguration]] = None,
      knowledgeArticleConfiguration: Option[SalesforceKnowledgeArticleConfiguration] = None,
      chatterFeedConfiguration: Option[SalesforceChatterFeedConfiguration] = None,
      crawlAttachments: Option[Boolean] = None,
      standardObjectAttachmentConfiguration: Option[SalesforceStandardObjectAttachmentConfiguration] = None,
      includeAttachmentFilePatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      excludeAttachmentFilePatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None
    ): SalesforceConfiguration =
      SalesforceConfiguration
        .builder
        .ifSome(serverUrl)(_.serverUrl(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(standardObjectConfigurations)(_.standardObjectConfigurations(_))
        .ifSome(knowledgeArticleConfiguration)(_.knowledgeArticleConfiguration(_))
        .ifSome(chatterFeedConfiguration)(_.chatterFeedConfiguration(_))
        .ifSome(crawlAttachments)(_.crawlAttachments(_))
        .ifSome(standardObjectAttachmentConfiguration)(_.standardObjectAttachmentConfiguration(_))
        .ifSome(includeAttachmentFilePatterns)(_.includeAttachmentFilePatterns(_))
        .ifSome(excludeAttachmentFilePatterns)(_.excludeAttachmentFilePatterns(_))
        .build

    def salesforceCustomKnowledgeArticleTypeConfiguration(
      name: Option[String] = None,
      documentDataFieldName: Option[String] = None,
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None
    ): SalesforceCustomKnowledgeArticleTypeConfiguration =
      SalesforceCustomKnowledgeArticleTypeConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentDataFieldName)(_.documentDataFieldName(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .build

    def salesforceKnowledgeArticleConfiguration(
      includedStates: Option[List[SalesforceKnowledgeArticleState]] = None,
      standardKnowledgeArticleTypeConfiguration: Option[SalesforceStandardKnowledgeArticleTypeConfiguration] = None,
      customKnowledgeArticleTypeConfigurations: Option[List[SalesforceCustomKnowledgeArticleTypeConfiguration]] = None
    ): SalesforceKnowledgeArticleConfiguration =
      SalesforceKnowledgeArticleConfiguration
        .builder
        .ifSome(includedStates)(_.includedStates(_))
        .ifSome(standardKnowledgeArticleTypeConfiguration)(_.standardKnowledgeArticleTypeConfiguration(_))
        .ifSome(customKnowledgeArticleTypeConfigurations)(_.customKnowledgeArticleTypeConfigurations(_))
        .build

    def salesforceStandardKnowledgeArticleTypeConfiguration(
      documentDataFieldName: Option[String] = None,
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None
    ): SalesforceStandardKnowledgeArticleTypeConfiguration =
      SalesforceStandardKnowledgeArticleTypeConfiguration
        .builder
        .ifSome(documentDataFieldName)(_.documentDataFieldName(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .build

    def salesforceStandardObjectAttachmentConfiguration(
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None
    ): SalesforceStandardObjectAttachmentConfiguration =
      SalesforceStandardObjectAttachmentConfiguration
        .builder
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .build

    def salesforceStandardObjectConfiguration(
      name: Option[String] = None,
      documentDataFieldName: Option[String] = None,
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None
    ): SalesforceStandardObjectConfiguration =
      SalesforceStandardObjectConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(documentDataFieldName)(_.documentDataFieldName(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .build

    def scoreAttributes(
      scoreConfidence: Option[String] = None
    ): ScoreAttributes =
      ScoreAttributes
        .builder
        .ifSome(scoreConfidence)(_.scoreConfidence(_))
        .build

    def search(
      facetable: Option[Boolean] = None,
      searchable: Option[Boolean] = None,
      displayable: Option[Boolean] = None,
      sortable: Option[Boolean] = None
    ): Search =
      Search
        .builder
        .ifSome(facetable)(_.facetable(_))
        .ifSome(searchable)(_.searchable(_))
        .ifSome(displayable)(_.displayable(_))
        .ifSome(sortable)(_.sortable(_))
        .build

    def serverSideEncryptionConfiguration(
      kmsKeyId: Option[String] = None
    ): ServerSideEncryptionConfiguration =
      ServerSideEncryptionConfiguration
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def serviceNowConfiguration(
      hostUrl: Option[String] = None,
      secretArn: Option[String] = None,
      serviceNowBuildVersion: Option[String] = None,
      knowledgeArticleConfiguration: Option[ServiceNowKnowledgeArticleConfiguration] = None,
      serviceCatalogConfiguration: Option[ServiceNowServiceCatalogConfiguration] = None,
      authenticationType: Option[String] = None
    ): ServiceNowConfiguration =
      ServiceNowConfiguration
        .builder
        .ifSome(hostUrl)(_.hostUrl(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(serviceNowBuildVersion)(_.serviceNowBuildVersion(_))
        .ifSome(knowledgeArticleConfiguration)(_.knowledgeArticleConfiguration(_))
        .ifSome(serviceCatalogConfiguration)(_.serviceCatalogConfiguration(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def serviceNowKnowledgeArticleConfiguration(
      crawlAttachments: Option[Boolean] = None,
      includeAttachmentFilePatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      excludeAttachmentFilePatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      documentDataFieldName: Option[String] = None,
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None,
      filterQuery: Option[String] = None
    ): ServiceNowKnowledgeArticleConfiguration =
      ServiceNowKnowledgeArticleConfiguration
        .builder
        .ifSome(crawlAttachments)(_.crawlAttachments(_))
        .ifSome(includeAttachmentFilePatterns)(_.includeAttachmentFilePatterns(_))
        .ifSome(excludeAttachmentFilePatterns)(_.excludeAttachmentFilePatterns(_))
        .ifSome(documentDataFieldName)(_.documentDataFieldName(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .ifSome(filterQuery)(_.filterQuery(_))
        .build

    def serviceNowServiceCatalogConfiguration(
      crawlAttachments: Option[Boolean] = None,
      includeAttachmentFilePatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      excludeAttachmentFilePatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      documentDataFieldName: Option[String] = None,
      documentTitleFieldName: Option[String] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None
    ): ServiceNowServiceCatalogConfiguration =
      ServiceNowServiceCatalogConfiguration
        .builder
        .ifSome(crawlAttachments)(_.crawlAttachments(_))
        .ifSome(includeAttachmentFilePatterns)(_.includeAttachmentFilePatterns(_))
        .ifSome(excludeAttachmentFilePatterns)(_.excludeAttachmentFilePatterns(_))
        .ifSome(documentDataFieldName)(_.documentDataFieldName(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sharePointConfiguration(
      sharePointVersion: Option[String] = None,
      urls: Option[List[Url]] = None,
      secretArn: Option[String] = None,
      crawlAttachments: Option[Boolean] = None,
      useChangeLog: Option[Boolean] = None,
      inclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      exclusionPatterns: Option[List[DataSourceInclusionsExclusionsStringsMember]] = None,
      vpcConfiguration: Option[DataSourceVpcConfiguration] = None,
      fieldMappings: Option[List[DataSourceToIndexFieldMapping]] = None,
      documentTitleFieldName: Option[String] = None,
      disableLocalGroups: Option[Boolean] = None
    ): SharePointConfiguration =
      SharePointConfiguration
        .builder
        .ifSome(sharePointVersion)(_.sharePointVersion(_))
        .ifSome(urls)(_.urls(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(crawlAttachments)(_.crawlAttachments(_))
        .ifSome(useChangeLog)(_.useChangeLog(_))
        .ifSome(inclusionPatterns)(_.inclusionPatterns(_))
        .ifSome(exclusionPatterns)(_.exclusionPatterns(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(fieldMappings)(_.fieldMappings(_))
        .ifSome(documentTitleFieldName)(_.documentTitleFieldName(_))
        .ifSome(disableLocalGroups)(_.disableLocalGroups(_))
        .build

    def sortingConfiguration(
      documentAttributeKey: Option[String] = None,
      sortOrder: Option[String] = None
    ): SortingConfiguration =
      SortingConfiguration
        .builder
        .ifSome(documentAttributeKey)(_.documentAttributeKey(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def sqlConfiguration(
      queryIdentifiersEnclosingOption: Option[String] = None
    ): SqlConfiguration =
      SqlConfiguration
        .builder
        .ifSome(queryIdentifiersEnclosingOption)(_.queryIdentifiersEnclosingOption(_))
        .build

    def startDataSourceSyncJobRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): StartDataSourceSyncJobRequest =
      StartDataSourceSyncJobRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def startDataSourceSyncJobResponse(
      executionId: Option[String] = None
    ): StartDataSourceSyncJobResponse =
      StartDataSourceSyncJobResponse
        .builder
        .ifSome(executionId)(_.executionId(_))
        .build

    def status(
      documentId: Option[String] = None,
      documentStatus: Option[String] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None
    ): Status =
      Status
        .builder
        .ifSome(documentId)(_.documentId(_))
        .ifSome(documentStatus)(_.documentStatus(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def stopDataSourceSyncJobRequest(
      id: Option[String] = None,
      indexId: Option[String] = None
    ): StopDataSourceSyncJobRequest =
      StopDataSourceSyncJobRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(indexId)(_.indexId(_))
        .build

    def submitFeedbackRequest(
      indexId: Option[String] = None,
      queryId: Option[String] = None,
      clickFeedbackItems: Option[List[ClickFeedback]] = None,
      relevanceFeedbackItems: Option[List[RelevanceFeedback]] = None
    ): SubmitFeedbackRequest =
      SubmitFeedbackRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(queryId)(_.queryId(_))
        .ifSome(clickFeedbackItems)(_.clickFeedbackItems(_))
        .ifSome(relevanceFeedbackItems)(_.relevanceFeedbackItems(_))
        .build

    def suggestion(
      id: Option[String] = None,
      value: Option[SuggestionValue] = None
    ): Suggestion =
      Suggestion
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(value)(_.value(_))
        .build

    def suggestionHighlight(
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None
    ): SuggestionHighlight =
      SuggestionHighlight
        .builder
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .build

    def suggestionTextWithHighlights(
      text: Option[String] = None,
      highlights: Option[List[SuggestionHighlight]] = None
    ): SuggestionTextWithHighlights =
      SuggestionTextWithHighlights
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(highlights)(_.highlights(_))
        .build

    def suggestionValue(
      text: Option[SuggestionTextWithHighlights] = None
    ): SuggestionValue =
      SuggestionValue
        .builder
        .ifSome(text)(_.text(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def textDocumentStatistics(
      indexedTextDocumentsCount: Option[Int] = None,
      indexedTextBytes: Option[IndexedTextBytes] = None
    ): TextDocumentStatistics =
      TextDocumentStatistics
        .builder
        .ifSome(indexedTextDocumentsCount)(_.indexedTextDocumentsCount(_))
        .ifSome(indexedTextBytes)(_.indexedTextBytes(_))
        .build

    def textWithHighlights(
      text: Option[String] = None,
      highlights: Option[List[Highlight]] = None
    ): TextWithHighlights =
      TextWithHighlights
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(highlights)(_.highlights(_))
        .build

    def thesaurusSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None
    ): ThesaurusSummary =
      ThesaurusSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timeRange(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): TimeRange =
      TimeRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateDataSourceRequest(
      id: Option[String] = None,
      name: Option[String] = None,
      indexId: Option[String] = None,
      configuration: Option[DataSourceConfiguration] = None,
      description: Option[String] = None,
      schedule: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdateDataSourceRequest =
      UpdateDataSourceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateIndexRequest(
      id: Option[String] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None,
      description: Option[String] = None,
      documentMetadataConfigurationUpdates: Option[List[DocumentMetadataConfiguration]] = None,
      capacityUnits: Option[CapacityUnitsConfiguration] = None,
      userTokenConfigurations: Option[List[UserTokenConfiguration]] = None,
      userContextPolicy: Option[String] = None
    ): UpdateIndexRequest =
      UpdateIndexRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(documentMetadataConfigurationUpdates)(_.documentMetadataConfigurationUpdates(_))
        .ifSome(capacityUnits)(_.capacityUnits(_))
        .ifSome(userTokenConfigurations)(_.userTokenConfigurations(_))
        .ifSome(userContextPolicy)(_.userContextPolicy(_))
        .build

    def updateQuerySuggestionsBlockListRequest(
      indexId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      sourceS3Path: Option[S3Path] = None,
      roleArn: Option[String] = None
    ): UpdateQuerySuggestionsBlockListRequest =
      UpdateQuerySuggestionsBlockListRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(sourceS3Path)(_.sourceS3Path(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateQuerySuggestionsConfigRequest(
      indexId: Option[String] = None,
      mode: Option[String] = None,
      queryLogLookBackWindowInDays: Option[Int] = None,
      includeQueriesWithoutUserInformation: Option[Boolean] = None,
      minimumNumberOfQueryingUsers: Option[Int] = None,
      minimumQueryCount: Option[Int] = None
    ): UpdateQuerySuggestionsConfigRequest =
      UpdateQuerySuggestionsConfigRequest
        .builder
        .ifSome(indexId)(_.indexId(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(queryLogLookBackWindowInDays)(_.queryLogLookBackWindowInDays(_))
        .ifSome(includeQueriesWithoutUserInformation)(_.includeQueriesWithoutUserInformation(_))
        .ifSome(minimumNumberOfQueryingUsers)(_.minimumNumberOfQueryingUsers(_))
        .ifSome(minimumQueryCount)(_.minimumQueryCount(_))
        .build

    def updateThesaurusRequest(
      id: Option[String] = None,
      name: Option[String] = None,
      indexId: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      sourceS3Path: Option[S3Path] = None
    ): UpdateThesaurusRequest =
      UpdateThesaurusRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(indexId)(_.indexId(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(sourceS3Path)(_.sourceS3Path(_))
        .build

    def userContext(
      token: Option[String] = None
    ): UserContext =
      UserContext
        .builder
        .ifSome(token)(_.token(_))
        .build

    def userTokenConfiguration(
      jwtTokenTypeConfiguration: Option[JwtTokenTypeConfiguration] = None,
      jsonTokenTypeConfiguration: Option[JsonTokenTypeConfiguration] = None
    ): UserTokenConfiguration =
      UserTokenConfiguration
        .builder
        .ifSome(jwtTokenTypeConfiguration)(_.jwtTokenTypeConfiguration(_))
        .ifSome(jsonTokenTypeConfiguration)(_.jsonTokenTypeConfiguration(_))
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
