package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotanalytics.IoTAnalyticsClient
import software.amazon.awssdk.services.iotanalytics.model._


object iotanalytics { module =>

  // Free monad over IoTAnalyticsOp
  type IoTAnalyticsIO[A] = FF[IoTAnalyticsOp, A]

  sealed trait IoTAnalyticsOp[A] {
    def visit[F[_]](visitor: IoTAnalyticsOp.Visitor[F]): F[A]
  }

  object IoTAnalyticsOp {
    // Given a IoTAnalyticsClient we can embed a IoTAnalyticsIO program in any algebra that understands embedding.
    implicit val IoTAnalyticsOpEmbeddable: Embeddable[IoTAnalyticsOp, IoTAnalyticsClient] = new Embeddable[IoTAnalyticsOp, IoTAnalyticsClient] {
      def embed[A](client: IoTAnalyticsClient, io: IoTAnalyticsIO[A]): Embedded[A] = Embedded.IoTAnalytics(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IoTAnalyticsOp.Visitor[Kleisli[M, IoTAnalyticsClient, *]] {
        def batchPutMessage(
          request: BatchPutMessageRequest
        ): Kleisli[M, IoTAnalyticsClient, BatchPutMessageResponse] =
          primitive(_.batchPutMessage(request))

        def cancelPipelineReprocessing(
          request: CancelPipelineReprocessingRequest
        ): Kleisli[M, IoTAnalyticsClient, CancelPipelineReprocessingResponse] =
          primitive(_.cancelPipelineReprocessing(request))

        def createChannel(
          request: CreateChannelRequest
        ): Kleisli[M, IoTAnalyticsClient, CreateChannelResponse] =
          primitive(_.createChannel(request))

        def createDataset(
          request: CreateDatasetRequest
        ): Kleisli[M, IoTAnalyticsClient, CreateDatasetResponse] =
          primitive(_.createDataset(request))

        def createDatasetContent(
          request: CreateDatasetContentRequest
        ): Kleisli[M, IoTAnalyticsClient, CreateDatasetContentResponse] =
          primitive(_.createDatasetContent(request))

        def createDatastore(
          request: CreateDatastoreRequest
        ): Kleisli[M, IoTAnalyticsClient, CreateDatastoreResponse] =
          primitive(_.createDatastore(request))

        def createPipeline(
          request: CreatePipelineRequest
        ): Kleisli[M, IoTAnalyticsClient, CreatePipelineResponse] =
          primitive(_.createPipeline(request))

        def deleteChannel(
          request: DeleteChannelRequest
        ): Kleisli[M, IoTAnalyticsClient, DeleteChannelResponse] =
          primitive(_.deleteChannel(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, IoTAnalyticsClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def deleteDatasetContent(
          request: DeleteDatasetContentRequest
        ): Kleisli[M, IoTAnalyticsClient, DeleteDatasetContentResponse] =
          primitive(_.deleteDatasetContent(request))

        def deleteDatastore(
          request: DeleteDatastoreRequest
        ): Kleisli[M, IoTAnalyticsClient, DeleteDatastoreResponse] =
          primitive(_.deleteDatastore(request))

        def deletePipeline(
          request: DeletePipelineRequest
        ): Kleisli[M, IoTAnalyticsClient, DeletePipelineResponse] =
          primitive(_.deletePipeline(request))

        def describeChannel(
          request: DescribeChannelRequest
        ): Kleisli[M, IoTAnalyticsClient, DescribeChannelResponse] =
          primitive(_.describeChannel(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, IoTAnalyticsClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeDatastore(
          request: DescribeDatastoreRequest
        ): Kleisli[M, IoTAnalyticsClient, DescribeDatastoreResponse] =
          primitive(_.describeDatastore(request))

        def describeLoggingOptions(
          request: DescribeLoggingOptionsRequest
        ): Kleisli[M, IoTAnalyticsClient, DescribeLoggingOptionsResponse] =
          primitive(_.describeLoggingOptions(request))

        def describePipeline(
          request: DescribePipelineRequest
        ): Kleisli[M, IoTAnalyticsClient, DescribePipelineResponse] =
          primitive(_.describePipeline(request))

        def getDatasetContent(
          request: GetDatasetContentRequest
        ): Kleisli[M, IoTAnalyticsClient, GetDatasetContentResponse] =
          primitive(_.getDatasetContent(request))

        def listChannels(
          request: ListChannelsRequest
        ): Kleisli[M, IoTAnalyticsClient, ListChannelsResponse] =
          primitive(_.listChannels(request))

        def listDatasetContents(
          request: ListDatasetContentsRequest
        ): Kleisli[M, IoTAnalyticsClient, ListDatasetContentsResponse] =
          primitive(_.listDatasetContents(request))

        def listDatasets(
          request: ListDatasetsRequest
        ): Kleisli[M, IoTAnalyticsClient, ListDatasetsResponse] =
          primitive(_.listDatasets(request))

        def listDatastores(
          request: ListDatastoresRequest
        ): Kleisli[M, IoTAnalyticsClient, ListDatastoresResponse] =
          primitive(_.listDatastores(request))

        def listPipelines(
          request: ListPipelinesRequest
        ): Kleisli[M, IoTAnalyticsClient, ListPipelinesResponse] =
          primitive(_.listPipelines(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IoTAnalyticsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putLoggingOptions(
          request: PutLoggingOptionsRequest
        ): Kleisli[M, IoTAnalyticsClient, PutLoggingOptionsResponse] =
          primitive(_.putLoggingOptions(request))

        def runPipelineActivity(
          request: RunPipelineActivityRequest
        ): Kleisli[M, IoTAnalyticsClient, RunPipelineActivityResponse] =
          primitive(_.runPipelineActivity(request))

        def sampleChannelData(
          request: SampleChannelDataRequest
        ): Kleisli[M, IoTAnalyticsClient, SampleChannelDataResponse] =
          primitive(_.sampleChannelData(request))

        def startPipelineReprocessing(
          request: StartPipelineReprocessingRequest
        ): Kleisli[M, IoTAnalyticsClient, StartPipelineReprocessingResponse] =
          primitive(_.startPipelineReprocessing(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IoTAnalyticsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IoTAnalyticsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateChannel(
          request: UpdateChannelRequest
        ): Kleisli[M, IoTAnalyticsClient, UpdateChannelResponse] =
          primitive(_.updateChannel(request))

        def updateDataset(
          request: UpdateDatasetRequest
        ): Kleisli[M, IoTAnalyticsClient, UpdateDatasetResponse] =
          primitive(_.updateDataset(request))

        def updateDatastore(
          request: UpdateDatastoreRequest
        ): Kleisli[M, IoTAnalyticsClient, UpdateDatastoreResponse] =
          primitive(_.updateDatastore(request))

        def updatePipeline(
          request: UpdatePipelineRequest
        ): Kleisli[M, IoTAnalyticsClient, UpdatePipelineResponse] =
          primitive(_.updatePipeline(request))

        def primitive[A](
          f: IoTAnalyticsClient => A
        ): Kleisli[M, IoTAnalyticsClient, A]
      }
    }

    trait Visitor[F[_]] extends (IoTAnalyticsOp ~> F) {
      final def apply[A](op: IoTAnalyticsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchPutMessage(
        request: BatchPutMessageRequest
      ): F[BatchPutMessageResponse]

      def cancelPipelineReprocessing(
        request: CancelPipelineReprocessingRequest
      ): F[CancelPipelineReprocessingResponse]

      def createChannel(
        request: CreateChannelRequest
      ): F[CreateChannelResponse]

      def createDataset(
        request: CreateDatasetRequest
      ): F[CreateDatasetResponse]

      def createDatasetContent(
        request: CreateDatasetContentRequest
      ): F[CreateDatasetContentResponse]

      def createDatastore(
        request: CreateDatastoreRequest
      ): F[CreateDatastoreResponse]

      def createPipeline(
        request: CreatePipelineRequest
      ): F[CreatePipelineResponse]

      def deleteChannel(
        request: DeleteChannelRequest
      ): F[DeleteChannelResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def deleteDatasetContent(
        request: DeleteDatasetContentRequest
      ): F[DeleteDatasetContentResponse]

      def deleteDatastore(
        request: DeleteDatastoreRequest
      ): F[DeleteDatastoreResponse]

      def deletePipeline(
        request: DeletePipelineRequest
      ): F[DeletePipelineResponse]

      def describeChannel(
        request: DescribeChannelRequest
      ): F[DescribeChannelResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeDatastore(
        request: DescribeDatastoreRequest
      ): F[DescribeDatastoreResponse]

      def describeLoggingOptions(
        request: DescribeLoggingOptionsRequest
      ): F[DescribeLoggingOptionsResponse]

      def describePipeline(
        request: DescribePipelineRequest
      ): F[DescribePipelineResponse]

      def getDatasetContent(
        request: GetDatasetContentRequest
      ): F[GetDatasetContentResponse]

      def listChannels(
        request: ListChannelsRequest
      ): F[ListChannelsResponse]

      def listDatasetContents(
        request: ListDatasetContentsRequest
      ): F[ListDatasetContentsResponse]

      def listDatasets(
        request: ListDatasetsRequest
      ): F[ListDatasetsResponse]

      def listDatastores(
        request: ListDatastoresRequest
      ): F[ListDatastoresResponse]

      def listPipelines(
        request: ListPipelinesRequest
      ): F[ListPipelinesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putLoggingOptions(
        request: PutLoggingOptionsRequest
      ): F[PutLoggingOptionsResponse]

      def runPipelineActivity(
        request: RunPipelineActivityRequest
      ): F[RunPipelineActivityResponse]

      def sampleChannelData(
        request: SampleChannelDataRequest
      ): F[SampleChannelDataResponse]

      def startPipelineReprocessing(
        request: StartPipelineReprocessingRequest
      ): F[StartPipelineReprocessingResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateChannel(
        request: UpdateChannelRequest
      ): F[UpdateChannelResponse]

      def updateDataset(
        request: UpdateDatasetRequest
      ): F[UpdateDatasetResponse]

      def updateDatastore(
        request: UpdateDatastoreRequest
      ): F[UpdateDatastoreResponse]

      def updatePipeline(
        request: UpdatePipelineRequest
      ): F[UpdatePipelineResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IoTAnalyticsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchPutMessageOp(
      request: BatchPutMessageRequest
    ) extends IoTAnalyticsOp[BatchPutMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchPutMessageResponse] =
        visitor.batchPutMessage(request)
    }

    final case class CancelPipelineReprocessingOp(
      request: CancelPipelineReprocessingRequest
    ) extends IoTAnalyticsOp[CancelPipelineReprocessingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelPipelineReprocessingResponse] =
        visitor.cancelPipelineReprocessing(request)
    }

    final case class CreateChannelOp(
      request: CreateChannelRequest
    ) extends IoTAnalyticsOp[CreateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelResponse] =
        visitor.createChannel(request)
    }

    final case class CreateDatasetOp(
      request: CreateDatasetRequest
    ) extends IoTAnalyticsOp[CreateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetResponse] =
        visitor.createDataset(request)
    }

    final case class CreateDatasetContentOp(
      request: CreateDatasetContentRequest
    ) extends IoTAnalyticsOp[CreateDatasetContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetContentResponse] =
        visitor.createDatasetContent(request)
    }

    final case class CreateDatastoreOp(
      request: CreateDatastoreRequest
    ) extends IoTAnalyticsOp[CreateDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatastoreResponse] =
        visitor.createDatastore(request)
    }

    final case class CreatePipelineOp(
      request: CreatePipelineRequest
    ) extends IoTAnalyticsOp[CreatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePipelineResponse] =
        visitor.createPipeline(request)
    }

    final case class DeleteChannelOp(
      request: DeleteChannelRequest
    ) extends IoTAnalyticsOp[DeleteChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelResponse] =
        visitor.deleteChannel(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends IoTAnalyticsOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DeleteDatasetContentOp(
      request: DeleteDatasetContentRequest
    ) extends IoTAnalyticsOp[DeleteDatasetContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetContentResponse] =
        visitor.deleteDatasetContent(request)
    }

    final case class DeleteDatastoreOp(
      request: DeleteDatastoreRequest
    ) extends IoTAnalyticsOp[DeleteDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatastoreResponse] =
        visitor.deleteDatastore(request)
    }

    final case class DeletePipelineOp(
      request: DeletePipelineRequest
    ) extends IoTAnalyticsOp[DeletePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePipelineResponse] =
        visitor.deletePipeline(request)
    }

    final case class DescribeChannelOp(
      request: DescribeChannelRequest
    ) extends IoTAnalyticsOp[DescribeChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelResponse] =
        visitor.describeChannel(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends IoTAnalyticsOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeDatastoreOp(
      request: DescribeDatastoreRequest
    ) extends IoTAnalyticsOp[DescribeDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatastoreResponse] =
        visitor.describeDatastore(request)
    }

    final case class DescribeLoggingOptionsOp(
      request: DescribeLoggingOptionsRequest
    ) extends IoTAnalyticsOp[DescribeLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoggingOptionsResponse] =
        visitor.describeLoggingOptions(request)
    }

    final case class DescribePipelineOp(
      request: DescribePipelineRequest
    ) extends IoTAnalyticsOp[DescribePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePipelineResponse] =
        visitor.describePipeline(request)
    }

    final case class GetDatasetContentOp(
      request: GetDatasetContentRequest
    ) extends IoTAnalyticsOp[GetDatasetContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDatasetContentResponse] =
        visitor.getDatasetContent(request)
    }

    final case class ListChannelsOp(
      request: ListChannelsRequest
    ) extends IoTAnalyticsOp[ListChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsResponse] =
        visitor.listChannels(request)
    }

    final case class ListDatasetContentsOp(
      request: ListDatasetContentsRequest
    ) extends IoTAnalyticsOp[ListDatasetContentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetContentsResponse] =
        visitor.listDatasetContents(request)
    }

    final case class ListDatasetsOp(
      request: ListDatasetsRequest
    ) extends IoTAnalyticsOp[ListDatasetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetsResponse] =
        visitor.listDatasets(request)
    }

    final case class ListDatastoresOp(
      request: ListDatastoresRequest
    ) extends IoTAnalyticsOp[ListDatastoresResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatastoresResponse] =
        visitor.listDatastores(request)
    }

