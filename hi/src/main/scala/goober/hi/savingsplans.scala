package goober.hi

import goober.free.savingsplans.SavingsplansIO
import software.amazon.awssdk.services.savingsplans.model._


object savingsplans {
  import goober.free.{savingsplans ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def createSavingsPlanRequest(
      savingsPlanOfferingId: Option[String] = None,
      commitment: Option[String] = None,
      upfrontPaymentAmount: Option[String] = None,
      purchaseTime: Option[DateTime] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateSavingsPlanRequest =
      CreateSavingsPlanRequest
        .builder
        .ifSome(savingsPlanOfferingId)(_.savingsPlanOfferingId(_))
        .ifSome(commitment)(_.commitment(_))
        .ifSome(upfrontPaymentAmount)(_.upfrontPaymentAmount(_))
        .ifSome(purchaseTime)(_.purchaseTime(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSavingsPlanResponse(
      savingsPlanId: Option[String] = None
    ): CreateSavingsPlanResponse =
      CreateSavingsPlanResponse
        .builder
        .ifSome(savingsPlanId)(_.savingsPlanId(_))
        .build

    def deleteQueuedSavingsPlanRequest(
      savingsPlanId: Option[String] = None
    ): DeleteQueuedSavingsPlanRequest =
      DeleteQueuedSavingsPlanRequest
        .builder
        .ifSome(savingsPlanId)(_.savingsPlanId(_))
        .build

    def deleteQueuedSavingsPlanResponse(

    ): DeleteQueuedSavingsPlanResponse =
      DeleteQueuedSavingsPlanResponse
        .builder

        .build

    def describeSavingsPlanRatesRequest(
      savingsPlanId: Option[String] = None,
      filters: Option[List[SavingsPlanRateFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeSavingsPlanRatesRequest =
      DescribeSavingsPlanRatesRequest
        .builder
        .ifSome(savingsPlanId)(_.savingsPlanId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSavingsPlanRatesResponse(
      savingsPlanId: Option[String] = None,
      searchResults: Option[List[SavingsPlanRate]] = None,
      nextToken: Option[String] = None
    ): DescribeSavingsPlanRatesResponse =
      DescribeSavingsPlanRatesResponse
        .builder
        .ifSome(savingsPlanId)(_.savingsPlanId(_))
        .ifSome(searchResults)(_.searchResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSavingsPlansOfferingRatesRequest(
      savingsPlanOfferingIds: Option[List[UUID]] = None,
      savingsPlanPaymentOptions: Option[List[SavingsPlanPaymentOption]] = None,
      savingsPlanTypes: Option[List[SavingsPlanType]] = None,
      products: Option[List[SavingsPlanProductType]] = None,
      serviceCodes: Option[List[SavingsPlanRateServiceCode]] = None,
      usageTypes: Option[List[SavingsPlanRateUsageType]] = None,
      operations: Option[List[SavingsPlanRateOperation]] = None,
      filters: Option[List[SavingsPlanOfferingRateFilterElement]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeSavingsPlansOfferingRatesRequest =
      DescribeSavingsPlansOfferingRatesRequest
        .builder
        .ifSome(savingsPlanOfferingIds)(_.savingsPlanOfferingIds(_))
        .ifSome(savingsPlanPaymentOptions)(_.savingsPlanPaymentOptions(_))
        .ifSome(savingsPlanTypes)(_.savingsPlanTypes(_))
        .ifSome(products)(_.products(_))
        .ifSome(serviceCodes)(_.serviceCodes(_))
        .ifSome(usageTypes)(_.usageTypes(_))
        .ifSome(operations)(_.operations(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSavingsPlansOfferingRatesResponse(
      searchResults: Option[List[SavingsPlanOfferingRate]] = None,
      nextToken: Option[String] = None
    ): DescribeSavingsPlansOfferingRatesResponse =
      DescribeSavingsPlansOfferingRatesResponse
        .builder
        .ifSome(searchResults)(_.searchResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSavingsPlansOfferingsRequest(
      offeringIds: Option[List[UUID]] = None,
      paymentOptions: Option[List[SavingsPlanPaymentOption]] = None,
      productType: Option[String] = None,
      planTypes: Option[List[SavingsPlanType]] = None,
      durations: Option[List[SavingsPlansDuration]] = None,
      currencies: Option[List[CurrencyCode]] = None,
      descriptions: Option[List[SavingsPlanDescription]] = None,
      serviceCodes: Option[List[SavingsPlanServiceCode]] = None,
      usageTypes: Option[List[SavingsPlanUsageType]] = None,
      operations: Option[List[SavingsPlanOperation]] = None,
      filters: Option[List[SavingsPlanOfferingFilterElement]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeSavingsPlansOfferingsRequest =
      DescribeSavingsPlansOfferingsRequest
        .builder
        .ifSome(offeringIds)(_.offeringIds(_))
        .ifSome(paymentOptions)(_.paymentOptions(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(planTypes)(_.planTypes(_))
        .ifSome(durations)(_.durations(_))
        .ifSome(currencies)(_.currencies(_))
        .ifSome(descriptions)(_.descriptions(_))
        .ifSome(serviceCodes)(_.serviceCodes(_))
        .ifSome(usageTypes)(_.usageTypes(_))
        .ifSome(operations)(_.operations(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSavingsPlansOfferingsResponse(
      searchResults: Option[List[SavingsPlanOffering]] = None,
      nextToken: Option[String] = None
    ): DescribeSavingsPlansOfferingsResponse =
      DescribeSavingsPlansOfferingsResponse
        .builder
        .ifSome(searchResults)(_.searchResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSavingsPlansRequest(
      savingsPlanArns: Option[List[SavingsPlanArn]] = None,
      savingsPlanIds: Option[List[SavingsPlanId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      states: Option[List[SavingsPlanState]] = None,
      filters: Option[List[SavingsPlanFilter]] = None
    ): DescribeSavingsPlansRequest =
      DescribeSavingsPlansRequest
        .builder
        .ifSome(savingsPlanArns)(_.savingsPlanArns(_))
        .ifSome(savingsPlanIds)(_.savingsPlanIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(states)(_.states(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeSavingsPlansResponse(
      savingsPlans: Option[List[SavingsPlan]] = None,
      nextToken: Option[String] = None
    ): DescribeSavingsPlansResponse =
      DescribeSavingsPlansResponse
        .builder
        .ifSome(savingsPlans)(_.savingsPlans(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
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

    def parentSavingsPlanOffering(
      offeringId: Option[String] = None,
      paymentOption: Option[String] = None,
      planType: Option[String] = None,
      durationSeconds: Option[SavingsPlansDuration] = None,
      currency: Option[String] = None,
      planDescription: Option[String] = None
    ): ParentSavingsPlanOffering =
      ParentSavingsPlanOffering
        .builder
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(planType)(_.planType(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(currency)(_.currency(_))
        .ifSome(planDescription)(_.planDescription(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def savingsPlan(
      offeringId: Option[String] = None,
      savingsPlanId: Option[String] = None,
      savingsPlanArn: Option[String] = None,
      description: Option[String] = None,
      start: Option[String] = None,
      end: Option[String] = None,
      state: Option[String] = None,
      region: Option[String] = None,
      ec2InstanceFamily: Option[String] = None,
      savingsPlanType: Option[String] = None,
      paymentOption: Option[String] = None,
      productTypes: Option[List[SavingsPlanProductType]] = None,
      currency: Option[String] = None,
      commitment: Option[String] = None,
      upfrontPaymentAmount: Option[String] = None,
      recurringPaymentAmount: Option[String] = None,
      termDurationInSeconds: Option[TermDurationInSeconds] = None,
      tags: Option[TagMap] = None
    ): SavingsPlan =
      SavingsPlan
        .builder
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(savingsPlanId)(_.savingsPlanId(_))
        .ifSome(savingsPlanArn)(_.savingsPlanArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(start)(_.start(_))
        .ifSome(end)(_.end(_))
        .ifSome(state)(_.state(_))
        .ifSome(region)(_.region(_))
        .ifSome(ec2InstanceFamily)(_.ec2InstanceFamily(_))
        .ifSome(savingsPlanType)(_.savingsPlanType(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(productTypes)(_.productTypes(_))
        .ifSome(currency)(_.currency(_))
        .ifSome(commitment)(_.commitment(_))
        .ifSome(upfrontPaymentAmount)(_.upfrontPaymentAmount(_))
        .ifSome(recurringPaymentAmount)(_.recurringPaymentAmount(_))
        .ifSome(termDurationInSeconds)(_.termDurationInSeconds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def savingsPlanFilter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): SavingsPlanFilter =
      SavingsPlanFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def savingsPlanOffering(
      offeringId: Option[String] = None,
      productTypes: Option[List[SavingsPlanProductType]] = None,
      planType: Option[String] = None,
      description: Option[String] = None,
      paymentOption: Option[String] = None,
      durationSeconds: Option[SavingsPlansDuration] = None,
      currency: Option[String] = None,
      serviceCode: Option[String] = None,
      usageType: Option[String] = None,
      operation: Option[String] = None,
      properties: Option[List[SavingsPlanOfferingProperty]] = None
    ): SavingsPlanOffering =
      SavingsPlanOffering
        .builder
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(productTypes)(_.productTypes(_))
        .ifSome(planType)(_.planType(_))
        .ifSome(description)(_.description(_))
        .ifSome(paymentOption)(_.paymentOption(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(currency)(_.currency(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(usageType)(_.usageType(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(properties)(_.properties(_))
        .build

    def savingsPlanOfferingFilterElement(
      name: Option[String] = None,
      values: Option[List[JsonSafeFilterValueString]] = None
    ): SavingsPlanOfferingFilterElement =
      SavingsPlanOfferingFilterElement
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def savingsPlanOfferingProperty(
      name: Option[String] = None,
      value: Option[String] = None
    ): SavingsPlanOfferingProperty =
      SavingsPlanOfferingProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def savingsPlanOfferingRate(
      savingsPlanOffering: Option[ParentSavingsPlanOffering] = None,
      rate: Option[String] = None,
      unit: Option[String] = None,
      productType: Option[String] = None,
      serviceCode: Option[String] = None,
      usageType: Option[String] = None,
      operation: Option[String] = None,
      properties: Option[List[SavingsPlanOfferingRateProperty]] = None
    ): SavingsPlanOfferingRate =
      SavingsPlanOfferingRate
        .builder
        .ifSome(savingsPlanOffering)(_.savingsPlanOffering(_))
        .ifSome(rate)(_.rate(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(usageType)(_.usageType(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(properties)(_.properties(_))
        .build

    def savingsPlanOfferingRateFilterElement(
      name: Option[String] = None,
      values: Option[List[JsonSafeFilterValueString]] = None
    ): SavingsPlanOfferingRateFilterElement =
      SavingsPlanOfferingRateFilterElement
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def savingsPlanOfferingRateProperty(
      name: Option[String] = None,
      value: Option[String] = None
    ): SavingsPlanOfferingRateProperty =
      SavingsPlanOfferingRateProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def savingsPlanRate(
      rate: Option[String] = None,
      currency: Option[String] = None,
      unit: Option[String] = None,
      productType: Option[String] = None,
      serviceCode: Option[String] = None,
      usageType: Option[String] = None,
      operation: Option[String] = None,
      properties: Option[List[SavingsPlanRateProperty]] = None
    ): SavingsPlanRate =
      SavingsPlanRate
        .builder
        .ifSome(rate)(_.rate(_))
        .ifSome(currency)(_.currency(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(usageType)(_.usageType(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(properties)(_.properties(_))
        .build

    def savingsPlanRateFilter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): SavingsPlanRateFilter =
      SavingsPlanRateFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def savingsPlanRateProperty(
      name: Option[String] = None,
      value: Option[String] = None
    ): SavingsPlanRateProperty =
      SavingsPlanRateProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
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
