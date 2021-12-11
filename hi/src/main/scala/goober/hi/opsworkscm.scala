package goober.hi

import goober.free.opsworkscm.OpsWorksCmIO
import software.amazon.awssdk.services.opsworkscm.model._


object opsworkscm {
  import goober.free.{opsworkscm ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountAttribute(
      name: Option[String] = None,
      maximum: Option[Int] = None,
      used: Option[Int] = None
    ): AccountAttribute =
      AccountAttribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maximum)(_.maximum(_))
        .ifSome(used)(_.used(_))
        .build

    def associateNodeRequest(
      serverName: Option[String] = None,
      nodeName: Option[String] = None,
      engineAttributes: Option[List[EngineAttribute]] = None
    ): AssociateNodeRequest =
      AssociateNodeRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(nodeName)(_.nodeName(_))
        .ifSome(engineAttributes)(_.engineAttributes(_))
        .build

    def associateNodeResponse(
      nodeAssociationStatusToken: Option[String] = None
    ): AssociateNodeResponse =
      AssociateNodeResponse
        .builder
        .ifSome(nodeAssociationStatusToken)(_.nodeAssociationStatusToken(_))
        .build

    def backup(
      backupArn: Option[String] = None,
      backupId: Option[String] = None,
      backupType: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      engine: Option[String] = None,
      engineModel: Option[String] = None,
      engineVersion: Option[String] = None,
      instanceProfileArn: Option[String] = None,
      instanceType: Option[String] = None,
      keyPair: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      s3DataSize: Option[Int] = None,
      s3DataUrl: Option[String] = None,
      s3LogUrl: Option[String] = None,
      securityGroupIds: Option[List[String]] = None,
      serverName: Option[String] = None,
      serviceRoleArn: Option[String] = None,
      status: Option[String] = None,
      statusDescription: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      toolsVersion: Option[String] = None,
      userArn: Option[String] = None
    ): Backup =
      Backup
        .builder
        .ifSome(backupArn)(_.backupArn(_))
        .ifSome(backupId)(_.backupId(_))
        .ifSome(backupType)(_.backupType(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineModel)(_.engineModel(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(instanceProfileArn)(_.instanceProfileArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(s3DataSize)(_.s3DataSize(_))
        .ifSome(s3DataUrl)(_.s3DataUrl(_))
        .ifSome(s3LogUrl)(_.s3LogUrl(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDescription)(_.statusDescription(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(toolsVersion)(_.toolsVersion(_))
        .ifSome(userArn)(_.userArn(_))
        .build

    def createBackupRequest(
      serverName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateBackupRequest =
      CreateBackupRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBackupResponse(
      backup: Option[Backup] = None
    ): CreateBackupResponse =
      CreateBackupResponse
        .builder
        .ifSome(backup)(_.backup(_))
        .build

    def createServerRequest(
      associatePublicIpAddress: Option[Boolean] = None,
      customDomain: Option[String] = None,
      customCertificate: Option[String] = None,
      customPrivateKey: Option[String] = None,
      disableAutomatedBackup: Option[Boolean] = None,
      engine: Option[String] = None,
      engineModel: Option[String] = None,
      engineVersion: Option[String] = None,
      engineAttributes: Option[List[EngineAttribute]] = None,
      backupRetentionCount: Option[Int] = None,
      serverName: Option[String] = None,
      instanceProfileArn: Option[String] = None,
      instanceType: Option[String] = None,
      keyPair: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      securityGroupIds: Option[List[String]] = None,
      serviceRoleArn: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      tags: Option[List[Tag]] = None,
      backupId: Option[String] = None
    ): CreateServerRequest =
      CreateServerRequest
        .builder
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(customDomain)(_.customDomain(_))
        .ifSome(customCertificate)(_.customCertificate(_))
        .ifSome(customPrivateKey)(_.customPrivateKey(_))
        .ifSome(disableAutomatedBackup)(_.disableAutomatedBackup(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineModel)(_.engineModel(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(engineAttributes)(_.engineAttributes(_))
        .ifSome(backupRetentionCount)(_.backupRetentionCount(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(instanceProfileArn)(_.instanceProfileArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(backupId)(_.backupId(_))
        .build

    def createServerResponse(
      server: Option[Server] = None
    ): CreateServerResponse =
      CreateServerResponse
        .builder
        .ifSome(server)(_.server(_))
        .build

    def deleteBackupRequest(
      backupId: Option[String] = None
    ): DeleteBackupRequest =
      DeleteBackupRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .build

    def deleteBackupResponse(

    ): DeleteBackupResponse =
      DeleteBackupResponse
        .builder

        .build

    def deleteServerRequest(
      serverName: Option[String] = None
    ): DeleteServerRequest =
      DeleteServerRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .build

    def deleteServerResponse(

    ): DeleteServerResponse =
      DeleteServerResponse
        .builder

        .build

    def describeAccountAttributesRequest(

    ): DescribeAccountAttributesRequest =
      DescribeAccountAttributesRequest
        .builder

        .build

    def describeAccountAttributesResponse(
      attributes: Option[List[AccountAttribute]] = None
    ): DescribeAccountAttributesResponse =
      DescribeAccountAttributesResponse
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def describeBackupsRequest(
      backupId: Option[String] = None,
      serverName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeBackupsRequest =
      DescribeBackupsRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeBackupsResponse(
      backups: Option[List[Backup]] = None,
      nextToken: Option[String] = None
    ): DescribeBackupsResponse =
      DescribeBackupsResponse
        .builder
        .ifSome(backups)(_.backups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventsRequest(
      serverName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeEventsRequest =
      DescribeEventsRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeEventsResponse(
      serverEvents: Option[List[ServerEvent]] = None,
      nextToken: Option[String] = None
    ): DescribeEventsResponse =
      DescribeEventsResponse
        .builder
        .ifSome(serverEvents)(_.serverEvents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeNodeAssociationStatusRequest(
      nodeAssociationStatusToken: Option[String] = None,
      serverName: Option[String] = None
    ): DescribeNodeAssociationStatusRequest =
      DescribeNodeAssociationStatusRequest
        .builder
        .ifSome(nodeAssociationStatusToken)(_.nodeAssociationStatusToken(_))
        .ifSome(serverName)(_.serverName(_))
        .build

    def describeNodeAssociationStatusResponse(
      nodeAssociationStatus: Option[String] = None,
      engineAttributes: Option[List[EngineAttribute]] = None
    ): DescribeNodeAssociationStatusResponse =
      DescribeNodeAssociationStatusResponse
        .builder
        .ifSome(nodeAssociationStatus)(_.nodeAssociationStatus(_))
        .ifSome(engineAttributes)(_.engineAttributes(_))
        .build

    def describeServersRequest(
      serverName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeServersRequest =
      DescribeServersRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeServersResponse(
      servers: Option[List[Server]] = None,
      nextToken: Option[String] = None
    ): DescribeServersResponse =
      DescribeServersResponse
        .builder
        .ifSome(servers)(_.servers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disassociateNodeRequest(
      serverName: Option[String] = None,
      nodeName: Option[String] = None,
      engineAttributes: Option[List[EngineAttribute]] = None
    ): DisassociateNodeRequest =
      DisassociateNodeRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(nodeName)(_.nodeName(_))
        .ifSome(engineAttributes)(_.engineAttributes(_))
        .build

    def disassociateNodeResponse(
      nodeAssociationStatusToken: Option[String] = None
    ): DisassociateNodeResponse =
      DisassociateNodeResponse
        .builder
        .ifSome(nodeAssociationStatusToken)(_.nodeAssociationStatusToken(_))
        .build

    def engineAttribute(
      name: Option[String] = None,
      value: Option[String] = None
    ): EngineAttribute =
      EngineAttribute
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def exportServerEngineAttributeRequest(
      exportAttributeName: Option[String] = None,
      serverName: Option[String] = None,
      inputAttributes: Option[List[EngineAttribute]] = None
    ): ExportServerEngineAttributeRequest =
      ExportServerEngineAttributeRequest
        .builder
        .ifSome(exportAttributeName)(_.exportAttributeName(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(inputAttributes)(_.inputAttributes(_))
        .build

    def exportServerEngineAttributeResponse(
      engineAttribute: Option[EngineAttribute] = None,
      serverName: Option[String] = None
    ): ExportServerEngineAttributeResponse =
      ExportServerEngineAttributeResponse
        .builder
        .ifSome(engineAttribute)(_.engineAttribute(_))
        .ifSome(serverName)(_.serverName(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidStateException(
      message: Option[String] = None
    ): InvalidStateException =
      InvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
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

    def restoreServerRequest(
      backupId: Option[String] = None,
      serverName: Option[String] = None,
      instanceType: Option[String] = None,
      keyPair: Option[String] = None
    ): RestoreServerRequest =
      RestoreServerRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(keyPair)(_.keyPair(_))
        .build

    def restoreServerResponse(
      server: Option[Server] = None
    ): RestoreServerResponse =
      RestoreServerResponse
        .builder
        .ifSome(server)(_.server(_))
        .build

    def server(
      associatePublicIpAddress: Option[Boolean] = None,
      backupRetentionCount: Option[Int] = None,
      serverName: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      cloudFormationStackArn: Option[String] = None,
      customDomain: Option[String] = None,
      disableAutomatedBackup: Option[Boolean] = None,
      endpoint: Option[String] = None,
      engine: Option[String] = None,
      engineModel: Option[String] = None,
      engineAttributes: Option[List[EngineAttribute]] = None,
      engineVersion: Option[String] = None,
      instanceProfileArn: Option[String] = None,
      instanceType: Option[String] = None,
      keyPair: Option[String] = None,
      maintenanceStatus: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      preferredBackupWindow: Option[String] = None,
      securityGroupIds: Option[List[String]] = None,
      serviceRoleArn: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      subnetIds: Option[List[String]] = None,
      serverArn: Option[String] = None
    ): Server =
      Server
        .builder
        .ifSome(associatePublicIpAddress)(_.associatePublicIpAddress(_))
        .ifSome(backupRetentionCount)(_.backupRetentionCount(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(cloudFormationStackArn)(_.cloudFormationStackArn(_))
        .ifSome(customDomain)(_.customDomain(_))
        .ifSome(disableAutomatedBackup)(_.disableAutomatedBackup(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(engine)(_.engine(_))
        .ifSome(engineModel)(_.engineModel(_))
        .ifSome(engineAttributes)(_.engineAttributes(_))
        .ifSome(engineVersion)(_.engineVersion(_))
        .ifSome(instanceProfileArn)(_.instanceProfileArn(_))
        .ifSome(instanceType)(_.instanceType(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(maintenanceStatus)(_.maintenanceStatus(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(serviceRoleArn)(_.serviceRoleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(serverArn)(_.serverArn(_))
        .build

    def serverEvent(
      createdAt: Option[Timestamp] = None,
      serverName: Option[String] = None,
      message: Option[String] = None,
      logUrl: Option[String] = None
    ): ServerEvent =
      ServerEvent
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(message)(_.message(_))
        .ifSome(logUrl)(_.logUrl(_))
        .build

    def startMaintenanceRequest(
      serverName: Option[String] = None,
      engineAttributes: Option[List[EngineAttribute]] = None
    ): StartMaintenanceRequest =
      StartMaintenanceRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(engineAttributes)(_.engineAttributes(_))
        .build

    def startMaintenanceResponse(
      server: Option[Server] = None
    ): StartMaintenanceResponse =
      StartMaintenanceResponse
        .builder
        .ifSome(server)(_.server(_))
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

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def updateServerEngineAttributesRequest(
      serverName: Option[String] = None,
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): UpdateServerEngineAttributesRequest =
      UpdateServerEngineAttributesRequest
        .builder
        .ifSome(serverName)(_.serverName(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def updateServerEngineAttributesResponse(
      server: Option[Server] = None
    ): UpdateServerEngineAttributesResponse =
      UpdateServerEngineAttributesResponse
        .builder
        .ifSome(server)(_.server(_))
        .build

    def updateServerRequest(
      disableAutomatedBackup: Option[Boolean] = None,
      backupRetentionCount: Option[Int] = None,
      serverName: Option[String] = None,
      preferredMaintenanceWindow: Option[String] = None,
      preferredBackupWindow: Option[String] = None
    ): UpdateServerRequest =
      UpdateServerRequest
        .builder
        .ifSome(disableAutomatedBackup)(_.disableAutomatedBackup(_))
        .ifSome(backupRetentionCount)(_.backupRetentionCount(_))
        .ifSome(serverName)(_.serverName(_))
        .ifSome(preferredMaintenanceWindow)(_.preferredMaintenanceWindow(_))
        .ifSome(preferredBackupWindow)(_.preferredBackupWindow(_))
        .build

    def updateServerResponse(
      server: Option[Server] = None
    ): UpdateServerResponse =
      UpdateServerResponse
        .builder
        .ifSome(server)(_.server(_))
        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
