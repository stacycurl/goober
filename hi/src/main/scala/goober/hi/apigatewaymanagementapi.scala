package goober.hi

import goober.free.apigatewaymanagementapi.ApiGatewayManagementApiIO
import software.amazon.awssdk.services.apigatewaymanagementapi.model._


object apigatewaymanagementapi {
  import goober.free.{apigatewaymanagementapi ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def deleteConnectionRequest(
      connectionId: Option[String] = None
    ): DeleteConnectionRequest =
      DeleteConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def forbiddenException(

    ): ForbiddenException =
      ForbiddenException
        .builder

        .build

    def getConnectionRequest(
      connectionId: Option[String] = None
    ): GetConnectionRequest =
      GetConnectionRequest
        .builder
        .ifSome(connectionId)(_.connectionId(_))
        .build

    def getConnectionResponse(
      connectedAt: Option[__timestampIso8601] = None,
      identity: Option[Identity] = None,
      lastActiveAt: Option[__timestampIso8601] = None
    ): GetConnectionResponse =
      GetConnectionResponse
        .builder
        .ifSome(connectedAt)(_.connectedAt(_))
        .ifSome(identity)(_.identity(_))
        .ifSome(lastActiveAt)(_.lastActiveAt(_))
        .build

    def goneException(

    ): GoneException =
      GoneException
        .builder

        .build

    def identity(
      sourceIp: Option[String] = None,
      userAgent: Option[String] = None
    ): Identity =
      Identity
        .builder
        .ifSome(sourceIp)(_.sourceIp(_))
        .ifSome(userAgent)(_.userAgent(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def payloadTooLargeException(
      message: Option[String] = None
    ): PayloadTooLargeException =
      PayloadTooLargeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def postToConnectionRequest(
      data: Option[Data] = None,
      connectionId: Option[String] = None
    ): PostToConnectionRequest =
      PostToConnectionRequest
        .builder
        .ifSome(data)(_.data(_))
        .ifSome(connectionId)(_.connectionId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
