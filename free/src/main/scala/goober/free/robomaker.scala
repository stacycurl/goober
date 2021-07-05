package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.robomaker.RoboMakerClient
import software.amazon.awssdk.services.robomaker.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object robomaker { module =>

  // Free monad over RoboMakerOp
  type RoboMakerIO[A] = FF[RoboMakerOp, A]

  sealed trait RoboMakerOp[A] {
    def visit[F[_]](visitor: RoboMakerOp.Visitor[F]): F[A]
  }

  object RoboMakerOp {
    // Given a RoboMakerClient we can embed a RoboMakerIO program in any algebra that understands embedding.
    implicit val RoboMakerOpEmbeddable: Embeddable[RoboMakerOp, RoboMakerClient] = new Embeddable[RoboMakerOp, RoboMakerClient] {
      def embed[A](client: RoboMakerClient, io: RoboMakerIO[A]): Embedded[A] = Embedded.RoboMaker(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RoboMakerOp.Visitor[Kleisli[M, RoboMakerClient, *]] {
        def batchDeleteWorlds(
          request: BatchDeleteWorldsRequest
        ): Kleisli[M, RoboMakerClient, BatchDeleteWorldsResponse] =
          primitive(_.batchDeleteWorlds(request))

        def batchDescribeSimulationJob(
          request: BatchDescribeSimulationJobRequest
        ): Kleisli[M, RoboMakerClient, BatchDescribeSimulationJobResponse] =
          primitive(_.batchDescribeSimulationJob(request))

        def cancelDeploymentJob(
          request: CancelDeploymentJobRequest
        ): Kleisli[M, RoboMakerClient, CancelDeploymentJobResponse] =
          primitive(_.cancelDeploymentJob(request))

        def cancelSimulationJob(
          request: CancelSimulationJobRequest
        ): Kleisli[M, RoboMakerClient, CancelSimulationJobResponse] =
          primitive(_.cancelSimulationJob(request))

        def cancelSimulationJobBatch(
          request: CancelSimulationJobBatchRequest
        ): Kleisli[M, RoboMakerClient, CancelSimulationJobBatchResponse] =
          primitive(_.cancelSimulationJobBatch(request))

        def cancelWorldExportJob(
          request: CancelWorldExportJobRequest
        ): Kleisli[M, RoboMakerClient, CancelWorldExportJobResponse] =
          primitive(_.cancelWorldExportJob(request))

        def cancelWorldGenerationJob(
          request: CancelWorldGenerationJobRequest
        ): Kleisli[M, RoboMakerClient, CancelWorldGenerationJobResponse] =
          primitive(_.cancelWorldGenerationJob(request))

        def createDeploymentJob(
          request: CreateDeploymentJobRequest
        ): Kleisli[M, RoboMakerClient, CreateDeploymentJobResponse] =
          primitive(_.createDeploymentJob(request))

        def createFleet(
          request: CreateFleetRequest
        ): Kleisli[M, RoboMakerClient, CreateFleetResponse] =
          primitive(_.createFleet(request))

        def createRobot(
          request: CreateRobotRequest
        ): Kleisli[M, RoboMakerClient, CreateRobotResponse] =
          primitive(_.createRobot(request))

        def createRobotApplication(
          request: CreateRobotApplicationRequest
        ): Kleisli[M, RoboMakerClient, CreateRobotApplicationResponse] =
          primitive(_.createRobotApplication(request))

        def createRobotApplicationVersion(
          request: CreateRobotApplicationVersionRequest
        ): Kleisli[M, RoboMakerClient, CreateRobotApplicationVersionResponse] =
          primitive(_.createRobotApplicationVersion(request))

        def createSimulationApplication(
          request: CreateSimulationApplicationRequest
        ): Kleisli[M, RoboMakerClient, CreateSimulationApplicationResponse] =
          primitive(_.createSimulationApplication(request))

        def createSimulationApplicationVersion(
          request: CreateSimulationApplicationVersionRequest
        ): Kleisli[M, RoboMakerClient, CreateSimulationApplicationVersionResponse] =
          primitive(_.createSimulationApplicationVersion(request))

        def createSimulationJob(
          request: CreateSimulationJobRequest
        ): Kleisli[M, RoboMakerClient, CreateSimulationJobResponse] =
          primitive(_.createSimulationJob(request))

        def createWorldExportJob(
          request: CreateWorldExportJobRequest
        ): Kleisli[M, RoboMakerClient, CreateWorldExportJobResponse] =
          primitive(_.createWorldExportJob(request))

        def createWorldGenerationJob(
          request: CreateWorldGenerationJobRequest
        ): Kleisli[M, RoboMakerClient, CreateWorldGenerationJobResponse] =
          primitive(_.createWorldGenerationJob(request))

        def createWorldTemplate(
          request: CreateWorldTemplateRequest
        ): Kleisli[M, RoboMakerClient, CreateWorldTemplateResponse] =
          primitive(_.createWorldTemplate(request))

        def deleteFleet(
          request: DeleteFleetRequest
        ): Kleisli[M, RoboMakerClient, DeleteFleetResponse] =
          primitive(_.deleteFleet(request))

        def deleteRobot(
          request: DeleteRobotRequest
        ): Kleisli[M, RoboMakerClient, DeleteRobotResponse] =
          primitive(_.deleteRobot(request))

        def deleteRobotApplication(
          request: DeleteRobotApplicationRequest
        ): Kleisli[M, RoboMakerClient, DeleteRobotApplicationResponse] =
          primitive(_.deleteRobotApplication(request))

        def deleteSimulationApplication(
          request: DeleteSimulationApplicationRequest
        ): Kleisli[M, RoboMakerClient, DeleteSimulationApplicationResponse] =
          primitive(_.deleteSimulationApplication(request))

        def deleteWorldTemplate(
          request: DeleteWorldTemplateRequest
        ): Kleisli[M, RoboMakerClient, DeleteWorldTemplateResponse] =
          primitive(_.deleteWorldTemplate(request))

        def deregisterRobot(
          request: DeregisterRobotRequest
        ): Kleisli[M, RoboMakerClient, DeregisterRobotResponse] =
          primitive(_.deregisterRobot(request))

        def describeDeploymentJob(
          request: DescribeDeploymentJobRequest
        ): Kleisli[M, RoboMakerClient, DescribeDeploymentJobResponse] =
          primitive(_.describeDeploymentJob(request))

        def describeFleet(
          request: DescribeFleetRequest
        ): Kleisli[M, RoboMakerClient, DescribeFleetResponse] =
          primitive(_.describeFleet(request))

        def describeRobot(
          request: DescribeRobotRequest
        ): Kleisli[M, RoboMakerClient, DescribeRobotResponse] =
          primitive(_.describeRobot(request))

        def describeRobotApplication(
          request: DescribeRobotApplicationRequest
        ): Kleisli[M, RoboMakerClient, DescribeRobotApplicationResponse] =
          primitive(_.describeRobotApplication(request))

        def describeSimulationApplication(
          request: DescribeSimulationApplicationRequest
        ): Kleisli[M, RoboMakerClient, DescribeSimulationApplicationResponse] =
          primitive(_.describeSimulationApplication(request))

        def describeSimulationJob(
          request: DescribeSimulationJobRequest
        ): Kleisli[M, RoboMakerClient, DescribeSimulationJobResponse] =
          primitive(_.describeSimulationJob(request))

        def describeSimulationJobBatch(
          request: DescribeSimulationJobBatchRequest
        ): Kleisli[M, RoboMakerClient, DescribeSimulationJobBatchResponse] =
          primitive(_.describeSimulationJobBatch(request))

        def describeWorld(
          request: DescribeWorldRequest
        ): Kleisli[M, RoboMakerClient, DescribeWorldResponse] =
          primitive(_.describeWorld(request))

        def describeWorldExportJob(
          request: DescribeWorldExportJobRequest
        ): Kleisli[M, RoboMakerClient, DescribeWorldExportJobResponse] =
          primitive(_.describeWorldExportJob(request))

        def describeWorldGenerationJob(
          request: DescribeWorldGenerationJobRequest
        ): Kleisli[M, RoboMakerClient, DescribeWorldGenerationJobResponse] =
          primitive(_.describeWorldGenerationJob(request))

        def describeWorldTemplate(
          request: DescribeWorldTemplateRequest
        ): Kleisli[M, RoboMakerClient, DescribeWorldTemplateResponse] =
          primitive(_.describeWorldTemplate(request))

        def getWorldTemplateBody(
          request: GetWorldTemplateBodyRequest
        ): Kleisli[M, RoboMakerClient, GetWorldTemplateBodyResponse] =
          primitive(_.getWorldTemplateBody(request))

        def listDeploymentJobs(
          request: ListDeploymentJobsRequest
        ): Kleisli[M, RoboMakerClient, ListDeploymentJobsResponse] =
          primitive(_.listDeploymentJobs(request))

        def listFleets(
          request: ListFleetsRequest
        ): Kleisli[M, RoboMakerClient, ListFleetsResponse] =
          primitive(_.listFleets(request))

        def listRobotApplications(
          request: ListRobotApplicationsRequest
        ): Kleisli[M, RoboMakerClient, ListRobotApplicationsResponse] =
          primitive(_.listRobotApplications(request))

        def listRobots(
          request: ListRobotsRequest
        ): Kleisli[M, RoboMakerClient, ListRobotsResponse] =
          primitive(_.listRobots(request))

        def listSimulationApplications(
          request: ListSimulationApplicationsRequest
        ): Kleisli[M, RoboMakerClient, ListSimulationApplicationsResponse] =
          primitive(_.listSimulationApplications(request))

        def listSimulationJobBatches(
          request: ListSimulationJobBatchesRequest
        ): Kleisli[M, RoboMakerClient, ListSimulationJobBatchesResponse] =
          primitive(_.listSimulationJobBatches(request))

        def listSimulationJobs(
          request: ListSimulationJobsRequest
        ): Kleisli[M, RoboMakerClient, ListSimulationJobsResponse] =
          primitive(_.listSimulationJobs(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, RoboMakerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWorldExportJobs(
          request: ListWorldExportJobsRequest
        ): Kleisli[M, RoboMakerClient, ListWorldExportJobsResponse] =
          primitive(_.listWorldExportJobs(request))

        def listWorldGenerationJobs(
          request: ListWorldGenerationJobsRequest
        ): Kleisli[M, RoboMakerClient, ListWorldGenerationJobsResponse] =
          primitive(_.listWorldGenerationJobs(request))

        def listWorldTemplates(
          request: ListWorldTemplatesRequest
        ): Kleisli[M, RoboMakerClient, ListWorldTemplatesResponse] =
          primitive(_.listWorldTemplates(request))

        def listWorlds(
          request: ListWorldsRequest
        ): Kleisli[M, RoboMakerClient, ListWorldsResponse] =
          primitive(_.listWorlds(request))

        def registerRobot(
          request: RegisterRobotRequest
        ): Kleisli[M, RoboMakerClient, RegisterRobotResponse] =
          primitive(_.registerRobot(request))

        def restartSimulationJob(
          request: RestartSimulationJobRequest
        ): Kleisli[M, RoboMakerClient, RestartSimulationJobResponse] =
          primitive(_.restartSimulationJob(request))

        def startSimulationJobBatch(
          request: StartSimulationJobBatchRequest
        ): Kleisli[M, RoboMakerClient, StartSimulationJobBatchResponse] =
          primitive(_.startSimulationJobBatch(request))

        def syncDeploymentJob(
          request: SyncDeploymentJobRequest
        ): Kleisli[M, RoboMakerClient, SyncDeploymentJobResponse] =
          primitive(_.syncDeploymentJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, RoboMakerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, RoboMakerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateRobotApplication(
          request: UpdateRobotApplicationRequest
        ): Kleisli[M, RoboMakerClient, UpdateRobotApplicationResponse] =
          primitive(_.updateRobotApplication(request))

        def updateSimulationApplication(
          request: UpdateSimulationApplicationRequest
        ): Kleisli[M, RoboMakerClient, UpdateSimulationApplicationResponse] =
          primitive(_.updateSimulationApplication(request))

        def updateWorldTemplate(
          request: UpdateWorldTemplateRequest
        ): Kleisli[M, RoboMakerClient, UpdateWorldTemplateResponse] =
          primitive(_.updateWorldTemplate(request))

        def primitive[A](
          f: RoboMakerClient => A
        ): Kleisli[M, RoboMakerClient, A]
      }
    }

    trait Visitor[F[_]] extends (RoboMakerOp ~> F) {
      final def apply[A](op: RoboMakerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchDeleteWorlds(
        request: BatchDeleteWorldsRequest
      ): F[BatchDeleteWorldsResponse]

      def batchDescribeSimulationJob(
        request: BatchDescribeSimulationJobRequest
      ): F[BatchDescribeSimulationJobResponse]

      def cancelDeploymentJob(
        request: CancelDeploymentJobRequest
      ): F[CancelDeploymentJobResponse]

      def cancelSimulationJob(
        request: CancelSimulationJobRequest
      ): F[CancelSimulationJobResponse]

      def cancelSimulationJobBatch(
        request: CancelSimulationJobBatchRequest
      ): F[CancelSimulationJobBatchResponse]

      def cancelWorldExportJob(
        request: CancelWorldExportJobRequest
      ): F[CancelWorldExportJobResponse]

      def cancelWorldGenerationJob(
        request: CancelWorldGenerationJobRequest
      ): F[CancelWorldGenerationJobResponse]

      def createDeploymentJob(
        request: CreateDeploymentJobRequest
      ): F[CreateDeploymentJobResponse]

      def createFleet(
        request: CreateFleetRequest
      ): F[CreateFleetResponse]

      def createRobot(
        request: CreateRobotRequest
      ): F[CreateRobotResponse]

      def createRobotApplication(
        request: CreateRobotApplicationRequest
      ): F[CreateRobotApplicationResponse]

      def createRobotApplicationVersion(
        request: CreateRobotApplicationVersionRequest
      ): F[CreateRobotApplicationVersionResponse]

      def createSimulationApplication(
        request: CreateSimulationApplicationRequest
      ): F[CreateSimulationApplicationResponse]

      def createSimulationApplicationVersion(
        request: CreateSimulationApplicationVersionRequest
      ): F[CreateSimulationApplicationVersionResponse]

      def createSimulationJob(
        request: CreateSimulationJobRequest
      ): F[CreateSimulationJobResponse]

      def createWorldExportJob(
        request: CreateWorldExportJobRequest
      ): F[CreateWorldExportJobResponse]

      def createWorldGenerationJob(
        request: CreateWorldGenerationJobRequest
      ): F[CreateWorldGenerationJobResponse]

      def createWorldTemplate(
        request: CreateWorldTemplateRequest
      ): F[CreateWorldTemplateResponse]

      def deleteFleet(
        request: DeleteFleetRequest
      ): F[DeleteFleetResponse]

      def deleteRobot(
        request: DeleteRobotRequest
      ): F[DeleteRobotResponse]

      def deleteRobotApplication(
        request: DeleteRobotApplicationRequest
      ): F[DeleteRobotApplicationResponse]

      def deleteSimulationApplication(
        request: DeleteSimulationApplicationRequest
      ): F[DeleteSimulationApplicationResponse]

      def deleteWorldTemplate(
        request: DeleteWorldTemplateRequest
      ): F[DeleteWorldTemplateResponse]

      def deregisterRobot(
        request: DeregisterRobotRequest
      ): F[DeregisterRobotResponse]

      def describeDeploymentJob(
        request: DescribeDeploymentJobRequest
      ): F[DescribeDeploymentJobResponse]

      def describeFleet(
        request: DescribeFleetRequest
      ): F[DescribeFleetResponse]

      def describeRobot(
        request: DescribeRobotRequest
      ): F[DescribeRobotResponse]

      def describeRobotApplication(
        request: DescribeRobotApplicationRequest
      ): F[DescribeRobotApplicationResponse]

      def describeSimulationApplication(
        request: DescribeSimulationApplicationRequest
      ): F[DescribeSimulationApplicationResponse]

      def describeSimulationJob(
        request: DescribeSimulationJobRequest
      ): F[DescribeSimulationJobResponse]

      def describeSimulationJobBatch(
        request: DescribeSimulationJobBatchRequest
      ): F[DescribeSimulationJobBatchResponse]

      def describeWorld(
        request: DescribeWorldRequest
      ): F[DescribeWorldResponse]

      def describeWorldExportJob(
        request: DescribeWorldExportJobRequest
      ): F[DescribeWorldExportJobResponse]

      def describeWorldGenerationJob(
        request: DescribeWorldGenerationJobRequest
      ): F[DescribeWorldGenerationJobResponse]

      def describeWorldTemplate(
        request: DescribeWorldTemplateRequest
      ): F[DescribeWorldTemplateResponse]

      def getWorldTemplateBody(
        request: GetWorldTemplateBodyRequest
      ): F[GetWorldTemplateBodyResponse]

      def listDeploymentJobs(
        request: ListDeploymentJobsRequest
      ): F[ListDeploymentJobsResponse]

      def listFleets(
        request: ListFleetsRequest
      ): F[ListFleetsResponse]

      def listRobotApplications(
        request: ListRobotApplicationsRequest
      ): F[ListRobotApplicationsResponse]

      def listRobots(
        request: ListRobotsRequest
      ): F[ListRobotsResponse]

      def listSimulationApplications(
        request: ListSimulationApplicationsRequest
      ): F[ListSimulationApplicationsResponse]

      def listSimulationJobBatches(
        request: ListSimulationJobBatchesRequest
      ): F[ListSimulationJobBatchesResponse]

      def listSimulationJobs(
        request: ListSimulationJobsRequest
      ): F[ListSimulationJobsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWorldExportJobs(
        request: ListWorldExportJobsRequest
      ): F[ListWorldExportJobsResponse]

      def listWorldGenerationJobs(
        request: ListWorldGenerationJobsRequest
      ): F[ListWorldGenerationJobsResponse]

      def listWorldTemplates(
        request: ListWorldTemplatesRequest
      ): F[ListWorldTemplatesResponse]

      def listWorlds(
        request: ListWorldsRequest
      ): F[ListWorldsResponse]

      def registerRobot(
        request: RegisterRobotRequest
      ): F[RegisterRobotResponse]

      def restartSimulationJob(
        request: RestartSimulationJobRequest
      ): F[RestartSimulationJobResponse]

      def startSimulationJobBatch(
        request: StartSimulationJobBatchRequest
      ): F[StartSimulationJobBatchResponse]

      def syncDeploymentJob(
        request: SyncDeploymentJobRequest
      ): F[SyncDeploymentJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateRobotApplication(
        request: UpdateRobotApplicationRequest
      ): F[UpdateRobotApplicationResponse]

      def updateSimulationApplication(
        request: UpdateSimulationApplicationRequest
      ): F[UpdateSimulationApplicationResponse]

      def updateWorldTemplate(
        request: UpdateWorldTemplateRequest
      ): F[UpdateWorldTemplateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RoboMakerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchDeleteWorldsOp(
      request: BatchDeleteWorldsRequest
    ) extends RoboMakerOp[BatchDeleteWorldsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteWorldsResponse] =
        visitor.batchDeleteWorlds(request)
    }

    final case class BatchDescribeSimulationJobOp(
      request: BatchDescribeSimulationJobRequest
    ) extends RoboMakerOp[BatchDescribeSimulationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDescribeSimulationJobResponse] =
        visitor.batchDescribeSimulationJob(request)
    }

    final case class CancelDeploymentJobOp(
      request: CancelDeploymentJobRequest
    ) extends RoboMakerOp[CancelDeploymentJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelDeploymentJobResponse] =
        visitor.cancelDeploymentJob(request)
    }

    final case class CancelSimulationJobOp(
      request: CancelSimulationJobRequest
    ) extends RoboMakerOp[CancelSimulationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelSimulationJobResponse] =
        visitor.cancelSimulationJob(request)
    }

    final case class CancelSimulationJobBatchOp(
      request: CancelSimulationJobBatchRequest
    ) extends RoboMakerOp[CancelSimulationJobBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelSimulationJobBatchResponse] =
        visitor.cancelSimulationJobBatch(request)
    }

    final case class CancelWorldExportJobOp(
      request: CancelWorldExportJobRequest
    ) extends RoboMakerOp[CancelWorldExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelWorldExportJobResponse] =
        visitor.cancelWorldExportJob(request)
    }

    final case class CancelWorldGenerationJobOp(
      request: CancelWorldGenerationJobRequest
    ) extends RoboMakerOp[CancelWorldGenerationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelWorldGenerationJobResponse] =
        visitor.cancelWorldGenerationJob(request)
    }

    final case class CreateDeploymentJobOp(
      request: CreateDeploymentJobRequest
    ) extends RoboMakerOp[CreateDeploymentJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentJobResponse] =
        visitor.createDeploymentJob(request)
    }

    final case class CreateFleetOp(
      request: CreateFleetRequest
    ) extends RoboMakerOp[CreateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFleetResponse] =
        visitor.createFleet(request)
    }

    final case class CreateRobotOp(
      request: CreateRobotRequest
    ) extends RoboMakerOp[CreateRobotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRobotResponse] =
        visitor.createRobot(request)
    }

    final case class CreateRobotApplicationOp(
      request: CreateRobotApplicationRequest
    ) extends RoboMakerOp[CreateRobotApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRobotApplicationResponse] =
        visitor.createRobotApplication(request)
    }

    final case class CreateRobotApplicationVersionOp(
      request: CreateRobotApplicationVersionRequest
    ) extends RoboMakerOp[CreateRobotApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRobotApplicationVersionResponse] =
        visitor.createRobotApplicationVersion(request)
    }

    final case class CreateSimulationApplicationOp(
      request: CreateSimulationApplicationRequest
    ) extends RoboMakerOp[CreateSimulationApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSimulationApplicationResponse] =
        visitor.createSimulationApplication(request)
    }

    final case class CreateSimulationApplicationVersionOp(
      request: CreateSimulationApplicationVersionRequest
    ) extends RoboMakerOp[CreateSimulationApplicationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSimulationApplicationVersionResponse] =
        visitor.createSimulationApplicationVersion(request)
    }

    final case class CreateSimulationJobOp(
      request: CreateSimulationJobRequest
    ) extends RoboMakerOp[CreateSimulationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSimulationJobResponse] =
        visitor.createSimulationJob(request)
    }

    final case class CreateWorldExportJobOp(
      request: CreateWorldExportJobRequest
    ) extends RoboMakerOp[CreateWorldExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorldExportJobResponse] =
        visitor.createWorldExportJob(request)
    }

    final case class CreateWorldGenerationJobOp(
      request: CreateWorldGenerationJobRequest
    ) extends RoboMakerOp[CreateWorldGenerationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorldGenerationJobResponse] =
        visitor.createWorldGenerationJob(request)
    }

    final case class CreateWorldTemplateOp(
      request: CreateWorldTemplateRequest
    ) extends RoboMakerOp[CreateWorldTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorldTemplateResponse] =
        visitor.createWorldTemplate(request)
    }

    final case class DeleteFleetOp(
      request: DeleteFleetRequest
    ) extends RoboMakerOp[DeleteFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFleetResponse] =
        visitor.deleteFleet(request)
    }

    final case class DeleteRobotOp(
      request: DeleteRobotRequest
    ) extends RoboMakerOp[DeleteRobotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRobotResponse] =
        visitor.deleteRobot(request)
    }

    final case class DeleteRobotApplicationOp(
      request: DeleteRobotApplicationRequest
    ) extends RoboMakerOp[DeleteRobotApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRobotApplicationResponse] =
        visitor.deleteRobotApplication(request)
    }

    final case class DeleteSimulationApplicationOp(
      request: DeleteSimulationApplicationRequest
    ) extends RoboMakerOp[DeleteSimulationApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSimulationApplicationResponse] =
        visitor.deleteSimulationApplication(request)
    }

    final case class DeleteWorldTemplateOp(
      request: DeleteWorldTemplateRequest
    ) extends RoboMakerOp[DeleteWorldTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorldTemplateResponse] =
        visitor.deleteWorldTemplate(request)
    }

    final case class DeregisterRobotOp(
      request: DeregisterRobotRequest
    ) extends RoboMakerOp[DeregisterRobotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterRobotResponse] =
        visitor.deregisterRobot(request)
    }

    final case class DescribeDeploymentJobOp(
      request: DescribeDeploymentJobRequest
    ) extends RoboMakerOp[DescribeDeploymentJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDeploymentJobResponse] =
        visitor.describeDeploymentJob(request)
    }

    final case class DescribeFleetOp(
      request: DescribeFleetRequest
    ) extends RoboMakerOp[DescribeFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetResponse] =
        visitor.describeFleet(request)
    }

    final case class DescribeRobotOp(
      request: DescribeRobotRequest
    ) extends RoboMakerOp[DescribeRobotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRobotResponse] =
        visitor.describeRobot(request)
    }

    final case class DescribeRobotApplicationOp(
      request: DescribeRobotApplicationRequest
    ) extends RoboMakerOp[DescribeRobotApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRobotApplicationResponse] =
        visitor.describeRobotApplication(request)
    }

    final case class DescribeSimulationApplicationOp(
      request: DescribeSimulationApplicationRequest
    ) extends RoboMakerOp[DescribeSimulationApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSimulationApplicationResponse] =
        visitor.describeSimulationApplication(request)
    }

    final case class DescribeSimulationJobOp(
      request: DescribeSimulationJobRequest
    ) extends RoboMakerOp[DescribeSimulationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSimulationJobResponse] =
        visitor.describeSimulationJob(request)
    }

    final case class DescribeSimulationJobBatchOp(
      request: DescribeSimulationJobBatchRequest
    ) extends RoboMakerOp[DescribeSimulationJobBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSimulationJobBatchResponse] =
        visitor.describeSimulationJobBatch(request)
    }

    final case class DescribeWorldOp(
      request: DescribeWorldRequest
    ) extends RoboMakerOp[DescribeWorldResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorldResponse] =
        visitor.describeWorld(request)
    }

    final case class DescribeWorldExportJobOp(
      request: DescribeWorldExportJobRequest
    ) extends RoboMakerOp[DescribeWorldExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorldExportJobResponse] =
        visitor.describeWorldExportJob(request)
    }

    final case class DescribeWorldGenerationJobOp(
      request: DescribeWorldGenerationJobRequest
    ) extends RoboMakerOp[DescribeWorldGenerationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorldGenerationJobResponse] =
        visitor.describeWorldGenerationJob(request)
    }

    final case class DescribeWorldTemplateOp(
      request: DescribeWorldTemplateRequest
    ) extends RoboMakerOp[DescribeWorldTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorldTemplateResponse] =
        visitor.describeWorldTemplate(request)
    }

    final case class GetWorldTemplateBodyOp(
      request: GetWorldTemplateBodyRequest
    ) extends RoboMakerOp[GetWorldTemplateBodyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWorldTemplateBodyResponse] =
        visitor.getWorldTemplateBody(request)
    }

    final case class ListDeploymentJobsOp(
      request: ListDeploymentJobsRequest
    ) extends RoboMakerOp[ListDeploymentJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentJobsResponse] =
        visitor.listDeploymentJobs(request)
    }

    final case class ListFleetsOp(
      request: ListFleetsRequest
    ) extends RoboMakerOp[ListFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFleetsResponse] =
        visitor.listFleets(request)
    }

    final case class ListRobotApplicationsOp(
      request: ListRobotApplicationsRequest
    ) extends RoboMakerOp[ListRobotApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRobotApplicationsResponse] =
        visitor.listRobotApplications(request)
    }

    final case class ListRobotsOp(
      request: ListRobotsRequest
    ) extends RoboMakerOp[ListRobotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRobotsResponse] =
        visitor.listRobots(request)
    }

    final case class ListSimulationApplicationsOp(
      request: ListSimulationApplicationsRequest
    ) extends RoboMakerOp[ListSimulationApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSimulationApplicationsResponse] =
        visitor.listSimulationApplications(request)
    }

    final case class ListSimulationJobBatchesOp(
      request: ListSimulationJobBatchesRequest
    ) extends RoboMakerOp[ListSimulationJobBatchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSimulationJobBatchesResponse] =
        visitor.listSimulationJobBatches(request)
    }

    final case class ListSimulationJobsOp(
      request: ListSimulationJobsRequest
    ) extends RoboMakerOp[ListSimulationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSimulationJobsResponse] =
        visitor.listSimulationJobs(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends RoboMakerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWorldExportJobsOp(
      request: ListWorldExportJobsRequest
    ) extends RoboMakerOp[ListWorldExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorldExportJobsResponse] =
        visitor.listWorldExportJobs(request)
    }

    final case class ListWorldGenerationJobsOp(
      request: ListWorldGenerationJobsRequest
    ) extends RoboMakerOp[ListWorldGenerationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorldGenerationJobsResponse] =
        visitor.listWorldGenerationJobs(request)
    }

    final case class ListWorldTemplatesOp(
      request: ListWorldTemplatesRequest
    ) extends RoboMakerOp[ListWorldTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorldTemplatesResponse] =
        visitor.listWorldTemplates(request)
    }

    final case class ListWorldsOp(
      request: ListWorldsRequest
    ) extends RoboMakerOp[ListWorldsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWorldsResponse] =
        visitor.listWorlds(request)
    }

    final case class RegisterRobotOp(
      request: RegisterRobotRequest
    ) extends RoboMakerOp[RegisterRobotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterRobotResponse] =
        visitor.registerRobot(request)
    }

    final case class RestartSimulationJobOp(
      request: RestartSimulationJobRequest
    ) extends RoboMakerOp[RestartSimulationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestartSimulationJobResponse] =
        visitor.restartSimulationJob(request)
    }

    final case class StartSimulationJobBatchOp(
      request: StartSimulationJobBatchRequest
    ) extends RoboMakerOp[StartSimulationJobBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSimulationJobBatchResponse] =
        visitor.startSimulationJobBatch(request)
    }

    final case class SyncDeploymentJobOp(
      request: SyncDeploymentJobRequest
    ) extends RoboMakerOp[SyncDeploymentJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SyncDeploymentJobResponse] =
        visitor.syncDeploymentJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends RoboMakerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends RoboMakerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateRobotApplicationOp(
      request: UpdateRobotApplicationRequest
    ) extends RoboMakerOp[UpdateRobotApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRobotApplicationResponse] =
        visitor.updateRobotApplication(request)
    }

    final case class UpdateSimulationApplicationOp(
      request: UpdateSimulationApplicationRequest
    ) extends RoboMakerOp[UpdateSimulationApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSimulationApplicationResponse] =
        visitor.updateSimulationApplication(request)
    }

    final case class UpdateWorldTemplateOp(
      request: UpdateWorldTemplateRequest
    ) extends RoboMakerOp[UpdateWorldTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorldTemplateResponse] =
        visitor.updateWorldTemplate(request)
    }
  }

  import RoboMakerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RoboMakerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchDeleteWorlds(
    request: BatchDeleteWorldsRequest
  ): RoboMakerIO[BatchDeleteWorldsResponse] =
    FF.liftF(BatchDeleteWorldsOp(request))

  def batchDescribeSimulationJob(
    request: BatchDescribeSimulationJobRequest
  ): RoboMakerIO[BatchDescribeSimulationJobResponse] =
    FF.liftF(BatchDescribeSimulationJobOp(request))

  def cancelDeploymentJob(
    request: CancelDeploymentJobRequest
  ): RoboMakerIO[CancelDeploymentJobResponse] =
    FF.liftF(CancelDeploymentJobOp(request))

  def cancelSimulationJob(
    request: CancelSimulationJobRequest
  ): RoboMakerIO[CancelSimulationJobResponse] =
    FF.liftF(CancelSimulationJobOp(request))

  def cancelSimulationJobBatch(
    request: CancelSimulationJobBatchRequest
  ): RoboMakerIO[CancelSimulationJobBatchResponse] =
    FF.liftF(CancelSimulationJobBatchOp(request))

  def cancelWorldExportJob(
    request: CancelWorldExportJobRequest
  ): RoboMakerIO[CancelWorldExportJobResponse] =
    FF.liftF(CancelWorldExportJobOp(request))

  def cancelWorldGenerationJob(
    request: CancelWorldGenerationJobRequest
  ): RoboMakerIO[CancelWorldGenerationJobResponse] =
    FF.liftF(CancelWorldGenerationJobOp(request))

  def createDeploymentJob(
    request: CreateDeploymentJobRequest
  ): RoboMakerIO[CreateDeploymentJobResponse] =
    FF.liftF(CreateDeploymentJobOp(request))

  def createFleet(
    request: CreateFleetRequest
  ): RoboMakerIO[CreateFleetResponse] =
    FF.liftF(CreateFleetOp(request))

  def createRobot(
    request: CreateRobotRequest
  ): RoboMakerIO[CreateRobotResponse] =
    FF.liftF(CreateRobotOp(request))

  def createRobotApplication(
    request: CreateRobotApplicationRequest
  ): RoboMakerIO[CreateRobotApplicationResponse] =
    FF.liftF(CreateRobotApplicationOp(request))

  def createRobotApplicationVersion(
    request: CreateRobotApplicationVersionRequest
  ): RoboMakerIO[CreateRobotApplicationVersionResponse] =
    FF.liftF(CreateRobotApplicationVersionOp(request))

  def createSimulationApplication(
    request: CreateSimulationApplicationRequest
  ): RoboMakerIO[CreateSimulationApplicationResponse] =
    FF.liftF(CreateSimulationApplicationOp(request))

  def createSimulationApplicationVersion(
    request: CreateSimulationApplicationVersionRequest
  ): RoboMakerIO[CreateSimulationApplicationVersionResponse] =
    FF.liftF(CreateSimulationApplicationVersionOp(request))

  def createSimulationJob(
    request: CreateSimulationJobRequest
  ): RoboMakerIO[CreateSimulationJobResponse] =
    FF.liftF(CreateSimulationJobOp(request))

  def createWorldExportJob(
    request: CreateWorldExportJobRequest
  ): RoboMakerIO[CreateWorldExportJobResponse] =
    FF.liftF(CreateWorldExportJobOp(request))

  def createWorldGenerationJob(
    request: CreateWorldGenerationJobRequest
  ): RoboMakerIO[CreateWorldGenerationJobResponse] =
    FF.liftF(CreateWorldGenerationJobOp(request))

  def createWorldTemplate(
    request: CreateWorldTemplateRequest
  ): RoboMakerIO[CreateWorldTemplateResponse] =
    FF.liftF(CreateWorldTemplateOp(request))

  def deleteFleet(
    request: DeleteFleetRequest
  ): RoboMakerIO[DeleteFleetResponse] =
    FF.liftF(DeleteFleetOp(request))

  def deleteRobot(
    request: DeleteRobotRequest
  ): RoboMakerIO[DeleteRobotResponse] =
    FF.liftF(DeleteRobotOp(request))

  def deleteRobotApplication(
    request: DeleteRobotApplicationRequest
  ): RoboMakerIO[DeleteRobotApplicationResponse] =
    FF.liftF(DeleteRobotApplicationOp(request))

  def deleteSimulationApplication(
    request: DeleteSimulationApplicationRequest
  ): RoboMakerIO[DeleteSimulationApplicationResponse] =
    FF.liftF(DeleteSimulationApplicationOp(request))

  def deleteWorldTemplate(
    request: DeleteWorldTemplateRequest
  ): RoboMakerIO[DeleteWorldTemplateResponse] =
    FF.liftF(DeleteWorldTemplateOp(request))

  def deregisterRobot(
    request: DeregisterRobotRequest
  ): RoboMakerIO[DeregisterRobotResponse] =
    FF.liftF(DeregisterRobotOp(request))

  def describeDeploymentJob(
    request: DescribeDeploymentJobRequest
  ): RoboMakerIO[DescribeDeploymentJobResponse] =
    FF.liftF(DescribeDeploymentJobOp(request))

  def describeFleet(
    request: DescribeFleetRequest
  ): RoboMakerIO[DescribeFleetResponse] =
    FF.liftF(DescribeFleetOp(request))

  def describeRobot(
    request: DescribeRobotRequest
  ): RoboMakerIO[DescribeRobotResponse] =
    FF.liftF(DescribeRobotOp(request))

  def describeRobotApplication(
    request: DescribeRobotApplicationRequest
  ): RoboMakerIO[DescribeRobotApplicationResponse] =
    FF.liftF(DescribeRobotApplicationOp(request))

  def describeSimulationApplication(
    request: DescribeSimulationApplicationRequest
  ): RoboMakerIO[DescribeSimulationApplicationResponse] =
    FF.liftF(DescribeSimulationApplicationOp(request))

  def describeSimulationJob(
    request: DescribeSimulationJobRequest
  ): RoboMakerIO[DescribeSimulationJobResponse] =
    FF.liftF(DescribeSimulationJobOp(request))

  def describeSimulationJobBatch(
    request: DescribeSimulationJobBatchRequest
  ): RoboMakerIO[DescribeSimulationJobBatchResponse] =
    FF.liftF(DescribeSimulationJobBatchOp(request))

  def describeWorld(
    request: DescribeWorldRequest
  ): RoboMakerIO[DescribeWorldResponse] =
    FF.liftF(DescribeWorldOp(request))

  def describeWorldExportJob(
    request: DescribeWorldExportJobRequest
  ): RoboMakerIO[DescribeWorldExportJobResponse] =
    FF.liftF(DescribeWorldExportJobOp(request))

  def describeWorldGenerationJob(
    request: DescribeWorldGenerationJobRequest
  ): RoboMakerIO[DescribeWorldGenerationJobResponse] =
    FF.liftF(DescribeWorldGenerationJobOp(request))

  def describeWorldTemplate(
    request: DescribeWorldTemplateRequest
  ): RoboMakerIO[DescribeWorldTemplateResponse] =
    FF.liftF(DescribeWorldTemplateOp(request))

  def getWorldTemplateBody(
    request: GetWorldTemplateBodyRequest
  ): RoboMakerIO[GetWorldTemplateBodyResponse] =
    FF.liftF(GetWorldTemplateBodyOp(request))

  def listDeploymentJobs(
    request: ListDeploymentJobsRequest
  ): RoboMakerIO[ListDeploymentJobsResponse] =
    FF.liftF(ListDeploymentJobsOp(request))

  def listFleets(
    request: ListFleetsRequest
  ): RoboMakerIO[ListFleetsResponse] =
    FF.liftF(ListFleetsOp(request))

  def listRobotApplications(
    request: ListRobotApplicationsRequest
  ): RoboMakerIO[ListRobotApplicationsResponse] =
    FF.liftF(ListRobotApplicationsOp(request))

  def listRobots(
    request: ListRobotsRequest
  ): RoboMakerIO[ListRobotsResponse] =
    FF.liftF(ListRobotsOp(request))

  def listSimulationApplications(
    request: ListSimulationApplicationsRequest
  ): RoboMakerIO[ListSimulationApplicationsResponse] =
    FF.liftF(ListSimulationApplicationsOp(request))

  def listSimulationJobBatches(
    request: ListSimulationJobBatchesRequest
  ): RoboMakerIO[ListSimulationJobBatchesResponse] =
    FF.liftF(ListSimulationJobBatchesOp(request))

  def listSimulationJobs(
    request: ListSimulationJobsRequest
  ): RoboMakerIO[ListSimulationJobsResponse] =
    FF.liftF(ListSimulationJobsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): RoboMakerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWorldExportJobs(
    request: ListWorldExportJobsRequest
  ): RoboMakerIO[ListWorldExportJobsResponse] =
    FF.liftF(ListWorldExportJobsOp(request))

  def listWorldGenerationJobs(
    request: ListWorldGenerationJobsRequest
  ): RoboMakerIO[ListWorldGenerationJobsResponse] =
    FF.liftF(ListWorldGenerationJobsOp(request))

  def listWorldTemplates(
    request: ListWorldTemplatesRequest
  ): RoboMakerIO[ListWorldTemplatesResponse] =
    FF.liftF(ListWorldTemplatesOp(request))

  def listWorlds(
    request: ListWorldsRequest
  ): RoboMakerIO[ListWorldsResponse] =
    FF.liftF(ListWorldsOp(request))

  def registerRobot(
    request: RegisterRobotRequest
  ): RoboMakerIO[RegisterRobotResponse] =
    FF.liftF(RegisterRobotOp(request))

  def restartSimulationJob(
    request: RestartSimulationJobRequest
  ): RoboMakerIO[RestartSimulationJobResponse] =
    FF.liftF(RestartSimulationJobOp(request))

  def startSimulationJobBatch(
    request: StartSimulationJobBatchRequest
  ): RoboMakerIO[StartSimulationJobBatchResponse] =
    FF.liftF(StartSimulationJobBatchOp(request))

  def syncDeploymentJob(
    request: SyncDeploymentJobRequest
  ): RoboMakerIO[SyncDeploymentJobResponse] =
    FF.liftF(SyncDeploymentJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): RoboMakerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): RoboMakerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateRobotApplication(
    request: UpdateRobotApplicationRequest
  ): RoboMakerIO[UpdateRobotApplicationResponse] =
    FF.liftF(UpdateRobotApplicationOp(request))

  def updateSimulationApplication(
    request: UpdateSimulationApplicationRequest
  ): RoboMakerIO[UpdateSimulationApplicationResponse] =
    FF.liftF(UpdateSimulationApplicationOp(request))

  def updateWorldTemplate(
    request: UpdateWorldTemplateRequest
  ): RoboMakerIO[UpdateWorldTemplateResponse] =
    FF.liftF(UpdateWorldTemplateOp(request))
}
