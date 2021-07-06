package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.workspaces.WorkSpacesClient
import software.amazon.awssdk.services.workspaces.model._


object workspaces { module =>

  // Free monad over WorkSpacesOp
  type WorkSpacesIO[A] = FF[WorkSpacesOp, A]

  sealed trait WorkSpacesOp[A] {
    def visit[F[_]](visitor: WorkSpacesOp.Visitor[F]): F[A]
  }

  object WorkSpacesOp {
    // Given a WorkSpacesClient we can embed a WorkSpacesIO program in any algebra that understands embedding.
    implicit val WorkSpacesOpEmbeddable: Embeddable[WorkSpacesOp, WorkSpacesClient] = new Embeddable[WorkSpacesOp, WorkSpacesClient] {
      def embed[A](client: WorkSpacesClient, io: WorkSpacesIO[A]): Embedded[A] = Embedded.WorkSpaces(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends WorkSpacesOp.Visitor[Kleisli[M, WorkSpacesClient, *]] {
        def associateConnectionAlias(
          request: AssociateConnectionAliasRequest
        ): Kleisli[M, WorkSpacesClient, AssociateConnectionAliasResponse] =
          primitive(_.associateConnectionAlias(request))

        def associateIpGroups(
          request: AssociateIpGroupsRequest
        ): Kleisli[M, WorkSpacesClient, AssociateIpGroupsResponse] =
          primitive(_.associateIpGroups(request))

        def authorizeIpRules(
          request: AuthorizeIpRulesRequest
        ): Kleisli[M, WorkSpacesClient, AuthorizeIpRulesResponse] =
          primitive(_.authorizeIpRules(request))

        def copyWorkspaceImage(
          request: CopyWorkspaceImageRequest
        ): Kleisli[M, WorkSpacesClient, CopyWorkspaceImageResponse] =
          primitive(_.copyWorkspaceImage(request))

        def createConnectionAlias(
          request: CreateConnectionAliasRequest
        ): Kleisli[M, WorkSpacesClient, CreateConnectionAliasResponse] =
          primitive(_.createConnectionAlias(request))

        def createIpGroup(
          request: CreateIpGroupRequest
        ): Kleisli[M, WorkSpacesClient, CreateIpGroupResponse] =
          primitive(_.createIpGroup(request))

        def createTags(
          request: CreateTagsRequest
        ): Kleisli[M, WorkSpacesClient, CreateTagsResponse] =
          primitive(_.createTags(request))

        def createWorkspaceBundle(
          request: CreateWorkspaceBundleRequest
        ): Kleisli[M, WorkSpacesClient, CreateWorkspaceBundleResponse] =
          primitive(_.createWorkspaceBundle(request))

        def createWorkspaces(
          request: CreateWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, CreateWorkspacesResponse] =
          primitive(_.createWorkspaces(request))

        def deleteConnectionAlias(
          request: DeleteConnectionAliasRequest
        ): Kleisli[M, WorkSpacesClient, DeleteConnectionAliasResponse] =
          primitive(_.deleteConnectionAlias(request))

        def deleteIpGroup(
          request: DeleteIpGroupRequest
        ): Kleisli[M, WorkSpacesClient, DeleteIpGroupResponse] =
          primitive(_.deleteIpGroup(request))

        def deleteTags(
          request: DeleteTagsRequest
        ): Kleisli[M, WorkSpacesClient, DeleteTagsResponse] =
          primitive(_.deleteTags(request))

        def deleteWorkspaceBundle(
          request: DeleteWorkspaceBundleRequest
        ): Kleisli[M, WorkSpacesClient, DeleteWorkspaceBundleResponse] =
          primitive(_.deleteWorkspaceBundle(request))

        def deleteWorkspaceImage(
          request: DeleteWorkspaceImageRequest
        ): Kleisli[M, WorkSpacesClient, DeleteWorkspaceImageResponse] =
          primitive(_.deleteWorkspaceImage(request))

        def deregisterWorkspaceDirectory(
          request: DeregisterWorkspaceDirectoryRequest
        ): Kleisli[M, WorkSpacesClient, DeregisterWorkspaceDirectoryResponse] =
          primitive(_.deregisterWorkspaceDirectory(request))

        def describeAccount(
          request: DescribeAccountRequest
        ): Kleisli[M, WorkSpacesClient, DescribeAccountResponse] =
          primitive(_.describeAccount(request))

        def describeAccountModifications(
          request: DescribeAccountModificationsRequest
        ): Kleisli[M, WorkSpacesClient, DescribeAccountModificationsResponse] =
          primitive(_.describeAccountModifications(request))

        def describeClientProperties(
          request: DescribeClientPropertiesRequest
        ): Kleisli[M, WorkSpacesClient, DescribeClientPropertiesResponse] =
          primitive(_.describeClientProperties(request))

        def describeConnectionAliasPermissions(
          request: DescribeConnectionAliasPermissionsRequest
        ): Kleisli[M, WorkSpacesClient, DescribeConnectionAliasPermissionsResponse] =
          primitive(_.describeConnectionAliasPermissions(request))

        def describeConnectionAliases(
          request: DescribeConnectionAliasesRequest
        ): Kleisli[M, WorkSpacesClient, DescribeConnectionAliasesResponse] =
          primitive(_.describeConnectionAliases(request))

        def describeIpGroups(
          request: DescribeIpGroupsRequest
        ): Kleisli[M, WorkSpacesClient, DescribeIpGroupsResponse] =
          primitive(_.describeIpGroups(request))

        def describeTags(
          request: DescribeTagsRequest
        ): Kleisli[M, WorkSpacesClient, DescribeTagsResponse] =
          primitive(_.describeTags(request))

        def describeWorkspaceBundles(
          request: DescribeWorkspaceBundlesRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspaceBundlesResponse] =
          primitive(_.describeWorkspaceBundles(request))

        def describeWorkspaceDirectories(
          request: DescribeWorkspaceDirectoriesRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspaceDirectoriesResponse] =
          primitive(_.describeWorkspaceDirectories(request))

        def describeWorkspaceImagePermissions(
          request: DescribeWorkspaceImagePermissionsRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspaceImagePermissionsResponse] =
          primitive(_.describeWorkspaceImagePermissions(request))

        def describeWorkspaceImages(
          request: DescribeWorkspaceImagesRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspaceImagesResponse] =
          primitive(_.describeWorkspaceImages(request))

        def describeWorkspaceSnapshots(
          request: DescribeWorkspaceSnapshotsRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspaceSnapshotsResponse] =
          primitive(_.describeWorkspaceSnapshots(request))

        def describeWorkspaces(
          request: DescribeWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspacesResponse] =
          primitive(_.describeWorkspaces(request))

        def describeWorkspacesConnectionStatus(
          request: DescribeWorkspacesConnectionStatusRequest
        ): Kleisli[M, WorkSpacesClient, DescribeWorkspacesConnectionStatusResponse] =
          primitive(_.describeWorkspacesConnectionStatus(request))

        def disassociateConnectionAlias(
          request: DisassociateConnectionAliasRequest
        ): Kleisli[M, WorkSpacesClient, DisassociateConnectionAliasResponse] =
          primitive(_.disassociateConnectionAlias(request))

        def disassociateIpGroups(
          request: DisassociateIpGroupsRequest
        ): Kleisli[M, WorkSpacesClient, DisassociateIpGroupsResponse] =
          primitive(_.disassociateIpGroups(request))

        def importWorkspaceImage(
          request: ImportWorkspaceImageRequest
        ): Kleisli[M, WorkSpacesClient, ImportWorkspaceImageResponse] =
          primitive(_.importWorkspaceImage(request))

        def listAvailableManagementCidrRanges(
          request: ListAvailableManagementCidrRangesRequest
        ): Kleisli[M, WorkSpacesClient, ListAvailableManagementCidrRangesResponse] =
          primitive(_.listAvailableManagementCidrRanges(request))

        def migrateWorkspace(
          request: MigrateWorkspaceRequest
        ): Kleisli[M, WorkSpacesClient, MigrateWorkspaceResponse] =
          primitive(_.migrateWorkspace(request))

        def modifyAccount(
          request: ModifyAccountRequest
        ): Kleisli[M, WorkSpacesClient, ModifyAccountResponse] =
          primitive(_.modifyAccount(request))

        def modifyClientProperties(
          request: ModifyClientPropertiesRequest
        ): Kleisli[M, WorkSpacesClient, ModifyClientPropertiesResponse] =
          primitive(_.modifyClientProperties(request))

        def modifySelfservicePermissions(
          request: ModifySelfservicePermissionsRequest
        ): Kleisli[M, WorkSpacesClient, ModifySelfservicePermissionsResponse] =
          primitive(_.modifySelfservicePermissions(request))

        def modifyWorkspaceAccessProperties(
          request: ModifyWorkspaceAccessPropertiesRequest
        ): Kleisli[M, WorkSpacesClient, ModifyWorkspaceAccessPropertiesResponse] =
          primitive(_.modifyWorkspaceAccessProperties(request))

        def modifyWorkspaceCreationProperties(
          request: ModifyWorkspaceCreationPropertiesRequest
        ): Kleisli[M, WorkSpacesClient, ModifyWorkspaceCreationPropertiesResponse] =
          primitive(_.modifyWorkspaceCreationProperties(request))

        def modifyWorkspaceProperties(
          request: ModifyWorkspacePropertiesRequest
        ): Kleisli[M, WorkSpacesClient, ModifyWorkspacePropertiesResponse] =
          primitive(_.modifyWorkspaceProperties(request))

        def modifyWorkspaceState(
          request: ModifyWorkspaceStateRequest
        ): Kleisli[M, WorkSpacesClient, ModifyWorkspaceStateResponse] =
          primitive(_.modifyWorkspaceState(request))

        def rebootWorkspaces(
          request: RebootWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, RebootWorkspacesResponse] =
          primitive(_.rebootWorkspaces(request))

        def rebuildWorkspaces(
          request: RebuildWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, RebuildWorkspacesResponse] =
          primitive(_.rebuildWorkspaces(request))

        def registerWorkspaceDirectory(
          request: RegisterWorkspaceDirectoryRequest
        ): Kleisli[M, WorkSpacesClient, RegisterWorkspaceDirectoryResponse] =
          primitive(_.registerWorkspaceDirectory(request))

        def restoreWorkspace(
          request: RestoreWorkspaceRequest
        ): Kleisli[M, WorkSpacesClient, RestoreWorkspaceResponse] =
          primitive(_.restoreWorkspace(request))

        def revokeIpRules(
          request: RevokeIpRulesRequest
        ): Kleisli[M, WorkSpacesClient, RevokeIpRulesResponse] =
          primitive(_.revokeIpRules(request))

        def startWorkspaces(
          request: StartWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, StartWorkspacesResponse] =
          primitive(_.startWorkspaces(request))

        def stopWorkspaces(
          request: StopWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, StopWorkspacesResponse] =
          primitive(_.stopWorkspaces(request))

        def terminateWorkspaces(
          request: TerminateWorkspacesRequest
        ): Kleisli[M, WorkSpacesClient, TerminateWorkspacesResponse] =
          primitive(_.terminateWorkspaces(request))

        def updateConnectionAliasPermission(
          request: UpdateConnectionAliasPermissionRequest
        ): Kleisli[M, WorkSpacesClient, UpdateConnectionAliasPermissionResponse] =
          primitive(_.updateConnectionAliasPermission(request))

        def updateRulesOfIpGroup(
          request: UpdateRulesOfIpGroupRequest
        ): Kleisli[M, WorkSpacesClient, UpdateRulesOfIpGroupResponse] =
          primitive(_.updateRulesOfIpGroup(request))

        def updateWorkspaceBundle(
          request: UpdateWorkspaceBundleRequest
        ): Kleisli[M, WorkSpacesClient, UpdateWorkspaceBundleResponse] =
          primitive(_.updateWorkspaceBundle(request))

        def updateWorkspaceImagePermission(
          request: UpdateWorkspaceImagePermissionRequest
        ): Kleisli[M, WorkSpacesClient, UpdateWorkspaceImagePermissionResponse] =
          primitive(_.updateWorkspaceImagePermission(request))

        def primitive[A](
          f: WorkSpacesClient => A
        ): Kleisli[M, WorkSpacesClient, A]
      }
    }

    trait Visitor[F[_]] extends (WorkSpacesOp ~> F) {
      final def apply[A](op: WorkSpacesOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateConnectionAlias(
        request: AssociateConnectionAliasRequest
      ): F[AssociateConnectionAliasResponse]

      def associateIpGroups(
        request: AssociateIpGroupsRequest
      ): F[AssociateIpGroupsResponse]

      def authorizeIpRules(
        request: AuthorizeIpRulesRequest
      ): F[AuthorizeIpRulesResponse]

      def copyWorkspaceImage(
        request: CopyWorkspaceImageRequest
      ): F[CopyWorkspaceImageResponse]

      def createConnectionAlias(
        request: CreateConnectionAliasRequest
      ): F[CreateConnectionAliasResponse]

      def createIpGroup(
        request: CreateIpGroupRequest
      ): F[CreateIpGroupResponse]

      def createTags(
        request: CreateTagsRequest
      ): F[CreateTagsResponse]

      def createWorkspaceBundle(
        request: CreateWorkspaceBundleRequest
      ): F[CreateWorkspaceBundleResponse]

      def createWorkspaces(
        request: CreateWorkspacesRequest
      ): F[CreateWorkspacesResponse]

      def deleteConnectionAlias(
        request: DeleteConnectionAliasRequest
      ): F[DeleteConnectionAliasResponse]

      def deleteIpGroup(
        request: DeleteIpGroupRequest
      ): F[DeleteIpGroupResponse]

      def deleteTags(
        request: DeleteTagsRequest
      ): F[DeleteTagsResponse]

      def deleteWorkspaceBundle(
        request: DeleteWorkspaceBundleRequest
      ): F[DeleteWorkspaceBundleResponse]

      def deleteWorkspaceImage(
        request: DeleteWorkspaceImageRequest
      ): F[DeleteWorkspaceImageResponse]

      def deregisterWorkspaceDirectory(
        request: DeregisterWorkspaceDirectoryRequest
      ): F[DeregisterWorkspaceDirectoryResponse]

      def describeAccount(
        request: DescribeAccountRequest
      ): F[DescribeAccountResponse]

      def describeAccountModifications(
        request: DescribeAccountModificationsRequest
      ): F[DescribeAccountModificationsResponse]

      def describeClientProperties(
        request: DescribeClientPropertiesRequest
      ): F[DescribeClientPropertiesResponse]

      def describeConnectionAliasPermissions(
        request: DescribeConnectionAliasPermissionsRequest
      ): F[DescribeConnectionAliasPermissionsResponse]

      def describeConnectionAliases(
        request: DescribeConnectionAliasesRequest
      ): F[DescribeConnectionAliasesResponse]

      def describeIpGroups(
        request: DescribeIpGroupsRequest
      ): F[DescribeIpGroupsResponse]

      def describeTags(
        request: DescribeTagsRequest
      ): F[DescribeTagsResponse]

      def describeWorkspaceBundles(
        request: DescribeWorkspaceBundlesRequest
      ): F[DescribeWorkspaceBundlesResponse]

      def describeWorkspaceDirectories(
        request: DescribeWorkspaceDirectoriesRequest
      ): F[DescribeWorkspaceDirectoriesResponse]

      def describeWorkspaceImagePermissions(
        request: DescribeWorkspaceImagePermissionsRequest
      ): F[DescribeWorkspaceImagePermissionsResponse]

      def describeWorkspaceImages(
        request: DescribeWorkspaceImagesRequest
      ): F[DescribeWorkspaceImagesResponse]

      def describeWorkspaceSnapshots(
        request: DescribeWorkspaceSnapshotsRequest
      ): F[DescribeWorkspaceSnapshotsResponse]

      def describeWorkspaces(
        request: DescribeWorkspacesRequest
      ): F[DescribeWorkspacesResponse]

      def describeWorkspacesConnectionStatus(
        request: DescribeWorkspacesConnectionStatusRequest
      ): F[DescribeWorkspacesConnectionStatusResponse]

      def disassociateConnectionAlias(
        request: DisassociateConnectionAliasRequest
      ): F[DisassociateConnectionAliasResponse]

      def disassociateIpGroups(
        request: DisassociateIpGroupsRequest
      ): F[DisassociateIpGroupsResponse]

      def importWorkspaceImage(
        request: ImportWorkspaceImageRequest
      ): F[ImportWorkspaceImageResponse]

      def listAvailableManagementCidrRanges(
        request: ListAvailableManagementCidrRangesRequest
      ): F[ListAvailableManagementCidrRangesResponse]

      def migrateWorkspace(
        request: MigrateWorkspaceRequest
      ): F[MigrateWorkspaceResponse]

      def modifyAccount(
        request: ModifyAccountRequest
      ): F[ModifyAccountResponse]

      def modifyClientProperties(
        request: ModifyClientPropertiesRequest
      ): F[ModifyClientPropertiesResponse]

      def modifySelfservicePermissions(
        request: ModifySelfservicePermissionsRequest
      ): F[ModifySelfservicePermissionsResponse]

      def modifyWorkspaceAccessProperties(
        request: ModifyWorkspaceAccessPropertiesRequest
      ): F[ModifyWorkspaceAccessPropertiesResponse]

      def modifyWorkspaceCreationProperties(
        request: ModifyWorkspaceCreationPropertiesRequest
      ): F[ModifyWorkspaceCreationPropertiesResponse]

      def modifyWorkspaceProperties(
        request: ModifyWorkspacePropertiesRequest
      ): F[ModifyWorkspacePropertiesResponse]

      def modifyWorkspaceState(
        request: ModifyWorkspaceStateRequest
      ): F[ModifyWorkspaceStateResponse]

      def rebootWorkspaces(
        request: RebootWorkspacesRequest
      ): F[RebootWorkspacesResponse]

      def rebuildWorkspaces(
        request: RebuildWorkspacesRequest
      ): F[RebuildWorkspacesResponse]

      def registerWorkspaceDirectory(
        request: RegisterWorkspaceDirectoryRequest
      ): F[RegisterWorkspaceDirectoryResponse]

      def restoreWorkspace(
        request: RestoreWorkspaceRequest
      ): F[RestoreWorkspaceResponse]

      def revokeIpRules(
        request: RevokeIpRulesRequest
      ): F[RevokeIpRulesResponse]

      def startWorkspaces(
        request: StartWorkspacesRequest
      ): F[StartWorkspacesResponse]

      def stopWorkspaces(
        request: StopWorkspacesRequest
      ): F[StopWorkspacesResponse]

      def terminateWorkspaces(
        request: TerminateWorkspacesRequest
      ): F[TerminateWorkspacesResponse]

      def updateConnectionAliasPermission(
        request: UpdateConnectionAliasPermissionRequest
      ): F[UpdateConnectionAliasPermissionResponse]

      def updateRulesOfIpGroup(
        request: UpdateRulesOfIpGroupRequest
      ): F[UpdateRulesOfIpGroupResponse]

      def updateWorkspaceBundle(
        request: UpdateWorkspaceBundleRequest
      ): F[UpdateWorkspaceBundleResponse]

      def updateWorkspaceImagePermission(
        request: UpdateWorkspaceImagePermissionRequest
      ): F[UpdateWorkspaceImagePermissionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends WorkSpacesOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateConnectionAliasOp(
      request: AssociateConnectionAliasRequest
    ) extends WorkSpacesOp[AssociateConnectionAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateConnectionAliasResponse] =
        visitor.associateConnectionAlias(request)
    }

    final case class AssociateIpGroupsOp(
      request: AssociateIpGroupsRequest
    ) extends WorkSpacesOp[AssociateIpGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateIpGroupsResponse] =
        visitor.associateIpGroups(request)
    }

    final case class AuthorizeIpRulesOp(
      request: AuthorizeIpRulesRequest
    ) extends WorkSpacesOp[AuthorizeIpRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AuthorizeIpRulesResponse] =
        visitor.authorizeIpRules(request)
    }

    final case class CopyWorkspaceImageOp(
      request: CopyWorkspaceImageRequest
    ) extends WorkSpacesOp[CopyWorkspaceImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyWorkspaceImageResponse] =
        visitor.copyWorkspaceImage(request)
    }

