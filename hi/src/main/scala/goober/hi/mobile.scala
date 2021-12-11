package goober.hi

import goober.free.mobile.MobileIO
import software.amazon.awssdk.services.mobile.model._


object mobile {
  import goober.free.{mobile ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountActionRequiredException(
      message: Option[String] = None
    ): AccountActionRequiredException =
      AccountActionRequiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def bundleDetails(
      bundleId: Option[String] = None,
      title: Option[String] = None,
      version: Option[String] = None,
      description: Option[String] = None,
      iconUrl: Option[String] = None,
      availablePlatforms: Option[List[Platform]] = None
    ): BundleDetails =
      BundleDetails
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(title)(_.title(_))
        .ifSome(version)(_.version(_))
        .ifSome(description)(_.description(_))
        .ifSome(iconUrl)(_.iconUrl(_))
        .ifSome(availablePlatforms)(_.availablePlatforms(_))
        .build

    def createProjectRequest(
      name: Option[String] = None,
      region: Option[String] = None,
      contents: Option[Contents] = None,
      snapshotId: Option[String] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(region)(_.region(_))
        .ifSome(contents)(_.contents(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .build

    def deleteProjectRequest(
      projectId: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .build

    def describeBundleRequest(
      bundleId: Option[String] = None
    ): DescribeBundleRequest =
      DescribeBundleRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .build

    def describeProjectRequest(
      projectId: Option[String] = None,
      syncFromResources: Option[Boolean] = None
    ): DescribeProjectRequest =
      DescribeProjectRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(syncFromResources)(_.syncFromResources(_))
        .build

    def exportBundleRequest(
      bundleId: Option[String] = None,
      projectId: Option[String] = None,
      platform: Option[String] = None
    ): ExportBundleRequest =
      ExportBundleRequest
        .builder
        .ifSome(bundleId)(_.bundleId(_))
        .ifSome(projectId)(_.projectId(_))
        .ifSome(platform)(_.platform(_))
        .build

    def exportProjectRequest(
      projectId: Option[String] = None
    ): ExportProjectRequest =
      ExportProjectRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def listBundlesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBundlesRequest =
      ListBundlesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def projectDetails(
      name: Option[String] = None,
      projectId: Option[String] = None,
      region: Option[String] = None,
      state: Option[String] = None,
      createdDate: Option[Date] = None,
      lastUpdatedDate: Option[Date] = None,
      consoleUrl: Option[String] = None,
      resources: Option[List[Resource]] = None
    ): ProjectDetails =
      ProjectDetails
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(projectId)(_.projectId(_))
        .ifSome(region)(_.region(_))
        .ifSome(state)(_.state(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .ifSome(consoleUrl)(_.consoleUrl(_))
        .ifSome(resources)(_.resources(_))
        .build

    def projectSummary(
      name: Option[String] = None,
      projectId: Option[String] = None
    ): ProjectSummary =
      ProjectSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(projectId)(_.projectId(_))
        .build

    def resource(
      `type`: Option[String] = None,
      name: Option[String] = None,
      arn: Option[String] = None,
      feature: Option[String] = None,
      attributes: Option[Attributes] = None
    ): Resource =
      Resource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(feature)(_.feature(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def serviceUnavailableException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequestsException(
      retryAfterSeconds: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateProjectRequest(
      contents: Option[Contents] = None,
      projectId: Option[String] = None
    ): UpdateProjectRequest =
      UpdateProjectRequest
        .builder
        .ifSome(contents)(_.contents(_))
        .ifSome(projectId)(_.projectId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
