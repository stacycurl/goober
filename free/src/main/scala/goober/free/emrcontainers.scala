package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.emrcontainers.EmrContainersClient
import software.amazon.awssdk.services.emrcontainers.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object emrcontainers { module =>

  // Free monad over EmrContainersOp
  type EmrContainersIO[A] = FF[EmrContainersOp, A]

  sealed trait EmrContainersOp[A] {
    def visit[F[_]](visitor: EmrContainersOp.Visitor[F]): F[A]
  }

  object EmrContainersOp {
    // Given a EmrContainersClient we can embed a EmrContainersIO program in any algebra that understands embedding.
    implicit val EmrContainersOpEmbeddable: Embeddable[EmrContainersOp, EmrContainersClient] = new Embeddable[EmrContainersOp, EmrContainersClient] {
      def embed[A](client: EmrContainersClient, io: EmrContainersIO[A]): Embedded[A] = Embedded.EmrContainers(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EmrContainersOp.Visitor[Kleisli[M, EmrContainersClient, *]] {
        def cancelJobRun(
          request: CancelJobRunRequest
        ): Kleisli[M, EmrContainersClient, CancelJobRunResponse] =
          primitive(_.cancelJobRun(request))

        def createManagedEndpoint(
          request: CreateManagedEndpointRequest
        ): Kleisli[M, EmrContainersClient, CreateManagedEndpointResponse] =
          primitive(_.createManagedEndpoint(request))

        def createVirtualCluster(
          request: CreateVirtualClusterRequest
        ): Kleisli[M, EmrContainersClient, CreateVirtualClusterResponse] =
          primitive(_.createVirtualCluster(request))

        def deleteManagedEndpoint(
          request: DeleteManagedEndpointRequest
        ): Kleisli[M, EmrContainersClient, DeleteManagedEndpointResponse] =
          primitive(_.deleteManagedEndpoint(request))

        def deleteVirtualCluster(
          request: DeleteVirtualClusterRequest
        ): Kleisli[M, EmrContainersClient, DeleteVirtualClusterResponse] =
          primitive(_.deleteVirtualCluster(request))

        def describeJobRun(
          request: DescribeJobRunRequest
        ): Kleisli[M, EmrContainersClient, DescribeJobRunResponse] =
          primitive(_.describeJobRun(request))

        def describeManagedEndpoint(
          request: DescribeManagedEndpointRequest
        ): Kleisli[M, EmrContainersClient, DescribeManagedEndpointResponse] =
          primitive(_.describeManagedEndpoint(request))

        def describeVirtualCluster(
          request: DescribeVirtualClusterRequest
        ): Kleisli[M, EmrContainersClient, DescribeVirtualClusterResponse] =
          primitive(_.describeVirtualCluster(request))

        def listJobRuns(
          request: ListJobRunsRequest
        ): Kleisli[M, EmrContainersClient, ListJobRunsResponse] =
          primitive(_.listJobRuns(request))

        def listManagedEndpoints(
          request: ListManagedEndpointsRequest
        ): Kleisli[M, EmrContainersClient, ListManagedEndpointsResponse] =
          primitive(_.listManagedEndpoints(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EmrContainersClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listVirtualClusters(
          request: ListVirtualClustersRequest
        ): Kleisli[M, EmrContainersClient, ListVirtualClustersResponse] =
          primitive(_.listVirtualClusters(request))

        def startJobRun(
          request: StartJobRunRequest
        ): Kleisli[M, EmrContainersClient, StartJobRunResponse] =
          primitive(_.startJobRun(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EmrContainersClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EmrContainersClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: EmrContainersClient => A
        ): Kleisli[M, EmrContainersClient, A]
      }
    }

    trait Visitor[F[_]] extends (EmrContainersOp ~> F) {
      final def apply[A](op: EmrContainersOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelJobRun(
        request: CancelJobRunRequest
      ): F[CancelJobRunResponse]

      def createManagedEndpoint(
        request: CreateManagedEndpointRequest
      ): F[CreateManagedEndpointResponse]

      def createVirtualCluster(
        request: CreateVirtualClusterRequest
      ): F[CreateVirtualClusterResponse]

      def deleteManagedEndpoint(
        request: DeleteManagedEndpointRequest
      ): F[DeleteManagedEndpointResponse]

      def deleteVirtualCluster(
        request: DeleteVirtualClusterRequest
      ): F[DeleteVirtualClusterResponse]

      def describeJobRun(
        request: DescribeJobRunRequest
      ): F[DescribeJobRunResponse]

      def describeManagedEndpoint(
        request: DescribeManagedEndpointRequest
      ): F[DescribeManagedEndpointResponse]

      def describeVirtualCluster(
        request: DescribeVirtualClusterRequest
      ): F[DescribeVirtualClusterResponse]

      def listJobRuns(
        request: ListJobRunsRequest
      ): F[ListJobRunsResponse]

      def listManagedEndpoints(
        request: ListManagedEndpointsRequest
      ): F[ListManagedEndpointsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listVirtualClusters(
        request: ListVirtualClustersRequest
      ): F[ListVirtualClustersResponse]

      def startJobRun(
        request: StartJobRunRequest
      ): F[StartJobRunResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EmrContainersOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelJobRunOp(
      request: CancelJobRunRequest
    ) extends EmrContainersOp[CancelJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobRunResponse] =
        visitor.cancelJobRun(request)
    }

    final case class CreateManagedEndpointOp(
      request: CreateManagedEndpointRequest
    ) extends EmrContainersOp[CreateManagedEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateManagedEndpointResponse] =
        visitor.createManagedEndpoint(request)
    }

    final case class CreateVirtualClusterOp(
      request: CreateVirtualClusterRequest
    ) extends EmrContainersOp[CreateVirtualClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVirtualClusterResponse] =
        visitor.createVirtualCluster(request)
    }

    final case class DeleteManagedEndpointOp(
      request: DeleteManagedEndpointRequest
    ) extends EmrContainersOp[DeleteManagedEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteManagedEndpointResponse] =
        visitor.deleteManagedEndpoint(request)
    }

    final case class DeleteVirtualClusterOp(
      request: DeleteVirtualClusterRequest
    ) extends EmrContainersOp[DeleteVirtualClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVirtualClusterResponse] =
        visitor.deleteVirtualCluster(request)
    }

    final case class DescribeJobRunOp(
      request: DescribeJobRunRequest
    ) extends EmrContainersOp[DescribeJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobRunResponse] =
        visitor.describeJobRun(request)
    }

    final case class DescribeManagedEndpointOp(
      request: DescribeManagedEndpointRequest
    ) extends EmrContainersOp[DescribeManagedEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeManagedEndpointResponse] =
        visitor.describeManagedEndpoint(request)
    }

    final case class DescribeVirtualClusterOp(
      request: DescribeVirtualClusterRequest
    ) extends EmrContainersOp[DescribeVirtualClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVirtualClusterResponse] =
        visitor.describeVirtualCluster(request)
    }

    final case class ListJobRunsOp(
      request: ListJobRunsRequest
    ) extends EmrContainersOp[ListJobRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobRunsResponse] =
        visitor.listJobRuns(request)
    }

    final case class ListManagedEndpointsOp(
      request: ListManagedEndpointsRequest
    ) extends EmrContainersOp[ListManagedEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListManagedEndpointsResponse] =
        visitor.listManagedEndpoints(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EmrContainersOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListVirtualClustersOp(
      request: ListVirtualClustersRequest
    ) extends EmrContainersOp[ListVirtualClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVirtualClustersResponse] =
        visitor.listVirtualClusters(request)
    }

    final case class StartJobRunOp(
      request: StartJobRunRequest
    ) extends EmrContainersOp[StartJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartJobRunResponse] =
        visitor.startJobRun(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EmrContainersOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EmrContainersOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import EmrContainersOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EmrContainersOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelJobRun(
    request: CancelJobRunRequest
  ): EmrContainersIO[CancelJobRunResponse] =
    FF.liftF(CancelJobRunOp(request))

  def createManagedEndpoint(
    request: CreateManagedEndpointRequest
  ): EmrContainersIO[CreateManagedEndpointResponse] =
    FF.liftF(CreateManagedEndpointOp(request))

  def createVirtualCluster(
    request: CreateVirtualClusterRequest
  ): EmrContainersIO[CreateVirtualClusterResponse] =
    FF.liftF(CreateVirtualClusterOp(request))

  def deleteManagedEndpoint(
    request: DeleteManagedEndpointRequest
  ): EmrContainersIO[DeleteManagedEndpointResponse] =
    FF.liftF(DeleteManagedEndpointOp(request))

  def deleteVirtualCluster(
    request: DeleteVirtualClusterRequest
  ): EmrContainersIO[DeleteVirtualClusterResponse] =
    FF.liftF(DeleteVirtualClusterOp(request))

  def describeJobRun(
    request: DescribeJobRunRequest
  ): EmrContainersIO[DescribeJobRunResponse] =
    FF.liftF(DescribeJobRunOp(request))

  def describeManagedEndpoint(
    request: DescribeManagedEndpointRequest
  ): EmrContainersIO[DescribeManagedEndpointResponse] =
    FF.liftF(DescribeManagedEndpointOp(request))

  def describeVirtualCluster(
    request: DescribeVirtualClusterRequest
  ): EmrContainersIO[DescribeVirtualClusterResponse] =
    FF.liftF(DescribeVirtualClusterOp(request))

  def listJobRuns(
    request: ListJobRunsRequest
  ): EmrContainersIO[ListJobRunsResponse] =
    FF.liftF(ListJobRunsOp(request))

  def listManagedEndpoints(
    request: ListManagedEndpointsRequest
  ): EmrContainersIO[ListManagedEndpointsResponse] =
    FF.liftF(ListManagedEndpointsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EmrContainersIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listVirtualClusters(
    request: ListVirtualClustersRequest
  ): EmrContainersIO[ListVirtualClustersResponse] =
    FF.liftF(ListVirtualClustersOp(request))

  def startJobRun(
    request: StartJobRunRequest
  ): EmrContainersIO[StartJobRunResponse] =
    FF.liftF(StartJobRunOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EmrContainersIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EmrContainersIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
