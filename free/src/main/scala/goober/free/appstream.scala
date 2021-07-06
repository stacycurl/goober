package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.appstream.AppStreamClient
import software.amazon.awssdk.services.appstream.model._


object appstream { module =>

  // Free monad over AppStreamOp
  type AppStreamIO[A] = FF[AppStreamOp, A]

  sealed trait AppStreamOp[A] {
    def visit[F[_]](visitor: AppStreamOp.Visitor[F]): F[A]
  }

  object AppStreamOp {
    // Given a AppStreamClient we can embed a AppStreamIO program in any algebra that understands embedding.
    implicit val AppStreamOpEmbeddable: Embeddable[AppStreamOp, AppStreamClient] = new Embeddable[AppStreamOp, AppStreamClient] {
      def embed[A](client: AppStreamClient, io: AppStreamIO[A]): Embedded[A] = Embedded.AppStream(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppStreamOp.Visitor[Kleisli[M, AppStreamClient, *]] {
        def associateFleet(
          request: AssociateFleetRequest
        ): Kleisli[M, AppStreamClient, AssociateFleetResponse] =
          primitive(_.associateFleet(request))

        def batchAssociateUserStack(
          request: BatchAssociateUserStackRequest
        ): Kleisli[M, AppStreamClient, BatchAssociateUserStackResponse] =
          primitive(_.batchAssociateUserStack(request))

        def batchDisassociateUserStack(
          request: BatchDisassociateUserStackRequest
        ): Kleisli[M, AppStreamClient, BatchDisassociateUserStackResponse] =
          primitive(_.batchDisassociateUserStack(request))

        def copyImage(
          request: CopyImageRequest
        ): Kleisli[M, AppStreamClient, CopyImageResponse] =
          primitive(_.copyImage(request))

        def createDirectoryConfig(
          request: CreateDirectoryConfigRequest
        ): Kleisli[M, AppStreamClient, CreateDirectoryConfigResponse] =
          primitive(_.createDirectoryConfig(request))

        def createFleet(
          request: CreateFleetRequest
        ): Kleisli[M, AppStreamClient, CreateFleetResponse] =
          primitive(_.createFleet(request))

        def createImageBuilder(
          request: CreateImageBuilderRequest
        ): Kleisli[M, AppStreamClient, CreateImageBuilderResponse] =
          primitive(_.createImageBuilder(request))

        def createImageBuilderStreamingURL(
          request: CreateImageBuilderStreamingUrlRequest
        ): Kleisli[M, AppStreamClient, CreateImageBuilderStreamingUrlResponse] =
          primitive(_.createImageBuilderStreamingURL(request))

        def createStack(
          request: CreateStackRequest
        ): Kleisli[M, AppStreamClient, CreateStackResponse] =
          primitive(_.createStack(request))

        def createStreamingURL(
          request: CreateStreamingUrlRequest
        ): Kleisli[M, AppStreamClient, CreateStreamingUrlResponse] =
          primitive(_.createStreamingURL(request))

        def createUpdatedImage(
          request: CreateUpdatedImageRequest
        ): Kleisli[M, AppStreamClient, CreateUpdatedImageResponse] =
          primitive(_.createUpdatedImage(request))

        def createUsageReportSubscription(
          request: CreateUsageReportSubscriptionRequest
        ): Kleisli[M, AppStreamClient, CreateUsageReportSubscriptionResponse] =
          primitive(_.createUsageReportSubscription(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, AppStreamClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def deleteDirectoryConfig(
          request: DeleteDirectoryConfigRequest
        ): Kleisli[M, AppStreamClient, DeleteDirectoryConfigResponse] =
          primitive(_.deleteDirectoryConfig(request))

        def deleteFleet(
          request: DeleteFleetRequest
        ): Kleisli[M, AppStreamClient, DeleteFleetResponse] =
          primitive(_.deleteFleet(request))

        def deleteImage(
          request: DeleteImageRequest
        ): Kleisli[M, AppStreamClient, DeleteImageResponse] =
          primitive(_.deleteImage(request))

        def deleteImageBuilder(
          request: DeleteImageBuilderRequest
        ): Kleisli[M, AppStreamClient, DeleteImageBuilderResponse] =
          primitive(_.deleteImageBuilder(request))

        def deleteImagePermissions(
          request: DeleteImagePermissionsRequest
        ): Kleisli[M, AppStreamClient, DeleteImagePermissionsResponse] =
          primitive(_.deleteImagePermissions(request))

        def deleteStack(
          request: DeleteStackRequest
        ): Kleisli[M, AppStreamClient, DeleteStackResponse] =
          primitive(_.deleteStack(request))

        def deleteUsageReportSubscription(
          request: DeleteUsageReportSubscriptionRequest
        ): Kleisli[M, AppStreamClient, DeleteUsageReportSubscriptionResponse] =
          primitive(_.deleteUsageReportSubscription(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, AppStreamClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def describeDirectoryConfigs(
          request: DescribeDirectoryConfigsRequest
        ): Kleisli[M, AppStreamClient, DescribeDirectoryConfigsResponse] =
          primitive(_.describeDirectoryConfigs(request))

        def describeFleets(
          request: DescribeFleetsRequest
        ): Kleisli[M, AppStreamClient, DescribeFleetsResponse] =
          primitive(_.describeFleets(request))

        def describeImageBuilders(
          request: DescribeImageBuildersRequest
        ): Kleisli[M, AppStreamClient, DescribeImageBuildersResponse] =
          primitive(_.describeImageBuilders(request))

        def describeImagePermissions(
          request: DescribeImagePermissionsRequest
        ): Kleisli[M, AppStreamClient, DescribeImagePermissionsResponse] =
          primitive(_.describeImagePermissions(request))

        def describeImages(
          request: DescribeImagesRequest
        ): Kleisli[M, AppStreamClient, DescribeImagesResponse] =
          primitive(_.describeImages(request))

        def describeSessions(
          request: DescribeSessionsRequest
        ): Kleisli[M, AppStreamClient, DescribeSessionsResponse] =
          primitive(_.describeSessions(request))

        def describeStacks(
          request: DescribeStacksRequest
        ): Kleisli[M, AppStreamClient, DescribeStacksResponse] =
          primitive(_.describeStacks(request))

        def describeUsageReportSubscriptions(
          request: DescribeUsageReportSubscriptionsRequest
        ): Kleisli[M, AppStreamClient, DescribeUsageReportSubscriptionsResponse] =
          primitive(_.describeUsageReportSubscriptions(request))

        def describeUserStackAssociations(
          request: DescribeUserStackAssociationsRequest
        ): Kleisli[M, AppStreamClient, DescribeUserStackAssociationsResponse] =
          primitive(_.describeUserStackAssociations(request))

        def describeUsers(
          request: DescribeUsersRequest
        ): Kleisli[M, AppStreamClient, DescribeUsersResponse] =
          primitive(_.describeUsers(request))

        def disableUser(
          request: DisableUserRequest
        ): Kleisli[M, AppStreamClient, DisableUserResponse] =
          primitive(_.disableUser(request))

        def disassociateFleet(
          request: DisassociateFleetRequest
        ): Kleisli[M, AppStreamClient, DisassociateFleetResponse] =
          primitive(_.disassociateFleet(request))

        def enableUser(
          request: EnableUserRequest
        ): Kleisli[M, AppStreamClient, EnableUserResponse] =
          primitive(_.enableUser(request))

        def expireSession(
          request: ExpireSessionRequest
        ): Kleisli[M, AppStreamClient, ExpireSessionResponse] =
          primitive(_.expireSession(request))

        def listAssociatedFleets(
          request: ListAssociatedFleetsRequest
        ): Kleisli[M, AppStreamClient, ListAssociatedFleetsResponse] =
          primitive(_.listAssociatedFleets(request))

        def listAssociatedStacks(
          request: ListAssociatedStacksRequest
        ): Kleisli[M, AppStreamClient, ListAssociatedStacksResponse] =
          primitive(_.listAssociatedStacks(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppStreamClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startFleet(
          request: StartFleetRequest
        ): Kleisli[M, AppStreamClient, StartFleetResponse] =
          primitive(_.startFleet(request))

        def startImageBuilder(
          request: StartImageBuilderRequest
        ): Kleisli[M, AppStreamClient, StartImageBuilderResponse] =
          primitive(_.startImageBuilder(request))

        def stopFleet(
          request: StopFleetRequest
        ): Kleisli[M, AppStreamClient, StopFleetResponse] =
          primitive(_.stopFleet(request))

        def stopImageBuilder(
          request: StopImageBuilderRequest
        ): Kleisli[M, AppStreamClient, StopImageBuilderResponse] =
          primitive(_.stopImageBuilder(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppStreamClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppStreamClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDirectoryConfig(
          request: UpdateDirectoryConfigRequest
        ): Kleisli[M, AppStreamClient, UpdateDirectoryConfigResponse] =
          primitive(_.updateDirectoryConfig(request))

        def updateFleet(
          request: UpdateFleetRequest
        ): Kleisli[M, AppStreamClient, UpdateFleetResponse] =
          primitive(_.updateFleet(request))

        def updateImagePermissions(
          request: UpdateImagePermissionsRequest
        ): Kleisli[M, AppStreamClient, UpdateImagePermissionsResponse] =
          primitive(_.updateImagePermissions(request))

        def updateStack(
          request: UpdateStackRequest
        ): Kleisli[M, AppStreamClient, UpdateStackResponse] =
          primitive(_.updateStack(request))

        def primitive[A](
          f: AppStreamClient => A
        ): Kleisli[M, AppStreamClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppStreamOp ~> F) {
      final def apply[A](op: AppStreamOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateFleet(
        request: AssociateFleetRequest
      ): F[AssociateFleetResponse]

      def batchAssociateUserStack(
        request: BatchAssociateUserStackRequest
      ): F[BatchAssociateUserStackResponse]

      def batchDisassociateUserStack(
        request: BatchDisassociateUserStackRequest
      ): F[BatchDisassociateUserStackResponse]

      def copyImage(
        request: CopyImageRequest
      ): F[CopyImageResponse]

      def createDirectoryConfig(
        request: CreateDirectoryConfigRequest
      ): F[CreateDirectoryConfigResponse]

      def createFleet(
        request: CreateFleetRequest
      ): F[CreateFleetResponse]

      def createImageBuilder(
        request: CreateImageBuilderRequest
      ): F[CreateImageBuilderResponse]

      def createImageBuilderStreamingURL(
        request: CreateImageBuilderStreamingUrlRequest
      ): F[CreateImageBuilderStreamingUrlResponse]

      def createStack(
        request: CreateStackRequest
      ): F[CreateStackResponse]

      def createStreamingURL(
        request: CreateStreamingUrlRequest
      ): F[CreateStreamingUrlResponse]

      def createUpdatedImage(
        request: CreateUpdatedImageRequest
      ): F[CreateUpdatedImageResponse]

      def createUsageReportSubscription(
        request: CreateUsageReportSubscriptionRequest
      ): F[CreateUsageReportSubscriptionResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def deleteDirectoryConfig(
        request: DeleteDirectoryConfigRequest
      ): F[DeleteDirectoryConfigResponse]

      def deleteFleet(
        request: DeleteFleetRequest
      ): F[DeleteFleetResponse]

      def deleteImage(
        request: DeleteImageRequest
      ): F[DeleteImageResponse]

      def deleteImageBuilder(
        request: DeleteImageBuilderRequest
      ): F[DeleteImageBuilderResponse]

      def deleteImagePermissions(
        request: DeleteImagePermissionsRequest
      ): F[DeleteImagePermissionsResponse]

      def deleteStack(
        request: DeleteStackRequest
      ): F[DeleteStackResponse]

      def deleteUsageReportSubscription(
        request: DeleteUsageReportSubscriptionRequest
      ): F[DeleteUsageReportSubscriptionResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def describeDirectoryConfigs(
        request: DescribeDirectoryConfigsRequest
      ): F[DescribeDirectoryConfigsResponse]

      def describeFleets(
        request: DescribeFleetsRequest
      ): F[DescribeFleetsResponse]

      def describeImageBuilders(
        request: DescribeImageBuildersRequest
      ): F[DescribeImageBuildersResponse]

      def describeImagePermissions(
        request: DescribeImagePermissionsRequest
      ): F[DescribeImagePermissionsResponse]

      def describeImages(
        request: DescribeImagesRequest
      ): F[DescribeImagesResponse]

      def describeSessions(
        request: DescribeSessionsRequest
      ): F[DescribeSessionsResponse]

      def describeStacks(
        request: DescribeStacksRequest
      ): F[DescribeStacksResponse]

      def describeUsageReportSubscriptions(
        request: DescribeUsageReportSubscriptionsRequest
      ): F[DescribeUsageReportSubscriptionsResponse]

      def describeUserStackAssociations(
        request: DescribeUserStackAssociationsRequest
      ): F[DescribeUserStackAssociationsResponse]

      def describeUsers(
        request: DescribeUsersRequest
      ): F[DescribeUsersResponse]

      def disableUser(
        request: DisableUserRequest
      ): F[DisableUserResponse]

      def disassociateFleet(
        request: DisassociateFleetRequest
      ): F[DisassociateFleetResponse]

      def enableUser(
        request: EnableUserRequest
      ): F[EnableUserResponse]

      def expireSession(
        request: ExpireSessionRequest
      ): F[ExpireSessionResponse]

      def listAssociatedFleets(
        request: ListAssociatedFleetsRequest
      ): F[ListAssociatedFleetsResponse]

      def listAssociatedStacks(
        request: ListAssociatedStacksRequest
      ): F[ListAssociatedStacksResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startFleet(
        request: StartFleetRequest
      ): F[StartFleetResponse]

      def startImageBuilder(
        request: StartImageBuilderRequest
      ): F[StartImageBuilderResponse]

      def stopFleet(
        request: StopFleetRequest
      ): F[StopFleetResponse]

      def stopImageBuilder(
        request: StopImageBuilderRequest
      ): F[StopImageBuilderResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDirectoryConfig(
        request: UpdateDirectoryConfigRequest
      ): F[UpdateDirectoryConfigResponse]

      def updateFleet(
        request: UpdateFleetRequest
      ): F[UpdateFleetResponse]

      def updateImagePermissions(
        request: UpdateImagePermissionsRequest
      ): F[UpdateImagePermissionsResponse]

      def updateStack(
        request: UpdateStackRequest
      ): F[UpdateStackResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppStreamOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateFleetOp(
      request: AssociateFleetRequest
    ) extends AppStreamOp[AssociateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateFleetResponse] =
        visitor.associateFleet(request)
    }

    final case class BatchAssociateUserStackOp(
      request: BatchAssociateUserStackRequest
    ) extends AppStreamOp[BatchAssociateUserStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateUserStackResponse] =
        visitor.batchAssociateUserStack(request)
    }

    final case class BatchDisassociateUserStackOp(
      request: BatchDisassociateUserStackRequest
    ) extends AppStreamOp[BatchDisassociateUserStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateUserStackResponse] =
        visitor.batchDisassociateUserStack(request)
    }

    final case class CopyImageOp(
      request: CopyImageRequest
    ) extends AppStreamOp[CopyImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyImageResponse] =
        visitor.copyImage(request)
    }

    final case class CreateDirectoryConfigOp(
      request: CreateDirectoryConfigRequest
    ) extends AppStreamOp[CreateDirectoryConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDirectoryConfigResponse] =
        visitor.createDirectoryConfig(request)
    }

    final case class CreateFleetOp(
      request: CreateFleetRequest
    ) extends AppStreamOp[CreateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFleetResponse] =
        visitor.createFleet(request)
    }

    final case class CreateImageBuilderOp(
      request: CreateImageBuilderRequest
    ) extends AppStreamOp[CreateImageBuilderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageBuilderResponse] =
        visitor.createImageBuilder(request)
    }

    final case class CreateImageBuilderStreamingURLOp(
      request: CreateImageBuilderStreamingUrlRequest
    ) extends AppStreamOp[CreateImageBuilderStreamingUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateImageBuilderStreamingUrlResponse] =
        visitor.createImageBuilderStreamingURL(request)
    }

    final case class CreateStackOp(
      request: CreateStackRequest
    ) extends AppStreamOp[CreateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStackResponse] =
        visitor.createStack(request)
    }

    final case class CreateStreamingURLOp(
      request: CreateStreamingUrlRequest
    ) extends AppStreamOp[CreateStreamingUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamingUrlResponse] =
        visitor.createStreamingURL(request)
    }

    final case class CreateUpdatedImageOp(
      request: CreateUpdatedImageRequest
    ) extends AppStreamOp[CreateUpdatedImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUpdatedImageResponse] =
        visitor.createUpdatedImage(request)
    }

    final case class CreateUsageReportSubscriptionOp(
      request: CreateUsageReportSubscriptionRequest
    ) extends AppStreamOp[CreateUsageReportSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUsageReportSubscriptionResponse] =
        visitor.createUsageReportSubscription(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends AppStreamOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class DeleteDirectoryConfigOp(
      request: DeleteDirectoryConfigRequest
    ) extends AppStreamOp[DeleteDirectoryConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDirectoryConfigResponse] =
        visitor.deleteDirectoryConfig(request)
    }

    final case class DeleteFleetOp(
      request: DeleteFleetRequest
    ) extends AppStreamOp[DeleteFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFleetResponse] =
        visitor.deleteFleet(request)
    }

    final case class DeleteImageOp(
      request: DeleteImageRequest
    ) extends AppStreamOp[DeleteImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImageResponse] =
        visitor.deleteImage(request)
    }

    final case class DeleteImageBuilderOp(
      request: DeleteImageBuilderRequest
    ) extends AppStreamOp[DeleteImageBuilderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImageBuilderResponse] =
        visitor.deleteImageBuilder(request)
    }

    final case class DeleteImagePermissionsOp(
      request: DeleteImagePermissionsRequest
    ) extends AppStreamOp[DeleteImagePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteImagePermissionsResponse] =
        visitor.deleteImagePermissions(request)
    }

    final case class DeleteStackOp(
      request: DeleteStackRequest
    ) extends AppStreamOp[DeleteStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStackResponse] =
        visitor.deleteStack(request)
    }

    final case class DeleteUsageReportSubscriptionOp(
      request: DeleteUsageReportSubscriptionRequest
    ) extends AppStreamOp[DeleteUsageReportSubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUsageReportSubscriptionResponse] =
        visitor.deleteUsageReportSubscription(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends AppStreamOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DescribeDirectoryConfigsOp(
      request: DescribeDirectoryConfigsRequest
    ) extends AppStreamOp[DescribeDirectoryConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDirectoryConfigsResponse] =
        visitor.describeDirectoryConfigs(request)
    }

    final case class DescribeFleetsOp(
      request: DescribeFleetsRequest
    ) extends AppStreamOp[DescribeFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetsResponse] =
        visitor.describeFleets(request)
    }

    final case class DescribeImageBuildersOp(
      request: DescribeImageBuildersRequest
    ) extends AppStreamOp[DescribeImageBuildersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImageBuildersResponse] =
        visitor.describeImageBuilders(request)
    }

