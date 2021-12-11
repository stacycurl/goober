package goober.hi

import goober.free.mediapackagevod.MediaPackageVodIO
import software.amazon.awssdk.services.mediapackagevod.model._


object mediapackagevod {
  import goober.free.{mediapackagevod ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def asset(
      arn: Option[String] = None,
      createdAt: Option[String] = None,
      egressEndpoints: Option[List[EgressEndpoint]] = None,
      id: Option[String] = None,
      packagingGroupId: Option[String] = None,
      resourceId: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceRoleArn: Option[String] = None,
      tags: Option[Tags] = None
    ): Asset =
      Asset
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(id)(_.id(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceRoleArn)(_.sourceRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def assetCreateParameters(
      id: Option[String] = None,
      packagingGroupId: Option[String] = None,
      resourceId: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceRoleArn: Option[String] = None,
      tags: Option[Tags] = None
    ): AssetCreateParameters =
      AssetCreateParameters
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceRoleArn)(_.sourceRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def assetList(
      assets: Option[List[AssetShallow]] = None,
      nextToken: Option[String] = None
    ): AssetList =
      AssetList
        .builder
        .ifSome(assets)(_.assets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def assetShallow(
      arn: Option[String] = None,
      createdAt: Option[String] = None,
      id: Option[String] = None,
      packagingGroupId: Option[String] = None,
      resourceId: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceRoleArn: Option[String] = None,
      tags: Option[Tags] = None
    ): AssetShallow =
      AssetShallow
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(id)(_.id(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceRoleArn)(_.sourceRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def authorization(
      cdnIdentifierSecret: Option[String] = None,
      secretsRoleArn: Option[String] = None
    ): Authorization =
      Authorization
        .builder
        .ifSome(cdnIdentifierSecret)(_.cdnIdentifierSecret(_))
        .ifSome(secretsRoleArn)(_.secretsRoleArn(_))
        .build

    def cmafEncryption(
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): CmafEncryption =
      CmafEncryption
        .builder
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def cmafPackage(
      encryption: Option[CmafEncryption] = None,
      hlsManifests: Option[List[HlsManifest]] = None,
      includeEncoderConfigurationInSegments: Option[Boolean] = None,
      segmentDurationSeconds: Option[Int] = None
    ): CmafPackage =
      CmafPackage
        .builder
        .ifSome(encryption)(_.encryption(_))
        .ifSome(hlsManifests)(_.hlsManifests(_))
        .ifSome(includeEncoderConfigurationInSegments)(_.includeEncoderConfigurationInSegments(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .build

    def configureLogsParameters(
      egressAccessLogs: Option[EgressAccessLogs] = None
    ): ConfigureLogsParameters =
      ConfigureLogsParameters
        .builder
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .build

    def configureLogsRequest(
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None
    ): ConfigureLogsRequest =
      ConfigureLogsRequest
        .builder
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .build

    def configureLogsResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      domainName: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): ConfigureLogsResponse =
      ConfigureLogsResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssetRequest(
      id: Option[String] = None,
      packagingGroupId: Option[String] = None,
      resourceId: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceRoleArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateAssetRequest =
      CreateAssetRequest
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceRoleArn)(_.sourceRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createAssetResponse(
      arn: Option[String] = None,
      createdAt: Option[String] = None,
      egressEndpoints: Option[List[EgressEndpoint]] = None,
      id: Option[String] = None,
      packagingGroupId: Option[String] = None,
      resourceId: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceRoleArn: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateAssetResponse =
      CreateAssetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(id)(_.id(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceRoleArn)(_.sourceRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPackagingConfigurationRequest(
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      packagingGroupId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreatePackagingConfigurationRequest =
      CreatePackagingConfigurationRequest
        .builder
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPackagingConfigurationResponse(
      arn: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      packagingGroupId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreatePackagingConfigurationResponse =
      CreatePackagingConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPackagingGroupRequest(
      authorization: Option[Authorization] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): CreatePackagingGroupRequest =
      CreatePackagingGroupRequest
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPackagingGroupResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      domainName: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): CreatePackagingGroupResponse =
      CreatePackagingGroupResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def dashEncryption(
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): DashEncryption =
      DashEncryption
        .builder
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def dashManifest(
      manifestLayout: Option[String] = None,
      manifestName: Option[String] = None,
      minBufferTimeSeconds: Option[Int] = None,
      profile: Option[String] = None,
      streamSelection: Option[StreamSelection] = None
    ): DashManifest =
      DashManifest
        .builder
        .ifSome(manifestLayout)(_.manifestLayout(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(minBufferTimeSeconds)(_.minBufferTimeSeconds(_))
        .ifSome(profile)(_.profile(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .build

    def dashPackage(
      dashManifests: Option[List[DashManifest]] = None,
      encryption: Option[DashEncryption] = None,
      includeEncoderConfigurationInSegments: Option[Boolean] = None,
      periodTriggers: Option[List[__PeriodTriggersElement]] = None,
      segmentDurationSeconds: Option[Int] = None,
      segmentTemplateFormat: Option[String] = None
    ): DashPackage =
      DashPackage
        .builder
        .ifSome(dashManifests)(_.dashManifests(_))
        .ifSome(encryption)(_.encryption(_))
        .ifSome(includeEncoderConfigurationInSegments)(_.includeEncoderConfigurationInSegments(_))
        .ifSome(periodTriggers)(_.periodTriggers(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(segmentTemplateFormat)(_.segmentTemplateFormat(_))
        .build

    def deleteAssetRequest(
      id: Option[String] = None
    ): DeleteAssetRequest =
      DeleteAssetRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteAssetResponse(

    ): DeleteAssetResponse =
      DeleteAssetResponse
        .builder

        .build

    def deletePackagingConfigurationRequest(
      id: Option[String] = None
    ): DeletePackagingConfigurationRequest =
      DeletePackagingConfigurationRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deletePackagingConfigurationResponse(

    ): DeletePackagingConfigurationResponse =
      DeletePackagingConfigurationResponse
        .builder

        .build

    def deletePackagingGroupRequest(
      id: Option[String] = None
    ): DeletePackagingGroupRequest =
      DeletePackagingGroupRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deletePackagingGroupResponse(

    ): DeletePackagingGroupResponse =
      DeletePackagingGroupResponse
        .builder

        .build

    def describeAssetRequest(
      id: Option[String] = None
    ): DescribeAssetRequest =
      DescribeAssetRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describeAssetResponse(
      arn: Option[String] = None,
      createdAt: Option[String] = None,
      egressEndpoints: Option[List[EgressEndpoint]] = None,
      id: Option[String] = None,
      packagingGroupId: Option[String] = None,
      resourceId: Option[String] = None,
      sourceArn: Option[String] = None,
      sourceRoleArn: Option[String] = None,
      tags: Option[Tags] = None
    ): DescribeAssetResponse =
      DescribeAssetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(egressEndpoints)(_.egressEndpoints(_))
        .ifSome(id)(_.id(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(sourceArn)(_.sourceArn(_))
        .ifSome(sourceRoleArn)(_.sourceRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describePackagingConfigurationRequest(
      id: Option[String] = None
    ): DescribePackagingConfigurationRequest =
      DescribePackagingConfigurationRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describePackagingConfigurationResponse(
      arn: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      packagingGroupId: Option[String] = None,
      tags: Option[Tags] = None
    ): DescribePackagingConfigurationResponse =
      DescribePackagingConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describePackagingGroupRequest(
      id: Option[String] = None
    ): DescribePackagingGroupRequest =
      DescribePackagingGroupRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def describePackagingGroupResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      domainName: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): DescribePackagingGroupResponse =
      DescribePackagingGroupResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def egressAccessLogs(
      logGroupName: Option[String] = None
    ): EgressAccessLogs =
      EgressAccessLogs
        .builder
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def egressEndpoint(
      packagingConfigurationId: Option[String] = None,
      url: Option[String] = None
    ): EgressEndpoint =
      EgressEndpoint
        .builder
        .ifSome(packagingConfigurationId)(_.packagingConfigurationId(_))
        .ifSome(url)(_.url(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def hlsEncryption(
      constantInitializationVector: Option[String] = None,
      encryptionMethod: Option[String] = None,
      spekeKeyProvider: Option[SpekeKeyProvider] = None
    ): HlsEncryption =
      HlsEncryption
        .builder
        .ifSome(constantInitializationVector)(_.constantInitializationVector(_))
        .ifSome(encryptionMethod)(_.encryptionMethod(_))
        .ifSome(spekeKeyProvider)(_.spekeKeyProvider(_))
        .build

    def hlsManifest(
      adMarkers: Option[String] = None,
      includeIframeOnlyStream: Option[Boolean] = None,
      manifestName: Option[String] = None,
      programDateTimeIntervalSeconds: Option[Int] = None,
      repeatExtXKey: Option[Boolean] = None,
      streamSelection: Option[StreamSelection] = None
    ): HlsManifest =
      HlsManifest
        .builder
        .ifSome(adMarkers)(_.adMarkers(_))
        .ifSome(includeIframeOnlyStream)(_.includeIframeOnlyStream(_))
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(programDateTimeIntervalSeconds)(_.programDateTimeIntervalSeconds(_))
        .ifSome(repeatExtXKey)(_.repeatExtXKey(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .build

    def hlsPackage(
      encryption: Option[HlsEncryption] = None,
      hlsManifests: Option[List[HlsManifest]] = None,
      segmentDurationSeconds: Option[Int] = None,
      useAudioRenditionGroup: Option[Boolean] = None
    ): HlsPackage =
      HlsPackage
        .builder
        .ifSome(encryption)(_.encryption(_))
        .ifSome(hlsManifests)(_.hlsManifests(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .ifSome(useAudioRenditionGroup)(_.useAudioRenditionGroup(_))
        .build

    def internalServerErrorException(
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAssetsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      packagingGroupId: Option[String] = None
    ): ListAssetsRequest =
      ListAssetsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .build

    def listAssetsResponse(
      assets: Option[List[AssetShallow]] = None,
      nextToken: Option[String] = None
    ): ListAssetsResponse =
      ListAssetsResponse
        .builder
        .ifSome(assets)(_.assets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackagingConfigurationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      packagingGroupId: Option[String] = None
    ): ListPackagingConfigurationsRequest =
      ListPackagingConfigurationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .build

    def listPackagingConfigurationsResponse(
      nextToken: Option[String] = None,
      packagingConfigurations: Option[List[PackagingConfiguration]] = None
    ): ListPackagingConfigurationsResponse =
      ListPackagingConfigurationsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(packagingConfigurations)(_.packagingConfigurations(_))
        .build

    def listPackagingGroupsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPackagingGroupsRequest =
      ListPackagingGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPackagingGroupsResponse(
      nextToken: Option[String] = None,
      packagingGroups: Option[List[PackagingGroup]] = None
    ): ListPackagingGroupsResponse =
      ListPackagingGroupsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(packagingGroups)(_.packagingGroups(_))
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

    def mssManifest(
      manifestName: Option[String] = None,
      streamSelection: Option[StreamSelection] = None
    ): MssManifest =
      MssManifest
        .builder
        .ifSome(manifestName)(_.manifestName(_))
        .ifSome(streamSelection)(_.streamSelection(_))
        .build

    def mssPackage(
      encryption: Option[MssEncryption] = None,
      mssManifests: Option[List[MssManifest]] = None,
      segmentDurationSeconds: Option[Int] = None
    ): MssPackage =
      MssPackage
        .builder
        .ifSome(encryption)(_.encryption(_))
        .ifSome(mssManifests)(_.mssManifests(_))
        .ifSome(segmentDurationSeconds)(_.segmentDurationSeconds(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def packagingConfiguration(
      arn: Option[String] = None,
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      packagingGroupId: Option[String] = None,
      tags: Option[Tags] = None
    ): PackagingConfiguration =
      PackagingConfiguration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def packagingConfigurationCreateParameters(
      cmafPackage: Option[CmafPackage] = None,
      dashPackage: Option[DashPackage] = None,
      hlsPackage: Option[HlsPackage] = None,
      id: Option[String] = None,
      mssPackage: Option[MssPackage] = None,
      packagingGroupId: Option[String] = None,
      tags: Option[Tags] = None
    ): PackagingConfigurationCreateParameters =
      PackagingConfigurationCreateParameters
        .builder
        .ifSome(cmafPackage)(_.cmafPackage(_))
        .ifSome(dashPackage)(_.dashPackage(_))
        .ifSome(hlsPackage)(_.hlsPackage(_))
        .ifSome(id)(_.id(_))
        .ifSome(mssPackage)(_.mssPackage(_))
        .ifSome(packagingGroupId)(_.packagingGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def packagingConfigurationList(
      nextToken: Option[String] = None,
      packagingConfigurations: Option[List[PackagingConfiguration]] = None
    ): PackagingConfigurationList =
      PackagingConfigurationList
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(packagingConfigurations)(_.packagingConfigurations(_))
        .build

    def packagingGroup(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      domainName: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): PackagingGroup =
      PackagingGroup
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def packagingGroupCreateParameters(
      authorization: Option[Authorization] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): PackagingGroupCreateParameters =
      PackagingGroupCreateParameters
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

    def packagingGroupList(
      nextToken: Option[String] = None,
      packagingGroups: Option[List[PackagingGroup]] = None
    ): PackagingGroupList =
      PackagingGroupList
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(packagingGroups)(_.packagingGroups(_))
        .build

    def packagingGroupUpdateParameters(
      authorization: Option[Authorization] = None
    ): PackagingGroupUpdateParameters =
      PackagingGroupUpdateParameters
        .builder
        .ifSome(authorization)(_.authorization(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def spekeKeyProvider(
      roleArn: Option[String] = None,
      systemIds: Option[List[__string]] = None,
      url: Option[String] = None
    ): SpekeKeyProvider =
      SpekeKeyProvider
        .builder
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

    def updatePackagingGroupRequest(
      authorization: Option[Authorization] = None,
      id: Option[String] = None
    ): UpdatePackagingGroupRequest =
      UpdatePackagingGroupRequest
        .builder
        .ifSome(authorization)(_.authorization(_))
        .ifSome(id)(_.id(_))
        .build

    def updatePackagingGroupResponse(
      arn: Option[String] = None,
      authorization: Option[Authorization] = None,
      domainName: Option[String] = None,
      egressAccessLogs: Option[EgressAccessLogs] = None,
      id: Option[String] = None,
      tags: Option[Tags] = None
    ): UpdatePackagingGroupResponse =
      UpdatePackagingGroupResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authorization)(_.authorization(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(egressAccessLogs)(_.egressAccessLogs(_))
        .ifSome(id)(_.id(_))
        .ifSome(tags)(_.tags(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
