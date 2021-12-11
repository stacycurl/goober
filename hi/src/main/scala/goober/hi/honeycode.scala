package goober.hi

import goober.free.honeycode.HoneycodeIO
import software.amazon.awssdk.services.honeycode.model._


object honeycode {
  import goober.free.{honeycode ⇒ free}

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

    def automationExecutionException(
      message: Option[String] = None
    ): AutomationExecutionException =
      AutomationExecutionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def automationExecutionTimeoutException(
      message: Option[String] = None
    ): AutomationExecutionTimeoutException =
      AutomationExecutionTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def batchCreateTableRowsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      rowsToCreate: Option[List[CreateRowData]] = None,
      clientRequestToken: Option[String] = None
    ): BatchCreateTableRowsRequest =
      BatchCreateTableRowsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(rowsToCreate)(_.rowsToCreate(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def batchDeleteTableRowsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      rowIds: Option[List[RowId]] = None,
      clientRequestToken: Option[String] = None
    ): BatchDeleteTableRowsRequest =
      BatchDeleteTableRowsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(rowIds)(_.rowIds(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def batchUpdateTableRowsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      rowsToUpdate: Option[List[UpdateRowData]] = None,
      clientRequestToken: Option[String] = None
    ): BatchUpdateTableRowsRequest =
      BatchUpdateTableRowsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(rowsToUpdate)(_.rowsToUpdate(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def batchUpsertTableRowsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      rowsToUpsert: Option[List[UpsertRowData]] = None,
      clientRequestToken: Option[String] = None
    ): BatchUpsertTableRowsRequest =
      BatchUpsertTableRowsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(rowsToUpsert)(_.rowsToUpsert(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def cell(
      formula: Option[String] = None,
      format: Option[String] = None,
      rawValue: Option[String] = None,
      formattedValue: Option[String] = None
    ): Cell =
      Cell
        .builder
        .ifSome(formula)(_.formula(_))
        .ifSome(format)(_.format(_))
        .ifSome(rawValue)(_.rawValue(_))
        .ifSome(formattedValue)(_.formattedValue(_))
        .build

    def cellInput(
      fact: Option[String] = None
    ): CellInput =
      CellInput
        .builder
        .ifSome(fact)(_.fact(_))
        .build

    def columnMetadata(
      name: Option[String] = None,
      format: Option[String] = None
    ): ColumnMetadata =
      ColumnMetadata
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .build

    def createRowData(
      batchItemId: Option[String] = None,
      cellsToCreate: Option[RowDataInput] = None
    ): CreateRowData =
      CreateRowData
        .builder
        .ifSome(batchItemId)(_.batchItemId(_))
        .ifSome(cellsToCreate)(_.cellsToCreate(_))
        .build

    def dataItem(
      overrideFormat: Option[String] = None,
      rawValue: Option[String] = None,
      formattedValue: Option[String] = None
    ): DataItem =
      DataItem
        .builder
        .ifSome(overrideFormat)(_.overrideFormat(_))
        .ifSome(rawValue)(_.rawValue(_))
        .ifSome(formattedValue)(_.formattedValue(_))
        .build

    def delimitedTextImportOptions(
      delimiter: Option[String] = None,
      hasHeaderRow: Option[Boolean] = None,
      ignoreEmptyRows: Option[Boolean] = None,
      dataCharacterEncoding: Option[String] = None
    ): DelimitedTextImportOptions =
      DelimitedTextImportOptions
        .builder
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(hasHeaderRow)(_.hasHeaderRow(_))
        .ifSome(ignoreEmptyRows)(_.ignoreEmptyRows(_))
        .ifSome(dataCharacterEncoding)(_.dataCharacterEncoding(_))
        .build

    def describeTableDataImportJobRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      jobId: Option[String] = None
    ): DescribeTableDataImportJobRequest =
      DescribeTableDataImportJobRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def destinationOptions(
      columnMap: Option[ImportColumnMap] = None
    ): DestinationOptions =
      DestinationOptions
        .builder
        .ifSome(columnMap)(_.columnMap(_))
        .build

    def failedBatchItem(
      id: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailedBatchItem =
      FailedBatchItem
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def filter(
      formula: Option[String] = None,
      contextRowId: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(formula)(_.formula(_))
        .ifSome(contextRowId)(_.contextRowId(_))
        .build

    def getScreenDataRequest(
      workbookId: Option[String] = None,
      appId: Option[String] = None,
      screenId: Option[String] = None,
      variables: Option[VariableValueMap] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetScreenDataRequest =
      GetScreenDataRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(screenId)(_.screenId(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def importDataSource(
      dataSourceConfig: Option[ImportDataSourceConfig] = None
    ): ImportDataSource =
      ImportDataSource
        .builder
        .ifSome(dataSourceConfig)(_.dataSourceConfig(_))
        .build

    def importDataSourceConfig(
      dataSourceUrl: Option[String] = None
    ): ImportDataSourceConfig =
      ImportDataSourceConfig
        .builder
        .ifSome(dataSourceUrl)(_.dataSourceUrl(_))
        .build

    def importJobSubmitter(
      email: Option[String] = None,
      userArn: Option[String] = None
    ): ImportJobSubmitter =
      ImportJobSubmitter
        .builder
        .ifSome(email)(_.email(_))
        .ifSome(userArn)(_.userArn(_))
        .build

    def importOptions(
      destinationOptions: Option[DestinationOptions] = None,
      delimitedTextOptions: Option[DelimitedTextImportOptions] = None
    ): ImportOptions =
      ImportOptions
        .builder
        .ifSome(destinationOptions)(_.destinationOptions(_))
        .ifSome(delimitedTextOptions)(_.delimitedTextOptions(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invokeScreenAutomationRequest(
      workbookId: Option[String] = None,
      appId: Option[String] = None,
      screenId: Option[String] = None,
      screenAutomationId: Option[String] = None,
      variables: Option[VariableValueMap] = None,
      rowId: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): InvokeScreenAutomationRequest =
      InvokeScreenAutomationRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(appId)(_.appId(_))
        .ifSome(screenId)(_.screenId(_))
        .ifSome(screenAutomationId)(_.screenAutomationId(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(rowId)(_.rowId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def listTableColumnsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTableColumnsRequest =
      ListTableColumnsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTableRowsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      rowIds: Option[List[RowId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTableRowsRequest =
      ListTableRowsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(rowIds)(_.rowIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTablesRequest(
      workbookId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTablesRequest =
      ListTablesRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def queryTableRowsRequest(
      workbookId: Option[String] = None,
      tableId: Option[String] = None,
      filterFormula: Option[Filter] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): QueryTableRowsRequest =
      QueryTableRowsRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(filterFormula)(_.filterFormula(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def requestTimeoutException(
      message: Option[String] = None
    ): RequestTimeoutException =
      RequestTimeoutException
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

    def resultRow(
      rowId: Option[String] = None,
      dataItems: Option[List[DataItem]] = None
    ): ResultRow =
      ResultRow
        .builder
        .ifSome(rowId)(_.rowId(_))
        .ifSome(dataItems)(_.dataItems(_))
        .build

    def resultSet(
      headers: Option[List[ColumnMetadata]] = None,
      rows: Option[List[ResultRow]] = None
    ): ResultSet =
      ResultSet
        .builder
        .ifSome(headers)(_.headers(_))
        .ifSome(rows)(_.rows(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sourceDataColumnProperties(
      columnIndex: Option[Int] = None
    ): SourceDataColumnProperties =
      SourceDataColumnProperties
        .builder
        .ifSome(columnIndex)(_.columnIndex(_))
        .build

    def startTableDataImportJobRequest(
      workbookId: Option[String] = None,
      dataSource: Option[ImportDataSource] = None,
      dataFormat: Option[String] = None,
      destinationTableId: Option[String] = None,
      importOptions: Option[ImportOptions] = None,
      clientRequestToken: Option[String] = None
    ): StartTableDataImportJobRequest =
      StartTableDataImportJobRequest
        .builder
        .ifSome(workbookId)(_.workbookId(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(destinationTableId)(_.destinationTableId(_))
        .ifSome(importOptions)(_.importOptions(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def table(
      tableId: Option[String] = None,
      tableName: Option[String] = None
    ): Table =
      Table
        .builder
        .ifSome(tableId)(_.tableId(_))
        .ifSome(tableName)(_.tableName(_))
        .build

    def tableColumn(
      tableColumnId: Option[String] = None,
      tableColumnName: Option[String] = None,
      format: Option[String] = None
    ): TableColumn =
      TableColumn
        .builder
        .ifSome(tableColumnId)(_.tableColumnId(_))
        .ifSome(tableColumnName)(_.tableColumnName(_))
        .ifSome(format)(_.format(_))
        .build

    def tableDataImportJobMetadata(
      submitter: Option[ImportJobSubmitter] = None,
      submitTime: Option[TimestampInMillis] = None,
      importOptions: Option[ImportOptions] = None,
      dataSource: Option[ImportDataSource] = None
    ): TableDataImportJobMetadata =
      TableDataImportJobMetadata
        .builder
        .ifSome(submitter)(_.submitter(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(importOptions)(_.importOptions(_))
        .ifSome(dataSource)(_.dataSource(_))
        .build

    def tableRow(
      rowId: Option[String] = None,
      cells: Option[List[Cell]] = None
    ): TableRow =
      TableRow
        .builder
        .ifSome(rowId)(_.rowId(_))
        .ifSome(cells)(_.cells(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateRowData(
      rowId: Option[String] = None,
      cellsToUpdate: Option[RowDataInput] = None
    ): UpdateRowData =
      UpdateRowData
        .builder
        .ifSome(rowId)(_.rowId(_))
        .ifSome(cellsToUpdate)(_.cellsToUpdate(_))
        .build

    def upsertRowData(
      batchItemId: Option[String] = None,
      filter: Option[Filter] = None,
      cellsToUpdate: Option[RowDataInput] = None
    ): UpsertRowData =
      UpsertRowData
        .builder
        .ifSome(batchItemId)(_.batchItemId(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(cellsToUpdate)(_.cellsToUpdate(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def variableValue(
      rawValue: Option[String] = None
    ): VariableValue =
      VariableValue
        .builder
        .ifSome(rawValue)(_.rawValue(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
