package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.quicksight.QuickSightClient
import software.amazon.awssdk.services.quicksight.model._


object quicksight { module =>

  // Free monad over QuickSightOp
  type QuickSightIO[A] = FF[QuickSightOp, A]

  sealed trait QuickSightOp[A] {
    def visit[F[_]](visitor: QuickSightOp.Visitor[F]): F[A]
  }

  object QuickSightOp {
    // Given a QuickSightClient we can embed a QuickSightIO program in any algebra that understands embedding.
    implicit val QuickSightOpEmbeddable: Embeddable[QuickSightOp, QuickSightClient] = new Embeddable[QuickSightOp, QuickSightClient] {
      def embed[A](client: QuickSightClient, io: QuickSightIO[A]): Embedded[A] = Embedded.QuickSight(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends QuickSightOp.Visitor[Kleisli[M, QuickSightClient, *]] {
        def cancelIngestion(
          request: CancelIngestionRequest
        ): Kleisli[M, QuickSightClient, CancelIngestionResponse] =
          primitive(_.cancelIngestion(request))

        def createAccountCustomization(
          request: CreateAccountCustomizationRequest
        ): Kleisli[M, QuickSightClient, CreateAccountCustomizationResponse] =
          primitive(_.createAccountCustomization(request))

        def createAnalysis(
          request: CreateAnalysisRequest
        ): Kleisli[M, QuickSightClient, CreateAnalysisResponse] =
          primitive(_.createAnalysis(request))

        def createDashboard(
          request: CreateDashboardRequest
        ): Kleisli[M, QuickSightClient, CreateDashboardResponse] =
          primitive(_.createDashboard(request))

        def createDataSet(
          request: CreateDataSetRequest
        ): Kleisli[M, QuickSightClient, CreateDataSetResponse] =
          primitive(_.createDataSet(request))

        def createDataSource(
          request: CreateDataSourceRequest
        ): Kleisli[M, QuickSightClient, CreateDataSourceResponse] =
          primitive(_.createDataSource(request))

        def createGroup(
          request: CreateGroupRequest
        ): Kleisli[M, QuickSightClient, CreateGroupResponse] =
          primitive(_.createGroup(request))

        def createGroupMembership(
          request: CreateGroupMembershipRequest
        ): Kleisli[M, QuickSightClient, CreateGroupMembershipResponse] =
          primitive(_.createGroupMembership(request))

        def createIAMPolicyAssignment(
          request: CreateIamPolicyAssignmentRequest
        ): Kleisli[M, QuickSightClient, CreateIamPolicyAssignmentResponse] =
          primitive(_.createIAMPolicyAssignment(request))

        def createIngestion(
          request: CreateIngestionRequest
        ): Kleisli[M, QuickSightClient, CreateIngestionResponse] =
          primitive(_.createIngestion(request))

        def createNamespace(
          request: CreateNamespaceRequest
        ): Kleisli[M, QuickSightClient, CreateNamespaceResponse] =
          primitive(_.createNamespace(request))

        def createTemplate(
          request: CreateTemplateRequest
        ): Kleisli[M, QuickSightClient, CreateTemplateResponse] =
          primitive(_.createTemplate(request))

        def createTemplateAlias(
          request: CreateTemplateAliasRequest
        ): Kleisli[M, QuickSightClient, CreateTemplateAliasResponse] =
          primitive(_.createTemplateAlias(request))

        def createTheme(
          request: CreateThemeRequest
        ): Kleisli[M, QuickSightClient, CreateThemeResponse] =
          primitive(_.createTheme(request))

        def createThemeAlias(
          request: CreateThemeAliasRequest
        ): Kleisli[M, QuickSightClient, CreateThemeAliasResponse] =
          primitive(_.createThemeAlias(request))

        def deleteAccountCustomization(
          request: DeleteAccountCustomizationRequest
        ): Kleisli[M, QuickSightClient, DeleteAccountCustomizationResponse] =
          primitive(_.deleteAccountCustomization(request))

        def deleteAnalysis(
          request: DeleteAnalysisRequest
        ): Kleisli[M, QuickSightClient, DeleteAnalysisResponse] =
          primitive(_.deleteAnalysis(request))

        def deleteDashboard(
          request: DeleteDashboardRequest
        ): Kleisli[M, QuickSightClient, DeleteDashboardResponse] =
          primitive(_.deleteDashboard(request))

        def deleteDataSet(
          request: DeleteDataSetRequest
        ): Kleisli[M, QuickSightClient, DeleteDataSetResponse] =
          primitive(_.deleteDataSet(request))

        def deleteDataSource(
          request: DeleteDataSourceRequest
        ): Kleisli[M, QuickSightClient, DeleteDataSourceResponse] =
          primitive(_.deleteDataSource(request))

        def deleteGroup(
          request: DeleteGroupRequest
        ): Kleisli[M, QuickSightClient, DeleteGroupResponse] =
          primitive(_.deleteGroup(request))

        def deleteGroupMembership(
          request: DeleteGroupMembershipRequest
        ): Kleisli[M, QuickSightClient, DeleteGroupMembershipResponse] =
          primitive(_.deleteGroupMembership(request))

        def deleteIAMPolicyAssignment(
          request: DeleteIamPolicyAssignmentRequest
        ): Kleisli[M, QuickSightClient, DeleteIamPolicyAssignmentResponse] =
          primitive(_.deleteIAMPolicyAssignment(request))

        def deleteNamespace(
          request: DeleteNamespaceRequest
        ): Kleisli[M, QuickSightClient, DeleteNamespaceResponse] =
          primitive(_.deleteNamespace(request))

        def deleteTemplate(
          request: DeleteTemplateRequest
        ): Kleisli[M, QuickSightClient, DeleteTemplateResponse] =
          primitive(_.deleteTemplate(request))

        def deleteTemplateAlias(
          request: DeleteTemplateAliasRequest
        ): Kleisli[M, QuickSightClient, DeleteTemplateAliasResponse] =
          primitive(_.deleteTemplateAlias(request))

        def deleteTheme(
          request: DeleteThemeRequest
        ): Kleisli[M, QuickSightClient, DeleteThemeResponse] =
          primitive(_.deleteTheme(request))

        def deleteThemeAlias(
          request: DeleteThemeAliasRequest
        ): Kleisli[M, QuickSightClient, DeleteThemeAliasResponse] =
          primitive(_.deleteThemeAlias(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, QuickSightClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def deleteUserByPrincipalId(
          request: DeleteUserByPrincipalIdRequest
        ): Kleisli[M, QuickSightClient, DeleteUserByPrincipalIdResponse] =
          primitive(_.deleteUserByPrincipalId(request))

        def describeAccountCustomization(
          request: DescribeAccountCustomizationRequest
        ): Kleisli[M, QuickSightClient, DescribeAccountCustomizationResponse] =
          primitive(_.describeAccountCustomization(request))

        def describeAccountSettings(
          request: DescribeAccountSettingsRequest
        ): Kleisli[M, QuickSightClient, DescribeAccountSettingsResponse] =
          primitive(_.describeAccountSettings(request))

        def describeAnalysis(
          request: DescribeAnalysisRequest
        ): Kleisli[M, QuickSightClient, DescribeAnalysisResponse] =
          primitive(_.describeAnalysis(request))

        def describeAnalysisPermissions(
          request: DescribeAnalysisPermissionsRequest
        ): Kleisli[M, QuickSightClient, DescribeAnalysisPermissionsResponse] =
          primitive(_.describeAnalysisPermissions(request))

        def describeDashboard(
          request: DescribeDashboardRequest
        ): Kleisli[M, QuickSightClient, DescribeDashboardResponse] =
          primitive(_.describeDashboard(request))

        def describeDashboardPermissions(
          request: DescribeDashboardPermissionsRequest
        ): Kleisli[M, QuickSightClient, DescribeDashboardPermissionsResponse] =
          primitive(_.describeDashboardPermissions(request))

        def describeDataSet(
          request: DescribeDataSetRequest
        ): Kleisli[M, QuickSightClient, DescribeDataSetResponse] =
          primitive(_.describeDataSet(request))

        def describeDataSetPermissions(
          request: DescribeDataSetPermissionsRequest
        ): Kleisli[M, QuickSightClient, DescribeDataSetPermissionsResponse] =
          primitive(_.describeDataSetPermissions(request))

        def describeDataSource(
          request: DescribeDataSourceRequest
        ): Kleisli[M, QuickSightClient, DescribeDataSourceResponse] =
          primitive(_.describeDataSource(request))

        def describeDataSourcePermissions(
          request: DescribeDataSourcePermissionsRequest
        ): Kleisli[M, QuickSightClient, DescribeDataSourcePermissionsResponse] =
          primitive(_.describeDataSourcePermissions(request))

        def describeGroup(
          request: DescribeGroupRequest
        ): Kleisli[M, QuickSightClient, DescribeGroupResponse] =
          primitive(_.describeGroup(request))

        def describeIAMPolicyAssignment(
          request: DescribeIamPolicyAssignmentRequest
        ): Kleisli[M, QuickSightClient, DescribeIamPolicyAssignmentResponse] =
          primitive(_.describeIAMPolicyAssignment(request))

        def describeIngestion(
          request: DescribeIngestionRequest
        ): Kleisli[M, QuickSightClient, DescribeIngestionResponse] =
          primitive(_.describeIngestion(request))

        def describeNamespace(
          request: DescribeNamespaceRequest
        ): Kleisli[M, QuickSightClient, DescribeNamespaceResponse] =
          primitive(_.describeNamespace(request))

        def describeTemplate(
          request: DescribeTemplateRequest
        ): Kleisli[M, QuickSightClient, DescribeTemplateResponse] =
          primitive(_.describeTemplate(request))

        def describeTemplateAlias(
          request: DescribeTemplateAliasRequest
        ): Kleisli[M, QuickSightClient, DescribeTemplateAliasResponse] =
          primitive(_.describeTemplateAlias(request))

        def describeTemplatePermissions(
          request: DescribeTemplatePermissionsRequest
        ): Kleisli[M, QuickSightClient, DescribeTemplatePermissionsResponse] =
          primitive(_.describeTemplatePermissions(request))

        def describeTheme(
          request: DescribeThemeRequest
        ): Kleisli[M, QuickSightClient, DescribeThemeResponse] =
          primitive(_.describeTheme(request))

        def describeThemeAlias(
          request: DescribeThemeAliasRequest
        ): Kleisli[M, QuickSightClient, DescribeThemeAliasResponse] =
          primitive(_.describeThemeAlias(request))

        def describeThemePermissions(
          request: DescribeThemePermissionsRequest
        ): Kleisli[M, QuickSightClient, DescribeThemePermissionsResponse] =
          primitive(_.describeThemePermissions(request))

        def describeUser(
          request: DescribeUserRequest
        ): Kleisli[M, QuickSightClient, DescribeUserResponse] =
          primitive(_.describeUser(request))

        def getDashboardEmbedUrl(
          request: GetDashboardEmbedUrlRequest
        ): Kleisli[M, QuickSightClient, GetDashboardEmbedUrlResponse] =
          primitive(_.getDashboardEmbedUrl(request))

        def getSessionEmbedUrl(
          request: GetSessionEmbedUrlRequest
        ): Kleisli[M, QuickSightClient, GetSessionEmbedUrlResponse] =
          primitive(_.getSessionEmbedUrl(request))

        def listAnalyses(
          request: ListAnalysesRequest
        ): Kleisli[M, QuickSightClient, ListAnalysesResponse] =
          primitive(_.listAnalyses(request))

        def listDashboardVersions(
          request: ListDashboardVersionsRequest
        ): Kleisli[M, QuickSightClient, ListDashboardVersionsResponse] =
          primitive(_.listDashboardVersions(request))

        def listDashboards(
          request: ListDashboardsRequest
        ): Kleisli[M, QuickSightClient, ListDashboardsResponse] =
          primitive(_.listDashboards(request))

        def listDataSets(
          request: ListDataSetsRequest
        ): Kleisli[M, QuickSightClient, ListDataSetsResponse] =
          primitive(_.listDataSets(request))

        def listDataSources(
          request: ListDataSourcesRequest
        ): Kleisli[M, QuickSightClient, ListDataSourcesResponse] =
          primitive(_.listDataSources(request))

        def listGroupMemberships(
          request: ListGroupMembershipsRequest
        ): Kleisli[M, QuickSightClient, ListGroupMembershipsResponse] =
          primitive(_.listGroupMemberships(request))

        def listGroups(
          request: ListGroupsRequest
        ): Kleisli[M, QuickSightClient, ListGroupsResponse] =
          primitive(_.listGroups(request))

        def listIAMPolicyAssignments(
          request: ListIamPolicyAssignmentsRequest
        ): Kleisli[M, QuickSightClient, ListIamPolicyAssignmentsResponse] =
          primitive(_.listIAMPolicyAssignments(request))

        def listIAMPolicyAssignmentsForUser(
          request: ListIamPolicyAssignmentsForUserRequest
        ): Kleisli[M, QuickSightClient, ListIamPolicyAssignmentsForUserResponse] =
          primitive(_.listIAMPolicyAssignmentsForUser(request))

        def listIngestions(
          request: ListIngestionsRequest
        ): Kleisli[M, QuickSightClient, ListIngestionsResponse] =
          primitive(_.listIngestions(request))

        def listNamespaces(
          request: ListNamespacesRequest
        ): Kleisli[M, QuickSightClient, ListNamespacesResponse] =
          primitive(_.listNamespaces(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, QuickSightClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listTemplateAliases(
          request: ListTemplateAliasesRequest
        ): Kleisli[M, QuickSightClient, ListTemplateAliasesResponse] =
          primitive(_.listTemplateAliases(request))

        def listTemplateVersions(
          request: ListTemplateVersionsRequest
        ): Kleisli[M, QuickSightClient, ListTemplateVersionsResponse] =
          primitive(_.listTemplateVersions(request))

        def listTemplates(
          request: ListTemplatesRequest
        ): Kleisli[M, QuickSightClient, ListTemplatesResponse] =
          primitive(_.listTemplates(request))

        def listThemeAliases(
          request: ListThemeAliasesRequest
        ): Kleisli[M, QuickSightClient, ListThemeAliasesResponse] =
          primitive(_.listThemeAliases(request))

        def listThemeVersions(
          request: ListThemeVersionsRequest
        ): Kleisli[M, QuickSightClient, ListThemeVersionsResponse] =
          primitive(_.listThemeVersions(request))

        def listThemes(
          request: ListThemesRequest
        ): Kleisli[M, QuickSightClient, ListThemesResponse] =
          primitive(_.listThemes(request))

        def listUserGroups(
          request: ListUserGroupsRequest
        ): Kleisli[M, QuickSightClient, ListUserGroupsResponse] =
          primitive(_.listUserGroups(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, QuickSightClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def registerUser(
          request: RegisterUserRequest
        ): Kleisli[M, QuickSightClient, RegisterUserResponse] =
          primitive(_.registerUser(request))

        def restoreAnalysis(
          request: RestoreAnalysisRequest
        ): Kleisli[M, QuickSightClient, RestoreAnalysisResponse] =
          primitive(_.restoreAnalysis(request))

        def searchAnalyses(
          request: SearchAnalysesRequest
        ): Kleisli[M, QuickSightClient, SearchAnalysesResponse] =
          primitive(_.searchAnalyses(request))

        def searchDashboards(
          request: SearchDashboardsRequest
        ): Kleisli[M, QuickSightClient, SearchDashboardsResponse] =
          primitive(_.searchDashboards(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, QuickSightClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, QuickSightClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccountCustomization(
          request: UpdateAccountCustomizationRequest
        ): Kleisli[M, QuickSightClient, UpdateAccountCustomizationResponse] =
          primitive(_.updateAccountCustomization(request))

        def updateAccountSettings(
          request: UpdateAccountSettingsRequest
        ): Kleisli[M, QuickSightClient, UpdateAccountSettingsResponse] =
          primitive(_.updateAccountSettings(request))

        def updateAnalysis(
          request: UpdateAnalysisRequest
        ): Kleisli[M, QuickSightClient, UpdateAnalysisResponse] =
          primitive(_.updateAnalysis(request))

        def updateAnalysisPermissions(
          request: UpdateAnalysisPermissionsRequest
        ): Kleisli[M, QuickSightClient, UpdateAnalysisPermissionsResponse] =
          primitive(_.updateAnalysisPermissions(request))

        def updateDashboard(
          request: UpdateDashboardRequest
        ): Kleisli[M, QuickSightClient, UpdateDashboardResponse] =
          primitive(_.updateDashboard(request))

        def updateDashboardPermissions(
          request: UpdateDashboardPermissionsRequest
        ): Kleisli[M, QuickSightClient, UpdateDashboardPermissionsResponse] =
          primitive(_.updateDashboardPermissions(request))

        def updateDashboardPublishedVersion(
          request: UpdateDashboardPublishedVersionRequest
        ): Kleisli[M, QuickSightClient, UpdateDashboardPublishedVersionResponse] =
          primitive(_.updateDashboardPublishedVersion(request))

        def updateDataSet(
          request: UpdateDataSetRequest
        ): Kleisli[M, QuickSightClient, UpdateDataSetResponse] =
          primitive(_.updateDataSet(request))

        def updateDataSetPermissions(
          request: UpdateDataSetPermissionsRequest
        ): Kleisli[M, QuickSightClient, UpdateDataSetPermissionsResponse] =
          primitive(_.updateDataSetPermissions(request))

        def updateDataSource(
          request: UpdateDataSourceRequest
        ): Kleisli[M, QuickSightClient, UpdateDataSourceResponse] =
          primitive(_.updateDataSource(request))

        def updateDataSourcePermissions(
          request: UpdateDataSourcePermissionsRequest
        ): Kleisli[M, QuickSightClient, UpdateDataSourcePermissionsResponse] =
          primitive(_.updateDataSourcePermissions(request))

        def updateGroup(
          request: UpdateGroupRequest
        ): Kleisli[M, QuickSightClient, UpdateGroupResponse] =
          primitive(_.updateGroup(request))

        def updateIAMPolicyAssignment(
          request: UpdateIamPolicyAssignmentRequest
        ): Kleisli[M, QuickSightClient, UpdateIamPolicyAssignmentResponse] =
          primitive(_.updateIAMPolicyAssignment(request))

        def updateTemplate(
          request: UpdateTemplateRequest
        ): Kleisli[M, QuickSightClient, UpdateTemplateResponse] =
          primitive(_.updateTemplate(request))

        def updateTemplateAlias(
          request: UpdateTemplateAliasRequest
        ): Kleisli[M, QuickSightClient, UpdateTemplateAliasResponse] =
          primitive(_.updateTemplateAlias(request))

        def updateTemplatePermissions(
          request: UpdateTemplatePermissionsRequest
        ): Kleisli[M, QuickSightClient, UpdateTemplatePermissionsResponse] =
          primitive(_.updateTemplatePermissions(request))

        def updateTheme(
          request: UpdateThemeRequest
        ): Kleisli[M, QuickSightClient, UpdateThemeResponse] =
          primitive(_.updateTheme(request))

        def updateThemeAlias(
          request: UpdateThemeAliasRequest
        ): Kleisli[M, QuickSightClient, UpdateThemeAliasResponse] =
          primitive(_.updateThemeAlias(request))

        def updateThemePermissions(
          request: UpdateThemePermissionsRequest
        ): Kleisli[M, QuickSightClient, UpdateThemePermissionsResponse] =
          primitive(_.updateThemePermissions(request))

        def updateUser(
          request: UpdateUserRequest
        ): Kleisli[M, QuickSightClient, UpdateUserResponse] =
          primitive(_.updateUser(request))

        def primitive[A](
          f: QuickSightClient => A
        ): Kleisli[M, QuickSightClient, A]
      }
    }

    trait Visitor[F[_]] extends (QuickSightOp ~> F) {
      final def apply[A](op: QuickSightOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def cancelIngestion(
        request: CancelIngestionRequest
      ): F[CancelIngestionResponse]

      def createAccountCustomization(
        request: CreateAccountCustomizationRequest
      ): F[CreateAccountCustomizationResponse]

      def createAnalysis(
        request: CreateAnalysisRequest
      ): F[CreateAnalysisResponse]

      def createDashboard(
        request: CreateDashboardRequest
      ): F[CreateDashboardResponse]

      def createDataSet(
        request: CreateDataSetRequest
      ): F[CreateDataSetResponse]

      def createDataSource(
        request: CreateDataSourceRequest
      ): F[CreateDataSourceResponse]

      def createGroup(
        request: CreateGroupRequest
      ): F[CreateGroupResponse]

      def createGroupMembership(
        request: CreateGroupMembershipRequest
      ): F[CreateGroupMembershipResponse]

      def createIAMPolicyAssignment(
        request: CreateIamPolicyAssignmentRequest
      ): F[CreateIamPolicyAssignmentResponse]

      def createIngestion(
        request: CreateIngestionRequest
      ): F[CreateIngestionResponse]

      def createNamespace(
        request: CreateNamespaceRequest
      ): F[CreateNamespaceResponse]

      def createTemplate(
        request: CreateTemplateRequest
      ): F[CreateTemplateResponse]

      def createTemplateAlias(
        request: CreateTemplateAliasRequest
      ): F[CreateTemplateAliasResponse]

      def createTheme(
        request: CreateThemeRequest
      ): F[CreateThemeResponse]

      def createThemeAlias(
        request: CreateThemeAliasRequest
      ): F[CreateThemeAliasResponse]

      def deleteAccountCustomization(
        request: DeleteAccountCustomizationRequest
      ): F[DeleteAccountCustomizationResponse]

      def deleteAnalysis(
        request: DeleteAnalysisRequest
      ): F[DeleteAnalysisResponse]

      def deleteDashboard(
        request: DeleteDashboardRequest
      ): F[DeleteDashboardResponse]

      def deleteDataSet(
        request: DeleteDataSetRequest
      ): F[DeleteDataSetResponse]

      def deleteDataSource(
        request: DeleteDataSourceRequest
      ): F[DeleteDataSourceResponse]

      def deleteGroup(
        request: DeleteGroupRequest
      ): F[DeleteGroupResponse]

      def deleteGroupMembership(
        request: DeleteGroupMembershipRequest
      ): F[DeleteGroupMembershipResponse]

      def deleteIAMPolicyAssignment(
        request: DeleteIamPolicyAssignmentRequest
      ): F[DeleteIamPolicyAssignmentResponse]

      def deleteNamespace(
        request: DeleteNamespaceRequest
      ): F[DeleteNamespaceResponse]

      def deleteTemplate(
        request: DeleteTemplateRequest
      ): F[DeleteTemplateResponse]

      def deleteTemplateAlias(
        request: DeleteTemplateAliasRequest
      ): F[DeleteTemplateAliasResponse]

      def deleteTheme(
        request: DeleteThemeRequest
      ): F[DeleteThemeResponse]

      def deleteThemeAlias(
        request: DeleteThemeAliasRequest
      ): F[DeleteThemeAliasResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def deleteUserByPrincipalId(
        request: DeleteUserByPrincipalIdRequest
      ): F[DeleteUserByPrincipalIdResponse]

      def describeAccountCustomization(
        request: DescribeAccountCustomizationRequest
      ): F[DescribeAccountCustomizationResponse]

      def describeAccountSettings(
        request: DescribeAccountSettingsRequest
      ): F[DescribeAccountSettingsResponse]

      def describeAnalysis(
        request: DescribeAnalysisRequest
      ): F[DescribeAnalysisResponse]

      def describeAnalysisPermissions(
        request: DescribeAnalysisPermissionsRequest
      ): F[DescribeAnalysisPermissionsResponse]

      def describeDashboard(
        request: DescribeDashboardRequest
      ): F[DescribeDashboardResponse]

      def describeDashboardPermissions(
        request: DescribeDashboardPermissionsRequest
      ): F[DescribeDashboardPermissionsResponse]

      def describeDataSet(
        request: DescribeDataSetRequest
      ): F[DescribeDataSetResponse]

      def describeDataSetPermissions(
        request: DescribeDataSetPermissionsRequest
      ): F[DescribeDataSetPermissionsResponse]

      def describeDataSource(
        request: DescribeDataSourceRequest
      ): F[DescribeDataSourceResponse]

      def describeDataSourcePermissions(
        request: DescribeDataSourcePermissionsRequest
      ): F[DescribeDataSourcePermissionsResponse]

      def describeGroup(
        request: DescribeGroupRequest
      ): F[DescribeGroupResponse]

      def describeIAMPolicyAssignment(
        request: DescribeIamPolicyAssignmentRequest
      ): F[DescribeIamPolicyAssignmentResponse]

      def describeIngestion(
        request: DescribeIngestionRequest
      ): F[DescribeIngestionResponse]

      def describeNamespace(
        request: DescribeNamespaceRequest
      ): F[DescribeNamespaceResponse]

      def describeTemplate(
        request: DescribeTemplateRequest
      ): F[DescribeTemplateResponse]

      def describeTemplateAlias(
        request: DescribeTemplateAliasRequest
      ): F[DescribeTemplateAliasResponse]

      def describeTemplatePermissions(
        request: DescribeTemplatePermissionsRequest
      ): F[DescribeTemplatePermissionsResponse]

      def describeTheme(
        request: DescribeThemeRequest
      ): F[DescribeThemeResponse]

      def describeThemeAlias(
        request: DescribeThemeAliasRequest
      ): F[DescribeThemeAliasResponse]

      def describeThemePermissions(
        request: DescribeThemePermissionsRequest
      ): F[DescribeThemePermissionsResponse]

      def describeUser(
        request: DescribeUserRequest
      ): F[DescribeUserResponse]

      def getDashboardEmbedUrl(
        request: GetDashboardEmbedUrlRequest
      ): F[GetDashboardEmbedUrlResponse]

      def getSessionEmbedUrl(
        request: GetSessionEmbedUrlRequest
      ): F[GetSessionEmbedUrlResponse]

      def listAnalyses(
        request: ListAnalysesRequest
      ): F[ListAnalysesResponse]

      def listDashboardVersions(
        request: ListDashboardVersionsRequest
      ): F[ListDashboardVersionsResponse]

      def listDashboards(
        request: ListDashboardsRequest
      ): F[ListDashboardsResponse]

      def listDataSets(
        request: ListDataSetsRequest
      ): F[ListDataSetsResponse]

      def listDataSources(
        request: ListDataSourcesRequest
      ): F[ListDataSourcesResponse]

      def listGroupMemberships(
        request: ListGroupMembershipsRequest
      ): F[ListGroupMembershipsResponse]

      def listGroups(
        request: ListGroupsRequest
      ): F[ListGroupsResponse]

      def listIAMPolicyAssignments(
        request: ListIamPolicyAssignmentsRequest
      ): F[ListIamPolicyAssignmentsResponse]

      def listIAMPolicyAssignmentsForUser(
        request: ListIamPolicyAssignmentsForUserRequest
      ): F[ListIamPolicyAssignmentsForUserResponse]

      def listIngestions(
        request: ListIngestionsRequest
      ): F[ListIngestionsResponse]

      def listNamespaces(
        request: ListNamespacesRequest
      ): F[ListNamespacesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listTemplateAliases(
        request: ListTemplateAliasesRequest
      ): F[ListTemplateAliasesResponse]

      def listTemplateVersions(
        request: ListTemplateVersionsRequest
      ): F[ListTemplateVersionsResponse]

      def listTemplates(
        request: ListTemplatesRequest
      ): F[ListTemplatesResponse]

      def listThemeAliases(
        request: ListThemeAliasesRequest
      ): F[ListThemeAliasesResponse]

      def listThemeVersions(
        request: ListThemeVersionsRequest
      ): F[ListThemeVersionsResponse]

      def listThemes(
        request: ListThemesRequest
      ): F[ListThemesResponse]

      def listUserGroups(
        request: ListUserGroupsRequest
      ): F[ListUserGroupsResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def registerUser(
        request: RegisterUserRequest
      ): F[RegisterUserResponse]

      def restoreAnalysis(
        request: RestoreAnalysisRequest
      ): F[RestoreAnalysisResponse]

      def searchAnalyses(
        request: SearchAnalysesRequest
      ): F[SearchAnalysesResponse]

      def searchDashboards(
        request: SearchDashboardsRequest
      ): F[SearchDashboardsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccountCustomization(
        request: UpdateAccountCustomizationRequest
      ): F[UpdateAccountCustomizationResponse]

      def updateAccountSettings(
        request: UpdateAccountSettingsRequest
      ): F[UpdateAccountSettingsResponse]

      def updateAnalysis(
        request: UpdateAnalysisRequest
      ): F[UpdateAnalysisResponse]

      def updateAnalysisPermissions(
        request: UpdateAnalysisPermissionsRequest
      ): F[UpdateAnalysisPermissionsResponse]

      def updateDashboard(
        request: UpdateDashboardRequest
      ): F[UpdateDashboardResponse]

      def updateDashboardPermissions(
        request: UpdateDashboardPermissionsRequest
      ): F[UpdateDashboardPermissionsResponse]

      def updateDashboardPublishedVersion(
        request: UpdateDashboardPublishedVersionRequest
      ): F[UpdateDashboardPublishedVersionResponse]

      def updateDataSet(
        request: UpdateDataSetRequest
      ): F[UpdateDataSetResponse]

      def updateDataSetPermissions(
        request: UpdateDataSetPermissionsRequest
      ): F[UpdateDataSetPermissionsResponse]

      def updateDataSource(
        request: UpdateDataSourceRequest
      ): F[UpdateDataSourceResponse]

      def updateDataSourcePermissions(
        request: UpdateDataSourcePermissionsRequest
      ): F[UpdateDataSourcePermissionsResponse]

      def updateGroup(
        request: UpdateGroupRequest
      ): F[UpdateGroupResponse]

      def updateIAMPolicyAssignment(
        request: UpdateIamPolicyAssignmentRequest
      ): F[UpdateIamPolicyAssignmentResponse]

      def updateTemplate(
        request: UpdateTemplateRequest
      ): F[UpdateTemplateResponse]

      def updateTemplateAlias(
        request: UpdateTemplateAliasRequest
      ): F[UpdateTemplateAliasResponse]

      def updateTemplatePermissions(
        request: UpdateTemplatePermissionsRequest
      ): F[UpdateTemplatePermissionsResponse]

      def updateTheme(
        request: UpdateThemeRequest
      ): F[UpdateThemeResponse]

      def updateThemeAlias(
        request: UpdateThemeAliasRequest
      ): F[UpdateThemeAliasResponse]

      def updateThemePermissions(
        request: UpdateThemePermissionsRequest
      ): F[UpdateThemePermissionsResponse]

      def updateUser(
        request: UpdateUserRequest
      ): F[UpdateUserResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends QuickSightOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CancelIngestionOp(
      request: CancelIngestionRequest
    ) extends QuickSightOp[CancelIngestionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CancelIngestionResponse] =
        visitor.cancelIngestion(request)
    }

    final case class CreateAccountCustomizationOp(
      request: CreateAccountCustomizationRequest
    ) extends QuickSightOp[CreateAccountCustomizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccountCustomizationResponse] =
        visitor.createAccountCustomization(request)
    }

    final case class CreateAnalysisOp(
      request: CreateAnalysisRequest
    ) extends QuickSightOp[CreateAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAnalysisResponse] =
        visitor.createAnalysis(request)
    }

    final case class CreateDashboardOp(
      request: CreateDashboardRequest
    ) extends QuickSightOp[CreateDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDashboardResponse] =
        visitor.createDashboard(request)
    }

    final case class CreateDataSetOp(
      request: CreateDataSetRequest
    ) extends QuickSightOp[CreateDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSetResponse] =
        visitor.createDataSet(request)
    }

    final case class CreateDataSourceOp(
      request: CreateDataSourceRequest
    ) extends QuickSightOp[CreateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDataSourceResponse] =
        visitor.createDataSource(request)
    }

    final case class CreateGroupOp(
      request: CreateGroupRequest
    ) extends QuickSightOp[CreateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupResponse] =
        visitor.createGroup(request)
    }

    final case class CreateGroupMembershipOp(
      request: CreateGroupMembershipRequest
    ) extends QuickSightOp[CreateGroupMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGroupMembershipResponse] =
        visitor.createGroupMembership(request)
    }

    final case class CreateIAMPolicyAssignmentOp(
      request: CreateIamPolicyAssignmentRequest
    ) extends QuickSightOp[CreateIamPolicyAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIamPolicyAssignmentResponse] =
        visitor.createIAMPolicyAssignment(request)
    }

    final case class CreateIngestionOp(
      request: CreateIngestionRequest
    ) extends QuickSightOp[CreateIngestionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIngestionResponse] =
        visitor.createIngestion(request)
    }

    final case class CreateNamespaceOp(
      request: CreateNamespaceRequest
    ) extends QuickSightOp[CreateNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNamespaceResponse] =
        visitor.createNamespace(request)
    }

    final case class CreateTemplateOp(
      request: CreateTemplateRequest
    ) extends QuickSightOp[CreateTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTemplateResponse] =
        visitor.createTemplate(request)
    }

    final case class CreateTemplateAliasOp(
      request: CreateTemplateAliasRequest
    ) extends QuickSightOp[CreateTemplateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTemplateAliasResponse] =
        visitor.createTemplateAlias(request)
    }

    final case class CreateThemeOp(
      request: CreateThemeRequest
    ) extends QuickSightOp[CreateThemeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThemeResponse] =
        visitor.createTheme(request)
    }

    final case class CreateThemeAliasOp(
      request: CreateThemeAliasRequest
    ) extends QuickSightOp[CreateThemeAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateThemeAliasResponse] =
        visitor.createThemeAlias(request)
    }

    final case class DeleteAccountCustomizationOp(
      request: DeleteAccountCustomizationRequest
    ) extends QuickSightOp[DeleteAccountCustomizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountCustomizationResponse] =
        visitor.deleteAccountCustomization(request)
    }

