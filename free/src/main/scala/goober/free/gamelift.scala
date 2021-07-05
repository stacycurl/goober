package goober.free

import scala.language.higherKinds

import cats.free.{Free => FF}
import cats.~>
import cats.data.Kleisli
import software.amazon.awssdk.services.gamelift.GameLiftClient
import software.amazon.awssdk.services.gamelift.model._
import java.nio.file.Path
import software.amazon.awssdk.core.sync.RequestBody

object gamelift { module =>

  // Free monad over GameLiftOp
  type GameLiftIO[A] = FF[GameLiftOp, A]

  sealed trait GameLiftOp[A] {
    def visit[F[_]](visitor: GameLiftOp.Visitor[F]): F[A]
  }

  object GameLiftOp {
    // Given a GameLiftClient we can embed a GameLiftIO program in any algebra that understands embedding.
    implicit val GameLiftOpEmbeddable: Embeddable[GameLiftOp, GameLiftClient] = new Embeddable[GameLiftOp, GameLiftClient] {
      def embed[A](client: GameLiftClient, io: GameLiftIO[A]): Embedded[A] = Embedded.GameLift(client, io)
    }

    object Visitor {
      trait KleisliVisitor[M[_]] extends GameLiftOp.Visitor[Kleisli[M, GameLiftClient, *]] {
        def acceptMatch(
          request: AcceptMatchRequest
        ): Kleisli[M, GameLiftClient, AcceptMatchResponse] =
          primitive(_.acceptMatch(request))

        def claimGameServer(
          request: ClaimGameServerRequest
        ): Kleisli[M, GameLiftClient, ClaimGameServerResponse] =
          primitive(_.claimGameServer(request))

        def createAlias(
          request: CreateAliasRequest
        ): Kleisli[M, GameLiftClient, CreateAliasResponse] =
          primitive(_.createAlias(request))

        def createBuild(
          request: CreateBuildRequest
        ): Kleisli[M, GameLiftClient, CreateBuildResponse] =
          primitive(_.createBuild(request))

        def createFleet(
          request: CreateFleetRequest
        ): Kleisli[M, GameLiftClient, CreateFleetResponse] =
          primitive(_.createFleet(request))

        def createFleetLocations(
          request: CreateFleetLocationsRequest
        ): Kleisli[M, GameLiftClient, CreateFleetLocationsResponse] =
          primitive(_.createFleetLocations(request))

        def createGameServerGroup(
          request: CreateGameServerGroupRequest
        ): Kleisli[M, GameLiftClient, CreateGameServerGroupResponse] =
          primitive(_.createGameServerGroup(request))

        def createGameSession(
          request: CreateGameSessionRequest
        ): Kleisli[M, GameLiftClient, CreateGameSessionResponse] =
          primitive(_.createGameSession(request))

        def createGameSessionQueue(
          request: CreateGameSessionQueueRequest
        ): Kleisli[M, GameLiftClient, CreateGameSessionQueueResponse] =
          primitive(_.createGameSessionQueue(request))

        def createMatchmakingConfiguration(
          request: CreateMatchmakingConfigurationRequest
        ): Kleisli[M, GameLiftClient, CreateMatchmakingConfigurationResponse] =
          primitive(_.createMatchmakingConfiguration(request))

        def createMatchmakingRuleSet(
          request: CreateMatchmakingRuleSetRequest
        ): Kleisli[M, GameLiftClient, CreateMatchmakingRuleSetResponse] =
          primitive(_.createMatchmakingRuleSet(request))

        def createPlayerSession(
          request: CreatePlayerSessionRequest
        ): Kleisli[M, GameLiftClient, CreatePlayerSessionResponse] =
          primitive(_.createPlayerSession(request))

        def createPlayerSessions(
          request: CreatePlayerSessionsRequest
        ): Kleisli[M, GameLiftClient, CreatePlayerSessionsResponse] =
          primitive(_.createPlayerSessions(request))

        def createScript(
          request: CreateScriptRequest
        ): Kleisli[M, GameLiftClient, CreateScriptResponse] =
          primitive(_.createScript(request))

        def createVpcPeeringAuthorization(
          request: CreateVpcPeeringAuthorizationRequest
        ): Kleisli[M, GameLiftClient, CreateVpcPeeringAuthorizationResponse] =
          primitive(_.createVpcPeeringAuthorization(request))

        def createVpcPeeringConnection(
          request: CreateVpcPeeringConnectionRequest
        ): Kleisli[M, GameLiftClient, CreateVpcPeeringConnectionResponse] =
          primitive(_.createVpcPeeringConnection(request))

        def deleteAlias(
          request: DeleteAliasRequest
        ): Kleisli[M, GameLiftClient, DeleteAliasResponse] =
          primitive(_.deleteAlias(request))

        def deleteBuild(
          request: DeleteBuildRequest
        ): Kleisli[M, GameLiftClient, DeleteBuildResponse] =
          primitive(_.deleteBuild(request))

        def deleteFleet(
          request: DeleteFleetRequest
        ): Kleisli[M, GameLiftClient, DeleteFleetResponse] =
          primitive(_.deleteFleet(request))

        def deleteFleetLocations(
          request: DeleteFleetLocationsRequest
        ): Kleisli[M, GameLiftClient, DeleteFleetLocationsResponse] =
          primitive(_.deleteFleetLocations(request))

        def deleteGameServerGroup(
          request: DeleteGameServerGroupRequest
        ): Kleisli[M, GameLiftClient, DeleteGameServerGroupResponse] =
          primitive(_.deleteGameServerGroup(request))

        def deleteGameSessionQueue(
          request: DeleteGameSessionQueueRequest
        ): Kleisli[M, GameLiftClient, DeleteGameSessionQueueResponse] =
          primitive(_.deleteGameSessionQueue(request))

        def deleteMatchmakingConfiguration(
          request: DeleteMatchmakingConfigurationRequest
        ): Kleisli[M, GameLiftClient, DeleteMatchmakingConfigurationResponse] =
          primitive(_.deleteMatchmakingConfiguration(request))

        def deleteMatchmakingRuleSet(
          request: DeleteMatchmakingRuleSetRequest
        ): Kleisli[M, GameLiftClient, DeleteMatchmakingRuleSetResponse] =
          primitive(_.deleteMatchmakingRuleSet(request))

        def deleteScalingPolicy(
          request: DeleteScalingPolicyRequest
        ): Kleisli[M, GameLiftClient, DeleteScalingPolicyResponse] =
          primitive(_.deleteScalingPolicy(request))

        def deleteScript(
          request: DeleteScriptRequest
        ): Kleisli[M, GameLiftClient, DeleteScriptResponse] =
          primitive(_.deleteScript(request))

        def deleteVpcPeeringAuthorization(
          request: DeleteVpcPeeringAuthorizationRequest
        ): Kleisli[M, GameLiftClient, DeleteVpcPeeringAuthorizationResponse] =
          primitive(_.deleteVpcPeeringAuthorization(request))

        def deleteVpcPeeringConnection(
          request: DeleteVpcPeeringConnectionRequest
        ): Kleisli[M, GameLiftClient, DeleteVpcPeeringConnectionResponse] =
          primitive(_.deleteVpcPeeringConnection(request))

        def deregisterGameServer(
          request: DeregisterGameServerRequest
        ): Kleisli[M, GameLiftClient, DeregisterGameServerResponse] =
          primitive(_.deregisterGameServer(request))

        def describeAlias(
          request: DescribeAliasRequest
        ): Kleisli[M, GameLiftClient, DescribeAliasResponse] =
          primitive(_.describeAlias(request))

        def describeBuild(
          request: DescribeBuildRequest
        ): Kleisli[M, GameLiftClient, DescribeBuildResponse] =
          primitive(_.describeBuild(request))

        def describeEC2InstanceLimits(
          request: DescribeEc2InstanceLimitsRequest
        ): Kleisli[M, GameLiftClient, DescribeEc2InstanceLimitsResponse] =
          primitive(_.describeEC2InstanceLimits(request))

        def describeFleetAttributes(
          request: DescribeFleetAttributesRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetAttributesResponse] =
          primitive(_.describeFleetAttributes(request))

        def describeFleetCapacity(
          request: DescribeFleetCapacityRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetCapacityResponse] =
          primitive(_.describeFleetCapacity(request))

        def describeFleetEvents(
          request: DescribeFleetEventsRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetEventsResponse] =
          primitive(_.describeFleetEvents(request))

        def describeFleetLocationAttributes(
          request: DescribeFleetLocationAttributesRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetLocationAttributesResponse] =
          primitive(_.describeFleetLocationAttributes(request))

        def describeFleetLocationCapacity(
          request: DescribeFleetLocationCapacityRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetLocationCapacityResponse] =
          primitive(_.describeFleetLocationCapacity(request))

        def describeFleetLocationUtilization(
          request: DescribeFleetLocationUtilizationRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetLocationUtilizationResponse] =
          primitive(_.describeFleetLocationUtilization(request))

        def describeFleetPortSettings(
          request: DescribeFleetPortSettingsRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetPortSettingsResponse] =
          primitive(_.describeFleetPortSettings(request))

        def describeFleetUtilization(
          request: DescribeFleetUtilizationRequest
        ): Kleisli[M, GameLiftClient, DescribeFleetUtilizationResponse] =
          primitive(_.describeFleetUtilization(request))

