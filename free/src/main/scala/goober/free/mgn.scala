package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.mgn.MgnClient
import software.amazon.awssdk.services.mgn.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object mgn { module =>

  // Free monad over MgnOp
  type MgnIO[A] = FF[MgnOp, A]

  sealed trait MgnOp[A] {
    def visit[F[_]](visitor: MgnOp.Visitor[F]): F[A]
  }

  object MgnOp {
    // Given a MgnClient we can embed a MgnIO program in any algebra that understands embedding.
    implicit val MgnOpEmbeddable: Embeddable[MgnOp, MgnClient] = new Embeddable[MgnOp, MgnClient] {
      def embed[A](client: MgnClient, io: MgnIO[A]): Embedded[A] = Embedded.Mgn(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends MgnOp.Visitor[Kleisli[M, MgnClient, *]] {
        def changeServerLifeCycleState(
          request: ChangeServerLifeCycleStateRequest
        ): Kleisli[M, MgnClient, ChangeServerLifeCycleStateResponse] =
          primitive(_.changeServerLifeCycleState(request))

        def createReplicationConfigurationTemplate(
          request: CreateReplicationConfigurationTemplateRequest
        ): Kleisli[M, MgnClient, CreateReplicationConfigurationTemplateResponse] =
          primitive(_.createReplicationConfigurationTemplate(request))

        def deleteJob(
          request: DeleteJobRequest
        ): Kleisli[M, MgnClient, DeleteJobResponse] =
          primitive(_.deleteJob(request))

        def deleteReplicationConfigurationTemplate(
          request: DeleteReplicationConfigurationTemplateRequest
        ): Kleisli[M, MgnClient, DeleteReplicationConfigurationTemplateResponse] =
          primitive(_.deleteReplicationConfigurationTemplate(request))

        def deleteSourceServer(
          request: DeleteSourceServerRequest
        ): Kleisli[M, MgnClient, DeleteSourceServerResponse] =
          primitive(_.deleteSourceServer(request))

        def describeJobLogItems(
          request: DescribeJobLogItemsRequest
        ): Kleisli[M, MgnClient, DescribeJobLogItemsResponse] =
          primitive(_.describeJobLogItems(request))

        def describeJobs(
          request: DescribeJobsRequest
        ): Kleisli[M, MgnClient, DescribeJobsResponse] =
          primitive(_.describeJobs(request))

        def describeReplicationConfigurationTemplates(
          request: DescribeReplicationConfigurationTemplatesRequest
        ): Kleisli[M, MgnClient, DescribeReplicationConfigurationTemplatesResponse] =
          primitive(_.describeReplicationConfigurationTemplates(request))

        def describeSourceServers(
          request: DescribeSourceServersRequest
        ): Kleisli[M, MgnClient, DescribeSourceServersResponse] =
          primitive(_.describeSourceServers(request))

        def disconnectFromService(
          request: DisconnectFromServiceRequest
        ): Kleisli[M, MgnClient, DisconnectFromServiceResponse] =
          primitive(_.disconnectFromService(request))

        def finalizeCutover(
          request: FinalizeCutoverRequest
        ): Kleisli[M, MgnClient, FinalizeCutoverResponse] =
          primitive(_.finalizeCutover(request))

        def getLaunchConfiguration(
          request: GetLaunchConfigurationRequest
        ): Kleisli[M, MgnClient, GetLaunchConfigurationResponse] =
          primitive(_.getLaunchConfiguration(request))

        def getReplicationConfiguration(
          request: GetReplicationConfigurationRequest
        ): Kleisli[M, MgnClient, GetReplicationConfigurationResponse] =
          primitive(_.getReplicationConfiguration(request))

        def initializeService(
          request: InitializeServiceRequest
        ): Kleisli[M, MgnClient, InitializeServiceResponse] =
          primitive(_.initializeService(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, MgnClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def markAsArchived(
          request: MarkAsArchivedRequest
        ): Kleisli[M, MgnClient, MarkAsArchivedResponse] =
          primitive(_.markAsArchived(request))

        def retryDataReplication(
          request: RetryDataReplicationRequest
        ): Kleisli[M, MgnClient, RetryDataReplicationResponse] =
          primitive(_.retryDataReplication(request))

        def startCutover(
          request: StartCutoverRequest
        ): Kleisli[M, MgnClient, StartCutoverResponse] =
          primitive(_.startCutover(request))

        def startTest(
          request: StartTestRequest
        ): Kleisli[M, MgnClient, StartTestResponse] =
          primitive(_.startTest(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, MgnClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def terminateTargetInstances(
          request: TerminateTargetInstancesRequest
        ): Kleisli[M, MgnClient, TerminateTargetInstancesResponse] =
          primitive(_.terminateTargetInstances(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, MgnClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateLaunchConfiguration(
          request: UpdateLaunchConfigurationRequest
        ): Kleisli[M, MgnClient, UpdateLaunchConfigurationResponse] =
          primitive(_.updateLaunchConfiguration(request))

        def updateReplicationConfiguration(
          request: UpdateReplicationConfigurationRequest
        ): Kleisli[M, MgnClient, UpdateReplicationConfigurationResponse] =
          primitive(_.updateReplicationConfiguration(request))

        def updateReplicationConfigurationTemplate(
          request: UpdateReplicationConfigurationTemplateRequest
        ): Kleisli[M, MgnClient, UpdateReplicationConfigurationTemplateResponse] =
          primitive(_.updateReplicationConfigurationTemplate(request))

        def primitive[A](
          f: MgnClient => A
        ): Kleisli[M, MgnClient, A]
      }
    }

    trait Visitor[F[_]] extends (MgnOp ~> F) {
      final def apply[A](op: MgnOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def changeServerLifeCycleState(
        request: ChangeServerLifeCycleStateRequest
      ): F[ChangeServerLifeCycleStateResponse]

      def createReplicationConfigurationTemplate(
        request: CreateReplicationConfigurationTemplateRequest
      ): F[CreateReplicationConfigurationTemplateResponse]

      def deleteJob(
        request: DeleteJobRequest
      ): F[DeleteJobResponse]

      def deleteReplicationConfigurationTemplate(
        request: DeleteReplicationConfigurationTemplateRequest
      ): F[DeleteReplicationConfigurationTemplateResponse]

      def deleteSourceServer(
        request: DeleteSourceServerRequest
      ): F[DeleteSourceServerResponse]

      def describeJobLogItems(
        request: DescribeJobLogItemsRequest
      ): F[DescribeJobLogItemsResponse]

      def describeJobs(
        request: DescribeJobsRequest
      ): F[DescribeJobsResponse]

      def describeReplicationConfigurationTemplates(
        request: DescribeReplicationConfigurationTemplatesRequest
      ): F[DescribeReplicationConfigurationTemplatesResponse]

      def describeSourceServers(
        request: DescribeSourceServersRequest
      ): F[DescribeSourceServersResponse]

      def disconnectFromService(
        request: DisconnectFromServiceRequest
      ): F[DisconnectFromServiceResponse]

      def finalizeCutover(
        request: FinalizeCutoverRequest
      ): F[FinalizeCutoverResponse]

      def getLaunchConfiguration(
        request: GetLaunchConfigurationRequest
      ): F[GetLaunchConfigurationResponse]

      def getReplicationConfiguration(
        request: GetReplicationConfigurationRequest
      ): F[GetReplicationConfigurationResponse]

      def initializeService(
        request: InitializeServiceRequest
      ): F[InitializeServiceResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def markAsArchived(
        request: MarkAsArchivedRequest
      ): F[MarkAsArchivedResponse]

      def retryDataReplication(
        request: RetryDataReplicationRequest
      ): F[RetryDataReplicationResponse]

      def startCutover(
        request: StartCutoverRequest
      ): F[StartCutoverResponse]

      def startTest(
        request: StartTestRequest
      ): F[StartTestResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def terminateTargetInstances(
        request: TerminateTargetInstancesRequest
      ): F[TerminateTargetInstancesResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateLaunchConfiguration(
        request: UpdateLaunchConfigurationRequest
      ): F[UpdateLaunchConfigurationResponse]

      def updateReplicationConfiguration(
        request: UpdateReplicationConfigurationRequest
      ): F[UpdateReplicationConfigurationResponse]

      def updateReplicationConfigurationTemplate(
        request: UpdateReplicationConfigurationTemplateRequest
      ): F[UpdateReplicationConfigurationTemplateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends MgnOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ChangeServerLifeCycleStateOp(
      request: ChangeServerLifeCycleStateRequest
    ) extends MgnOp[ChangeServerLifeCycleStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ChangeServerLifeCycleStateResponse] =
        visitor.changeServerLifeCycleState(request)
    }

    final case class CreateReplicationConfigurationTemplateOp(
      request: CreateReplicationConfigurationTemplateRequest
    ) extends MgnOp[CreateReplicationConfigurationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationConfigurationTemplateResponse] =
        visitor.createReplicationConfigurationTemplate(request)
    }

    final case class DeleteJobOp(
      request: DeleteJobRequest
    ) extends MgnOp[DeleteJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobResponse] =
        visitor.deleteJob(request)
    }

    final case class DeleteReplicationConfigurationTemplateOp(
      request: DeleteReplicationConfigurationTemplateRequest
    ) extends MgnOp[DeleteReplicationConfigurationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationConfigurationTemplateResponse] =
        visitor.deleteReplicationConfigurationTemplate(request)
    }

    final case class DeleteSourceServerOp(
      request: DeleteSourceServerRequest
    ) extends MgnOp[DeleteSourceServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSourceServerResponse] =
        visitor.deleteSourceServer(request)
    }

    final case class DescribeJobLogItemsOp(
      request: DescribeJobLogItemsRequest
    ) extends MgnOp[DescribeJobLogItemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobLogItemsResponse] =
        visitor.describeJobLogItems(request)
    }

    final case class DescribeJobsOp(
      request: DescribeJobsRequest
    ) extends MgnOp[DescribeJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobsResponse] =
        visitor.describeJobs(request)
    }

    final case class DescribeReplicationConfigurationTemplatesOp(
      request: DescribeReplicationConfigurationTemplatesRequest
    ) extends MgnOp[DescribeReplicationConfigurationTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReplicationConfigurationTemplatesResponse] =
        visitor.describeReplicationConfigurationTemplates(request)
    }

    final case class DescribeSourceServersOp(
      request: DescribeSourceServersRequest
    ) extends MgnOp[DescribeSourceServersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSourceServersResponse] =
        visitor.describeSourceServers(request)
    }

    final case class DisconnectFromServiceOp(
      request: DisconnectFromServiceRequest
    ) extends MgnOp[DisconnectFromServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisconnectFromServiceResponse] =
        visitor.disconnectFromService(request)
    }

    final case class FinalizeCutoverOp(
      request: FinalizeCutoverRequest
    ) extends MgnOp[FinalizeCutoverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[FinalizeCutoverResponse] =
        visitor.finalizeCutover(request)
    }

    final case class GetLaunchConfigurationOp(
      request: GetLaunchConfigurationRequest
    ) extends MgnOp[GetLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLaunchConfigurationResponse] =
        visitor.getLaunchConfiguration(request)
    }

    final case class GetReplicationConfigurationOp(
      request: GetReplicationConfigurationRequest
    ) extends MgnOp[GetReplicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReplicationConfigurationResponse] =
        visitor.getReplicationConfiguration(request)
    }

    final case class InitializeServiceOp(
      request: InitializeServiceRequest
    ) extends MgnOp[InitializeServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitializeServiceResponse] =
        visitor.initializeService(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends MgnOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class MarkAsArchivedOp(
      request: MarkAsArchivedRequest
    ) extends MgnOp[MarkAsArchivedResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MarkAsArchivedResponse] =
        visitor.markAsArchived(request)
    }

    final case class RetryDataReplicationOp(
      request: RetryDataReplicationRequest
    ) extends MgnOp[RetryDataReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetryDataReplicationResponse] =
        visitor.retryDataReplication(request)
    }

    final case class StartCutoverOp(
      request: StartCutoverRequest
    ) extends MgnOp[StartCutoverResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCutoverResponse] =
        visitor.startCutover(request)
    }

    final case class StartTestOp(
      request: StartTestRequest
    ) extends MgnOp[StartTestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTestResponse] =
        visitor.startTest(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends MgnOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TerminateTargetInstancesOp(
      request: TerminateTargetInstancesRequest
    ) extends MgnOp[TerminateTargetInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateTargetInstancesResponse] =
        visitor.terminateTargetInstances(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends MgnOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateLaunchConfigurationOp(
      request: UpdateLaunchConfigurationRequest
    ) extends MgnOp[UpdateLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLaunchConfigurationResponse] =
        visitor.updateLaunchConfiguration(request)
    }

    final case class UpdateReplicationConfigurationOp(
      request: UpdateReplicationConfigurationRequest
    ) extends MgnOp[UpdateReplicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReplicationConfigurationResponse] =
        visitor.updateReplicationConfiguration(request)
    }

    final case class UpdateReplicationConfigurationTemplateOp(
      request: UpdateReplicationConfigurationTemplateRequest
    ) extends MgnOp[UpdateReplicationConfigurationTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReplicationConfigurationTemplateResponse] =
        visitor.updateReplicationConfigurationTemplate(request)
    }
  }

  import MgnOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[MgnOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def changeServerLifeCycleState(
    request: ChangeServerLifeCycleStateRequest
  ): MgnIO[ChangeServerLifeCycleStateResponse] =
    FF.liftF(ChangeServerLifeCycleStateOp(request))

  def createReplicationConfigurationTemplate(
    request: CreateReplicationConfigurationTemplateRequest
  ): MgnIO[CreateReplicationConfigurationTemplateResponse] =
    FF.liftF(CreateReplicationConfigurationTemplateOp(request))

  def deleteJob(
    request: DeleteJobRequest
  ): MgnIO[DeleteJobResponse] =
    FF.liftF(DeleteJobOp(request))

  def deleteReplicationConfigurationTemplate(
    request: DeleteReplicationConfigurationTemplateRequest
  ): MgnIO[DeleteReplicationConfigurationTemplateResponse] =
    FF.liftF(DeleteReplicationConfigurationTemplateOp(request))

  def deleteSourceServer(
    request: DeleteSourceServerRequest
  ): MgnIO[DeleteSourceServerResponse] =
    FF.liftF(DeleteSourceServerOp(request))

  def describeJobLogItems(
    request: DescribeJobLogItemsRequest
  ): MgnIO[DescribeJobLogItemsResponse] =
    FF.liftF(DescribeJobLogItemsOp(request))

  def describeJobs(
    request: DescribeJobsRequest
  ): MgnIO[DescribeJobsResponse] =
    FF.liftF(DescribeJobsOp(request))

  def describeReplicationConfigurationTemplates(
    request: DescribeReplicationConfigurationTemplatesRequest
  ): MgnIO[DescribeReplicationConfigurationTemplatesResponse] =
    FF.liftF(DescribeReplicationConfigurationTemplatesOp(request))

  def describeSourceServers(
    request: DescribeSourceServersRequest
  ): MgnIO[DescribeSourceServersResponse] =
    FF.liftF(DescribeSourceServersOp(request))

  def disconnectFromService(
    request: DisconnectFromServiceRequest
  ): MgnIO[DisconnectFromServiceResponse] =
    FF.liftF(DisconnectFromServiceOp(request))

  def finalizeCutover(
    request: FinalizeCutoverRequest
  ): MgnIO[FinalizeCutoverResponse] =
    FF.liftF(FinalizeCutoverOp(request))

  def getLaunchConfiguration(
    request: GetLaunchConfigurationRequest
  ): MgnIO[GetLaunchConfigurationResponse] =
    FF.liftF(GetLaunchConfigurationOp(request))

  def getReplicationConfiguration(
    request: GetReplicationConfigurationRequest
  ): MgnIO[GetReplicationConfigurationResponse] =
    FF.liftF(GetReplicationConfigurationOp(request))

  def initializeService(
    request: InitializeServiceRequest
  ): MgnIO[InitializeServiceResponse] =
    FF.liftF(InitializeServiceOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): MgnIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def markAsArchived(
    request: MarkAsArchivedRequest
  ): MgnIO[MarkAsArchivedResponse] =
    FF.liftF(MarkAsArchivedOp(request))

  def retryDataReplication(
    request: RetryDataReplicationRequest
  ): MgnIO[RetryDataReplicationResponse] =
    FF.liftF(RetryDataReplicationOp(request))

  def startCutover(
    request: StartCutoverRequest
  ): MgnIO[StartCutoverResponse] =
    FF.liftF(StartCutoverOp(request))

  def startTest(
    request: StartTestRequest
  ): MgnIO[StartTestResponse] =
    FF.liftF(StartTestOp(request))

  def tagResource(
    request: TagResourceRequest
  ): MgnIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def terminateTargetInstances(
    request: TerminateTargetInstancesRequest
  ): MgnIO[TerminateTargetInstancesResponse] =
    FF.liftF(TerminateTargetInstancesOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): MgnIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateLaunchConfiguration(
    request: UpdateLaunchConfigurationRequest
  ): MgnIO[UpdateLaunchConfigurationResponse] =
    FF.liftF(UpdateLaunchConfigurationOp(request))

  def updateReplicationConfiguration(
    request: UpdateReplicationConfigurationRequest
  ): MgnIO[UpdateReplicationConfigurationResponse] =
    FF.liftF(UpdateReplicationConfigurationOp(request))

  def updateReplicationConfigurationTemplate(
    request: UpdateReplicationConfigurationTemplateRequest
  ): MgnIO[UpdateReplicationConfigurationTemplateResponse] =
    FF.liftF(UpdateReplicationConfigurationTemplateOp(request))
}
