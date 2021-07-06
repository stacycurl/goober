package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.fsx.FSxClient
import software.amazon.awssdk.services.fsx.model._


object fsx { module =>

  // Free monad over FSxOp
  type FSxIO[A] = FF[FSxOp, A]

  sealed trait FSxOp[A] {
    def visit[F[_]](visitor: FSxOp.Visitor[F]): F[A]
  }

  object FSxOp {
    // Given a FSxClient we can embed a FSxIO program in any algebra that understands embedding.
    implicit val FSxOpEmbeddable: Embeddable[FSxOp, FSxClient] = new Embeddable[FSxOp, FSxClient] {
      def embed[A](client: FSxClient, io: FSxIO[A]): Embedded[A] = Embedded.FSx(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends FSxOp.Visitor[Kleisli[M, FSxClient, *]] {
        def associateFileSystemAliases(
          request: AssociateFileSystemAliasesRequest
        ): Kleisli[M, FSxClient, AssociateFileSystemAliasesResponse] =
          primitive(_.associateFileSystemAliases(request))

        def cancelDataRepositoryTask(
          request: CancelDataRepositoryTaskRequest
        ): Kleisli[M, FSxClient, CancelDataRepositoryTaskResponse] =
          primitive(_.cancelDataRepositoryTask(request))

        def copyBackup(
          request: CopyBackupRequest
        ): Kleisli[M, FSxClient, CopyBackupResponse] =
          primitive(_.copyBackup(request))

        def createBackup(
          request: CreateBackupRequest
        ): Kleisli[M, FSxClient, CreateBackupResponse] =
          primitive(_.createBackup(request))

        def createDataRepositoryTask(
          request: CreateDataRepositoryTaskRequest
        ): Kleisli[M, FSxClient, CreateDataRepositoryTaskResponse] =
          primitive(_.createDataRepositoryTask(request))

        def createFileSystem(
          request: CreateFileSystemRequest
        ): Kleisli[M, FSxClient, CreateFileSystemResponse] =
          primitive(_.createFileSystem(request))

        def createFileSystemFromBackup(
          request: CreateFileSystemFromBackupRequest
        ): Kleisli[M, FSxClient, CreateFileSystemFromBackupResponse] =
          primitive(_.createFileSystemFromBackup(request))

        def deleteBackup(
          request: DeleteBackupRequest
        ): Kleisli[M, FSxClient, DeleteBackupResponse] =
          primitive(_.deleteBackup(request))

        def deleteFileSystem(
          request: DeleteFileSystemRequest
        ): Kleisli[M, FSxClient, DeleteFileSystemResponse] =
          primitive(_.deleteFileSystem(request))

        def describeBackups(
          request: DescribeBackupsRequest
        ): Kleisli[M, FSxClient, DescribeBackupsResponse] =
          primitive(_.describeBackups(request))

        def describeDataRepositoryTasks(
          request: DescribeDataRepositoryTasksRequest
        ): Kleisli[M, FSxClient, DescribeDataRepositoryTasksResponse] =
          primitive(_.describeDataRepositoryTasks(request))

        def describeFileSystemAliases(
          request: DescribeFileSystemAliasesRequest
        ): Kleisli[M, FSxClient, DescribeFileSystemAliasesResponse] =
          primitive(_.describeFileSystemAliases(request))

        def describeFileSystems(
          request: DescribeFileSystemsRequest
        ): Kleisli[M, FSxClient, DescribeFileSystemsResponse] =
          primitive(_.describeFileSystems(request))

        def disassociateFileSystemAliases(
          request: DisassociateFileSystemAliasesRequest
        ): Kleisli[M, FSxClient, DisassociateFileSystemAliasesResponse] =
          primitive(_.disassociateFileSystemAliases(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, FSxClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, FSxClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, FSxClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateFileSystem(
          request: UpdateFileSystemRequest
        ): Kleisli[M, FSxClient, UpdateFileSystemResponse] =
          primitive(_.updateFileSystem(request))

        def primitive[A](
          f: FSxClient => A
        ): Kleisli[M, FSxClient, A]
      }
    }

    trait Visitor[F[_]] extends (FSxOp ~> F) {
      final def apply[A](op: FSxOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateFileSystemAliases(
        request: AssociateFileSystemAliasesRequest
      ): F[AssociateFileSystemAliasesResponse]

      def cancelDataRepositoryTask(
        request: CancelDataRepositoryTaskRequest
      ): F[CancelDataRepositoryTaskResponse]

      def copyBackup(
        request: CopyBackupRequest
      ): F[CopyBackupResponse]

      def createBackup(
        request: CreateBackupRequest
      ): F[CreateBackupResponse]

      def createDataRepositoryTask(
        request: CreateDataRepositoryTaskRequest
      ): F[CreateDataRepositoryTaskResponse]

      def createFileSystem(
        request: CreateFileSystemRequest
      ): F[CreateFileSystemResponse]

      def createFileSystemFromBackup(
        request: CreateFileSystemFromBackupRequest
      ): F[CreateFileSystemFromBackupResponse]

      def deleteBackup(
        request: DeleteBackupRequest
      ): F[DeleteBackupResponse]

      def deleteFileSystem(
        request: DeleteFileSystemRequest
      ): F[DeleteFileSystemResponse]

      def describeBackups(
        request: DescribeBackupsRequest
      ): F[DescribeBackupsResponse]

      def describeDataRepositoryTasks(
        request: DescribeDataRepositoryTasksRequest
      ): F[DescribeDataRepositoryTasksResponse]

      def describeFileSystemAliases(
        request: DescribeFileSystemAliasesRequest
      ): F[DescribeFileSystemAliasesResponse]

      def describeFileSystems(
        request: DescribeFileSystemsRequest
      ): F[DescribeFileSystemsResponse]

      def disassociateFileSystemAliases(
        request: DisassociateFileSystemAliasesRequest
      ): F[DisassociateFileSystemAliasesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

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
    ) extends FSxOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateFileSystemAliasesOp(
      request: AssociateFileSystemAliasesRequest
    ) extends FSxOp[AssociateFileSystemAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateFileSystemAliasesResponse] =
        visitor.associateFileSystemAliases(request)
    }

    final case class CancelDataRepositoryTaskOp(
      request: CancelDataRepositoryTaskRequest
    ) extends FSxOp[CancelDataRepositoryTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelDataRepositoryTaskResponse] =
        visitor.cancelDataRepositoryTask(request)
    }

    final case class CopyBackupOp(
      request: CopyBackupRequest
    ) extends FSxOp[CopyBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyBackupResponse] =
        visitor.copyBackup(request)
    }

    final case class CreateBackupOp(
      request: CreateBackupRequest
    ) extends FSxOp[CreateBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBackupResponse] =
        visitor.createBackup(request)
    }

    final case class CreateDataRepositoryTaskOp(
      request: CreateDataRepositoryTaskRequest
    ) extends FSxOp[CreateDataRepositoryTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataRepositoryTaskResponse] =
        visitor.createDataRepositoryTask(request)
    }

