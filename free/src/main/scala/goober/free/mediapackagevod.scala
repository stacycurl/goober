package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mediapackagevod.MediaPackageVodClient
import software.amazon.awssdk.services.mediapackagevod.model._


object mediapackagevod { module =>

  // Free monad over MediaPackageVodOp
  type MediaPackageVodIO[A] = FF[MediaPackageVodOp, A]

  sealed trait MediaPackageVodOp[A] {
    def visit[F[_]](visitor: MediaPackageVodOp.Visitor[F]): F[A]
  }

  object MediaPackageVodOp {
    // Given a MediaPackageVodClient we can embed a MediaPackageVodIO program in any algebra that understands embedding.
    implicit val MediaPackageVodOpEmbeddable: Embeddable[MediaPackageVodOp, MediaPackageVodClient] = new Embeddable[MediaPackageVodOp, MediaPackageVodClient] {
      def embed[A](client: MediaPackageVodClient, io: MediaPackageVodIO[A]): Embedded[A] = Embedded.MediaPackageVod(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MediaPackageVodOp.Visitor[Kleisli[M, MediaPackageVodClient, *]] {
        def configureLogs(
          request: ConfigureLogsRequest
        ): Kleisli[M, MediaPackageVodClient, ConfigureLogsResponse] =
          primitive(_.configureLogs(request))

        def createAsset(
          request: CreateAssetRequest
        ): Kleisli[M, MediaPackageVodClient, CreateAssetResponse] =
          primitive(_.createAsset(request))

        def createPackagingConfiguration(
          request: CreatePackagingConfigurationRequest
        ): Kleisli[M, MediaPackageVodClient, CreatePackagingConfigurationResponse] =
          primitive(_.createPackagingConfiguration(request))

        def createPackagingGroup(
          request: CreatePackagingGroupRequest
        ): Kleisli[M, MediaPackageVodClient, CreatePackagingGroupResponse] =
          primitive(_.createPackagingGroup(request))

        def deleteAsset(
          request: DeleteAssetRequest
        ): Kleisli[M, MediaPackageVodClient, DeleteAssetResponse] =
          primitive(_.deleteAsset(request))

        def deletePackagingConfiguration(
          request: DeletePackagingConfigurationRequest
        ): Kleisli[M, MediaPackageVodClient, DeletePackagingConfigurationResponse] =
          primitive(_.deletePackagingConfiguration(request))

        def deletePackagingGroup(
          request: DeletePackagingGroupRequest
        ): Kleisli[M, MediaPackageVodClient, DeletePackagingGroupResponse] =
          primitive(_.deletePackagingGroup(request))

        def describeAsset(
          request: DescribeAssetRequest
        ): Kleisli[M, MediaPackageVodClient, DescribeAssetResponse] =
          primitive(_.describeAsset(request))

        def describePackagingConfiguration(
          request: DescribePackagingConfigurationRequest
        ): Kleisli[M, MediaPackageVodClient, DescribePackagingConfigurationResponse] =
          primitive(_.describePackagingConfiguration(request))

        def describePackagingGroup(
          request: DescribePackagingGroupRequest
        ): Kleisli[M, MediaPackageVodClient, DescribePackagingGroupResponse] =
          primitive(_.describePackagingGroup(request))

        def listAssets(
          request: ListAssetsRequest
        ): Kleisli[M, MediaPackageVodClient, ListAssetsResponse] =
          primitive(_.listAssets(request))

        def listPackagingConfigurations(
          request: ListPackagingConfigurationsRequest
        ): Kleisli[M, MediaPackageVodClient, ListPackagingConfigurationsResponse] =
          primitive(_.listPackagingConfigurations(request))

        def listPackagingGroups(
          request: ListPackagingGroupsRequest
        ): Kleisli[M, MediaPackageVodClient, ListPackagingGroupsResponse] =
          primitive(_.listPackagingGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MediaPackageVodClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MediaPackageVodClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MediaPackageVodClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updatePackagingGroup(
          request: UpdatePackagingGroupRequest
        ): Kleisli[M, MediaPackageVodClient, UpdatePackagingGroupResponse] =
          primitive(_.updatePackagingGroup(request))

        def primitive[A](
          f: MediaPackageVodClient => A
        ): Kleisli[M, MediaPackageVodClient, A]
      }
    }

    trait Visitor[F[_]] extends (MediaPackageVodOp ~> F) {
      final def apply[A](op: MediaPackageVodOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def configureLogs(
        request: ConfigureLogsRequest
      ): F[ConfigureLogsResponse]

      def createAsset(
        request: CreateAssetRequest
      ): F[CreateAssetResponse]

      def createPackagingConfiguration(
        request: CreatePackagingConfigurationRequest
      ): F[CreatePackagingConfigurationResponse]

      def createPackagingGroup(
        request: CreatePackagingGroupRequest
      ): F[CreatePackagingGroupResponse]

      def deleteAsset(
        request: DeleteAssetRequest
      ): F[DeleteAssetResponse]

      def deletePackagingConfiguration(
        request: DeletePackagingConfigurationRequest
      ): F[DeletePackagingConfigurationResponse]

      def deletePackagingGroup(
        request: DeletePackagingGroupRequest
      ): F[DeletePackagingGroupResponse]

      def describeAsset(
        request: DescribeAssetRequest
      ): F[DescribeAssetResponse]

      def describePackagingConfiguration(
        request: DescribePackagingConfigurationRequest
      ): F[DescribePackagingConfigurationResponse]

      def describePackagingGroup(
        request: DescribePackagingGroupRequest
      ): F[DescribePackagingGroupResponse]

      def listAssets(
        request: ListAssetsRequest
      ): F[ListAssetsResponse]

      def listPackagingConfigurations(
        request: ListPackagingConfigurationsRequest
      ): F[ListPackagingConfigurationsResponse]

      def listPackagingGroups(
        request: ListPackagingGroupsRequest
      ): F[ListPackagingGroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updatePackagingGroup(
        request: UpdatePackagingGroupRequest
      ): F[UpdatePackagingGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MediaPackageVodOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ConfigureLogsOp(
      request: ConfigureLogsRequest
    ) extends MediaPackageVodOp[ConfigureLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ConfigureLogsResponse] =
        visitor.configureLogs(request)
    }

    final case class CreateAssetOp(
      request: CreateAssetRequest
    ) extends MediaPackageVodOp[CreateAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssetResponse] =
        visitor.createAsset(request)
    }

    final case class CreatePackagingConfigurationOp(
      request: CreatePackagingConfigurationRequest
    ) extends MediaPackageVodOp[CreatePackagingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePackagingConfigurationResponse] =
        visitor.createPackagingConfiguration(request)
    }

    final case class CreatePackagingGroupOp(
      request: CreatePackagingGroupRequest
    ) extends MediaPackageVodOp[CreatePackagingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePackagingGroupResponse] =
        visitor.createPackagingGroup(request)
    }

    final case class DeleteAssetOp(
      request: DeleteAssetRequest
    ) extends MediaPackageVodOp[DeleteAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssetResponse] =
        visitor.deleteAsset(request)
    }

    final case class DeletePackagingConfigurationOp(
      request: DeletePackagingConfigurationRequest
    ) extends MediaPackageVodOp[DeletePackagingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePackagingConfigurationResponse] =
        visitor.deletePackagingConfiguration(request)
    }

