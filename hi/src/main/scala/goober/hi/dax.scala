package goober.hi

import goober.free.dax.DaxIO
import software.amazon.awssdk.services.dax.model._


object dax {
  import goober.free.{dax ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def cluster(
      clusterName: Option[String] = None,
      description: Option[String] = None,
      clusterArn: Option[String] = None,
      totalNodes: Option[Int] = None,
      activeNodes: Option[Int] = None,
      nodeType: Option[String] = None,
      status: Option[String] = None,
      clusterDiscoveryEndpoint: Option[Endpoint] = None,
      nodeIdsToRemove: Option[List[String]] = None,
      nodes: Option[List[Node]] = None,
      preferredMaintenanceWindow: Option[String] = None,
      notificationConfiguration: Option[NotificationConfiguration] = None,
      subnetGroup: Option[String] = None,
      securityGroups: Option[List[SecurityGroupMembership]] = None,
      iamRoleArn: Option[String] = None,
      parameterGroup: Option[ParameterGroupStatus] = None,
      sSEDescription: Option[SSEDescription] = None
    ): Cluster =
      Cluster
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(description)(_.description(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(totalNodes)(_.totalNodes(_))
        .ifSome(activeNodes)(_.activeNodes(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(status)(_.status(_))
        .ifSome(clusterDiscoveryEndpoint)(_.clusterDiscoveryEndpoint(_))
        .ifSome(nodeIdsToRemove)(_.nodeIdsToRemove(_))
        .ifSome(nodes)(_.nodes(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(notificationConfiguration)(_.notificationConfiguration(_))
        .ifSome(subnetGroup)(_.subnetGroup(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(parameterGroup)(_.parameterGroup(_))
        .ifSome(sSEDescription)(_.sSEDescription(_))
        .build

    def clusterAlreadyExistsFault(

    ): ClusterAlreadyExistsFault =
      ClusterAlreadyExistsFault
        .builder

        .build

    def clusterNotFoundFault(

    ): ClusterNotFoundFault =
      ClusterNotFoundFault
        .builder

        .build

    def clusterQuotaForCustomerExceededFault(

    ): ClusterQuotaForCustomerExceededFault =
      ClusterQuotaForCustomerExceededFault
        .builder

        .build

    def createClusterRequest(
      clusterName: Option[String] = None,
      nodeType: Option[String] = None,
      description: Option[String] = None,
      replicationFactor: Option[Int] = None,
      availabilityZones: Option[List[String]] = None,
      subnetGroupName: Option[String] = None,
      securityGroupIds: Option[List[String]] = None,
      preferredMaintenanceWindow: Option[String] = None,
      notificationTopicArn: Option[String] = None,
      iamRoleArn: Option[String] = None,
      parameterGroupName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      sSESpecification: Option[SSESpecification] = None
    ): CreateClusterRequest =
      CreateClusterRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(description)(_.description(_))
        .ifSome(replicationFactor)(_.replicationFactor(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(sSESpecification)(_.sSESpecification(_))
        .build

    def createClusterResponse(
      cluster: Option[Cluster] = None
    ): CreateClusterResponse =
      CreateClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def createParameterGroupRequest(
      parameterGroupName: Option[String] = None,
      description: Option[String] = None
    ): CreateParameterGroupRequest =
      CreateParameterGroupRequest
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(description)(_.description(_))
        .build

    def createParameterGroupResponse(
      parameterGroup: Option[ParameterGroup] = None
    ): CreateParameterGroupResponse =
      CreateParameterGroupResponse
        .builder
        .ifSome(parameterGroup)(_.parameterGroup(_))
        .build

    def createSubnetGroupRequest(
      subnetGroupName: Option[String] = None,
      description: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): CreateSubnetGroupRequest =
      CreateSubnetGroupRequest
        .builder
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def createSubnetGroupResponse(
      subnetGroup: Option[SubnetGroup] = None
    ): CreateSubnetGroupResponse =
      CreateSubnetGroupResponse
        .builder
        .ifSome(subnetGroup)(_.subnetGroup(_))
        .build

    def decreaseReplicationFactorRequest(
      clusterName: Option[String] = None,
      newReplicationFactor: Option[Int] = None,
      availabilityZones: Option[List[String]] = None,
      nodeIdsToRemove: Option[List[String]] = None
    ): DecreaseReplicationFactorRequest =
      DecreaseReplicationFactorRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(newReplicationFactor)(_.newReplicationFactor(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(nodeIdsToRemove)(_.nodeIdsToRemove(_))
        .build

    def decreaseReplicationFactorResponse(
      cluster: Option[Cluster] = None
    ): DecreaseReplicationFactorResponse =
      DecreaseReplicationFactorResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def deleteClusterRequest(
      clusterName: Option[String] = None
    ): DeleteClusterRequest =
      DeleteClusterRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .build

    def deleteClusterResponse(
      cluster: Option[Cluster] = None
    ): DeleteClusterResponse =
      DeleteClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def deleteParameterGroupRequest(
      parameterGroupName: Option[String] = None
    ): DeleteParameterGroupRequest =
      DeleteParameterGroupRequest
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .build

    def deleteParameterGroupResponse(
      deletionMessage: Option[String] = None
    ): DeleteParameterGroupResponse =
      DeleteParameterGroupResponse
        .builder
        .ifSome(deletionMessage)(_.deletionMessage(_))
        .build

    def deleteSubnetGroupRequest(
      subnetGroupName: Option[String] = None
    ): DeleteSubnetGroupRequest =
      DeleteSubnetGroupRequest
        .builder
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .build

    def deleteSubnetGroupResponse(
      deletionMessage: Option[String] = None
    ): DeleteSubnetGroupResponse =
      DeleteSubnetGroupResponse
        .builder
        .ifSome(deletionMessage)(_.deletionMessage(_))
        .build

    def describeClustersRequest(
      clusterNames: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeClustersRequest =
      DescribeClustersRequest
        .builder
        .ifSome(clusterNames)(_.clusterNames(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeClustersResponse(
      nextToken: Option[String] = None,
      clusters: Option[List[Cluster]] = None
    ): DescribeClustersResponse =
      DescribeClustersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(clusters)(_.clusters(_))
        .build

    def describeDefaultParametersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDefaultParametersRequest =
      DescribeDefaultParametersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDefaultParametersResponse(
      nextToken: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): DescribeDefaultParametersResponse =
      DescribeDefaultParametersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def describeEventsRequest(
      sourceName: Option[String] = None,
      sourceType: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeEventsRequest =
      DescribeEventsRequest
        .builder
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventsResponse(
      nextToken: Option[String] = None,
      events: Option[List[Event]] = None
    ): DescribeEventsResponse =
      DescribeEventsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(events)(_.events(_))
        .build

    def describeParameterGroupsRequest(
      parameterGroupNames: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeParameterGroupsRequest =
      DescribeParameterGroupsRequest
        .builder
        .ifSome(parameterGroupNames)(_.parameterGroupNames(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeParameterGroupsResponse(
      nextToken: Option[String] = None,
      parameterGroups: Option[List[ParameterGroup]] = None
    ): DescribeParameterGroupsResponse =
      DescribeParameterGroupsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(parameterGroups)(_.parameterGroups(_))
        .build

    def describeParametersRequest(
      parameterGroupName: Option[String] = None,
      source: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeParametersRequest =
      DescribeParametersRequest
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(source)(_.source(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeParametersResponse(
      nextToken: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): DescribeParametersResponse =
      DescribeParametersResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def describeSubnetGroupsRequest(
      subnetGroupNames: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeSubnetGroupsRequest =
      DescribeSubnetGroupsRequest
        .builder
        .ifSome(subnetGroupNames)(_.subnetGroupNames(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeSubnetGroupsResponse(
      nextToken: Option[String] = None,
      subnetGroups: Option[List[SubnetGroup]] = None
    ): DescribeSubnetGroupsResponse =
      DescribeSubnetGroupsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(subnetGroups)(_.subnetGroups(_))
        .build

    def endpoint(
      address: Option[String] = None,
      port: Option[Int] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(port)(_.port(_))
        .build

    def event(
      sourceName: Option[String] = None,
      sourceType: Option[String] = None,
      message: Option[String] = None,
      date: Option[TStamp] = None
    ): Event =
      Event
        .builder
        .ifSome(sourceName)(_.sourceName(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(message)(_.message(_))
        .ifSome(date)(_.date(_))
        .build

    def increaseReplicationFactorRequest(
      clusterName: Option[String] = None,
      newReplicationFactor: Option[Int] = None,
      availabilityZones: Option[List[String]] = None
    ): IncreaseReplicationFactorRequest =
      IncreaseReplicationFactorRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(newReplicationFactor)(_.newReplicationFactor(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .build

    def increaseReplicationFactorResponse(
      cluster: Option[Cluster] = None
    ): IncreaseReplicationFactorResponse =
      IncreaseReplicationFactorResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def insufficientClusterCapacityFault(

    ): InsufficientClusterCapacityFault =
      InsufficientClusterCapacityFault
        .builder

        .build

    def invalidARNFault(

    ): InvalidARNFault =
      InvalidARNFault
        .builder

        .build

    def invalidClusterStateFault(

    ): InvalidClusterStateFault =
      InvalidClusterStateFault
        .builder

        .build

    def invalidParameterCombinationException(
      message: Option[String] = None
    ): InvalidParameterCombinationException =
      InvalidParameterCombinationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterGroupStateFault(

    ): InvalidParameterGroupStateFault =
      InvalidParameterGroupStateFault
        .builder

        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSubnet(

    ): InvalidSubnet =
      InvalidSubnet
        .builder

        .build

    def invalidVPCNetworkStateFault(

    ): InvalidVPCNetworkStateFault =
      InvalidVPCNetworkStateFault
        .builder

        .build

    def listTagsRequest(
      resourceName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def node(
      nodeId: Option[String] = None,
      endpoint: Option[Endpoint] = None,
      nodeCreateTime: Option[TStamp] = None,
      availabilityZone: Option[String] = None,
      nodeStatus: Option[String] = None,
      parameterGroupStatus: Option[String] = None
    ): Node =
      Node
        .builder
        .ifSome(nodeId)(_.nodeId(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(nodeCreateTime)(_.nodeCreateTime(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(nodeStatus)(_.nodeStatus(_))
        .ifSome(parameterGroupStatus)(_.parameterGroupStatus(_))
        .build

    def nodeNotFoundFault(

    ): NodeNotFoundFault =
      NodeNotFoundFault
        .builder

        .build

    def nodeQuotaForClusterExceededFault(

    ): NodeQuotaForClusterExceededFault =
      NodeQuotaForClusterExceededFault
        .builder

        .build

    def nodeQuotaForCustomerExceededFault(

    ): NodeQuotaForCustomerExceededFault =
      NodeQuotaForCustomerExceededFault
        .builder

        .build

    def nodeTypeSpecificValue(
      nodeType: Option[String] = None,
      value: Option[String] = None
    ): NodeTypeSpecificValue =
      NodeTypeSpecificValue
        .builder
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(value)(_.value(_))
        .build

    def notificationConfiguration(
      topicArn: Option[String] = None,
      topicStatus: Option[String] = None
    ): NotificationConfiguration =
      NotificationConfiguration
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .ifSome(topicStatus)(_.topicStatus(_))
        .build

    def parameter(
      parameterName: Option[String] = None,
      parameterType: Option[String] = None,
      parameterValue: Option[String] = None,
      nodeTypeSpecificValues: Option[List[NodeTypeSpecificValue]] = None,
      description: Option[String] = None,
      source: Option[String] = None,
      dataType: Option[String] = None,
      allowedValues: Option[String] = None,
      isModifiable: Option[String] = None,
      changeType: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterType)(_.parameterType(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .ifSome(nodeTypeSpecificValues)(_.nodeTypeSpecificValues(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(dataType)(_.dataType(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(isModifiable)(_.isModifiable(_))
        .ifSome(changeType)(_.changeType(_))
        .build

    def parameterGroup(
      parameterGroupName: Option[String] = None,
      description: Option[String] = None
    ): ParameterGroup =
      ParameterGroup
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(description)(_.description(_))
        .build

    def parameterGroupAlreadyExistsFault(

    ): ParameterGroupAlreadyExistsFault =
      ParameterGroupAlreadyExistsFault
        .builder

        .build

    def parameterGroupNotFoundFault(

    ): ParameterGroupNotFoundFault =
      ParameterGroupNotFoundFault
        .builder

        .build

    def parameterGroupQuotaExceededFault(

    ): ParameterGroupQuotaExceededFault =
      ParameterGroupQuotaExceededFault
        .builder

        .build

    def parameterGroupStatus(
      parameterGroupName: Option[String] = None,
      parameterApplyStatus: Option[String] = None,
      nodeIdsToReboot: Option[List[String]] = None
    ): ParameterGroupStatus =
      ParameterGroupStatus
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameterApplyStatus)(_.parameterApplyStatus(_))
        .ifSome(nodeIdsToReboot)(_.nodeIdsToReboot(_))
        .build

    def parameterNameValue(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None
    ): ParameterNameValue =
      ParameterNameValue
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .build

    def rebootNodeRequest(
      clusterName: Option[String] = None,
      nodeId: Option[String] = None
    ): RebootNodeRequest =
      RebootNodeRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(nodeId)(_.nodeId(_))
        .build

    def rebootNodeResponse(
      cluster: Option[Cluster] = None
    ): RebootNodeResponse =
      RebootNodeResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def sSEDescription(
      status: Option[String] = None
    ): SSEDescription =
      SSEDescription
        .builder
        .ifSome(status)(_.status(_))
        .build

    def sSESpecification(
      enabled: Option[Boolean] = None
    ): SSESpecification =
      SSESpecification
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def securityGroupMembership(
      securityGroupIdentifier: Option[String] = None,
      status: Option[String] = None
    ): SecurityGroupMembership =
      SecurityGroupMembership
        .builder
        .ifSome(securityGroupIdentifier)(_.securityGroupIdentifier(_))
        .ifSome(status)(_.status(_))
        .build

    def serviceLinkedRoleNotFoundFault(

    ): ServiceLinkedRoleNotFoundFault =
      ServiceLinkedRoleNotFoundFault
        .builder

        .build

    def subnet(
      subnetIdentifier: Option[String] = None,
      subnetAvailabilityZone: Option[String] = None
    ): Subnet =
      Subnet
        .builder
        .ifSome(subnetIdentifier)(_.subnetIdentifier(_))
        .ifSome(subnetAvailabilityZone)(_.subnetAvailabilityZone(_))
        .build

    def subnetGroup(
      subnetGroupName: Option[String] = None,
      description: Option[String] = None,
      vpcId: Option[String] = None,
      subnets: Option[List[Subnet]] = None
    ): SubnetGroup =
      SubnetGroup
        .builder
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnets)(_.subnets(_))
        .build

    def subnetGroupAlreadyExistsFault(

    ): SubnetGroupAlreadyExistsFault =
      SubnetGroupAlreadyExistsFault
        .builder

        .build

    def subnetGroupInUseFault(

    ): SubnetGroupInUseFault =
      SubnetGroupInUseFault
        .builder

        .build

    def subnetGroupNotFoundFault(

    ): SubnetGroupNotFoundFault =
      SubnetGroupNotFoundFault
        .builder

        .build

    def subnetGroupQuotaExceededFault(

    ): SubnetGroupQuotaExceededFault =
      SubnetGroupQuotaExceededFault
        .builder

        .build

    def subnetInUse(

    ): SubnetInUse =
      SubnetInUse
        .builder

        .build

    def subnetQuotaExceededFault(

    ): SubnetQuotaExceededFault =
      SubnetQuotaExceededFault
        .builder

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

    def tagNotFoundFault(

    ): TagNotFoundFault =
      TagNotFoundFault
        .builder

        .build

    def tagQuotaPerResourceExceeded(

    ): TagQuotaPerResourceExceeded =
      TagQuotaPerResourceExceeded
        .builder

        .build

    def tagResourceRequest(
      resourceName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(
      tags: Option[List[Tag]] = None
    ): TagResourceResponse =
      TagResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def untagResourceRequest(
      resourceName: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(
      tags: Option[List[Tag]] = None
    ): UntagResourceResponse =
      UntagResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def updateClusterRequest(
      clusterName: Option[String] = None,
      description: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      notificationTopicArn: Option[String] = None,
      notificationTopicStatus: Option[String] = None,
      parameterGroupName: Option[String] = None,
      securityGroupIds: Option[List[String]] = None
    ): UpdateClusterRequest =
      UpdateClusterRequest
        .builder
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(description)(_.description(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(notificationTopicArn)(_.notificationTopicArn(_))
        .ifSome(notificationTopicStatus)(_.notificationTopicStatus(_))
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def updateClusterResponse(
      cluster: Option[Cluster] = None
    ): UpdateClusterResponse =
      UpdateClusterResponse
        .builder
        .ifSome(cluster)(_.cluster(_))
        .build

    def updateParameterGroupRequest(
      parameterGroupName: Option[String] = None,
      parameterNameValues: Option[List[ParameterNameValue]] = None
    ): UpdateParameterGroupRequest =
      UpdateParameterGroupRequest
        .builder
        .ifSome(parameterGroupName)(_.parameterGroupName(_))
        .ifSome(parameterNameValues)(_.parameterNameValues(_))
        .build

    def updateParameterGroupResponse(
      parameterGroup: Option[ParameterGroup] = None
    ): UpdateParameterGroupResponse =
      UpdateParameterGroupResponse
        .builder
        .ifSome(parameterGroup)(_.parameterGroup(_))
        .build

    def updateSubnetGroupRequest(
      subnetGroupName: Option[String] = None,
      description: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): UpdateSubnetGroupRequest =
      UpdateSubnetGroupRequest
        .builder
        .ifSome(subnetGroupName)(_.subnetGroupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def updateSubnetGroupResponse(
      subnetGroup: Option[SubnetGroup] = None
    ): UpdateSubnetGroupResponse =
      UpdateSubnetGroupResponse
        .builder
        .ifSome(subnetGroup)(_.subnetGroup(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
