package goober.hi

import goober.free.ssoadmin.SsoAdminIO
import software.amazon.awssdk.services.ssoadmin.model._


object ssoadmin {
  import goober.free.{ssoadmin ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessControlAttribute(
      key: Option[String] = None,
      value: Option[AccessControlAttributeValue] = None
    ): AccessControlAttribute =
      AccessControlAttribute
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def accessControlAttributeValue(
      source: Option[List[AccessControlAttributeValueSource]] = None
    ): AccessControlAttributeValue =
      AccessControlAttributeValue
        .builder
        .ifSome(source)(_.source(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountAssignment(
      accountId: Option[String] = None,
      permissionSetArn: Option[String] = None,
      principalType: Option[String] = None,
      principalId: Option[String] = None
    ): AccountAssignment =
      AccountAssignment
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(principalType)(_.principalType(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def accountAssignmentOperationStatus(
      status: Option[String] = None,
      requestId: Option[String] = None,
      failureReason: Option[String] = None,
      targetId: Option[String] = None,
      targetType: Option[String] = None,
      permissionSetArn: Option[String] = None,
      principalType: Option[String] = None,
      principalId: Option[String] = None,
      createdDate: Option[Date] = None
    ): AccountAssignmentOperationStatus =
      AccountAssignmentOperationStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(principalType)(_.principalType(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def accountAssignmentOperationStatusMetadata(
      status: Option[String] = None,
      requestId: Option[String] = None,
      createdDate: Option[Date] = None
    ): AccountAssignmentOperationStatusMetadata =
      AccountAssignmentOperationStatusMetadata
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def attachManagedPolicyToPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      managedPolicyArn: Option[String] = None
    ): AttachManagedPolicyToPermissionSetRequest =
      AttachManagedPolicyToPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(managedPolicyArn)(_.managedPolicyArn(_))
        .build

    def attachManagedPolicyToPermissionSetResponse(

    ): AttachManagedPolicyToPermissionSetResponse =
      AttachManagedPolicyToPermissionSetResponse
        .builder

        .build

    def attachedManagedPolicy(
      name: Option[String] = None,
      arn: Option[String] = None
    ): AttachedManagedPolicy =
      AttachedManagedPolicy
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createAccountAssignmentRequest(
      instanceArn: Option[String] = None,
      targetId: Option[String] = None,
      targetType: Option[String] = None,
      permissionSetArn: Option[String] = None,
      principalType: Option[String] = None,
      principalId: Option[String] = None
    ): CreateAccountAssignmentRequest =
      CreateAccountAssignmentRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(principalType)(_.principalType(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def createAccountAssignmentResponse(
      accountAssignmentCreationStatus: Option[AccountAssignmentOperationStatus] = None
    ): CreateAccountAssignmentResponse =
      CreateAccountAssignmentResponse
        .builder
        .ifSome(accountAssignmentCreationStatus)(_.accountAssignmentCreationStatus(_))
        .build

    def createInstanceAccessControlAttributeConfigurationRequest(
      instanceArn: Option[String] = None,
      instanceAccessControlAttributeConfiguration: Option[InstanceAccessControlAttributeConfiguration] = None
    ): CreateInstanceAccessControlAttributeConfigurationRequest =
      CreateInstanceAccessControlAttributeConfigurationRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(instanceAccessControlAttributeConfiguration)(_.instanceAccessControlAttributeConfiguration(_))
        .build

    def createInstanceAccessControlAttributeConfigurationResponse(

    ): CreateInstanceAccessControlAttributeConfigurationResponse =
      CreateInstanceAccessControlAttributeConfigurationResponse
        .builder

        .build

    def createPermissionSetRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      instanceArn: Option[String] = None,
      sessionDuration: Option[String] = None,
      relayState: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePermissionSetRequest =
      CreatePermissionSetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(sessionDuration)(_.sessionDuration(_))
        .ifSome(relayState)(_.relayState(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPermissionSetResponse(
      permissionSet: Option[PermissionSet] = None
    ): CreatePermissionSetResponse =
      CreatePermissionSetResponse
        .builder
        .ifSome(permissionSet)(_.permissionSet(_))
        .build

    def deleteAccountAssignmentRequest(
      instanceArn: Option[String] = None,
      targetId: Option[String] = None,
      targetType: Option[String] = None,
      permissionSetArn: Option[String] = None,
      principalType: Option[String] = None,
      principalId: Option[String] = None
    ): DeleteAccountAssignmentRequest =
      DeleteAccountAssignmentRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetType)(_.targetType(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(principalType)(_.principalType(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def deleteAccountAssignmentResponse(
      accountAssignmentDeletionStatus: Option[AccountAssignmentOperationStatus] = None
    ): DeleteAccountAssignmentResponse =
      DeleteAccountAssignmentResponse
        .builder
        .ifSome(accountAssignmentDeletionStatus)(_.accountAssignmentDeletionStatus(_))
        .build

    def deleteInlinePolicyFromPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None
    ): DeleteInlinePolicyFromPermissionSetRequest =
      DeleteInlinePolicyFromPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .build

    def deleteInlinePolicyFromPermissionSetResponse(

    ): DeleteInlinePolicyFromPermissionSetResponse =
      DeleteInlinePolicyFromPermissionSetResponse
        .builder

        .build

    def deleteInstanceAccessControlAttributeConfigurationRequest(
      instanceArn: Option[String] = None
    ): DeleteInstanceAccessControlAttributeConfigurationRequest =
      DeleteInstanceAccessControlAttributeConfigurationRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .build

    def deleteInstanceAccessControlAttributeConfigurationResponse(

    ): DeleteInstanceAccessControlAttributeConfigurationResponse =
      DeleteInstanceAccessControlAttributeConfigurationResponse
        .builder

        .build

    def deletePermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None
    ): DeletePermissionSetRequest =
      DeletePermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .build

    def deletePermissionSetResponse(

    ): DeletePermissionSetResponse =
      DeletePermissionSetResponse
        .builder

        .build

    def describeAccountAssignmentCreationStatusRequest(
      instanceArn: Option[String] = None,
      accountAssignmentCreationRequestId: Option[String] = None
    ): DescribeAccountAssignmentCreationStatusRequest =
      DescribeAccountAssignmentCreationStatusRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(accountAssignmentCreationRequestId)(_.accountAssignmentCreationRequestId(_))
        .build

    def describeAccountAssignmentCreationStatusResponse(
      accountAssignmentCreationStatus: Option[AccountAssignmentOperationStatus] = None
    ): DescribeAccountAssignmentCreationStatusResponse =
      DescribeAccountAssignmentCreationStatusResponse
        .builder
        .ifSome(accountAssignmentCreationStatus)(_.accountAssignmentCreationStatus(_))
        .build

    def describeAccountAssignmentDeletionStatusRequest(
      instanceArn: Option[String] = None,
      accountAssignmentDeletionRequestId: Option[String] = None
    ): DescribeAccountAssignmentDeletionStatusRequest =
      DescribeAccountAssignmentDeletionStatusRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(accountAssignmentDeletionRequestId)(_.accountAssignmentDeletionRequestId(_))
        .build

    def describeAccountAssignmentDeletionStatusResponse(
      accountAssignmentDeletionStatus: Option[AccountAssignmentOperationStatus] = None
    ): DescribeAccountAssignmentDeletionStatusResponse =
      DescribeAccountAssignmentDeletionStatusResponse
        .builder
        .ifSome(accountAssignmentDeletionStatus)(_.accountAssignmentDeletionStatus(_))
        .build

    def describeInstanceAccessControlAttributeConfigurationRequest(
      instanceArn: Option[String] = None
    ): DescribeInstanceAccessControlAttributeConfigurationRequest =
      DescribeInstanceAccessControlAttributeConfigurationRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .build

    def describeInstanceAccessControlAttributeConfigurationResponse(
      status: Option[String] = None,
      statusReason: Option[String] = None,
      instanceAccessControlAttributeConfiguration: Option[InstanceAccessControlAttributeConfiguration] = None
    ): DescribeInstanceAccessControlAttributeConfigurationResponse =
      DescribeInstanceAccessControlAttributeConfigurationResponse
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(instanceAccessControlAttributeConfiguration)(_.instanceAccessControlAttributeConfiguration(_))
        .build

    def describePermissionSetProvisioningStatusRequest(
      instanceArn: Option[String] = None,
      provisionPermissionSetRequestId: Option[String] = None
    ): DescribePermissionSetProvisioningStatusRequest =
      DescribePermissionSetProvisioningStatusRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(provisionPermissionSetRequestId)(_.provisionPermissionSetRequestId(_))
        .build

    def describePermissionSetProvisioningStatusResponse(
      permissionSetProvisioningStatus: Option[PermissionSetProvisioningStatus] = None
    ): DescribePermissionSetProvisioningStatusResponse =
      DescribePermissionSetProvisioningStatusResponse
        .builder
        .ifSome(permissionSetProvisioningStatus)(_.permissionSetProvisioningStatus(_))
        .build

    def describePermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None
    ): DescribePermissionSetRequest =
      DescribePermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .build

    def describePermissionSetResponse(
      permissionSet: Option[PermissionSet] = None
    ): DescribePermissionSetResponse =
      DescribePermissionSetResponse
        .builder
        .ifSome(permissionSet)(_.permissionSet(_))
        .build

    def detachManagedPolicyFromPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      managedPolicyArn: Option[String] = None
    ): DetachManagedPolicyFromPermissionSetRequest =
      DetachManagedPolicyFromPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(managedPolicyArn)(_.managedPolicyArn(_))
        .build

    def detachManagedPolicyFromPermissionSetResponse(

    ): DetachManagedPolicyFromPermissionSetResponse =
      DetachManagedPolicyFromPermissionSetResponse
        .builder

        .build

    def getInlinePolicyForPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None
    ): GetInlinePolicyForPermissionSetRequest =
      GetInlinePolicyForPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .build

    def getInlinePolicyForPermissionSetResponse(
      inlinePolicy: Option[String] = None
    ): GetInlinePolicyForPermissionSetResponse =
      GetInlinePolicyForPermissionSetResponse
        .builder
        .ifSome(inlinePolicy)(_.inlinePolicy(_))
        .build

    def instanceAccessControlAttributeConfiguration(
      accessControlAttributes: Option[List[AccessControlAttribute]] = None
    ): InstanceAccessControlAttributeConfiguration =
      InstanceAccessControlAttributeConfiguration
        .builder
        .ifSome(accessControlAttributes)(_.accessControlAttributes(_))
        .build

    def instanceMetadata(
      instanceArn: Option[String] = None,
      identityStoreId: Option[String] = None
    ): InstanceMetadata =
      InstanceMetadata
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAccountAssignmentCreationStatusRequest(
      instanceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filter: Option[OperationStatusFilter] = None
    ): ListAccountAssignmentCreationStatusRequest =
      ListAccountAssignmentCreationStatusRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listAccountAssignmentCreationStatusResponse(
      accountAssignmentsCreationStatus: Option[List[AccountAssignmentOperationStatusMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAccountAssignmentCreationStatusResponse =
      ListAccountAssignmentCreationStatusResponse
        .builder
        .ifSome(accountAssignmentsCreationStatus)(_.accountAssignmentsCreationStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountAssignmentDeletionStatusRequest(
      instanceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filter: Option[OperationStatusFilter] = None
    ): ListAccountAssignmentDeletionStatusRequest =
      ListAccountAssignmentDeletionStatusRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listAccountAssignmentDeletionStatusResponse(
      accountAssignmentsDeletionStatus: Option[List[AccountAssignmentOperationStatusMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAccountAssignmentDeletionStatusResponse =
      ListAccountAssignmentDeletionStatusResponse
        .builder
        .ifSome(accountAssignmentsDeletionStatus)(_.accountAssignmentsDeletionStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountAssignmentsRequest(
      instanceArn: Option[String] = None,
      accountId: Option[String] = None,
      permissionSetArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAccountAssignmentsRequest =
      ListAccountAssignmentsRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountAssignmentsResponse(
      accountAssignments: Option[List[AccountAssignment]] = None,
      nextToken: Option[String] = None
    ): ListAccountAssignmentsResponse =
      ListAccountAssignmentsResponse
        .builder
        .ifSome(accountAssignments)(_.accountAssignments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountsForProvisionedPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      provisioningStatus: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAccountsForProvisionedPermissionSetRequest =
      ListAccountsForProvisionedPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(provisioningStatus)(_.provisioningStatus(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountsForProvisionedPermissionSetResponse(
      accountIds: Option[List[AccountId]] = None,
      nextToken: Option[String] = None
    ): ListAccountsForProvisionedPermissionSetResponse =
      ListAccountsForProvisionedPermissionSetResponse
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstancesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInstancesRequest =
      ListInstancesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInstancesResponse(
      instances: Option[List[InstanceMetadata]] = None,
      nextToken: Option[String] = None
    ): ListInstancesResponse =
      ListInstancesResponse
        .builder
        .ifSome(instances)(_.instances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listManagedPoliciesInPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListManagedPoliciesInPermissionSetRequest =
      ListManagedPoliciesInPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listManagedPoliciesInPermissionSetResponse(
      attachedManagedPolicies: Option[List[AttachedManagedPolicy]] = None,
      nextToken: Option[String] = None
    ): ListManagedPoliciesInPermissionSetResponse =
      ListManagedPoliciesInPermissionSetResponse
        .builder
        .ifSome(attachedManagedPolicies)(_.attachedManagedPolicies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPermissionSetProvisioningStatusRequest(
      instanceArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filter: Option[OperationStatusFilter] = None
    ): ListPermissionSetProvisioningStatusRequest =
      ListPermissionSetProvisioningStatusRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listPermissionSetProvisioningStatusResponse(
      permissionSetsProvisioningStatus: Option[List[PermissionSetProvisioningStatusMetadata]] = None,
      nextToken: Option[String] = None
    ): ListPermissionSetProvisioningStatusResponse =
      ListPermissionSetProvisioningStatusResponse
        .builder
        .ifSome(permissionSetsProvisioningStatus)(_.permissionSetsProvisioningStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPermissionSetsProvisionedToAccountRequest(
      instanceArn: Option[String] = None,
      accountId: Option[String] = None,
      provisioningStatus: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPermissionSetsProvisionedToAccountRequest =
      ListPermissionSetsProvisionedToAccountRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(provisioningStatus)(_.provisioningStatus(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPermissionSetsProvisionedToAccountResponse(
      nextToken: Option[String] = None,
      permissionSets: Option[List[PermissionSetArn]] = None
    ): ListPermissionSetsProvisionedToAccountResponse =
      ListPermissionSetsProvisionedToAccountResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(permissionSets)(_.permissionSets(_))
        .build

    def listPermissionSetsRequest(
      instanceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPermissionSetsRequest =
      ListPermissionSetsRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPermissionSetsResponse(
      permissionSets: Option[List[PermissionSetArn]] = None,
      nextToken: Option[String] = None
    ): ListPermissionSetsResponse =
      ListPermissionSetsResponse
        .builder
        .ifSome(permissionSets)(_.permissionSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      instanceArn: Option[String] = None,
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def operationStatusFilter(
      status: Option[String] = None
    ): OperationStatusFilter =
      OperationStatusFilter
        .builder
        .ifSome(status)(_.status(_))
        .build

    def permissionSet(
      name: Option[String] = None,
      permissionSetArn: Option[String] = None,
      description: Option[String] = None,
      createdDate: Option[Date] = None,
      sessionDuration: Option[String] = None,
      relayState: Option[String] = None
    ): PermissionSet =
      PermissionSet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(sessionDuration)(_.sessionDuration(_))
        .ifSome(relayState)(_.relayState(_))
        .build

    def permissionSetProvisioningStatus(
      status: Option[String] = None,
      requestId: Option[String] = None,
      accountId: Option[String] = None,
      permissionSetArn: Option[String] = None,
      failureReason: Option[String] = None,
      createdDate: Option[Date] = None
    ): PermissionSetProvisioningStatus =
      PermissionSetProvisioningStatus
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def permissionSetProvisioningStatusMetadata(
      status: Option[String] = None,
      requestId: Option[String] = None,
      createdDate: Option[Date] = None
    ): PermissionSetProvisioningStatusMetadata =
      PermissionSetProvisioningStatusMetadata
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def provisionPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      targetId: Option[String] = None,
      targetType: Option[String] = None
    ): ProvisionPermissionSetRequest =
      ProvisionPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(targetType)(_.targetType(_))
        .build

    def provisionPermissionSetResponse(
      permissionSetProvisioningStatus: Option[PermissionSetProvisioningStatus] = None
    ): ProvisionPermissionSetResponse =
      ProvisionPermissionSetResponse
        .builder
        .ifSome(permissionSetProvisioningStatus)(_.permissionSetProvisioningStatus(_))
        .build

    def putInlinePolicyToPermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      inlinePolicy: Option[String] = None
    ): PutInlinePolicyToPermissionSetRequest =
      PutInlinePolicyToPermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(inlinePolicy)(_.inlinePolicy(_))
        .build

    def putInlinePolicyToPermissionSetResponse(

    ): PutInlinePolicyToPermissionSetResponse =
      PutInlinePolicyToPermissionSetResponse
        .builder

        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
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
      instanceArn: Option[String] = None,
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      instanceArn: Option[String] = None,
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateInstanceAccessControlAttributeConfigurationRequest(
      instanceArn: Option[String] = None,
      instanceAccessControlAttributeConfiguration: Option[InstanceAccessControlAttributeConfiguration] = None
    ): UpdateInstanceAccessControlAttributeConfigurationRequest =
      UpdateInstanceAccessControlAttributeConfigurationRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(instanceAccessControlAttributeConfiguration)(_.instanceAccessControlAttributeConfiguration(_))
        .build

    def updateInstanceAccessControlAttributeConfigurationResponse(

    ): UpdateInstanceAccessControlAttributeConfigurationResponse =
      UpdateInstanceAccessControlAttributeConfigurationResponse
        .builder

        .build

    def updatePermissionSetRequest(
      instanceArn: Option[String] = None,
      permissionSetArn: Option[String] = None,
      description: Option[String] = None,
      sessionDuration: Option[String] = None,
      relayState: Option[String] = None
    ): UpdatePermissionSetRequest =
      UpdatePermissionSetRequest
        .builder
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(permissionSetArn)(_.permissionSetArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(sessionDuration)(_.sessionDuration(_))
        .ifSome(relayState)(_.relayState(_))
        .build

    def updatePermissionSetResponse(

    ): UpdatePermissionSetResponse =
      UpdatePermissionSetResponse
        .builder

        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
