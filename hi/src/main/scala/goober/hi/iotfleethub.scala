package goober.hi

import goober.free.iotfleethub.IoTFleetHubIO
import software.amazon.awssdk.services.iotfleethub.model._


object iotfleethub {
  import goober.free.{iotfleethub ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def applicationSummary(
      applicationId: Option[String] = None,
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      applicationUrl: Option[String] = None,
      applicationCreationDate: Option[Timestamp] = None,
      applicationLastUpdateDate: Option[Timestamp] = None,
      applicationState: Option[String] = None
    ): ApplicationSummary =
      ApplicationSummary
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(applicationUrl)(_.applicationUrl(_))
        .ifSome(applicationCreationDate)(_.applicationCreationDate(_))
        .ifSome(applicationLastUpdateDate)(_.applicationLastUpdateDate(_))
        .ifSome(applicationState)(_.applicationState(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createApplicationRequest(
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      clientToken: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createApplicationResponse(
      applicationId: Option[String] = None,
      applicationArn: Option[String] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationArn)(_.applicationArn(_))
        .build

    def deleteApplicationRequest(
      applicationId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteApplicationRequest =
      DeleteApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteApplicationResponse(

    ): DeleteApplicationResponse =
      DeleteApplicationResponse
        .builder

        .build

    def describeApplicationRequest(
      applicationId: Option[String] = None
    ): DescribeApplicationRequest =
      DescribeApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def describeApplicationResponse(
      applicationId: Option[String] = None,
      applicationArn: Option[String] = None,
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      applicationUrl: Option[String] = None,
      applicationState: Option[String] = None,
      applicationCreationDate: Option[Timestamp] = None,
      applicationLastUpdateDate: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      ssoClientId: Option[String] = None,
      errorMessage: Option[String] = None,
      tags: Option[TagMap] = None
    ): DescribeApplicationResponse =
      DescribeApplicationResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(applicationUrl)(_.applicationUrl(_))
        .ifSome(applicationState)(_.applicationState(_))
        .ifSome(applicationCreationDate)(_.applicationCreationDate(_))
        .ifSome(applicationLastUpdateDate)(_.applicationLastUpdateDate(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(ssoClientId)(_.ssoClientId(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApplicationsRequest(
      nextToken: Option[String] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsResponse(
      applicationSummaries: Option[List[ApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ListApplicationsResponse =
      ListApplicationsResponse
        .builder
        .ifSome(applicationSummaries)(_.applicationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
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

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateApplicationRequest(
      applicationId: Option[String] = None,
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateApplicationResponse(

    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
