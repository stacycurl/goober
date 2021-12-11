package goober.hi

import goober.free.codestarnotifications.CodestarNotificationsIO
import software.amazon.awssdk.services.codestarnotifications.model._


object codestarnotifications {
  import goober.free.{codestarnotifications ⇒ free}

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

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def configurationException(
      message: Option[String] = None
    ): ConfigurationException =
      ConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createNotificationRuleRequest(
      name: Option[String] = None,
      eventTypeIds: Option[List[EventTypeId]] = None,
      resource: Option[String] = None,
      targets: Option[List[Target]] = None,
      detailType: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[Tags] = None,
      status: Option[String] = None
    ): CreateNotificationRuleRequest =
      CreateNotificationRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(eventTypeIds)(_.eventTypeIds(_))
        .ifSome(resource)(_.resource(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(detailType)(_.detailType(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteNotificationRuleRequest(
      arn: Option[String] = None
    ): DeleteNotificationRuleRequest =
      DeleteNotificationRuleRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteTargetRequest(
      targetAddress: Option[String] = None,
      forceUnsubscribeAll: Option[Boolean] = None
    ): DeleteTargetRequest =
      DeleteTargetRequest
        .builder
        .ifSome(targetAddress)(_.targetAddress(_))
        .ifSome(forceUnsubscribeAll)(_.forceUnsubscribeAll(_))
        .build

    def describeNotificationRuleRequest(
      arn: Option[String] = None
    ): DescribeNotificationRuleRequest =
      DescribeNotificationRuleRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def eventTypeSummary(
      eventTypeId: Option[String] = None,
      serviceName: Option[String] = None,
      eventTypeName: Option[String] = None,
      resourceType: Option[String] = None
    ): EventTypeSummary =
      EventTypeSummary
        .builder
        .ifSome(eventTypeId)(_.eventTypeId(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(eventTypeName)(_.eventTypeName(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
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

    def listEventTypesFilter(
      name: Option[String] = None,
      value: Option[String] = None
    ): ListEventTypesFilter =
      ListEventTypesFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def listEventTypesRequest(
      filters: Option[List[ListEventTypesFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEventTypesRequest =
      ListEventTypesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listNotificationRulesFilter(
      name: Option[String] = None,
      value: Option[String] = None
    ): ListNotificationRulesFilter =
      ListNotificationRulesFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def listNotificationRulesRequest(
      filters: Option[List[ListNotificationRulesFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListNotificationRulesRequest =
      ListNotificationRulesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceRequest(
      arn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def listTargetsFilter(
      name: Option[String] = None,
      value: Option[String] = None
    ): ListTargetsFilter =
      ListTargetsFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def listTargetsRequest(
      filters: Option[List[ListTargetsFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTargetsRequest =
      ListTargetsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def notificationRuleSummary(
      id: Option[String] = None,
      arn: Option[String] = None
    ): NotificationRuleSummary =
      NotificationRuleSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
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

    def subscribeRequest(
      arn: Option[String] = None,
      target: Option[Target] = None,
      clientRequestToken: Option[String] = None
    ): SubscribeRequest =
      SubscribeRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(target)(_.target(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def tagResourceRequest(
      arn: Option[String] = None,
      tags: Option[Tags] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def target(
      targetType: Option[String] = None,
      targetAddress: Option[String] = None
    ): Target =
      Target
        .builder
        .ifSome(targetType)(_.targetType(_))
        .ifSome(targetAddress)(_.targetAddress(_))
        .build

    def targetSummary(
      targetAddress: Option[String] = None,
      targetType: Option[String] = None,
      targetStatus: Option[String] = None
    ): TargetSummary =
      TargetSummary
        .builder
        .ifSome(targetAddress)(_.targetAddress(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(targetStatus)(_.targetStatus(_))
        .build

    def unsubscribeRequest(
      arn: Option[String] = None,
      targetAddress: Option[String] = None
    ): UnsubscribeRequest =
      UnsubscribeRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(targetAddress)(_.targetAddress(_))
        .build

    def untagResourceRequest(
      arn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateNotificationRuleRequest(
      arn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      eventTypeIds: Option[List[EventTypeId]] = None,
      targets: Option[List[Target]] = None,
      detailType: Option[String] = None
    ): UpdateNotificationRuleRequest =
      UpdateNotificationRuleRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(eventTypeIds)(_.eventTypeIds(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(detailType)(_.detailType(_))
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
