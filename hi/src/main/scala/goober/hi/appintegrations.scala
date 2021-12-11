package goober.hi

import goober.free.appintegrations.AppIntegrationsIO
import software.amazon.awssdk.services.appintegrations.model._


object appintegrations {
  import goober.free.{appintegrations ⇒ free}

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

    def createEventIntegrationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      eventFilter: Option[EventFilter] = None,
      eventBridgeBus: Option[String] = None,
      clientToken: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateEventIntegrationRequest =
      CreateEventIntegrationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventFilter)(_.eventFilter(_))
        .ifSome(eventBridgeBus)(_.eventBridgeBus(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEventIntegrationResponse(
      eventIntegrationArn: Option[String] = None
    ): CreateEventIntegrationResponse =
      CreateEventIntegrationResponse
        .builder
        .ifSome(eventIntegrationArn)(_.eventIntegrationArn(_))
        .build

    def deleteEventIntegrationRequest(
      name: Option[String] = None
    ): DeleteEventIntegrationRequest =
      DeleteEventIntegrationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteEventIntegrationResponse(

    ): DeleteEventIntegrationResponse =
      DeleteEventIntegrationResponse
        .builder

        .build

    def duplicateResourceException(
      message: Option[String] = None
    ): DuplicateResourceException =
      DuplicateResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def eventFilter(
      source: Option[String] = None
    ): EventFilter =
      EventFilter
        .builder
        .ifSome(source)(_.source(_))
        .build

    def eventIntegration(
      eventIntegrationArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      eventFilter: Option[EventFilter] = None,
      eventBridgeBus: Option[String] = None,
      tags: Option[TagMap] = None
    ): EventIntegration =
      EventIntegration
        .builder
        .ifSome(eventIntegrationArn)(_.eventIntegrationArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventFilter)(_.eventFilter(_))
        .ifSome(eventBridgeBus)(_.eventBridgeBus(_))
        .ifSome(tags)(_.tags(_))
        .build

    def eventIntegrationAssociation(
      eventIntegrationAssociationArn: Option[String] = None,
      eventIntegrationAssociationId: Option[String] = None,
      eventIntegrationName: Option[String] = None,
      clientId: Option[String] = None,
      eventBridgeRuleName: Option[String] = None,
      clientAssociationMetadata: Option[ClientAssociationMetadata] = None
    ): EventIntegrationAssociation =
      EventIntegrationAssociation
        .builder
        .ifSome(eventIntegrationAssociationArn)(_.eventIntegrationAssociationArn(_))
        .ifSome(eventIntegrationAssociationId)(_.eventIntegrationAssociationId(_))
        .ifSome(eventIntegrationName)(_.eventIntegrationName(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(eventBridgeRuleName)(_.eventBridgeRuleName(_))
        .ifSome(clientAssociationMetadata)(_.clientAssociationMetadata(_))
        .build

    def getEventIntegrationRequest(
      name: Option[String] = None
    ): GetEventIntegrationRequest =
      GetEventIntegrationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getEventIntegrationResponse(
      name: Option[String] = None,
      description: Option[String] = None,
      eventIntegrationArn: Option[String] = None,
      eventBridgeBus: Option[String] = None,
      eventFilter: Option[EventFilter] = None,
      tags: Option[TagMap] = None
    ): GetEventIntegrationResponse =
      GetEventIntegrationResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(eventIntegrationArn)(_.eventIntegrationArn(_))
        .ifSome(eventBridgeBus)(_.eventBridgeBus(_))
        .ifSome(eventFilter)(_.eventFilter(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServiceError(
      message: Option[String] = None
    ): InternalServiceError =
      InternalServiceError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listEventIntegrationAssociationsRequest(
      eventIntegrationName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEventIntegrationAssociationsRequest =
      ListEventIntegrationAssociationsRequest
        .builder
        .ifSome(eventIntegrationName)(_.eventIntegrationName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEventIntegrationAssociationsResponse(
      eventIntegrationAssociations: Option[List[EventIntegrationAssociation]] = None,
      nextToken: Option[String] = None
    ): ListEventIntegrationAssociationsResponse =
      ListEventIntegrationAssociationsResponse
        .builder
        .ifSome(eventIntegrationAssociations)(_.eventIntegrationAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventIntegrationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEventIntegrationsRequest =
      ListEventIntegrationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEventIntegrationsResponse(
      eventIntegrations: Option[List[EventIntegration]] = None,
      nextToken: Option[String] = None
    ): ListEventIntegrationsResponse =
      ListEventIntegrationsResponse
        .builder
        .ifSome(eventIntegrations)(_.eventIntegrations(_))
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

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceQuotaExceededException(
      message: Option[String] = None
    ): ResourceQuotaExceededException =
      ResourceQuotaExceededException
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

    def updateEventIntegrationRequest(
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateEventIntegrationRequest =
      UpdateEventIntegrationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateEventIntegrationResponse(

    ): UpdateEventIntegrationResponse =
      UpdateEventIntegrationResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
