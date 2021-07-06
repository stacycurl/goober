package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.apprunner.AppRunnerClient
import software.amazon.awssdk.services.apprunner.model._


object apprunner { module =>

  // Free monad over AppRunnerOp
  type AppRunnerIO[A] = FF[AppRunnerOp, A]

  sealed trait AppRunnerOp[A] {
    def visit[F[_]](visitor: AppRunnerOp.Visitor[F]): F[A]
  }

  object AppRunnerOp {
    // Given a AppRunnerClient we can embed a AppRunnerIO program in any algebra that understands embedding.
    implicit val AppRunnerOpEmbeddable: Embeddable[AppRunnerOp, AppRunnerClient] = new Embeddable[AppRunnerOp, AppRunnerClient] {
      def embed[A](client: AppRunnerClient, io: AppRunnerIO[A]): Embedded[A] = Embedded.AppRunner(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppRunnerOp.Visitor[Kleisli[M, AppRunnerClient, *]] {
        def associateCustomDomain(
          request: AssociateCustomDomainRequest
        ): Kleisli[M, AppRunnerClient, AssociateCustomDomainResponse] =
          primitive(_.associateCustomDomain(request))

        def createAutoScalingConfiguration(
          request: CreateAutoScalingConfigurationRequest
        ): Kleisli[M, AppRunnerClient, CreateAutoScalingConfigurationResponse] =
          primitive(_.createAutoScalingConfiguration(request))

        def createConnection(
          request: CreateConnectionRequest
        ): Kleisli[M, AppRunnerClient, CreateConnectionResponse] =
          primitive(_.createConnection(request))

        def createService(
          request: CreateServiceRequest
        ): Kleisli[M, AppRunnerClient, CreateServiceResponse] =
          primitive(_.createService(request))

        def deleteAutoScalingConfiguration(
          request: DeleteAutoScalingConfigurationRequest
        ): Kleisli[M, AppRunnerClient, DeleteAutoScalingConfigurationResponse] =
          primitive(_.deleteAutoScalingConfiguration(request))

        def deleteConnection(
          request: DeleteConnectionRequest
        ): Kleisli[M, AppRunnerClient, DeleteConnectionResponse] =
          primitive(_.deleteConnection(request))

        def deleteService(
          request: DeleteServiceRequest
        ): Kleisli[M, AppRunnerClient, DeleteServiceResponse] =
          primitive(_.deleteService(request))

        def describeAutoScalingConfiguration(
          request: DescribeAutoScalingConfigurationRequest
        ): Kleisli[M, AppRunnerClient, DescribeAutoScalingConfigurationResponse] =
          primitive(_.describeAutoScalingConfiguration(request))

        def describeCustomDomains(
          request: DescribeCustomDomainsRequest
        ): Kleisli[M, AppRunnerClient, DescribeCustomDomainsResponse] =
          primitive(_.describeCustomDomains(request))

        def describeService(
          request: DescribeServiceRequest
        ): Kleisli[M, AppRunnerClient, DescribeServiceResponse] =
          primitive(_.describeService(request))

        def disassociateCustomDomain(
          request: DisassociateCustomDomainRequest
        ): Kleisli[M, AppRunnerClient, DisassociateCustomDomainResponse] =
          primitive(_.disassociateCustomDomain(request))

        def listAutoScalingConfigurations(
          request: ListAutoScalingConfigurationsRequest
        ): Kleisli[M, AppRunnerClient, ListAutoScalingConfigurationsResponse] =
          primitive(_.listAutoScalingConfigurations(request))

        def listConnections(
          request: ListConnectionsRequest
        ): Kleisli[M, AppRunnerClient, ListConnectionsResponse] =
          primitive(_.listConnections(request))

        def listOperations(
          request: ListOperationsRequest
        ): Kleisli[M, AppRunnerClient, ListOperationsResponse] =
          primitive(_.listOperations(request))

        def listServices(
          request: ListServicesRequest
        ): Kleisli[M, AppRunnerClient, ListServicesResponse] =
          primitive(_.listServices(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppRunnerClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def pauseService(
          request: PauseServiceRequest
        ): Kleisli[M, AppRunnerClient, PauseServiceResponse] =
          primitive(_.pauseService(request))

        def resumeService(
          request: ResumeServiceRequest
        ): Kleisli[M, AppRunnerClient, ResumeServiceResponse] =
          primitive(_.resumeService(request))

        def startDeployment(
          request: StartDeploymentRequest
        ): Kleisli[M, AppRunnerClient, StartDeploymentResponse] =
          primitive(_.startDeployment(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppRunnerClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppRunnerClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateService(
          request: UpdateServiceRequest
        ): Kleisli[M, AppRunnerClient, UpdateServiceResponse] =
          primitive(_.updateService(request))

        def primitive[A](
          f: AppRunnerClient => A
        ): Kleisli[M, AppRunnerClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppRunnerOp ~> F) {
      final def apply[A](op: AppRunnerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateCustomDomain(
        request: AssociateCustomDomainRequest
      ): F[AssociateCustomDomainResponse]

      def createAutoScalingConfiguration(
        request: CreateAutoScalingConfigurationRequest
      ): F[CreateAutoScalingConfigurationResponse]

      def createConnection(
        request: CreateConnectionRequest
      ): F[CreateConnectionResponse]

      def createService(
        request: CreateServiceRequest
      ): F[CreateServiceResponse]

      def deleteAutoScalingConfiguration(
        request: DeleteAutoScalingConfigurationRequest
      ): F[DeleteAutoScalingConfigurationResponse]

      def deleteConnection(
        request: DeleteConnectionRequest
      ): F[DeleteConnectionResponse]

      def deleteService(
        request: DeleteServiceRequest
      ): F[DeleteServiceResponse]

      def describeAutoScalingConfiguration(
        request: DescribeAutoScalingConfigurationRequest
      ): F[DescribeAutoScalingConfigurationResponse]

      def describeCustomDomains(
        request: DescribeCustomDomainsRequest
      ): F[DescribeCustomDomainsResponse]

      def describeService(
        request: DescribeServiceRequest
      ): F[DescribeServiceResponse]

      def disassociateCustomDomain(
        request: DisassociateCustomDomainRequest
      ): F[DisassociateCustomDomainResponse]

      def listAutoScalingConfigurations(
        request: ListAutoScalingConfigurationsRequest
      ): F[ListAutoScalingConfigurationsResponse]

      def listConnections(
        request: ListConnectionsRequest
      ): F[ListConnectionsResponse]

      def listOperations(
        request: ListOperationsRequest
      ): F[ListOperationsResponse]

      def listServices(
        request: ListServicesRequest
      ): F[ListServicesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def pauseService(
        request: PauseServiceRequest
      ): F[PauseServiceResponse]

      def resumeService(
        request: ResumeServiceRequest
      ): F[ResumeServiceResponse]

      def startDeployment(
        request: StartDeploymentRequest
      ): F[StartDeploymentResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateService(
        request: UpdateServiceRequest
      ): F[UpdateServiceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppRunnerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateCustomDomainOp(
      request: AssociateCustomDomainRequest
    ) extends AppRunnerOp[AssociateCustomDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateCustomDomainResponse] =
        visitor.associateCustomDomain(request)
    }

    final case class CreateAutoScalingConfigurationOp(
      request: CreateAutoScalingConfigurationRequest
    ) extends AppRunnerOp[CreateAutoScalingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAutoScalingConfigurationResponse] =
        visitor.createAutoScalingConfiguration(request)
    }

    final case class CreateConnectionOp(
      request: CreateConnectionRequest
    ) extends AppRunnerOp[CreateConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionResponse] =
        visitor.createConnection(request)
    }

    final case class CreateServiceOp(
      request: CreateServiceRequest
    ) extends AppRunnerOp[CreateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceResponse] =
        visitor.createService(request)
    }

    final case class DeleteAutoScalingConfigurationOp(
      request: DeleteAutoScalingConfigurationRequest
    ) extends AppRunnerOp[DeleteAutoScalingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAutoScalingConfigurationResponse] =
        visitor.deleteAutoScalingConfiguration(request)
    }

    final case class DeleteConnectionOp(
      request: DeleteConnectionRequest
    ) extends AppRunnerOp[DeleteConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionResponse] =
        visitor.deleteConnection(request)
    }

    final case class DeleteServiceOp(
      request: DeleteServiceRequest
    ) extends AppRunnerOp[DeleteServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceResponse] =
        visitor.deleteService(request)
    }

    final case class DescribeAutoScalingConfigurationOp(
      request: DescribeAutoScalingConfigurationRequest
    ) extends AppRunnerOp[DescribeAutoScalingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAutoScalingConfigurationResponse] =
        visitor.describeAutoScalingConfiguration(request)
    }

    final case class DescribeCustomDomainsOp(
      request: DescribeCustomDomainsRequest
    ) extends AppRunnerOp[DescribeCustomDomainsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomDomainsResponse] =
        visitor.describeCustomDomains(request)
    }

    final case class DescribeServiceOp(
      request: DescribeServiceRequest
    ) extends AppRunnerOp[DescribeServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceResponse] =
        visitor.describeService(request)
    }

    final case class DisassociateCustomDomainOp(
      request: DisassociateCustomDomainRequest
    ) extends AppRunnerOp[DisassociateCustomDomainResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateCustomDomainResponse] =
        visitor.disassociateCustomDomain(request)
    }

    final case class ListAutoScalingConfigurationsOp(
      request: ListAutoScalingConfigurationsRequest
    ) extends AppRunnerOp[ListAutoScalingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAutoScalingConfigurationsResponse] =
        visitor.listAutoScalingConfigurations(request)
    }

