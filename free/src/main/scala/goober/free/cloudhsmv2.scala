package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudhsmv2.CloudHsmV2Client
import software.amazon.awssdk.services.cloudhsmv2.model._


object cloudhsmv2 { module =>

  // Free monad over CloudHsmV2Op
  type CloudHsmV2IO[A] = FF[CloudHsmV2Op, A]

  sealed trait CloudHsmV2Op[A] {
    def visit[F[_]](visitor: CloudHsmV2Op.Visitor[F]): F[A]
  }

  object CloudHsmV2Op {
    // Given a CloudHsmV2Client we can embed a CloudHsmV2IO program in any algebra that understands embedding.
    implicit val CloudHsmV2OpEmbeddable: Embeddable[CloudHsmV2Op, CloudHsmV2Client] = new Embeddable[CloudHsmV2Op, CloudHsmV2Client] {
      def embed[A](client: CloudHsmV2Client, io: CloudHsmV2IO[A]): Embedded[A] = Embedded.CloudHsmV2(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudHsmV2Op.Visitor[Kleisli[M, CloudHsmV2Client, *]] {
        def copyBackupToRegion(
          request: CopyBackupToRegionRequest
        ): Kleisli[M, CloudHsmV2Client, CopyBackupToRegionResponse] =
          primitive(_.copyBackupToRegion(request))

        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, CloudHsmV2Client, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createHsm(
          request: CreateHsmRequest
        ): Kleisli[M, CloudHsmV2Client, CreateHsmResponse] =
          primitive(_.createHsm(request))

        def deleteBackup(
          request: DeleteBackupRequest
        ): Kleisli[M, CloudHsmV2Client, DeleteBackupResponse] =
          primitive(_.deleteBackup(request))

        def deleteCluster(
          request: DeleteClusterRequest
        ): Kleisli[M, CloudHsmV2Client, DeleteClusterResponse] =
          primitive(_.deleteCluster(request))

        def deleteHsm(
          request: DeleteHsmRequest
        ): Kleisli[M, CloudHsmV2Client, DeleteHsmResponse] =
          primitive(_.deleteHsm(request))

        def describeBackups(
          request: DescribeBackupsRequest
        ): Kleisli[M, CloudHsmV2Client, DescribeBackupsResponse] =
          primitive(_.describeBackups(request))

        def describeClusters(
          request: DescribeClustersRequest
        ): Kleisli[M, CloudHsmV2Client, DescribeClustersResponse] =
          primitive(_.describeClusters(request))

        def initializeCluster(
          request: InitializeClusterRequest
        ): Kleisli[M, CloudHsmV2Client, InitializeClusterResponse] =
          primitive(_.initializeCluster(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, CloudHsmV2Client, ListTagsResponse] =
          primitive(_.listTags(request))

        def modifyBackupAttributes(
          request: ModifyBackupAttributesRequest
        ): Kleisli[M, CloudHsmV2Client, ModifyBackupAttributesResponse] =
          primitive(_.modifyBackupAttributes(request))

        def modifyCluster(
          request: ModifyClusterRequest
        ): Kleisli[M, CloudHsmV2Client, ModifyClusterResponse] =
          primitive(_.modifyCluster(request))

        def restoreBackup(
          request: RestoreBackupRequest
        ): Kleisli[M, CloudHsmV2Client, RestoreBackupResponse] =
          primitive(_.restoreBackup(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CloudHsmV2Client, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CloudHsmV2Client, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: CloudHsmV2Client => A
        ): Kleisli[M, CloudHsmV2Client, A]
      }
    }

    trait Visitor[F[_]] extends (CloudHsmV2Op ~> F) {
      final def apply[A](op: CloudHsmV2Op[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def copyBackupToRegion(
        request: CopyBackupToRegionRequest
      ): F[CopyBackupToRegionResponse]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createHsm(
        request: CreateHsmRequest
      ): F[CreateHsmResponse]

      def deleteBackup(
        request: DeleteBackupRequest
      ): F[DeleteBackupResponse]

      def deleteCluster(
        request: DeleteClusterRequest
      ): F[DeleteClusterResponse]

      def deleteHsm(
        request: DeleteHsmRequest
      ): F[DeleteHsmResponse]

      def describeBackups(
        request: DescribeBackupsRequest
      ): F[DescribeBackupsResponse]

      def describeClusters(
        request: DescribeClustersRequest
      ): F[DescribeClustersResponse]

      def initializeCluster(
        request: InitializeClusterRequest
      ): F[InitializeClusterResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def modifyBackupAttributes(
        request: ModifyBackupAttributesRequest
      ): F[ModifyBackupAttributesResponse]

      def modifyCluster(
        request: ModifyClusterRequest
      ): F[ModifyClusterResponse]

      def restoreBackup(
        request: RestoreBackupRequest
      ): F[RestoreBackupResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudHsmV2Op[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CopyBackupToRegionOp(
      request: CopyBackupToRegionRequest
    ) extends CloudHsmV2Op[CopyBackupToRegionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyBackupToRegionResponse] =
        visitor.copyBackupToRegion(request)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends CloudHsmV2Op[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateHsmOp(
      request: CreateHsmRequest
    ) extends CloudHsmV2Op[CreateHsmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateHsmResponse] =
        visitor.createHsm(request)
    }

    final case class DeleteBackupOp(
      request: DeleteBackupRequest
    ) extends CloudHsmV2Op[DeleteBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupResponse] =
        visitor.deleteBackup(request)
    }

    final case class DeleteClusterOp(
      request: DeleteClusterRequest
    ) extends CloudHsmV2Op[DeleteClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterResponse] =
        visitor.deleteCluster(request)
    }

    final case class DeleteHsmOp(
      request: DeleteHsmRequest
    ) extends CloudHsmV2Op[DeleteHsmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteHsmResponse] =
        visitor.deleteHsm(request)
    }

    final case class DescribeBackupsOp(
      request: DescribeBackupsRequest
    ) extends CloudHsmV2Op[DescribeBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupsResponse] =
        visitor.describeBackups(request)
    }

    final case class DescribeClustersOp(
      request: DescribeClustersRequest
    ) extends CloudHsmV2Op[DescribeClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClustersResponse] =
        visitor.describeClusters(request)
    }

    final case class InitializeClusterOp(
      request: InitializeClusterRequest
    ) extends CloudHsmV2Op[InitializeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InitializeClusterResponse] =
        visitor.initializeCluster(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends CloudHsmV2Op[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class ModifyBackupAttributesOp(
      request: ModifyBackupAttributesRequest
    ) extends CloudHsmV2Op[ModifyBackupAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyBackupAttributesResponse] =
        visitor.modifyBackupAttributes(request)
    }

    final case class ModifyClusterOp(
      request: ModifyClusterRequest
    ) extends CloudHsmV2Op[ModifyClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterResponse] =
        visitor.modifyCluster(request)
    }

    final case class RestoreBackupOp(
      request: RestoreBackupRequest
    ) extends CloudHsmV2Op[RestoreBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreBackupResponse] =
        visitor.restoreBackup(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CloudHsmV2Op[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CloudHsmV2Op[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import CloudHsmV2Op._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudHsmV2Op, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def copyBackupToRegion(
    request: CopyBackupToRegionRequest
  ): CloudHsmV2IO[CopyBackupToRegionResponse] =
    FF.liftF(CopyBackupToRegionOp(request))

  def createCluster(
    request: CreateClusterRequest
  ): CloudHsmV2IO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createHsm(
    request: CreateHsmRequest
  ): CloudHsmV2IO[CreateHsmResponse] =
    FF.liftF(CreateHsmOp(request))

  def deleteBackup(
    request: DeleteBackupRequest
  ): CloudHsmV2IO[DeleteBackupResponse] =
    FF.liftF(DeleteBackupOp(request))

  def deleteCluster(
    request: DeleteClusterRequest
  ): CloudHsmV2IO[DeleteClusterResponse] =
    FF.liftF(DeleteClusterOp(request))

  def deleteHsm(
    request: DeleteHsmRequest
  ): CloudHsmV2IO[DeleteHsmResponse] =
    FF.liftF(DeleteHsmOp(request))

  def describeBackups(
    request: DescribeBackupsRequest
  ): CloudHsmV2IO[DescribeBackupsResponse] =
    FF.liftF(DescribeBackupsOp(request))

  def describeClusters(
    request: DescribeClustersRequest
  ): CloudHsmV2IO[DescribeClustersResponse] =
    FF.liftF(DescribeClustersOp(request))

  def initializeCluster(
    request: InitializeClusterRequest
  ): CloudHsmV2IO[InitializeClusterResponse] =
    FF.liftF(InitializeClusterOp(request))

  def listTags(
    request: ListTagsRequest
  ): CloudHsmV2IO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def modifyBackupAttributes(
    request: ModifyBackupAttributesRequest
  ): CloudHsmV2IO[ModifyBackupAttributesResponse] =
    FF.liftF(ModifyBackupAttributesOp(request))

  def modifyCluster(
    request: ModifyClusterRequest
  ): CloudHsmV2IO[ModifyClusterResponse] =
    FF.liftF(ModifyClusterOp(request))

  def restoreBackup(
    request: RestoreBackupRequest
  ): CloudHsmV2IO[RestoreBackupResponse] =
    FF.liftF(RestoreBackupOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CloudHsmV2IO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CloudHsmV2IO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
