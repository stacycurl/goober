package goober.hi

import goober.free.workmail.WorkMailIO
import software.amazon.awssdk.services.workmail.model._


object workmail {
  import goober.free.{workmail ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessControlRule(
      name: Option[String] = None,
      effect: Option[String] = None,
      description: Option[String] = None,
      ipRanges: Option[List[IpRange]] = None,
      notIpRanges: Option[List[IpRange]] = None,
      actions: Option[List[AccessControlRuleAction]] = None,
      notActions: Option[List[AccessControlRuleAction]] = None,
      userIds: Option[List[WorkMailIdentifier]] = None,
      notUserIds: Option[List[WorkMailIdentifier]] = None,
      dateCreated: Option[Timestamp] = None,
      dateModified: Option[Timestamp] = None
    ): AccessControlRule =
      AccessControlRule
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(effect)(_.effect(_))
        .ifSome(description)(_.description(_))
        .ifSome(ipRanges)(_.ipRanges(_))
        .ifSome(notIpRanges)(_.notIpRanges(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(notActions)(_.notActions(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(notUserIds)(_.notUserIds(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateModified)(_.dateModified(_))
        .build

    def associateDelegateToResourceRequest(
      organizationId: Option[String] = None,
      resourceId: Option[String] = None,
      entityId: Option[String] = None
    ): AssociateDelegateToResourceRequest =
      AssociateDelegateToResourceRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(entityId)(_.entityId(_))
        .build

    def associateDelegateToResourceResponse(

    ): AssociateDelegateToResourceResponse =
      AssociateDelegateToResourceResponse
        .builder

        .build

    def associateMemberToGroupRequest(
      organizationId: Option[String] = None,
      groupId: Option[String] = None,
      memberId: Option[String] = None
    ): AssociateMemberToGroupRequest =
      AssociateMemberToGroupRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def associateMemberToGroupResponse(

    ): AssociateMemberToGroupResponse =
      AssociateMemberToGroupResponse
        .builder

        .build

    def bookingOptions(
      autoAcceptRequests: Option[Boolean] = None,
      autoDeclineRecurringRequests: Option[Boolean] = None,
      autoDeclineConflictingRequests: Option[Boolean] = None
    ): BookingOptions =
      BookingOptions
        .builder
        .ifSome(autoAcceptRequests)(_.autoAcceptRequests(_))
        .ifSome(autoDeclineRecurringRequests)(_.autoDeclineRecurringRequests(_))
        .ifSome(autoDeclineConflictingRequests)(_.autoDeclineConflictingRequests(_))
        .build

    def cancelMailboxExportJobRequest(
      clientToken: Option[String] = None,
      jobId: Option[String] = None,
      organizationId: Option[String] = None
    ): CancelMailboxExportJobRequest =
      CancelMailboxExportJobRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def cancelMailboxExportJobResponse(

    ): CancelMailboxExportJobResponse =
      CancelMailboxExportJobResponse
        .builder

        .build

    def createAliasRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      alias: Option[String] = None
    ): CreateAliasRequest =
      CreateAliasRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(alias)(_.alias(_))
        .build

    def createAliasResponse(

    ): CreateAliasResponse =
      CreateAliasResponse
        .builder

        .build

    def createGroupRequest(
      organizationId: Option[String] = None,
      name: Option[String] = None
    ): CreateGroupRequest =
      CreateGroupRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(name)(_.name(_))
        .build

    def createGroupResponse(
      groupId: Option[String] = None
    ): CreateGroupResponse =
      CreateGroupResponse
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def createMobileDeviceAccessRuleRequest(
      organizationId: Option[String] = None,
      clientToken: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      effect: Option[String] = None,
      deviceTypes: Option[List[DeviceType]] = None,
      notDeviceTypes: Option[List[DeviceType]] = None,
      deviceModels: Option[List[DeviceModel]] = None,
      notDeviceModels: Option[List[DeviceModel]] = None,
      deviceOperatingSystems: Option[List[DeviceOperatingSystem]] = None,
      notDeviceOperatingSystems: Option[List[DeviceOperatingSystem]] = None,
      deviceUserAgents: Option[List[DeviceUserAgent]] = None,
      notDeviceUserAgents: Option[List[DeviceUserAgent]] = None
    ): CreateMobileDeviceAccessRuleRequest =
      CreateMobileDeviceAccessRuleRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(effect)(_.effect(_))
        .ifSome(deviceTypes)(_.deviceTypes(_))
        .ifSome(notDeviceTypes)(_.notDeviceTypes(_))
        .ifSome(deviceModels)(_.deviceModels(_))
        .ifSome(notDeviceModels)(_.notDeviceModels(_))
        .ifSome(deviceOperatingSystems)(_.deviceOperatingSystems(_))
        .ifSome(notDeviceOperatingSystems)(_.notDeviceOperatingSystems(_))
        .ifSome(deviceUserAgents)(_.deviceUserAgents(_))
        .ifSome(notDeviceUserAgents)(_.notDeviceUserAgents(_))
        .build

    def createMobileDeviceAccessRuleResponse(
      mobileDeviceAccessRuleId: Option[String] = None
    ): CreateMobileDeviceAccessRuleResponse =
      CreateMobileDeviceAccessRuleResponse
        .builder
        .ifSome(mobileDeviceAccessRuleId)(_.mobileDeviceAccessRuleId(_))
        .build

    def createOrganizationRequest(
      directoryId: Option[String] = None,
      alias: Option[String] = None,
      clientToken: Option[String] = None,
      domains: Option[List[Domain]] = None,
      kmsKeyArn: Option[String] = None,
      enableInteroperability: Option[Boolean] = None
    ): CreateOrganizationRequest =
      CreateOrganizationRequest
        .builder
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(domains)(_.domains(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(enableInteroperability)(_.enableInteroperability(_))
        .build

    def createOrganizationResponse(
      organizationId: Option[String] = None
    ): CreateOrganizationResponse =
      CreateOrganizationResponse
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def createResourceRequest(
      organizationId: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None
    ): CreateResourceRequest =
      CreateResourceRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createResourceResponse(
      resourceId: Option[String] = None
    ): CreateResourceResponse =
      CreateResourceResponse
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def createUserRequest(
      organizationId: Option[String] = None,
      name: Option[String] = None,
      displayName: Option[String] = None,
      password: Option[String] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(password)(_.password(_))
        .build

    def createUserResponse(
      userId: Option[String] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(userId)(_.userId(_))
        .build

    def delegate(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): Delegate =
      Delegate
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def deleteAccessControlRuleRequest(
      organizationId: Option[String] = None,
      name: Option[String] = None
    ): DeleteAccessControlRuleRequest =
      DeleteAccessControlRuleRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteAccessControlRuleResponse(

    ): DeleteAccessControlRuleResponse =
      DeleteAccessControlRuleResponse
        .builder

        .build

    def deleteAliasRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      alias: Option[String] = None
    ): DeleteAliasRequest =
      DeleteAliasRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(alias)(_.alias(_))
        .build

    def deleteAliasResponse(

    ): DeleteAliasResponse =
      DeleteAliasResponse
        .builder

        .build

    def deleteGroupRequest(
      organizationId: Option[String] = None,
      groupId: Option[String] = None
    ): DeleteGroupRequest =
      DeleteGroupRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def deleteGroupResponse(

    ): DeleteGroupResponse =
      DeleteGroupResponse
        .builder

        .build

    def deleteMailboxPermissionsRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      granteeId: Option[String] = None
    ): DeleteMailboxPermissionsRequest =
      DeleteMailboxPermissionsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(granteeId)(_.granteeId(_))
        .build

    def deleteMailboxPermissionsResponse(

    ): DeleteMailboxPermissionsResponse =
      DeleteMailboxPermissionsResponse
        .builder

        .build

    def deleteMobileDeviceAccessRuleRequest(
      organizationId: Option[String] = None,
      mobileDeviceAccessRuleId: Option[String] = None
    ): DeleteMobileDeviceAccessRuleRequest =
      DeleteMobileDeviceAccessRuleRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(mobileDeviceAccessRuleId)(_.mobileDeviceAccessRuleId(_))
        .build

    def deleteMobileDeviceAccessRuleResponse(

    ): DeleteMobileDeviceAccessRuleResponse =
      DeleteMobileDeviceAccessRuleResponse
        .builder

        .build

    def deleteOrganizationRequest(
      clientToken: Option[String] = None,
      organizationId: Option[String] = None,
      deleteDirectory: Option[Boolean] = None
    ): DeleteOrganizationRequest =
      DeleteOrganizationRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(deleteDirectory)(_.deleteDirectory(_))
        .build

    def deleteOrganizationResponse(
      organizationId: Option[String] = None,
      state: Option[String] = None
    ): DeleteOrganizationResponse =
      DeleteOrganizationResponse
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(state)(_.state(_))
        .build

    def deleteResourceRequest(
      organizationId: Option[String] = None,
      resourceId: Option[String] = None
    ): DeleteResourceRequest =
      DeleteResourceRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def deleteResourceResponse(

    ): DeleteResourceResponse =
      DeleteResourceResponse
        .builder

        .build

    def deleteRetentionPolicyRequest(
      organizationId: Option[String] = None,
      id: Option[String] = None
    ): DeleteRetentionPolicyRequest =
      DeleteRetentionPolicyRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(id)(_.id(_))
        .build

    def deleteRetentionPolicyResponse(

    ): DeleteRetentionPolicyResponse =
      DeleteRetentionPolicyResponse
        .builder

        .build

    def deleteUserRequest(
      organizationId: Option[String] = None,
      userId: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def deleteUserResponse(

    ): DeleteUserResponse =
      DeleteUserResponse
        .builder

        .build

    def deregisterFromWorkMailRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None
    ): DeregisterFromWorkMailRequest =
      DeregisterFromWorkMailRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .build

    def deregisterFromWorkMailResponse(

    ): DeregisterFromWorkMailResponse =
      DeregisterFromWorkMailResponse
        .builder

        .build

    def describeGroupRequest(
      organizationId: Option[String] = None,
      groupId: Option[String] = None
    ): DescribeGroupRequest =
      DescribeGroupRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def describeGroupResponse(
      groupId: Option[String] = None,
      name: Option[String] = None,
      email: Option[String] = None,
      state: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): DescribeGroupResponse =
      DescribeGroupResponse
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(name)(_.name(_))
        .ifSome(email)(_.email(_))
        .ifSome(state)(_.state(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

    def describeMailboxExportJobRequest(
      jobId: Option[String] = None,
      organizationId: Option[String] = None
    ): DescribeMailboxExportJobRequest =
      DescribeMailboxExportJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def describeMailboxExportJobResponse(
      entityId: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3Prefix: Option[String] = None,
      s3Path: Option[String] = None,
      estimatedProgress: Option[Int] = None,
      state: Option[String] = None,
      errorInfo: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): DescribeMailboxExportJobResponse =
      DescribeMailboxExportJobResponse
        .builder
        .ifSome(entityId)(_.entityId(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(s3Path)(_.s3Path(_))
        .ifSome(estimatedProgress)(_.estimatedProgress(_))
        .ifSome(state)(_.state(_))
        .ifSome(errorInfo)(_.errorInfo(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def describeOrganizationRequest(
      organizationId: Option[String] = None
    ): DescribeOrganizationRequest =
      DescribeOrganizationRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def describeOrganizationResponse(
      organizationId: Option[String] = None,
      alias: Option[String] = None,
      state: Option[String] = None,
      directoryId: Option[String] = None,
      directoryType: Option[String] = None,
      defaultMailDomain: Option[String] = None,
      completedDate: Option[Timestamp] = None,
      errorMessage: Option[String] = None,
      aRN: Option[String] = None
    ): DescribeOrganizationResponse =
      DescribeOrganizationResponse
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(state)(_.state(_))
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(directoryType)(_.directoryType(_))
        .ifSome(defaultMailDomain)(_.defaultMailDomain(_))
        .ifSome(completedDate)(_.completedDate(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(aRN)(_.aRN(_))
        .build

    def describeResourceRequest(
      organizationId: Option[String] = None,
      resourceId: Option[String] = None
    ): DescribeResourceRequest =
      DescribeResourceRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def describeResourceResponse(
      resourceId: Option[String] = None,
      email: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      bookingOptions: Option[BookingOptions] = None,
      state: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): DescribeResourceResponse =
      DescribeResourceResponse
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(email)(_.email(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(bookingOptions)(_.bookingOptions(_))
        .ifSome(state)(_.state(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

    def describeUserRequest(
      organizationId: Option[String] = None,
      userId: Option[String] = None
    ): DescribeUserRequest =
      DescribeUserRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def describeUserResponse(
      userId: Option[String] = None,
      name: Option[String] = None,
      email: Option[String] = None,
      displayName: Option[String] = None,
      state: Option[String] = None,
      userRole: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): DescribeUserResponse =
      DescribeUserResponse
        .builder
        .ifSome(userId)(_.userId(_))
        .ifSome(name)(_.name(_))
        .ifSome(email)(_.email(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(state)(_.state(_))
        .ifSome(userRole)(_.userRole(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

    def directoryInUseException(
      message: Option[String] = None
    ): DirectoryInUseException =
      DirectoryInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def directoryServiceAuthenticationFailedException(
      message: Option[String] = None
    ): DirectoryServiceAuthenticationFailedException =
      DirectoryServiceAuthenticationFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def directoryUnavailableException(
      message: Option[String] = None
    ): DirectoryUnavailableException =
      DirectoryUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def disassociateDelegateFromResourceRequest(
      organizationId: Option[String] = None,
      resourceId: Option[String] = None,
      entityId: Option[String] = None
    ): DisassociateDelegateFromResourceRequest =
      DisassociateDelegateFromResourceRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(entityId)(_.entityId(_))
        .build

    def disassociateDelegateFromResourceResponse(

    ): DisassociateDelegateFromResourceResponse =
      DisassociateDelegateFromResourceResponse
        .builder

        .build

    def disassociateMemberFromGroupRequest(
      organizationId: Option[String] = None,
      groupId: Option[String] = None,
      memberId: Option[String] = None
    ): DisassociateMemberFromGroupRequest =
      DisassociateMemberFromGroupRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def disassociateMemberFromGroupResponse(

    ): DisassociateMemberFromGroupResponse =
      DisassociateMemberFromGroupResponse
        .builder

        .build

    def domain(
      domainName: Option[String] = None,
      hostedZoneId: Option[String] = None
    ): Domain =
      Domain
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(hostedZoneId)(_.hostedZoneId(_))
        .build

    def emailAddressInUseException(
      message: Option[String] = None
    ): EmailAddressInUseException =
      EmailAddressInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entityAlreadyRegisteredException(
      message: Option[String] = None
    ): EntityAlreadyRegisteredException =
      EntityAlreadyRegisteredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entityNotFoundException(
      message: Option[String] = None
    ): EntityNotFoundException =
      EntityNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entityStateException(
      message: Option[String] = None
    ): EntityStateException =
      EntityStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def folderConfiguration(
      name: Option[String] = None,
      action: Option[String] = None,
      period: Option[Int] = None
    ): FolderConfiguration =
      FolderConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(action)(_.action(_))
        .ifSome(period)(_.period(_))
        .build

    def getAccessControlEffectRequest(
      organizationId: Option[String] = None,
      ipAddress: Option[String] = None,
      action: Option[String] = None,
      userId: Option[String] = None
    ): GetAccessControlEffectRequest =
      GetAccessControlEffectRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(action)(_.action(_))
        .ifSome(userId)(_.userId(_))
        .build

    def getAccessControlEffectResponse(
      effect: Option[String] = None,
      matchedRules: Option[List[AccessControlRuleName]] = None
    ): GetAccessControlEffectResponse =
      GetAccessControlEffectResponse
        .builder
        .ifSome(effect)(_.effect(_))
        .ifSome(matchedRules)(_.matchedRules(_))
        .build

    def getDefaultRetentionPolicyRequest(
      organizationId: Option[String] = None
    ): GetDefaultRetentionPolicyRequest =
      GetDefaultRetentionPolicyRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def getDefaultRetentionPolicyResponse(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      folderConfigurations: Option[List[FolderConfiguration]] = None
    ): GetDefaultRetentionPolicyResponse =
      GetDefaultRetentionPolicyResponse
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(folderConfigurations)(_.folderConfigurations(_))
        .build

    def getMailboxDetailsRequest(
      organizationId: Option[String] = None,
      userId: Option[String] = None
    ): GetMailboxDetailsRequest =
      GetMailboxDetailsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(userId)(_.userId(_))
        .build

    def getMailboxDetailsResponse(
      mailboxQuota: Option[Int] = None,
      mailboxSize: Option[MailboxSize] = None
    ): GetMailboxDetailsResponse =
      GetMailboxDetailsResponse
        .builder
        .ifSome(mailboxQuota)(_.mailboxQuota(_))
        .ifSome(mailboxSize)(_.mailboxSize(_))
        .build

    def getMobileDeviceAccessEffectRequest(
      organizationId: Option[String] = None,
      deviceType: Option[String] = None,
      deviceModel: Option[String] = None,
      deviceOperatingSystem: Option[String] = None,
      deviceUserAgent: Option[String] = None
    ): GetMobileDeviceAccessEffectRequest =
      GetMobileDeviceAccessEffectRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(deviceModel)(_.deviceModel(_))
        .ifSome(deviceOperatingSystem)(_.deviceOperatingSystem(_))
        .ifSome(deviceUserAgent)(_.deviceUserAgent(_))
        .build

    def getMobileDeviceAccessEffectResponse(
      effect: Option[String] = None,
      matchedRules: Option[List[MobileDeviceAccessMatchedRule]] = None
    ): GetMobileDeviceAccessEffectResponse =
      GetMobileDeviceAccessEffectResponse
        .builder
        .ifSome(effect)(_.effect(_))
        .ifSome(matchedRules)(_.matchedRules(_))
        .build

    def group(
      id: Option[String] = None,
      email: Option[String] = None,
      name: Option[String] = None,
      state: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): Group =
      Group
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(email)(_.email(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

    def invalidConfigurationException(
      message: Option[String] = None
    ): InvalidConfigurationException =
      InvalidConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPasswordException(
      message: Option[String] = None
    ): InvalidPasswordException =
      InvalidPasswordException
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

    def listAccessControlRulesRequest(
      organizationId: Option[String] = None
    ): ListAccessControlRulesRequest =
      ListAccessControlRulesRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def listAccessControlRulesResponse(
      rules: Option[List[AccessControlRule]] = None
    ): ListAccessControlRulesResponse =
      ListAccessControlRulesResponse
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def listAliasesRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAliasesRequest =
      ListAliasesRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAliasesResponse(
      aliases: Option[List[EmailAddress]] = None,
      nextToken: Option[String] = None
    ): ListAliasesResponse =
      ListAliasesResponse
        .builder
        .ifSome(aliases)(_.aliases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupMembersRequest(
      organizationId: Option[String] = None,
      groupId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGroupMembersRequest =
      ListGroupMembersRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGroupMembersResponse(
      members: Option[List[Member]] = None,
      nextToken: Option[String] = None
    ): ListGroupMembersResponse =
      ListGroupMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupsRequest(
      organizationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGroupsRequest =
      ListGroupsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGroupsResponse(
      groups: Option[List[Group]] = None,
      nextToken: Option[String] = None
    ): ListGroupsResponse =
      ListGroupsResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMailboxExportJobsRequest(
      organizationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMailboxExportJobsRequest =
      ListMailboxExportJobsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMailboxExportJobsResponse(
      jobs: Option[List[MailboxExportJob]] = None,
      nextToken: Option[String] = None
    ): ListMailboxExportJobsResponse =
      ListMailboxExportJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMailboxPermissionsRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMailboxPermissionsRequest =
      ListMailboxPermissionsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMailboxPermissionsResponse(
      permissions: Option[List[Permission]] = None,
      nextToken: Option[String] = None
    ): ListMailboxPermissionsResponse =
      ListMailboxPermissionsResponse
        .builder
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMobileDeviceAccessRulesRequest(
      organizationId: Option[String] = None
    ): ListMobileDeviceAccessRulesRequest =
      ListMobileDeviceAccessRulesRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def listMobileDeviceAccessRulesResponse(
      rules: Option[List[MobileDeviceAccessRule]] = None
    ): ListMobileDeviceAccessRulesResponse =
      ListMobileDeviceAccessRulesResponse
        .builder
        .ifSome(rules)(_.rules(_))
        .build

    def listOrganizationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListOrganizationsRequest =
      ListOrganizationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listOrganizationsResponse(
      organizationSummaries: Option[List[OrganizationSummary]] = None,
      nextToken: Option[String] = None
    ): ListOrganizationsResponse =
      ListOrganizationsResponse
        .builder
        .ifSome(organizationSummaries)(_.organizationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceDelegatesRequest(
      organizationId: Option[String] = None,
      resourceId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourceDelegatesRequest =
      ListResourceDelegatesRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourceDelegatesResponse(
      delegates: Option[List[Delegate]] = None,
      nextToken: Option[String] = None
    ): ListResourceDelegatesResponse =
      ListResourceDelegatesResponse
        .builder
        .ifSome(delegates)(_.delegates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourcesRequest(
      organizationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourcesRequest =
      ListResourcesRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourcesResponse(
      resources: Option[List[Resource]] = None,
      nextToken: Option[String] = None
    ): ListResourcesResponse =
      ListResourcesResponse
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(nextToken)(_.nextToken(_))
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
      organizationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
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

    def mailDomainNotFoundException(
      message: Option[String] = None
    ): MailDomainNotFoundException =
      MailDomainNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def mailDomainStateException(
      message: Option[String] = None
    ): MailDomainStateException =
      MailDomainStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def mailboxExportJob(
      jobId: Option[String] = None,
      entityId: Option[String] = None,
      description: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3Path: Option[String] = None,
      estimatedProgress: Option[Int] = None,
      state: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): MailboxExportJob =
      MailboxExportJob
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(description)(_.description(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Path)(_.s3Path(_))
        .ifSome(estimatedProgress)(_.estimatedProgress(_))
        .ifSome(state)(_.state(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def member(
      id: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): Member =
      Member
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

    def mobileDeviceAccessMatchedRule(
      mobileDeviceAccessRuleId: Option[String] = None,
      name: Option[String] = None
    ): MobileDeviceAccessMatchedRule =
      MobileDeviceAccessMatchedRule
        .builder
        .ifSome(mobileDeviceAccessRuleId)(_.mobileDeviceAccessRuleId(_))
        .ifSome(name)(_.name(_))
        .build

    def mobileDeviceAccessRule(
      mobileDeviceAccessRuleId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      effect: Option[String] = None,
      deviceTypes: Option[List[DeviceType]] = None,
      notDeviceTypes: Option[List[DeviceType]] = None,
      deviceModels: Option[List[DeviceModel]] = None,
      notDeviceModels: Option[List[DeviceModel]] = None,
      deviceOperatingSystems: Option[List[DeviceOperatingSystem]] = None,
      notDeviceOperatingSystems: Option[List[DeviceOperatingSystem]] = None,
      deviceUserAgents: Option[List[DeviceUserAgent]] = None,
      notDeviceUserAgents: Option[List[DeviceUserAgent]] = None,
      dateCreated: Option[Timestamp] = None,
      dateModified: Option[Timestamp] = None
    ): MobileDeviceAccessRule =
      MobileDeviceAccessRule
        .builder
        .ifSome(mobileDeviceAccessRuleId)(_.mobileDeviceAccessRuleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(effect)(_.effect(_))
        .ifSome(deviceTypes)(_.deviceTypes(_))
        .ifSome(notDeviceTypes)(_.notDeviceTypes(_))
        .ifSome(deviceModels)(_.deviceModels(_))
        .ifSome(notDeviceModels)(_.notDeviceModels(_))
        .ifSome(deviceOperatingSystems)(_.deviceOperatingSystems(_))
        .ifSome(notDeviceOperatingSystems)(_.notDeviceOperatingSystems(_))
        .ifSome(deviceUserAgents)(_.deviceUserAgents(_))
        .ifSome(notDeviceUserAgents)(_.notDeviceUserAgents(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateModified)(_.dateModified(_))
        .build

    def nameAvailabilityException(
      message: Option[String] = None
    ): NameAvailabilityException =
      NameAvailabilityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationNotFoundException(
      message: Option[String] = None
    ): OrganizationNotFoundException =
      OrganizationNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationStateException(
      message: Option[String] = None
    ): OrganizationStateException =
      OrganizationStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationSummary(
      organizationId: Option[String] = None,
      alias: Option[String] = None,
      defaultMailDomain: Option[String] = None,
      errorMessage: Option[String] = None,
      state: Option[String] = None
    ): OrganizationSummary =
      OrganizationSummary
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(alias)(_.alias(_))
        .ifSome(defaultMailDomain)(_.defaultMailDomain(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(state)(_.state(_))
        .build

    def permission(
      granteeId: Option[String] = None,
      granteeType: Option[String] = None,
      permissionValues: Option[List[PermissionType]] = None
    ): Permission =
      Permission
        .builder
        .ifSome(granteeId)(_.granteeId(_))
        .ifSome(granteeType)(_.granteeType(_))
        .ifSome(permissionValues)(_.permissionValues(_))
        .build

    def putAccessControlRuleRequest(
      name: Option[String] = None,
      effect: Option[String] = None,
      description: Option[String] = None,
      ipRanges: Option[List[IpRange]] = None,
      notIpRanges: Option[List[IpRange]] = None,
      actions: Option[List[AccessControlRuleAction]] = None,
      notActions: Option[List[AccessControlRuleAction]] = None,
      userIds: Option[List[WorkMailIdentifier]] = None,
      notUserIds: Option[List[WorkMailIdentifier]] = None,
      organizationId: Option[String] = None
    ): PutAccessControlRuleRequest =
      PutAccessControlRuleRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(effect)(_.effect(_))
        .ifSome(description)(_.description(_))
        .ifSome(ipRanges)(_.ipRanges(_))
        .ifSome(notIpRanges)(_.notIpRanges(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(notActions)(_.notActions(_))
        .ifSome(userIds)(_.userIds(_))
        .ifSome(notUserIds)(_.notUserIds(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def putAccessControlRuleResponse(

    ): PutAccessControlRuleResponse =
      PutAccessControlRuleResponse
        .builder

        .build

    def putMailboxPermissionsRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      granteeId: Option[String] = None,
      permissionValues: Option[List[PermissionType]] = None
    ): PutMailboxPermissionsRequest =
      PutMailboxPermissionsRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(granteeId)(_.granteeId(_))
        .ifSome(permissionValues)(_.permissionValues(_))
        .build

    def putMailboxPermissionsResponse(

    ): PutMailboxPermissionsResponse =
      PutMailboxPermissionsResponse
        .builder

        .build

    def putRetentionPolicyRequest(
      organizationId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      folderConfigurations: Option[List[FolderConfiguration]] = None
    ): PutRetentionPolicyRequest =
      PutRetentionPolicyRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(folderConfigurations)(_.folderConfigurations(_))
        .build

    def putRetentionPolicyResponse(

    ): PutRetentionPolicyResponse =
      PutRetentionPolicyResponse
        .builder

        .build

    def registerToWorkMailRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      email: Option[String] = None
    ): RegisterToWorkMailRequest =
      RegisterToWorkMailRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(email)(_.email(_))
        .build

    def registerToWorkMailResponse(

    ): RegisterToWorkMailResponse =
      RegisterToWorkMailResponse
        .builder

        .build

    def reservedNameException(
      message: Option[String] = None
    ): ReservedNameException =
      ReservedNameException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resetPasswordRequest(
      organizationId: Option[String] = None,
      userId: Option[String] = None,
      password: Option[String] = None
    ): ResetPasswordRequest =
      ResetPasswordRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(password)(_.password(_))
        .build

    def resetPasswordResponse(

    ): ResetPasswordResponse =
      ResetPasswordResponse
        .builder

        .build

    def resource(
      id: Option[String] = None,
      email: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      state: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): Resource =
      Resource
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(email)(_.email(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(state)(_.state(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startMailboxExportJobRequest(
      clientToken: Option[String] = None,
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      description: Option[String] = None,
      roleArn: Option[String] = None,
      kmsKeyArn: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3Prefix: Option[String] = None
    ): StartMailboxExportJobRequest =
      StartMailboxExportJobRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(description)(_.description(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def startMailboxExportJobResponse(
      jobId: Option[String] = None
    ): StartMailboxExportJobResponse =
      StartMailboxExportJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
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
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
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

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateMailboxQuotaRequest(
      organizationId: Option[String] = None,
      userId: Option[String] = None,
      mailboxQuota: Option[Int] = None
    ): UpdateMailboxQuotaRequest =
      UpdateMailboxQuotaRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(mailboxQuota)(_.mailboxQuota(_))
        .build

    def updateMailboxQuotaResponse(

    ): UpdateMailboxQuotaResponse =
      UpdateMailboxQuotaResponse
        .builder

        .build

    def updateMobileDeviceAccessRuleRequest(
      organizationId: Option[String] = None,
      mobileDeviceAccessRuleId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      effect: Option[String] = None,
      deviceTypes: Option[List[DeviceType]] = None,
      notDeviceTypes: Option[List[DeviceType]] = None,
      deviceModels: Option[List[DeviceModel]] = None,
      notDeviceModels: Option[List[DeviceModel]] = None,
      deviceOperatingSystems: Option[List[DeviceOperatingSystem]] = None,
      notDeviceOperatingSystems: Option[List[DeviceOperatingSystem]] = None,
      deviceUserAgents: Option[List[DeviceUserAgent]] = None,
      notDeviceUserAgents: Option[List[DeviceUserAgent]] = None
    ): UpdateMobileDeviceAccessRuleRequest =
      UpdateMobileDeviceAccessRuleRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(mobileDeviceAccessRuleId)(_.mobileDeviceAccessRuleId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(effect)(_.effect(_))
        .ifSome(deviceTypes)(_.deviceTypes(_))
        .ifSome(notDeviceTypes)(_.notDeviceTypes(_))
        .ifSome(deviceModels)(_.deviceModels(_))
        .ifSome(notDeviceModels)(_.notDeviceModels(_))
        .ifSome(deviceOperatingSystems)(_.deviceOperatingSystems(_))
        .ifSome(notDeviceOperatingSystems)(_.notDeviceOperatingSystems(_))
        .ifSome(deviceUserAgents)(_.deviceUserAgents(_))
        .ifSome(notDeviceUserAgents)(_.notDeviceUserAgents(_))
        .build

    def updateMobileDeviceAccessRuleResponse(

    ): UpdateMobileDeviceAccessRuleResponse =
      UpdateMobileDeviceAccessRuleResponse
        .builder

        .build

    def updatePrimaryEmailAddressRequest(
      organizationId: Option[String] = None,
      entityId: Option[String] = None,
      email: Option[String] = None
    ): UpdatePrimaryEmailAddressRequest =
      UpdatePrimaryEmailAddressRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(entityId)(_.entityId(_))
        .ifSome(email)(_.email(_))
        .build

    def updatePrimaryEmailAddressResponse(

    ): UpdatePrimaryEmailAddressResponse =
      UpdatePrimaryEmailAddressResponse
        .builder

        .build

    def updateResourceRequest(
      organizationId: Option[String] = None,
      resourceId: Option[String] = None,
      name: Option[String] = None,
      bookingOptions: Option[BookingOptions] = None
    ): UpdateResourceRequest =
      UpdateResourceRequest
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(bookingOptions)(_.bookingOptions(_))
        .build

    def updateResourceResponse(

    ): UpdateResourceResponse =
      UpdateResourceResponse
        .builder

        .build

    def user(
      id: Option[String] = None,
      email: Option[String] = None,
      name: Option[String] = None,
      displayName: Option[String] = None,
      state: Option[String] = None,
      userRole: Option[String] = None,
      enabledDate: Option[Timestamp] = None,
      disabledDate: Option[Timestamp] = None
    ): User =
      User
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(email)(_.email(_))
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(state)(_.state(_))
        .ifSome(userRole)(_.userRole(_))
        .ifSome(enabledDate)(_.enabledDate(_))
        .ifSome(disabledDate)(_.disabledDate(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
