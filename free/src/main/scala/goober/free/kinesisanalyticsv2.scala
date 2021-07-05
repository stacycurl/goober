package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisanalyticsv2.KinesisAnalyticsV2Client
import software.amazon.awssdk.services.kinesisanalyticsv2.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object kinesisanalyticsv2 { module =>

  // Free monad over KinesisAnalyticsV2Op
  type KinesisAnalyticsV2IO[A] = FF[KinesisAnalyticsV2Op, A]

  sealed trait KinesisAnalyticsV2Op[A] {
    def visit[F[_]](visitor: KinesisAnalyticsV2Op.Visitor[F]): F[A]
  }

  object KinesisAnalyticsV2Op {
    // Given a KinesisAnalyticsV2Client we can embed a KinesisAnalyticsV2IO program in any algebra that understands embedding.
    implicit val KinesisAnalyticsV2OpEmbeddable: Embeddable[KinesisAnalyticsV2Op, KinesisAnalyticsV2Client] = new Embeddable[KinesisAnalyticsV2Op, KinesisAnalyticsV2Client] {
      def embed[A](client: KinesisAnalyticsV2Client, io: KinesisAnalyticsV2IO[A]): Embedded[A] = Embedded.KinesisAnalyticsV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisAnalyticsV2Op.Visitor[Kleisli[M, KinesisAnalyticsV2Client, *]] {
        def addApplicationCloudWatchLoggingOption(
          request: AddApplicationCloudWatchLoggingOptionRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, AddApplicationCloudWatchLoggingOptionResponse] =
          primitive(_.addApplicationCloudWatchLoggingOption(request))

        def addApplicationInput(
          request: AddApplicationInputRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, AddApplicationInputResponse] =
          primitive(_.addApplicationInput(request))

        def addApplicationInputProcessingConfiguration(
          request: AddApplicationInputProcessingConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, AddApplicationInputProcessingConfigurationResponse] =
          primitive(_.addApplicationInputProcessingConfiguration(request))

        def addApplicationOutput(
          request: AddApplicationOutputRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, AddApplicationOutputResponse] =
          primitive(_.addApplicationOutput(request))

        def addApplicationReferenceDataSource(
          request: AddApplicationReferenceDataSourceRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, AddApplicationReferenceDataSourceResponse] =
          primitive(_.addApplicationReferenceDataSource(request))

        def addApplicationVpcConfiguration(
          request: AddApplicationVpcConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, AddApplicationVpcConfigurationResponse] =
          primitive(_.addApplicationVpcConfiguration(request))

        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createApplicationPresignedUrl(
          request: CreateApplicationPresignedUrlRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, CreateApplicationPresignedUrlResponse] =
          primitive(_.createApplicationPresignedUrl(request))

        def createApplicationSnapshot(
          request: CreateApplicationSnapshotRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, CreateApplicationSnapshotResponse] =
          primitive(_.createApplicationSnapshot(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteApplicationCloudWatchLoggingOption(
          request: DeleteApplicationCloudWatchLoggingOptionRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationCloudWatchLoggingOptionResponse] =
          primitive(_.deleteApplicationCloudWatchLoggingOption(request))

        def deleteApplicationInputProcessingConfiguration(
          request: DeleteApplicationInputProcessingConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationInputProcessingConfigurationResponse] =
          primitive(_.deleteApplicationInputProcessingConfiguration(request))

        def deleteApplicationOutput(
          request: DeleteApplicationOutputRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationOutputResponse] =
          primitive(_.deleteApplicationOutput(request))

        def deleteApplicationReferenceDataSource(
          request: DeleteApplicationReferenceDataSourceRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationReferenceDataSourceResponse] =
          primitive(_.deleteApplicationReferenceDataSource(request))

        def deleteApplicationSnapshot(
          request: DeleteApplicationSnapshotRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationSnapshotResponse] =
          primitive(_.deleteApplicationSnapshot(request))

        def deleteApplicationVpcConfiguration(
          request: DeleteApplicationVpcConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DeleteApplicationVpcConfigurationResponse] =
          primitive(_.deleteApplicationVpcConfiguration(request))

        def describeApplication(
          request: DescribeApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DescribeApplicationResponse] =
          primitive(_.describeApplication(request))

        def describeApplicationSnapshot(
          request: DescribeApplicationSnapshotRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DescribeApplicationSnapshotResponse] =
          primitive(_.describeApplicationSnapshot(request))

        def describeApplicationVersion(
          request: DescribeApplicationVersionRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DescribeApplicationVersionResponse] =
          primitive(_.describeApplicationVersion(request))

        def discoverInputSchema(
          request: DiscoverInputSchemaRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, DiscoverInputSchemaResponse] =
          primitive(_.discoverInputSchema(request))

        def listApplicationSnapshots(
          request: ListApplicationSnapshotsRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, ListApplicationSnapshotsResponse] =
          primitive(_.listApplicationSnapshots(request))

        def listApplicationVersions(
          request: ListApplicationVersionsRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, ListApplicationVersionsResponse] =
          primitive(_.listApplicationVersions(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rollbackApplication(
          request: RollbackApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, RollbackApplicationResponse] =
          primitive(_.rollbackApplication(request))

        def startApplication(
          request: StartApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, StartApplicationResponse] =
          primitive(_.startApplication(request))

        def stopApplication(
          request: StopApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, StopApplicationResponse] =
          primitive(_.stopApplication(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def updateApplicationMaintenanceConfiguration(
          request: UpdateApplicationMaintenanceConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsV2Client, UpdateApplicationMaintenanceConfigurationResponse] =
          primitive(_.updateApplicationMaintenanceConfiguration(request))

        def primitive[A](
          f: KinesisAnalyticsV2Client => A
        ): Kleisli[M, KinesisAnalyticsV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisAnalyticsV2Op ~> F) {
      final def apply[A](op: KinesisAnalyticsV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addApplicationCloudWatchLoggingOption(
        request: AddApplicationCloudWatchLoggingOptionRequest
      ): F[AddApplicationCloudWatchLoggingOptionResponse]

      def addApplicationInput(
        request: AddApplicationInputRequest
      ): F[AddApplicationInputResponse]

      def addApplicationInputProcessingConfiguration(
        request: AddApplicationInputProcessingConfigurationRequest
      ): F[AddApplicationInputProcessingConfigurationResponse]

      def addApplicationOutput(
        request: AddApplicationOutputRequest
      ): F[AddApplicationOutputResponse]

      def addApplicationReferenceDataSource(
        request: AddApplicationReferenceDataSourceRequest
      ): F[AddApplicationReferenceDataSourceResponse]

      def addApplicationVpcConfiguration(
        request: AddApplicationVpcConfigurationRequest
      ): F[AddApplicationVpcConfigurationResponse]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createApplicationPresignedUrl(
        request: CreateApplicationPresignedUrlRequest
      ): F[CreateApplicationPresignedUrlResponse]

      def createApplicationSnapshot(
        request: CreateApplicationSnapshotRequest
      ): F[CreateApplicationSnapshotResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def deleteApplicationCloudWatchLoggingOption(
        request: DeleteApplicationCloudWatchLoggingOptionRequest
      ): F[DeleteApplicationCloudWatchLoggingOptionResponse]

      def deleteApplicationInputProcessingConfiguration(
        request: DeleteApplicationInputProcessingConfigurationRequest
      ): F[DeleteApplicationInputProcessingConfigurationResponse]

      def deleteApplicationOutput(
        request: DeleteApplicationOutputRequest
      ): F[DeleteApplicationOutputResponse]

      def deleteApplicationReferenceDataSource(
        request: DeleteApplicationReferenceDataSourceRequest
      ): F[DeleteApplicationReferenceDataSourceResponse]

      def deleteApplicationSnapshot(
        request: DeleteApplicationSnapshotRequest
      ): F[DeleteApplicationSnapshotResponse]

      def deleteApplicationVpcConfiguration(
        request: DeleteApplicationVpcConfigurationRequest
      ): F[DeleteApplicationVpcConfigurationResponse]

      def describeApplication(
        request: DescribeApplicationRequest
      ): F[DescribeApplicationResponse]

      def describeApplicationSnapshot(
        request: DescribeApplicationSnapshotRequest
      ): F[DescribeApplicationSnapshotResponse]

      def describeApplicationVersion(
        request: DescribeApplicationVersionRequest
      ): F[DescribeApplicationVersionResponse]

      def discoverInputSchema(
        request: DiscoverInputSchemaRequest
      ): F[DiscoverInputSchemaResponse]

      def listApplicationSnapshots(
        request: ListApplicationSnapshotsRequest
      ): F[ListApplicationSnapshotsResponse]

      def listApplicationVersions(
        request: ListApplicationVersionsRequest
      ): F[ListApplicationVersionsResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rollbackApplication(
        request: RollbackApplicationRequest
      ): F[RollbackApplicationResponse]

      def startApplication(
        request: StartApplicationRequest
      ): F[StartApplicationResponse]

      def stopApplication(
        request: StopApplicationRequest
      ): F[StopApplicationResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]

      def updateApplicationMaintenanceConfiguration(
        request: UpdateApplicationMaintenanceConfigurationRequest
      ): F[UpdateApplicationMaintenanceConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisAnalyticsV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddApplicationCloudWatchLoggingOptionOp(
      request: AddApplicationCloudWatchLoggingOptionRequest
    ) extends KinesisAnalyticsV2Op[AddApplicationCloudWatchLoggingOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationCloudWatchLoggingOptionResponse] =
        visitor.addApplicationCloudWatchLoggingOption(request)
    }

    final case class AddApplicationInputOp(
      request: AddApplicationInputRequest
    ) extends KinesisAnalyticsV2Op[AddApplicationInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationInputResponse] =
        visitor.addApplicationInput(request)
    }

    final case class AddApplicationInputProcessingConfigurationOp(
      request: AddApplicationInputProcessingConfigurationRequest
    ) extends KinesisAnalyticsV2Op[AddApplicationInputProcessingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationInputProcessingConfigurationResponse] =
        visitor.addApplicationInputProcessingConfiguration(request)
    }

    final case class AddApplicationOutputOp(
      request: AddApplicationOutputRequest
    ) extends KinesisAnalyticsV2Op[AddApplicationOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationOutputResponse] =
        visitor.addApplicationOutput(request)
    }

    final case class AddApplicationReferenceDataSourceOp(
      request: AddApplicationReferenceDataSourceRequest
    ) extends KinesisAnalyticsV2Op[AddApplicationReferenceDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationReferenceDataSourceResponse] =
        visitor.addApplicationReferenceDataSource(request)
    }

    final case class AddApplicationVpcConfigurationOp(
      request: AddApplicationVpcConfigurationRequest
    ) extends KinesisAnalyticsV2Op[AddApplicationVpcConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationVpcConfigurationResponse] =
        visitor.addApplicationVpcConfiguration(request)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends KinesisAnalyticsV2Op[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateApplicationPresignedUrlOp(
      request: CreateApplicationPresignedUrlRequest
    ) extends KinesisAnalyticsV2Op[CreateApplicationPresignedUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationPresignedUrlResponse] =
        visitor.createApplicationPresignedUrl(request)
    }

    final case class CreateApplicationSnapshotOp(
      request: CreateApplicationSnapshotRequest
    ) extends KinesisAnalyticsV2Op[CreateApplicationSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationSnapshotResponse] =
        visitor.createApplicationSnapshot(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteApplicationCloudWatchLoggingOptionOp(
      request: DeleteApplicationCloudWatchLoggingOptionRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationCloudWatchLoggingOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationCloudWatchLoggingOptionResponse] =
        visitor.deleteApplicationCloudWatchLoggingOption(request)
    }

    final case class DeleteApplicationInputProcessingConfigurationOp(
      request: DeleteApplicationInputProcessingConfigurationRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationInputProcessingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationInputProcessingConfigurationResponse] =
        visitor.deleteApplicationInputProcessingConfiguration(request)
    }

    final case class DeleteApplicationOutputOp(
      request: DeleteApplicationOutputRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationOutputResponse] =
        visitor.deleteApplicationOutput(request)
    }

    final case class DeleteApplicationReferenceDataSourceOp(
      request: DeleteApplicationReferenceDataSourceRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationReferenceDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationReferenceDataSourceResponse] =
        visitor.deleteApplicationReferenceDataSource(request)
    }

    final case class DeleteApplicationSnapshotOp(
      request: DeleteApplicationSnapshotRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationSnapshotResponse] =
        visitor.deleteApplicationSnapshot(request)
    }

    final case class DeleteApplicationVpcConfigurationOp(
      request: DeleteApplicationVpcConfigurationRequest
    ) extends KinesisAnalyticsV2Op[DeleteApplicationVpcConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationVpcConfigurationResponse] =
        visitor.deleteApplicationVpcConfiguration(request)
    }

    final case class DescribeApplicationOp(
      request: DescribeApplicationRequest
    ) extends KinesisAnalyticsV2Op[DescribeApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationResponse] =
        visitor.describeApplication(request)
    }

    final case class DescribeApplicationSnapshotOp(
      request: DescribeApplicationSnapshotRequest
    ) extends KinesisAnalyticsV2Op[DescribeApplicationSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationSnapshotResponse] =
        visitor.describeApplicationSnapshot(request)
    }

    final case class DescribeApplicationVersionOp(
      request: DescribeApplicationVersionRequest
    ) extends KinesisAnalyticsV2Op[DescribeApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationVersionResponse] =
        visitor.describeApplicationVersion(request)
    }

    final case class DiscoverInputSchemaOp(
      request: DiscoverInputSchemaRequest
    ) extends KinesisAnalyticsV2Op[DiscoverInputSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DiscoverInputSchemaResponse] =
        visitor.discoverInputSchema(request)
    }

    final case class ListApplicationSnapshotsOp(
      request: ListApplicationSnapshotsRequest
    ) extends KinesisAnalyticsV2Op[ListApplicationSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationSnapshotsResponse] =
        visitor.listApplicationSnapshots(request)
    }

    final case class ListApplicationVersionsOp(
      request: ListApplicationVersionsRequest
    ) extends KinesisAnalyticsV2Op[ListApplicationVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationVersionsResponse] =
        visitor.listApplicationVersions(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends KinesisAnalyticsV2Op[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends KinesisAnalyticsV2Op[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RollbackApplicationOp(
      request: RollbackApplicationRequest
    ) extends KinesisAnalyticsV2Op[RollbackApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RollbackApplicationResponse] =
        visitor.rollbackApplication(request)
    }

    final case class StartApplicationOp(
      request: StartApplicationRequest
    ) extends KinesisAnalyticsV2Op[StartApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartApplicationResponse] =
        visitor.startApplication(request)
    }

    final case class StopApplicationOp(
      request: StopApplicationRequest
    ) extends KinesisAnalyticsV2Op[StopApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopApplicationResponse] =
        visitor.stopApplication(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends KinesisAnalyticsV2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends KinesisAnalyticsV2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends KinesisAnalyticsV2Op[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }

    final case class UpdateApplicationMaintenanceConfigurationOp(
      request: UpdateApplicationMaintenanceConfigurationRequest
    ) extends KinesisAnalyticsV2Op[UpdateApplicationMaintenanceConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationMaintenanceConfigurationResponse] =
        visitor.updateApplicationMaintenanceConfiguration(request)
    }
  }

  import KinesisAnalyticsV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisAnalyticsV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addApplicationCloudWatchLoggingOption(
    request: AddApplicationCloudWatchLoggingOptionRequest
  ): KinesisAnalyticsV2IO[AddApplicationCloudWatchLoggingOptionResponse] =
    FF.liftF(AddApplicationCloudWatchLoggingOptionOp(request))

  def addApplicationInput(
    request: AddApplicationInputRequest
  ): KinesisAnalyticsV2IO[AddApplicationInputResponse] =
    FF.liftF(AddApplicationInputOp(request))

  def addApplicationInputProcessingConfiguration(
    request: AddApplicationInputProcessingConfigurationRequest
  ): KinesisAnalyticsV2IO[AddApplicationInputProcessingConfigurationResponse] =
    FF.liftF(AddApplicationInputProcessingConfigurationOp(request))

  def addApplicationOutput(
    request: AddApplicationOutputRequest
  ): KinesisAnalyticsV2IO[AddApplicationOutputResponse] =
    FF.liftF(AddApplicationOutputOp(request))

  def addApplicationReferenceDataSource(
    request: AddApplicationReferenceDataSourceRequest
  ): KinesisAnalyticsV2IO[AddApplicationReferenceDataSourceResponse] =
    FF.liftF(AddApplicationReferenceDataSourceOp(request))

  def addApplicationVpcConfiguration(
    request: AddApplicationVpcConfigurationRequest
  ): KinesisAnalyticsV2IO[AddApplicationVpcConfigurationResponse] =
    FF.liftF(AddApplicationVpcConfigurationOp(request))

  def createApplication(
    request: CreateApplicationRequest
  ): KinesisAnalyticsV2IO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createApplicationPresignedUrl(
    request: CreateApplicationPresignedUrlRequest
  ): KinesisAnalyticsV2IO[CreateApplicationPresignedUrlResponse] =
    FF.liftF(CreateApplicationPresignedUrlOp(request))

  def createApplicationSnapshot(
    request: CreateApplicationSnapshotRequest
  ): KinesisAnalyticsV2IO[CreateApplicationSnapshotResponse] =
    FF.liftF(CreateApplicationSnapshotOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteApplicationCloudWatchLoggingOption(
    request: DeleteApplicationCloudWatchLoggingOptionRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationCloudWatchLoggingOptionResponse] =
    FF.liftF(DeleteApplicationCloudWatchLoggingOptionOp(request))

  def deleteApplicationInputProcessingConfiguration(
    request: DeleteApplicationInputProcessingConfigurationRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationInputProcessingConfigurationResponse] =
    FF.liftF(DeleteApplicationInputProcessingConfigurationOp(request))

  def deleteApplicationOutput(
    request: DeleteApplicationOutputRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationOutputResponse] =
    FF.liftF(DeleteApplicationOutputOp(request))

  def deleteApplicationReferenceDataSource(
    request: DeleteApplicationReferenceDataSourceRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationReferenceDataSourceResponse] =
    FF.liftF(DeleteApplicationReferenceDataSourceOp(request))

  def deleteApplicationSnapshot(
    request: DeleteApplicationSnapshotRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationSnapshotResponse] =
    FF.liftF(DeleteApplicationSnapshotOp(request))

  def deleteApplicationVpcConfiguration(
    request: DeleteApplicationVpcConfigurationRequest
  ): KinesisAnalyticsV2IO[DeleteApplicationVpcConfigurationResponse] =
    FF.liftF(DeleteApplicationVpcConfigurationOp(request))

  def describeApplication(
    request: DescribeApplicationRequest
  ): KinesisAnalyticsV2IO[DescribeApplicationResponse] =
    FF.liftF(DescribeApplicationOp(request))

  def describeApplicationSnapshot(
    request: DescribeApplicationSnapshotRequest
  ): KinesisAnalyticsV2IO[DescribeApplicationSnapshotResponse] =
    FF.liftF(DescribeApplicationSnapshotOp(request))

  def describeApplicationVersion(
    request: DescribeApplicationVersionRequest
  ): KinesisAnalyticsV2IO[DescribeApplicationVersionResponse] =
    FF.liftF(DescribeApplicationVersionOp(request))

  def discoverInputSchema(
    request: DiscoverInputSchemaRequest
  ): KinesisAnalyticsV2IO[DiscoverInputSchemaResponse] =
    FF.liftF(DiscoverInputSchemaOp(request))

  def listApplicationSnapshots(
    request: ListApplicationSnapshotsRequest
  ): KinesisAnalyticsV2IO[ListApplicationSnapshotsResponse] =
    FF.liftF(ListApplicationSnapshotsOp(request))

  def listApplicationVersions(
    request: ListApplicationVersionsRequest
  ): KinesisAnalyticsV2IO[ListApplicationVersionsResponse] =
    FF.liftF(ListApplicationVersionsOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): KinesisAnalyticsV2IO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): KinesisAnalyticsV2IO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rollbackApplication(
    request: RollbackApplicationRequest
  ): KinesisAnalyticsV2IO[RollbackApplicationResponse] =
    FF.liftF(RollbackApplicationOp(request))

  def startApplication(
    request: StartApplicationRequest
  ): KinesisAnalyticsV2IO[StartApplicationResponse] =
    FF.liftF(StartApplicationOp(request))

  def stopApplication(
    request: StopApplicationRequest
  ): KinesisAnalyticsV2IO[StopApplicationResponse] =
    FF.liftF(StopApplicationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): KinesisAnalyticsV2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): KinesisAnalyticsV2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): KinesisAnalyticsV2IO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))

  def updateApplicationMaintenanceConfiguration(
    request: UpdateApplicationMaintenanceConfigurationRequest
  ): KinesisAnalyticsV2IO[UpdateApplicationMaintenanceConfigurationResponse] =
    FF.liftF(UpdateApplicationMaintenanceConfigurationOp(request))
}
