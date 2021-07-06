package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sfn.SfnClient
import software.amazon.awssdk.services.sfn.model._


object sfn { module =>

  // Free monad over SfnOp
  type SfnIO[A] = FF[SfnOp, A]

  sealed trait SfnOp[A] {
    def visit[F[_]](visitor: SfnOp.Visitor[F]): F[A]
  }

  object SfnOp {
    // Given a SfnClient we can embed a SfnIO program in any algebra that understands embedding.
    implicit val SfnOpEmbeddable: Embeddable[SfnOp, SfnClient] = new Embeddable[SfnOp, SfnClient] {
      def embed[A](client: SfnClient, io: SfnIO[A]): Embedded[A] = Embedded.Sfn(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SfnOp.Visitor[Kleisli[M, SfnClient, *]] {
        def createActivity(
          request: CreateActivityRequest
        ): Kleisli[M, SfnClient, CreateActivityResponse] =
          primitive(_.createActivity(request))

        def createStateMachine(
          request: CreateStateMachineRequest
        ): Kleisli[M, SfnClient, CreateStateMachineResponse] =
          primitive(_.createStateMachine(request))

        def deleteActivity(
          request: DeleteActivityRequest
        ): Kleisli[M, SfnClient, DeleteActivityResponse] =
          primitive(_.deleteActivity(request))

        def deleteStateMachine(
          request: DeleteStateMachineRequest
        ): Kleisli[M, SfnClient, DeleteStateMachineResponse] =
          primitive(_.deleteStateMachine(request))

        def describeActivity(
          request: DescribeActivityRequest
        ): Kleisli[M, SfnClient, DescribeActivityResponse] =
          primitive(_.describeActivity(request))

        def describeExecution(
          request: DescribeExecutionRequest
        ): Kleisli[M, SfnClient, DescribeExecutionResponse] =
          primitive(_.describeExecution(request))

        def describeStateMachine(
          request: DescribeStateMachineRequest
        ): Kleisli[M, SfnClient, DescribeStateMachineResponse] =
          primitive(_.describeStateMachine(request))

        def describeStateMachineForExecution(
          request: DescribeStateMachineForExecutionRequest
        ): Kleisli[M, SfnClient, DescribeStateMachineForExecutionResponse] =
          primitive(_.describeStateMachineForExecution(request))

        def getActivityTask(
          request: GetActivityTaskRequest
        ): Kleisli[M, SfnClient, GetActivityTaskResponse] =
          primitive(_.getActivityTask(request))

        def getExecutionHistory(
          request: GetExecutionHistoryRequest
        ): Kleisli[M, SfnClient, GetExecutionHistoryResponse] =
          primitive(_.getExecutionHistory(request))

        def listActivities(
          request: ListActivitiesRequest
        ): Kleisli[M, SfnClient, ListActivitiesResponse] =
          primitive(_.listActivities(request))

        def listExecutions(
          request: ListExecutionsRequest
        ): Kleisli[M, SfnClient, ListExecutionsResponse] =
          primitive(_.listExecutions(request))

        def listStateMachines(
          request: ListStateMachinesRequest
        ): Kleisli[M, SfnClient, ListStateMachinesResponse] =
          primitive(_.listStateMachines(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, SfnClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def sendTaskFailure(
          request: SendTaskFailureRequest
        ): Kleisli[M, SfnClient, SendTaskFailureResponse] =
          primitive(_.sendTaskFailure(request))

        def sendTaskHeartbeat(
          request: SendTaskHeartbeatRequest
        ): Kleisli[M, SfnClient, SendTaskHeartbeatResponse] =
          primitive(_.sendTaskHeartbeat(request))

        def sendTaskSuccess(
          request: SendTaskSuccessRequest
        ): Kleisli[M, SfnClient, SendTaskSuccessResponse] =
          primitive(_.sendTaskSuccess(request))

        def startExecution(
          request: StartExecutionRequest
        ): Kleisli[M, SfnClient, StartExecutionResponse] =
          primitive(_.startExecution(request))

        def startSyncExecution(
          request: StartSyncExecutionRequest
        ): Kleisli[M, SfnClient, StartSyncExecutionResponse] =
          primitive(_.startSyncExecution(request))

        def stopExecution(
          request: StopExecutionRequest
        ): Kleisli[M, SfnClient, StopExecutionResponse] =
          primitive(_.stopExecution(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, SfnClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, SfnClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateStateMachine(
          request: UpdateStateMachineRequest
        ): Kleisli[M, SfnClient, UpdateStateMachineResponse] =
          primitive(_.updateStateMachine(request))

        def primitive[A](
          f: SfnClient => A
        ): Kleisli[M, SfnClient, A]
      }
    }

    trait Visitor[F[_]] extends (SfnOp ~> F) {
      final def apply[A](op: SfnOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createActivity(
        request: CreateActivityRequest
      ): F[CreateActivityResponse]

      def createStateMachine(
        request: CreateStateMachineRequest
      ): F[CreateStateMachineResponse]

      def deleteActivity(
        request: DeleteActivityRequest
      ): F[DeleteActivityResponse]

      def deleteStateMachine(
        request: DeleteStateMachineRequest
      ): F[DeleteStateMachineResponse]

      def describeActivity(
        request: DescribeActivityRequest
      ): F[DescribeActivityResponse]

      def describeExecution(
        request: DescribeExecutionRequest
      ): F[DescribeExecutionResponse]

      def describeStateMachine(
        request: DescribeStateMachineRequest
      ): F[DescribeStateMachineResponse]

      def describeStateMachineForExecution(
        request: DescribeStateMachineForExecutionRequest
      ): F[DescribeStateMachineForExecutionResponse]

      def getActivityTask(
        request: GetActivityTaskRequest
      ): F[GetActivityTaskResponse]

      def getExecutionHistory(
        request: GetExecutionHistoryRequest
      ): F[GetExecutionHistoryResponse]

      def listActivities(
        request: ListActivitiesRequest
      ): F[ListActivitiesResponse]

      def listExecutions(
        request: ListExecutionsRequest
      ): F[ListExecutionsResponse]

      def listStateMachines(
        request: ListStateMachinesRequest
      ): F[ListStateMachinesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def sendTaskFailure(
        request: SendTaskFailureRequest
      ): F[SendTaskFailureResponse]

      def sendTaskHeartbeat(
        request: SendTaskHeartbeatRequest
      ): F[SendTaskHeartbeatResponse]

      def sendTaskSuccess(
        request: SendTaskSuccessRequest
      ): F[SendTaskSuccessResponse]

      def startExecution(
        request: StartExecutionRequest
      ): F[StartExecutionResponse]

      def startSyncExecution(
        request: StartSyncExecutionRequest
      ): F[StartSyncExecutionResponse]

      def stopExecution(
        request: StopExecutionRequest
      ): F[StopExecutionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateStateMachine(
        request: UpdateStateMachineRequest
      ): F[UpdateStateMachineResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SfnOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateActivityOp(
      request: CreateActivityRequest
    ) extends SfnOp[CreateActivityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateActivityResponse] =
        visitor.createActivity(request)
    }

    final case class CreateStateMachineOp(
      request: CreateStateMachineRequest
    ) extends SfnOp[CreateStateMachineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStateMachineResponse] =
        visitor.createStateMachine(request)
    }

    final case class DeleteActivityOp(
      request: DeleteActivityRequest
    ) extends SfnOp[DeleteActivityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteActivityResponse] =
        visitor.deleteActivity(request)
    }

    final case class DeleteStateMachineOp(
      request: DeleteStateMachineRequest
    ) extends SfnOp[DeleteStateMachineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStateMachineResponse] =
        visitor.deleteStateMachine(request)
    }

    final case class DescribeActivityOp(
      request: DescribeActivityRequest
    ) extends SfnOp[DescribeActivityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeActivityResponse] =
        visitor.describeActivity(request)
    }

    final case class DescribeExecutionOp(
      request: DescribeExecutionRequest
    ) extends SfnOp[DescribeExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExecutionResponse] =
        visitor.describeExecution(request)
    }

    final case class DescribeStateMachineOp(
      request: DescribeStateMachineRequest
    ) extends SfnOp[DescribeStateMachineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStateMachineResponse] =
        visitor.describeStateMachine(request)
    }

    final case class DescribeStateMachineForExecutionOp(
      request: DescribeStateMachineForExecutionRequest
    ) extends SfnOp[DescribeStateMachineForExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStateMachineForExecutionResponse] =
        visitor.describeStateMachineForExecution(request)
    }

    final case class GetActivityTaskOp(
      request: GetActivityTaskRequest
    ) extends SfnOp[GetActivityTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetActivityTaskResponse] =
        visitor.getActivityTask(request)
    }

    final case class GetExecutionHistoryOp(
      request: GetExecutionHistoryRequest
    ) extends SfnOp[GetExecutionHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExecutionHistoryResponse] =
        visitor.getExecutionHistory(request)
    }

