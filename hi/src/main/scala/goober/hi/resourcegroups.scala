package goober.hi

import goober.free.resourcegroups.ResourceGroupsIO
import software.amazon.awssdk.services.resourcegroups.model._


object resourcegroups {
  import goober.free.{resourcegroups ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createGroupInput(
      name: Option[String] = None,
      description: Option[String] = None,
      resourceQuery: Option[ResourceQuery] = None,
      tags: Option[Tags] = None,
      configuration: Option[List[GroupConfigurationItem]] = None
    ): CreateGroupInput =
      CreateGroupInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(resourceQuery)(_.resourceQuery(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def createGroupOutput(
      group: Option[Group] = None,
      resourceQuery: Option[ResourceQuery] = None,
      tags: Option[Tags] = None,
      groupConfiguration: Option[GroupConfiguration] = None
    ): CreateGroupOutput =
      CreateGroupOutput
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(resourceQuery)(_.resourceQuery(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(groupConfiguration)(_.groupConfiguration(_))
        .build

    def deleteGroupInput(
      groupName: Option[String] = None,
      group: Option[String] = None
    ): DeleteGroupInput =
      DeleteGroupInput
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(group)(_.group(_))
        .build

    def deleteGroupOutput(
      group: Option[Group] = None
    ): DeleteGroupOutput =
      DeleteGroupOutput
        .builder
        .ifSome(group)(_.group(_))
        .build

    def failedResource(
      resourceArn: Option[String] = None,
      errorMessage: Option[String] = None,
      errorCode: Option[String] = None
    ): FailedResource =
      FailedResource
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorCode)(_.errorCode(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getGroupConfigurationInput(
      group: Option[String] = None
    ): GetGroupConfigurationInput =
      GetGroupConfigurationInput
        .builder
        .ifSome(group)(_.group(_))
        .build

    def getGroupConfigurationOutput(
      groupConfiguration: Option[GroupConfiguration] = None
    ): GetGroupConfigurationOutput =
      GetGroupConfigurationOutput
        .builder
        .ifSome(groupConfiguration)(_.groupConfiguration(_))
        .build

    def getGroupInput(
      groupName: Option[String] = None,
      group: Option[String] = None
    ): GetGroupInput =
      GetGroupInput
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(group)(_.group(_))
        .build

    def getGroupOutput(
      group: Option[Group] = None
    ): GetGroupOutput =
      GetGroupOutput
        .builder
        .ifSome(group)(_.group(_))
        .build

    def getGroupQueryInput(
      groupName: Option[String] = None,
      group: Option[String] = None
    ): GetGroupQueryInput =
      GetGroupQueryInput
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(group)(_.group(_))
        .build

    def getGroupQueryOutput(
      groupQuery: Option[GroupQuery] = None
    ): GetGroupQueryOutput =
      GetGroupQueryOutput
        .builder
        .ifSome(groupQuery)(_.groupQuery(_))
        .build

    def getTagsInput(
      arn: Option[String] = None
    ): GetTagsInput =
      GetTagsInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getTagsOutput(
      arn: Option[String] = None,
      tags: Option[Tags] = None
    ): GetTagsOutput =
      GetTagsOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def group(
      groupArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): Group =
      Group
        .builder
        .ifSome(groupArn)(_.groupArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def groupConfiguration(
      configuration: Option[List[GroupConfigurationItem]] = None,
      proposedConfiguration: Option[List[GroupConfigurationItem]] = None,
      status: Option[String] = None,
      failureReason: Option[String] = None
    ): GroupConfiguration =
      GroupConfiguration
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(proposedConfiguration)(_.proposedConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def groupConfigurationItem(
      `type`: Option[String] = None,
      parameters: Option[List[GroupConfigurationParameter]] = None
    ): GroupConfigurationItem =
      GroupConfigurationItem
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def groupConfigurationParameter(
      name: Option[String] = None,
      values: Option[List[GroupConfigurationParameterValue]] = None
    ): GroupConfigurationParameter =
      GroupConfigurationParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def groupFilter(
      name: Option[String] = None,
      values: Option[List[GroupFilterValue]] = None
    ): GroupFilter =
      GroupFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def groupIdentifier(
      groupName: Option[String] = None,
      groupArn: Option[String] = None
    ): GroupIdentifier =
      GroupIdentifier
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupArn)(_.groupArn(_))
        .build

    def groupQuery(
      groupName: Option[String] = None,
      resourceQuery: Option[ResourceQuery] = None
    ): GroupQuery =
      GroupQuery
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(resourceQuery)(_.resourceQuery(_))
        .build

    def groupResourcesInput(
      group: Option[String] = None,
      resourceArns: Option[List[ResourceArn]] = None
    ): GroupResourcesInput =
      GroupResourcesInput
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .build

    def groupResourcesOutput(
      succeeded: Option[List[ResourceArn]] = None,
      failed: Option[List[FailedResource]] = None,
      pending: Option[List[PendingResource]] = None
    ): GroupResourcesOutput =
      GroupResourcesOutput
        .builder
        .ifSome(succeeded)(_.succeeded(_))
        .ifSome(failed)(_.failed(_))
        .ifSome(pending)(_.pending(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listGroupResourcesInput(
      groupName: Option[String] = None,
      group: Option[String] = None,
      filters: Option[List[ResourceFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListGroupResourcesInput =
      ListGroupResourcesInput
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(group)(_.group(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupResourcesItem(
      identifier: Option[ResourceIdentifier] = None,
      status: Option[ResourceStatus] = None
    ): ListGroupResourcesItem =
      ListGroupResourcesItem
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(status)(_.status(_))
        .build

    def listGroupResourcesOutput(
      resources: Option[List[ListGroupResourcesItem]] = None,
      resourceIdentifiers: Option[List[ResourceIdentifier]] = None,
      nextToken: Option[String] = None,
      queryErrors: Option[List[QueryError]] = None
    ): ListGroupResourcesOutput =
      ListGroupResourcesOutput
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(resourceIdentifiers)(_.resourceIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(queryErrors)(_.queryErrors(_))
        .build

    def listGroupsInput(
      filters: Option[List[GroupFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListGroupsInput =
      ListGroupsInput
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupsOutput(
      groupIdentifiers: Option[List[GroupIdentifier]] = None,
      groups: Option[List[Group]] = None,
      nextToken: Option[String] = None
    ): ListGroupsOutput =
      ListGroupsOutput
        .builder
        .ifSome(groupIdentifiers)(_.groupIdentifiers(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def methodNotAllowedException(
      message: Option[String] = None
    ): MethodNotAllowedException =
      MethodNotAllowedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pendingResource(
      resourceArn: Option[String] = None
    ): PendingResource =
      PendingResource
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def putGroupConfigurationInput(
      group: Option[String] = None,
      configuration: Option[List[GroupConfigurationItem]] = None
    ): PutGroupConfigurationInput =
      PutGroupConfigurationInput
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def putGroupConfigurationOutput(

    ): PutGroupConfigurationOutput =
      PutGroupConfigurationOutput
        .builder

        .build

    def queryError(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): QueryError =
      QueryError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceFilter(
      name: Option[String] = None,
      values: Option[List[ResourceFilterValue]] = None
    ): ResourceFilter =
      ResourceFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def resourceIdentifier(
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceIdentifier =
      ResourceIdentifier
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resourceQuery(
      `type`: Option[String] = None,
      query: Option[String] = None
    ): ResourceQuery =
      ResourceQuery
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(query)(_.query(_))
        .build

    def resourceStatus(
      name: Option[String] = None
    ): ResourceStatus =
      ResourceStatus
        .builder
        .ifSome(name)(_.name(_))
        .build

    def searchResourcesInput(
      resourceQuery: Option[ResourceQuery] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchResourcesInput =
      SearchResourcesInput
        .builder
        .ifSome(resourceQuery)(_.resourceQuery(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchResourcesOutput(
      resourceIdentifiers: Option[List[ResourceIdentifier]] = None,
      nextToken: Option[String] = None,
      queryErrors: Option[List[QueryError]] = None
    ): SearchResourcesOutput =
      SearchResourcesOutput
        .builder
        .ifSome(resourceIdentifiers)(_.resourceIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(queryErrors)(_.queryErrors(_))
        .build

    def tagInput(
      arn: Option[String] = None,
      tags: Option[Tags] = None
    ): TagInput =
      TagInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagOutput(
      arn: Option[String] = None,
      tags: Option[Tags] = None
    ): TagOutput =
      TagOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ungroupResourcesInput(
      group: Option[String] = None,
      resourceArns: Option[List[ResourceArn]] = None
    ): UngroupResourcesInput =
      UngroupResourcesInput
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .build

    def ungroupResourcesOutput(
      succeeded: Option[List[ResourceArn]] = None,
      failed: Option[List[FailedResource]] = None,
      pending: Option[List[PendingResource]] = None
    ): UngroupResourcesOutput =
      UngroupResourcesOutput
        .builder
        .ifSome(succeeded)(_.succeeded(_))
        .ifSome(failed)(_.failed(_))
        .ifSome(pending)(_.pending(_))
        .build

    def untagInput(
      arn: Option[String] = None,
      keys: Option[List[TagKey]] = None
    ): UntagInput =
      UntagInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(keys)(_.keys(_))
        .build

    def untagOutput(
      arn: Option[String] = None,
      keys: Option[List[TagKey]] = None
    ): UntagOutput =
      UntagOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(keys)(_.keys(_))
        .build

    def updateGroupInput(
      groupName: Option[String] = None,
      group: Option[String] = None,
      description: Option[String] = None
    ): UpdateGroupInput =
      UpdateGroupInput
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(group)(_.group(_))
        .ifSome(description)(_.description(_))
        .build

    def updateGroupOutput(
      group: Option[Group] = None
    ): UpdateGroupOutput =
      UpdateGroupOutput
        .builder
        .ifSome(group)(_.group(_))
        .build

    def updateGroupQueryInput(
      groupName: Option[String] = None,
      group: Option[String] = None,
      resourceQuery: Option[ResourceQuery] = None
    ): UpdateGroupQueryInput =
      UpdateGroupQueryInput
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(group)(_.group(_))
        .ifSome(resourceQuery)(_.resourceQuery(_))
        .build

    def updateGroupQueryOutput(
      groupQuery: Option[GroupQuery] = None
    ): UpdateGroupQueryOutput =
      UpdateGroupQueryOutput
        .builder
        .ifSome(groupQuery)(_.groupQuery(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
