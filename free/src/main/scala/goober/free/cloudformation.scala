package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.cloudformation.CloudFormationClient
import software.amazon.awssdk.services.cloudformation.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object cloudformation { module =>

  // Free monad over CloudFormationOp
  type CloudFormationIO[A] = FF[CloudFormationOp, A]

  sealed trait CloudFormationOp[A] {
    def visit[F[_]](visitor: CloudFormationOp.Visitor[F]): F[A]
  }

  object CloudFormationOp {
    // Given a CloudFormationClient we can embed a CloudFormationIO program in any algebra that understands embedding.
    implicit val CloudFormationOpEmbeddable: Embeddable[CloudFormationOp, CloudFormationClient] = new Embeddable[CloudFormationOp, CloudFormationClient] {
      def embed[A](client: CloudFormationClient, io: CloudFormationIO[A]): Embedded[A] = Embedded.CloudFormation(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CloudFormationOp.Visitor[Kleisli[M, CloudFormationClient, *]] {
        def cancelUpdateStack(
          request: CancelUpdateStackRequest
        ): Kleisli[M, CloudFormationClient, CancelUpdateStackResponse] =
          primitive(_.cancelUpdateStack(request))

        def continueUpdateRollback(
          request: ContinueUpdateRollbackRequest
        ): Kleisli[M, CloudFormationClient, ContinueUpdateRollbackResponse] =
          primitive(_.continueUpdateRollback(request))

        def createChangeSet(
          request: CreateChangeSetRequest
        ): Kleisli[M, CloudFormationClient, CreateChangeSetResponse] =
          primitive(_.createChangeSet(request))

        def createStack(
          request: CreateStackRequest
        ): Kleisli[M, CloudFormationClient, CreateStackResponse] =
          primitive(_.createStack(request))

        def createStackInstances(
          request: CreateStackInstancesRequest
        ): Kleisli[M, CloudFormationClient, CreateStackInstancesResponse] =
          primitive(_.createStackInstances(request))

        def createStackSet(
          request: CreateStackSetRequest
        ): Kleisli[M, CloudFormationClient, CreateStackSetResponse] =
          primitive(_.createStackSet(request))

        def deleteChangeSet(
          request: DeleteChangeSetRequest
        ): Kleisli[M, CloudFormationClient, DeleteChangeSetResponse] =
          primitive(_.deleteChangeSet(request))

        def deleteStack(
          request: DeleteStackRequest
        ): Kleisli[M, CloudFormationClient, DeleteStackResponse] =
          primitive(_.deleteStack(request))

        def deleteStackInstances(
          request: DeleteStackInstancesRequest
        ): Kleisli[M, CloudFormationClient, DeleteStackInstancesResponse] =
          primitive(_.deleteStackInstances(request))

        def deleteStackSet(
          request: DeleteStackSetRequest
        ): Kleisli[M, CloudFormationClient, DeleteStackSetResponse] =
          primitive(_.deleteStackSet(request))

        def deregisterType(
          request: DeregisterTypeRequest
        ): Kleisli[M, CloudFormationClient, DeregisterTypeResponse] =
          primitive(_.deregisterType(request))

        def describeAccountLimits(
          request: DescribeAccountLimitsRequest
        ): Kleisli[M, CloudFormationClient, DescribeAccountLimitsResponse] =
          primitive(_.describeAccountLimits(request))

        def describeChangeSet(
          request: DescribeChangeSetRequest
        ): Kleisli[M, CloudFormationClient, DescribeChangeSetResponse] =
          primitive(_.describeChangeSet(request))

        def describeStackDriftDetectionStatus(
          request: DescribeStackDriftDetectionStatusRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackDriftDetectionStatusResponse] =
          primitive(_.describeStackDriftDetectionStatus(request))

        def describeStackEvents(
          request: DescribeStackEventsRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackEventsResponse] =
          primitive(_.describeStackEvents(request))

        def describeStackInstance(
          request: DescribeStackInstanceRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackInstanceResponse] =
          primitive(_.describeStackInstance(request))

        def describeStackResource(
          request: DescribeStackResourceRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackResourceResponse] =
          primitive(_.describeStackResource(request))

        def describeStackResourceDrifts(
          request: DescribeStackResourceDriftsRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackResourceDriftsResponse] =
          primitive(_.describeStackResourceDrifts(request))

        def describeStackResources(
          request: DescribeStackResourcesRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackResourcesResponse] =
          primitive(_.describeStackResources(request))

        def describeStackSet(
          request: DescribeStackSetRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackSetResponse] =
          primitive(_.describeStackSet(request))

        def describeStackSetOperation(
          request: DescribeStackSetOperationRequest
        ): Kleisli[M, CloudFormationClient, DescribeStackSetOperationResponse] =
          primitive(_.describeStackSetOperation(request))

        def describeStacks(
          request: DescribeStacksRequest
        ): Kleisli[M, CloudFormationClient, DescribeStacksResponse] =
          primitive(_.describeStacks(request))

        def describeType(
          request: DescribeTypeRequest
        ): Kleisli[M, CloudFormationClient, DescribeTypeResponse] =
          primitive(_.describeType(request))

        def describeTypeRegistration(
          request: DescribeTypeRegistrationRequest
        ): Kleisli[M, CloudFormationClient, DescribeTypeRegistrationResponse] =
          primitive(_.describeTypeRegistration(request))

        def detectStackDrift(
          request: DetectStackDriftRequest
        ): Kleisli[M, CloudFormationClient, DetectStackDriftResponse] =
          primitive(_.detectStackDrift(request))

        def detectStackResourceDrift(
          request: DetectStackResourceDriftRequest
        ): Kleisli[M, CloudFormationClient, DetectStackResourceDriftResponse] =
          primitive(_.detectStackResourceDrift(request))

        def detectStackSetDrift(
          request: DetectStackSetDriftRequest
        ): Kleisli[M, CloudFormationClient, DetectStackSetDriftResponse] =
          primitive(_.detectStackSetDrift(request))

        def estimateTemplateCost(
          request: EstimateTemplateCostRequest
        ): Kleisli[M, CloudFormationClient, EstimateTemplateCostResponse] =
          primitive(_.estimateTemplateCost(request))

        def executeChangeSet(
          request: ExecuteChangeSetRequest
        ): Kleisli[M, CloudFormationClient, ExecuteChangeSetResponse] =
          primitive(_.executeChangeSet(request))

        def getStackPolicy(
          request: GetStackPolicyRequest
        ): Kleisli[M, CloudFormationClient, GetStackPolicyResponse] =
          primitive(_.getStackPolicy(request))

        def getTemplate(
          request: GetTemplateRequest
        ): Kleisli[M, CloudFormationClient, GetTemplateResponse] =
          primitive(_.getTemplate(request))

        def getTemplateSummary(
          request: GetTemplateSummaryRequest
        ): Kleisli[M, CloudFormationClient, GetTemplateSummaryResponse] =
          primitive(_.getTemplateSummary(request))

        def listChangeSets(
          request: ListChangeSetsRequest
        ): Kleisli[M, CloudFormationClient, ListChangeSetsResponse] =
          primitive(_.listChangeSets(request))

        def listExports(
          request: ListExportsRequest
        ): Kleisli[M, CloudFormationClient, ListExportsResponse] =
          primitive(_.listExports(request))

        def listImports(
          request: ListImportsRequest
        ): Kleisli[M, CloudFormationClient, ListImportsResponse] =
          primitive(_.listImports(request))

        def listStackInstances(
          request: ListStackInstancesRequest
        ): Kleisli[M, CloudFormationClient, ListStackInstancesResponse] =
          primitive(_.listStackInstances(request))

        def listStackResources(
          request: ListStackResourcesRequest
        ): Kleisli[M, CloudFormationClient, ListStackResourcesResponse] =
          primitive(_.listStackResources(request))

        def listStackSetOperationResults(
          request: ListStackSetOperationResultsRequest
        ): Kleisli[M, CloudFormationClient, ListStackSetOperationResultsResponse] =
          primitive(_.listStackSetOperationResults(request))

        def listStackSetOperations(
          request: ListStackSetOperationsRequest
        ): Kleisli[M, CloudFormationClient, ListStackSetOperationsResponse] =
          primitive(_.listStackSetOperations(request))

        def listStackSets(
          request: ListStackSetsRequest
        ): Kleisli[M, CloudFormationClient, ListStackSetsResponse] =
          primitive(_.listStackSets(request))

        def listStacks(
          request: ListStacksRequest
        ): Kleisli[M, CloudFormationClient, ListStacksResponse] =
          primitive(_.listStacks(request))

        def listTypeRegistrations(
          request: ListTypeRegistrationsRequest
        ): Kleisli[M, CloudFormationClient, ListTypeRegistrationsResponse] =
          primitive(_.listTypeRegistrations(request))

        def listTypeVersions(
          request: ListTypeVersionsRequest
        ): Kleisli[M, CloudFormationClient, ListTypeVersionsResponse] =
          primitive(_.listTypeVersions(request))

        def listTypes(
          request: ListTypesRequest
        ): Kleisli[M, CloudFormationClient, ListTypesResponse] =
          primitive(_.listTypes(request))

        def recordHandlerProgress(
          request: RecordHandlerProgressRequest
        ): Kleisli[M, CloudFormationClient, RecordHandlerProgressResponse] =
          primitive(_.recordHandlerProgress(request))

        def registerType(
          request: RegisterTypeRequest
        ): Kleisli[M, CloudFormationClient, RegisterTypeResponse] =
          primitive(_.registerType(request))

        def setStackPolicy(
          request: SetStackPolicyRequest
        ): Kleisli[M, CloudFormationClient, SetStackPolicyResponse] =
          primitive(_.setStackPolicy(request))

        def setTypeDefaultVersion(
          request: SetTypeDefaultVersionRequest
        ): Kleisli[M, CloudFormationClient, SetTypeDefaultVersionResponse] =
          primitive(_.setTypeDefaultVersion(request))

        def signalResource(
          request: SignalResourceRequest
        ): Kleisli[M, CloudFormationClient, SignalResourceResponse] =
          primitive(_.signalResource(request))

        def stopStackSetOperation(
          request: StopStackSetOperationRequest
        ): Kleisli[M, CloudFormationClient, StopStackSetOperationResponse] =
          primitive(_.stopStackSetOperation(request))

        def updateStack(
          request: UpdateStackRequest
        ): Kleisli[M, CloudFormationClient, UpdateStackResponse] =
          primitive(_.updateStack(request))

        def updateStackInstances(
          request: UpdateStackInstancesRequest
        ): Kleisli[M, CloudFormationClient, UpdateStackInstancesResponse] =
          primitive(_.updateStackInstances(request))

        def updateStackSet(
          request: UpdateStackSetRequest
        ): Kleisli[M, CloudFormationClient, UpdateStackSetResponse] =
          primitive(_.updateStackSet(request))

        def updateTerminationProtection(
          request: UpdateTerminationProtectionRequest
        ): Kleisli[M, CloudFormationClient, UpdateTerminationProtectionResponse] =
          primitive(_.updateTerminationProtection(request))

        def validateTemplate(
          request: ValidateTemplateRequest
        ): Kleisli[M, CloudFormationClient, ValidateTemplateResponse] =
          primitive(_.validateTemplate(request))

        def primitive[A](
          f: CloudFormationClient => A
        ): Kleisli[M, CloudFormationClient, A]
      }
    }

    trait Visitor[F[_]] extends (CloudFormationOp ~> F) {
      final def apply[A](op: CloudFormationOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelUpdateStack(
        request: CancelUpdateStackRequest
      ): F[CancelUpdateStackResponse]

      def continueUpdateRollback(
        request: ContinueUpdateRollbackRequest
      ): F[ContinueUpdateRollbackResponse]

      def createChangeSet(
        request: CreateChangeSetRequest
      ): F[CreateChangeSetResponse]

      def createStack(
        request: CreateStackRequest
      ): F[CreateStackResponse]

      def createStackInstances(
        request: CreateStackInstancesRequest
      ): F[CreateStackInstancesResponse]

      def createStackSet(
        request: CreateStackSetRequest
      ): F[CreateStackSetResponse]

      def deleteChangeSet(
        request: DeleteChangeSetRequest
      ): F[DeleteChangeSetResponse]

      def deleteStack(
        request: DeleteStackRequest
      ): F[DeleteStackResponse]

      def deleteStackInstances(
        request: DeleteStackInstancesRequest
      ): F[DeleteStackInstancesResponse]

      def deleteStackSet(
        request: DeleteStackSetRequest
      ): F[DeleteStackSetResponse]

      def deregisterType(
        request: DeregisterTypeRequest
      ): F[DeregisterTypeResponse]

      def describeAccountLimits(
        request: DescribeAccountLimitsRequest
      ): F[DescribeAccountLimitsResponse]

      def describeChangeSet(
        request: DescribeChangeSetRequest
      ): F[DescribeChangeSetResponse]

      def describeStackDriftDetectionStatus(
        request: DescribeStackDriftDetectionStatusRequest
      ): F[DescribeStackDriftDetectionStatusResponse]

      def describeStackEvents(
        request: DescribeStackEventsRequest
      ): F[DescribeStackEventsResponse]

      def describeStackInstance(
        request: DescribeStackInstanceRequest
      ): F[DescribeStackInstanceResponse]

      def describeStackResource(
        request: DescribeStackResourceRequest
      ): F[DescribeStackResourceResponse]

      def describeStackResourceDrifts(
        request: DescribeStackResourceDriftsRequest
      ): F[DescribeStackResourceDriftsResponse]

      def describeStackResources(
        request: DescribeStackResourcesRequest
      ): F[DescribeStackResourcesResponse]

      def describeStackSet(
        request: DescribeStackSetRequest
      ): F[DescribeStackSetResponse]

      def describeStackSetOperation(
        request: DescribeStackSetOperationRequest
      ): F[DescribeStackSetOperationResponse]

      def describeStacks(
        request: DescribeStacksRequest
      ): F[DescribeStacksResponse]

      def describeType(
        request: DescribeTypeRequest
      ): F[DescribeTypeResponse]

      def describeTypeRegistration(
        request: DescribeTypeRegistrationRequest
      ): F[DescribeTypeRegistrationResponse]

      def detectStackDrift(
        request: DetectStackDriftRequest
      ): F[DetectStackDriftResponse]

      def detectStackResourceDrift(
        request: DetectStackResourceDriftRequest
      ): F[DetectStackResourceDriftResponse]

      def detectStackSetDrift(
        request: DetectStackSetDriftRequest
      ): F[DetectStackSetDriftResponse]

      def estimateTemplateCost(
        request: EstimateTemplateCostRequest
      ): F[EstimateTemplateCostResponse]

      def executeChangeSet(
        request: ExecuteChangeSetRequest
      ): F[ExecuteChangeSetResponse]

      def getStackPolicy(
        request: GetStackPolicyRequest
      ): F[GetStackPolicyResponse]

      def getTemplate(
        request: GetTemplateRequest
      ): F[GetTemplateResponse]

      def getTemplateSummary(
        request: GetTemplateSummaryRequest
      ): F[GetTemplateSummaryResponse]

      def listChangeSets(
        request: ListChangeSetsRequest
      ): F[ListChangeSetsResponse]

      def listExports(
        request: ListExportsRequest
      ): F[ListExportsResponse]

      def listImports(
        request: ListImportsRequest
      ): F[ListImportsResponse]

      def listStackInstances(
        request: ListStackInstancesRequest
      ): F[ListStackInstancesResponse]

      def listStackResources(
        request: ListStackResourcesRequest
      ): F[ListStackResourcesResponse]

      def listStackSetOperationResults(
        request: ListStackSetOperationResultsRequest
      ): F[ListStackSetOperationResultsResponse]

      def listStackSetOperations(
        request: ListStackSetOperationsRequest
      ): F[ListStackSetOperationsResponse]

      def listStackSets(
        request: ListStackSetsRequest
      ): F[ListStackSetsResponse]

      def listStacks(
        request: ListStacksRequest
      ): F[ListStacksResponse]

      def listTypeRegistrations(
        request: ListTypeRegistrationsRequest
      ): F[ListTypeRegistrationsResponse]

      def listTypeVersions(
        request: ListTypeVersionsRequest
      ): F[ListTypeVersionsResponse]

      def listTypes(
        request: ListTypesRequest
      ): F[ListTypesResponse]

      def recordHandlerProgress(
        request: RecordHandlerProgressRequest
      ): F[RecordHandlerProgressResponse]

      def registerType(
        request: RegisterTypeRequest
      ): F[RegisterTypeResponse]

      def setStackPolicy(
        request: SetStackPolicyRequest
      ): F[SetStackPolicyResponse]

      def setTypeDefaultVersion(
        request: SetTypeDefaultVersionRequest
      ): F[SetTypeDefaultVersionResponse]

      def signalResource(
        request: SignalResourceRequest
      ): F[SignalResourceResponse]

      def stopStackSetOperation(
        request: StopStackSetOperationRequest
      ): F[StopStackSetOperationResponse]

      def updateStack(
        request: UpdateStackRequest
      ): F[UpdateStackResponse]

      def updateStackInstances(
        request: UpdateStackInstancesRequest
      ): F[UpdateStackInstancesResponse]

      def updateStackSet(
        request: UpdateStackSetRequest
      ): F[UpdateStackSetResponse]

      def updateTerminationProtection(
        request: UpdateTerminationProtectionRequest
      ): F[UpdateTerminationProtectionResponse]

      def validateTemplate(
        request: ValidateTemplateRequest
      ): F[ValidateTemplateResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CloudFormationOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelUpdateStackOp(
      request: CancelUpdateStackRequest
    ) extends CloudFormationOp[CancelUpdateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelUpdateStackResponse] =
        visitor.cancelUpdateStack(request)
    }

    final case class ContinueUpdateRollbackOp(
      request: ContinueUpdateRollbackRequest
    ) extends CloudFormationOp[ContinueUpdateRollbackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ContinueUpdateRollbackResponse] =
        visitor.continueUpdateRollback(request)
    }

    final case class CreateChangeSetOp(
      request: CreateChangeSetRequest
    ) extends CloudFormationOp[CreateChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChangeSetResponse] =
        visitor.createChangeSet(request)
    }

    final case class CreateStackOp(
      request: CreateStackRequest
    ) extends CloudFormationOp[CreateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStackResponse] =
        visitor.createStack(request)
    }

    final case class CreateStackInstancesOp(
      request: CreateStackInstancesRequest
    ) extends CloudFormationOp[CreateStackInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStackInstancesResponse] =
        visitor.createStackInstances(request)
    }

    final case class CreateStackSetOp(
      request: CreateStackSetRequest
    ) extends CloudFormationOp[CreateStackSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStackSetResponse] =
        visitor.createStackSet(request)
    }

    final case class DeleteChangeSetOp(
      request: DeleteChangeSetRequest
    ) extends CloudFormationOp[DeleteChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChangeSetResponse] =
        visitor.deleteChangeSet(request)
    }

    final case class DeleteStackOp(
      request: DeleteStackRequest
    ) extends CloudFormationOp[DeleteStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStackResponse] =
        visitor.deleteStack(request)
    }

    final case class DeleteStackInstancesOp(
      request: DeleteStackInstancesRequest
    ) extends CloudFormationOp[DeleteStackInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStackInstancesResponse] =
        visitor.deleteStackInstances(request)
    }

    final case class DeleteStackSetOp(
      request: DeleteStackSetRequest
    ) extends CloudFormationOp[DeleteStackSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStackSetResponse] =
        visitor.deleteStackSet(request)
    }

    final case class DeregisterTypeOp(
      request: DeregisterTypeRequest
    ) extends CloudFormationOp[DeregisterTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTypeResponse] =
        visitor.deregisterType(request)
    }

    final case class DescribeAccountLimitsOp(
      request: DescribeAccountLimitsRequest
    ) extends CloudFormationOp[DescribeAccountLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountLimitsResponse] =
        visitor.describeAccountLimits(request)
    }

    final case class DescribeChangeSetOp(
      request: DescribeChangeSetRequest
    ) extends CloudFormationOp[DescribeChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChangeSetResponse] =
        visitor.describeChangeSet(request)
    }

    final case class DescribeStackDriftDetectionStatusOp(
      request: DescribeStackDriftDetectionStatusRequest
    ) extends CloudFormationOp[DescribeStackDriftDetectionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackDriftDetectionStatusResponse] =
        visitor.describeStackDriftDetectionStatus(request)
    }

    final case class DescribeStackEventsOp(
      request: DescribeStackEventsRequest
    ) extends CloudFormationOp[DescribeStackEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackEventsResponse] =
        visitor.describeStackEvents(request)
    }

    final case class DescribeStackInstanceOp(
      request: DescribeStackInstanceRequest
    ) extends CloudFormationOp[DescribeStackInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackInstanceResponse] =
        visitor.describeStackInstance(request)
    }

    final case class DescribeStackResourceOp(
      request: DescribeStackResourceRequest
    ) extends CloudFormationOp[DescribeStackResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackResourceResponse] =
        visitor.describeStackResource(request)
    }

    final case class DescribeStackResourceDriftsOp(
      request: DescribeStackResourceDriftsRequest
    ) extends CloudFormationOp[DescribeStackResourceDriftsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackResourceDriftsResponse] =
        visitor.describeStackResourceDrifts(request)
    }

    final case class DescribeStackResourcesOp(
      request: DescribeStackResourcesRequest
    ) extends CloudFormationOp[DescribeStackResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackResourcesResponse] =
        visitor.describeStackResources(request)
    }

    final case class DescribeStackSetOp(
      request: DescribeStackSetRequest
    ) extends CloudFormationOp[DescribeStackSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackSetResponse] =
        visitor.describeStackSet(request)
    }

    final case class DescribeStackSetOperationOp(
      request: DescribeStackSetOperationRequest
    ) extends CloudFormationOp[DescribeStackSetOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStackSetOperationResponse] =
        visitor.describeStackSetOperation(request)
    }

    final case class DescribeStacksOp(
      request: DescribeStacksRequest
    ) extends CloudFormationOp[DescribeStacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStacksResponse] =
        visitor.describeStacks(request)
    }

    final case class DescribeTypeOp(
      request: DescribeTypeRequest
    ) extends CloudFormationOp[DescribeTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTypeResponse] =
        visitor.describeType(request)
    }

    final case class DescribeTypeRegistrationOp(
      request: DescribeTypeRegistrationRequest
    ) extends CloudFormationOp[DescribeTypeRegistrationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTypeRegistrationResponse] =
        visitor.describeTypeRegistration(request)
    }

    final case class DetectStackDriftOp(
      request: DetectStackDriftRequest
    ) extends CloudFormationOp[DetectStackDriftResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectStackDriftResponse] =
        visitor.detectStackDrift(request)
    }

    final case class DetectStackResourceDriftOp(
      request: DetectStackResourceDriftRequest
    ) extends CloudFormationOp[DetectStackResourceDriftResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectStackResourceDriftResponse] =
        visitor.detectStackResourceDrift(request)
    }

    final case class DetectStackSetDriftOp(
      request: DetectStackSetDriftRequest
    ) extends CloudFormationOp[DetectStackSetDriftResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DetectStackSetDriftResponse] =
        visitor.detectStackSetDrift(request)
    }

    final case class EstimateTemplateCostOp(
      request: EstimateTemplateCostRequest
    ) extends CloudFormationOp[EstimateTemplateCostResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EstimateTemplateCostResponse] =
        visitor.estimateTemplateCost(request)
    }

    final case class ExecuteChangeSetOp(
      request: ExecuteChangeSetRequest
    ) extends CloudFormationOp[ExecuteChangeSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteChangeSetResponse] =
        visitor.executeChangeSet(request)
    }

    final case class GetStackPolicyOp(
      request: GetStackPolicyRequest
    ) extends CloudFormationOp[GetStackPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStackPolicyResponse] =
        visitor.getStackPolicy(request)
    }

    final case class GetTemplateOp(
      request: GetTemplateRequest
    ) extends CloudFormationOp[GetTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTemplateResponse] =
        visitor.getTemplate(request)
    }

    final case class GetTemplateSummaryOp(
      request: GetTemplateSummaryRequest
    ) extends CloudFormationOp[GetTemplateSummaryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetTemplateSummaryResponse] =
        visitor.getTemplateSummary(request)
    }

    final case class ListChangeSetsOp(
      request: ListChangeSetsRequest
    ) extends CloudFormationOp[ListChangeSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChangeSetsResponse] =
        visitor.listChangeSets(request)
    }

    final case class ListExportsOp(
      request: ListExportsRequest
    ) extends CloudFormationOp[ListExportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListExportsResponse] =
        visitor.listExports(request)
    }

    final case class ListImportsOp(
      request: ListImportsRequest
    ) extends CloudFormationOp[ListImportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListImportsResponse] =
        visitor.listImports(request)
    }

    final case class ListStackInstancesOp(
      request: ListStackInstancesRequest
    ) extends CloudFormationOp[ListStackInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStackInstancesResponse] =
        visitor.listStackInstances(request)
    }

    final case class ListStackResourcesOp(
      request: ListStackResourcesRequest
    ) extends CloudFormationOp[ListStackResourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStackResourcesResponse] =
        visitor.listStackResources(request)
    }

    final case class ListStackSetOperationResultsOp(
      request: ListStackSetOperationResultsRequest
    ) extends CloudFormationOp[ListStackSetOperationResultsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStackSetOperationResultsResponse] =
        visitor.listStackSetOperationResults(request)
    }

    final case class ListStackSetOperationsOp(
      request: ListStackSetOperationsRequest
    ) extends CloudFormationOp[ListStackSetOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStackSetOperationsResponse] =
        visitor.listStackSetOperations(request)
    }

    final case class ListStackSetsOp(
      request: ListStackSetsRequest
    ) extends CloudFormationOp[ListStackSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStackSetsResponse] =
        visitor.listStackSets(request)
    }

    final case class ListStacksOp(
      request: ListStacksRequest
    ) extends CloudFormationOp[ListStacksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStacksResponse] =
        visitor.listStacks(request)
    }

    final case class ListTypeRegistrationsOp(
      request: ListTypeRegistrationsRequest
    ) extends CloudFormationOp[ListTypeRegistrationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTypeRegistrationsResponse] =
        visitor.listTypeRegistrations(request)
    }

    final case class ListTypeVersionsOp(
      request: ListTypeVersionsRequest
    ) extends CloudFormationOp[ListTypeVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTypeVersionsResponse] =
        visitor.listTypeVersions(request)
    }

    final case class ListTypesOp(
      request: ListTypesRequest
    ) extends CloudFormationOp[ListTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTypesResponse] =
        visitor.listTypes(request)
    }

    final case class RecordHandlerProgressOp(
      request: RecordHandlerProgressRequest
    ) extends CloudFormationOp[RecordHandlerProgressResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RecordHandlerProgressResponse] =
        visitor.recordHandlerProgress(request)
    }

    final case class RegisterTypeOp(
      request: RegisterTypeRequest
    ) extends CloudFormationOp[RegisterTypeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTypeResponse] =
        visitor.registerType(request)
    }

    final case class SetStackPolicyOp(
      request: SetStackPolicyRequest
    ) extends CloudFormationOp[SetStackPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetStackPolicyResponse] =
        visitor.setStackPolicy(request)
    }

    final case class SetTypeDefaultVersionOp(
      request: SetTypeDefaultVersionRequest
    ) extends CloudFormationOp[SetTypeDefaultVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetTypeDefaultVersionResponse] =
        visitor.setTypeDefaultVersion(request)
    }

    final case class SignalResourceOp(
      request: SignalResourceRequest
    ) extends CloudFormationOp[SignalResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SignalResourceResponse] =
        visitor.signalResource(request)
    }

    final case class StopStackSetOperationOp(
      request: StopStackSetOperationRequest
    ) extends CloudFormationOp[StopStackSetOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopStackSetOperationResponse] =
        visitor.stopStackSetOperation(request)
    }

    final case class UpdateStackOp(
      request: UpdateStackRequest
    ) extends CloudFormationOp[UpdateStackResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStackResponse] =
        visitor.updateStack(request)
    }

    final case class UpdateStackInstancesOp(
      request: UpdateStackInstancesRequest
    ) extends CloudFormationOp[UpdateStackInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStackInstancesResponse] =
        visitor.updateStackInstances(request)
    }

    final case class UpdateStackSetOp(
      request: UpdateStackSetRequest
    ) extends CloudFormationOp[UpdateStackSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStackSetResponse] =
        visitor.updateStackSet(request)
    }

    final case class UpdateTerminationProtectionOp(
      request: UpdateTerminationProtectionRequest
    ) extends CloudFormationOp[UpdateTerminationProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTerminationProtectionResponse] =
        visitor.updateTerminationProtection(request)
    }

    final case class ValidateTemplateOp(
      request: ValidateTemplateRequest
    ) extends CloudFormationOp[ValidateTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateTemplateResponse] =
        visitor.validateTemplate(request)
    }
  }

  import CloudFormationOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CloudFormationOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelUpdateStack(
    request: CancelUpdateStackRequest
  ): CloudFormationIO[CancelUpdateStackResponse] =
    FF.liftF(CancelUpdateStackOp(request))

  def continueUpdateRollback(
    request: ContinueUpdateRollbackRequest
  ): CloudFormationIO[ContinueUpdateRollbackResponse] =
    FF.liftF(ContinueUpdateRollbackOp(request))

  def createChangeSet(
    request: CreateChangeSetRequest
  ): CloudFormationIO[CreateChangeSetResponse] =
    FF.liftF(CreateChangeSetOp(request))

  def createStack(
    request: CreateStackRequest
  ): CloudFormationIO[CreateStackResponse] =
    FF.liftF(CreateStackOp(request))

  def createStackInstances(
    request: CreateStackInstancesRequest
  ): CloudFormationIO[CreateStackInstancesResponse] =
    FF.liftF(CreateStackInstancesOp(request))

  def createStackSet(
    request: CreateStackSetRequest
  ): CloudFormationIO[CreateStackSetResponse] =
    FF.liftF(CreateStackSetOp(request))

  def deleteChangeSet(
    request: DeleteChangeSetRequest
  ): CloudFormationIO[DeleteChangeSetResponse] =
    FF.liftF(DeleteChangeSetOp(request))

  def deleteStack(
    request: DeleteStackRequest
  ): CloudFormationIO[DeleteStackResponse] =
    FF.liftF(DeleteStackOp(request))

  def deleteStackInstances(
    request: DeleteStackInstancesRequest
  ): CloudFormationIO[DeleteStackInstancesResponse] =
    FF.liftF(DeleteStackInstancesOp(request))

  def deleteStackSet(
    request: DeleteStackSetRequest
  ): CloudFormationIO[DeleteStackSetResponse] =
    FF.liftF(DeleteStackSetOp(request))

  def deregisterType(
    request: DeregisterTypeRequest
  ): CloudFormationIO[DeregisterTypeResponse] =
    FF.liftF(DeregisterTypeOp(request))

  def describeAccountLimits(
    request: DescribeAccountLimitsRequest
  ): CloudFormationIO[DescribeAccountLimitsResponse] =
    FF.liftF(DescribeAccountLimitsOp(request))

  def describeChangeSet(
    request: DescribeChangeSetRequest
  ): CloudFormationIO[DescribeChangeSetResponse] =
    FF.liftF(DescribeChangeSetOp(request))

  def describeStackDriftDetectionStatus(
    request: DescribeStackDriftDetectionStatusRequest
  ): CloudFormationIO[DescribeStackDriftDetectionStatusResponse] =
    FF.liftF(DescribeStackDriftDetectionStatusOp(request))

  def describeStackEvents(
    request: DescribeStackEventsRequest
  ): CloudFormationIO[DescribeStackEventsResponse] =
    FF.liftF(DescribeStackEventsOp(request))

  def describeStackInstance(
    request: DescribeStackInstanceRequest
  ): CloudFormationIO[DescribeStackInstanceResponse] =
    FF.liftF(DescribeStackInstanceOp(request))

  def describeStackResource(
    request: DescribeStackResourceRequest
  ): CloudFormationIO[DescribeStackResourceResponse] =
    FF.liftF(DescribeStackResourceOp(request))

  def describeStackResourceDrifts(
    request: DescribeStackResourceDriftsRequest
  ): CloudFormationIO[DescribeStackResourceDriftsResponse] =
    FF.liftF(DescribeStackResourceDriftsOp(request))

  def describeStackResources(
    request: DescribeStackResourcesRequest
  ): CloudFormationIO[DescribeStackResourcesResponse] =
    FF.liftF(DescribeStackResourcesOp(request))

  def describeStackSet(
    request: DescribeStackSetRequest
  ): CloudFormationIO[DescribeStackSetResponse] =
    FF.liftF(DescribeStackSetOp(request))

  def describeStackSetOperation(
    request: DescribeStackSetOperationRequest
  ): CloudFormationIO[DescribeStackSetOperationResponse] =
    FF.liftF(DescribeStackSetOperationOp(request))

  def describeStacks(
    request: DescribeStacksRequest
  ): CloudFormationIO[DescribeStacksResponse] =
    FF.liftF(DescribeStacksOp(request))

  def describeType(
    request: DescribeTypeRequest
  ): CloudFormationIO[DescribeTypeResponse] =
    FF.liftF(DescribeTypeOp(request))

  def describeTypeRegistration(
    request: DescribeTypeRegistrationRequest
  ): CloudFormationIO[DescribeTypeRegistrationResponse] =
    FF.liftF(DescribeTypeRegistrationOp(request))

  def detectStackDrift(
    request: DetectStackDriftRequest
  ): CloudFormationIO[DetectStackDriftResponse] =
    FF.liftF(DetectStackDriftOp(request))

  def detectStackResourceDrift(
    request: DetectStackResourceDriftRequest
  ): CloudFormationIO[DetectStackResourceDriftResponse] =
    FF.liftF(DetectStackResourceDriftOp(request))

  def detectStackSetDrift(
    request: DetectStackSetDriftRequest
  ): CloudFormationIO[DetectStackSetDriftResponse] =
    FF.liftF(DetectStackSetDriftOp(request))

  def estimateTemplateCost(
    request: EstimateTemplateCostRequest
  ): CloudFormationIO[EstimateTemplateCostResponse] =
    FF.liftF(EstimateTemplateCostOp(request))

  def executeChangeSet(
    request: ExecuteChangeSetRequest
  ): CloudFormationIO[ExecuteChangeSetResponse] =
    FF.liftF(ExecuteChangeSetOp(request))

  def getStackPolicy(
    request: GetStackPolicyRequest
  ): CloudFormationIO[GetStackPolicyResponse] =
    FF.liftF(GetStackPolicyOp(request))

  def getTemplate(
    request: GetTemplateRequest
  ): CloudFormationIO[GetTemplateResponse] =
    FF.liftF(GetTemplateOp(request))

  def getTemplateSummary(
    request: GetTemplateSummaryRequest
  ): CloudFormationIO[GetTemplateSummaryResponse] =
    FF.liftF(GetTemplateSummaryOp(request))

  def listChangeSets(
    request: ListChangeSetsRequest
  ): CloudFormationIO[ListChangeSetsResponse] =
    FF.liftF(ListChangeSetsOp(request))

  def listExports(
    request: ListExportsRequest
  ): CloudFormationIO[ListExportsResponse] =
    FF.liftF(ListExportsOp(request))

  def listImports(
    request: ListImportsRequest
  ): CloudFormationIO[ListImportsResponse] =
    FF.liftF(ListImportsOp(request))

  def listStackInstances(
    request: ListStackInstancesRequest
  ): CloudFormationIO[ListStackInstancesResponse] =
    FF.liftF(ListStackInstancesOp(request))

  def listStackResources(
    request: ListStackResourcesRequest
  ): CloudFormationIO[ListStackResourcesResponse] =
    FF.liftF(ListStackResourcesOp(request))

  def listStackSetOperationResults(
    request: ListStackSetOperationResultsRequest
  ): CloudFormationIO[ListStackSetOperationResultsResponse] =
    FF.liftF(ListStackSetOperationResultsOp(request))

  def listStackSetOperations(
    request: ListStackSetOperationsRequest
  ): CloudFormationIO[ListStackSetOperationsResponse] =
    FF.liftF(ListStackSetOperationsOp(request))

  def listStackSets(
    request: ListStackSetsRequest
  ): CloudFormationIO[ListStackSetsResponse] =
    FF.liftF(ListStackSetsOp(request))

  def listStacks(
    request: ListStacksRequest
  ): CloudFormationIO[ListStacksResponse] =
    FF.liftF(ListStacksOp(request))

  def listTypeRegistrations(
    request: ListTypeRegistrationsRequest
  ): CloudFormationIO[ListTypeRegistrationsResponse] =
    FF.liftF(ListTypeRegistrationsOp(request))

  def listTypeVersions(
    request: ListTypeVersionsRequest
  ): CloudFormationIO[ListTypeVersionsResponse] =
    FF.liftF(ListTypeVersionsOp(request))

  def listTypes(
    request: ListTypesRequest
  ): CloudFormationIO[ListTypesResponse] =
    FF.liftF(ListTypesOp(request))

  def recordHandlerProgress(
    request: RecordHandlerProgressRequest
  ): CloudFormationIO[RecordHandlerProgressResponse] =
    FF.liftF(RecordHandlerProgressOp(request))

  def registerType(
    request: RegisterTypeRequest
  ): CloudFormationIO[RegisterTypeResponse] =
    FF.liftF(RegisterTypeOp(request))

  def setStackPolicy(
    request: SetStackPolicyRequest
  ): CloudFormationIO[SetStackPolicyResponse] =
    FF.liftF(SetStackPolicyOp(request))

  def setTypeDefaultVersion(
    request: SetTypeDefaultVersionRequest
  ): CloudFormationIO[SetTypeDefaultVersionResponse] =
    FF.liftF(SetTypeDefaultVersionOp(request))

  def signalResource(
    request: SignalResourceRequest
  ): CloudFormationIO[SignalResourceResponse] =
    FF.liftF(SignalResourceOp(request))

  def stopStackSetOperation(
    request: StopStackSetOperationRequest
  ): CloudFormationIO[StopStackSetOperationResponse] =
    FF.liftF(StopStackSetOperationOp(request))

  def updateStack(
    request: UpdateStackRequest
  ): CloudFormationIO[UpdateStackResponse] =
    FF.liftF(UpdateStackOp(request))

  def updateStackInstances(
    request: UpdateStackInstancesRequest
  ): CloudFormationIO[UpdateStackInstancesResponse] =
    FF.liftF(UpdateStackInstancesOp(request))

  def updateStackSet(
    request: UpdateStackSetRequest
  ): CloudFormationIO[UpdateStackSetResponse] =
    FF.liftF(UpdateStackSetOp(request))

  def updateTerminationProtection(
    request: UpdateTerminationProtectionRequest
  ): CloudFormationIO[UpdateTerminationProtectionResponse] =
    FF.liftF(UpdateTerminationProtectionOp(request))

  def validateTemplate(
    request: ValidateTemplateRequest
  ): CloudFormationIO[ValidateTemplateResponse] =
    FF.liftF(ValidateTemplateOp(request))
}
