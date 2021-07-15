package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.efs.EfsClient
import software.amazon.awssdk.services.efs.model._


object efs { module =>

  // Free monad over EfsOp
  type EfsIO[A] = FF[EfsOp, A]

  sealed trait EfsOp[A] {
    def visit[F[_]](visitor: EfsOp.Visitor[F]): F[A]
  }

  object EfsOp {
    // Given a EfsClient we can embed a EfsIO program in any algebra that understands embedding.
    implicit val EfsOpEmbeddable: Embeddable[EfsOp, EfsClient] = new Embeddable[EfsOp, EfsClient] {
      def embed[A](client: EfsClient, io: EfsIO[A]): Embedded[A] = Embedded.Efs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EfsOp.Visitor[Kleisli[M, EfsClient, *]] {
        def createAccessPoint(
          request: CreateAccessPointRequest
        ): Kleisli[M, EfsClient, CreateAccessPointResponse] =
          primitive(_.createAccessPoint(request))

        def createFileSystem(
          request: CreateFileSystemRequest
        ): Kleisli[M, EfsClient, CreateFileSystemResponse] =
          primitive(_.createFileSystem(request))

        def createMountTarget(
          request: CreateMountTargetRequest
        ): Kleisli[M, EfsClient, CreateMountTargetResponse] =
          primitive(_.createMountTarget(request))

        def deleteAccessPoint(
          request: DeleteAccessPointRequest
        ): Kleisli[M, EfsClient, DeleteAccessPointResponse] =
          primitive(_.deleteAccessPoint(request))

        def deleteFileSystem(
          request: DeleteFileSystemRequest
        ): Kleisli[M, EfsClient, DeleteFileSystemResponse] =
          primitive(_.deleteFileSystem(request))

        def deleteFileSystemPolicy(
          request: DeleteFileSystemPolicyRequest
        ): Kleisli[M, EfsClient, DeleteFileSystemPolicyResponse] =
          primitive(_.deleteFileSystemPolicy(request))

        def deleteMountTarget(
          request: DeleteMountTargetRequest
        ): Kleisli[M, EfsClient, DeleteMountTargetResponse] =
          primitive(_.deleteMountTarget(request))

        def describeAccessPoints(
          request: DescribeAccessPointsRequest
        ): Kleisli[M, EfsClient, DescribeAccessPointsResponse] =
          primitive(_.describeAccessPoints(request))

        def describeAccountPreferences(
          request: DescribeAccountPreferencesRequest
        ): Kleisli[M, EfsClient, DescribeAccountPreferencesResponse] =
          primitive(_.describeAccountPreferences(request))

        def describeBackupPolicy(
          request: DescribeBackupPolicyRequest
        ): Kleisli[M, EfsClient, DescribeBackupPolicyResponse] =
          primitive(_.describeBackupPolicy(request))

        def describeFileSystemPolicy(
          request: DescribeFileSystemPolicyRequest
        ): Kleisli[M, EfsClient, DescribeFileSystemPolicyResponse] =
          primitive(_.describeFileSystemPolicy(request))

        def describeFileSystems(
          request: DescribeFileSystemsRequest
        ): Kleisli[M, EfsClient, DescribeFileSystemsResponse] =
          primitive(_.describeFileSystems(request))

        def describeLifecycleConfiguration(
          request: DescribeLifecycleConfigurationRequest
        ): Kleisli[M, EfsClient, DescribeLifecycleConfigurationResponse] =
          primitive(_.describeLifecycleConfiguration(request))

        def describeMountTargetSecurityGroups(
          request: DescribeMountTargetSecurityGroupsRequest
        ): Kleisli[M, EfsClient, DescribeMountTargetSecurityGroupsResponse] =
          primitive(_.describeMountTargetSecurityGroups(request))

        def describeMountTargets(
          request: DescribeMountTargetsRequest
        ): Kleisli[M, EfsClient, DescribeMountTargetsResponse] =
          primitive(_.describeMountTargets(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EfsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def modifyMountTargetSecurityGroups(
          request: ModifyMountTargetSecurityGroupsRequest
        ): Kleisli[M, EfsClient, ModifyMountTargetSecurityGroupsResponse] =
          primitive(_.modifyMountTargetSecurityGroups(request))

        def putAccountPreferences(
          request: PutAccountPreferencesRequest
        ): Kleisli[M, EfsClient, PutAccountPreferencesResponse] =
          primitive(_.putAccountPreferences(request))

        def putBackupPolicy(
          request: PutBackupPolicyRequest
        ): Kleisli[M, EfsClient, PutBackupPolicyResponse] =
          primitive(_.putBackupPolicy(request))

        def putFileSystemPolicy(
          request: PutFileSystemPolicyRequest
        ): Kleisli[M, EfsClient, PutFileSystemPolicyResponse] =
          primitive(_.putFileSystemPolicy(request))

        def putLifecycleConfiguration(
          request: PutLifecycleConfigurationRequest
        ): Kleisli[M, EfsClient, PutLifecycleConfigurationResponse] =
          primitive(_.putLifecycleConfiguration(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EfsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EfsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFileSystem(
          request: UpdateFileSystemRequest
        ): Kleisli[M, EfsClient, UpdateFileSystemResponse] =
          primitive(_.updateFileSystem(request))

        def primitive[A](
          f: EfsClient => A
        ): Kleisli[M, EfsClient, A]
      }
    }

    trait Visitor[F[_]] extends (EfsOp ~> F) {
      final def apply[A](op: EfsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createAccessPoint(
        request: CreateAccessPointRequest
      ): F[CreateAccessPointResponse]

      def createFileSystem(
        request: CreateFileSystemRequest
      ): F[CreateFileSystemResponse]

      def createMountTarget(
        request: CreateMountTargetRequest
      ): F[CreateMountTargetResponse]

      def deleteAccessPoint(
        request: DeleteAccessPointRequest
      ): F[DeleteAccessPointResponse]

      def deleteFileSystem(
        request: DeleteFileSystemRequest
      ): F[DeleteFileSystemResponse]

      def deleteFileSystemPolicy(
        request: DeleteFileSystemPolicyRequest
      ): F[DeleteFileSystemPolicyResponse]

      def deleteMountTarget(
        request: DeleteMountTargetRequest
      ): F[DeleteMountTargetResponse]

      def describeAccessPoints(
        request: DescribeAccessPointsRequest
      ): F[DescribeAccessPointsResponse]

      def describeAccountPreferences(
        request: DescribeAccountPreferencesRequest
      ): F[DescribeAccountPreferencesResponse]

      def describeBackupPolicy(
        request: DescribeBackupPolicyRequest
      ): F[DescribeBackupPolicyResponse]

      def describeFileSystemPolicy(
        request: DescribeFileSystemPolicyRequest
      ): F[DescribeFileSystemPolicyResponse]

      def describeFileSystems(
        request: DescribeFileSystemsRequest
      ): F[DescribeFileSystemsResponse]

      def describeLifecycleConfiguration(
        request: DescribeLifecycleConfigurationRequest
      ): F[DescribeLifecycleConfigurationResponse]

      def describeMountTargetSecurityGroups(
        request: DescribeMountTargetSecurityGroupsRequest
      ): F[DescribeMountTargetSecurityGroupsResponse]

      def describeMountTargets(
        request: DescribeMountTargetsRequest
      ): F[DescribeMountTargetsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def modifyMountTargetSecurityGroups(
        request: ModifyMountTargetSecurityGroupsRequest
      ): F[ModifyMountTargetSecurityGroupsResponse]

      def putAccountPreferences(
        request: PutAccountPreferencesRequest
      ): F[PutAccountPreferencesResponse]

      def putBackupPolicy(
        request: PutBackupPolicyRequest
      ): F[PutBackupPolicyResponse]

      def putFileSystemPolicy(
        request: PutFileSystemPolicyRequest
      ): F[PutFileSystemPolicyResponse]

      def putLifecycleConfiguration(
        request: PutLifecycleConfigurationRequest
      ): F[PutLifecycleConfigurationResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateFileSystem(
        request: UpdateFileSystemRequest
      ): F[UpdateFileSystemResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EfsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAccessPointOp(
      request: CreateAccessPointRequest
    ) extends EfsOp[CreateAccessPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessPointResponse] =
        visitor.createAccessPoint(request)
    }

    final case class CreateFileSystemOp(
      request: CreateFileSystemRequest
    ) extends EfsOp[CreateFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFileSystemResponse] =
        visitor.createFileSystem(request)
    }

    final case class CreateMountTargetOp(
      request: CreateMountTargetRequest
    ) extends EfsOp[CreateMountTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMountTargetResponse] =
        visitor.createMountTarget(request)
    }

    final case class DeleteAccessPointOp(
      request: DeleteAccessPointRequest
    ) extends EfsOp[DeleteAccessPointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessPointResponse] =
        visitor.deleteAccessPoint(request)
    }

    final case class DeleteFileSystemOp(
      request: DeleteFileSystemRequest
    ) extends EfsOp[DeleteFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFileSystemResponse] =
        visitor.deleteFileSystem(request)
    }

    final case class DeleteFileSystemPolicyOp(
      request: DeleteFileSystemPolicyRequest
    ) extends EfsOp[DeleteFileSystemPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFileSystemPolicyResponse] =
        visitor.deleteFileSystemPolicy(request)
    }

    final case class DeleteMountTargetOp(
      request: DeleteMountTargetRequest
    ) extends EfsOp[DeleteMountTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMountTargetResponse] =
        visitor.deleteMountTarget(request)
    }

    final case class DescribeAccessPointsOp(
      request: DescribeAccessPointsRequest
    ) extends EfsOp[DescribeAccessPointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccessPointsResponse] =
        visitor.describeAccessPoints(request)
    }

    final case class DescribeAccountPreferencesOp(
      request: DescribeAccountPreferencesRequest
    ) extends EfsOp[DescribeAccountPreferencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountPreferencesResponse] =
        visitor.describeAccountPreferences(request)
    }

