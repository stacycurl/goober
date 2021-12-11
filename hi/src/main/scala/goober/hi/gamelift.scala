package goober.hi

import goober.free.gamelift.GameLiftIO
import software.amazon.awssdk.services.gamelift.model._


object gamelift {
  import goober.free.{gamelift ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptMatchInput(
      ticketId: Option[String] = None,
      playerIds: Option[List[NonZeroAndMaxString]] = None,
      acceptanceType: Option[String] = None
    ): AcceptMatchInput =
      AcceptMatchInput
        .builder
        .ifSome(ticketId)(_.ticketId(_))
        .ifSome(playerIds)(_.playerIds(_))
        .ifSome(acceptanceType)(_.acceptanceType(_))
        .build

    def acceptMatchOutput(

    ): AcceptMatchOutput =
      AcceptMatchOutput
        .builder

        .build

    def alias(
      aliasId: Option[String] = None,
      name: Option[String] = None,
      aliasArn: Option[String] = None,
      description: Option[String] = None,
      routingStrategy: Option[RoutingStrategy] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): Alias =
      Alias
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(name)(_.name(_))
        .ifSome(aliasArn)(_.aliasArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(routingStrategy)(_.routingStrategy(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def attributeValue(
      s: Option[String] = None,
      n: Option[DoubleObject] = None,
      sL: Option[List[NonZeroAndMaxString]] = None,
      sDM: Option[StringDoubleMap] = None
    ): AttributeValue =
      AttributeValue
        .builder
        .ifSome(s)(_.s(_))
        .ifSome(n)(_.n(_))
        .ifSome(sL)(_.sL(_))
        .ifSome(sDM)(_.sDM(_))
        .build

    def awsCredentials(
      accessKeyId: Option[String] = None,
      secretAccessKey: Option[String] = None,
      sessionToken: Option[String] = None
    ): AwsCredentials =
      AwsCredentials
        .builder
        .ifSome(accessKeyId)(_.accessKeyId(_))
        .ifSome(secretAccessKey)(_.secretAccessKey(_))
        .ifSome(sessionToken)(_.sessionToken(_))
        .build

    def build(
      buildId: Option[String] = None,
      buildArn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      status: Option[String] = None,
      sizeOnDisk: Option[PositiveLong] = None,
      operatingSystem: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): Build =
      Build
        .builder
        .ifSome(buildId)(_.buildId(_))
        .ifSome(buildArn)(_.buildArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .ifSome(sizeOnDisk)(_.sizeOnDisk(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def certificateConfiguration(
      certificateType: Option[String] = None
    ): CertificateConfiguration =
      CertificateConfiguration
        .builder
        .ifSome(certificateType)(_.certificateType(_))
        .build

    def claimGameServerInput(
      gameServerGroupName: Option[String] = None,
      gameServerId: Option[String] = None,
      gameServerData: Option[String] = None
    ): ClaimGameServerInput =
      ClaimGameServerInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerId)(_.gameServerId(_))
        .ifSome(gameServerData)(_.gameServerData(_))
        .build

    def claimGameServerOutput(
      gameServer: Option[GameServer] = None
    ): ClaimGameServerOutput =
      ClaimGameServerOutput
        .builder
        .ifSome(gameServer)(_.gameServer(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createAliasInput(
      name: Option[String] = None,
      description: Option[String] = None,
      routingStrategy: Option[RoutingStrategy] = None,
      tags: Option[List[Tag]] = None
    ): CreateAliasInput =
      CreateAliasInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(routingStrategy)(_.routingStrategy(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAliasOutput(
      alias: Option[Alias] = None
    ): CreateAliasOutput =
      CreateAliasOutput
        .builder
        .ifSome(alias)(_.alias(_))
        .build

    def createBuildInput(
      name: Option[String] = None,
      version: Option[String] = None,
      storageLocation: Option[S3Location] = None,
      operatingSystem: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateBuildInput =
      CreateBuildInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(storageLocation)(_.storageLocation(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBuildOutput(
      build: Option[Build] = None,
      uploadCredentials: Option[AwsCredentials] = None,
      storageLocation: Option[S3Location] = None
    ): CreateBuildOutput =
      CreateBuildOutput
        .builder
        .ifSome(build)(_.build(_))
        .ifSome(uploadCredentials)(_.uploadCredentials(_))
        .ifSome(storageLocation)(_.storageLocation(_))
        .build

    def createFleetInput(
      name: Option[String] = None,
      description: Option[String] = None,
      buildId: Option[String] = None,
      scriptId: Option[String] = None,
      serverLaunchPath: Option[String] = None,
      serverLaunchParameters: Option[String] = None,
      logPaths: Option[List[NonZeroAndMaxString]] = None,
      eC2InstanceType: Option[String] = None,
      eC2InboundPermissions: Option[List[IpPermission]] = None,
      newGameSessionProtectionPolicy: Option[String] = None,
      runtimeConfiguration: Option[RuntimeConfiguration] = None,
      resourceCreationLimitPolicy: Option[ResourceCreationLimitPolicy] = None,
      metricGroups: Option[List[MetricGroup]] = None,
      peerVpcAwsAccountId: Option[String] = None,
      peerVpcId: Option[String] = None,
      fleetType: Option[String] = None,
      instanceRoleArn: Option[String] = None,
      certificateConfiguration: Option[CertificateConfiguration] = None,
      locations: Option[List[LocationConfiguration]] = None,
      tags: Option[List[Tag]] = None
    ): CreateFleetInput =
      CreateFleetInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(buildId)(_.buildId(_))
        .ifSome(scriptId)(_.scriptId(_))
        .ifSome(serverLaunchPath)(_.serverLaunchPath(_))
        .ifSome(serverLaunchParameters)(_.serverLaunchParameters(_))
        .ifSome(logPaths)(_.logPaths(_))
        .ifSome(eC2InstanceType)(_.eC2InstanceType(_))
        .ifSome(eC2InboundPermissions)(_.eC2InboundPermissions(_))
        .ifSome(newGameSessionProtectionPolicy)(_.newGameSessionProtectionPolicy(_))
        .ifSome(runtimeConfiguration)(_.runtimeConfiguration(_))
        .ifSome(resourceCreationLimitPolicy)(_.resourceCreationLimitPolicy(_))
        .ifSome(metricGroups)(_.metricGroups(_))
        .ifSome(peerVpcAwsAccountId)(_.peerVpcAwsAccountId(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .ifSome(fleetType)(_.fleetType(_))
        .ifSome(instanceRoleArn)(_.instanceRoleArn(_))
        .ifSome(certificateConfiguration)(_.certificateConfiguration(_))
        .ifSome(locations)(_.locations(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFleetLocationsInput(
      fleetId: Option[String] = None,
      locations: Option[List[LocationConfiguration]] = None
    ): CreateFleetLocationsInput =
      CreateFleetLocationsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(locations)(_.locations(_))
        .build

    def createFleetLocationsOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      locationStates: Option[List[LocationState]] = None
    ): CreateFleetLocationsOutput =
      CreateFleetLocationsOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(locationStates)(_.locationStates(_))
        .build

    def createFleetOutput(
      fleetAttributes: Option[FleetAttributes] = None,
      locationStates: Option[List[LocationState]] = None
    ): CreateFleetOutput =
      CreateFleetOutput
        .builder
        .ifSome(fleetAttributes)(_.fleetAttributes(_))
        .ifSome(locationStates)(_.locationStates(_))
        .build

    def createGameServerGroupInput(
      gameServerGroupName: Option[String] = None,
      roleArn: Option[String] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      launchTemplate: Option[LaunchTemplateSpecification] = None,
      instanceDefinitions: Option[List[InstanceDefinition]] = None,
      autoScalingPolicy: Option[GameServerGroupAutoScalingPolicy] = None,
      balancingStrategy: Option[String] = None,
      gameServerProtectionPolicy: Option[String] = None,
      vpcSubnets: Option[List[VpcSubnet]] = None,
      tags: Option[List[Tag]] = None
    ): CreateGameServerGroupInput =
      CreateGameServerGroupInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(launchTemplate)(_.launchTemplate(_))
        .ifSome(instanceDefinitions)(_.instanceDefinitions(_))
        .ifSome(autoScalingPolicy)(_.autoScalingPolicy(_))
        .ifSome(balancingStrategy)(_.balancingStrategy(_))
        .ifSome(gameServerProtectionPolicy)(_.gameServerProtectionPolicy(_))
        .ifSome(vpcSubnets)(_.vpcSubnets(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGameServerGroupOutput(
      gameServerGroup: Option[GameServerGroup] = None
    ): CreateGameServerGroupOutput =
      CreateGameServerGroupOutput
        .builder
        .ifSome(gameServerGroup)(_.gameServerGroup(_))
        .build

    def createGameSessionInput(
      fleetId: Option[String] = None,
      aliasId: Option[String] = None,
      maximumPlayerSessionCount: Option[Int] = None,
      name: Option[String] = None,
      gameProperties: Option[List[GameProperty]] = None,
      creatorId: Option[String] = None,
      gameSessionId: Option[String] = None,
      idempotencyToken: Option[String] = None,
      gameSessionData: Option[String] = None,
      location: Option[String] = None
    ): CreateGameSessionInput =
      CreateGameSessionInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(maximumPlayerSessionCount)(_.maximumPlayerSessionCount(_))
        .ifSome(name)(_.name(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(creatorId)(_.creatorId(_))
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .ifSome(location)(_.location(_))
        .build

    def createGameSessionOutput(
      gameSession: Option[GameSession] = None
    ): CreateGameSessionOutput =
      CreateGameSessionOutput
        .builder
        .ifSome(gameSession)(_.gameSession(_))
        .build

    def createGameSessionQueueInput(
      name: Option[String] = None,
      timeoutInSeconds: Option[Int] = None,
      playerLatencyPolicies: Option[List[PlayerLatencyPolicy]] = None,
      destinations: Option[List[GameSessionQueueDestination]] = None,
      filterConfiguration: Option[FilterConfiguration] = None,
      priorityConfiguration: Option[PriorityConfiguration] = None,
      customEventData: Option[String] = None,
      notificationTarget: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateGameSessionQueueInput =
      CreateGameSessionQueueInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(playerLatencyPolicies)(_.playerLatencyPolicies(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(filterConfiguration)(_.filterConfiguration(_))
        .ifSome(priorityConfiguration)(_.priorityConfiguration(_))
        .ifSome(customEventData)(_.customEventData(_))
        .ifSome(notificationTarget)(_.notificationTarget(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGameSessionQueueOutput(
      gameSessionQueue: Option[GameSessionQueue] = None
    ): CreateGameSessionQueueOutput =
      CreateGameSessionQueueOutput
        .builder
        .ifSome(gameSessionQueue)(_.gameSessionQueue(_))
        .build

    def createMatchmakingConfigurationInput(
      name: Option[String] = None,
      description: Option[String] = None,
      gameSessionQueueArns: Option[List[ArnStringModel]] = None,
      requestTimeoutSeconds: Option[Int] = None,
      acceptanceTimeoutSeconds: Option[Int] = None,
      acceptanceRequired: Option[Boolean] = None,
      ruleSetName: Option[String] = None,
      notificationTarget: Option[String] = None,
      additionalPlayerCount: Option[Int] = None,
      customEventData: Option[String] = None,
      gameProperties: Option[List[GameProperty]] = None,
      gameSessionData: Option[String] = None,
      backfillMode: Option[String] = None,
      flexMatchMode: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateMatchmakingConfigurationInput =
      CreateMatchmakingConfigurationInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(gameSessionQueueArns)(_.gameSessionQueueArns(_))
        .ifSome(requestTimeoutSeconds)(_.requestTimeoutSeconds(_))
        .ifSome(acceptanceTimeoutSeconds)(_.acceptanceTimeoutSeconds(_))
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(notificationTarget)(_.notificationTarget(_))
        .ifSome(additionalPlayerCount)(_.additionalPlayerCount(_))
        .ifSome(customEventData)(_.customEventData(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .ifSome(backfillMode)(_.backfillMode(_))
        .ifSome(flexMatchMode)(_.flexMatchMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMatchmakingConfigurationOutput(
      configuration: Option[MatchmakingConfiguration] = None
    ): CreateMatchmakingConfigurationOutput =
      CreateMatchmakingConfigurationOutput
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def createMatchmakingRuleSetInput(
      name: Option[String] = None,
      ruleSetBody: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateMatchmakingRuleSetInput =
      CreateMatchmakingRuleSetInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(ruleSetBody)(_.ruleSetBody(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMatchmakingRuleSetOutput(
      ruleSet: Option[MatchmakingRuleSet] = None
    ): CreateMatchmakingRuleSetOutput =
      CreateMatchmakingRuleSetOutput
        .builder
        .ifSome(ruleSet)(_.ruleSet(_))
        .build

    def createPlayerSessionInput(
      gameSessionId: Option[String] = None,
      playerId: Option[String] = None,
      playerData: Option[String] = None
    ): CreatePlayerSessionInput =
      CreatePlayerSessionInput
        .builder
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(playerId)(_.playerId(_))
        .ifSome(playerData)(_.playerData(_))
        .build

    def createPlayerSessionOutput(
      playerSession: Option[PlayerSession] = None
    ): CreatePlayerSessionOutput =
      CreatePlayerSessionOutput
        .builder
        .ifSome(playerSession)(_.playerSession(_))
        .build

    def createPlayerSessionsInput(
      gameSessionId: Option[String] = None,
      playerIds: Option[List[NonZeroAndMaxString]] = None,
      playerDataMap: Option[PlayerDataMap] = None
    ): CreatePlayerSessionsInput =
      CreatePlayerSessionsInput
        .builder
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(playerIds)(_.playerIds(_))
        .ifSome(playerDataMap)(_.playerDataMap(_))
        .build

    def createPlayerSessionsOutput(
      playerSessions: Option[List[PlayerSession]] = None
    ): CreatePlayerSessionsOutput =
      CreatePlayerSessionsOutput
        .builder
        .ifSome(playerSessions)(_.playerSessions(_))
        .build

    def createScriptInput(
      name: Option[String] = None,
      version: Option[String] = None,
      storageLocation: Option[S3Location] = None,
      zipFile: Option[ZipBlob] = None,
      tags: Option[List[Tag]] = None
    ): CreateScriptInput =
      CreateScriptInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(storageLocation)(_.storageLocation(_))
        .ifSome(zipFile)(_.zipFile(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createScriptOutput(
      script: Option[Script] = None
    ): CreateScriptOutput =
      CreateScriptOutput
        .builder
        .ifSome(script)(_.script(_))
        .build

    def createVpcPeeringAuthorizationInput(
      gameLiftAwsAccountId: Option[String] = None,
      peerVpcId: Option[String] = None
    ): CreateVpcPeeringAuthorizationInput =
      CreateVpcPeeringAuthorizationInput
        .builder
        .ifSome(gameLiftAwsAccountId)(_.gameLiftAwsAccountId(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .build

    def createVpcPeeringAuthorizationOutput(
      vpcPeeringAuthorization: Option[VpcPeeringAuthorization] = None
    ): CreateVpcPeeringAuthorizationOutput =
      CreateVpcPeeringAuthorizationOutput
        .builder
        .ifSome(vpcPeeringAuthorization)(_.vpcPeeringAuthorization(_))
        .build

    def createVpcPeeringConnectionInput(
      fleetId: Option[String] = None,
      peerVpcAwsAccountId: Option[String] = None,
      peerVpcId: Option[String] = None
    ): CreateVpcPeeringConnectionInput =
      CreateVpcPeeringConnectionInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(peerVpcAwsAccountId)(_.peerVpcAwsAccountId(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .build

    def createVpcPeeringConnectionOutput(

    ): CreateVpcPeeringConnectionOutput =
      CreateVpcPeeringConnectionOutput
        .builder

        .build

    def deleteAliasInput(
      aliasId: Option[String] = None
    ): DeleteAliasInput =
      DeleteAliasInput
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .build

    def deleteBuildInput(
      buildId: Option[String] = None
    ): DeleteBuildInput =
      DeleteBuildInput
        .builder
        .ifSome(buildId)(_.buildId(_))
        .build

    def deleteFleetInput(
      fleetId: Option[String] = None
    ): DeleteFleetInput =
      DeleteFleetInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def deleteFleetLocationsInput(
      fleetId: Option[String] = None,
      locations: Option[List[LocationStringModel]] = None
    ): DeleteFleetLocationsInput =
      DeleteFleetLocationsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(locations)(_.locations(_))
        .build

    def deleteFleetLocationsOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      locationStates: Option[List[LocationState]] = None
    ): DeleteFleetLocationsOutput =
      DeleteFleetLocationsOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(locationStates)(_.locationStates(_))
        .build

    def deleteGameServerGroupInput(
      gameServerGroupName: Option[String] = None,
      deleteOption: Option[String] = None
    ): DeleteGameServerGroupInput =
      DeleteGameServerGroupInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(deleteOption)(_.deleteOption(_))
        .build

    def deleteGameServerGroupOutput(
      gameServerGroup: Option[GameServerGroup] = None
    ): DeleteGameServerGroupOutput =
      DeleteGameServerGroupOutput
        .builder
        .ifSome(gameServerGroup)(_.gameServerGroup(_))
        .build

    def deleteGameSessionQueueInput(
      name: Option[String] = None
    ): DeleteGameSessionQueueInput =
      DeleteGameSessionQueueInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteGameSessionQueueOutput(

    ): DeleteGameSessionQueueOutput =
      DeleteGameSessionQueueOutput
        .builder

        .build

    def deleteMatchmakingConfigurationInput(
      name: Option[String] = None
    ): DeleteMatchmakingConfigurationInput =
      DeleteMatchmakingConfigurationInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteMatchmakingConfigurationOutput(

    ): DeleteMatchmakingConfigurationOutput =
      DeleteMatchmakingConfigurationOutput
        .builder

        .build

    def deleteMatchmakingRuleSetInput(
      name: Option[String] = None
    ): DeleteMatchmakingRuleSetInput =
      DeleteMatchmakingRuleSetInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteMatchmakingRuleSetOutput(

    ): DeleteMatchmakingRuleSetOutput =
      DeleteMatchmakingRuleSetOutput
        .builder

        .build

    def deleteScalingPolicyInput(
      name: Option[String] = None,
      fleetId: Option[String] = None
    ): DeleteScalingPolicyInput =
      DeleteScalingPolicyInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def deleteScriptInput(
      scriptId: Option[String] = None
    ): DeleteScriptInput =
      DeleteScriptInput
        .builder
        .ifSome(scriptId)(_.scriptId(_))
        .build

    def deleteVpcPeeringAuthorizationInput(
      gameLiftAwsAccountId: Option[String] = None,
      peerVpcId: Option[String] = None
    ): DeleteVpcPeeringAuthorizationInput =
      DeleteVpcPeeringAuthorizationInput
        .builder
        .ifSome(gameLiftAwsAccountId)(_.gameLiftAwsAccountId(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .build

    def deleteVpcPeeringAuthorizationOutput(

    ): DeleteVpcPeeringAuthorizationOutput =
      DeleteVpcPeeringAuthorizationOutput
        .builder

        .build

    def deleteVpcPeeringConnectionInput(
      fleetId: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None
    ): DeleteVpcPeeringConnectionInput =
      DeleteVpcPeeringConnectionInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .build

    def deleteVpcPeeringConnectionOutput(

    ): DeleteVpcPeeringConnectionOutput =
      DeleteVpcPeeringConnectionOutput
        .builder

        .build

    def deregisterGameServerInput(
      gameServerGroupName: Option[String] = None,
      gameServerId: Option[String] = None
    ): DeregisterGameServerInput =
      DeregisterGameServerInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerId)(_.gameServerId(_))
        .build

    def describeAliasInput(
      aliasId: Option[String] = None
    ): DescribeAliasInput =
      DescribeAliasInput
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .build

    def describeAliasOutput(
      alias: Option[Alias] = None
    ): DescribeAliasOutput =
      DescribeAliasOutput
        .builder
        .ifSome(alias)(_.alias(_))
        .build

    def describeBuildInput(
      buildId: Option[String] = None
    ): DescribeBuildInput =
      DescribeBuildInput
        .builder
        .ifSome(buildId)(_.buildId(_))
        .build

    def describeBuildOutput(
      build: Option[Build] = None
    ): DescribeBuildOutput =
      DescribeBuildOutput
        .builder
        .ifSome(build)(_.build(_))
        .build

    def describeEC2InstanceLimitsInput(
      eC2InstanceType: Option[String] = None,
      location: Option[String] = None
    ): DescribeEC2InstanceLimitsInput =
      DescribeEC2InstanceLimitsInput
        .builder
        .ifSome(eC2InstanceType)(_.eC2InstanceType(_))
        .ifSome(location)(_.location(_))
        .build

    def describeEC2InstanceLimitsOutput(
      eC2InstanceLimits: Option[List[EC2InstanceLimit]] = None
    ): DescribeEC2InstanceLimitsOutput =
      DescribeEC2InstanceLimitsOutput
        .builder
        .ifSome(eC2InstanceLimits)(_.eC2InstanceLimits(_))
        .build

    def describeFleetAttributesInput(
      fleetIds: Option[List[FleetIdOrArn]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFleetAttributesInput =
      DescribeFleetAttributesInput
        .builder
        .ifSome(fleetIds)(_.fleetIds(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetAttributesOutput(
      fleetAttributes: Option[List[FleetAttributes]] = None,
      nextToken: Option[String] = None
    ): DescribeFleetAttributesOutput =
      DescribeFleetAttributesOutput
        .builder
        .ifSome(fleetAttributes)(_.fleetAttributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetCapacityInput(
      fleetIds: Option[List[FleetIdOrArn]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFleetCapacityInput =
      DescribeFleetCapacityInput
        .builder
        .ifSome(fleetIds)(_.fleetIds(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetCapacityOutput(
      fleetCapacity: Option[List[FleetCapacity]] = None,
      nextToken: Option[String] = None
    ): DescribeFleetCapacityOutput =
      DescribeFleetCapacityOutput
        .builder
        .ifSome(fleetCapacity)(_.fleetCapacity(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetEventsInput(
      fleetId: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFleetEventsInput =
      DescribeFleetEventsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetEventsOutput(
      events: Option[List[Event]] = None,
      nextToken: Option[String] = None
    ): DescribeFleetEventsOutput =
      DescribeFleetEventsOutput
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetLocationAttributesInput(
      fleetId: Option[String] = None,
      locations: Option[List[LocationStringModel]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFleetLocationAttributesInput =
      DescribeFleetLocationAttributesInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(locations)(_.locations(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetLocationAttributesOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      locationAttributes: Option[List[LocationAttributes]] = None,
      nextToken: Option[String] = None
    ): DescribeFleetLocationAttributesOutput =
      DescribeFleetLocationAttributesOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(locationAttributes)(_.locationAttributes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetLocationCapacityInput(
      fleetId: Option[String] = None,
      location: Option[String] = None
    ): DescribeFleetLocationCapacityInput =
      DescribeFleetLocationCapacityInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(location)(_.location(_))
        .build

    def describeFleetLocationCapacityOutput(
      fleetCapacity: Option[FleetCapacity] = None
    ): DescribeFleetLocationCapacityOutput =
      DescribeFleetLocationCapacityOutput
        .builder
        .ifSome(fleetCapacity)(_.fleetCapacity(_))
        .build

    def describeFleetLocationUtilizationInput(
      fleetId: Option[String] = None,
      location: Option[String] = None
    ): DescribeFleetLocationUtilizationInput =
      DescribeFleetLocationUtilizationInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(location)(_.location(_))
        .build

    def describeFleetLocationUtilizationOutput(
      fleetUtilization: Option[FleetUtilization] = None
    ): DescribeFleetLocationUtilizationOutput =
      DescribeFleetLocationUtilizationOutput
        .builder
        .ifSome(fleetUtilization)(_.fleetUtilization(_))
        .build

    def describeFleetPortSettingsInput(
      fleetId: Option[String] = None,
      location: Option[String] = None
    ): DescribeFleetPortSettingsInput =
      DescribeFleetPortSettingsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(location)(_.location(_))
        .build

    def describeFleetPortSettingsOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      inboundPermissions: Option[List[IpPermission]] = None,
      updateStatus: Option[String] = None,
      location: Option[String] = None
    ): DescribeFleetPortSettingsOutput =
      DescribeFleetPortSettingsOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(inboundPermissions)(_.inboundPermissions(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(location)(_.location(_))
        .build

    def describeFleetUtilizationInput(
      fleetIds: Option[List[FleetIdOrArn]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFleetUtilizationInput =
      DescribeFleetUtilizationInput
        .builder
        .ifSome(fleetIds)(_.fleetIds(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetUtilizationOutput(
      fleetUtilization: Option[List[FleetUtilization]] = None,
      nextToken: Option[String] = None
    ): DescribeFleetUtilizationOutput =
      DescribeFleetUtilizationOutput
        .builder
        .ifSome(fleetUtilization)(_.fleetUtilization(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameServerGroupInput(
      gameServerGroupName: Option[String] = None
    ): DescribeGameServerGroupInput =
      DescribeGameServerGroupInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .build

    def describeGameServerGroupOutput(
      gameServerGroup: Option[GameServerGroup] = None
    ): DescribeGameServerGroupOutput =
      DescribeGameServerGroupOutput
        .builder
        .ifSome(gameServerGroup)(_.gameServerGroup(_))
        .build

    def describeGameServerInput(
      gameServerGroupName: Option[String] = None,
      gameServerId: Option[String] = None
    ): DescribeGameServerInput =
      DescribeGameServerInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerId)(_.gameServerId(_))
        .build

    def describeGameServerInstancesInput(
      gameServerGroupName: Option[String] = None,
      instanceIds: Option[List[GameServerInstanceId]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeGameServerInstancesInput =
      DescribeGameServerInstancesInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(instanceIds)(_.instanceIds(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameServerInstancesOutput(
      gameServerInstances: Option[List[GameServerInstance]] = None,
      nextToken: Option[String] = None
    ): DescribeGameServerInstancesOutput =
      DescribeGameServerInstancesOutput
        .builder
        .ifSome(gameServerInstances)(_.gameServerInstances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameServerOutput(
      gameServer: Option[GameServer] = None
    ): DescribeGameServerOutput =
      DescribeGameServerOutput
        .builder
        .ifSome(gameServer)(_.gameServer(_))
        .build

    def describeGameSessionDetailsInput(
      fleetId: Option[String] = None,
      gameSessionId: Option[String] = None,
      aliasId: Option[String] = None,
      location: Option[String] = None,
      statusFilter: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeGameSessionDetailsInput =
      DescribeGameSessionDetailsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(location)(_.location(_))
        .ifSome(statusFilter)(_.statusFilter(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameSessionDetailsOutput(
      gameSessionDetails: Option[List[GameSessionDetail]] = None,
      nextToken: Option[String] = None
    ): DescribeGameSessionDetailsOutput =
      DescribeGameSessionDetailsOutput
        .builder
        .ifSome(gameSessionDetails)(_.gameSessionDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameSessionPlacementInput(
      placementId: Option[String] = None
    ): DescribeGameSessionPlacementInput =
      DescribeGameSessionPlacementInput
        .builder
        .ifSome(placementId)(_.placementId(_))
        .build

    def describeGameSessionPlacementOutput(
      gameSessionPlacement: Option[GameSessionPlacement] = None
    ): DescribeGameSessionPlacementOutput =
      DescribeGameSessionPlacementOutput
        .builder
        .ifSome(gameSessionPlacement)(_.gameSessionPlacement(_))
        .build

    def describeGameSessionQueuesInput(
      names: Option[List[GameSessionQueueNameOrArn]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeGameSessionQueuesInput =
      DescribeGameSessionQueuesInput
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameSessionQueuesOutput(
      gameSessionQueues: Option[List[GameSessionQueue]] = None,
      nextToken: Option[String] = None
    ): DescribeGameSessionQueuesOutput =
      DescribeGameSessionQueuesOutput
        .builder
        .ifSome(gameSessionQueues)(_.gameSessionQueues(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameSessionsInput(
      fleetId: Option[String] = None,
      gameSessionId: Option[String] = None,
      aliasId: Option[String] = None,
      location: Option[String] = None,
      statusFilter: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeGameSessionsInput =
      DescribeGameSessionsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(location)(_.location(_))
        .ifSome(statusFilter)(_.statusFilter(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeGameSessionsOutput(
      gameSessions: Option[List[GameSession]] = None,
      nextToken: Option[String] = None
    ): DescribeGameSessionsOutput =
      DescribeGameSessionsOutput
        .builder
        .ifSome(gameSessions)(_.gameSessions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstancesInput(
      fleetId: Option[String] = None,
      instanceId: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      location: Option[String] = None
    ): DescribeInstancesInput =
      DescribeInstancesInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(location)(_.location(_))
        .build

    def describeInstancesOutput(
      instances: Option[List[Instance]] = None,
      nextToken: Option[String] = None
    ): DescribeInstancesOutput =
      DescribeInstancesOutput
        .builder
        .ifSome(instances)(_.instances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMatchmakingConfigurationsInput(
      names: Option[List[MatchmakingConfigurationName]] = None,
      ruleSetName: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMatchmakingConfigurationsInput =
      DescribeMatchmakingConfigurationsInput
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMatchmakingConfigurationsOutput(
      configurations: Option[List[MatchmakingConfiguration]] = None,
      nextToken: Option[String] = None
    ): DescribeMatchmakingConfigurationsOutput =
      DescribeMatchmakingConfigurationsOutput
        .builder
        .ifSome(configurations)(_.configurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMatchmakingInput(
      ticketIds: Option[List[MatchmakingIdStringModel]] = None
    ): DescribeMatchmakingInput =
      DescribeMatchmakingInput
        .builder
        .ifSome(ticketIds)(_.ticketIds(_))
        .build

    def describeMatchmakingOutput(
      ticketList: Option[List[MatchmakingTicket]] = None
    ): DescribeMatchmakingOutput =
      DescribeMatchmakingOutput
        .builder
        .ifSome(ticketList)(_.ticketList(_))
        .build

    def describeMatchmakingRuleSetsInput(
      names: Option[List[MatchmakingRuleSetName]] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeMatchmakingRuleSetsInput =
      DescribeMatchmakingRuleSetsInput
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeMatchmakingRuleSetsOutput(
      ruleSets: Option[List[MatchmakingRuleSet]] = None,
      nextToken: Option[String] = None
    ): DescribeMatchmakingRuleSetsOutput =
      DescribeMatchmakingRuleSetsOutput
        .builder
        .ifSome(ruleSets)(_.ruleSets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePlayerSessionsInput(
      gameSessionId: Option[String] = None,
      playerId: Option[String] = None,
      playerSessionId: Option[String] = None,
      playerSessionStatusFilter: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribePlayerSessionsInput =
      DescribePlayerSessionsInput
        .builder
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(playerId)(_.playerId(_))
        .ifSome(playerSessionId)(_.playerSessionId(_))
        .ifSome(playerSessionStatusFilter)(_.playerSessionStatusFilter(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePlayerSessionsOutput(
      playerSessions: Option[List[PlayerSession]] = None,
      nextToken: Option[String] = None
    ): DescribePlayerSessionsOutput =
      DescribePlayerSessionsOutput
        .builder
        .ifSome(playerSessions)(_.playerSessions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRuntimeConfigurationInput(
      fleetId: Option[String] = None
    ): DescribeRuntimeConfigurationInput =
      DescribeRuntimeConfigurationInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def describeRuntimeConfigurationOutput(
      runtimeConfiguration: Option[RuntimeConfiguration] = None
    ): DescribeRuntimeConfigurationOutput =
      DescribeRuntimeConfigurationOutput
        .builder
        .ifSome(runtimeConfiguration)(_.runtimeConfiguration(_))
        .build

    def describeScalingPoliciesInput(
      fleetId: Option[String] = None,
      statusFilter: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None,
      location: Option[String] = None
    ): DescribeScalingPoliciesInput =
      DescribeScalingPoliciesInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(statusFilter)(_.statusFilter(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(location)(_.location(_))
        .build

    def describeScalingPoliciesOutput(
      scalingPolicies: Option[List[ScalingPolicy]] = None,
      nextToken: Option[String] = None
    ): DescribeScalingPoliciesOutput =
      DescribeScalingPoliciesOutput
        .builder
        .ifSome(scalingPolicies)(_.scalingPolicies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScriptInput(
      scriptId: Option[String] = None
    ): DescribeScriptInput =
      DescribeScriptInput
        .builder
        .ifSome(scriptId)(_.scriptId(_))
        .build

    def describeScriptOutput(
      script: Option[Script] = None
    ): DescribeScriptOutput =
      DescribeScriptOutput
        .builder
        .ifSome(script)(_.script(_))
        .build

    def describeVpcPeeringAuthorizationsInput(

    ): DescribeVpcPeeringAuthorizationsInput =
      DescribeVpcPeeringAuthorizationsInput
        .builder

        .build

    def describeVpcPeeringAuthorizationsOutput(
      vpcPeeringAuthorizations: Option[List[VpcPeeringAuthorization]] = None
    ): DescribeVpcPeeringAuthorizationsOutput =
      DescribeVpcPeeringAuthorizationsOutput
        .builder
        .ifSome(vpcPeeringAuthorizations)(_.vpcPeeringAuthorizations(_))
        .build

    def describeVpcPeeringConnectionsInput(
      fleetId: Option[String] = None
    ): DescribeVpcPeeringConnectionsInput =
      DescribeVpcPeeringConnectionsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def describeVpcPeeringConnectionsOutput(
      vpcPeeringConnections: Option[List[VpcPeeringConnection]] = None
    ): DescribeVpcPeeringConnectionsOutput =
      DescribeVpcPeeringConnectionsOutput
        .builder
        .ifSome(vpcPeeringConnections)(_.vpcPeeringConnections(_))
        .build

    def desiredPlayerSession(
      playerId: Option[String] = None,
      playerData: Option[String] = None
    ): DesiredPlayerSession =
      DesiredPlayerSession
        .builder
        .ifSome(playerId)(_.playerId(_))
        .ifSome(playerData)(_.playerData(_))
        .build

    def eC2InstanceCounts(
      dESIRED: Option[Int] = None,
      mINIMUM: Option[Int] = None,
      mAXIMUM: Option[Int] = None,
      pENDING: Option[Int] = None,
      aCTIVE: Option[Int] = None,
      iDLE: Option[Int] = None,
      tERMINATING: Option[Int] = None
    ): EC2InstanceCounts =
      EC2InstanceCounts
        .builder
        .ifSome(dESIRED)(_.dESIRED(_))
        .ifSome(mINIMUM)(_.mINIMUM(_))
        .ifSome(mAXIMUM)(_.mAXIMUM(_))
        .ifSome(pENDING)(_.pENDING(_))
        .ifSome(aCTIVE)(_.aCTIVE(_))
        .ifSome(iDLE)(_.iDLE(_))
        .ifSome(tERMINATING)(_.tERMINATING(_))
        .build

    def eC2InstanceLimit(
      eC2InstanceType: Option[String] = None,
      currentInstances: Option[Int] = None,
      instanceLimit: Option[Int] = None,
      location: Option[String] = None
    ): EC2InstanceLimit =
      EC2InstanceLimit
        .builder
        .ifSome(eC2InstanceType)(_.eC2InstanceType(_))
        .ifSome(currentInstances)(_.currentInstances(_))
        .ifSome(instanceLimit)(_.instanceLimit(_))
        .ifSome(location)(_.location(_))
        .build

    def event(
      eventId: Option[String] = None,
      resourceId: Option[String] = None,
      eventCode: Option[String] = None,
      message: Option[String] = None,
      eventTime: Option[Timestamp] = None,
      preSignedLogUrl: Option[String] = None
    ): Event =
      Event
        .builder
        .ifSome(eventId)(_.eventId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(eventCode)(_.eventCode(_))
        .ifSome(message)(_.message(_))
        .ifSome(eventTime)(_.eventTime(_))
        .ifSome(preSignedLogUrl)(_.preSignedLogUrl(_))
        .build

    def filterConfiguration(
      allowedLocations: Option[List[LocationStringModel]] = None
    ): FilterConfiguration =
      FilterConfiguration
        .builder
        .ifSome(allowedLocations)(_.allowedLocations(_))
        .build

    def fleetAttributes(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      fleetType: Option[String] = None,
      instanceType: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      terminationTime: Option[Timestamp] = None,
      status: Option[String] = None,
      buildId: Option[String] = None,
      buildArn: Option[String] = None,
      scriptId: Option[String] = None,
      scriptArn: Option[String] = None,
      serverLaunchPath: Option[String] = None,
      serverLaunchParameters: Option[String] = None,
      logPaths: Option[List[NonZeroAndMaxString]] = None,
      newGameSessionProtectionPolicy: Option[String] = None,
      operatingSystem: Option[String] = None,
      resourceCreationLimitPolicy: Option[ResourceCreationLimitPolicy] = None,
      metricGroups: Option[List[MetricGroup]] = None,
      stoppedActions: Option[List[FleetAction]] = None,
      instanceRoleArn: Option[String] = None,
      certificateConfiguration: Option[CertificateConfiguration] = None
    ): FleetAttributes =
      FleetAttributes
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(fleetType)(_.fleetType(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(terminationTime)(_.terminationTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(buildId)(_.buildId(_))
        .ifSome(buildArn)(_.buildArn(_))
        .ifSome(scriptId)(_.scriptId(_))
        .ifSome(scriptArn)(_.scriptArn(_))
        .ifSome(serverLaunchPath)(_.serverLaunchPath(_))
        .ifSome(serverLaunchParameters)(_.serverLaunchParameters(_))
        .ifSome(logPaths)(_.logPaths(_))
        .ifSome(newGameSessionProtectionPolicy)(_.newGameSessionProtectionPolicy(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(resourceCreationLimitPolicy)(_.resourceCreationLimitPolicy(_))
        .ifSome(metricGroups)(_.metricGroups(_))
        .ifSome(stoppedActions)(_.stoppedActions(_))
        .ifSome(instanceRoleArn)(_.instanceRoleArn(_))
        .ifSome(certificateConfiguration)(_.certificateConfiguration(_))
        .build

    def fleetCapacity(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      instanceType: Option[String] = None,
      instanceCounts: Option[EC2InstanceCounts] = None,
      location: Option[String] = None
    ): FleetCapacity =
      FleetCapacity
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(instanceCounts)(_.instanceCounts(_))
        .ifSome(location)(_.location(_))
        .build

    def fleetCapacityExceededException(
      message: Option[String] = None
    ): FleetCapacityExceededException =
      FleetCapacityExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fleetUtilization(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      activeServerProcessCount: Option[Int] = None,
      activeGameSessionCount: Option[Int] = None,
      currentPlayerSessionCount: Option[Int] = None,
      maximumPlayerSessionCount: Option[Int] = None,
      location: Option[String] = None
    ): FleetUtilization =
      FleetUtilization
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(activeServerProcessCount)(_.activeServerProcessCount(_))
        .ifSome(activeGameSessionCount)(_.activeGameSessionCount(_))
        .ifSome(currentPlayerSessionCount)(_.currentPlayerSessionCount(_))
        .ifSome(maximumPlayerSessionCount)(_.maximumPlayerSessionCount(_))
        .ifSome(location)(_.location(_))
        .build

    def gameProperty(
      key: Option[String] = None,
      value: Option[String] = None
    ): GameProperty =
      GameProperty
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def gameServer(
      gameServerGroupName: Option[String] = None,
      gameServerGroupArn: Option[String] = None,
      gameServerId: Option[String] = None,
      instanceId: Option[String] = None,
      connectionInfo: Option[String] = None,
      gameServerData: Option[String] = None,
      claimStatus: Option[String] = None,
      utilizationStatus: Option[String] = None,
      registrationTime: Option[Timestamp] = None,
      lastClaimTime: Option[Timestamp] = None,
      lastHealthCheckTime: Option[Timestamp] = None
    ): GameServer =
      GameServer
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerGroupArn)(_.gameServerGroupArn(_))
        .ifSome(gameServerId)(_.gameServerId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(connectionInfo)(_.connectionInfo(_))
        .ifSome(gameServerData)(_.gameServerData(_))
        .ifSome(claimStatus)(_.claimStatus(_))
        .ifSome(utilizationStatus)(_.utilizationStatus(_))
        .ifSome(registrationTime)(_.registrationTime(_))
        .ifSome(lastClaimTime)(_.lastClaimTime(_))
        .ifSome(lastHealthCheckTime)(_.lastHealthCheckTime(_))
        .build

    def gameServerGroup(
      gameServerGroupName: Option[String] = None,
      gameServerGroupArn: Option[String] = None,
      roleArn: Option[String] = None,
      instanceDefinitions: Option[List[InstanceDefinition]] = None,
      balancingStrategy: Option[String] = None,
      gameServerProtectionPolicy: Option[String] = None,
      autoScalingGroupArn: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      suspendedActions: Option[List[GameServerGroupAction]] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdatedTime: Option[Timestamp] = None
    ): GameServerGroup =
      GameServerGroup
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerGroupArn)(_.gameServerGroupArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(instanceDefinitions)(_.instanceDefinitions(_))
        .ifSome(balancingStrategy)(_.balancingStrategy(_))
        .ifSome(gameServerProtectionPolicy)(_.gameServerProtectionPolicy(_))
        .ifSome(autoScalingGroupArn)(_.autoScalingGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(suspendedActions)(_.suspendedActions(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def gameServerGroupAutoScalingPolicy(
      estimatedInstanceWarmup: Option[Int] = None,
      targetTrackingConfiguration: Option[TargetTrackingConfiguration] = None
    ): GameServerGroupAutoScalingPolicy =
      GameServerGroupAutoScalingPolicy
        .builder
        .ifSome(estimatedInstanceWarmup)(_.estimatedInstanceWarmup(_))
        .ifSome(targetTrackingConfiguration)(_.targetTrackingConfiguration(_))
        .build

    def gameServerInstance(
      gameServerGroupName: Option[String] = None,
      gameServerGroupArn: Option[String] = None,
      instanceId: Option[String] = None,
      instanceStatus: Option[String] = None
    ): GameServerInstance =
      GameServerInstance
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerGroupArn)(_.gameServerGroupArn(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceStatus)(_.instanceStatus(_))
        .build

    def gameSession(
      gameSessionId: Option[String] = None,
      name: Option[String] = None,
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      terminationTime: Option[Timestamp] = None,
      currentPlayerSessionCount: Option[Int] = None,
      maximumPlayerSessionCount: Option[Int] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      gameProperties: Option[List[GameProperty]] = None,
      ipAddress: Option[String] = None,
      dnsName: Option[String] = None,
      port: Option[Int] = None,
      playerSessionCreationPolicy: Option[String] = None,
      creatorId: Option[String] = None,
      gameSessionData: Option[String] = None,
      matchmakerData: Option[String] = None,
      location: Option[String] = None
    ): GameSession =
      GameSession
        .builder
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(name)(_.name(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(terminationTime)(_.terminationTime(_))
        .ifSome(currentPlayerSessionCount)(_.currentPlayerSessionCount(_))
        .ifSome(maximumPlayerSessionCount)(_.maximumPlayerSessionCount(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(port)(_.port(_))
        .ifSome(playerSessionCreationPolicy)(_.playerSessionCreationPolicy(_))
        .ifSome(creatorId)(_.creatorId(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .ifSome(matchmakerData)(_.matchmakerData(_))
        .ifSome(location)(_.location(_))
        .build

    def gameSessionConnectionInfo(
      gameSessionArn: Option[String] = None,
      ipAddress: Option[String] = None,
      dnsName: Option[String] = None,
      port: Option[Int] = None,
      matchedPlayerSessions: Option[List[MatchedPlayerSession]] = None
    ): GameSessionConnectionInfo =
      GameSessionConnectionInfo
        .builder
        .ifSome(gameSessionArn)(_.gameSessionArn(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(port)(_.port(_))
        .ifSome(matchedPlayerSessions)(_.matchedPlayerSessions(_))
        .build

    def gameSessionDetail(
      gameSession: Option[GameSession] = None,
      protectionPolicy: Option[String] = None
    ): GameSessionDetail =
      GameSessionDetail
        .builder
        .ifSome(gameSession)(_.gameSession(_))
        .ifSome(protectionPolicy)(_.protectionPolicy(_))
        .build

    def gameSessionFullException(
      message: Option[String] = None
    ): GameSessionFullException =
      GameSessionFullException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def gameSessionPlacement(
      placementId: Option[String] = None,
      gameSessionQueueName: Option[String] = None,
      status: Option[String] = None,
      gameProperties: Option[List[GameProperty]] = None,
      maximumPlayerSessionCount: Option[Int] = None,
      gameSessionName: Option[String] = None,
      gameSessionId: Option[String] = None,
      gameSessionArn: Option[String] = None,
      gameSessionRegion: Option[String] = None,
      playerLatencies: Option[List[PlayerLatency]] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      ipAddress: Option[String] = None,
      dnsName: Option[String] = None,
      port: Option[Int] = None,
      placedPlayerSessions: Option[List[PlacedPlayerSession]] = None,
      gameSessionData: Option[String] = None,
      matchmakerData: Option[String] = None
    ): GameSessionPlacement =
      GameSessionPlacement
        .builder
        .ifSome(placementId)(_.placementId(_))
        .ifSome(gameSessionQueueName)(_.gameSessionQueueName(_))
        .ifSome(status)(_.status(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(maximumPlayerSessionCount)(_.maximumPlayerSessionCount(_))
        .ifSome(gameSessionName)(_.gameSessionName(_))
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(gameSessionArn)(_.gameSessionArn(_))
        .ifSome(gameSessionRegion)(_.gameSessionRegion(_))
        .ifSome(playerLatencies)(_.playerLatencies(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(port)(_.port(_))
        .ifSome(placedPlayerSessions)(_.placedPlayerSessions(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .ifSome(matchmakerData)(_.matchmakerData(_))
        .build

    def gameSessionQueue(
      name: Option[String] = None,
      gameSessionQueueArn: Option[String] = None,
      timeoutInSeconds: Option[Int] = None,
      playerLatencyPolicies: Option[List[PlayerLatencyPolicy]] = None,
      destinations: Option[List[GameSessionQueueDestination]] = None,
      filterConfiguration: Option[FilterConfiguration] = None,
      priorityConfiguration: Option[PriorityConfiguration] = None,
      customEventData: Option[String] = None,
      notificationTarget: Option[String] = None
    ): GameSessionQueue =
      GameSessionQueue
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(gameSessionQueueArn)(_.gameSessionQueueArn(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(playerLatencyPolicies)(_.playerLatencyPolicies(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(filterConfiguration)(_.filterConfiguration(_))
        .ifSome(priorityConfiguration)(_.priorityConfiguration(_))
        .ifSome(customEventData)(_.customEventData(_))
        .ifSome(notificationTarget)(_.notificationTarget(_))
        .build

    def gameSessionQueueDestination(
      destinationArn: Option[String] = None
    ): GameSessionQueueDestination =
      GameSessionQueueDestination
        .builder
        .ifSome(destinationArn)(_.destinationArn(_))
        .build

    def getGameSessionLogUrlInput(
      gameSessionId: Option[String] = None
    ): GetGameSessionLogUrlInput =
      GetGameSessionLogUrlInput
        .builder
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .build

    def getGameSessionLogUrlOutput(
      preSignedUrl: Option[String] = None
    ): GetGameSessionLogUrlOutput =
      GetGameSessionLogUrlOutput
        .builder
        .ifSome(preSignedUrl)(_.preSignedUrl(_))
        .build

    def getInstanceAccessInput(
      fleetId: Option[String] = None,
      instanceId: Option[String] = None
    ): GetInstanceAccessInput =
      GetInstanceAccessInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .build

    def getInstanceAccessOutput(
      instanceAccess: Option[InstanceAccess] = None
    ): GetInstanceAccessOutput =
      GetInstanceAccessOutput
        .builder
        .ifSome(instanceAccess)(_.instanceAccess(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def instance(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      instanceId: Option[String] = None,
      ipAddress: Option[String] = None,
      dnsName: Option[String] = None,
      operatingSystem: Option[String] = None,
      `type`: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      location: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(location)(_.location(_))
        .build

    def instanceAccess(
      fleetId: Option[String] = None,
      instanceId: Option[String] = None,
      ipAddress: Option[String] = None,
      operatingSystem: Option[String] = None,
      credentials: Option[InstanceCredentials] = None
    ): InstanceAccess =
      InstanceAccess
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(operatingSystem)(_.operatingSystem(_))
        .ifSome(credentials)(_.credentials(_))
        .build

    def instanceCredentials(
      userName: Option[String] = None,
      secret: Option[String] = None
    ): InstanceCredentials =
      InstanceCredentials
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(secret)(_.secret(_))
        .build

    def instanceDefinition(
      instanceType: Option[String] = None,
      weightedCapacity: Option[String] = None
    ): InstanceDefinition =
      InstanceDefinition
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(weightedCapacity)(_.weightedCapacity(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFleetStatusException(
      message: Option[String] = None
    ): InvalidFleetStatusException =
      InvalidFleetStatusException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidGameSessionStatusException(
      message: Option[String] = None
    ): InvalidGameSessionStatusException =
      InvalidGameSessionStatusException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ipPermission(
      fromPort: Option[Int] = None,
      toPort: Option[Int] = None,
      ipRange: Option[String] = None,
      protocol: Option[String] = None
    ): IpPermission =
      IpPermission
        .builder
        .ifSome(fromPort)(_.fromPort(_))
        .ifSome(toPort)(_.toPort(_))
        .ifSome(ipRange)(_.ipRange(_))
        .ifSome(protocol)(_.protocol(_))
        .build

    def launchTemplateSpecification(
      launchTemplateId: Option[String] = None,
      launchTemplateName: Option[String] = None,
      version: Option[String] = None
    ): LaunchTemplateSpecification =
      LaunchTemplateSpecification
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(launchTemplateName)(_.launchTemplateName(_))
        .ifSome(version)(_.version(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAliasesInput(
      routingStrategyType: Option[String] = None,
      name: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAliasesInput =
      ListAliasesInput
        .builder
        .ifSome(routingStrategyType)(_.routingStrategyType(_))
        .ifSome(name)(_.name(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAliasesOutput(
      aliases: Option[List[Alias]] = None,
      nextToken: Option[String] = None
    ): ListAliasesOutput =
      ListAliasesOutput
        .builder
        .ifSome(aliases)(_.aliases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildsInput(
      status: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBuildsInput =
      ListBuildsInput
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildsOutput(
      builds: Option[List[Build]] = None,
      nextToken: Option[String] = None
    ): ListBuildsOutput =
      ListBuildsOutput
        .builder
        .ifSome(builds)(_.builds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFleetsInput(
      buildId: Option[String] = None,
      scriptId: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListFleetsInput =
      ListFleetsInput
        .builder
        .ifSome(buildId)(_.buildId(_))
        .ifSome(scriptId)(_.scriptId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFleetsOutput(
      fleetIds: Option[List[FleetId]] = None,
      nextToken: Option[String] = None
    ): ListFleetsOutput =
      ListFleetsOutput
        .builder
        .ifSome(fleetIds)(_.fleetIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGameServerGroupsInput(
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListGameServerGroupsInput =
      ListGameServerGroupsInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGameServerGroupsOutput(
      gameServerGroups: Option[List[GameServerGroup]] = None,
      nextToken: Option[String] = None
    ): ListGameServerGroupsOutput =
      ListGameServerGroupsOutput
        .builder
        .ifSome(gameServerGroups)(_.gameServerGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGameServersInput(
      gameServerGroupName: Option[String] = None,
      sortOrder: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListGameServersInput =
      ListGameServersInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGameServersOutput(
      gameServers: Option[List[GameServer]] = None,
      nextToken: Option[String] = None
    ): ListGameServersOutput =
      ListGameServersOutput
        .builder
        .ifSome(gameServers)(_.gameServers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listScriptsInput(
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListScriptsInput =
      ListScriptsInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listScriptsOutput(
      scripts: Option[List[Script]] = None,
      nextToken: Option[String] = None
    ): ListScriptsOutput =
      ListScriptsOutput
        .builder
        .ifSome(scripts)(_.scripts(_))
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

    def locationAttributes(
      locationState: Option[LocationState] = None,
      stoppedActions: Option[List[FleetAction]] = None,
      updateStatus: Option[String] = None
    ): LocationAttributes =
      LocationAttributes
        .builder
        .ifSome(locationState)(_.locationState(_))
        .ifSome(stoppedActions)(_.stoppedActions(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .build

    def locationConfiguration(
      location: Option[String] = None
    ): LocationConfiguration =
      LocationConfiguration
        .builder
        .ifSome(location)(_.location(_))
        .build

    def locationState(
      location: Option[String] = None,
      status: Option[String] = None
    ): LocationState =
      LocationState
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(status)(_.status(_))
        .build

    def matchedPlayerSession(
      playerId: Option[String] = None,
      playerSessionId: Option[String] = None
    ): MatchedPlayerSession =
      MatchedPlayerSession
        .builder
        .ifSome(playerId)(_.playerId(_))
        .ifSome(playerSessionId)(_.playerSessionId(_))
        .build

    def matchmakingConfiguration(
      name: Option[String] = None,
      configurationArn: Option[String] = None,
      description: Option[String] = None,
      gameSessionQueueArns: Option[List[ArnStringModel]] = None,
      requestTimeoutSeconds: Option[Int] = None,
      acceptanceTimeoutSeconds: Option[Int] = None,
      acceptanceRequired: Option[Boolean] = None,
      ruleSetName: Option[String] = None,
      ruleSetArn: Option[String] = None,
      notificationTarget: Option[String] = None,
      additionalPlayerCount: Option[Int] = None,
      customEventData: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      gameProperties: Option[List[GameProperty]] = None,
      gameSessionData: Option[String] = None,
      backfillMode: Option[String] = None,
      flexMatchMode: Option[String] = None
    ): MatchmakingConfiguration =
      MatchmakingConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(configurationArn)(_.configurationArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(gameSessionQueueArns)(_.gameSessionQueueArns(_))
        .ifSome(requestTimeoutSeconds)(_.requestTimeoutSeconds(_))
        .ifSome(acceptanceTimeoutSeconds)(_.acceptanceTimeoutSeconds(_))
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(ruleSetArn)(_.ruleSetArn(_))
        .ifSome(notificationTarget)(_.notificationTarget(_))
        .ifSome(additionalPlayerCount)(_.additionalPlayerCount(_))
        .ifSome(customEventData)(_.customEventData(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .ifSome(backfillMode)(_.backfillMode(_))
        .ifSome(flexMatchMode)(_.flexMatchMode(_))
        .build

    def matchmakingRuleSet(
      ruleSetName: Option[String] = None,
      ruleSetArn: Option[String] = None,
      ruleSetBody: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): MatchmakingRuleSet =
      MatchmakingRuleSet
        .builder
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(ruleSetArn)(_.ruleSetArn(_))
        .ifSome(ruleSetBody)(_.ruleSetBody(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def matchmakingTicket(
      ticketId: Option[String] = None,
      configurationName: Option[String] = None,
      configurationArn: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      statusMessage: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      players: Option[List[Player]] = None,
      gameSessionConnectionInfo: Option[GameSessionConnectionInfo] = None,
      estimatedWaitTime: Option[Int] = None
    ): MatchmakingTicket =
      MatchmakingTicket
        .builder
        .ifSome(ticketId)(_.ticketId(_))
        .ifSome(configurationName)(_.configurationName(_))
        .ifSome(configurationArn)(_.configurationArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(players)(_.players(_))
        .ifSome(gameSessionConnectionInfo)(_.gameSessionConnectionInfo(_))
        .ifSome(estimatedWaitTime)(_.estimatedWaitTime(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def outOfCapacityException(
      message: Option[String] = None
    ): OutOfCapacityException =
      OutOfCapacityException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def placedPlayerSession(
      playerId: Option[String] = None,
      playerSessionId: Option[String] = None
    ): PlacedPlayerSession =
      PlacedPlayerSession
        .builder
        .ifSome(playerId)(_.playerId(_))
        .ifSome(playerSessionId)(_.playerSessionId(_))
        .build

    def player(
      playerId: Option[String] = None,
      playerAttributes: Option[PlayerAttributeMap] = None,
      team: Option[String] = None,
      latencyInMs: Option[LatencyMap] = None
    ): Player =
      Player
        .builder
        .ifSome(playerId)(_.playerId(_))
        .ifSome(playerAttributes)(_.playerAttributes(_))
        .ifSome(team)(_.team(_))
        .ifSome(latencyInMs)(_.latencyInMs(_))
        .build

    def playerLatency(
      playerId: Option[String] = None,
      regionIdentifier: Option[String] = None,
      latencyInMilliseconds: Option[Float] = None
    ): PlayerLatency =
      PlayerLatency
        .builder
        .ifSome(playerId)(_.playerId(_))
        .ifSome(regionIdentifier)(_.regionIdentifier(_))
        .ifSome(latencyInMilliseconds)(_.latencyInMilliseconds(_))
        .build

    def playerLatencyPolicy(
      maximumIndividualPlayerLatencyMilliseconds: Option[Int] = None,
      policyDurationSeconds: Option[Int] = None
    ): PlayerLatencyPolicy =
      PlayerLatencyPolicy
        .builder
        .ifSome(maximumIndividualPlayerLatencyMilliseconds)(_.maximumIndividualPlayerLatencyMilliseconds(_))
        .ifSome(policyDurationSeconds)(_.policyDurationSeconds(_))
        .build

    def playerSession(
      playerSessionId: Option[String] = None,
      playerId: Option[String] = None,
      gameSessionId: Option[String] = None,
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      terminationTime: Option[Timestamp] = None,
      status: Option[String] = None,
      ipAddress: Option[String] = None,
      dnsName: Option[String] = None,
      port: Option[Int] = None,
      playerData: Option[String] = None
    ): PlayerSession =
      PlayerSession
        .builder
        .ifSome(playerSessionId)(_.playerSessionId(_))
        .ifSome(playerId)(_.playerId(_))
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(terminationTime)(_.terminationTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(dnsName)(_.dnsName(_))
        .ifSome(port)(_.port(_))
        .ifSome(playerData)(_.playerData(_))
        .build

    def priorityConfiguration(
      priorityOrder: Option[List[PriorityType]] = None,
      locationOrder: Option[List[LocationStringModel]] = None
    ): PriorityConfiguration =
      PriorityConfiguration
        .builder
        .ifSome(priorityOrder)(_.priorityOrder(_))
        .ifSome(locationOrder)(_.locationOrder(_))
        .build

    def putScalingPolicyInput(
      name: Option[String] = None,
      fleetId: Option[String] = None,
      scalingAdjustment: Option[Int] = None,
      scalingAdjustmentType: Option[String] = None,
      threshold: Option[Double] = None,
      comparisonOperator: Option[String] = None,
      evaluationPeriods: Option[Int] = None,
      metricName: Option[String] = None,
      policyType: Option[String] = None,
      targetConfiguration: Option[TargetConfiguration] = None
    ): PutScalingPolicyInput =
      PutScalingPolicyInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(scalingAdjustment)(_.scalingAdjustment(_))
        .ifSome(scalingAdjustmentType)(_.scalingAdjustmentType(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(targetConfiguration)(_.targetConfiguration(_))
        .build

    def putScalingPolicyOutput(
      name: Option[String] = None
    ): PutScalingPolicyOutput =
      PutScalingPolicyOutput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def registerGameServerInput(
      gameServerGroupName: Option[String] = None,
      gameServerId: Option[String] = None,
      instanceId: Option[String] = None,
      connectionInfo: Option[String] = None,
      gameServerData: Option[String] = None
    ): RegisterGameServerInput =
      RegisterGameServerInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerId)(_.gameServerId(_))
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(connectionInfo)(_.connectionInfo(_))
        .ifSome(gameServerData)(_.gameServerData(_))
        .build

    def registerGameServerOutput(
      gameServer: Option[GameServer] = None
    ): RegisterGameServerOutput =
      RegisterGameServerOutput
        .builder
        .ifSome(gameServer)(_.gameServer(_))
        .build

    def requestUploadCredentialsInput(
      buildId: Option[String] = None
    ): RequestUploadCredentialsInput =
      RequestUploadCredentialsInput
        .builder
        .ifSome(buildId)(_.buildId(_))
        .build

    def requestUploadCredentialsOutput(
      uploadCredentials: Option[AwsCredentials] = None,
      storageLocation: Option[S3Location] = None
    ): RequestUploadCredentialsOutput =
      RequestUploadCredentialsOutput
        .builder
        .ifSome(uploadCredentials)(_.uploadCredentials(_))
        .ifSome(storageLocation)(_.storageLocation(_))
        .build

    def resolveAliasInput(
      aliasId: Option[String] = None
    ): ResolveAliasInput =
      ResolveAliasInput
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .build

    def resolveAliasOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None
    ): ResolveAliasOutput =
      ResolveAliasOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def resourceCreationLimitPolicy(
      newGameSessionsPerCreator: Option[Int] = None,
      policyPeriodInMinutes: Option[Int] = None
    ): ResourceCreationLimitPolicy =
      ResourceCreationLimitPolicy
        .builder
        .ifSome(newGameSessionsPerCreator)(_.newGameSessionsPerCreator(_))
        .ifSome(policyPeriodInMinutes)(_.policyPeriodInMinutes(_))
        .build

    def resumeGameServerGroupInput(
      gameServerGroupName: Option[String] = None,
      resumeActions: Option[List[GameServerGroupAction]] = None
    ): ResumeGameServerGroupInput =
      ResumeGameServerGroupInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(resumeActions)(_.resumeActions(_))
        .build

    def resumeGameServerGroupOutput(
      gameServerGroup: Option[GameServerGroup] = None
    ): ResumeGameServerGroupOutput =
      ResumeGameServerGroupOutput
        .builder
        .ifSome(gameServerGroup)(_.gameServerGroup(_))
        .build

    def routingStrategy(
      `type`: Option[String] = None,
      fleetId: Option[String] = None,
      message: Option[String] = None
    ): RoutingStrategy =
      RoutingStrategy
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(message)(_.message(_))
        .build

    def runtimeConfiguration(
      serverProcesses: Option[List[ServerProcess]] = None,
      maxConcurrentGameSessionActivations: Option[Int] = None,
      gameSessionActivationTimeoutSeconds: Option[Int] = None
    ): RuntimeConfiguration =
      RuntimeConfiguration
        .builder
        .ifSome(serverProcesses)(_.serverProcesses(_))
        .ifSome(maxConcurrentGameSessionActivations)(_.maxConcurrentGameSessionActivations(_))
        .ifSome(gameSessionActivationTimeoutSeconds)(_.gameSessionActivationTimeoutSeconds(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      key: Option[String] = None,
      roleArn: Option[String] = None,
      objectVersion: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(objectVersion)(_.objectVersion(_))
        .build

    def scalingPolicy(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      scalingAdjustment: Option[Int] = None,
      scalingAdjustmentType: Option[String] = None,
      comparisonOperator: Option[String] = None,
      threshold: Option[Double] = None,
      evaluationPeriods: Option[Int] = None,
      metricName: Option[String] = None,
      policyType: Option[String] = None,
      targetConfiguration: Option[TargetConfiguration] = None,
      updateStatus: Option[String] = None,
      location: Option[String] = None
    ): ScalingPolicy =
      ScalingPolicy
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(scalingAdjustment)(_.scalingAdjustment(_))
        .ifSome(scalingAdjustmentType)(_.scalingAdjustmentType(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(threshold)(_.threshold(_))
        .ifSome(evaluationPeriods)(_.evaluationPeriods(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(policyType)(_.policyType(_))
        .ifSome(targetConfiguration)(_.targetConfiguration(_))
        .ifSome(updateStatus)(_.updateStatus(_))
        .ifSome(location)(_.location(_))
        .build

    def script(
      scriptId: Option[String] = None,
      scriptArn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sizeOnDisk: Option[PositiveLong] = None,
      creationTime: Option[Timestamp] = None,
      storageLocation: Option[S3Location] = None
    ): Script =
      Script
        .builder
        .ifSome(scriptId)(_.scriptId(_))
        .ifSome(scriptArn)(_.scriptArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sizeOnDisk)(_.sizeOnDisk(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(storageLocation)(_.storageLocation(_))
        .build

    def searchGameSessionsInput(
      fleetId: Option[String] = None,
      aliasId: Option[String] = None,
      location: Option[String] = None,
      filterExpression: Option[String] = None,
      sortExpression: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchGameSessionsInput =
      SearchGameSessionsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(location)(_.location(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(sortExpression)(_.sortExpression(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchGameSessionsOutput(
      gameSessions: Option[List[GameSession]] = None,
      nextToken: Option[String] = None
    ): SearchGameSessionsOutput =
      SearchGameSessionsOutput
        .builder
        .ifSome(gameSessions)(_.gameSessions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def serverProcess(
      launchPath: Option[String] = None,
      parameters: Option[String] = None,
      concurrentExecutions: Option[Int] = None
    ): ServerProcess =
      ServerProcess
        .builder
        .ifSome(launchPath)(_.launchPath(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(concurrentExecutions)(_.concurrentExecutions(_))
        .build

    def startFleetActionsInput(
      fleetId: Option[String] = None,
      actions: Option[List[FleetAction]] = None,
      location: Option[String] = None
    ): StartFleetActionsInput =
      StartFleetActionsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(location)(_.location(_))
        .build

    def startFleetActionsOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None
    ): StartFleetActionsOutput =
      StartFleetActionsOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def startGameSessionPlacementInput(
      placementId: Option[String] = None,
      gameSessionQueueName: Option[String] = None,
      gameProperties: Option[List[GameProperty]] = None,
      maximumPlayerSessionCount: Option[Int] = None,
      gameSessionName: Option[String] = None,
      playerLatencies: Option[List[PlayerLatency]] = None,
      desiredPlayerSessions: Option[List[DesiredPlayerSession]] = None,
      gameSessionData: Option[String] = None
    ): StartGameSessionPlacementInput =
      StartGameSessionPlacementInput
        .builder
        .ifSome(placementId)(_.placementId(_))
        .ifSome(gameSessionQueueName)(_.gameSessionQueueName(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(maximumPlayerSessionCount)(_.maximumPlayerSessionCount(_))
        .ifSome(gameSessionName)(_.gameSessionName(_))
        .ifSome(playerLatencies)(_.playerLatencies(_))
        .ifSome(desiredPlayerSessions)(_.desiredPlayerSessions(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .build

    def startGameSessionPlacementOutput(
      gameSessionPlacement: Option[GameSessionPlacement] = None
    ): StartGameSessionPlacementOutput =
      StartGameSessionPlacementOutput
        .builder
        .ifSome(gameSessionPlacement)(_.gameSessionPlacement(_))
        .build

    def startMatchBackfillInput(
      ticketId: Option[String] = None,
      configurationName: Option[String] = None,
      gameSessionArn: Option[String] = None,
      players: Option[List[Player]] = None
    ): StartMatchBackfillInput =
      StartMatchBackfillInput
        .builder
        .ifSome(ticketId)(_.ticketId(_))
        .ifSome(configurationName)(_.configurationName(_))
        .ifSome(gameSessionArn)(_.gameSessionArn(_))
        .ifSome(players)(_.players(_))
        .build

    def startMatchBackfillOutput(
      matchmakingTicket: Option[MatchmakingTicket] = None
    ): StartMatchBackfillOutput =
      StartMatchBackfillOutput
        .builder
        .ifSome(matchmakingTicket)(_.matchmakingTicket(_))
        .build

    def startMatchmakingInput(
      ticketId: Option[String] = None,
      configurationName: Option[String] = None,
      players: Option[List[Player]] = None
    ): StartMatchmakingInput =
      StartMatchmakingInput
        .builder
        .ifSome(ticketId)(_.ticketId(_))
        .ifSome(configurationName)(_.configurationName(_))
        .ifSome(players)(_.players(_))
        .build

    def startMatchmakingOutput(
      matchmakingTicket: Option[MatchmakingTicket] = None
    ): StartMatchmakingOutput =
      StartMatchmakingOutput
        .builder
        .ifSome(matchmakingTicket)(_.matchmakingTicket(_))
        .build

    def stopFleetActionsInput(
      fleetId: Option[String] = None,
      actions: Option[List[FleetAction]] = None,
      location: Option[String] = None
    ): StopFleetActionsInput =
      StopFleetActionsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(location)(_.location(_))
        .build

    def stopFleetActionsOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None
    ): StopFleetActionsOutput =
      StopFleetActionsOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .build

    def stopGameSessionPlacementInput(
      placementId: Option[String] = None
    ): StopGameSessionPlacementInput =
      StopGameSessionPlacementInput
        .builder
        .ifSome(placementId)(_.placementId(_))
        .build

    def stopGameSessionPlacementOutput(
      gameSessionPlacement: Option[GameSessionPlacement] = None
    ): StopGameSessionPlacementOutput =
      StopGameSessionPlacementOutput
        .builder
        .ifSome(gameSessionPlacement)(_.gameSessionPlacement(_))
        .build

    def stopMatchmakingInput(
      ticketId: Option[String] = None
    ): StopMatchmakingInput =
      StopMatchmakingInput
        .builder
        .ifSome(ticketId)(_.ticketId(_))
        .build

    def stopMatchmakingOutput(

    ): StopMatchmakingOutput =
      StopMatchmakingOutput
        .builder

        .build

    def suspendGameServerGroupInput(
      gameServerGroupName: Option[String] = None,
      suspendActions: Option[List[GameServerGroupAction]] = None
    ): SuspendGameServerGroupInput =
      SuspendGameServerGroupInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(suspendActions)(_.suspendActions(_))
        .build

    def suspendGameServerGroupOutput(
      gameServerGroup: Option[GameServerGroup] = None
    ): SuspendGameServerGroupOutput =
      SuspendGameServerGroupOutput
        .builder
        .ifSome(gameServerGroup)(_.gameServerGroup(_))
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

    def taggingFailedException(
      message: Option[String] = None
    ): TaggingFailedException =
      TaggingFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def targetConfiguration(
      targetValue: Option[Double] = None
    ): TargetConfiguration =
      TargetConfiguration
        .builder
        .ifSome(targetValue)(_.targetValue(_))
        .build

    def targetTrackingConfiguration(
      targetValue: Option[NonNegativeDouble] = None
    ): TargetTrackingConfiguration =
      TargetTrackingConfiguration
        .builder
        .ifSome(targetValue)(_.targetValue(_))
        .build

    def terminalRoutingStrategyException(
      message: Option[String] = None
    ): TerminalRoutingStrategyException =
      TerminalRoutingStrategyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsupportedRegionException(
      message: Option[String] = None
    ): UnsupportedRegionException =
      UnsupportedRegionException
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

    def updateAliasInput(
      aliasId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      routingStrategy: Option[RoutingStrategy] = None
    ): UpdateAliasInput =
      UpdateAliasInput
        .builder
        .ifSome(aliasId)(_.aliasId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(routingStrategy)(_.routingStrategy(_))
        .build

    def updateAliasOutput(
      alias: Option[Alias] = None
    ): UpdateAliasOutput =
      UpdateAliasOutput
        .builder
        .ifSome(alias)(_.alias(_))
        .build

    def updateBuildInput(
      buildId: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None
    ): UpdateBuildInput =
      UpdateBuildInput
        .builder
        .ifSome(buildId)(_.buildId(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def updateBuildOutput(
      build: Option[Build] = None
    ): UpdateBuildOutput =
      UpdateBuildOutput
        .builder
        .ifSome(build)(_.build(_))
        .build

    def updateFleetAttributesInput(
      fleetId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      newGameSessionProtectionPolicy: Option[String] = None,
      resourceCreationLimitPolicy: Option[ResourceCreationLimitPolicy] = None,
      metricGroups: Option[List[MetricGroup]] = None
    ): UpdateFleetAttributesInput =
      UpdateFleetAttributesInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(newGameSessionProtectionPolicy)(_.newGameSessionProtectionPolicy(_))
        .ifSome(resourceCreationLimitPolicy)(_.resourceCreationLimitPolicy(_))
        .ifSome(metricGroups)(_.metricGroups(_))
        .build

    def updateFleetAttributesOutput(
      fleetId: Option[String] = None
    ): UpdateFleetAttributesOutput =
      UpdateFleetAttributesOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def updateFleetCapacityInput(
      fleetId: Option[String] = None,
      desiredInstances: Option[Int] = None,
      minSize: Option[Int] = None,
      maxSize: Option[Int] = None,
      location: Option[String] = None
    ): UpdateFleetCapacityInput =
      UpdateFleetCapacityInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(desiredInstances)(_.desiredInstances(_))
        .ifSome(minSize)(_.minSize(_))
        .ifSome(maxSize)(_.maxSize(_))
        .ifSome(location)(_.location(_))
        .build

    def updateFleetCapacityOutput(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      location: Option[String] = None
    ): UpdateFleetCapacityOutput =
      UpdateFleetCapacityOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(location)(_.location(_))
        .build

    def updateFleetPortSettingsInput(
      fleetId: Option[String] = None,
      inboundPermissionAuthorizations: Option[List[IpPermission]] = None,
      inboundPermissionRevocations: Option[List[IpPermission]] = None
    ): UpdateFleetPortSettingsInput =
      UpdateFleetPortSettingsInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(inboundPermissionAuthorizations)(_.inboundPermissionAuthorizations(_))
        .ifSome(inboundPermissionRevocations)(_.inboundPermissionRevocations(_))
        .build

    def updateFleetPortSettingsOutput(
      fleetId: Option[String] = None
    ): UpdateFleetPortSettingsOutput =
      UpdateFleetPortSettingsOutput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .build

    def updateGameServerGroupInput(
      gameServerGroupName: Option[String] = None,
      roleArn: Option[String] = None,
      instanceDefinitions: Option[List[InstanceDefinition]] = None,
      gameServerProtectionPolicy: Option[String] = None,
      balancingStrategy: Option[String] = None
    ): UpdateGameServerGroupInput =
      UpdateGameServerGroupInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(instanceDefinitions)(_.instanceDefinitions(_))
        .ifSome(gameServerProtectionPolicy)(_.gameServerProtectionPolicy(_))
        .ifSome(balancingStrategy)(_.balancingStrategy(_))
        .build

    def updateGameServerGroupOutput(
      gameServerGroup: Option[GameServerGroup] = None
    ): UpdateGameServerGroupOutput =
      UpdateGameServerGroupOutput
        .builder
        .ifSome(gameServerGroup)(_.gameServerGroup(_))
        .build

    def updateGameServerInput(
      gameServerGroupName: Option[String] = None,
      gameServerId: Option[String] = None,
      gameServerData: Option[String] = None,
      utilizationStatus: Option[String] = None,
      healthCheck: Option[String] = None
    ): UpdateGameServerInput =
      UpdateGameServerInput
        .builder
        .ifSome(gameServerGroupName)(_.gameServerGroupName(_))
        .ifSome(gameServerId)(_.gameServerId(_))
        .ifSome(gameServerData)(_.gameServerData(_))
        .ifSome(utilizationStatus)(_.utilizationStatus(_))
        .ifSome(healthCheck)(_.healthCheck(_))
        .build

    def updateGameServerOutput(
      gameServer: Option[GameServer] = None
    ): UpdateGameServerOutput =
      UpdateGameServerOutput
        .builder
        .ifSome(gameServer)(_.gameServer(_))
        .build

    def updateGameSessionInput(
      gameSessionId: Option[String] = None,
      maximumPlayerSessionCount: Option[Int] = None,
      name: Option[String] = None,
      playerSessionCreationPolicy: Option[String] = None,
      protectionPolicy: Option[String] = None
    ): UpdateGameSessionInput =
      UpdateGameSessionInput
        .builder
        .ifSome(gameSessionId)(_.gameSessionId(_))
        .ifSome(maximumPlayerSessionCount)(_.maximumPlayerSessionCount(_))
        .ifSome(name)(_.name(_))
        .ifSome(playerSessionCreationPolicy)(_.playerSessionCreationPolicy(_))
        .ifSome(protectionPolicy)(_.protectionPolicy(_))
        .build

    def updateGameSessionOutput(
      gameSession: Option[GameSession] = None
    ): UpdateGameSessionOutput =
      UpdateGameSessionOutput
        .builder
        .ifSome(gameSession)(_.gameSession(_))
        .build

    def updateGameSessionQueueInput(
      name: Option[String] = None,
      timeoutInSeconds: Option[Int] = None,
      playerLatencyPolicies: Option[List[PlayerLatencyPolicy]] = None,
      destinations: Option[List[GameSessionQueueDestination]] = None,
      filterConfiguration: Option[FilterConfiguration] = None,
      priorityConfiguration: Option[PriorityConfiguration] = None,
      customEventData: Option[String] = None,
      notificationTarget: Option[String] = None
    ): UpdateGameSessionQueueInput =
      UpdateGameSessionQueueInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(playerLatencyPolicies)(_.playerLatencyPolicies(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(filterConfiguration)(_.filterConfiguration(_))
        .ifSome(priorityConfiguration)(_.priorityConfiguration(_))
        .ifSome(customEventData)(_.customEventData(_))
        .ifSome(notificationTarget)(_.notificationTarget(_))
        .build

    def updateGameSessionQueueOutput(
      gameSessionQueue: Option[GameSessionQueue] = None
    ): UpdateGameSessionQueueOutput =
      UpdateGameSessionQueueOutput
        .builder
        .ifSome(gameSessionQueue)(_.gameSessionQueue(_))
        .build

    def updateMatchmakingConfigurationInput(
      name: Option[String] = None,
      description: Option[String] = None,
      gameSessionQueueArns: Option[List[ArnStringModel]] = None,
      requestTimeoutSeconds: Option[Int] = None,
      acceptanceTimeoutSeconds: Option[Int] = None,
      acceptanceRequired: Option[Boolean] = None,
      ruleSetName: Option[String] = None,
      notificationTarget: Option[String] = None,
      additionalPlayerCount: Option[Int] = None,
      customEventData: Option[String] = None,
      gameProperties: Option[List[GameProperty]] = None,
      gameSessionData: Option[String] = None,
      backfillMode: Option[String] = None,
      flexMatchMode: Option[String] = None
    ): UpdateMatchmakingConfigurationInput =
      UpdateMatchmakingConfigurationInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(gameSessionQueueArns)(_.gameSessionQueueArns(_))
        .ifSome(requestTimeoutSeconds)(_.requestTimeoutSeconds(_))
        .ifSome(acceptanceTimeoutSeconds)(_.acceptanceTimeoutSeconds(_))
        .ifSome(acceptanceRequired)(_.acceptanceRequired(_))
        .ifSome(ruleSetName)(_.ruleSetName(_))
        .ifSome(notificationTarget)(_.notificationTarget(_))
        .ifSome(additionalPlayerCount)(_.additionalPlayerCount(_))
        .ifSome(customEventData)(_.customEventData(_))
        .ifSome(gameProperties)(_.gameProperties(_))
        .ifSome(gameSessionData)(_.gameSessionData(_))
        .ifSome(backfillMode)(_.backfillMode(_))
        .ifSome(flexMatchMode)(_.flexMatchMode(_))
        .build

    def updateMatchmakingConfigurationOutput(
      configuration: Option[MatchmakingConfiguration] = None
    ): UpdateMatchmakingConfigurationOutput =
      UpdateMatchmakingConfigurationOutput
        .builder
        .ifSome(configuration)(_.configuration(_))
        .build

    def updateRuntimeConfigurationInput(
      fleetId: Option[String] = None,
      runtimeConfiguration: Option[RuntimeConfiguration] = None
    ): UpdateRuntimeConfigurationInput =
      UpdateRuntimeConfigurationInput
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(runtimeConfiguration)(_.runtimeConfiguration(_))
        .build

    def updateRuntimeConfigurationOutput(
      runtimeConfiguration: Option[RuntimeConfiguration] = None
    ): UpdateRuntimeConfigurationOutput =
      UpdateRuntimeConfigurationOutput
        .builder
        .ifSome(runtimeConfiguration)(_.runtimeConfiguration(_))
        .build

    def updateScriptInput(
      scriptId: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      storageLocation: Option[S3Location] = None,
      zipFile: Option[ZipBlob] = None
    ): UpdateScriptInput =
      UpdateScriptInput
        .builder
        .ifSome(scriptId)(_.scriptId(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(storageLocation)(_.storageLocation(_))
        .ifSome(zipFile)(_.zipFile(_))
        .build

    def updateScriptOutput(
      script: Option[Script] = None
    ): UpdateScriptOutput =
      UpdateScriptOutput
        .builder
        .ifSome(script)(_.script(_))
        .build

    def validateMatchmakingRuleSetInput(
      ruleSetBody: Option[String] = None
    ): ValidateMatchmakingRuleSetInput =
      ValidateMatchmakingRuleSetInput
        .builder
        .ifSome(ruleSetBody)(_.ruleSetBody(_))
        .build

    def validateMatchmakingRuleSetOutput(
      valid: Option[Boolean] = None
    ): ValidateMatchmakingRuleSetOutput =
      ValidateMatchmakingRuleSetOutput
        .builder
        .ifSome(valid)(_.valid(_))
        .build

    def vpcPeeringAuthorization(
      gameLiftAwsAccountId: Option[String] = None,
      peerVpcAwsAccountId: Option[String] = None,
      peerVpcId: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      expirationTime: Option[Timestamp] = None
    ): VpcPeeringAuthorization =
      VpcPeeringAuthorization
        .builder
        .ifSome(gameLiftAwsAccountId)(_.gameLiftAwsAccountId(_))
        .ifSome(peerVpcAwsAccountId)(_.peerVpcAwsAccountId(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .build

    def vpcPeeringConnection(
      fleetId: Option[String] = None,
      fleetArn: Option[String] = None,
      ipV4CidrBlock: Option[String] = None,
      vpcPeeringConnectionId: Option[String] = None,
      status: Option[VpcPeeringConnectionStatus] = None,
      peerVpcId: Option[String] = None,
      gameLiftVpcId: Option[String] = None
    ): VpcPeeringConnection =
      VpcPeeringConnection
        .builder
        .ifSome(fleetId)(_.fleetId(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(ipV4CidrBlock)(_.ipV4CidrBlock(_))
        .ifSome(vpcPeeringConnectionId)(_.vpcPeeringConnectionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(peerVpcId)(_.peerVpcId(_))
        .ifSome(gameLiftVpcId)(_.gameLiftVpcId(_))
        .build

    def vpcPeeringConnectionStatus(
      code: Option[String] = None,
      message: Option[String] = None
    ): VpcPeeringConnectionStatus =
      VpcPeeringConnectionStatus
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
