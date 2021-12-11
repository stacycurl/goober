package goober.hi

import goober.free.databasemigration.DatabaseMigrationIO
import software.amazon.awssdk.services.databasemigration.model._


object databasemigration {
  import goober.free.{databasemigration ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedFault(
      message: Option[String] = None
    ): AccessDeniedFault =
      AccessDeniedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountQuota(
      accountQuotaName: Option[String] = None,
      used: Option[Long] = None,
      max: Option[Long] = None
    ): AccountQuota =
      AccountQuota
        .builder
        .ifSome(accountQuotaName)(_.accountQuotaName(_))
        .ifSome(used)(_.used(_))
        .ifSome(max)(_.max(_))
        .build

    def addTagsToResourceMessage(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): AddTagsToResourceMessage =
      AddTagsToResourceMessage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def addTagsToResourceResponse(

    ): AddTagsToResourceResponse =
      AddTagsToResourceResponse
        .builder

        .build

    def applyPendingMaintenanceActionMessage(
      replicationInstanceArn: Option[String] = None,
      applyAction: Option[String] = None,
      optInType: Option[String] = None
    ): ApplyPendingMaintenanceActionMessage =
      ApplyPendingMaintenanceActionMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(applyAction)(_.applyAction(_))
        .ifSome(optInType)(_.optInType(_))
        .build

    def applyPendingMaintenanceActionResponse(
      resourcePendingMaintenanceActions: Option[ResourcePendingMaintenanceActions] = None
    ): ApplyPendingMaintenanceActionResponse =
      ApplyPendingMaintenanceActionResponse
        .builder
        .ifSome(resourcePendingMaintenanceActions)(_.resourcePendingMaintenanceActions(_))
        .build

    def availabilityZone(
      name: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .build

    def cancelReplicationTaskAssessmentRunMessage(
      replicationTaskAssessmentRunArn: Option[String] = None
    ): CancelReplicationTaskAssessmentRunMessage =
      CancelReplicationTaskAssessmentRunMessage
        .builder
        .ifSome(replicationTaskAssessmentRunArn)(_.replicationTaskAssessmentRunArn(_))
        .build

    def cancelReplicationTaskAssessmentRunResponse(
      replicationTaskAssessmentRun: Option[ReplicationTaskAssessmentRun] = None
    ): CancelReplicationTaskAssessmentRunResponse =
      CancelReplicationTaskAssessmentRunResponse
        .builder
        .ifSome(replicationTaskAssessmentRun)(_.replicationTaskAssessmentRun(_))
        .build

    def certificate(
      certificateIdentifier: Option[String] = None,
      certificateCreationDate: Option[TStamp] = None,
      certificatePem: Option[String] = None,
      certificateWallet: Option[CertificateWallet] = None,
      certificateArn: Option[String] = None,
      certificateOwner: Option[String] = None,
      validFromDate: Option[TStamp] = None,
      validToDate: Option[TStamp] = None,
      signingAlgorithm: Option[String] = None,
      keyLength: Option[Int] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(certificateIdentifier)(_.certificateIdentifier(_))
        .ifSome(certificateCreationDate)(_.certificateCreationDate(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(certificateWallet)(_.certificateWallet(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateOwner)(_.certificateOwner(_))
        .ifSome(validFromDate)(_.validFromDate(_))
        .ifSome(validToDate)(_.validToDate(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .ifSome(keyLength)(_.keyLength(_))
        .build

    def connection(
      replicationInstanceArn: Option[String] = None,
      endpointArn: Option[String] = None,
      status: Option[String] = None,
      lastFailureMessage: Option[String] = None,
      endpointIdentifier: Option[String] = None,
      replicationInstanceIdentifier: Option[String] = None
    ): Connection =
      Connection
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastFailureMessage)(_.lastFailureMessage(_))
        .ifSome(endpointIdentifier)(_.endpointIdentifier(_))
        .ifSome(replicationInstanceIdentifier)(_.replicationInstanceIdentifier(_))
        .build

    def createEndpointMessage(
      endpointIdentifier: Option[String] = None,
      endpointType: Option[String] = None,
      engineName: Option[String] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      serverName: Option[String] = None,
      port: Option[Int] = None,
      databaseName: Option[String] = None,
      extraConnectionAttributes: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      certificateArn: Option[String] = None,
      sslMode: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      externalTableDefinition: Option[String] = None,
      dynamoDbSettings: Option[DynamoDbSettings] = None,
      s3Settings: Option[S3Settings] = None,
      dmsTransferSettings: Option[DmsTransferSettings] = None,
      mongoDbSettings: Option[MongoDbSettings] = None,
      kinesisSettings: Option[KinesisSettings] = None,
      kafkaSettings: Option[KafkaSettings] = None,
      elasticsearchSettings: Option[ElasticsearchSettings] = None,
      neptuneSettings: Option[NeptuneSettings] = None,
      redshiftSettings: Option[RedshiftSettings] = None,
      postgreSQLSettings: Option[PostgreSQLSettings] = None,
      mySQLSettings: Option[MySQLSettings] = None,
      oracleSettings: Option[OracleSettings] = None,
      sybaseSettings: Option[SybaseSettings] = None,
      microsoftSQLServerSettings: Option[MicrosoftSQLServerSettings] = None,
      iBMDb2Settings: Option[IBMDb2Settings] = None,
      resourceIdentifier: Option[String] = None,
      docDbSettings: Option[DocDbSettings] = None
    ): CreateEndpointMessage =
      CreateEndpointMessage
        .builder
        .ifSome(endpointIdentifier)(_.endpointIdentifier(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(port)(_.port(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(extraConnectionAttributes)(_.extraConnectionAttributes(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(sslMode)(_.sslMode(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(externalTableDefinition)(_.externalTableDefinition(_))
        .ifSome(dynamoDbSettings)(_.dynamoDbSettings(_))
        .ifSome(s3Settings)(_.s3Settings(_))
        .ifSome(dmsTransferSettings)(_.dmsTransferSettings(_))
        .ifSome(mongoDbSettings)(_.mongoDbSettings(_))
        .ifSome(kinesisSettings)(_.kinesisSettings(_))
        .ifSome(kafkaSettings)(_.kafkaSettings(_))
        .ifSome(elasticsearchSettings)(_.elasticsearchSettings(_))
        .ifSome(neptuneSettings)(_.neptuneSettings(_))
        .ifSome(redshiftSettings)(_.redshiftSettings(_))
        .ifSome(postgreSQLSettings)(_.postgreSQLSettings(_))
        .ifSome(mySQLSettings)(_.mySQLSettings(_))
        .ifSome(oracleSettings)(_.oracleSettings(_))
        .ifSome(sybaseSettings)(_.sybaseSettings(_))
        .ifSome(microsoftSQLServerSettings)(_.microsoftSQLServerSettings(_))
        .ifSome(iBMDb2Settings)(_.iBMDb2Settings(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(docDbSettings)(_.docDbSettings(_))
        .build

    def createEndpointResponse(
      endpoint: Option[Endpoint] = None
    ): CreateEndpointResponse =
      CreateEndpointResponse
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def createEventSubscriptionMessage(
      subscriptionName: Option[String] = None,
      snsTopicArn: Option[String] = None,
      sourceType: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      sourceIds: Option[List[String]] = None,
      enabled: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateEventSubscriptionMessage =
      CreateEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(sourceIds)(_.sourceIds(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEventSubscriptionResponse(
      eventSubscription: Option[EventSubscription] = None
    ): CreateEventSubscriptionResponse =
      CreateEventSubscriptionResponse
        .builder
        .ifSome(eventSubscription)(_.eventSubscription(_))
        .build

    def createReplicationInstanceMessage(
      replicationInstanceIdentifier: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      replicationInstanceClass: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      availabilityZone: Option[String] = None,
      replicationSubnetGroupIdentifier: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None,
      publiclyAccessible: Option[Boolean] = None,
      dnsNameServers: Option[String] = None,
      resourceIdentifier: Option[String] = None
    ): CreateReplicationInstanceMessage =
      CreateReplicationInstanceMessage
        .builder
        .ifSome(replicationInstanceIdentifier)(_.replicationInstanceIdentifier(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(replicationInstanceClass)(_.replicationInstanceClass(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(replicationSubnetGroupIdentifier)(_.replicationSubnetGroupIdentifier(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(dnsNameServers)(_.dnsNameServers(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .build

    def createReplicationInstanceResponse(
      replicationInstance: Option[ReplicationInstance] = None
    ): CreateReplicationInstanceResponse =
      CreateReplicationInstanceResponse
        .builder
        .ifSome(replicationInstance)(_.replicationInstance(_))
        .build

    def createReplicationSubnetGroupMessage(
      replicationSubnetGroupIdentifier: Option[String] = None,
      replicationSubnetGroupDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None
    ): CreateReplicationSubnetGroupMessage =
      CreateReplicationSubnetGroupMessage
        .builder
        .ifSome(replicationSubnetGroupIdentifier)(_.replicationSubnetGroupIdentifier(_))
        .ifSome(replicationSubnetGroupDescription)(_.replicationSubnetGroupDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createReplicationSubnetGroupResponse(
      replicationSubnetGroup: Option[ReplicationSubnetGroup] = None
    ): CreateReplicationSubnetGroupResponse =
      CreateReplicationSubnetGroupResponse
        .builder
        .ifSome(replicationSubnetGroup)(_.replicationSubnetGroup(_))
        .build

    def createReplicationTaskMessage(
      replicationTaskIdentifier: Option[String] = None,
      sourceEndpointArn: Option[String] = None,
      targetEndpointArn: Option[String] = None,
      replicationInstanceArn: Option[String] = None,
      migrationType: Option[String] = None,
      tableMappings: Option[String] = None,
      replicationTaskSettings: Option[String] = None,
      cdcStartTime: Option[TStamp] = None,
      cdcStartPosition: Option[String] = None,
      cdcStopPosition: Option[String] = None,
      tags: Option[List[Tag]] = None,
      taskData: Option[String] = None,
      resourceIdentifier: Option[String] = None
    ): CreateReplicationTaskMessage =
      CreateReplicationTaskMessage
        .builder
        .ifSome(replicationTaskIdentifier)(_.replicationTaskIdentifier(_))
        .ifSome(sourceEndpointArn)(_.sourceEndpointArn(_))
        .ifSome(targetEndpointArn)(_.targetEndpointArn(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(migrationType)(_.migrationType(_))
        .ifSome(tableMappings)(_.tableMappings(_))
        .ifSome(replicationTaskSettings)(_.replicationTaskSettings(_))
        .ifSome(cdcStartTime)(_.cdcStartTime(_))
        .ifSome(cdcStartPosition)(_.cdcStartPosition(_))
        .ifSome(cdcStopPosition)(_.cdcStopPosition(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(taskData)(_.taskData(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .build

    def createReplicationTaskResponse(
      replicationTask: Option[ReplicationTask] = None
    ): CreateReplicationTaskResponse =
      CreateReplicationTaskResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def deleteCertificateMessage(
      certificateArn: Option[String] = None
    ): DeleteCertificateMessage =
      DeleteCertificateMessage
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def deleteCertificateResponse(
      certificate: Option[Certificate] = None
    ): DeleteCertificateResponse =
      DeleteCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .build

    def deleteConnectionMessage(
      endpointArn: Option[String] = None,
      replicationInstanceArn: Option[String] = None
    ): DeleteConnectionMessage =
      DeleteConnectionMessage
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .build

    def deleteConnectionResponse(
      connection: Option[Connection] = None
    ): DeleteConnectionResponse =
      DeleteConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def deleteEndpointMessage(
      endpointArn: Option[String] = None
    ): DeleteEndpointMessage =
      DeleteEndpointMessage
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def deleteEndpointResponse(
      endpoint: Option[Endpoint] = None
    ): DeleteEndpointResponse =
      DeleteEndpointResponse
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def deleteEventSubscriptionMessage(
      subscriptionName: Option[String] = None
    ): DeleteEventSubscriptionMessage =
      DeleteEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .build

    def deleteEventSubscriptionResponse(
      eventSubscription: Option[EventSubscription] = None
    ): DeleteEventSubscriptionResponse =
      DeleteEventSubscriptionResponse
        .builder
        .ifSome(eventSubscription)(_.eventSubscription(_))
        .build

    def deleteReplicationInstanceMessage(
      replicationInstanceArn: Option[String] = None
    ): DeleteReplicationInstanceMessage =
      DeleteReplicationInstanceMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .build

    def deleteReplicationInstanceResponse(
      replicationInstance: Option[ReplicationInstance] = None
    ): DeleteReplicationInstanceResponse =
      DeleteReplicationInstanceResponse
        .builder
        .ifSome(replicationInstance)(_.replicationInstance(_))
        .build

    def deleteReplicationSubnetGroupMessage(
      replicationSubnetGroupIdentifier: Option[String] = None
    ): DeleteReplicationSubnetGroupMessage =
      DeleteReplicationSubnetGroupMessage
        .builder
        .ifSome(replicationSubnetGroupIdentifier)(_.replicationSubnetGroupIdentifier(_))
        .build

    def deleteReplicationSubnetGroupResponse(

    ): DeleteReplicationSubnetGroupResponse =
      DeleteReplicationSubnetGroupResponse
        .builder

        .build

    def deleteReplicationTaskAssessmentRunMessage(
      replicationTaskAssessmentRunArn: Option[String] = None
    ): DeleteReplicationTaskAssessmentRunMessage =
      DeleteReplicationTaskAssessmentRunMessage
        .builder
        .ifSome(replicationTaskAssessmentRunArn)(_.replicationTaskAssessmentRunArn(_))
        .build

    def deleteReplicationTaskAssessmentRunResponse(
      replicationTaskAssessmentRun: Option[ReplicationTaskAssessmentRun] = None
    ): DeleteReplicationTaskAssessmentRunResponse =
      DeleteReplicationTaskAssessmentRunResponse
        .builder
        .ifSome(replicationTaskAssessmentRun)(_.replicationTaskAssessmentRun(_))
        .build

    def deleteReplicationTaskMessage(
      replicationTaskArn: Option[String] = None
    ): DeleteReplicationTaskMessage =
      DeleteReplicationTaskMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .build

    def deleteReplicationTaskResponse(
      replicationTask: Option[ReplicationTask] = None
    ): DeleteReplicationTaskResponse =
      DeleteReplicationTaskResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def describeAccountAttributesMessage(

    ): DescribeAccountAttributesMessage =
      DescribeAccountAttributesMessage
        .builder

        .build

    def describeAccountAttributesResponse(
      accountQuotas: Option[List[AccountQuota]] = None,
      uniqueAccountIdentifier: Option[String] = None
    ): DescribeAccountAttributesResponse =
      DescribeAccountAttributesResponse
        .builder
        .ifSome(accountQuotas)(_.accountQuotas(_))
        .ifSome(uniqueAccountIdentifier)(_.uniqueAccountIdentifier(_))
        .build

    def describeApplicableIndividualAssessmentsMessage(
      replicationTaskArn: Option[String] = None,
      replicationInstanceArn: Option[String] = None,
      sourceEngineName: Option[String] = None,
      targetEngineName: Option[String] = None,
      migrationType: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeApplicableIndividualAssessmentsMessage =
      DescribeApplicableIndividualAssessmentsMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(sourceEngineName)(_.sourceEngineName(_))
        .ifSome(targetEngineName)(_.targetEngineName(_))
        .ifSome(migrationType)(_.migrationType(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeApplicableIndividualAssessmentsResponse(
      individualAssessmentNames: Option[List[String]] = None,
      marker: Option[String] = None
    ): DescribeApplicableIndividualAssessmentsResponse =
      DescribeApplicableIndividualAssessmentsResponse
        .builder
        .ifSome(individualAssessmentNames)(_.individualAssessmentNames(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCertificatesMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCertificatesMessage =
      DescribeCertificatesMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCertificatesResponse(
      marker: Option[String] = None,
      certificates: Option[List[Certificate]] = None
    ): DescribeCertificatesResponse =
      DescribeCertificatesResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(certificates)(_.certificates(_))
        .build

    def describeConnectionsMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeConnectionsMessage =
      DescribeConnectionsMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeConnectionsResponse(
      marker: Option[String] = None,
      connections: Option[List[Connection]] = None
    ): DescribeConnectionsResponse =
      DescribeConnectionsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(connections)(_.connections(_))
        .build

    def describeEndpointSettingsMessage(
      engineName: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEndpointSettingsMessage =
      DescribeEndpointSettingsMessage
        .builder
        .ifSome(engineName)(_.engineName(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEndpointSettingsResponse(
      marker: Option[String] = None,
      endpointSettings: Option[List[EndpointSetting]] = None
    ): DescribeEndpointSettingsResponse =
      DescribeEndpointSettingsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(endpointSettings)(_.endpointSettings(_))
        .build

    def describeEndpointTypesMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEndpointTypesMessage =
      DescribeEndpointTypesMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEndpointTypesResponse(
      marker: Option[String] = None,
      supportedEndpointTypes: Option[List[SupportedEndpointType]] = None
    ): DescribeEndpointTypesResponse =
      DescribeEndpointTypesResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(supportedEndpointTypes)(_.supportedEndpointTypes(_))
        .build

    def describeEndpointsMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEndpointsMessage =
      DescribeEndpointsMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEndpointsResponse(
      marker: Option[String] = None,
      endpoints: Option[List[Endpoint]] = None
    ): DescribeEndpointsResponse =
      DescribeEndpointsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def describeEventCategoriesMessage(
      sourceType: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeEventCategoriesMessage =
      DescribeEventCategoriesMessage
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeEventCategoriesResponse(
      eventCategoryGroupList: Option[List[EventCategoryGroup]] = None
    ): DescribeEventCategoriesResponse =
      DescribeEventCategoriesResponse
        .builder
        .ifSome(eventCategoryGroupList)(_.eventCategoryGroupList(_))
        .build

    def describeEventSubscriptionsMessage(
      subscriptionName: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEventSubscriptionsMessage =
      DescribeEventSubscriptionsMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEventSubscriptionsResponse(
      marker: Option[String] = None,
      eventSubscriptionsList: Option[List[EventSubscription]] = None
    ): DescribeEventSubscriptionsResponse =
      DescribeEventSubscriptionsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(eventSubscriptionsList)(_.eventSubscriptionsList(_))
        .build

    def describeEventsMessage(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      startTime: Option[TStamp] = None,
      endTime: Option[TStamp] = None,
      duration: Option[Int] = None,
      eventCategories: Option[List[String]] = None,
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeEventsMessage =
      DescribeEventsMessage
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeEventsResponse(
      marker: Option[String] = None,
      events: Option[List[Event]] = None
    ): DescribeEventsResponse =
      DescribeEventsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(events)(_.events(_))
        .build

    def describeOrderableReplicationInstancesMessage(
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeOrderableReplicationInstancesMessage =
      DescribeOrderableReplicationInstancesMessage
        .builder
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeOrderableReplicationInstancesResponse(
      orderableReplicationInstances: Option[List[OrderableReplicationInstance]] = None,
      marker: Option[String] = None
    ): DescribeOrderableReplicationInstancesResponse =
      DescribeOrderableReplicationInstancesResponse
        .builder
        .ifSome(orderableReplicationInstances)(_.orderableReplicationInstances(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describePendingMaintenanceActionsMessage(
      replicationInstanceArn: Option[String] = None,
      filters: Option[List[Filter]] = None,
      marker: Option[String] = None,
      maxRecords: Option[Int] = None
    ): DescribePendingMaintenanceActionsMessage =
      DescribePendingMaintenanceActionsMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .build

    def describePendingMaintenanceActionsResponse(
      pendingMaintenanceActions: Option[List[ResourcePendingMaintenanceActions]] = None,
      marker: Option[String] = None
    ): DescribePendingMaintenanceActionsResponse =
      DescribePendingMaintenanceActionsResponse
        .builder
        .ifSome(pendingMaintenanceActions)(_.pendingMaintenanceActions(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeRefreshSchemasStatusMessage(
      endpointArn: Option[String] = None
    ): DescribeRefreshSchemasStatusMessage =
      DescribeRefreshSchemasStatusMessage
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def describeRefreshSchemasStatusResponse(
      refreshSchemasStatus: Option[RefreshSchemasStatus] = None
    ): DescribeRefreshSchemasStatusResponse =
      DescribeRefreshSchemasStatusResponse
        .builder
        .ifSome(refreshSchemasStatus)(_.refreshSchemasStatus(_))
        .build

    def describeReplicationInstanceTaskLogsMessage(
      replicationInstanceArn: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationInstanceTaskLogsMessage =
      DescribeReplicationInstanceTaskLogsMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationInstanceTaskLogsResponse(
      replicationInstanceArn: Option[String] = None,
      replicationInstanceTaskLogs: Option[List[ReplicationInstanceTaskLog]] = None,
      marker: Option[String] = None
    ): DescribeReplicationInstanceTaskLogsResponse =
      DescribeReplicationInstanceTaskLogsResponse
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(replicationInstanceTaskLogs)(_.replicationInstanceTaskLogs(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationInstancesMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationInstancesMessage =
      DescribeReplicationInstancesMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationInstancesResponse(
      marker: Option[String] = None,
      replicationInstances: Option[List[ReplicationInstance]] = None
    ): DescribeReplicationInstancesResponse =
      DescribeReplicationInstancesResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(replicationInstances)(_.replicationInstances(_))
        .build

    def describeReplicationSubnetGroupsMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationSubnetGroupsMessage =
      DescribeReplicationSubnetGroupsMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationSubnetGroupsResponse(
      marker: Option[String] = None,
      replicationSubnetGroups: Option[List[ReplicationSubnetGroup]] = None
    ): DescribeReplicationSubnetGroupsResponse =
      DescribeReplicationSubnetGroupsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(replicationSubnetGroups)(_.replicationSubnetGroups(_))
        .build

    def describeReplicationTaskAssessmentResultsMessage(
      replicationTaskArn: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationTaskAssessmentResultsMessage =
      DescribeReplicationTaskAssessmentResultsMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationTaskAssessmentResultsResponse(
      marker: Option[String] = None,
      bucketName: Option[String] = None,
      replicationTaskAssessmentResults: Option[List[ReplicationTaskAssessmentResult]] = None
    ): DescribeReplicationTaskAssessmentResultsResponse =
      DescribeReplicationTaskAssessmentResultsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(replicationTaskAssessmentResults)(_.replicationTaskAssessmentResults(_))
        .build

    def describeReplicationTaskAssessmentRunsMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationTaskAssessmentRunsMessage =
      DescribeReplicationTaskAssessmentRunsMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationTaskAssessmentRunsResponse(
      marker: Option[String] = None,
      replicationTaskAssessmentRuns: Option[List[ReplicationTaskAssessmentRun]] = None
    ): DescribeReplicationTaskAssessmentRunsResponse =
      DescribeReplicationTaskAssessmentRunsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(replicationTaskAssessmentRuns)(_.replicationTaskAssessmentRuns(_))
        .build

    def describeReplicationTaskIndividualAssessmentsMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeReplicationTaskIndividualAssessmentsMessage =
      DescribeReplicationTaskIndividualAssessmentsMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeReplicationTaskIndividualAssessmentsResponse(
      marker: Option[String] = None,
      replicationTaskIndividualAssessments: Option[List[ReplicationTaskIndividualAssessment]] = None
    ): DescribeReplicationTaskIndividualAssessmentsResponse =
      DescribeReplicationTaskIndividualAssessmentsResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(replicationTaskIndividualAssessments)(_.replicationTaskIndividualAssessments(_))
        .build

    def describeReplicationTasksMessage(
      filters: Option[List[Filter]] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      withoutSettings: Option[Boolean] = None
    ): DescribeReplicationTasksMessage =
      DescribeReplicationTasksMessage
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(withoutSettings)(_.withoutSettings(_))
        .build

    def describeReplicationTasksResponse(
      marker: Option[String] = None,
      replicationTasks: Option[List[ReplicationTask]] = None
    ): DescribeReplicationTasksResponse =
      DescribeReplicationTasksResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(replicationTasks)(_.replicationTasks(_))
        .build

    def describeSchemasMessage(
      endpointArn: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeSchemasMessage =
      DescribeSchemasMessage
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeSchemasResponse(
      marker: Option[String] = None,
      schemas: Option[List[String]] = None
    ): DescribeSchemasResponse =
      DescribeSchemasResponse
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(schemas)(_.schemas(_))
        .build

    def describeTableStatisticsMessage(
      replicationTaskArn: Option[String] = None,
      maxRecords: Option[Int] = None,
      marker: Option[String] = None,
      filters: Option[List[Filter]] = None
    ): DescribeTableStatisticsMessage =
      DescribeTableStatisticsMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(filters)(_.filters(_))
        .build

    def describeTableStatisticsResponse(
      replicationTaskArn: Option[String] = None,
      tableStatistics: Option[List[TableStatistics]] = None,
      marker: Option[String] = None
    ): DescribeTableStatisticsResponse =
      DescribeTableStatisticsResponse
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(tableStatistics)(_.tableStatistics(_))
        .ifSome(marker)(_.marker(_))
        .build

    def dmsTransferSettings(
      serviceAccessRoleArn: Option[String] = None,
      bucketName: Option[String] = None
    ): DmsTransferSettings =
      DmsTransferSettings
        .builder
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(bucketName)(_.bucketName(_))
        .build

    def docDbSettings(
      username: Option[String] = None,
      password: Option[String] = None,
      serverName: Option[String] = None,
      port: Option[Int] = None,
      databaseName: Option[String] = None,
      nestingLevel: Option[String] = None,
      extractDocId: Option[Boolean] = None,
      docsToInvestigate: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): DocDbSettings =
      DocDbSettings
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(port)(_.port(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(nestingLevel)(_.nestingLevel(_))
        .ifSome(extractDocId)(_.extractDocId(_))
        .ifSome(docsToInvestigate)(_.docsToInvestigate(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def dynamoDbSettings(
      serviceAccessRoleArn: Option[String] = None
    ): DynamoDbSettings =
      DynamoDbSettings
        .builder
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .build

    def elasticsearchSettings(
      serviceAccessRoleArn: Option[String] = None,
      endpointUri: Option[String] = None,
      fullLoadErrorPercentage: Option[Int] = None,
      errorRetryDuration: Option[Int] = None
    ): ElasticsearchSettings =
      ElasticsearchSettings
        .builder
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(endpointUri)(_.endpointUri(_))
        .ifSome(fullLoadErrorPercentage)(_.fullLoadErrorPercentage(_))
        .ifSome(errorRetryDuration)(_.errorRetryDuration(_))
        .build

    def endpoint(
      endpointIdentifier: Option[String] = None,
      endpointType: Option[String] = None,
      engineName: Option[String] = None,
      engineDisplayName: Option[String] = None,
      username: Option[String] = None,
      serverName: Option[String] = None,
      port: Option[Int] = None,
      databaseName: Option[String] = None,
      extraConnectionAttributes: Option[String] = None,
      status: Option[String] = None,
      kmsKeyId: Option[String] = None,
      endpointArn: Option[String] = None,
      certificateArn: Option[String] = None,
      sslMode: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      externalTableDefinition: Option[String] = None,
      externalId: Option[String] = None,
      dynamoDbSettings: Option[DynamoDbSettings] = None,
      s3Settings: Option[S3Settings] = None,
      dmsTransferSettings: Option[DmsTransferSettings] = None,
      mongoDbSettings: Option[MongoDbSettings] = None,
      kinesisSettings: Option[KinesisSettings] = None,
      kafkaSettings: Option[KafkaSettings] = None,
      elasticsearchSettings: Option[ElasticsearchSettings] = None,
      neptuneSettings: Option[NeptuneSettings] = None,
      redshiftSettings: Option[RedshiftSettings] = None,
      postgreSQLSettings: Option[PostgreSQLSettings] = None,
      mySQLSettings: Option[MySQLSettings] = None,
      oracleSettings: Option[OracleSettings] = None,
      sybaseSettings: Option[SybaseSettings] = None,
      microsoftSQLServerSettings: Option[MicrosoftSQLServerSettings] = None,
      iBMDb2Settings: Option[IBMDb2Settings] = None,
      docDbSettings: Option[DocDbSettings] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(endpointIdentifier)(_.endpointIdentifier(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(engineDisplayName)(_.engineDisplayName(_))
        .ifSome(username)(_.username(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(port)(_.port(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(extraConnectionAttributes)(_.extraConnectionAttributes(_))
        .ifSome(status)(_.status(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(sslMode)(_.sslMode(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(externalTableDefinition)(_.externalTableDefinition(_))
        .ifSome(externalId)(_.externalId(_))
        .ifSome(dynamoDbSettings)(_.dynamoDbSettings(_))
        .ifSome(s3Settings)(_.s3Settings(_))
        .ifSome(dmsTransferSettings)(_.dmsTransferSettings(_))
        .ifSome(mongoDbSettings)(_.mongoDbSettings(_))
        .ifSome(kinesisSettings)(_.kinesisSettings(_))
        .ifSome(kafkaSettings)(_.kafkaSettings(_))
        .ifSome(elasticsearchSettings)(_.elasticsearchSettings(_))
        .ifSome(neptuneSettings)(_.neptuneSettings(_))
        .ifSome(redshiftSettings)(_.redshiftSettings(_))
        .ifSome(postgreSQLSettings)(_.postgreSQLSettings(_))
        .ifSome(mySQLSettings)(_.mySQLSettings(_))
        .ifSome(oracleSettings)(_.oracleSettings(_))
        .ifSome(sybaseSettings)(_.sybaseSettings(_))
        .ifSome(microsoftSQLServerSettings)(_.microsoftSQLServerSettings(_))
        .ifSome(iBMDb2Settings)(_.iBMDb2Settings(_))
        .ifSome(docDbSettings)(_.docDbSettings(_))
        .build

    def endpointSetting(
      name: Option[String] = None,
      `type`: Option[String] = None,
      enumValues: Option[List[String]] = None,
      sensitive: Option[Boolean] = None,
      units: Option[String] = None,
      applicability: Option[String] = None,
      intValueMin: Option[Int] = None,
      intValueMax: Option[Int] = None
    ): EndpointSetting =
      EndpointSetting
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(enumValues)(_.enumValues(_))
        .ifSome(sensitive)(_.sensitive(_))
        .ifSome(units)(_.units(_))
        .ifSome(applicability)(_.applicability(_))
        .ifSome(intValueMin)(_.intValueMin(_))
        .ifSome(intValueMax)(_.intValueMax(_))
        .build

    def event(
      sourceIdentifier: Option[String] = None,
      sourceType: Option[String] = None,
      message: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      date: Option[TStamp] = None
    ): Event =
      Event
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(message)(_.message(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(date)(_.date(_))
        .build

    def eventCategoryGroup(
      sourceType: Option[String] = None,
      eventCategories: Option[List[String]] = None
    ): EventCategoryGroup =
      EventCategoryGroup
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .build

    def eventSubscription(
      customerAwsId: Option[String] = None,
      custSubscriptionId: Option[String] = None,
      snsTopicArn: Option[String] = None,
      status: Option[String] = None,
      subscriptionCreationTime: Option[String] = None,
      sourceType: Option[String] = None,
      sourceIdsList: Option[List[String]] = None,
      eventCategoriesList: Option[List[String]] = None,
      enabled: Option[Boolean] = None
    ): EventSubscription =
      EventSubscription
        .builder
        .ifSome(customerAwsId)(_.customerAwsId(_))
        .ifSome(custSubscriptionId)(_.custSubscriptionId(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(subscriptionCreationTime)(_.subscriptionCreationTime(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceIdsList)(_.sourceIdsList(_))
        .ifSome(eventCategoriesList)(_.eventCategoriesList(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[String]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def iBMDb2Settings(
      databaseName: Option[String] = None,
      password: Option[String] = None,
      port: Option[Int] = None,
      serverName: Option[String] = None,
      setDataCaptureChanges: Option[Boolean] = None,
      currentLsn: Option[String] = None,
      maxKBytesPerRead: Option[Int] = None,
      username: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): IBMDb2Settings =
      IBMDb2Settings
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(password)(_.password(_))
        .ifSome(port)(_.port(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(setDataCaptureChanges)(_.setDataCaptureChanges(_))
        .ifSome(currentLsn)(_.currentLsn(_))
        .ifSome(maxKBytesPerRead)(_.maxKBytesPerRead(_))
        .ifSome(username)(_.username(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def importCertificateMessage(
      certificateIdentifier: Option[String] = None,
      certificatePem: Option[String] = None,
      certificateWallet: Option[CertificateWallet] = None,
      tags: Option[List[Tag]] = None
    ): ImportCertificateMessage =
      ImportCertificateMessage
        .builder
        .ifSome(certificateIdentifier)(_.certificateIdentifier(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(certificateWallet)(_.certificateWallet(_))
        .ifSome(tags)(_.tags(_))
        .build

    def importCertificateResponse(
      certificate: Option[Certificate] = None
    ): ImportCertificateResponse =
      ImportCertificateResponse
        .builder
        .ifSome(certificate)(_.certificate(_))
        .build

    def insufficientResourceCapacityFault(
      message: Option[String] = None
    ): InsufficientResourceCapacityFault =
      InsufficientResourceCapacityFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCertificateFault(
      message: Option[String] = None
    ): InvalidCertificateFault =
      InvalidCertificateFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResourceStateFault(
      message: Option[String] = None
    ): InvalidResourceStateFault =
      InvalidResourceStateFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSubnet(
      message: Option[String] = None
    ): InvalidSubnet =
      InvalidSubnet
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSAccessDeniedFault(
      message: Option[String] = None
    ): KMSAccessDeniedFault =
      KMSAccessDeniedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSDisabledFault(
      message: Option[String] = None
    ): KMSDisabledFault =
      KMSDisabledFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSFault(
      message: Option[String] = None
    ): KMSFault =
      KMSFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSInvalidStateFault(
      message: Option[String] = None
    ): KMSInvalidStateFault =
      KMSInvalidStateFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSKeyNotAccessibleFault(
      message: Option[String] = None
    ): KMSKeyNotAccessibleFault =
      KMSKeyNotAccessibleFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSNotFoundFault(
      message: Option[String] = None
    ): KMSNotFoundFault =
      KMSNotFoundFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSThrottlingFault(
      message: Option[String] = None
    ): KMSThrottlingFault =
      KMSThrottlingFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kafkaSettings(
      broker: Option[String] = None,
      topic: Option[String] = None,
      messageFormat: Option[String] = None,
      includeTransactionDetails: Option[Boolean] = None,
      includePartitionValue: Option[Boolean] = None,
      partitionIncludeSchemaTable: Option[Boolean] = None,
      includeTableAlterOperations: Option[Boolean] = None,
      includeControlDetails: Option[Boolean] = None,
      messageMaxBytes: Option[Int] = None,
      includeNullAndEmpty: Option[Boolean] = None,
      securityProtocol: Option[String] = None,
      sslClientCertificateArn: Option[String] = None,
      sslClientKeyArn: Option[String] = None,
      sslClientKeyPassword: Option[String] = None,
      sslCaCertificateArn: Option[String] = None,
      saslUsername: Option[String] = None,
      saslPassword: Option[String] = None
    ): KafkaSettings =
      KafkaSettings
        .builder
        .ifSome(broker)(_.broker(_))
        .ifSome(topic)(_.topic(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .ifSome(includeTransactionDetails)(_.includeTransactionDetails(_))
        .ifSome(includePartitionValue)(_.includePartitionValue(_))
        .ifSome(partitionIncludeSchemaTable)(_.partitionIncludeSchemaTable(_))
        .ifSome(includeTableAlterOperations)(_.includeTableAlterOperations(_))
        .ifSome(includeControlDetails)(_.includeControlDetails(_))
        .ifSome(messageMaxBytes)(_.messageMaxBytes(_))
        .ifSome(includeNullAndEmpty)(_.includeNullAndEmpty(_))
        .ifSome(securityProtocol)(_.securityProtocol(_))
        .ifSome(sslClientCertificateArn)(_.sslClientCertificateArn(_))
        .ifSome(sslClientKeyArn)(_.sslClientKeyArn(_))
        .ifSome(sslClientKeyPassword)(_.sslClientKeyPassword(_))
        .ifSome(sslCaCertificateArn)(_.sslCaCertificateArn(_))
        .ifSome(saslUsername)(_.saslUsername(_))
        .ifSome(saslPassword)(_.saslPassword(_))
        .build

    def kinesisSettings(
      streamArn: Option[String] = None,
      messageFormat: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      includeTransactionDetails: Option[Boolean] = None,
      includePartitionValue: Option[Boolean] = None,
      partitionIncludeSchemaTable: Option[Boolean] = None,
      includeTableAlterOperations: Option[Boolean] = None,
      includeControlDetails: Option[Boolean] = None,
      includeNullAndEmpty: Option[Boolean] = None
    ): KinesisSettings =
      KinesisSettings
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(includeTransactionDetails)(_.includeTransactionDetails(_))
        .ifSome(includePartitionValue)(_.includePartitionValue(_))
        .ifSome(partitionIncludeSchemaTable)(_.partitionIncludeSchemaTable(_))
        .ifSome(includeTableAlterOperations)(_.includeTableAlterOperations(_))
        .ifSome(includeControlDetails)(_.includeControlDetails(_))
        .ifSome(includeNullAndEmpty)(_.includeNullAndEmpty(_))
        .build

    def listTagsForResourceMessage(
      resourceArn: Option[String] = None
    ): ListTagsForResourceMessage =
      ListTagsForResourceMessage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tagList: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tagList)(_.tagList(_))
        .build

    def microsoftSQLServerSettings(
      port: Option[Int] = None,
      bcpPacketSize: Option[Int] = None,
      databaseName: Option[String] = None,
      controlTablesFileGroup: Option[String] = None,
      password: Option[String] = None,
      querySingleAlwaysOnNode: Option[Boolean] = None,
      readBackupOnly: Option[Boolean] = None,
      safeguardPolicy: Option[String] = None,
      serverName: Option[String] = None,
      username: Option[String] = None,
      useBcpFullLoad: Option[Boolean] = None,
      useThirdPartyBackupDevice: Option[Boolean] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): MicrosoftSQLServerSettings =
      MicrosoftSQLServerSettings
        .builder
        .ifSome(port)(_.port(_))
        .ifSome(bcpPacketSize)(_.bcpPacketSize(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(controlTablesFileGroup)(_.controlTablesFileGroup(_))
        .ifSome(password)(_.password(_))
        .ifSome(querySingleAlwaysOnNode)(_.querySingleAlwaysOnNode(_))
        .ifSome(readBackupOnly)(_.readBackupOnly(_))
        .ifSome(safeguardPolicy)(_.safeguardPolicy(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(username)(_.username(_))
        .ifSome(useBcpFullLoad)(_.useBcpFullLoad(_))
        .ifSome(useThirdPartyBackupDevice)(_.useThirdPartyBackupDevice(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def modifyEndpointMessage(
      endpointArn: Option[String] = None,
      endpointIdentifier: Option[String] = None,
      endpointType: Option[String] = None,
      engineName: Option[String] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      serverName: Option[String] = None,
      port: Option[Int] = None,
      databaseName: Option[String] = None,
      extraConnectionAttributes: Option[String] = None,
      certificateArn: Option[String] = None,
      sslMode: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      externalTableDefinition: Option[String] = None,
      dynamoDbSettings: Option[DynamoDbSettings] = None,
      s3Settings: Option[S3Settings] = None,
      dmsTransferSettings: Option[DmsTransferSettings] = None,
      mongoDbSettings: Option[MongoDbSettings] = None,
      kinesisSettings: Option[KinesisSettings] = None,
      kafkaSettings: Option[KafkaSettings] = None,
      elasticsearchSettings: Option[ElasticsearchSettings] = None,
      neptuneSettings: Option[NeptuneSettings] = None,
      redshiftSettings: Option[RedshiftSettings] = None,
      postgreSQLSettings: Option[PostgreSQLSettings] = None,
      mySQLSettings: Option[MySQLSettings] = None,
      oracleSettings: Option[OracleSettings] = None,
      sybaseSettings: Option[SybaseSettings] = None,
      microsoftSQLServerSettings: Option[MicrosoftSQLServerSettings] = None,
      iBMDb2Settings: Option[IBMDb2Settings] = None,
      docDbSettings: Option[DocDbSettings] = None
    ): ModifyEndpointMessage =
      ModifyEndpointMessage
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(endpointIdentifier)(_.endpointIdentifier(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(engineName)(_.engineName(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(port)(_.port(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(extraConnectionAttributes)(_.extraConnectionAttributes(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(sslMode)(_.sslMode(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(externalTableDefinition)(_.externalTableDefinition(_))
        .ifSome(dynamoDbSettings)(_.dynamoDbSettings(_))
        .ifSome(s3Settings)(_.s3Settings(_))
        .ifSome(dmsTransferSettings)(_.dmsTransferSettings(_))
        .ifSome(mongoDbSettings)(_.mongoDbSettings(_))
        .ifSome(kinesisSettings)(_.kinesisSettings(_))
        .ifSome(kafkaSettings)(_.kafkaSettings(_))
        .ifSome(elasticsearchSettings)(_.elasticsearchSettings(_))
        .ifSome(neptuneSettings)(_.neptuneSettings(_))
        .ifSome(redshiftSettings)(_.redshiftSettings(_))
        .ifSome(postgreSQLSettings)(_.postgreSQLSettings(_))
        .ifSome(mySQLSettings)(_.mySQLSettings(_))
        .ifSome(oracleSettings)(_.oracleSettings(_))
        .ifSome(sybaseSettings)(_.sybaseSettings(_))
        .ifSome(microsoftSQLServerSettings)(_.microsoftSQLServerSettings(_))
        .ifSome(iBMDb2Settings)(_.iBMDb2Settings(_))
        .ifSome(docDbSettings)(_.docDbSettings(_))
        .build

    def modifyEndpointResponse(
      endpoint: Option[Endpoint] = None
    ): ModifyEndpointResponse =
      ModifyEndpointResponse
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def modifyEventSubscriptionMessage(
      subscriptionName: Option[String] = None,
      snsTopicArn: Option[String] = None,
      sourceType: Option[String] = None,
      eventCategories: Option[List[String]] = None,
      enabled: Option[Boolean] = None
    ): ModifyEventSubscriptionMessage =
      ModifyEventSubscriptionMessage
        .builder
        .ifSome(subscriptionName)(_.subscriptionName(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(eventCategories)(_.eventCategories(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def modifyEventSubscriptionResponse(
      eventSubscription: Option[EventSubscription] = None
    ): ModifyEventSubscriptionResponse =
      ModifyEventSubscriptionResponse
        .builder
        .ifSome(eventSubscription)(_.eventSubscription(_))
        .build

    def modifyReplicationInstanceMessage(
      replicationInstanceArn: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      applyImmediately: Option[Boolean] = None,
      replicationInstanceClass: Option[String] = None,
      vpcSecurityGroupIds: Option[List[String]] = None,
      preferredMaintenanceWindow: Option[String] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      allowMajorVersionUpgrade: Option[Boolean] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      replicationInstanceIdentifier: Option[String] = None
    ): ModifyReplicationInstanceMessage =
      ModifyReplicationInstanceMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(applyImmediately)(_.applyImmediately(_))
        .ifSome(replicationInstanceClass)(_.replicationInstanceClass(_))
        .ifSome(vpcSecurityGroupIds)(_.vpcSecurityGroupIds(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(allowMajorVersionUpgrade)(_.allowMajorVersionUpgrade(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(replicationInstanceIdentifier)(_.replicationInstanceIdentifier(_))
        .build

    def modifyReplicationInstanceResponse(
      replicationInstance: Option[ReplicationInstance] = None
    ): ModifyReplicationInstanceResponse =
      ModifyReplicationInstanceResponse
        .builder
        .ifSome(replicationInstance)(_.replicationInstance(_))
        .build

    def modifyReplicationSubnetGroupMessage(
      replicationSubnetGroupIdentifier: Option[String] = None,
      replicationSubnetGroupDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None
    ): ModifyReplicationSubnetGroupMessage =
      ModifyReplicationSubnetGroupMessage
        .builder
        .ifSome(replicationSubnetGroupIdentifier)(_.replicationSubnetGroupIdentifier(_))
        .ifSome(replicationSubnetGroupDescription)(_.replicationSubnetGroupDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def modifyReplicationSubnetGroupResponse(
      replicationSubnetGroup: Option[ReplicationSubnetGroup] = None
    ): ModifyReplicationSubnetGroupResponse =
      ModifyReplicationSubnetGroupResponse
        .builder
        .ifSome(replicationSubnetGroup)(_.replicationSubnetGroup(_))
        .build

    def modifyReplicationTaskMessage(
      replicationTaskArn: Option[String] = None,
      replicationTaskIdentifier: Option[String] = None,
      migrationType: Option[String] = None,
      tableMappings: Option[String] = None,
      replicationTaskSettings: Option[String] = None,
      cdcStartTime: Option[TStamp] = None,
      cdcStartPosition: Option[String] = None,
      cdcStopPosition: Option[String] = None,
      taskData: Option[String] = None
    ): ModifyReplicationTaskMessage =
      ModifyReplicationTaskMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(replicationTaskIdentifier)(_.replicationTaskIdentifier(_))
        .ifSome(migrationType)(_.migrationType(_))
        .ifSome(tableMappings)(_.tableMappings(_))
        .ifSome(replicationTaskSettings)(_.replicationTaskSettings(_))
        .ifSome(cdcStartTime)(_.cdcStartTime(_))
        .ifSome(cdcStartPosition)(_.cdcStartPosition(_))
        .ifSome(cdcStopPosition)(_.cdcStopPosition(_))
        .ifSome(taskData)(_.taskData(_))
        .build

    def modifyReplicationTaskResponse(
      replicationTask: Option[ReplicationTask] = None
    ): ModifyReplicationTaskResponse =
      ModifyReplicationTaskResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def mongoDbSettings(
      username: Option[String] = None,
      password: Option[String] = None,
      serverName: Option[String] = None,
      port: Option[Int] = None,
      databaseName: Option[String] = None,
      authType: Option[String] = None,
      authMechanism: Option[String] = None,
      nestingLevel: Option[String] = None,
      extractDocId: Option[String] = None,
      docsToInvestigate: Option[String] = None,
      authSource: Option[String] = None,
      kmsKeyId: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): MongoDbSettings =
      MongoDbSettings
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(port)(_.port(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(authType)(_.authType(_))
        .ifSome(authMechanism)(_.authMechanism(_))
        .ifSome(nestingLevel)(_.nestingLevel(_))
        .ifSome(extractDocId)(_.extractDocId(_))
        .ifSome(docsToInvestigate)(_.docsToInvestigate(_))
        .ifSome(authSource)(_.authSource(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def moveReplicationTaskMessage(
      replicationTaskArn: Option[String] = None,
      targetReplicationInstanceArn: Option[String] = None
    ): MoveReplicationTaskMessage =
      MoveReplicationTaskMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(targetReplicationInstanceArn)(_.targetReplicationInstanceArn(_))
        .build

    def moveReplicationTaskResponse(
      replicationTask: Option[ReplicationTask] = None
    ): MoveReplicationTaskResponse =
      MoveReplicationTaskResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def mySQLSettings(
      afterConnectScript: Option[String] = None,
      cleanSourceMetadataOnMismatch: Option[Boolean] = None,
      databaseName: Option[String] = None,
      eventsPollInterval: Option[Int] = None,
      targetDbType: Option[String] = None,
      maxFileSize: Option[Int] = None,
      parallelLoadThreads: Option[Int] = None,
      password: Option[String] = None,
      port: Option[Int] = None,
      serverName: Option[String] = None,
      serverTimezone: Option[String] = None,
      username: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): MySQLSettings =
      MySQLSettings
        .builder
        .ifSome(afterConnectScript)(_.afterConnectScript(_))
        .ifSome(cleanSourceMetadataOnMismatch)(_.cleanSourceMetadataOnMismatch(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(eventsPollInterval)(_.eventsPollInterval(_))
        .ifSome(targetDbType)(_.targetDbType(_))
        .ifSome(maxFileSize)(_.maxFileSize(_))
        .ifSome(parallelLoadThreads)(_.parallelLoadThreads(_))
        .ifSome(password)(_.password(_))
        .ifSome(port)(_.port(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(serverTimezone)(_.serverTimezone(_))
        .ifSome(username)(_.username(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def neptuneSettings(
      serviceAccessRoleArn: Option[String] = None,
      s3BucketName: Option[String] = None,
      s3BucketFolder: Option[String] = None,
      errorRetryDuration: Option[Int] = None,
      maxFileSize: Option[Int] = None,
      maxRetryCount: Option[Int] = None,
      iamAuthEnabled: Option[Boolean] = None
    ): NeptuneSettings =
      NeptuneSettings
        .builder
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3BucketFolder)(_.s3BucketFolder(_))
        .ifSome(errorRetryDuration)(_.errorRetryDuration(_))
        .ifSome(maxFileSize)(_.maxFileSize(_))
        .ifSome(maxRetryCount)(_.maxRetryCount(_))
        .ifSome(iamAuthEnabled)(_.iamAuthEnabled(_))
        .build

    def oracleSettings(
      addSupplementalLogging: Option[Boolean] = None,
      archivedLogDestId: Option[Int] = None,
      additionalArchivedLogDestId: Option[Int] = None,
      allowSelectNestedTables: Option[Boolean] = None,
      parallelAsmReadThreads: Option[Int] = None,
      readAheadBlocks: Option[Int] = None,
      accessAlternateDirectly: Option[Boolean] = None,
      useAlternateFolderForOnline: Option[Boolean] = None,
      oraclePathPrefix: Option[String] = None,
      usePathPrefix: Option[String] = None,
      replacePathPrefix: Option[Boolean] = None,
      enableHomogenousTablespace: Option[Boolean] = None,
      directPathNoLog: Option[Boolean] = None,
      archivedLogsOnly: Option[Boolean] = None,
      asmPassword: Option[String] = None,
      asmServer: Option[String] = None,
      asmUser: Option[String] = None,
      charLengthSemantics: Option[String] = None,
      databaseName: Option[String] = None,
      directPathParallelLoad: Option[Boolean] = None,
      failTasksOnLobTruncation: Option[Boolean] = None,
      numberDatatypeScale: Option[Int] = None,
      password: Option[String] = None,
      port: Option[Int] = None,
      readTableSpaceName: Option[Boolean] = None,
      retryInterval: Option[Int] = None,
      securityDbEncryption: Option[String] = None,
      securityDbEncryptionName: Option[String] = None,
      serverName: Option[String] = None,
      spatialDataOptionToGeoJsonFunctionName: Option[String] = None,
      username: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None,
      secretsManagerOracleAsmAccessRoleArn: Option[String] = None,
      secretsManagerOracleAsmSecretId: Option[String] = None
    ): OracleSettings =
      OracleSettings
        .builder
        .ifSome(addSupplementalLogging)(_.addSupplementalLogging(_))
        .ifSome(archivedLogDestId)(_.archivedLogDestId(_))
        .ifSome(additionalArchivedLogDestId)(_.additionalArchivedLogDestId(_))
        .ifSome(allowSelectNestedTables)(_.allowSelectNestedTables(_))
        .ifSome(parallelAsmReadThreads)(_.parallelAsmReadThreads(_))
        .ifSome(readAheadBlocks)(_.readAheadBlocks(_))
        .ifSome(accessAlternateDirectly)(_.accessAlternateDirectly(_))
        .ifSome(useAlternateFolderForOnline)(_.useAlternateFolderForOnline(_))
        .ifSome(oraclePathPrefix)(_.oraclePathPrefix(_))
        .ifSome(usePathPrefix)(_.usePathPrefix(_))
        .ifSome(replacePathPrefix)(_.replacePathPrefix(_))
        .ifSome(enableHomogenousTablespace)(_.enableHomogenousTablespace(_))
        .ifSome(directPathNoLog)(_.directPathNoLog(_))
        .ifSome(archivedLogsOnly)(_.archivedLogsOnly(_))
        .ifSome(asmPassword)(_.asmPassword(_))
        .ifSome(asmServer)(_.asmServer(_))
        .ifSome(asmUser)(_.asmUser(_))
        .ifSome(charLengthSemantics)(_.charLengthSemantics(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(directPathParallelLoad)(_.directPathParallelLoad(_))
        .ifSome(failTasksOnLobTruncation)(_.failTasksOnLobTruncation(_))
        .ifSome(numberDatatypeScale)(_.numberDatatypeScale(_))
        .ifSome(password)(_.password(_))
        .ifSome(port)(_.port(_))
        .ifSome(readTableSpaceName)(_.readTableSpaceName(_))
        .ifSome(retryInterval)(_.retryInterval(_))
        .ifSome(securityDbEncryption)(_.securityDbEncryption(_))
        .ifSome(securityDbEncryptionName)(_.securityDbEncryptionName(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(spatialDataOptionToGeoJsonFunctionName)(_.spatialDataOptionToGeoJsonFunctionName(_))
        .ifSome(username)(_.username(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .ifSome(secretsManagerOracleAsmAccessRoleArn)(_.secretsManagerOracleAsmAccessRoleArn(_))
        .ifSome(secretsManagerOracleAsmSecretId)(_.secretsManagerOracleAsmSecretId(_))
        .build

    def orderableReplicationInstance(
      engineVersion: Option[String] = None,
      replicationInstanceClass: Option[String] = None,
      storageType: Option[String] = None,
      minAllocatedStorage: Option[Int] = None,
      maxAllocatedStorage: Option[Int] = None,
      defaultAllocatedStorage: Option[Int] = None,
      includedAllocatedStorage: Option[Int] = None,
      availabilityZones: Option[List[String]] = None,
      releaseStatus: Option[String] = None
    ): OrderableReplicationInstance =
      OrderableReplicationInstance
        .builder
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(replicationInstanceClass)(_.replicationInstanceClass(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(minAllocatedStorage)(_.minAllocatedStorage(_))
        .ifSome(maxAllocatedStorage)(_.maxAllocatedStorage(_))
        .ifSome(defaultAllocatedStorage)(_.defaultAllocatedStorage(_))
        .ifSome(includedAllocatedStorage)(_.includedAllocatedStorage(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(releaseStatus)(_.releaseStatus(_))
        .build

    def pendingMaintenanceAction(
      action: Option[String] = None,
      autoAppliedAfterDate: Option[TStamp] = None,
      forcedApplyDate: Option[TStamp] = None,
      optInStatus: Option[String] = None,
      currentApplyDate: Option[TStamp] = None,
      description: Option[String] = None
    ): PendingMaintenanceAction =
      PendingMaintenanceAction
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(autoAppliedAfterDate)(_.autoAppliedAfterDate(_))
        .ifSome(forcedApplyDate)(_.forcedApplyDate(_))
        .ifSome(optInStatus)(_.optInStatus(_))
        .ifSome(currentApplyDate)(_.currentApplyDate(_))
        .ifSome(description)(_.description(_))
        .build

    def postgreSQLSettings(
      afterConnectScript: Option[String] = None,
      captureDdls: Option[Boolean] = None,
      maxFileSize: Option[Int] = None,
      databaseName: Option[String] = None,
      ddlArtifactsSchema: Option[String] = None,
      executeTimeout: Option[Int] = None,
      failTasksOnLobTruncation: Option[Boolean] = None,
      password: Option[String] = None,
      port: Option[Int] = None,
      serverName: Option[String] = None,
      username: Option[String] = None,
      slotName: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): PostgreSQLSettings =
      PostgreSQLSettings
        .builder
        .ifSome(afterConnectScript)(_.afterConnectScript(_))
        .ifSome(captureDdls)(_.captureDdls(_))
        .ifSome(maxFileSize)(_.maxFileSize(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(ddlArtifactsSchema)(_.ddlArtifactsSchema(_))
        .ifSome(executeTimeout)(_.executeTimeout(_))
        .ifSome(failTasksOnLobTruncation)(_.failTasksOnLobTruncation(_))
        .ifSome(password)(_.password(_))
        .ifSome(port)(_.port(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(username)(_.username(_))
        .ifSome(slotName)(_.slotName(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def rebootReplicationInstanceMessage(
      replicationInstanceArn: Option[String] = None,
      forceFailover: Option[Boolean] = None
    ): RebootReplicationInstanceMessage =
      RebootReplicationInstanceMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(forceFailover)(_.forceFailover(_))
        .build

    def rebootReplicationInstanceResponse(
      replicationInstance: Option[ReplicationInstance] = None
    ): RebootReplicationInstanceResponse =
      RebootReplicationInstanceResponse
        .builder
        .ifSome(replicationInstance)(_.replicationInstance(_))
        .build

    def redshiftSettings(
      acceptAnyDate: Option[Boolean] = None,
      afterConnectScript: Option[String] = None,
      bucketFolder: Option[String] = None,
      bucketName: Option[String] = None,
      caseSensitiveNames: Option[Boolean] = None,
      compUpdate: Option[Boolean] = None,
      connectionTimeout: Option[Int] = None,
      databaseName: Option[String] = None,
      dateFormat: Option[String] = None,
      emptyAsNull: Option[Boolean] = None,
      encryptionMode: Option[String] = None,
      explicitIds: Option[Boolean] = None,
      fileTransferUploadStreams: Option[Int] = None,
      loadTimeout: Option[Int] = None,
      maxFileSize: Option[Int] = None,
      password: Option[String] = None,
      port: Option[Int] = None,
      removeQuotes: Option[Boolean] = None,
      replaceInvalidChars: Option[String] = None,
      replaceChars: Option[String] = None,
      serverName: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      serverSideEncryptionKmsKeyId: Option[String] = None,
      timeFormat: Option[String] = None,
      trimBlanks: Option[Boolean] = None,
      truncateColumns: Option[Boolean] = None,
      username: Option[String] = None,
      writeBufferSize: Option[Int] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): RedshiftSettings =
      RedshiftSettings
        .builder
        .ifSome(acceptAnyDate)(_.acceptAnyDate(_))
        .ifSome(afterConnectScript)(_.afterConnectScript(_))
        .ifSome(bucketFolder)(_.bucketFolder(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(caseSensitiveNames)(_.caseSensitiveNames(_))
        .ifSome(compUpdate)(_.compUpdate(_))
        .ifSome(connectionTimeout)(_.connectionTimeout(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(dateFormat)(_.dateFormat(_))
        .ifSome(emptyAsNull)(_.emptyAsNull(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(explicitIds)(_.explicitIds(_))
        .ifSome(fileTransferUploadStreams)(_.fileTransferUploadStreams(_))
        .ifSome(loadTimeout)(_.loadTimeout(_))
        .ifSome(maxFileSize)(_.maxFileSize(_))
        .ifSome(password)(_.password(_))
        .ifSome(port)(_.port(_))
        .ifSome(removeQuotes)(_.removeQuotes(_))
        .ifSome(replaceInvalidChars)(_.replaceInvalidChars(_))
        .ifSome(replaceChars)(_.replaceChars(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(serverSideEncryptionKmsKeyId)(_.serverSideEncryptionKmsKeyId(_))
        .ifSome(timeFormat)(_.timeFormat(_))
        .ifSome(trimBlanks)(_.trimBlanks(_))
        .ifSome(truncateColumns)(_.truncateColumns(_))
        .ifSome(username)(_.username(_))
        .ifSome(writeBufferSize)(_.writeBufferSize(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def refreshSchemasMessage(
      endpointArn: Option[String] = None,
      replicationInstanceArn: Option[String] = None
    ): RefreshSchemasMessage =
      RefreshSchemasMessage
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .build

    def refreshSchemasResponse(
      refreshSchemasStatus: Option[RefreshSchemasStatus] = None
    ): RefreshSchemasResponse =
      RefreshSchemasResponse
        .builder
        .ifSome(refreshSchemasStatus)(_.refreshSchemasStatus(_))
        .build

    def refreshSchemasStatus(
      endpointArn: Option[String] = None,
      replicationInstanceArn: Option[String] = None,
      status: Option[String] = None,
      lastRefreshDate: Option[TStamp] = None,
      lastFailureMessage: Option[String] = None
    ): RefreshSchemasStatus =
      RefreshSchemasStatus
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastRefreshDate)(_.lastRefreshDate(_))
        .ifSome(lastFailureMessage)(_.lastFailureMessage(_))
        .build

    def reloadTablesMessage(
      replicationTaskArn: Option[String] = None,
      tablesToReload: Option[List[TableToReload]] = None,
      reloadOption: Option[String] = None
    ): ReloadTablesMessage =
      ReloadTablesMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(tablesToReload)(_.tablesToReload(_))
        .ifSome(reloadOption)(_.reloadOption(_))
        .build

    def reloadTablesResponse(
      replicationTaskArn: Option[String] = None
    ): ReloadTablesResponse =
      ReloadTablesResponse
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .build

    def removeTagsFromResourceMessage(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
    ): RemoveTagsFromResourceMessage =
      RemoveTagsFromResourceMessage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def removeTagsFromResourceResponse(

    ): RemoveTagsFromResourceResponse =
      RemoveTagsFromResourceResponse
        .builder

        .build

    def replicationInstance(
      replicationInstanceIdentifier: Option[String] = None,
      replicationInstanceClass: Option[String] = None,
      replicationInstanceStatus: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      instanceCreateTime: Option[TStamp] = None,
      vpcSecurityGroups: Option[List[VpcSecurityGroupMembership]] = None,
      availabilityZone: Option[String] = None,
      replicationSubnetGroup: Option[ReplicationSubnetGroup] = None,
      preferredMaintenanceWindow: Option[String] = None,
      pendingModifiedValues: Option[ReplicationPendingModifiedValues] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      kmsKeyId: Option[String] = None,
      replicationInstanceArn: Option[String] = None,
      replicationInstancePublicIpAddress: Option[String] = None,
      replicationInstancePrivateIpAddress: Option[String] = None,
      replicationInstancePublicIpAddresses: Option[List[String]] = None,
      replicationInstancePrivateIpAddresses: Option[List[String]] = None,
      publiclyAccessible: Option[Boolean] = None,
      secondaryAvailabilityZone: Option[String] = None,
      freeUntil: Option[TStamp] = None,
      dnsNameServers: Option[String] = None
    ): ReplicationInstance =
      ReplicationInstance
        .builder
        .ifSome(replicationInstanceIdentifier)(_.replicationInstanceIdentifier(_))
        .ifSome(replicationInstanceClass)(_.replicationInstanceClass(_))
        .ifSome(replicationInstanceStatus)(_.replicationInstanceStatus(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(instanceCreateTime)(_.instanceCreateTime(_))
        .ifSome(vpcSecurityGroups)(_.vpcSecurityGroups(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(replicationSubnetGroup)(_.replicationSubnetGroup(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(pendingModifiedValues)(_.pendingModifiedValues(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(replicationInstancePublicIpAddress)(_.replicationInstancePublicIpAddress(_))
        .ifSome(replicationInstancePrivateIpAddress)(_.replicationInstancePrivateIpAddress(_))
        .ifSome(replicationInstancePublicIpAddresses)(_.replicationInstancePublicIpAddresses(_))
        .ifSome(replicationInstancePrivateIpAddresses)(_.replicationInstancePrivateIpAddresses(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(secondaryAvailabilityZone)(_.secondaryAvailabilityZone(_))
        .ifSome(freeUntil)(_.freeUntil(_))
        .ifSome(dnsNameServers)(_.dnsNameServers(_))
        .build

    def replicationInstanceTaskLog(
      replicationTaskName: Option[String] = None,
      replicationTaskArn: Option[String] = None,
      replicationInstanceTaskLogSize: Option[Long] = None
    ): ReplicationInstanceTaskLog =
      ReplicationInstanceTaskLog
        .builder
        .ifSome(replicationTaskName)(_.replicationTaskName(_))
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(replicationInstanceTaskLogSize)(_.replicationInstanceTaskLogSize(_))
        .build

    def replicationPendingModifiedValues(
      replicationInstanceClass: Option[String] = None,
      allocatedStorage: Option[Int] = None,
      multiAZ: Option[Boolean] = None,
      engineVersion: Option[String] = None
    ): ReplicationPendingModifiedValues =
      ReplicationPendingModifiedValues
        .builder
        .ifSome(replicationInstanceClass)(_.replicationInstanceClass(_))
        .ifSome(allocatedStorage)(_.allocatedStorage(_))
        .ifSome(multiAZ)(_.multiAZ(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .build

    def replicationSubnetGroup(
      replicationSubnetGroupIdentifier: Option[String] = None,
      replicationSubnetGroupDescription: Option[String] = None,
      vpcId: Option[String] = None,
      subnetGroupStatus: Option[String] = None,
      subnets: Option[List[Subnet]] = None
    ): ReplicationSubnetGroup =
      ReplicationSubnetGroup
        .builder
        .ifSome(replicationSubnetGroupIdentifier)(_.replicationSubnetGroupIdentifier(_))
        .ifSome(replicationSubnetGroupDescription)(_.replicationSubnetGroupDescription(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetGroupStatus)(_.subnetGroupStatus(_))
        .ifSome(subnets)(_.subnets(_))
        .build

    def replicationSubnetGroupDoesNotCoverEnoughAZs(
      message: Option[String] = None
    ): ReplicationSubnetGroupDoesNotCoverEnoughAZs =
      ReplicationSubnetGroupDoesNotCoverEnoughAZs
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicationTask(
      replicationTaskIdentifier: Option[String] = None,
      sourceEndpointArn: Option[String] = None,
      targetEndpointArn: Option[String] = None,
      replicationInstanceArn: Option[String] = None,
      migrationType: Option[String] = None,
      tableMappings: Option[String] = None,
      replicationTaskSettings: Option[String] = None,
      status: Option[String] = None,
      lastFailureMessage: Option[String] = None,
      stopReason: Option[String] = None,
      replicationTaskCreationDate: Option[TStamp] = None,
      replicationTaskStartDate: Option[TStamp] = None,
      cdcStartPosition: Option[String] = None,
      cdcStopPosition: Option[String] = None,
      recoveryCheckpoint: Option[String] = None,
      replicationTaskArn: Option[String] = None,
      replicationTaskStats: Option[ReplicationTaskStats] = None,
      taskData: Option[String] = None,
      targetReplicationInstanceArn: Option[String] = None
    ): ReplicationTask =
      ReplicationTask
        .builder
        .ifSome(replicationTaskIdentifier)(_.replicationTaskIdentifier(_))
        .ifSome(sourceEndpointArn)(_.sourceEndpointArn(_))
        .ifSome(targetEndpointArn)(_.targetEndpointArn(_))
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(migrationType)(_.migrationType(_))
        .ifSome(tableMappings)(_.tableMappings(_))
        .ifSome(replicationTaskSettings)(_.replicationTaskSettings(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastFailureMessage)(_.lastFailureMessage(_))
        .ifSome(stopReason)(_.stopReason(_))
        .ifSome(replicationTaskCreationDate)(_.replicationTaskCreationDate(_))
        .ifSome(replicationTaskStartDate)(_.replicationTaskStartDate(_))
        .ifSome(cdcStartPosition)(_.cdcStartPosition(_))
        .ifSome(cdcStopPosition)(_.cdcStopPosition(_))
        .ifSome(recoveryCheckpoint)(_.recoveryCheckpoint(_))
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(replicationTaskStats)(_.replicationTaskStats(_))
        .ifSome(taskData)(_.taskData(_))
        .ifSome(targetReplicationInstanceArn)(_.targetReplicationInstanceArn(_))
        .build

    def replicationTaskAssessmentRun(
      replicationTaskAssessmentRunArn: Option[String] = None,
      replicationTaskArn: Option[String] = None,
      status: Option[String] = None,
      replicationTaskAssessmentRunCreationDate: Option[TStamp] = None,
      assessmentProgress: Option[ReplicationTaskAssessmentRunProgress] = None,
      lastFailureMessage: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      resultLocationBucket: Option[String] = None,
      resultLocationFolder: Option[String] = None,
      resultEncryptionMode: Option[String] = None,
      resultKmsKeyArn: Option[String] = None,
      assessmentRunName: Option[String] = None
    ): ReplicationTaskAssessmentRun =
      ReplicationTaskAssessmentRun
        .builder
        .ifSome(replicationTaskAssessmentRunArn)(_.replicationTaskAssessmentRunArn(_))
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(replicationTaskAssessmentRunCreationDate)(_.replicationTaskAssessmentRunCreationDate(_))
        .ifSome(assessmentProgress)(_.assessmentProgress(_))
        .ifSome(lastFailureMessage)(_.lastFailureMessage(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(resultLocationBucket)(_.resultLocationBucket(_))
        .ifSome(resultLocationFolder)(_.resultLocationFolder(_))
        .ifSome(resultEncryptionMode)(_.resultEncryptionMode(_))
        .ifSome(resultKmsKeyArn)(_.resultKmsKeyArn(_))
        .ifSome(assessmentRunName)(_.assessmentRunName(_))
        .build

    def replicationTaskAssessmentRunProgress(
      individualAssessmentCount: Option[Int] = None,
      individualAssessmentCompletedCount: Option[Int] = None
    ): ReplicationTaskAssessmentRunProgress =
      ReplicationTaskAssessmentRunProgress
        .builder
        .ifSome(individualAssessmentCount)(_.individualAssessmentCount(_))
        .ifSome(individualAssessmentCompletedCount)(_.individualAssessmentCompletedCount(_))
        .build

    def replicationTaskIndividualAssessment(
      replicationTaskIndividualAssessmentArn: Option[String] = None,
      replicationTaskAssessmentRunArn: Option[String] = None,
      individualAssessmentName: Option[String] = None,
      status: Option[String] = None,
      replicationTaskIndividualAssessmentStartDate: Option[TStamp] = None
    ): ReplicationTaskIndividualAssessment =
      ReplicationTaskIndividualAssessment
        .builder
        .ifSome(replicationTaskIndividualAssessmentArn)(_.replicationTaskIndividualAssessmentArn(_))
        .ifSome(replicationTaskAssessmentRunArn)(_.replicationTaskAssessmentRunArn(_))
        .ifSome(individualAssessmentName)(_.individualAssessmentName(_))
        .ifSome(status)(_.status(_))
        .ifSome(replicationTaskIndividualAssessmentStartDate)(_.replicationTaskIndividualAssessmentStartDate(_))
        .build

    def replicationTaskStats(
      fullLoadProgressPercent: Option[Int] = None,
      elapsedTimeMillis: Option[Long] = None,
      tablesLoaded: Option[Int] = None,
      tablesLoading: Option[Int] = None,
      tablesQueued: Option[Int] = None,
      tablesErrored: Option[Int] = None,
      freshStartDate: Option[TStamp] = None,
      startDate: Option[TStamp] = None,
      stopDate: Option[TStamp] = None,
      fullLoadStartDate: Option[TStamp] = None,
      fullLoadFinishDate: Option[TStamp] = None
    ): ReplicationTaskStats =
      ReplicationTaskStats
        .builder
        .ifSome(fullLoadProgressPercent)(_.fullLoadProgressPercent(_))
        .ifSome(elapsedTimeMillis)(_.elapsedTimeMillis(_))
        .ifSome(tablesLoaded)(_.tablesLoaded(_))
        .ifSome(tablesLoading)(_.tablesLoading(_))
        .ifSome(tablesQueued)(_.tablesQueued(_))
        .ifSome(tablesErrored)(_.tablesErrored(_))
        .ifSome(freshStartDate)(_.freshStartDate(_))
        .ifSome(startDate)(_.startDate(_))
        .ifSome(stopDate)(_.stopDate(_))
        .ifSome(fullLoadStartDate)(_.fullLoadStartDate(_))
        .ifSome(fullLoadFinishDate)(_.fullLoadFinishDate(_))
        .build

    def resourceAlreadyExistsFault(
      message: Option[String] = None,
      resourceArn: Option[String] = None
    ): ResourceAlreadyExistsFault =
      ResourceAlreadyExistsFault
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def resourceNotFoundFault(
      message: Option[String] = None
    ): ResourceNotFoundFault =
      ResourceNotFoundFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourcePendingMaintenanceActions(
      resourceIdentifier: Option[String] = None,
      pendingMaintenanceActionDetails: Option[List[PendingMaintenanceAction]] = None
    ): ResourcePendingMaintenanceActions =
      ResourcePendingMaintenanceActions
        .builder
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(pendingMaintenanceActionDetails)(_.pendingMaintenanceActionDetails(_))
        .build

    def resourceQuotaExceededFault(
      message: Option[String] = None
    ): ResourceQuotaExceededFault =
      ResourceQuotaExceededFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3AccessDeniedFault(
      message: Option[String] = None
    ): S3AccessDeniedFault =
      S3AccessDeniedFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3ResourceNotFoundFault(
      message: Option[String] = None
    ): S3ResourceNotFoundFault =
      S3ResourceNotFoundFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3Settings(
      serviceAccessRoleArn: Option[String] = None,
      externalTableDefinition: Option[String] = None,
      csvRowDelimiter: Option[String] = None,
      csvDelimiter: Option[String] = None,
      bucketFolder: Option[String] = None,
      bucketName: Option[String] = None,
      compressionType: Option[String] = None,
      encryptionMode: Option[String] = None,
      serverSideEncryptionKmsKeyId: Option[String] = None,
      dataFormat: Option[String] = None,
      encodingType: Option[String] = None,
      dictPageSizeLimit: Option[Int] = None,
      rowGroupLength: Option[Int] = None,
      dataPageSize: Option[Int] = None,
      parquetVersion: Option[String] = None,
      enableStatistics: Option[Boolean] = None,
      includeOpForFullLoad: Option[Boolean] = None,
      cdcInsertsOnly: Option[Boolean] = None,
      timestampColumnName: Option[String] = None,
      parquetTimestampInMillisecond: Option[Boolean] = None,
      cdcInsertsAndUpdates: Option[Boolean] = None,
      datePartitionEnabled: Option[Boolean] = None,
      datePartitionSequence: Option[String] = None,
      datePartitionDelimiter: Option[String] = None,
      useCsvNoSupValue: Option[Boolean] = None,
      csvNoSupValue: Option[String] = None,
      preserveTransactions: Option[Boolean] = None,
      cdcPath: Option[String] = None
    ): S3Settings =
      S3Settings
        .builder
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(externalTableDefinition)(_.externalTableDefinition(_))
        .ifSome(csvRowDelimiter)(_.csvRowDelimiter(_))
        .ifSome(csvDelimiter)(_.csvDelimiter(_))
        .ifSome(bucketFolder)(_.bucketFolder(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(compressionType)(_.compressionType(_))
        .ifSome(encryptionMode)(_.encryptionMode(_))
        .ifSome(serverSideEncryptionKmsKeyId)(_.serverSideEncryptionKmsKeyId(_))
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(dictPageSizeLimit)(_.dictPageSizeLimit(_))
        .ifSome(rowGroupLength)(_.rowGroupLength(_))
        .ifSome(dataPageSize)(_.dataPageSize(_))
        .ifSome(parquetVersion)(_.parquetVersion(_))
        .ifSome(enableStatistics)(_.enableStatistics(_))
        .ifSome(includeOpForFullLoad)(_.includeOpForFullLoad(_))
        .ifSome(cdcInsertsOnly)(_.cdcInsertsOnly(_))
        .ifSome(timestampColumnName)(_.timestampColumnName(_))
        .ifSome(parquetTimestampInMillisecond)(_.parquetTimestampInMillisecond(_))
        .ifSome(cdcInsertsAndUpdates)(_.cdcInsertsAndUpdates(_))
        .ifSome(datePartitionEnabled)(_.datePartitionEnabled(_))
        .ifSome(datePartitionSequence)(_.datePartitionSequence(_))
        .ifSome(datePartitionDelimiter)(_.datePartitionDelimiter(_))
        .ifSome(useCsvNoSupValue)(_.useCsvNoSupValue(_))
        .ifSome(csvNoSupValue)(_.csvNoSupValue(_))
        .ifSome(preserveTransactions)(_.preserveTransactions(_))
        .ifSome(cdcPath)(_.cdcPath(_))
        .build

    def sNSInvalidTopicFault(
      message: Option[String] = None
    ): SNSInvalidTopicFault =
      SNSInvalidTopicFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sNSNoAuthorizationFault(
      message: Option[String] = None
    ): SNSNoAuthorizationFault =
      SNSNoAuthorizationFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startReplicationTaskAssessmentMessage(
      replicationTaskArn: Option[String] = None
    ): StartReplicationTaskAssessmentMessage =
      StartReplicationTaskAssessmentMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .build

    def startReplicationTaskAssessmentResponse(
      replicationTask: Option[ReplicationTask] = None
    ): StartReplicationTaskAssessmentResponse =
      StartReplicationTaskAssessmentResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def startReplicationTaskAssessmentRunMessage(
      replicationTaskArn: Option[String] = None,
      serviceAccessRoleArn: Option[String] = None,
      resultLocationBucket: Option[String] = None,
      resultLocationFolder: Option[String] = None,
      resultEncryptionMode: Option[String] = None,
      resultKmsKeyArn: Option[String] = None,
      assessmentRunName: Option[String] = None,
      includeOnly: Option[List[String]] = None,
      exclude: Option[List[String]] = None
    ): StartReplicationTaskAssessmentRunMessage =
      StartReplicationTaskAssessmentRunMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(serviceAccessRoleArn)(_.serviceAccessRoleArn(_))
        .ifSome(resultLocationBucket)(_.resultLocationBucket(_))
        .ifSome(resultLocationFolder)(_.resultLocationFolder(_))
        .ifSome(resultEncryptionMode)(_.resultEncryptionMode(_))
        .ifSome(resultKmsKeyArn)(_.resultKmsKeyArn(_))
        .ifSome(assessmentRunName)(_.assessmentRunName(_))
        .ifSome(includeOnly)(_.includeOnly(_))
        .ifSome(exclude)(_.exclude(_))
        .build

    def startReplicationTaskAssessmentRunResponse(
      replicationTaskAssessmentRun: Option[ReplicationTaskAssessmentRun] = None
    ): StartReplicationTaskAssessmentRunResponse =
      StartReplicationTaskAssessmentRunResponse
        .builder
        .ifSome(replicationTaskAssessmentRun)(_.replicationTaskAssessmentRun(_))
        .build

    def startReplicationTaskMessage(
      replicationTaskArn: Option[String] = None,
      startReplicationTaskType: Option[String] = None,
      cdcStartTime: Option[TStamp] = None,
      cdcStartPosition: Option[String] = None,
      cdcStopPosition: Option[String] = None
    ): StartReplicationTaskMessage =
      StartReplicationTaskMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .ifSome(startReplicationTaskType)(_.startReplicationTaskType(_))
        .ifSome(cdcStartTime)(_.cdcStartTime(_))
        .ifSome(cdcStartPosition)(_.cdcStartPosition(_))
        .ifSome(cdcStopPosition)(_.cdcStopPosition(_))
        .build

    def startReplicationTaskResponse(
      replicationTask: Option[ReplicationTask] = None
    ): StartReplicationTaskResponse =
      StartReplicationTaskResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def stopReplicationTaskMessage(
      replicationTaskArn: Option[String] = None
    ): StopReplicationTaskMessage =
      StopReplicationTaskMessage
        .builder
        .ifSome(replicationTaskArn)(_.replicationTaskArn(_))
        .build

    def stopReplicationTaskResponse(
      replicationTask: Option[ReplicationTask] = None
    ): StopReplicationTaskResponse =
      StopReplicationTaskResponse
        .builder
        .ifSome(replicationTask)(_.replicationTask(_))
        .build

    def storageQuotaExceededFault(
      message: Option[String] = None
    ): StorageQuotaExceededFault =
      StorageQuotaExceededFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def subnet(
      subnetIdentifier: Option[String] = None,
      subnetAvailabilityZone: Option[AvailabilityZone] = None,
      subnetStatus: Option[String] = None
    ): Subnet =
      Subnet
        .builder
        .ifSome(subnetIdentifier)(_.subnetIdentifier(_))
        .ifSome(subnetAvailabilityZone)(_.subnetAvailabilityZone(_))
        .ifSome(subnetStatus)(_.subnetStatus(_))
        .build

    def subnetAlreadyInUse(
      message: Option[String] = None
    ): SubnetAlreadyInUse =
      SubnetAlreadyInUse
        .builder
        .ifSome(message)(_.message(_))
        .build

    def supportedEndpointType(
      engineName: Option[String] = None,
      supportsCDC: Option[Boolean] = None,
      endpointType: Option[String] = None,
      replicationInstanceEngineMinimumVersion: Option[String] = None,
      engineDisplayName: Option[String] = None
    ): SupportedEndpointType =
      SupportedEndpointType
        .builder
        .ifSome(engineName)(_.engineName(_))
        .ifSome(supportsCDC)(_.supportsCDC(_))
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(replicationInstanceEngineMinimumVersion)(_.replicationInstanceEngineMinimumVersion(_))
        .ifSome(engineDisplayName)(_.engineDisplayName(_))
        .build

    def sybaseSettings(
      databaseName: Option[String] = None,
      password: Option[String] = None,
      port: Option[Int] = None,
      serverName: Option[String] = None,
      username: Option[String] = None,
      secretsManagerAccessRoleArn: Option[String] = None,
      secretsManagerSecretId: Option[String] = None
    ): SybaseSettings =
      SybaseSettings
        .builder
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(password)(_.password(_))
        .ifSome(port)(_.port(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(username)(_.username(_))
        .ifSome(secretsManagerAccessRoleArn)(_.secretsManagerAccessRoleArn(_))
        .ifSome(secretsManagerSecretId)(_.secretsManagerSecretId(_))
        .build

    def tableStatistics(
      schemaName: Option[String] = None,
      tableName: Option[String] = None,
      inserts: Option[Long] = None,
      deletes: Option[Long] = None,
      updates: Option[Long] = None,
      ddls: Option[Long] = None,
      fullLoadRows: Option[Long] = None,
      fullLoadCondtnlChkFailedRows: Option[Long] = None,
      fullLoadErrorRows: Option[Long] = None,
      fullLoadStartTime: Option[TStamp] = None,
      fullLoadEndTime: Option[TStamp] = None,
      fullLoadReloaded: Option[Boolean] = None,
      lastUpdateTime: Option[TStamp] = None,
      tableState: Option[String] = None,
      validationPendingRecords: Option[Long] = None,
      validationFailedRecords: Option[Long] = None,
      validationSuspendedRecords: Option[Long] = None,
      validationState: Option[String] = None,
      validationStateDetails: Option[String] = None
    ): TableStatistics =
      TableStatistics
        .builder
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(inserts)(_.inserts(_))
        .ifSome(deletes)(_.deletes(_))
        .ifSome(updates)(_.updates(_))
        .ifSome(ddls)(_.ddls(_))
        .ifSome(fullLoadRows)(_.fullLoadRows(_))
        .ifSome(fullLoadCondtnlChkFailedRows)(_.fullLoadCondtnlChkFailedRows(_))
        .ifSome(fullLoadErrorRows)(_.fullLoadErrorRows(_))
        .ifSome(fullLoadStartTime)(_.fullLoadStartTime(_))
        .ifSome(fullLoadEndTime)(_.fullLoadEndTime(_))
        .ifSome(fullLoadReloaded)(_.fullLoadReloaded(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(tableState)(_.tableState(_))
        .ifSome(validationPendingRecords)(_.validationPendingRecords(_))
        .ifSome(validationFailedRecords)(_.validationFailedRecords(_))
        .ifSome(validationSuspendedRecords)(_.validationSuspendedRecords(_))
        .ifSome(validationState)(_.validationState(_))
        .ifSome(validationStateDetails)(_.validationStateDetails(_))
        .build

    def tableToReload(
      schemaName: Option[String] = None,
      tableName: Option[String] = None
    ): TableToReload =
      TableToReload
        .builder
        .ifSome(schemaName)(_.schemaName(_))
        .ifSome(tableName)(_.tableName(_))
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

    def testConnectionMessage(
      replicationInstanceArn: Option[String] = None,
      endpointArn: Option[String] = None
    ): TestConnectionMessage =
      TestConnectionMessage
        .builder
        .ifSome(replicationInstanceArn)(_.replicationInstanceArn(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def testConnectionResponse(
      connection: Option[Connection] = None
    ): TestConnectionResponse =
      TestConnectionResponse
        .builder
        .ifSome(connection)(_.connection(_))
        .build

    def upgradeDependencyFailureFault(
      message: Option[String] = None
    ): UpgradeDependencyFailureFault =
      UpgradeDependencyFailureFault
        .builder
        .ifSome(message)(_.message(_))
        .build

    def vpcSecurityGroupMembership(
      vpcSecurityGroupId: Option[String] = None,
      status: Option[String] = None
    ): VpcSecurityGroupMembership =
      VpcSecurityGroupMembership
        .builder
        .ifSome(vpcSecurityGroupId)(_.vpcSecurityGroupId(_))
        .ifSome(status)(_.status(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
