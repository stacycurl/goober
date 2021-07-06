package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.proton.ProtonClient
import software.amazon.awssdk.services.proton.model._


object proton { module =>

  // Free monad over ProtonOp
  type ProtonIO[A] = FF[ProtonOp, A]

  sealed trait ProtonOp[A] {
    def visit[F[_]](visitor: ProtonOp.Visitor[F]): F[A]
  }

  object ProtonOp {
    // Given a ProtonClient we can embed a ProtonIO program in any algebra that understands embedding.
    implicit val ProtonOpEmbeddable: Embeddable[ProtonOp, ProtonClient] = new Embeddable[ProtonOp, ProtonClient] {
      def embed[A](client: ProtonClient, io: ProtonIO[A]): Embedded[A] = Embedded.Proton(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ProtonOp.Visitor[Kleisli[M, ProtonClient, *]] {
        def acceptEnvironmentAccountConnection(
          request: AcceptEnvironmentAccountConnectionRequest
        ): Kleisli[M, ProtonClient, AcceptEnvironmentAccountConnectionResponse] =
          primitive(_.acceptEnvironmentAccountConnection(request))

        def cancelEnvironmentDeployment(
          request: CancelEnvironmentDeploymentRequest
        ): Kleisli[M, ProtonClient, CancelEnvironmentDeploymentResponse] =
          primitive(_.cancelEnvironmentDeployment(request))

        def cancelServiceInstanceDeployment(
          request: CancelServiceInstanceDeploymentRequest
        ): Kleisli[M, ProtonClient, CancelServiceInstanceDeploymentResponse] =
          primitive(_.cancelServiceInstanceDeployment(request))

        def cancelServicePipelineDeployment(
          request: CancelServicePipelineDeploymentRequest
        ): Kleisli[M, ProtonClient, CancelServicePipelineDeploymentResponse] =
          primitive(_.cancelServicePipelineDeployment(request))

        def createEnvironment(
          request: CreateEnvironmentRequest
        ): Kleisli[M, ProtonClient, CreateEnvironmentResponse] =
          primitive(_.createEnvironment(request))

        def createEnvironmentAccountConnection(
          request: CreateEnvironmentAccountConnectionRequest
        ): Kleisli[M, ProtonClient, CreateEnvironmentAccountConnectionResponse] =
          primitive(_.createEnvironmentAccountConnection(request))

        def createEnvironmentTemplate(
          request: CreateEnvironmentTemplateRequest
        ): Kleisli[M, ProtonClient, CreateEnvironmentTemplateResponse] =
          primitive(_.createEnvironmentTemplate(request))

        def createEnvironmentTemplateVersion(
          request: CreateEnvironmentTemplateVersionRequest
        ): Kleisli[M, ProtonClient, CreateEnvironmentTemplateVersionResponse] =
          primitive(_.createEnvironmentTemplateVersion(request))

        def createService(
          request: CreateServiceRequest
        ): Kleisli[M, ProtonClient, CreateServiceResponse] =
          primitive(_.createService(request))

        def createServiceTemplate(
          request: CreateServiceTemplateRequest
        ): Kleisli[M, ProtonClient, CreateServiceTemplateResponse] =
          primitive(_.createServiceTemplate(request))

        def createServiceTemplateVersion(
          request: CreateServiceTemplateVersionRequest
        ): Kleisli[M, ProtonClient, CreateServiceTemplateVersionResponse] =
          primitive(_.createServiceTemplateVersion(request))

        def deleteEnvironment(
          request: DeleteEnvironmentRequest
        ): Kleisli[M, ProtonClient, DeleteEnvironmentResponse] =
          primitive(_.deleteEnvironment(request))

        def deleteEnvironmentAccountConnection(
          request: DeleteEnvironmentAccountConnectionRequest
        ): Kleisli[M, ProtonClient, DeleteEnvironmentAccountConnectionResponse] =
          primitive(_.deleteEnvironmentAccountConnection(request))

        def deleteEnvironmentTemplate(
          request: DeleteEnvironmentTemplateRequest
        ): Kleisli[M, ProtonClient, DeleteEnvironmentTemplateResponse] =
          primitive(_.deleteEnvironmentTemplate(request))

        def deleteEnvironmentTemplateVersion(
          request: DeleteEnvironmentTemplateVersionRequest
        ): Kleisli[M, ProtonClient, DeleteEnvironmentTemplateVersionResponse] =
          primitive(_.deleteEnvironmentTemplateVersion(request))

        def deleteService(
          request: DeleteServiceRequest
        ): Kleisli[M, ProtonClient, DeleteServiceResponse] =
          primitive(_.deleteService(request))

        def deleteServiceTemplate(
          request: DeleteServiceTemplateRequest
        ): Kleisli[M, ProtonClient, DeleteServiceTemplateResponse] =
          primitive(_.deleteServiceTemplate(request))

        def deleteServiceTemplateVersion(
          request: DeleteServiceTemplateVersionRequest
        ): Kleisli[M, ProtonClient, DeleteServiceTemplateVersionResponse] =
          primitive(_.deleteServiceTemplateVersion(request))

        def getAccountSettings(
          request: GetAccountSettingsRequest
        ): Kleisli[M, ProtonClient, GetAccountSettingsResponse] =
          primitive(_.getAccountSettings(request))

        def getEnvironment(
          request: GetEnvironmentRequest
        ): Kleisli[M, ProtonClient, GetEnvironmentResponse] =
          primitive(_.getEnvironment(request))

        def getEnvironmentAccountConnection(
          request: GetEnvironmentAccountConnectionRequest
        ): Kleisli[M, ProtonClient, GetEnvironmentAccountConnectionResponse] =
          primitive(_.getEnvironmentAccountConnection(request))

        def getEnvironmentTemplate(
          request: GetEnvironmentTemplateRequest
        ): Kleisli[M, ProtonClient, GetEnvironmentTemplateResponse] =
          primitive(_.getEnvironmentTemplate(request))

        def getEnvironmentTemplateVersion(
          request: GetEnvironmentTemplateVersionRequest
        ): Kleisli[M, ProtonClient, GetEnvironmentTemplateVersionResponse] =
          primitive(_.getEnvironmentTemplateVersion(request))

        def getService(
          request: GetServiceRequest
        ): Kleisli[M, ProtonClient, GetServiceResponse] =
          primitive(_.getService(request))

        def getServiceInstance(
          request: GetServiceInstanceRequest
        ): Kleisli[M, ProtonClient, GetServiceInstanceResponse] =
          primitive(_.getServiceInstance(request))

        def getServiceTemplate(
          request: GetServiceTemplateRequest
        ): Kleisli[M, ProtonClient, GetServiceTemplateResponse] =
          primitive(_.getServiceTemplate(request))

        def getServiceTemplateVersion(
          request: GetServiceTemplateVersionRequest
        ): Kleisli[M, ProtonClient, GetServiceTemplateVersionResponse] =
          primitive(_.getServiceTemplateVersion(request))

        def listEnvironmentAccountConnections(
          request: ListEnvironmentAccountConnectionsRequest
        ): Kleisli[M, ProtonClient, ListEnvironmentAccountConnectionsResponse] =
          primitive(_.listEnvironmentAccountConnections(request))

        def listEnvironmentTemplateVersions(
          request: ListEnvironmentTemplateVersionsRequest
        ): Kleisli[M, ProtonClient, ListEnvironmentTemplateVersionsResponse] =
          primitive(_.listEnvironmentTemplateVersions(request))

        def listEnvironmentTemplates(
          request: ListEnvironmentTemplatesRequest
        ): Kleisli[M, ProtonClient, ListEnvironmentTemplatesResponse] =
          primitive(_.listEnvironmentTemplates(request))

        def listEnvironments(
          request: ListEnvironmentsRequest
        ): Kleisli[M, ProtonClient, ListEnvironmentsResponse] =
          primitive(_.listEnvironments(request))

        def listServiceInstances(
          request: ListServiceInstancesRequest
        ): Kleisli[M, ProtonClient, ListServiceInstancesResponse] =
          primitive(_.listServiceInstances(request))

        def listServiceTemplateVersions(
          request: ListServiceTemplateVersionsRequest
        ): Kleisli[M, ProtonClient, ListServiceTemplateVersionsResponse] =
          primitive(_.listServiceTemplateVersions(request))

        def listServiceTemplates(
          request: ListServiceTemplatesRequest
        ): Kleisli[M, ProtonClient, ListServiceTemplatesResponse] =
          primitive(_.listServiceTemplates(request))

        def listServices(
          request: ListServicesRequest
        ): Kleisli[M, ProtonClient, ListServicesResponse] =
          primitive(_.listServices(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ProtonClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def rejectEnvironmentAccountConnection(
          request: RejectEnvironmentAccountConnectionRequest
        ): Kleisli[M, ProtonClient, RejectEnvironmentAccountConnectionResponse] =
          primitive(_.rejectEnvironmentAccountConnection(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ProtonClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ProtonClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccountSettings(
          request: UpdateAccountSettingsRequest
        ): Kleisli[M, ProtonClient, UpdateAccountSettingsResponse] =
          primitive(_.updateAccountSettings(request))

        def updateEnvironment(
          request: UpdateEnvironmentRequest
        ): Kleisli[M, ProtonClient, UpdateEnvironmentResponse] =
          primitive(_.updateEnvironment(request))

        def updateEnvironmentAccountConnection(
          request: UpdateEnvironmentAccountConnectionRequest
        ): Kleisli[M, ProtonClient, UpdateEnvironmentAccountConnectionResponse] =
          primitive(_.updateEnvironmentAccountConnection(request))

        def updateEnvironmentTemplate(
          request: UpdateEnvironmentTemplateRequest
        ): Kleisli[M, ProtonClient, UpdateEnvironmentTemplateResponse] =
          primitive(_.updateEnvironmentTemplate(request))

        def updateEnvironmentTemplateVersion(
          request: UpdateEnvironmentTemplateVersionRequest
        ): Kleisli[M, ProtonClient, UpdateEnvironmentTemplateVersionResponse] =
          primitive(_.updateEnvironmentTemplateVersion(request))

        def updateService(
          request: UpdateServiceRequest
        ): Kleisli[M, ProtonClient, UpdateServiceResponse] =
          primitive(_.updateService(request))

        def updateServiceInstance(
          request: UpdateServiceInstanceRequest
        ): Kleisli[M, ProtonClient, UpdateServiceInstanceResponse] =
          primitive(_.updateServiceInstance(request))

        def updateServicePipeline(
          request: UpdateServicePipelineRequest
        ): Kleisli[M, ProtonClient, UpdateServicePipelineResponse] =
          primitive(_.updateServicePipeline(request))

        def updateServiceTemplate(
          request: UpdateServiceTemplateRequest
        ): Kleisli[M, ProtonClient, UpdateServiceTemplateResponse] =
          primitive(_.updateServiceTemplate(request))

        def updateServiceTemplateVersion(
          request: UpdateServiceTemplateVersionRequest
        ): Kleisli[M, ProtonClient, UpdateServiceTemplateVersionResponse] =
          primitive(_.updateServiceTemplateVersion(request))

        def primitive[A](
          f: ProtonClient => A
        ): Kleisli[M, ProtonClient, A]
      }
    }

    trait Visitor[F[_]] extends (ProtonOp ~> F) {
      final def apply[A](op: ProtonOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptEnvironmentAccountConnection(
        request: AcceptEnvironmentAccountConnectionRequest
      ): F[AcceptEnvironmentAccountConnectionResponse]

      def cancelEnvironmentDeployment(
        request: CancelEnvironmentDeploymentRequest
      ): F[CancelEnvironmentDeploymentResponse]

      def cancelServiceInstanceDeployment(
        request: CancelServiceInstanceDeploymentRequest
      ): F[CancelServiceInstanceDeploymentResponse]

      def cancelServicePipelineDeployment(
        request: CancelServicePipelineDeploymentRequest
      ): F[CancelServicePipelineDeploymentResponse]

      def createEnvironment(
        request: CreateEnvironmentRequest
      ): F[CreateEnvironmentResponse]

      def createEnvironmentAccountConnection(
        request: CreateEnvironmentAccountConnectionRequest
      ): F[CreateEnvironmentAccountConnectionResponse]

      def createEnvironmentTemplate(
        request: CreateEnvironmentTemplateRequest
      ): F[CreateEnvironmentTemplateResponse]

      def createEnvironmentTemplateVersion(
        request: CreateEnvironmentTemplateVersionRequest
      ): F[CreateEnvironmentTemplateVersionResponse]

      def createService(
        request: CreateServiceRequest
      ): F[CreateServiceResponse]

      def createServiceTemplate(
        request: CreateServiceTemplateRequest
      ): F[CreateServiceTemplateResponse]

      def createServiceTemplateVersion(
        request: CreateServiceTemplateVersionRequest
      ): F[CreateServiceTemplateVersionResponse]

      def deleteEnvironment(
        request: DeleteEnvironmentRequest
      ): F[DeleteEnvironmentResponse]

      def deleteEnvironmentAccountConnection(
        request: DeleteEnvironmentAccountConnectionRequest
      ): F[DeleteEnvironmentAccountConnectionResponse]

      def deleteEnvironmentTemplate(
        request: DeleteEnvironmentTemplateRequest
      ): F[DeleteEnvironmentTemplateResponse]

      def deleteEnvironmentTemplateVersion(
        request: DeleteEnvironmentTemplateVersionRequest
      ): F[DeleteEnvironmentTemplateVersionResponse]

      def deleteService(
        request: DeleteServiceRequest
      ): F[DeleteServiceResponse]

      def deleteServiceTemplate(
        request: DeleteServiceTemplateRequest
      ): F[DeleteServiceTemplateResponse]

      def deleteServiceTemplateVersion(
        request: DeleteServiceTemplateVersionRequest
      ): F[DeleteServiceTemplateVersionResponse]

      def getAccountSettings(
        request: GetAccountSettingsRequest
      ): F[GetAccountSettingsResponse]

      def getEnvironment(
        request: GetEnvironmentRequest
      ): F[GetEnvironmentResponse]

      def getEnvironmentAccountConnection(
        request: GetEnvironmentAccountConnectionRequest
      ): F[GetEnvironmentAccountConnectionResponse]

      def getEnvironmentTemplate(
        request: GetEnvironmentTemplateRequest
      ): F[GetEnvironmentTemplateResponse]

      def getEnvironmentTemplateVersion(
        request: GetEnvironmentTemplateVersionRequest
      ): F[GetEnvironmentTemplateVersionResponse]

      def getService(
        request: GetServiceRequest
      ): F[GetServiceResponse]

      def getServiceInstance(
        request: GetServiceInstanceRequest
      ): F[GetServiceInstanceResponse]

      def getServiceTemplate(
        request: GetServiceTemplateRequest
      ): F[GetServiceTemplateResponse]

      def getServiceTemplateVersion(
        request: GetServiceTemplateVersionRequest
      ): F[GetServiceTemplateVersionResponse]

      def listEnvironmentAccountConnections(
        request: ListEnvironmentAccountConnectionsRequest
      ): F[ListEnvironmentAccountConnectionsResponse]

      def listEnvironmentTemplateVersions(
        request: ListEnvironmentTemplateVersionsRequest
      ): F[ListEnvironmentTemplateVersionsResponse]

      def listEnvironmentTemplates(
        request: ListEnvironmentTemplatesRequest
      ): F[ListEnvironmentTemplatesResponse]

      def listEnvironments(
        request: ListEnvironmentsRequest
      ): F[ListEnvironmentsResponse]

      def listServiceInstances(
        request: ListServiceInstancesRequest
      ): F[ListServiceInstancesResponse]

      def listServiceTemplateVersions(
        request: ListServiceTemplateVersionsRequest
      ): F[ListServiceTemplateVersionsResponse]

      def listServiceTemplates(
        request: ListServiceTemplatesRequest
      ): F[ListServiceTemplatesResponse]

      def listServices(
        request: ListServicesRequest
      ): F[ListServicesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def rejectEnvironmentAccountConnection(
        request: RejectEnvironmentAccountConnectionRequest
      ): F[RejectEnvironmentAccountConnectionResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccountSettings(
        request: UpdateAccountSettingsRequest
      ): F[UpdateAccountSettingsResponse]

      def updateEnvironment(
        request: UpdateEnvironmentRequest
      ): F[UpdateEnvironmentResponse]

      def updateEnvironmentAccountConnection(
        request: UpdateEnvironmentAccountConnectionRequest
      ): F[UpdateEnvironmentAccountConnectionResponse]

      def updateEnvironmentTemplate(
        request: UpdateEnvironmentTemplateRequest
      ): F[UpdateEnvironmentTemplateResponse]

      def updateEnvironmentTemplateVersion(
        request: UpdateEnvironmentTemplateVersionRequest
      ): F[UpdateEnvironmentTemplateVersionResponse]

      def updateService(
        request: UpdateServiceRequest
      ): F[UpdateServiceResponse]

      def updateServiceInstance(
        request: UpdateServiceInstanceRequest
      ): F[UpdateServiceInstanceResponse]

      def updateServicePipeline(
        request: UpdateServicePipelineRequest
      ): F[UpdateServicePipelineResponse]

      def updateServiceTemplate(
        request: UpdateServiceTemplateRequest
      ): F[UpdateServiceTemplateResponse]

      def updateServiceTemplateVersion(
        request: UpdateServiceTemplateVersionRequest
      ): F[UpdateServiceTemplateVersionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ProtonOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptEnvironmentAccountConnectionOp(
      request: AcceptEnvironmentAccountConnectionRequest
    ) extends ProtonOp[AcceptEnvironmentAccountConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptEnvironmentAccountConnectionResponse] =
        visitor.acceptEnvironmentAccountConnection(request)
    }

    final case class CancelEnvironmentDeploymentOp(
      request: CancelEnvironmentDeploymentRequest
    ) extends ProtonOp[CancelEnvironmentDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelEnvironmentDeploymentResponse] =
        visitor.cancelEnvironmentDeployment(request)
    }

    final case class CancelServiceInstanceDeploymentOp(
      request: CancelServiceInstanceDeploymentRequest
    ) extends ProtonOp[CancelServiceInstanceDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelServiceInstanceDeploymentResponse] =
        visitor.cancelServiceInstanceDeployment(request)
    }

    final case class CancelServicePipelineDeploymentOp(
      request: CancelServicePipelineDeploymentRequest
    ) extends ProtonOp[CancelServicePipelineDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelServicePipelineDeploymentResponse] =
        visitor.cancelServicePipelineDeployment(request)
    }

    final case class CreateEnvironmentOp(
      request: CreateEnvironmentRequest
    ) extends ProtonOp[CreateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentResponse] =
        visitor.createEnvironment(request)
    }

    final case class CreateEnvironmentAccountConnectionOp(
      request: CreateEnvironmentAccountConnectionRequest
    ) extends ProtonOp[CreateEnvironmentAccountConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentAccountConnectionResponse] =
        visitor.createEnvironmentAccountConnection(request)
    }

    final case class CreateEnvironmentTemplateOp(
      request: CreateEnvironmentTemplateRequest
    ) extends ProtonOp[CreateEnvironmentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentTemplateResponse] =
        visitor.createEnvironmentTemplate(request)
    }

    final case class CreateEnvironmentTemplateVersionOp(
      request: CreateEnvironmentTemplateVersionRequest
    ) extends ProtonOp[CreateEnvironmentTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEnvironmentTemplateVersionResponse] =
        visitor.createEnvironmentTemplateVersion(request)
    }

    final case class CreateServiceOp(
      request: CreateServiceRequest
    ) extends ProtonOp[CreateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceResponse] =
        visitor.createService(request)
    }

    final case class CreateServiceTemplateOp(
      request: CreateServiceTemplateRequest
    ) extends ProtonOp[CreateServiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceTemplateResponse] =
        visitor.createServiceTemplate(request)
    }

