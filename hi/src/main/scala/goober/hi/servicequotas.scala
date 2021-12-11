package goober.hi

import goober.free.servicequotas.ServiceQuotasIO
import software.amazon.awssdk.services.servicequotas.model._


object servicequotas {
  import goober.free.{servicequotas ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aWSServiceAccessNotEnabledException(
      message: Option[String] = None
    ): AWSServiceAccessNotEnabledException =
      AWSServiceAccessNotEnabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associateServiceQuotaTemplateRequest(

    ): AssociateServiceQuotaTemplateRequest =
      AssociateServiceQuotaTemplateRequest
        .builder

        .build

    def associateServiceQuotaTemplateResponse(

    ): AssociateServiceQuotaTemplateResponse =
      AssociateServiceQuotaTemplateResponse
        .builder

        .build

    def deleteServiceQuotaIncreaseRequestFromTemplateRequest(
      serviceCode: Option[String] = None,
      quotaCode: Option[String] = None,
      awsRegion: Option[String] = None
    ): DeleteServiceQuotaIncreaseRequestFromTemplateRequest =
      DeleteServiceQuotaIncreaseRequestFromTemplateRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def deleteServiceQuotaIncreaseRequestFromTemplateResponse(

    ): DeleteServiceQuotaIncreaseRequestFromTemplateResponse =
      DeleteServiceQuotaIncreaseRequestFromTemplateResponse
        .builder

        .build

    def dependencyAccessDeniedException(
      message: Option[String] = None
    ): DependencyAccessDeniedException =
      DependencyAccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def disassociateServiceQuotaTemplateRequest(

    ): DisassociateServiceQuotaTemplateRequest =
      DisassociateServiceQuotaTemplateRequest
        .builder

        .build

    def disassociateServiceQuotaTemplateResponse(

    ): DisassociateServiceQuotaTemplateResponse =
      DisassociateServiceQuotaTemplateResponse
        .builder

        .build

    def errorReason(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): ErrorReason =
      ErrorReason
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def getAWSDefaultServiceQuotaRequest(
      serviceCode: Option[String] = None,
      quotaCode: Option[String] = None
    ): GetAWSDefaultServiceQuotaRequest =
      GetAWSDefaultServiceQuotaRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .build

    def getAWSDefaultServiceQuotaResponse(
      quota: Option[ServiceQuota] = None
    ): GetAWSDefaultServiceQuotaResponse =
      GetAWSDefaultServiceQuotaResponse
        .builder
        .ifSome(quota)(_.quota(_))
        .build

    def getAssociationForServiceQuotaTemplateRequest(

    ): GetAssociationForServiceQuotaTemplateRequest =
      GetAssociationForServiceQuotaTemplateRequest
        .builder

        .build

    def getAssociationForServiceQuotaTemplateResponse(
      serviceQuotaTemplateAssociationStatus: Option[String] = None
    ): GetAssociationForServiceQuotaTemplateResponse =
      GetAssociationForServiceQuotaTemplateResponse
        .builder
        .ifSome(serviceQuotaTemplateAssociationStatus)(_.serviceQuotaTemplateAssociationStatus(_))
        .build

    def getRequestedServiceQuotaChangeRequest(
      requestId: Option[String] = None
    ): GetRequestedServiceQuotaChangeRequest =
      GetRequestedServiceQuotaChangeRequest
        .builder
        .ifSome(requestId)(_.requestId(_))
        .build

    def getRequestedServiceQuotaChangeResponse(
      requestedQuota: Option[RequestedServiceQuotaChange] = None
    ): GetRequestedServiceQuotaChangeResponse =
      GetRequestedServiceQuotaChangeResponse
        .builder
        .ifSome(requestedQuota)(_.requestedQuota(_))
        .build

    def getServiceQuotaIncreaseRequestFromTemplateRequest(
      serviceCode: Option[String] = None,
      quotaCode: Option[String] = None,
      awsRegion: Option[String] = None
    ): GetServiceQuotaIncreaseRequestFromTemplateRequest =
      GetServiceQuotaIncreaseRequestFromTemplateRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def getServiceQuotaIncreaseRequestFromTemplateResponse(
      serviceQuotaIncreaseRequestInTemplate: Option[ServiceQuotaIncreaseRequestInTemplate] = None
    ): GetServiceQuotaIncreaseRequestFromTemplateResponse =
      GetServiceQuotaIncreaseRequestFromTemplateResponse
        .builder
        .ifSome(serviceQuotaIncreaseRequestInTemplate)(_.serviceQuotaIncreaseRequestInTemplate(_))
        .build

    def getServiceQuotaRequest(
      serviceCode: Option[String] = None,
      quotaCode: Option[String] = None
    ): GetServiceQuotaRequest =
      GetServiceQuotaRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .build

    def getServiceQuotaResponse(
      quota: Option[ServiceQuota] = None
    ): GetServiceQuotaResponse =
      GetServiceQuotaResponse
        .builder
        .ifSome(quota)(_.quota(_))
        .build

    def illegalArgumentException(
      message: Option[String] = None
    ): IllegalArgumentException =
      IllegalArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPaginationTokenException(
      message: Option[String] = None
    ): InvalidPaginationTokenException =
      InvalidPaginationTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResourceStateException(
      message: Option[String] = None
    ): InvalidResourceStateException =
      InvalidResourceStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAWSDefaultServiceQuotasRequest(
      serviceCode: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAWSDefaultServiceQuotasRequest =
      ListAWSDefaultServiceQuotasRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAWSDefaultServiceQuotasResponse(
      nextToken: Option[String] = None,
      quotas: Option[List[ServiceQuota]] = None
    ): ListAWSDefaultServiceQuotasResponse =
      ListAWSDefaultServiceQuotasResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(quotas)(_.quotas(_))
        .build

    def listRequestedServiceQuotaChangeHistoryByQuotaRequest(
      serviceCode: Option[String] = None,
      quotaCode: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRequestedServiceQuotaChangeHistoryByQuotaRequest =
      ListRequestedServiceQuotaChangeHistoryByQuotaRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRequestedServiceQuotaChangeHistoryByQuotaResponse(
      nextToken: Option[String] = None,
      requestedQuotas: Option[List[RequestedServiceQuotaChange]] = None
    ): ListRequestedServiceQuotaChangeHistoryByQuotaResponse =
      ListRequestedServiceQuotaChangeHistoryByQuotaResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestedQuotas)(_.requestedQuotas(_))
        .build

    def listRequestedServiceQuotaChangeHistoryRequest(
      serviceCode: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRequestedServiceQuotaChangeHistoryRequest =
      ListRequestedServiceQuotaChangeHistoryRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRequestedServiceQuotaChangeHistoryResponse(
      nextToken: Option[String] = None,
      requestedQuotas: Option[List[RequestedServiceQuotaChange]] = None
    ): ListRequestedServiceQuotaChangeHistoryResponse =
      ListRequestedServiceQuotaChangeHistoryResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestedQuotas)(_.requestedQuotas(_))
        .build

    def listServiceQuotaIncreaseRequestsInTemplateRequest(
      serviceCode: Option[String] = None,
      awsRegion: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListServiceQuotaIncreaseRequestsInTemplateRequest =
      ListServiceQuotaIncreaseRequestsInTemplateRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listServiceQuotaIncreaseRequestsInTemplateResponse(
      serviceQuotaIncreaseRequestInTemplateList: Option[List[ServiceQuotaIncreaseRequestInTemplate]] = None,
      nextToken: Option[String] = None
    ): ListServiceQuotaIncreaseRequestsInTemplateResponse =
      ListServiceQuotaIncreaseRequestsInTemplateResponse
        .builder
        .ifSome(serviceQuotaIncreaseRequestInTemplateList)(_.serviceQuotaIncreaseRequestInTemplateList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServiceQuotasRequest(
      serviceCode: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListServiceQuotasRequest =
      ListServiceQuotasRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listServiceQuotasResponse(
      nextToken: Option[String] = None,
      quotas: Option[List[ServiceQuota]] = None
    ): ListServiceQuotasResponse =
      ListServiceQuotasResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(quotas)(_.quotas(_))
        .build

    def listServicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListServicesRequest =
      ListServicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listServicesResponse(
      nextToken: Option[String] = None,
      services: Option[List[ServiceInfo]] = None
    ): ListServicesResponse =
      ListServicesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(services)(_.services(_))
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

    def metricInfo(
      metricNamespace: Option[String] = None,
      metricName: Option[String] = None,
      metricDimensions: Option[MetricDimensionsMapDefinition] = None,
      metricStatisticRecommendation: Option[String] = None
    ): MetricInfo =
      MetricInfo
        .builder
        .ifSome(metricNamespace)(_.metricNamespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricDimensions)(_.metricDimensions(_))
        .ifSome(metricStatisticRecommendation)(_.metricStatisticRecommendation(_))
        .build

    def noAvailableOrganizationException(
      message: Option[String] = None
    ): NoAvailableOrganizationException =
      NoAvailableOrganizationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noSuchResourceException(
      message: Option[String] = None
    ): NoSuchResourceException =
      NoSuchResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationNotInAllFeaturesModeException(
      message: Option[String] = None
    ): OrganizationNotInAllFeaturesModeException =
      OrganizationNotInAllFeaturesModeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putServiceQuotaIncreaseRequestIntoTemplateRequest(
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None,
      awsRegion: Option[String] = None,
      desiredValue: Option[QuotaValue] = None
    ): PutServiceQuotaIncreaseRequestIntoTemplateRequest =
      PutServiceQuotaIncreaseRequestIntoTemplateRequest
        .builder
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(desiredValue)(_.desiredValue(_))
        .build

    def putServiceQuotaIncreaseRequestIntoTemplateResponse(
      serviceQuotaIncreaseRequestInTemplate: Option[ServiceQuotaIncreaseRequestInTemplate] = None
    ): PutServiceQuotaIncreaseRequestIntoTemplateResponse =
      PutServiceQuotaIncreaseRequestIntoTemplateResponse
        .builder
        .ifSome(serviceQuotaIncreaseRequestInTemplate)(_.serviceQuotaIncreaseRequestInTemplate(_))
        .build

    def quotaExceededException(
      message: Option[String] = None
    ): QuotaExceededException =
      QuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def quotaPeriod(
      periodValue: Option[Int] = None,
      periodUnit: Option[String] = None
    ): QuotaPeriod =
      QuotaPeriod
        .builder
        .ifSome(periodValue)(_.periodValue(_))
        .ifSome(periodUnit)(_.periodUnit(_))
        .build

    def requestServiceQuotaIncreaseRequest(
      serviceCode: Option[String] = None,
      quotaCode: Option[String] = None,
      desiredValue: Option[QuotaValue] = None
    ): RequestServiceQuotaIncreaseRequest =
      RequestServiceQuotaIncreaseRequest
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(desiredValue)(_.desiredValue(_))
        .build

    def requestServiceQuotaIncreaseResponse(
      requestedQuota: Option[RequestedServiceQuotaChange] = None
    ): RequestServiceQuotaIncreaseResponse =
      RequestServiceQuotaIncreaseResponse
        .builder
        .ifSome(requestedQuota)(_.requestedQuota(_))
        .build

    def requestedServiceQuotaChange(
      id: Option[String] = None,
      caseId: Option[String] = None,
      serviceCode: Option[String] = None,
      serviceName: Option[String] = None,
      quotaCode: Option[String] = None,
      quotaName: Option[String] = None,
      desiredValue: Option[QuotaValue] = None,
      status: Option[String] = None,
      created: Option[DateTime] = None,
      lastUpdated: Option[DateTime] = None,
      requester: Option[String] = None,
      quotaArn: Option[String] = None,
      globalQuota: Option[Boolean] = None,
      unit: Option[String] = None
    ): RequestedServiceQuotaChange =
      RequestedServiceQuotaChange
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(caseId)(_.caseId(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(quotaName)(_.quotaName(_))
        .ifSome(desiredValue)(_.desiredValue(_))
        .ifSome(status)(_.status(_))
        .ifSome(created)(_.created(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(requester)(_.requester(_))
        .ifSome(quotaArn)(_.quotaArn(_))
        .ifSome(globalQuota)(_.globalQuota(_))
        .ifSome(unit)(_.unit(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceException(
      message: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceInfo(
      serviceCode: Option[String] = None,
      serviceName: Option[String] = None
    ): ServiceInfo =
      ServiceInfo
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def serviceQuota(
      serviceCode: Option[String] = None,
      serviceName: Option[String] = None,
      quotaArn: Option[String] = None,
      quotaCode: Option[String] = None,
      quotaName: Option[String] = None,
      value: Option[QuotaValue] = None,
      unit: Option[String] = None,
      adjustable: Option[Boolean] = None,
      globalQuota: Option[Boolean] = None,
      usageMetric: Option[MetricInfo] = None,
      period: Option[QuotaPeriod] = None,
      errorReason: Option[ErrorReason] = None
    ): ServiceQuota =
      ServiceQuota
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(quotaArn)(_.quotaArn(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(quotaName)(_.quotaName(_))
        .ifSome(value)(_.value(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(adjustable)(_.adjustable(_))
        .ifSome(globalQuota)(_.globalQuota(_))
        .ifSome(usageMetric)(_.usageMetric(_))
        .ifSome(period)(_.period(_))
        .ifSome(errorReason)(_.errorReason(_))
        .build

    def serviceQuotaIncreaseRequestInTemplate(
      serviceCode: Option[String] = None,
      serviceName: Option[String] = None,
      quotaCode: Option[String] = None,
      quotaName: Option[String] = None,
      desiredValue: Option[QuotaValue] = None,
      awsRegion: Option[String] = None,
      unit: Option[String] = None,
      globalQuota: Option[Boolean] = None
    ): ServiceQuotaIncreaseRequestInTemplate =
      ServiceQuotaIncreaseRequestInTemplate
        .builder
        .ifSome(serviceCode)(_.serviceCode(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(quotaName)(_.quotaName(_))
        .ifSome(desiredValue)(_.desiredValue(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(globalQuota)(_.globalQuota(_))
        .build

    def serviceQuotaTemplateNotInUseException(
      message: Option[String] = None
    ): ServiceQuotaTemplateNotInUseException =
      ServiceQuotaTemplateNotInUseException
        .builder
        .ifSome(message)(_.message(_))
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

    def tagPolicyViolationException(
      message: Option[String] = None
    ): TagPolicyViolationException =
      TagPolicyViolationException
        .builder
        .ifSome(message)(_.message(_))
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

    def templatesNotAvailableInRegionException(
      message: Option[String] = None
    ): TemplatesNotAvailableInRegionException =
      TemplatesNotAvailableInRegionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
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

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
