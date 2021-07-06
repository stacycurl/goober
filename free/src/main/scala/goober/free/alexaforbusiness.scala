package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.alexaforbusiness.AlexaForBusinessClient
import software.amazon.awssdk.services.alexaforbusiness.model._


object alexaforbusiness { module =>

  // Free monad over AlexaForBusinessOp
  type AlexaForBusinessIO[A] = FF[AlexaForBusinessOp, A]

  sealed trait AlexaForBusinessOp[A] {
    def visit[F[_]](visitor: AlexaForBusinessOp.Visitor[F]): F[A]
  }

  object AlexaForBusinessOp {
    // Given a AlexaForBusinessClient we can embed a AlexaForBusinessIO program in any algebra that understands embedding.
    implicit val AlexaForBusinessOpEmbeddable: Embeddable[AlexaForBusinessOp, AlexaForBusinessClient] = new Embeddable[AlexaForBusinessOp, AlexaForBusinessClient] {
      def embed[A](client: AlexaForBusinessClient, io: AlexaForBusinessIO[A]): Embedded[A] = Embedded.AlexaForBusiness(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends AlexaForBusinessOp.Visitor[Kleisli[M, AlexaForBusinessClient, *]] {
        def approveSkill(
          request: ApproveSkillRequest
        ): Kleisli[M, AlexaForBusinessClient, ApproveSkillResponse] =
          primitive(_.approveSkill(request))

        def associateContactWithAddressBook(
          request: AssociateContactWithAddressBookRequest
        ): Kleisli[M, AlexaForBusinessClient, AssociateContactWithAddressBookResponse] =
          primitive(_.associateContactWithAddressBook(request))

        def associateDeviceWithNetworkProfile(
          request: AssociateDeviceWithNetworkProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, AssociateDeviceWithNetworkProfileResponse] =
          primitive(_.associateDeviceWithNetworkProfile(request))

        def associateDeviceWithRoom(
          request: AssociateDeviceWithRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, AssociateDeviceWithRoomResponse] =
          primitive(_.associateDeviceWithRoom(request))

        def associateSkillGroupWithRoom(
          request: AssociateSkillGroupWithRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, AssociateSkillGroupWithRoomResponse] =
          primitive(_.associateSkillGroupWithRoom(request))

        def associateSkillWithSkillGroup(
          request: AssociateSkillWithSkillGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, AssociateSkillWithSkillGroupResponse] =
          primitive(_.associateSkillWithSkillGroup(request))

        def associateSkillWithUsers(
          request: AssociateSkillWithUsersRequest
        ): Kleisli[M, AlexaForBusinessClient, AssociateSkillWithUsersResponse] =
          primitive(_.associateSkillWithUsers(request))

        def createAddressBook(
          request: CreateAddressBookRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateAddressBookResponse] =
          primitive(_.createAddressBook(request))

        def createBusinessReportSchedule(
          request: CreateBusinessReportScheduleRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateBusinessReportScheduleResponse] =
          primitive(_.createBusinessReportSchedule(request))

        def createConferenceProvider(
          request: CreateConferenceProviderRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateConferenceProviderResponse] =
          primitive(_.createConferenceProvider(request))

        def createContact(
          request: CreateContactRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateContactResponse] =
          primitive(_.createContact(request))

        def createGatewayGroup(
          request: CreateGatewayGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateGatewayGroupResponse] =
          primitive(_.createGatewayGroup(request))

        def createNetworkProfile(
          request: CreateNetworkProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateNetworkProfileResponse] =
          primitive(_.createNetworkProfile(request))

        def createProfile(
          request: CreateProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateProfileResponse] =
          primitive(_.createProfile(request))

        def createRoom(
          request: CreateRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateRoomResponse] =
          primitive(_.createRoom(request))

        def createSkillGroup(
          request: CreateSkillGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateSkillGroupResponse] =
          primitive(_.createSkillGroup(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, AlexaForBusinessClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def deleteAddressBook(
          request: DeleteAddressBookRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteAddressBookResponse] =
          primitive(_.deleteAddressBook(request))

        def deleteBusinessReportSchedule(
          request: DeleteBusinessReportScheduleRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteBusinessReportScheduleResponse] =
          primitive(_.deleteBusinessReportSchedule(request))

        def deleteConferenceProvider(
          request: DeleteConferenceProviderRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteConferenceProviderResponse] =
          primitive(_.deleteConferenceProvider(request))

        def deleteContact(
          request: DeleteContactRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteContactResponse] =
          primitive(_.deleteContact(request))

        def deleteDevice(
          request: DeleteDeviceRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteDeviceResponse] =
          primitive(_.deleteDevice(request))

        def deleteDeviceUsageData(
          request: DeleteDeviceUsageDataRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteDeviceUsageDataResponse] =
          primitive(_.deleteDeviceUsageData(request))

        def deleteGatewayGroup(
          request: DeleteGatewayGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteGatewayGroupResponse] =
          primitive(_.deleteGatewayGroup(request))

        def deleteNetworkProfile(
          request: DeleteNetworkProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteNetworkProfileResponse] =
          primitive(_.deleteNetworkProfile(request))

        def deleteProfile(
          request: DeleteProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteProfileResponse] =
          primitive(_.deleteProfile(request))

        def deleteRoom(
          request: DeleteRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteRoomResponse] =
          primitive(_.deleteRoom(request))

        def deleteRoomSkillParameter(
          request: DeleteRoomSkillParameterRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteRoomSkillParameterResponse] =
          primitive(_.deleteRoomSkillParameter(request))

        def deleteSkillAuthorization(
          request: DeleteSkillAuthorizationRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteSkillAuthorizationResponse] =
          primitive(_.deleteSkillAuthorization(request))

        def deleteSkillGroup(
          request: DeleteSkillGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteSkillGroupResponse] =
          primitive(_.deleteSkillGroup(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, AlexaForBusinessClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def disassociateContactFromAddressBook(
          request: DisassociateContactFromAddressBookRequest
        ): Kleisli[M, AlexaForBusinessClient, DisassociateContactFromAddressBookResponse] =
          primitive(_.disassociateContactFromAddressBook(request))

        def disassociateDeviceFromRoom(
          request: DisassociateDeviceFromRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, DisassociateDeviceFromRoomResponse] =
          primitive(_.disassociateDeviceFromRoom(request))

        def disassociateSkillFromSkillGroup(
          request: DisassociateSkillFromSkillGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, DisassociateSkillFromSkillGroupResponse] =
          primitive(_.disassociateSkillFromSkillGroup(request))

        def disassociateSkillFromUsers(
          request: DisassociateSkillFromUsersRequest
        ): Kleisli[M, AlexaForBusinessClient, DisassociateSkillFromUsersResponse] =
          primitive(_.disassociateSkillFromUsers(request))

        def disassociateSkillGroupFromRoom(
          request: DisassociateSkillGroupFromRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, DisassociateSkillGroupFromRoomResponse] =
          primitive(_.disassociateSkillGroupFromRoom(request))

        def forgetSmartHomeAppliances(
          request: ForgetSmartHomeAppliancesRequest
        ): Kleisli[M, AlexaForBusinessClient, ForgetSmartHomeAppliancesResponse] =
          primitive(_.forgetSmartHomeAppliances(request))

        def getAddressBook(
          request: GetAddressBookRequest
        ): Kleisli[M, AlexaForBusinessClient, GetAddressBookResponse] =
          primitive(_.getAddressBook(request))

        def getConferencePreference(
          request: GetConferencePreferenceRequest
        ): Kleisli[M, AlexaForBusinessClient, GetConferencePreferenceResponse] =
          primitive(_.getConferencePreference(request))

        def getConferenceProvider(
          request: GetConferenceProviderRequest
        ): Kleisli[M, AlexaForBusinessClient, GetConferenceProviderResponse] =
          primitive(_.getConferenceProvider(request))

        def getContact(
          request: GetContactRequest
        ): Kleisli[M, AlexaForBusinessClient, GetContactResponse] =
          primitive(_.getContact(request))

        def getDevice(
          request: GetDeviceRequest
        ): Kleisli[M, AlexaForBusinessClient, GetDeviceResponse] =
          primitive(_.getDevice(request))

        def getGateway(
          request: GetGatewayRequest
        ): Kleisli[M, AlexaForBusinessClient, GetGatewayResponse] =
          primitive(_.getGateway(request))

        def getGatewayGroup(
          request: GetGatewayGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, GetGatewayGroupResponse] =
          primitive(_.getGatewayGroup(request))

        def getInvitationConfiguration(
          request: GetInvitationConfigurationRequest
        ): Kleisli[M, AlexaForBusinessClient, GetInvitationConfigurationResponse] =
          primitive(_.getInvitationConfiguration(request))

        def getNetworkProfile(
          request: GetNetworkProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, GetNetworkProfileResponse] =
          primitive(_.getNetworkProfile(request))

        def getProfile(
          request: GetProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, GetProfileResponse] =
          primitive(_.getProfile(request))

        def getRoom(
          request: GetRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, GetRoomResponse] =
          primitive(_.getRoom(request))

        def getRoomSkillParameter(
          request: GetRoomSkillParameterRequest
        ): Kleisli[M, AlexaForBusinessClient, GetRoomSkillParameterResponse] =
          primitive(_.getRoomSkillParameter(request))

        def getSkillGroup(
          request: GetSkillGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, GetSkillGroupResponse] =
          primitive(_.getSkillGroup(request))

        def listBusinessReportSchedules(
          request: ListBusinessReportSchedulesRequest
        ): Kleisli[M, AlexaForBusinessClient, ListBusinessReportSchedulesResponse] =
          primitive(_.listBusinessReportSchedules(request))

        def listConferenceProviders(
          request: ListConferenceProvidersRequest
        ): Kleisli[M, AlexaForBusinessClient, ListConferenceProvidersResponse] =
          primitive(_.listConferenceProviders(request))

        def listDeviceEvents(
          request: ListDeviceEventsRequest
        ): Kleisli[M, AlexaForBusinessClient, ListDeviceEventsResponse] =
          primitive(_.listDeviceEvents(request))

        def listGatewayGroups(
          request: ListGatewayGroupsRequest
        ): Kleisli[M, AlexaForBusinessClient, ListGatewayGroupsResponse] =
          primitive(_.listGatewayGroups(request))

        def listGateways(
          request: ListGatewaysRequest
        ): Kleisli[M, AlexaForBusinessClient, ListGatewaysResponse] =
          primitive(_.listGateways(request))

        def listSkills(
          request: ListSkillsRequest
        ): Kleisli[M, AlexaForBusinessClient, ListSkillsResponse] =
          primitive(_.listSkills(request))

        def listSkillsStoreCategories(
          request: ListSkillsStoreCategoriesRequest
        ): Kleisli[M, AlexaForBusinessClient, ListSkillsStoreCategoriesResponse] =
          primitive(_.listSkillsStoreCategories(request))

        def listSkillsStoreSkillsByCategory(
          request: ListSkillsStoreSkillsByCategoryRequest
        ): Kleisli[M, AlexaForBusinessClient, ListSkillsStoreSkillsByCategoryResponse] =
          primitive(_.listSkillsStoreSkillsByCategory(request))

        def listSmartHomeAppliances(
          request: ListSmartHomeAppliancesRequest
        ): Kleisli[M, AlexaForBusinessClient, ListSmartHomeAppliancesResponse] =
          primitive(_.listSmartHomeAppliances(request))

        def listTags(
          request: ListTagsRequest
        ): Kleisli[M, AlexaForBusinessClient, ListTagsResponse] =
          primitive(_.listTags(request))

        def putConferencePreference(
          request: PutConferencePreferenceRequest
        ): Kleisli[M, AlexaForBusinessClient, PutConferencePreferenceResponse] =
          primitive(_.putConferencePreference(request))

        def putInvitationConfiguration(
          request: PutInvitationConfigurationRequest
        ): Kleisli[M, AlexaForBusinessClient, PutInvitationConfigurationResponse] =
          primitive(_.putInvitationConfiguration(request))

        def putRoomSkillParameter(
          request: PutRoomSkillParameterRequest
        ): Kleisli[M, AlexaForBusinessClient, PutRoomSkillParameterResponse] =
          primitive(_.putRoomSkillParameter(request))

        def putSkillAuthorization(
          request: PutSkillAuthorizationRequest
        ): Kleisli[M, AlexaForBusinessClient, PutSkillAuthorizationResponse] =
          primitive(_.putSkillAuthorization(request))

        def registerAVSDevice(
          request: RegisterAvsDeviceRequest
        ): Kleisli[M, AlexaForBusinessClient, RegisterAvsDeviceResponse] =
          primitive(_.registerAVSDevice(request))

        def rejectSkill(
          request: RejectSkillRequest
        ): Kleisli[M, AlexaForBusinessClient, RejectSkillResponse] =
          primitive(_.rejectSkill(request))

        def resolveRoom(
          request: ResolveRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, ResolveRoomResponse] =
          primitive(_.resolveRoom(request))

        def revokeInvitation(
          request: RevokeInvitationRequest
        ): Kleisli[M, AlexaForBusinessClient, RevokeInvitationResponse] =
          primitive(_.revokeInvitation(request))

        def searchAddressBooks(
          request: SearchAddressBooksRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchAddressBooksResponse] =
          primitive(_.searchAddressBooks(request))

        def searchContacts(
          request: SearchContactsRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchContactsResponse] =
          primitive(_.searchContacts(request))

        def searchDevices(
          request: SearchDevicesRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchDevicesResponse] =
          primitive(_.searchDevices(request))

        def searchNetworkProfiles(
          request: SearchNetworkProfilesRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchNetworkProfilesResponse] =
          primitive(_.searchNetworkProfiles(request))

        def searchProfiles(
          request: SearchProfilesRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchProfilesResponse] =
          primitive(_.searchProfiles(request))

        def searchRooms(
          request: SearchRoomsRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchRoomsResponse] =
          primitive(_.searchRooms(request))

        def searchSkillGroups(
          request: SearchSkillGroupsRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchSkillGroupsResponse] =
          primitive(_.searchSkillGroups(request))

        def searchUsers(
          request: SearchUsersRequest
        ): Kleisli[M, AlexaForBusinessClient, SearchUsersResponse] =
          primitive(_.searchUsers(request))

        def sendAnnouncement(
          request: SendAnnouncementRequest
        ): Kleisli[M, AlexaForBusinessClient, SendAnnouncementResponse] =
          primitive(_.sendAnnouncement(request))

        def sendInvitation(
          request: SendInvitationRequest
        ): Kleisli[M, AlexaForBusinessClient, SendInvitationResponse] =
          primitive(_.sendInvitation(request))

        def startDeviceSync(
          request: StartDeviceSyncRequest
        ): Kleisli[M, AlexaForBusinessClient, StartDeviceSyncResponse] =
          primitive(_.startDeviceSync(request))

        def startSmartHomeApplianceDiscovery(
          request: StartSmartHomeApplianceDiscoveryRequest
        ): Kleisli[M, AlexaForBusinessClient, StartSmartHomeApplianceDiscoveryResponse] =
          primitive(_.startSmartHomeApplianceDiscovery(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, AlexaForBusinessClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, AlexaForBusinessClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAddressBook(
          request: UpdateAddressBookRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateAddressBookResponse] =
          primitive(_.updateAddressBook(request))

        def updateBusinessReportSchedule(
          request: UpdateBusinessReportScheduleRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateBusinessReportScheduleResponse] =
          primitive(_.updateBusinessReportSchedule(request))

        def updateConferenceProvider(
          request: UpdateConferenceProviderRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateConferenceProviderResponse] =
          primitive(_.updateConferenceProvider(request))

        def updateContact(
          request: UpdateContactRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateContactResponse] =
          primitive(_.updateContact(request))

        def updateDevice(
          request: UpdateDeviceRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateDeviceResponse] =
          primitive(_.updateDevice(request))

        def updateGateway(
          request: UpdateGatewayRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateGatewayResponse] =
          primitive(_.updateGateway(request))

        def updateGatewayGroup(
          request: UpdateGatewayGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateGatewayGroupResponse] =
          primitive(_.updateGatewayGroup(request))

        def updateNetworkProfile(
          request: UpdateNetworkProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateNetworkProfileResponse] =
          primitive(_.updateNetworkProfile(request))

        def updateProfile(
          request: UpdateProfileRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateProfileResponse] =
          primitive(_.updateProfile(request))

        def updateRoom(
          request: UpdateRoomRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateRoomResponse] =
          primitive(_.updateRoom(request))

        def updateSkillGroup(
          request: UpdateSkillGroupRequest
        ): Kleisli[M, AlexaForBusinessClient, UpdateSkillGroupResponse] =
          primitive(_.updateSkillGroup(request))

        def primitive[A](
          f: AlexaForBusinessClient => A
        ): Kleisli[M, AlexaForBusinessClient, A]
      }
    }

    trait Visitor[F[_]] extends (AlexaForBusinessOp ~> F) {
      final def apply[A](op: AlexaForBusinessOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def approveSkill(
        request: ApproveSkillRequest
      ): F[ApproveSkillResponse]

      def associateContactWithAddressBook(
        request: AssociateContactWithAddressBookRequest
      ): F[AssociateContactWithAddressBookResponse]

      def associateDeviceWithNetworkProfile(
        request: AssociateDeviceWithNetworkProfileRequest
      ): F[AssociateDeviceWithNetworkProfileResponse]

      def associateDeviceWithRoom(
        request: AssociateDeviceWithRoomRequest
      ): F[AssociateDeviceWithRoomResponse]

      def associateSkillGroupWithRoom(
        request: AssociateSkillGroupWithRoomRequest
      ): F[AssociateSkillGroupWithRoomResponse]

      def associateSkillWithSkillGroup(
        request: AssociateSkillWithSkillGroupRequest
      ): F[AssociateSkillWithSkillGroupResponse]

      def associateSkillWithUsers(
        request: AssociateSkillWithUsersRequest
      ): F[AssociateSkillWithUsersResponse]

      def createAddressBook(
        request: CreateAddressBookRequest
      ): F[CreateAddressBookResponse]

      def createBusinessReportSchedule(
        request: CreateBusinessReportScheduleRequest
      ): F[CreateBusinessReportScheduleResponse]

      def createConferenceProvider(
        request: CreateConferenceProviderRequest
      ): F[CreateConferenceProviderResponse]

      def createContact(
        request: CreateContactRequest
      ): F[CreateContactResponse]

      def createGatewayGroup(
        request: CreateGatewayGroupRequest
      ): F[CreateGatewayGroupResponse]

      def createNetworkProfile(
        request: CreateNetworkProfileRequest
      ): F[CreateNetworkProfileResponse]

      def createProfile(
        request: CreateProfileRequest
      ): F[CreateProfileResponse]

      def createRoom(
        request: CreateRoomRequest
      ): F[CreateRoomResponse]

      def createSkillGroup(
        request: CreateSkillGroupRequest
      ): F[CreateSkillGroupResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def deleteAddressBook(
        request: DeleteAddressBookRequest
      ): F[DeleteAddressBookResponse]

      def deleteBusinessReportSchedule(
        request: DeleteBusinessReportScheduleRequest
      ): F[DeleteBusinessReportScheduleResponse]

      def deleteConferenceProvider(
        request: DeleteConferenceProviderRequest
      ): F[DeleteConferenceProviderResponse]

      def deleteContact(
        request: DeleteContactRequest
      ): F[DeleteContactResponse]

      def deleteDevice(
        request: DeleteDeviceRequest
      ): F[DeleteDeviceResponse]

      def deleteDeviceUsageData(
        request: DeleteDeviceUsageDataRequest
      ): F[DeleteDeviceUsageDataResponse]

      def deleteGatewayGroup(
        request: DeleteGatewayGroupRequest
      ): F[DeleteGatewayGroupResponse]

      def deleteNetworkProfile(
        request: DeleteNetworkProfileRequest
      ): F[DeleteNetworkProfileResponse]

      def deleteProfile(
        request: DeleteProfileRequest
      ): F[DeleteProfileResponse]

      def deleteRoom(
        request: DeleteRoomRequest
      ): F[DeleteRoomResponse]

      def deleteRoomSkillParameter(
        request: DeleteRoomSkillParameterRequest
      ): F[DeleteRoomSkillParameterResponse]

      def deleteSkillAuthorization(
        request: DeleteSkillAuthorizationRequest
      ): F[DeleteSkillAuthorizationResponse]

      def deleteSkillGroup(
        request: DeleteSkillGroupRequest
      ): F[DeleteSkillGroupResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def disassociateContactFromAddressBook(
        request: DisassociateContactFromAddressBookRequest
      ): F[DisassociateContactFromAddressBookResponse]

      def disassociateDeviceFromRoom(
        request: DisassociateDeviceFromRoomRequest
      ): F[DisassociateDeviceFromRoomResponse]

      def disassociateSkillFromSkillGroup(
        request: DisassociateSkillFromSkillGroupRequest
      ): F[DisassociateSkillFromSkillGroupResponse]

      def disassociateSkillFromUsers(
        request: DisassociateSkillFromUsersRequest
      ): F[DisassociateSkillFromUsersResponse]

      def disassociateSkillGroupFromRoom(
        request: DisassociateSkillGroupFromRoomRequest
      ): F[DisassociateSkillGroupFromRoomResponse]

      def forgetSmartHomeAppliances(
        request: ForgetSmartHomeAppliancesRequest
      ): F[ForgetSmartHomeAppliancesResponse]

      def getAddressBook(
        request: GetAddressBookRequest
      ): F[GetAddressBookResponse]

      def getConferencePreference(
        request: GetConferencePreferenceRequest
      ): F[GetConferencePreferenceResponse]

      def getConferenceProvider(
        request: GetConferenceProviderRequest
      ): F[GetConferenceProviderResponse]

      def getContact(
        request: GetContactRequest
      ): F[GetContactResponse]

      def getDevice(
        request: GetDeviceRequest
      ): F[GetDeviceResponse]

      def getGateway(
        request: GetGatewayRequest
      ): F[GetGatewayResponse]

      def getGatewayGroup(
        request: GetGatewayGroupRequest
      ): F[GetGatewayGroupResponse]

      def getInvitationConfiguration(
        request: GetInvitationConfigurationRequest
      ): F[GetInvitationConfigurationResponse]

      def getNetworkProfile(
        request: GetNetworkProfileRequest
      ): F[GetNetworkProfileResponse]

      def getProfile(
        request: GetProfileRequest
      ): F[GetProfileResponse]

      def getRoom(
        request: GetRoomRequest
      ): F[GetRoomResponse]

      def getRoomSkillParameter(
        request: GetRoomSkillParameterRequest
      ): F[GetRoomSkillParameterResponse]

      def getSkillGroup(
        request: GetSkillGroupRequest
      ): F[GetSkillGroupResponse]

      def listBusinessReportSchedules(
        request: ListBusinessReportSchedulesRequest
      ): F[ListBusinessReportSchedulesResponse]

      def listConferenceProviders(
        request: ListConferenceProvidersRequest
      ): F[ListConferenceProvidersResponse]

      def listDeviceEvents(
        request: ListDeviceEventsRequest
      ): F[ListDeviceEventsResponse]

      def listGatewayGroups(
        request: ListGatewayGroupsRequest
      ): F[ListGatewayGroupsResponse]

      def listGateways(
        request: ListGatewaysRequest
      ): F[ListGatewaysResponse]

      def listSkills(
        request: ListSkillsRequest
      ): F[ListSkillsResponse]

      def listSkillsStoreCategories(
        request: ListSkillsStoreCategoriesRequest
      ): F[ListSkillsStoreCategoriesResponse]

      def listSkillsStoreSkillsByCategory(
        request: ListSkillsStoreSkillsByCategoryRequest
      ): F[ListSkillsStoreSkillsByCategoryResponse]

      def listSmartHomeAppliances(
        request: ListSmartHomeAppliancesRequest
      ): F[ListSmartHomeAppliancesResponse]

      def listTags(
        request: ListTagsRequest
      ): F[ListTagsResponse]

      def putConferencePreference(
        request: PutConferencePreferenceRequest
      ): F[PutConferencePreferenceResponse]

      def putInvitationConfiguration(
        request: PutInvitationConfigurationRequest
      ): F[PutInvitationConfigurationResponse]

      def putRoomSkillParameter(
        request: PutRoomSkillParameterRequest
      ): F[PutRoomSkillParameterResponse]

      def putSkillAuthorization(
        request: PutSkillAuthorizationRequest
      ): F[PutSkillAuthorizationResponse]

      def registerAVSDevice(
        request: RegisterAvsDeviceRequest
      ): F[RegisterAvsDeviceResponse]

      def rejectSkill(
        request: RejectSkillRequest
      ): F[RejectSkillResponse]

      def resolveRoom(
        request: ResolveRoomRequest
      ): F[ResolveRoomResponse]

      def revokeInvitation(
        request: RevokeInvitationRequest
      ): F[RevokeInvitationResponse]

      def searchAddressBooks(
        request: SearchAddressBooksRequest
      ): F[SearchAddressBooksResponse]

      def searchContacts(
        request: SearchContactsRequest
      ): F[SearchContactsResponse]

      def searchDevices(
        request: SearchDevicesRequest
      ): F[SearchDevicesResponse]

      def searchNetworkProfiles(
        request: SearchNetworkProfilesRequest
      ): F[SearchNetworkProfilesResponse]

      def searchProfiles(
        request: SearchProfilesRequest
      ): F[SearchProfilesResponse]

      def searchRooms(
        request: SearchRoomsRequest
      ): F[SearchRoomsResponse]

      def searchSkillGroups(
        request: SearchSkillGroupsRequest
      ): F[SearchSkillGroupsResponse]

      def searchUsers(
        request: SearchUsersRequest
      ): F[SearchUsersResponse]

      def sendAnnouncement(
        request: SendAnnouncementRequest
      ): F[SendAnnouncementResponse]

      def sendInvitation(
        request: SendInvitationRequest
      ): F[SendInvitationResponse]

      def startDeviceSync(
        request: StartDeviceSyncRequest
      ): F[StartDeviceSyncResponse]

      def startSmartHomeApplianceDiscovery(
        request: StartSmartHomeApplianceDiscoveryRequest
      ): F[StartSmartHomeApplianceDiscoveryResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAddressBook(
        request: UpdateAddressBookRequest
      ): F[UpdateAddressBookResponse]

      def updateBusinessReportSchedule(
        request: UpdateBusinessReportScheduleRequest
      ): F[UpdateBusinessReportScheduleResponse]

      def updateConferenceProvider(
        request: UpdateConferenceProviderRequest
      ): F[UpdateConferenceProviderResponse]

      def updateContact(
        request: UpdateContactRequest
      ): F[UpdateContactResponse]

      def updateDevice(
        request: UpdateDeviceRequest
      ): F[UpdateDeviceResponse]

      def updateGateway(
        request: UpdateGatewayRequest
      ): F[UpdateGatewayResponse]

      def updateGatewayGroup(
        request: UpdateGatewayGroupRequest
      ): F[UpdateGatewayGroupResponse]

      def updateNetworkProfile(
        request: UpdateNetworkProfileRequest
      ): F[UpdateNetworkProfileResponse]

      def updateProfile(
        request: UpdateProfileRequest
      ): F[UpdateProfileResponse]

      def updateRoom(
        request: UpdateRoomRequest
      ): F[UpdateRoomResponse]

      def updateSkillGroup(
        request: UpdateSkillGroupRequest
      ): F[UpdateSkillGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends AlexaForBusinessOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class ApproveSkillOp(
      request: ApproveSkillRequest
    ) extends AlexaForBusinessOp[ApproveSkillResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ApproveSkillResponse] =
        visitor.approveSkill(request)
    }

    final case class AssociateContactWithAddressBookOp(
      request: AssociateContactWithAddressBookRequest
    ) extends AlexaForBusinessOp[AssociateContactWithAddressBookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateContactWithAddressBookResponse] =
        visitor.associateContactWithAddressBook(request)
    }

    final case class AssociateDeviceWithNetworkProfileOp(
      request: AssociateDeviceWithNetworkProfileRequest
    ) extends AlexaForBusinessOp[AssociateDeviceWithNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDeviceWithNetworkProfileResponse] =
        visitor.associateDeviceWithNetworkProfile(request)
    }

    final case class AssociateDeviceWithRoomOp(
      request: AssociateDeviceWithRoomRequest
    ) extends AlexaForBusinessOp[AssociateDeviceWithRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateDeviceWithRoomResponse] =
        visitor.associateDeviceWithRoom(request)
    }

    final case class AssociateSkillGroupWithRoomOp(
      request: AssociateSkillGroupWithRoomRequest
    ) extends AlexaForBusinessOp[AssociateSkillGroupWithRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSkillGroupWithRoomResponse] =
        visitor.associateSkillGroupWithRoom(request)
    }

    final case class AssociateSkillWithSkillGroupOp(
      request: AssociateSkillWithSkillGroupRequest
    ) extends AlexaForBusinessOp[AssociateSkillWithSkillGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSkillWithSkillGroupResponse] =
        visitor.associateSkillWithSkillGroup(request)
    }

    final case class AssociateSkillWithUsersOp(
      request: AssociateSkillWithUsersRequest
    ) extends AlexaForBusinessOp[AssociateSkillWithUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSkillWithUsersResponse] =
        visitor.associateSkillWithUsers(request)
    }

    final case class CreateAddressBookOp(
      request: CreateAddressBookRequest
    ) extends AlexaForBusinessOp[CreateAddressBookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAddressBookResponse] =
        visitor.createAddressBook(request)
    }

    final case class CreateBusinessReportScheduleOp(
      request: CreateBusinessReportScheduleRequest
    ) extends AlexaForBusinessOp[CreateBusinessReportScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBusinessReportScheduleResponse] =
        visitor.createBusinessReportSchedule(request)
    }

    final case class CreateConferenceProviderOp(
      request: CreateConferenceProviderRequest
    ) extends AlexaForBusinessOp[CreateConferenceProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateConferenceProviderResponse] =
        visitor.createConferenceProvider(request)
    }

    final case class CreateContactOp(
      request: CreateContactRequest
    ) extends AlexaForBusinessOp[CreateContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactResponse] =
        visitor.createContact(request)
    }

    final case class CreateGatewayGroupOp(
      request: CreateGatewayGroupRequest
    ) extends AlexaForBusinessOp[CreateGatewayGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGatewayGroupResponse] =
        visitor.createGatewayGroup(request)
    }

    final case class CreateNetworkProfileOp(
      request: CreateNetworkProfileRequest
    ) extends AlexaForBusinessOp[CreateNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateNetworkProfileResponse] =
        visitor.createNetworkProfile(request)
    }

