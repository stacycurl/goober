package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.costexplorer.CostExplorerClient
import software.amazon.awssdk.services.costexplorer.model._


object costexplorer { module =>

  // Free monad over CostExplorerOp
  type CostExplorerIO[A] = FF[CostExplorerOp, A]

  sealed trait CostExplorerOp[A] {
    def visit[F[_]](visitor: CostExplorerOp.Visitor[F]): F[A]
  }

  object CostExplorerOp {
    // Given a CostExplorerClient we can embed a CostExplorerIO program in any algebra that understands embedding.
    implicit val CostExplorerOpEmbeddable: Embeddable[CostExplorerOp, CostExplorerClient] = new Embeddable[CostExplorerOp, CostExplorerClient] {
      def embed[A](client: CostExplorerClient, io: CostExplorerIO[A]): Embedded[A] = Embedded.CostExplorer(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CostExplorerOp.Visitor[Kleisli[M, CostExplorerClient, *]] {
        def createAnomalyMonitor(
          request: CreateAnomalyMonitorRequest
        ): Kleisli[M, CostExplorerClient, CreateAnomalyMonitorResponse] =
          primitive(_.createAnomalyMonitor(request))

        def createAnomalySubscription(
          request: CreateAnomalySubscriptionRequest
        ): Kleisli[M, CostExplorerClient, CreateAnomalySubscriptionResponse] =
          primitive(_.createAnomalySubscription(request))

        def createCostCategoryDefinition(
          request: CreateCostCategoryDefinitionRequest
        ): Kleisli[M, CostExplorerClient, CreateCostCategoryDefinitionResponse] =
          primitive(_.createCostCategoryDefinition(request))

        def deleteAnomalyMonitor(
          request: DeleteAnomalyMonitorRequest
        ): Kleisli[M, CostExplorerClient, DeleteAnomalyMonitorResponse] =
          primitive(_.deleteAnomalyMonitor(request))

        def deleteAnomalySubscription(
          request: DeleteAnomalySubscriptionRequest
        ): Kleisli[M, CostExplorerClient, DeleteAnomalySubscriptionResponse] =
          primitive(_.deleteAnomalySubscription(request))

        def deleteCostCategoryDefinition(
          request: DeleteCostCategoryDefinitionRequest
        ): Kleisli[M, CostExplorerClient, DeleteCostCategoryDefinitionResponse] =
          primitive(_.deleteCostCategoryDefinition(request))

        def describeCostCategoryDefinition(
          request: DescribeCostCategoryDefinitionRequest
        ): Kleisli[M, CostExplorerClient, DescribeCostCategoryDefinitionResponse] =
          primitive(_.describeCostCategoryDefinition(request))

        def getAnomalies(
          request: GetAnomaliesRequest
        ): Kleisli[M, CostExplorerClient, GetAnomaliesResponse] =
          primitive(_.getAnomalies(request))

        def getAnomalyMonitors(
          request: GetAnomalyMonitorsRequest
        ): Kleisli[M, CostExplorerClient, GetAnomalyMonitorsResponse] =
          primitive(_.getAnomalyMonitors(request))

        def getAnomalySubscriptions(
          request: GetAnomalySubscriptionsRequest
        ): Kleisli[M, CostExplorerClient, GetAnomalySubscriptionsResponse] =
          primitive(_.getAnomalySubscriptions(request))

        def getCostAndUsage(
          request: GetCostAndUsageRequest
        ): Kleisli[M, CostExplorerClient, GetCostAndUsageResponse] =
          primitive(_.getCostAndUsage(request))

        def getCostAndUsageWithResources(
          request: GetCostAndUsageWithResourcesRequest
        ): Kleisli[M, CostExplorerClient, GetCostAndUsageWithResourcesResponse] =
          primitive(_.getCostAndUsageWithResources(request))

        def getCostCategories(
          request: GetCostCategoriesRequest
        ): Kleisli[M, CostExplorerClient, GetCostCategoriesResponse] =
          primitive(_.getCostCategories(request))

        def getCostForecast(
          request: GetCostForecastRequest
        ): Kleisli[M, CostExplorerClient, GetCostForecastResponse] =
          primitive(_.getCostForecast(request))

        def getDimensionValues(
          request: GetDimensionValuesRequest
        ): Kleisli[M, CostExplorerClient, GetDimensionValuesResponse] =
          primitive(_.getDimensionValues(request))

        def getReservationCoverage(
          request: GetReservationCoverageRequest
        ): Kleisli[M, CostExplorerClient, GetReservationCoverageResponse] =
          primitive(_.getReservationCoverage(request))

        def getReservationPurchaseRecommendation(
          request: GetReservationPurchaseRecommendationRequest
        ): Kleisli[M, CostExplorerClient, GetReservationPurchaseRecommendationResponse] =
          primitive(_.getReservationPurchaseRecommendation(request))

        def getReservationUtilization(
          request: GetReservationUtilizationRequest
        ): Kleisli[M, CostExplorerClient, GetReservationUtilizationResponse] =
          primitive(_.getReservationUtilization(request))

        def getRightsizingRecommendation(
          request: GetRightsizingRecommendationRequest
        ): Kleisli[M, CostExplorerClient, GetRightsizingRecommendationResponse] =
          primitive(_.getRightsizingRecommendation(request))

        def getSavingsPlansCoverage(
          request: GetSavingsPlansCoverageRequest
        ): Kleisli[M, CostExplorerClient, GetSavingsPlansCoverageResponse] =
          primitive(_.getSavingsPlansCoverage(request))

        def getSavingsPlansPurchaseRecommendation(
          request: GetSavingsPlansPurchaseRecommendationRequest
        ): Kleisli[M, CostExplorerClient, GetSavingsPlansPurchaseRecommendationResponse] =
          primitive(_.getSavingsPlansPurchaseRecommendation(request))

        def getSavingsPlansUtilization(
          request: GetSavingsPlansUtilizationRequest
        ): Kleisli[M, CostExplorerClient, GetSavingsPlansUtilizationResponse] =
          primitive(_.getSavingsPlansUtilization(request))

        def getSavingsPlansUtilizationDetails(
          request: GetSavingsPlansUtilizationDetailsRequest
        ): Kleisli[M, CostExplorerClient, GetSavingsPlansUtilizationDetailsResponse] =
          primitive(_.getSavingsPlansUtilizationDetails(request))

        def getTags(
          request: GetTagsRequest
        ): Kleisli[M, CostExplorerClient, GetTagsResponse] =
          primitive(_.getTags(request))

        def getUsageForecast(
          request: GetUsageForecastRequest
        ): Kleisli[M, CostExplorerClient, GetUsageForecastResponse] =
          primitive(_.getUsageForecast(request))

        def listCostCategoryDefinitions(
          request: ListCostCategoryDefinitionsRequest
        ): Kleisli[M, CostExplorerClient, ListCostCategoryDefinitionsResponse] =
          primitive(_.listCostCategoryDefinitions(request))

        def provideAnomalyFeedback(
          request: ProvideAnomalyFeedbackRequest
        ): Kleisli[M, CostExplorerClient, ProvideAnomalyFeedbackResponse] =
          primitive(_.provideAnomalyFeedback(request))

        def updateAnomalyMonitor(
          request: UpdateAnomalyMonitorRequest
        ): Kleisli[M, CostExplorerClient, UpdateAnomalyMonitorResponse] =
          primitive(_.updateAnomalyMonitor(request))

        def updateAnomalySubscription(
          request: UpdateAnomalySubscriptionRequest
        ): Kleisli[M, CostExplorerClient, UpdateAnomalySubscriptionResponse] =
          primitive(_.updateAnomalySubscription(request))

        def updateCostCategoryDefinition(
          request: UpdateCostCategoryDefinitionRequest
        ): Kleisli[M, CostExplorerClient, UpdateCostCategoryDefinitionResponse] =
          primitive(_.updateCostCategoryDefinition(request))

        def primitive[A](
          f: CostExplorerClient => A
        ): Kleisli[M, CostExplorerClient, A]
      }
    }

    trait Visitor[F[_]] extends (CostExplorerOp ~> F) {
      final def apply[A](op: CostExplorerOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createAnomalyMonitor(
        request: CreateAnomalyMonitorRequest
      ): F[CreateAnomalyMonitorResponse]

      def createAnomalySubscription(
        request: CreateAnomalySubscriptionRequest
      ): F[CreateAnomalySubscriptionResponse]

      def createCostCategoryDefinition(
        request: CreateCostCategoryDefinitionRequest
      ): F[CreateCostCategoryDefinitionResponse]

      def deleteAnomalyMonitor(
        request: DeleteAnomalyMonitorRequest
      ): F[DeleteAnomalyMonitorResponse]

      def deleteAnomalySubscription(
        request: DeleteAnomalySubscriptionRequest
      ): F[DeleteAnomalySubscriptionResponse]

      def deleteCostCategoryDefinition(
        request: DeleteCostCategoryDefinitionRequest
      ): F[DeleteCostCategoryDefinitionResponse]

      def describeCostCategoryDefinition(
        request: DescribeCostCategoryDefinitionRequest
      ): F[DescribeCostCategoryDefinitionResponse]

      def getAnomalies(
        request: GetAnomaliesRequest
      ): F[GetAnomaliesResponse]

      def getAnomalyMonitors(
        request: GetAnomalyMonitorsRequest
      ): F[GetAnomalyMonitorsResponse]

      def getAnomalySubscriptions(
        request: GetAnomalySubscriptionsRequest
      ): F[GetAnomalySubscriptionsResponse]

      def getCostAndUsage(
        request: GetCostAndUsageRequest
      ): F[GetCostAndUsageResponse]

      def getCostAndUsageWithResources(
        request: GetCostAndUsageWithResourcesRequest
      ): F[GetCostAndUsageWithResourcesResponse]

      def getCostCategories(
        request: GetCostCategoriesRequest
      ): F[GetCostCategoriesResponse]

      def getCostForecast(
        request: GetCostForecastRequest
      ): F[GetCostForecastResponse]

      def getDimensionValues(
        request: GetDimensionValuesRequest
      ): F[GetDimensionValuesResponse]

      def getReservationCoverage(
        request: GetReservationCoverageRequest
      ): F[GetReservationCoverageResponse]

      def getReservationPurchaseRecommendation(
        request: GetReservationPurchaseRecommendationRequest
      ): F[GetReservationPurchaseRecommendationResponse]

      def getReservationUtilization(
        request: GetReservationUtilizationRequest
      ): F[GetReservationUtilizationResponse]

      def getRightsizingRecommendation(
        request: GetRightsizingRecommendationRequest
      ): F[GetRightsizingRecommendationResponse]

      def getSavingsPlansCoverage(
        request: GetSavingsPlansCoverageRequest
      ): F[GetSavingsPlansCoverageResponse]

      def getSavingsPlansPurchaseRecommendation(
        request: GetSavingsPlansPurchaseRecommendationRequest
      ): F[GetSavingsPlansPurchaseRecommendationResponse]

      def getSavingsPlansUtilization(
        request: GetSavingsPlansUtilizationRequest
      ): F[GetSavingsPlansUtilizationResponse]

      def getSavingsPlansUtilizationDetails(
        request: GetSavingsPlansUtilizationDetailsRequest
      ): F[GetSavingsPlansUtilizationDetailsResponse]

      def getTags(
        request: GetTagsRequest
      ): F[GetTagsResponse]

      def getUsageForecast(
        request: GetUsageForecastRequest
      ): F[GetUsageForecastResponse]

      def listCostCategoryDefinitions(
        request: ListCostCategoryDefinitionsRequest
      ): F[ListCostCategoryDefinitionsResponse]

      def provideAnomalyFeedback(
        request: ProvideAnomalyFeedbackRequest
      ): F[ProvideAnomalyFeedbackResponse]

      def updateAnomalyMonitor(
        request: UpdateAnomalyMonitorRequest
      ): F[UpdateAnomalyMonitorResponse]

      def updateAnomalySubscription(
        request: UpdateAnomalySubscriptionRequest
      ): F[UpdateAnomalySubscriptionResponse]

      def updateCostCategoryDefinition(
        request: UpdateCostCategoryDefinitionRequest
      ): F[UpdateCostCategoryDefinitionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CostExplorerOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateAnomalyMonitorOp(
      request: CreateAnomalyMonitorRequest
    ) extends CostExplorerOp[CreateAnomalyMonitorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAnomalyMonitorResponse] =
        visitor.createAnomalyMonitor(request)
    }

    final case class CreateAnomalySubscriptionOp(
      request: CreateAnomalySubscriptionRequest
    ) extends CostExplorerOp[CreateAnomalySubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAnomalySubscriptionResponse] =
        visitor.createAnomalySubscription(request)
    }

    final case class CreateCostCategoryDefinitionOp(
      request: CreateCostCategoryDefinitionRequest
    ) extends CostExplorerOp[CreateCostCategoryDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCostCategoryDefinitionResponse] =
        visitor.createCostCategoryDefinition(request)
    }

    final case class DeleteAnomalyMonitorOp(
      request: DeleteAnomalyMonitorRequest
    ) extends CostExplorerOp[DeleteAnomalyMonitorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnomalyMonitorResponse] =
        visitor.deleteAnomalyMonitor(request)
    }

