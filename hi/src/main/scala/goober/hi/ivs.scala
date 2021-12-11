package goober.hi

import goober.free.ivs.IvsIO
import software.amazon.awssdk.services.ivs.model._


object ivs {
  import goober.free.{ivs ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      exceptionMessage: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def batchError(
      arn: Option[String] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): BatchError =
      BatchError
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def batchGetChannelRequest(
      arns: Option[List[ChannelArn]] = None
    ): BatchGetChannelRequest =
      BatchGetChannelRequest
        .builder
        .ifSome(arns)(_.arns(_))
        .build

    def batchGetChannelResponse(
      channels: Option[List[Channel]] = None,
      errors: Option[List[BatchError]] = None
    ): BatchGetChannelResponse =
      BatchGetChannelResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(errors)(_.errors(_))
        .build

    def batchGetStreamKeyRequest(
      arns: Option[List[StreamKeyArn]] = None
    ): BatchGetStreamKeyRequest =
      BatchGetStreamKeyRequest
        .builder
        .ifSome(arns)(_.arns(_))
        .build

    def batchGetStreamKeyResponse(
      streamKeys: Option[List[StreamKey]] = None,
      errors: Option[List[BatchError]] = None
    ): BatchGetStreamKeyResponse =
      BatchGetStreamKeyResponse
        .builder
        .ifSome(streamKeys)(_.streamKeys(_))
        .ifSome(errors)(_.errors(_))
        .build

    def channel(
      arn: Option[String] = None,
      name: Option[String] = None,
      latencyMode: Option[String] = None,
      `type`: Option[String] = None,
      recordingConfigurationArn: Option[String] = None,
      ingestEndpoint: Option[String] = None,
      playbackUrl: Option[String] = None,
      authorized: Option[Boolean] = None,
      tags: Option[Tags] = None
    ): Channel =
      Channel
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(latencyMode)(_.latencyMode(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(recordingConfigurationArn)(_.recordingConfigurationArn(_))
        .ifSome(ingestEndpoint)(_.ingestEndpoint(_))
        .ifSome(playbackUrl)(_.playbackUrl(_))
        .ifSome(authorized)(_.authorized(_))
        .ifSome(tags)(_.tags(_))
        .build

    def channelNotBroadcasting(
      exceptionMessage: Option[String] = None
    ): ChannelNotBroadcasting =
      ChannelNotBroadcasting
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def channelSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      latencyMode: Option[String] = None,
      authorized: Option[Boolean] = None,
      recordingConfigurationArn: Option[String] = None,
      tags: Option[Tags] = None
    ): ChannelSummary =
      ChannelSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(latencyMode)(_.latencyMode(_))
        .ifSome(authorized)(_.authorized(_))
        .ifSome(recordingConfigurationArn)(_.recordingConfigurationArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def conflictException(
      exceptionMessage: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def createChannelRequest(
      name: Option[String] = None,
      latencyMode: Option[String] = None,
      `type`: Option[String] = None,
      authorized: Option[Boolean] = None,
      recordingConfigurationArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateChannelRequest =
      CreateChannelRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(latencyMode)(_.latencyMode(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(authorized)(_.authorized(_))
        .ifSome(recordingConfigurationArn)(_.recordingConfigurationArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChannelResponse(
      channel: Option[Channel] = None,
      streamKey: Option[StreamKey] = None
    ): CreateChannelResponse =
      CreateChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .ifSome(streamKey)(_.streamKey(_))
        .build

    def createRecordingConfigurationRequest(
      name: Option[String] = None,
      destinationConfiguration: Option[DestinationConfiguration] = None,
      tags: Option[Tags] = None
    ): CreateRecordingConfigurationRequest =
      CreateRecordingConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(destinationConfiguration)(_.destinationConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRecordingConfigurationResponse(
      recordingConfiguration: Option[RecordingConfiguration] = None
    ): CreateRecordingConfigurationResponse =
      CreateRecordingConfigurationResponse
        .builder
        .ifSome(recordingConfiguration)(_.recordingConfiguration(_))
        .build

    def createStreamKeyRequest(
      channelArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateStreamKeyRequest =
      CreateStreamKeyRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamKeyResponse(
      streamKey: Option[StreamKey] = None
    ): CreateStreamKeyResponse =
      CreateStreamKeyResponse
        .builder
        .ifSome(streamKey)(_.streamKey(_))
        .build

    def deleteChannelRequest(
      arn: Option[String] = None
    ): DeleteChannelRequest =
      DeleteChannelRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deletePlaybackKeyPairRequest(
      arn: Option[String] = None
    ): DeletePlaybackKeyPairRequest =
      DeletePlaybackKeyPairRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deletePlaybackKeyPairResponse(

    ): DeletePlaybackKeyPairResponse =
      DeletePlaybackKeyPairResponse
        .builder

        .build

    def deleteRecordingConfigurationRequest(
      arn: Option[String] = None
    ): DeleteRecordingConfigurationRequest =
      DeleteRecordingConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteStreamKeyRequest(
      arn: Option[String] = None
    ): DeleteStreamKeyRequest =
      DeleteStreamKeyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def destinationConfiguration(
      s3: Option[S3DestinationConfiguration] = None
    ): DestinationConfiguration =
      DestinationConfiguration
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def getChannelRequest(
      arn: Option[String] = None
    ): GetChannelRequest =
      GetChannelRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getChannelResponse(
      channel: Option[Channel] = None
    ): GetChannelResponse =
      GetChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def getPlaybackKeyPairRequest(
      arn: Option[String] = None
    ): GetPlaybackKeyPairRequest =
      GetPlaybackKeyPairRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getPlaybackKeyPairResponse(
      keyPair: Option[PlaybackKeyPair] = None
    ): GetPlaybackKeyPairResponse =
      GetPlaybackKeyPairResponse
        .builder
        .ifSome(keyPair)(_.keyPair(_))
        .build

    def getRecordingConfigurationRequest(
      arn: Option[String] = None
    ): GetRecordingConfigurationRequest =
      GetRecordingConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getRecordingConfigurationResponse(
      recordingConfiguration: Option[RecordingConfiguration] = None
    ): GetRecordingConfigurationResponse =
      GetRecordingConfigurationResponse
        .builder
        .ifSome(recordingConfiguration)(_.recordingConfiguration(_))
        .build

    def getStreamKeyRequest(
      arn: Option[String] = None
    ): GetStreamKeyRequest =
      GetStreamKeyRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getStreamKeyResponse(
      streamKey: Option[StreamKey] = None
    ): GetStreamKeyResponse =
      GetStreamKeyResponse
        .builder
        .ifSome(streamKey)(_.streamKey(_))
        .build

    def getStreamRequest(
      channelArn: Option[String] = None
    ): GetStreamRequest =
      GetStreamRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .build

    def getStreamResponse(
      stream: Option[Stream] = None
    ): GetStreamResponse =
      GetStreamResponse
        .builder
        .ifSome(stream)(_.stream(_))
        .build

    def importPlaybackKeyPairRequest(
      publicKeyMaterial: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): ImportPlaybackKeyPairRequest =
      ImportPlaybackKeyPairRequest
        .builder
        .ifSome(publicKeyMaterial)(_.publicKeyMaterial(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def importPlaybackKeyPairResponse(
      keyPair: Option[PlaybackKeyPair] = None
    ): ImportPlaybackKeyPairResponse =
      ImportPlaybackKeyPairResponse
        .builder
        .ifSome(keyPair)(_.keyPair(_))
        .build

    def internalServerException(
      exceptionMessage: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def listChannelsRequest(
      filterByName: Option[String] = None,
      filterByRecordingConfigurationArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListChannelsRequest =
      ListChannelsRequest
        .builder
        .ifSome(filterByName)(_.filterByName(_))
        .ifSome(filterByRecordingConfigurationArn)(_.filterByRecordingConfigurationArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listChannelsResponse(
      channels: Option[List[ChannelSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelsResponse =
      ListChannelsResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlaybackKeyPairsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPlaybackKeyPairsRequest =
      ListPlaybackKeyPairsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPlaybackKeyPairsResponse(
      keyPairs: Option[List[PlaybackKeyPairSummary]] = None,
      nextToken: Option[String] = None
    ): ListPlaybackKeyPairsResponse =
      ListPlaybackKeyPairsResponse
        .builder
        .ifSome(keyPairs)(_.keyPairs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecordingConfigurationsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRecordingConfigurationsRequest =
      ListRecordingConfigurationsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRecordingConfigurationsResponse(
      recordingConfigurations: Option[List[RecordingConfigurationSummary]] = None,
      nextToken: Option[String] = None
    ): ListRecordingConfigurationsResponse =
      ListRecordingConfigurationsResponse
        .builder
        .ifSome(recordingConfigurations)(_.recordingConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamKeysRequest(
      channelArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListStreamKeysRequest =
      ListStreamKeysRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listStreamKeysResponse(
      streamKeys: Option[List[StreamKeySummary]] = None,
      nextToken: Option[String] = None
    ): ListStreamKeysResponse =
      ListStreamKeysResponse
        .builder
        .ifSome(streamKeys)(_.streamKeys(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListStreamsRequest =
      ListStreamsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listStreamsResponse(
      streams: Option[List[StreamSummary]] = None,
      nextToken: Option[String] = None
    ): ListStreamsResponse =
      ListStreamsResponse
        .builder
        .ifSome(streams)(_.streams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[Tags] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def pendingVerification(
      exceptionMessage: Option[String] = None
    ): PendingVerification =
      PendingVerification
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def playbackKeyPair(
      arn: Option[String] = None,
      name: Option[String] = None,
      fingerprint: Option[String] = None,
      tags: Option[Tags] = None
    ): PlaybackKeyPair =
      PlaybackKeyPair
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(fingerprint)(_.fingerprint(_))
        .ifSome(tags)(_.tags(_))
        .build

    def playbackKeyPairSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): PlaybackKeyPairSummary =
      PlaybackKeyPairSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def putMetadataRequest(
      channelArn: Option[String] = None,
      metadata: Option[String] = None
    ): PutMetadataRequest =
      PutMetadataRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def recordingConfiguration(
      arn: Option[String] = None,
      name: Option[String] = None,
      destinationConfiguration: Option[DestinationConfiguration] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): RecordingConfiguration =
      RecordingConfiguration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(destinationConfiguration)(_.destinationConfiguration(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def recordingConfigurationSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      destinationConfiguration: Option[DestinationConfiguration] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): RecordingConfigurationSummary =
      RecordingConfigurationSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(destinationConfiguration)(_.destinationConfiguration(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceNotFoundException(
      exceptionMessage: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def s3DestinationConfiguration(
      bucketName: Option[String] = None
    ): S3DestinationConfiguration =
      S3DestinationConfiguration
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .build

    def serviceQuotaExceededException(
      exceptionMessage: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

    def stopStreamRequest(
      channelArn: Option[String] = None
    ): StopStreamRequest =
      StopStreamRequest
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .build

    def stopStreamResponse(

    ): StopStreamResponse =
      StopStreamResponse
        .builder

        .build

    def stream(
      channelArn: Option[String] = None,
      playbackUrl: Option[String] = None,
      startTime: Option[StreamStartTime] = None,
      state: Option[String] = None,
      health: Option[String] = None,
      viewerCount: Option[StreamViewerCount] = None
    ): Stream =
      Stream
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(playbackUrl)(_.playbackUrl(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(state)(_.state(_))
        .ifSome(health)(_.health(_))
        .ifSome(viewerCount)(_.viewerCount(_))
        .build

    def streamKey(
      arn: Option[String] = None,
      value: Option[String] = None,
      channelArn: Option[String] = None,
      tags: Option[Tags] = None
    ): StreamKey =
      StreamKey
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(value)(_.value(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def streamKeySummary(
      arn: Option[String] = None,
      channelArn: Option[String] = None,
      tags: Option[Tags] = None
    ): StreamKeySummary =
      StreamKeySummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def streamSummary(
      channelArn: Option[String] = None,
      state: Option[String] = None,
      health: Option[String] = None,
      viewerCount: Option[StreamViewerCount] = None,
      startTime: Option[StreamStartTime] = None
    ): StreamSummary =
      StreamSummary
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(health)(_.health(_))
        .ifSome(viewerCount)(_.viewerCount(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def streamUnavailable(
      exceptionMessage: Option[String] = None
    ): StreamUnavailable =
      StreamUnavailable
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
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

    def throttlingException(
      exceptionMessage: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
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
      arn: Option[String] = None,
      name: Option[String] = None,
      latencyMode: Option[String] = None,
      `type`: Option[String] = None,
      authorized: Option[Boolean] = None,
      recordingConfigurationArn: Option[String] = None
    ): UpdateChannelRequest =
      UpdateChannelRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(latencyMode)(_.latencyMode(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(authorized)(_.authorized(_))
        .ifSome(recordingConfigurationArn)(_.recordingConfigurationArn(_))
        .build

    def updateChannelResponse(
      channel: Option[Channel] = None
    ): UpdateChannelResponse =
      UpdateChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def validationException(
      exceptionMessage: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(exceptionMessage)(_.exceptionMessage(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
