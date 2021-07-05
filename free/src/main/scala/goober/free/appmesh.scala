package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.appmesh.AppMeshClient
import software.amazon.awssdk.services.appmesh.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object appmesh { module =>

  // Free monad over AppMeshOp
  type AppMeshIO[A] = FF[AppMeshOp, A]

  sealed trait AppMeshOp[A] {
    def visit[F[_]](visitor: AppMeshOp.Visitor[F]): F[A]
  }

  object AppMeshOp {
    // Given a AppMeshClient we can embed a AppMeshIO program in any algebra that understands embedding.
    implicit val AppMeshOpEmbeddable: Embeddable[AppMeshOp, AppMeshClient] = new Embeddable[AppMeshOp, AppMeshClient] {
      def embed[A](client: AppMeshClient, io: AppMeshIO[A]): Embedded[A] = Embedded.AppMesh(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AppMeshOp.Visitor[Kleisli[M, AppMeshClient, *]] {
        def createGatewayRoute(
          request: CreateGatewayRouteRequest
        ): Kleisli[M, AppMeshClient, CreateGatewayRouteResponse] =
          primitive(_.createGatewayRoute(request))

        def createMesh(
          request: CreateMeshRequest
        ): Kleisli[M, AppMeshClient, CreateMeshResponse] =
          primitive(_.createMesh(request))

        def createRoute(
          request: CreateRouteRequest
        ): Kleisli[M, AppMeshClient, CreateRouteResponse] =
          primitive(_.createRoute(request))

        def createVirtualGateway(
          request: CreateVirtualGatewayRequest
        ): Kleisli[M, AppMeshClient, CreateVirtualGatewayResponse] =
          primitive(_.createVirtualGateway(request))

        def createVirtualNode(
          request: CreateVirtualNodeRequest
        ): Kleisli[M, AppMeshClient, CreateVirtualNodeResponse] =
          primitive(_.createVirtualNode(request))

        def createVirtualRouter(
          request: CreateVirtualRouterRequest
        ): Kleisli[M, AppMeshClient, CreateVirtualRouterResponse] =
          primitive(_.createVirtualRouter(request))

        def createVirtualService(
          request: CreateVirtualServiceRequest
        ): Kleisli[M, AppMeshClient, CreateVirtualServiceResponse] =
          primitive(_.createVirtualService(request))

        def deleteGatewayRoute(
          request: DeleteGatewayRouteRequest
        ): Kleisli[M, AppMeshClient, DeleteGatewayRouteResponse] =
          primitive(_.deleteGatewayRoute(request))

        def deleteMesh(
          request: DeleteMeshRequest
        ): Kleisli[M, AppMeshClient, DeleteMeshResponse] =
          primitive(_.deleteMesh(request))

        def deleteRoute(
          request: DeleteRouteRequest
        ): Kleisli[M, AppMeshClient, DeleteRouteResponse] =
          primitive(_.deleteRoute(request))

        def deleteVirtualGateway(
          request: DeleteVirtualGatewayRequest
        ): Kleisli[M, AppMeshClient, DeleteVirtualGatewayResponse] =
          primitive(_.deleteVirtualGateway(request))

        def deleteVirtualNode(
          request: DeleteVirtualNodeRequest
        ): Kleisli[M, AppMeshClient, DeleteVirtualNodeResponse] =
          primitive(_.deleteVirtualNode(request))

        def deleteVirtualRouter(
          request: DeleteVirtualRouterRequest
        ): Kleisli[M, AppMeshClient, DeleteVirtualRouterResponse] =
          primitive(_.deleteVirtualRouter(request))

        def deleteVirtualService(
          request: DeleteVirtualServiceRequest
        ): Kleisli[M, AppMeshClient, DeleteVirtualServiceResponse] =
          primitive(_.deleteVirtualService(request))

        def describeGatewayRoute(
          request: DescribeGatewayRouteRequest
        ): Kleisli[M, AppMeshClient, DescribeGatewayRouteResponse] =
          primitive(_.describeGatewayRoute(request))

        def describeMesh(
          request: DescribeMeshRequest
        ): Kleisli[M, AppMeshClient, DescribeMeshResponse] =
          primitive(_.describeMesh(request))

        def describeRoute(
          request: DescribeRouteRequest
        ): Kleisli[M, AppMeshClient, DescribeRouteResponse] =
          primitive(_.describeRoute(request))

        def describeVirtualGateway(
          request: DescribeVirtualGatewayRequest
        ): Kleisli[M, AppMeshClient, DescribeVirtualGatewayResponse] =
          primitive(_.describeVirtualGateway(request))

        def describeVirtualNode(
          request: DescribeVirtualNodeRequest
        ): Kleisli[M, AppMeshClient, DescribeVirtualNodeResponse] =
          primitive(_.describeVirtualNode(request))

        def describeVirtualRouter(
          request: DescribeVirtualRouterRequest
        ): Kleisli[M, AppMeshClient, DescribeVirtualRouterResponse] =
          primitive(_.describeVirtualRouter(request))

        def describeVirtualService(
          request: DescribeVirtualServiceRequest
        ): Kleisli[M, AppMeshClient, DescribeVirtualServiceResponse] =
          primitive(_.describeVirtualService(request))

        def listGatewayRoutes(
          request: ListGatewayRoutesRequest
        ): Kleisli[M, AppMeshClient, ListGatewayRoutesResponse] =
          primitive(_.listGatewayRoutes(request))

        def listMeshes(
          request: ListMeshesRequest
        ): Kleisli[M, AppMeshClient, ListMeshesResponse] =
          primitive(_.listMeshes(request))

        def listRoutes(
          request: ListRoutesRequest
        ): Kleisli[M, AppMeshClient, ListRoutesResponse] =
          primitive(_.listRoutes(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, AppMeshClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listVirtualGateways(
          request: ListVirtualGatewaysRequest
        ): Kleisli[M, AppMeshClient, ListVirtualGatewaysResponse] =
          primitive(_.listVirtualGateways(request))

        def listVirtualNodes(
          request: ListVirtualNodesRequest
        ): Kleisli[M, AppMeshClient, ListVirtualNodesResponse] =
          primitive(_.listVirtualNodes(request))

        def listVirtualRouters(
          request: ListVirtualRoutersRequest
        ): Kleisli[M, AppMeshClient, ListVirtualRoutersResponse] =
          primitive(_.listVirtualRouters(request))

        def listVirtualServices(
          request: ListVirtualServicesRequest
        ): Kleisli[M, AppMeshClient, ListVirtualServicesResponse] =
          primitive(_.listVirtualServices(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AppMeshClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AppMeshClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateGatewayRoute(
          request: UpdateGatewayRouteRequest
        ): Kleisli[M, AppMeshClient, UpdateGatewayRouteResponse] =
          primitive(_.updateGatewayRoute(request))

        def updateMesh(
          request: UpdateMeshRequest
        ): Kleisli[M, AppMeshClient, UpdateMeshResponse] =
          primitive(_.updateMesh(request))

        def updateRoute(
          request: UpdateRouteRequest
        ): Kleisli[M, AppMeshClient, UpdateRouteResponse] =
          primitive(_.updateRoute(request))

        def updateVirtualGateway(
          request: UpdateVirtualGatewayRequest
        ): Kleisli[M, AppMeshClient, UpdateVirtualGatewayResponse] =
          primitive(_.updateVirtualGateway(request))

        def updateVirtualNode(
          request: UpdateVirtualNodeRequest
        ): Kleisli[M, AppMeshClient, UpdateVirtualNodeResponse] =
          primitive(_.updateVirtualNode(request))

        def updateVirtualRouter(
          request: UpdateVirtualRouterRequest
        ): Kleisli[M, AppMeshClient, UpdateVirtualRouterResponse] =
          primitive(_.updateVirtualRouter(request))

        def updateVirtualService(
          request: UpdateVirtualServiceRequest
        ): Kleisli[M, AppMeshClient, UpdateVirtualServiceResponse] =
          primitive(_.updateVirtualService(request))

        def primitive[A](
          f: AppMeshClient => A
        ): Kleisli[M, AppMeshClient, A]
      }
    }

    trait Visitor[F[_]] extends (AppMeshOp ~> F) {
      final def apply[A](op: AppMeshOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createGatewayRoute(
        request: CreateGatewayRouteRequest
      ): F[CreateGatewayRouteResponse]

      def createMesh(
        request: CreateMeshRequest
      ): F[CreateMeshResponse]

      def createRoute(
        request: CreateRouteRequest
      ): F[CreateRouteResponse]

      def createVirtualGateway(
        request: CreateVirtualGatewayRequest
      ): F[CreateVirtualGatewayResponse]

      def createVirtualNode(
        request: CreateVirtualNodeRequest
      ): F[CreateVirtualNodeResponse]

      def createVirtualRouter(
        request: CreateVirtualRouterRequest
      ): F[CreateVirtualRouterResponse]

      def createVirtualService(
        request: CreateVirtualServiceRequest
      ): F[CreateVirtualServiceResponse]

      def deleteGatewayRoute(
        request: DeleteGatewayRouteRequest
      ): F[DeleteGatewayRouteResponse]

      def deleteMesh(
        request: DeleteMeshRequest
      ): F[DeleteMeshResponse]

      def deleteRoute(
        request: DeleteRouteRequest
      ): F[DeleteRouteResponse]

      def deleteVirtualGateway(
        request: DeleteVirtualGatewayRequest
      ): F[DeleteVirtualGatewayResponse]

      def deleteVirtualNode(
        request: DeleteVirtualNodeRequest
      ): F[DeleteVirtualNodeResponse]

      def deleteVirtualRouter(
        request: DeleteVirtualRouterRequest
      ): F[DeleteVirtualRouterResponse]

      def deleteVirtualService(
        request: DeleteVirtualServiceRequest
      ): F[DeleteVirtualServiceResponse]

      def describeGatewayRoute(
        request: DescribeGatewayRouteRequest
      ): F[DescribeGatewayRouteResponse]

      def describeMesh(
        request: DescribeMeshRequest
      ): F[DescribeMeshResponse]

      def describeRoute(
        request: DescribeRouteRequest
      ): F[DescribeRouteResponse]

      def describeVirtualGateway(
        request: DescribeVirtualGatewayRequest
      ): F[DescribeVirtualGatewayResponse]

      def describeVirtualNode(
        request: DescribeVirtualNodeRequest
      ): F[DescribeVirtualNodeResponse]

      def describeVirtualRouter(
        request: DescribeVirtualRouterRequest
      ): F[DescribeVirtualRouterResponse]

      def describeVirtualService(
        request: DescribeVirtualServiceRequest
      ): F[DescribeVirtualServiceResponse]

      def listGatewayRoutes(
        request: ListGatewayRoutesRequest
      ): F[ListGatewayRoutesResponse]

      def listMeshes(
        request: ListMeshesRequest
      ): F[ListMeshesResponse]

      def listRoutes(
        request: ListRoutesRequest
      ): F[ListRoutesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listVirtualGateways(
        request: ListVirtualGatewaysRequest
      ): F[ListVirtualGatewaysResponse]

      def listVirtualNodes(
        request: ListVirtualNodesRequest
      ): F[ListVirtualNodesResponse]

      def listVirtualRouters(
        request: ListVirtualRoutersRequest
      ): F[ListVirtualRoutersResponse]

      def listVirtualServices(
        request: ListVirtualServicesRequest
      ): F[ListVirtualServicesResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateGatewayRoute(
        request: UpdateGatewayRouteRequest
      ): F[UpdateGatewayRouteResponse]

      def updateMesh(
        request: UpdateMeshRequest
      ): F[UpdateMeshResponse]

      def updateRoute(
        request: UpdateRouteRequest
      ): F[UpdateRouteResponse]

      def updateVirtualGateway(
        request: UpdateVirtualGatewayRequest
      ): F[UpdateVirtualGatewayResponse]

      def updateVirtualNode(
        request: UpdateVirtualNodeRequest
      ): F[UpdateVirtualNodeResponse]

      def updateVirtualRouter(
        request: UpdateVirtualRouterRequest
      ): F[UpdateVirtualRouterResponse]

      def updateVirtualService(
        request: UpdateVirtualServiceRequest
      ): F[UpdateVirtualServiceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AppMeshOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateGatewayRouteOp(
      request: CreateGatewayRouteRequest
    ) extends AppMeshOp[CreateGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGatewayRouteResponse] =
        visitor.createGatewayRoute(request)
    }

    final case class CreateMeshOp(
      request: CreateMeshRequest
    ) extends AppMeshOp[CreateMeshResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMeshResponse] =
        visitor.createMesh(request)
    }

    final case class CreateRouteOp(
      request: CreateRouteRequest
    ) extends AppMeshOp[CreateRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRouteResponse] =
        visitor.createRoute(request)
    }

    final case class CreateVirtualGatewayOp(
      request: CreateVirtualGatewayRequest
    ) extends AppMeshOp[CreateVirtualGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVirtualGatewayResponse] =
        visitor.createVirtualGateway(request)
    }

    final case class CreateVirtualNodeOp(
      request: CreateVirtualNodeRequest
    ) extends AppMeshOp[CreateVirtualNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVirtualNodeResponse] =
        visitor.createVirtualNode(request)
    }

    final case class CreateVirtualRouterOp(
      request: CreateVirtualRouterRequest
    ) extends AppMeshOp[CreateVirtualRouterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVirtualRouterResponse] =
        visitor.createVirtualRouter(request)
    }

    final case class CreateVirtualServiceOp(
      request: CreateVirtualServiceRequest
    ) extends AppMeshOp[CreateVirtualServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVirtualServiceResponse] =
        visitor.createVirtualService(request)
    }

    final case class DeleteGatewayRouteOp(
      request: DeleteGatewayRouteRequest
    ) extends AppMeshOp[DeleteGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGatewayRouteResponse] =
        visitor.deleteGatewayRoute(request)
    }

    final case class DeleteMeshOp(
      request: DeleteMeshRequest
    ) extends AppMeshOp[DeleteMeshResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMeshResponse] =
        visitor.deleteMesh(request)
    }

    final case class DeleteRouteOp(
      request: DeleteRouteRequest
    ) extends AppMeshOp[DeleteRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteResponse] =
        visitor.deleteRoute(request)
    }

    final case class DeleteVirtualGatewayOp(
      request: DeleteVirtualGatewayRequest
    ) extends AppMeshOp[DeleteVirtualGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualGatewayResponse] =
        visitor.deleteVirtualGateway(request)
    }

    final case class DeleteVirtualNodeOp(
      request: DeleteVirtualNodeRequest
    ) extends AppMeshOp[DeleteVirtualNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualNodeResponse] =
        visitor.deleteVirtualNode(request)
    }

    final case class DeleteVirtualRouterOp(
      request: DeleteVirtualRouterRequest
    ) extends AppMeshOp[DeleteVirtualRouterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualRouterResponse] =
        visitor.deleteVirtualRouter(request)
    }

    final case class DeleteVirtualServiceOp(
      request: DeleteVirtualServiceRequest
    ) extends AppMeshOp[DeleteVirtualServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualServiceResponse] =
        visitor.deleteVirtualService(request)
    }

    final case class DescribeGatewayRouteOp(
      request: DescribeGatewayRouteRequest
    ) extends AppMeshOp[DescribeGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGatewayRouteResponse] =
        visitor.describeGatewayRoute(request)
    }

    final case class DescribeMeshOp(
      request: DescribeMeshRequest
    ) extends AppMeshOp[DescribeMeshResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMeshResponse] =
        visitor.describeMesh(request)
    }

    final case class DescribeRouteOp(
      request: DescribeRouteRequest
    ) extends AppMeshOp[DescribeRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRouteResponse] =
        visitor.describeRoute(request)
    }

    final case class DescribeVirtualGatewayOp(
      request: DescribeVirtualGatewayRequest
    ) extends AppMeshOp[DescribeVirtualGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualGatewayResponse] =
        visitor.describeVirtualGateway(request)
    }

    final case class DescribeVirtualNodeOp(
      request: DescribeVirtualNodeRequest
    ) extends AppMeshOp[DescribeVirtualNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualNodeResponse] =
        visitor.describeVirtualNode(request)
    }

    final case class DescribeVirtualRouterOp(
      request: DescribeVirtualRouterRequest
    ) extends AppMeshOp[DescribeVirtualRouterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualRouterResponse] =
        visitor.describeVirtualRouter(request)
    }

    final case class DescribeVirtualServiceOp(
      request: DescribeVirtualServiceRequest
    ) extends AppMeshOp[DescribeVirtualServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualServiceResponse] =
        visitor.describeVirtualService(request)
    }

    final case class ListGatewayRoutesOp(
      request: ListGatewayRoutesRequest
    ) extends AppMeshOp[ListGatewayRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGatewayRoutesResponse] =
        visitor.listGatewayRoutes(request)
    }

    final case class ListMeshesOp(
      request: ListMeshesRequest
    ) extends AppMeshOp[ListMeshesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMeshesResponse] =
        visitor.listMeshes(request)
    }

    final case class ListRoutesOp(
      request: ListRoutesRequest
    ) extends AppMeshOp[ListRoutesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoutesResponse] =
        visitor.listRoutes(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends AppMeshOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListVirtualGatewaysOp(
      request: ListVirtualGatewaysRequest
    ) extends AppMeshOp[ListVirtualGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualGatewaysResponse] =
        visitor.listVirtualGateways(request)
    }

    final case class ListVirtualNodesOp(
      request: ListVirtualNodesRequest
    ) extends AppMeshOp[ListVirtualNodesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualNodesResponse] =
        visitor.listVirtualNodes(request)
    }

    final case class ListVirtualRoutersOp(
      request: ListVirtualRoutersRequest
    ) extends AppMeshOp[ListVirtualRoutersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualRoutersResponse] =
        visitor.listVirtualRouters(request)
    }

    final case class ListVirtualServicesOp(
      request: ListVirtualServicesRequest
    ) extends AppMeshOp[ListVirtualServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualServicesResponse] =
        visitor.listVirtualServices(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AppMeshOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AppMeshOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateGatewayRouteOp(
      request: UpdateGatewayRouteRequest
    ) extends AppMeshOp[UpdateGatewayRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayRouteResponse] =
        visitor.updateGatewayRoute(request)
    }

    final case class UpdateMeshOp(
      request: UpdateMeshRequest
    ) extends AppMeshOp[UpdateMeshResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMeshResponse] =
        visitor.updateMesh(request)
    }

    final case class UpdateRouteOp(
      request: UpdateRouteRequest
    ) extends AppMeshOp[UpdateRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRouteResponse] =
        visitor.updateRoute(request)
    }

    final case class UpdateVirtualGatewayOp(
      request: UpdateVirtualGatewayRequest
    ) extends AppMeshOp[UpdateVirtualGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVirtualGatewayResponse] =
        visitor.updateVirtualGateway(request)
    }

    final case class UpdateVirtualNodeOp(
      request: UpdateVirtualNodeRequest
    ) extends AppMeshOp[UpdateVirtualNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVirtualNodeResponse] =
        visitor.updateVirtualNode(request)
    }

    final case class UpdateVirtualRouterOp(
      request: UpdateVirtualRouterRequest
    ) extends AppMeshOp[UpdateVirtualRouterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVirtualRouterResponse] =
        visitor.updateVirtualRouter(request)
    }

    final case class UpdateVirtualServiceOp(
      request: UpdateVirtualServiceRequest
    ) extends AppMeshOp[UpdateVirtualServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVirtualServiceResponse] =
        visitor.updateVirtualService(request)
    }
  }

  import AppMeshOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AppMeshOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createGatewayRoute(
    request: CreateGatewayRouteRequest
  ): AppMeshIO[CreateGatewayRouteResponse] =
    FF.liftF(CreateGatewayRouteOp(request))

  def createMesh(
    request: CreateMeshRequest
  ): AppMeshIO[CreateMeshResponse] =
    FF.liftF(CreateMeshOp(request))

  def createRoute(
    request: CreateRouteRequest
  ): AppMeshIO[CreateRouteResponse] =
    FF.liftF(CreateRouteOp(request))

  def createVirtualGateway(
    request: CreateVirtualGatewayRequest
  ): AppMeshIO[CreateVirtualGatewayResponse] =
    FF.liftF(CreateVirtualGatewayOp(request))

  def createVirtualNode(
    request: CreateVirtualNodeRequest
  ): AppMeshIO[CreateVirtualNodeResponse] =
    FF.liftF(CreateVirtualNodeOp(request))

  def createVirtualRouter(
    request: CreateVirtualRouterRequest
  ): AppMeshIO[CreateVirtualRouterResponse] =
    FF.liftF(CreateVirtualRouterOp(request))

  def createVirtualService(
    request: CreateVirtualServiceRequest
  ): AppMeshIO[CreateVirtualServiceResponse] =
    FF.liftF(CreateVirtualServiceOp(request))

  def deleteGatewayRoute(
    request: DeleteGatewayRouteRequest
  ): AppMeshIO[DeleteGatewayRouteResponse] =
    FF.liftF(DeleteGatewayRouteOp(request))

  def deleteMesh(
    request: DeleteMeshRequest
  ): AppMeshIO[DeleteMeshResponse] =
    FF.liftF(DeleteMeshOp(request))

  def deleteRoute(
    request: DeleteRouteRequest
  ): AppMeshIO[DeleteRouteResponse] =
    FF.liftF(DeleteRouteOp(request))

  def deleteVirtualGateway(
    request: DeleteVirtualGatewayRequest
  ): AppMeshIO[DeleteVirtualGatewayResponse] =
    FF.liftF(DeleteVirtualGatewayOp(request))

  def deleteVirtualNode(
    request: DeleteVirtualNodeRequest
  ): AppMeshIO[DeleteVirtualNodeResponse] =
    FF.liftF(DeleteVirtualNodeOp(request))

  def deleteVirtualRouter(
    request: DeleteVirtualRouterRequest
  ): AppMeshIO[DeleteVirtualRouterResponse] =
    FF.liftF(DeleteVirtualRouterOp(request))

  def deleteVirtualService(
    request: DeleteVirtualServiceRequest
  ): AppMeshIO[DeleteVirtualServiceResponse] =
    FF.liftF(DeleteVirtualServiceOp(request))

  def describeGatewayRoute(
    request: DescribeGatewayRouteRequest
  ): AppMeshIO[DescribeGatewayRouteResponse] =
    FF.liftF(DescribeGatewayRouteOp(request))

  def describeMesh(
    request: DescribeMeshRequest
  ): AppMeshIO[DescribeMeshResponse] =
    FF.liftF(DescribeMeshOp(request))

  def describeRoute(
    request: DescribeRouteRequest
  ): AppMeshIO[DescribeRouteResponse] =
    FF.liftF(DescribeRouteOp(request))

  def describeVirtualGateway(
    request: DescribeVirtualGatewayRequest
  ): AppMeshIO[DescribeVirtualGatewayResponse] =
    FF.liftF(DescribeVirtualGatewayOp(request))

  def describeVirtualNode(
    request: DescribeVirtualNodeRequest
  ): AppMeshIO[DescribeVirtualNodeResponse] =
    FF.liftF(DescribeVirtualNodeOp(request))

  def describeVirtualRouter(
    request: DescribeVirtualRouterRequest
  ): AppMeshIO[DescribeVirtualRouterResponse] =
    FF.liftF(DescribeVirtualRouterOp(request))

  def describeVirtualService(
    request: DescribeVirtualServiceRequest
  ): AppMeshIO[DescribeVirtualServiceResponse] =
    FF.liftF(DescribeVirtualServiceOp(request))

  def listGatewayRoutes(
    request: ListGatewayRoutesRequest
  ): AppMeshIO[ListGatewayRoutesResponse] =
    FF.liftF(ListGatewayRoutesOp(request))

  def listMeshes(
    request: ListMeshesRequest
  ): AppMeshIO[ListMeshesResponse] =
    FF.liftF(ListMeshesOp(request))

  def listRoutes(
    request: ListRoutesRequest
  ): AppMeshIO[ListRoutesResponse] =
    FF.liftF(ListRoutesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): AppMeshIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listVirtualGateways(
    request: ListVirtualGatewaysRequest
  ): AppMeshIO[ListVirtualGatewaysResponse] =
    FF.liftF(ListVirtualGatewaysOp(request))

  def listVirtualNodes(
    request: ListVirtualNodesRequest
  ): AppMeshIO[ListVirtualNodesResponse] =
    FF.liftF(ListVirtualNodesOp(request))

  def listVirtualRouters(
    request: ListVirtualRoutersRequest
  ): AppMeshIO[ListVirtualRoutersResponse] =
    FF.liftF(ListVirtualRoutersOp(request))

  def listVirtualServices(
    request: ListVirtualServicesRequest
  ): AppMeshIO[ListVirtualServicesResponse] =
    FF.liftF(ListVirtualServicesOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AppMeshIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AppMeshIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateGatewayRoute(
    request: UpdateGatewayRouteRequest
  ): AppMeshIO[UpdateGatewayRouteResponse] =
    FF.liftF(UpdateGatewayRouteOp(request))

  def updateMesh(
    request: UpdateMeshRequest
  ): AppMeshIO[UpdateMeshResponse] =
    FF.liftF(UpdateMeshOp(request))

  def updateRoute(
    request: UpdateRouteRequest
  ): AppMeshIO[UpdateRouteResponse] =
    FF.liftF(UpdateRouteOp(request))

  def updateVirtualGateway(
    request: UpdateVirtualGatewayRequest
  ): AppMeshIO[UpdateVirtualGatewayResponse] =
    FF.liftF(UpdateVirtualGatewayOp(request))

  def updateVirtualNode(
    request: UpdateVirtualNodeRequest
  ): AppMeshIO[UpdateVirtualNodeResponse] =
    FF.liftF(UpdateVirtualNodeOp(request))

  def updateVirtualRouter(
    request: UpdateVirtualRouterRequest
  ): AppMeshIO[UpdateVirtualRouterResponse] =
    FF.liftF(UpdateVirtualRouterOp(request))

  def updateVirtualService(
    request: UpdateVirtualServiceRequest
  ): AppMeshIO[UpdateVirtualServiceResponse] =
    FF.liftF(UpdateVirtualServiceOp(request))
}