    final case class DescribeBackupPolicyOp(
      request: DescribeBackupPolicyRequest
    ) extends EfsOp[DescribeBackupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupPolicyResponse] =
        visitor.describeBackupPolicy(request)
    }

    final case class DescribeFileSystemPolicyOp(
      request: DescribeFileSystemPolicyRequest
    ) extends EfsOp[DescribeFileSystemPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFileSystemPolicyResponse] =
        visitor.describeFileSystemPolicy(request)
    }

    final case class DescribeFileSystemsOp(
      request: DescribeFileSystemsRequest
    ) extends EfsOp[DescribeFileSystemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFileSystemsResponse] =
        visitor.describeFileSystems(request)
    }

    final case class DescribeLifecycleConfigurationOp(
      request: DescribeLifecycleConfigurationRequest
    ) extends EfsOp[DescribeLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLifecycleConfigurationResponse] =
        visitor.describeLifecycleConfiguration(request)
    }

    final case class DescribeMountTargetSecurityGroupsOp(
      request: DescribeMountTargetSecurityGroupsRequest
    ) extends EfsOp[DescribeMountTargetSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMountTargetSecurityGroupsResponse] =
        visitor.describeMountTargetSecurityGroups(request)
    }

    final case class DescribeMountTargetsOp(
      request: DescribeMountTargetsRequest
    ) extends EfsOp[DescribeMountTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMountTargetsResponse] =
        visitor.describeMountTargets(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EfsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ModifyMountTargetSecurityGroupsOp(
      request: ModifyMountTargetSecurityGroupsRequest
    ) extends EfsOp[ModifyMountTargetSecurityGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyMountTargetSecurityGroupsResponse] =
        visitor.modifyMountTargetSecurityGroups(request)
    }

    final case class PutAccountPreferencesOp(
      request: PutAccountPreferencesRequest
    ) extends EfsOp[PutAccountPreferencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountPreferencesResponse] =
        visitor.putAccountPreferences(request)
    }

    final case class PutBackupPolicyOp(
      request: PutBackupPolicyRequest
    ) extends EfsOp[PutBackupPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBackupPolicyResponse] =
        visitor.putBackupPolicy(request)
    }

    final case class PutFileSystemPolicyOp(
      request: PutFileSystemPolicyRequest
    ) extends EfsOp[PutFileSystemPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFileSystemPolicyResponse] =
        visitor.putFileSystemPolicy(request)
    }

    final case class PutLifecycleConfigurationOp(
      request: PutLifecycleConfigurationRequest
    ) extends EfsOp[PutLifecycleConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLifecycleConfigurationResponse] =
        visitor.putLifecycleConfiguration(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EfsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EfsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFileSystemOp(
      request: UpdateFileSystemRequest
    ) extends EfsOp[UpdateFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFileSystemResponse] =
        visitor.updateFileSystem(request)
    }
  }

  import EfsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EfsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createAccessPoint(
    request: CreateAccessPointRequest
  ): EfsIO[CreateAccessPointResponse] =
    FF.liftF(CreateAccessPointOp(request))

  def createFileSystem(
    request: CreateFileSystemRequest
  ): EfsIO[CreateFileSystemResponse] =
    FF.liftF(CreateFileSystemOp(request))

  def createMountTarget(
    request: CreateMountTargetRequest
  ): EfsIO[CreateMountTargetResponse] =
    FF.liftF(CreateMountTargetOp(request))

  def deleteAccessPoint(
    request: DeleteAccessPointRequest
  ): EfsIO[DeleteAccessPointResponse] =
    FF.liftF(DeleteAccessPointOp(request))

  def deleteFileSystem(
    request: DeleteFileSystemRequest
  ): EfsIO[DeleteFileSystemResponse] =
    FF.liftF(DeleteFileSystemOp(request))

  def deleteFileSystemPolicy(
    request: DeleteFileSystemPolicyRequest
  ): EfsIO[DeleteFileSystemPolicyResponse] =
    FF.liftF(DeleteFileSystemPolicyOp(request))

  def deleteMountTarget(
    request: DeleteMountTargetRequest
  ): EfsIO[DeleteMountTargetResponse] =
    FF.liftF(DeleteMountTargetOp(request))

  def describeAccessPoints(
    request: DescribeAccessPointsRequest
  ): EfsIO[DescribeAccessPointsResponse] =
    FF.liftF(DescribeAccessPointsOp(request))

  def describeAccountPreferences(
    request: DescribeAccountPreferencesRequest
  ): EfsIO[DescribeAccountPreferencesResponse] =
    FF.liftF(DescribeAccountPreferencesOp(request))

  def describeBackupPolicy(
    request: DescribeBackupPolicyRequest
  ): EfsIO[DescribeBackupPolicyResponse] =
    FF.liftF(DescribeBackupPolicyOp(request))

  def describeFileSystemPolicy(
    request: DescribeFileSystemPolicyRequest
  ): EfsIO[DescribeFileSystemPolicyResponse] =
    FF.liftF(DescribeFileSystemPolicyOp(request))

  def describeFileSystems(
    request: DescribeFileSystemsRequest
  ): EfsIO[DescribeFileSystemsResponse] =
    FF.liftF(DescribeFileSystemsOp(request))

  def describeLifecycleConfiguration(
    request: DescribeLifecycleConfigurationRequest
  ): EfsIO[DescribeLifecycleConfigurationResponse] =
    FF.liftF(DescribeLifecycleConfigurationOp(request))

  def describeMountTargetSecurityGroups(
    request: DescribeMountTargetSecurityGroupsRequest
  ): EfsIO[DescribeMountTargetSecurityGroupsResponse] =
    FF.liftF(DescribeMountTargetSecurityGroupsOp(request))

  def describeMountTargets(
    request: DescribeMountTargetsRequest
  ): EfsIO[DescribeMountTargetsResponse] =
    FF.liftF(DescribeMountTargetsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EfsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def modifyMountTargetSecurityGroups(
    request: ModifyMountTargetSecurityGroupsRequest
  ): EfsIO[ModifyMountTargetSecurityGroupsResponse] =
    FF.liftF(ModifyMountTargetSecurityGroupsOp(request))

  def putAccountPreferences(
    request: PutAccountPreferencesRequest
  ): EfsIO[PutAccountPreferencesResponse] =
    FF.liftF(PutAccountPreferencesOp(request))

  def putBackupPolicy(
    request: PutBackupPolicyRequest
  ): EfsIO[PutBackupPolicyResponse] =
    FF.liftF(PutBackupPolicyOp(request))

  def putFileSystemPolicy(
    request: PutFileSystemPolicyRequest
  ): EfsIO[PutFileSystemPolicyResponse] =
    FF.liftF(PutFileSystemPolicyOp(request))

  def putLifecycleConfiguration(
    request: PutLifecycleConfigurationRequest
  ): EfsIO[PutLifecycleConfigurationResponse] =
    FF.liftF(PutLifecycleConfigurationOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EfsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EfsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFileSystem(
    request: UpdateFileSystemRequest
  ): EfsIO[UpdateFileSystemResponse] =
    FF.liftF(UpdateFileSystemOp(request))
}
