package goober.hi

import goober.free.cloud9.Cloud9IO
import software.amazon.awssdk.services.cloud9.model._


object cloud9 {
  import goober.free.{cloud9 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def badRequestException(

    ): BadRequestException =
      BadRequestException
        .builder

        .build

    def concurrentAccessException(

    ): ConcurrentAccessException =
      ConcurrentAccessException
        .builder

        .build

    def conflictException(

    ): ConflictException =
      ConflictException
        .builder

        .build

    def createEnvironmentEC2Request(
      name: Option[String] = None,
      description: Option[String] = None,
      clientRequestToken: Option[String] = None,
      instanceType: Option[String] = None,
      subnetId: Option[String] = None,
      imageId: Option[String] = None,
      automaticStopTimeMinutes: Option[Int] = None,
      ownerArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      connectionType: Option[String] = None
    ): CreateEnvironmentEC2Request =
      CreateEnvironmentEC2Request
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(automaticStopTimeMinutes)(_.automaticStopTimeMinutes(_))
        .ifSome(ownerArn)(_.ownerArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(connectionType)(_.connectionType(_))
        .build

    def createEnvironmentMembershipRequest(
      environmentId: Option[String] = None,
      userArn: Option[String] = None,
      permissions: Option[String] = None
    ): CreateEnvironmentMembershipRequest =
      CreateEnvironmentMembershipRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def deleteEnvironmentMembershipRequest(
      environmentId: Option[String] = None,
      userArn: Option[String] = None
    ): DeleteEnvironmentMembershipRequest =
      DeleteEnvironmentMembershipRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(userArn)(_.userArn(_))
        .build

    def deleteEnvironmentRequest(
      environmentId: Option[String] = None
    ): DeleteEnvironmentRequest =
      DeleteEnvironmentRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def describeEnvironmentMembershipsRequest(
      userArn: Option[String] = None,
      environmentId: Option[String] = None,
      permissions: Option[List[Permissions]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeEnvironmentMembershipsRequest =
      DescribeEnvironmentMembershipsRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeEnvironmentStatusRequest(
      environmentId: Option[String] = None
    ): DescribeEnvironmentStatusRequest =
      DescribeEnvironmentStatusRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .build

    def describeEnvironmentsRequest(
      environmentIds: Option[List[EnvironmentId]] = None
    ): DescribeEnvironmentsRequest =
      DescribeEnvironmentsRequest
        .builder
        .ifSome(environmentIds)(_.environmentIds(_))
        .build

    def environment(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      connectionType: Option[String] = None,
      arn: Option[String] = None,
      ownerArn: Option[String] = None,
      lifecycle: Option[EnvironmentLifecycle] = None,
      managedCredentialsStatus: Option[String] = None
    ): Environment =
      Environment
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(connectionType)(_.connectionType(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(ownerArn)(_.ownerArn(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(managedCredentialsStatus)(_.managedCredentialsStatus(_))
        .build

    def environmentLifecycle(
      status: Option[String] = None,
      reason: Option[String] = None,
      failureResource: Option[String] = None
    ): EnvironmentLifecycle =
      EnvironmentLifecycle
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .ifSome(failureResource)(_.failureResource(_))
        .build

    def environmentMember(
      permissions: Option[String] = None,
      userId: Option[String] = None,
      userArn: Option[String] = None,
      environmentId: Option[String] = None,
      lastAccess: Option[Timestamp] = None
    ): EnvironmentMember =
      EnvironmentMember
        .builder
        .ifSome(permissions)(_.permissions(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(lastAccess)(_.lastAccess(_))
        .build

    def forbiddenException(

    ): ForbiddenException =
      ForbiddenException
        .builder

        .build

    def internalServerErrorException(

    ): InternalServerErrorException =
      InternalServerErrorException
        .builder

        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listEnvironmentsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEnvironmentsRequest =
      ListEnvironmentsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def notFoundException(

    ): NotFoundException =
      NotFoundException
        .builder

        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagResourceRequest(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tooManyRequestsException(

    ): TooManyRequestsException =
      TooManyRequestsException
        .builder

        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateEnvironmentMembershipRequest(
      environmentId: Option[String] = None,
      userArn: Option[String] = None,
      permissions: Option[String] = None
    ): UpdateEnvironmentMembershipRequest =
      UpdateEnvironmentMembershipRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def updateEnvironmentRequest(
      environmentId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateEnvironmentRequest =
      UpdateEnvironmentRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
