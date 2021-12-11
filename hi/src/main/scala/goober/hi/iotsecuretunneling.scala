package goober.hi

import goober.free.iotsecuretunneling.IoTSecureTunnelingIO
import software.amazon.awssdk.services.iotsecuretunneling.model._


object iotsecuretunneling {
  import goober.free.{iotsecuretunneling ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def closeTunnelRequest(
      tunnelId: Option[String] = None,
      delete: Option[Boolean] = None
    ): CloseTunnelRequest =
      CloseTunnelRequest
        .builder
        .ifSome(tunnelId)(_.tunnelId(_))
        .ifSome(delete)(_.delete(_))
        .build

    def closeTunnelResponse(

    ): CloseTunnelResponse =
      CloseTunnelResponse
        .builder

        .build

    def connectionState(
      status: Option[String] = None,
      lastUpdatedAt: Option[DateType] = None
    ): ConnectionState =
      ConnectionState
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def describeTunnelRequest(
      tunnelId: Option[String] = None
    ): DescribeTunnelRequest =
      DescribeTunnelRequest
        .builder
        .ifSome(tunnelId)(_.tunnelId(_))
        .build

    def describeTunnelResponse(
      tunnel: Option[Tunnel] = None
    ): DescribeTunnelResponse =
      DescribeTunnelResponse
        .builder
        .ifSome(tunnel)(_.tunnel(_))
        .build

    def destinationConfig(
      thingName: Option[String] = None,
      services: Option[List[Service]] = None
    ): DestinationConfig =
      DestinationConfig
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(services)(_.services(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listTunnelsRequest(
      thingName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTunnelsRequest =
      ListTunnelsRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTunnelsResponse(
      tunnelSummaries: Option[List[TunnelSummary]] = None,
      nextToken: Option[String] = None
    ): ListTunnelsResponse =
      ListTunnelsResponse
        .builder
        .ifSome(tunnelSummaries)(_.tunnelSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def openTunnelRequest(
      description: Option[String] = None,
      tags: Option[List[Tag]] = None,
      destinationConfig: Option[DestinationConfig] = None,
      timeoutConfig: Option[TimeoutConfig] = None
    ): OpenTunnelRequest =
      OpenTunnelRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .build

    def openTunnelResponse(
      tunnelId: Option[String] = None,
      tunnelArn: Option[String] = None,
      sourceAccessToken: Option[String] = None,
      destinationAccessToken: Option[String] = None
    ): OpenTunnelResponse =
      OpenTunnelResponse
        .builder
        .ifSome(tunnelId)(_.tunnelId(_))
        .ifSome(tunnelArn)(_.tunnelArn(_))
        .ifSome(sourceAccessToken)(_.sourceAccessToken(_))
        .ifSome(destinationAccessToken)(_.destinationAccessToken(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
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

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def timeoutConfig(
      maxLifetimeTimeoutMinutes: Option[Int] = None
    ): TimeoutConfig =
      TimeoutConfig
        .builder
        .ifSome(maxLifetimeTimeoutMinutes)(_.maxLifetimeTimeoutMinutes(_))
        .build

    def tunnel(
      tunnelId: Option[String] = None,
      tunnelArn: Option[String] = None,
      status: Option[String] = None,
      sourceConnectionState: Option[ConnectionState] = None,
      destinationConnectionState: Option[ConnectionState] = None,
      description: Option[String] = None,
      destinationConfig: Option[DestinationConfig] = None,
      timeoutConfig: Option[TimeoutConfig] = None,
      tags: Option[List[Tag]] = None,
      createdAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None
    ): Tunnel =
      Tunnel
        .builder
        .ifSome(tunnelId)(_.tunnelId(_))
        .ifSome(tunnelArn)(_.tunnelArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(sourceConnectionState)(_.sourceConnectionState(_))
        .ifSome(destinationConnectionState)(_.destinationConnectionState(_))
        .ifSome(description)(_.description(_))
        .ifSome(destinationConfig)(_.destinationConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def tunnelSummary(
      tunnelId: Option[String] = None,
      tunnelArn: Option[String] = None,
      status: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None
    ): TunnelSummary =
      TunnelSummary
        .builder
        .ifSome(tunnelId)(_.tunnelId(_))
        .ifSome(tunnelArn)(_.tunnelArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
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

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
