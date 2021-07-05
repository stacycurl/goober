package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.ecs.EcsClient
import software.amazon.awssdk.services.ecs.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object ecs { module =>

  // Free monad over EcsOp
  type EcsIO[A] = FF[EcsOp, A]

  sealed trait EcsOp[A] {
    def visit[F[_]](visitor: EcsOp.Visitor[F]): F[A]
  }

  object EcsOp {
    // Given a EcsClient we can embed a EcsIO program in any algebra that understands embedding.
    implicit val EcsOpEmbeddable: Embeddable[EcsOp, EcsClient] = new Embeddable[EcsOp, EcsClient] {
      def embed[A](client: EcsClient, io: EcsIO[A]): Embedded[A] = Embedded.Ecs(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends EcsOp.Visitor[Kleisli[M, EcsClient, *]] {
        def createCapacityProvider(
          request: CreateCapacityProviderRequest
        ): Kleisli[M, EcsClient, CreateCapacityProviderResponse] =
          primitive(_.createCapacityProvider(request))

        def createCluster(
          request: CreateClusterRequest
        ): Kleisli[M, EcsClient, CreateClusterResponse] =
          primitive(_.createCluster(request))

        def createService(
          request: CreateServiceRequest
        ): Kleisli[M, EcsClient, CreateServiceResponse] =
          primitive(_.createService(request))

        def createTaskSet(
          request: CreateTaskSetRequest
        ): Kleisli[M, EcsClient, CreateTaskSetResponse] =
          primitive(_.createTaskSet(request))

        def deleteAccountSetting(
          request: DeleteAccountSettingRequest
        ): Kleisli[M, EcsClient, DeleteAccountSettingResponse] =
          primitive(_.deleteAccountSetting(request))

        def deleteAttributes(
          request: DeleteAttributesRequest
        ): Kleisli[M, EcsClient, DeleteAttributesResponse] =
          primitive(_.deleteAttributes(request))

        def deleteCapacityProvider(
          request: DeleteCapacityProviderRequest
        ): Kleisli[M, EcsClient, DeleteCapacityProviderResponse] =
          primitive(_.deleteCapacityProvider(request))

        def deleteCluster(
          request: DeleteClusterRequest
        ): Kleisli[M, EcsClient, DeleteClusterResponse] =
          primitive(_.deleteCluster(request))

        def deleteService(
          request: DeleteServiceRequest
        ): Kleisli[M, EcsClient, DeleteServiceResponse] =
          primitive(_.deleteService(request))

        def deleteTaskSet(
          request: DeleteTaskSetRequest
        ): Kleisli[M, EcsClient, DeleteTaskSetResponse] =
          primitive(_.deleteTaskSet(request))

        def deregisterContainerInstance(
          request: DeregisterContainerInstanceRequest
        ): Kleisli[M, EcsClient, DeregisterContainerInstanceResponse] =
          primitive(_.deregisterContainerInstance(request))

        def deregisterTaskDefinition(
          request: DeregisterTaskDefinitionRequest
        ): Kleisli[M, EcsClient, DeregisterTaskDefinitionResponse] =
          primitive(_.deregisterTaskDefinition(request))

        def describeCapacityProviders(
          request: DescribeCapacityProvidersRequest
        ): Kleisli[M, EcsClient, DescribeCapacityProvidersResponse] =
          primitive(_.describeCapacityProviders(request))

        def describeClusters(
          request: DescribeClustersRequest
        ): Kleisli[M, EcsClient, DescribeClustersResponse] =
          primitive(_.describeClusters(request))

        def describeContainerInstances(
          request: DescribeContainerInstancesRequest
        ): Kleisli[M, EcsClient, DescribeContainerInstancesResponse] =
          primitive(_.describeContainerInstances(request))

        def describeServices(
          request: DescribeServicesRequest
        ): Kleisli[M, EcsClient, DescribeServicesResponse] =
          primitive(_.describeServices(request))

        def describeTaskDefinition(
          request: DescribeTaskDefinitionRequest
        ): Kleisli[M, EcsClient, DescribeTaskDefinitionResponse] =
          primitive(_.describeTaskDefinition(request))

        def describeTaskSets(
          request: DescribeTaskSetsRequest
        ): Kleisli[M, EcsClient, DescribeTaskSetsResponse] =
          primitive(_.describeTaskSets(request))

        def describeTasks(
          request: DescribeTasksRequest
        ): Kleisli[M, EcsClient, DescribeTasksResponse] =
          primitive(_.describeTasks(request))

        def discoverPollEndpoint(
          request: DiscoverPollEndpointRequest
        ): Kleisli[M, EcsClient, DiscoverPollEndpointResponse] =
          primitive(_.discoverPollEndpoint(request))

        def executeCommand(
          request: ExecuteCommandRequest
        ): Kleisli[M, EcsClient, ExecuteCommandResponse] =
          primitive(_.executeCommand(request))

        def listAccountSettings(
          request: ListAccountSettingsRequest
        ): Kleisli[M, EcsClient, ListAccountSettingsResponse] =
          primitive(_.listAccountSettings(request))

        def listAttributes(
          request: ListAttributesRequest
        ): Kleisli[M, EcsClient, ListAttributesResponse] =
          primitive(_.listAttributes(request))

        def listClusters(
          request: ListClustersRequest
        ): Kleisli[M, EcsClient, ListClustersResponse] =
          primitive(_.listClusters(request))

        def listContainerInstances(
          request: ListContainerInstancesRequest
        ): Kleisli[M, EcsClient, ListContainerInstancesResponse] =
          primitive(_.listContainerInstances(request))

        def listServices(
          request: ListServicesRequest
        ): Kleisli[M, EcsClient, ListServicesResponse] =
          primitive(_.listServices(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, EcsClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTaskDefinitionFamilies(
          request: ListTaskDefinitionFamiliesRequest
        ): Kleisli[M, EcsClient, ListTaskDefinitionFamiliesResponse] =
          primitive(_.listTaskDefinitionFamilies(request))

        def listTaskDefinitions(
          request: ListTaskDefinitionsRequest
        ): Kleisli[M, EcsClient, ListTaskDefinitionsResponse] =
          primitive(_.listTaskDefinitions(request))

        def listTasks(
          request: ListTasksRequest
        ): Kleisli[M, EcsClient, ListTasksResponse] =
          primitive(_.listTasks(request))

        def putAccountSetting(
          request: PutAccountSettingRequest
        ): Kleisli[M, EcsClient, PutAccountSettingResponse] =
          primitive(_.putAccountSetting(request))

        def putAccountSettingDefault(
          request: PutAccountSettingDefaultRequest
        ): Kleisli[M, EcsClient, PutAccountSettingDefaultResponse] =
          primitive(_.putAccountSettingDefault(request))

        def putAttributes(
          request: PutAttributesRequest
        ): Kleisli[M, EcsClient, PutAttributesResponse] =
          primitive(_.putAttributes(request))

        def putClusterCapacityProviders(
          request: PutClusterCapacityProvidersRequest
        ): Kleisli[M, EcsClient, PutClusterCapacityProvidersResponse] =
          primitive(_.putClusterCapacityProviders(request))

        def registerContainerInstance(
          request: RegisterContainerInstanceRequest
        ): Kleisli[M, EcsClient, RegisterContainerInstanceResponse] =
          primitive(_.registerContainerInstance(request))

        def registerTaskDefinition(
          request: RegisterTaskDefinitionRequest
        ): Kleisli[M, EcsClient, RegisterTaskDefinitionResponse] =
          primitive(_.registerTaskDefinition(request))

        def runTask(
          request: RunTaskRequest
        ): Kleisli[M, EcsClient, RunTaskResponse] =
          primitive(_.runTask(request))

        def startTask(
          request: StartTaskRequest
        ): Kleisli[M, EcsClient, StartTaskResponse] =
          primitive(_.startTask(request))

        def stopTask(
          request: StopTaskRequest
        ): Kleisli[M, EcsClient, StopTaskResponse] =
          primitive(_.stopTask(request))

        def submitAttachmentStateChanges(
          request: SubmitAttachmentStateChangesRequest
        ): Kleisli[M, EcsClient, SubmitAttachmentStateChangesResponse] =
          primitive(_.submitAttachmentStateChanges(request))

        def submitContainerStateChange(
          request: SubmitContainerStateChangeRequest
        ): Kleisli[M, EcsClient, SubmitContainerStateChangeResponse] =
          primitive(_.submitContainerStateChange(request))

        def submitTaskStateChange(
          request: SubmitTaskStateChangeRequest
        ): Kleisli[M, EcsClient, SubmitTaskStateChangeResponse] =
          primitive(_.submitTaskStateChange(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, EcsClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, EcsClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateCapacityProvider(
          request: UpdateCapacityProviderRequest
        ): Kleisli[M, EcsClient, UpdateCapacityProviderResponse] =
          primitive(_.updateCapacityProvider(request))

        def updateCluster(
          request: UpdateClusterRequest
        ): Kleisli[M, EcsClient, UpdateClusterResponse] =
          primitive(_.updateCluster(request))

        def updateClusterSettings(
          request: UpdateClusterSettingsRequest
        ): Kleisli[M, EcsClient, UpdateClusterSettingsResponse] =
          primitive(_.updateClusterSettings(request))

        def updateContainerAgent(
          request: UpdateContainerAgentRequest
        ): Kleisli[M, EcsClient, UpdateContainerAgentResponse] =
          primitive(_.updateContainerAgent(request))

        def updateContainerInstancesState(
          request: UpdateContainerInstancesStateRequest
        ): Kleisli[M, EcsClient, UpdateContainerInstancesStateResponse] =
          primitive(_.updateContainerInstancesState(request))

        def updateService(
          request: UpdateServiceRequest
        ): Kleisli[M, EcsClient, UpdateServiceResponse] =
          primitive(_.updateService(request))

        def updateServicePrimaryTaskSet(
          request: UpdateServicePrimaryTaskSetRequest
        ): Kleisli[M, EcsClient, UpdateServicePrimaryTaskSetResponse] =
          primitive(_.updateServicePrimaryTaskSet(request))

        def updateTaskSet(
          request: UpdateTaskSetRequest
        ): Kleisli[M, EcsClient, UpdateTaskSetResponse] =
          primitive(_.updateTaskSet(request))

        def primitive[A](
          f: EcsClient => A
        ): Kleisli[M, EcsClient, A]
      }
    }

    trait Visitor[F[_]] extends (EcsOp ~> F) {
      final def apply[A](op: EcsOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createCapacityProvider(
        request: CreateCapacityProviderRequest
      ): F[CreateCapacityProviderResponse]

      def createCluster(
        request: CreateClusterRequest
      ): F[CreateClusterResponse]

      def createService(
        request: CreateServiceRequest
      ): F[CreateServiceResponse]

      def createTaskSet(
        request: CreateTaskSetRequest
      ): F[CreateTaskSetResponse]

      def deleteAccountSetting(
        request: DeleteAccountSettingRequest
      ): F[DeleteAccountSettingResponse]

      def deleteAttributes(
        request: DeleteAttributesRequest
      ): F[DeleteAttributesResponse]

      def deleteCapacityProvider(
        request: DeleteCapacityProviderRequest
      ): F[DeleteCapacityProviderResponse]

      def deleteCluster(
        request: DeleteClusterRequest
      ): F[DeleteClusterResponse]

      def deleteService(
        request: DeleteServiceRequest
      ): F[DeleteServiceResponse]

      def deleteTaskSet(
        request: DeleteTaskSetRequest
      ): F[DeleteTaskSetResponse]

      def deregisterContainerInstance(
        request: DeregisterContainerInstanceRequest
      ): F[DeregisterContainerInstanceResponse]

      def deregisterTaskDefinition(
        request: DeregisterTaskDefinitionRequest
      ): F[DeregisterTaskDefinitionResponse]

      def describeCapacityProviders(
        request: DescribeCapacityProvidersRequest
      ): F[DescribeCapacityProvidersResponse]

      def describeClusters(
        request: DescribeClustersRequest
      ): F[DescribeClustersResponse]

      def describeContainerInstances(
        request: DescribeContainerInstancesRequest
      ): F[DescribeContainerInstancesResponse]

      def describeServices(
        request: DescribeServicesRequest
      ): F[DescribeServicesResponse]

      def describeTaskDefinition(
        request: DescribeTaskDefinitionRequest
      ): F[DescribeTaskDefinitionResponse]

      def describeTaskSets(
        request: DescribeTaskSetsRequest
      ): F[DescribeTaskSetsResponse]

      def describeTasks(
        request: DescribeTasksRequest
      ): F[DescribeTasksResponse]

      def discoverPollEndpoint(
        request: DiscoverPollEndpointRequest
      ): F[DiscoverPollEndpointResponse]

      def executeCommand(
        request: ExecuteCommandRequest
      ): F[ExecuteCommandResponse]

      def listAccountSettings(
        request: ListAccountSettingsRequest
      ): F[ListAccountSettingsResponse]

      def listAttributes(
        request: ListAttributesRequest
      ): F[ListAttributesResponse]

      def listClusters(
        request: ListClustersRequest
      ): F[ListClustersResponse]

      def listContainerInstances(
        request: ListContainerInstancesRequest
      ): F[ListContainerInstancesResponse]

      def listServices(
        request: ListServicesRequest
      ): F[ListServicesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTaskDefinitionFamilies(
        request: ListTaskDefinitionFamiliesRequest
      ): F[ListTaskDefinitionFamiliesResponse]

      def listTaskDefinitions(
        request: ListTaskDefinitionsRequest
      ): F[ListTaskDefinitionsResponse]

      def listTasks(
        request: ListTasksRequest
      ): F[ListTasksResponse]

      def putAccountSetting(
        request: PutAccountSettingRequest
      ): F[PutAccountSettingResponse]

      def putAccountSettingDefault(
        request: PutAccountSettingDefaultRequest
      ): F[PutAccountSettingDefaultResponse]

      def putAttributes(
        request: PutAttributesRequest
      ): F[PutAttributesResponse]

      def putClusterCapacityProviders(
        request: PutClusterCapacityProvidersRequest
      ): F[PutClusterCapacityProvidersResponse]

      def registerContainerInstance(
        request: RegisterContainerInstanceRequest
      ): F[RegisterContainerInstanceResponse]

      def registerTaskDefinition(
        request: RegisterTaskDefinitionRequest
      ): F[RegisterTaskDefinitionResponse]

      def runTask(
        request: RunTaskRequest
      ): F[RunTaskResponse]

      def startTask(
        request: StartTaskRequest
      ): F[StartTaskResponse]

      def stopTask(
        request: StopTaskRequest
      ): F[StopTaskResponse]

      def submitAttachmentStateChanges(
        request: SubmitAttachmentStateChangesRequest
      ): F[SubmitAttachmentStateChangesResponse]

      def submitContainerStateChange(
        request: SubmitContainerStateChangeRequest
      ): F[SubmitContainerStateChangeResponse]

      def submitTaskStateChange(
        request: SubmitTaskStateChangeRequest
      ): F[SubmitTaskStateChangeResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateCapacityProvider(
        request: UpdateCapacityProviderRequest
      ): F[UpdateCapacityProviderResponse]

      def updateCluster(
        request: UpdateClusterRequest
      ): F[UpdateClusterResponse]

      def updateClusterSettings(
        request: UpdateClusterSettingsRequest
      ): F[UpdateClusterSettingsResponse]

      def updateContainerAgent(
        request: UpdateContainerAgentRequest
      ): F[UpdateContainerAgentResponse]

      def updateContainerInstancesState(
        request: UpdateContainerInstancesStateRequest
      ): F[UpdateContainerInstancesStateResponse]

      def updateService(
        request: UpdateServiceRequest
      ): F[UpdateServiceResponse]

      def updateServicePrimaryTaskSet(
        request: UpdateServicePrimaryTaskSetRequest
      ): F[UpdateServicePrimaryTaskSetResponse]

      def updateTaskSet(
        request: UpdateTaskSetRequest
      ): F[UpdateTaskSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends EcsOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateCapacityProviderOp(
      request: CreateCapacityProviderRequest
    ) extends EcsOp[CreateCapacityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCapacityProviderResponse] =
        visitor.createCapacityProvider(request)
    }

    final case class CreateClusterOp(
      request: CreateClusterRequest
    ) extends EcsOp[CreateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateClusterResponse] =
        visitor.createCluster(request)
    }

    final case class CreateServiceOp(
      request: CreateServiceRequest
    ) extends EcsOp[CreateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceResponse] =
        visitor.createService(request)
    }

    final case class CreateTaskSetOp(
      request: CreateTaskSetRequest
    ) extends EcsOp[CreateTaskSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTaskSetResponse] =
        visitor.createTaskSet(request)
    }

    final case class DeleteAccountSettingOp(
      request: DeleteAccountSettingRequest
    ) extends EcsOp[DeleteAccountSettingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountSettingResponse] =
        visitor.deleteAccountSetting(request)
    }

    final case class DeleteAttributesOp(
      request: DeleteAttributesRequest
    ) extends EcsOp[DeleteAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAttributesResponse] =
        visitor.deleteAttributes(request)
    }

    final case class DeleteCapacityProviderOp(
      request: DeleteCapacityProviderRequest
    ) extends EcsOp[DeleteCapacityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCapacityProviderResponse] =
        visitor.deleteCapacityProvider(request)
    }

    final case class DeleteClusterOp(
      request: DeleteClusterRequest
    ) extends EcsOp[DeleteClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteClusterResponse] =
        visitor.deleteCluster(request)
    }

    final case class DeleteServiceOp(
      request: DeleteServiceRequest
    ) extends EcsOp[DeleteServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceResponse] =
        visitor.deleteService(request)
    }

    final case class DeleteTaskSetOp(
      request: DeleteTaskSetRequest
    ) extends EcsOp[DeleteTaskSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTaskSetResponse] =
        visitor.deleteTaskSet(request)
    }

    final case class DeregisterContainerInstanceOp(
      request: DeregisterContainerInstanceRequest
    ) extends EcsOp[DeregisterContainerInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterContainerInstanceResponse] =
        visitor.deregisterContainerInstance(request)
    }

    final case class DeregisterTaskDefinitionOp(
      request: DeregisterTaskDefinitionRequest
    ) extends EcsOp[DeregisterTaskDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterTaskDefinitionResponse] =
        visitor.deregisterTaskDefinition(request)
    }

    final case class DescribeCapacityProvidersOp(
      request: DescribeCapacityProvidersRequest
    ) extends EcsOp[DescribeCapacityProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCapacityProvidersResponse] =
        visitor.describeCapacityProviders(request)
    }

    final case class DescribeClustersOp(
      request: DescribeClustersRequest
    ) extends EcsOp[DescribeClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClustersResponse] =
        visitor.describeClusters(request)
    }

    final case class DescribeContainerInstancesOp(
      request: DescribeContainerInstancesRequest
    ) extends EcsOp[DescribeContainerInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContainerInstancesResponse] =
        visitor.describeContainerInstances(request)
    }

    final case class DescribeServicesOp(
      request: DescribeServicesRequest
    ) extends EcsOp[DescribeServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServicesResponse] =
        visitor.describeServices(request)
    }

    final case class DescribeTaskDefinitionOp(
      request: DescribeTaskDefinitionRequest
    ) extends EcsOp[DescribeTaskDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTaskDefinitionResponse] =
        visitor.describeTaskDefinition(request)
    }

    final case class DescribeTaskSetsOp(
      request: DescribeTaskSetsRequest
    ) extends EcsOp[DescribeTaskSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTaskSetsResponse] =
        visitor.describeTaskSets(request)
    }

    final case class DescribeTasksOp(
      request: DescribeTasksRequest
    ) extends EcsOp[DescribeTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTasksResponse] =
        visitor.describeTasks(request)
    }

    final case class DiscoverPollEndpointOp(
      request: DiscoverPollEndpointRequest
    ) extends EcsOp[DiscoverPollEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DiscoverPollEndpointResponse] =
        visitor.discoverPollEndpoint(request)
    }

    final case class ExecuteCommandOp(
      request: ExecuteCommandRequest
    ) extends EcsOp[ExecuteCommandResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteCommandResponse] =
        visitor.executeCommand(request)
    }

    final case class ListAccountSettingsOp(
      request: ListAccountSettingsRequest
    ) extends EcsOp[ListAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountSettingsResponse] =
        visitor.listAccountSettings(request)
    }

    final case class ListAttributesOp(
      request: ListAttributesRequest
    ) extends EcsOp[ListAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttributesResponse] =
        visitor.listAttributes(request)
    }

    final case class ListClustersOp(
      request: ListClustersRequest
    ) extends EcsOp[ListClustersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListClustersResponse] =
        visitor.listClusters(request)
    }

    final case class ListContainerInstancesOp(
      request: ListContainerInstancesRequest
    ) extends EcsOp[ListContainerInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContainerInstancesResponse] =
        visitor.listContainerInstances(request)
    }

    final case class ListServicesOp(
      request: ListServicesRequest
    ) extends EcsOp[ListServicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServicesResponse] =
        visitor.listServices(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends EcsOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTaskDefinitionFamiliesOp(
      request: ListTaskDefinitionFamiliesRequest
    ) extends EcsOp[ListTaskDefinitionFamiliesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTaskDefinitionFamiliesResponse] =
        visitor.listTaskDefinitionFamilies(request)
    }

    final case class ListTaskDefinitionsOp(
      request: ListTaskDefinitionsRequest
    ) extends EcsOp[ListTaskDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTaskDefinitionsResponse] =
        visitor.listTaskDefinitions(request)
    }

    final case class ListTasksOp(
      request: ListTasksRequest
    ) extends EcsOp[ListTasksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTasksResponse] =
        visitor.listTasks(request)
    }

    final case class PutAccountSettingOp(
      request: PutAccountSettingRequest
    ) extends EcsOp[PutAccountSettingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountSettingResponse] =
        visitor.putAccountSetting(request)
    }

    final case class PutAccountSettingDefaultOp(
      request: PutAccountSettingDefaultRequest
    ) extends EcsOp[PutAccountSettingDefaultResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAccountSettingDefaultResponse] =
        visitor.putAccountSettingDefault(request)
    }

    final case class PutAttributesOp(
      request: PutAttributesRequest
    ) extends EcsOp[PutAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAttributesResponse] =
        visitor.putAttributes(request)
    }

    final case class PutClusterCapacityProvidersOp(
      request: PutClusterCapacityProvidersRequest
    ) extends EcsOp[PutClusterCapacityProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutClusterCapacityProvidersResponse] =
        visitor.putClusterCapacityProviders(request)
    }

    final case class RegisterContainerInstanceOp(
      request: RegisterContainerInstanceRequest
    ) extends EcsOp[RegisterContainerInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterContainerInstanceResponse] =
        visitor.registerContainerInstance(request)
    }

    final case class RegisterTaskDefinitionOp(
      request: RegisterTaskDefinitionRequest
    ) extends EcsOp[RegisterTaskDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterTaskDefinitionResponse] =
        visitor.registerTaskDefinition(request)
    }

    final case class RunTaskOp(
      request: RunTaskRequest
    ) extends EcsOp[RunTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RunTaskResponse] =
        visitor.runTask(request)
    }

    final case class StartTaskOp(
      request: StartTaskRequest
    ) extends EcsOp[StartTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTaskResponse] =
        visitor.startTask(request)
    }

    final case class StopTaskOp(
      request: StopTaskRequest
    ) extends EcsOp[StopTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopTaskResponse] =
        visitor.stopTask(request)
    }

    final case class SubmitAttachmentStateChangesOp(
      request: SubmitAttachmentStateChangesRequest
    ) extends EcsOp[SubmitAttachmentStateChangesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubmitAttachmentStateChangesResponse] =
        visitor.submitAttachmentStateChanges(request)
    }

    final case class SubmitContainerStateChangeOp(
      request: SubmitContainerStateChangeRequest
    ) extends EcsOp[SubmitContainerStateChangeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubmitContainerStateChangeResponse] =
        visitor.submitContainerStateChange(request)
    }

    final case class SubmitTaskStateChangeOp(
      request: SubmitTaskStateChangeRequest
    ) extends EcsOp[SubmitTaskStateChangeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SubmitTaskStateChangeResponse] =
        visitor.submitTaskStateChange(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends EcsOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends EcsOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateCapacityProviderOp(
      request: UpdateCapacityProviderRequest
    ) extends EcsOp[UpdateCapacityProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCapacityProviderResponse] =
        visitor.updateCapacityProvider(request)
    }

    final case class UpdateClusterOp(
      request: UpdateClusterRequest
    ) extends EcsOp[UpdateClusterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterResponse] =
        visitor.updateCluster(request)
    }

    final case class UpdateClusterSettingsOp(
      request: UpdateClusterSettingsRequest
    ) extends EcsOp[UpdateClusterSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateClusterSettingsResponse] =
        visitor.updateClusterSettings(request)
    }

    final case class UpdateContainerAgentOp(
      request: UpdateContainerAgentRequest
    ) extends EcsOp[UpdateContainerAgentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContainerAgentResponse] =
        visitor.updateContainerAgent(request)
    }

    final case class UpdateContainerInstancesStateOp(
      request: UpdateContainerInstancesStateRequest
    ) extends EcsOp[UpdateContainerInstancesStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContainerInstancesStateResponse] =
        visitor.updateContainerInstancesState(request)
    }

    final case class UpdateServiceOp(
      request: UpdateServiceRequest
    ) extends EcsOp[UpdateServiceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceResponse] =
        visitor.updateService(request)
    }

    final case class UpdateServicePrimaryTaskSetOp(
      request: UpdateServicePrimaryTaskSetRequest
    ) extends EcsOp[UpdateServicePrimaryTaskSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServicePrimaryTaskSetResponse] =
        visitor.updateServicePrimaryTaskSet(request)
    }

    final case class UpdateTaskSetOp(
      request: UpdateTaskSetRequest
    ) extends EcsOp[UpdateTaskSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTaskSetResponse] =
        visitor.updateTaskSet(request)
    }
  }

  import EcsOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[EcsOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createCapacityProvider(
    request: CreateCapacityProviderRequest
  ): EcsIO[CreateCapacityProviderResponse] =
    FF.liftF(CreateCapacityProviderOp(request))

  def createCluster(
    request: CreateClusterRequest
  ): EcsIO[CreateClusterResponse] =
    FF.liftF(CreateClusterOp(request))

  def createService(
    request: CreateServiceRequest
  ): EcsIO[CreateServiceResponse] =
    FF.liftF(CreateServiceOp(request))

  def createTaskSet(
    request: CreateTaskSetRequest
  ): EcsIO[CreateTaskSetResponse] =
    FF.liftF(CreateTaskSetOp(request))

  def deleteAccountSetting(
    request: DeleteAccountSettingRequest
  ): EcsIO[DeleteAccountSettingResponse] =
    FF.liftF(DeleteAccountSettingOp(request))

  def deleteAttributes(
    request: DeleteAttributesRequest
  ): EcsIO[DeleteAttributesResponse] =
    FF.liftF(DeleteAttributesOp(request))

  def deleteCapacityProvider(
    request: DeleteCapacityProviderRequest
  ): EcsIO[DeleteCapacityProviderResponse] =
    FF.liftF(DeleteCapacityProviderOp(request))

  def deleteCluster(
    request: DeleteClusterRequest
  ): EcsIO[DeleteClusterResponse] =
    FF.liftF(DeleteClusterOp(request))

  def deleteService(
    request: DeleteServiceRequest
  ): EcsIO[DeleteServiceResponse] =
    FF.liftF(DeleteServiceOp(request))

  def deleteTaskSet(
    request: DeleteTaskSetRequest
  ): EcsIO[DeleteTaskSetResponse] =
    FF.liftF(DeleteTaskSetOp(request))

  def deregisterContainerInstance(
    request: DeregisterContainerInstanceRequest
  ): EcsIO[DeregisterContainerInstanceResponse] =
    FF.liftF(DeregisterContainerInstanceOp(request))

  def deregisterTaskDefinition(
    request: DeregisterTaskDefinitionRequest
  ): EcsIO[DeregisterTaskDefinitionResponse] =
    FF.liftF(DeregisterTaskDefinitionOp(request))

  def describeCapacityProviders(
    request: DescribeCapacityProvidersRequest
  ): EcsIO[DescribeCapacityProvidersResponse] =
    FF.liftF(DescribeCapacityProvidersOp(request))

  def describeClusters(
    request: DescribeClustersRequest
  ): EcsIO[DescribeClustersResponse] =
    FF.liftF(DescribeClustersOp(request))

  def describeContainerInstances(
    request: DescribeContainerInstancesRequest
  ): EcsIO[DescribeContainerInstancesResponse] =
    FF.liftF(DescribeContainerInstancesOp(request))

  def describeServices(
    request: DescribeServicesRequest
  ): EcsIO[DescribeServicesResponse] =
    FF.liftF(DescribeServicesOp(request))

  def describeTaskDefinition(
    request: DescribeTaskDefinitionRequest
  ): EcsIO[DescribeTaskDefinitionResponse] =
    FF.liftF(DescribeTaskDefinitionOp(request))

  def describeTaskSets(
    request: DescribeTaskSetsRequest
  ): EcsIO[DescribeTaskSetsResponse] =
    FF.liftF(DescribeTaskSetsOp(request))

  def describeTasks(
    request: DescribeTasksRequest
  ): EcsIO[DescribeTasksResponse] =
    FF.liftF(DescribeTasksOp(request))

  def discoverPollEndpoint(
    request: DiscoverPollEndpointRequest
  ): EcsIO[DiscoverPollEndpointResponse] =
    FF.liftF(DiscoverPollEndpointOp(request))

  def executeCommand(
    request: ExecuteCommandRequest
  ): EcsIO[ExecuteCommandResponse] =
    FF.liftF(ExecuteCommandOp(request))

  def listAccountSettings(
    request: ListAccountSettingsRequest
  ): EcsIO[ListAccountSettingsResponse] =
    FF.liftF(ListAccountSettingsOp(request))

  def listAttributes(
    request: ListAttributesRequest
  ): EcsIO[ListAttributesResponse] =
    FF.liftF(ListAttributesOp(request))

  def listClusters(
    request: ListClustersRequest
  ): EcsIO[ListClustersResponse] =
    FF.liftF(ListClustersOp(request))

  def listContainerInstances(
    request: ListContainerInstancesRequest
  ): EcsIO[ListContainerInstancesResponse] =
    FF.liftF(ListContainerInstancesOp(request))

  def listServices(
    request: ListServicesRequest
  ): EcsIO[ListServicesResponse] =
    FF.liftF(ListServicesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): EcsIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTaskDefinitionFamilies(
    request: ListTaskDefinitionFamiliesRequest
  ): EcsIO[ListTaskDefinitionFamiliesResponse] =
    FF.liftF(ListTaskDefinitionFamiliesOp(request))

  def listTaskDefinitions(
    request: ListTaskDefinitionsRequest
  ): EcsIO[ListTaskDefinitionsResponse] =
    FF.liftF(ListTaskDefinitionsOp(request))

  def listTasks(
    request: ListTasksRequest
  ): EcsIO[ListTasksResponse] =
    FF.liftF(ListTasksOp(request))

  def putAccountSetting(
    request: PutAccountSettingRequest
  ): EcsIO[PutAccountSettingResponse] =
    FF.liftF(PutAccountSettingOp(request))

  def putAccountSettingDefault(
    request: PutAccountSettingDefaultRequest
  ): EcsIO[PutAccountSettingDefaultResponse] =
    FF.liftF(PutAccountSettingDefaultOp(request))

  def putAttributes(
    request: PutAttributesRequest
  ): EcsIO[PutAttributesResponse] =
    FF.liftF(PutAttributesOp(request))

  def putClusterCapacityProviders(
    request: PutClusterCapacityProvidersRequest
  ): EcsIO[PutClusterCapacityProvidersResponse] =
    FF.liftF(PutClusterCapacityProvidersOp(request))

  def registerContainerInstance(
    request: RegisterContainerInstanceRequest
  ): EcsIO[RegisterContainerInstanceResponse] =
    FF.liftF(RegisterContainerInstanceOp(request))

  def registerTaskDefinition(
    request: RegisterTaskDefinitionRequest
  ): EcsIO[RegisterTaskDefinitionResponse] =
    FF.liftF(RegisterTaskDefinitionOp(request))

  def runTask(
    request: RunTaskRequest
  ): EcsIO[RunTaskResponse] =
    FF.liftF(RunTaskOp(request))

  def startTask(
    request: StartTaskRequest
  ): EcsIO[StartTaskResponse] =
    FF.liftF(StartTaskOp(request))

  def stopTask(
    request: StopTaskRequest
  ): EcsIO[StopTaskResponse] =
    FF.liftF(StopTaskOp(request))

  def submitAttachmentStateChanges(
    request: SubmitAttachmentStateChangesRequest
  ): EcsIO[SubmitAttachmentStateChangesResponse] =
    FF.liftF(SubmitAttachmentStateChangesOp(request))

  def submitContainerStateChange(
    request: SubmitContainerStateChangeRequest
  ): EcsIO[SubmitContainerStateChangeResponse] =
    FF.liftF(SubmitContainerStateChangeOp(request))

  def submitTaskStateChange(
    request: SubmitTaskStateChangeRequest
  ): EcsIO[SubmitTaskStateChangeResponse] =
    FF.liftF(SubmitTaskStateChangeOp(request))

  def tagResource(
    request: TagResourceRequest
  ): EcsIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): EcsIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateCapacityProvider(
    request: UpdateCapacityProviderRequest
  ): EcsIO[UpdateCapacityProviderResponse] =
    FF.liftF(UpdateCapacityProviderOp(request))

  def updateCluster(
    request: UpdateClusterRequest
  ): EcsIO[UpdateClusterResponse] =
    FF.liftF(UpdateClusterOp(request))

  def updateClusterSettings(
    request: UpdateClusterSettingsRequest
  ): EcsIO[UpdateClusterSettingsResponse] =
    FF.liftF(UpdateClusterSettingsOp(request))

  def updateContainerAgent(
    request: UpdateContainerAgentRequest
  ): EcsIO[UpdateContainerAgentResponse] =
    FF.liftF(UpdateContainerAgentOp(request))

  def updateContainerInstancesState(
    request: UpdateContainerInstancesStateRequest
  ): EcsIO[UpdateContainerInstancesStateResponse] =
    FF.liftF(UpdateContainerInstancesStateOp(request))

  def updateService(
    request: UpdateServiceRequest
  ): EcsIO[UpdateServiceResponse] =
    FF.liftF(UpdateServiceOp(request))

  def updateServicePrimaryTaskSet(
    request: UpdateServicePrimaryTaskSetRequest
  ): EcsIO[UpdateServicePrimaryTaskSetResponse] =
    FF.liftF(UpdateServicePrimaryTaskSetOp(request))

  def updateTaskSet(
    request: UpdateTaskSetRequest
  ): EcsIO[UpdateTaskSetResponse] =
    FF.liftF(UpdateTaskSetOp(request))
}
