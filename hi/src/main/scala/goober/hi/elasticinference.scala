package goober.hi

import goober.free.elasticinference.ElasticInferenceIO
import software.amazon.awssdk.services.elasticinference.model._


object elasticinference {
  import goober.free.{elasticinference ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceleratorType(
      acceleratorTypeName: Option[String] = None,
      memoryInfo: Option[MemoryInfo] = None,
      throughputInfo: Option[List[KeyValuePair]] = None
    ): AcceleratorType =
      AcceleratorType
        .builder
        .ifSome(acceleratorTypeName)(_.acceleratorTypeName(_))
        .ifSome(memoryInfo)(_.memoryInfo(_))
        .ifSome(throughputInfo)(_.throughputInfo(_))
        .build

    def acceleratorTypeOffering(
      acceleratorType: Option[String] = None,
      locationType: Option[String] = None,
      location: Option[String] = None
    ): AcceleratorTypeOffering =
      AcceleratorTypeOffering
        .builder
        .ifSome(acceleratorType)(_.acceleratorType(_))
        .ifSome(locationType)(_.locationType(_))
        .ifSome(location)(_.location(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def describeAcceleratorOfferingsRequest(
      locationType: Option[String] = None,
      acceleratorTypes: Option[List[AcceleratorTypeName]] = None
    ): DescribeAcceleratorOfferingsRequest =
      DescribeAcceleratorOfferingsRequest
        .builder
        .ifSome(locationType)(_.locationType(_))
        .ifSome(acceleratorTypes)(_.acceleratorTypes(_))
        .build

    def describeAcceleratorOfferingsResponse(
      acceleratorTypeOfferings: Option[List[AcceleratorTypeOffering]] = None
    ): DescribeAcceleratorOfferingsResponse =
      DescribeAcceleratorOfferingsResponse
        .builder
        .ifSome(acceleratorTypeOfferings)(_.acceleratorTypeOfferings(_))
        .build

    def describeAcceleratorTypesRequest(

    ): DescribeAcceleratorTypesRequest =
      DescribeAcceleratorTypesRequest
        .builder

        .build

    def describeAcceleratorTypesResponse(
      acceleratorTypes: Option[List[AcceleratorType]] = None
    ): DescribeAcceleratorTypesResponse =
      DescribeAcceleratorTypesResponse
        .builder
        .ifSome(acceleratorTypes)(_.acceleratorTypes(_))
        .build

    def describeAcceleratorsRequest(
      acceleratorIds: Option[List[AcceleratorId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeAcceleratorsRequest =
      DescribeAcceleratorsRequest
        .builder
        .ifSome(acceleratorIds)(_.acceleratorIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAcceleratorsResponse(
      acceleratorSet: Option[List[ElasticInferenceAccelerator]] = None,
      nextToken: Option[String] = None
    ): DescribeAcceleratorsResponse =
      DescribeAcceleratorsResponse
        .builder
        .ifSome(acceleratorSet)(_.acceleratorSet(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def elasticInferenceAccelerator(
      acceleratorHealth: Option[ElasticInferenceAcceleratorHealth] = None,
      acceleratorType: Option[String] = None,
      acceleratorId: Option[String] = None,
      availabilityZone: Option[String] = None,
      attachedResource: Option[String] = None
    ): ElasticInferenceAccelerator =
      ElasticInferenceAccelerator
        .builder
        .ifSome(acceleratorHealth)(_.acceleratorHealth(_))
        .ifSome(acceleratorType)(_.acceleratorType(_))
        .ifSome(acceleratorId)(_.acceleratorId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(attachedResource)(_.attachedResource(_))
        .build

    def elasticInferenceAcceleratorHealth(
      status: Option[String] = None
    ): ElasticInferenceAcceleratorHealth =
      ElasticInferenceAcceleratorHealth
        .builder
        .ifSome(status)(_.status(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyValuePair(
      key: Option[String] = None,
      value: Option[Int] = None
    ): KeyValuePair =
      KeyValuePair
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def memoryInfo(
      sizeInMiB: Option[Int] = None
    ): MemoryInfo =
      MemoryInfo
        .builder
        .ifSome(sizeInMiB)(_.sizeInMiB(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
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

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
