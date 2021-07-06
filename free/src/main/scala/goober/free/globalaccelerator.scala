package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.globalaccelerator.GlobalAcceleratorClient
import software.amazon.awssdk.services.globalaccelerator.model._


object globalaccelerator { module =>

  // Free monad over GlobalAcceleratorOp
  type GlobalAcceleratorIO[A] = FF[GlobalAcceleratorOp, A]

  sealed trait GlobalAcceleratorOp[A] {
    def visit[F[_]](visitor: GlobalAcceleratorOp.Visitor[F]): F[A]
  }

  object GlobalAcceleratorOp {
    // Given a GlobalAcceleratorClient we can embed a GlobalAcceleratorIO program in any algebra that understands embedding.
    implicit val GlobalAcceleratorOpEmbeddable: Embeddable[GlobalAcceleratorOp, GlobalAcceleratorClient] = new Embeddable[GlobalAcceleratorOp, GlobalAcceleratorClient] {
      def embed[A](client: GlobalAcceleratorClient, io: GlobalAcceleratorIO[A]): Embedded[A] = Embedded.GlobalAccelerator(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GlobalAcceleratorOp.Visitor[Kleisli[M, GlobalAcceleratorClient, *]] {
        def addCustomRoutingEndpoints(
          request: AddCustomRoutingEndpointsRequest
        ): Kleisli[M, GlobalAcceleratorClient, AddCustomRoutingEndpointsResponse] =
          primitive(_.addCustomRoutingEndpoints(request))

        def advertiseByoipCidr(
          request: AdvertiseByoipCidrRequest
        ): Kleisli[M, GlobalAcceleratorClient, AdvertiseByoipCidrResponse] =
          primitive(_.advertiseByoipCidr(request))

        def allowCustomRoutingTraffic(
          request: AllowCustomRoutingTrafficRequest
        ): Kleisli[M, GlobalAcceleratorClient, AllowCustomRoutingTrafficResponse] =
          primitive(_.allowCustomRoutingTraffic(request))

        def createAccelerator(
          request: CreateAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, CreateAcceleratorResponse] =
          primitive(_.createAccelerator(request))

        def createCustomRoutingAccelerator(
          request: CreateCustomRoutingAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, CreateCustomRoutingAcceleratorResponse] =
          primitive(_.createCustomRoutingAccelerator(request))

        def createCustomRoutingEndpointGroup(
          request: CreateCustomRoutingEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, CreateCustomRoutingEndpointGroupResponse] =
          primitive(_.createCustomRoutingEndpointGroup(request))

        def createCustomRoutingListener(
          request: CreateCustomRoutingListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, CreateCustomRoutingListenerResponse] =
          primitive(_.createCustomRoutingListener(request))

        def createEndpointGroup(
          request: CreateEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, CreateEndpointGroupResponse] =
          primitive(_.createEndpointGroup(request))

        def createListener(
          request: CreateListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, CreateListenerResponse] =
          primitive(_.createListener(request))

        def deleteAccelerator(
          request: DeleteAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeleteAcceleratorResponse] =
          primitive(_.deleteAccelerator(request))

        def deleteCustomRoutingAccelerator(
          request: DeleteCustomRoutingAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeleteCustomRoutingAcceleratorResponse] =
          primitive(_.deleteCustomRoutingAccelerator(request))

        def deleteCustomRoutingEndpointGroup(
          request: DeleteCustomRoutingEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeleteCustomRoutingEndpointGroupResponse] =
          primitive(_.deleteCustomRoutingEndpointGroup(request))

        def deleteCustomRoutingListener(
          request: DeleteCustomRoutingListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeleteCustomRoutingListenerResponse] =
          primitive(_.deleteCustomRoutingListener(request))

        def deleteEndpointGroup(
          request: DeleteEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeleteEndpointGroupResponse] =
          primitive(_.deleteEndpointGroup(request))

        def deleteListener(
          request: DeleteListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeleteListenerResponse] =
          primitive(_.deleteListener(request))

        def denyCustomRoutingTraffic(
          request: DenyCustomRoutingTrafficRequest
        ): Kleisli[M, GlobalAcceleratorClient, DenyCustomRoutingTrafficResponse] =
          primitive(_.denyCustomRoutingTraffic(request))

        def deprovisionByoipCidr(
          request: DeprovisionByoipCidrRequest
        ): Kleisli[M, GlobalAcceleratorClient, DeprovisionByoipCidrResponse] =
          primitive(_.deprovisionByoipCidr(request))

        def describeAccelerator(
          request: DescribeAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeAcceleratorResponse] =
          primitive(_.describeAccelerator(request))

        def describeAcceleratorAttributes(
          request: DescribeAcceleratorAttributesRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeAcceleratorAttributesResponse] =
          primitive(_.describeAcceleratorAttributes(request))

        def describeCustomRoutingAccelerator(
          request: DescribeCustomRoutingAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeCustomRoutingAcceleratorResponse] =
          primitive(_.describeCustomRoutingAccelerator(request))

        def describeCustomRoutingAcceleratorAttributes(
          request: DescribeCustomRoutingAcceleratorAttributesRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeCustomRoutingAcceleratorAttributesResponse] =
          primitive(_.describeCustomRoutingAcceleratorAttributes(request))

        def describeCustomRoutingEndpointGroup(
          request: DescribeCustomRoutingEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeCustomRoutingEndpointGroupResponse] =
          primitive(_.describeCustomRoutingEndpointGroup(request))

        def describeCustomRoutingListener(
          request: DescribeCustomRoutingListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeCustomRoutingListenerResponse] =
          primitive(_.describeCustomRoutingListener(request))

        def describeEndpointGroup(
          request: DescribeEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeEndpointGroupResponse] =
          primitive(_.describeEndpointGroup(request))

        def describeListener(
          request: DescribeListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, DescribeListenerResponse] =
          primitive(_.describeListener(request))

        def listAccelerators(
          request: ListAcceleratorsRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListAcceleratorsResponse] =
          primitive(_.listAccelerators(request))

        def listByoipCidrs(
          request: ListByoipCidrsRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListByoipCidrsResponse] =
          primitive(_.listByoipCidrs(request))

        def listCustomRoutingAccelerators(
          request: ListCustomRoutingAcceleratorsRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListCustomRoutingAcceleratorsResponse] =
          primitive(_.listCustomRoutingAccelerators(request))

        def listCustomRoutingEndpointGroups(
          request: ListCustomRoutingEndpointGroupsRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListCustomRoutingEndpointGroupsResponse] =
          primitive(_.listCustomRoutingEndpointGroups(request))

        def listCustomRoutingListeners(
          request: ListCustomRoutingListenersRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListCustomRoutingListenersResponse] =
          primitive(_.listCustomRoutingListeners(request))

        def listCustomRoutingPortMappings(
          request: ListCustomRoutingPortMappingsRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListCustomRoutingPortMappingsResponse] =
          primitive(_.listCustomRoutingPortMappings(request))

        def listCustomRoutingPortMappingsByDestination(
          request: ListCustomRoutingPortMappingsByDestinationRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListCustomRoutingPortMappingsByDestinationResponse] =
          primitive(_.listCustomRoutingPortMappingsByDestination(request))

        def listEndpointGroups(
          request: ListEndpointGroupsRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListEndpointGroupsResponse] =
          primitive(_.listEndpointGroups(request))

        def listListeners(
          request: ListListenersRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListListenersResponse] =
          primitive(_.listListeners(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, GlobalAcceleratorClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def provisionByoipCidr(
          request: ProvisionByoipCidrRequest
        ): Kleisli[M, GlobalAcceleratorClient, ProvisionByoipCidrResponse] =
          primitive(_.provisionByoipCidr(request))

        def removeCustomRoutingEndpoints(
          request: RemoveCustomRoutingEndpointsRequest
        ): Kleisli[M, GlobalAcceleratorClient, RemoveCustomRoutingEndpointsResponse] =
          primitive(_.removeCustomRoutingEndpoints(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GlobalAcceleratorClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GlobalAcceleratorClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccelerator(
          request: UpdateAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateAcceleratorResponse] =
          primitive(_.updateAccelerator(request))

        def updateAcceleratorAttributes(
          request: UpdateAcceleratorAttributesRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateAcceleratorAttributesResponse] =
          primitive(_.updateAcceleratorAttributes(request))

        def updateCustomRoutingAccelerator(
          request: UpdateCustomRoutingAcceleratorRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateCustomRoutingAcceleratorResponse] =
          primitive(_.updateCustomRoutingAccelerator(request))

        def updateCustomRoutingAcceleratorAttributes(
          request: UpdateCustomRoutingAcceleratorAttributesRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateCustomRoutingAcceleratorAttributesResponse] =
          primitive(_.updateCustomRoutingAcceleratorAttributes(request))

        def updateCustomRoutingListener(
          request: UpdateCustomRoutingListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateCustomRoutingListenerResponse] =
          primitive(_.updateCustomRoutingListener(request))

        def updateEndpointGroup(
          request: UpdateEndpointGroupRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateEndpointGroupResponse] =
          primitive(_.updateEndpointGroup(request))

        def updateListener(
          request: UpdateListenerRequest
        ): Kleisli[M, GlobalAcceleratorClient, UpdateListenerResponse] =
          primitive(_.updateListener(request))

        def withdrawByoipCidr(
          request: WithdrawByoipCidrRequest
        ): Kleisli[M, GlobalAcceleratorClient, WithdrawByoipCidrResponse] =
          primitive(_.withdrawByoipCidr(request))

        def primitive[A](
          f: GlobalAcceleratorClient => A
        ): Kleisli[M, GlobalAcceleratorClient, A]
      }
    }

    trait Visitor[F[_]] extends (GlobalAcceleratorOp ~> F) {
      final def apply[A](op: GlobalAcceleratorOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addCustomRoutingEndpoints(
        request: AddCustomRoutingEndpointsRequest
      ): F[AddCustomRoutingEndpointsResponse]

      def advertiseByoipCidr(
        request: AdvertiseByoipCidrRequest
      ): F[AdvertiseByoipCidrResponse]

      def allowCustomRoutingTraffic(
        request: AllowCustomRoutingTrafficRequest
      ): F[AllowCustomRoutingTrafficResponse]

      def createAccelerator(
        request: CreateAcceleratorRequest
      ): F[CreateAcceleratorResponse]

      def createCustomRoutingAccelerator(
        request: CreateCustomRoutingAcceleratorRequest
      ): F[CreateCustomRoutingAcceleratorResponse]

      def createCustomRoutingEndpointGroup(
        request: CreateCustomRoutingEndpointGroupRequest
      ): F[CreateCustomRoutingEndpointGroupResponse]

      def createCustomRoutingListener(
        request: CreateCustomRoutingListenerRequest
      ): F[CreateCustomRoutingListenerResponse]

      def createEndpointGroup(
        request: CreateEndpointGroupRequest
      ): F[CreateEndpointGroupResponse]

      def createListener(
        request: CreateListenerRequest
      ): F[CreateListenerResponse]

      def deleteAccelerator(
        request: DeleteAcceleratorRequest
      ): F[DeleteAcceleratorResponse]

      def deleteCustomRoutingAccelerator(
        request: DeleteCustomRoutingAcceleratorRequest
      ): F[DeleteCustomRoutingAcceleratorResponse]

      def deleteCustomRoutingEndpointGroup(
        request: DeleteCustomRoutingEndpointGroupRequest
      ): F[DeleteCustomRoutingEndpointGroupResponse]

      def deleteCustomRoutingListener(
        request: DeleteCustomRoutingListenerRequest
      ): F[DeleteCustomRoutingListenerResponse]

      def deleteEndpointGroup(
        request: DeleteEndpointGroupRequest
      ): F[DeleteEndpointGroupResponse]

      def deleteListener(
        request: DeleteListenerRequest
      ): F[DeleteListenerResponse]

      def denyCustomRoutingTraffic(
        request: DenyCustomRoutingTrafficRequest
      ): F[DenyCustomRoutingTrafficResponse]

      def deprovisionByoipCidr(
        request: DeprovisionByoipCidrRequest
      ): F[DeprovisionByoipCidrResponse]

      def describeAccelerator(
        request: DescribeAcceleratorRequest
      ): F[DescribeAcceleratorResponse]

      def describeAcceleratorAttributes(
        request: DescribeAcceleratorAttributesRequest
      ): F[DescribeAcceleratorAttributesResponse]

      def describeCustomRoutingAccelerator(
        request: DescribeCustomRoutingAcceleratorRequest
      ): F[DescribeCustomRoutingAcceleratorResponse]

      def describeCustomRoutingAcceleratorAttributes(
        request: DescribeCustomRoutingAcceleratorAttributesRequest
      ): F[DescribeCustomRoutingAcceleratorAttributesResponse]

      def describeCustomRoutingEndpointGroup(
        request: DescribeCustomRoutingEndpointGroupRequest
      ): F[DescribeCustomRoutingEndpointGroupResponse]

      def describeCustomRoutingListener(
        request: DescribeCustomRoutingListenerRequest
      ): F[DescribeCustomRoutingListenerResponse]

      def describeEndpointGroup(
        request: DescribeEndpointGroupRequest
      ): F[DescribeEndpointGroupResponse]

      def describeListener(
        request: DescribeListenerRequest
      ): F[DescribeListenerResponse]

      def listAccelerators(
        request: ListAcceleratorsRequest
      ): F[ListAcceleratorsResponse]

      def listByoipCidrs(
        request: ListByoipCidrsRequest
      ): F[ListByoipCidrsResponse]

      def listCustomRoutingAccelerators(
        request: ListCustomRoutingAcceleratorsRequest
      ): F[ListCustomRoutingAcceleratorsResponse]

      def listCustomRoutingEndpointGroups(
        request: ListCustomRoutingEndpointGroupsRequest
      ): F[ListCustomRoutingEndpointGroupsResponse]

      def listCustomRoutingListeners(
        request: ListCustomRoutingListenersRequest
      ): F[ListCustomRoutingListenersResponse]

      def listCustomRoutingPortMappings(
        request: ListCustomRoutingPortMappingsRequest
      ): F[ListCustomRoutingPortMappingsResponse]

      def listCustomRoutingPortMappingsByDestination(
        request: ListCustomRoutingPortMappingsByDestinationRequest
      ): F[ListCustomRoutingPortMappingsByDestinationResponse]

      def listEndpointGroups(
        request: ListEndpointGroupsRequest
      ): F[ListEndpointGroupsResponse]

      def listListeners(
        request: ListListenersRequest
      ): F[ListListenersResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def provisionByoipCidr(
        request: ProvisionByoipCidrRequest
      ): F[ProvisionByoipCidrResponse]

      def removeCustomRoutingEndpoints(
        request: RemoveCustomRoutingEndpointsRequest
      ): F[RemoveCustomRoutingEndpointsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccelerator(
        request: UpdateAcceleratorRequest
      ): F[UpdateAcceleratorResponse]

      def updateAcceleratorAttributes(
        request: UpdateAcceleratorAttributesRequest
      ): F[UpdateAcceleratorAttributesResponse]

      def updateCustomRoutingAccelerator(
        request: UpdateCustomRoutingAcceleratorRequest
      ): F[UpdateCustomRoutingAcceleratorResponse]

      def updateCustomRoutingAcceleratorAttributes(
        request: UpdateCustomRoutingAcceleratorAttributesRequest
      ): F[UpdateCustomRoutingAcceleratorAttributesResponse]

      def updateCustomRoutingListener(
        request: UpdateCustomRoutingListenerRequest
      ): F[UpdateCustomRoutingListenerResponse]

      def updateEndpointGroup(
        request: UpdateEndpointGroupRequest
      ): F[UpdateEndpointGroupResponse]

      def updateListener(
        request: UpdateListenerRequest
      ): F[UpdateListenerResponse]

      def withdrawByoipCidr(
        request: WithdrawByoipCidrRequest
      ): F[WithdrawByoipCidrResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GlobalAcceleratorOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddCustomRoutingEndpointsOp(
      request: AddCustomRoutingEndpointsRequest
    ) extends GlobalAcceleratorOp[AddCustomRoutingEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddCustomRoutingEndpointsResponse] =
        visitor.addCustomRoutingEndpoints(request)
    }

    final case class AdvertiseByoipCidrOp(
      request: AdvertiseByoipCidrRequest
    ) extends GlobalAcceleratorOp[AdvertiseByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AdvertiseByoipCidrResponse] =
        visitor.advertiseByoipCidr(request)
    }

    final case class AllowCustomRoutingTrafficOp(
      request: AllowCustomRoutingTrafficRequest
    ) extends GlobalAcceleratorOp[AllowCustomRoutingTrafficResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AllowCustomRoutingTrafficResponse] =
        visitor.allowCustomRoutingTraffic(request)
    }

    final case class CreateAcceleratorOp(
      request: CreateAcceleratorRequest
    ) extends GlobalAcceleratorOp[CreateAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAcceleratorResponse] =
        visitor.createAccelerator(request)
    }

    final case class CreateCustomRoutingAcceleratorOp(
      request: CreateCustomRoutingAcceleratorRequest
    ) extends GlobalAcceleratorOp[CreateCustomRoutingAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomRoutingAcceleratorResponse] =
        visitor.createCustomRoutingAccelerator(request)
    }

    final case class CreateCustomRoutingEndpointGroupOp(
      request: CreateCustomRoutingEndpointGroupRequest
    ) extends GlobalAcceleratorOp[CreateCustomRoutingEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomRoutingEndpointGroupResponse] =
        visitor.createCustomRoutingEndpointGroup(request)
    }

    final case class CreateCustomRoutingListenerOp(
      request: CreateCustomRoutingListenerRequest
    ) extends GlobalAcceleratorOp[CreateCustomRoutingListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCustomRoutingListenerResponse] =
        visitor.createCustomRoutingListener(request)
    }

    final case class CreateEndpointGroupOp(
      request: CreateEndpointGroupRequest
    ) extends GlobalAcceleratorOp[CreateEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointGroupResponse] =
        visitor.createEndpointGroup(request)
    }

    final case class CreateListenerOp(
      request: CreateListenerRequest
    ) extends GlobalAcceleratorOp[CreateListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateListenerResponse] =
        visitor.createListener(request)
    }

    final case class DeleteAcceleratorOp(
      request: DeleteAcceleratorRequest
    ) extends GlobalAcceleratorOp[DeleteAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAcceleratorResponse] =
        visitor.deleteAccelerator(request)
    }

