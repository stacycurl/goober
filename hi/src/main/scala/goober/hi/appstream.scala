package goober.hi

import goober.free.appstream.AppStreamIO
import software.amazon.awssdk.services.appstream.model._


object appstream {
  import goober.free.{appstream ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessEndpoint(
      endpointType: Option[String] = None,
      vpceId: Option[String] = None
    ): AccessEndpoint =
      AccessEndpoint
        .builder
        .ifSome(endpointType)(_.endpointType(_))
        .ifSome(vpceId)(_.vpceId(_))
        .build

    def application(
      name: Option[String] = None,
      displayName: Option[String] = None,
      iconURL: Option[String] = None,
      launchPath: Option[String] = None,
      launchParameters: Option[String] = None,
      enabled: Option[Boolean] = None,
      metadata: Option[Metadata] = None
    ): Application =
      Application
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(iconURL)(_.iconURL(_))
        .ifSome(launchPath)(_.launchPath(_))
        .ifSome(launchParameters)(_.launchParameters(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(metadata)(_.metadata(_))
        .build

    def applicationSettings(
      enabled: Option[Boolean] = None,
      settingsGroup: Option[String] = None
    ): ApplicationSettings =
      ApplicationSettings
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(settingsGroup)(_.settingsGroup(_))
        .build

    def applicationSettingsResponse(
      enabled: Option[Boolean] = None,
      settingsGroup: Option[String] = None,
      s3BucketName: Option[String] = None
    ): ApplicationSettingsResponse =
      ApplicationSettingsResponse
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(settingsGroup)(_.settingsGroup(_))
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .build

    def associateFleetRequest(
      fleetName: Option[String] = None,
      stackName: Option[String] = None
    ): AssociateFleetRequest =
      AssociateFleetRequest
        .builder
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(stackName)(_.stackName(_))
        .build

    def batchAssociateUserStackRequest(
      userStackAssociations: Option[List[UserStackAssociation]] = None
    ): BatchAssociateUserStackRequest =
      BatchAssociateUserStackRequest
        .builder
        .ifSome(userStackAssociations)(_.userStackAssociations(_))
        .build

    def batchDisassociateUserStackRequest(
      userStackAssociations: Option[List[UserStackAssociation]] = None
    ): BatchDisassociateUserStackRequest =
      BatchDisassociateUserStackRequest
        .builder
        .ifSome(userStackAssociations)(_.userStackAssociations(_))
        .build

    def computeCapacity(
      desiredInstances: Option[Int] = None
    ): ComputeCapacity =
      ComputeCapacity
        .builder
        .ifSome(desiredInstances)(_.desiredInstances(_))
        .build

    def computeCapacityStatus(
      desired: Option[Int] = None,
      running: Option[Int] = None,
      inUse: Option[Int] = None,
      available: Option[Int] = None
    ): ComputeCapacityStatus =
      ComputeCapacityStatus
        .builder
        .ifSome(desired)(_.desired(_))
        .ifSome(running)(_.running(_))
        .ifSome(inUse)(_.inUse(_))
        .ifSome(available)(_.available(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def copyImageRequest(
      sourceImageName: Option[String] = None,
      destinationImageName: Option[String] = None,
      destinationRegion: Option[String] = None,
      destinationImageDescription: Option[String] = None
    ): CopyImageRequest =
      CopyImageRequest
        .builder
        .ifSome(sourceImageName)(_.sourceImageName(_))
        .ifSome(destinationImageName)(_.destinationImageName(_))
        .ifSome(destinationRegion)(_.destinationRegion(_))
        .ifSome(destinationImageDescription)(_.destinationImageDescription(_))
        .build

    def copyImageResponse(
      destinationImageName: Option[String] = None
    ): CopyImageResponse =
      CopyImageResponse
        .builder
        .ifSome(destinationImageName)(_.destinationImageName(_))
        .build

    def createDirectoryConfigRequest(
      directoryName: Option[String] = None,
      organizationalUnitDistinguishedNames: Option[List[OrganizationalUnitDistinguishedName]] = None,
      serviceAccountCredentials: Option[ServiceAccountCredentials] = None
    ): CreateDirectoryConfigRequest =
      CreateDirectoryConfigRequest
        .builder
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(organizationalUnitDistinguishedNames)(_.organizationalUnitDistinguishedNames(_))
        .ifSome(serviceAccountCredentials)(_.serviceAccountCredentials(_))
        .build

    def createFleetRequest(
      name: Option[String] = None,
      imageName: Option[String] = None,
      imageArn: Option[String] = None,
      instanceType: Option[String] = None,
      fleetType: Option[String] = None,
      computeCapacity: Option[ComputeCapacity] = None,
      vpcConfig: Option[VpcConfig] = None,
      maxUserDurationInSeconds: Option[Int] = None,
      disconnectTimeoutInSeconds: Option[Int] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      enableDefaultInternetAccess: Option[Boolean] = None,
      domainJoinInfo: Option[DomainJoinInfo] = None,
      tags: Option[Tags] = None,
      idleDisconnectTimeoutInSeconds: Option[Int] = None,
      iamRoleArn: Option[String] = None,
      streamView: Option[String] = None
    ): CreateFleetRequest =
      CreateFleetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(fleetType)(_.fleetType(_))
        .ifSome(computeCapacity)(_.computeCapacity(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(maxUserDurationInSeconds)(_.maxUserDurationInSeconds(_))
        .ifSome(disconnectTimeoutInSeconds)(_.disconnectTimeoutInSeconds(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(enableDefaultInternetAccess)(_.enableDefaultInternetAccess(_))
        .ifSome(domainJoinInfo)(_.domainJoinInfo(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(idleDisconnectTimeoutInSeconds)(_.idleDisconnectTimeoutInSeconds(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(streamView)(_.streamView(_))
        .build

    def createImageBuilderRequest(
      name: Option[String] = None,
      imageName: Option[String] = None,
      imageArn: Option[String] = None,
      instanceType: Option[String] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      iamRoleArn: Option[String] = None,
      enableDefaultInternetAccess: Option[Boolean] = None,
      domainJoinInfo: Option[DomainJoinInfo] = None,
      appstreamAgentVersion: Option[String] = None,
      tags: Option[Tags] = None,
      accessEndpoints: Option[List[AccessEndpoint]] = None
    ): CreateImageBuilderRequest =
      CreateImageBuilderRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(enableDefaultInternetAccess)(_.enableDefaultInternetAccess(_))
        .ifSome(domainJoinInfo)(_.domainJoinInfo(_))
        .ifSome(appstreamAgentVersion)(_.appstreamAgentVersion(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(accessEndpoints)(_.accessEndpoints(_))
        .build

    def createImageBuilderStreamingURLRequest(
      name: Option[String] = None,
      validity: Option[Long] = None
    ): CreateImageBuilderStreamingURLRequest =
      CreateImageBuilderStreamingURLRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(validity)(_.validity(_))
        .build

    def createStackRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      storageConnectors: Option[List[StorageConnector]] = None,
      redirectURL: Option[String] = None,
      feedbackURL: Option[String] = None,
      userSettings: Option[List[UserSetting]] = None,
      applicationSettings: Option[ApplicationSettings] = None,
      tags: Option[Tags] = None,
      accessEndpoints: Option[List[AccessEndpoint]] = None,
      embedHostDomains: Option[List[EmbedHostDomain]] = None
    ): CreateStackRequest =
      CreateStackRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(storageConnectors)(_.storageConnectors(_))
        .ifSome(redirectURL)(_.redirectURL(_))
        .ifSome(feedbackURL)(_.feedbackURL(_))
        .ifSome(userSettings)(_.userSettings(_))
        .ifSome(applicationSettings)(_.applicationSettings(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(accessEndpoints)(_.accessEndpoints(_))
        .ifSome(embedHostDomains)(_.embedHostDomains(_))
        .build

    def createStreamingURLRequest(
      stackName: Option[String] = None,
      fleetName: Option[String] = None,
      userId: Option[String] = None,
      applicationId: Option[String] = None,
      validity: Option[Long] = None,
      sessionContext: Option[String] = None
    ): CreateStreamingURLRequest =
      CreateStreamingURLRequest
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(sessionContext)(_.sessionContext(_))
        .build

    def createUpdatedImageRequest(
      existingImageName: Option[String] = None,
      newImageName: Option[String] = None,
      newImageDescription: Option[String] = None,
      newImageDisplayName: Option[String] = None,
      newImageTags: Option[Tags] = None,
      dryRun: Option[Boolean] = None
    ): CreateUpdatedImageRequest =
      CreateUpdatedImageRequest
        .builder
        .ifSome(existingImageName)(_.existingImageName(_))
        .ifSome(newImageName)(_.newImageName(_))
        .ifSome(newImageDescription)(_.newImageDescription(_))
        .ifSome(newImageDisplayName)(_.newImageDisplayName(_))
        .ifSome(newImageTags)(_.newImageTags(_))
        .ifSome(dryRun)(_.dryRun(_))
        .build

    def createUsageReportSubscriptionRequest(

    ): CreateUsageReportSubscriptionRequest =
      CreateUsageReportSubscriptionRequest
        .builder

        .build

    def createUserRequest(
      userName: Option[String] = None,
      messageAction: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      authenticationType: Option[String] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(messageAction)(_.messageAction(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def deleteDirectoryConfigRequest(
      directoryName: Option[String] = None
    ): DeleteDirectoryConfigRequest =
      DeleteDirectoryConfigRequest
        .builder
        .ifSome(directoryName)(_.directoryName(_))
        .build

    def deleteFleetRequest(
      name: Option[String] = None
    ): DeleteFleetRequest =
      DeleteFleetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteImageBuilderRequest(
      name: Option[String] = None
    ): DeleteImageBuilderRequest =
      DeleteImageBuilderRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteImagePermissionsRequest(
      name: Option[String] = None,
      sharedAccountId: Option[String] = None
    ): DeleteImagePermissionsRequest =
      DeleteImagePermissionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .build

    def deleteImageRequest(
      name: Option[String] = None
    ): DeleteImageRequest =
      DeleteImageRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteStackRequest(
      name: Option[String] = None
    ): DeleteStackRequest =
      DeleteStackRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteUsageReportSubscriptionRequest(

    ): DeleteUsageReportSubscriptionRequest =
      DeleteUsageReportSubscriptionRequest
        .builder

        .build

    def deleteUserRequest(
      userName: Option[String] = None,
      authenticationType: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def describeDirectoryConfigsRequest(
      directoryNames: Option[List[DirectoryName]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDirectoryConfigsRequest =
      DescribeDirectoryConfigsRequest
        .builder
        .ifSome(directoryNames)(_.directoryNames(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFleetsRequest(
      names: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): DescribeFleetsRequest =
      DescribeFleetsRequest
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImageBuildersRequest(
      names: Option[List[String]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeImageBuildersRequest =
      DescribeImageBuildersRequest
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImagePermissionsRequest(
      name: Option[String] = None,
      maxResults: Option[Int] = None,
      sharedAwsAccountIds: Option[List[AwsAccountId]] = None,
      nextToken: Option[String] = None
    ): DescribeImagePermissionsRequest =
      DescribeImagePermissionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sharedAwsAccountIds)(_.sharedAwsAccountIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeImagesRequest(
      names: Option[List[String]] = None,
      arns: Option[List[Arn]] = None,
      `type`: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeImagesRequest =
      DescribeImagesRequest
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(arns)(_.arns(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeSessionsRequest(
      stackName: Option[String] = None,
      fleetName: Option[String] = None,
      userId: Option[String] = None,
      nextToken: Option[String] = None,
      limit: Option[Int] = None,
      authenticationType: Option[String] = None
    ): DescribeSessionsRequest =
      DescribeSessionsRequest
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def describeStacksRequest(
      names: Option[List[String]] = None,
      nextToken: Option[String] = None
    ): DescribeStacksRequest =
      DescribeStacksRequest
        .builder
        .ifSome(names)(_.names(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeUsageReportSubscriptionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeUsageReportSubscriptionsRequest =
      DescribeUsageReportSubscriptionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeUserStackAssociationsRequest(
      stackName: Option[String] = None,
      userName: Option[String] = None,
      authenticationType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeUserStackAssociationsRequest =
      DescribeUserStackAssociationsRequest
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeUsersRequest(
      authenticationType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeUsersRequest =
      DescribeUsersRequest
        .builder
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def directoryConfig(
      directoryName: Option[String] = None,
      organizationalUnitDistinguishedNames: Option[List[OrganizationalUnitDistinguishedName]] = None,
      serviceAccountCredentials: Option[ServiceAccountCredentials] = None,
      createdTime: Option[Timestamp] = None
    ): DirectoryConfig =
      DirectoryConfig
        .builder
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(organizationalUnitDistinguishedNames)(_.organizationalUnitDistinguishedNames(_))
        .ifSome(serviceAccountCredentials)(_.serviceAccountCredentials(_))
        .ifSome(createdTime)(_.createdTime(_))
        .build

    def disableUserRequest(
      userName: Option[String] = None,
      authenticationType: Option[String] = None
    ): DisableUserRequest =
      DisableUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def disassociateFleetRequest(
      fleetName: Option[String] = None,
      stackName: Option[String] = None
    ): DisassociateFleetRequest =
      DisassociateFleetRequest
        .builder
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(stackName)(_.stackName(_))
        .build

    def domainJoinInfo(
      directoryName: Option[String] = None,
      organizationalUnitDistinguishedName: Option[String] = None
    ): DomainJoinInfo =
      DomainJoinInfo
        .builder
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(organizationalUnitDistinguishedName)(_.organizationalUnitDistinguishedName(_))
        .build

    def enableUserRequest(
      userName: Option[String] = None,
      authenticationType: Option[String] = None
    ): EnableUserRequest =
      EnableUserRequest
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def expireSessionRequest(
      sessionId: Option[String] = None
    ): ExpireSessionRequest =
      ExpireSessionRequest
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .build

    def fleet(
      arn: Option[String] = None,
      name: Option[String] = None,
      displayName: Option[String] = None,
      description: Option[String] = None,
      imageName: Option[String] = None,
      imageArn: Option[String] = None,
      instanceType: Option[String] = None,
      fleetType: Option[String] = None,
      computeCapacityStatus: Option[ComputeCapacityStatus] = None,
      maxUserDurationInSeconds: Option[Int] = None,
      disconnectTimeoutInSeconds: Option[Int] = None,
      state: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      createdTime: Option[Timestamp] = None,
      fleetErrors: Option[List[FleetError]] = None,
      enableDefaultInternetAccess: Option[Boolean] = None,
      domainJoinInfo: Option[DomainJoinInfo] = None,
      idleDisconnectTimeoutInSeconds: Option[Int] = None,
      iamRoleArn: Option[String] = None,
      streamView: Option[String] = None
    ): Fleet =
      Fleet
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(fleetType)(_.fleetType(_))
        .ifSome(computeCapacityStatus)(_.computeCapacityStatus(_))
        .ifSome(maxUserDurationInSeconds)(_.maxUserDurationInSeconds(_))
        .ifSome(disconnectTimeoutInSeconds)(_.disconnectTimeoutInSeconds(_))
        .ifSome(state)(_.state(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(fleetErrors)(_.fleetErrors(_))
        .ifSome(enableDefaultInternetAccess)(_.enableDefaultInternetAccess(_))
        .ifSome(domainJoinInfo)(_.domainJoinInfo(_))
        .ifSome(idleDisconnectTimeoutInSeconds)(_.idleDisconnectTimeoutInSeconds(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(streamView)(_.streamView(_))
        .build

    def fleetError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): FleetError =
      FleetError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def image(
      name: Option[String] = None,
      arn: Option[String] = None,
      baseImageArn: Option[String] = None,
      displayName: Option[String] = None,
      state: Option[String] = None,
      visibility: Option[String] = None,
      imageBuilderSupported: Option[Boolean] = None,
      imageBuilderName: Option[String] = None,
      platform: Option[String] = None,
      description: Option[String] = None,
      stateChangeReason: Option[ImageStateChangeReason] = None,
      applications: Option[List[Application]] = None,
      createdTime: Option[Timestamp] = None,
      publicBaseImageReleasedDate: Option[Timestamp] = None,
      appstreamAgentVersion: Option[String] = None,
      imagePermissions: Option[ImagePermissions] = None,
      imageErrors: Option[List[ResourceError]] = None
    ): Image =
      Image
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(baseImageArn)(_.baseImageArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(state)(_.state(_))
        .ifSome(visibility)(_.visibility(_))
        .ifSome(imageBuilderSupported)(_.imageBuilderSupported(_))
        .ifSome(imageBuilderName)(_.imageBuilderName(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(description)(_.description(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(applications)(_.applications(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(publicBaseImageReleasedDate)(_.publicBaseImageReleasedDate(_))
        .ifSome(appstreamAgentVersion)(_.appstreamAgentVersion(_))
        .ifSome(imagePermissions)(_.imagePermissions(_))
        .ifSome(imageErrors)(_.imageErrors(_))
        .build

    def imageBuilder(
      name: Option[String] = None,
      arn: Option[String] = None,
      imageArn: Option[String] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      instanceType: Option[String] = None,
      platform: Option[String] = None,
      iamRoleArn: Option[String] = None,
      state: Option[String] = None,
      stateChangeReason: Option[ImageBuilderStateChangeReason] = None,
      createdTime: Option[Timestamp] = None,
      enableDefaultInternetAccess: Option[Boolean] = None,
      domainJoinInfo: Option[DomainJoinInfo] = None,
      networkAccessConfiguration: Option[NetworkAccessConfiguration] = None,
      imageBuilderErrors: Option[List[ResourceError]] = None,
      appstreamAgentVersion: Option[String] = None,
      accessEndpoints: Option[List[AccessEndpoint]] = None
    ): ImageBuilder =
      ImageBuilder
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(state)(_.state(_))
        .ifSome(stateChangeReason)(_.stateChangeReason(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(enableDefaultInternetAccess)(_.enableDefaultInternetAccess(_))
        .ifSome(domainJoinInfo)(_.domainJoinInfo(_))
        .ifSome(networkAccessConfiguration)(_.networkAccessConfiguration(_))
        .ifSome(imageBuilderErrors)(_.imageBuilderErrors(_))
        .ifSome(appstreamAgentVersion)(_.appstreamAgentVersion(_))
        .ifSome(accessEndpoints)(_.accessEndpoints(_))
        .build

    def imageBuilderStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): ImageBuilderStateChangeReason =
      ImageBuilderStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def imagePermissions(
      allowFleet: Option[Boolean] = None,
      allowImageBuilder: Option[Boolean] = None
    ): ImagePermissions =
      ImagePermissions
        .builder
        .ifSome(allowFleet)(_.allowFleet(_))
        .ifSome(allowImageBuilder)(_.allowImageBuilder(_))
        .build

    def imageStateChangeReason(
      code: Option[String] = None,
      message: Option[String] = None
    ): ImageStateChangeReason =
      ImageStateChangeReason
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def incompatibleImageException(
      message: Option[String] = None
    ): IncompatibleImageException =
      IncompatibleImageException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAccountStatusException(
      message: Option[String] = None
    ): InvalidAccountStatusException =
      InvalidAccountStatusException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterCombinationException(
      message: Option[String] = None
    ): InvalidParameterCombinationException =
      InvalidParameterCombinationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRoleException(
      message: Option[String] = None
    ): InvalidRoleException =
      InvalidRoleException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def lastReportGenerationExecutionError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): LastReportGenerationExecutionError =
      LastReportGenerationExecutionError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAssociatedFleetsRequest(
      stackName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListAssociatedFleetsRequest =
      ListAssociatedFleetsRequest
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAssociatedStacksRequest(
      fleetName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListAssociatedStacksRequest =
      ListAssociatedStacksRequest
        .builder
        .ifSome(fleetName)(_.fleetName(_))
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
      tags: Option[Tags] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def networkAccessConfiguration(
      eniPrivateIpAddress: Option[String] = None,
      eniId: Option[String] = None
    ): NetworkAccessConfiguration =
      NetworkAccessConfiguration
        .builder
        .ifSome(eniPrivateIpAddress)(_.eniPrivateIpAddress(_))
        .ifSome(eniId)(_.eniId(_))
        .build

    def operationNotPermittedException(
      message: Option[String] = None
    ): OperationNotPermittedException =
      OperationNotPermittedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def requestLimitExceededException(
      message: Option[String] = None
    ): RequestLimitExceededException =
      RequestLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None,
      errorTimestamp: Option[Timestamp] = None
    ): ResourceError =
      ResourceError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(errorTimestamp)(_.errorTimestamp(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotAvailableException(
      message: Option[String] = None
    ): ResourceNotAvailableException =
      ResourceNotAvailableException
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

    def serviceAccountCredentials(
      accountName: Option[String] = None,
      accountPassword: Option[String] = None
    ): ServiceAccountCredentials =
      ServiceAccountCredentials
        .builder
        .ifSome(accountName)(_.accountName(_))
        .ifSome(accountPassword)(_.accountPassword(_))
        .build

    def session(
      id: Option[String] = None,
      userId: Option[String] = None,
      stackName: Option[String] = None,
      fleetName: Option[String] = None,
      state: Option[String] = None,
      connectionState: Option[String] = None,
      startTime: Option[Timestamp] = None,
      maxExpirationTime: Option[Timestamp] = None,
      authenticationType: Option[String] = None,
      networkAccessConfiguration: Option[NetworkAccessConfiguration] = None
    ): Session =
      Session
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(userId)(_.userId(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(fleetName)(_.fleetName(_))
        .ifSome(state)(_.state(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(maxExpirationTime)(_.maxExpirationTime(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(networkAccessConfiguration)(_.networkAccessConfiguration(_))
        .build

    def sharedImagePermissions(
      sharedAccountId: Option[String] = None,
      imagePermissions: Option[ImagePermissions] = None
    ): SharedImagePermissions =
      SharedImagePermissions
        .builder
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .ifSome(imagePermissions)(_.imagePermissions(_))
        .build

    def stack(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      storageConnectors: Option[List[StorageConnector]] = None,
      redirectURL: Option[String] = None,
      feedbackURL: Option[String] = None,
      stackErrors: Option[List[StackError]] = None,
      userSettings: Option[List[UserSetting]] = None,
      applicationSettings: Option[ApplicationSettingsResponse] = None,
      accessEndpoints: Option[List[AccessEndpoint]] = None,
      embedHostDomains: Option[List[EmbedHostDomain]] = None
    ): Stack =
      Stack
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(storageConnectors)(_.storageConnectors(_))
        .ifSome(redirectURL)(_.redirectURL(_))
        .ifSome(feedbackURL)(_.feedbackURL(_))
        .ifSome(stackErrors)(_.stackErrors(_))
        .ifSome(userSettings)(_.userSettings(_))
        .ifSome(applicationSettings)(_.applicationSettings(_))
        .ifSome(accessEndpoints)(_.accessEndpoints(_))
        .ifSome(embedHostDomains)(_.embedHostDomains(_))
        .build

    def stackError(
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): StackError =
      StackError
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def startFleetRequest(
      name: Option[String] = None
    ): StartFleetRequest =
      StartFleetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startImageBuilderRequest(
      name: Option[String] = None,
      appstreamAgentVersion: Option[String] = None
    ): StartImageBuilderRequest =
      StartImageBuilderRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(appstreamAgentVersion)(_.appstreamAgentVersion(_))
        .build

    def stopFleetRequest(
      name: Option[String] = None
    ): StopFleetRequest =
      StopFleetRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopImageBuilderRequest(
      name: Option[String] = None
    ): StopImageBuilderRequest =
      StopImageBuilderRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def storageConnector(
      connectorType: Option[String] = None,
      resourceIdentifier: Option[String] = None,
      domains: Option[List[Domain]] = None
    ): StorageConnector =
      StorageConnector
        .builder
        .ifSome(connectorType)(_.connectorType(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(domains)(_.domains(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
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

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
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

    def updateDirectoryConfigRequest(
      directoryName: Option[String] = None,
      organizationalUnitDistinguishedNames: Option[List[OrganizationalUnitDistinguishedName]] = None,
      serviceAccountCredentials: Option[ServiceAccountCredentials] = None
    ): UpdateDirectoryConfigRequest =
      UpdateDirectoryConfigRequest
        .builder
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(organizationalUnitDistinguishedNames)(_.organizationalUnitDistinguishedNames(_))
        .ifSome(serviceAccountCredentials)(_.serviceAccountCredentials(_))
        .build

    def updateFleetRequest(
      imageName: Option[String] = None,
      imageArn: Option[String] = None,
      name: Option[String] = None,
      instanceType: Option[String] = None,
      computeCapacity: Option[ComputeCapacity] = None,
      vpcConfig: Option[VpcConfig] = None,
      maxUserDurationInSeconds: Option[Int] = None,
      disconnectTimeoutInSeconds: Option[Int] = None,
      deleteVpcConfig: Option[Boolean] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      enableDefaultInternetAccess: Option[Boolean] = None,
      domainJoinInfo: Option[DomainJoinInfo] = None,
      idleDisconnectTimeoutInSeconds: Option[Int] = None,
      attributesToDelete: Option[List[FleetAttribute]] = None,
      iamRoleArn: Option[String] = None,
      streamView: Option[String] = None
    ): UpdateFleetRequest =
      UpdateFleetRequest
        .builder
        .ifSome(imageName)(_.imageName(_))
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(computeCapacity)(_.computeCapacity(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(maxUserDurationInSeconds)(_.maxUserDurationInSeconds(_))
        .ifSome(disconnectTimeoutInSeconds)(_.disconnectTimeoutInSeconds(_))
        .ifSome(deleteVpcConfig)(_.deleteVpcConfig(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(enableDefaultInternetAccess)(_.enableDefaultInternetAccess(_))
        .ifSome(domainJoinInfo)(_.domainJoinInfo(_))
        .ifSome(idleDisconnectTimeoutInSeconds)(_.idleDisconnectTimeoutInSeconds(_))
        .ifSome(attributesToDelete)(_.attributesToDelete(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(streamView)(_.streamView(_))
        .build

    def updateImagePermissionsRequest(
      name: Option[String] = None,
      sharedAccountId: Option[String] = None,
      imagePermissions: Option[ImagePermissions] = None
    ): UpdateImagePermissionsRequest =
      UpdateImagePermissionsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(sharedAccountId)(_.sharedAccountId(_))
        .ifSome(imagePermissions)(_.imagePermissions(_))
        .build

    def updateStackRequest(
      displayName: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      storageConnectors: Option[List[StorageConnector]] = None,
      deleteStorageConnectors: Option[Boolean] = None,
      redirectURL: Option[String] = None,
      feedbackURL: Option[String] = None,
      attributesToDelete: Option[List[StackAttribute]] = None,
      userSettings: Option[List[UserSetting]] = None,
      applicationSettings: Option[ApplicationSettings] = None,
      accessEndpoints: Option[List[AccessEndpoint]] = None,
      embedHostDomains: Option[List[EmbedHostDomain]] = None
    ): UpdateStackRequest =
      UpdateStackRequest
        .builder
        .ifSome(displayName)(_.displayName(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(storageConnectors)(_.storageConnectors(_))
        .ifSome(deleteStorageConnectors)(_.deleteStorageConnectors(_))
        .ifSome(redirectURL)(_.redirectURL(_))
        .ifSome(feedbackURL)(_.feedbackURL(_))
        .ifSome(attributesToDelete)(_.attributesToDelete(_))
        .ifSome(userSettings)(_.userSettings(_))
        .ifSome(applicationSettings)(_.applicationSettings(_))
        .ifSome(accessEndpoints)(_.accessEndpoints(_))
        .ifSome(embedHostDomains)(_.embedHostDomains(_))
        .build

    def usageReportSubscription(
      s3BucketName: Option[String] = None,
      schedule: Option[String] = None,
      lastGeneratedReportDate: Option[Timestamp] = None,
      subscriptionErrors: Option[List[LastReportGenerationExecutionError]] = None
    ): UsageReportSubscription =
      UsageReportSubscription
        .builder
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(lastGeneratedReportDate)(_.lastGeneratedReportDate(_))
        .ifSome(subscriptionErrors)(_.subscriptionErrors(_))
        .build

    def user(
      arn: Option[String] = None,
      userName: Option[String] = None,
      enabled: Option[Boolean] = None,
      status: Option[String] = None,
      firstName: Option[String] = None,
      lastName: Option[String] = None,
      createdTime: Option[Timestamp] = None,
      authenticationType: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(status)(_.status(_))
        .ifSome(firstName)(_.firstName(_))
        .ifSome(lastName)(_.lastName(_))
        .ifSome(createdTime)(_.createdTime(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .build

    def userSetting(
      action: Option[String] = None,
      permission: Option[String] = None
    ): UserSetting =
      UserSetting
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(permission)(_.permission(_))
        .build

    def userStackAssociation(
      stackName: Option[String] = None,
      userName: Option[String] = None,
      authenticationType: Option[String] = None,
      sendEmailNotification: Option[Boolean] = None
    ): UserStackAssociation =
      UserStackAssociation
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(authenticationType)(_.authenticationType(_))
        .ifSome(sendEmailNotification)(_.sendEmailNotification(_))
        .build

    def userStackAssociationError(
      userStackAssociation: Option[UserStackAssociation] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): UserStackAssociationError =
      UserStackAssociationError
        .builder
        .ifSome(userStackAssociation)(_.userStackAssociation(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def vpcConfig(
      subnetIds: Option[List[String]] = None,
      securityGroupIds: Option[List[String]] = None
    ): VpcConfig =
      VpcConfig
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