    final case class ListPipelinesOp(
      request: ListPipelinesRequest
    ) extends IoTAnalyticsOp[ListPipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelinesResponse] =
        visitor.listPipelines(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IoTAnalyticsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutLoggingOptionsOp(
      request: PutLoggingOptionsRequest
    ) extends IoTAnalyticsOp[PutLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLoggingOptionsResponse] =
        visitor.putLoggingOptions(request)
    }

    final case class RunPipelineActivityOp(
      request: RunPipelineActivityRequest
    ) extends IoTAnalyticsOp[RunPipelineActivityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RunPipelineActivityResponse] =
        visitor.runPipelineActivity(request)
    }

    final case class SampleChannelDataOp(
      request: SampleChannelDataRequest
    ) extends IoTAnalyticsOp[SampleChannelDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SampleChannelDataResponse] =
        visitor.sampleChannelData(request)
    }

    final case class StartPipelineReprocessingOp(
      request: StartPipelineReprocessingRequest
    ) extends IoTAnalyticsOp[StartPipelineReprocessingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPipelineReprocessingResponse] =
        visitor.startPipelineReprocessing(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IoTAnalyticsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IoTAnalyticsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateChannelOp(
      request: UpdateChannelRequest
    ) extends IoTAnalyticsOp[UpdateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelResponse] =
        visitor.updateChannel(request)
    }

    final case class UpdateDatasetOp(
      request: UpdateDatasetRequest
    ) extends IoTAnalyticsOp[UpdateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatasetResponse] =
        visitor.updateDataset(request)
    }

    final case class UpdateDatastoreOp(
      request: UpdateDatastoreRequest
    ) extends IoTAnalyticsOp[UpdateDatastoreResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatastoreResponse] =
        visitor.updateDatastore(request)
    }

    final case class UpdatePipelineOp(
      request: UpdatePipelineRequest
    ) extends IoTAnalyticsOp[UpdatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePipelineResponse] =
        visitor.updatePipeline(request)
    }
  }

  import IoTAnalyticsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IoTAnalyticsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchPutMessage(
    request: BatchPutMessageRequest
  ): IoTAnalyticsIO[BatchPutMessageResponse] =
    FF.liftF(BatchPutMessageOp(request))

  def cancelPipelineReprocessing(
    request: CancelPipelineReprocessingRequest
  ): IoTAnalyticsIO[CancelPipelineReprocessingResponse] =
    FF.liftF(CancelPipelineReprocessingOp(request))

  def createChannel(
    request: CreateChannelRequest
  ): IoTAnalyticsIO[CreateChannelResponse] =
    FF.liftF(CreateChannelOp(request))

  def createDataset(
    request: CreateDatasetRequest
  ): IoTAnalyticsIO[CreateDatasetResponse] =
    FF.liftF(CreateDatasetOp(request))

  def createDatasetContent(
    request: CreateDatasetContentRequest
  ): IoTAnalyticsIO[CreateDatasetContentResponse] =
    FF.liftF(CreateDatasetContentOp(request))

  def createDatastore(
    request: CreateDatastoreRequest
  ): IoTAnalyticsIO[CreateDatastoreResponse] =
    FF.liftF(CreateDatastoreOp(request))

  def createPipeline(
    request: CreatePipelineRequest
  ): IoTAnalyticsIO[CreatePipelineResponse] =
    FF.liftF(CreatePipelineOp(request))

  def deleteChannel(
    request: DeleteChannelRequest
  ): IoTAnalyticsIO[DeleteChannelResponse] =
    FF.liftF(DeleteChannelOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): IoTAnalyticsIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def deleteDatasetContent(
    request: DeleteDatasetContentRequest
  ): IoTAnalyticsIO[DeleteDatasetContentResponse] =
    FF.liftF(DeleteDatasetContentOp(request))

  def deleteDatastore(
    request: DeleteDatastoreRequest
  ): IoTAnalyticsIO[DeleteDatastoreResponse] =
    FF.liftF(DeleteDatastoreOp(request))

  def deletePipeline(
    request: DeletePipelineRequest
  ): IoTAnalyticsIO[DeletePipelineResponse] =
    FF.liftF(DeletePipelineOp(request))

  def describeChannel(
    request: DescribeChannelRequest
  ): IoTAnalyticsIO[DescribeChannelResponse] =
    FF.liftF(DescribeChannelOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): IoTAnalyticsIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeDatastore(
    request: DescribeDatastoreRequest
  ): IoTAnalyticsIO[DescribeDatastoreResponse] =
    FF.liftF(DescribeDatastoreOp(request))

  def describeLoggingOptions(
    request: DescribeLoggingOptionsRequest
  ): IoTAnalyticsIO[DescribeLoggingOptionsResponse] =
    FF.liftF(DescribeLoggingOptionsOp(request))

  def describePipeline(
    request: DescribePipelineRequest
  ): IoTAnalyticsIO[DescribePipelineResponse] =
    FF.liftF(DescribePipelineOp(request))

  def getDatasetContent(
    request: GetDatasetContentRequest
  ): IoTAnalyticsIO[GetDatasetContentResponse] =
    FF.liftF(GetDatasetContentOp(request))

  def listChannels(
    request: ListChannelsRequest
  ): IoTAnalyticsIO[ListChannelsResponse] =
    FF.liftF(ListChannelsOp(request))

  def listDatasetContents(
    request: ListDatasetContentsRequest
  ): IoTAnalyticsIO[ListDatasetContentsResponse] =
    FF.liftF(ListDatasetContentsOp(request))

  def listDatasets(
    request: ListDatasetsRequest
  ): IoTAnalyticsIO[ListDatasetsResponse] =
    FF.liftF(ListDatasetsOp(request))

  def listDatastores(
    request: ListDatastoresRequest
  ): IoTAnalyticsIO[ListDatastoresResponse] =
    FF.liftF(ListDatastoresOp(request))

  def listPipelines(
    request: ListPipelinesRequest
  ): IoTAnalyticsIO[ListPipelinesResponse] =
    FF.liftF(ListPipelinesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IoTAnalyticsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putLoggingOptions(
    request: PutLoggingOptionsRequest
  ): IoTAnalyticsIO[PutLoggingOptionsResponse] =
    FF.liftF(PutLoggingOptionsOp(request))

  def runPipelineActivity(
    request: RunPipelineActivityRequest
  ): IoTAnalyticsIO[RunPipelineActivityResponse] =
    FF.liftF(RunPipelineActivityOp(request))

  def sampleChannelData(
    request: SampleChannelDataRequest
  ): IoTAnalyticsIO[SampleChannelDataResponse] =
    FF.liftF(SampleChannelDataOp(request))

  def startPipelineReprocessing(
    request: StartPipelineReprocessingRequest
  ): IoTAnalyticsIO[StartPipelineReprocessingResponse] =
    FF.liftF(StartPipelineReprocessingOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IoTAnalyticsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IoTAnalyticsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateChannel(
    request: UpdateChannelRequest
  ): IoTAnalyticsIO[UpdateChannelResponse] =
    FF.liftF(UpdateChannelOp(request))

  def updateDataset(
    request: UpdateDatasetRequest
  ): IoTAnalyticsIO[UpdateDatasetResponse] =
    FF.liftF(UpdateDatasetOp(request))

  def updateDatastore(
    request: UpdateDatastoreRequest
  ): IoTAnalyticsIO[UpdateDatastoreResponse] =
    FF.liftF(UpdateDatastoreOp(request))

  def updatePipeline(
    request: UpdatePipelineRequest
  ): IoTAnalyticsIO[UpdatePipelineResponse] =
    FF.liftF(UpdatePipelineOp(request))
}
