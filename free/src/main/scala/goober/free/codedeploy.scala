package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codedeploy.CodeDeployClient
import software.amazon.awssdk.services.codedeploy.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object codedeploy { module =>

  // Free monad over CodeDeployOp
  type CodeDeployIO[A] = FF[CodeDeployOp, A]

  sealed trait CodeDeployOp[A] {
    def visit[F[_]](visitor: CodeDeployOp.Visitor[F]): F[A]
  }

  object CodeDeployOp {
    // Given a CodeDeployClient we can embed a CodeDeployIO program in any algebra that understands embedding.
    implicit val CodeDeployOpEmbeddable: Embeddable[CodeDeployOp, CodeDeployClient] = new Embeddable[CodeDeployOp, CodeDeployClient] {
      def embed[A](client: CodeDeployClient, io: CodeDeployIO[A]): Embedded[A] = Embedded.CodeDeploy(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeDeployOp.Visitor[Kleisli[M, CodeDeployClient, *]] {
        def addTagsToOnPremisesInstances(
          request: AddTagsToOnPremisesInstancesRequest
        ): Kleisli[M, CodeDeployClient, AddTagsToOnPremisesInstancesResponse] =
          primitive(_.addTagsToOnPremisesInstances(request))

        def batchGetApplicationRevisions(
          request: BatchGetApplicationRevisionsRequest
        ): Kleisli[M, CodeDeployClient, BatchGetApplicationRevisionsResponse] =
          primitive(_.batchGetApplicationRevisions(request))

        def batchGetApplications(
          request: BatchGetApplicationsRequest
        ): Kleisli[M, CodeDeployClient, BatchGetApplicationsResponse] =
          primitive(_.batchGetApplications(request))

        def batchGetDeploymentGroups(
          request: BatchGetDeploymentGroupsRequest
        ): Kleisli[M, CodeDeployClient, BatchGetDeploymentGroupsResponse] =
          primitive(_.batchGetDeploymentGroups(request))

        def batchGetDeploymentTargets(
          request: BatchGetDeploymentTargetsRequest
        ): Kleisli[M, CodeDeployClient, BatchGetDeploymentTargetsResponse] =
          primitive(_.batchGetDeploymentTargets(request))

        def batchGetDeployments(
          request: BatchGetDeploymentsRequest
        ): Kleisli[M, CodeDeployClient, BatchGetDeploymentsResponse] =
          primitive(_.batchGetDeployments(request))

        def batchGetOnPremisesInstances(
          request: BatchGetOnPremisesInstancesRequest
        ): Kleisli[M, CodeDeployClient, BatchGetOnPremisesInstancesResponse] =
          primitive(_.batchGetOnPremisesInstances(request))

        def continueDeployment(
          request: ContinueDeploymentRequest
        ): Kleisli[M, CodeDeployClient, ContinueDeploymentResponse] =
          primitive(_.continueDeployment(request))

        def createApplication(
          request: CreateApplicationRequest
        ): Kleisli[M, CodeDeployClient, CreateApplicationResponse] =
          primitive(_.createApplication(request))

        def createDeployment(
          request: CreateDeploymentRequest
        ): Kleisli[M, CodeDeployClient, CreateDeploymentResponse] =
          primitive(_.createDeployment(request))

        def createDeploymentConfig(
          request: CreateDeploymentConfigRequest
        ): Kleisli[M, CodeDeployClient, CreateDeploymentConfigResponse] =
          primitive(_.createDeploymentConfig(request))

        def createDeploymentGroup(
          request: CreateDeploymentGroupRequest
        ): Kleisli[M, CodeDeployClient, CreateDeploymentGroupResponse] =
          primitive(_.createDeploymentGroup(request))

        def deleteApplication(
          request: DeleteApplicationRequest
        ): Kleisli[M, CodeDeployClient, DeleteApplicationResponse] =
          primitive(_.deleteApplication(request))

        def deleteDeploymentConfig(
          request: DeleteDeploymentConfigRequest
        ): Kleisli[M, CodeDeployClient, DeleteDeploymentConfigResponse] =
          primitive(_.deleteDeploymentConfig(request))

        def deleteDeploymentGroup(
          request: DeleteDeploymentGroupRequest
        ): Kleisli[M, CodeDeployClient, DeleteDeploymentGroupResponse] =
          primitive(_.deleteDeploymentGroup(request))

        def deleteGitHubAccountToken(
          request: DeleteGitHubAccountTokenRequest
        ): Kleisli[M, CodeDeployClient, DeleteGitHubAccountTokenResponse] =
          primitive(_.deleteGitHubAccountToken(request))

        def deleteResourcesByExternalId(
          request: DeleteResourcesByExternalIdRequest
        ): Kleisli[M, CodeDeployClient, DeleteResourcesByExternalIdResponse] =
          primitive(_.deleteResourcesByExternalId(request))

        def deregisterOnPremisesInstance(
          request: DeregisterOnPremisesInstanceRequest
        ): Kleisli[M, CodeDeployClient, DeregisterOnPremisesInstanceResponse] =
          primitive(_.deregisterOnPremisesInstance(request))

        def getApplication(
          request: GetApplicationRequest
        ): Kleisli[M, CodeDeployClient, GetApplicationResponse] =
          primitive(_.getApplication(request))

        def getApplicationRevision(
          request: GetApplicationRevisionRequest
        ): Kleisli[M, CodeDeployClient, GetApplicationRevisionResponse] =
          primitive(_.getApplicationRevision(request))

        def getDeployment(
          request: GetDeploymentRequest
        ): Kleisli[M, CodeDeployClient, GetDeploymentResponse] =
          primitive(_.getDeployment(request))

        def getDeploymentConfig(
          request: GetDeploymentConfigRequest
        ): Kleisli[M, CodeDeployClient, GetDeploymentConfigResponse] =
          primitive(_.getDeploymentConfig(request))

        def getDeploymentGroup(
          request: GetDeploymentGroupRequest
        ): Kleisli[M, CodeDeployClient, GetDeploymentGroupResponse] =
          primitive(_.getDeploymentGroup(request))

        def getDeploymentTarget(
          request: GetDeploymentTargetRequest
        ): Kleisli[M, CodeDeployClient, GetDeploymentTargetResponse] =
          primitive(_.getDeploymentTarget(request))

        def getOnPremisesInstance(
          request: GetOnPremisesInstanceRequest
        ): Kleisli[M, CodeDeployClient, GetOnPremisesInstanceResponse] =
          primitive(_.getOnPremisesInstance(request))

        def listApplicationRevisions(
          request: ListApplicationRevisionsRequest
        ): Kleisli[M, CodeDeployClient, ListApplicationRevisionsResponse] =
          primitive(_.listApplicationRevisions(request))

        def listApplications(
          request: ListApplicationsRequest
        ): Kleisli[M, CodeDeployClient, ListApplicationsResponse] =
          primitive(_.listApplications(request))

        def listDeploymentConfigs(
          request: ListDeploymentConfigsRequest
        ): Kleisli[M, CodeDeployClient, ListDeploymentConfigsResponse] =
          primitive(_.listDeploymentConfigs(request))

        def listDeploymentGroups(
          request: ListDeploymentGroupsRequest
        ): Kleisli[M, CodeDeployClient, ListDeploymentGroupsResponse] =
          primitive(_.listDeploymentGroups(request))

        def listDeploymentTargets(
          request: ListDeploymentTargetsRequest
        ): Kleisli[M, CodeDeployClient, ListDeploymentTargetsResponse] =
          primitive(_.listDeploymentTargets(request))

        def listDeployments(
          request: ListDeploymentsRequest
        ): Kleisli[M, CodeDeployClient, ListDeploymentsResponse] =
          primitive(_.listDeployments(request))

        def listGitHubAccountTokenNames(
          request: ListGitHubAccountTokenNamesRequest
        ): Kleisli[M, CodeDeployClient, ListGitHubAccountTokenNamesResponse] =
          primitive(_.listGitHubAccountTokenNames(request))

        def listOnPremisesInstances(
          request: ListOnPremisesInstancesRequest
        ): Kleisli[M, CodeDeployClient, ListOnPremisesInstancesResponse] =
          primitive(_.listOnPremisesInstances(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, CodeDeployClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putLifecycleEventHookExecutionStatus(
          request: PutLifecycleEventHookExecutionStatusRequest
        ): Kleisli[M, CodeDeployClient, PutLifecycleEventHookExecutionStatusResponse] =
          primitive(_.putLifecycleEventHookExecutionStatus(request))

        def registerApplicationRevision(
          request: RegisterApplicationRevisionRequest
        ): Kleisli[M, CodeDeployClient, RegisterApplicationRevisionResponse] =
          primitive(_.registerApplicationRevision(request))

        def registerOnPremisesInstance(
          request: RegisterOnPremisesInstanceRequest
        ): Kleisli[M, CodeDeployClient, RegisterOnPremisesInstanceResponse] =
          primitive(_.registerOnPremisesInstance(request))

        def removeTagsFromOnPremisesInstances(
          request: RemoveTagsFromOnPremisesInstancesRequest
        ): Kleisli[M, CodeDeployClient, RemoveTagsFromOnPremisesInstancesResponse] =
          primitive(_.removeTagsFromOnPremisesInstances(request))

        def stopDeployment(
          request: StopDeploymentRequest
        ): Kleisli[M, CodeDeployClient, StopDeploymentResponse] =
          primitive(_.stopDeployment(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, CodeDeployClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, CodeDeployClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateApplication(
          request: UpdateApplicationRequest
        ): Kleisli[M, CodeDeployClient, UpdateApplicationResponse] =
          primitive(_.updateApplication(request))

        def updateDeploymentGroup(
          request: UpdateDeploymentGroupRequest
        ): Kleisli[M, CodeDeployClient, UpdateDeploymentGroupResponse] =
          primitive(_.updateDeploymentGroup(request))

        def primitive[A](
          f: CodeDeployClient => A
        ): Kleisli[M, CodeDeployClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeDeployOp ~> F) {
      final def apply[A](op: CodeDeployOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def addTagsToOnPremisesInstances(
        request: AddTagsToOnPremisesInstancesRequest
      ): F[AddTagsToOnPremisesInstancesResponse]

      def batchGetApplicationRevisions(
        request: BatchGetApplicationRevisionsRequest
      ): F[BatchGetApplicationRevisionsResponse]

      def batchGetApplications(
        request: BatchGetApplicationsRequest
      ): F[BatchGetApplicationsResponse]

      def batchGetDeploymentGroups(
        request: BatchGetDeploymentGroupsRequest
      ): F[BatchGetDeploymentGroupsResponse]

      def batchGetDeploymentTargets(
        request: BatchGetDeploymentTargetsRequest
      ): F[BatchGetDeploymentTargetsResponse]

      def batchGetDeployments(
        request: BatchGetDeploymentsRequest
      ): F[BatchGetDeploymentsResponse]

      def batchGetOnPremisesInstances(
        request: BatchGetOnPremisesInstancesRequest
      ): F[BatchGetOnPremisesInstancesResponse]

      def continueDeployment(
        request: ContinueDeploymentRequest
      ): F[ContinueDeploymentResponse]

      def createApplication(
        request: CreateApplicationRequest
      ): F[CreateApplicationResponse]

      def createDeployment(
        request: CreateDeploymentRequest
      ): F[CreateDeploymentResponse]

      def createDeploymentConfig(
        request: CreateDeploymentConfigRequest
      ): F[CreateDeploymentConfigResponse]

      def createDeploymentGroup(
        request: CreateDeploymentGroupRequest
      ): F[CreateDeploymentGroupResponse]

      def deleteApplication(
        request: DeleteApplicationRequest
      ): F[DeleteApplicationResponse]

      def deleteDeploymentConfig(
        request: DeleteDeploymentConfigRequest
      ): F[DeleteDeploymentConfigResponse]

      def deleteDeploymentGroup(
        request: DeleteDeploymentGroupRequest
      ): F[DeleteDeploymentGroupResponse]

      def deleteGitHubAccountToken(
        request: DeleteGitHubAccountTokenRequest
      ): F[DeleteGitHubAccountTokenResponse]

      def deleteResourcesByExternalId(
        request: DeleteResourcesByExternalIdRequest
      ): F[DeleteResourcesByExternalIdResponse]

      def deregisterOnPremisesInstance(
        request: DeregisterOnPremisesInstanceRequest
      ): F[DeregisterOnPremisesInstanceResponse]

      def getApplication(
        request: GetApplicationRequest
      ): F[GetApplicationResponse]

      def getApplicationRevision(
        request: GetApplicationRevisionRequest
      ): F[GetApplicationRevisionResponse]

      def getDeployment(
        request: GetDeploymentRequest
      ): F[GetDeploymentResponse]

      def getDeploymentConfig(
        request: GetDeploymentConfigRequest
      ): F[GetDeploymentConfigResponse]

      def getDeploymentGroup(
        request: GetDeploymentGroupRequest
      ): F[GetDeploymentGroupResponse]

      def getDeploymentTarget(
        request: GetDeploymentTargetRequest
      ): F[GetDeploymentTargetResponse]

      def getOnPremisesInstance(
        request: GetOnPremisesInstanceRequest
      ): F[GetOnPremisesInstanceResponse]

      def listApplicationRevisions(
        request: ListApplicationRevisionsRequest
      ): F[ListApplicationRevisionsResponse]

      def listApplications(
        request: ListApplicationsRequest
      ): F[ListApplicationsResponse]

      def listDeploymentConfigs(
        request: ListDeploymentConfigsRequest
      ): F[ListDeploymentConfigsResponse]

      def listDeploymentGroups(
        request: ListDeploymentGroupsRequest
      ): F[ListDeploymentGroupsResponse]

      def listDeploymentTargets(
        request: ListDeploymentTargetsRequest
      ): F[ListDeploymentTargetsResponse]

      def listDeployments(
        request: ListDeploymentsRequest
      ): F[ListDeploymentsResponse]

      def listGitHubAccountTokenNames(
        request: ListGitHubAccountTokenNamesRequest
      ): F[ListGitHubAccountTokenNamesResponse]

      def listOnPremisesInstances(
        request: ListOnPremisesInstancesRequest
      ): F[ListOnPremisesInstancesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putLifecycleEventHookExecutionStatus(
        request: PutLifecycleEventHookExecutionStatusRequest
      ): F[PutLifecycleEventHookExecutionStatusResponse]

      def registerApplicationRevision(
        request: RegisterApplicationRevisionRequest
      ): F[RegisterApplicationRevisionResponse]

      def registerOnPremisesInstance(
        request: RegisterOnPremisesInstanceRequest
      ): F[RegisterOnPremisesInstanceResponse]

      def removeTagsFromOnPremisesInstances(
        request: RemoveTagsFromOnPremisesInstancesRequest
      ): F[RemoveTagsFromOnPremisesInstancesResponse]

      def stopDeployment(
        request: StopDeploymentRequest
      ): F[StopDeploymentResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateApplication(
        request: UpdateApplicationRequest
      ): F[UpdateApplicationResponse]

      def updateDeploymentGroup(
        request: UpdateDeploymentGroupRequest
      ): F[UpdateDeploymentGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeDeployOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AddTagsToOnPremisesInstancesOp(
      request: AddTagsToOnPremisesInstancesRequest
    ) extends CodeDeployOp[AddTagsToOnPremisesInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AddTagsToOnPremisesInstancesResponse] =
        visitor.addTagsToOnPremisesInstances(request)
    }

    final case class BatchGetApplicationRevisionsOp(
      request: BatchGetApplicationRevisionsRequest
    ) extends CodeDeployOp[BatchGetApplicationRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetApplicationRevisionsResponse] =
        visitor.batchGetApplicationRevisions(request)
    }

    final case class BatchGetApplicationsOp(
      request: BatchGetApplicationsRequest
    ) extends CodeDeployOp[BatchGetApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetApplicationsResponse] =
        visitor.batchGetApplications(request)
    }

    final case class BatchGetDeploymentGroupsOp(
      request: BatchGetDeploymentGroupsRequest
    ) extends CodeDeployOp[BatchGetDeploymentGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetDeploymentGroupsResponse] =
        visitor.batchGetDeploymentGroups(request)
    }

    final case class BatchGetDeploymentTargetsOp(
      request: BatchGetDeploymentTargetsRequest
    ) extends CodeDeployOp[BatchGetDeploymentTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetDeploymentTargetsResponse] =
        visitor.batchGetDeploymentTargets(request)
    }

    final case class BatchGetDeploymentsOp(
      request: BatchGetDeploymentsRequest
    ) extends CodeDeployOp[BatchGetDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetDeploymentsResponse] =
        visitor.batchGetDeployments(request)
    }

    final case class BatchGetOnPremisesInstancesOp(
      request: BatchGetOnPremisesInstancesRequest
    ) extends CodeDeployOp[BatchGetOnPremisesInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetOnPremisesInstancesResponse] =
        visitor.batchGetOnPremisesInstances(request)
    }

    final case class ContinueDeploymentOp(
      request: ContinueDeploymentRequest
    ) extends CodeDeployOp[ContinueDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ContinueDeploymentResponse] =
        visitor.continueDeployment(request)
    }

    final case class CreateApplicationOp(
      request: CreateApplicationRequest
    ) extends CodeDeployOp[CreateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateApplicationResponse] =
        visitor.createApplication(request)
    }

    final case class CreateDeploymentOp(
      request: CreateDeploymentRequest
    ) extends CodeDeployOp[CreateDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentResponse] =
        visitor.createDeployment(request)
    }

    final case class CreateDeploymentConfigOp(
      request: CreateDeploymentConfigRequest
    ) extends CodeDeployOp[CreateDeploymentConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentConfigResponse] =
        visitor.createDeploymentConfig(request)
    }

    final case class CreateDeploymentGroupOp(
      request: CreateDeploymentGroupRequest
    ) extends CodeDeployOp[CreateDeploymentGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeploymentGroupResponse] =
        visitor.createDeploymentGroup(request)
    }

    final case class DeleteApplicationOp(
      request: DeleteApplicationRequest
    ) extends CodeDeployOp[DeleteApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteApplicationResponse] =
        visitor.deleteApplication(request)
    }

    final case class DeleteDeploymentConfigOp(
      request: DeleteDeploymentConfigRequest
    ) extends CodeDeployOp[DeleteDeploymentConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeploymentConfigResponse] =
        visitor.deleteDeploymentConfig(request)
    }

    final case class DeleteDeploymentGroupOp(
      request: DeleteDeploymentGroupRequest
    ) extends CodeDeployOp[DeleteDeploymentGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeploymentGroupResponse] =
        visitor.deleteDeploymentGroup(request)
    }

    final case class DeleteGitHubAccountTokenOp(
      request: DeleteGitHubAccountTokenRequest
    ) extends CodeDeployOp[DeleteGitHubAccountTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGitHubAccountTokenResponse] =
        visitor.deleteGitHubAccountToken(request)
    }

    final case class DeleteResourcesByExternalIdOp(
      request: DeleteResourcesByExternalIdRequest
    ) extends CodeDeployOp[DeleteResourcesByExternalIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcesByExternalIdResponse] =
        visitor.deleteResourcesByExternalId(request)
    }

    final case class DeregisterOnPremisesInstanceOp(
      request: DeregisterOnPremisesInstanceRequest
    ) extends CodeDeployOp[DeregisterOnPremisesInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterOnPremisesInstanceResponse] =
        visitor.deregisterOnPremisesInstance(request)
    }

    final case class GetApplicationOp(
      request: GetApplicationRequest
    ) extends CodeDeployOp[GetApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationResponse] =
        visitor.getApplication(request)
    }

    final case class GetApplicationRevisionOp(
      request: GetApplicationRevisionRequest
    ) extends CodeDeployOp[GetApplicationRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetApplicationRevisionResponse] =
        visitor.getApplicationRevision(request)
    }

    final case class GetDeploymentOp(
      request: GetDeploymentRequest
    ) extends CodeDeployOp[GetDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentResponse] =
        visitor.getDeployment(request)
    }

    final case class GetDeploymentConfigOp(
      request: GetDeploymentConfigRequest
    ) extends CodeDeployOp[GetDeploymentConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentConfigResponse] =
        visitor.getDeploymentConfig(request)
    }

    final case class GetDeploymentGroupOp(
      request: GetDeploymentGroupRequest
    ) extends CodeDeployOp[GetDeploymentGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentGroupResponse] =
        visitor.getDeploymentGroup(request)
    }

    final case class GetDeploymentTargetOp(
      request: GetDeploymentTargetRequest
    ) extends CodeDeployOp[GetDeploymentTargetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeploymentTargetResponse] =
        visitor.getDeploymentTarget(request)
    }

    final case class GetOnPremisesInstanceOp(
      request: GetOnPremisesInstanceRequest
    ) extends CodeDeployOp[GetOnPremisesInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetOnPremisesInstanceResponse] =
        visitor.getOnPremisesInstance(request)
    }

    final case class ListApplicationRevisionsOp(
      request: ListApplicationRevisionsRequest
    ) extends CodeDeployOp[ListApplicationRevisionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationRevisionsResponse] =
        visitor.listApplicationRevisions(request)
    }

    final case class ListApplicationsOp(
      request: ListApplicationsRequest
    ) extends CodeDeployOp[ListApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApplicationsResponse] =
        visitor.listApplications(request)
    }

    final case class ListDeploymentConfigsOp(
      request: ListDeploymentConfigsRequest
    ) extends CodeDeployOp[ListDeploymentConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentConfigsResponse] =
        visitor.listDeploymentConfigs(request)
    }

    final case class ListDeploymentGroupsOp(
      request: ListDeploymentGroupsRequest
    ) extends CodeDeployOp[ListDeploymentGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentGroupsResponse] =
        visitor.listDeploymentGroups(request)
    }

    final case class ListDeploymentTargetsOp(
      request: ListDeploymentTargetsRequest
    ) extends CodeDeployOp[ListDeploymentTargetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentTargetsResponse] =
        visitor.listDeploymentTargets(request)
    }

    final case class ListDeploymentsOp(
      request: ListDeploymentsRequest
    ) extends CodeDeployOp[ListDeploymentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeploymentsResponse] =
        visitor.listDeployments(request)
    }

    final case class ListGitHubAccountTokenNamesOp(
      request: ListGitHubAccountTokenNamesRequest
    ) extends CodeDeployOp[ListGitHubAccountTokenNamesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGitHubAccountTokenNamesResponse] =
        visitor.listGitHubAccountTokenNames(request)
    }

    final case class ListOnPremisesInstancesOp(
      request: ListOnPremisesInstancesRequest
    ) extends CodeDeployOp[ListOnPremisesInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOnPremisesInstancesResponse] =
        visitor.listOnPremisesInstances(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends CodeDeployOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutLifecycleEventHookExecutionStatusOp(
      request: PutLifecycleEventHookExecutionStatusRequest
    ) extends CodeDeployOp[PutLifecycleEventHookExecutionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLifecycleEventHookExecutionStatusResponse] =
        visitor.putLifecycleEventHookExecutionStatus(request)
    }

    final case class RegisterApplicationRevisionOp(
      request: RegisterApplicationRevisionRequest
    ) extends CodeDeployOp[RegisterApplicationRevisionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterApplicationRevisionResponse] =
        visitor.registerApplicationRevision(request)
    }

    final case class RegisterOnPremisesInstanceOp(
      request: RegisterOnPremisesInstanceRequest
    ) extends CodeDeployOp[RegisterOnPremisesInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterOnPremisesInstanceResponse] =
        visitor.registerOnPremisesInstance(request)
    }

    final case class RemoveTagsFromOnPremisesInstancesOp(
      request: RemoveTagsFromOnPremisesInstancesRequest
    ) extends CodeDeployOp[RemoveTagsFromOnPremisesInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RemoveTagsFromOnPremisesInstancesResponse] =
        visitor.removeTagsFromOnPremisesInstances(request)
    }

    final case class StopDeploymentOp(
      request: StopDeploymentRequest
    ) extends CodeDeployOp[StopDeploymentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopDeploymentResponse] =
        visitor.stopDeployment(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends CodeDeployOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends CodeDeployOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateApplicationOp(
      request: UpdateApplicationRequest
    ) extends CodeDeployOp[UpdateApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateApplicationResponse] =
        visitor.updateApplication(request)
    }

    final case class UpdateDeploymentGroupOp(
      request: UpdateDeploymentGroupRequest
    ) extends CodeDeployOp[UpdateDeploymentGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeploymentGroupResponse] =
        visitor.updateDeploymentGroup(request)
    }
  }

  import CodeDeployOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeDeployOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def addTagsToOnPremisesInstances(
    request: AddTagsToOnPremisesInstancesRequest
  ): CodeDeployIO[AddTagsToOnPremisesInstancesResponse] =
    FF.liftF(AddTagsToOnPremisesInstancesOp(request))

  def batchGetApplicationRevisions(
    request: BatchGetApplicationRevisionsRequest
  ): CodeDeployIO[BatchGetApplicationRevisionsResponse] =
    FF.liftF(BatchGetApplicationRevisionsOp(request))

  def batchGetApplications(
    request: BatchGetApplicationsRequest
  ): CodeDeployIO[BatchGetApplicationsResponse] =
    FF.liftF(BatchGetApplicationsOp(request))

  def batchGetDeploymentGroups(
    request: BatchGetDeploymentGroupsRequest
  ): CodeDeployIO[BatchGetDeploymentGroupsResponse] =
    FF.liftF(BatchGetDeploymentGroupsOp(request))

  def batchGetDeploymentTargets(
    request: BatchGetDeploymentTargetsRequest
  ): CodeDeployIO[BatchGetDeploymentTargetsResponse] =
    FF.liftF(BatchGetDeploymentTargetsOp(request))

  def batchGetDeployments(
    request: BatchGetDeploymentsRequest
  ): CodeDeployIO[BatchGetDeploymentsResponse] =
    FF.liftF(BatchGetDeploymentsOp(request))

  def batchGetOnPremisesInstances(
    request: BatchGetOnPremisesInstancesRequest
  ): CodeDeployIO[BatchGetOnPremisesInstancesResponse] =
    FF.liftF(BatchGetOnPremisesInstancesOp(request))

  def continueDeployment(
    request: ContinueDeploymentRequest
  ): CodeDeployIO[ContinueDeploymentResponse] =
    FF.liftF(ContinueDeploymentOp(request))

  def createApplication(
    request: CreateApplicationRequest
  ): CodeDeployIO[CreateApplicationResponse] =
    FF.liftF(CreateApplicationOp(request))

  def createDeployment(
    request: CreateDeploymentRequest
  ): CodeDeployIO[CreateDeploymentResponse] =
    FF.liftF(CreateDeploymentOp(request))

  def createDeploymentConfig(
    request: CreateDeploymentConfigRequest
  ): CodeDeployIO[CreateDeploymentConfigResponse] =
    FF.liftF(CreateDeploymentConfigOp(request))

  def createDeploymentGroup(
    request: CreateDeploymentGroupRequest
  ): CodeDeployIO[CreateDeploymentGroupResponse] =
    FF.liftF(CreateDeploymentGroupOp(request))

  def deleteApplication(
    request: DeleteApplicationRequest
  ): CodeDeployIO[DeleteApplicationResponse] =
    FF.liftF(DeleteApplicationOp(request))

  def deleteDeploymentConfig(
    request: DeleteDeploymentConfigRequest
  ): CodeDeployIO[DeleteDeploymentConfigResponse] =
    FF.liftF(DeleteDeploymentConfigOp(request))

  def deleteDeploymentGroup(
    request: DeleteDeploymentGroupRequest
  ): CodeDeployIO[DeleteDeploymentGroupResponse] =
    FF.liftF(DeleteDeploymentGroupOp(request))

  def deleteGitHubAccountToken(
    request: DeleteGitHubAccountTokenRequest
  ): CodeDeployIO[DeleteGitHubAccountTokenResponse] =
    FF.liftF(DeleteGitHubAccountTokenOp(request))

  def deleteResourcesByExternalId(
    request: DeleteResourcesByExternalIdRequest
  ): CodeDeployIO[DeleteResourcesByExternalIdResponse] =
    FF.liftF(DeleteResourcesByExternalIdOp(request))

  def deregisterOnPremisesInstance(
    request: DeregisterOnPremisesInstanceRequest
  ): CodeDeployIO[DeregisterOnPremisesInstanceResponse] =
    FF.liftF(DeregisterOnPremisesInstanceOp(request))

  def getApplication(
    request: GetApplicationRequest
  ): CodeDeployIO[GetApplicationResponse] =
    FF.liftF(GetApplicationOp(request))

  def getApplicationRevision(
    request: GetApplicationRevisionRequest
  ): CodeDeployIO[GetApplicationRevisionResponse] =
    FF.liftF(GetApplicationRevisionOp(request))

  def getDeployment(
    request: GetDeploymentRequest
  ): CodeDeployIO[GetDeploymentResponse] =
    FF.liftF(GetDeploymentOp(request))

  def getDeploymentConfig(
    request: GetDeploymentConfigRequest
  ): CodeDeployIO[GetDeploymentConfigResponse] =
    FF.liftF(GetDeploymentConfigOp(request))

  def getDeploymentGroup(
    request: GetDeploymentGroupRequest
  ): CodeDeployIO[GetDeploymentGroupResponse] =
    FF.liftF(GetDeploymentGroupOp(request))

  def getDeploymentTarget(
    request: GetDeploymentTargetRequest
  ): CodeDeployIO[GetDeploymentTargetResponse] =
    FF.liftF(GetDeploymentTargetOp(request))

  def getOnPremisesInstance(
    request: GetOnPremisesInstanceRequest
  ): CodeDeployIO[GetOnPremisesInstanceResponse] =
    FF.liftF(GetOnPremisesInstanceOp(request))

  def listApplicationRevisions(
    request: ListApplicationRevisionsRequest
  ): CodeDeployIO[ListApplicationRevisionsResponse] =
    FF.liftF(ListApplicationRevisionsOp(request))

  def listApplications(
    request: ListApplicationsRequest
  ): CodeDeployIO[ListApplicationsResponse] =
    FF.liftF(ListApplicationsOp(request))

  def listDeploymentConfigs(
    request: ListDeploymentConfigsRequest
  ): CodeDeployIO[ListDeploymentConfigsResponse] =
    FF.liftF(ListDeploymentConfigsOp(request))

  def listDeploymentGroups(
    request: ListDeploymentGroupsRequest
  ): CodeDeployIO[ListDeploymentGroupsResponse] =
    FF.liftF(ListDeploymentGroupsOp(request))

  def listDeploymentTargets(
    request: ListDeploymentTargetsRequest
  ): CodeDeployIO[ListDeploymentTargetsResponse] =
    FF.liftF(ListDeploymentTargetsOp(request))

  def listDeployments(
    request: ListDeploymentsRequest
  ): CodeDeployIO[ListDeploymentsResponse] =
    FF.liftF(ListDeploymentsOp(request))

  def listGitHubAccountTokenNames(
    request: ListGitHubAccountTokenNamesRequest
  ): CodeDeployIO[ListGitHubAccountTokenNamesResponse] =
    FF.liftF(ListGitHubAccountTokenNamesOp(request))

  def listOnPremisesInstances(
    request: ListOnPremisesInstancesRequest
  ): CodeDeployIO[ListOnPremisesInstancesResponse] =
    FF.liftF(ListOnPremisesInstancesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): CodeDeployIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putLifecycleEventHookExecutionStatus(
    request: PutLifecycleEventHookExecutionStatusRequest
  ): CodeDeployIO[PutLifecycleEventHookExecutionStatusResponse] =
    FF.liftF(PutLifecycleEventHookExecutionStatusOp(request))

  def registerApplicationRevision(
    request: RegisterApplicationRevisionRequest
  ): CodeDeployIO[RegisterApplicationRevisionResponse] =
    FF.liftF(RegisterApplicationRevisionOp(request))

  def registerOnPremisesInstance(
    request: RegisterOnPremisesInstanceRequest
  ): CodeDeployIO[RegisterOnPremisesInstanceResponse] =
    FF.liftF(RegisterOnPremisesInstanceOp(request))

  def removeTagsFromOnPremisesInstances(
    request: RemoveTagsFromOnPremisesInstancesRequest
  ): CodeDeployIO[RemoveTagsFromOnPremisesInstancesResponse] =
    FF.liftF(RemoveTagsFromOnPremisesInstancesOp(request))

  def stopDeployment(
    request: StopDeploymentRequest
  ): CodeDeployIO[StopDeploymentResponse] =
    FF.liftF(StopDeploymentOp(request))

  def tagResource(
    request: TagResourceRequest
  ): CodeDeployIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): CodeDeployIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateApplication(
    request: UpdateApplicationRequest
  ): CodeDeployIO[UpdateApplicationResponse] =
    FF.liftF(UpdateApplicationOp(request))

  def updateDeploymentGroup(
    request: UpdateDeploymentGroupRequest
  ): CodeDeployIO[UpdateDeploymentGroupResponse] =
    FF.liftF(UpdateDeploymentGroupOp(request))
}