    final case class CreateConnectionAliasOp(
      request: CreateConnectionAliasRequest
    ) extends WorkSpacesOp[CreateConnectionAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConnectionAliasResponse] =
        visitor.createConnectionAlias(request)
    }

    final case class CreateIpGroupOp(
      request: CreateIpGroupRequest
    ) extends WorkSpacesOp[CreateIpGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIpGroupResponse] =
        visitor.createIpGroup(request)
    }

    final case class CreateTagsOp(
      request: CreateTagsRequest
    ) extends WorkSpacesOp[CreateTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagsResponse] =
        visitor.createTags(request)
    }

    final case class CreateWorkspaceBundleOp(
      request: CreateWorkspaceBundleRequest
    ) extends WorkSpacesOp[CreateWorkspaceBundleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkspaceBundleResponse] =
        visitor.createWorkspaceBundle(request)
    }

    final case class CreateWorkspacesOp(
      request: CreateWorkspacesRequest
    ) extends WorkSpacesOp[CreateWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWorkspacesResponse] =
        visitor.createWorkspaces(request)
    }

    final case class DeleteConnectionAliasOp(
      request: DeleteConnectionAliasRequest
    ) extends WorkSpacesOp[DeleteConnectionAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConnectionAliasResponse] =
        visitor.deleteConnectionAlias(request)
    }

    final case class DeleteIpGroupOp(
      request: DeleteIpGroupRequest
    ) extends WorkSpacesOp[DeleteIpGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIpGroupResponse] =
        visitor.deleteIpGroup(request)
    }

    final case class DeleteTagsOp(
      request: DeleteTagsRequest
    ) extends WorkSpacesOp[DeleteTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagsResponse] =
        visitor.deleteTags(request)
    }

    final case class DeleteWorkspaceBundleOp(
      request: DeleteWorkspaceBundleRequest
    ) extends WorkSpacesOp[DeleteWorkspaceBundleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkspaceBundleResponse] =
        visitor.deleteWorkspaceBundle(request)
    }

    final case class DeleteWorkspaceImageOp(
      request: DeleteWorkspaceImageRequest
    ) extends WorkSpacesOp[DeleteWorkspaceImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWorkspaceImageResponse] =
        visitor.deleteWorkspaceImage(request)
    }

    final case class DeregisterWorkspaceDirectoryOp(
      request: DeregisterWorkspaceDirectoryRequest
    ) extends WorkSpacesOp[DeregisterWorkspaceDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterWorkspaceDirectoryResponse] =
        visitor.deregisterWorkspaceDirectory(request)
    }

    final case class DescribeAccountOp(
      request: DescribeAccountRequest
    ) extends WorkSpacesOp[DescribeAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountResponse] =
        visitor.describeAccount(request)
    }

    final case class DescribeAccountModificationsOp(
      request: DescribeAccountModificationsRequest
    ) extends WorkSpacesOp[DescribeAccountModificationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountModificationsResponse] =
        visitor.describeAccountModifications(request)
    }

    final case class DescribeClientPropertiesOp(
      request: DescribeClientPropertiesRequest
    ) extends WorkSpacesOp[DescribeClientPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeClientPropertiesResponse] =
        visitor.describeClientProperties(request)
    }

    final case class DescribeConnectionAliasPermissionsOp(
      request: DescribeConnectionAliasPermissionsRequest
    ) extends WorkSpacesOp[DescribeConnectionAliasPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectionAliasPermissionsResponse] =
        visitor.describeConnectionAliasPermissions(request)
    }

    final case class DescribeConnectionAliasesOp(
      request: DescribeConnectionAliasesRequest
    ) extends WorkSpacesOp[DescribeConnectionAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConnectionAliasesResponse] =
        visitor.describeConnectionAliases(request)
    }

    final case class DescribeIpGroupsOp(
      request: DescribeIpGroupsRequest
    ) extends WorkSpacesOp[DescribeIpGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIpGroupsResponse] =
        visitor.describeIpGroups(request)
    }

    final case class DescribeTagsOp(
      request: DescribeTagsRequest
    ) extends WorkSpacesOp[DescribeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagsResponse] =
        visitor.describeTags(request)
    }

    final case class DescribeWorkspaceBundlesOp(
      request: DescribeWorkspaceBundlesRequest
    ) extends WorkSpacesOp[DescribeWorkspaceBundlesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspaceBundlesResponse] =
        visitor.describeWorkspaceBundles(request)
    }

    final case class DescribeWorkspaceDirectoriesOp(
      request: DescribeWorkspaceDirectoriesRequest
    ) extends WorkSpacesOp[DescribeWorkspaceDirectoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspaceDirectoriesResponse] =
        visitor.describeWorkspaceDirectories(request)
    }

    final case class DescribeWorkspaceImagePermissionsOp(
      request: DescribeWorkspaceImagePermissionsRequest
    ) extends WorkSpacesOp[DescribeWorkspaceImagePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspaceImagePermissionsResponse] =
        visitor.describeWorkspaceImagePermissions(request)
    }

    final case class DescribeWorkspaceImagesOp(
      request: DescribeWorkspaceImagesRequest
    ) extends WorkSpacesOp[DescribeWorkspaceImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspaceImagesResponse] =
        visitor.describeWorkspaceImages(request)
    }

    final case class DescribeWorkspaceSnapshotsOp(
      request: DescribeWorkspaceSnapshotsRequest
    ) extends WorkSpacesOp[DescribeWorkspaceSnapshotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspaceSnapshotsResponse] =
        visitor.describeWorkspaceSnapshots(request)
    }

    final case class DescribeWorkspacesOp(
      request: DescribeWorkspacesRequest
    ) extends WorkSpacesOp[DescribeWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspacesResponse] =
        visitor.describeWorkspaces(request)
    }

    final case class DescribeWorkspacesConnectionStatusOp(
      request: DescribeWorkspacesConnectionStatusRequest
    ) extends WorkSpacesOp[DescribeWorkspacesConnectionStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeWorkspacesConnectionStatusResponse] =
        visitor.describeWorkspacesConnectionStatus(request)
    }

    final case class DisassociateConnectionAliasOp(
      request: DisassociateConnectionAliasRequest
    ) extends WorkSpacesOp[DisassociateConnectionAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateConnectionAliasResponse] =
        visitor.disassociateConnectionAlias(request)
    }

    final case class DisassociateIpGroupsOp(
      request: DisassociateIpGroupsRequest
    ) extends WorkSpacesOp[DisassociateIpGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateIpGroupsResponse] =
        visitor.disassociateIpGroups(request)
    }

    final case class ImportWorkspaceImageOp(
      request: ImportWorkspaceImageRequest
    ) extends WorkSpacesOp[ImportWorkspaceImageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportWorkspaceImageResponse] =
        visitor.importWorkspaceImage(request)
    }

    final case class ListAvailableManagementCidrRangesOp(
      request: ListAvailableManagementCidrRangesRequest
    ) extends WorkSpacesOp[ListAvailableManagementCidrRangesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAvailableManagementCidrRangesResponse] =
        visitor.listAvailableManagementCidrRanges(request)
    }

    final case class MigrateWorkspaceOp(
      request: MigrateWorkspaceRequest
    ) extends WorkSpacesOp[MigrateWorkspaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[MigrateWorkspaceResponse] =
        visitor.migrateWorkspace(request)
    }

    final case class ModifyAccountOp(
      request: ModifyAccountRequest
    ) extends WorkSpacesOp[ModifyAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyAccountResponse] =
        visitor.modifyAccount(request)
    }

    final case class ModifyClientPropertiesOp(
      request: ModifyClientPropertiesRequest
    ) extends WorkSpacesOp[ModifyClientPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyClientPropertiesResponse] =
        visitor.modifyClientProperties(request)
    }

    final case class ModifySelfservicePermissionsOp(
      request: ModifySelfservicePermissionsRequest
    ) extends WorkSpacesOp[ModifySelfservicePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifySelfservicePermissionsResponse] =
        visitor.modifySelfservicePermissions(request)
    }

    final case class ModifyWorkspaceAccessPropertiesOp(
      request: ModifyWorkspaceAccessPropertiesRequest
    ) extends WorkSpacesOp[ModifyWorkspaceAccessPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyWorkspaceAccessPropertiesResponse] =
        visitor.modifyWorkspaceAccessProperties(request)
    }

    final case class ModifyWorkspaceCreationPropertiesOp(
      request: ModifyWorkspaceCreationPropertiesRequest
    ) extends WorkSpacesOp[ModifyWorkspaceCreationPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyWorkspaceCreationPropertiesResponse] =
        visitor.modifyWorkspaceCreationProperties(request)
    }

    final case class ModifyWorkspacePropertiesOp(
      request: ModifyWorkspacePropertiesRequest
    ) extends WorkSpacesOp[ModifyWorkspacePropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyWorkspacePropertiesResponse] =
        visitor.modifyWorkspaceProperties(request)
    }

    final case class ModifyWorkspaceStateOp(
      request: ModifyWorkspaceStateRequest
    ) extends WorkSpacesOp[ModifyWorkspaceStateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ModifyWorkspaceStateResponse] =
        visitor.modifyWorkspaceState(request)
    }

    final case class RebootWorkspacesOp(
      request: RebootWorkspacesRequest
    ) extends WorkSpacesOp[RebootWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebootWorkspacesResponse] =
        visitor.rebootWorkspaces(request)
    }

    final case class RebuildWorkspacesOp(
      request: RebuildWorkspacesRequest
    ) extends WorkSpacesOp[RebuildWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RebuildWorkspacesResponse] =
        visitor.rebuildWorkspaces(request)
    }

    final case class RegisterWorkspaceDirectoryOp(
      request: RegisterWorkspaceDirectoryRequest
    ) extends WorkSpacesOp[RegisterWorkspaceDirectoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterWorkspaceDirectoryResponse] =
        visitor.registerWorkspaceDirectory(request)
    }

    final case class RestoreWorkspaceOp(
      request: RestoreWorkspaceRequest
    ) extends WorkSpacesOp[RestoreWorkspaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreWorkspaceResponse] =
        visitor.restoreWorkspace(request)
    }

    final case class RevokeIpRulesOp(
      request: RevokeIpRulesRequest
    ) extends WorkSpacesOp[RevokeIpRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeIpRulesResponse] =
        visitor.revokeIpRules(request)
    }

    final case class StartWorkspacesOp(
      request: StartWorkspacesRequest
    ) extends WorkSpacesOp[StartWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartWorkspacesResponse] =
        visitor.startWorkspaces(request)
    }

    final case class StopWorkspacesOp(
      request: StopWorkspacesRequest
    ) extends WorkSpacesOp[StopWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopWorkspacesResponse] =
        visitor.stopWorkspaces(request)
    }

    final case class TerminateWorkspacesOp(
      request: TerminateWorkspacesRequest
    ) extends WorkSpacesOp[TerminateWorkspacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateWorkspacesResponse] =
        visitor.terminateWorkspaces(request)
    }

    final case class UpdateConnectionAliasPermissionOp(
      request: UpdateConnectionAliasPermissionRequest
    ) extends WorkSpacesOp[UpdateConnectionAliasPermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConnectionAliasPermissionResponse] =
        visitor.updateConnectionAliasPermission(request)
    }

    final case class UpdateRulesOfIpGroupOp(
      request: UpdateRulesOfIpGroupRequest
    ) extends WorkSpacesOp[UpdateRulesOfIpGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRulesOfIpGroupResponse] =
        visitor.updateRulesOfIpGroup(request)
    }

    final case class UpdateWorkspaceBundleOp(
      request: UpdateWorkspaceBundleRequest
    ) extends WorkSpacesOp[UpdateWorkspaceBundleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkspaceBundleResponse] =
        visitor.updateWorkspaceBundle(request)
    }

    final case class UpdateWorkspaceImagePermissionOp(
      request: UpdateWorkspaceImagePermissionRequest
    ) extends WorkSpacesOp[UpdateWorkspaceImagePermissionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWorkspaceImagePermissionResponse] =
        visitor.updateWorkspaceImagePermission(request)
    }
  }

  import WorkSpacesOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[WorkSpacesOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateConnectionAlias(
    request: AssociateConnectionAliasRequest
  ): WorkSpacesIO[AssociateConnectionAliasResponse] =
    FF.liftF(AssociateConnectionAliasOp(request))

  def associateIpGroups(
    request: AssociateIpGroupsRequest
  ): WorkSpacesIO[AssociateIpGroupsResponse] =
    FF.liftF(AssociateIpGroupsOp(request))

  def authorizeIpRules(
    request: AuthorizeIpRulesRequest
  ): WorkSpacesIO[AuthorizeIpRulesResponse] =
    FF.liftF(AuthorizeIpRulesOp(request))

  def copyWorkspaceImage(
    request: CopyWorkspaceImageRequest
  ): WorkSpacesIO[CopyWorkspaceImageResponse] =
    FF.liftF(CopyWorkspaceImageOp(request))

  def createConnectionAlias(
    request: CreateConnectionAliasRequest
  ): WorkSpacesIO[CreateConnectionAliasResponse] =
    FF.liftF(CreateConnectionAliasOp(request))

  def createIpGroup(
    request: CreateIpGroupRequest
  ): WorkSpacesIO[CreateIpGroupResponse] =
    FF.liftF(CreateIpGroupOp(request))

  def createTags(
    request: CreateTagsRequest
  ): WorkSpacesIO[CreateTagsResponse] =
    FF.liftF(CreateTagsOp(request))

  def createWorkspaceBundle(
    request: CreateWorkspaceBundleRequest
  ): WorkSpacesIO[CreateWorkspaceBundleResponse] =
    FF.liftF(CreateWorkspaceBundleOp(request))

  def createWorkspaces(
    request: CreateWorkspacesRequest
  ): WorkSpacesIO[CreateWorkspacesResponse] =
    FF.liftF(CreateWorkspacesOp(request))

  def deleteConnectionAlias(
    request: DeleteConnectionAliasRequest
  ): WorkSpacesIO[DeleteConnectionAliasResponse] =
    FF.liftF(DeleteConnectionAliasOp(request))

  def deleteIpGroup(
    request: DeleteIpGroupRequest
  ): WorkSpacesIO[DeleteIpGroupResponse] =
    FF.liftF(DeleteIpGroupOp(request))

  def deleteTags(
    request: DeleteTagsRequest
  ): WorkSpacesIO[DeleteTagsResponse] =
    FF.liftF(DeleteTagsOp(request))

  def deleteWorkspaceBundle(
    request: DeleteWorkspaceBundleRequest
  ): WorkSpacesIO[DeleteWorkspaceBundleResponse] =
    FF.liftF(DeleteWorkspaceBundleOp(request))

  def deleteWorkspaceImage(
    request: DeleteWorkspaceImageRequest
  ): WorkSpacesIO[DeleteWorkspaceImageResponse] =
    FF.liftF(DeleteWorkspaceImageOp(request))

  def deregisterWorkspaceDirectory(
    request: DeregisterWorkspaceDirectoryRequest
  ): WorkSpacesIO[DeregisterWorkspaceDirectoryResponse] =
    FF.liftF(DeregisterWorkspaceDirectoryOp(request))

  def describeAccount(
    request: DescribeAccountRequest
  ): WorkSpacesIO[DescribeAccountResponse] =
    FF.liftF(DescribeAccountOp(request))

  def describeAccountModifications(
    request: DescribeAccountModificationsRequest
  ): WorkSpacesIO[DescribeAccountModificationsResponse] =
    FF.liftF(DescribeAccountModificationsOp(request))

  def describeClientProperties(
    request: DescribeClientPropertiesRequest
  ): WorkSpacesIO[DescribeClientPropertiesResponse] =
    FF.liftF(DescribeClientPropertiesOp(request))

  def describeConnectionAliasPermissions(
    request: DescribeConnectionAliasPermissionsRequest
  ): WorkSpacesIO[DescribeConnectionAliasPermissionsResponse] =
    FF.liftF(DescribeConnectionAliasPermissionsOp(request))

  def describeConnectionAliases(
    request: DescribeConnectionAliasesRequest
  ): WorkSpacesIO[DescribeConnectionAliasesResponse] =
    FF.liftF(DescribeConnectionAliasesOp(request))

  def describeIpGroups(
    request: DescribeIpGroupsRequest
  ): WorkSpacesIO[DescribeIpGroupsResponse] =
    FF.liftF(DescribeIpGroupsOp(request))

  def describeTags(
    request: DescribeTagsRequest
  ): WorkSpacesIO[DescribeTagsResponse] =
    FF.liftF(DescribeTagsOp(request))

  def describeWorkspaceBundles(
    request: DescribeWorkspaceBundlesRequest
  ): WorkSpacesIO[DescribeWorkspaceBundlesResponse] =
    FF.liftF(DescribeWorkspaceBundlesOp(request))

  def describeWorkspaceDirectories(
    request: DescribeWorkspaceDirectoriesRequest
  ): WorkSpacesIO[DescribeWorkspaceDirectoriesResponse] =
    FF.liftF(DescribeWorkspaceDirectoriesOp(request))

  def describeWorkspaceImagePermissions(
    request: DescribeWorkspaceImagePermissionsRequest
  ): WorkSpacesIO[DescribeWorkspaceImagePermissionsResponse] =
    FF.liftF(DescribeWorkspaceImagePermissionsOp(request))

  def describeWorkspaceImages(
    request: DescribeWorkspaceImagesRequest
  ): WorkSpacesIO[DescribeWorkspaceImagesResponse] =
    FF.liftF(DescribeWorkspaceImagesOp(request))

  def describeWorkspaceSnapshots(
    request: DescribeWorkspaceSnapshotsRequest
  ): WorkSpacesIO[DescribeWorkspaceSnapshotsResponse] =
    FF.liftF(DescribeWorkspaceSnapshotsOp(request))

  def describeWorkspaces(
    request: DescribeWorkspacesRequest
  ): WorkSpacesIO[DescribeWorkspacesResponse] =
    FF.liftF(DescribeWorkspacesOp(request))

  def describeWorkspacesConnectionStatus(
    request: DescribeWorkspacesConnectionStatusRequest
  ): WorkSpacesIO[DescribeWorkspacesConnectionStatusResponse] =
    FF.liftF(DescribeWorkspacesConnectionStatusOp(request))

  def disassociateConnectionAlias(
    request: DisassociateConnectionAliasRequest
  ): WorkSpacesIO[DisassociateConnectionAliasResponse] =
    FF.liftF(DisassociateConnectionAliasOp(request))

  def disassociateIpGroups(
    request: DisassociateIpGroupsRequest
  ): WorkSpacesIO[DisassociateIpGroupsResponse] =
    FF.liftF(DisassociateIpGroupsOp(request))

  def importWorkspaceImage(
    request: ImportWorkspaceImageRequest
  ): WorkSpacesIO[ImportWorkspaceImageResponse] =
    FF.liftF(ImportWorkspaceImageOp(request))

  def listAvailableManagementCidrRanges(
    request: ListAvailableManagementCidrRangesRequest
  ): WorkSpacesIO[ListAvailableManagementCidrRangesResponse] =
    FF.liftF(ListAvailableManagementCidrRangesOp(request))

  def migrateWorkspace(
    request: MigrateWorkspaceRequest
  ): WorkSpacesIO[MigrateWorkspaceResponse] =
    FF.liftF(MigrateWorkspaceOp(request))

  def modifyAccount(
    request: ModifyAccountRequest
  ): WorkSpacesIO[ModifyAccountResponse] =
    FF.liftF(ModifyAccountOp(request))

  def modifyClientProperties(
    request: ModifyClientPropertiesRequest
  ): WorkSpacesIO[ModifyClientPropertiesResponse] =
    FF.liftF(ModifyClientPropertiesOp(request))

  def modifySelfservicePermissions(
    request: ModifySelfservicePermissionsRequest
  ): WorkSpacesIO[ModifySelfservicePermissionsResponse] =
    FF.liftF(ModifySelfservicePermissionsOp(request))

  def modifyWorkspaceAccessProperties(
    request: ModifyWorkspaceAccessPropertiesRequest
  ): WorkSpacesIO[ModifyWorkspaceAccessPropertiesResponse] =
    FF.liftF(ModifyWorkspaceAccessPropertiesOp(request))

  def modifyWorkspaceCreationProperties(
    request: ModifyWorkspaceCreationPropertiesRequest
  ): WorkSpacesIO[ModifyWorkspaceCreationPropertiesResponse] =
    FF.liftF(ModifyWorkspaceCreationPropertiesOp(request))

  def modifyWorkspaceProperties(
    request: ModifyWorkspacePropertiesRequest
  ): WorkSpacesIO[ModifyWorkspacePropertiesResponse] =
    FF.liftF(ModifyWorkspacePropertiesOp(request))

  def modifyWorkspaceState(
    request: ModifyWorkspaceStateRequest
  ): WorkSpacesIO[ModifyWorkspaceStateResponse] =
    FF.liftF(ModifyWorkspaceStateOp(request))

  def rebootWorkspaces(
    request: RebootWorkspacesRequest
  ): WorkSpacesIO[RebootWorkspacesResponse] =
    FF.liftF(RebootWorkspacesOp(request))

  def rebuildWorkspaces(
    request: RebuildWorkspacesRequest
  ): WorkSpacesIO[RebuildWorkspacesResponse] =
    FF.liftF(RebuildWorkspacesOp(request))

  def registerWorkspaceDirectory(
    request: RegisterWorkspaceDirectoryRequest
  ): WorkSpacesIO[RegisterWorkspaceDirectoryResponse] =
    FF.liftF(RegisterWorkspaceDirectoryOp(request))

  def restoreWorkspace(
    request: RestoreWorkspaceRequest
  ): WorkSpacesIO[RestoreWorkspaceResponse] =
    FF.liftF(RestoreWorkspaceOp(request))

  def revokeIpRules(
    request: RevokeIpRulesRequest
  ): WorkSpacesIO[RevokeIpRulesResponse] =
    FF.liftF(RevokeIpRulesOp(request))

  def startWorkspaces(
    request: StartWorkspacesRequest
  ): WorkSpacesIO[StartWorkspacesResponse] =
    FF.liftF(StartWorkspacesOp(request))

  def stopWorkspaces(
    request: StopWorkspacesRequest
  ): WorkSpacesIO[StopWorkspacesResponse] =
    FF.liftF(StopWorkspacesOp(request))

  def terminateWorkspaces(
    request: TerminateWorkspacesRequest
  ): WorkSpacesIO[TerminateWorkspacesResponse] =
    FF.liftF(TerminateWorkspacesOp(request))

  def updateConnectionAliasPermission(
    request: UpdateConnectionAliasPermissionRequest
  ): WorkSpacesIO[UpdateConnectionAliasPermissionResponse] =
    FF.liftF(UpdateConnectionAliasPermissionOp(request))

  def updateRulesOfIpGroup(
    request: UpdateRulesOfIpGroupRequest
  ): WorkSpacesIO[UpdateRulesOfIpGroupResponse] =
    FF.liftF(UpdateRulesOfIpGroupOp(request))

  def updateWorkspaceBundle(
    request: UpdateWorkspaceBundleRequest
  ): WorkSpacesIO[UpdateWorkspaceBundleResponse] =
    FF.liftF(UpdateWorkspaceBundleOp(request))

  def updateWorkspaceImagePermission(
    request: UpdateWorkspaceImagePermissionRequest
  ): WorkSpacesIO[UpdateWorkspaceImagePermissionResponse] =
    FF.liftF(UpdateWorkspaceImagePermissionOp(request))
}
