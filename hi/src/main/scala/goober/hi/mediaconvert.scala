package goober.hi

import goober.free.mediaconvert.MediaConvertIO
import software.amazon.awssdk.services.mediaconvert.model._


object mediaconvert {
  import goober.free.{mediaconvert ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aacSettings(
      audioDescriptionBroadcasterMix: Option[String] = None,
      bitrate: Option[Int] = None,
      codecProfile: Option[String] = None,
      codingMode: Option[String] = None,
      rateControlMode: Option[String] = None,
      rawFormat: Option[String] = None,
      sampleRate: Option[Int] = None,
      specification: Option[String] = None,
      vbrQuality: Option[String] = None
    ): AacSettings =
      AacSettings
        .builder
        .ifSome(audioDescriptionBroadcasterMix)(_.audioDescriptionBroadcasterMix(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(codecProfile)(_.codecProfile(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(rawFormat)(_.rawFormat(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(specification)(_.specification(_))
        .ifSome(vbrQuality)(_.vbrQuality(_))
        .build

    def ac3Settings(
      bitrate: Option[Int] = None,
      bitstreamMode: Option[String] = None,
      codingMode: Option[String] = None,
      dialnorm: Option[Int] = None,
      dynamicRangeCompressionLine: Option[String] = None,
      dynamicRangeCompressionProfile: Option[String] = None,
      dynamicRangeCompressionRf: Option[String] = None,
      lfeFilter: Option[String] = None,
      metadataControl: Option[String] = None,
      sampleRate: Option[Int] = None
    ): Ac3Settings =
      Ac3Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bitstreamMode)(_.bitstreamMode(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(dialnorm)(_.dialnorm(_))
        .ifSome(dynamicRangeCompressionLine)(_.dynamicRangeCompressionLine(_))
        .ifSome(dynamicRangeCompressionProfile)(_.dynamicRangeCompressionProfile(_))
        .ifSome(dynamicRangeCompressionRf)(_.dynamicRangeCompressionRf(_))
        .ifSome(lfeFilter)(_.lfeFilter(_))
        .ifSome(metadataControl)(_.metadataControl(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def accelerationSettings(
      mode: Option[String] = None
    ): AccelerationSettings =
      AccelerationSettings
        .builder
        .ifSome(mode)(_.mode(_))
        .build

    def aiffSettings(
      bitDepth: Option[Int] = None,
      channels: Option[Int] = None,
      sampleRate: Option[Int] = None
    ): AiffSettings =
      AiffSettings
        .builder
        .ifSome(bitDepth)(_.bitDepth(_))
        .ifSome(channels)(_.channels(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def ancillarySourceSettings(
      convert608To708: Option[String] = None,
      sourceAncillaryChannelNumber: Option[Int] = None,
      terminateCaptions: Option[String] = None
    ): AncillarySourceSettings =
      AncillarySourceSettings
        .builder
        .ifSome(convert608To708)(_.convert608To708(_))
        .ifSome(sourceAncillaryChannelNumber)(_.sourceAncillaryChannelNumber(_))
        .ifSome(terminateCaptions)(_.terminateCaptions(_))
        .build

    def associateCertificateRequest(
      arn: Option[String] = None
    ): AssociateCertificateRequest =
      AssociateCertificateRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def associateCertificateResponse(

    ): AssociateCertificateResponse =
      AssociateCertificateResponse
        .builder

        .build

    def audioChannelTaggingSettings(
      channelTag: Option[String] = None
    ): AudioChannelTaggingSettings =
      AudioChannelTaggingSettings
        .builder
        .ifSome(channelTag)(_.channelTag(_))
        .build

    def audioCodecSettings(
      aacSettings: Option[AacSettings] = None,
      ac3Settings: Option[Ac3Settings] = None,
      aiffSettings: Option[AiffSettings] = None,
      codec: Option[String] = None,
      eac3AtmosSettings: Option[Eac3AtmosSettings] = None,
      eac3Settings: Option[Eac3Settings] = None,
      mp2Settings: Option[Mp2Settings] = None,
      mp3Settings: Option[Mp3Settings] = None,
      opusSettings: Option[OpusSettings] = None,
      vorbisSettings: Option[VorbisSettings] = None,
      wavSettings: Option[WavSettings] = None
    ): AudioCodecSettings =
      AudioCodecSettings
        .builder
        .ifSome(aacSettings)(_.aacSettings(_))
        .ifSome(ac3Settings)(_.ac3Settings(_))
        .ifSome(aiffSettings)(_.aiffSettings(_))
        .ifSome(codec)(_.codec(_))
        .ifSome(eac3AtmosSettings)(_.eac3AtmosSettings(_))
        .ifSome(eac3Settings)(_.eac3Settings(_))
        .ifSome(mp2Settings)(_.mp2Settings(_))
        .ifSome(mp3Settings)(_.mp3Settings(_))
        .ifSome(opusSettings)(_.opusSettings(_))
        .ifSome(vorbisSettings)(_.vorbisSettings(_))
        .ifSome(wavSettings)(_.wavSettings(_))
        .build

    def audioDescription(
      audioChannelTaggingSettings: Option[AudioChannelTaggingSettings] = None,
      audioNormalizationSettings: Option[AudioNormalizationSettings] = None,
      audioSourceName: Option[String] = None,
      audioType: Option[Int] = None,
      audioTypeControl: Option[String] = None,
      codecSettings: Option[AudioCodecSettings] = None,
      customLanguageCode: Option[String] = None,
      languageCode: Option[String] = None,
      languageCodeControl: Option[String] = None,
      remixSettings: Option[RemixSettings] = None,
      streamName: Option[String] = None
    ): AudioDescription =
      AudioDescription
        .builder
        .ifSome(audioChannelTaggingSettings)(_.audioChannelTaggingSettings(_))
        .ifSome(audioNormalizationSettings)(_.audioNormalizationSettings(_))
        .ifSome(audioSourceName)(_.audioSourceName(_))
        .ifSome(audioType)(_.audioType(_))
        .ifSome(audioTypeControl)(_.audioTypeControl(_))
        .ifSome(codecSettings)(_.codecSettings(_))
        .ifSome(customLanguageCode)(_.customLanguageCode(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageCodeControl)(_.languageCodeControl(_))
        .ifSome(remixSettings)(_.remixSettings(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def audioNormalizationSettings(
      algorithm: Option[String] = None,
      algorithmControl: Option[String] = None,
      correctionGateLevel: Option[Int] = None,
      loudnessLogging: Option[String] = None,
      peakCalculation: Option[String] = None,
      targetLkfs: Option[__doubleMinNegative59Max0] = None
    ): AudioNormalizationSettings =
      AudioNormalizationSettings
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(algorithmControl)(_.algorithmControl(_))
        .ifSome(correctionGateLevel)(_.correctionGateLevel(_))
        .ifSome(loudnessLogging)(_.loudnessLogging(_))
        .ifSome(peakCalculation)(_.peakCalculation(_))
        .ifSome(targetLkfs)(_.targetLkfs(_))
        .build

    def audioSelector(
      customLanguageCode: Option[String] = None,
      defaultSelection: Option[String] = None,
      externalAudioFileInput: Option[String] = None,
      languageCode: Option[String] = None,
      offset: Option[Int] = None,
      pids: Option[List[__integerMin1Max2147483647]] = None,
      programSelection: Option[Int] = None,
      remixSettings: Option[RemixSettings] = None,
      selectorType: Option[String] = None,
      tracks: Option[List[__integerMin1Max2147483647]] = None
    ): AudioSelector =
      AudioSelector
        .builder
        .ifSome(customLanguageCode)(_.customLanguageCode(_))
        .ifSome(defaultSelection)(_.defaultSelection(_))
        .ifSome(externalAudioFileInput)(_.externalAudioFileInput(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(offset)(_.offset(_))
        .ifSome(pids)(_.pids(_))
        .ifSome(programSelection)(_.programSelection(_))
        .ifSome(remixSettings)(_.remixSettings(_))
        .ifSome(selectorType)(_.selectorType(_))
        .ifSome(tracks)(_.tracks(_))
        .build

    def audioSelectorGroup(
      audioSelectorNames: Option[List[__stringMin1]] = None
    ): AudioSelectorGroup =
      AudioSelectorGroup
        .builder
        .ifSome(audioSelectorNames)(_.audioSelectorNames(_))
        .build

    def automatedAbrSettings(
      maxAbrBitrate: Option[Int] = None,
      maxRenditions: Option[Int] = None,
      minAbrBitrate: Option[Int] = None
    ): AutomatedAbrSettings =
      AutomatedAbrSettings
        .builder
        .ifSome(maxAbrBitrate)(_.maxAbrBitrate(_))
        .ifSome(maxRenditions)(_.maxRenditions(_))
        .ifSome(minAbrBitrate)(_.minAbrBitrate(_))
        .build

    def automatedEncodingSettings(
      abrSettings: Option[AutomatedAbrSettings] = None
    ): AutomatedEncodingSettings =
      AutomatedEncodingSettings
        .builder
        .ifSome(abrSettings)(_.abrSettings(_))
        .build

    def av1QvbrSettings(
      qvbrQualityLevel: Option[Int] = None,
      qvbrQualityLevelFineTune: Option[__doubleMin0Max1] = None
    ): Av1QvbrSettings =
      Av1QvbrSettings
        .builder
        .ifSome(qvbrQualityLevel)(_.qvbrQualityLevel(_))
        .ifSome(qvbrQualityLevelFineTune)(_.qvbrQualityLevelFineTune(_))
        .build

    def av1Settings(
      adaptiveQuantization: Option[String] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopSize: Option[__doubleMin0] = None,
      maxBitrate: Option[Int] = None,
      numberBFramesBetweenReferenceFrames: Option[Int] = None,
      qvbrSettings: Option[Av1QvbrSettings] = None,
      rateControlMode: Option[String] = None,
      slices: Option[Int] = None,
      spatialAdaptiveQuantization: Option[String] = None
    ): Av1Settings =
      Av1Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(numberBFramesBetweenReferenceFrames)(_.numberBFramesBetweenReferenceFrames(_))
        .ifSome(qvbrSettings)(_.qvbrSettings(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(slices)(_.slices(_))
        .ifSome(spatialAdaptiveQuantization)(_.spatialAdaptiveQuantization(_))
        .build

    def availBlanking(
      availBlankingImage: Option[String] = None
    ): AvailBlanking =
      AvailBlanking
        .builder
        .ifSome(availBlankingImage)(_.availBlankingImage(_))
        .build

    def avcIntraSettings(
      avcIntraClass: Option[String] = None,
      avcIntraUhdSettings: Option[AvcIntraUhdSettings] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      interlaceMode: Option[String] = None,
      scanTypeConversionMode: Option[String] = None,
      slowPal: Option[String] = None,
      telecine: Option[String] = None
    ): AvcIntraSettings =
      AvcIntraSettings
        .builder
        .ifSome(avcIntraClass)(_.avcIntraClass(_))
        .ifSome(avcIntraUhdSettings)(_.avcIntraUhdSettings(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(interlaceMode)(_.interlaceMode(_))
        .ifSome(scanTypeConversionMode)(_.scanTypeConversionMode(_))
        .ifSome(slowPal)(_.slowPal(_))
        .ifSome(telecine)(_.telecine(_))
        .build

    def avcIntraUhdSettings(
      qualityTuningLevel: Option[String] = None
    ): AvcIntraUhdSettings =
      AvcIntraUhdSettings
        .builder
        .ifSome(qualityTuningLevel)(_.qualityTuningLevel(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def burninDestinationSettings(
      alignment: Option[String] = None,
      backgroundColor: Option[String] = None,
      backgroundOpacity: Option[Int] = None,
      fontColor: Option[String] = None,
      fontOpacity: Option[Int] = None,
      fontResolution: Option[Int] = None,
      fontScript: Option[String] = None,
      fontSize: Option[Int] = None,
      outlineColor: Option[String] = None,
      outlineSize: Option[Int] = None,
      shadowColor: Option[String] = None,
      shadowOpacity: Option[Int] = None,
      shadowXOffset: Option[Int] = None,
      shadowYOffset: Option[Int] = None,
      teletextSpacing: Option[String] = None,
      xPosition: Option[Int] = None,
      yPosition: Option[Int] = None
    ): BurninDestinationSettings =
      BurninDestinationSettings
        .builder
        .ifSome(alignment)(_.alignment(_))
        .ifSome(backgroundColor)(_.backgroundColor(_))
        .ifSome(backgroundOpacity)(_.backgroundOpacity(_))
        .ifSome(fontColor)(_.fontColor(_))
        .ifSome(fontOpacity)(_.fontOpacity(_))
        .ifSome(fontResolution)(_.fontResolution(_))
        .ifSome(fontScript)(_.fontScript(_))
        .ifSome(fontSize)(_.fontSize(_))
        .ifSome(outlineColor)(_.outlineColor(_))
        .ifSome(outlineSize)(_.outlineSize(_))
        .ifSome(shadowColor)(_.shadowColor(_))
        .ifSome(shadowOpacity)(_.shadowOpacity(_))
        .ifSome(shadowXOffset)(_.shadowXOffset(_))
        .ifSome(shadowYOffset)(_.shadowYOffset(_))
        .ifSome(teletextSpacing)(_.teletextSpacing(_))
        .ifSome(xPosition)(_.xPosition(_))
        .ifSome(yPosition)(_.yPosition(_))
        .build

    def cancelJobRequest(
      id: Option[String] = None
    ): CancelJobRequest =
      CancelJobRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def cancelJobResponse(

    ): CancelJobResponse =
      CancelJobResponse
        .builder

        .build

    def captionDescription(
      captionSelectorName: Option[String] = None,
      customLanguageCode: Option[String] = None,
      destinationSettings: Option[CaptionDestinationSettings] = None,
      languageCode: Option[String] = None,
      languageDescription: Option[String] = None
    ): CaptionDescription =
      CaptionDescription
        .builder
        .ifSome(captionSelectorName)(_.captionSelectorName(_))
        .ifSome(customLanguageCode)(_.customLanguageCode(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageDescription)(_.languageDescription(_))
        .build

    def captionDescriptionPreset(
      customLanguageCode: Option[String] = None,
      destinationSettings: Option[CaptionDestinationSettings] = None,
      languageCode: Option[String] = None,
      languageDescription: Option[String] = None
    ): CaptionDescriptionPreset =
      CaptionDescriptionPreset
        .builder
        .ifSome(customLanguageCode)(_.customLanguageCode(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageDescription)(_.languageDescription(_))
        .build

    def captionDestinationSettings(
      burninDestinationSettings: Option[BurninDestinationSettings] = None,
      destinationType: Option[String] = None,
      dvbSubDestinationSettings: Option[DvbSubDestinationSettings] = None,
      embeddedDestinationSettings: Option[EmbeddedDestinationSettings] = None,
      imscDestinationSettings: Option[ImscDestinationSettings] = None,
      sccDestinationSettings: Option[SccDestinationSettings] = None,
      teletextDestinationSettings: Option[TeletextDestinationSettings] = None,
      ttmlDestinationSettings: Option[TtmlDestinationSettings] = None,
      webvttDestinationSettings: Option[WebvttDestinationSettings] = None
    ): CaptionDestinationSettings =
      CaptionDestinationSettings
        .builder
        .ifSome(burninDestinationSettings)(_.burninDestinationSettings(_))
        .ifSome(destinationType)(_.destinationType(_))
        .ifSome(dvbSubDestinationSettings)(_.dvbSubDestinationSettings(_))
        .ifSome(embeddedDestinationSettings)(_.embeddedDestinationSettings(_))
        .ifSome(imscDestinationSettings)(_.imscDestinationSettings(_))
        .ifSome(sccDestinationSettings)(_.sccDestinationSettings(_))
        .ifSome(teletextDestinationSettings)(_.teletextDestinationSettings(_))
        .ifSome(ttmlDestinationSettings)(_.ttmlDestinationSettings(_))
        .ifSome(webvttDestinationSettings)(_.webvttDestinationSettings(_))
        .build

    def captionSelector(
      customLanguageCode: Option[String] = None,
      languageCode: Option[String] = None,
      sourceSettings: Option[CaptionSourceSettings] = None
    ): CaptionSelector =
      CaptionSelector
        .builder
        .ifSome(customLanguageCode)(_.customLanguageCode(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(sourceSettings)(_.sourceSettings(_))
        .build

    def captionSourceFramerate(
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None
    ): CaptionSourceFramerate =
      CaptionSourceFramerate
        .builder
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .build

    def captionSourceSettings(
      ancillarySourceSettings: Option[AncillarySourceSettings] = None,
      dvbSubSourceSettings: Option[DvbSubSourceSettings] = None,
      embeddedSourceSettings: Option[EmbeddedSourceSettings] = None,
      fileSourceSettings: Option[FileSourceSettings] = None,
      sourceType: Option[String] = None,
      teletextSourceSettings: Option[TeletextSourceSettings] = None,
      trackSourceSettings: Option[TrackSourceSettings] = None
    ): CaptionSourceSettings =
      CaptionSourceSettings
        .builder
        .ifSome(ancillarySourceSettings)(_.ancillarySourceSettings(_))
        .ifSome(dvbSubSourceSettings)(_.dvbSubSourceSettings(_))
        .ifSome(embeddedSourceSettings)(_.embeddedSourceSettings(_))
        .ifSome(fileSourceSettings)(_.fileSourceSettings(_))
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(teletextSourceSettings)(_.teletextSourceSettings(_))
        .ifSome(trackSourceSettings)(_.trackSourceSettings(_))
        .build

    def channelMapping(
      outputChannels: Option[List[OutputChannelMapping]] = None
    ): ChannelMapping =
      ChannelMapping
        .builder
        .ifSome(outputChannels)(_.outputChannels(_))
        .build

    def cmafAdditionalManifest(
      manifestNameModifier: Option[String] = None,
      selectedOutputs: Option[List[__stringMin1]] = None
    ): CmafAdditionalManifest =
      CmafAdditionalManifest
        .builder
        .ifSome(manifestNameModifier)(_.manifestNameModifier(_))
        .ifSome(selectedOutputs)(_.selectedOutputs(_))
        .build

    def cmafEncryptionSettings(
      constantInitializationVector: Option[String] = None,
      encryptionMethod: Option[String] = None,
      initializationVectorInManifest: Option[String] = None,
      spekeKeyProvider: Option[SpekeKeyProviderCmaf] = None,
      staticKeyProvider: Option[StaticKeyProvider] = None,
      `type`: Option[String] = None
    ): CmafEncryptionSettings =
      CmafEncryptionSettings
        .builder
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(encryptionMethod)(_.encryptionMethod(_))
        .ifSome(initializationVectorInManifest)(_.initializationVectorInManifest(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .ifSome(staticKeyProvider)(_.staticKeyProvider(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def cmafGroupSettings(
      additionalManifests: Option[List[CmafAdditionalManifest]] = None,
      baseUrl: Option[String] = None,
      clientCache: Option[String] = None,
      codecSpecification: Option[String] = None,
      destination: Option[String] = None,
      destinationSettings: Option[DestinationSettings] = None,
      encryption: Option[CmafEncryptionSettings] = None,
      fragmentLength: Option[Int] = None,
      manifestCompression: Option[String] = None,
      manifestDurationFormat: Option[String] = None,
      minBufferTime: Option[Int] = None,
      minFinalSegmentLength: Option[__doubleMin0Max2147483647] = None,
      mpdProfile: Option[String] = None,
      ptsOffsetHandlingForBFrames: Option[String] = None,
      segmentControl: Option[String] = None,
      segmentLength: Option[Int] = None,
      streamInfResolution: Option[String] = None,
      writeDashManifest: Option[String] = None,
      writeHlsManifest: Option[String] = None,
      writeSegmentTimelineInRepresentation: Option[String] = None
    ): CmafGroupSettings =
      CmafGroupSettings
        .builder
        .ifSome(additionalManifests)(_.additionalManifests(_))
        .ifSome(baseUrl)(_.baseUrl(_))
        .ifSome(clientCache)(_.clientCache(_))
        .ifSome(codecSpecification)(_.codecSpecification(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(fragmentLength)(_.fragmentLength(_))
        .ifSome(manifestCompression)(_.manifestCompression(_))
        .ifSome(manifestDurationFormat)(_.manifestDurationFormat(_))
        .ifSome(minBufferTime)(_.minBufferTime(_))
        .ifSome(minFinalSegmentLength)(_.minFinalSegmentLength(_))
        .ifSome(mpdProfile)(_.mpdProfile(_))
        .ifSome(ptsOffsetHandlingForBFrames)(_.ptsOffsetHandlingForBFrames(_))
        .ifSome(segmentControl)(_.segmentControl(_))
        .ifSome(segmentLength)(_.segmentLength(_))
        .ifSome(streamInfResolution)(_.streamInfResolution(_))
        .ifSome(writeDashManifest)(_.writeDashManifest(_))
        .ifSome(writeHlsManifest)(_.writeHlsManifest(_))
        .ifSome(writeSegmentTimelineInRepresentation)(_.writeSegmentTimelineInRepresentation(_))
        .build

    def cmfcSettings(
      audioDuration: Option[String] = None,
      audioGroupId: Option[String] = None,
      audioRenditionSets: Option[String] = None,
      audioTrackType: Option[String] = None,
      descriptiveVideoServiceFlag: Option[String] = None,
      iFrameOnlyManifest: Option[String] = None,
      scte35Esam: Option[String] = None,
      scte35Source: Option[String] = None
    ): CmfcSettings =
      CmfcSettings
        .builder
        .ifSome(audioDuration)(_.audioDuration(_))
        .ifSome(audioGroupId)(_.audioGroupId(_))
        .ifSome(audioRenditionSets)(_.audioRenditionSets(_))
        .ifSome(audioTrackType)(_.audioTrackType(_))
        .ifSome(descriptiveVideoServiceFlag)(_.descriptiveVideoServiceFlag(_))
        .ifSome(iFrameOnlyManifest)(_.iFrameOnlyManifest(_))
        .ifSome(scte35Esam)(_.scte35Esam(_))
        .ifSome(scte35Source)(_.scte35Source(_))
        .build

    def colorCorrector(
      brightness: Option[Int] = None,
      colorSpaceConversion: Option[String] = None,
      contrast: Option[Int] = None,
      hdr10Metadata: Option[Hdr10Metadata] = None,
      hue: Option[Int] = None,
      saturation: Option[Int] = None
    ): ColorCorrector =
      ColorCorrector
        .builder
        .ifSome(brightness)(_.brightness(_))
        .ifSome(colorSpaceConversion)(_.colorSpaceConversion(_))
        .ifSome(contrast)(_.contrast(_))
        .ifSome(hdr10Metadata)(_.hdr10Metadata(_))
        .ifSome(hue)(_.hue(_))
        .ifSome(saturation)(_.saturation(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def containerSettings(
      cmfcSettings: Option[CmfcSettings] = None,
      container: Option[String] = None,
      f4vSettings: Option[F4vSettings] = None,
      m2tsSettings: Option[M2tsSettings] = None,
      m3u8Settings: Option[M3u8Settings] = None,
      movSettings: Option[MovSettings] = None,
      mp4Settings: Option[Mp4Settings] = None,
      mpdSettings: Option[MpdSettings] = None,
      mxfSettings: Option[MxfSettings] = None
    ): ContainerSettings =
      ContainerSettings
        .builder
        .ifSome(cmfcSettings)(_.cmfcSettings(_))
        .ifSome(container)(_.container(_))
        .ifSome(f4vSettings)(_.f4vSettings(_))
        .ifSome(m2tsSettings)(_.m2tsSettings(_))
        .ifSome(m3u8Settings)(_.m3u8Settings(_))
        .ifSome(movSettings)(_.movSettings(_))
        .ifSome(mp4Settings)(_.mp4Settings(_))
        .ifSome(mpdSettings)(_.mpdSettings(_))
        .ifSome(mxfSettings)(_.mxfSettings(_))
        .build

    def createJobRequest(
      accelerationSettings: Option[AccelerationSettings] = None,
      billingTagsSource: Option[String] = None,
      clientRequestToken: Option[String] = None,
      hopDestinations: Option[List[HopDestination]] = None,
      jobTemplate: Option[String] = None,
      priority: Option[Int] = None,
      queue: Option[String] = None,
      role: Option[String] = None,
      settings: Option[JobSettings] = None,
      simulateReservedQueue: Option[String] = None,
      statusUpdateInterval: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      userMetadata: Option[__mapOf__string] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(accelerationSettings)(_.accelerationSettings(_))
        .ifSome(billingTagsSource)(_.billingTagsSource(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(hopDestinations)(_.hopDestinations(_))
        .ifSome(jobTemplate)(_.jobTemplate(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(role)(_.role(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(simulateReservedQueue)(_.simulateReservedQueue(_))
        .ifSome(statusUpdateInterval)(_.statusUpdateInterval(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .build

    def createJobResponse(
      job: Option[Job] = None
    ): CreateJobResponse =
      CreateJobResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def createJobTemplateRequest(
      accelerationSettings: Option[AccelerationSettings] = None,
      category: Option[String] = None,
      description: Option[String] = None,
      hopDestinations: Option[List[HopDestination]] = None,
      name: Option[String] = None,
      priority: Option[Int] = None,
      queue: Option[String] = None,
      settings: Option[JobTemplateSettings] = None,
      statusUpdateInterval: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateJobTemplateRequest =
      CreateJobTemplateRequest
        .builder
        .ifSome(accelerationSettings)(_.accelerationSettings(_))
        .ifSome(category)(_.category(_))
        .ifSome(description)(_.description(_))
        .ifSome(hopDestinations)(_.hopDestinations(_))
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(statusUpdateInterval)(_.statusUpdateInterval(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createJobTemplateResponse(
      jobTemplate: Option[JobTemplate] = None
    ): CreateJobTemplateResponse =
      CreateJobTemplateResponse
        .builder
        .ifSome(jobTemplate)(_.jobTemplate(_))
        .build

    def createPresetRequest(
      category: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      settings: Option[PresetSettings] = None,
      tags: Option[__mapOf__string] = None
    ): CreatePresetRequest =
      CreatePresetRequest
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPresetResponse(
      preset: Option[Preset] = None
    ): CreatePresetResponse =
      CreatePresetResponse
        .builder
        .ifSome(preset)(_.preset(_))
        .build

    def createQueueRequest(
      description: Option[String] = None,
      name: Option[String] = None,
      pricingPlan: Option[String] = None,
      reservationPlanSettings: Option[ReservationPlanSettings] = None,
      status: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateQueueRequest =
      CreateQueueRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(reservationPlanSettings)(_.reservationPlanSettings(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createQueueResponse(
      queue: Option[Queue] = None
    ): CreateQueueResponse =
      CreateQueueResponse
        .builder
        .ifSome(queue)(_.queue(_))
        .build

    def dashAdditionalManifest(
      manifestNameModifier: Option[String] = None,
      selectedOutputs: Option[List[__stringMin1]] = None
    ): DashAdditionalManifest =
      DashAdditionalManifest
        .builder
        .ifSome(manifestNameModifier)(_.manifestNameModifier(_))
        .ifSome(selectedOutputs)(_.selectedOutputs(_))
        .build

    def dashIsoEncryptionSettings(
      playbackDeviceCompatibility: Option[String] = None,
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): DashIsoEncryptionSettings =
      DashIsoEncryptionSettings
        .builder
        .ifSome(playbackDeviceCompatibility)(_.playbackDeviceCompatibility(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def dashIsoGroupSettings(
      additionalManifests: Option[List[DashAdditionalManifest]] = None,
      audioChannelConfigSchemeIdUri: Option[String] = None,
      baseUrl: Option[String] = None,
      destination: Option[String] = None,
      destinationSettings: Option[DestinationSettings] = None,
      encryption: Option[DashIsoEncryptionSettings] = None,
      fragmentLength: Option[Int] = None,
      hbbtvCompliance: Option[String] = None,
      minBufferTime: Option[Int] = None,
      minFinalSegmentLength: Option[__doubleMin0Max2147483647] = None,
      mpdProfile: Option[String] = None,
      ptsOffsetHandlingForBFrames: Option[String] = None,
      segmentControl: Option[String] = None,
      segmentLength: Option[Int] = None,
      writeSegmentTimelineInRepresentation: Option[String] = None
    ): DashIsoGroupSettings =
      DashIsoGroupSettings
        .builder
        .ifSome(additionalManifests)(_.additionalManifests(_))
        .ifSome(audioChannelConfigSchemeIdUri)(_.audioChannelConfigSchemeIdUri(_))
        .ifSome(baseUrl)(_.baseUrl(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(fragmentLength)(_.fragmentLength(_))
        .ifSome(hbbtvCompliance)(_.hbbtvCompliance(_))
        .ifSome(minBufferTime)(_.minBufferTime(_))
        .ifSome(minFinalSegmentLength)(_.minFinalSegmentLength(_))
        .ifSome(mpdProfile)(_.mpdProfile(_))
        .ifSome(ptsOffsetHandlingForBFrames)(_.ptsOffsetHandlingForBFrames(_))
        .ifSome(segmentControl)(_.segmentControl(_))
        .ifSome(segmentLength)(_.segmentLength(_))
        .ifSome(writeSegmentTimelineInRepresentation)(_.writeSegmentTimelineInRepresentation(_))
        .build

    def deinterlacer(
      algorithm: Option[String] = None,
      control: Option[String] = None,
      mode: Option[String] = None
    ): Deinterlacer =
      Deinterlacer
        .builder
        .ifSome(algorithm)(_.algorithm(_))
        .ifSome(control)(_.control(_))
        .ifSome(mode)(_.mode(_))
        .build

    def deleteJobTemplateRequest(
      name: Option[String] = None
    ): DeleteJobTemplateRequest =
      DeleteJobTemplateRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteJobTemplateResponse(

    ): DeleteJobTemplateResponse =
      DeleteJobTemplateResponse
        .builder

        .build

    def deletePresetRequest(
      name: Option[String] = None
    ): DeletePresetRequest =
      DeletePresetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deletePresetResponse(

    ): DeletePresetResponse =
      DeletePresetResponse
        .builder

        .build

    def deleteQueueRequest(
      name: Option[String] = None
    ): DeleteQueueRequest =
      DeleteQueueRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteQueueResponse(

    ): DeleteQueueResponse =
      DeleteQueueResponse
        .builder

        .build

    def describeEndpointsRequest(
      maxResults: Option[Int] = None,
      mode: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeEndpointsRequest =
      DescribeEndpointsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEndpointsResponse(
      endpoints: Option[List[Endpoint]] = None,
      nextToken: Option[String] = None
    ): DescribeEndpointsResponse =
      DescribeEndpointsResponse
        .builder
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def destinationSettings(
      s3Settings: Option[S3DestinationSettings] = None
    ): DestinationSettings =
      DestinationSettings
        .builder
        .ifSome(s3Settings)(_.s3Settings(_))
        .build

    def disassociateCertificateRequest(
      arn: Option[String] = None
    ): DisassociateCertificateRequest =
      DisassociateCertificateRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def disassociateCertificateResponse(

    ): DisassociateCertificateResponse =
      DisassociateCertificateResponse
        .builder

        .build

    def dolbyVision(
      l6Metadata: Option[DolbyVisionLevel6Metadata] = None,
      l6Mode: Option[String] = None,
      profile: Option[String] = None
    ): DolbyVision =
      DolbyVision
        .builder
        .ifSome(l6Metadata)(_.l6Metadata(_))
        .ifSome(l6Mode)(_.l6Mode(_))
        .ifSome(profile)(_.profile(_))
        .build

    def dolbyVisionLevel6Metadata(
      maxCll: Option[Int] = None,
      maxFall: Option[Int] = None
    ): DolbyVisionLevel6Metadata =
      DolbyVisionLevel6Metadata
        .builder
        .ifSome(maxCll)(_.maxCll(_))
        .ifSome(maxFall)(_.maxFall(_))
        .build

    def dvbNitSettings(
      networkId: Option[Int] = None,
      networkName: Option[String] = None,
      nitInterval: Option[Int] = None
    ): DvbNitSettings =
      DvbNitSettings
        .builder
        .ifSome(networkId)(_.networkId(_))
        .ifSome(networkName)(_.networkName(_))
        .ifSome(nitInterval)(_.nitInterval(_))
        .build

    def dvbSdtSettings(
      outputSdt: Option[String] = None,
      sdtInterval: Option[Int] = None,
      serviceName: Option[String] = None,
      serviceProviderName: Option[String] = None
    ): DvbSdtSettings =
      DvbSdtSettings
        .builder
        .ifSome(outputSdt)(_.outputSdt(_))
        .ifSome(sdtInterval)(_.sdtInterval(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(serviceProviderName)(_.serviceProviderName(_))
        .build

    def dvbSubDestinationSettings(
      alignment: Option[String] = None,
      backgroundColor: Option[String] = None,
      backgroundOpacity: Option[Int] = None,
      ddsHandling: Option[String] = None,
      ddsXCoordinate: Option[Int] = None,
      ddsYCoordinate: Option[Int] = None,
      fontColor: Option[String] = None,
      fontOpacity: Option[Int] = None,
      fontResolution: Option[Int] = None,
      fontScript: Option[String] = None,
      fontSize: Option[Int] = None,
      height: Option[Int] = None,
      outlineColor: Option[String] = None,
      outlineSize: Option[Int] = None,
      shadowColor: Option[String] = None,
      shadowOpacity: Option[Int] = None,
      shadowXOffset: Option[Int] = None,
      shadowYOffset: Option[Int] = None,
      subtitlingType: Option[String] = None,
      teletextSpacing: Option[String] = None,
      width: Option[Int] = None,
      xPosition: Option[Int] = None,
      yPosition: Option[Int] = None
    ): DvbSubDestinationSettings =
      DvbSubDestinationSettings
        .builder
        .ifSome(alignment)(_.alignment(_))
        .ifSome(backgroundColor)(_.backgroundColor(_))
        .ifSome(backgroundOpacity)(_.backgroundOpacity(_))
        .ifSome(ddsHandling)(_.ddsHandling(_))
        .ifSome(ddsXCoordinate)(_.ddsXCoordinate(_))
        .ifSome(ddsYCoordinate)(_.ddsYCoordinate(_))
        .ifSome(fontColor)(_.fontColor(_))
        .ifSome(fontOpacity)(_.fontOpacity(_))
        .ifSome(fontResolution)(_.fontResolution(_))
        .ifSome(fontScript)(_.fontScript(_))
        .ifSome(fontSize)(_.fontSize(_))
        .ifSome(height)(_.height(_))
        .ifSome(outlineColor)(_.outlineColor(_))
        .ifSome(outlineSize)(_.outlineSize(_))
        .ifSome(shadowColor)(_.shadowColor(_))
        .ifSome(shadowOpacity)(_.shadowOpacity(_))
        .ifSome(shadowXOffset)(_.shadowXOffset(_))
        .ifSome(shadowYOffset)(_.shadowYOffset(_))
        .ifSome(subtitlingType)(_.subtitlingType(_))
        .ifSome(teletextSpacing)(_.teletextSpacing(_))
        .ifSome(width)(_.width(_))
        .ifSome(xPosition)(_.xPosition(_))
        .ifSome(yPosition)(_.yPosition(_))
        .build

    def dvbSubSourceSettings(
      pid: Option[Int] = None
    ): DvbSubSourceSettings =
      DvbSubSourceSettings
        .builder
        .ifSome(pid)(_.pid(_))
        .build

    def dvbTdtSettings(
      tdtInterval: Option[Int] = None
    ): DvbTdtSettings =
      DvbTdtSettings
        .builder
        .ifSome(tdtInterval)(_.tdtInterval(_))
        .build

    def eac3AtmosSettings(
      bitrate: Option[Int] = None,
      bitstreamMode: Option[String] = None,
      codingMode: Option[String] = None,
      dialogueIntelligence: Option[String] = None,
      dynamicRangeCompressionLine: Option[String] = None,
      dynamicRangeCompressionRf: Option[String] = None,
      loRoCenterMixLevel: Option[__doubleMinNegative6Max3] = None,
      loRoSurroundMixLevel: Option[__doubleMinNegative60MaxNegative1] = None,
      ltRtCenterMixLevel: Option[__doubleMinNegative6Max3] = None,
      ltRtSurroundMixLevel: Option[__doubleMinNegative60MaxNegative1] = None,
      meteringMode: Option[String] = None,
      sampleRate: Option[Int] = None,
      speechThreshold: Option[Int] = None,
      stereoDownmix: Option[String] = None,
      surroundExMode: Option[String] = None
    ): Eac3AtmosSettings =
      Eac3AtmosSettings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bitstreamMode)(_.bitstreamMode(_))
        .ifSome(codingMode)(_.codingMode(_))
        .ifSome(dialogueIntelligence)(_.dialogueIntelligence(_))
        .ifSome(dynamicRangeCompressionLine)(_.dynamicRangeCompressionLine(_))
        .ifSome(dynamicRangeCompressionRf)(_.dynamicRangeCompressionRf(_))
        .ifSome(loRoCenterMixLevel)(_.loRoCenterMixLevel(_))
        .ifSome(loRoSurroundMixLevel)(_.loRoSurroundMixLevel(_))
        .ifSome(ltRtCenterMixLevel)(_.ltRtCenterMixLevel(_))
        .ifSome(ltRtSurroundMixLevel)(_.ltRtSurroundMixLevel(_))
        .ifSome(meteringMode)(_.meteringMode(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(speechThreshold)(_.speechThreshold(_))
        .ifSome(stereoDownmix)(_.stereoDownmix(_))
        .ifSome(surroundExMode)(_.surroundExMode(_))
        .build

    def eac3Settings(
      attenuationControl: Option[String] = None,
      bitrate: Option[Int] = None,
      bitstreamMode: Option[String] = None,
      codingMode: Option[String] = None,
      dcFilter: Option[String] = None,
      dialnorm: Option[Int] = None,
      dynamicRangeCompressionLine: Option[String] = None,
      dynamicRangeCompressionRf: Option[String] = None,
      lfeControl: Option[String] = None,
      lfeFilter: Option[String] = None,
      loRoCenterMixLevel: Option[__doubleMinNegative60Max3] = None,
      loRoSurroundMixLevel: Option[__doubleMinNegative60MaxNegative1] = None,
      ltRtCenterMixLevel: Option[__doubleMinNegative60Max3] = None,
      ltRtSurroundMixLevel: Option[__doubleMinNegative60MaxNegative1] = None,
      metadataControl: Option[String] = None,
      passthroughControl: Option[String] = None,
      phaseControl: Option[String] = None,
      sampleRate: Option[Int] = None,
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
        .ifSome(dynamicRangeCompressionLine)(_.dynamicRangeCompressionLine(_))
        .ifSome(dynamicRangeCompressionRf)(_.dynamicRangeCompressionRf(_))
        .ifSome(lfeControl)(_.lfeControl(_))
        .ifSome(lfeFilter)(_.lfeFilter(_))
        .ifSome(loRoCenterMixLevel)(_.loRoCenterMixLevel(_))
        .ifSome(loRoSurroundMixLevel)(_.loRoSurroundMixLevel(_))
        .ifSome(ltRtCenterMixLevel)(_.ltRtCenterMixLevel(_))
        .ifSome(ltRtSurroundMixLevel)(_.ltRtSurroundMixLevel(_))
        .ifSome(metadataControl)(_.metadataControl(_))
        .ifSome(passthroughControl)(_.passthroughControl(_))
        .ifSome(phaseControl)(_.phaseControl(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(stereoDownmix)(_.stereoDownmix(_))
        .ifSome(surroundExMode)(_.surroundExMode(_))
        .ifSome(surroundMode)(_.surroundMode(_))
        .build

    def embeddedDestinationSettings(
      destination608ChannelNumber: Option[Int] = None,
      destination708ServiceNumber: Option[Int] = None
    ): EmbeddedDestinationSettings =
      EmbeddedDestinationSettings
        .builder
        .ifSome(destination608ChannelNumber)(_.destination608ChannelNumber(_))
        .ifSome(destination708ServiceNumber)(_.destination708ServiceNumber(_))
        .build

    def embeddedSourceSettings(
      convert608To708: Option[String] = None,
      source608ChannelNumber: Option[Int] = None,
      source608TrackNumber: Option[Int] = None,
      terminateCaptions: Option[String] = None
    ): EmbeddedSourceSettings =
      EmbeddedSourceSettings
        .builder
        .ifSome(convert608To708)(_.convert608To708(_))
        .ifSome(source608ChannelNumber)(_.source608ChannelNumber(_))
        .ifSome(source608TrackNumber)(_.source608TrackNumber(_))
        .ifSome(terminateCaptions)(_.terminateCaptions(_))
        .build

    def endpoint(
      url: Option[String] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(url)(_.url(_))
        .build

    def esamManifestConfirmConditionNotification(
      mccXml: Option[String] = None
    ): EsamManifestConfirmConditionNotification =
      EsamManifestConfirmConditionNotification
        .builder
        .ifSome(mccXml)(_.mccXml(_))
        .build

    def esamSettings(
      manifestConfirmConditionNotification: Option[EsamManifestConfirmConditionNotification] = None,
      responseSignalPreroll: Option[Int] = None,
      signalProcessingNotification: Option[EsamSignalProcessingNotification] = None
    ): EsamSettings =
      EsamSettings
        .builder
        .ifSome(manifestConfirmConditionNotification)(_.manifestConfirmConditionNotification(_))
        .ifSome(responseSignalPreroll)(_.responseSignalPreroll(_))
        .ifSome(signalProcessingNotification)(_.signalProcessingNotification(_))
        .build

    def esamSignalProcessingNotification(
      sccXml: Option[String] = None
    ): EsamSignalProcessingNotification =
      EsamSignalProcessingNotification
        .builder
        .ifSome(sccXml)(_.sccXml(_))
        .build

    def exceptionBody(
      message: Option[String] = None
    ): ExceptionBody =
      ExceptionBody
        .builder
        .ifSome(message)(_.message(_))
        .build

    def f4vSettings(
      moovPlacement: Option[String] = None
    ): F4vSettings =
      F4vSettings
        .builder
        .ifSome(moovPlacement)(_.moovPlacement(_))
        .build

    def fileGroupSettings(
      destination: Option[String] = None,
      destinationSettings: Option[DestinationSettings] = None
    ): FileGroupSettings =
      FileGroupSettings
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .build

    def fileSourceSettings(
      convert608To708: Option[String] = None,
      framerate: Option[CaptionSourceFramerate] = None,
      sourceFile: Option[String] = None,
      timeDelta: Option[Int] = None
    ): FileSourceSettings =
      FileSourceSettings
        .builder
        .ifSome(convert608To708)(_.convert608To708(_))
        .ifSome(framerate)(_.framerate(_))
        .ifSome(sourceFile)(_.sourceFile(_))
        .ifSome(timeDelta)(_.timeDelta(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def frameCaptureSettings(
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      maxCaptures: Option[Int] = None,
      quality: Option[Int] = None
    ): FrameCaptureSettings =
      FrameCaptureSettings
        .builder
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(maxCaptures)(_.maxCaptures(_))
        .ifSome(quality)(_.quality(_))
        .build

    def getJobRequest(
      id: Option[String] = None
    ): GetJobRequest =
      GetJobRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getJobResponse(
      job: Option[Job] = None
    ): GetJobResponse =
      GetJobResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def getJobTemplateRequest(
      name: Option[String] = None
    ): GetJobTemplateRequest =
      GetJobTemplateRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getJobTemplateResponse(
      jobTemplate: Option[JobTemplate] = None
    ): GetJobTemplateResponse =
      GetJobTemplateResponse
        .builder
        .ifSome(jobTemplate)(_.jobTemplate(_))
        .build

    def getPresetRequest(
      name: Option[String] = None
    ): GetPresetRequest =
      GetPresetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getPresetResponse(
      preset: Option[Preset] = None
    ): GetPresetResponse =
      GetPresetResponse
        .builder
        .ifSome(preset)(_.preset(_))
        .build

    def getQueueRequest(
      name: Option[String] = None
    ): GetQueueRequest =
      GetQueueRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getQueueResponse(
      queue: Option[Queue] = None
    ): GetQueueResponse =
      GetQueueResponse
        .builder
        .ifSome(queue)(_.queue(_))
        .build

    def h264QvbrSettings(
      maxAverageBitrate: Option[Int] = None,
      qvbrQualityLevel: Option[Int] = None,
      qvbrQualityLevelFineTune: Option[__doubleMin0Max1] = None
    ): H264QvbrSettings =
      H264QvbrSettings
        .builder
        .ifSome(maxAverageBitrate)(_.maxAverageBitrate(_))
        .ifSome(qvbrQualityLevel)(_.qvbrQualityLevel(_))
        .ifSome(qvbrQualityLevelFineTune)(_.qvbrQualityLevelFineTune(_))
        .build

    def h264Settings(
      adaptiveQuantization: Option[String] = None,
      bitrate: Option[Int] = None,
      codecLevel: Option[String] = None,
      codecProfile: Option[String] = None,
      dynamicSubGop: Option[String] = None,
      entropyEncoding: Option[String] = None,
      fieldEncoding: Option[String] = None,
      flickerAdaptiveQuantization: Option[String] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopBReference: Option[String] = None,
      gopClosedCadence: Option[Int] = None,
      gopSize: Option[__doubleMin0] = None,
      gopSizeUnits: Option[String] = None,
      hrdBufferInitialFillPercentage: Option[Int] = None,
      hrdBufferSize: Option[Int] = None,
      interlaceMode: Option[String] = None,
      maxBitrate: Option[Int] = None,
      minIInterval: Option[Int] = None,
      numberBFramesBetweenReferenceFrames: Option[Int] = None,
      numberReferenceFrames: Option[Int] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      qualityTuningLevel: Option[String] = None,
      qvbrSettings: Option[H264QvbrSettings] = None,
      rateControlMode: Option[String] = None,
      repeatPps: Option[String] = None,
      scanTypeConversionMode: Option[String] = None,
      sceneChangeDetect: Option[String] = None,
      slices: Option[Int] = None,
      slowPal: Option[String] = None,
      softness: Option[Int] = None,
      spatialAdaptiveQuantization: Option[String] = None,
      syntax: Option[String] = None,
      telecine: Option[String] = None,
      temporalAdaptiveQuantization: Option[String] = None,
      unregisteredSeiTimecode: Option[String] = None
    ): H264Settings =
      H264Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(codecLevel)(_.codecLevel(_))
        .ifSome(codecProfile)(_.codecProfile(_))
        .ifSome(dynamicSubGop)(_.dynamicSubGop(_))
        .ifSome(entropyEncoding)(_.entropyEncoding(_))
        .ifSome(fieldEncoding)(_.fieldEncoding(_))
        .ifSome(flickerAdaptiveQuantization)(_.flickerAdaptiveQuantization(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopBReference)(_.gopBReference(_))
        .ifSome(gopClosedCadence)(_.gopClosedCadence(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(gopSizeUnits)(_.gopSizeUnits(_))
        .ifSome(hrdBufferInitialFillPercentage)(_.hrdBufferInitialFillPercentage(_))
        .ifSome(hrdBufferSize)(_.hrdBufferSize(_))
        .ifSome(interlaceMode)(_.interlaceMode(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(minIInterval)(_.minIInterval(_))
        .ifSome(numberBFramesBetweenReferenceFrames)(_.numberBFramesBetweenReferenceFrames(_))
        .ifSome(numberReferenceFrames)(_.numberReferenceFrames(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(qualityTuningLevel)(_.qualityTuningLevel(_))
        .ifSome(qvbrSettings)(_.qvbrSettings(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(repeatPps)(_.repeatPps(_))
        .ifSome(scanTypeConversionMode)(_.scanTypeConversionMode(_))
        .ifSome(sceneChangeDetect)(_.sceneChangeDetect(_))
        .ifSome(slices)(_.slices(_))
        .ifSome(slowPal)(_.slowPal(_))
        .ifSome(softness)(_.softness(_))
        .ifSome(spatialAdaptiveQuantization)(_.spatialAdaptiveQuantization(_))
        .ifSome(syntax)(_.syntax(_))
        .ifSome(telecine)(_.telecine(_))
        .ifSome(temporalAdaptiveQuantization)(_.temporalAdaptiveQuantization(_))
        .ifSome(unregisteredSeiTimecode)(_.unregisteredSeiTimecode(_))
        .build

    def h265QvbrSettings(
      maxAverageBitrate: Option[Int] = None,
      qvbrQualityLevel: Option[Int] = None,
      qvbrQualityLevelFineTune: Option[__doubleMin0Max1] = None
    ): H265QvbrSettings =
      H265QvbrSettings
        .builder
        .ifSome(maxAverageBitrate)(_.maxAverageBitrate(_))
        .ifSome(qvbrQualityLevel)(_.qvbrQualityLevel(_))
        .ifSome(qvbrQualityLevelFineTune)(_.qvbrQualityLevelFineTune(_))
        .build

    def h265Settings(
      adaptiveQuantization: Option[String] = None,
      alternateTransferFunctionSei: Option[String] = None,
      bitrate: Option[Int] = None,
      codecLevel: Option[String] = None,
      codecProfile: Option[String] = None,
      dynamicSubGop: Option[String] = None,
      flickerAdaptiveQuantization: Option[String] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopBReference: Option[String] = None,
      gopClosedCadence: Option[Int] = None,
      gopSize: Option[__doubleMin0] = None,
      gopSizeUnits: Option[String] = None,
      hrdBufferInitialFillPercentage: Option[Int] = None,
      hrdBufferSize: Option[Int] = None,
      interlaceMode: Option[String] = None,
      maxBitrate: Option[Int] = None,
      minIInterval: Option[Int] = None,
      numberBFramesBetweenReferenceFrames: Option[Int] = None,
      numberReferenceFrames: Option[Int] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      qualityTuningLevel: Option[String] = None,
      qvbrSettings: Option[H265QvbrSettings] = None,
      rateControlMode: Option[String] = None,
      sampleAdaptiveOffsetFilterMode: Option[String] = None,
      scanTypeConversionMode: Option[String] = None,
      sceneChangeDetect: Option[String] = None,
      slices: Option[Int] = None,
      slowPal: Option[String] = None,
      spatialAdaptiveQuantization: Option[String] = None,
      telecine: Option[String] = None,
      temporalAdaptiveQuantization: Option[String] = None,
      temporalIds: Option[String] = None,
      tiles: Option[String] = None,
      unregisteredSeiTimecode: Option[String] = None,
      writeMp4PackagingType: Option[String] = None
    ): H265Settings =
      H265Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(alternateTransferFunctionSei)(_.alternateTransferFunctionSei(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(codecLevel)(_.codecLevel(_))
        .ifSome(codecProfile)(_.codecProfile(_))
        .ifSome(dynamicSubGop)(_.dynamicSubGop(_))
        .ifSome(flickerAdaptiveQuantization)(_.flickerAdaptiveQuantization(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopBReference)(_.gopBReference(_))
        .ifSome(gopClosedCadence)(_.gopClosedCadence(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(gopSizeUnits)(_.gopSizeUnits(_))
        .ifSome(hrdBufferInitialFillPercentage)(_.hrdBufferInitialFillPercentage(_))
        .ifSome(hrdBufferSize)(_.hrdBufferSize(_))
        .ifSome(interlaceMode)(_.interlaceMode(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(minIInterval)(_.minIInterval(_))
        .ifSome(numberBFramesBetweenReferenceFrames)(_.numberBFramesBetweenReferenceFrames(_))
        .ifSome(numberReferenceFrames)(_.numberReferenceFrames(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(qualityTuningLevel)(_.qualityTuningLevel(_))
        .ifSome(qvbrSettings)(_.qvbrSettings(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(sampleAdaptiveOffsetFilterMode)(_.sampleAdaptiveOffsetFilterMode(_))
        .ifSome(scanTypeConversionMode)(_.scanTypeConversionMode(_))
        .ifSome(sceneChangeDetect)(_.sceneChangeDetect(_))
        .ifSome(slices)(_.slices(_))
        .ifSome(slowPal)(_.slowPal(_))
        .ifSome(spatialAdaptiveQuantization)(_.spatialAdaptiveQuantization(_))
        .ifSome(telecine)(_.telecine(_))
        .ifSome(temporalAdaptiveQuantization)(_.temporalAdaptiveQuantization(_))
        .ifSome(temporalIds)(_.temporalIds(_))
        .ifSome(tiles)(_.tiles(_))
        .ifSome(unregisteredSeiTimecode)(_.unregisteredSeiTimecode(_))
        .ifSome(writeMp4PackagingType)(_.writeMp4PackagingType(_))
        .build

    def hdr10Metadata(
      bluePrimaryX: Option[Int] = None,
      bluePrimaryY: Option[Int] = None,
      greenPrimaryX: Option[Int] = None,
      greenPrimaryY: Option[Int] = None,
      maxContentLightLevel: Option[Int] = None,
      maxFrameAverageLightLevel: Option[Int] = None,
      maxLuminance: Option[Int] = None,
      minLuminance: Option[Int] = None,
      redPrimaryX: Option[Int] = None,
      redPrimaryY: Option[Int] = None,
      whitePointX: Option[Int] = None,
      whitePointY: Option[Int] = None
    ): Hdr10Metadata =
      Hdr10Metadata
        .builder
        .ifSome(bluePrimaryX)(_.bluePrimaryX(_))
        .ifSome(bluePrimaryY)(_.bluePrimaryY(_))
        .ifSome(greenPrimaryX)(_.greenPrimaryX(_))
        .ifSome(greenPrimaryY)(_.greenPrimaryY(_))
        .ifSome(maxContentLightLevel)(_.maxContentLightLevel(_))
        .ifSome(maxFrameAverageLightLevel)(_.maxFrameAverageLightLevel(_))
        .ifSome(maxLuminance)(_.maxLuminance(_))
        .ifSome(minLuminance)(_.minLuminance(_))
        .ifSome(redPrimaryX)(_.redPrimaryX(_))
        .ifSome(redPrimaryY)(_.redPrimaryY(_))
        .ifSome(whitePointX)(_.whitePointX(_))
        .ifSome(whitePointY)(_.whitePointY(_))
        .build

    def hlsAdditionalManifest(
      manifestNameModifier: Option[String] = None,
      selectedOutputs: Option[List[__stringMin1]] = None
    ): HlsAdditionalManifest =
      HlsAdditionalManifest
        .builder
        .ifSome(manifestNameModifier)(_.manifestNameModifier(_))
        .ifSome(selectedOutputs)(_.selectedOutputs(_))
        .build

    def hlsCaptionLanguageMapping(
      captionChannel: Option[Int] = None,
      customLanguageCode: Option[String] = None,
      languageCode: Option[String] = None,
      languageDescription: Option[String] = None
    ): HlsCaptionLanguageMapping =
      HlsCaptionLanguageMapping
        .builder
        .ifSome(captionChannel)(_.captionChannel(_))
        .ifSome(customLanguageCode)(_.customLanguageCode(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(languageDescription)(_.languageDescription(_))
        .build

    def hlsEncryptionSettings(
      constantInitializationVector: Option[String] = None,
      encryptionMethod: Option[String] = None,
      initializationVectorInManifest: Option[String] = None,
      offlineEncrypted: Option[String] = None,
      spekeKeyProvider: Option[SpekeKeyProvider] = None,
      staticKeyProvider: Option[StaticKeyProvider] = None,
      `type`: Option[String] = None
    ): HlsEncryptionSettings =
      HlsEncryptionSettings
        .builder
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(encryptionMethod)(_.encryptionMethod(_))
        .ifSome(initializationVectorInManifest)(_.initializationVectorInManifest(_))
        .ifSome(offlineEncrypted)(_.offlineEncrypted(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .ifSome(staticKeyProvider)(_.staticKeyProvider(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def hlsGroupSettings(
      adMarkers: Option[List[HlsAdMarkers]] = None,
      additionalManifests: Option[List[HlsAdditionalManifest]] = None,
      audioOnlyHeader: Option[String] = None,
      baseUrl: Option[String] = None,
      captionLanguageMappings: Option[List[HlsCaptionLanguageMapping]] = None,
      captionLanguageSetting: Option[String] = None,
      clientCache: Option[String] = None,
      codecSpecification: Option[String] = None,
      destination: Option[String] = None,
      destinationSettings: Option[DestinationSettings] = None,
      directoryStructure: Option[String] = None,
      encryption: Option[HlsEncryptionSettings] = None,
      manifestCompression: Option[String] = None,
      manifestDurationFormat: Option[String] = None,
      minFinalSegmentLength: Option[__doubleMin0Max2147483647] = None,
      minSegmentLength: Option[Int] = None,
      outputSelection: Option[String] = None,
      programDateTime: Option[String] = None,
      programDateTimePeriod: Option[Int] = None,
      segmentControl: Option[String] = None,
      segmentLength: Option[Int] = None,
      segmentsPerSubdirectory: Option[Int] = None,
      streamInfResolution: Option[String] = None,
      timedMetadataId3Frame: Option[String] = None,
      timedMetadataId3Period: Option[Int] = None,
      timestampDeltaMilliseconds: Option[Int] = None
    ): HlsGroupSettings =
      HlsGroupSettings
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(additionalManifests)(_.additionalManifests(_))
        .ifSome(audioOnlyHeader)(_.audioOnlyHeader(_))
        .ifSome(baseUrl)(_.baseUrl(_))
        .ifSome(captionLanguageMappings)(_.captionLanguageMappings(_))
        .ifSome(captionLanguageSetting)(_.captionLanguageSetting(_))
        .ifSome(clientCache)(_.clientCache(_))
        .ifSome(codecSpecification)(_.codecSpecification(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(directoryStructure)(_.directoryStructure(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(manifestCompression)(_.manifestCompression(_))
        .ifSome(manifestDurationFormat)(_.manifestDurationFormat(_))
        .ifSome(minFinalSegmentLength)(_.minFinalSegmentLength(_))
        .ifSome(minSegmentLength)(_.minSegmentLength(_))
        .ifSome(outputSelection)(_.outputSelection(_))
        .ifSome(programDateTime)(_.programDateTime(_))
        .ifSome(programDateTimePeriod)(_.programDateTimePeriod(_))
        .ifSome(segmentControl)(_.segmentControl(_))
        .ifSome(segmentLength)(_.segmentLength(_))
        .ifSome(segmentsPerSubdirectory)(_.segmentsPerSubdirectory(_))
        .ifSome(streamInfResolution)(_.streamInfResolution(_))
        .ifSome(timedMetadataId3Frame)(_.timedMetadataId3Frame(_))
        .ifSome(timedMetadataId3Period)(_.timedMetadataId3Period(_))
        .ifSome(timestampDeltaMilliseconds)(_.timestampDeltaMilliseconds(_))
        .build

    def hlsSettings(
      audioGroupId: Option[String] = None,
      audioOnlyContainer: Option[String] = None,
      audioRenditionSets: Option[String] = None,
      audioTrackType: Option[String] = None,
      descriptiveVideoServiceFlag: Option[String] = None,
      iFrameOnlyManifest: Option[String] = None,
      segmentModifier: Option[String] = None
    ): HlsSettings =
      HlsSettings
        .builder
        .ifSome(audioGroupId)(_.audioGroupId(_))
        .ifSome(audioOnlyContainer)(_.audioOnlyContainer(_))
        .ifSome(audioRenditionSets)(_.audioRenditionSets(_))
        .ifSome(audioTrackType)(_.audioTrackType(_))
        .ifSome(descriptiveVideoServiceFlag)(_.descriptiveVideoServiceFlag(_))
        .ifSome(iFrameOnlyManifest)(_.iFrameOnlyManifest(_))
        .ifSome(segmentModifier)(_.segmentModifier(_))
        .build

    def hopDestination(
      priority: Option[Int] = None,
      queue: Option[String] = None,
      waitMinutes: Option[Int] = None
    ): HopDestination =
      HopDestination
        .builder
        .ifSome(priority)(_.priority(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(waitMinutes)(_.waitMinutes(_))
        .build

    def id3Insertion(
      id3: Option[String] = None,
      timecode: Option[String] = None
    ): Id3Insertion =
      Id3Insertion
        .builder
        .ifSome(id3)(_.id3(_))
        .ifSome(timecode)(_.timecode(_))
        .build

    def imageInserter(
      insertableImages: Option[List[InsertableImage]] = None
    ): ImageInserter =
      ImageInserter
        .builder
        .ifSome(insertableImages)(_.insertableImages(_))
        .build

    def imscDestinationSettings(
      stylePassthrough: Option[String] = None
    ): ImscDestinationSettings =
      ImscDestinationSettings
        .builder
        .ifSome(stylePassthrough)(_.stylePassthrough(_))
        .build

    def input(
      audioSelectorGroups: Option[__mapOfAudioSelectorGroup] = None,
      audioSelectors: Option[__mapOfAudioSelector] = None,
      captionSelectors: Option[__mapOfCaptionSelector] = None,
      crop: Option[Rectangle] = None,
      deblockFilter: Option[String] = None,
      decryptionSettings: Option[InputDecryptionSettings] = None,
      denoiseFilter: Option[String] = None,
      fileInput: Option[String] = None,
      filterEnable: Option[String] = None,
      filterStrength: Option[Int] = None,
      imageInserter: Option[ImageInserter] = None,
      inputClippings: Option[List[InputClipping]] = None,
      inputScanType: Option[String] = None,
      position: Option[Rectangle] = None,
      programNumber: Option[Int] = None,
      psiControl: Option[String] = None,
      supplementalImps: Option[List[__stringPatternS3ASSETMAPXml]] = None,
      timecodeSource: Option[String] = None,
      timecodeStart: Option[String] = None,
      videoSelector: Option[VideoSelector] = None
    ): Input =
      Input
        .builder
        .ifSome(audioSelectorGroups)(_.audioSelectorGroups(_))
        .ifSome(audioSelectors)(_.audioSelectors(_))
        .ifSome(captionSelectors)(_.captionSelectors(_))
        .ifSome(crop)(_.crop(_))
        .ifSome(deblockFilter)(_.deblockFilter(_))
        .ifSome(decryptionSettings)(_.decryptionSettings(_))
        .ifSome(denoiseFilter)(_.denoiseFilter(_))
        .ifSome(fileInput)(_.fileInput(_))
        .ifSome(filterEnable)(_.filterEnable(_))
        .ifSome(filterStrength)(_.filterStrength(_))
        .ifSome(imageInserter)(_.imageInserter(_))
        .ifSome(inputClippings)(_.inputClippings(_))
        .ifSome(inputScanType)(_.inputScanType(_))
        .ifSome(position)(_.position(_))
        .ifSome(programNumber)(_.programNumber(_))
        .ifSome(psiControl)(_.psiControl(_))
        .ifSome(supplementalImps)(_.supplementalImps(_))
        .ifSome(timecodeSource)(_.timecodeSource(_))
        .ifSome(timecodeStart)(_.timecodeStart(_))
        .ifSome(videoSelector)(_.videoSelector(_))
        .build

    def inputClipping(
      endTimecode: Option[String] = None,
      startTimecode: Option[String] = None
    ): InputClipping =
      InputClipping
        .builder
        .ifSome(endTimecode)(_.endTimecode(_))
        .ifSome(startTimecode)(_.startTimecode(_))
        .build

    def inputDecryptionSettings(
      decryptionMode: Option[String] = None,
      encryptedDecryptionKey: Option[String] = None,
      initializationVector: Option[String] = None,
      kmsKeyRegion: Option[String] = None
    ): InputDecryptionSettings =
      InputDecryptionSettings
        .builder
        .ifSome(decryptionMode)(_.decryptionMode(_))
        .ifSome(encryptedDecryptionKey)(_.encryptedDecryptionKey(_))
        .ifSome(initializationVector)(_.initializationVector(_))
        .ifSome(kmsKeyRegion)(_.kmsKeyRegion(_))
        .build

    def inputTemplate(
      audioSelectorGroups: Option[__mapOfAudioSelectorGroup] = None,
      audioSelectors: Option[__mapOfAudioSelector] = None,
      captionSelectors: Option[__mapOfCaptionSelector] = None,
      crop: Option[Rectangle] = None,
      deblockFilter: Option[String] = None,
      denoiseFilter: Option[String] = None,
      filterEnable: Option[String] = None,
      filterStrength: Option[Int] = None,
      imageInserter: Option[ImageInserter] = None,
      inputClippings: Option[List[InputClipping]] = None,
      inputScanType: Option[String] = None,
      position: Option[Rectangle] = None,
      programNumber: Option[Int] = None,
      psiControl: Option[String] = None,
      timecodeSource: Option[String] = None,
      timecodeStart: Option[String] = None,
      videoSelector: Option[VideoSelector] = None
    ): InputTemplate =
      InputTemplate
        .builder
        .ifSome(audioSelectorGroups)(_.audioSelectorGroups(_))
        .ifSome(audioSelectors)(_.audioSelectors(_))
        .ifSome(captionSelectors)(_.captionSelectors(_))
        .ifSome(crop)(_.crop(_))
        .ifSome(deblockFilter)(_.deblockFilter(_))
        .ifSome(denoiseFilter)(_.denoiseFilter(_))
        .ifSome(filterEnable)(_.filterEnable(_))
        .ifSome(filterStrength)(_.filterStrength(_))
        .ifSome(imageInserter)(_.imageInserter(_))
        .ifSome(inputClippings)(_.inputClippings(_))
        .ifSome(inputScanType)(_.inputScanType(_))
        .ifSome(position)(_.position(_))
        .ifSome(programNumber)(_.programNumber(_))
        .ifSome(psiControl)(_.psiControl(_))
        .ifSome(timecodeSource)(_.timecodeSource(_))
        .ifSome(timecodeStart)(_.timecodeStart(_))
        .ifSome(videoSelector)(_.videoSelector(_))
        .build

    def insertableImage(
      duration: Option[Int] = None,
      fadeIn: Option[Int] = None,
      fadeOut: Option[Int] = None,
      height: Option[Int] = None,
      imageInserterInput: Option[String] = None,
      imageX: Option[Int] = None,
      imageY: Option[Int] = None,
      layer: Option[Int] = None,
      opacity: Option[Int] = None,
      startTime: Option[String] = None,
      width: Option[Int] = None
    ): InsertableImage =
      InsertableImage
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(fadeIn)(_.fadeIn(_))
        .ifSome(fadeOut)(_.fadeOut(_))
        .ifSome(height)(_.height(_))
        .ifSome(imageInserterInput)(_.imageInserterInput(_))
        .ifSome(imageX)(_.imageX(_))
        .ifSome(imageY)(_.imageY(_))
        .ifSome(layer)(_.layer(_))
        .ifSome(opacity)(_.opacity(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(width)(_.width(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def job(
      accelerationSettings: Option[AccelerationSettings] = None,
      accelerationStatus: Option[String] = None,
      arn: Option[String] = None,
      billingTagsSource: Option[String] = None,
      createdAt: Option[__timestampUnix] = None,
      currentPhase: Option[String] = None,
      errorCode: Option[Int] = None,
      errorMessage: Option[String] = None,
      hopDestinations: Option[List[HopDestination]] = None,
      id: Option[String] = None,
      jobPercentComplete: Option[Int] = None,
      jobTemplate: Option[String] = None,
      messages: Option[JobMessages] = None,
      outputGroupDetails: Option[List[OutputGroupDetail]] = None,
      priority: Option[Int] = None,
      queue: Option[String] = None,
      queueTransitions: Option[List[QueueTransition]] = None,
      retryCount: Option[Int] = None,
      role: Option[String] = None,
      settings: Option[JobSettings] = None,
      simulateReservedQueue: Option[String] = None,
      status: Option[String] = None,
      statusUpdateInterval: Option[String] = None,
      timing: Option[Timing] = None,
      userMetadata: Option[__mapOf__string] = None
    ): Job =
      Job
        .builder
        .ifSome(accelerationSettings)(_.accelerationSettings(_))
        .ifSome(accelerationStatus)(_.accelerationStatus(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(billingTagsSource)(_.billingTagsSource(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(currentPhase)(_.currentPhase(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(hopDestinations)(_.hopDestinations(_))
        .ifSome(id)(_.id(_))
        .ifSome(jobPercentComplete)(_.jobPercentComplete(_))
        .ifSome(jobTemplate)(_.jobTemplate(_))
        .ifSome(messages)(_.messages(_))
        .ifSome(outputGroupDetails)(_.outputGroupDetails(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(queueTransitions)(_.queueTransitions(_))
        .ifSome(retryCount)(_.retryCount(_))
        .ifSome(role)(_.role(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(simulateReservedQueue)(_.simulateReservedQueue(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusUpdateInterval)(_.statusUpdateInterval(_))
        .ifSome(timing)(_.timing(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .build

    def jobMessages(
      info: Option[List[__string]] = None,
      warning: Option[List[__string]] = None
    ): JobMessages =
      JobMessages
        .builder
        .ifSome(info)(_.info(_))
        .ifSome(warning)(_.warning(_))
        .build

    def jobSettings(
      adAvailOffset: Option[Int] = None,
      availBlanking: Option[AvailBlanking] = None,
      esam: Option[EsamSettings] = None,
      inputs: Option[List[Input]] = None,
      kantarWatermark: Option[KantarWatermarkSettings] = None,
      motionImageInserter: Option[MotionImageInserter] = None,
      nielsenConfiguration: Option[NielsenConfiguration] = None,
      nielsenNonLinearWatermark: Option[NielsenNonLinearWatermarkSettings] = None,
      outputGroups: Option[List[OutputGroup]] = None,
      timecodeConfig: Option[TimecodeConfig] = None,
      timedMetadataInsertion: Option[TimedMetadataInsertion] = None
    ): JobSettings =
      JobSettings
        .builder
        .ifSome(adAvailOffset)(_.adAvailOffset(_))
        .ifSome(availBlanking)(_.availBlanking(_))
        .ifSome(esam)(_.esam(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(kantarWatermark)(_.kantarWatermark(_))
        .ifSome(motionImageInserter)(_.motionImageInserter(_))
        .ifSome(nielsenConfiguration)(_.nielsenConfiguration(_))
        .ifSome(nielsenNonLinearWatermark)(_.nielsenNonLinearWatermark(_))
        .ifSome(outputGroups)(_.outputGroups(_))
        .ifSome(timecodeConfig)(_.timecodeConfig(_))
        .ifSome(timedMetadataInsertion)(_.timedMetadataInsertion(_))
        .build

    def jobTemplate(
      accelerationSettings: Option[AccelerationSettings] = None,
      arn: Option[String] = None,
      category: Option[String] = None,
      createdAt: Option[__timestampUnix] = None,
      description: Option[String] = None,
      hopDestinations: Option[List[HopDestination]] = None,
      lastUpdated: Option[__timestampUnix] = None,
      name: Option[String] = None,
      priority: Option[Int] = None,
      queue: Option[String] = None,
      settings: Option[JobTemplateSettings] = None,
      statusUpdateInterval: Option[String] = None,
      `type`: Option[String] = None
    ): JobTemplate =
      JobTemplate
        .builder
        .ifSome(accelerationSettings)(_.accelerationSettings(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(category)(_.category(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(hopDestinations)(_.hopDestinations(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(statusUpdateInterval)(_.statusUpdateInterval(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def jobTemplateSettings(
      adAvailOffset: Option[Int] = None,
      availBlanking: Option[AvailBlanking] = None,
      esam: Option[EsamSettings] = None,
      inputs: Option[List[InputTemplate]] = None,
      kantarWatermark: Option[KantarWatermarkSettings] = None,
      motionImageInserter: Option[MotionImageInserter] = None,
      nielsenConfiguration: Option[NielsenConfiguration] = None,
      nielsenNonLinearWatermark: Option[NielsenNonLinearWatermarkSettings] = None,
      outputGroups: Option[List[OutputGroup]] = None,
      timecodeConfig: Option[TimecodeConfig] = None,
      timedMetadataInsertion: Option[TimedMetadataInsertion] = None
    ): JobTemplateSettings =
      JobTemplateSettings
        .builder
        .ifSome(adAvailOffset)(_.adAvailOffset(_))
        .ifSome(availBlanking)(_.availBlanking(_))
        .ifSome(esam)(_.esam(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(kantarWatermark)(_.kantarWatermark(_))
        .ifSome(motionImageInserter)(_.motionImageInserter(_))
        .ifSome(nielsenConfiguration)(_.nielsenConfiguration(_))
        .ifSome(nielsenNonLinearWatermark)(_.nielsenNonLinearWatermark(_))
        .ifSome(outputGroups)(_.outputGroups(_))
        .ifSome(timecodeConfig)(_.timecodeConfig(_))
        .ifSome(timedMetadataInsertion)(_.timedMetadataInsertion(_))
        .build

    def kantarWatermarkSettings(
      channelName: Option[String] = None,
      contentReference: Option[String] = None,
      credentialsSecretName: Option[String] = None,
      fileOffset: Option[__doubleMin0] = None,
      kantarLicenseId: Option[Int] = None,
      kantarServerUrl: Option[String] = None,
      logDestination: Option[String] = None,
      metadata3: Option[String] = None,
      metadata4: Option[String] = None,
      metadata5: Option[String] = None,
      metadata6: Option[String] = None,
      metadata7: Option[String] = None,
      metadata8: Option[String] = None
    ): KantarWatermarkSettings =
      KantarWatermarkSettings
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(contentReference)(_.contentReference(_))
        .ifSome(credentialsSecretName)(_.credentialsSecretName(_))
        .ifSome(fileOffset)(_.fileOffset(_))
        .ifSome(kantarLicenseId)(_.kantarLicenseId(_))
        .ifSome(kantarServerUrl)(_.kantarServerUrl(_))
        .ifSome(logDestination)(_.logDestination(_))
        .ifSome(metadata3)(_.metadata3(_))
        .ifSome(metadata4)(_.metadata4(_))
        .ifSome(metadata5)(_.metadata5(_))
        .ifSome(metadata6)(_.metadata6(_))
        .ifSome(metadata7)(_.metadata7(_))
        .ifSome(metadata8)(_.metadata8(_))
        .build

    def listJobTemplatesRequest(
      category: Option[String] = None,
      listBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      order: Option[String] = None
    ): ListJobTemplatesRequest =
      ListJobTemplatesRequest
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(listBy)(_.listBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(order)(_.order(_))
        .build

    def listJobTemplatesResponse(
      jobTemplates: Option[List[JobTemplate]] = None,
      nextToken: Option[String] = None
    ): ListJobTemplatesResponse =
      ListJobTemplatesResponse
        .builder
        .ifSome(jobTemplates)(_.jobTemplates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      order: Option[String] = None,
      queue: Option[String] = None,
      status: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(order)(_.order(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(status)(_.status(_))
        .build

    def listJobsResponse(
      jobs: Option[List[Job]] = None,
      nextToken: Option[String] = None
    ): ListJobsResponse =
      ListJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPresetsRequest(
      category: Option[String] = None,
      listBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      order: Option[String] = None
    ): ListPresetsRequest =
      ListPresetsRequest
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(listBy)(_.listBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(order)(_.order(_))
        .build

    def listPresetsResponse(
      nextToken: Option[String] = None,
      presets: Option[List[Preset]] = None
    ): ListPresetsResponse =
      ListPresetsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(presets)(_.presets(_))
        .build

    def listQueuesRequest(
      listBy: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      order: Option[String] = None
    ): ListQueuesRequest =
      ListQueuesRequest
        .builder
        .ifSome(listBy)(_.listBy(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(order)(_.order(_))
        .build

    def listQueuesResponse(
      nextToken: Option[String] = None,
      queues: Option[List[Queue]] = None
    ): ListQueuesResponse =
      ListQueuesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(queues)(_.queues(_))
        .build

    def listTagsForResourceRequest(
      arn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def listTagsForResourceResponse(
      resourceTags: Option[ResourceTags] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(resourceTags)(_.resourceTags(_))
        .build

    def m2tsScte35Esam(
      scte35EsamPid: Option[Int] = None
    ): M2tsScte35Esam =
      M2tsScte35Esam
        .builder
        .ifSome(scte35EsamPid)(_.scte35EsamPid(_))
        .build

    def m2tsSettings(
      audioBufferModel: Option[String] = None,
      audioDuration: Option[String] = None,
      audioFramesPerPes: Option[Int] = None,
      audioPids: Option[List[__integerMin32Max8182]] = None,
      bitrate: Option[Int] = None,
      bufferModel: Option[String] = None,
      dvbNitSettings: Option[DvbNitSettings] = None,
      dvbSdtSettings: Option[DvbSdtSettings] = None,
      dvbSubPids: Option[List[__integerMin32Max8182]] = None,
      dvbTdtSettings: Option[DvbTdtSettings] = None,
      dvbTeletextPid: Option[Int] = None,
      ebpAudioInterval: Option[String] = None,
      ebpPlacement: Option[String] = None,
      esRateInPes: Option[String] = None,
      forceTsVideoEbpOrder: Option[String] = None,
      fragmentTime: Option[__doubleMin0] = None,
      maxPcrInterval: Option[Int] = None,
      minEbpInterval: Option[Int] = None,
      nielsenId3: Option[String] = None,
      nullPacketBitrate: Option[__doubleMin0] = None,
      patInterval: Option[Int] = None,
      pcrControl: Option[String] = None,
      pcrPid: Option[Int] = None,
      pmtInterval: Option[Int] = None,
      pmtPid: Option[Int] = None,
      privateMetadataPid: Option[Int] = None,
      programNumber: Option[Int] = None,
      rateMode: Option[String] = None,
      scte35Esam: Option[M2tsScte35Esam] = None,
      scte35Pid: Option[Int] = None,
      scte35Source: Option[String] = None,
      segmentationMarkers: Option[String] = None,
      segmentationStyle: Option[String] = None,
      segmentationTime: Option[__doubleMin0] = None,
      timedMetadataPid: Option[Int] = None,
      transportStreamId: Option[Int] = None,
      videoPid: Option[Int] = None
    ): M2tsSettings =
      M2tsSettings
        .builder
        .ifSome(audioBufferModel)(_.audioBufferModel(_))
        .ifSome(audioDuration)(_.audioDuration(_))
        .ifSome(audioFramesPerPes)(_.audioFramesPerPes(_))
        .ifSome(audioPids)(_.audioPids(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(bufferModel)(_.bufferModel(_))
        .ifSome(dvbNitSettings)(_.dvbNitSettings(_))
        .ifSome(dvbSdtSettings)(_.dvbSdtSettings(_))
        .ifSome(dvbSubPids)(_.dvbSubPids(_))
        .ifSome(dvbTdtSettings)(_.dvbTdtSettings(_))
        .ifSome(dvbTeletextPid)(_.dvbTeletextPid(_))
        .ifSome(ebpAudioInterval)(_.ebpAudioInterval(_))
        .ifSome(ebpPlacement)(_.ebpPlacement(_))
        .ifSome(esRateInPes)(_.esRateInPes(_))
        .ifSome(forceTsVideoEbpOrder)(_.forceTsVideoEbpOrder(_))
        .ifSome(fragmentTime)(_.fragmentTime(_))
        .ifSome(maxPcrInterval)(_.maxPcrInterval(_))
        .ifSome(minEbpInterval)(_.minEbpInterval(_))
        .ifSome(nielsenId3)(_.nielsenId3(_))
        .ifSome(nullPacketBitrate)(_.nullPacketBitrate(_))
        .ifSome(patInterval)(_.patInterval(_))
        .ifSome(pcrControl)(_.pcrControl(_))
        .ifSome(pcrPid)(_.pcrPid(_))
        .ifSome(pmtInterval)(_.pmtInterval(_))
        .ifSome(pmtPid)(_.pmtPid(_))
        .ifSome(privateMetadataPid)(_.privateMetadataPid(_))
        .ifSome(programNumber)(_.programNumber(_))
        .ifSome(rateMode)(_.rateMode(_))
        .ifSome(scte35Esam)(_.scte35Esam(_))
        .ifSome(scte35Pid)(_.scte35Pid(_))
        .ifSome(scte35Source)(_.scte35Source(_))
        .ifSome(segmentationMarkers)(_.segmentationMarkers(_))
        .ifSome(segmentationStyle)(_.segmentationStyle(_))
        .ifSome(segmentationTime)(_.segmentationTime(_))
        .ifSome(timedMetadataPid)(_.timedMetadataPid(_))
        .ifSome(transportStreamId)(_.transportStreamId(_))
        .ifSome(videoPid)(_.videoPid(_))
        .build

    def m3u8Settings(
      audioDuration: Option[String] = None,
      audioFramesPerPes: Option[Int] = None,
      audioPids: Option[List[__integerMin32Max8182]] = None,
      maxPcrInterval: Option[Int] = None,
      nielsenId3: Option[String] = None,
      patInterval: Option[Int] = None,
      pcrControl: Option[String] = None,
      pcrPid: Option[Int] = None,
      pmtInterval: Option[Int] = None,
      pmtPid: Option[Int] = None,
      privateMetadataPid: Option[Int] = None,
      programNumber: Option[Int] = None,
      scte35Pid: Option[Int] = None,
      scte35Source: Option[String] = None,
      timedMetadata: Option[String] = None,
      timedMetadataPid: Option[Int] = None,
      transportStreamId: Option[Int] = None,
      videoPid: Option[Int] = None
    ): M3u8Settings =
      M3u8Settings
        .builder
        .ifSome(audioDuration)(_.audioDuration(_))
        .ifSome(audioFramesPerPes)(_.audioFramesPerPes(_))
        .ifSome(audioPids)(_.audioPids(_))
        .ifSome(maxPcrInterval)(_.maxPcrInterval(_))
        .ifSome(nielsenId3)(_.nielsenId3(_))
        .ifSome(patInterval)(_.patInterval(_))
        .ifSome(pcrControl)(_.pcrControl(_))
        .ifSome(pcrPid)(_.pcrPid(_))
        .ifSome(pmtInterval)(_.pmtInterval(_))
        .ifSome(pmtPid)(_.pmtPid(_))
        .ifSome(privateMetadataPid)(_.privateMetadataPid(_))
        .ifSome(programNumber)(_.programNumber(_))
        .ifSome(scte35Pid)(_.scte35Pid(_))
        .ifSome(scte35Source)(_.scte35Source(_))
        .ifSome(timedMetadata)(_.timedMetadata(_))
        .ifSome(timedMetadataPid)(_.timedMetadataPid(_))
        .ifSome(transportStreamId)(_.transportStreamId(_))
        .ifSome(videoPid)(_.videoPid(_))
        .build

    def motionImageInserter(
      framerate: Option[MotionImageInsertionFramerate] = None,
      input: Option[String] = None,
      insertionMode: Option[String] = None,
      offset: Option[MotionImageInsertionOffset] = None,
      playback: Option[String] = None,
      startTime: Option[String] = None
    ): MotionImageInserter =
      MotionImageInserter
        .builder
        .ifSome(framerate)(_.framerate(_))
        .ifSome(input)(_.input(_))
        .ifSome(insertionMode)(_.insertionMode(_))
        .ifSome(offset)(_.offset(_))
        .ifSome(playback)(_.playback(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def motionImageInsertionFramerate(
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None
    ): MotionImageInsertionFramerate =
      MotionImageInsertionFramerate
        .builder
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .build

    def motionImageInsertionOffset(
      imageX: Option[Int] = None,
      imageY: Option[Int] = None
    ): MotionImageInsertionOffset =
      MotionImageInsertionOffset
        .builder
        .ifSome(imageX)(_.imageX(_))
        .ifSome(imageY)(_.imageY(_))
        .build

    def movSettings(
      clapAtom: Option[String] = None,
      cslgAtom: Option[String] = None,
      mpeg2FourCCControl: Option[String] = None,
      paddingControl: Option[String] = None,
      reference: Option[String] = None
    ): MovSettings =
      MovSettings
        .builder
        .ifSome(clapAtom)(_.clapAtom(_))
        .ifSome(cslgAtom)(_.cslgAtom(_))
        .ifSome(mpeg2FourCCControl)(_.mpeg2FourCCControl(_))
        .ifSome(paddingControl)(_.paddingControl(_))
        .ifSome(reference)(_.reference(_))
        .build

    def mp2Settings(
      bitrate: Option[Int] = None,
      channels: Option[Int] = None,
      sampleRate: Option[Int] = None
    ): Mp2Settings =
      Mp2Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(channels)(_.channels(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def mp3Settings(
      bitrate: Option[Int] = None,
      channels: Option[Int] = None,
      rateControlMode: Option[String] = None,
      sampleRate: Option[Int] = None,
      vbrQuality: Option[Int] = None
    ): Mp3Settings =
      Mp3Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(channels)(_.channels(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(vbrQuality)(_.vbrQuality(_))
        .build

    def mp4Settings(
      audioDuration: Option[String] = None,
      cslgAtom: Option[String] = None,
      cttsVersion: Option[Int] = None,
      freeSpaceBox: Option[String] = None,
      moovPlacement: Option[String] = None,
      mp4MajorBrand: Option[String] = None
    ): Mp4Settings =
      Mp4Settings
        .builder
        .ifSome(audioDuration)(_.audioDuration(_))
        .ifSome(cslgAtom)(_.cslgAtom(_))
        .ifSome(cttsVersion)(_.cttsVersion(_))
        .ifSome(freeSpaceBox)(_.freeSpaceBox(_))
        .ifSome(moovPlacement)(_.moovPlacement(_))
        .ifSome(mp4MajorBrand)(_.mp4MajorBrand(_))
        .build

    def mpdSettings(
      accessibilityCaptionHints: Option[String] = None,
      audioDuration: Option[String] = None,
      captionContainerType: Option[String] = None,
      scte35Esam: Option[String] = None,
      scte35Source: Option[String] = None
    ): MpdSettings =
      MpdSettings
        .builder
        .ifSome(accessibilityCaptionHints)(_.accessibilityCaptionHints(_))
        .ifSome(audioDuration)(_.audioDuration(_))
        .ifSome(captionContainerType)(_.captionContainerType(_))
        .ifSome(scte35Esam)(_.scte35Esam(_))
        .ifSome(scte35Source)(_.scte35Source(_))
        .build

    def mpeg2Settings(
      adaptiveQuantization: Option[String] = None,
      bitrate: Option[Int] = None,
      codecLevel: Option[String] = None,
      codecProfile: Option[String] = None,
      dynamicSubGop: Option[String] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopClosedCadence: Option[Int] = None,
      gopSize: Option[__doubleMin0] = None,
      gopSizeUnits: Option[String] = None,
      hrdBufferInitialFillPercentage: Option[Int] = None,
      hrdBufferSize: Option[Int] = None,
      interlaceMode: Option[String] = None,
      intraDcPrecision: Option[String] = None,
      maxBitrate: Option[Int] = None,
      minIInterval: Option[Int] = None,
      numberBFramesBetweenReferenceFrames: Option[Int] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      qualityTuningLevel: Option[String] = None,
      rateControlMode: Option[String] = None,
      scanTypeConversionMode: Option[String] = None,
      sceneChangeDetect: Option[String] = None,
      slowPal: Option[String] = None,
      softness: Option[Int] = None,
      spatialAdaptiveQuantization: Option[String] = None,
      syntax: Option[String] = None,
      telecine: Option[String] = None,
      temporalAdaptiveQuantization: Option[String] = None
    ): Mpeg2Settings =
      Mpeg2Settings
        .builder
        .ifSome(adaptiveQuantization)(_.adaptiveQuantization(_))
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(codecLevel)(_.codecLevel(_))
        .ifSome(codecProfile)(_.codecProfile(_))
        .ifSome(dynamicSubGop)(_.dynamicSubGop(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopClosedCadence)(_.gopClosedCadence(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(gopSizeUnits)(_.gopSizeUnits(_))
        .ifSome(hrdBufferInitialFillPercentage)(_.hrdBufferInitialFillPercentage(_))
        .ifSome(hrdBufferSize)(_.hrdBufferSize(_))
        .ifSome(interlaceMode)(_.interlaceMode(_))
        .ifSome(intraDcPrecision)(_.intraDcPrecision(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(minIInterval)(_.minIInterval(_))
        .ifSome(numberBFramesBetweenReferenceFrames)(_.numberBFramesBetweenReferenceFrames(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(qualityTuningLevel)(_.qualityTuningLevel(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .ifSome(scanTypeConversionMode)(_.scanTypeConversionMode(_))
        .ifSome(sceneChangeDetect)(_.sceneChangeDetect(_))
        .ifSome(slowPal)(_.slowPal(_))
        .ifSome(softness)(_.softness(_))
        .ifSome(spatialAdaptiveQuantization)(_.spatialAdaptiveQuantization(_))
        .ifSome(syntax)(_.syntax(_))
        .ifSome(telecine)(_.telecine(_))
        .ifSome(temporalAdaptiveQuantization)(_.temporalAdaptiveQuantization(_))
        .build

    def msSmoothAdditionalManifest(
      manifestNameModifier: Option[String] = None,
      selectedOutputs: Option[List[__stringMin1]] = None
    ): MsSmoothAdditionalManifest =
      MsSmoothAdditionalManifest
        .builder
        .ifSome(manifestNameModifier)(_.manifestNameModifier(_))
        .ifSome(selectedOutputs)(_.selectedOutputs(_))
        .build

    def msSmoothEncryptionSettings(
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): MsSmoothEncryptionSettings =
      MsSmoothEncryptionSettings
        .builder
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def msSmoothGroupSettings(
      additionalManifests: Option[List[MsSmoothAdditionalManifest]] = None,
      audioDeduplication: Option[String] = None,
      destination: Option[String] = None,
      destinationSettings: Option[DestinationSettings] = None,
      encryption: Option[MsSmoothEncryptionSettings] = None,
      fragmentLength: Option[Int] = None,
      manifestEncoding: Option[String] = None
    ): MsSmoothGroupSettings =
      MsSmoothGroupSettings
        .builder
        .ifSome(additionalManifests)(_.additionalManifests(_))
        .ifSome(audioDeduplication)(_.audioDeduplication(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(destinationSettings)(_.destinationSettings(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(fragmentLength)(_.fragmentLength(_))
        .ifSome(manifestEncoding)(_.manifestEncoding(_))
        .build

    def mxfSettings(
      afdSignaling: Option[String] = None,
      profile: Option[String] = None
    ): MxfSettings =
      MxfSettings
        .builder
        .ifSome(afdSignaling)(_.afdSignaling(_))
        .ifSome(profile)(_.profile(_))
        .build

    def nexGuardFileMarkerSettings(
      license: Option[String] = None,
      payload: Option[Int] = None,
      preset: Option[String] = None,
      strength: Option[String] = None
    ): NexGuardFileMarkerSettings =
      NexGuardFileMarkerSettings
        .builder
        .ifSome(license)(_.license(_))
        .ifSome(payload)(_.payload(_))
        .ifSome(preset)(_.preset(_))
        .ifSome(strength)(_.strength(_))
        .build

    def nielsenConfiguration(
      breakoutCode: Option[Int] = None,
      distributorId: Option[String] = None
    ): NielsenConfiguration =
      NielsenConfiguration
        .builder
        .ifSome(breakoutCode)(_.breakoutCode(_))
        .ifSome(distributorId)(_.distributorId(_))
        .build

    def nielsenNonLinearWatermarkSettings(
      activeWatermarkProcess: Option[String] = None,
      adiFilename: Option[String] = None,
      assetId: Option[String] = None,
      assetName: Option[String] = None,
      cbetSourceId: Option[String] = None,
      episodeId: Option[String] = None,
      metadataDestination: Option[String] = None,
      sourceId: Option[Int] = None,
      sourceWatermarkStatus: Option[String] = None,
      ticServerUrl: Option[String] = None,
      uniqueTicPerAudioTrack: Option[String] = None
    ): NielsenNonLinearWatermarkSettings =
      NielsenNonLinearWatermarkSettings
        .builder
        .ifSome(activeWatermarkProcess)(_.activeWatermarkProcess(_))
        .ifSome(adiFilename)(_.adiFilename(_))
        .ifSome(assetId)(_.assetId(_))
        .ifSome(assetName)(_.assetName(_))
        .ifSome(cbetSourceId)(_.cbetSourceId(_))
        .ifSome(episodeId)(_.episodeId(_))
        .ifSome(metadataDestination)(_.metadataDestination(_))
        .ifSome(sourceId)(_.sourceId(_))
        .ifSome(sourceWatermarkStatus)(_.sourceWatermarkStatus(_))
        .ifSome(ticServerUrl)(_.ticServerUrl(_))
        .ifSome(uniqueTicPerAudioTrack)(_.uniqueTicPerAudioTrack(_))
        .build

    def noiseReducer(
      filter: Option[String] = None,
      filterSettings: Option[NoiseReducerFilterSettings] = None,
      spatialFilterSettings: Option[NoiseReducerSpatialFilterSettings] = None,
      temporalFilterSettings: Option[NoiseReducerTemporalFilterSettings] = None
    ): NoiseReducer =
      NoiseReducer
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(filterSettings)(_.filterSettings(_))
        .ifSome(spatialFilterSettings)(_.spatialFilterSettings(_))
        .ifSome(temporalFilterSettings)(_.temporalFilterSettings(_))
        .build

    def noiseReducerFilterSettings(
      strength: Option[Int] = None
    ): NoiseReducerFilterSettings =
      NoiseReducerFilterSettings
        .builder
        .ifSome(strength)(_.strength(_))
        .build

    def noiseReducerSpatialFilterSettings(
      postFilterSharpenStrength: Option[Int] = None,
      speed: Option[Int] = None,
      strength: Option[Int] = None
    ): NoiseReducerSpatialFilterSettings =
      NoiseReducerSpatialFilterSettings
        .builder
        .ifSome(postFilterSharpenStrength)(_.postFilterSharpenStrength(_))
        .ifSome(speed)(_.speed(_))
        .ifSome(strength)(_.strength(_))
        .build

    def noiseReducerTemporalFilterSettings(
      aggressiveMode: Option[Int] = None,
      postTemporalSharpening: Option[String] = None,
      speed: Option[Int] = None,
      strength: Option[Int] = None
    ): NoiseReducerTemporalFilterSettings =
      NoiseReducerTemporalFilterSettings
        .builder
        .ifSome(aggressiveMode)(_.aggressiveMode(_))
        .ifSome(postTemporalSharpening)(_.postTemporalSharpening(_))
        .ifSome(speed)(_.speed(_))
        .ifSome(strength)(_.strength(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def opusSettings(
      bitrate: Option[Int] = None,
      channels: Option[Int] = None,
      sampleRate: Option[Int] = None
    ): OpusSettings =
      OpusSettings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(channels)(_.channels(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def output(
      audioDescriptions: Option[List[AudioDescription]] = None,
      captionDescriptions: Option[List[CaptionDescription]] = None,
      containerSettings: Option[ContainerSettings] = None,
      extension: Option[String] = None,
      nameModifier: Option[String] = None,
      outputSettings: Option[OutputSettings] = None,
      preset: Option[String] = None,
      videoDescription: Option[VideoDescription] = None
    ): Output =
      Output
        .builder
        .ifSome(audioDescriptions)(_.audioDescriptions(_))
        .ifSome(captionDescriptions)(_.captionDescriptions(_))
        .ifSome(containerSettings)(_.containerSettings(_))
        .ifSome(extension)(_.extension(_))
        .ifSome(nameModifier)(_.nameModifier(_))
        .ifSome(outputSettings)(_.outputSettings(_))
        .ifSome(preset)(_.preset(_))
        .ifSome(videoDescription)(_.videoDescription(_))
        .build

    def outputChannelMapping(
      inputChannels: Option[List[__integerMinNegative60Max6]] = None,
      inputChannelsFineTune: Option[List[__doubleMinNegative60Max6]] = None
    ): OutputChannelMapping =
      OutputChannelMapping
        .builder
        .ifSome(inputChannels)(_.inputChannels(_))
        .ifSome(inputChannelsFineTune)(_.inputChannelsFineTune(_))
        .build

    def outputDetail(
      durationInMs: Option[Int] = None,
      videoDetails: Option[VideoDetail] = None
    ): OutputDetail =
      OutputDetail
        .builder
        .ifSome(durationInMs)(_.durationInMs(_))
        .ifSome(videoDetails)(_.videoDetails(_))
        .build

    def outputGroup(
      automatedEncodingSettings: Option[AutomatedEncodingSettings] = None,
      customName: Option[String] = None,
      name: Option[String] = None,
      outputGroupSettings: Option[OutputGroupSettings] = None,
      outputs: Option[List[Output]] = None
    ): OutputGroup =
      OutputGroup
        .builder
        .ifSome(automatedEncodingSettings)(_.automatedEncodingSettings(_))
        .ifSome(customName)(_.customName(_))
        .ifSome(name)(_.name(_))
        .ifSome(outputGroupSettings)(_.outputGroupSettings(_))
        .ifSome(outputs)(_.outputs(_))
        .build

    def outputGroupDetail(
      outputDetails: Option[List[OutputDetail]] = None
    ): OutputGroupDetail =
      OutputGroupDetail
        .builder
        .ifSome(outputDetails)(_.outputDetails(_))
        .build

    def outputGroupSettings(
      cmafGroupSettings: Option[CmafGroupSettings] = None,
      dashIsoGroupSettings: Option[DashIsoGroupSettings] = None,
      fileGroupSettings: Option[FileGroupSettings] = None,
      hlsGroupSettings: Option[HlsGroupSettings] = None,
      msSmoothGroupSettings: Option[MsSmoothGroupSettings] = None,
      `type`: Option[String] = None
    ): OutputGroupSettings =
      OutputGroupSettings
        .builder
        .ifSome(cmafGroupSettings)(_.cmafGroupSettings(_))
        .ifSome(dashIsoGroupSettings)(_.dashIsoGroupSettings(_))
        .ifSome(fileGroupSettings)(_.fileGroupSettings(_))
        .ifSome(hlsGroupSettings)(_.hlsGroupSettings(_))
        .ifSome(msSmoothGroupSettings)(_.msSmoothGroupSettings(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def outputSettings(
      hlsSettings: Option[HlsSettings] = None
    ): OutputSettings =
      OutputSettings
        .builder
        .ifSome(hlsSettings)(_.hlsSettings(_))
        .build

    def partnerWatermarking(
      nexguardFileMarkerSettings: Option[NexGuardFileMarkerSettings] = None
    ): PartnerWatermarking =
      PartnerWatermarking
        .builder
        .ifSome(nexguardFileMarkerSettings)(_.nexguardFileMarkerSettings(_))
        .build

    def preset(
      arn: Option[String] = None,
      category: Option[String] = None,
      createdAt: Option[__timestampUnix] = None,
      description: Option[String] = None,
      lastUpdated: Option[__timestampUnix] = None,
      name: Option[String] = None,
      settings: Option[PresetSettings] = None,
      `type`: Option[String] = None
    ): Preset =
      Preset
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(category)(_.category(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(name)(_.name(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def presetSettings(
      audioDescriptions: Option[List[AudioDescription]] = None,
      captionDescriptions: Option[List[CaptionDescriptionPreset]] = None,
      containerSettings: Option[ContainerSettings] = None,
      videoDescription: Option[VideoDescription] = None
    ): PresetSettings =
      PresetSettings
        .builder
        .ifSome(audioDescriptions)(_.audioDescriptions(_))
        .ifSome(captionDescriptions)(_.captionDescriptions(_))
        .ifSome(containerSettings)(_.containerSettings(_))
        .ifSome(videoDescription)(_.videoDescription(_))
        .build

    def proresSettings(
      codecProfile: Option[String] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      interlaceMode: Option[String] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      scanTypeConversionMode: Option[String] = None,
      slowPal: Option[String] = None,
      telecine: Option[String] = None
    ): ProresSettings =
      ProresSettings
        .builder
        .ifSome(codecProfile)(_.codecProfile(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(interlaceMode)(_.interlaceMode(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(scanTypeConversionMode)(_.scanTypeConversionMode(_))
        .ifSome(slowPal)(_.slowPal(_))
        .ifSome(telecine)(_.telecine(_))
        .build

    def queue(
      arn: Option[String] = None,
      createdAt: Option[__timestampUnix] = None,
      description: Option[String] = None,
      lastUpdated: Option[__timestampUnix] = None,
      name: Option[String] = None,
      pricingPlan: Option[String] = None,
      progressingJobsCount: Option[Int] = None,
      reservationPlan: Option[ReservationPlan] = None,
      status: Option[String] = None,
      submittedJobsCount: Option[Int] = None,
      `type`: Option[String] = None
    ): Queue =
      Queue
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(name)(_.name(_))
        .ifSome(pricingPlan)(_.pricingPlan(_))
        .ifSome(progressingJobsCount)(_.progressingJobsCount(_))
        .ifSome(reservationPlan)(_.reservationPlan(_))
        .ifSome(status)(_.status(_))
        .ifSome(submittedJobsCount)(_.submittedJobsCount(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def queueTransition(
      destinationQueue: Option[String] = None,
      sourceQueue: Option[String] = None,
      timestamp: Option[__timestampUnix] = None
    ): QueueTransition =
      QueueTransition
        .builder
        .ifSome(destinationQueue)(_.destinationQueue(_))
        .ifSome(sourceQueue)(_.sourceQueue(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def rectangle(
      height: Option[Int] = None,
      width: Option[Int] = None,
      x: Option[Int] = None,
      y: Option[Int] = None
    ): Rectangle =
      Rectangle
        .builder
        .ifSome(height)(_.height(_))
        .ifSome(width)(_.width(_))
        .ifSome(x)(_.x(_))
        .ifSome(y)(_.y(_))
        .build

    def remixSettings(
      channelMapping: Option[ChannelMapping] = None,
      channelsIn: Option[Int] = None,
      channelsOut: Option[Int] = None
    ): RemixSettings =
      RemixSettings
        .builder
        .ifSome(channelMapping)(_.channelMapping(_))
        .ifSome(channelsIn)(_.channelsIn(_))
        .ifSome(channelsOut)(_.channelsOut(_))
        .build

    def reservationPlan(
      commitment: Option[String] = None,
      expiresAt: Option[__timestampUnix] = None,
      purchasedAt: Option[__timestampUnix] = None,
      renewalType: Option[String] = None,
      reservedSlots: Option[Int] = None,
      status: Option[String] = None
    ): ReservationPlan =
      ReservationPlan
        .builder
        .ifSome(commitment)(_.commitment(_))
        .ifSome(expiresAt)(_.expiresAt(_))
        .ifSome(purchasedAt)(_.purchasedAt(_))
        .ifSome(renewalType)(_.renewalType(_))
        .ifSome(reservedSlots)(_.reservedSlots(_))
        .ifSome(status)(_.status(_))
        .build

    def reservationPlanSettings(
      commitment: Option[String] = None,
      renewalType: Option[String] = None,
      reservedSlots: Option[Int] = None
    ): ReservationPlanSettings =
      ReservationPlanSettings
        .builder
        .ifSome(commitment)(_.commitment(_))
        .ifSome(renewalType)(_.renewalType(_))
        .ifSome(reservedSlots)(_.reservedSlots(_))
        .build

    def resourceTags(
      arn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): ResourceTags =
      ResourceTags
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def s3DestinationAccessControl(
      cannedAcl: Option[String] = None
    ): S3DestinationAccessControl =
      S3DestinationAccessControl
        .builder
        .ifSome(cannedAcl)(_.cannedAcl(_))
        .build

    def s3DestinationSettings(
      accessControl: Option[S3DestinationAccessControl] = None,
      encryption: Option[S3EncryptionSettings] = None
    ): S3DestinationSettings =
      S3DestinationSettings
        .builder
        .ifSome(accessControl)(_.accessControl(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def s3EncryptionSettings(
      encryptionType: Option[String] = None,
      kmsKeyArn: Option[String] = None
    ): S3EncryptionSettings =
      S3EncryptionSettings
        .builder
        .ifSome(encryptionType)(_.encryptionType(_))
        .ifSome(kmsKeyArn)(_.kmsKeyArn(_))
        .build

    def sccDestinationSettings(
      framerate: Option[String] = None
    ): SccDestinationSettings =
      SccDestinationSettings
        .builder
        .ifSome(framerate)(_.framerate(_))
        .build

    def spekeKeyProvider(
      certificateArn: Option[String] = None,
      resourceId: Option[String] = None,
      systemIds: Option[List[__stringPattern09aFAF809aFAF409aFAF409aFAF409aFAF12]] = None,
      url: Option[String] = None
    ): SpekeKeyProvider =
      SpekeKeyProvider
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(systemIds)(_.systemIds(_))
        .ifSome(url)(_.url(_))
        .build

    def spekeKeyProviderCmaf(
      certificateArn: Option[String] = None,
      dashSignaledSystemIds: Option[List[__stringMin36Max36Pattern09aFAF809aFAF409aFAF409aFAF409aFAF12]] = None,
      hlsSignaledSystemIds: Option[List[__stringMin36Max36Pattern09aFAF809aFAF409aFAF409aFAF409aFAF12]] = None,
      resourceId: Option[String] = None,
      url: Option[String] = None
    ): SpekeKeyProviderCmaf =
      SpekeKeyProviderCmaf
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(dashSignaledSystemIds)(_.dashSignaledSystemIds(_))
        .ifSome(hlsSignaledSystemIds)(_.hlsSignaledSystemIds(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(url)(_.url(_))
        .build

    def staticKeyProvider(
      keyFormat: Option[String] = None,
      keyFormatVersions: Option[String] = None,
      staticKeyValue: Option[String] = None,
      url: Option[String] = None
    ): StaticKeyProvider =
      StaticKeyProvider
        .builder
        .ifSome(keyFormat)(_.keyFormat(_))
        .ifSome(keyFormatVersions)(_.keyFormatVersions(_))
        .ifSome(staticKeyValue)(_.staticKeyValue(_))
        .ifSome(url)(_.url(_))
        .build

    def tagResourceRequest(
      arn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def teletextDestinationSettings(
      pageNumber: Option[String] = None,
      pageTypes: Option[List[TeletextPageType]] = None
    ): TeletextDestinationSettings =
      TeletextDestinationSettings
        .builder
        .ifSome(pageNumber)(_.pageNumber(_))
        .ifSome(pageTypes)(_.pageTypes(_))
        .build

    def teletextSourceSettings(
      pageNumber: Option[String] = None
    ): TeletextSourceSettings =
      TeletextSourceSettings
        .builder
        .ifSome(pageNumber)(_.pageNumber(_))
        .build

    def timecodeBurnin(
      fontSize: Option[Int] = None,
      position: Option[String] = None,
      prefix: Option[String] = None
    ): TimecodeBurnin =
      TimecodeBurnin
        .builder
        .ifSome(fontSize)(_.fontSize(_))
        .ifSome(position)(_.position(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def timecodeConfig(
      anchor: Option[String] = None,
      source: Option[String] = None,
      start: Option[String] = None,
      timestampOffset: Option[String] = None
    ): TimecodeConfig =
      TimecodeConfig
        .builder
        .ifSome(anchor)(_.anchor(_))
        .ifSome(source)(_.source(_))
        .ifSome(start)(_.start(_))
        .ifSome(timestampOffset)(_.timestampOffset(_))
        .build

    def timedMetadataInsertion(
      id3Insertions: Option[List[Id3Insertion]] = None
    ): TimedMetadataInsertion =
      TimedMetadataInsertion
        .builder
        .ifSome(id3Insertions)(_.id3Insertions(_))
        .build

    def timing(
      finishTime: Option[__timestampUnix] = None,
      startTime: Option[__timestampUnix] = None,
      submitTime: Option[__timestampUnix] = None
    ): Timing =
      Timing
        .builder
        .ifSome(finishTime)(_.finishTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(submitTime)(_.submitTime(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def trackSourceSettings(
      trackNumber: Option[Int] = None
    ): TrackSourceSettings =
      TrackSourceSettings
        .builder
        .ifSome(trackNumber)(_.trackNumber(_))
        .build

    def ttmlDestinationSettings(
      stylePassthrough: Option[String] = None
    ): TtmlDestinationSettings =
      TtmlDestinationSettings
        .builder
        .ifSome(stylePassthrough)(_.stylePassthrough(_))
        .build

    def untagResourceRequest(
      arn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateJobTemplateRequest(
      accelerationSettings: Option[AccelerationSettings] = None,
      category: Option[String] = None,
      description: Option[String] = None,
      hopDestinations: Option[List[HopDestination]] = None,
      name: Option[String] = None,
      priority: Option[Int] = None,
      queue: Option[String] = None,
      settings: Option[JobTemplateSettings] = None,
      statusUpdateInterval: Option[String] = None
    ): UpdateJobTemplateRequest =
      UpdateJobTemplateRequest
        .builder
        .ifSome(accelerationSettings)(_.accelerationSettings(_))
        .ifSome(category)(_.category(_))
        .ifSome(description)(_.description(_))
        .ifSome(hopDestinations)(_.hopDestinations(_))
        .ifSome(name)(_.name(_))
        .ifSome(priority)(_.priority(_))
        .ifSome(queue)(_.queue(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(statusUpdateInterval)(_.statusUpdateInterval(_))
        .build

    def updateJobTemplateResponse(
      jobTemplate: Option[JobTemplate] = None
    ): UpdateJobTemplateResponse =
      UpdateJobTemplateResponse
        .builder
        .ifSome(jobTemplate)(_.jobTemplate(_))
        .build

    def updatePresetRequest(
      category: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      settings: Option[PresetSettings] = None
    ): UpdatePresetRequest =
      UpdatePresetRequest
        .builder
        .ifSome(category)(_.category(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(settings)(_.settings(_))
        .build

    def updatePresetResponse(
      preset: Option[Preset] = None
    ): UpdatePresetResponse =
      UpdatePresetResponse
        .builder
        .ifSome(preset)(_.preset(_))
        .build

    def updateQueueRequest(
      description: Option[String] = None,
      name: Option[String] = None,
      reservationPlanSettings: Option[ReservationPlanSettings] = None,
      status: Option[String] = None
    ): UpdateQueueRequest =
      UpdateQueueRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(reservationPlanSettings)(_.reservationPlanSettings(_))
        .ifSome(status)(_.status(_))
        .build

    def updateQueueResponse(
      queue: Option[Queue] = None
    ): UpdateQueueResponse =
      UpdateQueueResponse
        .builder
        .ifSome(queue)(_.queue(_))
        .build

    def vc3Settings(
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      interlaceMode: Option[String] = None,
      scanTypeConversionMode: Option[String] = None,
      slowPal: Option[String] = None,
      telecine: Option[String] = None,
      vc3Class: Option[String] = None
    ): Vc3Settings =
      Vc3Settings
        .builder
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(interlaceMode)(_.interlaceMode(_))
        .ifSome(scanTypeConversionMode)(_.scanTypeConversionMode(_))
        .ifSome(slowPal)(_.slowPal(_))
        .ifSome(telecine)(_.telecine(_))
        .ifSome(vc3Class)(_.vc3Class(_))
        .build

    def videoCodecSettings(
      av1Settings: Option[Av1Settings] = None,
      avcIntraSettings: Option[AvcIntraSettings] = None,
      codec: Option[String] = None,
      frameCaptureSettings: Option[FrameCaptureSettings] = None,
      h264Settings: Option[H264Settings] = None,
      h265Settings: Option[H265Settings] = None,
      mpeg2Settings: Option[Mpeg2Settings] = None,
      proresSettings: Option[ProresSettings] = None,
      vc3Settings: Option[Vc3Settings] = None,
      vp8Settings: Option[Vp8Settings] = None,
      vp9Settings: Option[Vp9Settings] = None
    ): VideoCodecSettings =
      VideoCodecSettings
        .builder
        .ifSome(av1Settings)(_.av1Settings(_))
        .ifSome(avcIntraSettings)(_.avcIntraSettings(_))
        .ifSome(codec)(_.codec(_))
        .ifSome(frameCaptureSettings)(_.frameCaptureSettings(_))
        .ifSome(h264Settings)(_.h264Settings(_))
        .ifSome(h265Settings)(_.h265Settings(_))
        .ifSome(mpeg2Settings)(_.mpeg2Settings(_))
        .ifSome(proresSettings)(_.proresSettings(_))
        .ifSome(vc3Settings)(_.vc3Settings(_))
        .ifSome(vp8Settings)(_.vp8Settings(_))
        .ifSome(vp9Settings)(_.vp9Settings(_))
        .build

    def videoDescription(
      afdSignaling: Option[String] = None,
      antiAlias: Option[String] = None,
      codecSettings: Option[VideoCodecSettings] = None,
      colorMetadata: Option[String] = None,
      crop: Option[Rectangle] = None,
      dropFrameTimecode: Option[String] = None,
      fixedAfd: Option[Int] = None,
      height: Option[Int] = None,
      position: Option[Rectangle] = None,
      respondToAfd: Option[String] = None,
      scalingBehavior: Option[String] = None,
      sharpness: Option[Int] = None,
      timecodeInsertion: Option[String] = None,
      videoPreprocessors: Option[VideoPreprocessor] = None,
      width: Option[Int] = None
    ): VideoDescription =
      VideoDescription
        .builder
        .ifSome(afdSignaling)(_.afdSignaling(_))
        .ifSome(antiAlias)(_.antiAlias(_))
        .ifSome(codecSettings)(_.codecSettings(_))
        .ifSome(colorMetadata)(_.colorMetadata(_))
        .ifSome(crop)(_.crop(_))
        .ifSome(dropFrameTimecode)(_.dropFrameTimecode(_))
        .ifSome(fixedAfd)(_.fixedAfd(_))
        .ifSome(height)(_.height(_))
        .ifSome(position)(_.position(_))
        .ifSome(respondToAfd)(_.respondToAfd(_))
        .ifSome(scalingBehavior)(_.scalingBehavior(_))
        .ifSome(sharpness)(_.sharpness(_))
        .ifSome(timecodeInsertion)(_.timecodeInsertion(_))
        .ifSome(videoPreprocessors)(_.videoPreprocessors(_))
        .ifSome(width)(_.width(_))
        .build

    def videoDetail(
      heightInPx: Option[Int] = None,
      widthInPx: Option[Int] = None
    ): VideoDetail =
      VideoDetail
        .builder
        .ifSome(heightInPx)(_.heightInPx(_))
        .ifSome(widthInPx)(_.widthInPx(_))
        .build

    def videoPreprocessor(
      colorCorrector: Option[ColorCorrector] = None,
      deinterlacer: Option[Deinterlacer] = None,
      dolbyVision: Option[DolbyVision] = None,
      imageInserter: Option[ImageInserter] = None,
      noiseReducer: Option[NoiseReducer] = None,
      partnerWatermarking: Option[PartnerWatermarking] = None,
      timecodeBurnin: Option[TimecodeBurnin] = None
    ): VideoPreprocessor =
      VideoPreprocessor
        .builder
        .ifSome(colorCorrector)(_.colorCorrector(_))
        .ifSome(deinterlacer)(_.deinterlacer(_))
        .ifSome(dolbyVision)(_.dolbyVision(_))
        .ifSome(imageInserter)(_.imageInserter(_))
        .ifSome(noiseReducer)(_.noiseReducer(_))
        .ifSome(partnerWatermarking)(_.partnerWatermarking(_))
        .ifSome(timecodeBurnin)(_.timecodeBurnin(_))
        .build

    def videoSelector(
      alphaBehavior: Option[String] = None,
      colorSpace: Option[String] = None,
      colorSpaceUsage: Option[String] = None,
      hdr10Metadata: Option[Hdr10Metadata] = None,
      pid: Option[Int] = None,
      programNumber: Option[Int] = None,
      rotate: Option[String] = None,
      sampleRange: Option[String] = None
    ): VideoSelector =
      VideoSelector
        .builder
        .ifSome(alphaBehavior)(_.alphaBehavior(_))
        .ifSome(colorSpace)(_.colorSpace(_))
        .ifSome(colorSpaceUsage)(_.colorSpaceUsage(_))
        .ifSome(hdr10Metadata)(_.hdr10Metadata(_))
        .ifSome(pid)(_.pid(_))
        .ifSome(programNumber)(_.programNumber(_))
        .ifSome(rotate)(_.rotate(_))
        .ifSome(sampleRange)(_.sampleRange(_))
        .build

    def vorbisSettings(
      channels: Option[Int] = None,
      sampleRate: Option[Int] = None,
      vbrQuality: Option[Int] = None
    ): VorbisSettings =
      VorbisSettings
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(vbrQuality)(_.vbrQuality(_))
        .build

    def vp8Settings(
      bitrate: Option[Int] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopSize: Option[__doubleMin0] = None,
      hrdBufferSize: Option[Int] = None,
      maxBitrate: Option[Int] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      qualityTuningLevel: Option[String] = None,
      rateControlMode: Option[String] = None
    ): Vp8Settings =
      Vp8Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(hrdBufferSize)(_.hrdBufferSize(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(qualityTuningLevel)(_.qualityTuningLevel(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .build

    def vp9Settings(
      bitrate: Option[Int] = None,
      framerateControl: Option[String] = None,
      framerateConversionAlgorithm: Option[String] = None,
      framerateDenominator: Option[Int] = None,
      framerateNumerator: Option[Int] = None,
      gopSize: Option[__doubleMin0] = None,
      hrdBufferSize: Option[Int] = None,
      maxBitrate: Option[Int] = None,
      parControl: Option[String] = None,
      parDenominator: Option[Int] = None,
      parNumerator: Option[Int] = None,
      qualityTuningLevel: Option[String] = None,
      rateControlMode: Option[String] = None
    ): Vp9Settings =
      Vp9Settings
        .builder
        .ifSome(bitrate)(_.bitrate(_))
        .ifSome(framerateControl)(_.framerateControl(_))
        .ifSome(framerateConversionAlgorithm)(_.framerateConversionAlgorithm(_))
        .ifSome(framerateDenominator)(_.framerateDenominator(_))
        .ifSome(framerateNumerator)(_.framerateNumerator(_))
        .ifSome(gopSize)(_.gopSize(_))
        .ifSome(hrdBufferSize)(_.hrdBufferSize(_))
        .ifSome(maxBitrate)(_.maxBitrate(_))
        .ifSome(parControl)(_.parControl(_))
        .ifSome(parDenominator)(_.parDenominator(_))
        .ifSome(parNumerator)(_.parNumerator(_))
        .ifSome(qualityTuningLevel)(_.qualityTuningLevel(_))
        .ifSome(rateControlMode)(_.rateControlMode(_))
        .build

    def wavSettings(
      bitDepth: Option[Int] = None,
      channels: Option[Int] = None,
      format: Option[String] = None,
      sampleRate: Option[Int] = None
    ): WavSettings =
      WavSettings
        .builder
        .ifSome(bitDepth)(_.bitDepth(_))
        .ifSome(channels)(_.channels(_))
        .ifSome(format)(_.format(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .build

    def webvttDestinationSettings(
      stylePassthrough: Option[String] = None
    ): WebvttDestinationSettings =
      WebvttDestinationSettings
        .builder
        .ifSome(stylePassthrough)(_.stylePassthrough(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
