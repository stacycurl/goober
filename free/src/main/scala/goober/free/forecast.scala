package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.forecast.ForecastClient
import software.amazon.awssdk.services.forecast.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object forecast { module =>

  // Free monad over ForecastOp
  type ForecastIO[A] = FF[ForecastOp, A]

  sealed trait ForecastOp[A] {
    def visit[F[_]](visitor: ForecastOp.Visitor[F]): F[A]
  }

  object ForecastOp {
    // Given a ForecastClient we can embed a ForecastIO program in any algebra that understands embedding.
    implicit val ForecastOpEmbeddable: Embeddable[ForecastOp, ForecastClient] = new Embeddable[ForecastOp, ForecastClient] {
      def embed[A](client: ForecastClient, io: ForecastIO[A]): Embedded[A] = Embedded.Forecast(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ForecastOp.Visitor[Kleisli[M, ForecastClient, *]] {
        def createDataset(
          request: CreateDatasetRequest
        ): Kleisli[M, ForecastClient, CreateDatasetResponse] =
          primitive(_.createDataset(request))

        def createDatasetGroup(
          request: CreateDatasetGroupRequest
        ): Kleisli[M, ForecastClient, CreateDatasetGroupResponse] =
          primitive(_.createDatasetGroup(request))

        def createDatasetImportJob(
          request: CreateDatasetImportJobRequest
        ): Kleisli[M, ForecastClient, CreateDatasetImportJobResponse] =
          primitive(_.createDatasetImportJob(request))

        def createForecast(
          request: CreateForecastRequest
        ): Kleisli[M, ForecastClient, CreateForecastResponse] =
          primitive(_.createForecast(request))

        def createForecastExportJob(
          request: CreateForecastExportJobRequest
        ): Kleisli[M, ForecastClient, CreateForecastExportJobResponse] =
          primitive(_.createForecastExportJob(request))

        def createPredictor(
          request: CreatePredictorRequest
        ): Kleisli[M, ForecastClient, CreatePredictorResponse] =
          primitive(_.createPredictor(request))

        def createPredictorBacktestExportJob(
          request: CreatePredictorBacktestExportJobRequest
        ): Kleisli[M, ForecastClient, CreatePredictorBacktestExportJobResponse] =
          primitive(_.createPredictorBacktestExportJob(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, ForecastClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def deleteDatasetGroup(
          request: DeleteDatasetGroupRequest
        ): Kleisli[M, ForecastClient, DeleteDatasetGroupResponse] =
          primitive(_.deleteDatasetGroup(request))

        def deleteDatasetImportJob(
          request: DeleteDatasetImportJobRequest
        ): Kleisli[M, ForecastClient, DeleteDatasetImportJobResponse] =
          primitive(_.deleteDatasetImportJob(request))

        def deleteForecast(
          request: DeleteForecastRequest
        ): Kleisli[M, ForecastClient, DeleteForecastResponse] =
          primitive(_.deleteForecast(request))

        def deleteForecastExportJob(
          request: DeleteForecastExportJobRequest
        ): Kleisli[M, ForecastClient, DeleteForecastExportJobResponse] =
          primitive(_.deleteForecastExportJob(request))

        def deletePredictor(
          request: DeletePredictorRequest
        ): Kleisli[M, ForecastClient, DeletePredictorResponse] =
          primitive(_.deletePredictor(request))

        def deletePredictorBacktestExportJob(
          request: DeletePredictorBacktestExportJobRequest
        ): Kleisli[M, ForecastClient, DeletePredictorBacktestExportJobResponse] =
          primitive(_.deletePredictorBacktestExportJob(request))

        def deleteResourceTree(
          request: DeleteResourceTreeRequest
        ): Kleisli[M, ForecastClient, DeleteResourceTreeResponse] =
          primitive(_.deleteResourceTree(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, ForecastClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeDatasetGroup(
          request: DescribeDatasetGroupRequest
        ): Kleisli[M, ForecastClient, DescribeDatasetGroupResponse] =
          primitive(_.describeDatasetGroup(request))

        def describeDatasetImportJob(
          request: DescribeDatasetImportJobRequest
        ): Kleisli[M, ForecastClient, DescribeDatasetImportJobResponse] =
          primitive(_.describeDatasetImportJob(request))

        def describeForecast(
          request: DescribeForecastRequest
        ): Kleisli[M, ForecastClient, DescribeForecastResponse] =
          primitive(_.describeForecast(request))

        def describeForecastExportJob(
          request: DescribeForecastExportJobRequest
        ): Kleisli[M, ForecastClient, DescribeForecastExportJobResponse] =
          primitive(_.describeForecastExportJob(request))

        def describePredictor(
          request: DescribePredictorRequest
        ): Kleisli[M, ForecastClient, DescribePredictorResponse] =
          primitive(_.describePredictor(request))

        def describePredictorBacktestExportJob(
          request: DescribePredictorBacktestExportJobRequest
        ): Kleisli[M, ForecastClient, DescribePredictorBacktestExportJobResponse] =
          primitive(_.describePredictorBacktestExportJob(request))

        def getAccuracyMetrics(
          request: GetAccuracyMetricsRequest
        ): Kleisli[M, ForecastClient, GetAccuracyMetricsResponse] =
          primitive(_.getAccuracyMetrics(request))

        def listDatasetGroups(
          request: ListDatasetGroupsRequest
        ): Kleisli[M, ForecastClient, ListDatasetGroupsResponse] =
          primitive(_.listDatasetGroups(request))

        def listDatasetImportJobs(
          request: ListDatasetImportJobsRequest
        ): Kleisli[M, ForecastClient, ListDatasetImportJobsResponse] =
          primitive(_.listDatasetImportJobs(request))

        def listDatasets(
          request: ListDatasetsRequest
        ): Kleisli[M, ForecastClient, ListDatasetsResponse] =
          primitive(_.listDatasets(request))

        def listForecastExportJobs(
          request: ListForecastExportJobsRequest
        ): Kleisli[M, ForecastClient, ListForecastExportJobsResponse] =
          primitive(_.listForecastExportJobs(request))

        def listForecasts(
          request: ListForecastsRequest
        ): Kleisli[M, ForecastClient, ListForecastsResponse] =
          primitive(_.listForecasts(request))

        def listPredictorBacktestExportJobs(
          request: ListPredictorBacktestExportJobsRequest
        ): Kleisli[M, ForecastClient, ListPredictorBacktestExportJobsResponse] =
          primitive(_.listPredictorBacktestExportJobs(request))

        def listPredictors(
          request: ListPredictorsRequest
        ): Kleisli[M, ForecastClient, ListPredictorsResponse] =
          primitive(_.listPredictors(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ForecastClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def stopResource(
          request: StopResourceRequest
        ): Kleisli[M, ForecastClient, StopResourceResponse] =
          primitive(_.stopResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ForecastClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ForecastClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDatasetGroup(
          request: UpdateDatasetGroupRequest
        ): Kleisli[M, ForecastClient, UpdateDatasetGroupResponse] =
          primitive(_.updateDatasetGroup(request))

        def primitive[A](
          f: ForecastClient => A
        ): Kleisli[M, ForecastClient, A]
      }
    }

    trait Visitor[F[_]] extends (ForecastOp ~> F) {
      final def apply[A](op: ForecastOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDataset(
        request: CreateDatasetRequest
      ): F[CreateDatasetResponse]

      def createDatasetGroup(
        request: CreateDatasetGroupRequest
      ): F[CreateDatasetGroupResponse]

      def createDatasetImportJob(
        request: CreateDatasetImportJobRequest
      ): F[CreateDatasetImportJobResponse]

      def createForecast(
        request: CreateForecastRequest
      ): F[CreateForecastResponse]

      def createForecastExportJob(
        request: CreateForecastExportJobRequest
      ): F[CreateForecastExportJobResponse]

      def createPredictor(
        request: CreatePredictorRequest
      ): F[CreatePredictorResponse]

      def createPredictorBacktestExportJob(
        request: CreatePredictorBacktestExportJobRequest
      ): F[CreatePredictorBacktestExportJobResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def deleteDatasetGroup(
        request: DeleteDatasetGroupRequest
      ): F[DeleteDatasetGroupResponse]

      def deleteDatasetImportJob(
        request: DeleteDatasetImportJobRequest
      ): F[DeleteDatasetImportJobResponse]

      def deleteForecast(
        request: DeleteForecastRequest
      ): F[DeleteForecastResponse]

      def deleteForecastExportJob(
        request: DeleteForecastExportJobRequest
      ): F[DeleteForecastExportJobResponse]

      def deletePredictor(
        request: DeletePredictorRequest
      ): F[DeletePredictorResponse]

      def deletePredictorBacktestExportJob(
        request: DeletePredictorBacktestExportJobRequest
      ): F[DeletePredictorBacktestExportJobResponse]

      def deleteResourceTree(
        request: DeleteResourceTreeRequest
      ): F[DeleteResourceTreeResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeDatasetGroup(
        request: DescribeDatasetGroupRequest
      ): F[DescribeDatasetGroupResponse]

      def describeDatasetImportJob(
        request: DescribeDatasetImportJobRequest
      ): F[DescribeDatasetImportJobResponse]

      def describeForecast(
        request: DescribeForecastRequest
      ): F[DescribeForecastResponse]

      def describeForecastExportJob(
        request: DescribeForecastExportJobRequest
      ): F[DescribeForecastExportJobResponse]

      def describePredictor(
        request: DescribePredictorRequest
      ): F[DescribePredictorResponse]

      def describePredictorBacktestExportJob(
        request: DescribePredictorBacktestExportJobRequest
      ): F[DescribePredictorBacktestExportJobResponse]

      def getAccuracyMetrics(
        request: GetAccuracyMetricsRequest
      ): F[GetAccuracyMetricsResponse]

      def listDatasetGroups(
        request: ListDatasetGroupsRequest
      ): F[ListDatasetGroupsResponse]

      def listDatasetImportJobs(
        request: ListDatasetImportJobsRequest
      ): F[ListDatasetImportJobsResponse]

      def listDatasets(
        request: ListDatasetsRequest
      ): F[ListDatasetsResponse]

      def listForecastExportJobs(
        request: ListForecastExportJobsRequest
      ): F[ListForecastExportJobsResponse]

      def listForecasts(
        request: ListForecastsRequest
      ): F[ListForecastsResponse]

      def listPredictorBacktestExportJobs(
        request: ListPredictorBacktestExportJobsRequest
      ): F[ListPredictorBacktestExportJobsResponse]

      def listPredictors(
        request: ListPredictorsRequest
      ): F[ListPredictorsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def stopResource(
        request: StopResourceRequest
      ): F[StopResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDatasetGroup(
        request: UpdateDatasetGroupRequest
      ): F[UpdateDatasetGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ForecastOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDatasetOp(
      request: CreateDatasetRequest
    ) extends ForecastOp[CreateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetResponse] =
        visitor.createDataset(request)
    }

    final case class CreateDatasetGroupOp(
      request: CreateDatasetGroupRequest
    ) extends ForecastOp[CreateDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetGroupResponse] =
        visitor.createDatasetGroup(request)
    }

    final case class CreateDatasetImportJobOp(
      request: CreateDatasetImportJobRequest
    ) extends ForecastOp[CreateDatasetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetImportJobResponse] =
        visitor.createDatasetImportJob(request)
    }

    final case class CreateForecastOp(
      request: CreateForecastRequest
    ) extends ForecastOp[CreateForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateForecastResponse] =
        visitor.createForecast(request)
    }

    final case class CreateForecastExportJobOp(
      request: CreateForecastExportJobRequest
    ) extends ForecastOp[CreateForecastExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateForecastExportJobResponse] =
        visitor.createForecastExportJob(request)
    }

    final case class CreatePredictorOp(
      request: CreatePredictorRequest
    ) extends ForecastOp[CreatePredictorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePredictorResponse] =
        visitor.createPredictor(request)
    }

    final case class CreatePredictorBacktestExportJobOp(
      request: CreatePredictorBacktestExportJobRequest
    ) extends ForecastOp[CreatePredictorBacktestExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePredictorBacktestExportJobResponse] =
        visitor.createPredictorBacktestExportJob(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends ForecastOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DeleteDatasetGroupOp(
      request: DeleteDatasetGroupRequest
    ) extends ForecastOp[DeleteDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetGroupResponse] =
        visitor.deleteDatasetGroup(request)
    }

    final case class DeleteDatasetImportJobOp(
      request: DeleteDatasetImportJobRequest
    ) extends ForecastOp[DeleteDatasetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetImportJobResponse] =
        visitor.deleteDatasetImportJob(request)
    }

    final case class DeleteForecastOp(
      request: DeleteForecastRequest
    ) extends ForecastOp[DeleteForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteForecastResponse] =
        visitor.deleteForecast(request)
    }

    final case class DeleteForecastExportJobOp(
      request: DeleteForecastExportJobRequest
    ) extends ForecastOp[DeleteForecastExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteForecastExportJobResponse] =
        visitor.deleteForecastExportJob(request)
    }

    final case class DeletePredictorOp(
      request: DeletePredictorRequest
    ) extends ForecastOp[DeletePredictorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePredictorResponse] =
        visitor.deletePredictor(request)
    }

    final case class DeletePredictorBacktestExportJobOp(
      request: DeletePredictorBacktestExportJobRequest
    ) extends ForecastOp[DeletePredictorBacktestExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePredictorBacktestExportJobResponse] =
        visitor.deletePredictorBacktestExportJob(request)
    }

    final case class DeleteResourceTreeOp(
      request: DeleteResourceTreeRequest
    ) extends ForecastOp[DeleteResourceTreeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceTreeResponse] =
        visitor.deleteResourceTree(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends ForecastOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeDatasetGroupOp(
      request: DescribeDatasetGroupRequest
    ) extends ForecastOp[DescribeDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetGroupResponse] =
        visitor.describeDatasetGroup(request)
    }

    final case class DescribeDatasetImportJobOp(
      request: DescribeDatasetImportJobRequest
    ) extends ForecastOp[DescribeDatasetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetImportJobResponse] =
        visitor.describeDatasetImportJob(request)
    }

    final case class DescribeForecastOp(
      request: DescribeForecastRequest
    ) extends ForecastOp[DescribeForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeForecastResponse] =
        visitor.describeForecast(request)
    }

    final case class DescribeForecastExportJobOp(
      request: DescribeForecastExportJobRequest
    ) extends ForecastOp[DescribeForecastExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeForecastExportJobResponse] =
        visitor.describeForecastExportJob(request)
    }

    final case class DescribePredictorOp(
      request: DescribePredictorRequest
    ) extends ForecastOp[DescribePredictorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePredictorResponse] =
        visitor.describePredictor(request)
    }

    final case class DescribePredictorBacktestExportJobOp(
      request: DescribePredictorBacktestExportJobRequest
    ) extends ForecastOp[DescribePredictorBacktestExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePredictorBacktestExportJobResponse] =
        visitor.describePredictorBacktestExportJob(request)
    }

    final case class GetAccuracyMetricsOp(
      request: GetAccuracyMetricsRequest
    ) extends ForecastOp[GetAccuracyMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccuracyMetricsResponse] =
        visitor.getAccuracyMetrics(request)
    }

    final case class ListDatasetGroupsOp(
      request: ListDatasetGroupsRequest
    ) extends ForecastOp[ListDatasetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetGroupsResponse] =
        visitor.listDatasetGroups(request)
    }

    final case class ListDatasetImportJobsOp(
      request: ListDatasetImportJobsRequest
    ) extends ForecastOp[ListDatasetImportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetImportJobsResponse] =
        visitor.listDatasetImportJobs(request)
    }

    final case class ListDatasetsOp(
      request: ListDatasetsRequest
    ) extends ForecastOp[ListDatasetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetsResponse] =
        visitor.listDatasets(request)
    }

    final case class ListForecastExportJobsOp(
      request: ListForecastExportJobsRequest
    ) extends ForecastOp[ListForecastExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListForecastExportJobsResponse] =
        visitor.listForecastExportJobs(request)
    }

    final case class ListForecastsOp(
      request: ListForecastsRequest
    ) extends ForecastOp[ListForecastsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListForecastsResponse] =
        visitor.listForecasts(request)
    }

    final case class ListPredictorBacktestExportJobsOp(
      request: ListPredictorBacktestExportJobsRequest
    ) extends ForecastOp[ListPredictorBacktestExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPredictorBacktestExportJobsResponse] =
        visitor.listPredictorBacktestExportJobs(request)
    }

    final case class ListPredictorsOp(
      request: ListPredictorsRequest
    ) extends ForecastOp[ListPredictorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPredictorsResponse] =
        visitor.listPredictors(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ForecastOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StopResourceOp(
      request: StopResourceRequest
    ) extends ForecastOp[StopResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopResourceResponse] =
        visitor.stopResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ForecastOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ForecastOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDatasetGroupOp(
      request: UpdateDatasetGroupRequest
    ) extends ForecastOp[UpdateDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatasetGroupResponse] =
        visitor.updateDatasetGroup(request)
    }
  }

  import ForecastOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ForecastOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDataset(
    request: CreateDatasetRequest
  ): ForecastIO[CreateDatasetResponse] =
    FF.liftF(CreateDatasetOp(request))

  def createDatasetGroup(
    request: CreateDatasetGroupRequest
  ): ForecastIO[CreateDatasetGroupResponse] =
    FF.liftF(CreateDatasetGroupOp(request))

  def createDatasetImportJob(
    request: CreateDatasetImportJobRequest
  ): ForecastIO[CreateDatasetImportJobResponse] =
    FF.liftF(CreateDatasetImportJobOp(request))

  def createForecast(
    request: CreateForecastRequest
  ): ForecastIO[CreateForecastResponse] =
    FF.liftF(CreateForecastOp(request))

  def createForecastExportJob(
    request: CreateForecastExportJobRequest
  ): ForecastIO[CreateForecastExportJobResponse] =
    FF.liftF(CreateForecastExportJobOp(request))

  def createPredictor(
    request: CreatePredictorRequest
  ): ForecastIO[CreatePredictorResponse] =
    FF.liftF(CreatePredictorOp(request))

  def createPredictorBacktestExportJob(
    request: CreatePredictorBacktestExportJobRequest
  ): ForecastIO[CreatePredictorBacktestExportJobResponse] =
    FF.liftF(CreatePredictorBacktestExportJobOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): ForecastIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def deleteDatasetGroup(
    request: DeleteDatasetGroupRequest
  ): ForecastIO[DeleteDatasetGroupResponse] =
    FF.liftF(DeleteDatasetGroupOp(request))

  def deleteDatasetImportJob(
    request: DeleteDatasetImportJobRequest
  ): ForecastIO[DeleteDatasetImportJobResponse] =
    FF.liftF(DeleteDatasetImportJobOp(request))

  def deleteForecast(
    request: DeleteForecastRequest
  ): ForecastIO[DeleteForecastResponse] =
    FF.liftF(DeleteForecastOp(request))

  def deleteForecastExportJob(
    request: DeleteForecastExportJobRequest
  ): ForecastIO[DeleteForecastExportJobResponse] =
    FF.liftF(DeleteForecastExportJobOp(request))

  def deletePredictor(
    request: DeletePredictorRequest
  ): ForecastIO[DeletePredictorResponse] =
    FF.liftF(DeletePredictorOp(request))

  def deletePredictorBacktestExportJob(
    request: DeletePredictorBacktestExportJobRequest
  ): ForecastIO[DeletePredictorBacktestExportJobResponse] =
    FF.liftF(DeletePredictorBacktestExportJobOp(request))

  def deleteResourceTree(
    request: DeleteResourceTreeRequest
  ): ForecastIO[DeleteResourceTreeResponse] =
    FF.liftF(DeleteResourceTreeOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): ForecastIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeDatasetGroup(
    request: DescribeDatasetGroupRequest
  ): ForecastIO[DescribeDatasetGroupResponse] =
    FF.liftF(DescribeDatasetGroupOp(request))

  def describeDatasetImportJob(
    request: DescribeDatasetImportJobRequest
  ): ForecastIO[DescribeDatasetImportJobResponse] =
    FF.liftF(DescribeDatasetImportJobOp(request))

  def describeForecast(
    request: DescribeForecastRequest
  ): ForecastIO[DescribeForecastResponse] =
    FF.liftF(DescribeForecastOp(request))

  def describeForecastExportJob(
    request: DescribeForecastExportJobRequest
  ): ForecastIO[DescribeForecastExportJobResponse] =
    FF.liftF(DescribeForecastExportJobOp(request))

  def describePredictor(
    request: DescribePredictorRequest
  ): ForecastIO[DescribePredictorResponse] =
    FF.liftF(DescribePredictorOp(request))

  def describePredictorBacktestExportJob(
    request: DescribePredictorBacktestExportJobRequest
  ): ForecastIO[DescribePredictorBacktestExportJobResponse] =
    FF.liftF(DescribePredictorBacktestExportJobOp(request))

  def getAccuracyMetrics(
    request: GetAccuracyMetricsRequest
  ): ForecastIO[GetAccuracyMetricsResponse] =
    FF.liftF(GetAccuracyMetricsOp(request))

  def listDatasetGroups(
    request: ListDatasetGroupsRequest
  ): ForecastIO[ListDatasetGroupsResponse] =
    FF.liftF(ListDatasetGroupsOp(request))

  def listDatasetImportJobs(
    request: ListDatasetImportJobsRequest
  ): ForecastIO[ListDatasetImportJobsResponse] =
    FF.liftF(ListDatasetImportJobsOp(request))

  def listDatasets(
    request: ListDatasetsRequest
  ): ForecastIO[ListDatasetsResponse] =
    FF.liftF(ListDatasetsOp(request))

  def listForecastExportJobs(
    request: ListForecastExportJobsRequest
  ): ForecastIO[ListForecastExportJobsResponse] =
    FF.liftF(ListForecastExportJobsOp(request))

  def listForecasts(
    request: ListForecastsRequest
  ): ForecastIO[ListForecastsResponse] =
    FF.liftF(ListForecastsOp(request))

  def listPredictorBacktestExportJobs(
    request: ListPredictorBacktestExportJobsRequest
  ): ForecastIO[ListPredictorBacktestExportJobsResponse] =
    FF.liftF(ListPredictorBacktestExportJobsOp(request))

  def listPredictors(
    request: ListPredictorsRequest
  ): ForecastIO[ListPredictorsResponse] =
    FF.liftF(ListPredictorsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ForecastIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def stopResource(
    request: StopResourceRequest
  ): ForecastIO[StopResourceResponse] =
    FF.liftF(StopResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ForecastIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ForecastIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDatasetGroup(
    request: UpdateDatasetGroupRequest
  ): ForecastIO[UpdateDatasetGroupResponse] =
    FF.liftF(UpdateDatasetGroupOp(request))
}
