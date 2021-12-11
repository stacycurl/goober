package goober.hi

import goober.free.greengrass.GreengrassIO
import software.amazon.awssdk.services.greengrass.model._


object greengrass {
  import goober.free.{greengrass ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def associateRoleToGroupRequest(
      groupId: Option[String] = None,
      roleArn: Option[String] = None
    ): AssociateRoleToGroupRequest =
      AssociateRoleToGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def associateRoleToGroupResponse(
      associatedAt: Option[String] = None
    ): AssociateRoleToGroupResponse =
      AssociateRoleToGroupResponse
        .builder
        .ifSome(associatedAt)(_.associatedAt(_))
        .build

    def associateServiceRoleToAccountRequest(
      roleArn: Option[String] = None
    ): AssociateServiceRoleToAccountRequest =
      AssociateServiceRoleToAccountRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def associateServiceRoleToAccountResponse(
      associatedAt: Option[String] = None
    ): AssociateServiceRoleToAccountResponse =
      AssociateServiceRoleToAccountResponse
        .builder
        .ifSome(associatedAt)(_.associatedAt(_))
        .build

    def badRequestException(
      errorDetails: Option[List[ErrorDetail]] = None,
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(errorDetails)(_.errorDetails(_))
        .ifSome(message)(_.message(_))
        .build

    def bulkDeployment(
      bulkDeploymentArn: Option[String] = None,
      bulkDeploymentId: Option[String] = None,
      createdAt: Option[String] = None
    ): BulkDeployment =
      BulkDeployment
        .builder
        .ifSome(bulkDeploymentArn)(_.bulkDeploymentArn(_))
        .ifSome(bulkDeploymentId)(_.bulkDeploymentId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def bulkDeploymentMetrics(
      invalidInputRecords: Option[Int] = None,
      recordsProcessed: Option[Int] = None,
      retryAttempts: Option[Int] = None
    ): BulkDeploymentMetrics =
      BulkDeploymentMetrics
        .builder
        .ifSome(invalidInputRecords)(_.invalidInputRecords(_))
        .ifSome(recordsProcessed)(_.recordsProcessed(_))
        .ifSome(retryAttempts)(_.retryAttempts(_))
        .build

    def connectivityInfo(
      hostAddress: Option[String] = None,
      id: Option[String] = None,
      metadata: Option[String] = None,
      portNumber: Option[Int] = None
    ): ConnectivityInfo =
      ConnectivityInfo
        .builder
        .ifSome(hostAddress)(_.hostAddress(_))
        .ifSome(id)(_.id(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(portNumber)(_.portNumber(_))
        .build

    def connector(
      connectorArn: Option[String] = None,
      id: Option[String] = None,
      parameters: Option[__mapOf__string] = None
    ): Connector =
      Connector
        .builder
        .ifSome(connectorArn)(_.connectorArn(_))
        .ifSome(id)(_.id(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def connectorDefinitionVersion(
      connectors: Option[List[Connector]] = None
    ): ConnectorDefinitionVersion =
      ConnectorDefinitionVersion
        .builder
        .ifSome(connectors)(_.connectors(_))
        .build

    def core(
      certificateArn: Option[String] = None,
      id: Option[String] = None,
      syncShadow: Option[Boolean] = None,
      thingArn: Option[String] = None
    ): Core =
      Core
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(id)(_.id(_))
        .ifSome(syncShadow)(_.syncShadow(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def coreDefinitionVersion(
      cores: Option[List[Core]] = None
    ): CoreDefinitionVersion =
      CoreDefinitionVersion
        .builder
        .ifSome(cores)(_.cores(_))
        .build

    def createConnectorDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[ConnectorDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateConnectorDefinitionRequest =
      CreateConnectorDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConnectorDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateConnectorDefinitionResponse =
      CreateConnectorDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createConnectorDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      connectorDefinitionId: Option[String] = None,
      connectors: Option[List[Connector]] = None
    ): CreateConnectorDefinitionVersionRequest =
      CreateConnectorDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(connectorDefinitionId)(_.connectorDefinitionId(_))
        .ifSome(connectors)(_.connectors(_))
        .build

    def createConnectorDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateConnectorDefinitionVersionResponse =
      CreateConnectorDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createCoreDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[CoreDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateCoreDefinitionRequest =
      CreateCoreDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCoreDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateCoreDefinitionResponse =
      CreateCoreDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createCoreDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      coreDefinitionId: Option[String] = None,
      cores: Option[List[Core]] = None
    ): CreateCoreDefinitionVersionRequest =
      CreateCoreDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(coreDefinitionId)(_.coreDefinitionId(_))
        .ifSome(cores)(_.cores(_))
        .build

    def createCoreDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateCoreDefinitionVersionResponse =
      CreateCoreDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createDeploymentRequest(
      amznClientToken: Option[String] = None,
      deploymentId: Option[String] = None,
      deploymentType: Option[String] = None,
      groupId: Option[String] = None,
      groupVersionId: Option[String] = None
    ): CreateDeploymentRequest =
      CreateDeploymentRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupVersionId)(_.groupVersionId(_))
        .build

    def createDeploymentResponse(
      deploymentArn: Option[String] = None,
      deploymentId: Option[String] = None
    ): CreateDeploymentResponse =
      CreateDeploymentResponse
        .builder
        .ifSome(deploymentArn)(_.deploymentArn(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def createDeviceDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[DeviceDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateDeviceDefinitionRequest =
      CreateDeviceDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeviceDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateDeviceDefinitionResponse =
      CreateDeviceDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createDeviceDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      deviceDefinitionId: Option[String] = None,
      devices: Option[List[Device]] = None
    ): CreateDeviceDefinitionVersionRequest =
      CreateDeviceDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(deviceDefinitionId)(_.deviceDefinitionId(_))
        .ifSome(devices)(_.devices(_))
        .build

    def createDeviceDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateDeviceDefinitionVersionResponse =
      CreateDeviceDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createFunctionDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[FunctionDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateFunctionDefinitionRequest =
      CreateFunctionDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFunctionDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateFunctionDefinitionResponse =
      CreateFunctionDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createFunctionDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      defaultConfig: Option[FunctionDefaultConfig] = None,
      functionDefinitionId: Option[String] = None,
      functions: Option[List[Function]] = None
    ): CreateFunctionDefinitionVersionRequest =
      CreateFunctionDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(defaultConfig)(_.defaultConfig(_))
        .ifSome(functionDefinitionId)(_.functionDefinitionId(_))
        .ifSome(functions)(_.functions(_))
        .build

    def createFunctionDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateFunctionDefinitionVersionResponse =
      CreateFunctionDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createGroupCertificateAuthorityRequest(
      amznClientToken: Option[String] = None,
      groupId: Option[String] = None
    ): CreateGroupCertificateAuthorityRequest =
      CreateGroupCertificateAuthorityRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def createGroupCertificateAuthorityResponse(
      groupCertificateAuthorityArn: Option[String] = None
    ): CreateGroupCertificateAuthorityResponse =
      CreateGroupCertificateAuthorityResponse
        .builder
        .ifSome(groupCertificateAuthorityArn)(_.groupCertificateAuthorityArn(_))
        .build

    def createGroupRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[GroupVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateGroupRequest =
      CreateGroupRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createGroupResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateGroupResponse =
      CreateGroupResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createGroupVersionRequest(
      amznClientToken: Option[String] = None,
      connectorDefinitionVersionArn: Option[String] = None,
      coreDefinitionVersionArn: Option[String] = None,
      deviceDefinitionVersionArn: Option[String] = None,
      functionDefinitionVersionArn: Option[String] = None,
      groupId: Option[String] = None,
      loggerDefinitionVersionArn: Option[String] = None,
      resourceDefinitionVersionArn: Option[String] = None,
      subscriptionDefinitionVersionArn: Option[String] = None
    ): CreateGroupVersionRequest =
      CreateGroupVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(connectorDefinitionVersionArn)(_.connectorDefinitionVersionArn(_))
        .ifSome(coreDefinitionVersionArn)(_.coreDefinitionVersionArn(_))
        .ifSome(deviceDefinitionVersionArn)(_.deviceDefinitionVersionArn(_))
        .ifSome(functionDefinitionVersionArn)(_.functionDefinitionVersionArn(_))
        .ifSome(groupId)(_.groupId(_))
        .ifSome(loggerDefinitionVersionArn)(_.loggerDefinitionVersionArn(_))
        .ifSome(resourceDefinitionVersionArn)(_.resourceDefinitionVersionArn(_))
        .ifSome(subscriptionDefinitionVersionArn)(_.subscriptionDefinitionVersionArn(_))
        .build

    def createGroupVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateGroupVersionResponse =
      CreateGroupVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createLoggerDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[LoggerDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateLoggerDefinitionRequest =
      CreateLoggerDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createLoggerDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateLoggerDefinitionResponse =
      CreateLoggerDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createLoggerDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      loggerDefinitionId: Option[String] = None,
      loggers: Option[List[Logger]] = None
    ): CreateLoggerDefinitionVersionRequest =
      CreateLoggerDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(loggerDefinitionId)(_.loggerDefinitionId(_))
        .ifSome(loggers)(_.loggers(_))
        .build

    def createLoggerDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateLoggerDefinitionVersionResponse =
      CreateLoggerDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createResourceDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[ResourceDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateResourceDefinitionRequest =
      CreateResourceDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createResourceDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateResourceDefinitionResponse =
      CreateResourceDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createResourceDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      resourceDefinitionId: Option[String] = None,
      resources: Option[List[Resource]] = None
    ): CreateResourceDefinitionVersionRequest =
      CreateResourceDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(resourceDefinitionId)(_.resourceDefinitionId(_))
        .ifSome(resources)(_.resources(_))
        .build

    def createResourceDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateResourceDefinitionVersionResponse =
      CreateResourceDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def createSoftwareUpdateJobRequest(
      amznClientToken: Option[String] = None,
      s3UrlSignerRole: Option[String] = None,
      softwareToUpdate: Option[String] = None,
      updateAgentLogLevel: Option[String] = None,
      updateTargets: Option[List[__string]] = None,
      updateTargetsArchitecture: Option[String] = None,
      updateTargetsOperatingSystem: Option[String] = None
    ): CreateSoftwareUpdateJobRequest =
      CreateSoftwareUpdateJobRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(s3UrlSignerRole)(_.s3UrlSignerRole(_))
        .ifSome(softwareToUpdate)(_.softwareToUpdate(_))
        .ifSome(updateAgentLogLevel)(_.updateAgentLogLevel(_))
        .ifSome(updateTargets)(_.updateTargets(_))
        .ifSome(updateTargetsArchitecture)(_.updateTargetsArchitecture(_))
        .ifSome(updateTargetsOperatingSystem)(_.updateTargetsOperatingSystem(_))
        .build

    def createSoftwareUpdateJobResponse(
      iotJobArn: Option[String] = None,
      iotJobId: Option[String] = None,
      platformSoftwareVersion: Option[String] = None
    ): CreateSoftwareUpdateJobResponse =
      CreateSoftwareUpdateJobResponse
        .builder
        .ifSome(iotJobArn)(_.iotJobArn(_))
        .ifSome(iotJobId)(_.iotJobId(_))
        .ifSome(platformSoftwareVersion)(_.platformSoftwareVersion(_))
        .build

    def createSubscriptionDefinitionRequest(
      amznClientToken: Option[String] = None,
      initialVersion: Option[SubscriptionDefinitionVersion] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): CreateSubscriptionDefinitionRequest =
      CreateSubscriptionDefinitionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(initialVersion)(_.initialVersion(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSubscriptionDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): CreateSubscriptionDefinitionResponse =
      CreateSubscriptionDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def createSubscriptionDefinitionVersionRequest(
      amznClientToken: Option[String] = None,
      subscriptionDefinitionId: Option[String] = None,
      subscriptions: Option[List[Subscription]] = None
    ): CreateSubscriptionDefinitionVersionRequest =
      CreateSubscriptionDefinitionVersionRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(subscriptionDefinitionId)(_.subscriptionDefinitionId(_))
        .ifSome(subscriptions)(_.subscriptions(_))
        .build

    def createSubscriptionDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): CreateSubscriptionDefinitionVersionResponse =
      CreateSubscriptionDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def definitionInformation(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): DefinitionInformation =
      DefinitionInformation
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deleteConnectorDefinitionRequest(
      connectorDefinitionId: Option[String] = None
    ): DeleteConnectorDefinitionRequest =
      DeleteConnectorDefinitionRequest
        .builder
        .ifSome(connectorDefinitionId)(_.connectorDefinitionId(_))
        .build

    def deleteConnectorDefinitionResponse(

    ): DeleteConnectorDefinitionResponse =
      DeleteConnectorDefinitionResponse
        .builder

        .build

    def deleteCoreDefinitionRequest(
      coreDefinitionId: Option[String] = None
    ): DeleteCoreDefinitionRequest =
      DeleteCoreDefinitionRequest
        .builder
        .ifSome(coreDefinitionId)(_.coreDefinitionId(_))
        .build

    def deleteCoreDefinitionResponse(

    ): DeleteCoreDefinitionResponse =
      DeleteCoreDefinitionResponse
        .builder

        .build

    def deleteDeviceDefinitionRequest(
      deviceDefinitionId: Option[String] = None
    ): DeleteDeviceDefinitionRequest =
      DeleteDeviceDefinitionRequest
        .builder
        .ifSome(deviceDefinitionId)(_.deviceDefinitionId(_))
        .build

    def deleteDeviceDefinitionResponse(

    ): DeleteDeviceDefinitionResponse =
      DeleteDeviceDefinitionResponse
        .builder

        .build

    def deleteFunctionDefinitionRequest(
      functionDefinitionId: Option[String] = None
    ): DeleteFunctionDefinitionRequest =
      DeleteFunctionDefinitionRequest
        .builder
        .ifSome(functionDefinitionId)(_.functionDefinitionId(_))
        .build

    def deleteFunctionDefinitionResponse(

    ): DeleteFunctionDefinitionResponse =
      DeleteFunctionDefinitionResponse
        .builder

        .build

    def deleteGroupRequest(
      groupId: Option[String] = None
    ): DeleteGroupRequest =
      DeleteGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def deleteGroupResponse(

    ): DeleteGroupResponse =
      DeleteGroupResponse
        .builder

        .build

    def deleteLoggerDefinitionRequest(
      loggerDefinitionId: Option[String] = None
    ): DeleteLoggerDefinitionRequest =
      DeleteLoggerDefinitionRequest
        .builder
        .ifSome(loggerDefinitionId)(_.loggerDefinitionId(_))
        .build

    def deleteLoggerDefinitionResponse(

    ): DeleteLoggerDefinitionResponse =
      DeleteLoggerDefinitionResponse
        .builder

        .build

    def deleteResourceDefinitionRequest(
      resourceDefinitionId: Option[String] = None
    ): DeleteResourceDefinitionRequest =
      DeleteResourceDefinitionRequest
        .builder
        .ifSome(resourceDefinitionId)(_.resourceDefinitionId(_))
        .build

    def deleteResourceDefinitionResponse(

    ): DeleteResourceDefinitionResponse =
      DeleteResourceDefinitionResponse
        .builder

        .build

    def deleteSubscriptionDefinitionRequest(
      subscriptionDefinitionId: Option[String] = None
    ): DeleteSubscriptionDefinitionRequest =
      DeleteSubscriptionDefinitionRequest
        .builder
        .ifSome(subscriptionDefinitionId)(_.subscriptionDefinitionId(_))
        .build

    def deleteSubscriptionDefinitionResponse(

    ): DeleteSubscriptionDefinitionResponse =
      DeleteSubscriptionDefinitionResponse
        .builder

        .build

    def deployment(
      createdAt: Option[String] = None,
      deploymentArn: Option[String] = None,
      deploymentId: Option[String] = None,
      deploymentType: Option[String] = None,
      groupArn: Option[String] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentArn)(_.deploymentArn(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(groupArn)(_.groupArn(_))
        .build

    def device(
      certificateArn: Option[String] = None,
      id: Option[String] = None,
      syncShadow: Option[Boolean] = None,
      thingArn: Option[String] = None
    ): Device =
      Device
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(id)(_.id(_))
        .ifSome(syncShadow)(_.syncShadow(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def deviceDefinitionVersion(
      devices: Option[List[Device]] = None
    ): DeviceDefinitionVersion =
      DeviceDefinitionVersion
        .builder
        .ifSome(devices)(_.devices(_))
        .build

    def disassociateRoleFromGroupRequest(
      groupId: Option[String] = None
    ): DisassociateRoleFromGroupRequest =
      DisassociateRoleFromGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def disassociateRoleFromGroupResponse(
      disassociatedAt: Option[String] = None
    ): DisassociateRoleFromGroupResponse =
      DisassociateRoleFromGroupResponse
        .builder
        .ifSome(disassociatedAt)(_.disassociatedAt(_))
        .build

    def disassociateServiceRoleFromAccountRequest(

    ): DisassociateServiceRoleFromAccountRequest =
      DisassociateServiceRoleFromAccountRequest
        .builder

        .build

    def disassociateServiceRoleFromAccountResponse(
      disassociatedAt: Option[String] = None
    ): DisassociateServiceRoleFromAccountResponse =
      DisassociateServiceRoleFromAccountResponse
        .builder
        .ifSome(disassociatedAt)(_.disassociatedAt(_))
        .build

    def empty(

    ): Empty =
      Empty
        .builder

        .build

    def errorDetail(
      detailedErrorCode: Option[String] = None,
      detailedErrorMessage: Option[String] = None
    ): ErrorDetail =
      ErrorDetail
        .builder
        .ifSome(detailedErrorCode)(_.detailedErrorCode(_))
        .ifSome(detailedErrorMessage)(_.detailedErrorMessage(_))
        .build

    def function(
      functionArn: Option[String] = None,
      functionConfiguration: Option[FunctionConfiguration] = None,
      id: Option[String] = None
    ): Function =
      Function
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .ifSome(functionConfiguration)(_.functionConfiguration(_))
        .ifSome(id)(_.id(_))
        .build

    def functionConfiguration(
      encodingType: Option[String] = None,
      environment: Option[FunctionConfigurationEnvironment] = None,
      execArgs: Option[String] = None,
      executable: Option[String] = None,
      memorySize: Option[Int] = None,
      pinned: Option[Boolean] = None,
      timeout: Option[Int] = None
    ): FunctionConfiguration =
      FunctionConfiguration
        .builder
        .ifSome(encodingType)(_.encodingType(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(execArgs)(_.execArgs(_))
        .ifSome(executable)(_.executable(_))
        .ifSome(memorySize)(_.memorySize(_))
        .ifSome(pinned)(_.pinned(_))
        .ifSome(timeout)(_.timeout(_))
        .build

    def functionConfigurationEnvironment(
      accessSysfs: Option[Boolean] = None,
      execution: Option[FunctionExecutionConfig] = None,
      resourceAccessPolicies: Option[List[ResourceAccessPolicy]] = None,
      variables: Option[__mapOf__string] = None
    ): FunctionConfigurationEnvironment =
      FunctionConfigurationEnvironment
        .builder
        .ifSome(accessSysfs)(_.accessSysfs(_))
        .ifSome(execution)(_.execution(_))
        .ifSome(resourceAccessPolicies)(_.resourceAccessPolicies(_))
        .ifSome(variables)(_.variables(_))
        .build

    def functionDefaultConfig(
      execution: Option[FunctionDefaultExecutionConfig] = None
    ): FunctionDefaultConfig =
      FunctionDefaultConfig
        .builder
        .ifSome(execution)(_.execution(_))
        .build

    def functionDefaultExecutionConfig(
      isolationMode: Option[String] = None,
      runAs: Option[FunctionRunAsConfig] = None
    ): FunctionDefaultExecutionConfig =
      FunctionDefaultExecutionConfig
        .builder
        .ifSome(isolationMode)(_.isolationMode(_))
        .ifSome(runAs)(_.runAs(_))
        .build

    def functionDefinitionVersion(
      defaultConfig: Option[FunctionDefaultConfig] = None,
      functions: Option[List[Function]] = None
    ): FunctionDefinitionVersion =
      FunctionDefinitionVersion
        .builder
        .ifSome(defaultConfig)(_.defaultConfig(_))
        .ifSome(functions)(_.functions(_))
        .build

    def functionExecutionConfig(
      isolationMode: Option[String] = None,
      runAs: Option[FunctionRunAsConfig] = None
    ): FunctionExecutionConfig =
      FunctionExecutionConfig
        .builder
        .ifSome(isolationMode)(_.isolationMode(_))
        .ifSome(runAs)(_.runAs(_))
        .build

    def functionRunAsConfig(
      gid: Option[Int] = None,
      uid: Option[Int] = None
    ): FunctionRunAsConfig =
      FunctionRunAsConfig
        .builder
        .ifSome(gid)(_.gid(_))
        .ifSome(uid)(_.uid(_))
        .build

    def generalError(
      errorDetails: Option[List[ErrorDetail]] = None,
      message: Option[String] = None
    ): GeneralError =
      GeneralError
        .builder
        .ifSome(errorDetails)(_.errorDetails(_))
        .ifSome(message)(_.message(_))
        .build

    def getAssociatedRoleRequest(
      groupId: Option[String] = None
    ): GetAssociatedRoleRequest =
      GetAssociatedRoleRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def getAssociatedRoleResponse(
      associatedAt: Option[String] = None,
      roleArn: Option[String] = None
    ): GetAssociatedRoleResponse =
      GetAssociatedRoleResponse
        .builder
        .ifSome(associatedAt)(_.associatedAt(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def getBulkDeploymentStatusRequest(
      bulkDeploymentId: Option[String] = None
    ): GetBulkDeploymentStatusRequest =
      GetBulkDeploymentStatusRequest
        .builder
        .ifSome(bulkDeploymentId)(_.bulkDeploymentId(_))
        .build

    def getBulkDeploymentStatusResponse(
      bulkDeploymentMetrics: Option[BulkDeploymentMetrics] = None,
      bulkDeploymentStatus: Option[String] = None,
      createdAt: Option[String] = None,
      errorDetails: Option[List[ErrorDetail]] = None,
      errorMessage: Option[String] = None,
      tags: Option[Tags] = None
    ): GetBulkDeploymentStatusResponse =
      GetBulkDeploymentStatusResponse
        .builder
        .ifSome(bulkDeploymentMetrics)(_.bulkDeploymentMetrics(_))
        .ifSome(bulkDeploymentStatus)(_.bulkDeploymentStatus(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getConnectivityInfoRequest(
      thingName: Option[String] = None
    ): GetConnectivityInfoRequest =
      GetConnectivityInfoRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .build

    def getConnectivityInfoResponse(
      connectivityInfo: Option[List[ConnectivityInfo]] = None,
      message: Option[String] = None
    ): GetConnectivityInfoResponse =
      GetConnectivityInfoResponse
        .builder
        .ifSome(connectivityInfo)(_.connectivityInfo(_))
        .ifSome(message)(_.message(_))
        .build

    def getConnectorDefinitionRequest(
      connectorDefinitionId: Option[String] = None
    ): GetConnectorDefinitionRequest =
      GetConnectorDefinitionRequest
        .builder
        .ifSome(connectorDefinitionId)(_.connectorDefinitionId(_))
        .build

    def getConnectorDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetConnectorDefinitionResponse =
      GetConnectorDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getConnectorDefinitionVersionRequest(
      connectorDefinitionId: Option[String] = None,
      connectorDefinitionVersionId: Option[String] = None,
      nextToken: Option[String] = None
    ): GetConnectorDefinitionVersionRequest =
      GetConnectorDefinitionVersionRequest
        .builder
        .ifSome(connectorDefinitionId)(_.connectorDefinitionId(_))
        .ifSome(connectorDefinitionVersionId)(_.connectorDefinitionVersionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getConnectorDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[ConnectorDefinitionVersion] = None,
      id: Option[String] = None,
      nextToken: Option[String] = None,
      version: Option[String] = None
    ): GetConnectorDefinitionVersionResponse =
      GetConnectorDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(version)(_.version(_))
        .build

    def getCoreDefinitionRequest(
      coreDefinitionId: Option[String] = None
    ): GetCoreDefinitionRequest =
      GetCoreDefinitionRequest
        .builder
        .ifSome(coreDefinitionId)(_.coreDefinitionId(_))
        .build

    def getCoreDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetCoreDefinitionResponse =
      GetCoreDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getCoreDefinitionVersionRequest(
      coreDefinitionId: Option[String] = None,
      coreDefinitionVersionId: Option[String] = None
    ): GetCoreDefinitionVersionRequest =
      GetCoreDefinitionVersionRequest
        .builder
        .ifSome(coreDefinitionId)(_.coreDefinitionId(_))
        .ifSome(coreDefinitionVersionId)(_.coreDefinitionVersionId(_))
        .build

    def getCoreDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[CoreDefinitionVersion] = None,
      id: Option[String] = None,
      nextToken: Option[String] = None,
      version: Option[String] = None
    ): GetCoreDefinitionVersionResponse =
      GetCoreDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(version)(_.version(_))
        .build

    def getDeploymentStatusRequest(
      deploymentId: Option[String] = None,
      groupId: Option[String] = None
    ): GetDeploymentStatusRequest =
      GetDeploymentStatusRequest
        .builder
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def getDeploymentStatusResponse(
      deploymentStatus: Option[String] = None,
      deploymentType: Option[String] = None,
      errorDetails: Option[List[ErrorDetail]] = None,
      errorMessage: Option[String] = None,
      updatedAt: Option[String] = None
    ): GetDeploymentStatusResponse =
      GetDeploymentStatusResponse
        .builder
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(errorDetails)(_.errorDetails(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .ifSome(updatedAt)(_.updatedAt(_))
        .build

    def getDeviceDefinitionRequest(
      deviceDefinitionId: Option[String] = None
    ): GetDeviceDefinitionRequest =
      GetDeviceDefinitionRequest
        .builder
        .ifSome(deviceDefinitionId)(_.deviceDefinitionId(_))
        .build

    def getDeviceDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetDeviceDefinitionResponse =
      GetDeviceDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getDeviceDefinitionVersionRequest(
      deviceDefinitionId: Option[String] = None,
      deviceDefinitionVersionId: Option[String] = None,
      nextToken: Option[String] = None
    ): GetDeviceDefinitionVersionRequest =
      GetDeviceDefinitionVersionRequest
        .builder
        .ifSome(deviceDefinitionId)(_.deviceDefinitionId(_))
        .ifSome(deviceDefinitionVersionId)(_.deviceDefinitionVersionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDeviceDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[DeviceDefinitionVersion] = None,
      id: Option[String] = None,
      nextToken: Option[String] = None,
      version: Option[String] = None
    ): GetDeviceDefinitionVersionResponse =
      GetDeviceDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(version)(_.version(_))
        .build

    def getFunctionDefinitionRequest(
      functionDefinitionId: Option[String] = None
    ): GetFunctionDefinitionRequest =
      GetFunctionDefinitionRequest
        .builder
        .ifSome(functionDefinitionId)(_.functionDefinitionId(_))
        .build

    def getFunctionDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetFunctionDefinitionResponse =
      GetFunctionDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getFunctionDefinitionVersionRequest(
      functionDefinitionId: Option[String] = None,
      functionDefinitionVersionId: Option[String] = None,
      nextToken: Option[String] = None
    ): GetFunctionDefinitionVersionRequest =
      GetFunctionDefinitionVersionRequest
        .builder
        .ifSome(functionDefinitionId)(_.functionDefinitionId(_))
        .ifSome(functionDefinitionVersionId)(_.functionDefinitionVersionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getFunctionDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[FunctionDefinitionVersion] = None,
      id: Option[String] = None,
      nextToken: Option[String] = None,
      version: Option[String] = None
    ): GetFunctionDefinitionVersionResponse =
      GetFunctionDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(version)(_.version(_))
        .build

    def getGroupCertificateAuthorityRequest(
      certificateAuthorityId: Option[String] = None,
      groupId: Option[String] = None
    ): GetGroupCertificateAuthorityRequest =
      GetGroupCertificateAuthorityRequest
        .builder
        .ifSome(certificateAuthorityId)(_.certificateAuthorityId(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def getGroupCertificateAuthorityResponse(
      groupCertificateAuthorityArn: Option[String] = None,
      groupCertificateAuthorityId: Option[String] = None,
      pemEncodedCertificate: Option[String] = None
    ): GetGroupCertificateAuthorityResponse =
      GetGroupCertificateAuthorityResponse
        .builder
        .ifSome(groupCertificateAuthorityArn)(_.groupCertificateAuthorityArn(_))
        .ifSome(groupCertificateAuthorityId)(_.groupCertificateAuthorityId(_))
        .ifSome(pemEncodedCertificate)(_.pemEncodedCertificate(_))
        .build

    def getGroupCertificateConfigurationRequest(
      groupId: Option[String] = None
    ): GetGroupCertificateConfigurationRequest =
      GetGroupCertificateConfigurationRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def getGroupCertificateConfigurationResponse(
      certificateAuthorityExpiryInMilliseconds: Option[String] = None,
      certificateExpiryInMilliseconds: Option[String] = None,
      groupId: Option[String] = None
    ): GetGroupCertificateConfigurationResponse =
      GetGroupCertificateConfigurationResponse
        .builder
        .ifSome(certificateAuthorityExpiryInMilliseconds)(_.certificateAuthorityExpiryInMilliseconds(_))
        .ifSome(certificateExpiryInMilliseconds)(_.certificateExpiryInMilliseconds(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def getGroupRequest(
      groupId: Option[String] = None
    ): GetGroupRequest =
      GetGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def getGroupResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetGroupResponse =
      GetGroupResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getGroupVersionRequest(
      groupId: Option[String] = None,
      groupVersionId: Option[String] = None
    ): GetGroupVersionRequest =
      GetGroupVersionRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(groupVersionId)(_.groupVersionId(_))
        .build

    def getGroupVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[GroupVersion] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): GetGroupVersionResponse =
      GetGroupVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def getLoggerDefinitionRequest(
      loggerDefinitionId: Option[String] = None
    ): GetLoggerDefinitionRequest =
      GetLoggerDefinitionRequest
        .builder
        .ifSome(loggerDefinitionId)(_.loggerDefinitionId(_))
        .build

    def getLoggerDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetLoggerDefinitionResponse =
      GetLoggerDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getLoggerDefinitionVersionRequest(
      loggerDefinitionId: Option[String] = None,
      loggerDefinitionVersionId: Option[String] = None,
      nextToken: Option[String] = None
    ): GetLoggerDefinitionVersionRequest =
      GetLoggerDefinitionVersionRequest
        .builder
        .ifSome(loggerDefinitionId)(_.loggerDefinitionId(_))
        .ifSome(loggerDefinitionVersionId)(_.loggerDefinitionVersionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getLoggerDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[LoggerDefinitionVersion] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): GetLoggerDefinitionVersionResponse =
      GetLoggerDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def getResourceDefinitionRequest(
      resourceDefinitionId: Option[String] = None
    ): GetResourceDefinitionRequest =
      GetResourceDefinitionRequest
        .builder
        .ifSome(resourceDefinitionId)(_.resourceDefinitionId(_))
        .build

    def getResourceDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetResourceDefinitionResponse =
      GetResourceDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getResourceDefinitionVersionRequest(
      resourceDefinitionId: Option[String] = None,
      resourceDefinitionVersionId: Option[String] = None
    ): GetResourceDefinitionVersionRequest =
      GetResourceDefinitionVersionRequest
        .builder
        .ifSome(resourceDefinitionId)(_.resourceDefinitionId(_))
        .ifSome(resourceDefinitionVersionId)(_.resourceDefinitionVersionId(_))
        .build

    def getResourceDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[ResourceDefinitionVersion] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): GetResourceDefinitionVersionResponse =
      GetResourceDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

    def getServiceRoleForAccountRequest(

    ): GetServiceRoleForAccountRequest =
      GetServiceRoleForAccountRequest
        .builder

        .build

    def getServiceRoleForAccountResponse(
      associatedAt: Option[String] = None,
      roleArn: Option[String] = None
    ): GetServiceRoleForAccountResponse =
      GetServiceRoleForAccountResponse
        .builder
        .ifSome(associatedAt)(_.associatedAt(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def getSubscriptionDefinitionRequest(
      subscriptionDefinitionId: Option[String] = None
    ): GetSubscriptionDefinitionRequest =
      GetSubscriptionDefinitionRequest
        .builder
        .ifSome(subscriptionDefinitionId)(_.subscriptionDefinitionId(_))
        .build

    def getSubscriptionDefinitionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[Tags] = None
    ): GetSubscriptionDefinitionResponse =
      GetSubscriptionDefinitionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getSubscriptionDefinitionVersionRequest(
      nextToken: Option[String] = None,
      subscriptionDefinitionId: Option[String] = None,
      subscriptionDefinitionVersionId: Option[String] = None
    ): GetSubscriptionDefinitionVersionRequest =
      GetSubscriptionDefinitionVersionRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(subscriptionDefinitionId)(_.subscriptionDefinitionId(_))
        .ifSome(subscriptionDefinitionVersionId)(_.subscriptionDefinitionVersionId(_))
        .build

    def getSubscriptionDefinitionVersionResponse(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      definition: Option[SubscriptionDefinitionVersion] = None,
      id: Option[String] = None,
      nextToken: Option[String] = None,
      version: Option[String] = None
    ): GetSubscriptionDefinitionVersionResponse =
      GetSubscriptionDefinitionVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(definition)(_.definition(_))
        .ifSome(id)(_.id(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(version)(_.version(_))
        .build

    def getThingRuntimeConfigurationRequest(
      thingName: Option[String] = None
    ): GetThingRuntimeConfigurationRequest =
      GetThingRuntimeConfigurationRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .build

    def getThingRuntimeConfigurationResponse(
      runtimeConfiguration: Option[RuntimeConfiguration] = None
    ): GetThingRuntimeConfigurationResponse =
      GetThingRuntimeConfigurationResponse
        .builder
        .ifSome(runtimeConfiguration)(_.runtimeConfiguration(_))
        .build

    def groupCertificateAuthorityProperties(
      groupCertificateAuthorityArn: Option[String] = None,
      groupCertificateAuthorityId: Option[String] = None
    ): GroupCertificateAuthorityProperties =
      GroupCertificateAuthorityProperties
        .builder
        .ifSome(groupCertificateAuthorityArn)(_.groupCertificateAuthorityArn(_))
        .ifSome(groupCertificateAuthorityId)(_.groupCertificateAuthorityId(_))
        .build

    def groupCertificateConfiguration(
      certificateAuthorityExpiryInMilliseconds: Option[String] = None,
      certificateExpiryInMilliseconds: Option[String] = None,
      groupId: Option[String] = None
    ): GroupCertificateConfiguration =
      GroupCertificateConfiguration
        .builder
        .ifSome(certificateAuthorityExpiryInMilliseconds)(_.certificateAuthorityExpiryInMilliseconds(_))
        .ifSome(certificateExpiryInMilliseconds)(_.certificateExpiryInMilliseconds(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def groupInformation(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      lastUpdatedTimestamp: Option[String] = None,
      latestVersion: Option[String] = None,
      latestVersionArn: Option[String] = None,
      name: Option[String] = None
    ): GroupInformation =
      GroupInformation
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(latestVersionArn)(_.latestVersionArn(_))
        .ifSome(name)(_.name(_))
        .build

    def groupOwnerSetting(
      autoAddGroupOwner: Option[Boolean] = None,
      groupOwner: Option[String] = None
    ): GroupOwnerSetting =
      GroupOwnerSetting
        .builder
        .ifSome(autoAddGroupOwner)(_.autoAddGroupOwner(_))
        .ifSome(groupOwner)(_.groupOwner(_))
        .build

    def groupVersion(
      connectorDefinitionVersionArn: Option[String] = None,
      coreDefinitionVersionArn: Option[String] = None,
      deviceDefinitionVersionArn: Option[String] = None,
      functionDefinitionVersionArn: Option[String] = None,
      loggerDefinitionVersionArn: Option[String] = None,
      resourceDefinitionVersionArn: Option[String] = None,
      subscriptionDefinitionVersionArn: Option[String] = None
    ): GroupVersion =
      GroupVersion
        .builder
        .ifSome(connectorDefinitionVersionArn)(_.connectorDefinitionVersionArn(_))
        .ifSome(coreDefinitionVersionArn)(_.coreDefinitionVersionArn(_))
        .ifSome(deviceDefinitionVersionArn)(_.deviceDefinitionVersionArn(_))
        .ifSome(functionDefinitionVersionArn)(_.functionDefinitionVersionArn(_))
        .ifSome(loggerDefinitionVersionArn)(_.loggerDefinitionVersionArn(_))
        .ifSome(resourceDefinitionVersionArn)(_.resourceDefinitionVersionArn(_))
        .ifSome(subscriptionDefinitionVersionArn)(_.subscriptionDefinitionVersionArn(_))
        .build

    def internalServerErrorException(
      errorDetails: Option[List[ErrorDetail]] = None,
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(errorDetails)(_.errorDetails(_))
        .ifSome(message)(_.message(_))
        .build

    def listBulkDeploymentDetailedReportsRequest(
      bulkDeploymentId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBulkDeploymentDetailedReportsRequest =
      ListBulkDeploymentDetailedReportsRequest
        .builder
        .ifSome(bulkDeploymentId)(_.bulkDeploymentId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBulkDeploymentDetailedReportsResponse(
      deployments: Option[List[BulkDeploymentResult]] = None,
      nextToken: Option[String] = None
    ): ListBulkDeploymentDetailedReportsResponse =
      ListBulkDeploymentDetailedReportsResponse
        .builder
        .ifSome(deployments)(_.deployments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBulkDeploymentsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBulkDeploymentsRequest =
      ListBulkDeploymentsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBulkDeploymentsResponse(
      bulkDeployments: Option[List[BulkDeployment]] = None,
      nextToken: Option[String] = None
    ): ListBulkDeploymentsResponse =
      ListBulkDeploymentsResponse
        .builder
        .ifSome(bulkDeployments)(_.bulkDeployments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectorDefinitionVersionsRequest(
      connectorDefinitionId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListConnectorDefinitionVersionsRequest =
      ListConnectorDefinitionVersionsRequest
        .builder
        .ifSome(connectorDefinitionId)(_.connectorDefinitionId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectorDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListConnectorDefinitionVersionsResponse =
      ListConnectorDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listConnectorDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListConnectorDefinitionsRequest =
      ListConnectorDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listConnectorDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListConnectorDefinitionsResponse =
      ListConnectorDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCoreDefinitionVersionsRequest(
      coreDefinitionId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListCoreDefinitionVersionsRequest =
      ListCoreDefinitionVersionsRequest
        .builder
        .ifSome(coreDefinitionId)(_.coreDefinitionId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCoreDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListCoreDefinitionVersionsResponse =
      ListCoreDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listCoreDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListCoreDefinitionsRequest =
      ListCoreDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCoreDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListCoreDefinitionsResponse =
      ListCoreDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListDefinitionsResponse =
      ListDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsRequest(
      groupId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsRequest =
      ListDeploymentsRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeploymentsResponse(
      deployments: Option[List[Deployment]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentsResponse =
      ListDeploymentsResponse
        .builder
        .ifSome(deployments)(_.deployments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeviceDefinitionVersionsRequest(
      deviceDefinitionId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListDeviceDefinitionVersionsRequest =
      ListDeviceDefinitionVersionsRequest
        .builder
        .ifSome(deviceDefinitionId)(_.deviceDefinitionId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeviceDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListDeviceDefinitionVersionsResponse =
      ListDeviceDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listDeviceDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListDeviceDefinitionsRequest =
      ListDeviceDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDeviceDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListDeviceDefinitionsResponse =
      ListDeviceDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFunctionDefinitionVersionsRequest(
      functionDefinitionId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListFunctionDefinitionVersionsRequest =
      ListFunctionDefinitionVersionsRequest
        .builder
        .ifSome(functionDefinitionId)(_.functionDefinitionId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFunctionDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListFunctionDefinitionVersionsResponse =
      ListFunctionDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listFunctionDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListFunctionDefinitionsRequest =
      ListFunctionDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFunctionDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListFunctionDefinitionsResponse =
      ListFunctionDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupCertificateAuthoritiesRequest(
      groupId: Option[String] = None
    ): ListGroupCertificateAuthoritiesRequest =
      ListGroupCertificateAuthoritiesRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .build

    def listGroupCertificateAuthoritiesResponse(
      groupCertificateAuthorities: Option[List[GroupCertificateAuthorityProperties]] = None
    ): ListGroupCertificateAuthoritiesResponse =
      ListGroupCertificateAuthoritiesResponse
        .builder
        .ifSome(groupCertificateAuthorities)(_.groupCertificateAuthorities(_))
        .build

    def listGroupVersionsRequest(
      groupId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListGroupVersionsRequest =
      ListGroupVersionsRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListGroupVersionsResponse =
      ListGroupVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listGroupsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListGroupsRequest =
      ListGroupsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGroupsResponse(
      groups: Option[List[GroupInformation]] = None,
      nextToken: Option[String] = None
    ): ListGroupsResponse =
      ListGroupsResponse
        .builder
        .ifSome(groups)(_.groups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLoggerDefinitionVersionsRequest(
      loggerDefinitionId: Option[String] = None,
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListLoggerDefinitionVersionsRequest =
      ListLoggerDefinitionVersionsRequest
        .builder
        .ifSome(loggerDefinitionId)(_.loggerDefinitionId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLoggerDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListLoggerDefinitionVersionsResponse =
      ListLoggerDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listLoggerDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListLoggerDefinitionsRequest =
      ListLoggerDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listLoggerDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListLoggerDefinitionsResponse =
      ListLoggerDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceDefinitionVersionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None,
      resourceDefinitionId: Option[String] = None
    ): ListResourceDefinitionVersionsRequest =
      ListResourceDefinitionVersionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourceDefinitionId)(_.resourceDefinitionId(_))
        .build

    def listResourceDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListResourceDefinitionVersionsResponse =
      ListResourceDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listResourceDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListResourceDefinitionsRequest =
      ListResourceDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listResourceDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListResourceDefinitionsResponse =
      ListResourceDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSubscriptionDefinitionVersionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None,
      subscriptionDefinitionId: Option[String] = None
    ): ListSubscriptionDefinitionVersionsRequest =
      ListSubscriptionDefinitionVersionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(subscriptionDefinitionId)(_.subscriptionDefinitionId(_))
        .build

    def listSubscriptionDefinitionVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListSubscriptionDefinitionVersionsResponse =
      ListSubscriptionDefinitionVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listSubscriptionDefinitionsRequest(
      maxResults: Option[String] = None,
      nextToken: Option[String] = None
    ): ListSubscriptionDefinitionsRequest =
      ListSubscriptionDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSubscriptionDefinitionsResponse(
      definitions: Option[List[DefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListSubscriptionDefinitionsResponse =
      ListSubscriptionDefinitionsResponse
        .builder
        .ifSome(definitions)(_.definitions(_))
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

    def listVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionInformation]] = None
    ): ListVersionsResponse =
      ListVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def localDeviceResourceData(
      groupOwnerSetting: Option[GroupOwnerSetting] = None,
      sourcePath: Option[String] = None
    ): LocalDeviceResourceData =
      LocalDeviceResourceData
        .builder
        .ifSome(groupOwnerSetting)(_.groupOwnerSetting(_))
        .ifSome(sourcePath)(_.sourcePath(_))
        .build

    def localVolumeResourceData(
      destinationPath: Option[String] = None,
      groupOwnerSetting: Option[GroupOwnerSetting] = None,
      sourcePath: Option[String] = None
    ): LocalVolumeResourceData =
      LocalVolumeResourceData
        .builder
        .ifSome(destinationPath)(_.destinationPath(_))
        .ifSome(groupOwnerSetting)(_.groupOwnerSetting(_))
        .ifSome(sourcePath)(_.sourcePath(_))
        .build

    def logger(
      component: Option[String] = None,
      id: Option[String] = None,
      level: Option[String] = None,
      space: Option[Int] = None,
      `type`: Option[String] = None
    ): Logger =
      Logger
        .builder
        .ifSome(component)(_.component(_))
        .ifSome(id)(_.id(_))
        .ifSome(level)(_.level(_))
        .ifSome(space)(_.space(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def loggerDefinitionVersion(
      loggers: Option[List[Logger]] = None
    ): LoggerDefinitionVersion =
      LoggerDefinitionVersion
        .builder
        .ifSome(loggers)(_.loggers(_))
        .build

    def resetDeploymentsRequest(
      amznClientToken: Option[String] = None,
      force: Option[Boolean] = None,
      groupId: Option[String] = None
    ): ResetDeploymentsRequest =
      ResetDeploymentsRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(force)(_.force(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def resetDeploymentsResponse(
      deploymentArn: Option[String] = None,
      deploymentId: Option[String] = None
    ): ResetDeploymentsResponse =
      ResetDeploymentsResponse
        .builder
        .ifSome(deploymentArn)(_.deploymentArn(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .build

    def resource(
      id: Option[String] = None,
      name: Option[String] = None,
      resourceDataContainer: Option[ResourceDataContainer] = None
    ): Resource =
      Resource
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourceDataContainer)(_.resourceDataContainer(_))
        .build

    def resourceAccessPolicy(
      permission: Option[String] = None,
      resourceId: Option[String] = None
    ): ResourceAccessPolicy =
      ResourceAccessPolicy
        .builder
        .ifSome(permission)(_.permission(_))
        .ifSome(resourceId)(_.resourceId(_))
        .build

    def resourceDataContainer(
      localDeviceResourceData: Option[LocalDeviceResourceData] = None,
      localVolumeResourceData: Option[LocalVolumeResourceData] = None,
      s3MachineLearningModelResourceData: Option[S3MachineLearningModelResourceData] = None,
      sageMakerMachineLearningModelResourceData: Option[SageMakerMachineLearningModelResourceData] = None,
      secretsManagerSecretResourceData: Option[SecretsManagerSecretResourceData] = None
    ): ResourceDataContainer =
      ResourceDataContainer
        .builder
        .ifSome(localDeviceResourceData)(_.localDeviceResourceData(_))
        .ifSome(localVolumeResourceData)(_.localVolumeResourceData(_))
        .ifSome(s3MachineLearningModelResourceData)(_.s3MachineLearningModelResourceData(_))
        .ifSome(sageMakerMachineLearningModelResourceData)(_.sageMakerMachineLearningModelResourceData(_))
        .ifSome(secretsManagerSecretResourceData)(_.secretsManagerSecretResourceData(_))
        .build

    def resourceDefinitionVersion(
      resources: Option[List[Resource]] = None
    ): ResourceDefinitionVersion =
      ResourceDefinitionVersion
        .builder
        .ifSome(resources)(_.resources(_))
        .build

    def resourceDownloadOwnerSetting(
      groupOwner: Option[String] = None,
      groupPermission: Option[String] = None
    ): ResourceDownloadOwnerSetting =
      ResourceDownloadOwnerSetting
        .builder
        .ifSome(groupOwner)(_.groupOwner(_))
        .ifSome(groupPermission)(_.groupPermission(_))
        .build

    def runtimeConfiguration(
      telemetryConfiguration: Option[TelemetryConfiguration] = None
    ): RuntimeConfiguration =
      RuntimeConfiguration
        .builder
        .ifSome(telemetryConfiguration)(_.telemetryConfiguration(_))
        .build

    def runtimeConfigurationUpdate(
      telemetryConfiguration: Option[TelemetryConfigurationUpdate] = None
    ): RuntimeConfigurationUpdate =
      RuntimeConfigurationUpdate
        .builder
        .ifSome(telemetryConfiguration)(_.telemetryConfiguration(_))
        .build

    def s3MachineLearningModelResourceData(
      destinationPath: Option[String] = None,
      ownerSetting: Option[ResourceDownloadOwnerSetting] = None,
      s3Uri: Option[String] = None
    ): S3MachineLearningModelResourceData =
      S3MachineLearningModelResourceData
        .builder
        .ifSome(destinationPath)(_.destinationPath(_))
        .ifSome(ownerSetting)(_.ownerSetting(_))
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def sageMakerMachineLearningModelResourceData(
      destinationPath: Option[String] = None,
      ownerSetting: Option[ResourceDownloadOwnerSetting] = None,
      sageMakerJobArn: Option[String] = None
    ): SageMakerMachineLearningModelResourceData =
      SageMakerMachineLearningModelResourceData
        .builder
        .ifSome(destinationPath)(_.destinationPath(_))
        .ifSome(ownerSetting)(_.ownerSetting(_))
        .ifSome(sageMakerJobArn)(_.sageMakerJobArn(_))
        .build

    def secretsManagerSecretResourceData(
      aRN: Option[String] = None,
      additionalStagingLabelsToDownload: Option[List[__string]] = None
    ): SecretsManagerSecretResourceData =
      SecretsManagerSecretResourceData
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(additionalStagingLabelsToDownload)(_.additionalStagingLabelsToDownload(_))
        .build

    def startBulkDeploymentRequest(
      amznClientToken: Option[String] = None,
      executionRoleArn: Option[String] = None,
      inputFileUri: Option[String] = None,
      tags: Option[Tags] = None
    ): StartBulkDeploymentRequest =
      StartBulkDeploymentRequest
        .builder
        .ifSome(amznClientToken)(_.amznClientToken(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(inputFileUri)(_.inputFileUri(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startBulkDeploymentResponse(
      bulkDeploymentArn: Option[String] = None,
      bulkDeploymentId: Option[String] = None
    ): StartBulkDeploymentResponse =
      StartBulkDeploymentResponse
        .builder
        .ifSome(bulkDeploymentArn)(_.bulkDeploymentArn(_))
        .ifSome(bulkDeploymentId)(_.bulkDeploymentId(_))
        .build

    def stopBulkDeploymentRequest(
      bulkDeploymentId: Option[String] = None
    ): StopBulkDeploymentRequest =
      StopBulkDeploymentRequest
        .builder
        .ifSome(bulkDeploymentId)(_.bulkDeploymentId(_))
        .build

    def stopBulkDeploymentResponse(

    ): StopBulkDeploymentResponse =
      StopBulkDeploymentResponse
        .builder

        .build

    def subscription(
      id: Option[String] = None,
      source: Option[String] = None,
      subject: Option[String] = None,
      target: Option[String] = None
    ): Subscription =
      Subscription
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(source)(_.source(_))
        .ifSome(subject)(_.subject(_))
        .ifSome(target)(_.target(_))
        .build

    def subscriptionDefinitionVersion(
      subscriptions: Option[List[Subscription]] = None
    ): SubscriptionDefinitionVersion =
      SubscriptionDefinitionVersion
        .builder
        .ifSome(subscriptions)(_.subscriptions(_))
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

    def telemetryConfiguration(
      configurationSyncStatus: Option[String] = None,
      telemetry: Option[String] = None
    ): TelemetryConfiguration =
      TelemetryConfiguration
        .builder
        .ifSome(configurationSyncStatus)(_.configurationSyncStatus(_))
        .ifSome(telemetry)(_.telemetry(_))
        .build

    def telemetryConfigurationUpdate(
      telemetry: Option[String] = None
    ): TelemetryConfigurationUpdate =
      TelemetryConfigurationUpdate
        .builder
        .ifSome(telemetry)(_.telemetry(_))
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

    def updateConnectivityInfoRequest(
      connectivityInfo: Option[List[ConnectivityInfo]] = None,
      thingName: Option[String] = None
    ): UpdateConnectivityInfoRequest =
      UpdateConnectivityInfoRequest
        .builder
        .ifSome(connectivityInfo)(_.connectivityInfo(_))
        .ifSome(thingName)(_.thingName(_))
        .build

    def updateConnectivityInfoResponse(
      message: Option[String] = None,
      version: Option[String] = None
    ): UpdateConnectivityInfoResponse =
      UpdateConnectivityInfoResponse
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(version)(_.version(_))
        .build

    def updateConnectorDefinitionRequest(
      connectorDefinitionId: Option[String] = None,
      name: Option[String] = None
    ): UpdateConnectorDefinitionRequest =
      UpdateConnectorDefinitionRequest
        .builder
        .ifSome(connectorDefinitionId)(_.connectorDefinitionId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateConnectorDefinitionResponse(

    ): UpdateConnectorDefinitionResponse =
      UpdateConnectorDefinitionResponse
        .builder

        .build

    def updateCoreDefinitionRequest(
      coreDefinitionId: Option[String] = None,
      name: Option[String] = None
    ): UpdateCoreDefinitionRequest =
      UpdateCoreDefinitionRequest
        .builder
        .ifSome(coreDefinitionId)(_.coreDefinitionId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateCoreDefinitionResponse(

    ): UpdateCoreDefinitionResponse =
      UpdateCoreDefinitionResponse
        .builder

        .build

    def updateDeviceDefinitionRequest(
      deviceDefinitionId: Option[String] = None,
      name: Option[String] = None
    ): UpdateDeviceDefinitionRequest =
      UpdateDeviceDefinitionRequest
        .builder
        .ifSome(deviceDefinitionId)(_.deviceDefinitionId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateDeviceDefinitionResponse(

    ): UpdateDeviceDefinitionResponse =
      UpdateDeviceDefinitionResponse
        .builder

        .build

    def updateFunctionDefinitionRequest(
      functionDefinitionId: Option[String] = None,
      name: Option[String] = None
    ): UpdateFunctionDefinitionRequest =
      UpdateFunctionDefinitionRequest
        .builder
        .ifSome(functionDefinitionId)(_.functionDefinitionId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateFunctionDefinitionResponse(

    ): UpdateFunctionDefinitionResponse =
      UpdateFunctionDefinitionResponse
        .builder

        .build

    def updateGroupCertificateConfigurationRequest(
      certificateExpiryInMilliseconds: Option[String] = None,
      groupId: Option[String] = None
    ): UpdateGroupCertificateConfigurationRequest =
      UpdateGroupCertificateConfigurationRequest
        .builder
        .ifSome(certificateExpiryInMilliseconds)(_.certificateExpiryInMilliseconds(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def updateGroupCertificateConfigurationResponse(
      certificateAuthorityExpiryInMilliseconds: Option[String] = None,
      certificateExpiryInMilliseconds: Option[String] = None,
      groupId: Option[String] = None
    ): UpdateGroupCertificateConfigurationResponse =
      UpdateGroupCertificateConfigurationResponse
        .builder
        .ifSome(certificateAuthorityExpiryInMilliseconds)(_.certificateAuthorityExpiryInMilliseconds(_))
        .ifSome(certificateExpiryInMilliseconds)(_.certificateExpiryInMilliseconds(_))
        .ifSome(groupId)(_.groupId(_))
        .build

    def updateGroupRequest(
      groupId: Option[String] = None,
      name: Option[String] = None
    ): UpdateGroupRequest =
      UpdateGroupRequest
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateGroupResponse(

    ): UpdateGroupResponse =
      UpdateGroupResponse
        .builder

        .build

    def updateLoggerDefinitionRequest(
      loggerDefinitionId: Option[String] = None,
      name: Option[String] = None
    ): UpdateLoggerDefinitionRequest =
      UpdateLoggerDefinitionRequest
        .builder
        .ifSome(loggerDefinitionId)(_.loggerDefinitionId(_))
        .ifSome(name)(_.name(_))
        .build

    def updateLoggerDefinitionResponse(

    ): UpdateLoggerDefinitionResponse =
      UpdateLoggerDefinitionResponse
        .builder

        .build

    def updateResourceDefinitionRequest(
      name: Option[String] = None,
      resourceDefinitionId: Option[String] = None
    ): UpdateResourceDefinitionRequest =
      UpdateResourceDefinitionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(resourceDefinitionId)(_.resourceDefinitionId(_))
        .build

    def updateResourceDefinitionResponse(

    ): UpdateResourceDefinitionResponse =
      UpdateResourceDefinitionResponse
        .builder

        .build

    def updateSubscriptionDefinitionRequest(
      name: Option[String] = None,
      subscriptionDefinitionId: Option[String] = None
    ): UpdateSubscriptionDefinitionRequest =
      UpdateSubscriptionDefinitionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(subscriptionDefinitionId)(_.subscriptionDefinitionId(_))
        .build

    def updateSubscriptionDefinitionResponse(

    ): UpdateSubscriptionDefinitionResponse =
      UpdateSubscriptionDefinitionResponse
        .builder

        .build

    def updateThingRuntimeConfigurationRequest(
      telemetryConfiguration: Option[TelemetryConfigurationUpdate] = None,
      thingName: Option[String] = None
    ): UpdateThingRuntimeConfigurationRequest =
      UpdateThingRuntimeConfigurationRequest
        .builder
        .ifSome(telemetryConfiguration)(_.telemetryConfiguration(_))
        .ifSome(thingName)(_.thingName(_))
        .build

    def updateThingRuntimeConfigurationResponse(

    ): UpdateThingRuntimeConfigurationResponse =
      UpdateThingRuntimeConfigurationResponse
        .builder

        .build

    def versionInformation(
      arn: Option[String] = None,
      creationTimestamp: Option[String] = None,
      id: Option[String] = None,
      version: Option[String] = None
    ): VersionInformation =
      VersionInformation
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(id)(_.id(_))
        .ifSome(version)(_.version(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
