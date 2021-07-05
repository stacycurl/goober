package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.applicationinsights.ApplicationInsightsClient
import software.amazon.awssdk.services.applicationinsights.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object applicationinsights { module =>

  // Free monad over ApplicationInsightsOp
  type ApplicationInsightsIO[A] = FF[ApplicationInsightsOp, A]

  sealed trait ApplicationInsightsOp[A] {
    def visit[F[_]](visitor: ApplicationInsightsOp.Visitor[F]): F[A]
  }

  object ApplicationInsightsOp {
    // Given a ApplicationInsightsClient we can embed a ApplicationInsightsIO program in any algebra that understands embedding.
    implicit val ApplicationInsightsOpEmbeddable: Embeddable[ApplicationInsightsOp, ApplicationInsightsClient] = new Embeddable[ApplicationInsightsOp, ApplicationInsightsClient] {
      def embed[A](client: ApplicationInsightsClient, io: ApplicationInsightsIO[A]): Embedded[A] = Embedded.ApplicationInsights(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ApplicationInsightsOp.Visitor[Kleisli[M, ApplicationInsightsClient, *]] {
        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, ApplicationInsightsClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createComponent(
          request: CreateComponentRequest
        ): Kleisli[M, ApplicationInsightsClient, CreateComponentResponse] =
          primitive(_.createComponent(request))

        def createLogPattern(
          request: CreateLogPatternRequest
        ): Kleisli[M, ApplicationInsightsClient, CreateLogPatternResponse] =
          primitive(_.createLogPattern(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, ApplicationInsightsClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteComponent(
          request: DeleteComponentRequest
        ): Kleisli[M, ApplicationInsightsClient, DeleteComponentResponse] =
          primitive(_.deleteComponent(request))

        def deleteLogPattern(
          request: DeleteLogPatternRequest
        ): Kleisli[M, ApplicationInsightsClient, DeleteLogPatternResponse] =
          primitive(_.deleteLogPattern(request))

        def describeApplication(
          request: DescribeApplicationRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeApplicationResponse] =
          primitive(_.describeApplication(request))

        def describeComponent(
          request: DescribeComponentRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeComponentResponse] =
          primitive(_.describeComponent(request))

        def describeComponentConfiguration(
          request: DescribeComponentConfigurationRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeComponentConfigurationResponse] =
          primitive(_.describeComponentConfiguration(request))

        def describeComponentConfigurationRecommendation(
          request: DescribeComponentConfigurationRecommendationRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeComponentConfigurationRecommendationResponse] =
          primitive(_.describeComponentConfigurationRecommendation(request))

        def describeLogPattern(
          request: DescribeLogPatternRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeLogPatternResponse] =
          primitive(_.describeLogPattern(request))

        def describeObservation(
          request: DescribeObservationRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeObservationResponse] =
          primitive(_.describeObservation(request))

        def describeProblem(
          request: DescribeProblemRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeProblemResponse] =
          primitive(_.describeProblem(request))

        def describeProblemObservations(
          request: DescribeProblemObservationsRequest
        ): Kleisli[M, ApplicationInsightsClient, DescribeProblemObservationsResponse] =
          primitive(_.describeProblemObservations(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, ApplicationInsightsClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listComponents(
          request: ListComponentsRequest
        ): Kleisli[M, ApplicationInsightsClient, ListComponentsResponse] =
          primitive(_.listComponents(request))

        def listConfigurationHistory(
          request: ListConfigurationHistoryRequest
        ): Kleisli[M, ApplicationInsightsClient, ListConfigurationHistoryResponse] =
          primitive(_.listConfigurationHistory(request))

        def listLogPatternSets(
          request: ListLogPatternSetsRequest
        ): Kleisli[M, ApplicationInsightsClient, ListLogPatternSetsResponse] =
          primitive(_.listLogPatternSets(request))

        def listLogPatterns(
          request: ListLogPatternsRequest
        ): Kleisli[M, ApplicationInsightsClient, ListLogPatternsResponse] =
          primitive(_.listLogPatterns(request))

        def listProblems(
          request: ListProblemsRequest
        ): Kleisli[M, ApplicationInsightsClient, ListProblemsResponse] =
          primitive(_.listProblems(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ApplicationInsightsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ApplicationInsightsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ApplicationInsightsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, ApplicationInsightsClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def updateComponent(
          request: UpdateComponentRequest
        ): Kleisli[M, ApplicationInsightsClient, UpdateComponentResponse] =
          primitive(_.updateComponent(request))

        def updateComponentConfiguration(
          request: UpdateComponentConfigurationRequest
        ): Kleisli[M, ApplicationInsightsClient, UpdateComponentConfigurationResponse] =
          primitive(_.updateComponentConfiguration(request))

        def updateLogPattern(
          request: UpdateLogPatternRequest
        ): Kleisli[M, ApplicationInsightsClient, UpdateLogPatternResponse] =
          primitive(_.updateLogPattern(request))

        def primitive[A](
          f: ApplicationInsightsClient => A
        ): Kleisli[M, ApplicationInsightsClient, A]
      }
    }

    trait Visitor[F[_]] extends (ApplicationInsightsOp ~> F) {
      final def apply[A](op: ApplicationInsightsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createComponent(
        request: CreateComponentRequest
      ): F[CreateComponentResponse]

      def createLogPattern(
        request: CreateLogPatternRequest
      ): F[CreateLogPatternResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def deleteComponent(
        request: DeleteComponentRequest
      ): F[DeleteComponentResponse]

      def deleteLogPattern(
        request: DeleteLogPatternRequest
      ): F[DeleteLogPatternResponse]

      def describeApplication(
        request: DescribeApplicationRequest
      ): F[DescribeApplicationResponse]

      def describeComponent(
        request: DescribeComponentRequest
      ): F[DescribeComponentResponse]

      def describeComponentConfiguration(
        request: DescribeComponentConfigurationRequest
      ): F[DescribeComponentConfigurationResponse]

      def describeComponentConfigurationRecommendation(
        request: DescribeComponentConfigurationRecommendationRequest
      ): F[DescribeComponentConfigurationRecommendationResponse]

      def describeLogPattern(
        request: DescribeLogPatternRequest
      ): F[DescribeLogPatternResponse]

      def describeObservation(
        request: DescribeObservationRequest
      ): F[DescribeObservationResponse]

      def describeProblem(
        request: DescribeProblemRequest
      ): F[DescribeProblemResponse]

      def describeProblemObservations(
        request: DescribeProblemObservationsRequest
      ): F[DescribeProblemObservationsResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listComponents(
        request: ListComponentsRequest
      ): F[ListComponentsResponse]

      def listConfigurationHistory(
        request: ListConfigurationHistoryRequest
      ): F[ListConfigurationHistoryResponse]

      def listLogPatternSets(
        request: ListLogPatternSetsRequest
      ): F[ListLogPatternSetsResponse]

      def listLogPatterns(
        request: ListLogPatternsRequest
      ): F[ListLogPatternsResponse]

      def listProblems(
        request: ListProblemsRequest
      ): F[ListProblemsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]

      def updateComponent(
        request: UpdateComponentRequest
      ): F[UpdateComponentResponse]

      def updateComponentConfiguration(
        request: UpdateComponentConfigurationRequest
      ): F[UpdateComponentConfigurationResponse]

      def updateLogPattern(
        request: UpdateLogPatternRequest
      ): F[UpdateLogPatternResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ApplicationInsightsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends ApplicationInsightsOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateComponentOp(
      request: CreateComponentRequest
    ) extends ApplicationInsightsOp[CreateComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateComponentResponse] =
        visitor.createComponent(request)
    }

    final case class CreateLogPatternOp(
      request: CreateLogPatternRequest
    ) extends ApplicationInsightsOp[CreateLogPatternResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLogPatternResponse] =
        visitor.createLogPattern(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends ApplicationInsightsOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteComponentOp(
      request: DeleteComponentRequest
    ) extends ApplicationInsightsOp[DeleteComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteComponentResponse] =
        visitor.deleteComponent(request)
    }

    final case class DeleteLogPatternOp(
      request: DeleteLogPatternRequest
    ) extends ApplicationInsightsOp[DeleteLogPatternResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLogPatternResponse] =
        visitor.deleteLogPattern(request)
    }

    final case class DescribeApplicationOp(
      request: DescribeApplicationRequest
    ) extends ApplicationInsightsOp[DescribeApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeApplicationResponse] =
        visitor.describeApplication(request)
    }

    final case class DescribeComponentOp(
      request: DescribeComponentRequest
    ) extends ApplicationInsightsOp[DescribeComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComponentResponse] =
        visitor.describeComponent(request)
    }

    final case class DescribeComponentConfigurationOp(
      request: DescribeComponentConfigurationRequest
    ) extends ApplicationInsightsOp[DescribeComponentConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComponentConfigurationResponse] =
        visitor.describeComponentConfiguration(request)
    }

    final case class DescribeComponentConfigurationRecommendationOp(
      request: DescribeComponentConfigurationRecommendationRequest
    ) extends ApplicationInsightsOp[DescribeComponentConfigurationRecommendationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeComponentConfigurationRecommendationResponse] =
        visitor.describeComponentConfigurationRecommendation(request)
    }

    final case class DescribeLogPatternOp(
      request: DescribeLogPatternRequest
    ) extends ApplicationInsightsOp[DescribeLogPatternResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLogPatternResponse] =
        visitor.describeLogPattern(request)
    }

    final case class DescribeObservationOp(
      request: DescribeObservationRequest
    ) extends ApplicationInsightsOp[DescribeObservationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeObservationResponse] =
        visitor.describeObservation(request)
    }

    final case class DescribeProblemOp(
      request: DescribeProblemRequest
    ) extends ApplicationInsightsOp[DescribeProblemResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProblemResponse] =
        visitor.describeProblem(request)
    }

    final case class DescribeProblemObservationsOp(
      request: DescribeProblemObservationsRequest
    ) extends ApplicationInsightsOp[DescribeProblemObservationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProblemObservationsResponse] =
        visitor.describeProblemObservations(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends ApplicationInsightsOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListComponentsOp(
      request: ListComponentsRequest
    ) extends ApplicationInsightsOp[ListComponentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListComponentsResponse] =
        visitor.listComponents(request)
    }

    final case class ListConfigurationHistoryOp(
      request: ListConfigurationHistoryRequest
    ) extends ApplicationInsightsOp[ListConfigurationHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConfigurationHistoryResponse] =
        visitor.listConfigurationHistory(request)
    }

    final case class ListLogPatternSetsOp(
      request: ListLogPatternSetsRequest
    ) extends ApplicationInsightsOp[ListLogPatternSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLogPatternSetsResponse] =
        visitor.listLogPatternSets(request)
    }

    final case class ListLogPatternsOp(
      request: ListLogPatternsRequest
    ) extends ApplicationInsightsOp[ListLogPatternsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLogPatternsResponse] =
        visitor.listLogPatterns(request)
    }

    final case class ListProblemsOp(
      request: ListProblemsRequest
    ) extends ApplicationInsightsOp[ListProblemsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProblemsResponse] =
        visitor.listProblems(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ApplicationInsightsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ApplicationInsightsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ApplicationInsightsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends ApplicationInsightsOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }

    final case class UpdateComponentOp(
      request: UpdateComponentRequest
    ) extends ApplicationInsightsOp[UpdateComponentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateComponentResponse] =
        visitor.updateComponent(request)
    }

    final case class UpdateComponentConfigurationOp(
      request: UpdateComponentConfigurationRequest
    ) extends ApplicationInsightsOp[UpdateComponentConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateComponentConfigurationResponse] =
        visitor.updateComponentConfiguration(request)
    }

    final case class UpdateLogPatternOp(
      request: UpdateLogPatternRequest
    ) extends ApplicationInsightsOp[UpdateLogPatternResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLogPatternResponse] =
        visitor.updateLogPattern(request)
    }
  }

  import ApplicationInsightsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ApplicationInsightsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createApplication(
    request: CreateApplicationRequest
  ): ApplicationInsightsIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createComponent(
    request: CreateComponentRequest
  ): ApplicationInsightsIO[CreateComponentResponse] =
    FF.liftF(CreateComponentOp(request))

  def createLogPattern(
    request: CreateLogPatternRequest
  ): ApplicationInsightsIO[CreateLogPatternResponse] =
    FF.liftF(CreateLogPatternOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): ApplicationInsightsIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteComponent(
    request: DeleteComponentRequest
  ): ApplicationInsightsIO[DeleteComponentResponse] =
    FF.liftF(DeleteComponentOp(request))

  def deleteLogPattern(
    request: DeleteLogPatternRequest
  ): ApplicationInsightsIO[DeleteLogPatternResponse] =
    FF.liftF(DeleteLogPatternOp(request))

  def describeApplication(
    request: DescribeApplicationRequest
  ): ApplicationInsightsIO[DescribeApplicationResponse] =
    FF.liftF(DescribeApplicationOp(request))

  def describeComponent(
    request: DescribeComponentRequest
  ): ApplicationInsightsIO[DescribeComponentResponse] =
    FF.liftF(DescribeComponentOp(request))

  def describeComponentConfiguration(
    request: DescribeComponentConfigurationRequest
  ): ApplicationInsightsIO[DescribeComponentConfigurationResponse] =
    FF.liftF(DescribeComponentConfigurationOp(request))

  def describeComponentConfigurationRecommendation(
    request: DescribeComponentConfigurationRecommendationRequest
  ): ApplicationInsightsIO[DescribeComponentConfigurationRecommendationResponse] =
    FF.liftF(DescribeComponentConfigurationRecommendationOp(request))

  def describeLogPattern(
    request: DescribeLogPatternRequest
  ): ApplicationInsightsIO[DescribeLogPatternResponse] =
    FF.liftF(DescribeLogPatternOp(request))

  def describeObservation(
    request: DescribeObservationRequest
  ): ApplicationInsightsIO[DescribeObservationResponse] =
    FF.liftF(DescribeObservationOp(request))

  def describeProblem(
    request: DescribeProblemRequest
  ): ApplicationInsightsIO[DescribeProblemResponse] =
    FF.liftF(DescribeProblemOp(request))

  def describeProblemObservations(
    request: DescribeProblemObservationsRequest
  ): ApplicationInsightsIO[DescribeProblemObservationsResponse] =
    FF.liftF(DescribeProblemObservationsOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): ApplicationInsightsIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listComponents(
    request: ListComponentsRequest
  ): ApplicationInsightsIO[ListComponentsResponse] =
    FF.liftF(ListComponentsOp(request))

  def listConfigurationHistory(
    request: ListConfigurationHistoryRequest
  ): ApplicationInsightsIO[ListConfigurationHistoryResponse] =
    FF.liftF(ListConfigurationHistoryOp(request))

  def listLogPatternSets(
    request: ListLogPatternSetsRequest
  ): ApplicationInsightsIO[ListLogPatternSetsResponse] =
    FF.liftF(ListLogPatternSetsOp(request))

  def listLogPatterns(
    request: ListLogPatternsRequest
  ): ApplicationInsightsIO[ListLogPatternsResponse] =
    FF.liftF(ListLogPatternsOp(request))

  def listProblems(
    request: ListProblemsRequest
  ): ApplicationInsightsIO[ListProblemsResponse] =
    FF.liftF(ListProblemsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ApplicationInsightsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ApplicationInsightsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ApplicationInsightsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): ApplicationInsightsIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))

  def updateComponent(
    request: UpdateComponentRequest
  ): ApplicationInsightsIO[UpdateComponentResponse] =
    FF.liftF(UpdateComponentOp(request))

  def updateComponentConfiguration(
    request: UpdateComponentConfigurationRequest
  ): ApplicationInsightsIO[UpdateComponentConfigurationResponse] =
    FF.liftF(UpdateComponentConfigurationOp(request))

  def updateLogPattern(
    request: UpdateLogPatternRequest
  ): ApplicationInsightsIO[UpdateLogPatternResponse] =
    FF.liftF(UpdateLogPatternOp(request))
}
