package goober.hi

import goober.free.timestreamwrite.TimestreamWriteIO
import software.amazon.awssdk.services.timestreamwrite.model._


object timestreamwrite {
  import goober.free.{timestreamwrite ⇒ free}

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

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createDatabaseRequest(
      databaseName: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDatabaseRequest =
      CreateDatabaseRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDatabaseResponse(
      database: Option[Database] = None
    ): CreateDatabaseResponse =
      CreateDatabaseResponse
        .builder
        .ifSome(database)(_.database(_))
        .build

    def createTableRequest(
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      retentionProperties: Option[RetentionProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateTableRequest =
      CreateTableRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(retentionProperties)(_.retentionProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTableResponse(
      table: Option[Table] = None
    ): CreateTableResponse =
      CreateTableResponse
        .builder
        .ifSome(table)(_.table(_))
        .build

    def database(
      arn: Option[String] = None,
      databaseName: Option[String] = None,
      tableCount: Option[Long] = None,
      kmsKeyId: Option[String] = None,
      creationTime: Option[Date] = None,
      lastUpdatedTime: Option[Date] = None
    ): Database =
      Database
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableCount)(_.tableCount(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def deleteDatabaseRequest(
      databaseName: Option[String] = None
    ): DeleteDatabaseRequest =
      DeleteDatabaseRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def deleteTableRequest(
      databaseName: Option[String] = None,
      tableName: Option[String] = None
    ): DeleteTableRequest =
      DeleteTableRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeDatabaseRequest(
      databaseName: Option[String] = None
    ): DescribeDatabaseRequest =
      DescribeDatabaseRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def describeDatabaseResponse(
      database: Option[Database] = None
    ): DescribeDatabaseResponse =
      DescribeDatabaseResponse
        .builder
        .ifSome(database)(_.database(_))
        .build

    def describeEndpointsRequest(

    ): DescribeEndpointsRequest =
      DescribeEndpointsRequest
        .builder

        .build

    def describeEndpointsResponse(
      endpoints: Option[List[Endpoint]] = None
    ): DescribeEndpointsResponse =
      DescribeEndpointsResponse
        .builder
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def describeTableRequest(
      databaseName: Option[String] = None,
      tableName: Option[String] = None
    ): DescribeTableRequest =
      DescribeTableRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeTableResponse(
      table: Option[Table] = None
    ): DescribeTableResponse =
      DescribeTableResponse
        .builder
        .ifSome(table)(_.table(_))
        .build

    def dimension(
      name: Option[String] = None,
      value: Option[String] = None,
      dimensionValueType: Option[String] = None
    ): Dimension =
      Dimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(dimensionValueType)(_.dimensionValueType(_))
        .build

    def endpoint(
      address: Option[String] = None,
      cachePeriodInMinutes: Option[Long] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(cachePeriodInMinutes)(_.cachePeriodInMinutes(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidEndpointException(
      message: Option[String] = None
    ): InvalidEndpointException =
      InvalidEndpointException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDatabasesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatabasesRequest =
      ListDatabasesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatabasesResponse(
      databases: Option[List[Database]] = None,
      nextToken: Option[String] = None
    ): ListDatabasesResponse =
      ListDatabasesResponse
        .builder
        .ifSome(databases)(_.databases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTablesRequest(
      databaseName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTablesRequest =
      ListTablesRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTablesResponse(
      tables: Option[List[Table]] = None,
      nextToken: Option[String] = None
    ): ListTablesResponse =
      ListTablesResponse
        .builder
        .ifSome(tables)(_.tables(_))
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

    def record(
      dimensions: Option[List[Dimension]] = None,
      measureName: Option[String] = None,
      measureValue: Option[String] = None,
      measureValueType: Option[String] = None,
      time: Option[String] = None,
      timeUnit: Option[String] = None,
      version: Option[RecordVersion] = None
    ): Record =
      Record
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(measureName)(_.measureName(_))
        .ifSome(measureValue)(_.measureValue(_))
        .ifSome(measureValueType)(_.measureValueType(_))
        .ifSome(time)(_.time(_))
        .ifSome(timeUnit)(_.timeUnit(_))
        .ifSome(version)(_.version(_))
        .build

    def rejectedRecord(
      recordIndex: Option[Int] = None,
      reason: Option[String] = None,
      existingVersion: Option[RecordVersion] = None
    ): RejectedRecord =
      RejectedRecord
        .builder
        .ifSome(recordIndex)(_.recordIndex(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(existingVersion)(_.existingVersion(_))
        .build

    def rejectedRecordsException(
      message: Option[String] = None,
      rejectedRecords: Option[List[RejectedRecord]] = None
    ): RejectedRecordsException =
      RejectedRecordsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(rejectedRecords)(_.rejectedRecords(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def retentionProperties(
      memoryStoreRetentionPeriodInHours: Option[MemoryStoreRetentionPeriodInHours] = None,
      magneticStoreRetentionPeriodInDays: Option[MagneticStoreRetentionPeriodInDays] = None
    ): RetentionProperties =
      RetentionProperties
        .builder
        .ifSome(memoryStoreRetentionPeriodInHours)(_.memoryStoreRetentionPeriodInHours(_))
        .ifSome(magneticStoreRetentionPeriodInDays)(_.magneticStoreRetentionPeriodInDays(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def table(
      arn: Option[String] = None,
      tableName: Option[String] = None,
      databaseName: Option[String] = None,
      tableStatus: Option[String] = None,
      retentionProperties: Option[RetentionProperties] = None,
      creationTime: Option[Date] = None,
      lastUpdatedTime: Option[Date] = None
    ): Table =
      Table
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableStatus)(_.tableStatus(_))
        .ifSome(retentionProperties)(_.retentionProperties(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
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

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateDatabaseRequest(
      databaseName: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): UpdateDatabaseRequest =
      UpdateDatabaseRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def updateDatabaseResponse(
      database: Option[Database] = None
    ): UpdateDatabaseResponse =
      UpdateDatabaseResponse
        .builder
        .ifSome(database)(_.database(_))
        .build

    def updateTableRequest(
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      retentionProperties: Option[RetentionProperties] = None
    ): UpdateTableRequest =
      UpdateTableRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(retentionProperties)(_.retentionProperties(_))
        .build

    def updateTableResponse(
      table: Option[Table] = None
    ): UpdateTableResponse =
      UpdateTableResponse
        .builder
        .ifSome(table)(_.table(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def writeRecordsRequest(
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      commonAttributes: Option[Record] = None,
      records: Option[List[Record]] = None
    ): WriteRecordsRequest =
      WriteRecordsRequest
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(commonAttributes)(_.commonAttributes(_))
        .ifSome(records)(_.records(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
