package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.inspector.InspectorClient
import software.amazon.awssdk.services.inspector.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object inspector { module =>

  // Free monad over InspectorOp
  type InspectorIO[A] = FF[InspectorOp, A]

  sealed trait InspectorOp[A] {
    def visit[F[_]](visitor: InspectorOp.Visitor[F]): F[A]
  }

  object InspectorOp {
    // Given a InspectorClient we can embed a InspectorIO program in any algebra that understands embedding.
    implicit val InspectorOpEmbeddable: Embeddable[InspectorOp, InspectorClient] = new Embeddable[InspectorOp, InspectorClient] {
      def embed[A](client: InspectorClient, io: InspectorIO[A]): Embedded[A] = Embedded.Inspector(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends InspectorOp.Visitor[Kleisli[M, InspectorClient, *]] {
        def addAttributesToFindings(
          request: AddAttributesToFindingsRequest
        ): Kleisli[M, InspectorClient, AddAttributesToFindingsResponse] =
          primitive(_.addAttributesToFindings(request))

        def createAssessmentTarget(
          request: CreateAssessmentTargetRequest
        ): Kleisli[M, InspectorClient, CreateAssessmentTargetResponse] =
          primitive(_.createAssessmentTarget(request))

        def createAssessmentTemplate(
          request: CreateAssessmentTemplateRequest
        ): Kleisli[M, InspectorClient, CreateAssessmentTemplateResponse] =
          primitive(_.createAssessmentTemplate(request))

        def createExclusionsPreview(
          request: CreateExclusionsPreviewRequest
        ): Kleisli[M, InspectorClient, CreateExclusionsPreviewResponse] =
          primitive(_.createExclusionsPreview(request))

        def createResourceGroup(
          request: CreateResourceGroupRequest
        ): Kleisli[M, InspectorClient, CreateResourceGroupResponse] =
          primitive(_.createResourceGroup(request))

        def deleteAssessmentRun(
          request: DeleteAssessmentRunRequest
        ): Kleisli[M, InspectorClient, DeleteAssessmentRunResponse] =
          primitive(_.deleteAssessmentRun(request))

        def deleteAssessmentTarget(
          request: DeleteAssessmentTargetRequest
        ): Kleisli[M, InspectorClient, DeleteAssessmentTargetResponse] =
          primitive(_.deleteAssessmentTarget(request))

        def deleteAssessmentTemplate(
          request: DeleteAssessmentTemplateRequest
        ): Kleisli[M, InspectorClient, DeleteAssessmentTemplateResponse] =
          primitive(_.deleteAssessmentTemplate(request))

        def describeAssessmentRuns(
          request: DescribeAssessmentRunsRequest
        ): Kleisli[M, InspectorClient, DescribeAssessmentRunsResponse] =
          primitive(_.describeAssessmentRuns(request))

        def describeAssessmentTargets(
          request: DescribeAssessmentTargetsRequest
        ): Kleisli[M, InspectorClient, DescribeAssessmentTargetsResponse] =
          primitive(_.describeAssessmentTargets(request))

        def describeAssessmentTemplates(
          request: DescribeAssessmentTemplatesRequest
        ): Kleisli[M, InspectorClient, DescribeAssessmentTemplatesResponse] =
          primitive(_.describeAssessmentTemplates(request))

        def describeCrossAccountAccessRole(
          request: DescribeCrossAccountAccessRoleRequest
        ): Kleisli[M, InspectorClient, DescribeCrossAccountAccessRoleResponse] =
          primitive(_.describeCrossAccountAccessRole(request))

        def describeExclusions(
          request: DescribeExclusionsRequest
        ): Kleisli[M, InspectorClient, DescribeExclusionsResponse] =
          primitive(_.describeExclusions(request))

        def describeFindings(
          request: DescribeFindingsRequest
        ): Kleisli[M, InspectorClient, DescribeFindingsResponse] =
          primitive(_.describeFindings(request))

        def describeResourceGroups(
          request: DescribeResourceGroupsRequest
        ): Kleisli[M, InspectorClient, DescribeResourceGroupsResponse] =
          primitive(_.describeResourceGroups(request))

        def describeRulesPackages(
          request: DescribeRulesPackagesRequest
        ): Kleisli[M, InspectorClient, DescribeRulesPackagesResponse] =
          primitive(_.describeRulesPackages(request))

        def getAssessmentReport(
          request: GetAssessmentReportRequest
        ): Kleisli[M, InspectorClient, GetAssessmentReportResponse] =
          primitive(_.getAssessmentReport(request))

        def getExclusionsPreview(
          request: GetExclusionsPreviewRequest
        ): Kleisli[M, InspectorClient, GetExclusionsPreviewResponse] =
          primitive(_.getExclusionsPreview(request))

        def getTelemetryMetadata(
          request: GetTelemetryMetadataRequest
        ): Kleisli[M, InspectorClient, GetTelemetryMetadataResponse] =
          primitive(_.getTelemetryMetadata(request))

        def listAssessmentRunAgents(
          request: ListAssessmentRunAgentsRequest
        ): Kleisli[M, InspectorClient, ListAssessmentRunAgentsResponse] =
          primitive(_.listAssessmentRunAgents(request))

        def listAssessmentRuns(
          request: ListAssessmentRunsRequest
        ): Kleisli[M, InspectorClient, ListAssessmentRunsResponse] =
          primitive(_.listAssessmentRuns(request))

        def listAssessmentTargets(
          request: ListAssessmentTargetsRequest
        ): Kleisli[M, InspectorClient, ListAssessmentTargetsResponse] =
          primitive(_.listAssessmentTargets(request))

        def listAssessmentTemplates(
          request: ListAssessmentTemplatesRequest
        ): Kleisli[M, InspectorClient, ListAssessmentTemplatesResponse] =
          primitive(_.listAssessmentTemplates(request))

        def listEventSubscriptions(
          request: ListEventSubscriptionsRequest
        ): Kleisli[M, InspectorClient, ListEventSubscriptionsResponse] =
          primitive(_.listEventSubscriptions(request))

        def listExclusions(
          request: ListExclusionsRequest
        ): Kleisli[M, InspectorClient, ListExclusionsResponse] =
          primitive(_.listExclusions(request))

        def listFindings(
          request: ListFindingsRequest
        ): Kleisli[M, InspectorClient, ListFindingsResponse] =
          primitive(_.listFindings(request))

        def listRulesPackages(
          request: ListRulesPackagesRequest
        ): Kleisli[M, InspectorClient, ListRulesPackagesResponse] =
          primitive(_.listRulesPackages(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, InspectorClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def previewAgents(
          request: PreviewAgentsRequest
        ): Kleisli[M, InspectorClient, PreviewAgentsResponse] =
          primitive(_.previewAgents(request))

        def registerCrossAccountAccessRole(
          request: RegisterCrossAccountAccessRoleRequest
        ): Kleisli[M, InspectorClient, RegisterCrossAccountAccessRoleResponse] =
          primitive(_.registerCrossAccountAccessRole(request))

        def removeAttributesFromFindings(
          request: RemoveAttributesFromFindingsRequest
        ): Kleisli[M, InspectorClient, RemoveAttributesFromFindingsResponse] =
          primitive(_.removeAttributesFromFindings(request))

        def setTagsForResource(
          request: SetTagsForResourceRequest
        ): Kleisli[M, InspectorClient, SetTagsForResourceResponse] =
          primitive(_.setTagsForResource(request))

        def startAssessmentRun(
          request: StartAssessmentRunRequest
        ): Kleisli[M, InspectorClient, StartAssessmentRunResponse] =
          primitive(_.startAssessmentRun(request))

        def stopAssessmentRun(
          request: StopAssessmentRunRequest
        ): Kleisli[M, InspectorClient, StopAssessmentRunResponse] =
          primitive(_.stopAssessmentRun(request))

        def subscribeToEvent(
          request: SubscribeToEventRequest
        ): Kleisli[M, InspectorClient, SubscribeToEventResponse] =
          primitive(_.subscribeToEvent(request))

        def unsubscribeFromEvent(
          request: UnsubscribeFromEventRequest
        ): Kleisli[M, InspectorClient, UnsubscribeFromEventResponse] =
          primitive(_.unsubscribeFromEvent(request))

        def updateAssessmentTarget(
          request: UpdateAssessmentTargetRequest
        ): Kleisli[M, InspectorClient, UpdateAssessmentTargetResponse] =
          primitive(_.updateAssessmentTarget(request))

        def primitive[A](
          f: InspectorClient => A
        ): Kleisli[M, InspectorClient, A]
      }
    }

    trait Visitor[F[_]] extends (InspectorOp ~> F) {
      final def apply[A](op: InspectorOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addAttributesToFindings(
        request: AddAttributesToFindingsRequest
      ): F[AddAttributesToFindingsResponse]

      def createAssessmentTarget(
        request: CreateAssessmentTargetRequest
      ): F[CreateAssessmentTargetResponse]

      def createAssessmentTemplate(
        request: CreateAssessmentTemplateRequest
      ): F[CreateAssessmentTemplateResponse]

      def createExclusionsPreview(
        request: CreateExclusionsPreviewRequest
      ): F[CreateExclusionsPreviewResponse]

      def createResourceGroup(
        request: CreateResourceGroupRequest
      ): F[CreateResourceGroupResponse]

      def deleteAssessmentRun(
        request: DeleteAssessmentRunRequest
      ): F[DeleteAssessmentRunResponse]

      def deleteAssessmentTarget(
        request: DeleteAssessmentTargetRequest
      ): F[DeleteAssessmentTargetResponse]

      def deleteAssessmentTemplate(
        request: DeleteAssessmentTemplateRequest
      ): F[DeleteAssessmentTemplateResponse]

      def describeAssessmentRuns(
        request: DescribeAssessmentRunsRequest
      ): F[DescribeAssessmentRunsResponse]

      def describeAssessmentTargets(
        request: DescribeAssessmentTargetsRequest
      ): F[DescribeAssessmentTargetsResponse]

      def describeAssessmentTemplates(
        request: DescribeAssessmentTemplatesRequest
      ): F[DescribeAssessmentTemplatesResponse]

      def describeCrossAccountAccessRole(
        request: DescribeCrossAccountAccessRoleRequest
      ): F[DescribeCrossAccountAccessRoleResponse]

      def describeExclusions(
        request: DescribeExclusionsRequest
      ): F[DescribeExclusionsResponse]

      def describeFindings(
        request: DescribeFindingsRequest
      ): F[DescribeFindingsResponse]

      def describeResourceGroups(
        request: DescribeResourceGroupsRequest
      ): F[DescribeResourceGroupsResponse]

      def describeRulesPackages(
        request: DescribeRulesPackagesRequest
      ): F[DescribeRulesPackagesResponse]

      def getAssessmentReport(
        request: GetAssessmentReportRequest
      ): F[GetAssessmentReportResponse]

      def getExclusionsPreview(
        request: GetExclusionsPreviewRequest
      ): F[GetExclusionsPreviewResponse]

      def getTelemetryMetadata(
        request: GetTelemetryMetadataRequest
      ): F[GetTelemetryMetadataResponse]

      def listAssessmentRunAgents(
        request: ListAssessmentRunAgentsRequest
      ): F[ListAssessmentRunAgentsResponse]

      def listAssessmentRuns(
        request: ListAssessmentRunsRequest
      ): F[ListAssessmentRunsResponse]

      def listAssessmentTargets(
        request: ListAssessmentTargetsRequest
      ): F[ListAssessmentTargetsResponse]

      def listAssessmentTemplates(
        request: ListAssessmentTemplatesRequest
      ): F[ListAssessmentTemplatesResponse]

      def listEventSubscriptions(
        request: ListEventSubscriptionsRequest
      ): F[ListEventSubscriptionsResponse]

      def listExclusions(
        request: ListExclusionsRequest
      ): F[ListExclusionsResponse]

      def listFindings(
        request: ListFindingsRequest
      ): F[ListFindingsResponse]

      def listRulesPackages(
        request: ListRulesPackagesRequest
      ): F[ListRulesPackagesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def previewAgents(
        request: PreviewAgentsRequest
      ): F[PreviewAgentsResponse]

      def registerCrossAccountAccessRole(
        request: RegisterCrossAccountAccessRoleRequest
      ): F[RegisterCrossAccountAccessRoleResponse]

      def removeAttributesFromFindings(
        request: RemoveAttributesFromFindingsRequest
      ): F[RemoveAttributesFromFindingsResponse]

      def setTagsForResource(
        request: SetTagsForResourceRequest
      ): F[SetTagsForResourceResponse]

      def startAssessmentRun(
        request: StartAssessmentRunRequest
      ): F[StartAssessmentRunResponse]

      def stopAssessmentRun(
        request: StopAssessmentRunRequest
      ): F[StopAssessmentRunResponse]

      def subscribeToEvent(
        request: SubscribeToEventRequest
      ): F[SubscribeToEventResponse]

      def unsubscribeFromEvent(
        request: UnsubscribeFromEventRequest
      ): F[UnsubscribeFromEventResponse]

      def updateAssessmentTarget(
        request: UpdateAssessmentTargetRequest
      ): F[UpdateAssessmentTargetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends InspectorOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddAttributesToFindingsOp(
      request: AddAttributesToFindingsRequest
    ) extends InspectorOp[AddAttributesToFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddAttributesToFindingsResponse] =
        visitor.addAttributesToFindings(request)
    }

    final case class CreateAssessmentTargetOp(
      request: CreateAssessmentTargetRequest
    ) extends InspectorOp[CreateAssessmentTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssessmentTargetResponse] =
        visitor.createAssessmentTarget(request)
    }

    final case class CreateAssessmentTemplateOp(
      request: CreateAssessmentTemplateRequest
    ) extends InspectorOp[CreateAssessmentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssessmentTemplateResponse] =
        visitor.createAssessmentTemplate(request)
    }

    final case class CreateExclusionsPreviewOp(
      request: CreateExclusionsPreviewRequest
    ) extends InspectorOp[CreateExclusionsPreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateExclusionsPreviewResponse] =
        visitor.createExclusionsPreview(request)
    }

    final case class CreateResourceGroupOp(
      request: CreateResourceGroupRequest
    ) extends InspectorOp[CreateResourceGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceGroupResponse] =
        visitor.createResourceGroup(request)
    }

    final case class DeleteAssessmentRunOp(
      request: DeleteAssessmentRunRequest
    ) extends InspectorOp[DeleteAssessmentRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssessmentRunResponse] =
        visitor.deleteAssessmentRun(request)
    }

    final case class DeleteAssessmentTargetOp(
      request: DeleteAssessmentTargetRequest
    ) extends InspectorOp[DeleteAssessmentTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssessmentTargetResponse] =
        visitor.deleteAssessmentTarget(request)
    }

    final case class DeleteAssessmentTemplateOp(
      request: DeleteAssessmentTemplateRequest
    ) extends InspectorOp[DeleteAssessmentTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssessmentTemplateResponse] =
        visitor.deleteAssessmentTemplate(request)
    }

    final case class DescribeAssessmentRunsOp(
      request: DescribeAssessmentRunsRequest
    ) extends InspectorOp[DescribeAssessmentRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssessmentRunsResponse] =
        visitor.describeAssessmentRuns(request)
    }

    final case class DescribeAssessmentTargetsOp(
      request: DescribeAssessmentTargetsRequest
    ) extends InspectorOp[DescribeAssessmentTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssessmentTargetsResponse] =
        visitor.describeAssessmentTargets(request)
    }

    final case class DescribeAssessmentTemplatesOp(
      request: DescribeAssessmentTemplatesRequest
    ) extends InspectorOp[DescribeAssessmentTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssessmentTemplatesResponse] =
        visitor.describeAssessmentTemplates(request)
    }

    final case class DescribeCrossAccountAccessRoleOp(
      request: DescribeCrossAccountAccessRoleRequest
    ) extends InspectorOp[DescribeCrossAccountAccessRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCrossAccountAccessRoleResponse] =
        visitor.describeCrossAccountAccessRole(request)
    }

    final case class DescribeExclusionsOp(
      request: DescribeExclusionsRequest
    ) extends InspectorOp[DescribeExclusionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeExclusionsResponse] =
        visitor.describeExclusions(request)
    }

    final case class DescribeFindingsOp(
      request: DescribeFindingsRequest
    ) extends InspectorOp[DescribeFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFindingsResponse] =
        visitor.describeFindings(request)
    }

    final case class DescribeResourceGroupsOp(
      request: DescribeResourceGroupsRequest
    ) extends InspectorOp[DescribeResourceGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeResourceGroupsResponse] =
        visitor.describeResourceGroups(request)
    }

    final case class DescribeRulesPackagesOp(
      request: DescribeRulesPackagesRequest
    ) extends InspectorOp[DescribeRulesPackagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRulesPackagesResponse] =
        visitor.describeRulesPackages(request)
    }

    final case class GetAssessmentReportOp(
      request: GetAssessmentReportRequest
    ) extends InspectorOp[GetAssessmentReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssessmentReportResponse] =
        visitor.getAssessmentReport(request)
    }

    final case class GetExclusionsPreviewOp(
      request: GetExclusionsPreviewRequest
    ) extends InspectorOp[GetExclusionsPreviewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetExclusionsPreviewResponse] =
        visitor.getExclusionsPreview(request)
    }

    final case class GetTelemetryMetadataOp(
      request: GetTelemetryMetadataRequest
    ) extends InspectorOp[GetTelemetryMetadataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTelemetryMetadataResponse] =
        visitor.getTelemetryMetadata(request)
    }

    final case class ListAssessmentRunAgentsOp(
      request: ListAssessmentRunAgentsRequest
    ) extends InspectorOp[ListAssessmentRunAgentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentRunAgentsResponse] =
        visitor.listAssessmentRunAgents(request)
    }

    final case class ListAssessmentRunsOp(
      request: ListAssessmentRunsRequest
    ) extends InspectorOp[ListAssessmentRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentRunsResponse] =
        visitor.listAssessmentRuns(request)
    }

    final case class ListAssessmentTargetsOp(
      request: ListAssessmentTargetsRequest
    ) extends InspectorOp[ListAssessmentTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentTargetsResponse] =
        visitor.listAssessmentTargets(request)
    }

    final case class ListAssessmentTemplatesOp(
      request: ListAssessmentTemplatesRequest
    ) extends InspectorOp[ListAssessmentTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssessmentTemplatesResponse] =
        visitor.listAssessmentTemplates(request)
    }

    final case class ListEventSubscriptionsOp(
      request: ListEventSubscriptionsRequest
    ) extends InspectorOp[ListEventSubscriptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventSubscriptionsResponse] =
        visitor.listEventSubscriptions(request)
    }

    final case class ListExclusionsOp(
      request: ListExclusionsRequest
    ) extends InspectorOp[ListExclusionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExclusionsResponse] =
        visitor.listExclusions(request)
    }

    final case class ListFindingsOp(
      request: ListFindingsRequest
    ) extends InspectorOp[ListFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFindingsResponse] =
        visitor.listFindings(request)
    }

    final case class ListRulesPackagesOp(
      request: ListRulesPackagesRequest
    ) extends InspectorOp[ListRulesPackagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRulesPackagesResponse] =
        visitor.listRulesPackages(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends InspectorOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PreviewAgentsOp(
      request: PreviewAgentsRequest
    ) extends InspectorOp[PreviewAgentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PreviewAgentsResponse] =
        visitor.previewAgents(request)
    }

    final case class RegisterCrossAccountAccessRoleOp(
      request: RegisterCrossAccountAccessRoleRequest
    ) extends InspectorOp[RegisterCrossAccountAccessRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterCrossAccountAccessRoleResponse] =
        visitor.registerCrossAccountAccessRole(request)
    }

    final case class RemoveAttributesFromFindingsOp(
      request: RemoveAttributesFromFindingsRequest
    ) extends InspectorOp[RemoveAttributesFromFindingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveAttributesFromFindingsResponse] =
        visitor.removeAttributesFromFindings(request)
    }

    final case class SetTagsForResourceOp(
      request: SetTagsForResourceRequest
    ) extends InspectorOp[SetTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetTagsForResourceResponse] =
        visitor.setTagsForResource(request)
    }

    final case class StartAssessmentRunOp(
      request: StartAssessmentRunRequest
    ) extends InspectorOp[StartAssessmentRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartAssessmentRunResponse] =
        visitor.startAssessmentRun(request)
    }

    final case class StopAssessmentRunOp(
      request: StopAssessmentRunRequest
    ) extends InspectorOp[StopAssessmentRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopAssessmentRunResponse] =
        visitor.stopAssessmentRun(request)
    }

    final case class SubscribeToEventOp(
      request: SubscribeToEventRequest
    ) extends InspectorOp[SubscribeToEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubscribeToEventResponse] =
        visitor.subscribeToEvent(request)
    }

    final case class UnsubscribeFromEventOp(
      request: UnsubscribeFromEventRequest
    ) extends InspectorOp[UnsubscribeFromEventResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UnsubscribeFromEventResponse] =
        visitor.unsubscribeFromEvent(request)
    }

    final case class UpdateAssessmentTargetOp(
      request: UpdateAssessmentTargetRequest
    ) extends InspectorOp[UpdateAssessmentTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssessmentTargetResponse] =
        visitor.updateAssessmentTarget(request)
    }
  }

  import InspectorOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[InspectorOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addAttributesToFindings(
    request: AddAttributesToFindingsRequest
  ): InspectorIO[AddAttributesToFindingsResponse] =
    FF.liftF(AddAttributesToFindingsOp(request))

  def createAssessmentTarget(
    request: CreateAssessmentTargetRequest
  ): InspectorIO[CreateAssessmentTargetResponse] =
    FF.liftF(CreateAssessmentTargetOp(request))

  def createAssessmentTemplate(
    request: CreateAssessmentTemplateRequest
  ): InspectorIO[CreateAssessmentTemplateResponse] =
    FF.liftF(CreateAssessmentTemplateOp(request))

  def createExclusionsPreview(
    request: CreateExclusionsPreviewRequest
  ): InspectorIO[CreateExclusionsPreviewResponse] =
    FF.liftF(CreateExclusionsPreviewOp(request))

  def createResourceGroup(
    request: CreateResourceGroupRequest
  ): InspectorIO[CreateResourceGroupResponse] =
    FF.liftF(CreateResourceGroupOp(request))

  def deleteAssessmentRun(
    request: DeleteAssessmentRunRequest
  ): InspectorIO[DeleteAssessmentRunResponse] =
    FF.liftF(DeleteAssessmentRunOp(request))

  def deleteAssessmentTarget(
    request: DeleteAssessmentTargetRequest
  ): InspectorIO[DeleteAssessmentTargetResponse] =
    FF.liftF(DeleteAssessmentTargetOp(request))

  def deleteAssessmentTemplate(
    request: DeleteAssessmentTemplateRequest
  ): InspectorIO[DeleteAssessmentTemplateResponse] =
    FF.liftF(DeleteAssessmentTemplateOp(request))

  def describeAssessmentRuns(
    request: DescribeAssessmentRunsRequest
  ): InspectorIO[DescribeAssessmentRunsResponse] =
    FF.liftF(DescribeAssessmentRunsOp(request))

  def describeAssessmentTargets(
    request: DescribeAssessmentTargetsRequest
  ): InspectorIO[DescribeAssessmentTargetsResponse] =
    FF.liftF(DescribeAssessmentTargetsOp(request))

  def describeAssessmentTemplates(
    request: DescribeAssessmentTemplatesRequest
  ): InspectorIO[DescribeAssessmentTemplatesResponse] =
    FF.liftF(DescribeAssessmentTemplatesOp(request))

  def describeCrossAccountAccessRole(
    request: DescribeCrossAccountAccessRoleRequest
  ): InspectorIO[DescribeCrossAccountAccessRoleResponse] =
    FF.liftF(DescribeCrossAccountAccessRoleOp(request))

  def describeExclusions(
    request: DescribeExclusionsRequest
  ): InspectorIO[DescribeExclusionsResponse] =
    FF.liftF(DescribeExclusionsOp(request))

  def describeFindings(
    request: DescribeFindingsRequest
  ): InspectorIO[DescribeFindingsResponse] =
    FF.liftF(DescribeFindingsOp(request))

  def describeResourceGroups(
    request: DescribeResourceGroupsRequest
  ): InspectorIO[DescribeResourceGroupsResponse] =
    FF.liftF(DescribeResourceGroupsOp(request))

  def describeRulesPackages(
    request: DescribeRulesPackagesRequest
  ): InspectorIO[DescribeRulesPackagesResponse] =
    FF.liftF(DescribeRulesPackagesOp(request))

  def getAssessmentReport(
    request: GetAssessmentReportRequest
  ): InspectorIO[GetAssessmentReportResponse] =
    FF.liftF(GetAssessmentReportOp(request))

  def getExclusionsPreview(
    request: GetExclusionsPreviewRequest
  ): InspectorIO[GetExclusionsPreviewResponse] =
    FF.liftF(GetExclusionsPreviewOp(request))

  def getTelemetryMetadata(
    request: GetTelemetryMetadataRequest
  ): InspectorIO[GetTelemetryMetadataResponse] =
    FF.liftF(GetTelemetryMetadataOp(request))

  def listAssessmentRunAgents(
    request: ListAssessmentRunAgentsRequest
  ): InspectorIO[ListAssessmentRunAgentsResponse] =
    FF.liftF(ListAssessmentRunAgentsOp(request))

  def listAssessmentRuns(
    request: ListAssessmentRunsRequest
  ): InspectorIO[ListAssessmentRunsResponse] =
    FF.liftF(ListAssessmentRunsOp(request))

  def listAssessmentTargets(
    request: ListAssessmentTargetsRequest
  ): InspectorIO[ListAssessmentTargetsResponse] =
    FF.liftF(ListAssessmentTargetsOp(request))

  def listAssessmentTemplates(
    request: ListAssessmentTemplatesRequest
  ): InspectorIO[ListAssessmentTemplatesResponse] =
    FF.liftF(ListAssessmentTemplatesOp(request))

  def listEventSubscriptions(
    request: ListEventSubscriptionsRequest
  ): InspectorIO[ListEventSubscriptionsResponse] =
    FF.liftF(ListEventSubscriptionsOp(request))

  def listExclusions(
    request: ListExclusionsRequest
  ): InspectorIO[ListExclusionsResponse] =
    FF.liftF(ListExclusionsOp(request))

  def listFindings(
    request: ListFindingsRequest
  ): InspectorIO[ListFindingsResponse] =
    FF.liftF(ListFindingsOp(request))

  def listRulesPackages(
    request: ListRulesPackagesRequest
  ): InspectorIO[ListRulesPackagesResponse] =
    FF.liftF(ListRulesPackagesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): InspectorIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def previewAgents(
    request: PreviewAgentsRequest
  ): InspectorIO[PreviewAgentsResponse] =
    FF.liftF(PreviewAgentsOp(request))

  def registerCrossAccountAccessRole(
    request: RegisterCrossAccountAccessRoleRequest
  ): InspectorIO[RegisterCrossAccountAccessRoleResponse] =
    FF.liftF(RegisterCrossAccountAccessRoleOp(request))

  def removeAttributesFromFindings(
    request: RemoveAttributesFromFindingsRequest
  ): InspectorIO[RemoveAttributesFromFindingsResponse] =
    FF.liftF(RemoveAttributesFromFindingsOp(request))

  def setTagsForResource(
    request: SetTagsForResourceRequest
  ): InspectorIO[SetTagsForResourceResponse] =
    FF.liftF(SetTagsForResourceOp(request))

  def startAssessmentRun(
    request: StartAssessmentRunRequest
  ): InspectorIO[StartAssessmentRunResponse] =
    FF.liftF(StartAssessmentRunOp(request))

  def stopAssessmentRun(
    request: StopAssessmentRunRequest
  ): InspectorIO[StopAssessmentRunResponse] =
    FF.liftF(StopAssessmentRunOp(request))

  def subscribeToEvent(
    request: SubscribeToEventRequest
  ): InspectorIO[SubscribeToEventResponse] =
    FF.liftF(SubscribeToEventOp(request))

  def unsubscribeFromEvent(
    request: UnsubscribeFromEventRequest
  ): InspectorIO[UnsubscribeFromEventResponse] =
    FF.liftF(UnsubscribeFromEventOp(request))

  def updateAssessmentTarget(
    request: UpdateAssessmentTargetRequest
  ): InspectorIO[UpdateAssessmentTargetResponse] =
    FF.liftF(UpdateAssessmentTargetOp(request))
}
