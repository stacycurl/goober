package goober.hi

import goober.free.resourcegroupstaggingapi.ResourceGroupsTaggingApiIO
import software.amazon.awssdk.services.resourcegroupstaggingapi.model._


object resourcegroupstaggingapi {
  import goober.free.{resourcegroupstaggingapi ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def complianceDetails(
      noncompliantKeys: Option[List[TagKey]] = None,
      keysWithNoncompliantValues: Option[List[TagKey]] = None,
      complianceStatus: Option[Boolean] = None
    ): ComplianceDetails =
      ComplianceDetails
        .builder
        .ifSome(noncompliantKeys)(_.noncompliantKeys(_))
        .ifSome(keysWithNoncompliantValues)(_.keysWithNoncompliantValues(_))
        .ifSome(complianceStatus)(_.complianceStatus(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def constraintViolationException(
      message: Option[String] = None
    ): ConstraintViolationException =
      ConstraintViolationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def describeReportCreationInput(

    ): DescribeReportCreationInput =
      DescribeReportCreationInput
        .builder

        .build

    def describeReportCreationOutput(
      status: Option[String] = None,
      s3Location: Option[String] = None,
      errorMessage: Option[String] = None
    ): DescribeReportCreationOutput =
      DescribeReportCreationOutput
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(s3Location)(_.s3Location(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def failureInfo(
      statusCode: Option[Int] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailureInfo =
      FailureInfo
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def getComplianceSummaryInput(
      targetIdFilters: Option[List[TargetId]] = None,
      regionFilters: Option[List[Region]] = None,
      resourceTypeFilters: Option[List[AmazonResourceType]] = None,
      tagKeyFilters: Option[List[TagKey]] = None,
      groupBy: Option[List[GroupByAttribute]] = None,
      maxResults: Option[Int] = None,
      paginationToken: Option[String] = None
    ): GetComplianceSummaryInput =
      GetComplianceSummaryInput
        .builder
        .ifSome(targetIdFilters)(_.targetIdFilters(_))
        .ifSome(regionFilters)(_.regionFilters(_))
        .ifSome(resourceTypeFilters)(_.resourceTypeFilters(_))
        .ifSome(tagKeyFilters)(_.tagKeyFilters(_))
        .ifSome(groupBy)(_.groupBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def getComplianceSummaryOutput(
      summaryList: Option[List[Summary]] = None,
      paginationToken: Option[String] = None
    ): GetComplianceSummaryOutput =
      GetComplianceSummaryOutput
        .builder
        .ifSome(summaryList)(_.summaryList(_))
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def getResourcesInput(
      paginationToken: Option[String] = None,
      tagFilters: Option[List[TagFilter]] = None,
      resourcesPerPage: Option[Int] = None,
      tagsPerPage: Option[Int] = None,
      resourceTypeFilters: Option[List[AmazonResourceType]] = None,
      includeComplianceDetails: Option[Boolean] = None,
      excludeCompliantResources: Option[Boolean] = None,
      resourceARNList: Option[List[ResourceARN]] = None
    ): GetResourcesInput =
      GetResourcesInput
        .builder
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(tagFilters)(_.tagFilters(_))
        .ifSome(resourcesPerPage)(_.resourcesPerPage(_))
        .ifSome(tagsPerPage)(_.tagsPerPage(_))
        .ifSome(resourceTypeFilters)(_.resourceTypeFilters(_))
        .ifSome(includeComplianceDetails)(_.includeComplianceDetails(_))
        .ifSome(excludeCompliantResources)(_.excludeCompliantResources(_))
        .ifSome(resourceARNList)(_.resourceARNList(_))
        .build

    def getResourcesOutput(
      paginationToken: Option[String] = None,
      resourceTagMappingList: Option[List[ResourceTagMapping]] = None
    ): GetResourcesOutput =
      GetResourcesOutput
        .builder
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(resourceTagMappingList)(_.resourceTagMappingList(_))
        .build

    def getTagKeysInput(
      paginationToken: Option[String] = None
    ): GetTagKeysInput =
      GetTagKeysInput
        .builder
        .ifSome(paginationToken)(_.paginationToken(_))
        .build

    def getTagKeysOutput(
      paginationToken: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): GetTagKeysOutput =
      GetTagKeysOutput
        .builder
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def getTagValuesInput(
      paginationToken: Option[String] = None,
      key: Option[String] = None
    ): GetTagValuesInput =
      GetTagValuesInput
        .builder
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(key)(_.key(_))
        .build

    def getTagValuesOutput(
      paginationToken: Option[String] = None,
      tagValues: Option[List[TagValue]] = None
    ): GetTagValuesOutput =
      GetTagValuesOutput
        .builder
        .ifSome(paginationToken)(_.paginationToken(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
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

    def paginationTokenExpiredException(
      message: Option[String] = None
    ): PaginationTokenExpiredException =
      PaginationTokenExpiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceTagMapping(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      complianceDetails: Option[ComplianceDetails] = None
    ): ResourceTagMapping =
      ResourceTagMapping
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(complianceDetails)(_.complianceDetails(_))
        .build

    def startReportCreationInput(
      s3Bucket: Option[String] = None
    ): StartReportCreationInput =
      StartReportCreationInput
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .build

    def startReportCreationOutput(

    ): StartReportCreationOutput =
      StartReportCreationOutput
        .builder

        .build

    def summary(
      lastUpdated: Option[String] = None,
      targetId: Option[String] = None,
      targetIdType: Option[String] = None,
      region: Option[String] = None,
      resourceType: Option[String] = None,
      nonCompliantResources: Option[NonCompliantResources] = None
    ): Summary =
      Summary
        .builder
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetIdType)(_.targetIdType(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(nonCompliantResources)(_.nonCompliantResources(_))
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

    def tagFilter(
      key: Option[String] = None,
      values: Option[List[TagValue]] = None
    ): TagFilter =
      TagFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def tagResourcesInput(
      resourceARNList: Option[List[ResourceARN]] = None,
      tags: Option[TagMap] = None
    ): TagResourcesInput =
      TagResourcesInput
        .builder
        .ifSome(resourceARNList)(_.resourceARNList(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourcesOutput(
      failedResourcesMap: Option[FailedResourcesMap] = None
    ): TagResourcesOutput =
      TagResourcesOutput
        .builder
        .ifSome(failedResourcesMap)(_.failedResourcesMap(_))
        .build

    def throttledException(
      message: Option[String] = None
    ): ThrottledException =
      ThrottledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourcesInput(
      resourceARNList: Option[List[ResourceARN]] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourcesInput =
      UntagResourcesInput
        .builder
        .ifSome(resourceARNList)(_.resourceARNList(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourcesOutput(
      failedResourcesMap: Option[FailedResourcesMap] = None
    ): UntagResourcesOutput =
      UntagResourcesOutput
        .builder
        .ifSome(failedResourcesMap)(_.failedResourcesMap(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
