package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iot1clickprojects.Iot1ClickProjectsClient
import software.amazon.awssdk.services.iot1clickprojects.model._


object iot1clickprojects { module =>

  // Free monad over Iot1ClickProjectsOp
  type Iot1ClickProjectsIO[A] = FF[Iot1ClickProjectsOp, A]

  sealed trait Iot1ClickProjectsOp[A] {
    def visit[F[_]](visitor: Iot1ClickProjectsOp.Visitor[F]): F[A]
  }

  object Iot1ClickProjectsOp {
    // Given a Iot1ClickProjectsClient we can embed a Iot1ClickProjectsIO program in any algebra that understands embedding.
    implicit val Iot1ClickProjectsOpEmbeddable: Embeddable[Iot1ClickProjectsOp, Iot1ClickProjectsClient] = new Embeddable[Iot1ClickProjectsOp, Iot1ClickProjectsClient] {
      def embed[A](client: Iot1ClickProjectsClient, io: Iot1ClickProjectsIO[A]): Embedded[A] = Embedded.Iot1ClickProjects(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends Iot1ClickProjectsOp.Visitor[Kleisli[M, Iot1ClickProjectsClient, *]] {
        def associateDeviceWithPlacement(
          request: AssociateDeviceWithPlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, AssociateDeviceWithPlacementResponse] =
          primitive(_.associateDeviceWithPlacement(request))

        def createPlacement(
          request: CreatePlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, CreatePlacementResponse] =
          primitive(_.createPlacement(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, Iot1ClickProjectsClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def deletePlacement(
          request: DeletePlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, DeletePlacementResponse] =
          primitive(_.deletePlacement(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, Iot1ClickProjectsClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def describePlacement(
          request: DescribePlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, DescribePlacementResponse] =
          primitive(_.describePlacement(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, Iot1ClickProjectsClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def disassociateDeviceFromPlacement(
          request: DisassociateDeviceFromPlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, DisassociateDeviceFromPlacementResponse] =
          primitive(_.disassociateDeviceFromPlacement(request))

        def getDevicesInPlacement(
          request: GetDevicesInPlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, GetDevicesInPlacementResponse] =
          primitive(_.getDevicesInPlacement(request))

        def listPlacements(
          request: ListPlacementsRequest
        ): Kleisli[M, Iot1ClickProjectsClient, ListPlacementsResponse] =
          primitive(_.listPlacements(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, Iot1ClickProjectsClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, Iot1ClickProjectsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, Iot1ClickProjectsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, Iot1ClickProjectsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updatePlacement(
          request: UpdatePlacementRequest
        ): Kleisli[M, Iot1ClickProjectsClient, UpdatePlacementResponse] =
          primitive(_.updatePlacement(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, Iot1ClickProjectsClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def primitive[A](
          f: Iot1ClickProjectsClient => A
        ): Kleisli[M, Iot1ClickProjectsClient, A]
      }
    }

    trait Visitor[F[_]] extends (Iot1ClickProjectsOp ~> F) {
      final def apply[A](op: Iot1ClickProjectsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateDeviceWithPlacement(
        request: AssociateDeviceWithPlacementRequest
      ): F[AssociateDeviceWithPlacementResponse]

      def createPlacement(
        request: CreatePlacementRequest
      ): F[CreatePlacementResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def deletePlacement(
        request: DeletePlacementRequest
      ): F[DeletePlacementResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def describePlacement(
        request: DescribePlacementRequest
      ): F[DescribePlacementResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def disassociateDeviceFromPlacement(
        request: DisassociateDeviceFromPlacementRequest
      ): F[DisassociateDeviceFromPlacementResponse]

      def getDevicesInPlacement(
        request: GetDevicesInPlacementRequest
      ): F[GetDevicesInPlacementResponse]

      def listPlacements(
        request: ListPlacementsRequest
      ): F[ListPlacementsResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updatePlacement(
        request: UpdatePlacementRequest
      ): F[UpdatePlacementResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends Iot1ClickProjectsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateDeviceWithPlacementOp(
      request: AssociateDeviceWithPlacementRequest
    ) extends Iot1ClickProjectsOp[AssociateDeviceWithPlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDeviceWithPlacementResponse] =
        visitor.associateDeviceWithPlacement(request)
    }

    final case class CreatePlacementOp(
      request: CreatePlacementRequest
    ) extends Iot1ClickProjectsOp[CreatePlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlacementResponse] =
        visitor.createPlacement(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends Iot1ClickProjectsOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class DeletePlacementOp(
      request: DeletePlacementRequest
    ) extends Iot1ClickProjectsOp[DeletePlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlacementResponse] =
        visitor.deletePlacement(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends Iot1ClickProjectsOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DescribePlacementOp(
      request: DescribePlacementRequest
    ) extends Iot1ClickProjectsOp[DescribePlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePlacementResponse] =
        visitor.describePlacement(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends Iot1ClickProjectsOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class DisassociateDeviceFromPlacementOp(
      request: DisassociateDeviceFromPlacementRequest
    ) extends Iot1ClickProjectsOp[DisassociateDeviceFromPlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDeviceFromPlacementResponse] =
        visitor.disassociateDeviceFromPlacement(request)
    }

    final case class GetDevicesInPlacementOp(
      request: GetDevicesInPlacementRequest
    ) extends Iot1ClickProjectsOp[GetDevicesInPlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevicesInPlacementResponse] =
        visitor.getDevicesInPlacement(request)
    }

    final case class ListPlacementsOp(
      request: ListPlacementsRequest
    ) extends Iot1ClickProjectsOp[ListPlacementsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlacementsResponse] =
        visitor.listPlacements(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends Iot1ClickProjectsOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends Iot1ClickProjectsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends Iot1ClickProjectsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends Iot1ClickProjectsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdatePlacementOp(
      request: UpdatePlacementRequest
    ) extends Iot1ClickProjectsOp[UpdatePlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePlacementResponse] =
        visitor.updatePlacement(request)
    }

    final case class UpdateProjectOp(
      request: UpdateProjectRequest
    ) extends Iot1ClickProjectsOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }
  }

  import Iot1ClickProjectsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[Iot1ClickProjectsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateDeviceWithPlacement(
    request: AssociateDeviceWithPlacementRequest
  ): Iot1ClickProjectsIO[AssociateDeviceWithPlacementResponse] =
    FF.liftF(AssociateDeviceWithPlacementOp(request))

  def createPlacement(
    request: CreatePlacementRequest
  ): Iot1ClickProjectsIO[CreatePlacementResponse] =
    FF.liftF(CreatePlacementOp(request))

  def createProject(
    request: CreateProjectRequest
  ): Iot1ClickProjectsIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def deletePlacement(
    request: DeletePlacementRequest
  ): Iot1ClickProjectsIO[DeletePlacementResponse] =
    FF.liftF(DeletePlacementOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): Iot1ClickProjectsIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def describePlacement(
    request: DescribePlacementRequest
  ): Iot1ClickProjectsIO[DescribePlacementResponse] =
    FF.liftF(DescribePlacementOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): Iot1ClickProjectsIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def disassociateDeviceFromPlacement(
    request: DisassociateDeviceFromPlacementRequest
  ): Iot1ClickProjectsIO[DisassociateDeviceFromPlacementResponse] =
    FF.liftF(DisassociateDeviceFromPlacementOp(request))

  def getDevicesInPlacement(
    request: GetDevicesInPlacementRequest
  ): Iot1ClickProjectsIO[GetDevicesInPlacementResponse] =
    FF.liftF(GetDevicesInPlacementOp(request))

  def listPlacements(
    request: ListPlacementsRequest
  ): Iot1ClickProjectsIO[ListPlacementsResponse] =
    FF.liftF(ListPlacementsOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): Iot1ClickProjectsIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): Iot1ClickProjectsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): Iot1ClickProjectsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): Iot1ClickProjectsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updatePlacement(
    request: UpdatePlacementRequest
  ): Iot1ClickProjectsIO[UpdatePlacementResponse] =
    FF.liftF(UpdatePlacementOp(request))

  def updateProject(
    request: UpdateProjectRequest
  ): Iot1ClickProjectsIO[UpdateProjectResponse] =
    FF.liftF(UpdateProjectOp(request))
}
