package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudtrail.CloudTrailClient
import software.amazon.awssdk.services.cloudtrail.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cloudtrail { module =>

  // Free monad over CloudTrailOp
  type CloudTrailIO[A] = FF[CloudTrailOp, A]

  sealed trait CloudTrailOp[A] {
    def visit[F[_]](visitor: CloudTrailOp.Visitor[F]): F[A]
  }

  object CloudTrailOp {
    // Given a CloudTrailClient we can embed a CloudTrailIO program in any algebra that understands embedding.
    implicit val CloudTrailOpEmbeddable: Embeddable[CloudTrailOp, CloudTrailClient] = new Embeddable[CloudTrailOp, CloudTrailClient] {
      def embed[A](client: CloudTrailClient, io: CloudTrailIO[A]): Embedded[A] = Embedded.CloudTrail(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudTrailOp.Visitor[Kleisli[M, CloudTrailClient, *]] {
        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, CloudTrailClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def createTrail(
          request: CreateTrailRequest
        ): Kleisli[M, CloudTrailClient, CreateTrailResponse] =
          primitive(_.createTrail(request))

        def deleteTrail(
          request: DeleteTrailRequest
        ): Kleisli[M, CloudTrailClient, DeleteTrailResponse] =
          primitive(_.deleteTrail(request))

        def describeTrails(
          request: DescribeTrailsRequest
        ): Kleisli[M, CloudTrailClient, DescribeTrailsResponse] =
          primitive(_.describeTrails(request))

        def getEventSelectors(
          request: GetEventSelectorsRequest
        ): Kleisli[M, CloudTrailClient, GetEventSelectorsResponse] =
          primitive(_.getEventSelectors(request))

        def getInsightSelectors(
          request: GetInsightSelectorsRequest
        ): Kleisli[M, CloudTrailClient, GetInsightSelectorsResponse] =
          primitive(_.getInsightSelectors(request))

        def getTrail(
          request: GetTrailRequest
        ): Kleisli[M, CloudTrailClient, GetTrailResponse] =
          primitive(_.getTrail(request))

        def getTrailStatus(
          request: GetTrailStatusRequest
        ): Kleisli[M, CloudTrailClient, GetTrailStatusResponse] =
          primitive(_.getTrailStatus(request))

        def listPublicKeys(
          request: ListPublicKeysRequest
        ): Kleisli[M, CloudTrailClient, ListPublicKeysResponse] =
          primitive(_.listPublicKeys(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, CloudTrailClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def listTrails(
          request: ListTrailsRequest
        ): Kleisli[M, CloudTrailClient, ListTrailsResponse] =
          primitive(_.listTrails(request))

        def lookupEvents(
          request: LookupEventsRequest
        ): Kleisli[M, CloudTrailClient, LookupEventsResponse] =
          primitive(_.lookupEvents(request))

        def putEventSelectors(
          request: PutEventSelectorsRequest
        ): Kleisli[M, CloudTrailClient, PutEventSelectorsResponse] =
          primitive(_.putEventSelectors(request))

        def putInsightSelectors(
          request: PutInsightSelectorsRequest
        ): Kleisli[M, CloudTrailClient, PutInsightSelectorsResponse] =
          primitive(_.putInsightSelectors(request))

        def removeTags(
          request: RemoveTagsRequest
        ): Kleisli[M, CloudTrailClient, RemoveTagsResponse] =
          primitive(_.removeTags(request))

        def startLogging(
          request: StartLoggingRequest
        ): Kleisli[M, CloudTrailClient, StartLoggingResponse] =
          primitive(_.startLogging(request))

        def stopLogging(
          request: StopLoggingRequest
        ): Kleisli[M, CloudTrailClient, StopLoggingResponse] =
          primitive(_.stopLogging(request))

        def updateTrail(
          request: UpdateTrailRequest
        ): Kleisli[M, CloudTrailClient, UpdateTrailResponse] =
          primitive(_.updateTrail(request))

        def primitive[A](
          f: CloudTrailClient => A
        ): Kleisli[M, CloudTrailClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudTrailOp ~> F) {
      final def apply[A](op: CloudTrailOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def createTrail(
        request: CreateTrailRequest
      ): F[CreateTrailResponse]

      def deleteTrail(
        request: DeleteTrailRequest
      ): F[DeleteTrailResponse]

      def describeTrails(
        request: DescribeTrailsRequest
      ): F[DescribeTrailsResponse]

      def getEventSelectors(
        request: GetEventSelectorsRequest
      ): F[GetEventSelectorsResponse]

      def getInsightSelectors(
        request: GetInsightSelectorsRequest
      ): F[GetInsightSelectorsResponse]

      def getTrail(
        request: GetTrailRequest
      ): F[GetTrailResponse]

      def getTrailStatus(
        request: GetTrailStatusRequest
      ): F[GetTrailStatusResponse]

      def listPublicKeys(
        request: ListPublicKeysRequest
      ): F[ListPublicKeysResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def listTrails(
        request: ListTrailsRequest
      ): F[ListTrailsResponse]

      def lookupEvents(
        request: LookupEventsRequest
      ): F[LookupEventsResponse]

      def putEventSelectors(
        request: PutEventSelectorsRequest
      ): F[PutEventSelectorsResponse]

      def putInsightSelectors(
        request: PutInsightSelectorsRequest
      ): F[PutInsightSelectorsResponse]

      def removeTags(
        request: RemoveTagsRequest
      ): F[RemoveTagsResponse]

      def startLogging(
        request: StartLoggingRequest
      ): F[StartLoggingResponse]

      def stopLogging(
        request: StopLoggingRequest
      ): F[StopLoggingResponse]

      def updateTrail(
        request: UpdateTrailRequest
      ): F[UpdateTrailResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudTrailOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends CloudTrailOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class CreateTrailOp(
      request: CreateTrailRequest
    ) extends CloudTrailOp[CreateTrailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTrailResponse] =
        visitor.createTrail(request)
    }

    final case class DeleteTrailOp(
      request: DeleteTrailRequest
    ) extends CloudTrailOp[DeleteTrailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTrailResponse] =
        visitor.deleteTrail(request)
    }

    final case class DescribeTrailsOp(
      request: DescribeTrailsRequest
    ) extends CloudTrailOp[DescribeTrailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrailsResponse] =
        visitor.describeTrails(request)
    }

    final case class GetEventSelectorsOp(
      request: GetEventSelectorsRequest
    ) extends CloudTrailOp[GetEventSelectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventSelectorsResponse] =
        visitor.getEventSelectors(request)
    }

    final case class GetInsightSelectorsOp(
      request: GetInsightSelectorsRequest
    ) extends CloudTrailOp[GetInsightSelectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInsightSelectorsResponse] =
        visitor.getInsightSelectors(request)
    }

    final case class GetTrailOp(
      request: GetTrailRequest
    ) extends CloudTrailOp[GetTrailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTrailResponse] =
        visitor.getTrail(request)
    }

    final case class GetTrailStatusOp(
      request: GetTrailStatusRequest
    ) extends CloudTrailOp[GetTrailStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTrailStatusResponse] =
        visitor.getTrailStatus(request)
    }

    final case class ListPublicKeysOp(
      request: ListPublicKeysRequest
    ) extends CloudTrailOp[ListPublicKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPublicKeysResponse] =
        visitor.listPublicKeys(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends CloudTrailOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class ListTrailsOp(
      request: ListTrailsRequest
    ) extends CloudTrailOp[ListTrailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTrailsResponse] =
        visitor.listTrails(request)
    }

    final case class LookupEventsOp(
      request: LookupEventsRequest
    ) extends CloudTrailOp[LookupEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LookupEventsResponse] =
        visitor.lookupEvents(request)
    }

    final case class PutEventSelectorsOp(
      request: PutEventSelectorsRequest
    ) extends CloudTrailOp[PutEventSelectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventSelectorsResponse] =
        visitor.putEventSelectors(request)
    }

    final case class PutInsightSelectorsOp(
      request: PutInsightSelectorsRequest
    ) extends CloudTrailOp[PutInsightSelectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutInsightSelectorsResponse] =
        visitor.putInsightSelectors(request)
    }

    final case class RemoveTagsOp(
      request: RemoveTagsRequest
    ) extends CloudTrailOp[RemoveTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsResponse] =
        visitor.removeTags(request)
    }

    final case class StartLoggingOp(
      request: StartLoggingRequest
    ) extends CloudTrailOp[StartLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartLoggingResponse] =
        visitor.startLogging(request)
    }

    final case class StopLoggingOp(
      request: StopLoggingRequest
    ) extends CloudTrailOp[StopLoggingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopLoggingResponse] =
        visitor.stopLogging(request)
    }

    final case class UpdateTrailOp(
      request: UpdateTrailRequest
    ) extends CloudTrailOp[UpdateTrailResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTrailResponse] =
        visitor.updateTrail(request)
    }
  }

  import CloudTrailOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudTrailOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTags(
    request: AddTagsRequest
  ): CloudTrailIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def createTrail(
    request: CreateTrailRequest
  ): CloudTrailIO[CreateTrailResponse] =
    FF.liftF(CreateTrailOp(request))

  def deleteTrail(
    request: DeleteTrailRequest
  ): CloudTrailIO[DeleteTrailResponse] =
    FF.liftF(DeleteTrailOp(request))

  def describeTrails(
    request: DescribeTrailsRequest
  ): CloudTrailIO[DescribeTrailsResponse] =
    FF.liftF(DescribeTrailsOp(request))

  def getEventSelectors(
    request: GetEventSelectorsRequest
  ): CloudTrailIO[GetEventSelectorsResponse] =
    FF.liftF(GetEventSelectorsOp(request))

  def getInsightSelectors(
    request: GetInsightSelectorsRequest
  ): CloudTrailIO[GetInsightSelectorsResponse] =
    FF.liftF(GetInsightSelectorsOp(request))

  def getTrail(
    request: GetTrailRequest
  ): CloudTrailIO[GetTrailResponse] =
    FF.liftF(GetTrailOp(request))

  def getTrailStatus(
    request: GetTrailStatusRequest
  ): CloudTrailIO[GetTrailStatusResponse] =
    FF.liftF(GetTrailStatusOp(request))

  def listPublicKeys(
    request: ListPublicKeysRequest
  ): CloudTrailIO[ListPublicKeysResponse] =
    FF.liftF(ListPublicKeysOp(request))

  def listTags(
    request: ListTagsRequest
  ): CloudTrailIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def listTrails(
    request: ListTrailsRequest
  ): CloudTrailIO[ListTrailsResponse] =
    FF.liftF(ListTrailsOp(request))

  def lookupEvents(
    request: LookupEventsRequest
  ): CloudTrailIO[LookupEventsResponse] =
    FF.liftF(LookupEventsOp(request))

  def putEventSelectors(
    request: PutEventSelectorsRequest
  ): CloudTrailIO[PutEventSelectorsResponse] =
    FF.liftF(PutEventSelectorsOp(request))

  def putInsightSelectors(
    request: PutInsightSelectorsRequest
  ): CloudTrailIO[PutInsightSelectorsResponse] =
    FF.liftF(PutInsightSelectorsOp(request))

  def removeTags(
    request: RemoveTagsRequest
  ): CloudTrailIO[RemoveTagsResponse] =
    FF.liftF(RemoveTagsOp(request))

  def startLogging(
    request: StartLoggingRequest
  ): CloudTrailIO[StartLoggingResponse] =
    FF.liftF(StartLoggingOp(request))

  def stopLogging(
    request: StopLoggingRequest
  ): CloudTrailIO[StopLoggingResponse] =
    FF.liftF(StopLoggingOp(request))

  def updateTrail(
    request: UpdateTrailRequest
  ): CloudTrailIO[UpdateTrailResponse] =
    FF.liftF(UpdateTrailOp(request))
}
