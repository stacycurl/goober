package goober.hi

import goober.free.dynamodbstreams.DynamoDbStreamsIO
import software.amazon.awssdk.services.dynamodb.model._


object dynamodbstreams {
  import goober.free.{dynamodbstreams ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def attributeValue(
      s: Option[String] = None,
      n: Option[String] = None,
      b: Option[BinaryAttributeValue] = None,
      sS: Option[List[StringAttributeValue]] = None,
      nS: Option[List[NumberAttributeValue]] = None,
      bS: Option[List[BinaryAttributeValue]] = None,
      m: Option[MapAttributeValue] = None,
      l: Option[List[AttributeValue]] = None,
      nULL: Option[Boolean] = None,
      bOOL: Option[Boolean] = None
    ): AttributeValue =
      AttributeValue
        .builder
        .ifSome(s)(_.s(_))
        .ifSome(n)(_.n(_))
        .ifSome(b)(_.b(_))
        .ifSome(sS)(_.sS(_))
        .ifSome(nS)(_.nS(_))
        .ifSome(bS)(_.bS(_))
        .ifSome(m)(_.m(_))
        .ifSome(l)(_.l(_))
        .ifSome(nULL)(_.nULL(_))
        .ifSome(bOOL)(_.bOOL(_))
        .build

    def describeStreamInput(
      streamArn: Option[String] = None,
      limit: Option[Int] = None,
      exclusiveStartShardId: Option[String] = None
    ): DescribeStreamInput =
      DescribeStreamInput
        .builder
        .ifSome(streamArn)(_.streamArn(_))
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

    def expiredIteratorException(
      message: Option[String] = None
    ): ExpiredIteratorException =
      ExpiredIteratorException
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
      nextShardIterator: Option[String] = None
    ): GetRecordsOutput =
      GetRecordsOutput
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(nextShardIterator)(_.nextShardIterator(_))
        .build

    def getShardIteratorInput(
      streamArn: Option[String] = None,
      shardId: Option[String] = None,
      shardIteratorType: Option[String] = None,
      sequenceNumber: Option[String] = None
    ): GetShardIteratorInput =
      GetShardIteratorInput
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(shardId)(_.shardId(_))
        .ifSome(shardIteratorType)(_.shardIteratorType(_))
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .build

    def getShardIteratorOutput(
      shardIterator: Option[String] = None
    ): GetShardIteratorOutput =
      GetShardIteratorOutput
        .builder
        .ifSome(shardIterator)(_.shardIterator(_))
        .build

    def identity(
      principalId: Option[String] = None,
      `type`: Option[String] = None
    ): Identity =
      Identity
        .builder
        .ifSome(principalId)(_.principalId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keySchemaElement(
      attributeName: Option[String] = None,
      keyType: Option[String] = None
    ): KeySchemaElement =
      KeySchemaElement
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listStreamsInput(
      tableName: Option[String] = None,
      limit: Option[Int] = None,
      exclusiveStartStreamArn: Option[String] = None
    ): ListStreamsInput =
      ListStreamsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(exclusiveStartStreamArn)(_.exclusiveStartStreamArn(_))
        .build

    def listStreamsOutput(
      streams: Option[List[Stream]] = None,
      lastEvaluatedStreamArn: Option[String] = None
    ): ListStreamsOutput =
      ListStreamsOutput
        .builder
        .ifSome(streams)(_.streams(_))
        .ifSome(lastEvaluatedStreamArn)(_.lastEvaluatedStreamArn(_))
        .build

    def record(
      eventID: Option[String] = None,
      eventName: Option[String] = None,
      eventVersion: Option[String] = None,
      eventSource: Option[String] = None,
      awsRegion: Option[String] = None,
      dynamodb: Option[StreamRecord] = None,
      userIdentity: Option[Identity] = None
    ): Record =
      Record
        .builder
        .ifSome(eventID)(_.eventID(_))
        .ifSome(eventName)(_.eventName(_))
        .ifSome(eventVersion)(_.eventVersion(_))
        .ifSome(eventSource)(_.eventSource(_))
        .ifSome(awsRegion)(_.awsRegion(_))
        .ifSome(dynamodb)(_.dynamodb(_))
        .ifSome(userIdentity)(_.userIdentity(_))
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
      sequenceNumberRange: Option[SequenceNumberRange] = None,
      parentShardId: Option[String] = None
    ): Shard =
      Shard
        .builder
        .ifSome(shardId)(_.shardId(_))
        .ifSome(sequenceNumberRange)(_.sequenceNumberRange(_))
        .ifSome(parentShardId)(_.parentShardId(_))
        .build

    def stream(
      streamArn: Option[String] = None,
      tableName: Option[String] = None,
      streamLabel: Option[String] = None
    ): Stream =
      Stream
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(streamLabel)(_.streamLabel(_))
        .build

    def streamDescription(
      streamArn: Option[String] = None,
      streamLabel: Option[String] = None,
      streamStatus: Option[String] = None,
      streamViewType: Option[String] = None,
      creationRequestDateTime: Option[Date] = None,
      tableName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      shards: Option[List[Shard]] = None,
      lastEvaluatedShardId: Option[String] = None
    ): StreamDescription =
      StreamDescription
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(streamLabel)(_.streamLabel(_))
        .ifSome(streamStatus)(_.streamStatus(_))
        .ifSome(streamViewType)(_.streamViewType(_))
        .ifSome(creationRequestDateTime)(_.creationRequestDateTime(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(shards)(_.shards(_))
        .ifSome(lastEvaluatedShardId)(_.lastEvaluatedShardId(_))
        .build

    def streamRecord(
      approximateCreationDateTime: Option[Date] = None,
      keys: Option[AttributeMap] = None,
      newImage: Option[AttributeMap] = None,
      oldImage: Option[AttributeMap] = None,
      sequenceNumber: Option[String] = None,
      sizeBytes: Option[PositiveLongObject] = None,
      streamViewType: Option[String] = None
    ): StreamRecord =
      StreamRecord
        .builder
        .ifSome(approximateCreationDateTime)(_.approximateCreationDateTime(_))
        .ifSome(keys)(_.keys(_))
        .ifSome(newImage)(_.newImage(_))
        .ifSome(oldImage)(_.oldImage(_))
        .ifSome(sequenceNumber)(_.sequenceNumber(_))
        .ifSome(sizeBytes)(_.sizeBytes(_))
        .ifSome(streamViewType)(_.streamViewType(_))
        .build

    def trimmedDataAccessException(
      message: Option[String] = None
    ): TrimmedDataAccessException =
      TrimmedDataAccessException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
