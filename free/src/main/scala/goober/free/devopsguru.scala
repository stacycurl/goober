package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.devopsguru.DevOpsGuruClient
import software.amazon.awssdk.services.devopsguru.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object devopsguru { module =>

  // Free monad over DevOpsGuruOp
  type DevOpsGuruIO[A] = FF[DevOpsGuruOp, A]

  sealed trait DevOpsGuruOp[A] {
    def visit[F[_]](visitor: DevOpsGuruOp.Visitor[F]): F[A]
  }

  object DevOpsGuruOp {
    // Given a DevOpsGuruClient we can embed a DevOpsGuruIO program in any algebra that understands embedding.
    implicit val DevOpsGuruOpEmbeddable: Embeddable[DevOpsGuruOp, DevOpsGuruClient] = new Embeddable[DevOpsGuruOp, DevOpsGuruClient] {
      def embed[A](client: DevOpsGuruClient, io: DevOpsGuruIO[A]): Embedded[A] = Embedded.DevOpsGuru(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DevOpsGuruOp.Visitor[Kleisli[M, DevOpsGuruClient, *]] {
        def addNotificationChannel(
          request: AddNotificationChannelRequest
        ): Kleisli[M, DevOpsGuruClient, AddNotificationChannelResponse] =
          primitive(_.addNotificationChannel(request))

        def describeAccountHealth(
          request: DescribeAccountHealthRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeAccountHealthResponse] =
          primitive(_.describeAccountHealth(request))

        def describeAccountOverview(
          request: DescribeAccountOverviewRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeAccountOverviewResponse] =
          primitive(_.describeAccountOverview(request))

        def describeAnomaly(
          request: DescribeAnomalyRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeAnomalyResponse] =
          primitive(_.describeAnomaly(request))

        def describeFeedback(
          request: DescribeFeedbackRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeFeedbackResponse] =
          primitive(_.describeFeedback(request))

        def describeInsight(
          request: DescribeInsightRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeInsightResponse] =
          primitive(_.describeInsight(request))

        def describeResourceCollectionHealth(
          request: DescribeResourceCollectionHealthRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeResourceCollectionHealthResponse] =
          primitive(_.describeResourceCollectionHealth(request))

        def describeServiceIntegration(
          request: DescribeServiceIntegrationRequest
        ): Kleisli[M, DevOpsGuruClient, DescribeServiceIntegrationResponse] =
          primitive(_.describeServiceIntegration(request))

        def getCostEstimation(
          request: GetCostEstimationRequest
        ): Kleisli[M, DevOpsGuruClient, GetCostEstimationResponse] =
          primitive(_.getCostEstimation(request))

        def getResourceCollection(
          request: GetResourceCollectionRequest
        ): Kleisli[M, DevOpsGuruClient, GetResourceCollectionResponse] =
          primitive(_.getResourceCollection(request))

        def listAnomaliesForInsight(
          request: ListAnomaliesForInsightRequest
        ): Kleisli[M, DevOpsGuruClient, ListAnomaliesForInsightResponse] =
          primitive(_.listAnomaliesForInsight(request))

        def listEvents(
          request: ListEventsRequest
        ): Kleisli[M, DevOpsGuruClient, ListEventsResponse] =
          primitive(_.listEvents(request))

        def listInsights(
          request: ListInsightsRequest
        ): Kleisli[M, DevOpsGuruClient, ListInsightsResponse] =
          primitive(_.listInsights(request))

        def listNotificationChannels(
          request: ListNotificationChannelsRequest
        ): Kleisli[M, DevOpsGuruClient, ListNotificationChannelsResponse] =
          primitive(_.listNotificationChannels(request))

        def listRecommendations(
          request: ListRecommendationsRequest
        ): Kleisli[M, DevOpsGuruClient, ListRecommendationsResponse] =
          primitive(_.listRecommendations(request))

        def putFeedback(
          request: PutFeedbackRequest
        ): Kleisli[M, DevOpsGuruClient, PutFeedbackResponse] =
          primitive(_.putFeedback(request))

        def removeNotificationChannel(
          request: RemoveNotificationChannelRequest
        ): Kleisli[M, DevOpsGuruClient, RemoveNotificationChannelResponse] =
          primitive(_.removeNotificationChannel(request))

        def searchInsights(
          request: SearchInsightsRequest
        ): Kleisli[M, DevOpsGuruClient, SearchInsightsResponse] =
          primitive(_.searchInsights(request))

        def startCostEstimation(
          request: StartCostEstimationRequest
        ): Kleisli[M, DevOpsGuruClient, StartCostEstimationResponse] =
          primitive(_.startCostEstimation(request))

        def updateResourceCollection(
          request: UpdateResourceCollectionRequest
        ): Kleisli[M, DevOpsGuruClient, UpdateResourceCollectionResponse] =
          primitive(_.updateResourceCollection(request))

        def updateServiceIntegration(
          request: UpdateServiceIntegrationRequest
        ): Kleisli[M, DevOpsGuruClient, UpdateServiceIntegrationResponse] =
          primitive(_.updateServiceIntegration(request))

        def primitive[A](
          f: DevOpsGuruClient => A
        ): Kleisli[M, DevOpsGuruClient, A]
      }
    }

    trait Visitor[F[_]] extends (DevOpsGuruOp ~> F) {
      final def apply[A](op: DevOpsGuruOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addNotificationChannel(
        request: AddNotificationChannelRequest
      ): F[AddNotificationChannelResponse]

      def describeAccountHealth(
        request: DescribeAccountHealthRequest
      ): F[DescribeAccountHealthResponse]

      def describeAccountOverview(
        request: DescribeAccountOverviewRequest
      ): F[DescribeAccountOverviewResponse]

      def describeAnomaly(
        request: DescribeAnomalyRequest
      ): F[DescribeAnomalyResponse]

      def describeFeedback(
        request: DescribeFeedbackRequest
      ): F[DescribeFeedbackResponse]

      def describeInsight(
        request: DescribeInsightRequest
      ): F[DescribeInsightResponse]

      def describeResourceCollectionHealth(
        request: DescribeResourceCollectionHealthRequest
      ): F[DescribeResourceCollectionHealthResponse]

      def describeServiceIntegration(
        request: DescribeServiceIntegrationRequest
      ): F[DescribeServiceIntegrationResponse]

      def getCostEstimation(
        request: GetCostEstimationRequest
      ): F[GetCostEstimationResponse]

      def getResourceCollection(
        request: GetResourceCollectionRequest
      ): F[GetResourceCollectionResponse]

      def listAnomaliesForInsight(
        request: ListAnomaliesForInsightRequest
      ): F[ListAnomaliesForInsightResponse]

      def listEvents(
        request: ListEventsRequest
      ): F[ListEventsResponse]

      def listInsights(
        request: ListInsightsRequest
      ): F[ListInsightsResponse]

      def listNotificationChannels(
        request: ListNotificationChannelsRequest
      ): F[ListNotificationChannelsResponse]

      def listRecommendations(
        request: ListRecommendationsRequest
      ): F[ListRecommendationsResponse]

      def putFeedback(
        request: PutFeedbackRequest
      ): F[PutFeedbackResponse]

      def removeNotificationChannel(
        request: RemoveNotificationChannelRequest
      ): F[RemoveNotificationChannelResponse]

      def searchInsights(
        request: SearchInsightsRequest
      ): F[SearchInsightsResponse]

      def startCostEstimation(
        request: StartCostEstimationRequest
      ): F[StartCostEstimationResponse]

      def updateResourceCollection(
        request: UpdateResourceCollectionRequest
      ): F[UpdateResourceCollectionResponse]

      def updateServiceIntegration(
        request: UpdateServiceIntegrationRequest
      ): F[UpdateServiceIntegrationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DevOpsGuruOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddNotificationChannelOp(
      request: AddNotificationChannelRequest
    ) extends DevOpsGuruOp[AddNotificationChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddNotificationChannelResponse] =
        visitor.addNotificationChannel(request)
    }

    final case class DescribeAccountHealthOp(
      request: DescribeAccountHealthRequest
    ) extends DevOpsGuruOp[DescribeAccountHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountHealthResponse] =
        visitor.describeAccountHealth(request)
    }

    final case class DescribeAccountOverviewOp(
      request: DescribeAccountOverviewRequest
    ) extends DevOpsGuruOp[DescribeAccountOverviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountOverviewResponse] =
        visitor.describeAccountOverview(request)
    }

    final case class DescribeAnomalyOp(
      request: DescribeAnomalyRequest
    ) extends DevOpsGuruOp[DescribeAnomalyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnomalyResponse] =
        visitor.describeAnomaly(request)
    }

    final case class DescribeFeedbackOp(
      request: DescribeFeedbackRequest
    ) extends DevOpsGuruOp[DescribeFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFeedbackResponse] =
        visitor.describeFeedback(request)
    }

    final case class DescribeInsightOp(
      request: DescribeInsightRequest
    ) extends DevOpsGuruOp[DescribeInsightResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInsightResponse] =
        visitor.describeInsight(request)
    }

    final case class DescribeResourceCollectionHealthOp(
      request: DescribeResourceCollectionHealthRequest
    ) extends DevOpsGuruOp[DescribeResourceCollectionHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourceCollectionHealthResponse] =
        visitor.describeResourceCollectionHealth(request)
    }

    final case class DescribeServiceIntegrationOp(
      request: DescribeServiceIntegrationRequest
    ) extends DevOpsGuruOp[DescribeServiceIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceIntegrationResponse] =
        visitor.describeServiceIntegration(request)
    }

    final case class GetCostEstimationOp(
      request: GetCostEstimationRequest
    ) extends DevOpsGuruOp[GetCostEstimationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCostEstimationResponse] =
        visitor.getCostEstimation(request)
    }

    final case class GetResourceCollectionOp(
      request: GetResourceCollectionRequest
    ) extends DevOpsGuruOp[GetResourceCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceCollectionResponse] =
        visitor.getResourceCollection(request)
    }

    final case class ListAnomaliesForInsightOp(
      request: ListAnomaliesForInsightRequest
    ) extends DevOpsGuruOp[ListAnomaliesForInsightResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnomaliesForInsightResponse] =
        visitor.listAnomaliesForInsight(request)
    }

    final case class ListEventsOp(
      request: ListEventsRequest
    ) extends DevOpsGuruOp[ListEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventsResponse] =
        visitor.listEvents(request)
    }

    final case class ListInsightsOp(
      request: ListInsightsRequest
    ) extends DevOpsGuruOp[ListInsightsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInsightsResponse] =
        visitor.listInsights(request)
    }

    final case class ListNotificationChannelsOp(
      request: ListNotificationChannelsRequest
    ) extends DevOpsGuruOp[ListNotificationChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotificationChannelsResponse] =
        visitor.listNotificationChannels(request)
    }

    final case class ListRecommendationsOp(
      request: ListRecommendationsRequest
    ) extends DevOpsGuruOp[ListRecommendationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecommendationsResponse] =
        visitor.listRecommendations(request)
    }

    final case class PutFeedbackOp(
      request: PutFeedbackRequest
    ) extends DevOpsGuruOp[PutFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutFeedbackResponse] =
        visitor.putFeedback(request)
    }

    final case class RemoveNotificationChannelOp(
      request: RemoveNotificationChannelRequest
    ) extends DevOpsGuruOp[RemoveNotificationChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveNotificationChannelResponse] =
        visitor.removeNotificationChannel(request)
    }

    final case class SearchInsightsOp(
      request: SearchInsightsRequest
    ) extends DevOpsGuruOp[SearchInsightsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchInsightsResponse] =
        visitor.searchInsights(request)
    }

    final case class StartCostEstimationOp(
      request: StartCostEstimationRequest
    ) extends DevOpsGuruOp[StartCostEstimationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartCostEstimationResponse] =
        visitor.startCostEstimation(request)
    }

    final case class UpdateResourceCollectionOp(
      request: UpdateResourceCollectionRequest
    ) extends DevOpsGuruOp[UpdateResourceCollectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceCollectionResponse] =
        visitor.updateResourceCollection(request)
    }

    final case class UpdateServiceIntegrationOp(
      request: UpdateServiceIntegrationRequest
    ) extends DevOpsGuruOp[UpdateServiceIntegrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceIntegrationResponse] =
        visitor.updateServiceIntegration(request)
    }
  }

  import DevOpsGuruOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DevOpsGuruOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addNotificationChannel(
    request: AddNotificationChannelRequest
  ): DevOpsGuruIO[AddNotificationChannelResponse] =
    FF.liftF(AddNotificationChannelOp(request))

  def describeAccountHealth(
    request: DescribeAccountHealthRequest
  ): DevOpsGuruIO[DescribeAccountHealthResponse] =
    FF.liftF(DescribeAccountHealthOp(request))

  def describeAccountOverview(
    request: DescribeAccountOverviewRequest
  ): DevOpsGuruIO[DescribeAccountOverviewResponse] =
    FF.liftF(DescribeAccountOverviewOp(request))

  def describeAnomaly(
    request: DescribeAnomalyRequest
  ): DevOpsGuruIO[DescribeAnomalyResponse] =
    FF.liftF(DescribeAnomalyOp(request))

  def describeFeedback(
    request: DescribeFeedbackRequest
  ): DevOpsGuruIO[DescribeFeedbackResponse] =
    FF.liftF(DescribeFeedbackOp(request))

  def describeInsight(
    request: DescribeInsightRequest
  ): DevOpsGuruIO[DescribeInsightResponse] =
    FF.liftF(DescribeInsightOp(request))

  def describeResourceCollectionHealth(
    request: DescribeResourceCollectionHealthRequest
  ): DevOpsGuruIO[DescribeResourceCollectionHealthResponse] =
    FF.liftF(DescribeResourceCollectionHealthOp(request))

  def describeServiceIntegration(
    request: DescribeServiceIntegrationRequest
  ): DevOpsGuruIO[DescribeServiceIntegrationResponse] =
    FF.liftF(DescribeServiceIntegrationOp(request))

  def getCostEstimation(
    request: GetCostEstimationRequest
  ): DevOpsGuruIO[GetCostEstimationResponse] =
    FF.liftF(GetCostEstimationOp(request))

  def getResourceCollection(
    request: GetResourceCollectionRequest
  ): DevOpsGuruIO[GetResourceCollectionResponse] =
    FF.liftF(GetResourceCollectionOp(request))

  def listAnomaliesForInsight(
    request: ListAnomaliesForInsightRequest
  ): DevOpsGuruIO[ListAnomaliesForInsightResponse] =
    FF.liftF(ListAnomaliesForInsightOp(request))

  def listEvents(
    request: ListEventsRequest
  ): DevOpsGuruIO[ListEventsResponse] =
    FF.liftF(ListEventsOp(request))

  def listInsights(
    request: ListInsightsRequest
  ): DevOpsGuruIO[ListInsightsResponse] =
    FF.liftF(ListInsightsOp(request))

  def listNotificationChannels(
    request: ListNotificationChannelsRequest
  ): DevOpsGuruIO[ListNotificationChannelsResponse] =
    FF.liftF(ListNotificationChannelsOp(request))

  def listRecommendations(
    request: ListRecommendationsRequest
  ): DevOpsGuruIO[ListRecommendationsResponse] =
    FF.liftF(ListRecommendationsOp(request))

  def putFeedback(
    request: PutFeedbackRequest
  ): DevOpsGuruIO[PutFeedbackResponse] =
    FF.liftF(PutFeedbackOp(request))

  def removeNotificationChannel(
    request: RemoveNotificationChannelRequest
  ): DevOpsGuruIO[RemoveNotificationChannelResponse] =
    FF.liftF(RemoveNotificationChannelOp(request))

  def searchInsights(
    request: SearchInsightsRequest
  ): DevOpsGuruIO[SearchInsightsResponse] =
    FF.liftF(SearchInsightsOp(request))

  def startCostEstimation(
    request: StartCostEstimationRequest
  ): DevOpsGuruIO[StartCostEstimationResponse] =
    FF.liftF(StartCostEstimationOp(request))

  def updateResourceCollection(
    request: UpdateResourceCollectionRequest
  ): DevOpsGuruIO[UpdateResourceCollectionResponse] =
    FF.liftF(UpdateResourceCollectionOp(request))

  def updateServiceIntegration(
    request: UpdateServiceIntegrationRequest
  ): DevOpsGuruIO[UpdateServiceIntegrationResponse] =
    FF.liftF(UpdateServiceIntegrationOp(request))
}
