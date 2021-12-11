package goober.hi

import goober.free.managedblockchain.ManagedBlockchainIO
import software.amazon.awssdk.services.managedblockchain.model._


object managedblockchain {
  import goober.free.{managedblockchain ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def approvalThresholdPolicy(
      thresholdPercentage: Option[Int] = None,
      proposalDurationInHours: Option[Int] = None,
      thresholdComparator: Option[String] = None
    ): ApprovalThresholdPolicy =
      ApprovalThresholdPolicy
        .builder
        .ifSome(thresholdPercentage)(_.thresholdPercentage(_))
        .ifSome(proposalDurationInHours)(_.proposalDurationInHours(_))
        .ifSome(thresholdComparator)(_.thresholdComparator(_))
        .build

    def createMemberInput(
      clientRequestToken: Option[String] = None,
      invitationId: Option[String] = None,
      networkId: Option[String] = None,
      memberConfiguration: Option[MemberConfiguration] = None
    ): CreateMemberInput =
      CreateMemberInput
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberConfiguration)(_.memberConfiguration(_))
        .build

    def createMemberOutput(
      memberId: Option[String] = None
    ): CreateMemberOutput =
      CreateMemberOutput
        .builder
        .ifSome(memberId)(_.memberId(_))
        .build

    def createNetworkInput(
      clientRequestToken: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      framework: Option[String] = None,
      frameworkVersion: Option[String] = None,
      frameworkConfiguration: Option[NetworkFrameworkConfiguration] = None,
      votingPolicy: Option[VotingPolicy] = None,
      memberConfiguration: Option[MemberConfiguration] = None,
      tags: Option[InputTagMap] = None
    ): CreateNetworkInput =
      CreateNetworkInput
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(frameworkVersion)(_.frameworkVersion(_))
        .ifSome(frameworkConfiguration)(_.frameworkConfiguration(_))
        .ifSome(votingPolicy)(_.votingPolicy(_))
        .ifSome(memberConfiguration)(_.memberConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createNetworkOutput(
      networkId: Option[String] = None,
      memberId: Option[String] = None
    ): CreateNetworkOutput =
      CreateNetworkOutput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def createNodeInput(
      clientRequestToken: Option[String] = None,
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      nodeConfiguration: Option[NodeConfiguration] = None,
      tags: Option[InputTagMap] = None
    ): CreateNodeInput =
      CreateNodeInput
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(nodeConfiguration)(_.nodeConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createNodeOutput(
      nodeId: Option[String] = None
    ): CreateNodeOutput =
      CreateNodeOutput
        .builder
        .ifSome(nodeId)(_.nodeId(_))
        .build

    def createProposalInput(
      clientRequestToken: Option[String] = None,
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      actions: Option[ProposalActions] = None,
      description: Option[String] = None,
      tags: Option[InputTagMap] = None
    ): CreateProposalInput =
      CreateProposalInput
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProposalOutput(
      proposalId: Option[String] = None
    ): CreateProposalOutput =
      CreateProposalOutput
        .builder
        .ifSome(proposalId)(_.proposalId(_))
        .build

    def deleteMemberInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None
    ): DeleteMemberInput =
      DeleteMemberInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def deleteMemberOutput(

    ): DeleteMemberOutput =
      DeleteMemberOutput
        .builder

        .build

    def deleteNodeInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      nodeId: Option[String] = None
    ): DeleteNodeInput =
      DeleteNodeInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(nodeId)(_.nodeId(_))
        .build

    def deleteNodeOutput(

    ): DeleteNodeOutput =
      DeleteNodeOutput
        .builder

        .build

