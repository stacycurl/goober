package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.kendra.KendraClient
import software.amazon.awssdk.services.kendra.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object kendra { module =>

  // Free monad over KendraOp
  type KendraIO[A] = FF[KendraOp, A]

  sealed trait KendraOp[A] {
    def visit[F[_]](visitor: KendraOp.Visitor[F]): F[A]
  }

  object KendraOp {
    // Given a KendraClient we can embed a KendraIO program in any algebra that understands embedding.
    implicit val KendraOpEmbeddable: Embeddable[KendraOp, KendraClient] = new Embeddable[KendraOp, KendraClient] {
      def embed[A](client: KendraClient, io: KendraIO[A]): Embedded[A] = Embedded.Kendra(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends KendraOp.Visitor[Kleisli[M, KendraClient, *]] {
        def batchDeleteDocument(
          request: BatchDeleteDocumentRequest
        ): Kleisli[M, KendraClient, BatchDeleteDocumentResponse] =
          primitive(_.batchDeleteDocument(request))

        def batchGetDocumentStatus(
          request: BatchGetDocumentStatusRequest
        ): Kleisli[M, KendraClient, BatchGetDocumentStatusResponse] =
          primitive(_.batchGetDocumentStatus(request))

        def batchPutDocument(
          request: BatchPutDocumentRequest
        ): Kleisli[M, KendraClient, BatchPutDocumentResponse] =
          primitive(_.batchPutDocument(request))

        def clearQuerySuggestions(
          request: ClearQuerySuggestionsRequest
        ): Kleisli[M, KendraClient, ClearQuerySuggestionsResponse] =
          primitive(_.clearQuerySuggestions(request))

        def createDataSource(
          request: CreateDataSourceRequest
        ): Kleisli[M, KendraClient, CreateDataSourceResponse] =
          primitive(_.createDataSource(request))

        def createFaq(
          request: CreateFaqRequest
        ): Kleisli[M, KendraClient, CreateFaqResponse] =
          primitive(_.createFaq(request))

        def createIndex(
          request: CreateIndexRequest
        ): Kleisli[M, KendraClient, CreateIndexResponse] =
          primitive(_.createIndex(request))

        def createQuerySuggestionsBlockList(
          request: CreateQuerySuggestionsBlockListRequest
        ): Kleisli[M, KendraClient, CreateQuerySuggestionsBlockListResponse] =
          primitive(_.createQuerySuggestionsBlockList(request))

        def createThesaurus(
          request: CreateThesaurusRequest
        ): Kleisli[M, KendraClient, CreateThesaurusResponse] =
          primitive(_.createThesaurus(request))

        def deleteDataSource(
          request: DeleteDataSourceRequest
        ): Kleisli[M, KendraClient, DeleteDataSourceResponse] =
          primitive(_.deleteDataSource(request))

        def deleteFaq(
          request: DeleteFaqRequest
        ): Kleisli[M, KendraClient, DeleteFaqResponse] =
          primitive(_.deleteFaq(request))

        def deleteIndex(
          request: DeleteIndexRequest
        ): Kleisli[M, KendraClient, DeleteIndexResponse] =
          primitive(_.deleteIndex(request))

        def deleteQuerySuggestionsBlockList(
          request: DeleteQuerySuggestionsBlockListRequest
        ): Kleisli[M, KendraClient, DeleteQuerySuggestionsBlockListResponse] =
          primitive(_.deleteQuerySuggestionsBlockList(request))

        def deleteThesaurus(
          request: DeleteThesaurusRequest
        ): Kleisli[M, KendraClient, DeleteThesaurusResponse] =
          primitive(_.deleteThesaurus(request))

        def describeDataSource(
          request: DescribeDataSourceRequest
        ): Kleisli[M, KendraClient, DescribeDataSourceResponse] =
          primitive(_.describeDataSource(request))

        def describeFaq(
          request: DescribeFaqRequest
        ): Kleisli[M, KendraClient, DescribeFaqResponse] =
          primitive(_.describeFaq(request))

        def describeIndex(
          request: DescribeIndexRequest
        ): Kleisli[M, KendraClient, DescribeIndexResponse] =
          primitive(_.describeIndex(request))

        def describeQuerySuggestionsBlockList(
          request: DescribeQuerySuggestionsBlockListRequest
        ): Kleisli[M, KendraClient, DescribeQuerySuggestionsBlockListResponse] =
          primitive(_.describeQuerySuggestionsBlockList(request))

        def describeQuerySuggestionsConfig(
          request: DescribeQuerySuggestionsConfigRequest
        ): Kleisli[M, KendraClient, DescribeQuerySuggestionsConfigResponse] =
          primitive(_.describeQuerySuggestionsConfig(request))

        def describeThesaurus(
          request: DescribeThesaurusRequest
        ): Kleisli[M, KendraClient, DescribeThesaurusResponse] =
          primitive(_.describeThesaurus(request))

        def getQuerySuggestions(
          request: GetQuerySuggestionsRequest
        ): Kleisli[M, KendraClient, GetQuerySuggestionsResponse] =
          primitive(_.getQuerySuggestions(request))

        def listDataSourceSyncJobs(
          request: ListDataSourceSyncJobsRequest
        ): Kleisli[M, KendraClient, ListDataSourceSyncJobsResponse] =
          primitive(_.listDataSourceSyncJobs(request))

        def listDataSources(
          request: ListDataSourcesRequest
        ): Kleisli[M, KendraClient, ListDataSourcesResponse] =
          primitive(_.listDataSources(request))

        def listFaqs(
          request: ListFaqsRequest
        ): Kleisli[M, KendraClient, ListFaqsResponse] =
          primitive(_.listFaqs(request))

        def listIndices(
          request: ListIndicesRequest
        ): Kleisli[M, KendraClient, ListIndicesResponse] =
          primitive(_.listIndices(request))

        def listQuerySuggestionsBlockLists(
          request: ListQuerySuggestionsBlockListsRequest
        ): Kleisli[M, KendraClient, ListQuerySuggestionsBlockListsResponse] =
          primitive(_.listQuerySuggestionsBlockLists(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, KendraClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listThesauri(
          request: ListThesauriRequest
        ): Kleisli[M, KendraClient, ListThesauriResponse] =
          primitive(_.listThesauri(request))

        def query(
          request: QueryRequest
        ): Kleisli[M, KendraClient, QueryResponse] =
          primitive(_.query(request))

        def startDataSourceSyncJob(
          request: StartDataSourceSyncJobRequest
        ): Kleisli[M, KendraClient, StartDataSourceSyncJobResponse] =
          primitive(_.startDataSourceSyncJob(request))

        def stopDataSourceSyncJob(
          request: StopDataSourceSyncJobRequest
        ): Kleisli[M, KendraClient, StopDataSourceSyncJobResponse] =
          primitive(_.stopDataSourceSyncJob(request))

        def submitFeedback(
          request: SubmitFeedbackRequest
        ): Kleisli[M, KendraClient, SubmitFeedbackResponse] =
          primitive(_.submitFeedback(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, KendraClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, KendraClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDataSource(
          request: UpdateDataSourceRequest
        ): Kleisli[M, KendraClient, UpdateDataSourceResponse] =
          primitive(_.updateDataSource(request))

        def updateIndex(
          request: UpdateIndexRequest
        ): Kleisli[M, KendraClient, UpdateIndexResponse] =
          primitive(_.updateIndex(request))

        def updateQuerySuggestionsBlockList(
          request: UpdateQuerySuggestionsBlockListRequest
        ): Kleisli[M, KendraClient, UpdateQuerySuggestionsBlockListResponse] =
          primitive(_.updateQuerySuggestionsBlockList(request))

        def updateQuerySuggestionsConfig(
          request: UpdateQuerySuggestionsConfigRequest
        ): Kleisli[M, KendraClient, UpdateQuerySuggestionsConfigResponse] =
          primitive(_.updateQuerySuggestionsConfig(request))

        def updateThesaurus(
          request: UpdateThesaurusRequest
        ): Kleisli[M, KendraClient, UpdateThesaurusResponse] =
          primitive(_.updateThesaurus(request))

        def primitive[A](
          f: KendraClient => A
        ): Kleisli[M, KendraClient, A]
      }
    }

    trait Visitor[F[_]] extends (KendraOp ~> F) {
      final def apply[A](op: KendraOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchDeleteDocument(
        request: BatchDeleteDocumentRequest
      ): F[BatchDeleteDocumentResponse]

      def batchGetDocumentStatus(
        request: BatchGetDocumentStatusRequest
      ): F[BatchGetDocumentStatusResponse]

      def batchPutDocument(
        request: BatchPutDocumentRequest
      ): F[BatchPutDocumentResponse]

      def clearQuerySuggestions(
        request: ClearQuerySuggestionsRequest
      ): F[ClearQuerySuggestionsResponse]

      def createDataSource(
        request: CreateDataSourceRequest
      ): F[CreateDataSourceResponse]

      def createFaq(
        request: CreateFaqRequest
      ): F[CreateFaqResponse]

      def createIndex(
        request: CreateIndexRequest
      ): F[CreateIndexResponse]

      def createQuerySuggestionsBlockList(
        request: CreateQuerySuggestionsBlockListRequest
      ): F[CreateQuerySuggestionsBlockListResponse]

      def createThesaurus(
        request: CreateThesaurusRequest
      ): F[CreateThesaurusResponse]

      def deleteDataSource(
        request: DeleteDataSourceRequest
      ): F[DeleteDataSourceResponse]

      def deleteFaq(
        request: DeleteFaqRequest
      ): F[DeleteFaqResponse]

      def deleteIndex(
        request: DeleteIndexRequest
      ): F[DeleteIndexResponse]

      def deleteQuerySuggestionsBlockList(
        request: DeleteQuerySuggestionsBlockListRequest
      ): F[DeleteQuerySuggestionsBlockListResponse]

      def deleteThesaurus(
        request: DeleteThesaurusRequest
      ): F[DeleteThesaurusResponse]

      def describeDataSource(
        request: DescribeDataSourceRequest
      ): F[DescribeDataSourceResponse]

      def describeFaq(
        request: DescribeFaqRequest
      ): F[DescribeFaqResponse]

      def describeIndex(
        request: DescribeIndexRequest
      ): F[DescribeIndexResponse]

      def describeQuerySuggestionsBlockList(
        request: DescribeQuerySuggestionsBlockListRequest
      ): F[DescribeQuerySuggestionsBlockListResponse]

      def describeQuerySuggestionsConfig(
        request: DescribeQuerySuggestionsConfigRequest
      ): F[DescribeQuerySuggestionsConfigResponse]

      def describeThesaurus(
        request: DescribeThesaurusRequest
      ): F[DescribeThesaurusResponse]

      def getQuerySuggestions(
        request: GetQuerySuggestionsRequest
      ): F[GetQuerySuggestionsResponse]

      def listDataSourceSyncJobs(
        request: ListDataSourceSyncJobsRequest
      ): F[ListDataSourceSyncJobsResponse]

      def listDataSources(
        request: ListDataSourcesRequest
      ): F[ListDataSourcesResponse]

      def listFaqs(
        request: ListFaqsRequest
      ): F[ListFaqsResponse]

      def listIndices(
        request: ListIndicesRequest
      ): F[ListIndicesResponse]

      def listQuerySuggestionsBlockLists(
        request: ListQuerySuggestionsBlockListsRequest
      ): F[ListQuerySuggestionsBlockListsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listThesauri(
        request: ListThesauriRequest
      ): F[ListThesauriResponse]

      def query(
        request: QueryRequest
      ): F[QueryResponse]

      def startDataSourceSyncJob(
        request: StartDataSourceSyncJobRequest
      ): F[StartDataSourceSyncJobResponse]

      def stopDataSourceSyncJob(
        request: StopDataSourceSyncJobRequest
      ): F[StopDataSourceSyncJobResponse]

      def submitFeedback(
        request: SubmitFeedbackRequest
      ): F[SubmitFeedbackResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDataSource(
        request: UpdateDataSourceRequest
      ): F[UpdateDataSourceResponse]

      def updateIndex(
        request: UpdateIndexRequest
      ): F[UpdateIndexResponse]

      def updateQuerySuggestionsBlockList(
        request: UpdateQuerySuggestionsBlockListRequest
      ): F[UpdateQuerySuggestionsBlockListResponse]

      def updateQuerySuggestionsConfig(
        request: UpdateQuerySuggestionsConfigRequest
      ): F[UpdateQuerySuggestionsConfigResponse]

      def updateThesaurus(
        request: UpdateThesaurusRequest
      ): F[UpdateThesaurusResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends KendraOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchDeleteDocumentOp(
      request: BatchDeleteDocumentRequest
    ) extends KendraOp[BatchDeleteDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteDocumentResponse] =
        visitor.batchDeleteDocument(request)
    }

    final case class BatchGetDocumentStatusOp(
      request: BatchGetDocumentStatusRequest
    ) extends KendraOp[BatchGetDocumentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetDocumentStatusResponse] =
        visitor.batchGetDocumentStatus(request)
    }

    final case class BatchPutDocumentOp(
      request: BatchPutDocumentRequest
    ) extends KendraOp[BatchPutDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchPutDocumentResponse] =
        visitor.batchPutDocument(request)
    }

    final case class ClearQuerySuggestionsOp(
      request: ClearQuerySuggestionsRequest
    ) extends KendraOp[ClearQuerySuggestionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ClearQuerySuggestionsResponse] =
        visitor.clearQuerySuggestions(request)
    }

    final case class CreateDataSourceOp(
      request: CreateDataSourceRequest
    ) extends KendraOp[CreateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSourceResponse] =
        visitor.createDataSource(request)
    }

    final case class CreateFaqOp(
      request: CreateFaqRequest
    ) extends KendraOp[CreateFaqResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFaqResponse] =
        visitor.createFaq(request)
    }

    final case class CreateIndexOp(
      request: CreateIndexRequest
    ) extends KendraOp[CreateIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIndexResponse] =
        visitor.createIndex(request)
    }

    final case class CreateQuerySuggestionsBlockListOp(
      request: CreateQuerySuggestionsBlockListRequest
    ) extends KendraOp[CreateQuerySuggestionsBlockListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQuerySuggestionsBlockListResponse] =
        visitor.createQuerySuggestionsBlockList(request)
    }

    final case class CreateThesaurusOp(
      request: CreateThesaurusRequest
    ) extends KendraOp[CreateThesaurusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThesaurusResponse] =
        visitor.createThesaurus(request)
    }

    final case class DeleteDataSourceOp(
      request: DeleteDataSourceRequest
    ) extends KendraOp[DeleteDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataSourceResponse] =
        visitor.deleteDataSource(request)
    }

    final case class DeleteFaqOp(
      request: DeleteFaqRequest
    ) extends KendraOp[DeleteFaqResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFaqResponse] =
        visitor.deleteFaq(request)
    }

    final case class DeleteIndexOp(
      request: DeleteIndexRequest
    ) extends KendraOp[DeleteIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIndexResponse] =
        visitor.deleteIndex(request)
    }

    final case class DeleteQuerySuggestionsBlockListOp(
      request: DeleteQuerySuggestionsBlockListRequest
    ) extends KendraOp[DeleteQuerySuggestionsBlockListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQuerySuggestionsBlockListResponse] =
        visitor.deleteQuerySuggestionsBlockList(request)
    }

    final case class DeleteThesaurusOp(
      request: DeleteThesaurusRequest
    ) extends KendraOp[DeleteThesaurusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThesaurusResponse] =
        visitor.deleteThesaurus(request)
    }

    final case class DescribeDataSourceOp(
      request: DescribeDataSourceRequest
    ) extends KendraOp[DescribeDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataSourceResponse] =
        visitor.describeDataSource(request)
    }

    final case class DescribeFaqOp(
      request: DescribeFaqRequest
    ) extends KendraOp[DescribeFaqResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFaqResponse] =
        visitor.describeFaq(request)
    }

    final case class DescribeIndexOp(
      request: DescribeIndexRequest
    ) extends KendraOp[DescribeIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIndexResponse] =
        visitor.describeIndex(request)
    }

    final case class DescribeQuerySuggestionsBlockListOp(
      request: DescribeQuerySuggestionsBlockListRequest
    ) extends KendraOp[DescribeQuerySuggestionsBlockListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeQuerySuggestionsBlockListResponse] =
        visitor.describeQuerySuggestionsBlockList(request)
    }

    final case class DescribeQuerySuggestionsConfigOp(
      request: DescribeQuerySuggestionsConfigRequest
    ) extends KendraOp[DescribeQuerySuggestionsConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeQuerySuggestionsConfigResponse] =
        visitor.describeQuerySuggestionsConfig(request)
    }

    final case class DescribeThesaurusOp(
      request: DescribeThesaurusRequest
    ) extends KendraOp[DescribeThesaurusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThesaurusResponse] =
        visitor.describeThesaurus(request)
    }

    final case class GetQuerySuggestionsOp(
      request: GetQuerySuggestionsRequest
    ) extends KendraOp[GetQuerySuggestionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetQuerySuggestionsResponse] =
        visitor.getQuerySuggestions(request)
    }

    final case class ListDataSourceSyncJobsOp(
      request: ListDataSourceSyncJobsRequest
    ) extends KendraOp[ListDataSourceSyncJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSourceSyncJobsResponse] =
        visitor.listDataSourceSyncJobs(request)
    }

    final case class ListDataSourcesOp(
      request: ListDataSourcesRequest
    ) extends KendraOp[ListDataSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSourcesResponse] =
        visitor.listDataSources(request)
    }

    final case class ListFaqsOp(
      request: ListFaqsRequest
    ) extends KendraOp[ListFaqsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFaqsResponse] =
        visitor.listFaqs(request)
    }

    final case class ListIndicesOp(
      request: ListIndicesRequest
    ) extends KendraOp[ListIndicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIndicesResponse] =
        visitor.listIndices(request)
    }

    final case class ListQuerySuggestionsBlockListsOp(
      request: ListQuerySuggestionsBlockListsRequest
    ) extends KendraOp[ListQuerySuggestionsBlockListsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQuerySuggestionsBlockListsResponse] =
        visitor.listQuerySuggestionsBlockLists(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends KendraOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListThesauriOp(
      request: ListThesauriRequest
    ) extends KendraOp[ListThesauriResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThesauriResponse] =
        visitor.listThesauri(request)
    }

    final case class QueryOp(
      request: QueryRequest
    ) extends KendraOp[QueryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[QueryResponse] =
        visitor.query(request)
    }

    final case class StartDataSourceSyncJobOp(
      request: StartDataSourceSyncJobRequest
    ) extends KendraOp[StartDataSourceSyncJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDataSourceSyncJobResponse] =
        visitor.startDataSourceSyncJob(request)
    }

    final case class StopDataSourceSyncJobOp(
      request: StopDataSourceSyncJobRequest
    ) extends KendraOp[StopDataSourceSyncJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDataSourceSyncJobResponse] =
        visitor.stopDataSourceSyncJob(request)
    }

    final case class SubmitFeedbackOp(
      request: SubmitFeedbackRequest
    ) extends KendraOp[SubmitFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubmitFeedbackResponse] =
        visitor.submitFeedback(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends KendraOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends KendraOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDataSourceOp(
      request: UpdateDataSourceRequest
    ) extends KendraOp[UpdateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSourceResponse] =
        visitor.updateDataSource(request)
    }

    final case class UpdateIndexOp(
      request: UpdateIndexRequest
    ) extends KendraOp[UpdateIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIndexResponse] =
        visitor.updateIndex(request)
    }

    final case class UpdateQuerySuggestionsBlockListOp(
      request: UpdateQuerySuggestionsBlockListRequest
    ) extends KendraOp[UpdateQuerySuggestionsBlockListResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQuerySuggestionsBlockListResponse] =
        visitor.updateQuerySuggestionsBlockList(request)
    }

    final case class UpdateQuerySuggestionsConfigOp(
      request: UpdateQuerySuggestionsConfigRequest
    ) extends KendraOp[UpdateQuerySuggestionsConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQuerySuggestionsConfigResponse] =
        visitor.updateQuerySuggestionsConfig(request)
    }

    final case class UpdateThesaurusOp(
      request: UpdateThesaurusRequest
    ) extends KendraOp[UpdateThesaurusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThesaurusResponse] =
        visitor.updateThesaurus(request)
    }
  }

  import KendraOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[KendraOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchDeleteDocument(
    request: BatchDeleteDocumentRequest
  ): KendraIO[BatchDeleteDocumentResponse] =
    FF.liftF(BatchDeleteDocumentOp(request))

  def batchGetDocumentStatus(
    request: BatchGetDocumentStatusRequest
  ): KendraIO[BatchGetDocumentStatusResponse] =
    FF.liftF(BatchGetDocumentStatusOp(request))

  def batchPutDocument(
    request: BatchPutDocumentRequest
  ): KendraIO[BatchPutDocumentResponse] =
    FF.liftF(BatchPutDocumentOp(request))

  def clearQuerySuggestions(
    request: ClearQuerySuggestionsRequest
  ): KendraIO[ClearQuerySuggestionsResponse] =
    FF.liftF(ClearQuerySuggestionsOp(request))

  def createDataSource(
    request: CreateDataSourceRequest
  ): KendraIO[CreateDataSourceResponse] =
    FF.liftF(CreateDataSourceOp(request))

  def createFaq(
    request: CreateFaqRequest
  ): KendraIO[CreateFaqResponse] =
    FF.liftF(CreateFaqOp(request))

  def createIndex(
    request: CreateIndexRequest
  ): KendraIO[CreateIndexResponse] =
    FF.liftF(CreateIndexOp(request))

  def createQuerySuggestionsBlockList(
    request: CreateQuerySuggestionsBlockListRequest
  ): KendraIO[CreateQuerySuggestionsBlockListResponse] =
    FF.liftF(CreateQuerySuggestionsBlockListOp(request))

  def createThesaurus(
    request: CreateThesaurusRequest
  ): KendraIO[CreateThesaurusResponse] =
    FF.liftF(CreateThesaurusOp(request))

  def deleteDataSource(
    request: DeleteDataSourceRequest
  ): KendraIO[DeleteDataSourceResponse] =
    FF.liftF(DeleteDataSourceOp(request))

  def deleteFaq(
    request: DeleteFaqRequest
  ): KendraIO[DeleteFaqResponse] =
    FF.liftF(DeleteFaqOp(request))

  def deleteIndex(
    request: DeleteIndexRequest
  ): KendraIO[DeleteIndexResponse] =
    FF.liftF(DeleteIndexOp(request))

  def deleteQuerySuggestionsBlockList(
    request: DeleteQuerySuggestionsBlockListRequest
  ): KendraIO[DeleteQuerySuggestionsBlockListResponse] =
    FF.liftF(DeleteQuerySuggestionsBlockListOp(request))

  def deleteThesaurus(
    request: DeleteThesaurusRequest
  ): KendraIO[DeleteThesaurusResponse] =
    FF.liftF(DeleteThesaurusOp(request))

  def describeDataSource(
    request: DescribeDataSourceRequest
  ): KendraIO[DescribeDataSourceResponse] =
    FF.liftF(DescribeDataSourceOp(request))

  def describeFaq(
    request: DescribeFaqRequest
  ): KendraIO[DescribeFaqResponse] =
    FF.liftF(DescribeFaqOp(request))

  def describeIndex(
    request: DescribeIndexRequest
  ): KendraIO[DescribeIndexResponse] =
    FF.liftF(DescribeIndexOp(request))

  def describeQuerySuggestionsBlockList(
    request: DescribeQuerySuggestionsBlockListRequest
  ): KendraIO[DescribeQuerySuggestionsBlockListResponse] =
    FF.liftF(DescribeQuerySuggestionsBlockListOp(request))

  def describeQuerySuggestionsConfig(
    request: DescribeQuerySuggestionsConfigRequest
  ): KendraIO[DescribeQuerySuggestionsConfigResponse] =
    FF.liftF(DescribeQuerySuggestionsConfigOp(request))

  def describeThesaurus(
    request: DescribeThesaurusRequest
  ): KendraIO[DescribeThesaurusResponse] =
    FF.liftF(DescribeThesaurusOp(request))

  def getQuerySuggestions(
    request: GetQuerySuggestionsRequest
  ): KendraIO[GetQuerySuggestionsResponse] =
    FF.liftF(GetQuerySuggestionsOp(request))

  def listDataSourceSyncJobs(
    request: ListDataSourceSyncJobsRequest
  ): KendraIO[ListDataSourceSyncJobsResponse] =
    FF.liftF(ListDataSourceSyncJobsOp(request))

  def listDataSources(
    request: ListDataSourcesRequest
  ): KendraIO[ListDataSourcesResponse] =
    FF.liftF(ListDataSourcesOp(request))

  def listFaqs(
    request: ListFaqsRequest
  ): KendraIO[ListFaqsResponse] =
    FF.liftF(ListFaqsOp(request))

  def listIndices(
    request: ListIndicesRequest
  ): KendraIO[ListIndicesResponse] =
    FF.liftF(ListIndicesOp(request))

  def listQuerySuggestionsBlockLists(
    request: ListQuerySuggestionsBlockListsRequest
  ): KendraIO[ListQuerySuggestionsBlockListsResponse] =
    FF.liftF(ListQuerySuggestionsBlockListsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): KendraIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listThesauri(
    request: ListThesauriRequest
  ): KendraIO[ListThesauriResponse] =
    FF.liftF(ListThesauriOp(request))

  def query(
    request: QueryRequest
  ): KendraIO[QueryResponse] =
    FF.liftF(QueryOp(request))

  def startDataSourceSyncJob(
    request: StartDataSourceSyncJobRequest
  ): KendraIO[StartDataSourceSyncJobResponse] =
    FF.liftF(StartDataSourceSyncJobOp(request))

  def stopDataSourceSyncJob(
    request: StopDataSourceSyncJobRequest
  ): KendraIO[StopDataSourceSyncJobResponse] =
    FF.liftF(StopDataSourceSyncJobOp(request))

  def submitFeedback(
    request: SubmitFeedbackRequest
  ): KendraIO[SubmitFeedbackResponse] =
    FF.liftF(SubmitFeedbackOp(request))

  def tagResource(
    request: TagResourceRequest
  ): KendraIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): KendraIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDataSource(
    request: UpdateDataSourceRequest
  ): KendraIO[UpdateDataSourceResponse] =
    FF.liftF(UpdateDataSourceOp(request))

  def updateIndex(
    request: UpdateIndexRequest
  ): KendraIO[UpdateIndexResponse] =
    FF.liftF(UpdateIndexOp(request))

  def updateQuerySuggestionsBlockList(
    request: UpdateQuerySuggestionsBlockListRequest
  ): KendraIO[UpdateQuerySuggestionsBlockListResponse] =
    FF.liftF(UpdateQuerySuggestionsBlockListOp(request))

  def updateQuerySuggestionsConfig(
    request: UpdateQuerySuggestionsConfigRequest
  ): KendraIO[UpdateQuerySuggestionsConfigResponse] =
    FF.liftF(UpdateQuerySuggestionsConfigOp(request))

  def updateThesaurus(
    request: UpdateThesaurusRequest
  ): KendraIO[UpdateThesaurusResponse] =
    FF.liftF(UpdateThesaurusOp(request))
}