    final case class CreateProfileOp(
      request: CreateProfileRequest
    ) extends AlexaForBusinessOp[CreateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProfileResponse] =
        visitor.createProfile(request)
    }

    final case class CreateRoomOp(
      request: CreateRoomRequest
    ) extends AlexaForBusinessOp[CreateRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRoomResponse] =
        visitor.createRoom(request)
    }

    final case class CreateSkillGroupOp(
      request: CreateSkillGroupRequest
    ) extends AlexaForBusinessOp[CreateSkillGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSkillGroupResponse] =
        visitor.createSkillGroup(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends AlexaForBusinessOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class DeleteAddressBookOp(
      request: DeleteAddressBookRequest
    ) extends AlexaForBusinessOp[DeleteAddressBookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAddressBookResponse] =
        visitor.deleteAddressBook(request)
    }

    final case class DeleteBusinessReportScheduleOp(
      request: DeleteBusinessReportScheduleRequest
    ) extends AlexaForBusinessOp[DeleteBusinessReportScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBusinessReportScheduleResponse] =
        visitor.deleteBusinessReportSchedule(request)
    }

    final case class DeleteConferenceProviderOp(
      request: DeleteConferenceProviderRequest
    ) extends AlexaForBusinessOp[DeleteConferenceProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteConferenceProviderResponse] =
        visitor.deleteConferenceProvider(request)
    }

    final case class DeleteContactOp(
      request: DeleteContactRequest
    ) extends AlexaForBusinessOp[DeleteContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteContactResponse] =
        visitor.deleteContact(request)
    }

    final case class DeleteDeviceOp(
      request: DeleteDeviceRequest
    ) extends AlexaForBusinessOp[DeleteDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeviceResponse] =
        visitor.deleteDevice(request)
    }

    final case class DeleteDeviceUsageDataOp(
      request: DeleteDeviceUsageDataRequest
    ) extends AlexaForBusinessOp[DeleteDeviceUsageDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteDeviceUsageDataResponse] =
        visitor.deleteDeviceUsageData(request)
    }

    final case class DeleteGatewayGroupOp(
      request: DeleteGatewayGroupRequest
    ) extends AlexaForBusinessOp[DeleteGatewayGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGatewayGroupResponse] =
        visitor.deleteGatewayGroup(request)
    }

    final case class DeleteNetworkProfileOp(
      request: DeleteNetworkProfileRequest
    ) extends AlexaForBusinessOp[DeleteNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteNetworkProfileResponse] =
        visitor.deleteNetworkProfile(request)
    }

    final case class DeleteProfileOp(
      request: DeleteProfileRequest
    ) extends AlexaForBusinessOp[DeleteProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProfileResponse] =
        visitor.deleteProfile(request)
    }

    final case class DeleteRoomOp(
      request: DeleteRoomRequest
    ) extends AlexaForBusinessOp[DeleteRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRoomResponse] =
        visitor.deleteRoom(request)
    }

    final case class DeleteRoomSkillParameterOp(
      request: DeleteRoomSkillParameterRequest
    ) extends AlexaForBusinessOp[DeleteRoomSkillParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRoomSkillParameterResponse] =
        visitor.deleteRoomSkillParameter(request)
    }

    final case class DeleteSkillAuthorizationOp(
      request: DeleteSkillAuthorizationRequest
    ) extends AlexaForBusinessOp[DeleteSkillAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSkillAuthorizationResponse] =
        visitor.deleteSkillAuthorization(request)
    }

    final case class DeleteSkillGroupOp(
      request: DeleteSkillGroupRequest
    ) extends AlexaForBusinessOp[DeleteSkillGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSkillGroupResponse] =
        visitor.deleteSkillGroup(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends AlexaForBusinessOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DisassociateContactFromAddressBookOp(
      request: DisassociateContactFromAddressBookRequest
    ) extends AlexaForBusinessOp[DisassociateContactFromAddressBookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateContactFromAddressBookResponse] =
        visitor.disassociateContactFromAddressBook(request)
    }

    final case class DisassociateDeviceFromRoomOp(
      request: DisassociateDeviceFromRoomRequest
    ) extends AlexaForBusinessOp[DisassociateDeviceFromRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateDeviceFromRoomResponse] =
        visitor.disassociateDeviceFromRoom(request)
    }

    final case class DisassociateSkillFromSkillGroupOp(
      request: DisassociateSkillFromSkillGroupRequest
    ) extends AlexaForBusinessOp[DisassociateSkillFromSkillGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSkillFromSkillGroupResponse] =
        visitor.disassociateSkillFromSkillGroup(request)
    }

    final case class DisassociateSkillFromUsersOp(
      request: DisassociateSkillFromUsersRequest
    ) extends AlexaForBusinessOp[DisassociateSkillFromUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSkillFromUsersResponse] =
        visitor.disassociateSkillFromUsers(request)
    }

    final case class DisassociateSkillGroupFromRoomOp(
      request: DisassociateSkillGroupFromRoomRequest
    ) extends AlexaForBusinessOp[DisassociateSkillGroupFromRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSkillGroupFromRoomResponse] =
        visitor.disassociateSkillGroupFromRoom(request)
    }

    final case class ForgetSmartHomeAppliancesOp(
      request: ForgetSmartHomeAppliancesRequest
    ) extends AlexaForBusinessOp[ForgetSmartHomeAppliancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ForgetSmartHomeAppliancesResponse] =
        visitor.forgetSmartHomeAppliances(request)
    }

    final case class GetAddressBookOp(
      request: GetAddressBookRequest
    ) extends AlexaForBusinessOp[GetAddressBookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAddressBookResponse] =
        visitor.getAddressBook(request)
    }

    final case class GetConferencePreferenceOp(
      request: GetConferencePreferenceRequest
    ) extends AlexaForBusinessOp[GetConferencePreferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConferencePreferenceResponse] =
        visitor.getConferencePreference(request)
    }

    final case class GetConferenceProviderOp(
      request: GetConferenceProviderRequest
    ) extends AlexaForBusinessOp[GetConferenceProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetConferenceProviderResponse] =
        visitor.getConferenceProvider(request)
    }

    final case class GetContactOp(
      request: GetContactRequest
    ) extends AlexaForBusinessOp[GetContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactResponse] =
        visitor.getContact(request)
    }

    final case class GetDeviceOp(
      request: GetDeviceRequest
    ) extends AlexaForBusinessOp[GetDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetDeviceResponse] =
        visitor.getDevice(request)
    }

    final case class GetGatewayOp(
      request: GetGatewayRequest
    ) extends AlexaForBusinessOp[GetGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGatewayResponse] =
        visitor.getGateway(request)
    }

    final case class GetGatewayGroupOp(
      request: GetGatewayGroupRequest
    ) extends AlexaForBusinessOp[GetGatewayGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGatewayGroupResponse] =
        visitor.getGatewayGroup(request)
    }

    final case class GetInvitationConfigurationOp(
      request: GetInvitationConfigurationRequest
    ) extends AlexaForBusinessOp[GetInvitationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInvitationConfigurationResponse] =
        visitor.getInvitationConfiguration(request)
    }

    final case class GetNetworkProfileOp(
      request: GetNetworkProfileRequest
    ) extends AlexaForBusinessOp[GetNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetNetworkProfileResponse] =
        visitor.getNetworkProfile(request)
    }

    final case class GetProfileOp(
      request: GetProfileRequest
    ) extends AlexaForBusinessOp[GetProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProfileResponse] =
        visitor.getProfile(request)
    }

    final case class GetRoomOp(
      request: GetRoomRequest
    ) extends AlexaForBusinessOp[GetRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRoomResponse] =
        visitor.getRoom(request)
    }

    final case class GetRoomSkillParameterOp(
      request: GetRoomSkillParameterRequest
    ) extends AlexaForBusinessOp[GetRoomSkillParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRoomSkillParameterResponse] =
        visitor.getRoomSkillParameter(request)
    }

    final case class GetSkillGroupOp(
      request: GetSkillGroupRequest
    ) extends AlexaForBusinessOp[GetSkillGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSkillGroupResponse] =
        visitor.getSkillGroup(request)
    }

    final case class ListBusinessReportSchedulesOp(
      request: ListBusinessReportSchedulesRequest
    ) extends AlexaForBusinessOp[ListBusinessReportSchedulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBusinessReportSchedulesResponse] =
        visitor.listBusinessReportSchedules(request)
    }

    final case class ListConferenceProvidersOp(
      request: ListConferenceProvidersRequest
    ) extends AlexaForBusinessOp[ListConferenceProvidersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListConferenceProvidersResponse] =
        visitor.listConferenceProviders(request)
    }

    final case class ListDeviceEventsOp(
      request: ListDeviceEventsRequest
    ) extends AlexaForBusinessOp[ListDeviceEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListDeviceEventsResponse] =
        visitor.listDeviceEvents(request)
    }

    final case class ListGatewayGroupsOp(
      request: ListGatewayGroupsRequest
    ) extends AlexaForBusinessOp[ListGatewayGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGatewayGroupsResponse] =
        visitor.listGatewayGroups(request)
    }

    final case class ListGatewaysOp(
      request: ListGatewaysRequest
    ) extends AlexaForBusinessOp[ListGatewaysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGatewaysResponse] =
        visitor.listGateways(request)
    }

    final case class ListSkillsOp(
      request: ListSkillsRequest
    ) extends AlexaForBusinessOp[ListSkillsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSkillsResponse] =
        visitor.listSkills(request)
    }

    final case class ListSkillsStoreCategoriesOp(
      request: ListSkillsStoreCategoriesRequest
    ) extends AlexaForBusinessOp[ListSkillsStoreCategoriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSkillsStoreCategoriesResponse] =
        visitor.listSkillsStoreCategories(request)
    }

    final case class ListSkillsStoreSkillsByCategoryOp(
      request: ListSkillsStoreSkillsByCategoryRequest
    ) extends AlexaForBusinessOp[ListSkillsStoreSkillsByCategoryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSkillsStoreSkillsByCategoryResponse] =
        visitor.listSkillsStoreSkillsByCategory(request)
    }

    final case class ListSmartHomeAppliancesOp(
      request: ListSmartHomeAppliancesRequest
    ) extends AlexaForBusinessOp[ListSmartHomeAppliancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSmartHomeAppliancesResponse] =
        visitor.listSmartHomeAppliances(request)
    }

    final case class ListTagsOp(
      request: ListTagsRequest
    ) extends AlexaForBusinessOp[ListTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsResponse] =
        visitor.listTags(request)
    }

    final case class PutConferencePreferenceOp(
      request: PutConferencePreferenceRequest
    ) extends AlexaForBusinessOp[PutConferencePreferenceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutConferencePreferenceResponse] =
        visitor.putConferencePreference(request)
    }

    final case class PutInvitationConfigurationOp(
      request: PutInvitationConfigurationRequest
    ) extends AlexaForBusinessOp[PutInvitationConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutInvitationConfigurationResponse] =
        visitor.putInvitationConfiguration(request)
    }

    final case class PutRoomSkillParameterOp(
      request: PutRoomSkillParameterRequest
    ) extends AlexaForBusinessOp[PutRoomSkillParameterResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRoomSkillParameterResponse] =
        visitor.putRoomSkillParameter(request)
    }

    final case class PutSkillAuthorizationOp(
      request: PutSkillAuthorizationRequest
    ) extends AlexaForBusinessOp[PutSkillAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSkillAuthorizationResponse] =
        visitor.putSkillAuthorization(request)
    }

    final case class RegisterAVSDeviceOp(
      request: RegisterAvsDeviceRequest
    ) extends AlexaForBusinessOp[RegisterAvsDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterAvsDeviceResponse] =
        visitor.registerAVSDevice(request)
    }

    final case class RejectSkillOp(
      request: RejectSkillRequest
    ) extends AlexaForBusinessOp[RejectSkillResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RejectSkillResponse] =
        visitor.rejectSkill(request)
    }

    final case class ResolveRoomOp(
      request: ResolveRoomRequest
    ) extends AlexaForBusinessOp[ResolveRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResolveRoomResponse] =
        visitor.resolveRoom(request)
    }

    final case class RevokeInvitationOp(
      request: RevokeInvitationRequest
    ) extends AlexaForBusinessOp[RevokeInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RevokeInvitationResponse] =
        visitor.revokeInvitation(request)
    }

    final case class SearchAddressBooksOp(
      request: SearchAddressBooksRequest
    ) extends AlexaForBusinessOp[SearchAddressBooksResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchAddressBooksResponse] =
        visitor.searchAddressBooks(request)
    }

    final case class SearchContactsOp(
      request: SearchContactsRequest
    ) extends AlexaForBusinessOp[SearchContactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchContactsResponse] =
        visitor.searchContacts(request)
    }

    final case class SearchDevicesOp(
      request: SearchDevicesRequest
    ) extends AlexaForBusinessOp[SearchDevicesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchDevicesResponse] =
        visitor.searchDevices(request)
    }

    final case class SearchNetworkProfilesOp(
      request: SearchNetworkProfilesRequest
    ) extends AlexaForBusinessOp[SearchNetworkProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchNetworkProfilesResponse] =
        visitor.searchNetworkProfiles(request)
    }

    final case class SearchProfilesOp(
      request: SearchProfilesRequest
    ) extends AlexaForBusinessOp[SearchProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchProfilesResponse] =
        visitor.searchProfiles(request)
    }

    final case class SearchRoomsOp(
      request: SearchRoomsRequest
    ) extends AlexaForBusinessOp[SearchRoomsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchRoomsResponse] =
        visitor.searchRooms(request)
    }

    final case class SearchSkillGroupsOp(
      request: SearchSkillGroupsRequest
    ) extends AlexaForBusinessOp[SearchSkillGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchSkillGroupsResponse] =
        visitor.searchSkillGroups(request)
    }

    final case class SearchUsersOp(
      request: SearchUsersRequest
    ) extends AlexaForBusinessOp[SearchUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchUsersResponse] =
        visitor.searchUsers(request)
    }

    final case class SendAnnouncementOp(
      request: SendAnnouncementRequest
    ) extends AlexaForBusinessOp[SendAnnouncementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendAnnouncementResponse] =
        visitor.sendAnnouncement(request)
    }

    final case class SendInvitationOp(
      request: SendInvitationRequest
    ) extends AlexaForBusinessOp[SendInvitationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendInvitationResponse] =
        visitor.sendInvitation(request)
    }

    final case class StartDeviceSyncOp(
      request: StartDeviceSyncRequest
    ) extends AlexaForBusinessOp[StartDeviceSyncResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartDeviceSyncResponse] =
        visitor.startDeviceSync(request)
    }

    final case class StartSmartHomeApplianceDiscoveryOp(
      request: StartSmartHomeApplianceDiscoveryRequest
    ) extends AlexaForBusinessOp[StartSmartHomeApplianceDiscoveryResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartSmartHomeApplianceDiscoveryResponse] =
        visitor.startSmartHomeApplianceDiscovery(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends AlexaForBusinessOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends AlexaForBusinessOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAddressBookOp(
      request: UpdateAddressBookRequest
    ) extends AlexaForBusinessOp[UpdateAddressBookResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAddressBookResponse] =
        visitor.updateAddressBook(request)
    }

    final case class UpdateBusinessReportScheduleOp(
      request: UpdateBusinessReportScheduleRequest
    ) extends AlexaForBusinessOp[UpdateBusinessReportScheduleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBusinessReportScheduleResponse] =
        visitor.updateBusinessReportSchedule(request)
    }

    final case class UpdateConferenceProviderOp(
      request: UpdateConferenceProviderRequest
    ) extends AlexaForBusinessOp[UpdateConferenceProviderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateConferenceProviderResponse] =
        visitor.updateConferenceProvider(request)
    }

    final case class UpdateContactOp(
      request: UpdateContactRequest
    ) extends AlexaForBusinessOp[UpdateContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactResponse] =
        visitor.updateContact(request)
    }

    final case class UpdateDeviceOp(
      request: UpdateDeviceRequest
    ) extends AlexaForBusinessOp[UpdateDeviceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateDeviceResponse] =
        visitor.updateDevice(request)
    }

    final case class UpdateGatewayOp(
      request: UpdateGatewayRequest
    ) extends AlexaForBusinessOp[UpdateGatewayResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayResponse] =
        visitor.updateGateway(request)
    }

    final case class UpdateGatewayGroupOp(
      request: UpdateGatewayGroupRequest
    ) extends AlexaForBusinessOp[UpdateGatewayGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGatewayGroupResponse] =
        visitor.updateGatewayGroup(request)
    }

    final case class UpdateNetworkProfileOp(
      request: UpdateNetworkProfileRequest
    ) extends AlexaForBusinessOp[UpdateNetworkProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateNetworkProfileResponse] =
        visitor.updateNetworkProfile(request)
    }

    final case class UpdateProfileOp(
      request: UpdateProfileRequest
    ) extends AlexaForBusinessOp[UpdateProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProfileResponse] =
        visitor.updateProfile(request)
    }

    final case class UpdateRoomOp(
      request: UpdateRoomRequest
    ) extends AlexaForBusinessOp[UpdateRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoomResponse] =
        visitor.updateRoom(request)
    }

    final case class UpdateSkillGroupOp(
      request: UpdateSkillGroupRequest
    ) extends AlexaForBusinessOp[UpdateSkillGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSkillGroupResponse] =
        visitor.updateSkillGroup(request)
    }
  }

  import AlexaForBusinessOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[AlexaForBusinessOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def approveSkill(
    request: ApproveSkillRequest
  ): AlexaForBusinessIO[ApproveSkillResponse] =
    FF.liftF(ApproveSkillOp(request))

  def associateContactWithAddressBook(
    request: AssociateContactWithAddressBookRequest
  ): AlexaForBusinessIO[AssociateContactWithAddressBookResponse] =
    FF.liftF(AssociateContactWithAddressBookOp(request))

  def associateDeviceWithNetworkProfile(
    request: AssociateDeviceWithNetworkProfileRequest
  ): AlexaForBusinessIO[AssociateDeviceWithNetworkProfileResponse] =
    FF.liftF(AssociateDeviceWithNetworkProfileOp(request))

  def associateDeviceWithRoom(
    request: AssociateDeviceWithRoomRequest
  ): AlexaForBusinessIO[AssociateDeviceWithRoomResponse] =
    FF.liftF(AssociateDeviceWithRoomOp(request))

  def associateSkillGroupWithRoom(
    request: AssociateSkillGroupWithRoomRequest
  ): AlexaForBusinessIO[AssociateSkillGroupWithRoomResponse] =
    FF.liftF(AssociateSkillGroupWithRoomOp(request))

  def associateSkillWithSkillGroup(
    request: AssociateSkillWithSkillGroupRequest
  ): AlexaForBusinessIO[AssociateSkillWithSkillGroupResponse] =
    FF.liftF(AssociateSkillWithSkillGroupOp(request))

  def associateSkillWithUsers(
    request: AssociateSkillWithUsersRequest
  ): AlexaForBusinessIO[AssociateSkillWithUsersResponse] =
    FF.liftF(AssociateSkillWithUsersOp(request))

  def createAddressBook(
    request: CreateAddressBookRequest
  ): AlexaForBusinessIO[CreateAddressBookResponse] =
    FF.liftF(CreateAddressBookOp(request))

  def createBusinessReportSchedule(
    request: CreateBusinessReportScheduleRequest
  ): AlexaForBusinessIO[CreateBusinessReportScheduleResponse] =
    FF.liftF(CreateBusinessReportScheduleOp(request))

  def createConferenceProvider(
    request: CreateConferenceProviderRequest
  ): AlexaForBusinessIO[CreateConferenceProviderResponse] =
    FF.liftF(CreateConferenceProviderOp(request))

  def createContact(
    request: CreateContactRequest
  ): AlexaForBusinessIO[CreateContactResponse] =
    FF.liftF(CreateContactOp(request))

  def createGatewayGroup(
    request: CreateGatewayGroupRequest
  ): AlexaForBusinessIO[CreateGatewayGroupResponse] =
    FF.liftF(CreateGatewayGroupOp(request))

  def createNetworkProfile(
    request: CreateNetworkProfileRequest
  ): AlexaForBusinessIO[CreateNetworkProfileResponse] =
    FF.liftF(CreateNetworkProfileOp(request))

  def createProfile(
    request: CreateProfileRequest
  ): AlexaForBusinessIO[CreateProfileResponse] =
    FF.liftF(CreateProfileOp(request))

  def createRoom(
    request: CreateRoomRequest
  ): AlexaForBusinessIO[CreateRoomResponse] =
    FF.liftF(CreateRoomOp(request))

  def createSkillGroup(
    request: CreateSkillGroupRequest
  ): AlexaForBusinessIO[CreateSkillGroupResponse] =
    FF.liftF(CreateSkillGroupOp(request))

  def createUser(
    request: CreateUserRequest
  ): AlexaForBusinessIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def deleteAddressBook(
    request: DeleteAddressBookRequest
  ): AlexaForBusinessIO[DeleteAddressBookResponse] =
    FF.liftF(DeleteAddressBookOp(request))

  def deleteBusinessReportSchedule(
    request: DeleteBusinessReportScheduleRequest
  ): AlexaForBusinessIO[DeleteBusinessReportScheduleResponse] =
    FF.liftF(DeleteBusinessReportScheduleOp(request))

  def deleteConferenceProvider(
    request: DeleteConferenceProviderRequest
  ): AlexaForBusinessIO[DeleteConferenceProviderResponse] =
    FF.liftF(DeleteConferenceProviderOp(request))

  def deleteContact(
    request: DeleteContactRequest
  ): AlexaForBusinessIO[DeleteContactResponse] =
    FF.liftF(DeleteContactOp(request))

  def deleteDevice(
    request: DeleteDeviceRequest
  ): AlexaForBusinessIO[DeleteDeviceResponse] =
    FF.liftF(DeleteDeviceOp(request))

  def deleteDeviceUsageData(
    request: DeleteDeviceUsageDataRequest
  ): AlexaForBusinessIO[DeleteDeviceUsageDataResponse] =
    FF.liftF(DeleteDeviceUsageDataOp(request))

  def deleteGatewayGroup(
    request: DeleteGatewayGroupRequest
  ): AlexaForBusinessIO[DeleteGatewayGroupResponse] =
    FF.liftF(DeleteGatewayGroupOp(request))

  def deleteNetworkProfile(
    request: DeleteNetworkProfileRequest
  ): AlexaForBusinessIO[DeleteNetworkProfileResponse] =
    FF.liftF(DeleteNetworkProfileOp(request))

  def deleteProfile(
    request: DeleteProfileRequest
  ): AlexaForBusinessIO[DeleteProfileResponse] =
    FF.liftF(DeleteProfileOp(request))

  def deleteRoom(
    request: DeleteRoomRequest
  ): AlexaForBusinessIO[DeleteRoomResponse] =
    FF.liftF(DeleteRoomOp(request))

  def deleteRoomSkillParameter(
    request: DeleteRoomSkillParameterRequest
  ): AlexaForBusinessIO[DeleteRoomSkillParameterResponse] =
    FF.liftF(DeleteRoomSkillParameterOp(request))

  def deleteSkillAuthorization(
    request: DeleteSkillAuthorizationRequest
  ): AlexaForBusinessIO[DeleteSkillAuthorizationResponse] =
    FF.liftF(DeleteSkillAuthorizationOp(request))

  def deleteSkillGroup(
    request: DeleteSkillGroupRequest
  ): AlexaForBusinessIO[DeleteSkillGroupResponse] =
    FF.liftF(DeleteSkillGroupOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): AlexaForBusinessIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def disassociateContactFromAddressBook(
    request: DisassociateContactFromAddressBookRequest
  ): AlexaForBusinessIO[DisassociateContactFromAddressBookResponse] =
    FF.liftF(DisassociateContactFromAddressBookOp(request))

  def disassociateDeviceFromRoom(
    request: DisassociateDeviceFromRoomRequest
  ): AlexaForBusinessIO[DisassociateDeviceFromRoomResponse] =
    FF.liftF(DisassociateDeviceFromRoomOp(request))

  def disassociateSkillFromSkillGroup(
    request: DisassociateSkillFromSkillGroupRequest
  ): AlexaForBusinessIO[DisassociateSkillFromSkillGroupResponse] =
    FF.liftF(DisassociateSkillFromSkillGroupOp(request))

  def disassociateSkillFromUsers(
    request: DisassociateSkillFromUsersRequest
  ): AlexaForBusinessIO[DisassociateSkillFromUsersResponse] =
    FF.liftF(DisassociateSkillFromUsersOp(request))

  def disassociateSkillGroupFromRoom(
    request: DisassociateSkillGroupFromRoomRequest
  ): AlexaForBusinessIO[DisassociateSkillGroupFromRoomResponse] =
    FF.liftF(DisassociateSkillGroupFromRoomOp(request))

  def forgetSmartHomeAppliances(
    request: ForgetSmartHomeAppliancesRequest
  ): AlexaForBusinessIO[ForgetSmartHomeAppliancesResponse] =
    FF.liftF(ForgetSmartHomeAppliancesOp(request))

  def getAddressBook(
    request: GetAddressBookRequest
  ): AlexaForBusinessIO[GetAddressBookResponse] =
    FF.liftF(GetAddressBookOp(request))

  def getConferencePreference(
    request: GetConferencePreferenceRequest
  ): AlexaForBusinessIO[GetConferencePreferenceResponse] =
    FF.liftF(GetConferencePreferenceOp(request))

  def getConferenceProvider(
    request: GetConferenceProviderRequest
  ): AlexaForBusinessIO[GetConferenceProviderResponse] =
    FF.liftF(GetConferenceProviderOp(request))

  def getContact(
    request: GetContactRequest
  ): AlexaForBusinessIO[GetContactResponse] =
    FF.liftF(GetContactOp(request))

  def getDevice(
    request: GetDeviceRequest
  ): AlexaForBusinessIO[GetDeviceResponse] =
    FF.liftF(GetDeviceOp(request))

  def getGateway(
    request: GetGatewayRequest
  ): AlexaForBusinessIO[GetGatewayResponse] =
    FF.liftF(GetGatewayOp(request))

  def getGatewayGroup(
    request: GetGatewayGroupRequest
  ): AlexaForBusinessIO[GetGatewayGroupResponse] =
    FF.liftF(GetGatewayGroupOp(request))

  def getInvitationConfiguration(
    request: GetInvitationConfigurationRequest
  ): AlexaForBusinessIO[GetInvitationConfigurationResponse] =
    FF.liftF(GetInvitationConfigurationOp(request))

  def getNetworkProfile(
    request: GetNetworkProfileRequest
  ): AlexaForBusinessIO[GetNetworkProfileResponse] =
    FF.liftF(GetNetworkProfileOp(request))

  def getProfile(
    request: GetProfileRequest
  ): AlexaForBusinessIO[GetProfileResponse] =
    FF.liftF(GetProfileOp(request))

  def getRoom(
    request: GetRoomRequest
  ): AlexaForBusinessIO[GetRoomResponse] =
    FF.liftF(GetRoomOp(request))

  def getRoomSkillParameter(
    request: GetRoomSkillParameterRequest
  ): AlexaForBusinessIO[GetRoomSkillParameterResponse] =
    FF.liftF(GetRoomSkillParameterOp(request))

  def getSkillGroup(
    request: GetSkillGroupRequest
  ): AlexaForBusinessIO[GetSkillGroupResponse] =
    FF.liftF(GetSkillGroupOp(request))

  def listBusinessReportSchedules(
    request: ListBusinessReportSchedulesRequest
  ): AlexaForBusinessIO[ListBusinessReportSchedulesResponse] =
    FF.liftF(ListBusinessReportSchedulesOp(request))

  def listConferenceProviders(
    request: ListConferenceProvidersRequest
  ): AlexaForBusinessIO[ListConferenceProvidersResponse] =
    FF.liftF(ListConferenceProvidersOp(request))

  def listDeviceEvents(
    request: ListDeviceEventsRequest
  ): AlexaForBusinessIO[ListDeviceEventsResponse] =
    FF.liftF(ListDeviceEventsOp(request))

  def listGatewayGroups(
    request: ListGatewayGroupsRequest
  ): AlexaForBusinessIO[ListGatewayGroupsResponse] =
    FF.liftF(ListGatewayGroupsOp(request))

  def listGateways(
    request: ListGatewaysRequest
  ): AlexaForBusinessIO[ListGatewaysResponse] =
    FF.liftF(ListGatewaysOp(request))

  def listSkills(
    request: ListSkillsRequest
  ): AlexaForBusinessIO[ListSkillsResponse] =
    FF.liftF(ListSkillsOp(request))

  def listSkillsStoreCategories(
    request: ListSkillsStoreCategoriesRequest
  ): AlexaForBusinessIO[ListSkillsStoreCategoriesResponse] =
    FF.liftF(ListSkillsStoreCategoriesOp(request))

  def listSkillsStoreSkillsByCategory(
    request: ListSkillsStoreSkillsByCategoryRequest
  ): AlexaForBusinessIO[ListSkillsStoreSkillsByCategoryResponse] =
    FF.liftF(ListSkillsStoreSkillsByCategoryOp(request))

  def listSmartHomeAppliances(
    request: ListSmartHomeAppliancesRequest
  ): AlexaForBusinessIO[ListSmartHomeAppliancesResponse] =
    FF.liftF(ListSmartHomeAppliancesOp(request))

  def listTags(
    request: ListTagsRequest
  ): AlexaForBusinessIO[ListTagsResponse] =
    FF.liftF(ListTagsOp(request))

  def putConferencePreference(
    request: PutConferencePreferenceRequest
  ): AlexaForBusinessIO[PutConferencePreferenceResponse] =
    FF.liftF(PutConferencePreferenceOp(request))

  def putInvitationConfiguration(
    request: PutInvitationConfigurationRequest
  ): AlexaForBusinessIO[PutInvitationConfigurationResponse] =
    FF.liftF(PutInvitationConfigurationOp(request))

  def putRoomSkillParameter(
    request: PutRoomSkillParameterRequest
  ): AlexaForBusinessIO[PutRoomSkillParameterResponse] =
    FF.liftF(PutRoomSkillParameterOp(request))

  def putSkillAuthorization(
    request: PutSkillAuthorizationRequest
  ): AlexaForBusinessIO[PutSkillAuthorizationResponse] =
    FF.liftF(PutSkillAuthorizationOp(request))

  def registerAVSDevice(
    request: RegisterAvsDeviceRequest
  ): AlexaForBusinessIO[RegisterAvsDeviceResponse] =
    FF.liftF(RegisterAVSDeviceOp(request))

  def rejectSkill(
    request: RejectSkillRequest
  ): AlexaForBusinessIO[RejectSkillResponse] =
    FF.liftF(RejectSkillOp(request))

  def resolveRoom(
    request: ResolveRoomRequest
  ): AlexaForBusinessIO[ResolveRoomResponse] =
    FF.liftF(ResolveRoomOp(request))

  def revokeInvitation(
    request: RevokeInvitationRequest
  ): AlexaForBusinessIO[RevokeInvitationResponse] =
    FF.liftF(RevokeInvitationOp(request))

  def searchAddressBooks(
    request: SearchAddressBooksRequest
  ): AlexaForBusinessIO[SearchAddressBooksResponse] =
    FF.liftF(SearchAddressBooksOp(request))

  def searchContacts(
    request: SearchContactsRequest
  ): AlexaForBusinessIO[SearchContactsResponse] =
    FF.liftF(SearchContactsOp(request))

  def searchDevices(
    request: SearchDevicesRequest
  ): AlexaForBusinessIO[SearchDevicesResponse] =
    FF.liftF(SearchDevicesOp(request))

  def searchNetworkProfiles(
    request: SearchNetworkProfilesRequest
  ): AlexaForBusinessIO[SearchNetworkProfilesResponse] =
    FF.liftF(SearchNetworkProfilesOp(request))

  def searchProfiles(
    request: SearchProfilesRequest
  ): AlexaForBusinessIO[SearchProfilesResponse] =
    FF.liftF(SearchProfilesOp(request))

  def searchRooms(
    request: SearchRoomsRequest
  ): AlexaForBusinessIO[SearchRoomsResponse] =
    FF.liftF(SearchRoomsOp(request))

  def searchSkillGroups(
    request: SearchSkillGroupsRequest
  ): AlexaForBusinessIO[SearchSkillGroupsResponse] =
    FF.liftF(SearchSkillGroupsOp(request))

  def searchUsers(
    request: SearchUsersRequest
  ): AlexaForBusinessIO[SearchUsersResponse] =
    FF.liftF(SearchUsersOp(request))

  def sendAnnouncement(
    request: SendAnnouncementRequest
  ): AlexaForBusinessIO[SendAnnouncementResponse] =
    FF.liftF(SendAnnouncementOp(request))

  def sendInvitation(
    request: SendInvitationRequest
  ): AlexaForBusinessIO[SendInvitationResponse] =
    FF.liftF(SendInvitationOp(request))

  def startDeviceSync(
    request: StartDeviceSyncRequest
  ): AlexaForBusinessIO[StartDeviceSyncResponse] =
    FF.liftF(StartDeviceSyncOp(request))

  def startSmartHomeApplianceDiscovery(
    request: StartSmartHomeApplianceDiscoveryRequest
  ): AlexaForBusinessIO[StartSmartHomeApplianceDiscoveryResponse] =
    FF.liftF(StartSmartHomeApplianceDiscoveryOp(request))

  def tagResource(
    request: TagResourceRequest
  ): AlexaForBusinessIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): AlexaForBusinessIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAddressBook(
    request: UpdateAddressBookRequest
  ): AlexaForBusinessIO[UpdateAddressBookResponse] =
    FF.liftF(UpdateAddressBookOp(request))

  def updateBusinessReportSchedule(
    request: UpdateBusinessReportScheduleRequest
  ): AlexaForBusinessIO[UpdateBusinessReportScheduleResponse] =
    FF.liftF(UpdateBusinessReportScheduleOp(request))

  def updateConferenceProvider(
    request: UpdateConferenceProviderRequest
  ): AlexaForBusinessIO[UpdateConferenceProviderResponse] =
    FF.liftF(UpdateConferenceProviderOp(request))

  def updateContact(
    request: UpdateContactRequest
  ): AlexaForBusinessIO[UpdateContactResponse] =
    FF.liftF(UpdateContactOp(request))

  def updateDevice(
    request: UpdateDeviceRequest
  ): AlexaForBusinessIO[UpdateDeviceResponse] =
    FF.liftF(UpdateDeviceOp(request))

  def updateGateway(
    request: UpdateGatewayRequest
  ): AlexaForBusinessIO[UpdateGatewayResponse] =
    FF.liftF(UpdateGatewayOp(request))

  def updateGatewayGroup(
    request: UpdateGatewayGroupRequest
  ): AlexaForBusinessIO[UpdateGatewayGroupResponse] =
    FF.liftF(UpdateGatewayGroupOp(request))

  def updateNetworkProfile(
    request: UpdateNetworkProfileRequest
  ): AlexaForBusinessIO[UpdateNetworkProfileResponse] =
    FF.liftF(UpdateNetworkProfileOp(request))

  def updateProfile(
    request: UpdateProfileRequest
  ): AlexaForBusinessIO[UpdateProfileResponse] =
    FF.liftF(UpdateProfileOp(request))

  def updateRoom(
    request: UpdateRoomRequest
  ): AlexaForBusinessIO[UpdateRoomResponse] =
    FF.liftF(UpdateRoomOp(request))

  def updateSkillGroup(
    request: UpdateSkillGroupRequest
  ): AlexaForBusinessIO[UpdateSkillGroupResponse] =
    FF.liftF(UpdateSkillGroupOp(request))
}
