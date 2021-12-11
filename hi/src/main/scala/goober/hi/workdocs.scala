package goober.hi

import goober.free.workdocs.WorkDocsIO
import software.amazon.awssdk.services.workdocs.model._


object workdocs {
  import goober.free.{workdocs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abortDocumentVersionUploadRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      versionId: Option[String] = None
    ): AbortDocumentVersionUploadRequest =
      AbortDocumentVersionUploadRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def activateUserRequest(
      userId: Option[String] = None,
      authenticationToken: Option[String] = None
    ): ActivateUserRequest =
      ActivateUserRequest
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .build

    def activateUserResponse(
      user: Option[User] = None
    ): ActivateUserResponse =
      ActivateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def activity(
      `type`: Option[String] = None,
      timeStamp: Option[TimestampType] = None,
      isIndirectActivity: Option[Boolean] = None,
      organizationId: Option[String] = None,
      initiator: Option[UserMetadata] = None,
      participants: Option[Participants] = None,
      resourceMetadata: Option[ResourceMetadata] = None,
      originalParent: Option[ResourceMetadata] = None,
      commentMetadata: Option[CommentMetadata] = None
    ): Activity =
      Activity
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(timeStamp)(_.timeStamp(_))
        .ifSome(isIndirectActivity)(_.isIndirectActivity(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(initiator)(_.initiator(_))
        .ifSome(participants)(_.participants(_))
        .ifSome(resourceMetadata)(_.resourceMetadata(_))
        .ifSome(originalParent)(_.originalParent(_))
        .ifSome(commentMetadata)(_.commentMetadata(_))
        .build

    def addResourcePermissionsRequest(
      authenticationToken: Option[String] = None,
      resourceId: Option[String] = None,
      principals: Option[List[SharePrincipal]] = None,
      notificationOptions: Option[NotificationOptions] = None
    ): AddResourcePermissionsRequest =
      AddResourcePermissionsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(notificationOptions)(_.notificationOptions(_))
        .build

    def addResourcePermissionsResponse(
      shareResults: Option[List[ShareResult]] = None
    ): AddResourcePermissionsResponse =
      AddResourcePermissionsResponse
        .builder
        .ifSome(shareResults)(_.shareResults(_))
        .build

    def comment(
      commentId: Option[String] = None,
      parentId: Option[String] = None,
      threadId: Option[String] = None,
      text: Option[String] = None,
      contributor: Option[User] = None,
      createdTimestamp: Option[TimestampType] = None,
      status: Option[String] = None,
      visibility: Option[String] = None,
      recipientId: Option[String] = None
    ): Comment =
      Comment
        .builder
        .ifSome(commentId)(_.commentId(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(threadId)(_.threadId(_))
        .ifSome(text)(_.text(_))
        .ifSome(contributor)(_.contributor(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(visibility)(_.visibility(_))
        .ifSome(recipientId)(_.recipientId(_))
        .build

    def commentMetadata(
      commentId: Option[String] = None,
      contributor: Option[User] = None,
      createdTimestamp: Option[TimestampType] = None,
      commentStatus: Option[String] = None,
      recipientId: Option[String] = None
    ): CommentMetadata =
      CommentMetadata
        .builder
        .ifSome(commentId)(_.commentId(_))
        .ifSome(contributor)(_.contributor(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(commentStatus)(_.commentStatus(_))
        .ifSome(recipientId)(_.recipientId(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictingOperationException(
      message: Option[String] = None
    ): ConflictingOperationException =
      ConflictingOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createCommentRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      versionId: Option[String] = None,
      parentId: Option[String] = None,
      threadId: Option[String] = None,
      text: Option[String] = None,
      visibility: Option[String] = None,
      notifyCollaborators: Option[Boolean] = None
    ): CreateCommentRequest =
      CreateCommentRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(threadId)(_.threadId(_))
        .ifSome(text)(_.text(_))
        .ifSome(visibility)(_.visibility(_))
        .ifSome(notifyCollaborators)(_.notifyCollaborators(_))
        .build

    def createCommentResponse(
      comment: Option[Comment] = None
    ): CreateCommentResponse =
      CreateCommentResponse
        .builder
        .ifSome(comment)(_.comment(_))
        .build

    def createCustomMetadataRequest(
      authenticationToken: Option[String] = None,
      resourceId: Option[String] = None,
      versionId: Option[String] = None,
      customMetadata: Option[CustomMetadataMap] = None
    ): CreateCustomMetadataRequest =
      CreateCustomMetadataRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(customMetadata)(_.customMetadata(_))
        .build

    def createCustomMetadataResponse(

    ): CreateCustomMetadataResponse =
      CreateCustomMetadataResponse
        .builder

        .build

    def createFolderRequest(
      authenticationToken: Option[String] = None,
      name: Option[String] = None,
      parentFolderId: Option[String] = None
    ): CreateFolderRequest =
      CreateFolderRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(parentFolderId)(_.parentFolderId(_))
        .build

    def createFolderResponse(
      metadata: Option[FolderMetadata] = None
    ): CreateFolderResponse =
      CreateFolderResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .build

    def createLabelsRequest(
      resourceId: Option[String] = None,
      labels: Option[List[SharedLabel]] = None,
      authenticationToken: Option[String] = None
    ): CreateLabelsRequest =
      CreateLabelsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .build

    def createLabelsResponse(

    ): CreateLabelsResponse =
      CreateLabelsResponse
        .builder

        .build

    def createNotificationSubscriptionRequest(
      organizationId: Option[String] = None,
      endpoint: Option[String] = None,
      protocol: Option[String] = None,
      subscriptionType: Option[String] = None
    ): CreateNotificationSubscriptionRequest =
      CreateNotificationSubscriptionRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(subscriptionType)(_.subscriptionType(_))
        .build

    def createNotificationSubscriptionResponse(
      subscription: Option[Subscription] = None
    ): CreateNotificationSubscriptionResponse =
      CreateNotificationSubscriptionResponse
        .builder
        .ifSome(subscription)(_.subscription(_))
        .build

    def createUserRequest(
      organizationId: Option[String] = None,
      username: Option[String] = None,
      emailAddress: Option[String] = None,
      givenName: Option[String] = None,
      surname: Option[String] = None,
      password: Option[String] = None,
      timeZoneId: Option[String] = None,
      storageRule: Option[StorageRuleType] = None,
      authenticationToken: Option[String] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(username)(_.username(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(givenName)(_.givenName(_))
        .ifSome(surname)(_.surname(_))
        .ifSome(password)(_.password(_))
        .ifSome(timeZoneId)(_.timeZoneId(_))
        .ifSome(storageRule)(_.storageRule(_))
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .build

    def createUserResponse(
      user: Option[User] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def customMetadataLimitExceededException(
      message: Option[String] = None
    ): CustomMetadataLimitExceededException =
      CustomMetadataLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deactivateUserRequest(
      userId: Option[String] = None,
      authenticationToken: Option[String] = None
    ): DeactivateUserRequest =
      DeactivateUserRequest
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .build

    def deactivatingLastSystemUserException(

    ): DeactivatingLastSystemUserException =
      DeactivatingLastSystemUserException
        .builder

        .build

    def deleteCommentRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      versionId: Option[String] = None,
      commentId: Option[String] = None
    ): DeleteCommentRequest =
      DeleteCommentRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(commentId)(_.commentId(_))
        .build

    def deleteCustomMetadataRequest(
      authenticationToken: Option[String] = None,
      resourceId: Option[String] = None,
      versionId: Option[String] = None,
      keys: Option[List[CustomMetadataKeyType]] = None,
      deleteAll: Option[Boolean] = None
    ): DeleteCustomMetadataRequest =
      DeleteCustomMetadataRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(deleteAll)(_.deleteAll(_))
        .build

    def deleteCustomMetadataResponse(

    ): DeleteCustomMetadataResponse =
      DeleteCustomMetadataResponse
        .builder

        .build

    def deleteDocumentRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None
    ): DeleteDocumentRequest =
      DeleteDocumentRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .build

    def deleteFolderContentsRequest(
      authenticationToken: Option[String] = None,
      folderId: Option[String] = None
    ): DeleteFolderContentsRequest =
      DeleteFolderContentsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(folderId)(_.folderId(_))
        .build

    def deleteFolderRequest(
      authenticationToken: Option[String] = None,
      folderId: Option[String] = None
    ): DeleteFolderRequest =
      DeleteFolderRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(folderId)(_.folderId(_))
        .build

    def deleteLabelsRequest(
      resourceId: Option[String] = None,
      authenticationToken: Option[String] = None,
      labels: Option[List[SharedLabel]] = None,
      deleteAll: Option[Boolean] = None
    ): DeleteLabelsRequest =
      DeleteLabelsRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(deleteAll)(_.deleteAll(_))
        .build

    def deleteLabelsResponse(

    ): DeleteLabelsResponse =
      DeleteLabelsResponse
        .builder

        .build

    def deleteNotificationSubscriptionRequest(
      subscriptionId: Option[String] = None,
      organizationId: Option[String] = None
    ): DeleteNotificationSubscriptionRequest =
      DeleteNotificationSubscriptionRequest
        .builder
        .ifSome(subscriptionId)(_.subscriptionId(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def deleteUserRequest(
      authenticationToken: Option[String] = None,
      userId: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(userId)(_.userId(_))
        .build

    def describeActivitiesRequest(
      authenticationToken: Option[String] = None,
      startTime: Option[TimestampType] = None,
      endTime: Option[TimestampType] = None,
      organizationId: Option[String] = None,
      activityTypes: Option[String] = None,
      resourceId: Option[String] = None,
      userId: Option[String] = None,
      includeIndirectActivities: Option[Boolean] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeActivitiesRequest =
      DescribeActivitiesRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(activityTypes)(_.activityTypes(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(includeIndirectActivities)(_.includeIndirectActivities(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeActivitiesResponse(
      userActivities: Option[List[Activity]] = None,
      marker: Option[String] = None
    ): DescribeActivitiesResponse =
      DescribeActivitiesResponse
        .builder
        .ifSome(userActivities)(_.userActivities(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCommentsRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      versionId: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCommentsRequest =
      DescribeCommentsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCommentsResponse(
      comments: Option[List[Comment]] = None,
      marker: Option[String] = None
    ): DescribeCommentsResponse =
      DescribeCommentsResponse
        .builder
        .ifSome(comments)(_.comments(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeDocumentVersionsRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None,
      include: Option[String] = None,
      fields: Option[String] = None
    ): DescribeDocumentVersionsRequest =
      DescribeDocumentVersionsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(include)(_.include(_))
        .ifSome(fields)(_.fields(_))
        .build

    def describeDocumentVersionsResponse(
      documentVersions: Option[List[DocumentVersionMetadata]] = None,
      marker: Option[String] = None
    ): DescribeDocumentVersionsResponse =
      DescribeDocumentVersionsResponse
        .builder
        .ifSome(documentVersions)(_.documentVersions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeFolderContentsRequest(
      authenticationToken: Option[String] = None,
      folderId: Option[String] = None,
      sort: Option[String] = None,
      order: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None,
      `type`: Option[String] = None,
      include: Option[String] = None
    ): DescribeFolderContentsRequest =
      DescribeFolderContentsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(folderId)(_.folderId(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(order)(_.order(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(include)(_.include(_))
        .build

    def describeFolderContentsResponse(
      folders: Option[List[FolderMetadata]] = None,
      documents: Option[List[DocumentMetadata]] = None,
      marker: Option[String] = None
    ): DescribeFolderContentsResponse =
      DescribeFolderContentsResponse
        .builder
        .ifSome(folders)(_.folders(_))
        .ifSome(documents)(_.documents(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeGroupsRequest(
      authenticationToken: Option[String] = None,
      searchQuery: Option[String] = None,
      organizationId: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeGroupsRequest =
      DescribeGroupsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(searchQuery)(_.searchQuery(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeGroupsResponse(
      groups: Option[List[GroupMetadata]] = None,
      marker: Option[String] = None
    ): DescribeGroupsResponse =
      DescribeGroupsResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeNotificationSubscriptionsRequest(
      organizationId: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None
    ): DescribeNotificationSubscriptionsRequest =
      DescribeNotificationSubscriptionsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .build

    def describeNotificationSubscriptionsResponse(
      subscriptions: Option[List[Subscription]] = None,
      marker: Option[String] = None
    ): DescribeNotificationSubscriptionsResponse =
      DescribeNotificationSubscriptionsResponse
        .builder
        .ifSome(subscriptions)(_.subscriptions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeResourcePermissionsRequest(
      authenticationToken: Option[String] = None,
      resourceId: Option[String] = None,
      principalId: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeResourcePermissionsRequest =
      DescribeResourcePermissionsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeResourcePermissionsResponse(
      principals: Option[List[Principal]] = None,
      marker: Option[String] = None
    ): DescribeResourcePermissionsResponse =
      DescribeResourcePermissionsResponse
        .builder
        .ifSome(principals)(_.principals(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeRootFoldersRequest(
      authenticationToken: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeRootFoldersRequest =
      DescribeRootFoldersRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeRootFoldersResponse(
      folders: Option[List[FolderMetadata]] = None,
      marker: Option[String] = None
    ): DescribeRootFoldersResponse =
      DescribeRootFoldersResponse
        .builder
        .ifSome(folders)(_.folders(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeUsersRequest(
      authenticationToken: Option[String] = None,
      organizationId: Option[String] = None,
      userIds: Option[String] = None,
      query: Option[String] = None,
      include: Option[String] = None,
      order: Option[String] = None,
      sort: Option[String] = None,
      marker: Option[String] = None,
      limit: Option[Int] = None,
      fields: Option[String] = None
    ): DescribeUsersRequest =
      DescribeUsersRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(query)(_.query(_))
        .ifSome(include)(_.include(_))
        .ifSome(order)(_.order(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(fields)(_.fields(_))
        .build

    def describeUsersResponse(
      users: Option[List[User]] = None,
      totalNumberOfUsers: Option[SizeType] = None,
      marker: Option[String] = None
    ): DescribeUsersResponse =
      DescribeUsersResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(totalNumberOfUsers)(_.totalNumberOfUsers(_))
        .ifSome(marker)(_.marker(_))
        .build

    def documentLockedForCommentsException(
      message: Option[String] = None
    ): DocumentLockedForCommentsException =
      DocumentLockedForCommentsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def documentMetadata(
      id: Option[String] = None,
      creatorId: Option[String] = None,
      parentFolderId: Option[String] = None,
      createdTimestamp: Option[TimestampType] = None,
      modifiedTimestamp: Option[TimestampType] = None,
      latestVersionMetadata: Option[DocumentVersionMetadata] = None,
      resourceState: Option[String] = None,
      labels: Option[List[SharedLabel]] = None
    ): DocumentMetadata =
      DocumentMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(creatorId)(_.creatorId(_))
        .ifSome(parentFolderId)(_.parentFolderId(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(modifiedTimestamp)(_.modifiedTimestamp(_))
        .ifSome(latestVersionMetadata)(_.latestVersionMetadata(_))
        .ifSome(resourceState)(_.resourceState(_))
        .ifSome(labels)(_.labels(_))
        .build

    def documentVersionMetadata(
      id: Option[String] = None,
      name: Option[String] = None,
      contentType: Option[String] = None,
      size: Option[SizeType] = None,
      signature: Option[String] = None,
      status: Option[String] = None,
      createdTimestamp: Option[TimestampType] = None,
      modifiedTimestamp: Option[TimestampType] = None,
      contentCreatedTimestamp: Option[TimestampType] = None,
      contentModifiedTimestamp: Option[TimestampType] = None,
      creatorId: Option[String] = None,
      thumbnail: Option[DocumentThumbnailUrlMap] = None,
      source: Option[DocumentSourceUrlMap] = None
    ): DocumentVersionMetadata =
      DocumentVersionMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(size)(_.size(_))
        .ifSome(signature)(_.signature(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(modifiedTimestamp)(_.modifiedTimestamp(_))
        .ifSome(contentCreatedTimestamp)(_.contentCreatedTimestamp(_))
        .ifSome(contentModifiedTimestamp)(_.contentModifiedTimestamp(_))
        .ifSome(creatorId)(_.creatorId(_))
        .ifSome(thumbnail)(_.thumbnail(_))
        .ifSome(source)(_.source(_))
        .build

    def draftUploadOutOfSyncException(
      message: Option[String] = None
    ): DraftUploadOutOfSyncException =
      DraftUploadOutOfSyncException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entityAlreadyExistsException(
      message: Option[String] = None
    ): EntityAlreadyExistsException =
      EntityAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entityNotExistsException(
      message: Option[String] = None,
      entityIds: Option[List[IdType]] = None
    ): EntityNotExistsException =
      EntityNotExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(entityIds)(_.entityIds(_))
        .build

    def failedDependencyException(
      message: Option[String] = None
    ): FailedDependencyException =
      FailedDependencyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def folderMetadata(
      id: Option[String] = None,
      name: Option[String] = None,
      creatorId: Option[String] = None,
      parentFolderId: Option[String] = None,
      createdTimestamp: Option[TimestampType] = None,
      modifiedTimestamp: Option[TimestampType] = None,
      resourceState: Option[String] = None,
      signature: Option[String] = None,
      labels: Option[List[SharedLabel]] = None,
      size: Option[SizeType] = None,
      latestVersionSize: Option[SizeType] = None
    ): FolderMetadata =
      FolderMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(creatorId)(_.creatorId(_))
        .ifSome(parentFolderId)(_.parentFolderId(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(modifiedTimestamp)(_.modifiedTimestamp(_))
        .ifSome(resourceState)(_.resourceState(_))
        .ifSome(signature)(_.signature(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(size)(_.size(_))
        .ifSome(latestVersionSize)(_.latestVersionSize(_))
        .build

    def getCurrentUserRequest(
      authenticationToken: Option[String] = None
    ): GetCurrentUserRequest =
      GetCurrentUserRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .build

    def getCurrentUserResponse(
      user: Option[User] = None
    ): GetCurrentUserResponse =
      GetCurrentUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def getDocumentPathRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      limit: Option[Int] = None,
      fields: Option[String] = None,
      marker: Option[String] = None
    ): GetDocumentPathRequest =
      GetDocumentPathRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getDocumentPathResponse(
      path: Option[ResourcePath] = None
    ): GetDocumentPathResponse =
      GetDocumentPathResponse
        .builder
        .ifSome(path)(_.path(_))
        .build

    def getDocumentRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      includeCustomMetadata: Option[Boolean] = None
    ): GetDocumentRequest =
      GetDocumentRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(includeCustomMetadata)(_.includeCustomMetadata(_))
        .build

    def getDocumentResponse(
      metadata: Option[DocumentMetadata] = None,
      customMetadata: Option[CustomMetadataMap] = None
    ): GetDocumentResponse =
      GetDocumentResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(customMetadata)(_.customMetadata(_))
        .build

    def getDocumentVersionRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      versionId: Option[String] = None,
      fields: Option[String] = None,
      includeCustomMetadata: Option[Boolean] = None
    ): GetDocumentVersionRequest =
      GetDocumentVersionRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(includeCustomMetadata)(_.includeCustomMetadata(_))
        .build

    def getDocumentVersionResponse(
      metadata: Option[DocumentVersionMetadata] = None,
      customMetadata: Option[CustomMetadataMap] = None
    ): GetDocumentVersionResponse =
      GetDocumentVersionResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(customMetadata)(_.customMetadata(_))
        .build

    def getFolderPathRequest(
      authenticationToken: Option[String] = None,
      folderId: Option[String] = None,
      limit: Option[Int] = None,
      fields: Option[String] = None,
      marker: Option[String] = None
    ): GetFolderPathRequest =
      GetFolderPathRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(folderId)(_.folderId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(fields)(_.fields(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getFolderPathResponse(
      path: Option[ResourcePath] = None
    ): GetFolderPathResponse =
      GetFolderPathResponse
        .builder
        .ifSome(path)(_.path(_))
        .build

    def getFolderRequest(
      authenticationToken: Option[String] = None,
      folderId: Option[String] = None,
      includeCustomMetadata: Option[Boolean] = None
    ): GetFolderRequest =
      GetFolderRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(folderId)(_.folderId(_))
        .ifSome(includeCustomMetadata)(_.includeCustomMetadata(_))
        .build

    def getFolderResponse(
      metadata: Option[FolderMetadata] = None,
      customMetadata: Option[CustomMetadataMap] = None
    ): GetFolderResponse =
      GetFolderResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(customMetadata)(_.customMetadata(_))
        .build

    def getResourcesRequest(
      authenticationToken: Option[String] = None,
      userId: Option[String] = None,
      collectionType: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): GetResourcesRequest =
      GetResourcesRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(collectionType)(_.collectionType(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getResourcesResponse(
      folders: Option[List[FolderMetadata]] = None,
      documents: Option[List[DocumentMetadata]] = None,
      marker: Option[String] = None
    ): GetResourcesResponse =
      GetResourcesResponse
        .builder
        .ifSome(folders)(_.folders(_))
        .ifSome(documents)(_.documents(_))
        .ifSome(marker)(_.marker(_))
        .build

    def groupMetadata(
      id: Option[String] = None,
      name: Option[String] = None
    ): GroupMetadata =
      GroupMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def illegalUserStateException(
      message: Option[String] = None
    ): IllegalUserStateException =
      IllegalUserStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def initiateDocumentVersionUploadRequest(
      authenticationToken: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      contentCreatedTimestamp: Option[TimestampType] = None,
      contentModifiedTimestamp: Option[TimestampType] = None,
      contentType: Option[String] = None,
      documentSizeInBytes: Option[SizeType] = None,
      parentFolderId: Option[String] = None
    ): InitiateDocumentVersionUploadRequest =
      InitiateDocumentVersionUploadRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(contentCreatedTimestamp)(_.contentCreatedTimestamp(_))
        .ifSome(contentModifiedTimestamp)(_.contentModifiedTimestamp(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(documentSizeInBytes)(_.documentSizeInBytes(_))
        .ifSome(parentFolderId)(_.parentFolderId(_))
        .build

    def initiateDocumentVersionUploadResponse(
      metadata: Option[DocumentMetadata] = None,
      uploadMetadata: Option[UploadMetadata] = None
    ): InitiateDocumentVersionUploadResponse =
      InitiateDocumentVersionUploadResponse
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(uploadMetadata)(_.uploadMetadata(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCommentOperationException(
      message: Option[String] = None
    ): InvalidCommentOperationException =
      InvalidCommentOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOperationException(
      message: Option[String] = None
    ): InvalidOperationException =
      InvalidOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPasswordException(
      message: Option[String] = None
    ): InvalidPasswordException =
      InvalidPasswordException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notificationOptions(
      sendEmail: Option[Boolean] = None,
      emailMessage: Option[String] = None
    ): NotificationOptions =
      NotificationOptions
        .builder
        .ifSome(sendEmail)(_.sendEmail(_))
        .ifSome(emailMessage)(_.emailMessage(_))
        .build

    def participants(
      users: Option[List[UserMetadata]] = None,
      groups: Option[List[GroupMetadata]] = None
    ): Participants =
      Participants
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(groups)(_.groups(_))
        .build

    def permissionInfo(
      role: Option[String] = None,
      `type`: Option[String] = None
    ): PermissionInfo =
      PermissionInfo
        .builder
        .ifSome(role)(_.role(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def principal(
      id: Option[String] = None,
      `type`: Option[String] = None,
      roles: Option[List[PermissionInfo]] = None
    ): Principal =
      Principal
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(roles)(_.roles(_))
        .build

    def prohibitedStateException(
      message: Option[String] = None
    ): ProhibitedStateException =
      ProhibitedStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def removeAllResourcePermissionsRequest(
      authenticationToken: Option[String] = None,
      resourceId: Option[String] = None
    ): RemoveAllResourcePermissionsRequest =
      RemoveAllResourcePermissionsRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def removeResourcePermissionRequest(
      authenticationToken: Option[String] = None,
      resourceId: Option[String] = None,
      principalId: Option[String] = None,
      principalType: Option[String] = None
    ): RemoveResourcePermissionRequest =
      RemoveResourcePermissionRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(principalType)(_.principalType(_))
        .build

    def requestedEntityTooLargeException(
      message: Option[String] = None
    ): RequestedEntityTooLargeException =
      RequestedEntityTooLargeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceAlreadyCheckedOutException(
      message: Option[String] = None
    ): ResourceAlreadyCheckedOutException =
      ResourceAlreadyCheckedOutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceMetadata(
      `type`: Option[String] = None,
      name: Option[String] = None,
      originalName: Option[String] = None,
      id: Option[String] = None,
      versionId: Option[String] = None,
      owner: Option[UserMetadata] = None,
      parentId: Option[String] = None
    ): ResourceMetadata =
      ResourceMetadata
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(originalName)(_.originalName(_))
        .ifSome(id)(_.id(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(parentId)(_.parentId(_))
        .build

    def resourcePath(
      components: Option[List[ResourcePathComponent]] = None
    ): ResourcePath =
      ResourcePath
        .builder
        .ifSome(components)(_.components(_))
        .build

    def resourcePathComponent(
      id: Option[String] = None,
      name: Option[String] = None
    ): ResourcePathComponent =
      ResourcePathComponent
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sharePrincipal(
      id: Option[String] = None,
      `type`: Option[String] = None,
      role: Option[String] = None
    ): SharePrincipal =
      SharePrincipal
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(role)(_.role(_))
        .build

    def storageLimitExceededException(
      message: Option[String] = None
    ): StorageLimitExceededException =
      StorageLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def storageLimitWillExceedException(
      message: Option[String] = None
    ): StorageLimitWillExceedException =
      StorageLimitWillExceedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def storageRuleType(
      storageAllocatedInBytes: Option[PositiveSizeType] = None,
      storageType: Option[String] = None
    ): StorageRuleType =
      StorageRuleType
        .builder
        .ifSome(storageAllocatedInBytes)(_.storageAllocatedInBytes(_))
        .ifSome(storageType)(_.storageType(_))
        .build

    def subscription(
      subscriptionId: Option[String] = None,
      endPoint: Option[String] = None,
      protocol: Option[String] = None
    ): Subscription =
      Subscription
        .builder
        .ifSome(subscriptionId)(_.subscriptionId(_))
        .ifSome(endPoint)(_.endPoint(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def tooManyLabelsException(
      message: Option[String] = None
    ): TooManyLabelsException =
      TooManyLabelsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManySubscriptionsException(
      message: Option[String] = None
    ): TooManySubscriptionsException =
      TooManySubscriptionsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedOperationException(

    ): UnauthorizedOperationException =
      UnauthorizedOperationException
        .builder

        .build

    def unauthorizedResourceAccessException(
      message: Option[String] = None
    ): UnauthorizedResourceAccessException =
      UnauthorizedResourceAccessException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def updateDocumentRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      name: Option[String] = None,
      parentFolderId: Option[String] = None,
      resourceState: Option[String] = None
    ): UpdateDocumentRequest =
      UpdateDocumentRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(name)(_.name(_))
        .ifSome(parentFolderId)(_.parentFolderId(_))
        .ifSome(resourceState)(_.resourceState(_))
        .build

    def updateDocumentVersionRequest(
      authenticationToken: Option[String] = None,
      documentId: Option[String] = None,
      versionId: Option[String] = None,
      versionStatus: Option[String] = None
    ): UpdateDocumentVersionRequest =
      UpdateDocumentVersionRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(versionStatus)(_.versionStatus(_))
        .build

    def updateFolderRequest(
      authenticationToken: Option[String] = None,
      folderId: Option[String] = None,
      name: Option[String] = None,
      parentFolderId: Option[String] = None,
      resourceState: Option[String] = None
    ): UpdateFolderRequest =
      UpdateFolderRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(folderId)(_.folderId(_))
        .ifSome(name)(_.name(_))
        .ifSome(parentFolderId)(_.parentFolderId(_))
        .ifSome(resourceState)(_.resourceState(_))
        .build

    def updateUserRequest(
      authenticationToken: Option[String] = None,
      userId: Option[String] = None,
      givenName: Option[String] = None,
      surname: Option[String] = None,
      `type`: Option[String] = None,
      storageRule: Option[StorageRuleType] = None,
      timeZoneId: Option[String] = None,
      locale: Option[String] = None,
      grantPoweruserPrivileges: Option[String] = None
    ): UpdateUserRequest =
      UpdateUserRequest
        .builder
        .ifSome(authenticationToken)(_.authenticationToken(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(givenName)(_.givenName(_))
        .ifSome(surname)(_.surname(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(storageRule)(_.storageRule(_))
        .ifSome(timeZoneId)(_.timeZoneId(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(grantPoweruserPrivileges)(_.grantPoweruserPrivileges(_))
        .build

    def updateUserResponse(
      user: Option[User] = None
    ): UpdateUserResponse =
      UpdateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def uploadMetadata(
      uploadUrl: Option[String] = None,
      signedHeaders: Option[SignedHeaderMap] = None
    ): UploadMetadata =
      UploadMetadata
        .builder
        .ifSome(uploadUrl)(_.uploadUrl(_))
        .ifSome(signedHeaders)(_.signedHeaders(_))
        .build

    def user(
      id: Option[String] = None,
      username: Option[String] = None,
      emailAddress: Option[String] = None,
      givenName: Option[String] = None,
      surname: Option[String] = None,
      organizationId: Option[String] = None,
      rootFolderId: Option[String] = None,
      recycleBinFolderId: Option[String] = None,
      status: Option[String] = None,
      `type`: Option[String] = None,
      createdTimestamp: Option[TimestampType] = None,
      modifiedTimestamp: Option[TimestampType] = None,
      timeZoneId: Option[String] = None,
      locale: Option[String] = None,
      storage: Option[UserStorageMetadata] = None
    ): User =
      User
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(username)(_.username(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(givenName)(_.givenName(_))
        .ifSome(surname)(_.surname(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(rootFolderId)(_.rootFolderId(_))
        .ifSome(recycleBinFolderId)(_.recycleBinFolderId(_))
        .ifSome(status)(_.status(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(modifiedTimestamp)(_.modifiedTimestamp(_))
        .ifSome(timeZoneId)(_.timeZoneId(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(storage)(_.storage(_))
        .build

    def userMetadata(
      id: Option[String] = None,
      username: Option[String] = None,
      givenName: Option[String] = None,
      surname: Option[String] = None,
      emailAddress: Option[String] = None
    ): UserMetadata =
      UserMetadata
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(username)(_.username(_))
        .ifSome(givenName)(_.givenName(_))
        .ifSome(surname)(_.surname(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def userStorageMetadata(
      storageUtilizedInBytes: Option[SizeType] = None,
      storageRule: Option[StorageRuleType] = None
    ): UserStorageMetadata =
      UserStorageMetadata
        .builder
        .ifSome(storageUtilizedInBytes)(_.storageUtilizedInBytes(_))
        .ifSome(storageRule)(_.storageRule(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
