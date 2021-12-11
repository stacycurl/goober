package goober.hi

import goober.free.health.HealthIO
import software.amazon.awssdk.services.health.model._


object health {
  import goober.free.{health ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def affectedEntity(
      entityArn: Option[String] = None,
      eventArn: Option[String] = None,
      entityValue: Option[String] = None,
      entityUrl: Option[String] = None,
      awsAccountId: Option[String] = None,
      lastUpdatedTime: Option[timestamp] = None,
      statusCode: Option[String] = None,
      tags: Option[tagSet] = None
    ): AffectedEntity =
      AffectedEntity
        .builder
        .ifSome(entityArn)(_.entityArn(_))
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(entityValue)(_.entityValue(_))
        .ifSome(entityUrl)(_.entityUrl(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dateTimeRange(
      from: Option[timestamp] = None,
      to: Option[timestamp] = None
    ): DateTimeRange =
      DateTimeRange
        .builder
        .ifSome(from)(_.from(_))
        .ifSome(to)(_.to(_))
        .build

    def describeAffectedAccountsForOrganizationRequest(
      eventArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeAffectedAccountsForOrganizationRequest =
      DescribeAffectedAccountsForOrganizationRequest
        .builder
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeAffectedAccountsForOrganizationResponse(
      affectedAccounts: Option[List[accountId]] = None,
      eventScopeCode: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeAffectedAccountsForOrganizationResponse =
      DescribeAffectedAccountsForOrganizationResponse
        .builder
        .ifSome(affectedAccounts)(_.affectedAccounts(_))
        .ifSome(eventScopeCode)(_.eventScopeCode(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAffectedEntitiesForOrganizationRequest(
      organizationEntityFilters: Option[List[EventAccountFilter]] = None,
      locale: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeAffectedEntitiesForOrganizationRequest =
      DescribeAffectedEntitiesForOrganizationRequest
        .builder
        .ifSome(organizationEntityFilters)(_.organizationEntityFilters(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeAffectedEntitiesForOrganizationResponse(
      entities: Option[List[AffectedEntity]] = None,
      failedSet: Option[List[OrganizationAffectedEntitiesErrorItem]] = None,
      nextToken: Option[String] = None
    ): DescribeAffectedEntitiesForOrganizationResponse =
      DescribeAffectedEntitiesForOrganizationResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(failedSet)(_.failedSet(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAffectedEntitiesRequest(
      filter: Option[EntityFilter] = None,
      locale: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeAffectedEntitiesRequest =
      DescribeAffectedEntitiesRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeAffectedEntitiesResponse(
      entities: Option[List[AffectedEntity]] = None,
      nextToken: Option[String] = None
    ): DescribeAffectedEntitiesResponse =
      DescribeAffectedEntitiesResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEntityAggregatesRequest(
      eventArns: Option[List[eventArn]] = None
    ): DescribeEntityAggregatesRequest =
      DescribeEntityAggregatesRequest
        .builder
        .ifSome(eventArns)(_.eventArns(_))
        .build

    def describeEntityAggregatesResponse(
      entityAggregates: Option[List[EntityAggregate]] = None
    ): DescribeEntityAggregatesResponse =
      DescribeEntityAggregatesResponse
        .builder
        .ifSome(entityAggregates)(_.entityAggregates(_))
        .build

    def describeEventAggregatesRequest(
      filter: Option[EventFilter] = None,
      aggregateField: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeEventAggregatesRequest =
      DescribeEventAggregatesRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(aggregateField)(_.aggregateField(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventAggregatesResponse(
      eventAggregates: Option[List[EventAggregate]] = None,
      nextToken: Option[String] = None
    ): DescribeEventAggregatesResponse =
      DescribeEventAggregatesResponse
        .builder
        .ifSome(eventAggregates)(_.eventAggregates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventDetailsForOrganizationRequest(
      organizationEventDetailFilters: Option[List[EventAccountFilter]] = None,
      locale: Option[String] = None
    ): DescribeEventDetailsForOrganizationRequest =
      DescribeEventDetailsForOrganizationRequest
        .builder
        .ifSome(organizationEventDetailFilters)(_.organizationEventDetailFilters(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeEventDetailsForOrganizationResponse(
      successfulSet: Option[List[OrganizationEventDetails]] = None,
      failedSet: Option[List[OrganizationEventDetailsErrorItem]] = None
    ): DescribeEventDetailsForOrganizationResponse =
      DescribeEventDetailsForOrganizationResponse
        .builder
        .ifSome(successfulSet)(_.successfulSet(_))
        .ifSome(failedSet)(_.failedSet(_))
        .build

    def describeEventDetailsRequest(
      eventArns: Option[List[eventArn]] = None,
      locale: Option[String] = None
    ): DescribeEventDetailsRequest =
      DescribeEventDetailsRequest
        .builder
        .ifSome(eventArns)(_.eventArns(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeEventDetailsResponse(
      successfulSet: Option[List[EventDetails]] = None,
      failedSet: Option[List[EventDetailsErrorItem]] = None
    ): DescribeEventDetailsResponse =
      DescribeEventDetailsResponse
        .builder
        .ifSome(successfulSet)(_.successfulSet(_))
        .ifSome(failedSet)(_.failedSet(_))
        .build

    def describeEventTypesRequest(
      filter: Option[EventTypeFilter] = None,
      locale: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeEventTypesRequest =
      DescribeEventTypesRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeEventTypesResponse(
      eventTypes: Option[List[EventType]] = None,
      nextToken: Option[String] = None
    ): DescribeEventTypesResponse =
      DescribeEventTypesResponse
        .builder
        .ifSome(eventTypes)(_.eventTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventsForOrganizationRequest(
      filter: Option[OrganizationEventFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      locale: Option[String] = None
    ): DescribeEventsForOrganizationRequest =
      DescribeEventsForOrganizationRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeEventsForOrganizationResponse(
      events: Option[List[OrganizationEvent]] = None,
      nextToken: Option[String] = None
    ): DescribeEventsForOrganizationResponse =
      DescribeEventsForOrganizationResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventsRequest(
      filter: Option[EventFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      locale: Option[String] = None
    ): DescribeEventsRequest =
      DescribeEventsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(locale)(_.locale(_))
        .build

    def describeEventsResponse(
      events: Option[List[Event]] = None,
      nextToken: Option[String] = None
    ): DescribeEventsResponse =
      DescribeEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeHealthServiceStatusForOrganizationResponse(
      healthServiceAccessStatusForOrganization: Option[String] = None
    ): DescribeHealthServiceStatusForOrganizationResponse =
      DescribeHealthServiceStatusForOrganizationResponse
        .builder
        .ifSome(healthServiceAccessStatusForOrganization)(_.healthServiceAccessStatusForOrganization(_))
        .build

    def entityAggregate(
      eventArn: Option[String] = None,
      count: Option[Int] = None
    ): EntityAggregate =
      EntityAggregate
        .builder
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(count)(_.count(_))
        .build

    def entityFilter(
      eventArns: Option[List[eventArn]] = None,
      entityArns: Option[List[entityArn]] = None,
      entityValues: Option[List[entityValue]] = None,
      lastUpdatedTimes: Option[List[DateTimeRange]] = None,
      tags: Option[List[tagSet]] = None,
      statusCodes: Option[List[entityStatusCode]] = None
    ): EntityFilter =
      EntityFilter
        .builder
        .ifSome(eventArns)(_.eventArns(_))
        .ifSome(entityArns)(_.entityArns(_))
        .ifSome(entityValues)(_.entityValues(_))
        .ifSome(lastUpdatedTimes)(_.lastUpdatedTimes(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(statusCodes)(_.statusCodes(_))
        .build

    def event(
      arn: Option[String] = None,
      service: Option[String] = None,
      eventTypeCode: Option[String] = None,
      eventTypeCategory: Option[String] = None,
      region: Option[String] = None,
      availabilityZone: Option[String] = None,
      startTime: Option[timestamp] = None,
      endTime: Option[timestamp] = None,
      lastUpdatedTime: Option[timestamp] = None,
      statusCode: Option[String] = None,
      eventScopeCode: Option[String] = None
    ): Event =
      Event
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(service)(_.service(_))
        .ifSome(eventTypeCode)(_.eventTypeCode(_))
        .ifSome(eventTypeCategory)(_.eventTypeCategory(_))
        .ifSome(region)(_.region(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(eventScopeCode)(_.eventScopeCode(_))
        .build

    def eventAccountFilter(
      eventArn: Option[String] = None,
      awsAccountId: Option[String] = None
    ): EventAccountFilter =
      EventAccountFilter
        .builder
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .build

    def eventAggregate(
      aggregateValue: Option[String] = None,
      count: Option[Int] = None
    ): EventAggregate =
      EventAggregate
        .builder
        .ifSome(aggregateValue)(_.aggregateValue(_))
        .ifSome(count)(_.count(_))
        .build

    def eventDescription(
      latestDescription: Option[String] = None
    ): EventDescription =
      EventDescription
        .builder
        .ifSome(latestDescription)(_.latestDescription(_))
        .build

    def eventDetails(
      event: Option[Event] = None,
      eventDescription: Option[EventDescription] = None,
      eventMetadata: Option[eventMetadata] = None
    ): EventDetails =
      EventDetails
        .builder
        .ifSome(event)(_.event(_))
        .ifSome(eventDescription)(_.eventDescription(_))
        .ifSome(eventMetadata)(_.eventMetadata(_))
        .build

    def eventDetailsErrorItem(
      eventArn: Option[String] = None,
      errorName: Option[String] = None,
      errorMessage: Option[String] = None
    ): EventDetailsErrorItem =
      EventDetailsErrorItem
        .builder
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(errorName)(_.errorName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def eventFilter(
      eventArns: Option[List[eventArn]] = None,
      eventTypeCodes: Option[List[eventType]] = None,
      services: Option[List[service]] = None,
      regions: Option[List[region]] = None,
      availabilityZones: Option[List[availabilityZone]] = None,
      startTimes: Option[List[DateTimeRange]] = None,
      endTimes: Option[List[DateTimeRange]] = None,
      lastUpdatedTimes: Option[List[DateTimeRange]] = None,
      entityArns: Option[List[entityArn]] = None,
      entityValues: Option[List[entityValue]] = None,
      eventTypeCategories: Option[List[eventTypeCategory]] = None,
      tags: Option[List[tagSet]] = None,
      eventStatusCodes: Option[List[eventStatusCode]] = None
    ): EventFilter =
      EventFilter
        .builder
        .ifSome(eventArns)(_.eventArns(_))
        .ifSome(eventTypeCodes)(_.eventTypeCodes(_))
        .ifSome(services)(_.services(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(startTimes)(_.startTimes(_))
        .ifSome(endTimes)(_.endTimes(_))
        .ifSome(lastUpdatedTimes)(_.lastUpdatedTimes(_))
        .ifSome(entityArns)(_.entityArns(_))
        .ifSome(entityValues)(_.entityValues(_))
        .ifSome(eventTypeCategories)(_.eventTypeCategories(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(eventStatusCodes)(_.eventStatusCodes(_))
        .build

    def eventType(
      service: Option[String] = None,
      code: Option[String] = None,
      category: Option[String] = None
    ): EventType =
      EventType
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(code)(_.code(_))
        .ifSome(category)(_.category(_))
        .build

    def eventTypeFilter(
      eventTypeCodes: Option[List[eventTypeCode]] = None,
      services: Option[List[service]] = None,
      eventTypeCategories: Option[List[eventTypeCategory]] = None
    ): EventTypeFilter =
      EventTypeFilter
        .builder
        .ifSome(eventTypeCodes)(_.eventTypeCodes(_))
        .ifSome(services)(_.services(_))
        .ifSome(eventTypeCategories)(_.eventTypeCategories(_))
        .build

    def invalidPaginationToken(
      message: Option[String] = None
    ): InvalidPaginationToken =
      InvalidPaginationToken
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationAffectedEntitiesErrorItem(
      awsAccountId: Option[String] = None,
      eventArn: Option[String] = None,
      errorName: Option[String] = None,
      errorMessage: Option[String] = None
    ): OrganizationAffectedEntitiesErrorItem =
      OrganizationAffectedEntitiesErrorItem
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(errorName)(_.errorName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def organizationEvent(
      arn: Option[String] = None,
      service: Option[String] = None,
      eventTypeCode: Option[String] = None,
      eventTypeCategory: Option[String] = None,
      eventScopeCode: Option[String] = None,
      region: Option[String] = None,
      startTime: Option[timestamp] = None,
      endTime: Option[timestamp] = None,
      lastUpdatedTime: Option[timestamp] = None,
      statusCode: Option[String] = None
    ): OrganizationEvent =
      OrganizationEvent
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(service)(_.service(_))
        .ifSome(eventTypeCode)(_.eventTypeCode(_))
        .ifSome(eventTypeCategory)(_.eventTypeCategory(_))
        .ifSome(eventScopeCode)(_.eventScopeCode(_))
        .ifSome(region)(_.region(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def organizationEventDetails(
      awsAccountId: Option[String] = None,
      event: Option[Event] = None,
      eventDescription: Option[EventDescription] = None,
      eventMetadata: Option[eventMetadata] = None
    ): OrganizationEventDetails =
      OrganizationEventDetails
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(event)(_.event(_))
        .ifSome(eventDescription)(_.eventDescription(_))
        .ifSome(eventMetadata)(_.eventMetadata(_))
        .build

    def organizationEventDetailsErrorItem(
      awsAccountId: Option[String] = None,
      eventArn: Option[String] = None,
      errorName: Option[String] = None,
      errorMessage: Option[String] = None
    ): OrganizationEventDetailsErrorItem =
      OrganizationEventDetailsErrorItem
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(eventArn)(_.eventArn(_))
        .ifSome(errorName)(_.errorName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def organizationEventFilter(
      eventTypeCodes: Option[List[eventType]] = None,
      awsAccountIds: Option[List[accountId]] = None,
      services: Option[List[service]] = None,
      regions: Option[List[region]] = None,
      startTime: Option[DateTimeRange] = None,
      endTime: Option[DateTimeRange] = None,
      lastUpdatedTime: Option[DateTimeRange] = None,
      entityArns: Option[List[entityArn]] = None,
      entityValues: Option[List[entityValue]] = None,
      eventTypeCategories: Option[List[eventTypeCategory]] = None,
      eventStatusCodes: Option[List[eventStatusCode]] = None
    ): OrganizationEventFilter =
      OrganizationEventFilter
        .builder
        .ifSome(eventTypeCodes)(_.eventTypeCodes(_))
        .ifSome(awsAccountIds)(_.awsAccountIds(_))
        .ifSome(services)(_.services(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(entityArns)(_.entityArns(_))
        .ifSome(entityValues)(_.entityValues(_))
        .ifSome(eventTypeCategories)(_.eventTypeCategories(_))
        .ifSome(eventStatusCodes)(_.eventStatusCodes(_))
        .build

    def unsupportedLocale(
      message: Option[String] = None
    ): UnsupportedLocale =
      UnsupportedLocale
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
