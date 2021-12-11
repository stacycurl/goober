package goober.hi

import goober.free.ebs.EbsIO
import software.amazon.awssdk.services.ebs.model._


object ebs {
  import goober.free.{ebs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def block(
      blockIndex: Option[Int] = None,
      blockToken: Option[String] = None
    ): Block =
      Block
        .builder
        .ifSome(blockIndex)(_.blockIndex(_))
        .ifSome(blockToken)(_.blockToken(_))
        .build

    def changedBlock(
      blockIndex: Option[Int] = None,
      firstBlockToken: Option[String] = None,
      secondBlockToken: Option[String] = None
    ): ChangedBlock =
      ChangedBlock
        .builder
        .ifSome(blockIndex)(_.blockIndex(_))
        .ifSome(firstBlockToken)(_.firstBlockToken(_))
        .ifSome(secondBlockToken)(_.secondBlockToken(_))
        .build

    def completeSnapshotRequest(
      snapshotId: Option[String] = None,
      changedBlocksCount: Option[Int] = None,
      checksum: Option[String] = None,
      checksumAlgorithm: Option[String] = None,
      checksumAggregationMethod: Option[String] = None
    ): CompleteSnapshotRequest =
      CompleteSnapshotRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(changedBlocksCount)(_.changedBlocksCount(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(checksumAlgorithm)(_.checksumAlgorithm(_))
        .ifSome(checksumAggregationMethod)(_.checksumAggregationMethod(_))
        .build

    def completeSnapshotResponse(
      status: Option[String] = None
    ): CompleteSnapshotResponse =
      CompleteSnapshotResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def concurrentLimitExceededException(
      message: Option[String] = None
    ): ConcurrentLimitExceededException =
      ConcurrentLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getSnapshotBlockRequest(
      snapshotId: Option[String] = None,
      blockIndex: Option[Int] = None,
      blockToken: Option[String] = None
    ): GetSnapshotBlockRequest =
      GetSnapshotBlockRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(blockIndex)(_.blockIndex(_))
        .ifSome(blockToken)(_.blockToken(_))
        .build

    def getSnapshotBlockResponse(
      dataLength: Option[Int] = None,
      blockData: Option[BlockData] = None,
      checksum: Option[String] = None,
      checksumAlgorithm: Option[String] = None
    ): GetSnapshotBlockResponse =
      GetSnapshotBlockResponse
        .builder
        .ifSome(dataLength)(_.dataLength(_))
        .ifSome(blockData)(_.blockData(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(checksumAlgorithm)(_.checksumAlgorithm(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listChangedBlocksRequest(
      firstSnapshotId: Option[String] = None,
      secondSnapshotId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      startingBlockIndex: Option[Int] = None
    ): ListChangedBlocksRequest =
      ListChangedBlocksRequest
        .builder
        .ifSome(firstSnapshotId)(_.firstSnapshotId(_))
        .ifSome(secondSnapshotId)(_.secondSnapshotId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(startingBlockIndex)(_.startingBlockIndex(_))
        .build

    def listChangedBlocksResponse(
      changedBlocks: Option[List[ChangedBlock]] = None,
      expiryTime: Option[TimeStamp] = None,
      volumeSize: Option[VolumeSize] = None,
      blockSize: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListChangedBlocksResponse =
      ListChangedBlocksResponse
        .builder
        .ifSome(changedBlocks)(_.changedBlocks(_))
        .ifSome(expiryTime)(_.expiryTime(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(blockSize)(_.blockSize(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSnapshotBlocksRequest(
      snapshotId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      startingBlockIndex: Option[Int] = None
    ): ListSnapshotBlocksRequest =
      ListSnapshotBlocksRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(startingBlockIndex)(_.startingBlockIndex(_))
        .build

    def listSnapshotBlocksResponse(
      blocks: Option[List[Block]] = None,
      expiryTime: Option[TimeStamp] = None,
      volumeSize: Option[VolumeSize] = None,
      blockSize: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSnapshotBlocksResponse =
      ListSnapshotBlocksResponse
        .builder
        .ifSome(blocks)(_.blocks(_))
        .ifSome(expiryTime)(_.expiryTime(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(blockSize)(_.blockSize(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def putSnapshotBlockRequest(
      snapshotId: Option[String] = None,
      blockIndex: Option[Int] = None,
      blockData: Option[BlockData] = None,
      dataLength: Option[Int] = None,
      progress: Option[Int] = None,
      checksum: Option[String] = None,
      checksumAlgorithm: Option[String] = None
    ): PutSnapshotBlockRequest =
      PutSnapshotBlockRequest
        .builder
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(blockIndex)(_.blockIndex(_))
        .ifSome(blockData)(_.blockData(_))
        .ifSome(dataLength)(_.dataLength(_))
        .ifSome(progress)(_.progress(_))
        .ifSome(checksum)(_.checksum(_))
        .ifSome(checksumAlgorithm)(_.checksumAlgorithm(_))
        .build

    def putSnapshotBlockResponse(
      checksum: Option[String] = None,
      checksumAlgorithm: Option[String] = None
    ): PutSnapshotBlockResponse =
      PutSnapshotBlockResponse
        .builder
        .ifSome(checksum)(_.checksum(_))
        .ifSome(checksumAlgorithm)(_.checksumAlgorithm(_))
        .build

    def requestThrottledException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): RequestThrottledException =
      RequestThrottledException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

    def startSnapshotRequest(
      volumeSize: Option[VolumeSize] = None,
      parentSnapshotId: Option[String] = None,
      tags: Option[List[Tag]] = None,
      description: Option[String] = None,
      clientToken: Option[String] = None,
      encrypted: Option[Boolean] = None,
      kmsKeyArn: Option[String] = None,
      timeout: Option[Int] = None
    ): StartSnapshotRequest =
      StartSnapshotRequest
        .builder
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(parentSnapshotId)(_.parentSnapshotId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def startSnapshotResponse(
      description: Option[String] = None,
      snapshotId: Option[String] = None,
      ownerId: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[TimeStamp] = None,
      volumeSize: Option[VolumeSize] = None,
      blockSize: Option[Int] = None,
      tags: Option[List[Tag]] = None,
      parentSnapshotId: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): StartSnapshotResponse =
      StartSnapshotResponse
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(blockSize)(_.blockSize(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(parentSnapshotId)(_.parentSnapshotId(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
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

    def validationException(
      message: Option[String] = None,
      reason: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(reason)(_.reason(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