    final case class CreateServiceTemplateVersionOp(
      request: CreateServiceTemplateVersionRequest
    ) extends ProtonOp[CreateServiceTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceTemplateVersionResponse] =
        visitor.createServiceTemplateVersion(request)
    }

    final case class DeleteEnvironmentOp(
      request: DeleteEnvironmentRequest
    ) extends ProtonOp[DeleteEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentResponse] =
        visitor.deleteEnvironment(request)
    }

    final case class DeleteEnvironmentAccountConnectionOp(
      request: DeleteEnvironmentAccountConnectionRequest
    ) extends ProtonOp[DeleteEnvironmentAccountConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentAccountConnectionResponse] =
        visitor.deleteEnvironmentAccountConnection(request)
    }

    final case class DeleteEnvironmentTemplateOp(
      request: DeleteEnvironmentTemplateRequest
    ) extends ProtonOp[DeleteEnvironmentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentTemplateResponse] =
        visitor.deleteEnvironmentTemplate(request)
    }

    final case class DeleteEnvironmentTemplateVersionOp(
      request: DeleteEnvironmentTemplateVersionRequest
    ) extends ProtonOp[DeleteEnvironmentTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEnvironmentTemplateVersionResponse] =
        visitor.deleteEnvironmentTemplateVersion(request)
    }

    final case class DeleteServiceOp(
      request: DeleteServiceRequest
    ) extends ProtonOp[DeleteServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceResponse] =
        visitor.deleteService(request)
    }

    final case class DeleteServiceTemplateOp(
      request: DeleteServiceTemplateRequest
    ) extends ProtonOp[DeleteServiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceTemplateResponse] =
        visitor.deleteServiceTemplate(request)
    }

    final case class DeleteServiceTemplateVersionOp(
      request: DeleteServiceTemplateVersionRequest
    ) extends ProtonOp[DeleteServiceTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceTemplateVersionResponse] =
        visitor.deleteServiceTemplateVersion(request)
    }

    final case class GetAccountSettingsOp(
      request: GetAccountSettingsRequest
    ) extends ProtonOp[GetAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountSettingsResponse] =
        visitor.getAccountSettings(request)
    }

    final case class GetEnvironmentOp(
      request: GetEnvironmentRequest
    ) extends ProtonOp[GetEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentResponse] =
        visitor.getEnvironment(request)
    }

    final case class GetEnvironmentAccountConnectionOp(
      request: GetEnvironmentAccountConnectionRequest
    ) extends ProtonOp[GetEnvironmentAccountConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentAccountConnectionResponse] =
        visitor.getEnvironmentAccountConnection(request)
    }

    final case class GetEnvironmentTemplateOp(
      request: GetEnvironmentTemplateRequest
    ) extends ProtonOp[GetEnvironmentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentTemplateResponse] =
        visitor.getEnvironmentTemplate(request)
    }

    final case class GetEnvironmentTemplateVersionOp(
      request: GetEnvironmentTemplateVersionRequest
    ) extends ProtonOp[GetEnvironmentTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEnvironmentTemplateVersionResponse] =
        visitor.getEnvironmentTemplateVersion(request)
    }

    final case class GetServiceOp(
      request: GetServiceRequest
    ) extends ProtonOp[GetServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceResponse] =
        visitor.getService(request)
    }

    final case class GetServiceInstanceOp(
      request: GetServiceInstanceRequest
    ) extends ProtonOp[GetServiceInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceInstanceResponse] =
        visitor.getServiceInstance(request)
    }

    final case class GetServiceTemplateOp(
      request: GetServiceTemplateRequest
    ) extends ProtonOp[GetServiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceTemplateResponse] =
        visitor.getServiceTemplate(request)
    }

    final case class GetServiceTemplateVersionOp(
      request: GetServiceTemplateVersionRequest
    ) extends ProtonOp[GetServiceTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceTemplateVersionResponse] =
        visitor.getServiceTemplateVersion(request)
    }

    final case class ListEnvironmentAccountConnectionsOp(
      request: ListEnvironmentAccountConnectionsRequest
    ) extends ProtonOp[ListEnvironmentAccountConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentAccountConnectionsResponse] =
        visitor.listEnvironmentAccountConnections(request)
    }

    final case class ListEnvironmentTemplateVersionsOp(
      request: ListEnvironmentTemplateVersionsRequest
    ) extends ProtonOp[ListEnvironmentTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentTemplateVersionsResponse] =
        visitor.listEnvironmentTemplateVersions(request)
    }

    final case class ListEnvironmentTemplatesOp(
      request: ListEnvironmentTemplatesRequest
    ) extends ProtonOp[ListEnvironmentTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentTemplatesResponse] =
        visitor.listEnvironmentTemplates(request)
    }

    final case class ListEnvironmentsOp(
      request: ListEnvironmentsRequest
    ) extends ProtonOp[ListEnvironmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEnvironmentsResponse] =
        visitor.listEnvironments(request)
    }

    final case class ListServiceInstancesOp(
      request: ListServiceInstancesRequest
    ) extends ProtonOp[ListServiceInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceInstancesResponse] =
        visitor.listServiceInstances(request)
    }

    final case class ListServiceTemplateVersionsOp(
      request: ListServiceTemplateVersionsRequest
    ) extends ProtonOp[ListServiceTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceTemplateVersionsResponse] =
        visitor.listServiceTemplateVersions(request)
    }

    final case class ListServiceTemplatesOp(
      request: ListServiceTemplatesRequest
    ) extends ProtonOp[ListServiceTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceTemplatesResponse] =
        visitor.listServiceTemplates(request)
    }

    final case class ListServicesOp(
      request: ListServicesRequest
    ) extends ProtonOp[ListServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServicesResponse] =
        visitor.listServices(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ProtonOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RejectEnvironmentAccountConnectionOp(
      request: RejectEnvironmentAccountConnectionRequest
    ) extends ProtonOp[RejectEnvironmentAccountConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectEnvironmentAccountConnectionResponse] =
        visitor.rejectEnvironmentAccountConnection(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ProtonOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ProtonOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccountSettingsOp(
      request: UpdateAccountSettingsRequest
    ) extends ProtonOp[UpdateAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountSettingsResponse] =
        visitor.updateAccountSettings(request)
    }

    final case class UpdateEnvironmentOp(
      request: UpdateEnvironmentRequest
    ) extends ProtonOp[UpdateEnvironmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentResponse] =
        visitor.updateEnvironment(request)
    }

    final case class UpdateEnvironmentAccountConnectionOp(
      request: UpdateEnvironmentAccountConnectionRequest
    ) extends ProtonOp[UpdateEnvironmentAccountConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentAccountConnectionResponse] =
        visitor.updateEnvironmentAccountConnection(request)
    }

    final case class UpdateEnvironmentTemplateOp(
      request: UpdateEnvironmentTemplateRequest
    ) extends ProtonOp[UpdateEnvironmentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentTemplateResponse] =
        visitor.updateEnvironmentTemplate(request)
    }

    final case class UpdateEnvironmentTemplateVersionOp(
      request: UpdateEnvironmentTemplateVersionRequest
    ) extends ProtonOp[UpdateEnvironmentTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEnvironmentTemplateVersionResponse] =
        visitor.updateEnvironmentTemplateVersion(request)
    }

    final case class UpdateServiceOp(
      request: UpdateServiceRequest
    ) extends ProtonOp[UpdateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceResponse] =
        visitor.updateService(request)
    }

    final case class UpdateServiceInstanceOp(
      request: UpdateServiceInstanceRequest
    ) extends ProtonOp[UpdateServiceInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceInstanceResponse] =
        visitor.updateServiceInstance(request)
    }

    final case class UpdateServicePipelineOp(
      request: UpdateServicePipelineRequest
    ) extends ProtonOp[UpdateServicePipelineResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServicePipelineResponse] =
        visitor.updateServicePipeline(request)
    }

    final case class UpdateServiceTemplateOp(
      request: UpdateServiceTemplateRequest
    ) extends ProtonOp[UpdateServiceTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceTemplateResponse] =
        visitor.updateServiceTemplate(request)
    }

    final case class UpdateServiceTemplateVersionOp(
      request: UpdateServiceTemplateVersionRequest
    ) extends ProtonOp[UpdateServiceTemplateVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceTemplateVersionResponse] =
        visitor.updateServiceTemplateVersion(request)
    }
  }

  import ProtonOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ProtonOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptEnvironmentAccountConnection(
    request: AcceptEnvironmentAccountConnectionRequest
  ): ProtonIO[AcceptEnvironmentAccountConnectionResponse] =
    FF.liftF(AcceptEnvironmentAccountConnectionOp(request))

  def cancelEnvironmentDeployment(
    request: CancelEnvironmentDeploymentRequest
  ): ProtonIO[CancelEnvironmentDeploymentResponse] =
    FF.liftF(CancelEnvironmentDeploymentOp(request))

  def cancelServiceInstanceDeployment(
    request: CancelServiceInstanceDeploymentRequest
  ): ProtonIO[CancelServiceInstanceDeploymentResponse] =
    FF.liftF(CancelServiceInstanceDeploymentOp(request))

  def cancelServicePipelineDeployment(
    request: CancelServicePipelineDeploymentRequest
  ): ProtonIO[CancelServicePipelineDeploymentResponse] =
    FF.liftF(CancelServicePipelineDeploymentOp(request))

  def createEnvironment(
    request: CreateEnvironmentRequest
  ): ProtonIO[CreateEnvironmentResponse] =
    FF.liftF(CreateEnvironmentOp(request))

  def createEnvironmentAccountConnection(
    request: CreateEnvironmentAccountConnectionRequest
  ): ProtonIO[CreateEnvironmentAccountConnectionResponse] =
    FF.liftF(CreateEnvironmentAccountConnectionOp(request))

  def createEnvironmentTemplate(
    request: CreateEnvironmentTemplateRequest
  ): ProtonIO[CreateEnvironmentTemplateResponse] =
    FF.liftF(CreateEnvironmentTemplateOp(request))

  def createEnvironmentTemplateVersion(
    request: CreateEnvironmentTemplateVersionRequest
  ): ProtonIO[CreateEnvironmentTemplateVersionResponse] =
    FF.liftF(CreateEnvironmentTemplateVersionOp(request))

  def createService(
    request: CreateServiceRequest
  ): ProtonIO[CreateServiceResponse] =
    FF.liftF(CreateServiceOp(request))

  def createServiceTemplate(
    request: CreateServiceTemplateRequest
  ): ProtonIO[CreateServiceTemplateResponse] =
    FF.liftF(CreateServiceTemplateOp(request))

  def createServiceTemplateVersion(
    request: CreateServiceTemplateVersionRequest
  ): ProtonIO[CreateServiceTemplateVersionResponse] =
    FF.liftF(CreateServiceTemplateVersionOp(request))

  def deleteEnvironment(
    request: DeleteEnvironmentRequest
  ): ProtonIO[DeleteEnvironmentResponse] =
    FF.liftF(DeleteEnvironmentOp(request))

  def deleteEnvironmentAccountConnection(
    request: DeleteEnvironmentAccountConnectionRequest
  ): ProtonIO[DeleteEnvironmentAccountConnectionResponse] =
    FF.liftF(DeleteEnvironmentAccountConnectionOp(request))

  def deleteEnvironmentTemplate(
    request: DeleteEnvironmentTemplateRequest
  ): ProtonIO[DeleteEnvironmentTemplateResponse] =
    FF.liftF(DeleteEnvironmentTemplateOp(request))

  def deleteEnvironmentTemplateVersion(
    request: DeleteEnvironmentTemplateVersionRequest
  ): ProtonIO[DeleteEnvironmentTemplateVersionResponse] =
    FF.liftF(DeleteEnvironmentTemplateVersionOp(request))

  def deleteService(
    request: DeleteServiceRequest
  ): ProtonIO[DeleteServiceResponse] =
    FF.liftF(DeleteServiceOp(request))

  def deleteServiceTemplate(
    request: DeleteServiceTemplateRequest
  ): ProtonIO[DeleteServiceTemplateResponse] =
    FF.liftF(DeleteServiceTemplateOp(request))

  def deleteServiceTemplateVersion(
    request: DeleteServiceTemplateVersionRequest
  ): ProtonIO[DeleteServiceTemplateVersionResponse] =
    FF.liftF(DeleteServiceTemplateVersionOp(request))

  def getAccountSettings(
    request: GetAccountSettingsRequest
  ): ProtonIO[GetAccountSettingsResponse] =
    FF.liftF(GetAccountSettingsOp(request))

  def getEnvironment(
    request: GetEnvironmentRequest
  ): ProtonIO[GetEnvironmentResponse] =
    FF.liftF(GetEnvironmentOp(request))

  def getEnvironmentAccountConnection(
    request: GetEnvironmentAccountConnectionRequest
  ): ProtonIO[GetEnvironmentAccountConnectionResponse] =
    FF.liftF(GetEnvironmentAccountConnectionOp(request))

  def getEnvironmentTemplate(
    request: GetEnvironmentTemplateRequest
  ): ProtonIO[GetEnvironmentTemplateResponse] =
    FF.liftF(GetEnvironmentTemplateOp(request))

  def getEnvironmentTemplateVersion(
    request: GetEnvironmentTemplateVersionRequest
  ): ProtonIO[GetEnvironmentTemplateVersionResponse] =
    FF.liftF(GetEnvironmentTemplateVersionOp(request))

  def getService(
    request: GetServiceRequest
  ): ProtonIO[GetServiceResponse] =
    FF.liftF(GetServiceOp(request))

  def getServiceInstance(
    request: GetServiceInstanceRequest
  ): ProtonIO[GetServiceInstanceResponse] =
    FF.liftF(GetServiceInstanceOp(request))

  def getServiceTemplate(
    request: GetServiceTemplateRequest
  ): ProtonIO[GetServiceTemplateResponse] =
    FF.liftF(GetServiceTemplateOp(request))

  def getServiceTemplateVersion(
    request: GetServiceTemplateVersionRequest
  ): ProtonIO[GetServiceTemplateVersionResponse] =
    FF.liftF(GetServiceTemplateVersionOp(request))

  def listEnvironmentAccountConnections(
    request: ListEnvironmentAccountConnectionsRequest
  ): ProtonIO[ListEnvironmentAccountConnectionsResponse] =
    FF.liftF(ListEnvironmentAccountConnectionsOp(request))

  def listEnvironmentTemplateVersions(
    request: ListEnvironmentTemplateVersionsRequest
  ): ProtonIO[ListEnvironmentTemplateVersionsResponse] =
    FF.liftF(ListEnvironmentTemplateVersionsOp(request))

  def listEnvironmentTemplates(
    request: ListEnvironmentTemplatesRequest
  ): ProtonIO[ListEnvironmentTemplatesResponse] =
    FF.liftF(ListEnvironmentTemplatesOp(request))

  def listEnvironments(
    request: ListEnvironmentsRequest
  ): ProtonIO[ListEnvironmentsResponse] =
    FF.liftF(ListEnvironmentsOp(request))

  def listServiceInstances(
    request: ListServiceInstancesRequest
  ): ProtonIO[ListServiceInstancesResponse] =
    FF.liftF(ListServiceInstancesOp(request))

  def listServiceTemplateVersions(
    request: ListServiceTemplateVersionsRequest
  ): ProtonIO[ListServiceTemplateVersionsResponse] =
    FF.liftF(ListServiceTemplateVersionsOp(request))

  def listServiceTemplates(
    request: ListServiceTemplatesRequest
  ): ProtonIO[ListServiceTemplatesResponse] =
    FF.liftF(ListServiceTemplatesOp(request))

  def listServices(
    request: ListServicesRequest
  ): ProtonIO[ListServicesResponse] =
    FF.liftF(ListServicesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ProtonIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def rejectEnvironmentAccountConnection(
    request: RejectEnvironmentAccountConnectionRequest
  ): ProtonIO[RejectEnvironmentAccountConnectionResponse] =
    FF.liftF(RejectEnvironmentAccountConnectionOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ProtonIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ProtonIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccountSettings(
    request: UpdateAccountSettingsRequest
  ): ProtonIO[UpdateAccountSettingsResponse] =
    FF.liftF(UpdateAccountSettingsOp(request))

  def updateEnvironment(
    request: UpdateEnvironmentRequest
  ): ProtonIO[UpdateEnvironmentResponse] =
    FF.liftF(UpdateEnvironmentOp(request))

  def updateEnvironmentAccountConnection(
    request: UpdateEnvironmentAccountConnectionRequest
  ): ProtonIO[UpdateEnvironmentAccountConnectionResponse] =
    FF.liftF(UpdateEnvironmentAccountConnectionOp(request))

  def updateEnvironmentTemplate(
    request: UpdateEnvironmentTemplateRequest
  ): ProtonIO[UpdateEnvironmentTemplateResponse] =
    FF.liftF(UpdateEnvironmentTemplateOp(request))

  def updateEnvironmentTemplateVersion(
    request: UpdateEnvironmentTemplateVersionRequest
  ): ProtonIO[UpdateEnvironmentTemplateVersionResponse] =
    FF.liftF(UpdateEnvironmentTemplateVersionOp(request))

  def updateService(
    request: UpdateServiceRequest
  ): ProtonIO[UpdateServiceResponse] =
    FF.liftF(UpdateServiceOp(request))

  def updateServiceInstance(
    request: UpdateServiceInstanceRequest
  ): ProtonIO[UpdateServiceInstanceResponse] =
    FF.liftF(UpdateServiceInstanceOp(request))

  def updateServicePipeline(
    request: UpdateServicePipelineRequest
  ): ProtonIO[UpdateServicePipelineResponse] =
    FF.liftF(UpdateServicePipelineOp(request))

  def updateServiceTemplate(
    request: UpdateServiceTemplateRequest
  ): ProtonIO[UpdateServiceTemplateResponse] =
    FF.liftF(UpdateServiceTemplateOp(request))

  def updateServiceTemplateVersion(
    request: UpdateServiceTemplateVersionRequest
  ): ProtonIO[UpdateServiceTemplateVersionResponse] =
    FF.liftF(UpdateServiceTemplateVersionOp(request))
}
