package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.batch.BatchClient
import software.amazon.awssdk.services.batch.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object batch { module =>

  // Free monad over BatchOp
  type BatchIO[A] = FF[BatchOp, A]

  sealed trait BatchOp[A] {
    def visit[F[_]](visitor: BatchOp.Visitor[F]): F[A]
  }

  object BatchOp {
    // Given a BatchClient we can embed a BatchIO program in any algebra that understands embedding.
    implicit val BatchOpEmbeddable: Embeddable[BatchOp, BatchClient] = new Embeddable[BatchOp, BatchClient] {
      def embed[A](client: BatchClient, io: BatchIO[A]): Embedded[A] = Embedded.Batch(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends BatchOp.Visitor[Kleisli[M, BatchClient, *]] {
        def cancelJob(
          request: CancelJobRequest
        ): Kleisli[M, BatchClient, CancelJobResponse] =
          primitive(_.cancelJob(request))

        def createComputeEnvironment(
          request: CreateComputeEnvironmentRequest
        ): Kleisli[M, BatchClient, CreateComputeEnvironmentResponse] =
          primitive(_.createComputeEnvironment(request))

        def createJobQueue(
          request: CreateJobQueueRequest
        ): Kleisli[M, BatchClient, CreateJobQueueResponse] =
          primitive(_.createJobQueue(request))

        def deleteComputeEnvironment(
          request: DeleteComputeEnvironmentRequest
        ): Kleisli[M, BatchClient, DeleteComputeEnvironmentResponse] =
          primitive(_.deleteComputeEnvironment(request))

        def deleteJobQueue(
          request: DeleteJobQueueRequest
        ): Kleisli[M, BatchClient, DeleteJobQueueResponse] =
          primitive(_.deleteJobQueue(request))

        def deregisterJobDefinition(
          request: DeregisterJobDefinitionRequest
        ): Kleisli[M, BatchClient, DeregisterJobDefinitionResponse] =
          primitive(_.deregisterJobDefinition(request))

        def describeComputeEnvironments(
          request: DescribeComputeEnvironmentsRequest
        ): Kleisli[M, BatchClient, DescribeComputeEnvironmentsResponse] =
          primitive(_.describeComputeEnvironments(request))

        def describeJobDefinitions(
          request: DescribeJobDefinitionsRequest
        ): Kleisli[M, BatchClient, DescribeJobDefinitionsResponse] =
          primitive(_.describeJobDefinitions(request))

        def describeJobQueues(
          request: DescribeJobQueuesRequest
        ): Kleisli[M, BatchClient, DescribeJobQueuesResponse] =
          primitive(_.describeJobQueues(request))

        def describeJobs(
          request: DescribeJobsRequest
        ): Kleisli[M, BatchClient, DescribeJobsResponse] =
          primitive(_.describeJobs(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, BatchClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, BatchClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def registerJobDefinition(
          request: RegisterJobDefinitionRequest
        ): Kleisli[M, BatchClient, RegisterJobDefinitionResponse] =
          primitive(_.registerJobDefinition(request))

        def submitJob(
          request: SubmitJobRequest
        ): Kleisli[M, BatchClient, SubmitJobResponse] =
          primitive(_.submitJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, BatchClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def terminateJob(
          request: TerminateJobRequest
        ): Kleisli[M, BatchClient, TerminateJobResponse] =
          primitive(_.terminateJob(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, BatchClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateComputeEnvironment(
          request: UpdateComputeEnvironmentRequest
        ): Kleisli[M, BatchClient, UpdateComputeEnvironmentResponse] =
          primitive(_.updateComputeEnvironment(request))

        def updateJobQueue(
          request: UpdateJobQueueRequest
        ): Kleisli[M, BatchClient, UpdateJobQueueResponse] =
          primitive(_.updateJobQueue(request))

        def primitive[A](
          f: BatchClient => A
        ): Kleisli[M, BatchClient, A]
      }
    }

    trait Visitor[F[_]] extends (BatchOp ~> F) {
      final def apply[A](op: BatchOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelJob(
        request: CancelJobRequest
      ): F[CancelJobResponse]

      def createComputeEnvironment(
        request: CreateComputeEnvironmentRequest
      ): F[CreateComputeEnvironmentResponse]

      def createJobQueue(
        request: CreateJobQueueRequest
      ): F[CreateJobQueueResponse]

      def deleteComputeEnvironment(
        request: DeleteComputeEnvironmentRequest
      ): F[DeleteComputeEnvironmentResponse]

      def deleteJobQueue(
        request: DeleteJobQueueRequest
      ): F[DeleteJobQueueResponse]

      def deregisterJobDefinition(
        request: DeregisterJobDefinitionRequest
      ): F[DeregisterJobDefinitionResponse]

      def describeComputeEnvironments(
        request: DescribeComputeEnvironmentsRequest
      ): F[DescribeComputeEnvironmentsResponse]

      def describeJobDefinitions(
        request: DescribeJobDefinitionsRequest
      ): F[DescribeJobDefinitionsResponse]

      def describeJobQueues(
        request: DescribeJobQueuesRequest
      ): F[DescribeJobQueuesResponse]

      def describeJobs(
        request: DescribeJobsRequest
      ): F[DescribeJobsResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def registerJobDefinition(
        request: RegisterJobDefinitionRequest
      ): F[RegisterJobDefinitionResponse]

      def submitJob(
        request: SubmitJobRequest
      ): F[SubmitJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def terminateJob(
        request: TerminateJobRequest
      ): F[TerminateJobResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateComputeEnvironment(
        request: UpdateComputeEnvironmentRequest
      ): F[UpdateComputeEnvironmentResponse]

      def updateJobQueue(
        request: UpdateJobQueueRequest
      ): F[UpdateJobQueueResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends BatchOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelJobOp(
      request: CancelJobRequest
    ) extends BatchOp[CancelJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobResponse] =
        visitor.cancelJob(request)
    }

    final case class CreateComputeEnvironmentOp(
      request: CreateComputeEnvironmentRequest
    ) extends BatchOp[CreateComputeEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateComputeEnvironmentResponse] =
        visitor.createComputeEnvironment(request)
    }

    final case class CreateJobQueueOp(
      request: CreateJobQueueRequest
    ) extends BatchOp[CreateJobQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobQueueResponse] =
        visitor.createJobQueue(request)
    }

    final case class DeleteComputeEnvironmentOp(
      request: DeleteComputeEnvironmentRequest
    ) extends BatchOp[DeleteComputeEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteComputeEnvironmentResponse] =
        visitor.deleteComputeEnvironment(request)
    }

    final case class DeleteJobQueueOp(
      request: DeleteJobQueueRequest
    ) extends BatchOp[DeleteJobQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobQueueResponse] =
        visitor.deleteJobQueue(request)
    }

    final case class DeregisterJobDefinitionOp(
      request: DeregisterJobDefinitionRequest
    ) extends BatchOp[DeregisterJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterJobDefinitionResponse] =
        visitor.deregisterJobDefinition(request)
    }

    final case class DescribeComputeEnvironmentsOp(
      request: DescribeComputeEnvironmentsRequest
    ) extends BatchOp[DescribeComputeEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComputeEnvironmentsResponse] =
        visitor.describeComputeEnvironments(request)
    }

    final case class DescribeJobDefinitionsOp(
      request: DescribeJobDefinitionsRequest
    ) extends BatchOp[DescribeJobDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobDefinitionsResponse] =
        visitor.describeJobDefinitions(request)
    }

    final case class DescribeJobQueuesOp(
      request: DescribeJobQueuesRequest
    ) extends BatchOp[DescribeJobQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobQueuesResponse] =
        visitor.describeJobQueues(request)
    }

    final case class DescribeJobsOp(
      request: DescribeJobsRequest
    ) extends BatchOp[DescribeJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobsResponse] =
        visitor.describeJobs(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends BatchOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends BatchOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RegisterJobDefinitionOp(
      request: RegisterJobDefinitionRequest
    ) extends BatchOp[RegisterJobDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterJobDefinitionResponse] =
        visitor.registerJobDefinition(request)
    }

    final case class SubmitJobOp(
      request: SubmitJobRequest
    ) extends BatchOp[SubmitJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubmitJobResponse] =
        visitor.submitJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends BatchOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TerminateJobOp(
      request: TerminateJobRequest
    ) extends BatchOp[TerminateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateJobResponse] =
        visitor.terminateJob(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends BatchOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateComputeEnvironmentOp(
      request: UpdateComputeEnvironmentRequest
    ) extends BatchOp[UpdateComputeEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateComputeEnvironmentResponse] =
        visitor.updateComputeEnvironment(request)
    }

    final case class UpdateJobQueueOp(
      request: UpdateJobQueueRequest
    ) extends BatchOp[UpdateJobQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobQueueResponse] =
        visitor.updateJobQueue(request)
    }
  }

  import BatchOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[BatchOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelJob(
    request: CancelJobRequest
  ): BatchIO[CancelJobResponse] =
    FF.liftF(CancelJobOp(request))

  def createComputeEnvironment(
    request: CreateComputeEnvironmentRequest
  ): BatchIO[CreateComputeEnvironmentResponse] =
    FF.liftF(CreateComputeEnvironmentOp(request))

  def createJobQueue(
    request: CreateJobQueueRequest
  ): BatchIO[CreateJobQueueResponse] =
    FF.liftF(CreateJobQueueOp(request))

  def deleteComputeEnvironment(
    request: DeleteComputeEnvironmentRequest
  ): BatchIO[DeleteComputeEnvironmentResponse] =
    FF.liftF(DeleteComputeEnvironmentOp(request))

  def deleteJobQueue(
    request: DeleteJobQueueRequest
  ): BatchIO[DeleteJobQueueResponse] =
    FF.liftF(DeleteJobQueueOp(request))

  def deregisterJobDefinition(
    request: DeregisterJobDefinitionRequest
  ): BatchIO[DeregisterJobDefinitionResponse] =
    FF.liftF(DeregisterJobDefinitionOp(request))

  def describeComputeEnvironments(
    request: DescribeComputeEnvironmentsRequest
  ): BatchIO[DescribeComputeEnvironmentsResponse] =
    FF.liftF(DescribeComputeEnvironmentsOp(request))

  def describeJobDefinitions(
    request: DescribeJobDefinitionsRequest
  ): BatchIO[DescribeJobDefinitionsResponse] =
    FF.liftF(DescribeJobDefinitionsOp(request))

  def describeJobQueues(
    request: DescribeJobQueuesRequest
  ): BatchIO[DescribeJobQueuesResponse] =
    FF.liftF(DescribeJobQueuesOp(request))

  def describeJobs(
    request: DescribeJobsRequest
  ): BatchIO[DescribeJobsResponse] =
    FF.liftF(DescribeJobsOp(request))

  def listJobs(
    request: ListJobsRequest
  ): BatchIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): BatchIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def registerJobDefinition(
    request: RegisterJobDefinitionRequest
  ): BatchIO[RegisterJobDefinitionResponse] =
    FF.liftF(RegisterJobDefinitionOp(request))

  def submitJob(
    request: SubmitJobRequest
  ): BatchIO[SubmitJobResponse] =
    FF.liftF(SubmitJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): BatchIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def terminateJob(
    request: TerminateJobRequest
  ): BatchIO[TerminateJobResponse] =
    FF.liftF(TerminateJobOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): BatchIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateComputeEnvironment(
    request: UpdateComputeEnvironmentRequest
  ): BatchIO[UpdateComputeEnvironmentResponse] =
    FF.liftF(UpdateComputeEnvironmentOp(request))

  def updateJobQueue(
    request: UpdateJobQueueRequest
  ): BatchIO[UpdateJobQueueResponse] =
    FF.liftF(UpdateJobQueueOp(request))
}
