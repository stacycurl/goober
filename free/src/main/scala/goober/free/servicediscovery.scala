package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.servicediscovery.ServiceDiscoveryClient
import software.amazon.awssdk.services.servicediscovery.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object servicediscovery { module =>

  // Free monad over ServiceDiscoveryOp
  type ServiceDiscoveryIO[A] = FF[ServiceDiscoveryOp, A]

  sealed trait ServiceDiscoveryOp[A] {
    def visit[F[_]](visitor: ServiceDiscoveryOp.Visitor[F]): F[A]
  }

  object ServiceDiscoveryOp {
    // Given a ServiceDiscoveryClient we can embed a ServiceDiscoveryIO program in any algebra that understands embedding.
    implicit val ServiceDiscoveryOpEmbeddable: Embeddable[ServiceDiscoveryOp, ServiceDiscoveryClient] = new Embeddable[ServiceDiscoveryOp, ServiceDiscoveryClient] {
      def embed[A](client: ServiceDiscoveryClient, io: ServiceDiscoveryIO[A]): Embedded[A] = Embedded.ServiceDiscovery(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ServiceDiscoveryOp.Visitor[Kleisli[M, ServiceDiscoveryClient, *]] {
        def createHttpNamespace(
          request: CreateHttpNamespaceRequest
        ): Kleisli[M, ServiceDiscoveryClient, CreateHttpNamespaceResponse] =
          primitive(_.createHttpNamespace(request))

        def createPrivateDnsNamespace(
          request: CreatePrivateDnsNamespaceRequest
        ): Kleisli[M, ServiceDiscoveryClient, CreatePrivateDnsNamespaceResponse] =
          primitive(_.createPrivateDnsNamespace(request))

        def createPublicDnsNamespace(
          request: CreatePublicDnsNamespaceRequest
        ): Kleisli[M, ServiceDiscoveryClient, CreatePublicDnsNamespaceResponse] =
          primitive(_.createPublicDnsNamespace(request))

        def createService(
          request: CreateServiceRequest
        ): Kleisli[M, ServiceDiscoveryClient, CreateServiceResponse] =
          primitive(_.createService(request))

        def deleteNamespace(
          request: DeleteNamespaceRequest
        ): Kleisli[M, ServiceDiscoveryClient, DeleteNamespaceResponse] =
          primitive(_.deleteNamespace(request))

        def deleteService(
          request: DeleteServiceRequest
        ): Kleisli[M, ServiceDiscoveryClient, DeleteServiceResponse] =
          primitive(_.deleteService(request))

        def deregisterInstance(
          request: DeregisterInstanceRequest
        ): Kleisli[M, ServiceDiscoveryClient, DeregisterInstanceResponse] =
          primitive(_.deregisterInstance(request))

        def discoverInstances(
          request: DiscoverInstancesRequest
        ): Kleisli[M, ServiceDiscoveryClient, DiscoverInstancesResponse] =
          primitive(_.discoverInstances(request))

        def getInstance(
          request: GetInstanceRequest
        ): Kleisli[M, ServiceDiscoveryClient, GetInstanceResponse] =
          primitive(_.getInstance(request))

        def getInstancesHealthStatus(
          request: GetInstancesHealthStatusRequest
        ): Kleisli[M, ServiceDiscoveryClient, GetInstancesHealthStatusResponse] =
          primitive(_.getInstancesHealthStatus(request))

        def getNamespace(
          request: GetNamespaceRequest
        ): Kleisli[M, ServiceDiscoveryClient, GetNamespaceResponse] =
          primitive(_.getNamespace(request))

        def getOperation(
          request: GetOperationRequest
        ): Kleisli[M, ServiceDiscoveryClient, GetOperationResponse] =
          primitive(_.getOperation(request))

        def getService(
          request: GetServiceRequest
        ): Kleisli[M, ServiceDiscoveryClient, GetServiceResponse] =
          primitive(_.getService(request))

        def listInstances(
          request: ListInstancesRequest
        ): Kleisli[M, ServiceDiscoveryClient, ListInstancesResponse] =
          primitive(_.listInstances(request))

        def listNamespaces(
          request: ListNamespacesRequest
        ): Kleisli[M, ServiceDiscoveryClient, ListNamespacesResponse] =
          primitive(_.listNamespaces(request))

        def listOperations(
          request: ListOperationsRequest
        ): Kleisli[M, ServiceDiscoveryClient, ListOperationsResponse] =
          primitive(_.listOperations(request))

        def listServices(
          request: ListServicesRequest
        ): Kleisli[M, ServiceDiscoveryClient, ListServicesResponse] =
          primitive(_.listServices(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ServiceDiscoveryClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def registerInstance(
          request: RegisterInstanceRequest
        ): Kleisli[M, ServiceDiscoveryClient, RegisterInstanceResponse] =
          primitive(_.registerInstance(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ServiceDiscoveryClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ServiceDiscoveryClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateInstanceCustomHealthStatus(
          request: UpdateInstanceCustomHealthStatusRequest
        ): Kleisli[M, ServiceDiscoveryClient, UpdateInstanceCustomHealthStatusResponse] =
          primitive(_.updateInstanceCustomHealthStatus(request))

        def updateService(
          request: UpdateServiceRequest
        ): Kleisli[M, ServiceDiscoveryClient, UpdateServiceResponse] =
          primitive(_.updateService(request))

        def primitive[A](
          f: ServiceDiscoveryClient => A
        ): Kleisli[M, ServiceDiscoveryClient, A]
      }
    }

    trait Visitor[F[_]] extends (ServiceDiscoveryOp ~> F) {
      final def apply[A](op: ServiceDiscoveryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createHttpNamespace(
        request: CreateHttpNamespaceRequest
      ): F[CreateHttpNamespaceResponse]

      def createPrivateDnsNamespace(
        request: CreatePrivateDnsNamespaceRequest
      ): F[CreatePrivateDnsNamespaceResponse]

      def createPublicDnsNamespace(
        request: CreatePublicDnsNamespaceRequest
      ): F[CreatePublicDnsNamespaceResponse]

      def createService(
        request: CreateServiceRequest
      ): F[CreateServiceResponse]

      def deleteNamespace(
        request: DeleteNamespaceRequest
      ): F[DeleteNamespaceResponse]

      def deleteService(
        request: DeleteServiceRequest
      ): F[DeleteServiceResponse]

      def deregisterInstance(
        request: DeregisterInstanceRequest
      ): F[DeregisterInstanceResponse]

      def discoverInstances(
        request: DiscoverInstancesRequest
      ): F[DiscoverInstancesResponse]

      def getInstance(
        request: GetInstanceRequest
      ): F[GetInstanceResponse]

      def getInstancesHealthStatus(
        request: GetInstancesHealthStatusRequest
      ): F[GetInstancesHealthStatusResponse]

      def getNamespace(
        request: GetNamespaceRequest
      ): F[GetNamespaceResponse]

      def getOperation(
        request: GetOperationRequest
      ): F[GetOperationResponse]

      def getService(
        request: GetServiceRequest
      ): F[GetServiceResponse]

      def listInstances(
        request: ListInstancesRequest
      ): F[ListInstancesResponse]

      def listNamespaces(
        request: ListNamespacesRequest
      ): F[ListNamespacesResponse]

      def listOperations(
        request: ListOperationsRequest
      ): F[ListOperationsResponse]

      def listServices(
        request: ListServicesRequest
      ): F[ListServicesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def registerInstance(
        request: RegisterInstanceRequest
      ): F[RegisterInstanceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateInstanceCustomHealthStatus(
        request: UpdateInstanceCustomHealthStatusRequest
      ): F[UpdateInstanceCustomHealthStatusResponse]

      def updateService(
        request: UpdateServiceRequest
      ): F[UpdateServiceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ServiceDiscoveryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateHttpNamespaceOp(
      request: CreateHttpNamespaceRequest
    ) extends ServiceDiscoveryOp[CreateHttpNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHttpNamespaceResponse] =
        visitor.createHttpNamespace(request)
    }

    final case class CreatePrivateDnsNamespaceOp(
      request: CreatePrivateDnsNamespaceRequest
    ) extends ServiceDiscoveryOp[CreatePrivateDnsNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePrivateDnsNamespaceResponse] =
        visitor.createPrivateDnsNamespace(request)
    }

    final case class CreatePublicDnsNamespaceOp(
      request: CreatePublicDnsNamespaceRequest
    ) extends ServiceDiscoveryOp[CreatePublicDnsNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePublicDnsNamespaceResponse] =
        visitor.createPublicDnsNamespace(request)
    }

    final case class CreateServiceOp(
      request: CreateServiceRequest
    ) extends ServiceDiscoveryOp[CreateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceResponse] =
        visitor.createService(request)
    }

    final case class DeleteNamespaceOp(
      request: DeleteNamespaceRequest
    ) extends ServiceDiscoveryOp[DeleteNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNamespaceResponse] =
        visitor.deleteNamespace(request)
    }

    final case class DeleteServiceOp(
      request: DeleteServiceRequest
    ) extends ServiceDiscoveryOp[DeleteServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceResponse] =
        visitor.deleteService(request)
    }

    final case class DeregisterInstanceOp(
      request: DeregisterInstanceRequest
    ) extends ServiceDiscoveryOp[DeregisterInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterInstanceResponse] =
        visitor.deregisterInstance(request)
    }

    final case class DiscoverInstancesOp(
      request: DiscoverInstancesRequest
    ) extends ServiceDiscoveryOp[DiscoverInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DiscoverInstancesResponse] =
        visitor.discoverInstances(request)
    }

    final case class GetInstanceOp(
      request: GetInstanceRequest
    ) extends ServiceDiscoveryOp[GetInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceResponse] =
        visitor.getInstance(request)
    }

    final case class GetInstancesHealthStatusOp(
      request: GetInstancesHealthStatusRequest
    ) extends ServiceDiscoveryOp[GetInstancesHealthStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstancesHealthStatusResponse] =
        visitor.getInstancesHealthStatus(request)
    }

    final case class GetNamespaceOp(
      request: GetNamespaceRequest
    ) extends ServiceDiscoveryOp[GetNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNamespaceResponse] =
        visitor.getNamespace(request)
    }

    final case class GetOperationOp(
      request: GetOperationRequest
    ) extends ServiceDiscoveryOp[GetOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOperationResponse] =
        visitor.getOperation(request)
    }

    final case class GetServiceOp(
      request: GetServiceRequest
    ) extends ServiceDiscoveryOp[GetServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceResponse] =
        visitor.getService(request)
    }

    final case class ListInstancesOp(
      request: ListInstancesRequest
    ) extends ServiceDiscoveryOp[ListInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstancesResponse] =
        visitor.listInstances(request)
    }

    final case class ListNamespacesOp(
      request: ListNamespacesRequest
    ) extends ServiceDiscoveryOp[ListNamespacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNamespacesResponse] =
        visitor.listNamespaces(request)
    }

    final case class ListOperationsOp(
      request: ListOperationsRequest
    ) extends ServiceDiscoveryOp[ListOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOperationsResponse] =
        visitor.listOperations(request)
    }

    final case class ListServicesOp(
      request: ListServicesRequest
    ) extends ServiceDiscoveryOp[ListServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServicesResponse] =
        visitor.listServices(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ServiceDiscoveryOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RegisterInstanceOp(
      request: RegisterInstanceRequest
    ) extends ServiceDiscoveryOp[RegisterInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterInstanceResponse] =
        visitor.registerInstance(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ServiceDiscoveryOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ServiceDiscoveryOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateInstanceCustomHealthStatusOp(
      request: UpdateInstanceCustomHealthStatusRequest
    ) extends ServiceDiscoveryOp[UpdateInstanceCustomHealthStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInstanceCustomHealthStatusResponse] =
        visitor.updateInstanceCustomHealthStatus(request)
    }

    final case class UpdateServiceOp(
      request: UpdateServiceRequest
    ) extends ServiceDiscoveryOp[UpdateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceResponse] =
        visitor.updateService(request)
    }
  }

  import ServiceDiscoveryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ServiceDiscoveryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createHttpNamespace(
    request: CreateHttpNamespaceRequest
  ): ServiceDiscoveryIO[CreateHttpNamespaceResponse] =
    FF.liftF(CreateHttpNamespaceOp(request))

  def createPrivateDnsNamespace(
    request: CreatePrivateDnsNamespaceRequest
  ): ServiceDiscoveryIO[CreatePrivateDnsNamespaceResponse] =
    FF.liftF(CreatePrivateDnsNamespaceOp(request))

  def createPublicDnsNamespace(
    request: CreatePublicDnsNamespaceRequest
  ): ServiceDiscoveryIO[CreatePublicDnsNamespaceResponse] =
    FF.liftF(CreatePublicDnsNamespaceOp(request))

  def createService(
    request: CreateServiceRequest
  ): ServiceDiscoveryIO[CreateServiceResponse] =
    FF.liftF(CreateServiceOp(request))

  def deleteNamespace(
    request: DeleteNamespaceRequest
  ): ServiceDiscoveryIO[DeleteNamespaceResponse] =
    FF.liftF(DeleteNamespaceOp(request))

  def deleteService(
    request: DeleteServiceRequest
  ): ServiceDiscoveryIO[DeleteServiceResponse] =
    FF.liftF(DeleteServiceOp(request))

  def deregisterInstance(
    request: DeregisterInstanceRequest
  ): ServiceDiscoveryIO[DeregisterInstanceResponse] =
    FF.liftF(DeregisterInstanceOp(request))

  def discoverInstances(
    request: DiscoverInstancesRequest
  ): ServiceDiscoveryIO[DiscoverInstancesResponse] =
    FF.liftF(DiscoverInstancesOp(request))

  def getInstance(
    request: GetInstanceRequest
  ): ServiceDiscoveryIO[GetInstanceResponse] =
    FF.liftF(GetInstanceOp(request))

  def getInstancesHealthStatus(
    request: GetInstancesHealthStatusRequest
  ): ServiceDiscoveryIO[GetInstancesHealthStatusResponse] =
    FF.liftF(GetInstancesHealthStatusOp(request))

  def getNamespace(
    request: GetNamespaceRequest
  ): ServiceDiscoveryIO[GetNamespaceResponse] =
    FF.liftF(GetNamespaceOp(request))

  def getOperation(
    request: GetOperationRequest
  ): ServiceDiscoveryIO[GetOperationResponse] =
    FF.liftF(GetOperationOp(request))

  def getService(
    request: GetServiceRequest
  ): ServiceDiscoveryIO[GetServiceResponse] =
    FF.liftF(GetServiceOp(request))

  def listInstances(
    request: ListInstancesRequest
  ): ServiceDiscoveryIO[ListInstancesResponse] =
    FF.liftF(ListInstancesOp(request))

  def listNamespaces(
    request: ListNamespacesRequest
  ): ServiceDiscoveryIO[ListNamespacesResponse] =
    FF.liftF(ListNamespacesOp(request))

  def listOperations(
    request: ListOperationsRequest
  ): ServiceDiscoveryIO[ListOperationsResponse] =
    FF.liftF(ListOperationsOp(request))

  def listServices(
    request: ListServicesRequest
  ): ServiceDiscoveryIO[ListServicesResponse] =
    FF.liftF(ListServicesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ServiceDiscoveryIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def registerInstance(
    request: RegisterInstanceRequest
  ): ServiceDiscoveryIO[RegisterInstanceResponse] =
    FF.liftF(RegisterInstanceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ServiceDiscoveryIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ServiceDiscoveryIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateInstanceCustomHealthStatus(
    request: UpdateInstanceCustomHealthStatusRequest
  ): ServiceDiscoveryIO[UpdateInstanceCustomHealthStatusResponse] =
    FF.liftF(UpdateInstanceCustomHealthStatusOp(request))

  def updateService(
    request: UpdateServiceRequest
  ): ServiceDiscoveryIO[UpdateServiceResponse] =
    FF.liftF(UpdateServiceOp(request))
}