    def getMemberInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None
    ): GetMemberInput =
      GetMemberInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def getMemberOutput(
      member: Option[Member] = None
    ): GetMemberOutput =
      GetMemberOutput
        .builder
        .ifSome(member)(_.member(_))
        .build

    def getNetworkInput(
      networkId: Option[String] = None
    ): GetNetworkInput =
      GetNetworkInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .build

    def getNetworkOutput(
      network: Option[Network] = None
    ): GetNetworkOutput =
      GetNetworkOutput
        .builder
        .ifSome(network)(_.network(_))
        .build

    def getNodeInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      nodeId: Option[String] = None
    ): GetNodeInput =
      GetNodeInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(nodeId)(_.nodeId(_))
        .build

    def getNodeOutput(
      node: Option[Node] = None
    ): GetNodeOutput =
      GetNodeOutput
        .builder
        .ifSome(node)(_.node(_))
        .build

    def getProposalInput(
      networkId: Option[String] = None,
      proposalId: Option[String] = None
    ): GetProposalInput =
      GetProposalInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(proposalId)(_.proposalId(_))
        .build

    def getProposalOutput(
      proposal: Option[Proposal] = None
    ): GetProposalOutput =
      GetProposalOutput
        .builder
        .ifSome(proposal)(_.proposal(_))
        .build

    def illegalActionException(
      message: Option[String] = None
    ): IllegalActionException =
      IllegalActionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServiceErrorException(

    ): InternalServiceErrorException =
      InternalServiceErrorException
        .builder

        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invitation(
      invitationId: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      expirationDate: Option[Timestamp] = None,
      status: Option[String] = None,
      networkSummary: Option[NetworkSummary] = None,
      arn: Option[String] = None
    ): Invitation =
      Invitation
        .builder
        .ifSome(invitationId)(_.invitationId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(networkSummary)(_.networkSummary(_))
        .ifSome(arn)(_.arn(_))
        .build

    def inviteAction(
      principal: Option[String] = None
    ): InviteAction =
      InviteAction
        .builder
        .ifSome(principal)(_.principal(_))
        .build

    def listInvitationsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInvitationsInput =
      ListInvitationsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInvitationsOutput(
      invitations: Option[List[Invitation]] = None,
      nextToken: Option[String] = None
    ): ListInvitationsOutput =
      ListInvitationsOutput
        .builder
        .ifSome(invitations)(_.invitations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMembersInput(
      networkId: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      isOwned: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMembersInput =
      ListMembersInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(isOwned)(_.isOwned(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMembersOutput(
      members: Option[List[MemberSummary]] = None,
      nextToken: Option[String] = None
    ): ListMembersOutput =
      ListMembersOutput
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNetworksInput(
      name: Option[String] = None,
      framework: Option[String] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListNetworksInput =
      ListNetworksInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNetworksOutput(
      networks: Option[List[NetworkSummary]] = None,
      nextToken: Option[String] = None
    ): ListNetworksOutput =
      ListNetworksOutput
        .builder
        .ifSome(networks)(_.networks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNodesInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListNodesInput =
      ListNodesInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNodesOutput(
      nodes: Option[List[NodeSummary]] = None,
      nextToken: Option[String] = None
    ): ListNodesOutput =
      ListNodesOutput
        .builder
        .ifSome(nodes)(_.nodes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProposalVotesInput(
      networkId: Option[String] = None,
      proposalId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProposalVotesInput =
      ListProposalVotesInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProposalVotesOutput(
      proposalVotes: Option[List[VoteSummary]] = None,
      nextToken: Option[String] = None
    ): ListProposalVotesOutput =
      ListProposalVotesOutput
        .builder
        .ifSome(proposalVotes)(_.proposalVotes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProposalsInput(
      networkId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProposalsInput =
      ListProposalsInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProposalsOutput(
      proposals: Option[List[ProposalSummary]] = None,
      nextToken: Option[String] = None
    ): ListProposalsOutput =
      ListProposalsOutput
        .builder
        .ifSome(proposals)(_.proposals(_))
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
      tags: Option[OutputTagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def logConfiguration(
      enabled: Option[Boolean] = None
    ): LogConfiguration =
      LogConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def logConfigurations(
      cloudwatch: Option[LogConfiguration] = None
    ): LogConfigurations =
      LogConfigurations
        .builder
        .ifSome(cloudwatch)(_.cloudwatch(_))
        .build

    def member(
      networkId: Option[String] = None,
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      frameworkAttributes: Option[MemberFrameworkAttributes] = None,
      logPublishingConfiguration: Option[MemberLogPublishingConfiguration] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      tags: Option[OutputTagMap] = None,
      arn: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): Member =
      Member
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(frameworkAttributes)(_.frameworkAttributes(_))
        .ifSome(logPublishingConfiguration)(_.logPublishingConfiguration(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def memberConfiguration(
      name: Option[String] = None,
      description: Option[String] = None,
      frameworkConfiguration: Option[MemberFrameworkConfiguration] = None,
      logPublishingConfiguration: Option[MemberLogPublishingConfiguration] = None,
      tags: Option[InputTagMap] = None,
      kmsKeyArn: Option[String] = None
    ): MemberConfiguration =
      MemberConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(frameworkConfiguration)(_.frameworkConfiguration(_))
        .ifSome(logPublishingConfiguration)(_.logPublishingConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def memberFabricAttributes(
      adminUsername: Option[String] = None,
      caEndpoint: Option[String] = None
    ): MemberFabricAttributes =
      MemberFabricAttributes
        .builder
        .ifSome(adminUsername)(_.adminUsername(_))
        .ifSome(caEndpoint)(_.caEndpoint(_))
        .build

    def memberFabricConfiguration(
      adminUsername: Option[String] = None,
      adminPassword: Option[String] = None
    ): MemberFabricConfiguration =
      MemberFabricConfiguration
        .builder
        .ifSome(adminUsername)(_.adminUsername(_))
        .ifSome(adminPassword)(_.adminPassword(_))
        .build

    def memberFabricLogPublishingConfiguration(
      caLogs: Option[LogConfigurations] = None
    ): MemberFabricLogPublishingConfiguration =
      MemberFabricLogPublishingConfiguration
        .builder
        .ifSome(caLogs)(_.caLogs(_))
        .build

    def memberFrameworkAttributes(
      fabric: Option[MemberFabricAttributes] = None
    ): MemberFrameworkAttributes =
      MemberFrameworkAttributes
        .builder
        .ifSome(fabric)(_.fabric(_))
        .build

    def memberFrameworkConfiguration(
      fabric: Option[MemberFabricConfiguration] = None
    ): MemberFrameworkConfiguration =
      MemberFrameworkConfiguration
        .builder
        .ifSome(fabric)(_.fabric(_))
        .build

    def memberLogPublishingConfiguration(
      fabric: Option[MemberFabricLogPublishingConfiguration] = None
    ): MemberLogPublishingConfiguration =
      MemberLogPublishingConfiguration
        .builder
        .ifSome(fabric)(_.fabric(_))
        .build

    def memberSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      isOwned: Option[Boolean] = None,
      arn: Option[String] = None
    ): MemberSummary =
      MemberSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(isOwned)(_.isOwned(_))
        .ifSome(arn)(_.arn(_))
        .build

    def network(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      framework: Option[String] = None,
      frameworkVersion: Option[String] = None,
      frameworkAttributes: Option[NetworkFrameworkAttributes] = None,
      vpcEndpointServiceName: Option[String] = None,
      votingPolicy: Option[VotingPolicy] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      tags: Option[OutputTagMap] = None,
      arn: Option[String] = None
    ): Network =
      Network
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(frameworkVersion)(_.frameworkVersion(_))
        .ifSome(frameworkAttributes)(_.frameworkAttributes(_))
        .ifSome(vpcEndpointServiceName)(_.vpcEndpointServiceName(_))
        .ifSome(votingPolicy)(_.votingPolicy(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(arn)(_.arn(_))
        .build

    def networkEthereumAttributes(
      chainId: Option[String] = None
    ): NetworkEthereumAttributes =
      NetworkEthereumAttributes
        .builder
        .ifSome(chainId)(_.chainId(_))
        .build

    def networkFabricAttributes(
      orderingServiceEndpoint: Option[String] = None,
      edition: Option[String] = None
    ): NetworkFabricAttributes =
      NetworkFabricAttributes
        .builder
        .ifSome(orderingServiceEndpoint)(_.orderingServiceEndpoint(_))
        .ifSome(edition)(_.edition(_))
        .build

    def networkFabricConfiguration(
      edition: Option[String] = None
    ): NetworkFabricConfiguration =
      NetworkFabricConfiguration
        .builder
        .ifSome(edition)(_.edition(_))
        .build

    def networkFrameworkAttributes(
      fabric: Option[NetworkFabricAttributes] = None,
      ethereum: Option[NetworkEthereumAttributes] = None
    ): NetworkFrameworkAttributes =
      NetworkFrameworkAttributes
        .builder
        .ifSome(fabric)(_.fabric(_))
        .ifSome(ethereum)(_.ethereum(_))
        .build

    def networkFrameworkConfiguration(
      fabric: Option[NetworkFabricConfiguration] = None
    ): NetworkFrameworkConfiguration =
      NetworkFrameworkConfiguration
        .builder
        .ifSome(fabric)(_.fabric(_))
        .build

    def networkSummary(
      id: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      framework: Option[String] = None,
      frameworkVersion: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      arn: Option[String] = None
    ): NetworkSummary =
      NetworkSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(frameworkVersion)(_.frameworkVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(arn)(_.arn(_))
        .build

    def node(
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      id: Option[String] = None,
      instanceType: Option[String] = None,
      availabilityZone: Option[String] = None,
      frameworkAttributes: Option[NodeFrameworkAttributes] = None,
      logPublishingConfiguration: Option[NodeLogPublishingConfiguration] = None,
      stateDB: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      tags: Option[OutputTagMap] = None,
      arn: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): Node =
      Node
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(id)(_.id(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(frameworkAttributes)(_.frameworkAttributes(_))
        .ifSome(logPublishingConfiguration)(_.logPublishingConfiguration(_))
        .ifSome(stateDB)(_.stateDB(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def nodeConfiguration(
      instanceType: Option[String] = None,
      availabilityZone: Option[String] = None,
      logPublishingConfiguration: Option[NodeLogPublishingConfiguration] = None,
      stateDB: Option[String] = None
    ): NodeConfiguration =
      NodeConfiguration
        .builder
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(logPublishingConfiguration)(_.logPublishingConfiguration(_))
        .ifSome(stateDB)(_.stateDB(_))
        .build

    def nodeEthereumAttributes(
      httpEndpoint: Option[String] = None,
      webSocketEndpoint: Option[String] = None
    ): NodeEthereumAttributes =
      NodeEthereumAttributes
        .builder
        .ifSome(httpEndpoint)(_.httpEndpoint(_))
        .ifSome(webSocketEndpoint)(_.webSocketEndpoint(_))
        .build

    def nodeFabricAttributes(
      peerEndpoint: Option[String] = None,
      peerEventEndpoint: Option[String] = None
    ): NodeFabricAttributes =
      NodeFabricAttributes
        .builder
        .ifSome(peerEndpoint)(_.peerEndpoint(_))
        .ifSome(peerEventEndpoint)(_.peerEventEndpoint(_))
        .build

    def nodeFabricLogPublishingConfiguration(
      chaincodeLogs: Option[LogConfigurations] = None,
      peerLogs: Option[LogConfigurations] = None
    ): NodeFabricLogPublishingConfiguration =
      NodeFabricLogPublishingConfiguration
        .builder
        .ifSome(chaincodeLogs)(_.chaincodeLogs(_))
        .ifSome(peerLogs)(_.peerLogs(_))
        .build

    def nodeFrameworkAttributes(
      fabric: Option[NodeFabricAttributes] = None,
      ethereum: Option[NodeEthereumAttributes] = None
    ): NodeFrameworkAttributes =
      NodeFrameworkAttributes
        .builder
        .ifSome(fabric)(_.fabric(_))
        .ifSome(ethereum)(_.ethereum(_))
        .build

    def nodeLogPublishingConfiguration(
      fabric: Option[NodeFabricLogPublishingConfiguration] = None
    ): NodeLogPublishingConfiguration =
      NodeLogPublishingConfiguration
        .builder
        .ifSome(fabric)(_.fabric(_))
        .build

    def nodeSummary(
      id: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      availabilityZone: Option[String] = None,
      instanceType: Option[String] = None,
      arn: Option[String] = None
    ): NodeSummary =
      NodeSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(arn)(_.arn(_))
        .build

    def proposal(
      proposalId: Option[String] = None,
      networkId: Option[String] = None,
      description: Option[String] = None,
      actions: Option[ProposalActions] = None,
      proposedByMemberId: Option[String] = None,
      proposedByMemberName: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      expirationDate: Option[Timestamp] = None,
      yesVoteCount: Option[Int] = None,
      noVoteCount: Option[Int] = None,
      outstandingVoteCount: Option[Int] = None,
      tags: Option[OutputTagMap] = None,
      arn: Option[String] = None
    ): Proposal =
      Proposal
        .builder
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(networkId)(_.networkId(_))
        .ifSome(description)(_.description(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(proposedByMemberId)(_.proposedByMemberId(_))
        .ifSome(proposedByMemberName)(_.proposedByMemberName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(yesVoteCount)(_.yesVoteCount(_))
        .ifSome(noVoteCount)(_.noVoteCount(_))
        .ifSome(outstandingVoteCount)(_.outstandingVoteCount(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(arn)(_.arn(_))
        .build

    def proposalActions(
      invitations: Option[List[InviteAction]] = None,
      removals: Option[List[RemoveAction]] = None
    ): ProposalActions =
      ProposalActions
        .builder
        .ifSome(invitations)(_.invitations(_))
        .ifSome(removals)(_.removals(_))
        .build

    def proposalSummary(
      proposalId: Option[String] = None,
      description: Option[String] = None,
      proposedByMemberId: Option[String] = None,
      proposedByMemberName: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      expirationDate: Option[Timestamp] = None,
      arn: Option[String] = None
    ): ProposalSummary =
      ProposalSummary
        .builder
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(description)(_.description(_))
        .ifSome(proposedByMemberId)(_.proposedByMemberId(_))
        .ifSome(proposedByMemberName)(_.proposedByMemberName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(arn)(_.arn(_))
        .build

    def rejectInvitationInput(
      invitationId: Option[String] = None
    ): RejectInvitationInput =
      RejectInvitationInput
        .builder
        .ifSome(invitationId)(_.invitationId(_))
        .build

    def rejectInvitationOutput(

    ): RejectInvitationOutput =
      RejectInvitationOutput
        .builder

        .build

    def removeAction(
      memberId: Option[String] = None
    ): RemoveAction =
      RemoveAction
        .builder
        .ifSome(memberId)(_.memberId(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceededException(
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resourceNotReadyException(
      message: Option[String] = None
    ): ResourceNotReadyException =
      ResourceNotReadyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[InputTagMap] = None
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

    def throttlingException(

    ): ThrottlingException =
      ThrottlingException
        .builder

        .build

    def tooManyTagsException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
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

    def updateMemberInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      logPublishingConfiguration: Option[MemberLogPublishingConfiguration] = None
    ): UpdateMemberInput =
      UpdateMemberInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(logPublishingConfiguration)(_.logPublishingConfiguration(_))
        .build

    def updateMemberOutput(

    ): UpdateMemberOutput =
      UpdateMemberOutput
        .builder

        .build

    def updateNodeInput(
      networkId: Option[String] = None,
      memberId: Option[String] = None,
      nodeId: Option[String] = None,
      logPublishingConfiguration: Option[NodeLogPublishingConfiguration] = None
    ): UpdateNodeInput =
      UpdateNodeInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(memberId)(_.memberId(_))
        .ifSome(nodeId)(_.nodeId(_))
        .ifSome(logPublishingConfiguration)(_.logPublishingConfiguration(_))
        .build

    def updateNodeOutput(

    ): UpdateNodeOutput =
      UpdateNodeOutput
        .builder

        .build

    def voteOnProposalInput(
      networkId: Option[String] = None,
      proposalId: Option[String] = None,
      voterMemberId: Option[String] = None,
      vote: Option[String] = None
    ): VoteOnProposalInput =
      VoteOnProposalInput
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(proposalId)(_.proposalId(_))
        .ifSome(voterMemberId)(_.voterMemberId(_))
        .ifSome(vote)(_.vote(_))
        .build

    def voteOnProposalOutput(

    ): VoteOnProposalOutput =
      VoteOnProposalOutput
        .builder

        .build

    def voteSummary(
      vote: Option[String] = None,
      memberName: Option[String] = None,
      memberId: Option[String] = None
    ): VoteSummary =
      VoteSummary
        .builder
        .ifSome(vote)(_.vote(_))
        .ifSome(memberName)(_.memberName(_))
        .ifSome(memberId)(_.memberId(_))
        .build

    def votingPolicy(
      approvalThresholdPolicy: Option[ApprovalThresholdPolicy] = None
    ): VotingPolicy =
      VotingPolicy
        .builder
        .ifSome(approvalThresholdPolicy)(_.approvalThresholdPolicy(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
