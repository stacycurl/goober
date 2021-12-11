package goober.hi

import goober.free.groundstation.GroundStationIO
import software.amazon.awssdk.services.groundstation.model._


object groundstation {
  import goober.free.{groundstation ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def antennaDemodDecodeDetails(
      outputNode: Option[String] = None
    ): AntennaDemodDecodeDetails =
      AntennaDemodDecodeDetails
        .builder
        .ifSome(outputNode)(_.outputNode(_))
        .build

    def antennaDownlinkConfig(
      spectrumConfig: Option[SpectrumConfig] = None
    ): AntennaDownlinkConfig =
      AntennaDownlinkConfig
        .builder
        .ifSome(spectrumConfig)(_.spectrumConfig(_))
        .build

    def antennaDownlinkDemodDecodeConfig(
      decodeConfig: Option[DecodeConfig] = None,
      demodulationConfig: Option[DemodulationConfig] = None,
      spectrumConfig: Option[SpectrumConfig] = None
    ): AntennaDownlinkDemodDecodeConfig =
      AntennaDownlinkDemodDecodeConfig
        .builder
        .ifSome(decodeConfig)(_.decodeConfig(_))
        .ifSome(demodulationConfig)(_.demodulationConfig(_))
        .ifSome(spectrumConfig)(_.spectrumConfig(_))
        .build

    def antennaUplinkConfig(
      spectrumConfig: Option[UplinkSpectrumConfig] = None,
      targetEirp: Option[Eirp] = None,
      transmitDisabled: Option[Boolean] = None
    ): AntennaUplinkConfig =
      AntennaUplinkConfig
        .builder
        .ifSome(spectrumConfig)(_.spectrumConfig(_))
        .ifSome(targetEirp)(_.targetEirp(_))
        .ifSome(transmitDisabled)(_.transmitDisabled(_))
        .build

    def cancelContactRequest(
      contactId: Option[String] = None
    ): CancelContactRequest =
      CancelContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def configDetails(
      antennaDemodDecodeDetails: Option[AntennaDemodDecodeDetails] = None,
      endpointDetails: Option[EndpointDetails] = None,
      s3RecordingDetails: Option[S3RecordingDetails] = None
    ): ConfigDetails =
      ConfigDetails
        .builder
        .ifSome(antennaDemodDecodeDetails)(_.antennaDemodDecodeDetails(_))
        .ifSome(endpointDetails)(_.endpointDetails(_))
        .ifSome(s3RecordingDetails)(_.s3RecordingDetails(_))
        .build

    def configIdResponse(
      configArn: Option[String] = None,
      configId: Option[String] = None,
      configType: Option[String] = None
    ): ConfigIdResponse =
      ConfigIdResponse
        .builder
        .ifSome(configArn)(_.configArn(_))
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .build

    def configListItem(
      configArn: Option[String] = None,
      configId: Option[String] = None,
      configType: Option[String] = None,
      name: Option[String] = None
    ): ConfigListItem =
      ConfigListItem
        .builder
        .ifSome(configArn)(_.configArn(_))
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .ifSome(name)(_.name(_))
        .build

    def configTypeData(
      antennaDownlinkConfig: Option[AntennaDownlinkConfig] = None,
      antennaDownlinkDemodDecodeConfig: Option[AntennaDownlinkDemodDecodeConfig] = None,
      antennaUplinkConfig: Option[AntennaUplinkConfig] = None,
      dataflowEndpointConfig: Option[DataflowEndpointConfig] = None,
      s3RecordingConfig: Option[S3RecordingConfig] = None,
      trackingConfig: Option[TrackingConfig] = None,
      uplinkEchoConfig: Option[UplinkEchoConfig] = None
    ): ConfigTypeData =
      ConfigTypeData
        .builder
        .ifSome(antennaDownlinkConfig)(_.antennaDownlinkConfig(_))
        .ifSome(antennaDownlinkDemodDecodeConfig)(_.antennaDownlinkDemodDecodeConfig(_))
        .ifSome(antennaUplinkConfig)(_.antennaUplinkConfig(_))
        .ifSome(dataflowEndpointConfig)(_.dataflowEndpointConfig(_))
        .ifSome(s3RecordingConfig)(_.s3RecordingConfig(_))
        .ifSome(trackingConfig)(_.trackingConfig(_))
        .ifSome(uplinkEchoConfig)(_.uplinkEchoConfig(_))
        .build

    def contactData(
      contactId: Option[String] = None,
      contactStatus: Option[String] = None,
      endTime: Option[Timestamp] = None,
      errorMessage: Option[String] = None,
      groundStation: Option[String] = None,
      maximumElevation: Option[Elevation] = None,
      missionProfileArn: Option[String] = None,
      postPassEndTime: Option[Timestamp] = None,
      prePassStartTime: Option[Timestamp] = None,
      region: Option[String] = None,
      satelliteArn: Option[String] = None,
      startTime: Option[Timestamp] = None,
      tags: Option[TagsMap] = None
    ): ContactData =
      ContactData
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(contactStatus)(_.contactStatus(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(groundStation)(_.groundStation(_))
        .ifSome(maximumElevation)(_.maximumElevation(_))
        .ifSome(missionProfileArn)(_.missionProfileArn(_))
        .ifSome(postPassEndTime)(_.postPassEndTime(_))
        .ifSome(prePassStartTime)(_.prePassStartTime(_))
        .ifSome(region)(_.region(_))
        .ifSome(satelliteArn)(_.satelliteArn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def contactIdResponse(
      contactId: Option[String] = None
    ): ContactIdResponse =
      ContactIdResponse
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def createConfigRequest(
      configData: Option[ConfigTypeData] = None,
      name: Option[String] = None,
      tags: Option[TagsMap] = None
    ): CreateConfigRequest =
      CreateConfigRequest
        .builder
        .ifSome(configData)(_.configData(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataflowEndpointGroupRequest(
      endpointDetails: Option[List[EndpointDetails]] = None,
      tags: Option[TagsMap] = None
    ): CreateDataflowEndpointGroupRequest =
      CreateDataflowEndpointGroupRequest
        .builder
        .ifSome(endpointDetails)(_.endpointDetails(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMissionProfileRequest(
      contactPostPassDurationSeconds: Option[Int] = None,
      contactPrePassDurationSeconds: Option[Int] = None,
      dataflowEdges: Option[List[DataflowEdge]] = None,
      minimumViableContactDurationSeconds: Option[Int] = None,
      name: Option[String] = None,
      tags: Option[TagsMap] = None,
      trackingConfigArn: Option[String] = None
    ): CreateMissionProfileRequest =
      CreateMissionProfileRequest
        .builder
        .ifSome(contactPostPassDurationSeconds)(_.contactPostPassDurationSeconds(_))
        .ifSome(contactPrePassDurationSeconds)(_.contactPrePassDurationSeconds(_))
        .ifSome(dataflowEdges)(_.dataflowEdges(_))
        .ifSome(minimumViableContactDurationSeconds)(_.minimumViableContactDurationSeconds(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(trackingConfigArn)(_.trackingConfigArn(_))
        .build

    def dataflowDetail(
      destination: Option[Destination] = None,
      errorMessage: Option[String] = None,
      source: Option[Source] = None
    ): DataflowDetail =
      DataflowDetail
        .builder
        .ifSome(destination)(_.destination(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(source)(_.source(_))
        .build

    def dataflowEndpoint(
      address: Option[SocketAddress] = None,
      mtu: Option[Int] = None,
      name: Option[String] = None,
      status: Option[String] = None
    ): DataflowEndpoint =
      DataflowEndpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(mtu)(_.mtu(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def dataflowEndpointConfig(
      dataflowEndpointName: Option[String] = None,
      dataflowEndpointRegion: Option[String] = None
    ): DataflowEndpointConfig =
      DataflowEndpointConfig
        .builder
        .ifSome(dataflowEndpointName)(_.dataflowEndpointName(_))
        .ifSome(dataflowEndpointRegion)(_.dataflowEndpointRegion(_))
        .build

    def dataflowEndpointGroupIdResponse(
      dataflowEndpointGroupId: Option[String] = None
    ): DataflowEndpointGroupIdResponse =
      DataflowEndpointGroupIdResponse
        .builder
        .ifSome(dataflowEndpointGroupId)(_.dataflowEndpointGroupId(_))
        .build

    def dataflowEndpointListItem(
      dataflowEndpointGroupArn: Option[String] = None,
      dataflowEndpointGroupId: Option[String] = None
    ): DataflowEndpointListItem =
      DataflowEndpointListItem
        .builder
        .ifSome(dataflowEndpointGroupArn)(_.dataflowEndpointGroupArn(_))
        .ifSome(dataflowEndpointGroupId)(_.dataflowEndpointGroupId(_))
        .build

    def decodeConfig(
      unvalidatedJSON: Option[String] = None
    ): DecodeConfig =
      DecodeConfig
        .builder
        .ifSome(unvalidatedJSON)(_.unvalidatedJSON(_))
        .build

    def deleteConfigRequest(
      configId: Option[String] = None,
      configType: Option[String] = None
    ): DeleteConfigRequest =
      DeleteConfigRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .build

    def deleteDataflowEndpointGroupRequest(
      dataflowEndpointGroupId: Option[String] = None
    ): DeleteDataflowEndpointGroupRequest =
      DeleteDataflowEndpointGroupRequest
        .builder
        .ifSome(dataflowEndpointGroupId)(_.dataflowEndpointGroupId(_))
        .build

    def deleteMissionProfileRequest(
      missionProfileId: Option[String] = None
    ): DeleteMissionProfileRequest =
      DeleteMissionProfileRequest
        .builder
        .ifSome(missionProfileId)(_.missionProfileId(_))
        .build

    def demodulationConfig(
      unvalidatedJSON: Option[String] = None
    ): DemodulationConfig =
      DemodulationConfig
        .builder
        .ifSome(unvalidatedJSON)(_.unvalidatedJSON(_))
        .build

    def dependencyException(
      message: Option[String] = None,
      parameterName: Option[String] = None
    ): DependencyException =
      DependencyException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(parameterName)(_.parameterName(_))
        .build

    def describeContactRequest(
      contactId: Option[String] = None
    ): DescribeContactRequest =
      DescribeContactRequest
        .builder
        .ifSome(contactId)(_.contactId(_))
        .build

    def describeContactResponse(
      contactId: Option[String] = None,
      contactStatus: Option[String] = None,
      dataflowList: Option[List[DataflowDetail]] = None,
      endTime: Option[Timestamp] = None,
      errorMessage: Option[String] = None,
      groundStation: Option[String] = None,
      maximumElevation: Option[Elevation] = None,
      missionProfileArn: Option[String] = None,
      postPassEndTime: Option[Timestamp] = None,
      prePassStartTime: Option[Timestamp] = None,
      region: Option[String] = None,
      satelliteArn: Option[String] = None,
      startTime: Option[Timestamp] = None,
      tags: Option[TagsMap] = None
    ): DescribeContactResponse =
      DescribeContactResponse
        .builder
        .ifSome(contactId)(_.contactId(_))
        .ifSome(contactStatus)(_.contactStatus(_))
        .ifSome(dataflowList)(_.dataflowList(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(groundStation)(_.groundStation(_))
        .ifSome(maximumElevation)(_.maximumElevation(_))
        .ifSome(missionProfileArn)(_.missionProfileArn(_))
        .ifSome(postPassEndTime)(_.postPassEndTime(_))
        .ifSome(prePassStartTime)(_.prePassStartTime(_))
        .ifSome(region)(_.region(_))
        .ifSome(satelliteArn)(_.satelliteArn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def destination(
      configDetails: Option[ConfigDetails] = None,
      configId: Option[String] = None,
      configType: Option[String] = None,
      dataflowDestinationRegion: Option[String] = None
    ): Destination =
      Destination
        .builder
        .ifSome(configDetails)(_.configDetails(_))
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .ifSome(dataflowDestinationRegion)(_.dataflowDestinationRegion(_))
        .build

    def eirp(
      units: Option[String] = None,
      value: Option[Double] = None
    ): Eirp =
      Eirp
        .builder
        .ifSome(units)(_.units(_))
        .ifSome(value)(_.value(_))
        .build

    def elevation(
      unit: Option[String] = None,
      value: Option[Double] = None
    ): Elevation =
      Elevation
        .builder
        .ifSome(unit)(_.unit(_))
        .ifSome(value)(_.value(_))
        .build

    def endpointDetails(
      endpoint: Option[DataflowEndpoint] = None,
      securityDetails: Option[SecurityDetails] = None
    ): EndpointDetails =
      EndpointDetails
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(securityDetails)(_.securityDetails(_))
        .build

    def frequency(
      units: Option[String] = None,
      value: Option[Double] = None
    ): Frequency =
      Frequency
        .builder
        .ifSome(units)(_.units(_))
        .ifSome(value)(_.value(_))
        .build

    def frequencyBandwidth(
      units: Option[String] = None,
      value: Option[Double] = None
    ): FrequencyBandwidth =
      FrequencyBandwidth
        .builder
        .ifSome(units)(_.units(_))
        .ifSome(value)(_.value(_))
        .build

    def getConfigRequest(
      configId: Option[String] = None,
      configType: Option[String] = None
    ): GetConfigRequest =
      GetConfigRequest
        .builder
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .build

    def getConfigResponse(
      configArn: Option[String] = None,
      configData: Option[ConfigTypeData] = None,
      configId: Option[String] = None,
      configType: Option[String] = None,
      name: Option[String] = None,
      tags: Option[TagsMap] = None
    ): GetConfigResponse =
      GetConfigResponse
        .builder
        .ifSome(configArn)(_.configArn(_))
        .ifSome(configData)(_.configData(_))
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getDataflowEndpointGroupRequest(
      dataflowEndpointGroupId: Option[String] = None
    ): GetDataflowEndpointGroupRequest =
      GetDataflowEndpointGroupRequest
        .builder
        .ifSome(dataflowEndpointGroupId)(_.dataflowEndpointGroupId(_))
        .build

    def getDataflowEndpointGroupResponse(
      dataflowEndpointGroupArn: Option[String] = None,
      dataflowEndpointGroupId: Option[String] = None,
      endpointsDetails: Option[List[EndpointDetails]] = None,
      tags: Option[TagsMap] = None
    ): GetDataflowEndpointGroupResponse =
      GetDataflowEndpointGroupResponse
        .builder
        .ifSome(dataflowEndpointGroupArn)(_.dataflowEndpointGroupArn(_))
        .ifSome(dataflowEndpointGroupId)(_.dataflowEndpointGroupId(_))
        .ifSome(endpointsDetails)(_.endpointsDetails(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getMinuteUsageRequest(
      month: Option[Int] = None,
      year: Option[Int] = None
    ): GetMinuteUsageRequest =
      GetMinuteUsageRequest
        .builder
        .ifSome(month)(_.month(_))
        .ifSome(year)(_.year(_))
        .build

    def getMinuteUsageResponse(
      estimatedMinutesRemaining: Option[Int] = None,
      isReservedMinutesCustomer: Option[Boolean] = None,
      totalReservedMinuteAllocation: Option[Int] = None,
      totalScheduledMinutes: Option[Int] = None,
      upcomingMinutesScheduled: Option[Int] = None
    ): GetMinuteUsageResponse =
      GetMinuteUsageResponse
        .builder
        .ifSome(estimatedMinutesRemaining)(_.estimatedMinutesRemaining(_))
        .ifSome(isReservedMinutesCustomer)(_.isReservedMinutesCustomer(_))
        .ifSome(totalReservedMinuteAllocation)(_.totalReservedMinuteAllocation(_))
        .ifSome(totalScheduledMinutes)(_.totalScheduledMinutes(_))
        .ifSome(upcomingMinutesScheduled)(_.upcomingMinutesScheduled(_))
        .build

    def getMissionProfileRequest(
      missionProfileId: Option[String] = None
    ): GetMissionProfileRequest =
      GetMissionProfileRequest
        .builder
        .ifSome(missionProfileId)(_.missionProfileId(_))
        .build

    def getMissionProfileResponse(
      contactPostPassDurationSeconds: Option[Int] = None,
      contactPrePassDurationSeconds: Option[Int] = None,
      dataflowEdges: Option[List[DataflowEdge]] = None,
      minimumViableContactDurationSeconds: Option[Int] = None,
      missionProfileArn: Option[String] = None,
      missionProfileId: Option[String] = None,
      name: Option[String] = None,
      region: Option[String] = None,
      tags: Option[TagsMap] = None,
      trackingConfigArn: Option[String] = None
    ): GetMissionProfileResponse =
      GetMissionProfileResponse
        .builder
        .ifSome(contactPostPassDurationSeconds)(_.contactPostPassDurationSeconds(_))
        .ifSome(contactPrePassDurationSeconds)(_.contactPrePassDurationSeconds(_))
        .ifSome(dataflowEdges)(_.dataflowEdges(_))
        .ifSome(minimumViableContactDurationSeconds)(_.minimumViableContactDurationSeconds(_))
        .ifSome(missionProfileArn)(_.missionProfileArn(_))
        .ifSome(missionProfileId)(_.missionProfileId(_))
        .ifSome(name)(_.name(_))
        .ifSome(region)(_.region(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(trackingConfigArn)(_.trackingConfigArn(_))
        .build

    def getSatelliteRequest(
      satelliteId: Option[String] = None
    ): GetSatelliteRequest =
      GetSatelliteRequest
        .builder
        .ifSome(satelliteId)(_.satelliteId(_))
        .build

    def getSatelliteResponse(
      groundStations: Option[List[String]] = None,
      noradSatelliteID: Option[Int] = None,
      satelliteArn: Option[String] = None,
      satelliteId: Option[String] = None
    ): GetSatelliteResponse =
      GetSatelliteResponse
        .builder
        .ifSome(groundStations)(_.groundStations(_))
        .ifSome(noradSatelliteID)(_.noradSatelliteID(_))
        .ifSome(satelliteArn)(_.satelliteArn(_))
        .ifSome(satelliteId)(_.satelliteId(_))
        .build

    def groundStationData(
      groundStationId: Option[String] = None,
      groundStationName: Option[String] = None,
      region: Option[String] = None
    ): GroundStationData =
      GroundStationData
        .builder
        .ifSome(groundStationId)(_.groundStationId(_))
        .ifSome(groundStationName)(_.groundStationName(_))
        .ifSome(region)(_.region(_))
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

    def listConfigsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigsRequest =
      ListConfigsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigsResponse(
      configList: Option[List[ConfigListItem]] = None,
      nextToken: Option[String] = None
    ): ListConfigsResponse =
      ListConfigsResponse
        .builder
        .ifSome(configList)(_.configList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContactsRequest(
      endTime: Option[Timestamp] = None,
      groundStation: Option[String] = None,
      maxResults: Option[Int] = None,
      missionProfileArn: Option[String] = None,
      nextToken: Option[String] = None,
      satelliteArn: Option[String] = None,
      startTime: Option[Timestamp] = None,
      statusList: Option[List[ContactStatus]] = None
    ): ListContactsRequest =
      ListContactsRequest
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(groundStation)(_.groundStation(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(missionProfileArn)(_.missionProfileArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(satelliteArn)(_.satelliteArn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(statusList)(_.statusList(_))
        .build

    def listContactsResponse(
      contactList: Option[List[ContactData]] = None,
      nextToken: Option[String] = None
    ): ListContactsResponse =
      ListContactsResponse
        .builder
        .ifSome(contactList)(_.contactList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDataflowEndpointGroupsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDataflowEndpointGroupsRequest =
      ListDataflowEndpointGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDataflowEndpointGroupsResponse(
      dataflowEndpointGroupList: Option[List[DataflowEndpointListItem]] = None,
      nextToken: Option[String] = None
    ): ListDataflowEndpointGroupsResponse =
      ListDataflowEndpointGroupsResponse
        .builder
        .ifSome(dataflowEndpointGroupList)(_.dataflowEndpointGroupList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroundStationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      satelliteId: Option[String] = None
    ): ListGroundStationsRequest =
      ListGroundStationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(satelliteId)(_.satelliteId(_))
        .build

    def listGroundStationsResponse(
      groundStationList: Option[List[GroundStationData]] = None,
      nextToken: Option[String] = None
    ): ListGroundStationsResponse =
      ListGroundStationsResponse
        .builder
        .ifSome(groundStationList)(_.groundStationList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMissionProfilesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMissionProfilesRequest =
      ListMissionProfilesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMissionProfilesResponse(
      missionProfileList: Option[List[MissionProfileListItem]] = None,
      nextToken: Option[String] = None
    ): ListMissionProfilesResponse =
      ListMissionProfilesResponse
        .builder
        .ifSome(missionProfileList)(_.missionProfileList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSatellitesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSatellitesRequest =
      ListSatellitesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSatellitesResponse(
      nextToken: Option[String] = None,
      satellites: Option[List[SatelliteListItem]] = None
    ): ListSatellitesResponse =
      ListSatellitesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(satellites)(_.satellites(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagsMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def missionProfileIdResponse(
      missionProfileId: Option[String] = None
    ): MissionProfileIdResponse =
      MissionProfileIdResponse
        .builder
        .ifSome(missionProfileId)(_.missionProfileId(_))
        .build

    def missionProfileListItem(
      missionProfileArn: Option[String] = None,
      missionProfileId: Option[String] = None,
      name: Option[String] = None,
      region: Option[String] = None
    ): MissionProfileListItem =
      MissionProfileListItem
        .builder
        .ifSome(missionProfileArn)(_.missionProfileArn(_))
        .ifSome(missionProfileId)(_.missionProfileId(_))
        .ifSome(name)(_.name(_))
        .ifSome(region)(_.region(_))
        .build

    def reserveContactRequest(
      endTime: Option[Timestamp] = None,
      groundStation: Option[String] = None,
      missionProfileArn: Option[String] = None,
      satelliteArn: Option[String] = None,
      startTime: Option[Timestamp] = None,
      tags: Option[TagsMap] = None
    ): ReserveContactRequest =
      ReserveContactRequest
        .builder
        .ifSome(endTime)(_.endTime(_))
        .ifSome(groundStation)(_.groundStation(_))
        .ifSome(missionProfileArn)(_.missionProfileArn(_))
        .ifSome(satelliteArn)(_.satelliteArn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceLimitExceededException(
      message: Option[String] = None,
      parameterName: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(parameterName)(_.parameterName(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3RecordingConfig(
      bucketArn: Option[String] = None,
      prefix: Option[String] = None,
      roleArn: Option[String] = None
    ): S3RecordingConfig =
      S3RecordingConfig
        .builder
        .ifSome(bucketArn)(_.bucketArn(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def s3RecordingDetails(
      bucketArn: Option[String] = None,
      keyTemplate: Option[String] = None
    ): S3RecordingDetails =
      S3RecordingDetails
        .builder
        .ifSome(bucketArn)(_.bucketArn(_))
        .ifSome(keyTemplate)(_.keyTemplate(_))
        .build

    def satelliteListItem(
      groundStations: Option[List[String]] = None,
      noradSatelliteID: Option[Int] = None,
      satelliteArn: Option[String] = None,
      satelliteId: Option[String] = None
    ): SatelliteListItem =
      SatelliteListItem
        .builder
        .ifSome(groundStations)(_.groundStations(_))
        .ifSome(noradSatelliteID)(_.noradSatelliteID(_))
        .ifSome(satelliteArn)(_.satelliteArn(_))
        .ifSome(satelliteId)(_.satelliteId(_))
        .build

    def securityDetails(
      roleArn: Option[String] = None,
      securityGroupIds: Option[List[String]] = None,
      subnetIds: Option[List[String]] = None
    ): SecurityDetails =
      SecurityDetails
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .build

    def socketAddress(
      name: Option[String] = None,
      port: Option[Int] = None
    ): SocketAddress =
      SocketAddress
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(port)(_.port(_))
        .build

    def source(
      configDetails: Option[ConfigDetails] = None,
      configId: Option[String] = None,
      configType: Option[String] = None,
      dataflowSourceRegion: Option[String] = None
    ): Source =
      Source
        .builder
        .ifSome(configDetails)(_.configDetails(_))
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .ifSome(dataflowSourceRegion)(_.dataflowSourceRegion(_))
        .build

    def spectrumConfig(
      bandwidth: Option[FrequencyBandwidth] = None,
      centerFrequency: Option[Frequency] = None,
      polarization: Option[String] = None
    ): SpectrumConfig =
      SpectrumConfig
        .builder
        .ifSome(bandwidth)(_.bandwidth(_))
        .ifSome(centerFrequency)(_.centerFrequency(_))
        .ifSome(polarization)(_.polarization(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagsMap] = None
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

    def trackingConfig(
      autotrack: Option[String] = None
    ): TrackingConfig =
      TrackingConfig
        .builder
        .ifSome(autotrack)(_.autotrack(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
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

    def updateConfigRequest(
      configData: Option[ConfigTypeData] = None,
      configId: Option[String] = None,
      configType: Option[String] = None,
      name: Option[String] = None
    ): UpdateConfigRequest =
      UpdateConfigRequest
        .builder
        .ifSome(configData)(_.configData(_))
        .ifSome(configId)(_.configId(_))
        .ifSome(configType)(_.configType(_))
        .ifSome(name)(_.name(_))
        .build

    def updateMissionProfileRequest(
      contactPostPassDurationSeconds: Option[Int] = None,
      contactPrePassDurationSeconds: Option[Int] = None,
      dataflowEdges: Option[List[DataflowEdge]] = None,
      minimumViableContactDurationSeconds: Option[Int] = None,
      missionProfileId: Option[String] = None,
      name: Option[String] = None,
      trackingConfigArn: Option[String] = None
    ): UpdateMissionProfileRequest =
      UpdateMissionProfileRequest
        .builder
        .ifSome(contactPostPassDurationSeconds)(_.contactPostPassDurationSeconds(_))
        .ifSome(contactPrePassDurationSeconds)(_.contactPrePassDurationSeconds(_))
        .ifSome(dataflowEdges)(_.dataflowEdges(_))
        .ifSome(minimumViableContactDurationSeconds)(_.minimumViableContactDurationSeconds(_))
        .ifSome(missionProfileId)(_.missionProfileId(_))
        .ifSome(name)(_.name(_))
        .ifSome(trackingConfigArn)(_.trackingConfigArn(_))
        .build

    def uplinkEchoConfig(
      antennaUplinkConfigArn: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UplinkEchoConfig =
      UplinkEchoConfig
        .builder
        .ifSome(antennaUplinkConfigArn)(_.antennaUplinkConfigArn(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def uplinkSpectrumConfig(
      centerFrequency: Option[Frequency] = None,
      polarization: Option[String] = None
    ): UplinkSpectrumConfig =
      UplinkSpectrumConfig
        .builder
        .ifSome(centerFrequency)(_.centerFrequency(_))
        .ifSome(polarization)(_.polarization(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
