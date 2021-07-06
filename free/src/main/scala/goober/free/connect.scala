package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.connect.ConnectClient
import software.amazon.awssdk.services.connect.model._


object connect { module =>

  // Free monad over ConnectOp
  type ConnectIO[A] = FF[ConnectOp, A]

  sealed trait ConnectOp[A] {
    def visit[F[_]](visitor: ConnectOp.Visitor[F]): F[A]
  }

  object ConnectOp {
    // Given a ConnectClient we can embed a ConnectIO program in any algebra that understands embedding.
    implicit val ConnectOpEmbeddable: Embeddable[ConnectOp, ConnectClient] = new Embeddable[ConnectOp, ConnectClient] {
      def embed[A](client: ConnectClient, io: ConnectIO[A]): Embedded[A] = Embedded.Connect(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends ConnectOp.Visitor[Kleisli[M, ConnectClient, *]] {
        def associateApprovedOrigin(
          request: AssociateApprovedOriginRequest
        ): Kleisli[M, ConnectClient, AssociateApprovedOriginResponse] =
          primitive(_.associateApprovedOrigin(request))

        def associateBot(
          request: AssociateBotRequest
        ): Kleisli[M, ConnectClient, AssociateBotResponse] =
          primitive(_.associateBot(request))

        def associateInstanceStorageConfig(
          request: AssociateInstanceStorageConfigRequest
        ): Kleisli[M, ConnectClient, AssociateInstanceStorageConfigResponse] =
          primitive(_.associateInstanceStorageConfig(request))

        def associateLambdaFunction(
          request: AssociateLambdaFunctionRequest
        ): Kleisli[M, ConnectClient, AssociateLambdaFunctionResponse] =
          primitive(_.associateLambdaFunction(request))

        def associateLexBot(
          request: AssociateLexBotRequest
        ): Kleisli[M, ConnectClient, AssociateLexBotResponse] =
          primitive(_.associateLexBot(request))

        def associateQueueQuickConnects(
          request: AssociateQueueQuickConnectsRequest
        ): Kleisli[M, ConnectClient, AssociateQueueQuickConnectsResponse] =
          primitive(_.associateQueueQuickConnects(request))

        def associateRoutingProfileQueues(
          request: AssociateRoutingProfileQueuesRequest
        ): Kleisli[M, ConnectClient, AssociateRoutingProfileQueuesResponse] =
          primitive(_.associateRoutingProfileQueues(request))

        def associateSecurityKey(
          request: AssociateSecurityKeyRequest
        ): Kleisli[M, ConnectClient, AssociateSecurityKeyResponse] =
          primitive(_.associateSecurityKey(request))

        def createContactFlow(
          request: CreateContactFlowRequest
        ): Kleisli[M, ConnectClient, CreateContactFlowResponse] =
          primitive(_.createContactFlow(request))

        def createInstance(
          request: CreateInstanceRequest
        ): Kleisli[M, ConnectClient, CreateInstanceResponse] =
          primitive(_.createInstance(request))

        def createIntegrationAssociation(
          request: CreateIntegrationAssociationRequest
        ): Kleisli[M, ConnectClient, CreateIntegrationAssociationResponse] =
          primitive(_.createIntegrationAssociation(request))

        def createQueue(
          request: CreateQueueRequest
        ): Kleisli[M, ConnectClient, CreateQueueResponse] =
          primitive(_.createQueue(request))

        def createQuickConnect(
          request: CreateQuickConnectRequest
        ): Kleisli[M, ConnectClient, CreateQuickConnectResponse] =
          primitive(_.createQuickConnect(request))

        def createRoutingProfile(
          request: CreateRoutingProfileRequest
        ): Kleisli[M, ConnectClient, CreateRoutingProfileResponse] =
          primitive(_.createRoutingProfile(request))

        def createUseCase(
          request: CreateUseCaseRequest
        ): Kleisli[M, ConnectClient, CreateUseCaseResponse] =
          primitive(_.createUseCase(request))

        def createUser(
          request: CreateUserRequest
        ): Kleisli[M, ConnectClient, CreateUserResponse] =
          primitive(_.createUser(request))

        def createUserHierarchyGroup(
          request: CreateUserHierarchyGroupRequest
        ): Kleisli[M, ConnectClient, CreateUserHierarchyGroupResponse] =
          primitive(_.createUserHierarchyGroup(request))

        def deleteInstance(
          request: DeleteInstanceRequest
        ): Kleisli[M, ConnectClient, DeleteInstanceResponse] =
          primitive(_.deleteInstance(request))

        def deleteIntegrationAssociation(
          request: DeleteIntegrationAssociationRequest
        ): Kleisli[M, ConnectClient, DeleteIntegrationAssociationResponse] =
          primitive(_.deleteIntegrationAssociation(request))

        def deleteQuickConnect(
          request: DeleteQuickConnectRequest
        ): Kleisli[M, ConnectClient, DeleteQuickConnectResponse] =
          primitive(_.deleteQuickConnect(request))

        def deleteUseCase(
          request: DeleteUseCaseRequest
        ): Kleisli[M, ConnectClient, DeleteUseCaseResponse] =
          primitive(_.deleteUseCase(request))

        def deleteUser(
          request: DeleteUserRequest
        ): Kleisli[M, ConnectClient, DeleteUserResponse] =
          primitive(_.deleteUser(request))

        def deleteUserHierarchyGroup(
          request: DeleteUserHierarchyGroupRequest
        ): Kleisli[M, ConnectClient, DeleteUserHierarchyGroupResponse] =
          primitive(_.deleteUserHierarchyGroup(request))

        def describeContactFlow(
          request: DescribeContactFlowRequest
        ): Kleisli[M, ConnectClient, DescribeContactFlowResponse] =
          primitive(_.describeContactFlow(request))

        def describeHoursOfOperation(
          request: DescribeHoursOfOperationRequest
        ): Kleisli[M, ConnectClient, DescribeHoursOfOperationResponse] =
          primitive(_.describeHoursOfOperation(request))

        def describeInstance(
          request: DescribeInstanceRequest
        ): Kleisli[M, ConnectClient, DescribeInstanceResponse] =
          primitive(_.describeInstance(request))

        def describeInstanceAttribute(
          request: DescribeInstanceAttributeRequest
        ): Kleisli[M, ConnectClient, DescribeInstanceAttributeResponse] =
          primitive(_.describeInstanceAttribute(request))

        def describeInstanceStorageConfig(
          request: DescribeInstanceStorageConfigRequest
        ): Kleisli[M, ConnectClient, DescribeInstanceStorageConfigResponse] =
          primitive(_.describeInstanceStorageConfig(request))

        def describeQueue(
          request: DescribeQueueRequest
        ): Kleisli[M, ConnectClient, DescribeQueueResponse] =
          primitive(_.describeQueue(request))

        def describeQuickConnect(
          request: DescribeQuickConnectRequest
        ): Kleisli[M, ConnectClient, DescribeQuickConnectResponse] =
          primitive(_.describeQuickConnect(request))

        def describeRoutingProfile(
          request: DescribeRoutingProfileRequest
        ): Kleisli[M, ConnectClient, DescribeRoutingProfileResponse] =
          primitive(_.describeRoutingProfile(request))

        def describeUser(
          request: DescribeUserRequest
        ): Kleisli[M, ConnectClient, DescribeUserResponse] =
          primitive(_.describeUser(request))

        def describeUserHierarchyGroup(
          request: DescribeUserHierarchyGroupRequest
        ): Kleisli[M, ConnectClient, DescribeUserHierarchyGroupResponse] =
          primitive(_.describeUserHierarchyGroup(request))

        def describeUserHierarchyStructure(
          request: DescribeUserHierarchyStructureRequest
        ): Kleisli[M, ConnectClient, DescribeUserHierarchyStructureResponse] =
          primitive(_.describeUserHierarchyStructure(request))

        def disassociateApprovedOrigin(
          request: DisassociateApprovedOriginRequest
        ): Kleisli[M, ConnectClient, DisassociateApprovedOriginResponse] =
          primitive(_.disassociateApprovedOrigin(request))

        def disassociateBot(
          request: DisassociateBotRequest
        ): Kleisli[M, ConnectClient, DisassociateBotResponse] =
          primitive(_.disassociateBot(request))

        def disassociateInstanceStorageConfig(
          request: DisassociateInstanceStorageConfigRequest
        ): Kleisli[M, ConnectClient, DisassociateInstanceStorageConfigResponse] =
          primitive(_.disassociateInstanceStorageConfig(request))

        def disassociateLambdaFunction(
          request: DisassociateLambdaFunctionRequest
        ): Kleisli[M, ConnectClient, DisassociateLambdaFunctionResponse] =
          primitive(_.disassociateLambdaFunction(request))

        def disassociateLexBot(
          request: DisassociateLexBotRequest
        ): Kleisli[M, ConnectClient, DisassociateLexBotResponse] =
          primitive(_.disassociateLexBot(request))

        def disassociateQueueQuickConnects(
          request: DisassociateQueueQuickConnectsRequest
        ): Kleisli[M, ConnectClient, DisassociateQueueQuickConnectsResponse] =
          primitive(_.disassociateQueueQuickConnects(request))

        def disassociateRoutingProfileQueues(
          request: DisassociateRoutingProfileQueuesRequest
        ): Kleisli[M, ConnectClient, DisassociateRoutingProfileQueuesResponse] =
          primitive(_.disassociateRoutingProfileQueues(request))

        def disassociateSecurityKey(
          request: DisassociateSecurityKeyRequest
        ): Kleisli[M, ConnectClient, DisassociateSecurityKeyResponse] =
          primitive(_.disassociateSecurityKey(request))

        def getContactAttributes(
          request: GetContactAttributesRequest
        ): Kleisli[M, ConnectClient, GetContactAttributesResponse] =
          primitive(_.getContactAttributes(request))

        def getCurrentMetricData(
          request: GetCurrentMetricDataRequest
        ): Kleisli[M, ConnectClient, GetCurrentMetricDataResponse] =
          primitive(_.getCurrentMetricData(request))

        def getFederationToken(
          request: GetFederationTokenRequest
        ): Kleisli[M, ConnectClient, GetFederationTokenResponse] =
          primitive(_.getFederationToken(request))

        def getMetricData(
          request: GetMetricDataRequest
        ): Kleisli[M, ConnectClient, GetMetricDataResponse] =
          primitive(_.getMetricData(request))

        def listApprovedOrigins(
          request: ListApprovedOriginsRequest
        ): Kleisli[M, ConnectClient, ListApprovedOriginsResponse] =
          primitive(_.listApprovedOrigins(request))

        def listBots(
          request: ListBotsRequest
        ): Kleisli[M, ConnectClient, ListBotsResponse] =
          primitive(_.listBots(request))

        def listContactFlows(
          request: ListContactFlowsRequest
        ): Kleisli[M, ConnectClient, ListContactFlowsResponse] =
          primitive(_.listContactFlows(request))

        def listHoursOfOperations(
          request: ListHoursOfOperationsRequest
        ): Kleisli[M, ConnectClient, ListHoursOfOperationsResponse] =
          primitive(_.listHoursOfOperations(request))

        def listInstanceAttributes(
          request: ListInstanceAttributesRequest
        ): Kleisli[M, ConnectClient, ListInstanceAttributesResponse] =
          primitive(_.listInstanceAttributes(request))

        def listInstanceStorageConfigs(
          request: ListInstanceStorageConfigsRequest
        ): Kleisli[M, ConnectClient, ListInstanceStorageConfigsResponse] =
          primitive(_.listInstanceStorageConfigs(request))

        def listInstances(
          request: ListInstancesRequest
        ): Kleisli[M, ConnectClient, ListInstancesResponse] =
          primitive(_.listInstances(request))

        def listIntegrationAssociations(
          request: ListIntegrationAssociationsRequest
        ): Kleisli[M, ConnectClient, ListIntegrationAssociationsResponse] =
          primitive(_.listIntegrationAssociations(request))

        def listLambdaFunctions(
          request: ListLambdaFunctionsRequest
        ): Kleisli[M, ConnectClient, ListLambdaFunctionsResponse] =
          primitive(_.listLambdaFunctions(request))

        def listLexBots(
          request: ListLexBotsRequest
        ): Kleisli[M, ConnectClient, ListLexBotsResponse] =
          primitive(_.listLexBots(request))

        def listPhoneNumbers(
          request: ListPhoneNumbersRequest
        ): Kleisli[M, ConnectClient, ListPhoneNumbersResponse] =
          primitive(_.listPhoneNumbers(request))

        def listPrompts(
          request: ListPromptsRequest
        ): Kleisli[M, ConnectClient, ListPromptsResponse] =
          primitive(_.listPrompts(request))

        def listQueueQuickConnects(
          request: ListQueueQuickConnectsRequest
        ): Kleisli[M, ConnectClient, ListQueueQuickConnectsResponse] =
          primitive(_.listQueueQuickConnects(request))

        def listQueues(
          request: ListQueuesRequest
        ): Kleisli[M, ConnectClient, ListQueuesResponse] =
          primitive(_.listQueues(request))

        def listQuickConnects(
          request: ListQuickConnectsRequest
        ): Kleisli[M, ConnectClient, ListQuickConnectsResponse] =
          primitive(_.listQuickConnects(request))

        def listRoutingProfileQueues(
          request: ListRoutingProfileQueuesRequest
        ): Kleisli[M, ConnectClient, ListRoutingProfileQueuesResponse] =
          primitive(_.listRoutingProfileQueues(request))

        def listRoutingProfiles(
          request: ListRoutingProfilesRequest
        ): Kleisli[M, ConnectClient, ListRoutingProfilesResponse] =
          primitive(_.listRoutingProfiles(request))

        def listSecurityKeys(
          request: ListSecurityKeysRequest
        ): Kleisli[M, ConnectClient, ListSecurityKeysResponse] =
          primitive(_.listSecurityKeys(request))

        def listSecurityProfiles(
          request: ListSecurityProfilesRequest
        ): Kleisli[M, ConnectClient, ListSecurityProfilesResponse] =
          primitive(_.listSecurityProfiles(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, ConnectClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def listUseCases(
          request: ListUseCasesRequest
        ): Kleisli[M, ConnectClient, ListUseCasesResponse] =
          primitive(_.listUseCases(request))

        def listUserHierarchyGroups(
          request: ListUserHierarchyGroupsRequest
        ): Kleisli[M, ConnectClient, ListUserHierarchyGroupsResponse] =
          primitive(_.listUserHierarchyGroups(request))

        def listUsers(
          request: ListUsersRequest
        ): Kleisli[M, ConnectClient, ListUsersResponse] =
          primitive(_.listUsers(request))

        def resumeContactRecording(
          request: ResumeContactRecordingRequest
        ): Kleisli[M, ConnectClient, ResumeContactRecordingResponse] =
          primitive(_.resumeContactRecording(request))

        def startChatContact(
          request: StartChatContactRequest
        ): Kleisli[M, ConnectClient, StartChatContactResponse] =
          primitive(_.startChatContact(request))

        def startContactRecording(
          request: StartContactRecordingRequest
        ): Kleisli[M, ConnectClient, StartContactRecordingResponse] =
          primitive(_.startContactRecording(request))

        def startOutboundVoiceContact(
          request: StartOutboundVoiceContactRequest
        ): Kleisli[M, ConnectClient, StartOutboundVoiceContactResponse] =
          primitive(_.startOutboundVoiceContact(request))

        def startTaskContact(
          request: StartTaskContactRequest
        ): Kleisli[M, ConnectClient, StartTaskContactResponse] =
          primitive(_.startTaskContact(request))

        def stopContact(
          request: StopContactRequest
        ): Kleisli[M, ConnectClient, StopContactResponse] =
          primitive(_.stopContact(request))

        def stopContactRecording(
          request: StopContactRecordingRequest
        ): Kleisli[M, ConnectClient, StopContactRecordingResponse] =
          primitive(_.stopContactRecording(request))

        def suspendContactRecording(
          request: SuspendContactRecordingRequest
        ): Kleisli[M, ConnectClient, SuspendContactRecordingResponse] =
          primitive(_.suspendContactRecording(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, ConnectClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, ConnectClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateContactAttributes(
          request: UpdateContactAttributesRequest
        ): Kleisli[M, ConnectClient, UpdateContactAttributesResponse] =
          primitive(_.updateContactAttributes(request))

        def updateContactFlowContent(
          request: UpdateContactFlowContentRequest
        ): Kleisli[M, ConnectClient, UpdateContactFlowContentResponse] =
          primitive(_.updateContactFlowContent(request))

        def updateContactFlowName(
          request: UpdateContactFlowNameRequest
        ): Kleisli[M, ConnectClient, UpdateContactFlowNameResponse] =
          primitive(_.updateContactFlowName(request))

        def updateInstanceAttribute(
          request: UpdateInstanceAttributeRequest
        ): Kleisli[M, ConnectClient, UpdateInstanceAttributeResponse] =
          primitive(_.updateInstanceAttribute(request))

        def updateInstanceStorageConfig(
          request: UpdateInstanceStorageConfigRequest
        ): Kleisli[M, ConnectClient, UpdateInstanceStorageConfigResponse] =
          primitive(_.updateInstanceStorageConfig(request))

        def updateQueueHoursOfOperation(
          request: UpdateQueueHoursOfOperationRequest
        ): Kleisli[M, ConnectClient, UpdateQueueHoursOfOperationResponse] =
          primitive(_.updateQueueHoursOfOperation(request))

        def updateQueueMaxContacts(
          request: UpdateQueueMaxContactsRequest
        ): Kleisli[M, ConnectClient, UpdateQueueMaxContactsResponse] =
          primitive(_.updateQueueMaxContacts(request))

        def updateQueueName(
          request: UpdateQueueNameRequest
        ): Kleisli[M, ConnectClient, UpdateQueueNameResponse] =
          primitive(_.updateQueueName(request))

        def updateQueueOutboundCallerConfig(
          request: UpdateQueueOutboundCallerConfigRequest
        ): Kleisli[M, ConnectClient, UpdateQueueOutboundCallerConfigResponse] =
          primitive(_.updateQueueOutboundCallerConfig(request))

        def updateQueueStatus(
          request: UpdateQueueStatusRequest
        ): Kleisli[M, ConnectClient, UpdateQueueStatusResponse] =
          primitive(_.updateQueueStatus(request))

        def updateQuickConnectConfig(
          request: UpdateQuickConnectConfigRequest
        ): Kleisli[M, ConnectClient, UpdateQuickConnectConfigResponse] =
          primitive(_.updateQuickConnectConfig(request))

        def updateQuickConnectName(
          request: UpdateQuickConnectNameRequest
        ): Kleisli[M, ConnectClient, UpdateQuickConnectNameResponse] =
          primitive(_.updateQuickConnectName(request))

        def updateRoutingProfileConcurrency(
          request: UpdateRoutingProfileConcurrencyRequest
        ): Kleisli[M, ConnectClient, UpdateRoutingProfileConcurrencyResponse] =
          primitive(_.updateRoutingProfileConcurrency(request))

        def updateRoutingProfileDefaultOutboundQueue(
          request: UpdateRoutingProfileDefaultOutboundQueueRequest
        ): Kleisli[M, ConnectClient, UpdateRoutingProfileDefaultOutboundQueueResponse] =
          primitive(_.updateRoutingProfileDefaultOutboundQueue(request))

        def updateRoutingProfileName(
          request: UpdateRoutingProfileNameRequest
        ): Kleisli[M, ConnectClient, UpdateRoutingProfileNameResponse] =
          primitive(_.updateRoutingProfileName(request))

        def updateRoutingProfileQueues(
          request: UpdateRoutingProfileQueuesRequest
        ): Kleisli[M, ConnectClient, UpdateRoutingProfileQueuesResponse] =
          primitive(_.updateRoutingProfileQueues(request))

        def updateUserHierarchy(
          request: UpdateUserHierarchyRequest
        ): Kleisli[M, ConnectClient, UpdateUserHierarchyResponse] =
          primitive(_.updateUserHierarchy(request))

        def updateUserHierarchyGroupName(
          request: UpdateUserHierarchyGroupNameRequest
        ): Kleisli[M, ConnectClient, UpdateUserHierarchyGroupNameResponse] =
          primitive(_.updateUserHierarchyGroupName(request))

        def updateUserHierarchyStructure(
          request: UpdateUserHierarchyStructureRequest
        ): Kleisli[M, ConnectClient, UpdateUserHierarchyStructureResponse] =
          primitive(_.updateUserHierarchyStructure(request))

        def updateUserIdentityInfo(
          request: UpdateUserIdentityInfoRequest
        ): Kleisli[M, ConnectClient, UpdateUserIdentityInfoResponse] =
          primitive(_.updateUserIdentityInfo(request))

        def updateUserPhoneConfig(
          request: UpdateUserPhoneConfigRequest
        ): Kleisli[M, ConnectClient, UpdateUserPhoneConfigResponse] =
          primitive(_.updateUserPhoneConfig(request))

        def updateUserRoutingProfile(
          request: UpdateUserRoutingProfileRequest
        ): Kleisli[M, ConnectClient, UpdateUserRoutingProfileResponse] =
          primitive(_.updateUserRoutingProfile(request))

        def updateUserSecurityProfiles(
          request: UpdateUserSecurityProfilesRequest
        ): Kleisli[M, ConnectClient, UpdateUserSecurityProfilesResponse] =
          primitive(_.updateUserSecurityProfiles(request))

        def primitive[A](
          f: ConnectClient => A
        ): Kleisli[M, ConnectClient, A]
      }
    }

    trait Visitor[F[_]] extends (ConnectOp ~> F) {
      final def apply[A](op: ConnectOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def associateApprovedOrigin(
        request: AssociateApprovedOriginRequest
      ): F[AssociateApprovedOriginResponse]

      def associateBot(
        request: AssociateBotRequest
      ): F[AssociateBotResponse]

      def associateInstanceStorageConfig(
        request: AssociateInstanceStorageConfigRequest
      ): F[AssociateInstanceStorageConfigResponse]

      def associateLambdaFunction(
        request: AssociateLambdaFunctionRequest
      ): F[AssociateLambdaFunctionResponse]

      def associateLexBot(
        request: AssociateLexBotRequest
      ): F[AssociateLexBotResponse]

      def associateQueueQuickConnects(
        request: AssociateQueueQuickConnectsRequest
      ): F[AssociateQueueQuickConnectsResponse]

      def associateRoutingProfileQueues(
        request: AssociateRoutingProfileQueuesRequest
      ): F[AssociateRoutingProfileQueuesResponse]

      def associateSecurityKey(
        request: AssociateSecurityKeyRequest
      ): F[AssociateSecurityKeyResponse]

      def createContactFlow(
        request: CreateContactFlowRequest
      ): F[CreateContactFlowResponse]

      def createInstance(
        request: CreateInstanceRequest
      ): F[CreateInstanceResponse]

      def createIntegrationAssociation(
        request: CreateIntegrationAssociationRequest
      ): F[CreateIntegrationAssociationResponse]

      def createQueue(
        request: CreateQueueRequest
      ): F[CreateQueueResponse]

      def createQuickConnect(
        request: CreateQuickConnectRequest
      ): F[CreateQuickConnectResponse]

      def createRoutingProfile(
        request: CreateRoutingProfileRequest
      ): F[CreateRoutingProfileResponse]

      def createUseCase(
        request: CreateUseCaseRequest
      ): F[CreateUseCaseResponse]

      def createUser(
        request: CreateUserRequest
      ): F[CreateUserResponse]

      def createUserHierarchyGroup(
        request: CreateUserHierarchyGroupRequest
      ): F[CreateUserHierarchyGroupResponse]

      def deleteInstance(
        request: DeleteInstanceRequest
      ): F[DeleteInstanceResponse]

      def deleteIntegrationAssociation(
        request: DeleteIntegrationAssociationRequest
      ): F[DeleteIntegrationAssociationResponse]

      def deleteQuickConnect(
        request: DeleteQuickConnectRequest
      ): F[DeleteQuickConnectResponse]

      def deleteUseCase(
        request: DeleteUseCaseRequest
      ): F[DeleteUseCaseResponse]

      def deleteUser(
        request: DeleteUserRequest
      ): F[DeleteUserResponse]

      def deleteUserHierarchyGroup(
        request: DeleteUserHierarchyGroupRequest
      ): F[DeleteUserHierarchyGroupResponse]

      def describeContactFlow(
        request: DescribeContactFlowRequest
      ): F[DescribeContactFlowResponse]

      def describeHoursOfOperation(
        request: DescribeHoursOfOperationRequest
      ): F[DescribeHoursOfOperationResponse]

      def describeInstance(
        request: DescribeInstanceRequest
      ): F[DescribeInstanceResponse]

      def describeInstanceAttribute(
        request: DescribeInstanceAttributeRequest
      ): F[DescribeInstanceAttributeResponse]

      def describeInstanceStorageConfig(
        request: DescribeInstanceStorageConfigRequest
      ): F[DescribeInstanceStorageConfigResponse]

      def describeQueue(
        request: DescribeQueueRequest
      ): F[DescribeQueueResponse]

      def describeQuickConnect(
        request: DescribeQuickConnectRequest
      ): F[DescribeQuickConnectResponse]

      def describeRoutingProfile(
        request: DescribeRoutingProfileRequest
      ): F[DescribeRoutingProfileResponse]

      def describeUser(
        request: DescribeUserRequest
      ): F[DescribeUserResponse]

      def describeUserHierarchyGroup(
        request: DescribeUserHierarchyGroupRequest
      ): F[DescribeUserHierarchyGroupResponse]

      def describeUserHierarchyStructure(
        request: DescribeUserHierarchyStructureRequest
      ): F[DescribeUserHierarchyStructureResponse]

      def disassociateApprovedOrigin(
        request: DisassociateApprovedOriginRequest
      ): F[DisassociateApprovedOriginResponse]

      def disassociateBot(
        request: DisassociateBotRequest
      ): F[DisassociateBotResponse]

      def disassociateInstanceStorageConfig(
        request: DisassociateInstanceStorageConfigRequest
      ): F[DisassociateInstanceStorageConfigResponse]

      def disassociateLambdaFunction(
        request: DisassociateLambdaFunctionRequest
      ): F[DisassociateLambdaFunctionResponse]

      def disassociateLexBot(
        request: DisassociateLexBotRequest
      ): F[DisassociateLexBotResponse]

      def disassociateQueueQuickConnects(
        request: DisassociateQueueQuickConnectsRequest
      ): F[DisassociateQueueQuickConnectsResponse]

      def disassociateRoutingProfileQueues(
        request: DisassociateRoutingProfileQueuesRequest
      ): F[DisassociateRoutingProfileQueuesResponse]

      def disassociateSecurityKey(
        request: DisassociateSecurityKeyRequest
      ): F[DisassociateSecurityKeyResponse]

      def getContactAttributes(
        request: GetContactAttributesRequest
      ): F[GetContactAttributesResponse]

      def getCurrentMetricData(
        request: GetCurrentMetricDataRequest
      ): F[GetCurrentMetricDataResponse]

      def getFederationToken(
        request: GetFederationTokenRequest
      ): F[GetFederationTokenResponse]

      def getMetricData(
        request: GetMetricDataRequest
      ): F[GetMetricDataResponse]

      def listApprovedOrigins(
        request: ListApprovedOriginsRequest
      ): F[ListApprovedOriginsResponse]

      def listBots(
        request: ListBotsRequest
      ): F[ListBotsResponse]

      def listContactFlows(
        request: ListContactFlowsRequest
      ): F[ListContactFlowsResponse]

      def listHoursOfOperations(
        request: ListHoursOfOperationsRequest
      ): F[ListHoursOfOperationsResponse]

      def listInstanceAttributes(
        request: ListInstanceAttributesRequest
      ): F[ListInstanceAttributesResponse]

      def listInstanceStorageConfigs(
        request: ListInstanceStorageConfigsRequest
      ): F[ListInstanceStorageConfigsResponse]

      def listInstances(
        request: ListInstancesRequest
      ): F[ListInstancesResponse]

      def listIntegrationAssociations(
        request: ListIntegrationAssociationsRequest
      ): F[ListIntegrationAssociationsResponse]

      def listLambdaFunctions(
        request: ListLambdaFunctionsRequest
      ): F[ListLambdaFunctionsResponse]

      def listLexBots(
        request: ListLexBotsRequest
      ): F[ListLexBotsResponse]

      def listPhoneNumbers(
        request: ListPhoneNumbersRequest
      ): F[ListPhoneNumbersResponse]

      def listPrompts(
        request: ListPromptsRequest
      ): F[ListPromptsResponse]

      def listQueueQuickConnects(
        request: ListQueueQuickConnectsRequest
      ): F[ListQueueQuickConnectsResponse]

      def listQueues(
        request: ListQueuesRequest
      ): F[ListQueuesResponse]

      def listQuickConnects(
        request: ListQuickConnectsRequest
      ): F[ListQuickConnectsResponse]

      def listRoutingProfileQueues(
        request: ListRoutingProfileQueuesRequest
      ): F[ListRoutingProfileQueuesResponse]

      def listRoutingProfiles(
        request: ListRoutingProfilesRequest
      ): F[ListRoutingProfilesResponse]

      def listSecurityKeys(
        request: ListSecurityKeysRequest
      ): F[ListSecurityKeysResponse]

      def listSecurityProfiles(
        request: ListSecurityProfilesRequest
      ): F[ListSecurityProfilesResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def listUseCases(
        request: ListUseCasesRequest
      ): F[ListUseCasesResponse]

      def listUserHierarchyGroups(
        request: ListUserHierarchyGroupsRequest
      ): F[ListUserHierarchyGroupsResponse]

      def listUsers(
        request: ListUsersRequest
      ): F[ListUsersResponse]

      def resumeContactRecording(
        request: ResumeContactRecordingRequest
      ): F[ResumeContactRecordingResponse]

      def startChatContact(
        request: StartChatContactRequest
      ): F[StartChatContactResponse]

      def startContactRecording(
        request: StartContactRecordingRequest
      ): F[StartContactRecordingResponse]

      def startOutboundVoiceContact(
        request: StartOutboundVoiceContactRequest
      ): F[StartOutboundVoiceContactResponse]

      def startTaskContact(
        request: StartTaskContactRequest
      ): F[StartTaskContactResponse]

      def stopContact(
        request: StopContactRequest
      ): F[StopContactResponse]

      def stopContactRecording(
        request: StopContactRecordingRequest
      ): F[StopContactRecordingResponse]

      def suspendContactRecording(
        request: SuspendContactRecordingRequest
      ): F[SuspendContactRecordingResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateContactAttributes(
        request: UpdateContactAttributesRequest
      ): F[UpdateContactAttributesResponse]

      def updateContactFlowContent(
        request: UpdateContactFlowContentRequest
      ): F[UpdateContactFlowContentResponse]

      def updateContactFlowName(
        request: UpdateContactFlowNameRequest
      ): F[UpdateContactFlowNameResponse]

      def updateInstanceAttribute(
        request: UpdateInstanceAttributeRequest
      ): F[UpdateInstanceAttributeResponse]

      def updateInstanceStorageConfig(
        request: UpdateInstanceStorageConfigRequest
      ): F[UpdateInstanceStorageConfigResponse]

      def updateQueueHoursOfOperation(
        request: UpdateQueueHoursOfOperationRequest
      ): F[UpdateQueueHoursOfOperationResponse]

      def updateQueueMaxContacts(
        request: UpdateQueueMaxContactsRequest
      ): F[UpdateQueueMaxContactsResponse]

      def updateQueueName(
        request: UpdateQueueNameRequest
      ): F[UpdateQueueNameResponse]

      def updateQueueOutboundCallerConfig(
        request: UpdateQueueOutboundCallerConfigRequest
      ): F[UpdateQueueOutboundCallerConfigResponse]

      def updateQueueStatus(
        request: UpdateQueueStatusRequest
      ): F[UpdateQueueStatusResponse]

      def updateQuickConnectConfig(
        request: UpdateQuickConnectConfigRequest
      ): F[UpdateQuickConnectConfigResponse]

      def updateQuickConnectName(
        request: UpdateQuickConnectNameRequest
      ): F[UpdateQuickConnectNameResponse]

      def updateRoutingProfileConcurrency(
        request: UpdateRoutingProfileConcurrencyRequest
      ): F[UpdateRoutingProfileConcurrencyResponse]

      def updateRoutingProfileDefaultOutboundQueue(
        request: UpdateRoutingProfileDefaultOutboundQueueRequest
      ): F[UpdateRoutingProfileDefaultOutboundQueueResponse]

      def updateRoutingProfileName(
        request: UpdateRoutingProfileNameRequest
      ): F[UpdateRoutingProfileNameResponse]

      def updateRoutingProfileQueues(
        request: UpdateRoutingProfileQueuesRequest
      ): F[UpdateRoutingProfileQueuesResponse]

      def updateUserHierarchy(
        request: UpdateUserHierarchyRequest
      ): F[UpdateUserHierarchyResponse]

      def updateUserHierarchyGroupName(
        request: UpdateUserHierarchyGroupNameRequest
      ): F[UpdateUserHierarchyGroupNameResponse]

      def updateUserHierarchyStructure(
        request: UpdateUserHierarchyStructureRequest
      ): F[UpdateUserHierarchyStructureResponse]

      def updateUserIdentityInfo(
        request: UpdateUserIdentityInfoRequest
      ): F[UpdateUserIdentityInfoResponse]

      def updateUserPhoneConfig(
        request: UpdateUserPhoneConfigRequest
      ): F[UpdateUserPhoneConfigResponse]

      def updateUserRoutingProfile(
        request: UpdateUserRoutingProfileRequest
      ): F[UpdateUserRoutingProfileResponse]

      def updateUserSecurityProfiles(
        request: UpdateUserSecurityProfilesRequest
      ): F[UpdateUserSecurityProfilesResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends ConnectOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AssociateApprovedOriginOp(
      request: AssociateApprovedOriginRequest
    ) extends ConnectOp[AssociateApprovedOriginResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateApprovedOriginResponse] =
        visitor.associateApprovedOrigin(request)
    }

    final case class AssociateBotOp(
      request: AssociateBotRequest
    ) extends ConnectOp[AssociateBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateBotResponse] =
        visitor.associateBot(request)
    }

    final case class AssociateInstanceStorageConfigOp(
      request: AssociateInstanceStorageConfigRequest
    ) extends ConnectOp[AssociateInstanceStorageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateInstanceStorageConfigResponse] =
        visitor.associateInstanceStorageConfig(request)
    }

    final case class AssociateLambdaFunctionOp(
      request: AssociateLambdaFunctionRequest
    ) extends ConnectOp[AssociateLambdaFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateLambdaFunctionResponse] =
        visitor.associateLambdaFunction(request)
    }

    final case class AssociateLexBotOp(
      request: AssociateLexBotRequest
    ) extends ConnectOp[AssociateLexBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateLexBotResponse] =
        visitor.associateLexBot(request)
    }

    final case class AssociateQueueQuickConnectsOp(
      request: AssociateQueueQuickConnectsRequest
    ) extends ConnectOp[AssociateQueueQuickConnectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateQueueQuickConnectsResponse] =
        visitor.associateQueueQuickConnects(request)
    }

    final case class AssociateRoutingProfileQueuesOp(
      request: AssociateRoutingProfileQueuesRequest
    ) extends ConnectOp[AssociateRoutingProfileQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateRoutingProfileQueuesResponse] =
        visitor.associateRoutingProfileQueues(request)
    }

    final case class AssociateSecurityKeyOp(
      request: AssociateSecurityKeyRequest
    ) extends ConnectOp[AssociateSecurityKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AssociateSecurityKeyResponse] =
        visitor.associateSecurityKey(request)
    }

    final case class CreateContactFlowOp(
      request: CreateContactFlowRequest
    ) extends ConnectOp[CreateContactFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateContactFlowResponse] =
        visitor.createContactFlow(request)
    }

    final case class CreateInstanceOp(
      request: CreateInstanceRequest
    ) extends ConnectOp[CreateInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateInstanceResponse] =
        visitor.createInstance(request)
    }

