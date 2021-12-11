package goober.hi

import goober.free.elastictranscoder.ElasticTranscoderIO
import software.amazon.awssdk.services.elastictranscoder.model._


object elastictranscoder {
  import goober.free.{elastictranscoder ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(

    ): AccessDeniedException =
      AccessDeniedException
        .builder

        .build

    def artwork(
      inputKey: Option[String] = None,
      maxWidth: Option[String] = None,
      maxHeight: Option[String] = None,
      sizingPolicy: Option[String] = None,
      paddingPolicy: Option[String] = None,
      albumArtFormat: Option[String] = None,
      encryption: Option[Encryption] = None
    ): Artwork =
      Artwork
        .builder
        .ifSome(inputKey)(_.inputKey(_))
        .ifSome(maxWidth)(_.maxWidth(_))
        .ifSome(maxHeight)(_.maxHeight(_))
        .ifSome(sizingPolicy)(_.sizingPolicy(_))
        .ifSome(paddingPolicy)(_.paddingPolicy(_))
        .ifSome(albumArtFormat)(_.albumArtFormat(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def audioCodecOptions(
      profile: Option[String] = None,
      bitDepth: Option[String] = None,
      bitOrder: Option[String] = None,
      signed: Option[String] = None
    ): AudioCodecOptions =
      AudioCodecOptions
        .builder
        .ifSome(profile)(_.profile(_))
        .ifSome(bitDepth)(_.bitDepth(_))
        .ifSome(bitOrder)(_.bitOrder(_))
        .ifSome(signed)(_.signed(_))
        .build

    def audioParameters(
      codec: Option[String] = None,
      sampleRate: Option[String] = None,
      bitRate: Option[String] = None,
      channels: Option[String] = None,
      audioPackingMode: Option[String] = None,
      codecOptions: Option[AudioCodecOptions] = None
    ): AudioParameters =
      AudioParameters
        .builder
        .ifSome(codec)(_.codec(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(bitRate)(_.bitRate(_))
        .ifSome(channels)(_.channels(_))
        .ifSome(audioPackingMode)(_.audioPackingMode(_))
        .ifSome(codecOptions)(_.codecOptions(_))
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

    def captionFormat(
      format: Option[String] = None,
      pattern: Option[String] = None,
      encryption: Option[Encryption] = None
    ): CaptionFormat =
      CaptionFormat
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def captionSource(
      key: Option[String] = None,
      language: Option[String] = None,
      timeOffset: Option[String] = None,
      label: Option[String] = None,
      encryption: Option[Encryption] = None
    ): CaptionSource =
      CaptionSource
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(language)(_.language(_))
        .ifSome(timeOffset)(_.timeOffset(_))
        .ifSome(label)(_.label(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def captions(
      mergePolicy: Option[String] = None,
      captionSources: Option[List[CaptionSource]] = None,
      captionFormats: Option[List[CaptionFormat]] = None
    ): Captions =
      Captions
        .builder
        .ifSome(mergePolicy)(_.mergePolicy(_))
        .ifSome(captionSources)(_.captionSources(_))
        .ifSome(captionFormats)(_.captionFormats(_))
        .build

    def clip(
      timeSpan: Option[TimeSpan] = None
    ): Clip =
      Clip
        .builder
        .ifSome(timeSpan)(_.timeSpan(_))
        .build

    def createJobOutput(
      key: Option[String] = None,
      thumbnailPattern: Option[String] = None,
      thumbnailEncryption: Option[Encryption] = None,
      rotate: Option[String] = None,
      presetId: Option[String] = None,
      segmentDuration: Option[String] = None,
      watermarks: Option[List[JobWatermark]] = None,
      albumArt: Option[JobAlbumArt] = None,
      composition: Option[List[Clip]] = None,
      captions: Option[Captions] = None,
      encryption: Option[Encryption] = None
    ): CreateJobOutput =
      CreateJobOutput
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(thumbnailPattern)(_.thumbnailPattern(_))
        .ifSome(thumbnailEncryption)(_.thumbnailEncryption(_))
        .ifSome(rotate)(_.rotate(_))
        .ifSome(presetId)(_.presetId(_))
        .ifSome(segmentDuration)(_.segmentDuration(_))
        .ifSome(watermarks)(_.watermarks(_))
        .ifSome(albumArt)(_.albumArt(_))
        .ifSome(composition)(_.composition(_))
        .ifSome(captions)(_.captions(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def createJobPlaylist(
      name: Option[String] = None,
      format: Option[String] = None,
      outputKeys: Option[List[Key]] = None,
      hlsContentProtection: Option[HlsContentProtection] = None,
      playReadyDrm: Option[PlayReadyDrm] = None
    ): CreateJobPlaylist =
      CreateJobPlaylist
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(outputKeys)(_.outputKeys(_))
        .ifSome(hlsContentProtection)(_.hlsContentProtection(_))
        .ifSome(playReadyDrm)(_.playReadyDrm(_))
        .build

    def createJobRequest(
      pipelineId: Option[String] = None,
      input: Option[JobInput] = None,
      inputs: Option[List[JobInput]] = None,
      output: Option[CreateJobOutput] = None,
      outputs: Option[List[CreateJobOutput]] = None,
      outputKeyPrefix: Option[String] = None,
      playlists: Option[List[CreateJobPlaylist]] = None,
      userMetadata: Option[UserMetadata] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(outputKeyPrefix)(_.outputKeyPrefix(_))
        .ifSome(playlists)(_.playlists(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .build

    def createJobResponse(
      job: Option[Job] = None
    ): CreateJobResponse =
      CreateJobResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def createPipelineRequest(
      name: Option[String] = None,
      inputBucket: Option[String] = None,
      outputBucket: Option[String] = None,
      role: Option[String] = None,
      awsKmsKeyArn: Option[String] = None,
      notifications: Option[Notifications] = None,
      contentConfig: Option[PipelineOutputConfig] = None,
      thumbnailConfig: Option[PipelineOutputConfig] = None
    ): CreatePipelineRequest =
      CreatePipelineRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(inputBucket)(_.inputBucket(_))
        .ifSome(outputBucket)(_.outputBucket(_))
        .ifSome(role)(_.role(_))
        .ifSome(awsKmsKeyArn)(_.awsKmsKeyArn(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(contentConfig)(_.contentConfig(_))
        .ifSome(thumbnailConfig)(_.thumbnailConfig(_))
        .build

    def createPipelineResponse(
      pipeline: Option[Pipeline] = None,
      warnings: Option[List[Warning]] = None
    ): CreatePipelineResponse =
      CreatePipelineResponse
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def createPresetRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      container: Option[String] = None,
      video: Option[VideoParameters] = None,
      audio: Option[AudioParameters] = None,
      thumbnails: Option[Thumbnails] = None
    ): CreatePresetRequest =
      CreatePresetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(container)(_.container(_))
        .ifSome(video)(_.video(_))
        .ifSome(audio)(_.audio(_))
        .ifSome(thumbnails)(_.thumbnails(_))
        .build

    def createPresetResponse(
      preset: Option[Preset] = None,
      warning: Option[String] = None
    ): CreatePresetResponse =
      CreatePresetResponse
        .builder
        .ifSome(preset)(_.preset(_))
        .ifSome(warning)(_.warning(_))
        .build

    def deletePipelineRequest(
      id: Option[String] = None
    ): DeletePipelineRequest =
      DeletePipelineRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deletePipelineResponse(

    ): DeletePipelineResponse =
      DeletePipelineResponse
        .builder

        .build

    def deletePresetRequest(
      id: Option[String] = None
    ): DeletePresetRequest =
      DeletePresetRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deletePresetResponse(

    ): DeletePresetResponse =
      DeletePresetResponse
        .builder

        .build

    def detectedProperties(
      width: Option[Int] = None,
      height: Option[Int] = None,
      frameRate: Option[String] = None,
      fileSize: Option[NullableLong] = None,
      durationMillis: Option[NullableLong] = None
    ): DetectedProperties =
      DetectedProperties
        .builder
        .ifSome(width)(_.width(_))
        .ifSome(height)(_.height(_))
        .ifSome(frameRate)(_.frameRate(_))
        .ifSome(fileSize)(_.fileSize(_))
        .ifSome(durationMillis)(_.durationMillis(_))
        .build

    def encryption(
      mode: Option[String] = None,
      key: Option[String] = None,
      keyMd5: Option[String] = None,
      initializationVector: Option[String] = None
    ): Encryption =
      Encryption
        .builder
        .ifSome(mode)(_.mode(_))
        .ifSome(key)(_.key(_))
        .ifSome(keyMd5)(_.keyMd5(_))
        .ifSome(initializationVector)(_.initializationVector(_))
        .build

    def hlsContentProtection(
      method: Option[String] = None,
      key: Option[String] = None,
      keyMd5: Option[String] = None,
      initializationVector: Option[String] = None,
      licenseAcquisitionUrl: Option[String] = None,
      keyStoragePolicy: Option[String] = None
    ): HlsContentProtection =
      HlsContentProtection
        .builder
        .ifSome(method)(_.method(_))
        .ifSome(key)(_.key(_))
        .ifSome(keyMd5)(_.keyMd5(_))
        .ifSome(initializationVector)(_.initializationVector(_))
        .ifSome(licenseAcquisitionUrl)(_.licenseAcquisitionUrl(_))
        .ifSome(keyStoragePolicy)(_.keyStoragePolicy(_))
        .build

    def incompatibleVersionException(

    ): IncompatibleVersionException =
      IncompatibleVersionException
        .builder

        .build

    def inputCaptions(
      mergePolicy: Option[String] = None,
      captionSources: Option[List[CaptionSource]] = None
    ): InputCaptions =
      InputCaptions
        .builder
        .ifSome(mergePolicy)(_.mergePolicy(_))
        .ifSome(captionSources)(_.captionSources(_))
        .build

    def internalServiceException(

    ): InternalServiceException =
      InternalServiceException
        .builder

        .build

    def job(
      id: Option[String] = None,
      arn: Option[String] = None,
      pipelineId: Option[String] = None,
      input: Option[JobInput] = None,
      inputs: Option[List[JobInput]] = None,
      output: Option[JobOutput] = None,
      outputs: Option[List[JobOutput]] = None,
      outputKeyPrefix: Option[String] = None,
      playlists: Option[List[Playlist]] = None,
      status: Option[String] = None,
      userMetadata: Option[UserMetadata] = None,
      timing: Option[Timing] = None
    ): Job =
      Job
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(input)(_.input(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(output)(_.output(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(outputKeyPrefix)(_.outputKeyPrefix(_))
        .ifSome(playlists)(_.playlists(_))
        .ifSome(status)(_.status(_))
        .ifSome(userMetadata)(_.userMetadata(_))
        .ifSome(timing)(_.timing(_))
        .build

    def jobAlbumArt(
      mergePolicy: Option[String] = None,
      artwork: Option[List[Artwork]] = None
    ): JobAlbumArt =
      JobAlbumArt
        .builder
        .ifSome(mergePolicy)(_.mergePolicy(_))
        .ifSome(artwork)(_.artwork(_))
        .build

    def jobInput(
      key: Option[String] = None,
      frameRate: Option[String] = None,
      resolution: Option[String] = None,
      aspectRatio: Option[String] = None,
      interlaced: Option[String] = None,
      container: Option[String] = None,
      encryption: Option[Encryption] = None,
      timeSpan: Option[TimeSpan] = None,
      inputCaptions: Option[InputCaptions] = None,
      detectedProperties: Option[DetectedProperties] = None
    ): JobInput =
      JobInput
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(frameRate)(_.frameRate(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(aspectRatio)(_.aspectRatio(_))
        .ifSome(interlaced)(_.interlaced(_))
        .ifSome(container)(_.container(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(timeSpan)(_.timeSpan(_))
        .ifSome(inputCaptions)(_.inputCaptions(_))
        .ifSome(detectedProperties)(_.detectedProperties(_))
        .build

    def jobOutput(
      id: Option[String] = None,
      key: Option[String] = None,
      thumbnailPattern: Option[String] = None,
      thumbnailEncryption: Option[Encryption] = None,
      rotate: Option[String] = None,
      presetId: Option[String] = None,
      segmentDuration: Option[String] = None,
      status: Option[String] = None,
      statusDetail: Option[String] = None,
      duration: Option[NullableLong] = None,
      width: Option[Int] = None,
      height: Option[Int] = None,
      frameRate: Option[String] = None,
      fileSize: Option[NullableLong] = None,
      durationMillis: Option[NullableLong] = None,
      watermarks: Option[List[JobWatermark]] = None,
      albumArt: Option[JobAlbumArt] = None,
      composition: Option[List[Clip]] = None,
      captions: Option[Captions] = None,
      encryption: Option[Encryption] = None,
      appliedColorSpaceConversion: Option[String] = None
    ): JobOutput =
      JobOutput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(key)(_.key(_))
        .ifSome(thumbnailPattern)(_.thumbnailPattern(_))
        .ifSome(thumbnailEncryption)(_.thumbnailEncryption(_))
        .ifSome(rotate)(_.rotate(_))
        .ifSome(presetId)(_.presetId(_))
        .ifSome(segmentDuration)(_.segmentDuration(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetail)(_.statusDetail(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(width)(_.width(_))
        .ifSome(height)(_.height(_))
        .ifSome(frameRate)(_.frameRate(_))
        .ifSome(fileSize)(_.fileSize(_))
        .ifSome(durationMillis)(_.durationMillis(_))
        .ifSome(watermarks)(_.watermarks(_))
        .ifSome(albumArt)(_.albumArt(_))
        .ifSome(composition)(_.composition(_))
        .ifSome(captions)(_.captions(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(appliedColorSpaceConversion)(_.appliedColorSpaceConversion(_))
        .build

    def jobWatermark(
      presetWatermarkId: Option[String] = None,
      inputKey: Option[String] = None,
      encryption: Option[Encryption] = None
    ): JobWatermark =
      JobWatermark
        .builder
        .ifSome(presetWatermarkId)(_.presetWatermarkId(_))
        .ifSome(inputKey)(_.inputKey(_))
        .ifSome(encryption)(_.encryption(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listJobsByPipelineRequest(
      pipelineId: Option[String] = None,
      ascending: Option[String] = None,
      pageToken: Option[String] = None
    ): ListJobsByPipelineRequest =
      ListJobsByPipelineRequest
        .builder
        .ifSome(pipelineId)(_.pipelineId(_))
        .ifSome(ascending)(_.ascending(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listJobsByPipelineResponse(
      jobs: Option[List[Job]] = None,
      nextPageToken: Option[String] = None
    ): ListJobsByPipelineResponse =
      ListJobsByPipelineResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listJobsByStatusRequest(
      status: Option[String] = None,
      ascending: Option[String] = None,
      pageToken: Option[String] = None
    ): ListJobsByStatusRequest =
      ListJobsByStatusRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(ascending)(_.ascending(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listJobsByStatusResponse(
      jobs: Option[List[Job]] = None,
      nextPageToken: Option[String] = None
    ): ListJobsByStatusResponse =
      ListJobsByStatusResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listPipelinesRequest(
      ascending: Option[String] = None,
      pageToken: Option[String] = None
    ): ListPipelinesRequest =
      ListPipelinesRequest
        .builder
        .ifSome(ascending)(_.ascending(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listPipelinesResponse(
      pipelines: Option[List[Pipeline]] = None,
      nextPageToken: Option[String] = None
    ): ListPipelinesResponse =
      ListPipelinesResponse
        .builder
        .ifSome(pipelines)(_.pipelines(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def listPresetsRequest(
      ascending: Option[String] = None,
      pageToken: Option[String] = None
    ): ListPresetsRequest =
      ListPresetsRequest
        .builder
        .ifSome(ascending)(_.ascending(_))
        .ifSome(pageToken)(_.pageToken(_))
        .build

    def listPresetsResponse(
      presets: Option[List[Preset]] = None,
      nextPageToken: Option[String] = None
    ): ListPresetsResponse =
      ListPresetsResponse
        .builder
        .ifSome(presets)(_.presets(_))
        .ifSome(nextPageToken)(_.nextPageToken(_))
        .build

    def notifications(
      progressing: Option[String] = None,
      completed: Option[String] = None,
      warning: Option[String] = None,
      error: Option[String] = None
    ): Notifications =
      Notifications
        .builder
        .ifSome(progressing)(_.progressing(_))
        .ifSome(completed)(_.completed(_))
        .ifSome(warning)(_.warning(_))
        .ifSome(error)(_.error(_))
        .build

    def permission(
      granteeType: Option[String] = None,
      grantee: Option[String] = None,
      access: Option[List[AccessControl]] = None
    ): Permission =
      Permission
        .builder
        .ifSome(granteeType)(_.granteeType(_))
        .ifSome(grantee)(_.grantee(_))
        .ifSome(access)(_.access(_))
        .build

    def pipeline(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      inputBucket: Option[String] = None,
      outputBucket: Option[String] = None,
      role: Option[String] = None,
      awsKmsKeyArn: Option[String] = None,
      notifications: Option[Notifications] = None,
      contentConfig: Option[PipelineOutputConfig] = None,
      thumbnailConfig: Option[PipelineOutputConfig] = None
    ): Pipeline =
      Pipeline
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(inputBucket)(_.inputBucket(_))
        .ifSome(outputBucket)(_.outputBucket(_))
        .ifSome(role)(_.role(_))
        .ifSome(awsKmsKeyArn)(_.awsKmsKeyArn(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(contentConfig)(_.contentConfig(_))
        .ifSome(thumbnailConfig)(_.thumbnailConfig(_))
        .build

    def pipelineOutputConfig(
      bucket: Option[String] = None,
      storageClass: Option[String] = None,
      permissions: Option[List[Permission]] = None
    ): PipelineOutputConfig =
      PipelineOutputConfig
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(permissions)(_.permissions(_))
        .build

    def playReadyDrm(
      format: Option[String] = None,
      key: Option[String] = None,
      keyMd5: Option[String] = None,
      keyId: Option[String] = None,
      initializationVector: Option[String] = None,
      licenseAcquisitionUrl: Option[String] = None
    ): PlayReadyDrm =
      PlayReadyDrm
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(key)(_.key(_))
        .ifSome(keyMd5)(_.keyMd5(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(initializationVector)(_.initializationVector(_))
        .ifSome(licenseAcquisitionUrl)(_.licenseAcquisitionUrl(_))
        .build

    def playlist(
      name: Option[String] = None,
      format: Option[String] = None,
      outputKeys: Option[List[Key]] = None,
      hlsContentProtection: Option[HlsContentProtection] = None,
      playReadyDrm: Option[PlayReadyDrm] = None,
      status: Option[String] = None,
      statusDetail: Option[String] = None
    ): Playlist =
      Playlist
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(format)(_.format(_))
        .ifSome(outputKeys)(_.outputKeys(_))
        .ifSome(hlsContentProtection)(_.hlsContentProtection(_))
        .ifSome(playReadyDrm)(_.playReadyDrm(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetail)(_.statusDetail(_))
        .build

    def preset(
      id: Option[String] = None,
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      container: Option[String] = None,
      audio: Option[AudioParameters] = None,
      video: Option[VideoParameters] = None,
      thumbnails: Option[Thumbnails] = None,
      `type`: Option[String] = None
    ): Preset =
      Preset
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(container)(_.container(_))
        .ifSome(audio)(_.audio(_))
        .ifSome(video)(_.video(_))
        .ifSome(thumbnails)(_.thumbnails(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def presetWatermark(
      id: Option[String] = None,
      maxWidth: Option[String] = None,
      maxHeight: Option[String] = None,
      sizingPolicy: Option[String] = None,
      horizontalAlign: Option[String] = None,
      horizontalOffset: Option[String] = None,
      verticalAlign: Option[String] = None,
      verticalOffset: Option[String] = None,
      opacity: Option[String] = None,
      target: Option[String] = None
    ): PresetWatermark =
      PresetWatermark
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(maxWidth)(_.maxWidth(_))
        .ifSome(maxHeight)(_.maxHeight(_))
        .ifSome(sizingPolicy)(_.sizingPolicy(_))
        .ifSome(horizontalAlign)(_.horizontalAlign(_))
        .ifSome(horizontalOffset)(_.horizontalOffset(_))
        .ifSome(verticalAlign)(_.verticalAlign(_))
        .ifSome(verticalOffset)(_.verticalOffset(_))
        .ifSome(opacity)(_.opacity(_))
        .ifSome(target)(_.target(_))
        .build

    def readJobRequest(
      id: Option[String] = None
    ): ReadJobRequest =
      ReadJobRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def readJobResponse(
      job: Option[Job] = None
    ): ReadJobResponse =
      ReadJobResponse
        .builder
        .ifSome(job)(_.job(_))
        .build

    def readPipelineRequest(
      id: Option[String] = None
    ): ReadPipelineRequest =
      ReadPipelineRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def readPipelineResponse(
      pipeline: Option[Pipeline] = None,
      warnings: Option[List[Warning]] = None
    ): ReadPipelineResponse =
      ReadPipelineResponse
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def readPresetRequest(
      id: Option[String] = None
    ): ReadPresetRequest =
      ReadPresetRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def readPresetResponse(
      preset: Option[Preset] = None
    ): ReadPresetResponse =
      ReadPresetResponse
        .builder
        .ifSome(preset)(_.preset(_))
        .build

    def resourceInUseException(

    ): ResourceInUseException =
      ResourceInUseException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def testRoleRequest(
      role: Option[String] = None,
      inputBucket: Option[String] = None,
      outputBucket: Option[String] = None,
      topics: Option[List[SnsTopic]] = None
    ): TestRoleRequest =
      TestRoleRequest
        .builder
        .ifSome(role)(_.role(_))
        .ifSome(inputBucket)(_.inputBucket(_))
        .ifSome(outputBucket)(_.outputBucket(_))
        .ifSome(topics)(_.topics(_))
        .build

    def testRoleResponse(
      success: Option[String] = None,
      messages: Option[List[String]] = None
    ): TestRoleResponse =
      TestRoleResponse
        .builder
        .ifSome(success)(_.success(_))
        .ifSome(messages)(_.messages(_))
        .build

    def thumbnails(
      format: Option[String] = None,
      interval: Option[String] = None,
      resolution: Option[String] = None,
      aspectRatio: Option[String] = None,
      maxWidth: Option[String] = None,
      maxHeight: Option[String] = None,
      sizingPolicy: Option[String] = None,
      paddingPolicy: Option[String] = None
    ): Thumbnails =
      Thumbnails
        .builder
        .ifSome(format)(_.format(_))
        .ifSome(interval)(_.interval(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(aspectRatio)(_.aspectRatio(_))
        .ifSome(maxWidth)(_.maxWidth(_))
        .ifSome(maxHeight)(_.maxHeight(_))
        .ifSome(sizingPolicy)(_.sizingPolicy(_))
        .ifSome(paddingPolicy)(_.paddingPolicy(_))
        .build

    def timeSpan(
      startTime: Option[String] = None,
      duration: Option[String] = None
    ): TimeSpan =
      TimeSpan
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(duration)(_.duration(_))
        .build

    def timing(
      submitTimeMillis: Option[NullableLong] = None,
      startTimeMillis: Option[NullableLong] = None,
      finishTimeMillis: Option[NullableLong] = None
    ): Timing =
      Timing
        .builder
        .ifSome(submitTimeMillis)(_.submitTimeMillis(_))
        .ifSome(startTimeMillis)(_.startTimeMillis(_))
        .ifSome(finishTimeMillis)(_.finishTimeMillis(_))
        .build

    def updatePipelineNotificationsRequest(
      id: Option[String] = None,
      notifications: Option[Notifications] = None
    ): UpdatePipelineNotificationsRequest =
      UpdatePipelineNotificationsRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(notifications)(_.notifications(_))
        .build

    def updatePipelineNotificationsResponse(
      pipeline: Option[Pipeline] = None
    ): UpdatePipelineNotificationsResponse =
      UpdatePipelineNotificationsResponse
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def updatePipelineRequest(
      id: Option[String] = None,
      name: Option[String] = None,
      inputBucket: Option[String] = None,
      role: Option[String] = None,
      awsKmsKeyArn: Option[String] = None,
      notifications: Option[Notifications] = None,
      contentConfig: Option[PipelineOutputConfig] = None,
      thumbnailConfig: Option[PipelineOutputConfig] = None
    ): UpdatePipelineRequest =
      UpdatePipelineRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(inputBucket)(_.inputBucket(_))
        .ifSome(role)(_.role(_))
        .ifSome(awsKmsKeyArn)(_.awsKmsKeyArn(_))
        .ifSome(notifications)(_.notifications(_))
        .ifSome(contentConfig)(_.contentConfig(_))
        .ifSome(thumbnailConfig)(_.thumbnailConfig(_))
        .build

    def updatePipelineResponse(
      pipeline: Option[Pipeline] = None,
      warnings: Option[List[Warning]] = None
    ): UpdatePipelineResponse =
      UpdatePipelineResponse
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def updatePipelineStatusRequest(
      id: Option[String] = None,
      status: Option[String] = None
    ): UpdatePipelineStatusRequest =
      UpdatePipelineStatusRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(status)(_.status(_))
        .build

    def updatePipelineStatusResponse(
      pipeline: Option[Pipeline] = None
    ): UpdatePipelineStatusResponse =
      UpdatePipelineStatusResponse
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def validationException(

    ): ValidationException =
      ValidationException
        .builder

        .build

    def videoParameters(
      codec: Option[String] = None,
      codecOptions: Option[CodecOptions] = None,
      keyframesMaxDist: Option[String] = None,
      fixedGOP: Option[String] = None,
      bitRate: Option[String] = None,
      frameRate: Option[String] = None,
      maxFrameRate: Option[String] = None,
      resolution: Option[String] = None,
      aspectRatio: Option[String] = None,
      maxWidth: Option[String] = None,
      maxHeight: Option[String] = None,
      displayAspectRatio: Option[String] = None,
      sizingPolicy: Option[String] = None,
      paddingPolicy: Option[String] = None,
      watermarks: Option[List[PresetWatermark]] = None
    ): VideoParameters =
      VideoParameters
        .builder
        .ifSome(codec)(_.codec(_))
        .ifSome(codecOptions)(_.codecOptions(_))
        .ifSome(keyframesMaxDist)(_.keyframesMaxDist(_))
        .ifSome(fixedGOP)(_.fixedGOP(_))
        .ifSome(bitRate)(_.bitRate(_))
        .ifSome(frameRate)(_.frameRate(_))
        .ifSome(maxFrameRate)(_.maxFrameRate(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(aspectRatio)(_.aspectRatio(_))
        .ifSome(maxWidth)(_.maxWidth(_))
        .ifSome(maxHeight)(_.maxHeight(_))
        .ifSome(displayAspectRatio)(_.displayAspectRatio(_))
        .ifSome(sizingPolicy)(_.sizingPolicy(_))
        .ifSome(paddingPolicy)(_.paddingPolicy(_))
        .ifSome(watermarks)(_.watermarks(_))
        .build

    def warning(
      code: Option[String] = None,
      message: Option[String] = None
    ): Warning =
      Warning
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
