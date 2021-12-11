package goober.hi

import goober.free.alexaforbusiness.AlexaForBusinessIO
import software.amazon.awssdk.services.alexaforbusiness.model._


object alexaforbusiness {
  import goober.free.{alexaforbusiness ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addressBook(
      addressBookArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): AddressBook =
      AddressBook
        .builder
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def addressBookData(
      addressBookArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): AddressBookData =
      AddressBookData
        .builder
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def alreadyExistsException(
      message: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def approveSkillRequest(
      skillId: Option[String] = None
    ): ApproveSkillRequest =
      ApproveSkillRequest
        .builder
        .ifSome(skillId)(_.skillId(_))
        .build

    def approveSkillResponse(

    ): ApproveSkillResponse =
      ApproveSkillResponse
        .builder

        .build

    def associateContactWithAddressBookRequest(
      contactArn: Option[String] = None,
      addressBookArn: Option[String] = None
    ): AssociateContactWithAddressBookRequest =
      AssociateContactWithAddressBookRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .build

    def associateContactWithAddressBookResponse(

    ): AssociateContactWithAddressBookResponse =
      AssociateContactWithAddressBookResponse
        .builder

        .build

    def associateDeviceWithNetworkProfileRequest(
      deviceArn: Option[String] = None,
      networkProfileArn: Option[String] = None
    ): AssociateDeviceWithNetworkProfileRequest =
      AssociateDeviceWithNetworkProfileRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .build

    def associateDeviceWithNetworkProfileResponse(

    ): AssociateDeviceWithNetworkProfileResponse =
      AssociateDeviceWithNetworkProfileResponse
        .builder

        .build

    def associateDeviceWithRoomRequest(
      deviceArn: Option[String] = None,
      roomArn: Option[String] = None
    ): AssociateDeviceWithRoomRequest =
      AssociateDeviceWithRoomRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def associateDeviceWithRoomResponse(

    ): AssociateDeviceWithRoomResponse =
      AssociateDeviceWithRoomResponse
        .builder

        .build

    def associateSkillGroupWithRoomRequest(
      skillGroupArn: Option[String] = None,
      roomArn: Option[String] = None
    ): AssociateSkillGroupWithRoomRequest =
      AssociateSkillGroupWithRoomRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def associateSkillGroupWithRoomResponse(

    ): AssociateSkillGroupWithRoomResponse =
      AssociateSkillGroupWithRoomResponse
        .builder

        .build

    def associateSkillWithSkillGroupRequest(
      skillGroupArn: Option[String] = None,
      skillId: Option[String] = None
    ): AssociateSkillWithSkillGroupRequest =
      AssociateSkillWithSkillGroupRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(skillId)(_.skillId(_))
        .build

    def associateSkillWithSkillGroupResponse(

    ): AssociateSkillWithSkillGroupResponse =
      AssociateSkillWithSkillGroupResponse
        .builder

        .build

    def associateSkillWithUsersRequest(
      skillId: Option[String] = None
    ): AssociateSkillWithUsersRequest =
      AssociateSkillWithUsersRequest
        .builder
        .ifSome(skillId)(_.skillId(_))
        .build

    def associateSkillWithUsersResponse(

    ): AssociateSkillWithUsersResponse =
      AssociateSkillWithUsersResponse
        .builder

        .build

    def audio(
      locale: Option[String] = None,
      location: Option[String] = None
    ): Audio =
      Audio
        .builder
        .ifSome(locale)(_.locale(_))
        .ifSome(location)(_.location(_))
        .build

    def businessReport(
      status: Option[String] = None,
      failureCode: Option[String] = None,
      s3Location: Option[BusinessReportS3Location] = None,
      deliveryTime: Option[BusinessReportDeliveryTime] = None,
      downloadUrl: Option[String] = None
    ): BusinessReport =
      BusinessReport
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(s3Location)(_.s3Location(_))
        .ifSome(deliveryTime)(_.deliveryTime(_))
        .ifSome(downloadUrl)(_.downloadUrl(_))
        .build

    def businessReportContentRange(
      interval: Option[String] = None
    ): BusinessReportContentRange =
      BusinessReportContentRange
        .builder
        .ifSome(interval)(_.interval(_))
        .build

    def businessReportRecurrence(
      startDate: Option[String] = None
    ): BusinessReportRecurrence =
      BusinessReportRecurrence
        .builder
        .ifSome(startDate)(_.startDate(_))
        .build

    def businessReportS3Location(
      path: Option[String] = None,
      bucketName: Option[String] = None
    ): BusinessReportS3Location =
      BusinessReportS3Location
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(bucketName)(_.bucketName(_))
        .build

    def businessReportSchedule(
      scheduleArn: Option[String] = None,
      scheduleName: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      format: Option[String] = None,
      contentRange: Option[BusinessReportContentRange] = None,
      recurrence: Option[BusinessReportRecurrence] = None,
      lastBusinessReport: Option[BusinessReport] = None
    ): BusinessReportSchedule =
      BusinessReportSchedule
        .builder
        .ifSome(scheduleArn)(_.scheduleArn(_))
        .ifSome(scheduleName)(_.scheduleName(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(format)(_.format(_))
        .ifSome(contentRange)(_.contentRange(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(lastBusinessReport)(_.lastBusinessReport(_))
        .build

    def category(
      categoryId: Option[CategoryId] = None,
      categoryName: Option[String] = None
    ): Category =
      Category
        .builder
        .ifSome(categoryId)(_.categoryId(_))
        .ifSome(categoryName)(_.categoryName(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conferencePreference(
      defaultConferenceProviderArn: Option[String] = None
    ): ConferencePreference =
      ConferencePreference
        .builder
        .ifSome(defaultConferenceProviderArn)(_.defaultConferenceProviderArn(_))
        .build

    def conferenceProvider(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      iPDialIn: Option[IPDialIn] = None,
      pSTNDialIn: Option[PSTNDialIn] = None,
      meetingSetting: Option[MeetingSetting] = None
    ): ConferenceProvider =
      ConferenceProvider
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(iPDialIn)(_.iPDialIn(_))
        .ifSome(pSTNDialIn)(_.pSTNDialIn(_))
        .ifSome(meetingSetting)(_.meetingSetting(_))
        .build

    def contact(
      contactArn: Option[String] = None,
      displayName: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      phoneNumber: Option[String] = None,
      phoneNumbers: Option[List[PhoneNumber]] = None,
      sipAddresses: Option[List[SipAddress]] = None
    ): Contact =
      Contact
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(phoneNumbers)(_.phoneNumbers(_))
        .ifSome(sipAddresses)(_.sipAddresses(_))
        .build

    def contactData(
      contactArn: Option[String] = None,
      displayName: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      phoneNumber: Option[String] = None,
      phoneNumbers: Option[List[PhoneNumber]] = None,
      sipAddresses: Option[List[SipAddress]] = None
    ): ContactData =
      ContactData
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(phoneNumbers)(_.phoneNumbers(_))
        .ifSome(sipAddresses)(_.sipAddresses(_))
        .build

    def content(
      textList: Option[List[Text]] = None,
      ssmlList: Option[List[Ssml]] = None,
      audioList: Option[List[Audio]] = None
    ): Content =
      Content
        .builder
        .ifSome(textList)(_.textList(_))
        .ifSome(ssmlList)(_.ssmlList(_))
        .ifSome(audioList)(_.audioList(_))
        .build

    def createAddressBookRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAddressBookRequest =
      CreateAddressBookRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAddressBookResponse(
      addressBookArn: Option[String] = None
    ): CreateAddressBookResponse =
      CreateAddressBookResponse
        .builder
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .build

    def createBusinessReportScheduleRequest(
      scheduleName: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      format: Option[String] = None,
      contentRange: Option[BusinessReportContentRange] = None,
      recurrence: Option[BusinessReportRecurrence] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateBusinessReportScheduleRequest =
      CreateBusinessReportScheduleRequest
        .builder
        .ifSome(scheduleName)(_.scheduleName(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(format)(_.format(_))
        .ifSome(contentRange)(_.contentRange(_))
        .ifSome(recurrence)(_.recurrence(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBusinessReportScheduleResponse(
      scheduleArn: Option[String] = None
    ): CreateBusinessReportScheduleResponse =
      CreateBusinessReportScheduleResponse
        .builder
        .ifSome(scheduleArn)(_.scheduleArn(_))
        .build

    def createConferenceProviderRequest(
      conferenceProviderName: Option[String] = None,
      conferenceProviderType: Option[String] = None,
      iPDialIn: Option[IPDialIn] = None,
      pSTNDialIn: Option[PSTNDialIn] = None,
      meetingSetting: Option[MeetingSetting] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateConferenceProviderRequest =
      CreateConferenceProviderRequest
        .builder
        .ifSome(conferenceProviderName)(_.conferenceProviderName(_))
        .ifSome(conferenceProviderType)(_.conferenceProviderType(_))
        .ifSome(iPDialIn)(_.iPDialIn(_))
        .ifSome(pSTNDialIn)(_.pSTNDialIn(_))
        .ifSome(meetingSetting)(_.meetingSetting(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConferenceProviderResponse(
      conferenceProviderArn: Option[String] = None
    ): CreateConferenceProviderResponse =
      CreateConferenceProviderResponse
        .builder
        .ifSome(conferenceProviderArn)(_.conferenceProviderArn(_))
        .build

    def createContactRequest(
      displayName: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      phoneNumber: Option[String] = None,
      phoneNumbers: Option[List[PhoneNumber]] = None,
      sipAddresses: Option[List[SipAddress]] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateContactRequest =
      CreateContactRequest
        .builder
        .ifSome(displayName)(_.displayName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(phoneNumbers)(_.phoneNumbers(_))
        .ifSome(sipAddresses)(_.sipAddresses(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createContactResponse(
      contactArn: Option[String] = None
    ): CreateContactResponse =
      CreateContactResponse
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .build

    def createEndOfMeetingReminder(
      reminderAtMinutes: Option[List[Minutes]] = None,
      reminderType: Option[String] = None,
      enabled: Option[Boolean] = None
    ): CreateEndOfMeetingReminder =
      CreateEndOfMeetingReminder
        .builder
        .ifSome(reminderAtMinutes)(_.reminderAtMinutes(_))
        .ifSome(reminderType)(_.reminderType(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def createGatewayGroupRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateGatewayGroupRequest =
      CreateGatewayGroupRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGatewayGroupResponse(
      gatewayGroupArn: Option[String] = None
    ): CreateGatewayGroupResponse =
      CreateGatewayGroupResponse
        .builder
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .build

    def createInstantBooking(
      durationInMinutes: Option[Int] = None,
      enabled: Option[Boolean] = None
    ): CreateInstantBooking =
      CreateInstantBooking
        .builder
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def createMeetingRoomConfiguration(
      roomUtilizationMetricsEnabled: Option[Boolean] = None,
      endOfMeetingReminder: Option[CreateEndOfMeetingReminder] = None,
      instantBooking: Option[CreateInstantBooking] = None,
      requireCheckIn: Option[CreateRequireCheckIn] = None
    ): CreateMeetingRoomConfiguration =
      CreateMeetingRoomConfiguration
        .builder
        .ifSome(roomUtilizationMetricsEnabled)(_.roomUtilizationMetricsEnabled(_))
        .ifSome(endOfMeetingReminder)(_.endOfMeetingReminder(_))
        .ifSome(instantBooking)(_.instantBooking(_))
        .ifSome(requireCheckIn)(_.requireCheckIn(_))
        .build

    def createNetworkProfileRequest(
      networkProfileName: Option[String] = None,
      description: Option[String] = None,
      ssid: Option[String] = None,
      securityType: Option[String] = None,
      eapMethod: Option[String] = None,
      currentPassword: Option[String] = None,
      nextPassword: Option[String] = None,
      certificateAuthorityArn: Option[String] = None,
      trustAnchors: Option[List[TrustAnchor]] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateNetworkProfileRequest =
      CreateNetworkProfileRequest
        .builder
        .ifSome(networkProfileName)(_.networkProfileName(_))
        .ifSome(description)(_.description(_))
        .ifSome(ssid)(_.ssid(_))
        .ifSome(securityType)(_.securityType(_))
        .ifSome(eapMethod)(_.eapMethod(_))
        .ifSome(currentPassword)(_.currentPassword(_))
        .ifSome(nextPassword)(_.nextPassword(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(trustAnchors)(_.trustAnchors(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createNetworkProfileResponse(
      networkProfileArn: Option[String] = None
    ): CreateNetworkProfileResponse =
      CreateNetworkProfileResponse
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .build

    def createProfileRequest(
      profileName: Option[String] = None,
      timezone: Option[String] = None,
      address: Option[String] = None,
      distanceUnit: Option[String] = None,
      temperatureUnit: Option[String] = None,
      wakeWord: Option[String] = None,
      locale: Option[String] = None,
      clientRequestToken: Option[String] = None,
      setupModeDisabled: Option[Boolean] = None,
      maxVolumeLimit: Option[Int] = None,
      pSTNEnabled: Option[Boolean] = None,
      dataRetentionOptIn: Option[Boolean] = None,
      meetingRoomConfiguration: Option[CreateMeetingRoomConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): CreateProfileRequest =
      CreateProfileRequest
        .builder
        .ifSome(profileName)(_.profileName(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(address)(_.address(_))
        .ifSome(distanceUnit)(_.distanceUnit(_))
        .ifSome(temperatureUnit)(_.temperatureUnit(_))
        .ifSome(wakeWord)(_.wakeWord(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(setupModeDisabled)(_.setupModeDisabled(_))
        .ifSome(maxVolumeLimit)(_.maxVolumeLimit(_))
        .ifSome(pSTNEnabled)(_.pSTNEnabled(_))
        .ifSome(dataRetentionOptIn)(_.dataRetentionOptIn(_))
        .ifSome(meetingRoomConfiguration)(_.meetingRoomConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProfileResponse(
      profileArn: Option[String] = None
    ): CreateProfileResponse =
      CreateProfileResponse
        .builder
        .ifSome(profileArn)(_.profileArn(_))
        .build

    def createRequireCheckIn(
      releaseAfterMinutes: Option[Int] = None,
      enabled: Option[Boolean] = None
    ): CreateRequireCheckIn =
      CreateRequireCheckIn
        .builder
        .ifSome(releaseAfterMinutes)(_.releaseAfterMinutes(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def createRoomRequest(
      roomName: Option[String] = None,
      description: Option[String] = None,
      profileArn: Option[String] = None,
      providerCalendarId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateRoomRequest =
      CreateRoomRequest
        .builder
        .ifSome(roomName)(_.roomName(_))
        .ifSome(description)(_.description(_))
        .ifSome(profileArn)(_.profileArn(_))
        .ifSome(providerCalendarId)(_.providerCalendarId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRoomResponse(
      roomArn: Option[String] = None
    ): CreateRoomResponse =
      CreateRoomResponse
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def createSkillGroupRequest(
      skillGroupName: Option[String] = None,
      description: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSkillGroupRequest =
      CreateSkillGroupRequest
        .builder
        .ifSome(skillGroupName)(_.skillGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSkillGroupResponse(
      skillGroupArn: Option[String] = None
    ): CreateSkillGroupResponse =
      CreateSkillGroupResponse
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .build

    def createUserRequest(
      userId: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      email: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(email)(_.email(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserResponse(
      userArn: Option[String] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(userArn)(_.userArn(_))
        .build

    def deleteAddressBookRequest(
      addressBookArn: Option[String] = None
    ): DeleteAddressBookRequest =
      DeleteAddressBookRequest
        .builder
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .build

    def deleteAddressBookResponse(

    ): DeleteAddressBookResponse =
      DeleteAddressBookResponse
        .builder

        .build

    def deleteBusinessReportScheduleRequest(
      scheduleArn: Option[String] = None
    ): DeleteBusinessReportScheduleRequest =
      DeleteBusinessReportScheduleRequest
        .builder
        .ifSome(scheduleArn)(_.scheduleArn(_))
        .build

    def deleteBusinessReportScheduleResponse(

    ): DeleteBusinessReportScheduleResponse =
      DeleteBusinessReportScheduleResponse
        .builder

        .build

    def deleteConferenceProviderRequest(
      conferenceProviderArn: Option[String] = None
    ): DeleteConferenceProviderRequest =
      DeleteConferenceProviderRequest
        .builder
        .ifSome(conferenceProviderArn)(_.conferenceProviderArn(_))
        .build

    def deleteConferenceProviderResponse(

    ): DeleteConferenceProviderResponse =
      DeleteConferenceProviderResponse
        .builder

        .build

    def deleteContactRequest(
      contactArn: Option[String] = None
    ): DeleteContactRequest =
      DeleteContactRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .build

    def deleteContactResponse(

    ): DeleteContactResponse =
      DeleteContactResponse
        .builder

        .build

    def deleteDeviceRequest(
      deviceArn: Option[String] = None
    ): DeleteDeviceRequest =
      DeleteDeviceRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .build

    def deleteDeviceResponse(

    ): DeleteDeviceResponse =
      DeleteDeviceResponse
        .builder

        .build

    def deleteDeviceUsageDataRequest(
      deviceArn: Option[String] = None,
      deviceUsageType: Option[String] = None
    ): DeleteDeviceUsageDataRequest =
      DeleteDeviceUsageDataRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceUsageType)(_.deviceUsageType(_))
        .build

    def deleteDeviceUsageDataResponse(

    ): DeleteDeviceUsageDataResponse =
      DeleteDeviceUsageDataResponse
        .builder

        .build

    def deleteGatewayGroupRequest(
      gatewayGroupArn: Option[String] = None
    ): DeleteGatewayGroupRequest =
      DeleteGatewayGroupRequest
        .builder
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .build

    def deleteGatewayGroupResponse(

    ): DeleteGatewayGroupResponse =
      DeleteGatewayGroupResponse
        .builder

        .build

    def deleteNetworkProfileRequest(
      networkProfileArn: Option[String] = None
    ): DeleteNetworkProfileRequest =
      DeleteNetworkProfileRequest
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .build

    def deleteNetworkProfileResponse(

    ): DeleteNetworkProfileResponse =
      DeleteNetworkProfileResponse
        .builder

        .build

    def deleteProfileRequest(
      profileArn: Option[String] = None
    ): DeleteProfileRequest =
      DeleteProfileRequest
        .builder
        .ifSome(profileArn)(_.profileArn(_))
        .build

    def deleteProfileResponse(

    ): DeleteProfileResponse =
      DeleteProfileResponse
        .builder

        .build

    def deleteRoomRequest(
      roomArn: Option[String] = None
    ): DeleteRoomRequest =
      DeleteRoomRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def deleteRoomResponse(

    ): DeleteRoomResponse =
      DeleteRoomResponse
        .builder

        .build

    def deleteRoomSkillParameterRequest(
      roomArn: Option[String] = None,
      skillId: Option[String] = None,
      parameterKey: Option[String] = None
    ): DeleteRoomSkillParameterRequest =
      DeleteRoomSkillParameterRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(skillId)(_.skillId(_))
        .ifSome(parameterKey)(_.parameterKey(_))
        .build

    def deleteRoomSkillParameterResponse(

    ): DeleteRoomSkillParameterResponse =
      DeleteRoomSkillParameterResponse
        .builder

        .build

    def deleteSkillAuthorizationRequest(
      skillId: Option[String] = None,
      roomArn: Option[String] = None
    ): DeleteSkillAuthorizationRequest =
      DeleteSkillAuthorizationRequest
        .builder
        .ifSome(skillId)(_.skillId(_))
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def deleteSkillAuthorizationResponse(

    ): DeleteSkillAuthorizationResponse =
      DeleteSkillAuthorizationResponse
        .builder

        .build

    def deleteSkillGroupRequest(
      skillGroupArn: Option[String] = None
    ): DeleteSkillGroupRequest =
      DeleteSkillGroupRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .build

    def deleteSkillGroupResponse(

    ): DeleteSkillGroupResponse =
      DeleteSkillGroupResponse
        .builder

        .build

    def deleteUserRequest(
      userArn: Option[String] = None,
      enrollmentId: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(enrollmentId)(_.enrollmentId(_))
        .build

    def deleteUserResponse(

    ): DeleteUserResponse =
      DeleteUserResponse
        .builder

        .build

    def developerInfo(
      developerName: Option[String] = None,
      privacyPolicy: Option[String] = None,
      email: Option[String] = None,
      url: Option[String] = None
    ): DeveloperInfo =
      DeveloperInfo
        .builder
        .ifSome(developerName)(_.developerName(_))
        .ifSome(privacyPolicy)(_.privacyPolicy(_))
        .ifSome(email)(_.email(_))
        .ifSome(url)(_.url(_))
        .build

    def device(
      deviceArn: Option[String] = None,
      deviceSerialNumber: Option[String] = None,
      deviceType: Option[String] = None,
      deviceName: Option[String] = None,
      softwareVersion: Option[String] = None,
      macAddress: Option[String] = None,
      roomArn: Option[String] = None,
      deviceStatus: Option[String] = None,
      deviceStatusInfo: Option[DeviceStatusInfo] = None,
      networkProfileInfo: Option[DeviceNetworkProfileInfo] = None
    ): Device =
      Device
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceSerialNumber)(_.deviceSerialNumber(_))
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(softwareVersion)(_.softwareVersion(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(deviceStatus)(_.deviceStatus(_))
        .ifSome(deviceStatusInfo)(_.deviceStatusInfo(_))
        .ifSome(networkProfileInfo)(_.networkProfileInfo(_))
        .build

    def deviceData(
      deviceArn: Option[String] = None,
      deviceSerialNumber: Option[String] = None,
      deviceType: Option[String] = None,
      deviceName: Option[String] = None,
      softwareVersion: Option[String] = None,
      macAddress: Option[String] = None,
      deviceStatus: Option[String] = None,
      networkProfileArn: Option[String] = None,
      networkProfileName: Option[String] = None,
      roomArn: Option[String] = None,
      roomName: Option[String] = None,
      deviceStatusInfo: Option[DeviceStatusInfo] = None,
      createdTime: Option[DeviceDataCreatedTime] = None
    ): DeviceData =
      DeviceData
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceSerialNumber)(_.deviceSerialNumber(_))
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(softwareVersion)(_.softwareVersion(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(deviceStatus)(_.deviceStatus(_))
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .ifSome(networkProfileName)(_.networkProfileName(_))
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(roomName)(_.roomName(_))
        .ifSome(deviceStatusInfo)(_.deviceStatusInfo(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def deviceEvent(
      `type`: Option[String] = None,
      value: Option[String] = None,
      timestamp: Option[DeviceEventTime] = None
    ): DeviceEvent =
      DeviceEvent
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def deviceNetworkProfileInfo(
      networkProfileArn: Option[String] = None,
      certificateArn: Option[String] = None,
      certificateExpirationTime: Option[CertificateTime] = None
    ): DeviceNetworkProfileInfo =
      DeviceNetworkProfileInfo
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateExpirationTime)(_.certificateExpirationTime(_))
        .build

    def deviceNotRegisteredException(
      message: Option[String] = None
    ): DeviceNotRegisteredException =
      DeviceNotRegisteredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deviceStatusDetail(
      feature: Option[String] = None,
      code: Option[String] = None
    ): DeviceStatusDetail =
      DeviceStatusDetail
        .builder
        .ifSome(feature)(_.feature(_))
        .ifSome(code)(_.code(_))
        .build

    def deviceStatusInfo(
      deviceStatusDetails: Option[List[DeviceStatusDetail]] = None,
      connectionStatus: Option[String] = None,
      connectionStatusUpdatedTime: Option[ConnectionStatusUpdatedTime] = None
    ): DeviceStatusInfo =
      DeviceStatusInfo
        .builder
        .ifSome(deviceStatusDetails)(_.deviceStatusDetails(_))
        .ifSome(connectionStatus)(_.connectionStatus(_))
        .ifSome(connectionStatusUpdatedTime)(_.connectionStatusUpdatedTime(_))
        .build

    def disassociateContactFromAddressBookRequest(
      contactArn: Option[String] = None,
      addressBookArn: Option[String] = None
    ): DisassociateContactFromAddressBookRequest =
      DisassociateContactFromAddressBookRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .build

    def disassociateContactFromAddressBookResponse(

    ): DisassociateContactFromAddressBookResponse =
      DisassociateContactFromAddressBookResponse
        .builder

        .build

    def disassociateDeviceFromRoomRequest(
      deviceArn: Option[String] = None
    ): DisassociateDeviceFromRoomRequest =
      DisassociateDeviceFromRoomRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .build

    def disassociateDeviceFromRoomResponse(

    ): DisassociateDeviceFromRoomResponse =
      DisassociateDeviceFromRoomResponse
        .builder

        .build

    def disassociateSkillFromSkillGroupRequest(
      skillGroupArn: Option[String] = None,
      skillId: Option[String] = None
    ): DisassociateSkillFromSkillGroupRequest =
      DisassociateSkillFromSkillGroupRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(skillId)(_.skillId(_))
        .build

    def disassociateSkillFromSkillGroupResponse(

    ): DisassociateSkillFromSkillGroupResponse =
      DisassociateSkillFromSkillGroupResponse
        .builder

        .build

    def disassociateSkillFromUsersRequest(
      skillId: Option[String] = None
    ): DisassociateSkillFromUsersRequest =
      DisassociateSkillFromUsersRequest
        .builder
        .ifSome(skillId)(_.skillId(_))
        .build

    def disassociateSkillFromUsersResponse(

    ): DisassociateSkillFromUsersResponse =
      DisassociateSkillFromUsersResponse
        .builder

        .build

    def disassociateSkillGroupFromRoomRequest(
      skillGroupArn: Option[String] = None,
      roomArn: Option[String] = None
    ): DisassociateSkillGroupFromRoomRequest =
      DisassociateSkillGroupFromRoomRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def disassociateSkillGroupFromRoomResponse(

    ): DisassociateSkillGroupFromRoomResponse =
      DisassociateSkillGroupFromRoomResponse
        .builder

        .build

    def endOfMeetingReminder(
      reminderAtMinutes: Option[List[Minutes]] = None,
      reminderType: Option[String] = None,
      enabled: Option[Boolean] = None
    ): EndOfMeetingReminder =
      EndOfMeetingReminder
        .builder
        .ifSome(reminderAtMinutes)(_.reminderAtMinutes(_))
        .ifSome(reminderType)(_.reminderType(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def filter(
      key: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def forgetSmartHomeAppliancesRequest(
      roomArn: Option[String] = None
    ): ForgetSmartHomeAppliancesRequest =
      ForgetSmartHomeAppliancesRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def forgetSmartHomeAppliancesResponse(

    ): ForgetSmartHomeAppliancesResponse =
      ForgetSmartHomeAppliancesResponse
        .builder

        .build

    def gateway(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      gatewayGroupArn: Option[String] = None,
      softwareVersion: Option[String] = None
    ): Gateway =
      Gateway
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .ifSome(softwareVersion)(_.softwareVersion(_))
        .build

    def gatewayGroup(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): GatewayGroup =
      GatewayGroup
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def gatewayGroupSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): GatewayGroupSummary =
      GatewayGroupSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def gatewaySummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      gatewayGroupArn: Option[String] = None,
      softwareVersion: Option[String] = None
    ): GatewaySummary =
      GatewaySummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .ifSome(softwareVersion)(_.softwareVersion(_))
        .build

    def getAddressBookRequest(
      addressBookArn: Option[String] = None
    ): GetAddressBookRequest =
      GetAddressBookRequest
        .builder
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .build

    def getAddressBookResponse(
      addressBook: Option[AddressBook] = None
    ): GetAddressBookResponse =
      GetAddressBookResponse
        .builder
        .ifSome(addressBook)(_.addressBook(_))
        .build

    def getConferencePreferenceRequest(

    ): GetConferencePreferenceRequest =
      GetConferencePreferenceRequest
        .builder

        .build

    def getConferencePreferenceResponse(
      preference: Option[ConferencePreference] = None
    ): GetConferencePreferenceResponse =
      GetConferencePreferenceResponse
        .builder
        .ifSome(preference)(_.preference(_))
        .build

    def getConferenceProviderRequest(
      conferenceProviderArn: Option[String] = None
    ): GetConferenceProviderRequest =
      GetConferenceProviderRequest
        .builder
        .ifSome(conferenceProviderArn)(_.conferenceProviderArn(_))
        .build

    def getConferenceProviderResponse(
      conferenceProvider: Option[ConferenceProvider] = None
    ): GetConferenceProviderResponse =
      GetConferenceProviderResponse
        .builder
        .ifSome(conferenceProvider)(_.conferenceProvider(_))
        .build

    def getContactRequest(
      contactArn: Option[String] = None
    ): GetContactRequest =
      GetContactRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .build

    def getContactResponse(
      contact: Option[Contact] = None
    ): GetContactResponse =
      GetContactResponse
        .builder
        .ifSome(contact)(_.contact(_))
        .build

    def getDeviceRequest(
      deviceArn: Option[String] = None
    ): GetDeviceRequest =
      GetDeviceRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .build

    def getDeviceResponse(
      device: Option[Device] = None
    ): GetDeviceResponse =
      GetDeviceResponse
        .builder
        .ifSome(device)(_.device(_))
        .build

    def getGatewayGroupRequest(
      gatewayGroupArn: Option[String] = None
    ): GetGatewayGroupRequest =
      GetGatewayGroupRequest
        .builder
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .build

    def getGatewayGroupResponse(
      gatewayGroup: Option[GatewayGroup] = None
    ): GetGatewayGroupResponse =
      GetGatewayGroupResponse
        .builder
        .ifSome(gatewayGroup)(_.gatewayGroup(_))
        .build

    def getGatewayRequest(
      gatewayArn: Option[String] = None
    ): GetGatewayRequest =
      GetGatewayRequest
        .builder
        .ifSome(gatewayArn)(_.gatewayArn(_))
        .build

    def getGatewayResponse(
      gateway: Option[Gateway] = None
    ): GetGatewayResponse =
      GetGatewayResponse
        .builder
        .ifSome(gateway)(_.gateway(_))
        .build

    def getInvitationConfigurationRequest(

    ): GetInvitationConfigurationRequest =
      GetInvitationConfigurationRequest
        .builder

        .build

    def getInvitationConfigurationResponse(
      organizationName: Option[String] = None,
      contactEmail: Option[String] = None,
      privateSkillIds: Option[List[SkillId]] = None
    ): GetInvitationConfigurationResponse =
      GetInvitationConfigurationResponse
        .builder
        .ifSome(organizationName)(_.organizationName(_))
        .ifSome(contactEmail)(_.contactEmail(_))
        .ifSome(privateSkillIds)(_.privateSkillIds(_))
        .build

    def getNetworkProfileRequest(
      networkProfileArn: Option[String] = None
    ): GetNetworkProfileRequest =
      GetNetworkProfileRequest
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .build

    def getNetworkProfileResponse(
      networkProfile: Option[NetworkProfile] = None
    ): GetNetworkProfileResponse =
      GetNetworkProfileResponse
        .builder
        .ifSome(networkProfile)(_.networkProfile(_))
        .build

    def getProfileRequest(
      profileArn: Option[String] = None
    ): GetProfileRequest =
      GetProfileRequest
        .builder
        .ifSome(profileArn)(_.profileArn(_))
        .build

    def getProfileResponse(
      profile: Option[Profile] = None
    ): GetProfileResponse =
      GetProfileResponse
        .builder
        .ifSome(profile)(_.profile(_))
        .build

    def getRoomRequest(
      roomArn: Option[String] = None
    ): GetRoomRequest =
      GetRoomRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def getRoomResponse(
      room: Option[Room] = None
    ): GetRoomResponse =
      GetRoomResponse
        .builder
        .ifSome(room)(_.room(_))
        .build

    def getRoomSkillParameterRequest(
      roomArn: Option[String] = None,
      skillId: Option[String] = None,
      parameterKey: Option[String] = None
    ): GetRoomSkillParameterRequest =
      GetRoomSkillParameterRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(skillId)(_.skillId(_))
        .ifSome(parameterKey)(_.parameterKey(_))
        .build

    def getRoomSkillParameterResponse(
      roomSkillParameter: Option[RoomSkillParameter] = None
    ): GetRoomSkillParameterResponse =
      GetRoomSkillParameterResponse
        .builder
        .ifSome(roomSkillParameter)(_.roomSkillParameter(_))
        .build

    def getSkillGroupRequest(
      skillGroupArn: Option[String] = None
    ): GetSkillGroupRequest =
      GetSkillGroupRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .build

    def getSkillGroupResponse(
      skillGroup: Option[SkillGroup] = None
    ): GetSkillGroupResponse =
      GetSkillGroupResponse
        .builder
        .ifSome(skillGroup)(_.skillGroup(_))
        .build

    def iPDialIn(
      endpoint: Option[String] = None,
      commsProtocol: Option[String] = None
    ): IPDialIn =
      IPDialIn
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(commsProtocol)(_.commsProtocol(_))
        .build

    def instantBooking(
      durationInMinutes: Option[Int] = None,
      enabled: Option[Boolean] = None
    ): InstantBooking =
      InstantBooking
        .builder
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def invalidCertificateAuthorityException(
      message: Option[String] = None
    ): InvalidCertificateAuthorityException =
      InvalidCertificateAuthorityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDeviceException(
      message: Option[String] = None
    ): InvalidDeviceException =
      InvalidDeviceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSecretsManagerResourceException(
      message: Option[String] = None
    ): InvalidSecretsManagerResourceException =
      InvalidSecretsManagerResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidServiceLinkedRoleStateException(
      message: Option[String] = None
    ): InvalidServiceLinkedRoleStateException =
      InvalidServiceLinkedRoleStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidUserStatusException(
      message: Option[String] = None
    ): InvalidUserStatusException =
      InvalidUserStatusException
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

    def listBusinessReportSchedulesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBusinessReportSchedulesRequest =
      ListBusinessReportSchedulesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBusinessReportSchedulesResponse(
      businessReportSchedules: Option[List[BusinessReportSchedule]] = None,
      nextToken: Option[String] = None
    ): ListBusinessReportSchedulesResponse =
      ListBusinessReportSchedulesResponse
        .builder
        .ifSome(businessReportSchedules)(_.businessReportSchedules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConferenceProvidersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListConferenceProvidersRequest =
      ListConferenceProvidersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listConferenceProvidersResponse(
      conferenceProviders: Option[List[ConferenceProvider]] = None,
      nextToken: Option[String] = None
    ): ListConferenceProvidersResponse =
      ListConferenceProvidersResponse
        .builder
        .ifSome(conferenceProviders)(_.conferenceProviders(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeviceEventsRequest(
      deviceArn: Option[String] = None,
      eventType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDeviceEventsRequest =
      ListDeviceEventsRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(eventType)(_.eventType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDeviceEventsResponse(
      deviceEvents: Option[List[DeviceEvent]] = None,
      nextToken: Option[String] = None
    ): ListDeviceEventsResponse =
      ListDeviceEventsResponse
        .builder
        .ifSome(deviceEvents)(_.deviceEvents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGatewayGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGatewayGroupsRequest =
      ListGatewayGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGatewayGroupsResponse(
      gatewayGroups: Option[List[GatewayGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListGatewayGroupsResponse =
      ListGatewayGroupsResponse
        .builder
        .ifSome(gatewayGroups)(_.gatewayGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGatewaysRequest(
      gatewayGroupArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGatewaysRequest =
      ListGatewaysRequest
        .builder
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGatewaysResponse(
      gateways: Option[List[GatewaySummary]] = None,
      nextToken: Option[String] = None
    ): ListGatewaysResponse =
      ListGatewaysResponse
        .builder
        .ifSome(gateways)(_.gateways(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSkillsRequest(
      skillGroupArn: Option[String] = None,
      enablementType: Option[String] = None,
      skillType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSkillsRequest =
      ListSkillsRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(enablementType)(_.enablementType(_))
        .ifSome(skillType)(_.skillType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSkillsResponse(
      skillSummaries: Option[List[SkillSummary]] = None,
      nextToken: Option[String] = None
    ): ListSkillsResponse =
      ListSkillsResponse
        .builder
        .ifSome(skillSummaries)(_.skillSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSkillsStoreCategoriesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSkillsStoreCategoriesRequest =
      ListSkillsStoreCategoriesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSkillsStoreCategoriesResponse(
      categoryList: Option[List[Category]] = None,
      nextToken: Option[String] = None
    ): ListSkillsStoreCategoriesResponse =
      ListSkillsStoreCategoriesResponse
        .builder
        .ifSome(categoryList)(_.categoryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSkillsStoreSkillsByCategoryRequest(
      categoryId: Option[CategoryId] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSkillsStoreSkillsByCategoryRequest =
      ListSkillsStoreSkillsByCategoryRequest
        .builder
        .ifSome(categoryId)(_.categoryId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSkillsStoreSkillsByCategoryResponse(
      skillsStoreSkills: Option[List[SkillsStoreSkill]] = None,
      nextToken: Option[String] = None
    ): ListSkillsStoreSkillsByCategoryResponse =
      ListSkillsStoreSkillsByCategoryResponse
        .builder
        .ifSome(skillsStoreSkills)(_.skillsStoreSkills(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSmartHomeAppliancesRequest(
      roomArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSmartHomeAppliancesRequest =
      ListSmartHomeAppliancesRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSmartHomeAppliancesResponse(
      smartHomeAppliances: Option[List[SmartHomeAppliance]] = None,
      nextToken: Option[String] = None
    ): ListSmartHomeAppliancesResponse =
      ListSmartHomeAppliancesResponse
        .builder
        .ifSome(smartHomeAppliances)(_.smartHomeAppliances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def meetingRoomConfiguration(
      roomUtilizationMetricsEnabled: Option[Boolean] = None,
      endOfMeetingReminder: Option[EndOfMeetingReminder] = None,
      instantBooking: Option[InstantBooking] = None,
      requireCheckIn: Option[RequireCheckIn] = None
    ): MeetingRoomConfiguration =
      MeetingRoomConfiguration
        .builder
        .ifSome(roomUtilizationMetricsEnabled)(_.roomUtilizationMetricsEnabled(_))
        .ifSome(endOfMeetingReminder)(_.endOfMeetingReminder(_))
        .ifSome(instantBooking)(_.instantBooking(_))
        .ifSome(requireCheckIn)(_.requireCheckIn(_))
        .build

    def meetingSetting(
      requirePin: Option[String] = None
    ): MeetingSetting =
      MeetingSetting
        .builder
        .ifSome(requirePin)(_.requirePin(_))
        .build

    def nameInUseException(
      message: Option[String] = None
    ): NameInUseException =
      NameInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def networkProfile(
      networkProfileArn: Option[String] = None,
      networkProfileName: Option[String] = None,
      description: Option[String] = None,
      ssid: Option[String] = None,
      securityType: Option[String] = None,
      eapMethod: Option[String] = None,
      currentPassword: Option[String] = None,
      nextPassword: Option[String] = None,
      certificateAuthorityArn: Option[String] = None,
      trustAnchors: Option[List[TrustAnchor]] = None
    ): NetworkProfile =
      NetworkProfile
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .ifSome(networkProfileName)(_.networkProfileName(_))
        .ifSome(description)(_.description(_))
        .ifSome(ssid)(_.ssid(_))
        .ifSome(securityType)(_.securityType(_))
        .ifSome(eapMethod)(_.eapMethod(_))
        .ifSome(currentPassword)(_.currentPassword(_))
        .ifSome(nextPassword)(_.nextPassword(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(trustAnchors)(_.trustAnchors(_))
        .build

    def networkProfileData(
      networkProfileArn: Option[String] = None,
      networkProfileName: Option[String] = None,
      description: Option[String] = None,
      ssid: Option[String] = None,
      securityType: Option[String] = None,
      eapMethod: Option[String] = None,
      certificateAuthorityArn: Option[String] = None
    ): NetworkProfileData =
      NetworkProfileData
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .ifSome(networkProfileName)(_.networkProfileName(_))
        .ifSome(description)(_.description(_))
        .ifSome(ssid)(_.ssid(_))
        .ifSome(securityType)(_.securityType(_))
        .ifSome(eapMethod)(_.eapMethod(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pSTNDialIn(
      countryCode: Option[String] = None,
      phoneNumber: Option[String] = None,
      oneClickIdDelay: Option[String] = None,
      oneClickPinDelay: Option[String] = None
    ): PSTNDialIn =
      PSTNDialIn
        .builder
        .ifSome(countryCode)(_.countryCode(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(oneClickIdDelay)(_.oneClickIdDelay(_))
        .ifSome(oneClickPinDelay)(_.oneClickPinDelay(_))
        .build

    def phoneNumber(
      number: Option[String] = None,
      `type`: Option[String] = None
    ): PhoneNumber =
      PhoneNumber
        .builder
        .ifSome(number)(_.number(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def profile(
      profileArn: Option[String] = None,
      profileName: Option[String] = None,
      isDefault: Option[Boolean] = None,
      address: Option[String] = None,
      timezone: Option[String] = None,
      distanceUnit: Option[String] = None,
      temperatureUnit: Option[String] = None,
      wakeWord: Option[String] = None,
      locale: Option[String] = None,
      setupModeDisabled: Option[Boolean] = None,
      maxVolumeLimit: Option[Int] = None,
      pSTNEnabled: Option[Boolean] = None,
      dataRetentionOptIn: Option[Boolean] = None,
      addressBookArn: Option[String] = None,
      meetingRoomConfiguration: Option[MeetingRoomConfiguration] = None
    ): Profile =
      Profile
        .builder
        .ifSome(profileArn)(_.profileArn(_))
        .ifSome(profileName)(_.profileName(_))
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(address)(_.address(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(distanceUnit)(_.distanceUnit(_))
        .ifSome(temperatureUnit)(_.temperatureUnit(_))
        .ifSome(wakeWord)(_.wakeWord(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(setupModeDisabled)(_.setupModeDisabled(_))
        .ifSome(maxVolumeLimit)(_.maxVolumeLimit(_))
        .ifSome(pSTNEnabled)(_.pSTNEnabled(_))
        .ifSome(dataRetentionOptIn)(_.dataRetentionOptIn(_))
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .ifSome(meetingRoomConfiguration)(_.meetingRoomConfiguration(_))
        .build

    def profileData(
      profileArn: Option[String] = None,
      profileName: Option[String] = None,
      isDefault: Option[Boolean] = None,
      address: Option[String] = None,
      timezone: Option[String] = None,
      distanceUnit: Option[String] = None,
      temperatureUnit: Option[String] = None,
      wakeWord: Option[String] = None,
      locale: Option[String] = None
    ): ProfileData =
      ProfileData
        .builder
        .ifSome(profileArn)(_.profileArn(_))
        .ifSome(profileName)(_.profileName(_))
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(address)(_.address(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(distanceUnit)(_.distanceUnit(_))
        .ifSome(temperatureUnit)(_.temperatureUnit(_))
        .ifSome(wakeWord)(_.wakeWord(_))
        .ifSome(locale)(_.locale(_))
        .build

    def putConferencePreferenceRequest(
      conferencePreference: Option[ConferencePreference] = None
    ): PutConferencePreferenceRequest =
      PutConferencePreferenceRequest
        .builder
        .ifSome(conferencePreference)(_.conferencePreference(_))
        .build

    def putConferencePreferenceResponse(

    ): PutConferencePreferenceResponse =
      PutConferencePreferenceResponse
        .builder

        .build

    def putInvitationConfigurationRequest(
      organizationName: Option[String] = None,
      contactEmail: Option[String] = None,
      privateSkillIds: Option[List[SkillId]] = None
    ): PutInvitationConfigurationRequest =
      PutInvitationConfigurationRequest
        .builder
        .ifSome(organizationName)(_.organizationName(_))
        .ifSome(contactEmail)(_.contactEmail(_))
        .ifSome(privateSkillIds)(_.privateSkillIds(_))
        .build

    def putInvitationConfigurationResponse(

    ): PutInvitationConfigurationResponse =
      PutInvitationConfigurationResponse
        .builder

        .build

    def putRoomSkillParameterRequest(
      roomArn: Option[String] = None,
      skillId: Option[String] = None,
      roomSkillParameter: Option[RoomSkillParameter] = None
    ): PutRoomSkillParameterRequest =
      PutRoomSkillParameterRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(skillId)(_.skillId(_))
        .ifSome(roomSkillParameter)(_.roomSkillParameter(_))
        .build

    def putRoomSkillParameterResponse(

    ): PutRoomSkillParameterResponse =
      PutRoomSkillParameterResponse
        .builder

        .build

    def putSkillAuthorizationRequest(
      authorizationResult: Option[AuthorizationResult] = None,
      skillId: Option[String] = None,
      roomArn: Option[String] = None
    ): PutSkillAuthorizationRequest =
      PutSkillAuthorizationRequest
        .builder
        .ifSome(authorizationResult)(_.authorizationResult(_))
        .ifSome(skillId)(_.skillId(_))
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def putSkillAuthorizationResponse(

    ): PutSkillAuthorizationResponse =
      PutSkillAuthorizationResponse
        .builder

        .build

    def registerAVSDeviceRequest(
      clientId: Option[String] = None,
      userCode: Option[String] = None,
      productId: Option[String] = None,
      deviceSerialNumber: Option[String] = None,
      amazonId: Option[String] = None,
      roomArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): RegisterAVSDeviceRequest =
      RegisterAVSDeviceRequest
        .builder
        .ifSome(clientId)(_.clientId(_))
        .ifSome(userCode)(_.userCode(_))
        .ifSome(productId)(_.productId(_))
        .ifSome(deviceSerialNumber)(_.deviceSerialNumber(_))
        .ifSome(amazonId)(_.amazonId(_))
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def registerAVSDeviceResponse(
      deviceArn: Option[String] = None
    ): RegisterAVSDeviceResponse =
      RegisterAVSDeviceResponse
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .build

    def rejectSkillRequest(
      skillId: Option[String] = None
    ): RejectSkillRequest =
      RejectSkillRequest
        .builder
        .ifSome(skillId)(_.skillId(_))
        .build

    def rejectSkillResponse(

    ): RejectSkillResponse =
      RejectSkillResponse
        .builder

        .build

    def requireCheckIn(
      releaseAfterMinutes: Option[Int] = None,
      enabled: Option[Boolean] = None
    ): RequireCheckIn =
      RequireCheckIn
        .builder
        .ifSome(releaseAfterMinutes)(_.releaseAfterMinutes(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def resolveRoomRequest(
      userId: Option[String] = None,
      skillId: Option[String] = None
    ): ResolveRoomRequest =
      ResolveRoomRequest
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(skillId)(_.skillId(_))
        .build

    def resolveRoomResponse(
      roomArn: Option[String] = None,
      roomName: Option[String] = None,
      roomSkillParameters: Option[List[RoomSkillParameter]] = None
    ): ResolveRoomResponse =
      ResolveRoomResponse
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(roomName)(_.roomName(_))
        .ifSome(roomSkillParameters)(_.roomSkillParameters(_))
        .build

    def resourceAssociatedException(
      message: Option[String] = None
    ): ResourceAssociatedException =
      ResourceAssociatedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseException(
      message: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def revokeInvitationRequest(
      userArn: Option[String] = None,
      enrollmentId: Option[String] = None
    ): RevokeInvitationRequest =
      RevokeInvitationRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(enrollmentId)(_.enrollmentId(_))
        .build

    def revokeInvitationResponse(

    ): RevokeInvitationResponse =
      RevokeInvitationResponse
        .builder

        .build

    def room(
      roomArn: Option[String] = None,
      roomName: Option[String] = None,
      description: Option[String] = None,
      providerCalendarId: Option[String] = None,
      profileArn: Option[String] = None
    ): Room =
      Room
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(roomName)(_.roomName(_))
        .ifSome(description)(_.description(_))
        .ifSome(providerCalendarId)(_.providerCalendarId(_))
        .ifSome(profileArn)(_.profileArn(_))
        .build

    def roomData(
      roomArn: Option[String] = None,
      roomName: Option[String] = None,
      description: Option[String] = None,
      providerCalendarId: Option[String] = None,
      profileArn: Option[String] = None,
      profileName: Option[String] = None
    ): RoomData =
      RoomData
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(roomName)(_.roomName(_))
        .ifSome(description)(_.description(_))
        .ifSome(providerCalendarId)(_.providerCalendarId(_))
        .ifSome(profileArn)(_.profileArn(_))
        .ifSome(profileName)(_.profileName(_))
        .build

    def roomSkillParameter(
      parameterKey: Option[String] = None,
      parameterValue: Option[String] = None
    ): RoomSkillParameter =
      RoomSkillParameter
        .builder
        .ifSome(parameterKey)(_.parameterKey(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .build

    def searchAddressBooksRequest(
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchAddressBooksRequest =
      SearchAddressBooksRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchAddressBooksResponse(
      addressBooks: Option[List[AddressBookData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchAddressBooksResponse =
      SearchAddressBooksResponse
        .builder
        .ifSome(addressBooks)(_.addressBooks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchContactsRequest(
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): SearchContactsRequest =
      SearchContactsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def searchContactsResponse(
      contacts: Option[List[ContactData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchContactsResponse =
      SearchContactsResponse
        .builder
        .ifSome(contacts)(_.contacts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchDevicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None
    ): SearchDevicesRequest =
      SearchDevicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchDevicesResponse(
      devices: Option[List[DeviceData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchDevicesResponse =
      SearchDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchNetworkProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None
    ): SearchNetworkProfilesRequest =
      SearchNetworkProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchNetworkProfilesResponse(
      networkProfiles: Option[List[NetworkProfileData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchNetworkProfilesResponse =
      SearchNetworkProfilesResponse
        .builder
        .ifSome(networkProfiles)(_.networkProfiles(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None
    ): SearchProfilesRequest =
      SearchProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchProfilesResponse(
      profiles: Option[List[ProfileData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchProfilesResponse =
      SearchProfilesResponse
        .builder
        .ifSome(profiles)(_.profiles(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchRoomsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None
    ): SearchRoomsRequest =
      SearchRoomsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchRoomsResponse(
      rooms: Option[List[RoomData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchRoomsResponse =
      SearchRoomsResponse
        .builder
        .ifSome(rooms)(_.rooms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchSkillGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None
    ): SearchSkillGroupsRequest =
      SearchSkillGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchSkillGroupsResponse(
      skillGroups: Option[List[SkillGroupData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchSkillGroupsResponse =
      SearchSkillGroupsResponse
        .builder
        .ifSome(skillGroups)(_.skillGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def searchUsersRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None,
      sortCriteria: Option[List[Sort]] = None
    ): SearchUsersRequest =
      SearchUsersRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortCriteria)(_.sortCriteria(_))
        .build

    def searchUsersResponse(
      users: Option[List[UserData]] = None,
      nextToken: Option[String] = None,
      totalCount: Option[Int] = None
    ): SearchUsersResponse =
      SearchUsersResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(totalCount)(_.totalCount(_))
        .build

    def sendAnnouncementRequest(
      roomFilters: Option[List[Filter]] = None,
      content: Option[Content] = None,
      timeToLiveInSeconds: Option[Int] = None,
      clientRequestToken: Option[String] = None
    ): SendAnnouncementRequest =
      SendAnnouncementRequest
        .builder
        .ifSome(roomFilters)(_.roomFilters(_))
        .ifSome(content)(_.content(_))
        .ifSome(timeToLiveInSeconds)(_.timeToLiveInSeconds(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def sendAnnouncementResponse(
      announcementArn: Option[String] = None
    ): SendAnnouncementResponse =
      SendAnnouncementResponse
        .builder
        .ifSome(announcementArn)(_.announcementArn(_))
        .build

    def sendInvitationRequest(
      userArn: Option[String] = None
    ): SendInvitationRequest =
      SendInvitationRequest
        .builder
        .ifSome(userArn)(_.userArn(_))
        .build

    def sendInvitationResponse(

    ): SendInvitationResponse =
      SendInvitationResponse
        .builder

        .build

    def sipAddress(
      uri: Option[String] = None,
      `type`: Option[String] = None
    ): SipAddress =
      SipAddress
        .builder
        .ifSome(uri)(_.uri(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def skillDetails(
      productDescription: Option[String] = None,
      invocationPhrase: Option[String] = None,
      releaseDate: Option[String] = None,
      endUserLicenseAgreement: Option[String] = None,
      genericKeywords: Option[List[GenericKeyword]] = None,
      bulletPoints: Option[List[BulletPoint]] = None,
      newInThisVersionBulletPoints: Option[List[BulletPoint]] = None,
      skillTypes: Option[List[SkillStoreType]] = None,
      reviews: Option[Reviews] = None,
      developerInfo: Option[DeveloperInfo] = None
    ): SkillDetails =
      SkillDetails
        .builder
        .ifSome(productDescription)(_.productDescription(_))
        .ifSome(invocationPhrase)(_.invocationPhrase(_))
        .ifSome(releaseDate)(_.releaseDate(_))
        .ifSome(endUserLicenseAgreement)(_.endUserLicenseAgreement(_))
        .ifSome(genericKeywords)(_.genericKeywords(_))
        .ifSome(bulletPoints)(_.bulletPoints(_))
        .ifSome(newInThisVersionBulletPoints)(_.newInThisVersionBulletPoints(_))
        .ifSome(skillTypes)(_.skillTypes(_))
        .ifSome(reviews)(_.reviews(_))
        .ifSome(developerInfo)(_.developerInfo(_))
        .build

    def skillGroup(
      skillGroupArn: Option[String] = None,
      skillGroupName: Option[String] = None,
      description: Option[String] = None
    ): SkillGroup =
      SkillGroup
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(skillGroupName)(_.skillGroupName(_))
        .ifSome(description)(_.description(_))
        .build

    def skillGroupData(
      skillGroupArn: Option[String] = None,
      skillGroupName: Option[String] = None,
      description: Option[String] = None
    ): SkillGroupData =
      SkillGroupData
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(skillGroupName)(_.skillGroupName(_))
        .ifSome(description)(_.description(_))
        .build

    def skillNotLinkedException(
      message: Option[String] = None
    ): SkillNotLinkedException =
      SkillNotLinkedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def skillSummary(
      skillId: Option[String] = None,
      skillName: Option[String] = None,
      supportsLinking: Option[Boolean] = None,
      enablementType: Option[String] = None,
      skillType: Option[String] = None
    ): SkillSummary =
      SkillSummary
        .builder
        .ifSome(skillId)(_.skillId(_))
        .ifSome(skillName)(_.skillName(_))
        .ifSome(supportsLinking)(_.supportsLinking(_))
        .ifSome(enablementType)(_.enablementType(_))
        .ifSome(skillType)(_.skillType(_))
        .build

    def skillsStoreSkill(
      skillId: Option[String] = None,
      skillName: Option[String] = None,
      shortDescription: Option[String] = None,
      iconUrl: Option[String] = None,
      sampleUtterances: Option[List[Utterance]] = None,
      skillDetails: Option[SkillDetails] = None,
      supportsLinking: Option[Boolean] = None
    ): SkillsStoreSkill =
      SkillsStoreSkill
        .builder
        .ifSome(skillId)(_.skillId(_))
        .ifSome(skillName)(_.skillName(_))
        .ifSome(shortDescription)(_.shortDescription(_))
        .ifSome(iconUrl)(_.iconUrl(_))
        .ifSome(sampleUtterances)(_.sampleUtterances(_))
        .ifSome(skillDetails)(_.skillDetails(_))
        .ifSome(supportsLinking)(_.supportsLinking(_))
        .build

    def smartHomeAppliance(
      friendlyName: Option[String] = None,
      description: Option[String] = None,
      manufacturerName: Option[String] = None
    ): SmartHomeAppliance =
      SmartHomeAppliance
        .builder
        .ifSome(friendlyName)(_.friendlyName(_))
        .ifSome(description)(_.description(_))
        .ifSome(manufacturerName)(_.manufacturerName(_))
        .build

    def sort(
      key: Option[String] = None,
      value: Option[String] = None
    ): Sort =
      Sort
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def ssml(
      locale: Option[String] = None,
      value: Option[String] = None
    ): Ssml =
      Ssml
        .builder
        .ifSome(locale)(_.locale(_))
        .ifSome(value)(_.value(_))
        .build

    def startDeviceSyncRequest(
      roomArn: Option[String] = None,
      deviceArn: Option[String] = None,
      features: Option[List[Feature]] = None
    ): StartDeviceSyncRequest =
      StartDeviceSyncRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(features)(_.features(_))
        .build

    def startDeviceSyncResponse(

    ): StartDeviceSyncResponse =
      StartDeviceSyncResponse
        .builder

        .build

    def startSmartHomeApplianceDiscoveryRequest(
      roomArn: Option[String] = None
    ): StartSmartHomeApplianceDiscoveryRequest =
      StartSmartHomeApplianceDiscoveryRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .build

    def startSmartHomeApplianceDiscoveryResponse(

    ): StartSmartHomeApplianceDiscoveryResponse =
      StartSmartHomeApplianceDiscoveryResponse
        .builder

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
      arn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def text(
      locale: Option[String] = None,
      value: Option[String] = None
    ): Text =
      Text
        .builder
        .ifSome(locale)(_.locale(_))
        .ifSome(value)(_.value(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      arn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateAddressBookRequest(
      addressBookArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateAddressBookRequest =
      UpdateAddressBookRequest
        .builder
        .ifSome(addressBookArn)(_.addressBookArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateAddressBookResponse(

    ): UpdateAddressBookResponse =
      UpdateAddressBookResponse
        .builder

        .build

    def updateBusinessReportScheduleRequest(
      scheduleArn: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None,
      format: Option[String] = None,
      scheduleName: Option[String] = None,
      recurrence: Option[BusinessReportRecurrence] = None
    ): UpdateBusinessReportScheduleRequest =
      UpdateBusinessReportScheduleRequest
        .builder
        .ifSome(scheduleArn)(_.scheduleArn(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .ifSome(format)(_.format(_))
        .ifSome(scheduleName)(_.scheduleName(_))
        .ifSome(recurrence)(_.recurrence(_))
        .build

    def updateBusinessReportScheduleResponse(

    ): UpdateBusinessReportScheduleResponse =
      UpdateBusinessReportScheduleResponse
        .builder

        .build

    def updateConferenceProviderRequest(
      conferenceProviderArn: Option[String] = None,
      conferenceProviderType: Option[String] = None,
      iPDialIn: Option[IPDialIn] = None,
      pSTNDialIn: Option[PSTNDialIn] = None,
      meetingSetting: Option[MeetingSetting] = None
    ): UpdateConferenceProviderRequest =
      UpdateConferenceProviderRequest
        .builder
        .ifSome(conferenceProviderArn)(_.conferenceProviderArn(_))
        .ifSome(conferenceProviderType)(_.conferenceProviderType(_))
        .ifSome(iPDialIn)(_.iPDialIn(_))
        .ifSome(pSTNDialIn)(_.pSTNDialIn(_))
        .ifSome(meetingSetting)(_.meetingSetting(_))
        .build

    def updateConferenceProviderResponse(

    ): UpdateConferenceProviderResponse =
      UpdateConferenceProviderResponse
        .builder

        .build

    def updateContactRequest(
      contactArn: Option[String] = None,
      displayName: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      phoneNumber: Option[String] = None,
      phoneNumbers: Option[List[PhoneNumber]] = None,
      sipAddresses: Option[List[SipAddress]] = None
    ): UpdateContactRequest =
      UpdateContactRequest
        .builder
        .ifSome(contactArn)(_.contactArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(phoneNumber)(_.phoneNumber(_))
        .ifSome(phoneNumbers)(_.phoneNumbers(_))
        .ifSome(sipAddresses)(_.sipAddresses(_))
        .build

    def updateContactResponse(

    ): UpdateContactResponse =
      UpdateContactResponse
        .builder

        .build

    def updateDeviceRequest(
      deviceArn: Option[String] = None,
      deviceName: Option[String] = None
    ): UpdateDeviceRequest =
      UpdateDeviceRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceName)(_.deviceName(_))
        .build

    def updateDeviceResponse(

    ): UpdateDeviceResponse =
      UpdateDeviceResponse
        .builder

        .build

    def updateEndOfMeetingReminder(
      reminderAtMinutes: Option[List[Minutes]] = None,
      reminderType: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UpdateEndOfMeetingReminder =
      UpdateEndOfMeetingReminder
        .builder
        .ifSome(reminderAtMinutes)(_.reminderAtMinutes(_))
        .ifSome(reminderType)(_.reminderType(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateGatewayGroupRequest(
      gatewayGroupArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): UpdateGatewayGroupRequest =
      UpdateGatewayGroupRequest
        .builder
        .ifSome(gatewayGroupArn)(_.gatewayGroupArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def updateGatewayGroupResponse(

    ): UpdateGatewayGroupResponse =
      UpdateGatewayGroupResponse
        .builder

        .build

    def updateGatewayRequest(
      gatewayArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      softwareVersion: Option[String] = None
    ): UpdateGatewayRequest =
      UpdateGatewayRequest
        .builder
        .ifSome(gatewayArn)(_.gatewayArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(softwareVersion)(_.softwareVersion(_))
        .build

    def updateGatewayResponse(

    ): UpdateGatewayResponse =
      UpdateGatewayResponse
        .builder

        .build

    def updateInstantBooking(
      durationInMinutes: Option[Int] = None,
      enabled: Option[Boolean] = None
    ): UpdateInstantBooking =
      UpdateInstantBooking
        .builder
        .ifSome(durationInMinutes)(_.durationInMinutes(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateMeetingRoomConfiguration(
      roomUtilizationMetricsEnabled: Option[Boolean] = None,
      endOfMeetingReminder: Option[UpdateEndOfMeetingReminder] = None,
      instantBooking: Option[UpdateInstantBooking] = None,
      requireCheckIn: Option[UpdateRequireCheckIn] = None
    ): UpdateMeetingRoomConfiguration =
      UpdateMeetingRoomConfiguration
        .builder
        .ifSome(roomUtilizationMetricsEnabled)(_.roomUtilizationMetricsEnabled(_))
        .ifSome(endOfMeetingReminder)(_.endOfMeetingReminder(_))
        .ifSome(instantBooking)(_.instantBooking(_))
        .ifSome(requireCheckIn)(_.requireCheckIn(_))
        .build

    def updateNetworkProfileRequest(
      networkProfileArn: Option[String] = None,
      networkProfileName: Option[String] = None,
      description: Option[String] = None,
      currentPassword: Option[String] = None,
      nextPassword: Option[String] = None,
      certificateAuthorityArn: Option[String] = None,
      trustAnchors: Option[List[TrustAnchor]] = None
    ): UpdateNetworkProfileRequest =
      UpdateNetworkProfileRequest
        .builder
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .ifSome(networkProfileName)(_.networkProfileName(_))
        .ifSome(description)(_.description(_))
        .ifSome(currentPassword)(_.currentPassword(_))
        .ifSome(nextPassword)(_.nextPassword(_))
        .ifSome(certificateAuthorityArn)(_.certificateAuthorityArn(_))
        .ifSome(trustAnchors)(_.trustAnchors(_))
        .build

    def updateNetworkProfileResponse(

    ): UpdateNetworkProfileResponse =
      UpdateNetworkProfileResponse
        .builder

        .build

    def updateProfileRequest(
      profileArn: Option[String] = None,
      profileName: Option[String] = None,
      isDefault: Option[Boolean] = None,
      timezone: Option[String] = None,
      address: Option[String] = None,
      distanceUnit: Option[String] = None,
      temperatureUnit: Option[String] = None,
      wakeWord: Option[String] = None,
      locale: Option[String] = None,
      setupModeDisabled: Option[Boolean] = None,
      maxVolumeLimit: Option[Int] = None,
      pSTNEnabled: Option[Boolean] = None,
      dataRetentionOptIn: Option[Boolean] = None,
      meetingRoomConfiguration: Option[UpdateMeetingRoomConfiguration] = None
    ): UpdateProfileRequest =
      UpdateProfileRequest
        .builder
        .ifSome(profileArn)(_.profileArn(_))
        .ifSome(profileName)(_.profileName(_))
        .ifSome(isDefault)(_.isDefault(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(address)(_.address(_))
        .ifSome(distanceUnit)(_.distanceUnit(_))
        .ifSome(temperatureUnit)(_.temperatureUnit(_))
        .ifSome(wakeWord)(_.wakeWord(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(setupModeDisabled)(_.setupModeDisabled(_))
        .ifSome(maxVolumeLimit)(_.maxVolumeLimit(_))
        .ifSome(pSTNEnabled)(_.pSTNEnabled(_))
        .ifSome(dataRetentionOptIn)(_.dataRetentionOptIn(_))
        .ifSome(meetingRoomConfiguration)(_.meetingRoomConfiguration(_))
        .build

    def updateProfileResponse(

    ): UpdateProfileResponse =
      UpdateProfileResponse
        .builder

        .build

    def updateRequireCheckIn(
      releaseAfterMinutes: Option[Int] = None,
      enabled: Option[Boolean] = None
    ): UpdateRequireCheckIn =
      UpdateRequireCheckIn
        .builder
        .ifSome(releaseAfterMinutes)(_.releaseAfterMinutes(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateRoomRequest(
      roomArn: Option[String] = None,
      roomName: Option[String] = None,
      description: Option[String] = None,
      providerCalendarId: Option[String] = None,
      profileArn: Option[String] = None
    ): UpdateRoomRequest =
      UpdateRoomRequest
        .builder
        .ifSome(roomArn)(_.roomArn(_))
        .ifSome(roomName)(_.roomName(_))
        .ifSome(description)(_.description(_))
        .ifSome(providerCalendarId)(_.providerCalendarId(_))
        .ifSome(profileArn)(_.profileArn(_))
        .build

    def updateRoomResponse(

    ): UpdateRoomResponse =
      UpdateRoomResponse
        .builder

        .build

    def updateSkillGroupRequest(
      skillGroupArn: Option[String] = None,
      skillGroupName: Option[String] = None,
      description: Option[String] = None
    ): UpdateSkillGroupRequest =
      UpdateSkillGroupRequest
        .builder
        .ifSome(skillGroupArn)(_.skillGroupArn(_))
        .ifSome(skillGroupName)(_.skillGroupName(_))
        .ifSome(description)(_.description(_))
        .build

    def updateSkillGroupResponse(

    ): UpdateSkillGroupResponse =
      UpdateSkillGroupResponse
        .builder

        .build

    def userData(
      userArn: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      email: Option[String] = None,
      enrollmentStatus: Option[String] = None,
      enrollmentId: Option[String] = None
    ): UserData =
      UserData
        .builder
        .ifSome(userArn)(_.userArn(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(email)(_.email(_))
        .ifSome(enrollmentStatus)(_.enrollmentStatus(_))
        .ifSome(enrollmentId)(_.enrollmentId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
