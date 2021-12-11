package goober.hi

import goober.free.personalizeevents.PersonalizeEventsIO
import software.amazon.awssdk.services.personalizeevents.model._


object personalizeevents {
  import goober.free.{personalizeevents ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def event(
      eventId: Option[String] = None,
      eventType: Option[String] = None,
      eventValue: Option[FloatType] = None,
      itemId: Option[String] = None,
      properties: Option[String] = None,
      sentAt: Option[Date] = None,
      recommendationId: Option[String] = None,
      impression: Option[List[ItemId]] = None
    ): Event =
      Event
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(eventValue)(_.eventValue(_))
        .ifSome(itemId)(_.itemId(_))
        .ifSome(properties)(_.properties(_))
        .ifSome(sentAt)(_.sentAt(_))
        .ifSome(recommendationId)(_.recommendationId(_))
        .ifSome(impression)(_.impression(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def item(
      itemId: Option[String] = None,
      properties: Option[String] = None
    ): Item =
      Item
        .builder
        .ifSome(itemId)(_.itemId(_))
        .ifSome(properties)(_.properties(_))
        .build

    def putEventsRequest(
      trackingId: Option[String] = None,
      userId: Option[String] = None,
      sessionId: Option[String] = None,
      eventList: Option[List[Event]] = None
    ): PutEventsRequest =
      PutEventsRequest
        .builder
        .ifSome(trackingId)(_.trackingId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(eventList)(_.eventList(_))
        .build

    def putItemsRequest(
      datasetArn: Option[String] = None,
      items: Option[List[Item]] = None
    ): PutItemsRequest =
      PutItemsRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(items)(_.items(_))
        .build

    def putUsersRequest(
      datasetArn: Option[String] = None,
      users: Option[List[User]] = None
    ): PutUsersRequest =
      PutUsersRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(users)(_.users(_))
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

    def user(
      userId: Option[String] = None,
      properties: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(properties)(_.properties(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
