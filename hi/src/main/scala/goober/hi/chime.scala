package goober.hi

import goober.free.chime.ChimeIO
import software.amazon.awssdk.services.chime.model._


object chime {
  import goober.free.{chime ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      code: Option[String] = None,
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def account(
      awsAccountId: Option[String] = None,
      accountId: Option[String] = None,
      name: Option[String] = None,
      accountType: Option[String] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      defaultLicense: Option[String] = None,
      supportedLicenses: Option[List[License]] = None,
      signinDelegateGroups: Option[List[SigninDelegateGroup]] = None
    ): Account =
      Account
        .builder
        .ifSome(awsAccountId)(_.awsAccountId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(accountType)(_.accountType(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(defaultLicense)(_.defaultLicense(_))
        .ifSome(supportedLicenses)(_.supportedLicenses(_))
        .ifSome(signinDelegateGroups)(_.signinDelegateGroups(_))
        .build

    def accountSettings(
      disableRemoteControl: Option[Boolean] = None,
      enableDialOut: Option[Boolean] = None
    ): AccountSettings =
      AccountSettings
        .builder
        .ifSome(disableRemoteControl)(_.disableRemoteControl(_))
        .ifSome(enableDialOut)(_.enableDialOut(_))
        .build

    def alexaForBusinessMetadata(
      isAlexaForBusinessEnabled: Option[Boolean] = None,
      alexaForBusinessRoomArn: Option[String] = None
    ): AlexaForBusinessMetadata =
      AlexaForBusinessMetadata
        .builder
        .ifSome(isAlexaForBusinessEnabled)(_.isAlexaForBusinessEnabled(_))
        .ifSome(alexaForBusinessRoomArn)(_.alexaForBusinessRoomArn(_))
        .build

    def appInstance(
      appInstanceArn: Option[String] = None,
      name: Option[String] = None,
      metadata: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): AppInstance =
      AppInstance
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def appInstanceAdmin(
      admin: Option[Identity] = None,
      appInstanceArn: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None
    ): AppInstanceAdmin =
      AppInstanceAdmin
        .builder
        .ifSome(admin)(_.admin(_))
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .build

    def appInstanceAdminSummary(
      admin: Option[Identity] = None
    ): AppInstanceAdminSummary =
      AppInstanceAdminSummary
        .builder
        .ifSome(admin)(_.admin(_))
        .build

    def appInstanceRetentionSettings(
      channelRetentionSettings: Option[ChannelRetentionSettings] = None
    ): AppInstanceRetentionSettings =
      AppInstanceRetentionSettings
        .builder
        .ifSome(channelRetentionSettings)(_.channelRetentionSettings(_))
        .build

    def appInstanceStreamingConfiguration(
      appInstanceDataType: Option[String] = None,
      resourceArn: Option[String] = None
    ): AppInstanceStreamingConfiguration =
      AppInstanceStreamingConfiguration
        .builder
        .ifSome(appInstanceDataType)(_.appInstanceDataType(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def appInstanceSummary(
      appInstanceArn: Option[String] = None,
      name: Option[String] = None,
      metadata: Option[String] = None
    ): AppInstanceSummary =
      AppInstanceSummary
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def appInstanceUser(
      appInstanceUserArn: Option[String] = None,
      name: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      metadata: Option[String] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): AppInstanceUser =
      AppInstanceUser
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def appInstanceUserMembershipSummary(
      `type`: Option[String] = None,
      readMarkerTimestamp: Option[Timestamp] = None
    ): AppInstanceUserMembershipSummary =
      AppInstanceUserMembershipSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(readMarkerTimestamp)(_.readMarkerTimestamp(_))
        .build

    def appInstanceUserSummary(
      appInstanceUserArn: Option[String] = None,
      name: Option[String] = None,
      metadata: Option[String] = None
    ): AppInstanceUserSummary =
      AppInstanceUserSummary
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def associatePhoneNumberWithUserRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None,
      e164PhoneNumber: Option[String] = None
    ): AssociatePhoneNumberWithUserRequest =
      AssociatePhoneNumberWithUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(e164PhoneNumber)(_.e164PhoneNumber(_))
        .build

    def associatePhoneNumberWithUserResponse(

    ): AssociatePhoneNumberWithUserResponse =
      AssociatePhoneNumberWithUserResponse
        .builder

        .build

    def associatePhoneNumbersWithVoiceConnectorGroupRequest(
      voiceConnectorGroupId: Option[String] = None,
      e164PhoneNumbers: Option[List[E164PhoneNumber]] = None,
      forceAssociate: Option[Boolean] = None
    ): AssociatePhoneNumbersWithVoiceConnectorGroupRequest =
      AssociatePhoneNumbersWithVoiceConnectorGroupRequest
        .builder
        .ifSome(voiceConnectorGroupId)(_.voiceConnectorGroupId(_))
        .ifSome(e164PhoneNumbers)(_.e164PhoneNumbers(_))
        .ifSome(forceAssociate)(_.forceAssociate(_))
        .build

    def associatePhoneNumbersWithVoiceConnectorGroupResponse(
      phoneNumberErrors: Option[List[PhoneNumberError]] = None
    ): AssociatePhoneNumbersWithVoiceConnectorGroupResponse =
      AssociatePhoneNumbersWithVoiceConnectorGroupResponse
        .builder
        .ifSome(phoneNumberErrors)(_.phoneNumberErrors(_))
        .build

    def associatePhoneNumbersWithVoiceConnectorRequest(
      voiceConnectorId: Option[String] = None,
      e164PhoneNumbers: Option[List[E164PhoneNumber]] = None,
      forceAssociate: Option[Boolean] = None
    ): AssociatePhoneNumbersWithVoiceConnectorRequest =
      AssociatePhoneNumbersWithVoiceConnectorRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(e164PhoneNumbers)(_.e164PhoneNumbers(_))
        .ifSome(forceAssociate)(_.forceAssociate(_))
        .build

    def associatePhoneNumbersWithVoiceConnectorResponse(
      phoneNumberErrors: Option[List[PhoneNumberError]] = None
    ): AssociatePhoneNumbersWithVoiceConnectorResponse =
      AssociatePhoneNumbersWithVoiceConnectorResponse
        .builder
        .ifSome(phoneNumberErrors)(_.phoneNumberErrors(_))
        .build

    def associateSigninDelegateGroupsWithAccountRequest(
      accountId: Option[String] = None,
      signinDelegateGroups: Option[List[SigninDelegateGroup]] = None
    ): AssociateSigninDelegateGroupsWithAccountRequest =
      AssociateSigninDelegateGroupsWithAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(signinDelegateGroups)(_.signinDelegateGroups(_))
        .build

    def associateSigninDelegateGroupsWithAccountResponse(

    ): AssociateSigninDelegateGroupsWithAccountResponse =
      AssociateSigninDelegateGroupsWithAccountResponse
        .builder

        .build

    def attendee(
      externalUserId: Option[String] = None,
      attendeeId: Option[String] = None,
      joinToken: Option[String] = None
    ): Attendee =
      Attendee
        .builder
        .ifSome(externalUserId)(_.externalUserId(_))
        .ifSome(attendeeId)(_.attendeeId(_))
        .ifSome(joinToken)(_.joinToken(_))
        .build

    def badRequestException(
      code: Option[String] = None,
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def batchChannelMemberships(
      invitedBy: Option[Identity] = None,
      `type`: Option[String] = None,
      members: Option[List[Identity]] = None,
      channelArn: Option[String] = None
    ): BatchChannelMemberships =
      BatchChannelMemberships
        .builder
        .ifSome(invitedBy)(_.invitedBy(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(members)(_.members(_))
        .ifSome(channelArn)(_.channelArn(_))
        .build

    def batchCreateAttendeeRequest(
      meetingId: Option[String] = None,
      attendees: Option[List[CreateAttendeeRequestItem]] = None
    ): BatchCreateAttendeeRequest =
      BatchCreateAttendeeRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(attendees)(_.attendees(_))
        .build

    def batchCreateAttendeeResponse(
      attendees: Option[List[Attendee]] = None,
      errors: Option[List[CreateAttendeeError]] = None
    ): BatchCreateAttendeeResponse =
      BatchCreateAttendeeResponse
        .builder
        .ifSome(attendees)(_.attendees(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchCreateChannelMembershipError(
      memberArn: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchCreateChannelMembershipError =
      BatchCreateChannelMembershipError
        .builder
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchCreateChannelMembershipRequest(
      channelArn: Option[String] = None,
      `type`: Option[String] = None,
      memberArns: Option[List[ChimeArn]] = None,
      chimeBearer: Option[String] = None
    ): BatchCreateChannelMembershipRequest =
      BatchCreateChannelMembershipRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(memberArns)(_.memberArns(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def batchCreateChannelMembershipResponse(
      batchChannelMemberships: Option[BatchChannelMemberships] = None,
      errors: Option[List[BatchCreateChannelMembershipError]] = None
    ): BatchCreateChannelMembershipResponse =
      BatchCreateChannelMembershipResponse
        .builder
        .ifSome(batchChannelMemberships)(_.batchChannelMemberships(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchCreateRoomMembershipRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      membershipItemList: Option[List[MembershipItem]] = None
    ): BatchCreateRoomMembershipRequest =
      BatchCreateRoomMembershipRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(membershipItemList)(_.membershipItemList(_))
        .build

    def batchCreateRoomMembershipResponse(
      errors: Option[List[MemberError]] = None
    ): BatchCreateRoomMembershipResponse =
      BatchCreateRoomMembershipResponse
        .builder
        .ifSome(errors)(_.errors(_))
        .build

    def batchDeletePhoneNumberRequest(
      phoneNumberIds: Option[List[String]] = None
    ): BatchDeletePhoneNumberRequest =
      BatchDeletePhoneNumberRequest
        .builder
        .ifSome(phoneNumberIds)(_.phoneNumberIds(_))
        .build

    def batchDeletePhoneNumberResponse(
      phoneNumberErrors: Option[List[PhoneNumberError]] = None
    ): BatchDeletePhoneNumberResponse =
      BatchDeletePhoneNumberResponse
        .builder
        .ifSome(phoneNumberErrors)(_.phoneNumberErrors(_))
        .build

    def batchSuspendUserRequest(
      accountId: Option[String] = None,
      userIdList: Option[List[NonEmptyString]] = None
    ): BatchSuspendUserRequest =
      BatchSuspendUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userIdList)(_.userIdList(_))
        .build

    def batchSuspendUserResponse(
      userErrors: Option[List[UserError]] = None
    ): BatchSuspendUserResponse =
      BatchSuspendUserResponse
        .builder
        .ifSome(userErrors)(_.userErrors(_))
        .build

    def batchUnsuspendUserRequest(
      accountId: Option[String] = None,
      userIdList: Option[List[NonEmptyString]] = None
    ): BatchUnsuspendUserRequest =
      BatchUnsuspendUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userIdList)(_.userIdList(_))
        .build

    def batchUnsuspendUserResponse(
      userErrors: Option[List[UserError]] = None
    ): BatchUnsuspendUserResponse =
      BatchUnsuspendUserResponse
        .builder
        .ifSome(userErrors)(_.userErrors(_))
        .build

    def batchUpdatePhoneNumberRequest(
      updatePhoneNumberRequestItems: Option[List[UpdatePhoneNumberRequestItem]] = None
    ): BatchUpdatePhoneNumberRequest =
      BatchUpdatePhoneNumberRequest
        .builder
        .ifSome(updatePhoneNumberRequestItems)(_.updatePhoneNumberRequestItems(_))
        .build

    def batchUpdatePhoneNumberResponse(
      phoneNumberErrors: Option[List[PhoneNumberError]] = None
    ): BatchUpdatePhoneNumberResponse =
      BatchUpdatePhoneNumberResponse
        .builder
        .ifSome(phoneNumberErrors)(_.phoneNumberErrors(_))
        .build

    def batchUpdateUserRequest(
      accountId: Option[String] = None,
      updateUserRequestItems: Option[List[UpdateUserRequestItem]] = None
    ): BatchUpdateUserRequest =
      BatchUpdateUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(updateUserRequestItems)(_.updateUserRequestItems(_))
        .build

    def batchUpdateUserResponse(
      userErrors: Option[List[UserError]] = None
    ): BatchUpdateUserResponse =
      BatchUpdateUserResponse
        .builder
        .ifSome(userErrors)(_.userErrors(_))
        .build

    def bot(
      botId: Option[String] = None,
      userId: Option[String] = None,
      displayName: Option[String] = None,
      botType: Option[String] = None,
      disabled: Option[Boolean] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None,
      botEmail: Option[String] = None,
      securityToken: Option[String] = None
    ): Bot =
      Bot
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(botType)(_.botType(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .ifSome(botEmail)(_.botEmail(_))
        .ifSome(securityToken)(_.securityToken(_))
        .build

    def businessCallingSettings(
      cdrBucket: Option[String] = None
    ): BusinessCallingSettings =
      BusinessCallingSettings
        .builder
        .ifSome(cdrBucket)(_.cdrBucket(_))
        .build

    def channel(
      name: Option[String] = None,
      channelArn: Option[String] = None,
      mode: Option[String] = None,
      privacy: Option[String] = None,
      metadata: Option[String] = None,
      createdBy: Option[Identity] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastMessageTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): Channel =
      Channel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(privacy)(_.privacy(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastMessageTimestamp)(_.lastMessageTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def channelBan(
      member: Option[Identity] = None,
      channelArn: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      createdBy: Option[Identity] = None
    ): ChannelBan =
      ChannelBan
        .builder
        .ifSome(member)(_.member(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def channelBanSummary(
      member: Option[Identity] = None
    ): ChannelBanSummary =
      ChannelBanSummary
        .builder
        .ifSome(member)(_.member(_))
        .build

    def channelMembership(
      invitedBy: Option[Identity] = None,
      `type`: Option[String] = None,
      member: Option[Identity] = None,
      channelArn: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None
    ): ChannelMembership =
      ChannelMembership
        .builder
        .ifSome(invitedBy)(_.invitedBy(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(member)(_.member(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .build

    def channelMembershipForAppInstanceUserSummary(
      channelSummary: Option[ChannelSummary] = None,
      appInstanceUserMembershipSummary: Option[AppInstanceUserMembershipSummary] = None
    ): ChannelMembershipForAppInstanceUserSummary =
      ChannelMembershipForAppInstanceUserSummary
        .builder
        .ifSome(channelSummary)(_.channelSummary(_))
        .ifSome(appInstanceUserMembershipSummary)(_.appInstanceUserMembershipSummary(_))
        .build

    def channelMembershipSummary(
      member: Option[Identity] = None
    ): ChannelMembershipSummary =
      ChannelMembershipSummary
        .builder
        .ifSome(member)(_.member(_))
        .build

    def channelMessage(
      channelArn: Option[String] = None,
      messageId: Option[String] = None,
      content: Option[String] = None,
      metadata: Option[String] = None,
      `type`: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastEditedTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None,
      sender: Option[Identity] = None,
      redacted: Option[Boolean] = None,
      persistence: Option[String] = None
    ): ChannelMessage =
      ChannelMessage
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(content)(_.content(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastEditedTimestamp)(_.lastEditedTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(sender)(_.sender(_))
        .ifSome(redacted)(_.redacted(_))
        .ifSome(persistence)(_.persistence(_))
        .build

    def channelMessageSummary(
      messageId: Option[String] = None,
      content: Option[String] = None,
      metadata: Option[String] = None,
      `type`: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None,
      lastEditedTimestamp: Option[Timestamp] = None,
      sender: Option[Identity] = None,
      redacted: Option[Boolean] = None
    ): ChannelMessageSummary =
      ChannelMessageSummary
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(content)(_.content(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(lastEditedTimestamp)(_.lastEditedTimestamp(_))
        .ifSome(sender)(_.sender(_))
        .ifSome(redacted)(_.redacted(_))
        .build

    def channelModeratedByAppInstanceUserSummary(
      channelSummary: Option[ChannelSummary] = None
    ): ChannelModeratedByAppInstanceUserSummary =
      ChannelModeratedByAppInstanceUserSummary
        .builder
        .ifSome(channelSummary)(_.channelSummary(_))
        .build

    def channelModerator(
      moderator: Option[Identity] = None,
      channelArn: Option[String] = None,
      createdTimestamp: Option[Timestamp] = None,
      createdBy: Option[Identity] = None
    ): ChannelModerator =
      ChannelModerator
        .builder
        .ifSome(moderator)(_.moderator(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(createdBy)(_.createdBy(_))
        .build

    def channelModeratorSummary(
      moderator: Option[Identity] = None
    ): ChannelModeratorSummary =
      ChannelModeratorSummary
        .builder
        .ifSome(moderator)(_.moderator(_))
        .build

    def channelRetentionSettings(
      retentionDays: Option[Int] = None
    ): ChannelRetentionSettings =
      ChannelRetentionSettings
        .builder
        .ifSome(retentionDays)(_.retentionDays(_))
        .build

    def channelSummary(
      name: Option[String] = None,
      channelArn: Option[String] = None,
      mode: Option[String] = None,
      privacy: Option[String] = None,
      metadata: Option[String] = None,
      lastMessageTimestamp: Option[Timestamp] = None
    ): ChannelSummary =
      ChannelSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(privacy)(_.privacy(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(lastMessageTimestamp)(_.lastMessageTimestamp(_))
        .build

    def conflictException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def conversationRetentionSettings(
      retentionDays: Option[Int] = None
    ): ConversationRetentionSettings =
      ConversationRetentionSettings
        .builder
        .ifSome(retentionDays)(_.retentionDays(_))
        .build

    def createAccountRequest(
      name: Option[String] = None
    ): CreateAccountRequest =
      CreateAccountRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def createAccountResponse(
      account: Option[Account] = None
    ): CreateAccountResponse =
      CreateAccountResponse
        .builder
        .ifSome(account)(_.account(_))
        .build

    def createAppInstanceAdminRequest(
      appInstanceAdminArn: Option[String] = None,
      appInstanceArn: Option[String] = None
    ): CreateAppInstanceAdminRequest =
      CreateAppInstanceAdminRequest
        .builder
        .ifSome(appInstanceAdminArn)(_.appInstanceAdminArn(_))
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def createAppInstanceAdminResponse(
      appInstanceAdmin: Option[Identity] = None,
      appInstanceArn: Option[String] = None
    ): CreateAppInstanceAdminResponse =
      CreateAppInstanceAdminResponse
        .builder
        .ifSome(appInstanceAdmin)(_.appInstanceAdmin(_))
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def createAppInstanceRequest(
      name: Option[String] = None,
      metadata: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAppInstanceRequest =
      CreateAppInstanceRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAppInstanceResponse(
      appInstanceArn: Option[String] = None
    ): CreateAppInstanceResponse =
      CreateAppInstanceResponse
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def createAppInstanceUserRequest(
      appInstanceArn: Option[String] = None,
      appInstanceUserId: Option[String] = None,
      name: Option[String] = None,
      metadata: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAppInstanceUserRequest =
      CreateAppInstanceUserRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(appInstanceUserId)(_.appInstanceUserId(_))
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAppInstanceUserResponse(
      appInstanceUserArn: Option[String] = None
    ): CreateAppInstanceUserResponse =
      CreateAppInstanceUserResponse
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .build

    def createAttendeeError(
      externalUserId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): CreateAttendeeError =
      CreateAttendeeError
        .builder
        .ifSome(externalUserId)(_.externalUserId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def createAttendeeRequest(
      meetingId: Option[String] = None,
      externalUserId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAttendeeRequest =
      CreateAttendeeRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(externalUserId)(_.externalUserId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAttendeeRequestItem(
      externalUserId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAttendeeRequestItem =
      CreateAttendeeRequestItem
        .builder
        .ifSome(externalUserId)(_.externalUserId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAttendeeResponse(
      attendee: Option[Attendee] = None
    ): CreateAttendeeResponse =
      CreateAttendeeResponse
        .builder
        .ifSome(attendee)(_.attendee(_))
        .build

    def createBotRequest(
      accountId: Option[String] = None,
      displayName: Option[String] = None,
      domain: Option[String] = None
    ): CreateBotRequest =
      CreateBotRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(domain)(_.domain(_))
        .build

    def createBotResponse(
      bot: Option[Bot] = None
    ): CreateBotResponse =
      CreateBotResponse
        .builder
        .ifSome(bot)(_.bot(_))
        .build

    def createChannelBanRequest(
      channelArn: Option[String] = None,
      memberArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): CreateChannelBanRequest =
      CreateChannelBanRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def createChannelBanResponse(
      channelArn: Option[String] = None,
      member: Option[Identity] = None
    ): CreateChannelBanResponse =
      CreateChannelBanResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(member)(_.member(_))
        .build

    def createChannelMembershipRequest(
      channelArn: Option[String] = None,
      memberArn: Option[String] = None,
      `type`: Option[String] = None,
      chimeBearer: Option[String] = None
    ): CreateChannelMembershipRequest =
      CreateChannelMembershipRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def createChannelMembershipResponse(
      channelArn: Option[String] = None,
      member: Option[Identity] = None
    ): CreateChannelMembershipResponse =
      CreateChannelMembershipResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(member)(_.member(_))
        .build

    def createChannelModeratorRequest(
      channelArn: Option[String] = None,
      channelModeratorArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): CreateChannelModeratorRequest =
      CreateChannelModeratorRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(channelModeratorArn)(_.channelModeratorArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def createChannelModeratorResponse(
      channelArn: Option[String] = None,
      channelModerator: Option[Identity] = None
    ): CreateChannelModeratorResponse =
      CreateChannelModeratorResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(channelModerator)(_.channelModerator(_))
        .build

    def createChannelRequest(
      appInstanceArn: Option[String] = None,
      name: Option[String] = None,
      mode: Option[String] = None,
      privacy: Option[String] = None,
      metadata: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None,
      chimeBearer: Option[String] = None
    ): CreateChannelRequest =
      CreateChannelRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(privacy)(_.privacy(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def createChannelResponse(
      channelArn: Option[String] = None
    ): CreateChannelResponse =
      CreateChannelResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .build

    def createMeetingDialOutRequest(
      meetingId: Option[String] = None,
      fromPhoneNumber: Option[String] = None,
      toPhoneNumber: Option[String] = None,
      joinToken: Option[String] = None
    ): CreateMeetingDialOutRequest =
      CreateMeetingDialOutRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(fromPhoneNumber)(_.fromPhoneNumber(_))
        .ifSome(toPhoneNumber)(_.toPhoneNumber(_))
        .ifSome(joinToken)(_.joinToken(_))
        .build

    def createMeetingDialOutResponse(
      transactionId: Option[String] = None
    ): CreateMeetingDialOutResponse =
      CreateMeetingDialOutResponse
        .builder
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def createMeetingRequest(
      clientRequestToken: Option[String] = None,
      externalMeetingId: Option[String] = None,
      meetingHostId: Option[String] = None,
      mediaRegion: Option[String] = None,
      tags: Option[List[Tag]] = None,
      notificationsConfiguration: Option[MeetingNotificationConfiguration] = None
    ): CreateMeetingRequest =
      CreateMeetingRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(externalMeetingId)(_.externalMeetingId(_))
        .ifSome(meetingHostId)(_.meetingHostId(_))
        .ifSome(mediaRegion)(_.mediaRegion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(notificationsConfiguration)(_.notificationsConfiguration(_))
        .build

    def createMeetingResponse(
      meeting: Option[Meeting] = None
    ): CreateMeetingResponse =
      CreateMeetingResponse
        .builder
        .ifSome(meeting)(_.meeting(_))
        .build

    def createMeetingWithAttendeesRequest(
      clientRequestToken: Option[String] = None,
      externalMeetingId: Option[String] = None,
      meetingHostId: Option[String] = None,
      mediaRegion: Option[String] = None,
      tags: Option[List[Tag]] = None,
      notificationsConfiguration: Option[MeetingNotificationConfiguration] = None,
      attendees: Option[List[CreateAttendeeRequestItem]] = None
    ): CreateMeetingWithAttendeesRequest =
      CreateMeetingWithAttendeesRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(externalMeetingId)(_.externalMeetingId(_))
        .ifSome(meetingHostId)(_.meetingHostId(_))
        .ifSome(mediaRegion)(_.mediaRegion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(notificationsConfiguration)(_.notificationsConfiguration(_))
        .ifSome(attendees)(_.attendees(_))
        .build

    def createMeetingWithAttendeesResponse(
      meeting: Option[Meeting] = None,
      attendees: Option[List[Attendee]] = None,
      errors: Option[List[CreateAttendeeError]] = None
    ): CreateMeetingWithAttendeesResponse =
      CreateMeetingWithAttendeesResponse
        .builder
        .ifSome(meeting)(_.meeting(_))
        .ifSome(attendees)(_.attendees(_))
        .ifSome(errors)(_.errors(_))
        .build

    def createPhoneNumberOrderRequest(
      productType: Option[String] = None,
      e164PhoneNumbers: Option[List[E164PhoneNumber]] = None
    ): CreatePhoneNumberOrderRequest =
      CreatePhoneNumberOrderRequest
        .builder
        .ifSome(productType)(_.productType(_))
        .ifSome(e164PhoneNumbers)(_.e164PhoneNumbers(_))
        .build

    def createPhoneNumberOrderResponse(
      phoneNumberOrder: Option[PhoneNumberOrder] = None
    ): CreatePhoneNumberOrderResponse =
      CreatePhoneNumberOrderResponse
        .builder
        .ifSome(phoneNumberOrder)(_.phoneNumberOrder(_))
        .build

    def createProxySessionRequest(
      voiceConnectorId: Option[String] = None,
      participantPhoneNumbers: Option[List[E164PhoneNumber]] = None,
      name: Option[String] = None,
      expiryMinutes: Option[Int] = None,
      capabilities: Option[List[Capability]] = None,
      numberSelectionBehavior: Option[String] = None,
      geoMatchLevel: Option[String] = None,
      geoMatchParams: Option[GeoMatchParams] = None
    ): CreateProxySessionRequest =
      CreateProxySessionRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(participantPhoneNumbers)(_.participantPhoneNumbers(_))
        .ifSome(name)(_.name(_))
        .ifSome(expiryMinutes)(_.expiryMinutes(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(numberSelectionBehavior)(_.numberSelectionBehavior(_))
        .ifSome(geoMatchLevel)(_.geoMatchLevel(_))
        .ifSome(geoMatchParams)(_.geoMatchParams(_))
        .build

    def createProxySessionResponse(
      proxySession: Option[ProxySession] = None
    ): CreateProxySessionResponse =
      CreateProxySessionResponse
        .builder
        .ifSome(proxySession)(_.proxySession(_))
        .build

    def createRoomMembershipRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      memberId: Option[String] = None,
      role: Option[String] = None
    ): CreateRoomMembershipRequest =
      CreateRoomMembershipRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(role)(_.role(_))
        .build

    def createRoomMembershipResponse(
      roomMembership: Option[RoomMembership] = None
    ): CreateRoomMembershipResponse =
      CreateRoomMembershipResponse
        .builder
        .ifSome(roomMembership)(_.roomMembership(_))
        .build

    def createRoomRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): CreateRoomRequest =
      CreateRoomRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createRoomResponse(
      room: Option[Room] = None
    ): CreateRoomResponse =
      CreateRoomResponse
        .builder
        .ifSome(room)(_.room(_))
        .build

    def createSipMediaApplicationCallRequest(
      fromPhoneNumber: Option[String] = None,
      toPhoneNumber: Option[String] = None,
      sipMediaApplicationId: Option[String] = None
    ): CreateSipMediaApplicationCallRequest =
      CreateSipMediaApplicationCallRequest
        .builder
        .ifSome(fromPhoneNumber)(_.fromPhoneNumber(_))
        .ifSome(toPhoneNumber)(_.toPhoneNumber(_))
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .build

    def createSipMediaApplicationCallResponse(
      sipMediaApplicationCall: Option[SipMediaApplicationCall] = None
    ): CreateSipMediaApplicationCallResponse =
      CreateSipMediaApplicationCallResponse
        .builder
        .ifSome(sipMediaApplicationCall)(_.sipMediaApplicationCall(_))
        .build

    def createSipMediaApplicationRequest(
      awsRegion: Option[String] = None,
      name: Option[String] = None,
      endpoints: Option[List[SipMediaApplicationEndpoint]] = None
    ): CreateSipMediaApplicationRequest =
      CreateSipMediaApplicationRequest
        .builder
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(name)(_.name(_))
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def createSipMediaApplicationResponse(
      sipMediaApplication: Option[SipMediaApplication] = None
    ): CreateSipMediaApplicationResponse =
      CreateSipMediaApplicationResponse
        .builder
        .ifSome(sipMediaApplication)(_.sipMediaApplication(_))
        .build

    def createSipRuleRequest(
      name: Option[String] = None,
      triggerType: Option[String] = None,
      triggerValue: Option[String] = None,
      disabled: Option[Boolean] = None,
      targetApplications: Option[List[SipRuleTargetApplication]] = None
    ): CreateSipRuleRequest =
      CreateSipRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(triggerType)(_.triggerType(_))
        .ifSome(triggerValue)(_.triggerValue(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(targetApplications)(_.targetApplications(_))
        .build

    def createSipRuleResponse(
      sipRule: Option[SipRule] = None
    ): CreateSipRuleResponse =
      CreateSipRuleResponse
        .builder
        .ifSome(sipRule)(_.sipRule(_))
        .build

    def createUserRequest(
      accountId: Option[String] = None,
      username: Option[String] = None,
      email: Option[String] = None,
      userType: Option[String] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(username)(_.username(_))
        .ifSome(email)(_.email(_))
        .ifSome(userType)(_.userType(_))
        .build

    def createUserResponse(
      user: Option[User] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def createVoiceConnectorGroupRequest(
      name: Option[String] = None,
      voiceConnectorItems: Option[List[VoiceConnectorItem]] = None
    ): CreateVoiceConnectorGroupRequest =
      CreateVoiceConnectorGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(voiceConnectorItems)(_.voiceConnectorItems(_))
        .build

    def createVoiceConnectorGroupResponse(
      voiceConnectorGroup: Option[VoiceConnectorGroup] = None
    ): CreateVoiceConnectorGroupResponse =
      CreateVoiceConnectorGroupResponse
        .builder
        .ifSome(voiceConnectorGroup)(_.voiceConnectorGroup(_))
        .build

    def createVoiceConnectorRequest(
      name: Option[String] = None,
      awsRegion: Option[String] = None,
      requireEncryption: Option[Boolean] = None
    ): CreateVoiceConnectorRequest =
      CreateVoiceConnectorRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(requireEncryption)(_.requireEncryption(_))
        .build

    def createVoiceConnectorResponse(
      voiceConnector: Option[VoiceConnector] = None
    ): CreateVoiceConnectorResponse =
      CreateVoiceConnectorResponse
        .builder
        .ifSome(voiceConnector)(_.voiceConnector(_))
        .build

    def credential(
      username: Option[String] = None,
      password: Option[String] = None
    ): Credential =
      Credential
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .build

    def dNISEmergencyCallingConfiguration(
      emergencyPhoneNumber: Option[String] = None,
      testPhoneNumber: Option[String] = None,
      callingCountry: Option[String] = None
    ): DNISEmergencyCallingConfiguration =
      DNISEmergencyCallingConfiguration
        .builder
        .ifSome(emergencyPhoneNumber)(_.emergencyPhoneNumber(_))
        .ifSome(testPhoneNumber)(_.testPhoneNumber(_))
        .ifSome(callingCountry)(_.callingCountry(_))
        .build

    def deleteAccountRequest(
      accountId: Option[String] = None
    ): DeleteAccountRequest =
      DeleteAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def deleteAccountResponse(

    ): DeleteAccountResponse =
      DeleteAccountResponse
        .builder

        .build

    def deleteAppInstanceAdminRequest(
      appInstanceAdminArn: Option[String] = None,
      appInstanceArn: Option[String] = None
    ): DeleteAppInstanceAdminRequest =
      DeleteAppInstanceAdminRequest
        .builder
        .ifSome(appInstanceAdminArn)(_.appInstanceAdminArn(_))
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def deleteAppInstanceRequest(
      appInstanceArn: Option[String] = None
    ): DeleteAppInstanceRequest =
      DeleteAppInstanceRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def deleteAppInstanceStreamingConfigurationsRequest(
      appInstanceArn: Option[String] = None
    ): DeleteAppInstanceStreamingConfigurationsRequest =
      DeleteAppInstanceStreamingConfigurationsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def deleteAppInstanceUserRequest(
      appInstanceUserArn: Option[String] = None
    ): DeleteAppInstanceUserRequest =
      DeleteAppInstanceUserRequest
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .build

    def deleteAttendeeRequest(
      meetingId: Option[String] = None,
      attendeeId: Option[String] = None
    ): DeleteAttendeeRequest =
      DeleteAttendeeRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(attendeeId)(_.attendeeId(_))
        .build

    def deleteChannelBanRequest(
      channelArn: Option[String] = None,
      memberArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DeleteChannelBanRequest =
      DeleteChannelBanRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def deleteChannelMembershipRequest(
      channelArn: Option[String] = None,
      memberArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DeleteChannelMembershipRequest =
      DeleteChannelMembershipRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def deleteChannelMessageRequest(
      channelArn: Option[String] = None,
      messageId: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DeleteChannelMessageRequest =
      DeleteChannelMessageRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def deleteChannelModeratorRequest(
      channelArn: Option[String] = None,
      channelModeratorArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DeleteChannelModeratorRequest =
      DeleteChannelModeratorRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(channelModeratorArn)(_.channelModeratorArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def deleteChannelRequest(
      channelArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DeleteChannelRequest =
      DeleteChannelRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def deleteEventsConfigurationRequest(
      accountId: Option[String] = None,
      botId: Option[String] = None
    ): DeleteEventsConfigurationRequest =
      DeleteEventsConfigurationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(botId)(_.botId(_))
        .build

    def deleteMeetingRequest(
      meetingId: Option[String] = None
    ): DeleteMeetingRequest =
      DeleteMeetingRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .build

    def deletePhoneNumberRequest(
      phoneNumberId: Option[String] = None
    ): DeletePhoneNumberRequest =
      DeletePhoneNumberRequest
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .build

    def deleteProxySessionRequest(
      voiceConnectorId: Option[String] = None,
      proxySessionId: Option[String] = None
    ): DeleteProxySessionRequest =
      DeleteProxySessionRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(proxySessionId)(_.proxySessionId(_))
        .build

    def deleteRoomMembershipRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      memberId: Option[String] = None
    ): DeleteRoomMembershipRequest =
      DeleteRoomMembershipRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def deleteRoomRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None
    ): DeleteRoomRequest =
      DeleteRoomRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .build

    def deleteSipMediaApplicationRequest(
      sipMediaApplicationId: Option[String] = None
    ): DeleteSipMediaApplicationRequest =
      DeleteSipMediaApplicationRequest
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .build

    def deleteSipRuleRequest(
      sipRuleId: Option[String] = None
    ): DeleteSipRuleRequest =
      DeleteSipRuleRequest
        .builder
        .ifSome(sipRuleId)(_.sipRuleId(_))
        .build

    def deleteVoiceConnectorEmergencyCallingConfigurationRequest(
      voiceConnectorId: Option[String] = None
    ): DeleteVoiceConnectorEmergencyCallingConfigurationRequest =
      DeleteVoiceConnectorEmergencyCallingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def deleteVoiceConnectorGroupRequest(
      voiceConnectorGroupId: Option[String] = None
    ): DeleteVoiceConnectorGroupRequest =
      DeleteVoiceConnectorGroupRequest
        .builder
        .ifSome(voiceConnectorGroupId)(_.voiceConnectorGroupId(_))
        .build

    def deleteVoiceConnectorOriginationRequest(
      voiceConnectorId: Option[String] = None
    ): DeleteVoiceConnectorOriginationRequest =
      DeleteVoiceConnectorOriginationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def deleteVoiceConnectorProxyRequest(
      voiceConnectorId: Option[String] = None
    ): DeleteVoiceConnectorProxyRequest =
      DeleteVoiceConnectorProxyRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def deleteVoiceConnectorRequest(
      voiceConnectorId: Option[String] = None
    ): DeleteVoiceConnectorRequest =
      DeleteVoiceConnectorRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def deleteVoiceConnectorStreamingConfigurationRequest(
      voiceConnectorId: Option[String] = None
    ): DeleteVoiceConnectorStreamingConfigurationRequest =
      DeleteVoiceConnectorStreamingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def deleteVoiceConnectorTerminationCredentialsRequest(
      voiceConnectorId: Option[String] = None,
      usernames: Option[List[SensitiveString]] = None
    ): DeleteVoiceConnectorTerminationCredentialsRequest =
      DeleteVoiceConnectorTerminationCredentialsRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(usernames)(_.usernames(_))
        .build

    def deleteVoiceConnectorTerminationRequest(
      voiceConnectorId: Option[String] = None
    ): DeleteVoiceConnectorTerminationRequest =
      DeleteVoiceConnectorTerminationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def describeAppInstanceAdminRequest(
      appInstanceAdminArn: Option[String] = None,
      appInstanceArn: Option[String] = None
    ): DescribeAppInstanceAdminRequest =
      DescribeAppInstanceAdminRequest
        .builder
        .ifSome(appInstanceAdminArn)(_.appInstanceAdminArn(_))
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def describeAppInstanceAdminResponse(
      appInstanceAdmin: Option[AppInstanceAdmin] = None
    ): DescribeAppInstanceAdminResponse =
      DescribeAppInstanceAdminResponse
        .builder
        .ifSome(appInstanceAdmin)(_.appInstanceAdmin(_))
        .build

    def describeAppInstanceRequest(
      appInstanceArn: Option[String] = None
    ): DescribeAppInstanceRequest =
      DescribeAppInstanceRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def describeAppInstanceResponse(
      appInstance: Option[AppInstance] = None
    ): DescribeAppInstanceResponse =
      DescribeAppInstanceResponse
        .builder
        .ifSome(appInstance)(_.appInstance(_))
        .build

    def describeAppInstanceUserRequest(
      appInstanceUserArn: Option[String] = None
    ): DescribeAppInstanceUserRequest =
      DescribeAppInstanceUserRequest
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .build

    def describeAppInstanceUserResponse(
      appInstanceUser: Option[AppInstanceUser] = None
    ): DescribeAppInstanceUserResponse =
      DescribeAppInstanceUserResponse
        .builder
        .ifSome(appInstanceUser)(_.appInstanceUser(_))
        .build

    def describeChannelBanRequest(
      channelArn: Option[String] = None,
      memberArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DescribeChannelBanRequest =
      DescribeChannelBanRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def describeChannelBanResponse(
      channelBan: Option[ChannelBan] = None
    ): DescribeChannelBanResponse =
      DescribeChannelBanResponse
        .builder
        .ifSome(channelBan)(_.channelBan(_))
        .build

    def describeChannelMembershipForAppInstanceUserRequest(
      channelArn: Option[String] = None,
      appInstanceUserArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DescribeChannelMembershipForAppInstanceUserRequest =
      DescribeChannelMembershipForAppInstanceUserRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def describeChannelMembershipForAppInstanceUserResponse(
      channelMembership: Option[ChannelMembershipForAppInstanceUserSummary] = None
    ): DescribeChannelMembershipForAppInstanceUserResponse =
      DescribeChannelMembershipForAppInstanceUserResponse
        .builder
        .ifSome(channelMembership)(_.channelMembership(_))
        .build

    def describeChannelMembershipRequest(
      channelArn: Option[String] = None,
      memberArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DescribeChannelMembershipRequest =
      DescribeChannelMembershipRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(memberArn)(_.memberArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def describeChannelMembershipResponse(
      channelMembership: Option[ChannelMembership] = None
    ): DescribeChannelMembershipResponse =
      DescribeChannelMembershipResponse
        .builder
        .ifSome(channelMembership)(_.channelMembership(_))
        .build

    def describeChannelModeratedByAppInstanceUserRequest(
      channelArn: Option[String] = None,
      appInstanceUserArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DescribeChannelModeratedByAppInstanceUserRequest =
      DescribeChannelModeratedByAppInstanceUserRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def describeChannelModeratedByAppInstanceUserResponse(
      channel: Option[ChannelModeratedByAppInstanceUserSummary] = None
    ): DescribeChannelModeratedByAppInstanceUserResponse =
      DescribeChannelModeratedByAppInstanceUserResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def describeChannelModeratorRequest(
      channelArn: Option[String] = None,
      channelModeratorArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DescribeChannelModeratorRequest =
      DescribeChannelModeratorRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(channelModeratorArn)(_.channelModeratorArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def describeChannelModeratorResponse(
      channelModerator: Option[ChannelModerator] = None
    ): DescribeChannelModeratorResponse =
      DescribeChannelModeratorResponse
        .builder
        .ifSome(channelModerator)(_.channelModerator(_))
        .build

    def describeChannelRequest(
      channelArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): DescribeChannelRequest =
      DescribeChannelRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def describeChannelResponse(
      channel: Option[Channel] = None
    ): DescribeChannelResponse =
      DescribeChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def disassociatePhoneNumberFromUserRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None
    ): DisassociatePhoneNumberFromUserRequest =
      DisassociatePhoneNumberFromUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def disassociatePhoneNumberFromUserResponse(

    ): DisassociatePhoneNumberFromUserResponse =
      DisassociatePhoneNumberFromUserResponse
        .builder

        .build

    def disassociatePhoneNumbersFromVoiceConnectorGroupRequest(
      voiceConnectorGroupId: Option[String] = None,
      e164PhoneNumbers: Option[List[E164PhoneNumber]] = None
    ): DisassociatePhoneNumbersFromVoiceConnectorGroupRequest =
      DisassociatePhoneNumbersFromVoiceConnectorGroupRequest
        .builder
        .ifSome(voiceConnectorGroupId)(_.voiceConnectorGroupId(_))
        .ifSome(e164PhoneNumbers)(_.e164PhoneNumbers(_))
        .build

    def disassociatePhoneNumbersFromVoiceConnectorGroupResponse(
      phoneNumberErrors: Option[List[PhoneNumberError]] = None
    ): DisassociatePhoneNumbersFromVoiceConnectorGroupResponse =
      DisassociatePhoneNumbersFromVoiceConnectorGroupResponse
        .builder
        .ifSome(phoneNumberErrors)(_.phoneNumberErrors(_))
        .build

    def disassociatePhoneNumbersFromVoiceConnectorRequest(
      voiceConnectorId: Option[String] = None,
      e164PhoneNumbers: Option[List[E164PhoneNumber]] = None
    ): DisassociatePhoneNumbersFromVoiceConnectorRequest =
      DisassociatePhoneNumbersFromVoiceConnectorRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(e164PhoneNumbers)(_.e164PhoneNumbers(_))
        .build

    def disassociatePhoneNumbersFromVoiceConnectorResponse(
      phoneNumberErrors: Option[List[PhoneNumberError]] = None
    ): DisassociatePhoneNumbersFromVoiceConnectorResponse =
      DisassociatePhoneNumbersFromVoiceConnectorResponse
        .builder
        .ifSome(phoneNumberErrors)(_.phoneNumberErrors(_))
        .build

    def disassociateSigninDelegateGroupsFromAccountRequest(
      accountId: Option[String] = None,
      groupNames: Option[List[String]] = None
    ): DisassociateSigninDelegateGroupsFromAccountRequest =
      DisassociateSigninDelegateGroupsFromAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(groupNames)(_.groupNames(_))
        .build

    def disassociateSigninDelegateGroupsFromAccountResponse(

    ): DisassociateSigninDelegateGroupsFromAccountResponse =
      DisassociateSigninDelegateGroupsFromAccountResponse
        .builder

        .build

    def emergencyCallingConfiguration(
      dNIS: Option[List[DNISEmergencyCallingConfiguration]] = None
    ): EmergencyCallingConfiguration =
      EmergencyCallingConfiguration
        .builder
        .ifSome(dNIS)(_.dNIS(_))
        .build

    def eventsConfiguration(
      botId: Option[String] = None,
      outboundEventsHTTPSEndpoint: Option[String] = None,
      lambdaFunctionArn: Option[String] = None
    ): EventsConfiguration =
      EventsConfiguration
        .builder
        .ifSome(botId)(_.botId(_))
        .ifSome(outboundEventsHTTPSEndpoint)(_.outboundEventsHTTPSEndpoint(_))
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .build

    def forbiddenException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def geoMatchParams(
      country: Option[String] = None,
      areaCode: Option[String] = None
    ): GeoMatchParams =
      GeoMatchParams
        .builder
        .ifSome(country)(_.country(_))
        .ifSome(areaCode)(_.areaCode(_))
        .build

    def getAccountRequest(
      accountId: Option[String] = None
    ): GetAccountRequest =
      GetAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def getAccountResponse(
      account: Option[Account] = None
    ): GetAccountResponse =
      GetAccountResponse
        .builder
        .ifSome(account)(_.account(_))
        .build

    def getAccountSettingsRequest(
      accountId: Option[String] = None
    ): GetAccountSettingsRequest =
      GetAccountSettingsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def getAccountSettingsResponse(
      accountSettings: Option[AccountSettings] = None
    ): GetAccountSettingsResponse =
      GetAccountSettingsResponse
        .builder
        .ifSome(accountSettings)(_.accountSettings(_))
        .build

    def getAppInstanceRetentionSettingsRequest(
      appInstanceArn: Option[String] = None
    ): GetAppInstanceRetentionSettingsRequest =
      GetAppInstanceRetentionSettingsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def getAppInstanceRetentionSettingsResponse(
      appInstanceRetentionSettings: Option[AppInstanceRetentionSettings] = None,
      initiateDeletionTimestamp: Option[Timestamp] = None
    ): GetAppInstanceRetentionSettingsResponse =
      GetAppInstanceRetentionSettingsResponse
        .builder
        .ifSome(appInstanceRetentionSettings)(_.appInstanceRetentionSettings(_))
        .ifSome(initiateDeletionTimestamp)(_.initiateDeletionTimestamp(_))
        .build

    def getAppInstanceStreamingConfigurationsRequest(
      appInstanceArn: Option[String] = None
    ): GetAppInstanceStreamingConfigurationsRequest =
      GetAppInstanceStreamingConfigurationsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def getAppInstanceStreamingConfigurationsResponse(
      appInstanceStreamingConfigurations: Option[List[AppInstanceStreamingConfiguration]] = None
    ): GetAppInstanceStreamingConfigurationsResponse =
      GetAppInstanceStreamingConfigurationsResponse
        .builder
        .ifSome(appInstanceStreamingConfigurations)(_.appInstanceStreamingConfigurations(_))
        .build

    def getAttendeeRequest(
      meetingId: Option[String] = None,
      attendeeId: Option[String] = None
    ): GetAttendeeRequest =
      GetAttendeeRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(attendeeId)(_.attendeeId(_))
        .build

    def getAttendeeResponse(
      attendee: Option[Attendee] = None
    ): GetAttendeeResponse =
      GetAttendeeResponse
        .builder
        .ifSome(attendee)(_.attendee(_))
        .build

    def getBotRequest(
      accountId: Option[String] = None,
      botId: Option[String] = None
    ): GetBotRequest =
      GetBotRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(botId)(_.botId(_))
        .build

    def getBotResponse(
      bot: Option[Bot] = None
    ): GetBotResponse =
      GetBotResponse
        .builder
        .ifSome(bot)(_.bot(_))
        .build

    def getChannelMessageRequest(
      channelArn: Option[String] = None,
      messageId: Option[String] = None,
      chimeBearer: Option[String] = None
    ): GetChannelMessageRequest =
      GetChannelMessageRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def getChannelMessageResponse(
      channelMessage: Option[ChannelMessage] = None
    ): GetChannelMessageResponse =
      GetChannelMessageResponse
        .builder
        .ifSome(channelMessage)(_.channelMessage(_))
        .build

    def getEventsConfigurationRequest(
      accountId: Option[String] = None,
      botId: Option[String] = None
    ): GetEventsConfigurationRequest =
      GetEventsConfigurationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(botId)(_.botId(_))
        .build

    def getEventsConfigurationResponse(
      eventsConfiguration: Option[EventsConfiguration] = None
    ): GetEventsConfigurationResponse =
      GetEventsConfigurationResponse
        .builder
        .ifSome(eventsConfiguration)(_.eventsConfiguration(_))
        .build

    def getGlobalSettingsResponse(
      businessCalling: Option[BusinessCallingSettings] = None,
      voiceConnector: Option[VoiceConnectorSettings] = None
    ): GetGlobalSettingsResponse =
      GetGlobalSettingsResponse
        .builder
        .ifSome(businessCalling)(_.businessCalling(_))
        .ifSome(voiceConnector)(_.voiceConnector(_))
        .build

    def getMeetingRequest(
      meetingId: Option[String] = None
    ): GetMeetingRequest =
      GetMeetingRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .build

    def getMeetingResponse(
      meeting: Option[Meeting] = None
    ): GetMeetingResponse =
      GetMeetingResponse
        .builder
        .ifSome(meeting)(_.meeting(_))
        .build

    def getMessagingSessionEndpointRequest(

    ): GetMessagingSessionEndpointRequest =
      GetMessagingSessionEndpointRequest
        .builder

        .build

    def getMessagingSessionEndpointResponse(
      endpoint: Option[MessagingSessionEndpoint] = None
    ): GetMessagingSessionEndpointResponse =
      GetMessagingSessionEndpointResponse
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def getPhoneNumberOrderRequest(
      phoneNumberOrderId: Option[String] = None
    ): GetPhoneNumberOrderRequest =
      GetPhoneNumberOrderRequest
        .builder
        .ifSome(phoneNumberOrderId)(_.phoneNumberOrderId(_))
        .build

    def getPhoneNumberOrderResponse(
      phoneNumberOrder: Option[PhoneNumberOrder] = None
    ): GetPhoneNumberOrderResponse =
      GetPhoneNumberOrderResponse
        .builder
        .ifSome(phoneNumberOrder)(_.phoneNumberOrder(_))
        .build

    def getPhoneNumberRequest(
      phoneNumberId: Option[String] = None
    ): GetPhoneNumberRequest =
      GetPhoneNumberRequest
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .build

    def getPhoneNumberResponse(
      phoneNumber: Option[PhoneNumber] = None
    ): GetPhoneNumberResponse =
      GetPhoneNumberResponse
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def getPhoneNumberSettingsResponse(
      callingName: Option[String] = None,
      callingNameUpdatedTimestamp: Option[Iso8601Timestamp] = None
    ): GetPhoneNumberSettingsResponse =
      GetPhoneNumberSettingsResponse
        .builder
        .ifSome(callingName)(_.callingName(_))
        .ifSome(callingNameUpdatedTimestamp)(_.callingNameUpdatedTimestamp(_))
        .build

    def getProxySessionRequest(
      voiceConnectorId: Option[String] = None,
      proxySessionId: Option[String] = None
    ): GetProxySessionRequest =
      GetProxySessionRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(proxySessionId)(_.proxySessionId(_))
        .build

    def getProxySessionResponse(
      proxySession: Option[ProxySession] = None
    ): GetProxySessionResponse =
      GetProxySessionResponse
        .builder
        .ifSome(proxySession)(_.proxySession(_))
        .build

    def getRetentionSettingsRequest(
      accountId: Option[String] = None
    ): GetRetentionSettingsRequest =
      GetRetentionSettingsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def getRetentionSettingsResponse(
      retentionSettings: Option[RetentionSettings] = None,
      initiateDeletionTimestamp: Option[Iso8601Timestamp] = None
    ): GetRetentionSettingsResponse =
      GetRetentionSettingsResponse
        .builder
        .ifSome(retentionSettings)(_.retentionSettings(_))
        .ifSome(initiateDeletionTimestamp)(_.initiateDeletionTimestamp(_))
        .build

    def getRoomRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None
    ): GetRoomRequest =
      GetRoomRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .build

    def getRoomResponse(
      room: Option[Room] = None
    ): GetRoomResponse =
      GetRoomResponse
        .builder
        .ifSome(room)(_.room(_))
        .build

    def getSipMediaApplicationLoggingConfigurationRequest(
      sipMediaApplicationId: Option[String] = None
    ): GetSipMediaApplicationLoggingConfigurationRequest =
      GetSipMediaApplicationLoggingConfigurationRequest
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .build

    def getSipMediaApplicationLoggingConfigurationResponse(
      sipMediaApplicationLoggingConfiguration: Option[SipMediaApplicationLoggingConfiguration] = None
    ): GetSipMediaApplicationLoggingConfigurationResponse =
      GetSipMediaApplicationLoggingConfigurationResponse
        .builder
        .ifSome(sipMediaApplicationLoggingConfiguration)(_.sipMediaApplicationLoggingConfiguration(_))
        .build

    def getSipMediaApplicationRequest(
      sipMediaApplicationId: Option[String] = None
    ): GetSipMediaApplicationRequest =
      GetSipMediaApplicationRequest
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .build

    def getSipMediaApplicationResponse(
      sipMediaApplication: Option[SipMediaApplication] = None
    ): GetSipMediaApplicationResponse =
      GetSipMediaApplicationResponse
        .builder
        .ifSome(sipMediaApplication)(_.sipMediaApplication(_))
        .build

    def getSipRuleRequest(
      sipRuleId: Option[String] = None
    ): GetSipRuleRequest =
      GetSipRuleRequest
        .builder
        .ifSome(sipRuleId)(_.sipRuleId(_))
        .build

    def getSipRuleResponse(
      sipRule: Option[SipRule] = None
    ): GetSipRuleResponse =
      GetSipRuleResponse
        .builder
        .ifSome(sipRule)(_.sipRule(_))
        .build

    def getUserRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None
    ): GetUserRequest =
      GetUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def getUserResponse(
      user: Option[User] = None
    ): GetUserResponse =
      GetUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def getUserSettingsRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None
    ): GetUserSettingsRequest =
      GetUserSettingsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def getUserSettingsResponse(
      userSettings: Option[UserSettings] = None
    ): GetUserSettingsResponse =
      GetUserSettingsResponse
        .builder
        .ifSome(userSettings)(_.userSettings(_))
        .build

    def getVoiceConnectorEmergencyCallingConfigurationRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorEmergencyCallingConfigurationRequest =
      GetVoiceConnectorEmergencyCallingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorEmergencyCallingConfigurationResponse(
      emergencyCallingConfiguration: Option[EmergencyCallingConfiguration] = None
    ): GetVoiceConnectorEmergencyCallingConfigurationResponse =
      GetVoiceConnectorEmergencyCallingConfigurationResponse
        .builder
        .ifSome(emergencyCallingConfiguration)(_.emergencyCallingConfiguration(_))
        .build

    def getVoiceConnectorGroupRequest(
      voiceConnectorGroupId: Option[String] = None
    ): GetVoiceConnectorGroupRequest =
      GetVoiceConnectorGroupRequest
        .builder
        .ifSome(voiceConnectorGroupId)(_.voiceConnectorGroupId(_))
        .build

    def getVoiceConnectorGroupResponse(
      voiceConnectorGroup: Option[VoiceConnectorGroup] = None
    ): GetVoiceConnectorGroupResponse =
      GetVoiceConnectorGroupResponse
        .builder
        .ifSome(voiceConnectorGroup)(_.voiceConnectorGroup(_))
        .build

    def getVoiceConnectorLoggingConfigurationRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorLoggingConfigurationRequest =
      GetVoiceConnectorLoggingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorLoggingConfigurationResponse(
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): GetVoiceConnectorLoggingConfigurationResponse =
      GetVoiceConnectorLoggingConfigurationResponse
        .builder
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def getVoiceConnectorOriginationRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorOriginationRequest =
      GetVoiceConnectorOriginationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorOriginationResponse(
      origination: Option[Origination] = None
    ): GetVoiceConnectorOriginationResponse =
      GetVoiceConnectorOriginationResponse
        .builder
        .ifSome(origination)(_.origination(_))
        .build

    def getVoiceConnectorProxyRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorProxyRequest =
      GetVoiceConnectorProxyRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorProxyResponse(
      proxy: Option[Proxy] = None
    ): GetVoiceConnectorProxyResponse =
      GetVoiceConnectorProxyResponse
        .builder
        .ifSome(proxy)(_.proxy(_))
        .build

    def getVoiceConnectorRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorRequest =
      GetVoiceConnectorRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorResponse(
      voiceConnector: Option[VoiceConnector] = None
    ): GetVoiceConnectorResponse =
      GetVoiceConnectorResponse
        .builder
        .ifSome(voiceConnector)(_.voiceConnector(_))
        .build

    def getVoiceConnectorStreamingConfigurationRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorStreamingConfigurationRequest =
      GetVoiceConnectorStreamingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorStreamingConfigurationResponse(
      streamingConfiguration: Option[StreamingConfiguration] = None
    ): GetVoiceConnectorStreamingConfigurationResponse =
      GetVoiceConnectorStreamingConfigurationResponse
        .builder
        .ifSome(streamingConfiguration)(_.streamingConfiguration(_))
        .build

    def getVoiceConnectorTerminationHealthRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorTerminationHealthRequest =
      GetVoiceConnectorTerminationHealthRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorTerminationHealthResponse(
      terminationHealth: Option[TerminationHealth] = None
    ): GetVoiceConnectorTerminationHealthResponse =
      GetVoiceConnectorTerminationHealthResponse
        .builder
        .ifSome(terminationHealth)(_.terminationHealth(_))
        .build

    def getVoiceConnectorTerminationRequest(
      voiceConnectorId: Option[String] = None
    ): GetVoiceConnectorTerminationRequest =
      GetVoiceConnectorTerminationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def getVoiceConnectorTerminationResponse(
      termination: Option[Termination] = None
    ): GetVoiceConnectorTerminationResponse =
      GetVoiceConnectorTerminationResponse
        .builder
        .ifSome(termination)(_.termination(_))
        .build

    def identity(
      arn: Option[String] = None,
      name: Option[String] = None
    ): Identity =
      Identity
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def invite(
      inviteId: Option[String] = None,
      status: Option[String] = None,
      emailAddress: Option[String] = None,
      emailStatus: Option[String] = None
    ): Invite =
      Invite
        .builder
        .ifSome(inviteId)(_.inviteId(_))
        .ifSome(status)(_.status(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(emailStatus)(_.emailStatus(_))
        .build

    def inviteUsersRequest(
      accountId: Option[String] = None,
      userEmailList: Option[List[EmailAddress]] = None,
      userType: Option[String] = None
    ): InviteUsersRequest =
      InviteUsersRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userEmailList)(_.userEmailList(_))
        .ifSome(userType)(_.userType(_))
        .build

    def inviteUsersResponse(
      invites: Option[List[Invite]] = None
    ): InviteUsersResponse =
      InviteUsersResponse
        .builder
        .ifSome(invites)(_.invites(_))
        .build

    def listAccountsRequest(
      name: Option[String] = None,
      userEmail: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccountsRequest =
      ListAccountsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(userEmail)(_.userEmail(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAccountsResponse(
      accounts: Option[List[Account]] = None,
      nextToken: Option[String] = None
    ): ListAccountsResponse =
      ListAccountsResponse
        .builder
        .ifSome(accounts)(_.accounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppInstanceAdminsRequest(
      appInstanceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAppInstanceAdminsRequest =
      ListAppInstanceAdminsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppInstanceAdminsResponse(
      appInstanceArn: Option[String] = None,
      appInstanceAdmins: Option[List[AppInstanceAdminSummary]] = None,
      nextToken: Option[String] = None
    ): ListAppInstanceAdminsResponse =
      ListAppInstanceAdminsResponse
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(appInstanceAdmins)(_.appInstanceAdmins(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppInstanceUsersRequest(
      appInstanceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAppInstanceUsersRequest =
      ListAppInstanceUsersRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppInstanceUsersResponse(
      appInstanceArn: Option[String] = None,
      appInstanceUsers: Option[List[AppInstanceUserSummary]] = None,
      nextToken: Option[String] = None
    ): ListAppInstanceUsersResponse =
      ListAppInstanceUsersResponse
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(appInstanceUsers)(_.appInstanceUsers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppInstancesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAppInstancesRequest =
      ListAppInstancesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAppInstancesResponse(
      appInstances: Option[List[AppInstanceSummary]] = None,
      nextToken: Option[String] = None
    ): ListAppInstancesResponse =
      ListAppInstancesResponse
        .builder
        .ifSome(appInstances)(_.appInstances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAttendeeTagsRequest(
      meetingId: Option[String] = None,
      attendeeId: Option[String] = None
    ): ListAttendeeTagsRequest =
      ListAttendeeTagsRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(attendeeId)(_.attendeeId(_))
        .build

    def listAttendeeTagsResponse(
      tags: Option[List[Tag]] = None
    ): ListAttendeeTagsResponse =
      ListAttendeeTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listAttendeesRequest(
      meetingId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAttendeesRequest =
      ListAttendeesRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAttendeesResponse(
      attendees: Option[List[Attendee]] = None,
      nextToken: Option[String] = None
    ): ListAttendeesResponse =
      ListAttendeesResponse
        .builder
        .ifSome(attendees)(_.attendees(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotsRequest(
      accountId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBotsRequest =
      ListBotsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBotsResponse(
      bots: Option[List[Bot]] = None,
      nextToken: Option[String] = None
    ): ListBotsResponse =
      ListBotsResponse
        .builder
        .ifSome(bots)(_.bots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listChannelBansRequest(
      channelArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelBansRequest =
      ListChannelBansRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelBansResponse(
      channelArn: Option[String] = None,
      nextToken: Option[String] = None,
      channelBans: Option[List[ChannelBanSummary]] = None
    ): ListChannelBansResponse =
      ListChannelBansResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(channelBans)(_.channelBans(_))
        .build

    def listChannelMembershipsForAppInstanceUserRequest(
      appInstanceUserArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelMembershipsForAppInstanceUserRequest =
      ListChannelMembershipsForAppInstanceUserRequest
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelMembershipsForAppInstanceUserResponse(
      channelMemberships: Option[List[ChannelMembershipForAppInstanceUserSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelMembershipsForAppInstanceUserResponse =
      ListChannelMembershipsForAppInstanceUserResponse
        .builder
        .ifSome(channelMemberships)(_.channelMemberships(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listChannelMembershipsRequest(
      channelArn: Option[String] = None,
      `type`: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelMembershipsRequest =
      ListChannelMembershipsRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelMembershipsResponse(
      channelArn: Option[String] = None,
      channelMemberships: Option[List[ChannelMembershipSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelMembershipsResponse =
      ListChannelMembershipsResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(channelMemberships)(_.channelMemberships(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listChannelMessagesRequest(
      channelArn: Option[String] = None,
      sortOrder: Option[String] = None,
      notBefore: Option[Timestamp] = None,
      notAfter: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelMessagesRequest =
      ListChannelMessagesRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(notAfter)(_.notAfter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelMessagesResponse(
      channelArn: Option[String] = None,
      nextToken: Option[String] = None,
      channelMessages: Option[List[ChannelMessageSummary]] = None
    ): ListChannelMessagesResponse =
      ListChannelMessagesResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(channelMessages)(_.channelMessages(_))
        .build

    def listChannelModeratorsRequest(
      channelArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelModeratorsRequest =
      ListChannelModeratorsRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelModeratorsResponse(
      channelArn: Option[String] = None,
      nextToken: Option[String] = None,
      channelModerators: Option[List[ChannelModeratorSummary]] = None
    ): ListChannelModeratorsResponse =
      ListChannelModeratorsResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(channelModerators)(_.channelModerators(_))
        .build

    def listChannelsModeratedByAppInstanceUserRequest(
      appInstanceUserArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelsModeratedByAppInstanceUserRequest =
      ListChannelsModeratedByAppInstanceUserRequest
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelsModeratedByAppInstanceUserResponse(
      channels: Option[List[ChannelModeratedByAppInstanceUserSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelsModeratedByAppInstanceUserResponse =
      ListChannelsModeratedByAppInstanceUserResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listChannelsRequest(
      appInstanceArn: Option[String] = None,
      privacy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): ListChannelsRequest =
      ListChannelsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(privacy)(_.privacy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def listChannelsResponse(
      channels: Option[List[ChannelSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelsResponse =
      ListChannelsResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMeetingTagsRequest(
      meetingId: Option[String] = None
    ): ListMeetingTagsRequest =
      ListMeetingTagsRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .build

    def listMeetingTagsResponse(
      tags: Option[List[Tag]] = None
    ): ListMeetingTagsResponse =
      ListMeetingTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listMeetingsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMeetingsRequest =
      ListMeetingsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMeetingsResponse(
      meetings: Option[List[Meeting]] = None,
      nextToken: Option[String] = None
    ): ListMeetingsResponse =
      ListMeetingsResponse
        .builder
        .ifSome(meetings)(_.meetings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPhoneNumberOrdersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPhoneNumberOrdersRequest =
      ListPhoneNumberOrdersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPhoneNumberOrdersResponse(
      phoneNumberOrders: Option[List[PhoneNumberOrder]] = None,
      nextToken: Option[String] = None
    ): ListPhoneNumberOrdersResponse =
      ListPhoneNumberOrdersResponse
        .builder
        .ifSome(phoneNumberOrders)(_.phoneNumberOrders(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPhoneNumbersRequest(
      status: Option[String] = None,
      productType: Option[String] = None,
      filterName: Option[String] = None,
      filterValue: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPhoneNumbersRequest =
      ListPhoneNumbersRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(filterName)(_.filterName(_))
        .ifSome(filterValue)(_.filterValue(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPhoneNumbersResponse(
      phoneNumbers: Option[List[PhoneNumber]] = None,
      nextToken: Option[String] = None
    ): ListPhoneNumbersResponse =
      ListPhoneNumbersResponse
        .builder
        .ifSome(phoneNumbers)(_.phoneNumbers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProxySessionsRequest(
      voiceConnectorId: Option[String] = None,
      status: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProxySessionsRequest =
      ListProxySessionsRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(status)(_.status(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProxySessionsResponse(
      proxySessions: Option[List[ProxySession]] = None,
      nextToken: Option[String] = None
    ): ListProxySessionsResponse =
      ListProxySessionsResponse
        .builder
        .ifSome(proxySessions)(_.proxySessions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoomMembershipsRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRoomMembershipsRequest =
      ListRoomMembershipsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoomMembershipsResponse(
      roomMemberships: Option[List[RoomMembership]] = None,
      nextToken: Option[String] = None
    ): ListRoomMembershipsResponse =
      ListRoomMembershipsResponse
        .builder
        .ifSome(roomMemberships)(_.roomMemberships(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoomsRequest(
      accountId: Option[String] = None,
      memberId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListRoomsRequest =
      ListRoomsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoomsResponse(
      rooms: Option[List[Room]] = None,
      nextToken: Option[String] = None
    ): ListRoomsResponse =
      ListRoomsResponse
        .builder
        .ifSome(rooms)(_.rooms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSipMediaApplicationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSipMediaApplicationsRequest =
      ListSipMediaApplicationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSipMediaApplicationsResponse(
      sipMediaApplications: Option[List[SipMediaApplication]] = None,
      nextToken: Option[String] = None
    ): ListSipMediaApplicationsResponse =
      ListSipMediaApplicationsResponse
        .builder
        .ifSome(sipMediaApplications)(_.sipMediaApplications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSipRulesRequest(
      sipMediaApplicationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSipRulesRequest =
      ListSipRulesRequest
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSipRulesResponse(
      sipRules: Option[List[SipRule]] = None,
      nextToken: Option[String] = None
    ): ListSipRulesResponse =
      ListSipRulesResponse
        .builder
        .ifSome(sipRules)(_.sipRules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSupportedPhoneNumberCountriesRequest(
      productType: Option[String] = None
    ): ListSupportedPhoneNumberCountriesRequest =
      ListSupportedPhoneNumberCountriesRequest
        .builder
        .ifSome(productType)(_.productType(_))
        .build

    def listSupportedPhoneNumberCountriesResponse(
      phoneNumberCountries: Option[List[PhoneNumberCountry]] = None
    ): ListSupportedPhoneNumberCountriesResponse =
      ListSupportedPhoneNumberCountriesResponse
        .builder
        .ifSome(phoneNumberCountries)(_.phoneNumberCountries(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listUsersRequest(
      accountId: Option[String] = None,
      userEmail: Option[String] = None,
      userType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userEmail)(_.userEmail(_))
        .ifSome(userType)(_.userType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersResponse(
      users: Option[List[User]] = None,
      nextToken: Option[String] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVoiceConnectorGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListVoiceConnectorGroupsRequest =
      ListVoiceConnectorGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listVoiceConnectorGroupsResponse(
      voiceConnectorGroups: Option[List[VoiceConnectorGroup]] = None,
      nextToken: Option[String] = None
    ): ListVoiceConnectorGroupsResponse =
      ListVoiceConnectorGroupsResponse
        .builder
        .ifSome(voiceConnectorGroups)(_.voiceConnectorGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVoiceConnectorTerminationCredentialsRequest(
      voiceConnectorId: Option[String] = None
    ): ListVoiceConnectorTerminationCredentialsRequest =
      ListVoiceConnectorTerminationCredentialsRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .build

    def listVoiceConnectorTerminationCredentialsResponse(
      usernames: Option[List[SensitiveString]] = None
    ): ListVoiceConnectorTerminationCredentialsResponse =
      ListVoiceConnectorTerminationCredentialsResponse
        .builder
        .ifSome(usernames)(_.usernames(_))
        .build

    def listVoiceConnectorsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListVoiceConnectorsRequest =
      ListVoiceConnectorsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listVoiceConnectorsResponse(
      voiceConnectors: Option[List[VoiceConnector]] = None,
      nextToken: Option[String] = None
    ): ListVoiceConnectorsResponse =
      ListVoiceConnectorsResponse
        .builder
        .ifSome(voiceConnectors)(_.voiceConnectors(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loggingConfiguration(
      enableSIPLogs: Option[Boolean] = None
    ): LoggingConfiguration =
      LoggingConfiguration
        .builder
        .ifSome(enableSIPLogs)(_.enableSIPLogs(_))
        .build

    def logoutUserRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None
    ): LogoutUserRequest =
      LogoutUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def logoutUserResponse(

    ): LogoutUserResponse =
      LogoutUserResponse
        .builder

        .build

    def mediaPlacement(
      audioHostUrl: Option[String] = None,
      audioFallbackUrl: Option[String] = None,
      screenDataUrl: Option[String] = None,
      screenSharingUrl: Option[String] = None,
      screenViewingUrl: Option[String] = None,
      signalingUrl: Option[String] = None,
      turnControlUrl: Option[String] = None
    ): MediaPlacement =
      MediaPlacement
        .builder
        .ifSome(audioHostUrl)(_.audioHostUrl(_))
        .ifSome(audioFallbackUrl)(_.audioFallbackUrl(_))
        .ifSome(screenDataUrl)(_.screenDataUrl(_))
        .ifSome(screenSharingUrl)(_.screenSharingUrl(_))
        .ifSome(screenViewingUrl)(_.screenViewingUrl(_))
        .ifSome(signalingUrl)(_.signalingUrl(_))
        .ifSome(turnControlUrl)(_.turnControlUrl(_))
        .build

    def meeting(
      meetingId: Option[String] = None,
      externalMeetingId: Option[String] = None,
      mediaPlacement: Option[MediaPlacement] = None,
      mediaRegion: Option[String] = None
    ): Meeting =
      Meeting
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(externalMeetingId)(_.externalMeetingId(_))
        .ifSome(mediaPlacement)(_.mediaPlacement(_))
        .ifSome(mediaRegion)(_.mediaRegion(_))
        .build

    def meetingNotificationConfiguration(
      snsTopicArn: Option[String] = None,
      sqsQueueArn: Option[String] = None
    ): MeetingNotificationConfiguration =
      MeetingNotificationConfiguration
        .builder
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sqsQueueArn)(_.sqsQueueArn(_))
        .build

    def member(
      memberId: Option[String] = None,
      memberType: Option[String] = None,
      email: Option[String] = None,
      fullName: Option[String] = None,
      accountId: Option[String] = None
    ): Member =
      Member
        .builder
        .ifSome(memberId)(_.memberId(_))
        .ifSome(memberType)(_.memberType(_))
        .ifSome(email)(_.email(_))
        .ifSome(fullName)(_.fullName(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def memberError(
      memberId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): MemberError =
      MemberError
        .builder
        .ifSome(memberId)(_.memberId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def membershipItem(
      memberId: Option[String] = None,
      role: Option[String] = None
    ): MembershipItem =
      MembershipItem
        .builder
        .ifSome(memberId)(_.memberId(_))
        .ifSome(role)(_.role(_))
        .build

    def messagingSessionEndpoint(
      url: Option[String] = None
    ): MessagingSessionEndpoint =
      MessagingSessionEndpoint
        .builder
        .ifSome(url)(_.url(_))
        .build

    def notFoundException(
      code: Option[String] = None,
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def orderedPhoneNumber(
      e164PhoneNumber: Option[String] = None,
      status: Option[String] = None
    ): OrderedPhoneNumber =
      OrderedPhoneNumber
        .builder
        .ifSome(e164PhoneNumber)(_.e164PhoneNumber(_))
        .ifSome(status)(_.status(_))
        .build

    def origination(
      routes: Option[List[OriginationRoute]] = None,
      disabled: Option[Boolean] = None
    ): Origination =
      Origination
        .builder
        .ifSome(routes)(_.routes(_))
        .ifSome(disabled)(_.disabled(_))
        .build

    def originationRoute(
      host: Option[String] = None,
      port: Option[Int] = None,
      protocol: Option[String] = None,
      priority: Option[Int] = None,
      weight: Option[Int] = None
    ): OriginationRoute =
      OriginationRoute
        .builder
        .ifSome(host)(_.host(_))
        .ifSome(port)(_.port(_))
        .ifSome(protocol)(_.protocol(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(weight)(_.weight(_))
        .build

    def participant(
      phoneNumber: Option[String] = None,
      proxyPhoneNumber: Option[String] = None
    ): Participant =
      Participant
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(proxyPhoneNumber)(_.proxyPhoneNumber(_))
        .build

    def phoneNumber(
      phoneNumberId: Option[String] = None,
      e164PhoneNumber: Option[String] = None,
      country: Option[String] = None,
      `type`: Option[String] = None,
      productType: Option[String] = None,
      status: Option[String] = None,
      capabilities: Option[PhoneNumberCapabilities] = None,
      associations: Option[List[PhoneNumberAssociation]] = None,
      callingName: Option[String] = None,
      callingNameStatus: Option[String] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None,
      deletionTimestamp: Option[Iso8601Timestamp] = None
    ): PhoneNumber =
      PhoneNumber
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .ifSome(e164PhoneNumber)(_.e164PhoneNumber(_))
        .ifSome(country)(_.country(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(status)(_.status(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(associations)(_.associations(_))
        .ifSome(callingName)(_.callingName(_))
        .ifSome(callingNameStatus)(_.callingNameStatus(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .ifSome(deletionTimestamp)(_.deletionTimestamp(_))
        .build

    def phoneNumberAssociation(
      value: Option[String] = None,
      name: Option[String] = None,
      associatedTimestamp: Option[Iso8601Timestamp] = None
    ): PhoneNumberAssociation =
      PhoneNumberAssociation
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(name)(_.name(_))
        .ifSome(associatedTimestamp)(_.associatedTimestamp(_))
        .build

    def phoneNumberCapabilities(
      inboundCall: Option[Boolean] = None,
      outboundCall: Option[Boolean] = None,
      inboundSMS: Option[Boolean] = None,
      outboundSMS: Option[Boolean] = None,
      inboundMMS: Option[Boolean] = None,
      outboundMMS: Option[Boolean] = None
    ): PhoneNumberCapabilities =
      PhoneNumberCapabilities
        .builder
        .ifSome(inboundCall)(_.inboundCall(_))
        .ifSome(outboundCall)(_.outboundCall(_))
        .ifSome(inboundSMS)(_.inboundSMS(_))
        .ifSome(outboundSMS)(_.outboundSMS(_))
        .ifSome(inboundMMS)(_.inboundMMS(_))
        .ifSome(outboundMMS)(_.outboundMMS(_))
        .build

    def phoneNumberCountry(
      countryCode: Option[String] = None,
      supportedPhoneNumberTypes: Option[List[PhoneNumberType]] = None
    ): PhoneNumberCountry =
      PhoneNumberCountry
        .builder
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(supportedPhoneNumberTypes)(_.supportedPhoneNumberTypes(_))
        .build

    def phoneNumberError(
      phoneNumberId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PhoneNumberError =
      PhoneNumberError
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def phoneNumberOrder(
      phoneNumberOrderId: Option[String] = None,
      productType: Option[String] = None,
      status: Option[String] = None,
      orderedPhoneNumbers: Option[List[OrderedPhoneNumber]] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): PhoneNumberOrder =
      PhoneNumberOrder
        .builder
        .ifSome(phoneNumberOrderId)(_.phoneNumberOrderId(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(status)(_.status(_))
        .ifSome(orderedPhoneNumbers)(_.orderedPhoneNumbers(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def proxy(
      defaultSessionExpiryMinutes: Option[Int] = None,
      disabled: Option[Boolean] = None,
      fallBackPhoneNumber: Option[String] = None,
      phoneNumberCountries: Option[List[String]] = None
    ): Proxy =
      Proxy
        .builder
        .ifSome(defaultSessionExpiryMinutes)(_.defaultSessionExpiryMinutes(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(fallBackPhoneNumber)(_.fallBackPhoneNumber(_))
        .ifSome(phoneNumberCountries)(_.phoneNumberCountries(_))
        .build

    def proxySession(
      voiceConnectorId: Option[String] = None,
      proxySessionId: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      expiryMinutes: Option[Int] = None,
      capabilities: Option[List[Capability]] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None,
      endedTimestamp: Option[Iso8601Timestamp] = None,
      participants: Option[List[Participant]] = None,
      numberSelectionBehavior: Option[String] = None,
      geoMatchLevel: Option[String] = None,
      geoMatchParams: Option[GeoMatchParams] = None
    ): ProxySession =
      ProxySession
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(proxySessionId)(_.proxySessionId(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(expiryMinutes)(_.expiryMinutes(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .ifSome(endedTimestamp)(_.endedTimestamp(_))
        .ifSome(participants)(_.participants(_))
        .ifSome(numberSelectionBehavior)(_.numberSelectionBehavior(_))
        .ifSome(geoMatchLevel)(_.geoMatchLevel(_))
        .ifSome(geoMatchParams)(_.geoMatchParams(_))
        .build

    def putAppInstanceRetentionSettingsRequest(
      appInstanceArn: Option[String] = None,
      appInstanceRetentionSettings: Option[AppInstanceRetentionSettings] = None
    ): PutAppInstanceRetentionSettingsRequest =
      PutAppInstanceRetentionSettingsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(appInstanceRetentionSettings)(_.appInstanceRetentionSettings(_))
        .build

    def putAppInstanceRetentionSettingsResponse(
      appInstanceRetentionSettings: Option[AppInstanceRetentionSettings] = None,
      initiateDeletionTimestamp: Option[Timestamp] = None
    ): PutAppInstanceRetentionSettingsResponse =
      PutAppInstanceRetentionSettingsResponse
        .builder
        .ifSome(appInstanceRetentionSettings)(_.appInstanceRetentionSettings(_))
        .ifSome(initiateDeletionTimestamp)(_.initiateDeletionTimestamp(_))
        .build

    def putAppInstanceStreamingConfigurationsRequest(
      appInstanceArn: Option[String] = None,
      appInstanceStreamingConfigurations: Option[List[AppInstanceStreamingConfiguration]] = None
    ): PutAppInstanceStreamingConfigurationsRequest =
      PutAppInstanceStreamingConfigurationsRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(appInstanceStreamingConfigurations)(_.appInstanceStreamingConfigurations(_))
        .build

    def putAppInstanceStreamingConfigurationsResponse(
      appInstanceStreamingConfigurations: Option[List[AppInstanceStreamingConfiguration]] = None
    ): PutAppInstanceStreamingConfigurationsResponse =
      PutAppInstanceStreamingConfigurationsResponse
        .builder
        .ifSome(appInstanceStreamingConfigurations)(_.appInstanceStreamingConfigurations(_))
        .build

    def putEventsConfigurationRequest(
      accountId: Option[String] = None,
      botId: Option[String] = None,
      outboundEventsHTTPSEndpoint: Option[String] = None,
      lambdaFunctionArn: Option[String] = None
    ): PutEventsConfigurationRequest =
      PutEventsConfigurationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(outboundEventsHTTPSEndpoint)(_.outboundEventsHTTPSEndpoint(_))
        .ifSome(lambdaFunctionArn)(_.lambdaFunctionArn(_))
        .build

    def putEventsConfigurationResponse(
      eventsConfiguration: Option[EventsConfiguration] = None
    ): PutEventsConfigurationResponse =
      PutEventsConfigurationResponse
        .builder
        .ifSome(eventsConfiguration)(_.eventsConfiguration(_))
        .build

    def putRetentionSettingsRequest(
      accountId: Option[String] = None,
      retentionSettings: Option[RetentionSettings] = None
    ): PutRetentionSettingsRequest =
      PutRetentionSettingsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(retentionSettings)(_.retentionSettings(_))
        .build

    def putRetentionSettingsResponse(
      retentionSettings: Option[RetentionSettings] = None,
      initiateDeletionTimestamp: Option[Iso8601Timestamp] = None
    ): PutRetentionSettingsResponse =
      PutRetentionSettingsResponse
        .builder
        .ifSome(retentionSettings)(_.retentionSettings(_))
        .ifSome(initiateDeletionTimestamp)(_.initiateDeletionTimestamp(_))
        .build

    def putSipMediaApplicationLoggingConfigurationRequest(
      sipMediaApplicationId: Option[String] = None,
      sipMediaApplicationLoggingConfiguration: Option[SipMediaApplicationLoggingConfiguration] = None
    ): PutSipMediaApplicationLoggingConfigurationRequest =
      PutSipMediaApplicationLoggingConfigurationRequest
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .ifSome(sipMediaApplicationLoggingConfiguration)(_.sipMediaApplicationLoggingConfiguration(_))
        .build

    def putSipMediaApplicationLoggingConfigurationResponse(
      sipMediaApplicationLoggingConfiguration: Option[SipMediaApplicationLoggingConfiguration] = None
    ): PutSipMediaApplicationLoggingConfigurationResponse =
      PutSipMediaApplicationLoggingConfigurationResponse
        .builder
        .ifSome(sipMediaApplicationLoggingConfiguration)(_.sipMediaApplicationLoggingConfiguration(_))
        .build

    def putVoiceConnectorEmergencyCallingConfigurationRequest(
      voiceConnectorId: Option[String] = None,
      emergencyCallingConfiguration: Option[EmergencyCallingConfiguration] = None
    ): PutVoiceConnectorEmergencyCallingConfigurationRequest =
      PutVoiceConnectorEmergencyCallingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(emergencyCallingConfiguration)(_.emergencyCallingConfiguration(_))
        .build

    def putVoiceConnectorEmergencyCallingConfigurationResponse(
      emergencyCallingConfiguration: Option[EmergencyCallingConfiguration] = None
    ): PutVoiceConnectorEmergencyCallingConfigurationResponse =
      PutVoiceConnectorEmergencyCallingConfigurationResponse
        .builder
        .ifSome(emergencyCallingConfiguration)(_.emergencyCallingConfiguration(_))
        .build

    def putVoiceConnectorLoggingConfigurationRequest(
      voiceConnectorId: Option[String] = None,
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): PutVoiceConnectorLoggingConfigurationRequest =
      PutVoiceConnectorLoggingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def putVoiceConnectorLoggingConfigurationResponse(
      loggingConfiguration: Option[LoggingConfiguration] = None
    ): PutVoiceConnectorLoggingConfigurationResponse =
      PutVoiceConnectorLoggingConfigurationResponse
        .builder
        .ifSome(loggingConfiguration)(_.loggingConfiguration(_))
        .build

    def putVoiceConnectorOriginationRequest(
      voiceConnectorId: Option[String] = None,
      origination: Option[Origination] = None
    ): PutVoiceConnectorOriginationRequest =
      PutVoiceConnectorOriginationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(origination)(_.origination(_))
        .build

    def putVoiceConnectorOriginationResponse(
      origination: Option[Origination] = None
    ): PutVoiceConnectorOriginationResponse =
      PutVoiceConnectorOriginationResponse
        .builder
        .ifSome(origination)(_.origination(_))
        .build

    def putVoiceConnectorProxyRequest(
      voiceConnectorId: Option[String] = None,
      defaultSessionExpiryMinutes: Option[Int] = None,
      phoneNumberPoolCountries: Option[List[Country]] = None,
      fallBackPhoneNumber: Option[String] = None,
      disabled: Option[Boolean] = None
    ): PutVoiceConnectorProxyRequest =
      PutVoiceConnectorProxyRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(defaultSessionExpiryMinutes)(_.defaultSessionExpiryMinutes(_))
        .ifSome(phoneNumberPoolCountries)(_.phoneNumberPoolCountries(_))
        .ifSome(fallBackPhoneNumber)(_.fallBackPhoneNumber(_))
        .ifSome(disabled)(_.disabled(_))
        .build

    def putVoiceConnectorProxyResponse(
      proxy: Option[Proxy] = None
    ): PutVoiceConnectorProxyResponse =
      PutVoiceConnectorProxyResponse
        .builder
        .ifSome(proxy)(_.proxy(_))
        .build

    def putVoiceConnectorStreamingConfigurationRequest(
      voiceConnectorId: Option[String] = None,
      streamingConfiguration: Option[StreamingConfiguration] = None
    ): PutVoiceConnectorStreamingConfigurationRequest =
      PutVoiceConnectorStreamingConfigurationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(streamingConfiguration)(_.streamingConfiguration(_))
        .build

    def putVoiceConnectorStreamingConfigurationResponse(
      streamingConfiguration: Option[StreamingConfiguration] = None
    ): PutVoiceConnectorStreamingConfigurationResponse =
      PutVoiceConnectorStreamingConfigurationResponse
        .builder
        .ifSome(streamingConfiguration)(_.streamingConfiguration(_))
        .build

    def putVoiceConnectorTerminationCredentialsRequest(
      voiceConnectorId: Option[String] = None,
      credentials: Option[List[Credential]] = None
    ): PutVoiceConnectorTerminationCredentialsRequest =
      PutVoiceConnectorTerminationCredentialsRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(credentials)(_.credentials(_))
        .build

    def putVoiceConnectorTerminationRequest(
      voiceConnectorId: Option[String] = None,
      termination: Option[Termination] = None
    ): PutVoiceConnectorTerminationRequest =
      PutVoiceConnectorTerminationRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(termination)(_.termination(_))
        .build

    def putVoiceConnectorTerminationResponse(
      termination: Option[Termination] = None
    ): PutVoiceConnectorTerminationResponse =
      PutVoiceConnectorTerminationResponse
        .builder
        .ifSome(termination)(_.termination(_))
        .build

    def redactChannelMessageRequest(
      channelArn: Option[String] = None,
      messageId: Option[String] = None,
      chimeBearer: Option[String] = None
    ): RedactChannelMessageRequest =
      RedactChannelMessageRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def redactChannelMessageResponse(
      channelArn: Option[String] = None,
      messageId: Option[String] = None
    ): RedactChannelMessageResponse =
      RedactChannelMessageResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .build

    def redactConversationMessageRequest(
      accountId: Option[String] = None,
      conversationId: Option[String] = None,
      messageId: Option[String] = None
    ): RedactConversationMessageRequest =
      RedactConversationMessageRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(conversationId)(_.conversationId(_))
        .ifSome(messageId)(_.messageId(_))
        .build

    def redactConversationMessageResponse(

    ): RedactConversationMessageResponse =
      RedactConversationMessageResponse
        .builder

        .build

    def redactRoomMessageRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      messageId: Option[String] = None
    ): RedactRoomMessageRequest =
      RedactRoomMessageRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(messageId)(_.messageId(_))
        .build

    def redactRoomMessageResponse(

    ): RedactRoomMessageResponse =
      RedactRoomMessageResponse
        .builder

        .build

    def regenerateSecurityTokenRequest(
      accountId: Option[String] = None,
      botId: Option[String] = None
    ): RegenerateSecurityTokenRequest =
      RegenerateSecurityTokenRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(botId)(_.botId(_))
        .build

    def regenerateSecurityTokenResponse(
      bot: Option[Bot] = None
    ): RegenerateSecurityTokenResponse =
      RegenerateSecurityTokenResponse
        .builder
        .ifSome(bot)(_.bot(_))
        .build

    def resetPersonalPINRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None
    ): ResetPersonalPINRequest =
      ResetPersonalPINRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def resetPersonalPINResponse(
      user: Option[User] = None
    ): ResetPersonalPINResponse =
      ResetPersonalPINResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def resourceLimitExceededException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def restorePhoneNumberRequest(
      phoneNumberId: Option[String] = None
    ): RestorePhoneNumberRequest =
      RestorePhoneNumberRequest
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .build

    def restorePhoneNumberResponse(
      phoneNumber: Option[PhoneNumber] = None
    ): RestorePhoneNumberResponse =
      RestorePhoneNumberResponse
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def retentionSettings(
      roomRetentionSettings: Option[RoomRetentionSettings] = None,
      conversationRetentionSettings: Option[ConversationRetentionSettings] = None
    ): RetentionSettings =
      RetentionSettings
        .builder
        .ifSome(roomRetentionSettings)(_.roomRetentionSettings(_))
        .ifSome(conversationRetentionSettings)(_.conversationRetentionSettings(_))
        .build

    def room(
      roomId: Option[String] = None,
      name: Option[String] = None,
      accountId: Option[String] = None,
      createdBy: Option[String] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): Room =
      Room
        .builder
        .ifSome(roomId)(_.roomId(_))
        .ifSome(name)(_.name(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def roomMembership(
      roomId: Option[String] = None,
      member: Option[Member] = None,
      role: Option[String] = None,
      invitedBy: Option[String] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): RoomMembership =
      RoomMembership
        .builder
        .ifSome(roomId)(_.roomId(_))
        .ifSome(member)(_.member(_))
        .ifSome(role)(_.role(_))
        .ifSome(invitedBy)(_.invitedBy(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def roomRetentionSettings(
      retentionDays: Option[Int] = None
    ): RoomRetentionSettings =
      RoomRetentionSettings
        .builder
        .ifSome(retentionDays)(_.retentionDays(_))
        .build

    def searchAvailablePhoneNumbersRequest(
      areaCode: Option[String] = None,
      city: Option[String] = None,
      country: Option[String] = None,
      state: Option[String] = None,
      tollFreePrefix: Option[String] = None,
      phoneNumberType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchAvailablePhoneNumbersRequest =
      SearchAvailablePhoneNumbersRequest
        .builder
        .ifSome(areaCode)(_.areaCode(_))
        .ifSome(city)(_.city(_))
        .ifSome(country)(_.country(_))
        .ifSome(state)(_.state(_))
        .ifSome(tollFreePrefix)(_.tollFreePrefix(_))
        .ifSome(phoneNumberType)(_.phoneNumberType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchAvailablePhoneNumbersResponse(
      e164PhoneNumbers: Option[List[E164PhoneNumber]] = None,
      nextToken: Option[String] = None
    ): SearchAvailablePhoneNumbersResponse =
      SearchAvailablePhoneNumbersResponse
        .builder
        .ifSome(e164PhoneNumbers)(_.e164PhoneNumbers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def sendChannelMessageRequest(
      channelArn: Option[String] = None,
      content: Option[String] = None,
      `type`: Option[String] = None,
      persistence: Option[String] = None,
      metadata: Option[String] = None,
      clientRequestToken: Option[String] = None,
      chimeBearer: Option[String] = None
    ): SendChannelMessageRequest =
      SendChannelMessageRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(content)(_.content(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(persistence)(_.persistence(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def sendChannelMessageResponse(
      channelArn: Option[String] = None,
      messageId: Option[String] = None
    ): SendChannelMessageResponse =
      SendChannelMessageResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .build

    def serviceFailureException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ServiceFailureException =
      ServiceFailureException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def signinDelegateGroup(
      groupName: Option[String] = None
    ): SigninDelegateGroup =
      SigninDelegateGroup
        .builder
        .ifSome(groupName)(_.groupName(_))
        .build

    def sipMediaApplication(
      sipMediaApplicationId: Option[String] = None,
      awsRegion: Option[String] = None,
      name: Option[String] = None,
      endpoints: Option[List[SipMediaApplicationEndpoint]] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): SipMediaApplication =
      SipMediaApplication
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(name)(_.name(_))
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def sipMediaApplicationCall(
      transactionId: Option[String] = None
    ): SipMediaApplicationCall =
      SipMediaApplicationCall
        .builder
        .ifSome(transactionId)(_.transactionId(_))
        .build

    def sipMediaApplicationEndpoint(
      lambdaArn: Option[String] = None
    ): SipMediaApplicationEndpoint =
      SipMediaApplicationEndpoint
        .builder
        .ifSome(lambdaArn)(_.lambdaArn(_))
        .build

    def sipMediaApplicationLoggingConfiguration(
      enableSipMediaApplicationMessageLogs: Option[Boolean] = None
    ): SipMediaApplicationLoggingConfiguration =
      SipMediaApplicationLoggingConfiguration
        .builder
        .ifSome(enableSipMediaApplicationMessageLogs)(_.enableSipMediaApplicationMessageLogs(_))
        .build

    def sipRule(
      sipRuleId: Option[String] = None,
      name: Option[String] = None,
      disabled: Option[Boolean] = None,
      triggerType: Option[String] = None,
      triggerValue: Option[String] = None,
      targetApplications: Option[List[SipRuleTargetApplication]] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): SipRule =
      SipRule
        .builder
        .ifSome(sipRuleId)(_.sipRuleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(triggerType)(_.triggerType(_))
        .ifSome(triggerValue)(_.triggerValue(_))
        .ifSome(targetApplications)(_.targetApplications(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def sipRuleTargetApplication(
      sipMediaApplicationId: Option[String] = None,
      priority: Option[Int] = None,
      awsRegion: Option[String] = None
    ): SipRuleTargetApplication =
      SipRuleTargetApplication
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .build

    def streamingConfiguration(
      dataRetentionInHours: Option[Int] = None,
      disabled: Option[Boolean] = None,
      streamingNotificationTargets: Option[List[StreamingNotificationTarget]] = None
    ): StreamingConfiguration =
      StreamingConfiguration
        .builder
        .ifSome(dataRetentionInHours)(_.dataRetentionInHours(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(streamingNotificationTargets)(_.streamingNotificationTargets(_))
        .build

    def streamingNotificationTarget(
      notificationTarget: Option[String] = None
    ): StreamingNotificationTarget =
      StreamingNotificationTarget
        .builder
        .ifSome(notificationTarget)(_.notificationTarget(_))
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

    def tagAttendeeRequest(
      meetingId: Option[String] = None,
      attendeeId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagAttendeeRequest =
      TagAttendeeRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(attendeeId)(_.attendeeId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagMeetingRequest(
      meetingId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagMeetingRequest =
      TagMeetingRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceRequest(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def telephonySettings(
      inboundCalling: Option[Boolean] = None,
      outboundCalling: Option[Boolean] = None,
      sMS: Option[Boolean] = None
    ): TelephonySettings =
      TelephonySettings
        .builder
        .ifSome(inboundCalling)(_.inboundCalling(_))
        .ifSome(outboundCalling)(_.outboundCalling(_))
        .ifSome(sMS)(_.sMS(_))
        .build

    def termination(
      cpsLimit: Option[Int] = None,
      defaultPhoneNumber: Option[String] = None,
      callingRegions: Option[List[CallingRegion]] = None,
      cidrAllowedList: Option[List[String]] = None,
      disabled: Option[Boolean] = None
    ): Termination =
      Termination
        .builder
        .ifSome(cpsLimit)(_.cpsLimit(_))
        .ifSome(defaultPhoneNumber)(_.defaultPhoneNumber(_))
        .ifSome(callingRegions)(_.callingRegions(_))
        .ifSome(cidrAllowedList)(_.cidrAllowedList(_))
        .ifSome(disabled)(_.disabled(_))
        .build

    def terminationHealth(
      timestamp: Option[Iso8601Timestamp] = None,
      source: Option[String] = None
    ): TerminationHealth =
      TerminationHealth
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(source)(_.source(_))
        .build

    def throttledClientException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ThrottledClientException =
      ThrottledClientException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedClientException(
      code: Option[String] = None,
      message: Option[String] = None
    ): UnauthorizedClientException =
      UnauthorizedClientException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def unprocessableEntityException(
      code: Option[String] = None,
      message: Option[String] = None
    ): UnprocessableEntityException =
      UnprocessableEntityException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def untagAttendeeRequest(
      meetingId: Option[String] = None,
      attendeeId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagAttendeeRequest =
      UntagAttendeeRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(attendeeId)(_.attendeeId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagMeetingRequest(
      meetingId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagMeetingRequest =
      UntagMeetingRequest
        .builder
        .ifSome(meetingId)(_.meetingId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAccountRequest(
      accountId: Option[String] = None,
      name: Option[String] = None,
      defaultLicense: Option[String] = None
    ): UpdateAccountRequest =
      UpdateAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(name)(_.name(_))
        .ifSome(defaultLicense)(_.defaultLicense(_))
        .build

    def updateAccountResponse(
      account: Option[Account] = None
    ): UpdateAccountResponse =
      UpdateAccountResponse
        .builder
        .ifSome(account)(_.account(_))
        .build

    def updateAccountSettingsRequest(
      accountId: Option[String] = None,
      accountSettings: Option[AccountSettings] = None
    ): UpdateAccountSettingsRequest =
      UpdateAccountSettingsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(accountSettings)(_.accountSettings(_))
        .build

    def updateAccountSettingsResponse(

    ): UpdateAccountSettingsResponse =
      UpdateAccountSettingsResponse
        .builder

        .build

    def updateAppInstanceRequest(
      appInstanceArn: Option[String] = None,
      name: Option[String] = None,
      metadata: Option[String] = None
    ): UpdateAppInstanceRequest =
      UpdateAppInstanceRequest
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def updateAppInstanceResponse(
      appInstanceArn: Option[String] = None
    ): UpdateAppInstanceResponse =
      UpdateAppInstanceResponse
        .builder
        .ifSome(appInstanceArn)(_.appInstanceArn(_))
        .build

    def updateAppInstanceUserRequest(
      appInstanceUserArn: Option[String] = None,
      name: Option[String] = None,
      metadata: Option[String] = None
    ): UpdateAppInstanceUserRequest =
      UpdateAppInstanceUserRequest
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def updateAppInstanceUserResponse(
      appInstanceUserArn: Option[String] = None
    ): UpdateAppInstanceUserResponse =
      UpdateAppInstanceUserResponse
        .builder
        .ifSome(appInstanceUserArn)(_.appInstanceUserArn(_))
        .build

    def updateBotRequest(
      accountId: Option[String] = None,
      botId: Option[String] = None,
      disabled: Option[Boolean] = None
    ): UpdateBotRequest =
      UpdateBotRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(botId)(_.botId(_))
        .ifSome(disabled)(_.disabled(_))
        .build

    def updateBotResponse(
      bot: Option[Bot] = None
    ): UpdateBotResponse =
      UpdateBotResponse
        .builder
        .ifSome(bot)(_.bot(_))
        .build

    def updateChannelMessageRequest(
      channelArn: Option[String] = None,
      messageId: Option[String] = None,
      content: Option[String] = None,
      metadata: Option[String] = None,
      chimeBearer: Option[String] = None
    ): UpdateChannelMessageRequest =
      UpdateChannelMessageRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(content)(_.content(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def updateChannelMessageResponse(
      channelArn: Option[String] = None,
      messageId: Option[String] = None
    ): UpdateChannelMessageResponse =
      UpdateChannelMessageResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(messageId)(_.messageId(_))
        .build

    def updateChannelReadMarkerRequest(
      channelArn: Option[String] = None,
      chimeBearer: Option[String] = None
    ): UpdateChannelReadMarkerRequest =
      UpdateChannelReadMarkerRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def updateChannelReadMarkerResponse(
      channelArn: Option[String] = None
    ): UpdateChannelReadMarkerResponse =
      UpdateChannelReadMarkerResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .build

    def updateChannelRequest(
      channelArn: Option[String] = None,
      name: Option[String] = None,
      mode: Option[String] = None,
      metadata: Option[String] = None,
      chimeBearer: Option[String] = None
    ): UpdateChannelRequest =
      UpdateChannelRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(chimeBearer)(_.chimeBearer(_))
        .build

    def updateChannelResponse(
      channelArn: Option[String] = None
    ): UpdateChannelResponse =
      UpdateChannelResponse
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .build

    def updateGlobalSettingsRequest(
      businessCalling: Option[BusinessCallingSettings] = None,
      voiceConnector: Option[VoiceConnectorSettings] = None
    ): UpdateGlobalSettingsRequest =
      UpdateGlobalSettingsRequest
        .builder
        .ifSome(businessCalling)(_.businessCalling(_))
        .ifSome(voiceConnector)(_.voiceConnector(_))
        .build

    def updatePhoneNumberRequest(
      phoneNumberId: Option[String] = None,
      productType: Option[String] = None,
      callingName: Option[String] = None
    ): UpdatePhoneNumberRequest =
      UpdatePhoneNumberRequest
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(callingName)(_.callingName(_))
        .build

    def updatePhoneNumberRequestItem(
      phoneNumberId: Option[String] = None,
      productType: Option[String] = None,
      callingName: Option[String] = None
    ): UpdatePhoneNumberRequestItem =
      UpdatePhoneNumberRequestItem
        .builder
        .ifSome(phoneNumberId)(_.phoneNumberId(_))
        .ifSome(productType)(_.productType(_))
        .ifSome(callingName)(_.callingName(_))
        .build

    def updatePhoneNumberResponse(
      phoneNumber: Option[PhoneNumber] = None
    ): UpdatePhoneNumberResponse =
      UpdatePhoneNumberResponse
        .builder
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .build

    def updatePhoneNumberSettingsRequest(
      callingName: Option[String] = None
    ): UpdatePhoneNumberSettingsRequest =
      UpdatePhoneNumberSettingsRequest
        .builder
        .ifSome(callingName)(_.callingName(_))
        .build

    def updateProxySessionRequest(
      voiceConnectorId: Option[String] = None,
      proxySessionId: Option[String] = None,
      capabilities: Option[List[Capability]] = None,
      expiryMinutes: Option[Int] = None
    ): UpdateProxySessionRequest =
      UpdateProxySessionRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(proxySessionId)(_.proxySessionId(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(expiryMinutes)(_.expiryMinutes(_))
        .build

    def updateProxySessionResponse(
      proxySession: Option[ProxySession] = None
    ): UpdateProxySessionResponse =
      UpdateProxySessionResponse
        .builder
        .ifSome(proxySession)(_.proxySession(_))
        .build

    def updateRoomMembershipRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      memberId: Option[String] = None,
      role: Option[String] = None
    ): UpdateRoomMembershipRequest =
      UpdateRoomMembershipRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(role)(_.role(_))
        .build

    def updateRoomMembershipResponse(
      roomMembership: Option[RoomMembership] = None
    ): UpdateRoomMembershipResponse =
      UpdateRoomMembershipResponse
        .builder
        .ifSome(roomMembership)(_.roomMembership(_))
        .build

    def updateRoomRequest(
      accountId: Option[String] = None,
      roomId: Option[String] = None,
      name: Option[String] = None
    ): UpdateRoomRequest =
      UpdateRoomRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(roomId)(_.roomId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateRoomResponse(
      room: Option[Room] = None
    ): UpdateRoomResponse =
      UpdateRoomResponse
        .builder
        .ifSome(room)(_.room(_))
        .build

    def updateSipMediaApplicationRequest(
      sipMediaApplicationId: Option[String] = None,
      name: Option[String] = None,
      endpoints: Option[List[SipMediaApplicationEndpoint]] = None
    ): UpdateSipMediaApplicationRequest =
      UpdateSipMediaApplicationRequest
        .builder
        .ifSome(sipMediaApplicationId)(_.sipMediaApplicationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def updateSipMediaApplicationResponse(
      sipMediaApplication: Option[SipMediaApplication] = None
    ): UpdateSipMediaApplicationResponse =
      UpdateSipMediaApplicationResponse
        .builder
        .ifSome(sipMediaApplication)(_.sipMediaApplication(_))
        .build

    def updateSipRuleRequest(
      sipRuleId: Option[String] = None,
      name: Option[String] = None,
      disabled: Option[Boolean] = None,
      targetApplications: Option[List[SipRuleTargetApplication]] = None
    ): UpdateSipRuleRequest =
      UpdateSipRuleRequest
        .builder
        .ifSome(sipRuleId)(_.sipRuleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(disabled)(_.disabled(_))
        .ifSome(targetApplications)(_.targetApplications(_))
        .build

    def updateSipRuleResponse(
      sipRule: Option[SipRule] = None
    ): UpdateSipRuleResponse =
      UpdateSipRuleResponse
        .builder
        .ifSome(sipRule)(_.sipRule(_))
        .build

    def updateUserRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None,
      licenseType: Option[String] = None,
      userType: Option[String] = None,
      alexaForBusinessMetadata: Option[AlexaForBusinessMetadata] = None
    ): UpdateUserRequest =
      UpdateUserRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(userType)(_.userType(_))
        .ifSome(alexaForBusinessMetadata)(_.alexaForBusinessMetadata(_))
        .build

    def updateUserRequestItem(
      userId: Option[String] = None,
      licenseType: Option[String] = None,
      userType: Option[String] = None,
      alexaForBusinessMetadata: Option[AlexaForBusinessMetadata] = None
    ): UpdateUserRequestItem =
      UpdateUserRequestItem
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(userType)(_.userType(_))
        .ifSome(alexaForBusinessMetadata)(_.alexaForBusinessMetadata(_))
        .build

    def updateUserResponse(
      user: Option[User] = None
    ): UpdateUserResponse =
      UpdateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def updateUserSettingsRequest(
      accountId: Option[String] = None,
      userId: Option[String] = None,
      userSettings: Option[UserSettings] = None
    ): UpdateUserSettingsRequest =
      UpdateUserSettingsRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(userSettings)(_.userSettings(_))
        .build

    def updateVoiceConnectorGroupRequest(
      voiceConnectorGroupId: Option[String] = None,
      name: Option[String] = None,
      voiceConnectorItems: Option[List[VoiceConnectorItem]] = None
    ): UpdateVoiceConnectorGroupRequest =
      UpdateVoiceConnectorGroupRequest
        .builder
        .ifSome(voiceConnectorGroupId)(_.voiceConnectorGroupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(voiceConnectorItems)(_.voiceConnectorItems(_))
        .build

    def updateVoiceConnectorGroupResponse(
      voiceConnectorGroup: Option[VoiceConnectorGroup] = None
    ): UpdateVoiceConnectorGroupResponse =
      UpdateVoiceConnectorGroupResponse
        .builder
        .ifSome(voiceConnectorGroup)(_.voiceConnectorGroup(_))
        .build

    def updateVoiceConnectorRequest(
      voiceConnectorId: Option[String] = None,
      name: Option[String] = None,
      requireEncryption: Option[Boolean] = None
    ): UpdateVoiceConnectorRequest =
      UpdateVoiceConnectorRequest
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(name)(_.name(_))
        .ifSome(requireEncryption)(_.requireEncryption(_))
        .build

    def updateVoiceConnectorResponse(
      voiceConnector: Option[VoiceConnector] = None
    ): UpdateVoiceConnectorResponse =
      UpdateVoiceConnectorResponse
        .builder
        .ifSome(voiceConnector)(_.voiceConnector(_))
        .build

    def user(
      userId: Option[String] = None,
      accountId: Option[String] = None,
      primaryEmail: Option[String] = None,
      primaryProvisionedNumber: Option[String] = None,
      displayName: Option[String] = None,
      licenseType: Option[String] = None,
      userType: Option[String] = None,
      userRegistrationStatus: Option[String] = None,
      userInvitationStatus: Option[String] = None,
      registeredOn: Option[Iso8601Timestamp] = None,
      invitedOn: Option[Iso8601Timestamp] = None,
      alexaForBusinessMetadata: Option[AlexaForBusinessMetadata] = None,
      personalPIN: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(primaryEmail)(_.primaryEmail(_))
        .ifSome(primaryProvisionedNumber)(_.primaryProvisionedNumber(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(licenseType)(_.licenseType(_))
        .ifSome(userType)(_.userType(_))
        .ifSome(userRegistrationStatus)(_.userRegistrationStatus(_))
        .ifSome(userInvitationStatus)(_.userInvitationStatus(_))
        .ifSome(registeredOn)(_.registeredOn(_))
        .ifSome(invitedOn)(_.invitedOn(_))
        .ifSome(alexaForBusinessMetadata)(_.alexaForBusinessMetadata(_))
        .ifSome(personalPIN)(_.personalPIN(_))
        .build

    def userError(
      userId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): UserError =
      UserError
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def userSettings(
      telephony: Option[TelephonySettings] = None
    ): UserSettings =
      UserSettings
        .builder
        .ifSome(telephony)(_.telephony(_))
        .build

    def voiceConnector(
      voiceConnectorId: Option[String] = None,
      awsRegion: Option[String] = None,
      name: Option[String] = None,
      outboundHostName: Option[String] = None,
      requireEncryption: Option[Boolean] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): VoiceConnector =
      VoiceConnector
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(name)(_.name(_))
        .ifSome(outboundHostName)(_.outboundHostName(_))
        .ifSome(requireEncryption)(_.requireEncryption(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def voiceConnectorGroup(
      voiceConnectorGroupId: Option[String] = None,
      name: Option[String] = None,
      voiceConnectorItems: Option[List[VoiceConnectorItem]] = None,
      createdTimestamp: Option[Iso8601Timestamp] = None,
      updatedTimestamp: Option[Iso8601Timestamp] = None
    ): VoiceConnectorGroup =
      VoiceConnectorGroup
        .builder
        .ifSome(voiceConnectorGroupId)(_.voiceConnectorGroupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(voiceConnectorItems)(_.voiceConnectorItems(_))
        .ifSome(createdTimestamp)(_.createdTimestamp(_))
        .ifSome(updatedTimestamp)(_.updatedTimestamp(_))
        .build

    def voiceConnectorItem(
      voiceConnectorId: Option[String] = None,
      priority: Option[Int] = None
    ): VoiceConnectorItem =
      VoiceConnectorItem
        .builder
        .ifSome(voiceConnectorId)(_.voiceConnectorId(_))
        .ifSome(priority)(_.priority(_))
        .build

    def voiceConnectorSettings(
      cdrBucket: Option[String] = None
    ): VoiceConnectorSettings =
      VoiceConnectorSettings
        .builder
        .ifSome(cdrBucket)(_.cdrBucket(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
