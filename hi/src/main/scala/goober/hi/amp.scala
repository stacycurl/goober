package goober.hi

import goober.free.amp.AmpIO
import software.amazon.awssdk.services.amp.model._


object amp {
  import goober.free.{amp ⇒ free}

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

    def conflictException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def createWorkspaceRequest(
      alias: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateWorkspaceRequest =
      CreateWorkspaceRequest
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createWorkspaceResponse(
      arn: Option[String] = None,
      status: Option[WorkspaceStatus] = None,
      workspaceId: Option[String] = None
    ): CreateWorkspaceResponse =
      CreateWorkspaceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def deleteWorkspaceRequest(
      clientToken: Option[String] = None,
      workspaceId: Option[String] = None
    ): DeleteWorkspaceRequest =
      DeleteWorkspaceRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def describeWorkspaceRequest(
      workspaceId: Option[String] = None
    ): DescribeWorkspaceRequest =
      DescribeWorkspaceRequest
        .builder
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def describeWorkspaceResponse(
      workspace: Option[WorkspaceDescription] = None
    ): DescribeWorkspaceResponse =
      DescribeWorkspaceResponse
        .builder
        .ifSome(workspace)(_.workspace(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      retryAfterSeconds: Option[Int] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .build

    def listWorkspacesRequest(
      alias: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListWorkspacesRequest =
      ListWorkspacesRequest
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorkspacesResponse(
      nextToken: Option[String] = None,
      workspaces: Option[List[WorkspaceSummary]] = None
    ): ListWorkspacesResponse =
      ListWorkspacesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(workspaces)(_.workspaces(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None,
      serviceCode: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      quotaCode: Option[String] = None,
      retryAfterSeconds: Option[Int] = None,
      serviceCode: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(retryAfterSeconds)(_.retryAfterSeconds(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def updateWorkspaceAliasRequest(
      alias: Option[String] = None,
      clientToken: Option[String] = None,
      workspaceId: Option[String] = None
    ): UpdateWorkspaceAliasRequest =
      UpdateWorkspaceAliasRequest
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def validationException(
      fieldList: Option[List[ValidationExceptionField]] = None,
      message: Option[String] = None,
      reason: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(fieldList)(_.fieldList(_))
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def validationExceptionField(
      message: Option[String] = None,
      name: Option[String] = None
    ): ValidationExceptionField =
      ValidationExceptionField
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(name)(_.name(_))
        .build

    def workspaceDescription(
      alias: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      prometheusEndpoint: Option[String] = None,
      status: Option[WorkspaceStatus] = None,
      workspaceId: Option[String] = None
    ): WorkspaceDescription =
      WorkspaceDescription
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(prometheusEndpoint)(_.prometheusEndpoint(_))
        .ifSome(status)(_.status(_))
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

    def workspaceStatus(
      statusCode: Option[String] = None
    ): WorkspaceStatus =
      WorkspaceStatus
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def workspaceSummary(
      alias: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      status: Option[WorkspaceStatus] = None,
      workspaceId: Option[String] = None
    ): WorkspaceSummary =
      WorkspaceSummary
        .builder
        .ifSome(alias)(_.alias(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(workspaceId)(_.workspaceId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
