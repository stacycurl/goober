package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotjobsdataplane.IotJobsDataPlaneClient
import software.amazon.awssdk.services.iotjobsdataplane.model._


object iotjobsdataplane { module =>

  // Free monad over IotJobsDataPlaneOp
  type IotJobsDataPlaneIO[A] = FF[IotJobsDataPlaneOp, A]

  sealed trait IotJobsDataPlaneOp[A] {
    def visit[F[_]](visitor: IotJobsDataPlaneOp.Visitor[F]): F[A]
  }

  object IotJobsDataPlaneOp {
    // Given a IotJobsDataPlaneClient we can embed a IotJobsDataPlaneIO program in any algebra that understands embedding.
    implicit val IotJobsDataPlaneOpEmbeddable: Embeddable[IotJobsDataPlaneOp, IotJobsDataPlaneClient] = new Embeddable[IotJobsDataPlaneOp, IotJobsDataPlaneClient] {
      def embed[A](client: IotJobsDataPlaneClient, io: IotJobsDataPlaneIO[A]): Embedded[A] = Embedded.IotJobsDataPlane(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotJobsDataPlaneOp.Visitor[Kleisli[M, IotJobsDataPlaneClient, *]] {
        def describeJobExecution(
          request: DescribeJobExecutionRequest
        ): Kleisli[M, IotJobsDataPlaneClient, DescribeJobExecutionResponse] =
          primitive(_.describeJobExecution(request))

        def getPendingJobExecutions(
          request: GetPendingJobExecutionsRequest
        ): Kleisli[M, IotJobsDataPlaneClient, GetPendingJobExecutionsResponse] =
          primitive(_.getPendingJobExecutions(request))

        def startNextPendingJobExecution(
          request: StartNextPendingJobExecutionRequest
        ): Kleisli[M, IotJobsDataPlaneClient, StartNextPendingJobExecutionResponse] =
          primitive(_.startNextPendingJobExecution(request))

        def updateJobExecution(
          request: UpdateJobExecutionRequest
        ): Kleisli[M, IotJobsDataPlaneClient, UpdateJobExecutionResponse] =
          primitive(_.updateJobExecution(request))

        def primitive[A](
          f: IotJobsDataPlaneClient => A
        ): Kleisli[M, IotJobsDataPlaneClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotJobsDataPlaneOp ~> F) {
      final def apply[A](op: IotJobsDataPlaneOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeJobExecution(
        request: DescribeJobExecutionRequest
      ): F[DescribeJobExecutionResponse]

      def getPendingJobExecutions(
        request: GetPendingJobExecutionsRequest
      ): F[GetPendingJobExecutionsResponse]

      def startNextPendingJobExecution(
        request: StartNextPendingJobExecutionRequest
      ): F[StartNextPendingJobExecutionResponse]

      def updateJobExecution(
        request: UpdateJobExecutionRequest
      ): F[UpdateJobExecutionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotJobsDataPlaneOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeJobExecutionOp(
      request: DescribeJobExecutionRequest
    ) extends IotJobsDataPlaneOp[DescribeJobExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobExecutionResponse] =
        visitor.describeJobExecution(request)
    }

    final case class GetPendingJobExecutionsOp(
      request: GetPendingJobExecutionsRequest
    ) extends IotJobsDataPlaneOp[GetPendingJobExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPendingJobExecutionsResponse] =
        visitor.getPendingJobExecutions(request)
    }

    final case class StartNextPendingJobExecutionOp(
      request: StartNextPendingJobExecutionRequest
    ) extends IotJobsDataPlaneOp[StartNextPendingJobExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartNextPendingJobExecutionResponse] =
        visitor.startNextPendingJobExecution(request)
    }

    final case class UpdateJobExecutionOp(
      request: UpdateJobExecutionRequest
    ) extends IotJobsDataPlaneOp[UpdateJobExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateJobExecutionResponse] =
        visitor.updateJobExecution(request)
    }
  }

  import IotJobsDataPlaneOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotJobsDataPlaneOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeJobExecution(
    request: DescribeJobExecutionRequest
  ): IotJobsDataPlaneIO[DescribeJobExecutionResponse] =
    FF.liftF(DescribeJobExecutionOp(request))

  def getPendingJobExecutions(
    request: GetPendingJobExecutionsRequest
  ): IotJobsDataPlaneIO[GetPendingJobExecutionsResponse] =
    FF.liftF(GetPendingJobExecutionsOp(request))

  def startNextPendingJobExecution(
    request: StartNextPendingJobExecutionRequest
  ): IotJobsDataPlaneIO[StartNextPendingJobExecutionResponse] =
    FF.liftF(StartNextPendingJobExecutionOp(request))

  def updateJobExecution(
    request: UpdateJobExecutionRequest
  ): IotJobsDataPlaneIO[UpdateJobExecutionResponse] =
    FF.liftF(UpdateJobExecutionOp(request))
}
