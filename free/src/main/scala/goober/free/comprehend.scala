package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.comprehend.ComprehendClient
import software.amazon.awssdk.services.comprehend.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object comprehend { module =>

  // Free monad over ComprehendOp
  type ComprehendIO[A] = FF[ComprehendOp, A]

  sealed trait ComprehendOp[A] {
    def visit[F[_]](visitor: ComprehendOp.Visitor[F]): F[A]
  }

  object ComprehendOp {
    // Given a ComprehendClient we can embed a ComprehendIO program in any algebra that understands embedding.
    implicit val ComprehendOpEmbeddable: Embeddable[ComprehendOp, ComprehendClient] = new Embeddable[ComprehendOp, ComprehendClient] {
      def embed[A](client: ComprehendClient, io: ComprehendIO[A]): Embedded[A] = Embedded.Comprehend(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ComprehendOp.Visitor[Kleisli[M, ComprehendClient, *]] {
        def batchDetectDominantLanguage(
          request: BatchDetectDominantLanguageRequest
        ): Kleisli[M, ComprehendClient, BatchDetectDominantLanguageResponse] =
          primitive(_.batchDetectDominantLanguage(request))

        def batchDetectEntities(
          request: BatchDetectEntitiesRequest
        ): Kleisli[M, ComprehendClient, BatchDetectEntitiesResponse] =
          primitive(_.batchDetectEntities(request))

        def batchDetectKeyPhrases(
          request: BatchDetectKeyPhrasesRequest
        ): Kleisli[M, ComprehendClient, BatchDetectKeyPhrasesResponse] =
          primitive(_.batchDetectKeyPhrases(request))

        def batchDetectSentiment(
          request: BatchDetectSentimentRequest
        ): Kleisli[M, ComprehendClient, BatchDetectSentimentResponse] =
          primitive(_.batchDetectSentiment(request))

        def batchDetectSyntax(
          request: BatchDetectSyntaxRequest
        ): Kleisli[M, ComprehendClient, BatchDetectSyntaxResponse] =
          primitive(_.batchDetectSyntax(request))

        def classifyDocument(
          request: ClassifyDocumentRequest
        ): Kleisli[M, ComprehendClient, ClassifyDocumentResponse] =
          primitive(_.classifyDocument(request))

        def containsPiiEntities(
          request: ContainsPiiEntitiesRequest
        ): Kleisli[M, ComprehendClient, ContainsPiiEntitiesResponse] =
          primitive(_.containsPiiEntities(request))

        def createDocumentClassifier(
          request: CreateDocumentClassifierRequest
        ): Kleisli[M, ComprehendClient, CreateDocumentClassifierResponse] =
          primitive(_.createDocumentClassifier(request))

        def createEndpoint(
          request: CreateEndpointRequest
        ): Kleisli[M, ComprehendClient, CreateEndpointResponse] =
          primitive(_.createEndpoint(request))

        def createEntityRecognizer(
          request: CreateEntityRecognizerRequest
        ): Kleisli[M, ComprehendClient, CreateEntityRecognizerResponse] =
          primitive(_.createEntityRecognizer(request))

        def deleteDocumentClassifier(
          request: DeleteDocumentClassifierRequest
        ): Kleisli[M, ComprehendClient, DeleteDocumentClassifierResponse] =
          primitive(_.deleteDocumentClassifier(request))

        def deleteEndpoint(
          request: DeleteEndpointRequest
        ): Kleisli[M, ComprehendClient, DeleteEndpointResponse] =
          primitive(_.deleteEndpoint(request))

        def deleteEntityRecognizer(
          request: DeleteEntityRecognizerRequest
        ): Kleisli[M, ComprehendClient, DeleteEntityRecognizerResponse] =
          primitive(_.deleteEntityRecognizer(request))

        def describeDocumentClassificationJob(
          request: DescribeDocumentClassificationJobRequest
        ): Kleisli[M, ComprehendClient, DescribeDocumentClassificationJobResponse] =
          primitive(_.describeDocumentClassificationJob(request))

        def describeDocumentClassifier(
          request: DescribeDocumentClassifierRequest
        ): Kleisli[M, ComprehendClient, DescribeDocumentClassifierResponse] =
          primitive(_.describeDocumentClassifier(request))

        def describeDominantLanguageDetectionJob(
          request: DescribeDominantLanguageDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribeDominantLanguageDetectionJobResponse] =
          primitive(_.describeDominantLanguageDetectionJob(request))

        def describeEndpoint(
          request: DescribeEndpointRequest
        ): Kleisli[M, ComprehendClient, DescribeEndpointResponse] =
          primitive(_.describeEndpoint(request))

        def describeEntitiesDetectionJob(
          request: DescribeEntitiesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribeEntitiesDetectionJobResponse] =
          primitive(_.describeEntitiesDetectionJob(request))

        def describeEntityRecognizer(
          request: DescribeEntityRecognizerRequest
        ): Kleisli[M, ComprehendClient, DescribeEntityRecognizerResponse] =
          primitive(_.describeEntityRecognizer(request))

        def describeEventsDetectionJob(
          request: DescribeEventsDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribeEventsDetectionJobResponse] =
          primitive(_.describeEventsDetectionJob(request))

        def describeKeyPhrasesDetectionJob(
          request: DescribeKeyPhrasesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribeKeyPhrasesDetectionJobResponse] =
          primitive(_.describeKeyPhrasesDetectionJob(request))

        def describePiiEntitiesDetectionJob(
          request: DescribePiiEntitiesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribePiiEntitiesDetectionJobResponse] =
          primitive(_.describePiiEntitiesDetectionJob(request))

        def describeSentimentDetectionJob(
          request: DescribeSentimentDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribeSentimentDetectionJobResponse] =
          primitive(_.describeSentimentDetectionJob(request))

        def describeTopicsDetectionJob(
          request: DescribeTopicsDetectionJobRequest
        ): Kleisli[M, ComprehendClient, DescribeTopicsDetectionJobResponse] =
          primitive(_.describeTopicsDetectionJob(request))

        def detectDominantLanguage(
          request: DetectDominantLanguageRequest
        ): Kleisli[M, ComprehendClient, DetectDominantLanguageResponse] =
          primitive(_.detectDominantLanguage(request))

        def detectEntities(
          request: DetectEntitiesRequest
        ): Kleisli[M, ComprehendClient, DetectEntitiesResponse] =
          primitive(_.detectEntities(request))

        def detectKeyPhrases(
          request: DetectKeyPhrasesRequest
        ): Kleisli[M, ComprehendClient, DetectKeyPhrasesResponse] =
          primitive(_.detectKeyPhrases(request))

        def detectPiiEntities(
          request: DetectPiiEntitiesRequest
        ): Kleisli[M, ComprehendClient, DetectPiiEntitiesResponse] =
          primitive(_.detectPiiEntities(request))

        def detectSentiment(
          request: DetectSentimentRequest
        ): Kleisli[M, ComprehendClient, DetectSentimentResponse] =
          primitive(_.detectSentiment(request))

        def detectSyntax(
          request: DetectSyntaxRequest
        ): Kleisli[M, ComprehendClient, DetectSyntaxResponse] =
          primitive(_.detectSyntax(request))

        def listDocumentClassificationJobs(
          request: ListDocumentClassificationJobsRequest
        ): Kleisli[M, ComprehendClient, ListDocumentClassificationJobsResponse] =
          primitive(_.listDocumentClassificationJobs(request))

        def listDocumentClassifiers(
          request: ListDocumentClassifiersRequest
        ): Kleisli[M, ComprehendClient, ListDocumentClassifiersResponse] =
          primitive(_.listDocumentClassifiers(request))

        def listDominantLanguageDetectionJobs(
          request: ListDominantLanguageDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListDominantLanguageDetectionJobsResponse] =
          primitive(_.listDominantLanguageDetectionJobs(request))

        def listEndpoints(
          request: ListEndpointsRequest
        ): Kleisli[M, ComprehendClient, ListEndpointsResponse] =
          primitive(_.listEndpoints(request))

        def listEntitiesDetectionJobs(
          request: ListEntitiesDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListEntitiesDetectionJobsResponse] =
          primitive(_.listEntitiesDetectionJobs(request))

        def listEntityRecognizers(
          request: ListEntityRecognizersRequest
        ): Kleisli[M, ComprehendClient, ListEntityRecognizersResponse] =
          primitive(_.listEntityRecognizers(request))

        def listEventsDetectionJobs(
          request: ListEventsDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListEventsDetectionJobsResponse] =
          primitive(_.listEventsDetectionJobs(request))

        def listKeyPhrasesDetectionJobs(
          request: ListKeyPhrasesDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListKeyPhrasesDetectionJobsResponse] =
          primitive(_.listKeyPhrasesDetectionJobs(request))

        def listPiiEntitiesDetectionJobs(
          request: ListPiiEntitiesDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListPiiEntitiesDetectionJobsResponse] =
          primitive(_.listPiiEntitiesDetectionJobs(request))

        def listSentimentDetectionJobs(
          request: ListSentimentDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListSentimentDetectionJobsResponse] =
          primitive(_.listSentimentDetectionJobs(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ComprehendClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTopicsDetectionJobs(
          request: ListTopicsDetectionJobsRequest
        ): Kleisli[M, ComprehendClient, ListTopicsDetectionJobsResponse] =
          primitive(_.listTopicsDetectionJobs(request))

        def startDocumentClassificationJob(
          request: StartDocumentClassificationJobRequest
        ): Kleisli[M, ComprehendClient, StartDocumentClassificationJobResponse] =
          primitive(_.startDocumentClassificationJob(request))

        def startDominantLanguageDetectionJob(
          request: StartDominantLanguageDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartDominantLanguageDetectionJobResponse] =
          primitive(_.startDominantLanguageDetectionJob(request))

        def startEntitiesDetectionJob(
          request: StartEntitiesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartEntitiesDetectionJobResponse] =
          primitive(_.startEntitiesDetectionJob(request))

        def startEventsDetectionJob(
          request: StartEventsDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartEventsDetectionJobResponse] =
          primitive(_.startEventsDetectionJob(request))

        def startKeyPhrasesDetectionJob(
          request: StartKeyPhrasesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartKeyPhrasesDetectionJobResponse] =
          primitive(_.startKeyPhrasesDetectionJob(request))

        def startPiiEntitiesDetectionJob(
          request: StartPiiEntitiesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartPiiEntitiesDetectionJobResponse] =
          primitive(_.startPiiEntitiesDetectionJob(request))

        def startSentimentDetectionJob(
          request: StartSentimentDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartSentimentDetectionJobResponse] =
          primitive(_.startSentimentDetectionJob(request))

        def startTopicsDetectionJob(
          request: StartTopicsDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StartTopicsDetectionJobResponse] =
          primitive(_.startTopicsDetectionJob(request))

        def stopDominantLanguageDetectionJob(
          request: StopDominantLanguageDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StopDominantLanguageDetectionJobResponse] =
          primitive(_.stopDominantLanguageDetectionJob(request))

        def stopEntitiesDetectionJob(
          request: StopEntitiesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StopEntitiesDetectionJobResponse] =
          primitive(_.stopEntitiesDetectionJob(request))

        def stopEventsDetectionJob(
          request: StopEventsDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StopEventsDetectionJobResponse] =
          primitive(_.stopEventsDetectionJob(request))

        def stopKeyPhrasesDetectionJob(
          request: StopKeyPhrasesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StopKeyPhrasesDetectionJobResponse] =
          primitive(_.stopKeyPhrasesDetectionJob(request))

        def stopPiiEntitiesDetectionJob(
          request: StopPiiEntitiesDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StopPiiEntitiesDetectionJobResponse] =
          primitive(_.stopPiiEntitiesDetectionJob(request))

        def stopSentimentDetectionJob(
          request: StopSentimentDetectionJobRequest
        ): Kleisli[M, ComprehendClient, StopSentimentDetectionJobResponse] =
          primitive(_.stopSentimentDetectionJob(request))

        def stopTrainingDocumentClassifier(
          request: StopTrainingDocumentClassifierRequest
        ): Kleisli[M, ComprehendClient, StopTrainingDocumentClassifierResponse] =
          primitive(_.stopTrainingDocumentClassifier(request))

        def stopTrainingEntityRecognizer(
          request: StopTrainingEntityRecognizerRequest
        ): Kleisli[M, ComprehendClient, StopTrainingEntityRecognizerResponse] =
          primitive(_.stopTrainingEntityRecognizer(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ComprehendClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ComprehendClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateEndpoint(
          request: UpdateEndpointRequest
        ): Kleisli[M, ComprehendClient, UpdateEndpointResponse] =
          primitive(_.updateEndpoint(request))

        def primitive[A](
          f: ComprehendClient => A
        ): Kleisli[M, ComprehendClient, A]
      }
    }

    trait Visitor[F[_]] extends (ComprehendOp ~> F) {
      final def apply[A](op: ComprehendOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchDetectDominantLanguage(
        request: BatchDetectDominantLanguageRequest
      ): F[BatchDetectDominantLanguageResponse]

      def batchDetectEntities(
        request: BatchDetectEntitiesRequest
      ): F[BatchDetectEntitiesResponse]

      def batchDetectKeyPhrases(
        request: BatchDetectKeyPhrasesRequest
      ): F[BatchDetectKeyPhrasesResponse]

      def batchDetectSentiment(
        request: BatchDetectSentimentRequest
      ): F[BatchDetectSentimentResponse]

      def batchDetectSyntax(
        request: BatchDetectSyntaxRequest
      ): F[BatchDetectSyntaxResponse]

      def classifyDocument(
        request: ClassifyDocumentRequest
      ): F[ClassifyDocumentResponse]

      def containsPiiEntities(
        request: ContainsPiiEntitiesRequest
      ): F[ContainsPiiEntitiesResponse]

      def createDocumentClassifier(
        request: CreateDocumentClassifierRequest
      ): F[CreateDocumentClassifierResponse]

      def createEndpoint(
        request: CreateEndpointRequest
      ): F[CreateEndpointResponse]

      def createEntityRecognizer(
        request: CreateEntityRecognizerRequest
      ): F[CreateEntityRecognizerResponse]

      def deleteDocumentClassifier(
        request: DeleteDocumentClassifierRequest
      ): F[DeleteDocumentClassifierResponse]

      def deleteEndpoint(
        request: DeleteEndpointRequest
      ): F[DeleteEndpointResponse]

      def deleteEntityRecognizer(
        request: DeleteEntityRecognizerRequest
      ): F[DeleteEntityRecognizerResponse]

      def describeDocumentClassificationJob(
        request: DescribeDocumentClassificationJobRequest
      ): F[DescribeDocumentClassificationJobResponse]

      def describeDocumentClassifier(
        request: DescribeDocumentClassifierRequest
      ): F[DescribeDocumentClassifierResponse]

      def describeDominantLanguageDetectionJob(
        request: DescribeDominantLanguageDetectionJobRequest
      ): F[DescribeDominantLanguageDetectionJobResponse]

      def describeEndpoint(
        request: DescribeEndpointRequest
      ): F[DescribeEndpointResponse]

      def describeEntitiesDetectionJob(
        request: DescribeEntitiesDetectionJobRequest
      ): F[DescribeEntitiesDetectionJobResponse]

      def describeEntityRecognizer(
        request: DescribeEntityRecognizerRequest
      ): F[DescribeEntityRecognizerResponse]

      def describeEventsDetectionJob(
        request: DescribeEventsDetectionJobRequest
      ): F[DescribeEventsDetectionJobResponse]

      def describeKeyPhrasesDetectionJob(
        request: DescribeKeyPhrasesDetectionJobRequest
      ): F[DescribeKeyPhrasesDetectionJobResponse]

      def describePiiEntitiesDetectionJob(
        request: DescribePiiEntitiesDetectionJobRequest
      ): F[DescribePiiEntitiesDetectionJobResponse]

      def describeSentimentDetectionJob(
        request: DescribeSentimentDetectionJobRequest
      ): F[DescribeSentimentDetectionJobResponse]

      def describeTopicsDetectionJob(
        request: DescribeTopicsDetectionJobRequest
      ): F[DescribeTopicsDetectionJobResponse]

      def detectDominantLanguage(
        request: DetectDominantLanguageRequest
      ): F[DetectDominantLanguageResponse]

      def detectEntities(
        request: DetectEntitiesRequest
      ): F[DetectEntitiesResponse]

      def detectKeyPhrases(
        request: DetectKeyPhrasesRequest
      ): F[DetectKeyPhrasesResponse]

      def detectPiiEntities(
        request: DetectPiiEntitiesRequest
      ): F[DetectPiiEntitiesResponse]

      def detectSentiment(
        request: DetectSentimentRequest
      ): F[DetectSentimentResponse]

      def detectSyntax(
        request: DetectSyntaxRequest
      ): F[DetectSyntaxResponse]

      def listDocumentClassificationJobs(
        request: ListDocumentClassificationJobsRequest
      ): F[ListDocumentClassificationJobsResponse]

      def listDocumentClassifiers(
        request: ListDocumentClassifiersRequest
      ): F[ListDocumentClassifiersResponse]

      def listDominantLanguageDetectionJobs(
        request: ListDominantLanguageDetectionJobsRequest
      ): F[ListDominantLanguageDetectionJobsResponse]

      def listEndpoints(
        request: ListEndpointsRequest
      ): F[ListEndpointsResponse]

      def listEntitiesDetectionJobs(
        request: ListEntitiesDetectionJobsRequest
      ): F[ListEntitiesDetectionJobsResponse]

      def listEntityRecognizers(
        request: ListEntityRecognizersRequest
      ): F[ListEntityRecognizersResponse]

      def listEventsDetectionJobs(
        request: ListEventsDetectionJobsRequest
      ): F[ListEventsDetectionJobsResponse]

      def listKeyPhrasesDetectionJobs(
        request: ListKeyPhrasesDetectionJobsRequest
      ): F[ListKeyPhrasesDetectionJobsResponse]

      def listPiiEntitiesDetectionJobs(
        request: ListPiiEntitiesDetectionJobsRequest
      ): F[ListPiiEntitiesDetectionJobsResponse]

      def listSentimentDetectionJobs(
        request: ListSentimentDetectionJobsRequest
      ): F[ListSentimentDetectionJobsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTopicsDetectionJobs(
        request: ListTopicsDetectionJobsRequest
      ): F[ListTopicsDetectionJobsResponse]

      def startDocumentClassificationJob(
        request: StartDocumentClassificationJobRequest
      ): F[StartDocumentClassificationJobResponse]

      def startDominantLanguageDetectionJob(
        request: StartDominantLanguageDetectionJobRequest
      ): F[StartDominantLanguageDetectionJobResponse]

      def startEntitiesDetectionJob(
        request: StartEntitiesDetectionJobRequest
      ): F[StartEntitiesDetectionJobResponse]

      def startEventsDetectionJob(
        request: StartEventsDetectionJobRequest
      ): F[StartEventsDetectionJobResponse]

      def startKeyPhrasesDetectionJob(
        request: StartKeyPhrasesDetectionJobRequest
      ): F[StartKeyPhrasesDetectionJobResponse]

      def startPiiEntitiesDetectionJob(
        request: StartPiiEntitiesDetectionJobRequest
      ): F[StartPiiEntitiesDetectionJobResponse]

      def startSentimentDetectionJob(
        request: StartSentimentDetectionJobRequest
      ): F[StartSentimentDetectionJobResponse]

      def startTopicsDetectionJob(
        request: StartTopicsDetectionJobRequest
      ): F[StartTopicsDetectionJobResponse]

      def stopDominantLanguageDetectionJob(
        request: StopDominantLanguageDetectionJobRequest
      ): F[StopDominantLanguageDetectionJobResponse]

      def stopEntitiesDetectionJob(
        request: StopEntitiesDetectionJobRequest
      ): F[StopEntitiesDetectionJobResponse]

      def stopEventsDetectionJob(
        request: StopEventsDetectionJobRequest
      ): F[StopEventsDetectionJobResponse]

      def stopKeyPhrasesDetectionJob(
        request: StopKeyPhrasesDetectionJobRequest
      ): F[StopKeyPhrasesDetectionJobResponse]

      def stopPiiEntitiesDetectionJob(
        request: StopPiiEntitiesDetectionJobRequest
      ): F[StopPiiEntitiesDetectionJobResponse]

      def stopSentimentDetectionJob(
        request: StopSentimentDetectionJobRequest
      ): F[StopSentimentDetectionJobResponse]

      def stopTrainingDocumentClassifier(
        request: StopTrainingDocumentClassifierRequest
      ): F[StopTrainingDocumentClassifierResponse]

      def stopTrainingEntityRecognizer(
        request: StopTrainingEntityRecognizerRequest
      ): F[StopTrainingEntityRecognizerResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateEndpoint(
        request: UpdateEndpointRequest
      ): F[UpdateEndpointResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ComprehendOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchDetectDominantLanguageOp(
      request: BatchDetectDominantLanguageRequest
    ) extends ComprehendOp[BatchDetectDominantLanguageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDetectDominantLanguageResponse] =
        visitor.batchDetectDominantLanguage(request)
    }

    final case class BatchDetectEntitiesOp(
      request: BatchDetectEntitiesRequest
    ) extends ComprehendOp[BatchDetectEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDetectEntitiesResponse] =
        visitor.batchDetectEntities(request)
    }

    final case class BatchDetectKeyPhrasesOp(
      request: BatchDetectKeyPhrasesRequest
    ) extends ComprehendOp[BatchDetectKeyPhrasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDetectKeyPhrasesResponse] =
        visitor.batchDetectKeyPhrases(request)
    }

    final case class BatchDetectSentimentOp(
      request: BatchDetectSentimentRequest
    ) extends ComprehendOp[BatchDetectSentimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDetectSentimentResponse] =
        visitor.batchDetectSentiment(request)
    }

    final case class BatchDetectSyntaxOp(
      request: BatchDetectSyntaxRequest
    ) extends ComprehendOp[BatchDetectSyntaxResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDetectSyntaxResponse] =
        visitor.batchDetectSyntax(request)
    }

    final case class ClassifyDocumentOp(
      request: ClassifyDocumentRequest
    ) extends ComprehendOp[ClassifyDocumentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ClassifyDocumentResponse] =
        visitor.classifyDocument(request)
    }

    final case class ContainsPiiEntitiesOp(
      request: ContainsPiiEntitiesRequest
    ) extends ComprehendOp[ContainsPiiEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ContainsPiiEntitiesResponse] =
        visitor.containsPiiEntities(request)
    }

    final case class CreateDocumentClassifierOp(
      request: CreateDocumentClassifierRequest
    ) extends ComprehendOp[CreateDocumentClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDocumentClassifierResponse] =
        visitor.createDocumentClassifier(request)
    }

    final case class CreateEndpointOp(
      request: CreateEndpointRequest
    ) extends ComprehendOp[CreateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEndpointResponse] =
        visitor.createEndpoint(request)
    }

    final case class CreateEntityRecognizerOp(
      request: CreateEntityRecognizerRequest
    ) extends ComprehendOp[CreateEntityRecognizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEntityRecognizerResponse] =
        visitor.createEntityRecognizer(request)
    }

    final case class DeleteDocumentClassifierOp(
      request: DeleteDocumentClassifierRequest
    ) extends ComprehendOp[DeleteDocumentClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDocumentClassifierResponse] =
        visitor.deleteDocumentClassifier(request)
    }

    final case class DeleteEndpointOp(
      request: DeleteEndpointRequest
    ) extends ComprehendOp[DeleteEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEndpointResponse] =
        visitor.deleteEndpoint(request)
    }

    final case class DeleteEntityRecognizerOp(
      request: DeleteEntityRecognizerRequest
    ) extends ComprehendOp[DeleteEntityRecognizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEntityRecognizerResponse] =
        visitor.deleteEntityRecognizer(request)
    }

    final case class DescribeDocumentClassificationJobOp(
      request: DescribeDocumentClassificationJobRequest
    ) extends ComprehendOp[DescribeDocumentClassificationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDocumentClassificationJobResponse] =
        visitor.describeDocumentClassificationJob(request)
    }

    final case class DescribeDocumentClassifierOp(
      request: DescribeDocumentClassifierRequest
    ) extends ComprehendOp[DescribeDocumentClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDocumentClassifierResponse] =
        visitor.describeDocumentClassifier(request)
    }

    final case class DescribeDominantLanguageDetectionJobOp(
      request: DescribeDominantLanguageDetectionJobRequest
    ) extends ComprehendOp[DescribeDominantLanguageDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDominantLanguageDetectionJobResponse] =
        visitor.describeDominantLanguageDetectionJob(request)
    }

    final case class DescribeEndpointOp(
      request: DescribeEndpointRequest
    ) extends ComprehendOp[DescribeEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEndpointResponse] =
        visitor.describeEndpoint(request)
    }

    final case class DescribeEntitiesDetectionJobOp(
      request: DescribeEntitiesDetectionJobRequest
    ) extends ComprehendOp[DescribeEntitiesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEntitiesDetectionJobResponse] =
        visitor.describeEntitiesDetectionJob(request)
    }

    final case class DescribeEntityRecognizerOp(
      request: DescribeEntityRecognizerRequest
    ) extends ComprehendOp[DescribeEntityRecognizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEntityRecognizerResponse] =
        visitor.describeEntityRecognizer(request)
    }

    final case class DescribeEventsDetectionJobOp(
      request: DescribeEventsDetectionJobRequest
    ) extends ComprehendOp[DescribeEventsDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventsDetectionJobResponse] =
        visitor.describeEventsDetectionJob(request)
    }

    final case class DescribeKeyPhrasesDetectionJobOp(
      request: DescribeKeyPhrasesDetectionJobRequest
    ) extends ComprehendOp[DescribeKeyPhrasesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeKeyPhrasesDetectionJobResponse] =
        visitor.describeKeyPhrasesDetectionJob(request)
    }

    final case class DescribePiiEntitiesDetectionJobOp(
      request: DescribePiiEntitiesDetectionJobRequest
    ) extends ComprehendOp[DescribePiiEntitiesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePiiEntitiesDetectionJobResponse] =
        visitor.describePiiEntitiesDetectionJob(request)
    }

    final case class DescribeSentimentDetectionJobOp(
      request: DescribeSentimentDetectionJobRequest
    ) extends ComprehendOp[DescribeSentimentDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSentimentDetectionJobResponse] =
        visitor.describeSentimentDetectionJob(request)
    }

    final case class DescribeTopicsDetectionJobOp(
      request: DescribeTopicsDetectionJobRequest
    ) extends ComprehendOp[DescribeTopicsDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTopicsDetectionJobResponse] =
        visitor.describeTopicsDetectionJob(request)
    }

    final case class DetectDominantLanguageOp(
      request: DetectDominantLanguageRequest
    ) extends ComprehendOp[DetectDominantLanguageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectDominantLanguageResponse] =
        visitor.detectDominantLanguage(request)
    }

    final case class DetectEntitiesOp(
      request: DetectEntitiesRequest
    ) extends ComprehendOp[DetectEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectEntitiesResponse] =
        visitor.detectEntities(request)
    }

    final case class DetectKeyPhrasesOp(
      request: DetectKeyPhrasesRequest
    ) extends ComprehendOp[DetectKeyPhrasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectKeyPhrasesResponse] =
        visitor.detectKeyPhrases(request)
    }

    final case class DetectPiiEntitiesOp(
      request: DetectPiiEntitiesRequest
    ) extends ComprehendOp[DetectPiiEntitiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectPiiEntitiesResponse] =
        visitor.detectPiiEntities(request)
    }

    final case class DetectSentimentOp(
      request: DetectSentimentRequest
    ) extends ComprehendOp[DetectSentimentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectSentimentResponse] =
        visitor.detectSentiment(request)
    }

    final case class DetectSyntaxOp(
      request: DetectSyntaxRequest
    ) extends ComprehendOp[DetectSyntaxResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectSyntaxResponse] =
        visitor.detectSyntax(request)
    }

    final case class ListDocumentClassificationJobsOp(
      request: ListDocumentClassificationJobsRequest
    ) extends ComprehendOp[ListDocumentClassificationJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDocumentClassificationJobsResponse] =
        visitor.listDocumentClassificationJobs(request)
    }

    final case class ListDocumentClassifiersOp(
      request: ListDocumentClassifiersRequest
    ) extends ComprehendOp[ListDocumentClassifiersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDocumentClassifiersResponse] =
        visitor.listDocumentClassifiers(request)
    }

    final case class ListDominantLanguageDetectionJobsOp(
      request: ListDominantLanguageDetectionJobsRequest
    ) extends ComprehendOp[ListDominantLanguageDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDominantLanguageDetectionJobsResponse] =
        visitor.listDominantLanguageDetectionJobs(request)
    }

    final case class ListEndpointsOp(
      request: ListEndpointsRequest
    ) extends ComprehendOp[ListEndpointsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEndpointsResponse] =
        visitor.listEndpoints(request)
    }

    final case class ListEntitiesDetectionJobsOp(
      request: ListEntitiesDetectionJobsRequest
    ) extends ComprehendOp[ListEntitiesDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEntitiesDetectionJobsResponse] =
        visitor.listEntitiesDetectionJobs(request)
    }

    final case class ListEntityRecognizersOp(
      request: ListEntityRecognizersRequest
    ) extends ComprehendOp[ListEntityRecognizersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEntityRecognizersResponse] =
        visitor.listEntityRecognizers(request)
    }

    final case class ListEventsDetectionJobsOp(
      request: ListEventsDetectionJobsRequest
    ) extends ComprehendOp[ListEventsDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventsDetectionJobsResponse] =
        visitor.listEventsDetectionJobs(request)
    }

    final case class ListKeyPhrasesDetectionJobsOp(
      request: ListKeyPhrasesDetectionJobsRequest
    ) extends ComprehendOp[ListKeyPhrasesDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListKeyPhrasesDetectionJobsResponse] =
        visitor.listKeyPhrasesDetectionJobs(request)
    }

    final case class ListPiiEntitiesDetectionJobsOp(
      request: ListPiiEntitiesDetectionJobsRequest
    ) extends ComprehendOp[ListPiiEntitiesDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPiiEntitiesDetectionJobsResponse] =
        visitor.listPiiEntitiesDetectionJobs(request)
    }

    final case class ListSentimentDetectionJobsOp(
      request: ListSentimentDetectionJobsRequest
    ) extends ComprehendOp[ListSentimentDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSentimentDetectionJobsResponse] =
        visitor.listSentimentDetectionJobs(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ComprehendOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTopicsDetectionJobsOp(
      request: ListTopicsDetectionJobsRequest
    ) extends ComprehendOp[ListTopicsDetectionJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTopicsDetectionJobsResponse] =
        visitor.listTopicsDetectionJobs(request)
    }

    final case class StartDocumentClassificationJobOp(
      request: StartDocumentClassificationJobRequest
    ) extends ComprehendOp[StartDocumentClassificationJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDocumentClassificationJobResponse] =
        visitor.startDocumentClassificationJob(request)
    }

    final case class StartDominantLanguageDetectionJobOp(
      request: StartDominantLanguageDetectionJobRequest
    ) extends ComprehendOp[StartDominantLanguageDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDominantLanguageDetectionJobResponse] =
        visitor.startDominantLanguageDetectionJob(request)
    }

    final case class StartEntitiesDetectionJobOp(
      request: StartEntitiesDetectionJobRequest
    ) extends ComprehendOp[StartEntitiesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartEntitiesDetectionJobResponse] =
        visitor.startEntitiesDetectionJob(request)
    }

    final case class StartEventsDetectionJobOp(
      request: StartEventsDetectionJobRequest
    ) extends ComprehendOp[StartEventsDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartEventsDetectionJobResponse] =
        visitor.startEventsDetectionJob(request)
    }

    final case class StartKeyPhrasesDetectionJobOp(
      request: StartKeyPhrasesDetectionJobRequest
    ) extends ComprehendOp[StartKeyPhrasesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartKeyPhrasesDetectionJobResponse] =
        visitor.startKeyPhrasesDetectionJob(request)
    }

    final case class StartPiiEntitiesDetectionJobOp(
      request: StartPiiEntitiesDetectionJobRequest
    ) extends ComprehendOp[StartPiiEntitiesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPiiEntitiesDetectionJobResponse] =
        visitor.startPiiEntitiesDetectionJob(request)
    }

    final case class StartSentimentDetectionJobOp(
      request: StartSentimentDetectionJobRequest
    ) extends ComprehendOp[StartSentimentDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSentimentDetectionJobResponse] =
        visitor.startSentimentDetectionJob(request)
    }

    final case class StartTopicsDetectionJobOp(
      request: StartTopicsDetectionJobRequest
    ) extends ComprehendOp[StartTopicsDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTopicsDetectionJobResponse] =
        visitor.startTopicsDetectionJob(request)
    }

    final case class StopDominantLanguageDetectionJobOp(
      request: StopDominantLanguageDetectionJobRequest
    ) extends ComprehendOp[StopDominantLanguageDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDominantLanguageDetectionJobResponse] =
        visitor.stopDominantLanguageDetectionJob(request)
    }

    final case class StopEntitiesDetectionJobOp(
      request: StopEntitiesDetectionJobRequest
    ) extends ComprehendOp[StopEntitiesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopEntitiesDetectionJobResponse] =
        visitor.stopEntitiesDetectionJob(request)
    }

    final case class StopEventsDetectionJobOp(
      request: StopEventsDetectionJobRequest
    ) extends ComprehendOp[StopEventsDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopEventsDetectionJobResponse] =
        visitor.stopEventsDetectionJob(request)
    }

    final case class StopKeyPhrasesDetectionJobOp(
      request: StopKeyPhrasesDetectionJobRequest
    ) extends ComprehendOp[StopKeyPhrasesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopKeyPhrasesDetectionJobResponse] =
        visitor.stopKeyPhrasesDetectionJob(request)
    }

    final case class StopPiiEntitiesDetectionJobOp(
      request: StopPiiEntitiesDetectionJobRequest
    ) extends ComprehendOp[StopPiiEntitiesDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopPiiEntitiesDetectionJobResponse] =
        visitor.stopPiiEntitiesDetectionJob(request)
    }

    final case class StopSentimentDetectionJobOp(
      request: StopSentimentDetectionJobRequest
    ) extends ComprehendOp[StopSentimentDetectionJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopSentimentDetectionJobResponse] =
        visitor.stopSentimentDetectionJob(request)
    }

    final case class StopTrainingDocumentClassifierOp(
      request: StopTrainingDocumentClassifierRequest
    ) extends ComprehendOp[StopTrainingDocumentClassifierResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTrainingDocumentClassifierResponse] =
        visitor.stopTrainingDocumentClassifier(request)
    }

    final case class StopTrainingEntityRecognizerOp(
      request: StopTrainingEntityRecognizerRequest
    ) extends ComprehendOp[StopTrainingEntityRecognizerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTrainingEntityRecognizerResponse] =
        visitor.stopTrainingEntityRecognizer(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ComprehendOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ComprehendOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateEndpointOp(
      request: UpdateEndpointRequest
    ) extends ComprehendOp[UpdateEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateEndpointResponse] =
        visitor.updateEndpoint(request)
    }
  }

  import ComprehendOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ComprehendOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchDetectDominantLanguage(
    request: BatchDetectDominantLanguageRequest
  ): ComprehendIO[BatchDetectDominantLanguageResponse] =
    FF.liftF(BatchDetectDominantLanguageOp(request))

  def batchDetectEntities(
    request: BatchDetectEntitiesRequest
  ): ComprehendIO[BatchDetectEntitiesResponse] =
    FF.liftF(BatchDetectEntitiesOp(request))

  def batchDetectKeyPhrases(
    request: BatchDetectKeyPhrasesRequest
  ): ComprehendIO[BatchDetectKeyPhrasesResponse] =
    FF.liftF(BatchDetectKeyPhrasesOp(request))

  def batchDetectSentiment(
    request: BatchDetectSentimentRequest
  ): ComprehendIO[BatchDetectSentimentResponse] =
    FF.liftF(BatchDetectSentimentOp(request))

  def batchDetectSyntax(
    request: BatchDetectSyntaxRequest
  ): ComprehendIO[BatchDetectSyntaxResponse] =
    FF.liftF(BatchDetectSyntaxOp(request))

  def classifyDocument(
    request: ClassifyDocumentRequest
  ): ComprehendIO[ClassifyDocumentResponse] =
    FF.liftF(ClassifyDocumentOp(request))

  def containsPiiEntities(
    request: ContainsPiiEntitiesRequest
  ): ComprehendIO[ContainsPiiEntitiesResponse] =
    FF.liftF(ContainsPiiEntitiesOp(request))

  def createDocumentClassifier(
    request: CreateDocumentClassifierRequest
  ): ComprehendIO[CreateDocumentClassifierResponse] =
    FF.liftF(CreateDocumentClassifierOp(request))

  def createEndpoint(
    request: CreateEndpointRequest
  ): ComprehendIO[CreateEndpointResponse] =
    FF.liftF(CreateEndpointOp(request))

  def createEntityRecognizer(
    request: CreateEntityRecognizerRequest
  ): ComprehendIO[CreateEntityRecognizerResponse] =
    FF.liftF(CreateEntityRecognizerOp(request))

  def deleteDocumentClassifier(
    request: DeleteDocumentClassifierRequest
  ): ComprehendIO[DeleteDocumentClassifierResponse] =
    FF.liftF(DeleteDocumentClassifierOp(request))

  def deleteEndpoint(
    request: DeleteEndpointRequest
  ): ComprehendIO[DeleteEndpointResponse] =
    FF.liftF(DeleteEndpointOp(request))

  def deleteEntityRecognizer(
    request: DeleteEntityRecognizerRequest
  ): ComprehendIO[DeleteEntityRecognizerResponse] =
    FF.liftF(DeleteEntityRecognizerOp(request))

  def describeDocumentClassificationJob(
    request: DescribeDocumentClassificationJobRequest
  ): ComprehendIO[DescribeDocumentClassificationJobResponse] =
    FF.liftF(DescribeDocumentClassificationJobOp(request))

  def describeDocumentClassifier(
    request: DescribeDocumentClassifierRequest
  ): ComprehendIO[DescribeDocumentClassifierResponse] =
    FF.liftF(DescribeDocumentClassifierOp(request))

  def describeDominantLanguageDetectionJob(
    request: DescribeDominantLanguageDetectionJobRequest
  ): ComprehendIO[DescribeDominantLanguageDetectionJobResponse] =
    FF.liftF(DescribeDominantLanguageDetectionJobOp(request))

  def describeEndpoint(
    request: DescribeEndpointRequest
  ): ComprehendIO[DescribeEndpointResponse] =
    FF.liftF(DescribeEndpointOp(request))

  def describeEntitiesDetectionJob(
    request: DescribeEntitiesDetectionJobRequest
  ): ComprehendIO[DescribeEntitiesDetectionJobResponse] =
    FF.liftF(DescribeEntitiesDetectionJobOp(request))

  def describeEntityRecognizer(
    request: DescribeEntityRecognizerRequest
  ): ComprehendIO[DescribeEntityRecognizerResponse] =
    FF.liftF(DescribeEntityRecognizerOp(request))

  def describeEventsDetectionJob(
    request: DescribeEventsDetectionJobRequest
  ): ComprehendIO[DescribeEventsDetectionJobResponse] =
    FF.liftF(DescribeEventsDetectionJobOp(request))

  def describeKeyPhrasesDetectionJob(
    request: DescribeKeyPhrasesDetectionJobRequest
  ): ComprehendIO[DescribeKeyPhrasesDetectionJobResponse] =
    FF.liftF(DescribeKeyPhrasesDetectionJobOp(request))

  def describePiiEntitiesDetectionJob(
    request: DescribePiiEntitiesDetectionJobRequest
  ): ComprehendIO[DescribePiiEntitiesDetectionJobResponse] =
    FF.liftF(DescribePiiEntitiesDetectionJobOp(request))

  def describeSentimentDetectionJob(
    request: DescribeSentimentDetectionJobRequest
  ): ComprehendIO[DescribeSentimentDetectionJobResponse] =
    FF.liftF(DescribeSentimentDetectionJobOp(request))

  def describeTopicsDetectionJob(
    request: DescribeTopicsDetectionJobRequest
  ): ComprehendIO[DescribeTopicsDetectionJobResponse] =
    FF.liftF(DescribeTopicsDetectionJobOp(request))

  def detectDominantLanguage(
    request: DetectDominantLanguageRequest
  ): ComprehendIO[DetectDominantLanguageResponse] =
    FF.liftF(DetectDominantLanguageOp(request))

  def detectEntities(
    request: DetectEntitiesRequest
  ): ComprehendIO[DetectEntitiesResponse] =
    FF.liftF(DetectEntitiesOp(request))

  def detectKeyPhrases(
    request: DetectKeyPhrasesRequest
  ): ComprehendIO[DetectKeyPhrasesResponse] =
    FF.liftF(DetectKeyPhrasesOp(request))

  def detectPiiEntities(
    request: DetectPiiEntitiesRequest
  ): ComprehendIO[DetectPiiEntitiesResponse] =
    FF.liftF(DetectPiiEntitiesOp(request))

  def detectSentiment(
    request: DetectSentimentRequest
  ): ComprehendIO[DetectSentimentResponse] =
    FF.liftF(DetectSentimentOp(request))

  def detectSyntax(
    request: DetectSyntaxRequest
  ): ComprehendIO[DetectSyntaxResponse] =
    FF.liftF(DetectSyntaxOp(request))

  def listDocumentClassificationJobs(
    request: ListDocumentClassificationJobsRequest
  ): ComprehendIO[ListDocumentClassificationJobsResponse] =
    FF.liftF(ListDocumentClassificationJobsOp(request))

  def listDocumentClassifiers(
    request: ListDocumentClassifiersRequest
  ): ComprehendIO[ListDocumentClassifiersResponse] =
    FF.liftF(ListDocumentClassifiersOp(request))

  def listDominantLanguageDetectionJobs(
    request: ListDominantLanguageDetectionJobsRequest
  ): ComprehendIO[ListDominantLanguageDetectionJobsResponse] =
    FF.liftF(ListDominantLanguageDetectionJobsOp(request))

  def listEndpoints(
    request: ListEndpointsRequest
  ): ComprehendIO[ListEndpointsResponse] =
    FF.liftF(ListEndpointsOp(request))

  def listEntitiesDetectionJobs(
    request: ListEntitiesDetectionJobsRequest
  ): ComprehendIO[ListEntitiesDetectionJobsResponse] =
    FF.liftF(ListEntitiesDetectionJobsOp(request))

  def listEntityRecognizers(
    request: ListEntityRecognizersRequest
  ): ComprehendIO[ListEntityRecognizersResponse] =
    FF.liftF(ListEntityRecognizersOp(request))

  def listEventsDetectionJobs(
    request: ListEventsDetectionJobsRequest
  ): ComprehendIO[ListEventsDetectionJobsResponse] =
    FF.liftF(ListEventsDetectionJobsOp(request))

  def listKeyPhrasesDetectionJobs(
    request: ListKeyPhrasesDetectionJobsRequest
  ): ComprehendIO[ListKeyPhrasesDetectionJobsResponse] =
    FF.liftF(ListKeyPhrasesDetectionJobsOp(request))

  def listPiiEntitiesDetectionJobs(
    request: ListPiiEntitiesDetectionJobsRequest
  ): ComprehendIO[ListPiiEntitiesDetectionJobsResponse] =
    FF.liftF(ListPiiEntitiesDetectionJobsOp(request))

  def listSentimentDetectionJobs(
    request: ListSentimentDetectionJobsRequest
  ): ComprehendIO[ListSentimentDetectionJobsResponse] =
    FF.liftF(ListSentimentDetectionJobsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ComprehendIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTopicsDetectionJobs(
    request: ListTopicsDetectionJobsRequest
  ): ComprehendIO[ListTopicsDetectionJobsResponse] =
    FF.liftF(ListTopicsDetectionJobsOp(request))

  def startDocumentClassificationJob(
    request: StartDocumentClassificationJobRequest
  ): ComprehendIO[StartDocumentClassificationJobResponse] =
    FF.liftF(StartDocumentClassificationJobOp(request))

  def startDominantLanguageDetectionJob(
    request: StartDominantLanguageDetectionJobRequest
  ): ComprehendIO[StartDominantLanguageDetectionJobResponse] =
    FF.liftF(StartDominantLanguageDetectionJobOp(request))

  def startEntitiesDetectionJob(
    request: StartEntitiesDetectionJobRequest
  ): ComprehendIO[StartEntitiesDetectionJobResponse] =
    FF.liftF(StartEntitiesDetectionJobOp(request))

  def startEventsDetectionJob(
    request: StartEventsDetectionJobRequest
  ): ComprehendIO[StartEventsDetectionJobResponse] =
    FF.liftF(StartEventsDetectionJobOp(request))

  def startKeyPhrasesDetectionJob(
    request: StartKeyPhrasesDetectionJobRequest
  ): ComprehendIO[StartKeyPhrasesDetectionJobResponse] =
    FF.liftF(StartKeyPhrasesDetectionJobOp(request))

  def startPiiEntitiesDetectionJob(
    request: StartPiiEntitiesDetectionJobRequest
  ): ComprehendIO[StartPiiEntitiesDetectionJobResponse] =
    FF.liftF(StartPiiEntitiesDetectionJobOp(request))

  def startSentimentDetectionJob(
    request: StartSentimentDetectionJobRequest
  ): ComprehendIO[StartSentimentDetectionJobResponse] =
    FF.liftF(StartSentimentDetectionJobOp(request))

  def startTopicsDetectionJob(
    request: StartTopicsDetectionJobRequest
  ): ComprehendIO[StartTopicsDetectionJobResponse] =
    FF.liftF(StartTopicsDetectionJobOp(request))

  def stopDominantLanguageDetectionJob(
    request: StopDominantLanguageDetectionJobRequest
  ): ComprehendIO[StopDominantLanguageDetectionJobResponse] =
    FF.liftF(StopDominantLanguageDetectionJobOp(request))

  def stopEntitiesDetectionJob(
    request: StopEntitiesDetectionJobRequest
  ): ComprehendIO[StopEntitiesDetectionJobResponse] =
    FF.liftF(StopEntitiesDetectionJobOp(request))

  def stopEventsDetectionJob(
    request: StopEventsDetectionJobRequest
  ): ComprehendIO[StopEventsDetectionJobResponse] =
    FF.liftF(StopEventsDetectionJobOp(request))

  def stopKeyPhrasesDetectionJob(
    request: StopKeyPhrasesDetectionJobRequest
  ): ComprehendIO[StopKeyPhrasesDetectionJobResponse] =
    FF.liftF(StopKeyPhrasesDetectionJobOp(request))

  def stopPiiEntitiesDetectionJob(
    request: StopPiiEntitiesDetectionJobRequest
  ): ComprehendIO[StopPiiEntitiesDetectionJobResponse] =
    FF.liftF(StopPiiEntitiesDetectionJobOp(request))

  def stopSentimentDetectionJob(
    request: StopSentimentDetectionJobRequest
  ): ComprehendIO[StopSentimentDetectionJobResponse] =
    FF.liftF(StopSentimentDetectionJobOp(request))

  def stopTrainingDocumentClassifier(
    request: StopTrainingDocumentClassifierRequest
  ): ComprehendIO[StopTrainingDocumentClassifierResponse] =
    FF.liftF(StopTrainingDocumentClassifierOp(request))

  def stopTrainingEntityRecognizer(
    request: StopTrainingEntityRecognizerRequest
  ): ComprehendIO[StopTrainingEntityRecognizerResponse] =
    FF.liftF(StopTrainingEntityRecognizerOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ComprehendIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ComprehendIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateEndpoint(
    request: UpdateEndpointRequest
  ): ComprehendIO[UpdateEndpointResponse] =
    FF.liftF(UpdateEndpointOp(request))
}
