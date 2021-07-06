package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.databrew.DataBrewClient
import software.amazon.awssdk.services.databrew.model._


object databrew { module =>

  // Free monad over DataBrewOp
  type DataBrewIO[A] = FF[DataBrewOp, A]

  sealed trait DataBrewOp[A] {
    def visit[F[_]](visitor: DataBrewOp.Visitor[F]): F[A]
  }

  object DataBrewOp {
    // Given a DataBrewClient we can embed a DataBrewIO program in any algebra that understands embedding.
    implicit val DataBrewOpEmbeddable: Embeddable[DataBrewOp, DataBrewClient] = new Embeddable[DataBrewOp, DataBrewClient] {
      def embed[A](client: DataBrewClient, io: DataBrewIO[A]): Embedded[A] = Embedded.DataBrew(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends DataBrewOp.Visitor[Kleisli[M, DataBrewClient, *]] {
        def batchDeleteRecipeVersion(
          request: BatchDeleteRecipeVersionRequest
        ): Kleisli[M, DataBrewClient, BatchDeleteRecipeVersionResponse] =
          primitive(_.batchDeleteRecipeVersion(request))

        def createDataset(
          request: CreateDatasetRequest
        ): Kleisli[M, DataBrewClient, CreateDatasetResponse] =
          primitive(_.createDataset(request))

        def createProfileJob(
          request: CreateProfileJobRequest
        ): Kleisli[M, DataBrewClient, CreateProfileJobResponse] =
          primitive(_.createProfileJob(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, DataBrewClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def createRecipe(
          request: CreateRecipeRequest
        ): Kleisli[M, DataBrewClient, CreateRecipeResponse] =
          primitive(_.createRecipe(request))

        def createRecipeJob(
          request: CreateRecipeJobRequest
        ): Kleisli[M, DataBrewClient, CreateRecipeJobResponse] =
          primitive(_.createRecipeJob(request))

        def createSchedule(
          request: CreateScheduleRequest
        ): Kleisli[M, DataBrewClient, CreateScheduleResponse] =
          primitive(_.createSchedule(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, DataBrewClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def deleteJob(
          request: DeleteJobRequest
        ): Kleisli[M, DataBrewClient, DeleteJobResponse] =
          primitive(_.deleteJob(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, DataBrewClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def deleteRecipeVersion(
          request: DeleteRecipeVersionRequest
        ): Kleisli[M, DataBrewClient, DeleteRecipeVersionResponse] =
          primitive(_.deleteRecipeVersion(request))

        def deleteSchedule(
          request: DeleteScheduleRequest
        ): Kleisli[M, DataBrewClient, DeleteScheduleResponse] =
          primitive(_.deleteSchedule(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, DataBrewClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeJob(
          request: DescribeJobRequest
        ): Kleisli[M, DataBrewClient, DescribeJobResponse] =
          primitive(_.describeJob(request))

        def describeJobRun(
          request: DescribeJobRunRequest
        ): Kleisli[M, DataBrewClient, DescribeJobRunResponse] =
          primitive(_.describeJobRun(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, DataBrewClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def describeRecipe(
          request: DescribeRecipeRequest
        ): Kleisli[M, DataBrewClient, DescribeRecipeResponse] =
          primitive(_.describeRecipe(request))

        def describeSchedule(
          request: DescribeScheduleRequest
        ): Kleisli[M, DataBrewClient, DescribeScheduleResponse] =
          primitive(_.describeSchedule(request))

        def listDatasets(
          request: ListDatasetsRequest
        ): Kleisli[M, DataBrewClient, ListDatasetsResponse] =
          primitive(_.listDatasets(request))

        def listJobRuns(
          request: ListJobRunsRequest
        ): Kleisli[M, DataBrewClient, ListJobRunsResponse] =
          primitive(_.listJobRuns(request))

        def listJobs(
          request: ListJobsRequest
        ): Kleisli[M, DataBrewClient, ListJobsResponse] =
          primitive(_.listJobs(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, DataBrewClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listRecipeVersions(
          request: ListRecipeVersionsRequest
        ): Kleisli[M, DataBrewClient, ListRecipeVersionsResponse] =
          primitive(_.listRecipeVersions(request))

        def listRecipes(
          request: ListRecipesRequest
        ): Kleisli[M, DataBrewClient, ListRecipesResponse] =
          primitive(_.listRecipes(request))

        def listSchedules(
          request: ListSchedulesRequest
        ): Kleisli[M, DataBrewClient, ListSchedulesResponse] =
          primitive(_.listSchedules(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, DataBrewClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def publishRecipe(
          request: PublishRecipeRequest
        ): Kleisli[M, DataBrewClient, PublishRecipeResponse] =
          primitive(_.publishRecipe(request))

        def sendProjectSessionAction(
          request: SendProjectSessionActionRequest
        ): Kleisli[M, DataBrewClient, SendProjectSessionActionResponse] =
          primitive(_.sendProjectSessionAction(request))

        def startJobRun(
          request: StartJobRunRequest
        ): Kleisli[M, DataBrewClient, StartJobRunResponse] =
          primitive(_.startJobRun(request))

        def startProjectSession(
          request: StartProjectSessionRequest
        ): Kleisli[M, DataBrewClient, StartProjectSessionResponse] =
          primitive(_.startProjectSession(request))

        def stopJobRun(
          request: StopJobRunRequest
        ): Kleisli[M, DataBrewClient, StopJobRunResponse] =
          primitive(_.stopJobRun(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, DataBrewClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, DataBrewClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDataset(
          request: UpdateDatasetRequest
        ): Kleisli[M, DataBrewClient, UpdateDatasetResponse] =
          primitive(_.updateDataset(request))

        def updateProfileJob(
          request: UpdateProfileJobRequest
        ): Kleisli[M, DataBrewClient, UpdateProfileJobResponse] =
          primitive(_.updateProfileJob(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, DataBrewClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def updateRecipe(
          request: UpdateRecipeRequest
        ): Kleisli[M, DataBrewClient, UpdateRecipeResponse] =
          primitive(_.updateRecipe(request))

        def updateRecipeJob(
          request: UpdateRecipeJobRequest
        ): Kleisli[M, DataBrewClient, UpdateRecipeJobResponse] =
          primitive(_.updateRecipeJob(request))

        def updateSchedule(
          request: UpdateScheduleRequest
        ): Kleisli[M, DataBrewClient, UpdateScheduleResponse] =
          primitive(_.updateSchedule(request))

        def primitive[A](
          f: DataBrewClient => A
        ): Kleisli[M, DataBrewClient, A]
      }
    }

    trait Visitor[F[_]] extends (DataBrewOp ~> F) {
      final def apply[A](op: DataBrewOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def batchDeleteRecipeVersion(
        request: BatchDeleteRecipeVersionRequest
      ): F[BatchDeleteRecipeVersionResponse]

      def createDataset(
        request: CreateDatasetRequest
      ): F[CreateDatasetResponse]

      def createProfileJob(
        request: CreateProfileJobRequest
      ): F[CreateProfileJobResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def createRecipe(
        request: CreateRecipeRequest
      ): F[CreateRecipeResponse]

      def createRecipeJob(
        request: CreateRecipeJobRequest
      ): F[CreateRecipeJobResponse]

      def createSchedule(
        request: CreateScheduleRequest
      ): F[CreateScheduleResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def deleteJob(
        request: DeleteJobRequest
      ): F[DeleteJobResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def deleteRecipeVersion(
        request: DeleteRecipeVersionRequest
      ): F[DeleteRecipeVersionResponse]

      def deleteSchedule(
        request: DeleteScheduleRequest
      ): F[DeleteScheduleResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeJob(
        request: DescribeJobRequest
      ): F[DescribeJobResponse]

      def describeJobRun(
        request: DescribeJobRunRequest
      ): F[DescribeJobRunResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def describeRecipe(
        request: DescribeRecipeRequest
      ): F[DescribeRecipeResponse]

      def describeSchedule(
        request: DescribeScheduleRequest
      ): F[DescribeScheduleResponse]

      def listDatasets(
        request: ListDatasetsRequest
      ): F[ListDatasetsResponse]

      def listJobRuns(
        request: ListJobRunsRequest
      ): F[ListJobRunsResponse]

      def listJobs(
        request: ListJobsRequest
      ): F[ListJobsResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listRecipeVersions(
        request: ListRecipeVersionsRequest
      ): F[ListRecipeVersionsResponse]

      def listRecipes(
        request: ListRecipesRequest
      ): F[ListRecipesResponse]

      def listSchedules(
        request: ListSchedulesRequest
      ): F[ListSchedulesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def publishRecipe(
        request: PublishRecipeRequest
      ): F[PublishRecipeResponse]

      def sendProjectSessionAction(
        request: SendProjectSessionActionRequest
      ): F[SendProjectSessionActionResponse]

      def startJobRun(
        request: StartJobRunRequest
      ): F[StartJobRunResponse]

      def startProjectSession(
        request: StartProjectSessionRequest
      ): F[StartProjectSessionResponse]

      def stopJobRun(
        request: StopJobRunRequest
      ): F[StopJobRunResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDataset(
        request: UpdateDatasetRequest
      ): F[UpdateDatasetResponse]

      def updateProfileJob(
        request: UpdateProfileJobRequest
      ): F[UpdateProfileJobResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]

      def updateRecipe(
        request: UpdateRecipeRequest
      ): F[UpdateRecipeResponse]

      def updateRecipeJob(
        request: UpdateRecipeJobRequest
      ): F[UpdateRecipeJobResponse]

      def updateSchedule(
        request: UpdateScheduleRequest
      ): F[UpdateScheduleResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends DataBrewOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class BatchDeleteRecipeVersionOp(
      request: BatchDeleteRecipeVersionRequest
    ) extends DataBrewOp[BatchDeleteRecipeVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeleteRecipeVersionResponse] =
        visitor.batchDeleteRecipeVersion(request)
    }

    final case class CreateDatasetOp(
      request: CreateDatasetRequest
    ) extends DataBrewOp[CreateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetResponse] =
        visitor.createDataset(request)
    }

    final case class CreateProfileJobOp(
      request: CreateProfileJobRequest
    ) extends DataBrewOp[CreateProfileJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProfileJobResponse] =
        visitor.createProfileJob(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends DataBrewOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class CreateRecipeOp(
      request: CreateRecipeRequest
    ) extends DataBrewOp[CreateRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRecipeResponse] =
        visitor.createRecipe(request)
    }

    final case class CreateRecipeJobOp(
      request: CreateRecipeJobRequest
    ) extends DataBrewOp[CreateRecipeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRecipeJobResponse] =
        visitor.createRecipeJob(request)
    }

    final case class CreateScheduleOp(
      request: CreateScheduleRequest
    ) extends DataBrewOp[CreateScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateScheduleResponse] =
        visitor.createSchedule(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends DataBrewOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DeleteJobOp(
      request: DeleteJobRequest
    ) extends DataBrewOp[DeleteJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteJobResponse] =
        visitor.deleteJob(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends DataBrewOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DeleteRecipeVersionOp(
      request: DeleteRecipeVersionRequest
    ) extends DataBrewOp[DeleteRecipeVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRecipeVersionResponse] =
        visitor.deleteRecipeVersion(request)
    }

    final case class DeleteScheduleOp(
      request: DeleteScheduleRequest
    ) extends DataBrewOp[DeleteScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScheduleResponse] =
        visitor.deleteSchedule(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends DataBrewOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeJobOp(
      request: DescribeJobRequest
    ) extends DataBrewOp[DescribeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobResponse] =
        visitor.describeJob(request)
    }

    final case class DescribeJobRunOp(
      request: DescribeJobRunRequest
    ) extends DataBrewOp[DescribeJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeJobRunResponse] =
        visitor.describeJobRun(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends DataBrewOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class DescribeRecipeOp(
      request: DescribeRecipeRequest
    ) extends DataBrewOp[DescribeRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRecipeResponse] =
        visitor.describeRecipe(request)
    }

    final case class DescribeScheduleOp(
      request: DescribeScheduleRequest
    ) extends DataBrewOp[DescribeScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScheduleResponse] =
        visitor.describeSchedule(request)
    }

    final case class ListDatasetsOp(
      request: ListDatasetsRequest
    ) extends DataBrewOp[ListDatasetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetsResponse] =
        visitor.listDatasets(request)
    }

    final case class ListJobRunsOp(
      request: ListJobRunsRequest
    ) extends DataBrewOp[ListJobRunsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobRunsResponse] =
        visitor.listJobRuns(request)
    }

    final case class ListJobsOp(
      request: ListJobsRequest
    ) extends DataBrewOp[ListJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListJobsResponse] =
        visitor.listJobs(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends DataBrewOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListRecipeVersionsOp(
      request: ListRecipeVersionsRequest
    ) extends DataBrewOp[ListRecipeVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecipeVersionsResponse] =
        visitor.listRecipeVersions(request)
    }

    final case class ListRecipesOp(
      request: ListRecipesRequest
    ) extends DataBrewOp[ListRecipesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecipesResponse] =
        visitor.listRecipes(request)
    }

    final case class ListSchedulesOp(
      request: ListSchedulesRequest
    ) extends DataBrewOp[ListSchedulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchedulesResponse] =
        visitor.listSchedules(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends DataBrewOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PublishRecipeOp(
      request: PublishRecipeRequest
    ) extends DataBrewOp[PublishRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PublishRecipeResponse] =
        visitor.publishRecipe(request)
    }

    final case class SendProjectSessionActionOp(
      request: SendProjectSessionActionRequest
    ) extends DataBrewOp[SendProjectSessionActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendProjectSessionActionResponse] =
        visitor.sendProjectSessionAction(request)
    }

    final case class StartJobRunOp(
      request: StartJobRunRequest
    ) extends DataBrewOp[StartJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartJobRunResponse] =
        visitor.startJobRun(request)
    }

    final case class StartProjectSessionOp(
      request: StartProjectSessionRequest
    ) extends DataBrewOp[StartProjectSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartProjectSessionResponse] =
        visitor.startProjectSession(request)
    }

    final case class StopJobRunOp(
      request: StopJobRunRequest
    ) extends DataBrewOp[StopJobRunResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopJobRunResponse] =
        visitor.stopJobRun(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends DataBrewOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends DataBrewOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDatasetOp(
      request: UpdateDatasetRequest
    ) extends DataBrewOp[UpdateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDatasetResponse] =
        visitor.updateDataset(request)
    }

    final case class UpdateProfileJobOp(
      request: UpdateProfileJobRequest
    ) extends DataBrewOp[UpdateProfileJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProfileJobResponse] =
        visitor.updateProfileJob(request)
    }

    final case class UpdateProjectOp(
      request: UpdateProjectRequest
    ) extends DataBrewOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }

    final case class UpdateRecipeOp(
      request: UpdateRecipeRequest
    ) extends DataBrewOp[UpdateRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRecipeResponse] =
        visitor.updateRecipe(request)
    }

    final case class UpdateRecipeJobOp(
      request: UpdateRecipeJobRequest
    ) extends DataBrewOp[UpdateRecipeJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRecipeJobResponse] =
        visitor.updateRecipeJob(request)
    }

    final case class UpdateScheduleOp(
      request: UpdateScheduleRequest
    ) extends DataBrewOp[UpdateScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateScheduleResponse] =
        visitor.updateSchedule(request)
    }
  }

  import DataBrewOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[DataBrewOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def batchDeleteRecipeVersion(
    request: BatchDeleteRecipeVersionRequest
  ): DataBrewIO[BatchDeleteRecipeVersionResponse] =
    FF.liftF(BatchDeleteRecipeVersionOp(request))

  def createDataset(
    request: CreateDatasetRequest
  ): DataBrewIO[CreateDatasetResponse] =
    FF.liftF(CreateDatasetOp(request))

  def createProfileJob(
    request: CreateProfileJobRequest
  ): DataBrewIO[CreateProfileJobResponse] =
    FF.liftF(CreateProfileJobOp(request))

  def createProject(
    request: CreateProjectRequest
  ): DataBrewIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def createRecipe(
    request: CreateRecipeRequest
  ): DataBrewIO[CreateRecipeResponse] =
    FF.liftF(CreateRecipeOp(request))

  def createRecipeJob(
    request: CreateRecipeJobRequest
  ): DataBrewIO[CreateRecipeJobResponse] =
    FF.liftF(CreateRecipeJobOp(request))

  def createSchedule(
    request: CreateScheduleRequest
  ): DataBrewIO[CreateScheduleResponse] =
    FF.liftF(CreateScheduleOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): DataBrewIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def deleteJob(
    request: DeleteJobRequest
  ): DataBrewIO[DeleteJobResponse] =
    FF.liftF(DeleteJobOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): DataBrewIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def deleteRecipeVersion(
    request: DeleteRecipeVersionRequest
  ): DataBrewIO[DeleteRecipeVersionResponse] =
    FF.liftF(DeleteRecipeVersionOp(request))

  def deleteSchedule(
    request: DeleteScheduleRequest
  ): DataBrewIO[DeleteScheduleResponse] =
    FF.liftF(DeleteScheduleOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): DataBrewIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeJob(
    request: DescribeJobRequest
  ): DataBrewIO[DescribeJobResponse] =
    FF.liftF(DescribeJobOp(request))

  def describeJobRun(
    request: DescribeJobRunRequest
  ): DataBrewIO[DescribeJobRunResponse] =
    FF.liftF(DescribeJobRunOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): DataBrewIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def describeRecipe(
    request: DescribeRecipeRequest
  ): DataBrewIO[DescribeRecipeResponse] =
    FF.liftF(DescribeRecipeOp(request))

  def describeSchedule(
    request: DescribeScheduleRequest
  ): DataBrewIO[DescribeScheduleResponse] =
    FF.liftF(DescribeScheduleOp(request))

  def listDatasets(
    request: ListDatasetsRequest
  ): DataBrewIO[ListDatasetsResponse] =
    FF.liftF(ListDatasetsOp(request))

  def listJobRuns(
    request: ListJobRunsRequest
  ): DataBrewIO[ListJobRunsResponse] =
    FF.liftF(ListJobRunsOp(request))

  def listJobs(
    request: ListJobsRequest
  ): DataBrewIO[ListJobsResponse] =
    FF.liftF(ListJobsOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): DataBrewIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listRecipeVersions(
    request: ListRecipeVersionsRequest
  ): DataBrewIO[ListRecipeVersionsResponse] =
    FF.liftF(ListRecipeVersionsOp(request))

  def listRecipes(
    request: ListRecipesRequest
  ): DataBrewIO[ListRecipesResponse] =
    FF.liftF(ListRecipesOp(request))

  def listSchedules(
    request: ListSchedulesRequest
  ): DataBrewIO[ListSchedulesResponse] =
    FF.liftF(ListSchedulesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): DataBrewIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def publishRecipe(
    request: PublishRecipeRequest
  ): DataBrewIO[PublishRecipeResponse] =
    FF.liftF(PublishRecipeOp(request))

  def sendProjectSessionAction(
    request: SendProjectSessionActionRequest
  ): DataBrewIO[SendProjectSessionActionResponse] =
    FF.liftF(SendProjectSessionActionOp(request))

  def startJobRun(
    request: StartJobRunRequest
  ): DataBrewIO[StartJobRunResponse] =
    FF.liftF(StartJobRunOp(request))

  def startProjectSession(
    request: StartProjectSessionRequest
  ): DataBrewIO[StartProjectSessionResponse] =
    FF.liftF(StartProjectSessionOp(request))

  def stopJobRun(
    request: StopJobRunRequest
  ): DataBrewIO[StopJobRunResponse] =
    FF.liftF(StopJobRunOp(request))

  def tagResource(
    request: TagResourceRequest
  ): DataBrewIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): DataBrewIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDataset(
    request: UpdateDatasetRequest
  ): DataBrewIO[UpdateDatasetResponse] =
    FF.liftF(UpdateDatasetOp(request))

  def updateProfileJob(
    request: UpdateProfileJobRequest
  ): DataBrewIO[UpdateProfileJobResponse] =
    FF.liftF(UpdateProfileJobOp(request))

  def updateProject(
    request: UpdateProjectRequest
  ): DataBrewIO[UpdateProjectResponse] =
    FF.liftF(UpdateProjectOp(request))

  def updateRecipe(
    request: UpdateRecipeRequest
  ): DataBrewIO[UpdateRecipeResponse] =
    FF.liftF(UpdateRecipeOp(request))

  def updateRecipeJob(
    request: UpdateRecipeJobRequest
  ): DataBrewIO[UpdateRecipeJobResponse] =
    FF.liftF(UpdateRecipeJobOp(request))

  def updateSchedule(
    request: UpdateScheduleRequest
  ): DataBrewIO[UpdateScheduleResponse] =
    FF.liftF(UpdateScheduleOp(request))
}
