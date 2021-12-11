package goober.hi

import goober.free.marketplaceentitlement.MarketplaceEntitlementIO
import software.amazon.awssdk.services.marketplaceentitlement.model._


object marketplaceentitlement {
  import goober.free.{marketplaceentitlement ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def entitlement(
      productCode: Option[String] = None,
      dimension: Option[String] = None,
      customerIdentifier: Option[String] = None,
      value: Option[EntitlementValue] = None,
      expirationDate: Option[Timestamp] = None
    ): Entitlement =
      Entitlement
        .builder
        .ifSome(productCode)(_.productCode(_))
        .ifSome(dimension)(_.dimension(_))
        .ifSome(customerIdentifier)(_.customerIdentifier(_))
        .ifSome(value)(_.value(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .build

    def entitlementValue(
      integerValue: Option[Int] = None,
      doubleValue: Option[Double] = None,
      booleanValue: Option[Boolean] = None,
      stringValue: Option[String] = None
    ): EntitlementValue =
      EntitlementValue
        .builder
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .ifSome(stringValue)(_.stringValue(_))
        .build

    def getEntitlementsRequest(
      productCode: Option[String] = None,
      filter: Option[GetEntitlementFilters] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEntitlementsRequest =
      GetEntitlementsRequest
        .builder
        .ifSome(productCode)(_.productCode(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
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

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
