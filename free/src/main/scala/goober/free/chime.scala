package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.chime.ChimeClient
import software.amazon.awssdk.services.chime.model._


object chime { module =>

  // Free monad over ChimeOp
  type ChimeIO[A] = FF[ChimeOp, A]

  sealed trait ChimeOp[A] {
    def visit[F[_]](visitor: ChimeOp.Visitor[F]): F[A]
  }

  object ChimeOp {
    // Given a ChimeClient we can embed a ChimeIO program in any algebra that understands embedding.
    implicit val ChimeOpEmbeddable: Embeddable[ChimeOp, ChimeClient] = new Embeddable[ChimeOp, ChimeClient] {
      def embed[A](client: ChimeClient, io: ChimeIO[A]): Embedded[A] = Embedded.Chime(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ChimeOp.Visitor[Kleisli[M, ChimeClient, *]] {
        def associatePhoneNumberWithUser(
          request: AssociatePhoneNumberWithUserRequest
        ): Kleisli[M, ChimeClient, AssociatePhoneNumberWithUserResponse] =
          primitive(_.associatePhoneNumberWithUser(request))

        def associatePhoneNumbersWithVoiceConnector(
          request: AssociatePhoneNumbersWithVoiceConnectorRequest
        ): Kleisli[M, ChimeClient, AssociatePhoneNumbersWithVoiceConnectorResponse] =
          primitive(_.associatePhoneNumbersWithVoiceConnector(request))

        def associatePhoneNumbersWithVoiceConnectorGroup(
          request: AssociatePhoneNumbersWithVoiceConnectorGroupRequest
        ): Kleisli[M, ChimeClient, AssociatePhoneNumbersWithVoiceConnectorGroupResponse] =
          primitive(_.associatePhoneNumbersWithVoiceConnectorGroup(request))

        def associateSigninDelegateGroupsWithAccount(
          request: AssociateSigninDelegateGroupsWithAccountRequest
        ): Kleisli[M, ChimeClient, AssociateSigninDelegateGroupsWithAccountResponse] =
          primitive(_.associateSigninDelegateGroupsWithAccount(request))

        def batchCreateAttendee(
          request: BatchCreateAttendeeRequest
        ): Kleisli[M, ChimeClient, BatchCreateAttendeeResponse] =
          primitive(_.batchCreateAttendee(request))

        def batchCreateChannelMembership(
          request: BatchCreateChannelMembershipRequest
        ): Kleisli[M, ChimeClient, BatchCreateChannelMembershipResponse] =
          primitive(_.batchCreateChannelMembership(request))

        def batchCreateRoomMembership(
          request: BatchCreateRoomMembershipRequest
        ): Kleisli[M, ChimeClient, BatchCreateRoomMembershipResponse] =
          primitive(_.batchCreateRoomMembership(request))

        def batchDeletePhoneNumber(
          request: BatchDeletePhoneNumberRequest
        ): Kleisli[M, ChimeClient, BatchDeletePhoneNumberResponse] =
          primitive(_.batchDeletePhoneNumber(request))

        def batchSuspendUser(
          request: BatchSuspendUserRequest
        ): Kleisli[M, ChimeClient, BatchSuspendUserResponse] =
          primitive(_.batchSuspendUser(request))

        def batchUnsuspendUser(
          request: BatchUnsuspendUserRequest
        ): Kleisli[M, ChimeClient, BatchUnsuspendUserResponse] =
          primitive(_.batchUnsuspendUser(request))

        def batchUpdatePhoneNumber(
          request: BatchUpdatePhoneNumberRequest
        ): Kleisli[M, ChimeClient, BatchUpdatePhoneNumberResponse] =
          primitive(_.batchUpdatePhoneNumber(request))

        def batchUpdateUser(
          request: BatchUpdateUserRequest
        ): Kleisli[M, ChimeClient, BatchUpdateUserResponse] =
          primitive(_.batchUpdateUser(request))

        def createAccount(
          request: CreateAccountRequest
        ): Kleisli[M, ChimeClient, CreateAccountResponse] =
          primitive(_.createAccount(request))

        def createAppInstance(
          request: CreateAppInstanceRequest
        ): Kleisli[M, ChimeClient, CreateAppInstanceResponse] =
          primitive(_.createAppInstance(request))

        def createAppInstanceAdmin(
          request: CreateAppInstanceAdminRequest
        ): Kleisli[M, ChimeClient, CreateAppInstanceAdminResponse] =
          primitive(_.createAppInstanceAdmin(request))

        def createAppInstanceUser(
          request: CreateAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, CreateAppInstanceUserResponse] =
          primitive(_.createAppInstanceUser(request))

        def createAttendee(
          request: CreateAttendeeRequest
        ): Kleisli[M, ChimeClient, CreateAttendeeResponse] =
          primitive(_.createAttendee(request))

        def createBot(
          request: CreateBotRequest
        ): Kleisli[M, ChimeClient, CreateBotResponse] =
          primitive(_.createBot(request))

        def createChannel(
          request: CreateChannelRequest
        ): Kleisli[M, ChimeClient, CreateChannelResponse] =
          primitive(_.createChannel(request))

        def createChannelBan(
          request: CreateChannelBanRequest
        ): Kleisli[M, ChimeClient, CreateChannelBanResponse] =
          primitive(_.createChannelBan(request))

        def createChannelMembership(
          request: CreateChannelMembershipRequest
        ): Kleisli[M, ChimeClient, CreateChannelMembershipResponse] =
          primitive(_.createChannelMembership(request))

        def createChannelModerator(
          request: CreateChannelModeratorRequest
        ): Kleisli[M, ChimeClient, CreateChannelModeratorResponse] =
          primitive(_.createChannelModerator(request))

        def createMeeting(
          request: CreateMeetingRequest
        ): Kleisli[M, ChimeClient, CreateMeetingResponse] =
          primitive(_.createMeeting(request))

        def createMeetingDialOut(
          request: CreateMeetingDialOutRequest
        ): Kleisli[M, ChimeClient, CreateMeetingDialOutResponse] =
          primitive(_.createMeetingDialOut(request))

        def createMeetingWithAttendees(
          request: CreateMeetingWithAttendeesRequest
        ): Kleisli[M, ChimeClient, CreateMeetingWithAttendeesResponse] =
          primitive(_.createMeetingWithAttendees(request))

        def createPhoneNumberOrder(
          request: CreatePhoneNumberOrderRequest
        ): Kleisli[M, ChimeClient, CreatePhoneNumberOrderResponse] =
          primitive(_.createPhoneNumberOrder(request))

        def createProxySession(
          request: CreateProxySessionRequest
        ): Kleisli[M, ChimeClient, CreateProxySessionResponse] =
          primitive(_.createProxySession(request))

        def createRoom(
          request: CreateRoomRequest
        ): Kleisli[M, ChimeClient, CreateRoomResponse] =
          primitive(_.createRoom(request))

        def createRoomMembership(
          request: CreateRoomMembershipRequest
        ): Kleisli[M, ChimeClient, CreateRoomMembershipResponse] =
          primitive(_.createRoomMembership(request))

        def createSipMediaApplication(
          request: CreateSipMediaApplicationRequest
        ): Kleisli[M, ChimeClient, CreateSipMediaApplicationResponse] =
          primitive(_.createSipMediaApplication(request))

        def createSipMediaApplicationCall(
          request: CreateSipMediaApplicationCallRequest
        ): Kleisli[M, ChimeClient, CreateSipMediaApplicationCallResponse] =
          primitive(_.createSipMediaApplicationCall(request))

        def createSipRule(
          request: CreateSipRuleRequest
        ): Kleisli[M, ChimeClient, CreateSipRuleResponse] =
          primitive(_.createSipRule(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, ChimeClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def createVoiceConnector(
          request: CreateVoiceConnectorRequest
        ): Kleisli[M, ChimeClient, CreateVoiceConnectorResponse] =
          primitive(_.createVoiceConnector(request))

        def createVoiceConnectorGroup(
          request: CreateVoiceConnectorGroupRequest
        ): Kleisli[M, ChimeClient, CreateVoiceConnectorGroupResponse] =
          primitive(_.createVoiceConnectorGroup(request))

        def deleteAccount(
          request: DeleteAccountRequest
        ): Kleisli[M, ChimeClient, DeleteAccountResponse] =
          primitive(_.deleteAccount(request))

        def deleteAppInstance(
          request: DeleteAppInstanceRequest
        ): Kleisli[M, ChimeClient, DeleteAppInstanceResponse] =
          primitive(_.deleteAppInstance(request))

        def deleteAppInstanceAdmin(
          request: DeleteAppInstanceAdminRequest
        ): Kleisli[M, ChimeClient, DeleteAppInstanceAdminResponse] =
          primitive(_.deleteAppInstanceAdmin(request))

        def deleteAppInstanceStreamingConfigurations(
          request: DeleteAppInstanceStreamingConfigurationsRequest
        ): Kleisli[M, ChimeClient, DeleteAppInstanceStreamingConfigurationsResponse] =
          primitive(_.deleteAppInstanceStreamingConfigurations(request))

        def deleteAppInstanceUser(
          request: DeleteAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, DeleteAppInstanceUserResponse] =
          primitive(_.deleteAppInstanceUser(request))

        def deleteAttendee(
          request: DeleteAttendeeRequest
        ): Kleisli[M, ChimeClient, DeleteAttendeeResponse] =
          primitive(_.deleteAttendee(request))

        def deleteChannel(
          request: DeleteChannelRequest
        ): Kleisli[M, ChimeClient, DeleteChannelResponse] =
          primitive(_.deleteChannel(request))

        def deleteChannelBan(
          request: DeleteChannelBanRequest
        ): Kleisli[M, ChimeClient, DeleteChannelBanResponse] =
          primitive(_.deleteChannelBan(request))

        def deleteChannelMembership(
          request: DeleteChannelMembershipRequest
        ): Kleisli[M, ChimeClient, DeleteChannelMembershipResponse] =
          primitive(_.deleteChannelMembership(request))

        def deleteChannelMessage(
          request: DeleteChannelMessageRequest
        ): Kleisli[M, ChimeClient, DeleteChannelMessageResponse] =
          primitive(_.deleteChannelMessage(request))

        def deleteChannelModerator(
          request: DeleteChannelModeratorRequest
        ): Kleisli[M, ChimeClient, DeleteChannelModeratorResponse] =
          primitive(_.deleteChannelModerator(request))

        def deleteEventsConfiguration(
          request: DeleteEventsConfigurationRequest
        ): Kleisli[M, ChimeClient, DeleteEventsConfigurationResponse] =
          primitive(_.deleteEventsConfiguration(request))

        def deleteMeeting(
          request: DeleteMeetingRequest
        ): Kleisli[M, ChimeClient, DeleteMeetingResponse] =
          primitive(_.deleteMeeting(request))

        def deletePhoneNumber(
          request: DeletePhoneNumberRequest
        ): Kleisli[M, ChimeClient, DeletePhoneNumberResponse] =
          primitive(_.deletePhoneNumber(request))

        def deleteProxySession(
          request: DeleteProxySessionRequest
        ): Kleisli[M, ChimeClient, DeleteProxySessionResponse] =
          primitive(_.deleteProxySession(request))

        def deleteRoom(
          request: DeleteRoomRequest
        ): Kleisli[M, ChimeClient, DeleteRoomResponse] =
          primitive(_.deleteRoom(request))

        def deleteRoomMembership(
          request: DeleteRoomMembershipRequest
        ): Kleisli[M, ChimeClient, DeleteRoomMembershipResponse] =
          primitive(_.deleteRoomMembership(request))

        def deleteSipMediaApplication(
          request: DeleteSipMediaApplicationRequest
        ): Kleisli[M, ChimeClient, DeleteSipMediaApplicationResponse] =
          primitive(_.deleteSipMediaApplication(request))

        def deleteSipRule(
          request: DeleteSipRuleRequest
        ): Kleisli[M, ChimeClient, DeleteSipRuleResponse] =
          primitive(_.deleteSipRule(request))

        def deleteVoiceConnector(
          request: DeleteVoiceConnectorRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorResponse] =
          primitive(_.deleteVoiceConnector(request))

        def deleteVoiceConnectorEmergencyCallingConfiguration(
          request: DeleteVoiceConnectorEmergencyCallingConfigurationRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorEmergencyCallingConfigurationResponse] =
          primitive(_.deleteVoiceConnectorEmergencyCallingConfiguration(request))

        def deleteVoiceConnectorGroup(
          request: DeleteVoiceConnectorGroupRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorGroupResponse] =
          primitive(_.deleteVoiceConnectorGroup(request))

        def deleteVoiceConnectorOrigination(
          request: DeleteVoiceConnectorOriginationRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorOriginationResponse] =
          primitive(_.deleteVoiceConnectorOrigination(request))

        def deleteVoiceConnectorProxy(
          request: DeleteVoiceConnectorProxyRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorProxyResponse] =
          primitive(_.deleteVoiceConnectorProxy(request))

        def deleteVoiceConnectorStreamingConfiguration(
          request: DeleteVoiceConnectorStreamingConfigurationRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorStreamingConfigurationResponse] =
          primitive(_.deleteVoiceConnectorStreamingConfiguration(request))

        def deleteVoiceConnectorTermination(
          request: DeleteVoiceConnectorTerminationRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorTerminationResponse] =
          primitive(_.deleteVoiceConnectorTermination(request))

        def deleteVoiceConnectorTerminationCredentials(
          request: DeleteVoiceConnectorTerminationCredentialsRequest
        ): Kleisli[M, ChimeClient, DeleteVoiceConnectorTerminationCredentialsResponse] =
          primitive(_.deleteVoiceConnectorTerminationCredentials(request))

        def describeAppInstance(
          request: DescribeAppInstanceRequest
        ): Kleisli[M, ChimeClient, DescribeAppInstanceResponse] =
          primitive(_.describeAppInstance(request))

        def describeAppInstanceAdmin(
          request: DescribeAppInstanceAdminRequest
        ): Kleisli[M, ChimeClient, DescribeAppInstanceAdminResponse] =
          primitive(_.describeAppInstanceAdmin(request))

        def describeAppInstanceUser(
          request: DescribeAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, DescribeAppInstanceUserResponse] =
          primitive(_.describeAppInstanceUser(request))

        def describeChannel(
          request: DescribeChannelRequest
        ): Kleisli[M, ChimeClient, DescribeChannelResponse] =
          primitive(_.describeChannel(request))

        def describeChannelBan(
          request: DescribeChannelBanRequest
        ): Kleisli[M, ChimeClient, DescribeChannelBanResponse] =
          primitive(_.describeChannelBan(request))

        def describeChannelMembership(
          request: DescribeChannelMembershipRequest
        ): Kleisli[M, ChimeClient, DescribeChannelMembershipResponse] =
          primitive(_.describeChannelMembership(request))

        def describeChannelMembershipForAppInstanceUser(
          request: DescribeChannelMembershipForAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, DescribeChannelMembershipForAppInstanceUserResponse] =
          primitive(_.describeChannelMembershipForAppInstanceUser(request))

        def describeChannelModeratedByAppInstanceUser(
          request: DescribeChannelModeratedByAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, DescribeChannelModeratedByAppInstanceUserResponse] =
          primitive(_.describeChannelModeratedByAppInstanceUser(request))

        def describeChannelModerator(
          request: DescribeChannelModeratorRequest
        ): Kleisli[M, ChimeClient, DescribeChannelModeratorResponse] =
          primitive(_.describeChannelModerator(request))

        def disassociatePhoneNumberFromUser(
          request: DisassociatePhoneNumberFromUserRequest
        ): Kleisli[M, ChimeClient, DisassociatePhoneNumberFromUserResponse] =
          primitive(_.disassociatePhoneNumberFromUser(request))

        def disassociatePhoneNumbersFromVoiceConnector(
          request: DisassociatePhoneNumbersFromVoiceConnectorRequest
        ): Kleisli[M, ChimeClient, DisassociatePhoneNumbersFromVoiceConnectorResponse] =
          primitive(_.disassociatePhoneNumbersFromVoiceConnector(request))

        def disassociatePhoneNumbersFromVoiceConnectorGroup(
          request: DisassociatePhoneNumbersFromVoiceConnectorGroupRequest
        ): Kleisli[M, ChimeClient, DisassociatePhoneNumbersFromVoiceConnectorGroupResponse] =
          primitive(_.disassociatePhoneNumbersFromVoiceConnectorGroup(request))

        def disassociateSigninDelegateGroupsFromAccount(
          request: DisassociateSigninDelegateGroupsFromAccountRequest
        ): Kleisli[M, ChimeClient, DisassociateSigninDelegateGroupsFromAccountResponse] =
          primitive(_.disassociateSigninDelegateGroupsFromAccount(request))

        def getAccount(
          request: GetAccountRequest
        ): Kleisli[M, ChimeClient, GetAccountResponse] =
          primitive(_.getAccount(request))

        def getAccountSettings(
          request: GetAccountSettingsRequest
        ): Kleisli[M, ChimeClient, GetAccountSettingsResponse] =
          primitive(_.getAccountSettings(request))

        def getAppInstanceRetentionSettings(
          request: GetAppInstanceRetentionSettingsRequest
        ): Kleisli[M, ChimeClient, GetAppInstanceRetentionSettingsResponse] =
          primitive(_.getAppInstanceRetentionSettings(request))

        def getAppInstanceStreamingConfigurations(
          request: GetAppInstanceStreamingConfigurationsRequest
        ): Kleisli[M, ChimeClient, GetAppInstanceStreamingConfigurationsResponse] =
          primitive(_.getAppInstanceStreamingConfigurations(request))

        def getAttendee(
          request: GetAttendeeRequest
        ): Kleisli[M, ChimeClient, GetAttendeeResponse] =
          primitive(_.getAttendee(request))

        def getBot(
          request: GetBotRequest
        ): Kleisli[M, ChimeClient, GetBotResponse] =
          primitive(_.getBot(request))

        def getChannelMessage(
          request: GetChannelMessageRequest
        ): Kleisli[M, ChimeClient, GetChannelMessageResponse] =
          primitive(_.getChannelMessage(request))

        def getEventsConfiguration(
          request: GetEventsConfigurationRequest
        ): Kleisli[M, ChimeClient, GetEventsConfigurationResponse] =
          primitive(_.getEventsConfiguration(request))

        def getGlobalSettings(
          request: GetGlobalSettingsRequest
        ): Kleisli[M, ChimeClient, GetGlobalSettingsResponse] =
          primitive(_.getGlobalSettings(request))

        def getMeeting(
          request: GetMeetingRequest
        ): Kleisli[M, ChimeClient, GetMeetingResponse] =
          primitive(_.getMeeting(request))

        def getMessagingSessionEndpoint(
          request: GetMessagingSessionEndpointRequest
        ): Kleisli[M, ChimeClient, GetMessagingSessionEndpointResponse] =
          primitive(_.getMessagingSessionEndpoint(request))

        def getPhoneNumber(
          request: GetPhoneNumberRequest
        ): Kleisli[M, ChimeClient, GetPhoneNumberResponse] =
          primitive(_.getPhoneNumber(request))

        def getPhoneNumberOrder(
          request: GetPhoneNumberOrderRequest
        ): Kleisli[M, ChimeClient, GetPhoneNumberOrderResponse] =
          primitive(_.getPhoneNumberOrder(request))

        def getPhoneNumberSettings(
          request: GetPhoneNumberSettingsRequest
        ): Kleisli[M, ChimeClient, GetPhoneNumberSettingsResponse] =
          primitive(_.getPhoneNumberSettings(request))

        def getProxySession(
          request: GetProxySessionRequest
        ): Kleisli[M, ChimeClient, GetProxySessionResponse] =
          primitive(_.getProxySession(request))

        def getRetentionSettings(
          request: GetRetentionSettingsRequest
        ): Kleisli[M, ChimeClient, GetRetentionSettingsResponse] =
          primitive(_.getRetentionSettings(request))

        def getRoom(
          request: GetRoomRequest
        ): Kleisli[M, ChimeClient, GetRoomResponse] =
          primitive(_.getRoom(request))

        def getSipMediaApplication(
          request: GetSipMediaApplicationRequest
        ): Kleisli[M, ChimeClient, GetSipMediaApplicationResponse] =
          primitive(_.getSipMediaApplication(request))

        def getSipMediaApplicationLoggingConfiguration(
          request: GetSipMediaApplicationLoggingConfigurationRequest
        ): Kleisli[M, ChimeClient, GetSipMediaApplicationLoggingConfigurationResponse] =
          primitive(_.getSipMediaApplicationLoggingConfiguration(request))

        def getSipRule(
          request: GetSipRuleRequest
        ): Kleisli[M, ChimeClient, GetSipRuleResponse] =
          primitive(_.getSipRule(request))

        def getUser(
          request: GetUserRequest
        ): Kleisli[M, ChimeClient, GetUserResponse] =
          primitive(_.getUser(request))

        def getUserSettings(
          request: GetUserSettingsRequest
        ): Kleisli[M, ChimeClient, GetUserSettingsResponse] =
          primitive(_.getUserSettings(request))

        def getVoiceConnector(
          request: GetVoiceConnectorRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorResponse] =
          primitive(_.getVoiceConnector(request))

        def getVoiceConnectorEmergencyCallingConfiguration(
          request: GetVoiceConnectorEmergencyCallingConfigurationRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorEmergencyCallingConfigurationResponse] =
          primitive(_.getVoiceConnectorEmergencyCallingConfiguration(request))

        def getVoiceConnectorGroup(
          request: GetVoiceConnectorGroupRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorGroupResponse] =
          primitive(_.getVoiceConnectorGroup(request))

        def getVoiceConnectorLoggingConfiguration(
          request: GetVoiceConnectorLoggingConfigurationRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorLoggingConfigurationResponse] =
          primitive(_.getVoiceConnectorLoggingConfiguration(request))

        def getVoiceConnectorOrigination(
          request: GetVoiceConnectorOriginationRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorOriginationResponse] =
          primitive(_.getVoiceConnectorOrigination(request))

        def getVoiceConnectorProxy(
          request: GetVoiceConnectorProxyRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorProxyResponse] =
          primitive(_.getVoiceConnectorProxy(request))

        def getVoiceConnectorStreamingConfiguration(
          request: GetVoiceConnectorStreamingConfigurationRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorStreamingConfigurationResponse] =
          primitive(_.getVoiceConnectorStreamingConfiguration(request))

        def getVoiceConnectorTermination(
          request: GetVoiceConnectorTerminationRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorTerminationResponse] =
          primitive(_.getVoiceConnectorTermination(request))

        def getVoiceConnectorTerminationHealth(
          request: GetVoiceConnectorTerminationHealthRequest
        ): Kleisli[M, ChimeClient, GetVoiceConnectorTerminationHealthResponse] =
          primitive(_.getVoiceConnectorTerminationHealth(request))

        def inviteUsers(
          request: InviteUsersRequest
        ): Kleisli[M, ChimeClient, InviteUsersResponse] =
          primitive(_.inviteUsers(request))

        def listAccounts(
          request: ListAccountsRequest
        ): Kleisli[M, ChimeClient, ListAccountsResponse] =
          primitive(_.listAccounts(request))

        def listAppInstanceAdmins(
          request: ListAppInstanceAdminsRequest
        ): Kleisli[M, ChimeClient, ListAppInstanceAdminsResponse] =
          primitive(_.listAppInstanceAdmins(request))

        def listAppInstanceUsers(
          request: ListAppInstanceUsersRequest
        ): Kleisli[M, ChimeClient, ListAppInstanceUsersResponse] =
          primitive(_.listAppInstanceUsers(request))

        def listAppInstances(
          request: ListAppInstancesRequest
        ): Kleisli[M, ChimeClient, ListAppInstancesResponse] =
          primitive(_.listAppInstances(request))

        def listAttendeeTags(
          request: ListAttendeeTagsRequest
        ): Kleisli[M, ChimeClient, ListAttendeeTagsResponse] =
          primitive(_.listAttendeeTags(request))

        def listAttendees(
          request: ListAttendeesRequest
        ): Kleisli[M, ChimeClient, ListAttendeesResponse] =
          primitive(_.listAttendees(request))

        def listBots(
          request: ListBotsRequest
        ): Kleisli[M, ChimeClient, ListBotsResponse] =
          primitive(_.listBots(request))

        def listChannelBans(
          request: ListChannelBansRequest
        ): Kleisli[M, ChimeClient, ListChannelBansResponse] =
          primitive(_.listChannelBans(request))

        def listChannelMemberships(
          request: ListChannelMembershipsRequest
        ): Kleisli[M, ChimeClient, ListChannelMembershipsResponse] =
          primitive(_.listChannelMemberships(request))

        def listChannelMembershipsForAppInstanceUser(
          request: ListChannelMembershipsForAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, ListChannelMembershipsForAppInstanceUserResponse] =
          primitive(_.listChannelMembershipsForAppInstanceUser(request))

        def listChannelMessages(
          request: ListChannelMessagesRequest
        ): Kleisli[M, ChimeClient, ListChannelMessagesResponse] =
          primitive(_.listChannelMessages(request))

        def listChannelModerators(
          request: ListChannelModeratorsRequest
        ): Kleisli[M, ChimeClient, ListChannelModeratorsResponse] =
          primitive(_.listChannelModerators(request))

        def listChannels(
          request: ListChannelsRequest
        ): Kleisli[M, ChimeClient, ListChannelsResponse] =
          primitive(_.listChannels(request))

        def listChannelsModeratedByAppInstanceUser(
          request: ListChannelsModeratedByAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, ListChannelsModeratedByAppInstanceUserResponse] =
          primitive(_.listChannelsModeratedByAppInstanceUser(request))

        def listMeetingTags(
          request: ListMeetingTagsRequest
        ): Kleisli[M, ChimeClient, ListMeetingTagsResponse] =
          primitive(_.listMeetingTags(request))

        def listMeetings(
          request: ListMeetingsRequest
        ): Kleisli[M, ChimeClient, ListMeetingsResponse] =
          primitive(_.listMeetings(request))

        def listPhoneNumberOrders(
          request: ListPhoneNumberOrdersRequest
        ): Kleisli[M, ChimeClient, ListPhoneNumberOrdersResponse] =
          primitive(_.listPhoneNumberOrders(request))

        def listPhoneNumbers(
          request: ListPhoneNumbersRequest
        ): Kleisli[M, ChimeClient, ListPhoneNumbersResponse] =
          primitive(_.listPhoneNumbers(request))

        def listProxySessions(
          request: ListProxySessionsRequest
        ): Kleisli[M, ChimeClient, ListProxySessionsResponse] =
          primitive(_.listProxySessions(request))

        def listRoomMemberships(
          request: ListRoomMembershipsRequest
        ): Kleisli[M, ChimeClient, ListRoomMembershipsResponse] =
          primitive(_.listRoomMemberships(request))

        def listRooms(
          request: ListRoomsRequest
        ): Kleisli[M, ChimeClient, ListRoomsResponse] =
          primitive(_.listRooms(request))

        def listSipMediaApplications(
          request: ListSipMediaApplicationsRequest
        ): Kleisli[M, ChimeClient, ListSipMediaApplicationsResponse] =
          primitive(_.listSipMediaApplications(request))

        def listSipRules(
          request: ListSipRulesRequest
        ): Kleisli[M, ChimeClient, ListSipRulesResponse] =
          primitive(_.listSipRules(request))

        def listSupportedPhoneNumberCountries(
          request: ListSupportedPhoneNumberCountriesRequest
        ): Kleisli[M, ChimeClient, ListSupportedPhoneNumberCountriesResponse] =
          primitive(_.listSupportedPhoneNumberCountries(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ChimeClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, ChimeClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def listVoiceConnectorGroups(
          request: ListVoiceConnectorGroupsRequest
        ): Kleisli[M, ChimeClient, ListVoiceConnectorGroupsResponse] =
          primitive(_.listVoiceConnectorGroups(request))

        def listVoiceConnectorTerminationCredentials(
          request: ListVoiceConnectorTerminationCredentialsRequest
        ): Kleisli[M, ChimeClient, ListVoiceConnectorTerminationCredentialsResponse] =
          primitive(_.listVoiceConnectorTerminationCredentials(request))

        def listVoiceConnectors(
          request: ListVoiceConnectorsRequest
        ): Kleisli[M, ChimeClient, ListVoiceConnectorsResponse] =
          primitive(_.listVoiceConnectors(request))

        def logoutUser(
          request: LogoutUserRequest
        ): Kleisli[M, ChimeClient, LogoutUserResponse] =
          primitive(_.logoutUser(request))

        def putAppInstanceRetentionSettings(
          request: PutAppInstanceRetentionSettingsRequest
        ): Kleisli[M, ChimeClient, PutAppInstanceRetentionSettingsResponse] =
          primitive(_.putAppInstanceRetentionSettings(request))

        def putAppInstanceStreamingConfigurations(
          request: PutAppInstanceStreamingConfigurationsRequest
        ): Kleisli[M, ChimeClient, PutAppInstanceStreamingConfigurationsResponse] =
          primitive(_.putAppInstanceStreamingConfigurations(request))

        def putEventsConfiguration(
          request: PutEventsConfigurationRequest
        ): Kleisli[M, ChimeClient, PutEventsConfigurationResponse] =
          primitive(_.putEventsConfiguration(request))

        def putRetentionSettings(
          request: PutRetentionSettingsRequest
        ): Kleisli[M, ChimeClient, PutRetentionSettingsResponse] =
          primitive(_.putRetentionSettings(request))

        def putSipMediaApplicationLoggingConfiguration(
          request: PutSipMediaApplicationLoggingConfigurationRequest
        ): Kleisli[M, ChimeClient, PutSipMediaApplicationLoggingConfigurationResponse] =
          primitive(_.putSipMediaApplicationLoggingConfiguration(request))

        def putVoiceConnectorEmergencyCallingConfiguration(
          request: PutVoiceConnectorEmergencyCallingConfigurationRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorEmergencyCallingConfigurationResponse] =
          primitive(_.putVoiceConnectorEmergencyCallingConfiguration(request))

        def putVoiceConnectorLoggingConfiguration(
          request: PutVoiceConnectorLoggingConfigurationRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorLoggingConfigurationResponse] =
          primitive(_.putVoiceConnectorLoggingConfiguration(request))

        def putVoiceConnectorOrigination(
          request: PutVoiceConnectorOriginationRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorOriginationResponse] =
          primitive(_.putVoiceConnectorOrigination(request))

        def putVoiceConnectorProxy(
          request: PutVoiceConnectorProxyRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorProxyResponse] =
          primitive(_.putVoiceConnectorProxy(request))

        def putVoiceConnectorStreamingConfiguration(
          request: PutVoiceConnectorStreamingConfigurationRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorStreamingConfigurationResponse] =
          primitive(_.putVoiceConnectorStreamingConfiguration(request))

        def putVoiceConnectorTermination(
          request: PutVoiceConnectorTerminationRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorTerminationResponse] =
          primitive(_.putVoiceConnectorTermination(request))

        def putVoiceConnectorTerminationCredentials(
          request: PutVoiceConnectorTerminationCredentialsRequest
        ): Kleisli[M, ChimeClient, PutVoiceConnectorTerminationCredentialsResponse] =
          primitive(_.putVoiceConnectorTerminationCredentials(request))

        def redactChannelMessage(
          request: RedactChannelMessageRequest
        ): Kleisli[M, ChimeClient, RedactChannelMessageResponse] =
          primitive(_.redactChannelMessage(request))

        def redactConversationMessage(
          request: RedactConversationMessageRequest
        ): Kleisli[M, ChimeClient, RedactConversationMessageResponse] =
          primitive(_.redactConversationMessage(request))

        def redactRoomMessage(
          request: RedactRoomMessageRequest
        ): Kleisli[M, ChimeClient, RedactRoomMessageResponse] =
          primitive(_.redactRoomMessage(request))

        def regenerateSecurityToken(
          request: RegenerateSecurityTokenRequest
        ): Kleisli[M, ChimeClient, RegenerateSecurityTokenResponse] =
          primitive(_.regenerateSecurityToken(request))

        def resetPersonalPIN(
          request: ResetPersonalPinRequest
        ): Kleisli[M, ChimeClient, ResetPersonalPinResponse] =
          primitive(_.resetPersonalPIN(request))

        def restorePhoneNumber(
          request: RestorePhoneNumberRequest
        ): Kleisli[M, ChimeClient, RestorePhoneNumberResponse] =
          primitive(_.restorePhoneNumber(request))

        def searchAvailablePhoneNumbers(
          request: SearchAvailablePhoneNumbersRequest
        ): Kleisli[M, ChimeClient, SearchAvailablePhoneNumbersResponse] =
          primitive(_.searchAvailablePhoneNumbers(request))

        def sendChannelMessage(
          request: SendChannelMessageRequest
        ): Kleisli[M, ChimeClient, SendChannelMessageResponse] =
          primitive(_.sendChannelMessage(request))

        def tagAttendee(
          request: TagAttendeeRequest
        ): Kleisli[M, ChimeClient, TagAttendeeResponse] =
          primitive(_.tagAttendee(request))

        def tagMeeting(
          request: TagMeetingRequest
        ): Kleisli[M, ChimeClient, TagMeetingResponse] =
          primitive(_.tagMeeting(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ChimeClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagAttendee(
          request: UntagAttendeeRequest
        ): Kleisli[M, ChimeClient, UntagAttendeeResponse] =
          primitive(_.untagAttendee(request))

        def untagMeeting(
          request: UntagMeetingRequest
        ): Kleisli[M, ChimeClient, UntagMeetingResponse] =
          primitive(_.untagMeeting(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ChimeClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAccount(
          request: UpdateAccountRequest
        ): Kleisli[M, ChimeClient, UpdateAccountResponse] =
          primitive(_.updateAccount(request))

        def updateAccountSettings(
          request: UpdateAccountSettingsRequest
        ): Kleisli[M, ChimeClient, UpdateAccountSettingsResponse] =
          primitive(_.updateAccountSettings(request))

        def updateAppInstance(
          request: UpdateAppInstanceRequest
        ): Kleisli[M, ChimeClient, UpdateAppInstanceResponse] =
          primitive(_.updateAppInstance(request))

        def updateAppInstanceUser(
          request: UpdateAppInstanceUserRequest
        ): Kleisli[M, ChimeClient, UpdateAppInstanceUserResponse] =
          primitive(_.updateAppInstanceUser(request))

        def updateBot(
          request: UpdateBotRequest
        ): Kleisli[M, ChimeClient, UpdateBotResponse] =
          primitive(_.updateBot(request))

        def updateChannel(
          request: UpdateChannelRequest
        ): Kleisli[M, ChimeClient, UpdateChannelResponse] =
          primitive(_.updateChannel(request))

        def updateChannelMessage(
          request: UpdateChannelMessageRequest
        ): Kleisli[M, ChimeClient, UpdateChannelMessageResponse] =
          primitive(_.updateChannelMessage(request))

        def updateChannelReadMarker(
          request: UpdateChannelReadMarkerRequest
        ): Kleisli[M, ChimeClient, UpdateChannelReadMarkerResponse] =
          primitive(_.updateChannelReadMarker(request))

        def updateGlobalSettings(
          request: UpdateGlobalSettingsRequest
        ): Kleisli[M, ChimeClient, UpdateGlobalSettingsResponse] =
          primitive(_.updateGlobalSettings(request))

        def updatePhoneNumber(
          request: UpdatePhoneNumberRequest
        ): Kleisli[M, ChimeClient, UpdatePhoneNumberResponse] =
          primitive(_.updatePhoneNumber(request))

        def updatePhoneNumberSettings(
          request: UpdatePhoneNumberSettingsRequest
        ): Kleisli[M, ChimeClient, UpdatePhoneNumberSettingsResponse] =
          primitive(_.updatePhoneNumberSettings(request))

        def updateProxySession(
          request: UpdateProxySessionRequest
        ): Kleisli[M, ChimeClient, UpdateProxySessionResponse] =
          primitive(_.updateProxySession(request))

        def updateRoom(
          request: UpdateRoomRequest
        ): Kleisli[M, ChimeClient, UpdateRoomResponse] =
          primitive(_.updateRoom(request))

        def updateRoomMembership(
          request: UpdateRoomMembershipRequest
        ): Kleisli[M, ChimeClient, UpdateRoomMembershipResponse] =
          primitive(_.updateRoomMembership(request))

        def updateSipMediaApplication(
          request: UpdateSipMediaApplicationRequest
        ): Kleisli[M, ChimeClient, UpdateSipMediaApplicationResponse] =
          primitive(_.updateSipMediaApplication(request))

        def updateSipRule(
          request: UpdateSipRuleRequest
        ): Kleisli[M, ChimeClient, UpdateSipRuleResponse] =
          primitive(_.updateSipRule(request))

        def updateUser(
          request: UpdateUserRequest
        ): Kleisli[M, ChimeClient, UpdateUserResponse] =
          primitive(_.updateUser(request))

        def updateUserSettings(
          request: UpdateUserSettingsRequest
        ): Kleisli[M, ChimeClient, UpdateUserSettingsResponse] =
          primitive(_.updateUserSettings(request))

        def updateVoiceConnector(
          request: UpdateVoiceConnectorRequest
        ): Kleisli[M, ChimeClient, UpdateVoiceConnectorResponse] =
          primitive(_.updateVoiceConnector(request))

        def updateVoiceConnectorGroup(
          request: UpdateVoiceConnectorGroupRequest
        ): Kleisli[M, ChimeClient, UpdateVoiceConnectorGroupResponse] =
          primitive(_.updateVoiceConnectorGroup(request))

        def primitive[A](
          f: ChimeClient => A
        ): Kleisli[M, ChimeClient, A]
      }
    }

    trait Visitor[F[_]] extends (ChimeOp ~> F) {
      final def apply[A](op: ChimeOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associatePhoneNumberWithUser(
        request: AssociatePhoneNumberWithUserRequest
      ): F[AssociatePhoneNumberWithUserResponse]

      def associatePhoneNumbersWithVoiceConnector(
        request: AssociatePhoneNumbersWithVoiceConnectorRequest
      ): F[AssociatePhoneNumbersWithVoiceConnectorResponse]

      def associatePhoneNumbersWithVoiceConnectorGroup(
        request: AssociatePhoneNumbersWithVoiceConnectorGroupRequest
      ): F[AssociatePhoneNumbersWithVoiceConnectorGroupResponse]

      def associateSigninDelegateGroupsWithAccount(
        request: AssociateSigninDelegateGroupsWithAccountRequest
      ): F[AssociateSigninDelegateGroupsWithAccountResponse]

      def batchCreateAttendee(
        request: BatchCreateAttendeeRequest
      ): F[BatchCreateAttendeeResponse]

      def batchCreateChannelMembership(
        request: BatchCreateChannelMembershipRequest
      ): F[BatchCreateChannelMembershipResponse]

      def batchCreateRoomMembership(
        request: BatchCreateRoomMembershipRequest
      ): F[BatchCreateRoomMembershipResponse]

      def batchDeletePhoneNumber(
        request: BatchDeletePhoneNumberRequest
      ): F[BatchDeletePhoneNumberResponse]

      def batchSuspendUser(
        request: BatchSuspendUserRequest
      ): F[BatchSuspendUserResponse]

      def batchUnsuspendUser(
        request: BatchUnsuspendUserRequest
      ): F[BatchUnsuspendUserResponse]

      def batchUpdatePhoneNumber(
        request: BatchUpdatePhoneNumberRequest
      ): F[BatchUpdatePhoneNumberResponse]

      def batchUpdateUser(
        request: BatchUpdateUserRequest
      ): F[BatchUpdateUserResponse]

      def createAccount(
        request: CreateAccountRequest
      ): F[CreateAccountResponse]

      def createAppInstance(
        request: CreateAppInstanceRequest
      ): F[CreateAppInstanceResponse]

      def createAppInstanceAdmin(
        request: CreateAppInstanceAdminRequest
      ): F[CreateAppInstanceAdminResponse]

      def createAppInstanceUser(
        request: CreateAppInstanceUserRequest
      ): F[CreateAppInstanceUserResponse]

      def createAttendee(
        request: CreateAttendeeRequest
      ): F[CreateAttendeeResponse]

      def createBot(
        request: CreateBotRequest
      ): F[CreateBotResponse]

      def createChannel(
        request: CreateChannelRequest
      ): F[CreateChannelResponse]

      def createChannelBan(
        request: CreateChannelBanRequest
      ): F[CreateChannelBanResponse]

      def createChannelMembership(
        request: CreateChannelMembershipRequest
      ): F[CreateChannelMembershipResponse]

      def createChannelModerator(
        request: CreateChannelModeratorRequest
      ): F[CreateChannelModeratorResponse]

      def createMeeting(
        request: CreateMeetingRequest
      ): F[CreateMeetingResponse]

      def createMeetingDialOut(
        request: CreateMeetingDialOutRequest
      ): F[CreateMeetingDialOutResponse]

      def createMeetingWithAttendees(
        request: CreateMeetingWithAttendeesRequest
      ): F[CreateMeetingWithAttendeesResponse]

      def createPhoneNumberOrder(
        request: CreatePhoneNumberOrderRequest
      ): F[CreatePhoneNumberOrderResponse]

      def createProxySession(
        request: CreateProxySessionRequest
      ): F[CreateProxySessionResponse]

      def createRoom(
        request: CreateRoomRequest
      ): F[CreateRoomResponse]

      def createRoomMembership(
        request: CreateRoomMembershipRequest
      ): F[CreateRoomMembershipResponse]

      def createSipMediaApplication(
        request: CreateSipMediaApplicationRequest
      ): F[CreateSipMediaApplicationResponse]

      def createSipMediaApplicationCall(
        request: CreateSipMediaApplicationCallRequest
      ): F[CreateSipMediaApplicationCallResponse]

      def createSipRule(
        request: CreateSipRuleRequest
      ): F[CreateSipRuleResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def createVoiceConnector(
        request: CreateVoiceConnectorRequest
      ): F[CreateVoiceConnectorResponse]

      def createVoiceConnectorGroup(
        request: CreateVoiceConnectorGroupRequest
      ): F[CreateVoiceConnectorGroupResponse]

      def deleteAccount(
        request: DeleteAccountRequest
      ): F[DeleteAccountResponse]

      def deleteAppInstance(
        request: DeleteAppInstanceRequest
      ): F[DeleteAppInstanceResponse]

      def deleteAppInstanceAdmin(
        request: DeleteAppInstanceAdminRequest
      ): F[DeleteAppInstanceAdminResponse]

      def deleteAppInstanceStreamingConfigurations(
        request: DeleteAppInstanceStreamingConfigurationsRequest
      ): F[DeleteAppInstanceStreamingConfigurationsResponse]

      def deleteAppInstanceUser(
        request: DeleteAppInstanceUserRequest
      ): F[DeleteAppInstanceUserResponse]

      def deleteAttendee(
        request: DeleteAttendeeRequest
      ): F[DeleteAttendeeResponse]

      def deleteChannel(
        request: DeleteChannelRequest
      ): F[DeleteChannelResponse]

      def deleteChannelBan(
        request: DeleteChannelBanRequest
      ): F[DeleteChannelBanResponse]

      def deleteChannelMembership(
        request: DeleteChannelMembershipRequest
      ): F[DeleteChannelMembershipResponse]

      def deleteChannelMessage(
        request: DeleteChannelMessageRequest
      ): F[DeleteChannelMessageResponse]

      def deleteChannelModerator(
        request: DeleteChannelModeratorRequest
      ): F[DeleteChannelModeratorResponse]

      def deleteEventsConfiguration(
        request: DeleteEventsConfigurationRequest
      ): F[DeleteEventsConfigurationResponse]

      def deleteMeeting(
        request: DeleteMeetingRequest
      ): F[DeleteMeetingResponse]

      def deletePhoneNumber(
        request: DeletePhoneNumberRequest
      ): F[DeletePhoneNumberResponse]

      def deleteProxySession(
        request: DeleteProxySessionRequest
      ): F[DeleteProxySessionResponse]

      def deleteRoom(
        request: DeleteRoomRequest
      ): F[DeleteRoomResponse]

      def deleteRoomMembership(
        request: DeleteRoomMembershipRequest
      ): F[DeleteRoomMembershipResponse]

      def deleteSipMediaApplication(
        request: DeleteSipMediaApplicationRequest
      ): F[DeleteSipMediaApplicationResponse]

      def deleteSipRule(
        request: DeleteSipRuleRequest
      ): F[DeleteSipRuleResponse]

      def deleteVoiceConnector(
        request: DeleteVoiceConnectorRequest
      ): F[DeleteVoiceConnectorResponse]

      def deleteVoiceConnectorEmergencyCallingConfiguration(
        request: DeleteVoiceConnectorEmergencyCallingConfigurationRequest
      ): F[DeleteVoiceConnectorEmergencyCallingConfigurationResponse]

      def deleteVoiceConnectorGroup(
        request: DeleteVoiceConnectorGroupRequest
      ): F[DeleteVoiceConnectorGroupResponse]

      def deleteVoiceConnectorOrigination(
        request: DeleteVoiceConnectorOriginationRequest
      ): F[DeleteVoiceConnectorOriginationResponse]

      def deleteVoiceConnectorProxy(
        request: DeleteVoiceConnectorProxyRequest
      ): F[DeleteVoiceConnectorProxyResponse]

      def deleteVoiceConnectorStreamingConfiguration(
        request: DeleteVoiceConnectorStreamingConfigurationRequest
      ): F[DeleteVoiceConnectorStreamingConfigurationResponse]

      def deleteVoiceConnectorTermination(
        request: DeleteVoiceConnectorTerminationRequest
      ): F[DeleteVoiceConnectorTerminationResponse]

      def deleteVoiceConnectorTerminationCredentials(
        request: DeleteVoiceConnectorTerminationCredentialsRequest
      ): F[DeleteVoiceConnectorTerminationCredentialsResponse]

      def describeAppInstance(
        request: DescribeAppInstanceRequest
      ): F[DescribeAppInstanceResponse]

      def describeAppInstanceAdmin(
        request: DescribeAppInstanceAdminRequest
      ): F[DescribeAppInstanceAdminResponse]

      def describeAppInstanceUser(
        request: DescribeAppInstanceUserRequest
      ): F[DescribeAppInstanceUserResponse]

      def describeChannel(
        request: DescribeChannelRequest
      ): F[DescribeChannelResponse]

      def describeChannelBan(
        request: DescribeChannelBanRequest
      ): F[DescribeChannelBanResponse]

      def describeChannelMembership(
        request: DescribeChannelMembershipRequest
      ): F[DescribeChannelMembershipResponse]

      def describeChannelMembershipForAppInstanceUser(
        request: DescribeChannelMembershipForAppInstanceUserRequest
      ): F[DescribeChannelMembershipForAppInstanceUserResponse]

      def describeChannelModeratedByAppInstanceUser(
        request: DescribeChannelModeratedByAppInstanceUserRequest
      ): F[DescribeChannelModeratedByAppInstanceUserResponse]

      def describeChannelModerator(
        request: DescribeChannelModeratorRequest
      ): F[DescribeChannelModeratorResponse]

      def disassociatePhoneNumberFromUser(
        request: DisassociatePhoneNumberFromUserRequest
      ): F[DisassociatePhoneNumberFromUserResponse]

      def disassociatePhoneNumbersFromVoiceConnector(
        request: DisassociatePhoneNumbersFromVoiceConnectorRequest
      ): F[DisassociatePhoneNumbersFromVoiceConnectorResponse]

      def disassociatePhoneNumbersFromVoiceConnectorGroup(
        request: DisassociatePhoneNumbersFromVoiceConnectorGroupRequest
      ): F[DisassociatePhoneNumbersFromVoiceConnectorGroupResponse]

      def disassociateSigninDelegateGroupsFromAccount(
        request: DisassociateSigninDelegateGroupsFromAccountRequest
      ): F[DisassociateSigninDelegateGroupsFromAccountResponse]

      def getAccount(
        request: GetAccountRequest
      ): F[GetAccountResponse]

      def getAccountSettings(
        request: GetAccountSettingsRequest
      ): F[GetAccountSettingsResponse]

      def getAppInstanceRetentionSettings(
        request: GetAppInstanceRetentionSettingsRequest
      ): F[GetAppInstanceRetentionSettingsResponse]

      def getAppInstanceStreamingConfigurations(
        request: GetAppInstanceStreamingConfigurationsRequest
      ): F[GetAppInstanceStreamingConfigurationsResponse]

      def getAttendee(
        request: GetAttendeeRequest
      ): F[GetAttendeeResponse]

      def getBot(
        request: GetBotRequest
      ): F[GetBotResponse]

      def getChannelMessage(
        request: GetChannelMessageRequest
      ): F[GetChannelMessageResponse]

      def getEventsConfiguration(
        request: GetEventsConfigurationRequest
      ): F[GetEventsConfigurationResponse]

      def getGlobalSettings(
        request: GetGlobalSettingsRequest
      ): F[GetGlobalSettingsResponse]

      def getMeeting(
        request: GetMeetingRequest
      ): F[GetMeetingResponse]

      def getMessagingSessionEndpoint(
        request: GetMessagingSessionEndpointRequest
      ): F[GetMessagingSessionEndpointResponse]

      def getPhoneNumber(
        request: GetPhoneNumberRequest
      ): F[GetPhoneNumberResponse]

      def getPhoneNumberOrder(
        request: GetPhoneNumberOrderRequest
      ): F[GetPhoneNumberOrderResponse]

      def getPhoneNumberSettings(
        request: GetPhoneNumberSettingsRequest
      ): F[GetPhoneNumberSettingsResponse]

      def getProxySession(
        request: GetProxySessionRequest
      ): F[GetProxySessionResponse]

      def getRetentionSettings(
        request: GetRetentionSettingsRequest
      ): F[GetRetentionSettingsResponse]

      def getRoom(
        request: GetRoomRequest
      ): F[GetRoomResponse]

      def getSipMediaApplication(
        request: GetSipMediaApplicationRequest
      ): F[GetSipMediaApplicationResponse]

      def getSipMediaApplicationLoggingConfiguration(
        request: GetSipMediaApplicationLoggingConfigurationRequest
      ): F[GetSipMediaApplicationLoggingConfigurationResponse]

      def getSipRule(
        request: GetSipRuleRequest
      ): F[GetSipRuleResponse]

      def getUser(
        request: GetUserRequest
      ): F[GetUserResponse]

      def getUserSettings(
        request: GetUserSettingsRequest
      ): F[GetUserSettingsResponse]

      def getVoiceConnector(
        request: GetVoiceConnectorRequest
      ): F[GetVoiceConnectorResponse]

      def getVoiceConnectorEmergencyCallingConfiguration(
        request: GetVoiceConnectorEmergencyCallingConfigurationRequest
      ): F[GetVoiceConnectorEmergencyCallingConfigurationResponse]

      def getVoiceConnectorGroup(
        request: GetVoiceConnectorGroupRequest
      ): F[GetVoiceConnectorGroupResponse]

      def getVoiceConnectorLoggingConfiguration(
        request: GetVoiceConnectorLoggingConfigurationRequest
      ): F[GetVoiceConnectorLoggingConfigurationResponse]

      def getVoiceConnectorOrigination(
        request: GetVoiceConnectorOriginationRequest
      ): F[GetVoiceConnectorOriginationResponse]

      def getVoiceConnectorProxy(
        request: GetVoiceConnectorProxyRequest
      ): F[GetVoiceConnectorProxyResponse]

      def getVoiceConnectorStreamingConfiguration(
        request: GetVoiceConnectorStreamingConfigurationRequest
      ): F[GetVoiceConnectorStreamingConfigurationResponse]

      def getVoiceConnectorTermination(
        request: GetVoiceConnectorTerminationRequest
      ): F[GetVoiceConnectorTerminationResponse]

      def getVoiceConnectorTerminationHealth(
        request: GetVoiceConnectorTerminationHealthRequest
      ): F[GetVoiceConnectorTerminationHealthResponse]

      def inviteUsers(
        request: InviteUsersRequest
      ): F[InviteUsersResponse]

      def listAccounts(
        request: ListAccountsRequest
      ): F[ListAccountsResponse]

      def listAppInstanceAdmins(
        request: ListAppInstanceAdminsRequest
      ): F[ListAppInstanceAdminsResponse]

      def listAppInstanceUsers(
        request: ListAppInstanceUsersRequest
      ): F[ListAppInstanceUsersResponse]

      def listAppInstances(
        request: ListAppInstancesRequest
      ): F[ListAppInstancesResponse]

      def listAttendeeTags(
        request: ListAttendeeTagsRequest
      ): F[ListAttendeeTagsResponse]

      def listAttendees(
        request: ListAttendeesRequest
      ): F[ListAttendeesResponse]

      def listBots(
        request: ListBotsRequest
      ): F[ListBotsResponse]

      def listChannelBans(
        request: ListChannelBansRequest
      ): F[ListChannelBansResponse]

      def listChannelMemberships(
        request: ListChannelMembershipsRequest
      ): F[ListChannelMembershipsResponse]

      def listChannelMembershipsForAppInstanceUser(
        request: ListChannelMembershipsForAppInstanceUserRequest
      ): F[ListChannelMembershipsForAppInstanceUserResponse]

      def listChannelMessages(
        request: ListChannelMessagesRequest
      ): F[ListChannelMessagesResponse]

      def listChannelModerators(
        request: ListChannelModeratorsRequest
      ): F[ListChannelModeratorsResponse]

      def listChannels(
        request: ListChannelsRequest
      ): F[ListChannelsResponse]

      def listChannelsModeratedByAppInstanceUser(
        request: ListChannelsModeratedByAppInstanceUserRequest
      ): F[ListChannelsModeratedByAppInstanceUserResponse]

      def listMeetingTags(
        request: ListMeetingTagsRequest
      ): F[ListMeetingTagsResponse]

      def listMeetings(
        request: ListMeetingsRequest
      ): F[ListMeetingsResponse]

      def listPhoneNumberOrders(
        request: ListPhoneNumberOrdersRequest
      ): F[ListPhoneNumberOrdersResponse]

      def listPhoneNumbers(
        request: ListPhoneNumbersRequest
      ): F[ListPhoneNumbersResponse]

      def listProxySessions(
        request: ListProxySessionsRequest
      ): F[ListProxySessionsResponse]

      def listRoomMemberships(
        request: ListRoomMembershipsRequest
      ): F[ListRoomMembershipsResponse]

      def listRooms(
        request: ListRoomsRequest
      ): F[ListRoomsResponse]

      def listSipMediaApplications(
        request: ListSipMediaApplicationsRequest
      ): F[ListSipMediaApplicationsResponse]

      def listSipRules(
        request: ListSipRulesRequest
      ): F[ListSipRulesResponse]

      def listSupportedPhoneNumberCountries(
        request: ListSupportedPhoneNumberCountriesRequest
      ): F[ListSupportedPhoneNumberCountriesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def listVoiceConnectorGroups(
        request: ListVoiceConnectorGroupsRequest
      ): F[ListVoiceConnectorGroupsResponse]

      def listVoiceConnectorTerminationCredentials(
        request: ListVoiceConnectorTerminationCredentialsRequest
      ): F[ListVoiceConnectorTerminationCredentialsResponse]

      def listVoiceConnectors(
        request: ListVoiceConnectorsRequest
      ): F[ListVoiceConnectorsResponse]

      def logoutUser(
        request: LogoutUserRequest
      ): F[LogoutUserResponse]

      def putAppInstanceRetentionSettings(
        request: PutAppInstanceRetentionSettingsRequest
      ): F[PutAppInstanceRetentionSettingsResponse]

      def putAppInstanceStreamingConfigurations(
        request: PutAppInstanceStreamingConfigurationsRequest
      ): F[PutAppInstanceStreamingConfigurationsResponse]

      def putEventsConfiguration(
        request: PutEventsConfigurationRequest
      ): F[PutEventsConfigurationResponse]

      def putRetentionSettings(
        request: PutRetentionSettingsRequest
      ): F[PutRetentionSettingsResponse]

      def putSipMediaApplicationLoggingConfiguration(
        request: PutSipMediaApplicationLoggingConfigurationRequest
      ): F[PutSipMediaApplicationLoggingConfigurationResponse]

      def putVoiceConnectorEmergencyCallingConfiguration(
        request: PutVoiceConnectorEmergencyCallingConfigurationRequest
      ): F[PutVoiceConnectorEmergencyCallingConfigurationResponse]

      def putVoiceConnectorLoggingConfiguration(
        request: PutVoiceConnectorLoggingConfigurationRequest
      ): F[PutVoiceConnectorLoggingConfigurationResponse]

      def putVoiceConnectorOrigination(
        request: PutVoiceConnectorOriginationRequest
      ): F[PutVoiceConnectorOriginationResponse]

      def putVoiceConnectorProxy(
        request: PutVoiceConnectorProxyRequest
      ): F[PutVoiceConnectorProxyResponse]

      def putVoiceConnectorStreamingConfiguration(
        request: PutVoiceConnectorStreamingConfigurationRequest
      ): F[PutVoiceConnectorStreamingConfigurationResponse]

      def putVoiceConnectorTermination(
        request: PutVoiceConnectorTerminationRequest
      ): F[PutVoiceConnectorTerminationResponse]

      def putVoiceConnectorTerminationCredentials(
        request: PutVoiceConnectorTerminationCredentialsRequest
      ): F[PutVoiceConnectorTerminationCredentialsResponse]

      def redactChannelMessage(
        request: RedactChannelMessageRequest
      ): F[RedactChannelMessageResponse]

      def redactConversationMessage(
        request: RedactConversationMessageRequest
      ): F[RedactConversationMessageResponse]

      def redactRoomMessage(
        request: RedactRoomMessageRequest
      ): F[RedactRoomMessageResponse]

      def regenerateSecurityToken(
        request: RegenerateSecurityTokenRequest
      ): F[RegenerateSecurityTokenResponse]

      def resetPersonalPIN(
        request: ResetPersonalPinRequest
      ): F[ResetPersonalPinResponse]

      def restorePhoneNumber(
        request: RestorePhoneNumberRequest
      ): F[RestorePhoneNumberResponse]

      def searchAvailablePhoneNumbers(
        request: SearchAvailablePhoneNumbersRequest
      ): F[SearchAvailablePhoneNumbersResponse]

      def sendChannelMessage(
        request: SendChannelMessageRequest
      ): F[SendChannelMessageResponse]

      def tagAttendee(
        request: TagAttendeeRequest
      ): F[TagAttendeeResponse]

      def tagMeeting(
        request: TagMeetingRequest
      ): F[TagMeetingResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagAttendee(
        request: UntagAttendeeRequest
      ): F[UntagAttendeeResponse]

      def untagMeeting(
        request: UntagMeetingRequest
      ): F[UntagMeetingResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAccount(
        request: UpdateAccountRequest
      ): F[UpdateAccountResponse]

      def updateAccountSettings(
        request: UpdateAccountSettingsRequest
      ): F[UpdateAccountSettingsResponse]

      def updateAppInstance(
        request: UpdateAppInstanceRequest
      ): F[UpdateAppInstanceResponse]

      def updateAppInstanceUser(
        request: UpdateAppInstanceUserRequest
      ): F[UpdateAppInstanceUserResponse]

      def updateBot(
        request: UpdateBotRequest
      ): F[UpdateBotResponse]

      def updateChannel(
        request: UpdateChannelRequest
      ): F[UpdateChannelResponse]

      def updateChannelMessage(
        request: UpdateChannelMessageRequest
      ): F[UpdateChannelMessageResponse]

      def updateChannelReadMarker(
        request: UpdateChannelReadMarkerRequest
      ): F[UpdateChannelReadMarkerResponse]

      def updateGlobalSettings(
        request: UpdateGlobalSettingsRequest
      ): F[UpdateGlobalSettingsResponse]

      def updatePhoneNumber(
        request: UpdatePhoneNumberRequest
      ): F[UpdatePhoneNumberResponse]

      def updatePhoneNumberSettings(
        request: UpdatePhoneNumberSettingsRequest
      ): F[UpdatePhoneNumberSettingsResponse]

      def updateProxySession(
        request: UpdateProxySessionRequest
      ): F[UpdateProxySessionResponse]

      def updateRoom(
        request: UpdateRoomRequest
      ): F[UpdateRoomResponse]

      def updateRoomMembership(
        request: UpdateRoomMembershipRequest
      ): F[UpdateRoomMembershipResponse]

      def updateSipMediaApplication(
        request: UpdateSipMediaApplicationRequest
      ): F[UpdateSipMediaApplicationResponse]

      def updateSipRule(
        request: UpdateSipRuleRequest
      ): F[UpdateSipRuleResponse]

      def updateUser(
        request: UpdateUserRequest
      ): F[UpdateUserResponse]

      def updateUserSettings(
        request: UpdateUserSettingsRequest
      ): F[UpdateUserSettingsResponse]

      def updateVoiceConnector(
        request: UpdateVoiceConnectorRequest
      ): F[UpdateVoiceConnectorResponse]

      def updateVoiceConnectorGroup(
        request: UpdateVoiceConnectorGroupRequest
      ): F[UpdateVoiceConnectorGroupResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ChimeOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociatePhoneNumberWithUserOp(
      request: AssociatePhoneNumberWithUserRequest
    ) extends ChimeOp[AssociatePhoneNumberWithUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociatePhoneNumberWithUserResponse] =
        visitor.associatePhoneNumberWithUser(request)
    }

    final case class AssociatePhoneNumbersWithVoiceConnectorOp(
      request: AssociatePhoneNumbersWithVoiceConnectorRequest
    ) extends ChimeOp[AssociatePhoneNumbersWithVoiceConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociatePhoneNumbersWithVoiceConnectorResponse] =
        visitor.associatePhoneNumbersWithVoiceConnector(request)
    }

    final case class AssociatePhoneNumbersWithVoiceConnectorGroupOp(
      request: AssociatePhoneNumbersWithVoiceConnectorGroupRequest
    ) extends ChimeOp[AssociatePhoneNumbersWithVoiceConnectorGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociatePhoneNumbersWithVoiceConnectorGroupResponse] =
        visitor.associatePhoneNumbersWithVoiceConnectorGroup(request)
    }

    final case class AssociateSigninDelegateGroupsWithAccountOp(
      request: AssociateSigninDelegateGroupsWithAccountRequest
    ) extends ChimeOp[AssociateSigninDelegateGroupsWithAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSigninDelegateGroupsWithAccountResponse] =
        visitor.associateSigninDelegateGroupsWithAccount(request)
    }

    final case class BatchCreateAttendeeOp(
      request: BatchCreateAttendeeRequest
    ) extends ChimeOp[BatchCreateAttendeeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreateAttendeeResponse] =
        visitor.batchCreateAttendee(request)
    }

    final case class BatchCreateChannelMembershipOp(
      request: BatchCreateChannelMembershipRequest
    ) extends ChimeOp[BatchCreateChannelMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreateChannelMembershipResponse] =
        visitor.batchCreateChannelMembership(request)
    }

    final case class BatchCreateRoomMembershipOp(
      request: BatchCreateRoomMembershipRequest
    ) extends ChimeOp[BatchCreateRoomMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchCreateRoomMembershipResponse] =
        visitor.batchCreateRoomMembership(request)
    }

    final case class BatchDeletePhoneNumberOp(
      request: BatchDeletePhoneNumberRequest
    ) extends ChimeOp[BatchDeletePhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchDeletePhoneNumberResponse] =
        visitor.batchDeletePhoneNumber(request)
    }

    final case class BatchSuspendUserOp(
      request: BatchSuspendUserRequest
    ) extends ChimeOp[BatchSuspendUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchSuspendUserResponse] =
        visitor.batchSuspendUser(request)
    }

    final case class BatchUnsuspendUserOp(
      request: BatchUnsuspendUserRequest
    ) extends ChimeOp[BatchUnsuspendUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUnsuspendUserResponse] =
        visitor.batchUnsuspendUser(request)
    }

    final case class BatchUpdatePhoneNumberOp(
      request: BatchUpdatePhoneNumberRequest
    ) extends ChimeOp[BatchUpdatePhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdatePhoneNumberResponse] =
        visitor.batchUpdatePhoneNumber(request)
    }

    final case class BatchUpdateUserOp(
      request: BatchUpdateUserRequest
    ) extends ChimeOp[BatchUpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[BatchUpdateUserResponse] =
        visitor.batchUpdateUser(request)
    }

    final case class CreateAccountOp(
      request: CreateAccountRequest
    ) extends ChimeOp[CreateAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAccountResponse] =
        visitor.createAccount(request)
    }

    final case class CreateAppInstanceOp(
      request: CreateAppInstanceRequest
    ) extends ChimeOp[CreateAppInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppInstanceResponse] =
        visitor.createAppInstance(request)
    }

    final case class CreateAppInstanceAdminOp(
      request: CreateAppInstanceAdminRequest
    ) extends ChimeOp[CreateAppInstanceAdminResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppInstanceAdminResponse] =
        visitor.createAppInstanceAdmin(request)
    }

    final case class CreateAppInstanceUserOp(
      request: CreateAppInstanceUserRequest
    ) extends ChimeOp[CreateAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAppInstanceUserResponse] =
        visitor.createAppInstanceUser(request)
    }

    final case class CreateAttendeeOp(
      request: CreateAttendeeRequest
    ) extends ChimeOp[CreateAttendeeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAttendeeResponse] =
        visitor.createAttendee(request)
    }

