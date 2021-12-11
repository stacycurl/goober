package goober.hi

import goober.free.applicationcostprofiler.ApplicationCostProfilerIO
import software.amazon.awssdk.services.applicationcostprofiler.model._


object applicationcostprofiler {
  import goober.free.{applicationcostprofiler ⇒ free}

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

    def deleteReportDefinitionRequest(
      reportId: Option[String] = None
    ): DeleteReportDefinitionRequest =
      DeleteReportDefinitionRequest
        .builder
        .ifSome(reportId)(_.reportId(_))
        .build

    def getReportDefinitionRequest(
      reportId: Option[String] = None
    ): GetReportDefinitionRequest =
      GetReportDefinitionRequest
        .builder
        .ifSome(reportId)(_.reportId(_))
        .build

    def importApplicationUsageRequest(
      sourceS3Location: Option[SourceS3Location] = None
    ): ImportApplicationUsageRequest =
      ImportApplicationUsageRequest
        .builder
        .ifSome(sourceS3Location)(_.sourceS3Location(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listReportDefinitionsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListReportDefinitionsRequest =
      ListReportDefinitionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def putReportDefinitionRequest(
      reportId: Option[String] = None,
      reportDescription: Option[String] = None,
      reportFrequency: Option[String] = None,
      format: Option[String] = None,
      destinationS3Location: Option[S3Location] = None
    ): PutReportDefinitionRequest =
      PutReportDefinitionRequest
        .builder
        .ifSome(reportId)(_.reportId(_))
        .ifSome(reportDescription)(_.reportDescription(_))
        .ifSome(reportFrequency)(_.reportFrequency(_))
        .ifSome(format)(_.format(_))
        .ifSome(destinationS3Location)(_.destinationS3Location(_))
        .build

    def reportDefinition(
      reportId: Option[String] = None,
      reportDescription: Option[String] = None,
      reportFrequency: Option[String] = None,
      format: Option[String] = None,
      destinationS3Location: Option[S3Location] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None
    ): ReportDefinition =
      ReportDefinition
        .builder
        .ifSome(reportId)(_.reportId(_))
        .ifSome(reportDescription)(_.reportDescription(_))
        .ifSome(reportFrequency)(_.reportFrequency(_))
        .ifSome(format)(_.format(_))
        .ifSome(destinationS3Location)(_.destinationS3Location(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sourceS3Location(
      bucket: Option[String] = None,
      key: Option[String] = None,
      region: Option[String] = None
    ): SourceS3Location =
      SourceS3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(region)(_.region(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateReportDefinitionRequest(
      reportId: Option[String] = None,
      reportDescription: Option[String] = None,
      reportFrequency: Option[String] = None,
      format: Option[String] = None,
      destinationS3Location: Option[S3Location] = None
    ): UpdateReportDefinitionRequest =
      UpdateReportDefinitionRequest
        .builder
        .ifSome(reportId)(_.reportId(_))
        .ifSome(reportDescription)(_.reportDescription(_))
        .ifSome(reportFrequency)(_.reportFrequency(_))
        .ifSome(format)(_.format(_))
        .ifSome(destinationS3Location)(_.destinationS3Location(_))
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
