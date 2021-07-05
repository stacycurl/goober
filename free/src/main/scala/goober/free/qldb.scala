package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.qldb.QldbClient
import software.amazon.awssdk.services.qldb.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object qldb { module =>

  // Free monad over QldbOp
  type QldbIO[A] = FF[QldbOp, A]

  sealed trait QldbOp[A] {
    def visit[F[_]](visitor: QldbOp.Visitor[F]): F[A]
  }

  object QldbOp {
    // Given a QldbClient we can embed a QldbIO program in any algebra that understands embedding.
    implicit val QldbOpEmbeddable: Embeddable[QldbOp, QldbClient] = new Embeddable[QldbOp, QldbClient] {
      def embed[A](client: QldbClient, io: QldbIO[A]): Embedded[A] = Embedded.Qldb(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends QldbOp.Visitor[Kleisli[M, QldbClient, *]] {
        def cancelJournalKinesisStream(
          request: CancelJournalKinesisStreamRequest
        ): Kleisli[M, QldbClient, CancelJournalKinesisStreamResponse] =
          primitive(_.cancelJournalKinesisStream(request))

        def createLedger(
          request: CreateLedgerRequest
        ): Kleisli[M, QldbClient, CreateLedgerResponse] =
          primitive(_.createLedger(request))

        def deleteLedger(
          request: DeleteLedgerRequest
        ): Kleisli[M, QldbClient, DeleteLedgerResponse] =
          primitive(_.deleteLedger(request))

        def describeJournalKinesisStream(
          request: DescribeJournalKinesisStreamRequest
        ): Kleisli[M, QldbClient, DescribeJournalKinesisStreamResponse] =
          primitive(_.describeJournalKinesisStream(request))

        def describeJournalS3Export(
          request: DescribeJournalS3ExportRequest
        ): Kleisli[M, QldbClient, DescribeJournalS3ExportResponse] =
          primitive(_.describeJournalS3Export(request))

        def describeLedger(
          request: DescribeLedgerRequest
        ): Kleisli[M, QldbClient, DescribeLedgerResponse] =
          primitive(_.describeLedger(request))

        def exportJournalToS3(
          request: ExportJournalToS3Request
        ): Kleisli[M, QldbClient, ExportJournalToS3Response] =
          primitive(_.exportJournalToS3(request))

        def getBlock(
          request: GetBlockRequest
        ): Kleisli[M, QldbClient, GetBlockResponse] =
          primitive(_.getBlock(request))

        def getDigest(
          request: GetDigestRequest
        ): Kleisli[M, QldbClient, GetDigestResponse] =
          primitive(_.getDigest(request))

        def getRevision(
          request: GetRevisionRequest
        ): Kleisli[M, QldbClient, GetRevisionResponse] =
          primitive(_.getRevision(request))

        def listJournalKinesisStreamsForLedger(
          request: ListJournalKinesisStreamsForLedgerRequest
        ): Kleisli[M, QldbClient, ListJournalKinesisStreamsForLedgerResponse] =
          primitive(_.listJournalKinesisStreamsForLedger(request))

        def listJournalS3Exports(
          request: ListJournalS3ExportsRequest
        ): Kleisli[M, QldbClient, ListJournalS3ExportsResponse] =
          primitive(_.listJournalS3Exports(request))

        def listJournalS3ExportsForLedger(
          request: ListJournalS3ExportsForLedgerRequest
        ): Kleisli[M, QldbClient, ListJournalS3ExportsForLedgerResponse] =
          primitive(_.listJournalS3ExportsForLedger(request))

        def listLedgers(
          request: ListLedgersRequest
        ): Kleisli[M, QldbClient, ListLedgersResponse] =
          primitive(_.listLedgers(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, QldbClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def streamJournalToKinesis(
          request: StreamJournalToKinesisRequest
        ): Kleisli[M, QldbClient, StreamJournalToKinesisResponse] =
          primitive(_.streamJournalToKinesis(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, QldbClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, QldbClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateLedger(
          request: UpdateLedgerRequest
        ): Kleisli[M, QldbClient, UpdateLedgerResponse] =
          primitive(_.updateLedger(request))

        def updateLedgerPermissionsMode(
          request: UpdateLedgerPermissionsModeRequest
        ): Kleisli[M, QldbClient, UpdateLedgerPermissionsModeResponse] =
          primitive(_.updateLedgerPermissionsMode(request))

        def primitive[A](
          f: QldbClient => A
        ): Kleisli[M, QldbClient, A]
      }
    }

    trait Visitor[F[_]] extends (QldbOp ~> F) {
      final def apply[A](op: QldbOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelJournalKinesisStream(
        request: CancelJournalKinesisStreamRequest
      ): F[CancelJournalKinesisStreamResponse]

      def createLedger(
        request: CreateLedgerRequest
      ): F[CreateLedgerResponse]

      def deleteLedger(
        request: DeleteLedgerRequest
      ): F[DeleteLedgerResponse]

      def describeJournalKinesisStream(
        request: DescribeJournalKinesisStreamRequest
      ): F[DescribeJournalKinesisStreamResponse]

      def describeJournalS3Export(
        request: DescribeJournalS3ExportRequest
      ): F[DescribeJournalS3ExportResponse]

      def describeLedger(
        request: DescribeLedgerRequest
      ): F[DescribeLedgerResponse]

      def exportJournalToS3(
        request: ExportJournalToS3Request
      ): F[ExportJournalToS3Response]

      def getBlock(
        request: GetBlockRequest
      ): F[GetBlockResponse]

      def getDigest(
        request: GetDigestRequest
      ): F[GetDigestResponse]

      def getRevision(
        request: GetRevisionRequest
      ): F[GetRevisionResponse]

      def listJournalKinesisStreamsForLedger(
        request: ListJournalKinesisStreamsForLedgerRequest
      ): F[ListJournalKinesisStreamsForLedgerResponse]

      def listJournalS3Exports(
        request: ListJournalS3ExportsRequest
      ): F[ListJournalS3ExportsResponse]

      def listJournalS3ExportsForLedger(
        request: ListJournalS3ExportsForLedgerRequest
      ): F[ListJournalS3ExportsForLedgerResponse]

      def listLedgers(
        request: ListLedgersRequest
      ): F[ListLedgersResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def streamJournalToKinesis(
        request: StreamJournalToKinesisRequest
      ): F[StreamJournalToKinesisResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateLedger(
        request: UpdateLedgerRequest
      ): F[UpdateLedgerResponse]

      def updateLedgerPermissionsMode(
        request: UpdateLedgerPermissionsModeRequest
      ): F[UpdateLedgerPermissionsModeResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends QldbOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelJournalKinesisStreamOp(
      request: CancelJournalKinesisStreamRequest
    ) extends QldbOp[CancelJournalKinesisStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJournalKinesisStreamResponse] =
        visitor.cancelJournalKinesisStream(request)
    }

    final case class CreateLedgerOp(
      request: CreateLedgerRequest
    ) extends QldbOp[CreateLedgerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLedgerResponse] =
        visitor.createLedger(request)
    }

    final case class DeleteLedgerOp(
      request: DeleteLedgerRequest
    ) extends QldbOp[DeleteLedgerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLedgerResponse] =
        visitor.deleteLedger(request)
    }

    final case class DescribeJournalKinesisStreamOp(
      request: DescribeJournalKinesisStreamRequest
    ) extends QldbOp[DescribeJournalKinesisStreamResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJournalKinesisStreamResponse] =
        visitor.describeJournalKinesisStream(request)
    }

    final case class DescribeJournalS3ExportOp(
      request: DescribeJournalS3ExportRequest
    ) extends QldbOp[DescribeJournalS3ExportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJournalS3ExportResponse] =
        visitor.describeJournalS3Export(request)
    }

    final case class DescribeLedgerOp(
      request: DescribeLedgerRequest
    ) extends QldbOp[DescribeLedgerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLedgerResponse] =
        visitor.describeLedger(request)
    }

    final case class ExportJournalToS3Op(
      request: ExportJournalToS3Request
    ) extends QldbOp[ExportJournalToS3Response] {
      def visit[F[_]](visitor: Visitor[F]): F[ExportJournalToS3Response] =
        visitor.exportJournalToS3(request)
    }

    final case class GetBlockOp(
      request: GetBlockRequest
    ) extends QldbOp[GetBlockResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBlockResponse] =
        visitor.getBlock(request)
    }

    final case class GetDigestOp(
      request: GetDigestRequest
    ) extends QldbOp[GetDigestResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDigestResponse] =
        visitor.getDigest(request)
    }

    final case class GetRevisionOp(
      request: GetRevisionRequest
    ) extends QldbOp[GetRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRevisionResponse] =
        visitor.getRevision(request)
    }

    final case class ListJournalKinesisStreamsForLedgerOp(
      request: ListJournalKinesisStreamsForLedgerRequest
    ) extends QldbOp[ListJournalKinesisStreamsForLedgerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJournalKinesisStreamsForLedgerResponse] =
        visitor.listJournalKinesisStreamsForLedger(request)
    }

    final case class ListJournalS3ExportsOp(
      request: ListJournalS3ExportsRequest
    ) extends QldbOp[ListJournalS3ExportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJournalS3ExportsResponse] =
        visitor.listJournalS3Exports(request)
    }

    final case class ListJournalS3ExportsForLedgerOp(
      request: ListJournalS3ExportsForLedgerRequest
    ) extends QldbOp[ListJournalS3ExportsForLedgerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJournalS3ExportsForLedgerResponse] =
        visitor.listJournalS3ExportsForLedger(request)
    }

    final case class ListLedgersOp(
      request: ListLedgersRequest
    ) extends QldbOp[ListLedgersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLedgersResponse] =
        visitor.listLedgers(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends QldbOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StreamJournalToKinesisOp(
      request: StreamJournalToKinesisRequest
    ) extends QldbOp[StreamJournalToKinesisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StreamJournalToKinesisResponse] =
        visitor.streamJournalToKinesis(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends QldbOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends QldbOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateLedgerOp(
      request: UpdateLedgerRequest
    ) extends QldbOp[UpdateLedgerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLedgerResponse] =
        visitor.updateLedger(request)
    }

    final case class UpdateLedgerPermissionsModeOp(
      request: UpdateLedgerPermissionsModeRequest
    ) extends QldbOp[UpdateLedgerPermissionsModeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLedgerPermissionsModeResponse] =
        visitor.updateLedgerPermissionsMode(request)
    }
  }

  import QldbOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[QldbOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelJournalKinesisStream(
    request: CancelJournalKinesisStreamRequest
  ): QldbIO[CancelJournalKinesisStreamResponse] =
    FF.liftF(CancelJournalKinesisStreamOp(request))

  def createLedger(
    request: CreateLedgerRequest
  ): QldbIO[CreateLedgerResponse] =
    FF.liftF(CreateLedgerOp(request))

  def deleteLedger(
    request: DeleteLedgerRequest
  ): QldbIO[DeleteLedgerResponse] =
    FF.liftF(DeleteLedgerOp(request))

  def describeJournalKinesisStream(
    request: DescribeJournalKinesisStreamRequest
  ): QldbIO[DescribeJournalKinesisStreamResponse] =
    FF.liftF(DescribeJournalKinesisStreamOp(request))

  def describeJournalS3Export(
    request: DescribeJournalS3ExportRequest
  ): QldbIO[DescribeJournalS3ExportResponse] =
    FF.liftF(DescribeJournalS3ExportOp(request))

  def describeLedger(
    request: DescribeLedgerRequest
  ): QldbIO[DescribeLedgerResponse] =
    FF.liftF(DescribeLedgerOp(request))

  def exportJournalToS3(
    request: ExportJournalToS3Request
  ): QldbIO[ExportJournalToS3Response] =
    FF.liftF(ExportJournalToS3Op(request))

  def getBlock(
    request: GetBlockRequest
  ): QldbIO[GetBlockResponse] =
    FF.liftF(GetBlockOp(request))

  def getDigest(
    request: GetDigestRequest
  ): QldbIO[GetDigestResponse] =
    FF.liftF(GetDigestOp(request))

  def getRevision(
    request: GetRevisionRequest
  ): QldbIO[GetRevisionResponse] =
    FF.liftF(GetRevisionOp(request))

  def listJournalKinesisStreamsForLedger(
    request: ListJournalKinesisStreamsForLedgerRequest
  ): QldbIO[ListJournalKinesisStreamsForLedgerResponse] =
    FF.liftF(ListJournalKinesisStreamsForLedgerOp(request))

  def listJournalS3Exports(
    request: ListJournalS3ExportsRequest
  ): QldbIO[ListJournalS3ExportsResponse] =
    FF.liftF(ListJournalS3ExportsOp(request))

  def listJournalS3ExportsForLedger(
    request: ListJournalS3ExportsForLedgerRequest
  ): QldbIO[ListJournalS3ExportsForLedgerResponse] =
    FF.liftF(ListJournalS3ExportsForLedgerOp(request))

  def listLedgers(
    request: ListLedgersRequest
  ): QldbIO[ListLedgersResponse] =
    FF.liftF(ListLedgersOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): QldbIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def streamJournalToKinesis(
    request: StreamJournalToKinesisRequest
  ): QldbIO[StreamJournalToKinesisResponse] =
    FF.liftF(StreamJournalToKinesisOp(request))

  def tagResource(
    request: TagResourceRequest
  ): QldbIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): QldbIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateLedger(
    request: UpdateLedgerRequest
  ): QldbIO[UpdateLedgerResponse] =
    FF.liftF(UpdateLedgerOp(request))

  def updateLedgerPermissionsMode(
    request: UpdateLedgerPermissionsModeRequest
  ): QldbIO[UpdateLedgerPermissionsModeResponse] =
    FF.liftF(UpdateLedgerPermissionsModeOp(request))
}
