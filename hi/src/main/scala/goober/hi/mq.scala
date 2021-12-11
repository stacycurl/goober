package goober.hi

import goober.free.mq.MqIO
import software.amazon.awssdk.services.mq.model._


object mq {
  import goober.free.{mq ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def availabilityZone(
      name: Option[String] = None
    ): AvailabilityZone =
      AvailabilityZone
        .builder
        .ifSome(name)(_.name(_))
        .build

    def badRequestException(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def brokerEngineType(
      engineType: Option[String] = None,
      engineVersions: Option[List[EngineVersion]] = None
    ): BrokerEngineType =
      BrokerEngineType
        .builder
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersions)(_.engineVersions(_))
        .build

    def brokerEngineTypeOutput(
      brokerEngineTypes: Option[List[BrokerEngineType]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): BrokerEngineTypeOutput =
      BrokerEngineTypeOutput
        .builder
        .ifSome(brokerEngineTypes)(_.brokerEngineTypes(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def brokerInstance(
      consoleURL: Option[String] = None,
      endpoints: Option[List[__string]] = None,
      ipAddress: Option[String] = None
    ): BrokerInstance =
      BrokerInstance
        .builder
        .ifSome(consoleURL)(_.consoleURL(_))
        .ifSome(endpoints)(_.endpoints(_))
        .ifSome(ipAddress)(_.ipAddress(_))
        .build

    def brokerInstanceOption(
      availabilityZones: Option[List[AvailabilityZone]] = None,
      engineType: Option[String] = None,
      hostInstanceType: Option[String] = None,
      storageType: Option[String] = None,
      supportedDeploymentModes: Option[List[DeploymentMode]] = None,
      supportedEngineVersions: Option[List[__string]] = None
    ): BrokerInstanceOption =
      BrokerInstanceOption
        .builder
        .ifSome(availabilityZones)(_.availabilityZones(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(supportedDeploymentModes)(_.supportedDeploymentModes(_))
        .ifSome(supportedEngineVersions)(_.supportedEngineVersions(_))
        .build

    def brokerInstanceOptionsOutput(
      brokerInstanceOptions: Option[List[BrokerInstanceOption]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): BrokerInstanceOptionsOutput =
      BrokerInstanceOptionsOutput
        .builder
        .ifSome(brokerInstanceOptions)(_.brokerInstanceOptions(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def brokerSummary(
      brokerArn: Option[String] = None,
      brokerId: Option[String] = None,
      brokerName: Option[String] = None,
      brokerState: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      deploymentMode: Option[String] = None,
      engineType: Option[String] = None,
      hostInstanceType: Option[String] = None
    ): BrokerSummary =
      BrokerSummary
        .builder
        .ifSome(brokerArn)(_.brokerArn(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(brokerName)(_.brokerName(_))
        .ifSome(brokerState)(_.brokerState(_))
        .ifSome(created)(_.created(_))
        .ifSome(deploymentMode)(_.deploymentMode(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .build

    def configuration(
      arn: Option[String] = None,
      authenticationStrategy: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      id: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(created)(_.created(_))
        .ifSome(description)(_.description(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(id)(_.id(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def configurationId(
      id: Option[String] = None,
      revision: Option[Int] = None
    ): ConfigurationId =
      ConfigurationId
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(revision)(_.revision(_))
        .build

    def configurationRevision(
      created: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      revision: Option[Int] = None
    ): ConfigurationRevision =
      ConfigurationRevision
        .builder
        .ifSome(created)(_.created(_))
        .ifSome(description)(_.description(_))
        .ifSome(revision)(_.revision(_))
        .build

    def configurations(
      current: Option[ConfigurationId] = None,
      history: Option[List[ConfigurationId]] = None,
      pending: Option[ConfigurationId] = None
    ): Configurations =
      Configurations
        .builder
        .ifSome(current)(_.current(_))
        .ifSome(history)(_.history(_))
        .ifSome(pending)(_.pending(_))
        .build

    def conflictException(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def createBrokerInput(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerName: Option[String] = None,
      configuration: Option[ConfigurationId] = None,
      creatorRequestId: Option[String] = None,
      deploymentMode: Option[String] = None,
      encryptionOptions: Option[EncryptionOptions] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataInput] = None,
      logs: Option[Logs] = None,
      maintenanceWindowStartTime: Option[WeeklyStartTime] = None,
      publiclyAccessible: Option[Boolean] = None,
      securityGroups: Option[List[__string]] = None,
      storageType: Option[String] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[__mapOf__string] = None,
      users: Option[List[User]] = None
    ): CreateBrokerInput =
      CreateBrokerInput
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerName)(_.brokerName(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(deploymentMode)(_.deploymentMode(_))
        .ifSome(encryptionOptions)(_.encryptionOptions(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(maintenanceWindowStartTime)(_.maintenanceWindowStartTime(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(users)(_.users(_))
        .build

    def createBrokerOutput(
      brokerArn: Option[String] = None,
      brokerId: Option[String] = None
    ): CreateBrokerOutput =
      CreateBrokerOutput
        .builder
        .ifSome(brokerArn)(_.brokerArn(_))
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def createBrokerRequest(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerName: Option[String] = None,
      configuration: Option[ConfigurationId] = None,
      creatorRequestId: Option[String] = None,
      deploymentMode: Option[String] = None,
      encryptionOptions: Option[EncryptionOptions] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataInput] = None,
      logs: Option[Logs] = None,
      maintenanceWindowStartTime: Option[WeeklyStartTime] = None,
      publiclyAccessible: Option[Boolean] = None,
      securityGroups: Option[List[__string]] = None,
      storageType: Option[String] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[__mapOf__string] = None,
      users: Option[List[User]] = None
    ): CreateBrokerRequest =
      CreateBrokerRequest
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerName)(_.brokerName(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(deploymentMode)(_.deploymentMode(_))
        .ifSome(encryptionOptions)(_.encryptionOptions(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(maintenanceWindowStartTime)(_.maintenanceWindowStartTime(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(users)(_.users(_))
        .build

    def createBrokerResponse(
      brokerArn: Option[String] = None,
      brokerId: Option[String] = None
    ): CreateBrokerResponse =
      CreateBrokerResponse
        .builder
        .ifSome(brokerArn)(_.brokerArn(_))
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def createConfigurationInput(
      authenticationStrategy: Option[String] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      name: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateConfigurationInput =
      CreateConfigurationInput
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConfigurationOutput(
      arn: Option[String] = None,
      authenticationStrategy: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      id: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None
    ): CreateConfigurationOutput =
      CreateConfigurationOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(created)(_.created(_))
        .ifSome(id)(_.id(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .build

    def createConfigurationRequest(
      authenticationStrategy: Option[String] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      name: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateConfigurationRequest =
      CreateConfigurationRequest
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConfigurationResponse(
      arn: Option[String] = None,
      authenticationStrategy: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      id: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None
    ): CreateConfigurationResponse =
      CreateConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(created)(_.created(_))
        .ifSome(id)(_.id(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .build

    def createTagsRequest(
      resourceArn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): CreateTagsRequest =
      CreateTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createUserInput(
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      password: Option[String] = None
    ): CreateUserInput =
      CreateUserInput
        .builder
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(password)(_.password(_))
        .build

    def createUserRequest(
      brokerId: Option[String] = None,
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      password: Option[String] = None,
      username: Option[String] = None
    ): CreateUserRequest =
      CreateUserRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(password)(_.password(_))
        .ifSome(username)(_.username(_))
        .build

    def createUserResponse(

    ): CreateUserResponse =
      CreateUserResponse
        .builder

        .build

    def deleteBrokerOutput(
      brokerId: Option[String] = None
    ): DeleteBrokerOutput =
      DeleteBrokerOutput
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def deleteBrokerRequest(
      brokerId: Option[String] = None
    ): DeleteBrokerRequest =
      DeleteBrokerRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def deleteBrokerResponse(
      brokerId: Option[String] = None
    ): DeleteBrokerResponse =
      DeleteBrokerResponse
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def deleteTagsRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): DeleteTagsRequest =
      DeleteTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def deleteUserRequest(
      brokerId: Option[String] = None,
      username: Option[String] = None
    ): DeleteUserRequest =
      DeleteUserRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(username)(_.username(_))
        .build

    def deleteUserResponse(

    ): DeleteUserResponse =
      DeleteUserResponse
        .builder

        .build

    def describeBrokerEngineTypesRequest(
      engineType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBrokerEngineTypesRequest =
      DescribeBrokerEngineTypesRequest
        .builder
        .ifSome(engineType)(_.engineType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBrokerEngineTypesResponse(
      brokerEngineTypes: Option[List[BrokerEngineType]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBrokerEngineTypesResponse =
      DescribeBrokerEngineTypesResponse
        .builder
        .ifSome(brokerEngineTypes)(_.brokerEngineTypes(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBrokerInstanceOptionsRequest(
      engineType: Option[String] = None,
      hostInstanceType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      storageType: Option[String] = None
    ): DescribeBrokerInstanceOptionsRequest =
      DescribeBrokerInstanceOptionsRequest
        .builder
        .ifSome(engineType)(_.engineType(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(storageType)(_.storageType(_))
        .build

    def describeBrokerInstanceOptionsResponse(
      brokerInstanceOptions: Option[List[BrokerInstanceOption]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBrokerInstanceOptionsResponse =
      DescribeBrokerInstanceOptionsResponse
        .builder
        .ifSome(brokerInstanceOptions)(_.brokerInstanceOptions(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBrokerOutput(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerArn: Option[String] = None,
      brokerId: Option[String] = None,
      brokerInstances: Option[List[BrokerInstance]] = None,
      brokerName: Option[String] = None,
      brokerState: Option[String] = None,
      configurations: Option[Configurations] = None,
      created: Option[__timestampIso8601] = None,
      deploymentMode: Option[String] = None,
      encryptionOptions: Option[EncryptionOptions] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataOutput] = None,
      logs: Option[LogsSummary] = None,
      maintenanceWindowStartTime: Option[WeeklyStartTime] = None,
      pendingAuthenticationStrategy: Option[String] = None,
      pendingEngineVersion: Option[String] = None,
      pendingHostInstanceType: Option[String] = None,
      pendingLdapServerMetadata: Option[LdapServerMetadataOutput] = None,
      pendingSecurityGroups: Option[List[__string]] = None,
      publiclyAccessible: Option[Boolean] = None,
      securityGroups: Option[List[__string]] = None,
      storageType: Option[String] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[__mapOf__string] = None,
      users: Option[List[UserSummary]] = None
    ): DescribeBrokerOutput =
      DescribeBrokerOutput
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerArn)(_.brokerArn(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(brokerInstances)(_.brokerInstances(_))
        .ifSome(brokerName)(_.brokerName(_))
        .ifSome(brokerState)(_.brokerState(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(created)(_.created(_))
        .ifSome(deploymentMode)(_.deploymentMode(_))
        .ifSome(encryptionOptions)(_.encryptionOptions(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(maintenanceWindowStartTime)(_.maintenanceWindowStartTime(_))
        .ifSome(pendingAuthenticationStrategy)(_.pendingAuthenticationStrategy(_))
        .ifSome(pendingEngineVersion)(_.pendingEngineVersion(_))
        .ifSome(pendingHostInstanceType)(_.pendingHostInstanceType(_))
        .ifSome(pendingLdapServerMetadata)(_.pendingLdapServerMetadata(_))
        .ifSome(pendingSecurityGroups)(_.pendingSecurityGroups(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(users)(_.users(_))
        .build

    def describeBrokerRequest(
      brokerId: Option[String] = None
    ): DescribeBrokerRequest =
      DescribeBrokerRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def describeBrokerResponse(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerArn: Option[String] = None,
      brokerId: Option[String] = None,
      brokerInstances: Option[List[BrokerInstance]] = None,
      brokerName: Option[String] = None,
      brokerState: Option[String] = None,
      configurations: Option[Configurations] = None,
      created: Option[__timestampIso8601] = None,
      deploymentMode: Option[String] = None,
      encryptionOptions: Option[EncryptionOptions] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataOutput] = None,
      logs: Option[LogsSummary] = None,
      maintenanceWindowStartTime: Option[WeeklyStartTime] = None,
      pendingAuthenticationStrategy: Option[String] = None,
      pendingEngineVersion: Option[String] = None,
      pendingHostInstanceType: Option[String] = None,
      pendingLdapServerMetadata: Option[LdapServerMetadataOutput] = None,
      pendingSecurityGroups: Option[List[__string]] = None,
      publiclyAccessible: Option[Boolean] = None,
      securityGroups: Option[List[__string]] = None,
      storageType: Option[String] = None,
      subnetIds: Option[List[__string]] = None,
      tags: Option[__mapOf__string] = None,
      users: Option[List[UserSummary]] = None
    ): DescribeBrokerResponse =
      DescribeBrokerResponse
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerArn)(_.brokerArn(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(brokerInstances)(_.brokerInstances(_))
        .ifSome(brokerName)(_.brokerName(_))
        .ifSome(brokerState)(_.brokerState(_))
        .ifSome(configurations)(_.configurations(_))
        .ifSome(created)(_.created(_))
        .ifSome(deploymentMode)(_.deploymentMode(_))
        .ifSome(encryptionOptions)(_.encryptionOptions(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(maintenanceWindowStartTime)(_.maintenanceWindowStartTime(_))
        .ifSome(pendingAuthenticationStrategy)(_.pendingAuthenticationStrategy(_))
        .ifSome(pendingEngineVersion)(_.pendingEngineVersion(_))
        .ifSome(pendingHostInstanceType)(_.pendingHostInstanceType(_))
        .ifSome(pendingLdapServerMetadata)(_.pendingLdapServerMetadata(_))
        .ifSome(pendingSecurityGroups)(_.pendingSecurityGroups(_))
        .ifSome(publiclyAccessible)(_.publiclyAccessible(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(users)(_.users(_))
        .build

    def describeConfigurationRequest(
      configurationId: Option[String] = None
    ): DescribeConfigurationRequest =
      DescribeConfigurationRequest
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .build

    def describeConfigurationResponse(
      arn: Option[String] = None,
      authenticationStrategy: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      description: Option[String] = None,
      engineType: Option[String] = None,
      engineVersion: Option[String] = None,
      id: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): DescribeConfigurationResponse =
      DescribeConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(created)(_.created(_))
        .ifSome(description)(_.description(_))
        .ifSome(engineType)(_.engineType(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(id)(_.id(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeConfigurationRevisionOutput(
      configurationId: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      data: Option[String] = None,
      description: Option[String] = None
    ): DescribeConfigurationRevisionOutput =
      DescribeConfigurationRevisionOutput
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(created)(_.created(_))
        .ifSome(data)(_.data(_))
        .ifSome(description)(_.description(_))
        .build

    def describeConfigurationRevisionRequest(
      configurationId: Option[String] = None,
      configurationRevision: Option[String] = None
    ): DescribeConfigurationRevisionRequest =
      DescribeConfigurationRevisionRequest
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(configurationRevision)(_.configurationRevision(_))
        .build

    def describeConfigurationRevisionResponse(
      configurationId: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      data: Option[String] = None,
      description: Option[String] = None
    ): DescribeConfigurationRevisionResponse =
      DescribeConfigurationRevisionResponse
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(created)(_.created(_))
        .ifSome(data)(_.data(_))
        .ifSome(description)(_.description(_))
        .build

    def describeUserOutput(
      brokerId: Option[String] = None,
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      pending: Option[UserPendingChanges] = None,
      username: Option[String] = None
    ): DescribeUserOutput =
      DescribeUserOutput
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(pending)(_.pending(_))
        .ifSome(username)(_.username(_))
        .build

    def describeUserRequest(
      brokerId: Option[String] = None,
      username: Option[String] = None
    ): DescribeUserRequest =
      DescribeUserRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(username)(_.username(_))
        .build

    def describeUserResponse(
      brokerId: Option[String] = None,
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      pending: Option[UserPendingChanges] = None,
      username: Option[String] = None
    ): DescribeUserResponse =
      DescribeUserResponse
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(pending)(_.pending(_))
        .ifSome(username)(_.username(_))
        .build

    def encryptionOptions(
      kmsKeyId: Option[String] = None,
      useAwsOwnedKey: Option[Boolean] = None
    ): EncryptionOptions =
      EncryptionOptions
        .builder
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(useAwsOwnedKey)(_.useAwsOwnedKey(_))
        .build

    def engineVersion(
      name: Option[String] = None
    ): EngineVersion =
      EngineVersion
        .builder
        .ifSome(name)(_.name(_))
        .build

    def error(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): Error =
      Error
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def forbiddenException(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def internalServerErrorException(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def ldapServerMetadataInput(
      hosts: Option[List[__string]] = None,
      roleBase: Option[String] = None,
      roleName: Option[String] = None,
      roleSearchMatching: Option[String] = None,
      roleSearchSubtree: Option[Boolean] = None,
      serviceAccountPassword: Option[String] = None,
      serviceAccountUsername: Option[String] = None,
      userBase: Option[String] = None,
      userRoleName: Option[String] = None,
      userSearchMatching: Option[String] = None,
      userSearchSubtree: Option[Boolean] = None
    ): LdapServerMetadataInput =
      LdapServerMetadataInput
        .builder
        .ifSome(hosts)(_.hosts(_))
        .ifSome(roleBase)(_.roleBase(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(roleSearchMatching)(_.roleSearchMatching(_))
        .ifSome(roleSearchSubtree)(_.roleSearchSubtree(_))
        .ifSome(serviceAccountPassword)(_.serviceAccountPassword(_))
        .ifSome(serviceAccountUsername)(_.serviceAccountUsername(_))
        .ifSome(userBase)(_.userBase(_))
        .ifSome(userRoleName)(_.userRoleName(_))
        .ifSome(userSearchMatching)(_.userSearchMatching(_))
        .ifSome(userSearchSubtree)(_.userSearchSubtree(_))
        .build

    def ldapServerMetadataOutput(
      hosts: Option[List[__string]] = None,
      roleBase: Option[String] = None,
      roleName: Option[String] = None,
      roleSearchMatching: Option[String] = None,
      roleSearchSubtree: Option[Boolean] = None,
      serviceAccountUsername: Option[String] = None,
      userBase: Option[String] = None,
      userRoleName: Option[String] = None,
      userSearchMatching: Option[String] = None,
      userSearchSubtree: Option[Boolean] = None
    ): LdapServerMetadataOutput =
      LdapServerMetadataOutput
        .builder
        .ifSome(hosts)(_.hosts(_))
        .ifSome(roleBase)(_.roleBase(_))
        .ifSome(roleName)(_.roleName(_))
        .ifSome(roleSearchMatching)(_.roleSearchMatching(_))
        .ifSome(roleSearchSubtree)(_.roleSearchSubtree(_))
        .ifSome(serviceAccountUsername)(_.serviceAccountUsername(_))
        .ifSome(userBase)(_.userBase(_))
        .ifSome(userRoleName)(_.userRoleName(_))
        .ifSome(userSearchMatching)(_.userSearchMatching(_))
        .ifSome(userSearchSubtree)(_.userSearchSubtree(_))
        .build

    def listBrokersOutput(
      brokerSummaries: Option[List[BrokerSummary]] = None,
      nextToken: Option[String] = None
    ): ListBrokersOutput =
      ListBrokersOutput
        .builder
        .ifSome(brokerSummaries)(_.brokerSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBrokersRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListBrokersRequest =
      ListBrokersRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBrokersResponse(
      brokerSummaries: Option[List[BrokerSummary]] = None,
      nextToken: Option[String] = None
    ): ListBrokersResponse =
      ListBrokersResponse
        .builder
        .ifSome(brokerSummaries)(_.brokerSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationRevisionsOutput(
      configurationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      revisions: Option[List[ConfigurationRevision]] = None
    ): ListConfigurationRevisionsOutput =
      ListConfigurationRevisionsOutput
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(revisions)(_.revisions(_))
        .build

    def listConfigurationRevisionsRequest(
      configurationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationRevisionsRequest =
      ListConfigurationRevisionsRequest
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationRevisionsResponse(
      configurationId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      revisions: Option[List[ConfigurationRevision]] = None
    ): ListConfigurationRevisionsResponse =
      ListConfigurationRevisionsResponse
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(revisions)(_.revisions(_))
        .build

    def listConfigurationsOutput(
      configurations: Option[List[Configuration]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationsOutput =
      ListConfigurationsOutput
        .builder
        .ifSome(configurations)(_.configurations(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationsRequest =
      ListConfigurationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConfigurationsResponse(
      configurations: Option[List[Configuration]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListConfigurationsResponse =
      ListConfigurationsResponse
        .builder
        .ifSome(configurations)(_.configurations(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsRequest(
      resourceArn: Option[String] = None
    ): ListTagsRequest =
      ListTagsRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsResponse(
      tags: Option[__mapOf__string] = None
    ): ListTagsResponse =
      ListTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def listUsersOutput(
      brokerId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      users: Option[List[UserSummary]] = None
    ): ListUsersOutput =
      ListUsersOutput
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(users)(_.users(_))
        .build

    def listUsersRequest(
      brokerId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListUsersRequest =
      ListUsersRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listUsersResponse(
      brokerId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      users: Option[List[UserSummary]] = None
    ): ListUsersResponse =
      ListUsersResponse
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(users)(_.users(_))
        .build

    def logs(
      audit: Option[Boolean] = None,
      general: Option[Boolean] = None
    ): Logs =
      Logs
        .builder
        .ifSome(audit)(_.audit(_))
        .ifSome(general)(_.general(_))
        .build

    def logsSummary(
      audit: Option[Boolean] = None,
      auditLogGroup: Option[String] = None,
      general: Option[Boolean] = None,
      generalLogGroup: Option[String] = None,
      pending: Option[PendingLogs] = None
    ): LogsSummary =
      LogsSummary
        .builder
        .ifSome(audit)(_.audit(_))
        .ifSome(auditLogGroup)(_.auditLogGroup(_))
        .ifSome(general)(_.general(_))
        .ifSome(generalLogGroup)(_.generalLogGroup(_))
        .ifSome(pending)(_.pending(_))
        .build

    def notFoundException(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def pendingLogs(
      audit: Option[Boolean] = None,
      general: Option[Boolean] = None
    ): PendingLogs =
      PendingLogs
        .builder
        .ifSome(audit)(_.audit(_))
        .ifSome(general)(_.general(_))
        .build

    def rebootBrokerRequest(
      brokerId: Option[String] = None
    ): RebootBrokerRequest =
      RebootBrokerRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .build

    def rebootBrokerResponse(

    ): RebootBrokerResponse =
      RebootBrokerResponse
        .builder

        .build

    def sanitizationWarning(
      attributeName: Option[String] = None,
      elementName: Option[String] = None,
      reason: Option[String] = None
    ): SanitizationWarning =
      SanitizationWarning
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(elementName)(_.elementName(_))
        .ifSome(reason)(_.reason(_))
        .build

    def tags(
      tags: Option[__mapOf__string] = None
    ): Tags =
      Tags
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def unauthorizedException(
      errorAttribute: Option[String] = None,
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(errorAttribute)(_.errorAttribute(_))
        .ifSome(message)(_.message(_))
        .build

    def updateBrokerInput(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      configuration: Option[ConfigurationId] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataInput] = None,
      logs: Option[Logs] = None,
      securityGroups: Option[List[__string]] = None
    ): UpdateBrokerInput =
      UpdateBrokerInput
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def updateBrokerOutput(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerId: Option[String] = None,
      configuration: Option[ConfigurationId] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataOutput] = None,
      logs: Option[Logs] = None,
      securityGroups: Option[List[__string]] = None
    ): UpdateBrokerOutput =
      UpdateBrokerOutput
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def updateBrokerRequest(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerId: Option[String] = None,
      configuration: Option[ConfigurationId] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataInput] = None,
      logs: Option[Logs] = None,
      securityGroups: Option[List[__string]] = None
    ): UpdateBrokerRequest =
      UpdateBrokerRequest
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def updateBrokerResponse(
      authenticationStrategy: Option[String] = None,
      autoMinorVersionUpgrade: Option[Boolean] = None,
      brokerId: Option[String] = None,
      configuration: Option[ConfigurationId] = None,
      engineVersion: Option[String] = None,
      hostInstanceType: Option[String] = None,
      ldapServerMetadata: Option[LdapServerMetadataOutput] = None,
      logs: Option[Logs] = None,
      securityGroups: Option[List[__string]] = None
    ): UpdateBrokerResponse =
      UpdateBrokerResponse
        .builder
        .ifSome(authenticationStrategy)(_.authenticationStrategy(_))
        .ifSome(autoMinorVersionUpgrade)(_.autoMinorVersionUpgrade(_))
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(configuration)(_.configuration(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(hostInstanceType)(_.hostInstanceType(_))
        .ifSome(ldapServerMetadata)(_.ldapServerMetadata(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .build

    def updateConfigurationInput(
      data: Option[String] = None,
      description: Option[String] = None
    ): UpdateConfigurationInput =
      UpdateConfigurationInput
        .builder
        .ifSome(data)(_.data(_))
        .ifSome(description)(_.description(_))
        .build

    def updateConfigurationOutput(
      arn: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      id: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      warnings: Option[List[SanitizationWarning]] = None
    ): UpdateConfigurationOutput =
      UpdateConfigurationOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(created)(_.created(_))
        .ifSome(id)(_.id(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def updateConfigurationRequest(
      configurationId: Option[String] = None,
      data: Option[String] = None,
      description: Option[String] = None
    ): UpdateConfigurationRequest =
      UpdateConfigurationRequest
        .builder
        .ifSome(configurationId)(_.configurationId(_))
        .ifSome(data)(_.data(_))
        .ifSome(description)(_.description(_))
        .build

    def updateConfigurationResponse(
      arn: Option[String] = None,
      created: Option[__timestampIso8601] = None,
      id: Option[String] = None,
      latestRevision: Option[ConfigurationRevision] = None,
      name: Option[String] = None,
      warnings: Option[List[SanitizationWarning]] = None
    ): UpdateConfigurationResponse =
      UpdateConfigurationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(created)(_.created(_))
        .ifSome(id)(_.id(_))
        .ifSome(latestRevision)(_.latestRevision(_))
        .ifSome(name)(_.name(_))
        .ifSome(warnings)(_.warnings(_))
        .build

    def updateUserInput(
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      password: Option[String] = None
    ): UpdateUserInput =
      UpdateUserInput
        .builder
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(password)(_.password(_))
        .build

    def updateUserRequest(
      brokerId: Option[String] = None,
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      password: Option[String] = None,
      username: Option[String] = None
    ): UpdateUserRequest =
      UpdateUserRequest
        .builder
        .ifSome(brokerId)(_.brokerId(_))
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(password)(_.password(_))
        .ifSome(username)(_.username(_))
        .build

    def updateUserResponse(

    ): UpdateUserResponse =
      UpdateUserResponse
        .builder

        .build

    def user(
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      password: Option[String] = None,
      username: Option[String] = None
    ): User =
      User
        .builder
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(password)(_.password(_))
        .ifSome(username)(_.username(_))
        .build

    def userPendingChanges(
      consoleAccess: Option[Boolean] = None,
      groups: Option[List[__string]] = None,
      pendingChange: Option[String] = None
    ): UserPendingChanges =
      UserPendingChanges
        .builder
        .ifSome(consoleAccess)(_.consoleAccess(_))
        .ifSome(groups)(_.groups(_))
        .ifSome(pendingChange)(_.pendingChange(_))
        .build

    def userSummary(
      pendingChange: Option[String] = None,
      username: Option[String] = None
    ): UserSummary =
      UserSummary
        .builder
        .ifSome(pendingChange)(_.pendingChange(_))
        .ifSome(username)(_.username(_))
        .build

    def weeklyStartTime(
      dayOfWeek: Option[String] = None,
      timeOfDay: Option[String] = None,
      timeZone: Option[String] = None
    ): WeeklyStartTime =
      WeeklyStartTime
        .builder
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .ifSome(timeOfDay)(_.timeOfDay(_))
        .ifSome(timeZone)(_.timeZone(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
