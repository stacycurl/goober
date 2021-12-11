package goober.hi

import goober.free.lakeformation.LakeFormationIO
import software.amazon.awssdk.services.lakeformation.model._


object lakeformation {
  import goober.free.{lakeformation ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def addLFTagsToResourceRequest(
      catalogId: Option[String] = None,
      resource: Option[Resource] = None,
      lFTags: Option[List[LFTagPair]] = None
    ): AddLFTagsToResourceRequest =
      AddLFTagsToResourceRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(lFTags)(_.lFTags(_))
        .build

    def addLFTagsToResourceResponse(
      failures: Option[List[LFTagError]] = None
    ): AddLFTagsToResourceResponse =
      AddLFTagsToResourceResponse
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def alreadyExistsException(
      message: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def batchGrantPermissionsRequest(
      catalogId: Option[String] = None,
      entries: Option[List[BatchPermissionsRequestEntry]] = None
    ): BatchGrantPermissionsRequest =
      BatchGrantPermissionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(entries)(_.entries(_))
        .build

    def batchGrantPermissionsResponse(
      failures: Option[List[BatchPermissionsFailureEntry]] = None
    ): BatchGrantPermissionsResponse =
      BatchGrantPermissionsResponse
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def batchPermissionsFailureEntry(
      requestEntry: Option[BatchPermissionsRequestEntry] = None,
      error: Option[ErrorDetail] = None
    ): BatchPermissionsFailureEntry =
      BatchPermissionsFailureEntry
        .builder
        .ifSome(requestEntry)(_.requestEntry(_))
        .ifSome(error)(_.error(_))
        .build

    def batchPermissionsRequestEntry(
      id: Option[String] = None,
      principal: Option[DataLakePrincipal] = None,
      resource: Option[Resource] = None,
      permissions: Option[List[Permission]] = None,
      permissionsWithGrantOption: Option[List[Permission]] = None
    ): BatchPermissionsRequestEntry =
      BatchPermissionsRequestEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(permissionsWithGrantOption)(_.permissionsWithGrantOption(_))
        .build

    def batchRevokePermissionsRequest(
      catalogId: Option[String] = None,
      entries: Option[List[BatchPermissionsRequestEntry]] = None
    ): BatchRevokePermissionsRequest =
      BatchRevokePermissionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(entries)(_.entries(_))
        .build

    def batchRevokePermissionsResponse(
      failures: Option[List[BatchPermissionsFailureEntry]] = None
    ): BatchRevokePermissionsResponse =
      BatchRevokePermissionsResponse
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def catalogResource(

    ): CatalogResource =
      CatalogResource
        .builder

        .build

    def columnLFTag(
      name: Option[String] = None,
      lFTags: Option[List[LFTagPair]] = None
    ): ColumnLFTag =
      ColumnLFTag
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(lFTags)(_.lFTags(_))
        .build

    def columnWildcard(
      excludedColumnNames: Option[List[NameString]] = None
    ): ColumnWildcard =
      ColumnWildcard
        .builder
        .ifSome(excludedColumnNames)(_.excludedColumnNames(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createLFTagRequest(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None,
      tagValues: Option[List[LFTagValue]] = None
    ): CreateLFTagRequest =
      CreateLFTagRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def createLFTagResponse(

    ): CreateLFTagResponse =
      CreateLFTagResponse
        .builder

        .build

    def dataLakePrincipal(
      dataLakePrincipalIdentifier: Option[String] = None
    ): DataLakePrincipal =
      DataLakePrincipal
        .builder
        .ifSome(dataLakePrincipalIdentifier)(_.dataLakePrincipalIdentifier(_))
        .build

    def dataLakeSettings(
      dataLakeAdmins: Option[List[DataLakePrincipal]] = None,
      createDatabaseDefaultPermissions: Option[List[PrincipalPermissions]] = None,
      createTableDefaultPermissions: Option[List[PrincipalPermissions]] = None,
      trustedResourceOwners: Option[List[CatalogIdString]] = None
    ): DataLakeSettings =
      DataLakeSettings
        .builder
        .ifSome(dataLakeAdmins)(_.dataLakeAdmins(_))
        .ifSome(createDatabaseDefaultPermissions)(_.createDatabaseDefaultPermissions(_))
        .ifSome(createTableDefaultPermissions)(_.createTableDefaultPermissions(_))
        .ifSome(trustedResourceOwners)(_.trustedResourceOwners(_))
        .build

    def dataLocationResource(
      catalogId: Option[String] = None,
      resourceArn: Option[String] = None
    ): DataLocationResource =
      DataLocationResource
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def databaseResource(
      catalogId: Option[String] = None,
      name: Option[String] = None
    ): DatabaseResource =
      DatabaseResource
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteLFTagRequest(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None
    ): DeleteLFTagRequest =
      DeleteLFTagRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .build

    def deleteLFTagResponse(

    ): DeleteLFTagResponse =
      DeleteLFTagResponse
        .builder

        .build

    def deregisterResourceRequest(
      resourceArn: Option[String] = None
    ): DeregisterResourceRequest =
      DeregisterResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deregisterResourceResponse(

    ): DeregisterResourceResponse =
      DeregisterResourceResponse
        .builder

        .build

    def describeResourceRequest(
      resourceArn: Option[String] = None
    ): DescribeResourceRequest =
      DescribeResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeResourceResponse(
      resourceInfo: Option[ResourceInfo] = None
    ): DescribeResourceResponse =
      DescribeResourceResponse
        .builder
        .ifSome(resourceInfo)(_.resourceInfo(_))
        .build

    def detailsMap(
      resourceShare: Option[List[RAMResourceShareArn]] = None
    ): DetailsMap =
      DetailsMap
        .builder
        .ifSome(resourceShare)(_.resourceShare(_))
        .build

    def entityNotFoundException(
      message: Option[String] = None
    ): EntityNotFoundException =
      EntityNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def errorDetail(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): ErrorDetail =
      ErrorDetail
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def filterCondition(
      field: Option[String] = None,
      comparisonOperator: Option[String] = None,
      stringValueList: Option[List[StringValue]] = None
    ): FilterCondition =
      FilterCondition
        .builder
        .ifSome(field)(_.field(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(stringValueList)(_.stringValueList(_))
        .build

    def getDataLakeSettingsRequest(
      catalogId: Option[String] = None
    ): GetDataLakeSettingsRequest =
      GetDataLakeSettingsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .build

    def getDataLakeSettingsResponse(
      dataLakeSettings: Option[DataLakeSettings] = None
    ): GetDataLakeSettingsResponse =
      GetDataLakeSettingsResponse
        .builder
        .ifSome(dataLakeSettings)(_.dataLakeSettings(_))
        .build

    def getEffectivePermissionsForPathRequest(
      catalogId: Option[String] = None,
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetEffectivePermissionsForPathRequest =
      GetEffectivePermissionsForPathRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getEffectivePermissionsForPathResponse(
      permissions: Option[List[PrincipalResourcePermissions]] = None,
      nextToken: Option[String] = None
    ): GetEffectivePermissionsForPathResponse =
      GetEffectivePermissionsForPathResponse
        .builder
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getLFTagRequest(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None
    ): GetLFTagRequest =
      GetLFTagRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .build

    def getLFTagResponse(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None,
      tagValues: Option[List[LFTagValue]] = None
    ): GetLFTagResponse =
      GetLFTagResponse
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def getResourceLFTagsRequest(
      catalogId: Option[String] = None,
      resource: Option[Resource] = None,
      showAssignedLFTags: Option[Boolean] = None
    ): GetResourceLFTagsRequest =
      GetResourceLFTagsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(showAssignedLFTags)(_.showAssignedLFTags(_))
        .build

    def getResourceLFTagsResponse(
      lFTagOnDatabase: Option[List[LFTagPair]] = None,
      lFTagsOnTable: Option[List[LFTagPair]] = None,
      lFTagsOnColumns: Option[List[ColumnLFTag]] = None
    ): GetResourceLFTagsResponse =
      GetResourceLFTagsResponse
        .builder
        .ifSome(lFTagOnDatabase)(_.lFTagOnDatabase(_))
        .ifSome(lFTagsOnTable)(_.lFTagsOnTable(_))
        .ifSome(lFTagsOnColumns)(_.lFTagsOnColumns(_))
        .build

    def glueEncryptionException(
      message: Option[String] = None
    ): GlueEncryptionException =
      GlueEncryptionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def grantPermissionsRequest(
      catalogId: Option[String] = None,
      principal: Option[DataLakePrincipal] = None,
      resource: Option[Resource] = None,
      permissions: Option[List[Permission]] = None,
      permissionsWithGrantOption: Option[List[Permission]] = None
    ): GrantPermissionsRequest =
      GrantPermissionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(permissionsWithGrantOption)(_.permissionsWithGrantOption(_))
        .build

    def grantPermissionsResponse(

    ): GrantPermissionsResponse =
      GrantPermissionsResponse
        .builder

        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lFTag(
      tagKey: Option[String] = None,
      tagValues: Option[List[LFTagValue]] = None
    ): LFTag =
      LFTag
        .builder
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def lFTagError(
      lFTag: Option[LFTagPair] = None,
      error: Option[ErrorDetail] = None
    ): LFTagError =
      LFTagError
        .builder
        .ifSome(lFTag)(_.lFTag(_))
        .ifSome(error)(_.error(_))
        .build

    def lFTagKeyResource(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None,
      tagValues: Option[List[LFTagValue]] = None
    ): LFTagKeyResource =
      LFTagKeyResource
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def lFTagPair(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None,
      tagValues: Option[List[LFTagValue]] = None
    ): LFTagPair =
      LFTagPair
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def lFTagPolicyResource(
      catalogId: Option[String] = None,
      resourceType: Option[String] = None,
      expression: Option[List[LFTag]] = None
    ): LFTagPolicyResource =
      LFTagPolicyResource
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(expression)(_.expression(_))
        .build

    def listLFTagsRequest(
      catalogId: Option[String] = None,
      resourceShareType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListLFTagsRequest =
      ListLFTagsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resourceShareType)(_.resourceShareType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLFTagsResponse(
      lFTags: Option[List[LFTagPair]] = None,
      nextToken: Option[String] = None
    ): ListLFTagsResponse =
      ListLFTagsResponse
        .builder
        .ifSome(lFTags)(_.lFTags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPermissionsRequest(
      catalogId: Option[String] = None,
      principal: Option[DataLakePrincipal] = None,
      resourceType: Option[String] = None,
      resource: Option[Resource] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPermissionsRequest =
      ListPermissionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPermissionsResponse(
      principalResourcePermissions: Option[List[PrincipalResourcePermissions]] = None,
      nextToken: Option[String] = None
    ): ListPermissionsResponse =
      ListPermissionsResponse
        .builder
        .ifSome(principalResourcePermissions)(_.principalResourcePermissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourcesRequest(
      filterConditionList: Option[List[FilterCondition]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListResourcesRequest =
      ListResourcesRequest
        .builder
        .ifSome(filterConditionList)(_.filterConditionList(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourcesResponse(
      resourceInfoList: Option[List[ResourceInfo]] = None,
      nextToken: Option[String] = None
    ): ListResourcesResponse =
      ListResourcesResponse
        .builder
        .ifSome(resourceInfoList)(_.resourceInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def operationTimeoutException(
      message: Option[String] = None
    ): OperationTimeoutException =
      OperationTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def principalPermissions(
      principal: Option[DataLakePrincipal] = None,
      permissions: Option[List[Permission]] = None
    ): PrincipalPermissions =
      PrincipalPermissions
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def principalResourcePermissions(
      principal: Option[DataLakePrincipal] = None,
      resource: Option[Resource] = None,
      permissions: Option[List[Permission]] = None,
      permissionsWithGrantOption: Option[List[Permission]] = None,
      additionalDetails: Option[DetailsMap] = None
    ): PrincipalResourcePermissions =
      PrincipalResourcePermissions
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(permissionsWithGrantOption)(_.permissionsWithGrantOption(_))
        .ifSome(additionalDetails)(_.additionalDetails(_))
        .build

    def putDataLakeSettingsRequest(
      catalogId: Option[String] = None,
      dataLakeSettings: Option[DataLakeSettings] = None
    ): PutDataLakeSettingsRequest =
      PutDataLakeSettingsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(dataLakeSettings)(_.dataLakeSettings(_))
        .build

    def putDataLakeSettingsResponse(

    ): PutDataLakeSettingsResponse =
      PutDataLakeSettingsResponse
        .builder

        .build

    def registerResourceRequest(
      resourceArn: Option[String] = None,
      useServiceLinkedRole: Option[Boolean] = None,
      roleArn: Option[String] = None
    ): RegisterResourceRequest =
      RegisterResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(useServiceLinkedRole)(_.useServiceLinkedRole(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def registerResourceResponse(

    ): RegisterResourceResponse =
      RegisterResourceResponse
        .builder

        .build

    def removeLFTagsFromResourceRequest(
      catalogId: Option[String] = None,
      resource: Option[Resource] = None,
      lFTags: Option[List[LFTagPair]] = None
    ): RemoveLFTagsFromResourceRequest =
      RemoveLFTagsFromResourceRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(lFTags)(_.lFTags(_))
        .build

    def removeLFTagsFromResourceResponse(
      failures: Option[List[LFTagError]] = None
    ): RemoveLFTagsFromResourceResponse =
      RemoveLFTagsFromResourceResponse
        .builder
        .ifSome(failures)(_.failures(_))
        .build

    def resource(
      catalog: Option[CatalogResource] = None,
      database: Option[DatabaseResource] = None,
      table: Option[TableResource] = None,
      tableWithColumns: Option[TableWithColumnsResource] = None,
      dataLocation: Option[DataLocationResource] = None,
      lFTag: Option[LFTagKeyResource] = None,
      lFTagPolicy: Option[LFTagPolicyResource] = None
    ): Resource =
      Resource
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(database)(_.database(_))
        .ifSome(table)(_.table(_))
        .ifSome(tableWithColumns)(_.tableWithColumns(_))
        .ifSome(dataLocation)(_.dataLocation(_))
        .ifSome(lFTag)(_.lFTag(_))
        .ifSome(lFTagPolicy)(_.lFTagPolicy(_))
        .build

    def resourceInfo(
      resourceArn: Option[String] = None,
      roleArn: Option[String] = None,
      lastModified: Option[LastModifiedTimestamp] = None
    ): ResourceInfo =
      ResourceInfo
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def resourceNumberLimitExceededException(
      message: Option[String] = None
    ): ResourceNumberLimitExceededException =
      ResourceNumberLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def revokePermissionsRequest(
      catalogId: Option[String] = None,
      principal: Option[DataLakePrincipal] = None,
      resource: Option[Resource] = None,
      permissions: Option[List[Permission]] = None,
      permissionsWithGrantOption: Option[List[Permission]] = None
    ): RevokePermissionsRequest =
      RevokePermissionsRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(permissions)(_.permissions(_))
        .ifSome(permissionsWithGrantOption)(_.permissionsWithGrantOption(_))
        .build

    def revokePermissionsResponse(

    ): RevokePermissionsResponse =
      RevokePermissionsResponse
        .builder

        .build

    def searchDatabasesByLFTagsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      catalogId: Option[String] = None,
      expression: Option[List[LFTag]] = None
    ): SearchDatabasesByLFTagsRequest =
      SearchDatabasesByLFTagsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(expression)(_.expression(_))
        .build

    def searchDatabasesByLFTagsResponse(
      nextToken: Option[String] = None,
      databaseList: Option[List[TaggedDatabase]] = None
    ): SearchDatabasesByLFTagsResponse =
      SearchDatabasesByLFTagsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(databaseList)(_.databaseList(_))
        .build

    def searchTablesByLFTagsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      catalogId: Option[String] = None,
      expression: Option[List[LFTag]] = None
    ): SearchTablesByLFTagsRequest =
      SearchTablesByLFTagsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(expression)(_.expression(_))
        .build

    def searchTablesByLFTagsResponse(
      nextToken: Option[String] = None,
      tableList: Option[List[TaggedTable]] = None
    ): SearchTablesByLFTagsResponse =
      SearchTablesByLFTagsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tableList)(_.tableList(_))
        .build

    def tableResource(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      name: Option[String] = None,
      tableWildcard: Option[TableWildcard] = None
    ): TableResource =
      TableResource
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(name)(_.name(_))
        .ifSome(tableWildcard)(_.tableWildcard(_))
        .build

    def tableWildcard(

    ): TableWildcard =
      TableWildcard
        .builder

        .build

    def tableWithColumnsResource(
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      name: Option[String] = None,
      columnNames: Option[List[NameString]] = None,
      columnWildcard: Option[ColumnWildcard] = None
    ): TableWithColumnsResource =
      TableWithColumnsResource
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(name)(_.name(_))
        .ifSome(columnNames)(_.columnNames(_))
        .ifSome(columnWildcard)(_.columnWildcard(_))
        .build

    def taggedDatabase(
      database: Option[DatabaseResource] = None,
      lFTags: Option[List[LFTagPair]] = None
    ): TaggedDatabase =
      TaggedDatabase
        .builder
        .ifSome(database)(_.database(_))
        .ifSome(lFTags)(_.lFTags(_))
        .build

    def taggedTable(
      table: Option[TableResource] = None,
      lFTagOnDatabase: Option[List[LFTagPair]] = None,
      lFTagsOnTable: Option[List[LFTagPair]] = None,
      lFTagsOnColumns: Option[List[ColumnLFTag]] = None
    ): TaggedTable =
      TaggedTable
        .builder
        .ifSome(table)(_.table(_))
        .ifSome(lFTagOnDatabase)(_.lFTagOnDatabase(_))
        .ifSome(lFTagsOnTable)(_.lFTagsOnTable(_))
        .ifSome(lFTagsOnColumns)(_.lFTagsOnColumns(_))
        .build

    def updateLFTagRequest(
      catalogId: Option[String] = None,
      tagKey: Option[String] = None,
      tagValuesToDelete: Option[List[LFTagValue]] = None,
      tagValuesToAdd: Option[List[LFTagValue]] = None
    ): UpdateLFTagRequest =
      UpdateLFTagRequest
        .builder
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValuesToDelete)(_.tagValuesToDelete(_))
        .ifSome(tagValuesToAdd)(_.tagValuesToAdd(_))
        .build

    def updateLFTagResponse(

    ): UpdateLFTagResponse =
      UpdateLFTagResponse
        .builder

        .build

    def updateResourceRequest(
      roleArn: Option[String] = None,
      resourceArn: Option[String] = None
    ): UpdateResourceRequest =
      UpdateResourceRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def updateResourceResponse(

    ): UpdateResourceResponse =
      UpdateResourceResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
