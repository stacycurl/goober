package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.iotwireless.IotWirelessClient
import software.amazon.awssdk.services.iotwireless.model._


object iotwireless { module =>

  // Free monad over IotWirelessOp
  type IotWirelessIO[A] = FF[IotWirelessOp, A]

  sealed trait IotWirelessOp[A] {
    def visit[F[_]](visitor: IotWirelessOp.Visitor[F]): F[A]
  }

  object IotWirelessOp {
    // Given a IotWirelessClient we can embed a IotWirelessIO program in any algebra that understands embedding.
    implicit val IotWirelessOpEmbeddable: Embeddable[IotWirelessOp, IotWirelessClient] = new Embeddable[IotWirelessOp, IotWirelessClient] {
      def embed[A](client: IotWirelessClient, io: IotWirelessIO[A]): Embedded[A] = Embedded.IotWireless(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends IotWirelessOp.Visitor[Kleisli[M, IotWirelessClient, *]] {
        def associateAwsAccountWithPartnerAccount(
          request: AssociateAwsAccountWithPartnerAccountRequest
        ): Kleisli[M, IotWirelessClient, AssociateAwsAccountWithPartnerAccountResponse] =
          primitive(_.associateAwsAccountWithPartnerAccount(request))

        def associateWirelessDeviceWithThing(
          request: AssociateWirelessDeviceWithThingRequest
        ): Kleisli[M, IotWirelessClient, AssociateWirelessDeviceWithThingResponse] =
          primitive(_.associateWirelessDeviceWithThing(request))

        def associateWirelessGatewayWithCertificate(
          request: AssociateWirelessGatewayWithCertificateRequest
        ): Kleisli[M, IotWirelessClient, AssociateWirelessGatewayWithCertificateResponse] =
          primitive(_.associateWirelessGatewayWithCertificate(request))

        def associateWirelessGatewayWithThing(
          request: AssociateWirelessGatewayWithThingRequest
        ): Kleisli[M, IotWirelessClient, AssociateWirelessGatewayWithThingResponse] =
          primitive(_.associateWirelessGatewayWithThing(request))

        def createDestination(
          request: CreateDestinationRequest
        ): Kleisli[M, IotWirelessClient, CreateDestinationResponse] =
          primitive(_.createDestination(request))

        def createDeviceProfile(
          request: CreateDeviceProfileRequest
        ): Kleisli[M, IotWirelessClient, CreateDeviceProfileResponse] =
          primitive(_.createDeviceProfile(request))

        def createServiceProfile(
          request: CreateServiceProfileRequest
        ): Kleisli[M, IotWirelessClient, CreateServiceProfileResponse] =
          primitive(_.createServiceProfile(request))

        def createWirelessDevice(
          request: CreateWirelessDeviceRequest
        ): Kleisli[M, IotWirelessClient, CreateWirelessDeviceResponse] =
          primitive(_.createWirelessDevice(request))

        def createWirelessGateway(
          request: CreateWirelessGatewayRequest
        ): Kleisli[M, IotWirelessClient, CreateWirelessGatewayResponse] =
          primitive(_.createWirelessGateway(request))

        def createWirelessGatewayTask(
          request: CreateWirelessGatewayTaskRequest
        ): Kleisli[M, IotWirelessClient, CreateWirelessGatewayTaskResponse] =
          primitive(_.createWirelessGatewayTask(request))

        def createWirelessGatewayTaskDefinition(
          request: CreateWirelessGatewayTaskDefinitionRequest
        ): Kleisli[M, IotWirelessClient, CreateWirelessGatewayTaskDefinitionResponse] =
          primitive(_.createWirelessGatewayTaskDefinition(request))

        def deleteDestination(
          request: DeleteDestinationRequest
        ): Kleisli[M, IotWirelessClient, DeleteDestinationResponse] =
          primitive(_.deleteDestination(request))

        def deleteDeviceProfile(
          request: DeleteDeviceProfileRequest
        ): Kleisli[M, IotWirelessClient, DeleteDeviceProfileResponse] =
          primitive(_.deleteDeviceProfile(request))

        def deleteServiceProfile(
          request: DeleteServiceProfileRequest
        ): Kleisli[M, IotWirelessClient, DeleteServiceProfileResponse] =
          primitive(_.deleteServiceProfile(request))

        def deleteWirelessDevice(
          request: DeleteWirelessDeviceRequest
        ): Kleisli[M, IotWirelessClient, DeleteWirelessDeviceResponse] =
          primitive(_.deleteWirelessDevice(request))

        def deleteWirelessGateway(
          request: DeleteWirelessGatewayRequest
        ): Kleisli[M, IotWirelessClient, DeleteWirelessGatewayResponse] =
          primitive(_.deleteWirelessGateway(request))

        def deleteWirelessGatewayTask(
          request: DeleteWirelessGatewayTaskRequest
        ): Kleisli[M, IotWirelessClient, DeleteWirelessGatewayTaskResponse] =
          primitive(_.deleteWirelessGatewayTask(request))

        def deleteWirelessGatewayTaskDefinition(
          request: DeleteWirelessGatewayTaskDefinitionRequest
        ): Kleisli[M, IotWirelessClient, DeleteWirelessGatewayTaskDefinitionResponse] =
          primitive(_.deleteWirelessGatewayTaskDefinition(request))

        def disassociateAwsAccountFromPartnerAccount(
          request: DisassociateAwsAccountFromPartnerAccountRequest
        ): Kleisli[M, IotWirelessClient, DisassociateAwsAccountFromPartnerAccountResponse] =
          primitive(_.disassociateAwsAccountFromPartnerAccount(request))

        def disassociateWirelessDeviceFromThing(
          request: DisassociateWirelessDeviceFromThingRequest
        ): Kleisli[M, IotWirelessClient, DisassociateWirelessDeviceFromThingResponse] =
          primitive(_.disassociateWirelessDeviceFromThing(request))

        def disassociateWirelessGatewayFromCertificate(
          request: DisassociateWirelessGatewayFromCertificateRequest
        ): Kleisli[M, IotWirelessClient, DisassociateWirelessGatewayFromCertificateResponse] =
          primitive(_.disassociateWirelessGatewayFromCertificate(request))

        def disassociateWirelessGatewayFromThing(
          request: DisassociateWirelessGatewayFromThingRequest
        ): Kleisli[M, IotWirelessClient, DisassociateWirelessGatewayFromThingResponse] =
          primitive(_.disassociateWirelessGatewayFromThing(request))

        def getDestination(
          request: GetDestinationRequest
        ): Kleisli[M, IotWirelessClient, GetDestinationResponse] =
          primitive(_.getDestination(request))

        def getDeviceProfile(
          request: GetDeviceProfileRequest
        ): Kleisli[M, IotWirelessClient, GetDeviceProfileResponse] =
          primitive(_.getDeviceProfile(request))

        def getLogLevelsByResourceTypes(
          request: GetLogLevelsByResourceTypesRequest
        ): Kleisli[M, IotWirelessClient, GetLogLevelsByResourceTypesResponse] =
          primitive(_.getLogLevelsByResourceTypes(request))

        def getPartnerAccount(
          request: GetPartnerAccountRequest
        ): Kleisli[M, IotWirelessClient, GetPartnerAccountResponse] =
          primitive(_.getPartnerAccount(request))

        def getResourceLogLevel(
          request: GetResourceLogLevelRequest
        ): Kleisli[M, IotWirelessClient, GetResourceLogLevelResponse] =
          primitive(_.getResourceLogLevel(request))

        def getServiceEndpoint(
          request: GetServiceEndpointRequest
        ): Kleisli[M, IotWirelessClient, GetServiceEndpointResponse] =
          primitive(_.getServiceEndpoint(request))

        def getServiceProfile(
          request: GetServiceProfileRequest
        ): Kleisli[M, IotWirelessClient, GetServiceProfileResponse] =
          primitive(_.getServiceProfile(request))

        def getWirelessDevice(
          request: GetWirelessDeviceRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessDeviceResponse] =
          primitive(_.getWirelessDevice(request))

        def getWirelessDeviceStatistics(
          request: GetWirelessDeviceStatisticsRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessDeviceStatisticsResponse] =
          primitive(_.getWirelessDeviceStatistics(request))

        def getWirelessGateway(
          request: GetWirelessGatewayRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessGatewayResponse] =
          primitive(_.getWirelessGateway(request))

        def getWirelessGatewayCertificate(
          request: GetWirelessGatewayCertificateRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessGatewayCertificateResponse] =
          primitive(_.getWirelessGatewayCertificate(request))

        def getWirelessGatewayFirmwareInformation(
          request: GetWirelessGatewayFirmwareInformationRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessGatewayFirmwareInformationResponse] =
          primitive(_.getWirelessGatewayFirmwareInformation(request))

        def getWirelessGatewayStatistics(
          request: GetWirelessGatewayStatisticsRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessGatewayStatisticsResponse] =
          primitive(_.getWirelessGatewayStatistics(request))

        def getWirelessGatewayTask(
          request: GetWirelessGatewayTaskRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessGatewayTaskResponse] =
          primitive(_.getWirelessGatewayTask(request))

        def getWirelessGatewayTaskDefinition(
          request: GetWirelessGatewayTaskDefinitionRequest
        ): Kleisli[M, IotWirelessClient, GetWirelessGatewayTaskDefinitionResponse] =
          primitive(_.getWirelessGatewayTaskDefinition(request))

        def listDestinations(
          request: ListDestinationsRequest
        ): Kleisli[M, IotWirelessClient, ListDestinationsResponse] =
          primitive(_.listDestinations(request))

        def listDeviceProfiles(
          request: ListDeviceProfilesRequest
        ): Kleisli[M, IotWirelessClient, ListDeviceProfilesResponse] =
          primitive(_.listDeviceProfiles(request))

        def listPartnerAccounts(
          request: ListPartnerAccountsRequest
        ): Kleisli[M, IotWirelessClient, ListPartnerAccountsResponse] =
          primitive(_.listPartnerAccounts(request))

        def listServiceProfiles(
          request: ListServiceProfilesRequest
        ): Kleisli[M, IotWirelessClient, ListServiceProfilesResponse] =
          primitive(_.listServiceProfiles(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, IotWirelessClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listWirelessDevices(
          request: ListWirelessDevicesRequest
        ): Kleisli[M, IotWirelessClient, ListWirelessDevicesResponse] =
          primitive(_.listWirelessDevices(request))

        def listWirelessGatewayTaskDefinitions(
          request: ListWirelessGatewayTaskDefinitionsRequest
        ): Kleisli[M, IotWirelessClient, ListWirelessGatewayTaskDefinitionsResponse] =
          primitive(_.listWirelessGatewayTaskDefinitions(request))

        def listWirelessGateways(
          request: ListWirelessGatewaysRequest
        ): Kleisli[M, IotWirelessClient, ListWirelessGatewaysResponse] =
          primitive(_.listWirelessGateways(request))

        def putResourceLogLevel(
          request: PutResourceLogLevelRequest
        ): Kleisli[M, IotWirelessClient, PutResourceLogLevelResponse] =
          primitive(_.putResourceLogLevel(request))

        def resetAllResourceLogLevels(
          request: ResetAllResourceLogLevelsRequest
        ): Kleisli[M, IotWirelessClient, ResetAllResourceLogLevelsResponse] =
          primitive(_.resetAllResourceLogLevels(request))

        def resetResourceLogLevel(
          request: ResetResourceLogLevelRequest
        ): Kleisli[M, IotWirelessClient, ResetResourceLogLevelResponse] =
          primitive(_.resetResourceLogLevel(request))

        def sendDataToWirelessDevice(
          request: SendDataToWirelessDeviceRequest
        ): Kleisli[M, IotWirelessClient, SendDataToWirelessDeviceResponse] =
          primitive(_.sendDataToWirelessDevice(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, IotWirelessClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def testWirelessDevice(
          request: TestWirelessDeviceRequest
        ): Kleisli[M, IotWirelessClient, TestWirelessDeviceResponse] =
          primitive(_.testWirelessDevice(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, IotWirelessClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateDestination(
          request: UpdateDestinationRequest
        ): Kleisli[M, IotWirelessClient, UpdateDestinationResponse] =
          primitive(_.updateDestination(request))

        def updateLogLevelsByResourceTypes(
          request: UpdateLogLevelsByResourceTypesRequest
        ): Kleisli[M, IotWirelessClient, UpdateLogLevelsByResourceTypesResponse] =
          primitive(_.updateLogLevelsByResourceTypes(request))

        def updatePartnerAccount(
          request: UpdatePartnerAccountRequest
        ): Kleisli[M, IotWirelessClient, UpdatePartnerAccountResponse] =
          primitive(_.updatePartnerAccount(request))

        def updateWirelessDevice(
          request: UpdateWirelessDeviceRequest
        ): Kleisli[M, IotWirelessClient, UpdateWirelessDeviceResponse] =
          primitive(_.updateWirelessDevice(request))

        def updateWirelessGateway(
          request: UpdateWirelessGatewayRequest
        ): Kleisli[M, IotWirelessClient, UpdateWirelessGatewayResponse] =
          primitive(_.updateWirelessGateway(request))

        def primitive[A](
          f: IotWirelessClient => A
        ): Kleisli[M, IotWirelessClient, A]
      }
    }

    trait Visitor[F[_]] extends (IotWirelessOp ~> F) {
      final def apply[A](op: IotWirelessOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateAwsAccountWithPartnerAccount(
        request: AssociateAwsAccountWithPartnerAccountRequest
      ): F[AssociateAwsAccountWithPartnerAccountResponse]

      def associateWirelessDeviceWithThing(
        request: AssociateWirelessDeviceWithThingRequest
      ): F[AssociateWirelessDeviceWithThingResponse]

      def associateWirelessGatewayWithCertificate(
        request: AssociateWirelessGatewayWithCertificateRequest
      ): F[AssociateWirelessGatewayWithCertificateResponse]

      def associateWirelessGatewayWithThing(
        request: AssociateWirelessGatewayWithThingRequest
      ): F[AssociateWirelessGatewayWithThingResponse]

      def createDestination(
        request: CreateDestinationRequest
      ): F[CreateDestinationResponse]

      def createDeviceProfile(
        request: CreateDeviceProfileRequest
      ): F[CreateDeviceProfileResponse]

      def createServiceProfile(
        request: CreateServiceProfileRequest
      ): F[CreateServiceProfileResponse]

      def createWirelessDevice(
        request: CreateWirelessDeviceRequest
      ): F[CreateWirelessDeviceResponse]

      def createWirelessGateway(
        request: CreateWirelessGatewayRequest
      ): F[CreateWirelessGatewayResponse]

      def createWirelessGatewayTask(
        request: CreateWirelessGatewayTaskRequest
      ): F[CreateWirelessGatewayTaskResponse]

      def createWirelessGatewayTaskDefinition(
        request: CreateWirelessGatewayTaskDefinitionRequest
      ): F[CreateWirelessGatewayTaskDefinitionResponse]

      def deleteDestination(
        request: DeleteDestinationRequest
      ): F[DeleteDestinationResponse]

      def deleteDeviceProfile(
        request: DeleteDeviceProfileRequest
      ): F[DeleteDeviceProfileResponse]

      def deleteServiceProfile(
        request: DeleteServiceProfileRequest
      ): F[DeleteServiceProfileResponse]

      def deleteWirelessDevice(
        request: DeleteWirelessDeviceRequest
      ): F[DeleteWirelessDeviceResponse]

      def deleteWirelessGateway(
        request: DeleteWirelessGatewayRequest
      ): F[DeleteWirelessGatewayResponse]

      def deleteWirelessGatewayTask(
        request: DeleteWirelessGatewayTaskRequest
      ): F[DeleteWirelessGatewayTaskResponse]

      def deleteWirelessGatewayTaskDefinition(
        request: DeleteWirelessGatewayTaskDefinitionRequest
      ): F[DeleteWirelessGatewayTaskDefinitionResponse]

      def disassociateAwsAccountFromPartnerAccount(
        request: DisassociateAwsAccountFromPartnerAccountRequest
      ): F[DisassociateAwsAccountFromPartnerAccountResponse]

      def disassociateWirelessDeviceFromThing(
        request: DisassociateWirelessDeviceFromThingRequest
      ): F[DisassociateWirelessDeviceFromThingResponse]

      def disassociateWirelessGatewayFromCertificate(
        request: DisassociateWirelessGatewayFromCertificateRequest
      ): F[DisassociateWirelessGatewayFromCertificateResponse]

      def disassociateWirelessGatewayFromThing(
        request: DisassociateWirelessGatewayFromThingRequest
      ): F[DisassociateWirelessGatewayFromThingResponse]

      def getDestination(
        request: GetDestinationRequest
      ): F[GetDestinationResponse]

      def getDeviceProfile(
        request: GetDeviceProfileRequest
      ): F[GetDeviceProfileResponse]

      def getLogLevelsByResourceTypes(
        request: GetLogLevelsByResourceTypesRequest
      ): F[GetLogLevelsByResourceTypesResponse]

      def getPartnerAccount(
        request: GetPartnerAccountRequest
      ): F[GetPartnerAccountResponse]

      def getResourceLogLevel(
        request: GetResourceLogLevelRequest
      ): F[GetResourceLogLevelResponse]

      def getServiceEndpoint(
        request: GetServiceEndpointRequest
      ): F[GetServiceEndpointResponse]

      def getServiceProfile(
        request: GetServiceProfileRequest
      ): F[GetServiceProfileResponse]

      def getWirelessDevice(
        request: GetWirelessDeviceRequest
      ): F[GetWirelessDeviceResponse]

      def getWirelessDeviceStatistics(
        request: GetWirelessDeviceStatisticsRequest
      ): F[GetWirelessDeviceStatisticsResponse]

      def getWirelessGateway(
        request: GetWirelessGatewayRequest
      ): F[GetWirelessGatewayResponse]

      def getWirelessGatewayCertificate(
        request: GetWirelessGatewayCertificateRequest
      ): F[GetWirelessGatewayCertificateResponse]

      def getWirelessGatewayFirmwareInformation(
        request: GetWirelessGatewayFirmwareInformationRequest
      ): F[GetWirelessGatewayFirmwareInformationResponse]

      def getWirelessGatewayStatistics(
        request: GetWirelessGatewayStatisticsRequest
      ): F[GetWirelessGatewayStatisticsResponse]

      def getWirelessGatewayTask(
        request: GetWirelessGatewayTaskRequest
      ): F[GetWirelessGatewayTaskResponse]

      def getWirelessGatewayTaskDefinition(
        request: GetWirelessGatewayTaskDefinitionRequest
      ): F[GetWirelessGatewayTaskDefinitionResponse]

      def listDestinations(
        request: ListDestinationsRequest
      ): F[ListDestinationsResponse]

      def listDeviceProfiles(
        request: ListDeviceProfilesRequest
      ): F[ListDeviceProfilesResponse]

      def listPartnerAccounts(
        request: ListPartnerAccountsRequest
      ): F[ListPartnerAccountsResponse]

      def listServiceProfiles(
        request: ListServiceProfilesRequest
      ): F[ListServiceProfilesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listWirelessDevices(
        request: ListWirelessDevicesRequest
      ): F[ListWirelessDevicesResponse]

      def listWirelessGatewayTaskDefinitions(
        request: ListWirelessGatewayTaskDefinitionsRequest
      ): F[ListWirelessGatewayTaskDefinitionsResponse]

      def listWirelessGateways(
        request: ListWirelessGatewaysRequest
      ): F[ListWirelessGatewaysResponse]

      def putResourceLogLevel(
        request: PutResourceLogLevelRequest
      ): F[PutResourceLogLevelResponse]

      def resetAllResourceLogLevels(
        request: ResetAllResourceLogLevelsRequest
      ): F[ResetAllResourceLogLevelsResponse]

      def resetResourceLogLevel(
        request: ResetResourceLogLevelRequest
      ): F[ResetResourceLogLevelResponse]

      def sendDataToWirelessDevice(
        request: SendDataToWirelessDeviceRequest
      ): F[SendDataToWirelessDeviceResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def testWirelessDevice(
        request: TestWirelessDeviceRequest
      ): F[TestWirelessDeviceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateDestination(
        request: UpdateDestinationRequest
      ): F[UpdateDestinationResponse]

      def updateLogLevelsByResourceTypes(
        request: UpdateLogLevelsByResourceTypesRequest
      ): F[UpdateLogLevelsByResourceTypesResponse]

      def updatePartnerAccount(
        request: UpdatePartnerAccountRequest
      ): F[UpdatePartnerAccountResponse]

      def updateWirelessDevice(
        request: UpdateWirelessDeviceRequest
      ): F[UpdateWirelessDeviceResponse]

      def updateWirelessGateway(
        request: UpdateWirelessGatewayRequest
      ): F[UpdateWirelessGatewayResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends IotWirelessOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateAwsAccountWithPartnerAccountOp(
      request: AssociateAwsAccountWithPartnerAccountRequest
    ) extends IotWirelessOp[AssociateAwsAccountWithPartnerAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateAwsAccountWithPartnerAccountResponse] =
        visitor.associateAwsAccountWithPartnerAccount(request)
    }

    final case class AssociateWirelessDeviceWithThingOp(
      request: AssociateWirelessDeviceWithThingRequest
    ) extends IotWirelessOp[AssociateWirelessDeviceWithThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWirelessDeviceWithThingResponse] =
        visitor.associateWirelessDeviceWithThing(request)
    }

    final case class AssociateWirelessGatewayWithCertificateOp(
      request: AssociateWirelessGatewayWithCertificateRequest
    ) extends IotWirelessOp[AssociateWirelessGatewayWithCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWirelessGatewayWithCertificateResponse] =
        visitor.associateWirelessGatewayWithCertificate(request)
    }

    final case class AssociateWirelessGatewayWithThingOp(
      request: AssociateWirelessGatewayWithThingRequest
    ) extends IotWirelessOp[AssociateWirelessGatewayWithThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateWirelessGatewayWithThingResponse] =
        visitor.associateWirelessGatewayWithThing(request)
    }

    final case class CreateDestinationOp(
      request: CreateDestinationRequest
    ) extends IotWirelessOp[CreateDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDestinationResponse] =
        visitor.createDestination(request)
    }

    final case class CreateDeviceProfileOp(
      request: CreateDeviceProfileRequest
    ) extends IotWirelessOp[CreateDeviceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateDeviceProfileResponse] =
        visitor.createDeviceProfile(request)
    }

    final case class CreateServiceProfileOp(
      request: CreateServiceProfileRequest
    ) extends IotWirelessOp[CreateServiceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateServiceProfileResponse] =
        visitor.createServiceProfile(request)
    }

    final case class CreateWirelessDeviceOp(
      request: CreateWirelessDeviceRequest
    ) extends IotWirelessOp[CreateWirelessDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWirelessDeviceResponse] =
        visitor.createWirelessDevice(request)
    }

    final case class CreateWirelessGatewayOp(
      request: CreateWirelessGatewayRequest
    ) extends IotWirelessOp[CreateWirelessGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWirelessGatewayResponse] =
        visitor.createWirelessGateway(request)
    }

    final case class CreateWirelessGatewayTaskOp(
      request: CreateWirelessGatewayTaskRequest
    ) extends IotWirelessOp[CreateWirelessGatewayTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWirelessGatewayTaskResponse] =
        visitor.createWirelessGatewayTask(request)
    }

    final case class CreateWirelessGatewayTaskDefinitionOp(
      request: CreateWirelessGatewayTaskDefinitionRequest
    ) extends IotWirelessOp[CreateWirelessGatewayTaskDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateWirelessGatewayTaskDefinitionResponse] =
        visitor.createWirelessGatewayTaskDefinition(request)
    }

    final case class DeleteDestinationOp(
      request: DeleteDestinationRequest
    ) extends IotWirelessOp[DeleteDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDestinationResponse] =
        visitor.deleteDestination(request)
    }

    final case class DeleteDeviceProfileOp(
      request: DeleteDeviceProfileRequest
    ) extends IotWirelessOp[DeleteDeviceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeviceProfileResponse] =
        visitor.deleteDeviceProfile(request)
    }