        def describeGameServer(
          request: DescribeGameServerRequest
        ): Kleisli[M, GameLiftClient, DescribeGameServerResponse] =
          primitive(_.describeGameServer(request))

        def describeGameServerGroup(
          request: DescribeGameServerGroupRequest
        ): Kleisli[M, GameLiftClient, DescribeGameServerGroupResponse] =
          primitive(_.describeGameServerGroup(request))

        def describeGameServerInstances(
          request: DescribeGameServerInstancesRequest
        ): Kleisli[M, GameLiftClient, DescribeGameServerInstancesResponse] =
          primitive(_.describeGameServerInstances(request))

        def describeGameSessionDetails(
          request: DescribeGameSessionDetailsRequest
        ): Kleisli[M, GameLiftClient, DescribeGameSessionDetailsResponse] =
          primitive(_.describeGameSessionDetails(request))

        def describeGameSessionPlacement(
          request: DescribeGameSessionPlacementRequest
        ): Kleisli[M, GameLiftClient, DescribeGameSessionPlacementResponse] =
          primitive(_.describeGameSessionPlacement(request))

        def describeGameSessionQueues(
          request: DescribeGameSessionQueuesRequest
        ): Kleisli[M, GameLiftClient, DescribeGameSessionQueuesResponse] =
          primitive(_.describeGameSessionQueues(request))

        def describeGameSessions(
          request: DescribeGameSessionsRequest
        ): Kleisli[M, GameLiftClient, DescribeGameSessionsResponse] =
          primitive(_.describeGameSessions(request))

        def describeInstances(
          request: DescribeInstancesRequest
        ): Kleisli[M, GameLiftClient, DescribeInstancesResponse] =
          primitive(_.describeInstances(request))

        def describeMatchmaking(
          request: DescribeMatchmakingRequest
        ): Kleisli[M, GameLiftClient, DescribeMatchmakingResponse] =
          primitive(_.describeMatchmaking(request))

        def describeMatchmakingConfigurations(
          request: DescribeMatchmakingConfigurationsRequest
        ): Kleisli[M, GameLiftClient, DescribeMatchmakingConfigurationsResponse] =
          primitive(_.describeMatchmakingConfigurations(request))

        def describeMatchmakingRuleSets(
          request: DescribeMatchmakingRuleSetsRequest
        ): Kleisli[M, GameLiftClient, DescribeMatchmakingRuleSetsResponse] =
          primitive(_.describeMatchmakingRuleSets(request))

        def describePlayerSessions(
          request: DescribePlayerSessionsRequest
        ): Kleisli[M, GameLiftClient, DescribePlayerSessionsResponse] =
          primitive(_.describePlayerSessions(request))

        def describeRuntimeConfiguration(
          request: DescribeRuntimeConfigurationRequest
        ): Kleisli[M, GameLiftClient, DescribeRuntimeConfigurationResponse] =
          primitive(_.describeRuntimeConfiguration(request))

        def describeScalingPolicies(
          request: DescribeScalingPoliciesRequest
        ): Kleisli[M, GameLiftClient, DescribeScalingPoliciesResponse] =
          primitive(_.describeScalingPolicies(request))

        def describeScript(
          request: DescribeScriptRequest
        ): Kleisli[M, GameLiftClient, DescribeScriptResponse] =
          primitive(_.describeScript(request))

        def describeVpcPeeringAuthorizations(
          request: DescribeVpcPeeringAuthorizationsRequest
        ): Kleisli[M, GameLiftClient, DescribeVpcPeeringAuthorizationsResponse] =
          primitive(_.describeVpcPeeringAuthorizations(request))

        def describeVpcPeeringConnections(
          request: DescribeVpcPeeringConnectionsRequest
        ): Kleisli[M, GameLiftClient, DescribeVpcPeeringConnectionsResponse] =
          primitive(_.describeVpcPeeringConnections(request))

        def getGameSessionLogUrl(
          request: GetGameSessionLogUrlRequest
        ): Kleisli[M, GameLiftClient, GetGameSessionLogUrlResponse] =
          primitive(_.getGameSessionLogUrl(request))

        def getInstanceAccess(
          request: GetInstanceAccessRequest
        ): Kleisli[M, GameLiftClient, GetInstanceAccessResponse] =
          primitive(_.getInstanceAccess(request))

        def listAliases(
          request: ListAliasesRequest
        ): Kleisli[M, GameLiftClient, ListAliasesResponse] =
          primitive(_.listAliases(request))

        def listBuilds(
          request: ListBuildsRequest
        ): Kleisli[M, GameLiftClient, ListBuildsResponse] =
          primitive(_.listBuilds(request))

        def listFleets(
          request: ListFleetsRequest
        ): Kleisli[M, GameLiftClient, ListFleetsResponse] =
          primitive(_.listFleets(request))

        def listGameServerGroups(
          request: ListGameServerGroupsRequest
        ): Kleisli[M, GameLiftClient, ListGameServerGroupsResponse] =
          primitive(_.listGameServerGroups(request))

        def listGameServers(
          request: ListGameServersRequest
        ): Kleisli[M, GameLiftClient, ListGameServersResponse] =
          primitive(_.listGameServers(request))

        def listScripts(
          request: ListScriptsRequest
        ): Kleisli[M, GameLiftClient, ListScriptsResponse] =
          primitive(_.listScripts(request))

        def listTagsForResource(
          request: ListTagsForResourceRequest
        ): Kleisli[M, GameLiftClient, ListTagsForResourceResponse] =
          primitive(_.listTagsForResource(request))

        def putScalingPolicy(
          request: PutScalingPolicyRequest
        ): Kleisli[M, GameLiftClient, PutScalingPolicyResponse] =
          primitive(_.putScalingPolicy(request))

        def registerGameServer(
          request: RegisterGameServerRequest
        ): Kleisli[M, GameLiftClient, RegisterGameServerResponse] =
          primitive(_.registerGameServer(request))

        def requestUploadCredentials(
          request: RequestUploadCredentialsRequest
        ): Kleisli[M, GameLiftClient, RequestUploadCredentialsResponse] =
          primitive(_.requestUploadCredentials(request))

        def resolveAlias(
          request: ResolveAliasRequest
        ): Kleisli[M, GameLiftClient, ResolveAliasResponse] =
          primitive(_.resolveAlias(request))

        def resumeGameServerGroup(
          request: ResumeGameServerGroupRequest
        ): Kleisli[M, GameLiftClient, ResumeGameServerGroupResponse] =
          primitive(_.resumeGameServerGroup(request))

        def searchGameSessions(
          request: SearchGameSessionsRequest
        ): Kleisli[M, GameLiftClient, SearchGameSessionsResponse] =
          primitive(_.searchGameSessions(request))

        def startFleetActions(
          request: StartFleetActionsRequest
        ): Kleisli[M, GameLiftClient, StartFleetActionsResponse] =
          primitive(_.startFleetActions(request))

        def startGameSessionPlacement(
          request: StartGameSessionPlacementRequest
        ): Kleisli[M, GameLiftClient, StartGameSessionPlacementResponse] =
          primitive(_.startGameSessionPlacement(request))

        def startMatchBackfill(
          request: StartMatchBackfillRequest
        ): Kleisli[M, GameLiftClient, StartMatchBackfillResponse] =
          primitive(_.startMatchBackfill(request))

        def startMatchmaking(
          request: StartMatchmakingRequest
        ): Kleisli[M, GameLiftClient, StartMatchmakingResponse] =
          primitive(_.startMatchmaking(request))

        def stopFleetActions(
          request: StopFleetActionsRequest
        ): Kleisli[M, GameLiftClient, StopFleetActionsResponse] =
          primitive(_.stopFleetActions(request))

        def stopGameSessionPlacement(
          request: StopGameSessionPlacementRequest
        ): Kleisli[M, GameLiftClient, StopGameSessionPlacementResponse] =
          primitive(_.stopGameSessionPlacement(request))

        def stopMatchmaking(
          request: StopMatchmakingRequest
        ): Kleisli[M, GameLiftClient, StopMatchmakingResponse] =
          primitive(_.stopMatchmaking(request))

        def suspendGameServerGroup(
          request: SuspendGameServerGroupRequest
        ): Kleisli[M, GameLiftClient, SuspendGameServerGroupResponse] =
          primitive(_.suspendGameServerGroup(request))

        def tagResource(
          request: TagResourceRequest
        ): Kleisli[M, GameLiftClient, TagResourceResponse] =
          primitive(_.tagResource(request))

        def untagResource(
          request: UntagResourceRequest
        ): Kleisli[M, GameLiftClient, UntagResourceResponse] =
          primitive(_.untagResource(request))

        def updateAlias(
          request: UpdateAliasRequest
        ): Kleisli[M, GameLiftClient, UpdateAliasResponse] =
          primitive(_.updateAlias(request))

        def updateBuild(
          request: UpdateBuildRequest
        ): Kleisli[M, GameLiftClient, UpdateBuildResponse] =
          primitive(_.updateBuild(request))

        def updateFleetAttributes(
          request: UpdateFleetAttributesRequest
        ): Kleisli[M, GameLiftClient, UpdateFleetAttributesResponse] =
          primitive(_.updateFleetAttributes(request))

        def updateFleetCapacity(
          request: UpdateFleetCapacityRequest
        ): Kleisli[M, GameLiftClient, UpdateFleetCapacityResponse] =
          primitive(_.updateFleetCapacity(request))

