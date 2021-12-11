package goober.hi

import goober.free.iotwireless.IotWirelessIO
import software.amazon.awssdk.services.iotwireless.model._


object iotwireless {
  import goober.free.{iotwireless ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abpV1_0_x(
      devAddr: Option[String] = None,
      sessionKeys: Option[SessionKeysAbpV1_0_x] = None
    ): AbpV1_0_x =
      AbpV1_0_x
        .builder
        .ifSome(devAddr)(_.devAddr(_))
        .ifSome(sessionKeys)(_.sessionKeys(_))
        .build

    def abpV1_1(
      devAddr: Option[String] = None,
      sessionKeys: Option[SessionKeysAbpV1_1] = None
    ): AbpV1_1 =
      AbpV1_1
        .builder
        .ifSome(devAddr)(_.devAddr(_))
        .ifSome(sessionKeys)(_.sessionKeys(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def associateAwsAccountWithPartnerAccountRequest(
      sidewalk: Option[SidewalkAccountInfo] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AssociateAwsAccountWithPartnerAccountRequest =
      AssociateAwsAccountWithPartnerAccountRequest
        .builder
        .ifSome(sidewalk)(_.sidewalk(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def associateAwsAccountWithPartnerAccountResponse(
      sidewalk: Option[SidewalkAccountInfo] = None,
      arn: Option[String] = None
    ): AssociateAwsAccountWithPartnerAccountResponse =
      AssociateAwsAccountWithPartnerAccountResponse
        .builder
        .ifSome(sidewalk)(_.sidewalk(_))
        .ifSome(arn)(_.arn(_))
        .build

    def associateWirelessDeviceWithThingRequest(
      id: Option[String] = None,
      thingArn: Option[String] = None
    ): AssociateWirelessDeviceWithThingRequest =
      AssociateWirelessDeviceWithThingRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def associateWirelessDeviceWithThingResponse(

    ): AssociateWirelessDeviceWithThingResponse =
      AssociateWirelessDeviceWithThingResponse
        .builder

        .build

    def associateWirelessGatewayWithCertificateRequest(
      id: Option[String] = None,
      iotCertificateId: Option[String] = None
    ): AssociateWirelessGatewayWithCertificateRequest =
      AssociateWirelessGatewayWithCertificateRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(iotCertificateId)(_.iotCertificateId(_))
        .build

    def associateWirelessGatewayWithCertificateResponse(
      iotCertificateId: Option[String] = None
    ): AssociateWirelessGatewayWithCertificateResponse =
      AssociateWirelessGatewayWithCertificateResponse
        .builder
        .ifSome(iotCertificateId)(_.iotCertificateId(_))
        .build

    def associateWirelessGatewayWithThingRequest(
      id: Option[String] = None,
      thingArn: Option[String] = None
    ): AssociateWirelessGatewayWithThingRequest =
      AssociateWirelessGatewayWithThingRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def associateWirelessGatewayWithThingResponse(

    ): AssociateWirelessGatewayWithThingResponse =
      AssociateWirelessGatewayWithThingResponse
        .builder

        .build

    def certificateList(
      signingAlg: Option[String] = None,
      value: Option[String] = None
    ): CertificateList =
      CertificateList
        .builder
        .ifSome(signingAlg)(_.signingAlg(_))
        .ifSome(value)(_.value(_))
        .build

    def conflictException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def createDestinationRequest(
      name: Option[String] = None,
      expressionType: Option[String] = None,
      expression: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): CreateDestinationRequest =
      CreateDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createDestinationResponse(
      arn: Option[String] = None,
      name: Option[String] = None
    ): CreateDestinationResponse =
      CreateDestinationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def createDeviceProfileRequest(
      name: Option[String] = None,
      loRaWAN: Option[LoRaWANDeviceProfile] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): CreateDeviceProfileRequest =
      CreateDeviceProfileRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createDeviceProfileResponse(
      arn: Option[String] = None,
      id: Option[String] = None
    ): CreateDeviceProfileResponse =
      CreateDeviceProfileResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def createServiceProfileRequest(
      name: Option[String] = None,
      loRaWAN: Option[LoRaWANServiceProfile] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): CreateServiceProfileRequest =
      CreateServiceProfileRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createServiceProfileResponse(
      arn: Option[String] = None,
      id: Option[String] = None
    ): CreateServiceProfileResponse =
      CreateServiceProfileResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def createWirelessDeviceRequest(
      `type`: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      destinationName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      loRaWAN: Option[LoRaWANDevice] = None,
      tags: Option[List[Tag]] = None
    ): CreateWirelessDeviceRequest =
      CreateWirelessDeviceRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWirelessDeviceResponse(
      arn: Option[String] = None,
      id: Option[String] = None
    ): CreateWirelessDeviceResponse =
      CreateWirelessDeviceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def createWirelessGatewayRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      loRaWAN: Option[LoRaWANGateway] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): CreateWirelessGatewayRequest =
      CreateWirelessGatewayRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createWirelessGatewayResponse(
      arn: Option[String] = None,
      id: Option[String] = None
    ): CreateWirelessGatewayResponse =
      CreateWirelessGatewayResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .build

    def createWirelessGatewayTaskDefinitionRequest(
      autoCreateTasks: Option[Boolean] = None,
      name: Option[String] = None,
      update: Option[UpdateWirelessGatewayTaskCreate] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateWirelessGatewayTaskDefinitionRequest =
      CreateWirelessGatewayTaskDefinitionRequest
        .builder
        .ifSome(autoCreateTasks)(_.autoCreateTasks(_))
        .ifSome(name)(_.name(_))
        .ifSome(update)(_.update(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWirelessGatewayTaskDefinitionResponse(
      id: Option[String] = None,
      arn: Option[String] = None
    ): CreateWirelessGatewayTaskDefinitionResponse =
      CreateWirelessGatewayTaskDefinitionResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .build

    def createWirelessGatewayTaskRequest(
      id: Option[String] = None,
      wirelessGatewayTaskDefinitionId: Option[String] = None
    ): CreateWirelessGatewayTaskRequest =
      CreateWirelessGatewayTaskRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(wirelessGatewayTaskDefinitionId)(_.wirelessGatewayTaskDefinitionId(_))
        .build

    def createWirelessGatewayTaskResponse(
      wirelessGatewayTaskDefinitionId: Option[String] = None,
      status: Option[String] = None
    ): CreateWirelessGatewayTaskResponse =
      CreateWirelessGatewayTaskResponse
        .builder
        .ifSome(wirelessGatewayTaskDefinitionId)(_.wirelessGatewayTaskDefinitionId(_))
        .ifSome(status)(_.status(_))
        .build

    def deleteDestinationRequest(
      name: Option[String] = None
    ): DeleteDestinationRequest =
      DeleteDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteDestinationResponse(

    ): DeleteDestinationResponse =
      DeleteDestinationResponse
        .builder

        .build

    def deleteDeviceProfileRequest(
      id: Option[String] = None
    ): DeleteDeviceProfileRequest =
      DeleteDeviceProfileRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteDeviceProfileResponse(

    ): DeleteDeviceProfileResponse =
      DeleteDeviceProfileResponse
        .builder

        .build

    def deleteServiceProfileRequest(
      id: Option[String] = None
    ): DeleteServiceProfileRequest =
      DeleteServiceProfileRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteServiceProfileResponse(

    ): DeleteServiceProfileResponse =
      DeleteServiceProfileResponse
        .builder

        .build

    def deleteWirelessDeviceRequest(
      id: Option[String] = None
    ): DeleteWirelessDeviceRequest =
      DeleteWirelessDeviceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteWirelessDeviceResponse(

    ): DeleteWirelessDeviceResponse =
      DeleteWirelessDeviceResponse
        .builder

        .build

    def deleteWirelessGatewayRequest(
      id: Option[String] = None
    ): DeleteWirelessGatewayRequest =
      DeleteWirelessGatewayRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteWirelessGatewayResponse(

    ): DeleteWirelessGatewayResponse =
      DeleteWirelessGatewayResponse
        .builder

        .build

    def deleteWirelessGatewayTaskDefinitionRequest(
      id: Option[String] = None
    ): DeleteWirelessGatewayTaskDefinitionRequest =
      DeleteWirelessGatewayTaskDefinitionRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteWirelessGatewayTaskDefinitionResponse(

    ): DeleteWirelessGatewayTaskDefinitionResponse =
      DeleteWirelessGatewayTaskDefinitionResponse
        .builder

        .build

    def deleteWirelessGatewayTaskRequest(
      id: Option[String] = None
    ): DeleteWirelessGatewayTaskRequest =
      DeleteWirelessGatewayTaskRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteWirelessGatewayTaskResponse(

    ): DeleteWirelessGatewayTaskResponse =
      DeleteWirelessGatewayTaskResponse
        .builder

        .build

    def destinations(
      arn: Option[String] = None,
      name: Option[String] = None,
      expressionType: Option[String] = None,
      expression: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None
    ): Destinations =
      Destinations
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def deviceProfile(
      arn: Option[String] = None,
      name: Option[String] = None,
      id: Option[String] = None
    ): DeviceProfile =
      DeviceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .build

    def disassociateAwsAccountFromPartnerAccountRequest(
      partnerAccountId: Option[String] = None,
      partnerType: Option[String] = None
    ): DisassociateAwsAccountFromPartnerAccountRequest =
      DisassociateAwsAccountFromPartnerAccountRequest
        .builder
        .ifSome(partnerAccountId)(_.partnerAccountId(_))
        .ifSome(partnerType)(_.partnerType(_))
        .build

    def disassociateAwsAccountFromPartnerAccountResponse(

    ): DisassociateAwsAccountFromPartnerAccountResponse =
      DisassociateAwsAccountFromPartnerAccountResponse
        .builder

        .build

    def disassociateWirelessDeviceFromThingRequest(
      id: Option[String] = None
    ): DisassociateWirelessDeviceFromThingRequest =
      DisassociateWirelessDeviceFromThingRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def disassociateWirelessDeviceFromThingResponse(

    ): DisassociateWirelessDeviceFromThingResponse =
      DisassociateWirelessDeviceFromThingResponse
        .builder

        .build

    def disassociateWirelessGatewayFromCertificateRequest(
      id: Option[String] = None
    ): DisassociateWirelessGatewayFromCertificateRequest =
      DisassociateWirelessGatewayFromCertificateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def disassociateWirelessGatewayFromCertificateResponse(

    ): DisassociateWirelessGatewayFromCertificateResponse =
      DisassociateWirelessGatewayFromCertificateResponse
        .builder

        .build

    def disassociateWirelessGatewayFromThingRequest(
      id: Option[String] = None
    ): DisassociateWirelessGatewayFromThingRequest =
      DisassociateWirelessGatewayFromThingRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def disassociateWirelessGatewayFromThingResponse(

    ): DisassociateWirelessGatewayFromThingResponse =
      DisassociateWirelessGatewayFromThingResponse
        .builder

        .build

    def getDestinationRequest(
      name: Option[String] = None
    ): GetDestinationRequest =
      GetDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getDestinationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      expression: Option[String] = None,
      expressionType: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None
    ): GetDestinationResponse =
      GetDestinationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def getDeviceProfileRequest(
      id: Option[String] = None
    ): GetDeviceProfileRequest =
      GetDeviceProfileRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getDeviceProfileResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      id: Option[String] = None,
      loRaWAN: Option[LoRaWANDeviceProfile] = None
    ): GetDeviceProfileResponse =
      GetDeviceProfileResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .build

    def getLogLevelsByResourceTypesRequest(

    ): GetLogLevelsByResourceTypesRequest =
      GetLogLevelsByResourceTypesRequest
        .builder

        .build

    def getLogLevelsByResourceTypesResponse(
      defaultLogLevel: Option[String] = None,
      wirelessGatewayLogOptions: Option[List[WirelessGatewayLogOption]] = None,
      wirelessDeviceLogOptions: Option[List[WirelessDeviceLogOption]] = None
    ): GetLogLevelsByResourceTypesResponse =
      GetLogLevelsByResourceTypesResponse
        .builder
        .ifSome(defaultLogLevel)(_.defaultLogLevel(_))
        .ifSome(wirelessGatewayLogOptions)(_.wirelessGatewayLogOptions(_))
        .ifSome(wirelessDeviceLogOptions)(_.wirelessDeviceLogOptions(_))
        .build

    def getPartnerAccountRequest(
      partnerAccountId: Option[String] = None,
      partnerType: Option[String] = None
    ): GetPartnerAccountRequest =
      GetPartnerAccountRequest
        .builder
        .ifSome(partnerAccountId)(_.partnerAccountId(_))
        .ifSome(partnerType)(_.partnerType(_))
        .build

    def getPartnerAccountResponse(
      sidewalk: Option[SidewalkAccountInfoWithFingerprint] = None,
      accountLinked: Option[Boolean] = None
    ): GetPartnerAccountResponse =
      GetPartnerAccountResponse
        .builder
        .ifSome(sidewalk)(_.sidewalk(_))
        .ifSome(accountLinked)(_.accountLinked(_))
        .build

    def getResourceLogLevelRequest(
      resourceIdentifier: Option[String] = None,
      resourceType: Option[String] = None
    ): GetResourceLogLevelRequest =
      GetResourceLogLevelRequest
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def getResourceLogLevelResponse(
      logLevel: Option[String] = None
    ): GetResourceLogLevelResponse =
      GetResourceLogLevelResponse
        .builder
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def getServiceEndpointRequest(
      serviceType: Option[String] = None
    ): GetServiceEndpointRequest =
      GetServiceEndpointRequest
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .build

    def getServiceEndpointResponse(
      serviceType: Option[String] = None,
      serviceEndpoint: Option[String] = None,
      serverTrust: Option[String] = None
    ): GetServiceEndpointResponse =
      GetServiceEndpointResponse
        .builder
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(serviceEndpoint)(_.serviceEndpoint(_))
        .ifSome(serverTrust)(_.serverTrust(_))
        .build

    def getServiceProfileRequest(
      id: Option[String] = None
    ): GetServiceProfileRequest =
      GetServiceProfileRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getServiceProfileResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      id: Option[String] = None,
      loRaWAN: Option[LoRaWANGetServiceProfileInfo] = None
    ): GetServiceProfileResponse =
      GetServiceProfileResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .build

    def getWirelessDeviceRequest(
      identifier: Option[String] = None,
      identifierType: Option[String] = None
    ): GetWirelessDeviceRequest =
      GetWirelessDeviceRequest
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(identifierType)(_.identifierType(_))
        .build

    def getWirelessDeviceResponse(
      `type`: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      destinationName: Option[String] = None,
      id: Option[String] = None,
      arn: Option[String] = None,
      thingName: Option[String] = None,
      thingArn: Option[String] = None,
      loRaWAN: Option[LoRaWANDevice] = None,
      sidewalk: Option[SidewalkDevice] = None
    ): GetWirelessDeviceResponse =
      GetWirelessDeviceResponse
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(sidewalk)(_.sidewalk(_))
        .build

    def getWirelessDeviceStatisticsRequest(
      wirelessDeviceId: Option[String] = None
    ): GetWirelessDeviceStatisticsRequest =
      GetWirelessDeviceStatisticsRequest
        .builder
        .ifSome(wirelessDeviceId)(_.wirelessDeviceId(_))
        .build

    def getWirelessDeviceStatisticsResponse(
      wirelessDeviceId: Option[String] = None,
      lastUplinkReceivedAt: Option[String] = None,
      loRaWAN: Option[LoRaWANDeviceMetadata] = None,
      sidewalk: Option[SidewalkDeviceMetadata] = None
    ): GetWirelessDeviceStatisticsResponse =
      GetWirelessDeviceStatisticsResponse
        .builder
        .ifSome(wirelessDeviceId)(_.wirelessDeviceId(_))
        .ifSome(lastUplinkReceivedAt)(_.lastUplinkReceivedAt(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(sidewalk)(_.sidewalk(_))
        .build

    def getWirelessGatewayCertificateRequest(
      id: Option[String] = None
    ): GetWirelessGatewayCertificateRequest =
      GetWirelessGatewayCertificateRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getWirelessGatewayCertificateResponse(
      iotCertificateId: Option[String] = None,
      loRaWANNetworkServerCertificateId: Option[String] = None
    ): GetWirelessGatewayCertificateResponse =
      GetWirelessGatewayCertificateResponse
        .builder
        .ifSome(iotCertificateId)(_.iotCertificateId(_))
        .ifSome(loRaWANNetworkServerCertificateId)(_.loRaWANNetworkServerCertificateId(_))
        .build

    def getWirelessGatewayFirmwareInformationRequest(
      id: Option[String] = None
    ): GetWirelessGatewayFirmwareInformationRequest =
      GetWirelessGatewayFirmwareInformationRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getWirelessGatewayFirmwareInformationResponse(
      loRaWAN: Option[LoRaWANGatewayCurrentVersion] = None
    ): GetWirelessGatewayFirmwareInformationResponse =
      GetWirelessGatewayFirmwareInformationResponse
        .builder
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .build

    def getWirelessGatewayRequest(
      identifier: Option[String] = None,
      identifierType: Option[String] = None
    ): GetWirelessGatewayRequest =
      GetWirelessGatewayRequest
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(identifierType)(_.identifierType(_))
        .build

    def getWirelessGatewayResponse(
      name: Option[String] = None,
      id: Option[String] = None,
      description: Option[String] = None,
      loRaWAN: Option[LoRaWANGateway] = None,
      arn: Option[String] = None,
      thingName: Option[String] = None,
      thingArn: Option[String] = None
    ): GetWirelessGatewayResponse =
      GetWirelessGatewayResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def getWirelessGatewayStatisticsRequest(
      wirelessGatewayId: Option[String] = None
    ): GetWirelessGatewayStatisticsRequest =
      GetWirelessGatewayStatisticsRequest
        .builder
        .ifSome(wirelessGatewayId)(_.wirelessGatewayId(_))
        .build

    def getWirelessGatewayStatisticsResponse(
      wirelessGatewayId: Option[String] = None,
      lastUplinkReceivedAt: Option[String] = None,
      connectionStatus: Option[String] = None
    ): GetWirelessGatewayStatisticsResponse =
      GetWirelessGatewayStatisticsResponse
        .builder
        .ifSome(wirelessGatewayId)(_.wirelessGatewayId(_))
        .ifSome(lastUplinkReceivedAt)(_.lastUplinkReceivedAt(_))
        .ifSome(connectionStatus)(_.connectionStatus(_))
        .build

    def getWirelessGatewayTaskDefinitionRequest(
      id: Option[String] = None
    ): GetWirelessGatewayTaskDefinitionRequest =
      GetWirelessGatewayTaskDefinitionRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getWirelessGatewayTaskDefinitionResponse(
      autoCreateTasks: Option[Boolean] = None,
      name: Option[String] = None,
      update: Option[UpdateWirelessGatewayTaskCreate] = None,
      arn: Option[String] = None
    ): GetWirelessGatewayTaskDefinitionResponse =
      GetWirelessGatewayTaskDefinitionResponse
        .builder
        .ifSome(autoCreateTasks)(_.autoCreateTasks(_))
        .ifSome(name)(_.name(_))
        .ifSome(update)(_.update(_))
        .ifSome(arn)(_.arn(_))
        .build

    def getWirelessGatewayTaskRequest(
      id: Option[String] = None
    ): GetWirelessGatewayTaskRequest =
      GetWirelessGatewayTaskRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getWirelessGatewayTaskResponse(
      wirelessGatewayId: Option[String] = None,
      wirelessGatewayTaskDefinitionId: Option[String] = None,
      lastUplinkReceivedAt: Option[String] = None,
      taskCreatedAt: Option[String] = None,
      status: Option[String] = None
    ): GetWirelessGatewayTaskResponse =
      GetWirelessGatewayTaskResponse
        .builder
        .ifSome(wirelessGatewayId)(_.wirelessGatewayId(_))
        .ifSome(wirelessGatewayTaskDefinitionId)(_.wirelessGatewayTaskDefinitionId(_))
        .ifSome(lastUplinkReceivedAt)(_.lastUplinkReceivedAt(_))
        .ifSome(taskCreatedAt)(_.taskCreatedAt(_))
        .ifSome(status)(_.status(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDestinationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDestinationsRequest =
      ListDestinationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDestinationsResponse(
      nextToken: Option[String] = None,
      destinationList: Option[List[Destinations]] = None
    ): ListDestinationsResponse =
      ListDestinationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(destinationList)(_.destinationList(_))
        .build

    def listDeviceProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDeviceProfilesRequest =
      ListDeviceProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDeviceProfilesResponse(
      nextToken: Option[String] = None,
      deviceProfileList: Option[List[DeviceProfile]] = None
    ): ListDeviceProfilesResponse =
      ListDeviceProfilesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(deviceProfileList)(_.deviceProfileList(_))
        .build

    def listPartnerAccountsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPartnerAccountsRequest =
      ListPartnerAccountsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPartnerAccountsResponse(
      nextToken: Option[String] = None,
      sidewalk: Option[List[SidewalkAccountInfoWithFingerprint]] = None
    ): ListPartnerAccountsResponse =
      ListPartnerAccountsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sidewalk)(_.sidewalk(_))
        .build

    def listServiceProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListServiceProfilesRequest =
      ListServiceProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listServiceProfilesResponse(
      nextToken: Option[String] = None,
      serviceProfileList: Option[List[ServiceProfile]] = None
    ): ListServiceProfilesResponse =
      ListServiceProfilesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serviceProfileList)(_.serviceProfileList(_))
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

    def listWirelessDevicesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      destinationName: Option[String] = None,
      deviceProfileId: Option[String] = None,
      serviceProfileId: Option[String] = None,
      wirelessDeviceType: Option[String] = None
    ): ListWirelessDevicesRequest =
      ListWirelessDevicesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(deviceProfileId)(_.deviceProfileId(_))
        .ifSome(serviceProfileId)(_.serviceProfileId(_))
        .ifSome(wirelessDeviceType)(_.wirelessDeviceType(_))
        .build

    def listWirelessDevicesResponse(
      nextToken: Option[String] = None,
      wirelessDeviceList: Option[List[WirelessDeviceStatistics]] = None
    ): ListWirelessDevicesResponse =
      ListWirelessDevicesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(wirelessDeviceList)(_.wirelessDeviceList(_))
        .build

    def listWirelessGatewayTaskDefinitionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      taskDefinitionType: Option[String] = None
    ): ListWirelessGatewayTaskDefinitionsRequest =
      ListWirelessGatewayTaskDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(taskDefinitionType)(_.taskDefinitionType(_))
        .build

    def listWirelessGatewayTaskDefinitionsResponse(
      nextToken: Option[String] = None,
      taskDefinitions: Option[List[UpdateWirelessGatewayTaskEntry]] = None
    ): ListWirelessGatewayTaskDefinitionsResponse =
      ListWirelessGatewayTaskDefinitionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(taskDefinitions)(_.taskDefinitions(_))
        .build

    def listWirelessGatewaysRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWirelessGatewaysRequest =
      ListWirelessGatewaysRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWirelessGatewaysResponse(
      nextToken: Option[String] = None,
      wirelessGatewayList: Option[List[WirelessGatewayStatistics]] = None
    ): ListWirelessGatewaysResponse =
      ListWirelessGatewaysResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(wirelessGatewayList)(_.wirelessGatewayList(_))
        .build

    def loRaWANDevice(
      devEui: Option[String] = None,
      deviceProfileId: Option[String] = None,
      serviceProfileId: Option[String] = None,
      otaaV1_1: Option[OtaaV1_1] = None,
      otaaV1_0_x: Option[OtaaV1_0_x] = None,
      abpV1_1: Option[AbpV1_1] = None,
      abpV1_0_x: Option[AbpV1_0_x] = None
    ): LoRaWANDevice =
      LoRaWANDevice
        .builder
        .ifSome(devEui)(_.devEui(_))
        .ifSome(deviceProfileId)(_.deviceProfileId(_))
        .ifSome(serviceProfileId)(_.serviceProfileId(_))
        .ifSome(otaaV1_1)(_.otaaV1_1(_))
        .ifSome(otaaV1_0_x)(_.otaaV1_0_x(_))
        .ifSome(abpV1_1)(_.abpV1_1(_))
        .ifSome(abpV1_0_x)(_.abpV1_0_x(_))
        .build

    def loRaWANDeviceMetadata(
      devEui: Option[String] = None,
      fPort: Option[Int] = None,
      dataRate: Option[Int] = None,
      frequency: Option[Int] = None,
      timestamp: Option[String] = None,
      gateways: Option[List[LoRaWANGatewayMetadata]] = None
    ): LoRaWANDeviceMetadata =
      LoRaWANDeviceMetadata
        .builder
        .ifSome(devEui)(_.devEui(_))
        .ifSome(fPort)(_.fPort(_))
        .ifSome(dataRate)(_.dataRate(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(gateways)(_.gateways(_))
        .build

    def loRaWANDeviceProfile(
      supportsClassB: Option[Boolean] = None,
      classBTimeout: Option[Int] = None,
      pingSlotPeriod: Option[Int] = None,
      pingSlotDr: Option[Int] = None,
      pingSlotFreq: Option[Int] = None,
      supportsClassC: Option[Boolean] = None,
      classCTimeout: Option[Int] = None,
      macVersion: Option[String] = None,
      regParamsRevision: Option[String] = None,
      rxDelay1: Option[Int] = None,
      rxDrOffset1: Option[Int] = None,
      rxDataRate2: Option[Int] = None,
      rxFreq2: Option[Int] = None,
      factoryPresetFreqsList: Option[List[PresetFreq]] = None,
      maxEirp: Option[Int] = None,
      maxDutyCycle: Option[Int] = None,
      rfRegion: Option[String] = None,
      supportsJoin: Option[Boolean] = None,
      supports32BitFCnt: Option[Boolean] = None
    ): LoRaWANDeviceProfile =
      LoRaWANDeviceProfile
        .builder
        .ifSome(supportsClassB)(_.supportsClassB(_))
        .ifSome(classBTimeout)(_.classBTimeout(_))
        .ifSome(pingSlotPeriod)(_.pingSlotPeriod(_))
        .ifSome(pingSlotDr)(_.pingSlotDr(_))
        .ifSome(pingSlotFreq)(_.pingSlotFreq(_))
        .ifSome(supportsClassC)(_.supportsClassC(_))
        .ifSome(classCTimeout)(_.classCTimeout(_))
        .ifSome(macVersion)(_.macVersion(_))
        .ifSome(regParamsRevision)(_.regParamsRevision(_))
        .ifSome(rxDelay1)(_.rxDelay1(_))
        .ifSome(rxDrOffset1)(_.rxDrOffset1(_))
        .ifSome(rxDataRate2)(_.rxDataRate2(_))
        .ifSome(rxFreq2)(_.rxFreq2(_))
        .ifSome(factoryPresetFreqsList)(_.factoryPresetFreqsList(_))
        .ifSome(maxEirp)(_.maxEirp(_))
        .ifSome(maxDutyCycle)(_.maxDutyCycle(_))
        .ifSome(rfRegion)(_.rfRegion(_))
        .ifSome(supportsJoin)(_.supportsJoin(_))
        .ifSome(supports32BitFCnt)(_.supports32BitFCnt(_))
        .build

    def loRaWANGateway(
      gatewayEui: Option[String] = None,
      rfRegion: Option[String] = None,
      joinEuiFilters: Option[List[JoinEuiRange]] = None,
      netIdFilters: Option[List[NetId]] = None,
      subBands: Option[List[SubBand]] = None
    ): LoRaWANGateway =
      LoRaWANGateway
        .builder
        .ifSome(gatewayEui)(_.gatewayEui(_))
        .ifSome(rfRegion)(_.rfRegion(_))
        .ifSome(joinEuiFilters)(_.joinEuiFilters(_))
        .ifSome(netIdFilters)(_.netIdFilters(_))
        .ifSome(subBands)(_.subBands(_))
        .build

    def loRaWANGatewayCurrentVersion(
      currentVersion: Option[LoRaWANGatewayVersion] = None
    ): LoRaWANGatewayCurrentVersion =
      LoRaWANGatewayCurrentVersion
        .builder
        .ifSome(currentVersion)(_.currentVersion(_))
        .build

    def loRaWANGatewayMetadata(
      gatewayEui: Option[String] = None,
      snr: Option[Double] = None,
      rssi: Option[Double] = None
    ): LoRaWANGatewayMetadata =
      LoRaWANGatewayMetadata
        .builder
        .ifSome(gatewayEui)(_.gatewayEui(_))
        .ifSome(snr)(_.snr(_))
        .ifSome(rssi)(_.rssi(_))
        .build

    def loRaWANGatewayVersion(
      packageVersion: Option[String] = None,
      model: Option[String] = None,
      station: Option[String] = None
    ): LoRaWANGatewayVersion =
      LoRaWANGatewayVersion
        .builder
        .ifSome(packageVersion)(_.packageVersion(_))
        .ifSome(model)(_.model(_))
        .ifSome(station)(_.station(_))
        .build

    def loRaWANGetServiceProfileInfo(
      ulRate: Option[Int] = None,
      ulBucketSize: Option[Int] = None,
      ulRatePolicy: Option[String] = None,
      dlRate: Option[Int] = None,
      dlBucketSize: Option[Int] = None,
      dlRatePolicy: Option[String] = None,
      addGwMetadata: Option[Boolean] = None,
      devStatusReqFreq: Option[Int] = None,
      reportDevStatusBattery: Option[Boolean] = None,
      reportDevStatusMargin: Option[Boolean] = None,
      drMin: Option[Int] = None,
      drMax: Option[Int] = None,
      channelMask: Option[String] = None,
      prAllowed: Option[Boolean] = None,
      hrAllowed: Option[Boolean] = None,
      raAllowed: Option[Boolean] = None,
      nwkGeoLoc: Option[Boolean] = None,
      targetPer: Option[Int] = None,
      minGwDiversity: Option[Int] = None
    ): LoRaWANGetServiceProfileInfo =
      LoRaWANGetServiceProfileInfo
        .builder
        .ifSome(ulRate)(_.ulRate(_))
        .ifSome(ulBucketSize)(_.ulBucketSize(_))
        .ifSome(ulRatePolicy)(_.ulRatePolicy(_))
        .ifSome(dlRate)(_.dlRate(_))
        .ifSome(dlBucketSize)(_.dlBucketSize(_))
        .ifSome(dlRatePolicy)(_.dlRatePolicy(_))
        .ifSome(addGwMetadata)(_.addGwMetadata(_))
        .ifSome(devStatusReqFreq)(_.devStatusReqFreq(_))
        .ifSome(reportDevStatusBattery)(_.reportDevStatusBattery(_))
        .ifSome(reportDevStatusMargin)(_.reportDevStatusMargin(_))
        .ifSome(drMin)(_.drMin(_))
        .ifSome(drMax)(_.drMax(_))
        .ifSome(channelMask)(_.channelMask(_))
        .ifSome(prAllowed)(_.prAllowed(_))
        .ifSome(hrAllowed)(_.hrAllowed(_))
        .ifSome(raAllowed)(_.raAllowed(_))
        .ifSome(nwkGeoLoc)(_.nwkGeoLoc(_))
        .ifSome(targetPer)(_.targetPer(_))
        .ifSome(minGwDiversity)(_.minGwDiversity(_))
        .build

    def loRaWANListDevice(
      devEui: Option[String] = None
    ): LoRaWANListDevice =
      LoRaWANListDevice
        .builder
        .ifSome(devEui)(_.devEui(_))
        .build

    def loRaWANSendDataToDevice(
      fPort: Option[Int] = None
    ): LoRaWANSendDataToDevice =
      LoRaWANSendDataToDevice
        .builder
        .ifSome(fPort)(_.fPort(_))
        .build

    def loRaWANServiceProfile(
      addGwMetadata: Option[Boolean] = None
    ): LoRaWANServiceProfile =
      LoRaWANServiceProfile
        .builder
        .ifSome(addGwMetadata)(_.addGwMetadata(_))
        .build

    def loRaWANUpdateDevice(
      deviceProfileId: Option[String] = None,
      serviceProfileId: Option[String] = None
    ): LoRaWANUpdateDevice =
      LoRaWANUpdateDevice
        .builder
        .ifSome(deviceProfileId)(_.deviceProfileId(_))
        .ifSome(serviceProfileId)(_.serviceProfileId(_))
        .build

    def loRaWANUpdateGatewayTaskCreate(
      updateSignature: Option[String] = None,
      sigKeyCrc: Option[Crc] = None,
      currentVersion: Option[LoRaWANGatewayVersion] = None,
      updateVersion: Option[LoRaWANGatewayVersion] = None
    ): LoRaWANUpdateGatewayTaskCreate =
      LoRaWANUpdateGatewayTaskCreate
        .builder
        .ifSome(updateSignature)(_.updateSignature(_))
        .ifSome(sigKeyCrc)(_.sigKeyCrc(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(updateVersion)(_.updateVersion(_))
        .build

    def loRaWANUpdateGatewayTaskEntry(
      currentVersion: Option[LoRaWANGatewayVersion] = None,
      updateVersion: Option[LoRaWANGatewayVersion] = None
    ): LoRaWANUpdateGatewayTaskEntry =
      LoRaWANUpdateGatewayTaskEntry
        .builder
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(updateVersion)(_.updateVersion(_))
        .build

    def otaaV1_0_x(
      appKey: Option[String] = None,
      appEui: Option[String] = None
    ): OtaaV1_0_x =
      OtaaV1_0_x
        .builder
        .ifSome(appKey)(_.appKey(_))
        .ifSome(appEui)(_.appEui(_))
        .build

    def otaaV1_1(
      appKey: Option[String] = None,
      nwkKey: Option[String] = None,
      joinEui: Option[String] = None
    ): OtaaV1_1 =
      OtaaV1_1
        .builder
        .ifSome(appKey)(_.appKey(_))
        .ifSome(nwkKey)(_.nwkKey(_))
        .ifSome(joinEui)(_.joinEui(_))
        .build

    def putResourceLogLevelRequest(
      resourceIdentifier: Option[String] = None,
      resourceType: Option[String] = None,
      logLevel: Option[String] = None
    ): PutResourceLogLevelRequest =
      PutResourceLogLevelRequest
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def putResourceLogLevelResponse(

    ): PutResourceLogLevelResponse =
      PutResourceLogLevelResponse
        .builder

        .build

    def resetAllResourceLogLevelsRequest(

    ): ResetAllResourceLogLevelsRequest =
      ResetAllResourceLogLevelsRequest
        .builder

        .build

    def resetAllResourceLogLevelsResponse(

    ): ResetAllResourceLogLevelsResponse =
      ResetAllResourceLogLevelsResponse
        .builder

        .build

    def resetResourceLogLevelRequest(
      resourceIdentifier: Option[String] = None,
      resourceType: Option[String] = None
    ): ResetResourceLogLevelRequest =
      ResetResourceLogLevelRequest
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def resetResourceLogLevelResponse(

    ): ResetResourceLogLevelResponse =
      ResetResourceLogLevelResponse
        .builder

        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceType: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def sendDataToWirelessDeviceRequest(
      id: Option[String] = None,
      transmitMode: Option[Int] = None,
      payloadData: Option[String] = None,
      wirelessMetadata: Option[WirelessMetadata] = None
    ): SendDataToWirelessDeviceRequest =
      SendDataToWirelessDeviceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(transmitMode)(_.transmitMode(_))
        .ifSome(payloadData)(_.payloadData(_))
        .ifSome(wirelessMetadata)(_.wirelessMetadata(_))
        .build

    def sendDataToWirelessDeviceResponse(
      messageId: Option[String] = None
    ): SendDataToWirelessDeviceResponse =
      SendDataToWirelessDeviceResponse
        .builder
        .ifSome(messageId)(_.messageId(_))
        .build

    def serviceProfile(
      arn: Option[String] = None,
      name: Option[String] = None,
      id: Option[String] = None
    ): ServiceProfile =
      ServiceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .build

    def sessionKeysAbpV1_0_x(
      nwkSKey: Option[String] = None,
      appSKey: Option[String] = None
    ): SessionKeysAbpV1_0_x =
      SessionKeysAbpV1_0_x
        .builder
        .ifSome(nwkSKey)(_.nwkSKey(_))
        .ifSome(appSKey)(_.appSKey(_))
        .build

    def sessionKeysAbpV1_1(
      fNwkSIntKey: Option[String] = None,
      sNwkSIntKey: Option[String] = None,
      nwkSEncKey: Option[String] = None,
      appSKey: Option[String] = None
    ): SessionKeysAbpV1_1 =
      SessionKeysAbpV1_1
        .builder
        .ifSome(fNwkSIntKey)(_.fNwkSIntKey(_))
        .ifSome(sNwkSIntKey)(_.sNwkSIntKey(_))
        .ifSome(nwkSEncKey)(_.nwkSEncKey(_))
        .ifSome(appSKey)(_.appSKey(_))
        .build

    def sidewalkAccountInfo(
      amazonId: Option[String] = None,
      appServerPrivateKey: Option[String] = None
    ): SidewalkAccountInfo =
      SidewalkAccountInfo
        .builder
        .ifSome(amazonId)(_.amazonId(_))
        .ifSome(appServerPrivateKey)(_.appServerPrivateKey(_))
        .build

    def sidewalkAccountInfoWithFingerprint(
      amazonId: Option[String] = None,
      fingerprint: Option[String] = None,
      arn: Option[String] = None
    ): SidewalkAccountInfoWithFingerprint =
      SidewalkAccountInfoWithFingerprint
        .builder
        .ifSome(amazonId)(_.amazonId(_))
        .ifSome(fingerprint)(_.fingerprint(_))
        .ifSome(arn)(_.arn(_))
        .build

    def sidewalkDevice(
      sidewalkId: Option[String] = None,
      sidewalkManufacturingSn: Option[String] = None,
      deviceCertificates: Option[List[CertificateList]] = None
    ): SidewalkDevice =
      SidewalkDevice
        .builder
        .ifSome(sidewalkId)(_.sidewalkId(_))
        .ifSome(sidewalkManufacturingSn)(_.sidewalkManufacturingSn(_))
        .ifSome(deviceCertificates)(_.deviceCertificates(_))
        .build

    def sidewalkDeviceMetadata(
      rssi: Option[Int] = None,
      batteryLevel: Option[String] = None,
      event: Option[String] = None,
      deviceState: Option[String] = None
    ): SidewalkDeviceMetadata =
      SidewalkDeviceMetadata
        .builder
        .ifSome(rssi)(_.rssi(_))
        .ifSome(batteryLevel)(_.batteryLevel(_))
        .ifSome(event)(_.event(_))
        .ifSome(deviceState)(_.deviceState(_))
        .build

    def sidewalkListDevice(
      amazonId: Option[String] = None,
      sidewalkId: Option[String] = None,
      sidewalkManufacturingSn: Option[String] = None,
      deviceCertificates: Option[List[CertificateList]] = None
    ): SidewalkListDevice =
      SidewalkListDevice
        .builder
        .ifSome(amazonId)(_.amazonId(_))
        .ifSome(sidewalkId)(_.sidewalkId(_))
        .ifSome(sidewalkManufacturingSn)(_.sidewalkManufacturingSn(_))
        .ifSome(deviceCertificates)(_.deviceCertificates(_))
        .build

    def sidewalkSendDataToDevice(
      seq: Option[Int] = None,
      messageType: Option[String] = None
    ): SidewalkSendDataToDevice =
      SidewalkSendDataToDevice
        .builder
        .ifSome(seq)(_.seq(_))
        .ifSome(messageType)(_.messageType(_))
        .build

    def sidewalkUpdateAccount(
      appServerPrivateKey: Option[String] = None
    ): SidewalkUpdateAccount =
      SidewalkUpdateAccount
        .builder
        .ifSome(appServerPrivateKey)(_.appServerPrivateKey(_))
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

    def testWirelessDeviceRequest(
      id: Option[String] = None
    ): TestWirelessDeviceRequest =
      TestWirelessDeviceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def testWirelessDeviceResponse(
      result: Option[String] = None
    ): TestWirelessDeviceResponse =
      TestWirelessDeviceResponse
        .builder
        .ifSome(result)(_.result(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
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

    def updateDestinationRequest(
      name: Option[String] = None,
      expressionType: Option[String] = None,
      expression: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdateDestinationRequest =
      UpdateDestinationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(expressionType)(_.expressionType(_))
        .ifSome(expression)(_.expression(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateDestinationResponse(

    ): UpdateDestinationResponse =
      UpdateDestinationResponse
        .builder

        .build

    def updateLogLevelsByResourceTypesRequest(
      defaultLogLevel: Option[String] = None,
      wirelessDeviceLogOptions: Option[List[WirelessDeviceLogOption]] = None,
      wirelessGatewayLogOptions: Option[List[WirelessGatewayLogOption]] = None
    ): UpdateLogLevelsByResourceTypesRequest =
      UpdateLogLevelsByResourceTypesRequest
        .builder
        .ifSome(defaultLogLevel)(_.defaultLogLevel(_))
        .ifSome(wirelessDeviceLogOptions)(_.wirelessDeviceLogOptions(_))
        .ifSome(wirelessGatewayLogOptions)(_.wirelessGatewayLogOptions(_))
        .build

    def updateLogLevelsByResourceTypesResponse(

    ): UpdateLogLevelsByResourceTypesResponse =
      UpdateLogLevelsByResourceTypesResponse
        .builder

        .build

    def updatePartnerAccountRequest(
      sidewalk: Option[SidewalkUpdateAccount] = None,
      partnerAccountId: Option[String] = None,
      partnerType: Option[String] = None
    ): UpdatePartnerAccountRequest =
      UpdatePartnerAccountRequest
        .builder
        .ifSome(sidewalk)(_.sidewalk(_))
        .ifSome(partnerAccountId)(_.partnerAccountId(_))
        .ifSome(partnerType)(_.partnerType(_))
        .build

    def updatePartnerAccountResponse(

    ): UpdatePartnerAccountResponse =
      UpdatePartnerAccountResponse
        .builder

        .build

    def updateWirelessDeviceRequest(
      id: Option[String] = None,
      destinationName: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      loRaWAN: Option[LoRaWANUpdateDevice] = None
    ): UpdateWirelessDeviceRequest =
      UpdateWirelessDeviceRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .build

    def updateWirelessDeviceResponse(

    ): UpdateWirelessDeviceResponse =
      UpdateWirelessDeviceResponse
        .builder

        .build

    def updateWirelessGatewayRequest(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      joinEuiFilters: Option[List[JoinEuiRange]] = None,
      netIdFilters: Option[List[NetId]] = None
    ): UpdateWirelessGatewayRequest =
      UpdateWirelessGatewayRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(joinEuiFilters)(_.joinEuiFilters(_))
        .ifSome(netIdFilters)(_.netIdFilters(_))
        .build

    def updateWirelessGatewayResponse(

    ): UpdateWirelessGatewayResponse =
      UpdateWirelessGatewayResponse
        .builder

        .build

    def updateWirelessGatewayTaskCreate(
      updateDataSource: Option[String] = None,
      updateDataRole: Option[String] = None,
      loRaWAN: Option[LoRaWANUpdateGatewayTaskCreate] = None
    ): UpdateWirelessGatewayTaskCreate =
      UpdateWirelessGatewayTaskCreate
        .builder
        .ifSome(updateDataSource)(_.updateDataSource(_))
        .ifSome(updateDataRole)(_.updateDataRole(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .build

    def updateWirelessGatewayTaskEntry(
      id: Option[String] = None,
      loRaWAN: Option[LoRaWANUpdateGatewayTaskEntry] = None,
      arn: Option[String] = None
    ): UpdateWirelessGatewayTaskEntry =
      UpdateWirelessGatewayTaskEntry
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(arn)(_.arn(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def wirelessDeviceEventLogOption(
      event: Option[String] = None,
      logLevel: Option[String] = None
    ): WirelessDeviceEventLogOption =
      WirelessDeviceEventLogOption
        .builder
        .ifSome(event)(_.event(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def wirelessDeviceLogOption(
      `type`: Option[String] = None,
      logLevel: Option[String] = None,
      events: Option[List[WirelessDeviceEventLogOption]] = None
    ): WirelessDeviceLogOption =
      WirelessDeviceLogOption
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(events)(_.events(_))
        .build

    def wirelessDeviceStatistics(
      arn: Option[String] = None,
      id: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      destinationName: Option[String] = None,
      lastUplinkReceivedAt: Option[String] = None,
      loRaWAN: Option[LoRaWANListDevice] = None,
      sidewalk: Option[SidewalkListDevice] = None
    ): WirelessDeviceStatistics =
      WirelessDeviceStatistics
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(destinationName)(_.destinationName(_))
        .ifSome(lastUplinkReceivedAt)(_.lastUplinkReceivedAt(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(sidewalk)(_.sidewalk(_))
        .build

    def wirelessGatewayEventLogOption(
      event: Option[String] = None,
      logLevel: Option[String] = None
    ): WirelessGatewayEventLogOption =
      WirelessGatewayEventLogOption
        .builder
        .ifSome(event)(_.event(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def wirelessGatewayLogOption(
      `type`: Option[String] = None,
      logLevel: Option[String] = None,
      events: Option[List[WirelessGatewayEventLogOption]] = None
    ): WirelessGatewayLogOption =
      WirelessGatewayLogOption
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(events)(_.events(_))
        .build

    def wirelessGatewayStatistics(
      arn: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      loRaWAN: Option[LoRaWANGateway] = None,
      lastUplinkReceivedAt: Option[String] = None
    ): WirelessGatewayStatistics =
      WirelessGatewayStatistics
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(lastUplinkReceivedAt)(_.lastUplinkReceivedAt(_))
        .build

    def wirelessMetadata(
      loRaWAN: Option[LoRaWANSendDataToDevice] = None,
      sidewalk: Option[SidewalkSendDataToDevice] = None
    ): WirelessMetadata =
      WirelessMetadata
        .builder
        .ifSome(loRaWAN)(_.loRaWAN(_))
        .ifSome(sidewalk)(_.sidewalk(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