    final case class DeletePackagingGroupOp(
      request: DeletePackagingGroupRequest
    ) extends MediaPackageVodOp[DeletePackagingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePackagingGroupResponse] =
        visitor.deletePackagingGroup(request)
    }

    final case class DescribeAssetOp(
      request: DescribeAssetRequest
    ) extends MediaPackageVodOp[DescribeAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssetResponse] =
        visitor.describeAsset(request)
    }

    final case class DescribePackagingConfigurationOp(
      request: DescribePackagingConfigurationRequest
    ) extends MediaPackageVodOp[DescribePackagingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePackagingConfigurationResponse] =
        visitor.describePackagingConfiguration(request)
    }

    final case class DescribePackagingGroupOp(
      request: DescribePackagingGroupRequest
    ) extends MediaPackageVodOp[DescribePackagingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePackagingGroupResponse] =
        visitor.describePackagingGroup(request)
    }

    final case class ListAssetsOp(
      request: ListAssetsRequest
    ) extends MediaPackageVodOp[ListAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssetsResponse] =
        visitor.listAssets(request)
    }

    final case class ListPackagingConfigurationsOp(
      request: ListPackagingConfigurationsRequest
    ) extends MediaPackageVodOp[ListPackagingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackagingConfigurationsResponse] =
        visitor.listPackagingConfigurations(request)
    }

    final case class ListPackagingGroupsOp(
      request: ListPackagingGroupsRequest
    ) extends MediaPackageVodOp[ListPackagingGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPackagingGroupsResponse] =
        visitor.listPackagingGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MediaPackageVodOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MediaPackageVodOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MediaPackageVodOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdatePackagingGroupOp(
      request: UpdatePackagingGroupRequest
    ) extends MediaPackageVodOp[UpdatePackagingGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePackagingGroupResponse] =
        visitor.updatePackagingGroup(request)
    }
  }

  import MediaPackageVodOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MediaPackageVodOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def configureLogs(
    request: ConfigureLogsRequest
  ): MediaPackageVodIO[ConfigureLogsResponse] =
    FF.liftF(ConfigureLogsOp(request))

  def createAsset(
    request: CreateAssetRequest
  ): MediaPackageVodIO[CreateAssetResponse] =
    FF.liftF(CreateAssetOp(request))

  def createPackagingConfiguration(
    request: CreatePackagingConfigurationRequest
  ): MediaPackageVodIO[CreatePackagingConfigurationResponse] =
    FF.liftF(CreatePackagingConfigurationOp(request))

  def createPackagingGroup(
    request: CreatePackagingGroupRequest
  ): MediaPackageVodIO[CreatePackagingGroupResponse] =
    FF.liftF(CreatePackagingGroupOp(request))

  def deleteAsset(
    request: DeleteAssetRequest
  ): MediaPackageVodIO[DeleteAssetResponse] =
    FF.liftF(DeleteAssetOp(request))

  def deletePackagingConfiguration(
    request: DeletePackagingConfigurationRequest
  ): MediaPackageVodIO[DeletePackagingConfigurationResponse] =
    FF.liftF(DeletePackagingConfigurationOp(request))

  def deletePackagingGroup(
    request: DeletePackagingGroupRequest
  ): MediaPackageVodIO[DeletePackagingGroupResponse] =
    FF.liftF(DeletePackagingGroupOp(request))

  def describeAsset(
    request: DescribeAssetRequest
  ): MediaPackageVodIO[DescribeAssetResponse] =
    FF.liftF(DescribeAssetOp(request))

  def describePackagingConfiguration(
    request: DescribePackagingConfigurationRequest
  ): MediaPackageVodIO[DescribePackagingConfigurationResponse] =
    FF.liftF(DescribePackagingConfigurationOp(request))

  def describePackagingGroup(
    request: DescribePackagingGroupRequest
  ): MediaPackageVodIO[DescribePackagingGroupResponse] =
    FF.liftF(DescribePackagingGroupOp(request))

  def listAssets(
    request: ListAssetsRequest
  ): MediaPackageVodIO[ListAssetsResponse] =
    FF.liftF(ListAssetsOp(request))

  def listPackagingConfigurations(
    request: ListPackagingConfigurationsRequest
  ): MediaPackageVodIO[ListPackagingConfigurationsResponse] =
    FF.liftF(ListPackagingConfigurationsOp(request))

  def listPackagingGroups(
    request: ListPackagingGroupsRequest
  ): MediaPackageVodIO[ListPackagingGroupsResponse] =
    FF.liftF(ListPackagingGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MediaPackageVodIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MediaPackageVodIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MediaPackageVodIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updatePackagingGroup(
    request: UpdatePackagingGroupRequest
  ): MediaPackageVodIO[UpdatePackagingGroupResponse] =
    FF.liftF(UpdatePackagingGroupOp(request))
}
