package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.location.LocationClient
import software.amazon.awssdk.services.location.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object location { module =>

  // Free monad over LocationOp
  type LocationIO[A] = FF[LocationOp, A]

  sealed trait LocationOp[A] {
    def visit[F[_]](visitor: LocationOp.Visitor[F]): F[A]
  }

  object LocationOp {
    // Given a LocationClient we can embed a LocationIO program in any algebra that understands embedding.
    implicit val LocationOpEmbeddable: Embeddable[LocationOp, LocationClient] = new Embeddable[LocationOp, LocationClient] {
      def embed[A](client: LocationClient, io: LocationIO[A]): Embedded[A] = Embedded.Location(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends LocationOp.Visitor[Kleisli[M, LocationClient, *]] {
        def associateTrackerConsumer(
          request: AssociateTrackerConsumerRequest
        ): Kleisli[M, LocationClient, AssociateTrackerConsumerResponse] =
          primitive(_.associateTrackerConsumer(request))

        def batchDeleteDevicePositionHistory(
          request: BatchDeleteDevicePositionHistoryRequest
        ): Kleisli[M, LocationClient, BatchDeleteDevicePositionHistoryResponse] =
          primitive(_.batchDeleteDevicePositionHistory(request))

        def batchDeleteGeofence(
          request: BatchDeleteGeofenceRequest
        ): Kleisli[M, LocationClient, BatchDeleteGeofenceResponse] =
          primitive(_.batchDeleteGeofence(request))

        def batchEvaluateGeofences(
          request: BatchEvaluateGeofencesRequest
        ): Kleisli[M, LocationClient, BatchEvaluateGeofencesResponse] =
          primitive(_.batchEvaluateGeofences(request))

        def batchGetDevicePosition(
          request: BatchGetDevicePositionRequest
        ): Kleisli[M, LocationClient, BatchGetDevicePositionResponse] =
          primitive(_.batchGetDevicePosition(request))

        def batchPutGeofence(
          request: BatchPutGeofenceRequest
        ): Kleisli[M, LocationClient, BatchPutGeofenceResponse] =
          primitive(_.batchPutGeofence(request))

        def batchUpdateDevicePosition(
          request: BatchUpdateDevicePositionRequest
        ): Kleisli[M, LocationClient, BatchUpdateDevicePositionResponse] =
          primitive(_.batchUpdateDevicePosition(request))

        def calculateRoute(
          request: CalculateRouteRequest
        ): Kleisli[M, LocationClient, CalculateRouteResponse] =
          primitive(_.calculateRoute(request))

        def createGeofenceCollection(
          request: CreateGeofenceCollectionRequest
        ): Kleisli[M, LocationClient, CreateGeofenceCollectionResponse] =
          primitive(_.createGeofenceCollection(request))

        def createMap(
          request: CreateMapRequest
        ): Kleisli[M, LocationClient, CreateMapResponse] =
          primitive(_.createMap(request))

        def createPlaceIndex(
          request: CreatePlaceIndexRequest
        ): Kleisli[M, LocationClient, CreatePlaceIndexResponse] =
          primitive(_.createPlaceIndex(request))

        def createRouteCalculator(
          request: CreateRouteCalculatorRequest
        ): Kleisli[M, LocationClient, CreateRouteCalculatorResponse] =
          primitive(_.createRouteCalculator(request))

        def createTracker(
          request: CreateTrackerRequest
        ): Kleisli[M, LocationClient, CreateTrackerResponse] =
          primitive(_.createTracker(request))

        def deleteGeofenceCollection(
          request: DeleteGeofenceCollectionRequest
        ): Kleisli[M, LocationClient, DeleteGeofenceCollectionResponse] =
          primitive(_.deleteGeofenceCollection(request))

        def deleteMap(
          request: DeleteMapRequest
        ): Kleisli[M, LocationClient, DeleteMapResponse] =
          primitive(_.deleteMap(request))

        def deletePlaceIndex(
          request: DeletePlaceIndexRequest
        ): Kleisli[M, LocationClient, DeletePlaceIndexResponse] =
          primitive(_.deletePlaceIndex(request))

        def deleteRouteCalculator(
          request: DeleteRouteCalculatorRequest
        ): Kleisli[M, LocationClient, DeleteRouteCalculatorResponse] =
          primitive(_.deleteRouteCalculator(request))

        def deleteTracker(
          request: DeleteTrackerRequest
        ): Kleisli[M, LocationClient, DeleteTrackerResponse] =
          primitive(_.deleteTracker(request))

        def describeGeofenceCollection(
          request: DescribeGeofenceCollectionRequest
        ): Kleisli[M, LocationClient, DescribeGeofenceCollectionResponse] =
          primitive(_.describeGeofenceCollection(request))

        def describeMap(
          request: DescribeMapRequest
        ): Kleisli[M, LocationClient, DescribeMapResponse] =
          primitive(_.describeMap(request))

        def describePlaceIndex(
          request: DescribePlaceIndexRequest
        ): Kleisli[M, LocationClient, DescribePlaceIndexResponse] =
          primitive(_.describePlaceIndex(request))

        def describeRouteCalculator(
          request: DescribeRouteCalculatorRequest
        ): Kleisli[M, LocationClient, DescribeRouteCalculatorResponse] =
          primitive(_.describeRouteCalculator(request))

        def describeTracker(
          request: DescribeTrackerRequest
        ): Kleisli[M, LocationClient, DescribeTrackerResponse] =
          primitive(_.describeTracker(request))

        def disassociateTrackerConsumer(
          request: DisassociateTrackerConsumerRequest
        ): Kleisli[M, LocationClient, DisassociateTrackerConsumerResponse] =
          primitive(_.disassociateTrackerConsumer(request))

        def getDevicePosition(
          request: GetDevicePositionRequest
        ): Kleisli[M, LocationClient, GetDevicePositionResponse] =
          primitive(_.getDevicePosition(request))

        def getDevicePositionHistory(
          request: GetDevicePositionHistoryRequest
        ): Kleisli[M, LocationClient, GetDevicePositionHistoryResponse] =
          primitive(_.getDevicePositionHistory(request))

        def getGeofence(
          request: GetGeofenceRequest
        ): Kleisli[M, LocationClient, GetGeofenceResponse] =
          primitive(_.getGeofence(request))

        def getMapGlyphs(
          request: GetMapGlyphsRequest
        ): Kleisli[M, LocationClient, GetMapGlyphsResponse] =
          primitive(_.getMapGlyphs(request))

        def getMapSprites(
          request: GetMapSpritesRequest
        ): Kleisli[M, LocationClient, GetMapSpritesResponse] =
          primitive(_.getMapSprites(request))

        def getMapStyleDescriptor(
          request: GetMapStyleDescriptorRequest
        ): Kleisli[M, LocationClient, GetMapStyleDescriptorResponse] =
          primitive(_.getMapStyleDescriptor(request))

        def getMapTile(
          request: GetMapTileRequest
        ): Kleisli[M, LocationClient, GetMapTileResponse] =
          primitive(_.getMapTile(request))

        def listDevicePositions(
          request: ListDevicePositionsRequest
        ): Kleisli[M, LocationClient, ListDevicePositionsResponse] =
          primitive(_.listDevicePositions(request))

        def listGeofenceCollections(
          request: ListGeofenceCollectionsRequest
        ): Kleisli[M, LocationClient, ListGeofenceCollectionsResponse] =
          primitive(_.listGeofenceCollections(request))

        def listGeofences(
          request: ListGeofencesRequest
        ): Kleisli[M, LocationClient, ListGeofencesResponse] =
          primitive(_.listGeofences(request))

        def listMaps(
          request: ListMapsRequest
        ): Kleisli[M, LocationClient, ListMapsResponse] =
          primitive(_.listMaps(request))

        def listPlaceIndexes(
          request: ListPlaceIndexesRequest
        ): Kleisli[M, LocationClient, ListPlaceIndexesResponse] =
          primitive(_.listPlaceIndexes(request))

        def listRouteCalculators(
          request: ListRouteCalculatorsRequest
        ): Kleisli[M, LocationClient, ListRouteCalculatorsResponse] =
          primitive(_.listRouteCalculators(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, LocationClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTrackerConsumers(
          request: ListTrackerConsumersRequest
        ): Kleisli[M, LocationClient, ListTrackerConsumersResponse] =
          primitive(_.listTrackerConsumers(request))

        def listTrackers(
          request: ListTrackersRequest
        ): Kleisli[M, LocationClient, ListTrackersResponse] =
          primitive(_.listTrackers(request))

        def putGeofence(
          request: PutGeofenceRequest
        ): Kleisli[M, LocationClient, PutGeofenceResponse] =
          primitive(_.putGeofence(request))

        def searchPlaceIndexForPosition(
          request: SearchPlaceIndexForPositionRequest
        ): Kleisli[M, LocationClient, SearchPlaceIndexForPositionResponse] =
          primitive(_.searchPlaceIndexForPosition(request))

        def searchPlaceIndexForText(
          request: SearchPlaceIndexForTextRequest
        ): Kleisli[M, LocationClient, SearchPlaceIndexForTextResponse] =
          primitive(_.searchPlaceIndexForText(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, LocationClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, LocationClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def primitive[A](
          f: LocationClient => A
        ): Kleisli[M, LocationClient, A]
      }
    }

    trait Visitor[F[_]] extends (LocationOp ~> F) {
      final def apply[A](op: LocationOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateTrackerConsumer(
        request: AssociateTrackerConsumerRequest
      ): F[AssociateTrackerConsumerResponse]

      def batchDeleteDevicePositionHistory(
        request: BatchDeleteDevicePositionHistoryRequest
      ): F[BatchDeleteDevicePositionHistoryResponse]

      def batchDeleteGeofence(
        request: BatchDeleteGeofenceRequest
      ): F[BatchDeleteGeofenceResponse]

      def batchEvaluateGeofences(
        request: BatchEvaluateGeofencesRequest
      ): F[BatchEvaluateGeofencesResponse]

      def batchGetDevicePosition(
        request: BatchGetDevicePositionRequest
      ): F[BatchGetDevicePositionResponse]

      def batchPutGeofence(
        request: BatchPutGeofenceRequest
      ): F[BatchPutGeofenceResponse]

      def batchUpdateDevicePosition(
        request: BatchUpdateDevicePositionRequest
      ): F[BatchUpdateDevicePositionResponse]

      def calculateRoute(
        request: CalculateRouteRequest
      ): F[CalculateRouteResponse]

      def createGeofenceCollection(
        request: CreateGeofenceCollectionRequest
      ): F[CreateGeofenceCollectionResponse]

      def createMap(
        request: CreateMapRequest
      ): F[CreateMapResponse]

      def createPlaceIndex(
        request: CreatePlaceIndexRequest
      ): F[CreatePlaceIndexResponse]

      def createRouteCalculator(
        request: CreateRouteCalculatorRequest
      ): F[CreateRouteCalculatorResponse]

      def createTracker(
        request: CreateTrackerRequest
      ): F[CreateTrackerResponse]

      def deleteGeofenceCollection(
        request: DeleteGeofenceCollectionRequest
      ): F[DeleteGeofenceCollectionResponse]

      def deleteMap(
        request: DeleteMapRequest
      ): F[DeleteMapResponse]

      def deletePlaceIndex(
        request: DeletePlaceIndexRequest
      ): F[DeletePlaceIndexResponse]

      def deleteRouteCalculator(
        request: DeleteRouteCalculatorRequest
      ): F[DeleteRouteCalculatorResponse]

      def deleteTracker(
        request: DeleteTrackerRequest
      ): F[DeleteTrackerResponse]

      def describeGeofenceCollection(
        request: DescribeGeofenceCollectionRequest
      ): F[DescribeGeofenceCollectionResponse]

      def describeMap(
        request: DescribeMapRequest
      ): F[DescribeMapResponse]

      def describePlaceIndex(
        request: DescribePlaceIndexRequest
      ): F[DescribePlaceIndexResponse]

      def describeRouteCalculator(
        request: DescribeRouteCalculatorRequest
      ): F[DescribeRouteCalculatorResponse]

      def describeTracker(
        request: DescribeTrackerRequest
      ): F[DescribeTrackerResponse]

      def disassociateTrackerConsumer(
        request: DisassociateTrackerConsumerRequest
      ): F[DisassociateTrackerConsumerResponse]

      def getDevicePosition(
        request: GetDevicePositionRequest
      ): F[GetDevicePositionResponse]

      def getDevicePositionHistory(
        request: GetDevicePositionHistoryRequest
      ): F[GetDevicePositionHistoryResponse]

      def getGeofence(
        request: GetGeofenceRequest
      ): F[GetGeofenceResponse]

      def getMapGlyphs(
        request: GetMapGlyphsRequest
      ): F[GetMapGlyphsResponse]

      def getMapSprites(
        request: GetMapSpritesRequest
      ): F[GetMapSpritesResponse]

      def getMapStyleDescriptor(
        request: GetMapStyleDescriptorRequest
      ): F[GetMapStyleDescriptorResponse]

      def getMapTile(
        request: GetMapTileRequest
      ): F[GetMapTileResponse]

      def listDevicePositions(
        request: ListDevicePositionsRequest
      ): F[ListDevicePositionsResponse]

      def listGeofenceCollections(
        request: ListGeofenceCollectionsRequest
      ): F[ListGeofenceCollectionsResponse]

      def listGeofences(
        request: ListGeofencesRequest
      ): F[ListGeofencesResponse]

      def listMaps(
        request: ListMapsRequest
      ): F[ListMapsResponse]

      def listPlaceIndexes(
        request: ListPlaceIndexesRequest
      ): F[ListPlaceIndexesResponse]

      def listRouteCalculators(
        request: ListRouteCalculatorsRequest
      ): F[ListRouteCalculatorsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTrackerConsumers(
        request: ListTrackerConsumersRequest
      ): F[ListTrackerConsumersResponse]

      def listTrackers(
        request: ListTrackersRequest
      ): F[ListTrackersResponse]

      def putGeofence(
        request: PutGeofenceRequest
      ): F[PutGeofenceResponse]

      def searchPlaceIndexForPosition(
        request: SearchPlaceIndexForPositionRequest
      ): F[SearchPlaceIndexForPositionResponse]

      def searchPlaceIndexForText(
        request: SearchPlaceIndexForTextRequest
      ): F[SearchPlaceIndexForTextResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends LocationOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateTrackerConsumerOp(
      request: AssociateTrackerConsumerRequest
    ) extends LocationOp[AssociateTrackerConsumerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTrackerConsumerResponse] =
        visitor.associateTrackerConsumer(request)
    }

    final case class BatchDeleteDevicePositionHistoryOp(
      request: BatchDeleteDevicePositionHistoryRequest
    ) extends LocationOp[BatchDeleteDevicePositionHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteDevicePositionHistoryResponse] =
        visitor.batchDeleteDevicePositionHistory(request)
    }

    final case class BatchDeleteGeofenceOp(
      request: BatchDeleteGeofenceRequest
    ) extends LocationOp[BatchDeleteGeofenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteGeofenceResponse] =
        visitor.batchDeleteGeofence(request)
    }

    final case class BatchEvaluateGeofencesOp(
      request: BatchEvaluateGeofencesRequest
    ) extends LocationOp[BatchEvaluateGeofencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchEvaluateGeofencesResponse] =
        visitor.batchEvaluateGeofences(request)
    }

    final case class BatchGetDevicePositionOp(
      request: BatchGetDevicePositionRequest
    ) extends LocationOp[BatchGetDevicePositionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetDevicePositionResponse] =
        visitor.batchGetDevicePosition(request)
    }

    final case class BatchPutGeofenceOp(
      request: BatchPutGeofenceRequest
    ) extends LocationOp[BatchPutGeofenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchPutGeofenceResponse] =
        visitor.batchPutGeofence(request)
    }

    final case class BatchUpdateDevicePositionOp(
      request: BatchUpdateDevicePositionRequest
    ) extends LocationOp[BatchUpdateDevicePositionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdateDevicePositionResponse] =
        visitor.batchUpdateDevicePosition(request)
    }

    final case class CalculateRouteOp(
      request: CalculateRouteRequest
    ) extends LocationOp[CalculateRouteResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CalculateRouteResponse] =
        visitor.calculateRoute(request)
    }

    final case class CreateGeofenceCollectionOp(
      request: CreateGeofenceCollectionRequest
    ) extends LocationOp[CreateGeofenceCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGeofenceCollectionResponse] =
        visitor.createGeofenceCollection(request)
    }

    final case class CreateMapOp(
      request: CreateMapRequest
    ) extends LocationOp[CreateMapResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMapResponse] =
        visitor.createMap(request)
    }

    final case class CreatePlaceIndexOp(
      request: CreatePlaceIndexRequest
    ) extends LocationOp[CreatePlaceIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlaceIndexResponse] =
        visitor.createPlaceIndex(request)
    }

    final case class CreateRouteCalculatorOp(
      request: CreateRouteCalculatorRequest
    ) extends LocationOp[CreateRouteCalculatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRouteCalculatorResponse] =
        visitor.createRouteCalculator(request)
    }

    final case class CreateTrackerOp(
      request: CreateTrackerRequest
    ) extends LocationOp[CreateTrackerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrackerResponse] =
        visitor.createTracker(request)
    }

    final case class DeleteGeofenceCollectionOp(
      request: DeleteGeofenceCollectionRequest
    ) extends LocationOp[DeleteGeofenceCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGeofenceCollectionResponse] =
        visitor.deleteGeofenceCollection(request)
    }

    final case class DeleteMapOp(
      request: DeleteMapRequest
    ) extends LocationOp[DeleteMapResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMapResponse] =
        visitor.deleteMap(request)
    }

    final case class DeletePlaceIndexOp(
      request: DeletePlaceIndexRequest
    ) extends LocationOp[DeletePlaceIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePlaceIndexResponse] =
        visitor.deletePlaceIndex(request)
    }

    final case class DeleteRouteCalculatorOp(
      request: DeleteRouteCalculatorRequest
    ) extends LocationOp[DeleteRouteCalculatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRouteCalculatorResponse] =
        visitor.deleteRouteCalculator(request)
    }

    final case class DeleteTrackerOp(
      request: DeleteTrackerRequest
    ) extends LocationOp[DeleteTrackerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrackerResponse] =
        visitor.deleteTracker(request)
    }

    final case class DescribeGeofenceCollectionOp(
      request: DescribeGeofenceCollectionRequest
    ) extends LocationOp[DescribeGeofenceCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGeofenceCollectionResponse] =
        visitor.describeGeofenceCollection(request)
    }

    final case class DescribeMapOp(
      request: DescribeMapRequest
    ) extends LocationOp[DescribeMapResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMapResponse] =
        visitor.describeMap(request)
    }

    final case class DescribePlaceIndexOp(
      request: DescribePlaceIndexRequest
    ) extends LocationOp[DescribePlaceIndexResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePlaceIndexResponse] =
        visitor.describePlaceIndex(request)
    }

    final case class DescribeRouteCalculatorOp(
      request: DescribeRouteCalculatorRequest
    ) extends LocationOp[DescribeRouteCalculatorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRouteCalculatorResponse] =
        visitor.describeRouteCalculator(request)
    }

    final case class DescribeTrackerOp(
      request: DescribeTrackerRequest
    ) extends LocationOp[DescribeTrackerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrackerResponse] =
        visitor.describeTracker(request)
    }

    final case class DisassociateTrackerConsumerOp(
      request: DisassociateTrackerConsumerRequest
    ) extends LocationOp[DisassociateTrackerConsumerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTrackerConsumerResponse] =
        visitor.disassociateTrackerConsumer(request)
    }

    final case class GetDevicePositionOp(
      request: GetDevicePositionRequest
    ) extends LocationOp[GetDevicePositionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevicePositionResponse] =
        visitor.getDevicePosition(request)
    }

    final case class GetDevicePositionHistoryOp(
      request: GetDevicePositionHistoryRequest
    ) extends LocationOp[GetDevicePositionHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDevicePositionHistoryResponse] =
        visitor.getDevicePositionHistory(request)
    }

    final case class GetGeofenceOp(
      request: GetGeofenceRequest
    ) extends LocationOp[GetGeofenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGeofenceResponse] =
        visitor.getGeofence(request)
    }

    final case class GetMapGlyphsOp(
      request: GetMapGlyphsRequest
    ) extends LocationOp[GetMapGlyphsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMapGlyphsResponse] =
        visitor.getMapGlyphs(request)
    }

    final case class GetMapSpritesOp(
      request: GetMapSpritesRequest
    ) extends LocationOp[GetMapSpritesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMapSpritesResponse] =
        visitor.getMapSprites(request)
    }

    final case class GetMapStyleDescriptorOp(
      request: GetMapStyleDescriptorRequest
    ) extends LocationOp[GetMapStyleDescriptorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMapStyleDescriptorResponse] =
        visitor.getMapStyleDescriptor(request)
    }

    final case class GetMapTileOp(
      request: GetMapTileRequest
    ) extends LocationOp[GetMapTileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMapTileResponse] =
        visitor.getMapTile(request)
    }

    final case class ListDevicePositionsOp(
      request: ListDevicePositionsRequest
    ) extends LocationOp[ListDevicePositionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDevicePositionsResponse] =
        visitor.listDevicePositions(request)
    }

    final case class ListGeofenceCollectionsOp(
      request: ListGeofenceCollectionsRequest
    ) extends LocationOp[ListGeofenceCollectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGeofenceCollectionsResponse] =
        visitor.listGeofenceCollections(request)
    }

    final case class ListGeofencesOp(
      request: ListGeofencesRequest
    ) extends LocationOp[ListGeofencesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGeofencesResponse] =
        visitor.listGeofences(request)
    }

    final case class ListMapsOp(
      request: ListMapsRequest
    ) extends LocationOp[ListMapsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMapsResponse] =
        visitor.listMaps(request)
    }

    final case class ListPlaceIndexesOp(
      request: ListPlaceIndexesRequest
    ) extends LocationOp[ListPlaceIndexesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPlaceIndexesResponse] =
        visitor.listPlaceIndexes(request)
    }

    final case class ListRouteCalculatorsOp(
      request: ListRouteCalculatorsRequest
    ) extends LocationOp[ListRouteCalculatorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRouteCalculatorsResponse] =
        visitor.listRouteCalculators(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends LocationOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTrackerConsumersOp(
      request: ListTrackerConsumersRequest
    ) extends LocationOp[ListTrackerConsumersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrackerConsumersResponse] =
        visitor.listTrackerConsumers(request)
    }

    final case class ListTrackersOp(
      request: ListTrackersRequest
    ) extends LocationOp[ListTrackersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrackersResponse] =
        visitor.listTrackers(request)
    }

    final case class PutGeofenceOp(
      request: PutGeofenceRequest
    ) extends LocationOp[PutGeofenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutGeofenceResponse] =
        visitor.putGeofence(request)
    }

    final case class SearchPlaceIndexForPositionOp(
      request: SearchPlaceIndexForPositionRequest
    ) extends LocationOp[SearchPlaceIndexForPositionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchPlaceIndexForPositionResponse] =
        visitor.searchPlaceIndexForPosition(request)
    }

    final case class SearchPlaceIndexForTextOp(
      request: SearchPlaceIndexForTextRequest
    ) extends LocationOp[SearchPlaceIndexForTextResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchPlaceIndexForTextResponse] =
        visitor.searchPlaceIndexForText(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends LocationOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends LocationOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }
  }

  import LocationOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[LocationOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateTrackerConsumer(
    request: AssociateTrackerConsumerRequest
  ): LocationIO[AssociateTrackerConsumerResponse] =
    FF.liftF(AssociateTrackerConsumerOp(request))

  def batchDeleteDevicePositionHistory(
    request: BatchDeleteDevicePositionHistoryRequest
  ): LocationIO[BatchDeleteDevicePositionHistoryResponse] =
    FF.liftF(BatchDeleteDevicePositionHistoryOp(request))

  def batchDeleteGeofence(
    request: BatchDeleteGeofenceRequest
  ): LocationIO[BatchDeleteGeofenceResponse] =
    FF.liftF(BatchDeleteGeofenceOp(request))

  def batchEvaluateGeofences(
    request: BatchEvaluateGeofencesRequest
  ): LocationIO[BatchEvaluateGeofencesResponse] =
    FF.liftF(BatchEvaluateGeofencesOp(request))

  def batchGetDevicePosition(
    request: BatchGetDevicePositionRequest
  ): LocationIO[BatchGetDevicePositionResponse] =
    FF.liftF(BatchGetDevicePositionOp(request))

  def batchPutGeofence(
    request: BatchPutGeofenceRequest
  ): LocationIO[BatchPutGeofenceResponse] =
    FF.liftF(BatchPutGeofenceOp(request))

  def batchUpdateDevicePosition(
    request: BatchUpdateDevicePositionRequest
  ): LocationIO[BatchUpdateDevicePositionResponse] =
    FF.liftF(BatchUpdateDevicePositionOp(request))

  def calculateRoute(
    request: CalculateRouteRequest
  ): LocationIO[CalculateRouteResponse] =
    FF.liftF(CalculateRouteOp(request))

  def createGeofenceCollection(
    request: CreateGeofenceCollectionRequest
  ): LocationIO[CreateGeofenceCollectionResponse] =
    FF.liftF(CreateGeofenceCollectionOp(request))

  def createMap(
    request: CreateMapRequest
  ): LocationIO[CreateMapResponse] =
    FF.liftF(CreateMapOp(request))

  def createPlaceIndex(
    request: CreatePlaceIndexRequest
  ): LocationIO[CreatePlaceIndexResponse] =
    FF.liftF(CreatePlaceIndexOp(request))

  def createRouteCalculator(
    request: CreateRouteCalculatorRequest
  ): LocationIO[CreateRouteCalculatorResponse] =
    FF.liftF(CreateRouteCalculatorOp(request))

  def createTracker(
    request: CreateTrackerRequest
  ): LocationIO[CreateTrackerResponse] =
    FF.liftF(CreateTrackerOp(request))

  def deleteGeofenceCollection(
    request: DeleteGeofenceCollectionRequest
  ): LocationIO[DeleteGeofenceCollectionResponse] =
    FF.liftF(DeleteGeofenceCollectionOp(request))

  def deleteMap(
    request: DeleteMapRequest
  ): LocationIO[DeleteMapResponse] =
    FF.liftF(DeleteMapOp(request))

  def deletePlaceIndex(
    request: DeletePlaceIndexRequest
  ): LocationIO[DeletePlaceIndexResponse] =
    FF.liftF(DeletePlaceIndexOp(request))

  def deleteRouteCalculator(
    request: DeleteRouteCalculatorRequest
  ): LocationIO[DeleteRouteCalculatorResponse] =
    FF.liftF(DeleteRouteCalculatorOp(request))

  def deleteTracker(
    request: DeleteTrackerRequest
  ): LocationIO[DeleteTrackerResponse] =
    FF.liftF(DeleteTrackerOp(request))

  def describeGeofenceCollection(
    request: DescribeGeofenceCollectionRequest
  ): LocationIO[DescribeGeofenceCollectionResponse] =
    FF.liftF(DescribeGeofenceCollectionOp(request))

  def describeMap(
    request: DescribeMapRequest
  ): LocationIO[DescribeMapResponse] =
    FF.liftF(DescribeMapOp(request))

  def describePlaceIndex(
    request: DescribePlaceIndexRequest
  ): LocationIO[DescribePlaceIndexResponse] =
    FF.liftF(DescribePlaceIndexOp(request))

  def describeRouteCalculator(
    request: DescribeRouteCalculatorRequest
  ): LocationIO[DescribeRouteCalculatorResponse] =
    FF.liftF(DescribeRouteCalculatorOp(request))

  def describeTracker(
    request: DescribeTrackerRequest
  ): LocationIO[DescribeTrackerResponse] =
    FF.liftF(DescribeTrackerOp(request))

  def disassociateTrackerConsumer(
    request: DisassociateTrackerConsumerRequest
  ): LocationIO[DisassociateTrackerConsumerResponse] =
    FF.liftF(DisassociateTrackerConsumerOp(request))

  def getDevicePosition(
    request: GetDevicePositionRequest
  ): LocationIO[GetDevicePositionResponse] =
    FF.liftF(GetDevicePositionOp(request))

  def getDevicePositionHistory(
    request: GetDevicePositionHistoryRequest
  ): LocationIO[GetDevicePositionHistoryResponse] =
    FF.liftF(GetDevicePositionHistoryOp(request))

  def getGeofence(
    request: GetGeofenceRequest
  ): LocationIO[GetGeofenceResponse] =
    FF.liftF(GetGeofenceOp(request))

  def getMapGlyphs(
    request: GetMapGlyphsRequest
  ): LocationIO[GetMapGlyphsResponse] =
    FF.liftF(GetMapGlyphsOp(request))

  def getMapSprites(
    request: GetMapSpritesRequest
  ): LocationIO[GetMapSpritesResponse] =
    FF.liftF(GetMapSpritesOp(request))

  def getMapStyleDescriptor(
    request: GetMapStyleDescriptorRequest
  ): LocationIO[GetMapStyleDescriptorResponse] =
    FF.liftF(GetMapStyleDescriptorOp(request))

  def getMapTile(
    request: GetMapTileRequest
  ): LocationIO[GetMapTileResponse] =
    FF.liftF(GetMapTileOp(request))

  def listDevicePositions(
    request: ListDevicePositionsRequest
  ): LocationIO[ListDevicePositionsResponse] =
    FF.liftF(ListDevicePositionsOp(request))

  def listGeofenceCollections(
    request: ListGeofenceCollectionsRequest
  ): LocationIO[ListGeofenceCollectionsResponse] =
    FF.liftF(ListGeofenceCollectionsOp(request))

  def listGeofences(
    request: ListGeofencesRequest
  ): LocationIO[ListGeofencesResponse] =
    FF.liftF(ListGeofencesOp(request))

  def listMaps(
    request: ListMapsRequest
  ): LocationIO[ListMapsResponse] =
    FF.liftF(ListMapsOp(request))

  def listPlaceIndexes(
    request: ListPlaceIndexesRequest
  ): LocationIO[ListPlaceIndexesResponse] =
    FF.liftF(ListPlaceIndexesOp(request))

  def listRouteCalculators(
    request: ListRouteCalculatorsRequest
  ): LocationIO[ListRouteCalculatorsResponse] =
    FF.liftF(ListRouteCalculatorsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): LocationIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTrackerConsumers(
    request: ListTrackerConsumersRequest
  ): LocationIO[ListTrackerConsumersResponse] =
    FF.liftF(ListTrackerConsumersOp(request))

  def listTrackers(
    request: ListTrackersRequest
  ): LocationIO[ListTrackersResponse] =
    FF.liftF(ListTrackersOp(request))

  def putGeofence(
    request: PutGeofenceRequest
  ): LocationIO[PutGeofenceResponse] =
    FF.liftF(PutGeofenceOp(request))

  def searchPlaceIndexForPosition(
    request: SearchPlaceIndexForPositionRequest
  ): LocationIO[SearchPlaceIndexForPositionResponse] =
    FF.liftF(SearchPlaceIndexForPositionOp(request))

  def searchPlaceIndexForText(
    request: SearchPlaceIndexForTextRequest
  ): LocationIO[SearchPlaceIndexForTextResponse] =
    FF.liftF(SearchPlaceIndexForTextOp(request))

  def tagResource(
    request: TagResourceRequest
  ): LocationIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): LocationIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))
}
