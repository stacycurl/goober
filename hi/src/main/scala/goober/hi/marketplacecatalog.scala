package goober.hi

import goober.free.marketplacecatalog.MarketplaceCatalogIO
import software.amazon.awssdk.services.marketplacecatalog.model._


object marketplacecatalog {
  import goober.free.{marketplacecatalog ⇒ free}

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

    def cancelChangeSetRequest(
      catalog: Option[String] = None,
      changeSetId: Option[String] = None
    ): CancelChangeSetRequest =
      CancelChangeSetRequest
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .build

    def cancelChangeSetResponse(
      changeSetId: Option[String] = None,
      changeSetArn: Option[String] = None
    ): CancelChangeSetResponse =
      CancelChangeSetResponse
        .builder
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(changeSetArn)(_.changeSetArn(_))
        .build

    def change(
      changeType: Option[String] = None,
      entity: Option[Entity] = None,
      details: Option[String] = None,
      changeName: Option[String] = None
    ): Change =
      Change
        .builder
        .ifSome(changeType)(_.changeType(_))
        .ifSome(entity)(_.entity(_))
        .ifSome(details)(_.details(_))
        .ifSome(changeName)(_.changeName(_))
        .build

    def changeSetSummaryListItem(
      changeSetId: Option[String] = None,
      changeSetArn: Option[String] = None,
      changeSetName: Option[String] = None,
      startTime: Option[String] = None,
      endTime: Option[String] = None,
      status: Option[String] = None,
      entityIdList: Option[List[ResourceId]] = None,
      failureCode: Option[String] = None
    ): ChangeSetSummaryListItem =
      ChangeSetSummaryListItem
        .builder
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(changeSetArn)(_.changeSetArn(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(entityIdList)(_.entityIdList(_))
        .ifSome(failureCode)(_.failureCode(_))
        .build

    def changeSummary(
      changeType: Option[String] = None,
      entity: Option[Entity] = None,
      details: Option[String] = None,
      errorDetailList: Option[List[ErrorDetail]] = None,
      changeName: Option[String] = None
    ): ChangeSummary =
      ChangeSummary
        .builder
        .ifSome(changeType)(_.changeType(_))
        .ifSome(entity)(_.entity(_))
        .ifSome(details)(_.details(_))
        .ifSome(errorDetailList)(_.errorDetailList(_))
        .ifSome(changeName)(_.changeName(_))
        .build

    def describeChangeSetRequest(
      catalog: Option[String] = None,
      changeSetId: Option[String] = None
    ): DescribeChangeSetRequest =
      DescribeChangeSetRequest
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .build

    def describeChangeSetResponse(
      changeSetId: Option[String] = None,
      changeSetArn: Option[String] = None,
      changeSetName: Option[String] = None,
      startTime: Option[String] = None,
      endTime: Option[String] = None,
      status: Option[String] = None,
      failureCode: Option[String] = None,
      failureDescription: Option[String] = None,
      changeSet: Option[List[ChangeSummary]] = None
    ): DescribeChangeSetResponse =
      DescribeChangeSetResponse
        .builder
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(changeSetArn)(_.changeSetArn(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureDescription)(_.failureDescription(_))
        .ifSome(changeSet)(_.changeSet(_))
        .build

    def describeEntityRequest(
      catalog: Option[String] = None,
      entityId: Option[String] = None
    ): DescribeEntityRequest =
      DescribeEntityRequest
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(entityId)(_.entityId(_))
        .build

    def describeEntityResponse(
      entityType: Option[String] = None,
      entityIdentifier: Option[String] = None,
      entityArn: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      details: Option[String] = None
    ): DescribeEntityResponse =
      DescribeEntityResponse
        .builder
        .ifSome(entityType)(_.entityType(_))
        .ifSome(entityIdentifier)(_.entityIdentifier(_))
        .ifSome(entityArn)(_.entityArn(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(details)(_.details(_))
        .build

    def entity(
      `type`: Option[String] = None,
      identifier: Option[String] = None
    ): Entity =
      Entity
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(identifier)(_.identifier(_))
        .build

    def entitySummary(
      name: Option[String] = None,
      entityType: Option[String] = None,
      entityId: Option[String] = None,
      entityArn: Option[String] = None,
      lastModifiedDate: Option[String] = None,
      visibility: Option[String] = None
    ): EntitySummary =
      EntitySummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(entityType)(_.entityType(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(entityArn)(_.entityArn(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(visibility)(_.visibility(_))
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

    def filter(
      name: Option[String] = None,
      valueList: Option[List[FilterValueContent]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(valueList)(_.valueList(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listChangeSetsRequest(
      catalog: Option[String] = None,
      filterList: Option[List[Filter]] = None,
      sort: Option[Sort] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListChangeSetsRequest =
      ListChangeSetsRequest
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(filterList)(_.filterList(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listChangeSetsResponse(
      changeSetSummaryList: Option[List[ChangeSetSummaryListItem]] = None,
      nextToken: Option[String] = None
    ): ListChangeSetsResponse =
      ListChangeSetsResponse
        .builder
        .ifSome(changeSetSummaryList)(_.changeSetSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEntitiesRequest(
      catalog: Option[String] = None,
      entityType: Option[String] = None,
      filterList: Option[List[Filter]] = None,
      sort: Option[Sort] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEntitiesRequest =
      ListEntitiesRequest
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(entityType)(_.entityType(_))
        .ifSome(filterList)(_.filterList(_))
        .ifSome(sort)(_.sort(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEntitiesResponse(
      entitySummaryList: Option[List[EntitySummary]] = None,
      nextToken: Option[String] = None
    ): ListEntitiesResponse =
      ListEntitiesResponse
        .builder
        .ifSome(entitySummaryList)(_.entitySummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotSupportedException(
      message: Option[String] = None
    ): ResourceNotSupportedException =
      ResourceNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sort(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None
    ): Sort =
      Sort
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def startChangeSetRequest(
      catalog: Option[String] = None,
      changeSet: Option[List[Change]] = None,
      changeSetName: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): StartChangeSetRequest =
      StartChangeSetRequest
        .builder
        .ifSome(catalog)(_.catalog(_))
        .ifSome(changeSet)(_.changeSet(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def startChangeSetResponse(
      changeSetId: Option[String] = None,
      changeSetArn: Option[String] = None
    ): StartChangeSetResponse =
      StartChangeSetResponse
        .builder
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(changeSetArn)(_.changeSetArn(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
