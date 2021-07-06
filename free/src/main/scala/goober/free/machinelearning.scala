package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.machinelearning.MachineLearningClient
import software.amazon.awssdk.services.machinelearning.model._


object machinelearning { module =>

  // Free monad over MachineLearningOp
  type MachineLearningIO[A] = FF[MachineLearningOp, A]

  sealed trait MachineLearningOp[A] {
    def visit[F[_]](visitor: MachineLearningOp.Visitor[F]): F[A]
  }

  object MachineLearningOp {
    // Given a MachineLearningClient we can embed a MachineLearningIO program in any algebra that understands embedding.
    implicit val MachineLearningOpEmbeddable: Embeddable[MachineLearningOp, MachineLearningClient] = new Embeddable[MachineLearningOp, MachineLearningClient] {
      def embed[A](client: MachineLearningClient, io: MachineLearningIO[A]): Embedded[A] = Embedded.MachineLearning(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MachineLearningOp.Visitor[Kleisli[M, MachineLearningClient, *]] {
        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, MachineLearningClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def createBatchPrediction(
          request: CreateBatchPredictionRequest
        ): Kleisli[M, MachineLearningClient, CreateBatchPredictionResponse] =
          primitive(_.createBatchPrediction(request))

        def createDataSourceFromRDS(
          request: CreateDataSourceFromRdsRequest
        ): Kleisli[M, MachineLearningClient, CreateDataSourceFromRdsResponse] =
          primitive(_.createDataSourceFromRDS(request))

        def createDataSourceFromRedshift(
          request: CreateDataSourceFromRedshiftRequest
        ): Kleisli[M, MachineLearningClient, CreateDataSourceFromRedshiftResponse] =
          primitive(_.createDataSourceFromRedshift(request))

        def createDataSourceFromS3(
          request: CreateDataSourceFromS3Request
        ): Kleisli[M, MachineLearningClient, CreateDataSourceFromS3Response] =
          primitive(_.createDataSourceFromS3(request))

        def createEvaluation(
          request: CreateEvaluationRequest
        ): Kleisli[M, MachineLearningClient, CreateEvaluationResponse] =
          primitive(_.createEvaluation(request))

        def createMLModel(
          request: CreateMlModelRequest
        ): Kleisli[M, MachineLearningClient, CreateMlModelResponse] =
          primitive(_.createMLModel(request))

        def createRealtimeEndpoint(
          request: CreateRealtimeEndpointRequest
        ): Kleisli[M, MachineLearningClient, CreateRealtimeEndpointResponse] =
          primitive(_.createRealtimeEndpoint(request))

        def deleteBatchPrediction(
          request: DeleteBatchPredictionRequest
        ): Kleisli[M, MachineLearningClient, DeleteBatchPredictionResponse] =
          primitive(_.deleteBatchPrediction(request))

        def deleteDataSource(
          request: DeleteDataSourceRequest
        ): Kleisli[M, MachineLearningClient, DeleteDataSourceResponse] =
          primitive(_.deleteDataSource(request))

        def deleteEvaluation(
          request: DeleteEvaluationRequest
        ): Kleisli[M, MachineLearningClient, DeleteEvaluationResponse] =
          primitive(_.deleteEvaluation(request))

        def deleteMLModel(
          request: DeleteMlModelRequest
        ): Kleisli[M, MachineLearningClient, DeleteMlModelResponse] =
          primitive(_.deleteMLModel(request))

        def deleteRealtimeEndpoint(
          request: DeleteRealtimeEndpointRequest
        ): Kleisli[M, MachineLearningClient, DeleteRealtimeEndpointResponse] =
          primitive(_.deleteRealtimeEndpoint(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, MachineLearningClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def describeBatchPredictions(
          request: DescribeBatchPredictionsRequest
        ): Kleisli[M, MachineLearningClient, DescribeBatchPredictionsResponse] =
          primitive(_.describeBatchPredictions(request))

        def describeDataSources(
          request: DescribeDataSourcesRequest
        ): Kleisli[M, MachineLearningClient, DescribeDataSourcesResponse] =
          primitive(_.describeDataSources(request))

        def describeEvaluations(
          request: DescribeEvaluationsRequest
        ): Kleisli[M, MachineLearningClient, DescribeEvaluationsResponse] =
          primitive(_.describeEvaluations(request))

        def describeMLModels(
          request: DescribeMlModelsRequest
        ): Kleisli[M, MachineLearningClient, DescribeMlModelsResponse] =
          primitive(_.describeMLModels(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, MachineLearningClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def getBatchPrediction(
          request: GetBatchPredictionRequest
        ): Kleisli[M, MachineLearningClient, GetBatchPredictionResponse] =
          primitive(_.getBatchPrediction(request))

        def getDataSource(
          request: GetDataSourceRequest
        ): Kleisli[M, MachineLearningClient, GetDataSourceResponse] =
          primitive(_.getDataSource(request))

        def getEvaluation(
          request: GetEvaluationRequest
        ): Kleisli[M, MachineLearningClient, GetEvaluationResponse] =
          primitive(_.getEvaluation(request))

        def getMLModel(
          request: GetMlModelRequest
        ): Kleisli[M, MachineLearningClient, GetMlModelResponse] =
          primitive(_.getMLModel(request))

        def predict(
          request: PredictRequest
        ): Kleisli[M, MachineLearningClient, PredictResponse] =
          primitive(_.predict(request))

        def updateBatchPrediction(
          request: UpdateBatchPredictionRequest
        ): Kleisli[M, MachineLearningClient, UpdateBatchPredictionResponse] =
          primitive(_.updateBatchPrediction(request))

        def updateDataSource(
          request: UpdateDataSourceRequest
        ): Kleisli[M, MachineLearningClient, UpdateDataSourceResponse] =
          primitive(_.updateDataSource(request))

        def updateEvaluation(
          request: UpdateEvaluationRequest
        ): Kleisli[M, MachineLearningClient, UpdateEvaluationResponse] =
          primitive(_.updateEvaluation(request))

        def updateMLModel(
          request: UpdateMlModelRequest
        ): Kleisli[M, MachineLearningClient, UpdateMlModelResponse] =
          primitive(_.updateMLModel(request))

        def primitive[A](
          f: MachineLearningClient => A
        ): Kleisli[M, MachineLearningClient, A]
      }
    }

    trait Visitor[F[_]] extends (MachineLearningOp ~> F) {
      final def apply[A](op: MachineLearningOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def createBatchPrediction(
        request: CreateBatchPredictionRequest
      ): F[CreateBatchPredictionResponse]

      def createDataSourceFromRDS(
        request: CreateDataSourceFromRdsRequest
      ): F[CreateDataSourceFromRdsResponse]

      def createDataSourceFromRedshift(
        request: CreateDataSourceFromRedshiftRequest
      ): F[CreateDataSourceFromRedshiftResponse]

      def createDataSourceFromS3(
        request: CreateDataSourceFromS3Request
      ): F[CreateDataSourceFromS3Response]

      def createEvaluation(
        request: CreateEvaluationRequest
      ): F[CreateEvaluationResponse]

      def createMLModel(
        request: CreateMlModelRequest
      ): F[CreateMlModelResponse]

      def createRealtimeEndpoint(
        request: CreateRealtimeEndpointRequest
      ): F[CreateRealtimeEndpointResponse]

      def deleteBatchPrediction(
        request: DeleteBatchPredictionRequest
      ): F[DeleteBatchPredictionResponse]

      def deleteDataSource(
        request: DeleteDataSourceRequest
      ): F[DeleteDataSourceResponse]

      def deleteEvaluation(
        request: DeleteEvaluationRequest
      ): F[DeleteEvaluationResponse]

      def deleteMLModel(
        request: DeleteMlModelRequest
      ): F[DeleteMlModelResponse]

      def deleteRealtimeEndpoint(
        request: DeleteRealtimeEndpointRequest
      ): F[DeleteRealtimeEndpointResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def describeBatchPredictions(
        request: DescribeBatchPredictionsRequest
      ): F[DescribeBatchPredictionsResponse]

      def describeDataSources(
        request: DescribeDataSourcesRequest
      ): F[DescribeDataSourcesResponse]

      def describeEvaluations(
        request: DescribeEvaluationsRequest
      ): F[DescribeEvaluationsResponse]

      def describeMLModels(
        request: DescribeMlModelsRequest
      ): F[DescribeMlModelsResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def getBatchPrediction(
        request: GetBatchPredictionRequest
      ): F[GetBatchPredictionResponse]

      def getDataSource(
        request: GetDataSourceRequest
      ): F[GetDataSourceResponse]

      def getEvaluation(
        request: GetEvaluationRequest
      ): F[GetEvaluationResponse]

      def getMLModel(
        request: GetMlModelRequest
      ): F[GetMlModelResponse]

      def predict(
        request: PredictRequest
      ): F[PredictResponse]

      def updateBatchPrediction(
        request: UpdateBatchPredictionRequest
      ): F[UpdateBatchPredictionResponse]

      def updateDataSource(
        request: UpdateDataSourceRequest
      ): F[UpdateDataSourceResponse]

      def updateEvaluation(
        request: UpdateEvaluationRequest
      ): F[UpdateEvaluationResponse]

      def updateMLModel(
        request: UpdateMlModelRequest
      ): F[UpdateMlModelResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MachineLearningOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends MachineLearningOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class CreateBatchPredictionOp(
      request: CreateBatchPredictionRequest
    ) extends MachineLearningOp[CreateBatchPredictionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBatchPredictionResponse] =
        visitor.createBatchPrediction(request)
    }

    final case class CreateDataSourceFromRDSOp(
      request: CreateDataSourceFromRdsRequest
    ) extends MachineLearningOp[CreateDataSourceFromRdsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSourceFromRdsResponse] =
        visitor.createDataSourceFromRDS(request)
    }

    final case class CreateDataSourceFromRedshiftOp(
      request: CreateDataSourceFromRedshiftRequest
    ) extends MachineLearningOp[CreateDataSourceFromRedshiftResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSourceFromRedshiftResponse] =
        visitor.createDataSourceFromRedshift(request)
    }

    final case class CreateDataSourceFromS3Op(
      request: CreateDataSourceFromS3Request
    ) extends MachineLearningOp[CreateDataSourceFromS3Response] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSourceFromS3Response] =
        visitor.createDataSourceFromS3(request)
    }

    final case class CreateEvaluationOp(
      request: CreateEvaluationRequest
    ) extends MachineLearningOp[CreateEvaluationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEvaluationResponse] =
        visitor.createEvaluation(request)
    }

    final case class CreateMLModelOp(
      request: CreateMlModelRequest
    ) extends MachineLearningOp[CreateMlModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMlModelResponse] =
        visitor.createMLModel(request)
    }

    final case class CreateRealtimeEndpointOp(
      request: CreateRealtimeEndpointRequest
    ) extends MachineLearningOp[CreateRealtimeEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRealtimeEndpointResponse] =
        visitor.createRealtimeEndpoint(request)
    }

    final case class DeleteBatchPredictionOp(
      request: DeleteBatchPredictionRequest
    ) extends MachineLearningOp[DeleteBatchPredictionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBatchPredictionResponse] =
        visitor.deleteBatchPrediction(request)
    }

    final case class DeleteDataSourceOp(
      request: DeleteDataSourceRequest
    ) extends MachineLearningOp[DeleteDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataSourceResponse] =
        visitor.deleteDataSource(request)
    }

