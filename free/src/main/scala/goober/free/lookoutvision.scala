package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.lookoutvision.LookoutVisionClient
import software.amazon.awssdk.services.lookoutvision.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object lookoutvision { module =>

  // Free monad over LookoutVisionOp
  type LookoutVisionIO[A] = FF[LookoutVisionOp, A]

  sealed trait LookoutVisionOp[A] {
    def visit[F[_]](visitor: LookoutVisionOp.Visitor[F]): F[A]
  }

  object LookoutVisionOp {
    // Given a LookoutVisionClient we can embed a LookoutVisionIO program in any algebra that understands embedding.
    implicit val LookoutVisionOpEmbeddable: Embeddable[LookoutVisionOp, LookoutVisionClient] = new Embeddable[LookoutVisionOp, LookoutVisionClient] {
      def embed[A](client: LookoutVisionClient, io: LookoutVisionIO[A]): Embedded[A] = Embedded.LookoutVision(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LookoutVisionOp.Visitor[Kleisli[M, LookoutVisionClient, *]] {
        def createDataset(
          request: CreateDatasetRequest
        ): Kleisli[M, LookoutVisionClient, CreateDatasetResponse] =
          primitive(_.createDataset(request))

        def createModel(
          request: CreateModelRequest
        ): Kleisli[M, LookoutVisionClient, CreateModelResponse] =
          primitive(_.createModel(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, LookoutVisionClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, LookoutVisionClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def deleteModel(
          request: DeleteModelRequest
        ): Kleisli[M, LookoutVisionClient, DeleteModelResponse] =
          primitive(_.deleteModel(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, LookoutVisionClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, LookoutVisionClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeModel(
          request: DescribeModelRequest
        ): Kleisli[M, LookoutVisionClient, DescribeModelResponse] =
          primitive(_.describeModel(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, LookoutVisionClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def detectAnomalies(
          request: DetectAnomaliesRequest,
          body: RequestBody
        ): Kleisli[M, LookoutVisionClient, DetectAnomaliesResponse] =
          primitive(_.detectAnomalies(request, body))

        def listDatasetEntries(
          request: ListDatasetEntriesRequest
        ): Kleisli[M, LookoutVisionClient, ListDatasetEntriesResponse] =
          primitive(_.listDatasetEntries(request))

        def listModels(
          request: ListModelsRequest
        ): Kleisli[M, LookoutVisionClient, ListModelsResponse] =
          primitive(_.listModels(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, LookoutVisionClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LookoutVisionClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startModel(
          request: StartModelRequest
        ): Kleisli[M, LookoutVisionClient, StartModelResponse] =
          primitive(_.startModel(request))

        def stopModel(
          request: StopModelRequest
        ): Kleisli[M, LookoutVisionClient, StopModelResponse] =
          primitive(_.stopModel(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LookoutVisionClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LookoutVisionClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDatasetEntries(
          request: UpdateDatasetEntriesRequest
        ): Kleisli[M, LookoutVisionClient, UpdateDatasetEntriesResponse] =
          primitive(_.updateDatasetEntries(request))

        def primitive[A](
          f: LookoutVisionClient => A
        ): Kleisli[M, LookoutVisionClient, A]
      }
    }

    trait Visitor[F[_]] extends (LookoutVisionOp ~> F) {
      final def apply[A](op: LookoutVisionOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createDataset(
        request: CreateDatasetRequest
      ): F[CreateDatasetResponse]

      def createModel(
        request: CreateModelRequest
      ): F[CreateModelResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def deleteModel(
        request: DeleteModelRequest
      ): F[DeleteModelResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeModel(
        request: DescribeModelRequest
      ): F[DescribeModelResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def detectAnomalies(
        request: DetectAnomaliesRequest,
        body: RequestBody
      ): F[DetectAnomaliesResponse]

      def listDatasetEntries(
        request: ListDatasetEntriesRequest
      ): F[ListDatasetEntriesResponse]

      def listModels(
        request: ListModelsRequest
      ): F[ListModelsResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startModel(
        request: StartModelRequest
      ): F[StartModelResponse]

      def stopModel(
        request: StopModelRequest
      ): F[StopModelResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDatasetEntries(
        request: UpdateDatasetEntriesRequest
      ): F[UpdateDatasetEntriesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LookoutVisionOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateDatasetOp(
      request: CreateDatasetRequest
    ) extends LookoutVisionOp[CreateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetResponse] =
        visitor.createDataset(request)
    }

    final case class CreateModelOp(
      request: CreateModelRequest
    ) extends LookoutVisionOp[CreateModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateModelResponse] =
        visitor.createModel(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends LookoutVisionOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends LookoutVisionOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DeleteModelOp(
      request: DeleteModelRequest
    ) extends LookoutVisionOp[DeleteModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteModelResponse] =
        visitor.deleteModel(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends LookoutVisionOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends LookoutVisionOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeModelOp(
      request: DescribeModelRequest
    ) extends LookoutVisionOp[DescribeModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeModelResponse] =
        visitor.describeModel(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends LookoutVisionOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class DetectAnomaliesOp(
      request: DetectAnomaliesRequest,
      body: RequestBody
    ) extends LookoutVisionOp[DetectAnomaliesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectAnomaliesResponse] =
        visitor.detectAnomalies(request, body)
    }

    final case class ListDatasetEntriesOp(
      request: ListDatasetEntriesRequest
    ) extends LookoutVisionOp[ListDatasetEntriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetEntriesResponse] =
        visitor.listDatasetEntries(request)
    }

    final case class ListModelsOp(
      request: ListModelsRequest
    ) extends LookoutVisionOp[ListModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListModelsResponse] =
        visitor.listModels(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends LookoutVisionOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LookoutVisionOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartModelOp(
      request: StartModelRequest
    ) extends LookoutVisionOp[StartModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartModelResponse] =
        visitor.startModel(request)
    }

    final case class StopModelOp(
      request: StopModelRequest
    ) extends LookoutVisionOp[StopModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopModelResponse] =
        visitor.stopModel(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LookoutVisionOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LookoutVisionOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDatasetEntriesOp(
      request: UpdateDatasetEntriesRequest
    ) extends LookoutVisionOp[UpdateDatasetEntriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatasetEntriesResponse] =
        visitor.updateDatasetEntries(request)
    }
  }

  import LookoutVisionOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LookoutVisionOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createDataset(
    request: CreateDatasetRequest
  ): LookoutVisionIO[CreateDatasetResponse] =
    FF.liftF(CreateDatasetOp(request))

  def createModel(
    request: CreateModelRequest
  ): LookoutVisionIO[CreateModelResponse] =
    FF.liftF(CreateModelOp(request))

  def createProject(
    request: CreateProjectRequest
  ): LookoutVisionIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): LookoutVisionIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def deleteModel(
    request: DeleteModelRequest
  ): LookoutVisionIO[DeleteModelResponse] =
    FF.liftF(DeleteModelOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): LookoutVisionIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): LookoutVisionIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeModel(
    request: DescribeModelRequest
  ): LookoutVisionIO[DescribeModelResponse] =
    FF.liftF(DescribeModelOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): LookoutVisionIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def detectAnomalies(
    request: DetectAnomaliesRequest,
    body: RequestBody
  ): LookoutVisionIO[DetectAnomaliesResponse] =
    FF.liftF(DetectAnomaliesOp(request, body))

  def listDatasetEntries(
    request: ListDatasetEntriesRequest
  ): LookoutVisionIO[ListDatasetEntriesResponse] =
    FF.liftF(ListDatasetEntriesOp(request))

  def listModels(
    request: ListModelsRequest
  ): LookoutVisionIO[ListModelsResponse] =
    FF.liftF(ListModelsOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): LookoutVisionIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LookoutVisionIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startModel(
    request: StartModelRequest
  ): LookoutVisionIO[StartModelResponse] =
    FF.liftF(StartModelOp(request))

  def stopModel(
    request: StopModelRequest
  ): LookoutVisionIO[StopModelResponse] =
    FF.liftF(StopModelOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LookoutVisionIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LookoutVisionIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDatasetEntries(
    request: UpdateDatasetEntriesRequest
  ): LookoutVisionIO[UpdateDatasetEntriesResponse] =
    FF.liftF(UpdateDatasetEntriesOp(request))
}
