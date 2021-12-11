package goober.hi

import goober.free.kinesisvideoarchivedmedia.KinesisVideoArchivedMediaIO
import software.amazon.awssdk.services.kinesisvideoarchivedmedia.model._


object kinesisvideoarchivedmedia {
  import goober.free.{kinesisvideoarchivedmedia ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def clientLimitExceededException(
      message: Option[String] = None
    ): ClientLimitExceededException =
      ClientLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def clipFragmentSelector(
      fragmentSelectorType: Option[String] = None,
      timestampRange: Option[ClipTimestampRange] = None
    ): ClipFragmentSelector =
      ClipFragmentSelector
        .builder
        .ifSome(fragmentSelectorType)(_.fragmentSelectorType(_))
        .ifSome(timestampRange)(_.timestampRange(_))
        .build

    def clipTimestampRange(
      startTimestamp: Option[Timestamp] = None,
      endTimestamp: Option[Timestamp] = None
    ): ClipTimestampRange =
      ClipTimestampRange
        .builder
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(endTimestamp)(_.endTimestamp(_))
        .build

    def dASHFragmentSelector(
      fragmentSelectorType: Option[String] = None,
      timestampRange: Option[DASHTimestampRange] = None
    ): DASHFragmentSelector =
      DASHFragmentSelector
        .builder
        .ifSome(fragmentSelectorType)(_.fragmentSelectorType(_))
        .ifSome(timestampRange)(_.timestampRange(_))
        .build

    def dASHTimestampRange(
      startTimestamp: Option[Timestamp] = None,
      endTimestamp: Option[Timestamp] = None
    ): DASHTimestampRange =
      DASHTimestampRange
        .builder
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(endTimestamp)(_.endTimestamp(_))
        .build

    def fragment(
      fragmentNumber: Option[String] = None,
      fragmentSizeInBytes: Option[Long] = None,
      producerTimestamp: Option[Timestamp] = None,
      serverTimestamp: Option[Timestamp] = None,
      fragmentLengthInMilliseconds: Option[Long] = None
    ): Fragment =
      Fragment
        .builder
        .ifSome(fragmentNumber)(_.fragmentNumber(_))
        .ifSome(fragmentSizeInBytes)(_.fragmentSizeInBytes(_))
        .ifSome(producerTimestamp)(_.producerTimestamp(_))
        .ifSome(serverTimestamp)(_.serverTimestamp(_))
        .ifSome(fragmentLengthInMilliseconds)(_.fragmentLengthInMilliseconds(_))
        .build

    def fragmentSelector(
      fragmentSelectorType: Option[String] = None,
      timestampRange: Option[TimestampRange] = None
    ): FragmentSelector =
      FragmentSelector
        .builder
        .ifSome(fragmentSelectorType)(_.fragmentSelectorType(_))
        .ifSome(timestampRange)(_.timestampRange(_))
        .build

    def getClipInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      clipFragmentSelector: Option[ClipFragmentSelector] = None
    ): GetClipInput =
      GetClipInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(clipFragmentSelector)(_.clipFragmentSelector(_))
        .build

    def getClipOutput(
      contentType: Option[String] = None,
      payload: Option[Payload] = None
    ): GetClipOutput =
      GetClipOutput
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(payload)(_.payload(_))
        .build

    def getDASHStreamingSessionURLInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      playbackMode: Option[String] = None,
      displayFragmentTimestamp: Option[String] = None,
      displayFragmentNumber: Option[String] = None,
      dASHFragmentSelector: Option[DASHFragmentSelector] = None,
      expires: Option[Int] = None,
      maxManifestFragmentResults: Option[DASHMaxResults] = None
    ): GetDASHStreamingSessionURLInput =
      GetDASHStreamingSessionURLInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(displayFragmentTimestamp)(_.displayFragmentTimestamp(_))
        .ifSome(displayFragmentNumber)(_.displayFragmentNumber(_))
        .ifSome(dASHFragmentSelector)(_.dASHFragmentSelector(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(maxManifestFragmentResults)(_.maxManifestFragmentResults(_))
        .build

    def getDASHStreamingSessionURLOutput(
      dASHStreamingSessionURL: Option[String] = None
    ): GetDASHStreamingSessionURLOutput =
      GetDASHStreamingSessionURLOutput
        .builder
        .ifSome(dASHStreamingSessionURL)(_.dASHStreamingSessionURL(_))
        .build

    def getHLSStreamingSessionURLInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      playbackMode: Option[String] = None,
      hLSFragmentSelector: Option[HLSFragmentSelector] = None,
      containerFormat: Option[String] = None,
      discontinuityMode: Option[String] = None,
      displayFragmentTimestamp: Option[String] = None,
      expires: Option[Int] = None,
      maxMediaPlaylistFragmentResults: Option[HLSMaxResults] = None
    ): GetHLSStreamingSessionURLInput =
      GetHLSStreamingSessionURLInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(hLSFragmentSelector)(_.hLSFragmentSelector(_))
        .ifSome(containerFormat)(_.containerFormat(_))
        .ifSome(discontinuityMode)(_.discontinuityMode(_))
        .ifSome(displayFragmentTimestamp)(_.displayFragmentTimestamp(_))
        .ifSome(expires)(_.expires(_))
        .ifSome(maxMediaPlaylistFragmentResults)(_.maxMediaPlaylistFragmentResults(_))
        .build

    def getHLSStreamingSessionURLOutput(
      hLSStreamingSessionURL: Option[String] = None
    ): GetHLSStreamingSessionURLOutput =
      GetHLSStreamingSessionURLOutput
        .builder
        .ifSome(hLSStreamingSessionURL)(_.hLSStreamingSessionURL(_))
        .build

    def getMediaForFragmentListInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      fragments: Option[List[FragmentNumberString]] = None
    ): GetMediaForFragmentListInput =
      GetMediaForFragmentListInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(fragments)(_.fragments(_))
        .build

    def getMediaForFragmentListOutput(
      contentType: Option[String] = None,
      payload: Option[Payload] = None
    ): GetMediaForFragmentListOutput =
      GetMediaForFragmentListOutput
        .builder
        .ifSome(contentType)(_.contentType(_))
        .ifSome(payload)(_.payload(_))
        .build

    def hLSFragmentSelector(
      fragmentSelectorType: Option[String] = None,
      timestampRange: Option[HLSTimestampRange] = None
    ): HLSFragmentSelector =
      HLSFragmentSelector
        .builder
        .ifSome(fragmentSelectorType)(_.fragmentSelectorType(_))
        .ifSome(timestampRange)(_.timestampRange(_))
        .build

    def hLSTimestampRange(
      startTimestamp: Option[Timestamp] = None,
      endTimestamp: Option[Timestamp] = None
    ): HLSTimestampRange =
      HLSTimestampRange
        .builder
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(endTimestamp)(_.endTimestamp(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCodecPrivateDataException(
      message: Option[String] = None
    ): InvalidCodecPrivateDataException =
      InvalidCodecPrivateDataException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidMediaFrameException(
      message: Option[String] = None
    ): InvalidMediaFrameException =
      InvalidMediaFrameException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listFragmentsInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      maxResults: Option[ListFragmentsMaxResults] = None,
      nextToken: Option[String] = None,
      fragmentSelector: Option[FragmentSelector] = None
    ): ListFragmentsInput =
      ListFragmentsInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(fragmentSelector)(_.fragmentSelector(_))
        .build

    def listFragmentsOutput(
      fragments: Option[List[Fragment]] = None,
      nextToken: Option[String] = None
    ): ListFragmentsOutput =
      ListFragmentsOutput
        .builder
        .ifSome(fragments)(_.fragments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def missingCodecPrivateDataException(
      message: Option[String] = None
    ): MissingCodecPrivateDataException =
      MissingCodecPrivateDataException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def noDataRetentionException(
      message: Option[String] = None
    ): NoDataRetentionException =
      NoDataRetentionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
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

    def timestampRange(
      startTimestamp: Option[Timestamp] = None,
      endTimestamp: Option[Timestamp] = None
    ): TimestampRange =
      TimestampRange
        .builder
        .ifSome(startTimestamp)(_.startTimestamp(_))
        .ifSome(endTimestamp)(_.endTimestamp(_))
        .build

    def unsupportedStreamMediaTypeException(
      message: Option[String] = None
    ): UnsupportedStreamMediaTypeException =
      UnsupportedStreamMediaTypeException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
