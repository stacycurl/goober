package goober.hi

import goober.free.rdsdata.RdsDataIO
import software.amazon.awssdk.services.rdsdata.model._


object rdsdata {
  import goober.free.{rdsdata ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def arrayValue(
      arrayValues: Option[List[ArrayValue]] = None,
      booleanValues: Option[List[BoxedBoolean]] = None,
      doubleValues: Option[List[BoxedDouble]] = None,
      longValues: Option[List[BoxedLong]] = None,
      stringValues: Option[List[String]] = None
    ): ArrayValue =
      ArrayValue
        .builder
        .ifSome(arrayValues)(_.arrayValues(_))
        .ifSome(booleanValues)(_.booleanValues(_))
        .ifSome(doubleValues)(_.doubleValues(_))
        .ifSome(longValues)(_.longValues(_))
        .ifSome(stringValues)(_.stringValues(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def batchExecuteStatementRequest(
      database: Option[String] = None,
      parameterSets: Option[List[SqlParametersList]] = None,
      resourceArn: Option[String] = None,
      schema: Option[String] = None,
      secretArn: Option[String] = None,
      sql: Option[String] = None,
      transactionId: Option[String] = None
    ): BatchExecuteStatementRequest =
      BatchExecuteStatementRequest
        .builder
        .ifSome(database)(_.database(_))
        .ifSome(parameterSets)(_.parameterSets(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(sql)(_.sql(_))
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def batchExecuteStatementResponse(
      updateResults: Option[List[UpdateResult]] = None
    ): BatchExecuteStatementResponse =
      BatchExecuteStatementResponse
        .builder
        .ifSome(updateResults)(_.updateResults(_))
        .build

    def beginTransactionRequest(
      database: Option[String] = None,
      resourceArn: Option[String] = None,
      schema: Option[String] = None,
      secretArn: Option[String] = None
    ): BeginTransactionRequest =
      BeginTransactionRequest
        .builder
        .ifSome(database)(_.database(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def beginTransactionResponse(
      transactionId: Option[String] = None
    ): BeginTransactionResponse =
      BeginTransactionResponse
        .builder
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def columnMetadata(
      arrayBaseColumnType: Option[Int] = None,
      isAutoIncrement: Option[Boolean] = None,
      isCaseSensitive: Option[Boolean] = None,
      isCurrency: Option[Boolean] = None,
      isSigned: Option[Boolean] = None,
      label: Option[String] = None,
      name: Option[String] = None,
      nullable: Option[Int] = None,
      precision: Option[Int] = None,
      scale: Option[Int] = None,
      schemaName: Option[String] = None,
      tableName: Option[String] = None,
      `type`: Option[Int] = None,
      typeName: Option[String] = None
    ): ColumnMetadata =
      ColumnMetadata
        .builder
        .ifSome(arrayBaseColumnType)(_.arrayBaseColumnType(_))
        .ifSome(isAutoIncrement)(_.isAutoIncrement(_))
        .ifSome(isCaseSensitive)(_.isCaseSensitive(_))
        .ifSome(isCurrency)(_.isCurrency(_))
        .ifSome(isSigned)(_.isSigned(_))
        .ifSome(label)(_.label(_))
        .ifSome(name)(_.name(_))
        .ifSome(nullable)(_.nullable(_))
        .ifSome(precision)(_.precision(_))
        .ifSome(scale)(_.scale(_))
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .build

    def commitTransactionRequest(
      resourceArn: Option[String] = None,
      secretArn: Option[String] = None,
      transactionId: Option[String] = None
    ): CommitTransactionRequest =
      CommitTransactionRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def commitTransactionResponse(
      transactionStatus: Option[String] = None
    ): CommitTransactionResponse =
      CommitTransactionResponse
        .builder
        .ifSome(transactionStatus)(_.transactionStatus(_))
        .build

    def executeSqlRequest(
      awsSecretStoreArn: Option[String] = None,
      database: Option[String] = None,
      dbClusterOrInstanceArn: Option[String] = None,
      schema: Option[String] = None,
      sqlStatements: Option[String] = None
    ): ExecuteSqlRequest =
      ExecuteSqlRequest
        .builder
        .ifSome(awsSecretStoreArn)(_.awsSecretStoreArn(_))
        .ifSome(database)(_.database(_))
        .ifSome(dbClusterOrInstanceArn)(_.dbClusterOrInstanceArn(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(sqlStatements)(_.sqlStatements(_))
        .build

    def executeSqlResponse(
      sqlStatementResults: Option[List[SqlStatementResult]] = None
    ): ExecuteSqlResponse =
      ExecuteSqlResponse
        .builder
        .ifSome(sqlStatementResults)(_.sqlStatementResults(_))
        .build

    def executeStatementRequest(
      continueAfterTimeout: Option[Boolean] = None,
      database: Option[String] = None,
      includeResultMetadata: Option[Boolean] = None,
      parameters: Option[List[SqlParameter]] = None,
      resourceArn: Option[String] = None,
      resultSetOptions: Option[ResultSetOptions] = None,
      schema: Option[String] = None,
      secretArn: Option[String] = None,
      sql: Option[String] = None,
      transactionId: Option[String] = None
    ): ExecuteStatementRequest =
      ExecuteStatementRequest
        .builder
        .ifSome(continueAfterTimeout)(_.continueAfterTimeout(_))
        .ifSome(database)(_.database(_))
        .ifSome(includeResultMetadata)(_.includeResultMetadata(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resultSetOptions)(_.resultSetOptions(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(sql)(_.sql(_))
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def executeStatementResponse(
      columnMetadata: Option[List[ColumnMetadata]] = None,
      generatedFields: Option[List[Field]] = None,
      numberOfRecordsUpdated: Option[RecordsUpdated] = None,
      records: Option[List[FieldList]] = None
    ): ExecuteStatementResponse =
      ExecuteStatementResponse
        .builder
        .ifSome(columnMetadata)(_.columnMetadata(_))
        .ifSome(generatedFields)(_.generatedFields(_))
        .ifSome(numberOfRecordsUpdated)(_.numberOfRecordsUpdated(_))
        .ifSome(records)(_.records(_))
        .build

    def field(
      arrayValue: Option[ArrayValue] = None,
      blobValue: Option[Blob] = None,
      booleanValue: Option[Boolean] = None,
      doubleValue: Option[BoxedDouble] = None,
      isNull: Option[Boolean] = None,
      longValue: Option[BoxedLong] = None,
      stringValue: Option[String] = None
    ): Field =
      Field
        .builder
        .ifSome(arrayValue)(_.arrayValue(_))
        .ifSome(blobValue)(_.blobValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(isNull)(_.isNull(_))
        .ifSome(longValue)(_.longValue(_))
        .ifSome(stringValue)(_.stringValue(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServerErrorException(

    ): InternalServerErrorException =
      InternalServerErrorException
        .builder

        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def record(
      values: Option[List[Value]] = None
    ): Record =
      Record
        .builder
        .ifSome(values)(_.values(_))
        .build

    def resultFrame(
      records: Option[List[Record]] = None,
      resultSetMetadata: Option[ResultSetMetadata] = None
    ): ResultFrame =
      ResultFrame
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(resultSetMetadata)(_.resultSetMetadata(_))
        .build

    def resultSetMetadata(
      columnCount: Option[Long] = None,
      columnMetadata: Option[List[ColumnMetadata]] = None
    ): ResultSetMetadata =
      ResultSetMetadata
        .builder
        .ifSome(columnCount)(_.columnCount(_))
        .ifSome(columnMetadata)(_.columnMetadata(_))
        .build

    def resultSetOptions(
      decimalReturnType: Option[String] = None
    ): ResultSetOptions =
      ResultSetOptions
        .builder
        .ifSome(decimalReturnType)(_.decimalReturnType(_))
        .build

    def rollbackTransactionRequest(
      resourceArn: Option[String] = None,
      secretArn: Option[String] = None,
      transactionId: Option[String] = None
    ): RollbackTransactionRequest =
      RollbackTransactionRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def rollbackTransactionResponse(
      transactionStatus: Option[String] = None
    ): RollbackTransactionResponse =
      RollbackTransactionResponse
        .builder
        .ifSome(transactionStatus)(_.transactionStatus(_))
        .build

    def serviceUnavailableError(

    ): ServiceUnavailableError =
      ServiceUnavailableError
        .builder

        .build

    def sqlParameter(
      name: Option[String] = None,
      typeHint: Option[String] = None,
      value: Option[Field] = None
    ): SqlParameter =
      SqlParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(typeHint)(_.typeHint(_))
        .ifSome(value)(_.value(_))
        .build

    def statementTimeoutException(
      dbConnectionId: Option[Long] = None,
      message: Option[String] = None
    ): StatementTimeoutException =
      StatementTimeoutException
        .builder
        .ifSome(dbConnectionId)(_.dbConnectionId(_))
        .ifSome(message)(_.message(_))
        .build

    def structValue(
      attributes: Option[List[Value]] = None
    ): StructValue =
      StructValue
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def value(
      arrayValues: Option[List[Value]] = None,
      bigIntValue: Option[BoxedLong] = None,
      bitValue: Option[Boolean] = None,
      blobValue: Option[Blob] = None,
      doubleValue: Option[BoxedDouble] = None,
      intValue: Option[Int] = None,
      isNull: Option[Boolean] = None,
      realValue: Option[BoxedFloat] = None,
      stringValue: Option[String] = None,
      structValue: Option[StructValue] = None
    ): Value =
      Value
        .builder
        .ifSome(arrayValues)(_.arrayValues(_))
        .ifSome(bigIntValue)(_.bigIntValue(_))
        .ifSome(bitValue)(_.bitValue(_))
        .ifSome(blobValue)(_.blobValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(intValue)(_.intValue(_))
        .ifSome(isNull)(_.isNull(_))
        .ifSome(realValue)(_.realValue(_))
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(structValue)(_.structValue(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
