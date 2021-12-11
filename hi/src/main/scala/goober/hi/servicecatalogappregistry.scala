package goober.hi

import goober.free.servicecatalogappregistry.ServiceCatalogAppRegistryIO
import software.amazon.awssdk.services.servicecatalogappregistry.model._


object servicecatalogappregistry {
  import goober.free.{servicecatalogappregistry ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def application(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      tags: Option[Tags] = None
    ): Application =
      Application
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def applicationSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): ApplicationSummary =
      ApplicationSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def associateAttributeGroupRequest(
      application: Option[String] = None,
      attributeGroup: Option[String] = None
    ): AssociateAttributeGroupRequest =
      AssociateAttributeGroupRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .build

    def associateAttributeGroupResponse(
      applicationArn: Option[String] = None,
      attributeGroupArn: Option[String] = None
    ): AssociateAttributeGroupResponse =
      AssociateAttributeGroupResponse
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(attributeGroupArn)(_.attributeGroupArn(_))
        .build

    def associateResourceRequest(
      application: Option[String] = None,
      resourceType: Option[String] = None,
      resource: Option[String] = None
    ): AssociateResourceRequest =
      AssociateResourceRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .build

    def associateResourceResponse(
      applicationArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): AssociateResourceResponse =
      AssociateResourceResponse
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def attributeGroup(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      tags: Option[Tags] = None
    ): AttributeGroup =
      AttributeGroup
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def attributeGroupSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): AttributeGroupSummary =
      AttributeGroupSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createApplicationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      tags: Option[Tags] = None,
      clientToken: Option[String] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createApplicationResponse(
      application: Option[Application] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(application)(_.application(_))
        .build

    def createAttributeGroupRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      attributes: Option[String] = None,
      tags: Option[Tags] = None,
      clientToken: Option[String] = None
    ): CreateAttributeGroupRequest =
      CreateAttributeGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createAttributeGroupResponse(
      attributeGroup: Option[AttributeGroup] = None
    ): CreateAttributeGroupResponse =
      CreateAttributeGroupResponse
        .builder
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .build

    def deleteApplicationRequest(
      application: Option[String] = None
    ): DeleteApplicationRequest =
      DeleteApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .build

    def deleteApplicationResponse(
      application: Option[ApplicationSummary] = None
    ): DeleteApplicationResponse =
      DeleteApplicationResponse
        .builder
        .ifSome(application)(_.application(_))
        .build

    def deleteAttributeGroupRequest(
      attributeGroup: Option[String] = None
    ): DeleteAttributeGroupRequest =
      DeleteAttributeGroupRequest
        .builder
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .build

    def deleteAttributeGroupResponse(
      attributeGroup: Option[AttributeGroupSummary] = None
    ): DeleteAttributeGroupResponse =
      DeleteAttributeGroupResponse
        .builder
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .build

    def disassociateAttributeGroupRequest(
      application: Option[String] = None,
      attributeGroup: Option[String] = None
    ): DisassociateAttributeGroupRequest =
      DisassociateAttributeGroupRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .build

    def disassociateAttributeGroupResponse(
      applicationArn: Option[String] = None,
      attributeGroupArn: Option[String] = None
    ): DisassociateAttributeGroupResponse =
      DisassociateAttributeGroupResponse
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(attributeGroupArn)(_.attributeGroupArn(_))
        .build

    def disassociateResourceRequest(
      application: Option[String] = None,
      resourceType: Option[String] = None,
      resource: Option[String] = None
    ): DisassociateResourceRequest =
      DisassociateResourceRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .build

    def disassociateResourceResponse(
      applicationArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): DisassociateResourceResponse =
      DisassociateResourceResponse
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getApplicationRequest(
      application: Option[String] = None
    ): GetApplicationRequest =
      GetApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .build

    def getApplicationResponse(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      associatedResourceCount: Option[Int] = None,
      tags: Option[Tags] = None
    ): GetApplicationResponse =
      GetApplicationResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(associatedResourceCount)(_.associatedResourceCount(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getAttributeGroupRequest(
      attributeGroup: Option[String] = None
    ): GetAttributeGroupRequest =
      GetAttributeGroupRequest
        .builder
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .build

    def getAttributeGroupResponse(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      attributes: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      tags: Option[Tags] = None
    ): GetAttributeGroupResponse =
      GetAttributeGroupResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApplicationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listApplicationsResponse(
      applications: Option[List[ApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ListApplicationsResponse =
      ListApplicationsResponse
        .builder
        .ifSome(applications)(_.applications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociatedAttributeGroupsRequest(
      application: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssociatedAttributeGroupsRequest =
      ListAssociatedAttributeGroupsRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssociatedAttributeGroupsResponse(
      attributeGroups: Option[List[AttributeGroupId]] = None,
      nextToken: Option[String] = None
    ): ListAssociatedAttributeGroupsResponse =
      ListAssociatedAttributeGroupsResponse
        .builder
        .ifSome(attributeGroups)(_.attributeGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociatedResourcesRequest(
      application: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssociatedResourcesRequest =
      ListAssociatedResourcesRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssociatedResourcesResponse(
      resources: Option[List[ResourceInfo]] = None,
      nextToken: Option[String] = None
    ): ListAssociatedResourcesResponse =
      ListAssociatedResourcesResponse
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAttributeGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAttributeGroupsRequest =
      ListAttributeGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAttributeGroupsResponse(
      attributeGroups: Option[List[AttributeGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListAttributeGroupsResponse =
      ListAttributeGroupsResponse
        .builder
        .ifSome(attributeGroups)(_.attributeGroups(_))
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
      tags: Option[Tags] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def resourceInfo(
      name: Option[String] = None,
      arn: Option[String] = None
    ): ResourceInfo =
      ResourceInfo
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def syncResourceRequest(
      resourceType: Option[String] = None,
      resource: Option[String] = None
    ): SyncResourceRequest =
      SyncResourceRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .build

    def syncResourceResponse(
      applicationArn: Option[String] = None,
      resourceArn: Option[String] = None,
      actionTaken: Option[String] = None
    ): SyncResourceResponse =
      SyncResourceResponse
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(actionTaken)(_.actionTaken(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
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
      application: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateApplicationResponse(
      application: Option[Application] = None
    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder
        .ifSome(application)(_.application(_))
        .build

    def updateAttributeGroupRequest(
      attributeGroup: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      attributes: Option[String] = None
    ): UpdateAttributeGroupRequest =
      UpdateAttributeGroupRequest
        .builder
        .ifSome(attributeGroup)(_.attributeGroup(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def updateAttributeGroupResponse(
      attributeGroup: Option[AttributeGroup] = None
    ): UpdateAttributeGroupResponse =
      UpdateAttributeGroupResponse
        .builder
        .ifSome(attributeGroup)(_.attributeGroup(_))
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
