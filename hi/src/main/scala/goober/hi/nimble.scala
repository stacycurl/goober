package goober.hi

import goober.free.nimble.NimbleIO
import software.amazon.awssdk.services.nimble.model._


object nimble {
  import goober.free.{nimble ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptEulasInput(
      eulaIds: Option[List[__string]] = None
    ): AcceptEulasInput =
      AcceptEulasInput
        .builder
        .ifSome(eulaIds)(_.eulaIds(_))
        .build

    def acceptEulasOutput(
      eulaAcceptances: Option[List[EulaAcceptance]] = None
    ): AcceptEulasOutput =
      AcceptEulasOutput
        .builder
        .ifSome(eulaAcceptances)(_.eulaAcceptances(_))
        .build

    def acceptEulasRequest(
      clientToken: Option[String] = None,
      eulaIds: Option[List[__string]] = None,
      studioId: Option[String] = None
    ): AcceptEulasRequest =
      AcceptEulasRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(eulaIds)(_.eulaIds(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def acceptEulasResponse(
      eulaAcceptances: Option[List[EulaAcceptance]] = None
    ): AcceptEulasResponse =
      AcceptEulasResponse
        .builder
        .ifSome(eulaAcceptances)(_.eulaAcceptances(_))
        .build

    def accessDeniedException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

    def activeDirectoryComputerAttribute(
      name: Option[String] = None,
      value: Option[String] = None
    ): ActiveDirectoryComputerAttribute =
      ActiveDirectoryComputerAttribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def activeDirectoryConfiguration(
      computerAttributes: Option[List[ActiveDirectoryComputerAttribute]] = None,
      directoryId: Option[String] = None,
      organizationalUnitDistinguishedName: Option[String] = None
    ): ActiveDirectoryConfiguration =
      ActiveDirectoryConfiguration
        .builder
        .ifSome(computerAttributes)(_.computerAttributes(_))
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(organizationalUnitDistinguishedName)(_.organizationalUnitDistinguishedName(_))
        .build

    def computeFarmConfiguration(
      activeDirectoryUser: Option[String] = None,
      endpoint: Option[String] = None
    ): ComputeFarmConfiguration =
      ComputeFarmConfiguration
        .builder
        .ifSome(activeDirectoryUser)(_.activeDirectoryUser(_))
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def conflictException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

    def createLaunchProfileInput(
      description: Option[String] = None,
      ec2SubnetIds: Option[List[EC2SubnetId]] = None,
      launchProfileProtocolVersions: Option[List[LaunchProfileProtocolVersion]] = None,
      name: Option[String] = None,
      streamConfiguration: Option[StreamConfigurationCreate] = None,
      studioComponentIds: Option[List[__string]] = None,
      tags: Option[Tags] = None
    ): CreateLaunchProfileInput =
      CreateLaunchProfileInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(ec2SubnetIds)(_.ec2SubnetIds(_))
        .ifSome(launchProfileProtocolVersions)(_.launchProfileProtocolVersions(_))
        .ifSome(name)(_.name(_))
        .ifSome(streamConfiguration)(_.streamConfiguration(_))
        .ifSome(studioComponentIds)(_.studioComponentIds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLaunchProfileOutput(
      launchProfile: Option[LaunchProfile] = None
    ): CreateLaunchProfileOutput =
      CreateLaunchProfileOutput
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def createLaunchProfileRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      ec2SubnetIds: Option[List[EC2SubnetId]] = None,
      launchProfileProtocolVersions: Option[List[LaunchProfileProtocolVersion]] = None,
      name: Option[String] = None,
      streamConfiguration: Option[StreamConfigurationCreate] = None,
      studioComponentIds: Option[List[__string]] = None,
      studioId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateLaunchProfileRequest =
      CreateLaunchProfileRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SubnetIds)(_.ec2SubnetIds(_))
        .ifSome(launchProfileProtocolVersions)(_.launchProfileProtocolVersions(_))
        .ifSome(name)(_.name(_))
        .ifSome(streamConfiguration)(_.streamConfiguration(_))
        .ifSome(studioComponentIds)(_.studioComponentIds(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLaunchProfileResponse(
      launchProfile: Option[LaunchProfile] = None
    ): CreateLaunchProfileResponse =
      CreateLaunchProfileResponse
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def createStreamingImageInput(
      description: Option[String] = None,
      ec2ImageId: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateStreamingImageInput =
      CreateStreamingImageInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(ec2ImageId)(_.ec2ImageId(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamingImageOutput(
      streamingImage: Option[StreamingImage] = None
    ): CreateStreamingImageOutput =
      CreateStreamingImageOutput
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def createStreamingImageRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      ec2ImageId: Option[String] = None,
      name: Option[String] = None,
      studioId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateStreamingImageRequest =
      CreateStreamingImageRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2ImageId)(_.ec2ImageId(_))
        .ifSome(name)(_.name(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamingImageResponse(
      streamingImage: Option[StreamingImage] = None
    ): CreateStreamingImageResponse =
      CreateStreamingImageResponse
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def createStreamingSessionInput(
      ec2InstanceType: Option[String] = None,
      launchProfileId: Option[String] = None,
      streamingImageId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateStreamingSessionInput =
      CreateStreamingSessionInput
        .builder
        .ifSome(ec2InstanceType)(_.ec2InstanceType(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamingSessionOutput(
      session: Option[StreamingSession] = None
    ): CreateStreamingSessionOutput =
      CreateStreamingSessionOutput
        .builder
        .ifSome(session)(_.session(_))
        .build

    def createStreamingSessionRequest(
      clientToken: Option[String] = None,
      ec2InstanceType: Option[String] = None,
      launchProfileId: Option[String] = None,
      streamingImageId: Option[String] = None,
      studioId: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateStreamingSessionRequest =
      CreateStreamingSessionRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(ec2InstanceType)(_.ec2InstanceType(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamingSessionResponse(
      session: Option[StreamingSession] = None
    ): CreateStreamingSessionResponse =
      CreateStreamingSessionResponse
        .builder
        .ifSome(session)(_.session(_))
        .build

    def createStreamingSessionStreamInput(
      expirationInSeconds: Option[Int] = None
    ): CreateStreamingSessionStreamInput =
      CreateStreamingSessionStreamInput
        .builder
        .ifSome(expirationInSeconds)(_.expirationInSeconds(_))
        .build

    def createStreamingSessionStreamOutput(
      stream: Option[StreamingSessionStream] = None
    ): CreateStreamingSessionStreamOutput =
      CreateStreamingSessionStreamOutput
        .builder
        .ifSome(stream)(_.stream(_))
        .build

    def createStreamingSessionStreamRequest(
      clientToken: Option[String] = None,
      expirationInSeconds: Option[Int] = None,
      sessionId: Option[String] = None,
      studioId: Option[String] = None
    ): CreateStreamingSessionStreamRequest =
      CreateStreamingSessionStreamRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(expirationInSeconds)(_.expirationInSeconds(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def createStreamingSessionStreamResponse(
      stream: Option[StreamingSessionStream] = None
    ): CreateStreamingSessionStreamResponse =
      CreateStreamingSessionStreamResponse
        .builder
        .ifSome(stream)(_.stream(_))
        .build

    def createStudioComponentInput(
      configuration: Option[StudioComponentConfiguration] = None,
      description: Option[String] = None,
      ec2SecurityGroupIds: Option[List[SecurityGroupId]] = None,
      initializationScripts: Option[List[StudioComponentInitializationScript]] = None,
      name: Option[String] = None,
      scriptParameters: Option[List[ScriptParameterKeyValue]] = None,
      subtype: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None
    ): CreateStudioComponentInput =
      CreateStudioComponentInput
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SecurityGroupIds)(_.ec2SecurityGroupIds(_))
        .ifSome(initializationScripts)(_.initializationScripts(_))
        .ifSome(name)(_.name(_))
        .ifSome(scriptParameters)(_.scriptParameters(_))
        .ifSome(subtype)(_.subtype(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createStudioComponentOutput(
      studioComponent: Option[StudioComponent] = None
    ): CreateStudioComponentOutput =
      CreateStudioComponentOutput
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def createStudioComponentRequest(
      clientToken: Option[String] = None,
      configuration: Option[StudioComponentConfiguration] = None,
      description: Option[String] = None,
      ec2SecurityGroupIds: Option[List[SecurityGroupId]] = None,
      initializationScripts: Option[List[StudioComponentInitializationScript]] = None,
      name: Option[String] = None,
      scriptParameters: Option[List[ScriptParameterKeyValue]] = None,
      studioId: Option[String] = None,
      subtype: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None
    ): CreateStudioComponentRequest =
      CreateStudioComponentRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SecurityGroupIds)(_.ec2SecurityGroupIds(_))
        .ifSome(initializationScripts)(_.initializationScripts(_))
        .ifSome(name)(_.name(_))
        .ifSome(scriptParameters)(_.scriptParameters(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(subtype)(_.subtype(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def createStudioComponentResponse(
      studioComponent: Option[StudioComponent] = None
    ): CreateStudioComponentResponse =
      CreateStudioComponentResponse
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def createStudioInput(
      adminRoleArn: Option[String] = None,
      displayName: Option[String] = None,
      studioEncryptionConfiguration: Option[StudioEncryptionConfiguration] = None,
      studioName: Option[String] = None,
      tags: Option[Tags] = None,
      userRoleArn: Option[String] = None
    ): CreateStudioInput =
      CreateStudioInput
        .builder
        .ifSome(adminRoleArn)(_.adminRoleArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(studioEncryptionConfiguration)(_.studioEncryptionConfiguration(_))
        .ifSome(studioName)(_.studioName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userRoleArn)(_.userRoleArn(_))
        .build

    def createStudioOutput(
      studio: Option[Studio] = None
    ): CreateStudioOutput =
      CreateStudioOutput
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def createStudioRequest(
      adminRoleArn: Option[String] = None,
      clientToken: Option[String] = None,
      displayName: Option[String] = None,
      studioEncryptionConfiguration: Option[StudioEncryptionConfiguration] = None,
      studioName: Option[String] = None,
      tags: Option[Tags] = None,
      userRoleArn: Option[String] = None
    ): CreateStudioRequest =
      CreateStudioRequest
        .builder
        .ifSome(adminRoleArn)(_.adminRoleArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(studioEncryptionConfiguration)(_.studioEncryptionConfiguration(_))
        .ifSome(studioName)(_.studioName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(userRoleArn)(_.userRoleArn(_))
        .build

    def createStudioResponse(
      studio: Option[Studio] = None
    ): CreateStudioResponse =
      CreateStudioResponse
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def deleteLaunchProfileMemberOutput(

    ): DeleteLaunchProfileMemberOutput =
      DeleteLaunchProfileMemberOutput
        .builder

        .build

    def deleteLaunchProfileMemberRequest(
      clientToken: Option[String] = None,
      launchProfileId: Option[String] = None,
      principalId: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteLaunchProfileMemberRequest =
      DeleteLaunchProfileMemberRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteLaunchProfileMemberResponse(

    ): DeleteLaunchProfileMemberResponse =
      DeleteLaunchProfileMemberResponse
        .builder

        .build

    def deleteLaunchProfileOutput(
      launchProfile: Option[LaunchProfile] = None
    ): DeleteLaunchProfileOutput =
      DeleteLaunchProfileOutput
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def deleteLaunchProfileRequest(
      clientToken: Option[String] = None,
      launchProfileId: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteLaunchProfileRequest =
      DeleteLaunchProfileRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteLaunchProfileResponse(
      launchProfile: Option[LaunchProfile] = None
    ): DeleteLaunchProfileResponse =
      DeleteLaunchProfileResponse
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def deleteStreamingImageOutput(
      streamingImage: Option[StreamingImage] = None
    ): DeleteStreamingImageOutput =
      DeleteStreamingImageOutput
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def deleteStreamingImageRequest(
      clientToken: Option[String] = None,
      streamingImageId: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteStreamingImageRequest =
      DeleteStreamingImageRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteStreamingImageResponse(
      streamingImage: Option[StreamingImage] = None
    ): DeleteStreamingImageResponse =
      DeleteStreamingImageResponse
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def deleteStreamingSessionOutput(
      session: Option[StreamingSession] = None
    ): DeleteStreamingSessionOutput =
      DeleteStreamingSessionOutput
        .builder
        .ifSome(session)(_.session(_))
        .build

    def deleteStreamingSessionRequest(
      clientToken: Option[String] = None,
      sessionId: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteStreamingSessionRequest =
      DeleteStreamingSessionRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteStreamingSessionResponse(
      session: Option[StreamingSession] = None
    ): DeleteStreamingSessionResponse =
      DeleteStreamingSessionResponse
        .builder
        .ifSome(session)(_.session(_))
        .build

    def deleteStudioComponentOutput(
      studioComponent: Option[StudioComponent] = None
    ): DeleteStudioComponentOutput =
      DeleteStudioComponentOutput
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def deleteStudioComponentRequest(
      clientToken: Option[String] = None,
      studioComponentId: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteStudioComponentRequest =
      DeleteStudioComponentRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteStudioComponentResponse(
      studioComponent: Option[StudioComponent] = None
    ): DeleteStudioComponentResponse =
      DeleteStudioComponentResponse
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def deleteStudioMemberOutput(

    ): DeleteStudioMemberOutput =
      DeleteStudioMemberOutput
        .builder

        .build

    def deleteStudioMemberRequest(
      clientToken: Option[String] = None,
      principalId: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteStudioMemberRequest =
      DeleteStudioMemberRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteStudioMemberResponse(

    ): DeleteStudioMemberResponse =
      DeleteStudioMemberResponse
        .builder

        .build

    def deleteStudioOutput(
      studio: Option[Studio] = None
    ): DeleteStudioOutput =
      DeleteStudioOutput
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def deleteStudioRequest(
      clientToken: Option[String] = None,
      studioId: Option[String] = None
    ): DeleteStudioRequest =
      DeleteStudioRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def deleteStudioResponse(
      studio: Option[Studio] = None
    ): DeleteStudioResponse =
      DeleteStudioResponse
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def empty(

    ): Empty =
      Empty
        .builder

        .build

    def eula(
      content: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      eulaId: Option[String] = None,
      name: Option[String] = None,
      updatedAt: Option[Timestamp] = None
    ): Eula =
      Eula
        .builder
        .ifSome(content)(_.content(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(eulaId)(_.eulaId(_))
        .ifSome(name)(_.name(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def eulaAcceptance(
      acceptedAt: Option[Timestamp] = None,
      acceptedBy: Option[String] = None,
      accepteeId: Option[String] = None,
      eulaAcceptanceId: Option[String] = None,
      eulaId: Option[String] = None
    ): EulaAcceptance =
      EulaAcceptance
        .builder
        .ifSome(acceptedAt)(_.acceptedAt(_))
        .ifSome(acceptedBy)(_.acceptedBy(_))
        .ifSome(accepteeId)(_.accepteeId(_))
        .ifSome(eulaAcceptanceId)(_.eulaAcceptanceId(_))
        .ifSome(eulaId)(_.eulaId(_))
        .build

    def getEulaOutput(
      eula: Option[Eula] = None
    ): GetEulaOutput =
      GetEulaOutput
        .builder
        .ifSome(eula)(_.eula(_))
        .build

    def getEulaRequest(
      eulaId: Option[String] = None
    ): GetEulaRequest =
      GetEulaRequest
        .builder
        .ifSome(eulaId)(_.eulaId(_))
        .build

    def getEulaResponse(
      eula: Option[Eula] = None
    ): GetEulaResponse =
      GetEulaResponse
        .builder
        .ifSome(eula)(_.eula(_))
        .build

    def getLaunchProfileDetailsOutput(
      launchProfile: Option[LaunchProfile] = None,
      streamingImages: Option[List[StreamingImage]] = None,
      studioComponentSummaries: Option[List[StudioComponentSummary]] = None
    ): GetLaunchProfileDetailsOutput =
      GetLaunchProfileDetailsOutput
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .ifSome(streamingImages)(_.streamingImages(_))
        .ifSome(studioComponentSummaries)(_.studioComponentSummaries(_))
        .build

    def getLaunchProfileDetailsRequest(
      launchProfileId: Option[String] = None,
      studioId: Option[String] = None
    ): GetLaunchProfileDetailsRequest =
      GetLaunchProfileDetailsRequest
        .builder
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getLaunchProfileDetailsResponse(
      launchProfile: Option[LaunchProfile] = None,
      streamingImages: Option[List[StreamingImage]] = None,
      studioComponentSummaries: Option[List[StudioComponentSummary]] = None
    ): GetLaunchProfileDetailsResponse =
      GetLaunchProfileDetailsResponse
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .ifSome(streamingImages)(_.streamingImages(_))
        .ifSome(studioComponentSummaries)(_.studioComponentSummaries(_))
        .build

    def getLaunchProfileInitializationOutput(
      launchProfileInitialization: Option[LaunchProfileInitialization] = None
    ): GetLaunchProfileInitializationOutput =
      GetLaunchProfileInitializationOutput
        .builder
        .ifSome(launchProfileInitialization)(_.launchProfileInitialization(_))
        .build

    def getLaunchProfileInitializationRequest(
      launchProfileId: Option[String] = None,
      launchProfileProtocolVersions: Option[List[__string]] = None,
      launchPurpose: Option[String] = None,
      platform: Option[String] = None,
      studioId: Option[String] = None
    ): GetLaunchProfileInitializationRequest =
      GetLaunchProfileInitializationRequest
        .builder
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(launchProfileProtocolVersions)(_.launchProfileProtocolVersions(_))
        .ifSome(launchPurpose)(_.launchPurpose(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getLaunchProfileInitializationResponse(
      launchProfileInitialization: Option[LaunchProfileInitialization] = None
    ): GetLaunchProfileInitializationResponse =
      GetLaunchProfileInitializationResponse
        .builder
        .ifSome(launchProfileInitialization)(_.launchProfileInitialization(_))
        .build

    def getLaunchProfileMemberOutput(
      member: Option[LaunchProfileMembership] = None
    ): GetLaunchProfileMemberOutput =
      GetLaunchProfileMemberOutput
        .builder
        .ifSome(member)(_.member(_))
        .build

    def getLaunchProfileMemberRequest(
      launchProfileId: Option[String] = None,
      principalId: Option[String] = None,
      studioId: Option[String] = None
    ): GetLaunchProfileMemberRequest =
      GetLaunchProfileMemberRequest
        .builder
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getLaunchProfileMemberResponse(
      member: Option[LaunchProfileMembership] = None
    ): GetLaunchProfileMemberResponse =
      GetLaunchProfileMemberResponse
        .builder
        .ifSome(member)(_.member(_))
        .build

    def getLaunchProfileOutput(
      launchProfile: Option[LaunchProfile] = None
    ): GetLaunchProfileOutput =
      GetLaunchProfileOutput
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def getLaunchProfileRequest(
      launchProfileId: Option[String] = None,
      studioId: Option[String] = None
    ): GetLaunchProfileRequest =
      GetLaunchProfileRequest
        .builder
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getLaunchProfileResponse(
      launchProfile: Option[LaunchProfile] = None
    ): GetLaunchProfileResponse =
      GetLaunchProfileResponse
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def getStreamingImageOutput(
      streamingImage: Option[StreamingImage] = None
    ): GetStreamingImageOutput =
      GetStreamingImageOutput
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def getStreamingImageRequest(
      streamingImageId: Option[String] = None,
      studioId: Option[String] = None
    ): GetStreamingImageRequest =
      GetStreamingImageRequest
        .builder
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getStreamingImageResponse(
      streamingImage: Option[StreamingImage] = None
    ): GetStreamingImageResponse =
      GetStreamingImageResponse
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def getStreamingSessionOutput(
      session: Option[StreamingSession] = None
    ): GetStreamingSessionOutput =
      GetStreamingSessionOutput
        .builder
        .ifSome(session)(_.session(_))
        .build

    def getStreamingSessionRequest(
      sessionId: Option[String] = None,
      studioId: Option[String] = None
    ): GetStreamingSessionRequest =
      GetStreamingSessionRequest
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getStreamingSessionResponse(
      session: Option[StreamingSession] = None
    ): GetStreamingSessionResponse =
      GetStreamingSessionResponse
        .builder
        .ifSome(session)(_.session(_))
        .build

    def getStreamingSessionStreamOutput(
      stream: Option[StreamingSessionStream] = None
    ): GetStreamingSessionStreamOutput =
      GetStreamingSessionStreamOutput
        .builder
        .ifSome(stream)(_.stream(_))
        .build

    def getStreamingSessionStreamRequest(
      sessionId: Option[String] = None,
      streamId: Option[String] = None,
      studioId: Option[String] = None
    ): GetStreamingSessionStreamRequest =
      GetStreamingSessionStreamRequest
        .builder
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getStreamingSessionStreamResponse(
      stream: Option[StreamingSessionStream] = None
    ): GetStreamingSessionStreamResponse =
      GetStreamingSessionStreamResponse
        .builder
        .ifSome(stream)(_.stream(_))
        .build

    def getStudioComponentOutput(
      studioComponent: Option[StudioComponent] = None
    ): GetStudioComponentOutput =
      GetStudioComponentOutput
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def getStudioComponentRequest(
      studioComponentId: Option[String] = None,
      studioId: Option[String] = None
    ): GetStudioComponentRequest =
      GetStudioComponentRequest
        .builder
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getStudioComponentResponse(
      studioComponent: Option[StudioComponent] = None
    ): GetStudioComponentResponse =
      GetStudioComponentResponse
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def getStudioMemberOutput(
      member: Option[StudioMembership] = None
    ): GetStudioMemberOutput =
      GetStudioMemberOutput
        .builder
        .ifSome(member)(_.member(_))
        .build

    def getStudioMemberRequest(
      principalId: Option[String] = None,
      studioId: Option[String] = None
    ): GetStudioMemberRequest =
      GetStudioMemberRequest
        .builder
        .ifSome(principalId)(_.principalId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def getStudioMemberResponse(
      member: Option[StudioMembership] = None
    ): GetStudioMemberResponse =
      GetStudioMemberResponse
        .builder
        .ifSome(member)(_.member(_))
        .build

    def getStudioOutput(
      studio: Option[Studio] = None
    ): GetStudioOutput =
      GetStudioOutput
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def getStudioRequest(
      studioId: Option[String] = None
    ): GetStudioRequest =
      GetStudioRequest
        .builder
        .ifSome(studioId)(_.studioId(_))
        .build

    def getStudioResponse(
      studio: Option[Studio] = None
    ): GetStudioResponse =
      GetStudioResponse
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def internalServerErrorException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

    def internalServerException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

    def launchProfile(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      description: Option[String] = None,
      ec2SubnetIds: Option[List[EC2SubnetId]] = None,
      launchProfileId: Option[String] = None,
      launchProfileProtocolVersions: Option[List[LaunchProfileProtocolVersion]] = None,
      name: Option[String] = None,
      state: Option[String] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      streamConfiguration: Option[StreamConfiguration] = None,
      studioComponentIds: Option[List[__string]] = None,
      tags: Option[Tags] = None,
      updatedAt: Option[Timestamp] = None,
      updatedBy: Option[String] = None
    ): LaunchProfile =
      LaunchProfile
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SubnetIds)(_.ec2SubnetIds(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(launchProfileProtocolVersions)(_.launchProfileProtocolVersions(_))
        .ifSome(name)(_.name(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(streamConfiguration)(_.streamConfiguration(_))
        .ifSome(studioComponentIds)(_.studioComponentIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(updatedBy)(_.updatedBy(_))
        .build

    def launchProfileInitialization(
      activeDirectory: Option[LaunchProfileInitializationActiveDirectory] = None,
      ec2SecurityGroupIds: Option[List[SecurityGroupId]] = None,
      launchProfileId: Option[String] = None,
      launchProfileProtocolVersion: Option[String] = None,
      launchPurpose: Option[String] = None,
      name: Option[String] = None,
      platform: Option[String] = None,
      systemInitializationScripts: Option[List[LaunchProfileInitializationScript]] = None,
      userInitializationScripts: Option[List[LaunchProfileInitializationScript]] = None
    ): LaunchProfileInitialization =
      LaunchProfileInitialization
        .builder
        .ifSome(activeDirectory)(_.activeDirectory(_))
        .ifSome(ec2SecurityGroupIds)(_.ec2SecurityGroupIds(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(launchProfileProtocolVersion)(_.launchProfileProtocolVersion(_))
        .ifSome(launchPurpose)(_.launchPurpose(_))
        .ifSome(name)(_.name(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(systemInitializationScripts)(_.systemInitializationScripts(_))
        .ifSome(userInitializationScripts)(_.userInitializationScripts(_))
        .build

    def launchProfileInitializationActiveDirectory(
      computerAttributes: Option[List[ActiveDirectoryComputerAttribute]] = None,
      directoryId: Option[String] = None,
      directoryName: Option[String] = None,
      dnsIpAddresses: Option[List[ActiveDirectoryDnsIpAddress]] = None,
      organizationalUnitDistinguishedName: Option[String] = None,
      studioComponentId: Option[String] = None,
      studioComponentName: Option[String] = None
    ): LaunchProfileInitializationActiveDirectory =
      LaunchProfileInitializationActiveDirectory
        .builder
        .ifSome(computerAttributes)(_.computerAttributes(_))
        .ifSome(directoryId)(_.directoryId(_))
        .ifSome(directoryName)(_.directoryName(_))
        .ifSome(dnsIpAddresses)(_.dnsIpAddresses(_))
        .ifSome(organizationalUnitDistinguishedName)(_.organizationalUnitDistinguishedName(_))
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(studioComponentName)(_.studioComponentName(_))
        .build

    def launchProfileInitializationScript(
      script: Option[String] = None,
      studioComponentId: Option[String] = None,
      studioComponentName: Option[String] = None
    ): LaunchProfileInitializationScript =
      LaunchProfileInitializationScript
        .builder
        .ifSome(script)(_.script(_))
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(studioComponentName)(_.studioComponentName(_))
        .build

    def launchProfileMembership(
      identityStoreId: Option[String] = None,
      persona: Option[String] = None,
      principalId: Option[String] = None
    ): LaunchProfileMembership =
      LaunchProfileMembership
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(persona)(_.persona(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def licenseServiceConfiguration(
      endpoint: Option[String] = None
    ): LicenseServiceConfiguration =
      LicenseServiceConfiguration
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .build

    def listEulaAcceptancesOutput(
      eulaAcceptances: Option[List[EulaAcceptance]] = None,
      nextToken: Option[String] = None
    ): ListEulaAcceptancesOutput =
      ListEulaAcceptancesOutput
        .builder
        .ifSome(eulaAcceptances)(_.eulaAcceptances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEulaAcceptancesRequest(
      eulaIds: Option[List[__string]] = None,
      nextToken: Option[String] = None,
      studioId: Option[String] = None
    ): ListEulaAcceptancesRequest =
      ListEulaAcceptancesRequest
        .builder
        .ifSome(eulaIds)(_.eulaIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def listEulaAcceptancesResponse(
      eulaAcceptances: Option[List[EulaAcceptance]] = None,
      nextToken: Option[String] = None
    ): ListEulaAcceptancesResponse =
      ListEulaAcceptancesResponse
        .builder
        .ifSome(eulaAcceptances)(_.eulaAcceptances(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEulasOutput(
      eulas: Option[List[Eula]] = None,
      nextToken: Option[String] = None
    ): ListEulasOutput =
      ListEulasOutput
        .builder
        .ifSome(eulas)(_.eulas(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEulasRequest(
      eulaIds: Option[List[__string]] = None,
      nextToken: Option[String] = None
    ): ListEulasRequest =
      ListEulasRequest
        .builder
        .ifSome(eulaIds)(_.eulaIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEulasResponse(
      eulas: Option[List[Eula]] = None,
      nextToken: Option[String] = None
    ): ListEulasResponse =
      ListEulasResponse
        .builder
        .ifSome(eulas)(_.eulas(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLaunchProfileMembersOutput(
      members: Option[List[LaunchProfileMembership]] = None,
      nextToken: Option[String] = None
    ): ListLaunchProfileMembersOutput =
      ListLaunchProfileMembersOutput
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLaunchProfileMembersRequest(
      launchProfileId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      studioId: Option[String] = None
    ): ListLaunchProfileMembersRequest =
      ListLaunchProfileMembersRequest
        .builder
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def listLaunchProfileMembersResponse(
      members: Option[List[LaunchProfileMembership]] = None,
      nextToken: Option[String] = None
    ): ListLaunchProfileMembersResponse =
      ListLaunchProfileMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLaunchProfilesOutput(
      launchProfiles: Option[List[LaunchProfile]] = None,
      nextToken: Option[String] = None
    ): ListLaunchProfilesOutput =
      ListLaunchProfilesOutput
        .builder
        .ifSome(launchProfiles)(_.launchProfiles(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLaunchProfilesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      principalId: Option[String] = None,
      states: Option[List[__string]] = None,
      studioId: Option[String] = None
    ): ListLaunchProfilesRequest =
      ListLaunchProfilesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(states)(_.states(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def listLaunchProfilesResponse(
      launchProfiles: Option[List[LaunchProfile]] = None,
      nextToken: Option[String] = None
    ): ListLaunchProfilesResponse =
      ListLaunchProfilesResponse
        .builder
        .ifSome(launchProfiles)(_.launchProfiles(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamingImagesOutput(
      nextToken: Option[String] = None,
      streamingImages: Option[List[StreamingImage]] = None
    ): ListStreamingImagesOutput =
      ListStreamingImagesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(streamingImages)(_.streamingImages(_))
        .build

    def listStreamingImagesRequest(
      nextToken: Option[String] = None,
      owner: Option[String] = None,
      studioId: Option[String] = None
    ): ListStreamingImagesRequest =
      ListStreamingImagesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def listStreamingImagesResponse(
      nextToken: Option[String] = None,
      streamingImages: Option[List[StreamingImage]] = None
    ): ListStreamingImagesResponse =
      ListStreamingImagesResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(streamingImages)(_.streamingImages(_))
        .build

    def listStreamingSessionsOutput(
      nextToken: Option[String] = None,
      sessions: Option[List[StreamingSession]] = None
    ): ListStreamingSessionsOutput =
      ListStreamingSessionsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sessions)(_.sessions(_))
        .build

    def listStreamingSessionsRequest(
      createdBy: Option[String] = None,
      nextToken: Option[String] = None,
      sessionIds: Option[String] = None,
      studioId: Option[String] = None
    ): ListStreamingSessionsRequest =
      ListStreamingSessionsRequest
        .builder
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sessionIds)(_.sessionIds(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def listStreamingSessionsResponse(
      nextToken: Option[String] = None,
      sessions: Option[List[StreamingSession]] = None
    ): ListStreamingSessionsResponse =
      ListStreamingSessionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sessions)(_.sessions(_))
        .build

    def listStudioComponentsOutput(
      nextToken: Option[String] = None,
      studioComponents: Option[List[StudioComponent]] = None
    ): ListStudioComponentsOutput =
      ListStudioComponentsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studioComponents)(_.studioComponents(_))
        .build

    def listStudioComponentsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      states: Option[List[__string]] = None,
      studioId: Option[String] = None,
      types: Option[List[__string]] = None
    ): ListStudioComponentsRequest =
      ListStudioComponentsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(states)(_.states(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(types)(_.types(_))
        .build

    def listStudioComponentsResponse(
      nextToken: Option[String] = None,
      studioComponents: Option[List[StudioComponent]] = None
    ): ListStudioComponentsResponse =
      ListStudioComponentsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studioComponents)(_.studioComponents(_))
        .build

    def listStudioMembersOutput(
      members: Option[List[StudioMembership]] = None,
      nextToken: Option[String] = None
    ): ListStudioMembersOutput =
      ListStudioMembersOutput
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStudioMembersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      studioId: Option[String] = None
    ): ListStudioMembersRequest =
      ListStudioMembersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def listStudioMembersResponse(
      members: Option[List[StudioMembership]] = None,
      nextToken: Option[String] = None
    ): ListStudioMembersResponse =
      ListStudioMembersResponse
        .builder
        .ifSome(members)(_.members(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStudiosOutput(
      nextToken: Option[String] = None,
      studios: Option[List[Studio]] = None
    ): ListStudiosOutput =
      ListStudiosOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studios)(_.studios(_))
        .build

    def listStudiosRequest(
      nextToken: Option[String] = None
    ): ListStudiosRequest =
      ListStudiosRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStudiosResponse(
      nextToken: Option[String] = None,
      studios: Option[List[Studio]] = None
    ): ListStudiosResponse =
      ListStudiosResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(studios)(_.studios(_))
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

    def listTagsOutput(
      tags: Option[Tags] = None
    ): ListTagsOutput =
      ListTagsOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def newLaunchProfileMember(
      persona: Option[String] = None,
      principalId: Option[String] = None
    ): NewLaunchProfileMember =
      NewLaunchProfileMember
        .builder
        .ifSome(persona)(_.persona(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def newStudioMember(
      persona: Option[String] = None,
      principalId: Option[String] = None
    ): NewStudioMember =
      NewStudioMember
        .builder
        .ifSome(persona)(_.persona(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def putLaunchProfileMembersInput(
      identityStoreId: Option[String] = None,
      members: Option[List[NewLaunchProfileMember]] = None
    ): PutLaunchProfileMembersInput =
      PutLaunchProfileMembersInput
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(members)(_.members(_))
        .build

    def putLaunchProfileMembersRequest(
      clientToken: Option[String] = None,
      identityStoreId: Option[String] = None,
      launchProfileId: Option[String] = None,
      members: Option[List[NewLaunchProfileMember]] = None,
      studioId: Option[String] = None
    ): PutLaunchProfileMembersRequest =
      PutLaunchProfileMembersRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(members)(_.members(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def putLaunchProfileMembersResponse(

    ): PutLaunchProfileMembersResponse =
      PutLaunchProfileMembersResponse
        .builder

        .build

    def putStudioMembersInput(
      identityStoreId: Option[String] = None,
      members: Option[List[NewStudioMember]] = None
    ): PutStudioMembersInput =
      PutStudioMembersInput
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(members)(_.members(_))
        .build

    def putStudioMembersOutput(

    ): PutStudioMembersOutput =
      PutStudioMembersOutput
        .builder

        .build

    def putStudioMembersRequest(
      clientToken: Option[String] = None,
      identityStoreId: Option[String] = None,
      members: Option[List[NewStudioMember]] = None,
      studioId: Option[String] = None
    ): PutStudioMembersRequest =
      PutStudioMembersRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(members)(_.members(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def putStudioMembersResponse(

    ): PutStudioMembersResponse =
      PutStudioMembersResponse
        .builder

        .build

    def resourceNotFoundException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

    def scriptParameterKeyValue(
      key: Option[String] = None,
      value: Option[String] = None
    ): ScriptParameterKeyValue =
      ScriptParameterKeyValue
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def serviceQuotaExceededException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

    def sharedFileSystemConfiguration(
      endpoint: Option[String] = None,
      fileSystemId: Option[String] = None,
      linuxMountPoint: Option[String] = None,
      shareName: Option[String] = None,
      windowsMountDrive: Option[String] = None
    ): SharedFileSystemConfiguration =
      SharedFileSystemConfiguration
        .builder
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(linuxMountPoint)(_.linuxMountPoint(_))
        .ifSome(shareName)(_.shareName(_))
        .ifSome(windowsMountDrive)(_.windowsMountDrive(_))
        .build

    def startStudioSSOConfigurationRepairOutput(
      studio: Option[Studio] = None
    ): StartStudioSSOConfigurationRepairOutput =
      StartStudioSSOConfigurationRepairOutput
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def startStudioSSOConfigurationRepairRequest(
      clientToken: Option[String] = None,
      studioId: Option[String] = None
    ): StartStudioSSOConfigurationRepairRequest =
      StartStudioSSOConfigurationRepairRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def startStudioSSOConfigurationRepairResponse(
      studio: Option[Studio] = None
    ): StartStudioSSOConfigurationRepairResponse =
      StartStudioSSOConfigurationRepairResponse
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def streamConfiguration(
      clipboardMode: Option[String] = None,
      ec2InstanceTypes: Option[List[StreamingInstanceType]] = None,
      maxSessionLengthInMinutes: Option[Int] = None,
      streamingImageIds: Option[List[StreamingImageId]] = None
    ): StreamConfiguration =
      StreamConfiguration
        .builder
        .ifSome(clipboardMode)(_.clipboardMode(_))
        .ifSome(ec2InstanceTypes)(_.ec2InstanceTypes(_))
        .ifSome(maxSessionLengthInMinutes)(_.maxSessionLengthInMinutes(_))
        .ifSome(streamingImageIds)(_.streamingImageIds(_))
        .build

    def streamConfigurationCreate(
      clipboardMode: Option[String] = None,
      ec2InstanceTypes: Option[List[StreamingInstanceType]] = None,
      maxSessionLengthInMinutes: Option[Int] = None,
      streamingImageIds: Option[List[StreamingImageId]] = None
    ): StreamConfigurationCreate =
      StreamConfigurationCreate
        .builder
        .ifSome(clipboardMode)(_.clipboardMode(_))
        .ifSome(ec2InstanceTypes)(_.ec2InstanceTypes(_))
        .ifSome(maxSessionLengthInMinutes)(_.maxSessionLengthInMinutes(_))
        .ifSome(streamingImageIds)(_.streamingImageIds(_))
        .build

    def streamingImage(
      arn: Option[String] = None,
      description: Option[String] = None,
      ec2ImageId: Option[String] = None,
      encryptionConfiguration: Option[StreamingImageEncryptionConfiguration] = None,
      eulaIds: Option[List[__string]] = None,
      name: Option[String] = None,
      owner: Option[String] = None,
      platform: Option[String] = None,
      state: Option[String] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      streamingImageId: Option[String] = None,
      tags: Option[Tags] = None
    ): StreamingImage =
      StreamingImage
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2ImageId)(_.ec2ImageId(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(eulaIds)(_.eulaIds(_))
        .ifSome(name)(_.name(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def streamingImageEncryptionConfiguration(
      keyArn: Option[String] = None,
      keyType: Option[String] = None
    ): StreamingImageEncryptionConfiguration =
      StreamingImageEncryptionConfiguration
        .builder
        .ifSome(keyArn)(_.keyArn(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def streamingSession(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      ec2InstanceType: Option[String] = None,
      launchProfileId: Option[String] = None,
      sessionId: Option[String] = None,
      state: Option[String] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      streamingImageId: Option[String] = None,
      tags: Option[Tags] = None,
      terminateAt: Option[Timestamp] = None,
      updatedAt: Option[Timestamp] = None,
      updatedBy: Option[String] = None
    ): StreamingSession =
      StreamingSession
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(ec2InstanceType)(_.ec2InstanceType(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(sessionId)(_.sessionId(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(terminateAt)(_.terminateAt(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(updatedBy)(_.updatedBy(_))
        .build

    def streamingSessionStream(
      createdAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      expiresAt: Option[Timestamp] = None,
      state: Option[String] = None,
      statusCode: Option[String] = None,
      streamId: Option[String] = None,
      url: Option[String] = None
    ): StreamingSessionStream =
      StreamingSessionStream
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(expiresAt)(_.expiresAt(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(streamId)(_.streamId(_))
        .ifSome(url)(_.url(_))
        .build

    def studio(
      adminRoleArn: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      displayName: Option[String] = None,
      homeRegion: Option[String] = None,
      ssoClientId: Option[String] = None,
      state: Option[String] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      studioEncryptionConfiguration: Option[StudioEncryptionConfiguration] = None,
      studioId: Option[String] = None,
      studioName: Option[String] = None,
      studioUrl: Option[String] = None,
      tags: Option[Tags] = None,
      updatedAt: Option[Timestamp] = None,
      userRoleArn: Option[String] = None
    ): Studio =
      Studio
        .builder
        .ifSome(adminRoleArn)(_.adminRoleArn(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(homeRegion)(_.homeRegion(_))
        .ifSome(ssoClientId)(_.ssoClientId(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(studioEncryptionConfiguration)(_.studioEncryptionConfiguration(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(studioName)(_.studioName(_))
        .ifSome(studioUrl)(_.studioUrl(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(userRoleArn)(_.userRoleArn(_))
        .build

    def studioComponent(
      arn: Option[String] = None,
      configuration: Option[StudioComponentConfiguration] = None,
      createdAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      description: Option[String] = None,
      ec2SecurityGroupIds: Option[List[SecurityGroupId]] = None,
      initializationScripts: Option[List[StudioComponentInitializationScript]] = None,
      name: Option[String] = None,
      scriptParameters: Option[List[ScriptParameterKeyValue]] = None,
      state: Option[String] = None,
      statusCode: Option[String] = None,
      statusMessage: Option[String] = None,
      studioComponentId: Option[String] = None,
      subtype: Option[String] = None,
      tags: Option[Tags] = None,
      `type`: Option[String] = None,
      updatedAt: Option[Timestamp] = None,
      updatedBy: Option[String] = None
    ): StudioComponent =
      StudioComponent
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SecurityGroupIds)(_.ec2SecurityGroupIds(_))
        .ifSome(initializationScripts)(_.initializationScripts(_))
        .ifSome(name)(_.name(_))
        .ifSome(scriptParameters)(_.scriptParameters(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(subtype)(_.subtype(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(updatedBy)(_.updatedBy(_))
        .build

    def studioComponentConfiguration(
      activeDirectoryConfiguration: Option[ActiveDirectoryConfiguration] = None,
      computeFarmConfiguration: Option[ComputeFarmConfiguration] = None,
      licenseServiceConfiguration: Option[LicenseServiceConfiguration] = None,
      sharedFileSystemConfiguration: Option[SharedFileSystemConfiguration] = None
    ): StudioComponentConfiguration =
      StudioComponentConfiguration
        .builder
        .ifSome(activeDirectoryConfiguration)(_.activeDirectoryConfiguration(_))
        .ifSome(computeFarmConfiguration)(_.computeFarmConfiguration(_))
        .ifSome(licenseServiceConfiguration)(_.licenseServiceConfiguration(_))
        .ifSome(sharedFileSystemConfiguration)(_.sharedFileSystemConfiguration(_))
        .build

    def studioComponentInitializationScript(
      launchProfileProtocolVersion: Option[String] = None,
      platform: Option[String] = None,
      runContext: Option[String] = None,
      script: Option[String] = None
    ): StudioComponentInitializationScript =
      StudioComponentInitializationScript
        .builder
        .ifSome(launchProfileProtocolVersion)(_.launchProfileProtocolVersion(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(runContext)(_.runContext(_))
        .ifSome(script)(_.script(_))
        .build

    def studioComponentSummary(
      createdAt: Option[Timestamp] = None,
      createdBy: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      studioComponentId: Option[String] = None,
      subtype: Option[String] = None,
      `type`: Option[String] = None,
      updatedAt: Option[Timestamp] = None,
      updatedBy: Option[String] = None
    ): StudioComponentSummary =
      StudioComponentSummary
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(subtype)(_.subtype(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .ifSome(updatedBy)(_.updatedBy(_))
        .build

    def studioEncryptionConfiguration(
      keyArn: Option[String] = None,
      keyType: Option[String] = None
    ): StudioEncryptionConfiguration =
      StudioEncryptionConfiguration
        .builder
        .ifSome(keyArn)(_.keyArn(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def studioMembership(
      identityStoreId: Option[String] = None,
      persona: Option[String] = None,
      principalId: Option[String] = None
    ): StudioMembership =
      StudioMembership
        .builder
        .ifSome(identityStoreId)(_.identityStoreId(_))
        .ifSome(persona)(_.persona(_))
        .ifSome(principalId)(_.principalId(_))
        .build

    def tagResourceInput(
      tags: Option[Tags] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(tags)(_.tags(_))
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

    def throttlingException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
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

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateLaunchProfileInput(
      description: Option[String] = None,
      launchProfileProtocolVersions: Option[List[LaunchProfileProtocolVersion]] = None,
      name: Option[String] = None,
      streamConfiguration: Option[StreamConfigurationCreate] = None,
      studioComponentIds: Option[List[__string]] = None
    ): UpdateLaunchProfileInput =
      UpdateLaunchProfileInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(launchProfileProtocolVersions)(_.launchProfileProtocolVersions(_))
        .ifSome(name)(_.name(_))
        .ifSome(streamConfiguration)(_.streamConfiguration(_))
        .ifSome(studioComponentIds)(_.studioComponentIds(_))
        .build

    def updateLaunchProfileMemberInput(
      persona: Option[String] = None
    ): UpdateLaunchProfileMemberInput =
      UpdateLaunchProfileMemberInput
        .builder
        .ifSome(persona)(_.persona(_))
        .build

    def updateLaunchProfileMemberRequest(
      clientToken: Option[String] = None,
      launchProfileId: Option[String] = None,
      persona: Option[String] = None,
      principalId: Option[String] = None,
      studioId: Option[String] = None
    ): UpdateLaunchProfileMemberRequest =
      UpdateLaunchProfileMemberRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(persona)(_.persona(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def updateLaunchProfileMemberResponse(
      member: Option[LaunchProfileMembership] = None
    ): UpdateLaunchProfileMemberResponse =
      UpdateLaunchProfileMemberResponse
        .builder
        .ifSome(member)(_.member(_))
        .build

    def updateLaunchProfileOutput(
      launchProfile: Option[LaunchProfile] = None
    ): UpdateLaunchProfileOutput =
      UpdateLaunchProfileOutput
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def updateLaunchProfileRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      launchProfileId: Option[String] = None,
      launchProfileProtocolVersions: Option[List[LaunchProfileProtocolVersion]] = None,
      name: Option[String] = None,
      streamConfiguration: Option[StreamConfigurationCreate] = None,
      studioComponentIds: Option[List[__string]] = None,
      studioId: Option[String] = None
    ): UpdateLaunchProfileRequest =
      UpdateLaunchProfileRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(launchProfileId)(_.launchProfileId(_))
        .ifSome(launchProfileProtocolVersions)(_.launchProfileProtocolVersions(_))
        .ifSome(name)(_.name(_))
        .ifSome(streamConfiguration)(_.streamConfiguration(_))
        .ifSome(studioComponentIds)(_.studioComponentIds(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def updateLaunchProfileResponse(
      launchProfile: Option[LaunchProfile] = None
    ): UpdateLaunchProfileResponse =
      UpdateLaunchProfileResponse
        .builder
        .ifSome(launchProfile)(_.launchProfile(_))
        .build

    def updateStreamingImageInput(
      description: Option[String] = None,
      name: Option[String] = None
    ): UpdateStreamingImageInput =
      UpdateStreamingImageInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .build

    def updateStreamingImageOutput(
      streamingImage: Option[StreamingImage] = None
    ): UpdateStreamingImageOutput =
      UpdateStreamingImageOutput
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def updateStreamingImageRequest(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      streamingImageId: Option[String] = None,
      studioId: Option[String] = None
    ): UpdateStreamingImageRequest =
      UpdateStreamingImageRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(streamingImageId)(_.streamingImageId(_))
        .ifSome(studioId)(_.studioId(_))
        .build

    def updateStreamingImageResponse(
      streamingImage: Option[StreamingImage] = None
    ): UpdateStreamingImageResponse =
      UpdateStreamingImageResponse
        .builder
        .ifSome(streamingImage)(_.streamingImage(_))
        .build

    def updateStudioComponentInput(
      configuration: Option[StudioComponentConfiguration] = None,
      description: Option[String] = None,
      ec2SecurityGroupIds: Option[List[SecurityGroupId]] = None,
      initializationScripts: Option[List[StudioComponentInitializationScript]] = None,
      name: Option[String] = None,
      scriptParameters: Option[List[ScriptParameterKeyValue]] = None,
      subtype: Option[String] = None,
      `type`: Option[String] = None
    ): UpdateStudioComponentInput =
      UpdateStudioComponentInput
        .builder
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SecurityGroupIds)(_.ec2SecurityGroupIds(_))
        .ifSome(initializationScripts)(_.initializationScripts(_))
        .ifSome(name)(_.name(_))
        .ifSome(scriptParameters)(_.scriptParameters(_))
        .ifSome(subtype)(_.subtype(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def updateStudioComponentOutput(
      studioComponent: Option[StudioComponent] = None
    ): UpdateStudioComponentOutput =
      UpdateStudioComponentOutput
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def updateStudioComponentRequest(
      clientToken: Option[String] = None,
      configuration: Option[StudioComponentConfiguration] = None,
      description: Option[String] = None,
      ec2SecurityGroupIds: Option[List[SecurityGroupId]] = None,
      initializationScripts: Option[List[StudioComponentInitializationScript]] = None,
      name: Option[String] = None,
      scriptParameters: Option[List[ScriptParameterKeyValue]] = None,
      studioComponentId: Option[String] = None,
      studioId: Option[String] = None,
      subtype: Option[String] = None,
      `type`: Option[String] = None
    ): UpdateStudioComponentRequest =
      UpdateStudioComponentRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(description)(_.description(_))
        .ifSome(ec2SecurityGroupIds)(_.ec2SecurityGroupIds(_))
        .ifSome(initializationScripts)(_.initializationScripts(_))
        .ifSome(name)(_.name(_))
        .ifSome(scriptParameters)(_.scriptParameters(_))
        .ifSome(studioComponentId)(_.studioComponentId(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(subtype)(_.subtype(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def updateStudioComponentResponse(
      studioComponent: Option[StudioComponent] = None
    ): UpdateStudioComponentResponse =
      UpdateStudioComponentResponse
        .builder
        .ifSome(studioComponent)(_.studioComponent(_))
        .build

    def updateStudioInput(
      adminRoleArn: Option[String] = None,
      displayName: Option[String] = None,
      userRoleArn: Option[String] = None
    ): UpdateStudioInput =
      UpdateStudioInput
        .builder
        .ifSome(adminRoleArn)(_.adminRoleArn(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(userRoleArn)(_.userRoleArn(_))
        .build

    def updateStudioOutput(
      studio: Option[Studio] = None
    ): UpdateStudioOutput =
      UpdateStudioOutput
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def updateStudioRequest(
      adminRoleArn: Option[String] = None,
      clientToken: Option[String] = None,
      displayName: Option[String] = None,
      studioId: Option[String] = None,
      userRoleArn: Option[String] = None
    ): UpdateStudioRequest =
      UpdateStudioRequest
        .builder
        .ifSome(adminRoleArn)(_.adminRoleArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(studioId)(_.studioId(_))
        .ifSome(userRoleArn)(_.userRoleArn(_))
        .build

    def updateStudioResponse(
      studio: Option[Studio] = None
    ): UpdateStudioResponse =
      UpdateStudioResponse
        .builder
        .ifSome(studio)(_.studio(_))
        .build

    def validationException(
      code: Option[String] = None,
      context: Option[ExceptionContext] = None,
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(context)(_.context(_))
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