    final case class DeleteCustomRoutingAcceleratorOp(
      request: DeleteCustomRoutingAcceleratorRequest
    ) extends GlobalAcceleratorOp[DeleteCustomRoutingAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomRoutingAcceleratorResponse] =
        visitor.deleteCustomRoutingAccelerator(request)
    }

    final case class DeleteCustomRoutingEndpointGroupOp(
      request: DeleteCustomRoutingEndpointGroupRequest
    ) extends GlobalAcceleratorOp[DeleteCustomRoutingEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomRoutingEndpointGroupResponse] =
        visitor.deleteCustomRoutingEndpointGroup(request)
    }

    final case class DeleteCustomRoutingListenerOp(
      request: DeleteCustomRoutingListenerRequest
    ) extends GlobalAcceleratorOp[DeleteCustomRoutingListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCustomRoutingListenerResponse] =
        visitor.deleteCustomRoutingListener(request)
    }

    final case class DeleteEndpointGroupOp(
      request: DeleteEndpointGroupRequest
    ) extends GlobalAcceleratorOp[DeleteEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointGroupResponse] =
        visitor.deleteEndpointGroup(request)
    }

    final case class DeleteListenerOp(
      request: DeleteListenerRequest
    ) extends GlobalAcceleratorOp[DeleteListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteListenerResponse] =
        visitor.deleteListener(request)
    }

    final case class DenyCustomRoutingTrafficOp(
      request: DenyCustomRoutingTrafficRequest
    ) extends GlobalAcceleratorOp[DenyCustomRoutingTrafficResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DenyCustomRoutingTrafficResponse] =
        visitor.denyCustomRoutingTraffic(request)
    }

    final case class DeprovisionByoipCidrOp(
      request: DeprovisionByoipCidrRequest
    ) extends GlobalAcceleratorOp[DeprovisionByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeprovisionByoipCidrResponse] =
        visitor.deprovisionByoipCidr(request)
    }

    final case class DescribeAcceleratorOp(
      request: DescribeAcceleratorRequest
    ) extends GlobalAcceleratorOp[DescribeAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAcceleratorResponse] =
        visitor.describeAccelerator(request)
    }

    final case class DescribeAcceleratorAttributesOp(
      request: DescribeAcceleratorAttributesRequest
    ) extends GlobalAcceleratorOp[DescribeAcceleratorAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAcceleratorAttributesResponse] =
        visitor.describeAcceleratorAttributes(request)
    }

    final case class DescribeCustomRoutingAcceleratorOp(
      request: DescribeCustomRoutingAcceleratorRequest
    ) extends GlobalAcceleratorOp[DescribeCustomRoutingAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomRoutingAcceleratorResponse] =
        visitor.describeCustomRoutingAccelerator(request)
    }

    final case class DescribeCustomRoutingAcceleratorAttributesOp(
      request: DescribeCustomRoutingAcceleratorAttributesRequest
    ) extends GlobalAcceleratorOp[DescribeCustomRoutingAcceleratorAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomRoutingAcceleratorAttributesResponse] =
        visitor.describeCustomRoutingAcceleratorAttributes(request)
    }

    final case class DescribeCustomRoutingEndpointGroupOp(
      request: DescribeCustomRoutingEndpointGroupRequest
    ) extends GlobalAcceleratorOp[DescribeCustomRoutingEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomRoutingEndpointGroupResponse] =
        visitor.describeCustomRoutingEndpointGroup(request)
    }

    final case class DescribeCustomRoutingListenerOp(
      request: DescribeCustomRoutingListenerRequest
    ) extends GlobalAcceleratorOp[DescribeCustomRoutingListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCustomRoutingListenerResponse] =
        visitor.describeCustomRoutingListener(request)
    }

    final case class DescribeEndpointGroupOp(
      request: DescribeEndpointGroupRequest
    ) extends GlobalAcceleratorOp[DescribeEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointGroupResponse] =
        visitor.describeEndpointGroup(request)
    }

    final case class DescribeListenerOp(
      request: DescribeListenerRequest
    ) extends GlobalAcceleratorOp[DescribeListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeListenerResponse] =
        visitor.describeListener(request)
    }

    final case class ListAcceleratorsOp(
      request: ListAcceleratorsRequest
    ) extends GlobalAcceleratorOp[ListAcceleratorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAcceleratorsResponse] =
        visitor.listAccelerators(request)
    }

    final case class ListByoipCidrsOp(
      request: ListByoipCidrsRequest
    ) extends GlobalAcceleratorOp[ListByoipCidrsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListByoipCidrsResponse] =
        visitor.listByoipCidrs(request)
    }

    final case class ListCustomRoutingAcceleratorsOp(
      request: ListCustomRoutingAcceleratorsRequest
    ) extends GlobalAcceleratorOp[ListCustomRoutingAcceleratorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomRoutingAcceleratorsResponse] =
        visitor.listCustomRoutingAccelerators(request)
    }

    final case class ListCustomRoutingEndpointGroupsOp(
      request: ListCustomRoutingEndpointGroupsRequest
    ) extends GlobalAcceleratorOp[ListCustomRoutingEndpointGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomRoutingEndpointGroupsResponse] =
        visitor.listCustomRoutingEndpointGroups(request)
    }

    final case class ListCustomRoutingListenersOp(
      request: ListCustomRoutingListenersRequest
    ) extends GlobalAcceleratorOp[ListCustomRoutingListenersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomRoutingListenersResponse] =
        visitor.listCustomRoutingListeners(request)
    }

    final case class ListCustomRoutingPortMappingsOp(
      request: ListCustomRoutingPortMappingsRequest
    ) extends GlobalAcceleratorOp[ListCustomRoutingPortMappingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomRoutingPortMappingsResponse] =
        visitor.listCustomRoutingPortMappings(request)
    }

    final case class ListCustomRoutingPortMappingsByDestinationOp(
      request: ListCustomRoutingPortMappingsByDestinationRequest
    ) extends GlobalAcceleratorOp[ListCustomRoutingPortMappingsByDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCustomRoutingPortMappingsByDestinationResponse] =
        visitor.listCustomRoutingPortMappingsByDestination(request)
    }

    final case class ListEndpointGroupsOp(
      request: ListEndpointGroupsRequest
    ) extends GlobalAcceleratorOp[ListEndpointGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEndpointGroupsResponse] =
        visitor.listEndpointGroups(request)
    }

    final case class ListListenersOp(
      request: ListListenersRequest
    ) extends GlobalAcceleratorOp[ListListenersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListListenersResponse] =
        visitor.listListeners(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends GlobalAcceleratorOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ProvisionByoipCidrOp(
      request: ProvisionByoipCidrRequest
    ) extends GlobalAcceleratorOp[ProvisionByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ProvisionByoipCidrResponse] =
        visitor.provisionByoipCidr(request)
    }

    final case class RemoveCustomRoutingEndpointsOp(
      request: RemoveCustomRoutingEndpointsRequest
    ) extends GlobalAcceleratorOp[RemoveCustomRoutingEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveCustomRoutingEndpointsResponse] =
        visitor.removeCustomRoutingEndpoints(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GlobalAcceleratorOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GlobalAcceleratorOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAcceleratorOp(
      request: UpdateAcceleratorRequest
    ) extends GlobalAcceleratorOp[UpdateAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAcceleratorResponse] =
        visitor.updateAccelerator(request)
    }

    final case class UpdateAcceleratorAttributesOp(
      request: UpdateAcceleratorAttributesRequest
    ) extends GlobalAcceleratorOp[UpdateAcceleratorAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAcceleratorAttributesResponse] =
        visitor.updateAcceleratorAttributes(request)
    }

    final case class UpdateCustomRoutingAcceleratorOp(
      request: UpdateCustomRoutingAcceleratorRequest
    ) extends GlobalAcceleratorOp[UpdateCustomRoutingAcceleratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomRoutingAcceleratorResponse] =
        visitor.updateCustomRoutingAccelerator(request)
    }

    final case class UpdateCustomRoutingAcceleratorAttributesOp(
      request: UpdateCustomRoutingAcceleratorAttributesRequest
    ) extends GlobalAcceleratorOp[UpdateCustomRoutingAcceleratorAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomRoutingAcceleratorAttributesResponse] =
        visitor.updateCustomRoutingAcceleratorAttributes(request)
    }

    final case class UpdateCustomRoutingListenerOp(
      request: UpdateCustomRoutingListenerRequest
    ) extends GlobalAcceleratorOp[UpdateCustomRoutingListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCustomRoutingListenerResponse] =
        visitor.updateCustomRoutingListener(request)
    }

    final case class UpdateEndpointGroupOp(
      request: UpdateEndpointGroupRequest
    ) extends GlobalAcceleratorOp[UpdateEndpointGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEndpointGroupResponse] =
        visitor.updateEndpointGroup(request)
    }

    final case class UpdateListenerOp(
      request: UpdateListenerRequest
    ) extends GlobalAcceleratorOp[UpdateListenerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateListenerResponse] =
        visitor.updateListener(request)
    }

    final case class WithdrawByoipCidrOp(
      request: WithdrawByoipCidrRequest
    ) extends GlobalAcceleratorOp[WithdrawByoipCidrResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[WithdrawByoipCidrResponse] =
        visitor.withdrawByoipCidr(request)
    }
  }

  import GlobalAcceleratorOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GlobalAcceleratorOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addCustomRoutingEndpoints(
    request: AddCustomRoutingEndpointsRequest
  ): GlobalAcceleratorIO[AddCustomRoutingEndpointsResponse] =
    FF.liftF(AddCustomRoutingEndpointsOp(request))

  def advertiseByoipCidr(
    request: AdvertiseByoipCidrRequest
  ): GlobalAcceleratorIO[AdvertiseByoipCidrResponse] =
    FF.liftF(AdvertiseByoipCidrOp(request))

  def allowCustomRoutingTraffic(
    request: AllowCustomRoutingTrafficRequest
  ): GlobalAcceleratorIO[AllowCustomRoutingTrafficResponse] =
    FF.liftF(AllowCustomRoutingTrafficOp(request))

  def createAccelerator(
    request: CreateAcceleratorRequest
  ): GlobalAcceleratorIO[CreateAcceleratorResponse] =
    FF.liftF(CreateAcceleratorOp(request))

  def createCustomRoutingAccelerator(
    request: CreateCustomRoutingAcceleratorRequest
  ): GlobalAcceleratorIO[CreateCustomRoutingAcceleratorResponse] =
    FF.liftF(CreateCustomRoutingAcceleratorOp(request))

  def createCustomRoutingEndpointGroup(
    request: CreateCustomRoutingEndpointGroupRequest
  ): GlobalAcceleratorIO[CreateCustomRoutingEndpointGroupResponse] =
    FF.liftF(CreateCustomRoutingEndpointGroupOp(request))

  def createCustomRoutingListener(
    request: CreateCustomRoutingListenerRequest
  ): GlobalAcceleratorIO[CreateCustomRoutingListenerResponse] =
    FF.liftF(CreateCustomRoutingListenerOp(request))

  def createEndpointGroup(
    request: CreateEndpointGroupRequest
  ): GlobalAcceleratorIO[CreateEndpointGroupResponse] =
    FF.liftF(CreateEndpointGroupOp(request))

  def createListener(
    request: CreateListenerRequest
  ): GlobalAcceleratorIO[CreateListenerResponse] =
    FF.liftF(CreateListenerOp(request))

  def deleteAccelerator(
    request: DeleteAcceleratorRequest
  ): GlobalAcceleratorIO[DeleteAcceleratorResponse] =
    FF.liftF(DeleteAcceleratorOp(request))

  def deleteCustomRoutingAccelerator(
    request: DeleteCustomRoutingAcceleratorRequest
  ): GlobalAcceleratorIO[DeleteCustomRoutingAcceleratorResponse] =
    FF.liftF(DeleteCustomRoutingAcceleratorOp(request))

  def deleteCustomRoutingEndpointGroup(
    request: DeleteCustomRoutingEndpointGroupRequest
  ): GlobalAcceleratorIO[DeleteCustomRoutingEndpointGroupResponse] =
    FF.liftF(DeleteCustomRoutingEndpointGroupOp(request))

  def deleteCustomRoutingListener(
    request: DeleteCustomRoutingListenerRequest
  ): GlobalAcceleratorIO[DeleteCustomRoutingListenerResponse] =
    FF.liftF(DeleteCustomRoutingListenerOp(request))

  def deleteEndpointGroup(
    request: DeleteEndpointGroupRequest
  ): GlobalAcceleratorIO[DeleteEndpointGroupResponse] =
    FF.liftF(DeleteEndpointGroupOp(request))

  def deleteListener(
    request: DeleteListenerRequest
  ): GlobalAcceleratorIO[DeleteListenerResponse] =
    FF.liftF(DeleteListenerOp(request))

  def denyCustomRoutingTraffic(
    request: DenyCustomRoutingTrafficRequest
  ): GlobalAcceleratorIO[DenyCustomRoutingTrafficResponse] =
    FF.liftF(DenyCustomRoutingTrafficOp(request))

  def deprovisionByoipCidr(
    request: DeprovisionByoipCidrRequest
  ): GlobalAcceleratorIO[DeprovisionByoipCidrResponse] =
    FF.liftF(DeprovisionByoipCidrOp(request))

  def describeAccelerator(
    request: DescribeAcceleratorRequest
  ): GlobalAcceleratorIO[DescribeAcceleratorResponse] =
    FF.liftF(DescribeAcceleratorOp(request))

  def describeAcceleratorAttributes(
    request: DescribeAcceleratorAttributesRequest
  ): GlobalAcceleratorIO[DescribeAcceleratorAttributesResponse] =
    FF.liftF(DescribeAcceleratorAttributesOp(request))

  def describeCustomRoutingAccelerator(
    request: DescribeCustomRoutingAcceleratorRequest
  ): GlobalAcceleratorIO[DescribeCustomRoutingAcceleratorResponse] =
    FF.liftF(DescribeCustomRoutingAcceleratorOp(request))

  def describeCustomRoutingAcceleratorAttributes(
    request: DescribeCustomRoutingAcceleratorAttributesRequest
  ): GlobalAcceleratorIO[DescribeCustomRoutingAcceleratorAttributesResponse] =
    FF.liftF(DescribeCustomRoutingAcceleratorAttributesOp(request))

  def describeCustomRoutingEndpointGroup(
    request: DescribeCustomRoutingEndpointGroupRequest
  ): GlobalAcceleratorIO[DescribeCustomRoutingEndpointGroupResponse] =
    FF.liftF(DescribeCustomRoutingEndpointGroupOp(request))

  def describeCustomRoutingListener(
    request: DescribeCustomRoutingListenerRequest
  ): GlobalAcceleratorIO[DescribeCustomRoutingListenerResponse] =
    FF.liftF(DescribeCustomRoutingListenerOp(request))

  def describeEndpointGroup(
    request: DescribeEndpointGroupRequest
  ): GlobalAcceleratorIO[DescribeEndpointGroupResponse] =
    FF.liftF(DescribeEndpointGroupOp(request))

  def describeListener(
    request: DescribeListenerRequest
  ): GlobalAcceleratorIO[DescribeListenerResponse] =
    FF.liftF(DescribeListenerOp(request))

  def listAccelerators(
    request: ListAcceleratorsRequest
  ): GlobalAcceleratorIO[ListAcceleratorsResponse] =
    FF.liftF(ListAcceleratorsOp(request))

  def listByoipCidrs(
    request: ListByoipCidrsRequest
  ): GlobalAcceleratorIO[ListByoipCidrsResponse] =
    FF.liftF(ListByoipCidrsOp(request))

  def listCustomRoutingAccelerators(
    request: ListCustomRoutingAcceleratorsRequest
  ): GlobalAcceleratorIO[ListCustomRoutingAcceleratorsResponse] =
    FF.liftF(ListCustomRoutingAcceleratorsOp(request))

  def listCustomRoutingEndpointGroups(
    request: ListCustomRoutingEndpointGroupsRequest
  ): GlobalAcceleratorIO[ListCustomRoutingEndpointGroupsResponse] =
    FF.liftF(ListCustomRoutingEndpointGroupsOp(request))

  def listCustomRoutingListeners(
    request: ListCustomRoutingListenersRequest
  ): GlobalAcceleratorIO[ListCustomRoutingListenersResponse] =
    FF.liftF(ListCustomRoutingListenersOp(request))

  def listCustomRoutingPortMappings(
    request: ListCustomRoutingPortMappingsRequest
  ): GlobalAcceleratorIO[ListCustomRoutingPortMappingsResponse] =
    FF.liftF(ListCustomRoutingPortMappingsOp(request))

  def listCustomRoutingPortMappingsByDestination(
    request: ListCustomRoutingPortMappingsByDestinationRequest
  ): GlobalAcceleratorIO[ListCustomRoutingPortMappingsByDestinationResponse] =
    FF.liftF(ListCustomRoutingPortMappingsByDestinationOp(request))

  def listEndpointGroups(
    request: ListEndpointGroupsRequest
  ): GlobalAcceleratorIO[ListEndpointGroupsResponse] =
    FF.liftF(ListEndpointGroupsOp(request))

  def listListeners(
    request: ListListenersRequest
  ): GlobalAcceleratorIO[ListListenersResponse] =
    FF.liftF(ListListenersOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): GlobalAcceleratorIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def provisionByoipCidr(
    request: ProvisionByoipCidrRequest
  ): GlobalAcceleratorIO[ProvisionByoipCidrResponse] =
    FF.liftF(ProvisionByoipCidrOp(request))

  def removeCustomRoutingEndpoints(
    request: RemoveCustomRoutingEndpointsRequest
  ): GlobalAcceleratorIO[RemoveCustomRoutingEndpointsResponse] =
    FF.liftF(RemoveCustomRoutingEndpointsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GlobalAcceleratorIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GlobalAcceleratorIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccelerator(
    request: UpdateAcceleratorRequest
  ): GlobalAcceleratorIO[UpdateAcceleratorResponse] =
    FF.liftF(UpdateAcceleratorOp(request))

  def updateAcceleratorAttributes(
    request: UpdateAcceleratorAttributesRequest
  ): GlobalAcceleratorIO[UpdateAcceleratorAttributesResponse] =
    FF.liftF(UpdateAcceleratorAttributesOp(request))

  def updateCustomRoutingAccelerator(
    request: UpdateCustomRoutingAcceleratorRequest
  ): GlobalAcceleratorIO[UpdateCustomRoutingAcceleratorResponse] =
    FF.liftF(UpdateCustomRoutingAcceleratorOp(request))

  def updateCustomRoutingAcceleratorAttributes(
    request: UpdateCustomRoutingAcceleratorAttributesRequest
  ): GlobalAcceleratorIO[UpdateCustomRoutingAcceleratorAttributesResponse] =
    FF.liftF(UpdateCustomRoutingAcceleratorAttributesOp(request))

  def updateCustomRoutingListener(
    request: UpdateCustomRoutingListenerRequest
  ): GlobalAcceleratorIO[UpdateCustomRoutingListenerResponse] =
    FF.liftF(UpdateCustomRoutingListenerOp(request))

  def updateEndpointGroup(
    request: UpdateEndpointGroupRequest
  ): GlobalAcceleratorIO[UpdateEndpointGroupResponse] =
    FF.liftF(UpdateEndpointGroupOp(request))

  def updateListener(
    request: UpdateListenerRequest
  ): GlobalAcceleratorIO[UpdateListenerResponse] =
    FF.liftF(UpdateListenerOp(request))

  def withdrawByoipCidr(
    request: WithdrawByoipCidrRequest
  ): GlobalAcceleratorIO[WithdrawByoipCidrResponse] =
    FF.liftF(WithdrawByoipCidrOp(request))
}
