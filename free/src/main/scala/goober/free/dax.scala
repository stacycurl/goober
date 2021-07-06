package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.dax.DaxClient
import software.amazon.awssdk.services.dax.model._


object dax { module =>

  // Free monad over DaxOp
  type DaxIO[A] = FF[DaxOp, A]

  sealed trait DaxOp[A] {
    def visit[F[_]](visitor: DaxOp.Visitor[F]): F[A]
  }

  object DaxOp {
    // Given a DaxClient we can embed a DaxIO program in any algebra that understands embedding.
    implicit val DaxOpEmbeddable: Embeddable[DaxOp, DaxClient] = new Embeddable[DaxOp, DaxClient] {
      def embed[A](client: DaxClient, io: DaxIO[A]): Embedded[A] = Embedded.Dax(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DaxOp.Visitor[Kleisli[M, DaxClient, *]] {
        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, DaxClient, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createParameterGroup(
          request: CreateParameterGroupRequest
        ): Kleisli[M, DaxClient, CreateParameterGroupResponse] =
          primitive(_.createParameterGroup(request))

        def createSubnetGroup(
          request: CreateSubnetGroupRequest
        ): Kleisli[M, DaxClient, CreateSubnetGroupResponse] =
          primitive(_.createSubnetGroup(request))

        def decreaseReplicationFactor(
          request: DecreaseReplicationFactorRequest
        ): Kleisli[M, DaxClient, DecreaseReplicationFactorResponse] =
          primitive(_.decreaseReplicationFactor(request))

        def deleteCluster(
          request: DeleteClusterRequest
        ): Kleisli[M, DaxClient, DeleteClusterResponse] =
          primitive(_.deleteCluster(request))

        def deleteParameterGroup(
          request: DeleteParameterGroupRequest
        ): Kleisli[M, DaxClient, DeleteParameterGroupResponse] =
          primitive(_.deleteParameterGroup(request))

        def deleteSubnetGroup(
          request: DeleteSubnetGroupRequest
        ): Kleisli[M, DaxClient, DeleteSubnetGroupResponse] =
          primitive(_.deleteSubnetGroup(request))

        def describeClusters(
          request: DescribeClustersRequest
        ): Kleisli[M, DaxClient, DescribeClustersResponse] =
          primitive(_.describeClusters(request))

        def describeDefaultParameters(
          request: DescribeDefaultParametersRequest
        ): Kleisli[M, DaxClient, DescribeDefaultParametersResponse] =
          primitive(_.describeDefaultParameters(request))

        def describeEvents(
          request: DescribeEventsRequest
        ): Kleisli[M, DaxClient, DescribeEventsResponse] =
          primitive(_.describeEvents(request))

        def describeParameterGroups(
          request: DescribeParameterGroupsRequest
        ): Kleisli[M, DaxClient, DescribeParameterGroupsResponse] =
          primitive(_.describeParameterGroups(request))

        def describeParameters(
          request: DescribeParametersRequest
        ): Kleisli[M, DaxClient, DescribeParametersResponse] =
          primitive(_.describeParameters(request))

        def describeSubnetGroups(
          request: DescribeSubnetGroupsRequest
        ): Kleisli[M, DaxClient, DescribeSubnetGroupsResponse] =
          primitive(_.describeSubnetGroups(request))

        def increaseReplicationFactor(
          request: IncreaseReplicationFactorRequest
        ): Kleisli[M, DaxClient, IncreaseReplicationFactorResponse] =
          primitive(_.increaseReplicationFactor(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, DaxClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def rebootNode(
          request: RebootNodeRequest
        ): Kleisli[M, DaxClient, RebootNodeResponse] =
          primitive(_.rebootNode(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DaxClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DaxClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateCluster(
          request: UpdateClusterRequest
        ): Kleisli[M, DaxClient, UpdateClusterResponse] =
          primitive(_.updateCluster(request))

        def updateParameterGroup(
          request: UpdateParameterGroupRequest
        ): Kleisli[M, DaxClient, UpdateParameterGroupResponse] =
          primitive(_.updateParameterGroup(request))

        def updateSubnetGroup(
          request: UpdateSubnetGroupRequest
        ): Kleisli[M, DaxClient, UpdateSubnetGroupResponse] =
          primitive(_.updateSubnetGroup(request))

        def primitive[A](
          f: DaxClient => A
        ): Kleisli[M, DaxClient, A]
      }
    }

    trait Visitor[F[_]] extends (DaxOp ~> F) {
      final def apply[A](op: DaxOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createParameterGroup(
        request: CreateParameterGroupRequest
      ): F[CreateParameterGroupResponse]

      def createSubnetGroup(
        request: CreateSubnetGroupRequest
      ): F[CreateSubnetGroupResponse]

      def decreaseReplicationFactor(
        request: DecreaseReplicationFactorRequest
      ): F[DecreaseReplicationFactorResponse]

      def deleteCluster(
        request: DeleteClusterRequest
      ): F[DeleteClusterResponse]

      def deleteParameterGroup(
        request: DeleteParameterGroupRequest
      ): F[DeleteParameterGroupResponse]

      def deleteSubnetGroup(
        request: DeleteSubnetGroupRequest
      ): F[DeleteSubnetGroupResponse]

      def describeClusters(
        request: DescribeClustersRequest
      ): F[DescribeClustersResponse]

      def describeDefaultParameters(
        request: DescribeDefaultParametersRequest
      ): F[DescribeDefaultParametersResponse]

      def describeEvents(
        request: DescribeEventsRequest
      ): F[DescribeEventsResponse]

      def describeParameterGroups(
        request: DescribeParameterGroupsRequest
      ): F[DescribeParameterGroupsResponse]

      def describeParameters(
        request: DescribeParametersRequest
      ): F[DescribeParametersResponse]

      def describeSubnetGroups(
        request: DescribeSubnetGroupsRequest
      ): F[DescribeSubnetGroupsResponse]

      def increaseReplicationFactor(
        request: IncreaseReplicationFactorRequest
      ): F[IncreaseReplicationFactorResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def rebootNode(
        request: RebootNodeRequest
      ): F[RebootNodeResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateCluster(
        request: UpdateClusterRequest
      ): F[UpdateClusterResponse]

      def updateParameterGroup(
        request: UpdateParameterGroupRequest
      ): F[UpdateParameterGroupResponse]

      def updateSubnetGroup(
        request: UpdateSubnetGroupRequest
      ): F[UpdateSubnetGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DaxOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends DaxOp[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateParameterGroupOp(
      request: CreateParameterGroupRequest
    ) extends DaxOp[CreateParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateParameterGroupResponse] =
        visitor.createParameterGroup(request)
    }

    final case class CreateSubnetGroupOp(
      request: CreateSubnetGroupRequest
    ) extends DaxOp[CreateSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSubnetGroupResponse] =
        visitor.createSubnetGroup(request)
    }

    final case class DecreaseReplicationFactorOp(
      request: DecreaseReplicationFactorRequest
    ) extends DaxOp[DecreaseReplicationFactorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DecreaseReplicationFactorResponse] =
        visitor.decreaseReplicationFactor(request)
    }

    final case class DeleteClusterOp(
      request: DeleteClusterRequest
    ) extends DaxOp[DeleteClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterResponse] =
        visitor.deleteCluster(request)
    }

    final case class DeleteParameterGroupOp(
      request: DeleteParameterGroupRequest
    ) extends DaxOp[DeleteParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteParameterGroupResponse] =
        visitor.deleteParameterGroup(request)
    }

    final case class DeleteSubnetGroupOp(
      request: DeleteSubnetGroupRequest
    ) extends DaxOp[DeleteSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSubnetGroupResponse] =
        visitor.deleteSubnetGroup(request)
    }

    final case class DescribeClustersOp(
      request: DescribeClustersRequest
    ) extends DaxOp[DescribeClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClustersResponse] =
        visitor.describeClusters(request)
    }

    final case class DescribeDefaultParametersOp(
      request: DescribeDefaultParametersRequest
    ) extends DaxOp[DescribeDefaultParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDefaultParametersResponse] =
        visitor.describeDefaultParameters(request)
    }

    final case class DescribeEventsOp(
      request: DescribeEventsRequest
    ) extends DaxOp[DescribeEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsResponse] =
        visitor.describeEvents(request)
    }

    final case class DescribeParameterGroupsOp(
      request: DescribeParameterGroupsRequest
    ) extends DaxOp[DescribeParameterGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeParameterGroupsResponse] =
        visitor.describeParameterGroups(request)
    }

    final case class DescribeParametersOp(
      request: DescribeParametersRequest
    ) extends DaxOp[DescribeParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeParametersResponse] =
        visitor.describeParameters(request)
    }