    final case class DeleteEvaluationOp(
      request: DeleteEvaluationRequest
    ) extends MachineLearningOp[DeleteEvaluationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEvaluationResponse] =
        visitor.deleteEvaluation(request)
    }

    final case class DeleteMLModelOp(
      request: DeleteMlModelRequest
    ) extends MachineLearningOp[DeleteMlModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMlModelResponse] =
        visitor.deleteMLModel(request)
    }

    final case class DeleteRealtimeEndpointOp(
      request: DeleteRealtimeEndpointRequest
    ) extends MachineLearningOp[DeleteRealtimeEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRealtimeEndpointResponse] =
        visitor.deleteRealtimeEndpoint(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends MachineLearningOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DescribeBatchPredictionsOp(
      request: DescribeBatchPredictionsRequest
    ) extends MachineLearningOp[DescribeBatchPredictionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBatchPredictionsResponse] =
        visitor.describeBatchPredictions(request)
    }

    final case class DescribeDataSourcesOp(
      request: DescribeDataSourcesRequest
    ) extends MachineLearningOp[DescribeDataSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataSourcesResponse] =
        visitor.describeDataSources(request)
    }

    final case class DescribeEvaluationsOp(
      request: DescribeEvaluationsRequest
    ) extends MachineLearningOp[DescribeEvaluationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEvaluationsResponse] =
        visitor.describeEvaluations(request)
    }

    final case class DescribeMLModelsOp(
      request: DescribeMlModelsRequest
    ) extends MachineLearningOp[DescribeMlModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMlModelsResponse] =
        visitor.describeMLModels(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends MachineLearningOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class GetBatchPredictionOp(
      request: GetBatchPredictionRequest
    ) extends MachineLearningOp[GetBatchPredictionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBatchPredictionResponse] =
        visitor.getBatchPrediction(request)
    }

    final case class GetDataSourceOp(
      request: GetDataSourceRequest
    ) extends MachineLearningOp[GetDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataSourceResponse] =
        visitor.getDataSource(request)
    }

    final case class GetEvaluationOp(
      request: GetEvaluationRequest
    ) extends MachineLearningOp[GetEvaluationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEvaluationResponse] =
        visitor.getEvaluation(request)
    }

    final case class GetMLModelOp(
      request: GetMlModelRequest
    ) extends MachineLearningOp[GetMlModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMlModelResponse] =
        visitor.getMLModel(request)
    }

    final case class PredictOp(
      request: PredictRequest
    ) extends MachineLearningOp[PredictResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PredictResponse] =
        visitor.predict(request)
    }

    final case class UpdateBatchPredictionOp(
      request: UpdateBatchPredictionRequest
    ) extends MachineLearningOp[UpdateBatchPredictionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBatchPredictionResponse] =
        visitor.updateBatchPrediction(request)
    }

    final case class UpdateDataSourceOp(
      request: UpdateDataSourceRequest
    ) extends MachineLearningOp[UpdateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSourceResponse] =
        visitor.updateDataSource(request)
    }

    final case class UpdateEvaluationOp(
      request: UpdateEvaluationRequest
    ) extends MachineLearningOp[UpdateEvaluationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEvaluationResponse] =
        visitor.updateEvaluation(request)
    }

    final case class UpdateMLModelOp(
      request: UpdateMlModelRequest
    ) extends MachineLearningOp[UpdateMlModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMlModelResponse] =
        visitor.updateMLModel(request)
    }
  }

  import MachineLearningOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MachineLearningOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTags(
    request: AddTagsRequest
  ): MachineLearningIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def createBatchPrediction(
    request: CreateBatchPredictionRequest
  ): MachineLearningIO[CreateBatchPredictionResponse] =
    FF.liftF(CreateBatchPredictionOp(request))

  def createDataSourceFromRDS(
    request: CreateDataSourceFromRdsRequest
  ): MachineLearningIO[CreateDataSourceFromRdsResponse] =
    FF.liftF(CreateDataSourceFromRDSOp(request))

  def createDataSourceFromRedshift(
    request: CreateDataSourceFromRedshiftRequest
  ): MachineLearningIO[CreateDataSourceFromRedshiftResponse] =
    FF.liftF(CreateDataSourceFromRedshiftOp(request))

  def createDataSourceFromS3(
    request: CreateDataSourceFromS3Request
  ): MachineLearningIO[CreateDataSourceFromS3Response] =
    FF.liftF(CreateDataSourceFromS3Op(request))

  def createEvaluation(
    request: CreateEvaluationRequest
  ): MachineLearningIO[CreateEvaluationResponse] =
    FF.liftF(CreateEvaluationOp(request))

  def createMLModel(
    request: CreateMlModelRequest
  ): MachineLearningIO[CreateMlModelResponse] =
    FF.liftF(CreateMLModelOp(request))

  def createRealtimeEndpoint(
    request: CreateRealtimeEndpointRequest
  ): MachineLearningIO[CreateRealtimeEndpointResponse] =
    FF.liftF(CreateRealtimeEndpointOp(request))

  def deleteBatchPrediction(
    request: DeleteBatchPredictionRequest
  ): MachineLearningIO[DeleteBatchPredictionResponse] =
    FF.liftF(DeleteBatchPredictionOp(request))

  def deleteDataSource(
    request: DeleteDataSourceRequest
  ): MachineLearningIO[DeleteDataSourceResponse] =
    FF.liftF(DeleteDataSourceOp(request))

  def deleteEvaluation(
    request: DeleteEvaluationRequest
  ): MachineLearningIO[DeleteEvaluationResponse] =
    FF.liftF(DeleteEvaluationOp(request))

  def deleteMLModel(
    request: DeleteMlModelRequest
  ): MachineLearningIO[DeleteMlModelResponse] =
    FF.liftF(DeleteMLModelOp(request))

  def deleteRealtimeEndpoint(
    request: DeleteRealtimeEndpointRequest
  ): MachineLearningIO[DeleteRealtimeEndpointResponse] =
    FF.liftF(DeleteRealtimeEndpointOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): MachineLearningIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def describeBatchPredictions(
    request: DescribeBatchPredictionsRequest
  ): MachineLearningIO[DescribeBatchPredictionsResponse] =
    FF.liftF(DescribeBatchPredictionsOp(request))

  def describeDataSources(
    request: DescribeDataSourcesRequest
  ): MachineLearningIO[DescribeDataSourcesResponse] =
    FF.liftF(DescribeDataSourcesOp(request))

  def describeEvaluations(
    request: DescribeEvaluationsRequest
  ): MachineLearningIO[DescribeEvaluationsResponse] =
    FF.liftF(DescribeEvaluationsOp(request))

  def describeMLModels(
    request: DescribeMlModelsRequest
  ): MachineLearningIO[DescribeMlModelsResponse] =
    FF.liftF(DescribeMLModelsOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): MachineLearningIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def getBatchPrediction(
    request: GetBatchPredictionRequest
  ): MachineLearningIO[GetBatchPredictionResponse] =
    FF.liftF(GetBatchPredictionOp(request))

  def getDataSource(
    request: GetDataSourceRequest
  ): MachineLearningIO[GetDataSourceResponse] =
    FF.liftF(GetDataSourceOp(request))

  def getEvaluation(
    request: GetEvaluationRequest
  ): MachineLearningIO[GetEvaluationResponse] =
    FF.liftF(GetEvaluationOp(request))

  def getMLModel(
    request: GetMlModelRequest
  ): MachineLearningIO[GetMlModelResponse] =
    FF.liftF(GetMLModelOp(request))

  def predict(
    request: PredictRequest
  ): MachineLearningIO[PredictResponse] =
    FF.liftF(PredictOp(request))

  def updateBatchPrediction(
    request: UpdateBatchPredictionRequest
  ): MachineLearningIO[UpdateBatchPredictionResponse] =
    FF.liftF(UpdateBatchPredictionOp(request))

  def updateDataSource(
    request: UpdateDataSourceRequest
  ): MachineLearningIO[UpdateDataSourceResponse] =
    FF.liftF(UpdateDataSourceOp(request))

  def updateEvaluation(
    request: UpdateEvaluationRequest
  ): MachineLearningIO[UpdateEvaluationResponse] =
    FF.liftF(UpdateEvaluationOp(request))

  def updateMLModel(
    request: UpdateMlModelRequest
  ): MachineLearningIO[UpdateMlModelResponse] =
    FF.liftF(UpdateMLModelOp(request))
}
