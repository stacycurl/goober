package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.datapipeline.DataPipelineClient
import software.amazon.awssdk.services.datapipeline.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object datapipeline { module =>

  // Free monad over DataPipelineOp
  type DataPipelineIO[A] = FF[DataPipelineOp, A]

  sealed trait DataPipelineOp[A] {
    def visit[F[_]](visitor: DataPipelineOp.Visitor[F]): F[A]
  }

  object DataPipelineOp {
    // Given a DataPipelineClient we can embed a DataPipelineIO program in any algebra that understands embedding.
    implicit val DataPipelineOpEmbeddable: Embeddable[DataPipelineOp, DataPipelineClient] = new Embeddable[DataPipelineOp, DataPipelineClient] {
      def embed[A](client: DataPipelineClient, io: DataPipelineIO[A]): Embedded[A] = Embedded.DataPipeline(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DataPipelineOp.Visitor[Kleisli[M, DataPipelineClient, *]] {
        def activatePipeline(
          request: ActivatePipelineRequest
        ): Kleisli[M, DataPipelineClient, ActivatePipelineResponse] =
          primitive(_.activatePipeline(request))

        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, DataPipelineClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def createPipeline(
          request: CreatePipelineRequest
        ): Kleisli[M, DataPipelineClient, CreatePipelineResponse] =
          primitive(_.createPipeline(request))

        def deactivatePipeline(
          request: DeactivatePipelineRequest
        ): Kleisli[M, DataPipelineClient, DeactivatePipelineResponse] =
          primitive(_.deactivatePipeline(request))

        def deletePipeline(
          request: DeletePipelineRequest
        ): Kleisli[M, DataPipelineClient, DeletePipelineResponse] =
          primitive(_.deletePipeline(request))

        def describeObjects(
          request: DescribeObjectsRequest
        ): Kleisli[M, DataPipelineClient, DescribeObjectsResponse] =
          primitive(_.describeObjects(request))

        def describePipelines(
          request: DescribePipelinesRequest
        ): Kleisli[M, DataPipelineClient, DescribePipelinesResponse] =
          primitive(_.describePipelines(request))

        def evaluateExpression(
          request: EvaluateExpressionRequest
        ): Kleisli[M, DataPipelineClient, EvaluateExpressionResponse] =
          primitive(_.evaluateExpression(request))

        def getPipelineDefinition(
          request: GetPipelineDefinitionRequest
        ): Kleisli[M, DataPipelineClient, GetPipelineDefinitionResponse] =
          primitive(_.getPipelineDefinition(request))

        def listPipelines(
          request: ListPipelinesRequest
        ): Kleisli[M, DataPipelineClient, ListPipelinesResponse] =
          primitive(_.listPipelines(request))

        def pollForTask(
          request: PollForTaskRequest
        ): Kleisli[M, DataPipelineClient, PollForTaskResponse] =
          primitive(_.pollForTask(request))

        def putPipelineDefinition(
          request: PutPipelineDefinitionRequest
        ): Kleisli[M, DataPipelineClient, PutPipelineDefinitionResponse] =
          primitive(_.putPipelineDefinition(request))

        def queryObjects(
          request: QueryObjectsRequest
        ): Kleisli[M, DataPipelineClient, QueryObjectsResponse] =
          primitive(_.queryObjects(request))

        def removeTags(
          request: RemoveTagsRequest
        ): Kleisli[M, DataPipelineClient, RemoveTagsResponse] =
          primitive(_.removeTags(request))

        def reportTaskProgress(
          request: ReportTaskProgressRequest
        ): Kleisli[M, DataPipelineClient, ReportTaskProgressResponse] =
          primitive(_.reportTaskProgress(request))

        def reportTaskRunnerHeartbeat(
          request: ReportTaskRunnerHeartbeatRequest
        ): Kleisli[M, DataPipelineClient, ReportTaskRunnerHeartbeatResponse] =
          primitive(_.reportTaskRunnerHeartbeat(request))

        def setStatus(
          request: SetStatusRequest
        ): Kleisli[M, DataPipelineClient, SetStatusResponse] =
          primitive(_.setStatus(request))

        def setTaskStatus(
          request: SetTaskStatusRequest
        ): Kleisli[M, DataPipelineClient, SetTaskStatusResponse] =
          primitive(_.setTaskStatus(request))

        def validatePipelineDefinition(
          request: ValidatePipelineDefinitionRequest
        ): Kleisli[M, DataPipelineClient, ValidatePipelineDefinitionResponse] =
          primitive(_.validatePipelineDefinition(request))

        def primitive[A](
          f: DataPipelineClient => A
        ): Kleisli[M, DataPipelineClient, A]
      }
    }

    trait Visitor[F[_]] extends (DataPipelineOp ~> F) {
      final def apply[A](op: DataPipelineOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def activatePipeline(
        request: ActivatePipelineRequest
      ): F[ActivatePipelineResponse]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def createPipeline(
        request: CreatePipelineRequest
      ): F[CreatePipelineResponse]

      def deactivatePipeline(
        request: DeactivatePipelineRequest
      ): F[DeactivatePipelineResponse]

      def deletePipeline(
        request: DeletePipelineRequest
      ): F[DeletePipelineResponse]

      def describeObjects(
        request: DescribeObjectsRequest
      ): F[DescribeObjectsResponse]

      def describePipelines(
        request: DescribePipelinesRequest
      ): F[DescribePipelinesResponse]

      def evaluateExpression(
        request: EvaluateExpressionRequest
      ): F[EvaluateExpressionResponse]

      def getPipelineDefinition(
        request: GetPipelineDefinitionRequest
      ): F[GetPipelineDefinitionResponse]

      def listPipelines(
        request: ListPipelinesRequest
      ): F[ListPipelinesResponse]

      def pollForTask(
        request: PollForTaskRequest
      ): F[PollForTaskResponse]

      def putPipelineDefinition(
        request: PutPipelineDefinitionRequest
      ): F[PutPipelineDefinitionResponse]

      def queryObjects(
        request: QueryObjectsRequest
      ): F[QueryObjectsResponse]

      def removeTags(
        request: RemoveTagsRequest
      ): F[RemoveTagsResponse]

      def reportTaskProgress(
        request: ReportTaskProgressRequest
      ): F[ReportTaskProgressResponse]

      def reportTaskRunnerHeartbeat(
        request: ReportTaskRunnerHeartbeatRequest
      ): F[ReportTaskRunnerHeartbeatResponse]

      def setStatus(
        request: SetStatusRequest
      ): F[SetStatusResponse]

      def setTaskStatus(
        request: SetTaskStatusRequest
      ): F[SetTaskStatusResponse]

      def validatePipelineDefinition(
        request: ValidatePipelineDefinitionRequest
      ): F[ValidatePipelineDefinitionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DataPipelineOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ActivatePipelineOp(
      request: ActivatePipelineRequest
    ) extends DataPipelineOp[ActivatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ActivatePipelineResponse] =
        visitor.activatePipeline(request)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends DataPipelineOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class CreatePipelineOp(
      request: CreatePipelineRequest
    ) extends DataPipelineOp[CreatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePipelineResponse] =
        visitor.createPipeline(request)
    }

    final case class DeactivatePipelineOp(
      request: DeactivatePipelineRequest
    ) extends DataPipelineOp[DeactivatePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeactivatePipelineResponse] =
        visitor.deactivatePipeline(request)
    }

    final case class DeletePipelineOp(
      request: DeletePipelineRequest
    ) extends DataPipelineOp[DeletePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePipelineResponse] =
        visitor.deletePipeline(request)
    }

    final case class DescribeObjectsOp(
      request: DescribeObjectsRequest
    ) extends DataPipelineOp[DescribeObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeObjectsResponse] =
        visitor.describeObjects(request)
    }

    final case class DescribePipelinesOp(
      request: DescribePipelinesRequest
    ) extends DataPipelineOp[DescribePipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePipelinesResponse] =
        visitor.describePipelines(request)
    }

    final case class EvaluateExpressionOp(
      request: EvaluateExpressionRequest
    ) extends DataPipelineOp[EvaluateExpressionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EvaluateExpressionResponse] =
        visitor.evaluateExpression(request)
    }

    final case class GetPipelineDefinitionOp(
      request: GetPipelineDefinitionRequest
    ) extends DataPipelineOp[GetPipelineDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPipelineDefinitionResponse] =
        visitor.getPipelineDefinition(request)
    }

    final case class ListPipelinesOp(
      request: ListPipelinesRequest
    ) extends DataPipelineOp[ListPipelinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPipelinesResponse] =
        visitor.listPipelines(request)
    }

    final case class PollForTaskOp(
      request: PollForTaskRequest
    ) extends DataPipelineOp[PollForTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PollForTaskResponse] =
        visitor.pollForTask(request)
    }

    final case class PutPipelineDefinitionOp(
      request: PutPipelineDefinitionRequest
    ) extends DataPipelineOp[PutPipelineDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutPipelineDefinitionResponse] =
        visitor.putPipelineDefinition(request)
    }

    final case class QueryObjectsOp(
      request: QueryObjectsRequest
    ) extends DataPipelineOp[QueryObjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QueryObjectsResponse] =
        visitor.queryObjects(request)
    }

    final case class RemoveTagsOp(
      request: RemoveTagsRequest
    ) extends DataPipelineOp[RemoveTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsResponse] =
        visitor.removeTags(request)
    }

    final case class ReportTaskProgressOp(
      request: ReportTaskProgressRequest
    ) extends DataPipelineOp[ReportTaskProgressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReportTaskProgressResponse] =
        visitor.reportTaskProgress(request)
    }

    final case class ReportTaskRunnerHeartbeatOp(
      request: ReportTaskRunnerHeartbeatRequest
    ) extends DataPipelineOp[ReportTaskRunnerHeartbeatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ReportTaskRunnerHeartbeatResponse] =
        visitor.reportTaskRunnerHeartbeat(request)
    }

    final case class SetStatusOp(
      request: SetStatusRequest
    ) extends DataPipelineOp[SetStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetStatusResponse] =
        visitor.setStatus(request)
    }

    final case class SetTaskStatusOp(
      request: SetTaskStatusRequest
    ) extends DataPipelineOp[SetTaskStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetTaskStatusResponse] =
        visitor.setTaskStatus(request)
    }

    final case class ValidatePipelineDefinitionOp(
      request: ValidatePipelineDefinitionRequest
    ) extends DataPipelineOp[ValidatePipelineDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidatePipelineDefinitionResponse] =
        visitor.validatePipelineDefinition(request)
    }
  }

  import DataPipelineOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DataPipelineOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def activatePipeline(
    request: ActivatePipelineRequest
  ): DataPipelineIO[ActivatePipelineResponse] =
    FF.liftF(ActivatePipelineOp(request))

  def addTags(
    request: AddTagsRequest
  ): DataPipelineIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def createPipeline(
    request: CreatePipelineRequest
  ): DataPipelineIO[CreatePipelineResponse] =
    FF.liftF(CreatePipelineOp(request))

  def deactivatePipeline(
    request: DeactivatePipelineRequest
  ): DataPipelineIO[DeactivatePipelineResponse] =
    FF.liftF(DeactivatePipelineOp(request))

  def deletePipeline(
    request: DeletePipelineRequest
  ): DataPipelineIO[DeletePipelineResponse] =
    FF.liftF(DeletePipelineOp(request))

  def describeObjects(
    request: DescribeObjectsRequest
  ): DataPipelineIO[DescribeObjectsResponse] =
    FF.liftF(DescribeObjectsOp(request))

  def describePipelines(
    request: DescribePipelinesRequest
  ): DataPipelineIO[DescribePipelinesResponse] =
    FF.liftF(DescribePipelinesOp(request))

  def evaluateExpression(
    request: EvaluateExpressionRequest
  ): DataPipelineIO[EvaluateExpressionResponse] =
    FF.liftF(EvaluateExpressionOp(request))

  def getPipelineDefinition(
    request: GetPipelineDefinitionRequest
  ): DataPipelineIO[GetPipelineDefinitionResponse] =
    FF.liftF(GetPipelineDefinitionOp(request))

  def listPipelines(
    request: ListPipelinesRequest
  ): DataPipelineIO[ListPipelinesResponse] =
    FF.liftF(ListPipelinesOp(request))

  def pollForTask(
    request: PollForTaskRequest
  ): DataPipelineIO[PollForTaskResponse] =
    FF.liftF(PollForTaskOp(request))

  def putPipelineDefinition(
    request: PutPipelineDefinitionRequest
  ): DataPipelineIO[PutPipelineDefinitionResponse] =
    FF.liftF(PutPipelineDefinitionOp(request))

  def queryObjects(
    request: QueryObjectsRequest
  ): DataPipelineIO[QueryObjectsResponse] =
    FF.liftF(QueryObjectsOp(request))

  def removeTags(
    request: RemoveTagsRequest
  ): DataPipelineIO[RemoveTagsResponse] =
    FF.liftF(RemoveTagsOp(request))

  def reportTaskProgress(
    request: ReportTaskProgressRequest
  ): DataPipelineIO[ReportTaskProgressResponse] =
    FF.liftF(ReportTaskProgressOp(request))

  def reportTaskRunnerHeartbeat(
    request: ReportTaskRunnerHeartbeatRequest
  ): DataPipelineIO[ReportTaskRunnerHeartbeatResponse] =
    FF.liftF(ReportTaskRunnerHeartbeatOp(request))

  def setStatus(
    request: SetStatusRequest
  ): DataPipelineIO[SetStatusResponse] =
    FF.liftF(SetStatusOp(request))

  def setTaskStatus(
    request: SetTaskStatusRequest
  ): DataPipelineIO[SetTaskStatusResponse] =
    FF.liftF(SetTaskStatusOp(request))

  def validatePipelineDefinition(
    request: ValidatePipelineDefinitionRequest
  ): DataPipelineIO[ValidatePipelineDefinitionResponse] =
    FF.liftF(ValidatePipelineDefinitionOp(request))
}
