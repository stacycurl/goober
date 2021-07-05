package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ebs.EbsClient
import software.amazon.awssdk.services.ebs.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ebs { module =>

  // Free monad over EbsOp
  type EbsIO[A] = FF[EbsOp, A]

  sealed trait EbsOp[A] {
    def visit[F[_]](visitor: EbsOp.Visitor[F]): F[A]
  }

  object EbsOp {
    // Given a EbsClient we can embed a EbsIO program in any algebra that understands embedding.
    implicit val EbsOpEmbeddable: Embeddable[EbsOp, EbsClient] = new Embeddable[EbsOp, EbsClient] {
      def embed[A](client: EbsClient, io: EbsIO[A]): Embedded[A] = Embedded.Ebs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EbsOp.Visitor[Kleisli[M, EbsClient, *]] {
        def completeSnapshot(
          request: CompleteSnapshotRequest
        ): Kleisli[M, EbsClient, CompleteSnapshotResponse] =
          primitive(_.completeSnapshot(request))

        def getSnapshotBlock(
          request: GetSnapshotBlockRequest,
          path: Path
        ): Kleisli[M, EbsClient, GetSnapshotBlockResponse] =
          primitive(_.getSnapshotBlock(request, path))

        def listChangedBlocks(
          request: ListChangedBlocksRequest
        ): Kleisli[M, EbsClient, ListChangedBlocksResponse] =
          primitive(_.listChangedBlocks(request))

        def listSnapshotBlocks(
          request: ListSnapshotBlocksRequest
        ): Kleisli[M, EbsClient, ListSnapshotBlocksResponse] =
          primitive(_.listSnapshotBlocks(request))

        def putSnapshotBlock(
          request: PutSnapshotBlockRequest,
          body: RequestBody
        ): Kleisli[M, EbsClient, PutSnapshotBlockResponse] =
          primitive(_.putSnapshotBlock(request, body))

        def startSnapshot(
          request: StartSnapshotRequest
        ): Kleisli[M, EbsClient, StartSnapshotResponse] =
          primitive(_.startSnapshot(request))

        def primitive[A](
          f: EbsClient => A
        ): Kleisli[M, EbsClient, A]
      }
    }

    trait Visitor[F[_]] extends (EbsOp ~> F) {
      final def apply[A](op: EbsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def completeSnapshot(
        request: CompleteSnapshotRequest
      ): F[CompleteSnapshotResponse]

      def getSnapshotBlock(
        request: GetSnapshotBlockRequest,
        path: Path
      ): F[GetSnapshotBlockResponse]

      def listChangedBlocks(
        request: ListChangedBlocksRequest
      ): F[ListChangedBlocksResponse]

      def listSnapshotBlocks(
        request: ListSnapshotBlocksRequest
      ): F[ListSnapshotBlocksResponse]

      def putSnapshotBlock(
        request: PutSnapshotBlockRequest,
        body: RequestBody
      ): F[PutSnapshotBlockResponse]

      def startSnapshot(
        request: StartSnapshotRequest
      ): F[StartSnapshotResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EbsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CompleteSnapshotOp(
      request: CompleteSnapshotRequest
    ) extends EbsOp[CompleteSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompleteSnapshotResponse] =
        visitor.completeSnapshot(request)
    }

    final case class GetSnapshotBlockOp(
      request: GetSnapshotBlockRequest,
      path: Path
    ) extends EbsOp[GetSnapshotBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSnapshotBlockResponse] =
        visitor.getSnapshotBlock(request, path)
    }

    final case class ListChangedBlocksOp(
      request: ListChangedBlocksRequest
    ) extends EbsOp[ListChangedBlocksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChangedBlocksResponse] =
        visitor.listChangedBlocks(request)
    }

    final case class ListSnapshotBlocksOp(
      request: ListSnapshotBlocksRequest
    ) extends EbsOp[ListSnapshotBlocksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSnapshotBlocksResponse] =
        visitor.listSnapshotBlocks(request)
    }

    final case class PutSnapshotBlockOp(
      request: PutSnapshotBlockRequest,
      body: RequestBody
    ) extends EbsOp[PutSnapshotBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSnapshotBlockResponse] =
        visitor.putSnapshotBlock(request, body)
    }

    final case class StartSnapshotOp(
      request: StartSnapshotRequest
    ) extends EbsOp[StartSnapshotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSnapshotResponse] =
        visitor.startSnapshot(request)
    }
  }

  import EbsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EbsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def completeSnapshot(
    request: CompleteSnapshotRequest
  ): EbsIO[CompleteSnapshotResponse] =
    FF.liftF(CompleteSnapshotOp(request))

  def getSnapshotBlock(
    request: GetSnapshotBlockRequest,
    path: Path
  ): EbsIO[GetSnapshotBlockResponse] =
    FF.liftF(GetSnapshotBlockOp(request, path))

  def listChangedBlocks(
    request: ListChangedBlocksRequest
  ): EbsIO[ListChangedBlocksResponse] =
    FF.liftF(ListChangedBlocksOp(request))

  def listSnapshotBlocks(
    request: ListSnapshotBlocksRequest
  ): EbsIO[ListSnapshotBlocksResponse] =
    FF.liftF(ListSnapshotBlocksOp(request))

  def putSnapshotBlock(
    request: PutSnapshotBlockRequest,
    body: RequestBody
  ): EbsIO[PutSnapshotBlockResponse] =
    FF.liftF(PutSnapshotBlockOp(request, body))

  def startSnapshot(
    request: StartSnapshotRequest
  ): EbsIO[StartSnapshotResponse] =
    FF.liftF(StartSnapshotOp(request))
}
