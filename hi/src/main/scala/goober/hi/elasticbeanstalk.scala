package goober.hi

import goober.free.elasticbeanstalk.ElasticBeanstalkIO
import software.amazon.awssdk.services.elasticbeanstalk.model._


object elasticbeanstalk {
  import goober.free.{elasticbeanstalk ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abortEnvironmentUpdateMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None
    ): AbortEnvironmentUpdateMessage =
      AbortEnvironmentUpdateMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def applicationDescription(
      applicationArn: Option[String] = None,
      applicationName: Option[String] = None,
      description: Option[String] = None,
      dateCreated: Option[CreationDate] = None,
      dateUpdated: Option[UpdateDate] = None,
      versions: Option[List[VersionLabel]] = None,
      configurationTemplates: Option[List[ConfigurationTemplateName]] = None,
      resourceLifecycleConfig: Option[ApplicationResourceLifecycleConfig] = None
    ): ApplicationDescription =
      ApplicationDescription
        .builder
        .ifSome(applicationArn)(_.applicationArn(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(description)(_.description(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(versions)(_.versions(_))
        .ifSome(configurationTemplates)(_.configurationTemplates(_))
        .ifSome(resourceLifecycleConfig)(_.resourceLifecycleConfig(_))
        .build

    def applicationDescriptionMessage(
      application: Option[ApplicationDescription] = None
    ): ApplicationDescriptionMessage =
      ApplicationDescriptionMessage
        .builder
        .ifSome(application)(_.application(_))
        .build

    def applicationDescriptionsMessage(
      applications: Option[List[ApplicationDescription]] = None
    ): ApplicationDescriptionsMessage =
      ApplicationDescriptionsMessage
        .builder
        .ifSome(applications)(_.applications(_))
        .build

    def applicationMetrics(
      duration: Option[Int] = None,
      requestCount: Option[Int] = None,
      statusCodes: Option[StatusCodes] = None,
      latency: Option[Latency] = None
    ): ApplicationMetrics =
      ApplicationMetrics
        .builder
        .ifSome(duration)(_.duration(_))
        .ifSome(requestCount)(_.requestCount(_))
        .ifSome(statusCodes)(_.statusCodes(_))
        .ifSome(latency)(_.latency(_))
        .build

    def applicationResourceLifecycleConfig(
      serviceRole: Option[String] = None,
      versionLifecycleConfig: Option[ApplicationVersionLifecycleConfig] = None
    ): ApplicationResourceLifecycleConfig =
      ApplicationResourceLifecycleConfig
        .builder
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(versionLifecycleConfig)(_.versionLifecycleConfig(_))
        .build

    def applicationResourceLifecycleDescriptionMessage(
      applicationName: Option[String] = None,
      resourceLifecycleConfig: Option[ApplicationResourceLifecycleConfig] = None
    ): ApplicationResourceLifecycleDescriptionMessage =
      ApplicationResourceLifecycleDescriptionMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(resourceLifecycleConfig)(_.resourceLifecycleConfig(_))
        .build

    def applicationVersionDescription(
      applicationVersionArn: Option[String] = None,
      applicationName: Option[String] = None,
      description: Option[String] = None,
      versionLabel: Option[String] = None,
      sourceBuildInformation: Option[SourceBuildInformation] = None,
      buildArn: Option[String] = None,
      sourceBundle: Option[S3Location] = None,
      dateCreated: Option[CreationDate] = None,
      dateUpdated: Option[UpdateDate] = None,
      status: Option[String] = None
    ): ApplicationVersionDescription =
      ApplicationVersionDescription
        .builder
        .ifSome(applicationVersionArn)(_.applicationVersionArn(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(description)(_.description(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(sourceBuildInformation)(_.sourceBuildInformation(_))
        .ifSome(buildArn)(_.buildArn(_))
        .ifSome(sourceBundle)(_.sourceBundle(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(status)(_.status(_))
        .build

    def applicationVersionDescriptionMessage(
      applicationVersion: Option[ApplicationVersionDescription] = None
    ): ApplicationVersionDescriptionMessage =
      ApplicationVersionDescriptionMessage
        .builder
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .build

    def applicationVersionDescriptionsMessage(
      applicationVersions: Option[List[ApplicationVersionDescription]] = None,
      nextToken: Option[String] = None
    ): ApplicationVersionDescriptionsMessage =
      ApplicationVersionDescriptionsMessage
        .builder
        .ifSome(applicationVersions)(_.applicationVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def applicationVersionLifecycleConfig(
      maxCountRule: Option[MaxCountRule] = None,
      maxAgeRule: Option[MaxAgeRule] = None
    ): ApplicationVersionLifecycleConfig =
      ApplicationVersionLifecycleConfig
        .builder
        .ifSome(maxCountRule)(_.maxCountRule(_))
        .ifSome(maxAgeRule)(_.maxAgeRule(_))
        .build

    def applyEnvironmentManagedActionRequest(
      environmentName: Option[String] = None,
      environmentId: Option[String] = None,
      actionId: Option[String] = None
    ): ApplyEnvironmentManagedActionRequest =
      ApplyEnvironmentManagedActionRequest
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def associateEnvironmentOperationsRoleMessage(
      environmentName: Option[String] = None,
      operationsRole: Option[String] = None
    ): AssociateEnvironmentOperationsRoleMessage =
      AssociateEnvironmentOperationsRoleMessage
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(operationsRole)(_.operationsRole(_))
        .build

    def autoScalingGroup(
      name: Option[String] = None
    ): AutoScalingGroup =
      AutoScalingGroup
        .builder
        .ifSome(name)(_.name(_))
        .build

    def buildConfiguration(
      artifactName: Option[String] = None,
      codeBuildServiceRole: Option[String] = None,
      computeType: Option[String] = None,
      image: Option[String] = None,
      timeoutInMinutes: Option[Int] = None
    ): BuildConfiguration =
      BuildConfiguration
        .builder
        .ifSome(artifactName)(_.artifactName(_))
        .ifSome(codeBuildServiceRole)(_.codeBuildServiceRole(_))
        .ifSome(computeType)(_.computeType(_))
        .ifSome(image)(_.image(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .build

    def builder(
      aRN: Option[String] = None
    ): Builder =
      Builder
        .builder
        .ifSome(aRN)(_.aRN(_))
        .build

    def cPUUtilization(
      user: Option[NullableDouble] = None,
      nice: Option[NullableDouble] = None,
      system: Option[NullableDouble] = None,
      idle: Option[NullableDouble] = None,
      iOWait: Option[NullableDouble] = None,
      iRQ: Option[NullableDouble] = None,
      softIRQ: Option[NullableDouble] = None,
      privileged: Option[NullableDouble] = None
    ): CPUUtilization =
      CPUUtilization
        .builder
        .ifSome(user)(_.user(_))
        .ifSome(nice)(_.nice(_))
        .ifSome(system)(_.system(_))
        .ifSome(idle)(_.idle(_))
        .ifSome(iOWait)(_.iOWait(_))
        .ifSome(iRQ)(_.iRQ(_))
        .ifSome(softIRQ)(_.softIRQ(_))
        .ifSome(privileged)(_.privileged(_))
        .build

    def checkDNSAvailabilityMessage(
      cNAMEPrefix: Option[String] = None
    ): CheckDNSAvailabilityMessage =
      CheckDNSAvailabilityMessage
        .builder
        .ifSome(cNAMEPrefix)(_.cNAMEPrefix(_))
        .build

    def checkDNSAvailabilityResultMessage(
      available: Option[Boolean] = None,
      fullyQualifiedCNAME: Option[String] = None
    ): CheckDNSAvailabilityResultMessage =
      CheckDNSAvailabilityResultMessage
        .builder
        .ifSome(available)(_.available(_))
        .ifSome(fullyQualifiedCNAME)(_.fullyQualifiedCNAME(_))
        .build

    def codeBuildNotInServiceRegionException(

    ): CodeBuildNotInServiceRegionException =
      CodeBuildNotInServiceRegionException
        .builder

        .build

    def composeEnvironmentsMessage(
      applicationName: Option[String] = None,
      groupName: Option[String] = None,
      versionLabels: Option[List[VersionLabel]] = None
    ): ComposeEnvironmentsMessage =
      ComposeEnvironmentsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(versionLabels)(_.versionLabels(_))
        .build

    def configurationOptionDescription(
      namespace: Option[String] = None,
      name: Option[String] = None,
      defaultValue: Option[String] = None,
      changeSeverity: Option[String] = None,
      userDefined: Option[Boolean] = None,
      valueType: Option[String] = None,
      valueOptions: Option[List[ConfigurationOptionPossibleValue]] = None,
      minValue: Option[Int] = None,
      maxValue: Option[Int] = None,
      maxLength: Option[Int] = None,
      regex: Option[OptionRestrictionRegex] = None
    ): ConfigurationOptionDescription =
      ConfigurationOptionDescription
        .builder
        .ifSome(namespace)(_.namespace(_))
        .ifSome(name)(_.name(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(changeSeverity)(_.changeSeverity(_))
        .ifSome(userDefined)(_.userDefined(_))
        .ifSome(valueType)(_.valueType(_))
        .ifSome(valueOptions)(_.valueOptions(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(maxLength)(_.maxLength(_))
        .ifSome(regex)(_.regex(_))
        .build

    def configurationOptionSetting(
      resourceName: Option[String] = None,
      namespace: Option[String] = None,
      optionName: Option[String] = None,
      value: Option[String] = None
    ): ConfigurationOptionSetting =
      ConfigurationOptionSetting
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(optionName)(_.optionName(_))
        .ifSome(value)(_.value(_))
        .build

    def configurationOptionsDescription(
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      options: Option[List[ConfigurationOptionDescription]] = None
    ): ConfigurationOptionsDescription =
      ConfigurationOptionsDescription
        .builder
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(options)(_.options(_))
        .build

    def configurationSettingsDescription(
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      applicationName: Option[String] = None,
      templateName: Option[String] = None,
      description: Option[String] = None,
      environmentName: Option[String] = None,
      deploymentStatus: Option[String] = None,
      dateCreated: Option[CreationDate] = None,
      dateUpdated: Option[UpdateDate] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None
    ): ConfigurationSettingsDescription =
      ConfigurationSettingsDescription
        .builder
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(deploymentStatus)(_.deploymentStatus(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .build

    def configurationSettingsDescriptions(
      configurationSettings: Option[List[ConfigurationSettingsDescription]] = None
    ): ConfigurationSettingsDescriptions =
      ConfigurationSettingsDescriptions
        .builder
        .ifSome(configurationSettings)(_.configurationSettings(_))
        .build

    def configurationSettingsValidationMessages(
      messages: Option[List[ValidationMessage]] = None
    ): ConfigurationSettingsValidationMessages =
      ConfigurationSettingsValidationMessages
        .builder
        .ifSome(messages)(_.messages(_))
        .build

    def createApplicationMessage(
      applicationName: Option[String] = None,
      description: Option[String] = None,
      resourceLifecycleConfig: Option[ApplicationResourceLifecycleConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateApplicationMessage =
      CreateApplicationMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(description)(_.description(_))
        .ifSome(resourceLifecycleConfig)(_.resourceLifecycleConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createApplicationVersionMessage(
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      description: Option[String] = None,
      sourceBuildInformation: Option[SourceBuildInformation] = None,
      sourceBundle: Option[S3Location] = None,
      buildConfiguration: Option[BuildConfiguration] = None,
      autoCreateApplication: Option[Boolean] = None,
      process: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateApplicationVersionMessage =
      CreateApplicationVersionMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(description)(_.description(_))
        .ifSome(sourceBuildInformation)(_.sourceBuildInformation(_))
        .ifSome(sourceBundle)(_.sourceBundle(_))
        .ifSome(buildConfiguration)(_.buildConfiguration(_))
        .ifSome(autoCreateApplication)(_.autoCreateApplication(_))
        .ifSome(process)(_.process(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createConfigurationTemplateMessage(
      applicationName: Option[String] = None,
      templateName: Option[String] = None,
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      sourceConfiguration: Option[SourceConfiguration] = None,
      environmentId: Option[String] = None,
      description: Option[String] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None,
      tags: Option[List[Tag]] = None
    ): CreateConfigurationTemplateMessage =
      CreateConfigurationTemplateMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(sourceConfiguration)(_.sourceConfiguration(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(description)(_.description(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createEnvironmentMessage(
      applicationName: Option[String] = None,
      environmentName: Option[String] = None,
      groupName: Option[String] = None,
      description: Option[String] = None,
      cNAMEPrefix: Option[String] = None,
      tier: Option[EnvironmentTier] = None,
      tags: Option[List[Tag]] = None,
      versionLabel: Option[String] = None,
      templateName: Option[String] = None,
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None,
      optionsToRemove: Option[List[OptionSpecification]] = None,
      operationsRole: Option[String] = None
    ): CreateEnvironmentMessage =
      CreateEnvironmentMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(cNAMEPrefix)(_.cNAMEPrefix(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(optionsToRemove)(_.optionsToRemove(_))
        .ifSome(operationsRole)(_.operationsRole(_))
        .build

    def createPlatformVersionRequest(
      platformName: Option[String] = None,
      platformVersion: Option[String] = None,
      platformDefinitionBundle: Option[S3Location] = None,
      environmentName: Option[String] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None,
      tags: Option[List[Tag]] = None
    ): CreatePlatformVersionRequest =
      CreatePlatformVersionRequest
        .builder
        .ifSome(platformName)(_.platformName(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(platformDefinitionBundle)(_.platformDefinitionBundle(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStorageLocationResultMessage(
      s3Bucket: Option[String] = None
    ): CreateStorageLocationResultMessage =
      CreateStorageLocationResultMessage
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .build

    def customAmi(
      virtualizationType: Option[String] = None,
      imageId: Option[String] = None
    ): CustomAmi =
      CustomAmi
        .builder
        .ifSome(virtualizationType)(_.virtualizationType(_))
        .ifSome(imageId)(_.imageId(_))
        .build

    def deleteApplicationMessage(
      applicationName: Option[String] = None,
      terminateEnvByForce: Option[Boolean] = None
    ): DeleteApplicationMessage =
      DeleteApplicationMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(terminateEnvByForce)(_.terminateEnvByForce(_))
        .build

    def deleteApplicationVersionMessage(
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      deleteSourceBundle: Option[Boolean] = None
    ): DeleteApplicationVersionMessage =
      DeleteApplicationVersionMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(deleteSourceBundle)(_.deleteSourceBundle(_))
        .build

    def deleteConfigurationTemplateMessage(
      applicationName: Option[String] = None,
      templateName: Option[String] = None
    ): DeleteConfigurationTemplateMessage =
      DeleteConfigurationTemplateMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteEnvironmentConfigurationMessage(
      applicationName: Option[String] = None,
      environmentName: Option[String] = None
    ): DeleteEnvironmentConfigurationMessage =
      DeleteEnvironmentConfigurationMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def deletePlatformVersionRequest(
      platformArn: Option[String] = None
    ): DeletePlatformVersionRequest =
      DeletePlatformVersionRequest
        .builder
        .ifSome(platformArn)(_.platformArn(_))
        .build

    def deployment(
      versionLabel: Option[String] = None,
      deploymentId: Option[NullableLong] = None,
      status: Option[String] = None,
      deploymentTime: Option[DeploymentTimestamp] = None
    ): Deployment =
      Deployment
        .builder
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(deploymentId)(_.deploymentId(_))
        .ifSome(status)(_.status(_))
        .ifSome(deploymentTime)(_.deploymentTime(_))
        .build

    def describeApplicationVersionsMessage(
      applicationName: Option[String] = None,
      versionLabels: Option[List[VersionLabel]] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeApplicationVersionsMessage =
      DescribeApplicationVersionsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabels)(_.versionLabels(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeApplicationsMessage(
      applicationNames: Option[List[ApplicationName]] = None
    ): DescribeApplicationsMessage =
      DescribeApplicationsMessage
        .builder
        .ifSome(applicationNames)(_.applicationNames(_))
        .build

    def describeConfigurationOptionsMessage(
      applicationName: Option[String] = None,
      templateName: Option[String] = None,
      environmentName: Option[String] = None,
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      options: Option[List[OptionSpecification]] = None
    ): DescribeConfigurationOptionsMessage =
      DescribeConfigurationOptionsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(options)(_.options(_))
        .build

    def describeConfigurationSettingsMessage(
      applicationName: Option[String] = None,
      templateName: Option[String] = None,
      environmentName: Option[String] = None
    ): DescribeConfigurationSettingsMessage =
      DescribeConfigurationSettingsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def describeEnvironmentHealthRequest(
      environmentName: Option[String] = None,
      environmentId: Option[String] = None,
      attributeNames: Option[List[EnvironmentHealthAttribute]] = None
    ): DescribeEnvironmentHealthRequest =
      DescribeEnvironmentHealthRequest
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def describeEnvironmentManagedActionHistoryRequest(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None,
      nextToken: Option[String] = None,
      maxItems: Option[Int] = None
    ): DescribeEnvironmentManagedActionHistoryRequest =
      DescribeEnvironmentManagedActionHistoryRequest
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxItems)(_.maxItems(_))
        .build

    def describeEnvironmentManagedActionsRequest(
      environmentName: Option[String] = None,
      environmentId: Option[String] = None,
      status: Option[String] = None
    ): DescribeEnvironmentManagedActionsRequest =
      DescribeEnvironmentManagedActionsRequest
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(status)(_.status(_))
        .build

    def describeEnvironmentResourcesMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None
    ): DescribeEnvironmentResourcesMessage =
      DescribeEnvironmentResourcesMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def describeEnvironmentsMessage(
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      environmentIds: Option[List[EnvironmentId]] = None,
      environmentNames: Option[List[EnvironmentName]] = None,
      includeDeleted: Option[Boolean] = None,
      includedDeletedBackTo: Option[IncludeDeletedBackTo] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeEnvironmentsMessage =
      DescribeEnvironmentsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(environmentIds)(_.environmentIds(_))
        .ifSome(environmentNames)(_.environmentNames(_))
        .ifSome(includeDeleted)(_.includeDeleted(_))
        .ifSome(includedDeletedBackTo)(_.includedDeletedBackTo(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeEventsMessage(
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      templateName: Option[String] = None,
      environmentId: Option[String] = None,
      environmentName: Option[String] = None,
      platformArn: Option[String] = None,
      requestId: Option[String] = None,
      severity: Option[String] = None,
      startTime: Option[TimeFilterStart] = None,
      endTime: Option[TimeFilterEnd] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeEventsMessage =
      DescribeEventsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeInstancesHealthRequest(
      environmentName: Option[String] = None,
      environmentId: Option[String] = None,
      attributeNames: Option[List[InstancesHealthAttribute]] = None,
      nextToken: Option[String] = None
    ): DescribeInstancesHealthRequest =
      DescribeInstancesHealthRequest
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describePlatformVersionRequest(
      platformArn: Option[String] = None
    ): DescribePlatformVersionRequest =
      DescribePlatformVersionRequest
        .builder
        .ifSome(platformArn)(_.platformArn(_))
        .build

    def disassociateEnvironmentOperationsRoleMessage(
      environmentName: Option[String] = None
    ): DisassociateEnvironmentOperationsRoleMessage =
      DisassociateEnvironmentOperationsRoleMessage
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def elasticBeanstalkServiceException(
      message: Option[String] = None
    ): ElasticBeanstalkServiceException =
      ElasticBeanstalkServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def environmentDescription(
      environmentName: Option[String] = None,
      environmentId: Option[String] = None,
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      templateName: Option[String] = None,
      description: Option[String] = None,
      endpointURL: Option[String] = None,
      cNAME: Option[String] = None,
      dateCreated: Option[CreationDate] = None,
      dateUpdated: Option[UpdateDate] = None,
      status: Option[String] = None,
      abortableOperationInProgress: Option[Boolean] = None,
      health: Option[String] = None,
      healthStatus: Option[String] = None,
      resources: Option[EnvironmentResourcesDescription] = None,
      tier: Option[EnvironmentTier] = None,
      environmentLinks: Option[List[EnvironmentLink]] = None,
      environmentArn: Option[String] = None,
      operationsRole: Option[String] = None
    ): EnvironmentDescription =
      EnvironmentDescription
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(endpointURL)(_.endpointURL(_))
        .ifSome(cNAME)(_.cNAME(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(status)(_.status(_))
        .ifSome(abortableOperationInProgress)(_.abortableOperationInProgress(_))
        .ifSome(health)(_.health(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(environmentLinks)(_.environmentLinks(_))
        .ifSome(environmentArn)(_.environmentArn(_))
        .ifSome(operationsRole)(_.operationsRole(_))
        .build

    def environmentDescriptionsMessage(
      environments: Option[List[EnvironmentDescription]] = None,
      nextToken: Option[String] = None
    ): EnvironmentDescriptionsMessage =
      EnvironmentDescriptionsMessage
        .builder
        .ifSome(environments)(_.environments(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def environmentInfoDescription(
      infoType: Option[String] = None,
      ec2InstanceId: Option[String] = None,
      sampleTimestamp: Option[SampleTimestamp] = None,
      message: Option[String] = None
    ): EnvironmentInfoDescription =
      EnvironmentInfoDescription
        .builder
        .ifSome(infoType)(_.infoType(_))
        .ifSome(ec2InstanceId)(_.ec2InstanceId(_))
        .ifSome(sampleTimestamp)(_.sampleTimestamp(_))
        .ifSome(message)(_.message(_))
        .build

    def environmentLink(
      linkName: Option[String] = None,
      environmentName: Option[String] = None
    ): EnvironmentLink =
      EnvironmentLink
        .builder
        .ifSome(linkName)(_.linkName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def environmentResourceDescription(
      environmentName: Option[String] = None,
      autoScalingGroups: Option[List[AutoScalingGroup]] = None,
      instances: Option[List[Instance]] = None,
      launchConfigurations: Option[List[LaunchConfiguration]] = None,
      launchTemplates: Option[List[LaunchTemplate]] = None,
      loadBalancers: Option[List[LoadBalancer]] = None,
      triggers: Option[List[Trigger]] = None,
      queues: Option[List[Queue]] = None
    ): EnvironmentResourceDescription =
      EnvironmentResourceDescription
        .builder
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(autoScalingGroups)(_.autoScalingGroups(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(launchConfigurations)(_.launchConfigurations(_))
        .ifSome(launchTemplates)(_.launchTemplates(_))
        .ifSome(loadBalancers)(_.loadBalancers(_))
        .ifSome(triggers)(_.triggers(_))
        .ifSome(queues)(_.queues(_))
        .build

    def environmentResourceDescriptionsMessage(
      environmentResources: Option[EnvironmentResourceDescription] = None
    ): EnvironmentResourceDescriptionsMessage =
      EnvironmentResourceDescriptionsMessage
        .builder
        .ifSome(environmentResources)(_.environmentResources(_))
        .build

    def environmentResourcesDescription(
      loadBalancer: Option[LoadBalancerDescription] = None
    ): EnvironmentResourcesDescription =
      EnvironmentResourcesDescription
        .builder
        .ifSome(loadBalancer)(_.loadBalancer(_))
        .build

    def environmentTier(
      name: Option[String] = None,
      `type`: Option[String] = None,
      version: Option[String] = None
    ): EnvironmentTier =
      EnvironmentTier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(version)(_.version(_))
        .build

    def eventDescription(
      eventDate: Option[EventDate] = None,
      message: Option[String] = None,
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      templateName: Option[String] = None,
      environmentName: Option[String] = None,
      platformArn: Option[String] = None,
      requestId: Option[String] = None,
      severity: Option[String] = None
    ): EventDescription =
      EventDescription
        .builder
        .ifSome(eventDate)(_.eventDate(_))
        .ifSome(message)(_.message(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(requestId)(_.requestId(_))
        .ifSome(severity)(_.severity(_))
        .build

    def eventDescriptionsMessage(
      events: Option[List[EventDescription]] = None,
      nextToken: Option[String] = None
    ): EventDescriptionsMessage =
      EventDescriptionsMessage
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def instance(
      id: Option[String] = None
    ): Instance =
      Instance
        .builder
        .ifSome(id)(_.id(_))
        .build

    def instanceHealthSummary(
      noData: Option[Int] = None,
      unknown: Option[Int] = None,
      pending: Option[Int] = None,
      ok: Option[Int] = None,
      info: Option[Int] = None,
      warning: Option[Int] = None,
      degraded: Option[Int] = None,
      severe: Option[Int] = None
    ): InstanceHealthSummary =
      InstanceHealthSummary
        .builder
        .ifSome(noData)(_.noData(_))
        .ifSome(unknown)(_.unknown(_))
        .ifSome(pending)(_.pending(_))
        .ifSome(ok)(_.ok(_))
        .ifSome(info)(_.info(_))
        .ifSome(warning)(_.warning(_))
        .ifSome(degraded)(_.degraded(_))
        .ifSome(severe)(_.severe(_))
        .build

    def insufficientPrivilegesException(

    ): InsufficientPrivilegesException =
      InsufficientPrivilegesException
        .builder

        .build

    def invalidRequestException(

    ): InvalidRequestException =
      InvalidRequestException
        .builder

        .build

    def latency(
      p999: Option[NullableDouble] = None,
      p99: Option[NullableDouble] = None,
      p95: Option[NullableDouble] = None,
      p90: Option[NullableDouble] = None,
      p85: Option[NullableDouble] = None,
      p75: Option[NullableDouble] = None,
      p50: Option[NullableDouble] = None,
      p10: Option[NullableDouble] = None
    ): Latency =
      Latency
        .builder
        .ifSome(p999)(_.p999(_))
        .ifSome(p99)(_.p99(_))
        .ifSome(p95)(_.p95(_))
        .ifSome(p90)(_.p90(_))
        .ifSome(p85)(_.p85(_))
        .ifSome(p75)(_.p75(_))
        .ifSome(p50)(_.p50(_))
        .ifSome(p10)(_.p10(_))
        .build

    def launchConfiguration(
      name: Option[String] = None
    ): LaunchConfiguration =
      LaunchConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .build

    def launchTemplate(
      id: Option[String] = None
    ): LaunchTemplate =
      LaunchTemplate
        .builder
        .ifSome(id)(_.id(_))
        .build

    def listAvailableSolutionStacksResultMessage(
      solutionStacks: Option[List[SolutionStackName]] = None,
      solutionStackDetails: Option[List[SolutionStackDescription]] = None
    ): ListAvailableSolutionStacksResultMessage =
      ListAvailableSolutionStacksResultMessage
        .builder
        .ifSome(solutionStacks)(_.solutionStacks(_))
        .ifSome(solutionStackDetails)(_.solutionStackDetails(_))
        .build

    def listPlatformBranchesRequest(
      filters: Option[List[SearchFilter]] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPlatformBranchesRequest =
      ListPlatformBranchesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPlatformVersionsRequest(
      filters: Option[List[PlatformFilter]] = None,
      maxRecords: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListPlatformVersionsRequest =
      ListPlatformVersionsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxRecords)(_.maxRecords(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceMessage(
      resourceArn: Option[String] = None
    ): ListTagsForResourceMessage =
      ListTagsForResourceMessage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listener(
      protocol: Option[String] = None,
      port: Option[Int] = None
    ): Listener =
      Listener
        .builder
        .ifSome(protocol)(_.protocol(_))
        .ifSome(port)(_.port(_))
        .build

    def loadBalancer(
      name: Option[String] = None
    ): LoadBalancer =
      LoadBalancer
        .builder
        .ifSome(name)(_.name(_))
        .build

    def loadBalancerDescription(
      loadBalancerName: Option[String] = None,
      domain: Option[String] = None,
      listeners: Option[List[Listener]] = None
    ): LoadBalancerDescription =
      LoadBalancerDescription
        .builder
        .ifSome(loadBalancerName)(_.loadBalancerName(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(listeners)(_.listeners(_))
        .build

    def managedAction(
      actionId: Option[String] = None,
      actionDescription: Option[String] = None,
      actionType: Option[String] = None,
      status: Option[String] = None,
      windowStartTime: Option[Timestamp] = None
    ): ManagedAction =
      ManagedAction
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(actionDescription)(_.actionDescription(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(status)(_.status(_))
        .ifSome(windowStartTime)(_.windowStartTime(_))
        .build

    def managedActionHistoryItem(
      actionId: Option[String] = None,
      actionType: Option[String] = None,
      actionDescription: Option[String] = None,
      failureType: Option[String] = None,
      status: Option[String] = None,
      failureDescription: Option[String] = None,
      executedTime: Option[Timestamp] = None,
      finishedTime: Option[Timestamp] = None
    ): ManagedActionHistoryItem =
      ManagedActionHistoryItem
        .builder
        .ifSome(actionId)(_.actionId(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(actionDescription)(_.actionDescription(_))
        .ifSome(failureType)(_.failureType(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureDescription)(_.failureDescription(_))
        .ifSome(executedTime)(_.executedTime(_))
        .ifSome(finishedTime)(_.finishedTime(_))
        .build

    def managedActionInvalidStateException(

    ): ManagedActionInvalidStateException =
      ManagedActionInvalidStateException
        .builder

        .build

    def maxAgeRule(
      enabled: Option[Boolean] = None,
      maxAgeInDays: Option[Int] = None,
      deleteSourceFromS3: Option[Boolean] = None
    ): MaxAgeRule =
      MaxAgeRule
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(maxAgeInDays)(_.maxAgeInDays(_))
        .ifSome(deleteSourceFromS3)(_.deleteSourceFromS3(_))
        .build

    def maxCountRule(
      enabled: Option[Boolean] = None,
      maxCount: Option[Int] = None,
      deleteSourceFromS3: Option[Boolean] = None
    ): MaxCountRule =
      MaxCountRule
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(maxCount)(_.maxCount(_))
        .ifSome(deleteSourceFromS3)(_.deleteSourceFromS3(_))
        .build

    def operationInProgressException(

    ): OperationInProgressException =
      OperationInProgressException
        .builder

        .build

    def optionRestrictionRegex(
      pattern: Option[String] = None,
      label: Option[String] = None
    ): OptionRestrictionRegex =
      OptionRestrictionRegex
        .builder
        .ifSome(pattern)(_.pattern(_))
        .ifSome(label)(_.label(_))
        .build

    def optionSpecification(
      resourceName: Option[String] = None,
      namespace: Option[String] = None,
      optionName: Option[String] = None
    ): OptionSpecification =
      OptionSpecification
        .builder
        .ifSome(resourceName)(_.resourceName(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(optionName)(_.optionName(_))
        .build

    def platformBranchSummary(
      platformName: Option[String] = None,
      branchName: Option[String] = None,
      lifecycleState: Option[String] = None,
      branchOrder: Option[Int] = None,
      supportedTierList: Option[List[SupportedTier]] = None
    ): PlatformBranchSummary =
      PlatformBranchSummary
        .builder
        .ifSome(platformName)(_.platformName(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(lifecycleState)(_.lifecycleState(_))
        .ifSome(branchOrder)(_.branchOrder(_))
        .ifSome(supportedTierList)(_.supportedTierList(_))
        .build

    def platformDescription(
      platformArn: Option[String] = None,
      platformOwner: Option[String] = None,
      platformName: Option[String] = None,
      platformVersion: Option[String] = None,
      solutionStackName: Option[String] = None,
      platformStatus: Option[String] = None,
      dateCreated: Option[CreationDate] = None,
      dateUpdated: Option[UpdateDate] = None,
      platformCategory: Option[String] = None,
      description: Option[String] = None,
      maintainer: Option[String] = None,
      operatingSystemName: Option[String] = None,
      operatingSystemVersion: Option[String] = None,
      programmingLanguages: Option[List[PlatformProgrammingLanguage]] = None,
      frameworks: Option[List[PlatformFramework]] = None,
      customAmiList: Option[List[CustomAmi]] = None,
      supportedTierList: Option[List[SupportedTier]] = None,
      supportedAddonList: Option[List[SupportedAddon]] = None,
      platformLifecycleState: Option[String] = None,
      platformBranchName: Option[String] = None,
      platformBranchLifecycleState: Option[String] = None
    ): PlatformDescription =
      PlatformDescription
        .builder
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(platformOwner)(_.platformOwner(_))
        .ifSome(platformName)(_.platformName(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformStatus)(_.platformStatus(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(platformCategory)(_.platformCategory(_))
        .ifSome(description)(_.description(_))
        .ifSome(maintainer)(_.maintainer(_))
        .ifSome(operatingSystemName)(_.operatingSystemName(_))
        .ifSome(operatingSystemVersion)(_.operatingSystemVersion(_))
        .ifSome(programmingLanguages)(_.programmingLanguages(_))
        .ifSome(frameworks)(_.frameworks(_))
        .ifSome(customAmiList)(_.customAmiList(_))
        .ifSome(supportedTierList)(_.supportedTierList(_))
        .ifSome(supportedAddonList)(_.supportedAddonList(_))
        .ifSome(platformLifecycleState)(_.platformLifecycleState(_))
        .ifSome(platformBranchName)(_.platformBranchName(_))
        .ifSome(platformBranchLifecycleState)(_.platformBranchLifecycleState(_))
        .build

    def platformFilter(
      `type`: Option[String] = None,
      operator: Option[String] = None,
      values: Option[List[PlatformFilterValue]] = None
    ): PlatformFilter =
      PlatformFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(values)(_.values(_))
        .build

    def platformFramework(
      name: Option[String] = None,
      version: Option[String] = None
    ): PlatformFramework =
      PlatformFramework
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def platformProgrammingLanguage(
      name: Option[String] = None,
      version: Option[String] = None
    ): PlatformProgrammingLanguage =
      PlatformProgrammingLanguage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def platformSummary(
      platformArn: Option[String] = None,
      platformOwner: Option[String] = None,
      platformStatus: Option[String] = None,
      platformCategory: Option[String] = None,
      operatingSystemName: Option[String] = None,
      operatingSystemVersion: Option[String] = None,
      supportedTierList: Option[List[SupportedTier]] = None,
      supportedAddonList: Option[List[SupportedAddon]] = None,
      platformLifecycleState: Option[String] = None,
      platformVersion: Option[String] = None,
      platformBranchName: Option[String] = None,
      platformBranchLifecycleState: Option[String] = None
    ): PlatformSummary =
      PlatformSummary
        .builder
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(platformOwner)(_.platformOwner(_))
        .ifSome(platformStatus)(_.platformStatus(_))
        .ifSome(platformCategory)(_.platformCategory(_))
        .ifSome(operatingSystemName)(_.operatingSystemName(_))
        .ifSome(operatingSystemVersion)(_.operatingSystemVersion(_))
        .ifSome(supportedTierList)(_.supportedTierList(_))
        .ifSome(supportedAddonList)(_.supportedAddonList(_))
        .ifSome(platformLifecycleState)(_.platformLifecycleState(_))
        .ifSome(platformVersion)(_.platformVersion(_))
        .ifSome(platformBranchName)(_.platformBranchName(_))
        .ifSome(platformBranchLifecycleState)(_.platformBranchLifecycleState(_))
        .build

    def platformVersionStillReferencedException(

    ): PlatformVersionStillReferencedException =
      PlatformVersionStillReferencedException
        .builder

        .build

    def queue(
      name: Option[String] = None,
      uRL: Option[String] = None
    ): Queue =
      Queue
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(uRL)(_.uRL(_))
        .build

    def rebuildEnvironmentMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None
    ): RebuildEnvironmentMessage =
      RebuildEnvironmentMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def requestEnvironmentInfoMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None,
      infoType: Option[String] = None
    ): RequestEnvironmentInfoMessage =
      RequestEnvironmentInfoMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(infoType)(_.infoType(_))
        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourceQuota(
      maximum: Option[Int] = None
    ): ResourceQuota =
      ResourceQuota
        .builder
        .ifSome(maximum)(_.maximum(_))
        .build

    def resourceQuotas(
      applicationQuota: Option[ResourceQuota] = None,
      applicationVersionQuota: Option[ResourceQuota] = None,
      environmentQuota: Option[ResourceQuota] = None,
      configurationTemplateQuota: Option[ResourceQuota] = None,
      customPlatformQuota: Option[ResourceQuota] = None
    ): ResourceQuotas =
      ResourceQuotas
        .builder
        .ifSome(applicationQuota)(_.applicationQuota(_))
        .ifSome(applicationVersionQuota)(_.applicationVersionQuota(_))
        .ifSome(environmentQuota)(_.environmentQuota(_))
        .ifSome(configurationTemplateQuota)(_.configurationTemplateQuota(_))
        .ifSome(customPlatformQuota)(_.customPlatformQuota(_))
        .build

    def resourceTagsDescriptionMessage(
      resourceArn: Option[String] = None,
      resourceTags: Option[List[Tag]] = None
    ): ResourceTagsDescriptionMessage =
      ResourceTagsDescriptionMessage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .build

    def resourceTypeNotSupportedException(

    ): ResourceTypeNotSupportedException =
      ResourceTypeNotSupportedException
        .builder

        .build

    def restartAppServerMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None
    ): RestartAppServerMessage =
      RestartAppServerMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def retrieveEnvironmentInfoMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None,
      infoType: Option[String] = None
    ): RetrieveEnvironmentInfoMessage =
      RetrieveEnvironmentInfoMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(infoType)(_.infoType(_))
        .build

    def retrieveEnvironmentInfoResultMessage(
      environmentInfo: Option[List[EnvironmentInfoDescription]] = None
    ): RetrieveEnvironmentInfoResultMessage =
      RetrieveEnvironmentInfoResultMessage
        .builder
        .ifSome(environmentInfo)(_.environmentInfo(_))
        .build

    def s3Location(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def s3LocationNotInServiceRegionException(

    ): S3LocationNotInServiceRegionException =
      S3LocationNotInServiceRegionException
        .builder

        .build

    def s3SubscriptionRequiredException(

    ): S3SubscriptionRequiredException =
      S3SubscriptionRequiredException
        .builder

        .build

    def searchFilter(
      attribute: Option[String] = None,
      operator: Option[String] = None,
      values: Option[List[SearchFilterValue]] = None
    ): SearchFilter =
      SearchFilter
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(values)(_.values(_))
        .build

    def singleInstanceHealth(
      instanceId: Option[String] = None,
      healthStatus: Option[String] = None,
      color: Option[String] = None,
      causes: Option[List[Cause]] = None,
      launchedAt: Option[LaunchedAt] = None,
      applicationMetrics: Option[ApplicationMetrics] = None,
      system: Option[SystemStatus] = None,
      deployment: Option[Deployment] = None,
      availabilityZone: Option[String] = None,
      instanceType: Option[String] = None
    ): SingleInstanceHealth =
      SingleInstanceHealth
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(healthStatus)(_.healthStatus(_))
        .ifSome(color)(_.color(_))
        .ifSome(causes)(_.causes(_))
        .ifSome(launchedAt)(_.launchedAt(_))
        .ifSome(applicationMetrics)(_.applicationMetrics(_))
        .ifSome(system)(_.system(_))
        .ifSome(deployment)(_.deployment(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .ifSome(instanceType)(_.instanceType(_))
        .build

    def solutionStackDescription(
      solutionStackName: Option[String] = None,
      permittedFileTypes: Option[List[FileTypeExtension]] = None
    ): SolutionStackDescription =
      SolutionStackDescription
        .builder
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(permittedFileTypes)(_.permittedFileTypes(_))
        .build

    def sourceBuildInformation(
      sourceType: Option[String] = None,
      sourceRepository: Option[String] = None,
      sourceLocation: Option[String] = None
    ): SourceBuildInformation =
      SourceBuildInformation
        .builder
        .ifSome(sourceType)(_.sourceType(_))
        .ifSome(sourceRepository)(_.sourceRepository(_))
        .ifSome(sourceLocation)(_.sourceLocation(_))
        .build

    def sourceBundleDeletionException(

    ): SourceBundleDeletionException =
      SourceBundleDeletionException
        .builder

        .build

    def sourceConfiguration(
      applicationName: Option[String] = None,
      templateName: Option[String] = None
    ): SourceConfiguration =
      SourceConfiguration
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .build

    def statusCodes(
      status2xx: Option[Int] = None,
      status3xx: Option[Int] = None,
      status4xx: Option[Int] = None,
      status5xx: Option[Int] = None
    ): StatusCodes =
      StatusCodes
        .builder
        .ifSome(status2xx)(_.status2xx(_))
        .ifSome(status3xx)(_.status3xx(_))
        .ifSome(status4xx)(_.status4xx(_))
        .ifSome(status5xx)(_.status5xx(_))
        .build

    def swapEnvironmentCNAMEsMessage(
      sourceEnvironmentId: Option[String] = None,
      sourceEnvironmentName: Option[String] = None,
      destinationEnvironmentId: Option[String] = None,
      destinationEnvironmentName: Option[String] = None
    ): SwapEnvironmentCNAMEsMessage =
      SwapEnvironmentCNAMEsMessage
        .builder
        .ifSome(sourceEnvironmentId)(_.sourceEnvironmentId(_))
        .ifSome(sourceEnvironmentName)(_.sourceEnvironmentName(_))
        .ifSome(destinationEnvironmentId)(_.destinationEnvironmentId(_))
        .ifSome(destinationEnvironmentName)(_.destinationEnvironmentName(_))
        .build

    def systemStatus(
      cPUUtilization: Option[CPUUtilization] = None,
      loadAverage: Option[List[LoadAverageValue]] = None
    ): SystemStatus =
      SystemStatus
        .builder
        .ifSome(cPUUtilization)(_.cPUUtilization(_))
        .ifSome(loadAverage)(_.loadAverage(_))
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

    def terminateEnvironmentMessage(
      environmentId: Option[String] = None,
      environmentName: Option[String] = None,
      terminateResources: Option[Boolean] = None,
      forceTerminate: Option[Boolean] = None
    ): TerminateEnvironmentMessage =
      TerminateEnvironmentMessage
        .builder
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(terminateResources)(_.terminateResources(_))
        .ifSome(forceTerminate)(_.forceTerminate(_))
        .build

    def tooManyApplicationVersionsException(

    ): TooManyApplicationVersionsException =
      TooManyApplicationVersionsException
        .builder

        .build

    def tooManyApplicationsException(

    ): TooManyApplicationsException =
      TooManyApplicationsException
        .builder

        .build

    def tooManyBucketsException(

    ): TooManyBucketsException =
      TooManyBucketsException
        .builder

        .build

    def tooManyConfigurationTemplatesException(

    ): TooManyConfigurationTemplatesException =
      TooManyConfigurationTemplatesException
        .builder

        .build

    def tooManyEnvironmentsException(

    ): TooManyEnvironmentsException =
      TooManyEnvironmentsException
        .builder

        .build

    def tooManyPlatformsException(

    ): TooManyPlatformsException =
      TooManyPlatformsException
        .builder

        .build

    def tooManyTagsException(

    ): TooManyTagsException =
      TooManyTagsException
        .builder

        .build

    def trigger(
      name: Option[String] = None
    ): Trigger =
      Trigger
        .builder
        .ifSome(name)(_.name(_))
        .build

    def updateApplicationMessage(
      applicationName: Option[String] = None,
      description: Option[String] = None
    ): UpdateApplicationMessage =
      UpdateApplicationMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(description)(_.description(_))
        .build

    def updateApplicationResourceLifecycleMessage(
      applicationName: Option[String] = None,
      resourceLifecycleConfig: Option[ApplicationResourceLifecycleConfig] = None
    ): UpdateApplicationResourceLifecycleMessage =
      UpdateApplicationResourceLifecycleMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(resourceLifecycleConfig)(_.resourceLifecycleConfig(_))
        .build

    def updateApplicationVersionMessage(
      applicationName: Option[String] = None,
      versionLabel: Option[String] = None,
      description: Option[String] = None
    ): UpdateApplicationVersionMessage =
      UpdateApplicationVersionMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(description)(_.description(_))
        .build

    def updateConfigurationTemplateMessage(
      applicationName: Option[String] = None,
      templateName: Option[String] = None,
      description: Option[String] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None,
      optionsToRemove: Option[List[OptionSpecification]] = None
    ): UpdateConfigurationTemplateMessage =
      UpdateConfigurationTemplateMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(optionsToRemove)(_.optionsToRemove(_))
        .build

    def updateEnvironmentMessage(
      applicationName: Option[String] = None,
      environmentId: Option[String] = None,
      environmentName: Option[String] = None,
      groupName: Option[String] = None,
      description: Option[String] = None,
      tier: Option[EnvironmentTier] = None,
      versionLabel: Option[String] = None,
      templateName: Option[String] = None,
      solutionStackName: Option[String] = None,
      platformArn: Option[String] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None,
      optionsToRemove: Option[List[OptionSpecification]] = None
    ): UpdateEnvironmentMessage =
      UpdateEnvironmentMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(environmentId)(_.environmentId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tier)(_.tier(_))
        .ifSome(versionLabel)(_.versionLabel(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(solutionStackName)(_.solutionStackName(_))
        .ifSome(platformArn)(_.platformArn(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .ifSome(optionsToRemove)(_.optionsToRemove(_))
        .build

    def updateTagsForResourceMessage(
      resourceArn: Option[String] = None,
      tagsToAdd: Option[List[Tag]] = None,
      tagsToRemove: Option[List[TagKey]] = None
    ): UpdateTagsForResourceMessage =
      UpdateTagsForResourceMessage
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagsToAdd)(_.tagsToAdd(_))
        .ifSome(tagsToRemove)(_.tagsToRemove(_))
        .build

    def validateConfigurationSettingsMessage(
      applicationName: Option[String] = None,
      templateName: Option[String] = None,
      environmentName: Option[String] = None,
      optionSettings: Option[List[ConfigurationOptionSetting]] = None
    ): ValidateConfigurationSettingsMessage =
      ValidateConfigurationSettingsMessage
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(optionSettings)(_.optionSettings(_))
        .build

    def validationMessage(
      message: Option[String] = None,
      severity: Option[String] = None,
      namespace: Option[String] = None,
      optionName: Option[String] = None
    ): ValidationMessage =
      ValidationMessage
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(namespace)(_.namespace(_))
        .ifSome(optionName)(_.optionName(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
