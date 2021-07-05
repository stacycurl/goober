package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.resourcegroups.ResourceGroupsClient
import software.amazon.awssdk.services.resourcegroups.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object resourcegroups { module =>

  // Free monad over ResourceGroupsOp
  type ResourceGroupsIO[A] = FF[ResourceGroupsOp, A]

  sealed trait ResourceGroupsOp[A] {
    def visit[F[_]](visitor: ResourceGroupsOp.Visitor[F]): F[A]
  }

  object ResourceGroupsOp {
    // Given a ResourceGroupsClient we can embed a ResourceGroupsIO program in any algebra that understands embedding.
    implicit val ResourceGroupsOpEmbeddable: Embeddable[ResourceGroupsOp, ResourceGroupsClient] = new Embeddable[ResourceGroupsOp, ResourceGroupsClient] {
      def embed[A](client: ResourceGroupsClient, io: ResourceGroupsIO[A]): Embedded[A] = Embedded.ResourceGroups(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ResourceGroupsOp.Visitor[Kleisli[M, ResourceGroupsClient, *]] {
        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, ResourceGroupsClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, ResourceGroupsClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def getGroup(
          request: GetGroupRequest
        ): Kleisli[M, ResourceGroupsClient, GetGroupResponse] =
          primitive(_.getGroup(request))

        def getGroupConfiguration(
          request: GetGroupConfigurationRequest
        ): Kleisli[M, ResourceGroupsClient, GetGroupConfigurationResponse] =
          primitive(_.getGroupConfiguration(request))

        def getGroupQuery(
          request: GetGroupQueryRequest
        ): Kleisli[M, ResourceGroupsClient, GetGroupQueryResponse] =
          primitive(_.getGroupQuery(request))

        def getTags(
          request: GetTagsRequest
        ): Kleisli[M, ResourceGroupsClient, GetTagsResponse] =
          primitive(_.getTags(request))

        def groupResources(
          request: GroupResourcesRequest
        ): Kleisli[M, ResourceGroupsClient, GroupResourcesResponse] =
          primitive(_.groupResources(request))

        def listGroupResources(
          request: ListGroupResourcesRequest
        ): Kleisli[M, ResourceGroupsClient, ListGroupResourcesResponse] =
          primitive(_.listGroupResources(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, ResourceGroupsClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def putGroupConfiguration(
          request: PutGroupConfigurationRequest
        ): Kleisli[M, ResourceGroupsClient, PutGroupConfigurationResponse] =
          primitive(_.putGroupConfiguration(request))

        def searchResources(
          request: SearchResourcesRequest
        ): Kleisli[M, ResourceGroupsClient, SearchResourcesResponse] =
          primitive(_.searchResources(request))

        def tag(
          request: TagRequest
        ): Kleisli[M, ResourceGroupsClient, TagResponse] =
          primitive(_.tag(request))

        def ungroupResources(
          request: UngroupResourcesRequest
        ): Kleisli[M, ResourceGroupsClient, UngroupResourcesResponse] =
          primitive(_.ungroupResources(request))

        def untag(
          request: UntagRequest
        ): Kleisli[M, ResourceGroupsClient, UntagResponse] =
          primitive(_.untag(request))

        def updateGroup(
          request: UpdateGroupRequest
        ): Kleisli[M, ResourceGroupsClient, UpdateGroupResponse] =
          primitive(_.updateGroup(request))

        def updateGroupQuery(
          request: UpdateGroupQueryRequest
        ): Kleisli[M, ResourceGroupsClient, UpdateGroupQueryResponse] =
          primitive(_.updateGroupQuery(request))

        def primitive[A](
          f: ResourceGroupsClient => A
        ): Kleisli[M, ResourceGroupsClient, A]
      }
    }

    trait Visitor[F[_]] extends (ResourceGroupsOp ~> F) {
      final def apply[A](op: ResourceGroupsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def getGroup(
        request: GetGroupRequest
      ): F[GetGroupResponse]

      def getGroupConfiguration(
        request: GetGroupConfigurationRequest
      ): F[GetGroupConfigurationResponse]

      def getGroupQuery(
        request: GetGroupQueryRequest
      ): F[GetGroupQueryResponse]

      def getTags(
        request: GetTagsRequest
      ): F[GetTagsResponse]

      def groupResources(
        request: GroupResourcesRequest
      ): F[GroupResourcesResponse]

      def listGroupResources(
        request: ListGroupResourcesRequest
      ): F[ListGroupResourcesResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def putGroupConfiguration(
        request: PutGroupConfigurationRequest
      ): F[PutGroupConfigurationResponse]

      def searchResources(
        request: SearchResourcesRequest
      ): F[SearchResourcesResponse]

      def tag(
        request: TagRequest
      ): F[TagResponse]

      def ungroupResources(
        request: UngroupResourcesRequest
      ): F[UngroupResourcesResponse]

      def untag(
        request: UntagRequest
      ): F[UntagResponse]

      def updateGroup(
        request: UpdateGroupRequest
      ): F[UpdateGroupResponse]

      def updateGroupQuery(
        request: UpdateGroupQueryRequest
      ): F[UpdateGroupQueryResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ResourceGroupsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends ResourceGroupsOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends ResourceGroupsOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class GetGroupOp(
      request: GetGroupRequest
    ) extends ResourceGroupsOp[GetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupResponse] =
        visitor.getGroup(request)
    }

    final case class GetGroupConfigurationOp(
      request: GetGroupConfigurationRequest
    ) extends ResourceGroupsOp[GetGroupConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupConfigurationResponse] =
        visitor.getGroupConfiguration(request)
    }

    final case class GetGroupQueryOp(
      request: GetGroupQueryRequest
    ) extends ResourceGroupsOp[GetGroupQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupQueryResponse] =
        visitor.getGroupQuery(request)
    }

    final case class GetTagsOp(
      request: GetTagsRequest
    ) extends ResourceGroupsOp[GetTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagsResponse] =
        visitor.getTags(request)
    }

    final case class GroupResourcesOp(
      request: GroupResourcesRequest
    ) extends ResourceGroupsOp[GroupResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GroupResourcesResponse] =
        visitor.groupResources(request)
    }

    final case class ListGroupResourcesOp(
      request: ListGroupResourcesRequest
    ) extends ResourceGroupsOp[ListGroupResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupResourcesResponse] =
        visitor.listGroupResources(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends ResourceGroupsOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class PutGroupConfigurationOp(
      request: PutGroupConfigurationRequest
    ) extends ResourceGroupsOp[PutGroupConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutGroupConfigurationResponse] =
        visitor.putGroupConfiguration(request)
    }

    final case class SearchResourcesOp(
      request: SearchResourcesRequest
    ) extends ResourceGroupsOp[SearchResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchResourcesResponse] =
        visitor.searchResources(request)
    }

    final case class TagOp(
      request: TagRequest
    ) extends ResourceGroupsOp[TagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResponse] =
        visitor.tag(request)
    }

    final case class UngroupResourcesOp(
      request: UngroupResourcesRequest
    ) extends ResourceGroupsOp[UngroupResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UngroupResourcesResponse] =
        visitor.ungroupResources(request)
    }

    final case class UntagOp(
      request: UntagRequest
    ) extends ResourceGroupsOp[UntagResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResponse] =
        visitor.untag(request)
    }

    final case class UpdateGroupOp(
      request: UpdateGroupRequest
    ) extends ResourceGroupsOp[UpdateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupResponse] =
        visitor.updateGroup(request)
    }

    final case class UpdateGroupQueryOp(
      request: UpdateGroupQueryRequest
    ) extends ResourceGroupsOp[UpdateGroupQueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupQueryResponse] =
        visitor.updateGroupQuery(request)
    }
  }

  import ResourceGroupsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ResourceGroupsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createGroup(
    request: CreateGroupRequest
  ): ResourceGroupsIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): ResourceGroupsIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def getGroup(
    request: GetGroupRequest
  ): ResourceGroupsIO[GetGroupResponse] =
    FF.liftF(GetGroupOp(request))

  def getGroupConfiguration(
    request: GetGroupConfigurationRequest
  ): ResourceGroupsIO[GetGroupConfigurationResponse] =
    FF.liftF(GetGroupConfigurationOp(request))

  def getGroupQuery(
    request: GetGroupQueryRequest
  ): ResourceGroupsIO[GetGroupQueryResponse] =
    FF.liftF(GetGroupQueryOp(request))

  def getTags(
    request: GetTagsRequest
  ): ResourceGroupsIO[GetTagsResponse] =
    FF.liftF(GetTagsOp(request))

  def groupResources(
    request: GroupResourcesRequest
  ): ResourceGroupsIO[GroupResourcesResponse] =
    FF.liftF(GroupResourcesOp(request))

  def listGroupResources(
    request: ListGroupResourcesRequest
  ): ResourceGroupsIO[ListGroupResourcesResponse] =
    FF.liftF(ListGroupResourcesOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): ResourceGroupsIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def putGroupConfiguration(
    request: PutGroupConfigurationRequest
  ): ResourceGroupsIO[PutGroupConfigurationResponse] =
    FF.liftF(PutGroupConfigurationOp(request))

  def searchResources(
    request: SearchResourcesRequest
  ): ResourceGroupsIO[SearchResourcesResponse] =
    FF.liftF(SearchResourcesOp(request))

  def tag(
    request: TagRequest
  ): ResourceGroupsIO[TagResponse] =
    FF.liftF(TagOp(request))

  def ungroupResources(
    request: UngroupResourcesRequest
  ): ResourceGroupsIO[UngroupResourcesResponse] =
    FF.liftF(UngroupResourcesOp(request))

  def untag(
    request: UntagRequest
  ): ResourceGroupsIO[UntagResponse] =
    FF.liftF(UntagOp(request))

  def updateGroup(
    request: UpdateGroupRequest
  ): ResourceGroupsIO[UpdateGroupResponse] =
    FF.liftF(UpdateGroupOp(request))

  def updateGroupQuery(
    request: UpdateGroupQueryRequest
  ): ResourceGroupsIO[UpdateGroupQueryResponse] =
    FF.liftF(UpdateGroupQueryOp(request))
}
