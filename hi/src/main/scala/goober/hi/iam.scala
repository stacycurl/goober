package goober.hi

import goober.free.iam.IamIO
import software.amazon.awssdk.services.iam.model._


object iam {
  import goober.free.{iam ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDetail(
      serviceName: Option[String] = None,
      serviceNamespace: Option[String] = None,
      region: Option[String] = None,
      entityPath: Option[String] = None,
      lastAuthenticatedTime: Option[dateType] = None,
      totalAuthenticatedEntities: Option[Int] = None
    ): AccessDetail =
      AccessDetail
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(region)(_.region(_))
        .ifSome(entityPath)(_.entityPath(_))
        .ifSome(lastAuthenticatedTime)(_.lastAuthenticatedTime(_))
        .ifSome(totalAuthenticatedEntities)(_.totalAuthenticatedEntities(_))
        .build

    def accessKey(
      userName: Option[String] = None,
      accessKeyId: Option[String] = None,
      status: Option[String] = None,
      secretAccessKey: Option[String] = None,
      createDate: Option[dateType] = None
    ): AccessKey =
      AccessKey
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def accessKeyLastUsed(
      lastUsedDate: Option[dateType] = None,
      serviceName: Option[String] = None,
      region: Option[String] = None
    ): AccessKeyLastUsed =
      AccessKeyLastUsed
        .builder
        .ifSome(lastUsedDate)(_.lastUsedDate(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(region)(_.region(_))
        .build

    def accessKeyMetadata(
      userName: Option[String] = None,
      accessKeyId: Option[String] = None,
      status: Option[String] = None,
      createDate: Option[dateType] = None
    ): AccessKeyMetadata =
      AccessKeyMetadata
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def addClientIDToOpenIDConnectProviderRequest(
      openIDConnectProviderArn: Option[String] = None,
      clientID: Option[String] = None
    ): AddClientIDToOpenIDConnectProviderRequest =
      AddClientIDToOpenIDConnectProviderRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(clientID)(_.clientID(_))
        .build

    def addRoleToInstanceProfileRequest(
      instanceProfileName: Option[String] = None,
      roleName: Option[String] = None
    ): AddRoleToInstanceProfileRequest =
      AddRoleToInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(roleName)(_.roleName(_))
        .build

    def addUserToGroupRequest(
      groupName: Option[String] = None,
      userName: Option[String] = None
    ): AddUserToGroupRequest =
      AddUserToGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userName)(_.userName(_))
        .build

    def attachGroupPolicyRequest(
      groupName: Option[String] = None,
      policyArn: Option[String] = None
    ): AttachGroupPolicyRequest =
      AttachGroupPolicyRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def attachRolePolicyRequest(
      roleName: Option[String] = None,
      policyArn: Option[String] = None
    ): AttachRolePolicyRequest =
      AttachRolePolicyRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def attachUserPolicyRequest(
      userName: Option[String] = None,
      policyArn: Option[String] = None
    ): AttachUserPolicyRequest =
      AttachUserPolicyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def attachedPermissionsBoundary(
      permissionsBoundaryType: Option[String] = None,
      permissionsBoundaryArn: Option[String] = None
    ): AttachedPermissionsBoundary =
      AttachedPermissionsBoundary
        .builder
        .ifSome(permissionsBoundaryType)(_.permissionsBoundaryType(_))
        .ifSome(permissionsBoundaryArn)(_.permissionsBoundaryArn(_))
        .build

    def attachedPolicy(
      policyName: Option[String] = None,
      policyArn: Option[String] = None
    ): AttachedPolicy =
      AttachedPolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def changePasswordRequest(
      oldPassword: Option[String] = None,
      newPassword: Option[String] = None
    ): ChangePasswordRequest =
      ChangePasswordRequest
        .builder
        .ifSome(oldPassword)(_.oldPassword(_))
        .ifSome(newPassword)(_.newPassword(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def contextEntry(
      contextKeyName: Option[String] = None,
      contextKeyValues: Option[List[ContextKeyValueType]] = None,
      contextKeyType: Option[String] = None
    ): ContextEntry =
      ContextEntry
        .builder
        .ifSome(contextKeyName)(_.contextKeyName(_))
        .ifSome(contextKeyValues)(_.contextKeyValues(_))
        .ifSome(contextKeyType)(_.contextKeyType(_))
        .build

    def createAccessKeyRequest(
      userName: Option[String] = None
    ): CreateAccessKeyRequest =
      CreateAccessKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .build

    def createAccessKeyResponse(
      accessKey: Option[AccessKey] = None
    ): CreateAccessKeyResponse =
      CreateAccessKeyResponse
        .builder
        .ifSome(accessKey)(_.accessKey(_))
        .build

    def createAccountAliasRequest(
      accountAlias: Option[String] = None
    ): CreateAccountAliasRequest =
      CreateAccountAliasRequest
        .builder
        .ifSome(accountAlias)(_.accountAlias(_))
        .build

    def createGroupRequest(
      path: Option[String] = None,
      groupName: Option[String] = None
    ): CreateGroupRequest =
      CreateGroupRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(groupName)(_.groupName(_))
        .build

    def createGroupResponse(
      group: Option[Group] = None
    ): CreateGroupResponse =
      CreateGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .build

    def createInstanceProfileRequest(
      instanceProfileName: Option[String] = None,
      path: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateInstanceProfileRequest =
      CreateInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(path)(_.path(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createInstanceProfileResponse(
      instanceProfile: Option[InstanceProfile] = None
    ): CreateInstanceProfileResponse =
      CreateInstanceProfileResponse
        .builder
        .ifSome(instanceProfile)(_.instanceProfile(_))
        .build

    def createLoginProfileRequest(
      userName: Option[String] = None,
      password: Option[String] = None,
      passwordResetRequired: Option[Boolean] = None
    ): CreateLoginProfileRequest =
      CreateLoginProfileRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .ifSome(passwordResetRequired)(_.passwordResetRequired(_))
        .build

    def createLoginProfileResponse(
      loginProfile: Option[LoginProfile] = None
    ): CreateLoginProfileResponse =
      CreateLoginProfileResponse
        .builder
        .ifSome(loginProfile)(_.loginProfile(_))
        .build

    def createOpenIDConnectProviderRequest(
      url: Option[String] = None,
      clientIDList: Option[List[clientIDType]] = None,
      thumbprintList: Option[List[thumbprintType]] = None,
      tags: Option[List[Tag]] = None
    ): CreateOpenIDConnectProviderRequest =
      CreateOpenIDConnectProviderRequest
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(clientIDList)(_.clientIDList(_))
        .ifSome(thumbprintList)(_.thumbprintList(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createOpenIDConnectProviderResponse(
      openIDConnectProviderArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateOpenIDConnectProviderResponse =
      CreateOpenIDConnectProviderResponse
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPolicyRequest(
      policyName: Option[String] = None,
      path: Option[String] = None,
      policyDocument: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePolicyRequest =
      CreatePolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(path)(_.path(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPolicyResponse(
      policy: Option[Policy] = None
    ): CreatePolicyResponse =
      CreatePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def createPolicyVersionRequest(
      policyArn: Option[String] = None,
      policyDocument: Option[String] = None,
      setAsDefault: Option[Boolean] = None
    ): CreatePolicyVersionRequest =
      CreatePolicyVersionRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(setAsDefault)(_.setAsDefault(_))
        .build

    def createPolicyVersionResponse(
      policyVersion: Option[PolicyVersion] = None
    ): CreatePolicyVersionResponse =
      CreatePolicyVersionResponse
        .builder
        .ifSome(policyVersion)(_.policyVersion(_))
        .build

    def createRoleRequest(
      path: Option[String] = None,
      roleName: Option[String] = None,
      assumeRolePolicyDocument: Option[String] = None,
      description: Option[String] = None,
      maxSessionDuration: Option[Int] = None,
      permissionsBoundary: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateRoleRequest =
      CreateRoleRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(assumeRolePolicyDocument)(_.assumeRolePolicyDocument(_))
        .ifSome(description)(_.description(_))
        .ifSome(maxSessionDuration)(_.maxSessionDuration(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRoleResponse(
      role: Option[Role] = None
    ): CreateRoleResponse =
      CreateRoleResponse
        .builder
        .ifSome(role)(_.role(_))
        .build

    def createSAMLProviderRequest(
      sAMLMetadataDocument: Option[String] = None,
      name: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSAMLProviderRequest =
      CreateSAMLProviderRequest
        .builder
        .ifSome(sAMLMetadataDocument)(_.sAMLMetadataDocument(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSAMLProviderResponse(
      sAMLProviderArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateSAMLProviderResponse =
      CreateSAMLProviderResponse
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createServiceLinkedRoleRequest(
      aWSServiceName: Option[String] = None,
      description: Option[String] = None,
      customSuffix: Option[String] = None
    ): CreateServiceLinkedRoleRequest =
      CreateServiceLinkedRoleRequest
        .builder
        .ifSome(aWSServiceName)(_.aWSServiceName(_))
        .ifSome(description)(_.description(_))
        .ifSome(customSuffix)(_.customSuffix(_))
        .build

    def createServiceLinkedRoleResponse(
      role: Option[Role] = None
    ): CreateServiceLinkedRoleResponse =
      CreateServiceLinkedRoleResponse
        .builder
        .ifSome(role)(_.role(_))
        .build

    def createServiceSpecificCredentialRequest(
      userName: Option[String] = None,
      serviceName: Option[String] = None
    ): CreateServiceSpecificCredentialRequest =
      CreateServiceSpecificCredentialRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def createServiceSpecificCredentialResponse(
      serviceSpecificCredential: Option[ServiceSpecificCredential] = None
    ): CreateServiceSpecificCredentialResponse =
      CreateServiceSpecificCredentialResponse
        .builder
        .ifSome(serviceSpecificCredential)(_.serviceSpecificCredential(_))
        .build

    def createUserRequest(
      path: Option[String] = None,
      userName: Option[String] = None,
      permissionsBoundary: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserResponse(
      user: Option[User] = None
    ): CreateUserResponse =
      CreateUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def createVirtualMFADeviceRequest(
      path: Option[String] = None,
      virtualMFADeviceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateVirtualMFADeviceRequest =
      CreateVirtualMFADeviceRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(virtualMFADeviceName)(_.virtualMFADeviceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVirtualMFADeviceResponse(
      virtualMFADevice: Option[VirtualMFADevice] = None
    ): CreateVirtualMFADeviceResponse =
      CreateVirtualMFADeviceResponse
        .builder
        .ifSome(virtualMFADevice)(_.virtualMFADevice(_))
        .build

    def credentialReportExpiredException(
      message: Option[String] = None
    ): CredentialReportExpiredException =
      CredentialReportExpiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def credentialReportNotPresentException(
      message: Option[String] = None
    ): CredentialReportNotPresentException =
      CredentialReportNotPresentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def credentialReportNotReadyException(
      message: Option[String] = None
    ): CredentialReportNotReadyException =
      CredentialReportNotReadyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deactivateMFADeviceRequest(
      userName: Option[String] = None,
      serialNumber: Option[String] = None
    ): DeactivateMFADeviceRequest =
      DeactivateMFADeviceRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .build

    def deleteAccessKeyRequest(
      userName: Option[String] = None,
      accessKeyId: Option[String] = None
    ): DeleteAccessKeyRequest =
      DeleteAccessKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .build

    def deleteAccountAliasRequest(
      accountAlias: Option[String] = None
    ): DeleteAccountAliasRequest =
      DeleteAccountAliasRequest
        .builder
        .ifSome(accountAlias)(_.accountAlias(_))
        .build

    def deleteConflictException(
      message: Option[String] = None
    ): DeleteConflictException =
      DeleteConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteGroupPolicyRequest(
      groupName: Option[String] = None,
      policyName: Option[String] = None
    ): DeleteGroupPolicyRequest =
      DeleteGroupPolicyRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteGroupRequest(
      groupName: Option[String] = None
    ): DeleteGroupRequest =
      DeleteGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .build

    def deleteInstanceProfileRequest(
      instanceProfileName: Option[String] = None
    ): DeleteInstanceProfileRequest =
      DeleteInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .build

    def deleteLoginProfileRequest(
      userName: Option[String] = None
    ): DeleteLoginProfileRequest =
      DeleteLoginProfileRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .build

    def deleteOpenIDConnectProviderRequest(
      openIDConnectProviderArn: Option[String] = None
    ): DeleteOpenIDConnectProviderRequest =
      DeleteOpenIDConnectProviderRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .build

    def deletePolicyRequest(
      policyArn: Option[String] = None
    ): DeletePolicyRequest =
      DeletePolicyRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def deletePolicyVersionRequest(
      policyArn: Option[String] = None,
      versionId: Option[String] = None
    ): DeletePolicyVersionRequest =
      DeletePolicyVersionRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def deleteRolePermissionsBoundaryRequest(
      roleName: Option[String] = None
    ): DeleteRolePermissionsBoundaryRequest =
      DeleteRolePermissionsBoundaryRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .build

    def deleteRolePolicyRequest(
      roleName: Option[String] = None,
      policyName: Option[String] = None
    ): DeleteRolePolicyRequest =
      DeleteRolePolicyRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteRoleRequest(
      roleName: Option[String] = None
    ): DeleteRoleRequest =
      DeleteRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .build

    def deleteSAMLProviderRequest(
      sAMLProviderArn: Option[String] = None
    ): DeleteSAMLProviderRequest =
      DeleteSAMLProviderRequest
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .build

    def deleteSSHPublicKeyRequest(
      userName: Option[String] = None,
      sSHPublicKeyId: Option[String] = None
    ): DeleteSSHPublicKeyRequest =
      DeleteSSHPublicKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(sSHPublicKeyId)(_.sSHPublicKeyId(_))
        .build

    def deleteServerCertificateRequest(
      serverCertificateName: Option[String] = None
    ): DeleteServerCertificateRequest =
      DeleteServerCertificateRequest
        .builder
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .build

    def deleteServiceLinkedRoleRequest(
      roleName: Option[String] = None
    ): DeleteServiceLinkedRoleRequest =
      DeleteServiceLinkedRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .build

    def deleteServiceLinkedRoleResponse(
      deletionTaskId: Option[String] = None
    ): DeleteServiceLinkedRoleResponse =
      DeleteServiceLinkedRoleResponse
        .builder
        .ifSome(deletionTaskId)(_.deletionTaskId(_))
        .build

    def deleteServiceSpecificCredentialRequest(
      userName: Option[String] = None,
      serviceSpecificCredentialId: Option[String] = None
    ): DeleteServiceSpecificCredentialRequest =
      DeleteServiceSpecificCredentialRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serviceSpecificCredentialId)(_.serviceSpecificCredentialId(_))
        .build

    def deleteSigningCertificateRequest(
      userName: Option[String] = None,
      certificateId: Option[String] = None
    ): DeleteSigningCertificateRequest =
      DeleteSigningCertificateRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def deleteUserPermissionsBoundaryRequest(
      userName: Option[String] = None
    ): DeleteUserPermissionsBoundaryRequest =
      DeleteUserPermissionsBoundaryRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .build

    def deleteUserPolicyRequest(
      userName: Option[String] = None,
      policyName: Option[String] = None
    ): DeleteUserPolicyRequest =
      DeleteUserPolicyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def deleteUserRequest(
      userName: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .build

    def deleteVirtualMFADeviceRequest(
      serialNumber: Option[String] = None
    ): DeleteVirtualMFADeviceRequest =
      DeleteVirtualMFADeviceRequest
        .builder
        .ifSome(serialNumber)(_.serialNumber(_))
        .build

    def deletionTaskFailureReasonType(
      reason: Option[String] = None,
      roleUsageList: Option[List[RoleUsageType]] = None
    ): DeletionTaskFailureReasonType =
      DeletionTaskFailureReasonType
        .builder
        .ifSome(reason)(_.reason(_))
        .ifSome(roleUsageList)(_.roleUsageList(_))
        .build

    def detachGroupPolicyRequest(
      groupName: Option[String] = None,
      policyArn: Option[String] = None
    ): DetachGroupPolicyRequest =
      DetachGroupPolicyRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def detachRolePolicyRequest(
      roleName: Option[String] = None,
      policyArn: Option[String] = None
    ): DetachRolePolicyRequest =
      DetachRolePolicyRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def detachUserPolicyRequest(
      userName: Option[String] = None,
      policyArn: Option[String] = None
    ): DetachUserPolicyRequest =
      DetachUserPolicyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def duplicateCertificateException(
      message: Option[String] = None
    ): DuplicateCertificateException =
      DuplicateCertificateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateSSHPublicKeyException(
      message: Option[String] = None
    ): DuplicateSSHPublicKeyException =
      DuplicateSSHPublicKeyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def enableMFADeviceRequest(
      userName: Option[String] = None,
      serialNumber: Option[String] = None,
      authenticationCode1: Option[String] = None,
      authenticationCode2: Option[String] = None
    ): EnableMFADeviceRequest =
      EnableMFADeviceRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(authenticationCode1)(_.authenticationCode1(_))
        .ifSome(authenticationCode2)(_.authenticationCode2(_))
        .build

    def entityAlreadyExistsException(
      message: Option[String] = None
    ): EntityAlreadyExistsException =
      EntityAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def entityDetails(
      entityInfo: Option[EntityInfo] = None,
      lastAuthenticated: Option[dateType] = None
    ): EntityDetails =
      EntityDetails
        .builder
        .ifSome(entityInfo)(_.entityInfo(_))
        .ifSome(lastAuthenticated)(_.lastAuthenticated(_))
        .build

    def entityInfo(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      id: Option[String] = None,
      path: Option[String] = None
    ): EntityInfo =
      EntityInfo
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(path)(_.path(_))
        .build

    def entityTemporarilyUnmodifiableException(
      message: Option[String] = None
    ): EntityTemporarilyUnmodifiableException =
      EntityTemporarilyUnmodifiableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def errorDetails(
      message: Option[String] = None,
      code: Option[String] = None
    ): ErrorDetails =
      ErrorDetails
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(code)(_.code(_))
        .build

    def generateCredentialReportResponse(
      state: Option[String] = None,
      description: Option[String] = None
    ): GenerateCredentialReportResponse =
      GenerateCredentialReportResponse
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(description)(_.description(_))
        .build

    def generateOrganizationsAccessReportRequest(
      entityPath: Option[String] = None,
      organizationsPolicyId: Option[String] = None
    ): GenerateOrganizationsAccessReportRequest =
      GenerateOrganizationsAccessReportRequest
        .builder
        .ifSome(entityPath)(_.entityPath(_))
        .ifSome(organizationsPolicyId)(_.organizationsPolicyId(_))
        .build

    def generateOrganizationsAccessReportResponse(
      jobId: Option[String] = None
    ): GenerateOrganizationsAccessReportResponse =
      GenerateOrganizationsAccessReportResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def generateServiceLastAccessedDetailsRequest(
      arn: Option[String] = None,
      granularity: Option[String] = None
    ): GenerateServiceLastAccessedDetailsRequest =
      GenerateServiceLastAccessedDetailsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(granularity)(_.granularity(_))
        .build

    def generateServiceLastAccessedDetailsResponse(
      jobId: Option[String] = None
    ): GenerateServiceLastAccessedDetailsResponse =
      GenerateServiceLastAccessedDetailsResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getAccessKeyLastUsedRequest(
      accessKeyId: Option[String] = None
    ): GetAccessKeyLastUsedRequest =
      GetAccessKeyLastUsedRequest
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .build

    def getAccessKeyLastUsedResponse(
      userName: Option[String] = None,
      accessKeyLastUsed: Option[AccessKeyLastUsed] = None
    ): GetAccessKeyLastUsedResponse =
      GetAccessKeyLastUsedResponse
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(accessKeyLastUsed)(_.accessKeyLastUsed(_))
        .build

    def getAccountAuthorizationDetailsRequest(
      filter: Option[List[EntityType]] = None,
      maxItems: Option[Int] = None,
      marker: Option[String] = None
    ): GetAccountAuthorizationDetailsRequest =
      GetAccountAuthorizationDetailsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getAccountAuthorizationDetailsResponse(
      userDetailList: Option[List[UserDetail]] = None,
      groupDetailList: Option[List[GroupDetail]] = None,
      roleDetailList: Option[List[RoleDetail]] = None,
      policies: Option[List[ManagedPolicyDetail]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): GetAccountAuthorizationDetailsResponse =
      GetAccountAuthorizationDetailsResponse
        .builder
        .ifSome(userDetailList)(_.userDetailList(_))
        .ifSome(groupDetailList)(_.groupDetailList(_))
        .ifSome(roleDetailList)(_.roleDetailList(_))
        .ifSome(policies)(_.policies(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getAccountPasswordPolicyResponse(
      passwordPolicy: Option[PasswordPolicy] = None
    ): GetAccountPasswordPolicyResponse =
      GetAccountPasswordPolicyResponse
        .builder
        .ifSome(passwordPolicy)(_.passwordPolicy(_))
        .build

    def getAccountSummaryResponse(
      summaryMap: Option[summaryMapType] = None
    ): GetAccountSummaryResponse =
      GetAccountSummaryResponse
        .builder
        .ifSome(summaryMap)(_.summaryMap(_))
        .build

    def getContextKeysForCustomPolicyRequest(
      policyInputList: Option[List[policyDocumentType]] = None
    ): GetContextKeysForCustomPolicyRequest =
      GetContextKeysForCustomPolicyRequest
        .builder
        .ifSome(policyInputList)(_.policyInputList(_))
        .build

    def getContextKeysForPolicyResponse(
      contextKeyNames: Option[List[ContextKeyNameType]] = None
    ): GetContextKeysForPolicyResponse =
      GetContextKeysForPolicyResponse
        .builder
        .ifSome(contextKeyNames)(_.contextKeyNames(_))
        .build

    def getContextKeysForPrincipalPolicyRequest(
      policySourceArn: Option[String] = None,
      policyInputList: Option[List[policyDocumentType]] = None
    ): GetContextKeysForPrincipalPolicyRequest =
      GetContextKeysForPrincipalPolicyRequest
        .builder
        .ifSome(policySourceArn)(_.policySourceArn(_))
        .ifSome(policyInputList)(_.policyInputList(_))
        .build

    def getCredentialReportResponse(
      content: Option[ReportContentType] = None,
      reportFormat: Option[String] = None,
      generatedTime: Option[dateType] = None
    ): GetCredentialReportResponse =
      GetCredentialReportResponse
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(reportFormat)(_.reportFormat(_))
        .ifSome(generatedTime)(_.generatedTime(_))
        .build

    def getGroupPolicyRequest(
      groupName: Option[String] = None,
      policyName: Option[String] = None
    ): GetGroupPolicyRequest =
      GetGroupPolicyRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def getGroupPolicyResponse(
      groupName: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): GetGroupPolicyResponse =
      GetGroupPolicyResponse
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def getGroupRequest(
      groupName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): GetGroupRequest =
      GetGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def getGroupResponse(
      group: Option[Group] = None,
      users: Option[List[User]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): GetGroupResponse =
      GetGroupResponse
        .builder
        .ifSome(group)(_.group(_))
        .ifSome(users)(_.users(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getInstanceProfileRequest(
      instanceProfileName: Option[String] = None
    ): GetInstanceProfileRequest =
      GetInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .build

    def getInstanceProfileResponse(
      instanceProfile: Option[InstanceProfile] = None
    ): GetInstanceProfileResponse =
      GetInstanceProfileResponse
        .builder
        .ifSome(instanceProfile)(_.instanceProfile(_))
        .build

    def getLoginProfileRequest(
      userName: Option[String] = None
    ): GetLoginProfileRequest =
      GetLoginProfileRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .build

    def getLoginProfileResponse(
      loginProfile: Option[LoginProfile] = None
    ): GetLoginProfileResponse =
      GetLoginProfileResponse
        .builder
        .ifSome(loginProfile)(_.loginProfile(_))
        .build

    def getOpenIDConnectProviderRequest(
      openIDConnectProviderArn: Option[String] = None
    ): GetOpenIDConnectProviderRequest =
      GetOpenIDConnectProviderRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .build

    def getOpenIDConnectProviderResponse(
      url: Option[String] = None,
      clientIDList: Option[List[clientIDType]] = None,
      thumbprintList: Option[List[thumbprintType]] = None,
      createDate: Option[dateType] = None,
      tags: Option[List[Tag]] = None
    ): GetOpenIDConnectProviderResponse =
      GetOpenIDConnectProviderResponse
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(clientIDList)(_.clientIDList(_))
        .ifSome(thumbprintList)(_.thumbprintList(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getOrganizationsAccessReportRequest(
      jobId: Option[String] = None,
      maxItems: Option[Int] = None,
      marker: Option[String] = None,
      sortKey: Option[String] = None
    ): GetOrganizationsAccessReportRequest =
      GetOrganizationsAccessReportRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(sortKey)(_.sortKey(_))
        .build

    def getOrganizationsAccessReportResponse(
      jobStatus: Option[String] = None,
      jobCreationDate: Option[dateType] = None,
      jobCompletionDate: Option[dateType] = None,
      numberOfServicesAccessible: Option[Int] = None,
      numberOfServicesNotAccessed: Option[Int] = None,
      accessDetails: Option[List[AccessDetail]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None,
      errorDetails: Option[ErrorDetails] = None
    ): GetOrganizationsAccessReportResponse =
      GetOrganizationsAccessReportResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(jobCreationDate)(_.jobCreationDate(_))
        .ifSome(jobCompletionDate)(_.jobCompletionDate(_))
        .ifSome(numberOfServicesAccessible)(_.numberOfServicesAccessible(_))
        .ifSome(numberOfServicesNotAccessed)(_.numberOfServicesNotAccessed(_))
        .ifSome(accessDetails)(_.accessDetails(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .build

    def getPolicyRequest(
      policyArn: Option[String] = None
    ): GetPolicyRequest =
      GetPolicyRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def getPolicyResponse(
      policy: Option[Policy] = None
    ): GetPolicyResponse =
      GetPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getPolicyVersionRequest(
      policyArn: Option[String] = None,
      versionId: Option[String] = None
    ): GetPolicyVersionRequest =
      GetPolicyVersionRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def getPolicyVersionResponse(
      policyVersion: Option[PolicyVersion] = None
    ): GetPolicyVersionResponse =
      GetPolicyVersionResponse
        .builder
        .ifSome(policyVersion)(_.policyVersion(_))
        .build

    def getRolePolicyRequest(
      roleName: Option[String] = None,
      policyName: Option[String] = None
    ): GetRolePolicyRequest =
      GetRolePolicyRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def getRolePolicyResponse(
      roleName: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): GetRolePolicyResponse =
      GetRolePolicyResponse
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def getRoleRequest(
      roleName: Option[String] = None
    ): GetRoleRequest =
      GetRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .build

    def getRoleResponse(
      role: Option[Role] = None
    ): GetRoleResponse =
      GetRoleResponse
        .builder
        .ifSome(role)(_.role(_))
        .build

    def getSAMLProviderRequest(
      sAMLProviderArn: Option[String] = None
    ): GetSAMLProviderRequest =
      GetSAMLProviderRequest
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .build

    def getSAMLProviderResponse(
      sAMLMetadataDocument: Option[String] = None,
      createDate: Option[dateType] = None,
      validUntil: Option[dateType] = None,
      tags: Option[List[Tag]] = None
    ): GetSAMLProviderResponse =
      GetSAMLProviderResponse
        .builder
        .ifSome(sAMLMetadataDocument)(_.sAMLMetadataDocument(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getSSHPublicKeyRequest(
      userName: Option[String] = None,
      sSHPublicKeyId: Option[String] = None,
      encoding: Option[String] = None
    ): GetSSHPublicKeyRequest =
      GetSSHPublicKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(sSHPublicKeyId)(_.sSHPublicKeyId(_))
        .ifSome(encoding)(_.encoding(_))
        .build

    def getSSHPublicKeyResponse(
      sSHPublicKey: Option[SSHPublicKey] = None
    ): GetSSHPublicKeyResponse =
      GetSSHPublicKeyResponse
        .builder
        .ifSome(sSHPublicKey)(_.sSHPublicKey(_))
        .build

    def getServerCertificateRequest(
      serverCertificateName: Option[String] = None
    ): GetServerCertificateRequest =
      GetServerCertificateRequest
        .builder
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .build

    def getServerCertificateResponse(
      serverCertificate: Option[ServerCertificate] = None
    ): GetServerCertificateResponse =
      GetServerCertificateResponse
        .builder
        .ifSome(serverCertificate)(_.serverCertificate(_))
        .build

    def getServiceLastAccessedDetailsRequest(
      jobId: Option[String] = None,
      maxItems: Option[Int] = None,
      marker: Option[String] = None
    ): GetServiceLastAccessedDetailsRequest =
      GetServiceLastAccessedDetailsRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getServiceLastAccessedDetailsResponse(
      jobStatus: Option[String] = None,
      jobType: Option[String] = None,
      jobCreationDate: Option[dateType] = None,
      servicesLastAccessed: Option[List[ServiceLastAccessed]] = None,
      jobCompletionDate: Option[dateType] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None,
      error: Option[ErrorDetails] = None
    ): GetServiceLastAccessedDetailsResponse =
      GetServiceLastAccessedDetailsResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(jobCreationDate)(_.jobCreationDate(_))
        .ifSome(servicesLastAccessed)(_.servicesLastAccessed(_))
        .ifSome(jobCompletionDate)(_.jobCompletionDate(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(error)(_.error(_))
        .build

    def getServiceLastAccessedDetailsWithEntitiesRequest(
      jobId: Option[String] = None,
      serviceNamespace: Option[String] = None,
      maxItems: Option[Int] = None,
      marker: Option[String] = None
    ): GetServiceLastAccessedDetailsWithEntitiesRequest =
      GetServiceLastAccessedDetailsWithEntitiesRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .build

    def getServiceLastAccessedDetailsWithEntitiesResponse(
      jobStatus: Option[String] = None,
      jobCreationDate: Option[dateType] = None,
      jobCompletionDate: Option[dateType] = None,
      entityDetailsList: Option[List[EntityDetails]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None,
      error: Option[ErrorDetails] = None
    ): GetServiceLastAccessedDetailsWithEntitiesResponse =
      GetServiceLastAccessedDetailsWithEntitiesResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(jobCreationDate)(_.jobCreationDate(_))
        .ifSome(jobCompletionDate)(_.jobCompletionDate(_))
        .ifSome(entityDetailsList)(_.entityDetailsList(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(error)(_.error(_))
        .build

    def getServiceLinkedRoleDeletionStatusRequest(
      deletionTaskId: Option[String] = None
    ): GetServiceLinkedRoleDeletionStatusRequest =
      GetServiceLinkedRoleDeletionStatusRequest
        .builder
        .ifSome(deletionTaskId)(_.deletionTaskId(_))
        .build

    def getServiceLinkedRoleDeletionStatusResponse(
      status: Option[String] = None,
      reason: Option[DeletionTaskFailureReasonType] = None
    ): GetServiceLinkedRoleDeletionStatusResponse =
      GetServiceLinkedRoleDeletionStatusResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def getUserPolicyRequest(
      userName: Option[String] = None,
      policyName: Option[String] = None
    ): GetUserPolicyRequest =
      GetUserPolicyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def getUserPolicyResponse(
      userName: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): GetUserPolicyResponse =
      GetUserPolicyResponse
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def getUserRequest(
      userName: Option[String] = None
    ): GetUserRequest =
      GetUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .build

    def getUserResponse(
      user: Option[User] = None
    ): GetUserResponse =
      GetUserResponse
        .builder
        .ifSome(user)(_.user(_))
        .build

    def group(
      path: Option[String] = None,
      groupName: Option[String] = None,
      groupId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None
    ): Group =
      Group
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def groupDetail(
      path: Option[String] = None,
      groupName: Option[String] = None,
      groupId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None,
      groupPolicyList: Option[List[PolicyDetail]] = None,
      attachedManagedPolicies: Option[List[AttachedPolicy]] = None
    ): GroupDetail =
      GroupDetail
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(groupPolicyList)(_.groupPolicyList(_))
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .build

    def instanceProfile(
      path: Option[String] = None,
      instanceProfileName: Option[String] = None,
      instanceProfileId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None,
      roles: Option[List[Role]] = None,
      tags: Option[List[Tag]] = None
    ): InstanceProfile =
      InstanceProfile
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(instanceProfileId)(_.instanceProfileId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(roles)(_.roles(_))
        .ifSome(tags)(_.tags(_))
        .build

    def invalidAuthenticationCodeException(
      message: Option[String] = None
    ): InvalidAuthenticationCodeException =
      InvalidAuthenticationCodeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCertificateException(
      message: Option[String] = None
    ): InvalidCertificateException =
      InvalidCertificateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidPublicKeyException(
      message: Option[String] = None
    ): InvalidPublicKeyException =
      InvalidPublicKeyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidUserTypeException(
      message: Option[String] = None
    ): InvalidUserTypeException =
      InvalidUserTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyPairMismatchException(
      message: Option[String] = None
    ): KeyPairMismatchException =
      KeyPairMismatchException
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

    def listAccessKeysRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListAccessKeysRequest =
      ListAccessKeysRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listAccessKeysResponse(
      accessKeyMetadata: Option[List[AccessKeyMetadata]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListAccessKeysResponse =
      ListAccessKeysResponse
        .builder
        .ifSome(accessKeyMetadata)(_.accessKeyMetadata(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listAccountAliasesRequest(
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListAccountAliasesRequest =
      ListAccountAliasesRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listAccountAliasesResponse(
      accountAliases: Option[List[accountAliasType]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListAccountAliasesResponse =
      ListAccountAliasesResponse
        .builder
        .ifSome(accountAliases)(_.accountAliases(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listAttachedGroupPoliciesRequest(
      groupName: Option[String] = None,
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListAttachedGroupPoliciesRequest =
      ListAttachedGroupPoliciesRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listAttachedGroupPoliciesResponse(
      attachedPolicies: Option[List[AttachedPolicy]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListAttachedGroupPoliciesResponse =
      ListAttachedGroupPoliciesResponse
        .builder
        .ifSome(attachedPolicies)(_.attachedPolicies(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listAttachedRolePoliciesRequest(
      roleName: Option[String] = None,
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListAttachedRolePoliciesRequest =
      ListAttachedRolePoliciesRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listAttachedRolePoliciesResponse(
      attachedPolicies: Option[List[AttachedPolicy]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListAttachedRolePoliciesResponse =
      ListAttachedRolePoliciesResponse
        .builder
        .ifSome(attachedPolicies)(_.attachedPolicies(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listAttachedUserPoliciesRequest(
      userName: Option[String] = None,
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListAttachedUserPoliciesRequest =
      ListAttachedUserPoliciesRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listAttachedUserPoliciesResponse(
      attachedPolicies: Option[List[AttachedPolicy]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListAttachedUserPoliciesResponse =
      ListAttachedUserPoliciesResponse
        .builder
        .ifSome(attachedPolicies)(_.attachedPolicies(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listEntitiesForPolicyRequest(
      policyArn: Option[String] = None,
      entityFilter: Option[String] = None,
      pathPrefix: Option[String] = None,
      policyUsageFilter: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListEntitiesForPolicyRequest =
      ListEntitiesForPolicyRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(entityFilter)(_.entityFilter(_))
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(policyUsageFilter)(_.policyUsageFilter(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listEntitiesForPolicyResponse(
      policyGroups: Option[List[PolicyGroup]] = None,
      policyUsers: Option[List[PolicyUser]] = None,
      policyRoles: Option[List[PolicyRole]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListEntitiesForPolicyResponse =
      ListEntitiesForPolicyResponse
        .builder
        .ifSome(policyGroups)(_.policyGroups(_))
        .ifSome(policyUsers)(_.policyUsers(_))
        .ifSome(policyRoles)(_.policyRoles(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listGroupPoliciesRequest(
      groupName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListGroupPoliciesRequest =
      ListGroupPoliciesRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listGroupPoliciesResponse(
      policyNames: Option[List[policyNameType]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListGroupPoliciesResponse =
      ListGroupPoliciesResponse
        .builder
        .ifSome(policyNames)(_.policyNames(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listGroupsForUserRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListGroupsForUserRequest =
      ListGroupsForUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listGroupsForUserResponse(
      groups: Option[List[Group]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListGroupsForUserResponse =
      ListGroupsForUserResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listGroupsRequest(
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListGroupsRequest =
      ListGroupsRequest
        .builder
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listGroupsResponse(
      groups: Option[List[Group]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListGroupsResponse =
      ListGroupsResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceProfileTagsRequest(
      instanceProfileName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListInstanceProfileTagsRequest =
      ListInstanceProfileTagsRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listInstanceProfileTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListInstanceProfileTagsResponse =
      ListInstanceProfileTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceProfilesForRoleRequest(
      roleName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListInstanceProfilesForRoleRequest =
      ListInstanceProfilesForRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listInstanceProfilesForRoleResponse(
      instanceProfiles: Option[List[InstanceProfile]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListInstanceProfilesForRoleResponse =
      ListInstanceProfilesForRoleResponse
        .builder
        .ifSome(instanceProfiles)(_.instanceProfiles(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listInstanceProfilesRequest(
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListInstanceProfilesRequest =
      ListInstanceProfilesRequest
        .builder
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listInstanceProfilesResponse(
      instanceProfiles: Option[List[InstanceProfile]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListInstanceProfilesResponse =
      ListInstanceProfilesResponse
        .builder
        .ifSome(instanceProfiles)(_.instanceProfiles(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listMFADeviceTagsRequest(
      serialNumber: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListMFADeviceTagsRequest =
      ListMFADeviceTagsRequest
        .builder
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listMFADeviceTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListMFADeviceTagsResponse =
      ListMFADeviceTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listMFADevicesRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListMFADevicesRequest =
      ListMFADevicesRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listMFADevicesResponse(
      mFADevices: Option[List[MFADevice]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListMFADevicesResponse =
      ListMFADevicesResponse
        .builder
        .ifSome(mFADevices)(_.mFADevices(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listOpenIDConnectProviderTagsRequest(
      openIDConnectProviderArn: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListOpenIDConnectProviderTagsRequest =
      ListOpenIDConnectProviderTagsRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listOpenIDConnectProviderTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListOpenIDConnectProviderTagsResponse =
      ListOpenIDConnectProviderTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listOpenIDConnectProvidersRequest(

    ): ListOpenIDConnectProvidersRequest =
      ListOpenIDConnectProvidersRequest
        .builder

        .build

    def listOpenIDConnectProvidersResponse(
      openIDConnectProviderList: Option[List[OpenIDConnectProviderListEntry]] = None
    ): ListOpenIDConnectProvidersResponse =
      ListOpenIDConnectProvidersResponse
        .builder
        .ifSome(openIDConnectProviderList)(_.openIDConnectProviderList(_))
        .build

    def listPoliciesGrantingServiceAccessEntry(
      serviceNamespace: Option[String] = None,
      policies: Option[List[PolicyGrantingServiceAccess]] = None
    ): ListPoliciesGrantingServiceAccessEntry =
      ListPoliciesGrantingServiceAccessEntry
        .builder
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(policies)(_.policies(_))
        .build

    def listPoliciesGrantingServiceAccessRequest(
      marker: Option[String] = None,
      arn: Option[String] = None,
      serviceNamespaces: Option[List[serviceNamespaceType]] = None
    ): ListPoliciesGrantingServiceAccessRequest =
      ListPoliciesGrantingServiceAccessRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(serviceNamespaces)(_.serviceNamespaces(_))
        .build

    def listPoliciesGrantingServiceAccessResponse(
      policiesGrantingServiceAccess: Option[List[ListPoliciesGrantingServiceAccessEntry]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListPoliciesGrantingServiceAccessResponse =
      ListPoliciesGrantingServiceAccessResponse
        .builder
        .ifSome(policiesGrantingServiceAccess)(_.policiesGrantingServiceAccess(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listPoliciesRequest(
      scope: Option[String] = None,
      onlyAttached: Option[Boolean] = None,
      pathPrefix: Option[String] = None,
      policyUsageFilter: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListPoliciesRequest =
      ListPoliciesRequest
        .builder
        .ifSome(scope)(_.scope(_))
        .ifSome(onlyAttached)(_.onlyAttached(_))
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(policyUsageFilter)(_.policyUsageFilter(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listPoliciesResponse(
      policies: Option[List[Policy]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListPoliciesResponse =
      ListPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listPolicyTagsRequest(
      policyArn: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListPolicyTagsRequest =
      ListPolicyTagsRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listPolicyTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListPolicyTagsResponse =
      ListPolicyTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listPolicyVersionsRequest(
      policyArn: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListPolicyVersionsRequest =
      ListPolicyVersionsRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listPolicyVersionsResponse(
      versions: Option[List[PolicyVersion]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListPolicyVersionsResponse =
      ListPolicyVersionsResponse
        .builder
        .ifSome(versions)(_.versions(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listRolePoliciesRequest(
      roleName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListRolePoliciesRequest =
      ListRolePoliciesRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listRolePoliciesResponse(
      policyNames: Option[List[policyNameType]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListRolePoliciesResponse =
      ListRolePoliciesResponse
        .builder
        .ifSome(policyNames)(_.policyNames(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listRoleTagsRequest(
      roleName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListRoleTagsRequest =
      ListRoleTagsRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listRoleTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListRoleTagsResponse =
      ListRoleTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listRolesRequest(
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListRolesRequest =
      ListRolesRequest
        .builder
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listRolesResponse(
      roles: Option[List[Role]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListRolesResponse =
      ListRolesResponse
        .builder
        .ifSome(roles)(_.roles(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listSAMLProviderTagsRequest(
      sAMLProviderArn: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListSAMLProviderTagsRequest =
      ListSAMLProviderTagsRequest
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listSAMLProviderTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListSAMLProviderTagsResponse =
      ListSAMLProviderTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listSAMLProvidersRequest(

    ): ListSAMLProvidersRequest =
      ListSAMLProvidersRequest
        .builder

        .build

    def listSAMLProvidersResponse(
      sAMLProviderList: Option[List[SAMLProviderListEntry]] = None
    ): ListSAMLProvidersResponse =
      ListSAMLProvidersResponse
        .builder
        .ifSome(sAMLProviderList)(_.sAMLProviderList(_))
        .build

    def listSSHPublicKeysRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListSSHPublicKeysRequest =
      ListSSHPublicKeysRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listSSHPublicKeysResponse(
      sSHPublicKeys: Option[List[SSHPublicKeyMetadata]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListSSHPublicKeysResponse =
      ListSSHPublicKeysResponse
        .builder
        .ifSome(sSHPublicKeys)(_.sSHPublicKeys(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listServerCertificateTagsRequest(
      serverCertificateName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListServerCertificateTagsRequest =
      ListServerCertificateTagsRequest
        .builder
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listServerCertificateTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListServerCertificateTagsResponse =
      ListServerCertificateTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listServerCertificatesRequest(
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListServerCertificatesRequest =
      ListServerCertificatesRequest
        .builder
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listServerCertificatesResponse(
      serverCertificateMetadataList: Option[List[ServerCertificateMetadata]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListServerCertificatesResponse =
      ListServerCertificatesResponse
        .builder
        .ifSome(serverCertificateMetadataList)(_.serverCertificateMetadataList(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listServiceSpecificCredentialsRequest(
      userName: Option[String] = None,
      serviceName: Option[String] = None
    ): ListServiceSpecificCredentialsRequest =
      ListServiceSpecificCredentialsRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def listServiceSpecificCredentialsResponse(
      serviceSpecificCredentials: Option[List[ServiceSpecificCredentialMetadata]] = None
    ): ListServiceSpecificCredentialsResponse =
      ListServiceSpecificCredentialsResponse
        .builder
        .ifSome(serviceSpecificCredentials)(_.serviceSpecificCredentials(_))
        .build

    def listSigningCertificatesRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListSigningCertificatesRequest =
      ListSigningCertificatesRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listSigningCertificatesResponse(
      certificates: Option[List[SigningCertificate]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListSigningCertificatesResponse =
      ListSigningCertificatesResponse
        .builder
        .ifSome(certificates)(_.certificates(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listUserPoliciesRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListUserPoliciesRequest =
      ListUserPoliciesRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listUserPoliciesResponse(
      policyNames: Option[List[policyNameType]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListUserPoliciesResponse =
      ListUserPoliciesResponse
        .builder
        .ifSome(policyNames)(_.policyNames(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listUserTagsRequest(
      userName: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListUserTagsRequest =
      ListUserTagsRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listUserTagsResponse(
      tags: Option[List[Tag]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListUserTagsResponse =
      ListUserTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listUsersRequest(
      pathPrefix: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(pathPrefix)(_.pathPrefix(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listUsersResponse(
      users: Option[List[User]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(users)(_.users(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listVirtualMFADevicesRequest(
      assignmentStatus: Option[String] = None,
      marker: Option[String] = None,
      maxItems: Option[Int] = None
    ): ListVirtualMFADevicesRequest =
      ListVirtualMFADevicesRequest
        .builder
        .ifSome(assignmentStatus)(_.assignmentStatus(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def listVirtualMFADevicesResponse(
      virtualMFADevices: Option[List[VirtualMFADevice]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): ListVirtualMFADevicesResponse =
      ListVirtualMFADevicesResponse
        .builder
        .ifSome(virtualMFADevices)(_.virtualMFADevices(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def loginProfile(
      userName: Option[String] = None,
      createDate: Option[dateType] = None,
      passwordResetRequired: Option[Boolean] = None
    ): LoginProfile =
      LoginProfile
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(passwordResetRequired)(_.passwordResetRequired(_))
        .build

    def mFADevice(
      userName: Option[String] = None,
      serialNumber: Option[String] = None,
      enableDate: Option[dateType] = None
    ): MFADevice =
      MFADevice
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(enableDate)(_.enableDate(_))
        .build

    def malformedCertificateException(
      message: Option[String] = None
    ): MalformedCertificateException =
      MalformedCertificateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def malformedPolicyDocumentException(
      message: Option[String] = None
    ): MalformedPolicyDocumentException =
      MalformedPolicyDocumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def managedPolicyDetail(
      policyName: Option[String] = None,
      policyId: Option[String] = None,
      arn: Option[String] = None,
      path: Option[String] = None,
      defaultVersionId: Option[String] = None,
      attachmentCount: Option[Int] = None,
      permissionsBoundaryUsageCount: Option[Int] = None,
      isAttachable: Option[Boolean] = None,
      description: Option[String] = None,
      createDate: Option[dateType] = None,
      updateDate: Option[dateType] = None,
      policyVersionList: Option[List[PolicyVersion]] = None
    ): ManagedPolicyDetail =
      ManagedPolicyDetail
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(path)(_.path(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(attachmentCount)(_.attachmentCount(_))
        .ifSome(permissionsBoundaryUsageCount)(_.permissionsBoundaryUsageCount(_))
        .ifSome(isAttachable)(_.isAttachable(_))
        .ifSome(description)(_.description(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(policyVersionList)(_.policyVersionList(_))
        .build

    def noSuchEntityException(
      message: Option[String] = None
    ): NoSuchEntityException =
      NoSuchEntityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def openIDConnectProviderListEntry(
      arn: Option[String] = None
    ): OpenIDConnectProviderListEntry =
      OpenIDConnectProviderListEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def organizationsDecisionDetail(
      allowedByOrganizations: Option[Boolean] = None
    ): OrganizationsDecisionDetail =
      OrganizationsDecisionDetail
        .builder
        .ifSome(allowedByOrganizations)(_.allowedByOrganizations(_))
        .build

    def passwordPolicy(
      minimumPasswordLength: Option[Int] = None,
      requireSymbols: Option[Boolean] = None,
      requireNumbers: Option[Boolean] = None,
      requireUppercaseCharacters: Option[Boolean] = None,
      requireLowercaseCharacters: Option[Boolean] = None,
      allowUsersToChangePassword: Option[Boolean] = None,
      expirePasswords: Option[Boolean] = None,
      maxPasswordAge: Option[Int] = None,
      passwordReusePrevention: Option[Int] = None,
      hardExpiry: Option[Boolean] = None
    ): PasswordPolicy =
      PasswordPolicy
        .builder
        .ifSome(minimumPasswordLength)(_.minimumPasswordLength(_))
        .ifSome(requireSymbols)(_.requireSymbols(_))
        .ifSome(requireNumbers)(_.requireNumbers(_))
        .ifSome(requireUppercaseCharacters)(_.requireUppercaseCharacters(_))
        .ifSome(requireLowercaseCharacters)(_.requireLowercaseCharacters(_))
        .ifSome(allowUsersToChangePassword)(_.allowUsersToChangePassword(_))
        .ifSome(expirePasswords)(_.expirePasswords(_))
        .ifSome(maxPasswordAge)(_.maxPasswordAge(_))
        .ifSome(passwordReusePrevention)(_.passwordReusePrevention(_))
        .ifSome(hardExpiry)(_.hardExpiry(_))
        .build

    def passwordPolicyViolationException(
      message: Option[String] = None
    ): PasswordPolicyViolationException =
      PasswordPolicyViolationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def permissionsBoundaryDecisionDetail(
      allowedByPermissionsBoundary: Option[Boolean] = None
    ): PermissionsBoundaryDecisionDetail =
      PermissionsBoundaryDecisionDetail
        .builder
        .ifSome(allowedByPermissionsBoundary)(_.allowedByPermissionsBoundary(_))
        .build

    def policy(
      policyName: Option[String] = None,
      policyId: Option[String] = None,
      arn: Option[String] = None,
      path: Option[String] = None,
      defaultVersionId: Option[String] = None,
      attachmentCount: Option[Int] = None,
      permissionsBoundaryUsageCount: Option[Int] = None,
      isAttachable: Option[Boolean] = None,
      description: Option[String] = None,
      createDate: Option[dateType] = None,
      updateDate: Option[dateType] = None,
      tags: Option[List[Tag]] = None
    ): Policy =
      Policy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyId)(_.policyId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(path)(_.path(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(attachmentCount)(_.attachmentCount(_))
        .ifSome(permissionsBoundaryUsageCount)(_.permissionsBoundaryUsageCount(_))
        .ifSome(isAttachable)(_.isAttachable(_))
        .ifSome(description)(_.description(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(updateDate)(_.updateDate(_))
        .ifSome(tags)(_.tags(_))
        .build

    def policyDetail(
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): PolicyDetail =
      PolicyDetail
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def policyEvaluationException(
      message: Option[String] = None
    ): PolicyEvaluationException =
      PolicyEvaluationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyGrantingServiceAccess(
      policyName: Option[String] = None,
      policyType: Option[String] = None,
      policyArn: Option[String] = None,
      entityType: Option[String] = None,
      entityName: Option[String] = None
    ): PolicyGrantingServiceAccess =
      PolicyGrantingServiceAccess
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(entityType)(_.entityType(_))
        .ifSome(entityName)(_.entityName(_))
        .build

    def policyGroup(
      groupName: Option[String] = None,
      groupId: Option[String] = None
    ): PolicyGroup =
      PolicyGroup
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def policyNotAttachableException(
      message: Option[String] = None
    ): PolicyNotAttachableException =
      PolicyNotAttachableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyRole(
      roleName: Option[String] = None,
      roleId: Option[String] = None
    ): PolicyRole =
      PolicyRole
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(roleId)(_.roleId(_))
        .build

    def policyUser(
      userName: Option[String] = None,
      userId: Option[String] = None
    ): PolicyUser =
      PolicyUser
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(userId)(_.userId(_))
        .build

    def policyVersion(
      document: Option[String] = None,
      versionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None,
      createDate: Option[dateType] = None
    ): PolicyVersion =
      PolicyVersion
        .builder
        .ifSome(document)(_.document(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def position(
      line: Option[Int] = None,
      column: Option[Int] = None
    ): Position =
      Position
        .builder
        .ifSome(line)(_.line(_))
        .ifSome(column)(_.column(_))
        .build

    def putGroupPolicyRequest(
      groupName: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): PutGroupPolicyRequest =
      PutGroupPolicyRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def putRolePermissionsBoundaryRequest(
      roleName: Option[String] = None,
      permissionsBoundary: Option[String] = None
    ): PutRolePermissionsBoundaryRequest =
      PutRolePermissionsBoundaryRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .build

    def putRolePolicyRequest(
      roleName: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): PutRolePolicyRequest =
      PutRolePolicyRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def putUserPermissionsBoundaryRequest(
      userName: Option[String] = None,
      permissionsBoundary: Option[String] = None
    ): PutUserPermissionsBoundaryRequest =
      PutUserPermissionsBoundaryRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .build

    def putUserPolicyRequest(
      userName: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None
    ): PutUserPolicyRequest =
      PutUserPolicyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def removeClientIDFromOpenIDConnectProviderRequest(
      openIDConnectProviderArn: Option[String] = None,
      clientID: Option[String] = None
    ): RemoveClientIDFromOpenIDConnectProviderRequest =
      RemoveClientIDFromOpenIDConnectProviderRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(clientID)(_.clientID(_))
        .build

    def removeRoleFromInstanceProfileRequest(
      instanceProfileName: Option[String] = None,
      roleName: Option[String] = None
    ): RemoveRoleFromInstanceProfileRequest =
      RemoveRoleFromInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(roleName)(_.roleName(_))
        .build

    def removeUserFromGroupRequest(
      groupName: Option[String] = None,
      userName: Option[String] = None
    ): RemoveUserFromGroupRequest =
      RemoveUserFromGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(userName)(_.userName(_))
        .build

    def reportGenerationLimitExceededException(
      message: Option[String] = None
    ): ReportGenerationLimitExceededException =
      ReportGenerationLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resetServiceSpecificCredentialRequest(
      userName: Option[String] = None,
      serviceSpecificCredentialId: Option[String] = None
    ): ResetServiceSpecificCredentialRequest =
      ResetServiceSpecificCredentialRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serviceSpecificCredentialId)(_.serviceSpecificCredentialId(_))
        .build

    def resetServiceSpecificCredentialResponse(
      serviceSpecificCredential: Option[ServiceSpecificCredential] = None
    ): ResetServiceSpecificCredentialResponse =
      ResetServiceSpecificCredentialResponse
        .builder
        .ifSome(serviceSpecificCredential)(_.serviceSpecificCredential(_))
        .build

    def resyncMFADeviceRequest(
      userName: Option[String] = None,
      serialNumber: Option[String] = None,
      authenticationCode1: Option[String] = None,
      authenticationCode2: Option[String] = None
    ): ResyncMFADeviceRequest =
      ResyncMFADeviceRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(authenticationCode1)(_.authenticationCode1(_))
        .ifSome(authenticationCode2)(_.authenticationCode2(_))
        .build

    def role(
      path: Option[String] = None,
      roleName: Option[String] = None,
      roleId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None,
      assumeRolePolicyDocument: Option[String] = None,
      description: Option[String] = None,
      maxSessionDuration: Option[Int] = None,
      permissionsBoundary: Option[AttachedPermissionsBoundary] = None,
      tags: Option[List[Tag]] = None,
      roleLastUsed: Option[RoleLastUsed] = None
    ): Role =
      Role
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(roleId)(_.roleId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(assumeRolePolicyDocument)(_.assumeRolePolicyDocument(_))
        .ifSome(description)(_.description(_))
        .ifSome(maxSessionDuration)(_.maxSessionDuration(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(roleLastUsed)(_.roleLastUsed(_))
        .build

    def roleDetail(
      path: Option[String] = None,
      roleName: Option[String] = None,
      roleId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None,
      assumeRolePolicyDocument: Option[String] = None,
      instanceProfileList: Option[List[InstanceProfile]] = None,
      rolePolicyList: Option[List[PolicyDetail]] = None,
      attachedManagedPolicies: Option[List[AttachedPolicy]] = None,
      permissionsBoundary: Option[AttachedPermissionsBoundary] = None,
      tags: Option[List[Tag]] = None,
      roleLastUsed: Option[RoleLastUsed] = None
    ): RoleDetail =
      RoleDetail
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(roleId)(_.roleId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(assumeRolePolicyDocument)(_.assumeRolePolicyDocument(_))
        .ifSome(instanceProfileList)(_.instanceProfileList(_))
        .ifSome(rolePolicyList)(_.rolePolicyList(_))
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(roleLastUsed)(_.roleLastUsed(_))
        .build

    def roleLastUsed(
      lastUsedDate: Option[dateType] = None,
      region: Option[String] = None
    ): RoleLastUsed =
      RoleLastUsed
        .builder
        .ifSome(lastUsedDate)(_.lastUsedDate(_))
        .ifSome(region)(_.region(_))
        .build

    def roleUsageType(
      region: Option[String] = None,
      resources: Option[List[arnType]] = None
    ): RoleUsageType =
      RoleUsageType
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(resources)(_.resources(_))
        .build

    def sAMLProviderListEntry(
      arn: Option[String] = None,
      validUntil: Option[dateType] = None,
      createDate: Option[dateType] = None
    ): SAMLProviderListEntry =
      SAMLProviderListEntry
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(validUntil)(_.validUntil(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def sSHPublicKey(
      userName: Option[String] = None,
      sSHPublicKeyId: Option[String] = None,
      fingerprint: Option[String] = None,
      sSHPublicKeyBody: Option[String] = None,
      status: Option[String] = None,
      uploadDate: Option[dateType] = None
    ): SSHPublicKey =
      SSHPublicKey
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(sSHPublicKeyId)(_.sSHPublicKeyId(_))
        .ifSome(fingerprint)(_.fingerprint(_))
        .ifSome(sSHPublicKeyBody)(_.sSHPublicKeyBody(_))
        .ifSome(status)(_.status(_))
        .ifSome(uploadDate)(_.uploadDate(_))
        .build

    def sSHPublicKeyMetadata(
      userName: Option[String] = None,
      sSHPublicKeyId: Option[String] = None,
      status: Option[String] = None,
      uploadDate: Option[dateType] = None
    ): SSHPublicKeyMetadata =
      SSHPublicKeyMetadata
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(sSHPublicKeyId)(_.sSHPublicKeyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(uploadDate)(_.uploadDate(_))
        .build

    def serverCertificate(
      serverCertificateMetadata: Option[ServerCertificateMetadata] = None,
      certificateBody: Option[String] = None,
      certificateChain: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ServerCertificate =
      ServerCertificate
        .builder
        .ifSome(serverCertificateMetadata)(_.serverCertificateMetadata(_))
        .ifSome(certificateBody)(_.certificateBody(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(tags)(_.tags(_))
        .build

    def serverCertificateMetadata(
      path: Option[String] = None,
      serverCertificateName: Option[String] = None,
      serverCertificateId: Option[String] = None,
      arn: Option[String] = None,
      uploadDate: Option[dateType] = None,
      expiration: Option[dateType] = None
    ): ServerCertificateMetadata =
      ServerCertificateMetadata
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .ifSome(serverCertificateId)(_.serverCertificateId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(uploadDate)(_.uploadDate(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def serviceFailureException(
      message: Option[String] = None
    ): ServiceFailureException =
      ServiceFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceLastAccessed(
      serviceName: Option[String] = None,
      lastAuthenticated: Option[dateType] = None,
      serviceNamespace: Option[String] = None,
      lastAuthenticatedEntity: Option[String] = None,
      lastAuthenticatedRegion: Option[String] = None,
      totalAuthenticatedEntities: Option[Int] = None,
      trackedActionsLastAccessed: Option[List[TrackedActionLastAccessed]] = None
    ): ServiceLastAccessed =
      ServiceLastAccessed
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(lastAuthenticated)(_.lastAuthenticated(_))
        .ifSome(serviceNamespace)(_.serviceNamespace(_))
        .ifSome(lastAuthenticatedEntity)(_.lastAuthenticatedEntity(_))
        .ifSome(lastAuthenticatedRegion)(_.lastAuthenticatedRegion(_))
        .ifSome(totalAuthenticatedEntities)(_.totalAuthenticatedEntities(_))
        .ifSome(trackedActionsLastAccessed)(_.trackedActionsLastAccessed(_))
        .build

    def serviceNotSupportedException(
      message: Option[String] = None
    ): ServiceNotSupportedException =
      ServiceNotSupportedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceSpecificCredential(
      createDate: Option[dateType] = None,
      serviceName: Option[String] = None,
      serviceUserName: Option[String] = None,
      servicePassword: Option[String] = None,
      serviceSpecificCredentialId: Option[String] = None,
      userName: Option[String] = None,
      status: Option[String] = None
    ): ServiceSpecificCredential =
      ServiceSpecificCredential
        .builder
        .ifSome(createDate)(_.createDate(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceUserName)(_.serviceUserName(_))
        .ifSome(servicePassword)(_.servicePassword(_))
        .ifSome(serviceSpecificCredentialId)(_.serviceSpecificCredentialId(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(status)(_.status(_))
        .build

    def serviceSpecificCredentialMetadata(
      userName: Option[String] = None,
      status: Option[String] = None,
      serviceUserName: Option[String] = None,
      createDate: Option[dateType] = None,
      serviceSpecificCredentialId: Option[String] = None,
      serviceName: Option[String] = None
    ): ServiceSpecificCredentialMetadata =
      ServiceSpecificCredentialMetadata
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(status)(_.status(_))
        .ifSome(serviceUserName)(_.serviceUserName(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(serviceSpecificCredentialId)(_.serviceSpecificCredentialId(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def setDefaultPolicyVersionRequest(
      policyArn: Option[String] = None,
      versionId: Option[String] = None
    ): SetDefaultPolicyVersionRequest =
      SetDefaultPolicyVersionRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def setSecurityTokenServicePreferencesRequest(
      globalEndpointTokenVersion: Option[String] = None
    ): SetSecurityTokenServicePreferencesRequest =
      SetSecurityTokenServicePreferencesRequest
        .builder
        .ifSome(globalEndpointTokenVersion)(_.globalEndpointTokenVersion(_))
        .build

    def signingCertificate(
      userName: Option[String] = None,
      certificateId: Option[String] = None,
      certificateBody: Option[String] = None,
      status: Option[String] = None,
      uploadDate: Option[dateType] = None
    ): SigningCertificate =
      SigningCertificate
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(certificateBody)(_.certificateBody(_))
        .ifSome(status)(_.status(_))
        .ifSome(uploadDate)(_.uploadDate(_))
        .build

    def simulateCustomPolicyRequest(
      policyInputList: Option[List[policyDocumentType]] = None,
      permissionsBoundaryPolicyInputList: Option[List[policyDocumentType]] = None,
      actionNames: Option[List[ActionNameType]] = None,
      resourceArns: Option[List[ResourceNameType]] = None,
      resourcePolicy: Option[String] = None,
      resourceOwner: Option[String] = None,
      callerArn: Option[String] = None,
      contextEntries: Option[List[ContextEntry]] = None,
      resourceHandlingOption: Option[String] = None,
      maxItems: Option[Int] = None,
      marker: Option[String] = None
    ): SimulateCustomPolicyRequest =
      SimulateCustomPolicyRequest
        .builder
        .ifSome(policyInputList)(_.policyInputList(_))
        .ifSome(permissionsBoundaryPolicyInputList)(_.permissionsBoundaryPolicyInputList(_))
        .ifSome(actionNames)(_.actionNames(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(callerArn)(_.callerArn(_))
        .ifSome(contextEntries)(_.contextEntries(_))
        .ifSome(resourceHandlingOption)(_.resourceHandlingOption(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .build

    def simulatePolicyResponse(
      evaluationResults: Option[List[EvaluationResult]] = None,
      isTruncated: Option[Boolean] = None,
      marker: Option[String] = None
    ): SimulatePolicyResponse =
      SimulatePolicyResponse
        .builder
        .ifSome(evaluationResults)(_.evaluationResults(_))
        .ifSome(isTruncated)(_.isTruncated(_))
        .ifSome(marker)(_.marker(_))
        .build

    def simulatePrincipalPolicyRequest(
      policySourceArn: Option[String] = None,
      policyInputList: Option[List[policyDocumentType]] = None,
      permissionsBoundaryPolicyInputList: Option[List[policyDocumentType]] = None,
      actionNames: Option[List[ActionNameType]] = None,
      resourceArns: Option[List[ResourceNameType]] = None,
      resourcePolicy: Option[String] = None,
      resourceOwner: Option[String] = None,
      callerArn: Option[String] = None,
      contextEntries: Option[List[ContextEntry]] = None,
      resourceHandlingOption: Option[String] = None,
      maxItems: Option[Int] = None,
      marker: Option[String] = None
    ): SimulatePrincipalPolicyRequest =
      SimulatePrincipalPolicyRequest
        .builder
        .ifSome(policySourceArn)(_.policySourceArn(_))
        .ifSome(policyInputList)(_.policyInputList(_))
        .ifSome(permissionsBoundaryPolicyInputList)(_.permissionsBoundaryPolicyInputList(_))
        .ifSome(actionNames)(_.actionNames(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(callerArn)(_.callerArn(_))
        .ifSome(contextEntries)(_.contextEntries(_))
        .ifSome(resourceHandlingOption)(_.resourceHandlingOption(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(marker)(_.marker(_))
        .build

    def statement(
      sourcePolicyId: Option[String] = None,
      sourcePolicyType: Option[String] = None,
      startPosition: Option[Position] = None,
      endPosition: Option[Position] = None
    ): Statement =
      Statement
        .builder
        .ifSome(sourcePolicyId)(_.sourcePolicyId(_))
        .ifSome(sourcePolicyType)(_.sourcePolicyType(_))
        .ifSome(startPosition)(_.startPosition(_))
        .ifSome(endPosition)(_.endPosition(_))
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

    def tagInstanceProfileRequest(
      instanceProfileName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagInstanceProfileRequest =
      TagInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagMFADeviceRequest(
      serialNumber: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagMFADeviceRequest =
      TagMFADeviceRequest
        .builder
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagOpenIDConnectProviderRequest(
      openIDConnectProviderArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagOpenIDConnectProviderRequest =
      TagOpenIDConnectProviderRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagPolicyRequest(
      policyArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagPolicyRequest =
      TagPolicyRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagRoleRequest(
      roleName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagRoleRequest =
      TagRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagSAMLProviderRequest(
      sAMLProviderArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagSAMLProviderRequest =
      TagSAMLProviderRequest
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagServerCertificateRequest(
      serverCertificateName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagServerCertificateRequest =
      TagServerCertificateRequest
        .builder
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagUserRequest(
      userName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagUserRequest =
      TagUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def trackedActionLastAccessed(
      actionName: Option[String] = None,
      lastAccessedEntity: Option[String] = None,
      lastAccessedTime: Option[dateType] = None,
      lastAccessedRegion: Option[String] = None
    ): TrackedActionLastAccessed =
      TrackedActionLastAccessed
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(lastAccessedEntity)(_.lastAccessedEntity(_))
        .ifSome(lastAccessedTime)(_.lastAccessedTime(_))
        .ifSome(lastAccessedRegion)(_.lastAccessedRegion(_))
        .build

    def unmodifiableEntityException(
      message: Option[String] = None
    ): UnmodifiableEntityException =
      UnmodifiableEntityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unrecognizedPublicKeyEncodingException(
      message: Option[String] = None
    ): UnrecognizedPublicKeyEncodingException =
      UnrecognizedPublicKeyEncodingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagInstanceProfileRequest(
      instanceProfileName: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagInstanceProfileRequest =
      UntagInstanceProfileRequest
        .builder
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagMFADeviceRequest(
      serialNumber: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagMFADeviceRequest =
      UntagMFADeviceRequest
        .builder
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagOpenIDConnectProviderRequest(
      openIDConnectProviderArn: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagOpenIDConnectProviderRequest =
      UntagOpenIDConnectProviderRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagPolicyRequest(
      policyArn: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagPolicyRequest =
      UntagPolicyRequest
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagRoleRequest(
      roleName: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagRoleRequest =
      UntagRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagSAMLProviderRequest(
      sAMLProviderArn: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagSAMLProviderRequest =
      UntagSAMLProviderRequest
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagServerCertificateRequest(
      serverCertificateName: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagServerCertificateRequest =
      UntagServerCertificateRequest
        .builder
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagUserRequest(
      userName: Option[String] = None,
      tagKeys: Option[List[tagKeyType]] = None
    ): UntagUserRequest =
      UntagUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAccessKeyRequest(
      userName: Option[String] = None,
      accessKeyId: Option[String] = None,
      status: Option[String] = None
    ): UpdateAccessKeyRequest =
      UpdateAccessKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAccountPasswordPolicyRequest(
      minimumPasswordLength: Option[Int] = None,
      requireSymbols: Option[Boolean] = None,
      requireNumbers: Option[Boolean] = None,
      requireUppercaseCharacters: Option[Boolean] = None,
      requireLowercaseCharacters: Option[Boolean] = None,
      allowUsersToChangePassword: Option[Boolean] = None,
      maxPasswordAge: Option[Int] = None,
      passwordReusePrevention: Option[Int] = None,
      hardExpiry: Option[Boolean] = None
    ): UpdateAccountPasswordPolicyRequest =
      UpdateAccountPasswordPolicyRequest
        .builder
        .ifSome(minimumPasswordLength)(_.minimumPasswordLength(_))
        .ifSome(requireSymbols)(_.requireSymbols(_))
        .ifSome(requireNumbers)(_.requireNumbers(_))
        .ifSome(requireUppercaseCharacters)(_.requireUppercaseCharacters(_))
        .ifSome(requireLowercaseCharacters)(_.requireLowercaseCharacters(_))
        .ifSome(allowUsersToChangePassword)(_.allowUsersToChangePassword(_))
        .ifSome(maxPasswordAge)(_.maxPasswordAge(_))
        .ifSome(passwordReusePrevention)(_.passwordReusePrevention(_))
        .ifSome(hardExpiry)(_.hardExpiry(_))
        .build

    def updateAssumeRolePolicyRequest(
      roleName: Option[String] = None,
      policyDocument: Option[String] = None
    ): UpdateAssumeRolePolicyRequest =
      UpdateAssumeRolePolicyRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def updateGroupRequest(
      groupName: Option[String] = None,
      newPath: Option[String] = None,
      newGroupName: Option[String] = None
    ): UpdateGroupRequest =
      UpdateGroupRequest
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(newPath)(_.newPath(_))
        .ifSome(newGroupName)(_.newGroupName(_))
        .build

    def updateLoginProfileRequest(
      userName: Option[String] = None,
      password: Option[String] = None,
      passwordResetRequired: Option[Boolean] = None
    ): UpdateLoginProfileRequest =
      UpdateLoginProfileRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .ifSome(passwordResetRequired)(_.passwordResetRequired(_))
        .build

    def updateOpenIDConnectProviderThumbprintRequest(
      openIDConnectProviderArn: Option[String] = None,
      thumbprintList: Option[List[thumbprintType]] = None
    ): UpdateOpenIDConnectProviderThumbprintRequest =
      UpdateOpenIDConnectProviderThumbprintRequest
        .builder
        .ifSome(openIDConnectProviderArn)(_.openIDConnectProviderArn(_))
        .ifSome(thumbprintList)(_.thumbprintList(_))
        .build

    def updateRoleDescriptionRequest(
      roleName: Option[String] = None,
      description: Option[String] = None
    ): UpdateRoleDescriptionRequest =
      UpdateRoleDescriptionRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(description)(_.description(_))
        .build

    def updateRoleDescriptionResponse(
      role: Option[Role] = None
    ): UpdateRoleDescriptionResponse =
      UpdateRoleDescriptionResponse
        .builder
        .ifSome(role)(_.role(_))
        .build

    def updateRoleRequest(
      roleName: Option[String] = None,
      description: Option[String] = None,
      maxSessionDuration: Option[Int] = None
    ): UpdateRoleRequest =
      UpdateRoleRequest
        .builder
        .ifSome(roleName)(_.roleName(_))
        .ifSome(description)(_.description(_))
        .ifSome(maxSessionDuration)(_.maxSessionDuration(_))
        .build

    def updateRoleResponse(

    ): UpdateRoleResponse =
      UpdateRoleResponse
        .builder

        .build

    def updateSAMLProviderRequest(
      sAMLMetadataDocument: Option[String] = None,
      sAMLProviderArn: Option[String] = None
    ): UpdateSAMLProviderRequest =
      UpdateSAMLProviderRequest
        .builder
        .ifSome(sAMLMetadataDocument)(_.sAMLMetadataDocument(_))
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .build

    def updateSAMLProviderResponse(
      sAMLProviderArn: Option[String] = None
    ): UpdateSAMLProviderResponse =
      UpdateSAMLProviderResponse
        .builder
        .ifSome(sAMLProviderArn)(_.sAMLProviderArn(_))
        .build

    def updateSSHPublicKeyRequest(
      userName: Option[String] = None,
      sSHPublicKeyId: Option[String] = None,
      status: Option[String] = None
    ): UpdateSSHPublicKeyRequest =
      UpdateSSHPublicKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(sSHPublicKeyId)(_.sSHPublicKeyId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateServerCertificateRequest(
      serverCertificateName: Option[String] = None,
      newPath: Option[String] = None,
      newServerCertificateName: Option[String] = None
    ): UpdateServerCertificateRequest =
      UpdateServerCertificateRequest
        .builder
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .ifSome(newPath)(_.newPath(_))
        .ifSome(newServerCertificateName)(_.newServerCertificateName(_))
        .build

    def updateServiceSpecificCredentialRequest(
      userName: Option[String] = None,
      serviceSpecificCredentialId: Option[String] = None,
      status: Option[String] = None
    ): UpdateServiceSpecificCredentialRequest =
      UpdateServiceSpecificCredentialRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(serviceSpecificCredentialId)(_.serviceSpecificCredentialId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateSigningCertificateRequest(
      userName: Option[String] = None,
      certificateId: Option[String] = None,
      status: Option[String] = None
    ): UpdateSigningCertificateRequest =
      UpdateSigningCertificateRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(status)(_.status(_))
        .build

    def updateUserRequest(
      userName: Option[String] = None,
      newPath: Option[String] = None,
      newUserName: Option[String] = None
    ): UpdateUserRequest =
      UpdateUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(newPath)(_.newPath(_))
        .ifSome(newUserName)(_.newUserName(_))
        .build

    def uploadSSHPublicKeyRequest(
      userName: Option[String] = None,
      sSHPublicKeyBody: Option[String] = None
    ): UploadSSHPublicKeyRequest =
      UploadSSHPublicKeyRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(sSHPublicKeyBody)(_.sSHPublicKeyBody(_))
        .build

    def uploadSSHPublicKeyResponse(
      sSHPublicKey: Option[SSHPublicKey] = None
    ): UploadSSHPublicKeyResponse =
      UploadSSHPublicKeyResponse
        .builder
        .ifSome(sSHPublicKey)(_.sSHPublicKey(_))
        .build

    def uploadServerCertificateRequest(
      path: Option[String] = None,
      serverCertificateName: Option[String] = None,
      certificateBody: Option[String] = None,
      privateKey: Option[String] = None,
      certificateChain: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): UploadServerCertificateRequest =
      UploadServerCertificateRequest
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(serverCertificateName)(_.serverCertificateName(_))
        .ifSome(certificateBody)(_.certificateBody(_))
        .ifSome(privateKey)(_.privateKey(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(tags)(_.tags(_))
        .build

    def uploadServerCertificateResponse(
      serverCertificateMetadata: Option[ServerCertificateMetadata] = None,
      tags: Option[List[Tag]] = None
    ): UploadServerCertificateResponse =
      UploadServerCertificateResponse
        .builder
        .ifSome(serverCertificateMetadata)(_.serverCertificateMetadata(_))
        .ifSome(tags)(_.tags(_))
        .build

    def uploadSigningCertificateRequest(
      userName: Option[String] = None,
      certificateBody: Option[String] = None
    ): UploadSigningCertificateRequest =
      UploadSigningCertificateRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(certificateBody)(_.certificateBody(_))
        .build

    def uploadSigningCertificateResponse(
      certificate: Option[SigningCertificate] = None
    ): UploadSigningCertificateResponse =
      UploadSigningCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .build

    def user(
      path: Option[String] = None,
      userName: Option[String] = None,
      userId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None,
      passwordLastUsed: Option[dateType] = None,
      permissionsBoundary: Option[AttachedPermissionsBoundary] = None,
      tags: Option[List[Tag]] = None
    ): User =
      User
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(passwordLastUsed)(_.passwordLastUsed(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(tags)(_.tags(_))
        .build

    def userDetail(
      path: Option[String] = None,
      userName: Option[String] = None,
      userId: Option[String] = None,
      arn: Option[String] = None,
      createDate: Option[dateType] = None,
      userPolicyList: Option[List[PolicyDetail]] = None,
      groupList: Option[List[groupNameType]] = None,
      attachedManagedPolicies: Option[List[AttachedPolicy]] = None,
      permissionsBoundary: Option[AttachedPermissionsBoundary] = None,
      tags: Option[List[Tag]] = None
    ): UserDetail =
      UserDetail
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createDate)(_.createDate(_))
        .ifSome(userPolicyList)(_.userPolicyList(_))
        .ifSome(groupList)(_.groupList(_))
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .ifSome(permissionsBoundary)(_.permissionsBoundary(_))
        .ifSome(tags)(_.tags(_))
        .build

    def virtualMFADevice(
      serialNumber: Option[String] = None,
      base32StringSeed: Option[BootstrapDatum] = None,
      qRCodePNG: Option[BootstrapDatum] = None,
      user: Option[User] = None,
      enableDate: Option[dateType] = None,
      tags: Option[List[Tag]] = None
    ): VirtualMFADevice =
      VirtualMFADevice
        .builder
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(base32StringSeed)(_.base32StringSeed(_))
        .ifSome(qRCodePNG)(_.qRCodePNG(_))
        .ifSome(user)(_.user(_))
        .ifSome(enableDate)(_.enableDate(_))
        .ifSome(tags)(_.tags(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
