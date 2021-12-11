package goober.hi

import goober.free.pi.PiIO
import software.amazon.awssdk.services.pi.model._


object pi {
  import goober.free.{pi ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def dataPoint(
      timestamp: Option[ISOTimestamp] = None,
      value: Option[Double] = None
    ): DataPoint =
      DataPoint
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(value)(_.value(_))
        .build

    def describeDimensionKeysRequest(
      serviceType: Option[String] = None,
      identifier: Option[String] = None,
      startTime: Option[ISOTimestamp] = None,
      endTime: Option[ISOTimestamp] = None,
      metric: Option[String] = None,
      periodInSeconds: Option[Int] = None,
      groupBy: Option[DimensionGroup] = None,
      partitionBy: Option[DimensionGroup] = None,
      filter: Option[MetricQueryFilterMap] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDimensionKeysRequest =
      DescribeDimensionKeysRequest
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(metric)(_.metric(_))
        .ifSome(periodInSeconds)(_.periodInSeconds(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(partitionBy)(_.partitionBy(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDimensionKeysResponse(
      alignedStartTime: Option[ISOTimestamp] = None,
      alignedEndTime: Option[ISOTimestamp] = None,
      partitionKeys: Option[List[ResponsePartitionKey]] = None,
      keys: Option[List[DimensionKeyDescription]] = None,
      nextToken: Option[String] = None
    ): DescribeDimensionKeysResponse =
      DescribeDimensionKeysResponse
        .builder
        .ifSome(alignedStartTime)(_.alignedStartTime(_))
        .ifSome(alignedEndTime)(_.alignedEndTime(_))
        .ifSome(partitionKeys)(_.partitionKeys(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def dimensionGroup(
      group: Option[String] = None,
      dimensions: Option[List[RequestString]] = None,
      limit: Option[Int] = None
    ): DimensionGroup =
      DimensionGroup
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(limit)(_.limit(_))
        .build

    def dimensionKeyDescription(
      dimensions: Option[DimensionMap] = None,
      total: Option[Double] = None,
      partitions: Option[List[Double]] = None
    ): DimensionKeyDescription =
      DimensionKeyDescription
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(total)(_.total(_))
        .ifSome(partitions)(_.partitions(_))
        .build

    def dimensionKeyDetail(
      value: Option[String] = None,
      dimension: Option[String] = None,
      status: Option[String] = None
    ): DimensionKeyDetail =
      DimensionKeyDetail
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(dimension)(_.dimension(_))
        .ifSome(status)(_.status(_))
        .build

    def getDimensionKeyDetailsRequest(
      serviceType: Option[String] = None,
      identifier: Option[String] = None,
      group: Option[String] = None,
      groupIdentifier: Option[String] = None,
      requestedDimensions: Option[List[RequestString]] = None
    ): GetDimensionKeyDetailsRequest =
      GetDimensionKeyDetailsRequest
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(group)(_.group(_))
        .ifSome(groupIdentifier)(_.groupIdentifier(_))
        .ifSome(requestedDimensions)(_.requestedDimensions(_))
        .build

    def getDimensionKeyDetailsResponse(
      dimensions: Option[List[DimensionKeyDetail]] = None
    ): GetDimensionKeyDetailsResponse =
      GetDimensionKeyDetailsResponse
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def getResourceMetricsRequest(
      serviceType: Option[String] = None,
      identifier: Option[String] = None,
      metricQueries: Option[List[MetricQuery]] = None,
      startTime: Option[ISOTimestamp] = None,
      endTime: Option[ISOTimestamp] = None,
      periodInSeconds: Option[Int] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetResourceMetricsRequest =
      GetResourceMetricsRequest
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(metricQueries)(_.metricQueries(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(periodInSeconds)(_.periodInSeconds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceMetricsResponse(
      alignedStartTime: Option[ISOTimestamp] = None,
      alignedEndTime: Option[ISOTimestamp] = None,
      identifier: Option[String] = None,
      metricList: Option[List[MetricKeyDataPoints]] = None,
      nextToken: Option[String] = None
    ): GetResourceMetricsResponse =
      GetResourceMetricsResponse
        .builder
        .ifSome(alignedStartTime)(_.alignedStartTime(_))
        .ifSome(alignedEndTime)(_.alignedEndTime(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(metricList)(_.metricList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalServiceError(
      message: Option[String] = None
    ): InternalServiceError =
      InternalServiceError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def metricKeyDataPoints(
      key: Option[ResponseResourceMetricKey] = None,
      dataPoints: Option[List[DataPoint]] = None
    ): MetricKeyDataPoints =
      MetricKeyDataPoints
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(dataPoints)(_.dataPoints(_))
        .build

    def metricQuery(
      metric: Option[String] = None,
      groupBy: Option[DimensionGroup] = None,
      filter: Option[MetricQueryFilterMap] = None
    ): MetricQuery =
      MetricQuery
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(filter)(_.filter(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def responsePartitionKey(
      dimensions: Option[DimensionMap] = None
    ): ResponsePartitionKey =
      ResponsePartitionKey
        .builder
        .ifSome(dimensions)(_.dimensions(_))
        .build

    def responseResourceMetricKey(
      metric: Option[String] = None,
      dimensions: Option[DimensionMap] = None
    ): ResponseResourceMetricKey =
      ResponseResourceMetricKey
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(dimensions)(_.dimensions(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
