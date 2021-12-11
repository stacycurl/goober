package goober.hi

import goober.free.kinesis.KinesisIO
import software.amazon.awssdk.services.kinesis.model._


object kinesis {
  import goober.free.{kinesis ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addTagsToStreamInput(
      streamName: Option[String] = None,
      tags: Option[TagMap] = None
    ): AddTagsToStreamInput =
      AddTagsToStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def childShard(
      shardId: Option[String] = None,
      parentShards: Option[List[ShardId]] = None,
      hashKeyRange: Option[HashKeyRange] = None
    ): ChildShard =
      ChildShard
        .builder
        .ifSome(shardId)(_.shardId(_))
        .ifSome(parentShards)(_.parentShards(_))
        .ifSome(hashKeyRange)(_.hashKeyRange(_))
        .build

    def consumer(
      consumerName: Option[String] = None,
      consumerARN: Option[String] = None,
      consumerStatus: Option[String] = None,
      consumerCreationTimestamp: Option[Timestamp] = None
    ): Consumer =
      Consumer
        .builder
        .ifSome(consumerName)(_.consumerName(_))
        .ifSome(consumerARN)(_.consumerARN(_))
        .ifSome(consumerStatus)(_.consumerStatus(_))
        .ifSome(consumerCreationTimestamp)(_.consumerCreationTimestamp(_))
        .build

    def consumerDescription(
      consumerName: Option[String] = None,
      consumerARN: Option[String] = None,
      consumerStatus: Option[String] = None,
      consumerCreationTimestamp: Option[Timestamp] = None,
      streamARN: Option[String] = None
    ): ConsumerDescription =
      ConsumerDescription
        .builder
        .ifSome(consumerName)(_.consumerName(_))
        .ifSome(consumerARN)(_.consumerARN(_))
        .ifSome(consumerStatus)(_.consumerStatus(_))
        .ifSome(consumerCreationTimestamp)(_.consumerCreationTimestamp(_))
        .ifSome(streamARN)(_.streamARN(_))
        .build

    def createStreamInput(
      streamName: Option[String] = None,
      shardCount: Option[Int] = None
    ): CreateStreamInput =
      CreateStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(shardCount)(_.shardCount(_))
        .build

    def decreaseStreamRetentionPeriodInput(
      streamName: Option[String] = None,
      retentionPeriodHours: Option[Int] = None
    ): DecreaseStreamRetentionPeriodInput =
      DecreaseStreamRetentionPeriodInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(retentionPeriodHours)(_.retentionPeriodHours(_))
        .build

    def deleteStreamInput(
      streamName: Option[String] = None,
      enforceConsumerDeletion: Option[Boolean] = None
    ): DeleteStreamInput =
      DeleteStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(enforceConsumerDeletion)(_.enforceConsumerDeletion(_))
        .build

    def deregisterStreamConsumerInput(
      streamARN: Option[String] = None,
      consumerName: Option[String] = None,
      consumerARN: Option[String] = None
    ): DeregisterStreamConsumerInput =
      DeregisterStreamConsumerInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(consumerName)(_.consumerName(_))
        .ifSome(consumerARN)(_.consumerARN(_))
        .build

    def describeLimitsInput(

    ): DescribeLimitsInput =
      DescribeLimitsInput
        .builder

        .build

    def describeLimitsOutput(
      shardLimit: Option[Int] = None,
      openShardCount: Option[Int] = None
    ): DescribeLimitsOutput =
      DescribeLimitsOutput
        .builder
        .ifSome(shardLimit)(_.shardLimit(_))
        .ifSome(openShardCount)(_.openShardCount(_))
        .build

    def describeStreamConsumerInput(
      streamARN: Option[String] = None,
      consumerName: Option[String] = None,
      consumerARN: Option[String] = None
    ): DescribeStreamConsumerInput =
      DescribeStreamConsumerInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(consumerName)(_.consumerName(_))
        .ifSome(consumerARN)(_.consumerARN(_))
        .build

    def describeStreamConsumerOutput(
      consumerDescription: Option[ConsumerDescription] = None
    ): DescribeStreamConsumerOutput =
      DescribeStreamConsumerOutput
        .builder
        .ifSome(consumerDescription)(_.consumerDescription(_))
        .build

    def describeStreamInput(
      streamName: Option[String] = None,
      limit: Option[Int] = None,
      exclusiveStartShardId: Option[String] = None
    ): DescribeStreamInput =
      DescribeStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(exclusiveStartShardId)(_.exclusiveStartShardId(_))
        .build

    def describeStreamOutput(
      streamDescription: Option[StreamDescription] = None
    ): DescribeStreamOutput =
      DescribeStreamOutput
        .builder
        .ifSome(streamDescription)(_.streamDescription(_))
        .build

    def describeStreamSummaryInput(
      streamName: Option[String] = None
    ): DescribeStreamSummaryInput =
      DescribeStreamSummaryInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .build

    def describeStreamSummaryOutput(
      streamDescriptionSummary: Option[StreamDescriptionSummary] = None
    ): DescribeStreamSummaryOutput =
      DescribeStreamSummaryOutput
        .builder
        .ifSome(streamDescriptionSummary)(_.streamDescriptionSummary(_))
        .build

    def disableEnhancedMonitoringInput(
      streamName: Option[String] = None,
      shardLevelMetrics: Option[List[MetricsName]] = None
    ): DisableEnhancedMonitoringInput =
      DisableEnhancedMonitoringInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(shardLevelMetrics)(_.shardLevelMetrics(_))
        .build

    def enableEnhancedMonitoringInput(
      streamName: Option[String] = None,
      shardLevelMetrics: Option[List[MetricsName]] = None
    ): EnableEnhancedMonitoringInput =
      EnableEnhancedMonitoringInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(shardLevelMetrics)(_.shardLevelMetrics(_))
        .build

    def enhancedMetrics(
      shardLevelMetrics: Option[List[MetricsName]] = None
    ): EnhancedMetrics =
      EnhancedMetrics
        .builder
        .ifSome(shardLevelMetrics)(_.shardLevelMetrics(_))
        .build

    def enhancedMonitoringOutput(
      streamName: Option[String] = None,
      currentShardLevelMetrics: Option[List[MetricsName]] = None,
      desiredShardLevelMetrics: Option[List[MetricsName]] = None
    ): EnhancedMonitoringOutput =
      EnhancedMonitoringOutput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(currentShardLevelMetrics)(_.currentShardLevelMetrics(_))
        .ifSome(desiredShardLevelMetrics)(_.desiredShardLevelMetrics(_))
        .build

    def expiredIteratorException(
      message: Option[String] = None
    ): ExpiredIteratorException =
      ExpiredIteratorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def expiredNextTokenException(
      message: Option[String] = None
    ): ExpiredNextTokenException =
      ExpiredNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getRecordsInput(
      shardIterator: Option[String] = None,
      limit: Option[Int] = None
    ): GetRecordsInput =
      GetRecordsInput
        .builder
        .ifSome(shardIterator)(_.shardIterator(_))
        .ifSome(limit)(_.limit(_))
        .build

    def getRecordsOutput(
      records: Option[List[Record]] = None,
      nextShardIterator: Option[String] = None,
      millisBehindLatest: Option[MillisBehindLatest] = None,
      childShards: Option[List[ChildShard]] = None
    ): GetRecordsOutput =
      GetRecordsOutput
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(nextShardIterator)(_.nextShardIterator(_))
        .ifSome(millisBehindLatest)(_.millisBehindLatest(_))
        .ifSome(childShards)(_.childShards(_))
        .build

    def getShardIteratorInput(
      streamName: Option[String] = None,
      shardId: Option[String] = None,
      shardIteratorType: Option[String] = None,
      startingSequenceNumber: Option[String] = None,
      timestamp: Option[Timestamp] = None
    ): GetShardIteratorInput =
      GetShardIteratorInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(shardId)(_.shardId(_))
        .ifSome(shardIteratorType)(_.shardIteratorType(_))
        .ifSome(startingSequenceNumber)(_.startingSequenceNumber(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def getShardIteratorOutput(
      shardIterator: Option[String] = None
    ): GetShardIteratorOutput =
      GetShardIteratorOutput
        .builder
        .ifSome(shardIterator)(_.shardIterator(_))
        .build

    def hashKeyRange(
      startingHashKey: Option[String] = None,
      endingHashKey: Option[String] = None
    ): HashKeyRange =
      HashKeyRange
        .builder
        .ifSome(startingHashKey)(_.startingHashKey(_))
        .ifSome(endingHashKey)(_.endingHashKey(_))
        .build

    def increaseStreamRetentionPeriodInput(
      streamName: Option[String] = None,
      retentionPeriodHours: Option[Int] = None
    ): IncreaseStreamRetentionPeriodInput =
      IncreaseStreamRetentionPeriodInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(retentionPeriodHours)(_.retentionPeriodHours(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSAccessDeniedException(
      message: Option[String] = None
    ): KMSAccessDeniedException =
      KMSAccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSDisabledException(
      message: Option[String] = None
    ): KMSDisabledException =
      KMSDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSInvalidStateException(
      message: Option[String] = None
    ): KMSInvalidStateException =
      KMSInvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSNotFoundException(
      message: Option[String] = None
    ): KMSNotFoundException =
      KMSNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSOptInRequired(
      message: Option[String] = None
    ): KMSOptInRequired =
      KMSOptInRequired
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSThrottlingException(
      message: Option[String] = None
    ): KMSThrottlingException =
      KMSThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listShardsInput(
      streamName: Option[String] = None,
      nextToken: Option[String] = None,
      exclusiveStartShardId: Option[String] = None,
      maxResults: Option[Int] = None,
      streamCreationTimestamp: Option[Timestamp] = None,
      shardFilter: Option[ShardFilter] = None
    ): ListShardsInput =
      ListShardsInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(exclusiveStartShardId)(_.exclusiveStartShardId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(streamCreationTimestamp)(_.streamCreationTimestamp(_))
        .ifSome(shardFilter)(_.shardFilter(_))
        .build

    def listShardsOutput(
      shards: Option[List[Shard]] = None,
      nextToken: Option[String] = None
    ): ListShardsOutput =
      ListShardsOutput
        .builder
        .ifSome(shards)(_.shards(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamConsumersInput(
      streamARN: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      streamCreationTimestamp: Option[Timestamp] = None
    ): ListStreamConsumersInput =
      ListStreamConsumersInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(streamCreationTimestamp)(_.streamCreationTimestamp(_))
        .build

    def listStreamConsumersOutput(
      consumers: Option[List[Consumer]] = None,
      nextToken: Option[String] = None
    ): ListStreamConsumersOutput =
      ListStreamConsumersOutput
        .builder
        .ifSome(consumers)(_.consumers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamsInput(
      limit: Option[Int] = None,
      exclusiveStartStreamName: Option[String] = None
    ): ListStreamsInput =
      ListStreamsInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(exclusiveStartStreamName)(_.exclusiveStartStreamName(_))
        .build

    def listStreamsOutput(
      streamNames: Option[List[StreamName]] = None,
      hasMoreStreams: Option[Boolean] = None
    ): ListStreamsOutput =
      ListStreamsOutput
        .builder
        .ifSome(streamNames)(_.streamNames(_))
        .ifSome(hasMoreStreams)(_.hasMoreStreams(_))
        .build

    def listTagsForStreamInput(
      streamName: Option[String] = None,
      exclusiveStartTagKey: Option[String] = None,
      limit: Option[Int] = None
    ): ListTagsForStreamInput =
      ListTagsForStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(exclusiveStartTagKey)(_.exclusiveStartTagKey(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTagsForStreamOutput(
      tags: Option[List[Tag]] = None,
      hasMoreTags: Option[Boolean] = None
    ): ListTagsForStreamOutput =
      ListTagsForStreamOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(hasMoreTags)(_.hasMoreTags(_))
        .build

    def mergeShardsInput(
      streamName: Option[String] = None,
      shardToMerge: Option[String] = None,
      adjacentShardToMerge: Option[String] = None
    ): MergeShardsInput =
      MergeShardsInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(shardToMerge)(_.shardToMerge(_))
        .ifSome(adjacentShardToMerge)(_.adjacentShardToMerge(_))
        .build

    def provisionedThroughputExceededException(
      message: Option[String] = None
    ): ProvisionedThroughputExceededException =
      ProvisionedThroughputExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putRecordInput(
      streamName: Option[String] = None,
      data: Option[Data] = None,
      partitionKey: Option[String] = None,
      explicitHashKey: Option[String] = None,
      sequenceNumberForOrdering: Option[String] = None
    ): PutRecordInput =
      PutRecordInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(data)(_.data(_))
        .ifSome(partitionKey)(_.partitionKey(_))
        .ifSome(explicitHashKey)(_.explicitHashKey(_))
        .ifSome(sequenceNumberForOrdering)(_.sequenceNumberForOrdering(_))
        .build

    def putRecordOutput(
      shardId: Option[String] = None,
      sequenceNumber: Option[String] = None,
      encryptionType: Option[String] = None
    ): PutRecordOutput =
      PutRecordOutput
        .builder
        .ifSome(shardId)(_.shardId(_))
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .build

    def putRecordsInput(
      records: Option[List[PutRecordsRequestEntry]] = None,
      streamName: Option[String] = None
    ): PutRecordsInput =
      PutRecordsInput
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def putRecordsOutput(
      failedRecordCount: Option[Int] = None,
      records: Option[List[PutRecordsResultEntry]] = None,
      encryptionType: Option[String] = None
    ): PutRecordsOutput =
      PutRecordsOutput
        .builder
        .ifSome(failedRecordCount)(_.failedRecordCount(_))
        .ifSome(records)(_.records(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .build

    def putRecordsRequestEntry(
      data: Option[Data] = None,
      explicitHashKey: Option[String] = None,
      partitionKey: Option[String] = None
    ): PutRecordsRequestEntry =
      PutRecordsRequestEntry
        .builder
        .ifSome(data)(_.data(_))
        .ifSome(explicitHashKey)(_.explicitHashKey(_))
        .ifSome(partitionKey)(_.partitionKey(_))
        .build

    def putRecordsResultEntry(
      sequenceNumber: Option[String] = None,
      shardId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PutRecordsResultEntry =
      PutRecordsResultEntry
        .builder
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .ifSome(shardId)(_.shardId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def record(
      sequenceNumber: Option[String] = None,
      approximateArrivalTimestamp: Option[Timestamp] = None,
      data: Option[Data] = None,
      partitionKey: Option[String] = None,
      encryptionType: Option[String] = None
    ): Record =
      Record
        .builder
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .ifSome(approximateArrivalTimestamp)(_.approximateArrivalTimestamp(_))
        .ifSome(data)(_.data(_))
        .ifSome(partitionKey)(_.partitionKey(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .build

    def registerStreamConsumerInput(
      streamARN: Option[String] = None,
      consumerName: Option[String] = None
    ): RegisterStreamConsumerInput =
      RegisterStreamConsumerInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(consumerName)(_.consumerName(_))
        .build

    def registerStreamConsumerOutput(
      consumer: Option[Consumer] = None
    ): RegisterStreamConsumerOutput =
      RegisterStreamConsumerOutput
        .builder
        .ifSome(consumer)(_.consumer(_))
        .build

    def removeTagsFromStreamInput(
      streamName: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): RemoveTagsFromStreamInput =
      RemoveTagsFromStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sequenceNumberRange(
      startingSequenceNumber: Option[String] = None,
      endingSequenceNumber: Option[String] = None
    ): SequenceNumberRange =
      SequenceNumberRange
        .builder
        .ifSome(startingSequenceNumber)(_.startingSequenceNumber(_))
        .ifSome(endingSequenceNumber)(_.endingSequenceNumber(_))
        .build

    def shard(
      shardId: Option[String] = None,
      parentShardId: Option[String] = None,
      adjacentParentShardId: Option[String] = None,
      hashKeyRange: Option[HashKeyRange] = None,
      sequenceNumberRange: Option[SequenceNumberRange] = None
    ): Shard =
      Shard
        .builder
        .ifSome(shardId)(_.shardId(_))
        .ifSome(parentShardId)(_.parentShardId(_))
        .ifSome(adjacentParentShardId)(_.adjacentParentShardId(_))
        .ifSome(hashKeyRange)(_.hashKeyRange(_))
        .ifSome(sequenceNumberRange)(_.sequenceNumberRange(_))
        .build

    def shardFilter(
      `type`: Option[String] = None,
      shardId: Option[String] = None,
      timestamp: Option[Timestamp] = None
    ): ShardFilter =
      ShardFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(shardId)(_.shardId(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def splitShardInput(
      streamName: Option[String] = None,
      shardToSplit: Option[String] = None,
      newStartingHashKey: Option[String] = None
    ): SplitShardInput =
      SplitShardInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(shardToSplit)(_.shardToSplit(_))
        .ifSome(newStartingHashKey)(_.newStartingHashKey(_))
        .build

    def startStreamEncryptionInput(
      streamName: Option[String] = None,
      encryptionType: Option[String] = None,
      keyId: Option[String] = None
    ): StartStreamEncryptionInput =
      StartStreamEncryptionInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def startingPosition(
      `type`: Option[String] = None,
      sequenceNumber: Option[String] = None,
      timestamp: Option[Timestamp] = None
    ): StartingPosition =
      StartingPosition
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def stopStreamEncryptionInput(
      streamName: Option[String] = None,
      encryptionType: Option[String] = None,
      keyId: Option[String] = None
    ): StopStreamEncryptionInput =
      StopStreamEncryptionInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def streamDescription(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      streamStatus: Option[String] = None,
      shards: Option[List[Shard]] = None,
      hasMoreShards: Option[Boolean] = None,
      retentionPeriodHours: Option[Int] = None,
      streamCreationTimestamp: Option[Timestamp] = None,
      enhancedMonitoring: Option[List[EnhancedMetrics]] = None,
      encryptionType: Option[String] = None,
      keyId: Option[String] = None
    ): StreamDescription =
      StreamDescription
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(streamStatus)(_.streamStatus(_))
        .ifSome(shards)(_.shards(_))
        .ifSome(hasMoreShards)(_.hasMoreShards(_))
        .ifSome(retentionPeriodHours)(_.retentionPeriodHours(_))
        .ifSome(streamCreationTimestamp)(_.streamCreationTimestamp(_))
        .ifSome(enhancedMonitoring)(_.enhancedMonitoring(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def streamDescriptionSummary(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      streamStatus: Option[String] = None,
      retentionPeriodHours: Option[Int] = None,
      streamCreationTimestamp: Option[Timestamp] = None,
      enhancedMonitoring: Option[List[EnhancedMetrics]] = None,
      encryptionType: Option[String] = None,
      keyId: Option[String] = None,
      openShardCount: Option[Int] = None,
      consumerCount: Option[Int] = None
    ): StreamDescriptionSummary =
      StreamDescriptionSummary
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(streamStatus)(_.streamStatus(_))
        .ifSome(retentionPeriodHours)(_.retentionPeriodHours(_))
        .ifSome(streamCreationTimestamp)(_.streamCreationTimestamp(_))
        .ifSome(enhancedMonitoring)(_.enhancedMonitoring(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(openShardCount)(_.openShardCount(_))
        .ifSome(consumerCount)(_.consumerCount(_))
        .build

    def subscribeToShardEvent(
      records: Option[List[Record]] = None,
      continuationSequenceNumber: Option[String] = None,
      millisBehindLatest: Option[MillisBehindLatest] = None,
      childShards: Option[List[ChildShard]] = None
    ): SubscribeToShardEvent =
      SubscribeToShardEvent
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(continuationSequenceNumber)(_.continuationSequenceNumber(_))
        .ifSome(millisBehindLatest)(_.millisBehindLatest(_))
        .ifSome(childShards)(_.childShards(_))
        .build

    def subscribeToShardEventStream(
      subscribeToShardEvent: Option[SubscribeToShardEvent] = None,
      resourceNotFoundException: Option[ResourceNotFoundException] = None,
      resourceInUseException: Option[ResourceInUseException] = None,
      kMSDisabledException: Option[KMSDisabledException] = None,
      kMSInvalidStateException: Option[KMSInvalidStateException] = None,
      kMSAccessDeniedException: Option[KMSAccessDeniedException] = None,
      kMSNotFoundException: Option[KMSNotFoundException] = None,
      kMSOptInRequired: Option[KMSOptInRequired] = None,
      kMSThrottlingException: Option[KMSThrottlingException] = None,
      internalFailureException: Option[InternalFailureException] = None
    ): SubscribeToShardEventStream =
      SubscribeToShardEventStream
        .builder
        .ifSome(subscribeToShardEvent)(_.subscribeToShardEvent(_))
        .ifSome(resourceNotFoundException)(_.resourceNotFoundException(_))
        .ifSome(resourceInUseException)(_.resourceInUseException(_))
        .ifSome(kMSDisabledException)(_.kMSDisabledException(_))
        .ifSome(kMSInvalidStateException)(_.kMSInvalidStateException(_))
        .ifSome(kMSAccessDeniedException)(_.kMSAccessDeniedException(_))
        .ifSome(kMSNotFoundException)(_.kMSNotFoundException(_))
        .ifSome(kMSOptInRequired)(_.kMSOptInRequired(_))
        .ifSome(kMSThrottlingException)(_.kMSThrottlingException(_))
        .ifSome(internalFailureException)(_.internalFailureException(_))
        .build

    def subscribeToShardInput(
      consumerARN: Option[String] = None,
      shardId: Option[String] = None,
      startingPosition: Option[StartingPosition] = None
    ): SubscribeToShardInput =
      SubscribeToShardInput
        .builder
        .ifSome(consumerARN)(_.consumerARN(_))
        .ifSome(shardId)(_.shardId(_))
        .ifSome(startingPosition)(_.startingPosition(_))
        .build

    def subscribeToShardOutput(
      eventStream: Option[SubscribeToShardEventStream] = None
    ): SubscribeToShardOutput =
      SubscribeToShardOutput
        .builder
        .ifSome(eventStream)(_.eventStream(_))
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

    def updateShardCountInput(
      streamName: Option[String] = None,
      targetShardCount: Option[Int] = None,
      scalingType: Option[String] = None
    ): UpdateShardCountInput =
      UpdateShardCountInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(targetShardCount)(_.targetShardCount(_))
        .ifSome(scalingType)(_.scalingType(_))
        .build

    def updateShardCountOutput(
      streamName: Option[String] = None,
      currentShardCount: Option[Int] = None,
      targetShardCount: Option[Int] = None
    ): UpdateShardCountOutput =
      UpdateShardCountOutput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(currentShardCount)(_.currentShardCount(_))
        .ifSome(targetShardCount)(_.targetShardCount(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
