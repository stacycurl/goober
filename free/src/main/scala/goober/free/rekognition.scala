package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.rekognition.RekognitionClient
import software.amazon.awssdk.services.rekognition.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object rekognition { module =>

  // Free monad over RekognitionOp
  type RekognitionIO[A] = FF[RekognitionOp, A]

  sealed trait RekognitionOp[A] {
    def visit[F[_]](visitor: RekognitionOp.Visitor[F]): F[A]
  }

  object RekognitionOp {
    // Given a RekognitionClient we can embed a RekognitionIO program in any algebra that understands embedding.
    implicit val RekognitionOpEmbeddable: Embeddable[RekognitionOp, RekognitionClient] = new Embeddable[RekognitionOp, RekognitionClient] {
      def embed[A](client: RekognitionClient, io: RekognitionIO[A]): Embedded[A] = Embedded.Rekognition(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends RekognitionOp.Visitor[Kleisli[M, RekognitionClient, *]] {
        def compareFaces(
          request: CompareFacesRequest
        ): Kleisli[M, RekognitionClient, CompareFacesResponse] =
          primitive(_.compareFaces(request))

        def createCollection(
          request: CreateCollectionRequest
        ): Kleisli[M, RekognitionClient, CreateCollectionResponse] =
          primitive(_.createCollection(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, RekognitionClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def createProjectVersion(
          request: CreateProjectVersionRequest
        ): Kleisli[M, RekognitionClient, CreateProjectVersionResponse] =
          primitive(_.createProjectVersion(request))

        def createStreamProcessor(
          request: CreateStreamProcessorRequest
        ): Kleisli[M, RekognitionClient, CreateStreamProcessorResponse] =
          primitive(_.createStreamProcessor(request))

        def deleteCollection(
          request: DeleteCollectionRequest
        ): Kleisli[M, RekognitionClient, DeleteCollectionResponse] =
          primitive(_.deleteCollection(request))

        def deleteFaces(
          request: DeleteFacesRequest
        ): Kleisli[M, RekognitionClient, DeleteFacesResponse] =
          primitive(_.deleteFaces(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, RekognitionClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def deleteProjectVersion(
          request: DeleteProjectVersionRequest
        ): Kleisli[M, RekognitionClient, DeleteProjectVersionResponse] =
          primitive(_.deleteProjectVersion(request))

        def deleteStreamProcessor(
          request: DeleteStreamProcessorRequest
        ): Kleisli[M, RekognitionClient, DeleteStreamProcessorResponse] =
          primitive(_.deleteStreamProcessor(request))

        def describeCollection(
          request: DescribeCollectionRequest
        ): Kleisli[M, RekognitionClient, DescribeCollectionResponse] =
          primitive(_.describeCollection(request))

        def describeProjectVersions(
          request: DescribeProjectVersionsRequest
        ): Kleisli[M, RekognitionClient, DescribeProjectVersionsResponse] =
          primitive(_.describeProjectVersions(request))

        def describeProjects(
          request: DescribeProjectsRequest
        ): Kleisli[M, RekognitionClient, DescribeProjectsResponse] =
          primitive(_.describeProjects(request))

        def describeStreamProcessor(
          request: DescribeStreamProcessorRequest
        ): Kleisli[M, RekognitionClient, DescribeStreamProcessorResponse] =
          primitive(_.describeStreamProcessor(request))

        def detectCustomLabels(
          request: DetectCustomLabelsRequest
        ): Kleisli[M, RekognitionClient, DetectCustomLabelsResponse] =
          primitive(_.detectCustomLabels(request))

        def detectFaces(
          request: DetectFacesRequest
        ): Kleisli[M, RekognitionClient, DetectFacesResponse] =
          primitive(_.detectFaces(request))

        def detectLabels(
          request: DetectLabelsRequest
        ): Kleisli[M, RekognitionClient, DetectLabelsResponse] =
          primitive(_.detectLabels(request))

        def detectModerationLabels(
          request: DetectModerationLabelsRequest
        ): Kleisli[M, RekognitionClient, DetectModerationLabelsResponse] =
          primitive(_.detectModerationLabels(request))

        def detectProtectiveEquipment(
          request: DetectProtectiveEquipmentRequest
        ): Kleisli[M, RekognitionClient, DetectProtectiveEquipmentResponse] =
          primitive(_.detectProtectiveEquipment(request))

        def detectText(
          request: DetectTextRequest
        ): Kleisli[M, RekognitionClient, DetectTextResponse] =
          primitive(_.detectText(request))

        def getCelebrityInfo(
          request: GetCelebrityInfoRequest
        ): Kleisli[M, RekognitionClient, GetCelebrityInfoResponse] =
          primitive(_.getCelebrityInfo(request))

        def getCelebrityRecognition(
          request: GetCelebrityRecognitionRequest
        ): Kleisli[M, RekognitionClient, GetCelebrityRecognitionResponse] =
          primitive(_.getCelebrityRecognition(request))

        def getContentModeration(
          request: GetContentModerationRequest
        ): Kleisli[M, RekognitionClient, GetContentModerationResponse] =
          primitive(_.getContentModeration(request))

        def getFaceDetection(
          request: GetFaceDetectionRequest
        ): Kleisli[M, RekognitionClient, GetFaceDetectionResponse] =
          primitive(_.getFaceDetection(request))

        def getFaceSearch(
          request: GetFaceSearchRequest
        ): Kleisli[M, RekognitionClient, GetFaceSearchResponse] =
          primitive(_.getFaceSearch(request))

        def getLabelDetection(
          request: GetLabelDetectionRequest
        ): Kleisli[M, RekognitionClient, GetLabelDetectionResponse] =
          primitive(_.getLabelDetection(request))

        def getPersonTracking(
          request: GetPersonTrackingRequest
        ): Kleisli[M, RekognitionClient, GetPersonTrackingResponse] =
          primitive(_.getPersonTracking(request))

        def getSegmentDetection(
          request: GetSegmentDetectionRequest
        ): Kleisli[M, RekognitionClient, GetSegmentDetectionResponse] =
          primitive(_.getSegmentDetection(request))

        def getTextDetection(
          request: GetTextDetectionRequest
        ): Kleisli[M, RekognitionClient, GetTextDetectionResponse] =
          primitive(_.getTextDetection(request))

        def indexFaces(
          request: IndexFacesRequest
        ): Kleisli[M, RekognitionClient, IndexFacesResponse] =
          primitive(_.indexFaces(request))

        def listCollections(
          request: ListCollectionsRequest
        ): Kleisli[M, RekognitionClient, ListCollectionsResponse] =
          primitive(_.listCollections(request))

        def listFaces(
          request: ListFacesRequest
        ): Kleisli[M, RekognitionClient, ListFacesResponse] =
          primitive(_.listFaces(request))

        def listStreamProcessors(
          request: ListStreamProcessorsRequest
        ): Kleisli[M, RekognitionClient, ListStreamProcessorsResponse] =
          primitive(_.listStreamProcessors(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, RekognitionClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def recognizeCelebrities(
          request: RecognizeCelebritiesRequest
        ): Kleisli[M, RekognitionClient, RecognizeCelebritiesResponse] =
          primitive(_.recognizeCelebrities(request))

        def searchFaces(
          request: SearchFacesRequest
        ): Kleisli[M, RekognitionClient, SearchFacesResponse] =
          primitive(_.searchFaces(request))

        def searchFacesByImage(
          request: SearchFacesByImageRequest
        ): Kleisli[M, RekognitionClient, SearchFacesByImageResponse] =
          primitive(_.searchFacesByImage(request))

        def startCelebrityRecognition(
          request: StartCelebrityRecognitionRequest
        ): Kleisli[M, RekognitionClient, StartCelebrityRecognitionResponse] =
          primitive(_.startCelebrityRecognition(request))

        def startContentModeration(
          request: StartContentModerationRequest
        ): Kleisli[M, RekognitionClient, StartContentModerationResponse] =
          primitive(_.startContentModeration(request))

        def startFaceDetection(
          request: StartFaceDetectionRequest
        ): Kleisli[M, RekognitionClient, StartFaceDetectionResponse] =
          primitive(_.startFaceDetection(request))

        def startFaceSearch(
          request: StartFaceSearchRequest
        ): Kleisli[M, RekognitionClient, StartFaceSearchResponse] =
          primitive(_.startFaceSearch(request))

        def startLabelDetection(
          request: StartLabelDetectionRequest
        ): Kleisli[M, RekognitionClient, StartLabelDetectionResponse] =
          primitive(_.startLabelDetection(request))

        def startPersonTracking(
          request: StartPersonTrackingRequest
        ): Kleisli[M, RekognitionClient, StartPersonTrackingResponse] =
          primitive(_.startPersonTracking(request))

        def startProjectVersion(
          request: StartProjectVersionRequest
        ): Kleisli[M, RekognitionClient, StartProjectVersionResponse] =
          primitive(_.startProjectVersion(request))

        def startSegmentDetection(
          request: StartSegmentDetectionRequest
        ): Kleisli[M, RekognitionClient, StartSegmentDetectionResponse] =
          primitive(_.startSegmentDetection(request))

        def startStreamProcessor(
          request: StartStreamProcessorRequest
        ): Kleisli[M, RekognitionClient, StartStreamProcessorResponse] =
          primitive(_.startStreamProcessor(request))

        def startTextDetection(
          request: StartTextDetectionRequest
        ): Kleisli[M, RekognitionClient, StartTextDetectionResponse] =
          primitive(_.startTextDetection(request))

        def stopProjectVersion(
          request: StopProjectVersionRequest
        ): Kleisli[M, RekognitionClient, StopProjectVersionResponse] =
          primitive(_.stopProjectVersion(request))

        def stopStreamProcessor(
          request: StopStreamProcessorRequest
        ): Kleisli[M, RekognitionClient, StopStreamProcessorResponse] =
          primitive(_.stopStreamProcessor(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, RekognitionClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, RekognitionClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: RekognitionClient => A
        ): Kleisli[M, RekognitionClient, A]
      }
    }

    trait Visitor[F[_]] extends (RekognitionOp ~> F) {
      final def apply[A](op: RekognitionOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def compareFaces(
        request: CompareFacesRequest
      ): F[CompareFacesResponse]

      def createCollection(
        request: CreateCollectionRequest
      ): F[CreateCollectionResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def createProjectVersion(
        request: CreateProjectVersionRequest
      ): F[CreateProjectVersionResponse]

      def createStreamProcessor(
        request: CreateStreamProcessorRequest
      ): F[CreateStreamProcessorResponse]

      def deleteCollection(
        request: DeleteCollectionRequest
      ): F[DeleteCollectionResponse]

      def deleteFaces(
        request: DeleteFacesRequest
      ): F[DeleteFacesResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def deleteProjectVersion(
        request: DeleteProjectVersionRequest
      ): F[DeleteProjectVersionResponse]

      def deleteStreamProcessor(
        request: DeleteStreamProcessorRequest
      ): F[DeleteStreamProcessorResponse]

      def describeCollection(
        request: DescribeCollectionRequest
      ): F[DescribeCollectionResponse]

      def describeProjectVersions(
        request: DescribeProjectVersionsRequest
      ): F[DescribeProjectVersionsResponse]

      def describeProjects(
        request: DescribeProjectsRequest
      ): F[DescribeProjectsResponse]

      def describeStreamProcessor(
        request: DescribeStreamProcessorRequest
      ): F[DescribeStreamProcessorResponse]

      def detectCustomLabels(
        request: DetectCustomLabelsRequest
      ): F[DetectCustomLabelsResponse]

      def detectFaces(
        request: DetectFacesRequest
      ): F[DetectFacesResponse]

      def detectLabels(
        request: DetectLabelsRequest
      ): F[DetectLabelsResponse]

      def detectModerationLabels(
        request: DetectModerationLabelsRequest
      ): F[DetectModerationLabelsResponse]

      def detectProtectiveEquipment(
        request: DetectProtectiveEquipmentRequest
      ): F[DetectProtectiveEquipmentResponse]

      def detectText(
        request: DetectTextRequest
      ): F[DetectTextResponse]

      def getCelebrityInfo(
        request: GetCelebrityInfoRequest
      ): F[GetCelebrityInfoResponse]

      def getCelebrityRecognition(
        request: GetCelebrityRecognitionRequest
      ): F[GetCelebrityRecognitionResponse]

      def getContentModeration(
        request: GetContentModerationRequest
      ): F[GetContentModerationResponse]

      def getFaceDetection(
        request: GetFaceDetectionRequest
      ): F[GetFaceDetectionResponse]

      def getFaceSearch(
        request: GetFaceSearchRequest
      ): F[GetFaceSearchResponse]

      def getLabelDetection(
        request: GetLabelDetectionRequest
      ): F[GetLabelDetectionResponse]

      def getPersonTracking(
        request: GetPersonTrackingRequest
      ): F[GetPersonTrackingResponse]

      def getSegmentDetection(
        request: GetSegmentDetectionRequest
      ): F[GetSegmentDetectionResponse]

      def getTextDetection(
        request: GetTextDetectionRequest
      ): F[GetTextDetectionResponse]

      def indexFaces(
        request: IndexFacesRequest
      ): F[IndexFacesResponse]

      def listCollections(
        request: ListCollectionsRequest
      ): F[ListCollectionsResponse]

      def listFaces(
        request: ListFacesRequest
      ): F[ListFacesResponse]

      def listStreamProcessors(
        request: ListStreamProcessorsRequest
      ): F[ListStreamProcessorsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def recognizeCelebrities(
        request: RecognizeCelebritiesRequest
      ): F[RecognizeCelebritiesResponse]

      def searchFaces(
        request: SearchFacesRequest
      ): F[SearchFacesResponse]

      def searchFacesByImage(
        request: SearchFacesByImageRequest
      ): F[SearchFacesByImageResponse]

      def startCelebrityRecognition(
        request: StartCelebrityRecognitionRequest
      ): F[StartCelebrityRecognitionResponse]

      def startContentModeration(
        request: StartContentModerationRequest
      ): F[StartContentModerationResponse]

      def startFaceDetection(
        request: StartFaceDetectionRequest
      ): F[StartFaceDetectionResponse]

      def startFaceSearch(
        request: StartFaceSearchRequest
      ): F[StartFaceSearchResponse]

      def startLabelDetection(
        request: StartLabelDetectionRequest
      ): F[StartLabelDetectionResponse]

      def startPersonTracking(
        request: StartPersonTrackingRequest
      ): F[StartPersonTrackingResponse]

      def startProjectVersion(
        request: StartProjectVersionRequest
      ): F[StartProjectVersionResponse]

      def startSegmentDetection(
        request: StartSegmentDetectionRequest
      ): F[StartSegmentDetectionResponse]

      def startStreamProcessor(
        request: StartStreamProcessorRequest
      ): F[StartStreamProcessorResponse]

      def startTextDetection(
        request: StartTextDetectionRequest
      ): F[StartTextDetectionResponse]

      def stopProjectVersion(
        request: StopProjectVersionRequest
      ): F[StopProjectVersionResponse]

      def stopStreamProcessor(
        request: StopStreamProcessorRequest
      ): F[StopStreamProcessorResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends RekognitionOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CompareFacesOp(
      request: CompareFacesRequest
    ) extends RekognitionOp[CompareFacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CompareFacesResponse] =
        visitor.compareFaces(request)
    }

    final case class CreateCollectionOp(
      request: CreateCollectionRequest
    ) extends RekognitionOp[CreateCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCollectionResponse] =
        visitor.createCollection(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends RekognitionOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class CreateProjectVersionOp(
      request: CreateProjectVersionRequest
    ) extends RekognitionOp[CreateProjectVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectVersionResponse] =
        visitor.createProjectVersion(request)
    }

    final case class CreateStreamProcessorOp(
      request: CreateStreamProcessorRequest
    ) extends RekognitionOp[CreateStreamProcessorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStreamProcessorResponse] =
        visitor.createStreamProcessor(request)
    }

    final case class DeleteCollectionOp(
      request: DeleteCollectionRequest
    ) extends RekognitionOp[DeleteCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCollectionResponse] =
        visitor.deleteCollection(request)
    }

    final case class DeleteFacesOp(
      request: DeleteFacesRequest
    ) extends RekognitionOp[DeleteFacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFacesResponse] =
        visitor.deleteFaces(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends RekognitionOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DeleteProjectVersionOp(
      request: DeleteProjectVersionRequest
    ) extends RekognitionOp[DeleteProjectVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectVersionResponse] =
        visitor.deleteProjectVersion(request)
    }

    final case class DeleteStreamProcessorOp(
      request: DeleteStreamProcessorRequest
    ) extends RekognitionOp[DeleteStreamProcessorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStreamProcessorResponse] =
        visitor.deleteStreamProcessor(request)
    }

    final case class DescribeCollectionOp(
      request: DescribeCollectionRequest
    ) extends RekognitionOp[DescribeCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCollectionResponse] =
        visitor.describeCollection(request)
    }

    final case class DescribeProjectVersionsOp(
      request: DescribeProjectVersionsRequest
    ) extends RekognitionOp[DescribeProjectVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectVersionsResponse] =
        visitor.describeProjectVersions(request)
    }

    final case class DescribeProjectsOp(
      request: DescribeProjectsRequest
    ) extends RekognitionOp[DescribeProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectsResponse] =
        visitor.describeProjects(request)
    }

    final case class DescribeStreamProcessorOp(
      request: DescribeStreamProcessorRequest
    ) extends RekognitionOp[DescribeStreamProcessorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStreamProcessorResponse] =
        visitor.describeStreamProcessor(request)
    }

    final case class DetectCustomLabelsOp(
      request: DetectCustomLabelsRequest
    ) extends RekognitionOp[DetectCustomLabelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectCustomLabelsResponse] =
        visitor.detectCustomLabels(request)
    }

    final case class DetectFacesOp(
      request: DetectFacesRequest
    ) extends RekognitionOp[DetectFacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectFacesResponse] =
        visitor.detectFaces(request)
    }

    final case class DetectLabelsOp(
      request: DetectLabelsRequest
    ) extends RekognitionOp[DetectLabelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectLabelsResponse] =
        visitor.detectLabels(request)
    }

    final case class DetectModerationLabelsOp(
      request: DetectModerationLabelsRequest
    ) extends RekognitionOp[DetectModerationLabelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectModerationLabelsResponse] =
        visitor.detectModerationLabels(request)
    }

    final case class DetectProtectiveEquipmentOp(
      request: DetectProtectiveEquipmentRequest
    ) extends RekognitionOp[DetectProtectiveEquipmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectProtectiveEquipmentResponse] =
        visitor.detectProtectiveEquipment(request)
    }

    final case class DetectTextOp(
      request: DetectTextRequest
    ) extends RekognitionOp[DetectTextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectTextResponse] =
        visitor.detectText(request)
    }

    final case class GetCelebrityInfoOp(
      request: GetCelebrityInfoRequest
    ) extends RekognitionOp[GetCelebrityInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCelebrityInfoResponse] =
        visitor.getCelebrityInfo(request)
    }

    final case class GetCelebrityRecognitionOp(
      request: GetCelebrityRecognitionRequest
    ) extends RekognitionOp[GetCelebrityRecognitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCelebrityRecognitionResponse] =
        visitor.getCelebrityRecognition(request)
    }

    final case class GetContentModerationOp(
      request: GetContentModerationRequest
    ) extends RekognitionOp[GetContentModerationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContentModerationResponse] =
        visitor.getContentModeration(request)
    }

    final case class GetFaceDetectionOp(
      request: GetFaceDetectionRequest
    ) extends RekognitionOp[GetFaceDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFaceDetectionResponse] =
        visitor.getFaceDetection(request)
    }

    final case class GetFaceSearchOp(
      request: GetFaceSearchRequest
    ) extends RekognitionOp[GetFaceSearchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFaceSearchResponse] =
        visitor.getFaceSearch(request)
    }

    final case class GetLabelDetectionOp(
      request: GetLabelDetectionRequest
    ) extends RekognitionOp[GetLabelDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLabelDetectionResponse] =
        visitor.getLabelDetection(request)
    }

    final case class GetPersonTrackingOp(
      request: GetPersonTrackingRequest
    ) extends RekognitionOp[GetPersonTrackingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPersonTrackingResponse] =
        visitor.getPersonTracking(request)
    }

    final case class GetSegmentDetectionOp(
      request: GetSegmentDetectionRequest
    ) extends RekognitionOp[GetSegmentDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSegmentDetectionResponse] =
        visitor.getSegmentDetection(request)
    }

    final case class GetTextDetectionOp(
      request: GetTextDetectionRequest
    ) extends RekognitionOp[GetTextDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTextDetectionResponse] =
        visitor.getTextDetection(request)
    }

    final case class IndexFacesOp(
      request: IndexFacesRequest
    ) extends RekognitionOp[IndexFacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[IndexFacesResponse] =
        visitor.indexFaces(request)
    }

    final case class ListCollectionsOp(
      request: ListCollectionsRequest
    ) extends RekognitionOp[ListCollectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCollectionsResponse] =
        visitor.listCollections(request)
    }

    final case class ListFacesOp(
      request: ListFacesRequest
    ) extends RekognitionOp[ListFacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFacesResponse] =
        visitor.listFaces(request)
    }

    final case class ListStreamProcessorsOp(
      request: ListStreamProcessorsRequest
    ) extends RekognitionOp[ListStreamProcessorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStreamProcessorsResponse] =
        visitor.listStreamProcessors(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends RekognitionOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class RecognizeCelebritiesOp(
      request: RecognizeCelebritiesRequest
    ) extends RekognitionOp[RecognizeCelebritiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RecognizeCelebritiesResponse] =
        visitor.recognizeCelebrities(request)
    }

    final case class SearchFacesOp(
      request: SearchFacesRequest
    ) extends RekognitionOp[SearchFacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchFacesResponse] =
        visitor.searchFaces(request)
    }

    final case class SearchFacesByImageOp(
      request: SearchFacesByImageRequest
    ) extends RekognitionOp[SearchFacesByImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchFacesByImageResponse] =
        visitor.searchFacesByImage(request)
    }

    final case class StartCelebrityRecognitionOp(
      request: StartCelebrityRecognitionRequest
    ) extends RekognitionOp[StartCelebrityRecognitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCelebrityRecognitionResponse] =
        visitor.startCelebrityRecognition(request)
    }

    final case class StartContentModerationOp(
      request: StartContentModerationRequest
    ) extends RekognitionOp[StartContentModerationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartContentModerationResponse] =
        visitor.startContentModeration(request)
    }

    final case class StartFaceDetectionOp(
      request: StartFaceDetectionRequest
    ) extends RekognitionOp[StartFaceDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFaceDetectionResponse] =
        visitor.startFaceDetection(request)
    }

    final case class StartFaceSearchOp(
      request: StartFaceSearchRequest
    ) extends RekognitionOp[StartFaceSearchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFaceSearchResponse] =
        visitor.startFaceSearch(request)
    }

    final case class StartLabelDetectionOp(
      request: StartLabelDetectionRequest
    ) extends RekognitionOp[StartLabelDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartLabelDetectionResponse] =
        visitor.startLabelDetection(request)
    }

    final case class StartPersonTrackingOp(
      request: StartPersonTrackingRequest
    ) extends RekognitionOp[StartPersonTrackingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartPersonTrackingResponse] =
        visitor.startPersonTracking(request)
    }

    final case class StartProjectVersionOp(
      request: StartProjectVersionRequest
    ) extends RekognitionOp[StartProjectVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartProjectVersionResponse] =
        visitor.startProjectVersion(request)
    }

    final case class StartSegmentDetectionOp(
      request: StartSegmentDetectionRequest
    ) extends RekognitionOp[StartSegmentDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSegmentDetectionResponse] =
        visitor.startSegmentDetection(request)
    }

    final case class StartStreamProcessorOp(
      request: StartStreamProcessorRequest
    ) extends RekognitionOp[StartStreamProcessorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartStreamProcessorResponse] =
        visitor.startStreamProcessor(request)
    }

    final case class StartTextDetectionOp(
      request: StartTextDetectionRequest
    ) extends RekognitionOp[StartTextDetectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTextDetectionResponse] =
        visitor.startTextDetection(request)
    }

    final case class StopProjectVersionOp(
      request: StopProjectVersionRequest
    ) extends RekognitionOp[StopProjectVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopProjectVersionResponse] =
        visitor.stopProjectVersion(request)
    }

    final case class StopStreamProcessorOp(
      request: StopStreamProcessorRequest
    ) extends RekognitionOp[StopStreamProcessorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopStreamProcessorResponse] =
        visitor.stopStreamProcessor(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends RekognitionOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends RekognitionOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import RekognitionOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[RekognitionOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def compareFaces(
    request: CompareFacesRequest
  ): RekognitionIO[CompareFacesResponse] =
    FF.liftF(CompareFacesOp(request))

  def createCollection(
    request: CreateCollectionRequest
  ): RekognitionIO[CreateCollectionResponse] =
    FF.liftF(CreateCollectionOp(request))

  def createProject(
    request: CreateProjectRequest
  ): RekognitionIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def createProjectVersion(
    request: CreateProjectVersionRequest
  ): RekognitionIO[CreateProjectVersionResponse] =
    FF.liftF(CreateProjectVersionOp(request))

  def createStreamProcessor(
    request: CreateStreamProcessorRequest
  ): RekognitionIO[CreateStreamProcessorResponse] =
    FF.liftF(CreateStreamProcessorOp(request))

  def deleteCollection(
    request: DeleteCollectionRequest
  ): RekognitionIO[DeleteCollectionResponse] =
    FF.liftF(DeleteCollectionOp(request))

  def deleteFaces(
    request: DeleteFacesRequest
  ): RekognitionIO[DeleteFacesResponse] =
    FF.liftF(DeleteFacesOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): RekognitionIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def deleteProjectVersion(
    request: DeleteProjectVersionRequest
  ): RekognitionIO[DeleteProjectVersionResponse] =
    FF.liftF(DeleteProjectVersionOp(request))

  def deleteStreamProcessor(
    request: DeleteStreamProcessorRequest
  ): RekognitionIO[DeleteStreamProcessorResponse] =
    FF.liftF(DeleteStreamProcessorOp(request))

  def describeCollection(
    request: DescribeCollectionRequest
  ): RekognitionIO[DescribeCollectionResponse] =
    FF.liftF(DescribeCollectionOp(request))

  def describeProjectVersions(
    request: DescribeProjectVersionsRequest
  ): RekognitionIO[DescribeProjectVersionsResponse] =
    FF.liftF(DescribeProjectVersionsOp(request))

  def describeProjects(
    request: DescribeProjectsRequest
  ): RekognitionIO[DescribeProjectsResponse] =
    FF.liftF(DescribeProjectsOp(request))

  def describeStreamProcessor(
    request: DescribeStreamProcessorRequest
  ): RekognitionIO[DescribeStreamProcessorResponse] =
    FF.liftF(DescribeStreamProcessorOp(request))

  def detectCustomLabels(
    request: DetectCustomLabelsRequest
  ): RekognitionIO[DetectCustomLabelsResponse] =
    FF.liftF(DetectCustomLabelsOp(request))

  def detectFaces(
    request: DetectFacesRequest
  ): RekognitionIO[DetectFacesResponse] =
    FF.liftF(DetectFacesOp(request))

  def detectLabels(
    request: DetectLabelsRequest
  ): RekognitionIO[DetectLabelsResponse] =
    FF.liftF(DetectLabelsOp(request))

  def detectModerationLabels(
    request: DetectModerationLabelsRequest
  ): RekognitionIO[DetectModerationLabelsResponse] =
    FF.liftF(DetectModerationLabelsOp(request))

  def detectProtectiveEquipment(
    request: DetectProtectiveEquipmentRequest
  ): RekognitionIO[DetectProtectiveEquipmentResponse] =
    FF.liftF(DetectProtectiveEquipmentOp(request))

  def detectText(
    request: DetectTextRequest
  ): RekognitionIO[DetectTextResponse] =
    FF.liftF(DetectTextOp(request))

  def getCelebrityInfo(
    request: GetCelebrityInfoRequest
  ): RekognitionIO[GetCelebrityInfoResponse] =
    FF.liftF(GetCelebrityInfoOp(request))

  def getCelebrityRecognition(
    request: GetCelebrityRecognitionRequest
  ): RekognitionIO[GetCelebrityRecognitionResponse] =
    FF.liftF(GetCelebrityRecognitionOp(request))

  def getContentModeration(
    request: GetContentModerationRequest
  ): RekognitionIO[GetContentModerationResponse] =
    FF.liftF(GetContentModerationOp(request))

  def getFaceDetection(
    request: GetFaceDetectionRequest
  ): RekognitionIO[GetFaceDetectionResponse] =
    FF.liftF(GetFaceDetectionOp(request))

  def getFaceSearch(
    request: GetFaceSearchRequest
  ): RekognitionIO[GetFaceSearchResponse] =
    FF.liftF(GetFaceSearchOp(request))

  def getLabelDetection(
    request: GetLabelDetectionRequest
  ): RekognitionIO[GetLabelDetectionResponse] =
    FF.liftF(GetLabelDetectionOp(request))

  def getPersonTracking(
    request: GetPersonTrackingRequest
  ): RekognitionIO[GetPersonTrackingResponse] =
    FF.liftF(GetPersonTrackingOp(request))

  def getSegmentDetection(
    request: GetSegmentDetectionRequest
  ): RekognitionIO[GetSegmentDetectionResponse] =
    FF.liftF(GetSegmentDetectionOp(request))

  def getTextDetection(
    request: GetTextDetectionRequest
  ): RekognitionIO[GetTextDetectionResponse] =
    FF.liftF(GetTextDetectionOp(request))

  def indexFaces(
    request: IndexFacesRequest
  ): RekognitionIO[IndexFacesResponse] =
    FF.liftF(IndexFacesOp(request))

  def listCollections(
    request: ListCollectionsRequest
  ): RekognitionIO[ListCollectionsResponse] =
    FF.liftF(ListCollectionsOp(request))

  def listFaces(
    request: ListFacesRequest
  ): RekognitionIO[ListFacesResponse] =
    FF.liftF(ListFacesOp(request))

  def listStreamProcessors(
    request: ListStreamProcessorsRequest
  ): RekognitionIO[ListStreamProcessorsResponse] =
    FF.liftF(ListStreamProcessorsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): RekognitionIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def recognizeCelebrities(
    request: RecognizeCelebritiesRequest
  ): RekognitionIO[RecognizeCelebritiesResponse] =
    FF.liftF(RecognizeCelebritiesOp(request))

  def searchFaces(
    request: SearchFacesRequest
  ): RekognitionIO[SearchFacesResponse] =
    FF.liftF(SearchFacesOp(request))

  def searchFacesByImage(
    request: SearchFacesByImageRequest
  ): RekognitionIO[SearchFacesByImageResponse] =
    FF.liftF(SearchFacesByImageOp(request))

  def startCelebrityRecognition(
    request: StartCelebrityRecognitionRequest
  ): RekognitionIO[StartCelebrityRecognitionResponse] =
    FF.liftF(StartCelebrityRecognitionOp(request))

  def startContentModeration(
    request: StartContentModerationRequest
  ): RekognitionIO[StartContentModerationResponse] =
    FF.liftF(StartContentModerationOp(request))

  def startFaceDetection(
    request: StartFaceDetectionRequest
  ): RekognitionIO[StartFaceDetectionResponse] =
    FF.liftF(StartFaceDetectionOp(request))

  def startFaceSearch(
    request: StartFaceSearchRequest
  ): RekognitionIO[StartFaceSearchResponse] =
    FF.liftF(StartFaceSearchOp(request))

  def startLabelDetection(
    request: StartLabelDetectionRequest
  ): RekognitionIO[StartLabelDetectionResponse] =
    FF.liftF(StartLabelDetectionOp(request))

  def startPersonTracking(
    request: StartPersonTrackingRequest
  ): RekognitionIO[StartPersonTrackingResponse] =
    FF.liftF(StartPersonTrackingOp(request))

  def startProjectVersion(
    request: StartProjectVersionRequest
  ): RekognitionIO[StartProjectVersionResponse] =
    FF.liftF(StartProjectVersionOp(request))

  def startSegmentDetection(
    request: StartSegmentDetectionRequest
  ): RekognitionIO[StartSegmentDetectionResponse] =
    FF.liftF(StartSegmentDetectionOp(request))

  def startStreamProcessor(
    request: StartStreamProcessorRequest
  ): RekognitionIO[StartStreamProcessorResponse] =
    FF.liftF(StartStreamProcessorOp(request))

  def startTextDetection(
    request: StartTextDetectionRequest
  ): RekognitionIO[StartTextDetectionResponse] =
    FF.liftF(StartTextDetectionOp(request))

  def stopProjectVersion(
    request: StopProjectVersionRequest
  ): RekognitionIO[StopProjectVersionResponse] =
    FF.liftF(StopProjectVersionOp(request))

  def stopStreamProcessor(
    request: StopStreamProcessorRequest
  ): RekognitionIO[StopStreamProcessorResponse] =
    FF.liftF(StopStreamProcessorOp(request))

  def tagResource(
    request: TagResourceRequest
  ): RekognitionIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): RekognitionIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
