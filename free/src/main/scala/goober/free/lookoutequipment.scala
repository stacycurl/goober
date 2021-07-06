package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lookoutequipment.LookoutEquipmentClient
import software.amazon.awssdk.services.lookoutequipment.model._


object lookoutequipment { module =>

  // Free monad over LookoutEquipmentOp
  type LookoutEquipmentIO[A] = FF[LookoutEquipmentOp, A]

  sealed trait LookoutEquipmentOp[A] {
    def visit[F[_]](visitor: LookoutEquipmentOp.Visitor[F]): F[A]
  }

  object LookoutEquipmentOp {
    // Given a LookoutEquipmentClient we can embed a LookoutEquipmentIO program in any algebra that understands embedding.
    implicit val LookoutEquipmentOpEmbeddable: Embeddable[LookoutEquipmentOp, LookoutEquipmentClient] = new Embeddable[LookoutEquipmentOp, LookoutEquipmentClient] {
      def embed[A](client: LookoutEquipmentClient, io: LookoutEquipmentIO[A]): Embedded[A] = Embedded.LookoutEquipment(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LookoutEquipmentOp.Visitor[Kleisli[M, LookoutEquipmentClient, *]] {
        def createDataset(
          request: CreateDatasetRequest
        ): Kleisli[M, LookoutEquipmentClient, CreateDatasetResponse] =
          primitive(_.createDataset(request))

        def createInferenceScheduler(
          request: CreateInferenceSchedulerRequest
        ): Kleisli[M, LookoutEquipmentClient, CreateInferenceSchedulerResponse] =
          primitive(_.createInferenceScheduler(request))

        def createModel(
          request: CreateModelRequest
        ): Kleisli[M, LookoutEquipmentClient, CreateModelResponse] =
          primitive(_.createModel(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, LookoutEquipmentClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def deleteInferenceScheduler(
          request: DeleteInferenceSchedulerRequest
        ): Kleisli[M, LookoutEquipmentClient, DeleteInferenceSchedulerResponse] =
          primitive(_.deleteInferenceScheduler(request))

        def deleteModel(
          request: DeleteModelRequest
        ): Kleisli[M, LookoutEquipmentClient, DeleteModelResponse] =
          primitive(_.deleteModel(request))

        def describeDataIngestionJob(
          request: DescribeDataIngestionJobRequest
        ): Kleisli[M, LookoutEquipmentClient, DescribeDataIngestionJobResponse] =
          primitive(_.describeDataIngestionJob(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, LookoutEquipmentClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeInferenceScheduler(
          request: DescribeInferenceSchedulerRequest
        ): Kleisli[M, LookoutEquipmentClient, DescribeInferenceSchedulerResponse] =
          primitive(_.describeInferenceScheduler(request))

        def describeModel(
          request: DescribeModelRequest
        ): Kleisli[M, LookoutEquipmentClient, DescribeModelResponse] =
          primitive(_.describeModel(request))

        def listDataIngestionJobs(
          request: ListDataIngestionJobsRequest
        ): Kleisli[M, LookoutEquipmentClient, ListDataIngestionJobsResponse] =
          primitive(_.listDataIngestionJobs(request))

        def listDatasets(
          request: ListDatasetsRequest
        ): Kleisli[M, LookoutEquipmentClient, ListDatasetsResponse] =
          primitive(_.listDatasets(request))

        def listInferenceExecutions(
          request: ListInferenceExecutionsRequest
        ): Kleisli[M, LookoutEquipmentClient, ListInferenceExecutionsResponse] =
          primitive(_.listInferenceExecutions(request))

        def listInferenceSchedulers(
          request: ListInferenceSchedulersRequest
        ): Kleisli[M, LookoutEquipmentClient, ListInferenceSchedulersResponse] =
          primitive(_.listInferenceSchedulers(request))

        def listModels(
          request: ListModelsRequest
        ): Kleisli[M, LookoutEquipmentClient, ListModelsResponse] =
          primitive(_.listModels(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LookoutEquipmentClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startDataIngestionJob(
          request: StartDataIngestionJobRequest
        ): Kleisli[M, LookoutEquipmentClient, StartDataIngestionJobResponse] =
          primitive(_.startDataIngestionJob(request))

        def startInferenceScheduler(
          request: StartInferenceSchedulerRequest
        ): Kleisli[M, LookoutEquipmentClient, StartInferenceSchedulerResponse] =
          primitive(_.startInferenceScheduler(request))

        def stopInferenceScheduler(
          request: StopInferenceSchedulerRequest
        ): Kleisli[M, LookoutEquipmentClient, StopInferenceSchedulerResponse] =
          primitive(_.stopInferenceScheduler(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LookoutEquipmentClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LookoutEquipmentClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateInferenceScheduler(
          request: UpdateInferenceSchedulerRequest
        ): Kleisli[M, LookoutEquipmentClient, UpdateInferenceSchedulerResponse] =
          primitive(_.updateInferenceScheduler(request))

        def primitive[A](
          f: LookoutEquipmentClient => A
        ): Kleisli[M, LookoutEquipmentClient, A]
      }
    }

    trait Visitor[F[_]] extends (LookoutEquipmentOp ~> F) {
      final def apply[A](op: LookoutEquipmentOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDataset(
        request: CreateDatasetRequest
      ): F[CreateDatasetResponse]

      def createInferenceScheduler(
        request: CreateInferenceSchedulerRequest
      ): F[CreateInferenceSchedulerResponse]

      def createModel(
        request: CreateModelRequest
      ): F[CreateModelResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def deleteInferenceScheduler(
        request: DeleteInferenceSchedulerRequest
      ): F[DeleteInferenceSchedulerResponse]

      def deleteModel(
        request: DeleteModelRequest
      ): F[DeleteModelResponse]

      def describeDataIngestionJob(
        request: DescribeDataIngestionJobRequest
      ): F[DescribeDataIngestionJobResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeInferenceScheduler(
        request: DescribeInferenceSchedulerRequest
      ): F[DescribeInferenceSchedulerResponse]

      def describeModel(
        request: DescribeModelRequest
      ): F[DescribeModelResponse]

      def listDataIngestionJobs(
        request: ListDataIngestionJobsRequest
      ): F[ListDataIngestionJobsResponse]

      def listDatasets(
        request: ListDatasetsRequest
      ): F[ListDatasetsResponse]

      def listInferenceExecutions(
        request: ListInferenceExecutionsRequest
      ): F[ListInferenceExecutionsResponse]

      def listInferenceSchedulers(
        request: ListInferenceSchedulersRequest
      ): F[ListInferenceSchedulersResponse]

      def listModels(
        request: ListModelsRequest
      ): F[ListModelsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startDataIngestionJob(
        request: StartDataIngestionJobRequest
      ): F[StartDataIngestionJobResponse]

      def startInferenceScheduler(
        request: StartInferenceSchedulerRequest
      ): F[StartInferenceSchedulerResponse]

      def stopInferenceScheduler(
        request: StopInferenceSchedulerRequest
      ): F[StopInferenceSchedulerResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateInferenceScheduler(
        request: UpdateInferenceSchedulerRequest
      ): F[UpdateInferenceSchedulerResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LookoutEquipmentOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDatasetOp(
      request: CreateDatasetRequest
    ) extends LookoutEquipmentOp[CreateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetResponse] =
        visitor.createDataset(request)
    }

    final case class CreateInferenceSchedulerOp(
      request: CreateInferenceSchedulerRequest
    ) extends LookoutEquipmentOp[CreateInferenceSchedulerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInferenceSchedulerResponse] =
        visitor.createInferenceScheduler(request)
    }

    final case class CreateModelOp(
      request: CreateModelRequest
    ) extends LookoutEquipmentOp[CreateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelResponse] =
        visitor.createModel(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends LookoutEquipmentOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DeleteInferenceSchedulerOp(
      request: DeleteInferenceSchedulerRequest
    ) extends LookoutEquipmentOp[DeleteInferenceSchedulerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInferenceSchedulerResponse] =
        visitor.deleteInferenceScheduler(request)
    }

    final case class DeleteModelOp(
      request: DeleteModelRequest
    ) extends LookoutEquipmentOp[DeleteModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelResponse] =
        visitor.deleteModel(request)
    }

    final case class DescribeDataIngestionJobOp(
      request: DescribeDataIngestionJobRequest
    ) extends LookoutEquipmentOp[DescribeDataIngestionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataIngestionJobResponse] =
        visitor.describeDataIngestionJob(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends LookoutEquipmentOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeInferenceSchedulerOp(
      request: DescribeInferenceSchedulerRequest
    ) extends LookoutEquipmentOp[DescribeInferenceSchedulerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInferenceSchedulerResponse] =
        visitor.describeInferenceScheduler(request)
    }

    final case class DescribeModelOp(
      request: DescribeModelRequest
    ) extends LookoutEquipmentOp[DescribeModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelResponse] =
        visitor.describeModel(request)
    }

    final case class ListDataIngestionJobsOp(
      request: ListDataIngestionJobsRequest
    ) extends LookoutEquipmentOp[ListDataIngestionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataIngestionJobsResponse] =
        visitor.listDataIngestionJobs(request)
    }

    final case class ListDatasetsOp(
      request: ListDatasetsRequest
    ) extends LookoutEquipmentOp[ListDatasetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetsResponse] =
        visitor.listDatasets(request)
    }

    final case class ListInferenceExecutionsOp(
      request: ListInferenceExecutionsRequest
    ) extends LookoutEquipmentOp[ListInferenceExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInferenceExecutionsResponse] =
        visitor.listInferenceExecutions(request)
    }

    final case class ListInferenceSchedulersOp(
      request: ListInferenceSchedulersRequest
    ) extends LookoutEquipmentOp[ListInferenceSchedulersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInferenceSchedulersResponse] =
        visitor.listInferenceSchedulers(request)
    }

    final case class ListModelsOp(
      request: ListModelsRequest
    ) extends LookoutEquipmentOp[ListModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelsResponse] =
        visitor.listModels(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LookoutEquipmentOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartDataIngestionJobOp(
      request: StartDataIngestionJobRequest
    ) extends LookoutEquipmentOp[StartDataIngestionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDataIngestionJobResponse] =
        visitor.startDataIngestionJob(request)
    }

    final case class StartInferenceSchedulerOp(
      request: StartInferenceSchedulerRequest
    ) extends LookoutEquipmentOp[StartInferenceSchedulerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartInferenceSchedulerResponse] =
        visitor.startInferenceScheduler(request)
    }

    final case class StopInferenceSchedulerOp(
      request: StopInferenceSchedulerRequest
    ) extends LookoutEquipmentOp[StopInferenceSchedulerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopInferenceSchedulerResponse] =
        visitor.stopInferenceScheduler(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LookoutEquipmentOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LookoutEquipmentOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateInferenceSchedulerOp(
      request: UpdateInferenceSchedulerRequest
    ) extends LookoutEquipmentOp[UpdateInferenceSchedulerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInferenceSchedulerResponse] =
        visitor.updateInferenceScheduler(request)
    }
  }

  import LookoutEquipmentOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LookoutEquipmentOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDataset(
    request: CreateDatasetRequest
  ): LookoutEquipmentIO[CreateDatasetResponse] =
    FF.liftF(CreateDatasetOp(request))

  def createInferenceScheduler(
    request: CreateInferenceSchedulerRequest
  ): LookoutEquipmentIO[CreateInferenceSchedulerResponse] =
    FF.liftF(CreateInferenceSchedulerOp(request))

  def createModel(
    request: CreateModelRequest
  ): LookoutEquipmentIO[CreateModelResponse] =
    FF.liftF(CreateModelOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): LookoutEquipmentIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def deleteInferenceScheduler(
    request: DeleteInferenceSchedulerRequest
  ): LookoutEquipmentIO[DeleteInferenceSchedulerResponse] =
    FF.liftF(DeleteInferenceSchedulerOp(request))

  def deleteModel(
    request: DeleteModelRequest
  ): LookoutEquipmentIO[DeleteModelResponse] =
    FF.liftF(DeleteModelOp(request))

  def describeDataIngestionJob(
    request: DescribeDataIngestionJobRequest
  ): LookoutEquipmentIO[DescribeDataIngestionJobResponse] =
    FF.liftF(DescribeDataIngestionJobOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): LookoutEquipmentIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeInferenceScheduler(
    request: DescribeInferenceSchedulerRequest
  ): LookoutEquipmentIO[DescribeInferenceSchedulerResponse] =
    FF.liftF(DescribeInferenceSchedulerOp(request))

  def describeModel(
    request: DescribeModelRequest
  ): LookoutEquipmentIO[DescribeModelResponse] =
    FF.liftF(DescribeModelOp(request))

  def listDataIngestionJobs(
    request: ListDataIngestionJobsRequest
  ): LookoutEquipmentIO[ListDataIngestionJobsResponse] =
    FF.liftF(ListDataIngestionJobsOp(request))

  def listDatasets(
    request: ListDatasetsRequest
  ): LookoutEquipmentIO[ListDatasetsResponse] =
    FF.liftF(ListDatasetsOp(request))

  def listInferenceExecutions(
    request: ListInferenceExecutionsRequest
  ): LookoutEquipmentIO[ListInferenceExecutionsResponse] =
    FF.liftF(ListInferenceExecutionsOp(request))

  def listInferenceSchedulers(
    request: ListInferenceSchedulersRequest
  ): LookoutEquipmentIO[ListInferenceSchedulersResponse] =
    FF.liftF(ListInferenceSchedulersOp(request))

  def listModels(
    request: ListModelsRequest
  ): LookoutEquipmentIO[ListModelsResponse] =
    FF.liftF(ListModelsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LookoutEquipmentIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startDataIngestionJob(
    request: StartDataIngestionJobRequest
  ): LookoutEquipmentIO[StartDataIngestionJobResponse] =
    FF.liftF(StartDataIngestionJobOp(request))

  def startInferenceScheduler(
    request: StartInferenceSchedulerRequest
  ): LookoutEquipmentIO[StartInferenceSchedulerResponse] =
    FF.liftF(StartInferenceSchedulerOp(request))

  def stopInferenceScheduler(
    request: StopInferenceSchedulerRequest
  ): LookoutEquipmentIO[StopInferenceSchedulerResponse] =
    FF.liftF(StopInferenceSchedulerOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LookoutEquipmentIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LookoutEquipmentIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateInferenceScheduler(
    request: UpdateInferenceSchedulerRequest
  ): LookoutEquipmentIO[UpdateInferenceSchedulerResponse] =
    FF.liftF(UpdateInferenceSchedulerOp(request))
}
