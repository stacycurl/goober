package goober.hi

import goober.free.ram.RamIO
import software.amazon.awssdk.services.ram.model._


object ram {
  import goober.free.{ram ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptResourceShareInvitationRequest(
      resourceShareInvitationArn: Option[String] = None,
      clientToken: Option[String] = None
    ): AcceptResourceShareInvitationRequest =
      AcceptResourceShareInvitationRequest
        .builder
        .ifSome(resourceShareInvitationArn)(_.resourceShareInvitationArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def acceptResourceShareInvitationResponse(
      resourceShareInvitation: Option[ResourceShareInvitation] = None,
      clientToken: Option[String] = None
    ): AcceptResourceShareInvitationResponse =
      AcceptResourceShareInvitationResponse
        .builder
        .ifSome(resourceShareInvitation)(_.resourceShareInvitation(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def associateResourceSharePermissionRequest(
      resourceShareArn: Option[String] = None,
      permissionArn: Option[String] = None,
      replace: Option[Boolean] = None,
      clientToken: Option[String] = None,
      permissionVersion: Option[Int] = None
    ): AssociateResourceSharePermissionRequest =
      AssociateResourceSharePermissionRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(permissionArn)(_.permissionArn(_))
        .ifSome(replace)(_.replace(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(permissionVersion)(_.permissionVersion(_))
        .build

    def associateResourceSharePermissionResponse(
      returnValue: Option[Boolean] = None,
      clientToken: Option[String] = None
    ): AssociateResourceSharePermissionResponse =
      AssociateResourceSharePermissionResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def associateResourceShareRequest(
      resourceShareArn: Option[String] = None,
      resourceArns: Option[List[String]] = None,
      principals: Option[List[String]] = None,
      clientToken: Option[String] = None
    ): AssociateResourceShareRequest =
      AssociateResourceShareRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def associateResourceShareResponse(
      resourceShareAssociations: Option[List[ResourceShareAssociation]] = None,
      clientToken: Option[String] = None
    ): AssociateResourceShareResponse =
      AssociateResourceShareResponse
        .builder
        .ifSome(resourceShareAssociations)(_.resourceShareAssociations(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createResourceShareRequest(
      name: Option[String] = None,
      resourceArns: Option[List[String]] = None,
      principals: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      allowExternalPrincipals: Option[Boolean] = None,
      clientToken: Option[String] = None,
      permissionArns: Option[List[String]] = None
    ): CreateResourceShareRequest =
      CreateResourceShareRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(allowExternalPrincipals)(_.allowExternalPrincipals(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(permissionArns)(_.permissionArns(_))
        .build

    def createResourceShareResponse(
      resourceShare: Option[ResourceShare] = None,
      clientToken: Option[String] = None
    ): CreateResourceShareResponse =
      CreateResourceShareResponse
        .builder
        .ifSome(resourceShare)(_.resourceShare(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteResourceShareRequest(
      resourceShareArn: Option[String] = None,
      clientToken: Option[String] = None
    ): DeleteResourceShareRequest =
      DeleteResourceShareRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def deleteResourceShareResponse(
      returnValue: Option[Boolean] = None,
      clientToken: Option[String] = None
    ): DeleteResourceShareResponse =
      DeleteResourceShareResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def disassociateResourceSharePermissionRequest(
      resourceShareArn: Option[String] = None,
      permissionArn: Option[String] = None,
      clientToken: Option[String] = None
    ): DisassociateResourceSharePermissionRequest =
      DisassociateResourceSharePermissionRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(permissionArn)(_.permissionArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def disassociateResourceSharePermissionResponse(
      returnValue: Option[Boolean] = None,
      clientToken: Option[String] = None
    ): DisassociateResourceSharePermissionResponse =
      DisassociateResourceSharePermissionResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def disassociateResourceShareRequest(
      resourceShareArn: Option[String] = None,
      resourceArns: Option[List[String]] = None,
      principals: Option[List[String]] = None,
      clientToken: Option[String] = None
    ): DisassociateResourceShareRequest =
      DisassociateResourceShareRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def disassociateResourceShareResponse(
      resourceShareAssociations: Option[List[ResourceShareAssociation]] = None,
      clientToken: Option[String] = None
    ): DisassociateResourceShareResponse =
      DisassociateResourceShareResponse
        .builder
        .ifSome(resourceShareAssociations)(_.resourceShareAssociations(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def enableSharingWithAwsOrganizationRequest(

    ): EnableSharingWithAwsOrganizationRequest =
      EnableSharingWithAwsOrganizationRequest
        .builder

        .build

    def enableSharingWithAwsOrganizationResponse(
      returnValue: Option[Boolean] = None
    ): EnableSharingWithAwsOrganizationResponse =
      EnableSharingWithAwsOrganizationResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .build

    def getPermissionRequest(
      permissionArn: Option[String] = None,
      permissionVersion: Option[Int] = None
    ): GetPermissionRequest =
      GetPermissionRequest
        .builder
        .ifSome(permissionArn)(_.permissionArn(_))
        .ifSome(permissionVersion)(_.permissionVersion(_))
        .build

    def getPermissionResponse(
      permission: Option[ResourceSharePermissionDetail] = None
    ): GetPermissionResponse =
      GetPermissionResponse
        .builder
        .ifSome(permission)(_.permission(_))
        .build

    def getResourcePoliciesRequest(
      resourceArns: Option[List[String]] = None,
      principal: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetResourcePoliciesRequest =
      GetResourcePoliciesRequest
        .builder
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getResourcePoliciesResponse(
      policies: Option[List[Policy]] = None,
      nextToken: Option[String] = None
    ): GetResourcePoliciesResponse =
      GetResourcePoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceShareAssociationsRequest(
      associationType: Option[String] = None,
      resourceShareArns: Option[List[String]] = None,
      resourceArn: Option[String] = None,
      principal: Option[String] = None,
      associationStatus: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetResourceShareAssociationsRequest =
      GetResourceShareAssociationsRequest
        .builder
        .ifSome(associationType)(_.associationType(_))
        .ifSome(resourceShareArns)(_.resourceShareArns(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(associationStatus)(_.associationStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getResourceShareAssociationsResponse(
      resourceShareAssociations: Option[List[ResourceShareAssociation]] = None,
      nextToken: Option[String] = None
    ): GetResourceShareAssociationsResponse =
      GetResourceShareAssociationsResponse
        .builder
        .ifSome(resourceShareAssociations)(_.resourceShareAssociations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceShareInvitationsRequest(
      resourceShareInvitationArns: Option[List[String]] = None,
      resourceShareArns: Option[List[String]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetResourceShareInvitationsRequest =
      GetResourceShareInvitationsRequest
        .builder
        .ifSome(resourceShareInvitationArns)(_.resourceShareInvitationArns(_))
        .ifSome(resourceShareArns)(_.resourceShareArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getResourceShareInvitationsResponse(
      resourceShareInvitations: Option[List[ResourceShareInvitation]] = None,
      nextToken: Option[String] = None
    ): GetResourceShareInvitationsResponse =
      GetResourceShareInvitationsResponse
        .builder
        .ifSome(resourceShareInvitations)(_.resourceShareInvitations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getResourceSharesRequest(
      resourceShareArns: Option[List[String]] = None,
      resourceShareStatus: Option[String] = None,
      resourceOwner: Option[String] = None,
      name: Option[String] = None,
      tagFilters: Option[List[TagFilter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      permissionArn: Option[String] = None
    ): GetResourceSharesRequest =
      GetResourceSharesRequest
        .builder
        .ifSome(resourceShareArns)(_.resourceShareArns(_))
        .ifSome(resourceShareStatus)(_.resourceShareStatus(_))
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(name)(_.name(_))
        .ifSome(tagFilters)(_.tagFilters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(permissionArn)(_.permissionArn(_))
        .build

    def getResourceSharesResponse(
      resourceShares: Option[List[ResourceShare]] = None,
      nextToken: Option[String] = None
    ): GetResourceSharesResponse =
      GetResourceSharesResponse
        .builder
        .ifSome(resourceShares)(_.resourceShares(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidClientTokenException(
      message: Option[String] = None
    ): InvalidClientTokenException =
      InvalidClientTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidMaxResultsException(
      message: Option[String] = None
    ): InvalidMaxResultsException =
      InvalidMaxResultsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
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

    def invalidResourceTypeException(
      message: Option[String] = None
    ): InvalidResourceTypeException =
      InvalidResourceTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidStateTransitionException(
      message: Option[String] = None
    ): InvalidStateTransitionException =
      InvalidStateTransitionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listPendingInvitationResourcesRequest(
      resourceShareInvitationArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPendingInvitationResourcesRequest =
      ListPendingInvitationResourcesRequest
        .builder
        .ifSome(resourceShareInvitationArn)(_.resourceShareInvitationArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPendingInvitationResourcesResponse(
      resources: Option[List[Resource]] = None,
      nextToken: Option[String] = None
    ): ListPendingInvitationResourcesResponse =
      ListPendingInvitationResourcesResponse
        .builder
        .ifSome(resources)(_.resources(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPermissionsRequest(
      resourceType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPermissionsRequest =
      ListPermissionsRequest
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPermissionsResponse(
      permissions: Option[List[ResourceSharePermissionSummary]] = None,
      nextToken: Option[String] = None
    ): ListPermissionsResponse =
      ListPermissionsResponse
        .builder
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPrincipalsRequest(
      resourceOwner: Option[String] = None,
      resourceArn: Option[String] = None,
      principals: Option[List[String]] = None,
      resourceType: Option[String] = None,
      resourceShareArns: Option[List[String]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPrincipalsRequest =
      ListPrincipalsRequest
        .builder
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceShareArns)(_.resourceShareArns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPrincipalsResponse(
      principals: Option[List[Principal]] = None,
      nextToken: Option[String] = None
    ): ListPrincipalsResponse =
      ListPrincipalsResponse
        .builder
        .ifSome(principals)(_.principals(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceSharePermissionsRequest(
      resourceShareArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourceSharePermissionsRequest =
      ListResourceSharePermissionsRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourceSharePermissionsResponse(
      permissions: Option[List[ResourceSharePermissionSummary]] = None,
      nextToken: Option[String] = None
    ): ListResourceSharePermissionsResponse =
      ListResourceSharePermissionsResponse
        .builder
        .ifSome(permissions)(_.permissions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceTypesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourceTypesRequest =
      ListResourceTypesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listResourceTypesResponse(
      resourceTypes: Option[List[ServiceNameAndResourceType]] = None,
      nextToken: Option[String] = None
    ): ListResourceTypesResponse =
      ListResourceTypesResponse
        .builder
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourcesRequest(
      resourceOwner: Option[String] = None,
      principal: Option[String] = None,
      resourceType: Option[String] = None,
      resourceArns: Option[List[String]] = None,
      resourceShareArns: Option[List[String]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListResourcesRequest =
      ListResourcesRequest
        .builder
        .ifSome(resourceOwner)(_.resourceOwner(_))
        .ifSome(principal)(_.principal(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .ifSome(resourceShareArns)(_.resourceShareArns(_))
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

    def malformedArnException(
      message: Option[String] = None
    ): MalformedArnException =
      MalformedArnException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def missingRequiredParameterException(
      message: Option[String] = None
    ): MissingRequiredParameterException =
      MissingRequiredParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def operationNotPermittedException(
      message: Option[String] = None
    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def principal(
      id: Option[String] = None,
      resourceShareArn: Option[String] = None,
      creationTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      external: Option[Boolean] = None
    ): Principal =
      Principal
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(external)(_.external(_))
        .build

    def promoteResourceShareCreatedFromPolicyRequest(
      resourceShareArn: Option[String] = None
    ): PromoteResourceShareCreatedFromPolicyRequest =
      PromoteResourceShareCreatedFromPolicyRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .build

    def promoteResourceShareCreatedFromPolicyResponse(
      returnValue: Option[Boolean] = None
    ): PromoteResourceShareCreatedFromPolicyResponse =
      PromoteResourceShareCreatedFromPolicyResponse
        .builder
        .ifSome(returnValue)(_.returnValue(_))
        .build

    def rejectResourceShareInvitationRequest(
      resourceShareInvitationArn: Option[String] = None,
      clientToken: Option[String] = None
    ): RejectResourceShareInvitationRequest =
      RejectResourceShareInvitationRequest
        .builder
        .ifSome(resourceShareInvitationArn)(_.resourceShareInvitationArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def rejectResourceShareInvitationResponse(
      resourceShareInvitation: Option[ResourceShareInvitation] = None,
      clientToken: Option[String] = None
    ): RejectResourceShareInvitationResponse =
      RejectResourceShareInvitationResponse
        .builder
        .ifSome(resourceShareInvitation)(_.resourceShareInvitation(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def resource(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      resourceShareArn: Option[String] = None,
      resourceGroupArn: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      creationTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None
    ): Resource =
      Resource
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(resourceGroupArn)(_.resourceGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def resourceArnNotFoundException(
      message: Option[String] = None
    ): ResourceArnNotFoundException =
      ResourceArnNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceShare(
      resourceShareArn: Option[String] = None,
      name: Option[String] = None,
      owningAccountId: Option[String] = None,
      allowExternalPrincipals: Option[Boolean] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      tags: Option[List[Tag]] = None,
      creationTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      featureSet: Option[String] = None
    ): ResourceShare =
      ResourceShare
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(owningAccountId)(_.owningAccountId(_))
        .ifSome(allowExternalPrincipals)(_.allowExternalPrincipals(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(featureSet)(_.featureSet(_))
        .build

    def resourceShareAssociation(
      resourceShareArn: Option[String] = None,
      resourceShareName: Option[String] = None,
      associatedEntity: Option[String] = None,
      associationType: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      creationTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      external: Option[Boolean] = None
    ): ResourceShareAssociation =
      ResourceShareAssociation
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(resourceShareName)(_.resourceShareName(_))
        .ifSome(associatedEntity)(_.associatedEntity(_))
        .ifSome(associationType)(_.associationType(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(external)(_.external(_))
        .build

    def resourceShareInvitation(
      resourceShareInvitationArn: Option[String] = None,
      resourceShareName: Option[String] = None,
      resourceShareArn: Option[String] = None,
      senderAccountId: Option[String] = None,
      receiverAccountId: Option[String] = None,
      invitationTimestamp: Option[DateTime] = None,
      status: Option[String] = None,
      resourceShareAssociations: Option[List[ResourceShareAssociation]] = None,
      receiverArn: Option[String] = None
    ): ResourceShareInvitation =
      ResourceShareInvitation
        .builder
        .ifSome(resourceShareInvitationArn)(_.resourceShareInvitationArn(_))
        .ifSome(resourceShareName)(_.resourceShareName(_))
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(senderAccountId)(_.senderAccountId(_))
        .ifSome(receiverAccountId)(_.receiverAccountId(_))
        .ifSome(invitationTimestamp)(_.invitationTimestamp(_))
        .ifSome(status)(_.status(_))
        .ifSome(resourceShareAssociations)(_.resourceShareAssociations(_))
        .ifSome(receiverArn)(_.receiverArn(_))
        .build

    def resourceShareInvitationAlreadyAcceptedException(
      message: Option[String] = None
    ): ResourceShareInvitationAlreadyAcceptedException =
      ResourceShareInvitationAlreadyAcceptedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceShareInvitationAlreadyRejectedException(
      message: Option[String] = None
    ): ResourceShareInvitationAlreadyRejectedException =
      ResourceShareInvitationAlreadyRejectedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceShareInvitationArnNotFoundException(
      message: Option[String] = None
    ): ResourceShareInvitationArnNotFoundException =
      ResourceShareInvitationArnNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceShareInvitationExpiredException(
      message: Option[String] = None
    ): ResourceShareInvitationExpiredException =
      ResourceShareInvitationExpiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceShareLimitExceededException(
      message: Option[String] = None
    ): ResourceShareLimitExceededException =
      ResourceShareLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceSharePermissionDetail(
      arn: Option[String] = None,
      version: Option[String] = None,
      defaultVersion: Option[Boolean] = None,
      name: Option[String] = None,
      resourceType: Option[String] = None,
      permission: Option[String] = None,
      creationTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      isResourceTypeDefault: Option[Boolean] = None
    ): ResourceSharePermissionDetail =
      ResourceSharePermissionDetail
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(version)(_.version(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(permission)(_.permission(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(isResourceTypeDefault)(_.isResourceTypeDefault(_))
        .build

    def resourceSharePermissionSummary(
      arn: Option[String] = None,
      version: Option[String] = None,
      defaultVersion: Option[Boolean] = None,
      name: Option[String] = None,
      resourceType: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[DateTime] = None,
      lastUpdatedTime: Option[DateTime] = None,
      isResourceTypeDefault: Option[Boolean] = None
    ): ResourceSharePermissionSummary =
      ResourceSharePermissionSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(version)(_.version(_))
        .ifSome(defaultVersion)(_.defaultVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(isResourceTypeDefault)(_.isResourceTypeDefault(_))
        .build

    def serverInternalException(
      message: Option[String] = None
    ): ServerInternalException =
      ServerInternalException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceNameAndResourceType(
      resourceType: Option[String] = None,
      serviceName: Option[String] = None
    ): ServiceNameAndResourceType =
      ServiceNameAndResourceType
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
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

    def tagFilter(
      tagKey: Option[String] = None,
      tagValues: Option[List[TagValue]] = None
    ): TagFilter =
      TagFilter
        .builder
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValues)(_.tagValues(_))
        .build

    def tagLimitExceededException(
      message: Option[String] = None
    ): TagLimitExceededException =
      TagLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagPolicyViolationException(
      message: Option[String] = None
    ): TagPolicyViolationException =
      TagPolicyViolationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resourceShareArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def unknownResourceException(
      message: Option[String] = None
    ): UnknownResourceException =
      UnknownResourceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceShareArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateResourceShareRequest(
      resourceShareArn: Option[String] = None,
      name: Option[String] = None,
      allowExternalPrincipals: Option[Boolean] = None,
      clientToken: Option[String] = None
    ): UpdateResourceShareRequest =
      UpdateResourceShareRequest
        .builder
        .ifSome(resourceShareArn)(_.resourceShareArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(allowExternalPrincipals)(_.allowExternalPrincipals(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateResourceShareResponse(
      resourceShare: Option[ResourceShare] = None,
      clientToken: Option[String] = None
    ): UpdateResourceShareResponse =
      UpdateResourceShareResponse
        .builder
        .ifSome(resourceShare)(_.resourceShare(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
