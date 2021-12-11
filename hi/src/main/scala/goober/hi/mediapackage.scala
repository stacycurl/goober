package goober.hi

import goober.free.mediapackage.MediaPackageIO
import software.amazon.awssdk.services.mediapackage.model._


object mediapackage {
  import goober.free.{mediapackage ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def authorization(
      cdnIdentifierSecret: Option[String] = None,
      secretsRoleArn: Option[String] = None
    ): Authorization =
      Authorization
        .builder
        .ifSome(cdnIdentifierSecret)(_.cdnIdentifierSecret(_))
        .ifSome(secretsRoleArn)(_.secretsRoleArn(_))
        .build

    def channel(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): Channel =
      Channel
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def channelCreateParameters(
      description: Option[String] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): ChannelCreateParameters =
      ChannelCreateParameters
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def channelList(
      channels: Option[List[Channel]] = None,
      nextToken: Option[String] = None
    ): ChannelList =
      ChannelList
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def channelUpdateParameters(
      description: Option[String] = None
    ): ChannelUpdateParameters =
      ChannelUpdateParameters
        .builder
        .ifSome(description)(_.description(_))
        .build

    def cmafEncryption(
      constantInitializationVector: Option[String] = None,
      keyRotationIntervalSeconds: Option[Int] = None,
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): CmafEncryption =
      CmafEncryption
        .builder
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(keyRotationIntervalSeconds)(_.keyRotationIntervalSeconds(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def cmafPackage(
      encryption: Option[CmafEncryption] = None,
      hlsManifests: Option[List[HlsManifest]] = None,
      segmentDurationSeconds: Option[Int] = None,
      segmentPrefix: Option[String] = None,
      streamSelection: Option[StreamSelection] = None
    ): CmafPackage =
      CmafPackage
        .builder
        .ifSome(encryption)(_.encryption(_))
        .ifSome(hlsManifests)(_.hlsManifests(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(segmentPrefix)(_.segmentPrefix(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .build

    def cmafPackageCreateOrUpdateParameters(
      encryption: Option[CmafEncryption] = None,
      hlsManifests: Option[List[HlsManifestCreateOrUpdateParameters]] = None,
      segmentDurationSeconds: Option[Int] = None,
      segmentPrefix: Option[String] = None,
      streamSelection: Option[StreamSelection] = None
    ): CmafPackageCreateOrUpdateParameters =
      CmafPackageCreateOrUpdateParameters
        .builder
        .ifSome(encryption)(_.encryption(_))
        .ifSome(hlsManifests)(_.hlsManifests(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(segmentPrefix)(_.segmentPrefix(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .build

    def configureLogsParameters(
      egressAccessLogs: Option[EgressAccessLogs] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None
    ): ConfigureLogsParameters =
      ConfigureLogsParameters
        .builder
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .build

    def configureLogsRequest(
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None
    ): ConfigureLogsRequest =
      ConfigureLogsRequest
        .builder
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .build

    def configureLogsResponse(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): ConfigureLogsResponse =
      ConfigureLogsResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChannelRequest(
      description: Option[String] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateChannelRequest =
      CreateChannelRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createChannelResponse(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): CreateChannelResponse =
      CreateChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createHarvestJobRequest(
      endTime: Option[String] = None,
      id: Option[String] = None,
      originEndpointId: Option[String] = None,
      s3Destination: Option[S3Destination] = None,
      startTime: Option[String] = None
    ): CreateHarvestJobRequest =
      CreateHarvestJobRequest
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(id)(_.id(_))
        .ifSome(originEndpointId)(_.originEndpointId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def createHarvestJobResponse(
      arn: Option[String] = None,
      channelId: Option[String] = None,
      createdAt: Option[String] = None,
      endTime: Option[String] = None,
      id: Option[String] = None,
      originEndpointId: Option[String] = None,
      s3Destination: Option[S3Destination] = None,
      startTime: Option[String] = None,
      status: Option[String] = None
    ): CreateHarvestJobResponse =
      CreateHarvestJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(id)(_.id(_))
        .ifSome(originEndpointId)(_.originEndpointId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(status)(_.status(_))
        .build

    def createOriginEndpointRequest(
      authorization: Option[Authorization] = None,
      channelId: Option[String] = None,
      cmafPackage: Option[CmafPackageCreateOrUpdateParameters] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      tags: Option[Tags] = None,
      timeDelaySeconds: Option[Int] = None,
      whitelist: Option[List[__string]] = None
    ): CreateOriginEndpointRequest =
      CreateOriginEndpointRequest
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def createOriginEndpointResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      channelId: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      tags: Option[Tags] = None,
      timeDelaySeconds: Option[Int] = None,
      url: Option[String] = None,
      whitelist: Option[List[__string]] = None
    ): CreateOriginEndpointResponse =
      CreateOriginEndpointResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(url)(_.url(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def dashEncryption(
      keyRotationIntervalSeconds: Option[Int] = None,
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): DashEncryption =
      DashEncryption
        .builder
        .ifSome(keyRotationIntervalSeconds)(_.keyRotationIntervalSeconds(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def dashPackage(
      adTriggers: Option[List[__AdTriggersElement]] = None,
      adsOnDeliveryRestrictions: Option[String] = None,
      encryption: Option[DashEncryption] = None,
      manifestLayout: Option[String] = None,
      manifestWindowSeconds: Option[Int] = None,
      minBufferTimeSeconds: Option[Int] = None,
      minUpdatePeriodSeconds: Option[Int] = None,
      periodTriggers: Option[List[__PeriodTriggersElement]] = None,
      profile: Option[String] = None,
      segmentDurationSeconds: Option[Int] = None,
      segmentTemplateFormat: Option[String] = None,
      streamSelection: Option[StreamSelection] = None,
      suggestedPresentationDelaySeconds: Option[Int] = None,
      utcTiming: Option[String] = None,
      utcTimingUri: Option[String] = None
    ): DashPackage =
      DashPackage
        .builder
        .ifSome(adTriggers)(_.adTriggers(_))
        .ifSome(adsOnDeliveryRestrictions)(_.adsOnDeliveryRestrictions(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(manifestLayout)(_.manifestLayout(_))
        .ifSome(manifestWindowSeconds)(_.manifestWindowSeconds(_))
        .ifSome(minBufferTimeSeconds)(_.minBufferTimeSeconds(_))
        .ifSome(minUpdatePeriodSeconds)(_.minUpdatePeriodSeconds(_))
        .ifSome(periodTriggers)(_.periodTriggers(_))
        .ifSome(profile)(_.profile(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(segmentTemplateFormat)(_.segmentTemplateFormat(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .ifSome(suggestedPresentationDelaySeconds)(_.suggestedPresentationDelaySeconds(_))
        .ifSome(utcTiming)(_.utcTiming(_))
        .ifSome(utcTimingUri)(_.utcTimingUri(_))
        .build

    def deleteChannelRequest(
      id: Option[String] = None
    ): DeleteChannelRequest =
      DeleteChannelRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteChannelResponse(

    ): DeleteChannelResponse =
      DeleteChannelResponse
        .builder

        .build

    def deleteOriginEndpointRequest(
      id: Option[String] = None
    ): DeleteOriginEndpointRequest =
      DeleteOriginEndpointRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteOriginEndpointResponse(

    ): DeleteOriginEndpointResponse =
      DeleteOriginEndpointResponse
        .builder

        .build

    def describeChannelRequest(
      id: Option[String] = None
    ): DescribeChannelRequest =
      DescribeChannelRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeChannelResponse(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): DescribeChannelResponse =
      DescribeChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeHarvestJobRequest(
      id: Option[String] = None
    ): DescribeHarvestJobRequest =
      DescribeHarvestJobRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeHarvestJobResponse(
      arn: Option[String] = None,
      channelId: Option[String] = None,
      createdAt: Option[String] = None,
      endTime: Option[String] = None,
      id: Option[String] = None,
      originEndpointId: Option[String] = None,
      s3Destination: Option[S3Destination] = None,
      startTime: Option[String] = None,
      status: Option[String] = None
    ): DescribeHarvestJobResponse =
      DescribeHarvestJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(id)(_.id(_))
        .ifSome(originEndpointId)(_.originEndpointId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(status)(_.status(_))
        .build

    def describeOriginEndpointRequest(
      id: Option[String] = None
    ): DescribeOriginEndpointRequest =
      DescribeOriginEndpointRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeOriginEndpointResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      channelId: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      tags: Option[Tags] = None,
      timeDelaySeconds: Option[Int] = None,
      url: Option[String] = None,
      whitelist: Option[List[__string]] = None
    ): DescribeOriginEndpointResponse =
      DescribeOriginEndpointResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(url)(_.url(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def egressAccessLogs(
      logGroupName: Option[String] = None
    ): EgressAccessLogs =
      EgressAccessLogs
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def encryptionContractConfiguration(
      presetSpeke20Audio: Option[String] = None,
      presetSpeke20Video: Option[String] = None
    ): EncryptionContractConfiguration =
      EncryptionContractConfiguration
        .builder
        .ifSome(presetSpeke20Audio)(_.presetSpeke20Audio(_))
        .ifSome(presetSpeke20Video)(_.presetSpeke20Video(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def harvestJob(
      arn: Option[String] = None,
      channelId: Option[String] = None,
      createdAt: Option[String] = None,
      endTime: Option[String] = None,
      id: Option[String] = None,
      originEndpointId: Option[String] = None,
      s3Destination: Option[S3Destination] = None,
      startTime: Option[String] = None,
      status: Option[String] = None
    ): HarvestJob =
      HarvestJob
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(id)(_.id(_))
        .ifSome(originEndpointId)(_.originEndpointId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(status)(_.status(_))
        .build

    def harvestJobCreateParameters(
      endTime: Option[String] = None,
      id: Option[String] = None,
      originEndpointId: Option[String] = None,
      s3Destination: Option[S3Destination] = None,
      startTime: Option[String] = None
    ): HarvestJobCreateParameters =
      HarvestJobCreateParameters
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(id)(_.id(_))
        .ifSome(originEndpointId)(_.originEndpointId(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .ifSome(startTime)(_.startTime(_))
        .build

    def harvestJobList(
      harvestJobs: Option[List[HarvestJob]] = None,
      nextToken: Option[String] = None
    ): HarvestJobList =
      HarvestJobList
        .builder
        .ifSome(harvestJobs)(_.harvestJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def hlsEncryption(
      constantInitializationVector: Option[String] = None,
      encryptionMethod: Option[String] = None,
      keyRotationIntervalSeconds: Option[Int] = None,
      repeatExtXKey: Option[Boolean] = None,
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): HlsEncryption =
      HlsEncryption
        .builder
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(encryptionMethod)(_.encryptionMethod(_))
        .ifSome(keyRotationIntervalSeconds)(_.keyRotationIntervalSeconds(_))
        .ifSome(repeatExtXKey)(_.repeatExtXKey(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def hlsIngest(
      ingestEndpoints: Option[List[IngestEndpoint]] = None
    ): HlsIngest =
      HlsIngest
        .builder
        .ifSome(ingestEndpoints)(_.ingestEndpoints(_))
        .build

    def hlsManifest(
      adMarkers: Option[String] = None,
      id: Option[String] = None,
      includeIframeOnlyStream: Option[Boolean] = None,
      manifestName: Option[String] = None,
      playlistType: Option[String] = None,
      playlistWindowSeconds: Option[Int] = None,
      programDateTimeIntervalSeconds: Option[Int] = None,
      url: Option[String] = None
    ): HlsManifest =
      HlsManifest
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(id)(_.id(_))
        .ifSome(includeIframeOnlyStream)(_.includeIframeOnlyStream(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(playlistType)(_.playlistType(_))
        .ifSome(playlistWindowSeconds)(_.playlistWindowSeconds(_))
        .ifSome(programDateTimeIntervalSeconds)(_.programDateTimeIntervalSeconds(_))
        .ifSome(url)(_.url(_))
        .build

    def hlsManifestCreateOrUpdateParameters(
      adMarkers: Option[String] = None,
      adTriggers: Option[List[__AdTriggersElement]] = None,
      adsOnDeliveryRestrictions: Option[String] = None,
      id: Option[String] = None,
      includeIframeOnlyStream: Option[Boolean] = None,
      manifestName: Option[String] = None,
      playlistType: Option[String] = None,
      playlistWindowSeconds: Option[Int] = None,
      programDateTimeIntervalSeconds: Option[Int] = None
    ): HlsManifestCreateOrUpdateParameters =
      HlsManifestCreateOrUpdateParameters
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(adTriggers)(_.adTriggers(_))
        .ifSome(adsOnDeliveryRestrictions)(_.adsOnDeliveryRestrictions(_))
        .ifSome(id)(_.id(_))
        .ifSome(includeIframeOnlyStream)(_.includeIframeOnlyStream(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(playlistType)(_.playlistType(_))
        .ifSome(playlistWindowSeconds)(_.playlistWindowSeconds(_))
        .ifSome(programDateTimeIntervalSeconds)(_.programDateTimeIntervalSeconds(_))
        .build

    def hlsPackage(
      adMarkers: Option[String] = None,
      adTriggers: Option[List[__AdTriggersElement]] = None,
      adsOnDeliveryRestrictions: Option[String] = None,
      encryption: Option[HlsEncryption] = None,
      includeIframeOnlyStream: Option[Boolean] = None,
      playlistType: Option[String] = None,
      playlistWindowSeconds: Option[Int] = None,
      programDateTimeIntervalSeconds: Option[Int] = None,
      segmentDurationSeconds: Option[Int] = None,
      streamSelection: Option[StreamSelection] = None,
      useAudioRenditionGroup: Option[Boolean] = None
    ): HlsPackage =
      HlsPackage
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(adTriggers)(_.adTriggers(_))
        .ifSome(adsOnDeliveryRestrictions)(_.adsOnDeliveryRestrictions(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(includeIframeOnlyStream)(_.includeIframeOnlyStream(_))
        .ifSome(playlistType)(_.playlistType(_))
        .ifSome(playlistWindowSeconds)(_.playlistWindowSeconds(_))
        .ifSome(programDateTimeIntervalSeconds)(_.programDateTimeIntervalSeconds(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .ifSome(useAudioRenditionGroup)(_.useAudioRenditionGroup(_))
        .build

    def ingestEndpoint(
      id: Option[String] = None,
      password: Option[String] = None,
      url: Option[String] = None,
      username: Option[String] = None
    ): IngestEndpoint =
      IngestEndpoint
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(password)(_.password(_))
        .ifSome(url)(_.url(_))
        .ifSome(username)(_.username(_))
        .build

    def ingressAccessLogs(
      logGroupName: Option[String] = None
    ): IngressAccessLogs =
      IngressAccessLogs
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
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
      channels: Option[List[Channel]] = None,
      nextToken: Option[String] = None
    ): ListChannelsResponse =
      ListChannelsResponse
        .builder
        .ifSome(channels)(_.channels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHarvestJobsRequest(
      includeChannelId: Option[String] = None,
      includeStatus: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListHarvestJobsRequest =
      ListHarvestJobsRequest
        .builder
        .ifSome(includeChannelId)(_.includeChannelId(_))
        .ifSome(includeStatus)(_.includeStatus(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listHarvestJobsResponse(
      harvestJobs: Option[List[HarvestJob]] = None,
      nextToken: Option[String] = None
    ): ListHarvestJobsResponse =
      ListHarvestJobsResponse
        .builder
        .ifSome(harvestJobs)(_.harvestJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOriginEndpointsRequest(
      channelId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListOriginEndpointsRequest =
      ListOriginEndpointsRequest
        .builder
        .ifSome(channelId)(_.channelId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOriginEndpointsResponse(
      nextToken: Option[String] = None,
      originEndpoints: Option[List[OriginEndpoint]] = None
    ): ListOriginEndpointsResponse =
      ListOriginEndpointsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(originEndpoints)(_.originEndpoints(_))
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

    def mssEncryption(
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): MssEncryption =
      MssEncryption
        .builder
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def mssPackage(
      encryption: Option[MssEncryption] = None,
      manifestWindowSeconds: Option[Int] = None,
      segmentDurationSeconds: Option[Int] = None,
      streamSelection: Option[StreamSelection] = None
    ): MssPackage =
      MssPackage
        .builder
        .ifSome(encryption)(_.encryption(_))
        .ifSome(manifestWindowSeconds)(_.manifestWindowSeconds(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def originEndpoint(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      channelId: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      tags: Option[Tags] = None,
      timeDelaySeconds: Option[Int] = None,
      url: Option[String] = None,
      whitelist: Option[List[__string]] = None
    ): OriginEndpoint =
      OriginEndpoint
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(url)(_.url(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def originEndpointCreateParameters(
      authorization: Option[Authorization] = None,
      channelId: Option[String] = None,
      cmafPackage: Option[CmafPackageCreateOrUpdateParameters] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      tags: Option[Tags] = None,
      timeDelaySeconds: Option[Int] = None,
      whitelist: Option[List[__string]] = None
    ): OriginEndpointCreateParameters =
      OriginEndpointCreateParameters
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def originEndpointList(
      nextToken: Option[String] = None,
      originEndpoints: Option[List[OriginEndpoint]] = None
    ): OriginEndpointList =
      OriginEndpointList
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(originEndpoints)(_.originEndpoints(_))
        .build

    def originEndpointUpdateParameters(
      authorization: Option[Authorization] = None,
      cmafPackage: Option[CmafPackageCreateOrUpdateParameters] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      timeDelaySeconds: Option[Int] = None,
      whitelist: Option[List[__string]] = None
    ): OriginEndpointUpdateParameters =
      OriginEndpointUpdateParameters
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def rotateChannelCredentialsRequest(
      id: Option[String] = None
    ): RotateChannelCredentialsRequest =
      RotateChannelCredentialsRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def rotateChannelCredentialsResponse(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): RotateChannelCredentialsResponse =
      RotateChannelCredentialsResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def rotateIngestEndpointCredentialsRequest(
      id: Option[String] = None,
      ingestEndpointId: Option[String] = None
    ): RotateIngestEndpointCredentialsRequest =
      RotateIngestEndpointCredentialsRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(ingestEndpointId)(_.ingestEndpointId(_))
        .build

    def rotateIngestEndpointCredentialsResponse(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): RotateIngestEndpointCredentialsResponse =
      RotateIngestEndpointCredentialsResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def s3Destination(
      bucketName: Option[String] = None,
      manifestKey: Option[String] = None,
      roleArn: Option[String] = None
    ): S3Destination =
      S3Destination
        .builder
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(manifestKey)(_.manifestKey(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def spekeKeyProvider(
      certificateArn: Option[String] = None,
      encryptionContractConfiguration: Option[EncryptionContractConfiguration] = None,
      resourceId: Option[String] = None,
      roleArn: Option[String] = None,
      systemIds: Option[List[__string]] = None,
      url: Option[String] = None
    ): SpekeKeyProvider =
      SpekeKeyProvider
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(encryptionContractConfiguration)(_.encryptionContractConfiguration(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(systemIds)(_.systemIds(_))
        .ifSome(url)(_.url(_))
        .build

    def streamSelection(
      maxVideoBitsPerSecond: Option[Int] = None,
      minVideoBitsPerSecond: Option[Int] = None,
      streamOrder: Option[String] = None
    ): StreamSelection =
      StreamSelection
        .builder
        .ifSome(maxVideoBitsPerSecond)(_.maxVideoBitsPerSecond(_))
        .ifSome(minVideoBitsPerSecond)(_.minVideoBitsPerSecond(_))
        .ifSome(streamOrder)(_.streamOrder(_))
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

    def tagsModel(
      tags: Option[__mapOf__string] = None
    ): TagsModel =
      TagsModel
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unprocessableEntityException(
      message: Option[String] = None
    ): UnprocessableEntityException =
      UnprocessableEntityException
        .builder
        .ifSome(message)(_.message(_))
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
      description: Option[String] = None,
      id: Option[String] = None
    ): UpdateChannelRequest =
      UpdateChannelRequest
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(id)(_.id(_))
        .build

    def updateChannelResponse(
      arn: Option[String] = None,
      description: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      hlsIngest: Option[HlsIngest] = None,
      id: Option[String] = None,
      ingressAccessLogs: Option[IngressAccessLogs] = None,
      tags: Option[Tags] = None
    ): UpdateChannelResponse =
      UpdateChannelResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(hlsIngest)(_.hlsIngest(_))
        .ifSome(id)(_.id(_))
        .ifSome(ingressAccessLogs)(_.ingressAccessLogs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateOriginEndpointRequest(
      authorization: Option[Authorization] = None,
      cmafPackage: Option[CmafPackageCreateOrUpdateParameters] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      timeDelaySeconds: Option[Int] = None,
      whitelist: Option[List[__string]] = None
    ): UpdateOriginEndpointRequest =
      UpdateOriginEndpointRequest
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

    def updateOriginEndpointResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      channelId: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      description: Option[String] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      manifestName: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      origination: Option[String] = None,
      startoverWindowSeconds: Option[Int] = None,
      tags: Option[Tags] = None,
      timeDelaySeconds: Option[Int] = None,
      url: Option[String] = None,
      whitelist: Option[List[__string]] = None
    ): UpdateOriginEndpointResponse =
      UpdateOriginEndpointResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(channelId)(_.channelId(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(description)(_.description(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(origination)(_.origination(_))
        .ifSome(startoverWindowSeconds)(_.startoverWindowSeconds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(timeDelaySeconds)(_.timeDelaySeconds(_))
        .ifSome(url)(_.url(_))
        .ifSome(whitelist)(_.whitelist(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
