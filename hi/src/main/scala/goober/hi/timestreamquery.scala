package goober.hi

import goober.free.timestreamquery.TimestreamQueryIO
import software.amazon.awssdk.services.timestreamquery.model._


object timestreamquery {
  import goober.free.{timestreamquery ⇒ free}

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

    def cancelQueryRequest(
      queryId: Option[String] = None
    ): CancelQueryRequest =
      CancelQueryRequest
        .builder
        .ifSome(queryId)(_.queryId(_))
        .build

    def cancelQueryResponse(
      cancellationMessage: Option[String] = None
    ): CancelQueryResponse =
      CancelQueryResponse
        .builder
        .ifSome(cancellationMessage)(_.cancellationMessage(_))
        .build

    def columnInfo(
      name: Option[String] = None,
      `type`: Option[Type] = None
    ): ColumnInfo =
      ColumnInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def datum(
      scalarValue: Option[String] = None,
      timeSeriesValue: Option[List[TimeSeriesDataPoint]] = None,
      arrayValue: Option[List[Datum]] = None,
      rowValue: Option[Row] = None,
      nullValue: Option[Boolean] = None
    ): Datum =
      Datum
        .builder
        .ifSome(scalarValue)(_.scalarValue(_))
        .ifSome(timeSeriesValue)(_.timeSeriesValue(_))
        .ifSome(arrayValue)(_.arrayValue(_))
        .ifSome(rowValue)(_.rowValue(_))
        .ifSome(nullValue)(_.nullValue(_))
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

    def queryExecutionException(
      message: Option[String] = None
    ): QueryExecutionException =
      QueryExecutionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def queryRequest(
      queryString: Option[String] = None,
      clientToken: Option[String] = None,
      nextToken: Option[String] = None,
      maxRows: Option[Int] = None
    ): QueryRequest =
      QueryRequest
        .builder
        .ifSome(queryString)(_.queryString(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxRows)(_.maxRows(_))
        .build

    def queryResponse(
      queryId: Option[String] = None,
      nextToken: Option[String] = None,
      rows: Option[List[Row]] = None,
      columnInfo: Option[List[ColumnInfo]] = None,
      queryStatus: Option[QueryStatus] = None
    ): QueryResponse =
      QueryResponse
        .builder
        .ifSome(queryId)(_.queryId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(rows)(_.rows(_))
        .ifSome(columnInfo)(_.columnInfo(_))
        .ifSome(queryStatus)(_.queryStatus(_))
        .build

    def queryStatus(
      progressPercentage: Option[Double] = None,
      cumulativeBytesScanned: Option[Long] = None,
      cumulativeBytesMetered: Option[Long] = None
    ): QueryStatus =
      QueryStatus
        .builder
        .ifSome(progressPercentage)(_.progressPercentage(_))
        .ifSome(cumulativeBytesScanned)(_.cumulativeBytesScanned(_))
        .ifSome(cumulativeBytesMetered)(_.cumulativeBytesMetered(_))
        .build

    def row(
      data: Option[List[Datum]] = None
    ): Row =
      Row
        .builder
        .ifSome(data)(_.data(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timeSeriesDataPoint(
      time: Option[String] = None,
      value: Option[Datum] = None
    ): TimeSeriesDataPoint =
      TimeSeriesDataPoint
        .builder
        .ifSome(time)(_.time(_))
        .ifSome(value)(_.value(_))
        .build

    def type(
      scalarType: Option[String] = None,
      arrayColumnInfo: Option[ColumnInfo] = None,
      timeSeriesMeasureValueColumnInfo: Option[ColumnInfo] = None,
      rowColumnInfo: Option[List[ColumnInfo]] = None
    ): Type =
      Type
        .builder
        .ifSome(scalarType)(_.scalarType(_))
        .ifSome(arrayColumnInfo)(_.arrayColumnInfo(_))
        .ifSome(timeSeriesMeasureValueColumnInfo)(_.timeSeriesMeasureValueColumnInfo(_))
        .ifSome(rowColumnInfo)(_.rowColumnInfo(_))
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
