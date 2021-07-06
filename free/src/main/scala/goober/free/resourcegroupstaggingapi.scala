package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.resourcegroupstaggingapi.ResourceGroupsTaggingApiClient
import software.amazon.awssdk.services.resourcegroupstaggingapi.model._


object resourcegroupstaggingapi { module =>

  // Free monad over ResourceGroupsTaggingApiOp
  type ResourceGroupsTaggingApiIO[A] = FF[ResourceGroupsTaggingApiOp, A]

  sealed trait ResourceGroupsTaggingApiOp[A] {
    def visit[F[_]](visitor: ResourceGroupsTaggingApiOp.Visitor[F]): F[A]
  }

  object ResourceGroupsTaggingApiOp {
    // Given a ResourceGroupsTaggingApiClient we can embed a ResourceGroupsTaggingApiIO program in any algebra that understands embedding.
    implicit val ResourceGroupsTaggingApiOpEmbeddable: Embeddable[ResourceGroupsTaggingApiOp, ResourceGroupsTaggingApiClient] = new Embeddable[ResourceGroupsTaggingApiOp, ResourceGroupsTaggingApiClient] {
      def embed[A](client: ResourceGroupsTaggingApiClient, io: ResourceGroupsTaggingApiIO[A]): Embedded[A] = Embedded.ResourceGroupsTaggingApi(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ResourceGroupsTaggingApiOp.Visitor[Kleisli[M, ResourceGroupsTaggingApiClient, *]] {
        def describeReportCreation(
          request: DescribeReportCreationRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, DescribeReportCreationResponse] =
          primitive(_.describeReportCreation(request))

        def getComplianceSummary(
          request: GetComplianceSummaryRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, GetComplianceSummaryResponse] =
          primitive(_.getComplianceSummary(request))

        def getResources(
          request: GetResourcesRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, GetResourcesResponse] =
          primitive(_.getResources(request))

        def getTagKeys(
          request: GetTagKeysRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, GetTagKeysResponse] =
          primitive(_.getTagKeys(request))

        def getTagValues(
          request: GetTagValuesRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, GetTagValuesResponse] =
          primitive(_.getTagValues(request))

        def startReportCreation(
          request: StartReportCreationRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, StartReportCreationResponse] =
          primitive(_.startReportCreation(request))

        def tagResources(
          request: TagResourcesRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, TagResourcesResponse] =
          primitive(_.tagResources(request))

        def untagResources(
          request: UntagResourcesRequest
        ): Kleisli[M, ResourceGroupsTaggingApiClient, UntagResourcesResponse] =
          primitive(_.untagResources(request))

        def primitive[A](
          f: ResourceGroupsTaggingApiClient => A
        ): Kleisli[M, ResourceGroupsTaggingApiClient, A]
      }
    }

    trait Visitor[F[_]] extends (ResourceGroupsTaggingApiOp ~> F) {
      final def apply[A](op: ResourceGroupsTaggingApiOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def describeReportCreation(
        request: DescribeReportCreationRequest
      ): F[DescribeReportCreationResponse]

      def getComplianceSummary(
        request: GetComplianceSummaryRequest
      ): F[GetComplianceSummaryResponse]

      def getResources(
        request: GetResourcesRequest
      ): F[GetResourcesResponse]

      def getTagKeys(
        request: GetTagKeysRequest
      ): F[GetTagKeysResponse]

      def getTagValues(
        request: GetTagValuesRequest
      ): F[GetTagValuesResponse]

      def startReportCreation(
        request: StartReportCreationRequest
      ): F[StartReportCreationResponse]

      def tagResources(
        request: TagResourcesRequest
      ): F[TagResourcesResponse]

      def untagResources(
        request: UntagResourcesRequest
      ): F[UntagResourcesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ResourceGroupsTaggingApiOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class DescribeReportCreationOp(
      request: DescribeReportCreationRequest
    ) extends ResourceGroupsTaggingApiOp[DescribeReportCreationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeReportCreationResponse] =
        visitor.describeReportCreation(request)
    }

    final case class GetComplianceSummaryOp(
      request: GetComplianceSummaryRequest
    ) extends ResourceGroupsTaggingApiOp[GetComplianceSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetComplianceSummaryResponse] =
        visitor.getComplianceSummary(request)
    }

    final case class GetResourcesOp(
      request: GetResourcesRequest
    ) extends ResourceGroupsTaggingApiOp[GetResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcesResponse] =
        visitor.getResources(request)
    }

    final case class GetTagKeysOp(
      request: GetTagKeysRequest
    ) extends ResourceGroupsTaggingApiOp[GetTagKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagKeysResponse] =
        visitor.getTagKeys(request)
    }

    final case class GetTagValuesOp(
      request: GetTagValuesRequest
    ) extends ResourceGroupsTaggingApiOp[GetTagValuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTagValuesResponse] =
        visitor.getTagValues(request)
    }

    final case class StartReportCreationOp(
      request: StartReportCreationRequest
    ) extends ResourceGroupsTaggingApiOp[StartReportCreationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartReportCreationResponse] =
        visitor.startReportCreation(request)
    }

    final case class TagResourcesOp(
      request: TagResourcesRequest
    ) extends ResourceGroupsTaggingApiOp[TagResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourcesResponse] =
        visitor.tagResources(request)
    }

    final case class UntagResourcesOp(
      request: UntagResourcesRequest
    ) extends ResourceGroupsTaggingApiOp[UntagResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourcesResponse] =
        visitor.untagResources(request)
    }
  }

  import ResourceGroupsTaggingApiOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ResourceGroupsTaggingApiOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def describeReportCreation(
    request: DescribeReportCreationRequest
  ): ResourceGroupsTaggingApiIO[DescribeReportCreationResponse] =
    FF.liftF(DescribeReportCreationOp(request))

  def getComplianceSummary(
    request: GetComplianceSummaryRequest
  ): ResourceGroupsTaggingApiIO[GetComplianceSummaryResponse] =
    FF.liftF(GetComplianceSummaryOp(request))

  def getResources(
    request: GetResourcesRequest
  ): ResourceGroupsTaggingApiIO[GetResourcesResponse] =
    FF.liftF(GetResourcesOp(request))

  def getTagKeys(
    request: GetTagKeysRequest
  ): ResourceGroupsTaggingApiIO[GetTagKeysResponse] =
    FF.liftF(GetTagKeysOp(request))

  def getTagValues(
    request: GetTagValuesRequest
  ): ResourceGroupsTaggingApiIO[GetTagValuesResponse] =
    FF.liftF(GetTagValuesOp(request))

  def startReportCreation(
    request: StartReportCreationRequest
  ): ResourceGroupsTaggingApiIO[StartReportCreationResponse] =
    FF.liftF(StartReportCreationOp(request))

  def tagResources(
    request: TagResourcesRequest
  ): ResourceGroupsTaggingApiIO[TagResourcesResponse] =
    FF.liftF(TagResourcesOp(request))

  def untagResources(
    request: UntagResourcesRequest
  ): ResourceGroupsTaggingApiIO[UntagResourcesResponse] =
    FF.liftF(UntagResourcesOp(request))
}
