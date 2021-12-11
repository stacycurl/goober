package goober.hi

import goober.free.organizations.OrganizationsIO
import software.amazon.awssdk.services.organizations.model._


object organizations {
  import goober.free.{organizations ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aWSOrganizationsNotInUseException(
      message: Option[String] = None
    ): AWSOrganizationsNotInUseException =
      AWSOrganizationsNotInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def acceptHandshakeRequest(
      handshakeId: Option[String] = None
    ): AcceptHandshakeRequest =
      AcceptHandshakeRequest
        .builder
        .ifSome(handshakeId)(_.handshakeId(_))
        .build

    def acceptHandshakeResponse(
      handshake: Option[Handshake] = None
    ): AcceptHandshakeResponse =
      AcceptHandshakeResponse
        .builder
        .ifSome(handshake)(_.handshake(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accessDeniedForDependencyException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): AccessDeniedForDependencyException =
      AccessDeniedForDependencyException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def account(
      id: Option[String] = None,
      arn: Option[String] = None,
      email: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      joinedMethod: Option[String] = None,
      joinedTimestamp: Option[Timestamp] = None
    ): Account =
      Account
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(email)(_.email(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(joinedMethod)(_.joinedMethod(_))
        .ifSome(joinedTimestamp)(_.joinedTimestamp(_))
        .build

    def accountAlreadyRegisteredException(
      message: Option[String] = None
    ): AccountAlreadyRegisteredException =
      AccountAlreadyRegisteredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountNotFoundException(
      message: Option[String] = None
    ): AccountNotFoundException =
      AccountNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountNotRegisteredException(
      message: Option[String] = None
    ): AccountNotRegisteredException =
      AccountNotRegisteredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountOwnerNotVerifiedException(
      message: Option[String] = None
    ): AccountOwnerNotVerifiedException =
      AccountOwnerNotVerifiedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def alreadyInOrganizationException(
      message: Option[String] = None
    ): AlreadyInOrganizationException =
      AlreadyInOrganizationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def attachPolicyRequest(
      policyId: Option[String] = None,
      targetId: Option[String] = None
    ): AttachPolicyRequest =
      AttachPolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(targetId)(_.targetId(_))
        .build

    def cancelHandshakeRequest(
      handshakeId: Option[String] = None
    ): CancelHandshakeRequest =
      CancelHandshakeRequest
        .builder
        .ifSome(handshakeId)(_.handshakeId(_))
        .build

    def cancelHandshakeResponse(
      handshake: Option[Handshake] = None
    ): CancelHandshakeResponse =
      CancelHandshakeResponse
        .builder
        .ifSome(handshake)(_.handshake(_))
        .build

    def child(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): Child =
      Child
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def childNotFoundException(
      message: Option[String] = None
    ): ChildNotFoundException =
      ChildNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def constraintViolationException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): ConstraintViolationException =
      ConstraintViolationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def createAccountRequest(
      email: Option[String] = None,
      accountName: Option[String] = None,
      roleName: Option[String] = None,
      iamUserAccessToBilling: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateAccountRequest =
      CreateAccountRequest
        .builder
        .ifSome(email)(_.email(_))
        .ifSome(accountName)(_.accountName(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(iamUserAccessToBilling)(_.iamUserAccessToBilling(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAccountResponse(
      createAccountStatus: Option[CreateAccountStatus] = None
    ): CreateAccountResponse =
      CreateAccountResponse
        .builder
        .ifSome(createAccountStatus)(_.createAccountStatus(_))
        .build

    def createAccountStatus(
      id: Option[String] = None,
      accountName: Option[String] = None,
      state: Option[String] = None,
      requestedTimestamp: Option[Timestamp] = None,
      completedTimestamp: Option[Timestamp] = None,
      accountId: Option[String] = None,
      govCloudAccountId: Option[String] = None,
      failureReason: Option[String] = None
    ): CreateAccountStatus =
      CreateAccountStatus
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(accountName)(_.accountName(_))
        .ifSome(state)(_.state(_))
        .ifSome(requestedTimestamp)(_.requestedTimestamp(_))
        .ifSome(completedTimestamp)(_.completedTimestamp(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(govCloudAccountId)(_.govCloudAccountId(_))
        .ifSome(failureReason)(_.failureReason(_))
        .build

    def createAccountStatusNotFoundException(
      message: Option[String] = None
    ): CreateAccountStatusNotFoundException =
      CreateAccountStatusNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createGovCloudAccountRequest(
      email: Option[String] = None,
      accountName: Option[String] = None,
      roleName: Option[String] = None,
      iamUserAccessToBilling: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateGovCloudAccountRequest =
      CreateGovCloudAccountRequest
        .builder
        .ifSome(email)(_.email(_))
        .ifSome(accountName)(_.accountName(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(iamUserAccessToBilling)(_.iamUserAccessToBilling(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGovCloudAccountResponse(
      createAccountStatus: Option[CreateAccountStatus] = None
    ): CreateGovCloudAccountResponse =
      CreateGovCloudAccountResponse
        .builder
        .ifSome(createAccountStatus)(_.createAccountStatus(_))
        .build

    def createOrganizationRequest(
      featureSet: Option[String] = None
    ): CreateOrganizationRequest =
      CreateOrganizationRequest
        .builder
        .ifSome(featureSet)(_.featureSet(_))
        .build

    def createOrganizationResponse(
      organization: Option[Organization] = None
    ): CreateOrganizationResponse =
      CreateOrganizationResponse
        .builder
        .ifSome(organization)(_.organization(_))
        .build

    def createOrganizationalUnitRequest(
      parentId: Option[String] = None,
      name: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateOrganizationalUnitRequest =
      CreateOrganizationalUnitRequest
        .builder
        .ifSome(parentId)(_.parentId(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createOrganizationalUnitResponse(
      organizationalUnit: Option[OrganizationalUnit] = None
    ): CreateOrganizationalUnitResponse =
      CreateOrganizationalUnitResponse
        .builder
        .ifSome(organizationalUnit)(_.organizationalUnit(_))
        .build

    def createPolicyRequest(
      content: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePolicyRequest =
      CreatePolicyRequest
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPolicyResponse(
      policy: Option[Policy] = None
    ): CreatePolicyResponse =
      CreatePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def declineHandshakeRequest(
      handshakeId: Option[String] = None
    ): DeclineHandshakeRequest =
      DeclineHandshakeRequest
        .builder
        .ifSome(handshakeId)(_.handshakeId(_))
        .build

    def declineHandshakeResponse(
      handshake: Option[Handshake] = None
    ): DeclineHandshakeResponse =
      DeclineHandshakeResponse
        .builder
        .ifSome(handshake)(_.handshake(_))
        .build

    def delegatedAdministrator(
      id: Option[String] = None,
      arn: Option[String] = None,
      email: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      joinedMethod: Option[String] = None,
      joinedTimestamp: Option[Timestamp] = None,
      delegationEnabledDate: Option[Timestamp] = None
    ): DelegatedAdministrator =
      DelegatedAdministrator
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(email)(_.email(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(joinedMethod)(_.joinedMethod(_))
        .ifSome(joinedTimestamp)(_.joinedTimestamp(_))
        .ifSome(delegationEnabledDate)(_.delegationEnabledDate(_))
        .build

    def delegatedService(
      servicePrincipal: Option[String] = None,
      delegationEnabledDate: Option[Timestamp] = None
    ): DelegatedService =
      DelegatedService
        .builder
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .ifSome(delegationEnabledDate)(_.delegationEnabledDate(_))
        .build

    def deleteOrganizationalUnitRequest(
      organizationalUnitId: Option[String] = None
    ): DeleteOrganizationalUnitRequest =
      DeleteOrganizationalUnitRequest
        .builder
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .build

    def deletePolicyRequest(
      policyId: Option[String] = None
    ): DeletePolicyRequest =
      DeletePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def deregisterDelegatedAdministratorRequest(
      accountId: Option[String] = None,
      servicePrincipal: Option[String] = None
    ): DeregisterDelegatedAdministratorRequest =
      DeregisterDelegatedAdministratorRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .build

    def describeAccountRequest(
      accountId: Option[String] = None
    ): DescribeAccountRequest =
      DescribeAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def describeAccountResponse(
      account: Option[Account] = None
    ): DescribeAccountResponse =
      DescribeAccountResponse
        .builder
        .ifSome(account)(_.account(_))
        .build

    def describeCreateAccountStatusRequest(
      createAccountRequestId: Option[String] = None
    ): DescribeCreateAccountStatusRequest =
      DescribeCreateAccountStatusRequest
        .builder
        .ifSome(createAccountRequestId)(_.createAccountRequestId(_))
        .build

    def describeCreateAccountStatusResponse(
      createAccountStatus: Option[CreateAccountStatus] = None
    ): DescribeCreateAccountStatusResponse =
      DescribeCreateAccountStatusResponse
        .builder
        .ifSome(createAccountStatus)(_.createAccountStatus(_))
        .build

    def describeEffectivePolicyRequest(
      policyType: Option[String] = None,
      targetId: Option[String] = None
    ): DescribeEffectivePolicyRequest =
      DescribeEffectivePolicyRequest
        .builder
        .ifSome(policyType)(_.policyType(_))
        .ifSome(targetId)(_.targetId(_))
        .build

    def describeEffectivePolicyResponse(
      effectivePolicy: Option[EffectivePolicy] = None
    ): DescribeEffectivePolicyResponse =
      DescribeEffectivePolicyResponse
        .builder
        .ifSome(effectivePolicy)(_.effectivePolicy(_))
        .build

    def describeHandshakeRequest(
      handshakeId: Option[String] = None
    ): DescribeHandshakeRequest =
      DescribeHandshakeRequest
        .builder
        .ifSome(handshakeId)(_.handshakeId(_))
        .build

    def describeHandshakeResponse(
      handshake: Option[Handshake] = None
    ): DescribeHandshakeResponse =
      DescribeHandshakeResponse
        .builder
        .ifSome(handshake)(_.handshake(_))
        .build

    def describeOrganizationResponse(
      organization: Option[Organization] = None
    ): DescribeOrganizationResponse =
      DescribeOrganizationResponse
        .builder
        .ifSome(organization)(_.organization(_))
        .build

    def describeOrganizationalUnitRequest(
      organizationalUnitId: Option[String] = None
    ): DescribeOrganizationalUnitRequest =
      DescribeOrganizationalUnitRequest
        .builder
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .build

    def describeOrganizationalUnitResponse(
      organizationalUnit: Option[OrganizationalUnit] = None
    ): DescribeOrganizationalUnitResponse =
      DescribeOrganizationalUnitResponse
        .builder
        .ifSome(organizationalUnit)(_.organizationalUnit(_))
        .build

    def describePolicyRequest(
      policyId: Option[String] = None
    ): DescribePolicyRequest =
      DescribePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .build

    def describePolicyResponse(
      policy: Option[Policy] = None
    ): DescribePolicyResponse =
      DescribePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def destinationParentNotFoundException(
      message: Option[String] = None
    ): DestinationParentNotFoundException =
      DestinationParentNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def detachPolicyRequest(
      policyId: Option[String] = None,
      targetId: Option[String] = None
    ): DetachPolicyRequest =
      DetachPolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(targetId)(_.targetId(_))
        .build

    def disableAWSServiceAccessRequest(
      servicePrincipal: Option[String] = None
    ): DisableAWSServiceAccessRequest =
      DisableAWSServiceAccessRequest
        .builder
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .build

    def disablePolicyTypeRequest(
      rootId: Option[String] = None,
      policyType: Option[String] = None
    ): DisablePolicyTypeRequest =
      DisablePolicyTypeRequest
        .builder
        .ifSome(rootId)(_.rootId(_))
        .ifSome(policyType)(_.policyType(_))
        .build

    def disablePolicyTypeResponse(
      root: Option[Root] = None
    ): DisablePolicyTypeResponse =
      DisablePolicyTypeResponse
        .builder
        .ifSome(root)(_.root(_))
        .build

    def duplicateAccountException(
      message: Option[String] = None
    ): DuplicateAccountException =
      DuplicateAccountException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateHandshakeException(
      message: Option[String] = None
    ): DuplicateHandshakeException =
      DuplicateHandshakeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicateOrganizationalUnitException(
      message: Option[String] = None
    ): DuplicateOrganizationalUnitException =
      DuplicateOrganizationalUnitException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicatePolicyAttachmentException(
      message: Option[String] = None
    ): DuplicatePolicyAttachmentException =
      DuplicatePolicyAttachmentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def duplicatePolicyException(
      message: Option[String] = None
    ): DuplicatePolicyException =
      DuplicatePolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def effectivePolicy(
      policyContent: Option[String] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None,
      targetId: Option[String] = None,
      policyType: Option[String] = None
    ): EffectivePolicy =
      EffectivePolicy
        .builder
        .ifSome(policyContent)(_.policyContent(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(targetId)(_.targetId(_))
        .ifSome(policyType)(_.policyType(_))
        .build

    def effectivePolicyNotFoundException(
      message: Option[String] = None
    ): EffectivePolicyNotFoundException =
      EffectivePolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def enableAWSServiceAccessRequest(
      servicePrincipal: Option[String] = None
    ): EnableAWSServiceAccessRequest =
      EnableAWSServiceAccessRequest
        .builder
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .build

    def enableAllFeaturesRequest(

    ): EnableAllFeaturesRequest =
      EnableAllFeaturesRequest
        .builder

        .build

    def enableAllFeaturesResponse(
      handshake: Option[Handshake] = None
    ): EnableAllFeaturesResponse =
      EnableAllFeaturesResponse
        .builder
        .ifSome(handshake)(_.handshake(_))
        .build

    def enablePolicyTypeRequest(
      rootId: Option[String] = None,
      policyType: Option[String] = None
    ): EnablePolicyTypeRequest =
      EnablePolicyTypeRequest
        .builder
        .ifSome(rootId)(_.rootId(_))
        .ifSome(policyType)(_.policyType(_))
        .build

    def enablePolicyTypeResponse(
      root: Option[Root] = None
    ): EnablePolicyTypeResponse =
      EnablePolicyTypeResponse
        .builder
        .ifSome(root)(_.root(_))
        .build

    def enabledServicePrincipal(
      servicePrincipal: Option[String] = None,
      dateEnabled: Option[Timestamp] = None
    ): EnabledServicePrincipal =
      EnabledServicePrincipal
        .builder
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .ifSome(dateEnabled)(_.dateEnabled(_))
        .build

    def finalizingOrganizationException(
      message: Option[String] = None
    ): FinalizingOrganizationException =
      FinalizingOrganizationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def handshake(
      id: Option[String] = None,
      arn: Option[String] = None,
      parties: Option[List[HandshakeParty]] = None,
      state: Option[String] = None,
      requestedTimestamp: Option[Timestamp] = None,
      expirationTimestamp: Option[Timestamp] = None,
      action: Option[String] = None,
      resources: Option[List[HandshakeResource]] = None
    ): Handshake =
      Handshake
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(parties)(_.parties(_))
        .ifSome(state)(_.state(_))
        .ifSome(requestedTimestamp)(_.requestedTimestamp(_))
        .ifSome(expirationTimestamp)(_.expirationTimestamp(_))
        .ifSome(action)(_.action(_))
        .ifSome(resources)(_.resources(_))
        .build

    def handshakeAlreadyInStateException(
      message: Option[String] = None
    ): HandshakeAlreadyInStateException =
      HandshakeAlreadyInStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def handshakeConstraintViolationException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): HandshakeConstraintViolationException =
      HandshakeConstraintViolationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def handshakeFilter(
      actionType: Option[String] = None,
      parentHandshakeId: Option[String] = None
    ): HandshakeFilter =
      HandshakeFilter
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(parentHandshakeId)(_.parentHandshakeId(_))
        .build

    def handshakeNotFoundException(
      message: Option[String] = None
    ): HandshakeNotFoundException =
      HandshakeNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def handshakeParty(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): HandshakeParty =
      HandshakeParty
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def handshakeResource(
      value: Option[String] = None,
      `type`: Option[String] = None,
      resources: Option[List[HandshakeResource]] = None
    ): HandshakeResource =
      HandshakeResource
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(resources)(_.resources(_))
        .build

    def invalidHandshakeTransitionException(
      message: Option[String] = None
    ): InvalidHandshakeTransitionException =
      InvalidHandshakeTransitionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidInputException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def inviteAccountToOrganizationRequest(
      target: Option[HandshakeParty] = None,
      notes: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): InviteAccountToOrganizationRequest =
      InviteAccountToOrganizationRequest
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(notes)(_.notes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def inviteAccountToOrganizationResponse(
      handshake: Option[Handshake] = None
    ): InviteAccountToOrganizationResponse =
      InviteAccountToOrganizationResponse
        .builder
        .ifSome(handshake)(_.handshake(_))
        .build

    def listAWSServiceAccessForOrganizationRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAWSServiceAccessForOrganizationRequest =
      ListAWSServiceAccessForOrganizationRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAWSServiceAccessForOrganizationResponse(
      enabledServicePrincipals: Option[List[EnabledServicePrincipal]] = None,
      nextToken: Option[String] = None
    ): ListAWSServiceAccessForOrganizationResponse =
      ListAWSServiceAccessForOrganizationResponse
        .builder
        .ifSome(enabledServicePrincipals)(_.enabledServicePrincipals(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountsForParentRequest(
      parentId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccountsForParentRequest =
      ListAccountsForParentRequest
        .builder
        .ifSome(parentId)(_.parentId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAccountsForParentResponse(
      accounts: Option[List[Account]] = None,
      nextToken: Option[String] = None
    ): ListAccountsForParentResponse =
      ListAccountsForParentResponse
        .builder
        .ifSome(accounts)(_.accounts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAccountsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAccountsRequest =
      ListAccountsRequest
        .builder
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

    def listChildrenRequest(
      parentId: Option[String] = None,
      childType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListChildrenRequest =
      ListChildrenRequest
        .builder
        .ifSome(parentId)(_.parentId(_))
        .ifSome(childType)(_.childType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listChildrenResponse(
      children: Option[List[Child]] = None,
      nextToken: Option[String] = None
    ): ListChildrenResponse =
      ListChildrenResponse
        .builder
        .ifSome(children)(_.children(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCreateAccountStatusRequest(
      states: Option[List[CreateAccountState]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCreateAccountStatusRequest =
      ListCreateAccountStatusRequest
        .builder
        .ifSome(states)(_.states(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCreateAccountStatusResponse(
      createAccountStatuses: Option[List[CreateAccountStatus]] = None,
      nextToken: Option[String] = None
    ): ListCreateAccountStatusResponse =
      ListCreateAccountStatusResponse
        .builder
        .ifSome(createAccountStatuses)(_.createAccountStatuses(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDelegatedAdministratorsRequest(
      servicePrincipal: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDelegatedAdministratorsRequest =
      ListDelegatedAdministratorsRequest
        .builder
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDelegatedAdministratorsResponse(
      delegatedAdministrators: Option[List[DelegatedAdministrator]] = None,
      nextToken: Option[String] = None
    ): ListDelegatedAdministratorsResponse =
      ListDelegatedAdministratorsResponse
        .builder
        .ifSome(delegatedAdministrators)(_.delegatedAdministrators(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDelegatedServicesForAccountRequest(
      accountId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDelegatedServicesForAccountRequest =
      ListDelegatedServicesForAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDelegatedServicesForAccountResponse(
      delegatedServices: Option[List[DelegatedService]] = None,
      nextToken: Option[String] = None
    ): ListDelegatedServicesForAccountResponse =
      ListDelegatedServicesForAccountResponse
        .builder
        .ifSome(delegatedServices)(_.delegatedServices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHandshakesForAccountRequest(
      filter: Option[HandshakeFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHandshakesForAccountRequest =
      ListHandshakesForAccountRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHandshakesForAccountResponse(
      handshakes: Option[List[Handshake]] = None,
      nextToken: Option[String] = None
    ): ListHandshakesForAccountResponse =
      ListHandshakesForAccountResponse
        .builder
        .ifSome(handshakes)(_.handshakes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHandshakesForOrganizationRequest(
      filter: Option[HandshakeFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHandshakesForOrganizationRequest =
      ListHandshakesForOrganizationRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHandshakesForOrganizationResponse(
      handshakes: Option[List[Handshake]] = None,
      nextToken: Option[String] = None
    ): ListHandshakesForOrganizationResponse =
      ListHandshakesForOrganizationResponse
        .builder
        .ifSome(handshakes)(_.handshakes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOrganizationalUnitsForParentRequest(
      parentId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListOrganizationalUnitsForParentRequest =
      ListOrganizationalUnitsForParentRequest
        .builder
        .ifSome(parentId)(_.parentId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listOrganizationalUnitsForParentResponse(
      organizationalUnits: Option[List[OrganizationalUnit]] = None,
      nextToken: Option[String] = None
    ): ListOrganizationalUnitsForParentResponse =
      ListOrganizationalUnitsForParentResponse
        .builder
        .ifSome(organizationalUnits)(_.organizationalUnits(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listParentsRequest(
      childId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListParentsRequest =
      ListParentsRequest
        .builder
        .ifSome(childId)(_.childId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listParentsResponse(
      parents: Option[List[Parent]] = None,
      nextToken: Option[String] = None
    ): ListParentsResponse =
      ListParentsResponse
        .builder
        .ifSome(parents)(_.parents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPoliciesForTargetRequest(
      targetId: Option[String] = None,
      filter: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPoliciesForTargetRequest =
      ListPoliciesForTargetRequest
        .builder
        .ifSome(targetId)(_.targetId(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPoliciesForTargetResponse(
      policies: Option[List[PolicySummary]] = None,
      nextToken: Option[String] = None
    ): ListPoliciesForTargetResponse =
      ListPoliciesForTargetResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPoliciesRequest(
      filter: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPoliciesRequest =
      ListPoliciesRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPoliciesResponse(
      policies: Option[List[PolicySummary]] = None,
      nextToken: Option[String] = None
    ): ListPoliciesResponse =
      ListPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRootsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRootsRequest =
      ListRootsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRootsResponse(
      roots: Option[List[Root]] = None,
      nextToken: Option[String] = None
    ): ListRootsResponse =
      ListRootsResponse
        .builder
        .ifSome(roots)(_.roots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceId: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
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

    def listTargetsForPolicyRequest(
      policyId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTargetsForPolicyRequest =
      ListTargetsForPolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTargetsForPolicyResponse(
      targets: Option[List[PolicyTargetSummary]] = None,
      nextToken: Option[String] = None
    ): ListTargetsForPolicyResponse =
      ListTargetsForPolicyResponse
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def malformedPolicyDocumentException(
      message: Option[String] = None
    ): MalformedPolicyDocumentException =
      MalformedPolicyDocumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def masterCannotLeaveOrganizationException(
      message: Option[String] = None
    ): MasterCannotLeaveOrganizationException =
      MasterCannotLeaveOrganizationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def moveAccountRequest(
      accountId: Option[String] = None,
      sourceParentId: Option[String] = None,
      destinationParentId: Option[String] = None
    ): MoveAccountRequest =
      MoveAccountRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(sourceParentId)(_.sourceParentId(_))
        .ifSome(destinationParentId)(_.destinationParentId(_))
        .build

    def organization(
      id: Option[String] = None,
      arn: Option[String] = None,
      featureSet: Option[String] = None,
      masterAccountArn: Option[String] = None,
      masterAccountId: Option[String] = None,
      masterAccountEmail: Option[String] = None,
      availablePolicyTypes: Option[List[PolicyTypeSummary]] = None
    ): Organization =
      Organization
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(featureSet)(_.featureSet(_))
        .ifSome(masterAccountArn)(_.masterAccountArn(_))
        .ifSome(masterAccountId)(_.masterAccountId(_))
        .ifSome(masterAccountEmail)(_.masterAccountEmail(_))
        .ifSome(availablePolicyTypes)(_.availablePolicyTypes(_))
        .build

    def organizationNotEmptyException(
      message: Option[String] = None
    ): OrganizationNotEmptyException =
      OrganizationNotEmptyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationalUnit(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None
    ): OrganizationalUnit =
      OrganizationalUnit
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def organizationalUnitNotEmptyException(
      message: Option[String] = None
    ): OrganizationalUnitNotEmptyException =
      OrganizationalUnitNotEmptyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def organizationalUnitNotFoundException(
      message: Option[String] = None
    ): OrganizationalUnitNotFoundException =
      OrganizationalUnitNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def parent(
      id: Option[String] = None,
      `type`: Option[String] = None
    ): Parent =
      Parent
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def parentNotFoundException(
      message: Option[String] = None
    ): ParentNotFoundException =
      ParentNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policy(
      policySummary: Option[PolicySummary] = None,
      content: Option[String] = None
    ): Policy =
      Policy
        .builder
        .ifSome(policySummary)(_.policySummary(_))
        .ifSome(content)(_.content(_))
        .build

    def policyChangesInProgressException(
      message: Option[String] = None
    ): PolicyChangesInProgressException =
      PolicyChangesInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyInUseException(
      message: Option[String] = None
    ): PolicyInUseException =
      PolicyInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyNotAttachedException(
      message: Option[String] = None
    ): PolicyNotAttachedException =
      PolicyNotAttachedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyNotFoundException(
      message: Option[String] = None
    ): PolicyNotFoundException =
      PolicyNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policySummary(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      awsManaged: Option[Boolean] = None
    ): PolicySummary =
      PolicySummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(awsManaged)(_.awsManaged(_))
        .build

    def policyTargetSummary(
      targetId: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None
    ): PolicyTargetSummary =
      PolicyTargetSummary
        .builder
        .ifSome(targetId)(_.targetId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def policyTypeAlreadyEnabledException(
      message: Option[String] = None
    ): PolicyTypeAlreadyEnabledException =
      PolicyTypeAlreadyEnabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyTypeNotAvailableForOrganizationException(
      message: Option[String] = None
    ): PolicyTypeNotAvailableForOrganizationException =
      PolicyTypeNotAvailableForOrganizationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyTypeNotEnabledException(
      message: Option[String] = None
    ): PolicyTypeNotEnabledException =
      PolicyTypeNotEnabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def policyTypeSummary(
      `type`: Option[String] = None,
      status: Option[String] = None
    ): PolicyTypeSummary =
      PolicyTypeSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .build

    def registerDelegatedAdministratorRequest(
      accountId: Option[String] = None,
      servicePrincipal: Option[String] = None
    ): RegisterDelegatedAdministratorRequest =
      RegisterDelegatedAdministratorRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(servicePrincipal)(_.servicePrincipal(_))
        .build

    def removeAccountFromOrganizationRequest(
      accountId: Option[String] = None
    ): RemoveAccountFromOrganizationRequest =
      RemoveAccountFromOrganizationRequest
        .builder
        .ifSome(accountId)(_.accountId(_))
        .build

    def root(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      policyTypes: Option[List[PolicyTypeSummary]] = None
    ): Root =
      Root
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(policyTypes)(_.policyTypes(_))
        .build

    def rootNotFoundException(
      message: Option[String] = None
    ): RootNotFoundException =
      RootNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceException(
      message: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sourceParentNotFoundException(
      message: Option[String] = None
    ): SourceParentNotFoundException =
      SourceParentNotFoundException
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
      resourceId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def targetNotFoundException(
      message: Option[String] = None
    ): TargetNotFoundException =
      TargetNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequestsException(
      `type`: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def unsupportedAPIEndpointException(
      message: Option[String] = None
    ): UnsupportedAPIEndpointException =
      UnsupportedAPIEndpointException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceId: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateOrganizationalUnitRequest(
      organizationalUnitId: Option[String] = None,
      name: Option[String] = None
    ): UpdateOrganizationalUnitRequest =
      UpdateOrganizationalUnitRequest
        .builder
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateOrganizationalUnitResponse(
      organizationalUnit: Option[OrganizationalUnit] = None
    ): UpdateOrganizationalUnitResponse =
      UpdateOrganizationalUnitResponse
        .builder
        .ifSome(organizationalUnit)(_.organizationalUnit(_))
        .build

    def updatePolicyRequest(
      policyId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      content: Option[String] = None
    ): UpdatePolicyRequest =
      UpdatePolicyRequest
        .builder
        .ifSome(policyId)(_.policyId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(content)(_.content(_))
        .build

    def updatePolicyResponse(
      policy: Option[Policy] = None
    ): UpdatePolicyResponse =
      UpdatePolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
