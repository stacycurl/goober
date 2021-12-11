package goober.hi

import goober.free.iotsitewise.IoTSiteWiseIO
import software.amazon.awssdk.services.iotsitewise.model._


object iotsitewise {
  import goober.free.{iotsitewise ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessPolicySummary(
      id: Option[String] = None,
      identity: Option[Identity] = None,
      resource: Option[Resource] = None,
      permission: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None
    ): AccessPolicySummary =
      AccessPolicySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(identity)(_.identity(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(permission)(_.permission(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .build

    def aggregatedValue(
      timestamp: Option[Timestamp] = None,
      quality: Option[String] = None,
      value: Option[Aggregates] = None
    ): AggregatedValue =
      AggregatedValue
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(quality)(_.quality(_))
        .ifSome(value)(_.value(_))
        .build

    def aggregates(
      average: Option[AggregatedDoubleValue] = None,
      count: Option[AggregatedDoubleValue] = None,
      maximum: Option[AggregatedDoubleValue] = None,
      minimum: Option[AggregatedDoubleValue] = None,
      sum: Option[AggregatedDoubleValue] = None,
      standardDeviation: Option[AggregatedDoubleValue] = None
    ): Aggregates =
      Aggregates
        .builder
        .ifSome(average)(_.average(_))
        .ifSome(count)(_.count(_))
        .ifSome(maximum)(_.maximum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(standardDeviation)(_.standardDeviation(_))
        .build

    def alarms(
      alarmRoleArn: Option[String] = None,
      notificationLambdaArn: Option[String] = None
    ): Alarms =
      Alarms
        .builder
        .ifSome(alarmRoleArn)(_.alarmRoleArn(_))
        .ifSome(notificationLambdaArn)(_.notificationLambdaArn(_))
        .build

    def assetCompositeModel(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      properties: Option[List[AssetProperty]] = None
    ): AssetCompositeModel =
      AssetCompositeModel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(properties)(_.properties(_))
        .build

    def assetErrorDetails(
      assetId: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): AssetErrorDetails =
      AssetErrorDetails
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def assetHierarchy(
      id: Option[String] = None,
      name: Option[String] = None
    ): AssetHierarchy =
      AssetHierarchy
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .build

    def assetHierarchyInfo(
      parentAssetId: Option[String] = None,
      childAssetId: Option[String] = None
    ): AssetHierarchyInfo =
      AssetHierarchyInfo
        .builder
        .ifSome(parentAssetId)(_.parentAssetId(_))
        .ifSome(childAssetId)(_.childAssetId(_))
        .build

    def assetModelCompositeModel(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      properties: Option[List[AssetModelProperty]] = None
    ): AssetModelCompositeModel =
      AssetModelCompositeModel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(properties)(_.properties(_))
        .build

    def assetModelCompositeModelDefinition(
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      properties: Option[List[AssetModelPropertyDefinition]] = None
    ): AssetModelCompositeModelDefinition =
      AssetModelCompositeModelDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(properties)(_.properties(_))
        .build

    def assetModelHierarchy(
      id: Option[String] = None,
      name: Option[String] = None,
      childAssetModelId: Option[String] = None
    ): AssetModelHierarchy =
      AssetModelHierarchy
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(childAssetModelId)(_.childAssetModelId(_))
        .build

    def assetModelHierarchyDefinition(
      name: Option[String] = None,
      childAssetModelId: Option[String] = None
    ): AssetModelHierarchyDefinition =
      AssetModelHierarchyDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(childAssetModelId)(_.childAssetModelId(_))
        .build

    def assetModelProperty(
      id: Option[String] = None,
      name: Option[String] = None,
      dataType: Option[String] = None,
      dataTypeSpec: Option[String] = None,
      unit: Option[String] = None,
      `type`: Option[PropertyType] = None
    ): AssetModelProperty =
      AssetModelProperty
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(dataTypeSpec)(_.dataTypeSpec(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def assetModelPropertyDefinition(
      name: Option[String] = None,
      dataType: Option[String] = None,
      dataTypeSpec: Option[String] = None,
      unit: Option[String] = None,
      `type`: Option[PropertyType] = None
    ): AssetModelPropertyDefinition =
      AssetModelPropertyDefinition
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(dataTypeSpec)(_.dataTypeSpec(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def assetModelStatus(
      state: Option[String] = None,
      error: Option[ErrorDetails] = None
    ): AssetModelStatus =
      AssetModelStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(error)(_.error(_))
        .build

    def assetModelSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None,
      status: Option[AssetModelStatus] = None
    ): AssetModelSummary =
      AssetModelSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .ifSome(status)(_.status(_))
        .build

    def assetProperty(
      id: Option[String] = None,
      name: Option[String] = None,
      alias: Option[String] = None,
      notification: Option[PropertyNotification] = None,
      dataType: Option[String] = None,
      dataTypeSpec: Option[String] = None,
      unit: Option[String] = None
    ): AssetProperty =
      AssetProperty
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(dataTypeSpec)(_.dataTypeSpec(_))
        .ifSome(unit)(_.unit(_))
        .build

    def assetPropertyValue(
      value: Option[Variant] = None,
      timestamp: Option[TimeInNanos] = None,
      quality: Option[String] = None
    ): AssetPropertyValue =
      AssetPropertyValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(quality)(_.quality(_))
        .build

    def assetRelationshipSummary(
      hierarchyInfo: Option[AssetHierarchyInfo] = None,
      relationshipType: Option[String] = None
    ): AssetRelationshipSummary =
      AssetRelationshipSummary
        .builder
        .ifSome(hierarchyInfo)(_.hierarchyInfo(_))
        .ifSome(relationshipType)(_.relationshipType(_))
        .build

    def assetStatus(
      state: Option[String] = None,
      error: Option[ErrorDetails] = None
    ): AssetStatus =
      AssetStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(error)(_.error(_))
        .build

    def assetSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      assetModelId: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None,
      status: Option[AssetStatus] = None,
      hierarchies: Option[List[AssetHierarchy]] = None
    ): AssetSummary =
      AssetSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(hierarchies)(_.hierarchies(_))
        .build

    def associateAssetsRequest(
      assetId: Option[String] = None,
      hierarchyId: Option[String] = None,
      childAssetId: Option[String] = None,
      clientToken: Option[String] = None
    ): AssociateAssetsRequest =
      AssociateAssetsRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(hierarchyId)(_.hierarchyId(_))
        .ifSome(childAssetId)(_.childAssetId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def associatedAssetsSummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      assetModelId: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None,
      status: Option[AssetStatus] = None,
      hierarchies: Option[List[AssetHierarchy]] = None
    ): AssociatedAssetsSummary =
      AssociatedAssetsSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(hierarchies)(_.hierarchies(_))
        .build

    def attribute(
      defaultValue: Option[String] = None
    ): Attribute =
      Attribute
        .builder
        .ifSome(defaultValue)(_.defaultValue(_))
        .build

    def batchAssociateProjectAssetsRequest(
      projectId: Option[String] = None,
      assetIds: Option[List[ID]] = None,
      clientToken: Option[String] = None
    ): BatchAssociateProjectAssetsRequest =
      BatchAssociateProjectAssetsRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(assetIds)(_.assetIds(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def batchAssociateProjectAssetsResponse(
      errors: Option[List[AssetErrorDetails]] = None
    ): BatchAssociateProjectAssetsResponse =
      BatchAssociateProjectAssetsResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDisassociateProjectAssetsRequest(
      projectId: Option[String] = None,
      assetIds: Option[List[ID]] = None,
      clientToken: Option[String] = None
    ): BatchDisassociateProjectAssetsRequest =
      BatchDisassociateProjectAssetsRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(assetIds)(_.assetIds(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def batchDisassociateProjectAssetsResponse(
      errors: Option[List[AssetErrorDetails]] = None
    ): BatchDisassociateProjectAssetsResponse =
      BatchDisassociateProjectAssetsResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchPutAssetPropertyError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      timestamps: Option[List[TimeInNanos]] = None
    ): BatchPutAssetPropertyError =
      BatchPutAssetPropertyError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(timestamps)(_.timestamps(_))
        .build

    def batchPutAssetPropertyErrorEntry(
      entryId: Option[String] = None,
      errors: Option[List[BatchPutAssetPropertyError]] = None
    ): BatchPutAssetPropertyErrorEntry =
      BatchPutAssetPropertyErrorEntry
        .builder
        .ifSome(entryId)(_.entryId(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchPutAssetPropertyValueRequest(
      entries: Option[List[PutAssetPropertyValueEntry]] = None
    ): BatchPutAssetPropertyValueRequest =
      BatchPutAssetPropertyValueRequest
        .builder
        .ifSome(entries)(_.entries(_))
        .build

    def batchPutAssetPropertyValueResponse(
      errorEntries: Option[List[BatchPutAssetPropertyErrorEntry]] = None
    ): BatchPutAssetPropertyValueResponse =
      BatchPutAssetPropertyValueResponse
        .builder
        .ifSome(errorEntries)(_.errorEntries(_))
        .build

    def compositeModelProperty(
      name: Option[String] = None,
      `type`: Option[String] = None,
      assetProperty: Option[Property] = None
    ): CompositeModelProperty =
      CompositeModelProperty
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(assetProperty)(_.assetProperty(_))
        .build

    def configurationErrorDetails(
      code: Option[String] = None,
      message: Option[String] = None
    ): ConfigurationErrorDetails =
      ConfigurationErrorDetails
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def configurationStatus(
      state: Option[String] = None,
      error: Option[ConfigurationErrorDetails] = None
    ): ConfigurationStatus =
      ConfigurationStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(error)(_.error(_))
        .build

    def conflictingOperationException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceArn: Option[String] = None
    ): ConflictingOperationException =
      ConflictingOperationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def createAccessPolicyRequest(
      accessPolicyIdentity: Option[Identity] = None,
      accessPolicyResource: Option[Resource] = None,
      accessPolicyPermission: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateAccessPolicyRequest =
      CreateAccessPolicyRequest
        .builder
        .ifSome(accessPolicyIdentity)(_.accessPolicyIdentity(_))
        .ifSome(accessPolicyResource)(_.accessPolicyResource(_))
        .ifSome(accessPolicyPermission)(_.accessPolicyPermission(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAccessPolicyResponse(
      accessPolicyId: Option[String] = None,
      accessPolicyArn: Option[String] = None
    ): CreateAccessPolicyResponse =
      CreateAccessPolicyResponse
        .builder
        .ifSome(accessPolicyId)(_.accessPolicyId(_))
        .ifSome(accessPolicyArn)(_.accessPolicyArn(_))
        .build

    def createAssetModelRequest(
      assetModelName: Option[String] = None,
      assetModelDescription: Option[String] = None,
      assetModelProperties: Option[List[AssetModelPropertyDefinition]] = None,
      assetModelHierarchies: Option[List[AssetModelHierarchyDefinition]] = None,
      assetModelCompositeModels: Option[List[AssetModelCompositeModelDefinition]] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateAssetModelRequest =
      CreateAssetModelRequest
        .builder
        .ifSome(assetModelName)(_.assetModelName(_))
        .ifSome(assetModelDescription)(_.assetModelDescription(_))
        .ifSome(assetModelProperties)(_.assetModelProperties(_))
        .ifSome(assetModelHierarchies)(_.assetModelHierarchies(_))
        .ifSome(assetModelCompositeModels)(_.assetModelCompositeModels(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssetModelResponse(
      assetModelId: Option[String] = None,
      assetModelArn: Option[String] = None,
      assetModelStatus: Option[AssetModelStatus] = None
    ): CreateAssetModelResponse =
      CreateAssetModelResponse
        .builder
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(assetModelArn)(_.assetModelArn(_))
        .ifSome(assetModelStatus)(_.assetModelStatus(_))
        .build

    def createAssetRequest(
      assetName: Option[String] = None,
      assetModelId: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateAssetRequest =
      CreateAssetRequest
        .builder
        .ifSome(assetName)(_.assetName(_))
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssetResponse(
      assetId: Option[String] = None,
      assetArn: Option[String] = None,
      assetStatus: Option[AssetStatus] = None
    ): CreateAssetResponse =
      CreateAssetResponse
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(assetArn)(_.assetArn(_))
        .ifSome(assetStatus)(_.assetStatus(_))
        .build

    def createDashboardRequest(
      projectId: Option[String] = None,
      dashboardName: Option[String] = None,
      dashboardDescription: Option[String] = None,
      dashboardDefinition: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateDashboardRequest =
      CreateDashboardRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(dashboardName)(_.dashboardName(_))
        .ifSome(dashboardDescription)(_.dashboardDescription(_))
        .ifSome(dashboardDefinition)(_.dashboardDefinition(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDashboardResponse(
      dashboardId: Option[String] = None,
      dashboardArn: Option[String] = None
    ): CreateDashboardResponse =
      CreateDashboardResponse
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .build

    def createGatewayRequest(
      gatewayName: Option[String] = None,
      gatewayPlatform: Option[GatewayPlatform] = None,
      tags: Option[TagMap] = None
    ): CreateGatewayRequest =
      CreateGatewayRequest
        .builder
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(gatewayPlatform)(_.gatewayPlatform(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGatewayResponse(
      gatewayId: Option[String] = None,
      gatewayArn: Option[String] = None
    ): CreateGatewayResponse =
      CreateGatewayResponse
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(gatewayArn)(_.gatewayArn(_))
        .build

    def createPortalRequest(
      portalName: Option[String] = None,
      portalDescription: Option[String] = None,
      portalContactEmail: Option[String] = None,
      clientToken: Option[String] = None,
      portalLogoImageFile: Option[ImageFile] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None,
      portalAuthMode: Option[String] = None,
      notificationSenderEmail: Option[String] = None,
      alarms: Option[Alarms] = None
    ): CreatePortalRequest =
      CreatePortalRequest
        .builder
        .ifSome(portalName)(_.portalName(_))
        .ifSome(portalDescription)(_.portalDescription(_))
        .ifSome(portalContactEmail)(_.portalContactEmail(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(portalLogoImageFile)(_.portalLogoImageFile(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(portalAuthMode)(_.portalAuthMode(_))
        .ifSome(notificationSenderEmail)(_.notificationSenderEmail(_))
        .ifSome(alarms)(_.alarms(_))
        .build

    def createPortalResponse(
      portalId: Option[String] = None,
      portalArn: Option[String] = None,
      portalStartUrl: Option[String] = None,
      portalStatus: Option[PortalStatus] = None,
      ssoApplicationId: Option[String] = None
    ): CreatePortalResponse =
      CreatePortalResponse
        .builder
        .ifSome(portalId)(_.portalId(_))
        .ifSome(portalArn)(_.portalArn(_))
        .ifSome(portalStartUrl)(_.portalStartUrl(_))
        .ifSome(portalStatus)(_.portalStatus(_))
        .ifSome(ssoApplicationId)(_.ssoApplicationId(_))
        .build

    def createProjectRequest(
      portalId: Option[String] = None,
      projectName: Option[String] = None,
      projectDescription: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(portalId)(_.portalId(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(projectDescription)(_.projectDescription(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProjectResponse(
      projectId: Option[String] = None,
      projectArn: Option[String] = None
    ): CreateProjectResponse =
      CreateProjectResponse
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def dashboardSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None
    ): DashboardSummary =
      DashboardSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .build

    def deleteAccessPolicyRequest(
      accessPolicyId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteAccessPolicyRequest =
      DeleteAccessPolicyRequest
        .builder
        .ifSome(accessPolicyId)(_.accessPolicyId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteAccessPolicyResponse(

    ): DeleteAccessPolicyResponse =
      DeleteAccessPolicyResponse
        .builder

        .build

    def deleteAssetModelRequest(
      assetModelId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteAssetModelRequest =
      DeleteAssetModelRequest
        .builder
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteAssetModelResponse(
      assetModelStatus: Option[AssetModelStatus] = None
    ): DeleteAssetModelResponse =
      DeleteAssetModelResponse
        .builder
        .ifSome(assetModelStatus)(_.assetModelStatus(_))
        .build

    def deleteAssetRequest(
      assetId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteAssetRequest =
      DeleteAssetRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteAssetResponse(
      assetStatus: Option[AssetStatus] = None
    ): DeleteAssetResponse =
      DeleteAssetResponse
        .builder
        .ifSome(assetStatus)(_.assetStatus(_))
        .build

    def deleteDashboardRequest(
      dashboardId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteDashboardRequest =
      DeleteDashboardRequest
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteDashboardResponse(

    ): DeleteDashboardResponse =
      DeleteDashboardResponse
        .builder

        .build

    def deleteGatewayRequest(
      gatewayId: Option[String] = None
    ): DeleteGatewayRequest =
      DeleteGatewayRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .build

    def deletePortalRequest(
      portalId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeletePortalRequest =
      DeletePortalRequest
        .builder
        .ifSome(portalId)(_.portalId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deletePortalResponse(
      portalStatus: Option[PortalStatus] = None
    ): DeletePortalResponse =
      DeletePortalResponse
        .builder
        .ifSome(portalStatus)(_.portalStatus(_))
        .build

    def deleteProjectRequest(
      projectId: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteProjectResponse(

    ): DeleteProjectResponse =
      DeleteProjectResponse
        .builder

        .build

    def describeAccessPolicyRequest(
      accessPolicyId: Option[String] = None
    ): DescribeAccessPolicyRequest =
      DescribeAccessPolicyRequest
        .builder
        .ifSome(accessPolicyId)(_.accessPolicyId(_))
        .build

    def describeAccessPolicyResponse(
      accessPolicyId: Option[String] = None,
      accessPolicyArn: Option[String] = None,
      accessPolicyIdentity: Option[Identity] = None,
      accessPolicyResource: Option[Resource] = None,
      accessPolicyPermission: Option[String] = None,
      accessPolicyCreationDate: Option[Timestamp] = None,
      accessPolicyLastUpdateDate: Option[Timestamp] = None
    ): DescribeAccessPolicyResponse =
      DescribeAccessPolicyResponse
        .builder
        .ifSome(accessPolicyId)(_.accessPolicyId(_))
        .ifSome(accessPolicyArn)(_.accessPolicyArn(_))
        .ifSome(accessPolicyIdentity)(_.accessPolicyIdentity(_))
        .ifSome(accessPolicyResource)(_.accessPolicyResource(_))
        .ifSome(accessPolicyPermission)(_.accessPolicyPermission(_))
        .ifSome(accessPolicyCreationDate)(_.accessPolicyCreationDate(_))
        .ifSome(accessPolicyLastUpdateDate)(_.accessPolicyLastUpdateDate(_))
        .build

    def describeAssetModelRequest(
      assetModelId: Option[String] = None
    ): DescribeAssetModelRequest =
      DescribeAssetModelRequest
        .builder
        .ifSome(assetModelId)(_.assetModelId(_))
        .build

    def describeAssetModelResponse(
      assetModelId: Option[String] = None,
      assetModelArn: Option[String] = None,
      assetModelName: Option[String] = None,
      assetModelDescription: Option[String] = None,
      assetModelProperties: Option[List[AssetModelProperty]] = None,
      assetModelHierarchies: Option[List[AssetModelHierarchy]] = None,
      assetModelCompositeModels: Option[List[AssetModelCompositeModel]] = None,
      assetModelCreationDate: Option[Timestamp] = None,
      assetModelLastUpdateDate: Option[Timestamp] = None,
      assetModelStatus: Option[AssetModelStatus] = None
    ): DescribeAssetModelResponse =
      DescribeAssetModelResponse
        .builder
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(assetModelArn)(_.assetModelArn(_))
        .ifSome(assetModelName)(_.assetModelName(_))
        .ifSome(assetModelDescription)(_.assetModelDescription(_))
        .ifSome(assetModelProperties)(_.assetModelProperties(_))
        .ifSome(assetModelHierarchies)(_.assetModelHierarchies(_))
        .ifSome(assetModelCompositeModels)(_.assetModelCompositeModels(_))
        .ifSome(assetModelCreationDate)(_.assetModelCreationDate(_))
        .ifSome(assetModelLastUpdateDate)(_.assetModelLastUpdateDate(_))
        .ifSome(assetModelStatus)(_.assetModelStatus(_))
        .build

    def describeAssetPropertyRequest(
      assetId: Option[String] = None,
      propertyId: Option[String] = None
    ): DescribeAssetPropertyRequest =
      DescribeAssetPropertyRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .build

    def describeAssetPropertyResponse(
      assetId: Option[String] = None,
      assetName: Option[String] = None,
      assetModelId: Option[String] = None,
      assetProperty: Option[Property] = None,
      compositeModel: Option[CompositeModelProperty] = None
    ): DescribeAssetPropertyResponse =
      DescribeAssetPropertyResponse
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(assetName)(_.assetName(_))
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(assetProperty)(_.assetProperty(_))
        .ifSome(compositeModel)(_.compositeModel(_))
        .build

    def describeAssetRequest(
      assetId: Option[String] = None
    ): DescribeAssetRequest =
      DescribeAssetRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .build

    def describeAssetResponse(
      assetId: Option[String] = None,
      assetArn: Option[String] = None,
      assetName: Option[String] = None,
      assetModelId: Option[String] = None,
      assetProperties: Option[List[AssetProperty]] = None,
      assetHierarchies: Option[List[AssetHierarchy]] = None,
      assetCompositeModels: Option[List[AssetCompositeModel]] = None,
      assetCreationDate: Option[Timestamp] = None,
      assetLastUpdateDate: Option[Timestamp] = None,
      assetStatus: Option[AssetStatus] = None
    ): DescribeAssetResponse =
      DescribeAssetResponse
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(assetArn)(_.assetArn(_))
        .ifSome(assetName)(_.assetName(_))
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(assetProperties)(_.assetProperties(_))
        .ifSome(assetHierarchies)(_.assetHierarchies(_))
        .ifSome(assetCompositeModels)(_.assetCompositeModels(_))
        .ifSome(assetCreationDate)(_.assetCreationDate(_))
        .ifSome(assetLastUpdateDate)(_.assetLastUpdateDate(_))
        .ifSome(assetStatus)(_.assetStatus(_))
        .build

    def describeDashboardRequest(
      dashboardId: Option[String] = None
    ): DescribeDashboardRequest =
      DescribeDashboardRequest
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .build

    def describeDashboardResponse(
      dashboardId: Option[String] = None,
      dashboardArn: Option[String] = None,
      dashboardName: Option[String] = None,
      projectId: Option[String] = None,
      dashboardDescription: Option[String] = None,
      dashboardDefinition: Option[String] = None,
      dashboardCreationDate: Option[Timestamp] = None,
      dashboardLastUpdateDate: Option[Timestamp] = None
    ): DescribeDashboardResponse =
      DescribeDashboardResponse
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(dashboardArn)(_.dashboardArn(_))
        .ifSome(dashboardName)(_.dashboardName(_))
        .ifSome(projectId)(_.projectId(_))
        .ifSome(dashboardDescription)(_.dashboardDescription(_))
        .ifSome(dashboardDefinition)(_.dashboardDefinition(_))
        .ifSome(dashboardCreationDate)(_.dashboardCreationDate(_))
        .ifSome(dashboardLastUpdateDate)(_.dashboardLastUpdateDate(_))
        .build

    def describeDefaultEncryptionConfigurationRequest(

    ): DescribeDefaultEncryptionConfigurationRequest =
      DescribeDefaultEncryptionConfigurationRequest
        .builder

        .build

    def describeDefaultEncryptionConfigurationResponse(
      encryptionType: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      configurationStatus: Option[ConfigurationStatus] = None
    ): DescribeDefaultEncryptionConfigurationResponse =
      DescribeDefaultEncryptionConfigurationResponse
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(configurationStatus)(_.configurationStatus(_))
        .build

    def describeGatewayCapabilityConfigurationRequest(
      gatewayId: Option[String] = None,
      capabilityNamespace: Option[String] = None
    ): DescribeGatewayCapabilityConfigurationRequest =
      DescribeGatewayCapabilityConfigurationRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(capabilityNamespace)(_.capabilityNamespace(_))
        .build

    def describeGatewayCapabilityConfigurationResponse(
      gatewayId: Option[String] = None,
      capabilityNamespace: Option[String] = None,
      capabilityConfiguration: Option[String] = None,
      capabilitySyncStatus: Option[String] = None
    ): DescribeGatewayCapabilityConfigurationResponse =
      DescribeGatewayCapabilityConfigurationResponse
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(capabilityNamespace)(_.capabilityNamespace(_))
        .ifSome(capabilityConfiguration)(_.capabilityConfiguration(_))
        .ifSome(capabilitySyncStatus)(_.capabilitySyncStatus(_))
        .build

    def describeGatewayRequest(
      gatewayId: Option[String] = None
    ): DescribeGatewayRequest =
      DescribeGatewayRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .build

    def describeGatewayResponse(
      gatewayId: Option[String] = None,
      gatewayName: Option[String] = None,
      gatewayArn: Option[String] = None,
      gatewayPlatform: Option[GatewayPlatform] = None,
      gatewayCapabilitySummaries: Option[List[GatewayCapabilitySummary]] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None
    ): DescribeGatewayResponse =
      DescribeGatewayResponse
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(gatewayArn)(_.gatewayArn(_))
        .ifSome(gatewayPlatform)(_.gatewayPlatform(_))
        .ifSome(gatewayCapabilitySummaries)(_.gatewayCapabilitySummaries(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .build

    def describeLoggingOptionsRequest(

    ): DescribeLoggingOptionsRequest =
      DescribeLoggingOptionsRequest
        .builder

        .build

    def describeLoggingOptionsResponse(
      loggingOptions: Option[LoggingOptions] = None
    ): DescribeLoggingOptionsResponse =
      DescribeLoggingOptionsResponse
        .builder
        .ifSome(loggingOptions)(_.loggingOptions(_))
        .build

    def describePortalRequest(
      portalId: Option[String] = None
    ): DescribePortalRequest =
      DescribePortalRequest
        .builder
        .ifSome(portalId)(_.portalId(_))
        .build

    def describePortalResponse(
      portalId: Option[String] = None,
      portalArn: Option[String] = None,
      portalName: Option[String] = None,
      portalDescription: Option[String] = None,
      portalClientId: Option[String] = None,
      portalStartUrl: Option[String] = None,
      portalContactEmail: Option[String] = None,
      portalStatus: Option[PortalStatus] = None,
      portalCreationDate: Option[Timestamp] = None,
      portalLastUpdateDate: Option[Timestamp] = None,
      portalLogoImageLocation: Option[ImageLocation] = None,
      roleArn: Option[String] = None,
      portalAuthMode: Option[String] = None,
      notificationSenderEmail: Option[String] = None,
      alarms: Option[Alarms] = None
    ): DescribePortalResponse =
      DescribePortalResponse
        .builder
        .ifSome(portalId)(_.portalId(_))
        .ifSome(portalArn)(_.portalArn(_))
        .ifSome(portalName)(_.portalName(_))
        .ifSome(portalDescription)(_.portalDescription(_))
        .ifSome(portalClientId)(_.portalClientId(_))
        .ifSome(portalStartUrl)(_.portalStartUrl(_))
        .ifSome(portalContactEmail)(_.portalContactEmail(_))
        .ifSome(portalStatus)(_.portalStatus(_))
        .ifSome(portalCreationDate)(_.portalCreationDate(_))
        .ifSome(portalLastUpdateDate)(_.portalLastUpdateDate(_))
        .ifSome(portalLogoImageLocation)(_.portalLogoImageLocation(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(portalAuthMode)(_.portalAuthMode(_))
        .ifSome(notificationSenderEmail)(_.notificationSenderEmail(_))
        .ifSome(alarms)(_.alarms(_))
        .build

    def describeProjectRequest(
      projectId: Option[String] = None
    ): DescribeProjectRequest =
      DescribeProjectRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .build

    def describeProjectResponse(
      projectId: Option[String] = None,
      projectArn: Option[String] = None,
      projectName: Option[String] = None,
      portalId: Option[String] = None,
      projectDescription: Option[String] = None,
      projectCreationDate: Option[Timestamp] = None,
      projectLastUpdateDate: Option[Timestamp] = None
    ): DescribeProjectResponse =
      DescribeProjectResponse
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(portalId)(_.portalId(_))
        .ifSome(projectDescription)(_.projectDescription(_))
        .ifSome(projectCreationDate)(_.projectCreationDate(_))
        .ifSome(projectLastUpdateDate)(_.projectLastUpdateDate(_))
        .build

    def disassociateAssetsRequest(
      assetId: Option[String] = None,
      hierarchyId: Option[String] = None,
      childAssetId: Option[String] = None,
      clientToken: Option[String] = None
    ): DisassociateAssetsRequest =
      DisassociateAssetsRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(hierarchyId)(_.hierarchyId(_))
        .ifSome(childAssetId)(_.childAssetId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def errorDetails(
      code: Option[String] = None,
      message: Option[String] = None
    ): ErrorDetails =
      ErrorDetails
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def expressionVariable(
      name: Option[String] = None,
      value: Option[VariableValue] = None
    ): ExpressionVariable =
      ExpressionVariable
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def gatewayCapabilitySummary(
      capabilityNamespace: Option[String] = None,
      capabilitySyncStatus: Option[String] = None
    ): GatewayCapabilitySummary =
      GatewayCapabilitySummary
        .builder
        .ifSome(capabilityNamespace)(_.capabilityNamespace(_))
        .ifSome(capabilitySyncStatus)(_.capabilitySyncStatus(_))
        .build

    def gatewayPlatform(
      greengrass: Option[Greengrass] = None
    ): GatewayPlatform =
      GatewayPlatform
        .builder
        .ifSome(greengrass)(_.greengrass(_))
        .build

    def gatewaySummary(
      gatewayId: Option[String] = None,
      gatewayName: Option[String] = None,
      gatewayCapabilitySummaries: Option[List[GatewayCapabilitySummary]] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None
    ): GatewaySummary =
      GatewaySummary
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .ifSome(gatewayCapabilitySummaries)(_.gatewayCapabilitySummaries(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .build

    def getAssetPropertyAggregatesRequest(
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      aggregateTypes: Option[List[AggregateType]] = None,
      resolution: Option[String] = None,
      qualities: Option[List[Quality]] = None,
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None,
      timeOrdering: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAssetPropertyAggregatesRequest =
      GetAssetPropertyAggregatesRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(aggregateTypes)(_.aggregateTypes(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(qualities)(_.qualities(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(timeOrdering)(_.timeOrdering(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getAssetPropertyAggregatesResponse(
      aggregatedValues: Option[List[AggregatedValue]] = None,
      nextToken: Option[String] = None
    ): GetAssetPropertyAggregatesResponse =
      GetAssetPropertyAggregatesResponse
        .builder
        .ifSome(aggregatedValues)(_.aggregatedValues(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAssetPropertyValueHistoryRequest(
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      startDate: Option[Timestamp] = None,
      endDate: Option[Timestamp] = None,
      qualities: Option[List[Quality]] = None,
      timeOrdering: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetAssetPropertyValueHistoryRequest =
      GetAssetPropertyValueHistoryRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(endDate)(_.endDate(_))
        .ifSome(qualities)(_.qualities(_))
        .ifSome(timeOrdering)(_.timeOrdering(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getAssetPropertyValueHistoryResponse(
      assetPropertyValueHistory: Option[List[AssetPropertyValue]] = None,
      nextToken: Option[String] = None
    ): GetAssetPropertyValueHistoryResponse =
      GetAssetPropertyValueHistoryResponse
        .builder
        .ifSome(assetPropertyValueHistory)(_.assetPropertyValueHistory(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getAssetPropertyValueRequest(
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None
    ): GetAssetPropertyValueRequest =
      GetAssetPropertyValueRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .build

    def getAssetPropertyValueResponse(
      propertyValue: Option[AssetPropertyValue] = None
    ): GetAssetPropertyValueResponse =
      GetAssetPropertyValueResponse
        .builder
        .ifSome(propertyValue)(_.propertyValue(_))
        .build

    def getInterpolatedAssetPropertyValuesRequest(
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      startTimeInSeconds: Option[TimeInSeconds] = None,
      startTimeOffsetInNanos: Option[Int] = None,
      endTimeInSeconds: Option[TimeInSeconds] = None,
      endTimeOffsetInNanos: Option[Int] = None,
      quality: Option[String] = None,
      intervalInSeconds: Option[IntervalInSeconds] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      `type`: Option[String] = None
    ): GetInterpolatedAssetPropertyValuesRequest =
      GetInterpolatedAssetPropertyValuesRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(startTimeInSeconds)(_.startTimeInSeconds(_))
        .ifSome(startTimeOffsetInNanos)(_.startTimeOffsetInNanos(_))
        .ifSome(endTimeInSeconds)(_.endTimeInSeconds(_))
        .ifSome(endTimeOffsetInNanos)(_.endTimeOffsetInNanos(_))
        .ifSome(quality)(_.quality(_))
        .ifSome(intervalInSeconds)(_.intervalInSeconds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def getInterpolatedAssetPropertyValuesResponse(
      interpolatedAssetPropertyValues: Option[List[InterpolatedAssetPropertyValue]] = None,
      nextToken: Option[String] = None
    ): GetInterpolatedAssetPropertyValuesResponse =
      GetInterpolatedAssetPropertyValuesResponse
        .builder
        .ifSome(interpolatedAssetPropertyValues)(_.interpolatedAssetPropertyValues(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def greengrass(
      groupArn: Option[String] = None
    ): Greengrass =
      Greengrass
        .builder
        .ifSome(groupArn)(_.groupArn(_))
        .build

    def groupIdentity(
      id: Option[String] = None
    ): GroupIdentity =
      GroupIdentity
        .builder
        .ifSome(id)(_.id(_))
        .build

    def iAMRoleIdentity(
      arn: Option[String] = None
    ): IAMRoleIdentity =
      IAMRoleIdentity
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def iAMUserIdentity(
      arn: Option[String] = None
    ): IAMUserIdentity =
      IAMUserIdentity
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def identity(
      user: Option[UserIdentity] = None,
      group: Option[GroupIdentity] = None,
      iamUser: Option[IAMUserIdentity] = None,
      iamRole: Option[IAMRoleIdentity] = None
    ): Identity =
      Identity
        .builder
        .ifSome(user)(_.user(_))
        .ifSome(group)(_.group(_))
        .ifSome(iamUser)(_.iamUser(_))
        .ifSome(iamRole)(_.iamRole(_))
        .build

    def image(
      id: Option[String] = None,
      file: Option[ImageFile] = None
    ): Image =
      Image
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(file)(_.file(_))
        .build

    def imageFile(
      data: Option[ImageFileData] = None,
      `type`: Option[String] = None
    ): ImageFile =
      ImageFile
        .builder
        .ifSome(data)(_.data(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def imageLocation(
      id: Option[String] = None,
      url: Option[String] = None
    ): ImageLocation =
      ImageLocation
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(url)(_.url(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def interpolatedAssetPropertyValue(
      timestamp: Option[TimeInNanos] = None,
      value: Option[Variant] = None
    ): InterpolatedAssetPropertyValue =
      InterpolatedAssetPropertyValue
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(value)(_.value(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAccessPoliciesRequest(
      identityType: Option[String] = None,
      identityId: Option[String] = None,
      resourceType: Option[String] = None,
      resourceId: Option[String] = None,
      iamArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccessPoliciesRequest =
      ListAccessPoliciesRequest
        .builder
        .ifSome(identityType)(_.identityType(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(iamArn)(_.iamArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAccessPoliciesResponse(
      accessPolicySummaries: Option[List[AccessPolicySummary]] = None,
      nextToken: Option[String] = None
    ): ListAccessPoliciesResponse =
      ListAccessPoliciesResponse
        .builder
        .ifSome(accessPolicySummaries)(_.accessPolicySummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssetModelsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssetModelsRequest =
      ListAssetModelsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssetModelsResponse(
      assetModelSummaries: Option[List[AssetModelSummary]] = None,
      nextToken: Option[String] = None
    ): ListAssetModelsResponse =
      ListAssetModelsResponse
        .builder
        .ifSome(assetModelSummaries)(_.assetModelSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssetRelationshipsRequest(
      assetId: Option[String] = None,
      traversalType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssetRelationshipsRequest =
      ListAssetRelationshipsRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(traversalType)(_.traversalType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssetRelationshipsResponse(
      assetRelationshipSummaries: Option[List[AssetRelationshipSummary]] = None,
      nextToken: Option[String] = None
    ): ListAssetRelationshipsResponse =
      ListAssetRelationshipsResponse
        .builder
        .ifSome(assetRelationshipSummaries)(_.assetRelationshipSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      assetModelId: Option[String] = None,
      filter: Option[String] = None
    ): ListAssetsRequest =
      ListAssetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listAssetsResponse(
      assetSummaries: Option[List[AssetSummary]] = None,
      nextToken: Option[String] = None
    ): ListAssetsResponse =
      ListAssetsResponse
        .builder
        .ifSome(assetSummaries)(_.assetSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociatedAssetsRequest(
      assetId: Option[String] = None,
      hierarchyId: Option[String] = None,
      traversalDirection: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAssociatedAssetsRequest =
      ListAssociatedAssetsRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(hierarchyId)(_.hierarchyId(_))
        .ifSome(traversalDirection)(_.traversalDirection(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAssociatedAssetsResponse(
      assetSummaries: Option[List[AssociatedAssetsSummary]] = None,
      nextToken: Option[String] = None
    ): ListAssociatedAssetsResponse =
      ListAssociatedAssetsResponse
        .builder
        .ifSome(assetSummaries)(_.assetSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDashboardsRequest(
      projectId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDashboardsRequest =
      ListDashboardsRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDashboardsResponse(
      dashboardSummaries: Option[List[DashboardSummary]] = None,
      nextToken: Option[String] = None
    ): ListDashboardsResponse =
      ListDashboardsResponse
        .builder
        .ifSome(dashboardSummaries)(_.dashboardSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGatewaysRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGatewaysRequest =
      ListGatewaysRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGatewaysResponse(
      gatewaySummaries: Option[List[GatewaySummary]] = None,
      nextToken: Option[String] = None
    ): ListGatewaysResponse =
      ListGatewaysResponse
        .builder
        .ifSome(gatewaySummaries)(_.gatewaySummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPortalsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPortalsRequest =
      ListPortalsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPortalsResponse(
      portalSummaries: Option[List[PortalSummary]] = None,
      nextToken: Option[String] = None
    ): ListPortalsResponse =
      ListPortalsResponse
        .builder
        .ifSome(portalSummaries)(_.portalSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectAssetsRequest(
      projectId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProjectAssetsRequest =
      ListProjectAssetsRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProjectAssetsResponse(
      assetIds: Option[List[ID]] = None,
      nextToken: Option[String] = None
    ): ListProjectAssetsResponse =
      ListProjectAssetsResponse
        .builder
        .ifSome(assetIds)(_.assetIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsRequest(
      portalId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(portalId)(_.portalId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProjectsResponse(
      projectSummaries: Option[List[ProjectSummary]] = None,
      nextToken: Option[String] = None
    ): ListProjectsResponse =
      ListProjectsResponse
        .builder
        .ifSome(projectSummaries)(_.projectSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def loggingOptions(
      level: Option[String] = None
    ): LoggingOptions =
      LoggingOptions
        .builder
        .ifSome(level)(_.level(_))
        .build

    def measurement(

    ): Measurement =
      Measurement
        .builder

        .build

    def metric(
      expression: Option[String] = None,
      variables: Option[List[ExpressionVariable]] = None,
      window: Option[MetricWindow] = None
    ): Metric =
      Metric
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(variables)(_.variables(_))
        .ifSome(window)(_.window(_))
        .build

    def metricWindow(
      tumbling: Option[TumblingWindow] = None
    ): MetricWindow =
      MetricWindow
        .builder
        .ifSome(tumbling)(_.tumbling(_))
        .build

    def monitorErrorDetails(
      code: Option[String] = None,
      message: Option[String] = None
    ): MonitorErrorDetails =
      MonitorErrorDetails
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def portalResource(
      id: Option[String] = None
    ): PortalResource =
      PortalResource
        .builder
        .ifSome(id)(_.id(_))
        .build

    def portalStatus(
      state: Option[String] = None,
      error: Option[MonitorErrorDetails] = None
    ): PortalStatus =
      PortalStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(error)(_.error(_))
        .build

    def portalSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      startUrl: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      status: Option[PortalStatus] = None
    ): PortalSummary =
      PortalSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(startUrl)(_.startUrl(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .build

    def projectResource(
      id: Option[String] = None
    ): ProjectResource =
      ProjectResource
        .builder
        .ifSome(id)(_.id(_))
        .build

    def projectSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastUpdateDate: Option[Timestamp] = None
    ): ProjectSummary =
      ProjectSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdateDate)(_.lastUpdateDate(_))
        .build

    def property(
      id: Option[String] = None,
      name: Option[String] = None,
      alias: Option[String] = None,
      notification: Option[PropertyNotification] = None,
      dataType: Option[String] = None,
      unit: Option[String] = None,
      `type`: Option[PropertyType] = None
    ): Property =
      Property
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(notification)(_.notification(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(unit)(_.unit(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def propertyNotification(
      topic: Option[String] = None,
      state: Option[String] = None
    ): PropertyNotification =
      PropertyNotification
        .builder
        .ifSome(topic)(_.topic(_))
        .ifSome(state)(_.state(_))
        .build

    def propertyType(
      attribute: Option[Attribute] = None,
      measurement: Option[Measurement] = None,
      transform: Option[Transform] = None,
      metric: Option[Metric] = None
    ): PropertyType =
      PropertyType
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(measurement)(_.measurement(_))
        .ifSome(transform)(_.transform(_))
        .ifSome(metric)(_.metric(_))
        .build

    def putAssetPropertyValueEntry(
      entryId: Option[String] = None,
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      propertyValues: Option[List[AssetPropertyValue]] = None
    ): PutAssetPropertyValueEntry =
      PutAssetPropertyValueEntry
        .builder
        .ifSome(entryId)(_.entryId(_))
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(propertyValues)(_.propertyValues(_))
        .build

    def putDefaultEncryptionConfigurationRequest(
      encryptionType: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): PutDefaultEncryptionConfigurationRequest =
      PutDefaultEncryptionConfigurationRequest
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def putDefaultEncryptionConfigurationResponse(
      encryptionType: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      configurationStatus: Option[ConfigurationStatus] = None
    ): PutDefaultEncryptionConfigurationResponse =
      PutDefaultEncryptionConfigurationResponse
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(configurationStatus)(_.configurationStatus(_))
        .build

    def putLoggingOptionsRequest(
      loggingOptions: Option[LoggingOptions] = None
    ): PutLoggingOptionsRequest =
      PutLoggingOptionsRequest
        .builder
        .ifSome(loggingOptions)(_.loggingOptions(_))
        .build

    def putLoggingOptionsResponse(

    ): PutLoggingOptionsResponse =
      PutLoggingOptionsResponse
        .builder

        .build

    def resource(
      portal: Option[PortalResource] = None,
      project: Option[ProjectResource] = None
    ): Resource =
      Resource
        .builder
        .ifSome(portal)(_.portal(_))
        .ifSome(project)(_.project(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceArn: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timeInNanos(
      timeInSeconds: Option[TimeInSeconds] = None,
      offsetInNanos: Option[Int] = None
    ): TimeInNanos =
      TimeInNanos
        .builder
        .ifSome(timeInSeconds)(_.timeInSeconds(_))
        .ifSome(offsetInNanos)(_.offsetInNanos(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def transform(
      expression: Option[String] = None,
      variables: Option[List[ExpressionVariable]] = None
    ): Transform =
      Transform
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(variables)(_.variables(_))
        .build

    def tumblingWindow(
      interval: Option[String] = None
    ): TumblingWindow =
      TumblingWindow
        .builder
        .ifSome(interval)(_.interval(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateAccessPolicyRequest(
      accessPolicyId: Option[String] = None,
      accessPolicyIdentity: Option[Identity] = None,
      accessPolicyResource: Option[Resource] = None,
      accessPolicyPermission: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateAccessPolicyRequest =
      UpdateAccessPolicyRequest
        .builder
        .ifSome(accessPolicyId)(_.accessPolicyId(_))
        .ifSome(accessPolicyIdentity)(_.accessPolicyIdentity(_))
        .ifSome(accessPolicyResource)(_.accessPolicyResource(_))
        .ifSome(accessPolicyPermission)(_.accessPolicyPermission(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateAccessPolicyResponse(

    ): UpdateAccessPolicyResponse =
      UpdateAccessPolicyResponse
        .builder

        .build

    def updateAssetModelRequest(
      assetModelId: Option[String] = None,
      assetModelName: Option[String] = None,
      assetModelDescription: Option[String] = None,
      assetModelProperties: Option[List[AssetModelProperty]] = None,
      assetModelHierarchies: Option[List[AssetModelHierarchy]] = None,
      assetModelCompositeModels: Option[List[AssetModelCompositeModel]] = None,
      clientToken: Option[String] = None
    ): UpdateAssetModelRequest =
      UpdateAssetModelRequest
        .builder
        .ifSome(assetModelId)(_.assetModelId(_))
        .ifSome(assetModelName)(_.assetModelName(_))
        .ifSome(assetModelDescription)(_.assetModelDescription(_))
        .ifSome(assetModelProperties)(_.assetModelProperties(_))
        .ifSome(assetModelHierarchies)(_.assetModelHierarchies(_))
        .ifSome(assetModelCompositeModels)(_.assetModelCompositeModels(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateAssetModelResponse(
      assetModelStatus: Option[AssetModelStatus] = None
    ): UpdateAssetModelResponse =
      UpdateAssetModelResponse
        .builder
        .ifSome(assetModelStatus)(_.assetModelStatus(_))
        .build

    def updateAssetPropertyRequest(
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      propertyNotificationState: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateAssetPropertyRequest =
      UpdateAssetPropertyRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(propertyNotificationState)(_.propertyNotificationState(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateAssetRequest(
      assetId: Option[String] = None,
      assetName: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateAssetRequest =
      UpdateAssetRequest
        .builder
        .ifSome(assetId)(_.assetId(_))
        .ifSome(assetName)(_.assetName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateAssetResponse(
      assetStatus: Option[AssetStatus] = None
    ): UpdateAssetResponse =
      UpdateAssetResponse
        .builder
        .ifSome(assetStatus)(_.assetStatus(_))
        .build

    def updateDashboardRequest(
      dashboardId: Option[String] = None,
      dashboardName: Option[String] = None,
      dashboardDescription: Option[String] = None,
      dashboardDefinition: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateDashboardRequest =
      UpdateDashboardRequest
        .builder
        .ifSome(dashboardId)(_.dashboardId(_))
        .ifSome(dashboardName)(_.dashboardName(_))
        .ifSome(dashboardDescription)(_.dashboardDescription(_))
        .ifSome(dashboardDefinition)(_.dashboardDefinition(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateDashboardResponse(

    ): UpdateDashboardResponse =
      UpdateDashboardResponse
        .builder

        .build

    def updateGatewayCapabilityConfigurationRequest(
      gatewayId: Option[String] = None,
      capabilityNamespace: Option[String] = None,
      capabilityConfiguration: Option[String] = None
    ): UpdateGatewayCapabilityConfigurationRequest =
      UpdateGatewayCapabilityConfigurationRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(capabilityNamespace)(_.capabilityNamespace(_))
        .ifSome(capabilityConfiguration)(_.capabilityConfiguration(_))
        .build

    def updateGatewayCapabilityConfigurationResponse(
      capabilityNamespace: Option[String] = None,
      capabilitySyncStatus: Option[String] = None
    ): UpdateGatewayCapabilityConfigurationResponse =
      UpdateGatewayCapabilityConfigurationResponse
        .builder
        .ifSome(capabilityNamespace)(_.capabilityNamespace(_))
        .ifSome(capabilitySyncStatus)(_.capabilitySyncStatus(_))
        .build

    def updateGatewayRequest(
      gatewayId: Option[String] = None,
      gatewayName: Option[String] = None
    ): UpdateGatewayRequest =
      UpdateGatewayRequest
        .builder
        .ifSome(gatewayId)(_.gatewayId(_))
        .ifSome(gatewayName)(_.gatewayName(_))
        .build

    def updatePortalRequest(
      portalId: Option[String] = None,
      portalName: Option[String] = None,
      portalDescription: Option[String] = None,
      portalContactEmail: Option[String] = None,
      portalLogoImage: Option[Image] = None,
      roleArn: Option[String] = None,
      clientToken: Option[String] = None,
      notificationSenderEmail: Option[String] = None,
      alarms: Option[Alarms] = None
    ): UpdatePortalRequest =
      UpdatePortalRequest
        .builder
        .ifSome(portalId)(_.portalId(_))
        .ifSome(portalName)(_.portalName(_))
        .ifSome(portalDescription)(_.portalDescription(_))
        .ifSome(portalContactEmail)(_.portalContactEmail(_))
        .ifSome(portalLogoImage)(_.portalLogoImage(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(notificationSenderEmail)(_.notificationSenderEmail(_))
        .ifSome(alarms)(_.alarms(_))
        .build

    def updatePortalResponse(
      portalStatus: Option[PortalStatus] = None
    ): UpdatePortalResponse =
      UpdatePortalResponse
        .builder
        .ifSome(portalStatus)(_.portalStatus(_))
        .build

    def updateProjectRequest(
      projectId: Option[String] = None,
      projectName: Option[String] = None,
      projectDescription: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateProjectRequest =
      UpdateProjectRequest
        .builder
        .ifSome(projectId)(_.projectId(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(projectDescription)(_.projectDescription(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateProjectResponse(

    ): UpdateProjectResponse =
      UpdateProjectResponse
        .builder

        .build

    def userIdentity(
      id: Option[String] = None
    ): UserIdentity =
      UserIdentity
        .builder
        .ifSome(id)(_.id(_))
        .build

    def variableValue(
      propertyId: Option[String] = None,
      hierarchyId: Option[String] = None
    ): VariableValue =
      VariableValue
        .builder
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(hierarchyId)(_.hierarchyId(_))
        .build

    def variant(
      stringValue: Option[String] = None,
      integerValue: Option[Int] = None,
      doubleValue: Option[PropertyValueDoubleValue] = None,
      booleanValue: Option[Boolean] = None
    ): Variant =
      Variant
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
