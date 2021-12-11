package goober.hi

import goober.free.athena.AthenaIO
import software.amazon.awssdk.services.athena.model._


object athena {
  import goober.free.{athena ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def batchGetNamedQueryInput(
      namedQueryIds: Option[List[NamedQueryId]] = None
    ): BatchGetNamedQueryInput =
      BatchGetNamedQueryInput
        .builder
        .ifSome(namedQueryIds)(_.namedQueryIds(_))
        .build

    def batchGetNamedQueryOutput(
      namedQueries: Option[List[NamedQuery]] = None,
      unprocessedNamedQueryIds: Option[List[UnprocessedNamedQueryId]] = None
    ): BatchGetNamedQueryOutput =
      BatchGetNamedQueryOutput
        .builder
        .ifSome(namedQueries)(_.namedQueries(_))
        .ifSome(unprocessedNamedQueryIds)(_.unprocessedNamedQueryIds(_))
        .build

    def batchGetQueryExecutionInput(
      queryExecutionIds: Option[List[QueryExecutionId]] = None
    ): BatchGetQueryExecutionInput =
      BatchGetQueryExecutionInput
        .builder
        .ifSome(queryExecutionIds)(_.queryExecutionIds(_))
        .build

    def batchGetQueryExecutionOutput(
      queryExecutions: Option[List[QueryExecution]] = None,
      unprocessedQueryExecutionIds: Option[List[UnprocessedQueryExecutionId]] = None
    ): BatchGetQueryExecutionOutput =
      BatchGetQueryExecutionOutput
        .builder
        .ifSome(queryExecutions)(_.queryExecutions(_))
        .ifSome(unprocessedQueryExecutionIds)(_.unprocessedQueryExecutionIds(_))
        .build

    def column(
      name: Option[String] = None,
      `type`: Option[String] = None,
      comment: Option[String] = None
    ): Column =
      Column
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(comment)(_.comment(_))
        .build

    def columnInfo(
      catalogName: Option[String] = None,
      schemaName: Option[String] = None,
      tableName: Option[String] = None,
      name: Option[String] = None,
      label: Option[String] = None,
      `type`: Option[String] = None,
      precision: Option[Int] = None,
      scale: Option[Int] = None,
      nullable: Option[String] = None,
      caseSensitive: Option[Boolean] = None
    ): ColumnInfo =
      ColumnInfo
        .builder
        .ifSome(catalogName)(_.catalogName(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(name)(_.name(_))
        .ifSome(label)(_.label(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(precision)(_.precision(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(nullable)(_.nullable(_))
        .ifSome(caseSensitive)(_.caseSensitive(_))
        .build

    def createDataCatalogInput(
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ParametersMap] = None,
      tags: Option[List[Tag]] = None
    ): CreateDataCatalogInput =
      CreateDataCatalogInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataCatalogOutput(

    ): CreateDataCatalogOutput =
      CreateDataCatalogOutput
        .builder

        .build

    def createNamedQueryInput(
      name: Option[String] = None,
      description: Option[String] = None,
      database: Option[String] = None,
      queryString: Option[String] = None,
      clientRequestToken: Option[String] = None,
      workGroup: Option[String] = None
    ): CreateNamedQueryInput =
      CreateNamedQueryInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(database)(_.database(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def createNamedQueryOutput(
      namedQueryId: Option[String] = None
    ): CreateNamedQueryOutput =
      CreateNamedQueryOutput
        .builder
        .ifSome(namedQueryId)(_.namedQueryId(_))
        .build

    def createPreparedStatementInput(
      statementName: Option[String] = None,
      workGroup: Option[String] = None,
      queryStatement: Option[String] = None,
      description: Option[String] = None
    ): CreatePreparedStatementInput =
      CreatePreparedStatementInput
        .builder
        .ifSome(statementName)(_.statementName(_))
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(queryStatement)(_.queryStatement(_))
        .ifSome(description)(_.description(_))
        .build

    def createPreparedStatementOutput(

    ): CreatePreparedStatementOutput =
      CreatePreparedStatementOutput
        .builder

        .build

    def createWorkGroupInput(
      name: Option[String] = None,
      configuration: Option[WorkGroupConfiguration] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateWorkGroupInput =
      CreateWorkGroupInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorkGroupOutput(

    ): CreateWorkGroupOutput =
      CreateWorkGroupOutput
        .builder

        .build

    def dataCatalog(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      parameters: Option[ParametersMap] = None
    ): DataCatalog =
      DataCatalog
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def dataCatalogSummary(
      catalogName: Option[String] = None,
      `type`: Option[String] = None
    ): DataCatalogSummary =
      DataCatalogSummary
        .builder
        .ifSome(catalogName)(_.catalogName(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def database(
      name: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ParametersMap] = None
    ): Database =
      Database
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def datum(
      varCharValue: Option[String] = None
    ): Datum =
      Datum
        .builder
        .ifSome(varCharValue)(_.varCharValue(_))
        .build

    def deleteDataCatalogInput(
      name: Option[String] = None
    ): DeleteDataCatalogInput =
      DeleteDataCatalogInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteDataCatalogOutput(

    ): DeleteDataCatalogOutput =
      DeleteDataCatalogOutput
        .builder

        .build

    def deleteNamedQueryInput(
      namedQueryId: Option[String] = None
    ): DeleteNamedQueryInput =
      DeleteNamedQueryInput
        .builder
        .ifSome(namedQueryId)(_.namedQueryId(_))
        .build

    def deleteNamedQueryOutput(

    ): DeleteNamedQueryOutput =
      DeleteNamedQueryOutput
        .builder

        .build

    def deletePreparedStatementInput(
      statementName: Option[String] = None,
      workGroup: Option[String] = None
    ): DeletePreparedStatementInput =
      DeletePreparedStatementInput
        .builder
        .ifSome(statementName)(_.statementName(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def deletePreparedStatementOutput(

    ): DeletePreparedStatementOutput =
      DeletePreparedStatementOutput
        .builder

        .build

    def deleteWorkGroupInput(
      workGroup: Option[String] = None,
      recursiveDeleteOption: Option[Boolean] = None
    ): DeleteWorkGroupInput =
      DeleteWorkGroupInput
        .builder
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(recursiveDeleteOption)(_.recursiveDeleteOption(_))
        .build

    def deleteWorkGroupOutput(

    ): DeleteWorkGroupOutput =
      DeleteWorkGroupOutput
        .builder

        .build

    def encryptionConfiguration(
      encryptionOption: Option[String] = None,
      kmsKey: Option[String] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(encryptionOption)(_.encryptionOption(_))
        .ifSome(kmsKey)(_.kmsKey(_))
        .build

    def engineVersion(
      selectedEngineVersion: Option[String] = None,
      effectiveEngineVersion: Option[String] = None
    ): EngineVersion =
      EngineVersion
        .builder
        .ifSome(selectedEngineVersion)(_.selectedEngineVersion(_))
        .ifSome(effectiveEngineVersion)(_.effectiveEngineVersion(_))
        .build

    def getDataCatalogInput(
      name: Option[String] = None
    ): GetDataCatalogInput =
      GetDataCatalogInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getDataCatalogOutput(
      dataCatalog: Option[DataCatalog] = None
    ): GetDataCatalogOutput =
      GetDataCatalogOutput
        .builder
        .ifSome(dataCatalog)(_.dataCatalog(_))
        .build

    def getDatabaseInput(
      catalogName: Option[String] = None,
      databaseName: Option[String] = None
    ): GetDatabaseInput =
      GetDatabaseInput
        .builder
        .ifSome(catalogName)(_.catalogName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def getDatabaseOutput(
      database: Option[Database] = None
    ): GetDatabaseOutput =
      GetDatabaseOutput
        .builder
        .ifSome(database)(_.database(_))
        .build

    def getNamedQueryInput(
      namedQueryId: Option[String] = None
    ): GetNamedQueryInput =
      GetNamedQueryInput
        .builder
        .ifSome(namedQueryId)(_.namedQueryId(_))
        .build

    def getNamedQueryOutput(
      namedQuery: Option[NamedQuery] = None
    ): GetNamedQueryOutput =
      GetNamedQueryOutput
        .builder
        .ifSome(namedQuery)(_.namedQuery(_))
        .build

    def getPreparedStatementInput(
      statementName: Option[String] = None,
      workGroup: Option[String] = None
    ): GetPreparedStatementInput =
      GetPreparedStatementInput
        .builder
        .ifSome(statementName)(_.statementName(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def getPreparedStatementOutput(
      preparedStatement: Option[PreparedStatement] = None
    ): GetPreparedStatementOutput =
      GetPreparedStatementOutput
        .builder
        .ifSome(preparedStatement)(_.preparedStatement(_))
        .build

    def getQueryExecutionInput(
      queryExecutionId: Option[String] = None
    ): GetQueryExecutionInput =
      GetQueryExecutionInput
        .builder
        .ifSome(queryExecutionId)(_.queryExecutionId(_))
        .build

    def getQueryExecutionOutput(
      queryExecution: Option[QueryExecution] = None
    ): GetQueryExecutionOutput =
      GetQueryExecutionOutput
        .builder
        .ifSome(queryExecution)(_.queryExecution(_))
        .build

    def getQueryResultsInput(
      queryExecutionId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetQueryResultsInput =
      GetQueryResultsInput
        .builder
        .ifSome(queryExecutionId)(_.queryExecutionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getQueryResultsOutput(
      updateCount: Option[Long] = None,
      resultSet: Option[ResultSet] = None,
      nextToken: Option[String] = None
    ): GetQueryResultsOutput =
      GetQueryResultsOutput
        .builder
        .ifSome(updateCount)(_.updateCount(_))
        .ifSome(resultSet)(_.resultSet(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTableMetadataInput(
      catalogName: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None
    ): GetTableMetadataInput =
      GetTableMetadataInput
        .builder
        .ifSome(catalogName)(_.catalogName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .build

    def getTableMetadataOutput(
      tableMetadata: Option[TableMetadata] = None
    ): GetTableMetadataOutput =
      GetTableMetadataOutput
        .builder
        .ifSome(tableMetadata)(_.tableMetadata(_))
        .build

    def getWorkGroupInput(
      workGroup: Option[String] = None
    ): GetWorkGroupInput =
      GetWorkGroupInput
        .builder
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def getWorkGroupOutput(
      workGroup: Option[WorkGroup] = None
    ): GetWorkGroupOutput =
      GetWorkGroupOutput
        .builder
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      athenaErrorCode: Option[String] = None,
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(athenaErrorCode)(_.athenaErrorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def listDataCatalogsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDataCatalogsInput =
      ListDataCatalogsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDataCatalogsOutput(
      dataCatalogsSummary: Option[List[DataCatalogSummary]] = None,
      nextToken: Option[String] = None
    ): ListDataCatalogsOutput =
      ListDataCatalogsOutput
        .builder
        .ifSome(dataCatalogsSummary)(_.dataCatalogsSummary(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatabasesInput(
      catalogName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatabasesInput =
      ListDatabasesInput
        .builder
        .ifSome(catalogName)(_.catalogName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatabasesOutput(
      databaseList: Option[List[Database]] = None,
      nextToken: Option[String] = None
    ): ListDatabasesOutput =
      ListDatabasesOutput
        .builder
        .ifSome(databaseList)(_.databaseList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEngineVersionsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEngineVersionsInput =
      ListEngineVersionsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEngineVersionsOutput(
      engineVersions: Option[List[EngineVersion]] = None,
      nextToken: Option[String] = None
    ): ListEngineVersionsOutput =
      ListEngineVersionsOutput
        .builder
        .ifSome(engineVersions)(_.engineVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNamedQueriesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      workGroup: Option[String] = None
    ): ListNamedQueriesInput =
      ListNamedQueriesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def listNamedQueriesOutput(
      namedQueryIds: Option[List[NamedQueryId]] = None,
      nextToken: Option[String] = None
    ): ListNamedQueriesOutput =
      ListNamedQueriesOutput
        .builder
        .ifSome(namedQueryIds)(_.namedQueryIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPreparedStatementsInput(
      workGroup: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPreparedStatementsInput =
      ListPreparedStatementsInput
        .builder
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPreparedStatementsOutput(
      preparedStatements: Option[List[PreparedStatementSummary]] = None,
      nextToken: Option[String] = None
    ): ListPreparedStatementsOutput =
      ListPreparedStatementsOutput
        .builder
        .ifSome(preparedStatements)(_.preparedStatements(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listQueryExecutionsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      workGroup: Option[String] = None
    ): ListQueryExecutionsInput =
      ListQueryExecutionsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def listQueryExecutionsOutput(
      queryExecutionIds: Option[List[QueryExecutionId]] = None,
      nextToken: Option[String] = None
    ): ListQueryExecutionsOutput =
      ListQueryExecutionsOutput
        .builder
        .ifSome(queryExecutionIds)(_.queryExecutionIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTableMetadataInput(
      catalogName: Option[String] = None,
      databaseName: Option[String] = None,
      expression: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTableMetadataInput =
      ListTableMetadataInput
        .builder
        .ifSome(catalogName)(_.catalogName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTableMetadataOutput(
      tableMetadataList: Option[List[TableMetadata]] = None,
      nextToken: Option[String] = None
    ): ListTableMetadataOutput =
      ListTableMetadataOutput
        .builder
        .ifSome(tableMetadataList)(_.tableMetadataList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      resourceARN: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceOutput(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorkGroupsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorkGroupsInput =
      ListWorkGroupsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorkGroupsOutput(
      workGroups: Option[List[WorkGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorkGroupsOutput =
      ListWorkGroupsOutput
        .builder
        .ifSome(workGroups)(_.workGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def metadataException(
      message: Option[String] = None
    ): MetadataException =
      MetadataException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def namedQuery(
      name: Option[String] = None,
      description: Option[String] = None,
      database: Option[String] = None,
      queryString: Option[String] = None,
      namedQueryId: Option[String] = None,
      workGroup: Option[String] = None
    ): NamedQuery =
      NamedQuery
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(database)(_.database(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(namedQueryId)(_.namedQueryId(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def preparedStatement(
      statementName: Option[String] = None,
      queryStatement: Option[String] = None,
      workGroupName: Option[String] = None,
      description: Option[String] = None,
      lastModifiedTime: Option[Date] = None
    ): PreparedStatement =
      PreparedStatement
        .builder
        .ifSome(statementName)(_.statementName(_))
        .ifSome(queryStatement)(_.queryStatement(_))
        .ifSome(workGroupName)(_.workGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def preparedStatementSummary(
      statementName: Option[String] = None,
      lastModifiedTime: Option[Date] = None
    ): PreparedStatementSummary =
      PreparedStatementSummary
        .builder
        .ifSome(statementName)(_.statementName(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .build

    def queryExecution(
      queryExecutionId: Option[String] = None,
      query: Option[String] = None,
      statementType: Option[String] = None,
      resultConfiguration: Option[ResultConfiguration] = None,
      queryExecutionContext: Option[QueryExecutionContext] = None,
      status: Option[QueryExecutionStatus] = None,
      statistics: Option[QueryExecutionStatistics] = None,
      workGroup: Option[String] = None,
      engineVersion: Option[EngineVersion] = None
    ): QueryExecution =
      QueryExecution
        .builder
        .ifSome(queryExecutionId)(_.queryExecutionId(_))
        .ifSome(query)(_.query(_))
        .ifSome(statementType)(_.statementType(_))
        .ifSome(resultConfiguration)(_.resultConfiguration(_))
        .ifSome(queryExecutionContext)(_.queryExecutionContext(_))
        .ifSome(status)(_.status(_))
        .ifSome(statistics)(_.statistics(_))
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .build

    def queryExecutionContext(
      database: Option[String] = None,
      catalog: Option[String] = None
    ): QueryExecutionContext =
      QueryExecutionContext
        .builder
        .ifSome(database)(_.database(_))
        .ifSome(catalog)(_.catalog(_))
        .build

    def queryExecutionStatistics(
      engineExecutionTimeInMillis: Option[Long] = None,
      dataScannedInBytes: Option[Long] = None,
      dataManifestLocation: Option[String] = None,
      totalExecutionTimeInMillis: Option[Long] = None,
      queryQueueTimeInMillis: Option[Long] = None,
      queryPlanningTimeInMillis: Option[Long] = None,
      serviceProcessingTimeInMillis: Option[Long] = None
    ): QueryExecutionStatistics =
      QueryExecutionStatistics
        .builder
        .ifSome(engineExecutionTimeInMillis)(_.engineExecutionTimeInMillis(_))
        .ifSome(dataScannedInBytes)(_.dataScannedInBytes(_))
        .ifSome(dataManifestLocation)(_.dataManifestLocation(_))
        .ifSome(totalExecutionTimeInMillis)(_.totalExecutionTimeInMillis(_))
        .ifSome(queryQueueTimeInMillis)(_.queryQueueTimeInMillis(_))
        .ifSome(queryPlanningTimeInMillis)(_.queryPlanningTimeInMillis(_))
        .ifSome(serviceProcessingTimeInMillis)(_.serviceProcessingTimeInMillis(_))
        .build

    def queryExecutionStatus(
      state: Option[String] = None,
      stateChangeReason: Option[String] = None,
      submissionDateTime: Option[Date] = None,
      completionDateTime: Option[Date] = None
    ): QueryExecutionStatus =
      QueryExecutionStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(submissionDateTime)(_.submissionDateTime(_))
        .ifSome(completionDateTime)(_.completionDateTime(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resultConfiguration(
      outputLocation: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None
    ): ResultConfiguration =
      ResultConfiguration
        .builder
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .build

    def resultConfigurationUpdates(
      outputLocation: Option[String] = None,
      removeOutputLocation: Option[Boolean] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      removeEncryptionConfiguration: Option[Boolean] = None
    ): ResultConfigurationUpdates =
      ResultConfigurationUpdates
        .builder
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(removeOutputLocation)(_.removeOutputLocation(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(removeEncryptionConfiguration)(_.removeEncryptionConfiguration(_))
        .build

    def resultSet(
      rows: Option[List[Row]] = None,
      resultSetMetadata: Option[ResultSetMetadata] = None
    ): ResultSet =
      ResultSet
        .builder
        .ifSome(rows)(_.rows(_))
        .ifSome(resultSetMetadata)(_.resultSetMetadata(_))
        .build

    def resultSetMetadata(
      columnInfo: Option[List[ColumnInfo]] = None
    ): ResultSetMetadata =
      ResultSetMetadata
        .builder
        .ifSome(columnInfo)(_.columnInfo(_))
        .build

    def row(
      data: Option[List[Datum]] = None
    ): Row =
      Row
        .builder
        .ifSome(data)(_.data(_))
        .build

    def startQueryExecutionInput(
      queryString: Option[String] = None,
      clientRequestToken: Option[String] = None,
      queryExecutionContext: Option[QueryExecutionContext] = None,
      resultConfiguration: Option[ResultConfiguration] = None,
      workGroup: Option[String] = None
    ): StartQueryExecutionInput =
      StartQueryExecutionInput
        .builder
        .ifSome(queryString)(_.queryString(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(queryExecutionContext)(_.queryExecutionContext(_))
        .ifSome(resultConfiguration)(_.resultConfiguration(_))
        .ifSome(workGroup)(_.workGroup(_))
        .build

    def startQueryExecutionOutput(
      queryExecutionId: Option[String] = None
    ): StartQueryExecutionOutput =
      StartQueryExecutionOutput
        .builder
        .ifSome(queryExecutionId)(_.queryExecutionId(_))
        .build

    def stopQueryExecutionInput(
      queryExecutionId: Option[String] = None
    ): StopQueryExecutionInput =
      StopQueryExecutionInput
        .builder
        .ifSome(queryExecutionId)(_.queryExecutionId(_))
        .build

    def stopQueryExecutionOutput(

    ): StopQueryExecutionOutput =
      StopQueryExecutionOutput
        .builder

        .build

    def tableMetadata(
      name: Option[String] = None,
      createTime: Option[Timestamp] = None,
      lastAccessTime: Option[Timestamp] = None,
      tableType: Option[String] = None,
      columns: Option[List[Column]] = None,
      partitionKeys: Option[List[Column]] = None,
      parameters: Option[ParametersMap] = None
    ): TableMetadata =
      TableMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(lastAccessTime)(_.lastAccessTime(_))
        .ifSome(tableType)(_.tableType(_))
        .ifSome(columns)(_.columns(_))
        .ifSome(partitionKeys)(_.partitionKeys(_))
        .ifSome(parameters)(_.parameters(_))
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

    def tagResourceInput(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def tooManyRequestsException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def unprocessedNamedQueryId(
      namedQueryId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): UnprocessedNamedQueryId =
      UnprocessedNamedQueryId
        .builder
        .ifSome(namedQueryId)(_.namedQueryId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def unprocessedQueryExecutionId(
      queryExecutionId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): UnprocessedQueryExecutionId =
      UnprocessedQueryExecutionId
        .builder
        .ifSome(queryExecutionId)(_.queryExecutionId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def untagResourceInput(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateDataCatalogInput(
      name: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[ParametersMap] = None
    ): UpdateDataCatalogInput =
      UpdateDataCatalogInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def updateDataCatalogOutput(

    ): UpdateDataCatalogOutput =
      UpdateDataCatalogOutput
        .builder

        .build

    def updatePreparedStatementInput(
      statementName: Option[String] = None,
      workGroup: Option[String] = None,
      queryStatement: Option[String] = None,
      description: Option[String] = None
    ): UpdatePreparedStatementInput =
      UpdatePreparedStatementInput
        .builder
        .ifSome(statementName)(_.statementName(_))
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(queryStatement)(_.queryStatement(_))
        .ifSome(description)(_.description(_))
        .build

    def updatePreparedStatementOutput(

    ): UpdatePreparedStatementOutput =
      UpdatePreparedStatementOutput
        .builder

        .build

    def updateWorkGroupInput(
      workGroup: Option[String] = None,
      description: Option[String] = None,
      configurationUpdates: Option[WorkGroupConfigurationUpdates] = None,
      state: Option[String] = None
    ): UpdateWorkGroupInput =
      UpdateWorkGroupInput
        .builder
        .ifSome(workGroup)(_.workGroup(_))
        .ifSome(description)(_.description(_))
        .ifSome(configurationUpdates)(_.configurationUpdates(_))
        .ifSome(state)(_.state(_))
        .build

    def updateWorkGroupOutput(

    ): UpdateWorkGroupOutput =
      UpdateWorkGroupOutput
        .builder

        .build

    def workGroup(
      name: Option[String] = None,
      state: Option[String] = None,
      configuration: Option[WorkGroupConfiguration] = None,
      description: Option[String] = None,
      creationTime: Option[Date] = None
    ): WorkGroup =
      WorkGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def workGroupConfiguration(
      resultConfiguration: Option[ResultConfiguration] = None,
      enforceWorkGroupConfiguration: Option[Boolean] = None,
      publishCloudWatchMetricsEnabled: Option[Boolean] = None,
      bytesScannedCutoffPerQuery: Option[BytesScannedCutoffValue] = None,
      requesterPaysEnabled: Option[Boolean] = None,
      engineVersion: Option[EngineVersion] = None
    ): WorkGroupConfiguration =
      WorkGroupConfiguration
        .builder
        .ifSome(resultConfiguration)(_.resultConfiguration(_))
        .ifSome(enforceWorkGroupConfiguration)(_.enforceWorkGroupConfiguration(_))
        .ifSome(publishCloudWatchMetricsEnabled)(_.publishCloudWatchMetricsEnabled(_))
        .ifSome(bytesScannedCutoffPerQuery)(_.bytesScannedCutoffPerQuery(_))
        .ifSome(requesterPaysEnabled)(_.requesterPaysEnabled(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .build

    def workGroupConfigurationUpdates(
      enforceWorkGroupConfiguration: Option[Boolean] = None,
      resultConfigurationUpdates: Option[ResultConfigurationUpdates] = None,
      publishCloudWatchMetricsEnabled: Option[Boolean] = None,
      bytesScannedCutoffPerQuery: Option[BytesScannedCutoffValue] = None,
      removeBytesScannedCutoffPerQuery: Option[Boolean] = None,
      requesterPaysEnabled: Option[Boolean] = None,
      engineVersion: Option[EngineVersion] = None
    ): WorkGroupConfigurationUpdates =
      WorkGroupConfigurationUpdates
        .builder
        .ifSome(enforceWorkGroupConfiguration)(_.enforceWorkGroupConfiguration(_))
        .ifSome(resultConfigurationUpdates)(_.resultConfigurationUpdates(_))
        .ifSome(publishCloudWatchMetricsEnabled)(_.publishCloudWatchMetricsEnabled(_))
        .ifSome(bytesScannedCutoffPerQuery)(_.bytesScannedCutoffPerQuery(_))
        .ifSome(removeBytesScannedCutoffPerQuery)(_.removeBytesScannedCutoffPerQuery(_))
        .ifSome(requesterPaysEnabled)(_.requesterPaysEnabled(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .build

    def workGroupSummary(
      name: Option[String] = None,
      state: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[Date] = None,
      engineVersion: Option[EngineVersion] = None
    ): WorkGroupSummary =
      WorkGroupSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