    final case class CreateIntegrationAssociationOp(
      request: CreateIntegrationAssociationRequest
    ) extends ConnectOp[CreateIntegrationAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateIntegrationAssociationResponse] =
        visitor.createIntegrationAssociation(request)
    }

    final case class CreateQueueOp(
      request: CreateQueueRequest
    ) extends ConnectOp[CreateQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQueueResponse] =
        visitor.createQueue(request)
    }

    final case class CreateQuickConnectOp(
      request: CreateQuickConnectRequest
    ) extends ConnectOp[CreateQuickConnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateQuickConnectResponse] =
        visitor.createQuickConnect(request)
    }

    final case class CreateRoutingProfileOp(
      request: CreateRoutingProfileRequest
    ) extends ConnectOp[CreateRoutingProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateRoutingProfileResponse] =
        visitor.createRoutingProfile(request)
    }

    final case class CreateUseCaseOp(
      request: CreateUseCaseRequest
    ) extends ConnectOp[CreateUseCaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUseCaseResponse] =
        visitor.createUseCase(request)
    }

    final case class CreateUserOp(
      request: CreateUserRequest
    ) extends ConnectOp[CreateUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserResponse] =
        visitor.createUser(request)
    }

    final case class CreateUserHierarchyGroupOp(
      request: CreateUserHierarchyGroupRequest
    ) extends ConnectOp[CreateUserHierarchyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateUserHierarchyGroupResponse] =
        visitor.createUserHierarchyGroup(request)
    }

    final case class DeleteInstanceOp(
      request: DeleteInstanceRequest
    ) extends ConnectOp[DeleteInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteInstanceResponse] =
        visitor.deleteInstance(request)
    }

    final case class DeleteIntegrationAssociationOp(
      request: DeleteIntegrationAssociationRequest
    ) extends ConnectOp[DeleteIntegrationAssociationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteIntegrationAssociationResponse] =
        visitor.deleteIntegrationAssociation(request)
    }

    final case class DeleteQuickConnectOp(
      request: DeleteQuickConnectRequest
    ) extends ConnectOp[DeleteQuickConnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteQuickConnectResponse] =
        visitor.deleteQuickConnect(request)
    }

    final case class DeleteUseCaseOp(
      request: DeleteUseCaseRequest
    ) extends ConnectOp[DeleteUseCaseResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUseCaseResponse] =
        visitor.deleteUseCase(request)
    }

    final case class DeleteUserOp(
      request: DeleteUserRequest
    ) extends ConnectOp[DeleteUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserResponse] =
        visitor.deleteUser(request)
    }

    final case class DeleteUserHierarchyGroupOp(
      request: DeleteUserHierarchyGroupRequest
    ) extends ConnectOp[DeleteUserHierarchyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteUserHierarchyGroupResponse] =
        visitor.deleteUserHierarchyGroup(request)
    }

    final case class DescribeContactFlowOp(
      request: DescribeContactFlowRequest
    ) extends ConnectOp[DescribeContactFlowResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeContactFlowResponse] =
        visitor.describeContactFlow(request)
    }

    final case class DescribeHoursOfOperationOp(
      request: DescribeHoursOfOperationRequest
    ) extends ConnectOp[DescribeHoursOfOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeHoursOfOperationResponse] =
        visitor.describeHoursOfOperation(request)
    }

    final case class DescribeInstanceOp(
      request: DescribeInstanceRequest
    ) extends ConnectOp[DescribeInstanceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceResponse] =
        visitor.describeInstance(request)
    }

    final case class DescribeInstanceAttributeOp(
      request: DescribeInstanceAttributeRequest
    ) extends ConnectOp[DescribeInstanceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceAttributeResponse] =
        visitor.describeInstanceAttribute(request)
    }

    final case class DescribeInstanceStorageConfigOp(
      request: DescribeInstanceStorageConfigRequest
    ) extends ConnectOp[DescribeInstanceStorageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstanceStorageConfigResponse] =
        visitor.describeInstanceStorageConfig(request)
    }

    final case class DescribeQueueOp(
      request: DescribeQueueRequest
    ) extends ConnectOp[DescribeQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeQueueResponse] =
        visitor.describeQueue(request)
    }

    final case class DescribeQuickConnectOp(
      request: DescribeQuickConnectRequest
    ) extends ConnectOp[DescribeQuickConnectResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeQuickConnectResponse] =
        visitor.describeQuickConnect(request)
    }

    final case class DescribeRoutingProfileOp(
      request: DescribeRoutingProfileRequest
    ) extends ConnectOp[DescribeRoutingProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRoutingProfileResponse] =
        visitor.describeRoutingProfile(request)
    }

    final case class DescribeUserOp(
      request: DescribeUserRequest
    ) extends ConnectOp[DescribeUserResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserResponse] =
        visitor.describeUser(request)
    }

    final case class DescribeUserHierarchyGroupOp(
      request: DescribeUserHierarchyGroupRequest
    ) extends ConnectOp[DescribeUserHierarchyGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserHierarchyGroupResponse] =
        visitor.describeUserHierarchyGroup(request)
    }

    final case class DescribeUserHierarchyStructureOp(
      request: DescribeUserHierarchyStructureRequest
    ) extends ConnectOp[DescribeUserHierarchyStructureResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeUserHierarchyStructureResponse] =
        visitor.describeUserHierarchyStructure(request)
    }

    final case class DisassociateApprovedOriginOp(
      request: DisassociateApprovedOriginRequest
    ) extends ConnectOp[DisassociateApprovedOriginResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateApprovedOriginResponse] =
        visitor.disassociateApprovedOrigin(request)
    }

    final case class DisassociateBotOp(
      request: DisassociateBotRequest
    ) extends ConnectOp[DisassociateBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateBotResponse] =
        visitor.disassociateBot(request)
    }

    final case class DisassociateInstanceStorageConfigOp(
      request: DisassociateInstanceStorageConfigRequest
    ) extends ConnectOp[DisassociateInstanceStorageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateInstanceStorageConfigResponse] =
        visitor.disassociateInstanceStorageConfig(request)
    }

    final case class DisassociateLambdaFunctionOp(
      request: DisassociateLambdaFunctionRequest
    ) extends ConnectOp[DisassociateLambdaFunctionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateLambdaFunctionResponse] =
        visitor.disassociateLambdaFunction(request)
    }

    final case class DisassociateLexBotOp(
      request: DisassociateLexBotRequest
    ) extends ConnectOp[DisassociateLexBotResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateLexBotResponse] =
        visitor.disassociateLexBot(request)
    }

    final case class DisassociateQueueQuickConnectsOp(
      request: DisassociateQueueQuickConnectsRequest
    ) extends ConnectOp[DisassociateQueueQuickConnectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateQueueQuickConnectsResponse] =
        visitor.disassociateQueueQuickConnects(request)
    }

    final case class DisassociateRoutingProfileQueuesOp(
      request: DisassociateRoutingProfileQueuesRequest
    ) extends ConnectOp[DisassociateRoutingProfileQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateRoutingProfileQueuesResponse] =
        visitor.disassociateRoutingProfileQueues(request)
    }

    final case class DisassociateSecurityKeyOp(
      request: DisassociateSecurityKeyRequest
    ) extends ConnectOp[DisassociateSecurityKeyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DisassociateSecurityKeyResponse] =
        visitor.disassociateSecurityKey(request)
    }

    final case class GetContactAttributesOp(
      request: GetContactAttributesRequest
    ) extends ConnectOp[GetContactAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetContactAttributesResponse] =
        visitor.getContactAttributes(request)
    }

    final case class GetCurrentMetricDataOp(
      request: GetCurrentMetricDataRequest
    ) extends ConnectOp[GetCurrentMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetCurrentMetricDataResponse] =
        visitor.getCurrentMetricData(request)
    }

    final case class GetFederationTokenOp(
      request: GetFederationTokenRequest
    ) extends ConnectOp[GetFederationTokenResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetFederationTokenResponse] =
        visitor.getFederationToken(request)
    }

    final case class GetMetricDataOp(
      request: GetMetricDataRequest
    ) extends ConnectOp[GetMetricDataResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetMetricDataResponse] =
        visitor.getMetricData(request)
    }

    final case class ListApprovedOriginsOp(
      request: ListApprovedOriginsRequest
    ) extends ConnectOp[ListApprovedOriginsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListApprovedOriginsResponse] =
        visitor.listApprovedOrigins(request)
    }

    final case class ListBotsOp(
      request: ListBotsRequest
    ) extends ConnectOp[ListBotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBotsResponse] =
        visitor.listBots(request)
    }

    final case class ListContactFlowsOp(
      request: ListContactFlowsRequest
    ) extends ConnectOp[ListContactFlowsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListContactFlowsResponse] =
        visitor.listContactFlows(request)
    }

    final case class ListHoursOfOperationsOp(
      request: ListHoursOfOperationsRequest
    ) extends ConnectOp[ListHoursOfOperationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListHoursOfOperationsResponse] =
        visitor.listHoursOfOperations(request)
    }

    final case class ListInstanceAttributesOp(
      request: ListInstanceAttributesRequest
    ) extends ConnectOp[ListInstanceAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceAttributesResponse] =
        visitor.listInstanceAttributes(request)
    }

    final case class ListInstanceStorageConfigsOp(
      request: ListInstanceStorageConfigsRequest
    ) extends ConnectOp[ListInstanceStorageConfigsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstanceStorageConfigsResponse] =
        visitor.listInstanceStorageConfigs(request)
    }

    final case class ListInstancesOp(
      request: ListInstancesRequest
    ) extends ConnectOp[ListInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListInstancesResponse] =
        visitor.listInstances(request)
    }

    final case class ListIntegrationAssociationsOp(
      request: ListIntegrationAssociationsRequest
    ) extends ConnectOp[ListIntegrationAssociationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListIntegrationAssociationsResponse] =
        visitor.listIntegrationAssociations(request)
    }

    final case class ListLambdaFunctionsOp(
      request: ListLambdaFunctionsRequest
    ) extends ConnectOp[ListLambdaFunctionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLambdaFunctionsResponse] =
        visitor.listLambdaFunctions(request)
    }

    final case class ListLexBotsOp(
      request: ListLexBotsRequest
    ) extends ConnectOp[ListLexBotsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListLexBotsResponse] =
        visitor.listLexBots(request)
    }

    final case class ListPhoneNumbersOp(
      request: ListPhoneNumbersRequest
    ) extends ConnectOp[ListPhoneNumbersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPhoneNumbersResponse] =
        visitor.listPhoneNumbers(request)
    }

    final case class ListPromptsOp(
      request: ListPromptsRequest
    ) extends ConnectOp[ListPromptsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListPromptsResponse] =
        visitor.listPrompts(request)
    }

    final case class ListQueueQuickConnectsOp(
      request: ListQueueQuickConnectsRequest
    ) extends ConnectOp[ListQueueQuickConnectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueueQuickConnectsResponse] =
        visitor.listQueueQuickConnects(request)
    }

    final case class ListQueuesOp(
      request: ListQueuesRequest
    ) extends ConnectOp[ListQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQueuesResponse] =
        visitor.listQueues(request)
    }

    final case class ListQuickConnectsOp(
      request: ListQuickConnectsRequest
    ) extends ConnectOp[ListQuickConnectsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListQuickConnectsResponse] =
        visitor.listQuickConnects(request)
    }

    final case class ListRoutingProfileQueuesOp(
      request: ListRoutingProfileQueuesRequest
    ) extends ConnectOp[ListRoutingProfileQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoutingProfileQueuesResponse] =
        visitor.listRoutingProfileQueues(request)
    }

    final case class ListRoutingProfilesOp(
      request: ListRoutingProfilesRequest
    ) extends ConnectOp[ListRoutingProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListRoutingProfilesResponse] =
        visitor.listRoutingProfiles(request)
    }

    final case class ListSecurityKeysOp(
      request: ListSecurityKeysRequest
    ) extends ConnectOp[ListSecurityKeysResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecurityKeysResponse] =
        visitor.listSecurityKeys(request)
    }

    final case class ListSecurityProfilesOp(
      request: ListSecurityProfilesRequest
    ) extends ConnectOp[ListSecurityProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListSecurityProfilesResponse] =
        visitor.listSecurityProfiles(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends ConnectOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class ListUseCasesOp(
      request: ListUseCasesRequest
    ) extends ConnectOp[ListUseCasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUseCasesResponse] =
        visitor.listUseCases(request)
    }

    final case class ListUserHierarchyGroupsOp(
      request: ListUserHierarchyGroupsRequest
    ) extends ConnectOp[ListUserHierarchyGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUserHierarchyGroupsResponse] =
        visitor.listUserHierarchyGroups(request)
    }

    final case class ListUsersOp(
      request: ListUsersRequest
    ) extends ConnectOp[ListUsersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListUsersResponse] =
        visitor.listUsers(request)
    }

    final case class ResumeContactRecordingOp(
      request: ResumeContactRecordingRequest
    ) extends ConnectOp[ResumeContactRecordingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeContactRecordingResponse] =
        visitor.resumeContactRecording(request)
    }

    final case class StartChatContactOp(
      request: StartChatContactRequest
    ) extends ConnectOp[StartChatContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartChatContactResponse] =
        visitor.startChatContact(request)
    }

    final case class StartContactRecordingOp(
      request: StartContactRecordingRequest
    ) extends ConnectOp[StartContactRecordingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartContactRecordingResponse] =
        visitor.startContactRecording(request)
    }

    final case class StartOutboundVoiceContactOp(
      request: StartOutboundVoiceContactRequest
    ) extends ConnectOp[StartOutboundVoiceContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartOutboundVoiceContactResponse] =
        visitor.startOutboundVoiceContact(request)
    }

    final case class StartTaskContactOp(
      request: StartTaskContactRequest
    ) extends ConnectOp[StartTaskContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartTaskContactResponse] =
        visitor.startTaskContact(request)
    }

    final case class StopContactOp(
      request: StopContactRequest
    ) extends ConnectOp[StopContactResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopContactResponse] =
        visitor.stopContact(request)
    }

    final case class StopContactRecordingOp(
      request: StopContactRecordingRequest
    ) extends ConnectOp[StopContactRecordingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopContactRecordingResponse] =
        visitor.stopContactRecording(request)
    }

    final case class SuspendContactRecordingOp(
      request: SuspendContactRecordingRequest
    ) extends ConnectOp[SuspendContactRecordingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SuspendContactRecordingResponse] =
        visitor.suspendContactRecording(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends ConnectOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends ConnectOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateContactAttributesOp(
      request: UpdateContactAttributesRequest
    ) extends ConnectOp[UpdateContactAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactAttributesResponse] =
        visitor.updateContactAttributes(request)
    }

    final case class UpdateContactFlowContentOp(
      request: UpdateContactFlowContentRequest
    ) extends ConnectOp[UpdateContactFlowContentResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactFlowContentResponse] =
        visitor.updateContactFlowContent(request)
    }

    final case class UpdateContactFlowNameOp(
      request: UpdateContactFlowNameRequest
    ) extends ConnectOp[UpdateContactFlowNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateContactFlowNameResponse] =
        visitor.updateContactFlowName(request)
    }

    final case class UpdateInstanceAttributeOp(
      request: UpdateInstanceAttributeRequest
    ) extends ConnectOp[UpdateInstanceAttributeResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInstanceAttributeResponse] =
        visitor.updateInstanceAttribute(request)
    }

    final case class UpdateInstanceStorageConfigOp(
      request: UpdateInstanceStorageConfigRequest
    ) extends ConnectOp[UpdateInstanceStorageConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateInstanceStorageConfigResponse] =
        visitor.updateInstanceStorageConfig(request)
    }

    final case class UpdateQueueHoursOfOperationOp(
      request: UpdateQueueHoursOfOperationRequest
    ) extends ConnectOp[UpdateQueueHoursOfOperationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQueueHoursOfOperationResponse] =
        visitor.updateQueueHoursOfOperation(request)
    }

    final case class UpdateQueueMaxContactsOp(
      request: UpdateQueueMaxContactsRequest
    ) extends ConnectOp[UpdateQueueMaxContactsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQueueMaxContactsResponse] =
        visitor.updateQueueMaxContacts(request)
    }

    final case class UpdateQueueNameOp(
      request: UpdateQueueNameRequest
    ) extends ConnectOp[UpdateQueueNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQueueNameResponse] =
        visitor.updateQueueName(request)
    }

    final case class UpdateQueueOutboundCallerConfigOp(
      request: UpdateQueueOutboundCallerConfigRequest
    ) extends ConnectOp[UpdateQueueOutboundCallerConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQueueOutboundCallerConfigResponse] =
        visitor.updateQueueOutboundCallerConfig(request)
    }

    final case class UpdateQueueStatusOp(
      request: UpdateQueueStatusRequest
    ) extends ConnectOp[UpdateQueueStatusResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQueueStatusResponse] =
        visitor.updateQueueStatus(request)
    }

    final case class UpdateQuickConnectConfigOp(
      request: UpdateQuickConnectConfigRequest
    ) extends ConnectOp[UpdateQuickConnectConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQuickConnectConfigResponse] =
        visitor.updateQuickConnectConfig(request)
    }

    final case class UpdateQuickConnectNameOp(
      request: UpdateQuickConnectNameRequest
    ) extends ConnectOp[UpdateQuickConnectNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateQuickConnectNameResponse] =
        visitor.updateQuickConnectName(request)
    }

    final case class UpdateRoutingProfileConcurrencyOp(
      request: UpdateRoutingProfileConcurrencyRequest
    ) extends ConnectOp[UpdateRoutingProfileConcurrencyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoutingProfileConcurrencyResponse] =
        visitor.updateRoutingProfileConcurrency(request)
    }

    final case class UpdateRoutingProfileDefaultOutboundQueueOp(
      request: UpdateRoutingProfileDefaultOutboundQueueRequest
    ) extends ConnectOp[UpdateRoutingProfileDefaultOutboundQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoutingProfileDefaultOutboundQueueResponse] =
        visitor.updateRoutingProfileDefaultOutboundQueue(request)
    }

    final case class UpdateRoutingProfileNameOp(
      request: UpdateRoutingProfileNameRequest
    ) extends ConnectOp[UpdateRoutingProfileNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoutingProfileNameResponse] =
        visitor.updateRoutingProfileName(request)
    }

    final case class UpdateRoutingProfileQueuesOp(
      request: UpdateRoutingProfileQueuesRequest
    ) extends ConnectOp[UpdateRoutingProfileQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRoutingProfileQueuesResponse] =
        visitor.updateRoutingProfileQueues(request)
    }

    final case class UpdateUserHierarchyOp(
      request: UpdateUserHierarchyRequest
    ) extends ConnectOp[UpdateUserHierarchyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserHierarchyResponse] =
        visitor.updateUserHierarchy(request)
    }

    final case class UpdateUserHierarchyGroupNameOp(
      request: UpdateUserHierarchyGroupNameRequest
    ) extends ConnectOp[UpdateUserHierarchyGroupNameResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserHierarchyGroupNameResponse] =
        visitor.updateUserHierarchyGroupName(request)
    }

    final case class UpdateUserHierarchyStructureOp(
      request: UpdateUserHierarchyStructureRequest
    ) extends ConnectOp[UpdateUserHierarchyStructureResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserHierarchyStructureResponse] =
        visitor.updateUserHierarchyStructure(request)
    }

    final case class UpdateUserIdentityInfoOp(
      request: UpdateUserIdentityInfoRequest
    ) extends ConnectOp[UpdateUserIdentityInfoResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserIdentityInfoResponse] =
        visitor.updateUserIdentityInfo(request)
    }

    final case class UpdateUserPhoneConfigOp(
      request: UpdateUserPhoneConfigRequest
    ) extends ConnectOp[UpdateUserPhoneConfigResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserPhoneConfigResponse] =
        visitor.updateUserPhoneConfig(request)
    }

    final case class UpdateUserRoutingProfileOp(
      request: UpdateUserRoutingProfileRequest
    ) extends ConnectOp[UpdateUserRoutingProfileResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserRoutingProfileResponse] =
        visitor.updateUserRoutingProfile(request)
    }

    final case class UpdateUserSecurityProfilesOp(
      request: UpdateUserSecurityProfilesRequest
    ) extends ConnectOp[UpdateUserSecurityProfilesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateUserSecurityProfilesResponse] =
        visitor.updateUserSecurityProfiles(request)
    }
  }

  import ConnectOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[ConnectOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def associateApprovedOrigin(
    request: AssociateApprovedOriginRequest
  ): ConnectIO[AssociateApprovedOriginResponse] =
    FF.liftF(AssociateApprovedOriginOp(request))

  def associateBot(
    request: AssociateBotRequest
  ): ConnectIO[AssociateBotResponse] =
    FF.liftF(AssociateBotOp(request))

  def associateInstanceStorageConfig(
    request: AssociateInstanceStorageConfigRequest
  ): ConnectIO[AssociateInstanceStorageConfigResponse] =
    FF.liftF(AssociateInstanceStorageConfigOp(request))

  def associateLambdaFunction(
    request: AssociateLambdaFunctionRequest
  ): ConnectIO[AssociateLambdaFunctionResponse] =
    FF.liftF(AssociateLambdaFunctionOp(request))

  def associateLexBot(
    request: AssociateLexBotRequest
  ): ConnectIO[AssociateLexBotResponse] =
    FF.liftF(AssociateLexBotOp(request))

  def associateQueueQuickConnects(
    request: AssociateQueueQuickConnectsRequest
  ): ConnectIO[AssociateQueueQuickConnectsResponse] =
    FF.liftF(AssociateQueueQuickConnectsOp(request))

  def associateRoutingProfileQueues(
    request: AssociateRoutingProfileQueuesRequest
  ): ConnectIO[AssociateRoutingProfileQueuesResponse] =
    FF.liftF(AssociateRoutingProfileQueuesOp(request))

  def associateSecurityKey(
    request: AssociateSecurityKeyRequest
  ): ConnectIO[AssociateSecurityKeyResponse] =
    FF.liftF(AssociateSecurityKeyOp(request))

  def createContactFlow(
    request: CreateContactFlowRequest
  ): ConnectIO[CreateContactFlowResponse] =
    FF.liftF(CreateContactFlowOp(request))

  def createInstance(
    request: CreateInstanceRequest
  ): ConnectIO[CreateInstanceResponse] =
    FF.liftF(CreateInstanceOp(request))

  def createIntegrationAssociation(
    request: CreateIntegrationAssociationRequest
  ): ConnectIO[CreateIntegrationAssociationResponse] =
    FF.liftF(CreateIntegrationAssociationOp(request))

  def createQueue(
    request: CreateQueueRequest
  ): ConnectIO[CreateQueueResponse] =
    FF.liftF(CreateQueueOp(request))

  def createQuickConnect(
    request: CreateQuickConnectRequest
  ): ConnectIO[CreateQuickConnectResponse] =
    FF.liftF(CreateQuickConnectOp(request))

  def createRoutingProfile(
    request: CreateRoutingProfileRequest
  ): ConnectIO[CreateRoutingProfileResponse] =
    FF.liftF(CreateRoutingProfileOp(request))

  def createUseCase(
    request: CreateUseCaseRequest
  ): ConnectIO[CreateUseCaseResponse] =
    FF.liftF(CreateUseCaseOp(request))

  def createUser(
    request: CreateUserRequest
  ): ConnectIO[CreateUserResponse] =
    FF.liftF(CreateUserOp(request))

  def createUserHierarchyGroup(
    request: CreateUserHierarchyGroupRequest
  ): ConnectIO[CreateUserHierarchyGroupResponse] =
    FF.liftF(CreateUserHierarchyGroupOp(request))

  def deleteInstance(
    request: DeleteInstanceRequest
  ): ConnectIO[DeleteInstanceResponse] =
    FF.liftF(DeleteInstanceOp(request))

  def deleteIntegrationAssociation(
    request: DeleteIntegrationAssociationRequest
  ): ConnectIO[DeleteIntegrationAssociationResponse] =
    FF.liftF(DeleteIntegrationAssociationOp(request))

  def deleteQuickConnect(
    request: DeleteQuickConnectRequest
  ): ConnectIO[DeleteQuickConnectResponse] =
    FF.liftF(DeleteQuickConnectOp(request))

  def deleteUseCase(
    request: DeleteUseCaseRequest
  ): ConnectIO[DeleteUseCaseResponse] =
    FF.liftF(DeleteUseCaseOp(request))

  def deleteUser(
    request: DeleteUserRequest
  ): ConnectIO[DeleteUserResponse] =
    FF.liftF(DeleteUserOp(request))

  def deleteUserHierarchyGroup(
    request: DeleteUserHierarchyGroupRequest
  ): ConnectIO[DeleteUserHierarchyGroupResponse] =
    FF.liftF(DeleteUserHierarchyGroupOp(request))

  def describeContactFlow(
    request: DescribeContactFlowRequest
  ): ConnectIO[DescribeContactFlowResponse] =
    FF.liftF(DescribeContactFlowOp(request))

  def describeHoursOfOperation(
    request: DescribeHoursOfOperationRequest
  ): ConnectIO[DescribeHoursOfOperationResponse] =
    FF.liftF(DescribeHoursOfOperationOp(request))

  def describeInstance(
    request: DescribeInstanceRequest
  ): ConnectIO[DescribeInstanceResponse] =
    FF.liftF(DescribeInstanceOp(request))

  def describeInstanceAttribute(
    request: DescribeInstanceAttributeRequest
  ): ConnectIO[DescribeInstanceAttributeResponse] =
    FF.liftF(DescribeInstanceAttributeOp(request))

  def describeInstanceStorageConfig(
    request: DescribeInstanceStorageConfigRequest
  ): ConnectIO[DescribeInstanceStorageConfigResponse] =
    FF.liftF(DescribeInstanceStorageConfigOp(request))

  def describeQueue(
    request: DescribeQueueRequest
  ): ConnectIO[DescribeQueueResponse] =
    FF.liftF(DescribeQueueOp(request))

  def describeQuickConnect(
    request: DescribeQuickConnectRequest
  ): ConnectIO[DescribeQuickConnectResponse] =
    FF.liftF(DescribeQuickConnectOp(request))

  def describeRoutingProfile(
    request: DescribeRoutingProfileRequest
  ): ConnectIO[DescribeRoutingProfileResponse] =
    FF.liftF(DescribeRoutingProfileOp(request))

  def describeUser(
    request: DescribeUserRequest
  ): ConnectIO[DescribeUserResponse] =
    FF.liftF(DescribeUserOp(request))

  def describeUserHierarchyGroup(
    request: DescribeUserHierarchyGroupRequest
  ): ConnectIO[DescribeUserHierarchyGroupResponse] =
    FF.liftF(DescribeUserHierarchyGroupOp(request))

  def describeUserHierarchyStructure(
    request: DescribeUserHierarchyStructureRequest
  ): ConnectIO[DescribeUserHierarchyStructureResponse] =
    FF.liftF(DescribeUserHierarchyStructureOp(request))

  def disassociateApprovedOrigin(
    request: DisassociateApprovedOriginRequest
  ): ConnectIO[DisassociateApprovedOriginResponse] =
    FF.liftF(DisassociateApprovedOriginOp(request))

  def disassociateBot(
    request: DisassociateBotRequest
  ): ConnectIO[DisassociateBotResponse] =
    FF.liftF(DisassociateBotOp(request))

  def disassociateInstanceStorageConfig(
    request: DisassociateInstanceStorageConfigRequest
  ): ConnectIO[DisassociateInstanceStorageConfigResponse] =
    FF.liftF(DisassociateInstanceStorageConfigOp(request))

  def disassociateLambdaFunction(
    request: DisassociateLambdaFunctionRequest
  ): ConnectIO[DisassociateLambdaFunctionResponse] =
    FF.liftF(DisassociateLambdaFunctionOp(request))

  def disassociateLexBot(
    request: DisassociateLexBotRequest
  ): ConnectIO[DisassociateLexBotResponse] =
    FF.liftF(DisassociateLexBotOp(request))

  def disassociateQueueQuickConnects(
    request: DisassociateQueueQuickConnectsRequest
  ): ConnectIO[DisassociateQueueQuickConnectsResponse] =
    FF.liftF(DisassociateQueueQuickConnectsOp(request))

  def disassociateRoutingProfileQueues(
    request: DisassociateRoutingProfileQueuesRequest
  ): ConnectIO[DisassociateRoutingProfileQueuesResponse] =
    FF.liftF(DisassociateRoutingProfileQueuesOp(request))

  def disassociateSecurityKey(
    request: DisassociateSecurityKeyRequest
  ): ConnectIO[DisassociateSecurityKeyResponse] =
    FF.liftF(DisassociateSecurityKeyOp(request))

  def getContactAttributes(
    request: GetContactAttributesRequest
  ): ConnectIO[GetContactAttributesResponse] =
    FF.liftF(GetContactAttributesOp(request))

  def getCurrentMetricData(
    request: GetCurrentMetricDataRequest
  ): ConnectIO[GetCurrentMetricDataResponse] =
    FF.liftF(GetCurrentMetricDataOp(request))

  def getFederationToken(
    request: GetFederationTokenRequest
  ): ConnectIO[GetFederationTokenResponse] =
    FF.liftF(GetFederationTokenOp(request))

  def getMetricData(
    request: GetMetricDataRequest
  ): ConnectIO[GetMetricDataResponse] =
    FF.liftF(GetMetricDataOp(request))

  def listApprovedOrigins(
    request: ListApprovedOriginsRequest
  ): ConnectIO[ListApprovedOriginsResponse] =
    FF.liftF(ListApprovedOriginsOp(request))

  def listBots(
    request: ListBotsRequest
  ): ConnectIO[ListBotsResponse] =
    FF.liftF(ListBotsOp(request))

  def listContactFlows(
    request: ListContactFlowsRequest
  ): ConnectIO[ListContactFlowsResponse] =
    FF.liftF(ListContactFlowsOp(request))

  def listHoursOfOperations(
    request: ListHoursOfOperationsRequest
  ): ConnectIO[ListHoursOfOperationsResponse] =
    FF.liftF(ListHoursOfOperationsOp(request))

  def listInstanceAttributes(
    request: ListInstanceAttributesRequest
  ): ConnectIO[ListInstanceAttributesResponse] =
    FF.liftF(ListInstanceAttributesOp(request))

  def listInstanceStorageConfigs(
    request: ListInstanceStorageConfigsRequest
  ): ConnectIO[ListInstanceStorageConfigsResponse] =
    FF.liftF(ListInstanceStorageConfigsOp(request))

  def listInstances(
    request: ListInstancesRequest
  ): ConnectIO[ListInstancesResponse] =
    FF.liftF(ListInstancesOp(request))

  def listIntegrationAssociations(
    request: ListIntegrationAssociationsRequest
  ): ConnectIO[ListIntegrationAssociationsResponse] =
    FF.liftF(ListIntegrationAssociationsOp(request))

  def listLambdaFunctions(
    request: ListLambdaFunctionsRequest
  ): ConnectIO[ListLambdaFunctionsResponse] =
    FF.liftF(ListLambdaFunctionsOp(request))

  def listLexBots(
    request: ListLexBotsRequest
  ): ConnectIO[ListLexBotsResponse] =
    FF.liftF(ListLexBotsOp(request))

  def listPhoneNumbers(
    request: ListPhoneNumbersRequest
  ): ConnectIO[ListPhoneNumbersResponse] =
    FF.liftF(ListPhoneNumbersOp(request))

  def listPrompts(
    request: ListPromptsRequest
  ): ConnectIO[ListPromptsResponse] =
    FF.liftF(ListPromptsOp(request))

  def listQueueQuickConnects(
    request: ListQueueQuickConnectsRequest
  ): ConnectIO[ListQueueQuickConnectsResponse] =
    FF.liftF(ListQueueQuickConnectsOp(request))

  def listQueues(
    request: ListQueuesRequest
  ): ConnectIO[ListQueuesResponse] =
    FF.liftF(ListQueuesOp(request))

  def listQuickConnects(
    request: ListQuickConnectsRequest
  ): ConnectIO[ListQuickConnectsResponse] =
    FF.liftF(ListQuickConnectsOp(request))

  def listRoutingProfileQueues(
    request: ListRoutingProfileQueuesRequest
  ): ConnectIO[ListRoutingProfileQueuesResponse] =
    FF.liftF(ListRoutingProfileQueuesOp(request))

  def listRoutingProfiles(
    request: ListRoutingProfilesRequest
  ): ConnectIO[ListRoutingProfilesResponse] =
    FF.liftF(ListRoutingProfilesOp(request))

  def listSecurityKeys(
    request: ListSecurityKeysRequest
  ): ConnectIO[ListSecurityKeysResponse] =
    FF.liftF(ListSecurityKeysOp(request))

  def listSecurityProfiles(
    request: ListSecurityProfilesRequest
  ): ConnectIO[ListSecurityProfilesResponse] =
    FF.liftF(ListSecurityProfilesOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): ConnectIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def listUseCases(
    request: ListUseCasesRequest
  ): ConnectIO[ListUseCasesResponse] =
    FF.liftF(ListUseCasesOp(request))

  def listUserHierarchyGroups(
    request: ListUserHierarchyGroupsRequest
  ): ConnectIO[ListUserHierarchyGroupsResponse] =
    FF.liftF(ListUserHierarchyGroupsOp(request))

  def listUsers(
    request: ListUsersRequest
  ): ConnectIO[ListUsersResponse] =
    FF.liftF(ListUsersOp(request))

  def resumeContactRecording(
    request: ResumeContactRecordingRequest
  ): ConnectIO[ResumeContactRecordingResponse] =
    FF.liftF(ResumeContactRecordingOp(request))

  def startChatContact(
    request: StartChatContactRequest
  ): ConnectIO[StartChatContactResponse] =
    FF.liftF(StartChatContactOp(request))

  def startContactRecording(
    request: StartContactRecordingRequest
  ): ConnectIO[StartContactRecordingResponse] =
    FF.liftF(StartContactRecordingOp(request))

  def startOutboundVoiceContact(
    request: StartOutboundVoiceContactRequest
  ): ConnectIO[StartOutboundVoiceContactResponse] =
    FF.liftF(StartOutboundVoiceContactOp(request))

  def startTaskContact(
    request: StartTaskContactRequest
  ): ConnectIO[StartTaskContactResponse] =
    FF.liftF(StartTaskContactOp(request))

  def stopContact(
    request: StopContactRequest
  ): ConnectIO[StopContactResponse] =
    FF.liftF(StopContactOp(request))

  def stopContactRecording(
    request: StopContactRecordingRequest
  ): ConnectIO[StopContactRecordingResponse] =
    FF.liftF(StopContactRecordingOp(request))

  def suspendContactRecording(
    request: SuspendContactRecordingRequest
  ): ConnectIO[SuspendContactRecordingResponse] =
    FF.liftF(SuspendContactRecordingOp(request))

  def tagResource(
    request: TagResourceRequest
  ): ConnectIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): ConnectIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateContactAttributes(
    request: UpdateContactAttributesRequest
  ): ConnectIO[UpdateContactAttributesResponse] =
    FF.liftF(UpdateContactAttributesOp(request))

  def updateContactFlowContent(
    request: UpdateContactFlowContentRequest
  ): ConnectIO[UpdateContactFlowContentResponse] =
    FF.liftF(UpdateContactFlowContentOp(request))

  def updateContactFlowName(
    request: UpdateContactFlowNameRequest
  ): ConnectIO[UpdateContactFlowNameResponse] =
    FF.liftF(UpdateContactFlowNameOp(request))

  def updateInstanceAttribute(
    request: UpdateInstanceAttributeRequest
  ): ConnectIO[UpdateInstanceAttributeResponse] =
    FF.liftF(UpdateInstanceAttributeOp(request))

  def updateInstanceStorageConfig(
    request: UpdateInstanceStorageConfigRequest
  ): ConnectIO[UpdateInstanceStorageConfigResponse] =
    FF.liftF(UpdateInstanceStorageConfigOp(request))

  def updateQueueHoursOfOperation(
    request: UpdateQueueHoursOfOperationRequest
  ): ConnectIO[UpdateQueueHoursOfOperationResponse] =
    FF.liftF(UpdateQueueHoursOfOperationOp(request))

  def updateQueueMaxContacts(
    request: UpdateQueueMaxContactsRequest
  ): ConnectIO[UpdateQueueMaxContactsResponse] =
    FF.liftF(UpdateQueueMaxContactsOp(request))

  def updateQueueName(
    request: UpdateQueueNameRequest
  ): ConnectIO[UpdateQueueNameResponse] =
    FF.liftF(UpdateQueueNameOp(request))

  def updateQueueOutboundCallerConfig(
    request: UpdateQueueOutboundCallerConfigRequest
  ): ConnectIO[UpdateQueueOutboundCallerConfigResponse] =
    FF.liftF(UpdateQueueOutboundCallerConfigOp(request))

  def updateQueueStatus(
    request: UpdateQueueStatusRequest
  ): ConnectIO[UpdateQueueStatusResponse] =
    FF.liftF(UpdateQueueStatusOp(request))

  def updateQuickConnectConfig(
    request: UpdateQuickConnectConfigRequest
  ): ConnectIO[UpdateQuickConnectConfigResponse] =
    FF.liftF(UpdateQuickConnectConfigOp(request))

  def updateQuickConnectName(
    request: UpdateQuickConnectNameRequest
  ): ConnectIO[UpdateQuickConnectNameResponse] =
    FF.liftF(UpdateQuickConnectNameOp(request))

  def updateRoutingProfileConcurrency(
    request: UpdateRoutingProfileConcurrencyRequest
  ): ConnectIO[UpdateRoutingProfileConcurrencyResponse] =
    FF.liftF(UpdateRoutingProfileConcurrencyOp(request))

  def updateRoutingProfileDefaultOutboundQueue(
    request: UpdateRoutingProfileDefaultOutboundQueueRequest
  ): ConnectIO[UpdateRoutingProfileDefaultOutboundQueueResponse] =
    FF.liftF(UpdateRoutingProfileDefaultOutboundQueueOp(request))

  def updateRoutingProfileName(
    request: UpdateRoutingProfileNameRequest
  ): ConnectIO[UpdateRoutingProfileNameResponse] =
    FF.liftF(UpdateRoutingProfileNameOp(request))

  def updateRoutingProfileQueues(
    request: UpdateRoutingProfileQueuesRequest
  ): ConnectIO[UpdateRoutingProfileQueuesResponse] =
    FF.liftF(UpdateRoutingProfileQueuesOp(request))

  def updateUserHierarchy(
    request: UpdateUserHierarchyRequest
  ): ConnectIO[UpdateUserHierarchyResponse] =
    FF.liftF(UpdateUserHierarchyOp(request))

  def updateUserHierarchyGroupName(
    request: UpdateUserHierarchyGroupNameRequest
  ): ConnectIO[UpdateUserHierarchyGroupNameResponse] =
    FF.liftF(UpdateUserHierarchyGroupNameOp(request))

  def updateUserHierarchyStructure(
    request: UpdateUserHierarchyStructureRequest
  ): ConnectIO[UpdateUserHierarchyStructureResponse] =
    FF.liftF(UpdateUserHierarchyStructureOp(request))

  def updateUserIdentityInfo(
    request: UpdateUserIdentityInfoRequest
  ): ConnectIO[UpdateUserIdentityInfoResponse] =
    FF.liftF(UpdateUserIdentityInfoOp(request))

  def updateUserPhoneConfig(
    request: UpdateUserPhoneConfigRequest
  ): ConnectIO[UpdateUserPhoneConfigResponse] =
    FF.liftF(UpdateUserPhoneConfigOp(request))

  def updateUserRoutingProfile(
    request: UpdateUserRoutingProfileRequest
  ): ConnectIO[UpdateUserRoutingProfileResponse] =
    FF.liftF(UpdateUserRoutingProfileOp(request))

  def updateUserSecurityProfiles(
    request: UpdateUserSecurityProfilesRequest
  ): ConnectIO[UpdateUserSecurityProfilesResponse] =
    FF.liftF(UpdateUserSecurityProfilesOp(request))
}
