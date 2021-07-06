package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.sms.SmsClient
import software.amazon.awssdk.services.sms.model._


object sms { module =>

  // Free monad over SmsOp
  type SmsIO[A] = FF[SmsOp, A]

  sealed trait SmsOp[A] {
    def visit[F[_]](visitor: SmsOp.Visitor[F]): F[A]
  }

  object SmsOp {
    // Given a SmsClient we can embed a SmsIO program in any algebra that understands embedding.
    implicit val SmsOpEmbeddable: Embeddable[SmsOp, SmsClient] = new Embeddable[SmsOp, SmsClient] {
      def embed[A](client: SmsClient, io: SmsIO[A]): Embedded[A] = Embedded.Sms(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SmsOp.Visitor[Kleisli[M, SmsClient, *]] {
        def createApp(
          request: CreateAppRequest
        ): Kleisli[M, SmsClient, CreateAppResponse] =
          primitive(_.createApp(request))

        def createReplicationJob(
          request: CreateReplicationJobRequest
        ): Kleisli[M, SmsClient, CreateReplicationJobResponse] =
          primitive(_.createReplicationJob(request))

        def deleteApp(
          request: DeleteAppRequest
        ): Kleisli[M, SmsClient, DeleteAppResponse] =
          primitive(_.deleteApp(request))

        def deleteAppLaunchConfiguration(
          request: DeleteAppLaunchConfigurationRequest
        ): Kleisli[M, SmsClient, DeleteAppLaunchConfigurationResponse] =
          primitive(_.deleteAppLaunchConfiguration(request))

        def deleteAppReplicationConfiguration(
          request: DeleteAppReplicationConfigurationRequest
        ): Kleisli[M, SmsClient, DeleteAppReplicationConfigurationResponse] =
          primitive(_.deleteAppReplicationConfiguration(request))

        def deleteAppValidationConfiguration(
          request: DeleteAppValidationConfigurationRequest
        ): Kleisli[M, SmsClient, DeleteAppValidationConfigurationResponse] =
          primitive(_.deleteAppValidationConfiguration(request))

        def deleteReplicationJob(
          request: DeleteReplicationJobRequest
        ): Kleisli[M, SmsClient, DeleteReplicationJobResponse] =
          primitive(_.deleteReplicationJob(request))

        def deleteServerCatalog(
          request: DeleteServerCatalogRequest
        ): Kleisli[M, SmsClient, DeleteServerCatalogResponse] =
          primitive(_.deleteServerCatalog(request))

        def disassociateConnector(
          request: DisassociateConnectorRequest
        ): Kleisli[M, SmsClient, DisassociateConnectorResponse] =
          primitive(_.disassociateConnector(request))

        def generateChangeSet(
          request: GenerateChangeSetRequest
        ): Kleisli[M, SmsClient, GenerateChangeSetResponse] =
          primitive(_.generateChangeSet(request))

        def generateTemplate(
          request: GenerateTemplateRequest
        ): Kleisli[M, SmsClient, GenerateTemplateResponse] =
          primitive(_.generateTemplate(request))

        def getApp(
          request: GetAppRequest
        ): Kleisli[M, SmsClient, GetAppResponse] =
          primitive(_.getApp(request))

        def getAppLaunchConfiguration(
          request: GetAppLaunchConfigurationRequest
        ): Kleisli[M, SmsClient, GetAppLaunchConfigurationResponse] =
          primitive(_.getAppLaunchConfiguration(request))

        def getAppReplicationConfiguration(
          request: GetAppReplicationConfigurationRequest
        ): Kleisli[M, SmsClient, GetAppReplicationConfigurationResponse] =
          primitive(_.getAppReplicationConfiguration(request))

        def getAppValidationConfiguration(
          request: GetAppValidationConfigurationRequest
        ): Kleisli[M, SmsClient, GetAppValidationConfigurationResponse] =
          primitive(_.getAppValidationConfiguration(request))

        def getAppValidationOutput(
          request: GetAppValidationOutputRequest
        ): Kleisli[M, SmsClient, GetAppValidationOutputResponse] =
          primitive(_.getAppValidationOutput(request))

        def getConnectors(
          request: GetConnectorsRequest
        ): Kleisli[M, SmsClient, GetConnectorsResponse] =
          primitive(_.getConnectors(request))

        def getReplicationJobs(
          request: GetReplicationJobsRequest
        ): Kleisli[M, SmsClient, GetReplicationJobsResponse] =
          primitive(_.getReplicationJobs(request))

        def getReplicationRuns(
          request: GetReplicationRunsRequest
        ): Kleisli[M, SmsClient, GetReplicationRunsResponse] =
          primitive(_.getReplicationRuns(request))

        def getServers(
          request: GetServersRequest
        ): Kleisli[M, SmsClient, GetServersResponse] =
          primitive(_.getServers(request))

        def importAppCatalog(
          request: ImportAppCatalogRequest
        ): Kleisli[M, SmsClient, ImportAppCatalogResponse] =
          primitive(_.importAppCatalog(request))

        def importServerCatalog(
          request: ImportServerCatalogRequest
        ): Kleisli[M, SmsClient, ImportServerCatalogResponse] =
          primitive(_.importServerCatalog(request))

        def launchApp(
          request: LaunchAppRequest
        ): Kleisli[M, SmsClient, LaunchAppResponse] =
          primitive(_.launchApp(request))

        def listApps(
          request: ListAppsRequest
        ): Kleisli[M, SmsClient, ListAppsResponse] =
          primitive(_.listApps(request))

        def notifyAppValidationOutput(
          request: NotifyAppValidationOutputRequest
        ): Kleisli[M, SmsClient, NotifyAppValidationOutputResponse] =
          primitive(_.notifyAppValidationOutput(request))

        def putAppLaunchConfiguration(
          request: PutAppLaunchConfigurationRequest
        ): Kleisli[M, SmsClient, PutAppLaunchConfigurationResponse] =
          primitive(_.putAppLaunchConfiguration(request))

        def putAppReplicationConfiguration(
          request: PutAppReplicationConfigurationRequest
        ): Kleisli[M, SmsClient, PutAppReplicationConfigurationResponse] =
          primitive(_.putAppReplicationConfiguration(request))

        def putAppValidationConfiguration(
          request: PutAppValidationConfigurationRequest
        ): Kleisli[M, SmsClient, PutAppValidationConfigurationResponse] =
          primitive(_.putAppValidationConfiguration(request))

        def startAppReplication(
          request: StartAppReplicationRequest
        ): Kleisli[M, SmsClient, StartAppReplicationResponse] =
          primitive(_.startAppReplication(request))

        def startOnDemandAppReplication(
          request: StartOnDemandAppReplicationRequest
        ): Kleisli[M, SmsClient, StartOnDemandAppReplicationResponse] =
          primitive(_.startOnDemandAppReplication(request))

        def startOnDemandReplicationRun(
          request: StartOnDemandReplicationRunRequest
        ): Kleisli[M, SmsClient, StartOnDemandReplicationRunResponse] =
          primitive(_.startOnDemandReplicationRun(request))

        def stopAppReplication(
          request: StopAppReplicationRequest
        ): Kleisli[M, SmsClient, StopAppReplicationResponse] =
          primitive(_.stopAppReplication(request))

        def terminateApp(
          request: TerminateAppRequest
        ): Kleisli[M, SmsClient, TerminateAppResponse] =
          primitive(_.terminateApp(request))

        def updateApp(
          request: UpdateAppRequest
        ): Kleisli[M, SmsClient, UpdateAppResponse] =
          primitive(_.updateApp(request))

        def updateReplicationJob(
          request: UpdateReplicationJobRequest
        ): Kleisli[M, SmsClient, UpdateReplicationJobResponse] =
          primitive(_.updateReplicationJob(request))

        def primitive[A](
          f: SmsClient => A
        ): Kleisli[M, SmsClient, A]
      }
    }

    trait Visitor[F[_]] extends (SmsOp ~> F) {
      final def apply[A](op: SmsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApp(
        request: CreateAppRequest
      ): F[CreateAppResponse]

      def createReplicationJob(
        request: CreateReplicationJobRequest
      ): F[CreateReplicationJobResponse]

      def deleteApp(
        request: DeleteAppRequest
      ): F[DeleteAppResponse]

      def deleteAppLaunchConfiguration(
        request: DeleteAppLaunchConfigurationRequest
      ): F[DeleteAppLaunchConfigurationResponse]

      def deleteAppReplicationConfiguration(
        request: DeleteAppReplicationConfigurationRequest
      ): F[DeleteAppReplicationConfigurationResponse]

      def deleteAppValidationConfiguration(
        request: DeleteAppValidationConfigurationRequest
      ): F[DeleteAppValidationConfigurationResponse]

      def deleteReplicationJob(
        request: DeleteReplicationJobRequest
      ): F[DeleteReplicationJobResponse]

      def deleteServerCatalog(
        request: DeleteServerCatalogRequest
      ): F[DeleteServerCatalogResponse]

      def disassociateConnector(
        request: DisassociateConnectorRequest
      ): F[DisassociateConnectorResponse]

      def generateChangeSet(
        request: GenerateChangeSetRequest
      ): F[GenerateChangeSetResponse]

      def generateTemplate(
        request: GenerateTemplateRequest
      ): F[GenerateTemplateResponse]

      def getApp(
        request: GetAppRequest
      ): F[GetAppResponse]

      def getAppLaunchConfiguration(
        request: GetAppLaunchConfigurationRequest
      ): F[GetAppLaunchConfigurationResponse]

      def getAppReplicationConfiguration(
        request: GetAppReplicationConfigurationRequest
      ): F[GetAppReplicationConfigurationResponse]

      def getAppValidationConfiguration(
        request: GetAppValidationConfigurationRequest
      ): F[GetAppValidationConfigurationResponse]

      def getAppValidationOutput(
        request: GetAppValidationOutputRequest
      ): F[GetAppValidationOutputResponse]

      def getConnectors(
        request: GetConnectorsRequest
      ): F[GetConnectorsResponse]

      def getReplicationJobs(
        request: GetReplicationJobsRequest
      ): F[GetReplicationJobsResponse]

      def getReplicationRuns(
        request: GetReplicationRunsRequest
      ): F[GetReplicationRunsResponse]

      def getServers(
        request: GetServersRequest
      ): F[GetServersResponse]

      def importAppCatalog(
        request: ImportAppCatalogRequest
      ): F[ImportAppCatalogResponse]

      def importServerCatalog(
        request: ImportServerCatalogRequest
      ): F[ImportServerCatalogResponse]

      def launchApp(
        request: LaunchAppRequest
      ): F[LaunchAppResponse]

      def listApps(
        request: ListAppsRequest
      ): F[ListAppsResponse]

      def notifyAppValidationOutput(
        request: NotifyAppValidationOutputRequest
      ): F[NotifyAppValidationOutputResponse]

      def putAppLaunchConfiguration(
        request: PutAppLaunchConfigurationRequest
      ): F[PutAppLaunchConfigurationResponse]

      def putAppReplicationConfiguration(
        request: PutAppReplicationConfigurationRequest
      ): F[PutAppReplicationConfigurationResponse]

      def putAppValidationConfiguration(
        request: PutAppValidationConfigurationRequest
      ): F[PutAppValidationConfigurationResponse]

      def startAppReplication(
        request: StartAppReplicationRequest
      ): F[StartAppReplicationResponse]

      def startOnDemandAppReplication(
        request: StartOnDemandAppReplicationRequest
      ): F[StartOnDemandAppReplicationResponse]

      def startOnDemandReplicationRun(
        request: StartOnDemandReplicationRunRequest
      ): F[StartOnDemandReplicationRunResponse]

      def stopAppReplication(
        request: StopAppReplicationRequest
      ): F[StopAppReplicationResponse]

      def terminateApp(
        request: TerminateAppRequest
      ): F[TerminateAppResponse]

      def updateApp(
        request: UpdateAppRequest
      ): F[UpdateAppResponse]

      def updateReplicationJob(
        request: UpdateReplicationJobRequest
      ): F[UpdateReplicationJobResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SmsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAppOp(
      request: CreateAppRequest
    ) extends SmsOp[CreateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppResponse] =
        visitor.createApp(request)
    }

    final case class CreateReplicationJobOp(
      request: CreateReplicationJobRequest
    ) extends SmsOp[CreateReplicationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReplicationJobResponse] =
        visitor.createReplicationJob(request)
    }

    final case class DeleteAppOp(
      request: DeleteAppRequest
    ) extends SmsOp[DeleteAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppResponse] =
        visitor.deleteApp(request)
    }

    final case class DeleteAppLaunchConfigurationOp(
      request: DeleteAppLaunchConfigurationRequest
    ) extends SmsOp[DeleteAppLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppLaunchConfigurationResponse] =
        visitor.deleteAppLaunchConfiguration(request)
    }

