package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.appconfig.AppConfigClient
import software.amazon.awssdk.services.appconfig.model._


object appconfig { module =>

  // Free monad over AppConfigOp
  type AppConfigIO[A] = FF[AppConfigOp, A]

  sealed trait AppConfigOp[A] {
    def visit[F[_]](visitor: AppConfigOp.Visitor[F]): F[A]
  }

  object AppConfigOp {
    // Given a AppConfigClient we can embed a AppConfigIO program in any algebra that understands embedding.
    implicit val AppConfigOpEmbeddable: Embeddable[AppConfigOp, AppConfigClient] = new Embeddable[AppConfigOp, AppConfigClient] {
      def embed[A](client: AppConfigClient, io: AppConfigIO[A]): Embedded[A] = Embedded.AppConfig(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppConfigOp.Visitor[Kleisli[M, AppConfigClient, *]] {
        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, AppConfigClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createConfigurationProfile(
          request: CreateConfigurationProfileRequest
        ): Kleisli[M, AppConfigClient, CreateConfigurationProfileResponse] =
          primitive(_.createConfigurationProfile(request))

        def createDeploymentStrategy(
          request: CreateDeploymentStrategyRequest
        ): Kleisli[M, AppConfigClient, CreateDeploymentStrategyResponse] =
          primitive(_.createDeploymentStrategy(request))

        def createEnvironment(
          request: CreateEnvironmentRequest
        ): Kleisli[M, AppConfigClient, CreateEnvironmentResponse] =
          primitive(_.createEnvironment(request))

        def createHostedConfigurationVersion(
          request: CreateHostedConfigurationVersionRequest
        ): Kleisli[M, AppConfigClient, CreateHostedConfigurationVersionResponse] =
          primitive(_.createHostedConfigurationVersion(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, AppConfigClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteConfigurationProfile(
          request: DeleteConfigurationProfileRequest
        ): Kleisli[M, AppConfigClient, DeleteConfigurationProfileResponse] =
          primitive(_.deleteConfigurationProfile(request))

        def deleteDeploymentStrategy(
          request: DeleteDeploymentStrategyRequest
        ): Kleisli[M, AppConfigClient, DeleteDeploymentStrategyResponse] =
          primitive(_.deleteDeploymentStrategy(request))

        def deleteEnvironment(
          request: DeleteEnvironmentRequest
        ): Kleisli[M, AppConfigClient, DeleteEnvironmentResponse] =
          primitive(_.deleteEnvironment(request))

        def deleteHostedConfigurationVersion(
          request: DeleteHostedConfigurationVersionRequest
        ): Kleisli[M, AppConfigClient, DeleteHostedConfigurationVersionResponse] =
          primitive(_.deleteHostedConfigurationVersion(request))

        def getApplication(
          request: GetApplicationRequest
        ): Kleisli[M, AppConfigClient, GetApplicationResponse] =
          primitive(_.getApplication(request))

        def getConfiguration(
          request: GetConfigurationRequest
        ): Kleisli[M, AppConfigClient, GetConfigurationResponse] =
          primitive(_.getConfiguration(request))

        def getConfigurationProfile(
          request: GetConfigurationProfileRequest
        ): Kleisli[M, AppConfigClient, GetConfigurationProfileResponse] =
          primitive(_.getConfigurationProfile(request))

        def getDeployment(
          request: GetDeploymentRequest
        ): Kleisli[M, AppConfigClient, GetDeploymentResponse] =
          primitive(_.getDeployment(request))

        def getDeploymentStrategy(
          request: GetDeploymentStrategyRequest
        ): Kleisli[M, AppConfigClient, GetDeploymentStrategyResponse] =
          primitive(_.getDeploymentStrategy(request))

        def getEnvironment(
          request: GetEnvironmentRequest
        ): Kleisli[M, AppConfigClient, GetEnvironmentResponse] =
          primitive(_.getEnvironment(request))

        def getHostedConfigurationVersion(
          request: GetHostedConfigurationVersionRequest
        ): Kleisli[M, AppConfigClient, GetHostedConfigurationVersionResponse] =
          primitive(_.getHostedConfigurationVersion(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, AppConfigClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listConfigurationProfiles(
          request: ListConfigurationProfilesRequest
        ): Kleisli[M, AppConfigClient, ListConfigurationProfilesResponse] =
          primitive(_.listConfigurationProfiles(request))

        def listDeploymentStrategies(
          request: ListDeploymentStrategiesRequest
        ): Kleisli[M, AppConfigClient, ListDeploymentStrategiesResponse] =
          primitive(_.listDeploymentStrategies(request))

        def listDeployments(
          request: ListDeploymentsRequest
        ): Kleisli[M, AppConfigClient, ListDeploymentsResponse] =
          primitive(_.listDeployments(request))

        def listEnvironments(
          request: ListEnvironmentsRequest
        ): Kleisli[M, AppConfigClient, ListEnvironmentsResponse] =
          primitive(_.listEnvironments(request))

        def listHostedConfigurationVersions(
          request: ListHostedConfigurationVersionsRequest
        ): Kleisli[M, AppConfigClient, ListHostedConfigurationVersionsResponse] =
          primitive(_.listHostedConfigurationVersions(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppConfigClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startDeployment(
          request: StartDeploymentRequest
        ): Kleisli[M, AppConfigClient, StartDeploymentResponse] =
          primitive(_.startDeployment(request))

        def stopDeployment(
          request: StopDeploymentRequest
        ): Kleisli[M, AppConfigClient, StopDeploymentResponse] =
          primitive(_.stopDeployment(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppConfigClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppConfigClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, AppConfigClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def updateConfigurationProfile(
          request: UpdateConfigurationProfileRequest
        ): Kleisli[M, AppConfigClient, UpdateConfigurationProfileResponse] =
          primitive(_.updateConfigurationProfile(request))

        def updateDeploymentStrategy(
          request: UpdateDeploymentStrategyRequest
        ): Kleisli[M, AppConfigClient, UpdateDeploymentStrategyResponse] =
          primitive(_.updateDeploymentStrategy(request))

        def updateEnvironment(
          request: UpdateEnvironmentRequest
        ): Kleisli[M, AppConfigClient, UpdateEnvironmentResponse] =
          primitive(_.updateEnvironment(request))

        def validateConfiguration(
          request: ValidateConfigurationRequest
        ): Kleisli[M, AppConfigClient, ValidateConfigurationResponse] =
          primitive(_.validateConfiguration(request))

        def primitive[A](
          f: AppConfigClient => A
        ): Kleisli[M, AppConfigClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppConfigOp ~> F) {
      final def apply[A](op: AppConfigOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createConfigurationProfile(
        request: CreateConfigurationProfileRequest
      ): F[CreateConfigurationProfileResponse]

      def createDeploymentStrategy(
        request: CreateDeploymentStrategyRequest
      ): F[CreateDeploymentStrategyResponse]

      def createEnvironment(
        request: CreateEnvironmentRequest
      ): F[CreateEnvironmentResponse]

      def createHostedConfigurationVersion(
        request: CreateHostedConfigurationVersionRequest
      ): F[CreateHostedConfigurationVersionResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def deleteConfigurationProfile(
        request: DeleteConfigurationProfileRequest
      ): F[DeleteConfigurationProfileResponse]

      def deleteDeploymentStrategy(
        request: DeleteDeploymentStrategyRequest
      ): F[DeleteDeploymentStrategyResponse]

      def deleteEnvironment(
        request: DeleteEnvironmentRequest
      ): F[DeleteEnvironmentResponse]

      def deleteHostedConfigurationVersion(
        request: DeleteHostedConfigurationVersionRequest
      ): F[DeleteHostedConfigurationVersionResponse]

      def getApplication(
        request: GetApplicationRequest
      ): F[GetApplicationResponse]

      def getConfiguration(
        request: GetConfigurationRequest
      ): F[GetConfigurationResponse]

      def getConfigurationProfile(
        request: GetConfigurationProfileRequest
      ): F[GetConfigurationProfileResponse]

      def getDeployment(
        request: GetDeploymentRequest
      ): F[GetDeploymentResponse]

      def getDeploymentStrategy(
        request: GetDeploymentStrategyRequest
      ): F[GetDeploymentStrategyResponse]

      def getEnvironment(
        request: GetEnvironmentRequest
      ): F[GetEnvironmentResponse]

      def getHostedConfigurationVersion(
        request: GetHostedConfigurationVersionRequest
      ): F[GetHostedConfigurationVersionResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listConfigurationProfiles(
        request: ListConfigurationProfilesRequest
      ): F[ListConfigurationProfilesResponse]

      def listDeploymentStrategies(
        request: ListDeploymentStrategiesRequest
      ): F[ListDeploymentStrategiesResponse]

      def listDeployments(
        request: ListDeploymentsRequest
      ): F[ListDeploymentsResponse]

      def listEnvironments(
        request: ListEnvironmentsRequest
      ): F[ListEnvironmentsResponse]

      def listHostedConfigurationVersions(
        request: ListHostedConfigurationVersionsRequest
      ): F[ListHostedConfigurationVersionsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startDeployment(
        request: StartDeploymentRequest
      ): F[StartDeploymentResponse]

      def stopDeployment(
        request: StopDeploymentRequest
      ): F[StopDeploymentResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]

      def updateConfigurationProfile(
        request: UpdateConfigurationProfileRequest
      ): F[UpdateConfigurationProfileResponse]

      def updateDeploymentStrategy(
        request: UpdateDeploymentStrategyRequest
      ): F[UpdateDeploymentStrategyResponse]

      def updateEnvironment(
        request: UpdateEnvironmentRequest
      ): F[UpdateEnvironmentResponse]

      def validateConfiguration(
        request: ValidateConfigurationRequest
      ): F[ValidateConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppConfigOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends AppConfigOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateConfigurationProfileOp(
      request: CreateConfigurationProfileRequest
    ) extends AppConfigOp[CreateConfigurationProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConfigurationProfileResponse] =
        visitor.createConfigurationProfile(request)
    }

    final case class CreateDeploymentStrategyOp(
      request: CreateDeploymentStrategyRequest
    ) extends AppConfigOp[CreateDeploymentStrategyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentStrategyResponse] =
        visitor.createDeploymentStrategy(request)
    }

    final case class CreateEnvironmentOp(
      request: CreateEnvironmentRequest
    ) extends AppConfigOp[CreateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentResponse] =
        visitor.createEnvironment(request)
    }

    final case class CreateHostedConfigurationVersionOp(
      request: CreateHostedConfigurationVersionRequest
    ) extends AppConfigOp[CreateHostedConfigurationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHostedConfigurationVersionResponse] =
        visitor.createHostedConfigurationVersion(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends AppConfigOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteConfigurationProfileOp(
      request: DeleteConfigurationProfileRequest
    ) extends AppConfigOp[DeleteConfigurationProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConfigurationProfileResponse] =
        visitor.deleteConfigurationProfile(request)
    }

    final case class DeleteDeploymentStrategyOp(
      request: DeleteDeploymentStrategyRequest
    ) extends AppConfigOp[DeleteDeploymentStrategyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeploymentStrategyResponse] =
        visitor.deleteDeploymentStrategy(request)
    }

    final case class DeleteEnvironmentOp(
      request: DeleteEnvironmentRequest
    ) extends AppConfigOp[DeleteEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentResponse] =
        visitor.deleteEnvironment(request)
    }

    final case class DeleteHostedConfigurationVersionOp(
      request: DeleteHostedConfigurationVersionRequest
    ) extends AppConfigOp[DeleteHostedConfigurationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHostedConfigurationVersionResponse] =
        visitor.deleteHostedConfigurationVersion(request)
    }

    final case class GetApplicationOp(
      request: GetApplicationRequest
    ) extends AppConfigOp[GetApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationResponse] =
        visitor.getApplication(request)
    }

    final case class GetConfigurationOp(
      request: GetConfigurationRequest
    ) extends AppConfigOp[GetConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationResponse] =
        visitor.getConfiguration(request)
    }

    final case class GetConfigurationProfileOp(
      request: GetConfigurationProfileRequest
    ) extends AppConfigOp[GetConfigurationProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConfigurationProfileResponse] =
        visitor.getConfigurationProfile(request)
    }

    final case class GetDeploymentOp(
      request: GetDeploymentRequest
    ) extends AppConfigOp[GetDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentResponse] =
        visitor.getDeployment(request)
    }

    final case class GetDeploymentStrategyOp(
      request: GetDeploymentStrategyRequest
    ) extends AppConfigOp[GetDeploymentStrategyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentStrategyResponse] =
        visitor.getDeploymentStrategy(request)
    }

    final case class GetEnvironmentOp(
      request: GetEnvironmentRequest
    ) extends AppConfigOp[GetEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentResponse] =
        visitor.getEnvironment(request)
    }

    final case class GetHostedConfigurationVersionOp(
      request: GetHostedConfigurationVersionRequest
    ) extends AppConfigOp[GetHostedConfigurationVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetHostedConfigurationVersionResponse] =
        visitor.getHostedConfigurationVersion(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends AppConfigOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListConfigurationProfilesOp(
      request: ListConfigurationProfilesRequest
    ) extends AppConfigOp[ListConfigurationProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationProfilesResponse] =
        visitor.listConfigurationProfiles(request)
    }

    final case class ListDeploymentStrategiesOp(
      request: ListDeploymentStrategiesRequest
    ) extends AppConfigOp[ListDeploymentStrategiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentStrategiesResponse] =
        visitor.listDeploymentStrategies(request)
    }

    final case class ListDeploymentsOp(
      request: ListDeploymentsRequest
    ) extends AppConfigOp[ListDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentsResponse] =
        visitor.listDeployments(request)
    }

    final case class ListEnvironmentsOp(
      request: ListEnvironmentsRequest
    ) extends AppConfigOp[ListEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentsResponse] =
        visitor.listEnvironments(request)
    }

    final case class ListHostedConfigurationVersionsOp(
      request: ListHostedConfigurationVersionsRequest
    ) extends AppConfigOp[ListHostedConfigurationVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHostedConfigurationVersionsResponse] =
        visitor.listHostedConfigurationVersions(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppConfigOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartDeploymentOp(
      request: StartDeploymentRequest
    ) extends AppConfigOp[StartDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDeploymentResponse] =
        visitor.startDeployment(request)
    }

    final case class StopDeploymentOp(
      request: StopDeploymentRequest
    ) extends AppConfigOp[StopDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDeploymentResponse] =
        visitor.stopDeployment(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppConfigOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppConfigOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends AppConfigOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }

    final case class UpdateConfigurationProfileOp(
      request: UpdateConfigurationProfileRequest
    ) extends AppConfigOp[UpdateConfigurationProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConfigurationProfileResponse] =
        visitor.updateConfigurationProfile(request)
    }

    final case class UpdateDeploymentStrategyOp(
      request: UpdateDeploymentStrategyRequest
    ) extends AppConfigOp[UpdateDeploymentStrategyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeploymentStrategyResponse] =
        visitor.updateDeploymentStrategy(request)
    }

