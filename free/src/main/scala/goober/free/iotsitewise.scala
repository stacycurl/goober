package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotsitewise.IoTSiteWiseClient
import software.amazon.awssdk.services.iotsitewise.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object iotsitewise { module =>

  // Free monad over IoTSiteWiseOp
  type IoTSiteWiseIO[A] = FF[IoTSiteWiseOp, A]

  sealed trait IoTSiteWiseOp[A] {
    def visit[F[_]](visitor: IoTSiteWiseOp.Visitor[F]): F[A]
  }

  object IoTSiteWiseOp {
    // Given a IoTSiteWiseClient we can embed a IoTSiteWiseIO program in any algebra that understands embedding.
    implicit val IoTSiteWiseOpEmbeddable: Embeddable[IoTSiteWiseOp, IoTSiteWiseClient] = new Embeddable[IoTSiteWiseOp, IoTSiteWiseClient] {
      def embed[A](client: IoTSiteWiseClient, io: IoTSiteWiseIO[A]): Embedded[A] = Embedded.IoTSiteWise(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IoTSiteWiseOp.Visitor[Kleisli[M, IoTSiteWiseClient, *]] {
        def associateAssets(
          request: AssociateAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, AssociateAssetsResponse] =
          primitive(_.associateAssets(request))

        def batchAssociateProjectAssets(
          request: BatchAssociateProjectAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, BatchAssociateProjectAssetsResponse] =
          primitive(_.batchAssociateProjectAssets(request))

        def batchDisassociateProjectAssets(
          request: BatchDisassociateProjectAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, BatchDisassociateProjectAssetsResponse] =
          primitive(_.batchDisassociateProjectAssets(request))

        def batchPutAssetPropertyValue(
          request: BatchPutAssetPropertyValueRequest
        ): Kleisli[M, IoTSiteWiseClient, BatchPutAssetPropertyValueResponse] =
          primitive(_.batchPutAssetPropertyValue(request))

        def createAccessPolicy(
          request: CreateAccessPolicyRequest
        ): Kleisli[M, IoTSiteWiseClient, CreateAccessPolicyResponse] =
          primitive(_.createAccessPolicy(request))

        def createAsset(
          request: CreateAssetRequest
        ): Kleisli[M, IoTSiteWiseClient, CreateAssetResponse] =
          primitive(_.createAsset(request))

        def createAssetModel(
          request: CreateAssetModelRequest
        ): Kleisli[M, IoTSiteWiseClient, CreateAssetModelResponse] =
          primitive(_.createAssetModel(request))

        def createDashboard(
          request: CreateDashboardRequest
        ): Kleisli[M, IoTSiteWiseClient, CreateDashboardResponse] =
          primitive(_.createDashboard(request))

        def createGateway(
          request: CreateGatewayRequest
        ): Kleisli[M, IoTSiteWiseClient, CreateGatewayResponse] =
          primitive(_.createGateway(request))

        def createPortal(
          request: CreatePortalRequest
        ): Kleisli[M, IoTSiteWiseClient, CreatePortalResponse] =
          primitive(_.createPortal(request))

        def createProject(
          request: CreateProjectRequest
        ): Kleisli[M, IoTSiteWiseClient, CreateProjectResponse] =
          primitive(_.createProject(request))

        def deleteAccessPolicy(
          request: DeleteAccessPolicyRequest
        ): Kleisli[M, IoTSiteWiseClient, DeleteAccessPolicyResponse] =
          primitive(_.deleteAccessPolicy(request))

        def deleteAsset(
          request: DeleteAssetRequest
        ): Kleisli[M, IoTSiteWiseClient, DeleteAssetResponse] =
          primitive(_.deleteAsset(request))

        def deleteAssetModel(
          request: DeleteAssetModelRequest
        ): Kleisli[M, IoTSiteWiseClient, DeleteAssetModelResponse] =
          primitive(_.deleteAssetModel(request))

        def deleteDashboard(
          request: DeleteDashboardRequest
        ): Kleisli[M, IoTSiteWiseClient, DeleteDashboardResponse] =
          primitive(_.deleteDashboard(request))

        def deleteGateway(
          request: DeleteGatewayRequest
        ): Kleisli[M, IoTSiteWiseClient, DeleteGatewayResponse] =
          primitive(_.deleteGateway(request))

        def deletePortal(
          request: DeletePortalRequest
        ): Kleisli[M, IoTSiteWiseClient, DeletePortalResponse] =
          primitive(_.deletePortal(request))

        def deleteProject(
          request: DeleteProjectRequest
        ): Kleisli[M, IoTSiteWiseClient, DeleteProjectResponse] =
          primitive(_.deleteProject(request))

        def describeAccessPolicy(
          request: DescribeAccessPolicyRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeAccessPolicyResponse] =
          primitive(_.describeAccessPolicy(request))

        def describeAsset(
          request: DescribeAssetRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeAssetResponse] =
          primitive(_.describeAsset(request))

        def describeAssetModel(
          request: DescribeAssetModelRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeAssetModelResponse] =
          primitive(_.describeAssetModel(request))

        def describeAssetProperty(
          request: DescribeAssetPropertyRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeAssetPropertyResponse] =
          primitive(_.describeAssetProperty(request))

        def describeDashboard(
          request: DescribeDashboardRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeDashboardResponse] =
          primitive(_.describeDashboard(request))

        def describeDefaultEncryptionConfiguration(
          request: DescribeDefaultEncryptionConfigurationRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeDefaultEncryptionConfigurationResponse] =
          primitive(_.describeDefaultEncryptionConfiguration(request))

        def describeGateway(
          request: DescribeGatewayRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeGatewayResponse] =
          primitive(_.describeGateway(request))

        def describeGatewayCapabilityConfiguration(
          request: DescribeGatewayCapabilityConfigurationRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeGatewayCapabilityConfigurationResponse] =
          primitive(_.describeGatewayCapabilityConfiguration(request))

        def describeLoggingOptions(
          request: DescribeLoggingOptionsRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeLoggingOptionsResponse] =
          primitive(_.describeLoggingOptions(request))

        def describePortal(
          request: DescribePortalRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribePortalResponse] =
          primitive(_.describePortal(request))

        def describeProject(
          request: DescribeProjectRequest
        ): Kleisli[M, IoTSiteWiseClient, DescribeProjectResponse] =
          primitive(_.describeProject(request))

        def disassociateAssets(
          request: DisassociateAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, DisassociateAssetsResponse] =
          primitive(_.disassociateAssets(request))

        def getAssetPropertyAggregates(
          request: GetAssetPropertyAggregatesRequest
        ): Kleisli[M, IoTSiteWiseClient, GetAssetPropertyAggregatesResponse] =
          primitive(_.getAssetPropertyAggregates(request))

        def getAssetPropertyValue(
          request: GetAssetPropertyValueRequest
        ): Kleisli[M, IoTSiteWiseClient, GetAssetPropertyValueResponse] =
          primitive(_.getAssetPropertyValue(request))

        def getAssetPropertyValueHistory(
          request: GetAssetPropertyValueHistoryRequest
        ): Kleisli[M, IoTSiteWiseClient, GetAssetPropertyValueHistoryResponse] =
          primitive(_.getAssetPropertyValueHistory(request))

        def getInterpolatedAssetPropertyValues(
          request: GetInterpolatedAssetPropertyValuesRequest
        ): Kleisli[M, IoTSiteWiseClient, GetInterpolatedAssetPropertyValuesResponse] =
          primitive(_.getInterpolatedAssetPropertyValues(request))

        def listAccessPolicies(
          request: ListAccessPoliciesRequest
        ): Kleisli[M, IoTSiteWiseClient, ListAccessPoliciesResponse] =
          primitive(_.listAccessPolicies(request))

        def listAssetModels(
          request: ListAssetModelsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListAssetModelsResponse] =
          primitive(_.listAssetModels(request))

        def listAssetRelationships(
          request: ListAssetRelationshipsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListAssetRelationshipsResponse] =
          primitive(_.listAssetRelationships(request))

        def listAssets(
          request: ListAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListAssetsResponse] =
          primitive(_.listAssets(request))

        def listAssociatedAssets(
          request: ListAssociatedAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListAssociatedAssetsResponse] =
          primitive(_.listAssociatedAssets(request))

        def listDashboards(
          request: ListDashboardsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListDashboardsResponse] =
          primitive(_.listDashboards(request))

        def listGateways(
          request: ListGatewaysRequest
        ): Kleisli[M, IoTSiteWiseClient, ListGatewaysResponse] =
          primitive(_.listGateways(request))

        def listPortals(
          request: ListPortalsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListPortalsResponse] =
          primitive(_.listPortals(request))

        def listProjectAssets(
          request: ListProjectAssetsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListProjectAssetsResponse] =
          primitive(_.listProjectAssets(request))

        def listProjects(
          request: ListProjectsRequest
        ): Kleisli[M, IoTSiteWiseClient, ListProjectsResponse] =
          primitive(_.listProjects(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IoTSiteWiseClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putDefaultEncryptionConfiguration(
          request: PutDefaultEncryptionConfigurationRequest
        ): Kleisli[M, IoTSiteWiseClient, PutDefaultEncryptionConfigurationResponse] =
          primitive(_.putDefaultEncryptionConfiguration(request))

        def putLoggingOptions(
          request: PutLoggingOptionsRequest
        ): Kleisli[M, IoTSiteWiseClient, PutLoggingOptionsResponse] =
          primitive(_.putLoggingOptions(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IoTSiteWiseClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IoTSiteWiseClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccessPolicy(
          request: UpdateAccessPolicyRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateAccessPolicyResponse] =
          primitive(_.updateAccessPolicy(request))

        def updateAsset(
          request: UpdateAssetRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateAssetResponse] =
          primitive(_.updateAsset(request))

        def updateAssetModel(
          request: UpdateAssetModelRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateAssetModelResponse] =
          primitive(_.updateAssetModel(request))

        def updateAssetProperty(
          request: UpdateAssetPropertyRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateAssetPropertyResponse] =
          primitive(_.updateAssetProperty(request))

        def updateDashboard(
          request: UpdateDashboardRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateDashboardResponse] =
          primitive(_.updateDashboard(request))

        def updateGateway(
          request: UpdateGatewayRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateGatewayResponse] =
          primitive(_.updateGateway(request))

        def updateGatewayCapabilityConfiguration(
          request: UpdateGatewayCapabilityConfigurationRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateGatewayCapabilityConfigurationResponse] =
          primitive(_.updateGatewayCapabilityConfiguration(request))

        def updatePortal(
          request: UpdatePortalRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdatePortalResponse] =
          primitive(_.updatePortal(request))

        def updateProject(
          request: UpdateProjectRequest
        ): Kleisli[M, IoTSiteWiseClient, UpdateProjectResponse] =
          primitive(_.updateProject(request))

        def primitive[A](
          f: IoTSiteWiseClient => A
        ): Kleisli[M, IoTSiteWiseClient, A]
      }
    }

    trait Visitor[F[_]] extends (IoTSiteWiseOp ~> F) {
      final def apply[A](op: IoTSiteWiseOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateAssets(
        request: AssociateAssetsRequest
      ): F[AssociateAssetsResponse]

      def batchAssociateProjectAssets(
        request: BatchAssociateProjectAssetsRequest
      ): F[BatchAssociateProjectAssetsResponse]

      def batchDisassociateProjectAssets(
        request: BatchDisassociateProjectAssetsRequest
      ): F[BatchDisassociateProjectAssetsResponse]

      def batchPutAssetPropertyValue(
        request: BatchPutAssetPropertyValueRequest
      ): F[BatchPutAssetPropertyValueResponse]

      def createAccessPolicy(
        request: CreateAccessPolicyRequest
      ): F[CreateAccessPolicyResponse]

      def createAsset(
        request: CreateAssetRequest
      ): F[CreateAssetResponse]

      def createAssetModel(
        request: CreateAssetModelRequest
      ): F[CreateAssetModelResponse]

      def createDashboard(
        request: CreateDashboardRequest
      ): F[CreateDashboardResponse]

      def createGateway(
        request: CreateGatewayRequest
      ): F[CreateGatewayResponse]

      def createPortal(
        request: CreatePortalRequest
      ): F[CreatePortalResponse]

      def createProject(
        request: CreateProjectRequest
      ): F[CreateProjectResponse]

      def deleteAccessPolicy(
        request: DeleteAccessPolicyRequest
      ): F[DeleteAccessPolicyResponse]

      def deleteAsset(
        request: DeleteAssetRequest
      ): F[DeleteAssetResponse]

      def deleteAssetModel(
        request: DeleteAssetModelRequest
      ): F[DeleteAssetModelResponse]

      def deleteDashboard(
        request: DeleteDashboardRequest
      ): F[DeleteDashboardResponse]

      def deleteGateway(
        request: DeleteGatewayRequest
      ): F[DeleteGatewayResponse]

      def deletePortal(
        request: DeletePortalRequest
      ): F[DeletePortalResponse]

      def deleteProject(
        request: DeleteProjectRequest
      ): F[DeleteProjectResponse]

      def describeAccessPolicy(
        request: DescribeAccessPolicyRequest
      ): F[DescribeAccessPolicyResponse]

      def describeAsset(
        request: DescribeAssetRequest
      ): F[DescribeAssetResponse]

      def describeAssetModel(
        request: DescribeAssetModelRequest
      ): F[DescribeAssetModelResponse]

      def describeAssetProperty(
        request: DescribeAssetPropertyRequest
      ): F[DescribeAssetPropertyResponse]

      def describeDashboard(
        request: DescribeDashboardRequest
      ): F[DescribeDashboardResponse]

      def describeDefaultEncryptionConfiguration(
        request: DescribeDefaultEncryptionConfigurationRequest
      ): F[DescribeDefaultEncryptionConfigurationResponse]

      def describeGateway(
        request: DescribeGatewayRequest
      ): F[DescribeGatewayResponse]

      def describeGatewayCapabilityConfiguration(
        request: DescribeGatewayCapabilityConfigurationRequest
      ): F[DescribeGatewayCapabilityConfigurationResponse]

      def describeLoggingOptions(
        request: DescribeLoggingOptionsRequest
      ): F[DescribeLoggingOptionsResponse]

      def describePortal(
        request: DescribePortalRequest
      ): F[DescribePortalResponse]

      def describeProject(
        request: DescribeProjectRequest
      ): F[DescribeProjectResponse]

      def disassociateAssets(
        request: DisassociateAssetsRequest
      ): F[DisassociateAssetsResponse]

      def getAssetPropertyAggregates(
        request: GetAssetPropertyAggregatesRequest
      ): F[GetAssetPropertyAggregatesResponse]

      def getAssetPropertyValue(
        request: GetAssetPropertyValueRequest
      ): F[GetAssetPropertyValueResponse]

      def getAssetPropertyValueHistory(
        request: GetAssetPropertyValueHistoryRequest
      ): F[GetAssetPropertyValueHistoryResponse]

      def getInterpolatedAssetPropertyValues(
        request: GetInterpolatedAssetPropertyValuesRequest
      ): F[GetInterpolatedAssetPropertyValuesResponse]

      def listAccessPolicies(
        request: ListAccessPoliciesRequest
      ): F[ListAccessPoliciesResponse]

      def listAssetModels(
        request: ListAssetModelsRequest
      ): F[ListAssetModelsResponse]

      def listAssetRelationships(
        request: ListAssetRelationshipsRequest
      ): F[ListAssetRelationshipsResponse]

      def listAssets(
        request: ListAssetsRequest
      ): F[ListAssetsResponse]

      def listAssociatedAssets(
        request: ListAssociatedAssetsRequest
      ): F[ListAssociatedAssetsResponse]

      def listDashboards(
        request: ListDashboardsRequest
      ): F[ListDashboardsResponse]

      def listGateways(
        request: ListGatewaysRequest
      ): F[ListGatewaysResponse]

      def listPortals(
        request: ListPortalsRequest
      ): F[ListPortalsResponse]

      def listProjectAssets(
        request: ListProjectAssetsRequest
      ): F[ListProjectAssetsResponse]

      def listProjects(
        request: ListProjectsRequest
      ): F[ListProjectsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putDefaultEncryptionConfiguration(
        request: PutDefaultEncryptionConfigurationRequest
      ): F[PutDefaultEncryptionConfigurationResponse]

      def putLoggingOptions(
        request: PutLoggingOptionsRequest
      ): F[PutLoggingOptionsResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccessPolicy(
        request: UpdateAccessPolicyRequest
      ): F[UpdateAccessPolicyResponse]

      def updateAsset(
        request: UpdateAssetRequest
      ): F[UpdateAssetResponse]

      def updateAssetModel(
        request: UpdateAssetModelRequest
      ): F[UpdateAssetModelResponse]

      def updateAssetProperty(
        request: UpdateAssetPropertyRequest
      ): F[UpdateAssetPropertyResponse]

      def updateDashboard(
        request: UpdateDashboardRequest
      ): F[UpdateDashboardResponse]

      def updateGateway(
        request: UpdateGatewayRequest
      ): F[UpdateGatewayResponse]

      def updateGatewayCapabilityConfiguration(
        request: UpdateGatewayCapabilityConfigurationRequest
      ): F[UpdateGatewayCapabilityConfigurationResponse]

      def updatePortal(
        request: UpdatePortalRequest
      ): F[UpdatePortalResponse]

      def updateProject(
        request: UpdateProjectRequest
      ): F[UpdateProjectResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IoTSiteWiseOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateAssetsOp(
      request: AssociateAssetsRequest
    ) extends IoTSiteWiseOp[AssociateAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateAssetsResponse] =
        visitor.associateAssets(request)
    }

    final case class BatchAssociateProjectAssetsOp(
      request: BatchAssociateProjectAssetsRequest
    ) extends IoTSiteWiseOp[BatchAssociateProjectAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateProjectAssetsResponse] =
        visitor.batchAssociateProjectAssets(request)
    }

    final case class BatchDisassociateProjectAssetsOp(
      request: BatchDisassociateProjectAssetsRequest
    ) extends IoTSiteWiseOp[BatchDisassociateProjectAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateProjectAssetsResponse] =
        visitor.batchDisassociateProjectAssets(request)
    }

    final case class BatchPutAssetPropertyValueOp(
      request: BatchPutAssetPropertyValueRequest
    ) extends IoTSiteWiseOp[BatchPutAssetPropertyValueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchPutAssetPropertyValueResponse] =
        visitor.batchPutAssetPropertyValue(request)
    }

    final case class CreateAccessPolicyOp(
      request: CreateAccessPolicyRequest
    ) extends IoTSiteWiseOp[CreateAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccessPolicyResponse] =
        visitor.createAccessPolicy(request)
    }

    final case class CreateAssetOp(
      request: CreateAssetRequest
    ) extends IoTSiteWiseOp[CreateAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssetResponse] =
        visitor.createAsset(request)
    }

    final case class CreateAssetModelOp(
      request: CreateAssetModelRequest
    ) extends IoTSiteWiseOp[CreateAssetModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAssetModelResponse] =
        visitor.createAssetModel(request)
    }

    final case class CreateDashboardOp(
      request: CreateDashboardRequest
    ) extends IoTSiteWiseOp[CreateDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDashboardResponse] =
        visitor.createDashboard(request)
    }

    final case class CreateGatewayOp(
      request: CreateGatewayRequest
    ) extends IoTSiteWiseOp[CreateGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGatewayResponse] =
        visitor.createGateway(request)
    }

    final case class CreatePortalOp(
      request: CreatePortalRequest
    ) extends IoTSiteWiseOp[CreatePortalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePortalResponse] =
        visitor.createPortal(request)
    }

    final case class CreateProjectOp(
      request: CreateProjectRequest
    ) extends IoTSiteWiseOp[CreateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProjectResponse] =
        visitor.createProject(request)
    }

    final case class DeleteAccessPolicyOp(
      request: DeleteAccessPolicyRequest
    ) extends IoTSiteWiseOp[DeleteAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccessPolicyResponse] =
        visitor.deleteAccessPolicy(request)
    }

    final case class DeleteAssetOp(
      request: DeleteAssetRequest
    ) extends IoTSiteWiseOp[DeleteAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssetResponse] =
        visitor.deleteAsset(request)
    }

    final case class DeleteAssetModelOp(
      request: DeleteAssetModelRequest
    ) extends IoTSiteWiseOp[DeleteAssetModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAssetModelResponse] =
        visitor.deleteAssetModel(request)
    }

    final case class DeleteDashboardOp(
      request: DeleteDashboardRequest
    ) extends IoTSiteWiseOp[DeleteDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDashboardResponse] =
        visitor.deleteDashboard(request)
    }

    final case class DeleteGatewayOp(
      request: DeleteGatewayRequest
    ) extends IoTSiteWiseOp[DeleteGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGatewayResponse] =
        visitor.deleteGateway(request)
    }

    final case class DeletePortalOp(
      request: DeletePortalRequest
    ) extends IoTSiteWiseOp[DeletePortalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePortalResponse] =
        visitor.deletePortal(request)
    }

    final case class DeleteProjectOp(
      request: DeleteProjectRequest
    ) extends IoTSiteWiseOp[DeleteProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProjectResponse] =
        visitor.deleteProject(request)
    }

    final case class DescribeAccessPolicyOp(
      request: DescribeAccessPolicyRequest
    ) extends IoTSiteWiseOp[DescribeAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAccessPolicyResponse] =
        visitor.describeAccessPolicy(request)
    }

    final case class DescribeAssetOp(
      request: DescribeAssetRequest
    ) extends IoTSiteWiseOp[DescribeAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssetResponse] =
        visitor.describeAsset(request)
    }

    final case class DescribeAssetModelOp(
      request: DescribeAssetModelRequest
    ) extends IoTSiteWiseOp[DescribeAssetModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssetModelResponse] =
        visitor.describeAssetModel(request)
    }

    final case class DescribeAssetPropertyOp(
      request: DescribeAssetPropertyRequest
    ) extends IoTSiteWiseOp[DescribeAssetPropertyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAssetPropertyResponse] =
        visitor.describeAssetProperty(request)
    }

    final case class DescribeDashboardOp(
      request: DescribeDashboardRequest
    ) extends IoTSiteWiseOp[DescribeDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDashboardResponse] =
        visitor.describeDashboard(request)
    }

    final case class DescribeDefaultEncryptionConfigurationOp(
      request: DescribeDefaultEncryptionConfigurationRequest
    ) extends IoTSiteWiseOp[DescribeDefaultEncryptionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeDefaultEncryptionConfigurationResponse] =
        visitor.describeDefaultEncryptionConfiguration(request)
    }

    final case class DescribeGatewayOp(
      request: DescribeGatewayRequest
    ) extends IoTSiteWiseOp[DescribeGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGatewayResponse] =
        visitor.describeGateway(request)
    }

    final case class DescribeGatewayCapabilityConfigurationOp(
      request: DescribeGatewayCapabilityConfigurationRequest
    ) extends IoTSiteWiseOp[DescribeGatewayCapabilityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGatewayCapabilityConfigurationResponse] =
        visitor.describeGatewayCapabilityConfiguration(request)
    }

    final case class DescribeLoggingOptionsOp(
      request: DescribeLoggingOptionsRequest
    ) extends IoTSiteWiseOp[DescribeLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeLoggingOptionsResponse] =
        visitor.describeLoggingOptions(request)
    }

    final case class DescribePortalOp(
      request: DescribePortalRequest
    ) extends IoTSiteWiseOp[DescribePortalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePortalResponse] =
        visitor.describePortal(request)
    }

    final case class DescribeProjectOp(
      request: DescribeProjectRequest
    ) extends IoTSiteWiseOp[DescribeProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProjectResponse] =
        visitor.describeProject(request)
    }

    final case class DisassociateAssetsOp(
      request: DisassociateAssetsRequest
    ) extends IoTSiteWiseOp[DisassociateAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateAssetsResponse] =
        visitor.disassociateAssets(request)
    }

    final case class GetAssetPropertyAggregatesOp(
      request: GetAssetPropertyAggregatesRequest
    ) extends IoTSiteWiseOp[GetAssetPropertyAggregatesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssetPropertyAggregatesResponse] =
        visitor.getAssetPropertyAggregates(request)
    }

    final case class GetAssetPropertyValueOp(
      request: GetAssetPropertyValueRequest
    ) extends IoTSiteWiseOp[GetAssetPropertyValueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssetPropertyValueResponse] =
        visitor.getAssetPropertyValue(request)
    }

    final case class GetAssetPropertyValueHistoryOp(
      request: GetAssetPropertyValueHistoryRequest
    ) extends IoTSiteWiseOp[GetAssetPropertyValueHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAssetPropertyValueHistoryResponse] =
        visitor.getAssetPropertyValueHistory(request)
    }

    final case class GetInterpolatedAssetPropertyValuesOp(
      request: GetInterpolatedAssetPropertyValuesRequest
    ) extends IoTSiteWiseOp[GetInterpolatedAssetPropertyValuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInterpolatedAssetPropertyValuesResponse] =
        visitor.getInterpolatedAssetPropertyValues(request)
    }

    final case class ListAccessPoliciesOp(
      request: ListAccessPoliciesRequest
    ) extends IoTSiteWiseOp[ListAccessPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccessPoliciesResponse] =
        visitor.listAccessPolicies(request)
    }

    final case class ListAssetModelsOp(
      request: ListAssetModelsRequest
    ) extends IoTSiteWiseOp[ListAssetModelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssetModelsResponse] =
        visitor.listAssetModels(request)
    }

    final case class ListAssetRelationshipsOp(
      request: ListAssetRelationshipsRequest
    ) extends IoTSiteWiseOp[ListAssetRelationshipsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssetRelationshipsResponse] =
        visitor.listAssetRelationships(request)
    }

    final case class ListAssetsOp(
      request: ListAssetsRequest
    ) extends IoTSiteWiseOp[ListAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssetsResponse] =
        visitor.listAssets(request)
    }

    final case class ListAssociatedAssetsOp(
      request: ListAssociatedAssetsRequest
    ) extends IoTSiteWiseOp[ListAssociatedAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAssociatedAssetsResponse] =
        visitor.listAssociatedAssets(request)
    }

    final case class ListDashboardsOp(
      request: ListDashboardsRequest
    ) extends IoTSiteWiseOp[ListDashboardsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDashboardsResponse] =
        visitor.listDashboards(request)
    }

    final case class ListGatewaysOp(
      request: ListGatewaysRequest
    ) extends IoTSiteWiseOp[ListGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGatewaysResponse] =
        visitor.listGateways(request)
    }

    final case class ListPortalsOp(
      request: ListPortalsRequest
    ) extends IoTSiteWiseOp[ListPortalsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPortalsResponse] =
        visitor.listPortals(request)
    }

    final case class ListProjectAssetsOp(
      request: ListProjectAssetsRequest
    ) extends IoTSiteWiseOp[ListProjectAssetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectAssetsResponse] =
        visitor.listProjectAssets(request)
    }

    final case class ListProjectsOp(
      request: ListProjectsRequest
    ) extends IoTSiteWiseOp[ListProjectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProjectsResponse] =
        visitor.listProjects(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IoTSiteWiseOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutDefaultEncryptionConfigurationOp(
      request: PutDefaultEncryptionConfigurationRequest
    ) extends IoTSiteWiseOp[PutDefaultEncryptionConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutDefaultEncryptionConfigurationResponse] =
        visitor.putDefaultEncryptionConfiguration(request)
    }

    final case class PutLoggingOptionsOp(
      request: PutLoggingOptionsRequest
    ) extends IoTSiteWiseOp[PutLoggingOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutLoggingOptionsResponse] =
        visitor.putLoggingOptions(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IoTSiteWiseOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IoTSiteWiseOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccessPolicyOp(
      request: UpdateAccessPolicyRequest
    ) extends IoTSiteWiseOp[UpdateAccessPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccessPolicyResponse] =
        visitor.updateAccessPolicy(request)
    }

    final case class UpdateAssetOp(
      request: UpdateAssetRequest
    ) extends IoTSiteWiseOp[UpdateAssetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssetResponse] =
        visitor.updateAsset(request)
    }

    final case class UpdateAssetModelOp(
      request: UpdateAssetModelRequest
    ) extends IoTSiteWiseOp[UpdateAssetModelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssetModelResponse] =
        visitor.updateAssetModel(request)
    }

    final case class UpdateAssetPropertyOp(
      request: UpdateAssetPropertyRequest
    ) extends IoTSiteWiseOp[UpdateAssetPropertyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAssetPropertyResponse] =
        visitor.updateAssetProperty(request)
    }

    final case class UpdateDashboardOp(
      request: UpdateDashboardRequest
    ) extends IoTSiteWiseOp[UpdateDashboardResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDashboardResponse] =
        visitor.updateDashboard(request)
    }

    final case class UpdateGatewayOp(
      request: UpdateGatewayRequest
    ) extends IoTSiteWiseOp[UpdateGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayResponse] =
        visitor.updateGateway(request)
    }

    final case class UpdateGatewayCapabilityConfigurationOp(
      request: UpdateGatewayCapabilityConfigurationRequest
    ) extends IoTSiteWiseOp[UpdateGatewayCapabilityConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayCapabilityConfigurationResponse] =
        visitor.updateGatewayCapabilityConfiguration(request)
    }

    final case class UpdatePortalOp(
      request: UpdatePortalRequest
    ) extends IoTSiteWiseOp[UpdatePortalResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePortalResponse] =
        visitor.updatePortal(request)
    }

    final case class UpdateProjectOp(
      request: UpdateProjectRequest
    ) extends IoTSiteWiseOp[UpdateProjectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProjectResponse] =
        visitor.updateProject(request)
    }
  }

  import IoTSiteWiseOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IoTSiteWiseOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateAssets(
    request: AssociateAssetsRequest
  ): IoTSiteWiseIO[AssociateAssetsResponse] =
    FF.liftF(AssociateAssetsOp(request))

  def batchAssociateProjectAssets(
    request: BatchAssociateProjectAssetsRequest
  ): IoTSiteWiseIO[BatchAssociateProjectAssetsResponse] =
    FF.liftF(BatchAssociateProjectAssetsOp(request))

  def batchDisassociateProjectAssets(
    request: BatchDisassociateProjectAssetsRequest
  ): IoTSiteWiseIO[BatchDisassociateProjectAssetsResponse] =
    FF.liftF(BatchDisassociateProjectAssetsOp(request))

  def batchPutAssetPropertyValue(
    request: BatchPutAssetPropertyValueRequest
  ): IoTSiteWiseIO[BatchPutAssetPropertyValueResponse] =
    FF.liftF(BatchPutAssetPropertyValueOp(request))

  def createAccessPolicy(
    request: CreateAccessPolicyRequest
  ): IoTSiteWiseIO[CreateAccessPolicyResponse] =
    FF.liftF(CreateAccessPolicyOp(request))

  def createAsset(
    request: CreateAssetRequest
  ): IoTSiteWiseIO[CreateAssetResponse] =
    FF.liftF(CreateAssetOp(request))

  def createAssetModel(
    request: CreateAssetModelRequest
  ): IoTSiteWiseIO[CreateAssetModelResponse] =
    FF.liftF(CreateAssetModelOp(request))

  def createDashboard(
    request: CreateDashboardRequest
  ): IoTSiteWiseIO[CreateDashboardResponse] =
    FF.liftF(CreateDashboardOp(request))

  def createGateway(
    request: CreateGatewayRequest
  ): IoTSiteWiseIO[CreateGatewayResponse] =
    FF.liftF(CreateGatewayOp(request))

  def createPortal(
    request: CreatePortalRequest
  ): IoTSiteWiseIO[CreatePortalResponse] =
    FF.liftF(CreatePortalOp(request))

  def createProject(
    request: CreateProjectRequest
  ): IoTSiteWiseIO[CreateProjectResponse] =
    FF.liftF(CreateProjectOp(request))

  def deleteAccessPolicy(
    request: DeleteAccessPolicyRequest
  ): IoTSiteWiseIO[DeleteAccessPolicyResponse] =
    FF.liftF(DeleteAccessPolicyOp(request))

  def deleteAsset(
    request: DeleteAssetRequest
  ): IoTSiteWiseIO[DeleteAssetResponse] =
    FF.liftF(DeleteAssetOp(request))

  def deleteAssetModel(
    request: DeleteAssetModelRequest
  ): IoTSiteWiseIO[DeleteAssetModelResponse] =
    FF.liftF(DeleteAssetModelOp(request))

  def deleteDashboard(
    request: DeleteDashboardRequest
  ): IoTSiteWiseIO[DeleteDashboardResponse] =
    FF.liftF(DeleteDashboardOp(request))

  def deleteGateway(
    request: DeleteGatewayRequest
  ): IoTSiteWiseIO[DeleteGatewayResponse] =
    FF.liftF(DeleteGatewayOp(request))

  def deletePortal(
    request: DeletePortalRequest
  ): IoTSiteWiseIO[DeletePortalResponse] =
    FF.liftF(DeletePortalOp(request))

  def deleteProject(
    request: DeleteProjectRequest
  ): IoTSiteWiseIO[DeleteProjectResponse] =
    FF.liftF(DeleteProjectOp(request))

  def describeAccessPolicy(
    request: DescribeAccessPolicyRequest
  ): IoTSiteWiseIO[DescribeAccessPolicyResponse] =
    FF.liftF(DescribeAccessPolicyOp(request))

  def describeAsset(
    request: DescribeAssetRequest
  ): IoTSiteWiseIO[DescribeAssetResponse] =
    FF.liftF(DescribeAssetOp(request))

  def describeAssetModel(
    request: DescribeAssetModelRequest
  ): IoTSiteWiseIO[DescribeAssetModelResponse] =
    FF.liftF(DescribeAssetModelOp(request))

  def describeAssetProperty(
    request: DescribeAssetPropertyRequest
  ): IoTSiteWiseIO[DescribeAssetPropertyResponse] =
    FF.liftF(DescribeAssetPropertyOp(request))

  def describeDashboard(
    request: DescribeDashboardRequest
  ): IoTSiteWiseIO[DescribeDashboardResponse] =
    FF.liftF(DescribeDashboardOp(request))

  def describeDefaultEncryptionConfiguration(
    request: DescribeDefaultEncryptionConfigurationRequest
  ): IoTSiteWiseIO[DescribeDefaultEncryptionConfigurationResponse] =
    FF.liftF(DescribeDefaultEncryptionConfigurationOp(request))

  def describeGateway(
    request: DescribeGatewayRequest
  ): IoTSiteWiseIO[DescribeGatewayResponse] =
    FF.liftF(DescribeGatewayOp(request))

  def describeGatewayCapabilityConfiguration(
    request: DescribeGatewayCapabilityConfigurationRequest
  ): IoTSiteWiseIO[DescribeGatewayCapabilityConfigurationResponse] =
    FF.liftF(DescribeGatewayCapabilityConfigurationOp(request))

  def describeLoggingOptions(
    request: DescribeLoggingOptionsRequest
  ): IoTSiteWiseIO[DescribeLoggingOptionsResponse] =
    FF.liftF(DescribeLoggingOptionsOp(request))

  def describePortal(
    request: DescribePortalRequest
  ): IoTSiteWiseIO[DescribePortalResponse] =
    FF.liftF(DescribePortalOp(request))

  def describeProject(
    request: DescribeProjectRequest
  ): IoTSiteWiseIO[DescribeProjectResponse] =
    FF.liftF(DescribeProjectOp(request))

  def disassociateAssets(
    request: DisassociateAssetsRequest
  ): IoTSiteWiseIO[DisassociateAssetsResponse] =
    FF.liftF(DisassociateAssetsOp(request))

  def getAssetPropertyAggregates(
    request: GetAssetPropertyAggregatesRequest
  ): IoTSiteWiseIO[GetAssetPropertyAggregatesResponse] =
    FF.liftF(GetAssetPropertyAggregatesOp(request))

  def getAssetPropertyValue(
    request: GetAssetPropertyValueRequest
  ): IoTSiteWiseIO[GetAssetPropertyValueResponse] =
    FF.liftF(GetAssetPropertyValueOp(request))

  def getAssetPropertyValueHistory(
    request: GetAssetPropertyValueHistoryRequest
  ): IoTSiteWiseIO[GetAssetPropertyValueHistoryResponse] =
    FF.liftF(GetAssetPropertyValueHistoryOp(request))

  def getInterpolatedAssetPropertyValues(
    request: GetInterpolatedAssetPropertyValuesRequest
  ): IoTSiteWiseIO[GetInterpolatedAssetPropertyValuesResponse] =
    FF.liftF(GetInterpolatedAssetPropertyValuesOp(request))

  def listAccessPolicies(
    request: ListAccessPoliciesRequest
  ): IoTSiteWiseIO[ListAccessPoliciesResponse] =
    FF.liftF(ListAccessPoliciesOp(request))

  def listAssetModels(
    request: ListAssetModelsRequest
  ): IoTSiteWiseIO[ListAssetModelsResponse] =
    FF.liftF(ListAssetModelsOp(request))

  def listAssetRelationships(
    request: ListAssetRelationshipsRequest
  ): IoTSiteWiseIO[ListAssetRelationshipsResponse] =
    FF.liftF(ListAssetRelationshipsOp(request))

  def listAssets(
    request: ListAssetsRequest
  ): IoTSiteWiseIO[ListAssetsResponse] =
    FF.liftF(ListAssetsOp(request))

  def listAssociatedAssets(
    request: ListAssociatedAssetsRequest
  ): IoTSiteWiseIO[ListAssociatedAssetsResponse] =
    FF.liftF(ListAssociatedAssetsOp(request))

  def listDashboards(
    request: ListDashboardsRequest
  ): IoTSiteWiseIO[ListDashboardsResponse] =
    FF.liftF(ListDashboardsOp(request))

  def listGateways(
    request: ListGatewaysRequest
  ): IoTSiteWiseIO[ListGatewaysResponse] =
    FF.liftF(ListGatewaysOp(request))

  def listPortals(
    request: ListPortalsRequest
  ): IoTSiteWiseIO[ListPortalsResponse] =
    FF.liftF(ListPortalsOp(request))

  def listProjectAssets(
    request: ListProjectAssetsRequest
  ): IoTSiteWiseIO[ListProjectAssetsResponse] =
    FF.liftF(ListProjectAssetsOp(request))

  def listProjects(
    request: ListProjectsRequest
  ): IoTSiteWiseIO[ListProjectsResponse] =
    FF.liftF(ListProjectsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IoTSiteWiseIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putDefaultEncryptionConfiguration(
    request: PutDefaultEncryptionConfigurationRequest
  ): IoTSiteWiseIO[PutDefaultEncryptionConfigurationResponse] =
    FF.liftF(PutDefaultEncryptionConfigurationOp(request))

  def putLoggingOptions(
    request: PutLoggingOptionsRequest
  ): IoTSiteWiseIO[PutLoggingOptionsResponse] =
    FF.liftF(PutLoggingOptionsOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IoTSiteWiseIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IoTSiteWiseIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccessPolicy(
    request: UpdateAccessPolicyRequest
  ): IoTSiteWiseIO[UpdateAccessPolicyResponse] =
    FF.liftF(UpdateAccessPolicyOp(request))

  def updateAsset(
    request: UpdateAssetRequest
  ): IoTSiteWiseIO[UpdateAssetResponse] =
    FF.liftF(UpdateAssetOp(request))

  def updateAssetModel(
    request: UpdateAssetModelRequest
  ): IoTSiteWiseIO[UpdateAssetModelResponse] =
    FF.liftF(UpdateAssetModelOp(request))

  def updateAssetProperty(
    request: UpdateAssetPropertyRequest
  ): IoTSiteWiseIO[UpdateAssetPropertyResponse] =
    FF.liftF(UpdateAssetPropertyOp(request))

  def updateDashboard(
    request: UpdateDashboardRequest
  ): IoTSiteWiseIO[UpdateDashboardResponse] =
    FF.liftF(UpdateDashboardOp(request))

  def updateGateway(
    request: UpdateGatewayRequest
  ): IoTSiteWiseIO[UpdateGatewayResponse] =
    FF.liftF(UpdateGatewayOp(request))

  def updateGatewayCapabilityConfiguration(
    request: UpdateGatewayCapabilityConfigurationRequest
  ): IoTSiteWiseIO[UpdateGatewayCapabilityConfigurationResponse] =
    FF.liftF(UpdateGatewayCapabilityConfigurationOp(request))

  def updatePortal(
    request: UpdatePortalRequest
  ): IoTSiteWiseIO[UpdatePortalResponse] =
    FF.liftF(UpdatePortalOp(request))

  def updateProject(
    request: UpdateProjectRequest
  ): IoTSiteWiseIO[UpdateProjectResponse] =
    FF.liftF(UpdateProjectOp(request))
}
