package goober.hi

import goober.free.databrew.DataBrewIO
import software.amazon.awssdk.services.databrew.model._


object databrew {
  import goober.free.{databrew ⇒ free}

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

    def batchDeleteRecipeVersionRequest(
      name: Option[String] = None,
      recipeVersions: Option[List[RecipeVersion]] = None
    ): BatchDeleteRecipeVersionRequest =
      BatchDeleteRecipeVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeVersions)(_.recipeVersions(_))
        .build

    def batchDeleteRecipeVersionResponse(
      name: Option[String] = None,
      errors: Option[List[RecipeVersionErrorDetail]] = None
    ): BatchDeleteRecipeVersionResponse =
      BatchDeleteRecipeVersionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(errors)(_.errors(_))
        .build

    def conditionExpression(
      condition: Option[String] = None,
      value: Option[String] = None,
      targetColumn: Option[String] = None
    ): ConditionExpression =
      ConditionExpression
        .builder
        .ifSome(condition)(_.condition(_))
        .ifSome(value)(_.value(_))
        .ifSome(targetColumn)(_.targetColumn(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createDatasetRequest(
      name: Option[String] = None,
      format: Option[String] = None,
      formatOptions: Option[FormatOptions] = None,
      input: Option[Input] = None,
      pathOptions: Option[PathOptions] = None,
      tags: Option[TagMap] = None
    ): CreateDatasetRequest =
      CreateDatasetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(formatOptions)(_.formatOptions(_))
        .ifSome(input)(_.input(_))
        .ifSome(pathOptions)(_.pathOptions(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDatasetResponse(
      name: Option[String] = None
    ): CreateDatasetResponse =
      CreateDatasetResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createProfileJobRequest(
      datasetName: Option[String] = None,
      encryptionKeyArn: Option[String] = None,
      encryptionMode: Option[String] = None,
      name: Option[String] = None,
      logSubscription: Option[String] = None,
      maxCapacity: Option[Int] = None,
      maxRetries: Option[Int] = None,
      outputLocation: Option[S3Location] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None,
      timeout: Option[Int] = None,
      jobSample: Option[JobSample] = None
    ): CreateProfileJobRequest =
      CreateProfileJobRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(name)(_.name(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(jobSample)(_.jobSample(_))
        .build

    def createProfileJobResponse(
      name: Option[String] = None
    ): CreateProfileJobResponse =
      CreateProfileJobResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createProjectRequest(
      datasetName: Option[String] = None,
      name: Option[String] = None,
      recipeName: Option[String] = None,
      sample: Option[Sample] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(name)(_.name(_))
        .ifSome(recipeName)(_.recipeName(_))
        .ifSome(sample)(_.sample(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProjectResponse(
      name: Option[String] = None
    ): CreateProjectResponse =
      CreateProjectResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createRecipeJobRequest(
      datasetName: Option[String] = None,
      encryptionKeyArn: Option[String] = None,
      encryptionMode: Option[String] = None,
      name: Option[String] = None,
      logSubscription: Option[String] = None,
      maxCapacity: Option[Int] = None,
      maxRetries: Option[Int] = None,
      outputs: Option[List[Output]] = None,
      projectName: Option[String] = None,
      recipeReference: Option[RecipeReference] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None,
      timeout: Option[Int] = None
    ): CreateRecipeJobRequest =
      CreateRecipeJobRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(name)(_.name(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(recipeReference)(_.recipeReference(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def createRecipeJobResponse(
      name: Option[String] = None
    ): CreateRecipeJobResponse =
      CreateRecipeJobResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createRecipeRequest(
      description: Option[String] = None,
      name: Option[String] = None,
      steps: Option[List[RecipeStep]] = None,
      tags: Option[TagMap] = None
    ): CreateRecipeRequest =
      CreateRecipeRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(steps)(_.steps(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRecipeResponse(
      name: Option[String] = None
    ): CreateRecipeResponse =
      CreateRecipeResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createScheduleRequest(
      jobNames: Option[List[JobName]] = None,
      cronExpression: Option[String] = None,
      tags: Option[TagMap] = None,
      name: Option[String] = None
    ): CreateScheduleRequest =
      CreateScheduleRequest
        .builder
        .ifSome(jobNames)(_.jobNames(_))
        .ifSome(cronExpression)(_.cronExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(name)(_.name(_))
        .build

    def createScheduleResponse(
      name: Option[String] = None
    ): CreateScheduleResponse =
      CreateScheduleResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def csvOptions(
      delimiter: Option[String] = None,
      headerRow: Option[Boolean] = None
    ): CsvOptions =
      CsvOptions
        .builder
        .ifSome(delimiter)(_.delimiter(_))
        .ifSome(headerRow)(_.headerRow(_))
        .build

    def csvOutputOptions(
      delimiter: Option[String] = None
    ): CsvOutputOptions =
      CsvOutputOptions
        .builder
        .ifSome(delimiter)(_.delimiter(_))
        .build

    def dataCatalogInputDefinition(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      tempDirectory: Option[S3Location] = None
    ): DataCatalogInputDefinition =
      DataCatalogInputDefinition
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(tempDirectory)(_.tempDirectory(_))
        .build

    def databaseInputDefinition(
      glueConnectionName: Option[String] = None,
      databaseTableName: Option[String] = None,
      tempDirectory: Option[S3Location] = None
    ): DatabaseInputDefinition =
      DatabaseInputDefinition
        .builder
        .ifSome(glueConnectionName)(_.glueConnectionName(_))
        .ifSome(databaseTableName)(_.databaseTableName(_))
        .ifSome(tempDirectory)(_.tempDirectory(_))
        .build

    def dataset(
      accountId: Option[String] = None,
      createdBy: Option[String] = None,
      createDate: Option[Date] = None,
      name: Option[String] = None,
      format: Option[String] = None,
      formatOptions: Option[FormatOptions] = None,
      input: Option[Input] = None,
      lastModifiedDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      source: Option[String] = None,
      pathOptions: Option[PathOptions] = None,
      tags: Option[TagMap] = None,
      resourceArn: Option[String] = None
    ): Dataset =
      Dataset
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(formatOptions)(_.formatOptions(_))
        .ifSome(input)(_.input(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(source)(_.source(_))
        .ifSome(pathOptions)(_.pathOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def datasetParameter(
      name: Option[String] = None,
      `type`: Option[String] = None,
      datetimeOptions: Option[DatetimeOptions] = None,
      createColumn: Option[Boolean] = None,
      filter: Option[FilterExpression] = None
    ): DatasetParameter =
      DatasetParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(datetimeOptions)(_.datetimeOptions(_))
        .ifSome(createColumn)(_.createColumn(_))
        .ifSome(filter)(_.filter(_))
        .build

    def datetimeOptions(
      format: Option[String] = None,
      timezoneOffset: Option[String] = None,
      localeCode: Option[String] = None
    ): DatetimeOptions =
      DatetimeOptions
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(timezoneOffset)(_.timezoneOffset(_))
        .ifSome(localeCode)(_.localeCode(_))
        .build

    def deleteDatasetRequest(
      name: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteDatasetResponse(
      name: Option[String] = None
    ): DeleteDatasetResponse =
      DeleteDatasetResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteJobRequest(
      name: Option[String] = None
    ): DeleteJobRequest =
      DeleteJobRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteJobResponse(
      name: Option[String] = None
    ): DeleteJobResponse =
      DeleteJobResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteProjectRequest(
      name: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteProjectResponse(
      name: Option[String] = None
    ): DeleteProjectResponse =
      DeleteProjectResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteRecipeVersionRequest(
      name: Option[String] = None,
      recipeVersion: Option[String] = None
    ): DeleteRecipeVersionRequest =
      DeleteRecipeVersionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def deleteRecipeVersionResponse(
      name: Option[String] = None,
      recipeVersion: Option[String] = None
    ): DeleteRecipeVersionResponse =
      DeleteRecipeVersionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def deleteScheduleRequest(
      name: Option[String] = None
    ): DeleteScheduleRequest =
      DeleteScheduleRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteScheduleResponse(
      name: Option[String] = None
    ): DeleteScheduleResponse =
      DeleteScheduleResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeDatasetRequest(
      name: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeDatasetResponse(
      createdBy: Option[String] = None,
      createDate: Option[Date] = None,
      name: Option[String] = None,
      format: Option[String] = None,
      formatOptions: Option[FormatOptions] = None,
      input: Option[Input] = None,
      lastModifiedDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      source: Option[String] = None,
      pathOptions: Option[PathOptions] = None,
      tags: Option[TagMap] = None,
      resourceArn: Option[String] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(formatOptions)(_.formatOptions(_))
        .ifSome(input)(_.input(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(source)(_.source(_))
        .ifSome(pathOptions)(_.pathOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeJobRequest(
      name: Option[String] = None
    ): DescribeJobRequest =
      DescribeJobRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeJobResponse(
      createDate: Option[Date] = None,
      createdBy: Option[String] = None,
      datasetName: Option[String] = None,
      encryptionKeyArn: Option[String] = None,
      encryptionMode: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      logSubscription: Option[String] = None,
      maxCapacity: Option[Int] = None,
      maxRetries: Option[Int] = None,
      outputs: Option[List[Output]] = None,
      projectName: Option[String] = None,
      recipeReference: Option[RecipeReference] = None,
      resourceArn: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None,
      timeout: Option[Int] = None,
      jobSample: Option[JobSample] = None
    ): DescribeJobResponse =
      DescribeJobResponse
        .builder
        .ifSome(createDate)(_.createDate(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(recipeReference)(_.recipeReference(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(jobSample)(_.jobSample(_))
        .build

    def describeJobRunRequest(
      name: Option[String] = None,
      runId: Option[String] = None
    ): DescribeJobRunRequest =
      DescribeJobRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .build

    def describeJobRunResponse(
      attempt: Option[Int] = None,
      completedOn: Option[Date] = None,
      datasetName: Option[String] = None,
      errorMessage: Option[String] = None,
      executionTime: Option[Int] = None,
      jobName: Option[String] = None,
      runId: Option[String] = None,
      state: Option[String] = None,
      logSubscription: Option[String] = None,
      logGroupName: Option[String] = None,
      outputs: Option[List[Output]] = None,
      recipeReference: Option[RecipeReference] = None,
      startedBy: Option[String] = None,
      startedOn: Option[Date] = None,
      jobSample: Option[JobSample] = None
    ): DescribeJobRunResponse =
      DescribeJobRunResponse
        .builder
        .ifSome(attempt)(_.attempt(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(executionTime)(_.executionTime(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(state)(_.state(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(recipeReference)(_.recipeReference(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(jobSample)(_.jobSample(_))
        .build

    def describeProjectRequest(
      name: Option[String] = None
    ): DescribeProjectRequest =
      DescribeProjectRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeProjectResponse(
      createDate: Option[Date] = None,
      createdBy: Option[String] = None,
      datasetName: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      name: Option[String] = None,
      recipeName: Option[String] = None,
      resourceArn: Option[String] = None,
      sample: Option[Sample] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None,
      sessionStatus: Option[String] = None,
      openedBy: Option[String] = None,
      openDate: Option[Date] = None
    ): DescribeProjectResponse =
      DescribeProjectResponse
        .builder
        .ifSome(createDate)(_.createDate(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(name)(_.name(_))
        .ifSome(recipeName)(_.recipeName(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(sample)(_.sample(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(sessionStatus)(_.sessionStatus(_))
        .ifSome(openedBy)(_.openedBy(_))
        .ifSome(openDate)(_.openDate(_))
        .build

    def describeRecipeRequest(
      name: Option[String] = None,
      recipeVersion: Option[String] = None
    ): DescribeRecipeRequest =
      DescribeRecipeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def describeRecipeResponse(
      createdBy: Option[String] = None,
      createDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      projectName: Option[String] = None,
      publishedBy: Option[String] = None,
      publishedDate: Option[Date] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      steps: Option[List[RecipeStep]] = None,
      tags: Option[TagMap] = None,
      resourceArn: Option[String] = None,
      recipeVersion: Option[String] = None
    ): DescribeRecipeResponse =
      DescribeRecipeResponse
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(publishedBy)(_.publishedBy(_))
        .ifSome(publishedDate)(_.publishedDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(steps)(_.steps(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def describeScheduleRequest(
      name: Option[String] = None
    ): DescribeScheduleRequest =
      DescribeScheduleRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeScheduleResponse(
      createDate: Option[Date] = None,
      createdBy: Option[String] = None,
      jobNames: Option[List[JobName]] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      resourceArn: Option[String] = None,
      cronExpression: Option[String] = None,
      tags: Option[TagMap] = None,
      name: Option[String] = None
    ): DescribeScheduleResponse =
      DescribeScheduleResponse
        .builder
        .ifSome(createDate)(_.createDate(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(jobNames)(_.jobNames(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(cronExpression)(_.cronExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(name)(_.name(_))
        .build

    def excelOptions(
      sheetNames: Option[List[SheetName]] = None,
      sheetIndexes: Option[List[SheetIndex]] = None,
      headerRow: Option[Boolean] = None
    ): ExcelOptions =
      ExcelOptions
        .builder
        .ifSome(sheetNames)(_.sheetNames(_))
        .ifSome(sheetIndexes)(_.sheetIndexes(_))
        .ifSome(headerRow)(_.headerRow(_))
        .build

    def filesLimit(
      maxFiles: Option[Int] = None,
      orderedBy: Option[String] = None,
      order: Option[String] = None
    ): FilesLimit =
      FilesLimit
        .builder
        .ifSome(maxFiles)(_.maxFiles(_))
        .ifSome(orderedBy)(_.orderedBy(_))
        .ifSome(order)(_.order(_))
        .build

    def filterExpression(
      expression: Option[String] = None,
      valuesMap: Option[ValuesMap] = None
    ): FilterExpression =
      FilterExpression
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(valuesMap)(_.valuesMap(_))
        .build

    def formatOptions(
      json: Option[JsonOptions] = None,
      excel: Option[ExcelOptions] = None,
      csv: Option[CsvOptions] = None
    ): FormatOptions =
      FormatOptions
        .builder
        .ifSome(json)(_.json(_))
        .ifSome(excel)(_.excel(_))
        .ifSome(csv)(_.csv(_))
        .build

    def input(
      s3InputDefinition: Option[S3Location] = None,
      dataCatalogInputDefinition: Option[DataCatalogInputDefinition] = None,
      databaseInputDefinition: Option[DatabaseInputDefinition] = None
    ): Input =
      Input
        .builder
        .ifSome(s3InputDefinition)(_.s3InputDefinition(_))
        .ifSome(dataCatalogInputDefinition)(_.dataCatalogInputDefinition(_))
        .ifSome(databaseInputDefinition)(_.databaseInputDefinition(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def job(
      accountId: Option[String] = None,
      createdBy: Option[String] = None,
      createDate: Option[Date] = None,
      datasetName: Option[String] = None,
      encryptionKeyArn: Option[String] = None,
      encryptionMode: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      logSubscription: Option[String] = None,
      maxCapacity: Option[Int] = None,
      maxRetries: Option[Int] = None,
      outputs: Option[List[Output]] = None,
      projectName: Option[String] = None,
      recipeReference: Option[RecipeReference] = None,
      resourceArn: Option[String] = None,
      roleArn: Option[String] = None,
      timeout: Option[Int] = None,
      tags: Option[TagMap] = None,
      jobSample: Option[JobSample] = None
    ): Job =
      Job
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(recipeReference)(_.recipeReference(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(jobSample)(_.jobSample(_))
        .build

    def jobRun(
      attempt: Option[Int] = None,
      completedOn: Option[Date] = None,
      datasetName: Option[String] = None,
      errorMessage: Option[String] = None,
      executionTime: Option[Int] = None,
      jobName: Option[String] = None,
      runId: Option[String] = None,
      state: Option[String] = None,
      logSubscription: Option[String] = None,
      logGroupName: Option[String] = None,
      outputs: Option[List[Output]] = None,
      recipeReference: Option[RecipeReference] = None,
      startedBy: Option[String] = None,
      startedOn: Option[Date] = None,
      jobSample: Option[JobSample] = None
    ): JobRun =
      JobRun
        .builder
        .ifSome(attempt)(_.attempt(_))
        .ifSome(completedOn)(_.completedOn(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(executionTime)(_.executionTime(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(runId)(_.runId(_))
        .ifSome(state)(_.state(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(recipeReference)(_.recipeReference(_))
        .ifSome(startedBy)(_.startedBy(_))
        .ifSome(startedOn)(_.startedOn(_))
        .ifSome(jobSample)(_.jobSample(_))
        .build

    def jobSample(
      mode: Option[String] = None,
      size: Option[JobSize] = None
    ): JobSample =
      JobSample
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(size)(_.size(_))
        .build

    def jsonOptions(
      multiLine: Option[Boolean] = None
    ): JsonOptions =
      JsonOptions
        .builder
        .ifSome(multiLine)(_.multiLine(_))
        .build

    def listDatasetsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDatasetsRequest =
      ListDatasetsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetsResponse(
      datasets: Option[List[Dataset]] = None,
      nextToken: Option[String] = None
    ): ListDatasetsResponse =
      ListDatasetsResponse
        .builder
        .ifSome(datasets)(_.datasets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobRunsRequest(
      name: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobRunsRequest =
      ListJobRunsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobRunsResponse(
      jobRuns: Option[List[JobRun]] = None,
      nextToken: Option[String] = None
    ): ListJobRunsResponse =
      ListJobRunsResponse
        .builder
        .ifSome(jobRuns)(_.jobRuns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      datasetName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      projectName: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(projectName)(_.projectName(_))
        .build

    def listJobsResponse(
      jobs: Option[List[Job]] = None,
      nextToken: Option[String] = None
    ): ListJobsResponse =
      ListJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProjectsResponse(
      projects: Option[List[Project]] = None,
      nextToken: Option[String] = None
    ): ListProjectsResponse =
      ListProjectsResponse
        .builder
        .ifSome(projects)(_.projects(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecipeVersionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      name: Option[String] = None
    ): ListRecipeVersionsRequest =
      ListRecipeVersionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(name)(_.name(_))
        .build

    def listRecipeVersionsResponse(
      nextToken: Option[String] = None,
      recipes: Option[List[Recipe]] = None
    ): ListRecipeVersionsResponse =
      ListRecipeVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recipes)(_.recipes(_))
        .build

    def listRecipesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      recipeVersion: Option[String] = None
    ): ListRecipesRequest =
      ListRecipesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def listRecipesResponse(
      recipes: Option[List[Recipe]] = None,
      nextToken: Option[String] = None
    ): ListRecipesResponse =
      ListRecipesResponse
        .builder
        .ifSome(recipes)(_.recipes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchedulesRequest(
      jobName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSchedulesRequest =
      ListSchedulesRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSchedulesResponse(
      schedules: Option[List[Schedule]] = None,
      nextToken: Option[String] = None
    ): ListSchedulesResponse =
      ListSchedulesResponse
        .builder
        .ifSome(schedules)(_.schedules(_))
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

    def output(
      compressionFormat: Option[String] = None,
      format: Option[String] = None,
      partitionColumns: Option[List[ColumnName]] = None,
      location: Option[S3Location] = None,
      overwrite: Option[Boolean] = None,
      formatOptions: Option[OutputFormatOptions] = None
    ): Output =
      Output
        .builder
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(format)(_.format(_))
        .ifSome(partitionColumns)(_.partitionColumns(_))
        .ifSome(location)(_.location(_))
        .ifSome(overwrite)(_.overwrite(_))
        .ifSome(formatOptions)(_.formatOptions(_))
        .build

    def outputFormatOptions(
      csv: Option[CsvOutputOptions] = None
    ): OutputFormatOptions =
      OutputFormatOptions
        .builder
        .ifSome(csv)(_.csv(_))
        .build

    def pathOptions(
      lastModifiedDateCondition: Option[FilterExpression] = None,
      filesLimit: Option[FilesLimit] = None,
      parameters: Option[PathParametersMap] = None
    ): PathOptions =
      PathOptions
        .builder
        .ifSome(lastModifiedDateCondition)(_.lastModifiedDateCondition(_))
        .ifSome(filesLimit)(_.filesLimit(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def project(
      accountId: Option[String] = None,
      createDate: Option[Date] = None,
      createdBy: Option[String] = None,
      datasetName: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      name: Option[String] = None,
      recipeName: Option[String] = None,
      resourceArn: Option[String] = None,
      sample: Option[Sample] = None,
      tags: Option[TagMap] = None,
      roleArn: Option[String] = None,
      openedBy: Option[String] = None,
      openDate: Option[Date] = None
    ): Project =
      Project
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(name)(_.name(_))
        .ifSome(recipeName)(_.recipeName(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(sample)(_.sample(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(openedBy)(_.openedBy(_))
        .ifSome(openDate)(_.openDate(_))
        .build

    def publishRecipeRequest(
      description: Option[String] = None,
      name: Option[String] = None
    ): PublishRecipeRequest =
      PublishRecipeRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .build

    def publishRecipeResponse(
      name: Option[String] = None
    ): PublishRecipeResponse =
      PublishRecipeResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def recipe(
      createdBy: Option[String] = None,
      createDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      projectName: Option[String] = None,
      publishedBy: Option[String] = None,
      publishedDate: Option[Date] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      resourceArn: Option[String] = None,
      steps: Option[List[RecipeStep]] = None,
      tags: Option[TagMap] = None,
      recipeVersion: Option[String] = None
    ): Recipe =
      Recipe
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(publishedBy)(_.publishedBy(_))
        .ifSome(publishedDate)(_.publishedDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(steps)(_.steps(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def recipeAction(
      operation: Option[String] = None,
      parameters: Option[ParameterMap] = None
    ): RecipeAction =
      RecipeAction
        .builder
        .ifSome(operation)(_.operation(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def recipeReference(
      name: Option[String] = None,
      recipeVersion: Option[String] = None
    ): RecipeReference =
      RecipeReference
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def recipeStep(
      action: Option[RecipeAction] = None,
      conditionExpressions: Option[List[ConditionExpression]] = None
    ): RecipeStep =
      RecipeStep
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(conditionExpressions)(_.conditionExpressions(_))
        .build

    def recipeVersionErrorDetail(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      recipeVersion: Option[String] = None
    ): RecipeVersionErrorDetail =
      RecipeVersionErrorDetail
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(recipeVersion)(_.recipeVersion(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def sample(
      size: Option[Int] = None,
      `type`: Option[String] = None
    ): Sample =
      Sample
        .builder
        .ifSome(size)(_.size(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def schedule(
      accountId: Option[String] = None,
      createdBy: Option[String] = None,
      createDate: Option[Date] = None,
      jobNames: Option[List[JobName]] = None,
      lastModifiedBy: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      resourceArn: Option[String] = None,
      cronExpression: Option[String] = None,
      tags: Option[TagMap] = None,
      name: Option[String] = None
    ): Schedule =
      Schedule
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(jobNames)(_.jobNames(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(cronExpression)(_.cronExpression(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(name)(_.name(_))
        .build

    def sendProjectSessionActionRequest(
      preview: Option[Boolean] = None,
      name: Option[String] = None,
      recipeStep: Option[RecipeStep] = None,
      stepIndex: Option[Int] = None,
      clientSessionId: Option[String] = None,
      viewFrame: Option[ViewFrame] = None
    ): SendProjectSessionActionRequest =
      SendProjectSessionActionRequest
        .builder
        .ifSome(preview)(_.preview(_))
        .ifSome(name)(_.name(_))
        .ifSome(recipeStep)(_.recipeStep(_))
        .ifSome(stepIndex)(_.stepIndex(_))
        .ifSome(clientSessionId)(_.clientSessionId(_))
        .ifSome(viewFrame)(_.viewFrame(_))
        .build

    def sendProjectSessionActionResponse(
      result: Option[String] = None,
      name: Option[String] = None,
      actionId: Option[Int] = None
    ): SendProjectSessionActionResponse =
      SendProjectSessionActionResponse
        .builder
        .ifSome(result)(_.result(_))
        .ifSome(name)(_.name(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startJobRunRequest(
      name: Option[String] = None
    ): StartJobRunRequest =
      StartJobRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startJobRunResponse(
      runId: Option[String] = None
    ): StartJobRunResponse =
      StartJobRunResponse
        .builder
        .ifSome(runId)(_.runId(_))
        .build

    def startProjectSessionRequest(
      name: Option[String] = None,
      assumeControl: Option[Boolean] = None
    ): StartProjectSessionRequest =
      StartProjectSessionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(assumeControl)(_.assumeControl(_))
        .build

    def startProjectSessionResponse(
      name: Option[String] = None,
      clientSessionId: Option[String] = None
    ): StartProjectSessionResponse =
      StartProjectSessionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(clientSessionId)(_.clientSessionId(_))
        .build

    def stopJobRunRequest(
      name: Option[String] = None,
      runId: Option[String] = None
    ): StopJobRunRequest =
      StopJobRunRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(runId)(_.runId(_))
        .build

    def stopJobRunResponse(
      runId: Option[String] = None
    ): StopJobRunResponse =
      StopJobRunResponse
        .builder
        .ifSome(runId)(_.runId(_))
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

    def updateDatasetRequest(
      name: Option[String] = None,
      format: Option[String] = None,
      formatOptions: Option[FormatOptions] = None,
      input: Option[Input] = None,
      pathOptions: Option[PathOptions] = None
    ): UpdateDatasetRequest =
      UpdateDatasetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(formatOptions)(_.formatOptions(_))
        .ifSome(input)(_.input(_))
        .ifSome(pathOptions)(_.pathOptions(_))
        .build

    def updateDatasetResponse(
      name: Option[String] = None
    ): UpdateDatasetResponse =
      UpdateDatasetResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateProfileJobRequest(
      encryptionKeyArn: Option[String] = None,
      encryptionMode: Option[String] = None,
      name: Option[String] = None,
      logSubscription: Option[String] = None,
      maxCapacity: Option[Int] = None,
      maxRetries: Option[Int] = None,
      outputLocation: Option[S3Location] = None,
      roleArn: Option[String] = None,
      timeout: Option[Int] = None,
      jobSample: Option[JobSample] = None
    ): UpdateProfileJobRequest =
      UpdateProfileJobRequest
        .builder
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(name)(_.name(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(jobSample)(_.jobSample(_))
        .build

    def updateProfileJobResponse(
      name: Option[String] = None
    ): UpdateProfileJobResponse =
      UpdateProfileJobResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateProjectRequest(
      sample: Option[Sample] = None,
      roleArn: Option[String] = None,
      name: Option[String] = None
    ): UpdateProjectRequest =
      UpdateProjectRequest
        .builder
        .ifSome(sample)(_.sample(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(name)(_.name(_))
        .build

    def updateProjectResponse(
      lastModifiedDate: Option[Date] = None,
      name: Option[String] = None
    ): UpdateProjectResponse =
      UpdateProjectResponse
        .builder
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(name)(_.name(_))
        .build

    def updateRecipeJobRequest(
      encryptionKeyArn: Option[String] = None,
      encryptionMode: Option[String] = None,
      name: Option[String] = None,
      logSubscription: Option[String] = None,
      maxCapacity: Option[Int] = None,
      maxRetries: Option[Int] = None,
      outputs: Option[List[Output]] = None,
      roleArn: Option[String] = None,
      timeout: Option[Int] = None
    ): UpdateRecipeJobRequest =
      UpdateRecipeJobRequest
        .builder
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(name)(_.name(_))
        .ifSome(logSubscription)(_.logSubscription(_))
        .ifSome(maxCapacity)(_.maxCapacity(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def updateRecipeJobResponse(
      name: Option[String] = None
    ): UpdateRecipeJobResponse =
      UpdateRecipeJobResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateRecipeRequest(
      description: Option[String] = None,
      name: Option[String] = None,
      steps: Option[List[RecipeStep]] = None
    ): UpdateRecipeRequest =
      UpdateRecipeRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(steps)(_.steps(_))
        .build

    def updateRecipeResponse(
      name: Option[String] = None
    ): UpdateRecipeResponse =
      UpdateRecipeResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateScheduleRequest(
      jobNames: Option[List[JobName]] = None,
      cronExpression: Option[String] = None,
      name: Option[String] = None
    ): UpdateScheduleRequest =
      UpdateScheduleRequest
        .builder
        .ifSome(jobNames)(_.jobNames(_))
        .ifSome(cronExpression)(_.cronExpression(_))
        .ifSome(name)(_.name(_))
        .build

    def updateScheduleResponse(
      name: Option[String] = None
    ): UpdateScheduleResponse =
      UpdateScheduleResponse
        .builder
        .ifSome(name)(_.name(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def viewFrame(
      startColumnIndex: Option[Int] = None,
      columnRange: Option[Int] = None,
      hiddenColumns: Option[List[ColumnName]] = None
    ): ViewFrame =
      ViewFrame
        .builder
        .ifSome(startColumnIndex)(_.startColumnIndex(_))
        .ifSome(columnRange)(_.columnRange(_))
        .ifSome(hiddenColumns)(_.hiddenColumns(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
