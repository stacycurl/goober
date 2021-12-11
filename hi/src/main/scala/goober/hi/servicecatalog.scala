package goober.hi

import goober.free.servicecatalog.ServiceCatalogIO
import software.amazon.awssdk.services.servicecatalog.model._


object servicecatalog {
  import goober.free.{servicecatalog ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptPortfolioShareInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      portfolioShareType: Option[String] = None
    ): AcceptPortfolioShareInput =
      AcceptPortfolioShareInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(portfolioShareType)(_.portfolioShareType(_))
        .build

    def acceptPortfolioShareOutput(

    ): AcceptPortfolioShareOutput =
      AcceptPortfolioShareOutput
        .builder

        .build

    def accessLevelFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): AccessLevelFilter =
      AccessLevelFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def associateBudgetWithResourceInput(
      budgetName: Option[String] = None,
      resourceId: Option[String] = None
    ): AssociateBudgetWithResourceInput =
      AssociateBudgetWithResourceInput
        .builder
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def associateBudgetWithResourceOutput(

    ): AssociateBudgetWithResourceOutput =
      AssociateBudgetWithResourceOutput
        .builder

        .build

    def associatePrincipalWithPortfolioInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      principalARN: Option[String] = None,
      principalType: Option[String] = None
    ): AssociatePrincipalWithPortfolioInput =
      AssociatePrincipalWithPortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(principalARN)(_.principalARN(_))
        .ifSome(principalType)(_.principalType(_))
        .build

    def associatePrincipalWithPortfolioOutput(

    ): AssociatePrincipalWithPortfolioOutput =
      AssociatePrincipalWithPortfolioOutput
        .builder

        .build

    def associateProductWithPortfolioInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      portfolioId: Option[String] = None,
      sourcePortfolioId: Option[String] = None
    ): AssociateProductWithPortfolioInput =
      AssociateProductWithPortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(sourcePortfolioId)(_.sourcePortfolioId(_))
        .build

    def associateProductWithPortfolioOutput(

    ): AssociateProductWithPortfolioOutput =
      AssociateProductWithPortfolioOutput
        .builder

        .build

    def associateServiceActionWithProvisioningArtifactInput(
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      serviceActionId: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): AssociateServiceActionWithProvisioningArtifactInput =
      AssociateServiceActionWithProvisioningArtifactInput
        .builder
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def associateServiceActionWithProvisioningArtifactOutput(

    ): AssociateServiceActionWithProvisioningArtifactOutput =
      AssociateServiceActionWithProvisioningArtifactOutput
        .builder

        .build

    def associateTagOptionWithResourceInput(
      resourceId: Option[String] = None,
      tagOptionId: Option[String] = None
    ): AssociateTagOptionWithResourceInput =
      AssociateTagOptionWithResourceInput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagOptionId)(_.tagOptionId(_))
        .build

    def associateTagOptionWithResourceOutput(

    ): AssociateTagOptionWithResourceOutput =
      AssociateTagOptionWithResourceOutput
        .builder

        .build

    def batchAssociateServiceActionWithProvisioningArtifactInput(
      serviceActionAssociations: Option[List[ServiceActionAssociation]] = None,
      acceptLanguage: Option[String] = None
    ): BatchAssociateServiceActionWithProvisioningArtifactInput =
      BatchAssociateServiceActionWithProvisioningArtifactInput
        .builder
        .ifSome(serviceActionAssociations)(_.serviceActionAssociations(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def batchAssociateServiceActionWithProvisioningArtifactOutput(
      failedServiceActionAssociations: Option[List[FailedServiceActionAssociation]] = None
    ): BatchAssociateServiceActionWithProvisioningArtifactOutput =
      BatchAssociateServiceActionWithProvisioningArtifactOutput
        .builder
        .ifSome(failedServiceActionAssociations)(_.failedServiceActionAssociations(_))
        .build

    def batchDisassociateServiceActionFromProvisioningArtifactInput(
      serviceActionAssociations: Option[List[ServiceActionAssociation]] = None,
      acceptLanguage: Option[String] = None
    ): BatchDisassociateServiceActionFromProvisioningArtifactInput =
      BatchDisassociateServiceActionFromProvisioningArtifactInput
        .builder
        .ifSome(serviceActionAssociations)(_.serviceActionAssociations(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def batchDisassociateServiceActionFromProvisioningArtifactOutput(
      failedServiceActionAssociations: Option[List[FailedServiceActionAssociation]] = None
    ): BatchDisassociateServiceActionFromProvisioningArtifactOutput =
      BatchDisassociateServiceActionFromProvisioningArtifactOutput
        .builder
        .ifSome(failedServiceActionAssociations)(_.failedServiceActionAssociations(_))
        .build

    def budgetDetail(
      budgetName: Option[String] = None
    ): BudgetDetail =
      BudgetDetail
        .builder
        .ifSome(budgetName)(_.budgetName(_))
        .build

    def cloudWatchDashboard(
      name: Option[String] = None
    ): CloudWatchDashboard =
      CloudWatchDashboard
        .builder
        .ifSome(name)(_.name(_))
        .build

    def constraintDetail(
      constraintId: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      owner: Option[String] = None,
      productId: Option[String] = None,
      portfolioId: Option[String] = None
    ): ConstraintDetail =
      ConstraintDetail
        .builder
        .ifSome(constraintId)(_.constraintId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .build

    def constraintSummary(
      `type`: Option[String] = None,
      description: Option[String] = None
    ): ConstraintSummary =
      ConstraintSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .build

    def copyProductInput(
      acceptLanguage: Option[String] = None,
      sourceProductArn: Option[String] = None,
      targetProductId: Option[String] = None,
      targetProductName: Option[String] = None,
      sourceProvisioningArtifactIdentifiers: Option[List[SourceProvisioningArtifactPropertiesMap]] = None,
      copyOptions: Option[List[CopyOption]] = None,
      idempotencyToken: Option[String] = None
    ): CopyProductInput =
      CopyProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(sourceProductArn)(_.sourceProductArn(_))
        .ifSome(targetProductId)(_.targetProductId(_))
        .ifSome(targetProductName)(_.targetProductName(_))
        .ifSome(sourceProvisioningArtifactIdentifiers)(_.sourceProvisioningArtifactIdentifiers(_))
        .ifSome(copyOptions)(_.copyOptions(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def copyProductOutput(
      copyProductToken: Option[String] = None
    ): CopyProductOutput =
      CopyProductOutput
        .builder
        .ifSome(copyProductToken)(_.copyProductToken(_))
        .build

    def createConstraintInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      productId: Option[String] = None,
      parameters: Option[String] = None,
      `type`: Option[String] = None,
      description: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): CreateConstraintInput =
      CreateConstraintInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(description)(_.description(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createConstraintOutput(
      constraintDetail: Option[ConstraintDetail] = None,
      constraintParameters: Option[String] = None,
      status: Option[String] = None
    ): CreateConstraintOutput =
      CreateConstraintOutput
        .builder
        .ifSome(constraintDetail)(_.constraintDetail(_))
        .ifSome(constraintParameters)(_.constraintParameters(_))
        .ifSome(status)(_.status(_))
        .build

    def createPortfolioInput(
      acceptLanguage: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      providerName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      idempotencyToken: Option[String] = None
    ): CreatePortfolioInput =
      CreatePortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createPortfolioOutput(
      portfolioDetail: Option[PortfolioDetail] = None,
      tags: Option[List[Tag]] = None
    ): CreatePortfolioOutput =
      CreatePortfolioOutput
        .builder
        .ifSome(portfolioDetail)(_.portfolioDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPortfolioShareInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      accountId: Option[String] = None,
      organizationNode: Option[OrganizationNode] = None,
      shareTagOptions: Option[Boolean] = None
    ): CreatePortfolioShareInput =
      CreatePortfolioShareInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(organizationNode)(_.organizationNode(_))
        .ifSome(shareTagOptions)(_.shareTagOptions(_))
        .build

    def createPortfolioShareOutput(
      portfolioShareToken: Option[String] = None
    ): CreatePortfolioShareOutput =
      CreatePortfolioShareOutput
        .builder
        .ifSome(portfolioShareToken)(_.portfolioShareToken(_))
        .build

    def createProductInput(
      acceptLanguage: Option[String] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      description: Option[String] = None,
      distributor: Option[String] = None,
      supportDescription: Option[String] = None,
      supportEmail: Option[String] = None,
      supportUrl: Option[String] = None,
      productType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      provisioningArtifactParameters: Option[ProvisioningArtifactProperties] = None,
      idempotencyToken: Option[String] = None
    ): CreateProductInput =
      CreateProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(description)(_.description(_))
        .ifSome(distributor)(_.distributor(_))
        .ifSome(supportDescription)(_.supportDescription(_))
        .ifSome(supportEmail)(_.supportEmail(_))
        .ifSome(supportUrl)(_.supportUrl(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(provisioningArtifactParameters)(_.provisioningArtifactParameters(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createProductOutput(
      productViewDetail: Option[ProductViewDetail] = None,
      provisioningArtifactDetail: Option[ProvisioningArtifactDetail] = None,
      tags: Option[List[Tag]] = None
    ): CreateProductOutput =
      CreateProductOutput
        .builder
        .ifSome(productViewDetail)(_.productViewDetail(_))
        .ifSome(provisioningArtifactDetail)(_.provisioningArtifactDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProvisionedProductPlanInput(
      acceptLanguage: Option[String] = None,
      planName: Option[String] = None,
      planType: Option[String] = None,
      notificationArns: Option[List[NotificationArn]] = None,
      pathId: Option[String] = None,
      productId: Option[String] = None,
      provisionedProductName: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      provisioningParameters: Option[List[UpdateProvisioningParameter]] = None,
      idempotencyToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateProvisionedProductPlanInput =
      CreateProvisionedProductPlanInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(planName)(_.planName(_))
        .ifSome(planType)(_.planType(_))
        .ifSome(notificationArns)(_.notificationArns(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(provisioningParameters)(_.provisioningParameters(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProvisionedProductPlanOutput(
      planName: Option[String] = None,
      planId: Option[String] = None,
      provisionProductId: Option[String] = None,
      provisionedProductName: Option[String] = None,
      provisioningArtifactId: Option[String] = None
    ): CreateProvisionedProductPlanOutput =
      CreateProvisionedProductPlanOutput
        .builder
        .ifSome(planName)(_.planName(_))
        .ifSome(planId)(_.planId(_))
        .ifSome(provisionProductId)(_.provisionProductId(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .build

    def createProvisioningArtifactInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      parameters: Option[ProvisioningArtifactProperties] = None,
      idempotencyToken: Option[String] = None
    ): CreateProvisioningArtifactInput =
      CreateProvisioningArtifactInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createProvisioningArtifactOutput(
      provisioningArtifactDetail: Option[ProvisioningArtifactDetail] = None,
      info: Option[ProvisioningArtifactInfo] = None,
      status: Option[String] = None
    ): CreateProvisioningArtifactOutput =
      CreateProvisioningArtifactOutput
        .builder
        .ifSome(provisioningArtifactDetail)(_.provisioningArtifactDetail(_))
        .ifSome(info)(_.info(_))
        .ifSome(status)(_.status(_))
        .build

    def createServiceActionInput(
      name: Option[String] = None,
      definitionType: Option[String] = None,
      definition: Option[ServiceActionDefinitionMap] = None,
      description: Option[String] = None,
      acceptLanguage: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): CreateServiceActionInput =
      CreateServiceActionInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(definitionType)(_.definitionType(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(description)(_.description(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def createServiceActionOutput(
      serviceActionDetail: Option[ServiceActionDetail] = None
    ): CreateServiceActionOutput =
      CreateServiceActionOutput
        .builder
        .ifSome(serviceActionDetail)(_.serviceActionDetail(_))
        .build

    def createTagOptionInput(
      key: Option[String] = None,
      value: Option[String] = None
    ): CreateTagOptionInput =
      CreateTagOptionInput
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def createTagOptionOutput(
      tagOptionDetail: Option[TagOptionDetail] = None
    ): CreateTagOptionOutput =
      CreateTagOptionOutput
        .builder
        .ifSome(tagOptionDetail)(_.tagOptionDetail(_))
        .build

    def deleteConstraintInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None
    ): DeleteConstraintInput =
      DeleteConstraintInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .build

    def deleteConstraintOutput(

    ): DeleteConstraintOutput =
      DeleteConstraintOutput
        .builder

        .build

    def deletePortfolioInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None
    ): DeletePortfolioInput =
      DeletePortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .build

    def deletePortfolioOutput(

    ): DeletePortfolioOutput =
      DeletePortfolioOutput
        .builder

        .build

    def deletePortfolioShareInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      accountId: Option[String] = None,
      organizationNode: Option[OrganizationNode] = None
    ): DeletePortfolioShareInput =
      DeletePortfolioShareInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(organizationNode)(_.organizationNode(_))
        .build

    def deletePortfolioShareOutput(
      portfolioShareToken: Option[String] = None
    ): DeletePortfolioShareOutput =
      DeletePortfolioShareOutput
        .builder
        .ifSome(portfolioShareToken)(_.portfolioShareToken(_))
        .build

    def deleteProductInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None
    ): DeleteProductInput =
      DeleteProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .build

    def deleteProductOutput(

    ): DeleteProductOutput =
      DeleteProductOutput
        .builder

        .build

    def deleteProvisionedProductPlanInput(
      acceptLanguage: Option[String] = None,
      planId: Option[String] = None,
      ignoreErrors: Option[Boolean] = None
    ): DeleteProvisionedProductPlanInput =
      DeleteProvisionedProductPlanInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(planId)(_.planId(_))
        .ifSome(ignoreErrors)(_.ignoreErrors(_))
        .build

    def deleteProvisionedProductPlanOutput(

    ): DeleteProvisionedProductPlanOutput =
      DeleteProvisionedProductPlanOutput
        .builder

        .build

    def deleteProvisioningArtifactInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None
    ): DeleteProvisioningArtifactInput =
      DeleteProvisioningArtifactInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .build

    def deleteProvisioningArtifactOutput(

    ): DeleteProvisioningArtifactOutput =
      DeleteProvisioningArtifactOutput
        .builder

        .build

    def deleteServiceActionInput(
      id: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): DeleteServiceActionInput =
      DeleteServiceActionInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def deleteServiceActionOutput(

    ): DeleteServiceActionOutput =
      DeleteServiceActionOutput
        .builder

        .build

    def deleteTagOptionInput(
      id: Option[String] = None
    ): DeleteTagOptionInput =
      DeleteTagOptionInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteTagOptionOutput(

    ): DeleteTagOptionOutput =
      DeleteTagOptionOutput
        .builder

        .build

    def describeConstraintInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None
    ): DescribeConstraintInput =
      DescribeConstraintInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .build

    def describeConstraintOutput(
      constraintDetail: Option[ConstraintDetail] = None,
      constraintParameters: Option[String] = None,
      status: Option[String] = None
    ): DescribeConstraintOutput =
      DescribeConstraintOutput
        .builder
        .ifSome(constraintDetail)(_.constraintDetail(_))
        .ifSome(constraintParameters)(_.constraintParameters(_))
        .ifSome(status)(_.status(_))
        .build

    def describeCopyProductStatusInput(
      acceptLanguage: Option[String] = None,
      copyProductToken: Option[String] = None
    ): DescribeCopyProductStatusInput =
      DescribeCopyProductStatusInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(copyProductToken)(_.copyProductToken(_))
        .build

    def describeCopyProductStatusOutput(
      copyProductStatus: Option[String] = None,
      targetProductId: Option[String] = None,
      statusDetail: Option[String] = None
    ): DescribeCopyProductStatusOutput =
      DescribeCopyProductStatusOutput
        .builder
        .ifSome(copyProductStatus)(_.copyProductStatus(_))
        .ifSome(targetProductId)(_.targetProductId(_))
        .ifSome(statusDetail)(_.statusDetail(_))
        .build

    def describePortfolioInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None
    ): DescribePortfolioInput =
      DescribePortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .build

    def describePortfolioOutput(
      portfolioDetail: Option[PortfolioDetail] = None,
      tags: Option[List[Tag]] = None,
      tagOptions: Option[List[TagOptionDetail]] = None,
      budgets: Option[List[BudgetDetail]] = None
    ): DescribePortfolioOutput =
      DescribePortfolioOutput
        .builder
        .ifSome(portfolioDetail)(_.portfolioDetail(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(tagOptions)(_.tagOptions(_))
        .ifSome(budgets)(_.budgets(_))
        .build

    def describePortfolioShareStatusInput(
      portfolioShareToken: Option[String] = None
    ): DescribePortfolioShareStatusInput =
      DescribePortfolioShareStatusInput
        .builder
        .ifSome(portfolioShareToken)(_.portfolioShareToken(_))
        .build

    def describePortfolioShareStatusOutput(
      portfolioShareToken: Option[String] = None,
      portfolioId: Option[String] = None,
      organizationNodeValue: Option[String] = None,
      status: Option[String] = None,
      shareDetails: Option[ShareDetails] = None
    ): DescribePortfolioShareStatusOutput =
      DescribePortfolioShareStatusOutput
        .builder
        .ifSome(portfolioShareToken)(_.portfolioShareToken(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(organizationNodeValue)(_.organizationNodeValue(_))
        .ifSome(status)(_.status(_))
        .ifSome(shareDetails)(_.shareDetails(_))
        .build

    def describePortfolioSharesInput(
      portfolioId: Option[String] = None,
      `type`: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribePortfolioSharesInput =
      DescribePortfolioSharesInput
        .builder
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describePortfolioSharesOutput(
      nextPageToken: Option[String] = None,
      portfolioShareDetails: Option[List[PortfolioShareDetail]] = None
    ): DescribePortfolioSharesOutput =
      DescribePortfolioSharesOutput
        .builder
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .ifSome(portfolioShareDetails)(_.portfolioShareDetails(_))
        .build

    def describeProductAsAdminInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      sourcePortfolioId: Option[String] = None
    ): DescribeProductAsAdminInput =
      DescribeProductAsAdminInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourcePortfolioId)(_.sourcePortfolioId(_))
        .build

    def describeProductAsAdminOutput(
      productViewDetail: Option[ProductViewDetail] = None,
      provisioningArtifactSummaries: Option[List[ProvisioningArtifactSummary]] = None,
      tags: Option[List[Tag]] = None,
      tagOptions: Option[List[TagOptionDetail]] = None,
      budgets: Option[List[BudgetDetail]] = None
    ): DescribeProductAsAdminOutput =
      DescribeProductAsAdminOutput
        .builder
        .ifSome(productViewDetail)(_.productViewDetail(_))
        .ifSome(provisioningArtifactSummaries)(_.provisioningArtifactSummaries(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(tagOptions)(_.tagOptions(_))
        .ifSome(budgets)(_.budgets(_))
        .build

    def describeProductInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None
    ): DescribeProductInput =
      DescribeProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def describeProductOutput(
      productViewSummary: Option[ProductViewSummary] = None,
      provisioningArtifacts: Option[List[ProvisioningArtifact]] = None,
      budgets: Option[List[BudgetDetail]] = None,
      launchPaths: Option[List[LaunchPath]] = None
    ): DescribeProductOutput =
      DescribeProductOutput
        .builder
        .ifSome(productViewSummary)(_.productViewSummary(_))
        .ifSome(provisioningArtifacts)(_.provisioningArtifacts(_))
        .ifSome(budgets)(_.budgets(_))
        .ifSome(launchPaths)(_.launchPaths(_))
        .build

    def describeProductViewInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None
    ): DescribeProductViewInput =
      DescribeProductViewInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .build

    def describeProductViewOutput(
      productViewSummary: Option[ProductViewSummary] = None,
      provisioningArtifacts: Option[List[ProvisioningArtifact]] = None
    ): DescribeProductViewOutput =
      DescribeProductViewOutput
        .builder
        .ifSome(productViewSummary)(_.productViewSummary(_))
        .ifSome(provisioningArtifacts)(_.provisioningArtifacts(_))
        .build

    def describeProvisionedProductInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None
    ): DescribeProvisionedProductInput =
      DescribeProvisionedProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def describeProvisionedProductOutput(
      provisionedProductDetail: Option[ProvisionedProductDetail] = None,
      cloudWatchDashboards: Option[List[CloudWatchDashboard]] = None
    ): DescribeProvisionedProductOutput =
      DescribeProvisionedProductOutput
        .builder
        .ifSome(provisionedProductDetail)(_.provisionedProductDetail(_))
        .ifSome(cloudWatchDashboards)(_.cloudWatchDashboards(_))
        .build

    def describeProvisionedProductPlanInput(
      acceptLanguage: Option[String] = None,
      planId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): DescribeProvisionedProductPlanInput =
      DescribeProvisionedProductPlanInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(planId)(_.planId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def describeProvisionedProductPlanOutput(
      provisionedProductPlanDetails: Option[ProvisionedProductPlanDetails] = None,
      resourceChanges: Option[List[ResourceChange]] = None,
      nextPageToken: Option[String] = None
    ): DescribeProvisionedProductPlanOutput =
      DescribeProvisionedProductPlanOutput
        .builder
        .ifSome(provisionedProductPlanDetails)(_.provisionedProductPlanDetails(_))
        .ifSome(resourceChanges)(_.resourceChanges(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def describeProvisioningArtifactInput(
      acceptLanguage: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactName: Option[String] = None,
      productName: Option[String] = None,
      verbose: Option[Boolean] = None
    ): DescribeProvisioningArtifactInput =
      DescribeProvisioningArtifactInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactName)(_.provisioningArtifactName(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(verbose)(_.verbose(_))
        .build

    def describeProvisioningArtifactOutput(
      provisioningArtifactDetail: Option[ProvisioningArtifactDetail] = None,
      info: Option[ProvisioningArtifactInfo] = None,
      status: Option[String] = None
    ): DescribeProvisioningArtifactOutput =
      DescribeProvisioningArtifactOutput
        .builder
        .ifSome(provisioningArtifactDetail)(_.provisioningArtifactDetail(_))
        .ifSome(info)(_.info(_))
        .ifSome(status)(_.status(_))
        .build

    def describeProvisioningParametersInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      productName: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      provisioningArtifactName: Option[String] = None,
      pathId: Option[String] = None,
      pathName: Option[String] = None
    ): DescribeProvisioningParametersInput =
      DescribeProvisioningParametersInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(provisioningArtifactName)(_.provisioningArtifactName(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(pathName)(_.pathName(_))
        .build

    def describeProvisioningParametersOutput(
      provisioningArtifactParameters: Option[List[ProvisioningArtifactParameter]] = None,
      constraintSummaries: Option[List[ConstraintSummary]] = None,
      usageInstructions: Option[List[UsageInstruction]] = None,
      tagOptions: Option[List[TagOptionSummary]] = None,
      provisioningArtifactPreferences: Option[ProvisioningArtifactPreferences] = None,
      provisioningArtifactOutputs: Option[List[ProvisioningArtifactOutput]] = None
    ): DescribeProvisioningParametersOutput =
      DescribeProvisioningParametersOutput
        .builder
        .ifSome(provisioningArtifactParameters)(_.provisioningArtifactParameters(_))
        .ifSome(constraintSummaries)(_.constraintSummaries(_))
        .ifSome(usageInstructions)(_.usageInstructions(_))
        .ifSome(tagOptions)(_.tagOptions(_))
        .ifSome(provisioningArtifactPreferences)(_.provisioningArtifactPreferences(_))
        .ifSome(provisioningArtifactOutputs)(_.provisioningArtifactOutputs(_))
        .build

    def describeRecordInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): DescribeRecordInput =
      DescribeRecordInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def describeRecordOutput(
      recordDetail: Option[RecordDetail] = None,
      recordOutputs: Option[List[RecordOutput]] = None,
      nextPageToken: Option[String] = None
    ): DescribeRecordOutput =
      DescribeRecordOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .ifSome(recordOutputs)(_.recordOutputs(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def describeServiceActionExecutionParametersInput(
      provisionedProductId: Option[String] = None,
      serviceActionId: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): DescribeServiceActionExecutionParametersInput =
      DescribeServiceActionExecutionParametersInput
        .builder
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def describeServiceActionExecutionParametersOutput(
      serviceActionParameters: Option[List[ExecutionParameter]] = None
    ): DescribeServiceActionExecutionParametersOutput =
      DescribeServiceActionExecutionParametersOutput
        .builder
        .ifSome(serviceActionParameters)(_.serviceActionParameters(_))
        .build

    def describeServiceActionInput(
      id: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): DescribeServiceActionInput =
      DescribeServiceActionInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def describeServiceActionOutput(
      serviceActionDetail: Option[ServiceActionDetail] = None
    ): DescribeServiceActionOutput =
      DescribeServiceActionOutput
        .builder
        .ifSome(serviceActionDetail)(_.serviceActionDetail(_))
        .build

    def describeTagOptionInput(
      id: Option[String] = None
    ): DescribeTagOptionInput =
      DescribeTagOptionInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeTagOptionOutput(
      tagOptionDetail: Option[TagOptionDetail] = None
    ): DescribeTagOptionOutput =
      DescribeTagOptionOutput
        .builder
        .ifSome(tagOptionDetail)(_.tagOptionDetail(_))
        .build

    def disableAWSOrganizationsAccessInput(

    ): DisableAWSOrganizationsAccessInput =
      DisableAWSOrganizationsAccessInput
        .builder

        .build

    def disableAWSOrganizationsAccessOutput(

    ): DisableAWSOrganizationsAccessOutput =
      DisableAWSOrganizationsAccessOutput
        .builder

        .build

    def disassociateBudgetFromResourceInput(
      budgetName: Option[String] = None,
      resourceId: Option[String] = None
    ): DisassociateBudgetFromResourceInput =
      DisassociateBudgetFromResourceInput
        .builder
        .ifSome(budgetName)(_.budgetName(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def disassociateBudgetFromResourceOutput(

    ): DisassociateBudgetFromResourceOutput =
      DisassociateBudgetFromResourceOutput
        .builder

        .build

    def disassociatePrincipalFromPortfolioInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      principalARN: Option[String] = None
    ): DisassociatePrincipalFromPortfolioInput =
      DisassociatePrincipalFromPortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(principalARN)(_.principalARN(_))
        .build

    def disassociatePrincipalFromPortfolioOutput(

    ): DisassociatePrincipalFromPortfolioOutput =
      DisassociatePrincipalFromPortfolioOutput
        .builder

        .build

    def disassociateProductFromPortfolioInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      portfolioId: Option[String] = None
    ): DisassociateProductFromPortfolioInput =
      DisassociateProductFromPortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .build

    def disassociateProductFromPortfolioOutput(

    ): DisassociateProductFromPortfolioOutput =
      DisassociateProductFromPortfolioOutput
        .builder

        .build

    def disassociateServiceActionFromProvisioningArtifactInput(
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      serviceActionId: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): DisassociateServiceActionFromProvisioningArtifactInput =
      DisassociateServiceActionFromProvisioningArtifactInput
        .builder
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def disassociateServiceActionFromProvisioningArtifactOutput(

    ): DisassociateServiceActionFromProvisioningArtifactOutput =
      DisassociateServiceActionFromProvisioningArtifactOutput
        .builder

        .build

    def disassociateTagOptionFromResourceInput(
      resourceId: Option[String] = None,
      tagOptionId: Option[String] = None
    ): DisassociateTagOptionFromResourceInput =
      DisassociateTagOptionFromResourceInput
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagOptionId)(_.tagOptionId(_))
        .build

    def disassociateTagOptionFromResourceOutput(

    ): DisassociateTagOptionFromResourceOutput =
      DisassociateTagOptionFromResourceOutput
        .builder

        .build

    def duplicateResourceException(

    ): DuplicateResourceException =
      DuplicateResourceException
        .builder

        .build

    def enableAWSOrganizationsAccessInput(

    ): EnableAWSOrganizationsAccessInput =
      EnableAWSOrganizationsAccessInput
        .builder

        .build

    def enableAWSOrganizationsAccessOutput(

    ): EnableAWSOrganizationsAccessOutput =
      EnableAWSOrganizationsAccessOutput
        .builder

        .build

    def executeProvisionedProductPlanInput(
      acceptLanguage: Option[String] = None,
      planId: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): ExecuteProvisionedProductPlanInput =
      ExecuteProvisionedProductPlanInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(planId)(_.planId(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def executeProvisionedProductPlanOutput(
      recordDetail: Option[RecordDetail] = None
    ): ExecuteProvisionedProductPlanOutput =
      ExecuteProvisionedProductPlanOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .build

    def executeProvisionedProductServiceActionInput(
      provisionedProductId: Option[String] = None,
      serviceActionId: Option[String] = None,
      executeToken: Option[String] = None,
      acceptLanguage: Option[String] = None,
      parameters: Option[ExecutionParameterMap] = None
    ): ExecuteProvisionedProductServiceActionInput =
      ExecuteProvisionedProductServiceActionInput
        .builder
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(executeToken)(_.executeToken(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def executeProvisionedProductServiceActionOutput(
      recordDetail: Option[RecordDetail] = None
    ): ExecuteProvisionedProductServiceActionOutput =
      ExecuteProvisionedProductServiceActionOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .build

    def executionParameter(
      name: Option[String] = None,
      `type`: Option[String] = None,
      defaultValues: Option[List[ExecutionParameterValue]] = None
    ): ExecutionParameter =
      ExecutionParameter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(defaultValues)(_.defaultValues(_))
        .build

    def failedServiceActionAssociation(
      serviceActionId: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FailedServiceActionAssociation =
      FailedServiceActionAssociation
        .builder
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def getAWSOrganizationsAccessStatusInput(

    ): GetAWSOrganizationsAccessStatusInput =
      GetAWSOrganizationsAccessStatusInput
        .builder

        .build

    def getAWSOrganizationsAccessStatusOutput(
      accessStatus: Option[String] = None
    ): GetAWSOrganizationsAccessStatusOutput =
      GetAWSOrganizationsAccessStatusOutput
        .builder
        .ifSome(accessStatus)(_.accessStatus(_))
        .build

    def getProvisionedProductOutputsInput(
      acceptLanguage: Option[String] = None,
      provisionedProductId: Option[String] = None,
      provisionedProductName: Option[String] = None,
      outputKeys: Option[List[OutputKey]] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): GetProvisionedProductOutputsInput =
      GetProvisionedProductOutputsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(outputKeys)(_.outputKeys(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def getProvisionedProductOutputsOutput(
      outputs: Option[List[RecordOutput]] = None,
      nextPageToken: Option[String] = None
    ): GetProvisionedProductOutputsOutput =
      GetProvisionedProductOutputsOutput
        .builder
        .ifSome(outputs)(_.outputs(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def importAsProvisionedProductInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      provisionedProductName: Option[String] = None,
      physicalId: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): ImportAsProvisionedProductInput =
      ImportAsProvisionedProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(physicalId)(_.physicalId(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def importAsProvisionedProductOutput(
      recordDetail: Option[RecordDetail] = None
    ): ImportAsProvisionedProductOutput =
      ImportAsProvisionedProductOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .build

    def invalidParametersException(

    ): InvalidParametersException =
      InvalidParametersException
        .builder

        .build

    def invalidStateException(

    ): InvalidStateException =
      InvalidStateException
        .builder

        .build

    def launchPath(
      id: Option[String] = None,
      name: Option[String] = None
    ): LaunchPath =
      LaunchPath
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def launchPathSummary(
      id: Option[String] = None,
      constraintSummaries: Option[List[ConstraintSummary]] = None,
      tags: Option[List[Tag]] = None,
      name: Option[String] = None
    ): LaunchPathSummary =
      LaunchPathSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(constraintSummaries)(_.constraintSummaries(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(name)(_.name(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listAcceptedPortfolioSharesInput(
      acceptLanguage: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None,
      portfolioShareType: Option[String] = None
    ): ListAcceptedPortfolioSharesInput =
      ListAcceptedPortfolioSharesInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(portfolioShareType)(_.portfolioShareType(_))
        .build

    def listAcceptedPortfolioSharesOutput(
      portfolioDetails: Option[List[PortfolioDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListAcceptedPortfolioSharesOutput =
      ListAcceptedPortfolioSharesOutput
        .builder
        .ifSome(portfolioDetails)(_.portfolioDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listBudgetsForResourceInput(
      acceptLanguage: Option[String] = None,
      resourceId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListBudgetsForResourceInput =
      ListBudgetsForResourceInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listBudgetsForResourceOutput(
      budgets: Option[List[BudgetDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListBudgetsForResourceOutput =
      ListBudgetsForResourceOutput
        .builder
        .ifSome(budgets)(_.budgets(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listConstraintsForPortfolioInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      productId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListConstraintsForPortfolioInput =
      ListConstraintsForPortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listConstraintsForPortfolioOutput(
      constraintDetails: Option[List[ConstraintDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListConstraintsForPortfolioOutput =
      ListConstraintsForPortfolioOutput
        .builder
        .ifSome(constraintDetails)(_.constraintDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listLaunchPathsInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListLaunchPathsInput =
      ListLaunchPathsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listLaunchPathsOutput(
      launchPathSummaries: Option[List[LaunchPathSummary]] = None,
      nextPageToken: Option[String] = None
    ): ListLaunchPathsOutput =
      ListLaunchPathsOutput
        .builder
        .ifSome(launchPathSummaries)(_.launchPathSummaries(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listOrganizationPortfolioAccessInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      organizationNodeType: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListOrganizationPortfolioAccessInput =
      ListOrganizationPortfolioAccessInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(organizationNodeType)(_.organizationNodeType(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listOrganizationPortfolioAccessOutput(
      organizationNodes: Option[List[OrganizationNode]] = None,
      nextPageToken: Option[String] = None
    ): ListOrganizationPortfolioAccessOutput =
      ListOrganizationPortfolioAccessOutput
        .builder
        .ifSome(organizationNodes)(_.organizationNodes(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listPortfolioAccessInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      organizationParentId: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListPortfolioAccessInput =
      ListPortfolioAccessInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(organizationParentId)(_.organizationParentId(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listPortfolioAccessOutput(
      accountIds: Option[List[AccountId]] = None,
      nextPageToken: Option[String] = None
    ): ListPortfolioAccessOutput =
      ListPortfolioAccessOutput
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listPortfoliosForProductInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListPortfoliosForProductInput =
      ListPortfoliosForProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listPortfoliosForProductOutput(
      portfolioDetails: Option[List[PortfolioDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListPortfoliosForProductOutput =
      ListPortfoliosForProductOutput
        .builder
        .ifSome(portfolioDetails)(_.portfolioDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listPortfoliosInput(
      acceptLanguage: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListPortfoliosInput =
      ListPortfoliosInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listPortfoliosOutput(
      portfolioDetails: Option[List[PortfolioDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListPortfoliosOutput =
      ListPortfoliosOutput
        .builder
        .ifSome(portfolioDetails)(_.portfolioDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listPrincipalsForPortfolioInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListPrincipalsForPortfolioInput =
      ListPrincipalsForPortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listPrincipalsForPortfolioOutput(
      principals: Option[List[Principal]] = None,
      nextPageToken: Option[String] = None
    ): ListPrincipalsForPortfolioOutput =
      ListPrincipalsForPortfolioOutput
        .builder
        .ifSome(principals)(_.principals(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listProvisionedProductPlansInput(
      acceptLanguage: Option[String] = None,
      provisionProductId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None,
      accessLevelFilter: Option[AccessLevelFilter] = None
    ): ListProvisionedProductPlansInput =
      ListProvisionedProductPlansInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(provisionProductId)(_.provisionProductId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(accessLevelFilter)(_.accessLevelFilter(_))
        .build

    def listProvisionedProductPlansOutput(
      provisionedProductPlans: Option[List[ProvisionedProductPlanSummary]] = None,
      nextPageToken: Option[String] = None
    ): ListProvisionedProductPlansOutput =
      ListProvisionedProductPlansOutput
        .builder
        .ifSome(provisionedProductPlans)(_.provisionedProductPlans(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listProvisioningArtifactsForServiceActionInput(
      serviceActionId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): ListProvisioningArtifactsForServiceActionInput =
      ListProvisioningArtifactsForServiceActionInput
        .builder
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def listProvisioningArtifactsForServiceActionOutput(
      provisioningArtifactViews: Option[List[ProvisioningArtifactView]] = None,
      nextPageToken: Option[String] = None
    ): ListProvisioningArtifactsForServiceActionOutput =
      ListProvisioningArtifactsForServiceActionOutput
        .builder
        .ifSome(provisioningArtifactViews)(_.provisioningArtifactViews(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listProvisioningArtifactsInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None
    ): ListProvisioningArtifactsInput =
      ListProvisioningArtifactsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .build

    def listProvisioningArtifactsOutput(
      provisioningArtifactDetails: Option[List[ProvisioningArtifactDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListProvisioningArtifactsOutput =
      ListProvisioningArtifactsOutput
        .builder
        .ifSome(provisioningArtifactDetails)(_.provisioningArtifactDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listRecordHistoryInput(
      acceptLanguage: Option[String] = None,
      accessLevelFilter: Option[AccessLevelFilter] = None,
      searchFilter: Option[ListRecordHistorySearchFilter] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListRecordHistoryInput =
      ListRecordHistoryInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(accessLevelFilter)(_.accessLevelFilter(_))
        .ifSome(searchFilter)(_.searchFilter(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listRecordHistoryOutput(
      recordDetails: Option[List[RecordDetail]] = None,
      nextPageToken: Option[String] = None
    ): ListRecordHistoryOutput =
      ListRecordHistoryOutput
        .builder
        .ifSome(recordDetails)(_.recordDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listRecordHistorySearchFilter(
      key: Option[String] = None,
      value: Option[String] = None
    ): ListRecordHistorySearchFilter =
      ListRecordHistorySearchFilter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def listResourcesForTagOptionInput(
      tagOptionId: Option[String] = None,
      resourceType: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListResourcesForTagOptionInput =
      ListResourcesForTagOptionInput
        .builder
        .ifSome(tagOptionId)(_.tagOptionId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listResourcesForTagOptionOutput(
      resourceDetails: Option[List[ResourceDetail]] = None,
      pageToken: Option[String] = None
    ): ListResourcesForTagOptionOutput =
      ListResourcesForTagOptionOutput
        .builder
        .ifSome(resourceDetails)(_.resourceDetails(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listServiceActionsForProvisioningArtifactInput(
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): ListServiceActionsForProvisioningArtifactInput =
      ListServiceActionsForProvisioningArtifactInput
        .builder
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def listServiceActionsForProvisioningArtifactOutput(
      serviceActionSummaries: Option[List[ServiceActionSummary]] = None,
      nextPageToken: Option[String] = None
    ): ListServiceActionsForProvisioningArtifactOutput =
      ListServiceActionsForProvisioningArtifactOutput
        .builder
        .ifSome(serviceActionSummaries)(_.serviceActionSummaries(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listServiceActionsInput(
      acceptLanguage: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListServiceActionsInput =
      ListServiceActionsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listServiceActionsOutput(
      serviceActionSummaries: Option[List[ServiceActionSummary]] = None,
      nextPageToken: Option[String] = None
    ): ListServiceActionsOutput =
      ListServiceActionsOutput
        .builder
        .ifSome(serviceActionSummaries)(_.serviceActionSummaries(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listStackInstancesForProvisionedProductInput(
      acceptLanguage: Option[String] = None,
      provisionedProductId: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListStackInstancesForProvisionedProductInput =
      ListStackInstancesForProvisionedProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listStackInstancesForProvisionedProductOutput(
      stackInstances: Option[List[StackInstance]] = None,
      nextPageToken: Option[String] = None
    ): ListStackInstancesForProvisionedProductOutput =
      ListStackInstancesForProvisionedProductOutput
        .builder
        .ifSome(stackInstances)(_.stackInstances(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listTagOptionsFilters(
      key: Option[String] = None,
      value: Option[String] = None,
      active: Option[Boolean] = None
    ): ListTagOptionsFilters =
      ListTagOptionsFilters
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(active)(_.active(_))
        .build

    def listTagOptionsInput(
      filters: Option[ListTagOptionsFilters] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ListTagOptionsInput =
      ListTagOptionsInput
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listTagOptionsOutput(
      tagOptionDetails: Option[List[TagOptionDetail]] = None,
      pageToken: Option[String] = None
    ): ListTagOptionsOutput =
      ListTagOptionsOutput
        .builder
        .ifSome(tagOptionDetails)(_.tagOptionDetails(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def operationNotSupportedException(

    ): OperationNotSupportedException =
      OperationNotSupportedException
        .builder

        .build

    def organizationNode(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): OrganizationNode =
      OrganizationNode
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

    def parameterConstraints(
      allowedValues: Option[List[String]] = None,
      allowedPattern: Option[String] = None,
      constraintDescription: Option[String] = None,
      maxLength: Option[String] = None,
      minLength: Option[String] = None,
      maxValue: Option[String] = None,
      minValue: Option[String] = None
    ): ParameterConstraints =
      ParameterConstraints
        .builder
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(allowedPattern)(_.allowedPattern(_))
        .ifSome(constraintDescription)(_.constraintDescription(_))
        .ifSome(maxLength)(_.maxLength(_))
        .ifSome(minLength)(_.minLength(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(minValue)(_.minValue(_))
        .build

    def portfolioDetail(
      id: Option[String] = None,
      aRN: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      createdTime: Option[CreationTime] = None,
      providerName: Option[String] = None
    ): PortfolioDetail =
      PortfolioDetail
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def portfolioShareDetail(
      principalId: Option[String] = None,
      `type`: Option[String] = None,
      accepted: Option[Boolean] = None,
      shareTagOptions: Option[Boolean] = None
    ): PortfolioShareDetail =
      PortfolioShareDetail
        .builder
        .ifSome(principalId)(_.principalId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(accepted)(_.accepted(_))
        .ifSome(shareTagOptions)(_.shareTagOptions(_))
        .build

    def principal(
      principalARN: Option[String] = None,
      principalType: Option[String] = None
    ): Principal =
      Principal
        .builder
        .ifSome(principalARN)(_.principalARN(_))
        .ifSome(principalType)(_.principalType(_))
        .build

    def productViewAggregationValue(
      value: Option[String] = None,
      approximateCount: Option[Int] = None
    ): ProductViewAggregationValue =
      ProductViewAggregationValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(approximateCount)(_.approximateCount(_))
        .build

    def productViewDetail(
      productViewSummary: Option[ProductViewSummary] = None,
      status: Option[String] = None,
      productARN: Option[String] = None,
      createdTime: Option[CreatedTime] = None
    ): ProductViewDetail =
      ProductViewDetail
        .builder
        .ifSome(productViewSummary)(_.productViewSummary(_))
        .ifSome(status)(_.status(_))
        .ifSome(productARN)(_.productARN(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def productViewSummary(
      id: Option[String] = None,
      productId: Option[String] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      shortDescription: Option[String] = None,
      `type`: Option[String] = None,
      distributor: Option[String] = None,
      hasDefaultPath: Option[Boolean] = None,
      supportEmail: Option[String] = None,
      supportDescription: Option[String] = None,
      supportUrl: Option[String] = None
    ): ProductViewSummary =
      ProductViewSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(shortDescription)(_.shortDescription(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(distributor)(_.distributor(_))
        .ifSome(hasDefaultPath)(_.hasDefaultPath(_))
        .ifSome(supportEmail)(_.supportEmail(_))
        .ifSome(supportDescription)(_.supportDescription(_))
        .ifSome(supportUrl)(_.supportUrl(_))
        .build

    def provisionProductInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      productName: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      provisioningArtifactName: Option[String] = None,
      pathId: Option[String] = None,
      pathName: Option[String] = None,
      provisionedProductName: Option[String] = None,
      provisioningParameters: Option[List[ProvisioningParameter]] = None,
      provisioningPreferences: Option[ProvisioningPreferences] = None,
      tags: Option[List[Tag]] = None,
      notificationArns: Option[List[NotificationArn]] = None,
      provisionToken: Option[String] = None
    ): ProvisionProductInput =
      ProvisionProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(provisioningArtifactName)(_.provisioningArtifactName(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(pathName)(_.pathName(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(provisioningParameters)(_.provisioningParameters(_))
        .ifSome(provisioningPreferences)(_.provisioningPreferences(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(notificationArns)(_.notificationArns(_))
        .ifSome(provisionToken)(_.provisionToken(_))
        .build

    def provisionProductOutput(
      recordDetail: Option[RecordDetail] = None
    ): ProvisionProductOutput =
      ProvisionProductOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .build

    def provisionedProductAttribute(
      name: Option[String] = None,
      arn: Option[String] = None,
      `type`: Option[String] = None,
      id: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      createdTime: Option[CreatedTime] = None,
      idempotencyToken: Option[String] = None,
      lastRecordId: Option[String] = None,
      lastProvisioningRecordId: Option[String] = None,
      lastSuccessfulProvisioningRecordId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      physicalId: Option[String] = None,
      productId: Option[String] = None,
      productName: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      provisioningArtifactName: Option[String] = None,
      userArn: Option[String] = None,
      userArnSession: Option[String] = None
    ): ProvisionedProductAttribute =
      ProvisionedProductAttribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(lastRecordId)(_.lastRecordId(_))
        .ifSome(lastProvisioningRecordId)(_.lastProvisioningRecordId(_))
        .ifSome(lastSuccessfulProvisioningRecordId)(_.lastSuccessfulProvisioningRecordId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(physicalId)(_.physicalId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(provisioningArtifactName)(_.provisioningArtifactName(_))
        .ifSome(userArn)(_.userArn(_))
        .ifSome(userArnSession)(_.userArnSession(_))
        .build

    def provisionedProductDetail(
      name: Option[String] = None,
      arn: Option[String] = None,
      `type`: Option[String] = None,
      id: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      createdTime: Option[CreatedTime] = None,
      idempotencyToken: Option[String] = None,
      lastRecordId: Option[String] = None,
      lastProvisioningRecordId: Option[String] = None,
      lastSuccessfulProvisioningRecordId: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      launchRoleArn: Option[String] = None
    ): ProvisionedProductDetail =
      ProvisionedProductDetail
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(lastRecordId)(_.lastRecordId(_))
        .ifSome(lastProvisioningRecordId)(_.lastProvisioningRecordId(_))
        .ifSome(lastSuccessfulProvisioningRecordId)(_.lastSuccessfulProvisioningRecordId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(launchRoleArn)(_.launchRoleArn(_))
        .build

    def provisionedProductPlanDetails(
      createdTime: Option[CreatedTime] = None,
      pathId: Option[String] = None,
      productId: Option[String] = None,
      planName: Option[String] = None,
      planId: Option[String] = None,
      provisionProductId: Option[String] = None,
      provisionProductName: Option[String] = None,
      planType: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      status: Option[String] = None,
      updatedTime: Option[UpdatedTime] = None,
      notificationArns: Option[List[NotificationArn]] = None,
      provisioningParameters: Option[List[UpdateProvisioningParameter]] = None,
      tags: Option[List[Tag]] = None,
      statusMessage: Option[String] = None
    ): ProvisionedProductPlanDetails =
      ProvisionedProductPlanDetails
        .builder
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(planName)(_.planName(_))
        .ifSome(planId)(_.planId(_))
        .ifSome(provisionProductId)(_.provisionProductId(_))
        .ifSome(provisionProductName)(_.provisionProductName(_))
        .ifSome(planType)(_.planType(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(status)(_.status(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .ifSome(notificationArns)(_.notificationArns(_))
        .ifSome(provisioningParameters)(_.provisioningParameters(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .build

    def provisionedProductPlanSummary(
      planName: Option[String] = None,
      planId: Option[String] = None,
      provisionProductId: Option[String] = None,
      provisionProductName: Option[String] = None,
      planType: Option[String] = None,
      provisioningArtifactId: Option[String] = None
    ): ProvisionedProductPlanSummary =
      ProvisionedProductPlanSummary
        .builder
        .ifSome(planName)(_.planName(_))
        .ifSome(planId)(_.planId(_))
        .ifSome(provisionProductId)(_.provisionProductId(_))
        .ifSome(provisionProductName)(_.provisionProductName(_))
        .ifSome(planType)(_.planType(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .build

    def provisioningArtifact(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      createdTime: Option[ProvisioningArtifactCreatedTime] = None,
      guidance: Option[String] = None
    ): ProvisioningArtifact =
      ProvisioningArtifact
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(guidance)(_.guidance(_))
        .build

    def provisioningArtifactDetail(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      createdTime: Option[CreationTime] = None,
      active: Option[Boolean] = None,
      guidance: Option[String] = None
    ): ProvisioningArtifactDetail =
      ProvisioningArtifactDetail
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(active)(_.active(_))
        .ifSome(guidance)(_.guidance(_))
        .build

    def provisioningArtifactOutput(
      key: Option[String] = None,
      description: Option[String] = None
    ): ProvisioningArtifactOutput =
      ProvisioningArtifactOutput
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(description)(_.description(_))
        .build

    def provisioningArtifactParameter(
      parameterKey: Option[String] = None,
      defaultValue: Option[String] = None,
      parameterType: Option[String] = None,
      isNoEcho: Option[Boolean] = None,
      description: Option[String] = None,
      parameterConstraints: Option[ParameterConstraints] = None
    ): ProvisioningArtifactParameter =
      ProvisioningArtifactParameter
        .builder
        .ifSome(parameterKey)(_.parameterKey(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(parameterType)(_.parameterType(_))
        .ifSome(isNoEcho)(_.isNoEcho(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameterConstraints)(_.parameterConstraints(_))
        .build

    def provisioningArtifactPreferences(
      stackSetAccounts: Option[List[AccountId]] = None,
      stackSetRegions: Option[List[Region]] = None
    ): ProvisioningArtifactPreferences =
      ProvisioningArtifactPreferences
        .builder
        .ifSome(stackSetAccounts)(_.stackSetAccounts(_))
        .ifSome(stackSetRegions)(_.stackSetRegions(_))
        .build

    def provisioningArtifactProperties(
      name: Option[String] = None,
      description: Option[String] = None,
      info: Option[ProvisioningArtifactInfo] = None,
      `type`: Option[String] = None,
      disableTemplateValidation: Option[Boolean] = None
    ): ProvisioningArtifactProperties =
      ProvisioningArtifactProperties
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(info)(_.info(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(disableTemplateValidation)(_.disableTemplateValidation(_))
        .build

    def provisioningArtifactSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      createdTime: Option[ProvisioningArtifactCreatedTime] = None,
      provisioningArtifactMetadata: Option[ProvisioningArtifactInfo] = None
    ): ProvisioningArtifactSummary =
      ProvisioningArtifactSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(provisioningArtifactMetadata)(_.provisioningArtifactMetadata(_))
        .build

    def provisioningArtifactView(
      productViewSummary: Option[ProductViewSummary] = None,
      provisioningArtifact: Option[ProvisioningArtifact] = None
    ): ProvisioningArtifactView =
      ProvisioningArtifactView
        .builder
        .ifSome(productViewSummary)(_.productViewSummary(_))
        .ifSome(provisioningArtifact)(_.provisioningArtifact(_))
        .build

    def provisioningParameter(
      key: Option[String] = None,
      value: Option[String] = None
    ): ProvisioningParameter =
      ProvisioningParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def provisioningPreferences(
      stackSetAccounts: Option[List[AccountId]] = None,
      stackSetRegions: Option[List[Region]] = None,
      stackSetFailureToleranceCount: Option[Int] = None,
      stackSetFailureTolerancePercentage: Option[Int] = None,
      stackSetMaxConcurrencyCount: Option[Int] = None,
      stackSetMaxConcurrencyPercentage: Option[Int] = None
    ): ProvisioningPreferences =
      ProvisioningPreferences
        .builder
        .ifSome(stackSetAccounts)(_.stackSetAccounts(_))
        .ifSome(stackSetRegions)(_.stackSetRegions(_))
        .ifSome(stackSetFailureToleranceCount)(_.stackSetFailureToleranceCount(_))
        .ifSome(stackSetFailureTolerancePercentage)(_.stackSetFailureTolerancePercentage(_))
        .ifSome(stackSetMaxConcurrencyCount)(_.stackSetMaxConcurrencyCount(_))
        .ifSome(stackSetMaxConcurrencyPercentage)(_.stackSetMaxConcurrencyPercentage(_))
        .build

    def recordDetail(
      recordId: Option[String] = None,
      provisionedProductName: Option[String] = None,
      status: Option[String] = None,
      createdTime: Option[CreatedTime] = None,
      updatedTime: Option[UpdatedTime] = None,
      provisionedProductType: Option[String] = None,
      recordType: Option[String] = None,
      provisionedProductId: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      pathId: Option[String] = None,
      recordErrors: Option[List[RecordError]] = None,
      recordTags: Option[List[RecordTag]] = None,
      launchRoleArn: Option[String] = None
    ): RecordDetail =
      RecordDetail
        .builder
        .ifSome(recordId)(_.recordId(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .ifSome(provisionedProductType)(_.provisionedProductType(_))
        .ifSome(recordType)(_.recordType(_))
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(recordErrors)(_.recordErrors(_))
        .ifSome(recordTags)(_.recordTags(_))
        .ifSome(launchRoleArn)(_.launchRoleArn(_))
        .build

    def recordError(
      code: Option[String] = None,
      description: Option[String] = None
    ): RecordError =
      RecordError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(description)(_.description(_))
        .build

    def recordOutput(
      outputKey: Option[String] = None,
      outputValue: Option[String] = None,
      description: Option[String] = None
    ): RecordOutput =
      RecordOutput
        .builder
        .ifSome(outputKey)(_.outputKey(_))
        .ifSome(outputValue)(_.outputValue(_))
        .ifSome(description)(_.description(_))
        .build

    def recordTag(
      key: Option[String] = None,
      value: Option[String] = None
    ): RecordTag =
      RecordTag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def rejectPortfolioShareInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      portfolioShareType: Option[String] = None
    ): RejectPortfolioShareInput =
      RejectPortfolioShareInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(portfolioShareType)(_.portfolioShareType(_))
        .build

    def rejectPortfolioShareOutput(

    ): RejectPortfolioShareOutput =
      RejectPortfolioShareOutput
        .builder

        .build

    def resourceChange(
      action: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      resourceType: Option[String] = None,
      replacement: Option[String] = None,
      scope: Option[List[ResourceAttribute]] = None,
      details: Option[List[ResourceChangeDetail]] = None
    ): ResourceChange =
      ResourceChange
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(replacement)(_.replacement(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(details)(_.details(_))
        .build

    def resourceChangeDetail(
      target: Option[ResourceTargetDefinition] = None,
      evaluation: Option[String] = None,
      causingEntity: Option[String] = None
    ): ResourceChangeDetail =
      ResourceChangeDetail
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(evaluation)(_.evaluation(_))
        .ifSome(causingEntity)(_.causingEntity(_))
        .build

    def resourceDetail(
      id: Option[String] = None,
      aRN: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      createdTime: Option[ResourceDetailCreatedTime] = None
    ): ResourceDetail =
      ResourceDetail
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def resourceInUseException(

    ): ResourceInUseException =
      ResourceInUseException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourceTargetDefinition(
      attribute: Option[String] = None,
      name: Option[String] = None,
      requiresRecreation: Option[String] = None
    ): ResourceTargetDefinition =
      ResourceTargetDefinition
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(name)(_.name(_))
        .ifSome(requiresRecreation)(_.requiresRecreation(_))
        .build

    def scanProvisionedProductsInput(
      acceptLanguage: Option[String] = None,
      accessLevelFilter: Option[AccessLevelFilter] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): ScanProvisionedProductsInput =
      ScanProvisionedProductsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(accessLevelFilter)(_.accessLevelFilter(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def scanProvisionedProductsOutput(
      provisionedProducts: Option[List[ProvisionedProductDetail]] = None,
      nextPageToken: Option[String] = None
    ): ScanProvisionedProductsOutput =
      ScanProvisionedProductsOutput
        .builder
        .ifSome(provisionedProducts)(_.provisionedProducts(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def searchProductsAsAdminInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      filters: Option[ProductViewFilters] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      pageToken: Option[String] = None,
      pageSize: Option[Int] = None,
      productSource: Option[String] = None
    ): SearchProductsAsAdminInput =
      SearchProductsAsAdminInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(pageToken)(_.pageToken(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(productSource)(_.productSource(_))
        .build

    def searchProductsAsAdminOutput(
      productViewDetails: Option[List[ProductViewDetail]] = None,
      nextPageToken: Option[String] = None
    ): SearchProductsAsAdminOutput =
      SearchProductsAsAdminOutput
        .builder
        .ifSome(productViewDetails)(_.productViewDetails(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def searchProductsInput(
      acceptLanguage: Option[String] = None,
      filters: Option[ProductViewFilters] = None,
      pageSize: Option[Int] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      pageToken: Option[String] = None
    ): SearchProductsInput =
      SearchProductsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def searchProductsOutput(
      productViewSummaries: Option[List[ProductViewSummary]] = None,
      productViewAggregations: Option[ProductViewAggregations] = None,
      nextPageToken: Option[String] = None
    ): SearchProductsOutput =
      SearchProductsOutput
        .builder
        .ifSome(productViewSummaries)(_.productViewSummaries(_))
        .ifSome(productViewAggregations)(_.productViewAggregations(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def searchProvisionedProductsInput(
      acceptLanguage: Option[String] = None,
      accessLevelFilter: Option[AccessLevelFilter] = None,
      filters: Option[ProvisionedProductFilters] = None,
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      pageSize: Option[Int] = None,
      pageToken: Option[String] = None
    ): SearchProvisionedProductsInput =
      SearchProvisionedProductsInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(accessLevelFilter)(_.accessLevelFilter(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def searchProvisionedProductsOutput(
      provisionedProducts: Option[List[ProvisionedProductAttribute]] = None,
      totalResultsCount: Option[Int] = None,
      nextPageToken: Option[String] = None
    ): SearchProvisionedProductsOutput =
      SearchProvisionedProductsOutput
        .builder
        .ifSome(provisionedProducts)(_.provisionedProducts(_))
        .ifSome(totalResultsCount)(_.totalResultsCount(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def serviceActionAssociation(
      serviceActionId: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None
    ): ServiceActionAssociation =
      ServiceActionAssociation
        .builder
        .ifSome(serviceActionId)(_.serviceActionId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .build

    def serviceActionDetail(
      serviceActionSummary: Option[ServiceActionSummary] = None,
      definition: Option[ServiceActionDefinitionMap] = None
    ): ServiceActionDetail =
      ServiceActionDetail
        .builder
        .ifSome(serviceActionSummary)(_.serviceActionSummary(_))
        .ifSome(definition)(_.definition(_))
        .build

    def serviceActionSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      definitionType: Option[String] = None
    ): ServiceActionSummary =
      ServiceActionSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(definitionType)(_.definitionType(_))
        .build

    def shareDetails(
      successfulShares: Option[List[AccountId]] = None,
      shareErrors: Option[List[ShareError]] = None
    ): ShareDetails =
      ShareDetails
        .builder
        .ifSome(successfulShares)(_.successfulShares(_))
        .ifSome(shareErrors)(_.shareErrors(_))
        .build

    def shareError(
      accounts: Option[List[AccountId]] = None,
      message: Option[String] = None,
      error: Option[String] = None
    ): ShareError =
      ShareError
        .builder
        .ifSome(accounts)(_.accounts(_))
        .ifSome(message)(_.message(_))
        .ifSome(error)(_.error(_))
        .build

    def stackInstance(
      account: Option[String] = None,
      region: Option[String] = None,
      stackInstanceStatus: Option[String] = None
    ): StackInstance =
      StackInstance
        .builder
        .ifSome(account)(_.account(_))
        .ifSome(region)(_.region(_))
        .ifSome(stackInstanceStatus)(_.stackInstanceStatus(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagOptionDetail(
      key: Option[String] = None,
      value: Option[String] = None,
      active: Option[Boolean] = None,
      id: Option[String] = None,
      owner: Option[String] = None
    ): TagOptionDetail =
      TagOptionDetail
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(active)(_.active(_))
        .ifSome(id)(_.id(_))
        .ifSome(owner)(_.owner(_))
        .build

    def tagOptionNotMigratedException(

    ): TagOptionNotMigratedException =
      TagOptionNotMigratedException
        .builder

        .build

    def tagOptionSummary(
      key: Option[String] = None,
      values: Option[List[TagOptionValue]] = None
    ): TagOptionSummary =
      TagOptionSummary
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def terminateProvisionedProductInput(
      provisionedProductName: Option[String] = None,
      provisionedProductId: Option[String] = None,
      terminateToken: Option[String] = None,
      ignoreErrors: Option[Boolean] = None,
      acceptLanguage: Option[String] = None,
      retainPhysicalResources: Option[Boolean] = None
    ): TerminateProvisionedProductInput =
      TerminateProvisionedProductInput
        .builder
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(terminateToken)(_.terminateToken(_))
        .ifSome(ignoreErrors)(_.ignoreErrors(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(retainPhysicalResources)(_.retainPhysicalResources(_))
        .build

    def terminateProvisionedProductOutput(
      recordDetail: Option[RecordDetail] = None
    ): TerminateProvisionedProductOutput =
      TerminateProvisionedProductOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .build

    def updateConstraintInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[String] = None
    ): UpdateConstraintInput =
      UpdateConstraintInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def updateConstraintOutput(
      constraintDetail: Option[ConstraintDetail] = None,
      constraintParameters: Option[String] = None,
      status: Option[String] = None
    ): UpdateConstraintOutput =
      UpdateConstraintOutput
        .builder
        .ifSome(constraintDetail)(_.constraintDetail(_))
        .ifSome(constraintParameters)(_.constraintParameters(_))
        .ifSome(status)(_.status(_))
        .build

    def updatePortfolioInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      providerName: Option[String] = None,
      addTags: Option[List[Tag]] = None,
      removeTags: Option[List[TagKey]] = None
    ): UpdatePortfolioInput =
      UpdatePortfolioInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(providerName)(_.providerName(_))
        .ifSome(addTags)(_.addTags(_))
        .ifSome(removeTags)(_.removeTags(_))
        .build

    def updatePortfolioOutput(
      portfolioDetail: Option[PortfolioDetail] = None,
      tags: Option[List[Tag]] = None
    ): UpdatePortfolioOutput =
      UpdatePortfolioOutput
        .builder
        .ifSome(portfolioDetail)(_.portfolioDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updatePortfolioShareInput(
      acceptLanguage: Option[String] = None,
      portfolioId: Option[String] = None,
      accountId: Option[String] = None,
      organizationNode: Option[OrganizationNode] = None,
      shareTagOptions: Option[Boolean] = None
    ): UpdatePortfolioShareInput =
      UpdatePortfolioShareInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(portfolioId)(_.portfolioId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(organizationNode)(_.organizationNode(_))
        .ifSome(shareTagOptions)(_.shareTagOptions(_))
        .build

    def updatePortfolioShareOutput(
      portfolioShareToken: Option[String] = None,
      status: Option[String] = None
    ): UpdatePortfolioShareOutput =
      UpdatePortfolioShareOutput
        .builder
        .ifSome(portfolioShareToken)(_.portfolioShareToken(_))
        .ifSome(status)(_.status(_))
        .build

    def updateProductInput(
      acceptLanguage: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      description: Option[String] = None,
      distributor: Option[String] = None,
      supportDescription: Option[String] = None,
      supportEmail: Option[String] = None,
      supportUrl: Option[String] = None,
      addTags: Option[List[Tag]] = None,
      removeTags: Option[List[TagKey]] = None
    ): UpdateProductInput =
      UpdateProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(description)(_.description(_))
        .ifSome(distributor)(_.distributor(_))
        .ifSome(supportDescription)(_.supportDescription(_))
        .ifSome(supportEmail)(_.supportEmail(_))
        .ifSome(supportUrl)(_.supportUrl(_))
        .ifSome(addTags)(_.addTags(_))
        .ifSome(removeTags)(_.removeTags(_))
        .build

    def updateProductOutput(
      productViewDetail: Option[ProductViewDetail] = None,
      tags: Option[List[Tag]] = None
    ): UpdateProductOutput =
      UpdateProductOutput
        .builder
        .ifSome(productViewDetail)(_.productViewDetail(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateProvisionedProductInput(
      acceptLanguage: Option[String] = None,
      provisionedProductName: Option[String] = None,
      provisionedProductId: Option[String] = None,
      productId: Option[String] = None,
      productName: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      provisioningArtifactName: Option[String] = None,
      pathId: Option[String] = None,
      pathName: Option[String] = None,
      provisioningParameters: Option[List[UpdateProvisioningParameter]] = None,
      provisioningPreferences: Option[UpdateProvisioningPreferences] = None,
      tags: Option[List[Tag]] = None,
      updateToken: Option[String] = None
    ): UpdateProvisionedProductInput =
      UpdateProvisionedProductInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(provisionedProductName)(_.provisionedProductName(_))
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(productName)(_.productName(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(provisioningArtifactName)(_.provisioningArtifactName(_))
        .ifSome(pathId)(_.pathId(_))
        .ifSome(pathName)(_.pathName(_))
        .ifSome(provisioningParameters)(_.provisioningParameters(_))
        .ifSome(provisioningPreferences)(_.provisioningPreferences(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updateToken)(_.updateToken(_))
        .build

    def updateProvisionedProductOutput(
      recordDetail: Option[RecordDetail] = None
    ): UpdateProvisionedProductOutput =
      UpdateProvisionedProductOutput
        .builder
        .ifSome(recordDetail)(_.recordDetail(_))
        .build

    def updateProvisionedProductPropertiesInput(
      acceptLanguage: Option[String] = None,
      provisionedProductId: Option[String] = None,
      provisionedProductProperties: Option[ProvisionedProductProperties] = None,
      idempotencyToken: Option[String] = None
    ): UpdateProvisionedProductPropertiesInput =
      UpdateProvisionedProductPropertiesInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(provisionedProductProperties)(_.provisionedProductProperties(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def updateProvisionedProductPropertiesOutput(
      provisionedProductId: Option[String] = None,
      provisionedProductProperties: Option[ProvisionedProductProperties] = None,
      recordId: Option[String] = None,
      status: Option[String] = None
    ): UpdateProvisionedProductPropertiesOutput =
      UpdateProvisionedProductPropertiesOutput
        .builder
        .ifSome(provisionedProductId)(_.provisionedProductId(_))
        .ifSome(provisionedProductProperties)(_.provisionedProductProperties(_))
        .ifSome(recordId)(_.recordId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateProvisioningArtifactInput(
      acceptLanguage: Option[String] = None,
      productId: Option[String] = None,
      provisioningArtifactId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      active: Option[Boolean] = None,
      guidance: Option[String] = None
    ): UpdateProvisioningArtifactInput =
      UpdateProvisioningArtifactInput
        .builder
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(provisioningArtifactId)(_.provisioningArtifactId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(active)(_.active(_))
        .ifSome(guidance)(_.guidance(_))
        .build

    def updateProvisioningArtifactOutput(
      provisioningArtifactDetail: Option[ProvisioningArtifactDetail] = None,
      info: Option[ProvisioningArtifactInfo] = None,
      status: Option[String] = None
    ): UpdateProvisioningArtifactOutput =
      UpdateProvisioningArtifactOutput
        .builder
        .ifSome(provisioningArtifactDetail)(_.provisioningArtifactDetail(_))
        .ifSome(info)(_.info(_))
        .ifSome(status)(_.status(_))
        .build

    def updateProvisioningParameter(
      key: Option[String] = None,
      value: Option[String] = None,
      usePreviousValue: Option[Boolean] = None
    ): UpdateProvisioningParameter =
      UpdateProvisioningParameter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(usePreviousValue)(_.usePreviousValue(_))
        .build

    def updateProvisioningPreferences(
      stackSetAccounts: Option[List[AccountId]] = None,
      stackSetRegions: Option[List[Region]] = None,
      stackSetFailureToleranceCount: Option[Int] = None,
      stackSetFailureTolerancePercentage: Option[Int] = None,
      stackSetMaxConcurrencyCount: Option[Int] = None,
      stackSetMaxConcurrencyPercentage: Option[Int] = None,
      stackSetOperationType: Option[String] = None
    ): UpdateProvisioningPreferences =
      UpdateProvisioningPreferences
        .builder
        .ifSome(stackSetAccounts)(_.stackSetAccounts(_))
        .ifSome(stackSetRegions)(_.stackSetRegions(_))
        .ifSome(stackSetFailureToleranceCount)(_.stackSetFailureToleranceCount(_))
        .ifSome(stackSetFailureTolerancePercentage)(_.stackSetFailureTolerancePercentage(_))
        .ifSome(stackSetMaxConcurrencyCount)(_.stackSetMaxConcurrencyCount(_))
        .ifSome(stackSetMaxConcurrencyPercentage)(_.stackSetMaxConcurrencyPercentage(_))
        .ifSome(stackSetOperationType)(_.stackSetOperationType(_))
        .build

    def updateServiceActionInput(
      id: Option[String] = None,
      name: Option[String] = None,
      definition: Option[ServiceActionDefinitionMap] = None,
      description: Option[String] = None,
      acceptLanguage: Option[String] = None
    ): UpdateServiceActionInput =
      UpdateServiceActionInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(description)(_.description(_))
        .ifSome(acceptLanguage)(_.acceptLanguage(_))
        .build

    def updateServiceActionOutput(
      serviceActionDetail: Option[ServiceActionDetail] = None
    ): UpdateServiceActionOutput =
      UpdateServiceActionOutput
        .builder
        .ifSome(serviceActionDetail)(_.serviceActionDetail(_))
        .build

    def updateTagOptionInput(
      id: Option[String] = None,
      value: Option[String] = None,
      active: Option[Boolean] = None
    ): UpdateTagOptionInput =
      UpdateTagOptionInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(value)(_.value(_))
        .ifSome(active)(_.active(_))
        .build

    def updateTagOptionOutput(
      tagOptionDetail: Option[TagOptionDetail] = None
    ): UpdateTagOptionOutput =
      UpdateTagOptionOutput
        .builder
        .ifSome(tagOptionDetail)(_.tagOptionDetail(_))
        .build

    def usageInstruction(
      `type`: Option[String] = None,
      value: Option[String] = None
    ): UsageInstruction =
      UsageInstruction
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
