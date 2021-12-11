package goober.hi

import goober.free.redshiftdata.RedshiftDataIO
import software.amazon.awssdk.services.redshiftdata.model._


object redshiftdata {
  import goober.free.{redshiftdata ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activeStatementsExceededException(
      message: Option[String] = None
    ): ActiveStatementsExceededException =
      ActiveStatementsExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelStatementRequest(
      id: Option[String] = None
    ): CancelStatementRequest =
      CancelStatementRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def cancelStatementResponse(
      status: Option[Boolean] = None
    ): CancelStatementResponse =
      CancelStatementResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def columnMetadata(
      columnDefault: Option[String] = None,
      isCaseSensitive: Option[Boolean] = None,
      isCurrency: Option[Boolean] = None,
      isSigned: Option[Boolean] = None,
      label: Option[String] = None,
      length: Option[Int] = None,
      name: Option[String] = None,
      nullable: Option[Int] = None,
      precision: Option[Int] = None,
      scale: Option[Int] = None,
      schemaName: Option[String] = None,
      tableName: Option[String] = None,
      typeName: Option[String] = None
    ): ColumnMetadata =
      ColumnMetadata
        .builder
        .ifSome(columnDefault)(_.columnDefault(_))
        .ifSome(isCaseSensitive)(_.isCaseSensitive(_))
        .ifSome(isCurrency)(_.isCurrency(_))
        .ifSome(isSigned)(_.isSigned(_))
        .ifSome(label)(_.label(_))
        .ifSome(length)(_.length(_))
        .ifSome(name)(_.name(_))
        .ifSome(nullable)(_.nullable(_))
        .ifSome(precision)(_.precision(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(typeName)(_.typeName(_))
        .build

    def describeStatementRequest(
      id: Option[String] = None
    ): DescribeStatementRequest =
      DescribeStatementRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeStatementResponse(
      clusterIdentifier: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      duration: Option[Long] = None,
      error: Option[String] = None,
      hasResultSet: Option[Boolean] = None,
      id: Option[String] = None,
      queryParameters: Option[List[SqlParameter]] = None,
      queryString: Option[String] = None,
      redshiftPid: Option[Long] = None,
      redshiftQueryId: Option[Long] = None,
      resultRows: Option[Long] = None,
      resultSize: Option[Long] = None,
      secretArn: Option[String] = None,
      status: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): DescribeStatementResponse =
      DescribeStatementResponse
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(error)(_.error(_))
        .ifSome(hasResultSet)(_.hasResultSet(_))
        .ifSome(id)(_.id(_))
        .ifSome(queryParameters)(_.queryParameters(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(redshiftPid)(_.redshiftPid(_))
        .ifSome(redshiftQueryId)(_.redshiftQueryId(_))
        .ifSome(resultRows)(_.resultRows(_))
        .ifSome(resultSize)(_.resultSize(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def describeTableRequest(
      clusterIdentifier: Option[String] = None,
      connectedDatabase: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      schema: Option[String] = None,
      secretArn: Option[String] = None,
      table: Option[String] = None
    ): DescribeTableRequest =
      DescribeTableRequest
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(connectedDatabase)(_.connectedDatabase(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(table)(_.table(_))
        .build

    def describeTableResponse(
      columnList: Option[List[ColumnMetadata]] = None,
      nextToken: Option[String] = None,
      tableName: Option[String] = None
    ): DescribeTableResponse =
      DescribeTableResponse
        .builder
        .ifSome(columnList)(_.columnList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tableName)(_.tableName(_))
        .build

    def executeStatementException(
      message: Option[String] = None,
      statementId: Option[String] = None
    ): ExecuteStatementException =
      ExecuteStatementException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(statementId)(_.statementId(_))
        .build

    def executeStatementInput(
      clusterIdentifier: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      parameters: Option[List[SqlParameter]] = None,
      secretArn: Option[String] = None,
      sql: Option[String] = None,
      statementName: Option[String] = None,
      withEvent: Option[Boolean] = None
    ): ExecuteStatementInput =
      ExecuteStatementInput
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(sql)(_.sql(_))
        .ifSome(statementName)(_.statementName(_))
        .ifSome(withEvent)(_.withEvent(_))
        .build

    def executeStatementOutput(
      clusterIdentifier: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      id: Option[String] = None,
      secretArn: Option[String] = None
    ): ExecuteStatementOutput =
      ExecuteStatementOutput
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(id)(_.id(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def field(
      blobValue: Option[Blob] = None,
      booleanValue: Option[Boolean] = None,
      doubleValue: Option[BoxedDouble] = None,
      isNull: Option[Boolean] = None,
      longValue: Option[BoxedLong] = None,
      stringValue: Option[String] = None
    ): Field =
      Field
        .builder
        .ifSome(blobValue)(_.blobValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(isNull)(_.isNull(_))
        .ifSome(longValue)(_.longValue(_))
        .ifSome(stringValue)(_.stringValue(_))
        .build

    def getStatementResultRequest(
      id: Option[String] = None,
      nextToken: Option[String] = None
    ): GetStatementResultRequest =
      GetStatementResultRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getStatementResultResponse(
      columnMetadata: Option[List[ColumnMetadata]] = None,
      nextToken: Option[String] = None,
      records: Option[List[FieldList]] = None,
      totalNumRows: Option[Long] = None
    ): GetStatementResultResponse =
      GetStatementResultResponse
        .builder
        .ifSome(columnMetadata)(_.columnMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(records)(_.records(_))
        .ifSome(totalNumRows)(_.totalNumRows(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDatabasesRequest(
      clusterIdentifier: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      secretArn: Option[String] = None
    ): ListDatabasesRequest =
      ListDatabasesRequest
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def listDatabasesResponse(
      databases: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): ListDatabasesResponse =
      ListDatabasesResponse
        .builder
        .ifSome(databases)(_.databases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchemasRequest(
      clusterIdentifier: Option[String] = None,
      connectedDatabase: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      schemaPattern: Option[String] = None,
      secretArn: Option[String] = None
    ): ListSchemasRequest =
      ListSchemasRequest
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(connectedDatabase)(_.connectedDatabase(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemaPattern)(_.schemaPattern(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def listSchemasResponse(
      nextToken: Option[String] = None,
      schemas: Option[List[String]] = None
    ): ListSchemasResponse =
      ListSchemasResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemas)(_.schemas(_))
        .build

    def listStatementsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      roleLevel: Option[Boolean] = None,
      statementName: Option[String] = None,
      status: Option[String] = None
    ): ListStatementsRequest =
      ListStatementsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(roleLevel)(_.roleLevel(_))
        .ifSome(statementName)(_.statementName(_))
        .ifSome(status)(_.status(_))
        .build

    def listStatementsResponse(
      nextToken: Option[String] = None,
      statements: Option[List[StatementData]] = None
    ): ListStatementsResponse =
      ListStatementsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(statements)(_.statements(_))
        .build

    def listTablesRequest(
      clusterIdentifier: Option[String] = None,
      connectedDatabase: Option[String] = None,
      database: Option[String] = None,
      dbUser: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      schemaPattern: Option[String] = None,
      secretArn: Option[String] = None,
      tablePattern: Option[String] = None
    ): ListTablesRequest =
      ListTablesRequest
        .builder
        .ifSome(clusterIdentifier)(_.clusterIdentifier(_))
        .ifSome(connectedDatabase)(_.connectedDatabase(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbUser)(_.dbUser(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(schemaPattern)(_.schemaPattern(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(tablePattern)(_.tablePattern(_))
        .build

    def listTablesResponse(
      nextToken: Option[String] = None,
      tables: Option[List[TableMember]] = None
    ): ListTablesResponse =
      ListTablesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tables)(_.tables(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def sqlParameter(
      name: Option[String] = None,
      value: Option[String] = None
    ): SqlParameter =
      SqlParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def statementData(
      createdAt: Option[Timestamp] = None,
      id: Option[String] = None,
      queryParameters: Option[List[SqlParameter]] = None,
      queryString: Option[String] = None,
      secretArn: Option[String] = None,
      statementName: Option[String] = None,
      status: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): StatementData =
      StatementData
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(id)(_.id(_))
        .ifSome(queryParameters)(_.queryParameters(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(statementName)(_.statementName(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def tableMember(
      name: Option[String] = None,
      schema: Option[String] = None,
      `type`: Option[String] = None
    ): TableMember =
      TableMember
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(`type`)(_.`type`(_))
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
