package goober.hi

import goober.free.proton.ProtonIO
import software.amazon.awssdk.services.proton.model._


object proton {
  import goober.free.{proton ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def acceptEnvironmentAccountConnectionInput(
      id: Option[String] = None
    ): AcceptEnvironmentAccountConnectionInput =
      AcceptEnvironmentAccountConnectionInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def acceptEnvironmentAccountConnectionOutput(
      environmentAccountConnection: Option[EnvironmentAccountConnection] = None
    ): AcceptEnvironmentAccountConnectionOutput =
      AcceptEnvironmentAccountConnectionOutput
        .builder
        .ifSome(environmentAccountConnection)(_.environmentAccountConnection(_))
        .build

    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def accountSettings(
      pipelineServiceRoleArn: Option[String] = None
    ): AccountSettings =
      AccountSettings
        .builder
        .ifSome(pipelineServiceRoleArn)(_.pipelineServiceRoleArn(_))
        .build

    def cancelEnvironmentDeploymentInput(
      environmentName: Option[String] = None
    ): CancelEnvironmentDeploymentInput =
      CancelEnvironmentDeploymentInput
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def cancelEnvironmentDeploymentOutput(
      environment: Option[Environment] = None
    ): CancelEnvironmentDeploymentOutput =
      CancelEnvironmentDeploymentOutput
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def cancelServiceInstanceDeploymentInput(
      serviceInstanceName: Option[String] = None,
      serviceName: Option[String] = None
    ): CancelServiceInstanceDeploymentInput =
      CancelServiceInstanceDeploymentInput
        .builder
        .ifSome(serviceInstanceName)(_.serviceInstanceName(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def cancelServiceInstanceDeploymentOutput(
      serviceInstance: Option[ServiceInstance] = None
    ): CancelServiceInstanceDeploymentOutput =
      CancelServiceInstanceDeploymentOutput
        .builder
        .ifSome(serviceInstance)(_.serviceInstance(_))
        .build

    def cancelServicePipelineDeploymentInput(
      serviceName: Option[String] = None
    ): CancelServicePipelineDeploymentInput =
      CancelServicePipelineDeploymentInput
        .builder
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def cancelServicePipelineDeploymentOutput(
      pipeline: Option[ServicePipeline] = None
    ): CancelServicePipelineDeploymentOutput =
      CancelServicePipelineDeploymentOutput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def compatibleEnvironmentTemplate(
      majorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): CompatibleEnvironmentTemplate =
      CompatibleEnvironmentTemplate
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def compatibleEnvironmentTemplateInput(
      majorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): CompatibleEnvironmentTemplateInput =
      CompatibleEnvironmentTemplateInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createEnvironmentAccountConnectionInput(
      clientToken: Option[String] = None,
      environmentName: Option[String] = None,
      managementAccountId: Option[String] = None,
      roleArn: Option[String] = None
    ): CreateEnvironmentAccountConnectionInput =
      CreateEnvironmentAccountConnectionInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(managementAccountId)(_.managementAccountId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def createEnvironmentAccountConnectionOutput(
      environmentAccountConnection: Option[EnvironmentAccountConnection] = None
    ): CreateEnvironmentAccountConnectionOutput =
      CreateEnvironmentAccountConnectionOutput
        .builder
        .ifSome(environmentAccountConnection)(_.environmentAccountConnection(_))
        .build

    def createEnvironmentInput(
      description: Option[String] = None,
      environmentAccountConnectionId: Option[String] = None,
      name: Option[String] = None,
      protonServiceRoleArn: Option[String] = None,
      spec: Option[String] = None,
      tags: Option[List[Tag]] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): CreateEnvironmentInput =
      CreateEnvironmentInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(environmentAccountConnectionId)(_.environmentAccountConnectionId(_))
        .ifSome(name)(_.name(_))
        .ifSome(protonServiceRoleArn)(_.protonServiceRoleArn(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createEnvironmentOutput(
      environment: Option[Environment] = None
    ): CreateEnvironmentOutput =
      CreateEnvironmentOutput
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def createEnvironmentTemplateInput(
      description: Option[String] = None,
      displayName: Option[String] = None,
      encryptionKey: Option[String] = None,
      name: Option[String] = None,
      provisioning: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateEnvironmentTemplateInput =
      CreateEnvironmentTemplateInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(name)(_.name(_))
        .ifSome(provisioning)(_.provisioning(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEnvironmentTemplateOutput(
      environmentTemplate: Option[EnvironmentTemplate] = None
    ): CreateEnvironmentTemplateOutput =
      CreateEnvironmentTemplateOutput
        .builder
        .ifSome(environmentTemplate)(_.environmentTemplate(_))
        .build

    def createEnvironmentTemplateVersionInput(
      clientToken: Option[String] = None,
      description: Option[String] = None,
      majorVersion: Option[String] = None,
      source: Option[TemplateVersionSourceInput] = None,
      tags: Option[List[Tag]] = None,
      templateName: Option[String] = None
    ): CreateEnvironmentTemplateVersionInput =
      CreateEnvironmentTemplateVersionInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(source)(_.source(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createEnvironmentTemplateVersionOutput(
      environmentTemplateVersion: Option[EnvironmentTemplateVersion] = None
    ): CreateEnvironmentTemplateVersionOutput =
      CreateEnvironmentTemplateVersionOutput
        .builder
        .ifSome(environmentTemplateVersion)(_.environmentTemplateVersion(_))
        .build

    def createServiceInput(
      branchName: Option[String] = None,
      description: Option[String] = None,
      name: Option[String] = None,
      repositoryConnectionArn: Option[String] = None,
      repositoryId: Option[String] = None,
      spec: Option[String] = None,
      tags: Option[List[Tag]] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): CreateServiceInput =
      CreateServiceInput
        .builder
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(repositoryConnectionArn)(_.repositoryConnectionArn(_))
        .ifSome(repositoryId)(_.repositoryId(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createServiceOutput(
      service: Option[Service] = None
    ): CreateServiceOutput =
      CreateServiceOutput
        .builder
        .ifSome(service)(_.service(_))
        .build

    def createServiceTemplateInput(
      description: Option[String] = None,
      displayName: Option[String] = None,
      encryptionKey: Option[String] = None,
      name: Option[String] = None,
      pipelineProvisioning: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateServiceTemplateInput =
      CreateServiceTemplateInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineProvisioning)(_.pipelineProvisioning(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createServiceTemplateOutput(
      serviceTemplate: Option[ServiceTemplate] = None
    ): CreateServiceTemplateOutput =
      CreateServiceTemplateOutput
        .builder
        .ifSome(serviceTemplate)(_.serviceTemplate(_))
        .build

    def createServiceTemplateVersionInput(
      clientToken: Option[String] = None,
      compatibleEnvironmentTemplates: Option[List[CompatibleEnvironmentTemplateInput]] = None,
      description: Option[String] = None,
      majorVersion: Option[String] = None,
      source: Option[TemplateVersionSourceInput] = None,
      tags: Option[List[Tag]] = None,
      templateName: Option[String] = None
    ): CreateServiceTemplateVersionInput =
      CreateServiceTemplateVersionInput
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(compatibleEnvironmentTemplates)(_.compatibleEnvironmentTemplates(_))
        .ifSome(description)(_.description(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(source)(_.source(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def createServiceTemplateVersionOutput(
      serviceTemplateVersion: Option[ServiceTemplateVersion] = None
    ): CreateServiceTemplateVersionOutput =
      CreateServiceTemplateVersionOutput
        .builder
        .ifSome(serviceTemplateVersion)(_.serviceTemplateVersion(_))
        .build

    def deleteEnvironmentAccountConnectionInput(
      id: Option[String] = None
    ): DeleteEnvironmentAccountConnectionInput =
      DeleteEnvironmentAccountConnectionInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteEnvironmentAccountConnectionOutput(
      environmentAccountConnection: Option[EnvironmentAccountConnection] = None
    ): DeleteEnvironmentAccountConnectionOutput =
      DeleteEnvironmentAccountConnectionOutput
        .builder
        .ifSome(environmentAccountConnection)(_.environmentAccountConnection(_))
        .build

    def deleteEnvironmentInput(
      name: Option[String] = None
    ): DeleteEnvironmentInput =
      DeleteEnvironmentInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteEnvironmentOutput(
      environment: Option[Environment] = None
    ): DeleteEnvironmentOutput =
      DeleteEnvironmentOutput
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def deleteEnvironmentTemplateInput(
      name: Option[String] = None
    ): DeleteEnvironmentTemplateInput =
      DeleteEnvironmentTemplateInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteEnvironmentTemplateOutput(
      environmentTemplate: Option[EnvironmentTemplate] = None
    ): DeleteEnvironmentTemplateOutput =
      DeleteEnvironmentTemplateOutput
        .builder
        .ifSome(environmentTemplate)(_.environmentTemplate(_))
        .build

    def deleteEnvironmentTemplateVersionInput(
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): DeleteEnvironmentTemplateVersionInput =
      DeleteEnvironmentTemplateVersionInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteEnvironmentTemplateVersionOutput(
      environmentTemplateVersion: Option[EnvironmentTemplateVersion] = None
    ): DeleteEnvironmentTemplateVersionOutput =
      DeleteEnvironmentTemplateVersionOutput
        .builder
        .ifSome(environmentTemplateVersion)(_.environmentTemplateVersion(_))
        .build

    def deleteServiceInput(
      name: Option[String] = None
    ): DeleteServiceInput =
      DeleteServiceInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteServiceOutput(
      service: Option[Service] = None
    ): DeleteServiceOutput =
      DeleteServiceOutput
        .builder
        .ifSome(service)(_.service(_))
        .build

    def deleteServiceTemplateInput(
      name: Option[String] = None
    ): DeleteServiceTemplateInput =
      DeleteServiceTemplateInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteServiceTemplateOutput(
      serviceTemplate: Option[ServiceTemplate] = None
    ): DeleteServiceTemplateOutput =
      DeleteServiceTemplateOutput
        .builder
        .ifSome(serviceTemplate)(_.serviceTemplate(_))
        .build

    def deleteServiceTemplateVersionInput(
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): DeleteServiceTemplateVersionInput =
      DeleteServiceTemplateVersionInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteServiceTemplateVersionOutput(
      serviceTemplateVersion: Option[ServiceTemplateVersion] = None
    ): DeleteServiceTemplateVersionOutput =
      DeleteServiceTemplateVersionOutput
        .builder
        .ifSome(serviceTemplateVersion)(_.serviceTemplateVersion(_))
        .build

    def environment(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      description: Option[String] = None,
      environmentAccountConnectionId: Option[String] = None,
      environmentAccountId: Option[String] = None,
      lastDeploymentAttemptedAt: Option[Timestamp] = None,
      lastDeploymentSucceededAt: Option[Timestamp] = None,
      name: Option[String] = None,
      protonServiceRoleArn: Option[String] = None,
      provisioning: Option[String] = None,
      spec: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): Environment =
      Environment
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(description)(_.description(_))
        .ifSome(environmentAccountConnectionId)(_.environmentAccountConnectionId(_))
        .ifSome(environmentAccountId)(_.environmentAccountId(_))
        .ifSome(lastDeploymentAttemptedAt)(_.lastDeploymentAttemptedAt(_))
        .ifSome(lastDeploymentSucceededAt)(_.lastDeploymentSucceededAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(protonServiceRoleArn)(_.protonServiceRoleArn(_))
        .ifSome(provisioning)(_.provisioning(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def environmentAccountConnection(
      arn: Option[String] = None,
      environmentAccountId: Option[String] = None,
      environmentName: Option[String] = None,
      id: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      managementAccountId: Option[String] = None,
      requestedAt: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      status: Option[String] = None
    ): EnvironmentAccountConnection =
      EnvironmentAccountConnection
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(environmentAccountId)(_.environmentAccountId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(managementAccountId)(_.managementAccountId(_))
        .ifSome(requestedAt)(_.requestedAt(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .build

    def environmentAccountConnectionSummary(
      arn: Option[String] = None,
      environmentAccountId: Option[String] = None,
      environmentName: Option[String] = None,
      id: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      managementAccountId: Option[String] = None,
      requestedAt: Option[Timestamp] = None,
      roleArn: Option[String] = None,
      status: Option[String] = None
    ): EnvironmentAccountConnectionSummary =
      EnvironmentAccountConnectionSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(environmentAccountId)(_.environmentAccountId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(id)(_.id(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(managementAccountId)(_.managementAccountId(_))
        .ifSome(requestedAt)(_.requestedAt(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .build

    def environmentSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      description: Option[String] = None,
      environmentAccountConnectionId: Option[String] = None,
      environmentAccountId: Option[String] = None,
      lastDeploymentAttemptedAt: Option[Timestamp] = None,
      lastDeploymentSucceededAt: Option[Timestamp] = None,
      name: Option[String] = None,
      protonServiceRoleArn: Option[String] = None,
      provisioning: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): EnvironmentSummary =
      EnvironmentSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(description)(_.description(_))
        .ifSome(environmentAccountConnectionId)(_.environmentAccountConnectionId(_))
        .ifSome(environmentAccountId)(_.environmentAccountId(_))
        .ifSome(lastDeploymentAttemptedAt)(_.lastDeploymentAttemptedAt(_))
        .ifSome(lastDeploymentSucceededAt)(_.lastDeploymentSucceededAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(protonServiceRoleArn)(_.protonServiceRoleArn(_))
        .ifSome(provisioning)(_.provisioning(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def environmentTemplate(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      encryptionKey: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      provisioning: Option[String] = None,
      recommendedVersion: Option[String] = None
    ): EnvironmentTemplate =
      EnvironmentTemplate
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(provisioning)(_.provisioning(_))
        .ifSome(recommendedVersion)(_.recommendedVersion(_))
        .build

    def environmentTemplateFilter(
      majorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): EnvironmentTemplateFilter =
      EnvironmentTemplateFilter
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def environmentTemplateSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      provisioning: Option[String] = None,
      recommendedVersion: Option[String] = None
    ): EnvironmentTemplateSummary =
      EnvironmentTemplateSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(provisioning)(_.provisioning(_))
        .ifSome(recommendedVersion)(_.recommendedVersion(_))
        .build

    def environmentTemplateVersion(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      recommendedMinorVersion: Option[String] = None,
      schema: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      templateName: Option[String] = None
    ): EnvironmentTemplateVersion =
      EnvironmentTemplateVersion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(recommendedMinorVersion)(_.recommendedMinorVersion(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def environmentTemplateVersionSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      recommendedMinorVersion: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      templateName: Option[String] = None
    ): EnvironmentTemplateVersionSummary =
      EnvironmentTemplateVersionSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(recommendedMinorVersion)(_.recommendedMinorVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def getAccountSettingsInput(

    ): GetAccountSettingsInput =
      GetAccountSettingsInput
        .builder

        .build

    def getAccountSettingsOutput(
      accountSettings: Option[AccountSettings] = None
    ): GetAccountSettingsOutput =
      GetAccountSettingsOutput
        .builder
        .ifSome(accountSettings)(_.accountSettings(_))
        .build

    def getEnvironmentAccountConnectionInput(
      id: Option[String] = None
    ): GetEnvironmentAccountConnectionInput =
      GetEnvironmentAccountConnectionInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getEnvironmentAccountConnectionOutput(
      environmentAccountConnection: Option[EnvironmentAccountConnection] = None
    ): GetEnvironmentAccountConnectionOutput =
      GetEnvironmentAccountConnectionOutput
        .builder
        .ifSome(environmentAccountConnection)(_.environmentAccountConnection(_))
        .build

    def getEnvironmentInput(
      name: Option[String] = None
    ): GetEnvironmentInput =
      GetEnvironmentInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getEnvironmentOutput(
      environment: Option[Environment] = None
    ): GetEnvironmentOutput =
      GetEnvironmentOutput
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def getEnvironmentTemplateInput(
      name: Option[String] = None
    ): GetEnvironmentTemplateInput =
      GetEnvironmentTemplateInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getEnvironmentTemplateOutput(
      environmentTemplate: Option[EnvironmentTemplate] = None
    ): GetEnvironmentTemplateOutput =
      GetEnvironmentTemplateOutput
        .builder
        .ifSome(environmentTemplate)(_.environmentTemplate(_))
        .build

    def getEnvironmentTemplateVersionInput(
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): GetEnvironmentTemplateVersionInput =
      GetEnvironmentTemplateVersionInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def getEnvironmentTemplateVersionOutput(
      environmentTemplateVersion: Option[EnvironmentTemplateVersion] = None
    ): GetEnvironmentTemplateVersionOutput =
      GetEnvironmentTemplateVersionOutput
        .builder
        .ifSome(environmentTemplateVersion)(_.environmentTemplateVersion(_))
        .build

    def getServiceInput(
      name: Option[String] = None
    ): GetServiceInput =
      GetServiceInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getServiceInstanceInput(
      name: Option[String] = None,
      serviceName: Option[String] = None
    ): GetServiceInstanceInput =
      GetServiceInstanceInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def getServiceInstanceOutput(
      serviceInstance: Option[ServiceInstance] = None
    ): GetServiceInstanceOutput =
      GetServiceInstanceOutput
        .builder
        .ifSome(serviceInstance)(_.serviceInstance(_))
        .build

    def getServiceOutput(
      service: Option[Service] = None
    ): GetServiceOutput =
      GetServiceOutput
        .builder
        .ifSome(service)(_.service(_))
        .build

    def getServiceTemplateInput(
      name: Option[String] = None
    ): GetServiceTemplateInput =
      GetServiceTemplateInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getServiceTemplateOutput(
      serviceTemplate: Option[ServiceTemplate] = None
    ): GetServiceTemplateOutput =
      GetServiceTemplateOutput
        .builder
        .ifSome(serviceTemplate)(_.serviceTemplate(_))
        .build

    def getServiceTemplateVersionInput(
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): GetServiceTemplateVersionInput =
      GetServiceTemplateVersionInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def getServiceTemplateVersionOutput(
      serviceTemplateVersion: Option[ServiceTemplateVersion] = None
    ): GetServiceTemplateVersionOutput =
      GetServiceTemplateVersionOutput
        .builder
        .ifSome(serviceTemplateVersion)(_.serviceTemplateVersion(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listEnvironmentAccountConnectionsInput(
      environmentName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      requestedBy: Option[String] = None,
      statuses: Option[List[EnvironmentAccountConnectionStatus]] = None
    ): ListEnvironmentAccountConnectionsInput =
      ListEnvironmentAccountConnectionsInput
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(requestedBy)(_.requestedBy(_))
        .ifSome(statuses)(_.statuses(_))
        .build

    def listEnvironmentAccountConnectionsOutput(
      environmentAccountConnections: Option[List[EnvironmentAccountConnectionSummary]] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentAccountConnectionsOutput =
      ListEnvironmentAccountConnectionsOutput
        .builder
        .ifSome(environmentAccountConnections)(_.environmentAccountConnections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEnvironmentTemplateVersionsInput(
      majorVersion: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      templateName: Option[String] = None
    ): ListEnvironmentTemplateVersionsInput =
      ListEnvironmentTemplateVersionsInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def listEnvironmentTemplateVersionsOutput(
      nextToken: Option[String] = None,
      templateVersions: Option[List[EnvironmentTemplateVersionSummary]] = None
    ): ListEnvironmentTemplateVersionsOutput =
      ListEnvironmentTemplateVersionsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(templateVersions)(_.templateVersions(_))
        .build

    def listEnvironmentTemplatesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentTemplatesInput =
      ListEnvironmentTemplatesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEnvironmentTemplatesOutput(
      nextToken: Option[String] = None,
      templates: Option[List[EnvironmentTemplateSummary]] = None
    ): ListEnvironmentTemplatesOutput =
      ListEnvironmentTemplatesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(templates)(_.templates(_))
        .build

    def listEnvironmentsInput(
      environmentTemplates: Option[List[EnvironmentTemplateFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentsInput =
      ListEnvironmentsInput
        .builder
        .ifSome(environmentTemplates)(_.environmentTemplates(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEnvironmentsOutput(
      environments: Option[List[EnvironmentSummary]] = None,
      nextToken: Option[String] = None
    ): ListEnvironmentsOutput =
      ListEnvironmentsOutput
        .builder
        .ifSome(environments)(_.environments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServiceInstancesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      serviceName: Option[String] = None
    ): ListServiceInstancesInput =
      ListServiceInstancesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serviceName)(_.serviceName(_))
        .build

    def listServiceInstancesOutput(
      nextToken: Option[String] = None,
      serviceInstances: Option[List[ServiceInstanceSummary]] = None
    ): ListServiceInstancesOutput =
      ListServiceInstancesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(serviceInstances)(_.serviceInstances(_))
        .build

    def listServiceTemplateVersionsInput(
      majorVersion: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      templateName: Option[String] = None
    ): ListServiceTemplateVersionsInput =
      ListServiceTemplateVersionsInput
        .builder
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def listServiceTemplateVersionsOutput(
      nextToken: Option[String] = None,
      templateVersions: Option[List[ServiceTemplateVersionSummary]] = None
    ): ListServiceTemplateVersionsOutput =
      ListServiceTemplateVersionsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(templateVersions)(_.templateVersions(_))
        .build

    def listServiceTemplatesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListServiceTemplatesInput =
      ListServiceTemplatesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServiceTemplatesOutput(
      nextToken: Option[String] = None,
      templates: Option[List[ServiceTemplateSummary]] = None
    ): ListServiceTemplatesOutput =
      ListServiceTemplatesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(templates)(_.templates(_))
        .build

    def listServicesInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListServicesInput =
      ListServicesInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listServicesOutput(
      nextToken: Option[String] = None,
      services: Option[List[ServiceSummary]] = None
    ): ListServicesOutput =
      ListServicesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(services)(_.services(_))
        .build

    def listTagsForResourceInput(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      resourceArn: Option[String] = None
    ): ListTagsForResourceInput =
      ListTagsForResourceInput
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceOutput(
      nextToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceOutput =
      ListTagsForResourceOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def rejectEnvironmentAccountConnectionInput(
      id: Option[String] = None
    ): RejectEnvironmentAccountConnectionInput =
      RejectEnvironmentAccountConnectionInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def rejectEnvironmentAccountConnectionOutput(
      environmentAccountConnection: Option[EnvironmentAccountConnection] = None
    ): RejectEnvironmentAccountConnectionOutput =
      RejectEnvironmentAccountConnectionOutput
        .builder
        .ifSome(environmentAccountConnection)(_.environmentAccountConnection(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def s3ObjectSource(
      bucket: Option[String] = None,
      key: Option[String] = None
    ): S3ObjectSource =
      S3ObjectSource
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .build

    def service(
      arn: Option[String] = None,
      branchName: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      pipeline: Option[ServicePipeline] = None,
      repositoryConnectionArn: Option[String] = None,
      repositoryId: Option[String] = None,
      spec: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      templateName: Option[String] = None
    ): Service =
      Service
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipeline)(_.pipeline(_))
        .ifSome(repositoryConnectionArn)(_.repositoryConnectionArn(_))
        .ifSome(repositoryId)(_.repositoryId(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def serviceInstance(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      environmentName: Option[String] = None,
      lastDeploymentAttemptedAt: Option[Timestamp] = None,
      lastDeploymentSucceededAt: Option[Timestamp] = None,
      name: Option[String] = None,
      serviceName: Option[String] = None,
      spec: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): ServiceInstance =
      ServiceInstance
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(lastDeploymentAttemptedAt)(_.lastDeploymentAttemptedAt(_))
        .ifSome(lastDeploymentSucceededAt)(_.lastDeploymentSucceededAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def serviceInstanceSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      environmentName: Option[String] = None,
      lastDeploymentAttemptedAt: Option[Timestamp] = None,
      lastDeploymentSucceededAt: Option[Timestamp] = None,
      name: Option[String] = None,
      serviceName: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): ServiceInstanceSummary =
      ServiceInstanceSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(lastDeploymentAttemptedAt)(_.lastDeploymentAttemptedAt(_))
        .ifSome(lastDeploymentSucceededAt)(_.lastDeploymentSucceededAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def servicePipeline(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      deploymentStatus: Option[String] = None,
      deploymentStatusMessage: Option[String] = None,
      lastDeploymentAttemptedAt: Option[Timestamp] = None,
      lastDeploymentSucceededAt: Option[Timestamp] = None,
      spec: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None,
      templateName: Option[String] = None
    ): ServicePipeline =
      ServicePipeline
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(deploymentStatusMessage)(_.deploymentStatusMessage(_))
        .ifSome(lastDeploymentAttemptedAt)(_.lastDeploymentAttemptedAt(_))
        .ifSome(lastDeploymentSucceededAt)(_.lastDeploymentSucceededAt(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      templateName: Option[String] = None
    ): ServiceSummary =
      ServiceSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def serviceTemplate(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      encryptionKey: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      pipelineProvisioning: Option[String] = None,
      recommendedVersion: Option[String] = None
    ): ServiceTemplate =
      ServiceTemplate
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineProvisioning)(_.pipelineProvisioning(_))
        .ifSome(recommendedVersion)(_.recommendedVersion(_))
        .build

    def serviceTemplateSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      displayName: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      name: Option[String] = None,
      pipelineProvisioning: Option[String] = None,
      recommendedVersion: Option[String] = None
    ): ServiceTemplateSummary =
      ServiceTemplateSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(pipelineProvisioning)(_.pipelineProvisioning(_))
        .ifSome(recommendedVersion)(_.recommendedVersion(_))
        .build

    def serviceTemplateVersion(
      arn: Option[String] = None,
      compatibleEnvironmentTemplates: Option[List[CompatibleEnvironmentTemplate]] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      recommendedMinorVersion: Option[String] = None,
      schema: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      templateName: Option[String] = None
    ): ServiceTemplateVersion =
      ServiceTemplateVersion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(compatibleEnvironmentTemplates)(_.compatibleEnvironmentTemplates(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(recommendedMinorVersion)(_.recommendedMinorVersion(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def serviceTemplateVersionSummary(
      arn: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      description: Option[String] = None,
      lastModifiedAt: Option[Timestamp] = None,
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      recommendedMinorVersion: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      templateName: Option[String] = None
    ): ServiceTemplateVersionSummary =
      ServiceTemplateVersionSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(description)(_.description(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(recommendedMinorVersion)(_.recommendedMinorVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(templateName)(_.templateName(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceOutput(

    ): TagResourceOutput =
      TagResourceOutput
        .builder

        .build

    def templateVersionSourceInput(
      s3: Option[S3ObjectSource] = None
    ): TemplateVersionSourceInput =
      TemplateVersionSourceInput
        .builder
        .ifSome(s3)(_.s3(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceOutput(

    ): UntagResourceOutput =
      UntagResourceOutput
        .builder

        .build

    def updateAccountSettingsInput(
      pipelineServiceRoleArn: Option[String] = None
    ): UpdateAccountSettingsInput =
      UpdateAccountSettingsInput
        .builder
        .ifSome(pipelineServiceRoleArn)(_.pipelineServiceRoleArn(_))
        .build

    def updateAccountSettingsOutput(
      accountSettings: Option[AccountSettings] = None
    ): UpdateAccountSettingsOutput =
      UpdateAccountSettingsOutput
        .builder
        .ifSome(accountSettings)(_.accountSettings(_))
        .build

    def updateEnvironmentAccountConnectionInput(
      id: Option[String] = None,
      roleArn: Option[String] = None
    ): UpdateEnvironmentAccountConnectionInput =
      UpdateEnvironmentAccountConnectionInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateEnvironmentAccountConnectionOutput(
      environmentAccountConnection: Option[EnvironmentAccountConnection] = None
    ): UpdateEnvironmentAccountConnectionOutput =
      UpdateEnvironmentAccountConnectionOutput
        .builder
        .ifSome(environmentAccountConnection)(_.environmentAccountConnection(_))
        .build

    def updateEnvironmentInput(
      deploymentType: Option[String] = None,
      description: Option[String] = None,
      environmentAccountConnectionId: Option[String] = None,
      name: Option[String] = None,
      protonServiceRoleArn: Option[String] = None,
      spec: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None
    ): UpdateEnvironmentInput =
      UpdateEnvironmentInput
        .builder
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(description)(_.description(_))
        .ifSome(environmentAccountConnectionId)(_.environmentAccountConnectionId(_))
        .ifSome(name)(_.name(_))
        .ifSome(protonServiceRoleArn)(_.protonServiceRoleArn(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .build

    def updateEnvironmentOutput(
      environment: Option[Environment] = None
    ): UpdateEnvironmentOutput =
      UpdateEnvironmentOutput
        .builder
        .ifSome(environment)(_.environment(_))
        .build

    def updateEnvironmentTemplateInput(
      description: Option[String] = None,
      displayName: Option[String] = None,
      name: Option[String] = None
    ): UpdateEnvironmentTemplateInput =
      UpdateEnvironmentTemplateInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(name)(_.name(_))
        .build

    def updateEnvironmentTemplateOutput(
      environmentTemplate: Option[EnvironmentTemplate] = None
    ): UpdateEnvironmentTemplateOutput =
      UpdateEnvironmentTemplateOutput
        .builder
        .ifSome(environmentTemplate)(_.environmentTemplate(_))
        .build

    def updateEnvironmentTemplateVersionInput(
      description: Option[String] = None,
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      status: Option[String] = None,
      templateName: Option[String] = None
    ): UpdateEnvironmentTemplateVersionInput =
      UpdateEnvironmentTemplateVersionInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def updateEnvironmentTemplateVersionOutput(
      environmentTemplateVersion: Option[EnvironmentTemplateVersion] = None
    ): UpdateEnvironmentTemplateVersionOutput =
      UpdateEnvironmentTemplateVersionOutput
        .builder
        .ifSome(environmentTemplateVersion)(_.environmentTemplateVersion(_))
        .build

    def updateServiceInput(
      description: Option[String] = None,
      name: Option[String] = None,
      spec: Option[String] = None
    ): UpdateServiceInput =
      UpdateServiceInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(name)(_.name(_))
        .ifSome(spec)(_.spec(_))
        .build

    def updateServiceInstanceInput(
      deploymentType: Option[String] = None,
      name: Option[String] = None,
      serviceName: Option[String] = None,
      spec: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None
    ): UpdateServiceInstanceInput =
      UpdateServiceInstanceInput
        .builder
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(name)(_.name(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .build

    def updateServiceInstanceOutput(
      serviceInstance: Option[ServiceInstance] = None
    ): UpdateServiceInstanceOutput =
      UpdateServiceInstanceOutput
        .builder
        .ifSome(serviceInstance)(_.serviceInstance(_))
        .build

    def updateServiceOutput(
      service: Option[Service] = None
    ): UpdateServiceOutput =
      UpdateServiceOutput
        .builder
        .ifSome(service)(_.service(_))
        .build

    def updateServicePipelineInput(
      deploymentType: Option[String] = None,
      serviceName: Option[String] = None,
      spec: Option[String] = None,
      templateMajorVersion: Option[String] = None,
      templateMinorVersion: Option[String] = None
    ): UpdateServicePipelineInput =
      UpdateServicePipelineInput
        .builder
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(spec)(_.spec(_))
        .ifSome(templateMajorVersion)(_.templateMajorVersion(_))
        .ifSome(templateMinorVersion)(_.templateMinorVersion(_))
        .build

    def updateServicePipelineOutput(
      pipeline: Option[ServicePipeline] = None
    ): UpdateServicePipelineOutput =
      UpdateServicePipelineOutput
        .builder
        .ifSome(pipeline)(_.pipeline(_))
        .build

    def updateServiceTemplateInput(
      description: Option[String] = None,
      displayName: Option[String] = None,
      name: Option[String] = None
    ): UpdateServiceTemplateInput =
      UpdateServiceTemplateInput
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(name)(_.name(_))
        .build

    def updateServiceTemplateOutput(
      serviceTemplate: Option[ServiceTemplate] = None
    ): UpdateServiceTemplateOutput =
      UpdateServiceTemplateOutput
        .builder
        .ifSome(serviceTemplate)(_.serviceTemplate(_))
        .build

    def updateServiceTemplateVersionInput(
      compatibleEnvironmentTemplates: Option[List[CompatibleEnvironmentTemplateInput]] = None,
      description: Option[String] = None,
      majorVersion: Option[String] = None,
      minorVersion: Option[String] = None,
      status: Option[String] = None,
      templateName: Option[String] = None
    ): UpdateServiceTemplateVersionInput =
      UpdateServiceTemplateVersionInput
        .builder
        .ifSome(compatibleEnvironmentTemplates)(_.compatibleEnvironmentTemplates(_))
        .ifSome(description)(_.description(_))
        .ifSome(majorVersion)(_.majorVersion(_))
        .ifSome(minorVersion)(_.minorVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def updateServiceTemplateVersionOutput(
      serviceTemplateVersion: Option[ServiceTemplateVersion] = None
    ): UpdateServiceTemplateVersionOutput =
      UpdateServiceTemplateVersionOutput
        .builder
        .ifSome(serviceTemplateVersion)(_.serviceTemplateVersion(_))
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