    final case class DescribeImagePermissionsOp(
      request: DescribeImagePermissionsRequest
    ) extends AppStreamOp[DescribeImagePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImagePermissionsResponse] =
        visitor.describeImagePermissions(request)
    }

    final case class DescribeImagesOp(
      request: DescribeImagesRequest
    ) extends AppStreamOp[DescribeImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImagesResponse] =
        visitor.describeImages(request)
    }

    final case class DescribeSessionsOp(
      request: DescribeSessionsRequest
    ) extends AppStreamOp[DescribeSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSessionsResponse] =
        visitor.describeSessions(request)
    }

    final case class DescribeStacksOp(
      request: DescribeStacksRequest
    ) extends AppStreamOp[DescribeStacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStacksResponse] =
        visitor.describeStacks(request)
    }

    final case class DescribeUsageReportSubscriptionsOp(
      request: DescribeUsageReportSubscriptionsRequest
    ) extends AppStreamOp[DescribeUsageReportSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUsageReportSubscriptionsResponse] =
        visitor.describeUsageReportSubscriptions(request)
    }

    final case class DescribeUserStackAssociationsOp(
      request: DescribeUserStackAssociationsRequest
    ) extends AppStreamOp[DescribeUserStackAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserStackAssociationsResponse] =
        visitor.describeUserStackAssociations(request)
    }

    final case class DescribeUsersOp(
      request: DescribeUsersRequest
    ) extends AppStreamOp[DescribeUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUsersResponse] =
        visitor.describeUsers(request)
    }

    final case class DisableUserOp(
      request: DisableUserRequest
    ) extends AppStreamOp[DisableUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableUserResponse] =
        visitor.disableUser(request)
    }

    final case class DisassociateFleetOp(
      request: DisassociateFleetRequest
    ) extends AppStreamOp[DisassociateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFleetResponse] =
        visitor.disassociateFleet(request)
    }

    final case class EnableUserOp(
      request: EnableUserRequest
    ) extends AppStreamOp[EnableUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableUserResponse] =
        visitor.enableUser(request)
    }

    final case class ExpireSessionOp(
      request: ExpireSessionRequest
    ) extends AppStreamOp[ExpireSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExpireSessionResponse] =
        visitor.expireSession(request)
    }

    final case class ListAssociatedFleetsOp(
      request: ListAssociatedFleetsRequest
    ) extends AppStreamOp[ListAssociatedFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociatedFleetsResponse] =
        visitor.listAssociatedFleets(request)
    }

    final case class ListAssociatedStacksOp(
      request: ListAssociatedStacksRequest
    ) extends AppStreamOp[ListAssociatedStacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociatedStacksResponse] =
        visitor.listAssociatedStacks(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppStreamOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartFleetOp(
      request: StartFleetRequest
    ) extends AppStreamOp[StartFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFleetResponse] =
        visitor.startFleet(request)
    }

    final case class StartImageBuilderOp(
      request: StartImageBuilderRequest
    ) extends AppStreamOp[StartImageBuilderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImageBuilderResponse] =
        visitor.startImageBuilder(request)
    }

    final case class StopFleetOp(
      request: StopFleetRequest
    ) extends AppStreamOp[StopFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopFleetResponse] =
        visitor.stopFleet(request)
    }

    final case class StopImageBuilderOp(
      request: StopImageBuilderRequest
    ) extends AppStreamOp[StopImageBuilderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopImageBuilderResponse] =
        visitor.stopImageBuilder(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppStreamOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppStreamOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDirectoryConfigOp(
      request: UpdateDirectoryConfigRequest
    ) extends AppStreamOp[UpdateDirectoryConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDirectoryConfigResponse] =
        visitor.updateDirectoryConfig(request)
    }

    final case class UpdateFleetOp(
      request: UpdateFleetRequest
    ) extends AppStreamOp[UpdateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFleetResponse] =
        visitor.updateFleet(request)
    }

    final case class UpdateImagePermissionsOp(
      request: UpdateImagePermissionsRequest
    ) extends AppStreamOp[UpdateImagePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateImagePermissionsResponse] =
        visitor.updateImagePermissions(request)
    }

    final case class UpdateStackOp(
      request: UpdateStackRequest
    ) extends AppStreamOp[UpdateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStackResponse] =
        visitor.updateStack(request)
    }
  }

  import AppStreamOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppStreamOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateFleet(
    request: AssociateFleetRequest
  ): AppStreamIO[AssociateFleetResponse] =
    FF.liftF(AssociateFleetOp(request))

  def batchAssociateUserStack(
    request: BatchAssociateUserStackRequest
  ): AppStreamIO[BatchAssociateUserStackResponse] =
    FF.liftF(BatchAssociateUserStackOp(request))

  def batchDisassociateUserStack(
    request: BatchDisassociateUserStackRequest
  ): AppStreamIO[BatchDisassociateUserStackResponse] =
    FF.liftF(BatchDisassociateUserStackOp(request))

  def copyImage(
    request: CopyImageRequest
  ): AppStreamIO[CopyImageResponse] =
    FF.liftF(CopyImageOp(request))

  def createDirectoryConfig(
    request: CreateDirectoryConfigRequest
  ): AppStreamIO[CreateDirectoryConfigResponse] =
    FF.liftF(CreateDirectoryConfigOp(request))

  def createFleet(
    request: CreateFleetRequest
  ): AppStreamIO[CreateFleetResponse] =
    FF.liftF(CreateFleetOp(request))

  def createImageBuilder(
    request: CreateImageBuilderRequest
  ): AppStreamIO[CreateImageBuilderResponse] =
    FF.liftF(CreateImageBuilderOp(request))

  def createImageBuilderStreamingURL(
    request: CreateImageBuilderStreamingUrlRequest
  ): AppStreamIO[CreateImageBuilderStreamingUrlResponse] =
    FF.liftF(CreateImageBuilderStreamingURLOp(request))

  def createStack(
    request: CreateStackRequest
  ): AppStreamIO[CreateStackResponse] =
    FF.liftF(CreateStackOp(request))

  def createStreamingURL(
    request: CreateStreamingUrlRequest
  ): AppStreamIO[CreateStreamingUrlResponse] =
    FF.liftF(CreateStreamingURLOp(request))

  def createUpdatedImage(
    request: CreateUpdatedImageRequest
  ): AppStreamIO[CreateUpdatedImageResponse] =
    FF.liftF(CreateUpdatedImageOp(request))

  def createUsageReportSubscription(
    request: CreateUsageReportSubscriptionRequest
  ): AppStreamIO[CreateUsageReportSubscriptionResponse] =
    FF.liftF(CreateUsageReportSubscriptionOp(request))

  def createUser(
    request: CreateUserRequest
  ): AppStreamIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def deleteDirectoryConfig(
    request: DeleteDirectoryConfigRequest
  ): AppStreamIO[DeleteDirectoryConfigResponse] =
    FF.liftF(DeleteDirectoryConfigOp(request))

  def deleteFleet(
    request: DeleteFleetRequest
  ): AppStreamIO[DeleteFleetResponse] =
    FF.liftF(DeleteFleetOp(request))

  def deleteImage(
    request: DeleteImageRequest
  ): AppStreamIO[DeleteImageResponse] =
    FF.liftF(DeleteImageOp(request))

  def deleteImageBuilder(
    request: DeleteImageBuilderRequest
  ): AppStreamIO[DeleteImageBuilderResponse] =
    FF.liftF(DeleteImageBuilderOp(request))

  def deleteImagePermissions(
    request: DeleteImagePermissionsRequest
  ): AppStreamIO[DeleteImagePermissionsResponse] =
    FF.liftF(DeleteImagePermissionsOp(request))

  def deleteStack(
    request: DeleteStackRequest
  ): AppStreamIO[DeleteStackResponse] =
    FF.liftF(DeleteStackOp(request))

  def deleteUsageReportSubscription(
    request: DeleteUsageReportSubscriptionRequest
  ): AppStreamIO[DeleteUsageReportSubscriptionResponse] =
    FF.liftF(DeleteUsageReportSubscriptionOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): AppStreamIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def describeDirectoryConfigs(
    request: DescribeDirectoryConfigsRequest
  ): AppStreamIO[DescribeDirectoryConfigsResponse] =
    FF.liftF(DescribeDirectoryConfigsOp(request))

  def describeFleets(
    request: DescribeFleetsRequest
  ): AppStreamIO[DescribeFleetsResponse] =
    FF.liftF(DescribeFleetsOp(request))

  def describeImageBuilders(
    request: DescribeImageBuildersRequest
  ): AppStreamIO[DescribeImageBuildersResponse] =
    FF.liftF(DescribeImageBuildersOp(request))

  def describeImagePermissions(
    request: DescribeImagePermissionsRequest
  ): AppStreamIO[DescribeImagePermissionsResponse] =
    FF.liftF(DescribeImagePermissionsOp(request))

  def describeImages(
    request: DescribeImagesRequest
  ): AppStreamIO[DescribeImagesResponse] =
    FF.liftF(DescribeImagesOp(request))

  def describeSessions(
    request: DescribeSessionsRequest
  ): AppStreamIO[DescribeSessionsResponse] =
    FF.liftF(DescribeSessionsOp(request))

  def describeStacks(
    request: DescribeStacksRequest
  ): AppStreamIO[DescribeStacksResponse] =
    FF.liftF(DescribeStacksOp(request))

  def describeUsageReportSubscriptions(
    request: DescribeUsageReportSubscriptionsRequest
  ): AppStreamIO[DescribeUsageReportSubscriptionsResponse] =
    FF.liftF(DescribeUsageReportSubscriptionsOp(request))

  def describeUserStackAssociations(
    request: DescribeUserStackAssociationsRequest
  ): AppStreamIO[DescribeUserStackAssociationsResponse] =
    FF.liftF(DescribeUserStackAssociationsOp(request))

  def describeUsers(
    request: DescribeUsersRequest
  ): AppStreamIO[DescribeUsersResponse] =
    FF.liftF(DescribeUsersOp(request))

  def disableUser(
    request: DisableUserRequest
  ): AppStreamIO[DisableUserResponse] =
    FF.liftF(DisableUserOp(request))

  def disassociateFleet(
    request: DisassociateFleetRequest
  ): AppStreamIO[DisassociateFleetResponse] =
    FF.liftF(DisassociateFleetOp(request))

  def enableUser(
    request: EnableUserRequest
  ): AppStreamIO[EnableUserResponse] =
    FF.liftF(EnableUserOp(request))

  def expireSession(
    request: ExpireSessionRequest
  ): AppStreamIO[ExpireSessionResponse] =
    FF.liftF(ExpireSessionOp(request))

  def listAssociatedFleets(
    request: ListAssociatedFleetsRequest
  ): AppStreamIO[ListAssociatedFleetsResponse] =
    FF.liftF(ListAssociatedFleetsOp(request))

  def listAssociatedStacks(
    request: ListAssociatedStacksRequest
  ): AppStreamIO[ListAssociatedStacksResponse] =
    FF.liftF(ListAssociatedStacksOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppStreamIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startFleet(
    request: StartFleetRequest
  ): AppStreamIO[StartFleetResponse] =
    FF.liftF(StartFleetOp(request))

  def startImageBuilder(
    request: StartImageBuilderRequest
  ): AppStreamIO[StartImageBuilderResponse] =
    FF.liftF(StartImageBuilderOp(request))

  def stopFleet(
    request: StopFleetRequest
  ): AppStreamIO[StopFleetResponse] =
    FF.liftF(StopFleetOp(request))

  def stopImageBuilder(
    request: StopImageBuilderRequest
  ): AppStreamIO[StopImageBuilderResponse] =
    FF.liftF(StopImageBuilderOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppStreamIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppStreamIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDirectoryConfig(
    request: UpdateDirectoryConfigRequest
  ): AppStreamIO[UpdateDirectoryConfigResponse] =
    FF.liftF(UpdateDirectoryConfigOp(request))

  def updateFleet(
    request: UpdateFleetRequest
  ): AppStreamIO[UpdateFleetResponse] =
    FF.liftF(UpdateFleetOp(request))

  def updateImagePermissions(
    request: UpdateImagePermissionsRequest
  ): AppStreamIO[UpdateImagePermissionsResponse] =
    FF.liftF(UpdateImagePermissionsOp(request))

  def updateStack(
    request: UpdateStackRequest
  ): AppStreamIO[UpdateStackResponse] =
    FF.liftF(UpdateStackOp(request))
}
