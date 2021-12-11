package goober.hi

import goober.free.mediaconnect.MediaConnectIO
import software.amazon.awssdk.services.mediaconnect.model._


object mediaconnect {
  import goober.free.{mediaconnect ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addFlowMediaStreamsRequest(
      flowArn: Option[String] = None,
      mediaStreams: Option[List[AddMediaStreamRequest]] = None
    ): AddFlowMediaStreamsRequest =
      AddFlowMediaStreamsRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStreams)(_.mediaStreams(_))
        .build

    def addFlowMediaStreamsResponse(
      flowArn: Option[String] = None,
      mediaStreams: Option[List[MediaStream]] = None
    ): AddFlowMediaStreamsResponse =
      AddFlowMediaStreamsResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStreams)(_.mediaStreams(_))
        .build

    def addFlowOutputs420Exception(
      message: Option[String] = None
    ): AddFlowOutputs420Exception =
      AddFlowOutputs420Exception
        .builder
        .ifSome(message)(_.message(_))
        .build

    def addFlowOutputsRequest(
      flowArn: Option[String] = None,
      outputs: Option[List[AddOutputRequest]] = None
    ): AddFlowOutputsRequest =
      AddFlowOutputsRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(outputs)(_.outputs(_))
        .build

    def addFlowOutputsResponse(
      flowArn: Option[String] = None,
      outputs: Option[List[Output]] = None
    ): AddFlowOutputsResponse =
      AddFlowOutputsResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(outputs)(_.outputs(_))
        .build

    def addFlowSourcesRequest(
      flowArn: Option[String] = None,
      sources: Option[List[SetSourceRequest]] = None
    ): AddFlowSourcesRequest =
      AddFlowSourcesRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(sources)(_.sources(_))
        .build

    def addFlowSourcesResponse(
      flowArn: Option[String] = None,
      sources: Option[List[Source]] = None
    ): AddFlowSourcesResponse =
      AddFlowSourcesResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(sources)(_.sources(_))
        .build

    def addFlowVpcInterfacesRequest(
      flowArn: Option[String] = None,
      vpcInterfaces: Option[List[VpcInterfaceRequest]] = None
    ): AddFlowVpcInterfacesRequest =
      AddFlowVpcInterfacesRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(vpcInterfaces)(_.vpcInterfaces(_))
        .build

    def addFlowVpcInterfacesResponse(
      flowArn: Option[String] = None,
      vpcInterfaces: Option[List[VpcInterface]] = None
    ): AddFlowVpcInterfacesResponse =
      AddFlowVpcInterfacesResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(vpcInterfaces)(_.vpcInterfaces(_))
        .build

    def addMediaStreamRequest(
      attributes: Option[MediaStreamAttributesRequest] = None,
      clockRate: Option[Int] = None,
      description: Option[String] = None,
      mediaStreamId: Option[Int] = None,
      mediaStreamName: Option[String] = None,
      mediaStreamType: Option[String] = None,
      videoFormat: Option[String] = None
    ): AddMediaStreamRequest =
      AddMediaStreamRequest
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(clockRate)(_.clockRate(_))
        .ifSome(description)(_.description(_))
        .ifSome(mediaStreamId)(_.mediaStreamId(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .ifSome(mediaStreamType)(_.mediaStreamType(_))
        .ifSome(videoFormat)(_.videoFormat(_))
        .build

    def addOutputRequest(
      cidrAllowList: Option[List[__string]] = None,
      description: Option[String] = None,
      destination: Option[String] = None,
      encryption: Option[Encryption] = None,
      maxLatency: Option[Int] = None,
      mediaStreamOutputConfigurations: Option[List[MediaStreamOutputConfigurationRequest]] = None,
      minLatency: Option[Int] = None,
      name: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      remoteId: Option[String] = None,
      smoothingLatency: Option[Int] = None,
      streamId: Option[String] = None,
      vpcInterfaceAttachment: Option[VpcInterfaceAttachment] = None
    ): AddOutputRequest =
      AddOutputRequest
        .builder
        .ifSome(cidrAllowList)(_.cidrAllowList(_))
        .ifSome(description)(_.description(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(maxLatency)(_.maxLatency(_))
        .ifSome(mediaStreamOutputConfigurations)(_.mediaStreamOutputConfigurations(_))
        .ifSome(minLatency)(_.minLatency(_))
        .ifSome(name)(_.name(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(remoteId)(_.remoteId(_))
        .ifSome(smoothingLatency)(_.smoothingLatency(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(vpcInterfaceAttachment)(_.vpcInterfaceAttachment(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createFlow420Exception(
      message: Option[String] = None
    ): CreateFlow420Exception =
      CreateFlow420Exception
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createFlowRequest(
      availabilityZone: Option[String] = None,
      entitlements: Option[List[GrantEntitlementRequest]] = None,
      mediaStreams: Option[List[AddMediaStreamRequest]] = None,
      name: Option[String] = None,
      outputs: Option[List[AddOutputRequest]] = None,
      source: Option[SetSourceRequest] = None,
      sourceFailoverConfig: Option[FailoverConfig] = None,
      sources: Option[List[SetSourceRequest]] = None,
      vpcInterfaces: Option[List[VpcInterfaceRequest]] = None
    ): CreateFlowRequest =
      CreateFlowRequest
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(mediaStreams)(_.mediaStreams(_))
        .ifSome(name)(_.name(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(source)(_.source(_))
        .ifSome(sourceFailoverConfig)(_.sourceFailoverConfig(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(vpcInterfaces)(_.vpcInterfaces(_))
        .build

    def createFlowResponse(
      flow: Option[Flow] = None
    ): CreateFlowResponse =
      CreateFlowResponse
        .builder
        .ifSome(flow)(_.flow(_))
        .build

    def deleteFlowRequest(
      flowArn: Option[String] = None
    ): DeleteFlowRequest =
      DeleteFlowRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def deleteFlowResponse(
      flowArn: Option[String] = None,
      status: Option[String] = None
    ): DeleteFlowResponse =
      DeleteFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(status)(_.status(_))
        .build

    def describeFlowRequest(
      flowArn: Option[String] = None
    ): DescribeFlowRequest =
      DescribeFlowRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def describeFlowResponse(
      flow: Option[Flow] = None,
      messages: Option[Messages] = None
    ): DescribeFlowResponse =
      DescribeFlowResponse
        .builder
        .ifSome(flow)(_.flow(_))
        .ifSome(messages)(_.messages(_))
        .build

    def describeOfferingRequest(
      offeringArn: Option[String] = None
    ): DescribeOfferingRequest =
      DescribeOfferingRequest
        .builder
        .ifSome(offeringArn)(_.offeringArn(_))
        .build

    def describeOfferingResponse(
      offering: Option[Offering] = None
    ): DescribeOfferingResponse =
      DescribeOfferingResponse
        .builder
        .ifSome(offering)(_.offering(_))
        .build

    def describeReservationRequest(
      reservationArn: Option[String] = None
    ): DescribeReservationRequest =
      DescribeReservationRequest
        .builder
        .ifSome(reservationArn)(_.reservationArn(_))
        .build

    def describeReservationResponse(
      reservation: Option[Reservation] = None
    ): DescribeReservationResponse =
      DescribeReservationResponse
        .builder
        .ifSome(reservation)(_.reservation(_))
        .build

    def destinationConfiguration(
      destinationIp: Option[String] = None,
      destinationPort: Option[Int] = None,
      interface: Option[Interface] = None,
      outboundIp: Option[String] = None
    ): DestinationConfiguration =
      DestinationConfiguration
        .builder
        .ifSome(destinationIp)(_.destinationIp(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .ifSome(interface)(_.interface(_))
        .ifSome(outboundIp)(_.outboundIp(_))
        .build

    def destinationConfigurationRequest(
      destinationIp: Option[String] = None,
      destinationPort: Option[Int] = None,
      interface: Option[InterfaceRequest] = None
    ): DestinationConfigurationRequest =
      DestinationConfigurationRequest
        .builder
        .ifSome(destinationIp)(_.destinationIp(_))
        .ifSome(destinationPort)(_.destinationPort(_))
        .ifSome(interface)(_.interface(_))
        .build

    def encodingParameters(
      compressionFactor: Option[__double] = None,
      encoderProfile: Option[String] = None
    ): EncodingParameters =
      EncodingParameters
        .builder
        .ifSome(compressionFactor)(_.compressionFactor(_))
        .ifSome(encoderProfile)(_.encoderProfile(_))
        .build

    def encodingParametersRequest(
      compressionFactor: Option[__double] = None,
      encoderProfile: Option[String] = None
    ): EncodingParametersRequest =
      EncodingParametersRequest
        .builder
        .ifSome(compressionFactor)(_.compressionFactor(_))
        .ifSome(encoderProfile)(_.encoderProfile(_))
        .build

    def encryption(
      algorithm: Option[String] = None,
      constantInitializationVector: Option[String] = None,
      deviceId: Option[String] = None,
      keyType: Option[String] = None,
      region: Option[String] = None,
      resourceId: Option[String] = None,
      roleArn: Option[String] = None,
      secretArn: Option[String] = None,
      url: Option[String] = None
    ): Encryption =
      Encryption
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(keyType)(_.keyType(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(url)(_.url(_))
        .build

    def entitlement(
      dataTransferSubscriberFeePercent: Option[Int] = None,
      description: Option[String] = None,
      encryption: Option[Encryption] = None,
      entitlementArn: Option[String] = None,
      entitlementStatus: Option[String] = None,
      name: Option[String] = None,
      subscribers: Option[List[__string]] = None
    ): Entitlement =
      Entitlement
        .builder
        .ifSome(dataTransferSubscriberFeePercent)(_.dataTransferSubscriberFeePercent(_))
        .ifSome(description)(_.description(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(entitlementStatus)(_.entitlementStatus(_))
        .ifSome(name)(_.name(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def failoverConfig(
      failoverMode: Option[String] = None,
      recoveryWindow: Option[Int] = None,
      sourcePriority: Option[SourcePriority] = None,
      state: Option[String] = None
    ): FailoverConfig =
      FailoverConfig
        .builder
        .ifSome(failoverMode)(_.failoverMode(_))
        .ifSome(recoveryWindow)(_.recoveryWindow(_))
        .ifSome(sourcePriority)(_.sourcePriority(_))
        .ifSome(state)(_.state(_))
        .build

    def flow(
      availabilityZone: Option[String] = None,
      description: Option[String] = None,
      egressIp: Option[String] = None,
      entitlements: Option[List[Entitlement]] = None,
      flowArn: Option[String] = None,
      mediaStreams: Option[List[MediaStream]] = None,
      name: Option[String] = None,
      outputs: Option[List[Output]] = None,
      source: Option[Source] = None,
      sourceFailoverConfig: Option[FailoverConfig] = None,
      sources: Option[List[Source]] = None,
      status: Option[String] = None,
      vpcInterfaces: Option[List[VpcInterface]] = None
    ): Flow =
      Flow
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressIp)(_.egressIp(_))
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStreams)(_.mediaStreams(_))
        .ifSome(name)(_.name(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(source)(_.source(_))
        .ifSome(sourceFailoverConfig)(_.sourceFailoverConfig(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(status)(_.status(_))
        .ifSome(vpcInterfaces)(_.vpcInterfaces(_))
        .build

    def fmtp(
      channelOrder: Option[String] = None,
      colorimetry: Option[String] = None,
      exactFramerate: Option[String] = None,
      par: Option[String] = None,
      range: Option[String] = None,
      scanMode: Option[String] = None,
      tcs: Option[String] = None
    ): Fmtp =
      Fmtp
        .builder
        .ifSome(channelOrder)(_.channelOrder(_))
        .ifSome(colorimetry)(_.colorimetry(_))
        .ifSome(exactFramerate)(_.exactFramerate(_))
        .ifSome(par)(_.par(_))
        .ifSome(range)(_.range(_))
        .ifSome(scanMode)(_.scanMode(_))
        .ifSome(tcs)(_.tcs(_))
        .build

    def fmtpRequest(
      channelOrder: Option[String] = None,
      colorimetry: Option[String] = None,
      exactFramerate: Option[String] = None,
      par: Option[String] = None,
      range: Option[String] = None,
      scanMode: Option[String] = None,
      tcs: Option[String] = None
    ): FmtpRequest =
      FmtpRequest
        .builder
        .ifSome(channelOrder)(_.channelOrder(_))
        .ifSome(colorimetry)(_.colorimetry(_))
        .ifSome(exactFramerate)(_.exactFramerate(_))
        .ifSome(par)(_.par(_))
        .ifSome(range)(_.range(_))
        .ifSome(scanMode)(_.scanMode(_))
        .ifSome(tcs)(_.tcs(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def grantEntitlementRequest(
      dataTransferSubscriberFeePercent: Option[Int] = None,
      description: Option[String] = None,
      encryption: Option[Encryption] = None,
      entitlementStatus: Option[String] = None,
      name: Option[String] = None,
      subscribers: Option[List[__string]] = None
    ): GrantEntitlementRequest =
      GrantEntitlementRequest
        .builder
        .ifSome(dataTransferSubscriberFeePercent)(_.dataTransferSubscriberFeePercent(_))
        .ifSome(description)(_.description(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(entitlementStatus)(_.entitlementStatus(_))
        .ifSome(name)(_.name(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def grantFlowEntitlements420Exception(
      message: Option[String] = None
    ): GrantFlowEntitlements420Exception =
      GrantFlowEntitlements420Exception
        .builder
        .ifSome(message)(_.message(_))
        .build

    def grantFlowEntitlementsRequest(
      entitlements: Option[List[GrantEntitlementRequest]] = None,
      flowArn: Option[String] = None
    ): GrantFlowEntitlementsRequest =
      GrantFlowEntitlementsRequest
        .builder
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def grantFlowEntitlementsResponse(
      entitlements: Option[List[Entitlement]] = None,
      flowArn: Option[String] = None
    ): GrantFlowEntitlementsResponse =
      GrantFlowEntitlementsResponse
        .builder
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def inputConfiguration(
      inputIp: Option[String] = None,
      inputPort: Option[Int] = None,
      interface: Option[Interface] = None
    ): InputConfiguration =
      InputConfiguration
        .builder
        .ifSome(inputIp)(_.inputIp(_))
        .ifSome(inputPort)(_.inputPort(_))
        .ifSome(interface)(_.interface(_))
        .build

    def inputConfigurationRequest(
      inputPort: Option[Int] = None,
      interface: Option[InterfaceRequest] = None
    ): InputConfigurationRequest =
      InputConfigurationRequest
        .builder
        .ifSome(inputPort)(_.inputPort(_))
        .ifSome(interface)(_.interface(_))
        .build

    def interface(
      name: Option[String] = None
    ): Interface =
      Interface
        .builder
        .ifSome(name)(_.name(_))
        .build

    def interfaceRequest(
      name: Option[String] = None
    ): InterfaceRequest =
      InterfaceRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listEntitlementsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEntitlementsRequest =
      ListEntitlementsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEntitlementsResponse(
      entitlements: Option[List[ListedEntitlement]] = None,
      nextToken: Option[String] = None
    ): ListEntitlementsResponse =
      ListEntitlementsResponse
        .builder
        .ifSome(entitlements)(_.entitlements(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFlowsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFlowsRequest =
      ListFlowsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFlowsResponse(
      flows: Option[List[ListedFlow]] = None,
      nextToken: Option[String] = None
    ): ListFlowsResponse =
      ListFlowsResponse
        .builder
        .ifSome(flows)(_.flows(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOfferingsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOfferingsRequest =
      ListOfferingsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOfferingsResponse(
      nextToken: Option[String] = None,
      offerings: Option[List[Offering]] = None
    ): ListOfferingsResponse =
      ListOfferingsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(offerings)(_.offerings(_))
        .build

    def listReservationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListReservationsRequest =
      ListReservationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listReservationsResponse(
      nextToken: Option[String] = None,
      reservations: Option[List[Reservation]] = None
    ): ListReservationsResponse =
      ListReservationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reservations)(_.reservations(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[__mapOf__string] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listedEntitlement(
      dataTransferSubscriberFeePercent: Option[Int] = None,
      entitlementArn: Option[String] = None,
      entitlementName: Option[String] = None
    ): ListedEntitlement =
      ListedEntitlement
        .builder
        .ifSome(dataTransferSubscriberFeePercent)(_.dataTransferSubscriberFeePercent(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(entitlementName)(_.entitlementName(_))
        .build

    def listedFlow(
      availabilityZone: Option[String] = None,
      description: Option[String] = None,
      flowArn: Option[String] = None,
      name: Option[String] = None,
      sourceType: Option[String] = None,
      status: Option[String] = None
    ): ListedFlow =
      ListedFlow
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(description)(_.description(_))
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(status)(_.status(_))
        .build

    def mediaStream(
      attributes: Option[MediaStreamAttributes] = None,
      clockRate: Option[Int] = None,
      description: Option[String] = None,
      fmt: Option[Int] = None,
      mediaStreamId: Option[Int] = None,
      mediaStreamName: Option[String] = None,
      mediaStreamType: Option[String] = None,
      videoFormat: Option[String] = None
    ): MediaStream =
      MediaStream
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(clockRate)(_.clockRate(_))
        .ifSome(description)(_.description(_))
        .ifSome(fmt)(_.fmt(_))
        .ifSome(mediaStreamId)(_.mediaStreamId(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .ifSome(mediaStreamType)(_.mediaStreamType(_))
        .ifSome(videoFormat)(_.videoFormat(_))
        .build

    def mediaStreamAttributes(
      fmtp: Option[Fmtp] = None,
      lang: Option[String] = None
    ): MediaStreamAttributes =
      MediaStreamAttributes
        .builder
        .ifSome(fmtp)(_.fmtp(_))
        .ifSome(lang)(_.lang(_))
        .build

    def mediaStreamAttributesRequest(
      fmtp: Option[FmtpRequest] = None,
      lang: Option[String] = None
    ): MediaStreamAttributesRequest =
      MediaStreamAttributesRequest
        .builder
        .ifSome(fmtp)(_.fmtp(_))
        .ifSome(lang)(_.lang(_))
        .build

    def mediaStreamOutputConfiguration(
      destinationConfigurations: Option[List[DestinationConfiguration]] = None,
      encodingName: Option[String] = None,
      encodingParameters: Option[EncodingParameters] = None,
      mediaStreamName: Option[String] = None
    ): MediaStreamOutputConfiguration =
      MediaStreamOutputConfiguration
        .builder
        .ifSome(destinationConfigurations)(_.destinationConfigurations(_))
        .ifSome(encodingName)(_.encodingName(_))
        .ifSome(encodingParameters)(_.encodingParameters(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .build

    def mediaStreamOutputConfigurationRequest(
      destinationConfigurations: Option[List[DestinationConfigurationRequest]] = None,
      encodingName: Option[String] = None,
      encodingParameters: Option[EncodingParametersRequest] = None,
      mediaStreamName: Option[String] = None
    ): MediaStreamOutputConfigurationRequest =
      MediaStreamOutputConfigurationRequest
        .builder
        .ifSome(destinationConfigurations)(_.destinationConfigurations(_))
        .ifSome(encodingName)(_.encodingName(_))
        .ifSome(encodingParameters)(_.encodingParameters(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .build

    def mediaStreamSourceConfiguration(
      encodingName: Option[String] = None,
      inputConfigurations: Option[List[InputConfiguration]] = None,
      mediaStreamName: Option[String] = None
    ): MediaStreamSourceConfiguration =
      MediaStreamSourceConfiguration
        .builder
        .ifSome(encodingName)(_.encodingName(_))
        .ifSome(inputConfigurations)(_.inputConfigurations(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .build

    def mediaStreamSourceConfigurationRequest(
      encodingName: Option[String] = None,
      inputConfigurations: Option[List[InputConfigurationRequest]] = None,
      mediaStreamName: Option[String] = None
    ): MediaStreamSourceConfigurationRequest =
      MediaStreamSourceConfigurationRequest
        .builder
        .ifSome(encodingName)(_.encodingName(_))
        .ifSome(inputConfigurations)(_.inputConfigurations(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .build

    def messages(
      errors: Option[List[__string]] = None
    ): Messages =
      Messages
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def offering(
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      offeringArn: Option[String] = None,
      offeringDescription: Option[String] = None,
      pricePerUnit: Option[String] = None,
      priceUnits: Option[String] = None,
      resourceSpecification: Option[ResourceSpecification] = None
    ): Offering =
      Offering
        .builder
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(offeringArn)(_.offeringArn(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(pricePerUnit)(_.pricePerUnit(_))
        .ifSome(priceUnits)(_.priceUnits(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .build

    def output(
      dataTransferSubscriberFeePercent: Option[Int] = None,
      description: Option[String] = None,
      destination: Option[String] = None,
      encryption: Option[Encryption] = None,
      entitlementArn: Option[String] = None,
      listenerAddress: Option[String] = None,
      mediaLiveInputArn: Option[String] = None,
      mediaStreamOutputConfigurations: Option[List[MediaStreamOutputConfiguration]] = None,
      name: Option[String] = None,
      outputArn: Option[String] = None,
      port: Option[Int] = None,
      transport: Option[Transport] = None,
      vpcInterfaceAttachment: Option[VpcInterfaceAttachment] = None
    ): Output =
      Output
        .builder
        .ifSome(dataTransferSubscriberFeePercent)(_.dataTransferSubscriberFeePercent(_))
        .ifSome(description)(_.description(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(listenerAddress)(_.listenerAddress(_))
        .ifSome(mediaLiveInputArn)(_.mediaLiveInputArn(_))
        .ifSome(mediaStreamOutputConfigurations)(_.mediaStreamOutputConfigurations(_))
        .ifSome(name)(_.name(_))
        .ifSome(outputArn)(_.outputArn(_))
        .ifSome(port)(_.port(_))
        .ifSome(transport)(_.transport(_))
        .ifSome(vpcInterfaceAttachment)(_.vpcInterfaceAttachment(_))
        .build

    def purchaseOfferingRequest(
      offeringArn: Option[String] = None,
      reservationName: Option[String] = None,
      start: Option[String] = None
    ): PurchaseOfferingRequest =
      PurchaseOfferingRequest
        .builder
        .ifSome(offeringArn)(_.offeringArn(_))
        .ifSome(reservationName)(_.reservationName(_))
        .ifSome(start)(_.start(_))
        .build

    def purchaseOfferingResponse(
      reservation: Option[Reservation] = None
    ): PurchaseOfferingResponse =
      PurchaseOfferingResponse
        .builder
        .ifSome(reservation)(_.reservation(_))
        .build

    def removeFlowMediaStreamRequest(
      flowArn: Option[String] = None,
      mediaStreamName: Option[String] = None
    ): RemoveFlowMediaStreamRequest =
      RemoveFlowMediaStreamRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .build

    def removeFlowMediaStreamResponse(
      flowArn: Option[String] = None,
      mediaStreamName: Option[String] = None
    ): RemoveFlowMediaStreamResponse =
      RemoveFlowMediaStreamResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .build

    def removeFlowOutputRequest(
      flowArn: Option[String] = None,
      outputArn: Option[String] = None
    ): RemoveFlowOutputRequest =
      RemoveFlowOutputRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(outputArn)(_.outputArn(_))
        .build

    def removeFlowOutputResponse(
      flowArn: Option[String] = None,
      outputArn: Option[String] = None
    ): RemoveFlowOutputResponse =
      RemoveFlowOutputResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(outputArn)(_.outputArn(_))
        .build

    def removeFlowSourceRequest(
      flowArn: Option[String] = None,
      sourceArn: Option[String] = None
    ): RemoveFlowSourceRequest =
      RemoveFlowSourceRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .build

    def removeFlowSourceResponse(
      flowArn: Option[String] = None,
      sourceArn: Option[String] = None
    ): RemoveFlowSourceResponse =
      RemoveFlowSourceResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .build

    def removeFlowVpcInterfaceRequest(
      flowArn: Option[String] = None,
      vpcInterfaceName: Option[String] = None
    ): RemoveFlowVpcInterfaceRequest =
      RemoveFlowVpcInterfaceRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(vpcInterfaceName)(_.vpcInterfaceName(_))
        .build

    def removeFlowVpcInterfaceResponse(
      flowArn: Option[String] = None,
      nonDeletedNetworkInterfaceIds: Option[List[__string]] = None,
      vpcInterfaceName: Option[String] = None
    ): RemoveFlowVpcInterfaceResponse =
      RemoveFlowVpcInterfaceResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(nonDeletedNetworkInterfaceIds)(_.nonDeletedNetworkInterfaceIds(_))
        .ifSome(vpcInterfaceName)(_.vpcInterfaceName(_))
        .build

    def reservation(
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      end: Option[String] = None,
      offeringArn: Option[String] = None,
      offeringDescription: Option[String] = None,
      pricePerUnit: Option[String] = None,
      priceUnits: Option[String] = None,
      reservationArn: Option[String] = None,
      reservationName: Option[String] = None,
      reservationState: Option[String] = None,
      resourceSpecification: Option[ResourceSpecification] = None,
      start: Option[String] = None
    ): Reservation =
      Reservation
        .builder
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(end)(_.end(_))
        .ifSome(offeringArn)(_.offeringArn(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(pricePerUnit)(_.pricePerUnit(_))
        .ifSome(priceUnits)(_.priceUnits(_))
        .ifSome(reservationArn)(_.reservationArn(_))
        .ifSome(reservationName)(_.reservationName(_))
        .ifSome(reservationState)(_.reservationState(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(start)(_.start(_))
        .build

    def resourceSpecification(
      reservedBitrate: Option[Int] = None,
      resourceType: Option[String] = None
    ): ResourceSpecification =
      ResourceSpecification
        .builder
        .ifSome(reservedBitrate)(_.reservedBitrate(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def responseError(
      message: Option[String] = None
    ): ResponseError =
      ResponseError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def revokeFlowEntitlementRequest(
      entitlementArn: Option[String] = None,
      flowArn: Option[String] = None
    ): RevokeFlowEntitlementRequest =
      RevokeFlowEntitlementRequest
        .builder
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def revokeFlowEntitlementResponse(
      entitlementArn: Option[String] = None,
      flowArn: Option[String] = None
    ): RevokeFlowEntitlementResponse =
      RevokeFlowEntitlementResponse
        .builder
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def setSourceRequest(
      decryption: Option[Encryption] = None,
      description: Option[String] = None,
      entitlementArn: Option[String] = None,
      ingestPort: Option[Int] = None,
      maxBitrate: Option[Int] = None,
      maxLatency: Option[Int] = None,
      maxSyncBuffer: Option[Int] = None,
      mediaStreamSourceConfigurations: Option[List[MediaStreamSourceConfigurationRequest]] = None,
      minLatency: Option[Int] = None,
      name: Option[String] = None,
      protocol: Option[String] = None,
      streamId: Option[String] = None,
      vpcInterfaceName: Option[String] = None,
      whitelistCidr: Option[String] = None
    ): SetSourceRequest =
      SetSourceRequest
        .builder
        .ifSome(decryption)(_.decryption(_))
        .ifSome(description)(_.description(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(ingestPort)(_.ingestPort(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(maxLatency)(_.maxLatency(_))
        .ifSome(maxSyncBuffer)(_.maxSyncBuffer(_))
        .ifSome(mediaStreamSourceConfigurations)(_.mediaStreamSourceConfigurations(_))
        .ifSome(minLatency)(_.minLatency(_))
        .ifSome(name)(_.name(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(vpcInterfaceName)(_.vpcInterfaceName(_))
        .ifSome(whitelistCidr)(_.whitelistCidr(_))
        .build

    def source(
      dataTransferSubscriberFeePercent: Option[Int] = None,
      decryption: Option[Encryption] = None,
      description: Option[String] = None,
      entitlementArn: Option[String] = None,
      ingestIp: Option[String] = None,
      ingestPort: Option[Int] = None,
      mediaStreamSourceConfigurations: Option[List[MediaStreamSourceConfiguration]] = None,
      name: Option[String] = None,
      sourceArn: Option[String] = None,
      transport: Option[Transport] = None,
      vpcInterfaceName: Option[String] = None,
      whitelistCidr: Option[String] = None
    ): Source =
      Source
        .builder
        .ifSome(dataTransferSubscriberFeePercent)(_.dataTransferSubscriberFeePercent(_))
        .ifSome(decryption)(_.decryption(_))
        .ifSome(description)(_.description(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(ingestIp)(_.ingestIp(_))
        .ifSome(ingestPort)(_.ingestPort(_))
        .ifSome(mediaStreamSourceConfigurations)(_.mediaStreamSourceConfigurations(_))
        .ifSome(name)(_.name(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(transport)(_.transport(_))
        .ifSome(vpcInterfaceName)(_.vpcInterfaceName(_))
        .ifSome(whitelistCidr)(_.whitelistCidr(_))
        .build

    def sourcePriority(
      primarySource: Option[String] = None
    ): SourcePriority =
      SourcePriority
        .builder
        .ifSome(primarySource)(_.primarySource(_))
        .build

    def startFlowRequest(
      flowArn: Option[String] = None
    ): StartFlowRequest =
      StartFlowRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def startFlowResponse(
      flowArn: Option[String] = None,
      status: Option[String] = None
    ): StartFlowResponse =
      StartFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(status)(_.status(_))
        .build

    def stopFlowRequest(
      flowArn: Option[String] = None
    ): StopFlowRequest =
      StopFlowRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def stopFlowResponse(
      flowArn: Option[String] = None,
      status: Option[String] = None
    ): StopFlowResponse =
      StopFlowResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(status)(_.status(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transport(
      cidrAllowList: Option[List[__string]] = None,
      maxBitrate: Option[Int] = None,
      maxLatency: Option[Int] = None,
      maxSyncBuffer: Option[Int] = None,
      minLatency: Option[Int] = None,
      protocol: Option[String] = None,
      remoteId: Option[String] = None,
      smoothingLatency: Option[Int] = None,
      streamId: Option[String] = None
    ): Transport =
      Transport
        .builder
        .ifSome(cidrAllowList)(_.cidrAllowList(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(maxLatency)(_.maxLatency(_))
        .ifSome(maxSyncBuffer)(_.maxSyncBuffer(_))
        .ifSome(minLatency)(_.minLatency(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(remoteId)(_.remoteId(_))
        .ifSome(smoothingLatency)(_.smoothingLatency(_))
        .ifSome(streamId)(_.streamId(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateEncryption(
      algorithm: Option[String] = None,
      constantInitializationVector: Option[String] = None,
      deviceId: Option[String] = None,
      keyType: Option[String] = None,
      region: Option[String] = None,
      resourceId: Option[String] = None,
      roleArn: Option[String] = None,
      secretArn: Option[String] = None,
      url: Option[String] = None
    ): UpdateEncryption =
      UpdateEncryption
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(keyType)(_.keyType(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(secretArn)(_.secretArn(_))
        .ifSome(url)(_.url(_))
        .build

    def updateFailoverConfig(
      failoverMode: Option[String] = None,
      recoveryWindow: Option[Int] = None,
      sourcePriority: Option[SourcePriority] = None,
      state: Option[String] = None
    ): UpdateFailoverConfig =
      UpdateFailoverConfig
        .builder
        .ifSome(failoverMode)(_.failoverMode(_))
        .ifSome(recoveryWindow)(_.recoveryWindow(_))
        .ifSome(sourcePriority)(_.sourcePriority(_))
        .ifSome(state)(_.state(_))
        .build

    def updateFlowEntitlementRequest(
      description: Option[String] = None,
      encryption: Option[UpdateEncryption] = None,
      entitlementArn: Option[String] = None,
      entitlementStatus: Option[String] = None,
      flowArn: Option[String] = None,
      subscribers: Option[List[__string]] = None
    ): UpdateFlowEntitlementRequest =
      UpdateFlowEntitlementRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(entitlementStatus)(_.entitlementStatus(_))
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(subscribers)(_.subscribers(_))
        .build

    def updateFlowEntitlementResponse(
      entitlement: Option[Entitlement] = None,
      flowArn: Option[String] = None
    ): UpdateFlowEntitlementResponse =
      UpdateFlowEntitlementResponse
        .builder
        .ifSome(entitlement)(_.entitlement(_))
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def updateFlowMediaStreamRequest(
      attributes: Option[MediaStreamAttributesRequest] = None,
      clockRate: Option[Int] = None,
      description: Option[String] = None,
      flowArn: Option[String] = None,
      mediaStreamName: Option[String] = None,
      mediaStreamType: Option[String] = None,
      videoFormat: Option[String] = None
    ): UpdateFlowMediaStreamRequest =
      UpdateFlowMediaStreamRequest
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(clockRate)(_.clockRate(_))
        .ifSome(description)(_.description(_))
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStreamName)(_.mediaStreamName(_))
        .ifSome(mediaStreamType)(_.mediaStreamType(_))
        .ifSome(videoFormat)(_.videoFormat(_))
        .build

    def updateFlowMediaStreamResponse(
      flowArn: Option[String] = None,
      mediaStream: Option[MediaStream] = None
    ): UpdateFlowMediaStreamResponse =
      UpdateFlowMediaStreamResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(mediaStream)(_.mediaStream(_))
        .build

    def updateFlowOutputRequest(
      cidrAllowList: Option[List[__string]] = None,
      description: Option[String] = None,
      destination: Option[String] = None,
      encryption: Option[UpdateEncryption] = None,
      flowArn: Option[String] = None,
      maxLatency: Option[Int] = None,
      mediaStreamOutputConfigurations: Option[List[MediaStreamOutputConfigurationRequest]] = None,
      minLatency: Option[Int] = None,
      outputArn: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      remoteId: Option[String] = None,
      smoothingLatency: Option[Int] = None,
      streamId: Option[String] = None,
      vpcInterfaceAttachment: Option[VpcInterfaceAttachment] = None
    ): UpdateFlowOutputRequest =
      UpdateFlowOutputRequest
        .builder
        .ifSome(cidrAllowList)(_.cidrAllowList(_))
        .ifSome(description)(_.description(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(maxLatency)(_.maxLatency(_))
        .ifSome(mediaStreamOutputConfigurations)(_.mediaStreamOutputConfigurations(_))
        .ifSome(minLatency)(_.minLatency(_))
        .ifSome(outputArn)(_.outputArn(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(remoteId)(_.remoteId(_))
        .ifSome(smoothingLatency)(_.smoothingLatency(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(vpcInterfaceAttachment)(_.vpcInterfaceAttachment(_))
        .build

    def updateFlowOutputResponse(
      flowArn: Option[String] = None,
      output: Option[Output] = None
    ): UpdateFlowOutputResponse =
      UpdateFlowOutputResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(output)(_.output(_))
        .build

    def updateFlowRequest(
      flowArn: Option[String] = None,
      sourceFailoverConfig: Option[UpdateFailoverConfig] = None
    ): UpdateFlowRequest =
      UpdateFlowRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(sourceFailoverConfig)(_.sourceFailoverConfig(_))
        .build

    def updateFlowResponse(
      flow: Option[Flow] = None
    ): UpdateFlowResponse =
      UpdateFlowResponse
        .builder
        .ifSome(flow)(_.flow(_))
        .build

    def updateFlowSourceRequest(
      decryption: Option[UpdateEncryption] = None,
      description: Option[String] = None,
      entitlementArn: Option[String] = None,
      flowArn: Option[String] = None,
      ingestPort: Option[Int] = None,
      maxBitrate: Option[Int] = None,
      maxLatency: Option[Int] = None,
      maxSyncBuffer: Option[Int] = None,
      mediaStreamSourceConfigurations: Option[List[MediaStreamSourceConfigurationRequest]] = None,
      minLatency: Option[Int] = None,
      protocol: Option[String] = None,
      sourceArn: Option[String] = None,
      streamId: Option[String] = None,
      vpcInterfaceName: Option[String] = None,
      whitelistCidr: Option[String] = None
    ): UpdateFlowSourceRequest =
      UpdateFlowSourceRequest
        .builder
        .ifSome(decryption)(_.decryption(_))
        .ifSome(description)(_.description(_))
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(ingestPort)(_.ingestPort(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(maxLatency)(_.maxLatency(_))
        .ifSome(maxSyncBuffer)(_.maxSyncBuffer(_))
        .ifSome(mediaStreamSourceConfigurations)(_.mediaStreamSourceConfigurations(_))
        .ifSome(minLatency)(_.minLatency(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(vpcInterfaceName)(_.vpcInterfaceName(_))
        .ifSome(whitelistCidr)(_.whitelistCidr(_))
        .build

    def updateFlowSourceResponse(
      flowArn: Option[String] = None,
      source: Option[Source] = None
    ): UpdateFlowSourceResponse =
      UpdateFlowSourceResponse
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .ifSome(source)(_.source(_))
        .build

    def vpcInterface(
      name: Option[String] = None,
      networkInterfaceIds: Option[List[__string]] = None,
      networkInterfaceType: Option[String] = None,
      roleArn: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetId: Option[String] = None
    ): VpcInterface =
      VpcInterface
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .ifSome(networkInterfaceType)(_.networkInterfaceType(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

    def vpcInterfaceAttachment(
      vpcInterfaceName: Option[String] = None
    ): VpcInterfaceAttachment =
      VpcInterfaceAttachment
        .builder
        .ifSome(vpcInterfaceName)(_.vpcInterfaceName(_))
        .build

    def vpcInterfaceRequest(
      name: Option[String] = None,
      networkInterfaceType: Option[String] = None,
      roleArn: Option[String] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetId: Option[String] = None
    ): VpcInterfaceRequest =
      VpcInterfaceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(networkInterfaceType)(_.networkInterfaceType(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