    final case class UpdateEnvironmentOp(
      request: UpdateEnvironmentRequest
    ) extends AppConfigOp[UpdateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentResponse] =
        visitor.updateEnvironment(request)
    }

    final case class ValidateConfigurationOp(
      request: ValidateConfigurationRequest
    ) extends AppConfigOp[ValidateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateConfigurationResponse] =
        visitor.validateConfiguration(request)
    }
  }

  import AppConfigOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppConfigOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApplication(
    request: CreateApplicationRequest
  ): AppConfigIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createConfigurationProfile(
    request: CreateConfigurationProfileRequest
  ): AppConfigIO[CreateConfigurationProfileResponse] =
    FF.liftF(CreateConfigurationProfileOp(request))

  def createDeploymentStrategy(
    request: CreateDeploymentStrategyRequest
  ): AppConfigIO[CreateDeploymentStrategyResponse] =
    FF.liftF(CreateDeploymentStrategyOp(request))

  def createEnvironment(
    request: CreateEnvironmentRequest
  ): AppConfigIO[CreateEnvironmentResponse] =
    FF.liftF(CreateEnvironmentOp(request))

  def createHostedConfigurationVersion(
    request: CreateHostedConfigurationVersionRequest
  ): AppConfigIO[CreateHostedConfigurationVersionResponse] =
    FF.liftF(CreateHostedConfigurationVersionOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): AppConfigIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteConfigurationProfile(
    request: DeleteConfigurationProfileRequest
  ): AppConfigIO[DeleteConfigurationProfileResponse] =
    FF.liftF(DeleteConfigurationProfileOp(request))

  def deleteDeploymentStrategy(
    request: DeleteDeploymentStrategyRequest
  ): AppConfigIO[DeleteDeploymentStrategyResponse] =
    FF.liftF(DeleteDeploymentStrategyOp(request))

  def deleteEnvironment(
    request: DeleteEnvironmentRequest
  ): AppConfigIO[DeleteEnvironmentResponse] =
    FF.liftF(DeleteEnvironmentOp(request))

  def deleteHostedConfigurationVersion(
    request: DeleteHostedConfigurationVersionRequest
  ): AppConfigIO[DeleteHostedConfigurationVersionResponse] =
    FF.liftF(DeleteHostedConfigurationVersionOp(request))

  def getApplication(
    request: GetApplicationRequest
  ): AppConfigIO[GetApplicationResponse] =
    FF.liftF(GetApplicationOp(request))

  def getConfiguration(
    request: GetConfigurationRequest
  ): AppConfigIO[GetConfigurationResponse] =
    FF.liftF(GetConfigurationOp(request))

  def getConfigurationProfile(
    request: GetConfigurationProfileRequest
  ): AppConfigIO[GetConfigurationProfileResponse] =
    FF.liftF(GetConfigurationProfileOp(request))

  def getDeployment(
    request: GetDeploymentRequest
  ): AppConfigIO[GetDeploymentResponse] =
    FF.liftF(GetDeploymentOp(request))

  def getDeploymentStrategy(
    request: GetDeploymentStrategyRequest
  ): AppConfigIO[GetDeploymentStrategyResponse] =
    FF.liftF(GetDeploymentStrategyOp(request))

  def getEnvironment(
    request: GetEnvironmentRequest
  ): AppConfigIO[GetEnvironmentResponse] =
    FF.liftF(GetEnvironmentOp(request))

  def getHostedConfigurationVersion(
    request: GetHostedConfigurationVersionRequest
  ): AppConfigIO[GetHostedConfigurationVersionResponse] =
    FF.liftF(GetHostedConfigurationVersionOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): AppConfigIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listConfigurationProfiles(
    request: ListConfigurationProfilesRequest
  ): AppConfigIO[ListConfigurationProfilesResponse] =
    FF.liftF(ListConfigurationProfilesOp(request))

  def listDeploymentStrategies(
    request: ListDeploymentStrategiesRequest
  ): AppConfigIO[ListDeploymentStrategiesResponse] =
    FF.liftF(ListDeploymentStrategiesOp(request))

  def listDeployments(
    request: ListDeploymentsRequest
  ): AppConfigIO[ListDeploymentsResponse] =
    FF.liftF(ListDeploymentsOp(request))

  def listEnvironments(
    request: ListEnvironmentsRequest
  ): AppConfigIO[ListEnvironmentsResponse] =
    FF.liftF(ListEnvironmentsOp(request))

  def listHostedConfigurationVersions(
    request: ListHostedConfigurationVersionsRequest
  ): AppConfigIO[ListHostedConfigurationVersionsResponse] =
    FF.liftF(ListHostedConfigurationVersionsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppConfigIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startDeployment(
    request: StartDeploymentRequest
  ): AppConfigIO[StartDeploymentResponse] =
    FF.liftF(StartDeploymentOp(request))

  def stopDeployment(
    request: StopDeploymentRequest
  ): AppConfigIO[StopDeploymentResponse] =
    FF.liftF(StopDeploymentOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppConfigIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppConfigIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): AppConfigIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))

  def updateConfigurationProfile(
    request: UpdateConfigurationProfileRequest
  ): AppConfigIO[UpdateConfigurationProfileResponse] =
    FF.liftF(UpdateConfigurationProfileOp(request))

  def updateDeploymentStrategy(
    request: UpdateDeploymentStrategyRequest
  ): AppConfigIO[UpdateDeploymentStrategyResponse] =
    FF.liftF(UpdateDeploymentStrategyOp(request))

  def updateEnvironment(
    request: UpdateEnvironmentRequest
  ): AppConfigIO[UpdateEnvironmentResponse] =
    FF.liftF(UpdateEnvironmentOp(request))

  def validateConfiguration(
    request: ValidateConfigurationRequest
  ): AppConfigIO[ValidateConfigurationResponse] =
    FF.liftF(ValidateConfigurationOp(request))
}