    final case class ListConnectionsOp(
      request: ListConnectionsRequest
    ) extends AppRunnerOp[ListConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConnectionsResponse] =
        visitor.listConnections(request)
    }

    final case class ListOperationsOp(
      request: ListOperationsRequest
    ) extends AppRunnerOp[ListOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOperationsResponse] =
        visitor.listOperations(request)
    }

    final case class ListServicesOp(
      request: ListServicesRequest
    ) extends AppRunnerOp[ListServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServicesResponse] =
        visitor.listServices(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppRunnerOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PauseServiceOp(
      request: PauseServiceRequest
    ) extends AppRunnerOp[PauseServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PauseServiceResponse] =
        visitor.pauseService(request)
    }

    final case class ResumeServiceOp(
      request: ResumeServiceRequest
    ) extends AppRunnerOp[ResumeServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeServiceResponse] =
        visitor.resumeService(request)
    }

    final case class StartDeploymentOp(
      request: StartDeploymentRequest
    ) extends AppRunnerOp[StartDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDeploymentResponse] =
        visitor.startDeployment(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppRunnerOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppRunnerOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateServiceOp(
      request: UpdateServiceRequest
    ) extends AppRunnerOp[UpdateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceResponse] =
        visitor.updateService(request)
    }
  }

  import AppRunnerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppRunnerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateCustomDomain(
    request: AssociateCustomDomainRequest
  ): AppRunnerIO[AssociateCustomDomainResponse] =
    FF.liftF(AssociateCustomDomainOp(request))

  def createAutoScalingConfiguration(
    request: CreateAutoScalingConfigurationRequest
  ): AppRunnerIO[CreateAutoScalingConfigurationResponse] =
    FF.liftF(CreateAutoScalingConfigurationOp(request))

  def createConnection(
    request: CreateConnectionRequest
  ): AppRunnerIO[CreateConnectionResponse] =
    FF.liftF(CreateConnectionOp(request))

  def createService(
    request: CreateServiceRequest
  ): AppRunnerIO[CreateServiceResponse] =
    FF.liftF(CreateServiceOp(request))

  def deleteAutoScalingConfiguration(
    request: DeleteAutoScalingConfigurationRequest
  ): AppRunnerIO[DeleteAutoScalingConfigurationResponse] =
    FF.liftF(DeleteAutoScalingConfigurationOp(request))

  def deleteConnection(
    request: DeleteConnectionRequest
  ): AppRunnerIO[DeleteConnectionResponse] =
    FF.liftF(DeleteConnectionOp(request))

  def deleteService(
    request: DeleteServiceRequest
  ): AppRunnerIO[DeleteServiceResponse] =
    FF.liftF(DeleteServiceOp(request))

  def describeAutoScalingConfiguration(
    request: DescribeAutoScalingConfigurationRequest
  ): AppRunnerIO[DescribeAutoScalingConfigurationResponse] =
    FF.liftF(DescribeAutoScalingConfigurationOp(request))

  def describeCustomDomains(
    request: DescribeCustomDomainsRequest
  ): AppRunnerIO[DescribeCustomDomainsResponse] =
    FF.liftF(DescribeCustomDomainsOp(request))

  def describeService(
    request: DescribeServiceRequest
  ): AppRunnerIO[DescribeServiceResponse] =
    FF.liftF(DescribeServiceOp(request))

  def disassociateCustomDomain(
    request: DisassociateCustomDomainRequest
  ): AppRunnerIO[DisassociateCustomDomainResponse] =
    FF.liftF(DisassociateCustomDomainOp(request))

  def listAutoScalingConfigurations(
    request: ListAutoScalingConfigurationsRequest
  ): AppRunnerIO[ListAutoScalingConfigurationsResponse] =
    FF.liftF(ListAutoScalingConfigurationsOp(request))

  def listConnections(
    request: ListConnectionsRequest
  ): AppRunnerIO[ListConnectionsResponse] =
    FF.liftF(ListConnectionsOp(request))

  def listOperations(
    request: ListOperationsRequest
  ): AppRunnerIO[ListOperationsResponse] =
    FF.liftF(ListOperationsOp(request))

  def listServices(
    request: ListServicesRequest
  ): AppRunnerIO[ListServicesResponse] =
    FF.liftF(ListServicesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppRunnerIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def pauseService(
    request: PauseServiceRequest
  ): AppRunnerIO[PauseServiceResponse] =
    FF.liftF(PauseServiceOp(request))

  def resumeService(
    request: ResumeServiceRequest
  ): AppRunnerIO[ResumeServiceResponse] =
    FF.liftF(ResumeServiceOp(request))

  def startDeployment(
    request: StartDeploymentRequest
  ): AppRunnerIO[StartDeploymentResponse] =
    FF.liftF(StartDeploymentOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppRunnerIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppRunnerIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateService(
    request: UpdateServiceRequest
  ): AppRunnerIO[UpdateServiceResponse] =
    FF.liftF(UpdateServiceOp(request))
}
