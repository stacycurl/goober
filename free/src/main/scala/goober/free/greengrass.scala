package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.greengrass.GreengrassClient
import software.amazon.awssdk.services.greengrass.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object greengrass { module =>

  // Free monad over GreengrassOp
  type GreengrassIO[A] = FF[GreengrassOp, A]

  sealed trait GreengrassOp[A] {
    def visit[F[_]](visitor: GreengrassOp.Visitor[F]): F[A]
  }

  object GreengrassOp {
    // Given a GreengrassClient we can embed a GreengrassIO program in any algebra that understands embedding.
    implicit val GreengrassOpEmbeddable: Embeddable[GreengrassOp, GreengrassClient] = new Embeddable[GreengrassOp, GreengrassClient] {
      def embed[A](client: GreengrassClient, io: GreengrassIO[A]): Embedded[A] = Embedded.Greengrass(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GreengrassOp.Visitor[Kleisli[M, GreengrassClient, *]] {
        def associateRoleToGroup(
          request: AssociateRoleToGroupRequest
        ): Kleisli[M, GreengrassClient, AssociateRoleToGroupResponse] =
          primitive(_.associateRoleToGroup(request))

        def associateServiceRoleToAccount(
          request: AssociateServiceRoleToAccountRequest
        ): Kleisli[M, GreengrassClient, AssociateServiceRoleToAccountResponse] =
          primitive(_.associateServiceRoleToAccount(request))

        def createConnectorDefinition(
          request: CreateConnectorDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateConnectorDefinitionResponse] =
          primitive(_.createConnectorDefinition(request))

        def createConnectorDefinitionVersion(
          request: CreateConnectorDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateConnectorDefinitionVersionResponse] =
          primitive(_.createConnectorDefinitionVersion(request))

        def createCoreDefinition(
          request: CreateCoreDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateCoreDefinitionResponse] =
          primitive(_.createCoreDefinition(request))

        def createCoreDefinitionVersion(
          request: CreateCoreDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateCoreDefinitionVersionResponse] =
          primitive(_.createCoreDefinitionVersion(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, GreengrassClient, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def createDeviceDefinition(
          request: CreateDeviceDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateDeviceDefinitionResponse] =
          primitive(_.createDeviceDefinition(request))

        def createDeviceDefinitionVersion(
          request: CreateDeviceDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateDeviceDefinitionVersionResponse] =
          primitive(_.createDeviceDefinitionVersion(request))

        def createFunctionDefinition(
          request: CreateFunctionDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateFunctionDefinitionResponse] =
          primitive(_.createFunctionDefinition(request))

        def createFunctionDefinitionVersion(
          request: CreateFunctionDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateFunctionDefinitionVersionResponse] =
          primitive(_.createFunctionDefinitionVersion(request))

        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, GreengrassClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def createGroupCertificateAuthority(
          request: CreateGroupCertificateAuthorityRequest
        ): Kleisli[M, GreengrassClient, CreateGroupCertificateAuthorityResponse] =
          primitive(_.createGroupCertificateAuthority(request))

        def createGroupVersion(
          request: CreateGroupVersionRequest
        ): Kleisli[M, GreengrassClient, CreateGroupVersionResponse] =
          primitive(_.createGroupVersion(request))

        def createLoggerDefinition(
          request: CreateLoggerDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateLoggerDefinitionResponse] =
          primitive(_.createLoggerDefinition(request))

        def createLoggerDefinitionVersion(
          request: CreateLoggerDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateLoggerDefinitionVersionResponse] =
          primitive(_.createLoggerDefinitionVersion(request))

        def createResourceDefinition(
          request: CreateResourceDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateResourceDefinitionResponse] =
          primitive(_.createResourceDefinition(request))

        def createResourceDefinitionVersion(
          request: CreateResourceDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateResourceDefinitionVersionResponse] =
          primitive(_.createResourceDefinitionVersion(request))

        def createSoftwareUpdateJob(
          request: CreateSoftwareUpdateJobRequest
        ): Kleisli[M, GreengrassClient, CreateSoftwareUpdateJobResponse] =
          primitive(_.createSoftwareUpdateJob(request))

        def createSubscriptionDefinition(
          request: CreateSubscriptionDefinitionRequest
        ): Kleisli[M, GreengrassClient, CreateSubscriptionDefinitionResponse] =
          primitive(_.createSubscriptionDefinition(request))

        def createSubscriptionDefinitionVersion(
          request: CreateSubscriptionDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, CreateSubscriptionDefinitionVersionResponse] =
          primitive(_.createSubscriptionDefinitionVersion(request))

        def deleteConnectorDefinition(
          request: DeleteConnectorDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteConnectorDefinitionResponse] =
          primitive(_.deleteConnectorDefinition(request))

        def deleteCoreDefinition(
          request: DeleteCoreDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteCoreDefinitionResponse] =
          primitive(_.deleteCoreDefinition(request))

        def deleteDeviceDefinition(
          request: DeleteDeviceDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteDeviceDefinitionResponse] =
          primitive(_.deleteDeviceDefinition(request))

        def deleteFunctionDefinition(
          request: DeleteFunctionDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteFunctionDefinitionResponse] =
          primitive(_.deleteFunctionDefinition(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, GreengrassClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def deleteLoggerDefinition(
          request: DeleteLoggerDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteLoggerDefinitionResponse] =
          primitive(_.deleteLoggerDefinition(request))

        def deleteResourceDefinition(
          request: DeleteResourceDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteResourceDefinitionResponse] =
          primitive(_.deleteResourceDefinition(request))

        def deleteSubscriptionDefinition(
          request: DeleteSubscriptionDefinitionRequest
        ): Kleisli[M, GreengrassClient, DeleteSubscriptionDefinitionResponse] =
          primitive(_.deleteSubscriptionDefinition(request))

        def disassociateRoleFromGroup(
          request: DisassociateRoleFromGroupRequest
        ): Kleisli[M, GreengrassClient, DisassociateRoleFromGroupResponse] =
          primitive(_.disassociateRoleFromGroup(request))

        def disassociateServiceRoleFromAccount(
          request: DisassociateServiceRoleFromAccountRequest
        ): Kleisli[M, GreengrassClient, DisassociateServiceRoleFromAccountResponse] =
          primitive(_.disassociateServiceRoleFromAccount(request))

        def getAssociatedRole(
          request: GetAssociatedRoleRequest
        ): Kleisli[M, GreengrassClient, GetAssociatedRoleResponse] =
          primitive(_.getAssociatedRole(request))

        def getBulkDeploymentStatus(
          request: GetBulkDeploymentStatusRequest
        ): Kleisli[M, GreengrassClient, GetBulkDeploymentStatusResponse] =
          primitive(_.getBulkDeploymentStatus(request))

        def getConnectivityInfo(
          request: GetConnectivityInfoRequest
        ): Kleisli[M, GreengrassClient, GetConnectivityInfoResponse] =
          primitive(_.getConnectivityInfo(request))

        def getConnectorDefinition(
          request: GetConnectorDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetConnectorDefinitionResponse] =
          primitive(_.getConnectorDefinition(request))

        def getConnectorDefinitionVersion(
          request: GetConnectorDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetConnectorDefinitionVersionResponse] =
          primitive(_.getConnectorDefinitionVersion(request))

        def getCoreDefinition(
          request: GetCoreDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetCoreDefinitionResponse] =
          primitive(_.getCoreDefinition(request))

        def getCoreDefinitionVersion(
          request: GetCoreDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetCoreDefinitionVersionResponse] =
          primitive(_.getCoreDefinitionVersion(request))

        def getDeploymentStatus(
          request: GetDeploymentStatusRequest
        ): Kleisli[M, GreengrassClient, GetDeploymentStatusResponse] =
          primitive(_.getDeploymentStatus(request))

        def getDeviceDefinition(
          request: GetDeviceDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetDeviceDefinitionResponse] =
          primitive(_.getDeviceDefinition(request))

        def getDeviceDefinitionVersion(
          request: GetDeviceDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetDeviceDefinitionVersionResponse] =
          primitive(_.getDeviceDefinitionVersion(request))

        def getFunctionDefinition(
          request: GetFunctionDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetFunctionDefinitionResponse] =
          primitive(_.getFunctionDefinition(request))

        def getFunctionDefinitionVersion(
          request: GetFunctionDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetFunctionDefinitionVersionResponse] =
          primitive(_.getFunctionDefinitionVersion(request))

        def getGroup(
          request: GetGroupRequest
        ): Kleisli[M, GreengrassClient, GetGroupResponse] =
          primitive(_.getGroup(request))

        def getGroupCertificateAuthority(
          request: GetGroupCertificateAuthorityRequest
        ): Kleisli[M, GreengrassClient, GetGroupCertificateAuthorityResponse] =
          primitive(_.getGroupCertificateAuthority(request))

        def getGroupCertificateConfiguration(
          request: GetGroupCertificateConfigurationRequest
        ): Kleisli[M, GreengrassClient, GetGroupCertificateConfigurationResponse] =
          primitive(_.getGroupCertificateConfiguration(request))

        def getGroupVersion(
          request: GetGroupVersionRequest
        ): Kleisli[M, GreengrassClient, GetGroupVersionResponse] =
          primitive(_.getGroupVersion(request))

        def getLoggerDefinition(
          request: GetLoggerDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetLoggerDefinitionResponse] =
          primitive(_.getLoggerDefinition(request))

        def getLoggerDefinitionVersion(
          request: GetLoggerDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetLoggerDefinitionVersionResponse] =
          primitive(_.getLoggerDefinitionVersion(request))

        def getResourceDefinition(
          request: GetResourceDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetResourceDefinitionResponse] =
          primitive(_.getResourceDefinition(request))

        def getResourceDefinitionVersion(
          request: GetResourceDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetResourceDefinitionVersionResponse] =
          primitive(_.getResourceDefinitionVersion(request))

        def getServiceRoleForAccount(
          request: GetServiceRoleForAccountRequest
        ): Kleisli[M, GreengrassClient, GetServiceRoleForAccountResponse] =
          primitive(_.getServiceRoleForAccount(request))

        def getSubscriptionDefinition(
          request: GetSubscriptionDefinitionRequest
        ): Kleisli[M, GreengrassClient, GetSubscriptionDefinitionResponse] =
          primitive(_.getSubscriptionDefinition(request))

        def getSubscriptionDefinitionVersion(
          request: GetSubscriptionDefinitionVersionRequest
        ): Kleisli[M, GreengrassClient, GetSubscriptionDefinitionVersionResponse] =
          primitive(_.getSubscriptionDefinitionVersion(request))

        def getThingRuntimeConfiguration(
          request: GetThingRuntimeConfigurationRequest
        ): Kleisli[M, GreengrassClient, GetThingRuntimeConfigurationResponse] =
          primitive(_.getThingRuntimeConfiguration(request))

        def listBulkDeploymentDetailedReports(
          request: ListBulkDeploymentDetailedReportsRequest
        ): Kleisli[M, GreengrassClient, ListBulkDeploymentDetailedReportsResponse] =
          primitive(_.listBulkDeploymentDetailedReports(request))

        def listBulkDeployments(
          request: ListBulkDeploymentsRequest
        ): Kleisli[M, GreengrassClient, ListBulkDeploymentsResponse] =
          primitive(_.listBulkDeployments(request))

        def listConnectorDefinitionVersions(
          request: ListConnectorDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListConnectorDefinitionVersionsResponse] =
          primitive(_.listConnectorDefinitionVersions(request))

        def listConnectorDefinitions(
          request: ListConnectorDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListConnectorDefinitionsResponse] =
          primitive(_.listConnectorDefinitions(request))

        def listCoreDefinitionVersions(
          request: ListCoreDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListCoreDefinitionVersionsResponse] =
          primitive(_.listCoreDefinitionVersions(request))

        def listCoreDefinitions(
          request: ListCoreDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListCoreDefinitionsResponse] =
          primitive(_.listCoreDefinitions(request))

        def listDeployments(
          request: ListDeploymentsRequest
        ): Kleisli[M, GreengrassClient, ListDeploymentsResponse] =
          primitive(_.listDeployments(request))

        def listDeviceDefinitionVersions(
          request: ListDeviceDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListDeviceDefinitionVersionsResponse] =
          primitive(_.listDeviceDefinitionVersions(request))

        def listDeviceDefinitions(
          request: ListDeviceDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListDeviceDefinitionsResponse] =
          primitive(_.listDeviceDefinitions(request))

        def listFunctionDefinitionVersions(
          request: ListFunctionDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListFunctionDefinitionVersionsResponse] =
          primitive(_.listFunctionDefinitionVersions(request))

        def listFunctionDefinitions(
          request: ListFunctionDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListFunctionDefinitionsResponse] =
          primitive(_.listFunctionDefinitions(request))

        def listGroupCertificateAuthorities(
          request: ListGroupCertificateAuthoritiesRequest
        ): Kleisli[M, GreengrassClient, ListGroupCertificateAuthoritiesResponse] =
          primitive(_.listGroupCertificateAuthorities(request))

        def listGroupVersions(
          request: ListGroupVersionsRequest
        ): Kleisli[M, GreengrassClient, ListGroupVersionsResponse] =
          primitive(_.listGroupVersions(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, GreengrassClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def listLoggerDefinitionVersions(
          request: ListLoggerDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListLoggerDefinitionVersionsResponse] =
          primitive(_.listLoggerDefinitionVersions(request))

        def listLoggerDefinitions(
          request: ListLoggerDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListLoggerDefinitionsResponse] =
          primitive(_.listLoggerDefinitions(request))

        def listResourceDefinitionVersions(
          request: ListResourceDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListResourceDefinitionVersionsResponse] =
          primitive(_.listResourceDefinitionVersions(request))

        def listResourceDefinitions(
          request: ListResourceDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListResourceDefinitionsResponse] =
          primitive(_.listResourceDefinitions(request))

        def listSubscriptionDefinitionVersions(
          request: ListSubscriptionDefinitionVersionsRequest
        ): Kleisli[M, GreengrassClient, ListSubscriptionDefinitionVersionsResponse] =
          primitive(_.listSubscriptionDefinitionVersions(request))

        def listSubscriptionDefinitions(
          request: ListSubscriptionDefinitionsRequest
        ): Kleisli[M, GreengrassClient, ListSubscriptionDefinitionsResponse] =
          primitive(_.listSubscriptionDefinitions(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, GreengrassClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def resetDeployments(
          request: ResetDeploymentsRequest
        ): Kleisli[M, GreengrassClient, ResetDeploymentsResponse] =
          primitive(_.resetDeployments(request))

        def startBulkDeployment(
          request: StartBulkDeploymentRequest
        ): Kleisli[M, GreengrassClient, StartBulkDeploymentResponse] =
          primitive(_.startBulkDeployment(request))

        def stopBulkDeployment(
          request: StopBulkDeploymentRequest
        ): Kleisli[M, GreengrassClient, StopBulkDeploymentResponse] =
          primitive(_.stopBulkDeployment(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GreengrassClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GreengrassClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateConnectivityInfo(
          request: UpdateConnectivityInfoRequest
        ): Kleisli[M, GreengrassClient, UpdateConnectivityInfoResponse] =
          primitive(_.updateConnectivityInfo(request))

        def updateConnectorDefinition(
          request: UpdateConnectorDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateConnectorDefinitionResponse] =
          primitive(_.updateConnectorDefinition(request))

        def updateCoreDefinition(
          request: UpdateCoreDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateCoreDefinitionResponse] =
          primitive(_.updateCoreDefinition(request))

        def updateDeviceDefinition(
          request: UpdateDeviceDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateDeviceDefinitionResponse] =
          primitive(_.updateDeviceDefinition(request))

        def updateFunctionDefinition(
          request: UpdateFunctionDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateFunctionDefinitionResponse] =
          primitive(_.updateFunctionDefinition(request))

        def updateGroup(
          request: UpdateGroupRequest
        ): Kleisli[M, GreengrassClient, UpdateGroupResponse] =
          primitive(_.updateGroup(request))

        def updateGroupCertificateConfiguration(
          request: UpdateGroupCertificateConfigurationRequest
        ): Kleisli[M, GreengrassClient, UpdateGroupCertificateConfigurationResponse] =
          primitive(_.updateGroupCertificateConfiguration(request))

        def updateLoggerDefinition(
          request: UpdateLoggerDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateLoggerDefinitionResponse] =
          primitive(_.updateLoggerDefinition(request))

        def updateResourceDefinition(
          request: UpdateResourceDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateResourceDefinitionResponse] =
          primitive(_.updateResourceDefinition(request))

        def updateSubscriptionDefinition(
          request: UpdateSubscriptionDefinitionRequest
        ): Kleisli[M, GreengrassClient, UpdateSubscriptionDefinitionResponse] =
          primitive(_.updateSubscriptionDefinition(request))

        def updateThingRuntimeConfiguration(
          request: UpdateThingRuntimeConfigurationRequest
        ): Kleisli[M, GreengrassClient, UpdateThingRuntimeConfigurationResponse] =
          primitive(_.updateThingRuntimeConfiguration(request))

        def primitive[A](
          f: GreengrassClient => A
        ): Kleisli[M, GreengrassClient, A]
      }
    }

    trait Visitor[F[_]] extends (GreengrassOp ~> F) {
      final def apply[A](op: GreengrassOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateRoleToGroup(
        request: AssociateRoleToGroupRequest
      ): F[AssociateRoleToGroupResponse]

      def associateServiceRoleToAccount(
        request: AssociateServiceRoleToAccountRequest
      ): F[AssociateServiceRoleToAccountResponse]

      def createConnectorDefinition(
        request: CreateConnectorDefinitionRequest
      ): F[CreateConnectorDefinitionResponse]

      def createConnectorDefinitionVersion(
        request: CreateConnectorDefinitionVersionRequest
      ): F[CreateConnectorDefinitionVersionResponse]

      def createCoreDefinition(
        request: CreateCoreDefinitionRequest
      ): F[CreateCoreDefinitionResponse]

      def createCoreDefinitionVersion(
        request: CreateCoreDefinitionVersionRequest
      ): F[CreateCoreDefinitionVersionResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def createDeviceDefinition(
        request: CreateDeviceDefinitionRequest
      ): F[CreateDeviceDefinitionResponse]

      def createDeviceDefinitionVersion(
        request: CreateDeviceDefinitionVersionRequest
      ): F[CreateDeviceDefinitionVersionResponse]

      def createFunctionDefinition(
        request: CreateFunctionDefinitionRequest
      ): F[CreateFunctionDefinitionResponse]

      def createFunctionDefinitionVersion(
        request: CreateFunctionDefinitionVersionRequest
      ): F[CreateFunctionDefinitionVersionResponse]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def createGroupCertificateAuthority(
        request: CreateGroupCertificateAuthorityRequest
      ): F[CreateGroupCertificateAuthorityResponse]

      def createGroupVersion(
        request: CreateGroupVersionRequest
      ): F[CreateGroupVersionResponse]

      def createLoggerDefinition(
        request: CreateLoggerDefinitionRequest
      ): F[CreateLoggerDefinitionResponse]

      def createLoggerDefinitionVersion(
        request: CreateLoggerDefinitionVersionRequest
      ): F[CreateLoggerDefinitionVersionResponse]

      def createResourceDefinition(
        request: CreateResourceDefinitionRequest
      ): F[CreateResourceDefinitionResponse]

      def createResourceDefinitionVersion(
        request: CreateResourceDefinitionVersionRequest
      ): F[CreateResourceDefinitionVersionResponse]

      def createSoftwareUpdateJob(
        request: CreateSoftwareUpdateJobRequest
      ): F[CreateSoftwareUpdateJobResponse]

      def createSubscriptionDefinition(
        request: CreateSubscriptionDefinitionRequest
      ): F[CreateSubscriptionDefinitionResponse]

      def createSubscriptionDefinitionVersion(
        request: CreateSubscriptionDefinitionVersionRequest
      ): F[CreateSubscriptionDefinitionVersionResponse]

      def deleteConnectorDefinition(
        request: DeleteConnectorDefinitionRequest
      ): F[DeleteConnectorDefinitionResponse]

      def deleteCoreDefinition(
        request: DeleteCoreDefinitionRequest
      ): F[DeleteCoreDefinitionResponse]

      def deleteDeviceDefinition(
        request: DeleteDeviceDefinitionRequest
      ): F[DeleteDeviceDefinitionResponse]

      def deleteFunctionDefinition(
        request: DeleteFunctionDefinitionRequest
      ): F[DeleteFunctionDefinitionResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def deleteLoggerDefinition(
        request: DeleteLoggerDefinitionRequest
      ): F[DeleteLoggerDefinitionResponse]

      def deleteResourceDefinition(
        request: DeleteResourceDefinitionRequest
      ): F[DeleteResourceDefinitionResponse]

      def deleteSubscriptionDefinition(
        request: DeleteSubscriptionDefinitionRequest
      ): F[DeleteSubscriptionDefinitionResponse]

      def disassociateRoleFromGroup(
        request: DisassociateRoleFromGroupRequest
      ): F[DisassociateRoleFromGroupResponse]

      def disassociateServiceRoleFromAccount(
        request: DisassociateServiceRoleFromAccountRequest
      ): F[DisassociateServiceRoleFromAccountResponse]

      def getAssociatedRole(
        request: GetAssociatedRoleRequest
      ): F[GetAssociatedRoleResponse]

      def getBulkDeploymentStatus(
        request: GetBulkDeploymentStatusRequest
      ): F[GetBulkDeploymentStatusResponse]

      def getConnectivityInfo(
        request: GetConnectivityInfoRequest
      ): F[GetConnectivityInfoResponse]

      def getConnectorDefinition(
        request: GetConnectorDefinitionRequest
      ): F[GetConnectorDefinitionResponse]

      def getConnectorDefinitionVersion(
        request: GetConnectorDefinitionVersionRequest
      ): F[GetConnectorDefinitionVersionResponse]

      def getCoreDefinition(
        request: GetCoreDefinitionRequest
      ): F[GetCoreDefinitionResponse]

      def getCoreDefinitionVersion(
        request: GetCoreDefinitionVersionRequest
      ): F[GetCoreDefinitionVersionResponse]

      def getDeploymentStatus(
        request: GetDeploymentStatusRequest
      ): F[GetDeploymentStatusResponse]

      def getDeviceDefinition(
        request: GetDeviceDefinitionRequest
      ): F[GetDeviceDefinitionResponse]

      def getDeviceDefinitionVersion(
        request: GetDeviceDefinitionVersionRequest
      ): F[GetDeviceDefinitionVersionResponse]

      def getFunctionDefinition(
        request: GetFunctionDefinitionRequest
      ): F[GetFunctionDefinitionResponse]

      def getFunctionDefinitionVersion(
        request: GetFunctionDefinitionVersionRequest
      ): F[GetFunctionDefinitionVersionResponse]

      def getGroup(
        request: GetGroupRequest
      ): F[GetGroupResponse]

      def getGroupCertificateAuthority(
        request: GetGroupCertificateAuthorityRequest
      ): F[GetGroupCertificateAuthorityResponse]

      def getGroupCertificateConfiguration(
        request: GetGroupCertificateConfigurationRequest
      ): F[GetGroupCertificateConfigurationResponse]

      def getGroupVersion(
        request: GetGroupVersionRequest
      ): F[GetGroupVersionResponse]

      def getLoggerDefinition(
        request: GetLoggerDefinitionRequest
      ): F[GetLoggerDefinitionResponse]

      def getLoggerDefinitionVersion(
        request: GetLoggerDefinitionVersionRequest
      ): F[GetLoggerDefinitionVersionResponse]

      def getResourceDefinition(
        request: GetResourceDefinitionRequest
      ): F[GetResourceDefinitionResponse]

      def getResourceDefinitionVersion(
        request: GetResourceDefinitionVersionRequest
      ): F[GetResourceDefinitionVersionResponse]

      def getServiceRoleForAccount(
        request: GetServiceRoleForAccountRequest
      ): F[GetServiceRoleForAccountResponse]

      def getSubscriptionDefinition(
        request: GetSubscriptionDefinitionRequest
      ): F[GetSubscriptionDefinitionResponse]

      def getSubscriptionDefinitionVersion(
        request: GetSubscriptionDefinitionVersionRequest
      ): F[GetSubscriptionDefinitionVersionResponse]

      def getThingRuntimeConfiguration(
        request: GetThingRuntimeConfigurationRequest
      ): F[GetThingRuntimeConfigurationResponse]

      def listBulkDeploymentDetailedReports(
        request: ListBulkDeploymentDetailedReportsRequest
      ): F[ListBulkDeploymentDetailedReportsResponse]

      def listBulkDeployments(
        request: ListBulkDeploymentsRequest
      ): F[ListBulkDeploymentsResponse]

      def listConnectorDefinitionVersions(
        request: ListConnectorDefinitionVersionsRequest
      ): F[ListConnectorDefinitionVersionsResponse]

      def listConnectorDefinitions(
        request: ListConnectorDefinitionsRequest
      ): F[ListConnectorDefinitionsResponse]

      def listCoreDefinitionVersions(
        request: ListCoreDefinitionVersionsRequest
      ): F[ListCoreDefinitionVersionsResponse]

      def listCoreDefinitions(
        request: ListCoreDefinitionsRequest
      ): F[ListCoreDefinitionsResponse]

      def listDeployments(
        request: ListDeploymentsRequest
      ): F[ListDeploymentsResponse]

      def listDeviceDefinitionVersions(
        request: ListDeviceDefinitionVersionsRequest
      ): F[ListDeviceDefinitionVersionsResponse]

      def listDeviceDefinitions(
        request: ListDeviceDefinitionsRequest
      ): F[ListDeviceDefinitionsResponse]

      def listFunctionDefinitionVersions(
        request: ListFunctionDefinitionVersionsRequest
      ): F[ListFunctionDefinitionVersionsResponse]

      def listFunctionDefinitions(
        request: ListFunctionDefinitionsRequest
      ): F[ListFunctionDefinitionsResponse]

      def listGroupCertificateAuthorities(
        request: ListGroupCertificateAuthoritiesRequest
      ): F[ListGroupCertificateAuthoritiesResponse]

      def listGroupVersions(
        request: ListGroupVersionsRequest
      ): F[ListGroupVersionsResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def listLoggerDefinitionVersions(
        request: ListLoggerDefinitionVersionsRequest
      ): F[ListLoggerDefinitionVersionsResponse]

      def listLoggerDefinitions(
        request: ListLoggerDefinitionsRequest
      ): F[ListLoggerDefinitionsResponse]

      def listResourceDefinitionVersions(
        request: ListResourceDefinitionVersionsRequest
      ): F[ListResourceDefinitionVersionsResponse]

      def listResourceDefinitions(
        request: ListResourceDefinitionsRequest
      ): F[ListResourceDefinitionsResponse]

      def listSubscriptionDefinitionVersions(
        request: ListSubscriptionDefinitionVersionsRequest
      ): F[ListSubscriptionDefinitionVersionsResponse]

      def listSubscriptionDefinitions(
        request: ListSubscriptionDefinitionsRequest
      ): F[ListSubscriptionDefinitionsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def resetDeployments(
        request: ResetDeploymentsRequest
      ): F[ResetDeploymentsResponse]

      def startBulkDeployment(
        request: StartBulkDeploymentRequest
      ): F[StartBulkDeploymentResponse]

      def stopBulkDeployment(
        request: StopBulkDeploymentRequest
      ): F[StopBulkDeploymentResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateConnectivityInfo(
        request: UpdateConnectivityInfoRequest
      ): F[UpdateConnectivityInfoResponse]

      def updateConnectorDefinition(
        request: UpdateConnectorDefinitionRequest
      ): F[UpdateConnectorDefinitionResponse]

      def updateCoreDefinition(
        request: UpdateCoreDefinitionRequest
      ): F[UpdateCoreDefinitionResponse]

      def updateDeviceDefinition(
        request: UpdateDeviceDefinitionRequest
      ): F[UpdateDeviceDefinitionResponse]

      def updateFunctionDefinition(
        request: UpdateFunctionDefinitionRequest
      ): F[UpdateFunctionDefinitionResponse]

      def updateGroup(
        request: UpdateGroupRequest
      ): F[UpdateGroupResponse]

      def updateGroupCertificateConfiguration(
        request: UpdateGroupCertificateConfigurationRequest
      ): F[UpdateGroupCertificateConfigurationResponse]

      def updateLoggerDefinition(
        request: UpdateLoggerDefinitionRequest
      ): F[UpdateLoggerDefinitionResponse]

      def updateResourceDefinition(
        request: UpdateResourceDefinitionRequest
      ): F[UpdateResourceDefinitionResponse]

      def updateSubscriptionDefinition(
        request: UpdateSubscriptionDefinitionRequest
      ): F[UpdateSubscriptionDefinitionResponse]

      def updateThingRuntimeConfiguration(
        request: UpdateThingRuntimeConfigurationRequest
      ): F[UpdateThingRuntimeConfigurationResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GreengrassOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateRoleToGroupOp(
      request: AssociateRoleToGroupRequest
    ) extends GreengrassOp[AssociateRoleToGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateRoleToGroupResponse] =
        visitor.associateRoleToGroup(request)
    }

    final case class AssociateServiceRoleToAccountOp(
      request: AssociateServiceRoleToAccountRequest
    ) extends GreengrassOp[AssociateServiceRoleToAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateServiceRoleToAccountResponse] =
        visitor.associateServiceRoleToAccount(request)
    }

    final case class CreateConnectorDefinitionOp(
      request: CreateConnectorDefinitionRequest
    ) extends GreengrassOp[CreateConnectorDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectorDefinitionResponse] =
        visitor.createConnectorDefinition(request)
    }

    final case class CreateConnectorDefinitionVersionOp(
      request: CreateConnectorDefinitionVersionRequest
    ) extends GreengrassOp[CreateConnectorDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectorDefinitionVersionResponse] =
        visitor.createConnectorDefinitionVersion(request)
    }

    final case class CreateCoreDefinitionOp(
      request: CreateCoreDefinitionRequest
    ) extends GreengrassOp[CreateCoreDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCoreDefinitionResponse] =
        visitor.createCoreDefinition(request)
    }

    final case class CreateCoreDefinitionVersionOp(
      request: CreateCoreDefinitionVersionRequest
    ) extends GreengrassOp[CreateCoreDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCoreDefinitionVersionResponse] =
        visitor.createCoreDefinitionVersion(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends GreengrassOp[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class CreateDeviceDefinitionOp(
      request: CreateDeviceDefinitionRequest
    ) extends GreengrassOp[CreateDeviceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeviceDefinitionResponse] =
        visitor.createDeviceDefinition(request)
    }

    final case class CreateDeviceDefinitionVersionOp(
      request: CreateDeviceDefinitionVersionRequest
    ) extends GreengrassOp[CreateDeviceDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeviceDefinitionVersionResponse] =
        visitor.createDeviceDefinitionVersion(request)
    }

    final case class CreateFunctionDefinitionOp(
      request: CreateFunctionDefinitionRequest
    ) extends GreengrassOp[CreateFunctionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFunctionDefinitionResponse] =
        visitor.createFunctionDefinition(request)
    }

    final case class CreateFunctionDefinitionVersionOp(
      request: CreateFunctionDefinitionVersionRequest
    ) extends GreengrassOp[CreateFunctionDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFunctionDefinitionVersionResponse] =
        visitor.createFunctionDefinitionVersion(request)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends GreengrassOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class CreateGroupCertificateAuthorityOp(
      request: CreateGroupCertificateAuthorityRequest
    ) extends GreengrassOp[CreateGroupCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupCertificateAuthorityResponse] =
        visitor.createGroupCertificateAuthority(request)
    }

    final case class CreateGroupVersionOp(
      request: CreateGroupVersionRequest
    ) extends GreengrassOp[CreateGroupVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupVersionResponse] =
        visitor.createGroupVersion(request)
    }

    final case class CreateLoggerDefinitionOp(
      request: CreateLoggerDefinitionRequest
    ) extends GreengrassOp[CreateLoggerDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoggerDefinitionResponse] =
        visitor.createLoggerDefinition(request)
    }

    final case class CreateLoggerDefinitionVersionOp(
      request: CreateLoggerDefinitionVersionRequest
    ) extends GreengrassOp[CreateLoggerDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateLoggerDefinitionVersionResponse] =
        visitor.createLoggerDefinitionVersion(request)
    }

    final case class CreateResourceDefinitionOp(
      request: CreateResourceDefinitionRequest
    ) extends GreengrassOp[CreateResourceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceDefinitionResponse] =
        visitor.createResourceDefinition(request)
    }

    final case class CreateResourceDefinitionVersionOp(
      request: CreateResourceDefinitionVersionRequest
    ) extends GreengrassOp[CreateResourceDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateResourceDefinitionVersionResponse] =
        visitor.createResourceDefinitionVersion(request)
    }

    final case class CreateSoftwareUpdateJobOp(
      request: CreateSoftwareUpdateJobRequest
    ) extends GreengrassOp[CreateSoftwareUpdateJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSoftwareUpdateJobResponse] =
        visitor.createSoftwareUpdateJob(request)
    }

    final case class CreateSubscriptionDefinitionOp(
      request: CreateSubscriptionDefinitionRequest
    ) extends GreengrassOp[CreateSubscriptionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSubscriptionDefinitionResponse] =
        visitor.createSubscriptionDefinition(request)
    }

    final case class CreateSubscriptionDefinitionVersionOp(
      request: CreateSubscriptionDefinitionVersionRequest
    ) extends GreengrassOp[CreateSubscriptionDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSubscriptionDefinitionVersionResponse] =
        visitor.createSubscriptionDefinitionVersion(request)
    }

    final case class DeleteConnectorDefinitionOp(
      request: DeleteConnectorDefinitionRequest
    ) extends GreengrassOp[DeleteConnectorDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectorDefinitionResponse] =
        visitor.deleteConnectorDefinition(request)
    }

    final case class DeleteCoreDefinitionOp(
      request: DeleteCoreDefinitionRequest
    ) extends GreengrassOp[DeleteCoreDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCoreDefinitionResponse] =
        visitor.deleteCoreDefinition(request)
    }

    final case class DeleteDeviceDefinitionOp(
      request: DeleteDeviceDefinitionRequest
    ) extends GreengrassOp[DeleteDeviceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeviceDefinitionResponse] =
        visitor.deleteDeviceDefinition(request)
    }

    final case class DeleteFunctionDefinitionOp(
      request: DeleteFunctionDefinitionRequest
    ) extends GreengrassOp[DeleteFunctionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFunctionDefinitionResponse] =
        visitor.deleteFunctionDefinition(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends GreengrassOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class DeleteLoggerDefinitionOp(
      request: DeleteLoggerDefinitionRequest
    ) extends GreengrassOp[DeleteLoggerDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteLoggerDefinitionResponse] =
        visitor.deleteLoggerDefinition(request)
    }

    final case class DeleteResourceDefinitionOp(
      request: DeleteResourceDefinitionRequest
    ) extends GreengrassOp[DeleteResourceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourceDefinitionResponse] =
        visitor.deleteResourceDefinition(request)
    }

    final case class DeleteSubscriptionDefinitionOp(
      request: DeleteSubscriptionDefinitionRequest
    ) extends GreengrassOp[DeleteSubscriptionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSubscriptionDefinitionResponse] =
        visitor.deleteSubscriptionDefinition(request)
    }

    final case class DisassociateRoleFromGroupOp(
      request: DisassociateRoleFromGroupRequest
    ) extends GreengrassOp[DisassociateRoleFromGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateRoleFromGroupResponse] =
        visitor.disassociateRoleFromGroup(request)
    }

    final case class DisassociateServiceRoleFromAccountOp(
      request: DisassociateServiceRoleFromAccountRequest
    ) extends GreengrassOp[DisassociateServiceRoleFromAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateServiceRoleFromAccountResponse] =
        visitor.disassociateServiceRoleFromAccount(request)
    }

    final case class GetAssociatedRoleOp(
      request: GetAssociatedRoleRequest
    ) extends GreengrassOp[GetAssociatedRoleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssociatedRoleResponse] =
        visitor.getAssociatedRole(request)
    }

    final case class GetBulkDeploymentStatusOp(
      request: GetBulkDeploymentStatusRequest
    ) extends GreengrassOp[GetBulkDeploymentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBulkDeploymentStatusResponse] =
        visitor.getBulkDeploymentStatus(request)
    }

    final case class GetConnectivityInfoOp(
      request: GetConnectivityInfoRequest
    ) extends GreengrassOp[GetConnectivityInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectivityInfoResponse] =
        visitor.getConnectivityInfo(request)
    }

    final case class GetConnectorDefinitionOp(
      request: GetConnectorDefinitionRequest
    ) extends GreengrassOp[GetConnectorDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectorDefinitionResponse] =
        visitor.getConnectorDefinition(request)
    }

    final case class GetConnectorDefinitionVersionOp(
      request: GetConnectorDefinitionVersionRequest
    ) extends GreengrassOp[GetConnectorDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConnectorDefinitionVersionResponse] =
        visitor.getConnectorDefinitionVersion(request)
    }

    final case class GetCoreDefinitionOp(
      request: GetCoreDefinitionRequest
    ) extends GreengrassOp[GetCoreDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCoreDefinitionResponse] =
        visitor.getCoreDefinition(request)
    }

    final case class GetCoreDefinitionVersionOp(
      request: GetCoreDefinitionVersionRequest
    ) extends GreengrassOp[GetCoreDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCoreDefinitionVersionResponse] =
        visitor.getCoreDefinitionVersion(request)
    }

    final case class GetDeploymentStatusOp(
      request: GetDeploymentStatusRequest
    ) extends GreengrassOp[GetDeploymentStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentStatusResponse] =
        visitor.getDeploymentStatus(request)
    }

    final case class GetDeviceDefinitionOp(
      request: GetDeviceDefinitionRequest
    ) extends GreengrassOp[GetDeviceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceDefinitionResponse] =
        visitor.getDeviceDefinition(request)
    }

    final case class GetDeviceDefinitionVersionOp(
      request: GetDeviceDefinitionVersionRequest
    ) extends GreengrassOp[GetDeviceDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceDefinitionVersionResponse] =
        visitor.getDeviceDefinitionVersion(request)
    }

    final case class GetFunctionDefinitionOp(
      request: GetFunctionDefinitionRequest
    ) extends GreengrassOp[GetFunctionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionDefinitionResponse] =
        visitor.getFunctionDefinition(request)
    }

    final case class GetFunctionDefinitionVersionOp(
      request: GetFunctionDefinitionVersionRequest
    ) extends GreengrassOp[GetFunctionDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFunctionDefinitionVersionResponse] =
        visitor.getFunctionDefinitionVersion(request)
    }

    final case class GetGroupOp(
      request: GetGroupRequest
    ) extends GreengrassOp[GetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupResponse] =
        visitor.getGroup(request)
    }

    final case class GetGroupCertificateAuthorityOp(
      request: GetGroupCertificateAuthorityRequest
    ) extends GreengrassOp[GetGroupCertificateAuthorityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupCertificateAuthorityResponse] =
        visitor.getGroupCertificateAuthority(request)
    }

    final case class GetGroupCertificateConfigurationOp(
      request: GetGroupCertificateConfigurationRequest
    ) extends GreengrassOp[GetGroupCertificateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupCertificateConfigurationResponse] =
        visitor.getGroupCertificateConfiguration(request)
    }

    final case class GetGroupVersionOp(
      request: GetGroupVersionRequest
    ) extends GreengrassOp[GetGroupVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGroupVersionResponse] =
        visitor.getGroupVersion(request)
    }

    final case class GetLoggerDefinitionOp(
      request: GetLoggerDefinitionRequest
    ) extends GreengrassOp[GetLoggerDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoggerDefinitionResponse] =
        visitor.getLoggerDefinition(request)
    }

    final case class GetLoggerDefinitionVersionOp(
      request: GetLoggerDefinitionVersionRequest
    ) extends GreengrassOp[GetLoggerDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLoggerDefinitionVersionResponse] =
        visitor.getLoggerDefinitionVersion(request)
    }

    final case class GetResourceDefinitionOp(
      request: GetResourceDefinitionRequest
    ) extends GreengrassOp[GetResourceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceDefinitionResponse] =
        visitor.getResourceDefinition(request)
    }

    final case class GetResourceDefinitionVersionOp(
      request: GetResourceDefinitionVersionRequest
    ) extends GreengrassOp[GetResourceDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceDefinitionVersionResponse] =
        visitor.getResourceDefinitionVersion(request)
    }

    final case class GetServiceRoleForAccountOp(
      request: GetServiceRoleForAccountRequest
    ) extends GreengrassOp[GetServiceRoleForAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceRoleForAccountResponse] =
        visitor.getServiceRoleForAccount(request)
    }

    final case class GetSubscriptionDefinitionOp(
      request: GetSubscriptionDefinitionRequest
    ) extends GreengrassOp[GetSubscriptionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSubscriptionDefinitionResponse] =
        visitor.getSubscriptionDefinition(request)
    }

    final case class GetSubscriptionDefinitionVersionOp(
      request: GetSubscriptionDefinitionVersionRequest
    ) extends GreengrassOp[GetSubscriptionDefinitionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSubscriptionDefinitionVersionResponse] =
        visitor.getSubscriptionDefinitionVersion(request)
    }

    final case class GetThingRuntimeConfigurationOp(
      request: GetThingRuntimeConfigurationRequest
    ) extends GreengrassOp[GetThingRuntimeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetThingRuntimeConfigurationResponse] =
        visitor.getThingRuntimeConfiguration(request)
    }

    final case class ListBulkDeploymentDetailedReportsOp(
      request: ListBulkDeploymentDetailedReportsRequest
    ) extends GreengrassOp[ListBulkDeploymentDetailedReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBulkDeploymentDetailedReportsResponse] =
        visitor.listBulkDeploymentDetailedReports(request)
    }

    final case class ListBulkDeploymentsOp(
      request: ListBulkDeploymentsRequest
    ) extends GreengrassOp[ListBulkDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBulkDeploymentsResponse] =
        visitor.listBulkDeployments(request)
    }

    final case class ListConnectorDefinitionVersionsOp(
      request: ListConnectorDefinitionVersionsRequest
    ) extends GreengrassOp[ListConnectorDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConnectorDefinitionVersionsResponse] =
        visitor.listConnectorDefinitionVersions(request)
    }

    final case class ListConnectorDefinitionsOp(
      request: ListConnectorDefinitionsRequest
    ) extends GreengrassOp[ListConnectorDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConnectorDefinitionsResponse] =
        visitor.listConnectorDefinitions(request)
    }

    final case class ListCoreDefinitionVersionsOp(
      request: ListCoreDefinitionVersionsRequest
    ) extends GreengrassOp[ListCoreDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCoreDefinitionVersionsResponse] =
        visitor.listCoreDefinitionVersions(request)
    }

    final case class ListCoreDefinitionsOp(
      request: ListCoreDefinitionsRequest
    ) extends GreengrassOp[ListCoreDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCoreDefinitionsResponse] =
        visitor.listCoreDefinitions(request)
    }

    final case class ListDeploymentsOp(
      request: ListDeploymentsRequest
    ) extends GreengrassOp[ListDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentsResponse] =
        visitor.listDeployments(request)
    }

    final case class ListDeviceDefinitionVersionsOp(
      request: ListDeviceDefinitionVersionsRequest
    ) extends GreengrassOp[ListDeviceDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceDefinitionVersionsResponse] =
        visitor.listDeviceDefinitionVersions(request)
    }

    final case class ListDeviceDefinitionsOp(
      request: ListDeviceDefinitionsRequest
    ) extends GreengrassOp[ListDeviceDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceDefinitionsResponse] =
        visitor.listDeviceDefinitions(request)
    }

    final case class ListFunctionDefinitionVersionsOp(
      request: ListFunctionDefinitionVersionsRequest
    ) extends GreengrassOp[ListFunctionDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionDefinitionVersionsResponse] =
        visitor.listFunctionDefinitionVersions(request)
    }

    final case class ListFunctionDefinitionsOp(
      request: ListFunctionDefinitionsRequest
    ) extends GreengrassOp[ListFunctionDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFunctionDefinitionsResponse] =
        visitor.listFunctionDefinitions(request)
    }

    final case class ListGroupCertificateAuthoritiesOp(
      request: ListGroupCertificateAuthoritiesRequest
    ) extends GreengrassOp[ListGroupCertificateAuthoritiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupCertificateAuthoritiesResponse] =
        visitor.listGroupCertificateAuthorities(request)
    }

    final case class ListGroupVersionsOp(
      request: ListGroupVersionsRequest
    ) extends GreengrassOp[ListGroupVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupVersionsResponse] =
        visitor.listGroupVersions(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends GreengrassOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class ListLoggerDefinitionVersionsOp(
      request: ListLoggerDefinitionVersionsRequest
    ) extends GreengrassOp[ListLoggerDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLoggerDefinitionVersionsResponse] =
        visitor.listLoggerDefinitionVersions(request)
    }

    final case class ListLoggerDefinitionsOp(
      request: ListLoggerDefinitionsRequest
    ) extends GreengrassOp[ListLoggerDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLoggerDefinitionsResponse] =
        visitor.listLoggerDefinitions(request)
    }

    final case class ListResourceDefinitionVersionsOp(
      request: ListResourceDefinitionVersionsRequest
    ) extends GreengrassOp[ListResourceDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceDefinitionVersionsResponse] =
        visitor.listResourceDefinitionVersions(request)
    }

    final case class ListResourceDefinitionsOp(
      request: ListResourceDefinitionsRequest
    ) extends GreengrassOp[ListResourceDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourceDefinitionsResponse] =
        visitor.listResourceDefinitions(request)
    }

    final case class ListSubscriptionDefinitionVersionsOp(
      request: ListSubscriptionDefinitionVersionsRequest
    ) extends GreengrassOp[ListSubscriptionDefinitionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscriptionDefinitionVersionsResponse] =
        visitor.listSubscriptionDefinitionVersions(request)
    }

    final case class ListSubscriptionDefinitionsOp(
      request: ListSubscriptionDefinitionsRequest
    ) extends GreengrassOp[ListSubscriptionDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSubscriptionDefinitionsResponse] =
        visitor.listSubscriptionDefinitions(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends GreengrassOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ResetDeploymentsOp(
      request: ResetDeploymentsRequest
    ) extends GreengrassOp[ResetDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetDeploymentsResponse] =
        visitor.resetDeployments(request)
    }

    final case class StartBulkDeploymentOp(
      request: StartBulkDeploymentRequest
    ) extends GreengrassOp[StartBulkDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartBulkDeploymentResponse] =
        visitor.startBulkDeployment(request)
    }

    final case class StopBulkDeploymentOp(
      request: StopBulkDeploymentRequest
    ) extends GreengrassOp[StopBulkDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopBulkDeploymentResponse] =
        visitor.stopBulkDeployment(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GreengrassOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GreengrassOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateConnectivityInfoOp(
      request: UpdateConnectivityInfoRequest
    ) extends GreengrassOp[UpdateConnectivityInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectivityInfoResponse] =
        visitor.updateConnectivityInfo(request)
    }

    final case class UpdateConnectorDefinitionOp(
      request: UpdateConnectorDefinitionRequest
    ) extends GreengrassOp[UpdateConnectorDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectorDefinitionResponse] =
        visitor.updateConnectorDefinition(request)
    }

    final case class UpdateCoreDefinitionOp(
      request: UpdateCoreDefinitionRequest
    ) extends GreengrassOp[UpdateCoreDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCoreDefinitionResponse] =
        visitor.updateCoreDefinition(request)
    }

    final case class UpdateDeviceDefinitionOp(
      request: UpdateDeviceDefinitionRequest
    ) extends GreengrassOp[UpdateDeviceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceDefinitionResponse] =
        visitor.updateDeviceDefinition(request)
    }

    final case class UpdateFunctionDefinitionOp(
      request: UpdateFunctionDefinitionRequest
    ) extends GreengrassOp[UpdateFunctionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFunctionDefinitionResponse] =
        visitor.updateFunctionDefinition(request)
    }

    final case class UpdateGroupOp(
      request: UpdateGroupRequest
    ) extends GreengrassOp[UpdateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupResponse] =
        visitor.updateGroup(request)
    }

    final case class UpdateGroupCertificateConfigurationOp(
      request: UpdateGroupCertificateConfigurationRequest
    ) extends GreengrassOp[UpdateGroupCertificateConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupCertificateConfigurationResponse] =
        visitor.updateGroupCertificateConfiguration(request)
    }

    final case class UpdateLoggerDefinitionOp(
      request: UpdateLoggerDefinitionRequest
    ) extends GreengrassOp[UpdateLoggerDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLoggerDefinitionResponse] =
        visitor.updateLoggerDefinition(request)
    }

    final case class UpdateResourceDefinitionOp(
      request: UpdateResourceDefinitionRequest
    ) extends GreengrassOp[UpdateResourceDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateResourceDefinitionResponse] =
        visitor.updateResourceDefinition(request)
    }

    final case class UpdateSubscriptionDefinitionOp(
      request: UpdateSubscriptionDefinitionRequest
    ) extends GreengrassOp[UpdateSubscriptionDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSubscriptionDefinitionResponse] =
        visitor.updateSubscriptionDefinition(request)
    }

    final case class UpdateThingRuntimeConfigurationOp(
      request: UpdateThingRuntimeConfigurationRequest
    ) extends GreengrassOp[UpdateThingRuntimeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThingRuntimeConfigurationResponse] =
        visitor.updateThingRuntimeConfiguration(request)
    }
  }

  import GreengrassOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GreengrassOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateRoleToGroup(
    request: AssociateRoleToGroupRequest
  ): GreengrassIO[AssociateRoleToGroupResponse] =
    FF.liftF(AssociateRoleToGroupOp(request))

  def associateServiceRoleToAccount(
    request: AssociateServiceRoleToAccountRequest
  ): GreengrassIO[AssociateServiceRoleToAccountResponse] =
    FF.liftF(AssociateServiceRoleToAccountOp(request))

  def createConnectorDefinition(
    request: CreateConnectorDefinitionRequest
  ): GreengrassIO[CreateConnectorDefinitionResponse] =
    FF.liftF(CreateConnectorDefinitionOp(request))

  def createConnectorDefinitionVersion(
    request: CreateConnectorDefinitionVersionRequest
  ): GreengrassIO[CreateConnectorDefinitionVersionResponse] =
    FF.liftF(CreateConnectorDefinitionVersionOp(request))

  def createCoreDefinition(
    request: CreateCoreDefinitionRequest
  ): GreengrassIO[CreateCoreDefinitionResponse] =
    FF.liftF(CreateCoreDefinitionOp(request))

  def createCoreDefinitionVersion(
    request: CreateCoreDefinitionVersionRequest
  ): GreengrassIO[CreateCoreDefinitionVersionResponse] =
    FF.liftF(CreateCoreDefinitionVersionOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): GreengrassIO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def createDeviceDefinition(
    request: CreateDeviceDefinitionRequest
  ): GreengrassIO[CreateDeviceDefinitionResponse] =
    FF.liftF(CreateDeviceDefinitionOp(request))

  def createDeviceDefinitionVersion(
    request: CreateDeviceDefinitionVersionRequest
  ): GreengrassIO[CreateDeviceDefinitionVersionResponse] =
    FF.liftF(CreateDeviceDefinitionVersionOp(request))

  def createFunctionDefinition(
    request: CreateFunctionDefinitionRequest
  ): GreengrassIO[CreateFunctionDefinitionResponse] =
    FF.liftF(CreateFunctionDefinitionOp(request))

  def createFunctionDefinitionVersion(
    request: CreateFunctionDefinitionVersionRequest
  ): GreengrassIO[CreateFunctionDefinitionVersionResponse] =
    FF.liftF(CreateFunctionDefinitionVersionOp(request))

  def createGroup(
    request: CreateGroupRequest
  ): GreengrassIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def createGroupCertificateAuthority(
    request: CreateGroupCertificateAuthorityRequest
  ): GreengrassIO[CreateGroupCertificateAuthorityResponse] =
    FF.liftF(CreateGroupCertificateAuthorityOp(request))

  def createGroupVersion(
    request: CreateGroupVersionRequest
  ): GreengrassIO[CreateGroupVersionResponse] =
    FF.liftF(CreateGroupVersionOp(request))

  def createLoggerDefinition(
    request: CreateLoggerDefinitionRequest
  ): GreengrassIO[CreateLoggerDefinitionResponse] =
    FF.liftF(CreateLoggerDefinitionOp(request))

  def createLoggerDefinitionVersion(
    request: CreateLoggerDefinitionVersionRequest
  ): GreengrassIO[CreateLoggerDefinitionVersionResponse] =
    FF.liftF(CreateLoggerDefinitionVersionOp(request))

  def createResourceDefinition(
    request: CreateResourceDefinitionRequest
  ): GreengrassIO[CreateResourceDefinitionResponse] =
    FF.liftF(CreateResourceDefinitionOp(request))

  def createResourceDefinitionVersion(
    request: CreateResourceDefinitionVersionRequest
  ): GreengrassIO[CreateResourceDefinitionVersionResponse] =
    FF.liftF(CreateResourceDefinitionVersionOp(request))

  def createSoftwareUpdateJob(
    request: CreateSoftwareUpdateJobRequest
  ): GreengrassIO[CreateSoftwareUpdateJobResponse] =
    FF.liftF(CreateSoftwareUpdateJobOp(request))

  def createSubscriptionDefinition(
    request: CreateSubscriptionDefinitionRequest
  ): GreengrassIO[CreateSubscriptionDefinitionResponse] =
    FF.liftF(CreateSubscriptionDefinitionOp(request))

  def createSubscriptionDefinitionVersion(
    request: CreateSubscriptionDefinitionVersionRequest
  ): GreengrassIO[CreateSubscriptionDefinitionVersionResponse] =
    FF.liftF(CreateSubscriptionDefinitionVersionOp(request))

  def deleteConnectorDefinition(
    request: DeleteConnectorDefinitionRequest
  ): GreengrassIO[DeleteConnectorDefinitionResponse] =
    FF.liftF(DeleteConnectorDefinitionOp(request))

  def deleteCoreDefinition(
    request: DeleteCoreDefinitionRequest
  ): GreengrassIO[DeleteCoreDefinitionResponse] =
    FF.liftF(DeleteCoreDefinitionOp(request))

  def deleteDeviceDefinition(
    request: DeleteDeviceDefinitionRequest
  ): GreengrassIO[DeleteDeviceDefinitionResponse] =
    FF.liftF(DeleteDeviceDefinitionOp(request))

  def deleteFunctionDefinition(
    request: DeleteFunctionDefinitionRequest
  ): GreengrassIO[DeleteFunctionDefinitionResponse] =
    FF.liftF(DeleteFunctionDefinitionOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): GreengrassIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def deleteLoggerDefinition(
    request: DeleteLoggerDefinitionRequest
  ): GreengrassIO[DeleteLoggerDefinitionResponse] =
    FF.liftF(DeleteLoggerDefinitionOp(request))

  def deleteResourceDefinition(
    request: DeleteResourceDefinitionRequest
  ): GreengrassIO[DeleteResourceDefinitionResponse] =
    FF.liftF(DeleteResourceDefinitionOp(request))

  def deleteSubscriptionDefinition(
    request: DeleteSubscriptionDefinitionRequest
  ): GreengrassIO[DeleteSubscriptionDefinitionResponse] =
    FF.liftF(DeleteSubscriptionDefinitionOp(request))

  def disassociateRoleFromGroup(
    request: DisassociateRoleFromGroupRequest
  ): GreengrassIO[DisassociateRoleFromGroupResponse] =
    FF.liftF(DisassociateRoleFromGroupOp(request))

  def disassociateServiceRoleFromAccount(
    request: DisassociateServiceRoleFromAccountRequest
  ): GreengrassIO[DisassociateServiceRoleFromAccountResponse] =
    FF.liftF(DisassociateServiceRoleFromAccountOp(request))

  def getAssociatedRole(
    request: GetAssociatedRoleRequest
  ): GreengrassIO[GetAssociatedRoleResponse] =
    FF.liftF(GetAssociatedRoleOp(request))

  def getBulkDeploymentStatus(
    request: GetBulkDeploymentStatusRequest
  ): GreengrassIO[GetBulkDeploymentStatusResponse] =
    FF.liftF(GetBulkDeploymentStatusOp(request))

  def getConnectivityInfo(
    request: GetConnectivityInfoRequest
  ): GreengrassIO[GetConnectivityInfoResponse] =
    FF.liftF(GetConnectivityInfoOp(request))

  def getConnectorDefinition(
    request: GetConnectorDefinitionRequest
  ): GreengrassIO[GetConnectorDefinitionResponse] =
    FF.liftF(GetConnectorDefinitionOp(request))

  def getConnectorDefinitionVersion(
    request: GetConnectorDefinitionVersionRequest
  ): GreengrassIO[GetConnectorDefinitionVersionResponse] =
    FF.liftF(GetConnectorDefinitionVersionOp(request))

  def getCoreDefinition(
    request: GetCoreDefinitionRequest
  ): GreengrassIO[GetCoreDefinitionResponse] =
    FF.liftF(GetCoreDefinitionOp(request))

  def getCoreDefinitionVersion(
    request: GetCoreDefinitionVersionRequest
  ): GreengrassIO[GetCoreDefinitionVersionResponse] =
    FF.liftF(GetCoreDefinitionVersionOp(request))

  def getDeploymentStatus(
    request: GetDeploymentStatusRequest
  ): GreengrassIO[GetDeploymentStatusResponse] =
    FF.liftF(GetDeploymentStatusOp(request))

  def getDeviceDefinition(
    request: GetDeviceDefinitionRequest
  ): GreengrassIO[GetDeviceDefinitionResponse] =
    FF.liftF(GetDeviceDefinitionOp(request))

  def getDeviceDefinitionVersion(
    request: GetDeviceDefinitionVersionRequest
  ): GreengrassIO[GetDeviceDefinitionVersionResponse] =
    FF.liftF(GetDeviceDefinitionVersionOp(request))

  def getFunctionDefinition(
    request: GetFunctionDefinitionRequest
  ): GreengrassIO[GetFunctionDefinitionResponse] =
    FF.liftF(GetFunctionDefinitionOp(request))

  def getFunctionDefinitionVersion(
    request: GetFunctionDefinitionVersionRequest
  ): GreengrassIO[GetFunctionDefinitionVersionResponse] =
    FF.liftF(GetFunctionDefinitionVersionOp(request))

  def getGroup(
    request: GetGroupRequest
  ): GreengrassIO[GetGroupResponse] =
    FF.liftF(GetGroupOp(request))

  def getGroupCertificateAuthority(
    request: GetGroupCertificateAuthorityRequest
  ): GreengrassIO[GetGroupCertificateAuthorityResponse] =
    FF.liftF(GetGroupCertificateAuthorityOp(request))

  def getGroupCertificateConfiguration(
    request: GetGroupCertificateConfigurationRequest
  ): GreengrassIO[GetGroupCertificateConfigurationResponse] =
    FF.liftF(GetGroupCertificateConfigurationOp(request))

  def getGroupVersion(
    request: GetGroupVersionRequest
  ): GreengrassIO[GetGroupVersionResponse] =
    FF.liftF(GetGroupVersionOp(request))

  def getLoggerDefinition(
    request: GetLoggerDefinitionRequest
  ): GreengrassIO[GetLoggerDefinitionResponse] =
    FF.liftF(GetLoggerDefinitionOp(request))

  def getLoggerDefinitionVersion(
    request: GetLoggerDefinitionVersionRequest
  ): GreengrassIO[GetLoggerDefinitionVersionResponse] =
    FF.liftF(GetLoggerDefinitionVersionOp(request))

  def getResourceDefinition(
    request: GetResourceDefinitionRequest
  ): GreengrassIO[GetResourceDefinitionResponse] =
    FF.liftF(GetResourceDefinitionOp(request))

  def getResourceDefinitionVersion(
    request: GetResourceDefinitionVersionRequest
  ): GreengrassIO[GetResourceDefinitionVersionResponse] =
    FF.liftF(GetResourceDefinitionVersionOp(request))

  def getServiceRoleForAccount(
    request: GetServiceRoleForAccountRequest
  ): GreengrassIO[GetServiceRoleForAccountResponse] =
    FF.liftF(GetServiceRoleForAccountOp(request))

  def getSubscriptionDefinition(
    request: GetSubscriptionDefinitionRequest
  ): GreengrassIO[GetSubscriptionDefinitionResponse] =
    FF.liftF(GetSubscriptionDefinitionOp(request))

  def getSubscriptionDefinitionVersion(
    request: GetSubscriptionDefinitionVersionRequest
  ): GreengrassIO[GetSubscriptionDefinitionVersionResponse] =
    FF.liftF(GetSubscriptionDefinitionVersionOp(request))

  def getThingRuntimeConfiguration(
    request: GetThingRuntimeConfigurationRequest
  ): GreengrassIO[GetThingRuntimeConfigurationResponse] =
    FF.liftF(GetThingRuntimeConfigurationOp(request))

  def listBulkDeploymentDetailedReports(
    request: ListBulkDeploymentDetailedReportsRequest
  ): GreengrassIO[ListBulkDeploymentDetailedReportsResponse] =
    FF.liftF(ListBulkDeploymentDetailedReportsOp(request))

  def listBulkDeployments(
    request: ListBulkDeploymentsRequest
  ): GreengrassIO[ListBulkDeploymentsResponse] =
    FF.liftF(ListBulkDeploymentsOp(request))

  def listConnectorDefinitionVersions(
    request: ListConnectorDefinitionVersionsRequest
  ): GreengrassIO[ListConnectorDefinitionVersionsResponse] =
    FF.liftF(ListConnectorDefinitionVersionsOp(request))

  def listConnectorDefinitions(
    request: ListConnectorDefinitionsRequest
  ): GreengrassIO[ListConnectorDefinitionsResponse] =
    FF.liftF(ListConnectorDefinitionsOp(request))

  def listCoreDefinitionVersions(
    request: ListCoreDefinitionVersionsRequest
  ): GreengrassIO[ListCoreDefinitionVersionsResponse] =
    FF.liftF(ListCoreDefinitionVersionsOp(request))

  def listCoreDefinitions(
    request: ListCoreDefinitionsRequest
  ): GreengrassIO[ListCoreDefinitionsResponse] =
    FF.liftF(ListCoreDefinitionsOp(request))

  def listDeployments(
    request: ListDeploymentsRequest
  ): GreengrassIO[ListDeploymentsResponse] =
    FF.liftF(ListDeploymentsOp(request))

  def listDeviceDefinitionVersions(
    request: ListDeviceDefinitionVersionsRequest
  ): GreengrassIO[ListDeviceDefinitionVersionsResponse] =
    FF.liftF(ListDeviceDefinitionVersionsOp(request))

  def listDeviceDefinitions(
    request: ListDeviceDefinitionsRequest
  ): GreengrassIO[ListDeviceDefinitionsResponse] =
    FF.liftF(ListDeviceDefinitionsOp(request))

  def listFunctionDefinitionVersions(
    request: ListFunctionDefinitionVersionsRequest
  ): GreengrassIO[ListFunctionDefinitionVersionsResponse] =
    FF.liftF(ListFunctionDefinitionVersionsOp(request))

  def listFunctionDefinitions(
    request: ListFunctionDefinitionsRequest
  ): GreengrassIO[ListFunctionDefinitionsResponse] =
    FF.liftF(ListFunctionDefinitionsOp(request))

  def listGroupCertificateAuthorities(
    request: ListGroupCertificateAuthoritiesRequest
  ): GreengrassIO[ListGroupCertificateAuthoritiesResponse] =
    FF.liftF(ListGroupCertificateAuthoritiesOp(request))

  def listGroupVersions(
    request: ListGroupVersionsRequest
  ): GreengrassIO[ListGroupVersionsResponse] =
    FF.liftF(ListGroupVersionsOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): GreengrassIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def listLoggerDefinitionVersions(
    request: ListLoggerDefinitionVersionsRequest
  ): GreengrassIO[ListLoggerDefinitionVersionsResponse] =
    FF.liftF(ListLoggerDefinitionVersionsOp(request))

  def listLoggerDefinitions(
    request: ListLoggerDefinitionsRequest
  ): GreengrassIO[ListLoggerDefinitionsResponse] =
    FF.liftF(ListLoggerDefinitionsOp(request))

  def listResourceDefinitionVersions(
    request: ListResourceDefinitionVersionsRequest
  ): GreengrassIO[ListResourceDefinitionVersionsResponse] =
    FF.liftF(ListResourceDefinitionVersionsOp(request))

  def listResourceDefinitions(
    request: ListResourceDefinitionsRequest
  ): GreengrassIO[ListResourceDefinitionsResponse] =
    FF.liftF(ListResourceDefinitionsOp(request))

  def listSubscriptionDefinitionVersions(
    request: ListSubscriptionDefinitionVersionsRequest
  ): GreengrassIO[ListSubscriptionDefinitionVersionsResponse] =
    FF.liftF(ListSubscriptionDefinitionVersionsOp(request))

  def listSubscriptionDefinitions(
    request: ListSubscriptionDefinitionsRequest
  ): GreengrassIO[ListSubscriptionDefinitionsResponse] =
    FF.liftF(ListSubscriptionDefinitionsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): GreengrassIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def resetDeployments(
    request: ResetDeploymentsRequest
  ): GreengrassIO[ResetDeploymentsResponse] =
    FF.liftF(ResetDeploymentsOp(request))

  def startBulkDeployment(
    request: StartBulkDeploymentRequest
  ): GreengrassIO[StartBulkDeploymentResponse] =
    FF.liftF(StartBulkDeploymentOp(request))

  def stopBulkDeployment(
    request: StopBulkDeploymentRequest
  ): GreengrassIO[StopBulkDeploymentResponse] =
    FF.liftF(StopBulkDeploymentOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GreengrassIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GreengrassIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateConnectivityInfo(
    request: UpdateConnectivityInfoRequest
  ): GreengrassIO[UpdateConnectivityInfoResponse] =
    FF.liftF(UpdateConnectivityInfoOp(request))

  def updateConnectorDefinition(
    request: UpdateConnectorDefinitionRequest
  ): GreengrassIO[UpdateConnectorDefinitionResponse] =
    FF.liftF(UpdateConnectorDefinitionOp(request))

  def updateCoreDefinition(
    request: UpdateCoreDefinitionRequest
  ): GreengrassIO[UpdateCoreDefinitionResponse] =
    FF.liftF(UpdateCoreDefinitionOp(request))

  def updateDeviceDefinition(
    request: UpdateDeviceDefinitionRequest
  ): GreengrassIO[UpdateDeviceDefinitionResponse] =
    FF.liftF(UpdateDeviceDefinitionOp(request))

  def updateFunctionDefinition(
    request: UpdateFunctionDefinitionRequest
  ): GreengrassIO[UpdateFunctionDefinitionResponse] =
    FF.liftF(UpdateFunctionDefinitionOp(request))

  def updateGroup(
    request: UpdateGroupRequest
  ): GreengrassIO[UpdateGroupResponse] =
    FF.liftF(UpdateGroupOp(request))

  def updateGroupCertificateConfiguration(
    request: UpdateGroupCertificateConfigurationRequest
  ): GreengrassIO[UpdateGroupCertificateConfigurationResponse] =
    FF.liftF(UpdateGroupCertificateConfigurationOp(request))

  def updateLoggerDefinition(
    request: UpdateLoggerDefinitionRequest
  ): GreengrassIO[UpdateLoggerDefinitionResponse] =
    FF.liftF(UpdateLoggerDefinitionOp(request))

  def updateResourceDefinition(
    request: UpdateResourceDefinitionRequest
  ): GreengrassIO[UpdateResourceDefinitionResponse] =
    FF.liftF(UpdateResourceDefinitionOp(request))

  def updateSubscriptionDefinition(
    request: UpdateSubscriptionDefinitionRequest
  ): GreengrassIO[UpdateSubscriptionDefinitionResponse] =
    FF.liftF(UpdateSubscriptionDefinitionOp(request))

  def updateThingRuntimeConfiguration(
    request: UpdateThingRuntimeConfigurationRequest
  ): GreengrassIO[UpdateThingRuntimeConfigurationResponse] =
    FF.liftF(UpdateThingRuntimeConfigurationOp(request))
}
