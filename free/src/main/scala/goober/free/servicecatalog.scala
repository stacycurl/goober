package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.servicecatalog.ServiceCatalogClient
import software.amazon.awssdk.services.servicecatalog.model._


object servicecatalog { module =>

  // Free monad over ServiceCatalogOp
  type ServiceCatalogIO[A] = FF[ServiceCatalogOp, A]

  sealed trait ServiceCatalogOp[A] {
    def visit[F[_]](visitor: ServiceCatalogOp.Visitor[F]): F[A]
  }

  object ServiceCatalogOp {
    // Given a ServiceCatalogClient we can embed a ServiceCatalogIO program in any algebra that understands embedding.
    implicit val ServiceCatalogOpEmbeddable: Embeddable[ServiceCatalogOp, ServiceCatalogClient] = new Embeddable[ServiceCatalogOp, ServiceCatalogClient] {
      def embed[A](client: ServiceCatalogClient, io: ServiceCatalogIO[A]): Embedded[A] = Embedded.ServiceCatalog(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ServiceCatalogOp.Visitor[Kleisli[M, ServiceCatalogClient, *]] {
        def acceptPortfolioShare(
          request: AcceptPortfolioShareRequest
        ): Kleisli[M, ServiceCatalogClient, AcceptPortfolioShareResponse] =
          primitive(_.acceptPortfolioShare(request))

        def associateBudgetWithResource(
          request: AssociateBudgetWithResourceRequest
        ): Kleisli[M, ServiceCatalogClient, AssociateBudgetWithResourceResponse] =
          primitive(_.associateBudgetWithResource(request))

        def associatePrincipalWithPortfolio(
          request: AssociatePrincipalWithPortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, AssociatePrincipalWithPortfolioResponse] =
          primitive(_.associatePrincipalWithPortfolio(request))

        def associateProductWithPortfolio(
          request: AssociateProductWithPortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, AssociateProductWithPortfolioResponse] =
          primitive(_.associateProductWithPortfolio(request))

        def associateServiceActionWithProvisioningArtifact(
          request: AssociateServiceActionWithProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, AssociateServiceActionWithProvisioningArtifactResponse] =
          primitive(_.associateServiceActionWithProvisioningArtifact(request))

        def associateTagOptionWithResource(
          request: AssociateTagOptionWithResourceRequest
        ): Kleisli[M, ServiceCatalogClient, AssociateTagOptionWithResourceResponse] =
          primitive(_.associateTagOptionWithResource(request))

        def batchAssociateServiceActionWithProvisioningArtifact(
          request: BatchAssociateServiceActionWithProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, BatchAssociateServiceActionWithProvisioningArtifactResponse] =
          primitive(_.batchAssociateServiceActionWithProvisioningArtifact(request))

        def batchDisassociateServiceActionFromProvisioningArtifact(
          request: BatchDisassociateServiceActionFromProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, BatchDisassociateServiceActionFromProvisioningArtifactResponse] =
          primitive(_.batchDisassociateServiceActionFromProvisioningArtifact(request))

        def copyProduct(
          request: CopyProductRequest
        ): Kleisli[M, ServiceCatalogClient, CopyProductResponse] =
          primitive(_.copyProduct(request))

        def createConstraint(
          request: CreateConstraintRequest
        ): Kleisli[M, ServiceCatalogClient, CreateConstraintResponse] =
          primitive(_.createConstraint(request))

        def createPortfolio(
          request: CreatePortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, CreatePortfolioResponse] =
          primitive(_.createPortfolio(request))

        def createPortfolioShare(
          request: CreatePortfolioShareRequest
        ): Kleisli[M, ServiceCatalogClient, CreatePortfolioShareResponse] =
          primitive(_.createPortfolioShare(request))

        def createProduct(
          request: CreateProductRequest
        ): Kleisli[M, ServiceCatalogClient, CreateProductResponse] =
          primitive(_.createProduct(request))

        def createProvisionedProductPlan(
          request: CreateProvisionedProductPlanRequest
        ): Kleisli[M, ServiceCatalogClient, CreateProvisionedProductPlanResponse] =
          primitive(_.createProvisionedProductPlan(request))

        def createProvisioningArtifact(
          request: CreateProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, CreateProvisioningArtifactResponse] =
          primitive(_.createProvisioningArtifact(request))

        def createServiceAction(
          request: CreateServiceActionRequest
        ): Kleisli[M, ServiceCatalogClient, CreateServiceActionResponse] =
          primitive(_.createServiceAction(request))

        def createTagOption(
          request: CreateTagOptionRequest
        ): Kleisli[M, ServiceCatalogClient, CreateTagOptionResponse] =
          primitive(_.createTagOption(request))

        def deleteConstraint(
          request: DeleteConstraintRequest
        ): Kleisli[M, ServiceCatalogClient, DeleteConstraintResponse] =
          primitive(_.deleteConstraint(request))

        def deletePortfolio(
          request: DeletePortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, DeletePortfolioResponse] =
          primitive(_.deletePortfolio(request))

        def deletePortfolioShare(
          request: DeletePortfolioShareRequest
        ): Kleisli[M, ServiceCatalogClient, DeletePortfolioShareResponse] =
          primitive(_.deletePortfolioShare(request))

        def deleteProduct(
          request: DeleteProductRequest
        ): Kleisli[M, ServiceCatalogClient, DeleteProductResponse] =
          primitive(_.deleteProduct(request))

        def deleteProvisionedProductPlan(
          request: DeleteProvisionedProductPlanRequest
        ): Kleisli[M, ServiceCatalogClient, DeleteProvisionedProductPlanResponse] =
          primitive(_.deleteProvisionedProductPlan(request))

        def deleteProvisioningArtifact(
          request: DeleteProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, DeleteProvisioningArtifactResponse] =
          primitive(_.deleteProvisioningArtifact(request))

        def deleteServiceAction(
          request: DeleteServiceActionRequest
        ): Kleisli[M, ServiceCatalogClient, DeleteServiceActionResponse] =
          primitive(_.deleteServiceAction(request))

        def deleteTagOption(
          request: DeleteTagOptionRequest
        ): Kleisli[M, ServiceCatalogClient, DeleteTagOptionResponse] =
          primitive(_.deleteTagOption(request))

        def describeConstraint(
          request: DescribeConstraintRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeConstraintResponse] =
          primitive(_.describeConstraint(request))

        def describeCopyProductStatus(
          request: DescribeCopyProductStatusRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeCopyProductStatusResponse] =
          primitive(_.describeCopyProductStatus(request))

        def describePortfolio(
          request: DescribePortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, DescribePortfolioResponse] =
          primitive(_.describePortfolio(request))

        def describePortfolioShareStatus(
          request: DescribePortfolioShareStatusRequest
        ): Kleisli[M, ServiceCatalogClient, DescribePortfolioShareStatusResponse] =
          primitive(_.describePortfolioShareStatus(request))

        def describePortfolioShares(
          request: DescribePortfolioSharesRequest
        ): Kleisli[M, ServiceCatalogClient, DescribePortfolioSharesResponse] =
          primitive(_.describePortfolioShares(request))

        def describeProduct(
          request: DescribeProductRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProductResponse] =
          primitive(_.describeProduct(request))

        def describeProductAsAdmin(
          request: DescribeProductAsAdminRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProductAsAdminResponse] =
          primitive(_.describeProductAsAdmin(request))

        def describeProductView(
          request: DescribeProductViewRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProductViewResponse] =
          primitive(_.describeProductView(request))

        def describeProvisionedProduct(
          request: DescribeProvisionedProductRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProvisionedProductResponse] =
          primitive(_.describeProvisionedProduct(request))

        def describeProvisionedProductPlan(
          request: DescribeProvisionedProductPlanRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProvisionedProductPlanResponse] =
          primitive(_.describeProvisionedProductPlan(request))

        def describeProvisioningArtifact(
          request: DescribeProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProvisioningArtifactResponse] =
          primitive(_.describeProvisioningArtifact(request))

        def describeProvisioningParameters(
          request: DescribeProvisioningParametersRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeProvisioningParametersResponse] =
          primitive(_.describeProvisioningParameters(request))

        def describeRecord(
          request: DescribeRecordRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeRecordResponse] =
          primitive(_.describeRecord(request))

        def describeServiceAction(
          request: DescribeServiceActionRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeServiceActionResponse] =
          primitive(_.describeServiceAction(request))

        def describeServiceActionExecutionParameters(
          request: DescribeServiceActionExecutionParametersRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeServiceActionExecutionParametersResponse] =
          primitive(_.describeServiceActionExecutionParameters(request))

        def describeTagOption(
          request: DescribeTagOptionRequest
        ): Kleisli[M, ServiceCatalogClient, DescribeTagOptionResponse] =
          primitive(_.describeTagOption(request))

        def disableAWSOrganizationsAccess(
          request: DisableAwsOrganizationsAccessRequest
        ): Kleisli[M, ServiceCatalogClient, DisableAwsOrganizationsAccessResponse] =
          primitive(_.disableAWSOrganizationsAccess(request))

        def disassociateBudgetFromResource(
          request: DisassociateBudgetFromResourceRequest
        ): Kleisli[M, ServiceCatalogClient, DisassociateBudgetFromResourceResponse] =
          primitive(_.disassociateBudgetFromResource(request))

        def disassociatePrincipalFromPortfolio(
          request: DisassociatePrincipalFromPortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, DisassociatePrincipalFromPortfolioResponse] =
          primitive(_.disassociatePrincipalFromPortfolio(request))

        def disassociateProductFromPortfolio(
          request: DisassociateProductFromPortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, DisassociateProductFromPortfolioResponse] =
          primitive(_.disassociateProductFromPortfolio(request))

        def disassociateServiceActionFromProvisioningArtifact(
          request: DisassociateServiceActionFromProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, DisassociateServiceActionFromProvisioningArtifactResponse] =
          primitive(_.disassociateServiceActionFromProvisioningArtifact(request))

        def disassociateTagOptionFromResource(
          request: DisassociateTagOptionFromResourceRequest
        ): Kleisli[M, ServiceCatalogClient, DisassociateTagOptionFromResourceResponse] =
          primitive(_.disassociateTagOptionFromResource(request))

        def enableAWSOrganizationsAccess(
          request: EnableAwsOrganizationsAccessRequest
        ): Kleisli[M, ServiceCatalogClient, EnableAwsOrganizationsAccessResponse] =
          primitive(_.enableAWSOrganizationsAccess(request))

        def executeProvisionedProductPlan(
          request: ExecuteProvisionedProductPlanRequest
        ): Kleisli[M, ServiceCatalogClient, ExecuteProvisionedProductPlanResponse] =
          primitive(_.executeProvisionedProductPlan(request))

        def executeProvisionedProductServiceAction(
          request: ExecuteProvisionedProductServiceActionRequest
        ): Kleisli[M, ServiceCatalogClient, ExecuteProvisionedProductServiceActionResponse] =
          primitive(_.executeProvisionedProductServiceAction(request))

        def getAWSOrganizationsAccessStatus(
          request: GetAwsOrganizationsAccessStatusRequest
        ): Kleisli[M, ServiceCatalogClient, GetAwsOrganizationsAccessStatusResponse] =
          primitive(_.getAWSOrganizationsAccessStatus(request))

        def getProvisionedProductOutputs(
          request: GetProvisionedProductOutputsRequest
        ): Kleisli[M, ServiceCatalogClient, GetProvisionedProductOutputsResponse] =
          primitive(_.getProvisionedProductOutputs(request))

        def importAsProvisionedProduct(
          request: ImportAsProvisionedProductRequest
        ): Kleisli[M, ServiceCatalogClient, ImportAsProvisionedProductResponse] =
          primitive(_.importAsProvisionedProduct(request))

        def listAcceptedPortfolioShares(
          request: ListAcceptedPortfolioSharesRequest
        ): Kleisli[M, ServiceCatalogClient, ListAcceptedPortfolioSharesResponse] =
          primitive(_.listAcceptedPortfolioShares(request))

        def listBudgetsForResource(
          request: ListBudgetsForResourceRequest
        ): Kleisli[M, ServiceCatalogClient, ListBudgetsForResourceResponse] =
          primitive(_.listBudgetsForResource(request))

        def listConstraintsForPortfolio(
          request: ListConstraintsForPortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, ListConstraintsForPortfolioResponse] =
          primitive(_.listConstraintsForPortfolio(request))

        def listLaunchPaths(
          request: ListLaunchPathsRequest
        ): Kleisli[M, ServiceCatalogClient, ListLaunchPathsResponse] =
          primitive(_.listLaunchPaths(request))

        def listOrganizationPortfolioAccess(
          request: ListOrganizationPortfolioAccessRequest
        ): Kleisli[M, ServiceCatalogClient, ListOrganizationPortfolioAccessResponse] =
          primitive(_.listOrganizationPortfolioAccess(request))

        def listPortfolioAccess(
          request: ListPortfolioAccessRequest
        ): Kleisli[M, ServiceCatalogClient, ListPortfolioAccessResponse] =
          primitive(_.listPortfolioAccess(request))

        def listPortfolios(
          request: ListPortfoliosRequest
        ): Kleisli[M, ServiceCatalogClient, ListPortfoliosResponse] =
          primitive(_.listPortfolios(request))

        def listPortfoliosForProduct(
          request: ListPortfoliosForProductRequest
        ): Kleisli[M, ServiceCatalogClient, ListPortfoliosForProductResponse] =
          primitive(_.listPortfoliosForProduct(request))

        def listPrincipalsForPortfolio(
          request: ListPrincipalsForPortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, ListPrincipalsForPortfolioResponse] =
          primitive(_.listPrincipalsForPortfolio(request))

        def listProvisionedProductPlans(
          request: ListProvisionedProductPlansRequest
        ): Kleisli[M, ServiceCatalogClient, ListProvisionedProductPlansResponse] =
          primitive(_.listProvisionedProductPlans(request))

        def listProvisioningArtifacts(
          request: ListProvisioningArtifactsRequest
        ): Kleisli[M, ServiceCatalogClient, ListProvisioningArtifactsResponse] =
          primitive(_.listProvisioningArtifacts(request))

        def listProvisioningArtifactsForServiceAction(
          request: ListProvisioningArtifactsForServiceActionRequest
        ): Kleisli[M, ServiceCatalogClient, ListProvisioningArtifactsForServiceActionResponse] =
          primitive(_.listProvisioningArtifactsForServiceAction(request))

        def listRecordHistory(
          request: ListRecordHistoryRequest
        ): Kleisli[M, ServiceCatalogClient, ListRecordHistoryResponse] =
          primitive(_.listRecordHistory(request))

        def listResourcesForTagOption(
          request: ListResourcesForTagOptionRequest
        ): Kleisli[M, ServiceCatalogClient, ListResourcesForTagOptionResponse] =
          primitive(_.listResourcesForTagOption(request))

        def listServiceActions(
          request: ListServiceActionsRequest
        ): Kleisli[M, ServiceCatalogClient, ListServiceActionsResponse] =
          primitive(_.listServiceActions(request))

        def listServiceActionsForProvisioningArtifact(
          request: ListServiceActionsForProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, ListServiceActionsForProvisioningArtifactResponse] =
          primitive(_.listServiceActionsForProvisioningArtifact(request))

        def listStackInstancesForProvisionedProduct(
          request: ListStackInstancesForProvisionedProductRequest
        ): Kleisli[M, ServiceCatalogClient, ListStackInstancesForProvisionedProductResponse] =
          primitive(_.listStackInstancesForProvisionedProduct(request))

        def listTagOptions(
          request: ListTagOptionsRequest
        ): Kleisli[M, ServiceCatalogClient, ListTagOptionsResponse] =
          primitive(_.listTagOptions(request))

        def provisionProduct(
          request: ProvisionProductRequest
        ): Kleisli[M, ServiceCatalogClient, ProvisionProductResponse] =
          primitive(_.provisionProduct(request))

        def rejectPortfolioShare(
          request: RejectPortfolioShareRequest
        ): Kleisli[M, ServiceCatalogClient, RejectPortfolioShareResponse] =
          primitive(_.rejectPortfolioShare(request))

        def scanProvisionedProducts(
          request: ScanProvisionedProductsRequest
        ): Kleisli[M, ServiceCatalogClient, ScanProvisionedProductsResponse] =
          primitive(_.scanProvisionedProducts(request))

        def searchProducts(
          request: SearchProductsRequest
        ): Kleisli[M, ServiceCatalogClient, SearchProductsResponse] =
          primitive(_.searchProducts(request))

        def searchProductsAsAdmin(
          request: SearchProductsAsAdminRequest
        ): Kleisli[M, ServiceCatalogClient, SearchProductsAsAdminResponse] =
          primitive(_.searchProductsAsAdmin(request))

        def searchProvisionedProducts(
          request: SearchProvisionedProductsRequest
        ): Kleisli[M, ServiceCatalogClient, SearchProvisionedProductsResponse] =
          primitive(_.searchProvisionedProducts(request))

        def terminateProvisionedProduct(
          request: TerminateProvisionedProductRequest
        ): Kleisli[M, ServiceCatalogClient, TerminateProvisionedProductResponse] =
          primitive(_.terminateProvisionedProduct(request))

        def updateConstraint(
          request: UpdateConstraintRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateConstraintResponse] =
          primitive(_.updateConstraint(request))

        def updatePortfolio(
          request: UpdatePortfolioRequest
        ): Kleisli[M, ServiceCatalogClient, UpdatePortfolioResponse] =
          primitive(_.updatePortfolio(request))

        def updatePortfolioShare(
          request: UpdatePortfolioShareRequest
        ): Kleisli[M, ServiceCatalogClient, UpdatePortfolioShareResponse] =
          primitive(_.updatePortfolioShare(request))

        def updateProduct(
          request: UpdateProductRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateProductResponse] =
          primitive(_.updateProduct(request))

        def updateProvisionedProduct(
          request: UpdateProvisionedProductRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateProvisionedProductResponse] =
          primitive(_.updateProvisionedProduct(request))

        def updateProvisionedProductProperties(
          request: UpdateProvisionedProductPropertiesRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateProvisionedProductPropertiesResponse] =
          primitive(_.updateProvisionedProductProperties(request))

        def updateProvisioningArtifact(
          request: UpdateProvisioningArtifactRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateProvisioningArtifactResponse] =
          primitive(_.updateProvisioningArtifact(request))

        def updateServiceAction(
          request: UpdateServiceActionRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateServiceActionResponse] =
          primitive(_.updateServiceAction(request))

        def updateTagOption(
          request: UpdateTagOptionRequest
        ): Kleisli[M, ServiceCatalogClient, UpdateTagOptionResponse] =
          primitive(_.updateTagOption(request))

        def primitive[A](
          f: ServiceCatalogClient => A
        ): Kleisli[M, ServiceCatalogClient, A]
      }
    }

    trait Visitor[F[_]] extends (ServiceCatalogOp ~> F) {
      final def apply[A](op: ServiceCatalogOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptPortfolioShare(
        request: AcceptPortfolioShareRequest
      ): F[AcceptPortfolioShareResponse]

      def associateBudgetWithResource(
        request: AssociateBudgetWithResourceRequest
      ): F[AssociateBudgetWithResourceResponse]

      def associatePrincipalWithPortfolio(
        request: AssociatePrincipalWithPortfolioRequest
      ): F[AssociatePrincipalWithPortfolioResponse]

      def associateProductWithPortfolio(
        request: AssociateProductWithPortfolioRequest
      ): F[AssociateProductWithPortfolioResponse]

      def associateServiceActionWithProvisioningArtifact(
        request: AssociateServiceActionWithProvisioningArtifactRequest
      ): F[AssociateServiceActionWithProvisioningArtifactResponse]

      def associateTagOptionWithResource(
        request: AssociateTagOptionWithResourceRequest
      ): F[AssociateTagOptionWithResourceResponse]

      def batchAssociateServiceActionWithProvisioningArtifact(
        request: BatchAssociateServiceActionWithProvisioningArtifactRequest
      ): F[BatchAssociateServiceActionWithProvisioningArtifactResponse]

      def batchDisassociateServiceActionFromProvisioningArtifact(
        request: BatchDisassociateServiceActionFromProvisioningArtifactRequest
      ): F[BatchDisassociateServiceActionFromProvisioningArtifactResponse]

      def copyProduct(
        request: CopyProductRequest
      ): F[CopyProductResponse]

      def createConstraint(
        request: CreateConstraintRequest
      ): F[CreateConstraintResponse]

      def createPortfolio(
        request: CreatePortfolioRequest
      ): F[CreatePortfolioResponse]

      def createPortfolioShare(
        request: CreatePortfolioShareRequest
      ): F[CreatePortfolioShareResponse]

      def createProduct(
        request: CreateProductRequest
      ): F[CreateProductResponse]

      def createProvisionedProductPlan(
        request: CreateProvisionedProductPlanRequest
      ): F[CreateProvisionedProductPlanResponse]

      def createProvisioningArtifact(
        request: CreateProvisioningArtifactRequest
      ): F[CreateProvisioningArtifactResponse]

      def createServiceAction(
        request: CreateServiceActionRequest
      ): F[CreateServiceActionResponse]

      def createTagOption(
        request: CreateTagOptionRequest
      ): F[CreateTagOptionResponse]

      def deleteConstraint(
        request: DeleteConstraintRequest
      ): F[DeleteConstraintResponse]

      def deletePortfolio(
        request: DeletePortfolioRequest
      ): F[DeletePortfolioResponse]

      def deletePortfolioShare(
        request: DeletePortfolioShareRequest
      ): F[DeletePortfolioShareResponse]

      def deleteProduct(
        request: DeleteProductRequest
      ): F[DeleteProductResponse]

      def deleteProvisionedProductPlan(
        request: DeleteProvisionedProductPlanRequest
      ): F[DeleteProvisionedProductPlanResponse]

      def deleteProvisioningArtifact(
        request: DeleteProvisioningArtifactRequest
      ): F[DeleteProvisioningArtifactResponse]

      def deleteServiceAction(
        request: DeleteServiceActionRequest
      ): F[DeleteServiceActionResponse]

      def deleteTagOption(
        request: DeleteTagOptionRequest
      ): F[DeleteTagOptionResponse]

      def describeConstraint(
        request: DescribeConstraintRequest
      ): F[DescribeConstraintResponse]

      def describeCopyProductStatus(
        request: DescribeCopyProductStatusRequest
      ): F[DescribeCopyProductStatusResponse]

      def describePortfolio(
        request: DescribePortfolioRequest
      ): F[DescribePortfolioResponse]

      def describePortfolioShareStatus(
        request: DescribePortfolioShareStatusRequest
      ): F[DescribePortfolioShareStatusResponse]

      def describePortfolioShares(
        request: DescribePortfolioSharesRequest
      ): F[DescribePortfolioSharesResponse]

      def describeProduct(
        request: DescribeProductRequest
      ): F[DescribeProductResponse]

      def describeProductAsAdmin(
        request: DescribeProductAsAdminRequest
      ): F[DescribeProductAsAdminResponse]

      def describeProductView(
        request: DescribeProductViewRequest
      ): F[DescribeProductViewResponse]

      def describeProvisionedProduct(
        request: DescribeProvisionedProductRequest
      ): F[DescribeProvisionedProductResponse]

      def describeProvisionedProductPlan(
        request: DescribeProvisionedProductPlanRequest
      ): F[DescribeProvisionedProductPlanResponse]

      def describeProvisioningArtifact(
        request: DescribeProvisioningArtifactRequest
      ): F[DescribeProvisioningArtifactResponse]

      def describeProvisioningParameters(
        request: DescribeProvisioningParametersRequest
      ): F[DescribeProvisioningParametersResponse]

      def describeRecord(
        request: DescribeRecordRequest
      ): F[DescribeRecordResponse]

      def describeServiceAction(
        request: DescribeServiceActionRequest
      ): F[DescribeServiceActionResponse]

      def describeServiceActionExecutionParameters(
        request: DescribeServiceActionExecutionParametersRequest
      ): F[DescribeServiceActionExecutionParametersResponse]

      def describeTagOption(
        request: DescribeTagOptionRequest
      ): F[DescribeTagOptionResponse]

      def disableAWSOrganizationsAccess(
        request: DisableAwsOrganizationsAccessRequest
      ): F[DisableAwsOrganizationsAccessResponse]

      def disassociateBudgetFromResource(
        request: DisassociateBudgetFromResourceRequest
      ): F[DisassociateBudgetFromResourceResponse]

      def disassociatePrincipalFromPortfolio(
        request: DisassociatePrincipalFromPortfolioRequest
      ): F[DisassociatePrincipalFromPortfolioResponse]

      def disassociateProductFromPortfolio(
        request: DisassociateProductFromPortfolioRequest
      ): F[DisassociateProductFromPortfolioResponse]

      def disassociateServiceActionFromProvisioningArtifact(
        request: DisassociateServiceActionFromProvisioningArtifactRequest
      ): F[DisassociateServiceActionFromProvisioningArtifactResponse]

      def disassociateTagOptionFromResource(
        request: DisassociateTagOptionFromResourceRequest
      ): F[DisassociateTagOptionFromResourceResponse]

      def enableAWSOrganizationsAccess(
        request: EnableAwsOrganizationsAccessRequest
      ): F[EnableAwsOrganizationsAccessResponse]

      def executeProvisionedProductPlan(
        request: ExecuteProvisionedProductPlanRequest
      ): F[ExecuteProvisionedProductPlanResponse]

      def executeProvisionedProductServiceAction(
        request: ExecuteProvisionedProductServiceActionRequest
      ): F[ExecuteProvisionedProductServiceActionResponse]

      def getAWSOrganizationsAccessStatus(
        request: GetAwsOrganizationsAccessStatusRequest
      ): F[GetAwsOrganizationsAccessStatusResponse]

      def getProvisionedProductOutputs(
        request: GetProvisionedProductOutputsRequest
      ): F[GetProvisionedProductOutputsResponse]

      def importAsProvisionedProduct(
        request: ImportAsProvisionedProductRequest
      ): F[ImportAsProvisionedProductResponse]

      def listAcceptedPortfolioShares(
        request: ListAcceptedPortfolioSharesRequest
      ): F[ListAcceptedPortfolioSharesResponse]

      def listBudgetsForResource(
        request: ListBudgetsForResourceRequest
      ): F[ListBudgetsForResourceResponse]

      def listConstraintsForPortfolio(
        request: ListConstraintsForPortfolioRequest
      ): F[ListConstraintsForPortfolioResponse]

      def listLaunchPaths(
        request: ListLaunchPathsRequest
      ): F[ListLaunchPathsResponse]

      def listOrganizationPortfolioAccess(
        request: ListOrganizationPortfolioAccessRequest
      ): F[ListOrganizationPortfolioAccessResponse]

      def listPortfolioAccess(
        request: ListPortfolioAccessRequest
      ): F[ListPortfolioAccessResponse]

      def listPortfolios(
        request: ListPortfoliosRequest
      ): F[ListPortfoliosResponse]

      def listPortfoliosForProduct(
        request: ListPortfoliosForProductRequest
      ): F[ListPortfoliosForProductResponse]

      def listPrincipalsForPortfolio(
        request: ListPrincipalsForPortfolioRequest
      ): F[ListPrincipalsForPortfolioResponse]

      def listProvisionedProductPlans(
        request: ListProvisionedProductPlansRequest
      ): F[ListProvisionedProductPlansResponse]

      def listProvisioningArtifacts(
        request: ListProvisioningArtifactsRequest
      ): F[ListProvisioningArtifactsResponse]

      def listProvisioningArtifactsForServiceAction(
        request: ListProvisioningArtifactsForServiceActionRequest
      ): F[ListProvisioningArtifactsForServiceActionResponse]

      def listRecordHistory(
        request: ListRecordHistoryRequest
      ): F[ListRecordHistoryResponse]

      def listResourcesForTagOption(
        request: ListResourcesForTagOptionRequest
      ): F[ListResourcesForTagOptionResponse]

      def listServiceActions(
        request: ListServiceActionsRequest
      ): F[ListServiceActionsResponse]

      def listServiceActionsForProvisioningArtifact(
        request: ListServiceActionsForProvisioningArtifactRequest
      ): F[ListServiceActionsForProvisioningArtifactResponse]

      def listStackInstancesForProvisionedProduct(
        request: ListStackInstancesForProvisionedProductRequest
      ): F[ListStackInstancesForProvisionedProductResponse]

      def listTagOptions(
        request: ListTagOptionsRequest
      ): F[ListTagOptionsResponse]

      def provisionProduct(
        request: ProvisionProductRequest
      ): F[ProvisionProductResponse]

      def rejectPortfolioShare(
        request: RejectPortfolioShareRequest
      ): F[RejectPortfolioShareResponse]

      def scanProvisionedProducts(
        request: ScanProvisionedProductsRequest
      ): F[ScanProvisionedProductsResponse]

      def searchProducts(
        request: SearchProductsRequest
      ): F[SearchProductsResponse]

      def searchProductsAsAdmin(
        request: SearchProductsAsAdminRequest
      ): F[SearchProductsAsAdminResponse]

      def searchProvisionedProducts(
        request: SearchProvisionedProductsRequest
      ): F[SearchProvisionedProductsResponse]

      def terminateProvisionedProduct(
        request: TerminateProvisionedProductRequest
      ): F[TerminateProvisionedProductResponse]

      def updateConstraint(
        request: UpdateConstraintRequest
      ): F[UpdateConstraintResponse]

      def updatePortfolio(
        request: UpdatePortfolioRequest
      ): F[UpdatePortfolioResponse]

      def updatePortfolioShare(
        request: UpdatePortfolioShareRequest
      ): F[UpdatePortfolioShareResponse]

      def updateProduct(
        request: UpdateProductRequest
      ): F[UpdateProductResponse]

      def updateProvisionedProduct(
        request: UpdateProvisionedProductRequest
      ): F[UpdateProvisionedProductResponse]

      def updateProvisionedProductProperties(
        request: UpdateProvisionedProductPropertiesRequest
      ): F[UpdateProvisionedProductPropertiesResponse]

      def updateProvisioningArtifact(
        request: UpdateProvisioningArtifactRequest
      ): F[UpdateProvisioningArtifactResponse]

      def updateServiceAction(
        request: UpdateServiceActionRequest
      ): F[UpdateServiceActionResponse]

      def updateTagOption(
        request: UpdateTagOptionRequest
      ): F[UpdateTagOptionResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ServiceCatalogOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptPortfolioShareOp(
      request: AcceptPortfolioShareRequest
    ) extends ServiceCatalogOp[AcceptPortfolioShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptPortfolioShareResponse] =
        visitor.acceptPortfolioShare(request)
    }

    final case class AssociateBudgetWithResourceOp(
      request: AssociateBudgetWithResourceRequest
    ) extends ServiceCatalogOp[AssociateBudgetWithResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateBudgetWithResourceResponse] =
        visitor.associateBudgetWithResource(request)
    }

    final case class AssociatePrincipalWithPortfolioOp(
      request: AssociatePrincipalWithPortfolioRequest
    ) extends ServiceCatalogOp[AssociatePrincipalWithPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociatePrincipalWithPortfolioResponse] =
        visitor.associatePrincipalWithPortfolio(request)
    }

    final case class AssociateProductWithPortfolioOp(
      request: AssociateProductWithPortfolioRequest
    ) extends ServiceCatalogOp[AssociateProductWithPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateProductWithPortfolioResponse] =
        visitor.associateProductWithPortfolio(request)
    }