        def updateFleetPortSettings(
          request: UpdateFleetPortSettingsRequest
        ): Kleisli[M, GameLiftClient, UpdateFleetPortSettingsResponse] =
          primitive(_.updateFleetPortSettings(request))

        def updateGameServer(
          request: UpdateGameServerRequest
        ): Kleisli[M, GameLiftClient, UpdateGameServerResponse] =
          primitive(_.updateGameServer(request))

        def updateGameServerGroup(
          request: UpdateGameServerGroupRequest
        ): Kleisli[M, GameLiftClient, UpdateGameServerGroupResponse] =
          primitive(_.updateGameServerGroup(request))

        def updateGameSession(
          request: UpdateGameSessionRequest
        ): Kleisli[M, GameLiftClient, UpdateGameSessionResponse] =
          primitive(_.updateGameSession(request))

        def updateGameSessionQueue(
          request: UpdateGameSessionQueueRequest
        ): Kleisli[M, GameLiftClient, UpdateGameSessionQueueResponse] =
          primitive(_.updateGameSessionQueue(request))

        def updateMatchmakingConfiguration(
          request: UpdateMatchmakingConfigurationRequest
        ): Kleisli[M, GameLiftClient, UpdateMatchmakingConfigurationResponse] =
          primitive(_.updateMatchmakingConfiguration(request))

        def updateRuntimeConfiguration(
          request: UpdateRuntimeConfigurationRequest
        ): Kleisli[M, GameLiftClient, UpdateRuntimeConfigurationResponse] =
          primitive(_.updateRuntimeConfiguration(request))

        def updateScript(
          request: UpdateScriptRequest
        ): Kleisli[M, GameLiftClient, UpdateScriptResponse] =
          primitive(_.updateScript(request))

        def validateMatchmakingRuleSet(
          request: ValidateMatchmakingRuleSetRequest
        ): Kleisli[M, GameLiftClient, ValidateMatchmakingRuleSetResponse] =
          primitive(_.validateMatchmakingRuleSet(request))

        def primitive[A](
          f: GameLiftClient => A
        ): Kleisli[M, GameLiftClient, A]
      }
    }

    trait Visitor[F[_]] extends (GameLiftOp ~> F) {
      final def apply[A](op: GameLiftOp[A]): F[A] = op.visit(this)

      def embed[A](
        e: Embedded[A]
      ): F[A]

      def acceptMatch(
        request: AcceptMatchRequest
      ): F[AcceptMatchResponse]

      def claimGameServer(
        request: ClaimGameServerRequest
      ): F[ClaimGameServerResponse]

      def createAlias(
        request: CreateAliasRequest
      ): F[CreateAliasResponse]

      def createBuild(
        request: CreateBuildRequest
      ): F[CreateBuildResponse]

      def createFleet(
        request: CreateFleetRequest
      ): F[CreateFleetResponse]

      def createFleetLocations(
        request: CreateFleetLocationsRequest
      ): F[CreateFleetLocationsResponse]

      def createGameServerGroup(
        request: CreateGameServerGroupRequest
      ): F[CreateGameServerGroupResponse]

      def createGameSession(
        request: CreateGameSessionRequest
      ): F[CreateGameSessionResponse]

      def createGameSessionQueue(
        request: CreateGameSessionQueueRequest
      ): F[CreateGameSessionQueueResponse]

      def createMatchmakingConfiguration(
        request: CreateMatchmakingConfigurationRequest
      ): F[CreateMatchmakingConfigurationResponse]

      def createMatchmakingRuleSet(
        request: CreateMatchmakingRuleSetRequest
      ): F[CreateMatchmakingRuleSetResponse]

      def createPlayerSession(
        request: CreatePlayerSessionRequest
      ): F[CreatePlayerSessionResponse]

      def createPlayerSessions(
        request: CreatePlayerSessionsRequest
      ): F[CreatePlayerSessionsResponse]

      def createScript(
        request: CreateScriptRequest
      ): F[CreateScriptResponse]

      def createVpcPeeringAuthorization(
        request: CreateVpcPeeringAuthorizationRequest
      ): F[CreateVpcPeeringAuthorizationResponse]

      def createVpcPeeringConnection(
        request: CreateVpcPeeringConnectionRequest
      ): F[CreateVpcPeeringConnectionResponse]

      def deleteAlias(
        request: DeleteAliasRequest
      ): F[DeleteAliasResponse]

      def deleteBuild(
        request: DeleteBuildRequest
      ): F[DeleteBuildResponse]

      def deleteFleet(
        request: DeleteFleetRequest
      ): F[DeleteFleetResponse]

      def deleteFleetLocations(
        request: DeleteFleetLocationsRequest
      ): F[DeleteFleetLocationsResponse]

      def deleteGameServerGroup(
        request: DeleteGameServerGroupRequest
      ): F[DeleteGameServerGroupResponse]

      def deleteGameSessionQueue(
        request: DeleteGameSessionQueueRequest
      ): F[DeleteGameSessionQueueResponse]

      def deleteMatchmakingConfiguration(
        request: DeleteMatchmakingConfigurationRequest
      ): F[DeleteMatchmakingConfigurationResponse]

      def deleteMatchmakingRuleSet(
        request: DeleteMatchmakingRuleSetRequest
      ): F[DeleteMatchmakingRuleSetResponse]

      def deleteScalingPolicy(
        request: DeleteScalingPolicyRequest
      ): F[DeleteScalingPolicyResponse]

      def deleteScript(
        request: DeleteScriptRequest
      ): F[DeleteScriptResponse]

      def deleteVpcPeeringAuthorization(
        request: DeleteVpcPeeringAuthorizationRequest
      ): F[DeleteVpcPeeringAuthorizationResponse]

      def deleteVpcPeeringConnection(
        request: DeleteVpcPeeringConnectionRequest
      ): F[DeleteVpcPeeringConnectionResponse]

      def deregisterGameServer(
        request: DeregisterGameServerRequest
      ): F[DeregisterGameServerResponse]

      def describeAlias(
        request: DescribeAliasRequest
      ): F[DescribeAliasResponse]

      def describeBuild(
        request: DescribeBuildRequest
      ): F[DescribeBuildResponse]

      def describeEC2InstanceLimits(
        request: DescribeEc2InstanceLimitsRequest
      ): F[DescribeEc2InstanceLimitsResponse]

      def describeFleetAttributes(
        request: DescribeFleetAttributesRequest
      ): F[DescribeFleetAttributesResponse]

      def describeFleetCapacity(
        request: DescribeFleetCapacityRequest
      ): F[DescribeFleetCapacityResponse]

      def describeFleetEvents(
        request: DescribeFleetEventsRequest
      ): F[DescribeFleetEventsResponse]

      def describeFleetLocationAttributes(
        request: DescribeFleetLocationAttributesRequest
      ): F[DescribeFleetLocationAttributesResponse]

      def describeFleetLocationCapacity(
        request: DescribeFleetLocationCapacityRequest
      ): F[DescribeFleetLocationCapacityResponse]

      def describeFleetLocationUtilization(
        request: DescribeFleetLocationUtilizationRequest
      ): F[DescribeFleetLocationUtilizationResponse]

      def describeFleetPortSettings(
        request: DescribeFleetPortSettingsRequest
      ): F[DescribeFleetPortSettingsResponse]

      def describeFleetUtilization(
        request: DescribeFleetUtilizationRequest
      ): F[DescribeFleetUtilizationResponse]

      def describeGameServer(
        request: DescribeGameServerRequest
      ): F[DescribeGameServerResponse]

      def describeGameServerGroup(
        request: DescribeGameServerGroupRequest
      ): F[DescribeGameServerGroupResponse]

      def describeGameServerInstances(
        request: DescribeGameServerInstancesRequest
      ): F[DescribeGameServerInstancesResponse]

      def describeGameSessionDetails(
        request: DescribeGameSessionDetailsRequest
      ): F[DescribeGameSessionDetailsResponse]

      def describeGameSessionPlacement(
        request: DescribeGameSessionPlacementRequest
      ): F[DescribeGameSessionPlacementResponse]

      def describeGameSessionQueues(
        request: DescribeGameSessionQueuesRequest
      ): F[DescribeGameSessionQueuesResponse]

      def describeGameSessions(
        request: DescribeGameSessionsRequest
      ): F[DescribeGameSessionsResponse]

      def describeInstances(
        request: DescribeInstancesRequest
      ): F[DescribeInstancesResponse]

      def describeMatchmaking(
        request: DescribeMatchmakingRequest
      ): F[DescribeMatchmakingResponse]

      def describeMatchmakingConfigurations(
        request: DescribeMatchmakingConfigurationsRequest
      ): F[DescribeMatchmakingConfigurationsResponse]

      def describeMatchmakingRuleSets(
        request: DescribeMatchmakingRuleSetsRequest
      ): F[DescribeMatchmakingRuleSetsResponse]

      def describePlayerSessions(
        request: DescribePlayerSessionsRequest
      ): F[DescribePlayerSessionsResponse]

      def describeRuntimeConfiguration(
        request: DescribeRuntimeConfigurationRequest
      ): F[DescribeRuntimeConfigurationResponse]

      def describeScalingPolicies(
        request: DescribeScalingPoliciesRequest
      ): F[DescribeScalingPoliciesResponse]