    final case class ListActivitiesOp(
      request: ListActivitiesRequest
    ) extends SfnOp[ListActivitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListActivitiesResponse] =
        visitor.listActivities(request)
    }

    final case class ListExecutionsOp(
      request: ListExecutionsRequest
    ) extends SfnOp[ListExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExecutionsResponse] =
        visitor.listExecutions(request)
    }

    final case class ListStateMachinesOp(
      request: ListStateMachinesRequest
    ) extends SfnOp[ListStateMachinesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStateMachinesResponse] =
        visitor.listStateMachines(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends SfnOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class SendTaskFailureOp(
      request: SendTaskFailureRequest
    ) extends SfnOp[SendTaskFailureResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendTaskFailureResponse] =
        visitor.sendTaskFailure(request)
    }

    final case class SendTaskHeartbeatOp(
      request: SendTaskHeartbeatRequest
    ) extends SfnOp[SendTaskHeartbeatResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendTaskHeartbeatResponse] =
        visitor.sendTaskHeartbeat(request)
    }

    final case class SendTaskSuccessOp(
      request: SendTaskSuccessRequest
    ) extends SfnOp[SendTaskSuccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendTaskSuccessResponse] =
        visitor.sendTaskSuccess(request)
    }

    final case class StartExecutionOp(
      request: StartExecutionRequest
    ) extends SfnOp[StartExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartExecutionResponse] =
        visitor.startExecution(request)
    }

    final case class StartSyncExecutionOp(
      request: StartSyncExecutionRequest
    ) extends SfnOp[StartSyncExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSyncExecutionResponse] =
        visitor.startSyncExecution(request)
    }

    final case class StopExecutionOp(
      request: StopExecutionRequest
    ) extends SfnOp[StopExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopExecutionResponse] =
        visitor.stopExecution(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends SfnOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends SfnOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateStateMachineOp(
      request: UpdateStateMachineRequest
    ) extends SfnOp[UpdateStateMachineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStateMachineResponse] =
        visitor.updateStateMachine(request)
    }
  }

  import SfnOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SfnOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createActivity(
    request: CreateActivityRequest
  ): SfnIO[CreateActivityResponse] =
    FF.liftF(CreateActivityOp(request))

  def createStateMachine(
    request: CreateStateMachineRequest
  ): SfnIO[CreateStateMachineResponse] =
    FF.liftF(CreateStateMachineOp(request))

  def deleteActivity(
    request: DeleteActivityRequest
  ): SfnIO[DeleteActivityResponse] =
    FF.liftF(DeleteActivityOp(request))

  def deleteStateMachine(
    request: DeleteStateMachineRequest
  ): SfnIO[DeleteStateMachineResponse] =
    FF.liftF(DeleteStateMachineOp(request))

  def describeActivity(
    request: DescribeActivityRequest
  ): SfnIO[DescribeActivityResponse] =
    FF.liftF(DescribeActivityOp(request))

  def describeExecution(
    request: DescribeExecutionRequest
  ): SfnIO[DescribeExecutionResponse] =
    FF.liftF(DescribeExecutionOp(request))

  def describeStateMachine(
    request: DescribeStateMachineRequest
  ): SfnIO[DescribeStateMachineResponse] =
    FF.liftF(DescribeStateMachineOp(request))

  def describeStateMachineForExecution(
    request: DescribeStateMachineForExecutionRequest
  ): SfnIO[DescribeStateMachineForExecutionResponse] =
    FF.liftF(DescribeStateMachineForExecutionOp(request))

  def getActivityTask(
    request: GetActivityTaskRequest
  ): SfnIO[GetActivityTaskResponse] =
    FF.liftF(GetActivityTaskOp(request))

  def getExecutionHistory(
    request: GetExecutionHistoryRequest
  ): SfnIO[GetExecutionHistoryResponse] =
    FF.liftF(GetExecutionHistoryOp(request))

  def listActivities(
    request: ListActivitiesRequest
  ): SfnIO[ListActivitiesResponse] =
    FF.liftF(ListActivitiesOp(request))

  def listExecutions(
    request: ListExecutionsRequest
  ): SfnIO[ListExecutionsResponse] =
    FF.liftF(ListExecutionsOp(request))

  def listStateMachines(
    request: ListStateMachinesRequest
  ): SfnIO[ListStateMachinesResponse] =
    FF.liftF(ListStateMachinesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): SfnIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def sendTaskFailure(
    request: SendTaskFailureRequest
  ): SfnIO[SendTaskFailureResponse] =
    FF.liftF(SendTaskFailureOp(request))

  def sendTaskHeartbeat(
    request: SendTaskHeartbeatRequest
  ): SfnIO[SendTaskHeartbeatResponse] =
    FF.liftF(SendTaskHeartbeatOp(request))

  def sendTaskSuccess(
    request: SendTaskSuccessRequest
  ): SfnIO[SendTaskSuccessResponse] =
    FF.liftF(SendTaskSuccessOp(request))

  def startExecution(
    request: StartExecutionRequest
  ): SfnIO[StartExecutionResponse] =
    FF.liftF(StartExecutionOp(request))

  def startSyncExecution(
    request: StartSyncExecutionRequest
  ): SfnIO[StartSyncExecutionResponse] =
    FF.liftF(StartSyncExecutionOp(request))

  def stopExecution(
    request: StopExecutionRequest
  ): SfnIO[StopExecutionResponse] =
    FF.liftF(StopExecutionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): SfnIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): SfnIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateStateMachine(
    request: UpdateStateMachineRequest
  ): SfnIO[UpdateStateMachineResponse] =
    FF.liftF(UpdateStateMachineOp(request))
}
