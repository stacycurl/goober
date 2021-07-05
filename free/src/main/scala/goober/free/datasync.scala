package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.datasync.DataSyncClient
import software.amazon.awssdk.services.datasync.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object datasync { module =>

  // Free monad over DataSyncOp
  type DataSyncIO[A] = FF[DataSyncOp, A]

  sealed trait DataSyncOp[A] {
    def visit[F[_]](visitor: DataSyncOp.Visitor[F]): F[A]
  }

  object DataSyncOp {
    // Given a DataSyncClient we can embed a DataSyncIO program in any algebra that understands embedding.
    implicit val DataSyncOpEmbeddable: Embeddable[DataSyncOp, DataSyncClient] = new Embeddable[DataSyncOp, DataSyncClient] {
      def embed[A](client: DataSyncClient, io: DataSyncIO[A]): Embedded[A] = Embedded.DataSync(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DataSyncOp.Visitor[Kleisli[M, DataSyncClient, *]] {
        def cancelTaskExecution(
          request: CancelTaskExecutionRequest
        ): Kleisli[M, DataSyncClient, CancelTaskExecutionResponse] =
          primitive(_.cancelTaskExecution(request))

        def createAgent(
          request: CreateAgentRequest
        ): Kleisli[M, DataSyncClient, CreateAgentResponse] =
          primitive(_.createAgent(request))

        def createLocationEfs(
          request: CreateLocationEfsRequest
        ): Kleisli[M, DataSyncClient, CreateLocationEfsResponse] =
          primitive(_.createLocationEfs(request))

        def createLocationFsxWindows(
          request: CreateLocationFsxWindowsRequest
        ): Kleisli[M, DataSyncClient, CreateLocationFsxWindowsResponse] =
          primitive(_.createLocationFsxWindows(request))

        def createLocationNfs(
          request: CreateLocationNfsRequest
        ): Kleisli[M, DataSyncClient, CreateLocationNfsResponse] =
          primitive(_.createLocationNfs(request))

        def createLocationObjectStorage(
          request: CreateLocationObjectStorageRequest
        ): Kleisli[M, DataSyncClient, CreateLocationObjectStorageResponse] =
          primitive(_.createLocationObjectStorage(request))

        def createLocationS3(
          request: CreateLocationS3Request
        ): Kleisli[M, DataSyncClient, CreateLocationS3Response] =
          primitive(_.createLocationS3(request))

        def createLocationSmb(
          request: CreateLocationSmbRequest
        ): Kleisli[M, DataSyncClient, CreateLocationSmbResponse] =
          primitive(_.createLocationSmb(request))

        def createTask(
          request: CreateTaskRequest
        ): Kleisli[M, DataSyncClient, CreateTaskResponse] =
          primitive(_.createTask(request))

        def deleteAgent(
          request: DeleteAgentRequest
        ): Kleisli[M, DataSyncClient, DeleteAgentResponse] =
          primitive(_.deleteAgent(request))

        def deleteLocation(
          request: DeleteLocationRequest
        ): Kleisli[M, DataSyncClient, DeleteLocationResponse] =
          primitive(_.deleteLocation(request))

        def deleteTask(
          request: DeleteTaskRequest
        ): Kleisli[M, DataSyncClient, DeleteTaskResponse] =
          primitive(_.deleteTask(request))

        def describeAgent(
          request: DescribeAgentRequest
        ): Kleisli[M, DataSyncClient, DescribeAgentResponse] =
          primitive(_.describeAgent(request))

        def describeLocationEfs(
          request: DescribeLocationEfsRequest
        ): Kleisli[M, DataSyncClient, DescribeLocationEfsResponse] =
          primitive(_.describeLocationEfs(request))

        def describeLocationFsxWindows(
          request: DescribeLocationFsxWindowsRequest
        ): Kleisli[M, DataSyncClient, DescribeLocationFsxWindowsResponse] =
          primitive(_.describeLocationFsxWindows(request))

        def describeLocationNfs(
          request: DescribeLocationNfsRequest
        ): Kleisli[M, DataSyncClient, DescribeLocationNfsResponse] =
          primitive(_.describeLocationNfs(request))

        def describeLocationObjectStorage(
          request: DescribeLocationObjectStorageRequest
        ): Kleisli[M, DataSyncClient, DescribeLocationObjectStorageResponse] =
          primitive(_.describeLocationObjectStorage(request))

        def describeLocationS3(
          request: DescribeLocationS3Request
        ): Kleisli[M, DataSyncClient, DescribeLocationS3Response] =
          primitive(_.describeLocationS3(request))

        def describeLocationSmb(
          request: DescribeLocationSmbRequest
        ): Kleisli[M, DataSyncClient, DescribeLocationSmbResponse] =
          primitive(_.describeLocationSmb(request))

        def describeTask(
          request: DescribeTaskRequest
        ): Kleisli[M, DataSyncClient, DescribeTaskResponse] =
          primitive(_.describeTask(request))

        def describeTaskExecution(
          request: DescribeTaskExecutionRequest
        ): Kleisli[M, DataSyncClient, DescribeTaskExecutionResponse] =
          primitive(_.describeTaskExecution(request))

        def listAgents(
          request: ListAgentsRequest
        ): Kleisli[M, DataSyncClient, ListAgentsResponse] =
          primitive(_.listAgents(request))

        def listLocations(
          request: ListLocationsRequest
        ): Kleisli[M, DataSyncClient, ListLocationsResponse] =
          primitive(_.listLocations(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DataSyncClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTaskExecutions(
          request: ListTaskExecutionsRequest
        ): Kleisli[M, DataSyncClient, ListTaskExecutionsResponse] =
          primitive(_.listTaskExecutions(request))

        def listTasks(
          request: ListTasksRequest
        ): Kleisli[M, DataSyncClient, ListTasksResponse] =
          primitive(_.listTasks(request))

        def startTaskExecution(
          request: StartTaskExecutionRequest
        ): Kleisli[M, DataSyncClient, StartTaskExecutionResponse] =
          primitive(_.startTaskExecution(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DataSyncClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DataSyncClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAgent(
          request: UpdateAgentRequest
        ): Kleisli[M, DataSyncClient, UpdateAgentResponse] =
          primitive(_.updateAgent(request))

        def updateLocationNfs(
          request: UpdateLocationNfsRequest
        ): Kleisli[M, DataSyncClient, UpdateLocationNfsResponse] =
          primitive(_.updateLocationNfs(request))

        def updateLocationObjectStorage(
          request: UpdateLocationObjectStorageRequest
        ): Kleisli[M, DataSyncClient, UpdateLocationObjectStorageResponse] =
          primitive(_.updateLocationObjectStorage(request))

        def updateLocationSmb(
          request: UpdateLocationSmbRequest
        ): Kleisli[M, DataSyncClient, UpdateLocationSmbResponse] =
          primitive(_.updateLocationSmb(request))

        def updateTask(
          request: UpdateTaskRequest
        ): Kleisli[M, DataSyncClient, UpdateTaskResponse] =
          primitive(_.updateTask(request))

        def updateTaskExecution(
          request: UpdateTaskExecutionRequest
        ): Kleisli[M, DataSyncClient, UpdateTaskExecutionResponse] =
          primitive(_.updateTaskExecution(request))

        def primitive[A](
          f: DataSyncClient => A
        ): Kleisli[M, DataSyncClient, A]
      }
    }

    trait Visitor[F[_]] extends (DataSyncOp ~> F) {
      final def apply[A](op: DataSyncOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelTaskExecution(
        request: CancelTaskExecutionRequest
      ): F[CancelTaskExecutionResponse]

      def createAgent(
        request: CreateAgentRequest
      ): F[CreateAgentResponse]

      def createLocationEfs(
        request: CreateLocationEfsRequest
      ): F[CreateLocationEfsResponse]

      def createLocationFsxWindows(
        request: CreateLocationFsxWindowsRequest
      ): F[CreateLocationFsxWindowsResponse]

      def createLocationNfs(
        request: CreateLocationNfsRequest
      ): F[CreateLocationNfsResponse]

      def createLocationObjectStorage(
        request: CreateLocationObjectStorageRequest
      ): F[CreateLocationObjectStorageResponse]

      def createLocationS3(
        request: CreateLocationS3Request
      ): F[CreateLocationS3Response]

      def createLocationSmb(
        request: CreateLocationSmbRequest
      ): F[CreateLocationSmbResponse]

      def createTask(
        request: CreateTaskRequest
      ): F[CreateTaskResponse]

      def deleteAgent(
        request: DeleteAgentRequest
      ): F[DeleteAgentResponse]

      def deleteLocation(
        request: DeleteLocationRequest
      ): F[DeleteLocationResponse]

      def deleteTask(
        request: DeleteTaskRequest
      ): F[DeleteTaskResponse]

      def describeAgent(
        request: DescribeAgentRequest
      ): F[DescribeAgentResponse]

      def describeLocationEfs(
        request: DescribeLocationEfsRequest
      ): F[DescribeLocationEfsResponse]

      def describeLocationFsxWindows(
        request: DescribeLocationFsxWindowsRequest
      ): F[DescribeLocationFsxWindowsResponse]

      def describeLocationNfs(
        request: DescribeLocationNfsRequest
      ): F[DescribeLocationNfsResponse]

      def describeLocationObjectStorage(
        request: DescribeLocationObjectStorageRequest
      ): F[DescribeLocationObjectStorageResponse]

      def describeLocationS3(
        request: DescribeLocationS3Request
      ): F[DescribeLocationS3Response]

      def describeLocationSmb(
        request: DescribeLocationSmbRequest
      ): F[DescribeLocationSmbResponse]

      def describeTask(
        request: DescribeTaskRequest
      ): F[DescribeTaskResponse]

      def describeTaskExecution(
        request: DescribeTaskExecutionRequest
      ): F[DescribeTaskExecutionResponse]

      def listAgents(
        request: ListAgentsRequest
      ): F[ListAgentsResponse]

      def listLocations(
        request: ListLocationsRequest
      ): F[ListLocationsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTaskExecutions(
        request: ListTaskExecutionsRequest
      ): F[ListTaskExecutionsResponse]

      def listTasks(
        request: ListTasksRequest
      ): F[ListTasksResponse]

      def startTaskExecution(
        request: StartTaskExecutionRequest
      ): F[StartTaskExecutionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAgent(
        request: UpdateAgentRequest
      ): F[UpdateAgentResponse]

      def updateLocationNfs(
        request: UpdateLocationNfsRequest
      ): F[UpdateLocationNfsResponse]

      def updateLocationObjectStorage(
        request: UpdateLocationObjectStorageRequest
      ): F[UpdateLocationObjectStorageResponse]

      def updateLocationSmb(
        request: UpdateLocationSmbRequest
      ): F[UpdateLocationSmbResponse]

      def updateTask(
        request: UpdateTaskRequest
      ): F[UpdateTaskResponse]

      def updateTaskExecution(
        request: UpdateTaskExecutionRequest
      ): F[UpdateTaskExecutionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DataSyncOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelTaskExecutionOp(
      request: CancelTaskExecutionRequest
    ) extends DataSyncOp[CancelTaskExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelTaskExecutionResponse] =
        visitor.cancelTaskExecution(request)
    }

    final case class CreateAgentOp(
      request: CreateAgentRequest
    ) extends DataSyncOp[CreateAgentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAgentResponse] =
        visitor.createAgent(request)
    }

    final case class CreateLocationEfsOp(
      request: CreateLocationEfsRequest
    ) extends DataSyncOp[CreateLocationEfsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocationEfsResponse] =
        visitor.createLocationEfs(request)
    }

    final case class CreateLocationFsxWindowsOp(
      request: CreateLocationFsxWindowsRequest
    ) extends DataSyncOp[CreateLocationFsxWindowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocationFsxWindowsResponse] =
        visitor.createLocationFsxWindows(request)
    }

    final case class CreateLocationNfsOp(
      request: CreateLocationNfsRequest
    ) extends DataSyncOp[CreateLocationNfsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocationNfsResponse] =
        visitor.createLocationNfs(request)
    }

    final case class CreateLocationObjectStorageOp(
      request: CreateLocationObjectStorageRequest
    ) extends DataSyncOp[CreateLocationObjectStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocationObjectStorageResponse] =
        visitor.createLocationObjectStorage(request)
    }

    final case class CreateLocationS3Op(
      request: CreateLocationS3Request
    ) extends DataSyncOp[CreateLocationS3Response] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocationS3Response] =
        visitor.createLocationS3(request)
    }

    final case class CreateLocationSmbOp(
      request: CreateLocationSmbRequest
    ) extends DataSyncOp[CreateLocationSmbResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLocationSmbResponse] =
        visitor.createLocationSmb(request)
    }

    final case class CreateTaskOp(
      request: CreateTaskRequest
    ) extends DataSyncOp[CreateTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTaskResponse] =
        visitor.createTask(request)
    }

    final case class DeleteAgentOp(
      request: DeleteAgentRequest
    ) extends DataSyncOp[DeleteAgentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAgentResponse] =
        visitor.deleteAgent(request)
    }

    final case class DeleteLocationOp(
      request: DeleteLocationRequest
    ) extends DataSyncOp[DeleteLocationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLocationResponse] =
        visitor.deleteLocation(request)
    }

    final case class DeleteTaskOp(
      request: DeleteTaskRequest
    ) extends DataSyncOp[DeleteTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTaskResponse] =
        visitor.deleteTask(request)
    }

    final case class DescribeAgentOp(
      request: DescribeAgentRequest
    ) extends DataSyncOp[DescribeAgentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAgentResponse] =
        visitor.describeAgent(request)
    }

    final case class DescribeLocationEfsOp(
      request: DescribeLocationEfsRequest
    ) extends DataSyncOp[DescribeLocationEfsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationEfsResponse] =
        visitor.describeLocationEfs(request)
    }

    final case class DescribeLocationFsxWindowsOp(
      request: DescribeLocationFsxWindowsRequest
    ) extends DataSyncOp[DescribeLocationFsxWindowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationFsxWindowsResponse] =
        visitor.describeLocationFsxWindows(request)
    }

    final case class DescribeLocationNfsOp(
      request: DescribeLocationNfsRequest
    ) extends DataSyncOp[DescribeLocationNfsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationNfsResponse] =
        visitor.describeLocationNfs(request)
    }

    final case class DescribeLocationObjectStorageOp(
      request: DescribeLocationObjectStorageRequest
    ) extends DataSyncOp[DescribeLocationObjectStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationObjectStorageResponse] =
        visitor.describeLocationObjectStorage(request)
    }

    final case class DescribeLocationS3Op(
      request: DescribeLocationS3Request
    ) extends DataSyncOp[DescribeLocationS3Response] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationS3Response] =
        visitor.describeLocationS3(request)
    }

    final case class DescribeLocationSmbOp(
      request: DescribeLocationSmbRequest
    ) extends DataSyncOp[DescribeLocationSmbResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLocationSmbResponse] =
        visitor.describeLocationSmb(request)
    }

    final case class DescribeTaskOp(
      request: DescribeTaskRequest
    ) extends DataSyncOp[DescribeTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTaskResponse] =
        visitor.describeTask(request)
    }

    final case class DescribeTaskExecutionOp(
      request: DescribeTaskExecutionRequest
    ) extends DataSyncOp[DescribeTaskExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTaskExecutionResponse] =
        visitor.describeTaskExecution(request)
    }

    final case class ListAgentsOp(
      request: ListAgentsRequest
    ) extends DataSyncOp[ListAgentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAgentsResponse] =
        visitor.listAgents(request)
    }

    final case class ListLocationsOp(
      request: ListLocationsRequest
    ) extends DataSyncOp[ListLocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLocationsResponse] =
        visitor.listLocations(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DataSyncOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTaskExecutionsOp(
      request: ListTaskExecutionsRequest
    ) extends DataSyncOp[ListTaskExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTaskExecutionsResponse] =
        visitor.listTaskExecutions(request)
    }

    final case class ListTasksOp(
      request: ListTasksRequest
    ) extends DataSyncOp[ListTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTasksResponse] =
        visitor.listTasks(request)
    }

    final case class StartTaskExecutionOp(
      request: StartTaskExecutionRequest
    ) extends DataSyncOp[StartTaskExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTaskExecutionResponse] =
        visitor.startTaskExecution(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DataSyncOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DataSyncOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAgentOp(
      request: UpdateAgentRequest
    ) extends DataSyncOp[UpdateAgentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAgentResponse] =
        visitor.updateAgent(request)
    }

    final case class UpdateLocationNfsOp(
      request: UpdateLocationNfsRequest
    ) extends DataSyncOp[UpdateLocationNfsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLocationNfsResponse] =
        visitor.updateLocationNfs(request)
    }

    final case class UpdateLocationObjectStorageOp(
      request: UpdateLocationObjectStorageRequest
    ) extends DataSyncOp[UpdateLocationObjectStorageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLocationObjectStorageResponse] =
        visitor.updateLocationObjectStorage(request)
    }

    final case class UpdateLocationSmbOp(
      request: UpdateLocationSmbRequest
    ) extends DataSyncOp[UpdateLocationSmbResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLocationSmbResponse] =
        visitor.updateLocationSmb(request)
    }

    final case class UpdateTaskOp(
      request: UpdateTaskRequest
    ) extends DataSyncOp[UpdateTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTaskResponse] =
        visitor.updateTask(request)
    }

    final case class UpdateTaskExecutionOp(
      request: UpdateTaskExecutionRequest
    ) extends DataSyncOp[UpdateTaskExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTaskExecutionResponse] =
        visitor.updateTaskExecution(request)
    }
  }

  import DataSyncOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DataSyncOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelTaskExecution(
    request: CancelTaskExecutionRequest
  ): DataSyncIO[CancelTaskExecutionResponse] =
    FF.liftF(CancelTaskExecutionOp(request))

  def createAgent(
    request: CreateAgentRequest
  ): DataSyncIO[CreateAgentResponse] =
    FF.liftF(CreateAgentOp(request))

  def createLocationEfs(
    request: CreateLocationEfsRequest
  ): DataSyncIO[CreateLocationEfsResponse] =
    FF.liftF(CreateLocationEfsOp(request))

  def createLocationFsxWindows(
    request: CreateLocationFsxWindowsRequest
  ): DataSyncIO[CreateLocationFsxWindowsResponse] =
    FF.liftF(CreateLocationFsxWindowsOp(request))

  def createLocationNfs(
    request: CreateLocationNfsRequest
  ): DataSyncIO[CreateLocationNfsResponse] =
    FF.liftF(CreateLocationNfsOp(request))

  def createLocationObjectStorage(
    request: CreateLocationObjectStorageRequest
  ): DataSyncIO[CreateLocationObjectStorageResponse] =
    FF.liftF(CreateLocationObjectStorageOp(request))

  def createLocationS3(
    request: CreateLocationS3Request
  ): DataSyncIO[CreateLocationS3Response] =
    FF.liftF(CreateLocationS3Op(request))

  def createLocationSmb(
    request: CreateLocationSmbRequest
  ): DataSyncIO[CreateLocationSmbResponse] =
    FF.liftF(CreateLocationSmbOp(request))

  def createTask(
    request: CreateTaskRequest
  ): DataSyncIO[CreateTaskResponse] =
    FF.liftF(CreateTaskOp(request))

  def deleteAgent(
    request: DeleteAgentRequest
  ): DataSyncIO[DeleteAgentResponse] =
    FF.liftF(DeleteAgentOp(request))

  def deleteLocation(
    request: DeleteLocationRequest
  ): DataSyncIO[DeleteLocationResponse] =
    FF.liftF(DeleteLocationOp(request))

  def deleteTask(
    request: DeleteTaskRequest
  ): DataSyncIO[DeleteTaskResponse] =
    FF.liftF(DeleteTaskOp(request))

  def describeAgent(
    request: DescribeAgentRequest
  ): DataSyncIO[DescribeAgentResponse] =
    FF.liftF(DescribeAgentOp(request))

  def describeLocationEfs(
    request: DescribeLocationEfsRequest
  ): DataSyncIO[DescribeLocationEfsResponse] =
    FF.liftF(DescribeLocationEfsOp(request))

  def describeLocationFsxWindows(
    request: DescribeLocationFsxWindowsRequest
  ): DataSyncIO[DescribeLocationFsxWindowsResponse] =
    FF.liftF(DescribeLocationFsxWindowsOp(request))

  def describeLocationNfs(
    request: DescribeLocationNfsRequest
  ): DataSyncIO[DescribeLocationNfsResponse] =
    FF.liftF(DescribeLocationNfsOp(request))

  def describeLocationObjectStorage(
    request: DescribeLocationObjectStorageRequest
  ): DataSyncIO[DescribeLocationObjectStorageResponse] =
    FF.liftF(DescribeLocationObjectStorageOp(request))

  def describeLocationS3(
    request: DescribeLocationS3Request
  ): DataSyncIO[DescribeLocationS3Response] =
    FF.liftF(DescribeLocationS3Op(request))

  def describeLocationSmb(
    request: DescribeLocationSmbRequest
  ): DataSyncIO[DescribeLocationSmbResponse] =
    FF.liftF(DescribeLocationSmbOp(request))

  def describeTask(
    request: DescribeTaskRequest
  ): DataSyncIO[DescribeTaskResponse] =
    FF.liftF(DescribeTaskOp(request))

  def describeTaskExecution(
    request: DescribeTaskExecutionRequest
  ): DataSyncIO[DescribeTaskExecutionResponse] =
    FF.liftF(DescribeTaskExecutionOp(request))

  def listAgents(
    request: ListAgentsRequest
  ): DataSyncIO[ListAgentsResponse] =
    FF.liftF(ListAgentsOp(request))

  def listLocations(
    request: ListLocationsRequest
  ): DataSyncIO[ListLocationsResponse] =
    FF.liftF(ListLocationsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DataSyncIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTaskExecutions(
    request: ListTaskExecutionsRequest
  ): DataSyncIO[ListTaskExecutionsResponse] =
    FF.liftF(ListTaskExecutionsOp(request))

  def listTasks(
    request: ListTasksRequest
  ): DataSyncIO[ListTasksResponse] =
    FF.liftF(ListTasksOp(request))

  def startTaskExecution(
    request: StartTaskExecutionRequest
  ): DataSyncIO[StartTaskExecutionResponse] =
    FF.liftF(StartTaskExecutionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DataSyncIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DataSyncIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAgent(
    request: UpdateAgentRequest
  ): DataSyncIO[UpdateAgentResponse] =
    FF.liftF(UpdateAgentOp(request))

  def updateLocationNfs(
    request: UpdateLocationNfsRequest
  ): DataSyncIO[UpdateLocationNfsResponse] =
    FF.liftF(UpdateLocationNfsOp(request))

  def updateLocationObjectStorage(
    request: UpdateLocationObjectStorageRequest
  ): DataSyncIO[UpdateLocationObjectStorageResponse] =
    FF.liftF(UpdateLocationObjectStorageOp(request))

  def updateLocationSmb(
    request: UpdateLocationSmbRequest
  ): DataSyncIO[UpdateLocationSmbResponse] =
    FF.liftF(UpdateLocationSmbOp(request))

  def updateTask(
    request: UpdateTaskRequest
  ): DataSyncIO[UpdateTaskResponse] =
    FF.liftF(UpdateTaskOp(request))

  def updateTaskExecution(
    request: UpdateTaskExecutionRequest
  ): DataSyncIO[UpdateTaskExecutionResponse] =
    FF.liftF(UpdateTaskExecutionOp(request))
}
