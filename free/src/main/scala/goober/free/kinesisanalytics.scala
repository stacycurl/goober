package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kinesisanalytics.KinesisAnalyticsClient
import software.amazon.awssdk.services.kinesisanalytics.model._


object kinesisanalytics { module =>

  // Free monad over KinesisAnalyticsOp
  type KinesisAnalyticsIO[A] = FF[KinesisAnalyticsOp, A]

  sealed trait KinesisAnalyticsOp[A] {
    def visit[F[_]](visitor: KinesisAnalyticsOp.Visitor[F]): F[A]
  }

  object KinesisAnalyticsOp {
    // Given a KinesisAnalyticsClient we can embed a KinesisAnalyticsIO program in any algebra that understands embedding.
    implicit val KinesisAnalyticsOpEmbeddable: Embeddable[KinesisAnalyticsOp, KinesisAnalyticsClient] = new Embeddable[KinesisAnalyticsOp, KinesisAnalyticsClient] {
      def embed[A](client: KinesisAnalyticsClient, io: KinesisAnalyticsIO[A]): Embedded[A] = Embedded.KinesisAnalytics(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KinesisAnalyticsOp.Visitor[Kleisli[M, KinesisAnalyticsClient, *]] {
        def addApplicationCloudWatchLoggingOption(
          request: AddApplicationCloudWatchLoggingOptionRequest
        ): Kleisli[M, KinesisAnalyticsClient, AddApplicationCloudWatchLoggingOptionResponse] =
          primitive(_.addApplicationCloudWatchLoggingOption(request))

        def addApplicationInput(
          request: AddApplicationInputRequest
        ): Kleisli[M, KinesisAnalyticsClient, AddApplicationInputResponse] =
          primitive(_.addApplicationInput(request))

        def addApplicationInputProcessingConfiguration(
          request: AddApplicationInputProcessingConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsClient, AddApplicationInputProcessingConfigurationResponse] =
          primitive(_.addApplicationInputProcessingConfiguration(request))

        def addApplicationOutput(
          request: AddApplicationOutputRequest
        ): Kleisli[M, KinesisAnalyticsClient, AddApplicationOutputResponse] =
          primitive(_.addApplicationOutput(request))

        def addApplicationReferenceDataSource(
          request: AddApplicationReferenceDataSourceRequest
        ): Kleisli[M, KinesisAnalyticsClient, AddApplicationReferenceDataSourceResponse] =
          primitive(_.addApplicationReferenceDataSource(request))

        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, KinesisAnalyticsClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, KinesisAnalyticsClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteApplicationCloudWatchLoggingOption(
          request: DeleteApplicationCloudWatchLoggingOptionRequest
        ): Kleisli[M, KinesisAnalyticsClient, DeleteApplicationCloudWatchLoggingOptionResponse] =
          primitive(_.deleteApplicationCloudWatchLoggingOption(request))

        def deleteApplicationInputProcessingConfiguration(
          request: DeleteApplicationInputProcessingConfigurationRequest
        ): Kleisli[M, KinesisAnalyticsClient, DeleteApplicationInputProcessingConfigurationResponse] =
          primitive(_.deleteApplicationInputProcessingConfiguration(request))

        def deleteApplicationOutput(
          request: DeleteApplicationOutputRequest
        ): Kleisli[M, KinesisAnalyticsClient, DeleteApplicationOutputResponse] =
          primitive(_.deleteApplicationOutput(request))

        def deleteApplicationReferenceDataSource(
          request: DeleteApplicationReferenceDataSourceRequest
        ): Kleisli[M, KinesisAnalyticsClient, DeleteApplicationReferenceDataSourceResponse] =
          primitive(_.deleteApplicationReferenceDataSource(request))

        def describeApplication(
          request: DescribeApplicationRequest
        ): Kleisli[M, KinesisAnalyticsClient, DescribeApplicationResponse] =
          primitive(_.describeApplication(request))

        def discoverInputSchema(
          request: DiscoverInputSchemaRequest
        ): Kleisli[M, KinesisAnalyticsClient, DiscoverInputSchemaResponse] =
          primitive(_.discoverInputSchema(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, KinesisAnalyticsClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, KinesisAnalyticsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startApplication(
          request: StartApplicationRequest
        ): Kleisli[M, KinesisAnalyticsClient, StartApplicationResponse] =
          primitive(_.startApplication(request))

        def stopApplication(
          request: StopApplicationRequest
        ): Kleisli[M, KinesisAnalyticsClient, StopApplicationResponse] =
          primitive(_.stopApplication(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, KinesisAnalyticsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, KinesisAnalyticsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, KinesisAnalyticsClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def primitive[A](
          f: KinesisAnalyticsClient => A
        ): Kleisli[M, KinesisAnalyticsClient, A]
      }
    }

    trait Visitor[F[_]] extends (KinesisAnalyticsOp ~> F) {
      final def apply[A](op: KinesisAnalyticsOp[A]): F[A] = op.visit(this)

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

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

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

      def describeApplication(
        request: DescribeApplicationRequest
      ): F[DescribeApplicationResponse]

      def discoverInputSchema(
        request: DiscoverInputSchemaRequest
      ): F[DiscoverInputSchemaResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

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
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KinesisAnalyticsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddApplicationCloudWatchLoggingOptionOp(
      request: AddApplicationCloudWatchLoggingOptionRequest
    ) extends KinesisAnalyticsOp[AddApplicationCloudWatchLoggingOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationCloudWatchLoggingOptionResponse] =
        visitor.addApplicationCloudWatchLoggingOption(request)
    }

    final case class AddApplicationInputOp(
      request: AddApplicationInputRequest
    ) extends KinesisAnalyticsOp[AddApplicationInputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationInputResponse] =
        visitor.addApplicationInput(request)
    }

    final case class AddApplicationInputProcessingConfigurationOp(
      request: AddApplicationInputProcessingConfigurationRequest
    ) extends KinesisAnalyticsOp[AddApplicationInputProcessingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationInputProcessingConfigurationResponse] =
        visitor.addApplicationInputProcessingConfiguration(request)
    }

    final case class AddApplicationOutputOp(
      request: AddApplicationOutputRequest
    ) extends KinesisAnalyticsOp[AddApplicationOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationOutputResponse] =
        visitor.addApplicationOutput(request)
    }

    final case class AddApplicationReferenceDataSourceOp(
      request: AddApplicationReferenceDataSourceRequest
    ) extends KinesisAnalyticsOp[AddApplicationReferenceDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddApplicationReferenceDataSourceResponse] =
        visitor.addApplicationReferenceDataSource(request)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends KinesisAnalyticsOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends KinesisAnalyticsOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteApplicationCloudWatchLoggingOptionOp(
      request: DeleteApplicationCloudWatchLoggingOptionRequest
    ) extends KinesisAnalyticsOp[DeleteApplicationCloudWatchLoggingOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationCloudWatchLoggingOptionResponse] =
        visitor.deleteApplicationCloudWatchLoggingOption(request)
    }

    final case class DeleteApplicationInputProcessingConfigurationOp(
      request: DeleteApplicationInputProcessingConfigurationRequest
    ) extends KinesisAnalyticsOp[DeleteApplicationInputProcessingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationInputProcessingConfigurationResponse] =
        visitor.deleteApplicationInputProcessingConfiguration(request)
    }

    final case class DeleteApplicationOutputOp(
      request: DeleteApplicationOutputRequest
    ) extends KinesisAnalyticsOp[DeleteApplicationOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationOutputResponse] =
        visitor.deleteApplicationOutput(request)
    }