    final case class AssociateServiceActionWithProvisioningArtifactOp(
      request: AssociateServiceActionWithProvisioningArtifactRequest
    ) extends ServiceCatalogOp[AssociateServiceActionWithProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateServiceActionWithProvisioningArtifactResponse] =
        visitor.associateServiceActionWithProvisioningArtifact(request)
    }

    final case class AssociateTagOptionWithResourceOp(
      request: AssociateTagOptionWithResourceRequest
    ) extends ServiceCatalogOp[AssociateTagOptionWithResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateTagOptionWithResourceResponse] =
        visitor.associateTagOptionWithResource(request)
    }

    final case class BatchAssociateServiceActionWithProvisioningArtifactOp(
      request: BatchAssociateServiceActionWithProvisioningArtifactRequest
    ) extends ServiceCatalogOp[BatchAssociateServiceActionWithProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchAssociateServiceActionWithProvisioningArtifactResponse] =
        visitor.batchAssociateServiceActionWithProvisioningArtifact(request)
    }

    final case class BatchDisassociateServiceActionFromProvisioningArtifactOp(
      request: BatchDisassociateServiceActionFromProvisioningArtifactRequest
    ) extends ServiceCatalogOp[BatchDisassociateServiceActionFromProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDisassociateServiceActionFromProvisioningArtifactResponse] =
        visitor.batchDisassociateServiceActionFromProvisioningArtifact(request)
    }

    final case class CopyProductOp(
      request: CopyProductRequest
    ) extends ServiceCatalogOp[CopyProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CopyProductResponse] =
        visitor.copyProduct(request)
    }

    final case class CreateConstraintOp(
      request: CreateConstraintRequest
    ) extends ServiceCatalogOp[CreateConstraintResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConstraintResponse] =
        visitor.createConstraint(request)
    }

    final case class CreatePortfolioOp(
      request: CreatePortfolioRequest
    ) extends ServiceCatalogOp[CreatePortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePortfolioResponse] =
        visitor.createPortfolio(request)
    }

    final case class CreatePortfolioShareOp(
      request: CreatePortfolioShareRequest
    ) extends ServiceCatalogOp[CreatePortfolioShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePortfolioShareResponse] =
        visitor.createPortfolioShare(request)
    }

    final case class CreateProductOp(
      request: CreateProductRequest
    ) extends ServiceCatalogOp[CreateProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProductResponse] =
        visitor.createProduct(request)
    }

    final case class CreateProvisionedProductPlanOp(
      request: CreateProvisionedProductPlanRequest
    ) extends ServiceCatalogOp[CreateProvisionedProductPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProvisionedProductPlanResponse] =
        visitor.createProvisionedProductPlan(request)
    }

    final case class CreateProvisioningArtifactOp(
      request: CreateProvisioningArtifactRequest
    ) extends ServiceCatalogOp[CreateProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProvisioningArtifactResponse] =
        visitor.createProvisioningArtifact(request)
    }

    final case class CreateServiceActionOp(
      request: CreateServiceActionRequest
    ) extends ServiceCatalogOp[CreateServiceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceActionResponse] =
        visitor.createServiceAction(request)
    }

    final case class CreateTagOptionOp(
      request: CreateTagOptionRequest
    ) extends ServiceCatalogOp[CreateTagOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateTagOptionResponse] =
        visitor.createTagOption(request)
    }

    final case class DeleteConstraintOp(
      request: DeleteConstraintRequest
    ) extends ServiceCatalogOp[DeleteConstraintResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConstraintResponse] =
        visitor.deleteConstraint(request)
    }

    final case class DeletePortfolioOp(
      request: DeletePortfolioRequest
    ) extends ServiceCatalogOp[DeletePortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePortfolioResponse] =
        visitor.deletePortfolio(request)
    }

    final case class DeletePortfolioShareOp(
      request: DeletePortfolioShareRequest
    ) extends ServiceCatalogOp[DeletePortfolioShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePortfolioShareResponse] =
        visitor.deletePortfolioShare(request)
    }

    final case class DeleteProductOp(
      request: DeleteProductRequest
    ) extends ServiceCatalogOp[DeleteProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProductResponse] =
        visitor.deleteProduct(request)
    }

    final case class DeleteProvisionedProductPlanOp(
      request: DeleteProvisionedProductPlanRequest
    ) extends ServiceCatalogOp[DeleteProvisionedProductPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProvisionedProductPlanResponse] =
        visitor.deleteProvisionedProductPlan(request)
    }

    final case class DeleteProvisioningArtifactOp(
      request: DeleteProvisioningArtifactRequest
    ) extends ServiceCatalogOp[DeleteProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProvisioningArtifactResponse] =
        visitor.deleteProvisioningArtifact(request)
    }

    final case class DeleteServiceActionOp(
      request: DeleteServiceActionRequest
    ) extends ServiceCatalogOp[DeleteServiceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceActionResponse] =
        visitor.deleteServiceAction(request)
    }

    final case class DeleteTagOptionOp(
      request: DeleteTagOptionRequest
    ) extends ServiceCatalogOp[DeleteTagOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteTagOptionResponse] =
        visitor.deleteTagOption(request)
    }

    final case class DescribeConstraintOp(
      request: DescribeConstraintRequest
    ) extends ServiceCatalogOp[DescribeConstraintResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeConstraintResponse] =
        visitor.describeConstraint(request)
    }

    final case class DescribeCopyProductStatusOp(
      request: DescribeCopyProductStatusRequest
    ) extends ServiceCatalogOp[DescribeCopyProductStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeCopyProductStatusResponse] =
        visitor.describeCopyProductStatus(request)
    }

    final case class DescribePortfolioOp(
      request: DescribePortfolioRequest
    ) extends ServiceCatalogOp[DescribePortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePortfolioResponse] =
        visitor.describePortfolio(request)
    }

    final case class DescribePortfolioShareStatusOp(
      request: DescribePortfolioShareStatusRequest
    ) extends ServiceCatalogOp[DescribePortfolioShareStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePortfolioShareStatusResponse] =
        visitor.describePortfolioShareStatus(request)
    }

    final case class DescribePortfolioSharesOp(
      request: DescribePortfolioSharesRequest
    ) extends ServiceCatalogOp[DescribePortfolioSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePortfolioSharesResponse] =
        visitor.describePortfolioShares(request)
    }

    final case class DescribeProductOp(
      request: DescribeProductRequest
    ) extends ServiceCatalogOp[DescribeProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProductResponse] =
        visitor.describeProduct(request)
    }

    final case class DescribeProductAsAdminOp(
      request: DescribeProductAsAdminRequest
    ) extends ServiceCatalogOp[DescribeProductAsAdminResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProductAsAdminResponse] =
        visitor.describeProductAsAdmin(request)
    }

    final case class DescribeProductViewOp(
      request: DescribeProductViewRequest
    ) extends ServiceCatalogOp[DescribeProductViewResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProductViewResponse] =
        visitor.describeProductView(request)
    }

    final case class DescribeProvisionedProductOp(
      request: DescribeProvisionedProductRequest
    ) extends ServiceCatalogOp[DescribeProvisionedProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProvisionedProductResponse] =
        visitor.describeProvisionedProduct(request)
    }

    final case class DescribeProvisionedProductPlanOp(
      request: DescribeProvisionedProductPlanRequest
    ) extends ServiceCatalogOp[DescribeProvisionedProductPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProvisionedProductPlanResponse] =
        visitor.describeProvisionedProductPlan(request)
    }

    final case class DescribeProvisioningArtifactOp(
      request: DescribeProvisioningArtifactRequest
    ) extends ServiceCatalogOp[DescribeProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProvisioningArtifactResponse] =
        visitor.describeProvisioningArtifact(request)
    }

    final case class DescribeProvisioningParametersOp(
      request: DescribeProvisioningParametersRequest
    ) extends ServiceCatalogOp[DescribeProvisioningParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeProvisioningParametersResponse] =
        visitor.describeProvisioningParameters(request)
    }

    final case class DescribeRecordOp(
      request: DescribeRecordRequest
    ) extends ServiceCatalogOp[DescribeRecordResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRecordResponse] =
        visitor.describeRecord(request)
    }

    final case class DescribeServiceActionOp(
      request: DescribeServiceActionRequest
    ) extends ServiceCatalogOp[DescribeServiceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceActionResponse] =
        visitor.describeServiceAction(request)
    }

    final case class DescribeServiceActionExecutionParametersOp(
      request: DescribeServiceActionExecutionParametersRequest
    ) extends ServiceCatalogOp[DescribeServiceActionExecutionParametersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeServiceActionExecutionParametersResponse] =
        visitor.describeServiceActionExecutionParameters(request)
    }

    final case class DescribeTagOptionOp(
      request: DescribeTagOptionRequest
    ) extends ServiceCatalogOp[DescribeTagOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeTagOptionResponse] =
        visitor.describeTagOption(request)
    }

    final case class DisableAWSOrganizationsAccessOp(
      request: DisableAwsOrganizationsAccessRequest
    ) extends ServiceCatalogOp[DisableAwsOrganizationsAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisableAwsOrganizationsAccessResponse] =
        visitor.disableAWSOrganizationsAccess(request)
    }

    final case class DisassociateBudgetFromResourceOp(
      request: DisassociateBudgetFromResourceRequest
    ) extends ServiceCatalogOp[DisassociateBudgetFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateBudgetFromResourceResponse] =
        visitor.disassociateBudgetFromResource(request)
    }

    final case class DisassociatePrincipalFromPortfolioOp(
      request: DisassociatePrincipalFromPortfolioRequest
    ) extends ServiceCatalogOp[DisassociatePrincipalFromPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociatePrincipalFromPortfolioResponse] =
        visitor.disassociatePrincipalFromPortfolio(request)
    }

    final case class DisassociateProductFromPortfolioOp(
      request: DisassociateProductFromPortfolioRequest
    ) extends ServiceCatalogOp[DisassociateProductFromPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateProductFromPortfolioResponse] =
        visitor.disassociateProductFromPortfolio(request)
    }

    final case class DisassociateServiceActionFromProvisioningArtifactOp(
      request: DisassociateServiceActionFromProvisioningArtifactRequest
    ) extends ServiceCatalogOp[DisassociateServiceActionFromProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateServiceActionFromProvisioningArtifactResponse] =
        visitor.disassociateServiceActionFromProvisioningArtifact(request)
    }

    final case class DisassociateTagOptionFromResourceOp(
      request: DisassociateTagOptionFromResourceRequest
    ) extends ServiceCatalogOp[DisassociateTagOptionFromResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateTagOptionFromResourceResponse] =
        visitor.disassociateTagOptionFromResource(request)
    }

    final case class EnableAWSOrganizationsAccessOp(
      request: EnableAwsOrganizationsAccessRequest
    ) extends ServiceCatalogOp[EnableAwsOrganizationsAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[EnableAwsOrganizationsAccessResponse] =
        visitor.enableAWSOrganizationsAccess(request)
    }

    final case class ExecuteProvisionedProductPlanOp(
      request: ExecuteProvisionedProductPlanRequest
    ) extends ServiceCatalogOp[ExecuteProvisionedProductPlanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteProvisionedProductPlanResponse] =
        visitor.executeProvisionedProductPlan(request)
    }

    final case class ExecuteProvisionedProductServiceActionOp(
      request: ExecuteProvisionedProductServiceActionRequest
    ) extends ServiceCatalogOp[ExecuteProvisionedProductServiceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ExecuteProvisionedProductServiceActionResponse] =
        visitor.executeProvisionedProductServiceAction(request)
    }

    final case class GetAWSOrganizationsAccessStatusOp(
      request: GetAwsOrganizationsAccessStatusRequest
    ) extends ServiceCatalogOp[GetAwsOrganizationsAccessStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAwsOrganizationsAccessStatusResponse] =
        visitor.getAWSOrganizationsAccessStatus(request)
    }

    final case class GetProvisionedProductOutputsOp(
      request: GetProvisionedProductOutputsRequest
    ) extends ServiceCatalogOp[GetProvisionedProductOutputsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProvisionedProductOutputsResponse] =
        visitor.getProvisionedProductOutputs(request)
    }

    final case class ImportAsProvisionedProductOp(
      request: ImportAsProvisionedProductRequest
    ) extends ServiceCatalogOp[ImportAsProvisionedProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ImportAsProvisionedProductResponse] =
        visitor.importAsProvisionedProduct(request)
    }

    final case class ListAcceptedPortfolioSharesOp(
      request: ListAcceptedPortfolioSharesRequest
    ) extends ServiceCatalogOp[ListAcceptedPortfolioSharesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAcceptedPortfolioSharesResponse] =
        visitor.listAcceptedPortfolioShares(request)
    }

    final case class ListBudgetsForResourceOp(
      request: ListBudgetsForResourceRequest
    ) extends ServiceCatalogOp[ListBudgetsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBudgetsForResourceResponse] =
        visitor.listBudgetsForResource(request)
    }

    final case class ListConstraintsForPortfolioOp(
      request: ListConstraintsForPortfolioRequest
    ) extends ServiceCatalogOp[ListConstraintsForPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConstraintsForPortfolioResponse] =
        visitor.listConstraintsForPortfolio(request)
    }

    final case class ListLaunchPathsOp(
      request: ListLaunchPathsRequest
    ) extends ServiceCatalogOp[ListLaunchPathsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLaunchPathsResponse] =
        visitor.listLaunchPaths(request)
    }

    final case class ListOrganizationPortfolioAccessOp(
      request: ListOrganizationPortfolioAccessRequest
    ) extends ServiceCatalogOp[ListOrganizationPortfolioAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListOrganizationPortfolioAccessResponse] =
        visitor.listOrganizationPortfolioAccess(request)
    }

    final case class ListPortfolioAccessOp(
      request: ListPortfolioAccessRequest
    ) extends ServiceCatalogOp[ListPortfolioAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPortfolioAccessResponse] =
        visitor.listPortfolioAccess(request)
    }

    final case class ListPortfoliosOp(
      request: ListPortfoliosRequest
    ) extends ServiceCatalogOp[ListPortfoliosResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPortfoliosResponse] =
        visitor.listPortfolios(request)
    }

    final case class ListPortfoliosForProductOp(
      request: ListPortfoliosForProductRequest
    ) extends ServiceCatalogOp[ListPortfoliosForProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPortfoliosForProductResponse] =
        visitor.listPortfoliosForProduct(request)
    }

    final case class ListPrincipalsForPortfolioOp(
      request: ListPrincipalsForPortfolioRequest
    ) extends ServiceCatalogOp[ListPrincipalsForPortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPrincipalsForPortfolioResponse] =
        visitor.listPrincipalsForPortfolio(request)
    }

    final case class ListProvisionedProductPlansOp(
      request: ListProvisionedProductPlansRequest
    ) extends ServiceCatalogOp[ListProvisionedProductPlansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisionedProductPlansResponse] =
        visitor.listProvisionedProductPlans(request)
    }

    final case class ListProvisioningArtifactsOp(
      request: ListProvisioningArtifactsRequest
    ) extends ServiceCatalogOp[ListProvisioningArtifactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisioningArtifactsResponse] =
        visitor.listProvisioningArtifacts(request)
    }

    final case class ListProvisioningArtifactsForServiceActionOp(
      request: ListProvisioningArtifactsForServiceActionRequest
    ) extends ServiceCatalogOp[ListProvisioningArtifactsForServiceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProvisioningArtifactsForServiceActionResponse] =
        visitor.listProvisioningArtifactsForServiceAction(request)
    }

    final case class ListRecordHistoryOp(
      request: ListRecordHistoryRequest
    ) extends ServiceCatalogOp[ListRecordHistoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRecordHistoryResponse] =
        visitor.listRecordHistory(request)
    }

    final case class ListResourcesForTagOptionOp(
      request: ListResourcesForTagOptionRequest
    ) extends ServiceCatalogOp[ListResourcesForTagOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListResourcesForTagOptionResponse] =
        visitor.listResourcesForTagOption(request)
    }

    final case class ListServiceActionsOp(
      request: ListServiceActionsRequest
    ) extends ServiceCatalogOp[ListServiceActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceActionsResponse] =
        visitor.listServiceActions(request)
    }

    final case class ListServiceActionsForProvisioningArtifactOp(
      request: ListServiceActionsForProvisioningArtifactRequest
    ) extends ServiceCatalogOp[ListServiceActionsForProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceActionsForProvisioningArtifactResponse] =
        visitor.listServiceActionsForProvisioningArtifact(request)
    }

    final case class ListStackInstancesForProvisionedProductOp(
      request: ListStackInstancesForProvisionedProductRequest
    ) extends ServiceCatalogOp[ListStackInstancesForProvisionedProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListStackInstancesForProvisionedProductResponse] =
        visitor.listStackInstancesForProvisionedProduct(request)
    }

    final case class ListTagOptionsOp(
      request: ListTagOptionsRequest
    ) extends ServiceCatalogOp[ListTagOptionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagOptionsResponse] =
        visitor.listTagOptions(request)
    }

    final case class ProvisionProductOp(
      request: ProvisionProductRequest
    ) extends ServiceCatalogOp[ProvisionProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ProvisionProductResponse] =
        visitor.provisionProduct(request)
    }

    final case class RejectPortfolioShareOp(
      request: RejectPortfolioShareRequest
    ) extends ServiceCatalogOp[RejectPortfolioShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectPortfolioShareResponse] =
        visitor.rejectPortfolioShare(request)
    }

    final case class ScanProvisionedProductsOp(
      request: ScanProvisionedProductsRequest
    ) extends ServiceCatalogOp[ScanProvisionedProductsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ScanProvisionedProductsResponse] =
        visitor.scanProvisionedProducts(request)
    }

    final case class SearchProductsOp(
      request: SearchProductsRequest
    ) extends ServiceCatalogOp[SearchProductsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchProductsResponse] =
        visitor.searchProducts(request)
    }

    final case class SearchProductsAsAdminOp(
      request: SearchProductsAsAdminRequest
    ) extends ServiceCatalogOp[SearchProductsAsAdminResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchProductsAsAdminResponse] =
        visitor.searchProductsAsAdmin(request)
    }

    final case class SearchProvisionedProductsOp(
      request: SearchProvisionedProductsRequest
    ) extends ServiceCatalogOp[SearchProvisionedProductsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchProvisionedProductsResponse] =
        visitor.searchProvisionedProducts(request)
    }

    final case class TerminateProvisionedProductOp(
      request: TerminateProvisionedProductRequest
    ) extends ServiceCatalogOp[TerminateProvisionedProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TerminateProvisionedProductResponse] =
        visitor.terminateProvisionedProduct(request)
    }

    final case class UpdateConstraintOp(
      request: UpdateConstraintRequest
    ) extends ServiceCatalogOp[UpdateConstraintResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConstraintResponse] =
        visitor.updateConstraint(request)
    }

    final case class UpdatePortfolioOp(
      request: UpdatePortfolioRequest
    ) extends ServiceCatalogOp[UpdatePortfolioResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePortfolioResponse] =
        visitor.updatePortfolio(request)
    }

    final case class UpdatePortfolioShareOp(
      request: UpdatePortfolioShareRequest
    ) extends ServiceCatalogOp[UpdatePortfolioShareResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePortfolioShareResponse] =
        visitor.updatePortfolioShare(request)
    }

    final case class UpdateProductOp(
      request: UpdateProductRequest
    ) extends ServiceCatalogOp[UpdateProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProductResponse] =
        visitor.updateProduct(request)
    }

    final case class UpdateProvisionedProductOp(
      request: UpdateProvisionedProductRequest
    ) extends ServiceCatalogOp[UpdateProvisionedProductResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProvisionedProductResponse] =
        visitor.updateProvisionedProduct(request)
    }

    final case class UpdateProvisionedProductPropertiesOp(
      request: UpdateProvisionedProductPropertiesRequest
    ) extends ServiceCatalogOp[UpdateProvisionedProductPropertiesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProvisionedProductPropertiesResponse] =
        visitor.updateProvisionedProductProperties(request)
    }

    final case class UpdateProvisioningArtifactOp(
      request: UpdateProvisioningArtifactRequest
    ) extends ServiceCatalogOp[UpdateProvisioningArtifactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProvisioningArtifactResponse] =
        visitor.updateProvisioningArtifact(request)
    }

    final case class UpdateServiceActionOp(
      request: UpdateServiceActionRequest
    ) extends ServiceCatalogOp[UpdateServiceActionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateServiceActionResponse] =
        visitor.updateServiceAction(request)
    }

    final case class UpdateTagOptionOp(
      request: UpdateTagOptionRequest
    ) extends ServiceCatalogOp[UpdateTagOptionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateTagOptionResponse] =
        visitor.updateTagOption(request)
    }
  }

  import ServiceCatalogOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ServiceCatalogOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptPortfolioShare(
    request: AcceptPortfolioShareRequest
  ): ServiceCatalogIO[AcceptPortfolioShareResponse] =
    FF.liftF(AcceptPortfolioShareOp(request))

  def associateBudgetWithResource(
    request: AssociateBudgetWithResourceRequest
  ): ServiceCatalogIO[AssociateBudgetWithResourceResponse] =
    FF.liftF(AssociateBudgetWithResourceOp(request))

  def associatePrincipalWithPortfolio(
    request: AssociatePrincipalWithPortfolioRequest
  ): ServiceCatalogIO[AssociatePrincipalWithPortfolioResponse] =
    FF.liftF(AssociatePrincipalWithPortfolioOp(request))

  def associateProductWithPortfolio(
    request: AssociateProductWithPortfolioRequest
  ): ServiceCatalogIO[AssociateProductWithPortfolioResponse] =
    FF.liftF(AssociateProductWithPortfolioOp(request))

  def associateServiceActionWithProvisioningArtifact(
    request: AssociateServiceActionWithProvisioningArtifactRequest
  ): ServiceCatalogIO[AssociateServiceActionWithProvisioningArtifactResponse] =
    FF.liftF(AssociateServiceActionWithProvisioningArtifactOp(request))

  def associateTagOptionWithResource(
    request: AssociateTagOptionWithResourceRequest
  ): ServiceCatalogIO[AssociateTagOptionWithResourceResponse] =
    FF.liftF(AssociateTagOptionWithResourceOp(request))

  def batchAssociateServiceActionWithProvisioningArtifact(
    request: BatchAssociateServiceActionWithProvisioningArtifactRequest
  ): ServiceCatalogIO[BatchAssociateServiceActionWithProvisioningArtifactResponse] =
    FF.liftF(BatchAssociateServiceActionWithProvisioningArtifactOp(request))

  def batchDisassociateServiceActionFromProvisioningArtifact(
    request: BatchDisassociateServiceActionFromProvisioningArtifactRequest
  ): ServiceCatalogIO[BatchDisassociateServiceActionFromProvisioningArtifactResponse] =
    FF.liftF(BatchDisassociateServiceActionFromProvisioningArtifactOp(request))

  def copyProduct(
    request: CopyProductRequest
  ): ServiceCatalogIO[CopyProductResponse] =
    FF.liftF(CopyProductOp(request))

  def createConstraint(
    request: CreateConstraintRequest
  ): ServiceCatalogIO[CreateConstraintResponse] =
    FF.liftF(CreateConstraintOp(request))

  def createPortfolio(
    request: CreatePortfolioRequest
  ): ServiceCatalogIO[CreatePortfolioResponse] =
    FF.liftF(CreatePortfolioOp(request))

  def createPortfolioShare(
    request: CreatePortfolioShareRequest
  ): ServiceCatalogIO[CreatePortfolioShareResponse] =
    FF.liftF(CreatePortfolioShareOp(request))

  def createProduct(
    request: CreateProductRequest
  ): ServiceCatalogIO[CreateProductResponse] =
    FF.liftF(CreateProductOp(request))

  def createProvisionedProductPlan(
    request: CreateProvisionedProductPlanRequest
  ): ServiceCatalogIO[CreateProvisionedProductPlanResponse] =
    FF.liftF(CreateProvisionedProductPlanOp(request))

  def createProvisioningArtifact(
    request: CreateProvisioningArtifactRequest
  ): ServiceCatalogIO[CreateProvisioningArtifactResponse] =
    FF.liftF(CreateProvisioningArtifactOp(request))

  def createServiceAction(
    request: CreateServiceActionRequest
  ): ServiceCatalogIO[CreateServiceActionResponse] =
    FF.liftF(CreateServiceActionOp(request))

  def createTagOption(
    request: CreateTagOptionRequest
  ): ServiceCatalogIO[CreateTagOptionResponse] =
    FF.liftF(CreateTagOptionOp(request))

  def deleteConstraint(
    request: DeleteConstraintRequest
  ): ServiceCatalogIO[DeleteConstraintResponse] =
    FF.liftF(DeleteConstraintOp(request))

  def deletePortfolio(
    request: DeletePortfolioRequest
  ): ServiceCatalogIO[DeletePortfolioResponse] =
    FF.liftF(DeletePortfolioOp(request))

  def deletePortfolioShare(
    request: DeletePortfolioShareRequest
  ): ServiceCatalogIO[DeletePortfolioShareResponse] =
    FF.liftF(DeletePortfolioShareOp(request))

  def deleteProduct(
    request: DeleteProductRequest
  ): ServiceCatalogIO[DeleteProductResponse] =
    FF.liftF(DeleteProductOp(request))

  def deleteProvisionedProductPlan(
    request: DeleteProvisionedProductPlanRequest
  ): ServiceCatalogIO[DeleteProvisionedProductPlanResponse] =
    FF.liftF(DeleteProvisionedProductPlanOp(request))

  def deleteProvisioningArtifact(
    request: DeleteProvisioningArtifactRequest
  ): ServiceCatalogIO[DeleteProvisioningArtifactResponse] =
    FF.liftF(DeleteProvisioningArtifactOp(request))

  def deleteServiceAction(
    request: DeleteServiceActionRequest
  ): ServiceCatalogIO[DeleteServiceActionResponse] =
    FF.liftF(DeleteServiceActionOp(request))

  def deleteTagOption(
    request: DeleteTagOptionRequest
  ): ServiceCatalogIO[DeleteTagOptionResponse] =
    FF.liftF(DeleteTagOptionOp(request))

  def describeConstraint(
    request: DescribeConstraintRequest
  ): ServiceCatalogIO[DescribeConstraintResponse] =
    FF.liftF(DescribeConstraintOp(request))

  def describeCopyProductStatus(
    request: DescribeCopyProductStatusRequest
  ): ServiceCatalogIO[DescribeCopyProductStatusResponse] =
    FF.liftF(DescribeCopyProductStatusOp(request))

  def describePortfolio(
    request: DescribePortfolioRequest
  ): ServiceCatalogIO[DescribePortfolioResponse] =
    FF.liftF(DescribePortfolioOp(request))

  def describePortfolioShareStatus(
    request: DescribePortfolioShareStatusRequest
  ): ServiceCatalogIO[DescribePortfolioShareStatusResponse] =
    FF.liftF(DescribePortfolioShareStatusOp(request))

  def describePortfolioShares(
    request: DescribePortfolioSharesRequest
  ): ServiceCatalogIO[DescribePortfolioSharesResponse] =
    FF.liftF(DescribePortfolioSharesOp(request))

  def describeProduct(
    request: DescribeProductRequest
  ): ServiceCatalogIO[DescribeProductResponse] =
    FF.liftF(DescribeProductOp(request))

  def describeProductAsAdmin(
    request: DescribeProductAsAdminRequest
  ): ServiceCatalogIO[DescribeProductAsAdminResponse] =
    FF.liftF(DescribeProductAsAdminOp(request))

  def describeProductView(
    request: DescribeProductViewRequest
  ): ServiceCatalogIO[DescribeProductViewResponse] =
    FF.liftF(DescribeProductViewOp(request))

  def describeProvisionedProduct(
    request: DescribeProvisionedProductRequest
  ): ServiceCatalogIO[DescribeProvisionedProductResponse] =
    FF.liftF(DescribeProvisionedProductOp(request))

  def describeProvisionedProductPlan(
    request: DescribeProvisionedProductPlanRequest
  ): ServiceCatalogIO[DescribeProvisionedProductPlanResponse] =
    FF.liftF(DescribeProvisionedProductPlanOp(request))

  def describeProvisioningArtifact(
    request: DescribeProvisioningArtifactRequest
  ): ServiceCatalogIO[DescribeProvisioningArtifactResponse] =
    FF.liftF(DescribeProvisioningArtifactOp(request))

  def describeProvisioningParameters(
    request: DescribeProvisioningParametersRequest
  ): ServiceCatalogIO[DescribeProvisioningParametersResponse] =
    FF.liftF(DescribeProvisioningParametersOp(request))

  def describeRecord(
    request: DescribeRecordRequest
  ): ServiceCatalogIO[DescribeRecordResponse] =
    FF.liftF(DescribeRecordOp(request))

  def describeServiceAction(
    request: DescribeServiceActionRequest
  ): ServiceCatalogIO[DescribeServiceActionResponse] =
    FF.liftF(DescribeServiceActionOp(request))

  def describeServiceActionExecutionParameters(
    request: DescribeServiceActionExecutionParametersRequest
  ): ServiceCatalogIO[DescribeServiceActionExecutionParametersResponse] =
    FF.liftF(DescribeServiceActionExecutionParametersOp(request))

  def describeTagOption(
    request: DescribeTagOptionRequest
  ): ServiceCatalogIO[DescribeTagOptionResponse] =
    FF.liftF(DescribeTagOptionOp(request))

  def disableAWSOrganizationsAccess(
    request: DisableAwsOrganizationsAccessRequest
  ): ServiceCatalogIO[DisableAwsOrganizationsAccessResponse] =
    FF.liftF(DisableAWSOrganizationsAccessOp(request))

  def disassociateBudgetFromResource(
    request: DisassociateBudgetFromResourceRequest
  ): ServiceCatalogIO[DisassociateBudgetFromResourceResponse] =
    FF.liftF(DisassociateBudgetFromResourceOp(request))

  def disassociatePrincipalFromPortfolio(
    request: DisassociatePrincipalFromPortfolioRequest
  ): ServiceCatalogIO[DisassociatePrincipalFromPortfolioResponse] =
    FF.liftF(DisassociatePrincipalFromPortfolioOp(request))

  def disassociateProductFromPortfolio(
    request: DisassociateProductFromPortfolioRequest
  ): ServiceCatalogIO[DisassociateProductFromPortfolioResponse] =
    FF.liftF(DisassociateProductFromPortfolioOp(request))

  def disassociateServiceActionFromProvisioningArtifact(
    request: DisassociateServiceActionFromProvisioningArtifactRequest
  ): ServiceCatalogIO[DisassociateServiceActionFromProvisioningArtifactResponse] =
    FF.liftF(DisassociateServiceActionFromProvisioningArtifactOp(request))

  def disassociateTagOptionFromResource(
    request: DisassociateTagOptionFromResourceRequest
  ): ServiceCatalogIO[DisassociateTagOptionFromResourceResponse] =
    FF.liftF(DisassociateTagOptionFromResourceOp(request))

  def enableAWSOrganizationsAccess(
    request: EnableAwsOrganizationsAccessRequest
  ): ServiceCatalogIO[EnableAwsOrganizationsAccessResponse] =
    FF.liftF(EnableAWSOrganizationsAccessOp(request))

  def executeProvisionedProductPlan(
    request: ExecuteProvisionedProductPlanRequest
  ): ServiceCatalogIO[ExecuteProvisionedProductPlanResponse] =
    FF.liftF(ExecuteProvisionedProductPlanOp(request))

  def executeProvisionedProductServiceAction(
    request: ExecuteProvisionedProductServiceActionRequest
  ): ServiceCatalogIO[ExecuteProvisionedProductServiceActionResponse] =
    FF.liftF(ExecuteProvisionedProductServiceActionOp(request))

  def getAWSOrganizationsAccessStatus(
    request: GetAwsOrganizationsAccessStatusRequest
  ): ServiceCatalogIO[GetAwsOrganizationsAccessStatusResponse] =
    FF.liftF(GetAWSOrganizationsAccessStatusOp(request))

  def getProvisionedProductOutputs(
    request: GetProvisionedProductOutputsRequest
  ): ServiceCatalogIO[GetProvisionedProductOutputsResponse] =
    FF.liftF(GetProvisionedProductOutputsOp(request))

  def importAsProvisionedProduct(
    request: ImportAsProvisionedProductRequest
  ): ServiceCatalogIO[ImportAsProvisionedProductResponse] =
    FF.liftF(ImportAsProvisionedProductOp(request))

  def listAcceptedPortfolioShares(
    request: ListAcceptedPortfolioSharesRequest
  ): ServiceCatalogIO[ListAcceptedPortfolioSharesResponse] =
    FF.liftF(ListAcceptedPortfolioSharesOp(request))

  def listBudgetsForResource(
    request: ListBudgetsForResourceRequest
  ): ServiceCatalogIO[ListBudgetsForResourceResponse] =
    FF.liftF(ListBudgetsForResourceOp(request))

  def listConstraintsForPortfolio(
    request: ListConstraintsForPortfolioRequest
  ): ServiceCatalogIO[ListConstraintsForPortfolioResponse] =
    FF.liftF(ListConstraintsForPortfolioOp(request))

  def listLaunchPaths(
    request: ListLaunchPathsRequest
  ): ServiceCatalogIO[ListLaunchPathsResponse] =
    FF.liftF(ListLaunchPathsOp(request))

  def listOrganizationPortfolioAccess(
    request: ListOrganizationPortfolioAccessRequest
  ): ServiceCatalogIO[ListOrganizationPortfolioAccessResponse] =
    FF.liftF(ListOrganizationPortfolioAccessOp(request))

  def listPortfolioAccess(
    request: ListPortfolioAccessRequest
  ): ServiceCatalogIO[ListPortfolioAccessResponse] =
    FF.liftF(ListPortfolioAccessOp(request))

  def listPortfolios(
    request: ListPortfoliosRequest
  ): ServiceCatalogIO[ListPortfoliosResponse] =
    FF.liftF(ListPortfoliosOp(request))

  def listPortfoliosForProduct(
    request: ListPortfoliosForProductRequest
  ): ServiceCatalogIO[ListPortfoliosForProductResponse] =
    FF.liftF(ListPortfoliosForProductOp(request))

  def listPrincipalsForPortfolio(
    request: ListPrincipalsForPortfolioRequest
  ): ServiceCatalogIO[ListPrincipalsForPortfolioResponse] =
    FF.liftF(ListPrincipalsForPortfolioOp(request))

  def listProvisionedProductPlans(
    request: ListProvisionedProductPlansRequest
  ): ServiceCatalogIO[ListProvisionedProductPlansResponse] =
    FF.liftF(ListProvisionedProductPlansOp(request))

  def listProvisioningArtifacts(
    request: ListProvisioningArtifactsRequest
  ): ServiceCatalogIO[ListProvisioningArtifactsResponse] =
    FF.liftF(ListProvisioningArtifactsOp(request))

  def listProvisioningArtifactsForServiceAction(
    request: ListProvisioningArtifactsForServiceActionRequest
  ): ServiceCatalogIO[ListProvisioningArtifactsForServiceActionResponse] =
    FF.liftF(ListProvisioningArtifactsForServiceActionOp(request))

  def listRecordHistory(
    request: ListRecordHistoryRequest
  ): ServiceCatalogIO[ListRecordHistoryResponse] =
    FF.liftF(ListRecordHistoryOp(request))

  def listResourcesForTagOption(
    request: ListResourcesForTagOptionRequest
  ): ServiceCatalogIO[ListResourcesForTagOptionResponse] =
    FF.liftF(ListResourcesForTagOptionOp(request))

  def listServiceActions(
    request: ListServiceActionsRequest
  ): ServiceCatalogIO[ListServiceActionsResponse] =
    FF.liftF(ListServiceActionsOp(request))

  def listServiceActionsForProvisioningArtifact(
    request: ListServiceActionsForProvisioningArtifactRequest
  ): ServiceCatalogIO[ListServiceActionsForProvisioningArtifactResponse] =
    FF.liftF(ListServiceActionsForProvisioningArtifactOp(request))

  def listStackInstancesForProvisionedProduct(
    request: ListStackInstancesForProvisionedProductRequest
  ): ServiceCatalogIO[ListStackInstancesForProvisionedProductResponse] =
    FF.liftF(ListStackInstancesForProvisionedProductOp(request))

  def listTagOptions(
    request: ListTagOptionsRequest
  ): ServiceCatalogIO[ListTagOptionsResponse] =
    FF.liftF(ListTagOptionsOp(request))

  def provisionProduct(
    request: ProvisionProductRequest
  ): ServiceCatalogIO[ProvisionProductResponse] =
    FF.liftF(ProvisionProductOp(request))

  def rejectPortfolioShare(
    request: RejectPortfolioShareRequest
  ): ServiceCatalogIO[RejectPortfolioShareResponse] =
    FF.liftF(RejectPortfolioShareOp(request))

  def scanProvisionedProducts(
    request: ScanProvisionedProductsRequest
  ): ServiceCatalogIO[ScanProvisionedProductsResponse] =
    FF.liftF(ScanProvisionedProductsOp(request))

  def searchProducts(
    request: SearchProductsRequest
  ): ServiceCatalogIO[SearchProductsResponse] =
    FF.liftF(SearchProductsOp(request))

  def searchProductsAsAdmin(
    request: SearchProductsAsAdminRequest
  ): ServiceCatalogIO[SearchProductsAsAdminResponse] =
    FF.liftF(SearchProductsAsAdminOp(request))

  def searchProvisionedProducts(
    request: SearchProvisionedProductsRequest
  ): ServiceCatalogIO[SearchProvisionedProductsResponse] =
    FF.liftF(SearchProvisionedProductsOp(request))

  def terminateProvisionedProduct(
    request: TerminateProvisionedProductRequest
  ): ServiceCatalogIO[TerminateProvisionedProductResponse] =
    FF.liftF(TerminateProvisionedProductOp(request))

  def updateConstraint(
    request: UpdateConstraintRequest
  ): ServiceCatalogIO[UpdateConstraintResponse] =
    FF.liftF(UpdateConstraintOp(request))

  def updatePortfolio(
    request: UpdatePortfolioRequest
  ): ServiceCatalogIO[UpdatePortfolioResponse] =
    FF.liftF(UpdatePortfolioOp(request))

  def updatePortfolioShare(
    request: UpdatePortfolioShareRequest
  ): ServiceCatalogIO[UpdatePortfolioShareResponse] =
    FF.liftF(UpdatePortfolioShareOp(request))

  def updateProduct(
    request: UpdateProductRequest
  ): ServiceCatalogIO[UpdateProductResponse] =
    FF.liftF(UpdateProductOp(request))

  def updateProvisionedProduct(
    request: UpdateProvisionedProductRequest
  ): ServiceCatalogIO[UpdateProvisionedProductResponse] =
    FF.liftF(UpdateProvisionedProductOp(request))

  def updateProvisionedProductProperties(
    request: UpdateProvisionedProductPropertiesRequest
  ): ServiceCatalogIO[UpdateProvisionedProductPropertiesResponse] =
    FF.liftF(UpdateProvisionedProductPropertiesOp(request))

  def updateProvisioningArtifact(
    request: UpdateProvisioningArtifactRequest
  ): ServiceCatalogIO[UpdateProvisioningArtifactResponse] =
    FF.liftF(UpdateProvisioningArtifactOp(request))

  def updateServiceAction(
    request: UpdateServiceActionRequest
  ): ServiceCatalogIO[UpdateServiceActionResponse] =
    FF.liftF(UpdateServiceActionOp(request))

  def updateTagOption(
    request: UpdateTagOptionRequest
  ): ServiceCatalogIO[UpdateTagOptionResponse] =
    FF.liftF(UpdateTagOptionOp(request))
}
