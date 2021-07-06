package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.servicecatalogappregistry.ServiceCatalogAppRegistryClient
import software.amazon.awssdk.services.servicecatalogappregistry.model._


object servicecatalogappregistry { module =>

  // Free monad over ServiceCatalogAppRegistryOp
  type ServiceCatalogAppRegistryIO[A] = FF[ServiceCatalogAppRegistryOp, A]

  sealed trait ServiceCatalogAppRegistryOp[A] {
    def visit[F[_]](visitor: ServiceCatalogAppRegistryOp.Visitor[F]): F[A]
  }

  object ServiceCatalogAppRegistryOp {
    // Given a ServiceCatalogAppRegistryClient we can embed a ServiceCatalogAppRegistryIO program in any algebra that understands embedding.
    implicit val ServiceCatalogAppRegistryOpEmbeddable: Embeddable[ServiceCatalogAppRegistryOp, ServiceCatalogAppRegistryClient] = new Embeddable[ServiceCatalogAppRegistryOp, ServiceCatalogAppRegistryClient] {
      def embed[A](client: ServiceCatalogAppRegistryClient, io: ServiceCatalogAppRegistryIO[A]): Embedded[A] = Embedded.ServiceCatalogAppRegistry(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ServiceCatalogAppRegistryOp.Visitor[Kleisli[M, ServiceCatalogAppRegistryClient, *]] {
        def associateAttributeGroup(
          request: AssociateAttributeGroupRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, AssociateAttributeGroupResponse] =
          primitive(_.associateAttributeGroup(request))

        def associateResource(
          request: AssociateResourceRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, AssociateResourceResponse] =
          primitive(_.associateResource(request))

        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createAttributeGroup(
          request: CreateAttributeGroupRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, CreateAttributeGroupResponse] =
          primitive(_.createAttributeGroup(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteAttributeGroup(
          request: DeleteAttributeGroupRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, DeleteAttributeGroupResponse] =
          primitive(_.deleteAttributeGroup(request))

        def disassociateAttributeGroup(
          request: DisassociateAttributeGroupRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, DisassociateAttributeGroupResponse] =
          primitive(_.disassociateAttributeGroup(request))

        def disassociateResource(
          request: DisassociateResourceRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, DisassociateResourceResponse] =
          primitive(_.disassociateResource(request))

        def getApplication(
          request: GetApplicationRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, GetApplicationResponse] =
          primitive(_.getApplication(request))

        def getAttributeGroup(
          request: GetAttributeGroupRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, GetAttributeGroupResponse] =
          primitive(_.getAttributeGroup(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listAssociatedAttributeGroups(
          request: ListAssociatedAttributeGroupsRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, ListAssociatedAttributeGroupsResponse] =
          primitive(_.listAssociatedAttributeGroups(request))

        def listAssociatedResources(
          request: ListAssociatedResourcesRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, ListAssociatedResourcesResponse] =
          primitive(_.listAssociatedResources(request))

        def listAttributeGroups(
          request: ListAttributeGroupsRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, ListAttributeGroupsResponse] =
          primitive(_.listAttributeGroups(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def syncResource(
          request: SyncResourceRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, SyncResourceResponse] =
          primitive(_.syncResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def updateAttributeGroup(
          request: UpdateAttributeGroupRequest
        ): Kleisli[M, ServiceCatalogAppRegistryClient, UpdateAttributeGroupResponse] =
          primitive(_.updateAttributeGroup(request))

        def primitive[A](
          f: ServiceCatalogAppRegistryClient => A
        ): Kleisli[M, ServiceCatalogAppRegistryClient, A]
      }
    }

    trait Visitor[F[_]] extends (ServiceCatalogAppRegistryOp ~> F) {
      final def apply[A](op: ServiceCatalogAppRegistryOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateAttributeGroup(
        request: AssociateAttributeGroupRequest
      ): F[AssociateAttributeGroupResponse]

      def associateResource(
        request: AssociateResourceRequest
      ): F[AssociateResourceResponse]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createAttributeGroup(
        request: CreateAttributeGroupRequest
      ): F[CreateAttributeGroupResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def deleteAttributeGroup(
        request: DeleteAttributeGroupRequest
      ): F[DeleteAttributeGroupResponse]

      def disassociateAttributeGroup(
        request: DisassociateAttributeGroupRequest
      ): F[DisassociateAttributeGroupResponse]

      def disassociateResource(
        request: DisassociateResourceRequest
      ): F[DisassociateResourceResponse]

      def getApplication(
        request: GetApplicationRequest
      ): F[GetApplicationResponse]

      def getAttributeGroup(
        request: GetAttributeGroupRequest
      ): F[GetAttributeGroupResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listAssociatedAttributeGroups(
        request: ListAssociatedAttributeGroupsRequest
      ): F[ListAssociatedAttributeGroupsResponse]

      def listAssociatedResources(
        request: ListAssociatedResourcesRequest
      ): F[ListAssociatedResourcesResponse]

      def listAttributeGroups(
        request: ListAttributeGroupsRequest
      ): F[ListAttributeGroupsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def syncResource(
        request: SyncResourceRequest
      ): F[SyncResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]

      def updateAttributeGroup(
        request: UpdateAttributeGroupRequest
      ): F[UpdateAttributeGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ServiceCatalogAppRegistryOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateAttributeGroupOp(
      request: AssociateAttributeGroupRequest
    ) extends ServiceCatalogAppRegistryOp[AssociateAttributeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateAttributeGroupResponse] =
        visitor.associateAttributeGroup(request)
    }

    final case class AssociateResourceOp(
      request: AssociateResourceRequest
    ) extends ServiceCatalogAppRegistryOp[AssociateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateResourceResponse] =
        visitor.associateResource(request)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends ServiceCatalogAppRegistryOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateAttributeGroupOp(
      request: CreateAttributeGroupRequest
    ) extends ServiceCatalogAppRegistryOp[CreateAttributeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAttributeGroupResponse] =
        visitor.createAttributeGroup(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends ServiceCatalogAppRegistryOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteAttributeGroupOp(
      request: DeleteAttributeGroupRequest
    ) extends ServiceCatalogAppRegistryOp[DeleteAttributeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAttributeGroupResponse] =
        visitor.deleteAttributeGroup(request)
    }

    final case class DisassociateAttributeGroupOp(
      request: DisassociateAttributeGroupRequest
    ) extends ServiceCatalogAppRegistryOp[DisassociateAttributeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateAttributeGroupResponse] =
        visitor.disassociateAttributeGroup(request)
    }

    final case class DisassociateResourceOp(
      request: DisassociateResourceRequest
    ) extends ServiceCatalogAppRegistryOp[DisassociateResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateResourceResponse] =
        visitor.disassociateResource(request)
    }

    final case class GetApplicationOp(
      request: GetApplicationRequest
    ) extends ServiceCatalogAppRegistryOp[GetApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationResponse] =
        visitor.getApplication(request)
    }

    final case class GetAttributeGroupOp(
      request: GetAttributeGroupRequest
    ) extends ServiceCatalogAppRegistryOp[GetAttributeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAttributeGroupResponse] =
        visitor.getAttributeGroup(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends ServiceCatalogAppRegistryOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListAssociatedAttributeGroupsOp(
      request: ListAssociatedAttributeGroupsRequest
    ) extends ServiceCatalogAppRegistryOp[ListAssociatedAttributeGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociatedAttributeGroupsResponse] =
        visitor.listAssociatedAttributeGroups(request)
    }

    final case class ListAssociatedResourcesOp(
      request: ListAssociatedResourcesRequest
    ) extends ServiceCatalogAppRegistryOp[ListAssociatedResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociatedResourcesResponse] =
        visitor.listAssociatedResources(request)
    }

    final case class ListAttributeGroupsOp(
      request: ListAttributeGroupsRequest
    ) extends ServiceCatalogAppRegistryOp[ListAttributeGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttributeGroupsResponse] =
        visitor.listAttributeGroups(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ServiceCatalogAppRegistryOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class SyncResourceOp(
      request: SyncResourceRequest
    ) extends ServiceCatalogAppRegistryOp[SyncResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SyncResourceResponse] =
        visitor.syncResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ServiceCatalogAppRegistryOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ServiceCatalogAppRegistryOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends ServiceCatalogAppRegistryOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }

    final case class UpdateAttributeGroupOp(
      request: UpdateAttributeGroupRequest
    ) extends ServiceCatalogAppRegistryOp[UpdateAttributeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAttributeGroupResponse] =
        visitor.updateAttributeGroup(request)
    }
  }

  import ServiceCatalogAppRegistryOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ServiceCatalogAppRegistryOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateAttributeGroup(
    request: AssociateAttributeGroupRequest
  ): ServiceCatalogAppRegistryIO[AssociateAttributeGroupResponse] =
    FF.liftF(AssociateAttributeGroupOp(request))

  def associateResource(
    request: AssociateResourceRequest
  ): ServiceCatalogAppRegistryIO[AssociateResourceResponse] =
    FF.liftF(AssociateResourceOp(request))

  def createApplication(
    request: CreateApplicationRequest
  ): ServiceCatalogAppRegistryIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createAttributeGroup(
    request: CreateAttributeGroupRequest
  ): ServiceCatalogAppRegistryIO[CreateAttributeGroupResponse] =
    FF.liftF(CreateAttributeGroupOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): ServiceCatalogAppRegistryIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteAttributeGroup(
    request: DeleteAttributeGroupRequest
  ): ServiceCatalogAppRegistryIO[DeleteAttributeGroupResponse] =
    FF.liftF(DeleteAttributeGroupOp(request))

  def disassociateAttributeGroup(
    request: DisassociateAttributeGroupRequest
  ): ServiceCatalogAppRegistryIO[DisassociateAttributeGroupResponse] =
    FF.liftF(DisassociateAttributeGroupOp(request))

  def disassociateResource(
    request: DisassociateResourceRequest
  ): ServiceCatalogAppRegistryIO[DisassociateResourceResponse] =
    FF.liftF(DisassociateResourceOp(request))

  def getApplication(
    request: GetApplicationRequest
  ): ServiceCatalogAppRegistryIO[GetApplicationResponse] =
    FF.liftF(GetApplicationOp(request))

  def getAttributeGroup(
    request: GetAttributeGroupRequest
  ): ServiceCatalogAppRegistryIO[GetAttributeGroupResponse] =
    FF.liftF(GetAttributeGroupOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): ServiceCatalogAppRegistryIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listAssociatedAttributeGroups(
    request: ListAssociatedAttributeGroupsRequest
  ): ServiceCatalogAppRegistryIO[ListAssociatedAttributeGroupsResponse] =
    FF.liftF(ListAssociatedAttributeGroupsOp(request))

  def listAssociatedResources(
    request: ListAssociatedResourcesRequest
  ): ServiceCatalogAppRegistryIO[ListAssociatedResourcesResponse] =
    FF.liftF(ListAssociatedResourcesOp(request))

  def listAttributeGroups(
    request: ListAttributeGroupsRequest
  ): ServiceCatalogAppRegistryIO[ListAttributeGroupsResponse] =
    FF.liftF(ListAttributeGroupsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ServiceCatalogAppRegistryIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def syncResource(
    request: SyncResourceRequest
  ): ServiceCatalogAppRegistryIO[SyncResourceResponse] =
    FF.liftF(SyncResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ServiceCatalogAppRegistryIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ServiceCatalogAppRegistryIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): ServiceCatalogAppRegistryIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))

  def updateAttributeGroup(
    request: UpdateAttributeGroupRequest
  ): ServiceCatalogAppRegistryIO[UpdateAttributeGroupResponse] =
    FF.liftF(UpdateAttributeGroupOp(request))
}
