package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.dataexchange.DataExchangeClient
import software.amazon.awssdk.services.dataexchange.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object dataexchange { module =>

  // Free monad over DataExchangeOp
  type DataExchangeIO[A] = FF[DataExchangeOp, A]

  sealed trait DataExchangeOp[A] {
    def visit[F[_]](visitor: DataExchangeOp.Visitor[F]): F[A]
  }

  object DataExchangeOp {
    // Given a DataExchangeClient we can embed a DataExchangeIO program in any algebra that understands embedding.
    implicit val DataExchangeOpEmbeddable: Embeddable[DataExchangeOp, DataExchangeClient] = new Embeddable[DataExchangeOp, DataExchangeClient] {
      def embed[A](client: DataExchangeClient, io: DataExchangeIO[A]): Embedded[A] = Embedded.DataExchange(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DataExchangeOp.Visitor[Kleisli[M, DataExchangeClient, *]] {
        def cancelJob(
          request: CancelJobRequest
        ): Kleisli[M, DataExchangeClient, CancelJobResponse] =
          primitive(_.cancelJob(request))

        def createDataSet(
          request: CreateDataSetRequest
        ): Kleisli[M, DataExchangeClient, CreateDataSetResponse] =
          primitive(_.createDataSet(request))

        def createJob(
          request: CreateJobRequest
        ): Kleisli[M, DataExchangeClient, CreateJobResponse] =
          primitive(_.createJob(request))

        def createRevision(
          request: CreateRevisionRequest
        ): Kleisli[M, DataExchangeClient, CreateRevisionResponse] =
          primitive(_.createRevision(request))

        def deleteAsset(
          request: DeleteAssetRequest
        ): Kleisli[M, DataExchangeClient, DeleteAssetResponse] =
          primitive(_.deleteAsset(request))

        def deleteDataSet(
          request: DeleteDataSetRequest
        ): Kleisli[M, DataExchangeClient, DeleteDataSetResponse] =
          primitive(_.deleteDataSet(request))

        def deleteRevision(
          request: DeleteRevisionRequest
        ): Kleisli[M, DataExchangeClient, DeleteRevisionResponse] =
          primitive(_.deleteRevision(request))

        def getAsset(
          request: GetAssetRequest
        ): Kleisli[M, DataExchangeClient, GetAssetResponse] =
          primitive(_.getAsset(request))

        def getDataSet(
          request: GetDataSetRequest
        ): Kleisli[M, DataExchangeClient, GetDataSetResponse] =
          primitive(_.getDataSet(request))

        def getJob(
          request: GetJobRequest
        ): Kleisli[M, DataExchangeClient, GetJobResponse] =
          primitive(_.getJob(request))

        def getRevision(
          request: GetRevisionRequest
        ): Kleisli[M, DataExchangeClient, GetRevisionResponse] =
          primitive(_.getRevision(request))

        def listDataSetRevisions(
          request: ListDataSetRevisionsRequest
        ): Kleisli[M, DataExchangeClient, ListDataSetRevisionsResponse] =
          primitive(_.listDataSetRevisions(request))

        def listDataSets(
          request: ListDataSetsRequest
        ): Kleisli[M, DataExchangeClient, ListDataSetsResponse] =
          primitive(_.listDataSets(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, DataExchangeClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listRevisionAssets(
          request: ListRevisionAssetsRequest
        ): Kleisli[M, DataExchangeClient, ListRevisionAssetsResponse] =
          primitive(_.listRevisionAssets(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DataExchangeClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def startJob(
          request: StartJobRequest
        ): Kleisli[M, DataExchangeClient, StartJobResponse] =
          primitive(_.startJob(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DataExchangeClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DataExchangeClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAsset(
          request: UpdateAssetRequest
        ): Kleisli[M, DataExchangeClient, UpdateAssetResponse] =
          primitive(_.updateAsset(request))

        def updateDataSet(
          request: UpdateDataSetRequest
        ): Kleisli[M, DataExchangeClient, UpdateDataSetResponse] =
          primitive(_.updateDataSet(request))

        def updateRevision(
          request: UpdateRevisionRequest
        ): Kleisli[M, DataExchangeClient, UpdateRevisionResponse] =
          primitive(_.updateRevision(request))

        def primitive[A](
          f: DataExchangeClient => A
        ): Kleisli[M, DataExchangeClient, A]
      }
    }

    trait Visitor[F[_]] extends (DataExchangeOp ~> F) {
      final def apply[A](op: DataExchangeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelJob(
        request: CancelJobRequest
      ): F[CancelJobResponse]

      def createDataSet(
        request: CreateDataSetRequest
      ): F[CreateDataSetResponse]

      def createJob(
        request: CreateJobRequest
      ): F[CreateJobResponse]

      def createRevision(
        request: CreateRevisionRequest
      ): F[CreateRevisionResponse]

      def deleteAsset(
        request: DeleteAssetRequest
      ): F[DeleteAssetResponse]

      def deleteDataSet(
        request: DeleteDataSetRequest
      ): F[DeleteDataSetResponse]

      def deleteRevision(
        request: DeleteRevisionRequest
      ): F[DeleteRevisionResponse]

      def getAsset(
        request: GetAssetRequest
      ): F[GetAssetResponse]

      def getDataSet(
        request: GetDataSetRequest
      ): F[GetDataSetResponse]

      def getJob(
        request: GetJobRequest
      ): F[GetJobResponse]

      def getRevision(
        request: GetRevisionRequest
      ): F[GetRevisionResponse]

      def listDataSetRevisions(
        request: ListDataSetRevisionsRequest
      ): F[ListDataSetRevisionsResponse]

      def listDataSets(
        request: ListDataSetsRequest
      ): F[ListDataSetsResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listRevisionAssets(
        request: ListRevisionAssetsRequest
      ): F[ListRevisionAssetsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def startJob(
        request: StartJobRequest
      ): F[StartJobResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAsset(
        request: UpdateAssetRequest
      ): F[UpdateAssetResponse]

      def updateDataSet(
        request: UpdateDataSetRequest
      ): F[UpdateDataSetResponse]

      def updateRevision(
        request: UpdateRevisionRequest
      ): F[UpdateRevisionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DataExchangeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelJobOp(
      request: CancelJobRequest
    ) extends DataExchangeOp[CancelJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelJobResponse] =
        visitor.cancelJob(request)
    }

    final case class CreateDataSetOp(
      request: CreateDataSetRequest
    ) extends DataExchangeOp[CreateDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSetResponse] =
        visitor.createDataSet(request)
    }

    final case class CreateJobOp(
      request: CreateJobRequest
    ) extends DataExchangeOp[CreateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateJobResponse] =
        visitor.createJob(request)
    }

    final case class CreateRevisionOp(
      request: CreateRevisionRequest
    ) extends DataExchangeOp[CreateRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRevisionResponse] =
        visitor.createRevision(request)
    }

    final case class DeleteAssetOp(
      request: DeleteAssetRequest
    ) extends DataExchangeOp[DeleteAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssetResponse] =
        visitor.deleteAsset(request)
    }

    final case class DeleteDataSetOp(
      request: DeleteDataSetRequest
    ) extends DataExchangeOp[DeleteDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataSetResponse] =
        visitor.deleteDataSet(request)
    }

    final case class DeleteRevisionOp(
      request: DeleteRevisionRequest
    ) extends DataExchangeOp[DeleteRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRevisionResponse] =
        visitor.deleteRevision(request)
    }

    final case class GetAssetOp(
      request: GetAssetRequest
    ) extends DataExchangeOp[GetAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssetResponse] =
        visitor.getAsset(request)
    }

    final case class GetDataSetOp(
      request: GetDataSetRequest
    ) extends DataExchangeOp[GetDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDataSetResponse] =
        visitor.getDataSet(request)
    }

    final case class GetJobOp(
      request: GetJobRequest
    ) extends DataExchangeOp[GetJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetJobResponse] =
        visitor.getJob(request)
    }

    final case class GetRevisionOp(
      request: GetRevisionRequest
    ) extends DataExchangeOp[GetRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRevisionResponse] =
        visitor.getRevision(request)
    }

    final case class ListDataSetRevisionsOp(
      request: ListDataSetRevisionsRequest
    ) extends DataExchangeOp[ListDataSetRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSetRevisionsResponse] =
        visitor.listDataSetRevisions(request)
    }

    final case class ListDataSetsOp(
      request: ListDataSetsRequest
    ) extends DataExchangeOp[ListDataSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSetsResponse] =
        visitor.listDataSets(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends DataExchangeOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListRevisionAssetsOp(
      request: ListRevisionAssetsRequest
    ) extends DataExchangeOp[ListRevisionAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRevisionAssetsResponse] =
        visitor.listRevisionAssets(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DataExchangeOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class StartJobOp(
      request: StartJobRequest
    ) extends DataExchangeOp[StartJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartJobResponse] =
        visitor.startJob(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DataExchangeOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DataExchangeOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAssetOp(
      request: UpdateAssetRequest
    ) extends DataExchangeOp[UpdateAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssetResponse] =
        visitor.updateAsset(request)
    }

    final case class UpdateDataSetOp(
      request: UpdateDataSetRequest
    ) extends DataExchangeOp[UpdateDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSetResponse] =
        visitor.updateDataSet(request)
    }

    final case class UpdateRevisionOp(
      request: UpdateRevisionRequest
    ) extends DataExchangeOp[UpdateRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRevisionResponse] =
        visitor.updateRevision(request)
    }
  }

  import DataExchangeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DataExchangeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelJob(
    request: CancelJobRequest
  ): DataExchangeIO[CancelJobResponse] =
    FF.liftF(CancelJobOp(request))

  def createDataSet(
    request: CreateDataSetRequest
  ): DataExchangeIO[CreateDataSetResponse] =
    FF.liftF(CreateDataSetOp(request))

  def createJob(
    request: CreateJobRequest
  ): DataExchangeIO[CreateJobResponse] =
    FF.liftF(CreateJobOp(request))

  def createRevision(
    request: CreateRevisionRequest
  ): DataExchangeIO[CreateRevisionResponse] =
    FF.liftF(CreateRevisionOp(request))

  def deleteAsset(
    request: DeleteAssetRequest
  ): DataExchangeIO[DeleteAssetResponse] =
    FF.liftF(DeleteAssetOp(request))

  def deleteDataSet(
    request: DeleteDataSetRequest
  ): DataExchangeIO[DeleteDataSetResponse] =
    FF.liftF(DeleteDataSetOp(request))

  def deleteRevision(
    request: DeleteRevisionRequest
  ): DataExchangeIO[DeleteRevisionResponse] =
    FF.liftF(DeleteRevisionOp(request))

  def getAsset(
    request: GetAssetRequest
  ): DataExchangeIO[GetAssetResponse] =
    FF.liftF(GetAssetOp(request))

  def getDataSet(
    request: GetDataSetRequest
  ): DataExchangeIO[GetDataSetResponse] =
    FF.liftF(GetDataSetOp(request))

  def getJob(
    request: GetJobRequest
  ): DataExchangeIO[GetJobResponse] =
    FF.liftF(GetJobOp(request))

  def getRevision(
    request: GetRevisionRequest
  ): DataExchangeIO[GetRevisionResponse] =
    FF.liftF(GetRevisionOp(request))

  def listDataSetRevisions(
    request: ListDataSetRevisionsRequest
  ): DataExchangeIO[ListDataSetRevisionsResponse] =
    FF.liftF(ListDataSetRevisionsOp(request))

  def listDataSets(
    request: ListDataSetsRequest
  ): DataExchangeIO[ListDataSetsResponse] =
    FF.liftF(ListDataSetsOp(request))

  def listJobs(
    request: ListJobsRequest
  ): DataExchangeIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listRevisionAssets(
    request: ListRevisionAssetsRequest
  ): DataExchangeIO[ListRevisionAssetsResponse] =
    FF.liftF(ListRevisionAssetsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DataExchangeIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def startJob(
    request: StartJobRequest
  ): DataExchangeIO[StartJobResponse] =
    FF.liftF(StartJobOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DataExchangeIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DataExchangeIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAsset(
    request: UpdateAssetRequest
  ): DataExchangeIO[UpdateAssetResponse] =
    FF.liftF(UpdateAssetOp(request))

  def updateDataSet(
    request: UpdateDataSetRequest
  ): DataExchangeIO[UpdateDataSetResponse] =
    FF.liftF(UpdateDataSetOp(request))

  def updateRevision(
    request: UpdateRevisionRequest
  ): DataExchangeIO[UpdateRevisionResponse] =
    FF.liftF(UpdateRevisionOp(request))
}