    final case class DeleteApplicationReferenceDataSourceOp(
      request: DeleteApplicationReferenceDataSourceRequest
    ) extends KinesisAnalyticsOp[DeleteApplicationReferenceDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationReferenceDataSourceResponse] =
        visitor.deleteApplicationReferenceDataSource(request)
    }

    final case class DescribeApplicationOp(
      request: DescribeApplicationRequest
    ) extends KinesisAnalyticsOp[DescribeApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationResponse] =
        visitor.describeApplication(request)
    }

    final case class DiscoverInputSchemaOp(
      request: DiscoverInputSchemaRequest
    ) extends KinesisAnalyticsOp[DiscoverInputSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DiscoverInputSchemaResponse] =
        visitor.discoverInputSchema(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends KinesisAnalyticsOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends KinesisAnalyticsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartApplicationOp(
      request: StartApplicationRequest
    ) extends KinesisAnalyticsOp[StartApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartApplicationResponse] =
        visitor.startApplication(request)
    }

    final case class StopApplicationOp(
      request: StopApplicationRequest
    ) extends KinesisAnalyticsOp[StopApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopApplicationResponse] =
        visitor.stopApplication(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends KinesisAnalyticsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends KinesisAnalyticsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends KinesisAnalyticsOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }
  }

  import KinesisAnalyticsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KinesisAnalyticsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addApplicationCloudWatchLoggingOption(
    request: AddApplicationCloudWatchLoggingOptionRequest
  ): KinesisAnalyticsIO[AddApplicationCloudWatchLoggingOptionResponse] =
    FF.liftF(AddApplicationCloudWatchLoggingOptionOp(request))

  def addApplicationInput(
    request: AddApplicationInputRequest
  ): KinesisAnalyticsIO[AddApplicationInputResponse] =
    FF.liftF(AddApplicationInputOp(request))

  def addApplicationInputProcessingConfiguration(
    request: AddApplicationInputProcessingConfigurationRequest
  ): KinesisAnalyticsIO[AddApplicationInputProcessingConfigurationResponse] =
    FF.liftF(AddApplicationInputProcessingConfigurationOp(request))

  def addApplicationOutput(
    request: AddApplicationOutputRequest
  ): KinesisAnalyticsIO[AddApplicationOutputResponse] =
    FF.liftF(AddApplicationOutputOp(request))

  def addApplicationReferenceDataSource(
    request: AddApplicationReferenceDataSourceRequest
  ): KinesisAnalyticsIO[AddApplicationReferenceDataSourceResponse] =
    FF.liftF(AddApplicationReferenceDataSourceOp(request))

  def createApplication(
    request: CreateApplicationRequest
  ): KinesisAnalyticsIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): KinesisAnalyticsIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteApplicationCloudWatchLoggingOption(
    request: DeleteApplicationCloudWatchLoggingOptionRequest
  ): KinesisAnalyticsIO[DeleteApplicationCloudWatchLoggingOptionResponse] =
    FF.liftF(DeleteApplicationCloudWatchLoggingOptionOp(request))

  def deleteApplicationInputProcessingConfiguration(
    request: DeleteApplicationInputProcessingConfigurationRequest
  ): KinesisAnalyticsIO[DeleteApplicationInputProcessingConfigurationResponse] =
    FF.liftF(DeleteApplicationInputProcessingConfigurationOp(request))

  def deleteApplicationOutput(
    request: DeleteApplicationOutputRequest
  ): KinesisAnalyticsIO[DeleteApplicationOutputResponse] =
    FF.liftF(DeleteApplicationOutputOp(request))

  def deleteApplicationReferenceDataSource(
    request: DeleteApplicationReferenceDataSourceRequest
  ): KinesisAnalyticsIO[DeleteApplicationReferenceDataSourceResponse] =
    FF.liftF(DeleteApplicationReferenceDataSourceOp(request))

  def describeApplication(
    request: DescribeApplicationRequest
  ): KinesisAnalyticsIO[DescribeApplicationResponse] =
    FF.liftF(DescribeApplicationOp(request))

  def discoverInputSchema(
    request: DiscoverInputSchemaRequest
  ): KinesisAnalyticsIO[DiscoverInputSchemaResponse] =
    FF.liftF(DiscoverInputSchemaOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): KinesisAnalyticsIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): KinesisAnalyticsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startApplication(
    request: StartApplicationRequest
  ): KinesisAnalyticsIO[StartApplicationResponse] =
    FF.liftF(StartApplicationOp(request))

  def stopApplication(
    request: StopApplicationRequest
  ): KinesisAnalyticsIO[StopApplicationResponse] =
    FF.liftF(StopApplicationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): KinesisAnalyticsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): KinesisAnalyticsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): KinesisAnalyticsIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))
}
