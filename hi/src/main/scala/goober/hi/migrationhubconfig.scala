package goober.hi

import goober.free.migrationhubconfig.MigrationHubConfigIO
import software.amazon.awssdk.services.migrationhubconfig.model._


object migrationhubconfig {
  import goober.free.{migrationhubconfig ⇒ free}

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

    def createHomeRegionControlRequest(
      homeRegion: Option[String] = None,
      target: Option[Target] = None
    ): CreateHomeRegionControlRequest =
      CreateHomeRegionControlRequest
        .builder
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(target)(_.target(_))
        .build

    def describeHomeRegionControlsRequest(
      controlId: Option[String] = None,
      homeRegion: Option[String] = None,
      target: Option[Target] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeHomeRegionControlsRequest =
      DescribeHomeRegionControlsRequest
        .builder
        .ifSome(controlId)(_.controlId(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(target)(_.target(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def dryRunOperation(
      message: Option[String] = None
    ): DryRunOperation =
      DryRunOperation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getHomeRegionRequest(

    ): GetHomeRegionRequest =
      GetHomeRegionRequest
        .builder

        .build

    def homeRegionControl(
      controlId: Option[String] = None,
      homeRegion: Option[String] = None,
      target: Option[Target] = None,
      requestedTime: Option[RequestedTime] = None
    ): HomeRegionControl =
      HomeRegionControl
        .builder
        .ifSome(controlId)(_.controlId(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(target)(_.target(_))
        .ifSome(requestedTime)(_.requestedTime(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def target(
      `type`: Option[String] = None,
      id: Option[String] = None
    ): Target =
      Target
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
