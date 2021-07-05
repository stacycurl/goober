package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.amplify.AmplifyClient
import software.amazon.awssdk.services.amplify.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object amplify { module =>

  // Free monad over AmplifyOp
  type AmplifyIO[A] = FF[AmplifyOp, A]

  sealed trait AmplifyOp[A] {
    def visit[F[_]](visitor: AmplifyOp.Visitor[F]): F[A]
  }

  object AmplifyOp {
    // Given a AmplifyClient we can embed a AmplifyIO program in any algebra that understands embedding.
    implicit val AmplifyOpEmbeddable: Embeddable[AmplifyOp, AmplifyClient] = new Embeddable[AmplifyOp, AmplifyClient] {
      def embed[A](client: AmplifyClient, io: AmplifyIO[A]): Embedded[A] = Embedded.Amplify(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AmplifyOp.Visitor[Kleisli[M, AmplifyClient, *]] {
        def createApp(
          request: CreateAppRequest
        ): Kleisli[M, AmplifyClient, CreateAppResponse] =
          primitive(_.createApp(request))

        def createBackendEnvironment(
          request: CreateBackendEnvironmentRequest
        ): Kleisli[M, AmplifyClient, CreateBackendEnvironmentResponse] =
          primitive(_.createBackendEnvironment(request))

        def createBranch(
          request: CreateBranchRequest
        ): Kleisli[M, AmplifyClient, CreateBranchResponse] =
          primitive(_.createBranch(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, AmplifyClient, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def createDomainAssociation(
          request: CreateDomainAssociationRequest
        ): Kleisli[M, AmplifyClient, CreateDomainAssociationResponse] =
          primitive(_.createDomainAssociation(request))

        def createWebhook(
          request: CreateWebhookRequest
        ): Kleisli[M, AmplifyClient, CreateWebhookResponse] =
          primitive(_.createWebhook(request))

        def deleteApp(
          request: DeleteAppRequest
        ): Kleisli[M, AmplifyClient, DeleteAppResponse] =
          primitive(_.deleteApp(request))

        def deleteBackendEnvironment(
          request: DeleteBackendEnvironmentRequest
        ): Kleisli[M, AmplifyClient, DeleteBackendEnvironmentResponse] =
          primitive(_.deleteBackendEnvironment(request))

        def deleteBranch(
          request: DeleteBranchRequest
        ): Kleisli[M, AmplifyClient, DeleteBranchResponse] =
          primitive(_.deleteBranch(request))

        def deleteDomainAssociation(
          request: DeleteDomainAssociationRequest
        ): Kleisli[M, AmplifyClient, DeleteDomainAssociationResponse] =
          primitive(_.deleteDomainAssociation(request))

        def deleteJob(
          request: DeleteJobRequest
        ): Kleisli[M, AmplifyClient, DeleteJobResponse] =
          primitive(_.deleteJob(request))

        def deleteWebhook(
          request: DeleteWebhookRequest
        ): Kleisli[M, AmplifyClient, DeleteWebhookResponse] =
          primitive(_.deleteWebhook(request))

        def generateAccessLogs(
          request: GenerateAccessLogsRequest
        ): Kleisli[M, AmplifyClient, GenerateAccessLogsResponse] =
          primitive(_.generateAccessLogs(request))

        def getApp(
          request: GetAppRequest
        ): Kleisli[M, AmplifyClient, GetAppResponse] =
          primitive(_.getApp(request))

        def getArtifactUrl(
          request: GetArtifactUrlRequest
        ): Kleisli[M, AmplifyClient, GetArtifactUrlResponse] =
          primitive(_.getArtifactUrl(request))

        def getBackendEnvironment(
          request: GetBackendEnvironmentRequest
        ): Kleisli[M, AmplifyClient, GetBackendEnvironmentResponse] =
          primitive(_.getBackendEnvironment(request))

        def getBranch(
          request: GetBranchRequest
        ): Kleisli[M, AmplifyClient, GetBranchResponse] =
          primitive(_.getBranch(request))

        def getDomainAssociation(
          request: GetDomainAssociationRequest
        ): Kleisli[M, AmplifyClient, GetDomainAssociationResponse] =
          primitive(_.getDomainAssociation(request))

        def getJob(
          request: GetJobRequest
        ): Kleisli[M, AmplifyClient, GetJobResponse] =
          primitive(_.getJob(request))

        def getWebhook(
          request: GetWebhookRequest
        ): Kleisli[M, AmplifyClient, GetWebhookResponse] =
          primitive(_.getWebhook(request))

        def listApps(
          request: ListAppsRequest
        ): Kleisli[M, AmplifyClient, ListAppsResponse] =
          primitive(_.listApps(request))

        def listArtifacts(
          request: ListArtifactsRequest
        ): Kleisli[M, AmplifyClient, ListArtifactsResponse] =
          primitive(_.listArtifacts(request))

        def listBackendEnvironments(
          request: ListBackendEnvironmentsRequest
        ): Kleisli[M, AmplifyClient, ListBackendEnvironmentsResponse] =
          primitive(_.listBackendEnvironments(request))

        def listBranches(
          request: ListBranchesRequest
        ): Kleisli[M, AmplifyClient, ListBranchesResponse] =
          primitive(_.listBranches(request))

        def listDomainAssociations(
          request: ListDomainAssociationsRequest
        ): Kleisli[M, AmplifyClient, ListDomainAssociationsResponse] =
          primitive(_.listDomainAssociations(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, AmplifyClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AmplifyClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWebhooks(
          request: ListWebhooksRequest
        ): Kleisli[M, AmplifyClient, ListWebhooksResponse] =
          primitive(_.listWebhooks(request))

        def startDeployment(
          request: StartDeploymentRequest
        ): Kleisli[M, AmplifyClient, StartDeploymentResponse] =
          primitive(_.startDeployment(request))

        def startJob(
          request: StartJobRequest
        ): Kleisli[M, AmplifyClient, StartJobResponse] =
          primitive(_.startJob(request))

        def stopJob(
          request: StopJobRequest
        ): Kleisli[M, AmplifyClient, StopJobResponse] =
          primitive(_.stopJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AmplifyClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AmplifyClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApp(
          request: UpdateAppRequest
        ): Kleisli[M, AmplifyClient, UpdateAppResponse] =
          primitive(_.updateApp(request))

        def updateBranch(
          request: UpdateBranchRequest
        ): Kleisli[M, AmplifyClient, UpdateBranchResponse] =
          primitive(_.updateBranch(request))

        def updateDomainAssociation(
          request: UpdateDomainAssociationRequest
        ): Kleisli[M, AmplifyClient, UpdateDomainAssociationResponse] =
          primitive(_.updateDomainAssociation(request))

        def updateWebhook(
          request: UpdateWebhookRequest
        ): Kleisli[M, AmplifyClient, UpdateWebhookResponse] =
          primitive(_.updateWebhook(request))

        def primitive[A](
          f: AmplifyClient => A
        ): Kleisli[M, AmplifyClient, A]
      }
    }

    trait Visitor[F[_]] extends (AmplifyOp ~> F) {
      final def apply[A](op: AmplifyOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApp(
        request: CreateAppRequest
      ): F[CreateAppResponse]

      def createBackendEnvironment(
        request: CreateBackendEnvironmentRequest
      ): F[CreateBackendEnvironmentResponse]

      def createBranch(
        request: CreateBranchRequest
      ): F[CreateBranchResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def createDomainAssociation(
        request: CreateDomainAssociationRequest
      ): F[CreateDomainAssociationResponse]

      def createWebhook(
        request: CreateWebhookRequest
      ): F[CreateWebhookResponse]

      def deleteApp(
        request: DeleteAppRequest
      ): F[DeleteAppResponse]

      def deleteBackendEnvironment(
        request: DeleteBackendEnvironmentRequest
      ): F[DeleteBackendEnvironmentResponse]

      def deleteBranch(
        request: DeleteBranchRequest
      ): F[DeleteBranchResponse]

      def deleteDomainAssociation(
        request: DeleteDomainAssociationRequest
      ): F[DeleteDomainAssociationResponse]

      def deleteJob(
        request: DeleteJobRequest
      ): F[DeleteJobResponse]

      def deleteWebhook(
        request: DeleteWebhookRequest
      ): F[DeleteWebhookResponse]

      def generateAccessLogs(
        request: GenerateAccessLogsRequest
      ): F[GenerateAccessLogsResponse]

      def getApp(
        request: GetAppRequest
      ): F[GetAppResponse]

      def getArtifactUrl(
        request: GetArtifactUrlRequest
      ): F[GetArtifactUrlResponse]

      def getBackendEnvironment(
        request: GetBackendEnvironmentRequest
      ): F[GetBackendEnvironmentResponse]

      def getBranch(
        request: GetBranchRequest
      ): F[GetBranchResponse]

      def getDomainAssociation(
        request: GetDomainAssociationRequest
      ): F[GetDomainAssociationResponse]

      def getJob(
        request: GetJobRequest
      ): F[GetJobResponse]

      def getWebhook(
        request: GetWebhookRequest
      ): F[GetWebhookResponse]

      def listApps(
        request: ListAppsRequest
      ): F[ListAppsResponse]

      def listArtifacts(
        request: ListArtifactsRequest
      ): F[ListArtifactsResponse]

      def listBackendEnvironments(
        request: ListBackendEnvironmentsRequest
      ): F[ListBackendEnvironmentsResponse]

      def listBranches(
        request: ListBranchesRequest
      ): F[ListBranchesResponse]

      def listDomainAssociations(
        request: ListDomainAssociationsRequest
      ): F[ListDomainAssociationsResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWebhooks(
        request: ListWebhooksRequest
      ): F[ListWebhooksResponse]

      def startDeployment(
        request: StartDeploymentRequest
      ): F[StartDeploymentResponse]

      def startJob(
        request: StartJobRequest
      ): F[StartJobResponse]

      def stopJob(
        request: StopJobRequest
      ): F[StopJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApp(
        request: UpdateAppRequest
      ): F[UpdateAppResponse]

      def updateBranch(
        request: UpdateBranchRequest
      ): F[UpdateBranchResponse]

      def updateDomainAssociation(
        request: UpdateDomainAssociationRequest
      ): F[UpdateDomainAssociationResponse]

      def updateWebhook(
        request: UpdateWebhookRequest
      ): F[UpdateWebhookResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AmplifyOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAppOp(
      request: CreateAppRequest
    ) extends AmplifyOp[CreateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppResponse] =
        visitor.createApp(request)
    }

    final case class CreateBackendEnvironmentOp(
      request: CreateBackendEnvironmentRequest
    ) extends AmplifyOp[CreateBackendEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackendEnvironmentResponse] =
        visitor.createBackendEnvironment(request)
    }

    final case class CreateBranchOp(
      request: CreateBranchRequest
    ) extends AmplifyOp[CreateBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBranchResponse] =
        visitor.createBranch(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends AmplifyOp[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class CreateDomainAssociationOp(
      request: CreateDomainAssociationRequest
    ) extends AmplifyOp[CreateDomainAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDomainAssociationResponse] =
        visitor.createDomainAssociation(request)
    }

    final case class CreateWebhookOp(
      request: CreateWebhookRequest
    ) extends AmplifyOp[CreateWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebhookResponse] =
        visitor.createWebhook(request)
    }

    final case class DeleteAppOp(
      request: DeleteAppRequest
    ) extends AmplifyOp[DeleteAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppResponse] =
        visitor.deleteApp(request)
    }

    final case class DeleteBackendEnvironmentOp(
      request: DeleteBackendEnvironmentRequest
    ) extends AmplifyOp[DeleteBackendEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackendEnvironmentResponse] =
        visitor.deleteBackendEnvironment(request)
    }

    final case class DeleteBranchOp(
      request: DeleteBranchRequest
    ) extends AmplifyOp[DeleteBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBranchResponse] =
        visitor.deleteBranch(request)
    }

    final case class DeleteDomainAssociationOp(
      request: DeleteDomainAssociationRequest
    ) extends AmplifyOp[DeleteDomainAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDomainAssociationResponse] =
        visitor.deleteDomainAssociation(request)
    }

    final case class DeleteJobOp(
      request: DeleteJobRequest
    ) extends AmplifyOp[DeleteJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobResponse] =
        visitor.deleteJob(request)
    }

    final case class DeleteWebhookOp(
      request: DeleteWebhookRequest
    ) extends AmplifyOp[DeleteWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWebhookResponse] =
        visitor.deleteWebhook(request)
    }

    final case class GenerateAccessLogsOp(
      request: GenerateAccessLogsRequest
    ) extends AmplifyOp[GenerateAccessLogsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateAccessLogsResponse] =
        visitor.generateAccessLogs(request)
    }

    final case class GetAppOp(
      request: GetAppRequest
    ) extends AmplifyOp[GetAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppResponse] =
        visitor.getApp(request)
    }

    final case class GetArtifactUrlOp(
      request: GetArtifactUrlRequest
    ) extends AmplifyOp[GetArtifactUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetArtifactUrlResponse] =
        visitor.getArtifactUrl(request)
    }

    final case class GetBackendEnvironmentOp(
      request: GetBackendEnvironmentRequest
    ) extends AmplifyOp[GetBackendEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBackendEnvironmentResponse] =
        visitor.getBackendEnvironment(request)
    }

    final case class GetBranchOp(
      request: GetBranchRequest
    ) extends AmplifyOp[GetBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBranchResponse] =
        visitor.getBranch(request)
    }

    final case class GetDomainAssociationOp(
      request: GetDomainAssociationRequest
    ) extends AmplifyOp[GetDomainAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDomainAssociationResponse] =
        visitor.getDomainAssociation(request)
    }

    final case class GetJobOp(
      request: GetJobRequest
    ) extends AmplifyOp[GetJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobResponse] =
        visitor.getJob(request)
    }

    final case class GetWebhookOp(
      request: GetWebhookRequest
    ) extends AmplifyOp[GetWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWebhookResponse] =
        visitor.getWebhook(request)
    }

    final case class ListAppsOp(
      request: ListAppsRequest
    ) extends AmplifyOp[ListAppsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppsResponse] =
        visitor.listApps(request)
    }

    final case class ListArtifactsOp(
      request: ListArtifactsRequest
    ) extends AmplifyOp[ListArtifactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListArtifactsResponse] =
        visitor.listArtifacts(request)
    }

    final case class ListBackendEnvironmentsOp(
      request: ListBackendEnvironmentsRequest
    ) extends AmplifyOp[ListBackendEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBackendEnvironmentsResponse] =
        visitor.listBackendEnvironments(request)
    }

    final case class ListBranchesOp(
      request: ListBranchesRequest
    ) extends AmplifyOp[ListBranchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBranchesResponse] =
        visitor.listBranches(request)
    }

    final case class ListDomainAssociationsOp(
      request: ListDomainAssociationsRequest
    ) extends AmplifyOp[ListDomainAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDomainAssociationsResponse] =
        visitor.listDomainAssociations(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends AmplifyOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AmplifyOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWebhooksOp(
      request: ListWebhooksRequest
    ) extends AmplifyOp[ListWebhooksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWebhooksResponse] =
        visitor.listWebhooks(request)
    }

    final case class StartDeploymentOp(
      request: StartDeploymentRequest
    ) extends AmplifyOp[StartDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDeploymentResponse] =
        visitor.startDeployment(request)
    }

    final case class StartJobOp(
      request: StartJobRequest
    ) extends AmplifyOp[StartJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartJobResponse] =
        visitor.startJob(request)
    }

    final case class StopJobOp(
      request: StopJobRequest
    ) extends AmplifyOp[StopJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopJobResponse] =
        visitor.stopJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AmplifyOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AmplifyOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAppOp(
      request: UpdateAppRequest
    ) extends AmplifyOp[UpdateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAppResponse] =
        visitor.updateApp(request)
    }

    final case class UpdateBranchOp(
      request: UpdateBranchRequest
    ) extends AmplifyOp[UpdateBranchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBranchResponse] =
        visitor.updateBranch(request)
    }

    final case class UpdateDomainAssociationOp(
      request: UpdateDomainAssociationRequest
    ) extends AmplifyOp[UpdateDomainAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDomainAssociationResponse] =
        visitor.updateDomainAssociation(request)
    }

    final case class UpdateWebhookOp(
      request: UpdateWebhookRequest
    ) extends AmplifyOp[UpdateWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWebhookResponse] =
        visitor.updateWebhook(request)
    }
  }

  import AmplifyOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AmplifyOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApp(
    request: CreateAppRequest
  ): AmplifyIO[CreateAppResponse] =
    FF.liftF(CreateAppOp(request))

  def createBackendEnvironment(
    request: CreateBackendEnvironmentRequest
  ): AmplifyIO[CreateBackendEnvironmentResponse] =
    FF.liftF(CreateBackendEnvironmentOp(request))

  def createBranch(
    request: CreateBranchRequest
  ): AmplifyIO[CreateBranchResponse] =
    FF.liftF(CreateBranchOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): AmplifyIO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def createDomainAssociation(
    request: CreateDomainAssociationRequest
  ): AmplifyIO[CreateDomainAssociationResponse] =
    FF.liftF(CreateDomainAssociationOp(request))

  def createWebhook(
    request: CreateWebhookRequest
  ): AmplifyIO[CreateWebhookResponse] =
    FF.liftF(CreateWebhookOp(request))

  def deleteApp(
    request: DeleteAppRequest
  ): AmplifyIO[DeleteAppResponse] =
    FF.liftF(DeleteAppOp(request))

  def deleteBackendEnvironment(
    request: DeleteBackendEnvironmentRequest
  ): AmplifyIO[DeleteBackendEnvironmentResponse] =
    FF.liftF(DeleteBackendEnvironmentOp(request))

  def deleteBranch(
    request: DeleteBranchRequest
  ): AmplifyIO[DeleteBranchResponse] =
    FF.liftF(DeleteBranchOp(request))

  def deleteDomainAssociation(
    request: DeleteDomainAssociationRequest
  ): AmplifyIO[DeleteDomainAssociationResponse] =
    FF.liftF(DeleteDomainAssociationOp(request))

  def deleteJob(
    request: DeleteJobRequest
  ): AmplifyIO[DeleteJobResponse] =
    FF.liftF(DeleteJobOp(request))

  def deleteWebhook(
    request: DeleteWebhookRequest
  ): AmplifyIO[DeleteWebhookResponse] =
    FF.liftF(DeleteWebhookOp(request))

  def generateAccessLogs(
    request: GenerateAccessLogsRequest
  ): AmplifyIO[GenerateAccessLogsResponse] =
    FF.liftF(GenerateAccessLogsOp(request))

  def getApp(
    request: GetAppRequest
  ): AmplifyIO[GetAppResponse] =
    FF.liftF(GetAppOp(request))

  def getArtifactUrl(
    request: GetArtifactUrlRequest
  ): AmplifyIO[GetArtifactUrlResponse] =
    FF.liftF(GetArtifactUrlOp(request))

  def getBackendEnvironment(
    request: GetBackendEnvironmentRequest
  ): AmplifyIO[GetBackendEnvironmentResponse] =
    FF.liftF(GetBackendEnvironmentOp(request))

  def getBranch(
    request: GetBranchRequest
  ): AmplifyIO[GetBranchResponse] =
    FF.liftF(GetBranchOp(request))

  def getDomainAssociation(
    request: GetDomainAssociationRequest
  ): AmplifyIO[GetDomainAssociationResponse] =
    FF.liftF(GetDomainAssociationOp(request))

  def getJob(
    request: GetJobRequest
  ): AmplifyIO[GetJobResponse] =
    FF.liftF(GetJobOp(request))

  def getWebhook(
    request: GetWebhookRequest
  ): AmplifyIO[GetWebhookResponse] =
    FF.liftF(GetWebhookOp(request))

  def listApps(
    request: ListAppsRequest
  ): AmplifyIO[ListAppsResponse] =
    FF.liftF(ListAppsOp(request))

  def listArtifacts(
    request: ListArtifactsRequest
  ): AmplifyIO[ListArtifactsResponse] =
    FF.liftF(ListArtifactsOp(request))

  def listBackendEnvironments(
    request: ListBackendEnvironmentsRequest
  ): AmplifyIO[ListBackendEnvironmentsResponse] =
    FF.liftF(ListBackendEnvironmentsOp(request))

  def listBranches(
    request: ListBranchesRequest
  ): AmplifyIO[ListBranchesResponse] =
    FF.liftF(ListBranchesOp(request))

  def listDomainAssociations(
    request: ListDomainAssociationsRequest
  ): AmplifyIO[ListDomainAssociationsResponse] =
    FF.liftF(ListDomainAssociationsOp(request))

  def listJobs(
    request: ListJobsRequest
  ): AmplifyIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AmplifyIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWebhooks(
    request: ListWebhooksRequest
  ): AmplifyIO[ListWebhooksResponse] =
    FF.liftF(ListWebhooksOp(request))

  def startDeployment(
    request: StartDeploymentRequest
  ): AmplifyIO[StartDeploymentResponse] =
    FF.liftF(StartDeploymentOp(request))

  def startJob(
    request: StartJobRequest
  ): AmplifyIO[StartJobResponse] =
    FF.liftF(StartJobOp(request))

  def stopJob(
    request: StopJobRequest
  ): AmplifyIO[StopJobResponse] =
    FF.liftF(StopJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AmplifyIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AmplifyIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApp(
    request: UpdateAppRequest
  ): AmplifyIO[UpdateAppResponse] =
    FF.liftF(UpdateAppOp(request))

  def updateBranch(
    request: UpdateBranchRequest
  ): AmplifyIO[UpdateBranchResponse] =
    FF.liftF(UpdateBranchOp(request))

  def updateDomainAssociation(
    request: UpdateDomainAssociationRequest
  ): AmplifyIO[UpdateDomainAssociationResponse] =
    FF.liftF(UpdateDomainAssociationOp(request))

  def updateWebhook(
    request: UpdateWebhookRequest
  ): AmplifyIO[UpdateWebhookResponse] =
    FF.liftF(UpdateWebhookOp(request))
}
