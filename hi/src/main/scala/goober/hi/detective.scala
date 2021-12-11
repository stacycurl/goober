package goober.hi

import goober.free.detective.DetectiveIO
import software.amazon.awssdk.services.detective.model._


object detective {
  import goober.free.{detective ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptInvitationRequest(
      graphArn: Option[String] = None
    ): AcceptInvitationRequest =
      AcceptInvitationRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .build

    def account(
      accountId: Option[String] = None,
      emailAddress: Option[String] = None
    ): Account =
      Account
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createGraphRequest(
      tags: Option[TagMap] = None
    ): CreateGraphRequest =
      CreateGraphRequest
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def createGraphResponse(
      graphArn: Option[String] = None
    ): CreateGraphResponse =
      CreateGraphResponse
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .build

    def createMembersRequest(
      graphArn: Option[String] = None,
      message: Option[String] = None,
      disableEmailNotification: Option[Boolean] = None,
      accounts: Option[List[Account]] = None
    ): CreateMembersRequest =
      CreateMembersRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .ifSome(message)(_.message(_))
        .ifSome(disableEmailNotification)(_.disableEmailNotification(_))
        .ifSome(accounts)(_.accounts(_))
        .build

    def createMembersResponse(
      members: Option[List[MemberDetail]] = None,
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): CreateMembersResponse =
      CreateMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def deleteGraphRequest(
      graphArn: Option[String] = None
    ): DeleteGraphRequest =
      DeleteGraphRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .build

    def deleteMembersRequest(
      graphArn: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): DeleteMembersRequest =
      DeleteMembersRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def deleteMembersResponse(
      accountIds: Option[List[AccountId]] = None,
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): DeleteMembersResponse =
      DeleteMembersResponse
        .builder
        .ifSome(accountIds)(_.accountIds(_))
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def disassociateMembershipRequest(
      graphArn: Option[String] = None
    ): DisassociateMembershipRequest =
      DisassociateMembershipRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .build

    def getMembersRequest(
      graphArn: Option[String] = None,
      accountIds: Option[List[AccountId]] = None
    ): GetMembersRequest =
      GetMembersRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .ifSome(accountIds)(_.accountIds(_))
        .build

    def getMembersResponse(
      memberDetails: Option[List[MemberDetail]] = None,
      unprocessedAccounts: Option[List[UnprocessedAccount]] = None
    ): GetMembersResponse =
      GetMembersResponse
        .builder
        .ifSome(memberDetails)(_.memberDetails(_))
        .ifSome(unprocessedAccounts)(_.unprocessedAccounts(_))
        .build

    def graph(
      arn: Option[String] = None,
      createdTime: Option[Timestamp] = None
    ): Graph =
      Graph
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listGraphsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListGraphsRequest =
      ListGraphsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listGraphsResponse(
      graphList: Option[List[Graph]] = None,
      nextToken: Option[String] = None
    ): ListGraphsResponse =
      ListGraphsResponse
        .builder
        .ifSome(graphList)(_.graphList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListInvitationsRequest =
      ListInvitationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listInvitationsResponse(
      invitations: Option[List[MemberDetail]] = None,
      nextToken: Option[String] = None
    ): ListInvitationsResponse =
      ListInvitationsResponse
        .builder
        .ifSome(invitations)(_.invitations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMembersRequest(
      graphArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListMembersRequest =
      ListMembersRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listMembersResponse(
      memberDetails: Option[List[MemberDetail]] = None,
      nextToken: Option[String] = None
    ): ListMembersResponse =
      ListMembersResponse
        .builder
        .ifSome(memberDetails)(_.memberDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def memberDetail(
      accountId: Option[String] = None,
      emailAddress: Option[String] = None,
      graphArn: Option[String] = None,
      masterId: Option[String] = None,
      administratorId: Option[String] = None,
      status: Option[String] = None,
      disabledReason: Option[String] = None,
      invitedTime: Option[Timestamp] = None,
      updatedTime: Option[Timestamp] = None,
      volumeUsageInBytes: Option[ByteValue] = None,
      volumeUsageUpdatedTime: Option[Timestamp] = None,
      percentOfGraphUtilization: Option[Percentage] = None,
      percentOfGraphUtilizationUpdatedTime: Option[Timestamp] = None
    ): MemberDetail =
      MemberDetail
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(emailAddress)(_.emailAddress(_))
        .ifSome(graphArn)(_.graphArn(_))
        .ifSome(masterId)(_.masterId(_))
        .ifSome(administratorId)(_.administratorId(_))
        .ifSome(status)(_.status(_))
        .ifSome(disabledReason)(_.disabledReason(_))
        .ifSome(invitedTime)(_.invitedTime(_))
        .ifSome(updatedTime)(_.updatedTime(_))
        .ifSome(volumeUsageInBytes)(_.volumeUsageInBytes(_))
        .ifSome(volumeUsageUpdatedTime)(_.volumeUsageUpdatedTime(_))
        .ifSome(percentOfGraphUtilization)(_.percentOfGraphUtilization(_))
        .ifSome(percentOfGraphUtilizationUpdatedTime)(_.percentOfGraphUtilizationUpdatedTime(_))
        .build

    def rejectInvitationRequest(
      graphArn: Option[String] = None
    ): RejectInvitationRequest =
      RejectInvitationRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
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

    def startMonitoringMemberRequest(
      graphArn: Option[String] = None,
      accountId: Option[String] = None
    ): StartMonitoringMemberRequest =
      StartMonitoringMemberRequest
        .builder
        .ifSome(graphArn)(_.graphArn(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def unprocessedAccount(
      accountId: Option[String] = None,
      reason: Option[String] = None
    ): UnprocessedAccount =
      UnprocessedAccount
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(reason)(_.reason(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
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
