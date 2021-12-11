package goober.hi

import goober.free.pricing.PricingIO
import software.amazon.awssdk.services.pricing.model._


object pricing {
  import goober.free.{pricing ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def attributeValue(
      value: Option[String] = None
    ): AttributeValue =
      AttributeValue
        .builder
        .ifSome(value)(_.value(_))
        .build

    def describeServicesRequest(
      serviceCode: Option[String] = None,
      formatVersion: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeServicesRequest =
      DescribeServicesRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(formatVersion)(_.formatVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeServicesResponse(
      services: Option[List[Service]] = None,
      formatVersion: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeServicesResponse =
      DescribeServicesResponse
        .builder
        .ifSome(services)(_.services(_))
        .ifSome(formatVersion)(_.formatVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def expiredNextTokenException(
      message: Option[String] = None
    ): ExpiredNextTokenException =
      ExpiredNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def filter(
      `type`: Option[String] = None,
      field: Option[String] = None,
      value: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(field)(_.field(_))
        .ifSome(value)(_.value(_))
        .build

    def getAttributeValuesRequest(
      serviceCode: Option[String] = None,
      attributeName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAttributeValuesRequest =
      GetAttributeValuesRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getAttributeValuesResponse(
      attributeValues: Option[List[AttributeValue]] = None,
      nextToken: Option[String] = None
    ): GetAttributeValuesResponse =
      GetAttributeValuesResponse
        .builder
        .ifSome(attributeValues)(_.attributeValues(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getProductsRequest(
      serviceCode: Option[String] = None,
      filters: Option[List[Filter]] = None,
      formatVersion: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetProductsRequest =
      GetProductsRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(formatVersion)(_.formatVersion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getProductsResponse(
      formatVersion: Option[String] = None,
      priceList: Option[List[PriceListItemJSON]] = None,
      nextToken: Option[String] = None
    ): GetProductsResponse =
      GetProductsResponse
        .builder
        .ifSome(formatVersion)(_.formatVersion(_))
        .ifSome(priceList)(_.priceList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def service(
      serviceCode: Option[String] = None,
      attributeNames: Option[List[String]] = None
    ): Service =
      Service
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
