package goober.hi

import goober.free.mediatailor.MediaTailorIO
import software.amazon.awssdk.services.mediatailor.model._


object mediatailor {
  import goober.free.{mediatailor ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessConfiguration(
      accessType: Option[String] = None
    ): AccessConfiguration =
      AccessConfiguration
        .builder
        .ifSome(accessType)(_.accessType(_))
        .build

    def adBreak(
      messageType: Option[String] = None,
      offsetMillis: Option[__long] = None,
      slate: Option[SlateSource] = None,
      spliceInsertMessage: Option[SpliceInsertMessage] = None
    ): AdBreak =
      AdBreak
        .builder
        .ifSome(messageType)(_.messageType(_))
        .ifSome(offsetMillis)(_.offsetMillis(_))
        .ifSome(slate)(_.slate(_))
        .ifSome(spliceInsertMessage)(_.spliceInsertMessage(_))
        .build

    def adMarkerPassthrough(
      enabled: Option[Boolean] = None
    ): AdMarkerPassthrough =
      AdMarkerPassthrough
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def availSuppression(
      mode: Option[String] = None,
      value: Option[String] = None
    ): AvailSuppression =
      AvailSuppression
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(value)(_.value(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def bumper(
      endUrl: Option[String] = None,
      startUrl: Option[String] = None
    ): Bumper =
      Bumper
        .builder
        .ifSome(endUrl)(_.endUrl(_))
        .ifSome(startUrl)(_.startUrl(_))
        .build

    def cdnConfiguration(
      adSegmentUrlPrefix: Option[String] = None,
      contentSegmentUrlPrefix: Option[String] = None
    ): CdnConfiguration =
      CdnConfiguration
        .builder
        .ifSome(adSegmentUrlPrefix)(_.adSegmentUrlPrefix(_))
        .ifSome(contentSegmentUrlPrefix)(_.contentSegmentUrlPrefix(_))
        .build

    def channel(
      arn: Option[String] = None,
      channelName: Option[String] = None,
      channelState: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      outputs: Option[List[ResponseOutputItem]] = None,
      playbackMode: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): Channel =
      Channel
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelState)(_.channelState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChannelRequest(
      channelName: Option[String] = None,
      outputs: Option[List[RequestOutputItem]] = None,
      playbackMode: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateChannelRequest =
      CreateChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChannelResponse(
      arn: Option[String] = None,
      channelName: Option[String] = None,
      channelState: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      outputs: Option[List[ResponseOutputItem]] = None,
      playbackMode: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateChannelResponse =
      CreateChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelState)(_.channelState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProgramRequest(
      adBreaks: Option[List[AdBreak]] = None,
      channelName: Option[String] = None,
      programName: Option[String] = None,
      scheduleConfiguration: Option[ScheduleConfiguration] = None,
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): CreateProgramRequest =
      CreateProgramRequest
        .builder
        .ifSome(adBreaks)(_.adBreaks(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(programName)(_.programName(_))
        .ifSome(scheduleConfiguration)(_.scheduleConfiguration(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def createProgramResponse(
      adBreaks: Option[List[AdBreak]] = None,
      arn: Option[String] = None,
      channelName: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      programName: Option[String] = None,
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): CreateProgramResponse =
      CreateProgramResponse
        .builder
        .ifSome(adBreaks)(_.adBreaks(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(programName)(_.programName(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def createSourceLocationRequest(
      accessConfiguration: Option[AccessConfiguration] = None,
      defaultSegmentDeliveryConfiguration: Option[DefaultSegmentDeliveryConfiguration] = None,
      httpConfiguration: Option[HttpConfiguration] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateSourceLocationRequest =
      CreateSourceLocationRequest
        .builder
        .ifSome(accessConfiguration)(_.accessConfiguration(_))
        .ifSome(defaultSegmentDeliveryConfiguration)(_.defaultSegmentDeliveryConfiguration(_))
        .ifSome(httpConfiguration)(_.httpConfiguration(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSourceLocationResponse(
      accessConfiguration: Option[AccessConfiguration] = None,
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      defaultSegmentDeliveryConfiguration: Option[DefaultSegmentDeliveryConfiguration] = None,
      httpConfiguration: Option[HttpConfiguration] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateSourceLocationResponse =
      CreateSourceLocationResponse
        .builder
        .ifSome(accessConfiguration)(_.accessConfiguration(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(defaultSegmentDeliveryConfiguration)(_.defaultSegmentDeliveryConfiguration(_))
        .ifSome(httpConfiguration)(_.httpConfiguration(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createVodSourceRequest(
      httpPackageConfigurations: Option[List[HttpPackageConfiguration]] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      vodSourceName: Option[String] = None
    ): CreateVodSourceRequest =
      CreateVodSourceRequest
        .builder
        .ifSome(httpPackageConfigurations)(_.httpPackageConfigurations(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def createVodSourceResponse(
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      httpPackageConfigurations: Option[List[HttpPackageConfiguration]] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      vodSourceName: Option[String] = None
    ): CreateVodSourceResponse =
      CreateVodSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(httpPackageConfigurations)(_.httpPackageConfigurations(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def dashConfiguration(
      manifestEndpointPrefix: Option[String] = None,
      mpdLocation: Option[String] = None,
      originManifestType: Option[String] = None
    ): DashConfiguration =
      DashConfiguration
        .builder
        .ifSome(manifestEndpointPrefix)(_.manifestEndpointPrefix(_))
        .ifSome(mpdLocation)(_.mpdLocation(_))
        .ifSome(originManifestType)(_.originManifestType(_))
        .build

    def dashConfigurationForPut(
      mpdLocation: Option[String] = None,
      originManifestType: Option[String] = None
    ): DashConfigurationForPut =
      DashConfigurationForPut
        .builder
        .ifSome(mpdLocation)(_.mpdLocation(_))
        .ifSome(originManifestType)(_.originManifestType(_))
        .build

    def dashPlaylistSettings(
      manifestWindowSeconds: Option[Int] = None,
      minBufferTimeSeconds: Option[Int] = None,
      minUpdatePeriodSeconds: Option[Int] = None,
      suggestedPresentationDelaySeconds: Option[Int] = None
    ): DashPlaylistSettings =
      DashPlaylistSettings
        .builder
        .ifSome(manifestWindowSeconds)(_.manifestWindowSeconds(_))
        .ifSome(minBufferTimeSeconds)(_.minBufferTimeSeconds(_))
        .ifSome(minUpdatePeriodSeconds)(_.minUpdatePeriodSeconds(_))
        .ifSome(suggestedPresentationDelaySeconds)(_.suggestedPresentationDelaySeconds(_))
        .build

    def defaultSegmentDeliveryConfiguration(
      baseUrl: Option[String] = None
    ): DefaultSegmentDeliveryConfiguration =
      DefaultSegmentDeliveryConfiguration
        .builder
        .ifSome(baseUrl)(_.baseUrl(_))
        .build

    def deleteChannelPolicyRequest(
      channelName: Option[String] = None
    ): DeleteChannelPolicyRequest =
      DeleteChannelPolicyRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def deleteChannelPolicyResponse(

    ): DeleteChannelPolicyResponse =
      DeleteChannelPolicyResponse
        .builder

        .build

    def deleteChannelRequest(
      channelName: Option[String] = None
    ): DeleteChannelRequest =
      DeleteChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def deleteChannelResponse(

    ): DeleteChannelResponse =
      DeleteChannelResponse
        .builder

        .build

    def deletePlaybackConfigurationRequest(
      name: Option[String] = None
    ): DeletePlaybackConfigurationRequest =
      DeletePlaybackConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deletePlaybackConfigurationResponse(

    ): DeletePlaybackConfigurationResponse =
      DeletePlaybackConfigurationResponse
        .builder

        .build

    def deleteProgramRequest(
      channelName: Option[String] = None,
      programName: Option[String] = None
    ): DeleteProgramRequest =
      DeleteProgramRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(programName)(_.programName(_))
        .build

    def deleteProgramResponse(

    ): DeleteProgramResponse =
      DeleteProgramResponse
        .builder

        .build

    def deleteSourceLocationRequest(
      sourceLocationName: Option[String] = None
    ): DeleteSourceLocationRequest =
      DeleteSourceLocationRequest
        .builder
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .build

    def deleteSourceLocationResponse(

    ): DeleteSourceLocationResponse =
      DeleteSourceLocationResponse
        .builder

        .build

    def deleteVodSourceRequest(
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): DeleteVodSourceRequest =
      DeleteVodSourceRequest
        .builder
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def deleteVodSourceResponse(

    ): DeleteVodSourceResponse =
      DeleteVodSourceResponse
        .builder

        .build

    def describeChannelRequest(
      channelName: Option[String] = None
    ): DescribeChannelRequest =
      DescribeChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def describeChannelResponse(
      arn: Option[String] = None,
      channelName: Option[String] = None,
      channelState: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      outputs: Option[List[ResponseOutputItem]] = None,
      playbackMode: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): DescribeChannelResponse =
      DescribeChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelState)(_.channelState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeProgramRequest(
      channelName: Option[String] = None,
      programName: Option[String] = None
    ): DescribeProgramRequest =
      DescribeProgramRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(programName)(_.programName(_))
        .build

    def describeProgramResponse(
      adBreaks: Option[List[AdBreak]] = None,
      arn: Option[String] = None,
      channelName: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      programName: Option[String] = None,
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): DescribeProgramResponse =
      DescribeProgramResponse
        .builder
        .ifSome(adBreaks)(_.adBreaks(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(programName)(_.programName(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def describeSourceLocationRequest(
      sourceLocationName: Option[String] = None
    ): DescribeSourceLocationRequest =
      DescribeSourceLocationRequest
        .builder
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .build

    def describeSourceLocationResponse(
      accessConfiguration: Option[AccessConfiguration] = None,
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      defaultSegmentDeliveryConfiguration: Option[DefaultSegmentDeliveryConfiguration] = None,
      httpConfiguration: Option[HttpConfiguration] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): DescribeSourceLocationResponse =
      DescribeSourceLocationResponse
        .builder
        .ifSome(accessConfiguration)(_.accessConfiguration(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(defaultSegmentDeliveryConfiguration)(_.defaultSegmentDeliveryConfiguration(_))
        .ifSome(httpConfiguration)(_.httpConfiguration(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeVodSourceRequest(
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): DescribeVodSourceRequest =
      DescribeVodSourceRequest
        .builder
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def describeVodSourceResponse(
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      httpPackageConfigurations: Option[List[HttpPackageConfiguration]] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      vodSourceName: Option[String] = None
    ): DescribeVodSourceResponse =
      DescribeVodSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(httpPackageConfigurations)(_.httpPackageConfigurations(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def getChannelPolicyRequest(
      channelName: Option[String] = None
    ): GetChannelPolicyRequest =
      GetChannelPolicyRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def getChannelPolicyResponse(
      policy: Option[String] = None
    ): GetChannelPolicyResponse =
      GetChannelPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getChannelScheduleRequest(
      channelName: Option[String] = None,
      durationMinutes: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetChannelScheduleRequest =
      GetChannelScheduleRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(durationMinutes)(_.durationMinutes(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getChannelScheduleResponse(
      items: Option[List[ScheduleEntry]] = None,
      nextToken: Option[String] = None
    ): GetChannelScheduleResponse =
      GetChannelScheduleResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getPlaybackConfigurationRequest(
      name: Option[String] = None
    ): GetPlaybackConfigurationRequest =
      GetPlaybackConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getPlaybackConfigurationResponse(
      adDecisionServerUrl: Option[String] = None,
      availSuppression: Option[AvailSuppression] = None,
      bumper: Option[Bumper] = None,
      cdnConfiguration: Option[CdnConfiguration] = None,
      configurationAliases: Option[ConfigurationAliasesResponse] = None,
      dashConfiguration: Option[DashConfiguration] = None,
      hlsConfiguration: Option[HlsConfiguration] = None,
      livePreRollConfiguration: Option[LivePreRollConfiguration] = None,
      manifestProcessingRules: Option[ManifestProcessingRules] = None,
      name: Option[String] = None,
      personalizationThresholdSeconds: Option[Int] = None,
      playbackConfigurationArn: Option[String] = None,
      playbackEndpointPrefix: Option[String] = None,
      sessionInitializationEndpointPrefix: Option[String] = None,
      slateAdUrl: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      transcodeProfileName: Option[String] = None,
      videoContentSourceUrl: Option[String] = None
    ): GetPlaybackConfigurationResponse =
      GetPlaybackConfigurationResponse
        .builder
        .ifSome(adDecisionServerUrl)(_.adDecisionServerUrl(_))
        .ifSome(availSuppression)(_.availSuppression(_))
        .ifSome(bumper)(_.bumper(_))
        .ifSome(cdnConfiguration)(_.cdnConfiguration(_))
        .ifSome(configurationAliases)(_.configurationAliases(_))
        .ifSome(dashConfiguration)(_.dashConfiguration(_))
        .ifSome(hlsConfiguration)(_.hlsConfiguration(_))
        .ifSome(livePreRollConfiguration)(_.livePreRollConfiguration(_))
        .ifSome(manifestProcessingRules)(_.manifestProcessingRules(_))
        .ifSome(name)(_.name(_))
        .ifSome(personalizationThresholdSeconds)(_.personalizationThresholdSeconds(_))
        .ifSome(playbackConfigurationArn)(_.playbackConfigurationArn(_))
        .ifSome(playbackEndpointPrefix)(_.playbackEndpointPrefix(_))
        .ifSome(sessionInitializationEndpointPrefix)(_.sessionInitializationEndpointPrefix(_))
        .ifSome(slateAdUrl)(_.slateAdUrl(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(transcodeProfileName)(_.transcodeProfileName(_))
        .ifSome(videoContentSourceUrl)(_.videoContentSourceUrl(_))
        .build

    def hlsConfiguration(
      manifestEndpointPrefix: Option[String] = None
    ): HlsConfiguration =
      HlsConfiguration
        .builder
        .ifSome(manifestEndpointPrefix)(_.manifestEndpointPrefix(_))
        .build

    def hlsPlaylistSettings(
      manifestWindowSeconds: Option[Int] = None
    ): HlsPlaylistSettings =
      HlsPlaylistSettings
        .builder
        .ifSome(manifestWindowSeconds)(_.manifestWindowSeconds(_))
        .build

    def httpConfiguration(
      baseUrl: Option[String] = None
    ): HttpConfiguration =
      HttpConfiguration
        .builder
        .ifSome(baseUrl)(_.baseUrl(_))
        .build

    def httpPackageConfiguration(
      path: Option[String] = None,
      sourceGroup: Option[String] = None,
      `type`: Option[String] = None
    ): HttpPackageConfiguration =
      HttpPackageConfiguration
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(sourceGroup)(_.sourceGroup(_))
        .ifSome(`type`)(_.`type`(_))
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
      items: Option[List[Channel]] = None,
      nextToken: Option[String] = None
    ): ListChannelsResponse =
      ListChannelsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlaybackConfigurationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPlaybackConfigurationsRequest =
      ListPlaybackConfigurationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlaybackConfigurationsResponse(
      items: Option[List[PlaybackConfiguration]] = None,
      nextToken: Option[String] = None
    ): ListPlaybackConfigurationsResponse =
      ListPlaybackConfigurationsResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSourceLocationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSourceLocationsRequest =
      ListSourceLocationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSourceLocationsResponse(
      items: Option[List[SourceLocation]] = None,
      nextToken: Option[String] = None
    ): ListSourceLocationsResponse =
      ListSourceLocationsResponse
        .builder
        .ifSome(items)(_.items(_))
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
      tags: Option[__mapOf__string] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listVodSourcesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sourceLocationName: Option[String] = None
    ): ListVodSourcesRequest =
      ListVodSourcesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .build

    def listVodSourcesResponse(
      items: Option[List[VodSource]] = None,
      nextToken: Option[String] = None
    ): ListVodSourcesResponse =
      ListVodSourcesResponse
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def livePreRollConfiguration(
      adDecisionServerUrl: Option[String] = None,
      maxDurationSeconds: Option[Int] = None
    ): LivePreRollConfiguration =
      LivePreRollConfiguration
        .builder
        .ifSome(adDecisionServerUrl)(_.adDecisionServerUrl(_))
        .ifSome(maxDurationSeconds)(_.maxDurationSeconds(_))
        .build

    def manifestProcessingRules(
      adMarkerPassthrough: Option[AdMarkerPassthrough] = None
    ): ManifestProcessingRules =
      ManifestProcessingRules
        .builder
        .ifSome(adMarkerPassthrough)(_.adMarkerPassthrough(_))
        .build

    def playbackConfiguration(
      adDecisionServerUrl: Option[String] = None,
      availSuppression: Option[AvailSuppression] = None,
      bumper: Option[Bumper] = None,
      cdnConfiguration: Option[CdnConfiguration] = None,
      configurationAliases: Option[ConfigurationAliasesResponse] = None,
      dashConfiguration: Option[DashConfiguration] = None,
      hlsConfiguration: Option[HlsConfiguration] = None,
      livePreRollConfiguration: Option[LivePreRollConfiguration] = None,
      manifestProcessingRules: Option[ManifestProcessingRules] = None,
      name: Option[String] = None,
      personalizationThresholdSeconds: Option[Int] = None,
      playbackConfigurationArn: Option[String] = None,
      playbackEndpointPrefix: Option[String] = None,
      sessionInitializationEndpointPrefix: Option[String] = None,
      slateAdUrl: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      transcodeProfileName: Option[String] = None,
      videoContentSourceUrl: Option[String] = None
    ): PlaybackConfiguration =
      PlaybackConfiguration
        .builder
        .ifSome(adDecisionServerUrl)(_.adDecisionServerUrl(_))
        .ifSome(availSuppression)(_.availSuppression(_))
        .ifSome(bumper)(_.bumper(_))
        .ifSome(cdnConfiguration)(_.cdnConfiguration(_))
        .ifSome(configurationAliases)(_.configurationAliases(_))
        .ifSome(dashConfiguration)(_.dashConfiguration(_))
        .ifSome(hlsConfiguration)(_.hlsConfiguration(_))
        .ifSome(livePreRollConfiguration)(_.livePreRollConfiguration(_))
        .ifSome(manifestProcessingRules)(_.manifestProcessingRules(_))
        .ifSome(name)(_.name(_))
        .ifSome(personalizationThresholdSeconds)(_.personalizationThresholdSeconds(_))
        .ifSome(playbackConfigurationArn)(_.playbackConfigurationArn(_))
        .ifSome(playbackEndpointPrefix)(_.playbackEndpointPrefix(_))
        .ifSome(sessionInitializationEndpointPrefix)(_.sessionInitializationEndpointPrefix(_))
        .ifSome(slateAdUrl)(_.slateAdUrl(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(transcodeProfileName)(_.transcodeProfileName(_))
        .ifSome(videoContentSourceUrl)(_.videoContentSourceUrl(_))
        .build

    def putChannelPolicyRequest(
      channelName: Option[String] = None,
      policy: Option[String] = None
    ): PutChannelPolicyRequest =
      PutChannelPolicyRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putChannelPolicyResponse(

    ): PutChannelPolicyResponse =
      PutChannelPolicyResponse
        .builder

        .build

    def putPlaybackConfigurationRequest(
      adDecisionServerUrl: Option[String] = None,
      availSuppression: Option[AvailSuppression] = None,
      bumper: Option[Bumper] = None,
      cdnConfiguration: Option[CdnConfiguration] = None,
      configurationAliases: Option[ConfigurationAliasesRequest] = None,
      dashConfiguration: Option[DashConfigurationForPut] = None,
      livePreRollConfiguration: Option[LivePreRollConfiguration] = None,
      manifestProcessingRules: Option[ManifestProcessingRules] = None,
      name: Option[String] = None,
      personalizationThresholdSeconds: Option[Int] = None,
      slateAdUrl: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      transcodeProfileName: Option[String] = None,
      videoContentSourceUrl: Option[String] = None
    ): PutPlaybackConfigurationRequest =
      PutPlaybackConfigurationRequest
        .builder
        .ifSome(adDecisionServerUrl)(_.adDecisionServerUrl(_))
        .ifSome(availSuppression)(_.availSuppression(_))
        .ifSome(bumper)(_.bumper(_))
        .ifSome(cdnConfiguration)(_.cdnConfiguration(_))
        .ifSome(configurationAliases)(_.configurationAliases(_))
        .ifSome(dashConfiguration)(_.dashConfiguration(_))
        .ifSome(livePreRollConfiguration)(_.livePreRollConfiguration(_))
        .ifSome(manifestProcessingRules)(_.manifestProcessingRules(_))
        .ifSome(name)(_.name(_))
        .ifSome(personalizationThresholdSeconds)(_.personalizationThresholdSeconds(_))
        .ifSome(slateAdUrl)(_.slateAdUrl(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(transcodeProfileName)(_.transcodeProfileName(_))
        .ifSome(videoContentSourceUrl)(_.videoContentSourceUrl(_))
        .build

    def putPlaybackConfigurationResponse(
      adDecisionServerUrl: Option[String] = None,
      availSuppression: Option[AvailSuppression] = None,
      bumper: Option[Bumper] = None,
      cdnConfiguration: Option[CdnConfiguration] = None,
      configurationAliases: Option[ConfigurationAliasesResponse] = None,
      dashConfiguration: Option[DashConfiguration] = None,
      hlsConfiguration: Option[HlsConfiguration] = None,
      livePreRollConfiguration: Option[LivePreRollConfiguration] = None,
      manifestProcessingRules: Option[ManifestProcessingRules] = None,
      name: Option[String] = None,
      personalizationThresholdSeconds: Option[Int] = None,
      playbackConfigurationArn: Option[String] = None,
      playbackEndpointPrefix: Option[String] = None,
      sessionInitializationEndpointPrefix: Option[String] = None,
      slateAdUrl: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      transcodeProfileName: Option[String] = None,
      videoContentSourceUrl: Option[String] = None
    ): PutPlaybackConfigurationResponse =
      PutPlaybackConfigurationResponse
        .builder
        .ifSome(adDecisionServerUrl)(_.adDecisionServerUrl(_))
        .ifSome(availSuppression)(_.availSuppression(_))
        .ifSome(bumper)(_.bumper(_))
        .ifSome(cdnConfiguration)(_.cdnConfiguration(_))
        .ifSome(configurationAliases)(_.configurationAliases(_))
        .ifSome(dashConfiguration)(_.dashConfiguration(_))
        .ifSome(hlsConfiguration)(_.hlsConfiguration(_))
        .ifSome(livePreRollConfiguration)(_.livePreRollConfiguration(_))
        .ifSome(manifestProcessingRules)(_.manifestProcessingRules(_))
        .ifSome(name)(_.name(_))
        .ifSome(personalizationThresholdSeconds)(_.personalizationThresholdSeconds(_))
        .ifSome(playbackConfigurationArn)(_.playbackConfigurationArn(_))
        .ifSome(playbackEndpointPrefix)(_.playbackEndpointPrefix(_))
        .ifSome(sessionInitializationEndpointPrefix)(_.sessionInitializationEndpointPrefix(_))
        .ifSome(slateAdUrl)(_.slateAdUrl(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(transcodeProfileName)(_.transcodeProfileName(_))
        .ifSome(videoContentSourceUrl)(_.videoContentSourceUrl(_))
        .build

    def requestOutputItem(
      dashPlaylistSettings: Option[DashPlaylistSettings] = None,
      hlsPlaylistSettings: Option[HlsPlaylistSettings] = None,
      manifestName: Option[String] = None,
      sourceGroup: Option[String] = None
    ): RequestOutputItem =
      RequestOutputItem
        .builder
        .ifSome(dashPlaylistSettings)(_.dashPlaylistSettings(_))
        .ifSome(hlsPlaylistSettings)(_.hlsPlaylistSettings(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(sourceGroup)(_.sourceGroup(_))
        .build

    def responseOutputItem(
      dashPlaylistSettings: Option[DashPlaylistSettings] = None,
      hlsPlaylistSettings: Option[HlsPlaylistSettings] = None,
      manifestName: Option[String] = None,
      playbackUrl: Option[String] = None,
      sourceGroup: Option[String] = None
    ): ResponseOutputItem =
      ResponseOutputItem
        .builder
        .ifSome(dashPlaylistSettings)(_.dashPlaylistSettings(_))
        .ifSome(hlsPlaylistSettings)(_.hlsPlaylistSettings(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(playbackUrl)(_.playbackUrl(_))
        .ifSome(sourceGroup)(_.sourceGroup(_))
        .build

    def scheduleConfiguration(
      transition: Option[Transition] = None
    ): ScheduleConfiguration =
      ScheduleConfiguration
        .builder
        .ifSome(transition)(_.transition(_))
        .build

    def scheduleEntry(
      approximateDurationSeconds: Option[__long] = None,
      approximateStartTime: Option[__timestampUnix] = None,
      arn: Option[String] = None,
      channelName: Option[String] = None,
      programName: Option[String] = None,
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): ScheduleEntry =
      ScheduleEntry
        .builder
        .ifSome(approximateDurationSeconds)(_.approximateDurationSeconds(_))
        .ifSome(approximateStartTime)(_.approximateStartTime(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(programName)(_.programName(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def slateSource(
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): SlateSource =
      SlateSource
        .builder
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def sourceLocation(
      accessConfiguration: Option[AccessConfiguration] = None,
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      defaultSegmentDeliveryConfiguration: Option[DefaultSegmentDeliveryConfiguration] = None,
      httpConfiguration: Option[HttpConfiguration] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): SourceLocation =
      SourceLocation
        .builder
        .ifSome(accessConfiguration)(_.accessConfiguration(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(defaultSegmentDeliveryConfiguration)(_.defaultSegmentDeliveryConfiguration(_))
        .ifSome(httpConfiguration)(_.httpConfiguration(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def spliceInsertMessage(
      availNum: Option[Int] = None,
      availsExpected: Option[Int] = None,
      spliceEventId: Option[Int] = None,
      uniqueProgramId: Option[Int] = None
    ): SpliceInsertMessage =
      SpliceInsertMessage
        .builder
        .ifSome(availNum)(_.availNum(_))
        .ifSome(availsExpected)(_.availsExpected(_))
        .ifSome(spliceEventId)(_.spliceEventId(_))
        .ifSome(uniqueProgramId)(_.uniqueProgramId(_))
        .build

    def startChannelRequest(
      channelName: Option[String] = None
    ): StartChannelRequest =
      StartChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def startChannelResponse(

    ): StartChannelResponse =
      StartChannelResponse
        .builder

        .build

    def stopChannelRequest(
      channelName: Option[String] = None
    ): StopChannelRequest =
      StopChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .build

    def stopChannelResponse(

    ): StopChannelResponse =
      StopChannelResponse
        .builder

        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def transition(
      relativePosition: Option[String] = None,
      relativeProgram: Option[String] = None,
      `type`: Option[String] = None
    ): Transition =
      Transition
        .builder
        .ifSome(relativePosition)(_.relativePosition(_))
        .ifSome(relativeProgram)(_.relativeProgram(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateChannelRequest(
      channelName: Option[String] = None,
      outputs: Option[List[RequestOutputItem]] = None
    ): UpdateChannelRequest =
      UpdateChannelRequest
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(outputs)(_.outputs(_))
        .build

    def updateChannelResponse(
      arn: Option[String] = None,
      channelName: Option[String] = None,
      channelState: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      outputs: Option[List[ResponseOutputItem]] = None,
      playbackMode: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): UpdateChannelResponse =
      UpdateChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelState)(_.channelState(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(playbackMode)(_.playbackMode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateSourceLocationRequest(
      accessConfiguration: Option[AccessConfiguration] = None,
      defaultSegmentDeliveryConfiguration: Option[DefaultSegmentDeliveryConfiguration] = None,
      httpConfiguration: Option[HttpConfiguration] = None,
      sourceLocationName: Option[String] = None
    ): UpdateSourceLocationRequest =
      UpdateSourceLocationRequest
        .builder
        .ifSome(accessConfiguration)(_.accessConfiguration(_))
        .ifSome(defaultSegmentDeliveryConfiguration)(_.defaultSegmentDeliveryConfiguration(_))
        .ifSome(httpConfiguration)(_.httpConfiguration(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .build

    def updateSourceLocationResponse(
      accessConfiguration: Option[AccessConfiguration] = None,
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      defaultSegmentDeliveryConfiguration: Option[DefaultSegmentDeliveryConfiguration] = None,
      httpConfiguration: Option[HttpConfiguration] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): UpdateSourceLocationResponse =
      UpdateSourceLocationResponse
        .builder
        .ifSome(accessConfiguration)(_.accessConfiguration(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(defaultSegmentDeliveryConfiguration)(_.defaultSegmentDeliveryConfiguration(_))
        .ifSome(httpConfiguration)(_.httpConfiguration(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateVodSourceRequest(
      httpPackageConfigurations: Option[List[HttpPackageConfiguration]] = None,
      sourceLocationName: Option[String] = None,
      vodSourceName: Option[String] = None
    ): UpdateVodSourceRequest =
      UpdateVodSourceRequest
        .builder
        .ifSome(httpPackageConfigurations)(_.httpPackageConfigurations(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def updateVodSourceResponse(
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      httpPackageConfigurations: Option[List[HttpPackageConfiguration]] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      vodSourceName: Option[String] = None
    ): UpdateVodSourceResponse =
      UpdateVodSourceResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(httpPackageConfigurations)(_.httpPackageConfigurations(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

    def vodSource(
      arn: Option[String] = None,
      creationTime: Option[__timestampUnix] = None,
      httpPackageConfigurations: Option[List[HttpPackageConfiguration]] = None,
      lastModifiedTime: Option[__timestampUnix] = None,
      sourceLocationName: Option[String] = None,
      tags: Option[__mapOf__string] = None,
      vodSourceName: Option[String] = None
    ): VodSource =
      VodSource
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(httpPackageConfigurations)(_.httpPackageConfigurations(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(sourceLocationName)(_.sourceLocationName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vodSourceName)(_.vodSourceName(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
