package goober.hi

import goober.free.kinesisvideo.KinesisVideoIO
import software.amazon.awssdk.services.kinesisvideo.model._


object kinesisvideo {
  import goober.free.{kinesisvideo ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountChannelLimitExceededException(
      message: Option[String] = None
    ): AccountChannelLimitExceededException =
      AccountChannelLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountStreamLimitExceededException(
      message: Option[String] = None
    ): AccountStreamLimitExceededException =
      AccountStreamLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def channelInfo(
      channelName: Option[String] = None,
      channelARN: Option[String] = None,
      channelType: Option[String] = None,
      channelStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      singleMasterConfiguration: Option[SingleMasterConfiguration] = None,
      version: Option[String] = None
    ): ChannelInfo =
      ChannelInfo
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelARN)(_.channelARN(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(channelStatus)(_.channelStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(singleMasterConfiguration)(_.singleMasterConfiguration(_))
        .ifSome(version)(_.version(_))
        .build

    def channelNameCondition(
      comparisonOperator: Option[String] = None,
      comparisonValue: Option[String] = None
    ): ChannelNameCondition =
      ChannelNameCondition
        .builder
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(comparisonValue)(_.comparisonValue(_))
        .build

    def clientLimitExceededException(
      message: Option[String] = None
    ): ClientLimitExceededException =
      ClientLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createSignalingChannelInput(
      channelName: Option[String] = None,
      channelType: Option[String] = None,
      singleMasterConfiguration: Option[SingleMasterConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): CreateSignalingChannelInput =
      CreateSignalingChannelInput
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelType)(_.channelType(_))
        .ifSome(singleMasterConfiguration)(_.singleMasterConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSignalingChannelOutput(
      channelARN: Option[String] = None
    ): CreateSignalingChannelOutput =
      CreateSignalingChannelOutput
        .builder
        .ifSome(channelARN)(_.channelARN(_))
        .build

    def createStreamInput(
      deviceName: Option[String] = None,
      streamName: Option[String] = None,
      mediaType: Option[String] = None,
      kmsKeyId: Option[String] = None,
      dataRetentionInHours: Option[Int] = None,
      tags: Option[ResourceTags] = None
    ): CreateStreamInput =
      CreateStreamInput
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(mediaType)(_.mediaType(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(dataRetentionInHours)(_.dataRetentionInHours(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamOutput(
      streamARN: Option[String] = None
    ): CreateStreamOutput =
      CreateStreamOutput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .build

    def deleteSignalingChannelInput(
      channelARN: Option[String] = None,
      currentVersion: Option[String] = None
    ): DeleteSignalingChannelInput =
      DeleteSignalingChannelInput
        .builder
        .ifSome(channelARN)(_.channelARN(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .build

    def deleteSignalingChannelOutput(

    ): DeleteSignalingChannelOutput =
      DeleteSignalingChannelOutput
        .builder

        .build

    def deleteStreamInput(
      streamARN: Option[String] = None,
      currentVersion: Option[String] = None
    ): DeleteStreamInput =
      DeleteStreamInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .build

    def deleteStreamOutput(

    ): DeleteStreamOutput =
      DeleteStreamOutput
        .builder

        .build

    def describeSignalingChannelInput(
      channelName: Option[String] = None,
      channelARN: Option[String] = None
    ): DescribeSignalingChannelInput =
      DescribeSignalingChannelInput
        .builder
        .ifSome(channelName)(_.channelName(_))
        .ifSome(channelARN)(_.channelARN(_))
        .build

    def describeSignalingChannelOutput(
      channelInfo: Option[ChannelInfo] = None
    ): DescribeSignalingChannelOutput =
      DescribeSignalingChannelOutput
        .builder
        .ifSome(channelInfo)(_.channelInfo(_))
        .build

    def describeStreamInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None
    ): DescribeStreamInput =
      DescribeStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .build

    def describeStreamOutput(
      streamInfo: Option[StreamInfo] = None
    ): DescribeStreamOutput =
      DescribeStreamOutput
        .builder
        .ifSome(streamInfo)(_.streamInfo(_))
        .build

    def deviceStreamLimitExceededException(
      message: Option[String] = None
    ): DeviceStreamLimitExceededException =
      DeviceStreamLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getDataEndpointInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      aPIName: Option[String] = None
    ): GetDataEndpointInput =
      GetDataEndpointInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(aPIName)(_.aPIName(_))
        .build

    def getDataEndpointOutput(
      dataEndpoint: Option[String] = None
    ): GetDataEndpointOutput =
      GetDataEndpointOutput
        .builder
        .ifSome(dataEndpoint)(_.dataEndpoint(_))
        .build

    def getSignalingChannelEndpointInput(
      channelARN: Option[String] = None,
      singleMasterChannelEndpointConfiguration: Option[SingleMasterChannelEndpointConfiguration] = None
    ): GetSignalingChannelEndpointInput =
      GetSignalingChannelEndpointInput
        .builder
        .ifSome(channelARN)(_.channelARN(_))
        .ifSome(singleMasterChannelEndpointConfiguration)(_.singleMasterChannelEndpointConfiguration(_))
        .build

    def getSignalingChannelEndpointOutput(
      resourceEndpointList: Option[List[ResourceEndpointListItem]] = None
    ): GetSignalingChannelEndpointOutput =
      GetSignalingChannelEndpointOutput
        .builder
        .ifSome(resourceEndpointList)(_.resourceEndpointList(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDeviceException(
      message: Option[String] = None
    ): InvalidDeviceException =
      InvalidDeviceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResourceFormatException(
      message: Option[String] = None
    ): InvalidResourceFormatException =
      InvalidResourceFormatException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listSignalingChannelsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      channelNameCondition: Option[ChannelNameCondition] = None
    ): ListSignalingChannelsInput =
      ListSignalingChannelsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(channelNameCondition)(_.channelNameCondition(_))
        .build

    def listSignalingChannelsOutput(
      channelInfoList: Option[List[ChannelInfo]] = None,
      nextToken: Option[String] = None
    ): ListSignalingChannelsOutput =
      ListSignalingChannelsOutput
        .builder
        .ifSome(channelInfoList)(_.channelInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamsInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      streamNameCondition: Option[StreamNameCondition] = None
    ): ListStreamsInput =
      ListStreamsInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(streamNameCondition)(_.streamNameCondition(_))
        .build

    def listStreamsOutput(
      streamInfoList: Option[List[StreamInfo]] = None,
      nextToken: Option[String] = None
    ): ListStreamsOutput =
      ListStreamsOutput
        .builder
        .ifSome(streamInfoList)(_.streamInfoList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceInput(
      nextToken: Option[String] = None,
      resourceARN: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceOutput(
      nextToken: Option[String] = None,
      tags: Option[ResourceTags] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listTagsForStreamInput(
      nextToken: Option[String] = None,
      streamARN: Option[String] = None,
      streamName: Option[String] = None
    ): ListTagsForStreamInput =
      ListTagsForStreamInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def listTagsForStreamOutput(
      nextToken: Option[String] = None,
      tags: Option[ResourceTags] = None
    ): ListTagsForStreamOutput =
      ListTagsForStreamOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceEndpointListItem(
      protocol: Option[String] = None,
      resourceEndpoint: Option[String] = None
    ): ResourceEndpointListItem =
      ResourceEndpointListItem
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(resourceEndpoint)(_.resourceEndpoint(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
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

    def singleMasterChannelEndpointConfiguration(
      protocols: Option[List[ChannelProtocol]] = None,
      role: Option[String] = None
    ): SingleMasterChannelEndpointConfiguration =
      SingleMasterChannelEndpointConfiguration
        .builder
        .ifSome(protocols)(_.protocols(_))
        .ifSome(role)(_.role(_))
        .build

    def singleMasterConfiguration(
      messageTtlSeconds: Option[Int] = None
    ): SingleMasterConfiguration =
      SingleMasterConfiguration
        .builder
        .ifSome(messageTtlSeconds)(_.messageTtlSeconds(_))
        .build

    def streamInfo(
      deviceName: Option[String] = None,
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      mediaType: Option[String] = None,
      kmsKeyId: Option[String] = None,
      version: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      dataRetentionInHours: Option[Int] = None
    ): StreamInfo =
      StreamInfo
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(mediaType)(_.mediaType(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(version)(_.version(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(dataRetentionInHours)(_.dataRetentionInHours(_))
        .build

    def streamNameCondition(
      comparisonOperator: Option[String] = None,
      comparisonValue: Option[String] = None
    ): StreamNameCondition =
      StreamNameCondition
        .builder
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(comparisonValue)(_.comparisonValue(_))
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

    def tagResourceInput(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def tagStreamInput(
      streamARN: Option[String] = None,
      streamName: Option[String] = None,
      tags: Option[ResourceTags] = None
    ): TagStreamInput =
      TagStreamInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagStreamOutput(

    ): TagStreamOutput =
      TagStreamOutput
        .builder

        .build

    def tagsPerResourceExceededLimitException(
      message: Option[String] = None
    ): TagsPerResourceExceededLimitException =
      TagsPerResourceExceededLimitException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceInput(
      resourceARN: Option[String] = None,
      tagKeyList: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeyList)(_.tagKeyList(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def untagStreamInput(
      streamARN: Option[String] = None,
      streamName: Option[String] = None,
      tagKeyList: Option[List[TagKey]] = None
    ): UntagStreamInput =
      UntagStreamInput
        .builder
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(tagKeyList)(_.tagKeyList(_))
        .build

    def untagStreamOutput(

    ): UntagStreamOutput =
      UntagStreamOutput
        .builder

        .build

    def updateDataRetentionInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      currentVersion: Option[String] = None,
      operation: Option[String] = None,
      dataRetentionChangeInHours: Option[Int] = None
    ): UpdateDataRetentionInput =
      UpdateDataRetentionInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(dataRetentionChangeInHours)(_.dataRetentionChangeInHours(_))
        .build

    def updateDataRetentionOutput(

    ): UpdateDataRetentionOutput =
      UpdateDataRetentionOutput
        .builder

        .build

    def updateSignalingChannelInput(
      channelARN: Option[String] = None,
      currentVersion: Option[String] = None,
      singleMasterConfiguration: Option[SingleMasterConfiguration] = None
    ): UpdateSignalingChannelInput =
      UpdateSignalingChannelInput
        .builder
        .ifSome(channelARN)(_.channelARN(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(singleMasterConfiguration)(_.singleMasterConfiguration(_))
        .build

    def updateSignalingChannelOutput(

    ): UpdateSignalingChannelOutput =
      UpdateSignalingChannelOutput
        .builder

        .build

    def updateStreamInput(
      streamName: Option[String] = None,
      streamARN: Option[String] = None,
      currentVersion: Option[String] = None,
      deviceName: Option[String] = None,
      mediaType: Option[String] = None
    ): UpdateStreamInput =
      UpdateStreamInput
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(streamARN)(_.streamARN(_))
        .ifSome(currentVersion)(_.currentVersion(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(mediaType)(_.mediaType(_))
        .build

    def updateStreamOutput(

    ): UpdateStreamOutput =
      UpdateStreamOutput
        .builder

        .build

    def versionMismatchException(
      message: Option[String] = None
    ): VersionMismatchException =
      VersionMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