    final case class DeleteAnomalySubscriptionOp(
      request: DeleteAnomalySubscriptionRequest
    ) extends CostExplorerOp[DeleteAnomalySubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnomalySubscriptionResponse] =
        visitor.deleteAnomalySubscription(request)
    }

    final case class DeleteCostCategoryDefinitionOp(
      request: DeleteCostCategoryDefinitionRequest
    ) extends CostExplorerOp[DeleteCostCategoryDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCostCategoryDefinitionResponse] =
        visitor.deleteCostCategoryDefinition(request)
    }

    final case class DescribeCostCategoryDefinitionOp(
      request: DescribeCostCategoryDefinitionRequest
    ) extends CostExplorerOp[DescribeCostCategoryDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCostCategoryDefinitionResponse] =
        visitor.describeCostCategoryDefinition(request)
    }

    final case class GetAnomaliesOp(
      request: GetAnomaliesRequest
    ) extends CostExplorerOp[GetAnomaliesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnomaliesResponse] =
        visitor.getAnomalies(request)
    }

    final case class GetAnomalyMonitorsOp(
      request: GetAnomalyMonitorsRequest
    ) extends CostExplorerOp[GetAnomalyMonitorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnomalyMonitorsResponse] =
        visitor.getAnomalyMonitors(request)
    }

    final case class GetAnomalySubscriptionsOp(
      request: GetAnomalySubscriptionsRequest
    ) extends CostExplorerOp[GetAnomalySubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAnomalySubscriptionsResponse] =
        visitor.getAnomalySubscriptions(request)
    }

    final case class GetCostAndUsageOp(
      request: GetCostAndUsageRequest
    ) extends CostExplorerOp[GetCostAndUsageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCostAndUsageResponse] =
        visitor.getCostAndUsage(request)
    }

    final case class GetCostAndUsageWithResourcesOp(
      request: GetCostAndUsageWithResourcesRequest
    ) extends CostExplorerOp[GetCostAndUsageWithResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCostAndUsageWithResourcesResponse] =
        visitor.getCostAndUsageWithResources(request)
    }

    final case class GetCostCategoriesOp(
      request: GetCostCategoriesRequest
    ) extends CostExplorerOp[GetCostCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCostCategoriesResponse] =
        visitor.getCostCategories(request)
    }

    final case class GetCostForecastOp(
      request: GetCostForecastRequest
    ) extends CostExplorerOp[GetCostForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCostForecastResponse] =
        visitor.getCostForecast(request)
    }

    final case class GetDimensionValuesOp(
      request: GetDimensionValuesRequest
    ) extends CostExplorerOp[GetDimensionValuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDimensionValuesResponse] =
        visitor.getDimensionValues(request)
    }

    final case class GetReservationCoverageOp(
      request: GetReservationCoverageRequest
    ) extends CostExplorerOp[GetReservationCoverageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReservationCoverageResponse] =
        visitor.getReservationCoverage(request)
    }

    final case class GetReservationPurchaseRecommendationOp(
      request: GetReservationPurchaseRecommendationRequest
    ) extends CostExplorerOp[GetReservationPurchaseRecommendationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReservationPurchaseRecommendationResponse] =
        visitor.getReservationPurchaseRecommendation(request)
    }

    final case class GetReservationUtilizationOp(
      request: GetReservationUtilizationRequest
    ) extends CostExplorerOp[GetReservationUtilizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReservationUtilizationResponse] =
        visitor.getReservationUtilization(request)
    }

    final case class GetRightsizingRecommendationOp(
      request: GetRightsizingRecommendationRequest
    ) extends CostExplorerOp[GetRightsizingRecommendationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRightsizingRecommendationResponse] =
        visitor.getRightsizingRecommendation(request)
    }

    final case class GetSavingsPlansCoverageOp(
      request: GetSavingsPlansCoverageRequest
    ) extends CostExplorerOp[GetSavingsPlansCoverageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSavingsPlansCoverageResponse] =
        visitor.getSavingsPlansCoverage(request)
    }

    final case class GetSavingsPlansPurchaseRecommendationOp(
      request: GetSavingsPlansPurchaseRecommendationRequest
    ) extends CostExplorerOp[GetSavingsPlansPurchaseRecommendationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSavingsPlansPurchaseRecommendationResponse] =
        visitor.getSavingsPlansPurchaseRecommendation(request)
    }

    final case class GetSavingsPlansUtilizationOp(
      request: GetSavingsPlansUtilizationRequest
    ) extends CostExplorerOp[GetSavingsPlansUtilizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSavingsPlansUtilizationResponse] =
        visitor.getSavingsPlansUtilization(request)
    }

    final case class GetSavingsPlansUtilizationDetailsOp(
      request: GetSavingsPlansUtilizationDetailsRequest
    ) extends CostExplorerOp[GetSavingsPlansUtilizationDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSavingsPlansUtilizationDetailsResponse] =
        visitor.getSavingsPlansUtilizationDetails(request)
    }

    final case class GetTagsOp(
      request: GetTagsRequest
    ) extends CostExplorerOp[GetTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagsResponse] =
        visitor.getTags(request)
    }

    final case class GetUsageForecastOp(
      request: GetUsageForecastRequest
    ) extends CostExplorerOp[GetUsageForecastResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUsageForecastResponse] =
        visitor.getUsageForecast(request)
    }

    final case class ListCostCategoryDefinitionsOp(
      request: ListCostCategoryDefinitionsRequest
    ) extends CostExplorerOp[ListCostCategoryDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCostCategoryDefinitionsResponse] =
        visitor.listCostCategoryDefinitions(request)
    }

    final case class ProvideAnomalyFeedbackOp(
      request: ProvideAnomalyFeedbackRequest
    ) extends CostExplorerOp[ProvideAnomalyFeedbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ProvideAnomalyFeedbackResponse] =
        visitor.provideAnomalyFeedback(request)
    }

    final case class UpdateAnomalyMonitorOp(
      request: UpdateAnomalyMonitorRequest
    ) extends CostExplorerOp[UpdateAnomalyMonitorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAnomalyMonitorResponse] =
        visitor.updateAnomalyMonitor(request)
    }

    final case class UpdateAnomalySubscriptionOp(
      request: UpdateAnomalySubscriptionRequest
    ) extends CostExplorerOp[UpdateAnomalySubscriptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAnomalySubscriptionResponse] =
        visitor.updateAnomalySubscription(request)
    }

    final case class UpdateCostCategoryDefinitionOp(
      request: UpdateCostCategoryDefinitionRequest
    ) extends CostExplorerOp[UpdateCostCategoryDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCostCategoryDefinitionResponse] =
        visitor.updateCostCategoryDefinition(request)
    }
  }

  import CostExplorerOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CostExplorerOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createAnomalyMonitor(
    request: CreateAnomalyMonitorRequest
  ): CostExplorerIO[CreateAnomalyMonitorResponse] =
    FF.liftF(CreateAnomalyMonitorOp(request))

  def createAnomalySubscription(
    request: CreateAnomalySubscriptionRequest
  ): CostExplorerIO[CreateAnomalySubscriptionResponse] =
    FF.liftF(CreateAnomalySubscriptionOp(request))

  def createCostCategoryDefinition(
    request: CreateCostCategoryDefinitionRequest
  ): CostExplorerIO[CreateCostCategoryDefinitionResponse] =
    FF.liftF(CreateCostCategoryDefinitionOp(request))

  def deleteAnomalyMonitor(
    request: DeleteAnomalyMonitorRequest
  ): CostExplorerIO[DeleteAnomalyMonitorResponse] =
    FF.liftF(DeleteAnomalyMonitorOp(request))

  def deleteAnomalySubscription(
    request: DeleteAnomalySubscriptionRequest
  ): CostExplorerIO[DeleteAnomalySubscriptionResponse] =
    FF.liftF(DeleteAnomalySubscriptionOp(request))

  def deleteCostCategoryDefinition(
    request: DeleteCostCategoryDefinitionRequest
  ): CostExplorerIO[DeleteCostCategoryDefinitionResponse] =
    FF.liftF(DeleteCostCategoryDefinitionOp(request))

  def describeCostCategoryDefinition(
    request: DescribeCostCategoryDefinitionRequest
  ): CostExplorerIO[DescribeCostCategoryDefinitionResponse] =
    FF.liftF(DescribeCostCategoryDefinitionOp(request))

  def getAnomalies(
    request: GetAnomaliesRequest
  ): CostExplorerIO[GetAnomaliesResponse] =
    FF.liftF(GetAnomaliesOp(request))

  def getAnomalyMonitors(
    request: GetAnomalyMonitorsRequest
  ): CostExplorerIO[GetAnomalyMonitorsResponse] =
    FF.liftF(GetAnomalyMonitorsOp(request))

  def getAnomalySubscriptions(
    request: GetAnomalySubscriptionsRequest
  ): CostExplorerIO[GetAnomalySubscriptionsResponse] =
    FF.liftF(GetAnomalySubscriptionsOp(request))

  def getCostAndUsage(
    request: GetCostAndUsageRequest
  ): CostExplorerIO[GetCostAndUsageResponse] =
    FF.liftF(GetCostAndUsageOp(request))

  def getCostAndUsageWithResources(
    request: GetCostAndUsageWithResourcesRequest
  ): CostExplorerIO[GetCostAndUsageWithResourcesResponse] =
    FF.liftF(GetCostAndUsageWithResourcesOp(request))

  def getCostCategories(
    request: GetCostCategoriesRequest
  ): CostExplorerIO[GetCostCategoriesResponse] =
    FF.liftF(GetCostCategoriesOp(request))

  def getCostForecast(
    request: GetCostForecastRequest
  ): CostExplorerIO[GetCostForecastResponse] =
    FF.liftF(GetCostForecastOp(request))

  def getDimensionValues(
    request: GetDimensionValuesRequest
  ): CostExplorerIO[GetDimensionValuesResponse] =
    FF.liftF(GetDimensionValuesOp(request))

  def getReservationCoverage(
    request: GetReservationCoverageRequest
  ): CostExplorerIO[GetReservationCoverageResponse] =
    FF.liftF(GetReservationCoverageOp(request))

  def getReservationPurchaseRecommendation(
    request: GetReservationPurchaseRecommendationRequest
  ): CostExplorerIO[GetReservationPurchaseRecommendationResponse] =
    FF.liftF(GetReservationPurchaseRecommendationOp(request))

  def getReservationUtilization(
    request: GetReservationUtilizationRequest
  ): CostExplorerIO[GetReservationUtilizationResponse] =
    FF.liftF(GetReservationUtilizationOp(request))

  def getRightsizingRecommendation(
    request: GetRightsizingRecommendationRequest
  ): CostExplorerIO[GetRightsizingRecommendationResponse] =
    FF.liftF(GetRightsizingRecommendationOp(request))

  def getSavingsPlansCoverage(
    request: GetSavingsPlansCoverageRequest
  ): CostExplorerIO[GetSavingsPlansCoverageResponse] =
    FF.liftF(GetSavingsPlansCoverageOp(request))

  def getSavingsPlansPurchaseRecommendation(
    request: GetSavingsPlansPurchaseRecommendationRequest
  ): CostExplorerIO[GetSavingsPlansPurchaseRecommendationResponse] =
    FF.liftF(GetSavingsPlansPurchaseRecommendationOp(request))

  def getSavingsPlansUtilization(
    request: GetSavingsPlansUtilizationRequest
  ): CostExplorerIO[GetSavingsPlansUtilizationResponse] =
    FF.liftF(GetSavingsPlansUtilizationOp(request))

  def getSavingsPlansUtilizationDetails(
    request: GetSavingsPlansUtilizationDetailsRequest
  ): CostExplorerIO[GetSavingsPlansUtilizationDetailsResponse] =
    FF.liftF(GetSavingsPlansUtilizationDetailsOp(request))

  def getTags(
    request: GetTagsRequest
  ): CostExplorerIO[GetTagsResponse] =
    FF.liftF(GetTagsOp(request))

  def getUsageForecast(
    request: GetUsageForecastRequest
  ): CostExplorerIO[GetUsageForecastResponse] =
    FF.liftF(GetUsageForecastOp(request))

  def listCostCategoryDefinitions(
    request: ListCostCategoryDefinitionsRequest
  ): CostExplorerIO[ListCostCategoryDefinitionsResponse] =
    FF.liftF(ListCostCategoryDefinitionsOp(request))

  def provideAnomalyFeedback(
    request: ProvideAnomalyFeedbackRequest
  ): CostExplorerIO[ProvideAnomalyFeedbackResponse] =
    FF.liftF(ProvideAnomalyFeedbackOp(request))

  def updateAnomalyMonitor(
    request: UpdateAnomalyMonitorRequest
  ): CostExplorerIO[UpdateAnomalyMonitorResponse] =
    FF.liftF(UpdateAnomalyMonitorOp(request))

  def updateAnomalySubscription(
    request: UpdateAnomalySubscriptionRequest
  ): CostExplorerIO[UpdateAnomalySubscriptionResponse] =
    FF.liftF(UpdateAnomalySubscriptionOp(request))

  def updateCostCategoryDefinition(
    request: UpdateCostCategoryDefinitionRequest
  ): CostExplorerIO[UpdateCostCategoryDefinitionResponse] =
    FF.liftF(UpdateCostCategoryDefinitionOp(request))
}