    final case class DescribeSubnetGroupsOp(
      request: DescribeSubnetGroupsRequest
    ) extends DaxOp[DescribeSubnetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSubnetGroupsResponse] =
        visitor.describeSubnetGroups(request)
    }

    final case class IncreaseReplicationFactorOp(
      request: IncreaseReplicationFactorRequest
    ) extends DaxOp[IncreaseReplicationFactorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IncreaseReplicationFactorResponse] =
        visitor.increaseReplicationFactor(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends DaxOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class RebootNodeOp(
      request: RebootNodeRequest
    ) extends DaxOp[RebootNodeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootNodeResponse] =
        visitor.rebootNode(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DaxOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DaxOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateClusterOp(
      request: UpdateClusterRequest
    ) extends DaxOp[UpdateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterResponse] =
        visitor.updateCluster(request)
    }

    final case class UpdateParameterGroupOp(
      request: UpdateParameterGroupRequest
    ) extends DaxOp[UpdateParameterGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateParameterGroupResponse] =
        visitor.updateParameterGroup(request)
    }

    final case class UpdateSubnetGroupOp(
      request: UpdateSubnetGroupRequest
    ) extends DaxOp[UpdateSubnetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSubnetGroupResponse] =
        visitor.updateSubnetGroup(request)
    }
  }

  import DaxOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DaxOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createCluster(
    request: CreateClusterRequest
  ): DaxIO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createParameterGroup(
    request: CreateParameterGroupRequest
  ): DaxIO[CreateParameterGroupResponse] =
    FF.liftF(CreateParameterGroupOp(request))

  def createSubnetGroup(
    request: CreateSubnetGroupRequest
  ): DaxIO[CreateSubnetGroupResponse] =
    FF.liftF(CreateSubnetGroupOp(request))

  def decreaseReplicationFactor(
    request: DecreaseReplicationFactorRequest
  ): DaxIO[DecreaseReplicationFactorResponse] =
    FF.liftF(DecreaseReplicationFactorOp(request))

  def deleteCluster(
    request: DeleteClusterRequest
  ): DaxIO[DeleteClusterResponse] =
    FF.liftF(DeleteClusterOp(request))

  def deleteParameterGroup(
    request: DeleteParameterGroupRequest
  ): DaxIO[DeleteParameterGroupResponse] =
    FF.liftF(DeleteParameterGroupOp(request))

  def deleteSubnetGroup(
    request: DeleteSubnetGroupRequest
  ): DaxIO[DeleteSubnetGroupResponse] =
    FF.liftF(DeleteSubnetGroupOp(request))

  def describeClusters(
    request: DescribeClustersRequest
  ): DaxIO[DescribeClustersResponse] =
    FF.liftF(DescribeClustersOp(request))

  def describeDefaultParameters(
    request: DescribeDefaultParametersRequest
  ): DaxIO[DescribeDefaultParametersResponse] =
    FF.liftF(DescribeDefaultParametersOp(request))

  def describeEvents(
    request: DescribeEventsRequest
  ): DaxIO[DescribeEventsResponse] =
    FF.liftF(DescribeEventsOp(request))

  def describeParameterGroups(
    request: DescribeParameterGroupsRequest
  ): DaxIO[DescribeParameterGroupsResponse] =
    FF.liftF(DescribeParameterGroupsOp(request))

  def describeParameters(
    request: DescribeParametersRequest
  ): DaxIO[DescribeParametersResponse] =
    FF.liftF(DescribeParametersOp(request))

  def describeSubnetGroups(
    request: DescribeSubnetGroupsRequest
  ): DaxIO[DescribeSubnetGroupsResponse] =
    FF.liftF(DescribeSubnetGroupsOp(request))

  def increaseReplicationFactor(
    request: IncreaseReplicationFactorRequest
  ): DaxIO[IncreaseReplicationFactorResponse] =
    FF.liftF(IncreaseReplicationFactorOp(request))

  def listTags(
    request: ListTagsRequest
  ): DaxIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def rebootNode(
    request: RebootNodeRequest
  ): DaxIO[RebootNodeResponse] =
    FF.liftF(RebootNodeOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DaxIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DaxIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateCluster(
    request: UpdateClusterRequest
  ): DaxIO[UpdateClusterResponse] =
    FF.liftF(UpdateClusterOp(request))

  def updateParameterGroup(
    request: UpdateParameterGroupRequest
  ): DaxIO[UpdateParameterGroupResponse] =
    FF.liftF(UpdateParameterGroupOp(request))

  def updateSubnetGroup(
    request: UpdateSubnetGroupRequest
  ): DaxIO[UpdateSubnetGroupResponse] =
    FF.liftF(UpdateSubnetGroupOp(request))
}
