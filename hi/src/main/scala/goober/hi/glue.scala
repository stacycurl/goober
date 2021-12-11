package goober.hi

import goober.free.glue.GlueIO
import software.amazon.awssdk.services.glue.model._


object glue {
  import goober.free.{glue ⇒ free}

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

    def action(
      jobName: Option[String] = None,
      arguments: Option[GenericMap] = None,
      timeout: Option[Int] = None,
      securityConfiguration: Option[String] = None,
      notificationProperty: Option[NotificationProperty] = None,
      crawlerName: Option[String] = None
    ): Action =
      Action
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(arguments)(_.arguments(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(notificationProperty)(_.notificationProperty(_))
        .ifSome(crawlerName)(_.crawlerName(_))
        .build

    def alreadyExistsException(
      message: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def backfillError(
      code: Option[String] = None,
      partitions: Option[List[PartitionValueList]] = None
    ): BackfillError =
      BackfillError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(partitions)(_.partitions(_))
        .build

    def batchCreatePartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionInputList: Option[List[PartitionInput]] = None
    ): BatchCreatePartitionRequest =
      BatchCreatePartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionInputList)(_.partitionInputList(_))
        .build

    def batchCreatePartitionResponse(
      errors: Option[List[PartitionError]] = None
    ): BatchCreatePartitionResponse =
      BatchCreatePartitionResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeleteConnectionRequest(
      catalogId: Option[String] = None,
      connectionNameList: Option[List[NameString]] = None
    ): BatchDeleteConnectionRequest =
      BatchDeleteConnectionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(connectionNameList)(_.connectionNameList(_))
        .build

    def batchDeleteConnectionResponse(
      succeeded: Option[List[NameString]] = None,
      errors: Option[ErrorByName] = None
    ): BatchDeleteConnectionResponse =
      BatchDeleteConnectionResponse
        .builder
        .ifSome(succeeded)(_.succeeded(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeletePartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionsToDelete: Option[List[PartitionValueList]] = None
    ): BatchDeletePartitionRequest =
      BatchDeletePartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionsToDelete)(_.partitionsToDelete(_))
        .build

    def batchDeletePartitionResponse(
      errors: Option[List[PartitionError]] = None
    ): BatchDeletePartitionResponse =
      BatchDeletePartitionResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeleteTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tablesToDelete: Option[List[NameString]] = None
    ): BatchDeleteTableRequest =
      BatchDeleteTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tablesToDelete)(_.tablesToDelete(_))
        .build

    def batchDeleteTableResponse(
      errors: Option[List[TableError]] = None
    ): BatchDeleteTableResponse =
      BatchDeleteTableResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeleteTableVersionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      versionIds: Option[List[VersionString]] = None
    ): BatchDeleteTableVersionRequest =
      BatchDeleteTableVersionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(versionIds)(_.versionIds(_))
        .build

    def batchDeleteTableVersionResponse(
      errors: Option[List[TableVersionError]] = None
    ): BatchDeleteTableVersionResponse =
      BatchDeleteTableVersionResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchGetCrawlersRequest(
      crawlerNames: Option[List[NameString]] = None
    ): BatchGetCrawlersRequest =
      BatchGetCrawlersRequest
        .builder
        .ifSome(crawlerNames)(_.crawlerNames(_))
        .build

    def batchGetCrawlersResponse(
      crawlers: Option[List[Crawler]] = None,
      crawlersNotFound: Option[List[NameString]] = None
    ): BatchGetCrawlersResponse =
      BatchGetCrawlersResponse
        .builder
        .ifSome(crawlers)(_.crawlers(_))
        .ifSome(crawlersNotFound)(_.crawlersNotFound(_))
        .build

    def batchGetDevEndpointsRequest(
      devEndpointNames: Option[List[GenericString]] = None
    ): BatchGetDevEndpointsRequest =
      BatchGetDevEndpointsRequest
        .builder
        .ifSome(devEndpointNames)(_.devEndpointNames(_))
        .build

    def batchGetDevEndpointsResponse(
      devEndpoints: Option[List[DevEndpoint]] = None,
      devEndpointsNotFound: Option[List[GenericString]] = None
    ): BatchGetDevEndpointsResponse =
      BatchGetDevEndpointsResponse
        .builder
        .ifSome(devEndpoints)(_.devEndpoints(_))
        .ifSome(devEndpointsNotFound)(_.devEndpointsNotFound(_))
        .build

    def batchGetJobsRequest(
      jobNames: Option[List[NameString]] = None
    ): BatchGetJobsRequest =
      BatchGetJobsRequest
        .builder
        .ifSome(jobNames)(_.jobNames(_))
        .build

    def batchGetJobsResponse(
      jobs: Option[List[Job]] = None,
      jobsNotFound: Option[List[NameString]] = None
    ): BatchGetJobsResponse =
      BatchGetJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(jobsNotFound)(_.jobsNotFound(_))
        .build

    def batchGetPartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionsToGet: Option[List[PartitionValueList]] = None
    ): BatchGetPartitionRequest =
      BatchGetPartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionsToGet)(_.partitionsToGet(_))
        .build

    def batchGetPartitionResponse(
      partitions: Option[List[Partition]] = None,
      unprocessedKeys: Option[List[PartitionValueList]] = None
    ): BatchGetPartitionResponse =
      BatchGetPartitionResponse
        .builder
        .ifSome(partitions)(_.partitions(_))
        .ifSome(unprocessedKeys)(_.unprocessedKeys(_))
        .build

    def batchGetTriggersRequest(
      triggerNames: Option[List[NameString]] = None
    ): BatchGetTriggersRequest =
      BatchGetTriggersRequest
        .builder
        .ifSome(triggerNames)(_.triggerNames(_))
        .build

    def batchGetTriggersResponse(
      triggers: Option[List[Trigger]] = None,
      triggersNotFound: Option[List[NameString]] = None
    ): BatchGetTriggersResponse =
      BatchGetTriggersResponse
        .builder
        .ifSome(triggers)(_.triggers(_))
        .ifSome(triggersNotFound)(_.triggersNotFound(_))
        .build

    def batchGetWorkflowsRequest(
      names: Option[List[NameString]] = None,
      includeGraph: Option[Boolean] = None
    ): BatchGetWorkflowsRequest =
      BatchGetWorkflowsRequest
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(includeGraph)(_.includeGraph(_))
        .build

    def batchGetWorkflowsResponse(
      workflows: Option[List[Workflow]] = None,
      missingWorkflows: Option[List[NameString]] = None
    ): BatchGetWorkflowsResponse =
      BatchGetWorkflowsResponse
        .builder
        .ifSome(workflows)(_.workflows(_))
        .ifSome(missingWorkflows)(_.missingWorkflows(_))
        .build

    def batchStopJobRunError(
      jobName: Option[String] = None,
      jobRunId: Option[String] = None,
      errorDetail: Option[ErrorDetail] = None
    ): BatchStopJobRunError =
      BatchStopJobRunError
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobRunId)(_.jobRunId(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .build

    def batchStopJobRunRequest(
      jobName: Option[String] = None,
      jobRunIds: Option[List[IdString]] = None
    ): BatchStopJobRunRequest =
      BatchStopJobRunRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobRunIds)(_.jobRunIds(_))
        .build

    def batchStopJobRunResponse(
      successfulSubmissions: Option[List[BatchStopJobRunSuccessfulSubmission]] = None,
      errors: Option[List[BatchStopJobRunError]] = None
    ): BatchStopJobRunResponse =
      BatchStopJobRunResponse
        .builder
        .ifSome(successfulSubmissions)(_.successfulSubmissions(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchStopJobRunSuccessfulSubmission(
      jobName: Option[String] = None,
      jobRunId: Option[String] = None
    ): BatchStopJobRunSuccessfulSubmission =
      BatchStopJobRunSuccessfulSubmission
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobRunId)(_.jobRunId(_))
        .build

    def batchUpdatePartitionFailureEntry(
      partitionValueList: Option[List[ValueString]] = None,
      errorDetail: Option[ErrorDetail] = None
    ): BatchUpdatePartitionFailureEntry =
      BatchUpdatePartitionFailureEntry
        .builder
        .ifSome(partitionValueList)(_.partitionValueList(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .build

    def batchUpdatePartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      entries: Option[List[BatchUpdatePartitionRequestEntry]] = None
    ): BatchUpdatePartitionRequest =
      BatchUpdatePartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(entries)(_.entries(_))
        .build

    def batchUpdatePartitionRequestEntry(
      partitionValueList: Option[List[ValueString]] = None,
      partitionInput: Option[PartitionInput] = None
    ): BatchUpdatePartitionRequestEntry =
      BatchUpdatePartitionRequestEntry
        .builder
        .ifSome(partitionValueList)(_.partitionValueList(_))
        .ifSome(partitionInput)(_.partitionInput(_))
        .build

    def batchUpdatePartitionResponse(
      errors: Option[List[BatchUpdatePartitionFailureEntry]] = None
    ): BatchUpdatePartitionResponse =
      BatchUpdatePartitionResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def binaryColumnStatisticsData(
      maximumLength: Option[NonNegativeLong] = None,
      averageLength: Option[NonNegativeDouble] = None,
      numberOfNulls: Option[NonNegativeLong] = None
    ): BinaryColumnStatisticsData =
      BinaryColumnStatisticsData
        .builder
        .ifSome(maximumLength)(_.maximumLength(_))
        .ifSome(averageLength)(_.averageLength(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .build

    def booleanColumnStatisticsData(
      numberOfTrues: Option[NonNegativeLong] = None,
      numberOfFalses: Option[NonNegativeLong] = None,
      numberOfNulls: Option[NonNegativeLong] = None
    ): BooleanColumnStatisticsData =
      BooleanColumnStatisticsData
        .builder
        .ifSome(numberOfTrues)(_.numberOfTrues(_))
        .ifSome(numberOfFalses)(_.numberOfFalses(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .build

    def cancelMLTaskRunRequest(
      transformId: Option[String] = None,
      taskRunId: Option[String] = None
    ): CancelMLTaskRunRequest =
      CancelMLTaskRunRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(taskRunId)(_.taskRunId(_))
        .build

    def cancelMLTaskRunResponse(
      transformId: Option[String] = None,
      taskRunId: Option[String] = None,
      status: Option[String] = None
    ): CancelMLTaskRunResponse =
      CancelMLTaskRunResponse
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(taskRunId)(_.taskRunId(_))
        .ifSome(status)(_.status(_))
        .build

    def catalogEntry(
      databaseName: Option[String] = None,
      tableName: Option[String] = None
    ): CatalogEntry =
      CatalogEntry
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .build

    def catalogImportStatus(
      importCompleted: Option[Boolean] = None,
      importTime: Option[Timestamp] = None,
      importedBy: Option[String] = None
    ): CatalogImportStatus =
      CatalogImportStatus
        .builder
        .ifSome(importCompleted)(_.importCompleted(_))
        .ifSome(importTime)(_.importTime(_))
        .ifSome(importedBy)(_.importedBy(_))
        .build

    def catalogTarget(
      databaseName: Option[String] = None,
      tables: Option[List[NameString]] = None
    ): CatalogTarget =
      CatalogTarget
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tables)(_.tables(_))
        .build

    def checkSchemaVersionValidityInput(
      dataFormat: Option[String] = None,
      schemaDefinition: Option[String] = None
    ): CheckSchemaVersionValidityInput =
      CheckSchemaVersionValidityInput
        .builder
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(schemaDefinition)(_.schemaDefinition(_))
        .build

    def checkSchemaVersionValidityResponse(
      valid: Option[Boolean] = None,
      error: Option[String] = None
    ): CheckSchemaVersionValidityResponse =
      CheckSchemaVersionValidityResponse
        .builder
        .ifSome(valid)(_.valid(_))
        .ifSome(error)(_.error(_))
        .build

    def classifier(
      grokClassifier: Option[GrokClassifier] = None,
      xMLClassifier: Option[XMLClassifier] = None,
      jsonClassifier: Option[JsonClassifier] = None,
      csvClassifier: Option[CsvClassifier] = None
    ): Classifier =
      Classifier
        .builder
        .ifSome(grokClassifier)(_.grokClassifier(_))
        .ifSome(xMLClassifier)(_.xMLClassifier(_))
        .ifSome(jsonClassifier)(_.jsonClassifier(_))
        .ifSome(csvClassifier)(_.csvClassifier(_))
        .build

    def cloudWatchEncryption(
      cloudWatchEncryptionMode: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): CloudWatchEncryption =
      CloudWatchEncryption
        .builder
        .ifSome(cloudWatchEncryptionMode)(_.cloudWatchEncryptionMode(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def codeGenEdge(
      source: Option[String] = None,
      target: Option[String] = None,
      targetParameter: Option[String] = None
    ): CodeGenEdge =
      CodeGenEdge
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(target)(_.target(_))
        .ifSome(targetParameter)(_.targetParameter(_))
        .build

    def codeGenNode(
      id: Option[String] = None,
      nodeType: Option[String] = None,
      args: Option[List[CodeGenNodeArg]] = None,
      lineNumber: Option[Int] = None
    ): CodeGenNode =
      CodeGenNode
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(args)(_.args(_))
        .ifSome(lineNumber)(_.lineNumber(_))
        .build

    def codeGenNodeArg(
      name: Option[String] = None,
      value: Option[String] = None,
      param: Option[Boolean] = None
    ): CodeGenNodeArg =
      CodeGenNodeArg
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(param)(_.param(_))
        .build

    def column(
      name: Option[String] = None,
      `type`: Option[String] = None,
      comment: Option[String] = None,
      parameters: Option[ParametersMap] = None
    ): Column =
      Column
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def columnError(
      columnName: Option[String] = None,
      error: Option[ErrorDetail] = None
    ): ColumnError =
      ColumnError
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(error)(_.error(_))
        .build

    def columnImportance(
      columnName: Option[String] = None,
      importance: Option[GenericBoundedDouble] = None
    ): ColumnImportance =
      ColumnImportance
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(importance)(_.importance(_))
        .build

    def columnStatistics(
      columnName: Option[String] = None,
      columnType: Option[String] = None,
      analyzedTime: Option[Timestamp] = None,
      statisticsData: Option[ColumnStatisticsData] = None
    ): ColumnStatistics =
      ColumnStatistics
        .builder
        .ifSome(columnName)(_.columnName(_))
        .ifSome(columnType)(_.columnType(_))
        .ifSome(analyzedTime)(_.analyzedTime(_))
        .ifSome(statisticsData)(_.statisticsData(_))
        .build

    def columnStatisticsData(
      `type`: Option[String] = None,
      booleanColumnStatisticsData: Option[BooleanColumnStatisticsData] = None,
      dateColumnStatisticsData: Option[DateColumnStatisticsData] = None,
      decimalColumnStatisticsData: Option[DecimalColumnStatisticsData] = None,
      doubleColumnStatisticsData: Option[DoubleColumnStatisticsData] = None,
      longColumnStatisticsData: Option[LongColumnStatisticsData] = None,
      stringColumnStatisticsData: Option[StringColumnStatisticsData] = None,
      binaryColumnStatisticsData: Option[BinaryColumnStatisticsData] = None
    ): ColumnStatisticsData =
      ColumnStatisticsData
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(booleanColumnStatisticsData)(_.booleanColumnStatisticsData(_))
        .ifSome(dateColumnStatisticsData)(_.dateColumnStatisticsData(_))
        .ifSome(decimalColumnStatisticsData)(_.decimalColumnStatisticsData(_))
        .ifSome(doubleColumnStatisticsData)(_.doubleColumnStatisticsData(_))
        .ifSome(longColumnStatisticsData)(_.longColumnStatisticsData(_))
        .ifSome(stringColumnStatisticsData)(_.stringColumnStatisticsData(_))
        .ifSome(binaryColumnStatisticsData)(_.binaryColumnStatisticsData(_))
        .build

    def columnStatisticsError(
      columnStatistics: Option[ColumnStatistics] = None,
      error: Option[ErrorDetail] = None
    ): ColumnStatisticsError =
      ColumnStatisticsError
        .builder
        .ifSome(columnStatistics)(_.columnStatistics(_))
        .ifSome(error)(_.error(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def concurrentRunsExceededException(
      message: Option[String] = None
    ): ConcurrentRunsExceededException =
      ConcurrentRunsExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def condition(
      logicalOperator: Option[String] = None,
      jobName: Option[String] = None,
      state: Option[String] = None,
      crawlerName: Option[String] = None,
      crawlState: Option[String] = None
    ): Condition =
      Condition
        .builder
        .ifSome(logicalOperator)(_.logicalOperator(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(state)(_.state(_))
        .ifSome(crawlerName)(_.crawlerName(_))
        .ifSome(crawlState)(_.crawlState(_))
        .build

    def conditionCheckFailureException(
      message: Option[String] = None
    ): ConditionCheckFailureException =
      ConditionCheckFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def confusionMatrix(
      numTruePositives: Option[RecordsCount] = None,
      numFalsePositives: Option[RecordsCount] = None,
      numTrueNegatives: Option[RecordsCount] = None,
      numFalseNegatives: Option[RecordsCount] = None
    ): ConfusionMatrix =
      ConfusionMatrix
        .builder
        .ifSome(numTruePositives)(_.numTruePositives(_))
        .ifSome(numFalsePositives)(_.numFalsePositives(_))
        .ifSome(numTrueNegatives)(_.numTrueNegatives(_))
        .ifSome(numFalseNegatives)(_.numFalseNegatives(_))
        .build

    def connection(
      name: Option[String] = None,
      description: Option[String] = None,
      connectionType: Option[String] = None,
      matchCriteria: Option[List[NameString]] = None,
      connectionProperties: Option[ConnectionProperties] = None,
      physicalConnectionRequirements: Option[PhysicalConnectionRequirements] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None,
      lastUpdatedBy: Option[String] = None
    ): Connection =
      Connection
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(matchCriteria)(_.matchCriteria(_))
        .ifSome(connectionProperties)(_.connectionProperties(_))
        .ifSome(physicalConnectionRequirements)(_.physicalConnectionRequirements(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(lastUpdatedBy)(_.lastUpdatedBy(_))
        .build

    def connectionInput(
      name: Option[String] = None,
      description: Option[String] = None,
      connectionType: Option[String] = None,
      matchCriteria: Option[List[NameString]] = None,
      connectionProperties: Option[ConnectionProperties] = None,
      physicalConnectionRequirements: Option[PhysicalConnectionRequirements] = None
    ): ConnectionInput =
      ConnectionInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(matchCriteria)(_.matchCriteria(_))
        .ifSome(connectionProperties)(_.connectionProperties(_))
        .ifSome(physicalConnectionRequirements)(_.physicalConnectionRequirements(_))
        .build

    def connectionPasswordEncryption(
      returnConnectionPasswordEncrypted: Option[Boolean] = None,
      awsKmsKeyId: Option[String] = None
    ): ConnectionPasswordEncryption =
      ConnectionPasswordEncryption
        .builder
        .ifSome(returnConnectionPasswordEncrypted)(_.returnConnectionPasswordEncrypted(_))
        .ifSome(awsKmsKeyId)(_.awsKmsKeyId(_))
        .build

    def connectionsList(
      connections: Option[List[GenericString]] = None
    ): ConnectionsList =
      ConnectionsList
        .builder
        .ifSome(connections)(_.connections(_))
        .build

    def crawl(
      state: Option[String] = None,
      startedOn: Option[TimestampValue] = None,
      completedOn: Option[TimestampValue] = None,
      errorMessage: Option[String] = None,
      logGroup: Option[String] = None,
      logStream: Option[String] = None
    ): Crawl =
      Crawl
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(logGroup)(_.logGroup(_))
        .ifSome(logStream)(_.logStream(_))
        .build

    def crawler(
      name: Option[String] = None,
      role: Option[String] = None,
      targets: Option[CrawlerTargets] = None,
      databaseName: Option[String] = None,
      description: Option[String] = None,
      classifiers: Option[List[NameString]] = None,
      recrawlPolicy: Option[RecrawlPolicy] = None,
      schemaChangePolicy: Option[SchemaChangePolicy] = None,
      lineageConfiguration: Option[LineageConfiguration] = None,
      state: Option[String] = None,
      tablePrefix: Option[String] = None,
      schedule: Option[Schedule] = None,
      crawlElapsedTime: Option[MillisecondsCount] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None,
      lastCrawl: Option[LastCrawlInfo] = None,
      version: Option[VersionId] = None,
      configuration: Option[String] = None,
      crawlerSecurityConfiguration: Option[String] = None
    ): Crawler =
      Crawler
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(role)(_.role(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(description)(_.description(_))
        .ifSome(classifiers)(_.classifiers(_))
        .ifSome(recrawlPolicy)(_.recrawlPolicy(_))
        .ifSome(schemaChangePolicy)(_.schemaChangePolicy(_))
        .ifSome(lineageConfiguration)(_.lineageConfiguration(_))
        .ifSome(state)(_.state(_))
        .ifSome(tablePrefix)(_.tablePrefix(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(crawlElapsedTime)(_.crawlElapsedTime(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(lastCrawl)(_.lastCrawl(_))
        .ifSome(version)(_.version(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(crawlerSecurityConfiguration)(_.crawlerSecurityConfiguration(_))
        .build

    def crawlerMetrics(
      crawlerName: Option[String] = None,
      timeLeftSeconds: Option[NonNegativeDouble] = None,
      stillEstimating: Option[Boolean] = None,
      lastRuntimeSeconds: Option[NonNegativeDouble] = None,
      medianRuntimeSeconds: Option[NonNegativeDouble] = None,
      tablesCreated: Option[Int] = None,
      tablesUpdated: Option[Int] = None,
      tablesDeleted: Option[Int] = None
    ): CrawlerMetrics =
      CrawlerMetrics
        .builder
        .ifSome(crawlerName)(_.crawlerName(_))
        .ifSome(timeLeftSeconds)(_.timeLeftSeconds(_))
        .ifSome(stillEstimating)(_.stillEstimating(_))
        .ifSome(lastRuntimeSeconds)(_.lastRuntimeSeconds(_))
        .ifSome(medianRuntimeSeconds)(_.medianRuntimeSeconds(_))
        .ifSome(tablesCreated)(_.tablesCreated(_))
        .ifSome(tablesUpdated)(_.tablesUpdated(_))
        .ifSome(tablesDeleted)(_.tablesDeleted(_))
        .build

    def crawlerNodeDetails(
      crawls: Option[List[Crawl]] = None
    ): CrawlerNodeDetails =
      CrawlerNodeDetails
        .builder
        .ifSome(crawls)(_.crawls(_))
        .build

    def crawlerNotRunningException(
      message: Option[String] = None
    ): CrawlerNotRunningException =
      CrawlerNotRunningException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def crawlerRunningException(
      message: Option[String] = None
    ): CrawlerRunningException =
      CrawlerRunningException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def crawlerStoppingException(
      message: Option[String] = None
    ): CrawlerStoppingException =
      CrawlerStoppingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def crawlerTargets(
      s3Targets: Option[List[S3Target]] = None,
      jdbcTargets: Option[List[JdbcTarget]] = None,
      mongoDBTargets: Option[List[MongoDBTarget]] = None,
      dynamoDBTargets: Option[List[DynamoDBTarget]] = None,
      catalogTargets: Option[List[CatalogTarget]] = None
    ): CrawlerTargets =
      CrawlerTargets
        .builder
        .ifSome(s3Targets)(_.s3Targets(_))
        .ifSome(jdbcTargets)(_.jdbcTargets(_))
        .ifSome(mongoDBTargets)(_.mongoDBTargets(_))
        .ifSome(dynamoDBTargets)(_.dynamoDBTargets(_))
        .ifSome(catalogTargets)(_.catalogTargets(_))
        .build

    def createClassifierRequest(
      grokClassifier: Option[CreateGrokClassifierRequest] = None,
      xMLClassifier: Option[CreateXMLClassifierRequest] = None,
      jsonClassifier: Option[CreateJsonClassifierRequest] = None,
      csvClassifier: Option[CreateCsvClassifierRequest] = None
    ): CreateClassifierRequest =
      CreateClassifierRequest
        .builder
        .ifSome(grokClassifier)(_.grokClassifier(_))
        .ifSome(xMLClassifier)(_.xMLClassifier(_))
        .ifSome(jsonClassifier)(_.jsonClassifier(_))
        .ifSome(csvClassifier)(_.csvClassifier(_))
        .build

    def createClassifierResponse(

    ): CreateClassifierResponse =
      CreateClassifierResponse
        .builder

        .build

    def createConnectionRequest(
      catalogId: Option[String] = None,
      connectionInput: Option[ConnectionInput] = None
    ): CreateConnectionRequest =
      CreateConnectionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(connectionInput)(_.connectionInput(_))
        .build

    def createConnectionResponse(

    ): CreateConnectionResponse =
      CreateConnectionResponse
        .builder

        .build

    def createCrawlerRequest(
      name: Option[String] = None,
      role: Option[String] = None,
      databaseName: Option[String] = None,
      description: Option[String] = None,
      targets: Option[CrawlerTargets] = None,
      schedule: Option[String] = None,
      classifiers: Option[List[NameString]] = None,
      tablePrefix: Option[String] = None,
      schemaChangePolicy: Option[SchemaChangePolicy] = None,
      recrawlPolicy: Option[RecrawlPolicy] = None,
      lineageConfiguration: Option[LineageConfiguration] = None,
      configuration: Option[String] = None,
      crawlerSecurityConfiguration: Option[String] = None,
      tags: Option[TagsMap] = None
    ): CreateCrawlerRequest =
      CreateCrawlerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(role)(_.role(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(classifiers)(_.classifiers(_))
        .ifSome(tablePrefix)(_.tablePrefix(_))
        .ifSome(schemaChangePolicy)(_.schemaChangePolicy(_))
        .ifSome(recrawlPolicy)(_.recrawlPolicy(_))
        .ifSome(lineageConfiguration)(_.lineageConfiguration(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(crawlerSecurityConfiguration)(_.crawlerSecurityConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCrawlerResponse(

    ): CreateCrawlerResponse =
      CreateCrawlerResponse
        .builder

        .build

    def createCsvClassifierRequest(
      name: Option[String] = None,
      delimiter: Option[String] = None,
      quoteSymbol: Option[String] = None,
      containsHeader: Option[String] = None,
      header: Option[List[NameString]] = None,
      disableValueTrimming: Option[Boolean] = None,
      allowSingleColumn: Option[Boolean] = None
    ): CreateCsvClassifierRequest =
      CreateCsvClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(quoteSymbol)(_.quoteSymbol(_))
        .ifSome(containsHeader)(_.containsHeader(_))
        .ifSome(header)(_.header(_))
        .ifSome(disableValueTrimming)(_.disableValueTrimming(_))
        .ifSome(allowSingleColumn)(_.allowSingleColumn(_))
        .build

    def createDatabaseRequest(
      catalogId: Option[String] = None,
      databaseInput: Option[DatabaseInput] = None
    ): CreateDatabaseRequest =
      CreateDatabaseRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseInput)(_.databaseInput(_))
        .build

    def createDatabaseResponse(

    ): CreateDatabaseResponse =
      CreateDatabaseResponse
        .builder

        .build

    def createDevEndpointRequest(
      endpointName: Option[String] = None,
      roleArn: Option[String] = None,
      securityGroupIds: Option[List[GenericString]] = None,
      subnetId: Option[String] = None,
      publicKey: Option[String] = None,
      publicKeys: Option[List[GenericString]] = None,
      numberOfNodes: Option[Int] = None,
      workerType: Option[String] = None,
      glueVersion: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      extraPythonLibsS3Path: Option[String] = None,
      extraJarsS3Path: Option[String] = None,
      securityConfiguration: Option[String] = None,
      tags: Option[TagsMap] = None,
      arguments: Option[MapValue] = None
    ): CreateDevEndpointRequest =
      CreateDevEndpointRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(publicKeys)(_.publicKeys(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(extraPythonLibsS3Path)(_.extraPythonLibsS3Path(_))
        .ifSome(extraJarsS3Path)(_.extraJarsS3Path(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(arguments)(_.arguments(_))
        .build

    def createDevEndpointResponse(
      endpointName: Option[String] = None,
      status: Option[String] = None,
      securityGroupIds: Option[List[GenericString]] = None,
      subnetId: Option[String] = None,
      roleArn: Option[String] = None,
      yarnEndpointAddress: Option[String] = None,
      zeppelinRemoteSparkInterpreterPort: Option[Int] = None,
      numberOfNodes: Option[Int] = None,
      workerType: Option[String] = None,
      glueVersion: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      availabilityZone: Option[String] = None,
      vpcId: Option[String] = None,
      extraPythonLibsS3Path: Option[String] = None,
      extraJarsS3Path: Option[String] = None,
      failureReason: Option[String] = None,
      securityConfiguration: Option[String] = None,
      createdTimestamp: Option[TimestampValue] = None,
      arguments: Option[MapValue] = None
    ): CreateDevEndpointResponse =
      CreateDevEndpointResponse
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(status)(_.status(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(yarnEndpointAddress)(_.yarnEndpointAddress(_))
        .ifSome(zeppelinRemoteSparkInterpreterPort)(_.zeppelinRemoteSparkInterpreterPort(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(extraPythonLibsS3Path)(_.extraPythonLibsS3Path(_))
        .ifSome(extraJarsS3Path)(_.extraJarsS3Path(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(arguments)(_.arguments(_))
        .build

    def createGrokClassifierRequest(
      classification: Option[String] = None,
      name: Option[String] = None,
      grokPattern: Option[String] = None,
      customPatterns: Option[String] = None
    ): CreateGrokClassifierRequest =
      CreateGrokClassifierRequest
        .builder
        .ifSome(classification)(_.classification(_))
        .ifSome(name)(_.name(_))
        .ifSome(grokPattern)(_.grokPattern(_))
        .ifSome(customPatterns)(_.customPatterns(_))
        .build

    def createJobRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      logUri: Option[String] = None,
      role: Option[String] = None,
      executionProperty: Option[ExecutionProperty] = None,
      command: Option[JobCommand] = None,
      defaultArguments: Option[GenericMap] = None,
      nonOverridableArguments: Option[GenericMap] = None,
      connections: Option[ConnectionsList] = None,
      maxRetries: Option[Int] = None,
      allocatedCapacity: Option[Int] = None,
      timeout: Option[Int] = None,
      maxCapacity: Option[NullableDouble] = None,
      securityConfiguration: Option[String] = None,
      tags: Option[TagsMap] = None,
      notificationProperty: Option[NotificationProperty] = None,
      glueVersion: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      workerType: Option[String] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(role)(_.role(_))
        .ifSome(executionProperty)(_.executionProperty(_))
        .ifSome(command)(_.command(_))
        .ifSome(defaultArguments)(_.defaultArguments(_))
        .ifSome(nonOverridableArguments)(_.nonOverridableArguments(_))
        .ifSome(connections)(_.connections(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(allocatedCapacity)(_.allocatedCapacity(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(notificationProperty)(_.notificationProperty(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(workerType)(_.workerType(_))
        .build

    def createJobResponse(
      name: Option[String] = None
    ): CreateJobResponse =
      CreateJobResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createJsonClassifierRequest(
      name: Option[String] = None,
      jsonPath: Option[String] = None
    ): CreateJsonClassifierRequest =
      CreateJsonClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(jsonPath)(_.jsonPath(_))
        .build

    def createMLTransformRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      inputRecordTables: Option[List[GlueTable]] = None,
      parameters: Option[TransformParameters] = None,
      role: Option[String] = None,
      glueVersion: Option[String] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      timeout: Option[Int] = None,
      maxRetries: Option[Int] = None,
      tags: Option[TagsMap] = None,
      transformEncryption: Option[TransformEncryption] = None
    ): CreateMLTransformRequest =
      CreateMLTransformRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(inputRecordTables)(_.inputRecordTables(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(role)(_.role(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(transformEncryption)(_.transformEncryption(_))
        .build

    def createMLTransformResponse(
      transformId: Option[String] = None
    ): CreateMLTransformResponse =
      CreateMLTransformResponse
        .builder
        .ifSome(transformId)(_.transformId(_))
        .build

    def createPartitionIndexRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionIndex: Option[PartitionIndex] = None
    ): CreatePartitionIndexRequest =
      CreatePartitionIndexRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionIndex)(_.partitionIndex(_))
        .build

    def createPartitionIndexResponse(

    ): CreatePartitionIndexResponse =
      CreatePartitionIndexResponse
        .builder

        .build

    def createPartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionInput: Option[PartitionInput] = None
    ): CreatePartitionRequest =
      CreatePartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionInput)(_.partitionInput(_))
        .build

    def createPartitionResponse(

    ): CreatePartitionResponse =
      CreatePartitionResponse
        .builder

        .build

    def createRegistryInput(
      registryName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagsMap] = None
    ): CreateRegistryInput =
      CreateRegistryInput
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRegistryResponse(
      registryArn: Option[String] = None,
      registryName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagsMap] = None
    ): CreateRegistryResponse =
      CreateRegistryResponse
        .builder
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSchemaInput(
      registryId: Option[RegistryId] = None,
      schemaName: Option[String] = None,
      dataFormat: Option[String] = None,
      compatibility: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagsMap] = None,
      schemaDefinition: Option[String] = None
    ): CreateSchemaInput =
      CreateSchemaInput
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(compatibility)(_.compatibility(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(schemaDefinition)(_.schemaDefinition(_))
        .build

    def createSchemaResponse(
      registryName: Option[String] = None,
      registryArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaArn: Option[String] = None,
      description: Option[String] = None,
      dataFormat: Option[String] = None,
      compatibility: Option[String] = None,
      schemaCheckpoint: Option[SchemaCheckpointNumber] = None,
      latestSchemaVersion: Option[VersionLongNumber] = None,
      nextSchemaVersion: Option[VersionLongNumber] = None,
      schemaStatus: Option[String] = None,
      tags: Option[TagsMap] = None,
      schemaVersionId: Option[String] = None,
      schemaVersionStatus: Option[String] = None
    ): CreateSchemaResponse =
      CreateSchemaResponse
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(compatibility)(_.compatibility(_))
        .ifSome(schemaCheckpoint)(_.schemaCheckpoint(_))
        .ifSome(latestSchemaVersion)(_.latestSchemaVersion(_))
        .ifSome(nextSchemaVersion)(_.nextSchemaVersion(_))
        .ifSome(schemaStatus)(_.schemaStatus(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(schemaVersionStatus)(_.schemaVersionStatus(_))
        .build

    def createScriptRequest(
      dagNodes: Option[List[CodeGenNode]] = None,
      dagEdges: Option[List[CodeGenEdge]] = None,
      language: Option[String] = None
    ): CreateScriptRequest =
      CreateScriptRequest
        .builder
        .ifSome(dagNodes)(_.dagNodes(_))
        .ifSome(dagEdges)(_.dagEdges(_))
        .ifSome(language)(_.language(_))
        .build

    def createScriptResponse(
      pythonScript: Option[String] = None,
      scalaCode: Option[String] = None
    ): CreateScriptResponse =
      CreateScriptResponse
        .builder
        .ifSome(pythonScript)(_.pythonScript(_))
        .ifSome(scalaCode)(_.scalaCode(_))
        .build

    def createSecurityConfigurationRequest(
      name: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None
    ): CreateSecurityConfigurationRequest =
      CreateSecurityConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .build

    def createSecurityConfigurationResponse(
      name: Option[String] = None,
      createdTimestamp: Option[TimestampValue] = None
    ): CreateSecurityConfigurationResponse =
      CreateSecurityConfigurationResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .build

    def createTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableInput: Option[TableInput] = None,
      partitionIndexes: Option[List[PartitionIndex]] = None
    ): CreateTableRequest =
      CreateTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableInput)(_.tableInput(_))
        .ifSome(partitionIndexes)(_.partitionIndexes(_))
        .build

    def createTableResponse(

    ): CreateTableResponse =
      CreateTableResponse
        .builder

        .build

    def createTriggerRequest(
      name: Option[String] = None,
      workflowName: Option[String] = None,
      `type`: Option[String] = None,
      schedule: Option[String] = None,
      predicate: Option[Predicate] = None,
      actions: Option[List[Action]] = None,
      description: Option[String] = None,
      startOnCreation: Option[Boolean] = None,
      tags: Option[TagsMap] = None
    ): CreateTriggerRequest =
      CreateTriggerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(workflowName)(_.workflowName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(predicate)(_.predicate(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(description)(_.description(_))
        .ifSome(startOnCreation)(_.startOnCreation(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTriggerResponse(
      name: Option[String] = None
    ): CreateTriggerResponse =
      CreateTriggerResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createUserDefinedFunctionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      functionInput: Option[UserDefinedFunctionInput] = None
    ): CreateUserDefinedFunctionRequest =
      CreateUserDefinedFunctionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(functionInput)(_.functionInput(_))
        .build

    def createUserDefinedFunctionResponse(

    ): CreateUserDefinedFunctionResponse =
      CreateUserDefinedFunctionResponse
        .builder

        .build

    def createWorkflowRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      defaultRunProperties: Option[WorkflowRunProperties] = None,
      tags: Option[TagsMap] = None,
      maxConcurrentRuns: Option[Int] = None
    ): CreateWorkflowRequest =
      CreateWorkflowRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultRunProperties)(_.defaultRunProperties(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(maxConcurrentRuns)(_.maxConcurrentRuns(_))
        .build

    def createWorkflowResponse(
      name: Option[String] = None
    ): CreateWorkflowResponse =
      CreateWorkflowResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createXMLClassifierRequest(
      classification: Option[String] = None,
      name: Option[String] = None,
      rowTag: Option[String] = None
    ): CreateXMLClassifierRequest =
      CreateXMLClassifierRequest
        .builder
        .ifSome(classification)(_.classification(_))
        .ifSome(name)(_.name(_))
        .ifSome(rowTag)(_.rowTag(_))
        .build

    def csvClassifier(
      name: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None,
      version: Option[VersionId] = None,
      delimiter: Option[String] = None,
      quoteSymbol: Option[String] = None,
      containsHeader: Option[String] = None,
      header: Option[List[NameString]] = None,
      disableValueTrimming: Option[Boolean] = None,
      allowSingleColumn: Option[Boolean] = None
    ): CsvClassifier =
      CsvClassifier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(version)(_.version(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(quoteSymbol)(_.quoteSymbol(_))
        .ifSome(containsHeader)(_.containsHeader(_))
        .ifSome(header)(_.header(_))
        .ifSome(disableValueTrimming)(_.disableValueTrimming(_))
        .ifSome(allowSingleColumn)(_.allowSingleColumn(_))
        .build

    def dataCatalogEncryptionSettings(
      encryptionAtRest: Option[EncryptionAtRest] = None,
      connectionPasswordEncryption: Option[ConnectionPasswordEncryption] = None
    ): DataCatalogEncryptionSettings =
      DataCatalogEncryptionSettings
        .builder
        .ifSome(encryptionAtRest)(_.encryptionAtRest(_))
        .ifSome(connectionPasswordEncryption)(_.connectionPasswordEncryption(_))
        .build

    def dataLakePrincipal(
      dataLakePrincipalIdentifier: Option[String] = None
    ): DataLakePrincipal =
      DataLakePrincipal
        .builder
        .ifSome(dataLakePrincipalIdentifier)(_.dataLakePrincipalIdentifier(_))
        .build

    def database(
      name: Option[String] = None,
      description: Option[String] = None,
      locationUri: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      createTime: Option[Timestamp] = None,
      createTableDefaultPermissions: Option[List[PrincipalPermissions]] = None,
      targetDatabase: Option[DatabaseIdentifier] = None,
      catalogId: Option[String] = None
    ): Database =
      Database
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(createTableDefaultPermissions)(_.createTableDefaultPermissions(_))
        .ifSome(targetDatabase)(_.targetDatabase(_))
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def databaseIdentifier(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None
    ): DatabaseIdentifier =
      DatabaseIdentifier
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def databaseInput(
      name: Option[String] = None,
      description: Option[String] = None,
      locationUri: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      createTableDefaultPermissions: Option[List[PrincipalPermissions]] = None,
      targetDatabase: Option[DatabaseIdentifier] = None
    ): DatabaseInput =
      DatabaseInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(locationUri)(_.locationUri(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(createTableDefaultPermissions)(_.createTableDefaultPermissions(_))
        .ifSome(targetDatabase)(_.targetDatabase(_))
        .build

    def dateColumnStatisticsData(
      minimumValue: Option[Timestamp] = None,
      maximumValue: Option[Timestamp] = None,
      numberOfNulls: Option[NonNegativeLong] = None,
      numberOfDistinctValues: Option[NonNegativeLong] = None
    ): DateColumnStatisticsData =
      DateColumnStatisticsData
        .builder
        .ifSome(minimumValue)(_.minimumValue(_))
        .ifSome(maximumValue)(_.maximumValue(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .ifSome(numberOfDistinctValues)(_.numberOfDistinctValues(_))
        .build

    def decimalColumnStatisticsData(
      minimumValue: Option[DecimalNumber] = None,
      maximumValue: Option[DecimalNumber] = None,
      numberOfNulls: Option[NonNegativeLong] = None,
      numberOfDistinctValues: Option[NonNegativeLong] = None
    ): DecimalColumnStatisticsData =
      DecimalColumnStatisticsData
        .builder
        .ifSome(minimumValue)(_.minimumValue(_))
        .ifSome(maximumValue)(_.maximumValue(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .ifSome(numberOfDistinctValues)(_.numberOfDistinctValues(_))
        .build

    def decimalNumber(
      unscaledValue: Option[Blob] = None,
      scale: Option[Int] = None
    ): DecimalNumber =
      DecimalNumber
        .builder
        .ifSome(unscaledValue)(_.unscaledValue(_))
        .ifSome(scale)(_.scale(_))
        .build

    def deleteClassifierRequest(
      name: Option[String] = None
    ): DeleteClassifierRequest =
      DeleteClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteClassifierResponse(

    ): DeleteClassifierResponse =
      DeleteClassifierResponse
        .builder

        .build

    def deleteColumnStatisticsForPartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionValues: Option[List[ValueString]] = None,
      columnName: Option[String] = None
    ): DeleteColumnStatisticsForPartitionRequest =
      DeleteColumnStatisticsForPartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionValues)(_.partitionValues(_))
        .ifSome(columnName)(_.columnName(_))
        .build

    def deleteColumnStatisticsForPartitionResponse(

    ): DeleteColumnStatisticsForPartitionResponse =
      DeleteColumnStatisticsForPartitionResponse
        .builder

        .build

    def deleteColumnStatisticsForTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      columnName: Option[String] = None
    ): DeleteColumnStatisticsForTableRequest =
      DeleteColumnStatisticsForTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(columnName)(_.columnName(_))
        .build

    def deleteColumnStatisticsForTableResponse(

    ): DeleteColumnStatisticsForTableResponse =
      DeleteColumnStatisticsForTableResponse
        .builder

        .build

    def deleteConnectionRequest(
      catalogId: Option[String] = None,
      connectionName: Option[String] = None
    ): DeleteConnectionRequest =
      DeleteConnectionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(connectionName)(_.connectionName(_))
        .build

    def deleteConnectionResponse(

    ): DeleteConnectionResponse =
      DeleteConnectionResponse
        .builder

        .build

    def deleteCrawlerRequest(
      name: Option[String] = None
    ): DeleteCrawlerRequest =
      DeleteCrawlerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteCrawlerResponse(

    ): DeleteCrawlerResponse =
      DeleteCrawlerResponse
        .builder

        .build

    def deleteDatabaseRequest(
      catalogId: Option[String] = None,
      name: Option[String] = None
    ): DeleteDatabaseRequest =
      DeleteDatabaseRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteDatabaseResponse(

    ): DeleteDatabaseResponse =
      DeleteDatabaseResponse
        .builder

        .build

    def deleteDevEndpointRequest(
      endpointName: Option[String] = None
    ): DeleteDevEndpointRequest =
      DeleteDevEndpointRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def deleteDevEndpointResponse(

    ): DeleteDevEndpointResponse =
      DeleteDevEndpointResponse
        .builder

        .build

    def deleteJobRequest(
      jobName: Option[String] = None
    ): DeleteJobRequest =
      DeleteJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .build

    def deleteJobResponse(
      jobName: Option[String] = None
    ): DeleteJobResponse =
      DeleteJobResponse
        .builder
        .ifSome(jobName)(_.jobName(_))
        .build

    def deleteMLTransformRequest(
      transformId: Option[String] = None
    ): DeleteMLTransformRequest =
      DeleteMLTransformRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .build

    def deleteMLTransformResponse(
      transformId: Option[String] = None
    ): DeleteMLTransformResponse =
      DeleteMLTransformResponse
        .builder
        .ifSome(transformId)(_.transformId(_))
        .build

    def deletePartitionIndexRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      indexName: Option[String] = None
    ): DeletePartitionIndexRequest =
      DeletePartitionIndexRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .build

    def deletePartitionIndexResponse(

    ): DeletePartitionIndexResponse =
      DeletePartitionIndexResponse
        .builder

        .build

    def deletePartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionValues: Option[List[ValueString]] = None
    ): DeletePartitionRequest =
      DeletePartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionValues)(_.partitionValues(_))
        .build

    def deletePartitionResponse(

    ): DeletePartitionResponse =
      DeletePartitionResponse
        .builder

        .build

    def deleteRegistryInput(
      registryId: Option[RegistryId] = None
    ): DeleteRegistryInput =
      DeleteRegistryInput
        .builder
        .ifSome(registryId)(_.registryId(_))
        .build

    def deleteRegistryResponse(
      registryName: Option[String] = None,
      registryArn: Option[String] = None,
      status: Option[String] = None
    ): DeleteRegistryResponse =
      DeleteRegistryResponse
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteResourcePolicyRequest(
      policyHashCondition: Option[String] = None,
      resourceArn: Option[String] = None
    ): DeleteResourcePolicyRequest =
      DeleteResourcePolicyRequest
        .builder
        .ifSome(policyHashCondition)(_.policyHashCondition(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deleteResourcePolicyResponse(

    ): DeleteResourcePolicyResponse =
      DeleteResourcePolicyResponse
        .builder

        .build

    def deleteSchemaInput(
      schemaId: Option[SchemaId] = None
    ): DeleteSchemaInput =
      DeleteSchemaInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .build

    def deleteSchemaResponse(
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      status: Option[String] = None
    ): DeleteSchemaResponse =
      DeleteSchemaResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteSchemaVersionsInput(
      schemaId: Option[SchemaId] = None,
      versions: Option[String] = None
    ): DeleteSchemaVersionsInput =
      DeleteSchemaVersionsInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(versions)(_.versions(_))
        .build

    def deleteSchemaVersionsResponse(
      schemaVersionErrors: Option[List[SchemaVersionErrorItem]] = None
    ): DeleteSchemaVersionsResponse =
      DeleteSchemaVersionsResponse
        .builder
        .ifSome(schemaVersionErrors)(_.schemaVersionErrors(_))
        .build

    def deleteSecurityConfigurationRequest(
      name: Option[String] = None
    ): DeleteSecurityConfigurationRequest =
      DeleteSecurityConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteSecurityConfigurationResponse(

    ): DeleteSecurityConfigurationResponse =
      DeleteSecurityConfigurationResponse
        .builder

        .build

    def deleteTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      name: Option[String] = None
    ): DeleteTableRequest =
      DeleteTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteTableResponse(

    ): DeleteTableResponse =
      DeleteTableResponse
        .builder

        .build

    def deleteTableVersionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      versionId: Option[String] = None
    ): DeleteTableVersionRequest =
      DeleteTableVersionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def deleteTableVersionResponse(

    ): DeleteTableVersionResponse =
      DeleteTableVersionResponse
        .builder

        .build

    def deleteTriggerRequest(
      name: Option[String] = None
    ): DeleteTriggerRequest =
      DeleteTriggerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteTriggerResponse(
      name: Option[String] = None
    ): DeleteTriggerResponse =
      DeleteTriggerResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteUserDefinedFunctionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      functionName: Option[String] = None
    ): DeleteUserDefinedFunctionRequest =
      DeleteUserDefinedFunctionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(functionName)(_.functionName(_))
        .build

    def deleteUserDefinedFunctionResponse(

    ): DeleteUserDefinedFunctionResponse =
      DeleteUserDefinedFunctionResponse
        .builder

        .build

    def deleteWorkflowRequest(
      name: Option[String] = None
    ): DeleteWorkflowRequest =
      DeleteWorkflowRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteWorkflowResponse(
      name: Option[String] = None
    ): DeleteWorkflowResponse =
      DeleteWorkflowResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def devEndpoint(
      endpointName: Option[String] = None,
      roleArn: Option[String] = None,
      securityGroupIds: Option[List[GenericString]] = None,
      subnetId: Option[String] = None,
      yarnEndpointAddress: Option[String] = None,
      privateAddress: Option[String] = None,
      zeppelinRemoteSparkInterpreterPort: Option[Int] = None,
      publicAddress: Option[String] = None,
      status: Option[String] = None,
      workerType: Option[String] = None,
      glueVersion: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      numberOfNodes: Option[Int] = None,
      availabilityZone: Option[String] = None,
      vpcId: Option[String] = None,
      extraPythonLibsS3Path: Option[String] = None,
      extraJarsS3Path: Option[String] = None,
      failureReason: Option[String] = None,
      lastUpdateStatus: Option[String] = None,
      createdTimestamp: Option[TimestampValue] = None,
      lastModifiedTimestamp: Option[TimestampValue] = None,
      publicKey: Option[String] = None,
      publicKeys: Option[List[GenericString]] = None,
      securityConfiguration: Option[String] = None,
      arguments: Option[MapValue] = None
    ): DevEndpoint =
      DevEndpoint
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(yarnEndpointAddress)(_.yarnEndpointAddress(_))
        .ifSome(privateAddress)(_.privateAddress(_))
        .ifSome(zeppelinRemoteSparkInterpreterPort)(_.zeppelinRemoteSparkInterpreterPort(_))
        .ifSome(publicAddress)(_.publicAddress(_))
        .ifSome(status)(_.status(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(numberOfNodes)(_.numberOfNodes(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(extraPythonLibsS3Path)(_.extraPythonLibsS3Path(_))
        .ifSome(extraJarsS3Path)(_.extraJarsS3Path(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(lastUpdateStatus)(_.lastUpdateStatus(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastModifiedTimestamp)(_.lastModifiedTimestamp(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(publicKeys)(_.publicKeys(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(arguments)(_.arguments(_))
        .build

    def devEndpointCustomLibraries(
      extraPythonLibsS3Path: Option[String] = None,
      extraJarsS3Path: Option[String] = None
    ): DevEndpointCustomLibraries =
      DevEndpointCustomLibraries
        .builder
        .ifSome(extraPythonLibsS3Path)(_.extraPythonLibsS3Path(_))
        .ifSome(extraJarsS3Path)(_.extraJarsS3Path(_))
        .build

    def doubleColumnStatisticsData(
      minimumValue: Option[Double] = None,
      maximumValue: Option[Double] = None,
      numberOfNulls: Option[NonNegativeLong] = None,
      numberOfDistinctValues: Option[NonNegativeLong] = None
    ): DoubleColumnStatisticsData =
      DoubleColumnStatisticsData
        .builder
        .ifSome(minimumValue)(_.minimumValue(_))
        .ifSome(maximumValue)(_.maximumValue(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .ifSome(numberOfDistinctValues)(_.numberOfDistinctValues(_))
        .build

    def dynamoDBTarget(
      path: Option[String] = None,
      scanAll: Option[Boolean] = None,
      scanRate: Option[NullableDouble] = None
    ): DynamoDBTarget =
      DynamoDBTarget
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(scanAll)(_.scanAll(_))
        .ifSome(scanRate)(_.scanRate(_))
        .build

    def edge(
      sourceId: Option[String] = None,
      destinationId: Option[String] = None
    ): Edge =
      Edge
        .builder
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(destinationId)(_.destinationId(_))
        .build

    def encryptionAtRest(
      catalogEncryptionMode: Option[String] = None,
      sseAwsKmsKeyId: Option[String] = None
    ): EncryptionAtRest =
      EncryptionAtRest
        .builder
        .ifSome(catalogEncryptionMode)(_.catalogEncryptionMode(_))
        .ifSome(sseAwsKmsKeyId)(_.sseAwsKmsKeyId(_))
        .build

    def encryptionConfiguration(
      s3Encryption: Option[List[S3Encryption]] = None,
      cloudWatchEncryption: Option[CloudWatchEncryption] = None,
      jobBookmarksEncryption: Option[JobBookmarksEncryption] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(s3Encryption)(_.s3Encryption(_))
        .ifSome(cloudWatchEncryption)(_.cloudWatchEncryption(_))
        .ifSome(jobBookmarksEncryption)(_.jobBookmarksEncryption(_))
        .build

    def entityNotFoundException(
      message: Option[String] = None
    ): EntityNotFoundException =
      EntityNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def errorDetail(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): ErrorDetail =
      ErrorDetail
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def errorDetails(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): ErrorDetails =
      ErrorDetails
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def evaluationMetrics(
      transformType: Option[String] = None,
      findMatchesMetrics: Option[FindMatchesMetrics] = None
    ): EvaluationMetrics =
      EvaluationMetrics
        .builder
        .ifSome(transformType)(_.transformType(_))
        .ifSome(findMatchesMetrics)(_.findMatchesMetrics(_))
        .build

    def executionProperty(
      maxConcurrentRuns: Option[Int] = None
    ): ExecutionProperty =
      ExecutionProperty
        .builder
        .ifSome(maxConcurrentRuns)(_.maxConcurrentRuns(_))
        .build

    def exportLabelsTaskRunProperties(
      outputS3Path: Option[String] = None
    ): ExportLabelsTaskRunProperties =
      ExportLabelsTaskRunProperties
        .builder
        .ifSome(outputS3Path)(_.outputS3Path(_))
        .build

    def findMatchesMetrics(
      areaUnderPRCurve: Option[GenericBoundedDouble] = None,
      precision: Option[GenericBoundedDouble] = None,
      recall: Option[GenericBoundedDouble] = None,
      f1: Option[GenericBoundedDouble] = None,
      confusionMatrix: Option[ConfusionMatrix] = None,
      columnImportances: Option[List[ColumnImportance]] = None
    ): FindMatchesMetrics =
      FindMatchesMetrics
        .builder
        .ifSome(areaUnderPRCurve)(_.areaUnderPRCurve(_))
        .ifSome(precision)(_.precision(_))
        .ifSome(recall)(_.recall(_))
        .ifSome(f1)(_.f1(_))
        .ifSome(confusionMatrix)(_.confusionMatrix(_))
        .ifSome(columnImportances)(_.columnImportances(_))
        .build

    def findMatchesParameters(
      primaryKeyColumnName: Option[String] = None,
      precisionRecallTradeoff: Option[GenericBoundedDouble] = None,
      accuracyCostTradeoff: Option[GenericBoundedDouble] = None,
      enforceProvidedLabels: Option[Boolean] = None
    ): FindMatchesParameters =
      FindMatchesParameters
        .builder
        .ifSome(primaryKeyColumnName)(_.primaryKeyColumnName(_))
        .ifSome(precisionRecallTradeoff)(_.precisionRecallTradeoff(_))
        .ifSome(accuracyCostTradeoff)(_.accuracyCostTradeoff(_))
        .ifSome(enforceProvidedLabels)(_.enforceProvidedLabels(_))
        .build

    def findMatchesTaskRunProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobRunId: Option[String] = None
    ): FindMatchesTaskRunProperties =
      FindMatchesTaskRunProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobRunId)(_.jobRunId(_))
        .build

    def getCatalogImportStatusRequest(
      catalogId: Option[String] = None
    ): GetCatalogImportStatusRequest =
      GetCatalogImportStatusRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def getCatalogImportStatusResponse(
      importStatus: Option[CatalogImportStatus] = None
    ): GetCatalogImportStatusResponse =
      GetCatalogImportStatusResponse
        .builder
        .ifSome(importStatus)(_.importStatus(_))
        .build

    def getClassifierRequest(
      name: Option[String] = None
    ): GetClassifierRequest =
      GetClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getClassifierResponse(
      classifier: Option[Classifier] = None
    ): GetClassifierResponse =
      GetClassifierResponse
        .builder
        .ifSome(classifier)(_.classifier(_))
        .build

    def getClassifiersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetClassifiersRequest =
      GetClassifiersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getClassifiersResponse(
      classifiers: Option[List[Classifier]] = None,
      nextToken: Option[String] = None
    ): GetClassifiersResponse =
      GetClassifiersResponse
        .builder
        .ifSome(classifiers)(_.classifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getColumnStatisticsForPartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionValues: Option[List[ValueString]] = None,
      columnNames: Option[List[NameString]] = None
    ): GetColumnStatisticsForPartitionRequest =
      GetColumnStatisticsForPartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionValues)(_.partitionValues(_))
        .ifSome(columnNames)(_.columnNames(_))
        .build

    def getColumnStatisticsForPartitionResponse(
      columnStatisticsList: Option[List[ColumnStatistics]] = None,
      errors: Option[List[ColumnError]] = None
    ): GetColumnStatisticsForPartitionResponse =
      GetColumnStatisticsForPartitionResponse
        .builder
        .ifSome(columnStatisticsList)(_.columnStatisticsList(_))
        .ifSome(errors)(_.errors(_))
        .build

    def getColumnStatisticsForTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      columnNames: Option[List[NameString]] = None
    ): GetColumnStatisticsForTableRequest =
      GetColumnStatisticsForTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(columnNames)(_.columnNames(_))
        .build

    def getColumnStatisticsForTableResponse(
      columnStatisticsList: Option[List[ColumnStatistics]] = None,
      errors: Option[List[ColumnError]] = None
    ): GetColumnStatisticsForTableResponse =
      GetColumnStatisticsForTableResponse
        .builder
        .ifSome(columnStatisticsList)(_.columnStatisticsList(_))
        .ifSome(errors)(_.errors(_))
        .build

    def getConnectionRequest(
      catalogId: Option[String] = None,
      name: Option[String] = None,
      hidePassword: Option[Boolean] = None
    ): GetConnectionRequest =
      GetConnectionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(name)(_.name(_))
        .ifSome(hidePassword)(_.hidePassword(_))
        .build

    def getConnectionResponse(
      connection: Option[Connection] = None
    ): GetConnectionResponse =
      GetConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def getConnectionsFilter(
      matchCriteria: Option[List[NameString]] = None,
      connectionType: Option[String] = None
    ): GetConnectionsFilter =
      GetConnectionsFilter
        .builder
        .ifSome(matchCriteria)(_.matchCriteria(_))
        .ifSome(connectionType)(_.connectionType(_))
        .build

    def getConnectionsRequest(
      catalogId: Option[String] = None,
      filter: Option[GetConnectionsFilter] = None,
      hidePassword: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetConnectionsRequest =
      GetConnectionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(hidePassword)(_.hidePassword(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getConnectionsResponse(
      connectionList: Option[List[Connection]] = None,
      nextToken: Option[String] = None
    ): GetConnectionsResponse =
      GetConnectionsResponse
        .builder
        .ifSome(connectionList)(_.connectionList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCrawlerMetricsRequest(
      crawlerNameList: Option[List[NameString]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetCrawlerMetricsRequest =
      GetCrawlerMetricsRequest
        .builder
        .ifSome(crawlerNameList)(_.crawlerNameList(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCrawlerMetricsResponse(
      crawlerMetricsList: Option[List[CrawlerMetrics]] = None,
      nextToken: Option[String] = None
    ): GetCrawlerMetricsResponse =
      GetCrawlerMetricsResponse
        .builder
        .ifSome(crawlerMetricsList)(_.crawlerMetricsList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCrawlerRequest(
      name: Option[String] = None
    ): GetCrawlerRequest =
      GetCrawlerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getCrawlerResponse(
      crawler: Option[Crawler] = None
    ): GetCrawlerResponse =
      GetCrawlerResponse
        .builder
        .ifSome(crawler)(_.crawler(_))
        .build

    def getCrawlersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetCrawlersRequest =
      GetCrawlersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCrawlersResponse(
      crawlers: Option[List[Crawler]] = None,
      nextToken: Option[String] = None
    ): GetCrawlersResponse =
      GetCrawlersResponse
        .builder
        .ifSome(crawlers)(_.crawlers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDataCatalogEncryptionSettingsRequest(
      catalogId: Option[String] = None
    ): GetDataCatalogEncryptionSettingsRequest =
      GetDataCatalogEncryptionSettingsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def getDataCatalogEncryptionSettingsResponse(
      dataCatalogEncryptionSettings: Option[DataCatalogEncryptionSettings] = None
    ): GetDataCatalogEncryptionSettingsResponse =
      GetDataCatalogEncryptionSettingsResponse
        .builder
        .ifSome(dataCatalogEncryptionSettings)(_.dataCatalogEncryptionSettings(_))
        .build

    def getDatabaseRequest(
      catalogId: Option[String] = None,
      name: Option[String] = None
    ): GetDatabaseRequest =
      GetDatabaseRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(name)(_.name(_))
        .build

    def getDatabaseResponse(
      database: Option[Database] = None
    ): GetDatabaseResponse =
      GetDatabaseResponse
        .builder
        .ifSome(database)(_.database(_))
        .build

    def getDatabasesRequest(
      catalogId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resourceShareType: Option[String] = None
    ): GetDatabasesRequest =
      GetDatabasesRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resourceShareType)(_.resourceShareType(_))
        .build

    def getDatabasesResponse(
      databaseList: Option[List[Database]] = None,
      nextToken: Option[String] = None
    ): GetDatabasesResponse =
      GetDatabasesResponse
        .builder
        .ifSome(databaseList)(_.databaseList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDataflowGraphRequest(
      pythonScript: Option[String] = None
    ): GetDataflowGraphRequest =
      GetDataflowGraphRequest
        .builder
        .ifSome(pythonScript)(_.pythonScript(_))
        .build

    def getDataflowGraphResponse(
      dagNodes: Option[List[CodeGenNode]] = None,
      dagEdges: Option[List[CodeGenEdge]] = None
    ): GetDataflowGraphResponse =
      GetDataflowGraphResponse
        .builder
        .ifSome(dagNodes)(_.dagNodes(_))
        .ifSome(dagEdges)(_.dagEdges(_))
        .build

    def getDevEndpointRequest(
      endpointName: Option[String] = None
    ): GetDevEndpointRequest =
      GetDevEndpointRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .build

    def getDevEndpointResponse(
      devEndpoint: Option[DevEndpoint] = None
    ): GetDevEndpointResponse =
      GetDevEndpointResponse
        .builder
        .ifSome(devEndpoint)(_.devEndpoint(_))
        .build

    def getDevEndpointsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetDevEndpointsRequest =
      GetDevEndpointsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDevEndpointsResponse(
      devEndpoints: Option[List[DevEndpoint]] = None,
      nextToken: Option[String] = None
    ): GetDevEndpointsResponse =
      GetDevEndpointsResponse
        .builder
        .ifSome(devEndpoints)(_.devEndpoints(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getJobBookmarkRequest(
      jobName: Option[String] = None,
      runId: Option[String] = None
    ): GetJobBookmarkRequest =
      GetJobBookmarkRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(runId)(_.runId(_))
        .build

    def getJobBookmarkResponse(
      jobBookmarkEntry: Option[JobBookmarkEntry] = None
    ): GetJobBookmarkResponse =
      GetJobBookmarkResponse
        .builder
        .ifSome(jobBookmarkEntry)(_.jobBookmarkEntry(_))
        .build

    def getJobRequest(
      jobName: Option[String] = None
    ): GetJobRequest =
      GetJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .build

    def getJobResponse(
      job: Option[Job] = None
    ): GetJobResponse =
      GetJobResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def getJobRunRequest(
      jobName: Option[String] = None,
      runId: Option[String] = None,
      predecessorsIncluded: Option[Boolean] = None
    ): GetJobRunRequest =
      GetJobRunRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(predecessorsIncluded)(_.predecessorsIncluded(_))
        .build

    def getJobRunResponse(
      jobRun: Option[JobRun] = None
    ): GetJobRunResponse =
      GetJobRunResponse
        .builder
        .ifSome(jobRun)(_.jobRun(_))
        .build

    def getJobRunsRequest(
      jobName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetJobRunsRequest =
      GetJobRunsRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getJobRunsResponse(
      jobRuns: Option[List[JobRun]] = None,
      nextToken: Option[String] = None
    ): GetJobRunsResponse =
      GetJobRunsResponse
        .builder
        .ifSome(jobRuns)(_.jobRuns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetJobsRequest =
      GetJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getJobsResponse(
      jobs: Option[List[Job]] = None,
      nextToken: Option[String] = None
    ): GetJobsResponse =
      GetJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getMLTaskRunRequest(
      transformId: Option[String] = None,
      taskRunId: Option[String] = None
    ): GetMLTaskRunRequest =
      GetMLTaskRunRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(taskRunId)(_.taskRunId(_))
        .build

    def getMLTaskRunResponse(
      transformId: Option[String] = None,
      taskRunId: Option[String] = None,
      status: Option[String] = None,
      logGroupName: Option[String] = None,
      properties: Option[TaskRunProperties] = None,
      errorString: Option[String] = None,
      startedOn: Option[Timestamp] = None,
      lastModifiedOn: Option[Timestamp] = None,
      completedOn: Option[Timestamp] = None,
      executionTime: Option[Int] = None
    ): GetMLTaskRunResponse =
      GetMLTaskRunResponse
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(taskRunId)(_.taskRunId(_))
        .ifSome(status)(_.status(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(errorString)(_.errorString(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(executionTime)(_.executionTime(_))
        .build

    def getMLTaskRunsRequest(
      transformId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[TaskRunFilterCriteria] = None,
      sort: Option[TaskRunSortCriteria] = None
    ): GetMLTaskRunsRequest =
      GetMLTaskRunsRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sort)(_.sort(_))
        .build

    def getMLTaskRunsResponse(
      taskRuns: Option[List[TaskRun]] = None,
      nextToken: Option[String] = None
    ): GetMLTaskRunsResponse =
      GetMLTaskRunsResponse
        .builder
        .ifSome(taskRuns)(_.taskRuns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getMLTransformRequest(
      transformId: Option[String] = None
    ): GetMLTransformRequest =
      GetMLTransformRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .build

    def getMLTransformResponse(
      transformId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      createdOn: Option[Timestamp] = None,
      lastModifiedOn: Option[Timestamp] = None,
      inputRecordTables: Option[List[GlueTable]] = None,
      parameters: Option[TransformParameters] = None,
      evaluationMetrics: Option[EvaluationMetrics] = None,
      labelCount: Option[Int] = None,
      schema: Option[List[SchemaColumn]] = None,
      role: Option[String] = None,
      glueVersion: Option[String] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      timeout: Option[Int] = None,
      maxRetries: Option[Int] = None,
      transformEncryption: Option[TransformEncryption] = None
    ): GetMLTransformResponse =
      GetMLTransformResponse
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdOn)(_.createdOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(inputRecordTables)(_.inputRecordTables(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(evaluationMetrics)(_.evaluationMetrics(_))
        .ifSome(labelCount)(_.labelCount(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(role)(_.role(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(transformEncryption)(_.transformEncryption(_))
        .build

    def getMLTransformsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[TransformFilterCriteria] = None,
      sort: Option[TransformSortCriteria] = None
    ): GetMLTransformsRequest =
      GetMLTransformsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sort)(_.sort(_))
        .build

    def getMLTransformsResponse(
      transforms: Option[List[MLTransform]] = None,
      nextToken: Option[String] = None
    ): GetMLTransformsResponse =
      GetMLTransformsResponse
        .builder
        .ifSome(transforms)(_.transforms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getMappingRequest(
      source: Option[CatalogEntry] = None,
      sinks: Option[List[CatalogEntry]] = None,
      location: Option[Location] = None
    ): GetMappingRequest =
      GetMappingRequest
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(sinks)(_.sinks(_))
        .ifSome(location)(_.location(_))
        .build

    def getMappingResponse(
      mapping: Option[List[MappingEntry]] = None
    ): GetMappingResponse =
      GetMappingResponse
        .builder
        .ifSome(mapping)(_.mapping(_))
        .build

    def getPartitionIndexesRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      nextToken: Option[String] = None
    ): GetPartitionIndexesRequest =
      GetPartitionIndexesRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getPartitionIndexesResponse(
      partitionIndexDescriptorList: Option[List[PartitionIndexDescriptor]] = None,
      nextToken: Option[String] = None
    ): GetPartitionIndexesResponse =
      GetPartitionIndexesResponse
        .builder
        .ifSome(partitionIndexDescriptorList)(_.partitionIndexDescriptorList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getPartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionValues: Option[List[ValueString]] = None
    ): GetPartitionRequest =
      GetPartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionValues)(_.partitionValues(_))
        .build

    def getPartitionResponse(
      partition: Option[Partition] = None
    ): GetPartitionResponse =
      GetPartitionResponse
        .builder
        .ifSome(partition)(_.partition(_))
        .build

    def getPartitionsRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      expression: Option[String] = None,
      nextToken: Option[String] = None,
      segment: Option[Segment] = None,
      maxResults: Option[Int] = None,
      excludeColumnSchema: Option[Boolean] = None
    ): GetPartitionsRequest =
      GetPartitionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(segment)(_.segment(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(excludeColumnSchema)(_.excludeColumnSchema(_))
        .build

    def getPartitionsResponse(
      partitions: Option[List[Partition]] = None,
      nextToken: Option[String] = None
    ): GetPartitionsResponse =
      GetPartitionsResponse
        .builder
        .ifSome(partitions)(_.partitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getPlanRequest(
      mapping: Option[List[MappingEntry]] = None,
      source: Option[CatalogEntry] = None,
      sinks: Option[List[CatalogEntry]] = None,
      location: Option[Location] = None,
      language: Option[String] = None,
      additionalPlanOptionsMap: Option[AdditionalPlanOptionsMap] = None
    ): GetPlanRequest =
      GetPlanRequest
        .builder
        .ifSome(mapping)(_.mapping(_))
        .ifSome(source)(_.source(_))
        .ifSome(sinks)(_.sinks(_))
        .ifSome(location)(_.location(_))
        .ifSome(language)(_.language(_))
        .ifSome(additionalPlanOptionsMap)(_.additionalPlanOptionsMap(_))
        .build

    def getPlanResponse(
      pythonScript: Option[String] = None,
      scalaCode: Option[String] = None
    ): GetPlanResponse =
      GetPlanResponse
        .builder
        .ifSome(pythonScript)(_.pythonScript(_))
        .ifSome(scalaCode)(_.scalaCode(_))
        .build

    def getRegistryInput(
      registryId: Option[RegistryId] = None
    ): GetRegistryInput =
      GetRegistryInput
        .builder
        .ifSome(registryId)(_.registryId(_))
        .build

    def getRegistryResponse(
      registryName: Option[String] = None,
      registryArn: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[String] = None,
      updatedTime: Option[String] = None
    ): GetRegistryResponse =
      GetRegistryResponse
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .build

    def getResourcePoliciesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetResourcePoliciesRequest =
      GetResourcePoliciesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getResourcePoliciesResponse(
      getResourcePoliciesResponseList: Option[List[GluePolicy]] = None,
      nextToken: Option[String] = None
    ): GetResourcePoliciesResponse =
      GetResourcePoliciesResponse
        .builder
        .ifSome(getResourcePoliciesResponseList)(_.getResourcePoliciesResponseList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourcePolicyRequest(
      resourceArn: Option[String] = None
    ): GetResourcePolicyRequest =
      GetResourcePolicyRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getResourcePolicyResponse(
      policyInJson: Option[String] = None,
      policyHash: Option[String] = None,
      createTime: Option[Timestamp] = None,
      updateTime: Option[Timestamp] = None
    ): GetResourcePolicyResponse =
      GetResourcePolicyResponse
        .builder
        .ifSome(policyInJson)(_.policyInJson(_))
        .ifSome(policyHash)(_.policyHash(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def getSchemaByDefinitionInput(
      schemaId: Option[SchemaId] = None,
      schemaDefinition: Option[String] = None
    ): GetSchemaByDefinitionInput =
      GetSchemaByDefinitionInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaDefinition)(_.schemaDefinition(_))
        .build

    def getSchemaByDefinitionResponse(
      schemaVersionId: Option[String] = None,
      schemaArn: Option[String] = None,
      dataFormat: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[String] = None
    ): GetSchemaByDefinitionResponse =
      GetSchemaByDefinitionResponse
        .builder
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def getSchemaInput(
      schemaId: Option[SchemaId] = None
    ): GetSchemaInput =
      GetSchemaInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .build

    def getSchemaResponse(
      registryName: Option[String] = None,
      registryArn: Option[String] = None,
      schemaName: Option[String] = None,
      schemaArn: Option[String] = None,
      description: Option[String] = None,
      dataFormat: Option[String] = None,
      compatibility: Option[String] = None,
      schemaCheckpoint: Option[SchemaCheckpointNumber] = None,
      latestSchemaVersion: Option[VersionLongNumber] = None,
      nextSchemaVersion: Option[VersionLongNumber] = None,
      schemaStatus: Option[String] = None,
      createdTime: Option[String] = None,
      updatedTime: Option[String] = None
    ): GetSchemaResponse =
      GetSchemaResponse
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(compatibility)(_.compatibility(_))
        .ifSome(schemaCheckpoint)(_.schemaCheckpoint(_))
        .ifSome(latestSchemaVersion)(_.latestSchemaVersion(_))
        .ifSome(nextSchemaVersion)(_.nextSchemaVersion(_))
        .ifSome(schemaStatus)(_.schemaStatus(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .build

    def getSchemaVersionInput(
      schemaId: Option[SchemaId] = None,
      schemaVersionId: Option[String] = None,
      schemaVersionNumber: Option[SchemaVersionNumber] = None
    ): GetSchemaVersionInput =
      GetSchemaVersionInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(schemaVersionNumber)(_.schemaVersionNumber(_))
        .build

    def getSchemaVersionResponse(
      schemaVersionId: Option[String] = None,
      schemaDefinition: Option[String] = None,
      dataFormat: Option[String] = None,
      schemaArn: Option[String] = None,
      versionNumber: Option[VersionLongNumber] = None,
      status: Option[String] = None,
      createdTime: Option[String] = None
    ): GetSchemaVersionResponse =
      GetSchemaVersionResponse
        .builder
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(schemaDefinition)(_.schemaDefinition(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def getSchemaVersionsDiffInput(
      schemaId: Option[SchemaId] = None,
      firstSchemaVersionNumber: Option[SchemaVersionNumber] = None,
      secondSchemaVersionNumber: Option[SchemaVersionNumber] = None,
      schemaDiffType: Option[String] = None
    ): GetSchemaVersionsDiffInput =
      GetSchemaVersionsDiffInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(firstSchemaVersionNumber)(_.firstSchemaVersionNumber(_))
        .ifSome(secondSchemaVersionNumber)(_.secondSchemaVersionNumber(_))
        .ifSome(schemaDiffType)(_.schemaDiffType(_))
        .build

    def getSchemaVersionsDiffResponse(
      diff: Option[String] = None
    ): GetSchemaVersionsDiffResponse =
      GetSchemaVersionsDiffResponse
        .builder
        .ifSome(diff)(_.diff(_))
        .build

    def getSecurityConfigurationRequest(
      name: Option[String] = None
    ): GetSecurityConfigurationRequest =
      GetSecurityConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getSecurityConfigurationResponse(
      securityConfiguration: Option[SecurityConfiguration] = None
    ): GetSecurityConfigurationResponse =
      GetSecurityConfigurationResponse
        .builder
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .build

    def getSecurityConfigurationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetSecurityConfigurationsRequest =
      GetSecurityConfigurationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSecurityConfigurationsResponse(
      securityConfigurations: Option[List[SecurityConfiguration]] = None,
      nextToken: Option[String] = None
    ): GetSecurityConfigurationsResponse =
      GetSecurityConfigurationsResponse
        .builder
        .ifSome(securityConfigurations)(_.securityConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      name: Option[String] = None
    ): GetTableRequest =
      GetTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(name)(_.name(_))
        .build

    def getTableResponse(
      table: Option[Table] = None
    ): GetTableResponse =
      GetTableResponse
        .builder
        .ifSome(table)(_.table(_))
        .build

    def getTableVersionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      versionId: Option[String] = None
    ): GetTableVersionRequest =
      GetTableVersionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def getTableVersionResponse(
      tableVersion: Option[TableVersion] = None
    ): GetTableVersionResponse =
      GetTableVersionResponse
        .builder
        .ifSome(tableVersion)(_.tableVersion(_))
        .build

    def getTableVersionsRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetTableVersionsRequest =
      GetTableVersionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getTableVersionsResponse(
      tableVersions: Option[List[TableVersion]] = None,
      nextToken: Option[String] = None
    ): GetTableVersionsResponse =
      GetTableVersionsResponse
        .builder
        .ifSome(tableVersions)(_.tableVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTablesRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      expression: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetTablesRequest =
      GetTablesRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getTablesResponse(
      tableList: Option[List[Table]] = None,
      nextToken: Option[String] = None
    ): GetTablesResponse =
      GetTablesResponse
        .builder
        .ifSome(tableList)(_.tableList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTagsRequest(
      resourceArn: Option[String] = None
    ): GetTagsRequest =
      GetTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getTagsResponse(
      tags: Option[TagsMap] = None
    ): GetTagsResponse =
      GetTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def getTriggerRequest(
      name: Option[String] = None
    ): GetTriggerRequest =
      GetTriggerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getTriggerResponse(
      trigger: Option[Trigger] = None
    ): GetTriggerResponse =
      GetTriggerResponse
        .builder
        .ifSome(trigger)(_.trigger(_))
        .build

    def getTriggersRequest(
      nextToken: Option[String] = None,
      dependentJobName: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetTriggersRequest =
      GetTriggersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(dependentJobName)(_.dependentJobName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getTriggersResponse(
      triggers: Option[List[Trigger]] = None,
      nextToken: Option[String] = None
    ): GetTriggersResponse =
      GetTriggersResponse
        .builder
        .ifSome(triggers)(_.triggers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getUserDefinedFunctionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      functionName: Option[String] = None
    ): GetUserDefinedFunctionRequest =
      GetUserDefinedFunctionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(functionName)(_.functionName(_))
        .build

    def getUserDefinedFunctionResponse(
      userDefinedFunction: Option[UserDefinedFunction] = None
    ): GetUserDefinedFunctionResponse =
      GetUserDefinedFunctionResponse
        .builder
        .ifSome(userDefinedFunction)(_.userDefinedFunction(_))
        .build

    def getUserDefinedFunctionsRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      pattern: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetUserDefinedFunctionsRequest =
      GetUserDefinedFunctionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getUserDefinedFunctionsResponse(
      userDefinedFunctions: Option[List[UserDefinedFunction]] = None,
      nextToken: Option[String] = None
    ): GetUserDefinedFunctionsResponse =
      GetUserDefinedFunctionsResponse
        .builder
        .ifSome(userDefinedFunctions)(_.userDefinedFunctions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getWorkflowRequest(
      name: Option[String] = None,
      includeGraph: Option[Boolean] = None
    ): GetWorkflowRequest =
      GetWorkflowRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(includeGraph)(_.includeGraph(_))
        .build

    def getWorkflowResponse(
      workflow: Option[Workflow] = None
    ): GetWorkflowResponse =
      GetWorkflowResponse
        .builder
        .ifSome(workflow)(_.workflow(_))
        .build

    def getWorkflowRunPropertiesRequest(
      name: Option[String] = None,
      runId: Option[String] = None
    ): GetWorkflowRunPropertiesRequest =
      GetWorkflowRunPropertiesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .build

    def getWorkflowRunPropertiesResponse(
      runProperties: Option[WorkflowRunProperties] = None
    ): GetWorkflowRunPropertiesResponse =
      GetWorkflowRunPropertiesResponse
        .builder
        .ifSome(runProperties)(_.runProperties(_))
        .build

    def getWorkflowRunRequest(
      name: Option[String] = None,
      runId: Option[String] = None,
      includeGraph: Option[Boolean] = None
    ): GetWorkflowRunRequest =
      GetWorkflowRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(includeGraph)(_.includeGraph(_))
        .build

    def getWorkflowRunResponse(
      run: Option[WorkflowRun] = None
    ): GetWorkflowRunResponse =
      GetWorkflowRunResponse
        .builder
        .ifSome(run)(_.run(_))
        .build

    def getWorkflowRunsRequest(
      name: Option[String] = None,
      includeGraph: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetWorkflowRunsRequest =
      GetWorkflowRunsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(includeGraph)(_.includeGraph(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getWorkflowRunsResponse(
      runs: Option[List[WorkflowRun]] = None,
      nextToken: Option[String] = None
    ): GetWorkflowRunsResponse =
      GetWorkflowRunsResponse
        .builder
        .ifSome(runs)(_.runs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def glueEncryptionException(
      message: Option[String] = None
    ): GlueEncryptionException =
      GlueEncryptionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def gluePolicy(
      policyInJson: Option[String] = None,
      policyHash: Option[String] = None,
      createTime: Option[Timestamp] = None,
      updateTime: Option[Timestamp] = None
    ): GluePolicy =
      GluePolicy
        .builder
        .ifSome(policyInJson)(_.policyInJson(_))
        .ifSome(policyHash)(_.policyHash(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def glueTable(
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      catalogId: Option[String] = None,
      connectionName: Option[String] = None
    ): GlueTable =
      GlueTable
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(connectionName)(_.connectionName(_))
        .build

    def grokClassifier(
      name: Option[String] = None,
      classification: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None,
      version: Option[VersionId] = None,
      grokPattern: Option[String] = None,
      customPatterns: Option[String] = None
    ): GrokClassifier =
      GrokClassifier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(classification)(_.classification(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(version)(_.version(_))
        .ifSome(grokPattern)(_.grokPattern(_))
        .ifSome(customPatterns)(_.customPatterns(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def illegalWorkflowStateException(
      message: Option[String] = None
    ): IllegalWorkflowStateException =
      IllegalWorkflowStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def importCatalogToGlueRequest(
      catalogId: Option[String] = None
    ): ImportCatalogToGlueRequest =
      ImportCatalogToGlueRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def importCatalogToGlueResponse(

    ): ImportCatalogToGlueResponse =
      ImportCatalogToGlueResponse
        .builder

        .build

    def importLabelsTaskRunProperties(
      inputS3Path: Option[String] = None,
      replace: Option[Boolean] = None
    ): ImportLabelsTaskRunProperties =
      ImportLabelsTaskRunProperties
        .builder
        .ifSome(inputS3Path)(_.inputS3Path(_))
        .ifSome(replace)(_.replace(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jdbcTarget(
      connectionName: Option[String] = None,
      path: Option[String] = None,
      exclusions: Option[List[Path]] = None
    ): JdbcTarget =
      JdbcTarget
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(path)(_.path(_))
        .ifSome(exclusions)(_.exclusions(_))
        .build

    def job(
      name: Option[String] = None,
      description: Option[String] = None,
      logUri: Option[String] = None,
      role: Option[String] = None,
      createdOn: Option[TimestampValue] = None,
      lastModifiedOn: Option[TimestampValue] = None,
      executionProperty: Option[ExecutionProperty] = None,
      command: Option[JobCommand] = None,
      defaultArguments: Option[GenericMap] = None,
      nonOverridableArguments: Option[GenericMap] = None,
      connections: Option[ConnectionsList] = None,
      maxRetries: Option[Int] = None,
      allocatedCapacity: Option[Int] = None,
      timeout: Option[Int] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      securityConfiguration: Option[String] = None,
      notificationProperty: Option[NotificationProperty] = None,
      glueVersion: Option[String] = None
    ): Job =
      Job
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(role)(_.role(_))
        .ifSome(createdOn)(_.createdOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(executionProperty)(_.executionProperty(_))
        .ifSome(command)(_.command(_))
        .ifSome(defaultArguments)(_.defaultArguments(_))
        .ifSome(nonOverridableArguments)(_.nonOverridableArguments(_))
        .ifSome(connections)(_.connections(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(allocatedCapacity)(_.allocatedCapacity(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(notificationProperty)(_.notificationProperty(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .build

    def jobBookmarkEntry(
      jobName: Option[String] = None,
      version: Option[Int] = None,
      run: Option[Int] = None,
      attempt: Option[Int] = None,
      previousRunId: Option[String] = None,
      runId: Option[String] = None,
      jobBookmark: Option[String] = None
    ): JobBookmarkEntry =
      JobBookmarkEntry
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(version)(_.version(_))
        .ifSome(run)(_.run(_))
        .ifSome(attempt)(_.attempt(_))
        .ifSome(previousRunId)(_.previousRunId(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(jobBookmark)(_.jobBookmark(_))
        .build

    def jobBookmarksEncryption(
      jobBookmarksEncryptionMode: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): JobBookmarksEncryption =
      JobBookmarksEncryption
        .builder
        .ifSome(jobBookmarksEncryptionMode)(_.jobBookmarksEncryptionMode(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def jobCommand(
      name: Option[String] = None,
      scriptLocation: Option[String] = None,
      pythonVersion: Option[String] = None
    ): JobCommand =
      JobCommand
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(scriptLocation)(_.scriptLocation(_))
        .ifSome(pythonVersion)(_.pythonVersion(_))
        .build

    def jobNodeDetails(
      jobRuns: Option[List[JobRun]] = None
    ): JobNodeDetails =
      JobNodeDetails
        .builder
        .ifSome(jobRuns)(_.jobRuns(_))
        .build

    def jobRun(
      id: Option[String] = None,
      attempt: Option[Int] = None,
      previousRunId: Option[String] = None,
      triggerName: Option[String] = None,
      jobName: Option[String] = None,
      startedOn: Option[TimestampValue] = None,
      lastModifiedOn: Option[TimestampValue] = None,
      completedOn: Option[TimestampValue] = None,
      jobRunState: Option[String] = None,
      arguments: Option[GenericMap] = None,
      errorMessage: Option[String] = None,
      predecessorRuns: Option[List[Predecessor]] = None,
      allocatedCapacity: Option[Int] = None,
      executionTime: Option[Int] = None,
      timeout: Option[Int] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      securityConfiguration: Option[String] = None,
      logGroupName: Option[String] = None,
      notificationProperty: Option[NotificationProperty] = None,
      glueVersion: Option[String] = None
    ): JobRun =
      JobRun
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(attempt)(_.attempt(_))
        .ifSome(previousRunId)(_.previousRunId(_))
        .ifSome(triggerName)(_.triggerName(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(jobRunState)(_.jobRunState(_))
        .ifSome(arguments)(_.arguments(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(predecessorRuns)(_.predecessorRuns(_))
        .ifSome(allocatedCapacity)(_.allocatedCapacity(_))
        .ifSome(executionTime)(_.executionTime(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(notificationProperty)(_.notificationProperty(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .build

    def jobUpdate(
      description: Option[String] = None,
      logUri: Option[String] = None,
      role: Option[String] = None,
      executionProperty: Option[ExecutionProperty] = None,
      command: Option[JobCommand] = None,
      defaultArguments: Option[GenericMap] = None,
      nonOverridableArguments: Option[GenericMap] = None,
      connections: Option[ConnectionsList] = None,
      maxRetries: Option[Int] = None,
      allocatedCapacity: Option[Int] = None,
      timeout: Option[Int] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      securityConfiguration: Option[String] = None,
      notificationProperty: Option[NotificationProperty] = None,
      glueVersion: Option[String] = None
    ): JobUpdate =
      JobUpdate
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(logUri)(_.logUri(_))
        .ifSome(role)(_.role(_))
        .ifSome(executionProperty)(_.executionProperty(_))
        .ifSome(command)(_.command(_))
        .ifSome(defaultArguments)(_.defaultArguments(_))
        .ifSome(nonOverridableArguments)(_.nonOverridableArguments(_))
        .ifSome(connections)(_.connections(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(allocatedCapacity)(_.allocatedCapacity(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(notificationProperty)(_.notificationProperty(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .build

    def jsonClassifier(
      name: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None,
      version: Option[VersionId] = None,
      jsonPath: Option[String] = None
    ): JsonClassifier =
      JsonClassifier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(version)(_.version(_))
        .ifSome(jsonPath)(_.jsonPath(_))
        .build

    def keySchemaElement(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): KeySchemaElement =
      KeySchemaElement
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def labelingSetGenerationTaskRunProperties(
      outputS3Path: Option[String] = None
    ): LabelingSetGenerationTaskRunProperties =
      LabelingSetGenerationTaskRunProperties
        .builder
        .ifSome(outputS3Path)(_.outputS3Path(_))
        .build

    def lastCrawlInfo(
      status: Option[String] = None,
      errorMessage: Option[String] = None,
      logGroup: Option[String] = None,
      logStream: Option[String] = None,
      messagePrefix: Option[String] = None,
      startTime: Option[Timestamp] = None
    ): LastCrawlInfo =
      LastCrawlInfo
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(logGroup)(_.logGroup(_))
        .ifSome(logStream)(_.logStream(_))
        .ifSome(messagePrefix)(_.messagePrefix(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def lineageConfiguration(
      crawlerLineageSettings: Option[String] = None
    ): LineageConfiguration =
      LineageConfiguration
        .builder
        .ifSome(crawlerLineageSettings)(_.crawlerLineageSettings(_))
        .build

    def listCrawlersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      tags: Option[TagsMap] = None
    ): ListCrawlersRequest =
      ListCrawlersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listCrawlersResponse(
      crawlerNames: Option[List[NameString]] = None,
      nextToken: Option[String] = None
    ): ListCrawlersResponse =
      ListCrawlersResponse
        .builder
        .ifSome(crawlerNames)(_.crawlerNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevEndpointsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      tags: Option[TagsMap] = None
    ): ListDevEndpointsRequest =
      ListDevEndpointsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listDevEndpointsResponse(
      devEndpointNames: Option[List[NameString]] = None,
      nextToken: Option[String] = None
    ): ListDevEndpointsResponse =
      ListDevEndpointsResponse
        .builder
        .ifSome(devEndpointNames)(_.devEndpointNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      tags: Option[TagsMap] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listJobsResponse(
      jobNames: Option[List[NameString]] = None,
      nextToken: Option[String] = None
    ): ListJobsResponse =
      ListJobsResponse
        .builder
        .ifSome(jobNames)(_.jobNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMLTransformsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[TransformFilterCriteria] = None,
      sort: Option[TransformSortCriteria] = None,
      tags: Option[TagsMap] = None
    ): ListMLTransformsRequest =
      ListMLTransformsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listMLTransformsResponse(
      transformIds: Option[List[HashString]] = None,
      nextToken: Option[String] = None
    ): ListMLTransformsResponse =
      ListMLTransformsResponse
        .builder
        .ifSome(transformIds)(_.transformIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRegistriesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRegistriesInput =
      ListRegistriesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRegistriesResponse(
      registries: Option[List[RegistryListItem]] = None,
      nextToken: Option[String] = None
    ): ListRegistriesResponse =
      ListRegistriesResponse
        .builder
        .ifSome(registries)(_.registries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchemaVersionsInput(
      schemaId: Option[SchemaId] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSchemaVersionsInput =
      ListSchemaVersionsInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchemaVersionsResponse(
      schemas: Option[List[SchemaVersionListItem]] = None,
      nextToken: Option[String] = None
    ): ListSchemaVersionsResponse =
      ListSchemaVersionsResponse
        .builder
        .ifSome(schemas)(_.schemas(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchemasInput(
      registryId: Option[RegistryId] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSchemasInput =
      ListSchemasInput
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchemasResponse(
      schemas: Option[List[SchemaListItem]] = None,
      nextToken: Option[String] = None
    ): ListSchemasResponse =
      ListSchemasResponse
        .builder
        .ifSome(schemas)(_.schemas(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTriggersRequest(
      nextToken: Option[String] = None,
      dependentJobName: Option[String] = None,
      maxResults: Option[Int] = None,
      tags: Option[TagsMap] = None
    ): ListTriggersRequest =
      ListTriggersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(dependentJobName)(_.dependentJobName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listTriggersResponse(
      triggerNames: Option[List[NameString]] = None,
      nextToken: Option[String] = None
    ): ListTriggersResponse =
      ListTriggersResponse
        .builder
        .ifSome(triggerNames)(_.triggerNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorkflowsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkflowsRequest =
      ListWorkflowsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkflowsResponse(
      workflows: Option[List[NameString]] = None,
      nextToken: Option[String] = None
    ): ListWorkflowsResponse =
      ListWorkflowsResponse
        .builder
        .ifSome(workflows)(_.workflows(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def location(
      jdbc: Option[List[CodeGenNodeArg]] = None,
      s3: Option[List[CodeGenNodeArg]] = None,
      dynamoDB: Option[List[CodeGenNodeArg]] = None
    ): Location =
      Location
        .builder
        .ifSome(jdbc)(_.jdbc(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(dynamoDB)(_.dynamoDB(_))
        .build

    def longColumnStatisticsData(
      minimumValue: Option[Long] = None,
      maximumValue: Option[Long] = None,
      numberOfNulls: Option[NonNegativeLong] = None,
      numberOfDistinctValues: Option[NonNegativeLong] = None
    ): LongColumnStatisticsData =
      LongColumnStatisticsData
        .builder
        .ifSome(minimumValue)(_.minimumValue(_))
        .ifSome(maximumValue)(_.maximumValue(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .ifSome(numberOfDistinctValues)(_.numberOfDistinctValues(_))
        .build

    def mLTransform(
      transformId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      createdOn: Option[Timestamp] = None,
      lastModifiedOn: Option[Timestamp] = None,
      inputRecordTables: Option[List[GlueTable]] = None,
      parameters: Option[TransformParameters] = None,
      evaluationMetrics: Option[EvaluationMetrics] = None,
      labelCount: Option[Int] = None,
      schema: Option[List[SchemaColumn]] = None,
      role: Option[String] = None,
      glueVersion: Option[String] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      timeout: Option[Int] = None,
      maxRetries: Option[Int] = None,
      transformEncryption: Option[TransformEncryption] = None
    ): MLTransform =
      MLTransform
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdOn)(_.createdOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(inputRecordTables)(_.inputRecordTables(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(evaluationMetrics)(_.evaluationMetrics(_))
        .ifSome(labelCount)(_.labelCount(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(role)(_.role(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(transformEncryption)(_.transformEncryption(_))
        .build

    def mLTransformNotReadyException(
      message: Option[String] = None
    ): MLTransformNotReadyException =
      MLTransformNotReadyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def mLUserDataEncryption(
      mlUserDataEncryptionMode: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): MLUserDataEncryption =
      MLUserDataEncryption
        .builder
        .ifSome(mlUserDataEncryptionMode)(_.mlUserDataEncryptionMode(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def mappingEntry(
      sourceTable: Option[String] = None,
      sourcePath: Option[String] = None,
      sourceType: Option[String] = None,
      targetTable: Option[String] = None,
      targetPath: Option[String] = None,
      targetType: Option[String] = None
    ): MappingEntry =
      MappingEntry
        .builder
        .ifSome(sourceTable)(_.sourceTable(_))
        .ifSome(sourcePath)(_.sourcePath(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(targetTable)(_.targetTable(_))
        .ifSome(targetPath)(_.targetPath(_))
        .ifSome(targetType)(_.targetType(_))
        .build

    def metadataInfo(
      metadataValue: Option[String] = None,
      createdTime: Option[String] = None,
      otherMetadataValueList: Option[List[OtherMetadataValueListItem]] = None
    ): MetadataInfo =
      MetadataInfo
        .builder
        .ifSome(metadataValue)(_.metadataValue(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(otherMetadataValueList)(_.otherMetadataValueList(_))
        .build

    def metadataKeyValuePair(
      metadataKey: Option[String] = None,
      metadataValue: Option[String] = None
    ): MetadataKeyValuePair =
      MetadataKeyValuePair
        .builder
        .ifSome(metadataKey)(_.metadataKey(_))
        .ifSome(metadataValue)(_.metadataValue(_))
        .build

    def mongoDBTarget(
      connectionName: Option[String] = None,
      path: Option[String] = None,
      scanAll: Option[Boolean] = None
    ): MongoDBTarget =
      MongoDBTarget
        .builder
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(path)(_.path(_))
        .ifSome(scanAll)(_.scanAll(_))
        .build

    def noScheduleException(
      message: Option[String] = None
    ): NoScheduleException =
      NoScheduleException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def node(
      `type`: Option[String] = None,
      name: Option[String] = None,
      uniqueId: Option[String] = None,
      triggerDetails: Option[TriggerNodeDetails] = None,
      jobDetails: Option[JobNodeDetails] = None,
      crawlerDetails: Option[CrawlerNodeDetails] = None
    ): Node =
      Node
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(uniqueId)(_.uniqueId(_))
        .ifSome(triggerDetails)(_.triggerDetails(_))
        .ifSome(jobDetails)(_.jobDetails(_))
        .ifSome(crawlerDetails)(_.crawlerDetails(_))
        .build

    def notificationProperty(
      notifyDelayAfter: Option[Int] = None
    ): NotificationProperty =
      NotificationProperty
        .builder
        .ifSome(notifyDelayAfter)(_.notifyDelayAfter(_))
        .build

    def operationTimeoutException(
      message: Option[String] = None
    ): OperationTimeoutException =
      OperationTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def order(
      column: Option[String] = None,
      sortOrder: Option[Int] = None
    ): Order =
      Order
        .builder
        .ifSome(column)(_.column(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def otherMetadataValueListItem(
      metadataValue: Option[String] = None,
      createdTime: Option[String] = None
    ): OtherMetadataValueListItem =
      OtherMetadataValueListItem
        .builder
        .ifSome(metadataValue)(_.metadataValue(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def partition(
      values: Option[List[ValueString]] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastAccessTime: Option[Timestamp] = None,
      storageDescriptor: Option[StorageDescriptor] = None,
      parameters: Option[ParametersMap] = None,
      lastAnalyzedTime: Option[Timestamp] = None,
      catalogId: Option[String] = None
    ): Partition =
      Partition
        .builder
        .ifSome(values)(_.values(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastAccessTime)(_.lastAccessTime(_))
        .ifSome(storageDescriptor)(_.storageDescriptor(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(lastAnalyzedTime)(_.lastAnalyzedTime(_))
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def partitionError(
      partitionValues: Option[List[ValueString]] = None,
      errorDetail: Option[ErrorDetail] = None
    ): PartitionError =
      PartitionError
        .builder
        .ifSome(partitionValues)(_.partitionValues(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .build

    def partitionIndex(
      keys: Option[List[NameString]] = None,
      indexName: Option[String] = None
    ): PartitionIndex =
      PartitionIndex
        .builder
        .ifSome(keys)(_.keys(_))
        .ifSome(indexName)(_.indexName(_))
        .build

    def partitionIndexDescriptor(
      indexName: Option[String] = None,
      keys: Option[List[KeySchemaElement]] = None,
      indexStatus: Option[String] = None,
      backfillErrors: Option[List[BackfillError]] = None
    ): PartitionIndexDescriptor =
      PartitionIndexDescriptor
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(indexStatus)(_.indexStatus(_))
        .ifSome(backfillErrors)(_.backfillErrors(_))
        .build

    def partitionInput(
      values: Option[List[ValueString]] = None,
      lastAccessTime: Option[Timestamp] = None,
      storageDescriptor: Option[StorageDescriptor] = None,
      parameters: Option[ParametersMap] = None,
      lastAnalyzedTime: Option[Timestamp] = None
    ): PartitionInput =
      PartitionInput
        .builder
        .ifSome(values)(_.values(_))
        .ifSome(lastAccessTime)(_.lastAccessTime(_))
        .ifSome(storageDescriptor)(_.storageDescriptor(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(lastAnalyzedTime)(_.lastAnalyzedTime(_))
        .build

    def partitionValueList(
      values: Option[List[ValueString]] = None
    ): PartitionValueList =
      PartitionValueList
        .builder
        .ifSome(values)(_.values(_))
        .build

    def physicalConnectionRequirements(
      subnetId: Option[String] = None,
      securityGroupIdList: Option[List[NameString]] = None,
      availabilityZone: Option[String] = None
    ): PhysicalConnectionRequirements =
      PhysicalConnectionRequirements
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(securityGroupIdList)(_.securityGroupIdList(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .build

    def predecessor(
      jobName: Option[String] = None,
      runId: Option[String] = None
    ): Predecessor =
      Predecessor
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(runId)(_.runId(_))
        .build

    def predicate(
      logical: Option[String] = None,
      conditions: Option[List[Condition]] = None
    ): Predicate =
      Predicate
        .builder
        .ifSome(logical)(_.logical(_))
        .ifSome(conditions)(_.conditions(_))
        .build

    def principalPermissions(
      principal: Option[DataLakePrincipal] = None,
      permissions: Option[List[Permission]] = None
    ): PrincipalPermissions =
      PrincipalPermissions
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def propertyPredicate(
      key: Option[String] = None,
      value: Option[String] = None,
      comparator: Option[String] = None
    ): PropertyPredicate =
      PropertyPredicate
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(comparator)(_.comparator(_))
        .build

    def putDataCatalogEncryptionSettingsRequest(
      catalogId: Option[String] = None,
      dataCatalogEncryptionSettings: Option[DataCatalogEncryptionSettings] = None
    ): PutDataCatalogEncryptionSettingsRequest =
      PutDataCatalogEncryptionSettingsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(dataCatalogEncryptionSettings)(_.dataCatalogEncryptionSettings(_))
        .build

    def putDataCatalogEncryptionSettingsResponse(

    ): PutDataCatalogEncryptionSettingsResponse =
      PutDataCatalogEncryptionSettingsResponse
        .builder

        .build

    def putResourcePolicyRequest(
      policyInJson: Option[String] = None,
      resourceArn: Option[String] = None,
      policyHashCondition: Option[String] = None,
      policyExistsCondition: Option[String] = None,
      enableHybrid: Option[String] = None
    ): PutResourcePolicyRequest =
      PutResourcePolicyRequest
        .builder
        .ifSome(policyInJson)(_.policyInJson(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(policyHashCondition)(_.policyHashCondition(_))
        .ifSome(policyExistsCondition)(_.policyExistsCondition(_))
        .ifSome(enableHybrid)(_.enableHybrid(_))
        .build

    def putResourcePolicyResponse(
      policyHash: Option[String] = None
    ): PutResourcePolicyResponse =
      PutResourcePolicyResponse
        .builder
        .ifSome(policyHash)(_.policyHash(_))
        .build

    def putSchemaVersionMetadataInput(
      schemaId: Option[SchemaId] = None,
      schemaVersionNumber: Option[SchemaVersionNumber] = None,
      schemaVersionId: Option[String] = None,
      metadataKeyValue: Option[MetadataKeyValuePair] = None
    ): PutSchemaVersionMetadataInput =
      PutSchemaVersionMetadataInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaVersionNumber)(_.schemaVersionNumber(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(metadataKeyValue)(_.metadataKeyValue(_))
        .build

    def putSchemaVersionMetadataResponse(
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      registryName: Option[String] = None,
      latestVersion: Option[Boolean] = None,
      versionNumber: Option[VersionLongNumber] = None,
      schemaVersionId: Option[String] = None,
      metadataKey: Option[String] = None,
      metadataValue: Option[String] = None
    ): PutSchemaVersionMetadataResponse =
      PutSchemaVersionMetadataResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(metadataKey)(_.metadataKey(_))
        .ifSome(metadataValue)(_.metadataValue(_))
        .build

    def putWorkflowRunPropertiesRequest(
      name: Option[String] = None,
      runId: Option[String] = None,
      runProperties: Option[WorkflowRunProperties] = None
    ): PutWorkflowRunPropertiesRequest =
      PutWorkflowRunPropertiesRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(runProperties)(_.runProperties(_))
        .build

    def putWorkflowRunPropertiesResponse(

    ): PutWorkflowRunPropertiesResponse =
      PutWorkflowRunPropertiesResponse
        .builder

        .build

    def querySchemaVersionMetadataInput(
      schemaId: Option[SchemaId] = None,
      schemaVersionNumber: Option[SchemaVersionNumber] = None,
      schemaVersionId: Option[String] = None,
      metadataList: Option[List[MetadataKeyValuePair]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): QuerySchemaVersionMetadataInput =
      QuerySchemaVersionMetadataInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaVersionNumber)(_.schemaVersionNumber(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(metadataList)(_.metadataList(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def querySchemaVersionMetadataResponse(
      metadataInfoMap: Option[MetadataInfoMap] = None,
      schemaVersionId: Option[String] = None,
      nextToken: Option[String] = None
    ): QuerySchemaVersionMetadataResponse =
      QuerySchemaVersionMetadataResponse
        .builder
        .ifSome(metadataInfoMap)(_.metadataInfoMap(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def recrawlPolicy(
      recrawlBehavior: Option[String] = None
    ): RecrawlPolicy =
      RecrawlPolicy
        .builder
        .ifSome(recrawlBehavior)(_.recrawlBehavior(_))
        .build

    def registerSchemaVersionInput(
      schemaId: Option[SchemaId] = None,
      schemaDefinition: Option[String] = None
    ): RegisterSchemaVersionInput =
      RegisterSchemaVersionInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaDefinition)(_.schemaDefinition(_))
        .build

    def registerSchemaVersionResponse(
      schemaVersionId: Option[String] = None,
      versionNumber: Option[VersionLongNumber] = None,
      status: Option[String] = None
    ): RegisterSchemaVersionResponse =
      RegisterSchemaVersionResponse
        .builder
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(status)(_.status(_))
        .build

    def registryId(
      registryName: Option[String] = None,
      registryArn: Option[String] = None
    ): RegistryId =
      RegistryId
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .build

    def registryListItem(
      registryName: Option[String] = None,
      registryArn: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[String] = None,
      updatedTime: Option[String] = None
    ): RegistryListItem =
      RegistryListItem
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .build

    def removeSchemaVersionMetadataInput(
      schemaId: Option[SchemaId] = None,
      schemaVersionNumber: Option[SchemaVersionNumber] = None,
      schemaVersionId: Option[String] = None,
      metadataKeyValue: Option[MetadataKeyValuePair] = None
    ): RemoveSchemaVersionMetadataInput =
      RemoveSchemaVersionMetadataInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaVersionNumber)(_.schemaVersionNumber(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(metadataKeyValue)(_.metadataKeyValue(_))
        .build

    def removeSchemaVersionMetadataResponse(
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      registryName: Option[String] = None,
      latestVersion: Option[Boolean] = None,
      versionNumber: Option[VersionLongNumber] = None,
      schemaVersionId: Option[String] = None,
      metadataKey: Option[String] = None,
      metadataValue: Option[String] = None
    ): RemoveSchemaVersionMetadataResponse =
      RemoveSchemaVersionMetadataResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(registryName)(_.registryName(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(metadataKey)(_.metadataKey(_))
        .ifSome(metadataValue)(_.metadataValue(_))
        .build

    def resetJobBookmarkRequest(
      jobName: Option[String] = None,
      runId: Option[String] = None
    ): ResetJobBookmarkRequest =
      ResetJobBookmarkRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(runId)(_.runId(_))
        .build

    def resetJobBookmarkResponse(
      jobBookmarkEntry: Option[JobBookmarkEntry] = None
    ): ResetJobBookmarkResponse =
      ResetJobBookmarkResponse
        .builder
        .ifSome(jobBookmarkEntry)(_.jobBookmarkEntry(_))
        .build

    def resourceNumberLimitExceededException(
      message: Option[String] = None
    ): ResourceNumberLimitExceededException =
      ResourceNumberLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceUri(
      resourceType: Option[String] = None,
      uri: Option[String] = None
    ): ResourceUri =
      ResourceUri
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(uri)(_.uri(_))
        .build

    def resumeWorkflowRunRequest(
      name: Option[String] = None,
      runId: Option[String] = None,
      nodeIds: Option[List[NameString]] = None
    ): ResumeWorkflowRunRequest =
      ResumeWorkflowRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(nodeIds)(_.nodeIds(_))
        .build

    def resumeWorkflowRunResponse(
      runId: Option[String] = None,
      nodeIds: Option[List[NameString]] = None
    ): ResumeWorkflowRunResponse =
      ResumeWorkflowRunResponse
        .builder
        .ifSome(runId)(_.runId(_))
        .ifSome(nodeIds)(_.nodeIds(_))
        .build

    def s3Encryption(
      s3EncryptionMode: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): S3Encryption =
      S3Encryption
        .builder
        .ifSome(s3EncryptionMode)(_.s3EncryptionMode(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def s3Target(
      path: Option[String] = None,
      exclusions: Option[List[Path]] = None,
      connectionName: Option[String] = None,
      sampleSize: Option[Int] = None
    ): S3Target =
      S3Target
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(exclusions)(_.exclusions(_))
        .ifSome(connectionName)(_.connectionName(_))
        .ifSome(sampleSize)(_.sampleSize(_))
        .build

    def schedule(
      scheduleExpression: Option[String] = None,
      state: Option[String] = None
    ): Schedule =
      Schedule
        .builder
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(state)(_.state(_))
        .build

    def schedulerNotRunningException(
      message: Option[String] = None
    ): SchedulerNotRunningException =
      SchedulerNotRunningException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def schedulerRunningException(
      message: Option[String] = None
    ): SchedulerRunningException =
      SchedulerRunningException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def schedulerTransitioningException(
      message: Option[String] = None
    ): SchedulerTransitioningException =
      SchedulerTransitioningException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def schemaChangePolicy(
      updateBehavior: Option[String] = None,
      deleteBehavior: Option[String] = None
    ): SchemaChangePolicy =
      SchemaChangePolicy
        .builder
        .ifSome(updateBehavior)(_.updateBehavior(_))
        .ifSome(deleteBehavior)(_.deleteBehavior(_))
        .build

    def schemaColumn(
      name: Option[String] = None,
      dataType: Option[String] = None
    ): SchemaColumn =
      SchemaColumn
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .build

    def schemaId(
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      registryName: Option[String] = None
    ): SchemaId =
      SchemaId
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(registryName)(_.registryName(_))
        .build

    def schemaListItem(
      registryName: Option[String] = None,
      schemaName: Option[String] = None,
      schemaArn: Option[String] = None,
      description: Option[String] = None,
      schemaStatus: Option[String] = None,
      createdTime: Option[String] = None,
      updatedTime: Option[String] = None
    ): SchemaListItem =
      SchemaListItem
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(schemaStatus)(_.schemaStatus(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .build

    def schemaReference(
      schemaId: Option[SchemaId] = None,
      schemaVersionId: Option[String] = None,
      schemaVersionNumber: Option[VersionLongNumber] = None
    ): SchemaReference =
      SchemaReference
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(schemaVersionNumber)(_.schemaVersionNumber(_))
        .build

    def schemaVersionErrorItem(
      versionNumber: Option[VersionLongNumber] = None,
      errorDetails: Option[ErrorDetails] = None
    ): SchemaVersionErrorItem =
      SchemaVersionErrorItem
        .builder
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def schemaVersionListItem(
      schemaArn: Option[String] = None,
      schemaVersionId: Option[String] = None,
      versionNumber: Option[VersionLongNumber] = None,
      status: Option[String] = None,
      createdTime: Option[String] = None
    ): SchemaVersionListItem =
      SchemaVersionListItem
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaVersionId)(_.schemaVersionId(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def schemaVersionNumber(
      latestVersion: Option[Boolean] = None,
      versionNumber: Option[VersionLongNumber] = None
    ): SchemaVersionNumber =
      SchemaVersionNumber
        .builder
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def searchTablesRequest(
      catalogId: Option[String] = None,
      nextToken: Option[String] = None,
      filters: Option[List[PropertyPredicate]] = None,
      searchText: Option[String] = None,
      sortCriteria: Option[List[SortCriterion]] = None,
      maxResults: Option[Int] = None,
      resourceShareType: Option[String] = None
    ): SearchTablesRequest =
      SearchTablesRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(searchText)(_.searchText(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resourceShareType)(_.resourceShareType(_))
        .build

    def searchTablesResponse(
      nextToken: Option[String] = None,
      tableList: Option[List[Table]] = None
    ): SearchTablesResponse =
      SearchTablesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tableList)(_.tableList(_))
        .build

    def securityConfiguration(
      name: Option[String] = None,
      createdTimeStamp: Option[TimestampValue] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None
    ): SecurityConfiguration =
      SecurityConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(createdTimeStamp)(_.createdTimeStamp(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .build

    def segment(
      segmentNumber: Option[Int] = None,
      totalSegments: Option[Int] = None
    ): Segment =
      Segment
        .builder
        .ifSome(segmentNumber)(_.segmentNumber(_))
        .ifSome(totalSegments)(_.totalSegments(_))
        .build

    def serDeInfo(
      name: Option[String] = None,
      serializationLibrary: Option[String] = None,
      parameters: Option[ParametersMap] = None
    ): SerDeInfo =
      SerDeInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(serializationLibrary)(_.serializationLibrary(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def skewedInfo(
      skewedColumnNames: Option[List[NameString]] = None,
      skewedColumnValues: Option[List[ColumnValuesString]] = None,
      skewedColumnValueLocationMaps: Option[LocationMap] = None
    ): SkewedInfo =
      SkewedInfo
        .builder
        .ifSome(skewedColumnNames)(_.skewedColumnNames(_))
        .ifSome(skewedColumnValues)(_.skewedColumnValues(_))
        .ifSome(skewedColumnValueLocationMaps)(_.skewedColumnValueLocationMaps(_))
        .build

    def sortCriterion(
      fieldName: Option[String] = None,
      sort: Option[String] = None
    ): SortCriterion =
      SortCriterion
        .builder
        .ifSome(fieldName)(_.fieldName(_))
        .ifSome(sort)(_.sort(_))
        .build

    def startCrawlerRequest(
      name: Option[String] = None
    ): StartCrawlerRequest =
      StartCrawlerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startCrawlerResponse(

    ): StartCrawlerResponse =
      StartCrawlerResponse
        .builder

        .build

    def startCrawlerScheduleRequest(
      crawlerName: Option[String] = None
    ): StartCrawlerScheduleRequest =
      StartCrawlerScheduleRequest
        .builder
        .ifSome(crawlerName)(_.crawlerName(_))
        .build

    def startCrawlerScheduleResponse(

    ): StartCrawlerScheduleResponse =
      StartCrawlerScheduleResponse
        .builder

        .build

    def startExportLabelsTaskRunRequest(
      transformId: Option[String] = None,
      outputS3Path: Option[String] = None
    ): StartExportLabelsTaskRunRequest =
      StartExportLabelsTaskRunRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(outputS3Path)(_.outputS3Path(_))
        .build

    def startExportLabelsTaskRunResponse(
      taskRunId: Option[String] = None
    ): StartExportLabelsTaskRunResponse =
      StartExportLabelsTaskRunResponse
        .builder
        .ifSome(taskRunId)(_.taskRunId(_))
        .build

    def startImportLabelsTaskRunRequest(
      transformId: Option[String] = None,
      inputS3Path: Option[String] = None,
      replaceAllLabels: Option[Boolean] = None
    ): StartImportLabelsTaskRunRequest =
      StartImportLabelsTaskRunRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(inputS3Path)(_.inputS3Path(_))
        .ifSome(replaceAllLabels)(_.replaceAllLabels(_))
        .build

    def startImportLabelsTaskRunResponse(
      taskRunId: Option[String] = None
    ): StartImportLabelsTaskRunResponse =
      StartImportLabelsTaskRunResponse
        .builder
        .ifSome(taskRunId)(_.taskRunId(_))
        .build

    def startJobRunRequest(
      jobName: Option[String] = None,
      jobRunId: Option[String] = None,
      arguments: Option[GenericMap] = None,
      allocatedCapacity: Option[Int] = None,
      timeout: Option[Int] = None,
      maxCapacity: Option[NullableDouble] = None,
      securityConfiguration: Option[String] = None,
      notificationProperty: Option[NotificationProperty] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None
    ): StartJobRunRequest =
      StartJobRunRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobRunId)(_.jobRunId(_))
        .ifSome(arguments)(_.arguments(_))
        .ifSome(allocatedCapacity)(_.allocatedCapacity(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(securityConfiguration)(_.securityConfiguration(_))
        .ifSome(notificationProperty)(_.notificationProperty(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .build

    def startJobRunResponse(
      jobRunId: Option[String] = None
    ): StartJobRunResponse =
      StartJobRunResponse
        .builder
        .ifSome(jobRunId)(_.jobRunId(_))
        .build

    def startMLEvaluationTaskRunRequest(
      transformId: Option[String] = None
    ): StartMLEvaluationTaskRunRequest =
      StartMLEvaluationTaskRunRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .build

    def startMLEvaluationTaskRunResponse(
      taskRunId: Option[String] = None
    ): StartMLEvaluationTaskRunResponse =
      StartMLEvaluationTaskRunResponse
        .builder
        .ifSome(taskRunId)(_.taskRunId(_))
        .build

    def startMLLabelingSetGenerationTaskRunRequest(
      transformId: Option[String] = None,
      outputS3Path: Option[String] = None
    ): StartMLLabelingSetGenerationTaskRunRequest =
      StartMLLabelingSetGenerationTaskRunRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(outputS3Path)(_.outputS3Path(_))
        .build

    def startMLLabelingSetGenerationTaskRunResponse(
      taskRunId: Option[String] = None
    ): StartMLLabelingSetGenerationTaskRunResponse =
      StartMLLabelingSetGenerationTaskRunResponse
        .builder
        .ifSome(taskRunId)(_.taskRunId(_))
        .build

    def startTriggerRequest(
      name: Option[String] = None
    ): StartTriggerRequest =
      StartTriggerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startTriggerResponse(
      name: Option[String] = None
    ): StartTriggerResponse =
      StartTriggerResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startWorkflowRunRequest(
      name: Option[String] = None
    ): StartWorkflowRunRequest =
      StartWorkflowRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startWorkflowRunResponse(
      runId: Option[String] = None
    ): StartWorkflowRunResponse =
      StartWorkflowRunResponse
        .builder
        .ifSome(runId)(_.runId(_))
        .build

    def stopCrawlerRequest(
      name: Option[String] = None
    ): StopCrawlerRequest =
      StopCrawlerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopCrawlerResponse(

    ): StopCrawlerResponse =
      StopCrawlerResponse
        .builder

        .build

    def stopCrawlerScheduleRequest(
      crawlerName: Option[String] = None
    ): StopCrawlerScheduleRequest =
      StopCrawlerScheduleRequest
        .builder
        .ifSome(crawlerName)(_.crawlerName(_))
        .build

    def stopCrawlerScheduleResponse(

    ): StopCrawlerScheduleResponse =
      StopCrawlerScheduleResponse
        .builder

        .build

    def stopTriggerRequest(
      name: Option[String] = None
    ): StopTriggerRequest =
      StopTriggerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopTriggerResponse(
      name: Option[String] = None
    ): StopTriggerResponse =
      StopTriggerResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopWorkflowRunRequest(
      name: Option[String] = None,
      runId: Option[String] = None
    ): StopWorkflowRunRequest =
      StopWorkflowRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .build

    def stopWorkflowRunResponse(

    ): StopWorkflowRunResponse =
      StopWorkflowRunResponse
        .builder

        .build

    def storageDescriptor(
      columns: Option[List[Column]] = None,
      location: Option[String] = None,
      inputFormat: Option[String] = None,
      outputFormat: Option[String] = None,
      compressed: Option[Boolean] = None,
      numberOfBuckets: Option[Int] = None,
      serdeInfo: Option[SerDeInfo] = None,
      bucketColumns: Option[List[NameString]] = None,
      sortColumns: Option[List[Order]] = None,
      parameters: Option[ParametersMap] = None,
      skewedInfo: Option[SkewedInfo] = None,
      storedAsSubDirectories: Option[Boolean] = None,
      schemaReference: Option[SchemaReference] = None
    ): StorageDescriptor =
      StorageDescriptor
        .builder
        .ifSome(columns)(_.columns(_))
        .ifSome(location)(_.location(_))
        .ifSome(inputFormat)(_.inputFormat(_))
        .ifSome(outputFormat)(_.outputFormat(_))
        .ifSome(compressed)(_.compressed(_))
        .ifSome(numberOfBuckets)(_.numberOfBuckets(_))
        .ifSome(serdeInfo)(_.serdeInfo(_))
        .ifSome(bucketColumns)(_.bucketColumns(_))
        .ifSome(sortColumns)(_.sortColumns(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(skewedInfo)(_.skewedInfo(_))
        .ifSome(storedAsSubDirectories)(_.storedAsSubDirectories(_))
        .ifSome(schemaReference)(_.schemaReference(_))
        .build

    def stringColumnStatisticsData(
      maximumLength: Option[NonNegativeLong] = None,
      averageLength: Option[NonNegativeDouble] = None,
      numberOfNulls: Option[NonNegativeLong] = None,
      numberOfDistinctValues: Option[NonNegativeLong] = None
    ): StringColumnStatisticsData =
      StringColumnStatisticsData
        .builder
        .ifSome(maximumLength)(_.maximumLength(_))
        .ifSome(averageLength)(_.averageLength(_))
        .ifSome(numberOfNulls)(_.numberOfNulls(_))
        .ifSome(numberOfDistinctValues)(_.numberOfDistinctValues(_))
        .build

    def table(
      name: Option[String] = None,
      databaseName: Option[String] = None,
      description: Option[String] = None,
      owner: Option[String] = None,
      createTime: Option[Timestamp] = None,
      updateTime: Option[Timestamp] = None,
      lastAccessTime: Option[Timestamp] = None,
      lastAnalyzedTime: Option[Timestamp] = None,
      retention: Option[Int] = None,
      storageDescriptor: Option[StorageDescriptor] = None,
      partitionKeys: Option[List[Column]] = None,
      viewOriginalText: Option[String] = None,
      viewExpandedText: Option[String] = None,
      tableType: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      createdBy: Option[String] = None,
      isRegisteredWithLakeFormation: Option[Boolean] = None,
      targetTable: Option[TableIdentifier] = None,
      catalogId: Option[String] = None
    ): Table =
      Table
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(description)(_.description(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .ifSome(lastAccessTime)(_.lastAccessTime(_))
        .ifSome(lastAnalyzedTime)(_.lastAnalyzedTime(_))
        .ifSome(retention)(_.retention(_))
        .ifSome(storageDescriptor)(_.storageDescriptor(_))
        .ifSome(partitionKeys)(_.partitionKeys(_))
        .ifSome(viewOriginalText)(_.viewOriginalText(_))
        .ifSome(viewExpandedText)(_.viewExpandedText(_))
        .ifSome(tableType)(_.tableType(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(isRegisteredWithLakeFormation)(_.isRegisteredWithLakeFormation(_))
        .ifSome(targetTable)(_.targetTable(_))
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def tableError(
      tableName: Option[String] = None,
      errorDetail: Option[ErrorDetail] = None
    ): TableError =
      TableError
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .build

    def tableIdentifier(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      name: Option[String] = None
    ): TableIdentifier =
      TableIdentifier
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(name)(_.name(_))
        .build

    def tableInput(
      name: Option[String] = None,
      description: Option[String] = None,
      owner: Option[String] = None,
      lastAccessTime: Option[Timestamp] = None,
      lastAnalyzedTime: Option[Timestamp] = None,
      retention: Option[Int] = None,
      storageDescriptor: Option[StorageDescriptor] = None,
      partitionKeys: Option[List[Column]] = None,
      viewOriginalText: Option[String] = None,
      viewExpandedText: Option[String] = None,
      tableType: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      targetTable: Option[TableIdentifier] = None
    ): TableInput =
      TableInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(lastAccessTime)(_.lastAccessTime(_))
        .ifSome(lastAnalyzedTime)(_.lastAnalyzedTime(_))
        .ifSome(retention)(_.retention(_))
        .ifSome(storageDescriptor)(_.storageDescriptor(_))
        .ifSome(partitionKeys)(_.partitionKeys(_))
        .ifSome(viewOriginalText)(_.viewOriginalText(_))
        .ifSome(viewExpandedText)(_.viewExpandedText(_))
        .ifSome(tableType)(_.tableType(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(targetTable)(_.targetTable(_))
        .build

    def tableVersion(
      table: Option[Table] = None,
      versionId: Option[String] = None
    ): TableVersion =
      TableVersion
        .builder
        .ifSome(table)(_.table(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def tableVersionError(
      tableName: Option[String] = None,
      versionId: Option[String] = None,
      errorDetail: Option[ErrorDetail] = None
    ): TableVersionError =
      TableVersionError
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(errorDetail)(_.errorDetail(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tagsToAdd: Option[TagsMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagsToAdd)(_.tagsToAdd(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def taskRun(
      transformId: Option[String] = None,
      taskRunId: Option[String] = None,
      status: Option[String] = None,
      logGroupName: Option[String] = None,
      properties: Option[TaskRunProperties] = None,
      errorString: Option[String] = None,
      startedOn: Option[Timestamp] = None,
      lastModifiedOn: Option[Timestamp] = None,
      completedOn: Option[Timestamp] = None,
      executionTime: Option[Int] = None
    ): TaskRun =
      TaskRun
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(taskRunId)(_.taskRunId(_))
        .ifSome(status)(_.status(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(errorString)(_.errorString(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(executionTime)(_.executionTime(_))
        .build

    def taskRunFilterCriteria(
      taskRunType: Option[String] = None,
      status: Option[String] = None,
      startedBefore: Option[Timestamp] = None,
      startedAfter: Option[Timestamp] = None
    ): TaskRunFilterCriteria =
      TaskRunFilterCriteria
        .builder
        .ifSome(taskRunType)(_.taskRunType(_))
        .ifSome(status)(_.status(_))
        .ifSome(startedBefore)(_.startedBefore(_))
        .ifSome(startedAfter)(_.startedAfter(_))
        .build

    def taskRunProperties(
      taskType: Option[String] = None,
      importLabelsTaskRunProperties: Option[ImportLabelsTaskRunProperties] = None,
      exportLabelsTaskRunProperties: Option[ExportLabelsTaskRunProperties] = None,
      labelingSetGenerationTaskRunProperties: Option[LabelingSetGenerationTaskRunProperties] = None,
      findMatchesTaskRunProperties: Option[FindMatchesTaskRunProperties] = None
    ): TaskRunProperties =
      TaskRunProperties
        .builder
        .ifSome(taskType)(_.taskType(_))
        .ifSome(importLabelsTaskRunProperties)(_.importLabelsTaskRunProperties(_))
        .ifSome(exportLabelsTaskRunProperties)(_.exportLabelsTaskRunProperties(_))
        .ifSome(labelingSetGenerationTaskRunProperties)(_.labelingSetGenerationTaskRunProperties(_))
        .ifSome(findMatchesTaskRunProperties)(_.findMatchesTaskRunProperties(_))
        .build

    def taskRunSortCriteria(
      column: Option[String] = None,
      sortDirection: Option[String] = None
    ): TaskRunSortCriteria =
      TaskRunSortCriteria
        .builder
        .ifSome(column)(_.column(_))
        .ifSome(sortDirection)(_.sortDirection(_))
        .build

    def transformEncryption(
      mlUserDataEncryption: Option[MLUserDataEncryption] = None,
      taskRunSecurityConfigurationName: Option[String] = None
    ): TransformEncryption =
      TransformEncryption
        .builder
        .ifSome(mlUserDataEncryption)(_.mlUserDataEncryption(_))
        .ifSome(taskRunSecurityConfigurationName)(_.taskRunSecurityConfigurationName(_))
        .build

    def transformFilterCriteria(
      name: Option[String] = None,
      transformType: Option[String] = None,
      status: Option[String] = None,
      glueVersion: Option[String] = None,
      createdBefore: Option[Timestamp] = None,
      createdAfter: Option[Timestamp] = None,
      lastModifiedBefore: Option[Timestamp] = None,
      lastModifiedAfter: Option[Timestamp] = None,
      schema: Option[List[SchemaColumn]] = None
    ): TransformFilterCriteria =
      TransformFilterCriteria
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(transformType)(_.transformType(_))
        .ifSome(status)(_.status(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(createdBefore)(_.createdBefore(_))
        .ifSome(createdAfter)(_.createdAfter(_))
        .ifSome(lastModifiedBefore)(_.lastModifiedBefore(_))
        .ifSome(lastModifiedAfter)(_.lastModifiedAfter(_))
        .ifSome(schema)(_.schema(_))
        .build

    def transformParameters(
      transformType: Option[String] = None,
      findMatchesParameters: Option[FindMatchesParameters] = None
    ): TransformParameters =
      TransformParameters
        .builder
        .ifSome(transformType)(_.transformType(_))
        .ifSome(findMatchesParameters)(_.findMatchesParameters(_))
        .build

    def transformSortCriteria(
      column: Option[String] = None,
      sortDirection: Option[String] = None
    ): TransformSortCriteria =
      TransformSortCriteria
        .builder
        .ifSome(column)(_.column(_))
        .ifSome(sortDirection)(_.sortDirection(_))
        .build

    def trigger(
      name: Option[String] = None,
      workflowName: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      description: Option[String] = None,
      schedule: Option[String] = None,
      actions: Option[List[Action]] = None,
      predicate: Option[Predicate] = None
    ): Trigger =
      Trigger
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(workflowName)(_.workflowName(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(predicate)(_.predicate(_))
        .build

    def triggerNodeDetails(
      trigger: Option[Trigger] = None
    ): TriggerNodeDetails =
      TriggerNodeDetails
        .builder
        .ifSome(trigger)(_.trigger(_))
        .build

    def triggerUpdate(
      name: Option[String] = None,
      description: Option[String] = None,
      schedule: Option[String] = None,
      actions: Option[List[Action]] = None,
      predicate: Option[Predicate] = None
    ): TriggerUpdate =
      TriggerUpdate
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(predicate)(_.predicate(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagsToRemove: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagsToRemove)(_.tagsToRemove(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateClassifierRequest(
      grokClassifier: Option[UpdateGrokClassifierRequest] = None,
      xMLClassifier: Option[UpdateXMLClassifierRequest] = None,
      jsonClassifier: Option[UpdateJsonClassifierRequest] = None,
      csvClassifier: Option[UpdateCsvClassifierRequest] = None
    ): UpdateClassifierRequest =
      UpdateClassifierRequest
        .builder
        .ifSome(grokClassifier)(_.grokClassifier(_))
        .ifSome(xMLClassifier)(_.xMLClassifier(_))
        .ifSome(jsonClassifier)(_.jsonClassifier(_))
        .ifSome(csvClassifier)(_.csvClassifier(_))
        .build

    def updateClassifierResponse(

    ): UpdateClassifierResponse =
      UpdateClassifierResponse
        .builder

        .build

    def updateColumnStatisticsForPartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionValues: Option[List[ValueString]] = None,
      columnStatisticsList: Option[List[ColumnStatistics]] = None
    ): UpdateColumnStatisticsForPartitionRequest =
      UpdateColumnStatisticsForPartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionValues)(_.partitionValues(_))
        .ifSome(columnStatisticsList)(_.columnStatisticsList(_))
        .build

    def updateColumnStatisticsForPartitionResponse(
      errors: Option[List[ColumnStatisticsError]] = None
    ): UpdateColumnStatisticsForPartitionResponse =
      UpdateColumnStatisticsForPartitionResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def updateColumnStatisticsForTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      columnStatisticsList: Option[List[ColumnStatistics]] = None
    ): UpdateColumnStatisticsForTableRequest =
      UpdateColumnStatisticsForTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(columnStatisticsList)(_.columnStatisticsList(_))
        .build

    def updateColumnStatisticsForTableResponse(
      errors: Option[List[ColumnStatisticsError]] = None
    ): UpdateColumnStatisticsForTableResponse =
      UpdateColumnStatisticsForTableResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def updateConnectionRequest(
      catalogId: Option[String] = None,
      name: Option[String] = None,
      connectionInput: Option[ConnectionInput] = None
    ): UpdateConnectionRequest =
      UpdateConnectionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(name)(_.name(_))
        .ifSome(connectionInput)(_.connectionInput(_))
        .build

    def updateConnectionResponse(

    ): UpdateConnectionResponse =
      UpdateConnectionResponse
        .builder

        .build

    def updateCrawlerRequest(
      name: Option[String] = None,
      role: Option[String] = None,
      databaseName: Option[String] = None,
      description: Option[String] = None,
      targets: Option[CrawlerTargets] = None,
      schedule: Option[String] = None,
      classifiers: Option[List[NameString]] = None,
      tablePrefix: Option[String] = None,
      schemaChangePolicy: Option[SchemaChangePolicy] = None,
      recrawlPolicy: Option[RecrawlPolicy] = None,
      lineageConfiguration: Option[LineageConfiguration] = None,
      configuration: Option[String] = None,
      crawlerSecurityConfiguration: Option[String] = None
    ): UpdateCrawlerRequest =
      UpdateCrawlerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(role)(_.role(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(classifiers)(_.classifiers(_))
        .ifSome(tablePrefix)(_.tablePrefix(_))
        .ifSome(schemaChangePolicy)(_.schemaChangePolicy(_))
        .ifSome(recrawlPolicy)(_.recrawlPolicy(_))
        .ifSome(lineageConfiguration)(_.lineageConfiguration(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(crawlerSecurityConfiguration)(_.crawlerSecurityConfiguration(_))
        .build

    def updateCrawlerResponse(

    ): UpdateCrawlerResponse =
      UpdateCrawlerResponse
        .builder

        .build

    def updateCrawlerScheduleRequest(
      crawlerName: Option[String] = None,
      schedule: Option[String] = None
    ): UpdateCrawlerScheduleRequest =
      UpdateCrawlerScheduleRequest
        .builder
        .ifSome(crawlerName)(_.crawlerName(_))
        .ifSome(schedule)(_.schedule(_))
        .build

    def updateCrawlerScheduleResponse(

    ): UpdateCrawlerScheduleResponse =
      UpdateCrawlerScheduleResponse
        .builder

        .build

    def updateCsvClassifierRequest(
      name: Option[String] = None,
      delimiter: Option[String] = None,
      quoteSymbol: Option[String] = None,
      containsHeader: Option[String] = None,
      header: Option[List[NameString]] = None,
      disableValueTrimming: Option[Boolean] = None,
      allowSingleColumn: Option[Boolean] = None
    ): UpdateCsvClassifierRequest =
      UpdateCsvClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(quoteSymbol)(_.quoteSymbol(_))
        .ifSome(containsHeader)(_.containsHeader(_))
        .ifSome(header)(_.header(_))
        .ifSome(disableValueTrimming)(_.disableValueTrimming(_))
        .ifSome(allowSingleColumn)(_.allowSingleColumn(_))
        .build

    def updateDatabaseRequest(
      catalogId: Option[String] = None,
      name: Option[String] = None,
      databaseInput: Option[DatabaseInput] = None
    ): UpdateDatabaseRequest =
      UpdateDatabaseRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(name)(_.name(_))
        .ifSome(databaseInput)(_.databaseInput(_))
        .build

    def updateDatabaseResponse(

    ): UpdateDatabaseResponse =
      UpdateDatabaseResponse
        .builder

        .build

    def updateDevEndpointRequest(
      endpointName: Option[String] = None,
      publicKey: Option[String] = None,
      addPublicKeys: Option[List[GenericString]] = None,
      deletePublicKeys: Option[List[GenericString]] = None,
      customLibraries: Option[DevEndpointCustomLibraries] = None,
      updateEtlLibraries: Option[Boolean] = None,
      deleteArguments: Option[List[GenericString]] = None,
      addArguments: Option[MapValue] = None
    ): UpdateDevEndpointRequest =
      UpdateDevEndpointRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(addPublicKeys)(_.addPublicKeys(_))
        .ifSome(deletePublicKeys)(_.deletePublicKeys(_))
        .ifSome(customLibraries)(_.customLibraries(_))
        .ifSome(updateEtlLibraries)(_.updateEtlLibraries(_))
        .ifSome(deleteArguments)(_.deleteArguments(_))
        .ifSome(addArguments)(_.addArguments(_))
        .build

    def updateDevEndpointResponse(

    ): UpdateDevEndpointResponse =
      UpdateDevEndpointResponse
        .builder

        .build

    def updateGrokClassifierRequest(
      name: Option[String] = None,
      classification: Option[String] = None,
      grokPattern: Option[String] = None,
      customPatterns: Option[String] = None
    ): UpdateGrokClassifierRequest =
      UpdateGrokClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(classification)(_.classification(_))
        .ifSome(grokPattern)(_.grokPattern(_))
        .ifSome(customPatterns)(_.customPatterns(_))
        .build

    def updateJobRequest(
      jobName: Option[String] = None,
      jobUpdate: Option[JobUpdate] = None
    ): UpdateJobRequest =
      UpdateJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobUpdate)(_.jobUpdate(_))
        .build

    def updateJobResponse(
      jobName: Option[String] = None
    ): UpdateJobResponse =
      UpdateJobResponse
        .builder
        .ifSome(jobName)(_.jobName(_))
        .build

    def updateJsonClassifierRequest(
      name: Option[String] = None,
      jsonPath: Option[String] = None
    ): UpdateJsonClassifierRequest =
      UpdateJsonClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(jsonPath)(_.jsonPath(_))
        .build

    def updateMLTransformRequest(
      transformId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[TransformParameters] = None,
      role: Option[String] = None,
      glueVersion: Option[String] = None,
      maxCapacity: Option[NullableDouble] = None,
      workerType: Option[String] = None,
      numberOfWorkers: Option[Int] = None,
      timeout: Option[Int] = None,
      maxRetries: Option[Int] = None
    ): UpdateMLTransformRequest =
      UpdateMLTransformRequest
        .builder
        .ifSome(transformId)(_.transformId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(role)(_.role(_))
        .ifSome(glueVersion)(_.glueVersion(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(workerType)(_.workerType(_))
        .ifSome(numberOfWorkers)(_.numberOfWorkers(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .build

    def updateMLTransformResponse(
      transformId: Option[String] = None
    ): UpdateMLTransformResponse =
      UpdateMLTransformResponse
        .builder
        .ifSome(transformId)(_.transformId(_))
        .build

    def updatePartitionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      partitionValueList: Option[List[ValueString]] = None,
      partitionInput: Option[PartitionInput] = None
    ): UpdatePartitionRequest =
      UpdatePartitionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(partitionValueList)(_.partitionValueList(_))
        .ifSome(partitionInput)(_.partitionInput(_))
        .build

    def updatePartitionResponse(

    ): UpdatePartitionResponse =
      UpdatePartitionResponse
        .builder

        .build

    def updateRegistryInput(
      registryId: Option[RegistryId] = None,
      description: Option[String] = None
    ): UpdateRegistryInput =
      UpdateRegistryInput
        .builder
        .ifSome(registryId)(_.registryId(_))
        .ifSome(description)(_.description(_))
        .build

    def updateRegistryResponse(
      registryName: Option[String] = None,
      registryArn: Option[String] = None
    ): UpdateRegistryResponse =
      UpdateRegistryResponse
        .builder
        .ifSome(registryName)(_.registryName(_))
        .ifSome(registryArn)(_.registryArn(_))
        .build

    def updateSchemaInput(
      schemaId: Option[SchemaId] = None,
      schemaVersionNumber: Option[SchemaVersionNumber] = None,
      compatibility: Option[String] = None,
      description: Option[String] = None
    ): UpdateSchemaInput =
      UpdateSchemaInput
        .builder
        .ifSome(schemaId)(_.schemaId(_))
        .ifSome(schemaVersionNumber)(_.schemaVersionNumber(_))
        .ifSome(compatibility)(_.compatibility(_))
        .ifSome(description)(_.description(_))
        .build

    def updateSchemaResponse(
      schemaArn: Option[String] = None,
      schemaName: Option[String] = None,
      registryName: Option[String] = None
    ): UpdateSchemaResponse =
      UpdateSchemaResponse
        .builder
        .ifSome(schemaArn)(_.schemaArn(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(registryName)(_.registryName(_))
        .build

    def updateTableRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableInput: Option[TableInput] = None,
      skipArchive: Option[Boolean] = None
    ): UpdateTableRequest =
      UpdateTableRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableInput)(_.tableInput(_))
        .ifSome(skipArchive)(_.skipArchive(_))
        .build

    def updateTableResponse(

    ): UpdateTableResponse =
      UpdateTableResponse
        .builder

        .build

    def updateTriggerRequest(
      name: Option[String] = None,
      triggerUpdate: Option[TriggerUpdate] = None
    ): UpdateTriggerRequest =
      UpdateTriggerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(triggerUpdate)(_.triggerUpdate(_))
        .build

    def updateTriggerResponse(
      trigger: Option[Trigger] = None
    ): UpdateTriggerResponse =
      UpdateTriggerResponse
        .builder
        .ifSome(trigger)(_.trigger(_))
        .build

    def updateUserDefinedFunctionRequest(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      functionName: Option[String] = None,
      functionInput: Option[UserDefinedFunctionInput] = None
    ): UpdateUserDefinedFunctionRequest =
      UpdateUserDefinedFunctionRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(functionName)(_.functionName(_))
        .ifSome(functionInput)(_.functionInput(_))
        .build

    def updateUserDefinedFunctionResponse(

    ): UpdateUserDefinedFunctionResponse =
      UpdateUserDefinedFunctionResponse
        .builder

        .build

    def updateWorkflowRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      defaultRunProperties: Option[WorkflowRunProperties] = None,
      maxConcurrentRuns: Option[Int] = None
    ): UpdateWorkflowRequest =
      UpdateWorkflowRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultRunProperties)(_.defaultRunProperties(_))
        .ifSome(maxConcurrentRuns)(_.maxConcurrentRuns(_))
        .build

    def updateWorkflowResponse(
      name: Option[String] = None
    ): UpdateWorkflowResponse =
      UpdateWorkflowResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateXMLClassifierRequest(
      name: Option[String] = None,
      classification: Option[String] = None,
      rowTag: Option[String] = None
    ): UpdateXMLClassifierRequest =
      UpdateXMLClassifierRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(classification)(_.classification(_))
        .ifSome(rowTag)(_.rowTag(_))
        .build

    def userDefinedFunction(
      functionName: Option[String] = None,
      databaseName: Option[String] = None,
      className: Option[String] = None,
      ownerName: Option[String] = None,
      ownerType: Option[String] = None,
      createTime: Option[Timestamp] = None,
      resourceUris: Option[List[ResourceUri]] = None,
      catalogId: Option[String] = None
    ): UserDefinedFunction =
      UserDefinedFunction
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(className)(_.className(_))
        .ifSome(ownerName)(_.ownerName(_))
        .ifSome(ownerType)(_.ownerType(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(resourceUris)(_.resourceUris(_))
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def userDefinedFunctionInput(
      functionName: Option[String] = None,
      className: Option[String] = None,
      ownerName: Option[String] = None,
      ownerType: Option[String] = None,
      resourceUris: Option[List[ResourceUri]] = None
    ): UserDefinedFunctionInput =
      UserDefinedFunctionInput
        .builder
        .ifSome(functionName)(_.functionName(_))
        .ifSome(className)(_.className(_))
        .ifSome(ownerName)(_.ownerName(_))
        .ifSome(ownerType)(_.ownerType(_))
        .ifSome(resourceUris)(_.resourceUris(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def versionMismatchException(
      message: Option[String] = None
    ): VersionMismatchException =
      VersionMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def workflow(
      name: Option[String] = None,
      description: Option[String] = None,
      defaultRunProperties: Option[WorkflowRunProperties] = None,
      createdOn: Option[TimestampValue] = None,
      lastModifiedOn: Option[TimestampValue] = None,
      lastRun: Option[WorkflowRun] = None,
      graph: Option[WorkflowGraph] = None,
      maxConcurrentRuns: Option[Int] = None
    ): Workflow =
      Workflow
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(defaultRunProperties)(_.defaultRunProperties(_))
        .ifSome(createdOn)(_.createdOn(_))
        .ifSome(lastModifiedOn)(_.lastModifiedOn(_))
        .ifSome(lastRun)(_.lastRun(_))
        .ifSome(graph)(_.graph(_))
        .ifSome(maxConcurrentRuns)(_.maxConcurrentRuns(_))
        .build

    def workflowGraph(
      nodes: Option[List[Node]] = None,
      edges: Option[List[Edge]] = None
    ): WorkflowGraph =
      WorkflowGraph
        .builder
        .ifSome(nodes)(_.nodes(_))
        .ifSome(edges)(_.edges(_))
        .build

    def workflowRun(
      name: Option[String] = None,
      workflowRunId: Option[String] = None,
      previousRunId: Option[String] = None,
      workflowRunProperties: Option[WorkflowRunProperties] = None,
      startedOn: Option[TimestampValue] = None,
      completedOn: Option[TimestampValue] = None,
      status: Option[String] = None,
      errorMessage: Option[String] = None,
      statistics: Option[WorkflowRunStatistics] = None,
      graph: Option[WorkflowGraph] = None
    ): WorkflowRun =
      WorkflowRun
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(workflowRunId)(_.workflowRunId(_))
        .ifSome(previousRunId)(_.previousRunId(_))
        .ifSome(workflowRunProperties)(_.workflowRunProperties(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(statistics)(_.statistics(_))
        .ifSome(graph)(_.graph(_))
        .build

    def workflowRunStatistics(
      totalActions: Option[Int] = None,
      timeoutActions: Option[Int] = None,
      failedActions: Option[Int] = None,
      stoppedActions: Option[Int] = None,
      succeededActions: Option[Int] = None,
      runningActions: Option[Int] = None
    ): WorkflowRunStatistics =
      WorkflowRunStatistics
        .builder
        .ifSome(totalActions)(_.totalActions(_))
        .ifSome(timeoutActions)(_.timeoutActions(_))
        .ifSome(failedActions)(_.failedActions(_))
        .ifSome(stoppedActions)(_.stoppedActions(_))
        .ifSome(succeededActions)(_.succeededActions(_))
        .ifSome(runningActions)(_.runningActions(_))
        .build

    def xMLClassifier(
      name: Option[String] = None,
      classification: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdated: Option[Timestamp] = None,
      version: Option[VersionId] = None,
      rowTag: Option[String] = None
    ): XMLClassifier =
      XMLClassifier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(classification)(_.classification(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(version)(_.version(_))
        .ifSome(rowTag)(_.rowTag(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
