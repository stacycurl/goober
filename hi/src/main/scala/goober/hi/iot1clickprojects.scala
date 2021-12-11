package goober.hi

import goober.free.iot1clickprojects.Iot1ClickProjectsIO
import software.amazon.awssdk.services.iot1clickprojects.model._


object iot1clickprojects {
  import goober.free.{iot1clickprojects ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateDeviceWithPlacementRequest(
      projectName: Option[String] = None,
      placementName: Option[String] = None,
      deviceId: Option[String] = None,
      deviceTemplateName: Option[String] = None
    ): AssociateDeviceWithPlacementRequest =
      AssociateDeviceWithPlacementRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(placementName)(_.placementName(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(deviceTemplateName)(_.deviceTemplateName(_))
        .build

    def associateDeviceWithPlacementResponse(

    ): AssociateDeviceWithPlacementResponse =
      AssociateDeviceWithPlacementResponse
        .builder

        .build

    def createPlacementRequest(
      placementName: Option[String] = None,
      projectName: Option[String] = None,
      attributes: Option[PlacementAttributeMap] = None
    ): CreatePlacementRequest =
      CreatePlacementRequest
        .builder
        .ifSome(placementName)(_.placementName(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def createPlacementResponse(

    ): CreatePlacementResponse =
      CreatePlacementResponse
        .builder

        .build

    def createProjectRequest(
      projectName: Option[String] = None,
      description: Option[String] = None,
      placementTemplate: Option[PlacementTemplate] = None,
      tags: Option[TagMap] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(description)(_.description(_))
        .ifSome(placementTemplate)(_.placementTemplate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProjectResponse(

    ): CreateProjectResponse =
      CreateProjectResponse
        .builder

        .build

    def deletePlacementRequest(
      placementName: Option[String] = None,
      projectName: Option[String] = None
    ): DeletePlacementRequest =
      DeletePlacementRequest
        .builder
        .ifSome(placementName)(_.placementName(_))
        .ifSome(projectName)(_.projectName(_))
        .build

    def deletePlacementResponse(

    ): DeletePlacementResponse =
      DeletePlacementResponse
        .builder

        .build

    def deleteProjectRequest(
      projectName: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def deleteProjectResponse(

    ): DeleteProjectResponse =
      DeleteProjectResponse
        .builder

        .build

    def describePlacementRequest(
      placementName: Option[String] = None,
      projectName: Option[String] = None
    ): DescribePlacementRequest =
      DescribePlacementRequest
        .builder
        .ifSome(placementName)(_.placementName(_))
        .ifSome(projectName)(_.projectName(_))
        .build

    def describePlacementResponse(
      placement: Option[PlacementDescription] = None
    ): DescribePlacementResponse =
      DescribePlacementResponse
        .builder
        .ifSome(placement)(_.placement(_))
        .build

    def describeProjectRequest(
      projectName: Option[String] = None
    ): DescribeProjectRequest =
      DescribeProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def describeProjectResponse(
      project: Option[ProjectDescription] = None
    ): DescribeProjectResponse =
      DescribeProjectResponse
        .builder
        .ifSome(project)(_.project(_))
        .build

    def deviceTemplate(
      deviceType: Option[String] = None,
      callbackOverrides: Option[DeviceCallbackOverrideMap] = None
    ): DeviceTemplate =
      DeviceTemplate
        .builder
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(callbackOverrides)(_.callbackOverrides(_))
        .build

    def disassociateDeviceFromPlacementRequest(
      projectName: Option[String] = None,
      placementName: Option[String] = None,
      deviceTemplateName: Option[String] = None
    ): DisassociateDeviceFromPlacementRequest =
      DisassociateDeviceFromPlacementRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(placementName)(_.placementName(_))
        .ifSome(deviceTemplateName)(_.deviceTemplateName(_))
        .build

    def disassociateDeviceFromPlacementResponse(

    ): DisassociateDeviceFromPlacementResponse =
      DisassociateDeviceFromPlacementResponse
        .builder

        .build

    def getDevicesInPlacementRequest(
      projectName: Option[String] = None,
      placementName: Option[String] = None
    ): GetDevicesInPlacementRequest =
      GetDevicesInPlacementRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(placementName)(_.placementName(_))
        .build

    def getDevicesInPlacementResponse(
      devices: Option[DeviceMap] = None
    ): GetDevicesInPlacementResponse =
      GetDevicesInPlacementResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .build

    def internalFailureException(
      code: Option[String] = None,
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      code: Option[String] = None,
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def listPlacementsRequest(
      projectName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPlacementsRequest =
      ListPlacementsRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPlacementsResponse(
      placements: Option[List[PlacementSummary]] = None,
      nextToken: Option[String] = None
    ): ListPlacementsResponse =
      ListPlacementsResponse
        .builder
        .ifSome(placements)(_.placements(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProjectsResponse(
      projects: Option[List[ProjectSummary]] = None,
      nextToken: Option[String] = None
    ): ListProjectsResponse =
      ListProjectsResponse
        .builder
        .ifSome(projects)(_.projects(_))
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

    def placementDescription(
      projectName: Option[String] = None,
      placementName: Option[String] = None,
      attributes: Option[PlacementAttributeMap] = None,
      createdDate: Option[Time] = None,
      updatedDate: Option[Time] = None
    ): PlacementDescription =
      PlacementDescription
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(placementName)(_.placementName(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .build

    def placementSummary(
      projectName: Option[String] = None,
      placementName: Option[String] = None,
      createdDate: Option[Time] = None,
      updatedDate: Option[Time] = None
    ): PlacementSummary =
      PlacementSummary
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(placementName)(_.placementName(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .build

    def placementTemplate(
      defaultAttributes: Option[DefaultPlacementAttributeMap] = None,
      deviceTemplates: Option[DeviceTemplateMap] = None
    ): PlacementTemplate =
      PlacementTemplate
        .builder
        .ifSome(defaultAttributes)(_.defaultAttributes(_))
        .ifSome(deviceTemplates)(_.deviceTemplates(_))
        .build

    def projectDescription(
      arn: Option[String] = None,
      projectName: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[Time] = None,
      updatedDate: Option[Time] = None,
      placementTemplate: Option[PlacementTemplate] = None,
      tags: Option[TagMap] = None
    ): ProjectDescription =
      ProjectDescription
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .ifSome(placementTemplate)(_.placementTemplate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def projectSummary(
      arn: Option[String] = None,
      projectName: Option[String] = None,
      createdDate: Option[Time] = None,
      updatedDate: Option[Time] = None,
      tags: Option[TagMap] = None
    ): ProjectSummary =
      ProjectSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(updatedDate)(_.updatedDate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceConflictException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(code)(_.code(_))
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

    def tooManyRequestsException(
      code: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(code)(_.code(_))
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

    def updatePlacementRequest(
      placementName: Option[String] = None,
      projectName: Option[String] = None,
      attributes: Option[PlacementAttributeMap] = None
    ): UpdatePlacementRequest =
      UpdatePlacementRequest
        .builder
        .ifSome(placementName)(_.placementName(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def updatePlacementResponse(

    ): UpdatePlacementResponse =
      UpdatePlacementResponse
        .builder

        .build

    def updateProjectRequest(
      projectName: Option[String] = None,
      description: Option[String] = None,
      placementTemplate: Option[PlacementTemplate] = None
    ): UpdateProjectRequest =
      UpdateProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(description)(_.description(_))
        .ifSome(placementTemplate)(_.placementTemplate(_))
        .build

    def updateProjectResponse(

    ): UpdateProjectResponse =
      UpdateProjectResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