    final case class DeleteAppReplicationConfigurationOp(
      request: DeleteAppReplicationConfigurationRequest
    ) extends SmsOp[DeleteAppReplicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppReplicationConfigurationResponse] =
        visitor.deleteAppReplicationConfiguration(request)
    }

    final case class DeleteAppValidationConfigurationOp(
      request: DeleteAppValidationConfigurationRequest
    ) extends SmsOp[DeleteAppValidationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppValidationConfigurationResponse] =
        visitor.deleteAppValidationConfiguration(request)
    }

    final case class DeleteReplicationJobOp(
      request: DeleteReplicationJobRequest
    ) extends SmsOp[DeleteReplicationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReplicationJobResponse] =
        visitor.deleteReplicationJob(request)
    }

    final case class DeleteServerCatalogOp(
      request: DeleteServerCatalogRequest
    ) extends SmsOp[DeleteServerCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServerCatalogResponse] =
        visitor.deleteServerCatalog(request)
    }

    final case class DisassociateConnectorOp(
      request: DisassociateConnectorRequest
    ) extends SmsOp[DisassociateConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateConnectorResponse] =
        visitor.disassociateConnector(request)
    }

    final case class GenerateChangeSetOp(
      request: GenerateChangeSetRequest
    ) extends SmsOp[GenerateChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateChangeSetResponse] =
        visitor.generateChangeSet(request)
    }

    final case class GenerateTemplateOp(
      request: GenerateTemplateRequest
    ) extends SmsOp[GenerateTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GenerateTemplateResponse] =
        visitor.generateTemplate(request)
    }

    final case class GetAppOp(
      request: GetAppRequest
    ) extends SmsOp[GetAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppResponse] =
        visitor.getApp(request)
    }

    final case class GetAppLaunchConfigurationOp(
      request: GetAppLaunchConfigurationRequest
    ) extends SmsOp[GetAppLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppLaunchConfigurationResponse] =
        visitor.getAppLaunchConfiguration(request)
    }

    final case class GetAppReplicationConfigurationOp(
      request: GetAppReplicationConfigurationRequest
    ) extends SmsOp[GetAppReplicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppReplicationConfigurationResponse] =
        visitor.getAppReplicationConfiguration(request)
    }

    final case class GetAppValidationConfigurationOp(
      request: GetAppValidationConfigurationRequest
    ) extends SmsOp[GetAppValidationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppValidationConfigurationResponse] =
        visitor.getAppValidationConfiguration(request)
    }

    final case class GetAppValidationOutputOp(
      request: GetAppValidationOutputRequest
    ) extends SmsOp[GetAppValidationOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppValidationOutputResponse] =
        visitor.getAppValidationOutput(request)
    }

    final case class GetConnectorsOp(
      request: GetConnectorsRequest
    ) extends SmsOp[GetConnectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectorsResponse] =
        visitor.getConnectors(request)
    }

    final case class GetReplicationJobsOp(
      request: GetReplicationJobsRequest
    ) extends SmsOp[GetReplicationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReplicationJobsResponse] =
        visitor.getReplicationJobs(request)
    }

    final case class GetReplicationRunsOp(
      request: GetReplicationRunsRequest
    ) extends SmsOp[GetReplicationRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReplicationRunsResponse] =
        visitor.getReplicationRuns(request)
    }

    final case class GetServersOp(
      request: GetServersRequest
    ) extends SmsOp[GetServersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServersResponse] =
        visitor.getServers(request)
    }

    final case class ImportAppCatalogOp(
      request: ImportAppCatalogRequest
    ) extends SmsOp[ImportAppCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportAppCatalogResponse] =
        visitor.importAppCatalog(request)
    }

    final case class ImportServerCatalogOp(
      request: ImportServerCatalogRequest
    ) extends SmsOp[ImportServerCatalogResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportServerCatalogResponse] =
        visitor.importServerCatalog(request)
    }

    final case class LaunchAppOp(
      request: LaunchAppRequest
    ) extends SmsOp[LaunchAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LaunchAppResponse] =
        visitor.launchApp(request)
    }

    final case class ListAppsOp(
      request: ListAppsRequest
    ) extends SmsOp[ListAppsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppsResponse] =
        visitor.listApps(request)
    }

    final case class NotifyAppValidationOutputOp(
      request: NotifyAppValidationOutputRequest
    ) extends SmsOp[NotifyAppValidationOutputResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[NotifyAppValidationOutputResponse] =
        visitor.notifyAppValidationOutput(request)
    }

    final case class PutAppLaunchConfigurationOp(
      request: PutAppLaunchConfigurationRequest
    ) extends SmsOp[PutAppLaunchConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAppLaunchConfigurationResponse] =
        visitor.putAppLaunchConfiguration(request)
    }

    final case class PutAppReplicationConfigurationOp(
      request: PutAppReplicationConfigurationRequest
    ) extends SmsOp[PutAppReplicationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAppReplicationConfigurationResponse] =
        visitor.putAppReplicationConfiguration(request)
    }

    final case class PutAppValidationConfigurationOp(
      request: PutAppValidationConfigurationRequest
    ) extends SmsOp[PutAppValidationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAppValidationConfigurationResponse] =
        visitor.putAppValidationConfiguration(request)
    }

    final case class StartAppReplicationOp(
      request: StartAppReplicationRequest
    ) extends SmsOp[StartAppReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAppReplicationResponse] =
        visitor.startAppReplication(request)
    }

    final case class StartOnDemandAppReplicationOp(
      request: StartOnDemandAppReplicationRequest
    ) extends SmsOp[StartOnDemandAppReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartOnDemandAppReplicationResponse] =
        visitor.startOnDemandAppReplication(request)
    }

    final case class StartOnDemandReplicationRunOp(
      request: StartOnDemandReplicationRunRequest
    ) extends SmsOp[StartOnDemandReplicationRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartOnDemandReplicationRunResponse] =
        visitor.startOnDemandReplicationRun(request)
    }

    final case class StopAppReplicationOp(
      request: StopAppReplicationRequest
    ) extends SmsOp[StopAppReplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopAppReplicationResponse] =
        visitor.stopAppReplication(request)
    }

    final case class TerminateAppOp(
      request: TerminateAppRequest
    ) extends SmsOp[TerminateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateAppResponse] =
        visitor.terminateApp(request)
    }

    final case class UpdateAppOp(
      request: UpdateAppRequest
    ) extends SmsOp[UpdateAppResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAppResponse] =
        visitor.updateApp(request)
    }

    final case class UpdateReplicationJobOp(
      request: UpdateReplicationJobRequest
    ) extends SmsOp[UpdateReplicationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReplicationJobResponse] =
        visitor.updateReplicationJob(request)
    }
  }

  import SmsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SmsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApp(
    request: CreateAppRequest
  ): SmsIO[CreateAppResponse] =
    FF.liftF(CreateAppOp(request))

  def createReplicationJob(
    request: CreateReplicationJobRequest
  ): SmsIO[CreateReplicationJobResponse] =
    FF.liftF(CreateReplicationJobOp(request))

  def deleteApp(
    request: DeleteAppRequest
  ): SmsIO[DeleteAppResponse] =
    FF.liftF(DeleteAppOp(request))

  def deleteAppLaunchConfiguration(
    request: DeleteAppLaunchConfigurationRequest
  ): SmsIO[DeleteAppLaunchConfigurationResponse] =
    FF.liftF(DeleteAppLaunchConfigurationOp(request))

  def deleteAppReplicationConfiguration(
    request: DeleteAppReplicationConfigurationRequest
  ): SmsIO[DeleteAppReplicationConfigurationResponse] =
    FF.liftF(DeleteAppReplicationConfigurationOp(request))

  def deleteAppValidationConfiguration(
    request: DeleteAppValidationConfigurationRequest
  ): SmsIO[DeleteAppValidationConfigurationResponse] =
    FF.liftF(DeleteAppValidationConfigurationOp(request))

  def deleteReplicationJob(
    request: DeleteReplicationJobRequest
  ): SmsIO[DeleteReplicationJobResponse] =
    FF.liftF(DeleteReplicationJobOp(request))

  def deleteServerCatalog(
    request: DeleteServerCatalogRequest
  ): SmsIO[DeleteServerCatalogResponse] =
    FF.liftF(DeleteServerCatalogOp(request))

  def disassociateConnector(
    request: DisassociateConnectorRequest
  ): SmsIO[DisassociateConnectorResponse] =
    FF.liftF(DisassociateConnectorOp(request))

  def generateChangeSet(
    request: GenerateChangeSetRequest
  ): SmsIO[GenerateChangeSetResponse] =
    FF.liftF(GenerateChangeSetOp(request))

  def generateTemplate(
    request: GenerateTemplateRequest
  ): SmsIO[GenerateTemplateResponse] =
    FF.liftF(GenerateTemplateOp(request))

  def getApp(
    request: GetAppRequest
  ): SmsIO[GetAppResponse] =
    FF.liftF(GetAppOp(request))

  def getAppLaunchConfiguration(
    request: GetAppLaunchConfigurationRequest
  ): SmsIO[GetAppLaunchConfigurationResponse] =
    FF.liftF(GetAppLaunchConfigurationOp(request))

  def getAppReplicationConfiguration(
    request: GetAppReplicationConfigurationRequest
  ): SmsIO[GetAppReplicationConfigurationResponse] =
    FF.liftF(GetAppReplicationConfigurationOp(request))

  def getAppValidationConfiguration(
    request: GetAppValidationConfigurationRequest
  ): SmsIO[GetAppValidationConfigurationResponse] =
    FF.liftF(GetAppValidationConfigurationOp(request))

  def getAppValidationOutput(
    request: GetAppValidationOutputRequest
  ): SmsIO[GetAppValidationOutputResponse] =
    FF.liftF(GetAppValidationOutputOp(request))

  def getConnectors(
    request: GetConnectorsRequest
  ): SmsIO[GetConnectorsResponse] =
    FF.liftF(GetConnectorsOp(request))

  def getReplicationJobs(
    request: GetReplicationJobsRequest
  ): SmsIO[GetReplicationJobsResponse] =
    FF.liftF(GetReplicationJobsOp(request))

  def getReplicationRuns(
    request: GetReplicationRunsRequest
  ): SmsIO[GetReplicationRunsResponse] =
    FF.liftF(GetReplicationRunsOp(request))

  def getServers(
    request: GetServersRequest
  ): SmsIO[GetServersResponse] =
    FF.liftF(GetServersOp(request))

  def importAppCatalog(
    request: ImportAppCatalogRequest
  ): SmsIO[ImportAppCatalogResponse] =
    FF.liftF(ImportAppCatalogOp(request))

  def importServerCatalog(
    request: ImportServerCatalogRequest
  ): SmsIO[ImportServerCatalogResponse] =
    FF.liftF(ImportServerCatalogOp(request))

  def launchApp(
    request: LaunchAppRequest
  ): SmsIO[LaunchAppResponse] =
    FF.liftF(LaunchAppOp(request))

  def listApps(
    request: ListAppsRequest
  ): SmsIO[ListAppsResponse] =
    FF.liftF(ListAppsOp(request))

  def notifyAppValidationOutput(
    request: NotifyAppValidationOutputRequest
  ): SmsIO[NotifyAppValidationOutputResponse] =
    FF.liftF(NotifyAppValidationOutputOp(request))

  def putAppLaunchConfiguration(
    request: PutAppLaunchConfigurationRequest
  ): SmsIO[PutAppLaunchConfigurationResponse] =
    FF.liftF(PutAppLaunchConfigurationOp(request))

  def putAppReplicationConfiguration(
    request: PutAppReplicationConfigurationRequest
  ): SmsIO[PutAppReplicationConfigurationResponse] =
    FF.liftF(PutAppReplicationConfigurationOp(request))

  def putAppValidationConfiguration(
    request: PutAppValidationConfigurationRequest
  ): SmsIO[PutAppValidationConfigurationResponse] =
    FF.liftF(PutAppValidationConfigurationOp(request))

  def startAppReplication(
    request: StartAppReplicationRequest
  ): SmsIO[StartAppReplicationResponse] =
    FF.liftF(StartAppReplicationOp(request))

  def startOnDemandAppReplication(
    request: StartOnDemandAppReplicationRequest
  ): SmsIO[StartOnDemandAppReplicationResponse] =
    FF.liftF(StartOnDemandAppReplicationOp(request))

  def startOnDemandReplicationRun(
    request: StartOnDemandReplicationRunRequest
  ): SmsIO[StartOnDemandReplicationRunResponse] =
    FF.liftF(StartOnDemandReplicationRunOp(request))

  def stopAppReplication(
    request: StopAppReplicationRequest
  ): SmsIO[StopAppReplicationResponse] =
    FF.liftF(StopAppReplicationOp(request))

  def terminateApp(
    request: TerminateAppRequest
  ): SmsIO[TerminateAppResponse] =
    FF.liftF(TerminateAppOp(request))

  def updateApp(
    request: UpdateAppRequest
  ): SmsIO[UpdateAppResponse] =
    FF.liftF(UpdateAppOp(request))

  def updateReplicationJob(
    request: UpdateReplicationJobRequest
  ): SmsIO[UpdateReplicationJobResponse] =
    FF.liftF(UpdateReplicationJobOp(request))
}
