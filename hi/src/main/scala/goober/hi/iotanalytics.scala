package goober.hi

import goober.free.iotanalytics.IoTAnalyticsIO
import software.amazon.awssdk.services.iotanalytics.model._


object iotanalytics {
  import goober.free.{iotanalytics ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addAttributesActivity(
      name: Option[String] = None,
      attributes: Option[AttributeNameMapping] = None,
      next: Option[String] = None
    ): AddAttributesActivity =
      AddAttributesActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(next)(_.next(_))
        .build

    def batchPutMessageErrorEntry(
      messageId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchPutMessageErrorEntry =
      BatchPutMessageErrorEntry
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchPutMessageRequest(
      channelName: Option[String] = None,
      messages: Option[List[Message]] = None
    ): BatchPutMessageRequest =
      BatchPutMessageRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(messages)(_.messages(_))
        .build

    def batchPutMessageResponse(
      batchPutMessageErrorEntries: Option[List[BatchPutMessageErrorEntry]] = None
    ): BatchPutMessageResponse =
      BatchPutMessageResponse
        .builder
        .ifSome(batchPutMessageErrorEntries)(_.batchPutMessageErrorEntries(_))
        .build

    def cancelPipelineReprocessingRequest(
      pipelineName: Option[String] = None,
      reprocessingId: Option[String] = None
    ): CancelPipelineReprocessingRequest =
      CancelPipelineReprocessingRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(reprocessingId)(_.reprocessingId(_))
        .build

    def cancelPipelineReprocessingResponse(

    ): CancelPipelineReprocessingResponse =
      CancelPipelineReprocessingResponse
        .builder

        .build

    def channel(
      name: Option[String] = None,
      storage: Option[ChannelStorage] = None,
      arn: Option[String] = None,
      status: Option[String] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      lastMessageArrivalTime: Option[Timestamp] = None
    ): Channel =
      Channel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(storage)(_.storage(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(lastMessageArrivalTime)(_.lastMessageArrivalTime(_))
        .build

    def channelActivity(
      name: Option[String] = None,
      channelName: Option[String] = None,
      next: Option[String] = None
    ): ChannelActivity =
      ChannelActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(next)(_.next(_))
        .build

    def channelMessages(
      s3Paths: Option[List[S3PathChannelMessage]] = None
    ): ChannelMessages =
      ChannelMessages
        .builder
        .ifSome(s3Paths)(_.s3Paths(_))
        .build

    def channelStatistics(
      size: Option[EstimatedResourceSize] = None
    ): ChannelStatistics =
      ChannelStatistics
        .builder
        .ifSome(size)(_.size(_))
        .build

    def channelStorage(
      serviceManagedS3: Option[ServiceManagedChannelS3Storage] = None,
      customerManagedS3: Option[CustomerManagedChannelS3Storage] = None
    ): ChannelStorage =
      ChannelStorage
        .builder
        .ifSome(serviceManagedS3)(_.serviceManagedS3(_))
        .ifSome(customerManagedS3)(_.customerManagedS3(_))
        .build

    def channelStorageSummary(
      serviceManagedS3: Option[ServiceManagedChannelS3StorageSummary] = None,
      customerManagedS3: Option[CustomerManagedChannelS3StorageSummary] = None
    ): ChannelStorageSummary =
      ChannelStorageSummary
        .builder
        .ifSome(serviceManagedS3)(_.serviceManagedS3(_))
        .ifSome(customerManagedS3)(_.customerManagedS3(_))
        .build

    def channelSummary(
      channelName: Option[String] = None,
      channelStorage: Option[ChannelStorageSummary] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      lastMessageArrivalTime: Option[Timestamp] = None
    ): ChannelSummary =
      ChannelSummary
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelStorage)(_.channelStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(lastMessageArrivalTime)(_.lastMessageArrivalTime(_))
        .build

    def column(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): Column =
      Column
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def containerDatasetAction(
      image: Option[String] = None,
      executionRoleArn: Option[String] = None,
      resourceConfiguration: Option[ResourceConfiguration] = None,
      variables: Option[List[Variable]] = None
    ): ContainerDatasetAction =
      ContainerDatasetAction
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(resourceConfiguration)(_.resourceConfiguration(_))
        .ifSome(variables)(_.variables(_))
        .build

    def createChannelRequest(
      channelName: Option[String] = None,
      channelStorage: Option[ChannelStorage] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      tags: Option[List[Tag]] = None
    ): CreateChannelRequest =
      CreateChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelStorage)(_.channelStorage(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChannelResponse(
      channelName: Option[String] = None,
      channelArn: Option[String] = None,
      retentionPeriod: Option[RetentionPeriod] = None
    ): CreateChannelResponse =
      CreateChannelResponse
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .build

    def createDatasetContentRequest(
      datasetName: Option[String] = None,
      versionId: Option[String] = None
    ): CreateDatasetContentRequest =
      CreateDatasetContentRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def createDatasetContentResponse(
      versionId: Option[String] = None
    ): CreateDatasetContentResponse =
      CreateDatasetContentResponse
        .builder
        .ifSome(versionId)(_.versionId(_))
        .build

    def createDatasetRequest(
      datasetName: Option[String] = None,
      actions: Option[List[DatasetAction]] = None,
      triggers: Option[List[DatasetTrigger]] = None,
      contentDeliveryRules: Option[List[DatasetContentDeliveryRule]] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      versioningConfiguration: Option[VersioningConfiguration] = None,
      tags: Option[List[Tag]] = None,
      lateDataRules: Option[List[LateDataRule]] = None
    ): CreateDatasetRequest =
      CreateDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(triggers)(_.triggers(_))
        .ifSome(contentDeliveryRules)(_.contentDeliveryRules(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(versioningConfiguration)(_.versioningConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(lateDataRules)(_.lateDataRules(_))
        .build

    def createDatasetResponse(
      datasetName: Option[String] = None,
      datasetArn: Option[String] = None,
      retentionPeriod: Option[RetentionPeriod] = None
    ): CreateDatasetResponse =
      CreateDatasetResponse
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .build

    def createDatastoreRequest(
      datastoreName: Option[String] = None,
      datastoreStorage: Option[DatastoreStorage] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      tags: Option[List[Tag]] = None,
      fileFormatConfiguration: Option[FileFormatConfiguration] = None,
      datastorePartitions: Option[DatastorePartitions] = None
    ): CreateDatastoreRequest =
      CreateDatastoreRequest
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(datastoreStorage)(_.datastoreStorage(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileFormatConfiguration)(_.fileFormatConfiguration(_))
        .ifSome(datastorePartitions)(_.datastorePartitions(_))
        .build

    def createDatastoreResponse(
      datastoreName: Option[String] = None,
      datastoreArn: Option[String] = None,
      retentionPeriod: Option[RetentionPeriod] = None
    ): CreateDatastoreResponse =
      CreateDatastoreResponse
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(datastoreArn)(_.datastoreArn(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .build

    def createPipelineRequest(
      pipelineName: Option[String] = None,
      pipelineActivities: Option[List[PipelineActivity]] = None,
      tags: Option[List[Tag]] = None
    ): CreatePipelineRequest =
      CreatePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineActivities)(_.pipelineActivities(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPipelineResponse(
      pipelineName: Option[String] = None,
      pipelineArn: Option[String] = None
    ): CreatePipelineResponse =
      CreatePipelineResponse
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineArn)(_.pipelineArn(_))
        .build

    def customerManagedChannelS3Storage(
      bucket: Option[String] = None,
      keyPrefix: Option[String] = None,
      roleArn: Option[String] = None
    ): CustomerManagedChannelS3Storage =
      CustomerManagedChannelS3Storage
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def customerManagedChannelS3StorageSummary(
      bucket: Option[String] = None,
      keyPrefix: Option[String] = None,
      roleArn: Option[String] = None
    ): CustomerManagedChannelS3StorageSummary =
      CustomerManagedChannelS3StorageSummary
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def customerManagedDatastoreS3Storage(
      bucket: Option[String] = None,
      keyPrefix: Option[String] = None,
      roleArn: Option[String] = None
    ): CustomerManagedDatastoreS3Storage =
      CustomerManagedDatastoreS3Storage
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def customerManagedDatastoreS3StorageSummary(
      bucket: Option[String] = None,
      keyPrefix: Option[String] = None,
      roleArn: Option[String] = None
    ): CustomerManagedDatastoreS3StorageSummary =
      CustomerManagedDatastoreS3StorageSummary
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(keyPrefix)(_.keyPrefix(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def dataset(
      name: Option[String] = None,
      arn: Option[String] = None,
      actions: Option[List[DatasetAction]] = None,
      triggers: Option[List[DatasetTrigger]] = None,
      contentDeliveryRules: Option[List[DatasetContentDeliveryRule]] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      versioningConfiguration: Option[VersioningConfiguration] = None,
      lateDataRules: Option[List[LateDataRule]] = None
    ): Dataset =
      Dataset
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(triggers)(_.triggers(_))
        .ifSome(contentDeliveryRules)(_.contentDeliveryRules(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(versioningConfiguration)(_.versioningConfiguration(_))
        .ifSome(lateDataRules)(_.lateDataRules(_))
        .build

    def datasetAction(
      actionName: Option[String] = None,
      queryAction: Option[SqlQueryDatasetAction] = None,
      containerAction: Option[ContainerDatasetAction] = None
    ): DatasetAction =
      DatasetAction
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(queryAction)(_.queryAction(_))
        .ifSome(containerAction)(_.containerAction(_))
        .build

    def datasetActionSummary(
      actionName: Option[String] = None,
      actionType: Option[String] = None
    ): DatasetActionSummary =
      DatasetActionSummary
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionType)(_.actionType(_))
        .build

    def datasetContentDeliveryDestination(
      iotEventsDestinationConfiguration: Option[IotEventsDestinationConfiguration] = None,
      s3DestinationConfiguration: Option[S3DestinationConfiguration] = None
    ): DatasetContentDeliveryDestination =
      DatasetContentDeliveryDestination
        .builder
        .ifSome(iotEventsDestinationConfiguration)(_.iotEventsDestinationConfiguration(_))
        .ifSome(s3DestinationConfiguration)(_.s3DestinationConfiguration(_))
        .build

    def datasetContentDeliveryRule(
      entryName: Option[String] = None,
      destination: Option[DatasetContentDeliveryDestination] = None
    ): DatasetContentDeliveryRule =
      DatasetContentDeliveryRule
        .builder
        .ifSome(entryName)(_.entryName(_))
        .ifSome(destination)(_.destination(_))
        .build

    def datasetContentStatus(
      state: Option[String] = None,
      reason: Option[String] = None
    ): DatasetContentStatus =
      DatasetContentStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(reason)(_.reason(_))
        .build

    def datasetContentSummary(
      version: Option[String] = None,
      status: Option[DatasetContentStatus] = None,
      creationTime: Option[Timestamp] = None,
      scheduleTime: Option[Timestamp] = None,
      completionTime: Option[Timestamp] = None
    ): DatasetContentSummary =
      DatasetContentSummary
        .builder
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(scheduleTime)(_.scheduleTime(_))
        .ifSome(completionTime)(_.completionTime(_))
        .build

    def datasetContentVersionValue(
      datasetName: Option[String] = None
    ): DatasetContentVersionValue =
      DatasetContentVersionValue
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def datasetEntry(
      entryName: Option[String] = None,
      dataURI: Option[String] = None
    ): DatasetEntry =
      DatasetEntry
        .builder
        .ifSome(entryName)(_.entryName(_))
        .ifSome(dataURI)(_.dataURI(_))
        .build

    def datasetSummary(
      datasetName: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      triggers: Option[List[DatasetTrigger]] = None,
      actions: Option[List[DatasetActionSummary]] = None
    ): DatasetSummary =
      DatasetSummary
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(triggers)(_.triggers(_))
        .ifSome(actions)(_.actions(_))
        .build

    def datasetTrigger(
      schedule: Option[Schedule] = None,
      dataset: Option[TriggeringDataset] = None
    ): DatasetTrigger =
      DatasetTrigger
        .builder
        .ifSome(schedule)(_.schedule(_))
        .ifSome(dataset)(_.dataset(_))
        .build

    def datastore(
      name: Option[String] = None,
      storage: Option[DatastoreStorage] = None,
      arn: Option[String] = None,
      status: Option[String] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      lastMessageArrivalTime: Option[Timestamp] = None,
      fileFormatConfiguration: Option[FileFormatConfiguration] = None,
      datastorePartitions: Option[DatastorePartitions] = None
    ): Datastore =
      Datastore
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(storage)(_.storage(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(lastMessageArrivalTime)(_.lastMessageArrivalTime(_))
        .ifSome(fileFormatConfiguration)(_.fileFormatConfiguration(_))
        .ifSome(datastorePartitions)(_.datastorePartitions(_))
        .build

    def datastoreActivity(
      name: Option[String] = None,
      datastoreName: Option[String] = None
    ): DatastoreActivity =
      DatastoreActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(datastoreName)(_.datastoreName(_))
        .build

    def datastorePartition(
      attributePartition: Option[Partition] = None,
      timestampPartition: Option[TimestampPartition] = None
    ): DatastorePartition =
      DatastorePartition
        .builder
        .ifSome(attributePartition)(_.attributePartition(_))
        .ifSome(timestampPartition)(_.timestampPartition(_))
        .build

    def datastorePartitions(
      partitions: Option[List[DatastorePartition]] = None
    ): DatastorePartitions =
      DatastorePartitions
        .builder
        .ifSome(partitions)(_.partitions(_))
        .build

    def datastoreStatistics(
      size: Option[EstimatedResourceSize] = None
    ): DatastoreStatistics =
      DatastoreStatistics
        .builder
        .ifSome(size)(_.size(_))
        .build

    def datastoreStorage(
      serviceManagedS3: Option[ServiceManagedDatastoreS3Storage] = None,
      customerManagedS3: Option[CustomerManagedDatastoreS3Storage] = None
    ): DatastoreStorage =
      DatastoreStorage
        .builder
        .ifSome(serviceManagedS3)(_.serviceManagedS3(_))
        .ifSome(customerManagedS3)(_.customerManagedS3(_))
        .build

    def datastoreStorageSummary(
      serviceManagedS3: Option[ServiceManagedDatastoreS3StorageSummary] = None,
      customerManagedS3: Option[CustomerManagedDatastoreS3StorageSummary] = None
    ): DatastoreStorageSummary =
      DatastoreStorageSummary
        .builder
        .ifSome(serviceManagedS3)(_.serviceManagedS3(_))
        .ifSome(customerManagedS3)(_.customerManagedS3(_))
        .build

    def datastoreSummary(
      datastoreName: Option[String] = None,
      datastoreStorage: Option[DatastoreStorageSummary] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None,
      lastMessageArrivalTime: Option[Timestamp] = None,
      fileFormatType: Option[String] = None,
      datastorePartitions: Option[DatastorePartitions] = None
    ): DatastoreSummary =
      DatastoreSummary
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(datastoreStorage)(_.datastoreStorage(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .ifSome(lastMessageArrivalTime)(_.lastMessageArrivalTime(_))
        .ifSome(fileFormatType)(_.fileFormatType(_))
        .ifSome(datastorePartitions)(_.datastorePartitions(_))
        .build

    def deleteChannelRequest(
      channelName: Option[String] = None
    ): DeleteChannelRequest =
      DeleteChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def deleteDatasetContentRequest(
      datasetName: Option[String] = None,
      versionId: Option[String] = None
    ): DeleteDatasetContentRequest =
      DeleteDatasetContentRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def deleteDatasetRequest(
      datasetName: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def deleteDatastoreRequest(
      datastoreName: Option[String] = None
    ): DeleteDatastoreRequest =
      DeleteDatastoreRequest
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .build

    def deletePipelineRequest(
      pipelineName: Option[String] = None
    ): DeletePipelineRequest =
      DeletePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .build

    def deltaTime(
      offsetSeconds: Option[Int] = None,
      timeExpression: Option[String] = None
    ): DeltaTime =
      DeltaTime
        .builder
        .ifSome(offsetSeconds)(_.offsetSeconds(_))
        .ifSome(timeExpression)(_.timeExpression(_))
        .build

    def deltaTimeSessionWindowConfiguration(
      timeoutInMinutes: Option[Int] = None
    ): DeltaTimeSessionWindowConfiguration =
      DeltaTimeSessionWindowConfiguration
        .builder
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .build

    def describeChannelRequest(
      channelName: Option[String] = None,
      includeStatistics: Option[Boolean] = None
    ): DescribeChannelRequest =
      DescribeChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(includeStatistics)(_.includeStatistics(_))
        .build

    def describeChannelResponse(
      channel: Option[Channel] = None,
      statistics: Option[ChannelStatistics] = None
    ): DescribeChannelResponse =
      DescribeChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def describeDatasetRequest(
      datasetName: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def describeDatasetResponse(
      dataset: Option[Dataset] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(dataset)(_.dataset(_))
        .build

    def describeDatastoreRequest(
      datastoreName: Option[String] = None,
      includeStatistics: Option[Boolean] = None
    ): DescribeDatastoreRequest =
      DescribeDatastoreRequest
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(includeStatistics)(_.includeStatistics(_))
        .build

    def describeDatastoreResponse(
      datastore: Option[Datastore] = None,
      statistics: Option[DatastoreStatistics] = None
    ): DescribeDatastoreResponse =
      DescribeDatastoreResponse
        .builder
        .ifSome(datastore)(_.datastore(_))
        .ifSome(statistics)(_.statistics(_))
        .build

    def describeLoggingOptionsRequest(

    ): DescribeLoggingOptionsRequest =
      DescribeLoggingOptionsRequest
        .builder

        .build

    def describeLoggingOptionsResponse(
      loggingOptions: Option[LoggingOptions] = None
    ): DescribeLoggingOptionsResponse =
      DescribeLoggingOptionsResponse
        .builder
        .ifSome(loggingOptions)(_.loggingOptions(_))
        .build

    def describePipelineRequest(
      pipelineName: Option[String] = None
    ): DescribePipelineRequest =
      DescribePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .build

    def describePipelineResponse(
      pipeline: Option[Pipeline] = None
    ): DescribePipelineResponse =
      DescribePipelineResponse
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def deviceRegistryEnrichActivity(
      name: Option[String] = None,
      attribute: Option[String] = None,
      thingName: Option[String] = None,
      roleArn: Option[String] = None,
      next: Option[String] = None
    ): DeviceRegistryEnrichActivity =
      DeviceRegistryEnrichActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attribute)(_.attribute(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(next)(_.next(_))
        .build

    def deviceShadowEnrichActivity(
      name: Option[String] = None,
      attribute: Option[String] = None,
      thingName: Option[String] = None,
      roleArn: Option[String] = None,
      next: Option[String] = None
    ): DeviceShadowEnrichActivity =
      DeviceShadowEnrichActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attribute)(_.attribute(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(next)(_.next(_))
        .build

    def estimatedResourceSize(
      estimatedSizeInBytes: Option[SizeInBytes] = None,
      estimatedOn: Option[Timestamp] = None
    ): EstimatedResourceSize =
      EstimatedResourceSize
        .builder
        .ifSome(estimatedSizeInBytes)(_.estimatedSizeInBytes(_))
        .ifSome(estimatedOn)(_.estimatedOn(_))
        .build

    def fileFormatConfiguration(
      jsonConfiguration: Option[JsonConfiguration] = None,
      parquetConfiguration: Option[ParquetConfiguration] = None
    ): FileFormatConfiguration =
      FileFormatConfiguration
        .builder
        .ifSome(jsonConfiguration)(_.jsonConfiguration(_))
        .ifSome(parquetConfiguration)(_.parquetConfiguration(_))
        .build

    def filterActivity(
      name: Option[String] = None,
      filter: Option[String] = None,
      next: Option[String] = None
    ): FilterActivity =
      FilterActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(next)(_.next(_))
        .build

    def getDatasetContentRequest(
      datasetName: Option[String] = None,
      versionId: Option[String] = None
    ): GetDatasetContentRequest =
      GetDatasetContentRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def getDatasetContentResponse(
      entries: Option[List[DatasetEntry]] = None,
      timestamp: Option[Timestamp] = None,
      status: Option[DatasetContentStatus] = None
    ): GetDatasetContentResponse =
      GetDatasetContentResponse
        .builder
        .ifSome(entries)(_.entries(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(status)(_.status(_))
        .build

    def glueConfiguration(
      tableName: Option[String] = None,
      databaseName: Option[String] = None
    ): GlueConfiguration =
      GlueConfiguration
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(databaseName)(_.databaseName(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
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

    def iotEventsDestinationConfiguration(
      inputName: Option[String] = None,
      roleArn: Option[String] = None
    ): IotEventsDestinationConfiguration =
      IotEventsDestinationConfiguration
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def jsonConfiguration(

    ): JsonConfiguration =
      JsonConfiguration
        .builder

        .build

    def lambdaActivity(
      name: Option[String] = None,
      lambdaName: Option[String] = None,
      batchSize: Option[Int] = None,
      next: Option[String] = None
    ): LambdaActivity =
      LambdaActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(lambdaName)(_.lambdaName(_))
        .ifSome(batchSize)(_.batchSize(_))
        .ifSome(next)(_.next(_))
        .build

    def lateDataRule(
      ruleName: Option[String] = None,
      ruleConfiguration: Option[LateDataRuleConfiguration] = None
    ): LateDataRule =
      LateDataRule
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(ruleConfiguration)(_.ruleConfiguration(_))
        .build

    def lateDataRuleConfiguration(
      deltaTimeSessionWindowConfiguration: Option[DeltaTimeSessionWindowConfiguration] = None
    ): LateDataRuleConfiguration =
      LateDataRuleConfiguration
        .builder
        .ifSome(deltaTimeSessionWindowConfiguration)(_.deltaTimeSessionWindowConfiguration(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listChannelsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListChannelsRequest =
      ListChannelsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listChannelsResponse(
      channelSummaries: Option[List[ChannelSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelsResponse =
      ListChannelsResponse
        .builder
        .ifSome(channelSummaries)(_.channelSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetContentsRequest(
      datasetName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      scheduledOnOrAfter: Option[Timestamp] = None,
      scheduledBefore: Option[Timestamp] = None
    ): ListDatasetContentsRequest =
      ListDatasetContentsRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(scheduledOnOrAfter)(_.scheduledOnOrAfter(_))
        .ifSome(scheduledBefore)(_.scheduledBefore(_))
        .build

    def listDatasetContentsResponse(
      datasetContentSummaries: Option[List[DatasetContentSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetContentsResponse =
      ListDatasetContentsResponse
        .builder
        .ifSome(datasetContentSummaries)(_.datasetContentSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetsRequest =
      ListDatasetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetsResponse(
      datasetSummaries: Option[List[DatasetSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetsResponse =
      ListDatasetsResponse
        .builder
        .ifSome(datasetSummaries)(_.datasetSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatastoresRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatastoresRequest =
      ListDatastoresRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatastoresResponse(
      datastoreSummaries: Option[List[DatastoreSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatastoresResponse =
      ListDatastoresResponse
        .builder
        .ifSome(datastoreSummaries)(_.datastoreSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPipelinesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPipelinesRequest =
      ListPipelinesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPipelinesResponse(
      pipelineSummaries: Option[List[PipelineSummary]] = None,
      nextToken: Option[String] = None
    ): ListPipelinesResponse =
      ListPipelinesResponse
        .builder
        .ifSome(pipelineSummaries)(_.pipelineSummaries(_))
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
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def loggingOptions(
      roleArn: Option[String] = None,
      level: Option[String] = None,
      enabled: Option[Boolean] = None
    ): LoggingOptions =
      LoggingOptions
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(level)(_.level(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def mathActivity(
      name: Option[String] = None,
      attribute: Option[String] = None,
      math: Option[String] = None,
      next: Option[String] = None
    ): MathActivity =
      MathActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attribute)(_.attribute(_))
        .ifSome(math)(_.math(_))
        .ifSome(next)(_.next(_))
        .build

    def message(
      messageId: Option[String] = None,
      payload: Option[MessagePayload] = None
    ): Message =
      Message
        .builder
        .ifSome(messageId)(_.messageId(_))
        .ifSome(payload)(_.payload(_))
        .build

    def outputFileUriValue(
      fileName: Option[String] = None
    ): OutputFileUriValue =
      OutputFileUriValue
        .builder
        .ifSome(fileName)(_.fileName(_))
        .build

    def parquetConfiguration(
      schemaDefinition: Option[SchemaDefinition] = None
    ): ParquetConfiguration =
      ParquetConfiguration
        .builder
        .ifSome(schemaDefinition)(_.schemaDefinition(_))
        .build

    def partition(
      attributeName: Option[String] = None
    ): Partition =
      Partition
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .build

    def pipeline(
      name: Option[String] = None,
      arn: Option[String] = None,
      activities: Option[List[PipelineActivity]] = None,
      reprocessingSummaries: Option[List[ReprocessingSummary]] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): Pipeline =
      Pipeline
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(activities)(_.activities(_))
        .ifSome(reprocessingSummaries)(_.reprocessingSummaries(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def pipelineActivity(
      channel: Option[ChannelActivity] = None,
      lambda: Option[LambdaActivity] = None,
      datastore: Option[DatastoreActivity] = None,
      addAttributes: Option[AddAttributesActivity] = None,
      removeAttributes: Option[RemoveAttributesActivity] = None,
      selectAttributes: Option[SelectAttributesActivity] = None,
      filter: Option[FilterActivity] = None,
      math: Option[MathActivity] = None,
      deviceRegistryEnrich: Option[DeviceRegistryEnrichActivity] = None,
      deviceShadowEnrich: Option[DeviceShadowEnrichActivity] = None
    ): PipelineActivity =
      PipelineActivity
        .builder
        .ifSome(channel)(_.channel(_))
        .ifSome(lambda)(_.lambda(_))
        .ifSome(datastore)(_.datastore(_))
        .ifSome(addAttributes)(_.addAttributes(_))
        .ifSome(removeAttributes)(_.removeAttributes(_))
        .ifSome(selectAttributes)(_.selectAttributes(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(math)(_.math(_))
        .ifSome(deviceRegistryEnrich)(_.deviceRegistryEnrich(_))
        .ifSome(deviceShadowEnrich)(_.deviceShadowEnrich(_))
        .build

    def pipelineSummary(
      pipelineName: Option[String] = None,
      reprocessingSummaries: Option[List[ReprocessingSummary]] = None,
      creationTime: Option[Timestamp] = None,
      lastUpdateTime: Option[Timestamp] = None
    ): PipelineSummary =
      PipelineSummary
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(reprocessingSummaries)(_.reprocessingSummaries(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def putLoggingOptionsRequest(
      loggingOptions: Option[LoggingOptions] = None
    ): PutLoggingOptionsRequest =
      PutLoggingOptionsRequest
        .builder
        .ifSome(loggingOptions)(_.loggingOptions(_))
        .build

    def queryFilter(
      deltaTime: Option[DeltaTime] = None
    ): QueryFilter =
      QueryFilter
        .builder
        .ifSome(deltaTime)(_.deltaTime(_))
        .build

    def removeAttributesActivity(
      name: Option[String] = None,
      attributes: Option[List[AttributeName]] = None,
      next: Option[String] = None
    ): RemoveAttributesActivity =
      RemoveAttributesActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(next)(_.next(_))
        .build

    def reprocessingSummary(
      id: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None
    ): ReprocessingSummary =
      ReprocessingSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceArn: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def resourceConfiguration(
      computeType: Option[String] = None,
      volumeSizeInGB: Option[Int] = None
    ): ResourceConfiguration =
      ResourceConfiguration
        .builder
        .ifSome(computeType)(_.computeType(_))
        .ifSome(volumeSizeInGB)(_.volumeSizeInGB(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def retentionPeriod(
      unlimited: Option[Boolean] = None,
      numberOfDays: Option[Int] = None
    ): RetentionPeriod =
      RetentionPeriod
        .builder
        .ifSome(unlimited)(_.unlimited(_))
        .ifSome(numberOfDays)(_.numberOfDays(_))
        .build

    def runPipelineActivityRequest(
      pipelineActivity: Option[PipelineActivity] = None,
      payloads: Option[List[MessagePayload]] = None
    ): RunPipelineActivityRequest =
      RunPipelineActivityRequest
        .builder
        .ifSome(pipelineActivity)(_.pipelineActivity(_))
        .ifSome(payloads)(_.payloads(_))
        .build

    def runPipelineActivityResponse(
      payloads: Option[List[MessagePayload]] = None,
      logResult: Option[String] = None
    ): RunPipelineActivityResponse =
      RunPipelineActivityResponse
        .builder
        .ifSome(payloads)(_.payloads(_))
        .ifSome(logResult)(_.logResult(_))
        .build

    def s3DestinationConfiguration(
      bucket: Option[String] = None,
      key: Option[String] = None,
      glueConfiguration: Option[GlueConfiguration] = None,
      roleArn: Option[String] = None
    ): S3DestinationConfiguration =
      S3DestinationConfiguration
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(glueConfiguration)(_.glueConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def sampleChannelDataRequest(
      channelName: Option[String] = None,
      maxMessages: Option[Int] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None
    ): SampleChannelDataRequest =
      SampleChannelDataRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(maxMessages)(_.maxMessages(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def sampleChannelDataResponse(
      payloads: Option[List[MessagePayload]] = None
    ): SampleChannelDataResponse =
      SampleChannelDataResponse
        .builder
        .ifSome(payloads)(_.payloads(_))
        .build

    def schedule(
      expression: Option[String] = None
    ): Schedule =
      Schedule
        .builder
        .ifSome(expression)(_.expression(_))
        .build

    def schemaDefinition(
      columns: Option[List[Column]] = None
    ): SchemaDefinition =
      SchemaDefinition
        .builder
        .ifSome(columns)(_.columns(_))
        .build

    def selectAttributesActivity(
      name: Option[String] = None,
      attributes: Option[List[AttributeName]] = None,
      next: Option[String] = None
    ): SelectAttributesActivity =
      SelectAttributesActivity
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(next)(_.next(_))
        .build

    def serviceManagedChannelS3Storage(

    ): ServiceManagedChannelS3Storage =
      ServiceManagedChannelS3Storage
        .builder

        .build

    def serviceManagedChannelS3StorageSummary(

    ): ServiceManagedChannelS3StorageSummary =
      ServiceManagedChannelS3StorageSummary
        .builder

        .build

    def serviceManagedDatastoreS3Storage(

    ): ServiceManagedDatastoreS3Storage =
      ServiceManagedDatastoreS3Storage
        .builder

        .build

    def serviceManagedDatastoreS3StorageSummary(

    ): ServiceManagedDatastoreS3StorageSummary =
      ServiceManagedDatastoreS3StorageSummary
        .builder

        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sqlQueryDatasetAction(
      sqlQuery: Option[String] = None,
      filters: Option[List[QueryFilter]] = None
    ): SqlQueryDatasetAction =
      SqlQueryDatasetAction
        .builder
        .ifSome(sqlQuery)(_.sqlQuery(_))
        .ifSome(filters)(_.filters(_))
        .build

    def startPipelineReprocessingRequest(
      pipelineName: Option[String] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      channelMessages: Option[ChannelMessages] = None
    ): StartPipelineReprocessingRequest =
      StartPipelineReprocessingRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(channelMessages)(_.channelMessages(_))
        .build

    def startPipelineReprocessingResponse(
      reprocessingId: Option[String] = None
    ): StartPipelineReprocessingResponse =
      StartPipelineReprocessingResponse
        .builder
        .ifSome(reprocessingId)(_.reprocessingId(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timestampPartition(
      attributeName: Option[String] = None,
      timestampFormat: Option[String] = None
    ): TimestampPartition =
      TimestampPartition
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(timestampFormat)(_.timestampFormat(_))
        .build

    def triggeringDataset(
      name: Option[String] = None
    ): TriggeringDataset =
      TriggeringDataset
        .builder
        .ifSome(name)(_.name(_))
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

    def updateChannelRequest(
      channelName: Option[String] = None,
      channelStorage: Option[ChannelStorage] = None,
      retentionPeriod: Option[RetentionPeriod] = None
    ): UpdateChannelRequest =
      UpdateChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelStorage)(_.channelStorage(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .build

    def updateDatasetRequest(
      datasetName: Option[String] = None,
      actions: Option[List[DatasetAction]] = None,
      triggers: Option[List[DatasetTrigger]] = None,
      contentDeliveryRules: Option[List[DatasetContentDeliveryRule]] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      versioningConfiguration: Option[VersioningConfiguration] = None,
      lateDataRules: Option[List[LateDataRule]] = None
    ): UpdateDatasetRequest =
      UpdateDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(triggers)(_.triggers(_))
        .ifSome(contentDeliveryRules)(_.contentDeliveryRules(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(versioningConfiguration)(_.versioningConfiguration(_))
        .ifSome(lateDataRules)(_.lateDataRules(_))
        .build

    def updateDatastoreRequest(
      datastoreName: Option[String] = None,
      retentionPeriod: Option[RetentionPeriod] = None,
      datastoreStorage: Option[DatastoreStorage] = None,
      fileFormatConfiguration: Option[FileFormatConfiguration] = None
    ): UpdateDatastoreRequest =
      UpdateDatastoreRequest
        .builder
        .ifSome(datastoreName)(_.datastoreName(_))
        .ifSome(retentionPeriod)(_.retentionPeriod(_))
        .ifSome(datastoreStorage)(_.datastoreStorage(_))
        .ifSome(fileFormatConfiguration)(_.fileFormatConfiguration(_))
        .build

    def updatePipelineRequest(
      pipelineName: Option[String] = None,
      pipelineActivities: Option[List[PipelineActivity]] = None
    ): UpdatePipelineRequest =
      UpdatePipelineRequest
        .builder
        .ifSome(pipelineName)(_.pipelineName(_))
        .ifSome(pipelineActivities)(_.pipelineActivities(_))
        .build

    def variable(
      name: Option[String] = None,
      stringValue: Option[String] = None,
      doubleValue: Option[DoubleValue] = None,
      datasetContentVersionValue: Option[DatasetContentVersionValue] = None,
      outputFileUriValue: Option[OutputFileUriValue] = None
    ): Variable =
      Variable
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(datasetContentVersionValue)(_.datasetContentVersionValue(_))
        .ifSome(outputFileUriValue)(_.outputFileUriValue(_))
        .build

    def versioningConfiguration(
      unlimited: Option[Boolean] = None,
      maxVersions: Option[Int] = None
    ): VersioningConfiguration =
      VersioningConfiguration
        .builder
        .ifSome(unlimited)(_.unlimited(_))
        .ifSome(maxVersions)(_.maxVersions(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
