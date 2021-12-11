package goober.hi

import goober.free.marketplacemetering.MarketplaceMeteringIO
import software.amazon.awssdk.services.marketplacemetering.model._


object marketplacemetering {
  import goober.free.{marketplacemetering ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def batchMeterUsageRequest(
      usageRecords: Option[List[UsageRecord]] = None,
      productCode: Option[String] = None
    ): BatchMeterUsageRequest =
      BatchMeterUsageRequest
        .builder
        .ifSome(usageRecords)(_.usageRecords(_))
        .ifSome(productCode)(_.productCode(_))
        .build

    def customerNotEntitledException(
      message: Option[String] = None
    ): CustomerNotEntitledException =
      CustomerNotEntitledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def disabledApiException(
      message: Option[String] = None
    ): DisabledApiException =
      DisabledApiException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateRequestException(
      message: Option[String] = None
    ): DuplicateRequestException =
      DuplicateRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def expiredTokenException(
      message: Option[String] = None
    ): ExpiredTokenException =
      ExpiredTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServiceErrorException(
      message: Option[String] = None
    ): InternalServiceErrorException =
      InternalServiceErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCustomerIdentifierException(
      message: Option[String] = None
    ): InvalidCustomerIdentifierException =
      InvalidCustomerIdentifierException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidEndpointRegionException(
      message: Option[String] = None
    ): InvalidEndpointRegionException =
      InvalidEndpointRegionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidProductCodeException(
      message: Option[String] = None
    ): InvalidProductCodeException =
      InvalidProductCodeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPublicKeyVersionException(
      message: Option[String] = None
    ): InvalidPublicKeyVersionException =
      InvalidPublicKeyVersionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRegionException(
      message: Option[String] = None
    ): InvalidRegionException =
      InvalidRegionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTagException(
      message: Option[String] = None
    ): InvalidTagException =
      InvalidTagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidTokenException(
      message: Option[String] = None
    ): InvalidTokenException =
      InvalidTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidUsageAllocationsException(
      message: Option[String] = None
    ): InvalidUsageAllocationsException =
      InvalidUsageAllocationsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidUsageDimensionException(
      message: Option[String] = None
    ): InvalidUsageDimensionException =
      InvalidUsageDimensionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def meterUsageRequest(
      productCode: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      usageDimension: Option[String] = None,
      usageQuantity: Option[Int] = None,
      usageAllocations: Option[List[UsageAllocation]] = None
    ): MeterUsageRequest =
      MeterUsageRequest
        .builder
        .ifSome(productCode)(_.productCode(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(usageDimension)(_.usageDimension(_))
        .ifSome(usageQuantity)(_.usageQuantity(_))
        .ifSome(usageAllocations)(_.usageAllocations(_))
        .build

    def platformNotSupportedException(
      message: Option[String] = None
    ): PlatformNotSupportedException =
      PlatformNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def registerUsageRequest(
      productCode: Option[String] = None,
      publicKeyVersion: Option[Int] = None,
      nonce: Option[String] = None
    ): RegisterUsageRequest =
      RegisterUsageRequest
        .builder
        .ifSome(productCode)(_.productCode(_))
        .ifSome(publicKeyVersion)(_.publicKeyVersion(_))
        .ifSome(nonce)(_.nonce(_))
        .build

    def resolveCustomerRequest(
      registrationToken: Option[String] = None
    ): ResolveCustomerRequest =
      ResolveCustomerRequest
        .builder
        .ifSome(registrationToken)(_.registrationToken(_))
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

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timestampOutOfBoundsException(
      message: Option[String] = None
    ): TimestampOutOfBoundsException =
      TimestampOutOfBoundsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def usageAllocation(
      allocatedUsageQuantity: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): UsageAllocation =
      UsageAllocation
        .builder
        .ifSome(allocatedUsageQuantity)(_.allocatedUsageQuantity(_))
        .ifSome(tags)(_.tags(_))
        .build

    def usageRecord(
      timestamp: Option[Timestamp] = None,
      customerIdentifier: Option[String] = None,
      dimension: Option[String] = None,
      quantity: Option[Int] = None,
      usageAllocations: Option[List[UsageAllocation]] = None
    ): UsageRecord =
      UsageRecord
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(customerIdentifier)(_.customerIdentifier(_))
        .ifSome(dimension)(_.dimension(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(usageAllocations)(_.usageAllocations(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
