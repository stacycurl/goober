package goober.hi

import goober.free.migrationhub.MigrationHubIO
import software.amazon.awssdk.services.migrationhub.model._


object migrationhub {
  import goober.free.{migrationhub ⇒ free}

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

    def applicationState(
      applicationId: Option[String] = None,
      applicationStatus: Option[String] = None,
      lastUpdatedTime: Option[UpdateDateTime] = None
    ): ApplicationState =
      ApplicationState
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(applicationStatus)(_.applicationStatus(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def associateCreatedArtifactRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      createdArtifact: Option[CreatedArtifact] = None
    ): AssociateCreatedArtifactRequest =
      AssociateCreatedArtifactRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(createdArtifact)(_.createdArtifact(_))
        .build

    def associateDiscoveredResourceRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      discoveredResource: Option[DiscoveredResource] = None
    ): AssociateDiscoveredResourceRequest =
      AssociateDiscoveredResourceRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(discoveredResource)(_.discoveredResource(_))
        .build

    def createProgressUpdateStreamRequest(
      progressUpdateStreamName: Option[String] = None
    ): CreateProgressUpdateStreamRequest =
      CreateProgressUpdateStreamRequest
        .builder
        .ifSome(progressUpdateStreamName)(_.progressUpdateStreamName(_))
        .build

    def createdArtifact(
      name: Option[String] = None,
      description: Option[String] = None
    ): CreatedArtifact =
      CreatedArtifact
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def deleteProgressUpdateStreamRequest(
      progressUpdateStreamName: Option[String] = None
    ): DeleteProgressUpdateStreamRequest =
      DeleteProgressUpdateStreamRequest
        .builder
        .ifSome(progressUpdateStreamName)(_.progressUpdateStreamName(_))
        .build

    def describeApplicationStateRequest(
      applicationId: Option[String] = None
    ): DescribeApplicationStateRequest =
      DescribeApplicationStateRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def describeMigrationTaskRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None
    ): DescribeMigrationTaskRequest =
      DescribeMigrationTaskRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .build

    def disassociateCreatedArtifactRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      createdArtifactName: Option[String] = None
    ): DisassociateCreatedArtifactRequest =
      DisassociateCreatedArtifactRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(createdArtifactName)(_.createdArtifactName(_))
        .build

    def disassociateDiscoveredResourceRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      configurationId: Option[String] = None
    ): DisassociateDiscoveredResourceRequest =
      DisassociateDiscoveredResourceRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(configurationId)(_.configurationId(_))
        .build

    def discoveredResource(
      configurationId: Option[String] = None,
      description: Option[String] = None
    ): DiscoveredResource =
      DiscoveredResource
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(description)(_.description(_))
        .build

    def dryRunOperation(
      message: Option[String] = None
    ): DryRunOperation =
      DryRunOperation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def homeRegionNotSetException(
      message: Option[String] = None
    ): HomeRegionNotSetException =
      HomeRegionNotSetException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def importMigrationTaskRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None
    ): ImportMigrationTaskRequest =
      ImportMigrationTaskRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
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

    def listApplicationStatesRequest(
      applicationIds: Option[List[ApplicationId]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListApplicationStatesRequest =
      ListApplicationStatesRequest
        .builder
        .ifSome(applicationIds)(_.applicationIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCreatedArtifactsRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCreatedArtifactsRequest =
      ListCreatedArtifactsRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDiscoveredResourcesRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDiscoveredResourcesRequest =
      ListDiscoveredResourcesRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMigrationTasksRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      resourceName: Option[String] = None
    ): ListMigrationTasksRequest =
      ListMigrationTasksRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def listProgressUpdateStreamsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProgressUpdateStreamsRequest =
      ListProgressUpdateStreamsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def migrationTask(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      task: Option[Task] = None,
      updateDateTime: Option[UpdateDateTime] = None,
      resourceAttributeList: Option[List[ResourceAttribute]] = None
    ): MigrationTask =
      MigrationTask
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(task)(_.task(_))
        .ifSome(updateDateTime)(_.updateDateTime(_))
        .ifSome(resourceAttributeList)(_.resourceAttributeList(_))
        .build

    def migrationTaskSummary(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      status: Option[String] = None,
      progressPercent: Option[Int] = None,
      statusDetail: Option[String] = None,
      updateDateTime: Option[UpdateDateTime] = None
    ): MigrationTaskSummary =
      MigrationTaskSummary
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(status)(_.status(_))
        .ifSome(progressPercent)(_.progressPercent(_))
        .ifSome(statusDetail)(_.statusDetail(_))
        .ifSome(updateDateTime)(_.updateDateTime(_))
        .build

    def notifyApplicationStateRequest(
      applicationId: Option[String] = None,
      status: Option[String] = None,
      updateDateTime: Option[UpdateDateTime] = None
    ): NotifyApplicationStateRequest =
      NotifyApplicationStateRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(status)(_.status(_))
        .ifSome(updateDateTime)(_.updateDateTime(_))
        .build

    def notifyMigrationTaskStateRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      task: Option[Task] = None,
      updateDateTime: Option[UpdateDateTime] = None,
      nextUpdateSeconds: Option[Int] = None
    ): NotifyMigrationTaskStateRequest =
      NotifyMigrationTaskStateRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(task)(_.task(_))
        .ifSome(updateDateTime)(_.updateDateTime(_))
        .ifSome(nextUpdateSeconds)(_.nextUpdateSeconds(_))
        .build

    def policyErrorException(
      message: Option[String] = None
    ): PolicyErrorException =
      PolicyErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def progressUpdateStreamSummary(
      progressUpdateStreamName: Option[String] = None
    ): ProgressUpdateStreamSummary =
      ProgressUpdateStreamSummary
        .builder
        .ifSome(progressUpdateStreamName)(_.progressUpdateStreamName(_))
        .build

    def putResourceAttributesRequest(
      progressUpdateStream: Option[String] = None,
      migrationTaskName: Option[String] = None,
      resourceAttributeList: Option[List[ResourceAttribute]] = None
    ): PutResourceAttributesRequest =
      PutResourceAttributesRequest
        .builder
        .ifSome(progressUpdateStream)(_.progressUpdateStream(_))
        .ifSome(migrationTaskName)(_.migrationTaskName(_))
        .ifSome(resourceAttributeList)(_.resourceAttributeList(_))
        .build

    def resourceAttribute(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): ResourceAttribute =
      ResourceAttribute
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
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

    def task(
      status: Option[String] = None,
      statusDetail: Option[String] = None,
      progressPercent: Option[Int] = None
    ): Task =
      Task
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(statusDetail)(_.statusDetail(_))
        .ifSome(progressPercent)(_.progressPercent(_))
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

    def unauthorizedOperation(
      message: Option[String] = None
    ): UnauthorizedOperation =
      UnauthorizedOperation
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
