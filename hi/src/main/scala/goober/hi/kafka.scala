package goober.hi

import goober.free.kafka.KafkaIO
import software.amazon.awssdk.services.kafka.model._


object kafka {
  import goober.free.{kafka ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def badRequestException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def batchAssociateScramSecretRequest(
      clusterArn: Option[String] = None,
      secretArnList: Option[List[__string]] = None
    ): BatchAssociateScramSecretRequest =
      BatchAssociateScramSecretRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(secretArnList)(_.secretArnList(_))
        .build

    def batchAssociateScramSecretResponse(
      clusterArn: Option[String] = None,
      unprocessedScramSecrets: Option[List[UnprocessedScramSecret]] = None
    ): BatchAssociateScramSecretResponse =
      BatchAssociateScramSecretResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(unprocessedScramSecrets)(_.unprocessedScramSecrets(_))
        .build

    def batchDisassociateScramSecretRequest(
      clusterArn: Option[String] = None,
      secretArnList: Option[List[__string]] = None
    ): BatchDisassociateScramSecretRequest =
      BatchDisassociateScramSecretRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(secretArnList)(_.secretArnList(_))
        .build

    def batchDisassociateScramSecretResponse(
      clusterArn: Option[String] = None,
      unprocessedScramSecrets: Option[List[UnprocessedScramSecret]] = None
    ): BatchDisassociateScramSecretResponse =
      BatchDisassociateScramSecretResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(unprocessedScramSecrets)(_.unprocessedScramSecrets(_))
        .build

    def brokerEBSVolumeInfo(
      kafkaBrokerNodeId: Option[String] = None,
      volumeSizeGB: Option[Int] = None
    ): BrokerEBSVolumeInfo =
      BrokerEBSVolumeInfo
        .builder
        .ifSome(kafkaBrokerNodeId)(_.kafkaBrokerNodeId(_))
        .ifSome(volumeSizeGB)(_.volumeSizeGB(_))
        .build

    def brokerLogs(
      cloudWatchLogs: Option[CloudWatchLogs] = None,
      firehose: Option[Firehose] = None,
      s3: Option[S3] = None
    ): BrokerLogs =
      BrokerLogs
        .builder
        .ifSome(cloudWatchLogs)(_.cloudWatchLogs(_))
        .ifSome(firehose)(_.firehose(_))
        .ifSome(s3)(_.s3(_))
        .build

    def brokerNodeGroupInfo(
      brokerAZDistribution: Option[String] = None,
      clientSubnets: Option[List[__string]] = None,
      instanceType: Option[String] = None,
      securityGroups: Option[List[__string]] = None,
      storageInfo: Option[StorageInfo] = None
    ): BrokerNodeGroupInfo =
      BrokerNodeGroupInfo
        .builder
        .ifSome(brokerAZDistribution)(_.brokerAZDistribution(_))
        .ifSome(clientSubnets)(_.clientSubnets(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(storageInfo)(_.storageInfo(_))
        .build

    def brokerNodeInfo(
      attachedENIId: Option[String] = None,
      brokerId: Option[__double] = None,
      clientSubnet: Option[String] = None,
      clientVpcIpAddress: Option[String] = None,
      currentBrokerSoftwareInfo: Option[BrokerSoftwareInfo] = None,
      endpoints: Option[List[__string]] = None
    ): BrokerNodeInfo =
      BrokerNodeInfo
        .builder
        .ifSome(attachedENIId)(_.attachedENIId(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(clientSubnet)(_.clientSubnet(_))
        .ifSome(clientVpcIpAddress)(_.clientVpcIpAddress(_))
        .ifSome(currentBrokerSoftwareInfo)(_.currentBrokerSoftwareInfo(_))
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def brokerSoftwareInfo(
      configurationArn: Option[String] = None,
      configurationRevision: Option[__long] = None,
      kafkaVersion: Option[String] = None
    ): BrokerSoftwareInfo =
      BrokerSoftwareInfo
        .builder
        .ifSome(configurationArn)(_.configurationArn(_))
        .ifSome(configurationRevision)(_.configurationRevision(_))
        .ifSome(kafkaVersion)(_.kafkaVersion(_))
        .build

    def clientAuthentication(
      sasl: Option[Sasl] = None,
      tls: Option[Tls] = None
    ): ClientAuthentication =
      ClientAuthentication
        .builder
        .ifSome(sasl)(_.sasl(_))
        .ifSome(tls)(_.tls(_))
        .build

    def cloudWatchLogs(
      enabled: Option[Boolean] = None,
      logGroup: Option[String] = None
    ): CloudWatchLogs =
      CloudWatchLogs
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(logGroup)(_.logGroup(_))
        .build

    def clusterInfo(
      activeOperationArn: Option[String] = None,
      brokerNodeGroupInfo: Option[BrokerNodeGroupInfo] = None,
      clientAuthentication: Option[ClientAuthentication] = None,
      clusterArn: Option[String] = None,
      clusterName: Option[String] = None,
      creationTime: Option[__timestampIso8601] = None,
      currentBrokerSoftwareInfo: Option[BrokerSoftwareInfo] = None,
      currentVersion: Option[String] = None,
      encryptionInfo: Option[EncryptionInfo] = None,
      enhancedMonitoring: Option[String] = None,
      openMonitoring: Option[OpenMonitoring] = None,
      loggingInfo: Option[LoggingInfo] = None,
      numberOfBrokerNodes: Option[Int] = None,
      state: Option[String] = None,
      stateInfo: Option[StateInfo] = None,
      tags: Option[__mapOf__string] = None,
      zookeeperConnectString: Option[String] = None,
      zookeeperConnectStringTls: Option[String] = None
    ): ClusterInfo =
      ClusterInfo
        .builder
        .ifSome(activeOperationArn)(_.activeOperationArn(_))
        .ifSome(brokerNodeGroupInfo)(_.brokerNodeGroupInfo(_))
        .ifSome(clientAuthentication)(_.clientAuthentication(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(currentBrokerSoftwareInfo)(_.currentBrokerSoftwareInfo(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(encryptionInfo)(_.encryptionInfo(_))
        .ifSome(enhancedMonitoring)(_.enhancedMonitoring(_))
        .ifSome(openMonitoring)(_.openMonitoring(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .ifSome(numberOfBrokerNodes)(_.numberOfBrokerNodes(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateInfo)(_.stateInfo(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(zookeeperConnectString)(_.zookeeperConnectString(_))
        .ifSome(zookeeperConnectStringTls)(_.zookeeperConnectStringTls(_))
        .build

    def clusterOperationInfo(
      clientRequestId: Option[String] = None,
      clusterArn: Option[String] = None,
      creationTime: Option[__timestampIso8601] = None,
      endTime: Option[__timestampIso8601] = None,
      errorInfo: Option[ErrorInfo] = None,
      operationArn: Option[String] = None,
      operationState: Option[String] = None,
      operationSteps: Option[List[ClusterOperationStep]] = None,
      operationType: Option[String] = None,
      sourceClusterInfo: Option[MutableClusterInfo] = None,
      targetClusterInfo: Option[MutableClusterInfo] = None
    ): ClusterOperationInfo =
      ClusterOperationInfo
        .builder
        .ifSome(clientRequestId)(_.clientRequestId(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(errorInfo)(_.errorInfo(_))
        .ifSome(operationArn)(_.operationArn(_))
        .ifSome(operationState)(_.operationState(_))
        .ifSome(operationSteps)(_.operationSteps(_))
        .ifSome(operationType)(_.operationType(_))
        .ifSome(sourceClusterInfo)(_.sourceClusterInfo(_))
        .ifSome(targetClusterInfo)(_.targetClusterInfo(_))
        .build

    def clusterOperationStep(
      stepInfo: Option[ClusterOperationStepInfo] = None,
      stepName: Option[String] = None
    ): ClusterOperationStep =
      ClusterOperationStep
        .builder
        .ifSome(stepInfo)(_.stepInfo(_))
        .ifSome(stepName)(_.stepName(_))
        .build

    def clusterOperationStepInfo(
      stepStatus: Option[String] = None
    ): ClusterOperationStepInfo =
      ClusterOperationStepInfo
        .builder
        .ifSome(stepStatus)(_.stepStatus(_))
        .build

    def compatibleKafkaVersion(
      sourceVersion: Option[String] = None,
      targetVersions: Option[List[__string]] = None
    ): CompatibleKafkaVersion =
      CompatibleKafkaVersion
        .builder
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(targetVersions)(_.targetVersions(_))
        .build

    def configuration(
      arn: Option[String] = None,
      creationTime: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      kafkaVersions: Option[List[__string]] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      state: Option[String] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(kafkaVersions)(_.kafkaVersions(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .build

    def configurationInfo(
      arn: Option[String] = None,
      revision: Option[__long] = None
    ): ConfigurationInfo =
      ConfigurationInfo
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(revision)(_.revision(_))
        .build

    def configurationRevision(
      creationTime: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      revision: Option[__long] = None
    ): ConfigurationRevision =
      ConfigurationRevision
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(revision)(_.revision(_))
        .build

    def conflictException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def createClusterRequest(
      brokerNodeGroupInfo: Option[BrokerNodeGroupInfo] = None,
      clientAuthentication: Option[ClientAuthentication] = None,
      clusterName: Option[String] = None,
      configurationInfo: Option[ConfigurationInfo] = None,
      encryptionInfo: Option[EncryptionInfo] = None,
      enhancedMonitoring: Option[String] = None,
      openMonitoring: Option[OpenMonitoringInfo] = None,
      kafkaVersion: Option[String] = None,
      loggingInfo: Option[LoggingInfo] = None,
      numberOfBrokerNodes: Option[Int] = None,
      tags: Option[__mapOf__string] = None
    ): CreateClusterRequest =
      CreateClusterRequest
        .builder
        .ifSome(brokerNodeGroupInfo)(_.brokerNodeGroupInfo(_))
        .ifSome(clientAuthentication)(_.clientAuthentication(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(configurationInfo)(_.configurationInfo(_))
        .ifSome(encryptionInfo)(_.encryptionInfo(_))
        .ifSome(enhancedMonitoring)(_.enhancedMonitoring(_))
        .ifSome(openMonitoring)(_.openMonitoring(_))
        .ifSome(kafkaVersion)(_.kafkaVersion(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .ifSome(numberOfBrokerNodes)(_.numberOfBrokerNodes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createClusterResponse(
      clusterArn: Option[String] = None,
      clusterName: Option[String] = None,
      state: Option[String] = None
    ): CreateClusterResponse =
      CreateClusterResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterName)(_.clusterName(_))
        .ifSome(state)(_.state(_))
        .build

    def createConfigurationRequest(
      description: Option[String] = None,
      kafkaVersions: Option[List[__string]] = None,
      name: Option[String] = None,
      serverProperties: Option[__blob] = None
    ): CreateConfigurationRequest =
      CreateConfigurationRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(kafkaVersions)(_.kafkaVersions(_))
        .ifSome(name)(_.name(_))
        .ifSome(serverProperties)(_.serverProperties(_))
        .build

    def createConfigurationResponse(
      arn: Option[String] = None,
      creationTime: Option[__timestampIso8601] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      state: Option[String] = None
    ): CreateConfigurationResponse =
      CreateConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .build

    def deleteClusterRequest(
      clusterArn: Option[String] = None,
      currentVersion: Option[String] = None
    ): DeleteClusterRequest =
      DeleteClusterRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .build

    def deleteClusterResponse(
      clusterArn: Option[String] = None,
      state: Option[String] = None
    ): DeleteClusterResponse =
      DeleteClusterResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(state)(_.state(_))
        .build

    def deleteConfigurationRequest(
      arn: Option[String] = None
    ): DeleteConfigurationRequest =
      DeleteConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteConfigurationResponse(
      arn: Option[String] = None,
      state: Option[String] = None
    ): DeleteConfigurationResponse =
      DeleteConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(state)(_.state(_))
        .build

    def describeClusterOperationRequest(
      clusterOperationArn: Option[String] = None
    ): DescribeClusterOperationRequest =
      DescribeClusterOperationRequest
        .builder
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def describeClusterOperationResponse(
      clusterOperationInfo: Option[ClusterOperationInfo] = None
    ): DescribeClusterOperationResponse =
      DescribeClusterOperationResponse
        .builder
        .ifSome(clusterOperationInfo)(_.clusterOperationInfo(_))
        .build

    def describeClusterRequest(
      clusterArn: Option[String] = None
    ): DescribeClusterRequest =
      DescribeClusterRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def describeClusterResponse(
      clusterInfo: Option[ClusterInfo] = None
    ): DescribeClusterResponse =
      DescribeClusterResponse
        .builder
        .ifSome(clusterInfo)(_.clusterInfo(_))
        .build

    def describeConfigurationRequest(
      arn: Option[String] = None
    ): DescribeConfigurationRequest =
      DescribeConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def describeConfigurationResponse(
      arn: Option[String] = None,
      creationTime: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      kafkaVersions: Option[List[__string]] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      state: Option[String] = None
    ): DescribeConfigurationResponse =
      DescribeConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(kafkaVersions)(_.kafkaVersions(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .build

    def describeConfigurationRevisionRequest(
      arn: Option[String] = None,
      revision: Option[__long] = None
    ): DescribeConfigurationRevisionRequest =
      DescribeConfigurationRevisionRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(revision)(_.revision(_))
        .build

    def describeConfigurationRevisionResponse(
      arn: Option[String] = None,
      creationTime: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      revision: Option[__long] = None,
      serverProperties: Option[__blob] = None
    ): DescribeConfigurationRevisionResponse =
      DescribeConfigurationRevisionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(revision)(_.revision(_))
        .ifSome(serverProperties)(_.serverProperties(_))
        .build

    def eBSStorageInfo(
      volumeSize: Option[Int] = None
    ): EBSStorageInfo =
      EBSStorageInfo
        .builder
        .ifSome(volumeSize)(_.volumeSize(_))
        .build

    def encryptionAtRest(
      dataVolumeKMSKeyId: Option[String] = None
    ): EncryptionAtRest =
      EncryptionAtRest
        .builder
        .ifSome(dataVolumeKMSKeyId)(_.dataVolumeKMSKeyId(_))
        .build

    def encryptionInTransit(
      clientBroker: Option[String] = None,
      inCluster: Option[Boolean] = None
    ): EncryptionInTransit =
      EncryptionInTransit
        .builder
        .ifSome(clientBroker)(_.clientBroker(_))
        .ifSome(inCluster)(_.inCluster(_))
        .build

    def encryptionInfo(
      encryptionAtRest: Option[EncryptionAtRest] = None,
      encryptionInTransit: Option[EncryptionInTransit] = None
    ): EncryptionInfo =
      EncryptionInfo
        .builder
        .ifSome(encryptionAtRest)(_.encryptionAtRest(_))
        .ifSome(encryptionInTransit)(_.encryptionInTransit(_))
        .build

    def error(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): Error =
      Error
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def errorInfo(
      errorCode: Option[String] = None,
      errorString: Option[String] = None
    ): ErrorInfo =
      ErrorInfo
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorString)(_.errorString(_))
        .build

    def firehose(
      deliveryStream: Option[String] = None,
      enabled: Option[Boolean] = None
    ): Firehose =
      Firehose
        .builder
        .ifSome(deliveryStream)(_.deliveryStream(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def forbiddenException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def getBootstrapBrokersRequest(
      clusterArn: Option[String] = None
    ): GetBootstrapBrokersRequest =
      GetBootstrapBrokersRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def getBootstrapBrokersResponse(
      bootstrapBrokerString: Option[String] = None,
      bootstrapBrokerStringTls: Option[String] = None,
      bootstrapBrokerStringSaslScram: Option[String] = None,
      bootstrapBrokerStringSaslIam: Option[String] = None
    ): GetBootstrapBrokersResponse =
      GetBootstrapBrokersResponse
        .builder
        .ifSome(bootstrapBrokerString)(_.bootstrapBrokerString(_))
        .ifSome(bootstrapBrokerStringTls)(_.bootstrapBrokerStringTls(_))
        .ifSome(bootstrapBrokerStringSaslScram)(_.bootstrapBrokerStringSaslScram(_))
        .ifSome(bootstrapBrokerStringSaslIam)(_.bootstrapBrokerStringSaslIam(_))
        .build

    def getCompatibleKafkaVersionsRequest(
      clusterArn: Option[String] = None
    ): GetCompatibleKafkaVersionsRequest =
      GetCompatibleKafkaVersionsRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def getCompatibleKafkaVersionsResponse(
      compatibleKafkaVersions: Option[List[CompatibleKafkaVersion]] = None
    ): GetCompatibleKafkaVersionsResponse =
      GetCompatibleKafkaVersionsResponse
        .builder
        .ifSome(compatibleKafkaVersions)(_.compatibleKafkaVersions(_))
        .build

    def iam(
      enabled: Option[Boolean] = None
    ): Iam =
      Iam
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def internalServerErrorException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def jmxExporter(
      enabledInBroker: Option[Boolean] = None
    ): JmxExporter =
      JmxExporter
        .builder
        .ifSome(enabledInBroker)(_.enabledInBroker(_))
        .build

    def jmxExporterInfo(
      enabledInBroker: Option[Boolean] = None
    ): JmxExporterInfo =
      JmxExporterInfo
        .builder
        .ifSome(enabledInBroker)(_.enabledInBroker(_))
        .build

    def kafkaVersion(
      version: Option[String] = None,
      status: Option[String] = None
    ): KafkaVersion =
      KafkaVersion
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .build

    def listClusterOperationsRequest(
      clusterArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListClusterOperationsRequest =
      ListClusterOperationsRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClusterOperationsResponse(
      clusterOperationInfoList: Option[List[ClusterOperationInfo]] = None,
      nextToken: Option[String] = None
    ): ListClusterOperationsResponse =
      ListClusterOperationsResponse
        .builder
        .ifSome(clusterOperationInfoList)(_.clusterOperationInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClustersRequest(
      clusterNameFilter: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListClustersRequest =
      ListClustersRequest
        .builder
        .ifSome(clusterNameFilter)(_.clusterNameFilter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listClustersResponse(
      clusterInfoList: Option[List[ClusterInfo]] = None,
      nextToken: Option[String] = None
    ): ListClustersResponse =
      ListClustersResponse
        .builder
        .ifSome(clusterInfoList)(_.clusterInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationRevisionsRequest(
      arn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationRevisionsRequest =
      ListConfigurationRevisionsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationRevisionsResponse(
      nextToken: Option[String] = None,
      revisions: Option[List[ConfigurationRevision]] = None
    ): ListConfigurationRevisionsResponse =
      ListConfigurationRevisionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(revisions)(_.revisions(_))
        .build

    def listConfigurationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationsRequest =
      ListConfigurationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationsResponse(
      configurations: Option[List[Configuration]] = None,
      nextToken: Option[String] = None
    ): ListConfigurationsResponse =
      ListConfigurationsResponse
        .builder
        .ifSome(configurations)(_.configurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listKafkaVersionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListKafkaVersionsRequest =
      ListKafkaVersionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listKafkaVersionsResponse(
      kafkaVersions: Option[List[KafkaVersion]] = None,
      nextToken: Option[String] = None
    ): ListKafkaVersionsResponse =
      ListKafkaVersionsResponse
        .builder
        .ifSome(kafkaVersions)(_.kafkaVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNodesRequest(
      clusterArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListNodesRequest =
      ListNodesRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNodesResponse(
      nextToken: Option[String] = None,
      nodeInfoList: Option[List[NodeInfo]] = None
    ): ListNodesResponse =
      ListNodesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(nodeInfoList)(_.nodeInfoList(_))
        .build

    def listScramSecretsRequest(
      clusterArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListScramSecretsRequest =
      ListScramSecretsRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listScramSecretsResponse(
      nextToken: Option[String] = None,
      secretArnList: Option[List[__string]] = None
    ): ListScramSecretsResponse =
      ListScramSecretsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(secretArnList)(_.secretArnList(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[__mapOf__string] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def loggingInfo(
      brokerLogs: Option[BrokerLogs] = None
    ): LoggingInfo =
      LoggingInfo
        .builder
        .ifSome(brokerLogs)(_.brokerLogs(_))
        .build

    def mutableClusterInfo(
      brokerEBSVolumeInfo: Option[List[BrokerEBSVolumeInfo]] = None,
      configurationInfo: Option[ConfigurationInfo] = None,
      numberOfBrokerNodes: Option[Int] = None,
      enhancedMonitoring: Option[String] = None,
      openMonitoring: Option[OpenMonitoring] = None,
      kafkaVersion: Option[String] = None,
      loggingInfo: Option[LoggingInfo] = None,
      instanceType: Option[String] = None
    ): MutableClusterInfo =
      MutableClusterInfo
        .builder
        .ifSome(brokerEBSVolumeInfo)(_.brokerEBSVolumeInfo(_))
        .ifSome(configurationInfo)(_.configurationInfo(_))
        .ifSome(numberOfBrokerNodes)(_.numberOfBrokerNodes(_))
        .ifSome(enhancedMonitoring)(_.enhancedMonitoring(_))
        .ifSome(openMonitoring)(_.openMonitoring(_))
        .ifSome(kafkaVersion)(_.kafkaVersion(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .ifSome(instanceType)(_.instanceType(_))
        .build

    def nodeExporter(
      enabledInBroker: Option[Boolean] = None
    ): NodeExporter =
      NodeExporter
        .builder
        .ifSome(enabledInBroker)(_.enabledInBroker(_))
        .build

    def nodeExporterInfo(
      enabledInBroker: Option[Boolean] = None
    ): NodeExporterInfo =
      NodeExporterInfo
        .builder
        .ifSome(enabledInBroker)(_.enabledInBroker(_))
        .build

    def nodeInfo(
      addedToClusterTime: Option[String] = None,
      brokerNodeInfo: Option[BrokerNodeInfo] = None,
      instanceType: Option[String] = None,
      nodeARN: Option[String] = None,
      nodeType: Option[String] = None,
      zookeeperNodeInfo: Option[ZookeeperNodeInfo] = None
    ): NodeInfo =
      NodeInfo
        .builder
        .ifSome(addedToClusterTime)(_.addedToClusterTime(_))
        .ifSome(brokerNodeInfo)(_.brokerNodeInfo(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(nodeARN)(_.nodeARN(_))
        .ifSome(nodeType)(_.nodeType(_))
        .ifSome(zookeeperNodeInfo)(_.zookeeperNodeInfo(_))
        .build

    def notFoundException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def openMonitoring(
      prometheus: Option[Prometheus] = None
    ): OpenMonitoring =
      OpenMonitoring
        .builder
        .ifSome(prometheus)(_.prometheus(_))
        .build

    def openMonitoringInfo(
      prometheus: Option[PrometheusInfo] = None
    ): OpenMonitoringInfo =
      OpenMonitoringInfo
        .builder
        .ifSome(prometheus)(_.prometheus(_))
        .build

    def prometheus(
      jmxExporter: Option[JmxExporter] = None,
      nodeExporter: Option[NodeExporter] = None
    ): Prometheus =
      Prometheus
        .builder
        .ifSome(jmxExporter)(_.jmxExporter(_))
        .ifSome(nodeExporter)(_.nodeExporter(_))
        .build

    def prometheusInfo(
      jmxExporter: Option[JmxExporterInfo] = None,
      nodeExporter: Option[NodeExporterInfo] = None
    ): PrometheusInfo =
      PrometheusInfo
        .builder
        .ifSome(jmxExporter)(_.jmxExporter(_))
        .ifSome(nodeExporter)(_.nodeExporter(_))
        .build

    def rebootBrokerRequest(
      brokerIds: Option[List[__string]] = None,
      clusterArn: Option[String] = None
    ): RebootBrokerRequest =
      RebootBrokerRequest
        .builder
        .ifSome(brokerIds)(_.brokerIds(_))
        .ifSome(clusterArn)(_.clusterArn(_))
        .build

    def rebootBrokerResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): RebootBrokerResponse =
      RebootBrokerResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def s3(
      bucket: Option[String] = None,
      enabled: Option[Boolean] = None,
      prefix: Option[String] = None
    ): S3 =
      S3
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def sasl(
      scram: Option[Scram] = None,
      iam: Option[Iam] = None
    ): Sasl =
      Sasl
        .builder
        .ifSome(scram)(_.scram(_))
        .ifSome(iam)(_.iam(_))
        .build

    def scram(
      enabled: Option[Boolean] = None
    ): Scram =
      Scram
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def serviceUnavailableException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def stateInfo(
      code: Option[String] = None,
      message: Option[String] = None
    ): StateInfo =
      StateInfo
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def storageInfo(
      ebsStorageInfo: Option[EBSStorageInfo] = None
    ): StorageInfo =
      StorageInfo
        .builder
        .ifSome(ebsStorageInfo)(_.ebsStorageInfo(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tls(
      certificateAuthorityArnList: Option[List[__string]] = None
    ): Tls =
      Tls
        .builder
        .ifSome(certificateAuthorityArnList)(_.certificateAuthorityArnList(_))
        .build

    def tooManyRequestsException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def unauthorizedException(
      invalidParameter: Option[String] = None,
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(invalidParameter)(_.invalidParameter(_))
        .ifSome(message)(_.message(_))
        .build

    def unprocessedScramSecret(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      secretArn: Option[String] = None
    ): UnprocessedScramSecret =
      UnprocessedScramSecret
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(secretArn)(_.secretArn(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateBrokerCountRequest(
      clusterArn: Option[String] = None,
      currentVersion: Option[String] = None,
      targetNumberOfBrokerNodes: Option[Int] = None
    ): UpdateBrokerCountRequest =
      UpdateBrokerCountRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(targetNumberOfBrokerNodes)(_.targetNumberOfBrokerNodes(_))
        .build

    def updateBrokerCountResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): UpdateBrokerCountResponse =
      UpdateBrokerCountResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def updateBrokerStorageRequest(
      clusterArn: Option[String] = None,
      currentVersion: Option[String] = None,
      targetBrokerEBSVolumeInfo: Option[List[BrokerEBSVolumeInfo]] = None
    ): UpdateBrokerStorageRequest =
      UpdateBrokerStorageRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(targetBrokerEBSVolumeInfo)(_.targetBrokerEBSVolumeInfo(_))
        .build

    def updateBrokerStorageResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): UpdateBrokerStorageResponse =
      UpdateBrokerStorageResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def updateBrokerTypeRequest(
      clusterArn: Option[String] = None,
      currentVersion: Option[String] = None,
      targetInstanceType: Option[String] = None
    ): UpdateBrokerTypeRequest =
      UpdateBrokerTypeRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(targetInstanceType)(_.targetInstanceType(_))
        .build

    def updateBrokerTypeResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): UpdateBrokerTypeResponse =
      UpdateBrokerTypeResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def updateClusterConfigurationRequest(
      clusterArn: Option[String] = None,
      configurationInfo: Option[ConfigurationInfo] = None,
      currentVersion: Option[String] = None
    ): UpdateClusterConfigurationRequest =
      UpdateClusterConfigurationRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(configurationInfo)(_.configurationInfo(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .build

    def updateClusterConfigurationResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): UpdateClusterConfigurationResponse =
      UpdateClusterConfigurationResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def updateClusterKafkaVersionRequest(
      clusterArn: Option[String] = None,
      configurationInfo: Option[ConfigurationInfo] = None,
      currentVersion: Option[String] = None,
      targetKafkaVersion: Option[String] = None
    ): UpdateClusterKafkaVersionRequest =
      UpdateClusterKafkaVersionRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(configurationInfo)(_.configurationInfo(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(targetKafkaVersion)(_.targetKafkaVersion(_))
        .build

    def updateClusterKafkaVersionResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): UpdateClusterKafkaVersionResponse =
      UpdateClusterKafkaVersionResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def updateConfigurationRequest(
      arn: Option[String] = None,
      description: Option[String] = None,
      serverProperties: Option[__blob] = None
    ): UpdateConfigurationRequest =
      UpdateConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(serverProperties)(_.serverProperties(_))
        .build

    def updateConfigurationResponse(
      arn: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None
    ): UpdateConfigurationResponse =
      UpdateConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .build

    def updateMonitoringRequest(
      clusterArn: Option[String] = None,
      currentVersion: Option[String] = None,
      enhancedMonitoring: Option[String] = None,
      openMonitoring: Option[OpenMonitoringInfo] = None,
      loggingInfo: Option[LoggingInfo] = None
    ): UpdateMonitoringRequest =
      UpdateMonitoringRequest
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(enhancedMonitoring)(_.enhancedMonitoring(_))
        .ifSome(openMonitoring)(_.openMonitoring(_))
        .ifSome(loggingInfo)(_.loggingInfo(_))
        .build

    def updateMonitoringResponse(
      clusterArn: Option[String] = None,
      clusterOperationArn: Option[String] = None
    ): UpdateMonitoringResponse =
      UpdateMonitoringResponse
        .builder
        .ifSome(clusterArn)(_.clusterArn(_))
        .ifSome(clusterOperationArn)(_.clusterOperationArn(_))
        .build

    def zookeeperNodeInfo(
      attachedENIId: Option[String] = None,
      clientVpcIpAddress: Option[String] = None,
      endpoints: Option[List[__string]] = None,
      zookeeperId: Option[__double] = None,
      zookeeperVersion: Option[String] = None
    ): ZookeeperNodeInfo =
      ZookeeperNodeInfo
        .builder
        .ifSome(attachedENIId)(_.attachedENIId(_))
        .ifSome(clientVpcIpAddress)(_.clientVpcIpAddress(_))
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(zookeeperId)(_.zookeeperId(_))
        .ifSome(zookeeperVersion)(_.zookeeperVersion(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
