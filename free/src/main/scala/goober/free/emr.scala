package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.emr.EmrClient
import software.amazon.awssdk.services.emr.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object emr { module =>

  // Free monad over EmrOp
  type EmrIO[A] = FF[EmrOp, A]

  sealed trait EmrOp[A] {
    def visit[F[_]](visitor: EmrOp.Visitor[F]): F[A]
  }

  object EmrOp {
    // Given a EmrClient we can embed a EmrIO program in any algebra that understands embedding.
    implicit val EmrOpEmbeddable: Embeddable[EmrOp, EmrClient] = new Embeddable[EmrOp, EmrClient] {
      def embed[A](client: EmrClient, io: EmrIO[A]): Embedded[A] = Embedded.Emr(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EmrOp.Visitor[Kleisli[M, EmrClient, *]] {
        def addInstanceFleet(
          request: AddInstanceFleetRequest
        ): Kleisli[M, EmrClient, AddInstanceFleetResponse] =
          primitive(_.addInstanceFleet(request))

        def addInstanceGroups(
          request: AddInstanceGroupsRequest
        ): Kleisli[M, EmrClient, AddInstanceGroupsResponse] =
          primitive(_.addInstanceGroups(request))

        def addJobFlowSteps(
          request: AddJobFlowStepsRequest
        ): Kleisli[M, EmrClient, AddJobFlowStepsResponse] =
          primitive(_.addJobFlowSteps(request))

        def addTags(
          request: AddTagsRequest
        ): Kleisli[M, EmrClient, AddTagsResponse] =
          primitive(_.addTags(request))

        def cancelSteps(
          request: CancelStepsRequest
        ): Kleisli[M, EmrClient, CancelStepsResponse] =
          primitive(_.cancelSteps(request))

        def createSecurityConfiguration(
          request: CreateSecurityConfigurationRequest
        ): Kleisli[M, EmrClient, CreateSecurityConfigurationResponse] =
          primitive(_.createSecurityConfiguration(request))

        def createStudio(
          request: CreateStudioRequest
        ): Kleisli[M, EmrClient, CreateStudioResponse] =
          primitive(_.createStudio(request))

        def createStudioSessionMapping(
          request: CreateStudioSessionMappingRequest
        ): Kleisli[M, EmrClient, CreateStudioSessionMappingResponse] =
          primitive(_.createStudioSessionMapping(request))

        def deleteSecurityConfiguration(
          request: DeleteSecurityConfigurationRequest
        ): Kleisli[M, EmrClient, DeleteSecurityConfigurationResponse] =
          primitive(_.deleteSecurityConfiguration(request))

        def deleteStudio(
          request: DeleteStudioRequest
        ): Kleisli[M, EmrClient, DeleteStudioResponse] =
          primitive(_.deleteStudio(request))

        def deleteStudioSessionMapping(
          request: DeleteStudioSessionMappingRequest
        ): Kleisli[M, EmrClient, DeleteStudioSessionMappingResponse] =
          primitive(_.deleteStudioSessionMapping(request))

        def describeCluster(
          request: DescribeClusterRequest
        ): Kleisli[M, EmrClient, DescribeClusterResponse] =
          primitive(_.describeCluster(request))

        def describeNotebookExecution(
          request: DescribeNotebookExecutionRequest
        ): Kleisli[M, EmrClient, DescribeNotebookExecutionResponse] =
          primitive(_.describeNotebookExecution(request))

        def describeSecurityConfiguration(
          request: DescribeSecurityConfigurationRequest
        ): Kleisli[M, EmrClient, DescribeSecurityConfigurationResponse] =
          primitive(_.describeSecurityConfiguration(request))

        def describeStep(
          request: DescribeStepRequest
        ): Kleisli[M, EmrClient, DescribeStepResponse] =
          primitive(_.describeStep(request))

        def describeStudio(
          request: DescribeStudioRequest
        ): Kleisli[M, EmrClient, DescribeStudioResponse] =
          primitive(_.describeStudio(request))

        def getBlockPublicAccessConfiguration(
          request: GetBlockPublicAccessConfigurationRequest
        ): Kleisli[M, EmrClient, GetBlockPublicAccessConfigurationResponse] =
          primitive(_.getBlockPublicAccessConfiguration(request))

        def getManagedScalingPolicy(
          request: GetManagedScalingPolicyRequest
        ): Kleisli[M, EmrClient, GetManagedScalingPolicyResponse] =
          primitive(_.getManagedScalingPolicy(request))

        def getStudioSessionMapping(
          request: GetStudioSessionMappingRequest
        ): Kleisli[M, EmrClient, GetStudioSessionMappingResponse] =
          primitive(_.getStudioSessionMapping(request))

        def listBootstrapActions(
          request: ListBootstrapActionsRequest
        ): Kleisli[M, EmrClient, ListBootstrapActionsResponse] =
          primitive(_.listBootstrapActions(request))

        def listClusters(
          request: ListClustersRequest
        ): Kleisli[M, EmrClient, ListClustersResponse] =
          primitive(_.listClusters(request))

        def listInstanceFleets(
          request: ListInstanceFleetsRequest
        ): Kleisli[M, EmrClient, ListInstanceFleetsResponse] =
          primitive(_.listInstanceFleets(request))

        def listInstanceGroups(
          request: ListInstanceGroupsRequest
        ): Kleisli[M, EmrClient, ListInstanceGroupsResponse] =
          primitive(_.listInstanceGroups(request))

        def listInstances(
          request: ListInstancesRequest
        ): Kleisli[M, EmrClient, ListInstancesResponse] =
          primitive(_.listInstances(request))

        def listNotebookExecutions(
          request: ListNotebookExecutionsRequest
        ): Kleisli[M, EmrClient, ListNotebookExecutionsResponse] =
          primitive(_.listNotebookExecutions(request))

        def listSecurityConfigurations(
          request: ListSecurityConfigurationsRequest
        ): Kleisli[M, EmrClient, ListSecurityConfigurationsResponse] =
          primitive(_.listSecurityConfigurations(request))

        def listSteps(
          request: ListStepsRequest
        ): Kleisli[M, EmrClient, ListStepsResponse] =
          primitive(_.listSteps(request))

        def listStudioSessionMappings(
          request: ListStudioSessionMappingsRequest
        ): Kleisli[M, EmrClient, ListStudioSessionMappingsResponse] =
          primitive(_.listStudioSessionMappings(request))

        def listStudios(
          request: ListStudiosRequest
        ): Kleisli[M, EmrClient, ListStudiosResponse] =
          primitive(_.listStudios(request))

        def modifyCluster(
          request: ModifyClusterRequest
        ): Kleisli[M, EmrClient, ModifyClusterResponse] =
          primitive(_.modifyCluster(request))

        def modifyInstanceFleet(
          request: ModifyInstanceFleetRequest
        ): Kleisli[M, EmrClient, ModifyInstanceFleetResponse] =
          primitive(_.modifyInstanceFleet(request))

        def modifyInstanceGroups(
          request: ModifyInstanceGroupsRequest
        ): Kleisli[M, EmrClient, ModifyInstanceGroupsResponse] =
          primitive(_.modifyInstanceGroups(request))

        def putAutoScalingPolicy(
          request: PutAutoScalingPolicyRequest
        ): Kleisli[M, EmrClient, PutAutoScalingPolicyResponse] =
          primitive(_.putAutoScalingPolicy(request))

        def putBlockPublicAccessConfiguration(
          request: PutBlockPublicAccessConfigurationRequest
        ): Kleisli[M, EmrClient, PutBlockPublicAccessConfigurationResponse] =
          primitive(_.putBlockPublicAccessConfiguration(request))

        def putManagedScalingPolicy(
          request: PutManagedScalingPolicyRequest
        ): Kleisli[M, EmrClient, PutManagedScalingPolicyResponse] =
          primitive(_.putManagedScalingPolicy(request))

        def removeAutoScalingPolicy(
          request: RemoveAutoScalingPolicyRequest
        ): Kleisli[M, EmrClient, RemoveAutoScalingPolicyResponse] =
          primitive(_.removeAutoScalingPolicy(request))

        def removeManagedScalingPolicy(
          request: RemoveManagedScalingPolicyRequest
        ): Kleisli[M, EmrClient, RemoveManagedScalingPolicyResponse] =
          primitive(_.removeManagedScalingPolicy(request))

        def removeTags(
          request: RemoveTagsRequest
        ): Kleisli[M, EmrClient, RemoveTagsResponse] =
          primitive(_.removeTags(request))

        def runJobFlow(
          request: RunJobFlowRequest
        ): Kleisli[M, EmrClient, RunJobFlowResponse] =
          primitive(_.runJobFlow(request))

        def setTerminationProtection(
          request: SetTerminationProtectionRequest
        ): Kleisli[M, EmrClient, SetTerminationProtectionResponse] =
          primitive(_.setTerminationProtection(request))

        def setVisibleToAllUsers(
          request: SetVisibleToAllUsersRequest
        ): Kleisli[M, EmrClient, SetVisibleToAllUsersResponse] =
          primitive(_.setVisibleToAllUsers(request))

        def startNotebookExecution(
          request: StartNotebookExecutionRequest
        ): Kleisli[M, EmrClient, StartNotebookExecutionResponse] =
          primitive(_.startNotebookExecution(request))

        def stopNotebookExecution(
          request: StopNotebookExecutionRequest
        ): Kleisli[M, EmrClient, StopNotebookExecutionResponse] =
          primitive(_.stopNotebookExecution(request))

        def terminateJobFlows(
          request: TerminateJobFlowsRequest
        ): Kleisli[M, EmrClient, TerminateJobFlowsResponse] =
          primitive(_.terminateJobFlows(request))

        def updateStudio(
          request: UpdateStudioRequest
        ): Kleisli[M, EmrClient, UpdateStudioResponse] =
          primitive(_.updateStudio(request))

        def updateStudioSessionMapping(
          request: UpdateStudioSessionMappingRequest
        ): Kleisli[M, EmrClient, UpdateStudioSessionMappingResponse] =
          primitive(_.updateStudioSessionMapping(request))

        def primitive[A](
          f: EmrClient => A
        ): Kleisli[M, EmrClient, A]
      }
    }

    trait Visitor[F[_]] extends (EmrOp ~> F) {
      final def apply[A](op: EmrOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addInstanceFleet(
        request: AddInstanceFleetRequest
      ): F[AddInstanceFleetResponse]

      def addInstanceGroups(
        request: AddInstanceGroupsRequest
      ): F[AddInstanceGroupsResponse]

      def addJobFlowSteps(
        request: AddJobFlowStepsRequest
      ): F[AddJobFlowStepsResponse]

      def addTags(
        request: AddTagsRequest
      ): F[AddTagsResponse]

      def cancelSteps(
        request: CancelStepsRequest
      ): F[CancelStepsResponse]

      def createSecurityConfiguration(
        request: CreateSecurityConfigurationRequest
      ): F[CreateSecurityConfigurationResponse]

      def createStudio(
        request: CreateStudioRequest
      ): F[CreateStudioResponse]

      def createStudioSessionMapping(
        request: CreateStudioSessionMappingRequest
      ): F[CreateStudioSessionMappingResponse]

      def deleteSecurityConfiguration(
        request: DeleteSecurityConfigurationRequest
      ): F[DeleteSecurityConfigurationResponse]

      def deleteStudio(
        request: DeleteStudioRequest
      ): F[DeleteStudioResponse]

      def deleteStudioSessionMapping(
        request: DeleteStudioSessionMappingRequest
      ): F[DeleteStudioSessionMappingResponse]

      def describeCluster(
        request: DescribeClusterRequest
      ): F[DescribeClusterResponse]

      def describeNotebookExecution(
        request: DescribeNotebookExecutionRequest
      ): F[DescribeNotebookExecutionResponse]

      def describeSecurityConfiguration(
        request: DescribeSecurityConfigurationRequest
      ): F[DescribeSecurityConfigurationResponse]

      def describeStep(
        request: DescribeStepRequest
      ): F[DescribeStepResponse]

      def describeStudio(
        request: DescribeStudioRequest
      ): F[DescribeStudioResponse]

      def getBlockPublicAccessConfiguration(
        request: GetBlockPublicAccessConfigurationRequest
      ): F[GetBlockPublicAccessConfigurationResponse]

      def getManagedScalingPolicy(
        request: GetManagedScalingPolicyRequest
      ): F[GetManagedScalingPolicyResponse]

      def getStudioSessionMapping(
        request: GetStudioSessionMappingRequest
      ): F[GetStudioSessionMappingResponse]

      def listBootstrapActions(
        request: ListBootstrapActionsRequest
      ): F[ListBootstrapActionsResponse]

      def listClusters(
        request: ListClustersRequest
      ): F[ListClustersResponse]

      def listInstanceFleets(
        request: ListInstanceFleetsRequest
      ): F[ListInstanceFleetsResponse]

      def listInstanceGroups(
        request: ListInstanceGroupsRequest
      ): F[ListInstanceGroupsResponse]

      def listInstances(
        request: ListInstancesRequest
      ): F[ListInstancesResponse]

      def listNotebookExecutions(
        request: ListNotebookExecutionsRequest
      ): F[ListNotebookExecutionsResponse]

      def listSecurityConfigurations(
        request: ListSecurityConfigurationsRequest
      ): F[ListSecurityConfigurationsResponse]

      def listSteps(
        request: ListStepsRequest
      ): F[ListStepsResponse]

      def listStudioSessionMappings(
        request: ListStudioSessionMappingsRequest
      ): F[ListStudioSessionMappingsResponse]

      def listStudios(
        request: ListStudiosRequest
      ): F[ListStudiosResponse]

      def modifyCluster(
        request: ModifyClusterRequest
      ): F[ModifyClusterResponse]

      def modifyInstanceFleet(
        request: ModifyInstanceFleetRequest
      ): F[ModifyInstanceFleetResponse]

      def modifyInstanceGroups(
        request: ModifyInstanceGroupsRequest
      ): F[ModifyInstanceGroupsResponse]

      def putAutoScalingPolicy(
        request: PutAutoScalingPolicyRequest
      ): F[PutAutoScalingPolicyResponse]

      def putBlockPublicAccessConfiguration(
        request: PutBlockPublicAccessConfigurationRequest
      ): F[PutBlockPublicAccessConfigurationResponse]

      def putManagedScalingPolicy(
        request: PutManagedScalingPolicyRequest
      ): F[PutManagedScalingPolicyResponse]

      def removeAutoScalingPolicy(
        request: RemoveAutoScalingPolicyRequest
      ): F[RemoveAutoScalingPolicyResponse]

      def removeManagedScalingPolicy(
        request: RemoveManagedScalingPolicyRequest
      ): F[RemoveManagedScalingPolicyResponse]

      def removeTags(
        request: RemoveTagsRequest
      ): F[RemoveTagsResponse]

      def runJobFlow(
        request: RunJobFlowRequest
      ): F[RunJobFlowResponse]

      def setTerminationProtection(
        request: SetTerminationProtectionRequest
      ): F[SetTerminationProtectionResponse]

      def setVisibleToAllUsers(
        request: SetVisibleToAllUsersRequest
      ): F[SetVisibleToAllUsersResponse]

      def startNotebookExecution(
        request: StartNotebookExecutionRequest
      ): F[StartNotebookExecutionResponse]

      def stopNotebookExecution(
        request: StopNotebookExecutionRequest
      ): F[StopNotebookExecutionResponse]

      def terminateJobFlows(
        request: TerminateJobFlowsRequest
      ): F[TerminateJobFlowsResponse]

      def updateStudio(
        request: UpdateStudioRequest
      ): F[UpdateStudioResponse]

      def updateStudioSessionMapping(
        request: UpdateStudioSessionMappingRequest
      ): F[UpdateStudioSessionMappingResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EmrOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddInstanceFleetOp(
      request: AddInstanceFleetRequest
    ) extends EmrOp[AddInstanceFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddInstanceFleetResponse] =
        visitor.addInstanceFleet(request)
    }

    final case class AddInstanceGroupsOp(
      request: AddInstanceGroupsRequest
    ) extends EmrOp[AddInstanceGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddInstanceGroupsResponse] =
        visitor.addInstanceGroups(request)
    }

    final case class AddJobFlowStepsOp(
      request: AddJobFlowStepsRequest
    ) extends EmrOp[AddJobFlowStepsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddJobFlowStepsResponse] =
        visitor.addJobFlowSteps(request)
    }

    final case class AddTagsOp(
      request: AddTagsRequest
    ) extends EmrOp[AddTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsResponse] =
        visitor.addTags(request)
    }

    final case class CancelStepsOp(
      request: CancelStepsRequest
    ) extends EmrOp[CancelStepsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelStepsResponse] =
        visitor.cancelSteps(request)
    }

    final case class CreateSecurityConfigurationOp(
      request: CreateSecurityConfigurationRequest
    ) extends EmrOp[CreateSecurityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSecurityConfigurationResponse] =
        visitor.createSecurityConfiguration(request)
    }

    final case class CreateStudioOp(
      request: CreateStudioRequest
    ) extends EmrOp[CreateStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStudioResponse] =
        visitor.createStudio(request)
    }

    final case class CreateStudioSessionMappingOp(
      request: CreateStudioSessionMappingRequest
    ) extends EmrOp[CreateStudioSessionMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateStudioSessionMappingResponse] =
        visitor.createStudioSessionMapping(request)
    }

    final case class DeleteSecurityConfigurationOp(
      request: DeleteSecurityConfigurationRequest
    ) extends EmrOp[DeleteSecurityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSecurityConfigurationResponse] =
        visitor.deleteSecurityConfiguration(request)
    }

    final case class DeleteStudioOp(
      request: DeleteStudioRequest
    ) extends EmrOp[DeleteStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStudioResponse] =
        visitor.deleteStudio(request)
    }

    final case class DeleteStudioSessionMappingOp(
      request: DeleteStudioSessionMappingRequest
    ) extends EmrOp[DeleteStudioSessionMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteStudioSessionMappingResponse] =
        visitor.deleteStudioSessionMapping(request)
    }

    final case class DescribeClusterOp(
      request: DescribeClusterRequest
    ) extends EmrOp[DescribeClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClusterResponse] =
        visitor.describeCluster(request)
    }

    final case class DescribeNotebookExecutionOp(
      request: DescribeNotebookExecutionRequest
    ) extends EmrOp[DescribeNotebookExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNotebookExecutionResponse] =
        visitor.describeNotebookExecution(request)
    }

    final case class DescribeSecurityConfigurationOp(
      request: DescribeSecurityConfigurationRequest
    ) extends EmrOp[DescribeSecurityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSecurityConfigurationResponse] =
        visitor.describeSecurityConfiguration(request)
    }

    final case class DescribeStepOp(
      request: DescribeStepRequest
    ) extends EmrOp[DescribeStepResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStepResponse] =
        visitor.describeStep(request)
    }

    final case class DescribeStudioOp(
      request: DescribeStudioRequest
    ) extends EmrOp[DescribeStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeStudioResponse] =
        visitor.describeStudio(request)
    }

    final case class GetBlockPublicAccessConfigurationOp(
      request: GetBlockPublicAccessConfigurationRequest
    ) extends EmrOp[GetBlockPublicAccessConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBlockPublicAccessConfigurationResponse] =
        visitor.getBlockPublicAccessConfiguration(request)
    }

    final case class GetManagedScalingPolicyOp(
      request: GetManagedScalingPolicyRequest
    ) extends EmrOp[GetManagedScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetManagedScalingPolicyResponse] =
        visitor.getManagedScalingPolicy(request)
    }

    final case class GetStudioSessionMappingOp(
      request: GetStudioSessionMappingRequest
    ) extends EmrOp[GetStudioSessionMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetStudioSessionMappingResponse] =
        visitor.getStudioSessionMapping(request)
    }

    final case class ListBootstrapActionsOp(
      request: ListBootstrapActionsRequest
    ) extends EmrOp[ListBootstrapActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBootstrapActionsResponse] =
        visitor.listBootstrapActions(request)
    }

    final case class ListClustersOp(
      request: ListClustersRequest
    ) extends EmrOp[ListClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClustersResponse] =
        visitor.listClusters(request)
    }

    final case class ListInstanceFleetsOp(
      request: ListInstanceFleetsRequest
    ) extends EmrOp[ListInstanceFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceFleetsResponse] =
        visitor.listInstanceFleets(request)
    }

    final case class ListInstanceGroupsOp(
      request: ListInstanceGroupsRequest
    ) extends EmrOp[ListInstanceGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceGroupsResponse] =
        visitor.listInstanceGroups(request)
    }

    final case class ListInstancesOp(
      request: ListInstancesRequest
    ) extends EmrOp[ListInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstancesResponse] =
        visitor.listInstances(request)
    }

    final case class ListNotebookExecutionsOp(
      request: ListNotebookExecutionsRequest
    ) extends EmrOp[ListNotebookExecutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNotebookExecutionsResponse] =
        visitor.listNotebookExecutions(request)
    }

    final case class ListSecurityConfigurationsOp(
      request: ListSecurityConfigurationsRequest
    ) extends EmrOp[ListSecurityConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecurityConfigurationsResponse] =
        visitor.listSecurityConfigurations(request)
    }

    final case class ListStepsOp(
      request: ListStepsRequest
    ) extends EmrOp[ListStepsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStepsResponse] =
        visitor.listSteps(request)
    }

    final case class ListStudioSessionMappingsOp(
      request: ListStudioSessionMappingsRequest
    ) extends EmrOp[ListStudioSessionMappingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStudioSessionMappingsResponse] =
        visitor.listStudioSessionMappings(request)
    }

    final case class ListStudiosOp(
      request: ListStudiosRequest
    ) extends EmrOp[ListStudiosResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStudiosResponse] =
        visitor.listStudios(request)
    }

    final case class ModifyClusterOp(
      request: ModifyClusterRequest
    ) extends EmrOp[ModifyClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClusterResponse] =
        visitor.modifyCluster(request)
    }

    final case class ModifyInstanceFleetOp(
      request: ModifyInstanceFleetRequest
    ) extends EmrOp[ModifyInstanceFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceFleetResponse] =
        visitor.modifyInstanceFleet(request)
    }

    final case class ModifyInstanceGroupsOp(
      request: ModifyInstanceGroupsRequest
    ) extends EmrOp[ModifyInstanceGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyInstanceGroupsResponse] =
        visitor.modifyInstanceGroups(request)
    }

    final case class PutAutoScalingPolicyOp(
      request: PutAutoScalingPolicyRequest
    ) extends EmrOp[PutAutoScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAutoScalingPolicyResponse] =
        visitor.putAutoScalingPolicy(request)
    }

    final case class PutBlockPublicAccessConfigurationOp(
      request: PutBlockPublicAccessConfigurationRequest
    ) extends EmrOp[PutBlockPublicAccessConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutBlockPublicAccessConfigurationResponse] =
        visitor.putBlockPublicAccessConfiguration(request)
    }

    final case class PutManagedScalingPolicyOp(
      request: PutManagedScalingPolicyRequest
    ) extends EmrOp[PutManagedScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutManagedScalingPolicyResponse] =
        visitor.putManagedScalingPolicy(request)
    }

    final case class RemoveAutoScalingPolicyOp(
      request: RemoveAutoScalingPolicyRequest
    ) extends EmrOp[RemoveAutoScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveAutoScalingPolicyResponse] =
        visitor.removeAutoScalingPolicy(request)
    }

    final case class RemoveManagedScalingPolicyOp(
      request: RemoveManagedScalingPolicyRequest
    ) extends EmrOp[RemoveManagedScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveManagedScalingPolicyResponse] =
        visitor.removeManagedScalingPolicy(request)
    }

    final case class RemoveTagsOp(
      request: RemoveTagsRequest
    ) extends EmrOp[RemoveTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsResponse] =
        visitor.removeTags(request)
    }

    final case class RunJobFlowOp(
      request: RunJobFlowRequest
    ) extends EmrOp[RunJobFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RunJobFlowResponse] =
        visitor.runJobFlow(request)
    }

    final case class SetTerminationProtectionOp(
      request: SetTerminationProtectionRequest
    ) extends EmrOp[SetTerminationProtectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetTerminationProtectionResponse] =
        visitor.setTerminationProtection(request)
    }

    final case class SetVisibleToAllUsersOp(
      request: SetVisibleToAllUsersRequest
    ) extends EmrOp[SetVisibleToAllUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SetVisibleToAllUsersResponse] =
        visitor.setVisibleToAllUsers(request)
    }

    final case class StartNotebookExecutionOp(
      request: StartNotebookExecutionRequest
    ) extends EmrOp[StartNotebookExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartNotebookExecutionResponse] =
        visitor.startNotebookExecution(request)
    }

    final case class StopNotebookExecutionOp(
      request: StopNotebookExecutionRequest
    ) extends EmrOp[StopNotebookExecutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopNotebookExecutionResponse] =
        visitor.stopNotebookExecution(request)
    }

    final case class TerminateJobFlowsOp(
      request: TerminateJobFlowsRequest
    ) extends EmrOp[TerminateJobFlowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateJobFlowsResponse] =
        visitor.terminateJobFlows(request)
    }

    final case class UpdateStudioOp(
      request: UpdateStudioRequest
    ) extends EmrOp[UpdateStudioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStudioResponse] =
        visitor.updateStudio(request)
    }

    final case class UpdateStudioSessionMappingOp(
      request: UpdateStudioSessionMappingRequest
    ) extends EmrOp[UpdateStudioSessionMappingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateStudioSessionMappingResponse] =
        visitor.updateStudioSessionMapping(request)
    }
  }

  import EmrOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EmrOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addInstanceFleet(
    request: AddInstanceFleetRequest
  ): EmrIO[AddInstanceFleetResponse] =
    FF.liftF(AddInstanceFleetOp(request))

  def addInstanceGroups(
    request: AddInstanceGroupsRequest
  ): EmrIO[AddInstanceGroupsResponse] =
    FF.liftF(AddInstanceGroupsOp(request))

  def addJobFlowSteps(
    request: AddJobFlowStepsRequest
  ): EmrIO[AddJobFlowStepsResponse] =
    FF.liftF(AddJobFlowStepsOp(request))

  def addTags(
    request: AddTagsRequest
  ): EmrIO[AddTagsResponse] =
    FF.liftF(AddTagsOp(request))

  def cancelSteps(
    request: CancelStepsRequest
  ): EmrIO[CancelStepsResponse] =
    FF.liftF(CancelStepsOp(request))

  def createSecurityConfiguration(
    request: CreateSecurityConfigurationRequest
  ): EmrIO[CreateSecurityConfigurationResponse] =
    FF.liftF(CreateSecurityConfigurationOp(request))

  def createStudio(
    request: CreateStudioRequest
  ): EmrIO[CreateStudioResponse] =
    FF.liftF(CreateStudioOp(request))

  def createStudioSessionMapping(
    request: CreateStudioSessionMappingRequest
  ): EmrIO[CreateStudioSessionMappingResponse] =
    FF.liftF(CreateStudioSessionMappingOp(request))

  def deleteSecurityConfiguration(
    request: DeleteSecurityConfigurationRequest
  ): EmrIO[DeleteSecurityConfigurationResponse] =
    FF.liftF(DeleteSecurityConfigurationOp(request))

  def deleteStudio(
    request: DeleteStudioRequest
  ): EmrIO[DeleteStudioResponse] =
    FF.liftF(DeleteStudioOp(request))

  def deleteStudioSessionMapping(
    request: DeleteStudioSessionMappingRequest
  ): EmrIO[DeleteStudioSessionMappingResponse] =
    FF.liftF(DeleteStudioSessionMappingOp(request))

  def describeCluster(
    request: DescribeClusterRequest
  ): EmrIO[DescribeClusterResponse] =
    FF.liftF(DescribeClusterOp(request))

  def describeNotebookExecution(
    request: DescribeNotebookExecutionRequest
  ): EmrIO[DescribeNotebookExecutionResponse] =
    FF.liftF(DescribeNotebookExecutionOp(request))

  def describeSecurityConfiguration(
    request: DescribeSecurityConfigurationRequest
  ): EmrIO[DescribeSecurityConfigurationResponse] =
    FF.liftF(DescribeSecurityConfigurationOp(request))

  def describeStep(
    request: DescribeStepRequest
  ): EmrIO[DescribeStepResponse] =
    FF.liftF(DescribeStepOp(request))

  def describeStudio(
    request: DescribeStudioRequest
  ): EmrIO[DescribeStudioResponse] =
    FF.liftF(DescribeStudioOp(request))

  def getBlockPublicAccessConfiguration(
    request: GetBlockPublicAccessConfigurationRequest
  ): EmrIO[GetBlockPublicAccessConfigurationResponse] =
    FF.liftF(GetBlockPublicAccessConfigurationOp(request))

  def getManagedScalingPolicy(
    request: GetManagedScalingPolicyRequest
  ): EmrIO[GetManagedScalingPolicyResponse] =
    FF.liftF(GetManagedScalingPolicyOp(request))

  def getStudioSessionMapping(
    request: GetStudioSessionMappingRequest
  ): EmrIO[GetStudioSessionMappingResponse] =
    FF.liftF(GetStudioSessionMappingOp(request))

  def listBootstrapActions(
    request: ListBootstrapActionsRequest
  ): EmrIO[ListBootstrapActionsResponse] =
    FF.liftF(ListBootstrapActionsOp(request))

  def listClusters(
    request: ListClustersRequest
  ): EmrIO[ListClustersResponse] =
    FF.liftF(ListClustersOp(request))

  def listInstanceFleets(
    request: ListInstanceFleetsRequest
  ): EmrIO[ListInstanceFleetsResponse] =
    FF.liftF(ListInstanceFleetsOp(request))

  def listInstanceGroups(
    request: ListInstanceGroupsRequest
  ): EmrIO[ListInstanceGroupsResponse] =
    FF.liftF(ListInstanceGroupsOp(request))

  def listInstances(
    request: ListInstancesRequest
  ): EmrIO[ListInstancesResponse] =
    FF.liftF(ListInstancesOp(request))

  def listNotebookExecutions(
    request: ListNotebookExecutionsRequest
  ): EmrIO[ListNotebookExecutionsResponse] =
    FF.liftF(ListNotebookExecutionsOp(request))

  def listSecurityConfigurations(
    request: ListSecurityConfigurationsRequest
  ): EmrIO[ListSecurityConfigurationsResponse] =
    FF.liftF(ListSecurityConfigurationsOp(request))

  def listSteps(
    request: ListStepsRequest
  ): EmrIO[ListStepsResponse] =
    FF.liftF(ListStepsOp(request))

  def listStudioSessionMappings(
    request: ListStudioSessionMappingsRequest
  ): EmrIO[ListStudioSessionMappingsResponse] =
    FF.liftF(ListStudioSessionMappingsOp(request))

  def listStudios(
    request: ListStudiosRequest
  ): EmrIO[ListStudiosResponse] =
    FF.liftF(ListStudiosOp(request))

  def modifyCluster(
    request: ModifyClusterRequest
  ): EmrIO[ModifyClusterResponse] =
    FF.liftF(ModifyClusterOp(request))

  def modifyInstanceFleet(
    request: ModifyInstanceFleetRequest
  ): EmrIO[ModifyInstanceFleetResponse] =
    FF.liftF(ModifyInstanceFleetOp(request))

  def modifyInstanceGroups(
    request: ModifyInstanceGroupsRequest
  ): EmrIO[ModifyInstanceGroupsResponse] =
    FF.liftF(ModifyInstanceGroupsOp(request))

  def putAutoScalingPolicy(
    request: PutAutoScalingPolicyRequest
  ): EmrIO[PutAutoScalingPolicyResponse] =
    FF.liftF(PutAutoScalingPolicyOp(request))

  def putBlockPublicAccessConfiguration(
    request: PutBlockPublicAccessConfigurationRequest
  ): EmrIO[PutBlockPublicAccessConfigurationResponse] =
    FF.liftF(PutBlockPublicAccessConfigurationOp(request))

  def putManagedScalingPolicy(
    request: PutManagedScalingPolicyRequest
  ): EmrIO[PutManagedScalingPolicyResponse] =
    FF.liftF(PutManagedScalingPolicyOp(request))

  def removeAutoScalingPolicy(
    request: RemoveAutoScalingPolicyRequest
  ): EmrIO[RemoveAutoScalingPolicyResponse] =
    FF.liftF(RemoveAutoScalingPolicyOp(request))

  def removeManagedScalingPolicy(
    request: RemoveManagedScalingPolicyRequest
  ): EmrIO[RemoveManagedScalingPolicyResponse] =
    FF.liftF(RemoveManagedScalingPolicyOp(request))

  def removeTags(
    request: RemoveTagsRequest
  ): EmrIO[RemoveTagsResponse] =
    FF.liftF(RemoveTagsOp(request))

  def runJobFlow(
    request: RunJobFlowRequest
  ): EmrIO[RunJobFlowResponse] =
    FF.liftF(RunJobFlowOp(request))

  def setTerminationProtection(
    request: SetTerminationProtectionRequest
  ): EmrIO[SetTerminationProtectionResponse] =
    FF.liftF(SetTerminationProtectionOp(request))

  def setVisibleToAllUsers(
    request: SetVisibleToAllUsersRequest
  ): EmrIO[SetVisibleToAllUsersResponse] =
    FF.liftF(SetVisibleToAllUsersOp(request))

  def startNotebookExecution(
    request: StartNotebookExecutionRequest
  ): EmrIO[StartNotebookExecutionResponse] =
    FF.liftF(StartNotebookExecutionOp(request))

  def stopNotebookExecution(
    request: StopNotebookExecutionRequest
  ): EmrIO[StopNotebookExecutionResponse] =
    FF.liftF(StopNotebookExecutionOp(request))

  def terminateJobFlows(
    request: TerminateJobFlowsRequest
  ): EmrIO[TerminateJobFlowsResponse] =
    FF.liftF(TerminateJobFlowsOp(request))

  def updateStudio(
    request: UpdateStudioRequest
  ): EmrIO[UpdateStudioResponse] =
    FF.liftF(UpdateStudioOp(request))

  def updateStudioSessionMapping(
    request: UpdateStudioSessionMappingRequest
  ): EmrIO[UpdateStudioSessionMappingResponse] =
    FF.liftF(UpdateStudioSessionMappingOp(request))
}
