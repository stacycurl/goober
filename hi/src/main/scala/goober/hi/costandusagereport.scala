package goober.hi

import goober.free.costandusagereport.CostAndUsageReportIO
import software.amazon.awssdk.services.costandusagereport.model._


object costandusagereport {
  import goober.free.{costandusagereport ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def deleteReportDefinitionRequest(
      reportName: Option[String] = None
    ): DeleteReportDefinitionRequest =
      DeleteReportDefinitionRequest
        .builder
        .ifSome(reportName)(_.reportName(_))
        .build

    def deleteReportDefinitionResponse(
      responseMessage: Option[String] = None
    ): DeleteReportDefinitionResponse =
      DeleteReportDefinitionResponse
        .builder
        .ifSome(responseMessage)(_.responseMessage(_))
        .build

    def describeReportDefinitionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeReportDefinitionsRequest =
      DescribeReportDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeReportDefinitionsResponse(
      reportDefinitions: Option[List[ReportDefinition]] = None,
      nextToken: Option[String] = None
    ): DescribeReportDefinitionsResponse =
      DescribeReportDefinitionsResponse
        .builder
        .ifSome(reportDefinitions)(_.reportDefinitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def duplicateReportNameException(
      message: Option[String] = None
    ): DuplicateReportNameException =
      DuplicateReportNameException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def modifyReportDefinitionRequest(
      reportName: Option[String] = None,
      reportDefinition: Option[ReportDefinition] = None
    ): ModifyReportDefinitionRequest =
      ModifyReportDefinitionRequest
        .builder
        .ifSome(reportName)(_.reportName(_))
        .ifSome(reportDefinition)(_.reportDefinition(_))
        .build

    def modifyReportDefinitionResponse(

    ): ModifyReportDefinitionResponse =
      ModifyReportDefinitionResponse
        .builder

        .build

    def putReportDefinitionRequest(
      reportDefinition: Option[ReportDefinition] = None
    ): PutReportDefinitionRequest =
      PutReportDefinitionRequest
        .builder
        .ifSome(reportDefinition)(_.reportDefinition(_))
        .build

    def putReportDefinitionResponse(

    ): PutReportDefinitionResponse =
      PutReportDefinitionResponse
        .builder

        .build

    def reportDefinition(
      reportName: Option[String] = None,
      timeUnit: Option[String] = None,
      format: Option[String] = None,
      compression: Option[String] = None,
      additionalSchemaElements: Option[List[SchemaElement]] = None,
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None,
      s3Region: Option[String] = None,
      additionalArtifacts: Option[List[AdditionalArtifact]] = None,
      refreshClosedReports: Option[Boolean] = None,
      reportVersioning: Option[String] = None,
      billingViewArn: Option[String] = None
    ): ReportDefinition =
      ReportDefinition
        .builder
        .ifSome(reportName)(_.reportName(_))
        .ifSome(timeUnit)(_.timeUnit(_))
        .ifSome(format)(_.format(_))
        .ifSome(compression)(_.compression(_))
        .ifSome(additionalSchemaElements)(_.additionalSchemaElements(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(s3Region)(_.s3Region(_))
        .ifSome(additionalArtifacts)(_.additionalArtifacts(_))
        .ifSome(refreshClosedReports)(_.refreshClosedReports(_))
        .ifSome(reportVersioning)(_.reportVersioning(_))
        .ifSome(billingViewArn)(_.billingViewArn(_))
        .build

    def reportLimitReachedException(
      message: Option[String] = None
    ): ReportLimitReachedException =
      ReportLimitReachedException
        .builder
        .ifSome(message)(_.message(_))
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