    final case class CreateFileSystemOp(
      request: CreateFileSystemRequest
    ) extends FSxOp[CreateFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFileSystemResponse] =
        visitor.createFileSystem(request)
    }

    final case class CreateFileSystemFromBackupOp(
      request: CreateFileSystemFromBackupRequest
    ) extends FSxOp[CreateFileSystemFromBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFileSystemFromBackupResponse] =
        visitor.createFileSystemFromBackup(request)
    }

    final case class DeleteBackupOp(
      request: DeleteBackupRequest
    ) extends FSxOp[DeleteBackupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBackupResponse] =
        visitor.deleteBackup(request)
    }

    final case class DeleteFileSystemOp(
      request: DeleteFileSystemRequest
    ) extends FSxOp[DeleteFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFileSystemResponse] =
        visitor.deleteFileSystem(request)
    }

    final case class DescribeBackupsOp(
      request: DescribeBackupsRequest
    ) extends FSxOp[DescribeBackupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBackupsResponse] =
        visitor.describeBackups(request)
    }

    final case class DescribeDataRepositoryTasksOp(
      request: DescribeDataRepositoryTasksRequest
    ) extends FSxOp[DescribeDataRepositoryTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataRepositoryTasksResponse] =
        visitor.describeDataRepositoryTasks(request)
    }

    final case class DescribeFileSystemAliasesOp(
      request: DescribeFileSystemAliasesRequest
    ) extends FSxOp[DescribeFileSystemAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFileSystemAliasesResponse] =
        visitor.describeFileSystemAliases(request)
    }

    final case class DescribeFileSystemsOp(
      request: DescribeFileSystemsRequest
    ) extends FSxOp[DescribeFileSystemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFileSystemsResponse] =
        visitor.describeFileSystems(request)
    }

    final case class DisassociateFileSystemAliasesOp(
      request: DisassociateFileSystemAliasesRequest
    ) extends FSxOp[DisassociateFileSystemAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateFileSystemAliasesResponse] =
        visitor.disassociateFileSystemAliases(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends FSxOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends FSxOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends FSxOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateFileSystemOp(
      request: UpdateFileSystemRequest
    ) extends FSxOp[UpdateFileSystemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFileSystemResponse] =
        visitor.updateFileSystem(request)
    }
  }

  import FSxOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[FSxOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateFileSystemAliases(
    request: AssociateFileSystemAliasesRequest
  ): FSxIO[AssociateFileSystemAliasesResponse] =
    FF.liftF(AssociateFileSystemAliasesOp(request))

  def cancelDataRepositoryTask(
    request: CancelDataRepositoryTaskRequest
  ): FSxIO[CancelDataRepositoryTaskResponse] =
    FF.liftF(CancelDataRepositoryTaskOp(request))

  def copyBackup(
    request: CopyBackupRequest
  ): FSxIO[CopyBackupResponse] =
    FF.liftF(CopyBackupOp(request))

  def createBackup(
    request: CreateBackupRequest
  ): FSxIO[CreateBackupResponse] =
    FF.liftF(CreateBackupOp(request))

  def createDataRepositoryTask(
    request: CreateDataRepositoryTaskRequest
  ): FSxIO[CreateDataRepositoryTaskResponse] =
    FF.liftF(CreateDataRepositoryTaskOp(request))

  def createFileSystem(
    request: CreateFileSystemRequest
  ): FSxIO[CreateFileSystemResponse] =
    FF.liftF(CreateFileSystemOp(request))

  def createFileSystemFromBackup(
    request: CreateFileSystemFromBackupRequest
  ): FSxIO[CreateFileSystemFromBackupResponse] =
    FF.liftF(CreateFileSystemFromBackupOp(request))

  def deleteBackup(
    request: DeleteBackupRequest
  ): FSxIO[DeleteBackupResponse] =
    FF.liftF(DeleteBackupOp(request))

  def deleteFileSystem(
    request: DeleteFileSystemRequest
  ): FSxIO[DeleteFileSystemResponse] =
    FF.liftF(DeleteFileSystemOp(request))

  def describeBackups(
    request: DescribeBackupsRequest
  ): FSxIO[DescribeBackupsResponse] =
    FF.liftF(DescribeBackupsOp(request))

  def describeDataRepositoryTasks(
    request: DescribeDataRepositoryTasksRequest
  ): FSxIO[DescribeDataRepositoryTasksResponse] =
    FF.liftF(DescribeDataRepositoryTasksOp(request))

  def describeFileSystemAliases(
    request: DescribeFileSystemAliasesRequest
  ): FSxIO[DescribeFileSystemAliasesResponse] =
    FF.liftF(DescribeFileSystemAliasesOp(request))

  def describeFileSystems(
    request: DescribeFileSystemsRequest
  ): FSxIO[DescribeFileSystemsResponse] =
    FF.liftF(DescribeFileSystemsOp(request))

  def disassociateFileSystemAliases(
    request: DisassociateFileSystemAliasesRequest
  ): FSxIO[DisassociateFileSystemAliasesResponse] =
    FF.liftF(DisassociateFileSystemAliasesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): FSxIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): FSxIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): FSxIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateFileSystem(
    request: UpdateFileSystemRequest
  ): FSxIO[UpdateFileSystemResponse] =
    FF.liftF(UpdateFileSystemOp(request))
}
