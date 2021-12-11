package goober.hi

import goober.free.identitystore.IdentitystoreIO
import software.amazon.awssdk.services.identitystore.model._


object identitystore {
  import goober.free.{identitystore ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def describeGroupRequest(
      identityStoreId: Option[String] = None,
      groupId: Option[String] = None
    ): DescribeGroupRequest =
      DescribeGroupRequest
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def describeGroupResponse(
      groupId: Option[String] = None,
      displayName: Option[String] = None
    ): DescribeGroupResponse =
      DescribeGroupResponse
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def describeUserRequest(
      identityStoreId: Option[String] = None,
      userId: Option[String] = None
    ): DescribeUserRequest =
      DescribeUserRequest
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def describeUserResponse(
      userName: Option[String] = None,
      userId: Option[String] = None
    ): DescribeUserResponse =
      DescribeUserResponse
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(userId)(_.userId(_))
        .build

    def filter(
      attributePath: Option[String] = None,
      attributeValue: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(attributePath)(_.attributePath(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def group(
      groupId: Option[String] = None,
      displayName: Option[String] = None
    ): Group =
      Group
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def internalServerException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def listGroupsRequest(
      identityStoreId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListGroupsRequest =
      ListGroupsRequest
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listGroupsResponse(
      groups: Option[List[Group]] = None,
      nextToken: Option[String] = None
    ): ListGroupsResponse =
      ListGroupsResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersRequest(
      identityStoreId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listUsersResponse(
      users: Option[List[User]] = None,
      nextToken: Option[String] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def resourceNotFoundException(
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def user(
      userName: Option[String] = None,
      userId: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(userId)(_.userId(_))
        .build

    def validationException(
      message: Option[String] = None,
      requestId: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(requestId)(_.requestId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
