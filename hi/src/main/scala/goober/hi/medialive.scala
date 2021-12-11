package goober.hi

import goober.free.medialive.MediaLiveIO
import software.amazon.awssdk.services.medialive.model._


object medialive {
  import goober.free.{medialive ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aacSettings(
      bitrate: Option[__double] = None,
      codingMode: Option[String] = None,
      inputType: Option[String] = None,
      profile: Option[String] = None,
      rateControlMode: Option[String] = None,
      rawFormat: Option[String] = None,
      sampleRate: Option[__double] = None,
      spec: Option[String] = None,
      vbrQuality: Option[String] = None
    ): AacSettings =
      AacSettings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(inputType)(_.inputType(_))
        .ifSome(profile)(_.profile(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(rawFormat)(_.rawFormat(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(vbrQuality)(_.vbrQuality(_))
        .build

    def ac3Settings(
      bitrate: Option[__double] = None,
      bitstreamMode: Option[String] = None,
      codingMode: Option[String] = None,
      dialnorm: Option[Int] = None,
      drcProfile: Option[String] = None,
      lfeFilter: Option[String] = None,
      metadataControl: Option[String] = None
    ): Ac3Settings =
      Ac3Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bitstreamMode)(_.bitstreamMode(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(dialnorm)(_.dialnorm(_))
        .ifSome(drcProfile)(_.drcProfile(_))
        .ifSome(lfeFilter)(_.lfeFilter(_))
        .ifSome(metadataControl)(_.metadataControl(_))
        .build

    def acceptInputDeviceTransferRequest(
      inputDeviceId: Option[String] = None
    ): AcceptInputDeviceTransferRequest =
      AcceptInputDeviceTransferRequest
        .builder
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .build

    def acceptInputDeviceTransferResponse(

    ): AcceptInputDeviceTransferResponse =
      AcceptInputDeviceTransferResponse
        .builder

        .build

    def accessDenied(
      message: Option[String] = None
    ): AccessDenied =
      AccessDenied
        .builder
        .ifSome(message)(_.message(_))
        .build

    def ancillarySourceSettings(
      sourceAncillaryChannelNumber: Option[Int] = None
    ): AncillarySourceSettings =
      AncillarySourceSettings
        .builder
        .ifSome(sourceAncillaryChannelNumber)(_.sourceAncillaryChannelNumber(_))
        .build

    def archiveCdnSettings(
      archiveS3Settings: Option[ArchiveS3Settings] = None
    ): ArchiveCdnSettings =
      ArchiveCdnSettings
        .builder
        .ifSome(archiveS3Settings)(_.archiveS3Settings(_))
        .build

    def archiveContainerSettings(
      m2tsSettings: Option[M2tsSettings] = None,
      rawSettings: Option[RawSettings] = None
    ): ArchiveContainerSettings =
      ArchiveContainerSettings
        .builder
        .ifSome(m2tsSettings)(_.m2tsSettings(_))
        .ifSome(rawSettings)(_.rawSettings(_))
        .build

    def archiveGroupSettings(
      archiveCdnSettings: Option[ArchiveCdnSettings] = None,
      destination: Option[OutputLocationRef] = None,
      rolloverInterval: Option[Int] = None
    ): ArchiveGroupSettings =
      ArchiveGroupSettings
        .builder
        .ifSome(archiveCdnSettings)(_.archiveCdnSettings(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(rolloverInterval)(_.rolloverInterval(_))
        .build

    def archiveOutputSettings(
      containerSettings: Option[ArchiveContainerSettings] = None,
      extension: Option[String] = None,
      nameModifier: Option[String] = None
    ): ArchiveOutputSettings =
      ArchiveOutputSettings
        .builder
        .ifSome(containerSettings)(_.containerSettings(_))
        .ifSome(extension)(_.extension(_))
        .ifSome(nameModifier)(_.nameModifier(_))
        .build

    def archiveS3Settings(
      cannedAcl: Option[String] = None
    ): ArchiveS3Settings =
      ArchiveS3Settings
        .builder
        .ifSome(cannedAcl)(_.cannedAcl(_))
        .build

    def aribDestinationSettings(

    ): AribDestinationSettings =
      AribDestinationSettings
        .builder

        .build

    def aribSourceSettings(

    ): AribSourceSettings =
      AribSourceSettings
        .builder

        .build

    def audioChannelMapping(
      inputChannelLevels: Option[List[InputChannelLevel]] = None,
      outputChannel: Option[Int] = None
    ): AudioChannelMapping =
      AudioChannelMapping
        .builder
        .ifSome(inputChannelLevels)(_.inputChannelLevels(_))
        .ifSome(outputChannel)(_.outputChannel(_))
        .build

    def audioCodecSettings(
      aacSettings: Option[AacSettings] = None,
      ac3Settings: Option[Ac3Settings] = None,
      eac3Settings: Option[Eac3Settings] = None,
      mp2Settings: Option[Mp2Settings] = None,
      passThroughSettings: Option[PassThroughSettings] = None,
      wavSettings: Option[WavSettings] = None
    ): AudioCodecSettings =
      AudioCodecSettings
        .builder
        .ifSome(aacSettings)(_.aacSettings(_))
        .ifSome(ac3Settings)(_.ac3Settings(_))
        .ifSome(eac3Settings)(_.eac3Settings(_))
        .ifSome(mp2Settings)(_.mp2Settings(_))
        .ifSome(passThroughSettings)(_.passThroughSettings(_))
        .ifSome(wavSettings)(_.wavSettings(_))
        .build

    def audioDescription(
      audioNormalizationSettings: Option[AudioNormalizationSettings] = None,
      audioSelectorName: Option[String] = None,
      audioType: Option[String] = None,
      audioTypeControl: Option[String] = None,
      codecSettings: Option[AudioCodecSettings] = None,
      languageCode: Option[String] = None,
      languageCodeControl: Option[String] = None,
      name: Option[String] = None,
      remixSettings: Option[RemixSettings] = None,
      streamName: Option[String] = None
    ): AudioDescription =
      AudioDescription
        .builder
        .ifSome(audioNormalizationSettings)(_.audioNormalizationSettings(_))
        .ifSome(audioSelectorName)(_.audioSelectorName(_))
        .ifSome(audioType)(_.audioType(_))
        .ifSome(audioTypeControl)(_.audioTypeControl(_))
        .ifSome(codecSettings)(_.codecSettings(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageCodeControl)(_.languageCodeControl(_))
        .ifSome(name)(_.name(_))
        .ifSome(remixSettings)(_.remixSettings(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def audioLanguageSelection(
      languageCode: Option[String] = None,
      languageSelectionPolicy: Option[String] = None
    ): AudioLanguageSelection =
      AudioLanguageSelection
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageSelectionPolicy)(_.languageSelectionPolicy(_))
        .build

    def audioNormalizationSettings(
      algorithm: Option[String] = None,
      algorithmControl: Option[String] = None,
      targetLkfs: Option[__doubleMinNegative59Max0] = None
    ): AudioNormalizationSettings =
      AudioNormalizationSettings
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(algorithmControl)(_.algorithmControl(_))
        .ifSome(targetLkfs)(_.targetLkfs(_))
        .build

    def audioOnlyHlsSettings(
      audioGroupId: Option[String] = None,
      audioOnlyImage: Option[InputLocation] = None,
      audioTrackType: Option[String] = None,
      segmentType: Option[String] = None
    ): AudioOnlyHlsSettings =
      AudioOnlyHlsSettings
        .builder
        .ifSome(audioGroupId)(_.audioGroupId(_))
        .ifSome(audioOnlyImage)(_.audioOnlyImage(_))
        .ifSome(audioTrackType)(_.audioTrackType(_))
        .ifSome(segmentType)(_.segmentType(_))
        .build

    def audioPidSelection(
      pid: Option[Int] = None
    ): AudioPidSelection =
      AudioPidSelection
        .builder
        .ifSome(pid)(_.pid(_))
        .build

    def audioSelector(
      name: Option[String] = None,
      selectorSettings: Option[AudioSelectorSettings] = None
    ): AudioSelector =
      AudioSelector
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(selectorSettings)(_.selectorSettings(_))
        .build

    def audioSelectorSettings(
      audioLanguageSelection: Option[AudioLanguageSelection] = None,
      audioPidSelection: Option[AudioPidSelection] = None,
      audioTrackSelection: Option[AudioTrackSelection] = None
    ): AudioSelectorSettings =
      AudioSelectorSettings
        .builder
        .ifSome(audioLanguageSelection)(_.audioLanguageSelection(_))
        .ifSome(audioPidSelection)(_.audioPidSelection(_))
        .ifSome(audioTrackSelection)(_.audioTrackSelection(_))
        .build

    def audioSilenceFailoverSettings(
      audioSelectorName: Option[String] = None,
      audioSilenceThresholdMsec: Option[Int] = None
    ): AudioSilenceFailoverSettings =
      AudioSilenceFailoverSettings
        .builder
        .ifSome(audioSelectorName)(_.audioSelectorName(_))
        .ifSome(audioSilenceThresholdMsec)(_.audioSilenceThresholdMsec(_))
        .build

    def audioTrack(
      track: Option[Int] = None
    ): AudioTrack =
      AudioTrack
        .builder
        .ifSome(track)(_.track(_))
        .build

    def audioTrackSelection(
      tracks: Option[List[AudioTrack]] = None
    ): AudioTrackSelection =
      AudioTrackSelection
        .builder
        .ifSome(tracks)(_.tracks(_))
        .build

    def automaticInputFailoverSettings(
      errorClearTimeMsec: Option[Int] = None,
      failoverConditions: Option[List[FailoverCondition]] = None,
      inputPreference: Option[String] = None,
      secondaryInputId: Option[String] = None
    ): AutomaticInputFailoverSettings =
      AutomaticInputFailoverSettings
        .builder
        .ifSome(errorClearTimeMsec)(_.errorClearTimeMsec(_))
        .ifSome(failoverConditions)(_.failoverConditions(_))
        .ifSome(inputPreference)(_.inputPreference(_))
        .ifSome(secondaryInputId)(_.secondaryInputId(_))
        .build

    def availBlanking(
      availBlankingImage: Option[InputLocation] = None,
      state: Option[String] = None
    ): AvailBlanking =
      AvailBlanking
        .builder
        .ifSome(availBlankingImage)(_.availBlankingImage(_))
        .ifSome(state)(_.state(_))
        .build

    def availConfiguration(
      availSettings: Option[AvailSettings] = None
    ): AvailConfiguration =
      AvailConfiguration
        .builder
        .ifSome(availSettings)(_.availSettings(_))
        .build

    def availSettings(
      scte35SpliceInsert: Option[Scte35SpliceInsert] = None,
      scte35TimeSignalApos: Option[Scte35TimeSignalApos] = None
    ): AvailSettings =
      AvailSettings
        .builder
        .ifSome(scte35SpliceInsert)(_.scte35SpliceInsert(_))
        .ifSome(scte35TimeSignalApos)(_.scte35TimeSignalApos(_))
        .build

    def badGatewayException(
      message: Option[String] = None
    ): BadGatewayException =
      BadGatewayException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def batchDelete(
      channelIds: Option[List[__string]] = None,
      inputIds: Option[List[__string]] = None,
      inputSecurityGroupIds: Option[List[__string]] = None,
      multiplexIds: Option[List[__string]] = None
    ): BatchDelete =
      BatchDelete
        .builder
        .ifSome(channelIds)(_.channelIds(_))
        .ifSome(inputIds)(_.inputIds(_))
        .ifSome(inputSecurityGroupIds)(_.inputSecurityGroupIds(_))
        .ifSome(multiplexIds)(_.multiplexIds(_))
        .build

    def batchDeleteRequest(
      channelIds: Option[List[__string]] = None,
      inputIds: Option[List[__string]] = None,
      inputSecurityGroupIds: Option[List[__string]] = None,
      multiplexIds: Option[List[__string]] = None
    ): BatchDeleteRequest =
      BatchDeleteRequest
        .builder
        .ifSome(channelIds)(_.channelIds(_))
        .ifSome(inputIds)(_.inputIds(_))
        .ifSome(inputSecurityGroupIds)(_.inputSecurityGroupIds(_))
        .ifSome(multiplexIds)(_.multiplexIds(_))
        .build

    def batchDeleteResponse(
      failed: Option[List[BatchFailedResultModel]] = None,
      successful: Option[List[BatchSuccessfulResultModel]] = None
    ): BatchDeleteResponse =
      BatchDeleteResponse
        .builder
        .ifSome(failed)(_.failed(_))
        .ifSome(successful)(_.successful(_))
        .build

    def batchDeleteResultModel(
      failed: Option[List[BatchFailedResultModel]] = None,
      successful: Option[List[BatchSuccessfulResultModel]] = None
    ): BatchDeleteResultModel =
      BatchDeleteResultModel
        .builder
        .ifSome(failed)(_.failed(_))
        .ifSome(successful)(_.successful(_))
        .build

    def batchFailedResultModel(
      arn: Option[String] = None,
      code: Option[String] = None,
      id: Option[String] = None,
      message: Option[String] = None
    ): BatchFailedResultModel =
      BatchFailedResultModel
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(code)(_.code(_))
        .ifSome(id)(_.id(_))
        .ifSome(message)(_.message(_))
        .build

    def batchScheduleActionCreateRequest(
      scheduleActions: Option[List[ScheduleAction]] = None
    ): BatchScheduleActionCreateRequest =
      BatchScheduleActionCreateRequest
        .builder
        .ifSome(scheduleActions)(_.scheduleActions(_))
        .build

    def batchScheduleActionDeleteRequest(
      actionNames: Option[List[__string]] = None
    ): BatchScheduleActionDeleteRequest =
      BatchScheduleActionDeleteRequest
        .builder
        .ifSome(actionNames)(_.actionNames(_))
        .build

    def batchStart(
      channelIds: Option[List[__string]] = None,
      multiplexIds: Option[List[__string]] = None
    ): BatchStart =
      BatchStart
        .builder
        .ifSome(channelIds)(_.channelIds(_))
        .ifSome(multiplexIds)(_.multiplexIds(_))
        .build

    def batchStartRequest(
      channelIds: Option[List[__string]] = None,
      multiplexIds: Option[List[__string]] = None
    ): BatchStartRequest =
      BatchStartRequest
        .builder
        .ifSome(channelIds)(_.channelIds(_))
        .ifSome(multiplexIds)(_.multiplexIds(_))
        .build

    def batchStartResponse(
      failed: Option[List[BatchFailedResultModel]] = None,
      successful: Option[List[BatchSuccessfulResultModel]] = None
    ): BatchStartResponse =
      BatchStartResponse
        .builder
        .ifSome(failed)(_.failed(_))
        .ifSome(successful)(_.successful(_))
        .build

    def batchStartResultModel(
      failed: Option[List[BatchFailedResultModel]] = None,
      successful: Option[List[BatchSuccessfulResultModel]] = None
    ): BatchStartResultModel =
      BatchStartResultModel
        .builder
        .ifSome(failed)(_.failed(_))
        .ifSome(successful)(_.successful(_))
        .build

    def batchStop(
      channelIds: Option[List[__string]] = None,
      multiplexIds: Option[List[__string]] = None
    ): BatchStop =
      BatchStop
        .builder
        .ifSome(channelIds)(_.channelIds(_))
        .ifSome(multiplexIds)(_.multiplexIds(_))
        .build

    def batchStopRequest(
      channelIds: Option[List[__string]] = None,
      multiplexIds: Option[List[__string]] = None
    ): BatchStopRequest =
      BatchStopRequest
        .builder
        .ifSome(channelIds)(_.channelIds(_))
        .ifSome(multiplexIds)(_.multiplexIds(_))
        .build

    def batchStopResponse(
      failed: Option[List[BatchFailedResultModel]] = None,
      successful: Option[List[BatchSuccessfulResultModel]] = None
    ): BatchStopResponse =
      BatchStopResponse
        .builder
        .ifSome(failed)(_.failed(_))
        .ifSome(successful)(_.successful(_))
        .build

    def batchStopResultModel(
      failed: Option[List[BatchFailedResultModel]] = None,
      successful: Option[List[BatchSuccessfulResultModel]] = None
    ): BatchStopResultModel =
      BatchStopResultModel
        .builder
        .ifSome(failed)(_.failed(_))
        .ifSome(successful)(_.successful(_))
        .build

    def batchSuccessfulResultModel(
      arn: Option[String] = None,
      id: Option[String] = None,
      state: Option[String] = None
    ): BatchSuccessfulResultModel =
      BatchSuccessfulResultModel
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(state)(_.state(_))
        .build

    def batchUpdateScheduleRequest(
      channelId: Option[String] = None,
      creates: Option[BatchScheduleActionCreateRequest] = None,
      deletes: Option[BatchScheduleActionDeleteRequest] = None
    ): BatchUpdateScheduleRequest =
      BatchUpdateScheduleRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(creates)(_.creates(_))
        .ifSome(deletes)(_.deletes(_))
        .build

    def batchUpdateScheduleResponse(
      creates: Option[BatchScheduleActionCreateResult] = None,
      deletes: Option[BatchScheduleActionDeleteResult] = None
    ): BatchUpdateScheduleResponse =
      BatchUpdateScheduleResponse
        .builder
        .ifSome(creates)(_.creates(_))
        .ifSome(deletes)(_.deletes(_))
        .build

    def blackoutSlate(
      blackoutSlateImage: Option[InputLocation] = None,
      networkEndBlackout: Option[String] = None,
      networkEndBlackoutImage: Option[InputLocation] = None,
      networkId: Option[String] = None,
      state: Option[String] = None
    ): BlackoutSlate =
      BlackoutSlate
        .builder
        .ifSome(blackoutSlateImage)(_.blackoutSlateImage(_))
        .ifSome(networkEndBlackout)(_.networkEndBlackout(_))
        .ifSome(networkEndBlackoutImage)(_.networkEndBlackoutImage(_))
        .ifSome(networkId)(_.networkId(_))
        .ifSome(state)(_.state(_))
        .build

    def burnInDestinationSettings(
      alignment: Option[String] = None,
      backgroundColor: Option[String] = None,
      backgroundOpacity: Option[Int] = None,
      font: Option[InputLocation] = None,
      fontColor: Option[String] = None,
      fontOpacity: Option[Int] = None,
      fontResolution: Option[Int] = None,
      fontSize: Option[String] = None,
      outlineColor: Option[String] = None,
      outlineSize: Option[Int] = None,
      shadowColor: Option[String] = None,
      shadowOpacity: Option[Int] = None,
      shadowXOffset: Option[Int] = None,
      shadowYOffset: Option[Int] = None,
      teletextGridControl: Option[String] = None,
      xPosition: Option[Int] = None,
      yPosition: Option[Int] = None
    ): BurnInDestinationSettings =
      BurnInDestinationSettings
        .builder
        .ifSome(alignment)(_.alignment(_))
        .ifSome(backgroundColor)(_.backgroundColor(_))
        .ifSome(backgroundOpacity)(_.backgroundOpacity(_))
        .ifSome(font)(_.font(_))
        .ifSome(fontColor)(_.fontColor(_))
        .ifSome(fontOpacity)(_.fontOpacity(_))
        .ifSome(fontResolution)(_.fontResolution(_))
        .ifSome(fontSize)(_.fontSize(_))
        .ifSome(outlineColor)(_.outlineColor(_))
        .ifSome(outlineSize)(_.outlineSize(_))
        .ifSome(shadowColor)(_.shadowColor(_))
        .ifSome(shadowOpacity)(_.shadowOpacity(_))
        .ifSome(shadowXOffset)(_.shadowXOffset(_))
        .ifSome(shadowYOffset)(_.shadowYOffset(_))
        .ifSome(teletextGridControl)(_.teletextGridControl(_))
        .ifSome(xPosition)(_.xPosition(_))
        .ifSome(yPosition)(_.yPosition(_))
        .build

    def cancelInputDeviceTransferRequest(
      inputDeviceId: Option[String] = None
    ): CancelInputDeviceTransferRequest =
      CancelInputDeviceTransferRequest
        .builder
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .build

    def cancelInputDeviceTransferResponse(

    ): CancelInputDeviceTransferResponse =
      CancelInputDeviceTransferResponse
        .builder

        .build

    def captionDescription(
      captionSelectorName: Option[String] = None,
      destinationSettings: Option[CaptionDestinationSettings] = None,
      languageCode: Option[String] = None,
      languageDescription: Option[String] = None,
      name: Option[String] = None
    ): CaptionDescription =
      CaptionDescription
        .builder
        .ifSome(captionSelectorName)(_.captionSelectorName(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageDescription)(_.languageDescription(_))
        .ifSome(name)(_.name(_))
        .build

    def captionDestinationSettings(
      aribDestinationSettings: Option[AribDestinationSettings] = None,
      burnInDestinationSettings: Option[BurnInDestinationSettings] = None,
      dvbSubDestinationSettings: Option[DvbSubDestinationSettings] = None,
      ebuTtDDestinationSettings: Option[EbuTtDDestinationSettings] = None,
      embeddedDestinationSettings: Option[EmbeddedDestinationSettings] = None,
      embeddedPlusScte20DestinationSettings: Option[EmbeddedPlusScte20DestinationSettings] = None,
      rtmpCaptionInfoDestinationSettings: Option[RtmpCaptionInfoDestinationSettings] = None,
      scte20PlusEmbeddedDestinationSettings: Option[Scte20PlusEmbeddedDestinationSettings] = None,
      scte27DestinationSettings: Option[Scte27DestinationSettings] = None,
      smpteTtDestinationSettings: Option[SmpteTtDestinationSettings] = None,
      teletextDestinationSettings: Option[TeletextDestinationSettings] = None,
      ttmlDestinationSettings: Option[TtmlDestinationSettings] = None,
      webvttDestinationSettings: Option[WebvttDestinationSettings] = None
    ): CaptionDestinationSettings =
      CaptionDestinationSettings
        .builder
        .ifSome(aribDestinationSettings)(_.aribDestinationSettings(_))
        .ifSome(burnInDestinationSettings)(_.burnInDestinationSettings(_))
        .ifSome(dvbSubDestinationSettings)(_.dvbSubDestinationSettings(_))
        .ifSome(ebuTtDDestinationSettings)(_.ebuTtDDestinationSettings(_))
        .ifSome(embeddedDestinationSettings)(_.embeddedDestinationSettings(_))
        .ifSome(embeddedPlusScte20DestinationSettings)(_.embeddedPlusScte20DestinationSettings(_))
        .ifSome(rtmpCaptionInfoDestinationSettings)(_.rtmpCaptionInfoDestinationSettings(_))
        .ifSome(scte20PlusEmbeddedDestinationSettings)(_.scte20PlusEmbeddedDestinationSettings(_))
        .ifSome(scte27DestinationSettings)(_.scte27DestinationSettings(_))
        .ifSome(smpteTtDestinationSettings)(_.smpteTtDestinationSettings(_))
        .ifSome(teletextDestinationSettings)(_.teletextDestinationSettings(_))
        .ifSome(ttmlDestinationSettings)(_.ttmlDestinationSettings(_))
        .ifSome(webvttDestinationSettings)(_.webvttDestinationSettings(_))
        .build

    def captionLanguageMapping(
      captionChannel: Option[Int] = None,
      languageCode: Option[String] = None,
      languageDescription: Option[String] = None
    ): CaptionLanguageMapping =
      CaptionLanguageMapping
        .builder
        .ifSome(captionChannel)(_.captionChannel(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageDescription)(_.languageDescription(_))
        .build

    def captionRectangle(
      height: Option[__doubleMin0Max100] = None,
      leftOffset: Option[__doubleMin0Max100] = None,
      topOffset: Option[__doubleMin0Max100] = None,
      width: Option[__doubleMin0Max100] = None
    ): CaptionRectangle =
      CaptionRectangle
        .builder
        .ifSome(height)(_.height(_))
        .ifSome(leftOffset)(_.leftOffset(_))
        .ifSome(topOffset)(_.topOffset(_))
        .ifSome(width)(_.width(_))
        .build

    def captionSelector(
      languageCode: Option[String] = None,
      name: Option[String] = None,
      selectorSettings: Option[CaptionSelectorSettings] = None
    ): CaptionSelector =
      CaptionSelector
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(name)(_.name(_))
        .ifSome(selectorSettings)(_.selectorSettings(_))
        .build

    def captionSelectorSettings(
      ancillarySourceSettings: Option[AncillarySourceSettings] = None,
      aribSourceSettings: Option[AribSourceSettings] = None,
      dvbSubSourceSettings: Option[DvbSubSourceSettings] = None,
      embeddedSourceSettings: Option[EmbeddedSourceSettings] = None,
      scte20SourceSettings: Option[Scte20SourceSettings] = None,
      scte27SourceSettings: Option[Scte27SourceSettings] = None,
      teletextSourceSettings: Option[TeletextSourceSettings] = None
    ): CaptionSelectorSettings =
      CaptionSelectorSettings
        .builder
        .ifSome(ancillarySourceSettings)(_.ancillarySourceSettings(_))
        .ifSome(aribSourceSettings)(_.aribSourceSettings(_))
        .ifSome(dvbSubSourceSettings)(_.dvbSubSourceSettings(_))
        .ifSome(embeddedSourceSettings)(_.embeddedSourceSettings(_))
        .ifSome(scte20SourceSettings)(_.scte20SourceSettings(_))
        .ifSome(scte27SourceSettings)(_.scte27SourceSettings(_))
        .ifSome(teletextSourceSettings)(_.teletextSourceSettings(_))
        .build

    def cdiInputSpecification(
      resolution: Option[String] = None
    ): CdiInputSpecification =
      CdiInputSpecification
        .builder
        .ifSome(resolution)(_.resolution(_))
        .build

    def channel(
      arn: Option[String] = None,
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      egressEndpoints: Option[List[ChannelEgressEndpoint]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      id: Option[String] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      pipelineDetails: Option[List[PipelineDetail]] = None,
      pipelinesRunningCount: Option[Int] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettingsDescription] = None
    ): Channel =
      Channel
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def channelConfigurationValidationError(
      message: Option[String] = None,
      validationErrors: Option[List[ValidationError]] = None
    ): ChannelConfigurationValidationError =
      ChannelConfigurationValidationError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def channelEgressEndpoint(
      sourceIp: Option[String] = None
    ): ChannelEgressEndpoint =
      ChannelEgressEndpoint
        .builder
        .ifSome(sourceIp)(_.sourceIp(_))
        .build

    def channelSummary(
      arn: Option[String] = None,
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      egressEndpoints: Option[List[ChannelEgressEndpoint]] = None,
      id: Option[String] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettingsDescription] = None
    ): ChannelSummary =
      ChannelSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def colorSpacePassthroughSettings(

    ): ColorSpacePassthroughSettings =
      ColorSpacePassthroughSettings
        .builder

        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createChannel(
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      reserved: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettings] = None
    ): CreateChannel =
      CreateChannel
        .builder
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(reserved)(_.reserved(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def createChannelRequest(
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      reserved: Option[String] = None,
      roleArn: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettings] = None
    ): CreateChannelRequest =
      CreateChannelRequest
        .builder
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(reserved)(_.reserved(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def createChannelResponse(
      channel: Option[Channel] = None
    ): CreateChannelResponse =
      CreateChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def createChannelResultModel(
      channel: Option[Channel] = None
    ): CreateChannelResultModel =
      CreateChannelResultModel
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def createInput(
      destinations: Option[List[InputDestinationRequest]] = None,
      inputDevices: Option[List[InputDeviceSettings]] = None,
      inputSecurityGroups: Option[List[__string]] = None,
      mediaConnectFlows: Option[List[MediaConnectFlowRequest]] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      roleArn: Option[String] = None,
      sources: Option[List[InputSourceRequest]] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      vpc: Option[InputVpcRequest] = None
    ): CreateInput =
      CreateInput
        .builder
        .ifSome(destinations)(_.destinations(_))
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(inputSecurityGroups)(_.inputSecurityGroups(_))
        .ifSome(mediaConnectFlows)(_.mediaConnectFlows(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def createInputRequest(
      destinations: Option[List[InputDestinationRequest]] = None,
      inputDevices: Option[List[InputDeviceSettings]] = None,
      inputSecurityGroups: Option[List[__string]] = None,
      mediaConnectFlows: Option[List[MediaConnectFlowRequest]] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      roleArn: Option[String] = None,
      sources: Option[List[InputSourceRequest]] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      vpc: Option[InputVpcRequest] = None
    ): CreateInputRequest =
      CreateInputRequest
        .builder
        .ifSome(destinations)(_.destinations(_))
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(inputSecurityGroups)(_.inputSecurityGroups(_))
        .ifSome(mediaConnectFlows)(_.mediaConnectFlows(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def createInputResponse(
      input: Option[Input] = None
    ): CreateInputResponse =
      CreateInputResponse
        .builder
        .ifSome(input)(_.input(_))
        .build

    def createInputResultModel(
      input: Option[Input] = None
    ): CreateInputResultModel =
      CreateInputResultModel
        .builder
        .ifSome(input)(_.input(_))
        .build

    def createInputSecurityGroupRequest(
      tags: Option[Tags] = None,
      whitelistRules: Option[List[InputWhitelistRuleCidr]] = None
    ): CreateInputSecurityGroupRequest =
      CreateInputSecurityGroupRequest
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(whitelistRules)(_.whitelistRules(_))
        .build

    def createInputSecurityGroupResponse(
      securityGroup: Option[InputSecurityGroup] = None
    ): CreateInputSecurityGroupResponse =
      CreateInputSecurityGroupResponse
        .builder
        .ifSome(securityGroup)(_.securityGroup(_))
        .build

    def createInputSecurityGroupResultModel(
      securityGroup: Option[InputSecurityGroup] = None
    ): CreateInputSecurityGroupResultModel =
      CreateInputSecurityGroupResultModel
        .builder
        .ifSome(securityGroup)(_.securityGroup(_))
        .build

    def createMultiplex(
      availabilityZones: Option[List[__string]] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateMultiplex =
      CreateMultiplex
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMultiplexProgram(
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None,
      programName: Option[String] = None,
      requestId: Option[String] = None
    ): CreateMultiplexProgram =
      CreateMultiplexProgram
        .builder
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .ifSome(programName)(_.programName(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createMultiplexProgramRequest(
      multiplexId: Option[String] = None,
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None,
      programName: Option[String] = None,
      requestId: Option[String] = None
    ): CreateMultiplexProgramRequest =
      CreateMultiplexProgramRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .ifSome(programName)(_.programName(_))
        .ifSome(requestId)(_.requestId(_))
        .build

    def createMultiplexProgramResponse(
      multiplexProgram: Option[MultiplexProgram] = None
    ): CreateMultiplexProgramResponse =
      CreateMultiplexProgramResponse
        .builder
        .ifSome(multiplexProgram)(_.multiplexProgram(_))
        .build

    def createMultiplexProgramResultModel(
      multiplexProgram: Option[MultiplexProgram] = None
    ): CreateMultiplexProgramResultModel =
      CreateMultiplexProgramResultModel
        .builder
        .ifSome(multiplexProgram)(_.multiplexProgram(_))
        .build

    def createMultiplexRequest(
      availabilityZones: Option[List[__string]] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateMultiplexRequest =
      CreateMultiplexRequest
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMultiplexResponse(
      multiplex: Option[Multiplex] = None
    ): CreateMultiplexResponse =
      CreateMultiplexResponse
        .builder
        .ifSome(multiplex)(_.multiplex(_))
        .build

    def createMultiplexResultModel(
      multiplex: Option[Multiplex] = None
    ): CreateMultiplexResultModel =
      CreateMultiplexResultModel
        .builder
        .ifSome(multiplex)(_.multiplex(_))
        .build

    def createPartnerInput(
      requestId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreatePartnerInput =
      CreatePartnerInput
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPartnerInputRequest(
      inputId: Option[String] = None,
      requestId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreatePartnerInputRequest =
      CreatePartnerInputRequest
        .builder
        .ifSome(inputId)(_.inputId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPartnerInputResponse(
      input: Option[Input] = None
    ): CreatePartnerInputResponse =
      CreatePartnerInputResponse
        .builder
        .ifSome(input)(_.input(_))
        .build

    def createPartnerInputResultModel(
      input: Option[Input] = None
    ): CreatePartnerInputResultModel =
      CreatePartnerInputResultModel
        .builder
        .ifSome(input)(_.input(_))
        .build

    def createTagsRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateTagsRequest =
      CreateTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteChannelRequest(
      channelId: Option[String] = None
    ): DeleteChannelRequest =
      DeleteChannelRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .build

    def deleteChannelResponse(
      arn: Option[String] = None,
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      egressEndpoints: Option[List[ChannelEgressEndpoint]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      id: Option[String] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      pipelineDetails: Option[List[PipelineDetail]] = None,
      pipelinesRunningCount: Option[Int] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettingsDescription] = None
    ): DeleteChannelResponse =
      DeleteChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def deleteInputRequest(
      inputId: Option[String] = None
    ): DeleteInputRequest =
      DeleteInputRequest
        .builder
        .ifSome(inputId)(_.inputId(_))
        .build

    def deleteInputResponse(

    ): DeleteInputResponse =
      DeleteInputResponse
        .builder

        .build

    def deleteInputSecurityGroupRequest(
      inputSecurityGroupId: Option[String] = None
    ): DeleteInputSecurityGroupRequest =
      DeleteInputSecurityGroupRequest
        .builder
        .ifSome(inputSecurityGroupId)(_.inputSecurityGroupId(_))
        .build

    def deleteInputSecurityGroupResponse(

    ): DeleteInputSecurityGroupResponse =
      DeleteInputSecurityGroupResponse
        .builder

        .build

    def deleteMultiplexProgramRequest(
      multiplexId: Option[String] = None,
      programName: Option[String] = None
    ): DeleteMultiplexProgramRequest =
      DeleteMultiplexProgramRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(programName)(_.programName(_))
        .build

    def deleteMultiplexProgramResponse(
      channelId: Option[String] = None,
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None,
      packetIdentifiersMap: Option[MultiplexProgramPacketIdentifiersMap] = None,
      pipelineDetails: Option[List[MultiplexProgramPipelineDetail]] = None,
      programName: Option[String] = None
    ): DeleteMultiplexProgramResponse =
      DeleteMultiplexProgramResponse
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .ifSome(packetIdentifiersMap)(_.packetIdentifiersMap(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(programName)(_.programName(_))
        .build

    def deleteMultiplexRequest(
      multiplexId: Option[String] = None
    ): DeleteMultiplexRequest =
      DeleteMultiplexRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .build

    def deleteMultiplexResponse(
      arn: Option[String] = None,
      availabilityZones: Option[List[__string]] = None,
      destinations: Option[List[MultiplexOutputDestination]] = None,
      id: Option[String] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      programCount: Option[Int] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): DeleteMultiplexResponse =
      DeleteMultiplexResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(programCount)(_.programCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteReservationRequest(
      reservationId: Option[String] = None
    ): DeleteReservationRequest =
      DeleteReservationRequest
        .builder
        .ifSome(reservationId)(_.reservationId(_))
        .build

    def deleteReservationResponse(
      arn: Option[String] = None,
      count: Option[Int] = None,
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      end: Option[String] = None,
      fixedPrice: Option[__double] = None,
      name: Option[String] = None,
      offeringDescription: Option[String] = None,
      offeringId: Option[String] = None,
      offeringType: Option[String] = None,
      region: Option[String] = None,
      reservationId: Option[String] = None,
      resourceSpecification: Option[ReservationResourceSpecification] = None,
      start: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      usagePrice: Option[__double] = None
    ): DeleteReservationResponse =
      DeleteReservationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(count)(_.count(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(end)(_.end(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(name)(_.name(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(region)(_.region(_))
        .ifSome(reservationId)(_.reservationId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(start)(_.start(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .build

    def deleteScheduleRequest(
      channelId: Option[String] = None
    ): DeleteScheduleRequest =
      DeleteScheduleRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .build

    def deleteScheduleResponse(

    ): DeleteScheduleResponse =
      DeleteScheduleResponse
        .builder

        .build

    def deleteTagsRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): DeleteTagsRequest =
      DeleteTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def describeChannelRequest(
      channelId: Option[String] = None
    ): DescribeChannelRequest =
      DescribeChannelRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .build

    def describeChannelResponse(
      arn: Option[String] = None,
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      egressEndpoints: Option[List[ChannelEgressEndpoint]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      id: Option[String] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      pipelineDetails: Option[List[PipelineDetail]] = None,
      pipelinesRunningCount: Option[Int] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettingsDescription] = None
    ): DescribeChannelResponse =
      DescribeChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def describeInputDeviceRequest(
      inputDeviceId: Option[String] = None
    ): DescribeInputDeviceRequest =
      DescribeInputDeviceRequest
        .builder
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .build

    def describeInputDeviceResponse(
      arn: Option[String] = None,
      connectionState: Option[String] = None,
      deviceSettingsSyncState: Option[String] = None,
      deviceUpdateStatus: Option[String] = None,
      hdDeviceSettings: Option[InputDeviceHdSettings] = None,
      id: Option[String] = None,
      macAddress: Option[String] = None,
      name: Option[String] = None,
      networkSettings: Option[InputDeviceNetworkSettings] = None,
      serialNumber: Option[String] = None,
      `type`: Option[String] = None,
      uhdDeviceSettings: Option[InputDeviceUhdSettings] = None
    ): DescribeInputDeviceResponse =
      DescribeInputDeviceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(deviceSettingsSyncState)(_.deviceSettingsSyncState(_))
        .ifSome(deviceUpdateStatus)(_.deviceUpdateStatus(_))
        .ifSome(hdDeviceSettings)(_.hdDeviceSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkSettings)(_.networkSettings(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uhdDeviceSettings)(_.uhdDeviceSettings(_))
        .build

    def describeInputDeviceThumbnailRequest(
      inputDeviceId: Option[String] = None,
      accept: Option[String] = None
    ): DescribeInputDeviceThumbnailRequest =
      DescribeInputDeviceThumbnailRequest
        .builder
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .ifSome(accept)(_.accept(_))
        .build

    def describeInputDeviceThumbnailResponse(
      body: Option[InputDeviceThumbnail] = None,
      contentType: Option[String] = None,
      contentLength: Option[__long] = None,
      eTag: Option[String] = None,
      lastModified: Option[__timestamp] = None
    ): DescribeInputDeviceThumbnailResponse =
      DescribeInputDeviceThumbnailResponse
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(contentLength)(_.contentLength(_))
        .ifSome(eTag)(_.eTag(_))
        .ifSome(lastModified)(_.lastModified(_))
        .build

    def describeInputRequest(
      inputId: Option[String] = None
    ): DescribeInputRequest =
      DescribeInputRequest
        .builder
        .ifSome(inputId)(_.inputId(_))
        .build

    def describeInputResponse(
      arn: Option[String] = None,
      attachedChannels: Option[List[__string]] = None,
      destinations: Option[List[InputDestination]] = None,
      id: Option[String] = None,
      inputClass: Option[String] = None,
      inputDevices: Option[List[InputDeviceSettings]] = None,
      inputPartnerIds: Option[List[__string]] = None,
      inputSourceType: Option[String] = None,
      mediaConnectFlows: Option[List[MediaConnectFlow]] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None,
      securityGroups: Option[List[__string]] = None,
      sources: Option[List[InputSource]] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None
    ): DescribeInputResponse =
      DescribeInputResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(attachedChannels)(_.attachedChannels(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputClass)(_.inputClass(_))
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(inputPartnerIds)(_.inputPartnerIds(_))
        .ifSome(inputSourceType)(_.inputSourceType(_))
        .ifSome(mediaConnectFlows)(_.mediaConnectFlows(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def describeInputSecurityGroupRequest(
      inputSecurityGroupId: Option[String] = None
    ): DescribeInputSecurityGroupRequest =
      DescribeInputSecurityGroupRequest
        .builder
        .ifSome(inputSecurityGroupId)(_.inputSecurityGroupId(_))
        .build

    def describeInputSecurityGroupResponse(
      arn: Option[String] = None,
      id: Option[String] = None,
      inputs: Option[List[__string]] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      whitelistRules: Option[List[InputWhitelistRule]] = None
    ): DescribeInputSecurityGroupResponse =
      DescribeInputSecurityGroupResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(whitelistRules)(_.whitelistRules(_))
        .build

    def describeMultiplexProgramRequest(
      multiplexId: Option[String] = None,
      programName: Option[String] = None
    ): DescribeMultiplexProgramRequest =
      DescribeMultiplexProgramRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(programName)(_.programName(_))
        .build

    def describeMultiplexProgramResponse(
      channelId: Option[String] = None,
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None,
      packetIdentifiersMap: Option[MultiplexProgramPacketIdentifiersMap] = None,
      pipelineDetails: Option[List[MultiplexProgramPipelineDetail]] = None,
      programName: Option[String] = None
    ): DescribeMultiplexProgramResponse =
      DescribeMultiplexProgramResponse
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .ifSome(packetIdentifiersMap)(_.packetIdentifiersMap(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(programName)(_.programName(_))
        .build

    def describeMultiplexRequest(
      multiplexId: Option[String] = None
    ): DescribeMultiplexRequest =
      DescribeMultiplexRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .build

    def describeMultiplexResponse(
      arn: Option[String] = None,
      availabilityZones: Option[List[__string]] = None,
      destinations: Option[List[MultiplexOutputDestination]] = None,
      id: Option[String] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      programCount: Option[Int] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): DescribeMultiplexResponse =
      DescribeMultiplexResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(programCount)(_.programCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeOfferingRequest(
      offeringId: Option[String] = None
    ): DescribeOfferingRequest =
      DescribeOfferingRequest
        .builder
        .ifSome(offeringId)(_.offeringId(_))
        .build

    def describeOfferingResponse(
      arn: Option[String] = None,
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      fixedPrice: Option[__double] = None,
      offeringDescription: Option[String] = None,
      offeringId: Option[String] = None,
      offeringType: Option[String] = None,
      region: Option[String] = None,
      resourceSpecification: Option[ReservationResourceSpecification] = None,
      usagePrice: Option[__double] = None
    ): DescribeOfferingResponse =
      DescribeOfferingResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .build

    def describeReservationRequest(
      reservationId: Option[String] = None
    ): DescribeReservationRequest =
      DescribeReservationRequest
        .builder
        .ifSome(reservationId)(_.reservationId(_))
        .build

    def describeReservationResponse(
      arn: Option[String] = None,
      count: Option[Int] = None,
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      end: Option[String] = None,
      fixedPrice: Option[__double] = None,
      name: Option[String] = None,
      offeringDescription: Option[String] = None,
      offeringId: Option[String] = None,
      offeringType: Option[String] = None,
      region: Option[String] = None,
      reservationId: Option[String] = None,
      resourceSpecification: Option[ReservationResourceSpecification] = None,
      start: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      usagePrice: Option[__double] = None
    ): DescribeReservationResponse =
      DescribeReservationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(count)(_.count(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(end)(_.end(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(name)(_.name(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(region)(_.region(_))
        .ifSome(reservationId)(_.reservationId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(start)(_.start(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .build

    def describeScheduleRequest(
      channelId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeScheduleRequest =
      DescribeScheduleRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeScheduleResponse(
      nextToken: Option[String] = None,
      scheduleActions: Option[List[ScheduleAction]] = None
    ): DescribeScheduleResponse =
      DescribeScheduleResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(scheduleActions)(_.scheduleActions(_))
        .build

    def dvbNitSettings(
      networkId: Option[Int] = None,
      networkName: Option[String] = None,
      repInterval: Option[Int] = None
    ): DvbNitSettings =
      DvbNitSettings
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(networkName)(_.networkName(_))
        .ifSome(repInterval)(_.repInterval(_))
        .build

    def dvbSdtSettings(
      outputSdt: Option[String] = None,
      repInterval: Option[Int] = None,
      serviceName: Option[String] = None,
      serviceProviderName: Option[String] = None
    ): DvbSdtSettings =
      DvbSdtSettings
        .builder
        .ifSome(outputSdt)(_.outputSdt(_))
        .ifSome(repInterval)(_.repInterval(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceProviderName)(_.serviceProviderName(_))
        .build

    def dvbSubDestinationSettings(
      alignment: Option[String] = None,
      backgroundColor: Option[String] = None,
      backgroundOpacity: Option[Int] = None,
      font: Option[InputLocation] = None,
      fontColor: Option[String] = None,
      fontOpacity: Option[Int] = None,
      fontResolution: Option[Int] = None,
      fontSize: Option[String] = None,
      outlineColor: Option[String] = None,
      outlineSize: Option[Int] = None,
      shadowColor: Option[String] = None,
      shadowOpacity: Option[Int] = None,
      shadowXOffset: Option[Int] = None,
      shadowYOffset: Option[Int] = None,
      teletextGridControl: Option[String] = None,
      xPosition: Option[Int] = None,
      yPosition: Option[Int] = None
    ): DvbSubDestinationSettings =
      DvbSubDestinationSettings
        .builder
        .ifSome(alignment)(_.alignment(_))
        .ifSome(backgroundColor)(_.backgroundColor(_))
        .ifSome(backgroundOpacity)(_.backgroundOpacity(_))
        .ifSome(font)(_.font(_))
        .ifSome(fontColor)(_.fontColor(_))
        .ifSome(fontOpacity)(_.fontOpacity(_))
        .ifSome(fontResolution)(_.fontResolution(_))
        .ifSome(fontSize)(_.fontSize(_))
        .ifSome(outlineColor)(_.outlineColor(_))
        .ifSome(outlineSize)(_.outlineSize(_))
        .ifSome(shadowColor)(_.shadowColor(_))
        .ifSome(shadowOpacity)(_.shadowOpacity(_))
        .ifSome(shadowXOffset)(_.shadowXOffset(_))
        .ifSome(shadowYOffset)(_.shadowYOffset(_))
        .ifSome(teletextGridControl)(_.teletextGridControl(_))
        .ifSome(xPosition)(_.xPosition(_))
        .ifSome(yPosition)(_.yPosition(_))
        .build

    def dvbSubSourceSettings(
      ocrLanguage: Option[String] = None,
      pid: Option[Int] = None
    ): DvbSubSourceSettings =
      DvbSubSourceSettings
        .builder
        .ifSome(ocrLanguage)(_.ocrLanguage(_))
        .ifSome(pid)(_.pid(_))
        .build

    def dvbTdtSettings(
      repInterval: Option[Int] = None
    ): DvbTdtSettings =
      DvbTdtSettings
        .builder
        .ifSome(repInterval)(_.repInterval(_))
        .build

    def eac3Settings(
      attenuationControl: Option[String] = None,
      bitrate: Option[__double] = None,
      bitstreamMode: Option[String] = None,
      codingMode: Option[String] = None,
      dcFilter: Option[String] = None,
      dialnorm: Option[Int] = None,
      drcLine: Option[String] = None,
      drcRf: Option[String] = None,
      lfeControl: Option[String] = None,
      lfeFilter: Option[String] = None,
      loRoCenterMixLevel: Option[__double] = None,
      loRoSurroundMixLevel: Option[__double] = None,
      ltRtCenterMixLevel: Option[__double] = None,
      ltRtSurroundMixLevel: Option[__double] = None,
      metadataControl: Option[String] = None,
      passthroughControl: Option[String] = None,
      phaseControl: Option[String] = None,
      stereoDownmix: Option[String] = None,
      surroundExMode: Option[String] = None,
      surroundMode: Option[String] = None
    ): Eac3Settings =
      Eac3Settings
        .builder
        .ifSome(attenuationControl)(_.attenuationControl(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bitstreamMode)(_.bitstreamMode(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(dcFilter)(_.dcFilter(_))
        .ifSome(dialnorm)(_.dialnorm(_))
        .ifSome(drcLine)(_.drcLine(_))
        .ifSome(drcRf)(_.drcRf(_))
        .ifSome(lfeControl)(_.lfeControl(_))
        .ifSome(lfeFilter)(_.lfeFilter(_))
        .ifSome(loRoCenterMixLevel)(_.loRoCenterMixLevel(_))
        .ifSome(loRoSurroundMixLevel)(_.loRoSurroundMixLevel(_))
        .ifSome(ltRtCenterMixLevel)(_.ltRtCenterMixLevel(_))
        .ifSome(ltRtSurroundMixLevel)(_.ltRtSurroundMixLevel(_))
        .ifSome(metadataControl)(_.metadataControl(_))
        .ifSome(passthroughControl)(_.passthroughControl(_))
        .ifSome(phaseControl)(_.phaseControl(_))
        .ifSome(stereoDownmix)(_.stereoDownmix(_))
        .ifSome(surroundExMode)(_.surroundExMode(_))
        .ifSome(surroundMode)(_.surroundMode(_))
        .build

    def ebuTtDDestinationSettings(
      copyrightHolder: Option[String] = None,
      fillLineGap: Option[String] = None,
      fontFamily: Option[String] = None,
      styleControl: Option[String] = None
    ): EbuTtDDestinationSettings =
      EbuTtDDestinationSettings
        .builder
        .ifSome(copyrightHolder)(_.copyrightHolder(_))
        .ifSome(fillLineGap)(_.fillLineGap(_))
        .ifSome(fontFamily)(_.fontFamily(_))
        .ifSome(styleControl)(_.styleControl(_))
        .build

    def embeddedDestinationSettings(

    ): EmbeddedDestinationSettings =
      EmbeddedDestinationSettings
        .builder

        .build

    def embeddedPlusScte20DestinationSettings(

    ): EmbeddedPlusScte20DestinationSettings =
      EmbeddedPlusScte20DestinationSettings
        .builder

        .build

    def embeddedSourceSettings(
      convert608To708: Option[String] = None,
      scte20Detection: Option[String] = None,
      source608ChannelNumber: Option[Int] = None,
      source608TrackNumber: Option[Int] = None
    ): EmbeddedSourceSettings =
      EmbeddedSourceSettings
        .builder
        .ifSome(convert608To708)(_.convert608To708(_))
        .ifSome(scte20Detection)(_.scte20Detection(_))
        .ifSome(source608ChannelNumber)(_.source608ChannelNumber(_))
        .ifSome(source608TrackNumber)(_.source608TrackNumber(_))
        .build

    def empty(

    ): Empty =
      Empty
        .builder

        .build

    def encoderSettings(
      audioDescriptions: Option[List[AudioDescription]] = None,
      availBlanking: Option[AvailBlanking] = None,
      availConfiguration: Option[AvailConfiguration] = None,
      blackoutSlate: Option[BlackoutSlate] = None,
      captionDescriptions: Option[List[CaptionDescription]] = None,
      featureActivations: Option[FeatureActivations] = None,
      globalConfiguration: Option[GlobalConfiguration] = None,
      motionGraphicsConfiguration: Option[MotionGraphicsConfiguration] = None,
      nielsenConfiguration: Option[NielsenConfiguration] = None,
      outputGroups: Option[List[OutputGroup]] = None,
      timecodeConfig: Option[TimecodeConfig] = None,
      videoDescriptions: Option[List[VideoDescription]] = None
    ): EncoderSettings =
      EncoderSettings
        .builder
        .ifSome(audioDescriptions)(_.audioDescriptions(_))
        .ifSome(availBlanking)(_.availBlanking(_))
        .ifSome(availConfiguration)(_.availConfiguration(_))
        .ifSome(blackoutSlate)(_.blackoutSlate(_))
        .ifSome(captionDescriptions)(_.captionDescriptions(_))
        .ifSome(featureActivations)(_.featureActivations(_))
        .ifSome(globalConfiguration)(_.globalConfiguration(_))
        .ifSome(motionGraphicsConfiguration)(_.motionGraphicsConfiguration(_))
        .ifSome(nielsenConfiguration)(_.nielsenConfiguration(_))
        .ifSome(outputGroups)(_.outputGroups(_))
        .ifSome(timecodeConfig)(_.timecodeConfig(_))
        .ifSome(videoDescriptions)(_.videoDescriptions(_))
        .build

    def failoverCondition(
      failoverConditionSettings: Option[FailoverConditionSettings] = None
    ): FailoverCondition =
      FailoverCondition
        .builder
        .ifSome(failoverConditionSettings)(_.failoverConditionSettings(_))
        .build

    def failoverConditionSettings(
      audioSilenceSettings: Option[AudioSilenceFailoverSettings] = None,
      inputLossSettings: Option[InputLossFailoverSettings] = None,
      videoBlackSettings: Option[VideoBlackFailoverSettings] = None
    ): FailoverConditionSettings =
      FailoverConditionSettings
        .builder
        .ifSome(audioSilenceSettings)(_.audioSilenceSettings(_))
        .ifSome(inputLossSettings)(_.inputLossSettings(_))
        .ifSome(videoBlackSettings)(_.videoBlackSettings(_))
        .build

    def featureActivations(
      inputPrepareScheduleActions: Option[String] = None
    ): FeatureActivations =
      FeatureActivations
        .builder
        .ifSome(inputPrepareScheduleActions)(_.inputPrepareScheduleActions(_))
        .build

    def fecOutputSettings(
      columnDepth: Option[Int] = None,
      includeFec: Option[String] = None,
      rowLength: Option[Int] = None
    ): FecOutputSettings =
      FecOutputSettings
        .builder
        .ifSome(columnDepth)(_.columnDepth(_))
        .ifSome(includeFec)(_.includeFec(_))
        .ifSome(rowLength)(_.rowLength(_))
        .build

    def fixedModeScheduleActionStartSettings(
      time: Option[String] = None
    ): FixedModeScheduleActionStartSettings =
      FixedModeScheduleActionStartSettings
        .builder
        .ifSome(time)(_.time(_))
        .build

    def fmp4HlsSettings(
      audioRenditionSets: Option[String] = None,
      nielsenId3Behavior: Option[String] = None,
      timedMetadataBehavior: Option[String] = None
    ): Fmp4HlsSettings =
      Fmp4HlsSettings
        .builder
        .ifSome(audioRenditionSets)(_.audioRenditionSets(_))
        .ifSome(nielsenId3Behavior)(_.nielsenId3Behavior(_))
        .ifSome(timedMetadataBehavior)(_.timedMetadataBehavior(_))
        .build

    def followModeScheduleActionStartSettings(
      followPoint: Option[String] = None,
      referenceActionName: Option[String] = None
    ): FollowModeScheduleActionStartSettings =
      FollowModeScheduleActionStartSettings
        .builder
        .ifSome(followPoint)(_.followPoint(_))
        .ifSome(referenceActionName)(_.referenceActionName(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def frameCaptureCdnSettings(
      frameCaptureS3Settings: Option[FrameCaptureS3Settings] = None
    ): FrameCaptureCdnSettings =
      FrameCaptureCdnSettings
        .builder
        .ifSome(frameCaptureS3Settings)(_.frameCaptureS3Settings(_))
        .build

    def frameCaptureGroupSettings(
      destination: Option[OutputLocationRef] = None,
      frameCaptureCdnSettings: Option[FrameCaptureCdnSettings] = None
    ): FrameCaptureGroupSettings =
      FrameCaptureGroupSettings
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(frameCaptureCdnSettings)(_.frameCaptureCdnSettings(_))
        .build

    def frameCaptureHlsSettings(

    ): FrameCaptureHlsSettings =
      FrameCaptureHlsSettings
        .builder

        .build

    def frameCaptureOutputSettings(
      nameModifier: Option[String] = None
    ): FrameCaptureOutputSettings =
      FrameCaptureOutputSettings
        .builder
        .ifSome(nameModifier)(_.nameModifier(_))
        .build

    def frameCaptureS3Settings(
      cannedAcl: Option[String] = None
    ): FrameCaptureS3Settings =
      FrameCaptureS3Settings
        .builder
        .ifSome(cannedAcl)(_.cannedAcl(_))
        .build

    def frameCaptureSettings(
      captureInterval: Option[Int] = None,
      captureIntervalUnits: Option[String] = None
    ): FrameCaptureSettings =
      FrameCaptureSettings
        .builder
        .ifSome(captureInterval)(_.captureInterval(_))
        .ifSome(captureIntervalUnits)(_.captureIntervalUnits(_))
        .build

    def gatewayTimeoutException(
      message: Option[String] = None
    ): GatewayTimeoutException =
      GatewayTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def globalConfiguration(
      initialAudioGain: Option[Int] = None,
      inputEndAction: Option[String] = None,
      inputLossBehavior: Option[InputLossBehavior] = None,
      outputLockingMode: Option[String] = None,
      outputTimingSource: Option[String] = None,
      supportLowFramerateInputs: Option[String] = None
    ): GlobalConfiguration =
      GlobalConfiguration
        .builder
        .ifSome(initialAudioGain)(_.initialAudioGain(_))
        .ifSome(inputEndAction)(_.inputEndAction(_))
        .ifSome(inputLossBehavior)(_.inputLossBehavior(_))
        .ifSome(outputLockingMode)(_.outputLockingMode(_))
        .ifSome(outputTimingSource)(_.outputTimingSource(_))
        .ifSome(supportLowFramerateInputs)(_.supportLowFramerateInputs(_))
        .build

    def h264ColorSpaceSettings(
      colorSpacePassthroughSettings: Option[ColorSpacePassthroughSettings] = None,
      rec601Settings: Option[Rec601Settings] = None,
      rec709Settings: Option[Rec709Settings] = None
    ): H264ColorSpaceSettings =
      H264ColorSpaceSettings
        .builder
        .ifSome(colorSpacePassthroughSettings)(_.colorSpacePassthroughSettings(_))
        .ifSome(rec601Settings)(_.rec601Settings(_))
        .ifSome(rec709Settings)(_.rec709Settings(_))
        .build

    def h264FilterSettings(
      temporalFilterSettings: Option[TemporalFilterSettings] = None
    ): H264FilterSettings =
      H264FilterSettings
        .builder
        .ifSome(temporalFilterSettings)(_.temporalFilterSettings(_))
        .build

    def h264Settings(
      adaptiveQuantization: Option[String] = None,
      afdSignaling: Option[String] = None,
      bitrate: Option[Int] = None,
      bufFillPct: Option[Int] = None,
      bufSize: Option[Int] = None,
      colorMetadata: Option[String] = None,
      colorSpaceSettings: Option[H264ColorSpaceSettings] = None,
      entropyEncoding: Option[String] = None,
      filterSettings: Option[H264FilterSettings] = None,
      fixedAfd: Option[String] = None,
      flickerAq: Option[String] = None,
      forceFieldPictures: Option[String] = None,
      framerateControl: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopBReference: Option[String] = None,
      gopClosedCadence: Option[Int] = None,
      gopNumBFrames: Option[Int] = None,
      gopSize: Option[__double] = None,
      gopSizeUnits: Option[String] = None,
      level: Option[String] = None,
      lookAheadRateControl: Option[String] = None,
      maxBitrate: Option[Int] = None,
      minIInterval: Option[Int] = None,
      numRefFrames: Option[Int] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      profile: Option[String] = None,
      qualityLevel: Option[String] = None,
      qvbrQualityLevel: Option[Int] = None,
      rateControlMode: Option[String] = None,
      scanType: Option[String] = None,
      sceneChangeDetect: Option[String] = None,
      slices: Option[Int] = None,
      softness: Option[Int] = None,
      spatialAq: Option[String] = None,
      subgopLength: Option[String] = None,
      syntax: Option[String] = None,
      temporalAq: Option[String] = None,
      timecodeInsertion: Option[String] = None
    ): H264Settings =
      H264Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(afdSignaling)(_.afdSignaling(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bufFillPct)(_.bufFillPct(_))
        .ifSome(bufSize)(_.bufSize(_))
        .ifSome(colorMetadata)(_.colorMetadata(_))
        .ifSome(colorSpaceSettings)(_.colorSpaceSettings(_))
        .ifSome(entropyEncoding)(_.entropyEncoding(_))
        .ifSome(filterSettings)(_.filterSettings(_))
        .ifSome(fixedAfd)(_.fixedAfd(_))
        .ifSome(flickerAq)(_.flickerAq(_))
        .ifSome(forceFieldPictures)(_.forceFieldPictures(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopBReference)(_.gopBReference(_))
        .ifSome(gopClosedCadence)(_.gopClosedCadence(_))
        .ifSome(gopNumBFrames)(_.gopNumBFrames(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(gopSizeUnits)(_.gopSizeUnits(_))
        .ifSome(level)(_.level(_))
        .ifSome(lookAheadRateControl)(_.lookAheadRateControl(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(minIInterval)(_.minIInterval(_))
        .ifSome(numRefFrames)(_.numRefFrames(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(profile)(_.profile(_))
        .ifSome(qualityLevel)(_.qualityLevel(_))
        .ifSome(qvbrQualityLevel)(_.qvbrQualityLevel(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(scanType)(_.scanType(_))
        .ifSome(sceneChangeDetect)(_.sceneChangeDetect(_))
        .ifSome(slices)(_.slices(_))
        .ifSome(softness)(_.softness(_))
        .ifSome(spatialAq)(_.spatialAq(_))
        .ifSome(subgopLength)(_.subgopLength(_))
        .ifSome(syntax)(_.syntax(_))
        .ifSome(temporalAq)(_.temporalAq(_))
        .ifSome(timecodeInsertion)(_.timecodeInsertion(_))
        .build

    def h265ColorSpaceSettings(
      colorSpacePassthroughSettings: Option[ColorSpacePassthroughSettings] = None,
      hdr10Settings: Option[Hdr10Settings] = None,
      rec601Settings: Option[Rec601Settings] = None,
      rec709Settings: Option[Rec709Settings] = None
    ): H265ColorSpaceSettings =
      H265ColorSpaceSettings
        .builder
        .ifSome(colorSpacePassthroughSettings)(_.colorSpacePassthroughSettings(_))
        .ifSome(hdr10Settings)(_.hdr10Settings(_))
        .ifSome(rec601Settings)(_.rec601Settings(_))
        .ifSome(rec709Settings)(_.rec709Settings(_))
        .build

    def h265FilterSettings(
      temporalFilterSettings: Option[TemporalFilterSettings] = None
    ): H265FilterSettings =
      H265FilterSettings
        .builder
        .ifSome(temporalFilterSettings)(_.temporalFilterSettings(_))
        .build

    def h265Settings(
      adaptiveQuantization: Option[String] = None,
      afdSignaling: Option[String] = None,
      alternativeTransferFunction: Option[String] = None,
      bitrate: Option[Int] = None,
      bufSize: Option[Int] = None,
      colorMetadata: Option[String] = None,
      colorSpaceSettings: Option[H265ColorSpaceSettings] = None,
      filterSettings: Option[H265FilterSettings] = None,
      fixedAfd: Option[String] = None,
      flickerAq: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopClosedCadence: Option[Int] = None,
      gopSize: Option[__double] = None,
      gopSizeUnits: Option[String] = None,
      level: Option[String] = None,
      lookAheadRateControl: Option[String] = None,
      maxBitrate: Option[Int] = None,
      minIInterval: Option[Int] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      profile: Option[String] = None,
      qvbrQualityLevel: Option[Int] = None,
      rateControlMode: Option[String] = None,
      scanType: Option[String] = None,
      sceneChangeDetect: Option[String] = None,
      slices: Option[Int] = None,
      tier: Option[String] = None,
      timecodeInsertion: Option[String] = None
    ): H265Settings =
      H265Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(afdSignaling)(_.afdSignaling(_))
        .ifSome(alternativeTransferFunction)(_.alternativeTransferFunction(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bufSize)(_.bufSize(_))
        .ifSome(colorMetadata)(_.colorMetadata(_))
        .ifSome(colorSpaceSettings)(_.colorSpaceSettings(_))
        .ifSome(filterSettings)(_.filterSettings(_))
        .ifSome(fixedAfd)(_.fixedAfd(_))
        .ifSome(flickerAq)(_.flickerAq(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopClosedCadence)(_.gopClosedCadence(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(gopSizeUnits)(_.gopSizeUnits(_))
        .ifSome(level)(_.level(_))
        .ifSome(lookAheadRateControl)(_.lookAheadRateControl(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(minIInterval)(_.minIInterval(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(profile)(_.profile(_))
        .ifSome(qvbrQualityLevel)(_.qvbrQualityLevel(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(scanType)(_.scanType(_))
        .ifSome(sceneChangeDetect)(_.sceneChangeDetect(_))
        .ifSome(slices)(_.slices(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(timecodeInsertion)(_.timecodeInsertion(_))
        .build

    def hdr10Settings(
      maxCll: Option[Int] = None,
      maxFall: Option[Int] = None
    ): Hdr10Settings =
      Hdr10Settings
        .builder
        .ifSome(maxCll)(_.maxCll(_))
        .ifSome(maxFall)(_.maxFall(_))
        .build

    def hlsAkamaiSettings(
      connectionRetryInterval: Option[Int] = None,
      filecacheDuration: Option[Int] = None,
      httpTransferMode: Option[String] = None,
      numRetries: Option[Int] = None,
      restartDelay: Option[Int] = None,
      salt: Option[String] = None,
      token: Option[String] = None
    ): HlsAkamaiSettings =
      HlsAkamaiSettings
        .builder
        .ifSome(connectionRetryInterval)(_.connectionRetryInterval(_))
        .ifSome(filecacheDuration)(_.filecacheDuration(_))
        .ifSome(httpTransferMode)(_.httpTransferMode(_))
        .ifSome(numRetries)(_.numRetries(_))
        .ifSome(restartDelay)(_.restartDelay(_))
        .ifSome(salt)(_.salt(_))
        .ifSome(token)(_.token(_))
        .build

    def hlsBasicPutSettings(
      connectionRetryInterval: Option[Int] = None,
      filecacheDuration: Option[Int] = None,
      numRetries: Option[Int] = None,
      restartDelay: Option[Int] = None
    ): HlsBasicPutSettings =
      HlsBasicPutSettings
        .builder
        .ifSome(connectionRetryInterval)(_.connectionRetryInterval(_))
        .ifSome(filecacheDuration)(_.filecacheDuration(_))
        .ifSome(numRetries)(_.numRetries(_))
        .ifSome(restartDelay)(_.restartDelay(_))
        .build

    def hlsCdnSettings(
      hlsAkamaiSettings: Option[HlsAkamaiSettings] = None,
      hlsBasicPutSettings: Option[HlsBasicPutSettings] = None,
      hlsMediaStoreSettings: Option[HlsMediaStoreSettings] = None,
      hlsS3Settings: Option[HlsS3Settings] = None,
      hlsWebdavSettings: Option[HlsWebdavSettings] = None
    ): HlsCdnSettings =
      HlsCdnSettings
        .builder
        .ifSome(hlsAkamaiSettings)(_.hlsAkamaiSettings(_))
        .ifSome(hlsBasicPutSettings)(_.hlsBasicPutSettings(_))
        .ifSome(hlsMediaStoreSettings)(_.hlsMediaStoreSettings(_))
        .ifSome(hlsS3Settings)(_.hlsS3Settings(_))
        .ifSome(hlsWebdavSettings)(_.hlsWebdavSettings(_))
        .build

    def hlsGroupSettings(
      adMarkers: Option[List[HlsAdMarkers]] = None,
      baseUrlContent: Option[String] = None,
      baseUrlContent1: Option[String] = None,
      baseUrlManifest: Option[String] = None,
      baseUrlManifest1: Option[String] = None,
      captionLanguageMappings: Option[List[CaptionLanguageMapping]] = None,
      captionLanguageSetting: Option[String] = None,
      clientCache: Option[String] = None,
      codecSpecification: Option[String] = None,
      constantIv: Option[String] = None,
      destination: Option[OutputLocationRef] = None,
      directoryStructure: Option[String] = None,
      discontinuityTags: Option[String] = None,
      encryptionType: Option[String] = None,
      hlsCdnSettings: Option[HlsCdnSettings] = None,
      hlsId3SegmentTagging: Option[String] = None,
      iFrameOnlyPlaylists: Option[String] = None,
      incompleteSegmentBehavior: Option[String] = None,
      indexNSegments: Option[Int] = None,
      inputLossAction: Option[String] = None,
      ivInManifest: Option[String] = None,
      ivSource: Option[String] = None,
      keepSegments: Option[Int] = None,
      keyFormat: Option[String] = None,
      keyFormatVersions: Option[String] = None,
      keyProviderSettings: Option[KeyProviderSettings] = None,
      manifestCompression: Option[String] = None,
      manifestDurationFormat: Option[String] = None,
      minSegmentLength: Option[Int] = None,
      mode: Option[String] = None,
      outputSelection: Option[String] = None,
      programDateTime: Option[String] = None,
      programDateTimePeriod: Option[Int] = None,
      redundantManifest: Option[String] = None,
      segmentLength: Option[Int] = None,
      segmentationMode: Option[String] = None,
      segmentsPerSubdirectory: Option[Int] = None,
      streamInfResolution: Option[String] = None,
      timedMetadataId3Frame: Option[String] = None,
      timedMetadataId3Period: Option[Int] = None,
      timestampDeltaMilliseconds: Option[Int] = None,
      tsFileMode: Option[String] = None
    ): HlsGroupSettings =
      HlsGroupSettings
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(baseUrlContent)(_.baseUrlContent(_))
        .ifSome(baseUrlContent1)(_.baseUrlContent1(_))
        .ifSome(baseUrlManifest)(_.baseUrlManifest(_))
        .ifSome(baseUrlManifest1)(_.baseUrlManifest1(_))
        .ifSome(captionLanguageMappings)(_.captionLanguageMappings(_))
        .ifSome(captionLanguageSetting)(_.captionLanguageSetting(_))
        .ifSome(clientCache)(_.clientCache(_))
        .ifSome(codecSpecification)(_.codecSpecification(_))
        .ifSome(constantIv)(_.constantIv(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(directoryStructure)(_.directoryStructure(_))
        .ifSome(discontinuityTags)(_.discontinuityTags(_))
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(hlsCdnSettings)(_.hlsCdnSettings(_))
        .ifSome(hlsId3SegmentTagging)(_.hlsId3SegmentTagging(_))
        .ifSome(iFrameOnlyPlaylists)(_.iFrameOnlyPlaylists(_))
        .ifSome(incompleteSegmentBehavior)(_.incompleteSegmentBehavior(_))
        .ifSome(indexNSegments)(_.indexNSegments(_))
        .ifSome(inputLossAction)(_.inputLossAction(_))
        .ifSome(ivInManifest)(_.ivInManifest(_))
        .ifSome(ivSource)(_.ivSource(_))
        .ifSome(keepSegments)(_.keepSegments(_))
        .ifSome(keyFormat)(_.keyFormat(_))
        .ifSome(keyFormatVersions)(_.keyFormatVersions(_))
        .ifSome(keyProviderSettings)(_.keyProviderSettings(_))
        .ifSome(manifestCompression)(_.manifestCompression(_))
        .ifSome(manifestDurationFormat)(_.manifestDurationFormat(_))
        .ifSome(minSegmentLength)(_.minSegmentLength(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(outputSelection)(_.outputSelection(_))
        .ifSome(programDateTime)(_.programDateTime(_))
        .ifSome(programDateTimePeriod)(_.programDateTimePeriod(_))
        .ifSome(redundantManifest)(_.redundantManifest(_))
        .ifSome(segmentLength)(_.segmentLength(_))
        .ifSome(segmentationMode)(_.segmentationMode(_))
        .ifSome(segmentsPerSubdirectory)(_.segmentsPerSubdirectory(_))
        .ifSome(streamInfResolution)(_.streamInfResolution(_))
        .ifSome(timedMetadataId3Frame)(_.timedMetadataId3Frame(_))
        .ifSome(timedMetadataId3Period)(_.timedMetadataId3Period(_))
        .ifSome(timestampDeltaMilliseconds)(_.timestampDeltaMilliseconds(_))
        .ifSome(tsFileMode)(_.tsFileMode(_))
        .build

    def hlsId3SegmentTaggingScheduleActionSettings(
      tag: Option[String] = None
    ): HlsId3SegmentTaggingScheduleActionSettings =
      HlsId3SegmentTaggingScheduleActionSettings
        .builder
        .ifSome(tag)(_.tag(_))
        .build

    def hlsInputSettings(
      bandwidth: Option[Int] = None,
      bufferSegments: Option[Int] = None,
      retries: Option[Int] = None,
      retryInterval: Option[Int] = None,
      scte35Source: Option[String] = None
    ): HlsInputSettings =
      HlsInputSettings
        .builder
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(bufferSegments)(_.bufferSegments(_))
        .ifSome(retries)(_.retries(_))
        .ifSome(retryInterval)(_.retryInterval(_))
        .ifSome(scte35Source)(_.scte35Source(_))
        .build

    def hlsMediaStoreSettings(
      connectionRetryInterval: Option[Int] = None,
      filecacheDuration: Option[Int] = None,
      mediaStoreStorageClass: Option[String] = None,
      numRetries: Option[Int] = None,
      restartDelay: Option[Int] = None
    ): HlsMediaStoreSettings =
      HlsMediaStoreSettings
        .builder
        .ifSome(connectionRetryInterval)(_.connectionRetryInterval(_))
        .ifSome(filecacheDuration)(_.filecacheDuration(_))
        .ifSome(mediaStoreStorageClass)(_.mediaStoreStorageClass(_))
        .ifSome(numRetries)(_.numRetries(_))
        .ifSome(restartDelay)(_.restartDelay(_))
        .build

    def hlsOutputSettings(
      h265PackagingType: Option[String] = None,
      hlsSettings: Option[HlsSettings] = None,
      nameModifier: Option[String] = None,
      segmentModifier: Option[String] = None
    ): HlsOutputSettings =
      HlsOutputSettings
        .builder
        .ifSome(h265PackagingType)(_.h265PackagingType(_))
        .ifSome(hlsSettings)(_.hlsSettings(_))
        .ifSome(nameModifier)(_.nameModifier(_))
        .ifSome(segmentModifier)(_.segmentModifier(_))
        .build

    def hlsS3Settings(
      cannedAcl: Option[String] = None
    ): HlsS3Settings =
      HlsS3Settings
        .builder
        .ifSome(cannedAcl)(_.cannedAcl(_))
        .build

    def hlsSettings(
      audioOnlyHlsSettings: Option[AudioOnlyHlsSettings] = None,
      fmp4HlsSettings: Option[Fmp4HlsSettings] = None,
      frameCaptureHlsSettings: Option[FrameCaptureHlsSettings] = None,
      standardHlsSettings: Option[StandardHlsSettings] = None
    ): HlsSettings =
      HlsSettings
        .builder
        .ifSome(audioOnlyHlsSettings)(_.audioOnlyHlsSettings(_))
        .ifSome(fmp4HlsSettings)(_.fmp4HlsSettings(_))
        .ifSome(frameCaptureHlsSettings)(_.frameCaptureHlsSettings(_))
        .ifSome(standardHlsSettings)(_.standardHlsSettings(_))
        .build

    def hlsTimedMetadataScheduleActionSettings(
      id3: Option[String] = None
    ): HlsTimedMetadataScheduleActionSettings =
      HlsTimedMetadataScheduleActionSettings
        .builder
        .ifSome(id3)(_.id3(_))
        .build

    def hlsWebdavSettings(
      connectionRetryInterval: Option[Int] = None,
      filecacheDuration: Option[Int] = None,
      httpTransferMode: Option[String] = None,
      numRetries: Option[Int] = None,
      restartDelay: Option[Int] = None
    ): HlsWebdavSettings =
      HlsWebdavSettings
        .builder
        .ifSome(connectionRetryInterval)(_.connectionRetryInterval(_))
        .ifSome(filecacheDuration)(_.filecacheDuration(_))
        .ifSome(httpTransferMode)(_.httpTransferMode(_))
        .ifSome(numRetries)(_.numRetries(_))
        .ifSome(restartDelay)(_.restartDelay(_))
        .build

    def htmlMotionGraphicsSettings(

    ): HtmlMotionGraphicsSettings =
      HtmlMotionGraphicsSettings
        .builder

        .build

    def immediateModeScheduleActionStartSettings(

    ): ImmediateModeScheduleActionStartSettings =
      ImmediateModeScheduleActionStartSettings
        .builder

        .build

    def input(
      arn: Option[String] = None,
      attachedChannels: Option[List[__string]] = None,
      destinations: Option[List[InputDestination]] = None,
      id: Option[String] = None,
      inputClass: Option[String] = None,
      inputDevices: Option[List[InputDeviceSettings]] = None,
      inputPartnerIds: Option[List[__string]] = None,
      inputSourceType: Option[String] = None,
      mediaConnectFlows: Option[List[MediaConnectFlow]] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None,
      securityGroups: Option[List[__string]] = None,
      sources: Option[List[InputSource]] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None
    ): Input =
      Input
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(attachedChannels)(_.attachedChannels(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputClass)(_.inputClass(_))
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(inputPartnerIds)(_.inputPartnerIds(_))
        .ifSome(inputSourceType)(_.inputSourceType(_))
        .ifSome(mediaConnectFlows)(_.mediaConnectFlows(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def inputAttachment(
      automaticInputFailoverSettings: Option[AutomaticInputFailoverSettings] = None,
      inputAttachmentName: Option[String] = None,
      inputId: Option[String] = None,
      inputSettings: Option[InputSettings] = None
    ): InputAttachment =
      InputAttachment
        .builder
        .ifSome(automaticInputFailoverSettings)(_.automaticInputFailoverSettings(_))
        .ifSome(inputAttachmentName)(_.inputAttachmentName(_))
        .ifSome(inputId)(_.inputId(_))
        .ifSome(inputSettings)(_.inputSettings(_))
        .build

    def inputChannelLevel(
      gain: Option[Int] = None,
      inputChannel: Option[Int] = None
    ): InputChannelLevel =
      InputChannelLevel
        .builder
        .ifSome(gain)(_.gain(_))
        .ifSome(inputChannel)(_.inputChannel(_))
        .build

    def inputClippingSettings(
      inputTimecodeSource: Option[String] = None,
      startTimecode: Option[StartTimecode] = None,
      stopTimecode: Option[StopTimecode] = None
    ): InputClippingSettings =
      InputClippingSettings
        .builder
        .ifSome(inputTimecodeSource)(_.inputTimecodeSource(_))
        .ifSome(startTimecode)(_.startTimecode(_))
        .ifSome(stopTimecode)(_.stopTimecode(_))
        .build

    def inputDestination(
      ip: Option[String] = None,
      port: Option[String] = None,
      url: Option[String] = None,
      vpc: Option[InputDestinationVpc] = None
    ): InputDestination =
      InputDestination
        .builder
        .ifSome(ip)(_.ip(_))
        .ifSome(port)(_.port(_))
        .ifSome(url)(_.url(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def inputDestinationRequest(
      streamName: Option[String] = None
    ): InputDestinationRequest =
      InputDestinationRequest
        .builder
        .ifSome(streamName)(_.streamName(_))
        .build

    def inputDestinationVpc(
      availabilityZone: Option[String] = None,
      networkInterfaceId: Option[String] = None
    ): InputDestinationVpc =
      InputDestinationVpc
        .builder
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .build

    def inputDevice(
      arn: Option[String] = None,
      connectionState: Option[String] = None,
      deviceSettingsSyncState: Option[String] = None,
      deviceUpdateStatus: Option[String] = None,
      hdDeviceSettings: Option[InputDeviceHdSettings] = None,
      id: Option[String] = None,
      macAddress: Option[String] = None,
      name: Option[String] = None,
      networkSettings: Option[InputDeviceNetworkSettings] = None,
      serialNumber: Option[String] = None,
      `type`: Option[String] = None,
      uhdDeviceSettings: Option[InputDeviceUhdSettings] = None
    ): InputDevice =
      InputDevice
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(deviceSettingsSyncState)(_.deviceSettingsSyncState(_))
        .ifSome(deviceUpdateStatus)(_.deviceUpdateStatus(_))
        .ifSome(hdDeviceSettings)(_.hdDeviceSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkSettings)(_.networkSettings(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uhdDeviceSettings)(_.uhdDeviceSettings(_))
        .build

    def inputDeviceConfigurableSettings(
      configuredInput: Option[String] = None,
      maxBitrate: Option[Int] = None
    ): InputDeviceConfigurableSettings =
      InputDeviceConfigurableSettings
        .builder
        .ifSome(configuredInput)(_.configuredInput(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .build

    def inputDeviceConfigurationValidationError(
      message: Option[String] = None,
      validationErrors: Option[List[ValidationError]] = None
    ): InputDeviceConfigurationValidationError =
      InputDeviceConfigurationValidationError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def inputDeviceHdSettings(
      activeInput: Option[String] = None,
      configuredInput: Option[String] = None,
      deviceState: Option[String] = None,
      framerate: Option[__double] = None,
      height: Option[Int] = None,
      maxBitrate: Option[Int] = None,
      scanType: Option[String] = None,
      width: Option[Int] = None
    ): InputDeviceHdSettings =
      InputDeviceHdSettings
        .builder
        .ifSome(activeInput)(_.activeInput(_))
        .ifSome(configuredInput)(_.configuredInput(_))
        .ifSome(deviceState)(_.deviceState(_))
        .ifSome(framerate)(_.framerate(_))
        .ifSome(height)(_.height(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(scanType)(_.scanType(_))
        .ifSome(width)(_.width(_))
        .build

    def inputDeviceNetworkSettings(
      dnsAddresses: Option[List[__string]] = None,
      gateway: Option[String] = None,
      ipAddress: Option[String] = None,
      ipScheme: Option[String] = None,
      subnetMask: Option[String] = None
    ): InputDeviceNetworkSettings =
      InputDeviceNetworkSettings
        .builder
        .ifSome(dnsAddresses)(_.dnsAddresses(_))
        .ifSome(gateway)(_.gateway(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .ifSome(ipScheme)(_.ipScheme(_))
        .ifSome(subnetMask)(_.subnetMask(_))
        .build

    def inputDeviceRequest(
      id: Option[String] = None
    ): InputDeviceRequest =
      InputDeviceRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def inputDeviceSettings(
      id: Option[String] = None
    ): InputDeviceSettings =
      InputDeviceSettings
        .builder
        .ifSome(id)(_.id(_))
        .build

    def inputDeviceSummary(
      arn: Option[String] = None,
      connectionState: Option[String] = None,
      deviceSettingsSyncState: Option[String] = None,
      deviceUpdateStatus: Option[String] = None,
      hdDeviceSettings: Option[InputDeviceHdSettings] = None,
      id: Option[String] = None,
      macAddress: Option[String] = None,
      name: Option[String] = None,
      networkSettings: Option[InputDeviceNetworkSettings] = None,
      serialNumber: Option[String] = None,
      `type`: Option[String] = None,
      uhdDeviceSettings: Option[InputDeviceUhdSettings] = None
    ): InputDeviceSummary =
      InputDeviceSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(deviceSettingsSyncState)(_.deviceSettingsSyncState(_))
        .ifSome(deviceUpdateStatus)(_.deviceUpdateStatus(_))
        .ifSome(hdDeviceSettings)(_.hdDeviceSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkSettings)(_.networkSettings(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uhdDeviceSettings)(_.uhdDeviceSettings(_))
        .build

    def inputDeviceUhdSettings(
      activeInput: Option[String] = None,
      configuredInput: Option[String] = None,
      deviceState: Option[String] = None,
      framerate: Option[__double] = None,
      height: Option[Int] = None,
      maxBitrate: Option[Int] = None,
      scanType: Option[String] = None,
      width: Option[Int] = None
    ): InputDeviceUhdSettings =
      InputDeviceUhdSettings
        .builder
        .ifSome(activeInput)(_.activeInput(_))
        .ifSome(configuredInput)(_.configuredInput(_))
        .ifSome(deviceState)(_.deviceState(_))
        .ifSome(framerate)(_.framerate(_))
        .ifSome(height)(_.height(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(scanType)(_.scanType(_))
        .ifSome(width)(_.width(_))
        .build

    def inputLocation(
      passwordParam: Option[String] = None,
      uri: Option[String] = None,
      username: Option[String] = None
    ): InputLocation =
      InputLocation
        .builder
        .ifSome(passwordParam)(_.passwordParam(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(username)(_.username(_))
        .build

    def inputLossBehavior(
      blackFrameMsec: Option[Int] = None,
      inputLossImageColor: Option[String] = None,
      inputLossImageSlate: Option[InputLocation] = None,
      inputLossImageType: Option[String] = None,
      repeatFrameMsec: Option[Int] = None
    ): InputLossBehavior =
      InputLossBehavior
        .builder
        .ifSome(blackFrameMsec)(_.blackFrameMsec(_))
        .ifSome(inputLossImageColor)(_.inputLossImageColor(_))
        .ifSome(inputLossImageSlate)(_.inputLossImageSlate(_))
        .ifSome(inputLossImageType)(_.inputLossImageType(_))
        .ifSome(repeatFrameMsec)(_.repeatFrameMsec(_))
        .build

    def inputLossFailoverSettings(
      inputLossThresholdMsec: Option[Int] = None
    ): InputLossFailoverSettings =
      InputLossFailoverSettings
        .builder
        .ifSome(inputLossThresholdMsec)(_.inputLossThresholdMsec(_))
        .build

    def inputPrepareScheduleActionSettings(
      inputAttachmentNameReference: Option[String] = None,
      inputClippingSettings: Option[InputClippingSettings] = None,
      urlPath: Option[List[__string]] = None
    ): InputPrepareScheduleActionSettings =
      InputPrepareScheduleActionSettings
        .builder
        .ifSome(inputAttachmentNameReference)(_.inputAttachmentNameReference(_))
        .ifSome(inputClippingSettings)(_.inputClippingSettings(_))
        .ifSome(urlPath)(_.urlPath(_))
        .build

    def inputSecurityGroup(
      arn: Option[String] = None,
      id: Option[String] = None,
      inputs: Option[List[__string]] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      whitelistRules: Option[List[InputWhitelistRule]] = None
    ): InputSecurityGroup =
      InputSecurityGroup
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(whitelistRules)(_.whitelistRules(_))
        .build

    def inputSecurityGroupWhitelistRequest(
      tags: Option[Tags] = None,
      whitelistRules: Option[List[InputWhitelistRuleCidr]] = None
    ): InputSecurityGroupWhitelistRequest =
      InputSecurityGroupWhitelistRequest
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(whitelistRules)(_.whitelistRules(_))
        .build

    def inputSettings(
      audioSelectors: Option[List[AudioSelector]] = None,
      captionSelectors: Option[List[CaptionSelector]] = None,
      deblockFilter: Option[String] = None,
      denoiseFilter: Option[String] = None,
      filterStrength: Option[Int] = None,
      inputFilter: Option[String] = None,
      networkInputSettings: Option[NetworkInputSettings] = None,
      smpte2038DataPreference: Option[String] = None,
      sourceEndBehavior: Option[String] = None,
      videoSelector: Option[VideoSelector] = None
    ): InputSettings =
      InputSettings
        .builder
        .ifSome(audioSelectors)(_.audioSelectors(_))
        .ifSome(captionSelectors)(_.captionSelectors(_))
        .ifSome(deblockFilter)(_.deblockFilter(_))
        .ifSome(denoiseFilter)(_.denoiseFilter(_))
        .ifSome(filterStrength)(_.filterStrength(_))
        .ifSome(inputFilter)(_.inputFilter(_))
        .ifSome(networkInputSettings)(_.networkInputSettings(_))
        .ifSome(smpte2038DataPreference)(_.smpte2038DataPreference(_))
        .ifSome(sourceEndBehavior)(_.sourceEndBehavior(_))
        .ifSome(videoSelector)(_.videoSelector(_))
        .build

    def inputSource(
      passwordParam: Option[String] = None,
      url: Option[String] = None,
      username: Option[String] = None
    ): InputSource =
      InputSource
        .builder
        .ifSome(passwordParam)(_.passwordParam(_))
        .ifSome(url)(_.url(_))
        .ifSome(username)(_.username(_))
        .build

    def inputSourceRequest(
      passwordParam: Option[String] = None,
      url: Option[String] = None,
      username: Option[String] = None
    ): InputSourceRequest =
      InputSourceRequest
        .builder
        .ifSome(passwordParam)(_.passwordParam(_))
        .ifSome(url)(_.url(_))
        .ifSome(username)(_.username(_))
        .build

    def inputSpecification(
      codec: Option[String] = None,
      maximumBitrate: Option[String] = None,
      resolution: Option[String] = None
    ): InputSpecification =
      InputSpecification
        .builder
        .ifSome(codec)(_.codec(_))
        .ifSome(maximumBitrate)(_.maximumBitrate(_))
        .ifSome(resolution)(_.resolution(_))
        .build

    def inputSwitchScheduleActionSettings(
      inputAttachmentNameReference: Option[String] = None,
      inputClippingSettings: Option[InputClippingSettings] = None,
      urlPath: Option[List[__string]] = None
    ): InputSwitchScheduleActionSettings =
      InputSwitchScheduleActionSettings
        .builder
        .ifSome(inputAttachmentNameReference)(_.inputAttachmentNameReference(_))
        .ifSome(inputClippingSettings)(_.inputClippingSettings(_))
        .ifSome(urlPath)(_.urlPath(_))
        .build

    def inputVpcRequest(
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None
    ): InputVpcRequest =
      InputVpcRequest
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def inputWhitelistRule(
      cidr: Option[String] = None
    ): InputWhitelistRule =
      InputWhitelistRule
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def inputWhitelistRuleCidr(
      cidr: Option[String] = None
    ): InputWhitelistRuleCidr =
      InputWhitelistRuleCidr
        .builder
        .ifSome(cidr)(_.cidr(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServiceError(
      message: Option[String] = None
    ): InternalServiceError =
      InternalServiceError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequest(
      message: Option[String] = None
    ): InvalidRequest =
      InvalidRequest
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyProviderSettings(
      staticKeySettings: Option[StaticKeySettings] = None
    ): KeyProviderSettings =
      KeyProviderSettings
        .builder
        .ifSome(staticKeySettings)(_.staticKeySettings(_))
        .build

    def limitExceeded(
      message: Option[String] = None
    ): LimitExceeded =
      LimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listChannelsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListChannelsRequest =
      ListChannelsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
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

    def listChannelsResultModel(
      channels: Option[List[ChannelSummary]] = None,
      nextToken: Option[String] = None
    ): ListChannelsResultModel =
      ListChannelsResultModel
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputDeviceTransfersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      transferType: Option[String] = None
    ): ListInputDeviceTransfersRequest =
      ListInputDeviceTransfersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(transferType)(_.transferType(_))
        .build

    def listInputDeviceTransfersResponse(
      inputDeviceTransfers: Option[List[TransferringInputDeviceSummary]] = None,
      nextToken: Option[String] = None
    ): ListInputDeviceTransfersResponse =
      ListInputDeviceTransfersResponse
        .builder
        .ifSome(inputDeviceTransfers)(_.inputDeviceTransfers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputDeviceTransfersResultModel(
      inputDeviceTransfers: Option[List[TransferringInputDeviceSummary]] = None,
      nextToken: Option[String] = None
    ): ListInputDeviceTransfersResultModel =
      ListInputDeviceTransfersResultModel
        .builder
        .ifSome(inputDeviceTransfers)(_.inputDeviceTransfers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputDevicesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInputDevicesRequest =
      ListInputDevicesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputDevicesResponse(
      inputDevices: Option[List[InputDeviceSummary]] = None,
      nextToken: Option[String] = None
    ): ListInputDevicesResponse =
      ListInputDevicesResponse
        .builder
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputDevicesResultModel(
      inputDevices: Option[List[InputDeviceSummary]] = None,
      nextToken: Option[String] = None
    ): ListInputDevicesResultModel =
      ListInputDevicesResultModel
        .builder
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputSecurityGroupsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInputSecurityGroupsRequest =
      ListInputSecurityGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputSecurityGroupsResponse(
      inputSecurityGroups: Option[List[InputSecurityGroup]] = None,
      nextToken: Option[String] = None
    ): ListInputSecurityGroupsResponse =
      ListInputSecurityGroupsResponse
        .builder
        .ifSome(inputSecurityGroups)(_.inputSecurityGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputSecurityGroupsResultModel(
      inputSecurityGroups: Option[List[InputSecurityGroup]] = None,
      nextToken: Option[String] = None
    ): ListInputSecurityGroupsResultModel =
      ListInputSecurityGroupsResultModel
        .builder
        .ifSome(inputSecurityGroups)(_.inputSecurityGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInputsRequest =
      ListInputsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputsResponse(
      inputs: Option[List[Input]] = None,
      nextToken: Option[String] = None
    ): ListInputsResponse =
      ListInputsResponse
        .builder
        .ifSome(inputs)(_.inputs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInputsResultModel(
      inputs: Option[List[Input]] = None,
      nextToken: Option[String] = None
    ): ListInputsResultModel =
      ListInputsResultModel
        .builder
        .ifSome(inputs)(_.inputs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMultiplexProgramsRequest(
      maxResults: Option[Int] = None,
      multiplexId: Option[String] = None,
      nextToken: Option[String] = None
    ): ListMultiplexProgramsRequest =
      ListMultiplexProgramsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMultiplexProgramsResponse(
      multiplexPrograms: Option[List[MultiplexProgramSummary]] = None,
      nextToken: Option[String] = None
    ): ListMultiplexProgramsResponse =
      ListMultiplexProgramsResponse
        .builder
        .ifSome(multiplexPrograms)(_.multiplexPrograms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMultiplexProgramsResultModel(
      multiplexPrograms: Option[List[MultiplexProgramSummary]] = None,
      nextToken: Option[String] = None
    ): ListMultiplexProgramsResultModel =
      ListMultiplexProgramsResultModel
        .builder
        .ifSome(multiplexPrograms)(_.multiplexPrograms(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMultiplexesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMultiplexesRequest =
      ListMultiplexesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMultiplexesResponse(
      multiplexes: Option[List[MultiplexSummary]] = None,
      nextToken: Option[String] = None
    ): ListMultiplexesResponse =
      ListMultiplexesResponse
        .builder
        .ifSome(multiplexes)(_.multiplexes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMultiplexesResultModel(
      multiplexes: Option[List[MultiplexSummary]] = None,
      nextToken: Option[String] = None
    ): ListMultiplexesResultModel =
      ListMultiplexesResultModel
        .builder
        .ifSome(multiplexes)(_.multiplexes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOfferingsRequest(
      channelClass: Option[String] = None,
      channelConfiguration: Option[String] = None,
      codec: Option[String] = None,
      duration: Option[String] = None,
      maxResults: Option[Int] = None,
      maximumBitrate: Option[String] = None,
      maximumFramerate: Option[String] = None,
      nextToken: Option[String] = None,
      resolution: Option[String] = None,
      resourceType: Option[String] = None,
      specialFeature: Option[String] = None,
      videoQuality: Option[String] = None
    ): ListOfferingsRequest =
      ListOfferingsRequest
        .builder
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(channelConfiguration)(_.channelConfiguration(_))
        .ifSome(codec)(_.codec(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(maximumBitrate)(_.maximumBitrate(_))
        .ifSome(maximumFramerate)(_.maximumFramerate(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(specialFeature)(_.specialFeature(_))
        .ifSome(videoQuality)(_.videoQuality(_))
        .build

    def listOfferingsResponse(
      nextToken: Option[String] = None,
      offerings: Option[List[Offering]] = None
    ): ListOfferingsResponse =
      ListOfferingsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(offerings)(_.offerings(_))
        .build

    def listOfferingsResultModel(
      nextToken: Option[String] = None,
      offerings: Option[List[Offering]] = None
    ): ListOfferingsResultModel =
      ListOfferingsResultModel
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(offerings)(_.offerings(_))
        .build

    def listReservationsRequest(
      channelClass: Option[String] = None,
      codec: Option[String] = None,
      maxResults: Option[Int] = None,
      maximumBitrate: Option[String] = None,
      maximumFramerate: Option[String] = None,
      nextToken: Option[String] = None,
      resolution: Option[String] = None,
      resourceType: Option[String] = None,
      specialFeature: Option[String] = None,
      videoQuality: Option[String] = None
    ): ListReservationsRequest =
      ListReservationsRequest
        .builder
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(codec)(_.codec(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(maximumBitrate)(_.maximumBitrate(_))
        .ifSome(maximumFramerate)(_.maximumFramerate(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(specialFeature)(_.specialFeature(_))
        .ifSome(videoQuality)(_.videoQuality(_))
        .build

    def listReservationsResponse(
      nextToken: Option[String] = None,
      reservations: Option[List[Reservation]] = None
    ): ListReservationsResponse =
      ListReservationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reservations)(_.reservations(_))
        .build

    def listReservationsResultModel(
      nextToken: Option[String] = None,
      reservations: Option[List[Reservation]] = None
    ): ListReservationsResultModel =
      ListReservationsResultModel
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reservations)(_.reservations(_))
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

    def m2tsSettings(
      absentInputAudioBehavior: Option[String] = None,
      arib: Option[String] = None,
      aribCaptionsPid: Option[String] = None,
      aribCaptionsPidControl: Option[String] = None,
      audioBufferModel: Option[String] = None,
      audioFramesPerPes: Option[Int] = None,
      audioPids: Option[String] = None,
      audioStreamType: Option[String] = None,
      bitrate: Option[Int] = None,
      bufferModel: Option[String] = None,
      ccDescriptor: Option[String] = None,
      dvbNitSettings: Option[DvbNitSettings] = None,
      dvbSdtSettings: Option[DvbSdtSettings] = None,
      dvbSubPids: Option[String] = None,
      dvbTdtSettings: Option[DvbTdtSettings] = None,
      dvbTeletextPid: Option[String] = None,
      ebif: Option[String] = None,
      ebpAudioInterval: Option[String] = None,
      ebpLookaheadMs: Option[Int] = None,
      ebpPlacement: Option[String] = None,
      ecmPid: Option[String] = None,
      esRateInPes: Option[String] = None,
      etvPlatformPid: Option[String] = None,
      etvSignalPid: Option[String] = None,
      fragmentTime: Option[__doubleMin0] = None,
      klv: Option[String] = None,
      klvDataPids: Option[String] = None,
      nielsenId3Behavior: Option[String] = None,
      nullPacketBitrate: Option[__doubleMin0] = None,
      patInterval: Option[Int] = None,
      pcrControl: Option[String] = None,
      pcrPeriod: Option[Int] = None,
      pcrPid: Option[String] = None,
      pmtInterval: Option[Int] = None,
      pmtPid: Option[String] = None,
      programNum: Option[Int] = None,
      rateMode: Option[String] = None,
      scte27Pids: Option[String] = None,
      scte35Control: Option[String] = None,
      scte35Pid: Option[String] = None,
      segmentationMarkers: Option[String] = None,
      segmentationStyle: Option[String] = None,
      segmentationTime: Option[__doubleMin1] = None,
      timedMetadataBehavior: Option[String] = None,
      timedMetadataPid: Option[String] = None,
      transportStreamId: Option[Int] = None,
      videoPid: Option[String] = None
    ): M2tsSettings =
      M2tsSettings
        .builder
        .ifSome(absentInputAudioBehavior)(_.absentInputAudioBehavior(_))
        .ifSome(arib)(_.arib(_))
        .ifSome(aribCaptionsPid)(_.aribCaptionsPid(_))
        .ifSome(aribCaptionsPidControl)(_.aribCaptionsPidControl(_))
        .ifSome(audioBufferModel)(_.audioBufferModel(_))
        .ifSome(audioFramesPerPes)(_.audioFramesPerPes(_))
        .ifSome(audioPids)(_.audioPids(_))
        .ifSome(audioStreamType)(_.audioStreamType(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bufferModel)(_.bufferModel(_))
        .ifSome(ccDescriptor)(_.ccDescriptor(_))
        .ifSome(dvbNitSettings)(_.dvbNitSettings(_))
        .ifSome(dvbSdtSettings)(_.dvbSdtSettings(_))
        .ifSome(dvbSubPids)(_.dvbSubPids(_))
        .ifSome(dvbTdtSettings)(_.dvbTdtSettings(_))
        .ifSome(dvbTeletextPid)(_.dvbTeletextPid(_))
        .ifSome(ebif)(_.ebif(_))
        .ifSome(ebpAudioInterval)(_.ebpAudioInterval(_))
        .ifSome(ebpLookaheadMs)(_.ebpLookaheadMs(_))
        .ifSome(ebpPlacement)(_.ebpPlacement(_))
        .ifSome(ecmPid)(_.ecmPid(_))
        .ifSome(esRateInPes)(_.esRateInPes(_))
        .ifSome(etvPlatformPid)(_.etvPlatformPid(_))
        .ifSome(etvSignalPid)(_.etvSignalPid(_))
        .ifSome(fragmentTime)(_.fragmentTime(_))
        .ifSome(klv)(_.klv(_))
        .ifSome(klvDataPids)(_.klvDataPids(_))
        .ifSome(nielsenId3Behavior)(_.nielsenId3Behavior(_))
        .ifSome(nullPacketBitrate)(_.nullPacketBitrate(_))
        .ifSome(patInterval)(_.patInterval(_))
        .ifSome(pcrControl)(_.pcrControl(_))
        .ifSome(pcrPeriod)(_.pcrPeriod(_))
        .ifSome(pcrPid)(_.pcrPid(_))
        .ifSome(pmtInterval)(_.pmtInterval(_))
        .ifSome(pmtPid)(_.pmtPid(_))
        .ifSome(programNum)(_.programNum(_))
        .ifSome(rateMode)(_.rateMode(_))
        .ifSome(scte27Pids)(_.scte27Pids(_))
        .ifSome(scte35Control)(_.scte35Control(_))
        .ifSome(scte35Pid)(_.scte35Pid(_))
        .ifSome(segmentationMarkers)(_.segmentationMarkers(_))
        .ifSome(segmentationStyle)(_.segmentationStyle(_))
        .ifSome(segmentationTime)(_.segmentationTime(_))
        .ifSome(timedMetadataBehavior)(_.timedMetadataBehavior(_))
        .ifSome(timedMetadataPid)(_.timedMetadataPid(_))
        .ifSome(transportStreamId)(_.transportStreamId(_))
        .ifSome(videoPid)(_.videoPid(_))
        .build

    def m3u8Settings(
      audioFramesPerPes: Option[Int] = None,
      audioPids: Option[String] = None,
      ecmPid: Option[String] = None,
      nielsenId3Behavior: Option[String] = None,
      patInterval: Option[Int] = None,
      pcrControl: Option[String] = None,
      pcrPeriod: Option[Int] = None,
      pcrPid: Option[String] = None,
      pmtInterval: Option[Int] = None,
      pmtPid: Option[String] = None,
      programNum: Option[Int] = None,
      scte35Behavior: Option[String] = None,
      scte35Pid: Option[String] = None,
      timedMetadataBehavior: Option[String] = None,
      timedMetadataPid: Option[String] = None,
      transportStreamId: Option[Int] = None,
      videoPid: Option[String] = None
    ): M3u8Settings =
      M3u8Settings
        .builder
        .ifSome(audioFramesPerPes)(_.audioFramesPerPes(_))
        .ifSome(audioPids)(_.audioPids(_))
        .ifSome(ecmPid)(_.ecmPid(_))
        .ifSome(nielsenId3Behavior)(_.nielsenId3Behavior(_))
        .ifSome(patInterval)(_.patInterval(_))
        .ifSome(pcrControl)(_.pcrControl(_))
        .ifSome(pcrPeriod)(_.pcrPeriod(_))
        .ifSome(pcrPid)(_.pcrPid(_))
        .ifSome(pmtInterval)(_.pmtInterval(_))
        .ifSome(pmtPid)(_.pmtPid(_))
        .ifSome(programNum)(_.programNum(_))
        .ifSome(scte35Behavior)(_.scte35Behavior(_))
        .ifSome(scte35Pid)(_.scte35Pid(_))
        .ifSome(timedMetadataBehavior)(_.timedMetadataBehavior(_))
        .ifSome(timedMetadataPid)(_.timedMetadataPid(_))
        .ifSome(transportStreamId)(_.transportStreamId(_))
        .ifSome(videoPid)(_.videoPid(_))
        .build

    def mediaConnectFlow(
      flowArn: Option[String] = None
    ): MediaConnectFlow =
      MediaConnectFlow
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def mediaConnectFlowRequest(
      flowArn: Option[String] = None
    ): MediaConnectFlowRequest =
      MediaConnectFlowRequest
        .builder
        .ifSome(flowArn)(_.flowArn(_))
        .build

    def mediaPackageGroupSettings(
      destination: Option[OutputLocationRef] = None
    ): MediaPackageGroupSettings =
      MediaPackageGroupSettings
        .builder
        .ifSome(destination)(_.destination(_))
        .build

    def mediaPackageOutputDestinationSettings(
      channelId: Option[String] = None
    ): MediaPackageOutputDestinationSettings =
      MediaPackageOutputDestinationSettings
        .builder
        .ifSome(channelId)(_.channelId(_))
        .build

    def mediaPackageOutputSettings(

    ): MediaPackageOutputSettings =
      MediaPackageOutputSettings
        .builder

        .build

    def motionGraphicsActivateScheduleActionSettings(
      duration: Option[__longMin0Max86400000] = None,
      passwordParam: Option[String] = None,
      url: Option[String] = None,
      username: Option[String] = None
    ): MotionGraphicsActivateScheduleActionSettings =
      MotionGraphicsActivateScheduleActionSettings
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(passwordParam)(_.passwordParam(_))
        .ifSome(url)(_.url(_))
        .ifSome(username)(_.username(_))
        .build

    def motionGraphicsConfiguration(
      motionGraphicsInsertion: Option[String] = None,
      motionGraphicsSettings: Option[MotionGraphicsSettings] = None
    ): MotionGraphicsConfiguration =
      MotionGraphicsConfiguration
        .builder
        .ifSome(motionGraphicsInsertion)(_.motionGraphicsInsertion(_))
        .ifSome(motionGraphicsSettings)(_.motionGraphicsSettings(_))
        .build

    def motionGraphicsDeactivateScheduleActionSettings(

    ): MotionGraphicsDeactivateScheduleActionSettings =
      MotionGraphicsDeactivateScheduleActionSettings
        .builder

        .build

    def motionGraphicsSettings(
      htmlMotionGraphicsSettings: Option[HtmlMotionGraphicsSettings] = None
    ): MotionGraphicsSettings =
      MotionGraphicsSettings
        .builder
        .ifSome(htmlMotionGraphicsSettings)(_.htmlMotionGraphicsSettings(_))
        .build

    def mp2Settings(
      bitrate: Option[__double] = None,
      codingMode: Option[String] = None,
      sampleRate: Option[__double] = None
    ): Mp2Settings =
      Mp2Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def mpeg2FilterSettings(
      temporalFilterSettings: Option[TemporalFilterSettings] = None
    ): Mpeg2FilterSettings =
      Mpeg2FilterSettings
        .builder
        .ifSome(temporalFilterSettings)(_.temporalFilterSettings(_))
        .build

    def mpeg2Settings(
      adaptiveQuantization: Option[String] = None,
      afdSignaling: Option[String] = None,
      colorMetadata: Option[String] = None,
      colorSpace: Option[String] = None,
      displayAspectRatio: Option[String] = None,
      filterSettings: Option[Mpeg2FilterSettings] = None,
      fixedAfd: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopClosedCadence: Option[Int] = None,
      gopNumBFrames: Option[Int] = None,
      gopSize: Option[__double] = None,
      gopSizeUnits: Option[String] = None,
      scanType: Option[String] = None,
      subgopLength: Option[String] = None,
      timecodeInsertion: Option[String] = None
    ): Mpeg2Settings =
      Mpeg2Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(afdSignaling)(_.afdSignaling(_))
        .ifSome(colorMetadata)(_.colorMetadata(_))
        .ifSome(colorSpace)(_.colorSpace(_))
        .ifSome(displayAspectRatio)(_.displayAspectRatio(_))
        .ifSome(filterSettings)(_.filterSettings(_))
        .ifSome(fixedAfd)(_.fixedAfd(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopClosedCadence)(_.gopClosedCadence(_))
        .ifSome(gopNumBFrames)(_.gopNumBFrames(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(gopSizeUnits)(_.gopSizeUnits(_))
        .ifSome(scanType)(_.scanType(_))
        .ifSome(subgopLength)(_.subgopLength(_))
        .ifSome(timecodeInsertion)(_.timecodeInsertion(_))
        .build

    def msSmoothGroupSettings(
      acquisitionPointId: Option[String] = None,
      audioOnlyTimecodeControl: Option[String] = None,
      certificateMode: Option[String] = None,
      connectionRetryInterval: Option[Int] = None,
      destination: Option[OutputLocationRef] = None,
      eventId: Option[String] = None,
      eventIdMode: Option[String] = None,
      eventStopBehavior: Option[String] = None,
      filecacheDuration: Option[Int] = None,
      fragmentLength: Option[Int] = None,
      inputLossAction: Option[String] = None,
      numRetries: Option[Int] = None,
      restartDelay: Option[Int] = None,
      segmentationMode: Option[String] = None,
      sendDelayMs: Option[Int] = None,
      sparseTrackType: Option[String] = None,
      streamManifestBehavior: Option[String] = None,
      timestampOffset: Option[String] = None,
      timestampOffsetMode: Option[String] = None
    ): MsSmoothGroupSettings =
      MsSmoothGroupSettings
        .builder
        .ifSome(acquisitionPointId)(_.acquisitionPointId(_))
        .ifSome(audioOnlyTimecodeControl)(_.audioOnlyTimecodeControl(_))
        .ifSome(certificateMode)(_.certificateMode(_))
        .ifSome(connectionRetryInterval)(_.connectionRetryInterval(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(eventIdMode)(_.eventIdMode(_))
        .ifSome(eventStopBehavior)(_.eventStopBehavior(_))
        .ifSome(filecacheDuration)(_.filecacheDuration(_))
        .ifSome(fragmentLength)(_.fragmentLength(_))
        .ifSome(inputLossAction)(_.inputLossAction(_))
        .ifSome(numRetries)(_.numRetries(_))
        .ifSome(restartDelay)(_.restartDelay(_))
        .ifSome(segmentationMode)(_.segmentationMode(_))
        .ifSome(sendDelayMs)(_.sendDelayMs(_))
        .ifSome(sparseTrackType)(_.sparseTrackType(_))
        .ifSome(streamManifestBehavior)(_.streamManifestBehavior(_))
        .ifSome(timestampOffset)(_.timestampOffset(_))
        .ifSome(timestampOffsetMode)(_.timestampOffsetMode(_))
        .build

    def msSmoothOutputSettings(
      h265PackagingType: Option[String] = None,
      nameModifier: Option[String] = None
    ): MsSmoothOutputSettings =
      MsSmoothOutputSettings
        .builder
        .ifSome(h265PackagingType)(_.h265PackagingType(_))
        .ifSome(nameModifier)(_.nameModifier(_))
        .build

    def multiplex(
      arn: Option[String] = None,
      availabilityZones: Option[List[__string]] = None,
      destinations: Option[List[MultiplexOutputDestination]] = None,
      id: Option[String] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      programCount: Option[Int] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): Multiplex =
      Multiplex
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(programCount)(_.programCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def multiplexConfigurationValidationError(
      message: Option[String] = None,
      validationErrors: Option[List[ValidationError]] = None
    ): MultiplexConfigurationValidationError =
      MultiplexConfigurationValidationError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def multiplexGroupSettings(

    ): MultiplexGroupSettings =
      MultiplexGroupSettings
        .builder

        .build

    def multiplexMediaConnectOutputDestinationSettings(
      entitlementArn: Option[String] = None
    ): MultiplexMediaConnectOutputDestinationSettings =
      MultiplexMediaConnectOutputDestinationSettings
        .builder
        .ifSome(entitlementArn)(_.entitlementArn(_))
        .build

    def multiplexOutputDestination(
      mediaConnectSettings: Option[MultiplexMediaConnectOutputDestinationSettings] = None
    ): MultiplexOutputDestination =
      MultiplexOutputDestination
        .builder
        .ifSome(mediaConnectSettings)(_.mediaConnectSettings(_))
        .build

    def multiplexOutputSettings(
      destination: Option[OutputLocationRef] = None
    ): MultiplexOutputSettings =
      MultiplexOutputSettings
        .builder
        .ifSome(destination)(_.destination(_))
        .build

    def multiplexProgram(
      channelId: Option[String] = None,
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None,
      packetIdentifiersMap: Option[MultiplexProgramPacketIdentifiersMap] = None,
      pipelineDetails: Option[List[MultiplexProgramPipelineDetail]] = None,
      programName: Option[String] = None
    ): MultiplexProgram =
      MultiplexProgram
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .ifSome(packetIdentifiersMap)(_.packetIdentifiersMap(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(programName)(_.programName(_))
        .build

    def multiplexProgramChannelDestinationSettings(
      multiplexId: Option[String] = None,
      programName: Option[String] = None
    ): MultiplexProgramChannelDestinationSettings =
      MultiplexProgramChannelDestinationSettings
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(programName)(_.programName(_))
        .build

    def multiplexProgramPacketIdentifiersMap(
      audioPids: Option[List[__integer]] = None,
      dvbSubPids: Option[List[__integer]] = None,
      dvbTeletextPid: Option[Int] = None,
      etvPlatformPid: Option[Int] = None,
      etvSignalPid: Option[Int] = None,
      klvDataPids: Option[List[__integer]] = None,
      pcrPid: Option[Int] = None,
      pmtPid: Option[Int] = None,
      privateMetadataPid: Option[Int] = None,
      scte27Pids: Option[List[__integer]] = None,
      scte35Pid: Option[Int] = None,
      timedMetadataPid: Option[Int] = None,
      videoPid: Option[Int] = None
    ): MultiplexProgramPacketIdentifiersMap =
      MultiplexProgramPacketIdentifiersMap
        .builder
        .ifSome(audioPids)(_.audioPids(_))
        .ifSome(dvbSubPids)(_.dvbSubPids(_))
        .ifSome(dvbTeletextPid)(_.dvbTeletextPid(_))
        .ifSome(etvPlatformPid)(_.etvPlatformPid(_))
        .ifSome(etvSignalPid)(_.etvSignalPid(_))
        .ifSome(klvDataPids)(_.klvDataPids(_))
        .ifSome(pcrPid)(_.pcrPid(_))
        .ifSome(pmtPid)(_.pmtPid(_))
        .ifSome(privateMetadataPid)(_.privateMetadataPid(_))
        .ifSome(scte27Pids)(_.scte27Pids(_))
        .ifSome(scte35Pid)(_.scte35Pid(_))
        .ifSome(timedMetadataPid)(_.timedMetadataPid(_))
        .ifSome(videoPid)(_.videoPid(_))
        .build

    def multiplexProgramPipelineDetail(
      activeChannelPipeline: Option[String] = None,
      pipelineId: Option[String] = None
    ): MultiplexProgramPipelineDetail =
      MultiplexProgramPipelineDetail
        .builder
        .ifSome(activeChannelPipeline)(_.activeChannelPipeline(_))
        .ifSome(pipelineId)(_.pipelineId(_))
        .build

    def multiplexProgramServiceDescriptor(
      providerName: Option[String] = None,
      serviceName: Option[String] = None
    ): MultiplexProgramServiceDescriptor =
      MultiplexProgramServiceDescriptor
        .builder
        .ifSome(providerName)(_.providerName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def multiplexProgramSettings(
      preferredChannelPipeline: Option[String] = None,
      programNumber: Option[Int] = None,
      serviceDescriptor: Option[MultiplexProgramServiceDescriptor] = None,
      videoSettings: Option[MultiplexVideoSettings] = None
    ): MultiplexProgramSettings =
      MultiplexProgramSettings
        .builder
        .ifSome(preferredChannelPipeline)(_.preferredChannelPipeline(_))
        .ifSome(programNumber)(_.programNumber(_))
        .ifSome(serviceDescriptor)(_.serviceDescriptor(_))
        .ifSome(videoSettings)(_.videoSettings(_))
        .build

    def multiplexProgramSummary(
      channelId: Option[String] = None,
      programName: Option[String] = None
    ): MultiplexProgramSummary =
      MultiplexProgramSummary
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(programName)(_.programName(_))
        .build

    def multiplexSettings(
      maximumVideoBufferDelayMilliseconds: Option[Int] = None,
      transportStreamBitrate: Option[Int] = None,
      transportStreamId: Option[Int] = None,
      transportStreamReservedBitrate: Option[Int] = None
    ): MultiplexSettings =
      MultiplexSettings
        .builder
        .ifSome(maximumVideoBufferDelayMilliseconds)(_.maximumVideoBufferDelayMilliseconds(_))
        .ifSome(transportStreamBitrate)(_.transportStreamBitrate(_))
        .ifSome(transportStreamId)(_.transportStreamId(_))
        .ifSome(transportStreamReservedBitrate)(_.transportStreamReservedBitrate(_))
        .build

    def multiplexSettingsSummary(
      transportStreamBitrate: Option[Int] = None
    ): MultiplexSettingsSummary =
      MultiplexSettingsSummary
        .builder
        .ifSome(transportStreamBitrate)(_.transportStreamBitrate(_))
        .build

    def multiplexStatmuxVideoSettings(
      maximumBitrate: Option[Int] = None,
      minimumBitrate: Option[Int] = None,
      priority: Option[Int] = None
    ): MultiplexStatmuxVideoSettings =
      MultiplexStatmuxVideoSettings
        .builder
        .ifSome(maximumBitrate)(_.maximumBitrate(_))
        .ifSome(minimumBitrate)(_.minimumBitrate(_))
        .ifSome(priority)(_.priority(_))
        .build

    def multiplexSummary(
      arn: Option[String] = None,
      availabilityZones: Option[List[__string]] = None,
      id: Option[String] = None,
      multiplexSettings: Option[MultiplexSettingsSummary] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      programCount: Option[Int] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): MultiplexSummary =
      MultiplexSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(id)(_.id(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(programCount)(_.programCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def multiplexVideoSettings(
      constantBitrate: Option[Int] = None,
      statmuxSettings: Option[MultiplexStatmuxVideoSettings] = None
    ): MultiplexVideoSettings =
      MultiplexVideoSettings
        .builder
        .ifSome(constantBitrate)(_.constantBitrate(_))
        .ifSome(statmuxSettings)(_.statmuxSettings(_))
        .build

    def networkInputSettings(
      hlsInputSettings: Option[HlsInputSettings] = None,
      serverValidation: Option[String] = None
    ): NetworkInputSettings =
      NetworkInputSettings
        .builder
        .ifSome(hlsInputSettings)(_.hlsInputSettings(_))
        .ifSome(serverValidation)(_.serverValidation(_))
        .build

    def nielsenConfiguration(
      distributorId: Option[String] = None,
      nielsenPcmToId3Tagging: Option[String] = None
    ): NielsenConfiguration =
      NielsenConfiguration
        .builder
        .ifSome(distributorId)(_.distributorId(_))
        .ifSome(nielsenPcmToId3Tagging)(_.nielsenPcmToId3Tagging(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def offering(
      arn: Option[String] = None,
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      fixedPrice: Option[__double] = None,
      offeringDescription: Option[String] = None,
      offeringId: Option[String] = None,
      offeringType: Option[String] = None,
      region: Option[String] = None,
      resourceSpecification: Option[ReservationResourceSpecification] = None,
      usagePrice: Option[__double] = None
    ): Offering =
      Offering
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(region)(_.region(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .build

    def output(
      audioDescriptionNames: Option[List[__string]] = None,
      captionDescriptionNames: Option[List[__string]] = None,
      outputName: Option[String] = None,
      outputSettings: Option[OutputSettings] = None,
      videoDescriptionName: Option[String] = None
    ): Output =
      Output
        .builder
        .ifSome(audioDescriptionNames)(_.audioDescriptionNames(_))
        .ifSome(captionDescriptionNames)(_.captionDescriptionNames(_))
        .ifSome(outputName)(_.outputName(_))
        .ifSome(outputSettings)(_.outputSettings(_))
        .ifSome(videoDescriptionName)(_.videoDescriptionName(_))
        .build

    def outputDestination(
      id: Option[String] = None,
      mediaPackageSettings: Option[List[MediaPackageOutputDestinationSettings]] = None,
      multiplexSettings: Option[MultiplexProgramChannelDestinationSettings] = None,
      settings: Option[List[OutputDestinationSettings]] = None
    ): OutputDestination =
      OutputDestination
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(mediaPackageSettings)(_.mediaPackageSettings(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(settings)(_.settings(_))
        .build

    def outputDestinationSettings(
      passwordParam: Option[String] = None,
      streamName: Option[String] = None,
      url: Option[String] = None,
      username: Option[String] = None
    ): OutputDestinationSettings =
      OutputDestinationSettings
        .builder
        .ifSome(passwordParam)(_.passwordParam(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(url)(_.url(_))
        .ifSome(username)(_.username(_))
        .build

    def outputGroup(
      name: Option[String] = None,
      outputGroupSettings: Option[OutputGroupSettings] = None,
      outputs: Option[List[Output]] = None
    ): OutputGroup =
      OutputGroup
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(outputGroupSettings)(_.outputGroupSettings(_))
        .ifSome(outputs)(_.outputs(_))
        .build

    def outputGroupSettings(
      archiveGroupSettings: Option[ArchiveGroupSettings] = None,
      frameCaptureGroupSettings: Option[FrameCaptureGroupSettings] = None,
      hlsGroupSettings: Option[HlsGroupSettings] = None,
      mediaPackageGroupSettings: Option[MediaPackageGroupSettings] = None,
      msSmoothGroupSettings: Option[MsSmoothGroupSettings] = None,
      multiplexGroupSettings: Option[MultiplexGroupSettings] = None,
      rtmpGroupSettings: Option[RtmpGroupSettings] = None,
      udpGroupSettings: Option[UdpGroupSettings] = None
    ): OutputGroupSettings =
      OutputGroupSettings
        .builder
        .ifSome(archiveGroupSettings)(_.archiveGroupSettings(_))
        .ifSome(frameCaptureGroupSettings)(_.frameCaptureGroupSettings(_))
        .ifSome(hlsGroupSettings)(_.hlsGroupSettings(_))
        .ifSome(mediaPackageGroupSettings)(_.mediaPackageGroupSettings(_))
        .ifSome(msSmoothGroupSettings)(_.msSmoothGroupSettings(_))
        .ifSome(multiplexGroupSettings)(_.multiplexGroupSettings(_))
        .ifSome(rtmpGroupSettings)(_.rtmpGroupSettings(_))
        .ifSome(udpGroupSettings)(_.udpGroupSettings(_))
        .build

    def outputLocationRef(
      destinationRefId: Option[String] = None
    ): OutputLocationRef =
      OutputLocationRef
        .builder
        .ifSome(destinationRefId)(_.destinationRefId(_))
        .build

    def outputSettings(
      archiveOutputSettings: Option[ArchiveOutputSettings] = None,
      frameCaptureOutputSettings: Option[FrameCaptureOutputSettings] = None,
      hlsOutputSettings: Option[HlsOutputSettings] = None,
      mediaPackageOutputSettings: Option[MediaPackageOutputSettings] = None,
      msSmoothOutputSettings: Option[MsSmoothOutputSettings] = None,
      multiplexOutputSettings: Option[MultiplexOutputSettings] = None,
      rtmpOutputSettings: Option[RtmpOutputSettings] = None,
      udpOutputSettings: Option[UdpOutputSettings] = None
    ): OutputSettings =
      OutputSettings
        .builder
        .ifSome(archiveOutputSettings)(_.archiveOutputSettings(_))
        .ifSome(frameCaptureOutputSettings)(_.frameCaptureOutputSettings(_))
        .ifSome(hlsOutputSettings)(_.hlsOutputSettings(_))
        .ifSome(mediaPackageOutputSettings)(_.mediaPackageOutputSettings(_))
        .ifSome(msSmoothOutputSettings)(_.msSmoothOutputSettings(_))
        .ifSome(multiplexOutputSettings)(_.multiplexOutputSettings(_))
        .ifSome(rtmpOutputSettings)(_.rtmpOutputSettings(_))
        .ifSome(udpOutputSettings)(_.udpOutputSettings(_))
        .build

    def passThroughSettings(

    ): PassThroughSettings =
      PassThroughSettings
        .builder

        .build

    def pauseStateScheduleActionSettings(
      pipelines: Option[List[PipelinePauseStateSettings]] = None
    ): PauseStateScheduleActionSettings =
      PauseStateScheduleActionSettings
        .builder
        .ifSome(pipelines)(_.pipelines(_))
        .build

    def pipelineDetail(
      activeInputAttachmentName: Option[String] = None,
      activeInputSwitchActionName: Option[String] = None,
      activeMotionGraphicsActionName: Option[String] = None,
      activeMotionGraphicsUri: Option[String] = None,
      pipelineId: Option[String] = None
    ): PipelineDetail =
      PipelineDetail
        .builder
        .ifSome(activeInputAttachmentName)(_.activeInputAttachmentName(_))
        .ifSome(activeInputSwitchActionName)(_.activeInputSwitchActionName(_))
        .ifSome(activeMotionGraphicsActionName)(_.activeMotionGraphicsActionName(_))
        .ifSome(activeMotionGraphicsUri)(_.activeMotionGraphicsUri(_))
        .ifSome(pipelineId)(_.pipelineId(_))
        .build

    def pipelinePauseStateSettings(
      pipelineId: Option[String] = None
    ): PipelinePauseStateSettings =
      PipelinePauseStateSettings
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .build

    def purchaseOffering(
      count: Option[Int] = None,
      name: Option[String] = None,
      requestId: Option[String] = None,
      start: Option[String] = None,
      tags: Option[Tags] = None
    ): PurchaseOffering =
      PurchaseOffering
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(name)(_.name(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(start)(_.start(_))
        .ifSome(tags)(_.tags(_))
        .build

    def purchaseOfferingRequest(
      count: Option[Int] = None,
      name: Option[String] = None,
      offeringId: Option[String] = None,
      requestId: Option[String] = None,
      start: Option[String] = None,
      tags: Option[Tags] = None
    ): PurchaseOfferingRequest =
      PurchaseOfferingRequest
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(name)(_.name(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(start)(_.start(_))
        .ifSome(tags)(_.tags(_))
        .build

    def purchaseOfferingResponse(
      reservation: Option[Reservation] = None
    ): PurchaseOfferingResponse =
      PurchaseOfferingResponse
        .builder
        .ifSome(reservation)(_.reservation(_))
        .build

    def purchaseOfferingResultModel(
      reservation: Option[Reservation] = None
    ): PurchaseOfferingResultModel =
      PurchaseOfferingResultModel
        .builder
        .ifSome(reservation)(_.reservation(_))
        .build

    def rawSettings(

    ): RawSettings =
      RawSettings
        .builder

        .build

    def rec601Settings(

    ): Rec601Settings =
      Rec601Settings
        .builder

        .build

    def rec709Settings(

    ): Rec709Settings =
      Rec709Settings
        .builder

        .build

    def rejectInputDeviceTransferRequest(
      inputDeviceId: Option[String] = None
    ): RejectInputDeviceTransferRequest =
      RejectInputDeviceTransferRequest
        .builder
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .build

    def rejectInputDeviceTransferResponse(

    ): RejectInputDeviceTransferResponse =
      RejectInputDeviceTransferResponse
        .builder

        .build

    def remixSettings(
      channelMappings: Option[List[AudioChannelMapping]] = None,
      channelsIn: Option[Int] = None,
      channelsOut: Option[Int] = None
    ): RemixSettings =
      RemixSettings
        .builder
        .ifSome(channelMappings)(_.channelMappings(_))
        .ifSome(channelsIn)(_.channelsIn(_))
        .ifSome(channelsOut)(_.channelsOut(_))
        .build

    def reservation(
      arn: Option[String] = None,
      count: Option[Int] = None,
      currencyCode: Option[String] = None,
      duration: Option[Int] = None,
      durationUnits: Option[String] = None,
      end: Option[String] = None,
      fixedPrice: Option[__double] = None,
      name: Option[String] = None,
      offeringDescription: Option[String] = None,
      offeringId: Option[String] = None,
      offeringType: Option[String] = None,
      region: Option[String] = None,
      reservationId: Option[String] = None,
      resourceSpecification: Option[ReservationResourceSpecification] = None,
      start: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      usagePrice: Option[__double] = None
    ): Reservation =
      Reservation
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(count)(_.count(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(durationUnits)(_.durationUnits(_))
        .ifSome(end)(_.end(_))
        .ifSome(fixedPrice)(_.fixedPrice(_))
        .ifSome(name)(_.name(_))
        .ifSome(offeringDescription)(_.offeringDescription(_))
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(offeringType)(_.offeringType(_))
        .ifSome(region)(_.region(_))
        .ifSome(reservationId)(_.reservationId(_))
        .ifSome(resourceSpecification)(_.resourceSpecification(_))
        .ifSome(start)(_.start(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(usagePrice)(_.usagePrice(_))
        .build

    def reservationResourceSpecification(
      channelClass: Option[String] = None,
      codec: Option[String] = None,
      maximumBitrate: Option[String] = None,
      maximumFramerate: Option[String] = None,
      resolution: Option[String] = None,
      resourceType: Option[String] = None,
      specialFeature: Option[String] = None,
      videoQuality: Option[String] = None
    ): ReservationResourceSpecification =
      ReservationResourceSpecification
        .builder
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(codec)(_.codec(_))
        .ifSome(maximumBitrate)(_.maximumBitrate(_))
        .ifSome(maximumFramerate)(_.maximumFramerate(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(specialFeature)(_.specialFeature(_))
        .ifSome(videoQuality)(_.videoQuality(_))
        .build

    def resourceConflict(
      message: Option[String] = None
    ): ResourceConflict =
      ResourceConflict
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFound(
      message: Option[String] = None
    ): ResourceNotFound =
      ResourceNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rtmpCaptionInfoDestinationSettings(

    ): RtmpCaptionInfoDestinationSettings =
      RtmpCaptionInfoDestinationSettings
        .builder

        .build

    def rtmpGroupSettings(
      adMarkers: Option[List[RtmpAdMarkers]] = None,
      authenticationScheme: Option[String] = None,
      cacheFullBehavior: Option[String] = None,
      cacheLength: Option[Int] = None,
      captionData: Option[String] = None,
      inputLossAction: Option[String] = None,
      restartDelay: Option[Int] = None
    ): RtmpGroupSettings =
      RtmpGroupSettings
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(authenticationScheme)(_.authenticationScheme(_))
        .ifSome(cacheFullBehavior)(_.cacheFullBehavior(_))
        .ifSome(cacheLength)(_.cacheLength(_))
        .ifSome(captionData)(_.captionData(_))
        .ifSome(inputLossAction)(_.inputLossAction(_))
        .ifSome(restartDelay)(_.restartDelay(_))
        .build

    def rtmpOutputSettings(
      certificateMode: Option[String] = None,
      connectionRetryInterval: Option[Int] = None,
      destination: Option[OutputLocationRef] = None,
      numRetries: Option[Int] = None
    ): RtmpOutputSettings =
      RtmpOutputSettings
        .builder
        .ifSome(certificateMode)(_.certificateMode(_))
        .ifSome(connectionRetryInterval)(_.connectionRetryInterval(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(numRetries)(_.numRetries(_))
        .build

    def scheduleAction(
      actionName: Option[String] = None,
      scheduleActionSettings: Option[ScheduleActionSettings] = None,
      scheduleActionStartSettings: Option[ScheduleActionStartSettings] = None
    ): ScheduleAction =
      ScheduleAction
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(scheduleActionSettings)(_.scheduleActionSettings(_))
        .ifSome(scheduleActionStartSettings)(_.scheduleActionStartSettings(_))
        .build

    def scheduleActionSettings(
      hlsId3SegmentTaggingSettings: Option[HlsId3SegmentTaggingScheduleActionSettings] = None,
      hlsTimedMetadataSettings: Option[HlsTimedMetadataScheduleActionSettings] = None,
      inputPrepareSettings: Option[InputPrepareScheduleActionSettings] = None,
      inputSwitchSettings: Option[InputSwitchScheduleActionSettings] = None,
      motionGraphicsImageActivateSettings: Option[MotionGraphicsActivateScheduleActionSettings] = None,
      motionGraphicsImageDeactivateSettings: Option[MotionGraphicsDeactivateScheduleActionSettings] = None,
      pauseStateSettings: Option[PauseStateScheduleActionSettings] = None,
      scte35ReturnToNetworkSettings: Option[Scte35ReturnToNetworkScheduleActionSettings] = None,
      scte35SpliceInsertSettings: Option[Scte35SpliceInsertScheduleActionSettings] = None,
      scte35TimeSignalSettings: Option[Scte35TimeSignalScheduleActionSettings] = None,
      staticImageActivateSettings: Option[StaticImageActivateScheduleActionSettings] = None,
      staticImageDeactivateSettings: Option[StaticImageDeactivateScheduleActionSettings] = None
    ): ScheduleActionSettings =
      ScheduleActionSettings
        .builder
        .ifSome(hlsId3SegmentTaggingSettings)(_.hlsId3SegmentTaggingSettings(_))
        .ifSome(hlsTimedMetadataSettings)(_.hlsTimedMetadataSettings(_))
        .ifSome(inputPrepareSettings)(_.inputPrepareSettings(_))
        .ifSome(inputSwitchSettings)(_.inputSwitchSettings(_))
        .ifSome(motionGraphicsImageActivateSettings)(_.motionGraphicsImageActivateSettings(_))
        .ifSome(motionGraphicsImageDeactivateSettings)(_.motionGraphicsImageDeactivateSettings(_))
        .ifSome(pauseStateSettings)(_.pauseStateSettings(_))
        .ifSome(scte35ReturnToNetworkSettings)(_.scte35ReturnToNetworkSettings(_))
        .ifSome(scte35SpliceInsertSettings)(_.scte35SpliceInsertSettings(_))
        .ifSome(scte35TimeSignalSettings)(_.scte35TimeSignalSettings(_))
        .ifSome(staticImageActivateSettings)(_.staticImageActivateSettings(_))
        .ifSome(staticImageDeactivateSettings)(_.staticImageDeactivateSettings(_))
        .build

    def scheduleActionStartSettings(
      fixedModeScheduleActionStartSettings: Option[FixedModeScheduleActionStartSettings] = None,
      followModeScheduleActionStartSettings: Option[FollowModeScheduleActionStartSettings] = None,
      immediateModeScheduleActionStartSettings: Option[ImmediateModeScheduleActionStartSettings] = None
    ): ScheduleActionStartSettings =
      ScheduleActionStartSettings
        .builder
        .ifSome(fixedModeScheduleActionStartSettings)(_.fixedModeScheduleActionStartSettings(_))
        .ifSome(followModeScheduleActionStartSettings)(_.followModeScheduleActionStartSettings(_))
        .ifSome(immediateModeScheduleActionStartSettings)(_.immediateModeScheduleActionStartSettings(_))
        .build

    def scheduleDeleteResultModel(

    ): ScheduleDeleteResultModel =
      ScheduleDeleteResultModel
        .builder

        .build

    def scheduleDescribeResultModel(
      nextToken: Option[String] = None,
      scheduleActions: Option[List[ScheduleAction]] = None
    ): ScheduleDescribeResultModel =
      ScheduleDescribeResultModel
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(scheduleActions)(_.scheduleActions(_))
        .build

    def scte20PlusEmbeddedDestinationSettings(

    ): Scte20PlusEmbeddedDestinationSettings =
      Scte20PlusEmbeddedDestinationSettings
        .builder

        .build

    def scte20SourceSettings(
      convert608To708: Option[String] = None,
      source608ChannelNumber: Option[Int] = None
    ): Scte20SourceSettings =
      Scte20SourceSettings
        .builder
        .ifSome(convert608To708)(_.convert608To708(_))
        .ifSome(source608ChannelNumber)(_.source608ChannelNumber(_))
        .build

    def scte27DestinationSettings(

    ): Scte27DestinationSettings =
      Scte27DestinationSettings
        .builder

        .build

    def scte27SourceSettings(
      ocrLanguage: Option[String] = None,
      pid: Option[Int] = None
    ): Scte27SourceSettings =
      Scte27SourceSettings
        .builder
        .ifSome(ocrLanguage)(_.ocrLanguage(_))
        .ifSome(pid)(_.pid(_))
        .build

    def scte35DeliveryRestrictions(
      archiveAllowedFlag: Option[String] = None,
      deviceRestrictions: Option[String] = None,
      noRegionalBlackoutFlag: Option[String] = None,
      webDeliveryAllowedFlag: Option[String] = None
    ): Scte35DeliveryRestrictions =
      Scte35DeliveryRestrictions
        .builder
        .ifSome(archiveAllowedFlag)(_.archiveAllowedFlag(_))
        .ifSome(deviceRestrictions)(_.deviceRestrictions(_))
        .ifSome(noRegionalBlackoutFlag)(_.noRegionalBlackoutFlag(_))
        .ifSome(webDeliveryAllowedFlag)(_.webDeliveryAllowedFlag(_))
        .build

    def scte35Descriptor(
      scte35DescriptorSettings: Option[Scte35DescriptorSettings] = None
    ): Scte35Descriptor =
      Scte35Descriptor
        .builder
        .ifSome(scte35DescriptorSettings)(_.scte35DescriptorSettings(_))
        .build

    def scte35DescriptorSettings(
      segmentationDescriptorScte35DescriptorSettings: Option[Scte35SegmentationDescriptor] = None
    ): Scte35DescriptorSettings =
      Scte35DescriptorSettings
        .builder
        .ifSome(segmentationDescriptorScte35DescriptorSettings)(_.segmentationDescriptorScte35DescriptorSettings(_))
        .build

    def scte35ReturnToNetworkScheduleActionSettings(
      spliceEventId: Option[__longMin0Max4294967295] = None
    ): Scte35ReturnToNetworkScheduleActionSettings =
      Scte35ReturnToNetworkScheduleActionSettings
        .builder
        .ifSome(spliceEventId)(_.spliceEventId(_))
        .build

    def scte35SegmentationDescriptor(
      deliveryRestrictions: Option[Scte35DeliveryRestrictions] = None,
      segmentNum: Option[Int] = None,
      segmentationCancelIndicator: Option[String] = None,
      segmentationDuration: Option[__longMin0Max1099511627775] = None,
      segmentationEventId: Option[__longMin0Max4294967295] = None,
      segmentationTypeId: Option[Int] = None,
      segmentationUpid: Option[String] = None,
      segmentationUpidType: Option[Int] = None,
      segmentsExpected: Option[Int] = None,
      subSegmentNum: Option[Int] = None,
      subSegmentsExpected: Option[Int] = None
    ): Scte35SegmentationDescriptor =
      Scte35SegmentationDescriptor
        .builder
        .ifSome(deliveryRestrictions)(_.deliveryRestrictions(_))
        .ifSome(segmentNum)(_.segmentNum(_))
        .ifSome(segmentationCancelIndicator)(_.segmentationCancelIndicator(_))
        .ifSome(segmentationDuration)(_.segmentationDuration(_))
        .ifSome(segmentationEventId)(_.segmentationEventId(_))
        .ifSome(segmentationTypeId)(_.segmentationTypeId(_))
        .ifSome(segmentationUpid)(_.segmentationUpid(_))
        .ifSome(segmentationUpidType)(_.segmentationUpidType(_))
        .ifSome(segmentsExpected)(_.segmentsExpected(_))
        .ifSome(subSegmentNum)(_.subSegmentNum(_))
        .ifSome(subSegmentsExpected)(_.subSegmentsExpected(_))
        .build

    def scte35SpliceInsert(
      adAvailOffset: Option[Int] = None,
      noRegionalBlackoutFlag: Option[String] = None,
      webDeliveryAllowedFlag: Option[String] = None
    ): Scte35SpliceInsert =
      Scte35SpliceInsert
        .builder
        .ifSome(adAvailOffset)(_.adAvailOffset(_))
        .ifSome(noRegionalBlackoutFlag)(_.noRegionalBlackoutFlag(_))
        .ifSome(webDeliveryAllowedFlag)(_.webDeliveryAllowedFlag(_))
        .build

    def scte35SpliceInsertScheduleActionSettings(
      duration: Option[__longMin0Max8589934591] = None,
      spliceEventId: Option[__longMin0Max4294967295] = None
    ): Scte35SpliceInsertScheduleActionSettings =
      Scte35SpliceInsertScheduleActionSettings
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(spliceEventId)(_.spliceEventId(_))
        .build

    def scte35TimeSignalApos(
      adAvailOffset: Option[Int] = None,
      noRegionalBlackoutFlag: Option[String] = None,
      webDeliveryAllowedFlag: Option[String] = None
    ): Scte35TimeSignalApos =
      Scte35TimeSignalApos
        .builder
        .ifSome(adAvailOffset)(_.adAvailOffset(_))
        .ifSome(noRegionalBlackoutFlag)(_.noRegionalBlackoutFlag(_))
        .ifSome(webDeliveryAllowedFlag)(_.webDeliveryAllowedFlag(_))
        .build

    def scte35TimeSignalScheduleActionSettings(
      scte35Descriptors: Option[List[Scte35Descriptor]] = None
    ): Scte35TimeSignalScheduleActionSettings =
      Scte35TimeSignalScheduleActionSettings
        .builder
        .ifSome(scte35Descriptors)(_.scte35Descriptors(_))
        .build

    def smpteTtDestinationSettings(

    ): SmpteTtDestinationSettings =
      SmpteTtDestinationSettings
        .builder

        .build

    def standardHlsSettings(
      audioRenditionSets: Option[String] = None,
      m3u8Settings: Option[M3u8Settings] = None
    ): StandardHlsSettings =
      StandardHlsSettings
        .builder
        .ifSome(audioRenditionSets)(_.audioRenditionSets(_))
        .ifSome(m3u8Settings)(_.m3u8Settings(_))
        .build

    def startChannelRequest(
      channelId: Option[String] = None
    ): StartChannelRequest =
      StartChannelRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .build

    def startChannelResponse(
      arn: Option[String] = None,
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      egressEndpoints: Option[List[ChannelEgressEndpoint]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      id: Option[String] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      pipelineDetails: Option[List[PipelineDetail]] = None,
      pipelinesRunningCount: Option[Int] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettingsDescription] = None
    ): StartChannelResponse =
      StartChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def startMultiplexRequest(
      multiplexId: Option[String] = None
    ): StartMultiplexRequest =
      StartMultiplexRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .build

    def startMultiplexResponse(
      arn: Option[String] = None,
      availabilityZones: Option[List[__string]] = None,
      destinations: Option[List[MultiplexOutputDestination]] = None,
      id: Option[String] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      programCount: Option[Int] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): StartMultiplexResponse =
      StartMultiplexResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(programCount)(_.programCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startTimecode(
      timecode: Option[String] = None
    ): StartTimecode =
      StartTimecode
        .builder
        .ifSome(timecode)(_.timecode(_))
        .build

    def staticImageActivateScheduleActionSettings(
      duration: Option[Int] = None,
      fadeIn: Option[Int] = None,
      fadeOut: Option[Int] = None,
      height: Option[Int] = None,
      image: Option[InputLocation] = None,
      imageX: Option[Int] = None,
      imageY: Option[Int] = None,
      layer: Option[Int] = None,
      opacity: Option[Int] = None,
      width: Option[Int] = None
    ): StaticImageActivateScheduleActionSettings =
      StaticImageActivateScheduleActionSettings
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(fadeIn)(_.fadeIn(_))
        .ifSome(fadeOut)(_.fadeOut(_))
        .ifSome(height)(_.height(_))
        .ifSome(image)(_.image(_))
        .ifSome(imageX)(_.imageX(_))
        .ifSome(imageY)(_.imageY(_))
        .ifSome(layer)(_.layer(_))
        .ifSome(opacity)(_.opacity(_))
        .ifSome(width)(_.width(_))
        .build

    def staticImageDeactivateScheduleActionSettings(
      fadeOut: Option[Int] = None,
      layer: Option[Int] = None
    ): StaticImageDeactivateScheduleActionSettings =
      StaticImageDeactivateScheduleActionSettings
        .builder
        .ifSome(fadeOut)(_.fadeOut(_))
        .ifSome(layer)(_.layer(_))
        .build

    def staticKeySettings(
      keyProviderServer: Option[InputLocation] = None,
      staticKeyValue: Option[String] = None
    ): StaticKeySettings =
      StaticKeySettings
        .builder
        .ifSome(keyProviderServer)(_.keyProviderServer(_))
        .ifSome(staticKeyValue)(_.staticKeyValue(_))
        .build

    def stopChannelRequest(
      channelId: Option[String] = None
    ): StopChannelRequest =
      StopChannelRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .build

    def stopChannelResponse(
      arn: Option[String] = None,
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      egressEndpoints: Option[List[ChannelEgressEndpoint]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      id: Option[String] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      pipelineDetails: Option[List[PipelineDetail]] = None,
      pipelinesRunningCount: Option[Int] = None,
      roleArn: Option[String] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None,
      vpc: Option[VpcOutputSettingsDescription] = None
    ): StopChannelResponse =
      StopChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineDetails)(_.pipelineDetails(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpc)(_.vpc(_))
        .build

    def stopMultiplexRequest(
      multiplexId: Option[String] = None
    ): StopMultiplexRequest =
      StopMultiplexRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .build

    def stopMultiplexResponse(
      arn: Option[String] = None,
      availabilityZones: Option[List[__string]] = None,
      destinations: Option[List[MultiplexOutputDestination]] = None,
      id: Option[String] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None,
      pipelinesRunningCount: Option[Int] = None,
      programCount: Option[Int] = None,
      state: Option[String] = None,
      tags: Option[Tags] = None
    ): StopMultiplexResponse =
      StopMultiplexResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelinesRunningCount)(_.pipelinesRunningCount(_))
        .ifSome(programCount)(_.programCount(_))
        .ifSome(state)(_.state(_))
        .ifSome(tags)(_.tags(_))
        .build

    def stopTimecode(
      lastFrameClippingBehavior: Option[String] = None,
      timecode: Option[String] = None
    ): StopTimecode =
      StopTimecode
        .builder
        .ifSome(lastFrameClippingBehavior)(_.lastFrameClippingBehavior(_))
        .ifSome(timecode)(_.timecode(_))
        .build

    def tagsModel(
      tags: Option[Tags] = None
    ): TagsModel =
      TagsModel
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def teletextDestinationSettings(

    ): TeletextDestinationSettings =
      TeletextDestinationSettings
        .builder

        .build

    def teletextSourceSettings(
      outputRectangle: Option[CaptionRectangle] = None,
      pageNumber: Option[String] = None
    ): TeletextSourceSettings =
      TeletextSourceSettings
        .builder
        .ifSome(outputRectangle)(_.outputRectangle(_))
        .ifSome(pageNumber)(_.pageNumber(_))
        .build

    def temporalFilterSettings(
      postFilterSharpening: Option[String] = None,
      strength: Option[String] = None
    ): TemporalFilterSettings =
      TemporalFilterSettings
        .builder
        .ifSome(postFilterSharpening)(_.postFilterSharpening(_))
        .ifSome(strength)(_.strength(_))
        .build

    def thumbnailData(
      body: Option[String] = None
    ): ThumbnailData =
      ThumbnailData
        .builder
        .ifSome(body)(_.body(_))
        .build

    def timecodeConfig(
      source: Option[String] = None,
      syncThreshold: Option[Int] = None
    ): TimecodeConfig =
      TimecodeConfig
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(syncThreshold)(_.syncThreshold(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transferInputDevice(
      targetCustomerId: Option[String] = None,
      targetRegion: Option[String] = None,
      transferMessage: Option[String] = None
    ): TransferInputDevice =
      TransferInputDevice
        .builder
        .ifSome(targetCustomerId)(_.targetCustomerId(_))
        .ifSome(targetRegion)(_.targetRegion(_))
        .ifSome(transferMessage)(_.transferMessage(_))
        .build

    def transferInputDeviceRequest(
      inputDeviceId: Option[String] = None,
      targetCustomerId: Option[String] = None,
      targetRegion: Option[String] = None,
      transferMessage: Option[String] = None
    ): TransferInputDeviceRequest =
      TransferInputDeviceRequest
        .builder
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .ifSome(targetCustomerId)(_.targetCustomerId(_))
        .ifSome(targetRegion)(_.targetRegion(_))
        .ifSome(transferMessage)(_.transferMessage(_))
        .build

    def transferInputDeviceResponse(

    ): TransferInputDeviceResponse =
      TransferInputDeviceResponse
        .builder

        .build

    def transferringInputDeviceSummary(
      id: Option[String] = None,
      message: Option[String] = None,
      targetCustomerId: Option[String] = None,
      transferType: Option[String] = None
    ): TransferringInputDeviceSummary =
      TransferringInputDeviceSummary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(message)(_.message(_))
        .ifSome(targetCustomerId)(_.targetCustomerId(_))
        .ifSome(transferType)(_.transferType(_))
        .build

    def ttmlDestinationSettings(
      styleControl: Option[String] = None
    ): TtmlDestinationSettings =
      TtmlDestinationSettings
        .builder
        .ifSome(styleControl)(_.styleControl(_))
        .build

    def udpContainerSettings(
      m2tsSettings: Option[M2tsSettings] = None
    ): UdpContainerSettings =
      UdpContainerSettings
        .builder
        .ifSome(m2tsSettings)(_.m2tsSettings(_))
        .build

    def udpGroupSettings(
      inputLossAction: Option[String] = None,
      timedMetadataId3Frame: Option[String] = None,
      timedMetadataId3Period: Option[Int] = None
    ): UdpGroupSettings =
      UdpGroupSettings
        .builder
        .ifSome(inputLossAction)(_.inputLossAction(_))
        .ifSome(timedMetadataId3Frame)(_.timedMetadataId3Frame(_))
        .ifSome(timedMetadataId3Period)(_.timedMetadataId3Period(_))
        .build

    def udpOutputSettings(
      bufferMsec: Option[Int] = None,
      containerSettings: Option[UdpContainerSettings] = None,
      destination: Option[OutputLocationRef] = None,
      fecOutputSettings: Option[FecOutputSettings] = None
    ): UdpOutputSettings =
      UdpOutputSettings
        .builder
        .ifSome(bufferMsec)(_.bufferMsec(_))
        .ifSome(containerSettings)(_.containerSettings(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(fecOutputSettings)(_.fecOutputSettings(_))
        .build

    def unprocessableEntityException(
      message: Option[String] = None,
      validationErrors: Option[List[ValidationError]] = None
    ): UnprocessableEntityException =
      UnprocessableEntityException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def updateChannel(
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      destinations: Option[List[OutputDestination]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdateChannel =
      UpdateChannel
        .builder
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateChannelClass(
      channelClass: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None
    ): UpdateChannelClass =
      UpdateChannelClass
        .builder
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(destinations)(_.destinations(_))
        .build

    def updateChannelClassRequest(
      channelClass: Option[String] = None,
      channelId: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None
    ): UpdateChannelClassRequest =
      UpdateChannelClassRequest
        .builder
        .ifSome(channelClass)(_.channelClass(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(destinations)(_.destinations(_))
        .build

    def updateChannelClassResponse(
      channel: Option[Channel] = None
    ): UpdateChannelClassResponse =
      UpdateChannelClassResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def updateChannelRequest(
      cdiInputSpecification: Option[CdiInputSpecification] = None,
      channelId: Option[String] = None,
      destinations: Option[List[OutputDestination]] = None,
      encoderSettings: Option[EncoderSettings] = None,
      inputAttachments: Option[List[InputAttachment]] = None,
      inputSpecification: Option[InputSpecification] = None,
      logLevel: Option[String] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdateChannelRequest =
      UpdateChannelRequest
        .builder
        .ifSome(cdiInputSpecification)(_.cdiInputSpecification(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(encoderSettings)(_.encoderSettings(_))
        .ifSome(inputAttachments)(_.inputAttachments(_))
        .ifSome(inputSpecification)(_.inputSpecification(_))
        .ifSome(logLevel)(_.logLevel(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateChannelResponse(
      channel: Option[Channel] = None
    ): UpdateChannelResponse =
      UpdateChannelResponse
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def updateChannelResultModel(
      channel: Option[Channel] = None
    ): UpdateChannelResultModel =
      UpdateChannelResultModel
        .builder
        .ifSome(channel)(_.channel(_))
        .build

    def updateInput(
      destinations: Option[List[InputDestinationRequest]] = None,
      inputDevices: Option[List[InputDeviceRequest]] = None,
      inputSecurityGroups: Option[List[__string]] = None,
      mediaConnectFlows: Option[List[MediaConnectFlowRequest]] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None,
      sources: Option[List[InputSourceRequest]] = None
    ): UpdateInput =
      UpdateInput
        .builder
        .ifSome(destinations)(_.destinations(_))
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(inputSecurityGroups)(_.inputSecurityGroups(_))
        .ifSome(mediaConnectFlows)(_.mediaConnectFlows(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(sources)(_.sources(_))
        .build

    def updateInputDevice(
      hdDeviceSettings: Option[InputDeviceConfigurableSettings] = None,
      name: Option[String] = None,
      uhdDeviceSettings: Option[InputDeviceConfigurableSettings] = None
    ): UpdateInputDevice =
      UpdateInputDevice
        .builder
        .ifSome(hdDeviceSettings)(_.hdDeviceSettings(_))
        .ifSome(name)(_.name(_))
        .ifSome(uhdDeviceSettings)(_.uhdDeviceSettings(_))
        .build

    def updateInputDeviceRequest(
      hdDeviceSettings: Option[InputDeviceConfigurableSettings] = None,
      inputDeviceId: Option[String] = None,
      name: Option[String] = None,
      uhdDeviceSettings: Option[InputDeviceConfigurableSettings] = None
    ): UpdateInputDeviceRequest =
      UpdateInputDeviceRequest
        .builder
        .ifSome(hdDeviceSettings)(_.hdDeviceSettings(_))
        .ifSome(inputDeviceId)(_.inputDeviceId(_))
        .ifSome(name)(_.name(_))
        .ifSome(uhdDeviceSettings)(_.uhdDeviceSettings(_))
        .build

    def updateInputDeviceResponse(
      arn: Option[String] = None,
      connectionState: Option[String] = None,
      deviceSettingsSyncState: Option[String] = None,
      deviceUpdateStatus: Option[String] = None,
      hdDeviceSettings: Option[InputDeviceHdSettings] = None,
      id: Option[String] = None,
      macAddress: Option[String] = None,
      name: Option[String] = None,
      networkSettings: Option[InputDeviceNetworkSettings] = None,
      serialNumber: Option[String] = None,
      `type`: Option[String] = None,
      uhdDeviceSettings: Option[InputDeviceUhdSettings] = None
    ): UpdateInputDeviceResponse =
      UpdateInputDeviceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(deviceSettingsSyncState)(_.deviceSettingsSyncState(_))
        .ifSome(deviceUpdateStatus)(_.deviceUpdateStatus(_))
        .ifSome(hdDeviceSettings)(_.hdDeviceSettings(_))
        .ifSome(id)(_.id(_))
        .ifSome(macAddress)(_.macAddress(_))
        .ifSome(name)(_.name(_))
        .ifSome(networkSettings)(_.networkSettings(_))
        .ifSome(serialNumber)(_.serialNumber(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uhdDeviceSettings)(_.uhdDeviceSettings(_))
        .build

    def updateInputRequest(
      destinations: Option[List[InputDestinationRequest]] = None,
      inputDevices: Option[List[InputDeviceRequest]] = None,
      inputId: Option[String] = None,
      inputSecurityGroups: Option[List[__string]] = None,
      mediaConnectFlows: Option[List[MediaConnectFlowRequest]] = None,
      name: Option[String] = None,
      roleArn: Option[String] = None,
      sources: Option[List[InputSourceRequest]] = None
    ): UpdateInputRequest =
      UpdateInputRequest
        .builder
        .ifSome(destinations)(_.destinations(_))
        .ifSome(inputDevices)(_.inputDevices(_))
        .ifSome(inputId)(_.inputId(_))
        .ifSome(inputSecurityGroups)(_.inputSecurityGroups(_))
        .ifSome(mediaConnectFlows)(_.mediaConnectFlows(_))
        .ifSome(name)(_.name(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(sources)(_.sources(_))
        .build

    def updateInputResponse(
      input: Option[Input] = None
    ): UpdateInputResponse =
      UpdateInputResponse
        .builder
        .ifSome(input)(_.input(_))
        .build

    def updateInputResultModel(
      input: Option[Input] = None
    ): UpdateInputResultModel =
      UpdateInputResultModel
        .builder
        .ifSome(input)(_.input(_))
        .build

    def updateInputSecurityGroupRequest(
      inputSecurityGroupId: Option[String] = None,
      tags: Option[Tags] = None,
      whitelistRules: Option[List[InputWhitelistRuleCidr]] = None
    ): UpdateInputSecurityGroupRequest =
      UpdateInputSecurityGroupRequest
        .builder
        .ifSome(inputSecurityGroupId)(_.inputSecurityGroupId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(whitelistRules)(_.whitelistRules(_))
        .build

    def updateInputSecurityGroupResponse(
      securityGroup: Option[InputSecurityGroup] = None
    ): UpdateInputSecurityGroupResponse =
      UpdateInputSecurityGroupResponse
        .builder
        .ifSome(securityGroup)(_.securityGroup(_))
        .build

    def updateInputSecurityGroupResultModel(
      securityGroup: Option[InputSecurityGroup] = None
    ): UpdateInputSecurityGroupResultModel =
      UpdateInputSecurityGroupResultModel
        .builder
        .ifSome(securityGroup)(_.securityGroup(_))
        .build

    def updateMultiplex(
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None
    ): UpdateMultiplex =
      UpdateMultiplex
        .builder
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .build

    def updateMultiplexProgram(
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None
    ): UpdateMultiplexProgram =
      UpdateMultiplexProgram
        .builder
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .build

    def updateMultiplexProgramRequest(
      multiplexId: Option[String] = None,
      multiplexProgramSettings: Option[MultiplexProgramSettings] = None,
      programName: Option[String] = None
    ): UpdateMultiplexProgramRequest =
      UpdateMultiplexProgramRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(multiplexProgramSettings)(_.multiplexProgramSettings(_))
        .ifSome(programName)(_.programName(_))
        .build

    def updateMultiplexProgramResponse(
      multiplexProgram: Option[MultiplexProgram] = None
    ): UpdateMultiplexProgramResponse =
      UpdateMultiplexProgramResponse
        .builder
        .ifSome(multiplexProgram)(_.multiplexProgram(_))
        .build

    def updateMultiplexProgramResultModel(
      multiplexProgram: Option[MultiplexProgram] = None
    ): UpdateMultiplexProgramResultModel =
      UpdateMultiplexProgramResultModel
        .builder
        .ifSome(multiplexProgram)(_.multiplexProgram(_))
        .build

    def updateMultiplexRequest(
      multiplexId: Option[String] = None,
      multiplexSettings: Option[MultiplexSettings] = None,
      name: Option[String] = None
    ): UpdateMultiplexRequest =
      UpdateMultiplexRequest
        .builder
        .ifSome(multiplexId)(_.multiplexId(_))
        .ifSome(multiplexSettings)(_.multiplexSettings(_))
        .ifSome(name)(_.name(_))
        .build

    def updateMultiplexResponse(
      multiplex: Option[Multiplex] = None
    ): UpdateMultiplexResponse =
      UpdateMultiplexResponse
        .builder
        .ifSome(multiplex)(_.multiplex(_))
        .build

    def updateMultiplexResultModel(
      multiplex: Option[Multiplex] = None
    ): UpdateMultiplexResultModel =
      UpdateMultiplexResultModel
        .builder
        .ifSome(multiplex)(_.multiplex(_))
        .build

    def updateReservation(
      name: Option[String] = None
    ): UpdateReservation =
      UpdateReservation
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateReservationRequest(
      name: Option[String] = None,
      reservationId: Option[String] = None
    ): UpdateReservationRequest =
      UpdateReservationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(reservationId)(_.reservationId(_))
        .build

    def updateReservationResponse(
      reservation: Option[Reservation] = None
    ): UpdateReservationResponse =
      UpdateReservationResponse
        .builder
        .ifSome(reservation)(_.reservation(_))
        .build

    def updateReservationResultModel(
      reservation: Option[Reservation] = None
    ): UpdateReservationResultModel =
      UpdateReservationResultModel
        .builder
        .ifSome(reservation)(_.reservation(_))
        .build

    def validationError(
      elementPath: Option[String] = None,
      errorMessage: Option[String] = None
    ): ValidationError =
      ValidationError
        .builder
        .ifSome(elementPath)(_.elementPath(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def videoBlackFailoverSettings(
      blackDetectThreshold: Option[__doubleMin0Max1] = None,
      videoBlackThresholdMsec: Option[Int] = None
    ): VideoBlackFailoverSettings =
      VideoBlackFailoverSettings
        .builder
        .ifSome(blackDetectThreshold)(_.blackDetectThreshold(_))
        .ifSome(videoBlackThresholdMsec)(_.videoBlackThresholdMsec(_))
        .build

    def videoCodecSettings(
      frameCaptureSettings: Option[FrameCaptureSettings] = None,
      h264Settings: Option[H264Settings] = None,
      h265Settings: Option[H265Settings] = None,
      mpeg2Settings: Option[Mpeg2Settings] = None
    ): VideoCodecSettings =
      VideoCodecSettings
        .builder
        .ifSome(frameCaptureSettings)(_.frameCaptureSettings(_))
        .ifSome(h264Settings)(_.h264Settings(_))
        .ifSome(h265Settings)(_.h265Settings(_))
        .ifSome(mpeg2Settings)(_.mpeg2Settings(_))
        .build

    def videoDescription(
      codecSettings: Option[VideoCodecSettings] = None,
      height: Option[Int] = None,
      name: Option[String] = None,
      respondToAfd: Option[String] = None,
      scalingBehavior: Option[String] = None,
      sharpness: Option[Int] = None,
      width: Option[Int] = None
    ): VideoDescription =
      VideoDescription
        .builder
        .ifSome(codecSettings)(_.codecSettings(_))
        .ifSome(height)(_.height(_))
        .ifSome(name)(_.name(_))
        .ifSome(respondToAfd)(_.respondToAfd(_))
        .ifSome(scalingBehavior)(_.scalingBehavior(_))
        .ifSome(sharpness)(_.sharpness(_))
        .ifSome(width)(_.width(_))
        .build

    def videoSelector(
      colorSpace: Option[String] = None,
      colorSpaceSettings: Option[VideoSelectorColorSpaceSettings] = None,
      colorSpaceUsage: Option[String] = None,
      selectorSettings: Option[VideoSelectorSettings] = None
    ): VideoSelector =
      VideoSelector
        .builder
        .ifSome(colorSpace)(_.colorSpace(_))
        .ifSome(colorSpaceSettings)(_.colorSpaceSettings(_))
        .ifSome(colorSpaceUsage)(_.colorSpaceUsage(_))
        .ifSome(selectorSettings)(_.selectorSettings(_))
        .build

    def videoSelectorColorSpaceSettings(
      hdr10Settings: Option[Hdr10Settings] = None
    ): VideoSelectorColorSpaceSettings =
      VideoSelectorColorSpaceSettings
        .builder
        .ifSome(hdr10Settings)(_.hdr10Settings(_))
        .build

    def videoSelectorPid(
      pid: Option[Int] = None
    ): VideoSelectorPid =
      VideoSelectorPid
        .builder
        .ifSome(pid)(_.pid(_))
        .build

    def videoSelectorProgramId(
      programId: Option[Int] = None
    ): VideoSelectorProgramId =
      VideoSelectorProgramId
        .builder
        .ifSome(programId)(_.programId(_))
        .build

    def videoSelectorSettings(
      videoSelectorPid: Option[VideoSelectorPid] = None,
      videoSelectorProgramId: Option[VideoSelectorProgramId] = None
    ): VideoSelectorSettings =
      VideoSelectorSettings
        .builder
        .ifSome(videoSelectorPid)(_.videoSelectorPid(_))
        .ifSome(videoSelectorProgramId)(_.videoSelectorProgramId(_))
        .build

    def vpcOutputSettings(
      publicAddressAllocationIds: Option[List[__string]] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None
    ): VpcOutputSettings =
      VpcOutputSettings
        .builder
        .ifSome(publicAddressAllocationIds)(_.publicAddressAllocationIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def vpcOutputSettingsDescription(
      availabilityZones: Option[List[__string]] = None,
      networkInterfaceIds: Option[List[__string]] = None,
      securityGroupIds: Option[List[__string]] = None,
      subnetIds: Option[List[__string]] = None
    ): VpcOutputSettingsDescription =
      VpcOutputSettingsDescription
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def wavSettings(
      bitDepth: Option[__double] = None,
      codingMode: Option[String] = None,
      sampleRate: Option[__double] = None
    ): WavSettings =
      WavSettings
        .builder
        .ifSome(bitDepth)(_.bitDepth(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def webvttDestinationSettings(

    ): WebvttDestinationSettings =
      WebvttDestinationSettings
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
