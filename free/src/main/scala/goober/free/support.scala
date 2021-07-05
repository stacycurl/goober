package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.support.SupportClient
import software.amazon.awssdk.services.support.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object support { module =>

  // Free monad over SupportOp
  type SupportIO[A] = FF[SupportOp, A]

  sealed trait SupportOp[A] {
    def visit[F[_]](visitor: SupportOp.Visitor[F]): F[A]
  }

  object SupportOp {
    // Given a SupportClient we can embed a SupportIO program in any algebra that understands embedding.
    implicit val SupportOpEmbeddable: Embeddable[SupportOp, SupportClient] = new Embeddable[SupportOp, SupportClient] {
      def embed[A](client: SupportClient, io: SupportIO[A]): Embedded[A] = Embedded.Support(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends SupportOp.Visitor[Kleisli[M, SupportClient, *]] {
        def addAttachmentsToSet(
          request: AddAttachmentsToSetRequest
        ): Kleisli[M, SupportClient, AddAttachmentsToSetResponse] =
          primitive(_.addAttachmentsToSet(request))

        def addCommunicationToCase(
          request: AddCommunicationToCaseRequest
        ): Kleisli[M, SupportClient, AddCommunicationToCaseResponse] =
          primitive(_.addCommunicationToCase(request))

        def createCase(
          request: CreateCaseRequest
        ): Kleisli[M, SupportClient, CreateCaseResponse] =
          primitive(_.createCase(request))

        def describeAttachment(
          request: DescribeAttachmentRequest
        ): Kleisli[M, SupportClient, DescribeAttachmentResponse] =
          primitive(_.describeAttachment(request))

        def describeCases(
          request: DescribeCasesRequest
        ): Kleisli[M, SupportClient, DescribeCasesResponse] =
          primitive(_.describeCases(request))

        def describeCommunications(
          request: DescribeCommunicationsRequest
        ): Kleisli[M, SupportClient, DescribeCommunicationsResponse] =
          primitive(_.describeCommunications(request))

        def describeServices(
          request: DescribeServicesRequest
        ): Kleisli[M, SupportClient, DescribeServicesResponse] =
          primitive(_.describeServices(request))

        def describeSeverityLevels(
          request: DescribeSeverityLevelsRequest
        ): Kleisli[M, SupportClient, DescribeSeverityLevelsResponse] =
          primitive(_.describeSeverityLevels(request))

        def describeTrustedAdvisorCheckRefreshStatuses(
          request: DescribeTrustedAdvisorCheckRefreshStatusesRequest
        ): Kleisli[M, SupportClient, DescribeTrustedAdvisorCheckRefreshStatusesResponse] =
          primitive(_.describeTrustedAdvisorCheckRefreshStatuses(request))

        def describeTrustedAdvisorCheckResult(
          request: DescribeTrustedAdvisorCheckResultRequest
        ): Kleisli[M, SupportClient, DescribeTrustedAdvisorCheckResultResponse] =
          primitive(_.describeTrustedAdvisorCheckResult(request))

        def describeTrustedAdvisorCheckSummaries(
          request: DescribeTrustedAdvisorCheckSummariesRequest
        ): Kleisli[M, SupportClient, DescribeTrustedAdvisorCheckSummariesResponse] =
          primitive(_.describeTrustedAdvisorCheckSummaries(request))

        def describeTrustedAdvisorChecks(
          request: DescribeTrustedAdvisorChecksRequest
        ): Kleisli[M, SupportClient, DescribeTrustedAdvisorChecksResponse] =
          primitive(_.describeTrustedAdvisorChecks(request))

        def refreshTrustedAdvisorCheck(
          request: RefreshTrustedAdvisorCheckRequest
        ): Kleisli[M, SupportClient, RefreshTrustedAdvisorCheckResponse] =
          primitive(_.refreshTrustedAdvisorCheck(request))

        def resolveCase(
          request: ResolveCaseRequest
        ): Kleisli[M, SupportClient, ResolveCaseResponse] =
          primitive(_.resolveCase(request))

        def primitive[A](
          f: SupportClient => A
        ): Kleisli[M, SupportClient, A]
      }
    }

    trait Visitor[F[_]] extends (SupportOp ~> F) {
      final def apply[A](op: SupportOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addAttachmentsToSet(
        request: AddAttachmentsToSetRequest
      ): F[AddAttachmentsToSetResponse]

      def addCommunicationToCase(
        request: AddCommunicationToCaseRequest
      ): F[AddCommunicationToCaseResponse]

      def createCase(
        request: CreateCaseRequest
      ): F[CreateCaseResponse]

      def describeAttachment(
        request: DescribeAttachmentRequest
      ): F[DescribeAttachmentResponse]

      def describeCases(
        request: DescribeCasesRequest
      ): F[DescribeCasesResponse]

      def describeCommunications(
        request: DescribeCommunicationsRequest
      ): F[DescribeCommunicationsResponse]

      def describeServices(
        request: DescribeServicesRequest
      ): F[DescribeServicesResponse]

      def describeSeverityLevels(
        request: DescribeSeverityLevelsRequest
      ): F[DescribeSeverityLevelsResponse]

      def describeTrustedAdvisorCheckRefreshStatuses(
        request: DescribeTrustedAdvisorCheckRefreshStatusesRequest
      ): F[DescribeTrustedAdvisorCheckRefreshStatusesResponse]

      def describeTrustedAdvisorCheckResult(
        request: DescribeTrustedAdvisorCheckResultRequest
      ): F[DescribeTrustedAdvisorCheckResultResponse]

      def describeTrustedAdvisorCheckSummaries(
        request: DescribeTrustedAdvisorCheckSummariesRequest
      ): F[DescribeTrustedAdvisorCheckSummariesResponse]

      def describeTrustedAdvisorChecks(
        request: DescribeTrustedAdvisorChecksRequest
      ): F[DescribeTrustedAdvisorChecksResponse]

      def refreshTrustedAdvisorCheck(
        request: RefreshTrustedAdvisorCheckRequest
      ): F[RefreshTrustedAdvisorCheckResponse]

      def resolveCase(
        request: ResolveCaseRequest
      ): F[ResolveCaseResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends SupportOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddAttachmentsToSetOp(
      request: AddAttachmentsToSetRequest
    ) extends SupportOp[AddAttachmentsToSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddAttachmentsToSetResponse] =
        visitor.addAttachmentsToSet(request)
    }

    final case class AddCommunicationToCaseOp(
      request: AddCommunicationToCaseRequest
    ) extends SupportOp[AddCommunicationToCaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddCommunicationToCaseResponse] =
        visitor.addCommunicationToCase(request)
    }

    final case class CreateCaseOp(
      request: CreateCaseRequest
    ) extends SupportOp[CreateCaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCaseResponse] =
        visitor.createCase(request)
    }

    final case class DescribeAttachmentOp(
      request: DescribeAttachmentRequest
    ) extends SupportOp[DescribeAttachmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAttachmentResponse] =
        visitor.describeAttachment(request)
    }

    final case class DescribeCasesOp(
      request: DescribeCasesRequest
    ) extends SupportOp[DescribeCasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCasesResponse] =
        visitor.describeCases(request)
    }

    final case class DescribeCommunicationsOp(
      request: DescribeCommunicationsRequest
    ) extends SupportOp[DescribeCommunicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCommunicationsResponse] =
        visitor.describeCommunications(request)
    }

    final case class DescribeServicesOp(
      request: DescribeServicesRequest
    ) extends SupportOp[DescribeServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServicesResponse] =
        visitor.describeServices(request)
    }

    final case class DescribeSeverityLevelsOp(
      request: DescribeSeverityLevelsRequest
    ) extends SupportOp[DescribeSeverityLevelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSeverityLevelsResponse] =
        visitor.describeSeverityLevels(request)
    }

    final case class DescribeTrustedAdvisorCheckRefreshStatusesOp(
      request: DescribeTrustedAdvisorCheckRefreshStatusesRequest
    ) extends SupportOp[DescribeTrustedAdvisorCheckRefreshStatusesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrustedAdvisorCheckRefreshStatusesResponse] =
        visitor.describeTrustedAdvisorCheckRefreshStatuses(request)
    }

    final case class DescribeTrustedAdvisorCheckResultOp(
      request: DescribeTrustedAdvisorCheckResultRequest
    ) extends SupportOp[DescribeTrustedAdvisorCheckResultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrustedAdvisorCheckResultResponse] =
        visitor.describeTrustedAdvisorCheckResult(request)
    }

    final case class DescribeTrustedAdvisorCheckSummariesOp(
      request: DescribeTrustedAdvisorCheckSummariesRequest
    ) extends SupportOp[DescribeTrustedAdvisorCheckSummariesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrustedAdvisorCheckSummariesResponse] =
        visitor.describeTrustedAdvisorCheckSummaries(request)
    }

    final case class DescribeTrustedAdvisorChecksOp(
      request: DescribeTrustedAdvisorChecksRequest
    ) extends SupportOp[DescribeTrustedAdvisorChecksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTrustedAdvisorChecksResponse] =
        visitor.describeTrustedAdvisorChecks(request)
    }

    final case class RefreshTrustedAdvisorCheckOp(
      request: RefreshTrustedAdvisorCheckRequest
    ) extends SupportOp[RefreshTrustedAdvisorCheckResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RefreshTrustedAdvisorCheckResponse] =
        visitor.refreshTrustedAdvisorCheck(request)
    }

    final case class ResolveCaseOp(
      request: ResolveCaseRequest
    ) extends SupportOp[ResolveCaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResolveCaseResponse] =
        visitor.resolveCase(request)
    }
  }

  import SupportOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[SupportOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addAttachmentsToSet(
    request: AddAttachmentsToSetRequest
  ): SupportIO[AddAttachmentsToSetResponse] =
    FF.liftF(AddAttachmentsToSetOp(request))

  def addCommunicationToCase(
    request: AddCommunicationToCaseRequest
  ): SupportIO[AddCommunicationToCaseResponse] =
    FF.liftF(AddCommunicationToCaseOp(request))

  def createCase(
    request: CreateCaseRequest
  ): SupportIO[CreateCaseResponse] =
    FF.liftF(CreateCaseOp(request))

  def describeAttachment(
    request: DescribeAttachmentRequest
  ): SupportIO[DescribeAttachmentResponse] =
    FF.liftF(DescribeAttachmentOp(request))

  def describeCases(
    request: DescribeCasesRequest
  ): SupportIO[DescribeCasesResponse] =
    FF.liftF(DescribeCasesOp(request))

  def describeCommunications(
    request: DescribeCommunicationsRequest
  ): SupportIO[DescribeCommunicationsResponse] =
    FF.liftF(DescribeCommunicationsOp(request))

  def describeServices(
    request: DescribeServicesRequest
  ): SupportIO[DescribeServicesResponse] =
    FF.liftF(DescribeServicesOp(request))

  def describeSeverityLevels(
    request: DescribeSeverityLevelsRequest
  ): SupportIO[DescribeSeverityLevelsResponse] =
    FF.liftF(DescribeSeverityLevelsOp(request))

  def describeTrustedAdvisorCheckRefreshStatuses(
    request: DescribeTrustedAdvisorCheckRefreshStatusesRequest
  ): SupportIO[DescribeTrustedAdvisorCheckRefreshStatusesResponse] =
    FF.liftF(DescribeTrustedAdvisorCheckRefreshStatusesOp(request))

  def describeTrustedAdvisorCheckResult(
    request: DescribeTrustedAdvisorCheckResultRequest
  ): SupportIO[DescribeTrustedAdvisorCheckResultResponse] =
    FF.liftF(DescribeTrustedAdvisorCheckResultOp(request))

  def describeTrustedAdvisorCheckSummaries(
    request: DescribeTrustedAdvisorCheckSummariesRequest
  ): SupportIO[DescribeTrustedAdvisorCheckSummariesResponse] =
    FF.liftF(DescribeTrustedAdvisorCheckSummariesOp(request))

  def describeTrustedAdvisorChecks(
    request: DescribeTrustedAdvisorChecksRequest
  ): SupportIO[DescribeTrustedAdvisorChecksResponse] =
    FF.liftF(DescribeTrustedAdvisorChecksOp(request))

  def refreshTrustedAdvisorCheck(
    request: RefreshTrustedAdvisorCheckRequest
  ): SupportIO[RefreshTrustedAdvisorCheckResponse] =
    FF.liftF(RefreshTrustedAdvisorCheckOp(request))

  def resolveCase(
    request: ResolveCaseRequest
  ): SupportIO[ResolveCaseResponse] =
    FF.liftF(ResolveCaseOp(request))
}
