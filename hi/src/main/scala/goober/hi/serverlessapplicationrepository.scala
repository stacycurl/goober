package goober.hi

import goober.free.serverlessapplicationrepository.ServerlessApplicationRepositoryIO
import software.amazon.awssdk.services.serverlessapplicationrepository.model._


object serverlessapplicationrepository {
  import goober.free.{serverlessapplicationrepository ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def application(
      applicationId: Option[String] = None,
      author: Option[String] = None,
      creationTime: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      isVerifiedAuthor: Option[Boolean] = None,
      labels: Option[List[__string]] = None,
      licenseUrl: Option[String] = None,
      name: Option[String] = None,
      readmeUrl: Option[String] = None,
      spdxLicenseId: Option[String] = None,
      verifiedAuthorUrl: Option[String] = None,
      version: Option[Version] = None
    ): Application =
      Application
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(author)(_.author(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(isVerifiedAuthor)(_.isVerifiedAuthor(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(name)(_.name(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .ifSome(verifiedAuthorUrl)(_.verifiedAuthorUrl(_))
        .ifSome(version)(_.version(_))
        .build

    def applicationDependencyPage(
      dependencies: Option[List[ApplicationDependencySummary]] = None,
      nextToken: Option[String] = None
    ): ApplicationDependencyPage =
      ApplicationDependencyPage
        .builder
        .ifSome(dependencies)(_.dependencies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def applicationDependencySummary(
      applicationId: Option[String] = None,
      semanticVersion: Option[String] = None
    ): ApplicationDependencySummary =
      ApplicationDependencySummary
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .build

    def applicationPage(
      applications: Option[List[ApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ApplicationPage =
      ApplicationPage
        .builder
        .ifSome(applications)(_.applications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def applicationPolicy(
      statements: Option[List[ApplicationPolicyStatement]] = None
    ): ApplicationPolicy =
      ApplicationPolicy
        .builder
        .ifSome(statements)(_.statements(_))
        .build

    def applicationPolicyStatement(
      actions: Option[List[__string]] = None,
      principalOrgIDs: Option[List[__string]] = None,
      principals: Option[List[__string]] = None,
      statementId: Option[String] = None
    ): ApplicationPolicyStatement =
      ApplicationPolicyStatement
        .builder
        .ifSome(actions)(_.actions(_))
        .ifSome(principalOrgIDs)(_.principalOrgIDs(_))
        .ifSome(principals)(_.principals(_))
        .ifSome(statementId)(_.statementId(_))
        .build

    def applicationSummary(
      applicationId: Option[String] = None,
      author: Option[String] = None,
      creationTime: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      labels: Option[List[__string]] = None,
      name: Option[String] = None,
      spdxLicenseId: Option[String] = None
    ): ApplicationSummary =
      ApplicationSummary
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(author)(_.author(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(name)(_.name(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .build

    def applicationVersionPage(
      nextToken: Option[String] = None,
      versions: Option[List[VersionSummary]] = None
    ): ApplicationVersionPage =
      ApplicationVersionPage
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def badRequestException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def changeSetDetails(
      applicationId: Option[String] = None,
      changeSetId: Option[String] = None,
      semanticVersion: Option[String] = None,
      stackId: Option[String] = None
    ): ChangeSetDetails =
      ChangeSetDetails
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def conflictException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def createApplicationInput(
      author: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      labels: Option[List[__string]] = None,
      licenseBody: Option[String] = None,
      licenseUrl: Option[String] = None,
      name: Option[String] = None,
      readmeBody: Option[String] = None,
      readmeUrl: Option[String] = None,
      semanticVersion: Option[String] = None,
      sourceCodeArchiveUrl: Option[String] = None,
      sourceCodeUrl: Option[String] = None,
      spdxLicenseId: Option[String] = None,
      templateBody: Option[String] = None,
      templateUrl: Option[String] = None
    ): CreateApplicationInput =
      CreateApplicationInput
        .builder
        .ifSome(author)(_.author(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(licenseBody)(_.licenseBody(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(name)(_.name(_))
        .ifSome(readmeBody)(_.readmeBody(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(sourceCodeArchiveUrl)(_.sourceCodeArchiveUrl(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def createApplicationRequest(
      author: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      labels: Option[List[__string]] = None,
      licenseBody: Option[String] = None,
      licenseUrl: Option[String] = None,
      name: Option[String] = None,
      readmeBody: Option[String] = None,
      readmeUrl: Option[String] = None,
      semanticVersion: Option[String] = None,
      sourceCodeArchiveUrl: Option[String] = None,
      sourceCodeUrl: Option[String] = None,
      spdxLicenseId: Option[String] = None,
      templateBody: Option[String] = None,
      templateUrl: Option[String] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(author)(_.author(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(licenseBody)(_.licenseBody(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(name)(_.name(_))
        .ifSome(readmeBody)(_.readmeBody(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(sourceCodeArchiveUrl)(_.sourceCodeArchiveUrl(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def createApplicationResponse(
      applicationId: Option[String] = None,
      author: Option[String] = None,
      creationTime: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      isVerifiedAuthor: Option[Boolean] = None,
      labels: Option[List[__string]] = None,
      licenseUrl: Option[String] = None,
      name: Option[String] = None,
      readmeUrl: Option[String] = None,
      spdxLicenseId: Option[String] = None,
      verifiedAuthorUrl: Option[String] = None,
      version: Option[Version] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(author)(_.author(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(isVerifiedAuthor)(_.isVerifiedAuthor(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(name)(_.name(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .ifSome(verifiedAuthorUrl)(_.verifiedAuthorUrl(_))
        .ifSome(version)(_.version(_))
        .build

    def createApplicationVersionInput(
      sourceCodeArchiveUrl: Option[String] = None,
      sourceCodeUrl: Option[String] = None,
      templateBody: Option[String] = None,
      templateUrl: Option[String] = None
    ): CreateApplicationVersionInput =
      CreateApplicationVersionInput
        .builder
        .ifSome(sourceCodeArchiveUrl)(_.sourceCodeArchiveUrl(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def createApplicationVersionRequest(
      applicationId: Option[String] = None,
      semanticVersion: Option[String] = None,
      sourceCodeArchiveUrl: Option[String] = None,
      sourceCodeUrl: Option[String] = None,
      templateBody: Option[String] = None,
      templateUrl: Option[String] = None
    ): CreateApplicationVersionRequest =
      CreateApplicationVersionRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(sourceCodeArchiveUrl)(_.sourceCodeArchiveUrl(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def createApplicationVersionResponse(
      applicationId: Option[String] = None,
      creationTime: Option[String] = None,
      parameterDefinitions: Option[List[ParameterDefinition]] = None,
      requiredCapabilities: Option[List[Capability]] = None,
      resourcesSupported: Option[Boolean] = None,
      semanticVersion: Option[String] = None,
      sourceCodeArchiveUrl: Option[String] = None,
      sourceCodeUrl: Option[String] = None,
      templateUrl: Option[String] = None
    ): CreateApplicationVersionResponse =
      CreateApplicationVersionResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(parameterDefinitions)(_.parameterDefinitions(_))
        .ifSome(requiredCapabilities)(_.requiredCapabilities(_))
        .ifSome(resourcesSupported)(_.resourcesSupported(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(sourceCodeArchiveUrl)(_.sourceCodeArchiveUrl(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def createCloudFormationChangeSetInput(
      capabilities: Option[List[__string]] = None,
      changeSetName: Option[String] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      notificationArns: Option[List[__string]] = None,
      parameterOverrides: Option[List[ParameterValue]] = None,
      resourceTypes: Option[List[__string]] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      semanticVersion: Option[String] = None,
      stackName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      templateId: Option[String] = None
    ): CreateCloudFormationChangeSetInput =
      CreateCloudFormationChangeSetInput
        .builder
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(notificationArns)(_.notificationArns(_))
        .ifSome(parameterOverrides)(_.parameterOverrides(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def createCloudFormationChangeSetRequest(
      applicationId: Option[String] = None,
      capabilities: Option[List[__string]] = None,
      changeSetName: Option[String] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      notificationArns: Option[List[__string]] = None,
      parameterOverrides: Option[List[ParameterValue]] = None,
      resourceTypes: Option[List[__string]] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      semanticVersion: Option[String] = None,
      stackName: Option[String] = None,
      tags: Option[List[Tag]] = None,
      templateId: Option[String] = None
    ): CreateCloudFormationChangeSetRequest =
      CreateCloudFormationChangeSetRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(notificationArns)(_.notificationArns(_))
        .ifSome(parameterOverrides)(_.parameterOverrides(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def createCloudFormationChangeSetResponse(
      applicationId: Option[String] = None,
      changeSetId: Option[String] = None,
      semanticVersion: Option[String] = None,
      stackId: Option[String] = None
    ): CreateCloudFormationChangeSetResponse =
      CreateCloudFormationChangeSetResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def createCloudFormationTemplateRequest(
      applicationId: Option[String] = None,
      semanticVersion: Option[String] = None
    ): CreateCloudFormationTemplateRequest =
      CreateCloudFormationTemplateRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .build

    def createCloudFormationTemplateResponse(
      applicationId: Option[String] = None,
      creationTime: Option[String] = None,
      expirationTime: Option[String] = None,
      semanticVersion: Option[String] = None,
      status: Option[String] = None,
      templateId: Option[String] = None,
      templateUrl: Option[String] = None
    ): CreateCloudFormationTemplateResponse =
      CreateCloudFormationTemplateResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def deleteApplicationRequest(
      applicationId: Option[String] = None
    ): DeleteApplicationRequest =
      DeleteApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def forbiddenException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def getApplicationPolicyRequest(
      applicationId: Option[String] = None
    ): GetApplicationPolicyRequest =
      GetApplicationPolicyRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .build

    def getApplicationPolicyResponse(
      statements: Option[List[ApplicationPolicyStatement]] = None
    ): GetApplicationPolicyResponse =
      GetApplicationPolicyResponse
        .builder
        .ifSome(statements)(_.statements(_))
        .build

    def getApplicationRequest(
      applicationId: Option[String] = None,
      semanticVersion: Option[String] = None
    ): GetApplicationRequest =
      GetApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .build

    def getApplicationResponse(
      applicationId: Option[String] = None,
      author: Option[String] = None,
      creationTime: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      isVerifiedAuthor: Option[Boolean] = None,
      labels: Option[List[__string]] = None,
      licenseUrl: Option[String] = None,
      name: Option[String] = None,
      readmeUrl: Option[String] = None,
      spdxLicenseId: Option[String] = None,
      verifiedAuthorUrl: Option[String] = None,
      version: Option[Version] = None
    ): GetApplicationResponse =
      GetApplicationResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(author)(_.author(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(isVerifiedAuthor)(_.isVerifiedAuthor(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(name)(_.name(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .ifSome(verifiedAuthorUrl)(_.verifiedAuthorUrl(_))
        .ifSome(version)(_.version(_))
        .build

    def getCloudFormationTemplateRequest(
      applicationId: Option[String] = None,
      templateId: Option[String] = None
    ): GetCloudFormationTemplateRequest =
      GetCloudFormationTemplateRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(templateId)(_.templateId(_))
        .build

    def getCloudFormationTemplateResponse(
      applicationId: Option[String] = None,
      creationTime: Option[String] = None,
      expirationTime: Option[String] = None,
      semanticVersion: Option[String] = None,
      status: Option[String] = None,
      templateId: Option[String] = None,
      templateUrl: Option[String] = None
    ): GetCloudFormationTemplateResponse =
      GetCloudFormationTemplateResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def internalServerErrorException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): InternalServerErrorException =
      InternalServerErrorException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def listApplicationDependenciesRequest(
      applicationId: Option[String] = None,
      maxItems: Option[Int] = None,
      nextToken: Option[String] = None,
      semanticVersion: Option[String] = None
    ): ListApplicationDependenciesRequest =
      ListApplicationDependenciesRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .build

    def listApplicationDependenciesResponse(
      dependencies: Option[List[ApplicationDependencySummary]] = None,
      nextToken: Option[String] = None
    ): ListApplicationDependenciesResponse =
      ListApplicationDependenciesResponse
        .builder
        .ifSome(dependencies)(_.dependencies(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationVersionsRequest(
      applicationId: Option[String] = None,
      maxItems: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationVersionsRequest =
      ListApplicationVersionsRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationVersionsResponse(
      nextToken: Option[String] = None,
      versions: Option[List[VersionSummary]] = None
    ): ListApplicationVersionsResponse =
      ListApplicationVersionsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(versions)(_.versions(_))
        .build

    def listApplicationsRequest(
      maxItems: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(maxItems)(_.maxItems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsResponse(
      applications: Option[List[ApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ListApplicationsResponse =
      ListApplicationsResponse
        .builder
        .ifSome(applications)(_.applications(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def notFoundException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def parameterDefinition(
      allowedPattern: Option[String] = None,
      allowedValues: Option[List[__string]] = None,
      constraintDescription: Option[String] = None,
      defaultValue: Option[String] = None,
      description: Option[String] = None,
      maxLength: Option[Int] = None,
      maxValue: Option[Int] = None,
      minLength: Option[Int] = None,
      minValue: Option[Int] = None,
      name: Option[String] = None,
      noEcho: Option[Boolean] = None,
      referencedByResources: Option[List[__string]] = None,
      `type`: Option[String] = None
    ): ParameterDefinition =
      ParameterDefinition
        .builder
        .ifSome(allowedPattern)(_.allowedPattern(_))
        .ifSome(allowedValues)(_.allowedValues(_))
        .ifSome(constraintDescription)(_.constraintDescription(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(maxLength)(_.maxLength(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(minLength)(_.minLength(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(name)(_.name(_))
        .ifSome(noEcho)(_.noEcho(_))
        .ifSome(referencedByResources)(_.referencedByResources(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def parameterValue(
      name: Option[String] = None,
      value: Option[String] = None
    ): ParameterValue =
      ParameterValue
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def putApplicationPolicyRequest(
      applicationId: Option[String] = None,
      statements: Option[List[ApplicationPolicyStatement]] = None
    ): PutApplicationPolicyRequest =
      PutApplicationPolicyRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(statements)(_.statements(_))
        .build

    def putApplicationPolicyResponse(
      statements: Option[List[ApplicationPolicyStatement]] = None
    ): PutApplicationPolicyResponse =
      PutApplicationPolicyResponse
        .builder
        .ifSome(statements)(_.statements(_))
        .build

    def rollbackConfiguration(
      monitoringTimeInMinutes: Option[Int] = None,
      rollbackTriggers: Option[List[RollbackTrigger]] = None
    ): RollbackConfiguration =
      RollbackConfiguration
        .builder
        .ifSome(monitoringTimeInMinutes)(_.monitoringTimeInMinutes(_))
        .ifSome(rollbackTriggers)(_.rollbackTriggers(_))
        .build

    def rollbackTrigger(
      arn: Option[String] = None,
      `type`: Option[String] = None
    ): RollbackTrigger =
      RollbackTrigger
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
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

    def templateDetails(
      applicationId: Option[String] = None,
      creationTime: Option[String] = None,
      expirationTime: Option[String] = None,
      semanticVersion: Option[String] = None,
      status: Option[String] = None,
      templateId: Option[String] = None,
      templateUrl: Option[String] = None
    ): TemplateDetails =
      TemplateDetails
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(expirationTime)(_.expirationTime(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(status)(_.status(_))
        .ifSome(templateId)(_.templateId(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def tooManyRequestsException(
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def unshareApplicationInput(
      organizationId: Option[String] = None
    ): UnshareApplicationInput =
      UnshareApplicationInput
        .builder
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def unshareApplicationRequest(
      applicationId: Option[String] = None,
      organizationId: Option[String] = None
    ): UnshareApplicationRequest =
      UnshareApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(organizationId)(_.organizationId(_))
        .build

    def updateApplicationInput(
      author: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      labels: Option[List[__string]] = None,
      readmeBody: Option[String] = None,
      readmeUrl: Option[String] = None
    ): UpdateApplicationInput =
      UpdateApplicationInput
        .builder
        .ifSome(author)(_.author(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(readmeBody)(_.readmeBody(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .build

    def updateApplicationRequest(
      applicationId: Option[String] = None,
      author: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      labels: Option[List[__string]] = None,
      readmeBody: Option[String] = None,
      readmeUrl: Option[String] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(author)(_.author(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(readmeBody)(_.readmeBody(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .build

    def updateApplicationResponse(
      applicationId: Option[String] = None,
      author: Option[String] = None,
      creationTime: Option[String] = None,
      description: Option[String] = None,
      homePageUrl: Option[String] = None,
      isVerifiedAuthor: Option[Boolean] = None,
      labels: Option[List[__string]] = None,
      licenseUrl: Option[String] = None,
      name: Option[String] = None,
      readmeUrl: Option[String] = None,
      spdxLicenseId: Option[String] = None,
      verifiedAuthorUrl: Option[String] = None,
      version: Option[Version] = None
    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(author)(_.author(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(homePageUrl)(_.homePageUrl(_))
        .ifSome(isVerifiedAuthor)(_.isVerifiedAuthor(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(licenseUrl)(_.licenseUrl(_))
        .ifSome(name)(_.name(_))
        .ifSome(readmeUrl)(_.readmeUrl(_))
        .ifSome(spdxLicenseId)(_.spdxLicenseId(_))
        .ifSome(verifiedAuthorUrl)(_.verifiedAuthorUrl(_))
        .ifSome(version)(_.version(_))
        .build

    def version(
      applicationId: Option[String] = None,
      creationTime: Option[String] = None,
      parameterDefinitions: Option[List[ParameterDefinition]] = None,
      requiredCapabilities: Option[List[Capability]] = None,
      resourcesSupported: Option[Boolean] = None,
      semanticVersion: Option[String] = None,
      sourceCodeArchiveUrl: Option[String] = None,
      sourceCodeUrl: Option[String] = None,
      templateUrl: Option[String] = None
    ): Version =
      Version
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(parameterDefinitions)(_.parameterDefinitions(_))
        .ifSome(requiredCapabilities)(_.requiredCapabilities(_))
        .ifSome(resourcesSupported)(_.resourcesSupported(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(sourceCodeArchiveUrl)(_.sourceCodeArchiveUrl(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .ifSome(templateUrl)(_.templateUrl(_))
        .build

    def versionSummary(
      applicationId: Option[String] = None,
      creationTime: Option[String] = None,
      semanticVersion: Option[String] = None,
      sourceCodeUrl: Option[String] = None
    ): VersionSummary =
      VersionSummary
        .builder
        .ifSome(applicationId)(_.applicationId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(sourceCodeUrl)(_.sourceCodeUrl(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