      def describeScript(
        request: DescribeScriptRequest
      ): F[DescribeScriptResponse]

      def describeVpcPeeringAuthorizations(
        request: DescribeVpcPeeringAuthorizationsRequest
      ): F[DescribeVpcPeeringAuthorizationsResponse]

      def describeVpcPeeringConnections(
        request: DescribeVpcPeeringConnectionsRequest
      ): F[DescribeVpcPeeringConnectionsResponse]

      def getGameSessionLogUrl(
        request: GetGameSessionLogUrlRequest
      ): F[GetGameSessionLogUrlResponse]

      def getInstanceAccess(
        request: GetInstanceAccessRequest
      ): F[GetInstanceAccessResponse]

      def listAliases(
        request: ListAliasesRequest
      ): F[ListAliasesResponse]

      def listBuilds(
        request: ListBuildsRequest
      ): F[ListBuildsResponse]

      def listFleets(
        request: ListFleetsRequest
      ): F[ListFleetsResponse]

      def listGameServerGroups(
        request: ListGameServerGroupsRequest
      ): F[ListGameServerGroupsResponse]

      def listGameServers(
        request: ListGameServersRequest
      ): F[ListGameServersResponse]

      def listScripts(
        request: ListScriptsRequest
      ): F[ListScriptsResponse]

      def listTagsForResource(
        request: ListTagsForResourceRequest
      ): F[ListTagsForResourceResponse]

      def putScalingPolicy(
        request: PutScalingPolicyRequest
      ): F[PutScalingPolicyResponse]

      def registerGameServer(
        request: RegisterGameServerRequest
      ): F[RegisterGameServerResponse]

      def requestUploadCredentials(
        request: RequestUploadCredentialsRequest
      ): F[RequestUploadCredentialsResponse]

      def resolveAlias(
        request: ResolveAliasRequest
      ): F[ResolveAliasResponse]

      def resumeGameServerGroup(
        request: ResumeGameServerGroupRequest
      ): F[ResumeGameServerGroupResponse]

      def searchGameSessions(
        request: SearchGameSessionsRequest
      ): F[SearchGameSessionsResponse]

      def startFleetActions(
        request: StartFleetActionsRequest
      ): F[StartFleetActionsResponse]

      def startGameSessionPlacement(
        request: StartGameSessionPlacementRequest
      ): F[StartGameSessionPlacementResponse]

      def startMatchBackfill(
        request: StartMatchBackfillRequest
      ): F[StartMatchBackfillResponse]

      def startMatchmaking(
        request: StartMatchmakingRequest
      ): F[StartMatchmakingResponse]

      def stopFleetActions(
        request: StopFleetActionsRequest
      ): F[StopFleetActionsResponse]

      def stopGameSessionPlacement(
        request: StopGameSessionPlacementRequest
      ): F[StopGameSessionPlacementResponse]

      def stopMatchmaking(
        request: StopMatchmakingRequest
      ): F[StopMatchmakingResponse]

      def suspendGameServerGroup(
        request: SuspendGameServerGroupRequest
      ): F[SuspendGameServerGroupResponse]

      def tagResource(
        request: TagResourceRequest
      ): F[TagResourceResponse]

      def untagResource(
        request: UntagResourceRequest
      ): F[UntagResourceResponse]

      def updateAlias(
        request: UpdateAliasRequest
      ): F[UpdateAliasResponse]

      def updateBuild(
        request: UpdateBuildRequest
      ): F[UpdateBuildResponse]

      def updateFleetAttributes(
        request: UpdateFleetAttributesRequest
      ): F[UpdateFleetAttributesResponse]

      def updateFleetCapacity(
        request: UpdateFleetCapacityRequest
      ): F[UpdateFleetCapacityResponse]

      def updateFleetPortSettings(
        request: UpdateFleetPortSettingsRequest
      ): F[UpdateFleetPortSettingsResponse]

      def updateGameServer(
        request: UpdateGameServerRequest
      ): F[UpdateGameServerResponse]

      def updateGameServerGroup(
        request: UpdateGameServerGroupRequest
      ): F[UpdateGameServerGroupResponse]

      def updateGameSession(
        request: UpdateGameSessionRequest
      ): F[UpdateGameSessionResponse]

      def updateGameSessionQueue(
        request: UpdateGameSessionQueueRequest
      ): F[UpdateGameSessionQueueResponse]

      def updateMatchmakingConfiguration(
        request: UpdateMatchmakingConfigurationRequest
      ): F[UpdateMatchmakingConfigurationResponse]

      def updateRuntimeConfiguration(
        request: UpdateRuntimeConfigurationRequest
      ): F[UpdateRuntimeConfigurationResponse]

      def updateScript(
        request: UpdateScriptRequest
      ): F[UpdateScriptResponse]

      def validateMatchmakingRuleSet(
        request: ValidateMatchmakingRuleSetRequest
      ): F[ValidateMatchmakingRuleSetResponse]
    }

    final case class Embed[A](
      e: Embedded[A]
    ) extends GameLiftOp[A] {
      def visit[F[_]](visitor: Visitor[F]) =
        visitor.embed(e)
    }

    final case class AcceptMatchOp(
      request: AcceptMatchRequest
    ) extends GameLiftOp[AcceptMatchResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[AcceptMatchResponse] =
        visitor.acceptMatch(request)
    }

    final case class ClaimGameServerOp(
      request: ClaimGameServerRequest
    ) extends GameLiftOp[ClaimGameServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ClaimGameServerResponse] =
        visitor.claimGameServer(request)
    }

