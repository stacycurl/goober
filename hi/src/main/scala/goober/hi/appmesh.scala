package goober.hi

import goober.free.appmesh.AppMeshIO
import software.amazon.awssdk.services.appmesh.model._


object appmesh {
  import goober.free.{appmesh ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessLog(
      file: Option[FileAccessLog] = None
    ): AccessLog =
      AccessLog
        .builder
        .ifSome(file)(_.file(_))
        .build

    def awsCloudMapInstanceAttribute(
      key: Option[String] = None,
      value: Option[String] = None
    ): AwsCloudMapInstanceAttribute =
      AwsCloudMapInstanceAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def awsCloudMapServiceDiscovery(
      attributes: Option[List[AwsCloudMapInstanceAttribute]] = None,
      namespaceName: Option[String] = None,
      serviceName: Option[String] = None
    ): AwsCloudMapServiceDiscovery =
      AwsCloudMapServiceDiscovery
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(namespaceName)(_.namespaceName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def backend(
      virtualService: Option[VirtualServiceBackend] = None
    ): Backend =
      Backend
        .builder
        .ifSome(virtualService)(_.virtualService(_))
        .build

    def backendDefaults(
      clientPolicy: Option[ClientPolicy] = None
    ): BackendDefaults =
      BackendDefaults
        .builder
        .ifSome(clientPolicy)(_.clientPolicy(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def clientPolicy(
      tls: Option[ClientPolicyTls] = None
    ): ClientPolicy =
      ClientPolicy
        .builder
        .ifSome(tls)(_.tls(_))
        .build

    def clientPolicyTls(
      certificate: Option[ClientTlsCertificate] = None,
      enforce: Option[Boolean] = None,
      ports: Option[List[PortNumber]] = None,
      validation: Option[TlsValidationContext] = None
    ): ClientPolicyTls =
      ClientPolicyTls
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(enforce)(_.enforce(_))
        .ifSome(ports)(_.ports(_))
        .ifSome(validation)(_.validation(_))
        .build

    def clientTlsCertificate(
      file: Option[ListenerTlsFileCertificate] = None,
      sds: Option[ListenerTlsSdsCertificate] = None
    ): ClientTlsCertificate =
      ClientTlsCertificate
        .builder
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createGatewayRouteInput(
      clientToken: Option[String] = None,
      gatewayRouteName: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[GatewayRouteSpec] = None,
      tags: Option[List[TagRef]] = None,
      virtualGatewayName: Option[String] = None
    ): CreateGatewayRouteInput =
      CreateGatewayRouteInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(gatewayRouteName)(_.gatewayRouteName(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def createGatewayRouteOutput(
      gatewayRoute: Option[GatewayRouteData] = None
    ): CreateGatewayRouteOutput =
      CreateGatewayRouteOutput
        .builder
        .ifSome(gatewayRoute)(_.gatewayRoute(_))
        .build

    def createMeshInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      spec: Option[MeshSpec] = None,
      tags: Option[List[TagRef]] = None
    ): CreateMeshInput =
      CreateMeshInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMeshOutput(
      mesh: Option[MeshData] = None
    ): CreateMeshOutput =
      CreateMeshOutput
        .builder
        .ifSome(mesh)(_.mesh(_))
        .build

    def createRouteInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      routeName: Option[String] = None,
      spec: Option[RouteSpec] = None,
      tags: Option[List[TagRef]] = None,
      virtualRouterName: Option[String] = None
    ): CreateRouteInput =
      CreateRouteInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(routeName)(_.routeName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def createRouteOutput(
      route: Option[RouteData] = None
    ): CreateRouteOutput =
      CreateRouteOutput
        .builder
        .ifSome(route)(_.route(_))
        .build

    def createVirtualGatewayInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualGatewaySpec] = None,
      tags: Option[List[TagRef]] = None,
      virtualGatewayName: Option[String] = None
    ): CreateVirtualGatewayInput =
      CreateVirtualGatewayInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def createVirtualGatewayOutput(
      virtualGateway: Option[VirtualGatewayData] = None
    ): CreateVirtualGatewayOutput =
      CreateVirtualGatewayOutput
        .builder
        .ifSome(virtualGateway)(_.virtualGateway(_))
        .build

    def createVirtualNodeInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualNodeSpec] = None,
      tags: Option[List[TagRef]] = None,
      virtualNodeName: Option[String] = None
    ): CreateVirtualNodeInput =
      CreateVirtualNodeInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def createVirtualNodeOutput(
      virtualNode: Option[VirtualNodeData] = None
    ): CreateVirtualNodeOutput =
      CreateVirtualNodeOutput
        .builder
        .ifSome(virtualNode)(_.virtualNode(_))
        .build

    def createVirtualRouterInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualRouterSpec] = None,
      tags: Option[List[TagRef]] = None,
      virtualRouterName: Option[String] = None
    ): CreateVirtualRouterInput =
      CreateVirtualRouterInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def createVirtualRouterOutput(
      virtualRouter: Option[VirtualRouterData] = None
    ): CreateVirtualRouterOutput =
      CreateVirtualRouterOutput
        .builder
        .ifSome(virtualRouter)(_.virtualRouter(_))
        .build

    def createVirtualServiceInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualServiceSpec] = None,
      tags: Option[List[TagRef]] = None,
      virtualServiceName: Option[String] = None
    ): CreateVirtualServiceInput =
      CreateVirtualServiceInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def createVirtualServiceOutput(
      virtualService: Option[VirtualServiceData] = None
    ): CreateVirtualServiceOutput =
      CreateVirtualServiceOutput
        .builder
        .ifSome(virtualService)(_.virtualService(_))
        .build

    def deleteGatewayRouteInput(
      gatewayRouteName: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualGatewayName: Option[String] = None
    ): DeleteGatewayRouteInput =
      DeleteGatewayRouteInput
        .builder
        .ifSome(gatewayRouteName)(_.gatewayRouteName(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def deleteGatewayRouteOutput(
      gatewayRoute: Option[GatewayRouteData] = None
    ): DeleteGatewayRouteOutput =
      DeleteGatewayRouteOutput
        .builder
        .ifSome(gatewayRoute)(_.gatewayRoute(_))
        .build

    def deleteMeshInput(
      meshName: Option[String] = None
    ): DeleteMeshInput =
      DeleteMeshInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .build

    def deleteMeshOutput(
      mesh: Option[MeshData] = None
    ): DeleteMeshOutput =
      DeleteMeshOutput
        .builder
        .ifSome(mesh)(_.mesh(_))
        .build

    def deleteRouteInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      routeName: Option[String] = None,
      virtualRouterName: Option[String] = None
    ): DeleteRouteInput =
      DeleteRouteInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(routeName)(_.routeName(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def deleteRouteOutput(
      route: Option[RouteData] = None
    ): DeleteRouteOutput =
      DeleteRouteOutput
        .builder
        .ifSome(route)(_.route(_))
        .build

    def deleteVirtualGatewayInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualGatewayName: Option[String] = None
    ): DeleteVirtualGatewayInput =
      DeleteVirtualGatewayInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def deleteVirtualGatewayOutput(
      virtualGateway: Option[VirtualGatewayData] = None
    ): DeleteVirtualGatewayOutput =
      DeleteVirtualGatewayOutput
        .builder
        .ifSome(virtualGateway)(_.virtualGateway(_))
        .build

    def deleteVirtualNodeInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualNodeName: Option[String] = None
    ): DeleteVirtualNodeInput =
      DeleteVirtualNodeInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def deleteVirtualNodeOutput(
      virtualNode: Option[VirtualNodeData] = None
    ): DeleteVirtualNodeOutput =
      DeleteVirtualNodeOutput
        .builder
        .ifSome(virtualNode)(_.virtualNode(_))
        .build

    def deleteVirtualRouterInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualRouterName: Option[String] = None
    ): DeleteVirtualRouterInput =
      DeleteVirtualRouterInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def deleteVirtualRouterOutput(
      virtualRouter: Option[VirtualRouterData] = None
    ): DeleteVirtualRouterOutput =
      DeleteVirtualRouterOutput
        .builder
        .ifSome(virtualRouter)(_.virtualRouter(_))
        .build

    def deleteVirtualServiceInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualServiceName: Option[String] = None
    ): DeleteVirtualServiceInput =
      DeleteVirtualServiceInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def deleteVirtualServiceOutput(
      virtualService: Option[VirtualServiceData] = None
    ): DeleteVirtualServiceOutput =
      DeleteVirtualServiceOutput
        .builder
        .ifSome(virtualService)(_.virtualService(_))
        .build

    def describeGatewayRouteInput(
      gatewayRouteName: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualGatewayName: Option[String] = None
    ): DescribeGatewayRouteInput =
      DescribeGatewayRouteInput
        .builder
        .ifSome(gatewayRouteName)(_.gatewayRouteName(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def describeGatewayRouteOutput(
      gatewayRoute: Option[GatewayRouteData] = None
    ): DescribeGatewayRouteOutput =
      DescribeGatewayRouteOutput
        .builder
        .ifSome(gatewayRoute)(_.gatewayRoute(_))
        .build

    def describeMeshInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None
    ): DescribeMeshInput =
      DescribeMeshInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .build

    def describeMeshOutput(
      mesh: Option[MeshData] = None
    ): DescribeMeshOutput =
      DescribeMeshOutput
        .builder
        .ifSome(mesh)(_.mesh(_))
        .build

    def describeRouteInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      routeName: Option[String] = None,
      virtualRouterName: Option[String] = None
    ): DescribeRouteInput =
      DescribeRouteInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(routeName)(_.routeName(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def describeRouteOutput(
      route: Option[RouteData] = None
    ): DescribeRouteOutput =
      DescribeRouteOutput
        .builder
        .ifSome(route)(_.route(_))
        .build

    def describeVirtualGatewayInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualGatewayName: Option[String] = None
    ): DescribeVirtualGatewayInput =
      DescribeVirtualGatewayInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def describeVirtualGatewayOutput(
      virtualGateway: Option[VirtualGatewayData] = None
    ): DescribeVirtualGatewayOutput =
      DescribeVirtualGatewayOutput
        .builder
        .ifSome(virtualGateway)(_.virtualGateway(_))
        .build

    def describeVirtualNodeInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualNodeName: Option[String] = None
    ): DescribeVirtualNodeInput =
      DescribeVirtualNodeInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def describeVirtualNodeOutput(
      virtualNode: Option[VirtualNodeData] = None
    ): DescribeVirtualNodeOutput =
      DescribeVirtualNodeOutput
        .builder
        .ifSome(virtualNode)(_.virtualNode(_))
        .build

    def describeVirtualRouterInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualRouterName: Option[String] = None
    ): DescribeVirtualRouterInput =
      DescribeVirtualRouterInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def describeVirtualRouterOutput(
      virtualRouter: Option[VirtualRouterData] = None
    ): DescribeVirtualRouterOutput =
      DescribeVirtualRouterOutput
        .builder
        .ifSome(virtualRouter)(_.virtualRouter(_))
        .build

    def describeVirtualServiceInput(
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      virtualServiceName: Option[String] = None
    ): DescribeVirtualServiceInput =
      DescribeVirtualServiceInput
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def describeVirtualServiceOutput(
      virtualService: Option[VirtualServiceData] = None
    ): DescribeVirtualServiceOutput =
      DescribeVirtualServiceOutput
        .builder
        .ifSome(virtualService)(_.virtualService(_))
        .build

    def dnsServiceDiscovery(
      hostname: Option[String] = None,
      responseType: Option[String] = None
    ): DnsServiceDiscovery =
      DnsServiceDiscovery
        .builder
        .ifSome(hostname)(_.hostname(_))
        .ifSome(responseType)(_.responseType(_))
        .build

    def duration(
      unit: Option[String] = None,
      value: Option[DurationValue] = None
    ): Duration =
      Duration
        .builder
        .ifSome(unit)(_.unit(_))
        .ifSome(value)(_.value(_))
        .build

    def egressFilter(
      `type`: Option[String] = None
    ): EgressFilter =
      EgressFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def fileAccessLog(
      path: Option[String] = None
    ): FileAccessLog =
      FileAccessLog
        .builder
        .ifSome(path)(_.path(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def gatewayRouteData(
      gatewayRouteName: Option[String] = None,
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      spec: Option[GatewayRouteSpec] = None,
      status: Option[GatewayRouteStatus] = None,
      virtualGatewayName: Option[String] = None
    ): GatewayRouteData =
      GatewayRouteData
        .builder
        .ifSome(gatewayRouteName)(_.gatewayRouteName(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def gatewayRouteHostnameMatch(
      exact: Option[String] = None,
      suffix: Option[String] = None
    ): GatewayRouteHostnameMatch =
      GatewayRouteHostnameMatch
        .builder
        .ifSome(exact)(_.exact(_))
        .ifSome(suffix)(_.suffix(_))
        .build

    def gatewayRouteHostnameRewrite(
      defaultTargetHostname: Option[String] = None
    ): GatewayRouteHostnameRewrite =
      GatewayRouteHostnameRewrite
        .builder
        .ifSome(defaultTargetHostname)(_.defaultTargetHostname(_))
        .build

    def gatewayRouteRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      gatewayRouteName: Option[String] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      version: Option[Long] = None,
      virtualGatewayName: Option[String] = None
    ): GatewayRouteRef =
      GatewayRouteRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(gatewayRouteName)(_.gatewayRouteName(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(version)(_.version(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def gatewayRouteSpec(
      grpcRoute: Option[GrpcGatewayRoute] = None,
      http2Route: Option[HttpGatewayRoute] = None,
      httpRoute: Option[HttpGatewayRoute] = None,
      priority: Option[Int] = None
    ): GatewayRouteSpec =
      GatewayRouteSpec
        .builder
        .ifSome(grpcRoute)(_.grpcRoute(_))
        .ifSome(http2Route)(_.http2Route(_))
        .ifSome(httpRoute)(_.httpRoute(_))
        .ifSome(priority)(_.priority(_))
        .build

    def gatewayRouteStatus(
      status: Option[String] = None
    ): GatewayRouteStatus =
      GatewayRouteStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def gatewayRouteTarget(
      virtualService: Option[GatewayRouteVirtualService] = None
    ): GatewayRouteTarget =
      GatewayRouteTarget
        .builder
        .ifSome(virtualService)(_.virtualService(_))
        .build

    def gatewayRouteVirtualService(
      virtualServiceName: Option[String] = None
    ): GatewayRouteVirtualService =
      GatewayRouteVirtualService
        .builder
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def grpcGatewayRoute(
      action: Option[GrpcGatewayRouteAction] = None,
      match: Option[GrpcGatewayRouteMatch] = None
    ): GrpcGatewayRoute =
      GrpcGatewayRoute
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(match)(_.match(_))
        .build

    def grpcGatewayRouteAction(
      rewrite: Option[GrpcGatewayRouteRewrite] = None,
      target: Option[GatewayRouteTarget] = None
    ): GrpcGatewayRouteAction =
      GrpcGatewayRouteAction
        .builder
        .ifSome(rewrite)(_.rewrite(_))
        .ifSome(target)(_.target(_))
        .build

    def grpcGatewayRouteMatch(
      hostname: Option[GatewayRouteHostnameMatch] = None,
      metadata: Option[List[GrpcGatewayRouteMetadata]] = None,
      serviceName: Option[String] = None
    ): GrpcGatewayRouteMatch =
      GrpcGatewayRouteMatch
        .builder
        .ifSome(hostname)(_.hostname(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def grpcGatewayRouteMetadata(
      invert: Option[Boolean] = None,
      match: Option[GrpcMetadataMatchMethod] = None,
      name: Option[String] = None
    ): GrpcGatewayRouteMetadata =
      GrpcGatewayRouteMetadata
        .builder
        .ifSome(invert)(_.invert(_))
        .ifSome(match)(_.match(_))
        .ifSome(name)(_.name(_))
        .build

    def grpcGatewayRouteRewrite(
      hostname: Option[GatewayRouteHostnameRewrite] = None
    ): GrpcGatewayRouteRewrite =
      GrpcGatewayRouteRewrite
        .builder
        .ifSome(hostname)(_.hostname(_))
        .build

    def grpcMetadataMatchMethod(
      exact: Option[String] = None,
      prefix: Option[String] = None,
      range: Option[MatchRange] = None,
      regex: Option[String] = None,
      suffix: Option[String] = None
    ): GrpcMetadataMatchMethod =
      GrpcMetadataMatchMethod
        .builder
        .ifSome(exact)(_.exact(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(range)(_.range(_))
        .ifSome(regex)(_.regex(_))
        .ifSome(suffix)(_.suffix(_))
        .build

    def grpcRetryPolicy(
      grpcRetryEvents: Option[List[GrpcRetryPolicyEvent]] = None,
      httpRetryEvents: Option[List[HttpRetryPolicyEvent]] = None,
      maxRetries: Option[MaxRetries] = None,
      perRetryTimeout: Option[Duration] = None,
      tcpRetryEvents: Option[List[TcpRetryPolicyEvent]] = None
    ): GrpcRetryPolicy =
      GrpcRetryPolicy
        .builder
        .ifSome(grpcRetryEvents)(_.grpcRetryEvents(_))
        .ifSome(httpRetryEvents)(_.httpRetryEvents(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(perRetryTimeout)(_.perRetryTimeout(_))
        .ifSome(tcpRetryEvents)(_.tcpRetryEvents(_))
        .build

    def grpcRoute(
      action: Option[GrpcRouteAction] = None,
      match: Option[GrpcRouteMatch] = None,
      retryPolicy: Option[GrpcRetryPolicy] = None,
      timeout: Option[GrpcTimeout] = None
    ): GrpcRoute =
      GrpcRoute
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(match)(_.match(_))
        .ifSome(retryPolicy)(_.retryPolicy(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def grpcRouteAction(
      weightedTargets: Option[List[WeightedTarget]] = None
    ): GrpcRouteAction =
      GrpcRouteAction
        .builder
        .ifSome(weightedTargets)(_.weightedTargets(_))
        .build

    def grpcRouteMatch(
      metadata: Option[List[GrpcRouteMetadata]] = None,
      methodName: Option[String] = None,
      serviceName: Option[String] = None
    ): GrpcRouteMatch =
      GrpcRouteMatch
        .builder
        .ifSome(metadata)(_.metadata(_))
        .ifSome(methodName)(_.methodName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def grpcRouteMetadata(
      invert: Option[Boolean] = None,
      match: Option[GrpcRouteMetadataMatchMethod] = None,
      name: Option[String] = None
    ): GrpcRouteMetadata =
      GrpcRouteMetadata
        .builder
        .ifSome(invert)(_.invert(_))
        .ifSome(match)(_.match(_))
        .ifSome(name)(_.name(_))
        .build

    def grpcRouteMetadataMatchMethod(
      exact: Option[String] = None,
      prefix: Option[String] = None,
      range: Option[MatchRange] = None,
      regex: Option[String] = None,
      suffix: Option[String] = None
    ): GrpcRouteMetadataMatchMethod =
      GrpcRouteMetadataMatchMethod
        .builder
        .ifSome(exact)(_.exact(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(range)(_.range(_))
        .ifSome(regex)(_.regex(_))
        .ifSome(suffix)(_.suffix(_))
        .build

    def grpcTimeout(
      idle: Option[Duration] = None,
      perRequest: Option[Duration] = None
    ): GrpcTimeout =
      GrpcTimeout
        .builder
        .ifSome(idle)(_.idle(_))
        .ifSome(perRequest)(_.perRequest(_))
        .build

    def headerMatchMethod(
      exact: Option[String] = None,
      prefix: Option[String] = None,
      range: Option[MatchRange] = None,
      regex: Option[String] = None,
      suffix: Option[String] = None
    ): HeaderMatchMethod =
      HeaderMatchMethod
        .builder
        .ifSome(exact)(_.exact(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(range)(_.range(_))
        .ifSome(regex)(_.regex(_))
        .ifSome(suffix)(_.suffix(_))
        .build

    def healthCheckPolicy(
      healthyThreshold: Option[Int] = None,
      intervalMillis: Option[HealthCheckIntervalMillis] = None,
      path: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      timeoutMillis: Option[HealthCheckTimeoutMillis] = None,
      unhealthyThreshold: Option[Int] = None
    ): HealthCheckPolicy =
      HealthCheckPolicy
        .builder
        .ifSome(healthyThreshold)(_.healthyThreshold(_))
        .ifSome(intervalMillis)(_.intervalMillis(_))
        .ifSome(path)(_.path(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(timeoutMillis)(_.timeoutMillis(_))
        .ifSome(unhealthyThreshold)(_.unhealthyThreshold(_))
        .build

    def httpGatewayRoute(
      action: Option[HttpGatewayRouteAction] = None,
      match: Option[HttpGatewayRouteMatch] = None
    ): HttpGatewayRoute =
      HttpGatewayRoute
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(match)(_.match(_))
        .build

    def httpGatewayRouteAction(
      rewrite: Option[HttpGatewayRouteRewrite] = None,
      target: Option[GatewayRouteTarget] = None
    ): HttpGatewayRouteAction =
      HttpGatewayRouteAction
        .builder
        .ifSome(rewrite)(_.rewrite(_))
        .ifSome(target)(_.target(_))
        .build

    def httpGatewayRouteHeader(
      invert: Option[Boolean] = None,
      match: Option[HeaderMatchMethod] = None,
      name: Option[String] = None
    ): HttpGatewayRouteHeader =
      HttpGatewayRouteHeader
        .builder
        .ifSome(invert)(_.invert(_))
        .ifSome(match)(_.match(_))
        .ifSome(name)(_.name(_))
        .build

    def httpGatewayRouteMatch(
      headers: Option[List[HttpGatewayRouteHeader]] = None,
      hostname: Option[GatewayRouteHostnameMatch] = None,
      method: Option[String] = None,
      path: Option[HttpPathMatch] = None,
      prefix: Option[String] = None,
      queryParameters: Option[List[HttpQueryParameter]] = None
    ): HttpGatewayRouteMatch =
      HttpGatewayRouteMatch
        .builder
        .ifSome(headers)(_.headers(_))
        .ifSome(hostname)(_.hostname(_))
        .ifSome(method)(_.method(_))
        .ifSome(path)(_.path(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(queryParameters)(_.queryParameters(_))
        .build

    def httpGatewayRoutePathRewrite(
      exact: Option[String] = None
    ): HttpGatewayRoutePathRewrite =
      HttpGatewayRoutePathRewrite
        .builder
        .ifSome(exact)(_.exact(_))
        .build

    def httpGatewayRoutePrefixRewrite(
      defaultPrefix: Option[String] = None,
      value: Option[String] = None
    ): HttpGatewayRoutePrefixRewrite =
      HttpGatewayRoutePrefixRewrite
        .builder
        .ifSome(defaultPrefix)(_.defaultPrefix(_))
        .ifSome(value)(_.value(_))
        .build

    def httpGatewayRouteRewrite(
      hostname: Option[GatewayRouteHostnameRewrite] = None,
      path: Option[HttpGatewayRoutePathRewrite] = None,
      prefix: Option[HttpGatewayRoutePrefixRewrite] = None
    ): HttpGatewayRouteRewrite =
      HttpGatewayRouteRewrite
        .builder
        .ifSome(hostname)(_.hostname(_))
        .ifSome(path)(_.path(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def httpPathMatch(
      exact: Option[String] = None,
      regex: Option[String] = None
    ): HttpPathMatch =
      HttpPathMatch
        .builder
        .ifSome(exact)(_.exact(_))
        .ifSome(regex)(_.regex(_))
        .build

    def httpQueryParameter(
      match: Option[QueryParameterMatch] = None,
      name: Option[String] = None
    ): HttpQueryParameter =
      HttpQueryParameter
        .builder
        .ifSome(match)(_.match(_))
        .ifSome(name)(_.name(_))
        .build

    def httpRetryPolicy(
      httpRetryEvents: Option[List[HttpRetryPolicyEvent]] = None,
      maxRetries: Option[MaxRetries] = None,
      perRetryTimeout: Option[Duration] = None,
      tcpRetryEvents: Option[List[TcpRetryPolicyEvent]] = None
    ): HttpRetryPolicy =
      HttpRetryPolicy
        .builder
        .ifSome(httpRetryEvents)(_.httpRetryEvents(_))
        .ifSome(maxRetries)(_.maxRetries(_))
        .ifSome(perRetryTimeout)(_.perRetryTimeout(_))
        .ifSome(tcpRetryEvents)(_.tcpRetryEvents(_))
        .build

    def httpRoute(
      action: Option[HttpRouteAction] = None,
      match: Option[HttpRouteMatch] = None,
      retryPolicy: Option[HttpRetryPolicy] = None,
      timeout: Option[HttpTimeout] = None
    ): HttpRoute =
      HttpRoute
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(match)(_.match(_))
        .ifSome(retryPolicy)(_.retryPolicy(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def httpRouteAction(
      weightedTargets: Option[List[WeightedTarget]] = None
    ): HttpRouteAction =
      HttpRouteAction
        .builder
        .ifSome(weightedTargets)(_.weightedTargets(_))
        .build

    def httpRouteHeader(
      invert: Option[Boolean] = None,
      match: Option[HeaderMatchMethod] = None,
      name: Option[String] = None
    ): HttpRouteHeader =
      HttpRouteHeader
        .builder
        .ifSome(invert)(_.invert(_))
        .ifSome(match)(_.match(_))
        .ifSome(name)(_.name(_))
        .build

    def httpRouteMatch(
      headers: Option[List[HttpRouteHeader]] = None,
      method: Option[String] = None,
      path: Option[HttpPathMatch] = None,
      prefix: Option[String] = None,
      queryParameters: Option[List[HttpQueryParameter]] = None,
      scheme: Option[String] = None
    ): HttpRouteMatch =
      HttpRouteMatch
        .builder
        .ifSome(headers)(_.headers(_))
        .ifSome(method)(_.method(_))
        .ifSome(path)(_.path(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(queryParameters)(_.queryParameters(_))
        .ifSome(scheme)(_.scheme(_))
        .build

    def httpTimeout(
      idle: Option[Duration] = None,
      perRequest: Option[Duration] = None
    ): HttpTimeout =
      HttpTimeout
        .builder
        .ifSome(idle)(_.idle(_))
        .ifSome(perRequest)(_.perRequest(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
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

    def listGatewayRoutesInput(
      limit: Option[Int] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      nextToken: Option[String] = None,
      virtualGatewayName: Option[String] = None
    ): ListGatewayRoutesInput =
      ListGatewayRoutesInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def listGatewayRoutesOutput(
      gatewayRoutes: Option[List[GatewayRouteRef]] = None,
      nextToken: Option[String] = None
    ): ListGatewayRoutesOutput =
      ListGatewayRoutesOutput
        .builder
        .ifSome(gatewayRoutes)(_.gatewayRoutes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMeshesInput(
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMeshesInput =
      ListMeshesInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMeshesOutput(
      meshes: Option[List[MeshRef]] = None,
      nextToken: Option[String] = None
    ): ListMeshesOutput =
      ListMeshesOutput
        .builder
        .ifSome(meshes)(_.meshes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoutesInput(
      limit: Option[Int] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      nextToken: Option[String] = None,
      virtualRouterName: Option[String] = None
    ): ListRoutesInput =
      ListRoutesInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def listRoutesOutput(
      nextToken: Option[String] = None,
      routes: Option[List[RouteRef]] = None
    ): ListRoutesOutput =
      ListRoutesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(routes)(_.routes(_))
        .build

    def listTagsForResourceInput(
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceOutput(
      nextToken: Option[String] = None,
      tags: Option[List[TagRef]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listVirtualGatewaysInput(
      limit: Option[Int] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      nextToken: Option[String] = None
    ): ListVirtualGatewaysInput =
      ListVirtualGatewaysInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVirtualGatewaysOutput(
      nextToken: Option[String] = None,
      virtualGateways: Option[List[VirtualGatewayRef]] = None
    ): ListVirtualGatewaysOutput =
      ListVirtualGatewaysOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualGateways)(_.virtualGateways(_))
        .build

    def listVirtualNodesInput(
      limit: Option[Int] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      nextToken: Option[String] = None
    ): ListVirtualNodesInput =
      ListVirtualNodesInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVirtualNodesOutput(
      nextToken: Option[String] = None,
      virtualNodes: Option[List[VirtualNodeRef]] = None
    ): ListVirtualNodesOutput =
      ListVirtualNodesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualNodes)(_.virtualNodes(_))
        .build

    def listVirtualRoutersInput(
      limit: Option[Int] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      nextToken: Option[String] = None
    ): ListVirtualRoutersInput =
      ListVirtualRoutersInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVirtualRoutersOutput(
      nextToken: Option[String] = None,
      virtualRouters: Option[List[VirtualRouterRef]] = None
    ): ListVirtualRoutersOutput =
      ListVirtualRoutersOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualRouters)(_.virtualRouters(_))
        .build

    def listVirtualServicesInput(
      limit: Option[Int] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      nextToken: Option[String] = None
    ): ListVirtualServicesInput =
      ListVirtualServicesInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVirtualServicesOutput(
      nextToken: Option[String] = None,
      virtualServices: Option[List[VirtualServiceRef]] = None
    ): ListVirtualServicesOutput =
      ListVirtualServicesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(virtualServices)(_.virtualServices(_))
        .build

    def listener(
      connectionPool: Option[VirtualNodeConnectionPool] = None,
      healthCheck: Option[HealthCheckPolicy] = None,
      outlierDetection: Option[OutlierDetection] = None,
      portMapping: Option[PortMapping] = None,
      timeout: Option[ListenerTimeout] = None,
      tls: Option[ListenerTls] = None
    ): Listener =
      Listener
        .builder
        .ifSome(connectionPool)(_.connectionPool(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .ifSome(outlierDetection)(_.outlierDetection(_))
        .ifSome(portMapping)(_.portMapping(_))
        .ifSome(timeout)(_.timeout(_))
        .ifSome(tls)(_.tls(_))
        .build

    def listenerTimeout(
      grpc: Option[GrpcTimeout] = None,
      http: Option[HttpTimeout] = None,
      http2: Option[HttpTimeout] = None,
      tcp: Option[TcpTimeout] = None
    ): ListenerTimeout =
      ListenerTimeout
        .builder
        .ifSome(grpc)(_.grpc(_))
        .ifSome(http)(_.http(_))
        .ifSome(http2)(_.http2(_))
        .ifSome(tcp)(_.tcp(_))
        .build

    def listenerTls(
      certificate: Option[ListenerTlsCertificate] = None,
      mode: Option[String] = None,
      validation: Option[ListenerTlsValidationContext] = None
    ): ListenerTls =
      ListenerTls
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(validation)(_.validation(_))
        .build

    def listenerTlsAcmCertificate(
      certificateArn: Option[String] = None
    ): ListenerTlsAcmCertificate =
      ListenerTlsAcmCertificate
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def listenerTlsCertificate(
      acm: Option[ListenerTlsAcmCertificate] = None,
      file: Option[ListenerTlsFileCertificate] = None,
      sds: Option[ListenerTlsSdsCertificate] = None
    ): ListenerTlsCertificate =
      ListenerTlsCertificate
        .builder
        .ifSome(acm)(_.acm(_))
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def listenerTlsFileCertificate(
      certificateChain: Option[String] = None,
      privateKey: Option[String] = None
    ): ListenerTlsFileCertificate =
      ListenerTlsFileCertificate
        .builder
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(privateKey)(_.privateKey(_))
        .build

    def listenerTlsSdsCertificate(
      secretName: Option[String] = None
    ): ListenerTlsSdsCertificate =
      ListenerTlsSdsCertificate
        .builder
        .ifSome(secretName)(_.secretName(_))
        .build

    def listenerTlsValidationContext(
      subjectAlternativeNames: Option[SubjectAlternativeNames] = None,
      trust: Option[ListenerTlsValidationContextTrust] = None
    ): ListenerTlsValidationContext =
      ListenerTlsValidationContext
        .builder
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(trust)(_.trust(_))
        .build

    def listenerTlsValidationContextTrust(
      file: Option[TlsValidationContextFileTrust] = None,
      sds: Option[TlsValidationContextSdsTrust] = None
    ): ListenerTlsValidationContextTrust =
      ListenerTlsValidationContextTrust
        .builder
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def logging(
      accessLog: Option[AccessLog] = None
    ): Logging =
      Logging
        .builder
        .ifSome(accessLog)(_.accessLog(_))
        .build

    def matchRange(
      end: Option[Long] = None,
      start: Option[Long] = None
    ): MatchRange =
      MatchRange
        .builder
        .ifSome(end)(_.end(_))
        .ifSome(start)(_.start(_))
        .build

    def meshData(
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      spec: Option[MeshSpec] = None,
      status: Option[MeshStatus] = None
    ): MeshData =
      MeshData
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .build

    def meshRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      version: Option[Long] = None
    ): MeshRef =
      MeshRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(version)(_.version(_))
        .build

    def meshSpec(
      egressFilter: Option[EgressFilter] = None
    ): MeshSpec =
      MeshSpec
        .builder
        .ifSome(egressFilter)(_.egressFilter(_))
        .build

    def meshStatus(
      status: Option[String] = None
    ): MeshStatus =
      MeshStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def outlierDetection(
      baseEjectionDuration: Option[Duration] = None,
      interval: Option[Duration] = None,
      maxEjectionPercent: Option[Int] = None,
      maxServerErrors: Option[OutlierDetectionMaxServerErrors] = None
    ): OutlierDetection =
      OutlierDetection
        .builder
        .ifSome(baseEjectionDuration)(_.baseEjectionDuration(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(maxEjectionPercent)(_.maxEjectionPercent(_))
        .ifSome(maxServerErrors)(_.maxServerErrors(_))
        .build

    def portMapping(
      port: Option[Int] = None,
      protocol: Option[String] = None
    ): PortMapping =
      PortMapping
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def queryParameterMatch(
      exact: Option[String] = None
    ): QueryParameterMatch =
      QueryParameterMatch
        .builder
        .ifSome(exact)(_.exact(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceMetadata(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      uid: Option[String] = None,
      version: Option[Long] = None
    ): ResourceMetadata =
      ResourceMetadata
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(uid)(_.uid(_))
        .ifSome(version)(_.version(_))
        .build

    def routeData(
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      routeName: Option[String] = None,
      spec: Option[RouteSpec] = None,
      status: Option[RouteStatus] = None,
      virtualRouterName: Option[String] = None
    ): RouteData =
      RouteData
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(routeName)(_.routeName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def routeRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      routeName: Option[String] = None,
      version: Option[Long] = None,
      virtualRouterName: Option[String] = None
    ): RouteRef =
      RouteRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(routeName)(_.routeName(_))
        .ifSome(version)(_.version(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def routeSpec(
      grpcRoute: Option[GrpcRoute] = None,
      http2Route: Option[HttpRoute] = None,
      httpRoute: Option[HttpRoute] = None,
      priority: Option[Int] = None,
      tcpRoute: Option[TcpRoute] = None
    ): RouteSpec =
      RouteSpec
        .builder
        .ifSome(grpcRoute)(_.grpcRoute(_))
        .ifSome(http2Route)(_.http2Route(_))
        .ifSome(httpRoute)(_.httpRoute(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(tcpRoute)(_.tcpRoute(_))
        .build

    def routeStatus(
      status: Option[String] = None
    ): RouteStatus =
      RouteStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def serviceDiscovery(
      awsCloudMap: Option[AwsCloudMapServiceDiscovery] = None,
      dns: Option[DnsServiceDiscovery] = None
    ): ServiceDiscovery =
      ServiceDiscovery
        .builder
        .ifSome(awsCloudMap)(_.awsCloudMap(_))
        .ifSome(dns)(_.dns(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def subjectAlternativeNameMatchers(
      exact: Option[List[SubjectAlternativeName]] = None
    ): SubjectAlternativeNameMatchers =
      SubjectAlternativeNameMatchers
        .builder
        .ifSome(exact)(_.exact(_))
        .build

    def subjectAlternativeNames(
      match: Option[SubjectAlternativeNameMatchers] = None
    ): SubjectAlternativeNames =
      SubjectAlternativeNames
        .builder
        .ifSome(match)(_.match(_))
        .build

    def tagRef(
      key: Option[String] = None,
      value: Option[String] = None
    ): TagRef =
      TagRef
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[TagRef]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def tcpRoute(
      action: Option[TcpRouteAction] = None,
      timeout: Option[TcpTimeout] = None
    ): TcpRoute =
      TcpRoute
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def tcpRouteAction(
      weightedTargets: Option[List[WeightedTarget]] = None
    ): TcpRouteAction =
      TcpRouteAction
        .builder
        .ifSome(weightedTargets)(_.weightedTargets(_))
        .build

    def tcpTimeout(
      idle: Option[Duration] = None
    ): TcpTimeout =
      TcpTimeout
        .builder
        .ifSome(idle)(_.idle(_))
        .build

    def tlsValidationContext(
      subjectAlternativeNames: Option[SubjectAlternativeNames] = None,
      trust: Option[TlsValidationContextTrust] = None
    ): TlsValidationContext =
      TlsValidationContext
        .builder
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(trust)(_.trust(_))
        .build

    def tlsValidationContextAcmTrust(
      certificateAuthorityArns: Option[List[Arn]] = None
    ): TlsValidationContextAcmTrust =
      TlsValidationContextAcmTrust
        .builder
        .ifSome(certificateAuthorityArns)(_.certificateAuthorityArns(_))
        .build

    def tlsValidationContextFileTrust(
      certificateChain: Option[String] = None
    ): TlsValidationContextFileTrust =
      TlsValidationContextFileTrust
        .builder
        .ifSome(certificateChain)(_.certificateChain(_))
        .build

    def tlsValidationContextSdsTrust(
      secretName: Option[String] = None
    ): TlsValidationContextSdsTrust =
      TlsValidationContextSdsTrust
        .builder
        .ifSome(secretName)(_.secretName(_))
        .build

    def tlsValidationContextTrust(
      acm: Option[TlsValidationContextAcmTrust] = None,
      file: Option[TlsValidationContextFileTrust] = None,
      sds: Option[TlsValidationContextSdsTrust] = None
    ): TlsValidationContextTrust =
      TlsValidationContextTrust
        .builder
        .ifSome(acm)(_.acm(_))
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateGatewayRouteInput(
      clientToken: Option[String] = None,
      gatewayRouteName: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[GatewayRouteSpec] = None,
      virtualGatewayName: Option[String] = None
    ): UpdateGatewayRouteInput =
      UpdateGatewayRouteInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(gatewayRouteName)(_.gatewayRouteName(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def updateGatewayRouteOutput(
      gatewayRoute: Option[GatewayRouteData] = None
    ): UpdateGatewayRouteOutput =
      UpdateGatewayRouteOutput
        .builder
        .ifSome(gatewayRoute)(_.gatewayRoute(_))
        .build

    def updateMeshInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      spec: Option[MeshSpec] = None
    ): UpdateMeshInput =
      UpdateMeshInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(spec)(_.spec(_))
        .build

    def updateMeshOutput(
      mesh: Option[MeshData] = None
    ): UpdateMeshOutput =
      UpdateMeshOutput
        .builder
        .ifSome(mesh)(_.mesh(_))
        .build

    def updateRouteInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      routeName: Option[String] = None,
      spec: Option[RouteSpec] = None,
      virtualRouterName: Option[String] = None
    ): UpdateRouteInput =
      UpdateRouteInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(routeName)(_.routeName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def updateRouteOutput(
      route: Option[RouteData] = None
    ): UpdateRouteOutput =
      UpdateRouteOutput
        .builder
        .ifSome(route)(_.route(_))
        .build

    def updateVirtualGatewayInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualGatewaySpec] = None,
      virtualGatewayName: Option[String] = None
    ): UpdateVirtualGatewayInput =
      UpdateVirtualGatewayInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def updateVirtualGatewayOutput(
      virtualGateway: Option[VirtualGatewayData] = None
    ): UpdateVirtualGatewayOutput =
      UpdateVirtualGatewayOutput
        .builder
        .ifSome(virtualGateway)(_.virtualGateway(_))
        .build

    def updateVirtualNodeInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualNodeSpec] = None,
      virtualNodeName: Option[String] = None
    ): UpdateVirtualNodeInput =
      UpdateVirtualNodeInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def updateVirtualNodeOutput(
      virtualNode: Option[VirtualNodeData] = None
    ): UpdateVirtualNodeOutput =
      UpdateVirtualNodeOutput
        .builder
        .ifSome(virtualNode)(_.virtualNode(_))
        .build

    def updateVirtualRouterInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualRouterSpec] = None,
      virtualRouterName: Option[String] = None
    ): UpdateVirtualRouterInput =
      UpdateVirtualRouterInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def updateVirtualRouterOutput(
      virtualRouter: Option[VirtualRouterData] = None
    ): UpdateVirtualRouterOutput =
      UpdateVirtualRouterOutput
        .builder
        .ifSome(virtualRouter)(_.virtualRouter(_))
        .build

    def updateVirtualServiceInput(
      clientToken: Option[String] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      spec: Option[VirtualServiceSpec] = None,
      virtualServiceName: Option[String] = None
    ): UpdateVirtualServiceInput =
      UpdateVirtualServiceInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def updateVirtualServiceOutput(
      virtualService: Option[VirtualServiceData] = None
    ): UpdateVirtualServiceOutput =
      UpdateVirtualServiceOutput
        .builder
        .ifSome(virtualService)(_.virtualService(_))
        .build

    def virtualGatewayAccessLog(
      file: Option[VirtualGatewayFileAccessLog] = None
    ): VirtualGatewayAccessLog =
      VirtualGatewayAccessLog
        .builder
        .ifSome(file)(_.file(_))
        .build

    def virtualGatewayBackendDefaults(
      clientPolicy: Option[VirtualGatewayClientPolicy] = None
    ): VirtualGatewayBackendDefaults =
      VirtualGatewayBackendDefaults
        .builder
        .ifSome(clientPolicy)(_.clientPolicy(_))
        .build

    def virtualGatewayClientPolicy(
      tls: Option[VirtualGatewayClientPolicyTls] = None
    ): VirtualGatewayClientPolicy =
      VirtualGatewayClientPolicy
        .builder
        .ifSome(tls)(_.tls(_))
        .build

    def virtualGatewayClientPolicyTls(
      certificate: Option[VirtualGatewayClientTlsCertificate] = None,
      enforce: Option[Boolean] = None,
      ports: Option[List[PortNumber]] = None,
      validation: Option[VirtualGatewayTlsValidationContext] = None
    ): VirtualGatewayClientPolicyTls =
      VirtualGatewayClientPolicyTls
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(enforce)(_.enforce(_))
        .ifSome(ports)(_.ports(_))
        .ifSome(validation)(_.validation(_))
        .build

    def virtualGatewayClientTlsCertificate(
      file: Option[VirtualGatewayListenerTlsFileCertificate] = None,
      sds: Option[VirtualGatewayListenerTlsSdsCertificate] = None
    ): VirtualGatewayClientTlsCertificate =
      VirtualGatewayClientTlsCertificate
        .builder
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def virtualGatewayConnectionPool(
      grpc: Option[VirtualGatewayGrpcConnectionPool] = None,
      http: Option[VirtualGatewayHttpConnectionPool] = None,
      http2: Option[VirtualGatewayHttp2ConnectionPool] = None
    ): VirtualGatewayConnectionPool =
      VirtualGatewayConnectionPool
        .builder
        .ifSome(grpc)(_.grpc(_))
        .ifSome(http)(_.http(_))
        .ifSome(http2)(_.http2(_))
        .build

    def virtualGatewayData(
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      spec: Option[VirtualGatewaySpec] = None,
      status: Option[VirtualGatewayStatus] = None,
      virtualGatewayName: Option[String] = None
    ): VirtualGatewayData =
      VirtualGatewayData
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def virtualGatewayFileAccessLog(
      path: Option[String] = None
    ): VirtualGatewayFileAccessLog =
      VirtualGatewayFileAccessLog
        .builder
        .ifSome(path)(_.path(_))
        .build

    def virtualGatewayGrpcConnectionPool(
      maxRequests: Option[Int] = None
    ): VirtualGatewayGrpcConnectionPool =
      VirtualGatewayGrpcConnectionPool
        .builder
        .ifSome(maxRequests)(_.maxRequests(_))
        .build

    def virtualGatewayHealthCheckPolicy(
      healthyThreshold: Option[Int] = None,
      intervalMillis: Option[VirtualGatewayHealthCheckIntervalMillis] = None,
      path: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      timeoutMillis: Option[VirtualGatewayHealthCheckTimeoutMillis] = None,
      unhealthyThreshold: Option[Int] = None
    ): VirtualGatewayHealthCheckPolicy =
      VirtualGatewayHealthCheckPolicy
        .builder
        .ifSome(healthyThreshold)(_.healthyThreshold(_))
        .ifSome(intervalMillis)(_.intervalMillis(_))
        .ifSome(path)(_.path(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(timeoutMillis)(_.timeoutMillis(_))
        .ifSome(unhealthyThreshold)(_.unhealthyThreshold(_))
        .build

    def virtualGatewayHttp2ConnectionPool(
      maxRequests: Option[Int] = None
    ): VirtualGatewayHttp2ConnectionPool =
      VirtualGatewayHttp2ConnectionPool
        .builder
        .ifSome(maxRequests)(_.maxRequests(_))
        .build

    def virtualGatewayHttpConnectionPool(
      maxConnections: Option[Int] = None,
      maxPendingRequests: Option[Int] = None
    ): VirtualGatewayHttpConnectionPool =
      VirtualGatewayHttpConnectionPool
        .builder
        .ifSome(maxConnections)(_.maxConnections(_))
        .ifSome(maxPendingRequests)(_.maxPendingRequests(_))
        .build

    def virtualGatewayListener(
      connectionPool: Option[VirtualGatewayConnectionPool] = None,
      healthCheck: Option[VirtualGatewayHealthCheckPolicy] = None,
      portMapping: Option[VirtualGatewayPortMapping] = None,
      tls: Option[VirtualGatewayListenerTls] = None
    ): VirtualGatewayListener =
      VirtualGatewayListener
        .builder
        .ifSome(connectionPool)(_.connectionPool(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .ifSome(portMapping)(_.portMapping(_))
        .ifSome(tls)(_.tls(_))
        .build

    def virtualGatewayListenerTls(
      certificate: Option[VirtualGatewayListenerTlsCertificate] = None,
      mode: Option[String] = None,
      validation: Option[VirtualGatewayListenerTlsValidationContext] = None
    ): VirtualGatewayListenerTls =
      VirtualGatewayListenerTls
        .builder
        .ifSome(certificate)(_.certificate(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(validation)(_.validation(_))
        .build

    def virtualGatewayListenerTlsAcmCertificate(
      certificateArn: Option[String] = None
    ): VirtualGatewayListenerTlsAcmCertificate =
      VirtualGatewayListenerTlsAcmCertificate
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def virtualGatewayListenerTlsCertificate(
      acm: Option[VirtualGatewayListenerTlsAcmCertificate] = None,
      file: Option[VirtualGatewayListenerTlsFileCertificate] = None,
      sds: Option[VirtualGatewayListenerTlsSdsCertificate] = None
    ): VirtualGatewayListenerTlsCertificate =
      VirtualGatewayListenerTlsCertificate
        .builder
        .ifSome(acm)(_.acm(_))
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def virtualGatewayListenerTlsFileCertificate(
      certificateChain: Option[String] = None,
      privateKey: Option[String] = None
    ): VirtualGatewayListenerTlsFileCertificate =
      VirtualGatewayListenerTlsFileCertificate
        .builder
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(privateKey)(_.privateKey(_))
        .build

    def virtualGatewayListenerTlsSdsCertificate(
      secretName: Option[String] = None
    ): VirtualGatewayListenerTlsSdsCertificate =
      VirtualGatewayListenerTlsSdsCertificate
        .builder
        .ifSome(secretName)(_.secretName(_))
        .build

    def virtualGatewayListenerTlsValidationContext(
      subjectAlternativeNames: Option[SubjectAlternativeNames] = None,
      trust: Option[VirtualGatewayListenerTlsValidationContextTrust] = None
    ): VirtualGatewayListenerTlsValidationContext =
      VirtualGatewayListenerTlsValidationContext
        .builder
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(trust)(_.trust(_))
        .build

    def virtualGatewayListenerTlsValidationContextTrust(
      file: Option[VirtualGatewayTlsValidationContextFileTrust] = None,
      sds: Option[VirtualGatewayTlsValidationContextSdsTrust] = None
    ): VirtualGatewayListenerTlsValidationContextTrust =
      VirtualGatewayListenerTlsValidationContextTrust
        .builder
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def virtualGatewayLogging(
      accessLog: Option[VirtualGatewayAccessLog] = None
    ): VirtualGatewayLogging =
      VirtualGatewayLogging
        .builder
        .ifSome(accessLog)(_.accessLog(_))
        .build

    def virtualGatewayPortMapping(
      port: Option[Int] = None,
      protocol: Option[String] = None
    ): VirtualGatewayPortMapping =
      VirtualGatewayPortMapping
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def virtualGatewayRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      version: Option[Long] = None,
      virtualGatewayName: Option[String] = None
    ): VirtualGatewayRef =
      VirtualGatewayRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(version)(_.version(_))
        .ifSome(virtualGatewayName)(_.virtualGatewayName(_))
        .build

    def virtualGatewaySpec(
      backendDefaults: Option[VirtualGatewayBackendDefaults] = None,
      listeners: Option[List[VirtualGatewayListener]] = None,
      logging: Option[VirtualGatewayLogging] = None
    ): VirtualGatewaySpec =
      VirtualGatewaySpec
        .builder
        .ifSome(backendDefaults)(_.backendDefaults(_))
        .ifSome(listeners)(_.listeners(_))
        .ifSome(logging)(_.logging(_))
        .build

    def virtualGatewayStatus(
      status: Option[String] = None
    ): VirtualGatewayStatus =
      VirtualGatewayStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def virtualGatewayTlsValidationContext(
      subjectAlternativeNames: Option[SubjectAlternativeNames] = None,
      trust: Option[VirtualGatewayTlsValidationContextTrust] = None
    ): VirtualGatewayTlsValidationContext =
      VirtualGatewayTlsValidationContext
        .builder
        .ifSome(subjectAlternativeNames)(_.subjectAlternativeNames(_))
        .ifSome(trust)(_.trust(_))
        .build

    def virtualGatewayTlsValidationContextAcmTrust(
      certificateAuthorityArns: Option[List[Arn]] = None
    ): VirtualGatewayTlsValidationContextAcmTrust =
      VirtualGatewayTlsValidationContextAcmTrust
        .builder
        .ifSome(certificateAuthorityArns)(_.certificateAuthorityArns(_))
        .build

    def virtualGatewayTlsValidationContextFileTrust(
      certificateChain: Option[String] = None
    ): VirtualGatewayTlsValidationContextFileTrust =
      VirtualGatewayTlsValidationContextFileTrust
        .builder
        .ifSome(certificateChain)(_.certificateChain(_))
        .build

    def virtualGatewayTlsValidationContextSdsTrust(
      secretName: Option[String] = None
    ): VirtualGatewayTlsValidationContextSdsTrust =
      VirtualGatewayTlsValidationContextSdsTrust
        .builder
        .ifSome(secretName)(_.secretName(_))
        .build

    def virtualGatewayTlsValidationContextTrust(
      acm: Option[VirtualGatewayTlsValidationContextAcmTrust] = None,
      file: Option[VirtualGatewayTlsValidationContextFileTrust] = None,
      sds: Option[VirtualGatewayTlsValidationContextSdsTrust] = None
    ): VirtualGatewayTlsValidationContextTrust =
      VirtualGatewayTlsValidationContextTrust
        .builder
        .ifSome(acm)(_.acm(_))
        .ifSome(file)(_.file(_))
        .ifSome(sds)(_.sds(_))
        .build

    def virtualNodeConnectionPool(
      grpc: Option[VirtualNodeGrpcConnectionPool] = None,
      http: Option[VirtualNodeHttpConnectionPool] = None,
      http2: Option[VirtualNodeHttp2ConnectionPool] = None,
      tcp: Option[VirtualNodeTcpConnectionPool] = None
    ): VirtualNodeConnectionPool =
      VirtualNodeConnectionPool
        .builder
        .ifSome(grpc)(_.grpc(_))
        .ifSome(http)(_.http(_))
        .ifSome(http2)(_.http2(_))
        .ifSome(tcp)(_.tcp(_))
        .build

    def virtualNodeData(
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      spec: Option[VirtualNodeSpec] = None,
      status: Option[VirtualNodeStatus] = None,
      virtualNodeName: Option[String] = None
    ): VirtualNodeData =
      VirtualNodeData
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def virtualNodeGrpcConnectionPool(
      maxRequests: Option[Int] = None
    ): VirtualNodeGrpcConnectionPool =
      VirtualNodeGrpcConnectionPool
        .builder
        .ifSome(maxRequests)(_.maxRequests(_))
        .build

    def virtualNodeHttp2ConnectionPool(
      maxRequests: Option[Int] = None
    ): VirtualNodeHttp2ConnectionPool =
      VirtualNodeHttp2ConnectionPool
        .builder
        .ifSome(maxRequests)(_.maxRequests(_))
        .build

    def virtualNodeHttpConnectionPool(
      maxConnections: Option[Int] = None,
      maxPendingRequests: Option[Int] = None
    ): VirtualNodeHttpConnectionPool =
      VirtualNodeHttpConnectionPool
        .builder
        .ifSome(maxConnections)(_.maxConnections(_))
        .ifSome(maxPendingRequests)(_.maxPendingRequests(_))
        .build

    def virtualNodeRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      version: Option[Long] = None,
      virtualNodeName: Option[String] = None
    ): VirtualNodeRef =
      VirtualNodeRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(version)(_.version(_))
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def virtualNodeServiceProvider(
      virtualNodeName: Option[String] = None
    ): VirtualNodeServiceProvider =
      VirtualNodeServiceProvider
        .builder
        .ifSome(virtualNodeName)(_.virtualNodeName(_))
        .build

    def virtualNodeSpec(
      backendDefaults: Option[BackendDefaults] = None,
      backends: Option[List[Backend]] = None,
      listeners: Option[List[Listener]] = None,
      logging: Option[Logging] = None,
      serviceDiscovery: Option[ServiceDiscovery] = None
    ): VirtualNodeSpec =
      VirtualNodeSpec
        .builder
        .ifSome(backendDefaults)(_.backendDefaults(_))
        .ifSome(backends)(_.backends(_))
        .ifSome(listeners)(_.listeners(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(serviceDiscovery)(_.serviceDiscovery(_))
        .build

    def virtualNodeStatus(
      status: Option[String] = None
    ): VirtualNodeStatus =
      VirtualNodeStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def virtualNodeTcpConnectionPool(
      maxConnections: Option[Int] = None
    ): VirtualNodeTcpConnectionPool =
      VirtualNodeTcpConnectionPool
        .builder
        .ifSome(maxConnections)(_.maxConnections(_))
        .build

    def virtualRouterData(
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      spec: Option[VirtualRouterSpec] = None,
      status: Option[VirtualRouterStatus] = None,
      virtualRouterName: Option[String] = None
    ): VirtualRouterData =
      VirtualRouterData
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def virtualRouterListener(
      portMapping: Option[PortMapping] = None
    ): VirtualRouterListener =
      VirtualRouterListener
        .builder
        .ifSome(portMapping)(_.portMapping(_))
        .build

    def virtualRouterRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      version: Option[Long] = None,
      virtualRouterName: Option[String] = None
    ): VirtualRouterRef =
      VirtualRouterRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(version)(_.version(_))
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def virtualRouterServiceProvider(
      virtualRouterName: Option[String] = None
    ): VirtualRouterServiceProvider =
      VirtualRouterServiceProvider
        .builder
        .ifSome(virtualRouterName)(_.virtualRouterName(_))
        .build

    def virtualRouterSpec(
      listeners: Option[List[VirtualRouterListener]] = None
    ): VirtualRouterSpec =
      VirtualRouterSpec
        .builder
        .ifSome(listeners)(_.listeners(_))
        .build

    def virtualRouterStatus(
      status: Option[String] = None
    ): VirtualRouterStatus =
      VirtualRouterStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def virtualServiceBackend(
      clientPolicy: Option[ClientPolicy] = None,
      virtualServiceName: Option[String] = None
    ): VirtualServiceBackend =
      VirtualServiceBackend
        .builder
        .ifSome(clientPolicy)(_.clientPolicy(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def virtualServiceData(
      meshName: Option[String] = None,
      metadata: Option[ResourceMetadata] = None,
      spec: Option[VirtualServiceSpec] = None,
      status: Option[VirtualServiceStatus] = None,
      virtualServiceName: Option[String] = None
    ): VirtualServiceData =
      VirtualServiceData
        .builder
        .ifSome(meshName)(_.meshName(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def virtualServiceProvider(
      virtualNode: Option[VirtualNodeServiceProvider] = None,
      virtualRouter: Option[VirtualRouterServiceProvider] = None
    ): VirtualServiceProvider =
      VirtualServiceProvider
        .builder
        .ifSome(virtualNode)(_.virtualNode(_))
        .ifSome(virtualRouter)(_.virtualRouter(_))
        .build

    def virtualServiceRef(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None,
      meshName: Option[String] = None,
      meshOwner: Option[String] = None,
      resourceOwner: Option[String] = None,
      version: Option[Long] = None,
      virtualServiceName: Option[String] = None
    ): VirtualServiceRef =
      VirtualServiceRef
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(meshName)(_.meshName(_))
        .ifSome(meshOwner)(_.meshOwner(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(version)(_.version(_))
        .ifSome(virtualServiceName)(_.virtualServiceName(_))
        .build

    def virtualServiceSpec(
      provider: Option[VirtualServiceProvider] = None
    ): VirtualServiceSpec =
      VirtualServiceSpec
        .builder
        .ifSome(provider)(_.provider(_))
        .build

    def virtualServiceStatus(
      status: Option[String] = None
    ): VirtualServiceStatus =
      VirtualServiceStatus
        .builder
        .ifSome(status)(_.status(_))
        .build

    def weightedTarget(
      virtualNode: Option[String] = None,
      weight: Option[Int] = None
    ): WeightedTarget =
      WeightedTarget
        .builder
        .ifSome(virtualNode)(_.virtualNode(_))
        .ifSome(weight)(_.weight(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
