package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.personalize.PersonalizeClient
import software.amazon.awssdk.services.personalize.model._


object personalize { module =>

  // Free monad over PersonalizeOp
  type PersonalizeIO[A] = FF[PersonalizeOp, A]

  sealed trait PersonalizeOp[A] {
    def visit[F[_]](visitor: PersonalizeOp.Visitor[F]): F[A]
  }

  object PersonalizeOp {
    // Given a PersonalizeClient we can embed a PersonalizeIO program in any algebra that understands embedding.
    implicit val PersonalizeOpEmbeddable: Embeddable[PersonalizeOp, PersonalizeClient] = new Embeddable[PersonalizeOp, PersonalizeClient] {
      def embed[A](client: PersonalizeClient, io: PersonalizeIO[A]): Embedded[A] = Embedded.Personalize(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends PersonalizeOp.Visitor[Kleisli[M, PersonalizeClient, *]] {
        def createBatchInferenceJob(
          request: CreateBatchInferenceJobRequest
        ): Kleisli[M, PersonalizeClient, CreateBatchInferenceJobResponse] =
          primitive(_.createBatchInferenceJob(request))

        def createCampaign(
          request: CreateCampaignRequest
        ): Kleisli[M, PersonalizeClient, CreateCampaignResponse] =
          primitive(_.createCampaign(request))

        def createDataset(
          request: CreateDatasetRequest
        ): Kleisli[M, PersonalizeClient, CreateDatasetResponse] =
          primitive(_.createDataset(request))

        def createDatasetExportJob(
          request: CreateDatasetExportJobRequest
        ): Kleisli[M, PersonalizeClient, CreateDatasetExportJobResponse] =
          primitive(_.createDatasetExportJob(request))

        def createDatasetGroup(
          request: CreateDatasetGroupRequest
        ): Kleisli[M, PersonalizeClient, CreateDatasetGroupResponse] =
          primitive(_.createDatasetGroup(request))

        def createDatasetImportJob(
          request: CreateDatasetImportJobRequest
        ): Kleisli[M, PersonalizeClient, CreateDatasetImportJobResponse] =
          primitive(_.createDatasetImportJob(request))

        def createEventTracker(
          request: CreateEventTrackerRequest
        ): Kleisli[M, PersonalizeClient, CreateEventTrackerResponse] =
          primitive(_.createEventTracker(request))

        def createFilter(
          request: CreateFilterRequest
        ): Kleisli[M, PersonalizeClient, CreateFilterResponse] =
          primitive(_.createFilter(request))

        def createSchema(
          request: CreateSchemaRequest
        ): Kleisli[M, PersonalizeClient, CreateSchemaResponse] =
          primitive(_.createSchema(request))

        def createSolution(
          request: CreateSolutionRequest
        ): Kleisli[M, PersonalizeClient, CreateSolutionResponse] =
          primitive(_.createSolution(request))

        def createSolutionVersion(
          request: CreateSolutionVersionRequest
        ): Kleisli[M, PersonalizeClient, CreateSolutionVersionResponse] =
          primitive(_.createSolutionVersion(request))

        def deleteCampaign(
          request: DeleteCampaignRequest
        ): Kleisli[M, PersonalizeClient, DeleteCampaignResponse] =
          primitive(_.deleteCampaign(request))

        def deleteDataset(
          request: DeleteDatasetRequest
        ): Kleisli[M, PersonalizeClient, DeleteDatasetResponse] =
          primitive(_.deleteDataset(request))

        def deleteDatasetGroup(
          request: DeleteDatasetGroupRequest
        ): Kleisli[M, PersonalizeClient, DeleteDatasetGroupResponse] =
          primitive(_.deleteDatasetGroup(request))

        def deleteEventTracker(
          request: DeleteEventTrackerRequest
        ): Kleisli[M, PersonalizeClient, DeleteEventTrackerResponse] =
          primitive(_.deleteEventTracker(request))

        def deleteFilter(
          request: DeleteFilterRequest
        ): Kleisli[M, PersonalizeClient, DeleteFilterResponse] =
          primitive(_.deleteFilter(request))

        def deleteSchema(
          request: DeleteSchemaRequest
        ): Kleisli[M, PersonalizeClient, DeleteSchemaResponse] =
          primitive(_.deleteSchema(request))

        def deleteSolution(
          request: DeleteSolutionRequest
        ): Kleisli[M, PersonalizeClient, DeleteSolutionResponse] =
          primitive(_.deleteSolution(request))

        def describeAlgorithm(
          request: DescribeAlgorithmRequest
        ): Kleisli[M, PersonalizeClient, DescribeAlgorithmResponse] =
          primitive(_.describeAlgorithm(request))

        def describeBatchInferenceJob(
          request: DescribeBatchInferenceJobRequest
        ): Kleisli[M, PersonalizeClient, DescribeBatchInferenceJobResponse] =
          primitive(_.describeBatchInferenceJob(request))

        def describeCampaign(
          request: DescribeCampaignRequest
        ): Kleisli[M, PersonalizeClient, DescribeCampaignResponse] =
          primitive(_.describeCampaign(request))

        def describeDataset(
          request: DescribeDatasetRequest
        ): Kleisli[M, PersonalizeClient, DescribeDatasetResponse] =
          primitive(_.describeDataset(request))

        def describeDatasetExportJob(
          request: DescribeDatasetExportJobRequest
        ): Kleisli[M, PersonalizeClient, DescribeDatasetExportJobResponse] =
          primitive(_.describeDatasetExportJob(request))

        def describeDatasetGroup(
          request: DescribeDatasetGroupRequest
        ): Kleisli[M, PersonalizeClient, DescribeDatasetGroupResponse] =
          primitive(_.describeDatasetGroup(request))

        def describeDatasetImportJob(
          request: DescribeDatasetImportJobRequest
        ): Kleisli[M, PersonalizeClient, DescribeDatasetImportJobResponse] =
          primitive(_.describeDatasetImportJob(request))

        def describeEventTracker(
          request: DescribeEventTrackerRequest
        ): Kleisli[M, PersonalizeClient, DescribeEventTrackerResponse] =
          primitive(_.describeEventTracker(request))

        def describeFeatureTransformation(
          request: DescribeFeatureTransformationRequest
        ): Kleisli[M, PersonalizeClient, DescribeFeatureTransformationResponse] =
          primitive(_.describeFeatureTransformation(request))

        def describeFilter(
          request: DescribeFilterRequest
        ): Kleisli[M, PersonalizeClient, DescribeFilterResponse] =
          primitive(_.describeFilter(request))

        def describeRecipe(
          request: DescribeRecipeRequest
        ): Kleisli[M, PersonalizeClient, DescribeRecipeResponse] =
          primitive(_.describeRecipe(request))

        def describeSchema(
          request: DescribeSchemaRequest
        ): Kleisli[M, PersonalizeClient, DescribeSchemaResponse] =
          primitive(_.describeSchema(request))

        def describeSolution(
          request: DescribeSolutionRequest
        ): Kleisli[M, PersonalizeClient, DescribeSolutionResponse] =
          primitive(_.describeSolution(request))

        def describeSolutionVersion(
          request: DescribeSolutionVersionRequest
        ): Kleisli[M, PersonalizeClient, DescribeSolutionVersionResponse] =
          primitive(_.describeSolutionVersion(request))

        def getSolutionMetrics(
          request: GetSolutionMetricsRequest
        ): Kleisli[M, PersonalizeClient, GetSolutionMetricsResponse] =
          primitive(_.getSolutionMetrics(request))

        def listBatchInferenceJobs(
          request: ListBatchInferenceJobsRequest
        ): Kleisli[M, PersonalizeClient, ListBatchInferenceJobsResponse] =
          primitive(_.listBatchInferenceJobs(request))

        def listCampaigns(
          request: ListCampaignsRequest
        ): Kleisli[M, PersonalizeClient, ListCampaignsResponse] =
          primitive(_.listCampaigns(request))

        def listDatasetExportJobs(
          request: ListDatasetExportJobsRequest
        ): Kleisli[M, PersonalizeClient, ListDatasetExportJobsResponse] =
          primitive(_.listDatasetExportJobs(request))

        def listDatasetGroups(
          request: ListDatasetGroupsRequest
        ): Kleisli[M, PersonalizeClient, ListDatasetGroupsResponse] =
          primitive(_.listDatasetGroups(request))

        def listDatasetImportJobs(
          request: ListDatasetImportJobsRequest
        ): Kleisli[M, PersonalizeClient, ListDatasetImportJobsResponse] =
          primitive(_.listDatasetImportJobs(request))

        def listDatasets(
          request: ListDatasetsRequest
        ): Kleisli[M, PersonalizeClient, ListDatasetsResponse] =
          primitive(_.listDatasets(request))

        def listEventTrackers(
          request: ListEventTrackersRequest
        ): Kleisli[M, PersonalizeClient, ListEventTrackersResponse] =
          primitive(_.listEventTrackers(request))

        def listFilters(
          request: ListFiltersRequest
        ): Kleisli[M, PersonalizeClient, ListFiltersResponse] =
          primitive(_.listFilters(request))

        def listRecipes(
          request: ListRecipesRequest
        ): Kleisli[M, PersonalizeClient, ListRecipesResponse] =
          primitive(_.listRecipes(request))

        def listSchemas(
          request: ListSchemasRequest
        ): Kleisli[M, PersonalizeClient, ListSchemasResponse] =
          primitive(_.listSchemas(request))

        def listSolutionVersions(
          request: ListSolutionVersionsRequest
        ): Kleisli[M, PersonalizeClient, ListSolutionVersionsResponse] =
          primitive(_.listSolutionVersions(request))

        def listSolutions(
          request: ListSolutionsRequest
        ): Kleisli[M, PersonalizeClient, ListSolutionsResponse] =
          primitive(_.listSolutions(request))

        def stopSolutionVersionCreation(
          request: StopSolutionVersionCreationRequest
        ): Kleisli[M, PersonalizeClient, StopSolutionVersionCreationResponse] =
          primitive(_.stopSolutionVersionCreation(request))

        def updateCampaign(
          request: UpdateCampaignRequest
        ): Kleisli[M, PersonalizeClient, UpdateCampaignResponse] =
          primitive(_.updateCampaign(request))

        def primitive[A](
          f: PersonalizeClient => A
        ): Kleisli[M, PersonalizeClient, A]
      }
    }

    trait Visitor[F[_]] extends (PersonalizeOp ~> F) {
      final def apply[A](op: PersonalizeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def createBatchInferenceJob(
        request: CreateBatchInferenceJobRequest
      ): F[CreateBatchInferenceJobResponse]

      def createCampaign(
        request: CreateCampaignRequest
      ): F[CreateCampaignResponse]

      def createDataset(
        request: CreateDatasetRequest
      ): F[CreateDatasetResponse]

      def createDatasetExportJob(
        request: CreateDatasetExportJobRequest
      ): F[CreateDatasetExportJobResponse]

      def createDatasetGroup(
        request: CreateDatasetGroupRequest
      ): F[CreateDatasetGroupResponse]

      def createDatasetImportJob(
        request: CreateDatasetImportJobRequest
      ): F[CreateDatasetImportJobResponse]

      def createEventTracker(
        request: CreateEventTrackerRequest
      ): F[CreateEventTrackerResponse]

      def createFilter(
        request: CreateFilterRequest
      ): F[CreateFilterResponse]

      def createSchema(
        request: CreateSchemaRequest
      ): F[CreateSchemaResponse]

      def createSolution(
        request: CreateSolutionRequest
      ): F[CreateSolutionResponse]

      def createSolutionVersion(
        request: CreateSolutionVersionRequest
      ): F[CreateSolutionVersionResponse]

      def deleteCampaign(
        request: DeleteCampaignRequest
      ): F[DeleteCampaignResponse]

      def deleteDataset(
        request: DeleteDatasetRequest
      ): F[DeleteDatasetResponse]

      def deleteDatasetGroup(
        request: DeleteDatasetGroupRequest
      ): F[DeleteDatasetGroupResponse]

      def deleteEventTracker(
        request: DeleteEventTrackerRequest
      ): F[DeleteEventTrackerResponse]

      def deleteFilter(
        request: DeleteFilterRequest
      ): F[DeleteFilterResponse]

      def deleteSchema(
        request: DeleteSchemaRequest
      ): F[DeleteSchemaResponse]

      def deleteSolution(
        request: DeleteSolutionRequest
      ): F[DeleteSolutionResponse]

      def describeAlgorithm(
        request: DescribeAlgorithmRequest
      ): F[DescribeAlgorithmResponse]

      def describeBatchInferenceJob(
        request: DescribeBatchInferenceJobRequest
      ): F[DescribeBatchInferenceJobResponse]

      def describeCampaign(
        request: DescribeCampaignRequest
      ): F[DescribeCampaignResponse]

      def describeDataset(
        request: DescribeDatasetRequest
      ): F[DescribeDatasetResponse]

      def describeDatasetExportJob(
        request: DescribeDatasetExportJobRequest
      ): F[DescribeDatasetExportJobResponse]

      def describeDatasetGroup(
        request: DescribeDatasetGroupRequest
      ): F[DescribeDatasetGroupResponse]

      def describeDatasetImportJob(
        request: DescribeDatasetImportJobRequest
      ): F[DescribeDatasetImportJobResponse]

      def describeEventTracker(
        request: DescribeEventTrackerRequest
      ): F[DescribeEventTrackerResponse]

      def describeFeatureTransformation(
        request: DescribeFeatureTransformationRequest
      ): F[DescribeFeatureTransformationResponse]

      def describeFilter(
        request: DescribeFilterRequest
      ): F[DescribeFilterResponse]

      def describeRecipe(
        request: DescribeRecipeRequest
      ): F[DescribeRecipeResponse]

      def describeSchema(
        request: DescribeSchemaRequest
      ): F[DescribeSchemaResponse]

      def describeSolution(
        request: DescribeSolutionRequest
      ): F[DescribeSolutionResponse]

      def describeSolutionVersion(
        request: DescribeSolutionVersionRequest
      ): F[DescribeSolutionVersionResponse]

      def getSolutionMetrics(
        request: GetSolutionMetricsRequest
      ): F[GetSolutionMetricsResponse]

      def listBatchInferenceJobs(
        request: ListBatchInferenceJobsRequest
      ): F[ListBatchInferenceJobsResponse]

      def listCampaigns(
        request: ListCampaignsRequest
      ): F[ListCampaignsResponse]

      def listDatasetExportJobs(
        request: ListDatasetExportJobsRequest
      ): F[ListDatasetExportJobsResponse]

      def listDatasetGroups(
        request: ListDatasetGroupsRequest
      ): F[ListDatasetGroupsResponse]

      def listDatasetImportJobs(
        request: ListDatasetImportJobsRequest
      ): F[ListDatasetImportJobsResponse]

      def listDatasets(
        request: ListDatasetsRequest
      ): F[ListDatasetsResponse]

      def listEventTrackers(
        request: ListEventTrackersRequest
      ): F[ListEventTrackersResponse]

      def listFilters(
        request: ListFiltersRequest
      ): F[ListFiltersResponse]

      def listRecipes(
        request: ListRecipesRequest
      ): F[ListRecipesResponse]

      def listSchemas(
        request: ListSchemasRequest
      ): F[ListSchemasResponse]

      def listSolutionVersions(
        request: ListSolutionVersionsRequest
      ): F[ListSolutionVersionsResponse]

      def listSolutions(
        request: ListSolutionsRequest
      ): F[ListSolutionsResponse]

      def stopSolutionVersionCreation(
        request: StopSolutionVersionCreationRequest
      ): F[StopSolutionVersionCreationResponse]

      def updateCampaign(
        request: UpdateCampaignRequest
      ): F[UpdateCampaignResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends PersonalizeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class CreateBatchInferenceJobOp(
      request: CreateBatchInferenceJobRequest
    ) extends PersonalizeOp[CreateBatchInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBatchInferenceJobResponse] =
        visitor.createBatchInferenceJob(request)
    }

    final case class CreateCampaignOp(
      request: CreateCampaignRequest
    ) extends PersonalizeOp[CreateCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateCampaignResponse] =
        visitor.createCampaign(request)
    }

    final case class CreateDatasetOp(
      request: CreateDatasetRequest
    ) extends PersonalizeOp[CreateDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetResponse] =
        visitor.createDataset(request)
    }

    final case class CreateDatasetExportJobOp(
      request: CreateDatasetExportJobRequest
    ) extends PersonalizeOp[CreateDatasetExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetExportJobResponse] =
        visitor.createDatasetExportJob(request)
    }