    final case class DeleteAnalysisOp(
      request: DeleteAnalysisRequest
    ) extends QuickSightOp[DeleteAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAnalysisResponse] =
        visitor.deleteAnalysis(request)
    }

    final case class DeleteDashboardOp(
      request: DeleteDashboardRequest
    ) extends QuickSightOp[DeleteDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDashboardResponse] =
        visitor.deleteDashboard(request)
    }

    final case class DeleteDataSetOp(
      request: DeleteDataSetRequest
    ) extends QuickSightOp[DeleteDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataSetResponse] =
        visitor.deleteDataSet(request)
    }

    final case class DeleteDataSourceOp(
      request: DeleteDataSourceRequest
    ) extends QuickSightOp[DeleteDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDataSourceResponse] =
        visitor.deleteDataSource(request)
    }

    final case class DeleteGroupOp(
      request: DeleteGroupRequest
    ) extends QuickSightOp[DeleteGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupResponse] =
        visitor.deleteGroup(request)
    }

    final case class DeleteGroupMembershipOp(
      request: DeleteGroupMembershipRequest
    ) extends QuickSightOp[DeleteGroupMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGroupMembershipResponse] =
        visitor.deleteGroupMembership(request)
    }

    final case class DeleteIAMPolicyAssignmentOp(
      request: DeleteIamPolicyAssignmentRequest
    ) extends QuickSightOp[DeleteIamPolicyAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIamPolicyAssignmentResponse] =
        visitor.deleteIAMPolicyAssignment(request)
    }

    final case class DeleteNamespaceOp(
      request: DeleteNamespaceRequest
    ) extends QuickSightOp[DeleteNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNamespaceResponse] =
        visitor.deleteNamespace(request)
    }

    final case class DeleteTemplateOp(
      request: DeleteTemplateRequest
    ) extends QuickSightOp[DeleteTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTemplateResponse] =
        visitor.deleteTemplate(request)
    }

    final case class DeleteTemplateAliasOp(
      request: DeleteTemplateAliasRequest
    ) extends QuickSightOp[DeleteTemplateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTemplateAliasResponse] =
        visitor.deleteTemplateAlias(request)
    }

    final case class DeleteThemeOp(
      request: DeleteThemeRequest
    ) extends QuickSightOp[DeleteThemeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThemeResponse] =
        visitor.deleteTheme(request)
    }

    final case class DeleteThemeAliasOp(
      request: DeleteThemeAliasRequest
    ) extends QuickSightOp[DeleteThemeAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteThemeAliasResponse] =
        visitor.deleteThemeAlias(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends QuickSightOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DeleteUserByPrincipalIdOp(
      request: DeleteUserByPrincipalIdRequest
    ) extends QuickSightOp[DeleteUserByPrincipalIdResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserByPrincipalIdResponse] =
        visitor.deleteUserByPrincipalId(request)
    }

    final case class DescribeAccountCustomizationOp(
      request: DescribeAccountCustomizationRequest
    ) extends QuickSightOp[DescribeAccountCustomizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountCustomizationResponse] =
        visitor.describeAccountCustomization(request)
    }

    final case class DescribeAccountSettingsOp(
      request: DescribeAccountSettingsRequest
    ) extends QuickSightOp[DescribeAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccountSettingsResponse] =
        visitor.describeAccountSettings(request)
    }

    final case class DescribeAnalysisOp(
      request: DescribeAnalysisRequest
    ) extends QuickSightOp[DescribeAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnalysisResponse] =
        visitor.describeAnalysis(request)
    }

    final case class DescribeAnalysisPermissionsOp(
      request: DescribeAnalysisPermissionsRequest
    ) extends QuickSightOp[DescribeAnalysisPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAnalysisPermissionsResponse] =
        visitor.describeAnalysisPermissions(request)
    }

    final case class DescribeDashboardOp(
      request: DescribeDashboardRequest
    ) extends QuickSightOp[DescribeDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDashboardResponse] =
        visitor.describeDashboard(request)
    }

    final case class DescribeDashboardPermissionsOp(
      request: DescribeDashboardPermissionsRequest
    ) extends QuickSightOp[DescribeDashboardPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDashboardPermissionsResponse] =
        visitor.describeDashboardPermissions(request)
    }

    final case class DescribeDataSetOp(
      request: DescribeDataSetRequest
    ) extends QuickSightOp[DescribeDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataSetResponse] =
        visitor.describeDataSet(request)
    }

    final case class DescribeDataSetPermissionsOp(
      request: DescribeDataSetPermissionsRequest
    ) extends QuickSightOp[DescribeDataSetPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataSetPermissionsResponse] =
        visitor.describeDataSetPermissions(request)
    }

    final case class DescribeDataSourceOp(
      request: DescribeDataSourceRequest
    ) extends QuickSightOp[DescribeDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataSourceResponse] =
        visitor.describeDataSource(request)
    }

    final case class DescribeDataSourcePermissionsOp(
      request: DescribeDataSourcePermissionsRequest
    ) extends QuickSightOp[DescribeDataSourcePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDataSourcePermissionsResponse] =
        visitor.describeDataSourcePermissions(request)
    }

    final case class DescribeGroupOp(
      request: DescribeGroupRequest
    ) extends QuickSightOp[DescribeGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGroupResponse] =
        visitor.describeGroup(request)
    }

    final case class DescribeIAMPolicyAssignmentOp(
      request: DescribeIamPolicyAssignmentRequest
    ) extends QuickSightOp[DescribeIamPolicyAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIamPolicyAssignmentResponse] =
        visitor.describeIAMPolicyAssignment(request)
    }

    final case class DescribeIngestionOp(
      request: DescribeIngestionRequest
    ) extends QuickSightOp[DescribeIngestionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeIngestionResponse] =
        visitor.describeIngestion(request)
    }

    final case class DescribeNamespaceOp(
      request: DescribeNamespaceRequest
    ) extends QuickSightOp[DescribeNamespaceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeNamespaceResponse] =
        visitor.describeNamespace(request)
    }

    final case class DescribeTemplateOp(
      request: DescribeTemplateRequest
    ) extends QuickSightOp[DescribeTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTemplateResponse] =
        visitor.describeTemplate(request)
    }

    final case class DescribeTemplateAliasOp(
      request: DescribeTemplateAliasRequest
    ) extends QuickSightOp[DescribeTemplateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTemplateAliasResponse] =
        visitor.describeTemplateAlias(request)
    }

    final case class DescribeTemplatePermissionsOp(
      request: DescribeTemplatePermissionsRequest
    ) extends QuickSightOp[DescribeTemplatePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTemplatePermissionsResponse] =
        visitor.describeTemplatePermissions(request)
    }

    final case class DescribeThemeOp(
      request: DescribeThemeRequest
    ) extends QuickSightOp[DescribeThemeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThemeResponse] =
        visitor.describeTheme(request)
    }

    final case class DescribeThemeAliasOp(
      request: DescribeThemeAliasRequest
    ) extends QuickSightOp[DescribeThemeAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThemeAliasResponse] =
        visitor.describeThemeAlias(request)
    }

    final case class DescribeThemePermissionsOp(
      request: DescribeThemePermissionsRequest
    ) extends QuickSightOp[DescribeThemePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeThemePermissionsResponse] =
        visitor.describeThemePermissions(request)
    }

    final case class DescribeUserOp(
      request: DescribeUserRequest
    ) extends QuickSightOp[DescribeUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserResponse] =
        visitor.describeUser(request)
    }

    final case class GetDashboardEmbedUrlOp(
      request: GetDashboardEmbedUrlRequest
    ) extends QuickSightOp[GetDashboardEmbedUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDashboardEmbedUrlResponse] =
        visitor.getDashboardEmbedUrl(request)
    }

    final case class GetSessionEmbedUrlOp(
      request: GetSessionEmbedUrlRequest
    ) extends QuickSightOp[GetSessionEmbedUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSessionEmbedUrlResponse] =
        visitor.getSessionEmbedUrl(request)
    }

    final case class ListAnalysesOp(
      request: ListAnalysesRequest
    ) extends QuickSightOp[ListAnalysesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAnalysesResponse] =
        visitor.listAnalyses(request)
    }

    final case class ListDashboardVersionsOp(
      request: ListDashboardVersionsRequest
    ) extends QuickSightOp[ListDashboardVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDashboardVersionsResponse] =
        visitor.listDashboardVersions(request)
    }

    final case class ListDashboardsOp(
      request: ListDashboardsRequest
    ) extends QuickSightOp[ListDashboardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDashboardsResponse] =
        visitor.listDashboards(request)
    }

    final case class ListDataSetsOp(
      request: ListDataSetsRequest
    ) extends QuickSightOp[ListDataSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSetsResponse] =
        visitor.listDataSets(request)
    }

    final case class ListDataSourcesOp(
      request: ListDataSourcesRequest
    ) extends QuickSightOp[ListDataSourcesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDataSourcesResponse] =
        visitor.listDataSources(request)
    }

    final case class ListGroupMembershipsOp(
      request: ListGroupMembershipsRequest
    ) extends QuickSightOp[ListGroupMembershipsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupMembershipsResponse] =
        visitor.listGroupMemberships(request)
    }

    final case class ListGroupsOp(
      request: ListGroupsRequest
    ) extends QuickSightOp[ListGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGroupsResponse] =
        visitor.listGroups(request)
    }

    final case class ListIAMPolicyAssignmentsOp(
      request: ListIamPolicyAssignmentsRequest
    ) extends QuickSightOp[ListIamPolicyAssignmentsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIamPolicyAssignmentsResponse] =
        visitor.listIAMPolicyAssignments(request)
    }

    final case class ListIAMPolicyAssignmentsForUserOp(
      request: ListIamPolicyAssignmentsForUserRequest
    ) extends QuickSightOp[ListIamPolicyAssignmentsForUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIamPolicyAssignmentsForUserResponse] =
        visitor.listIAMPolicyAssignmentsForUser(request)
    }

    final case class ListIngestionsOp(
      request: ListIngestionsRequest
    ) extends QuickSightOp[ListIngestionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIngestionsResponse] =
        visitor.listIngestions(request)
    }

    final case class ListNamespacesOp(
      request: ListNamespacesRequest
    ) extends QuickSightOp[ListNamespacesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListNamespacesResponse] =
        visitor.listNamespaces(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends QuickSightOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListTemplateAliasesOp(
      request: ListTemplateAliasesRequest
    ) extends QuickSightOp[ListTemplateAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTemplateAliasesResponse] =
        visitor.listTemplateAliases(request)
    }

    final case class ListTemplateVersionsOp(
      request: ListTemplateVersionsRequest
    ) extends QuickSightOp[ListTemplateVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTemplateVersionsResponse] =
        visitor.listTemplateVersions(request)
    }

    final case class ListTemplatesOp(
      request: ListTemplatesRequest
    ) extends QuickSightOp[ListTemplatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTemplatesResponse] =
        visitor.listTemplates(request)
    }

    final case class ListThemeAliasesOp(
      request: ListThemeAliasesRequest
    ) extends QuickSightOp[ListThemeAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThemeAliasesResponse] =
        visitor.listThemeAliases(request)
    }

    final case class ListThemeVersionsOp(
      request: ListThemeVersionsRequest
    ) extends QuickSightOp[ListThemeVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThemeVersionsResponse] =
        visitor.listThemeVersions(request)
    }

    final case class ListThemesOp(
      request: ListThemesRequest
    ) extends QuickSightOp[ListThemesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListThemesResponse] =
        visitor.listThemes(request)
    }

    final case class ListUserGroupsOp(
      request: ListUserGroupsRequest
    ) extends QuickSightOp[ListUserGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserGroupsResponse] =
        visitor.listUserGroups(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends QuickSightOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class RegisterUserOp(
      request: RegisterUserRequest
    ) extends QuickSightOp[RegisterUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterUserResponse] =
        visitor.registerUser(request)
    }

    final case class RestoreAnalysisOp(
      request: RestoreAnalysisRequest
    ) extends QuickSightOp[RestoreAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestoreAnalysisResponse] =
        visitor.restoreAnalysis(request)
    }

    final case class SearchAnalysesOp(
      request: SearchAnalysesRequest
    ) extends QuickSightOp[SearchAnalysesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchAnalysesResponse] =
        visitor.searchAnalyses(request)
    }

    final case class SearchDashboardsOp(
      request: SearchDashboardsRequest
    ) extends QuickSightOp[SearchDashboardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchDashboardsResponse] =
        visitor.searchDashboards(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends QuickSightOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends QuickSightOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccountCustomizationOp(
      request: UpdateAccountCustomizationRequest
    ) extends QuickSightOp[UpdateAccountCustomizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountCustomizationResponse] =
        visitor.updateAccountCustomization(request)
    }

    final case class UpdateAccountSettingsOp(
      request: UpdateAccountSettingsRequest
    ) extends QuickSightOp[UpdateAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountSettingsResponse] =
        visitor.updateAccountSettings(request)
    }

    final case class UpdateAnalysisOp(
      request: UpdateAnalysisRequest
    ) extends QuickSightOp[UpdateAnalysisResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAnalysisResponse] =
        visitor.updateAnalysis(request)
    }

    final case class UpdateAnalysisPermissionsOp(
      request: UpdateAnalysisPermissionsRequest
    ) extends QuickSightOp[UpdateAnalysisPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAnalysisPermissionsResponse] =
        visitor.updateAnalysisPermissions(request)
    }

    final case class UpdateDashboardOp(
      request: UpdateDashboardRequest
    ) extends QuickSightOp[UpdateDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDashboardResponse] =
        visitor.updateDashboard(request)
    }

    final case class UpdateDashboardPermissionsOp(
      request: UpdateDashboardPermissionsRequest
    ) extends QuickSightOp[UpdateDashboardPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDashboardPermissionsResponse] =
        visitor.updateDashboardPermissions(request)
    }

    final case class UpdateDashboardPublishedVersionOp(
      request: UpdateDashboardPublishedVersionRequest
    ) extends QuickSightOp[UpdateDashboardPublishedVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDashboardPublishedVersionResponse] =
        visitor.updateDashboardPublishedVersion(request)
    }

    final case class UpdateDataSetOp(
      request: UpdateDataSetRequest
    ) extends QuickSightOp[UpdateDataSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSetResponse] =
        visitor.updateDataSet(request)
    }

    final case class UpdateDataSetPermissionsOp(
      request: UpdateDataSetPermissionsRequest
    ) extends QuickSightOp[UpdateDataSetPermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSetPermissionsResponse] =
        visitor.updateDataSetPermissions(request)
    }

    final case class UpdateDataSourceOp(
      request: UpdateDataSourceRequest
    ) extends QuickSightOp[UpdateDataSourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSourceResponse] =
        visitor.updateDataSource(request)
    }

    final case class UpdateDataSourcePermissionsOp(
      request: UpdateDataSourcePermissionsRequest
    ) extends QuickSightOp[UpdateDataSourcePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDataSourcePermissionsResponse] =
        visitor.updateDataSourcePermissions(request)
    }

    final case class UpdateGroupOp(
      request: UpdateGroupRequest
    ) extends QuickSightOp[UpdateGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGroupResponse] =
        visitor.updateGroup(request)
    }

    final case class UpdateIAMPolicyAssignmentOp(
      request: UpdateIamPolicyAssignmentRequest
    ) extends QuickSightOp[UpdateIamPolicyAssignmentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateIamPolicyAssignmentResponse] =
        visitor.updateIAMPolicyAssignment(request)
    }

    final case class UpdateTemplateOp(
      request: UpdateTemplateRequest
    ) extends QuickSightOp[UpdateTemplateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTemplateResponse] =
        visitor.updateTemplate(request)
    }

    final case class UpdateTemplateAliasOp(
      request: UpdateTemplateAliasRequest
    ) extends QuickSightOp[UpdateTemplateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTemplateAliasResponse] =
        visitor.updateTemplateAlias(request)
    }

    final case class UpdateTemplatePermissionsOp(
      request: UpdateTemplatePermissionsRequest
    ) extends QuickSightOp[UpdateTemplatePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTemplatePermissionsResponse] =
        visitor.updateTemplatePermissions(request)
    }

    final case class UpdateThemeOp(
      request: UpdateThemeRequest
    ) extends QuickSightOp[UpdateThemeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThemeResponse] =
        visitor.updateTheme(request)
    }

    final case class UpdateThemeAliasOp(
      request: UpdateThemeAliasRequest
    ) extends QuickSightOp[UpdateThemeAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThemeAliasResponse] =
        visitor.updateThemeAlias(request)
    }

    final case class UpdateThemePermissionsOp(
      request: UpdateThemePermissionsRequest
    ) extends QuickSightOp[UpdateThemePermissionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateThemePermissionsResponse] =
        visitor.updateThemePermissions(request)
    }

    final case class UpdateUserOp(
      request: UpdateUserRequest
    ) extends QuickSightOp[UpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserResponse] =
        visitor.updateUser(request)
    }
  }

  import QuickSightOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[QuickSightOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def cancelIngestion(
    request: CancelIngestionRequest
  ): QuickSightIO[CancelIngestionResponse] =
    FF.liftF(CancelIngestionOp(request))

  def createAccountCustomization(
    request: CreateAccountCustomizationRequest
  ): QuickSightIO[CreateAccountCustomizationResponse] =
    FF.liftF(CreateAccountCustomizationOp(request))

  def createAnalysis(
    request: CreateAnalysisRequest
  ): QuickSightIO[CreateAnalysisResponse] =
    FF.liftF(CreateAnalysisOp(request))

  def createDashboard(
    request: CreateDashboardRequest
  ): QuickSightIO[CreateDashboardResponse] =
    FF.liftF(CreateDashboardOp(request))

  def createDataSet(
    request: CreateDataSetRequest
  ): QuickSightIO[CreateDataSetResponse] =
    FF.liftF(CreateDataSetOp(request))

  def createDataSource(
    request: CreateDataSourceRequest
  ): QuickSightIO[CreateDataSourceResponse] =
    FF.liftF(CreateDataSourceOp(request))

  def createGroup(
    request: CreateGroupRequest
  ): QuickSightIO[CreateGroupResponse] =
    FF.liftF(CreateGroupOp(request))

  def createGroupMembership(
    request: CreateGroupMembershipRequest
  ): QuickSightIO[CreateGroupMembershipResponse] =
    FF.liftF(CreateGroupMembershipOp(request))

  def createIAMPolicyAssignment(
    request: CreateIamPolicyAssignmentRequest
  ): QuickSightIO[CreateIamPolicyAssignmentResponse] =
    FF.liftF(CreateIAMPolicyAssignmentOp(request))

  def createIngestion(
    request: CreateIngestionRequest
  ): QuickSightIO[CreateIngestionResponse] =
    FF.liftF(CreateIngestionOp(request))

  def createNamespace(
    request: CreateNamespaceRequest
  ): QuickSightIO[CreateNamespaceResponse] =
    FF.liftF(CreateNamespaceOp(request))

  def createTemplate(
    request: CreateTemplateRequest
  ): QuickSightIO[CreateTemplateResponse] =
    FF.liftF(CreateTemplateOp(request))

  def createTemplateAlias(
    request: CreateTemplateAliasRequest
  ): QuickSightIO[CreateTemplateAliasResponse] =
    FF.liftF(CreateTemplateAliasOp(request))

  def createTheme(
    request: CreateThemeRequest
  ): QuickSightIO[CreateThemeResponse] =
    FF.liftF(CreateThemeOp(request))

  def createThemeAlias(
    request: CreateThemeAliasRequest
  ): QuickSightIO[CreateThemeAliasResponse] =
    FF.liftF(CreateThemeAliasOp(request))

  def deleteAccountCustomization(
    request: DeleteAccountCustomizationRequest
  ): QuickSightIO[DeleteAccountCustomizationResponse] =
    FF.liftF(DeleteAccountCustomizationOp(request))

  def deleteAnalysis(
    request: DeleteAnalysisRequest
  ): QuickSightIO[DeleteAnalysisResponse] =
    FF.liftF(DeleteAnalysisOp(request))

  def deleteDashboard(
    request: DeleteDashboardRequest
  ): QuickSightIO[DeleteDashboardResponse] =
    FF.liftF(DeleteDashboardOp(request))

  def deleteDataSet(
    request: DeleteDataSetRequest
  ): QuickSightIO[DeleteDataSetResponse] =
    FF.liftF(DeleteDataSetOp(request))

  def deleteDataSource(
    request: DeleteDataSourceRequest
  ): QuickSightIO[DeleteDataSourceResponse] =
    FF.liftF(DeleteDataSourceOp(request))

  def deleteGroup(
    request: DeleteGroupRequest
  ): QuickSightIO[DeleteGroupResponse] =
    FF.liftF(DeleteGroupOp(request))

  def deleteGroupMembership(
    request: DeleteGroupMembershipRequest
  ): QuickSightIO[DeleteGroupMembershipResponse] =
    FF.liftF(DeleteGroupMembershipOp(request))

  def deleteIAMPolicyAssignment(
    request: DeleteIamPolicyAssignmentRequest
  ): QuickSightIO[DeleteIamPolicyAssignmentResponse] =
    FF.liftF(DeleteIAMPolicyAssignmentOp(request))

  def deleteNamespace(
    request: DeleteNamespaceRequest
  ): QuickSightIO[DeleteNamespaceResponse] =
    FF.liftF(DeleteNamespaceOp(request))

  def deleteTemplate(
    request: DeleteTemplateRequest
  ): QuickSightIO[DeleteTemplateResponse] =
    FF.liftF(DeleteTemplateOp(request))

  def deleteTemplateAlias(
    request: DeleteTemplateAliasRequest
  ): QuickSightIO[DeleteTemplateAliasResponse] =
    FF.liftF(DeleteTemplateAliasOp(request))

  def deleteTheme(
    request: DeleteThemeRequest
  ): QuickSightIO[DeleteThemeResponse] =
    FF.liftF(DeleteThemeOp(request))

  def deleteThemeAlias(
    request: DeleteThemeAliasRequest
  ): QuickSightIO[DeleteThemeAliasResponse] =
    FF.liftF(DeleteThemeAliasOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): QuickSightIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def deleteUserByPrincipalId(
    request: DeleteUserByPrincipalIdRequest
  ): QuickSightIO[DeleteUserByPrincipalIdResponse] =
    FF.liftF(DeleteUserByPrincipalIdOp(request))

  def describeAccountCustomization(
    request: DescribeAccountCustomizationRequest
  ): QuickSightIO[DescribeAccountCustomizationResponse] =
    FF.liftF(DescribeAccountCustomizationOp(request))

  def describeAccountSettings(
    request: DescribeAccountSettingsRequest
  ): QuickSightIO[DescribeAccountSettingsResponse] =
    FF.liftF(DescribeAccountSettingsOp(request))

  def describeAnalysis(
    request: DescribeAnalysisRequest
  ): QuickSightIO[DescribeAnalysisResponse] =
    FF.liftF(DescribeAnalysisOp(request))

  def describeAnalysisPermissions(
    request: DescribeAnalysisPermissionsRequest
  ): QuickSightIO[DescribeAnalysisPermissionsResponse] =
    FF.liftF(DescribeAnalysisPermissionsOp(request))

  def describeDashboard(
    request: DescribeDashboardRequest
  ): QuickSightIO[DescribeDashboardResponse] =
    FF.liftF(DescribeDashboardOp(request))

  def describeDashboardPermissions(
    request: DescribeDashboardPermissionsRequest
  ): QuickSightIO[DescribeDashboardPermissionsResponse] =
    FF.liftF(DescribeDashboardPermissionsOp(request))

  def describeDataSet(
    request: DescribeDataSetRequest
  ): QuickSightIO[DescribeDataSetResponse] =
    FF.liftF(DescribeDataSetOp(request))

  def describeDataSetPermissions(
    request: DescribeDataSetPermissionsRequest
  ): QuickSightIO[DescribeDataSetPermissionsResponse] =
    FF.liftF(DescribeDataSetPermissionsOp(request))

  def describeDataSource(
    request: DescribeDataSourceRequest
  ): QuickSightIO[DescribeDataSourceResponse] =
    FF.liftF(DescribeDataSourceOp(request))

  def describeDataSourcePermissions(
    request: DescribeDataSourcePermissionsRequest
  ): QuickSightIO[DescribeDataSourcePermissionsResponse] =
    FF.liftF(DescribeDataSourcePermissionsOp(request))

  def describeGroup(
    request: DescribeGroupRequest
  ): QuickSightIO[DescribeGroupResponse] =
    FF.liftF(DescribeGroupOp(request))

  def describeIAMPolicyAssignment(
    request: DescribeIamPolicyAssignmentRequest
  ): QuickSightIO[DescribeIamPolicyAssignmentResponse] =
    FF.liftF(DescribeIAMPolicyAssignmentOp(request))

  def describeIngestion(
    request: DescribeIngestionRequest
  ): QuickSightIO[DescribeIngestionResponse] =
    FF.liftF(DescribeIngestionOp(request))

  def describeNamespace(
    request: DescribeNamespaceRequest
  ): QuickSightIO[DescribeNamespaceResponse] =
    FF.liftF(DescribeNamespaceOp(request))

  def describeTemplate(
    request: DescribeTemplateRequest
  ): QuickSightIO[DescribeTemplateResponse] =
    FF.liftF(DescribeTemplateOp(request))

  def describeTemplateAlias(
    request: DescribeTemplateAliasRequest
  ): QuickSightIO[DescribeTemplateAliasResponse] =
    FF.liftF(DescribeTemplateAliasOp(request))

  def describeTemplatePermissions(
    request: DescribeTemplatePermissionsRequest
  ): QuickSightIO[DescribeTemplatePermissionsResponse] =
    FF.liftF(DescribeTemplatePermissionsOp(request))

  def describeTheme(
    request: DescribeThemeRequest
  ): QuickSightIO[DescribeThemeResponse] =
    FF.liftF(DescribeThemeOp(request))

  def describeThemeAlias(
    request: DescribeThemeAliasRequest
  ): QuickSightIO[DescribeThemeAliasResponse] =
    FF.liftF(DescribeThemeAliasOp(request))

  def describeThemePermissions(
    request: DescribeThemePermissionsRequest
  ): QuickSightIO[DescribeThemePermissionsResponse] =
    FF.liftF(DescribeThemePermissionsOp(request))

  def describeUser(
    request: DescribeUserRequest
  ): QuickSightIO[DescribeUserResponse] =
    FF.liftF(DescribeUserOp(request))

  def getDashboardEmbedUrl(
    request: GetDashboardEmbedUrlRequest
  ): QuickSightIO[GetDashboardEmbedUrlResponse] =
    FF.liftF(GetDashboardEmbedUrlOp(request))

  def getSessionEmbedUrl(
    request: GetSessionEmbedUrlRequest
  ): QuickSightIO[GetSessionEmbedUrlResponse] =
    FF.liftF(GetSessionEmbedUrlOp(request))

  def listAnalyses(
    request: ListAnalysesRequest
  ): QuickSightIO[ListAnalysesResponse] =
    FF.liftF(ListAnalysesOp(request))

  def listDashboardVersions(
    request: ListDashboardVersionsRequest
  ): QuickSightIO[ListDashboardVersionsResponse] =
    FF.liftF(ListDashboardVersionsOp(request))

  def listDashboards(
    request: ListDashboardsRequest
  ): QuickSightIO[ListDashboardsResponse] =
    FF.liftF(ListDashboardsOp(request))

  def listDataSets(
    request: ListDataSetsRequest
  ): QuickSightIO[ListDataSetsResponse] =
    FF.liftF(ListDataSetsOp(request))

  def listDataSources(
    request: ListDataSourcesRequest
  ): QuickSightIO[ListDataSourcesResponse] =
    FF.liftF(ListDataSourcesOp(request))

  def listGroupMemberships(
    request: ListGroupMembershipsRequest
  ): QuickSightIO[ListGroupMembershipsResponse] =
    FF.liftF(ListGroupMembershipsOp(request))

  def listGroups(
    request: ListGroupsRequest
  ): QuickSightIO[ListGroupsResponse] =
    FF.liftF(ListGroupsOp(request))

  def listIAMPolicyAssignments(
    request: ListIamPolicyAssignmentsRequest
  ): QuickSightIO[ListIamPolicyAssignmentsResponse] =
    FF.liftF(ListIAMPolicyAssignmentsOp(request))

  def listIAMPolicyAssignmentsForUser(
    request: ListIamPolicyAssignmentsForUserRequest
  ): QuickSightIO[ListIamPolicyAssignmentsForUserResponse] =
    FF.liftF(ListIAMPolicyAssignmentsForUserOp(request))

  def listIngestions(
    request: ListIngestionsRequest
  ): QuickSightIO[ListIngestionsResponse] =
    FF.liftF(ListIngestionsOp(request))

  def listNamespaces(
    request: ListNamespacesRequest
  ): QuickSightIO[ListNamespacesResponse] =
    FF.liftF(ListNamespacesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): QuickSightIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listTemplateAliases(
    request: ListTemplateAliasesRequest
  ): QuickSightIO[ListTemplateAliasesResponse] =
    FF.liftF(ListTemplateAliasesOp(request))

  def listTemplateVersions(
    request: ListTemplateVersionsRequest
  ): QuickSightIO[ListTemplateVersionsResponse] =
    FF.liftF(ListTemplateVersionsOp(request))

  def listTemplates(
    request: ListTemplatesRequest
  ): QuickSightIO[ListTemplatesResponse] =
    FF.liftF(ListTemplatesOp(request))

  def listThemeAliases(
    request: ListThemeAliasesRequest
  ): QuickSightIO[ListThemeAliasesResponse] =
    FF.liftF(ListThemeAliasesOp(request))

  def listThemeVersions(
    request: ListThemeVersionsRequest
  ): QuickSightIO[ListThemeVersionsResponse] =
    FF.liftF(ListThemeVersionsOp(request))

  def listThemes(
    request: ListThemesRequest
  ): QuickSightIO[ListThemesResponse] =
    FF.liftF(ListThemesOp(request))

  def listUserGroups(
    request: ListUserGroupsRequest
  ): QuickSightIO[ListUserGroupsResponse] =
    FF.liftF(ListUserGroupsOp(request))

  def listUsers(
    request: ListUsersRequest
  ): QuickSightIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def registerUser(
    request: RegisterUserRequest
  ): QuickSightIO[RegisterUserResponse] =
    FF.liftF(RegisterUserOp(request))

  def restoreAnalysis(
    request: RestoreAnalysisRequest
  ): QuickSightIO[RestoreAnalysisResponse] =
    FF.liftF(RestoreAnalysisOp(request))

  def searchAnalyses(
    request: SearchAnalysesRequest
  ): QuickSightIO[SearchAnalysesResponse] =
    FF.liftF(SearchAnalysesOp(request))

  def searchDashboards(
    request: SearchDashboardsRequest
  ): QuickSightIO[SearchDashboardsResponse] =
    FF.liftF(SearchDashboardsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): QuickSightIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): QuickSightIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccountCustomization(
    request: UpdateAccountCustomizationRequest
  ): QuickSightIO[UpdateAccountCustomizationResponse] =
    FF.liftF(UpdateAccountCustomizationOp(request))

  def updateAccountSettings(
    request: UpdateAccountSettingsRequest
  ): QuickSightIO[UpdateAccountSettingsResponse] =
    FF.liftF(UpdateAccountSettingsOp(request))

  def updateAnalysis(
    request: UpdateAnalysisRequest
  ): QuickSightIO[UpdateAnalysisResponse] =
    FF.liftF(UpdateAnalysisOp(request))

  def updateAnalysisPermissions(
    request: UpdateAnalysisPermissionsRequest
  ): QuickSightIO[UpdateAnalysisPermissionsResponse] =
    FF.liftF(UpdateAnalysisPermissionsOp(request))

  def updateDashboard(
    request: UpdateDashboardRequest
  ): QuickSightIO[UpdateDashboardResponse] =
    FF.liftF(UpdateDashboardOp(request))

  def updateDashboardPermissions(
    request: UpdateDashboardPermissionsRequest
  ): QuickSightIO[UpdateDashboardPermissionsResponse] =
    FF.liftF(UpdateDashboardPermissionsOp(request))

  def updateDashboardPublishedVersion(
    request: UpdateDashboardPublishedVersionRequest
  ): QuickSightIO[UpdateDashboardPublishedVersionResponse] =
    FF.liftF(UpdateDashboardPublishedVersionOp(request))

  def updateDataSet(
    request: UpdateDataSetRequest
  ): QuickSightIO[UpdateDataSetResponse] =
    FF.liftF(UpdateDataSetOp(request))

  def updateDataSetPermissions(
    request: UpdateDataSetPermissionsRequest
  ): QuickSightIO[UpdateDataSetPermissionsResponse] =
    FF.liftF(UpdateDataSetPermissionsOp(request))

  def updateDataSource(
    request: UpdateDataSourceRequest
  ): QuickSightIO[UpdateDataSourceResponse] =
    FF.liftF(UpdateDataSourceOp(request))

  def updateDataSourcePermissions(
    request: UpdateDataSourcePermissionsRequest
  ): QuickSightIO[UpdateDataSourcePermissionsResponse] =
    FF.liftF(UpdateDataSourcePermissionsOp(request))

  def updateGroup(
    request: UpdateGroupRequest
  ): QuickSightIO[UpdateGroupResponse] =
    FF.liftF(UpdateGroupOp(request))

  def updateIAMPolicyAssignment(
    request: UpdateIamPolicyAssignmentRequest
  ): QuickSightIO[UpdateIamPolicyAssignmentResponse] =
    FF.liftF(UpdateIAMPolicyAssignmentOp(request))

  def updateTemplate(
    request: UpdateTemplateRequest
  ): QuickSightIO[UpdateTemplateResponse] =
    FF.liftF(UpdateTemplateOp(request))

  def updateTemplateAlias(
    request: UpdateTemplateAliasRequest
  ): QuickSightIO[UpdateTemplateAliasResponse] =
    FF.liftF(UpdateTemplateAliasOp(request))

  def updateTemplatePermissions(
    request: UpdateTemplatePermissionsRequest
  ): QuickSightIO[UpdateTemplatePermissionsResponse] =
    FF.liftF(UpdateTemplatePermissionsOp(request))

  def updateTheme(
    request: UpdateThemeRequest
  ): QuickSightIO[UpdateThemeResponse] =
    FF.liftF(UpdateThemeOp(request))

  def updateThemeAlias(
    request: UpdateThemeAliasRequest
  ): QuickSightIO[UpdateThemeAliasResponse] =
    FF.liftF(UpdateThemeAliasOp(request))

  def updateThemePermissions(
    request: UpdateThemePermissionsRequest
  ): QuickSightIO[UpdateThemePermissionsResponse] =
    FF.liftF(UpdateThemePermissionsOp(request))

  def updateUser(
    request: UpdateUserRequest
  ): QuickSightIO[UpdateUserResponse] =
    FF.liftF(UpdateUserOp(request))
}