    final case class CreateAliasOp(
      request: CreateAliasRequest
    ) extends GameLiftOp[CreateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateAliasResponse] =
        visitor.createAlias(request)
    }

    final case class CreateBuildOp(
      request: CreateBuildRequest
    ) extends GameLiftOp[CreateBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateBuildResponse] =
        visitor.createBuild(request)
    }

    final case class CreateFleetOp(
      request: CreateFleetRequest
    ) extends GameLiftOp[CreateFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFleetResponse] =
        visitor.createFleet(request)
    }

    final case class CreateFleetLocationsOp(
      request: CreateFleetLocationsRequest
    ) extends GameLiftOp[CreateFleetLocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateFleetLocationsResponse] =
        visitor.createFleetLocations(request)
    }

    final case class CreateGameServerGroupOp(
      request: CreateGameServerGroupRequest
    ) extends GameLiftOp[CreateGameServerGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGameServerGroupResponse] =
        visitor.createGameServerGroup(request)
    }

    final case class CreateGameSessionOp(
      request: CreateGameSessionRequest
    ) extends GameLiftOp[CreateGameSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGameSessionResponse] =
        visitor.createGameSession(request)
    }

    final case class CreateGameSessionQueueOp(
      request: CreateGameSessionQueueRequest
    ) extends GameLiftOp[CreateGameSessionQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateGameSessionQueueResponse] =
        visitor.createGameSessionQueue(request)
    }

    final case class CreateMatchmakingConfigurationOp(
      request: CreateMatchmakingConfigurationRequest
    ) extends GameLiftOp[CreateMatchmakingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMatchmakingConfigurationResponse] =
        visitor.createMatchmakingConfiguration(request)
    }

    final case class CreateMatchmakingRuleSetOp(
      request: CreateMatchmakingRuleSetRequest
    ) extends GameLiftOp[CreateMatchmakingRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateMatchmakingRuleSetResponse] =
        visitor.createMatchmakingRuleSet(request)
    }

    final case class CreatePlayerSessionOp(
      request: CreatePlayerSessionRequest
    ) extends GameLiftOp[CreatePlayerSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlayerSessionResponse] =
        visitor.createPlayerSession(request)
    }

    final case class CreatePlayerSessionsOp(
      request: CreatePlayerSessionsRequest
    ) extends GameLiftOp[CreatePlayerSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreatePlayerSessionsResponse] =
        visitor.createPlayerSessions(request)
    }

    final case class CreateScriptOp(
      request: CreateScriptRequest
    ) extends GameLiftOp[CreateScriptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateScriptResponse] =
        visitor.createScript(request)
    }

    final case class CreateVpcPeeringAuthorizationOp(
      request: CreateVpcPeeringAuthorizationRequest
    ) extends GameLiftOp[CreateVpcPeeringAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcPeeringAuthorizationResponse] =
        visitor.createVpcPeeringAuthorization(request)
    }

    final case class CreateVpcPeeringConnectionOp(
      request: CreateVpcPeeringConnectionRequest
    ) extends GameLiftOp[CreateVpcPeeringConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[CreateVpcPeeringConnectionResponse] =
        visitor.createVpcPeeringConnection(request)
    }

    final case class DeleteAliasOp(
      request: DeleteAliasRequest
    ) extends GameLiftOp[DeleteAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteAliasResponse] =
        visitor.deleteAlias(request)
    }

    final case class DeleteBuildOp(
      request: DeleteBuildRequest
    ) extends GameLiftOp[DeleteBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteBuildResponse] =
        visitor.deleteBuild(request)
    }

    final case class DeleteFleetOp(
      request: DeleteFleetRequest
    ) extends GameLiftOp[DeleteFleetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFleetResponse] =
        visitor.deleteFleet(request)
    }

    final case class DeleteFleetLocationsOp(
      request: DeleteFleetLocationsRequest
    ) extends GameLiftOp[DeleteFleetLocationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteFleetLocationsResponse] =
        visitor.deleteFleetLocations(request)
    }

    final case class DeleteGameServerGroupOp(
      request: DeleteGameServerGroupRequest
    ) extends GameLiftOp[DeleteGameServerGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGameServerGroupResponse] =
        visitor.deleteGameServerGroup(request)
    }

    final case class DeleteGameSessionQueueOp(
      request: DeleteGameSessionQueueRequest
    ) extends GameLiftOp[DeleteGameSessionQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteGameSessionQueueResponse] =
        visitor.deleteGameSessionQueue(request)
    }

    final case class DeleteMatchmakingConfigurationOp(
      request: DeleteMatchmakingConfigurationRequest
    ) extends GameLiftOp[DeleteMatchmakingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMatchmakingConfigurationResponse] =
        visitor.deleteMatchmakingConfiguration(request)
    }

    final case class DeleteMatchmakingRuleSetOp(
      request: DeleteMatchmakingRuleSetRequest
    ) extends GameLiftOp[DeleteMatchmakingRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteMatchmakingRuleSetResponse] =
        visitor.deleteMatchmakingRuleSet(request)
    }

    final case class DeleteScalingPolicyOp(
      request: DeleteScalingPolicyRequest
    ) extends GameLiftOp[DeleteScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScalingPolicyResponse] =
        visitor.deleteScalingPolicy(request)
    }

    final case class DeleteScriptOp(
      request: DeleteScriptRequest
    ) extends GameLiftOp[DeleteScriptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteScriptResponse] =
        visitor.deleteScript(request)
    }

    final case class DeleteVpcPeeringAuthorizationOp(
      request: DeleteVpcPeeringAuthorizationRequest
    ) extends GameLiftOp[DeleteVpcPeeringAuthorizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcPeeringAuthorizationResponse] =
        visitor.deleteVpcPeeringAuthorization(request)
    }

    final case class DeleteVpcPeeringConnectionOp(
      request: DeleteVpcPeeringConnectionRequest
    ) extends GameLiftOp[DeleteVpcPeeringConnectionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeleteVpcPeeringConnectionResponse] =
        visitor.deleteVpcPeeringConnection(request)
    }

    final case class DeregisterGameServerOp(
      request: DeregisterGameServerRequest
    ) extends GameLiftOp[DeregisterGameServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DeregisterGameServerResponse] =
        visitor.deregisterGameServer(request)
    }

    final case class DescribeAliasOp(
      request: DescribeAliasRequest
    ) extends GameLiftOp[DescribeAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeAliasResponse] =
        visitor.describeAlias(request)
    }

    final case class DescribeBuildOp(
      request: DescribeBuildRequest
    ) extends GameLiftOp[DescribeBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeBuildResponse] =
        visitor.describeBuild(request)
    }

    final case class DescribeEC2InstanceLimitsOp(
      request: DescribeEc2InstanceLimitsRequest
    ) extends GameLiftOp[DescribeEc2InstanceLimitsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeEc2InstanceLimitsResponse] =
        visitor.describeEC2InstanceLimits(request)
    }

    final case class DescribeFleetAttributesOp(
      request: DescribeFleetAttributesRequest
    ) extends GameLiftOp[DescribeFleetAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetAttributesResponse] =
        visitor.describeFleetAttributes(request)
    }

    final case class DescribeFleetCapacityOp(
      request: DescribeFleetCapacityRequest
    ) extends GameLiftOp[DescribeFleetCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetCapacityResponse] =
        visitor.describeFleetCapacity(request)
    }

    final case class DescribeFleetEventsOp(
      request: DescribeFleetEventsRequest
    ) extends GameLiftOp[DescribeFleetEventsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetEventsResponse] =
        visitor.describeFleetEvents(request)
    }

    final case class DescribeFleetLocationAttributesOp(
      request: DescribeFleetLocationAttributesRequest
    ) extends GameLiftOp[DescribeFleetLocationAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetLocationAttributesResponse] =
        visitor.describeFleetLocationAttributes(request)
    }

    final case class DescribeFleetLocationCapacityOp(
      request: DescribeFleetLocationCapacityRequest
    ) extends GameLiftOp[DescribeFleetLocationCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetLocationCapacityResponse] =
        visitor.describeFleetLocationCapacity(request)
    }

    final case class DescribeFleetLocationUtilizationOp(
      request: DescribeFleetLocationUtilizationRequest
    ) extends GameLiftOp[DescribeFleetLocationUtilizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetLocationUtilizationResponse] =
        visitor.describeFleetLocationUtilization(request)
    }

    final case class DescribeFleetPortSettingsOp(
      request: DescribeFleetPortSettingsRequest
    ) extends GameLiftOp[DescribeFleetPortSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetPortSettingsResponse] =
        visitor.describeFleetPortSettings(request)
    }

    final case class DescribeFleetUtilizationOp(
      request: DescribeFleetUtilizationRequest
    ) extends GameLiftOp[DescribeFleetUtilizationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeFleetUtilizationResponse] =
        visitor.describeFleetUtilization(request)
    }

    final case class DescribeGameServerOp(
      request: DescribeGameServerRequest
    ) extends GameLiftOp[DescribeGameServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameServerResponse] =
        visitor.describeGameServer(request)
    }

    final case class DescribeGameServerGroupOp(
      request: DescribeGameServerGroupRequest
    ) extends GameLiftOp[DescribeGameServerGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameServerGroupResponse] =
        visitor.describeGameServerGroup(request)
    }

    final case class DescribeGameServerInstancesOp(
      request: DescribeGameServerInstancesRequest
    ) extends GameLiftOp[DescribeGameServerInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameServerInstancesResponse] =
        visitor.describeGameServerInstances(request)
    }

    final case class DescribeGameSessionDetailsOp(
      request: DescribeGameSessionDetailsRequest
    ) extends GameLiftOp[DescribeGameSessionDetailsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameSessionDetailsResponse] =
        visitor.describeGameSessionDetails(request)
    }

    final case class DescribeGameSessionPlacementOp(
      request: DescribeGameSessionPlacementRequest
    ) extends GameLiftOp[DescribeGameSessionPlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameSessionPlacementResponse] =
        visitor.describeGameSessionPlacement(request)
    }

    final case class DescribeGameSessionQueuesOp(
      request: DescribeGameSessionQueuesRequest
    ) extends GameLiftOp[DescribeGameSessionQueuesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameSessionQueuesResponse] =
        visitor.describeGameSessionQueues(request)
    }

    final case class DescribeGameSessionsOp(
      request: DescribeGameSessionsRequest
    ) extends GameLiftOp[DescribeGameSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeGameSessionsResponse] =
        visitor.describeGameSessions(request)
    }

    final case class DescribeInstancesOp(
      request: DescribeInstancesRequest
    ) extends GameLiftOp[DescribeInstancesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeInstancesResponse] =
        visitor.describeInstances(request)
    }

    final case class DescribeMatchmakingOp(
      request: DescribeMatchmakingRequest
    ) extends GameLiftOp[DescribeMatchmakingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMatchmakingResponse] =
        visitor.describeMatchmaking(request)
    }

    final case class DescribeMatchmakingConfigurationsOp(
      request: DescribeMatchmakingConfigurationsRequest
    ) extends GameLiftOp[DescribeMatchmakingConfigurationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMatchmakingConfigurationsResponse] =
        visitor.describeMatchmakingConfigurations(request)
    }

    final case class DescribeMatchmakingRuleSetsOp(
      request: DescribeMatchmakingRuleSetsRequest
    ) extends GameLiftOp[DescribeMatchmakingRuleSetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeMatchmakingRuleSetsResponse] =
        visitor.describeMatchmakingRuleSets(request)
    }

    final case class DescribePlayerSessionsOp(
      request: DescribePlayerSessionsRequest
    ) extends GameLiftOp[DescribePlayerSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribePlayerSessionsResponse] =
        visitor.describePlayerSessions(request)
    }

    final case class DescribeRuntimeConfigurationOp(
      request: DescribeRuntimeConfigurationRequest
    ) extends GameLiftOp[DescribeRuntimeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeRuntimeConfigurationResponse] =
        visitor.describeRuntimeConfiguration(request)
    }

    final case class DescribeScalingPoliciesOp(
      request: DescribeScalingPoliciesRequest
    ) extends GameLiftOp[DescribeScalingPoliciesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScalingPoliciesResponse] =
        visitor.describeScalingPolicies(request)
    }

    final case class DescribeScriptOp(
      request: DescribeScriptRequest
    ) extends GameLiftOp[DescribeScriptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeScriptResponse] =
        visitor.describeScript(request)
    }

    final case class DescribeVpcPeeringAuthorizationsOp(
      request: DescribeVpcPeeringAuthorizationsRequest
    ) extends GameLiftOp[DescribeVpcPeeringAuthorizationsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcPeeringAuthorizationsResponse] =
        visitor.describeVpcPeeringAuthorizations(request)
    }

    final case class DescribeVpcPeeringConnectionsOp(
      request: DescribeVpcPeeringConnectionsRequest
    ) extends GameLiftOp[DescribeVpcPeeringConnectionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[DescribeVpcPeeringConnectionsResponse] =
        visitor.describeVpcPeeringConnections(request)
    }

    final case class GetGameSessionLogUrlOp(
      request: GetGameSessionLogUrlRequest
    ) extends GameLiftOp[GetGameSessionLogUrlResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetGameSessionLogUrlResponse] =
        visitor.getGameSessionLogUrl(request)
    }

    final case class GetInstanceAccessOp(
      request: GetInstanceAccessRequest
    ) extends GameLiftOp[GetInstanceAccessResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[GetInstanceAccessResponse] =
        visitor.getInstanceAccess(request)
    }

    final case class ListAliasesOp(
      request: ListAliasesRequest
    ) extends GameLiftOp[ListAliasesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListAliasesResponse] =
        visitor.listAliases(request)
    }

    final case class ListBuildsOp(
      request: ListBuildsRequest
    ) extends GameLiftOp[ListBuildsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListBuildsResponse] =
        visitor.listBuilds(request)
    }

    final case class ListFleetsOp(
      request: ListFleetsRequest
    ) extends GameLiftOp[ListFleetsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListFleetsResponse] =
        visitor.listFleets(request)
    }

    final case class ListGameServerGroupsOp(
      request: ListGameServerGroupsRequest
    ) extends GameLiftOp[ListGameServerGroupsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGameServerGroupsResponse] =
        visitor.listGameServerGroups(request)
    }

    final case class ListGameServersOp(
      request: ListGameServersRequest
    ) extends GameLiftOp[ListGameServersResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListGameServersResponse] =
        visitor.listGameServers(request)
    }

    final case class ListScriptsOp(
      request: ListScriptsRequest
    ) extends GameLiftOp[ListScriptsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListScriptsResponse] =
        visitor.listScripts(request)
    }

    final case class ListTagsForResourceOp(
      request: ListTagsForResourceRequest
    ) extends GameLiftOp[ListTagsForResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ListTagsForResourceResponse] =
        visitor.listTagsForResource(request)
    }

    final case class PutScalingPolicyOp(
      request: PutScalingPolicyRequest
    ) extends GameLiftOp[PutScalingPolicyResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[PutScalingPolicyResponse] =
        visitor.putScalingPolicy(request)
    }

    final case class RegisterGameServerOp(
      request: RegisterGameServerRequest
    ) extends GameLiftOp[RegisterGameServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RegisterGameServerResponse] =
        visitor.registerGameServer(request)
    }

    final case class RequestUploadCredentialsOp(
      request: RequestUploadCredentialsRequest
    ) extends GameLiftOp[RequestUploadCredentialsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[RequestUploadCredentialsResponse] =
        visitor.requestUploadCredentials(request)
    }

    final case class ResolveAliasOp(
      request: ResolveAliasRequest
    ) extends GameLiftOp[ResolveAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResolveAliasResponse] =
        visitor.resolveAlias(request)
    }

    final case class ResumeGameServerGroupOp(
      request: ResumeGameServerGroupRequest
    ) extends GameLiftOp[ResumeGameServerGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ResumeGameServerGroupResponse] =
        visitor.resumeGameServerGroup(request)
    }

    final case class SearchGameSessionsOp(
      request: SearchGameSessionsRequest
    ) extends GameLiftOp[SearchGameSessionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SearchGameSessionsResponse] =
        visitor.searchGameSessions(request)
    }

    final case class StartFleetActionsOp(
      request: StartFleetActionsRequest
    ) extends GameLiftOp[StartFleetActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartFleetActionsResponse] =
        visitor.startFleetActions(request)
    }

    final case class StartGameSessionPlacementOp(
      request: StartGameSessionPlacementRequest
    ) extends GameLiftOp[StartGameSessionPlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartGameSessionPlacementResponse] =
        visitor.startGameSessionPlacement(request)
    }

    final case class StartMatchBackfillOp(
      request: StartMatchBackfillRequest
    ) extends GameLiftOp[StartMatchBackfillResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMatchBackfillResponse] =
        visitor.startMatchBackfill(request)
    }

    final case class StartMatchmakingOp(
      request: StartMatchmakingRequest
    ) extends GameLiftOp[StartMatchmakingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StartMatchmakingResponse] =
        visitor.startMatchmaking(request)
    }

    final case class StopFleetActionsOp(
      request: StopFleetActionsRequest
    ) extends GameLiftOp[StopFleetActionsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopFleetActionsResponse] =
        visitor.stopFleetActions(request)
    }

    final case class StopGameSessionPlacementOp(
      request: StopGameSessionPlacementRequest
    ) extends GameLiftOp[StopGameSessionPlacementResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopGameSessionPlacementResponse] =
        visitor.stopGameSessionPlacement(request)
    }

    final case class StopMatchmakingOp(
      request: StopMatchmakingRequest
    ) extends GameLiftOp[StopMatchmakingResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[StopMatchmakingResponse] =
        visitor.stopMatchmaking(request)
    }

    final case class SuspendGameServerGroupOp(
      request: SuspendGameServerGroupRequest
    ) extends GameLiftOp[SuspendGameServerGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[SuspendGameServerGroupResponse] =
        visitor.suspendGameServerGroup(request)
    }

    final case class TagResourceOp(
      request: TagResourceRequest
    ) extends GameLiftOp[TagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[TagResourceResponse] =
        visitor.tagResource(request)
    }

    final case class UntagResourceOp(
      request: UntagResourceRequest
    ) extends GameLiftOp[UntagResourceResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UntagResourceResponse] =
        visitor.untagResource(request)
    }

    final case class UpdateAliasOp(
      request: UpdateAliasRequest
    ) extends GameLiftOp[UpdateAliasResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateAliasResponse] =
        visitor.updateAlias(request)
    }

    final case class UpdateBuildOp(
      request: UpdateBuildRequest
    ) extends GameLiftOp[UpdateBuildResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateBuildResponse] =
        visitor.updateBuild(request)
    }

    final case class UpdateFleetAttributesOp(
      request: UpdateFleetAttributesRequest
    ) extends GameLiftOp[UpdateFleetAttributesResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFleetAttributesResponse] =
        visitor.updateFleetAttributes(request)
    }

    final case class UpdateFleetCapacityOp(
      request: UpdateFleetCapacityRequest
    ) extends GameLiftOp[UpdateFleetCapacityResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFleetCapacityResponse] =
        visitor.updateFleetCapacity(request)
    }

    final case class UpdateFleetPortSettingsOp(
      request: UpdateFleetPortSettingsRequest
    ) extends GameLiftOp[UpdateFleetPortSettingsResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateFleetPortSettingsResponse] =
        visitor.updateFleetPortSettings(request)
    }

    final case class UpdateGameServerOp(
      request: UpdateGameServerRequest
    ) extends GameLiftOp[UpdateGameServerResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGameServerResponse] =
        visitor.updateGameServer(request)
    }

    final case class UpdateGameServerGroupOp(
      request: UpdateGameServerGroupRequest
    ) extends GameLiftOp[UpdateGameServerGroupResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGameServerGroupResponse] =
        visitor.updateGameServerGroup(request)
    }

    final case class UpdateGameSessionOp(
      request: UpdateGameSessionRequest
    ) extends GameLiftOp[UpdateGameSessionResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGameSessionResponse] =
        visitor.updateGameSession(request)
    }

    final case class UpdateGameSessionQueueOp(
      request: UpdateGameSessionQueueRequest
    ) extends GameLiftOp[UpdateGameSessionQueueResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateGameSessionQueueResponse] =
        visitor.updateGameSessionQueue(request)
    }

    final case class UpdateMatchmakingConfigurationOp(
      request: UpdateMatchmakingConfigurationRequest
    ) extends GameLiftOp[UpdateMatchmakingConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateMatchmakingConfigurationResponse] =
        visitor.updateMatchmakingConfiguration(request)
    }

    final case class UpdateRuntimeConfigurationOp(
      request: UpdateRuntimeConfigurationRequest
    ) extends GameLiftOp[UpdateRuntimeConfigurationResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateRuntimeConfigurationResponse] =
        visitor.updateRuntimeConfiguration(request)
    }

    final case class UpdateScriptOp(
      request: UpdateScriptRequest
    ) extends GameLiftOp[UpdateScriptResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[UpdateScriptResponse] =
        visitor.updateScript(request)
    }

    final case class ValidateMatchmakingRuleSetOp(
      request: ValidateMatchmakingRuleSetRequest
    ) extends GameLiftOp[ValidateMatchmakingRuleSetResponse] {
      def visit[F[_]](visitor: Visitor[F]): F[ValidateMatchmakingRuleSetResponse] =
        visitor.validateMatchmakingRuleSet(request)
    }
  }

  import GameLiftOp._

  def embed[F[_], J, A](
    j: J,
    fa: FF[F, A]
  )(implicit
    ev: Embeddable[F, J]
  ): FF[GameLiftOp, A] =
    FF.liftF(Embed(ev.embed(j, fa)))

  def acceptMatch(
    request: AcceptMatchRequest
  ): GameLiftIO[AcceptMatchResponse] =
    FF.liftF(AcceptMatchOp(request))

  def claimGameServer(
    request: ClaimGameServerRequest
  ): GameLiftIO[ClaimGameServerResponse] =
    FF.liftF(ClaimGameServerOp(request))

  def createAlias(
    request: CreateAliasRequest
  ): GameLiftIO[CreateAliasResponse] =
    FF.liftF(CreateAliasOp(request))

  def createBuild(
    request: CreateBuildRequest
  ): GameLiftIO[CreateBuildResponse] =
    FF.liftF(CreateBuildOp(request))

  def createFleet(
    request: CreateFleetRequest
  ): GameLiftIO[CreateFleetResponse] =
    FF.liftF(CreateFleetOp(request))

  def createFleetLocations(
    request: CreateFleetLocationsRequest
  ): GameLiftIO[CreateFleetLocationsResponse] =
    FF.liftF(CreateFleetLocationsOp(request))

  def createGameServerGroup(
    request: CreateGameServerGroupRequest
  ): GameLiftIO[CreateGameServerGroupResponse] =
    FF.liftF(CreateGameServerGroupOp(request))

  def createGameSession(
    request: CreateGameSessionRequest
  ): GameLiftIO[CreateGameSessionResponse] =
    FF.liftF(CreateGameSessionOp(request))

  def createGameSessionQueue(
    request: CreateGameSessionQueueRequest
  ): GameLiftIO[CreateGameSessionQueueResponse] =
    FF.liftF(CreateGameSessionQueueOp(request))

  def createMatchmakingConfiguration(
    request: CreateMatchmakingConfigurationRequest
  ): GameLiftIO[CreateMatchmakingConfigurationResponse] =
    FF.liftF(CreateMatchmakingConfigurationOp(request))

  def createMatchmakingRuleSet(
    request: CreateMatchmakingRuleSetRequest
  ): GameLiftIO[CreateMatchmakingRuleSetResponse] =
    FF.liftF(CreateMatchmakingRuleSetOp(request))

  def createPlayerSession(
    request: CreatePlayerSessionRequest
  ): GameLiftIO[CreatePlayerSessionResponse] =
    FF.liftF(CreatePlayerSessionOp(request))

  def createPlayerSessions(
    request: CreatePlayerSessionsRequest
  ): GameLiftIO[CreatePlayerSessionsResponse] =
    FF.liftF(CreatePlayerSessionsOp(request))

  def createScript(
    request: CreateScriptRequest
  ): GameLiftIO[CreateScriptResponse] =
    FF.liftF(CreateScriptOp(request))

  def createVpcPeeringAuthorization(
    request: CreateVpcPeeringAuthorizationRequest
  ): GameLiftIO[CreateVpcPeeringAuthorizationResponse] =
    FF.liftF(CreateVpcPeeringAuthorizationOp(request))

  def createVpcPeeringConnection(
    request: CreateVpcPeeringConnectionRequest
  ): GameLiftIO[CreateVpcPeeringConnectionResponse] =
    FF.liftF(CreateVpcPeeringConnectionOp(request))

  def deleteAlias(
    request: DeleteAliasRequest
  ): GameLiftIO[DeleteAliasResponse] =
    FF.liftF(DeleteAliasOp(request))

  def deleteBuild(
    request: DeleteBuildRequest
  ): GameLiftIO[DeleteBuildResponse] =
    FF.liftF(DeleteBuildOp(request))

  def deleteFleet(
    request: DeleteFleetRequest
  ): GameLiftIO[DeleteFleetResponse] =
    FF.liftF(DeleteFleetOp(request))

  def deleteFleetLocations(
    request: DeleteFleetLocationsRequest
  ): GameLiftIO[DeleteFleetLocationsResponse] =
    FF.liftF(DeleteFleetLocationsOp(request))

  def deleteGameServerGroup(
    request: DeleteGameServerGroupRequest
  ): GameLiftIO[DeleteGameServerGroupResponse] =
    FF.liftF(DeleteGameServerGroupOp(request))

  def deleteGameSessionQueue(
    request: DeleteGameSessionQueueRequest
  ): GameLiftIO[DeleteGameSessionQueueResponse] =
    FF.liftF(DeleteGameSessionQueueOp(request))

  def deleteMatchmakingConfiguration(
    request: DeleteMatchmakingConfigurationRequest
  ): GameLiftIO[DeleteMatchmakingConfigurationResponse] =
    FF.liftF(DeleteMatchmakingConfigurationOp(request))

  def deleteMatchmakingRuleSet(
    request: DeleteMatchmakingRuleSetRequest
  ): GameLiftIO[DeleteMatchmakingRuleSetResponse] =
    FF.liftF(DeleteMatchmakingRuleSetOp(request))

  def deleteScalingPolicy(
    request: DeleteScalingPolicyRequest
  ): GameLiftIO[DeleteScalingPolicyResponse] =
    FF.liftF(DeleteScalingPolicyOp(request))

  def deleteScript(
    request: DeleteScriptRequest
  ): GameLiftIO[DeleteScriptResponse] =
    FF.liftF(DeleteScriptOp(request))

  def deleteVpcPeeringAuthorization(
    request: DeleteVpcPeeringAuthorizationRequest
  ): GameLiftIO[DeleteVpcPeeringAuthorizationResponse] =
    FF.liftF(DeleteVpcPeeringAuthorizationOp(request))

  def deleteVpcPeeringConnection(
    request: DeleteVpcPeeringConnectionRequest
  ): GameLiftIO[DeleteVpcPeeringConnectionResponse] =
    FF.liftF(DeleteVpcPeeringConnectionOp(request))

  def deregisterGameServer(
    request: DeregisterGameServerRequest
  ): GameLiftIO[DeregisterGameServerResponse] =
    FF.liftF(DeregisterGameServerOp(request))

  def describeAlias(
    request: DescribeAliasRequest
  ): GameLiftIO[DescribeAliasResponse] =
    FF.liftF(DescribeAliasOp(request))

  def describeBuild(
    request: DescribeBuildRequest
  ): GameLiftIO[DescribeBuildResponse] =
    FF.liftF(DescribeBuildOp(request))

  def describeEC2InstanceLimits(
    request: DescribeEc2InstanceLimitsRequest
  ): GameLiftIO[DescribeEc2InstanceLimitsResponse] =
    FF.liftF(DescribeEC2InstanceLimitsOp(request))

  def describeFleetAttributes(
    request: DescribeFleetAttributesRequest
  ): GameLiftIO[DescribeFleetAttributesResponse] =
    FF.liftF(DescribeFleetAttributesOp(request))

  def describeFleetCapacity(
    request: DescribeFleetCapacityRequest
  ): GameLiftIO[DescribeFleetCapacityResponse] =
    FF.liftF(DescribeFleetCapacityOp(request))

  def describeFleetEvents(
    request: DescribeFleetEventsRequest
  ): GameLiftIO[DescribeFleetEventsResponse] =
    FF.liftF(DescribeFleetEventsOp(request))

  def describeFleetLocationAttributes(
    request: DescribeFleetLocationAttributesRequest
  ): GameLiftIO[DescribeFleetLocationAttributesResponse] =
    FF.liftF(DescribeFleetLocationAttributesOp(request))

  def describeFleetLocationCapacity(
    request: DescribeFleetLocationCapacityRequest
  ): GameLiftIO[DescribeFleetLocationCapacityResponse] =
    FF.liftF(DescribeFleetLocationCapacityOp(request))

  def describeFleetLocationUtilization(
    request: DescribeFleetLocationUtilizationRequest
  ): GameLiftIO[DescribeFleetLocationUtilizationResponse] =
    FF.liftF(DescribeFleetLocationUtilizationOp(request))

  def describeFleetPortSettings(
    request: DescribeFleetPortSettingsRequest
  ): GameLiftIO[DescribeFleetPortSettingsResponse] =
    FF.liftF(DescribeFleetPortSettingsOp(request))

  def describeFleetUtilization(
    request: DescribeFleetUtilizationRequest
  ): GameLiftIO[DescribeFleetUtilizationResponse] =
    FF.liftF(DescribeFleetUtilizationOp(request))

  def describeGameServer(
    request: DescribeGameServerRequest
  ): GameLiftIO[DescribeGameServerResponse] =
    FF.liftF(DescribeGameServerOp(request))

  def describeGameServerGroup(
    request: DescribeGameServerGroupRequest
  ): GameLiftIO[DescribeGameServerGroupResponse] =
    FF.liftF(DescribeGameServerGroupOp(request))

  def describeGameServerInstances(
    request: DescribeGameServerInstancesRequest
  ): GameLiftIO[DescribeGameServerInstancesResponse] =
    FF.liftF(DescribeGameServerInstancesOp(request))

  def describeGameSessionDetails(
    request: DescribeGameSessionDetailsRequest
  ): GameLiftIO[DescribeGameSessionDetailsResponse] =
    FF.liftF(DescribeGameSessionDetailsOp(request))

  def describeGameSessionPlacement(
    request: DescribeGameSessionPlacementRequest
  ): GameLiftIO[DescribeGameSessionPlacementResponse] =
    FF.liftF(DescribeGameSessionPlacementOp(request))

  def describeGameSessionQueues(
    request: DescribeGameSessionQueuesRequest
  ): GameLiftIO[DescribeGameSessionQueuesResponse] =
    FF.liftF(DescribeGameSessionQueuesOp(request))

  def describeGameSessions(
    request: DescribeGameSessionsRequest
  ): GameLiftIO[DescribeGameSessionsResponse] =
    FF.liftF(DescribeGameSessionsOp(request))

  def describeInstances(
    request: DescribeInstancesRequest
  ): GameLiftIO[DescribeInstancesResponse] =
    FF.liftF(DescribeInstancesOp(request))

  def describeMatchmaking(
    request: DescribeMatchmakingRequest
  ): GameLiftIO[DescribeMatchmakingResponse] =
    FF.liftF(DescribeMatchmakingOp(request))

  def describeMatchmakingConfigurations(
    request: DescribeMatchmakingConfigurationsRequest
  ): GameLiftIO[DescribeMatchmakingConfigurationsResponse] =
    FF.liftF(DescribeMatchmakingConfigurationsOp(request))

  def describeMatchmakingRuleSets(
    request: DescribeMatchmakingRuleSetsRequest
  ): GameLiftIO[DescribeMatchmakingRuleSetsResponse] =
    FF.liftF(DescribeMatchmakingRuleSetsOp(request))

  def describePlayerSessions(
    request: DescribePlayerSessionsRequest
  ): GameLiftIO[DescribePlayerSessionsResponse] =
    FF.liftF(DescribePlayerSessionsOp(request))

  def describeRuntimeConfiguration(
    request: DescribeRuntimeConfigurationRequest
  ): GameLiftIO[DescribeRuntimeConfigurationResponse] =
    FF.liftF(DescribeRuntimeConfigurationOp(request))

  def describeScalingPolicies(
    request: DescribeScalingPoliciesRequest
  ): GameLiftIO[DescribeScalingPoliciesResponse] =
    FF.liftF(DescribeScalingPoliciesOp(request))

  def describeScript(
    request: DescribeScriptRequest
  ): GameLiftIO[DescribeScriptResponse] =
    FF.liftF(DescribeScriptOp(request))

  def describeVpcPeeringAuthorizations(
    request: DescribeVpcPeeringAuthorizationsRequest
  ): GameLiftIO[DescribeVpcPeeringAuthorizationsResponse] =
    FF.liftF(DescribeVpcPeeringAuthorizationsOp(request))

  def describeVpcPeeringConnections(
    request: DescribeVpcPeeringConnectionsRequest
  ): GameLiftIO[DescribeVpcPeeringConnectionsResponse] =
    FF.liftF(DescribeVpcPeeringConnectionsOp(request))

  def getGameSessionLogUrl(
    request: GetGameSessionLogUrlRequest
  ): GameLiftIO[GetGameSessionLogUrlResponse] =
    FF.liftF(GetGameSessionLogUrlOp(request))

  def getInstanceAccess(
    request: GetInstanceAccessRequest
  ): GameLiftIO[GetInstanceAccessResponse] =
    FF.liftF(GetInstanceAccessOp(request))

  def listAliases(
    request: ListAliasesRequest
  ): GameLiftIO[ListAliasesResponse] =
    FF.liftF(ListAliasesOp(request))

  def listBuilds(
    request: ListBuildsRequest
  ): GameLiftIO[ListBuildsResponse] =
    FF.liftF(ListBuildsOp(request))

  def listFleets(
    request: ListFleetsRequest
  ): GameLiftIO[ListFleetsResponse] =
    FF.liftF(ListFleetsOp(request))

  def listGameServerGroups(
    request: ListGameServerGroupsRequest
  ): GameLiftIO[ListGameServerGroupsResponse] =
    FF.liftF(ListGameServerGroupsOp(request))

  def listGameServers(
    request: ListGameServersRequest
  ): GameLiftIO[ListGameServersResponse] =
    FF.liftF(ListGameServersOp(request))

  def listScripts(
    request: ListScriptsRequest
  ): GameLiftIO[ListScriptsResponse] =
    FF.liftF(ListScriptsOp(request))

  def listTagsForResource(
    request: ListTagsForResourceRequest
  ): GameLiftIO[ListTagsForResourceResponse] =
    FF.liftF(ListTagsForResourceOp(request))

  def putScalingPolicy(
    request: PutScalingPolicyRequest
  ): GameLiftIO[PutScalingPolicyResponse] =
    FF.liftF(PutScalingPolicyOp(request))

  def registerGameServer(
    request: RegisterGameServerRequest
  ): GameLiftIO[RegisterGameServerResponse] =
    FF.liftF(RegisterGameServerOp(request))

  def requestUploadCredentials(
    request: RequestUploadCredentialsRequest
  ): GameLiftIO[RequestUploadCredentialsResponse] =
    FF.liftF(RequestUploadCredentialsOp(request))

  def resolveAlias(
    request: ResolveAliasRequest
  ): GameLiftIO[ResolveAliasResponse] =
    FF.liftF(ResolveAliasOp(request))

  def resumeGameServerGroup(
    request: ResumeGameServerGroupRequest
  ): GameLiftIO[ResumeGameServerGroupResponse] =
    FF.liftF(ResumeGameServerGroupOp(request))

  def searchGameSessions(
    request: SearchGameSessionsRequest
  ): GameLiftIO[SearchGameSessionsResponse] =
    FF.liftF(SearchGameSessionsOp(request))

  def startFleetActions(
    request: StartFleetActionsRequest
  ): GameLiftIO[StartFleetActionsResponse] =
    FF.liftF(StartFleetActionsOp(request))

  def startGameSessionPlacement(
    request: StartGameSessionPlacementRequest
  ): GameLiftIO[StartGameSessionPlacementResponse] =
    FF.liftF(StartGameSessionPlacementOp(request))

  def startMatchBackfill(
    request: StartMatchBackfillRequest
  ): GameLiftIO[StartMatchBackfillResponse] =
    FF.liftF(StartMatchBackfillOp(request))

  def startMatchmaking(
    request: StartMatchmakingRequest
  ): GameLiftIO[StartMatchmakingResponse] =
    FF.liftF(StartMatchmakingOp(request))

  def stopFleetActions(
    request: StopFleetActionsRequest
  ): GameLiftIO[StopFleetActionsResponse] =
    FF.liftF(StopFleetActionsOp(request))

  def stopGameSessionPlacement(
    request: StopGameSessionPlacementRequest
  ): GameLiftIO[StopGameSessionPlacementResponse] =
    FF.liftF(StopGameSessionPlacementOp(request))

  def stopMatchmaking(
    request: StopMatchmakingRequest
  ): GameLiftIO[StopMatchmakingResponse] =
    FF.liftF(StopMatchmakingOp(request))

  def suspendGameServerGroup(
    request: SuspendGameServerGroupRequest
  ): GameLiftIO[SuspendGameServerGroupResponse] =
    FF.liftF(SuspendGameServerGroupOp(request))

  def tagResource(
    request: TagResourceRequest
  ): GameLiftIO[TagResourceResponse] =
    FF.liftF(TagResourceOp(request))

  def untagResource(
    request: UntagResourceRequest
  ): GameLiftIO[UntagResourceResponse] =
    FF.liftF(UntagResourceOp(request))

  def updateAlias(
    request: UpdateAliasRequest
  ): GameLiftIO[UpdateAliasResponse] =
    FF.liftF(UpdateAliasOp(request))

  def updateBuild(
    request: UpdateBuildRequest
  ): GameLiftIO[UpdateBuildResponse] =
    FF.liftF(UpdateBuildOp(request))

  def updateFleetAttributes(
    request: UpdateFleetAttributesRequest
  ): GameLiftIO[UpdateFleetAttributesResponse] =
    FF.liftF(UpdateFleetAttributesOp(request))

  def updateFleetCapacity(
    request: UpdateFleetCapacityRequest
  ): GameLiftIO[UpdateFleetCapacityResponse] =
    FF.liftF(UpdateFleetCapacityOp(request))

  def updateFleetPortSettings(
    request: UpdateFleetPortSettingsRequest
  ): GameLiftIO[UpdateFleetPortSettingsResponse] =
    FF.liftF(UpdateFleetPortSettingsOp(request))

  def updateGameServer(
    request: UpdateGameServerRequest
  ): GameLiftIO[UpdateGameServerResponse] =
    FF.liftF(UpdateGameServerOp(request))

  def updateGameServerGroup(
    request: UpdateGameServerGroupRequest
  ): GameLiftIO[UpdateGameServerGroupResponse] =
    FF.liftF(UpdateGameServerGroupOp(request))

  def updateGameSession(
    request: UpdateGameSessionRequest
  ): GameLiftIO[UpdateGameSessionResponse] =
    FF.liftF(UpdateGameSessionOp(request))

  def updateGameSessionQueue(
    request: UpdateGameSessionQueueRequest
  ): GameLiftIO[UpdateGameSessionQueueResponse] =
    FF.liftF(UpdateGameSessionQueueOp(request))

  def updateMatchmakingConfiguration(
    request: UpdateMatchmakingConfigurationRequest
  ): GameLiftIO[UpdateMatchmakingConfigurationResponse] =
    FF.liftF(UpdateMatchmakingConfigurationOp(request))

  def updateRuntimeConfiguration(
    request: UpdateRuntimeConfigurationRequest
  ): GameLiftIO[UpdateRuntimeConfigurationResponse] =
    FF.liftF(UpdateRuntimeConfigurationOp(request))

  def updateScript(
    request: UpdateScriptRequest
  ): GameLiftIO[UpdateScriptResponse] =
    FF.liftF(UpdateScriptOp(request))

  def validateMatchmakingRuleSet(
    request: ValidateMatchmakingRuleSetRequest
  ): GameLiftIO[ValidateMatchmakingRuleSetResponse] =
    FF.liftF(ValidateMatchmakingRuleSetOp(request))
}
