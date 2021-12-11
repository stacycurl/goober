package goober.hi

import goober.free.qldb.QldbIO
import software.amazon.awssdk.services.qldb.model._


object qldb {
  import goober.free.{qldb ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def cancelJournalKinesisStreamRequest(
      ledgerName: Option[String] = None,
      streamId: Option[String] = None
    ): CancelJournalKinesisStreamRequest =
      CancelJournalKinesisStreamRequest
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .ifSome(streamId)(_.streamId(_))
        .build

    def cancelJournalKinesisStreamResponse(
      streamId: Option[String] = None
    ): CancelJournalKinesisStreamResponse =
      CancelJournalKinesisStreamResponse
        .builder
        .ifSome(streamId)(_.streamId(_))
        .build

    def createLedgerRequest(
      name: Option[String] = None,
      tags: Option[Tags] = None,
      permissionsMode: Option[String] = None,
      deletionProtection: Option[Boolean] = None
    ): CreateLedgerRequest =
      CreateLedgerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(permissionsMode)(_.permissionsMode(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def createLedgerResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      state: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      permissionsMode: Option[String] = None,
      deletionProtection: Option[Boolean] = None
    ): CreateLedgerResponse =
      CreateLedgerResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(permissionsMode)(_.permissionsMode(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def deleteLedgerRequest(
      name: Option[String] = None
    ): DeleteLedgerRequest =
      DeleteLedgerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeJournalKinesisStreamRequest(
      ledgerName: Option[String] = None,
      streamId: Option[String] = None
    ): DescribeJournalKinesisStreamRequest =
      DescribeJournalKinesisStreamRequest
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .ifSome(streamId)(_.streamId(_))
        .build

    def describeJournalKinesisStreamResponse(
      stream: Option[JournalKinesisStreamDescription] = None
    ): DescribeJournalKinesisStreamResponse =
      DescribeJournalKinesisStreamResponse
        .builder
        .ifSome(stream)(_.stream(_))
        .build

    def describeJournalS3ExportRequest(
      name: Option[String] = None,
      exportId: Option[String] = None
    ): DescribeJournalS3ExportRequest =
      DescribeJournalS3ExportRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(exportId)(_.exportId(_))
        .build

    def describeJournalS3ExportResponse(
      exportDescription: Option[JournalS3ExportDescription] = None
    ): DescribeJournalS3ExportResponse =
      DescribeJournalS3ExportResponse
        .builder
        .ifSome(exportDescription)(_.exportDescription(_))
        .build

    def describeLedgerRequest(
      name: Option[String] = None
    ): DescribeLedgerRequest =
      DescribeLedgerRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeLedgerResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      state: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      permissionsMode: Option[String] = None,
      deletionProtection: Option[Boolean] = None
    ): DescribeLedgerResponse =
      DescribeLedgerResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(permissionsMode)(_.permissionsMode(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def exportJournalToS3Request(
      name: Option[String] = None,
      inclusiveStartTime: Option[Timestamp] = None,
      exclusiveEndTime: Option[Timestamp] = None,
      s3ExportConfiguration: Option[S3ExportConfiguration] = None,
      roleArn: Option[String] = None
    ): ExportJournalToS3Request =
      ExportJournalToS3Request
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(inclusiveStartTime)(_.inclusiveStartTime(_))
        .ifSome(exclusiveEndTime)(_.exclusiveEndTime(_))
        .ifSome(s3ExportConfiguration)(_.s3ExportConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def exportJournalToS3Response(
      exportId: Option[String] = None
    ): ExportJournalToS3Response =
      ExportJournalToS3Response
        .builder
        .ifSome(exportId)(_.exportId(_))
        .build

    def getBlockRequest(
      name: Option[String] = None,
      blockAddress: Option[ValueHolder] = None,
      digestTipAddress: Option[ValueHolder] = None
    ): GetBlockRequest =
      GetBlockRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(blockAddress)(_.blockAddress(_))
        .ifSome(digestTipAddress)(_.digestTipAddress(_))
        .build

    def getBlockResponse(
      block: Option[ValueHolder] = None,
      proof: Option[ValueHolder] = None
    ): GetBlockResponse =
      GetBlockResponse
        .builder
        .ifSome(block)(_.block(_))
        .ifSome(proof)(_.proof(_))
        .build

    def getDigestRequest(
      name: Option[String] = None
    ): GetDigestRequest =
      GetDigestRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getDigestResponse(
      digest: Option[Digest] = None,
      digestTipAddress: Option[ValueHolder] = None
    ): GetDigestResponse =
      GetDigestResponse
        .builder
        .ifSome(digest)(_.digest(_))
        .ifSome(digestTipAddress)(_.digestTipAddress(_))
        .build

    def getRevisionRequest(
      name: Option[String] = None,
      blockAddress: Option[ValueHolder] = None,
      documentId: Option[String] = None,
      digestTipAddress: Option[ValueHolder] = None
    ): GetRevisionRequest =
      GetRevisionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(blockAddress)(_.blockAddress(_))
        .ifSome(documentId)(_.documentId(_))
        .ifSome(digestTipAddress)(_.digestTipAddress(_))
        .build

    def getRevisionResponse(
      proof: Option[ValueHolder] = None,
      revision: Option[ValueHolder] = None
    ): GetRevisionResponse =
      GetRevisionResponse
        .builder
        .ifSome(proof)(_.proof(_))
        .ifSome(revision)(_.revision(_))
        .build

    def invalidParameterException(
      message: Option[String] = None,
      parameterName: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(parameterName)(_.parameterName(_))
        .build

    def journalKinesisStreamDescription(
      ledgerName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      inclusiveStartTime: Option[Timestamp] = None,
      exclusiveEndTime: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      streamId: Option[String] = None,
      arn: Option[String] = None,
      status: Option[String] = None,
      kinesisConfiguration: Option[KinesisConfiguration] = None,
      errorCause: Option[String] = None,
      streamName: Option[String] = None
    ): JournalKinesisStreamDescription =
      JournalKinesisStreamDescription
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(inclusiveStartTime)(_.inclusiveStartTime(_))
        .ifSome(exclusiveEndTime)(_.exclusiveEndTime(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(kinesisConfiguration)(_.kinesisConfiguration(_))
        .ifSome(errorCause)(_.errorCause(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def journalS3ExportDescription(
      ledgerName: Option[String] = None,
      exportId: Option[String] = None,
      exportCreationTime: Option[Timestamp] = None,
      status: Option[String] = None,
      inclusiveStartTime: Option[Timestamp] = None,
      exclusiveEndTime: Option[Timestamp] = None,
      s3ExportConfiguration: Option[S3ExportConfiguration] = None,
      roleArn: Option[String] = None
    ): JournalS3ExportDescription =
      JournalS3ExportDescription
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .ifSome(exportId)(_.exportId(_))
        .ifSome(exportCreationTime)(_.exportCreationTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(inclusiveStartTime)(_.inclusiveStartTime(_))
        .ifSome(exclusiveEndTime)(_.exclusiveEndTime(_))
        .ifSome(s3ExportConfiguration)(_.s3ExportConfiguration(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def kinesisConfiguration(
      streamArn: Option[String] = None,
      aggregationEnabled: Option[Boolean] = None
    ): KinesisConfiguration =
      KinesisConfiguration
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(aggregationEnabled)(_.aggregationEnabled(_))
        .build

    def ledgerSummary(
      name: Option[String] = None,
      state: Option[String] = None,
      creationDateTime: Option[Timestamp] = None
    ): LedgerSummary =
      LedgerSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .build

    def limitExceededException(
      message: Option[String] = None,
      resourceType: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def listJournalKinesisStreamsForLedgerRequest(
      ledgerName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJournalKinesisStreamsForLedgerRequest =
      ListJournalKinesisStreamsForLedgerRequest
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJournalKinesisStreamsForLedgerResponse(
      streams: Option[List[JournalKinesisStreamDescription]] = None,
      nextToken: Option[String] = None
    ): ListJournalKinesisStreamsForLedgerResponse =
      ListJournalKinesisStreamsForLedgerResponse
        .builder
        .ifSome(streams)(_.streams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJournalS3ExportsForLedgerRequest(
      name: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJournalS3ExportsForLedgerRequest =
      ListJournalS3ExportsForLedgerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJournalS3ExportsForLedgerResponse(
      journalS3Exports: Option[List[JournalS3ExportDescription]] = None,
      nextToken: Option[String] = None
    ): ListJournalS3ExportsForLedgerResponse =
      ListJournalS3ExportsForLedgerResponse
        .builder
        .ifSome(journalS3Exports)(_.journalS3Exports(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJournalS3ExportsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJournalS3ExportsRequest =
      ListJournalS3ExportsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJournalS3ExportsResponse(
      journalS3Exports: Option[List[JournalS3ExportDescription]] = None,
      nextToken: Option[String] = None
    ): ListJournalS3ExportsResponse =
      ListJournalS3ExportsResponse
        .builder
        .ifSome(journalS3Exports)(_.journalS3Exports(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLedgersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListLedgersRequest =
      ListLedgersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLedgersResponse(
      ledgers: Option[List[LedgerSummary]] = None,
      nextToken: Option[String] = None
    ): ListLedgersResponse =
      ListLedgersResponse
        .builder
        .ifSome(ledgers)(_.ledgers(_))
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
      tags: Option[Tags] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resourceInUseException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def resourcePreconditionNotMetException(
      message: Option[String] = None,
      resourceType: Option[String] = None,
      resourceName: Option[String] = None
    ): ResourcePreconditionNotMetException =
      ResourcePreconditionNotMetException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def s3EncryptionConfiguration(
      objectEncryptionType: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): S3EncryptionConfiguration =
      S3EncryptionConfiguration
        .builder
        .ifSome(objectEncryptionType)(_.objectEncryptionType(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def s3ExportConfiguration(
      bucket: Option[String] = None,
      prefix: Option[String] = None,
      encryptionConfiguration: Option[S3EncryptionConfiguration] = None
    ): S3ExportConfiguration =
      S3ExportConfiguration
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .build

    def streamJournalToKinesisRequest(
      ledgerName: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[Tags] = None,
      inclusiveStartTime: Option[Timestamp] = None,
      exclusiveEndTime: Option[Timestamp] = None,
      kinesisConfiguration: Option[KinesisConfiguration] = None,
      streamName: Option[String] = None
    ): StreamJournalToKinesisRequest =
      StreamJournalToKinesisRequest
        .builder
        .ifSome(ledgerName)(_.ledgerName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(inclusiveStartTime)(_.inclusiveStartTime(_))
        .ifSome(exclusiveEndTime)(_.exclusiveEndTime(_))
        .ifSome(kinesisConfiguration)(_.kinesisConfiguration(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def streamJournalToKinesisResponse(
      streamId: Option[String] = None
    ): StreamJournalToKinesisResponse =
      StreamJournalToKinesisResponse
        .builder
        .ifSome(streamId)(_.streamId(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
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

    def updateLedgerPermissionsModeRequest(
      name: Option[String] = None,
      permissionsMode: Option[String] = None
    ): UpdateLedgerPermissionsModeRequest =
      UpdateLedgerPermissionsModeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(permissionsMode)(_.permissionsMode(_))
        .build

    def updateLedgerPermissionsModeResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      permissionsMode: Option[String] = None
    ): UpdateLedgerPermissionsModeResponse =
      UpdateLedgerPermissionsModeResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(permissionsMode)(_.permissionsMode(_))
        .build

    def updateLedgerRequest(
      name: Option[String] = None,
      deletionProtection: Option[Boolean] = None
    ): UpdateLedgerRequest =
      UpdateLedgerRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def updateLedgerResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      state: Option[String] = None,
      creationDateTime: Option[Timestamp] = None,
      deletionProtection: Option[Boolean] = None
    ): UpdateLedgerResponse =
      UpdateLedgerResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(state)(_.state(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(deletionProtection)(_.deletionProtection(_))
        .build

    def valueHolder(
      ionText: Option[String] = None
    ): ValueHolder =
      ValueHolder
        .builder
        .ifSome(ionText)(_.ionText(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