    final case class CreateBotOp(
      request: CreateBotRequest
    ) extends ChimeOp[CreateBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBotResponse] =
        visitor.createBot(request)
    }

    final case class CreateChannelOp(
      request: CreateChannelRequest
    ) extends ChimeOp[CreateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelResponse] =
        visitor.createChannel(request)
    }

    final case class CreateChannelBanOp(
      request: CreateChannelBanRequest
    ) extends ChimeOp[CreateChannelBanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelBanResponse] =
        visitor.createChannelBan(request)
    }

    final case class CreateChannelMembershipOp(
      request: CreateChannelMembershipRequest
    ) extends ChimeOp[CreateChannelMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelMembershipResponse] =
        visitor.createChannelMembership(request)
    }

    final case class CreateChannelModeratorOp(
      request: CreateChannelModeratorRequest
    ) extends ChimeOp[CreateChannelModeratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateChannelModeratorResponse] =
        visitor.createChannelModerator(request)
    }

    final case class CreateMeetingOp(
      request: CreateMeetingRequest
    ) extends ChimeOp[CreateMeetingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMeetingResponse] =
        visitor.createMeeting(request)
    }

    final case class CreateMeetingDialOutOp(
      request: CreateMeetingDialOutRequest
    ) extends ChimeOp[CreateMeetingDialOutResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMeetingDialOutResponse] =
        visitor.createMeetingDialOut(request)
    }

    final case class CreateMeetingWithAttendeesOp(
      request: CreateMeetingWithAttendeesRequest
    ) extends ChimeOp[CreateMeetingWithAttendeesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMeetingWithAttendeesResponse] =
        visitor.createMeetingWithAttendees(request)
    }

    final case class CreatePhoneNumberOrderOp(
      request: CreatePhoneNumberOrderRequest
    ) extends ChimeOp[CreatePhoneNumberOrderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePhoneNumberOrderResponse] =
        visitor.createPhoneNumberOrder(request)
    }

    final case class CreateProxySessionOp(
      request: CreateProxySessionRequest
    ) extends ChimeOp[CreateProxySessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateProxySessionResponse] =
        visitor.createProxySession(request)
    }

    final case class CreateRoomOp(
      request: CreateRoomRequest
    ) extends ChimeOp[CreateRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRoomResponse] =
        visitor.createRoom(request)
    }

    final case class CreateRoomMembershipOp(
      request: CreateRoomMembershipRequest
    ) extends ChimeOp[CreateRoomMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRoomMembershipResponse] =
        visitor.createRoomMembership(request)
    }

    final case class CreateSipMediaApplicationOp(
      request: CreateSipMediaApplicationRequest
    ) extends ChimeOp[CreateSipMediaApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSipMediaApplicationResponse] =
        visitor.createSipMediaApplication(request)
    }

    final case class CreateSipMediaApplicationCallOp(
      request: CreateSipMediaApplicationCallRequest
    ) extends ChimeOp[CreateSipMediaApplicationCallResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSipMediaApplicationCallResponse] =
        visitor.createSipMediaApplicationCall(request)
    }

    final case class CreateSipRuleOp(
      request: CreateSipRuleRequest
    ) extends ChimeOp[CreateSipRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateSipRuleResponse] =
        visitor.createSipRule(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends ChimeOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class CreateVoiceConnectorOp(
      request: CreateVoiceConnectorRequest
    ) extends ChimeOp[CreateVoiceConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVoiceConnectorResponse] =
        visitor.createVoiceConnector(request)
    }

    final case class CreateVoiceConnectorGroupOp(
      request: CreateVoiceConnectorGroupRequest
    ) extends ChimeOp[CreateVoiceConnectorGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVoiceConnectorGroupResponse] =
        visitor.createVoiceConnectorGroup(request)
    }

    final case class DeleteAccountOp(
      request: DeleteAccountRequest
    ) extends ChimeOp[DeleteAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAccountResponse] =
        visitor.deleteAccount(request)
    }

    final case class DeleteAppInstanceOp(
      request: DeleteAppInstanceRequest
    ) extends ChimeOp[DeleteAppInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppInstanceResponse] =
        visitor.deleteAppInstance(request)
    }

    final case class DeleteAppInstanceAdminOp(
      request: DeleteAppInstanceAdminRequest
    ) extends ChimeOp[DeleteAppInstanceAdminResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppInstanceAdminResponse] =
        visitor.deleteAppInstanceAdmin(request)
    }

    final case class DeleteAppInstanceStreamingConfigurationsOp(
      request: DeleteAppInstanceStreamingConfigurationsRequest
    ) extends ChimeOp[DeleteAppInstanceStreamingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppInstanceStreamingConfigurationsResponse] =
        visitor.deleteAppInstanceStreamingConfigurations(request)
    }

    final case class DeleteAppInstanceUserOp(
      request: DeleteAppInstanceUserRequest
    ) extends ChimeOp[DeleteAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAppInstanceUserResponse] =
        visitor.deleteAppInstanceUser(request)
    }

    final case class DeleteAttendeeOp(
      request: DeleteAttendeeRequest
    ) extends ChimeOp[DeleteAttendeeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAttendeeResponse] =
        visitor.deleteAttendee(request)
    }

    final case class DeleteChannelOp(
      request: DeleteChannelRequest
    ) extends ChimeOp[DeleteChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelResponse] =
        visitor.deleteChannel(request)
    }

    final case class DeleteChannelBanOp(
      request: DeleteChannelBanRequest
    ) extends ChimeOp[DeleteChannelBanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelBanResponse] =
        visitor.deleteChannelBan(request)
    }

    final case class DeleteChannelMembershipOp(
      request: DeleteChannelMembershipRequest
    ) extends ChimeOp[DeleteChannelMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelMembershipResponse] =
        visitor.deleteChannelMembership(request)
    }

    final case class DeleteChannelMessageOp(
      request: DeleteChannelMessageRequest
    ) extends ChimeOp[DeleteChannelMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelMessageResponse] =
        visitor.deleteChannelMessage(request)
    }

    final case class DeleteChannelModeratorOp(
      request: DeleteChannelModeratorRequest
    ) extends ChimeOp[DeleteChannelModeratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteChannelModeratorResponse] =
        visitor.deleteChannelModerator(request)
    }

    final case class DeleteEventsConfigurationOp(
      request: DeleteEventsConfigurationRequest
    ) extends ChimeOp[DeleteEventsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteEventsConfigurationResponse] =
        visitor.deleteEventsConfiguration(request)
    }

    final case class DeleteMeetingOp(
      request: DeleteMeetingRequest
    ) extends ChimeOp[DeleteMeetingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMeetingResponse] =
        visitor.deleteMeeting(request)
    }

    final case class DeletePhoneNumberOp(
      request: DeletePhoneNumberRequest
    ) extends ChimeOp[DeletePhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeletePhoneNumberResponse] =
        visitor.deletePhoneNumber(request)
    }

    final case class DeleteProxySessionOp(
      request: DeleteProxySessionRequest
    ) extends ChimeOp[DeleteProxySessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteProxySessionResponse] =
        visitor.deleteProxySession(request)
    }

    final case class DeleteRoomOp(
      request: DeleteRoomRequest
    ) extends ChimeOp[DeleteRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRoomResponse] =
        visitor.deleteRoom(request)
    }

    final case class DeleteRoomMembershipOp(
      request: DeleteRoomMembershipRequest
    ) extends ChimeOp[DeleteRoomMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteRoomMembershipResponse] =
        visitor.deleteRoomMembership(request)
    }

    final case class DeleteSipMediaApplicationOp(
      request: DeleteSipMediaApplicationRequest
    ) extends ChimeOp[DeleteSipMediaApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSipMediaApplicationResponse] =
        visitor.deleteSipMediaApplication(request)
    }

    final case class DeleteSipRuleOp(
      request: DeleteSipRuleRequest
    ) extends ChimeOp[DeleteSipRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteSipRuleResponse] =
        visitor.deleteSipRule(request)
    }

    final case class DeleteVoiceConnectorOp(
      request: DeleteVoiceConnectorRequest
    ) extends ChimeOp[DeleteVoiceConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorResponse] =
        visitor.deleteVoiceConnector(request)
    }

    final case class DeleteVoiceConnectorEmergencyCallingConfigurationOp(
      request: DeleteVoiceConnectorEmergencyCallingConfigurationRequest
    ) extends ChimeOp[DeleteVoiceConnectorEmergencyCallingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorEmergencyCallingConfigurationResponse] =
        visitor.deleteVoiceConnectorEmergencyCallingConfiguration(request)
    }

    final case class DeleteVoiceConnectorGroupOp(
      request: DeleteVoiceConnectorGroupRequest
    ) extends ChimeOp[DeleteVoiceConnectorGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorGroupResponse] =
        visitor.deleteVoiceConnectorGroup(request)
    }

    final case class DeleteVoiceConnectorOriginationOp(
      request: DeleteVoiceConnectorOriginationRequest
    ) extends ChimeOp[DeleteVoiceConnectorOriginationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorOriginationResponse] =
        visitor.deleteVoiceConnectorOrigination(request)
    }

    final case class DeleteVoiceConnectorProxyOp(
      request: DeleteVoiceConnectorProxyRequest
    ) extends ChimeOp[DeleteVoiceConnectorProxyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorProxyResponse] =
        visitor.deleteVoiceConnectorProxy(request)
    }

    final case class DeleteVoiceConnectorStreamingConfigurationOp(
      request: DeleteVoiceConnectorStreamingConfigurationRequest
    ) extends ChimeOp[DeleteVoiceConnectorStreamingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorStreamingConfigurationResponse] =
        visitor.deleteVoiceConnectorStreamingConfiguration(request)
    }

    final case class DeleteVoiceConnectorTerminationOp(
      request: DeleteVoiceConnectorTerminationRequest
    ) extends ChimeOp[DeleteVoiceConnectorTerminationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorTerminationResponse] =
        visitor.deleteVoiceConnectorTermination(request)
    }

    final case class DeleteVoiceConnectorTerminationCredentialsOp(
      request: DeleteVoiceConnectorTerminationCredentialsRequest
    ) extends ChimeOp[DeleteVoiceConnectorTerminationCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVoiceConnectorTerminationCredentialsResponse] =
        visitor.deleteVoiceConnectorTerminationCredentials(request)
    }

    final case class DescribeAppInstanceOp(
      request: DescribeAppInstanceRequest
    ) extends ChimeOp[DescribeAppInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAppInstanceResponse] =
        visitor.describeAppInstance(request)
    }

    final case class DescribeAppInstanceAdminOp(
      request: DescribeAppInstanceAdminRequest
    ) extends ChimeOp[DescribeAppInstanceAdminResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAppInstanceAdminResponse] =
        visitor.describeAppInstanceAdmin(request)
    }

    final case class DescribeAppInstanceUserOp(
      request: DescribeAppInstanceUserRequest
    ) extends ChimeOp[DescribeAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAppInstanceUserResponse] =
        visitor.describeAppInstanceUser(request)
    }

    final case class DescribeChannelOp(
      request: DescribeChannelRequest
    ) extends ChimeOp[DescribeChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelResponse] =
        visitor.describeChannel(request)
    }

    final case class DescribeChannelBanOp(
      request: DescribeChannelBanRequest
    ) extends ChimeOp[DescribeChannelBanResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelBanResponse] =
        visitor.describeChannelBan(request)
    }

    final case class DescribeChannelMembershipOp(
      request: DescribeChannelMembershipRequest
    ) extends ChimeOp[DescribeChannelMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelMembershipResponse] =
        visitor.describeChannelMembership(request)
    }

    final case class DescribeChannelMembershipForAppInstanceUserOp(
      request: DescribeChannelMembershipForAppInstanceUserRequest
    ) extends ChimeOp[DescribeChannelMembershipForAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelMembershipForAppInstanceUserResponse] =
        visitor.describeChannelMembershipForAppInstanceUser(request)
    }

    final case class DescribeChannelModeratedByAppInstanceUserOp(
      request: DescribeChannelModeratedByAppInstanceUserRequest
    ) extends ChimeOp[DescribeChannelModeratedByAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelModeratedByAppInstanceUserResponse] =
        visitor.describeChannelModeratedByAppInstanceUser(request)
    }

    final case class DescribeChannelModeratorOp(
      request: DescribeChannelModeratorRequest
    ) extends ChimeOp[DescribeChannelModeratorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeChannelModeratorResponse] =
        visitor.describeChannelModerator(request)
    }

    final case class DisassociatePhoneNumberFromUserOp(
      request: DisassociatePhoneNumberFromUserRequest
    ) extends ChimeOp[DisassociatePhoneNumberFromUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociatePhoneNumberFromUserResponse] =
        visitor.disassociatePhoneNumberFromUser(request)
    }

    final case class DisassociatePhoneNumbersFromVoiceConnectorOp(
      request: DisassociatePhoneNumbersFromVoiceConnectorRequest
    ) extends ChimeOp[DisassociatePhoneNumbersFromVoiceConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociatePhoneNumbersFromVoiceConnectorResponse] =
        visitor.disassociatePhoneNumbersFromVoiceConnector(request)
    }

    final case class DisassociatePhoneNumbersFromVoiceConnectorGroupOp(
      request: DisassociatePhoneNumbersFromVoiceConnectorGroupRequest
    ) extends ChimeOp[DisassociatePhoneNumbersFromVoiceConnectorGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociatePhoneNumbersFromVoiceConnectorGroupResponse] =
        visitor.disassociatePhoneNumbersFromVoiceConnectorGroup(request)
    }

    final case class DisassociateSigninDelegateGroupsFromAccountOp(
      request: DisassociateSigninDelegateGroupsFromAccountRequest
    ) extends ChimeOp[DisassociateSigninDelegateGroupsFromAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSigninDelegateGroupsFromAccountResponse] =
        visitor.disassociateSigninDelegateGroupsFromAccount(request)
    }

    final case class GetAccountOp(
      request: GetAccountRequest
    ) extends ChimeOp[GetAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountResponse] =
        visitor.getAccount(request)
    }

    final case class GetAccountSettingsOp(
      request: GetAccountSettingsRequest
    ) extends ChimeOp[GetAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAccountSettingsResponse] =
        visitor.getAccountSettings(request)
    }

    final case class GetAppInstanceRetentionSettingsOp(
      request: GetAppInstanceRetentionSettingsRequest
    ) extends ChimeOp[GetAppInstanceRetentionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppInstanceRetentionSettingsResponse] =
        visitor.getAppInstanceRetentionSettings(request)
    }

    final case class GetAppInstanceStreamingConfigurationsOp(
      request: GetAppInstanceStreamingConfigurationsRequest
    ) extends ChimeOp[GetAppInstanceStreamingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAppInstanceStreamingConfigurationsResponse] =
        visitor.getAppInstanceStreamingConfigurations(request)
    }

    final case class GetAttendeeOp(
      request: GetAttendeeRequest
    ) extends ChimeOp[GetAttendeeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetAttendeeResponse] =
        visitor.getAttendee(request)
    }

    final case class GetBotOp(
      request: GetBotRequest
    ) extends ChimeOp[GetBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetBotResponse] =
        visitor.getBot(request)
    }

    final case class GetChannelMessageOp(
      request: GetChannelMessageRequest
    ) extends ChimeOp[GetChannelMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetChannelMessageResponse] =
        visitor.getChannelMessage(request)
    }

    final case class GetEventsConfigurationOp(
      request: GetEventsConfigurationRequest
    ) extends ChimeOp[GetEventsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetEventsConfigurationResponse] =
        visitor.getEventsConfiguration(request)
    }

    final case class GetGlobalSettingsOp(
      request: GetGlobalSettingsRequest
    ) extends ChimeOp[GetGlobalSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGlobalSettingsResponse] =
        visitor.getGlobalSettings(request)
    }

    final case class GetMeetingOp(
      request: GetMeetingRequest
    ) extends ChimeOp[GetMeetingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMeetingResponse] =
        visitor.getMeeting(request)
    }

    final case class GetMessagingSessionEndpointOp(
      request: GetMessagingSessionEndpointRequest
    ) extends ChimeOp[GetMessagingSessionEndpointResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMessagingSessionEndpointResponse] =
        visitor.getMessagingSessionEndpoint(request)
    }

    final case class GetPhoneNumberOp(
      request: GetPhoneNumberRequest
    ) extends ChimeOp[GetPhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPhoneNumberResponse] =
        visitor.getPhoneNumber(request)
    }

    final case class GetPhoneNumberOrderOp(
      request: GetPhoneNumberOrderRequest
    ) extends ChimeOp[GetPhoneNumberOrderResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPhoneNumberOrderResponse] =
        visitor.getPhoneNumberOrder(request)
    }

    final case class GetPhoneNumberSettingsOp(
      request: GetPhoneNumberSettingsRequest
    ) extends ChimeOp[GetPhoneNumberSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetPhoneNumberSettingsResponse] =
        visitor.getPhoneNumberSettings(request)
    }

    final case class GetProxySessionOp(
      request: GetProxySessionRequest
    ) extends ChimeOp[GetProxySessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetProxySessionResponse] =
        visitor.getProxySession(request)
    }

    final case class GetRetentionSettingsOp(
      request: GetRetentionSettingsRequest
    ) extends ChimeOp[GetRetentionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRetentionSettingsResponse] =
        visitor.getRetentionSettings(request)
    }

    final case class GetRoomOp(
      request: GetRoomRequest
    ) extends ChimeOp[GetRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetRoomResponse] =
        visitor.getRoom(request)
    }

    final case class GetSipMediaApplicationOp(
      request: GetSipMediaApplicationRequest
    ) extends ChimeOp[GetSipMediaApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSipMediaApplicationResponse] =
        visitor.getSipMediaApplication(request)
    }

    final case class GetSipMediaApplicationLoggingConfigurationOp(
      request: GetSipMediaApplicationLoggingConfigurationRequest
    ) extends ChimeOp[GetSipMediaApplicationLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSipMediaApplicationLoggingConfigurationResponse] =
        visitor.getSipMediaApplicationLoggingConfiguration(request)
    }

    final case class GetSipRuleOp(
      request: GetSipRuleRequest
    ) extends ChimeOp[GetSipRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetSipRuleResponse] =
        visitor.getSipRule(request)
    }

    final case class GetUserOp(
      request: GetUserRequest
    ) extends ChimeOp[GetUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserResponse] =
        visitor.getUser(request)
    }

    final case class GetUserSettingsOp(
      request: GetUserSettingsRequest
    ) extends ChimeOp[GetUserSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetUserSettingsResponse] =
        visitor.getUserSettings(request)
    }

    final case class GetVoiceConnectorOp(
      request: GetVoiceConnectorRequest
    ) extends ChimeOp[GetVoiceConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorResponse] =
        visitor.getVoiceConnector(request)
    }

    final case class GetVoiceConnectorEmergencyCallingConfigurationOp(
      request: GetVoiceConnectorEmergencyCallingConfigurationRequest
    ) extends ChimeOp[GetVoiceConnectorEmergencyCallingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorEmergencyCallingConfigurationResponse] =
        visitor.getVoiceConnectorEmergencyCallingConfiguration(request)
    }

    final case class GetVoiceConnectorGroupOp(
      request: GetVoiceConnectorGroupRequest
    ) extends ChimeOp[GetVoiceConnectorGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorGroupResponse] =
        visitor.getVoiceConnectorGroup(request)
    }

    final case class GetVoiceConnectorLoggingConfigurationOp(
      request: GetVoiceConnectorLoggingConfigurationRequest
    ) extends ChimeOp[GetVoiceConnectorLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorLoggingConfigurationResponse] =
        visitor.getVoiceConnectorLoggingConfiguration(request)
    }

    final case class GetVoiceConnectorOriginationOp(
      request: GetVoiceConnectorOriginationRequest
    ) extends ChimeOp[GetVoiceConnectorOriginationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorOriginationResponse] =
        visitor.getVoiceConnectorOrigination(request)
    }

    final case class GetVoiceConnectorProxyOp(
      request: GetVoiceConnectorProxyRequest
    ) extends ChimeOp[GetVoiceConnectorProxyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorProxyResponse] =
        visitor.getVoiceConnectorProxy(request)
    }

    final case class GetVoiceConnectorStreamingConfigurationOp(
      request: GetVoiceConnectorStreamingConfigurationRequest
    ) extends ChimeOp[GetVoiceConnectorStreamingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorStreamingConfigurationResponse] =
        visitor.getVoiceConnectorStreamingConfiguration(request)
    }

    final case class GetVoiceConnectorTerminationOp(
      request: GetVoiceConnectorTerminationRequest
    ) extends ChimeOp[GetVoiceConnectorTerminationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorTerminationResponse] =
        visitor.getVoiceConnectorTermination(request)
    }

    final case class GetVoiceConnectorTerminationHealthOp(
      request: GetVoiceConnectorTerminationHealthRequest
    ) extends ChimeOp[GetVoiceConnectorTerminationHealthResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetVoiceConnectorTerminationHealthResponse] =
        visitor.getVoiceConnectorTerminationHealth(request)
    }

    final case class InviteUsersOp(
      request: InviteUsersRequest
    ) extends ChimeOp[InviteUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[InviteUsersResponse] =
        visitor.inviteUsers(request)
    }

    final case class ListAccountsOp(
      request: ListAccountsRequest
    ) extends ChimeOp[ListAccountsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAccountsResponse] =
        visitor.listAccounts(request)
    }

    final case class ListAppInstanceAdminsOp(
      request: ListAppInstanceAdminsRequest
    ) extends ChimeOp[ListAppInstanceAdminsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppInstanceAdminsResponse] =
        visitor.listAppInstanceAdmins(request)
    }

    final case class ListAppInstanceUsersOp(
      request: ListAppInstanceUsersRequest
    ) extends ChimeOp[ListAppInstanceUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppInstanceUsersResponse] =
        visitor.listAppInstanceUsers(request)
    }

    final case class ListAppInstancesOp(
      request: ListAppInstancesRequest
    ) extends ChimeOp[ListAppInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAppInstancesResponse] =
        visitor.listAppInstances(request)
    }

    final case class ListAttendeeTagsOp(
      request: ListAttendeeTagsRequest
    ) extends ChimeOp[ListAttendeeTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttendeeTagsResponse] =
        visitor.listAttendeeTags(request)
    }

    final case class ListAttendeesOp(
      request: ListAttendeesRequest
    ) extends ChimeOp[ListAttendeesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAttendeesResponse] =
        visitor.listAttendees(request)
    }

    final case class ListBotsOp(
      request: ListBotsRequest
    ) extends ChimeOp[ListBotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBotsResponse] =
        visitor.listBots(request)
    }

    final case class ListChannelBansOp(
      request: ListChannelBansRequest
    ) extends ChimeOp[ListChannelBansResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelBansResponse] =
        visitor.listChannelBans(request)
    }

    final case class ListChannelMembershipsOp(
      request: ListChannelMembershipsRequest
    ) extends ChimeOp[ListChannelMembershipsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelMembershipsResponse] =
        visitor.listChannelMemberships(request)
    }

    final case class ListChannelMembershipsForAppInstanceUserOp(
      request: ListChannelMembershipsForAppInstanceUserRequest
    ) extends ChimeOp[ListChannelMembershipsForAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelMembershipsForAppInstanceUserResponse] =
        visitor.listChannelMembershipsForAppInstanceUser(request)
    }

    final case class ListChannelMessagesOp(
      request: ListChannelMessagesRequest
    ) extends ChimeOp[ListChannelMessagesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelMessagesResponse] =
        visitor.listChannelMessages(request)
    }

    final case class ListChannelModeratorsOp(
      request: ListChannelModeratorsRequest
    ) extends ChimeOp[ListChannelModeratorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelModeratorsResponse] =
        visitor.listChannelModerators(request)
    }

    final case class ListChannelsOp(
      request: ListChannelsRequest
    ) extends ChimeOp[ListChannelsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsResponse] =
        visitor.listChannels(request)
    }

    final case class ListChannelsModeratedByAppInstanceUserOp(
      request: ListChannelsModeratedByAppInstanceUserRequest
    ) extends ChimeOp[ListChannelsModeratedByAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListChannelsModeratedByAppInstanceUserResponse] =
        visitor.listChannelsModeratedByAppInstanceUser(request)
    }

    final case class ListMeetingTagsOp(
      request: ListMeetingTagsRequest
    ) extends ChimeOp[ListMeetingTagsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMeetingTagsResponse] =
        visitor.listMeetingTags(request)
    }

    final case class ListMeetingsOp(
      request: ListMeetingsRequest
    ) extends ChimeOp[ListMeetingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListMeetingsResponse] =
        visitor.listMeetings(request)
    }

    final case class ListPhoneNumberOrdersOp(
      request: ListPhoneNumberOrdersRequest
    ) extends ChimeOp[ListPhoneNumberOrdersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPhoneNumberOrdersResponse] =
        visitor.listPhoneNumberOrders(request)
    }

    final case class ListPhoneNumbersOp(
      request: ListPhoneNumbersRequest
    ) extends ChimeOp[ListPhoneNumbersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPhoneNumbersResponse] =
        visitor.listPhoneNumbers(request)
    }

    final case class ListProxySessionsOp(
      request: ListProxySessionsRequest
    ) extends ChimeOp[ListProxySessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListProxySessionsResponse] =
        visitor.listProxySessions(request)
    }

    final case class ListRoomMembershipsOp(
      request: ListRoomMembershipsRequest
    ) extends ChimeOp[ListRoomMembershipsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoomMembershipsResponse] =
        visitor.listRoomMemberships(request)
    }

    final case class ListRoomsOp(
      request: ListRoomsRequest
    ) extends ChimeOp[ListRoomsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoomsResponse] =
        visitor.listRooms(request)
    }

    final case class ListSipMediaApplicationsOp(
      request: ListSipMediaApplicationsRequest
    ) extends ChimeOp[ListSipMediaApplicationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSipMediaApplicationsResponse] =
        visitor.listSipMediaApplications(request)
    }

    final case class ListSipRulesOp(
      request: ListSipRulesRequest
    ) extends ChimeOp[ListSipRulesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSipRulesResponse] =
        visitor.listSipRules(request)
    }

    final case class ListSupportedPhoneNumberCountriesOp(
      request: ListSupportedPhoneNumberCountriesRequest
    ) extends ChimeOp[ListSupportedPhoneNumberCountriesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSupportedPhoneNumberCountriesResponse] =
        visitor.listSupportedPhoneNumberCountries(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ChimeOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends ChimeOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class ListVoiceConnectorGroupsOp(
      request: ListVoiceConnectorGroupsRequest
    ) extends ChimeOp[ListVoiceConnectorGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVoiceConnectorGroupsResponse] =
        visitor.listVoiceConnectorGroups(request)
    }

    final case class ListVoiceConnectorTerminationCredentialsOp(
      request: ListVoiceConnectorTerminationCredentialsRequest
    ) extends ChimeOp[ListVoiceConnectorTerminationCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVoiceConnectorTerminationCredentialsResponse] =
        visitor.listVoiceConnectorTerminationCredentials(request)
    }

    final case class ListVoiceConnectorsOp(
      request: ListVoiceConnectorsRequest
    ) extends ChimeOp[ListVoiceConnectorsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListVoiceConnectorsResponse] =
        visitor.listVoiceConnectors(request)
    }

    final case class LogoutUserOp(
      request: LogoutUserRequest
    ) extends ChimeOp[LogoutUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[LogoutUserResponse] =
        visitor.logoutUser(request)
    }

    final case class PutAppInstanceRetentionSettingsOp(
      request: PutAppInstanceRetentionSettingsRequest
    ) extends ChimeOp[PutAppInstanceRetentionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAppInstanceRetentionSettingsResponse] =
        visitor.putAppInstanceRetentionSettings(request)
    }

    final case class PutAppInstanceStreamingConfigurationsOp(
      request: PutAppInstanceStreamingConfigurationsRequest
    ) extends ChimeOp[PutAppInstanceStreamingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutAppInstanceStreamingConfigurationsResponse] =
        visitor.putAppInstanceStreamingConfigurations(request)
    }

    final case class PutEventsConfigurationOp(
      request: PutEventsConfigurationRequest
    ) extends ChimeOp[PutEventsConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutEventsConfigurationResponse] =
        visitor.putEventsConfiguration(request)
    }

    final case class PutRetentionSettingsOp(
      request: PutRetentionSettingsRequest
    ) extends ChimeOp[PutRetentionSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutRetentionSettingsResponse] =
        visitor.putRetentionSettings(request)
    }

    final case class PutSipMediaApplicationLoggingConfigurationOp(
      request: PutSipMediaApplicationLoggingConfigurationRequest
    ) extends ChimeOp[PutSipMediaApplicationLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutSipMediaApplicationLoggingConfigurationResponse] =
        visitor.putSipMediaApplicationLoggingConfiguration(request)
    }

    final case class PutVoiceConnectorEmergencyCallingConfigurationOp(
      request: PutVoiceConnectorEmergencyCallingConfigurationRequest
    ) extends ChimeOp[PutVoiceConnectorEmergencyCallingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorEmergencyCallingConfigurationResponse] =
        visitor.putVoiceConnectorEmergencyCallingConfiguration(request)
    }

    final case class PutVoiceConnectorLoggingConfigurationOp(
      request: PutVoiceConnectorLoggingConfigurationRequest
    ) extends ChimeOp[PutVoiceConnectorLoggingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorLoggingConfigurationResponse] =
        visitor.putVoiceConnectorLoggingConfiguration(request)
    }

    final case class PutVoiceConnectorOriginationOp(
      request: PutVoiceConnectorOriginationRequest
    ) extends ChimeOp[PutVoiceConnectorOriginationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorOriginationResponse] =
        visitor.putVoiceConnectorOrigination(request)
    }

    final case class PutVoiceConnectorProxyOp(
      request: PutVoiceConnectorProxyRequest
    ) extends ChimeOp[PutVoiceConnectorProxyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorProxyResponse] =
        visitor.putVoiceConnectorProxy(request)
    }

    final case class PutVoiceConnectorStreamingConfigurationOp(
      request: PutVoiceConnectorStreamingConfigurationRequest
    ) extends ChimeOp[PutVoiceConnectorStreamingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorStreamingConfigurationResponse] =
        visitor.putVoiceConnectorStreamingConfiguration(request)
    }

    final case class PutVoiceConnectorTerminationOp(
      request: PutVoiceConnectorTerminationRequest
    ) extends ChimeOp[PutVoiceConnectorTerminationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorTerminationResponse] =
        visitor.putVoiceConnectorTermination(request)
    }

    final case class PutVoiceConnectorTerminationCredentialsOp(
      request: PutVoiceConnectorTerminationCredentialsRequest
    ) extends ChimeOp[PutVoiceConnectorTerminationCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutVoiceConnectorTerminationCredentialsResponse] =
        visitor.putVoiceConnectorTerminationCredentials(request)
    }

    final case class RedactChannelMessageOp(
      request: RedactChannelMessageRequest
    ) extends ChimeOp[RedactChannelMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RedactChannelMessageResponse] =
        visitor.redactChannelMessage(request)
    }

    final case class RedactConversationMessageOp(
      request: RedactConversationMessageRequest
    ) extends ChimeOp[RedactConversationMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RedactConversationMessageResponse] =
        visitor.redactConversationMessage(request)
    }

    final case class RedactRoomMessageOp(
      request: RedactRoomMessageRequest
    ) extends ChimeOp[RedactRoomMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RedactRoomMessageResponse] =
        visitor.redactRoomMessage(request)
    }

    final case class RegenerateSecurityTokenOp(
      request: RegenerateSecurityTokenRequest
    ) extends ChimeOp[RegenerateSecurityTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegenerateSecurityTokenResponse] =
        visitor.regenerateSecurityToken(request)
    }

    final case class ResetPersonalPINOp(
      request: ResetPersonalPinRequest
    ) extends ChimeOp[ResetPersonalPinResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResetPersonalPinResponse] =
        visitor.resetPersonalPIN(request)
    }

    final case class RestorePhoneNumberOp(
      request: RestorePhoneNumberRequest
    ) extends ChimeOp[RestorePhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RestorePhoneNumberResponse] =
        visitor.restorePhoneNumber(request)
    }

    final case class SearchAvailablePhoneNumbersOp(
      request: SearchAvailablePhoneNumbersRequest
    ) extends ChimeOp[SearchAvailablePhoneNumbersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchAvailablePhoneNumbersResponse] =
        visitor.searchAvailablePhoneNumbers(request)
    }

    final case class SendChannelMessageOp(
      request: SendChannelMessageRequest
    ) extends ChimeOp[SendChannelMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SendChannelMessageResponse] =
        visitor.sendChannelMessage(request)
    }

    final case class TagAttendeeOp(
      request: TagAttendeeRequest
    ) extends ChimeOp[TagAttendeeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagAttendeeResponse] =
        visitor.tagAttendee(request)
    }

    final case class TagMeetingOp(
      request: TagMeetingRequest
    ) extends ChimeOp[TagMeetingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagMeetingResponse] =
        visitor.tagMeeting(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ChimeOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagAttendeeOp(
      request: UntagAttendeeRequest
    ) extends ChimeOp[UntagAttendeeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagAttendeeResponse] =
        visitor.untagAttendee(request)
    }

    final case class UntagMeetingOp(
      request: UntagMeetingRequest
    ) extends ChimeOp[UntagMeetingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagMeetingResponse] =
        visitor.untagMeeting(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ChimeOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAccountOp(
      request: UpdateAccountRequest
    ) extends ChimeOp[UpdateAccountResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountResponse] =
        visitor.updateAccount(request)
    }

    final case class UpdateAccountSettingsOp(
      request: UpdateAccountSettingsRequest
    ) extends ChimeOp[UpdateAccountSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAccountSettingsResponse] =
        visitor.updateAccountSettings(request)
    }

    final case class UpdateAppInstanceOp(
      request: UpdateAppInstanceRequest
    ) extends ChimeOp[UpdateAppInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAppInstanceResponse] =
        visitor.updateAppInstance(request)
    }

    final case class UpdateAppInstanceUserOp(
      request: UpdateAppInstanceUserRequest
    ) extends ChimeOp[UpdateAppInstanceUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAppInstanceUserResponse] =
        visitor.updateAppInstanceUser(request)
    }

    final case class UpdateBotOp(
      request: UpdateBotRequest
    ) extends ChimeOp[UpdateBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBotResponse] =
        visitor.updateBot(request)
    }

    final case class UpdateChannelOp(
      request: UpdateChannelRequest
    ) extends ChimeOp[UpdateChannelResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelResponse] =
        visitor.updateChannel(request)
    }

    final case class UpdateChannelMessageOp(
      request: UpdateChannelMessageRequest
    ) extends ChimeOp[UpdateChannelMessageResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelMessageResponse] =
        visitor.updateChannelMessage(request)
    }

    final case class UpdateChannelReadMarkerOp(
      request: UpdateChannelReadMarkerRequest
    ) extends ChimeOp[UpdateChannelReadMarkerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateChannelReadMarkerResponse] =
        visitor.updateChannelReadMarker(request)
    }

    final case class UpdateGlobalSettingsOp(
      request: UpdateGlobalSettingsRequest
    ) extends ChimeOp[UpdateGlobalSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGlobalSettingsResponse] =
        visitor.updateGlobalSettings(request)
    }

    final case class UpdatePhoneNumberOp(
      request: UpdatePhoneNumberRequest
    ) extends ChimeOp[UpdatePhoneNumberResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePhoneNumberResponse] =
        visitor.updatePhoneNumber(request)
    }

    final case class UpdatePhoneNumberSettingsOp(
      request: UpdatePhoneNumberSettingsRequest
    ) extends ChimeOp[UpdatePhoneNumberSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdatePhoneNumberSettingsResponse] =
        visitor.updatePhoneNumberSettings(request)
    }

    final case class UpdateProxySessionOp(
      request: UpdateProxySessionRequest
    ) extends ChimeOp[UpdateProxySessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateProxySessionResponse] =
        visitor.updateProxySession(request)
    }

    final case class UpdateRoomOp(
      request: UpdateRoomRequest
    ) extends ChimeOp[UpdateRoomResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoomResponse] =
        visitor.updateRoom(request)
    }

    final case class UpdateRoomMembershipOp(
      request: UpdateRoomMembershipRequest
    ) extends ChimeOp[UpdateRoomMembershipResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoomMembershipResponse] =
        visitor.updateRoomMembership(request)
    }

    final case class UpdateSipMediaApplicationOp(
      request: UpdateSipMediaApplicationRequest
    ) extends ChimeOp[UpdateSipMediaApplicationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSipMediaApplicationResponse] =
        visitor.updateSipMediaApplication(request)
    }

    final case class UpdateSipRuleOp(
      request: UpdateSipRuleRequest
    ) extends ChimeOp[UpdateSipRuleResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateSipRuleResponse] =
        visitor.updateSipRule(request)
    }

    final case class UpdateUserOp(
      request: UpdateUserRequest
    ) extends ChimeOp[UpdateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserResponse] =
        visitor.updateUser(request)
    }

    final case class UpdateUserSettingsOp(
      request: UpdateUserSettingsRequest
    ) extends ChimeOp[UpdateUserSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserSettingsResponse] =
        visitor.updateUserSettings(request)
    }

    final case class UpdateVoiceConnectorOp(
      request: UpdateVoiceConnectorRequest
    ) extends ChimeOp[UpdateVoiceConnectorResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVoiceConnectorResponse] =
        visitor.updateVoiceConnector(request)
    }

    final case class UpdateVoiceConnectorGroupOp(
      request: UpdateVoiceConnectorGroupRequest
    ) extends ChimeOp[UpdateVoiceConnectorGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateVoiceConnectorGroupResponse] =
        visitor.updateVoiceConnectorGroup(request)
    }
  }

  import ChimeOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ChimeOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associatePhoneNumberWithUser(
    request: AssociatePhoneNumberWithUserRequest
  ): ChimeIO[AssociatePhoneNumberWithUserResponse] =
    FF.liftF(AssociatePhoneNumberWithUserOp(request))

  def associatePhoneNumbersWithVoiceConnector(
    request: AssociatePhoneNumbersWithVoiceConnectorRequest
  ): ChimeIO[AssociatePhoneNumbersWithVoiceConnectorResponse] =
    FF.liftF(AssociatePhoneNumbersWithVoiceConnectorOp(request))

  def associatePhoneNumbersWithVoiceConnectorGroup(
    request: AssociatePhoneNumbersWithVoiceConnectorGroupRequest
  ): ChimeIO[AssociatePhoneNumbersWithVoiceConnectorGroupResponse] =
    FF.liftF(AssociatePhoneNumbersWithVoiceConnectorGroupOp(request))

  def associateSigninDelegateGroupsWithAccount(
    request: AssociateSigninDelegateGroupsWithAccountRequest
  ): ChimeIO[AssociateSigninDelegateGroupsWithAccountResponse] =
    FF.liftF(AssociateSigninDelegateGroupsWithAccountOp(request))

  def batchCreateAttendee(
    request: BatchCreateAttendeeRequest
  ): ChimeIO[BatchCreateAttendeeResponse] =
    FF.liftF(BatchCreateAttendeeOp(request))

  def batchCreateChannelMembership(
    request: BatchCreateChannelMembershipRequest
  ): ChimeIO[BatchCreateChannelMembershipResponse] =
    FF.liftF(BatchCreateChannelMembershipOp(request))

  def batchCreateRoomMembership(
    request: BatchCreateRoomMembershipRequest
  ): ChimeIO[BatchCreateRoomMembershipResponse] =
    FF.liftF(BatchCreateRoomMembershipOp(request))

  def batchDeletePhoneNumber(
    request: BatchDeletePhoneNumberRequest
  ): ChimeIO[BatchDeletePhoneNumberResponse] =
    FF.liftF(BatchDeletePhoneNumberOp(request))

  def batchSuspendUser(
    request: BatchSuspendUserRequest
  ): ChimeIO[BatchSuspendUserResponse] =
    FF.liftF(BatchSuspendUserOp(request))

  def batchUnsuspendUser(
    request: BatchUnsuspendUserRequest
  ): ChimeIO[BatchUnsuspendUserResponse] =
    FF.liftF(BatchUnsuspendUserOp(request))

  def batchUpdatePhoneNumber(
    request: BatchUpdatePhoneNumberRequest
  ): ChimeIO[BatchUpdatePhoneNumberResponse] =
    FF.liftF(BatchUpdatePhoneNumberOp(request))

  def batchUpdateUser(
    request: BatchUpdateUserRequest
  ): ChimeIO[BatchUpdateUserResponse] =
    FF.liftF(BatchUpdateUserOp(request))

  def createAccount(
    request: CreateAccountRequest
  ): ChimeIO[CreateAccountResponse] =
    FF.liftF(CreateAccountOp(request))

  def createAppInstance(
    request: CreateAppInstanceRequest
  ): ChimeIO[CreateAppInstanceResponse] =
    FF.liftF(CreateAppInstanceOp(request))

  def createAppInstanceAdmin(
    request: CreateAppInstanceAdminRequest
  ): ChimeIO[CreateAppInstanceAdminResponse] =
    FF.liftF(CreateAppInstanceAdminOp(request))

  def createAppInstanceUser(
    request: CreateAppInstanceUserRequest
  ): ChimeIO[CreateAppInstanceUserResponse] =
    FF.liftF(CreateAppInstanceUserOp(request))

  def createAttendee(
    request: CreateAttendeeRequest
  ): ChimeIO[CreateAttendeeResponse] =
    FF.liftF(CreateAttendeeOp(request))

  def createBot(
    request: CreateBotRequest
  ): ChimeIO[CreateBotResponse] =
    FF.liftF(CreateBotOp(request))

  def createChannel(
    request: CreateChannelRequest
  ): ChimeIO[CreateChannelResponse] =
    FF.liftF(CreateChannelOp(request))

  def createChannelBan(
    request: CreateChannelBanRequest
  ): ChimeIO[CreateChannelBanResponse] =
    FF.liftF(CreateChannelBanOp(request))

  def createChannelMembership(
    request: CreateChannelMembershipRequest
  ): ChimeIO[CreateChannelMembershipResponse] =
    FF.liftF(CreateChannelMembershipOp(request))

  def createChannelModerator(
    request: CreateChannelModeratorRequest
  ): ChimeIO[CreateChannelModeratorResponse] =
    FF.liftF(CreateChannelModeratorOp(request))

  def createMeeting(
    request: CreateMeetingRequest
  ): ChimeIO[CreateMeetingResponse] =
    FF.liftF(CreateMeetingOp(request))

  def createMeetingDialOut(
    request: CreateMeetingDialOutRequest
  ): ChimeIO[CreateMeetingDialOutResponse] =
    FF.liftF(CreateMeetingDialOutOp(request))

  def createMeetingWithAttendees(
    request: CreateMeetingWithAttendeesRequest
  ): ChimeIO[CreateMeetingWithAttendeesResponse] =
    FF.liftF(CreateMeetingWithAttendeesOp(request))

  def createPhoneNumberOrder(
    request: CreatePhoneNumberOrderRequest
  ): ChimeIO[CreatePhoneNumberOrderResponse] =
    FF.liftF(CreatePhoneNumberOrderOp(request))

  def createProxySession(
    request: CreateProxySessionRequest
  ): ChimeIO[CreateProxySessionResponse] =
    FF.liftF(CreateProxySessionOp(request))

  def createRoom(
    request: CreateRoomRequest
  ): ChimeIO[CreateRoomResponse] =
    FF.liftF(CreateRoomOp(request))

  def createRoomMembership(
    request: CreateRoomMembershipRequest
  ): ChimeIO[CreateRoomMembershipResponse] =
    FF.liftF(CreateRoomMembershipOp(request))

  def createSipMediaApplication(
    request: CreateSipMediaApplicationRequest
  ): ChimeIO[CreateSipMediaApplicationResponse] =
    FF.liftF(CreateSipMediaApplicationOp(request))

  def createSipMediaApplicationCall(
    request: CreateSipMediaApplicationCallRequest
  ): ChimeIO[CreateSipMediaApplicationCallResponse] =
    FF.liftF(CreateSipMediaApplicationCallOp(request))

  def createSipRule(
    request: CreateSipRuleRequest
  ): ChimeIO[CreateSipRuleResponse] =
    FF.liftF(CreateSipRuleOp(request))

  def createUser(
    request: CreateUserRequest
  ): ChimeIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def createVoiceConnector(
    request: CreateVoiceConnectorRequest
  ): ChimeIO[CreateVoiceConnectorResponse] =
    FF.liftF(CreateVoiceConnectorOp(request))

  def createVoiceConnectorGroup(
    request: CreateVoiceConnectorGroupRequest
  ): ChimeIO[CreateVoiceConnectorGroupResponse] =
    FF.liftF(CreateVoiceConnectorGroupOp(request))

  def deleteAccount(
    request: DeleteAccountRequest
  ): ChimeIO[DeleteAccountResponse] =
    FF.liftF(DeleteAccountOp(request))

  def deleteAppInstance(
    request: DeleteAppInstanceRequest
  ): ChimeIO[DeleteAppInstanceResponse] =
    FF.liftF(DeleteAppInstanceOp(request))

  def deleteAppInstanceAdmin(
    request: DeleteAppInstanceAdminRequest
  ): ChimeIO[DeleteAppInstanceAdminResponse] =
    FF.liftF(DeleteAppInstanceAdminOp(request))

  def deleteAppInstanceStreamingConfigurations(
    request: DeleteAppInstanceStreamingConfigurationsRequest
  ): ChimeIO[DeleteAppInstanceStreamingConfigurationsResponse] =
    FF.liftF(DeleteAppInstanceStreamingConfigurationsOp(request))

  def deleteAppInstanceUser(
    request: DeleteAppInstanceUserRequest
  ): ChimeIO[DeleteAppInstanceUserResponse] =
    FF.liftF(DeleteAppInstanceUserOp(request))

  def deleteAttendee(
    request: DeleteAttendeeRequest
  ): ChimeIO[DeleteAttendeeResponse] =
    FF.liftF(DeleteAttendeeOp(request))

  def deleteChannel(
    request: DeleteChannelRequest
  ): ChimeIO[DeleteChannelResponse] =
    FF.liftF(DeleteChannelOp(request))

  def deleteChannelBan(
    request: DeleteChannelBanRequest
  ): ChimeIO[DeleteChannelBanResponse] =
    FF.liftF(DeleteChannelBanOp(request))

  def deleteChannelMembership(
    request: DeleteChannelMembershipRequest
  ): ChimeIO[DeleteChannelMembershipResponse] =
    FF.liftF(DeleteChannelMembershipOp(request))

  def deleteChannelMessage(
    request: DeleteChannelMessageRequest
  ): ChimeIO[DeleteChannelMessageResponse] =
    FF.liftF(DeleteChannelMessageOp(request))

  def deleteChannelModerator(
    request: DeleteChannelModeratorRequest
  ): ChimeIO[DeleteChannelModeratorResponse] =
    FF.liftF(DeleteChannelModeratorOp(request))

  def deleteEventsConfiguration(
    request: DeleteEventsConfigurationRequest
  ): ChimeIO[DeleteEventsConfigurationResponse] =
    FF.liftF(DeleteEventsConfigurationOp(request))

  def deleteMeeting(
    request: DeleteMeetingRequest
  ): ChimeIO[DeleteMeetingResponse] =
    FF.liftF(DeleteMeetingOp(request))

  def deletePhoneNumber(
    request: DeletePhoneNumberRequest
  ): ChimeIO[DeletePhoneNumberResponse] =
    FF.liftF(DeletePhoneNumberOp(request))

  def deleteProxySession(
    request: DeleteProxySessionRequest
  ): ChimeIO[DeleteProxySessionResponse] =
    FF.liftF(DeleteProxySessionOp(request))

  def deleteRoom(
    request: DeleteRoomRequest
  ): ChimeIO[DeleteRoomResponse] =
    FF.liftF(DeleteRoomOp(request))

  def deleteRoomMembership(
    request: DeleteRoomMembershipRequest
  ): ChimeIO[DeleteRoomMembershipResponse] =
    FF.liftF(DeleteRoomMembershipOp(request))

  def deleteSipMediaApplication(
    request: DeleteSipMediaApplicationRequest
  ): ChimeIO[DeleteSipMediaApplicationResponse] =
    FF.liftF(DeleteSipMediaApplicationOp(request))

  def deleteSipRule(
    request: DeleteSipRuleRequest
  ): ChimeIO[DeleteSipRuleResponse] =
    FF.liftF(DeleteSipRuleOp(request))

  def deleteVoiceConnector(
    request: DeleteVoiceConnectorRequest
  ): ChimeIO[DeleteVoiceConnectorResponse] =
    FF.liftF(DeleteVoiceConnectorOp(request))

  def deleteVoiceConnectorEmergencyCallingConfiguration(
    request: DeleteVoiceConnectorEmergencyCallingConfigurationRequest
  ): ChimeIO[DeleteVoiceConnectorEmergencyCallingConfigurationResponse] =
    FF.liftF(DeleteVoiceConnectorEmergencyCallingConfigurationOp(request))

  def deleteVoiceConnectorGroup(
    request: DeleteVoiceConnectorGroupRequest
  ): ChimeIO[DeleteVoiceConnectorGroupResponse] =
    FF.liftF(DeleteVoiceConnectorGroupOp(request))

  def deleteVoiceConnectorOrigination(
    request: DeleteVoiceConnectorOriginationRequest
  ): ChimeIO[DeleteVoiceConnectorOriginationResponse] =
    FF.liftF(DeleteVoiceConnectorOriginationOp(request))

  def deleteVoiceConnectorProxy(
    request: DeleteVoiceConnectorProxyRequest
  ): ChimeIO[DeleteVoiceConnectorProxyResponse] =
    FF.liftF(DeleteVoiceConnectorProxyOp(request))

  def deleteVoiceConnectorStreamingConfiguration(
    request: DeleteVoiceConnectorStreamingConfigurationRequest
  ): ChimeIO[DeleteVoiceConnectorStreamingConfigurationResponse] =
    FF.liftF(DeleteVoiceConnectorStreamingConfigurationOp(request))

  def deleteVoiceConnectorTermination(
    request: DeleteVoiceConnectorTerminationRequest
  ): ChimeIO[DeleteVoiceConnectorTerminationResponse] =
    FF.liftF(DeleteVoiceConnectorTerminationOp(request))

  def deleteVoiceConnectorTerminationCredentials(
    request: DeleteVoiceConnectorTerminationCredentialsRequest
  ): ChimeIO[DeleteVoiceConnectorTerminationCredentialsResponse] =
    FF.liftF(DeleteVoiceConnectorTerminationCredentialsOp(request))

  def describeAppInstance(
    request: DescribeAppInstanceRequest
  ): ChimeIO[DescribeAppInstanceResponse] =
    FF.liftF(DescribeAppInstanceOp(request))

  def describeAppInstanceAdmin(
    request: DescribeAppInstanceAdminRequest
  ): ChimeIO[DescribeAppInstanceAdminResponse] =
    FF.liftF(DescribeAppInstanceAdminOp(request))

  def describeAppInstanceUser(
    request: DescribeAppInstanceUserRequest
  ): ChimeIO[DescribeAppInstanceUserResponse] =
    FF.liftF(DescribeAppInstanceUserOp(request))

  def describeChannel(
    request: DescribeChannelRequest
  ): ChimeIO[DescribeChannelResponse] =
    FF.liftF(DescribeChannelOp(request))

  def describeChannelBan(
    request: DescribeChannelBanRequest
  ): ChimeIO[DescribeChannelBanResponse] =
    FF.liftF(DescribeChannelBanOp(request))

  def describeChannelMembership(
    request: DescribeChannelMembershipRequest
  ): ChimeIO[DescribeChannelMembershipResponse] =
    FF.liftF(DescribeChannelMembershipOp(request))

  def describeChannelMembershipForAppInstanceUser(
    request: DescribeChannelMembershipForAppInstanceUserRequest
  ): ChimeIO[DescribeChannelMembershipForAppInstanceUserResponse] =
    FF.liftF(DescribeChannelMembershipForAppInstanceUserOp(request))

  def describeChannelModeratedByAppInstanceUser(
    request: DescribeChannelModeratedByAppInstanceUserRequest
  ): ChimeIO[DescribeChannelModeratedByAppInstanceUserResponse] =
    FF.liftF(DescribeChannelModeratedByAppInstanceUserOp(request))

  def describeChannelModerator(
    request: DescribeChannelModeratorRequest
  ): ChimeIO[DescribeChannelModeratorResponse] =
    FF.liftF(DescribeChannelModeratorOp(request))

  def disassociatePhoneNumberFromUser(
    request: DisassociatePhoneNumberFromUserRequest
  ): ChimeIO[DisassociatePhoneNumberFromUserResponse] =
    FF.liftF(DisassociatePhoneNumberFromUserOp(request))

  def disassociatePhoneNumbersFromVoiceConnector(
    request: DisassociatePhoneNumbersFromVoiceConnectorRequest
  ): ChimeIO[DisassociatePhoneNumbersFromVoiceConnectorResponse] =
    FF.liftF(DisassociatePhoneNumbersFromVoiceConnectorOp(request))

  def disassociatePhoneNumbersFromVoiceConnectorGroup(
    request: DisassociatePhoneNumbersFromVoiceConnectorGroupRequest
  ): ChimeIO[DisassociatePhoneNumbersFromVoiceConnectorGroupResponse] =
    FF.liftF(DisassociatePhoneNumbersFromVoiceConnectorGroupOp(request))

  def disassociateSigninDelegateGroupsFromAccount(
    request: DisassociateSigninDelegateGroupsFromAccountRequest
  ): ChimeIO[DisassociateSigninDelegateGroupsFromAccountResponse] =
    FF.liftF(DisassociateSigninDelegateGroupsFromAccountOp(request))

  def getAccount(
    request: GetAccountRequest
  ): ChimeIO[GetAccountResponse] =
    FF.liftF(GetAccountOp(request))

  def getAccountSettings(
    request: GetAccountSettingsRequest
  ): ChimeIO[GetAccountSettingsResponse] =
    FF.liftF(GetAccountSettingsOp(request))

  def getAppInstanceRetentionSettings(
    request: GetAppInstanceRetentionSettingsRequest
  ): ChimeIO[GetAppInstanceRetentionSettingsResponse] =
    FF.liftF(GetAppInstanceRetentionSettingsOp(request))

  def getAppInstanceStreamingConfigurations(
    request: GetAppInstanceStreamingConfigurationsRequest
  ): ChimeIO[GetAppInstanceStreamingConfigurationsResponse] =
    FF.liftF(GetAppInstanceStreamingConfigurationsOp(request))

  def getAttendee(
    request: GetAttendeeRequest
  ): ChimeIO[GetAttendeeResponse] =
    FF.liftF(GetAttendeeOp(request))

  def getBot(
    request: GetBotRequest
  ): ChimeIO[GetBotResponse] =
    FF.liftF(GetBotOp(request))

  def getChannelMessage(
    request: GetChannelMessageRequest
  ): ChimeIO[GetChannelMessageResponse] =
    FF.liftF(GetChannelMessageOp(request))

  def getEventsConfiguration(
    request: GetEventsConfigurationRequest
  ): ChimeIO[GetEventsConfigurationResponse] =
    FF.liftF(GetEventsConfigurationOp(request))

  def getGlobalSettings(
    request: GetGlobalSettingsRequest
  ): ChimeIO[GetGlobalSettingsResponse] =
    FF.liftF(GetGlobalSettingsOp(request))

  def getMeeting(
    request: GetMeetingRequest
  ): ChimeIO[GetMeetingResponse] =
    FF.liftF(GetMeetingOp(request))

  def getMessagingSessionEndpoint(
    request: GetMessagingSessionEndpointRequest
  ): ChimeIO[GetMessagingSessionEndpointResponse] =
    FF.liftF(GetMessagingSessionEndpointOp(request))

  def getPhoneNumber(
    request: GetPhoneNumberRequest
  ): ChimeIO[GetPhoneNumberResponse] =
    FF.liftF(GetPhoneNumberOp(request))

  def getPhoneNumberOrder(
    request: GetPhoneNumberOrderRequest
  ): ChimeIO[GetPhoneNumberOrderResponse] =
    FF.liftF(GetPhoneNumberOrderOp(request))

  def getPhoneNumberSettings(
    request: GetPhoneNumberSettingsRequest
  ): ChimeIO[GetPhoneNumberSettingsResponse] =
    FF.liftF(GetPhoneNumberSettingsOp(request))

  def getProxySession(
    request: GetProxySessionRequest
  ): ChimeIO[GetProxySessionResponse] =
    FF.liftF(GetProxySessionOp(request))

  def getRetentionSettings(
    request: GetRetentionSettingsRequest
  ): ChimeIO[GetRetentionSettingsResponse] =
    FF.liftF(GetRetentionSettingsOp(request))

  def getRoom(
    request: GetRoomRequest
  ): ChimeIO[GetRoomResponse] =
    FF.liftF(GetRoomOp(request))

  def getSipMediaApplication(
    request: GetSipMediaApplicationRequest
  ): ChimeIO[GetSipMediaApplicationResponse] =
    FF.liftF(GetSipMediaApplicationOp(request))

  def getSipMediaApplicationLoggingConfiguration(
    request: GetSipMediaApplicationLoggingConfigurationRequest
  ): ChimeIO[GetSipMediaApplicationLoggingConfigurationResponse] =
    FF.liftF(GetSipMediaApplicationLoggingConfigurationOp(request))

  def getSipRule(
    request: GetSipRuleRequest
  ): ChimeIO[GetSipRuleResponse] =
    FF.liftF(GetSipRuleOp(request))

  def getUser(
    request: GetUserRequest
  ): ChimeIO[GetUserResponse] =
    FF.liftF(GetUserOp(request))

  def getUserSettings(
    request: GetUserSettingsRequest
  ): ChimeIO[GetUserSettingsResponse] =
    FF.liftF(GetUserSettingsOp(request))

  def getVoiceConnector(
    request: GetVoiceConnectorRequest
  ): ChimeIO[GetVoiceConnectorResponse] =
    FF.liftF(GetVoiceConnectorOp(request))

  def getVoiceConnectorEmergencyCallingConfiguration(
    request: GetVoiceConnectorEmergencyCallingConfigurationRequest
  ): ChimeIO[GetVoiceConnectorEmergencyCallingConfigurationResponse] =
    FF.liftF(GetVoiceConnectorEmergencyCallingConfigurationOp(request))

  def getVoiceConnectorGroup(
    request: GetVoiceConnectorGroupRequest
  ): ChimeIO[GetVoiceConnectorGroupResponse] =
    FF.liftF(GetVoiceConnectorGroupOp(request))

  def getVoiceConnectorLoggingConfiguration(
    request: GetVoiceConnectorLoggingConfigurationRequest
  ): ChimeIO[GetVoiceConnectorLoggingConfigurationResponse] =
    FF.liftF(GetVoiceConnectorLoggingConfigurationOp(request))

  def getVoiceConnectorOrigination(
    request: GetVoiceConnectorOriginationRequest
  ): ChimeIO[GetVoiceConnectorOriginationResponse] =
    FF.liftF(GetVoiceConnectorOriginationOp(request))

  def getVoiceConnectorProxy(
    request: GetVoiceConnectorProxyRequest
  ): ChimeIO[GetVoiceConnectorProxyResponse] =
    FF.liftF(GetVoiceConnectorProxyOp(request))

  def getVoiceConnectorStreamingConfiguration(
    request: GetVoiceConnectorStreamingConfigurationRequest
  ): ChimeIO[GetVoiceConnectorStreamingConfigurationResponse] =
    FF.liftF(GetVoiceConnectorStreamingConfigurationOp(request))

  def getVoiceConnectorTermination(
    request: GetVoiceConnectorTerminationRequest
  ): ChimeIO[GetVoiceConnectorTerminationResponse] =
    FF.liftF(GetVoiceConnectorTerminationOp(request))

  def getVoiceConnectorTerminationHealth(
    request: GetVoiceConnectorTerminationHealthRequest
  ): ChimeIO[GetVoiceConnectorTerminationHealthResponse] =
    FF.liftF(GetVoiceConnectorTerminationHealthOp(request))

  def inviteUsers(
    request: InviteUsersRequest
  ): ChimeIO[InviteUsersResponse] =
    FF.liftF(InviteUsersOp(request))

  def listAccounts(
    request: ListAccountsRequest
  ): ChimeIO[ListAccountsResponse] =
    FF.liftF(ListAccountsOp(request))

  def listAppInstanceAdmins(
    request: ListAppInstanceAdminsRequest
  ): ChimeIO[ListAppInstanceAdminsResponse] =
    FF.liftF(ListAppInstanceAdminsOp(request))

  def listAppInstanceUsers(
    request: ListAppInstanceUsersRequest
  ): ChimeIO[ListAppInstanceUsersResponse] =
    FF.liftF(ListAppInstanceUsersOp(request))

  def listAppInstances(
    request: ListAppInstancesRequest
  ): ChimeIO[ListAppInstancesResponse] =
    FF.liftF(ListAppInstancesOp(request))

  def listAttendeeTags(
    request: ListAttendeeTagsRequest
  ): ChimeIO[ListAttendeeTagsResponse] =
    FF.liftF(ListAttendeeTagsOp(request))

  def listAttendees(
    request: ListAttendeesRequest
  ): ChimeIO[ListAttendeesResponse] =
    FF.liftF(ListAttendeesOp(request))

  def listBots(
    request: ListBotsRequest
  ): ChimeIO[ListBotsResponse] =
    FF.liftF(ListBotsOp(request))

  def listChannelBans(
    request: ListChannelBansRequest
  ): ChimeIO[ListChannelBansResponse] =
    FF.liftF(ListChannelBansOp(request))

  def listChannelMemberships(
    request: ListChannelMembershipsRequest
  ): ChimeIO[ListChannelMembershipsResponse] =
    FF.liftF(ListChannelMembershipsOp(request))

  def listChannelMembershipsForAppInstanceUser(
    request: ListChannelMembershipsForAppInstanceUserRequest
  ): ChimeIO[ListChannelMembershipsForAppInstanceUserResponse] =
    FF.liftF(ListChannelMembershipsForAppInstanceUserOp(request))

  def listChannelMessages(
    request: ListChannelMessagesRequest
  ): ChimeIO[ListChannelMessagesResponse] =
    FF.liftF(ListChannelMessagesOp(request))

  def listChannelModerators(
    request: ListChannelModeratorsRequest
  ): ChimeIO[ListChannelModeratorsResponse] =
    FF.liftF(ListChannelModeratorsOp(request))

  def listChannels(
    request: ListChannelsRequest
  ): ChimeIO[ListChannelsResponse] =
    FF.liftF(ListChannelsOp(request))

  def listChannelsModeratedByAppInstanceUser(
    request: ListChannelsModeratedByAppInstanceUserRequest
  ): ChimeIO[ListChannelsModeratedByAppInstanceUserResponse] =
    FF.liftF(ListChannelsModeratedByAppInstanceUserOp(request))

  def listMeetingTags(
    request: ListMeetingTagsRequest
  ): ChimeIO[ListMeetingTagsResponse] =
    FF.liftF(ListMeetingTagsOp(request))

  def listMeetings(
    request: ListMeetingsRequest
  ): ChimeIO[ListMeetingsResponse] =
    FF.liftF(ListMeetingsOp(request))

  def listPhoneNumberOrders(
    request: ListPhoneNumberOrdersRequest
  ): ChimeIO[ListPhoneNumberOrdersResponse] =
    FF.liftF(ListPhoneNumberOrdersOp(request))

  def listPhoneNumbers(
    request: ListPhoneNumbersRequest
  ): ChimeIO[ListPhoneNumbersResponse] =
    FF.liftF(ListPhoneNumbersOp(request))

  def listProxySessions(
    request: ListProxySessionsRequest
  ): ChimeIO[ListProxySessionsResponse] =
    FF.liftF(ListProxySessionsOp(request))

  def listRoomMemberships(
    request: ListRoomMembershipsRequest
  ): ChimeIO[ListRoomMembershipsResponse] =
    FF.liftF(ListRoomMembershipsOp(request))

  def listRooms(
    request: ListRoomsRequest
  ): ChimeIO[ListRoomsResponse] =
    FF.liftF(ListRoomsOp(request))

  def listSipMediaApplications(
    request: ListSipMediaApplicationsRequest
  ): ChimeIO[ListSipMediaApplicationsResponse] =
    FF.liftF(ListSipMediaApplicationsOp(request))

  def listSipRules(
    request: ListSipRulesRequest
  ): ChimeIO[ListSipRulesResponse] =
    FF.liftF(ListSipRulesOp(request))

  def listSupportedPhoneNumberCountries(
    request: ListSupportedPhoneNumberCountriesRequest
  ): ChimeIO[ListSupportedPhoneNumberCountriesResponse] =
    FF.liftF(ListSupportedPhoneNumberCountriesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ChimeIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listUsers(
    request: ListUsersRequest
  ): ChimeIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def listVoiceConnectorGroups(
    request: ListVoiceConnectorGroupsRequest
  ): ChimeIO[ListVoiceConnectorGroupsResponse] =
    FF.liftF(ListVoiceConnectorGroupsOp(request))

  def listVoiceConnectorTerminationCredentials(
    request: ListVoiceConnectorTerminationCredentialsRequest
  ): ChimeIO[ListVoiceConnectorTerminationCredentialsResponse] =
    FF.liftF(ListVoiceConnectorTerminationCredentialsOp(request))

  def listVoiceConnectors(
    request: ListVoiceConnectorsRequest
  ): ChimeIO[ListVoiceConnectorsResponse] =
    FF.liftF(ListVoiceConnectorsOp(request))

  def logoutUser(
    request: LogoutUserRequest
  ): ChimeIO[LogoutUserResponse] =
    FF.liftF(LogoutUserOp(request))

  def putAppInstanceRetentionSettings(
    request: PutAppInstanceRetentionSettingsRequest
  ): ChimeIO[PutAppInstanceRetentionSettingsResponse] =
    FF.liftF(PutAppInstanceRetentionSettingsOp(request))

  def putAppInstanceStreamingConfigurations(
    request: PutAppInstanceStreamingConfigurationsRequest
  ): ChimeIO[PutAppInstanceStreamingConfigurationsResponse] =
    FF.liftF(PutAppInstanceStreamingConfigurationsOp(request))

  def putEventsConfiguration(
    request: PutEventsConfigurationRequest
  ): ChimeIO[PutEventsConfigurationResponse] =
    FF.liftF(PutEventsConfigurationOp(request))

  def putRetentionSettings(
    request: PutRetentionSettingsRequest
  ): ChimeIO[PutRetentionSettingsResponse] =
    FF.liftF(PutRetentionSettingsOp(request))

  def putSipMediaApplicationLoggingConfiguration(
    request: PutSipMediaApplicationLoggingConfigurationRequest
  ): ChimeIO[PutSipMediaApplicationLoggingConfigurationResponse] =
    FF.liftF(PutSipMediaApplicationLoggingConfigurationOp(request))

  def putVoiceConnectorEmergencyCallingConfiguration(
    request: PutVoiceConnectorEmergencyCallingConfigurationRequest
  ): ChimeIO[PutVoiceConnectorEmergencyCallingConfigurationResponse] =
    FF.liftF(PutVoiceConnectorEmergencyCallingConfigurationOp(request))

  def putVoiceConnectorLoggingConfiguration(
    request: PutVoiceConnectorLoggingConfigurationRequest
  ): ChimeIO[PutVoiceConnectorLoggingConfigurationResponse] =
    FF.liftF(PutVoiceConnectorLoggingConfigurationOp(request))

  def putVoiceConnectorOrigination(
    request: PutVoiceConnectorOriginationRequest
  ): ChimeIO[PutVoiceConnectorOriginationResponse] =
    FF.liftF(PutVoiceConnectorOriginationOp(request))

  def putVoiceConnectorProxy(
    request: PutVoiceConnectorProxyRequest
  ): ChimeIO[PutVoiceConnectorProxyResponse] =
    FF.liftF(PutVoiceConnectorProxyOp(request))

  def putVoiceConnectorStreamingConfiguration(
    request: PutVoiceConnectorStreamingConfigurationRequest
  ): ChimeIO[PutVoiceConnectorStreamingConfigurationResponse] =
    FF.liftF(PutVoiceConnectorStreamingConfigurationOp(request))

  def putVoiceConnectorTermination(
    request: PutVoiceConnectorTerminationRequest
  ): ChimeIO[PutVoiceConnectorTerminationResponse] =
    FF.liftF(PutVoiceConnectorTerminationOp(request))

  def putVoiceConnectorTerminationCredentials(
    request: PutVoiceConnectorTerminationCredentialsRequest
  ): ChimeIO[PutVoiceConnectorTerminationCredentialsResponse] =
    FF.liftF(PutVoiceConnectorTerminationCredentialsOp(request))

  def redactChannelMessage(
    request: RedactChannelMessageRequest
  ): ChimeIO[RedactChannelMessageResponse] =
    FF.liftF(RedactChannelMessageOp(request))

  def redactConversationMessage(
    request: RedactConversationMessageRequest
  ): ChimeIO[RedactConversationMessageResponse] =
    FF.liftF(RedactConversationMessageOp(request))

  def redactRoomMessage(
    request: RedactRoomMessageRequest
  ): ChimeIO[RedactRoomMessageResponse] =
    FF.liftF(RedactRoomMessageOp(request))

  def regenerateSecurityToken(
    request: RegenerateSecurityTokenRequest
  ): ChimeIO[RegenerateSecurityTokenResponse] =
    FF.liftF(RegenerateSecurityTokenOp(request))

  def resetPersonalPIN(
    request: ResetPersonalPinRequest
  ): ChimeIO[ResetPersonalPinResponse] =
    FF.liftF(ResetPersonalPINOp(request))

  def restorePhoneNumber(
    request: RestorePhoneNumberRequest
  ): ChimeIO[RestorePhoneNumberResponse] =
    FF.liftF(RestorePhoneNumberOp(request))

  def searchAvailablePhoneNumbers(
    request: SearchAvailablePhoneNumbersRequest
  ): ChimeIO[SearchAvailablePhoneNumbersResponse] =
    FF.liftF(SearchAvailablePhoneNumbersOp(request))

  def sendChannelMessage(
    request: SendChannelMessageRequest
  ): ChimeIO[SendChannelMessageResponse] =
    FF.liftF(SendChannelMessageOp(request))

  def tagAttendee(
    request: TagAttendeeRequest
  ): ChimeIO[TagAttendeeResponse] =
    FF.liftF(TagAttendeeOp(request))

  def tagMeeting(
    request: TagMeetingRequest
  ): ChimeIO[TagMeetingResponse] =
    FF.liftF(TagMeetingOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ChimeIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagAttendee(
    request: UntagAttendeeRequest
  ): ChimeIO[UntagAttendeeResponse] =
    FF.liftF(UntagAttendeeOp(request))

  def untagMeeting(
    request: UntagMeetingRequest
  ): ChimeIO[UntagMeetingResponse] =
    FF.liftF(UntagMeetingOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ChimeIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAccount(
    request: UpdateAccountRequest
  ): ChimeIO[UpdateAccountResponse] =
    FF.liftF(UpdateAccountOp(request))

  def updateAccountSettings(
    request: UpdateAccountSettingsRequest
  ): ChimeIO[UpdateAccountSettingsResponse] =
    FF.liftF(UpdateAccountSettingsOp(request))

  def updateAppInstance(
    request: UpdateAppInstanceRequest
  ): ChimeIO[UpdateAppInstanceResponse] =
    FF.liftF(UpdateAppInstanceOp(request))

  def updateAppInstanceUser(
    request: UpdateAppInstanceUserRequest
  ): ChimeIO[UpdateAppInstanceUserResponse] =
    FF.liftF(UpdateAppInstanceUserOp(request))

  def updateBot(
    request: UpdateBotRequest
  ): ChimeIO[UpdateBotResponse] =
    FF.liftF(UpdateBotOp(request))

  def updateChannel(
    request: UpdateChannelRequest
  ): ChimeIO[UpdateChannelResponse] =
    FF.liftF(UpdateChannelOp(request))

  def updateChannelMessage(
    request: UpdateChannelMessageRequest
  ): ChimeIO[UpdateChannelMessageResponse] =
    FF.liftF(UpdateChannelMessageOp(request))

  def updateChannelReadMarker(
    request: UpdateChannelReadMarkerRequest
  ): ChimeIO[UpdateChannelReadMarkerResponse] =
    FF.liftF(UpdateChannelReadMarkerOp(request))

  def updateGlobalSettings(
    request: UpdateGlobalSettingsRequest
  ): ChimeIO[UpdateGlobalSettingsResponse] =
    FF.liftF(UpdateGlobalSettingsOp(request))

  def updatePhoneNumber(
    request: UpdatePhoneNumberRequest
  ): ChimeIO[UpdatePhoneNumberResponse] =
    FF.liftF(UpdatePhoneNumberOp(request))

  def updatePhoneNumberSettings(
    request: UpdatePhoneNumberSettingsRequest
  ): ChimeIO[UpdatePhoneNumberSettingsResponse] =
    FF.liftF(UpdatePhoneNumberSettingsOp(request))

  def updateProxySession(
    request: UpdateProxySessionRequest
  ): ChimeIO[UpdateProxySessionResponse] =
    FF.liftF(UpdateProxySessionOp(request))

  def updateRoom(
    request: UpdateRoomRequest
  ): ChimeIO[UpdateRoomResponse] =
    FF.liftF(UpdateRoomOp(request))

  def updateRoomMembership(
    request: UpdateRoomMembershipRequest
  ): ChimeIO[UpdateRoomMembershipResponse] =
    FF.liftF(UpdateRoomMembershipOp(request))

  def updateSipMediaApplication(
    request: UpdateSipMediaApplicationRequest
  ): ChimeIO[UpdateSipMediaApplicationResponse] =
    FF.liftF(UpdateSipMediaApplicationOp(request))

  def updateSipRule(
    request: UpdateSipRuleRequest
  ): ChimeIO[UpdateSipRuleResponse] =
    FF.liftF(UpdateSipRuleOp(request))

  def updateUser(
    request: UpdateUserRequest
  ): ChimeIO[UpdateUserResponse] =
    FF.liftF(UpdateUserOp(request))

  def updateUserSettings(
    request: UpdateUserSettingsRequest
  ): ChimeIO[UpdateUserSettingsResponse] =
    FF.liftF(UpdateUserSettingsOp(request))

  def updateVoiceConnector(
    request: UpdateVoiceConnectorRequest
  ): ChimeIO[UpdateVoiceConnectorResponse] =
    FF.liftF(UpdateVoiceConnectorOp(request))

  def updateVoiceConnectorGroup(
    request: UpdateVoiceConnectorGroupRequest
  ): ChimeIO[UpdateVoiceConnectorGroupResponse] =
    FF.liftF(UpdateVoiceConnectorGroupOp(request))
}