    final case class DeleteServiceProfileOp(
      request: DeleteServiceProfileRequest
    ) extends IotWirelessOp[DeleteServiceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteServiceProfileResponse] =
        visitor.deleteServiceProfile(request)
    }

    final case class DeleteWirelessDeviceOp(
      request: DeleteWirelessDeviceRequest
    ) extends IotWirelessOp[DeleteWirelessDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWirelessDeviceResponse] =
        visitor.deleteWirelessDevice(request)
    }

    final case class DeleteWirelessGatewayOp(
      request: DeleteWirelessGatewayRequest
    ) extends IotWirelessOp[DeleteWirelessGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWirelessGatewayResponse] =
        visitor.deleteWirelessGateway(request)
    }

    final case class DeleteWirelessGatewayTaskOp(
      request: DeleteWirelessGatewayTaskRequest
    ) extends IotWirelessOp[DeleteWirelessGatewayTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWirelessGatewayTaskResponse] =
        visitor.deleteWirelessGatewayTask(request)
    }

    final case class DeleteWirelessGatewayTaskDefinitionOp(
      request: DeleteWirelessGatewayTaskDefinitionRequest
    ) extends IotWirelessOp[DeleteWirelessGatewayTaskDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteWirelessGatewayTaskDefinitionResponse] =
        visitor.deleteWirelessGatewayTaskDefinition(request)
    }

    final case class DisassociateAwsAccountFromPartnerAccountOp(
      request: DisassociateAwsAccountFromPartnerAccountRequest
    ) extends IotWirelessOp[DisassociateAwsAccountFromPartnerAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateAwsAccountFromPartnerAccountResponse] =
        visitor.disassociateAwsAccountFromPartnerAccount(request)
    }

    final case class DisassociateWirelessDeviceFromThingOp(
      request: DisassociateWirelessDeviceFromThingRequest
    ) extends IotWirelessOp[DisassociateWirelessDeviceFromThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWirelessDeviceFromThingResponse] =
        visitor.disassociateWirelessDeviceFromThing(request)
    }

    final case class DisassociateWirelessGatewayFromCertificateOp(
      request: DisassociateWirelessGatewayFromCertificateRequest
    ) extends IotWirelessOp[DisassociateWirelessGatewayFromCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWirelessGatewayFromCertificateResponse] =
        visitor.disassociateWirelessGatewayFromCertificate(request)
    }

    final case class DisassociateWirelessGatewayFromThingOp(
      request: DisassociateWirelessGatewayFromThingRequest
    ) extends IotWirelessOp[DisassociateWirelessGatewayFromThingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateWirelessGatewayFromThingResponse] =
        visitor.disassociateWirelessGatewayFromThing(request)
    }

    final case class GetDestinationOp(
      request: GetDestinationRequest
    ) extends IotWirelessOp[GetDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDestinationResponse] =
        visitor.getDestination(request)
    }

    final case class GetDeviceProfileOp(
      request: GetDeviceProfileRequest
    ) extends IotWirelessOp[GetDeviceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceProfileResponse] =
        visitor.getDeviceProfile(request)
    }

    final case class GetLogLevelsByResourceTypesOp(
      request: GetLogLevelsByResourceTypesRequest
    ) extends IotWirelessOp[GetLogLevelsByResourceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetLogLevelsByResourceTypesResponse] =
        visitor.getLogLevelsByResourceTypes(request)
    }

    final case class GetPartnerAccountOp(
      request: GetPartnerAccountRequest
    ) extends IotWirelessOp[GetPartnerAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPartnerAccountResponse] =
        visitor.getPartnerAccount(request)
    }

    final case class GetResourceLogLevelOp(
      request: GetResourceLogLevelRequest
    ) extends IotWirelessOp[GetResourceLogLevelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetResourceLogLevelResponse] =
        visitor.getResourceLogLevel(request)
    }

    final case class GetServiceEndpointOp(
      request: GetServiceEndpointRequest
    ) extends IotWirelessOp[GetServiceEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceEndpointResponse] =
        visitor.getServiceEndpoint(request)
    }

    final case class GetServiceProfileOp(
      request: GetServiceProfileRequest
    ) extends IotWirelessOp[GetServiceProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetServiceProfileResponse] =
        visitor.getServiceProfile(request)
    }

    final case class GetWirelessDeviceOp(
      request: GetWirelessDeviceRequest
    ) extends IotWirelessOp[GetWirelessDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessDeviceResponse] =
        visitor.getWirelessDevice(request)
    }

    final case class GetWirelessDeviceStatisticsOp(
      request: GetWirelessDeviceStatisticsRequest
    ) extends IotWirelessOp[GetWirelessDeviceStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessDeviceStatisticsResponse] =
        visitor.getWirelessDeviceStatistics(request)
    }

    final case class GetWirelessGatewayOp(
      request: GetWirelessGatewayRequest
    ) extends IotWirelessOp[GetWirelessGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessGatewayResponse] =
        visitor.getWirelessGateway(request)
    }

    final case class GetWirelessGatewayCertificateOp(
      request: GetWirelessGatewayCertificateRequest
    ) extends IotWirelessOp[GetWirelessGatewayCertificateResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessGatewayCertificateResponse] =
        visitor.getWirelessGatewayCertificate(request)
    }

    final case class GetWirelessGatewayFirmwareInformationOp(
      request: GetWirelessGatewayFirmwareInformationRequest
    ) extends IotWirelessOp[GetWirelessGatewayFirmwareInformationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessGatewayFirmwareInformationResponse] =
        visitor.getWirelessGatewayFirmwareInformation(request)
    }

    final case class GetWirelessGatewayStatisticsOp(
      request: GetWirelessGatewayStatisticsRequest
    ) extends IotWirelessOp[GetWirelessGatewayStatisticsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessGatewayStatisticsResponse] =
        visitor.getWirelessGatewayStatistics(request)
    }

    final case class GetWirelessGatewayTaskOp(
      request: GetWirelessGatewayTaskRequest
    ) extends IotWirelessOp[GetWirelessGatewayTaskResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessGatewayTaskResponse] =
        visitor.getWirelessGatewayTask(request)
    }

    final case class GetWirelessGatewayTaskDefinitionOp(
      request: GetWirelessGatewayTaskDefinitionRequest
    ) extends IotWirelessOp[GetWirelessGatewayTaskDefinitionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetWirelessGatewayTaskDefinitionResponse] =
        visitor.getWirelessGatewayTaskDefinition(request)
    }

    final case class ListDestinationsOp(
      request: ListDestinationsRequest
    ) extends IotWirelessOp[ListDestinationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDestinationsResponse] =
        visitor.listDestinations(request)
    }

    final case class ListDeviceProfilesOp(
      request: ListDeviceProfilesRequest
    ) extends IotWirelessOp[ListDeviceProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceProfilesResponse] =
        visitor.listDeviceProfiles(request)
    }

    final case class ListPartnerAccountsOp(
      request: ListPartnerAccountsRequest
    ) extends IotWirelessOp[ListPartnerAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPartnerAccountsResponse] =
        visitor.listPartnerAccounts(request)
    }

    final case class ListServiceProfilesOp(
      request: ListServiceProfilesRequest
    ) extends IotWirelessOp[ListServiceProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListServiceProfilesResponse] =
        visitor.listServiceProfiles(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends IotWirelessOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListWirelessDevicesOp(
      request: ListWirelessDevicesRequest
    ) extends IotWirelessOp[ListWirelessDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWirelessDevicesResponse] =
        visitor.listWirelessDevices(request)
    }

    final case class ListWirelessGatewayTaskDefinitionsOp(
      request: ListWirelessGatewayTaskDefinitionsRequest
    ) extends IotWirelessOp[ListWirelessGatewayTaskDefinitionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWirelessGatewayTaskDefinitionsResponse] =
        visitor.listWirelessGatewayTaskDefinitions(request)
    }

    final case class ListWirelessGatewaysOp(
      request: ListWirelessGatewaysRequest
    ) extends IotWirelessOp[ListWirelessGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListWirelessGatewaysResponse] =
        visitor.listWirelessGateways(request)
    }

    final case class PutResourceLogLevelOp(
      request: PutResourceLogLevelRequest
    ) extends IotWirelessOp[PutResourceLogLevelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutResourceLogLevelResponse] =
        visitor.putResourceLogLevel(request)
    }

    final case class ResetAllResourceLogLevelsOp(
      request: ResetAllResourceLogLevelsRequest
    ) extends IotWirelessOp[ResetAllResourceLogLevelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetAllResourceLogLevelsResponse] =
        visitor.resetAllResourceLogLevels(request)
    }

    final case class ResetResourceLogLevelOp(
      request: ResetResourceLogLevelRequest
    ) extends IotWirelessOp[ResetResourceLogLevelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetResourceLogLevelResponse] =
        visitor.resetResourceLogLevel(request)
    }

    final case class SendDataToWirelessDeviceOp(
      request: SendDataToWirelessDeviceRequest
    ) extends IotWirelessOp[SendDataToWirelessDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendDataToWirelessDeviceResponse] =
        visitor.sendDataToWirelessDevice(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends IotWirelessOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class TestWirelessDeviceOp(
      request: TestWirelessDeviceRequest
    ) extends IotWirelessOp[TestWirelessDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TestWirelessDeviceResponse] =
        visitor.testWirelessDevice(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends IotWirelessOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateDestinationOp(
      request: UpdateDestinationRequest
    ) extends IotWirelessOp[UpdateDestinationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDestinationResponse] =
        visitor.updateDestination(request)
    }

    final case class UpdateLogLevelsByResourceTypesOp(
      request: UpdateLogLevelsByResourceTypesRequest
    ) extends IotWirelessOp[UpdateLogLevelsByResourceTypesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateLogLevelsByResourceTypesResponse] =
        visitor.updateLogLevelsByResourceTypes(request)
    }

    final case class UpdatePartnerAccountOp(
      request: UpdatePartnerAccountRequest
    ) extends IotWirelessOp[UpdatePartnerAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePartnerAccountResponse] =
        visitor.updatePartnerAccount(request)
    }

    final case class UpdateWirelessDeviceOp(
      request: UpdateWirelessDeviceRequest
    ) extends IotWirelessOp[UpdateWirelessDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWirelessDeviceResponse] =
        visitor.updateWirelessDevice(request)
    }

    final case class UpdateWirelessGatewayOp(
      request: UpdateWirelessGatewayRequest
    ) extends IotWirelessOp[UpdateWirelessGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateWirelessGatewayResponse] =
        visitor.updateWirelessGateway(request)
    }
  }

  import IotWirelessOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[IotWirelessOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateAwsAccountWithPartnerAccount(
    request: AssociateAwsAccountWithPartnerAccountRequest
  ): IotWirelessIO[AssociateAwsAccountWithPartnerAccountResponse] =
    FF.liftF(AssociateAwsAccountWithPartnerAccountOp(request))

  def associateWirelessDeviceWithThing(
    request: AssociateWirelessDeviceWithThingRequest
  ): IotWirelessIO[AssociateWirelessDeviceWithThingResponse] =
    FF.liftF(AssociateWirelessDeviceWithThingOp(request))

  def associateWirelessGatewayWithCertificate(
    request: AssociateWirelessGatewayWithCertificateRequest
  ): IotWirelessIO[AssociateWirelessGatewayWithCertificateResponse] =
    FF.liftF(AssociateWirelessGatewayWithCertificateOp(request))

  def associateWirelessGatewayWithThing(
    request: AssociateWirelessGatewayWithThingRequest
  ): IotWirelessIO[AssociateWirelessGatewayWithThingResponse] =
    FF.liftF(AssociateWirelessGatewayWithThingOp(request))

  def createDestination(
    request: CreateDestinationRequest
  ): IotWirelessIO[CreateDestinationResponse] =
    FF.liftF(CreateDestinationOp(request))

  def createDeviceProfile(
    request: CreateDeviceProfileRequest
  ): IotWirelessIO[CreateDeviceProfileResponse] =
    FF.liftF(CreateDeviceProfileOp(request))

  def createServiceProfile(
    request: CreateServiceProfileRequest
  ): IotWirelessIO[CreateServiceProfileResponse] =
    FF.liftF(CreateServiceProfileOp(request))

  def createWirelessDevice(
    request: CreateWirelessDeviceRequest
  ): IotWirelessIO[CreateWirelessDeviceResponse] =
    FF.liftF(CreateWirelessDeviceOp(request))

  def createWirelessGateway(
    request: CreateWirelessGatewayRequest
  ): IotWirelessIO[CreateWirelessGatewayResponse] =
    FF.liftF(CreateWirelessGatewayOp(request))

  def createWirelessGatewayTask(
    request: CreateWirelessGatewayTaskRequest
  ): IotWirelessIO[CreateWirelessGatewayTaskResponse] =
    FF.liftF(CreateWirelessGatewayTaskOp(request))

  def createWirelessGatewayTaskDefinition(
    request: CreateWirelessGatewayTaskDefinitionRequest
  ): IotWirelessIO[CreateWirelessGatewayTaskDefinitionResponse] =
    FF.liftF(CreateWirelessGatewayTaskDefinitionOp(request))

  def deleteDestination(
    request: DeleteDestinationRequest
  ): IotWirelessIO[DeleteDestinationResponse] =
    FF.liftF(DeleteDestinationOp(request))

  def deleteDeviceProfile(
    request: DeleteDeviceProfileRequest
  ): IotWirelessIO[DeleteDeviceProfileResponse] =
    FF.liftF(DeleteDeviceProfileOp(request))

  def deleteServiceProfile(
    request: DeleteServiceProfileRequest
  ): IotWirelessIO[DeleteServiceProfileResponse] =
    FF.liftF(DeleteServiceProfileOp(request))

  def deleteWirelessDevice(
    request: DeleteWirelessDeviceRequest
  ): IotWirelessIO[DeleteWirelessDeviceResponse] =
    FF.liftF(DeleteWirelessDeviceOp(request))

  def deleteWirelessGateway(
    request: DeleteWirelessGatewayRequest
  ): IotWirelessIO[DeleteWirelessGatewayResponse] =
    FF.liftF(DeleteWirelessGatewayOp(request))

  def deleteWirelessGatewayTask(
    request: DeleteWirelessGatewayTaskRequest
  ): IotWirelessIO[DeleteWirelessGatewayTaskResponse] =
    FF.liftF(DeleteWirelessGatewayTaskOp(request))

  def deleteWirelessGatewayTaskDefinition(
    request: DeleteWirelessGatewayTaskDefinitionRequest
  ): IotWirelessIO[DeleteWirelessGatewayTaskDefinitionResponse] =
    FF.liftF(DeleteWirelessGatewayTaskDefinitionOp(request))

  def disassociateAwsAccountFromPartnerAccount(
    request: DisassociateAwsAccountFromPartnerAccountRequest
  ): IotWirelessIO[DisassociateAwsAccountFromPartnerAccountResponse] =
    FF.liftF(DisassociateAwsAccountFromPartnerAccountOp(request))

  def disassociateWirelessDeviceFromThing(
    request: DisassociateWirelessDeviceFromThingRequest
  ): IotWirelessIO[DisassociateWirelessDeviceFromThingResponse] =
    FF.liftF(DisassociateWirelessDeviceFromThingOp(request))

  def disassociateWirelessGatewayFromCertificate(
    request: DisassociateWirelessGatewayFromCertificateRequest
  ): IotWirelessIO[DisassociateWirelessGatewayFromCertificateResponse] =
    FF.liftF(DisassociateWirelessGatewayFromCertificateOp(request))

  def disassociateWirelessGatewayFromThing(
    request: DisassociateWirelessGatewayFromThingRequest
  ): IotWirelessIO[DisassociateWirelessGatewayFromThingResponse] =
    FF.liftF(DisassociateWirelessGatewayFromThingOp(request))

  def getDestination(
    request: GetDestinationRequest
  ): IotWirelessIO[GetDestinationResponse] =
    FF.liftF(GetDestinationOp(request))

  def getDeviceProfile(
    request: GetDeviceProfileRequest
  ): IotWirelessIO[GetDeviceProfileResponse] =
    FF.liftF(GetDeviceProfileOp(request))

  def getLogLevelsByResourceTypes(
    request: GetLogLevelsByResourceTypesRequest
  ): IotWirelessIO[GetLogLevelsByResourceTypesResponse] =
    FF.liftF(GetLogLevelsByResourceTypesOp(request))

  def getPartnerAccount(
    request: GetPartnerAccountRequest
  ): IotWirelessIO[GetPartnerAccountResponse] =
    FF.liftF(GetPartnerAccountOp(request))

  def getResourceLogLevel(
    request: GetResourceLogLevelRequest
  ): IotWirelessIO[GetResourceLogLevelResponse] =
    FF.liftF(GetResourceLogLevelOp(request))

  def getServiceEndpoint(
    request: GetServiceEndpointRequest
  ): IotWirelessIO[GetServiceEndpointResponse] =
    FF.liftF(GetServiceEndpointOp(request))

  def getServiceProfile(
    request: GetServiceProfileRequest
  ): IotWirelessIO[GetServiceProfileResponse] =
    FF.liftF(GetServiceProfileOp(request))

  def getWirelessDevice(
    request: GetWirelessDeviceRequest
  ): IotWirelessIO[GetWirelessDeviceResponse] =
    FF.liftF(GetWirelessDeviceOp(request))

  def getWirelessDeviceStatistics(
    request: GetWirelessDeviceStatisticsRequest
  ): IotWirelessIO[GetWirelessDeviceStatisticsResponse] =
    FF.liftF(GetWirelessDeviceStatisticsOp(request))

  def getWirelessGateway(
    request: GetWirelessGatewayRequest
  ): IotWirelessIO[GetWirelessGatewayResponse] =
    FF.liftF(GetWirelessGatewayOp(request))

  def getWirelessGatewayCertificate(
    request: GetWirelessGatewayCertificateRequest
  ): IotWirelessIO[GetWirelessGatewayCertificateResponse] =
    FF.liftF(GetWirelessGatewayCertificateOp(request))

  def getWirelessGatewayFirmwareInformation(
    request: GetWirelessGatewayFirmwareInformationRequest
  ): IotWirelessIO[GetWirelessGatewayFirmwareInformationResponse] =
    FF.liftF(GetWirelessGatewayFirmwareInformationOp(request))

  def getWirelessGatewayStatistics(
    request: GetWirelessGatewayStatisticsRequest
  ): IotWirelessIO[GetWirelessGatewayStatisticsResponse] =
    FF.liftF(GetWirelessGatewayStatisticsOp(request))

  def getWirelessGatewayTask(
    request: GetWirelessGatewayTaskRequest
  ): IotWirelessIO[GetWirelessGatewayTaskResponse] =
    FF.liftF(GetWirelessGatewayTaskOp(request))

  def getWirelessGatewayTaskDefinition(
    request: GetWirelessGatewayTaskDefinitionRequest
  ): IotWirelessIO[GetWirelessGatewayTaskDefinitionResponse] =
    FF.liftF(GetWirelessGatewayTaskDefinitionOp(request))

  def listDestinations(
    request: ListDestinationsRequest
  ): IotWirelessIO[ListDestinationsResponse] =
    FF.liftF(ListDestinationsOp(request))

  def listDeviceProfiles(
    request: ListDeviceProfilesRequest
  ): IotWirelessIO[ListDeviceProfilesResponse] =
    FF.liftF(ListDeviceProfilesOp(request))

  def listPartnerAccounts(
    request: ListPartnerAccountsRequest
  ): IotWirelessIO[ListPartnerAccountsResponse] =
    FF.liftF(ListPartnerAccountsOp(request))

  def listServiceProfiles(
    request: ListServiceProfilesRequest
  ): IotWirelessIO[ListServiceProfilesResponse] =
    FF.liftF(ListServiceProfilesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): IotWirelessIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listWirelessDevices(
    request: ListWirelessDevicesRequest
  ): IotWirelessIO[ListWirelessDevicesResponse] =
    FF.liftF(ListWirelessDevicesOp(request))

  def listWirelessGatewayTaskDefinitions(
    request: ListWirelessGatewayTaskDefinitionsRequest
  ): IotWirelessIO[ListWirelessGatewayTaskDefinitionsResponse] =
    FF.liftF(ListWirelessGatewayTaskDefinitionsOp(request))

  def listWirelessGateways(
    request: ListWirelessGatewaysRequest
  ): IotWirelessIO[ListWirelessGatewaysResponse] =
    FF.liftF(ListWirelessGatewaysOp(request))

  def putResourceLogLevel(
    request: PutResourceLogLevelRequest
  ): IotWirelessIO[PutResourceLogLevelResponse] =
    FF.liftF(PutResourceLogLevelOp(request))

  def resetAllResourceLogLevels(
    request: ResetAllResourceLogLevelsRequest
  ): IotWirelessIO[ResetAllResourceLogLevelsResponse] =
    FF.liftF(ResetAllResourceLogLevelsOp(request))

  def resetResourceLogLevel(
    request: ResetResourceLogLevelRequest
  ): IotWirelessIO[ResetResourceLogLevelResponse] =
    FF.liftF(ResetResourceLogLevelOp(request))

  def sendDataToWirelessDevice(
    request: SendDataToWirelessDeviceRequest
  ): IotWirelessIO[SendDataToWirelessDeviceResponse] =
    FF.liftF(SendDataToWirelessDeviceOp(request))

  def tagResource(
    request: TagResourceRequest
  ): IotWirelessIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def testWirelessDevice(
    request: TestWirelessDeviceRequest
  ): IotWirelessIO[TestWirelessDeviceResponse] =
    FF.liftF(TestWirelessDeviceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): IotWirelessIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateDestination(
    request: UpdateDestinationRequest
  ): IotWirelessIO[UpdateDestinationResponse] =
    FF.liftF(UpdateDestinationOp(request))

  def updateLogLevelsByResourceTypes(
    request: UpdateLogLevelsByResourceTypesRequest
  ): IotWirelessIO[UpdateLogLevelsByResourceTypesResponse] =
    FF.liftF(UpdateLogLevelsByResourceTypesOp(request))

  def updatePartnerAccount(
    request: UpdatePartnerAccountRequest
  ): IotWirelessIO[UpdatePartnerAccountResponse] =
    FF.liftF(UpdatePartnerAccountOp(request))

  def updateWirelessDevice(
    request: UpdateWirelessDeviceRequest
  ): IotWirelessIO[UpdateWirelessDeviceResponse] =
    FF.liftF(UpdateWirelessDeviceOp(request))

  def updateWirelessGateway(
    request: UpdateWirelessGatewayRequest
  ): IotWirelessIO[UpdateWirelessGatewayResponse] =
    FF.liftF(UpdateWirelessGatewayOp(request))
}
