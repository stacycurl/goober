package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.codebuild.CodeBuildClient
import software.amazon.awssdk.services.codebuild.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object codebuild { module =>

  // Free monad over CodeBuildOp
  type CodeBuildIO[A] = FF[CodeBuildOp, A]

  sealed trait CodeBuildOp[A] {
    def visit[F[_]](visitor: CodeBuildOp.Visitor[F]): F[A]
  }

  object CodeBuildOp {
    // Given a CodeBuildClient we can embed a CodeBuildIO program in any algebra that understands embedding.
    implicit val CodeBuildOpEmbeddable: Embeddable[CodeBuildOp, CodeBuildClient] = new Embeddable[CodeBuildOp, CodeBuildClient] {
      def embed[A](client: CodeBuildClient, io: CodeBuildIO[A]): Embedded[A] = Embedded.CodeBuild(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends CodeBuildOp.Visitor[Kleisli[M, CodeBuildClient, *]] {
        def batchDeleteBuilds(
          request: BatchDeleteBuildsRequest
        ): Kleisli[M, CodeBuildClient, BatchDeleteBuildsResponse] =
          primitive(_.batchDeleteBuilds(request))

        def batchGetBuildBatches(
          request: BatchGetBuildBatchesRequest
        ): Kleisli[M, CodeBuildClient, BatchGetBuildBatchesResponse] =
          primitive(_.batchGetBuildBatches(request))

        def batchGetBuilds(
          request: BatchGetBuildsRequest
        ): Kleisli[M, CodeBuildClient, BatchGetBuildsResponse] =
          primitive(_.batchGetBuilds(request))

        def batchGetProjects(
          request: BatchGetProjectsRequest
        ): Kleisli[M, CodeBuildClient, BatchGetProjectsResponse] =
          primitive(_.batchGetProjects(request))

        def batchGetReportGroups(
          request: BatchGetReportGroupsRequest
        ): Kleisli[M, CodeBuildClient, BatchGetReportGroupsResponse] =
          primitive(_.batchGetReportGroups(request))

        def batchGetReports(
          request: BatchGetReportsRequest
        ): Kleisli[M, CodeBuildClient, BatchGetReportsResponse] =
          primitive(_.batchGetReports(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, CodeBuildClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def createReportGroup(
          request: CreateReportGroupRequest
        ): Kleisli[M, CodeBuildClient, CreateReportGroupResponse] =
          primitive(_.createReportGroup(request))

        def createWebhook(
          request: CreateWebhookRequest
        ): Kleisli[M, CodeBuildClient, CreateWebhookResponse] =
          primitive(_.createWebhook(request))

        def deleteBuildBatch(
          request: DeleteBuildBatchRequest
        ): Kleisli[M, CodeBuildClient, DeleteBuildBatchResponse] =
          primitive(_.deleteBuildBatch(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, CodeBuildClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def deleteReport(
          request: DeleteReportRequest
        ): Kleisli[M, CodeBuildClient, DeleteReportResponse] =
          primitive(_.deleteReport(request))

        def deleteReportGroup(
          request: DeleteReportGroupRequest
        ): Kleisli[M, CodeBuildClient, DeleteReportGroupResponse] =
          primitive(_.deleteReportGroup(request))

        def deleteResourcePolicy(
          request: DeleteResourcePolicyRequest
        ): Kleisli[M, CodeBuildClient, DeleteResourcePolicyResponse] =
          primitive(_.deleteResourcePolicy(request))

        def deleteSourceCredentials(
          request: DeleteSourceCredentialsRequest
        ): Kleisli[M, CodeBuildClient, DeleteSourceCredentialsResponse] =
          primitive(_.deleteSourceCredentials(request))

        def deleteWebhook(
          request: DeleteWebhookRequest
        ): Kleisli[M, CodeBuildClient, DeleteWebhookResponse] =
          primitive(_.deleteWebhook(request))

        def describeCodeCoverages(
          request: DescribeCodeCoveragesRequest
        ): Kleisli[M, CodeBuildClient, DescribeCodeCoveragesResponse] =
          primitive(_.describeCodeCoverages(request))

        def describeTestCases(
          request: DescribeTestCasesRequest
        ): Kleisli[M, CodeBuildClient, DescribeTestCasesResponse] =
          primitive(_.describeTestCases(request))

        def getReportGroupTrend(
          request: GetReportGroupTrendRequest
        ): Kleisli[M, CodeBuildClient, GetReportGroupTrendResponse] =
          primitive(_.getReportGroupTrend(request))

        def getResourcePolicy(
          request: GetResourcePolicyRequest
        ): Kleisli[M, CodeBuildClient, GetResourcePolicyResponse] =
          primitive(_.getResourcePolicy(request))

        def importSourceCredentials(
          request: ImportSourceCredentialsRequest
        ): Kleisli[M, CodeBuildClient, ImportSourceCredentialsResponse] =
          primitive(_.importSourceCredentials(request))

        def invalidateProjectCache(
          request: InvalidateProjectCacheRequest
        ): Kleisli[M, CodeBuildClient, InvalidateProjectCacheResponse] =
          primitive(_.invalidateProjectCache(request))

        def listBuildBatches(
          request: ListBuildBatchesRequest
        ): Kleisli[M, CodeBuildClient, ListBuildBatchesResponse] =
          primitive(_.listBuildBatches(request))

        def listBuildBatchesForProject(
          request: ListBuildBatchesForProjectRequest
        ): Kleisli[M, CodeBuildClient, ListBuildBatchesForProjectResponse] =
          primitive(_.listBuildBatchesForProject(request))

        def listBuilds(
          request: ListBuildsRequest
        ): Kleisli[M, CodeBuildClient, ListBuildsResponse] =
          primitive(_.listBuilds(request))

        def listBuildsForProject(
          request: ListBuildsForProjectRequest
        ): Kleisli[M, CodeBuildClient, ListBuildsForProjectResponse] =
          primitive(_.listBuildsForProject(request))

        def listCuratedEnvironmentImages(
          request: ListCuratedEnvironmentImagesRequest
        ): Kleisli[M, CodeBuildClient, ListCuratedEnvironmentImagesResponse] =
          primitive(_.listCuratedEnvironmentImages(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, CodeBuildClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listReportGroups(
          request: ListReportGroupsRequest
        ): Kleisli[M, CodeBuildClient, ListReportGroupsResponse] =
          primitive(_.listReportGroups(request))

        def listReports(
          request: ListReportsRequest
        ): Kleisli[M, CodeBuildClient, ListReportsResponse] =
          primitive(_.listReports(request))

        def listReportsForReportGroup(
          request: ListReportsForReportGroupRequest
        ): Kleisli[M, CodeBuildClient, ListReportsForReportGroupResponse] =
          primitive(_.listReportsForReportGroup(request))

        def listSharedProjects(
          request: ListSharedProjectsRequest
        ): Kleisli[M, CodeBuildClient, ListSharedProjectsResponse] =
          primitive(_.listSharedProjects(request))

        def listSharedReportGroups(
          request: ListSharedReportGroupsRequest
        ): Kleisli[M, CodeBuildClient, ListSharedReportGroupsResponse] =
          primitive(_.listSharedReportGroups(request))

        def listSourceCredentials(
          request: ListSourceCredentialsRequest
        ): Kleisli[M, CodeBuildClient, ListSourceCredentialsResponse] =
          primitive(_.listSourceCredentials(request))

        def putResourcePolicy(
          request: PutResourcePolicyRequest
        ): Kleisli[M, CodeBuildClient, PutResourcePolicyResponse] =
          primitive(_.putResourcePolicy(request))

        def retryBuild(
          request: RetryBuildRequest
        ): Kleisli[M, CodeBuildClient, RetryBuildResponse] =
          primitive(_.retryBuild(request))

        def retryBuildBatch(
          request: RetryBuildBatchRequest
        ): Kleisli[M, CodeBuildClient, RetryBuildBatchResponse] =
          primitive(_.retryBuildBatch(request))

        def startBuild(
          request: StartBuildRequest
        ): Kleisli[M, CodeBuildClient, StartBuildResponse] =
          primitive(_.startBuild(request))

        def startBuildBatch(
          request: StartBuildBatchRequest
        ): Kleisli[M, CodeBuildClient, StartBuildBatchResponse] =
          primitive(_.startBuildBatch(request))

        def stopBuild(
          request: StopBuildRequest
        ): Kleisli[M, CodeBuildClient, StopBuildResponse] =
          primitive(_.stopBuild(request))

        def stopBuildBatch(
          request: StopBuildBatchRequest
        ): Kleisli[M, CodeBuildClient, StopBuildBatchResponse] =
          primitive(_.stopBuildBatch(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, CodeBuildClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def updateReportGroup(
          request: UpdateReportGroupRequest
        ): Kleisli[M, CodeBuildClient, UpdateReportGroupResponse] =
          primitive(_.updateReportGroup(request))

        def updateWebhook(
          request: UpdateWebhookRequest
        ): Kleisli[M, CodeBuildClient, UpdateWebhookResponse] =
          primitive(_.updateWebhook(request))

        def primitive[A](
          f: CodeBuildClient => A
        ): Kleisli[M, CodeBuildClient, A]
      }
    }

    trait Visitor[F[_]] extends (CodeBuildOp ~> F) {
      final def apply[A](op: CodeBuildOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchDeleteBuilds(
        request: BatchDeleteBuildsRequest
      ): F[BatchDeleteBuildsResponse]

      def batchGetBuildBatches(
        request: BatchGetBuildBatchesRequest
      ): F[BatchGetBuildBatchesResponse]

      def batchGetBuilds(
        request: BatchGetBuildsRequest
      ): F[BatchGetBuildsResponse]

      def batchGetProjects(
        request: BatchGetProjectsRequest
      ): F[BatchGetProjectsResponse]

      def batchGetReportGroups(
        request: BatchGetReportGroupsRequest
      ): F[BatchGetReportGroupsResponse]

      def batchGetReports(
        request: BatchGetReportsRequest
      ): F[BatchGetReportsResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def createReportGroup(
        request: CreateReportGroupRequest
      ): F[CreateReportGroupResponse]

      def createWebhook(
        request: CreateWebhookRequest
      ): F[CreateWebhookResponse]

      def deleteBuildBatch(
        request: DeleteBuildBatchRequest
      ): F[DeleteBuildBatchResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def deleteReport(
        request: DeleteReportRequest
      ): F[DeleteReportResponse]

      def deleteReportGroup(
        request: DeleteReportGroupRequest
      ): F[DeleteReportGroupResponse]

      def deleteResourcePolicy(
        request: DeleteResourcePolicyRequest
      ): F[DeleteResourcePolicyResponse]

      def deleteSourceCredentials(
        request: DeleteSourceCredentialsRequest
      ): F[DeleteSourceCredentialsResponse]

      def deleteWebhook(
        request: DeleteWebhookRequest
      ): F[DeleteWebhookResponse]

      def describeCodeCoverages(
        request: DescribeCodeCoveragesRequest
      ): F[DescribeCodeCoveragesResponse]

      def describeTestCases(
        request: DescribeTestCasesRequest
      ): F[DescribeTestCasesResponse]

      def getReportGroupTrend(
        request: GetReportGroupTrendRequest
      ): F[GetReportGroupTrendResponse]

      def getResourcePolicy(
        request: GetResourcePolicyRequest
      ): F[GetResourcePolicyResponse]

      def importSourceCredentials(
        request: ImportSourceCredentialsRequest
      ): F[ImportSourceCredentialsResponse]

      def invalidateProjectCache(
        request: InvalidateProjectCacheRequest
      ): F[InvalidateProjectCacheResponse]

      def listBuildBatches(
        request: ListBuildBatchesRequest
      ): F[ListBuildBatchesResponse]

      def listBuildBatchesForProject(
        request: ListBuildBatchesForProjectRequest
      ): F[ListBuildBatchesForProjectResponse]

      def listBuilds(
        request: ListBuildsRequest
      ): F[ListBuildsResponse]

      def listBuildsForProject(
        request: ListBuildsForProjectRequest
      ): F[ListBuildsForProjectResponse]

      def listCuratedEnvironmentImages(
        request: ListCuratedEnvironmentImagesRequest
      ): F[ListCuratedEnvironmentImagesResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listReportGroups(
        request: ListReportGroupsRequest
      ): F[ListReportGroupsResponse]

      def listReports(
        request: ListReportsRequest
      ): F[ListReportsResponse]

      def listReportsForReportGroup(
        request: ListReportsForReportGroupRequest
      ): F[ListReportsForReportGroupResponse]

      def listSharedProjects(
        request: ListSharedProjectsRequest
      ): F[ListSharedProjectsResponse]

      def listSharedReportGroups(
        request: ListSharedReportGroupsRequest
      ): F[ListSharedReportGroupsResponse]

      def listSourceCredentials(
        request: ListSourceCredentialsRequest
      ): F[ListSourceCredentialsResponse]

      def putResourcePolicy(
        request: PutResourcePolicyRequest
      ): F[PutResourcePolicyResponse]

      def retryBuild(
        request: RetryBuildRequest
      ): F[RetryBuildResponse]

      def retryBuildBatch(
        request: RetryBuildBatchRequest
      ): F[RetryBuildBatchResponse]

      def startBuild(
        request: StartBuildRequest
      ): F[StartBuildResponse]

      def startBuildBatch(
        request: StartBuildBatchRequest
      ): F[StartBuildBatchResponse]

      def stopBuild(
        request: StopBuildRequest
      ): F[StopBuildResponse]

      def stopBuildBatch(
        request: StopBuildBatchRequest
      ): F[StopBuildBatchResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]

      def updateReportGroup(
        request: UpdateReportGroupRequest
      ): F[UpdateReportGroupResponse]

      def updateWebhook(
        request: UpdateWebhookRequest
      ): F[UpdateWebhookResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends CodeBuildOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchDeleteBuilds(
      request: BatchDeleteBuildsRequest
    ) extends CodeBuildOp[BatchDeleteBuildsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteBuildsResponse] =
        visitor.batchDeleteBuilds(request)
    }

    final case class BatchGetBuildBatches(
      request: BatchGetBuildBatchesRequest
    ) extends CodeBuildOp[BatchGetBuildBatchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetBuildBatchesResponse] =
        visitor.batchGetBuildBatches(request)
    }

    final case class BatchGetBuilds(
      request: BatchGetBuildsRequest
    ) extends CodeBuildOp[BatchGetBuildsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetBuildsResponse] =
        visitor.batchGetBuilds(request)
    }

    final case class BatchGetProjects(
      request: BatchGetProjectsRequest
    ) extends CodeBuildOp[BatchGetProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetProjectsResponse] =
        visitor.batchGetProjects(request)
    }

    final case class BatchGetReportGroups(
      request: BatchGetReportGroupsRequest
    ) extends CodeBuildOp[BatchGetReportGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetReportGroupsResponse] =
        visitor.batchGetReportGroups(request)
    }

    final case class BatchGetReports(
      request: BatchGetReportsRequest
    ) extends CodeBuildOp[BatchGetReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchGetReportsResponse] =
        visitor.batchGetReports(request)
    }

    final case class CreateProject(
      request: CreateProjectRequest
    ) extends CodeBuildOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class CreateReportGroup(
      request: CreateReportGroupRequest
    ) extends CodeBuildOp[CreateReportGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateReportGroupResponse] =
        visitor.createReportGroup(request)
    }

    final case class CreateWebhook(
      request: CreateWebhookRequest
    ) extends CodeBuildOp[CreateWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWebhookResponse] =
        visitor.createWebhook(request)
    }

    final case class DeleteBuildBatch(
      request: DeleteBuildBatchRequest
    ) extends CodeBuildOp[DeleteBuildBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBuildBatchResponse] =
        visitor.deleteBuildBatch(request)
    }

    final case class DeleteProject(
      request: DeleteProjectRequest
    ) extends CodeBuildOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DeleteReport(
      request: DeleteReportRequest
    ) extends CodeBuildOp[DeleteReportResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReportResponse] =
        visitor.deleteReport(request)
    }

    final case class DeleteReportGroup(
      request: DeleteReportGroupRequest
    ) extends CodeBuildOp[DeleteReportGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteReportGroupResponse] =
        visitor.deleteReportGroup(request)
    }

    final case class DeleteResourcePolicy(
      request: DeleteResourcePolicyRequest
    ) extends CodeBuildOp[DeleteResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteResourcePolicyResponse] =
        visitor.deleteResourcePolicy(request)
    }

    final case class DeleteSourceCredentials(
      request: DeleteSourceCredentialsRequest
    ) extends CodeBuildOp[DeleteSourceCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSourceCredentialsResponse] =
        visitor.deleteSourceCredentials(request)
    }

    final case class DeleteWebhook(
      request: DeleteWebhookRequest
    ) extends CodeBuildOp[DeleteWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWebhookResponse] =
        visitor.deleteWebhook(request)
    }

    final case class DescribeCodeCoverages(
      request: DescribeCodeCoveragesRequest
    ) extends CodeBuildOp[DescribeCodeCoveragesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCodeCoveragesResponse] =
        visitor.describeCodeCoverages(request)
    }

    final case class DescribeTestCases(
      request: DescribeTestCasesRequest
    ) extends CodeBuildOp[DescribeTestCasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTestCasesResponse] =
        visitor.describeTestCases(request)
    }

    final case class GetReportGroupTrend(
      request: GetReportGroupTrendRequest
    ) extends CodeBuildOp[GetReportGroupTrendResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetReportGroupTrendResponse] =
        visitor.getReportGroupTrend(request)
    }

    final case class GetResourcePolicy(
      request: GetResourcePolicyRequest
    ) extends CodeBuildOp[GetResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourcePolicyResponse] =
        visitor.getResourcePolicy(request)
    }

    final case class ImportSourceCredentials(
      request: ImportSourceCredentialsRequest
    ) extends CodeBuildOp[ImportSourceCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportSourceCredentialsResponse] =
        visitor.importSourceCredentials(request)
    }

    final case class InvalidateProjectCache(
      request: InvalidateProjectCacheRequest
    ) extends CodeBuildOp[InvalidateProjectCacheResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InvalidateProjectCacheResponse] =
        visitor.invalidateProjectCache(request)
    }

    final case class ListBuildBatches(
      request: ListBuildBatchesRequest
    ) extends CodeBuildOp[ListBuildBatchesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuildBatchesResponse] =
        visitor.listBuildBatches(request)
    }

    final case class ListBuildBatchesForProject(
      request: ListBuildBatchesForProjectRequest
    ) extends CodeBuildOp[ListBuildBatchesForProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuildBatchesForProjectResponse] =
        visitor.listBuildBatchesForProject(request)
    }

    final case class ListBuilds(
      request: ListBuildsRequest
    ) extends CodeBuildOp[ListBuildsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuildsResponse] =
        visitor.listBuilds(request)
    }

    final case class ListBuildsForProject(
      request: ListBuildsForProjectRequest
    ) extends CodeBuildOp[ListBuildsForProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuildsForProjectResponse] =
        visitor.listBuildsForProject(request)
    }

    final case class ListCuratedEnvironmentImages(
      request: ListCuratedEnvironmentImagesRequest
    ) extends CodeBuildOp[ListCuratedEnvironmentImagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCuratedEnvironmentImagesResponse] =
        visitor.listCuratedEnvironmentImages(request)
    }

    final case class ListProjects(
      request: ListProjectsRequest
    ) extends CodeBuildOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListReportGroups(
      request: ListReportGroupsRequest
    ) extends CodeBuildOp[ListReportGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReportGroupsResponse] =
        visitor.listReportGroups(request)
    }

    final case class ListReports(
      request: ListReportsRequest
    ) extends CodeBuildOp[ListReportsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReportsResponse] =
        visitor.listReports(request)
    }

    final case class ListReportsForReportGroup(
      request: ListReportsForReportGroupRequest
    ) extends CodeBuildOp[ListReportsForReportGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListReportsForReportGroupResponse] =
        visitor.listReportsForReportGroup(request)
    }

    final case class ListSharedProjects(
      request: ListSharedProjectsRequest
    ) extends CodeBuildOp[ListSharedProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSharedProjectsResponse] =
        visitor.listSharedProjects(request)
    }

    final case class ListSharedReportGroups(
      request: ListSharedReportGroupsRequest
    ) extends CodeBuildOp[ListSharedReportGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSharedReportGroupsResponse] =
        visitor.listSharedReportGroups(request)
    }

    final case class ListSourceCredentials(
      request: ListSourceCredentialsRequest
    ) extends CodeBuildOp[ListSourceCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSourceCredentialsResponse] =
        visitor.listSourceCredentials(request)
    }

    final case class PutResourcePolicy(
      request: PutResourcePolicyRequest
    ) extends CodeBuildOp[PutResourcePolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourcePolicyResponse] =
        visitor.putResourcePolicy(request)
    }

    final case class RetryBuild(
      request: RetryBuildRequest
    ) extends CodeBuildOp[RetryBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetryBuildResponse] =
        visitor.retryBuild(request)
    }

    final case class RetryBuildBatch(
      request: RetryBuildBatchRequest
    ) extends CodeBuildOp[RetryBuildBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RetryBuildBatchResponse] =
        visitor.retryBuildBatch(request)
    }

    final case class StartBuild(
      request: StartBuildRequest
    ) extends CodeBuildOp[StartBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartBuildResponse] =
        visitor.startBuild(request)
    }

    final case class StartBuildBatch(
      request: StartBuildBatchRequest
    ) extends CodeBuildOp[StartBuildBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartBuildBatchResponse] =
        visitor.startBuildBatch(request)
    }

    final case class StopBuild(
      request: StopBuildRequest
    ) extends CodeBuildOp[StopBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopBuildResponse] =
        visitor.stopBuild(request)
    }

    final case class StopBuildBatch(
      request: StopBuildBatchRequest
    ) extends CodeBuildOp[StopBuildBatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopBuildBatchResponse] =
        visitor.stopBuildBatch(request)
    }

    final case class UpdateProject(
      request: UpdateProjectRequest
    ) extends CodeBuildOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }

    final case class UpdateReportGroup(
      request: UpdateReportGroupRequest
    ) extends CodeBuildOp[UpdateReportGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateReportGroupResponse] =
        visitor.updateReportGroup(request)
    }

    final case class UpdateWebhook(
      request: UpdateWebhookRequest
    ) extends CodeBuildOp[UpdateWebhookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWebhookResponse] =
        visitor.updateWebhook(request)
    }
  }

  import CodeBuildOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[CodeBuildOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchDeleteBuilds(
    request: BatchDeleteBuildsRequest
  ): CodeBuildIO[BatchDeleteBuildsResponse] =
    FF.liftF(BatchDeleteBuilds(request))

  def batchGetBuildBatches(
    request: BatchGetBuildBatchesRequest
  ): CodeBuildIO[BatchGetBuildBatchesResponse] =
    FF.liftF(BatchGetBuildBatches(request))

  def batchGetBuilds(
    request: BatchGetBuildsRequest
  ): CodeBuildIO[BatchGetBuildsResponse] =
    FF.liftF(BatchGetBuilds(request))

  def batchGetProjects(
    request: BatchGetProjectsRequest
  ): CodeBuildIO[BatchGetProjectsResponse] =
    FF.liftF(BatchGetProjects(request))

  def batchGetReportGroups(
    request: BatchGetReportGroupsRequest
  ): CodeBuildIO[BatchGetReportGroupsResponse] =
    FF.liftF(BatchGetReportGroups(request))

  def batchGetReports(
    request: BatchGetReportsRequest
  ): CodeBuildIO[BatchGetReportsResponse] =
    FF.liftF(BatchGetReports(request))

  def createProject(
    request: CreateProjectRequest
  ): CodeBuildIO[CreateProjectResponse] =
    FF.liftF(CreateProject(request))

  def createReportGroup(
    request: CreateReportGroupRequest
  ): CodeBuildIO[CreateReportGroupResponse] =
    FF.liftF(CreateReportGroup(request))

  def createWebhook(
    request: CreateWebhookRequest
  ): CodeBuildIO[CreateWebhookResponse] =
    FF.liftF(CreateWebhook(request))

  def deleteBuildBatch(
    request: DeleteBuildBatchRequest
  ): CodeBuildIO[DeleteBuildBatchResponse] =
    FF.liftF(DeleteBuildBatch(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): CodeBuildIO[DeleteProjectResponse] =
    FF.liftF(DeleteProject(request))

  def deleteReport(
    request: DeleteReportRequest
  ): CodeBuildIO[DeleteReportResponse] =
    FF.liftF(DeleteReport(request))

  def deleteReportGroup(
    request: DeleteReportGroupRequest
  ): CodeBuildIO[DeleteReportGroupResponse] =
    FF.liftF(DeleteReportGroup(request))

  def deleteResourcePolicy(
    request: DeleteResourcePolicyRequest
  ): CodeBuildIO[DeleteResourcePolicyResponse] =
    FF.liftF(DeleteResourcePolicy(request))

  def deleteSourceCredentials(
    request: DeleteSourceCredentialsRequest
  ): CodeBuildIO[DeleteSourceCredentialsResponse] =
    FF.liftF(DeleteSourceCredentials(request))

  def deleteWebhook(
    request: DeleteWebhookRequest
  ): CodeBuildIO[DeleteWebhookResponse] =
    FF.liftF(DeleteWebhook(request))

  def describeCodeCoverages(
    request: DescribeCodeCoveragesRequest
  ): CodeBuildIO[DescribeCodeCoveragesResponse] =
    FF.liftF(DescribeCodeCoverages(request))

  def describeTestCases(
    request: DescribeTestCasesRequest
  ): CodeBuildIO[DescribeTestCasesResponse] =
    FF.liftF(DescribeTestCases(request))

  def getReportGroupTrend(
    request: GetReportGroupTrendRequest
  ): CodeBuildIO[GetReportGroupTrendResponse] =
    FF.liftF(GetReportGroupTrend(request))

  def getResourcePolicy(
    request: GetResourcePolicyRequest
  ): CodeBuildIO[GetResourcePolicyResponse] =
    FF.liftF(GetResourcePolicy(request))

  def importSourceCredentials(
    request: ImportSourceCredentialsRequest
  ): CodeBuildIO[ImportSourceCredentialsResponse] =
    FF.liftF(ImportSourceCredentials(request))

  def invalidateProjectCache(
    request: InvalidateProjectCacheRequest
  ): CodeBuildIO[InvalidateProjectCacheResponse] =
    FF.liftF(InvalidateProjectCache(request))

  def listBuildBatches(
    request: ListBuildBatchesRequest
  ): CodeBuildIO[ListBuildBatchesResponse] =
    FF.liftF(ListBuildBatches(request))

  def listBuildBatchesForProject(
    request: ListBuildBatchesForProjectRequest
  ): CodeBuildIO[ListBuildBatchesForProjectResponse] =
    FF.liftF(ListBuildBatchesForProject(request))

  def listBuilds(
    request: ListBuildsRequest
  ): CodeBuildIO[ListBuildsResponse] =
    FF.liftF(ListBuilds(request))

  def listBuildsForProject(
    request: ListBuildsForProjectRequest
  ): CodeBuildIO[ListBuildsForProjectResponse] =
    FF.liftF(ListBuildsForProject(request))

  def listCuratedEnvironmentImages(
    request: ListCuratedEnvironmentImagesRequest
  ): CodeBuildIO[ListCuratedEnvironmentImagesResponse] =
    FF.liftF(ListCuratedEnvironmentImages(request))

  def listProjects(
    request: ListProjectsRequest
  ): CodeBuildIO[ListProjectsResponse] =
    FF.liftF(ListProjects(request))

  def listReportGroups(
    request: ListReportGroupsRequest
  ): CodeBuildIO[ListReportGroupsResponse] =
    FF.liftF(ListReportGroups(request))

  def listReports(
    request: ListReportsRequest
  ): CodeBuildIO[ListReportsResponse] =
    FF.liftF(ListReports(request))

  def listReportsForReportGroup(
    request: ListReportsForReportGroupRequest
  ): CodeBuildIO[ListReportsForReportGroupResponse] =
    FF.liftF(ListReportsForReportGroup(request))

  def listSharedProjects(
    request: ListSharedProjectsRequest
  ): CodeBuildIO[ListSharedProjectsResponse] =
    FF.liftF(ListSharedProjects(request))

  def listSharedReportGroups(
    request: ListSharedReportGroupsRequest
  ): CodeBuildIO[ListSharedReportGroupsResponse] =
    FF.liftF(ListSharedReportGroups(request))

  def listSourceCredentials(
    request: ListSourceCredentialsRequest
  ): CodeBuildIO[ListSourceCredentialsResponse] =
    FF.liftF(ListSourceCredentials(request))

  def putResourcePolicy(
    request: PutResourcePolicyRequest
  ): CodeBuildIO[PutResourcePolicyResponse] =
    FF.liftF(PutResourcePolicy(request))

  def retryBuild(
    request: RetryBuildRequest
  ): CodeBuildIO[RetryBuildResponse] =
    FF.liftF(RetryBuild(request))

  def retryBuildBatch(
    request: RetryBuildBatchRequest
  ): CodeBuildIO[RetryBuildBatchResponse] =
    FF.liftF(RetryBuildBatch(request))

  def startBuild(
    request: StartBuildRequest
  ): CodeBuildIO[StartBuildResponse] =
    FF.liftF(StartBuild(request))

  def startBuildBatch(
    request: StartBuildBatchRequest
  ): CodeBuildIO[StartBuildBatchResponse] =
    FF.liftF(StartBuildBatch(request))

  def stopBuild(
    request: StopBuildRequest
  ): CodeBuildIO[StopBuildResponse] =
    FF.liftF(StopBuild(request))

  def stopBuildBatch(
    request: StopBuildBatchRequest
  ): CodeBuildIO[StopBuildBatchResponse] =
    FF.liftF(StopBuildBatch(request))

  def updateProject(
    request: UpdateProjectRequest
  ): CodeBuildIO[UpdateProjectResponse] =
    FF.liftF(UpdateProject(request))

  def updateReportGroup(
    request: UpdateReportGroupRequest
  ): CodeBuildIO[UpdateReportGroupResponse] =
    FF.liftF(UpdateReportGroup(request))

  def updateWebhook(
    request: UpdateWebhookRequest
  ): CodeBuildIO[UpdateWebhookResponse] =
    FF.liftF(UpdateWebhook(request))
}
