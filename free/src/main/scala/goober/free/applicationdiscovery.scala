package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.applicationdiscovery.ApplicationDiscoveryClient
import software.amazon.awssdk.services.applicationdiscovery.model._


object applicationdiscovery { module =>

  // Free monad over ApplicationDiscoveryOp
  type ApplicationDiscoveryIO[A] = FF[ApplicationDiscoveryOp, A]

  sealed trait ApplicationDiscoveryOp[A] {
    def visit[F[_]](visitor: ApplicationDiscoveryOp.Visitor[F]): F[A]
  }

  object ApplicationDiscoveryOp {
    // Given a ApplicationDiscoveryClient we can embed a ApplicationDiscoveryIO program in any algebra that understands embedding.
    implicit val ApplicationDiscoveryOpEmbeddable: Embeddable[ApplicationDiscoveryOp, ApplicationDiscoveryClient] = new Embeddable[ApplicationDiscoveryOp, ApplicationDiscoveryClient] {
      def embed[A](client: ApplicationDiscoveryClient, io: ApplicationDiscoveryIO[A]): Embedded[A] = Embedded.ApplicationDiscovery(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApplicationDiscoveryOp.Visitor[Kleisli[M, ApplicationDiscoveryClient, *]] {
        def associateConfigurationItemsToApplication(
          request: AssociateConfigurationItemsToApplicationRequest
        ): Kleisli[M, ApplicationDiscoveryClient, AssociateConfigurationItemsToApplicationResponse] =
          primitive(_.associateConfigurationItemsToApplication(request))

        def batchDeleteImportData(
          request: BatchDeleteImportDataRequest
        ): Kleisli[M, ApplicationDiscoveryClient, BatchDeleteImportDataResponse] =
          primitive(_.batchDeleteImportData(request))

        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, ApplicationDiscoveryClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createTags(
          request: CreateTagsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, CreateTagsResponse] =
          primitive(_.createTags(request))

        def deleteApplications(
          request: DeleteApplicationsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DeleteApplicationsResponse] =
          primitive(_.deleteApplications(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def describeAgents(
          request: DescribeAgentsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DescribeAgentsResponse] =
          primitive(_.describeAgents(request))

        def describeConfigurations(
          request: DescribeConfigurationsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DescribeConfigurationsResponse] =
          primitive(_.describeConfigurations(request))

        def describeContinuousExports(
          request: DescribeContinuousExportsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DescribeContinuousExportsResponse] =
          primitive(_.describeContinuousExports(request))

        def describeExportTasks(
          request: DescribeExportTasksRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DescribeExportTasksResponse] =
          primitive(_.describeExportTasks(request))

        def describeImportTasks(
          request: DescribeImportTasksRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DescribeImportTasksResponse] =
          primitive(_.describeImportTasks(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def disassociateConfigurationItemsFromApplication(
          request: DisassociateConfigurationItemsFromApplicationRequest
        ): Kleisli[M, ApplicationDiscoveryClient, DisassociateConfigurationItemsFromApplicationResponse] =
          primitive(_.disassociateConfigurationItemsFromApplication(request))

        def getDiscoverySummary(
          request: GetDiscoverySummaryRequest
        ): Kleisli[M, ApplicationDiscoveryClient, GetDiscoverySummaryResponse] =
          primitive(_.getDiscoverySummary(request))

        def listConfigurations(
          request: ListConfigurationsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, ListConfigurationsResponse] =
          primitive(_.listConfigurations(request))

        def listServerNeighbors(
          request: ListServerNeighborsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, ListServerNeighborsResponse] =
          primitive(_.listServerNeighbors(request))

        def startContinuousExport(
          request: StartContinuousExportRequest
        ): Kleisli[M, ApplicationDiscoveryClient, StartContinuousExportResponse] =
          primitive(_.startContinuousExport(request))

        def startDataCollectionByAgentIds(
          request: StartDataCollectionByAgentIdsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, StartDataCollectionByAgentIdsResponse] =
          primitive(_.startDataCollectionByAgentIds(request))

        def startExportTask(
          request: StartExportTaskRequest
        ): Kleisli[M, ApplicationDiscoveryClient, StartExportTaskResponse] =
          primitive(_.startExportTask(request))

        def startImportTask(
          request: StartImportTaskRequest
        ): Kleisli[M, ApplicationDiscoveryClient, StartImportTaskResponse] =
          primitive(_.startImportTask(request))

        def stopContinuousExport(
          request: StopContinuousExportRequest
        ): Kleisli[M, ApplicationDiscoveryClient, StopContinuousExportResponse] =
          primitive(_.stopContinuousExport(request))

        def stopDataCollectionByAgentIds(
          request: StopDataCollectionByAgentIdsRequest
        ): Kleisli[M, ApplicationDiscoveryClient, StopDataCollectionByAgentIdsResponse] =
          primitive(_.stopDataCollectionByAgentIds(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, ApplicationDiscoveryClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def primitive[A](
          f: ApplicationDiscoveryClient => A
        ): Kleisli[M, ApplicationDiscoveryClient, A]
      }
    }

    trait Visitor[F[_]] extends (ApplicationDiscoveryOp ~> F) {
      final def apply[A](op: ApplicationDiscoveryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateConfigurationItemsToApplication(
        request: AssociateConfigurationItemsToApplicationRequest
      ): F[AssociateConfigurationItemsToApplicationResponse]

      def batchDeleteImportData(
        request: BatchDeleteImportDataRequest
      ): F[BatchDeleteImportDataResponse]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createTags(
        request: CreateTagsRequest
      ): F[CreateTagsResponse]

      def deleteApplications(
        request: DeleteApplicationsRequest
      ): F[DeleteApplicationsResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def describeAgents(
        request: DescribeAgentsRequest
      ): F[DescribeAgentsResponse]

      def describeConfigurations(
        request: DescribeConfigurationsRequest
      ): F[DescribeConfigurationsResponse]

      def describeContinuousExports(
        request: DescribeContinuousExportsRequest
      ): F[DescribeContinuousExportsResponse]

      def describeExportTasks(
        request: DescribeExportTasksRequest
      ): F[DescribeExportTasksResponse]

      def describeImportTasks(
        request: DescribeImportTasksRequest
      ): F[DescribeImportTasksResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def disassociateConfigurationItemsFromApplication(
        request: DisassociateConfigurationItemsFromApplicationRequest
      ): F[DisassociateConfigurationItemsFromApplicationResponse]

      def getDiscoverySummary(
        request: GetDiscoverySummaryRequest
      ): F[GetDiscoverySummaryResponse]

      def listConfigurations(
        request: ListConfigurationsRequest
      ): F[ListConfigurationsResponse]

      def listServerNeighbors(
        request: ListServerNeighborsRequest
      ): F[ListServerNeighborsResponse]

      def startContinuousExport(
        request: StartContinuousExportRequest
      ): F[StartContinuousExportResponse]

      def startDataCollectionByAgentIds(
        request: StartDataCollectionByAgentIdsRequest
      ): F[StartDataCollectionByAgentIdsResponse]

      def startExportTask(
        request: StartExportTaskRequest
      ): F[StartExportTaskResponse]

      def startImportTask(
        request: StartImportTaskRequest
      ): F[StartImportTaskResponse]

      def stopContinuousExport(
        request: StopContinuousExportRequest
      ): F[StopContinuousExportResponse]

      def stopDataCollectionByAgentIds(
        request: StopDataCollectionByAgentIdsRequest
      ): F[StopDataCollectionByAgentIdsResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApplicationDiscoveryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateConfigurationItemsToApplicationOp(
      request: AssociateConfigurationItemsToApplicationRequest
    ) extends ApplicationDiscoveryOp[AssociateConfigurationItemsToApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateConfigurationItemsToApplicationResponse] =
        visitor.associateConfigurationItemsToApplication(request)
    }

    final case class BatchDeleteImportDataOp(
      request: BatchDeleteImportDataRequest
    ) extends ApplicationDiscoveryOp[BatchDeleteImportDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteImportDataResponse] =
        visitor.batchDeleteImportData(request)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends ApplicationDiscoveryOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateTagsOp(
      request: CreateTagsRequest
    ) extends ApplicationDiscoveryOp[CreateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagsResponse] =
        visitor.createTags(request)
    }

    final case class DeleteApplicationsOp(
      request: DeleteApplicationsRequest
    ) extends ApplicationDiscoveryOp[DeleteApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationsResponse] =
        visitor.deleteApplications(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends ApplicationDiscoveryOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DescribeAgentsOp(
      request: DescribeAgentsRequest
    ) extends ApplicationDiscoveryOp[DescribeAgentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAgentsResponse] =
        visitor.describeAgents(request)
    }

    final case class DescribeConfigurationsOp(
      request: DescribeConfigurationsRequest
    ) extends ApplicationDiscoveryOp[DescribeConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConfigurationsResponse] =
        visitor.describeConfigurations(request)
    }

    final case class DescribeContinuousExportsOp(
      request: DescribeContinuousExportsRequest
    ) extends ApplicationDiscoveryOp[DescribeContinuousExportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContinuousExportsResponse] =
        visitor.describeContinuousExports(request)
    }

    final case class DescribeExportTasksOp(
      request: DescribeExportTasksRequest
    ) extends ApplicationDiscoveryOp[DescribeExportTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExportTasksResponse] =
        visitor.describeExportTasks(request)
    }

    final case class DescribeImportTasksOp(
      request: DescribeImportTasksRequest
    ) extends ApplicationDiscoveryOp[DescribeImportTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeImportTasksResponse] =
        visitor.describeImportTasks(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends ApplicationDiscoveryOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DisassociateConfigurationItemsFromApplicationOp(
      request: DisassociateConfigurationItemsFromApplicationRequest
    ) extends ApplicationDiscoveryOp[DisassociateConfigurationItemsFromApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateConfigurationItemsFromApplicationResponse] =
        visitor.disassociateConfigurationItemsFromApplication(request)
    }

    final case class GetDiscoverySummaryOp(
      request: GetDiscoverySummaryRequest
    ) extends ApplicationDiscoveryOp[GetDiscoverySummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDiscoverySummaryResponse] =
        visitor.getDiscoverySummary(request)
    }

    final case class ListConfigurationsOp(
      request: ListConfigurationsRequest
    ) extends ApplicationDiscoveryOp[ListConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationsResponse] =
        visitor.listConfigurations(request)
    }

    final case class ListServerNeighborsOp(
      request: ListServerNeighborsRequest
    ) extends ApplicationDiscoveryOp[ListServerNeighborsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServerNeighborsResponse] =
        visitor.listServerNeighbors(request)
    }

    final case class StartContinuousExportOp(
      request: StartContinuousExportRequest
    ) extends ApplicationDiscoveryOp[StartContinuousExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartContinuousExportResponse] =
        visitor.startContinuousExport(request)
    }

    final case class StartDataCollectionByAgentIdsOp(
      request: StartDataCollectionByAgentIdsRequest
    ) extends ApplicationDiscoveryOp[StartDataCollectionByAgentIdsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDataCollectionByAgentIdsResponse] =
        visitor.startDataCollectionByAgentIds(request)
    }

    final case class StartExportTaskOp(
      request: StartExportTaskRequest
    ) extends ApplicationDiscoveryOp[StartExportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartExportTaskResponse] =
        visitor.startExportTask(request)
    }

    final case class StartImportTaskOp(
      request: StartImportTaskRequest
    ) extends ApplicationDiscoveryOp[StartImportTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartImportTaskResponse] =
        visitor.startImportTask(request)
    }

