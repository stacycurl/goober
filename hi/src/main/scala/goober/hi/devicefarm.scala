package goober.hi

import goober.free.devicefarm.DeviceFarmIO
import software.amazon.awssdk.services.devicefarm.model._


object devicefarm {
  import goober.free.{devicefarm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountSettings(
      awsAccountNumber: Option[String] = None,
      unmeteredDevices: Option[PurchasedDevicesMap] = None,
      unmeteredRemoteAccessDevices: Option[PurchasedDevicesMap] = None,
      maxJobTimeoutMinutes: Option[Int] = None,
      trialMinutes: Option[TrialMinutes] = None,
      maxSlots: Option[MaxSlotMap] = None,
      defaultJobTimeoutMinutes: Option[Int] = None,
      skipAppResign: Option[Boolean] = None
    ): AccountSettings =
      AccountSettings
        .builder
        .ifSome(awsAccountNumber)(_.awsAccountNumber(_))
        .ifSome(unmeteredDevices)(_.unmeteredDevices(_))
        .ifSome(unmeteredRemoteAccessDevices)(_.unmeteredRemoteAccessDevices(_))
        .ifSome(maxJobTimeoutMinutes)(_.maxJobTimeoutMinutes(_))
        .ifSome(trialMinutes)(_.trialMinutes(_))
        .ifSome(maxSlots)(_.maxSlots(_))
        .ifSome(defaultJobTimeoutMinutes)(_.defaultJobTimeoutMinutes(_))
        .ifSome(skipAppResign)(_.skipAppResign(_))
        .build

    def argumentException(
      message: Option[String] = None
    ): ArgumentException =
      ArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def artifact(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      extension: Option[String] = None,
      url: Option[String] = None
    ): Artifact =
      Artifact
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(extension)(_.extension(_))
        .ifSome(url)(_.url(_))
        .build

    def cPU(
      frequency: Option[String] = None,
      architecture: Option[String] = None,
      clock: Option[Double] = None
    ): CPU =
      CPU
        .builder
        .ifSome(frequency)(_.frequency(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(clock)(_.clock(_))
        .build

    def cannotDeleteException(
      message: Option[String] = None
    ): CannotDeleteException =
      CannotDeleteException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def counters(
      total: Option[Int] = None,
      passed: Option[Int] = None,
      failed: Option[Int] = None,
      warned: Option[Int] = None,
      errored: Option[Int] = None,
      stopped: Option[Int] = None,
      skipped: Option[Int] = None
    ): Counters =
      Counters
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(passed)(_.passed(_))
        .ifSome(failed)(_.failed(_))
        .ifSome(warned)(_.warned(_))
        .ifSome(errored)(_.errored(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(skipped)(_.skipped(_))
        .build

    def createDevicePoolRequest(
      projectArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      maxDevices: Option[Int] = None
    ): CreateDevicePoolRequest =
      CreateDevicePoolRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(maxDevices)(_.maxDevices(_))
        .build

    def createInstanceProfileRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      packageCleanup: Option[Boolean] = None,
      excludeAppPackagesFromCleanup: Option[List[String]] = None,
      rebootAfterUse: Option[Boolean] = None
    ): CreateInstanceProfileRequest =
      CreateInstanceProfileRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(packageCleanup)(_.packageCleanup(_))
        .ifSome(excludeAppPackagesFromCleanup)(_.excludeAppPackagesFromCleanup(_))
        .ifSome(rebootAfterUse)(_.rebootAfterUse(_))
        .build

    def createNetworkProfileRequest(
      projectArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      uplinkBandwidthBits: Option[Long] = None,
      downlinkBandwidthBits: Option[Long] = None,
      uplinkDelayMs: Option[Long] = None,
      downlinkDelayMs: Option[Long] = None,
      uplinkJitterMs: Option[Long] = None,
      downlinkJitterMs: Option[Long] = None,
      uplinkLossPercent: Option[Int] = None,
      downlinkLossPercent: Option[Int] = None
    ): CreateNetworkProfileRequest =
      CreateNetworkProfileRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uplinkBandwidthBits)(_.uplinkBandwidthBits(_))
        .ifSome(downlinkBandwidthBits)(_.downlinkBandwidthBits(_))
        .ifSome(uplinkDelayMs)(_.uplinkDelayMs(_))
        .ifSome(downlinkDelayMs)(_.downlinkDelayMs(_))
        .ifSome(uplinkJitterMs)(_.uplinkJitterMs(_))
        .ifSome(downlinkJitterMs)(_.downlinkJitterMs(_))
        .ifSome(uplinkLossPercent)(_.uplinkLossPercent(_))
        .ifSome(downlinkLossPercent)(_.downlinkLossPercent(_))
        .build

    def createProjectRequest(
      name: Option[String] = None,
      defaultJobTimeoutMinutes: Option[Int] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(defaultJobTimeoutMinutes)(_.defaultJobTimeoutMinutes(_))
        .build

    def createRemoteAccessSessionConfiguration(
      billingMethod: Option[String] = None,
      vpceConfigurationArns: Option[List[AmazonResourceName]] = None
    ): CreateRemoteAccessSessionConfiguration =
      CreateRemoteAccessSessionConfiguration
        .builder
        .ifSome(billingMethod)(_.billingMethod(_))
        .ifSome(vpceConfigurationArns)(_.vpceConfigurationArns(_))
        .build

    def createRemoteAccessSessionRequest(
      projectArn: Option[String] = None,
      deviceArn: Option[String] = None,
      instanceArn: Option[String] = None,
      sshPublicKey: Option[String] = None,
      remoteDebugEnabled: Option[Boolean] = None,
      remoteRecordEnabled: Option[Boolean] = None,
      remoteRecordAppArn: Option[String] = None,
      name: Option[String] = None,
      clientId: Option[String] = None,
      configuration: Option[CreateRemoteAccessSessionConfiguration] = None,
      interactionMode: Option[String] = None,
      skipAppResign: Option[Boolean] = None
    ): CreateRemoteAccessSessionRequest =
      CreateRemoteAccessSessionRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(sshPublicKey)(_.sshPublicKey(_))
        .ifSome(remoteDebugEnabled)(_.remoteDebugEnabled(_))
        .ifSome(remoteRecordEnabled)(_.remoteRecordEnabled(_))
        .ifSome(remoteRecordAppArn)(_.remoteRecordAppArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(interactionMode)(_.interactionMode(_))
        .ifSome(skipAppResign)(_.skipAppResign(_))
        .build

    def createTestGridProjectRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      vpcConfig: Option[TestGridVpcConfig] = None
    ): CreateTestGridProjectRequest =
      CreateTestGridProjectRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def createTestGridUrlRequest(
      projectArn: Option[String] = None,
      expiresInSeconds: Option[Int] = None
    ): CreateTestGridUrlRequest =
      CreateTestGridUrlRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(expiresInSeconds)(_.expiresInSeconds(_))
        .build

    def createUploadRequest(
      projectArn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      contentType: Option[String] = None
    ): CreateUploadRequest =
      CreateUploadRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(contentType)(_.contentType(_))
        .build

    def createVPCEConfigurationRequest(
      vpceConfigurationName: Option[String] = None,
      vpceServiceName: Option[String] = None,
      serviceDnsName: Option[String] = None,
      vpceConfigurationDescription: Option[String] = None
    ): CreateVPCEConfigurationRequest =
      CreateVPCEConfigurationRequest
        .builder
        .ifSome(vpceConfigurationName)(_.vpceConfigurationName(_))
        .ifSome(vpceServiceName)(_.vpceServiceName(_))
        .ifSome(serviceDnsName)(_.serviceDnsName(_))
        .ifSome(vpceConfigurationDescription)(_.vpceConfigurationDescription(_))
        .build

    def customerArtifactPaths(
      iosPaths: Option[List[String]] = None,
      androidPaths: Option[List[String]] = None,
      deviceHostPaths: Option[List[String]] = None
    ): CustomerArtifactPaths =
      CustomerArtifactPaths
        .builder
        .ifSome(iosPaths)(_.iosPaths(_))
        .ifSome(androidPaths)(_.androidPaths(_))
        .ifSome(deviceHostPaths)(_.deviceHostPaths(_))
        .build

    def deleteDevicePoolRequest(
      arn: Option[String] = None
    ): DeleteDevicePoolRequest =
      DeleteDevicePoolRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteInstanceProfileRequest(
      arn: Option[String] = None
    ): DeleteInstanceProfileRequest =
      DeleteInstanceProfileRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteNetworkProfileRequest(
      arn: Option[String] = None
    ): DeleteNetworkProfileRequest =
      DeleteNetworkProfileRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteProjectRequest(
      arn: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteRemoteAccessSessionRequest(
      arn: Option[String] = None
    ): DeleteRemoteAccessSessionRequest =
      DeleteRemoteAccessSessionRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteRunRequest(
      arn: Option[String] = None
    ): DeleteRunRequest =
      DeleteRunRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteTestGridProjectRequest(
      projectArn: Option[String] = None
    ): DeleteTestGridProjectRequest =
      DeleteTestGridProjectRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def deleteUploadRequest(
      arn: Option[String] = None
    ): DeleteUploadRequest =
      DeleteUploadRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteVPCEConfigurationRequest(
      arn: Option[String] = None
    ): DeleteVPCEConfigurationRequest =
      DeleteVPCEConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def device(
      arn: Option[String] = None,
      name: Option[String] = None,
      manufacturer: Option[String] = None,
      model: Option[String] = None,
      modelId: Option[String] = None,
      formFactor: Option[String] = None,
      platform: Option[String] = None,
      os: Option[String] = None,
      cpu: Option[CPU] = None,
      resolution: Option[Resolution] = None,
      heapSize: Option[Long] = None,
      memory: Option[Long] = None,
      image: Option[String] = None,
      carrier: Option[String] = None,
      radio: Option[String] = None,
      remoteAccessEnabled: Option[Boolean] = None,
      remoteDebugEnabled: Option[Boolean] = None,
      fleetType: Option[String] = None,
      fleetName: Option[String] = None,
      instances: Option[List[DeviceInstance]] = None,
      availability: Option[String] = None
    ): Device =
      Device
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(manufacturer)(_.manufacturer(_))
        .ifSome(model)(_.model(_))
        .ifSome(modelId)(_.modelId(_))
        .ifSome(formFactor)(_.formFactor(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(os)(_.os(_))
        .ifSome(cpu)(_.cpu(_))
        .ifSome(resolution)(_.resolution(_))
        .ifSome(heapSize)(_.heapSize(_))
        .ifSome(memory)(_.memory(_))
        .ifSome(image)(_.image(_))
        .ifSome(carrier)(_.carrier(_))
        .ifSome(radio)(_.radio(_))
        .ifSome(remoteAccessEnabled)(_.remoteAccessEnabled(_))
        .ifSome(remoteDebugEnabled)(_.remoteDebugEnabled(_))
        .ifSome(fleetType)(_.fleetType(_))
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(availability)(_.availability(_))
        .build

    def deviceFilter(
      attribute: Option[String] = None,
      operator: Option[String] = None,
      values: Option[List[String]] = None
    ): DeviceFilter =
      DeviceFilter
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(values)(_.values(_))
        .build

    def deviceInstance(
      arn: Option[String] = None,
      deviceArn: Option[String] = None,
      labels: Option[List[String]] = None,
      status: Option[String] = None,
      udid: Option[String] = None,
      instanceProfile: Option[InstanceProfile] = None
    ): DeviceInstance =
      DeviceInstance
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(status)(_.status(_))
        .ifSome(udid)(_.udid(_))
        .ifSome(instanceProfile)(_.instanceProfile(_))
        .build

    def deviceMinutes(
      total: Option[Double] = None,
      metered: Option[Double] = None,
      unmetered: Option[Double] = None
    ): DeviceMinutes =
      DeviceMinutes
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(metered)(_.metered(_))
        .ifSome(unmetered)(_.unmetered(_))
        .build

    def devicePool(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      rules: Option[List[Rule]] = None,
      maxDevices: Option[Int] = None
    ): DevicePool =
      DevicePool
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(maxDevices)(_.maxDevices(_))
        .build

    def deviceSelectionConfiguration(
      filters: Option[List[DeviceFilter]] = None,
      maxDevices: Option[Int] = None
    ): DeviceSelectionConfiguration =
      DeviceSelectionConfiguration
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxDevices)(_.maxDevices(_))
        .build

    def executionConfiguration(
      jobTimeoutMinutes: Option[Int] = None,
      accountsCleanup: Option[Boolean] = None,
      appPackagesCleanup: Option[Boolean] = None,
      videoCapture: Option[Boolean] = None,
      skipAppResign: Option[Boolean] = None
    ): ExecutionConfiguration =
      ExecutionConfiguration
        .builder
        .ifSome(jobTimeoutMinutes)(_.jobTimeoutMinutes(_))
        .ifSome(accountsCleanup)(_.accountsCleanup(_))
        .ifSome(appPackagesCleanup)(_.appPackagesCleanup(_))
        .ifSome(videoCapture)(_.videoCapture(_))
        .ifSome(skipAppResign)(_.skipAppResign(_))
        .build

    def getAccountSettingsRequest(

    ): GetAccountSettingsRequest =
      GetAccountSettingsRequest
        .builder

        .build

    def getDeviceInstanceRequest(
      arn: Option[String] = None
    ): GetDeviceInstanceRequest =
      GetDeviceInstanceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getDevicePoolCompatibilityRequest(
      devicePoolArn: Option[String] = None,
      appArn: Option[String] = None,
      testType: Option[String] = None,
      test: Option[ScheduleRunTest] = None,
      configuration: Option[ScheduleRunConfiguration] = None
    ): GetDevicePoolCompatibilityRequest =
      GetDevicePoolCompatibilityRequest
        .builder
        .ifSome(devicePoolArn)(_.devicePoolArn(_))
        .ifSome(appArn)(_.appArn(_))
        .ifSome(testType)(_.testType(_))
        .ifSome(test)(_.test(_))
        .ifSome(configuration)(_.configuration(_))
        .build

    def getDevicePoolRequest(
      arn: Option[String] = None
    ): GetDevicePoolRequest =
      GetDevicePoolRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getDeviceRequest(
      arn: Option[String] = None
    ): GetDeviceRequest =
      GetDeviceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getInstanceProfileRequest(
      arn: Option[String] = None
    ): GetInstanceProfileRequest =
      GetInstanceProfileRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getJobRequest(
      arn: Option[String] = None
    ): GetJobRequest =
      GetJobRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getNetworkProfileRequest(
      arn: Option[String] = None
    ): GetNetworkProfileRequest =
      GetNetworkProfileRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getOfferingStatusRequest(
      nextToken: Option[String] = None
    ): GetOfferingStatusRequest =
      GetOfferingStatusRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getProjectRequest(
      arn: Option[String] = None
    ): GetProjectRequest =
      GetProjectRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getRemoteAccessSessionRequest(
      arn: Option[String] = None
    ): GetRemoteAccessSessionRequest =
      GetRemoteAccessSessionRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getRunRequest(
      arn: Option[String] = None
    ): GetRunRequest =
      GetRunRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getSuiteRequest(
      arn: Option[String] = None
    ): GetSuiteRequest =
      GetSuiteRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getTestGridProjectRequest(
      projectArn: Option[String] = None
    ): GetTestGridProjectRequest =
      GetTestGridProjectRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def getTestGridSessionRequest(
      projectArn: Option[String] = None,
      sessionId: Option[String] = None,
      sessionArn: Option[String] = None
    ): GetTestGridSessionRequest =
      GetTestGridSessionRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(sessionArn)(_.sessionArn(_))
        .build

    def getTestRequest(
      arn: Option[String] = None
    ): GetTestRequest =
      GetTestRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getUploadRequest(
      arn: Option[String] = None
    ): GetUploadRequest =
      GetUploadRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getVPCEConfigurationRequest(
      arn: Option[String] = None
    ): GetVPCEConfigurationRequest =
      GetVPCEConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def idempotencyException(
      message: Option[String] = None
    ): IdempotencyException =
      IdempotencyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def incompatibilityMessage(
      message: Option[String] = None,
      `type`: Option[String] = None
    ): IncompatibilityMessage =
      IncompatibilityMessage
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def installToRemoteAccessSessionRequest(
      remoteAccessSessionArn: Option[String] = None,
      appArn: Option[String] = None
    ): InstallToRemoteAccessSessionRequest =
      InstallToRemoteAccessSessionRequest
        .builder
        .ifSome(remoteAccessSessionArn)(_.remoteAccessSessionArn(_))
        .ifSome(appArn)(_.appArn(_))
        .build

    def instanceProfile(
      arn: Option[String] = None,
      packageCleanup: Option[Boolean] = None,
      excludeAppPackagesFromCleanup: Option[List[String]] = None,
      rebootAfterUse: Option[Boolean] = None,
      name: Option[String] = None,
      description: Option[String] = None
    ): InstanceProfile =
      InstanceProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(packageCleanup)(_.packageCleanup(_))
        .ifSome(excludeAppPackagesFromCleanup)(_.excludeAppPackagesFromCleanup(_))
        .ifSome(rebootAfterUse)(_.rebootAfterUse(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidOperationException(
      message: Option[String] = None
    ): InvalidOperationException =
      InvalidOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def job(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      created: Option[DateTime] = None,
      status: Option[String] = None,
      result: Option[String] = None,
      started: Option[DateTime] = None,
      stopped: Option[DateTime] = None,
      counters: Option[Counters] = None,
      message: Option[String] = None,
      device: Option[Device] = None,
      instanceArn: Option[String] = None,
      deviceMinutes: Option[DeviceMinutes] = None,
      videoEndpoint: Option[String] = None,
      videoCapture: Option[Boolean] = None
    ): Job =
      Job
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(created)(_.created(_))
        .ifSome(status)(_.status(_))
        .ifSome(result)(_.result(_))
        .ifSome(started)(_.started(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(counters)(_.counters(_))
        .ifSome(message)(_.message(_))
        .ifSome(device)(_.device(_))
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(deviceMinutes)(_.deviceMinutes(_))
        .ifSome(videoEndpoint)(_.videoEndpoint(_))
        .ifSome(videoCapture)(_.videoCapture(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listArtifactsRequest(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      nextToken: Option[String] = None
    ): ListArtifactsRequest =
      ListArtifactsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeviceInstancesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDeviceInstancesRequest =
      ListDeviceInstancesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevicePoolsRequest(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      nextToken: Option[String] = None
    ): ListDevicePoolsRequest =
      ListDevicePoolsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevicesRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None,
      filters: Option[List[DeviceFilter]] = None
    ): ListDevicesRequest =
      ListDevicesRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listInstanceProfilesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInstanceProfilesRequest =
      ListInstanceProfilesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listNetworkProfilesRequest(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      nextToken: Option[String] = None
    ): ListNetworkProfilesRequest =
      ListNetworkProfilesRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOfferingPromotionsRequest(
      nextToken: Option[String] = None
    ): ListOfferingPromotionsRequest =
      ListOfferingPromotionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOfferingTransactionsRequest(
      nextToken: Option[String] = None
    ): ListOfferingTransactionsRequest =
      ListOfferingTransactionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOfferingsRequest(
      nextToken: Option[String] = None
    ): ListOfferingsRequest =
      ListOfferingsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListProjectsRequest =
      ListProjectsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRemoteAccessSessionsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListRemoteAccessSessionsRequest =
      ListRemoteAccessSessionsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRunsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListRunsRequest =
      ListRunsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSamplesRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListSamplesRequest =
      ListSamplesRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSuitesRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListSuitesRequest =
      ListSuitesRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listTestGridProjectsRequest(
      maxResult: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTestGridProjectsRequest =
      ListTestGridProjectsRequest
        .builder
        .ifSome(maxResult)(_.maxResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTestGridSessionActionsRequest(
      sessionArn: Option[String] = None,
      maxResult: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTestGridSessionActionsRequest =
      ListTestGridSessionActionsRequest
        .builder
        .ifSome(sessionArn)(_.sessionArn(_))
        .ifSome(maxResult)(_.maxResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTestGridSessionArtifactsRequest(
      sessionArn: Option[String] = None,
      `type`: Option[String] = None,
      maxResult: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTestGridSessionArtifactsRequest =
      ListTestGridSessionArtifactsRequest
        .builder
        .ifSome(sessionArn)(_.sessionArn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(maxResult)(_.maxResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTestGridSessionsRequest(
      projectArn: Option[String] = None,
      status: Option[String] = None,
      creationTimeAfter: Option[DateTime] = None,
      creationTimeBefore: Option[DateTime] = None,
      endTimeAfter: Option[DateTime] = None,
      endTimeBefore: Option[DateTime] = None,
      maxResult: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTestGridSessionsRequest =
      ListTestGridSessionsRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(endTimeAfter)(_.endTimeAfter(_))
        .ifSome(endTimeBefore)(_.endTimeBefore(_))
        .ifSome(maxResult)(_.maxResult(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTestsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTestsRequest =
      ListTestsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUniqueProblemsRequest(
      arn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListUniqueProblemsRequest =
      ListUniqueProblemsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUploadsRequest(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      nextToken: Option[String] = None
    ): ListUploadsRequest =
      ListUploadsRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listVPCEConfigurationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListVPCEConfigurationsRequest =
      ListVPCEConfigurationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def location(
      latitude: Option[Double] = None,
      longitude: Option[Double] = None
    ): Location =
      Location
        .builder
        .ifSome(latitude)(_.latitude(_))
        .ifSome(longitude)(_.longitude(_))
        .build

    def monetaryAmount(
      amount: Option[Double] = None,
      currencyCode: Option[String] = None
    ): MonetaryAmount =
      MonetaryAmount
        .builder
        .ifSome(amount)(_.amount(_))
        .ifSome(currencyCode)(_.currencyCode(_))
        .build

    def networkProfile(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      uplinkBandwidthBits: Option[Long] = None,
      downlinkBandwidthBits: Option[Long] = None,
      uplinkDelayMs: Option[Long] = None,
      downlinkDelayMs: Option[Long] = None,
      uplinkJitterMs: Option[Long] = None,
      downlinkJitterMs: Option[Long] = None,
      uplinkLossPercent: Option[Int] = None,
      downlinkLossPercent: Option[Int] = None
    ): NetworkProfile =
      NetworkProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uplinkBandwidthBits)(_.uplinkBandwidthBits(_))
        .ifSome(downlinkBandwidthBits)(_.downlinkBandwidthBits(_))
        .ifSome(uplinkDelayMs)(_.uplinkDelayMs(_))
        .ifSome(downlinkDelayMs)(_.downlinkDelayMs(_))
        .ifSome(uplinkJitterMs)(_.uplinkJitterMs(_))
        .ifSome(downlinkJitterMs)(_.downlinkJitterMs(_))
        .ifSome(uplinkLossPercent)(_.uplinkLossPercent(_))
        .ifSome(downlinkLossPercent)(_.downlinkLossPercent(_))
        .build

    def notEligibleException(
      message: Option[String] = None
    ): NotEligibleException =
      NotEligibleException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def offering(
      id: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      platform: Option[String] = None,
      recurringCharges: Option[List[RecurringCharge]] = None
    ): Offering =
      Offering
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(recurringCharges)(_.recurringCharges(_))
        .build

    def offeringPromotion(
      id: Option[String] = None,
      description: Option[String] = None
    ): OfferingPromotion =
      OfferingPromotion
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(description)(_.description(_))
        .build

    def offeringStatus(
      `type`: Option[String] = None,
      offering: Option[Offering] = None,
      quantity: Option[Int] = None,
      effectiveOn: Option[DateTime] = None
    ): OfferingStatus =
      OfferingStatus
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(offering)(_.offering(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(effectiveOn)(_.effectiveOn(_))
        .build

    def offeringTransaction(
      offeringStatus: Option[OfferingStatus] = None,
      transactionId: Option[String] = None,
      offeringPromotionId: Option[String] = None,
      createdOn: Option[DateTime] = None,
      cost: Option[MonetaryAmount] = None
    ): OfferingTransaction =
      OfferingTransaction
        .builder
        .ifSome(offeringStatus)(_.offeringStatus(_))
        .ifSome(transactionId)(_.transactionId(_))
        .ifSome(offeringPromotionId)(_.offeringPromotionId(_))
        .ifSome(createdOn)(_.createdOn(_))
        .ifSome(cost)(_.cost(_))
        .build

    def problem(
      run: Option[ProblemDetail] = None,
      job: Option[ProblemDetail] = None,
      suite: Option[ProblemDetail] = None,
      test: Option[ProblemDetail] = None,
      device: Option[Device] = None,
      result: Option[String] = None,
      message: Option[String] = None
    ): Problem =
      Problem
        .builder
        .ifSome(run)(_.run(_))
        .ifSome(job)(_.job(_))
        .ifSome(suite)(_.suite(_))
        .ifSome(test)(_.test(_))
        .ifSome(device)(_.device(_))
        .ifSome(result)(_.result(_))
        .ifSome(message)(_.message(_))
        .build

    def problemDetail(
      arn: Option[String] = None,
      name: Option[String] = None
    ): ProblemDetail =
      ProblemDetail
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .build

    def project(
      arn: Option[String] = None,
      name: Option[String] = None,
      defaultJobTimeoutMinutes: Option[Int] = None,
      created: Option[DateTime] = None
    ): Project =
      Project
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(defaultJobTimeoutMinutes)(_.defaultJobTimeoutMinutes(_))
        .ifSome(created)(_.created(_))
        .build

    def purchaseOfferingRequest(
      offeringId: Option[String] = None,
      quantity: Option[Int] = None,
      offeringPromotionId: Option[String] = None
    ): PurchaseOfferingRequest =
      PurchaseOfferingRequest
        .builder
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(quantity)(_.quantity(_))
        .ifSome(offeringPromotionId)(_.offeringPromotionId(_))
        .build

    def radios(
      wifi: Option[Boolean] = None,
      bluetooth: Option[Boolean] = None,
      nfc: Option[Boolean] = None,
      gps: Option[Boolean] = None
    ): Radios =
      Radios
        .builder
        .ifSome(wifi)(_.wifi(_))
        .ifSome(bluetooth)(_.bluetooth(_))
        .ifSome(nfc)(_.nfc(_))
        .ifSome(gps)(_.gps(_))
        .build

    def recurringCharge(
      cost: Option[MonetaryAmount] = None,
      frequency: Option[String] = None
    ): RecurringCharge =
      RecurringCharge
        .builder
        .ifSome(cost)(_.cost(_))
        .ifSome(frequency)(_.frequency(_))
        .build

    def remoteAccessSession(
      arn: Option[String] = None,
      name: Option[String] = None,
      created: Option[DateTime] = None,
      status: Option[String] = None,
      result: Option[String] = None,
      message: Option[String] = None,
      started: Option[DateTime] = None,
      stopped: Option[DateTime] = None,
      device: Option[Device] = None,
      instanceArn: Option[String] = None,
      remoteDebugEnabled: Option[Boolean] = None,
      remoteRecordEnabled: Option[Boolean] = None,
      remoteRecordAppArn: Option[String] = None,
      hostAddress: Option[String] = None,
      clientId: Option[String] = None,
      billingMethod: Option[String] = None,
      deviceMinutes: Option[DeviceMinutes] = None,
      endpoint: Option[String] = None,
      deviceUdid: Option[String] = None,
      interactionMode: Option[String] = None,
      skipAppResign: Option[Boolean] = None
    ): RemoteAccessSession =
      RemoteAccessSession
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(created)(_.created(_))
        .ifSome(status)(_.status(_))
        .ifSome(result)(_.result(_))
        .ifSome(message)(_.message(_))
        .ifSome(started)(_.started(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(device)(_.device(_))
        .ifSome(instanceArn)(_.instanceArn(_))
        .ifSome(remoteDebugEnabled)(_.remoteDebugEnabled(_))
        .ifSome(remoteRecordEnabled)(_.remoteRecordEnabled(_))
        .ifSome(remoteRecordAppArn)(_.remoteRecordAppArn(_))
        .ifSome(hostAddress)(_.hostAddress(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(billingMethod)(_.billingMethod(_))
        .ifSome(deviceMinutes)(_.deviceMinutes(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(deviceUdid)(_.deviceUdid(_))
        .ifSome(interactionMode)(_.interactionMode(_))
        .ifSome(skipAppResign)(_.skipAppResign(_))
        .build

    def renewOfferingRequest(
      offeringId: Option[String] = None,
      quantity: Option[Int] = None
    ): RenewOfferingRequest =
      RenewOfferingRequest
        .builder
        .ifSome(offeringId)(_.offeringId(_))
        .ifSome(quantity)(_.quantity(_))
        .build

    def resolution(
      width: Option[Int] = None,
      height: Option[Int] = None
    ): Resolution =
      Resolution
        .builder
        .ifSome(width)(_.width(_))
        .ifSome(height)(_.height(_))
        .build

    def rule(
      attribute: Option[String] = None,
      operator: Option[String] = None,
      value: Option[String] = None
    ): Rule =
      Rule
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(value)(_.value(_))
        .build

    def run(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      platform: Option[String] = None,
      created: Option[DateTime] = None,
      status: Option[String] = None,
      result: Option[String] = None,
      started: Option[DateTime] = None,
      stopped: Option[DateTime] = None,
      counters: Option[Counters] = None,
      message: Option[String] = None,
      totalJobs: Option[Int] = None,
      completedJobs: Option[Int] = None,
      billingMethod: Option[String] = None,
      deviceMinutes: Option[DeviceMinutes] = None,
      networkProfile: Option[NetworkProfile] = None,
      parsingResultUrl: Option[String] = None,
      resultCode: Option[String] = None,
      seed: Option[Int] = None,
      appUpload: Option[String] = None,
      eventCount: Option[Int] = None,
      jobTimeoutMinutes: Option[Int] = None,
      devicePoolArn: Option[String] = None,
      locale: Option[String] = None,
      radios: Option[Radios] = None,
      location: Option[Location] = None,
      customerArtifactPaths: Option[CustomerArtifactPaths] = None,
      webUrl: Option[String] = None,
      skipAppResign: Option[Boolean] = None,
      testSpecArn: Option[String] = None,
      deviceSelectionResult: Option[DeviceSelectionResult] = None
    ): Run =
      Run
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(created)(_.created(_))
        .ifSome(status)(_.status(_))
        .ifSome(result)(_.result(_))
        .ifSome(started)(_.started(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(counters)(_.counters(_))
        .ifSome(message)(_.message(_))
        .ifSome(totalJobs)(_.totalJobs(_))
        .ifSome(completedJobs)(_.completedJobs(_))
        .ifSome(billingMethod)(_.billingMethod(_))
        .ifSome(deviceMinutes)(_.deviceMinutes(_))
        .ifSome(networkProfile)(_.networkProfile(_))
        .ifSome(parsingResultUrl)(_.parsingResultUrl(_))
        .ifSome(resultCode)(_.resultCode(_))
        .ifSome(seed)(_.seed(_))
        .ifSome(appUpload)(_.appUpload(_))
        .ifSome(eventCount)(_.eventCount(_))
        .ifSome(jobTimeoutMinutes)(_.jobTimeoutMinutes(_))
        .ifSome(devicePoolArn)(_.devicePoolArn(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(radios)(_.radios(_))
        .ifSome(location)(_.location(_))
        .ifSome(customerArtifactPaths)(_.customerArtifactPaths(_))
        .ifSome(webUrl)(_.webUrl(_))
        .ifSome(skipAppResign)(_.skipAppResign(_))
        .ifSome(testSpecArn)(_.testSpecArn(_))
        .ifSome(deviceSelectionResult)(_.deviceSelectionResult(_))
        .build

    def sample(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      url: Option[String] = None
    ): Sample =
      Sample
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(url)(_.url(_))
        .build

    def scheduleRunConfiguration(
      extraDataPackageArn: Option[String] = None,
      networkProfileArn: Option[String] = None,
      locale: Option[String] = None,
      location: Option[Location] = None,
      vpceConfigurationArns: Option[List[AmazonResourceName]] = None,
      customerArtifactPaths: Option[CustomerArtifactPaths] = None,
      radios: Option[Radios] = None,
      auxiliaryApps: Option[List[AmazonResourceName]] = None,
      billingMethod: Option[String] = None
    ): ScheduleRunConfiguration =
      ScheduleRunConfiguration
        .builder
        .ifSome(extraDataPackageArn)(_.extraDataPackageArn(_))
        .ifSome(networkProfileArn)(_.networkProfileArn(_))
        .ifSome(locale)(_.locale(_))
        .ifSome(location)(_.location(_))
        .ifSome(vpceConfigurationArns)(_.vpceConfigurationArns(_))
        .ifSome(customerArtifactPaths)(_.customerArtifactPaths(_))
        .ifSome(radios)(_.radios(_))
        .ifSome(auxiliaryApps)(_.auxiliaryApps(_))
        .ifSome(billingMethod)(_.billingMethod(_))
        .build

    def scheduleRunRequest(
      projectArn: Option[String] = None,
      appArn: Option[String] = None,
      devicePoolArn: Option[String] = None,
      deviceSelectionConfiguration: Option[DeviceSelectionConfiguration] = None,
      name: Option[String] = None,
      test: Option[ScheduleRunTest] = None,
      configuration: Option[ScheduleRunConfiguration] = None,
      executionConfiguration: Option[ExecutionConfiguration] = None
    ): ScheduleRunRequest =
      ScheduleRunRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(appArn)(_.appArn(_))
        .ifSome(devicePoolArn)(_.devicePoolArn(_))
        .ifSome(deviceSelectionConfiguration)(_.deviceSelectionConfiguration(_))
        .ifSome(name)(_.name(_))
        .ifSome(test)(_.test(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(executionConfiguration)(_.executionConfiguration(_))
        .build

    def scheduleRunTest(
      `type`: Option[String] = None,
      testPackageArn: Option[String] = None,
      testSpecArn: Option[String] = None,
      filter: Option[String] = None,
      parameters: Option[TestParameters] = None
    ): ScheduleRunTest =
      ScheduleRunTest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(testPackageArn)(_.testPackageArn(_))
        .ifSome(testSpecArn)(_.testSpecArn(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def serviceAccountException(
      message: Option[String] = None
    ): ServiceAccountException =
      ServiceAccountException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def stopJobRequest(
      arn: Option[String] = None
    ): StopJobRequest =
      StopJobRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def stopRemoteAccessSessionRequest(
      arn: Option[String] = None
    ): StopRemoteAccessSessionRequest =
      StopRemoteAccessSessionRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def stopRunRequest(
      arn: Option[String] = None
    ): StopRunRequest =
      StopRunRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def suite(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      created: Option[DateTime] = None,
      status: Option[String] = None,
      result: Option[String] = None,
      started: Option[DateTime] = None,
      stopped: Option[DateTime] = None,
      counters: Option[Counters] = None,
      message: Option[String] = None,
      deviceMinutes: Option[DeviceMinutes] = None
    ): Suite =
      Suite
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(created)(_.created(_))
        .ifSome(status)(_.status(_))
        .ifSome(result)(_.result(_))
        .ifSome(started)(_.started(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(counters)(_.counters(_))
        .ifSome(message)(_.message(_))
        .ifSome(deviceMinutes)(_.deviceMinutes(_))
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

    def tagOperationException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TagOperationException =
      TagOperationException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def tagPolicyException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TagPolicyException =
      TagPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def tagResourceRequest(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def test(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      created: Option[DateTime] = None,
      status: Option[String] = None,
      result: Option[String] = None,
      started: Option[DateTime] = None,
      stopped: Option[DateTime] = None,
      counters: Option[Counters] = None,
      message: Option[String] = None,
      deviceMinutes: Option[DeviceMinutes] = None
    ): Test =
      Test
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(created)(_.created(_))
        .ifSome(status)(_.status(_))
        .ifSome(result)(_.result(_))
        .ifSome(started)(_.started(_))
        .ifSome(stopped)(_.stopped(_))
        .ifSome(counters)(_.counters(_))
        .ifSome(message)(_.message(_))
        .ifSome(deviceMinutes)(_.deviceMinutes(_))
        .build

    def testGridProject(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      vpcConfig: Option[TestGridVpcConfig] = None,
      created: Option[DateTime] = None
    ): TestGridProject =
      TestGridProject
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(created)(_.created(_))
        .build

    def testGridSession(
      arn: Option[String] = None,
      status: Option[String] = None,
      created: Option[DateTime] = None,
      ended: Option[DateTime] = None,
      billingMinutes: Option[Double] = None,
      seleniumProperties: Option[String] = None
    ): TestGridSession =
      TestGridSession
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(created)(_.created(_))
        .ifSome(ended)(_.ended(_))
        .ifSome(billingMinutes)(_.billingMinutes(_))
        .ifSome(seleniumProperties)(_.seleniumProperties(_))
        .build

    def testGridSessionAction(
      action: Option[String] = None,
      started: Option[DateTime] = None,
      duration: Option[Long] = None,
      statusCode: Option[String] = None,
      requestMethod: Option[String] = None
    ): TestGridSessionAction =
      TestGridSessionAction
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(started)(_.started(_))
        .ifSome(duration)(_.duration(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(requestMethod)(_.requestMethod(_))
        .build

    def testGridSessionArtifact(
      filename: Option[String] = None,
      `type`: Option[String] = None,
      url: Option[String] = None
    ): TestGridSessionArtifact =
      TestGridSessionArtifact
        .builder
        .ifSome(filename)(_.filename(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(url)(_.url(_))
        .build

    def testGridVpcConfig(
      securityGroupIds: Option[List[NonEmptyString]] = None,
      subnetIds: Option[List[NonEmptyString]] = None,
      vpcId: Option[String] = None
    ): TestGridVpcConfig =
      TestGridVpcConfig
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None,
      resourceName: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceName)(_.resourceName(_))
        .build

    def trialMinutes(
      total: Option[Double] = None,
      remaining: Option[Double] = None
    ): TrialMinutes =
      TrialMinutes
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(remaining)(_.remaining(_))
        .build

    def uniqueProblem(
      message: Option[String] = None,
      problems: Option[List[Problem]] = None
    ): UniqueProblem =
      UniqueProblem
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(problems)(_.problems(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateDeviceInstanceRequest(
      arn: Option[String] = None,
      profileArn: Option[String] = None,
      labels: Option[List[String]] = None
    ): UpdateDeviceInstanceRequest =
      UpdateDeviceInstanceRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(profileArn)(_.profileArn(_))
        .ifSome(labels)(_.labels(_))
        .build

    def updateDevicePoolRequest(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      rules: Option[List[Rule]] = None,
      maxDevices: Option[Int] = None,
      clearMaxDevices: Option[Boolean] = None
    ): UpdateDevicePoolRequest =
      UpdateDevicePoolRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(maxDevices)(_.maxDevices(_))
        .ifSome(clearMaxDevices)(_.clearMaxDevices(_))
        .build

    def updateInstanceProfileRequest(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      packageCleanup: Option[Boolean] = None,
      excludeAppPackagesFromCleanup: Option[List[String]] = None,
      rebootAfterUse: Option[Boolean] = None
    ): UpdateInstanceProfileRequest =
      UpdateInstanceProfileRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(packageCleanup)(_.packageCleanup(_))
        .ifSome(excludeAppPackagesFromCleanup)(_.excludeAppPackagesFromCleanup(_))
        .ifSome(rebootAfterUse)(_.rebootAfterUse(_))
        .build

    def updateNetworkProfileRequest(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      `type`: Option[String] = None,
      uplinkBandwidthBits: Option[Long] = None,
      downlinkBandwidthBits: Option[Long] = None,
      uplinkDelayMs: Option[Long] = None,
      downlinkDelayMs: Option[Long] = None,
      uplinkJitterMs: Option[Long] = None,
      downlinkJitterMs: Option[Long] = None,
      uplinkLossPercent: Option[Int] = None,
      downlinkLossPercent: Option[Int] = None
    ): UpdateNetworkProfileRequest =
      UpdateNetworkProfileRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(uplinkBandwidthBits)(_.uplinkBandwidthBits(_))
        .ifSome(downlinkBandwidthBits)(_.downlinkBandwidthBits(_))
        .ifSome(uplinkDelayMs)(_.uplinkDelayMs(_))
        .ifSome(downlinkDelayMs)(_.downlinkDelayMs(_))
        .ifSome(uplinkJitterMs)(_.uplinkJitterMs(_))
        .ifSome(downlinkJitterMs)(_.downlinkJitterMs(_))
        .ifSome(uplinkLossPercent)(_.uplinkLossPercent(_))
        .ifSome(downlinkLossPercent)(_.downlinkLossPercent(_))
        .build

    def updateProjectRequest(
      arn: Option[String] = None,
      name: Option[String] = None,
      defaultJobTimeoutMinutes: Option[Int] = None
    ): UpdateProjectRequest =
      UpdateProjectRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(defaultJobTimeoutMinutes)(_.defaultJobTimeoutMinutes(_))
        .build

    def updateTestGridProjectRequest(
      projectArn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      vpcConfig: Option[TestGridVpcConfig] = None
    ): UpdateTestGridProjectRequest =
      UpdateTestGridProjectRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def updateUploadRequest(
      arn: Option[String] = None,
      name: Option[String] = None,
      contentType: Option[String] = None,
      editContent: Option[Boolean] = None
    ): UpdateUploadRequest =
      UpdateUploadRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(editContent)(_.editContent(_))
        .build

    def updateVPCEConfigurationRequest(
      arn: Option[String] = None,
      vpceConfigurationName: Option[String] = None,
      vpceServiceName: Option[String] = None,
      serviceDnsName: Option[String] = None,
      vpceConfigurationDescription: Option[String] = None
    ): UpdateVPCEConfigurationRequest =
      UpdateVPCEConfigurationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(vpceConfigurationName)(_.vpceConfigurationName(_))
        .ifSome(vpceServiceName)(_.vpceServiceName(_))
        .ifSome(serviceDnsName)(_.serviceDnsName(_))
        .ifSome(vpceConfigurationDescription)(_.vpceConfigurationDescription(_))
        .build

    def upload(
      arn: Option[String] = None,
      name: Option[String] = None,
      created: Option[DateTime] = None,
      `type`: Option[String] = None,
      status: Option[String] = None,
      url: Option[String] = None,
      metadata: Option[String] = None,
      contentType: Option[String] = None,
      message: Option[String] = None,
      category: Option[String] = None
    ): Upload =
      Upload
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(created)(_.created(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(status)(_.status(_))
        .ifSome(url)(_.url(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(message)(_.message(_))
        .ifSome(category)(_.category(_))
        .build

    def vPCEConfiguration(
      arn: Option[String] = None,
      vpceConfigurationName: Option[String] = None,
      vpceServiceName: Option[String] = None,
      serviceDnsName: Option[String] = None,
      vpceConfigurationDescription: Option[String] = None
    ): VPCEConfiguration =
      VPCEConfiguration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(vpceConfigurationName)(_.vpceConfigurationName(_))
        .ifSome(vpceServiceName)(_.vpceServiceName(_))
        .ifSome(serviceDnsName)(_.serviceDnsName(_))
        .ifSome(vpceConfigurationDescription)(_.vpceConfigurationDescription(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