    final case class CreateDatasetGroupOp(
      request: CreateDatasetGroupRequest
    ) extends PersonalizeOp[CreateDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetGroupResponse] =
        visitor.createDatasetGroup(request)
    }

    final case class CreateDatasetImportJobOp(
      request: CreateDatasetImportJobRequest
    ) extends PersonalizeOp[CreateDatasetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDatasetImportJobResponse] =
        visitor.createDatasetImportJob(request)
    }

    final case class CreateEventTrackerOp(
      request: CreateEventTrackerRequest
    ) extends PersonalizeOp[CreateEventTrackerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateEventTrackerResponse] =
        visitor.createEventTracker(request)
    }

    final case class CreateFilterOp(
      request: CreateFilterRequest
    ) extends PersonalizeOp[CreateFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFilterResponse] =
        visitor.createFilter(request)
    }

    final case class CreateSchemaOp(
      request: CreateSchemaRequest
    ) extends PersonalizeOp[CreateSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSchemaResponse] =
        visitor.createSchema(request)
    }

    final case class CreateSolutionOp(
      request: CreateSolutionRequest
    ) extends PersonalizeOp[CreateSolutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSolutionResponse] =
        visitor.createSolution(request)
    }

    final case class CreateSolutionVersionOp(
      request: CreateSolutionVersionRequest
    ) extends PersonalizeOp[CreateSolutionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSolutionVersionResponse] =
        visitor.createSolutionVersion(request)
    }

    final case class DeleteCampaignOp(
      request: DeleteCampaignRequest
    ) extends PersonalizeOp[DeleteCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteCampaignResponse] =
        visitor.deleteCampaign(request)
    }

    final case class DeleteDatasetOp(
      request: DeleteDatasetRequest
    ) extends PersonalizeOp[DeleteDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetResponse] =
        visitor.deleteDataset(request)
    }

    final case class DeleteDatasetGroupOp(
      request: DeleteDatasetGroupRequest
    ) extends PersonalizeOp[DeleteDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDatasetGroupResponse] =
        visitor.deleteDatasetGroup(request)
    }

    final case class DeleteEventTrackerOp(
      request: DeleteEventTrackerRequest
    ) extends PersonalizeOp[DeleteEventTrackerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventTrackerResponse] =
        visitor.deleteEventTracker(request)
    }

    final case class DeleteFilterOp(
      request: DeleteFilterRequest
    ) extends PersonalizeOp[DeleteFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFilterResponse] =
        visitor.deleteFilter(request)
    }

    final case class DeleteSchemaOp(
      request: DeleteSchemaRequest
    ) extends PersonalizeOp[DeleteSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSchemaResponse] =
        visitor.deleteSchema(request)
    }

    final case class DeleteSolutionOp(
      request: DeleteSolutionRequest
    ) extends PersonalizeOp[DeleteSolutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSolutionResponse] =
        visitor.deleteSolution(request)
    }

    final case class DescribeAlgorithmOp(
      request: DescribeAlgorithmRequest
    ) extends PersonalizeOp[DescribeAlgorithmResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAlgorithmResponse] =
        visitor.describeAlgorithm(request)
    }

    final case class DescribeBatchInferenceJobOp(
      request: DescribeBatchInferenceJobRequest
    ) extends PersonalizeOp[DescribeBatchInferenceJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBatchInferenceJobResponse] =
        visitor.describeBatchInferenceJob(request)
    }

    final case class DescribeCampaignOp(
      request: DescribeCampaignRequest
    ) extends PersonalizeOp[DescribeCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCampaignResponse] =
        visitor.describeCampaign(request)
    }

    final case class DescribeDatasetOp(
      request: DescribeDatasetRequest
    ) extends PersonalizeOp[DescribeDatasetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetResponse] =
        visitor.describeDataset(request)
    }

    final case class DescribeDatasetExportJobOp(
      request: DescribeDatasetExportJobRequest
    ) extends PersonalizeOp[DescribeDatasetExportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetExportJobResponse] =
        visitor.describeDatasetExportJob(request)
    }

    final case class DescribeDatasetGroupOp(
      request: DescribeDatasetGroupRequest
    ) extends PersonalizeOp[DescribeDatasetGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetGroupResponse] =
        visitor.describeDatasetGroup(request)
    }

    final case class DescribeDatasetImportJobOp(
      request: DescribeDatasetImportJobRequest
    ) extends PersonalizeOp[DescribeDatasetImportJobResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDatasetImportJobResponse] =
        visitor.describeDatasetImportJob(request)
    }

    final case class DescribeEventTrackerOp(
      request: DescribeEventTrackerRequest
    ) extends PersonalizeOp[DescribeEventTrackerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEventTrackerResponse] =
        visitor.describeEventTracker(request)
    }

    final case class DescribeFeatureTransformationOp(
      request: DescribeFeatureTransformationRequest
    ) extends PersonalizeOp[DescribeFeatureTransformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFeatureTransformationResponse] =
        visitor.describeFeatureTransformation(request)
    }

    final case class DescribeFilterOp(
      request: DescribeFilterRequest
    ) extends PersonalizeOp[DescribeFilterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFilterResponse] =
        visitor.describeFilter(request)
    }

    final case class DescribeRecipeOp(
      request: DescribeRecipeRequest
    ) extends PersonalizeOp[DescribeRecipeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRecipeResponse] =
        visitor.describeRecipe(request)
    }

    final case class DescribeSchemaOp(
      request: DescribeSchemaRequest
    ) extends PersonalizeOp[DescribeSchemaResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSchemaResponse] =
        visitor.describeSchema(request)
    }

    final case class DescribeSolutionOp(
      request: DescribeSolutionRequest
    ) extends PersonalizeOp[DescribeSolutionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSolutionResponse] =
        visitor.describeSolution(request)
    }

    final case class DescribeSolutionVersionOp(
      request: DescribeSolutionVersionRequest
    ) extends PersonalizeOp[DescribeSolutionVersionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeSolutionVersionResponse] =
        visitor.describeSolutionVersion(request)
    }

    final case class GetSolutionMetricsOp(
      request: GetSolutionMetricsRequest
    ) extends PersonalizeOp[GetSolutionMetricsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSolutionMetricsResponse] =
        visitor.getSolutionMetrics(request)
    }

    final case class ListBatchInferenceJobsOp(
      request: ListBatchInferenceJobsRequest
    ) extends PersonalizeOp[ListBatchInferenceJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBatchInferenceJobsResponse] =
        visitor.listBatchInferenceJobs(request)
    }

    final case class ListCampaignsOp(
      request: ListCampaignsRequest
    ) extends PersonalizeOp[ListCampaignsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListCampaignsResponse] =
        visitor.listCampaigns(request)
    }

    final case class ListDatasetExportJobsOp(
      request: ListDatasetExportJobsRequest
    ) extends PersonalizeOp[ListDatasetExportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetExportJobsResponse] =
        visitor.listDatasetExportJobs(request)
    }

    final case class ListDatasetGroupsOp(
      request: ListDatasetGroupsRequest
    ) extends PersonalizeOp[ListDatasetGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetGroupsResponse] =
        visitor.listDatasetGroups(request)
    }

    final case class ListDatasetImportJobsOp(
      request: ListDatasetImportJobsRequest
    ) extends PersonalizeOp[ListDatasetImportJobsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetImportJobsResponse] =
        visitor.listDatasetImportJobs(request)
    }

    final case class ListDatasetsOp(
      request: ListDatasetsRequest
    ) extends PersonalizeOp[ListDatasetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDatasetsResponse] =
        visitor.listDatasets(request)
    }

    final case class ListEventTrackersOp(
      request: ListEventTrackersRequest
    ) extends PersonalizeOp[ListEventTrackersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListEventTrackersResponse] =
        visitor.listEventTrackers(request)
    }

    final case class ListFiltersOp(
      request: ListFiltersRequest
    ) extends PersonalizeOp[ListFiltersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFiltersResponse] =
        visitor.listFilters(request)
    }

    final case class ListRecipesOp(
      request: ListRecipesRequest
    ) extends PersonalizeOp[ListRecipesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecipesResponse] =
        visitor.listRecipes(request)
    }

    final case class ListSchemasOp(
      request: ListSchemasRequest
    ) extends PersonalizeOp[ListSchemasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSchemasResponse] =
        visitor.listSchemas(request)
    }

    final case class ListSolutionVersionsOp(
      request: ListSolutionVersionsRequest
    ) extends PersonalizeOp[ListSolutionVersionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSolutionVersionsResponse] =
        visitor.listSolutionVersions(request)
    }

    final case class ListSolutionsOp(
      request: ListSolutionsRequest
    ) extends PersonalizeOp[ListSolutionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSolutionsResponse] =
        visitor.listSolutions(request)
    }

    final case class StopSolutionVersionCreationOp(
      request: StopSolutionVersionCreationRequest
    ) extends PersonalizeOp[StopSolutionVersionCreationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopSolutionVersionCreationResponse] =
        visitor.stopSolutionVersionCreation(request)
    }

    final case class UpdateCampaignOp(
      request: UpdateCampaignRequest
    ) extends PersonalizeOp[UpdateCampaignResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateCampaignResponse] =
        visitor.updateCampaign(request)
    }
  }

  import PersonalizeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[PersonalizeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def createBatchInferenceJob(
    request: CreateBatchInferenceJobRequest
  ): PersonalizeIO[CreateBatchInferenceJobResponse] =
    FF.liftF(CreateBatchInferenceJobOp(request))

  def createCampaign(
    request: CreateCampaignRequest
  ): PersonalizeIO[CreateCampaignResponse] =
    FF.liftF(CreateCampaignOp(request))

  def createDataset(
    request: CreateDatasetRequest
  ): PersonalizeIO[CreateDatasetResponse] =
    FF.liftF(CreateDatasetOp(request))

  def createDatasetExportJob(
    request: CreateDatasetExportJobRequest
  ): PersonalizeIO[CreateDatasetExportJobResponse] =
    FF.liftF(CreateDatasetExportJobOp(request))

  def createDatasetGroup(
    request: CreateDatasetGroupRequest
  ): PersonalizeIO[CreateDatasetGroupResponse] =
    FF.liftF(CreateDatasetGroupOp(request))

  def createDatasetImportJob(
    request: CreateDatasetImportJobRequest
  ): PersonalizeIO[CreateDatasetImportJobResponse] =
    FF.liftF(CreateDatasetImportJobOp(request))

  def createEventTracker(
    request: CreateEventTrackerRequest
  ): PersonalizeIO[CreateEventTrackerResponse] =
    FF.liftF(CreateEventTrackerOp(request))

  def createFilter(
    request: CreateFilterRequest
  ): PersonalizeIO[CreateFilterResponse] =
    FF.liftF(CreateFilterOp(request))

  def createSchema(
    request: CreateSchemaRequest
  ): PersonalizeIO[CreateSchemaResponse] =
    FF.liftF(CreateSchemaOp(request))

  def createSolution(
    request: CreateSolutionRequest
  ): PersonalizeIO[CreateSolutionResponse] =
    FF.liftF(CreateSolutionOp(request))

  def createSolutionVersion(
    request: CreateSolutionVersionRequest
  ): PersonalizeIO[CreateSolutionVersionResponse] =
    FF.liftF(CreateSolutionVersionOp(request))

  def deleteCampaign(
    request: DeleteCampaignRequest
  ): PersonalizeIO[DeleteCampaignResponse] =
    FF.liftF(DeleteCampaignOp(request))

  def deleteDataset(
    request: DeleteDatasetRequest
  ): PersonalizeIO[DeleteDatasetResponse] =
    FF.liftF(DeleteDatasetOp(request))

  def deleteDatasetGroup(
    request: DeleteDatasetGroupRequest
  ): PersonalizeIO[DeleteDatasetGroupResponse] =
    FF.liftF(DeleteDatasetGroupOp(request))

  def deleteEventTracker(
    request: DeleteEventTrackerRequest
  ): PersonalizeIO[DeleteEventTrackerResponse] =
    FF.liftF(DeleteEventTrackerOp(request))

  def deleteFilter(
    request: DeleteFilterRequest
  ): PersonalizeIO[DeleteFilterResponse] =
    FF.liftF(DeleteFilterOp(request))

  def deleteSchema(
    request: DeleteSchemaRequest
  ): PersonalizeIO[DeleteSchemaResponse] =
    FF.liftF(DeleteSchemaOp(request))

  def deleteSolution(
    request: DeleteSolutionRequest
  ): PersonalizeIO[DeleteSolutionResponse] =
    FF.liftF(DeleteSolutionOp(request))

  def describeAlgorithm(
    request: DescribeAlgorithmRequest
  ): PersonalizeIO[DescribeAlgorithmResponse] =
    FF.liftF(DescribeAlgorithmOp(request))

  def describeBatchInferenceJob(
    request: DescribeBatchInferenceJobRequest
  ): PersonalizeIO[DescribeBatchInferenceJobResponse] =
    FF.liftF(DescribeBatchInferenceJobOp(request))

  def describeCampaign(
    request: DescribeCampaignRequest
  ): PersonalizeIO[DescribeCampaignResponse] =
    FF.liftF(DescribeCampaignOp(request))

  def describeDataset(
    request: DescribeDatasetRequest
  ): PersonalizeIO[DescribeDatasetResponse] =
    FF.liftF(DescribeDatasetOp(request))

  def describeDatasetExportJob(
    request: DescribeDatasetExportJobRequest
  ): PersonalizeIO[DescribeDatasetExportJobResponse] =
    FF.liftF(DescribeDatasetExportJobOp(request))

  def describeDatasetGroup(
    request: DescribeDatasetGroupRequest
  ): PersonalizeIO[DescribeDatasetGroupResponse] =
    FF.liftF(DescribeDatasetGroupOp(request))

  def describeDatasetImportJob(
    request: DescribeDatasetImportJobRequest
  ): PersonalizeIO[DescribeDatasetImportJobResponse] =
    FF.liftF(DescribeDatasetImportJobOp(request))

  def describeEventTracker(
    request: DescribeEventTrackerRequest
  ): PersonalizeIO[DescribeEventTrackerResponse] =
    FF.liftF(DescribeEventTrackerOp(request))

  def describeFeatureTransformation(
    request: DescribeFeatureTransformationRequest
  ): PersonalizeIO[DescribeFeatureTransformationResponse] =
    FF.liftF(DescribeFeatureTransformationOp(request))

  def describeFilter(
    request: DescribeFilterRequest
  ): PersonalizeIO[DescribeFilterResponse] =
    FF.liftF(DescribeFilterOp(request))

  def describeRecipe(
    request: DescribeRecipeRequest
  ): PersonalizeIO[DescribeRecipeResponse] =
    FF.liftF(DescribeRecipeOp(request))

  def describeSchema(
    request: DescribeSchemaRequest
  ): PersonalizeIO[DescribeSchemaResponse] =
    FF.liftF(DescribeSchemaOp(request))

  def describeSolution(
    request: DescribeSolutionRequest
  ): PersonalizeIO[DescribeSolutionResponse] =
    FF.liftF(DescribeSolutionOp(request))

  def describeSolutionVersion(
    request: DescribeSolutionVersionRequest
  ): PersonalizeIO[DescribeSolutionVersionResponse] =
    FF.liftF(DescribeSolutionVersionOp(request))

  def getSolutionMetrics(
    request: GetSolutionMetricsRequest
  ): PersonalizeIO[GetSolutionMetricsResponse] =
    FF.liftF(GetSolutionMetricsOp(request))

  def listBatchInferenceJobs(
    request: ListBatchInferenceJobsRequest
  ): PersonalizeIO[ListBatchInferenceJobsResponse] =
    FF.liftF(ListBatchInferenceJobsOp(request))

  def listCampaigns(
    request: ListCampaignsRequest
  ): PersonalizeIO[ListCampaignsResponse] =
    FF.liftF(ListCampaignsOp(request))

  def listDatasetExportJobs(
    request: ListDatasetExportJobsRequest
  ): PersonalizeIO[ListDatasetExportJobsResponse] =
    FF.liftF(ListDatasetExportJobsOp(request))

  def listDatasetGroups(
    request: ListDatasetGroupsRequest
  ): PersonalizeIO[ListDatasetGroupsResponse] =
    FF.liftF(ListDatasetGroupsOp(request))

  def listDatasetImportJobs(
    request: ListDatasetImportJobsRequest
  ): PersonalizeIO[ListDatasetImportJobsResponse] =
    FF.liftF(ListDatasetImportJobsOp(request))

  def listDatasets(
    request: ListDatasetsRequest
  ): PersonalizeIO[ListDatasetsResponse] =
    FF.liftF(ListDatasetsOp(request))

  def listEventTrackers(
    request: ListEventTrackersRequest
  ): PersonalizeIO[ListEventTrackersResponse] =
    FF.liftF(ListEventTrackersOp(request))

  def listFilters(
    request: ListFiltersRequest
  ): PersonalizeIO[ListFiltersResponse] =
    FF.liftF(ListFiltersOp(request))

  def listRecipes(
    request: ListRecipesRequest
  ): PersonalizeIO[ListRecipesResponse] =
    FF.liftF(ListRecipesOp(request))

  def listSchemas(
    request: ListSchemasRequest
  ): PersonalizeIO[ListSchemasResponse] =
    FF.liftF(ListSchemasOp(request))

  def listSolutionVersions(
    request: ListSolutionVersionsRequest
  ): PersonalizeIO[ListSolutionVersionsResponse] =
    FF.liftF(ListSolutionVersionsOp(request))

  def listSolutions(
    request: ListSolutionsRequest
  ): PersonalizeIO[ListSolutionsResponse] =
    FF.liftF(ListSolutionsOp(request))

  def stopSolutionVersionCreation(
    request: StopSolutionVersionCreationRequest
  ): PersonalizeIO[StopSolutionVersionCreationResponse] =
    FF.liftF(StopSolutionVersionCreationOp(request))

  def updateCampaign(
    request: UpdateCampaignRequest
  ): PersonalizeIO[UpdateCampaignResponse] =
    FF.liftF(UpdateCampaignOp(request))
}
