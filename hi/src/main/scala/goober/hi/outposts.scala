package goober.hi

import goober.free.outposts.OutpostsIO
import software.amazon.awssdk.services.outposts.model._


object outposts {
  import goober.free.{outposts ⇒ free}

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

    def createOutpostInput(
      name: Option[String] = None,
      description: Option[String] = None,
      siteId: Option[String] = None,
      availabilityZone: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateOutpostInput =
      CreateOutpostInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createOutpostOutput(
      outpost: Option[Outpost] = None
    ): CreateOutpostOutput =
      CreateOutpostOutput
        .builder
        .ifSome(outpost)(_.outpost(_))
        .build

    def deleteOutpostInput(
      outpostId: Option[String] = None
    ): DeleteOutpostInput =
      DeleteOutpostInput
        .builder
        .ifSome(outpostId)(_.outpostId(_))
        .build

    def deleteOutpostOutput(

    ): DeleteOutpostOutput =
      DeleteOutpostOutput
        .builder

        .build

    def deleteSiteInput(
      siteId: Option[String] = None
    ): DeleteSiteInput =
      DeleteSiteInput
        .builder
        .ifSome(siteId)(_.siteId(_))
        .build

    def deleteSiteOutput(

    ): DeleteSiteOutput =
      DeleteSiteOutput
        .builder

        .build

    def getOutpostInput(
      outpostId: Option[String] = None
    ): GetOutpostInput =
      GetOutpostInput
        .builder
        .ifSome(outpostId)(_.outpostId(_))
        .build

    def getOutpostInstanceTypesInput(
      outpostId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetOutpostInstanceTypesInput =
      GetOutpostInstanceTypesInput
        .builder
        .ifSome(outpostId)(_.outpostId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getOutpostInstanceTypesOutput(
      instanceTypes: Option[List[InstanceTypeItem]] = None,
      nextToken: Option[String] = None,
      outpostId: Option[String] = None,
      outpostArn: Option[String] = None
    ): GetOutpostInstanceTypesOutput =
      GetOutpostInstanceTypesOutput
        .builder
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(outpostId)(_.outpostId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .build

    def getOutpostOutput(
      outpost: Option[Outpost] = None
    ): GetOutpostOutput =
      GetOutpostOutput
        .builder
        .ifSome(outpost)(_.outpost(_))
        .build

    def instanceTypeItem(
      instanceType: Option[String] = None
    ): InstanceTypeItem =
      InstanceTypeItem
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listOutpostsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListOutpostsInput =
      ListOutpostsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listOutpostsOutput(
      outposts: Option[List[Outpost]] = None,
      nextToken: Option[String] = None
    ): ListOutpostsOutput =
      ListOutpostsOutput
        .builder
        .ifSome(outposts)(_.outposts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSitesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSitesInput =
      ListSitesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSitesOutput(
      sites: Option[List[Site]] = None,
      nextToken: Option[String] = None
    ): ListSitesOutput =
      ListSitesOutput
        .builder
        .ifSome(sites)(_.sites(_))
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

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def outpost(
      outpostId: Option[String] = None,
      ownerId: Option[String] = None,
      outpostArn: Option[String] = None,
      siteId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      lifeCycleStatus: Option[String] = None,
      availabilityZone: Option[String] = None,
      availabilityZoneId: Option[String] = None,
      tags: Option[TagMap] = None,
      siteArn: Option[String] = None
    ): Outpost =
      Outpost
        .builder
        .ifSome(outpostId)(_.outpostId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(outpostArn)(_.outpostArn(_))
        .ifSome(siteId)(_.siteId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(lifeCycleStatus)(_.lifeCycleStatus(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(availabilityZoneId)(_.availabilityZoneId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(siteArn)(_.siteArn(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def site(
      siteId: Option[String] = None,
      accountId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagMap] = None,
      siteArn: Option[String] = None
    ): Site =
      Site
        .builder
        .ifSome(siteId)(_.siteId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(siteArn)(_.siteArn(_))
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