    final case class StopContinuousExportOp(
      request: StopContinuousExportRequest
    ) extends ApplicationDiscoveryOp[StopContinuousExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopContinuousExportResponse] =
        visitor.stopContinuousExport(request)
    }

    final case class StopDataCollectionByAgentIdsOp(
      request: StopDataCollectionByAgentIdsRequest
    ) extends ApplicationDiscoveryOp[StopDataCollectionByAgentIdsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDataCollectionByAgentIdsResponse] =
        visitor.stopDataCollectionByAgentIds(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends ApplicationDiscoveryOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }
  }

  import ApplicationDiscoveryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApplicationDiscoveryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateConfigurationItemsToApplication(
    request: AssociateConfigurationItemsToApplicationRequest
  ): ApplicationDiscoveryIO[AssociateConfigurationItemsToApplicationResponse] =
    FF.liftF(AssociateConfigurationItemsToApplicationOp(request))

  def batchDeleteImportData(
    request: BatchDeleteImportDataRequest
  ): ApplicationDiscoveryIO[BatchDeleteImportDataResponse] =
    FF.liftF(BatchDeleteImportDataOp(request))

  def createApplication(
    request: CreateApplicationRequest
  ): ApplicationDiscoveryIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createTags(
    request: CreateTagsRequest
  ): ApplicationDiscoveryIO[CreateTagsResponse] =
    FF.liftF(CreateTagsOp(request))

  def deleteApplications(
    request: DeleteApplicationsRequest
  ): ApplicationDiscoveryIO[DeleteApplicationsResponse] =
    FF.liftF(DeleteApplicationsOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): ApplicationDiscoveryIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def describeAgents(
    request: DescribeAgentsRequest
  ): ApplicationDiscoveryIO[DescribeAgentsResponse] =
    FF.liftF(DescribeAgentsOp(request))

  def describeConfigurations(
    request: DescribeConfigurationsRequest
  ): ApplicationDiscoveryIO[DescribeConfigurationsResponse] =
    FF.liftF(DescribeConfigurationsOp(request))

  def describeContinuousExports(
    request: DescribeContinuousExportsRequest
  ): ApplicationDiscoveryIO[DescribeContinuousExportsResponse] =
    FF.liftF(DescribeContinuousExportsOp(request))

  def describeExportTasks(
    request: DescribeExportTasksRequest
  ): ApplicationDiscoveryIO[DescribeExportTasksResponse] =
    FF.liftF(DescribeExportTasksOp(request))

  def describeImportTasks(
    request: DescribeImportTasksRequest
  ): ApplicationDiscoveryIO[DescribeImportTasksResponse] =
    FF.liftF(DescribeImportTasksOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): ApplicationDiscoveryIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def disassociateConfigurationItemsFromApplication(
    request: DisassociateConfigurationItemsFromApplicationRequest
  ): ApplicationDiscoveryIO[DisassociateConfigurationItemsFromApplicationResponse] =
    FF.liftF(DisassociateConfigurationItemsFromApplicationOp(request))

  def getDiscoverySummary(
    request: GetDiscoverySummaryRequest
  ): ApplicationDiscoveryIO[GetDiscoverySummaryResponse] =
    FF.liftF(GetDiscoverySummaryOp(request))

  def listConfigurations(
    request: ListConfigurationsRequest
  ): ApplicationDiscoveryIO[ListConfigurationsResponse] =
    FF.liftF(ListConfigurationsOp(request))

  def listServerNeighbors(
    request: ListServerNeighborsRequest
  ): ApplicationDiscoveryIO[ListServerNeighborsResponse] =
    FF.liftF(ListServerNeighborsOp(request))

  def startContinuousExport(
    request: StartContinuousExportRequest
  ): ApplicationDiscoveryIO[StartContinuousExportResponse] =
    FF.liftF(StartContinuousExportOp(request))

  def startDataCollectionByAgentIds(
    request: StartDataCollectionByAgentIdsRequest
  ): ApplicationDiscoveryIO[StartDataCollectionByAgentIdsResponse] =
    FF.liftF(StartDataCollectionByAgentIdsOp(request))

  def startExportTask(
    request: StartExportTaskRequest
  ): ApplicationDiscoveryIO[StartExportTaskResponse] =
    FF.liftF(StartExportTaskOp(request))

  def startImportTask(
    request: StartImportTaskRequest
  ): ApplicationDiscoveryIO[StartImportTaskResponse] =
    FF.liftF(StartImportTaskOp(request))

  def stopContinuousExport(
    request: StopContinuousExportRequest
  ): ApplicationDiscoveryIO[StopContinuousExportResponse] =
    FF.liftF(StopContinuousExportOp(request))

  def stopDataCollectionByAgentIds(
    request: StopDataCollectionByAgentIdsRequest
  ): ApplicationDiscoveryIO[StopDataCollectionByAgentIdsResponse] =
    FF.liftF(StopDataCollectionByAgentIdsOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): ApplicationDiscoveryIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))
}
