package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.workdocs.WorkDocsClient
import software.amazon.awssdk.services.workdocs.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object workdocs { module =>

  // Free monad over WorkDocsOp
  type WorkDocsIO[A] = FF[WorkDocsOp, A]

  sealed trait WorkDocsOp[A] {
    def visit[F[_]](visitor: WorkDocsOp.Visitor[F]): F[A]
  }

  object WorkDocsOp {
    // Given a WorkDocsClient we can embed a WorkDocsIO program in any algebra that understands embedding.
    implicit val WorkDocsOpEmbeddable: Embeddable[WorkDocsOp, WorkDocsClient] = new Embeddable[WorkDocsOp, WorkDocsClient] {
      def embed[A](client: WorkDocsClient, io: WorkDocsIO[A]): Embedded[A] = Embedded.WorkDocs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WorkDocsOp.Visitor[Kleisli[M, WorkDocsClient, *]] {
        def abortDocumentVersionUpload(
          request: AbortDocumentVersionUploadRequest
        ): Kleisli[M, WorkDocsClient, AbortDocumentVersionUploadResponse] =
          primitive(_.abortDocumentVersionUpload(request))

        def activateUser(
          request: ActivateUserRequest
        ): Kleisli[M, WorkDocsClient, ActivateUserResponse] =
          primitive(_.activateUser(request))

        def addResourcePermissions(
          request: AddResourcePermissionsRequest
        ): Kleisli[M, WorkDocsClient, AddResourcePermissionsResponse] =
          primitive(_.addResourcePermissions(request))

        def createComment(
          request: CreateCommentRequest
        ): Kleisli[M, WorkDocsClient, CreateCommentResponse] =
          primitive(_.createComment(request))

        def createCustomMetadata(
          request: CreateCustomMetadataRequest
        ): Kleisli[M, WorkDocsClient, CreateCustomMetadataResponse] =
          primitive(_.createCustomMetadata(request))

        def createFolder(
          request: CreateFolderRequest
        ): Kleisli[M, WorkDocsClient, CreateFolderResponse] =
          primitive(_.createFolder(request))

        def createLabels(
          request: CreateLabelsRequest
        ): Kleisli[M, WorkDocsClient, CreateLabelsResponse] =
          primitive(_.createLabels(request))

        def createNotificationSubscription(
          request: CreateNotificationSubscriptionRequest
        ): Kleisli[M, WorkDocsClient, CreateNotificationSubscriptionResponse] =
          primitive(_.createNotificationSubscription(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, WorkDocsClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def deactivateUser(
          request: DeactivateUserRequest
        ): Kleisli[M, WorkDocsClient, DeactivateUserResponse] =
          primitive(_.deactivateUser(request))

        def deleteComment(
          request: DeleteCommentRequest
        ): Kleisli[M, WorkDocsClient, DeleteCommentResponse] =
          primitive(_.deleteComment(request))

        def deleteCustomMetadata(
          request: DeleteCustomMetadataRequest
        ): Kleisli[M, WorkDocsClient, DeleteCustomMetadataResponse] =
          primitive(_.deleteCustomMetadata(request))

        def deleteDocument(
          request: DeleteDocumentRequest
        ): Kleisli[M, WorkDocsClient, DeleteDocumentResponse] =
          primitive(_.deleteDocument(request))

        def deleteFolder(
          request: DeleteFolderRequest
        ): Kleisli[M, WorkDocsClient, DeleteFolderResponse] =
          primitive(_.deleteFolder(request))

        def deleteFolderContents(
          request: DeleteFolderContentsRequest
        ): Kleisli[M, WorkDocsClient, DeleteFolderContentsResponse] =
          primitive(_.deleteFolderContents(request))

        def deleteLabels(
          request: DeleteLabelsRequest
        ): Kleisli[M, WorkDocsClient, DeleteLabelsResponse] =
          primitive(_.deleteLabels(request))

        def deleteNotificationSubscription(
          request: DeleteNotificationSubscriptionRequest
        ): Kleisli[M, WorkDocsClient, DeleteNotificationSubscriptionResponse] =
          primitive(_.deleteNotificationSubscription(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, WorkDocsClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def describeActivities(
          request: DescribeActivitiesRequest
        ): Kleisli[M, WorkDocsClient, DescribeActivitiesResponse] =
          primitive(_.describeActivities(request))

        def describeComments(
          request: DescribeCommentsRequest
        ): Kleisli[M, WorkDocsClient, DescribeCommentsResponse] =
          primitive(_.describeComments(request))

        def describeDocumentVersions(
          request: DescribeDocumentVersionsRequest
        ): Kleisli[M, WorkDocsClient, DescribeDocumentVersionsResponse] =
          primitive(_.describeDocumentVersions(request))

        def describeFolderContents(
          request: DescribeFolderContentsRequest
        ): Kleisli[M, WorkDocsClient, DescribeFolderContentsResponse] =
          primitive(_.describeFolderContents(request))

        def describeGroups(
          request: DescribeGroupsRequest
        ): Kleisli[M, WorkDocsClient, DescribeGroupsResponse] =
          primitive(_.describeGroups(request))

        def describeNotificationSubscriptions(
          request: DescribeNotificationSubscriptionsRequest
        ): Kleisli[M, WorkDocsClient, DescribeNotificationSubscriptionsResponse] =
          primitive(_.describeNotificationSubscriptions(request))

        def describeResourcePermissions(
          request: DescribeResourcePermissionsRequest
        ): Kleisli[M, WorkDocsClient, DescribeResourcePermissionsResponse] =
          primitive(_.describeResourcePermissions(request))

        def describeRootFolders(
          request: DescribeRootFoldersRequest
        ): Kleisli[M, WorkDocsClient, DescribeRootFoldersResponse] =
          primitive(_.describeRootFolders(request))

        def describeUsers(
          request: DescribeUsersRequest
        ): Kleisli[M, WorkDocsClient, DescribeUsersResponse] =
          primitive(_.describeUsers(request))

        def getCurrentUser(
          request: GetCurrentUserRequest
        ): Kleisli[M, WorkDocsClient, GetCurrentUserResponse] =
          primitive(_.getCurrentUser(request))

        def getDocument(
          request: GetDocumentRequest
        ): Kleisli[M, WorkDocsClient, GetDocumentResponse] =
          primitive(_.getDocument(request))

        def getDocumentPath(
          request: GetDocumentPathRequest
        ): Kleisli[M, WorkDocsClient, GetDocumentPathResponse] =
          primitive(_.getDocumentPath(request))

        def getDocumentVersion(
          request: GetDocumentVersionRequest
        ): Kleisli[M, WorkDocsClient, GetDocumentVersionResponse] =
          primitive(_.getDocumentVersion(request))

        def getFolder(
          request: GetFolderRequest
        ): Kleisli[M, WorkDocsClient, GetFolderResponse] =
          primitive(_.getFolder(request))

        def getFolderPath(
          request: GetFolderPathRequest
        ): Kleisli[M, WorkDocsClient, GetFolderPathResponse] =
          primitive(_.getFolderPath(request))

        def getResources(
          request: GetResourcesRequest
        ): Kleisli[M, WorkDocsClient, GetResourcesResponse] =
          primitive(_.getResources(request))

        def initiateDocumentVersionUpload(
          request: InitiateDocumentVersionUploadRequest
        ): Kleisli[M, WorkDocsClient, InitiateDocumentVersionUploadResponse] =
          primitive(_.initiateDocumentVersionUpload(request))

        def removeAllResourcePermissions(
          request: RemoveAllResourcePermissionsRequest
        ): Kleisli[M, WorkDocsClient, RemoveAllResourcePermissionsResponse] =
          primitive(_.removeAllResourcePermissions(request))

        def removeResourcePermission(
          request: RemoveResourcePermissionRequest
        ): Kleisli[M, WorkDocsClient, RemoveResourcePermissionResponse] =
          primitive(_.removeResourcePermission(request))

        def updateDocument(
          request: UpdateDocumentRequest
        ): Kleisli[M, WorkDocsClient, UpdateDocumentResponse] =
          primitive(_.updateDocument(request))

        def updateDocumentVersion(
          request: UpdateDocumentVersionRequest
        ): Kleisli[M, WorkDocsClient, UpdateDocumentVersionResponse] =
          primitive(_.updateDocumentVersion(request))

        def updateFolder(
          request: UpdateFolderRequest
        ): Kleisli[M, WorkDocsClient, UpdateFolderResponse] =
          primitive(_.updateFolder(request))

        def updateUser(
          request: UpdateUserRequest
        ): Kleisli[M, WorkDocsClient, UpdateUserResponse] =
          primitive(_.updateUser(request))

        def primitive[A](
          f: WorkDocsClient => A
        ): Kleisli[M, WorkDocsClient, A]
      }
    }

    trait Visitor[F[_]] extends (WorkDocsOp ~> F) {
      final def apply[A](op: WorkDocsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def abortDocumentVersionUpload(
        request: AbortDocumentVersionUploadRequest
      ): F[AbortDocumentVersionUploadResponse]

      def activateUser(
        request: ActivateUserRequest
      ): F[ActivateUserResponse]

      def addResourcePermissions(
        request: AddResourcePermissionsRequest
      ): F[AddResourcePermissionsResponse]

      def createComment(
        request: CreateCommentRequest
      ): F[CreateCommentResponse]

      def createCustomMetadata(
        request: CreateCustomMetadataRequest
      ): F[CreateCustomMetadataResponse]

      def createFolder(
        request: CreateFolderRequest
      ): F[CreateFolderResponse]

      def createLabels(
        request: CreateLabelsRequest
      ): F[CreateLabelsResponse]

      def createNotificationSubscription(
        request: CreateNotificationSubscriptionRequest
      ): F[CreateNotificationSubscriptionResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def deactivateUser(
        request: DeactivateUserRequest
      ): F[DeactivateUserResponse]

      def deleteComment(
        request: DeleteCommentRequest
      ): F[DeleteCommentResponse]

      def deleteCustomMetadata(
        request: DeleteCustomMetadataRequest
      ): F[DeleteCustomMetadataResponse]

      def deleteDocument(
        request: DeleteDocumentRequest
      ): F[DeleteDocumentResponse]

      def deleteFolder(
        request: DeleteFolderRequest
      ): F[DeleteFolderResponse]

      def deleteFolderContents(
        request: DeleteFolderContentsRequest
      ): F[DeleteFolderContentsResponse]

      def deleteLabels(
        request: DeleteLabelsRequest
      ): F[DeleteLabelsResponse]

      def deleteNotificationSubscription(
        request: DeleteNotificationSubscriptionRequest
      ): F[DeleteNotificationSubscriptionResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def describeActivities(
        request: DescribeActivitiesRequest
      ): F[DescribeActivitiesResponse]

      def describeComments(
        request: DescribeCommentsRequest
      ): F[DescribeCommentsResponse]

      def describeDocumentVersions(
        request: DescribeDocumentVersionsRequest
      ): F[DescribeDocumentVersionsResponse]

      def describeFolderContents(
        request: DescribeFolderContentsRequest
      ): F[DescribeFolderContentsResponse]

      def describeGroups(
        request: DescribeGroupsRequest
      ): F[DescribeGroupsResponse]

      def describeNotificationSubscriptions(
        request: DescribeNotificationSubscriptionsRequest
      ): F[DescribeNotificationSubscriptionsResponse]

      def describeResourcePermissions(
        request: DescribeResourcePermissionsRequest
      ): F[DescribeResourcePermissionsResponse]

      def describeRootFolders(
        request: DescribeRootFoldersRequest
      ): F[DescribeRootFoldersResponse]

      def describeUsers(
        request: DescribeUsersRequest
      ): F[DescribeUsersResponse]

      def getCurrentUser(
        request: GetCurrentUserRequest
      ): F[GetCurrentUserResponse]

      def getDocument(
        request: GetDocumentRequest
      ): F[GetDocumentResponse]

      def getDocumentPath(
        request: GetDocumentPathRequest
      ): F[GetDocumentPathResponse]

      def getDocumentVersion(
        request: GetDocumentVersionRequest
      ): F[GetDocumentVersionResponse]

      def getFolder(
        request: GetFolderRequest
      ): F[GetFolderResponse]

      def getFolderPath(
        request: GetFolderPathRequest
      ): F[GetFolderPathResponse]

      def getResources(
        request: GetResourcesRequest
      ): F[GetResourcesResponse]

      def initiateDocumentVersionUpload(
        request: InitiateDocumentVersionUploadRequest
      ): F[InitiateDocumentVersionUploadResponse]

      def removeAllResourcePermissions(
        request: RemoveAllResourcePermissionsRequest
      ): F[RemoveAllResourcePermissionsResponse]

      def removeResourcePermission(
        request: RemoveResourcePermissionRequest
      ): F[RemoveResourcePermissionResponse]

      def updateDocument(
        request: UpdateDocumentRequest
      ): F[UpdateDocumentResponse]

      def updateDocumentVersion(
        request: UpdateDocumentVersionRequest
      ): F[UpdateDocumentVersionResponse]

      def updateFolder(
        request: UpdateFolderRequest
      ): F[UpdateFolderResponse]

      def updateUser(
        request: UpdateUserRequest
      ): F[UpdateUserResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WorkDocsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AbortDocumentVersionUploadOp(
      request: AbortDocumentVersionUploadRequest
    ) extends WorkDocsOp[AbortDocumentVersionUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AbortDocumentVersionUploadResponse] =
        visitor.abortDocumentVersionUpload(request)
    }

    final case class ActivateUserOp(
      request: ActivateUserRequest
    ) extends WorkDocsOp[ActivateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivateUserResponse] =
        visitor.activateUser(request)
    }

    final case class AddResourcePermissionsOp(
      request: AddResourcePermissionsRequest
    ) extends WorkDocsOp[AddResourcePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddResourcePermissionsResponse] =
        visitor.addResourcePermissions(request)
    }

    final case class CreateCommentOp(
      request: CreateCommentRequest
    ) extends WorkDocsOp[CreateCommentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCommentResponse] =
        visitor.createComment(request)
    }

    final case class CreateCustomMetadataOp(
      request: CreateCustomMetadataRequest
    ) extends WorkDocsOp[CreateCustomMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomMetadataResponse] =
        visitor.createCustomMetadata(request)
    }

    final case class CreateFolderOp(
      request: CreateFolderRequest
    ) extends WorkDocsOp[CreateFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFolderResponse] =
        visitor.createFolder(request)
    }

    final case class CreateLabelsOp(
      request: CreateLabelsRequest
    ) extends WorkDocsOp[CreateLabelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLabelsResponse] =
        visitor.createLabels(request)
    }

    final case class CreateNotificationSubscriptionOp(
      request: CreateNotificationSubscriptionRequest
    ) extends WorkDocsOp[CreateNotificationSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNotificationSubscriptionResponse] =
        visitor.createNotificationSubscription(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends WorkDocsOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class DeactivateUserOp(
      request: DeactivateUserRequest
    ) extends WorkDocsOp[DeactivateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeactivateUserResponse] =
        visitor.deactivateUser(request)
    }

    final case class DeleteCommentOp(
      request: DeleteCommentRequest
    ) extends WorkDocsOp[DeleteCommentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCommentResponse] =
        visitor.deleteComment(request)
    }

    final case class DeleteCustomMetadataOp(
      request: DeleteCustomMetadataRequest
    ) extends WorkDocsOp[DeleteCustomMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomMetadataResponse] =
        visitor.deleteCustomMetadata(request)
    }

    final case class DeleteDocumentOp(
      request: DeleteDocumentRequest
    ) extends WorkDocsOp[DeleteDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDocumentResponse] =
        visitor.deleteDocument(request)
    }

    final case class DeleteFolderOp(
      request: DeleteFolderRequest
    ) extends WorkDocsOp[DeleteFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFolderResponse] =
        visitor.deleteFolder(request)
    }

    final case class DeleteFolderContentsOp(
      request: DeleteFolderContentsRequest
    ) extends WorkDocsOp[DeleteFolderContentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFolderContentsResponse] =
        visitor.deleteFolderContents(request)
    }

    final case class DeleteLabelsOp(
      request: DeleteLabelsRequest
    ) extends WorkDocsOp[DeleteLabelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLabelsResponse] =
        visitor.deleteLabels(request)
    }

    final case class DeleteNotificationSubscriptionOp(
      request: DeleteNotificationSubscriptionRequest
    ) extends WorkDocsOp[DeleteNotificationSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNotificationSubscriptionResponse] =
        visitor.deleteNotificationSubscription(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends WorkDocsOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DescribeActivitiesOp(
      request: DescribeActivitiesRequest
    ) extends WorkDocsOp[DescribeActivitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActivitiesResponse] =
        visitor.describeActivities(request)
    }

    final case class DescribeCommentsOp(
      request: DescribeCommentsRequest
    ) extends WorkDocsOp[DescribeCommentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCommentsResponse] =
        visitor.describeComments(request)
    }

    final case class DescribeDocumentVersionsOp(
      request: DescribeDocumentVersionsRequest
    ) extends WorkDocsOp[DescribeDocumentVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDocumentVersionsResponse] =
        visitor.describeDocumentVersions(request)
    }

    final case class DescribeFolderContentsOp(
      request: DescribeFolderContentsRequest
    ) extends WorkDocsOp[DescribeFolderContentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFolderContentsResponse] =
        visitor.describeFolderContents(request)
    }

    final case class DescribeGroupsOp(
      request: DescribeGroupsRequest
    ) extends WorkDocsOp[DescribeGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGroupsResponse] =
        visitor.describeGroups(request)
    }

    final case class DescribeNotificationSubscriptionsOp(
      request: DescribeNotificationSubscriptionsRequest
    ) extends WorkDocsOp[DescribeNotificationSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotificationSubscriptionsResponse] =
        visitor.describeNotificationSubscriptions(request)
    }

    final case class DescribeResourcePermissionsOp(
      request: DescribeResourcePermissionsRequest
    ) extends WorkDocsOp[DescribeResourcePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourcePermissionsResponse] =
        visitor.describeResourcePermissions(request)
    }

    final case class DescribeRootFoldersOp(
      request: DescribeRootFoldersRequest
    ) extends WorkDocsOp[DescribeRootFoldersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRootFoldersResponse] =
        visitor.describeRootFolders(request)
    }

    final case class DescribeUsersOp(
      request: DescribeUsersRequest
    ) extends WorkDocsOp[DescribeUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUsersResponse] =
        visitor.describeUsers(request)
    }

    final case class GetCurrentUserOp(
      request: GetCurrentUserRequest
    ) extends WorkDocsOp[GetCurrentUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCurrentUserResponse] =
        visitor.getCurrentUser(request)
    }

    final case class GetDocumentOp(
      request: GetDocumentRequest
    ) extends WorkDocsOp[GetDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentResponse] =
        visitor.getDocument(request)
    }

    final case class GetDocumentPathOp(
      request: GetDocumentPathRequest
    ) extends WorkDocsOp[GetDocumentPathResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentPathResponse] =
        visitor.getDocumentPath(request)
    }

    final case class GetDocumentVersionOp(
      request: GetDocumentVersionRequest
    ) extends WorkDocsOp[GetDocumentVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDocumentVersionResponse] =
        visitor.getDocumentVersion(request)
    }

    final case class GetFolderOp(
      request: GetFolderRequest
    ) extends WorkDocsOp[GetFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFolderResponse] =
        visitor.getFolder(request)
    }

    final case class GetFolderPathOp(
      request: GetFolderPathRequest
    ) extends WorkDocsOp[GetFolderPathResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFolderPathResponse] =
        visitor.getFolderPath(request)
    }

    final case class GetResourcesOp(
      request: GetResourcesRequest
    ) extends WorkDocsOp[GetResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcesResponse] =
        visitor.getResources(request)
    }

    final case class InitiateDocumentVersionUploadOp(
      request: InitiateDocumentVersionUploadRequest
    ) extends WorkDocsOp[InitiateDocumentVersionUploadResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitiateDocumentVersionUploadResponse] =
        visitor.initiateDocumentVersionUpload(request)
    }

    final case class RemoveAllResourcePermissionsOp(
      request: RemoveAllResourcePermissionsRequest
    ) extends WorkDocsOp[RemoveAllResourcePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveAllResourcePermissionsResponse] =
        visitor.removeAllResourcePermissions(request)
    }

    final case class RemoveResourcePermissionOp(
      request: RemoveResourcePermissionRequest
    ) extends WorkDocsOp[RemoveResourcePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveResourcePermissionResponse] =
        visitor.removeResourcePermission(request)
    }

    final case class UpdateDocumentOp(
      request: UpdateDocumentRequest
    ) extends WorkDocsOp[UpdateDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentResponse] =
        visitor.updateDocument(request)
    }

    final case class UpdateDocumentVersionOp(
      request: UpdateDocumentVersionRequest
    ) extends WorkDocsOp[UpdateDocumentVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDocumentVersionResponse] =
        visitor.updateDocumentVersion(request)
    }

    final case class UpdateFolderOp(
      request: UpdateFolderRequest
    ) extends WorkDocsOp[UpdateFolderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFolderResponse] =
        visitor.updateFolder(request)
    }

    final case class UpdateUserOp(
      request: UpdateUserRequest
    ) extends WorkDocsOp[UpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserResponse] =
        visitor.updateUser(request)
    }
  }

  import WorkDocsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WorkDocsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def abortDocumentVersionUpload(
    request: AbortDocumentVersionUploadRequest
  ): WorkDocsIO[AbortDocumentVersionUploadResponse] =
    FF.liftF(AbortDocumentVersionUploadOp(request))

  def activateUser(
    request: ActivateUserRequest
  ): WorkDocsIO[ActivateUserResponse] =
    FF.liftF(ActivateUserOp(request))

  def addResourcePermissions(
    request: AddResourcePermissionsRequest
  ): WorkDocsIO[AddResourcePermissionsResponse] =
    FF.liftF(AddResourcePermissionsOp(request))

  def createComment(
    request: CreateCommentRequest
  ): WorkDocsIO[CreateCommentResponse] =
    FF.liftF(CreateCommentOp(request))

  def createCustomMetadata(
    request: CreateCustomMetadataRequest
  ): WorkDocsIO[CreateCustomMetadataResponse] =
    FF.liftF(CreateCustomMetadataOp(request))

  def createFolder(
    request: CreateFolderRequest
  ): WorkDocsIO[CreateFolderResponse] =
    FF.liftF(CreateFolderOp(request))

  def createLabels(
    request: CreateLabelsRequest
  ): WorkDocsIO[CreateLabelsResponse] =
    FF.liftF(CreateLabelsOp(request))

  def createNotificationSubscription(
    request: CreateNotificationSubscriptionRequest
  ): WorkDocsIO[CreateNotificationSubscriptionResponse] =
    FF.liftF(CreateNotificationSubscriptionOp(request))

  def createUser(
    request: CreateUserRequest
  ): WorkDocsIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def deactivateUser(
    request: DeactivateUserRequest
  ): WorkDocsIO[DeactivateUserResponse] =
    FF.liftF(DeactivateUserOp(request))

  def deleteComment(
    request: DeleteCommentRequest
  ): WorkDocsIO[DeleteCommentResponse] =
    FF.liftF(DeleteCommentOp(request))

  def deleteCustomMetadata(
    request: DeleteCustomMetadataRequest
  ): WorkDocsIO[DeleteCustomMetadataResponse] =
    FF.liftF(DeleteCustomMetadataOp(request))

  def deleteDocument(
    request: DeleteDocumentRequest
  ): WorkDocsIO[DeleteDocumentResponse] =
    FF.liftF(DeleteDocumentOp(request))

  def deleteFolder(
    request: DeleteFolderRequest
  ): WorkDocsIO[DeleteFolderResponse] =
    FF.liftF(DeleteFolderOp(request))

  def deleteFolderContents(
    request: DeleteFolderContentsRequest
  ): WorkDocsIO[DeleteFolderContentsResponse] =
    FF.liftF(DeleteFolderContentsOp(request))

  def deleteLabels(
    request: DeleteLabelsRequest
  ): WorkDocsIO[DeleteLabelsResponse] =
    FF.liftF(DeleteLabelsOp(request))

  def deleteNotificationSubscription(
    request: DeleteNotificationSubscriptionRequest
  ): WorkDocsIO[DeleteNotificationSubscriptionResponse] =
    FF.liftF(DeleteNotificationSubscriptionOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): WorkDocsIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def describeActivities(
    request: DescribeActivitiesRequest
  ): WorkDocsIO[DescribeActivitiesResponse] =
    FF.liftF(DescribeActivitiesOp(request))

  def describeComments(
    request: DescribeCommentsRequest
  ): WorkDocsIO[DescribeCommentsResponse] =
    FF.liftF(DescribeCommentsOp(request))

  def describeDocumentVersions(
    request: DescribeDocumentVersionsRequest
  ): WorkDocsIO[DescribeDocumentVersionsResponse] =
    FF.liftF(DescribeDocumentVersionsOp(request))

  def describeFolderContents(
    request: DescribeFolderContentsRequest
  ): WorkDocsIO[DescribeFolderContentsResponse] =
    FF.liftF(DescribeFolderContentsOp(request))

  def describeGroups(
    request: DescribeGroupsRequest
  ): WorkDocsIO[DescribeGroupsResponse] =
    FF.liftF(DescribeGroupsOp(request))

  def describeNotificationSubscriptions(
    request: DescribeNotificationSubscriptionsRequest
  ): WorkDocsIO[DescribeNotificationSubscriptionsResponse] =
    FF.liftF(DescribeNotificationSubscriptionsOp(request))

  def describeResourcePermissions(
    request: DescribeResourcePermissionsRequest
  ): WorkDocsIO[DescribeResourcePermissionsResponse] =
    FF.liftF(DescribeResourcePermissionsOp(request))

  def describeRootFolders(
    request: DescribeRootFoldersRequest
  ): WorkDocsIO[DescribeRootFoldersResponse] =
    FF.liftF(DescribeRootFoldersOp(request))

  def describeUsers(
    request: DescribeUsersRequest
  ): WorkDocsIO[DescribeUsersResponse] =
    FF.liftF(DescribeUsersOp(request))

  def getCurrentUser(
    request: GetCurrentUserRequest
  ): WorkDocsIO[GetCurrentUserResponse] =
    FF.liftF(GetCurrentUserOp(request))

  def getDocument(
    request: GetDocumentRequest
  ): WorkDocsIO[GetDocumentResponse] =
    FF.liftF(GetDocumentOp(request))

  def getDocumentPath(
    request: GetDocumentPathRequest
  ): WorkDocsIO[GetDocumentPathResponse] =
    FF.liftF(GetDocumentPathOp(request))

  def getDocumentVersion(
    request: GetDocumentVersionRequest
  ): WorkDocsIO[GetDocumentVersionResponse] =
    FF.liftF(GetDocumentVersionOp(request))

  def getFolder(
    request: GetFolderRequest
  ): WorkDocsIO[GetFolderResponse] =
    FF.liftF(GetFolderOp(request))

  def getFolderPath(
    request: GetFolderPathRequest
  ): WorkDocsIO[GetFolderPathResponse] =
    FF.liftF(GetFolderPathOp(request))

  def getResources(
    request: GetResourcesRequest
  ): WorkDocsIO[GetResourcesResponse] =
    FF.liftF(GetResourcesOp(request))

  def initiateDocumentVersionUpload(
    request: InitiateDocumentVersionUploadRequest
  ): WorkDocsIO[InitiateDocumentVersionUploadResponse] =
    FF.liftF(InitiateDocumentVersionUploadOp(request))

  def removeAllResourcePermissions(
    request: RemoveAllResourcePermissionsRequest
  ): WorkDocsIO[RemoveAllResourcePermissionsResponse] =
    FF.liftF(RemoveAllResourcePermissionsOp(request))

  def removeResourcePermission(
    request: RemoveResourcePermissionRequest
  ): WorkDocsIO[RemoveResourcePermissionResponse] =
    FF.liftF(RemoveResourcePermissionOp(request))

  def updateDocument(
    request: UpdateDocumentRequest
  ): WorkDocsIO[UpdateDocumentResponse] =
    FF.liftF(UpdateDocumentOp(request))

  def updateDocumentVersion(
    request: UpdateDocumentVersionRequest
  ): WorkDocsIO[UpdateDocumentVersionResponse] =
    FF.liftF(UpdateDocumentVersionOp(request))

  def updateFolder(
    request: UpdateFolderRequest
  ): WorkDocsIO[UpdateFolderResponse] =
    FF.liftF(UpdateFolderOp(request))

  def updateUser(
    request: UpdateUserRequest
  ): WorkDocsIO[UpdateUserResponse] =
    FF.liftF(UpdateUserOp(request))
}
