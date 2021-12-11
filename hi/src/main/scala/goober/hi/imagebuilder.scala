package goober.hi

import goober.free.imagebuilder.ImagebuilderIO
import software.amazon.awssdk.services.imagebuilder.model._


object imagebuilder {
  import goober.free.{imagebuilder ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def ami(
      region: Option[String] = None,
      image: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      state: Option[ImageState] = None,
      accountId: Option[String] = None
    ): Ami =
      Ami
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(image)(_.image(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(state)(_.state(_))
        .ifSome(accountId)(_.accountId(_))
        .build

    def amiDistributionConfiguration(
      name: Option[String] = None,
      description: Option[String] = None,
      targetAccountIds: Option[List[AccountId]] = None,
      amiTags: Option[TagMap] = None,
      kmsKeyId: Option[String] = None,
      launchPermission: Option[LaunchPermissionConfiguration] = None
    ): AmiDistributionConfiguration =
      AmiDistributionConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(targetAccountIds)(_.targetAccountIds(_))
        .ifSome(amiTags)(_.amiTags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(launchPermission)(_.launchPermission(_))
        .build

    def callRateLimitExceededException(
      message: Option[String] = None
    ): CallRateLimitExceededException =
      CallRateLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelImageCreationRequest(
      imageBuildVersionArn: Option[String] = None,
      clientToken: Option[String] = None
    ): CancelImageCreationRequest =
      CancelImageCreationRequest
        .builder
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def cancelImageCreationResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      imageBuildVersionArn: Option[String] = None
    ): CancelImageCreationResponse =
      CancelImageCreationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .build

    def clientException(
      message: Option[String] = None
    ): ClientException =
      ClientException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def component(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      description: Option[String] = None,
      changeDescription: Option[String] = None,
      `type`: Option[String] = None,
      platform: Option[String] = None,
      supportedOsVersions: Option[List[OsVersion]] = None,
      owner: Option[String] = None,
      data: Option[String] = None,
      kmsKeyId: Option[String] = None,
      encrypted: Option[Boolean] = None,
      dateCreated: Option[String] = None,
      tags: Option[TagMap] = None
    ): Component =
      Component
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(description)(_.description(_))
        .ifSome(changeDescription)(_.changeDescription(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(supportedOsVersions)(_.supportedOsVersions(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(data)(_.data(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(tags)(_.tags(_))
        .build

    def componentConfiguration(
      componentArn: Option[String] = None
    ): ComponentConfiguration =
      ComponentConfiguration
        .builder
        .ifSome(componentArn)(_.componentArn(_))
        .build

    def componentSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      platform: Option[String] = None,
      supportedOsVersions: Option[List[OsVersion]] = None,
      `type`: Option[String] = None,
      owner: Option[String] = None,
      description: Option[String] = None,
      changeDescription: Option[String] = None,
      dateCreated: Option[String] = None,
      tags: Option[TagMap] = None
    ): ComponentSummary =
      ComponentSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(supportedOsVersions)(_.supportedOsVersions(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(description)(_.description(_))
        .ifSome(changeDescription)(_.changeDescription(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(tags)(_.tags(_))
        .build

    def componentVersion(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      description: Option[String] = None,
      platform: Option[String] = None,
      supportedOsVersions: Option[List[OsVersion]] = None,
      `type`: Option[String] = None,
      owner: Option[String] = None,
      dateCreated: Option[String] = None
    ): ComponentVersion =
      ComponentVersion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(description)(_.description(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(supportedOsVersions)(_.supportedOsVersions(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .build

    def container(
      region: Option[String] = None,
      imageUris: Option[List[NonEmptyString]] = None
    ): Container =
      Container
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(imageUris)(_.imageUris(_))
        .build

    def containerDistributionConfiguration(
      description: Option[String] = None,
      containerTags: Option[List[NonEmptyString]] = None,
      targetRepository: Option[TargetContainerRepository] = None
    ): ContainerDistributionConfiguration =
      ContainerDistributionConfiguration
        .builder
        .ifSome(description)(_.description(_))
        .ifSome(containerTags)(_.containerTags(_))
        .ifSome(targetRepository)(_.targetRepository(_))
        .build

    def containerRecipe(
      arn: Option[String] = None,
      containerType: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      platform: Option[String] = None,
      owner: Option[String] = None,
      version: Option[String] = None,
      components: Option[List[ComponentConfiguration]] = None,
      instanceConfiguration: Option[InstanceConfiguration] = None,
      dockerfileTemplateData: Option[String] = None,
      kmsKeyId: Option[String] = None,
      encrypted: Option[Boolean] = None,
      parentImage: Option[String] = None,
      dateCreated: Option[String] = None,
      tags: Option[TagMap] = None,
      workingDirectory: Option[String] = None,
      targetRepository: Option[TargetContainerRepository] = None
    ): ContainerRecipe =
      ContainerRecipe
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(containerType)(_.containerType(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(version)(_.version(_))
        .ifSome(components)(_.components(_))
        .ifSome(instanceConfiguration)(_.instanceConfiguration(_))
        .ifSome(dockerfileTemplateData)(_.dockerfileTemplateData(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(parentImage)(_.parentImage(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(workingDirectory)(_.workingDirectory(_))
        .ifSome(targetRepository)(_.targetRepository(_))
        .build

    def containerRecipeSummary(
      arn: Option[String] = None,
      containerType: Option[String] = None,
      name: Option[String] = None,
      platform: Option[String] = None,
      owner: Option[String] = None,
      parentImage: Option[String] = None,
      dateCreated: Option[String] = None,
      tags: Option[TagMap] = None
    ): ContainerRecipeSummary =
      ContainerRecipeSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(containerType)(_.containerType(_))
        .ifSome(name)(_.name(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(parentImage)(_.parentImage(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createComponentRequest(
      name: Option[String] = None,
      semanticVersion: Option[String] = None,
      description: Option[String] = None,
      changeDescription: Option[String] = None,
      platform: Option[String] = None,
      supportedOsVersions: Option[List[OsVersion]] = None,
      data: Option[String] = None,
      uri: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[TagMap] = None,
      clientToken: Option[String] = None
    ): CreateComponentRequest =
      CreateComponentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(changeDescription)(_.changeDescription(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(supportedOsVersions)(_.supportedOsVersions(_))
        .ifSome(data)(_.data(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createComponentResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      componentBuildVersionArn: Option[String] = None
    ): CreateComponentResponse =
      CreateComponentResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(componentBuildVersionArn)(_.componentBuildVersionArn(_))
        .build

    def createContainerRecipeRequest(
      containerType: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      semanticVersion: Option[String] = None,
      components: Option[List[ComponentConfiguration]] = None,
      instanceConfiguration: Option[InstanceConfiguration] = None,
      dockerfileTemplateData: Option[String] = None,
      dockerfileTemplateUri: Option[String] = None,
      platformOverride: Option[String] = None,
      imageOsVersionOverride: Option[String] = None,
      parentImage: Option[String] = None,
      tags: Option[TagMap] = None,
      workingDirectory: Option[String] = None,
      targetRepository: Option[TargetContainerRepository] = None,
      kmsKeyId: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateContainerRecipeRequest =
      CreateContainerRecipeRequest
        .builder
        .ifSome(containerType)(_.containerType(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(components)(_.components(_))
        .ifSome(instanceConfiguration)(_.instanceConfiguration(_))
        .ifSome(dockerfileTemplateData)(_.dockerfileTemplateData(_))
        .ifSome(dockerfileTemplateUri)(_.dockerfileTemplateUri(_))
        .ifSome(platformOverride)(_.platformOverride(_))
        .ifSome(imageOsVersionOverride)(_.imageOsVersionOverride(_))
        .ifSome(parentImage)(_.parentImage(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(workingDirectory)(_.workingDirectory(_))
        .ifSome(targetRepository)(_.targetRepository(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createContainerRecipeResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      containerRecipeArn: Option[String] = None
    ): CreateContainerRecipeResponse =
      CreateContainerRecipeResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .build

    def createDistributionConfigurationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      distributions: Option[List[Distribution]] = None,
      tags: Option[TagMap] = None,
      clientToken: Option[String] = None
    ): CreateDistributionConfigurationRequest =
      CreateDistributionConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(distributions)(_.distributions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createDistributionConfigurationResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      distributionConfigurationArn: Option[String] = None
    ): CreateDistributionConfigurationResponse =
      CreateDistributionConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .build

    def createImagePipelineRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      imageRecipeArn: Option[String] = None,
      containerRecipeArn: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None,
      distributionConfigurationArn: Option[String] = None,
      imageTestsConfiguration: Option[ImageTestsConfiguration] = None,
      enhancedImageMetadataEnabled: Option[Boolean] = None,
      schedule: Option[Schedule] = None,
      status: Option[String] = None,
      tags: Option[TagMap] = None,
      clientToken: Option[String] = None
    ): CreateImagePipelineRequest =
      CreateImagePipelineRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .ifSome(imageTestsConfiguration)(_.imageTestsConfiguration(_))
        .ifSome(enhancedImageMetadataEnabled)(_.enhancedImageMetadataEnabled(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createImagePipelineResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      imagePipelineArn: Option[String] = None
    ): CreateImagePipelineResponse =
      CreateImagePipelineResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .build

    def createImageRecipeRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      semanticVersion: Option[String] = None,
      components: Option[List[ComponentConfiguration]] = None,
      parentImage: Option[String] = None,
      blockDeviceMappings: Option[List[InstanceBlockDeviceMapping]] = None,
      tags: Option[TagMap] = None,
      workingDirectory: Option[String] = None,
      clientToken: Option[String] = None
    ): CreateImageRecipeRequest =
      CreateImageRecipeRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(components)(_.components(_))
        .ifSome(parentImage)(_.parentImage(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(workingDirectory)(_.workingDirectory(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createImageRecipeResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      imageRecipeArn: Option[String] = None
    ): CreateImageRecipeResponse =
      CreateImageRecipeResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .build

    def createImageRequest(
      imageRecipeArn: Option[String] = None,
      containerRecipeArn: Option[String] = None,
      distributionConfigurationArn: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None,
      imageTestsConfiguration: Option[ImageTestsConfiguration] = None,
      enhancedImageMetadataEnabled: Option[Boolean] = None,
      tags: Option[TagMap] = None,
      clientToken: Option[String] = None
    ): CreateImageRequest =
      CreateImageRequest
        .builder
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .ifSome(imageTestsConfiguration)(_.imageTestsConfiguration(_))
        .ifSome(enhancedImageMetadataEnabled)(_.enhancedImageMetadataEnabled(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createImageResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      imageBuildVersionArn: Option[String] = None
    ): CreateImageResponse =
      CreateImageResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .build

    def createInfrastructureConfigurationRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      instanceTypes: Option[List[InstanceType]] = None,
      instanceProfileName: Option[String] = None,
      securityGroupIds: Option[List[NonEmptyString]] = None,
      subnetId: Option[String] = None,
      logging: Option[Logging] = None,
      keyPair: Option[String] = None,
      terminateInstanceOnFailure: Option[Boolean] = None,
      snsTopicArn: Option[String] = None,
      resourceTags: Option[ResourceTagMap] = None,
      tags: Option[TagMap] = None,
      clientToken: Option[String] = None
    ): CreateInfrastructureConfigurationRequest =
      CreateInfrastructureConfigurationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(terminateInstanceOnFailure)(_.terminateInstanceOnFailure(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def createInfrastructureConfigurationResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None
    ): CreateInfrastructureConfigurationResponse =
      CreateInfrastructureConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .build

    def deleteComponentRequest(
      componentBuildVersionArn: Option[String] = None
    ): DeleteComponentRequest =
      DeleteComponentRequest
        .builder
        .ifSome(componentBuildVersionArn)(_.componentBuildVersionArn(_))
        .build

    def deleteComponentResponse(
      requestId: Option[String] = None,
      componentBuildVersionArn: Option[String] = None
    ): DeleteComponentResponse =
      DeleteComponentResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(componentBuildVersionArn)(_.componentBuildVersionArn(_))
        .build

    def deleteContainerRecipeRequest(
      containerRecipeArn: Option[String] = None
    ): DeleteContainerRecipeRequest =
      DeleteContainerRecipeRequest
        .builder
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .build

    def deleteContainerRecipeResponse(
      requestId: Option[String] = None,
      containerRecipeArn: Option[String] = None
    ): DeleteContainerRecipeResponse =
      DeleteContainerRecipeResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .build

    def deleteDistributionConfigurationRequest(
      distributionConfigurationArn: Option[String] = None
    ): DeleteDistributionConfigurationRequest =
      DeleteDistributionConfigurationRequest
        .builder
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .build

    def deleteDistributionConfigurationResponse(
      requestId: Option[String] = None,
      distributionConfigurationArn: Option[String] = None
    ): DeleteDistributionConfigurationResponse =
      DeleteDistributionConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .build

    def deleteImagePipelineRequest(
      imagePipelineArn: Option[String] = None
    ): DeleteImagePipelineRequest =
      DeleteImagePipelineRequest
        .builder
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .build

    def deleteImagePipelineResponse(
      requestId: Option[String] = None,
      imagePipelineArn: Option[String] = None
    ): DeleteImagePipelineResponse =
      DeleteImagePipelineResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .build

    def deleteImageRecipeRequest(
      imageRecipeArn: Option[String] = None
    ): DeleteImageRecipeRequest =
      DeleteImageRecipeRequest
        .builder
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .build

    def deleteImageRecipeResponse(
      requestId: Option[String] = None,
      imageRecipeArn: Option[String] = None
    ): DeleteImageRecipeResponse =
      DeleteImageRecipeResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .build

    def deleteImageRequest(
      imageBuildVersionArn: Option[String] = None
    ): DeleteImageRequest =
      DeleteImageRequest
        .builder
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .build

    def deleteImageResponse(
      requestId: Option[String] = None,
      imageBuildVersionArn: Option[String] = None
    ): DeleteImageResponse =
      DeleteImageResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .build

    def deleteInfrastructureConfigurationRequest(
      infrastructureConfigurationArn: Option[String] = None
    ): DeleteInfrastructureConfigurationRequest =
      DeleteInfrastructureConfigurationRequest
        .builder
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .build

    def deleteInfrastructureConfigurationResponse(
      requestId: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None
    ): DeleteInfrastructureConfigurationResponse =
      DeleteInfrastructureConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .build

    def distribution(
      region: Option[String] = None,
      amiDistributionConfiguration: Option[AmiDistributionConfiguration] = None,
      containerDistributionConfiguration: Option[ContainerDistributionConfiguration] = None,
      licenseConfigurationArns: Option[List[LicenseConfigurationArn]] = None,
      launchTemplateConfigurations: Option[List[LaunchTemplateConfiguration]] = None
    ): Distribution =
      Distribution
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(amiDistributionConfiguration)(_.amiDistributionConfiguration(_))
        .ifSome(containerDistributionConfiguration)(_.containerDistributionConfiguration(_))
        .ifSome(licenseConfigurationArns)(_.licenseConfigurationArns(_))
        .ifSome(launchTemplateConfigurations)(_.launchTemplateConfigurations(_))
        .build

    def distributionConfiguration(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      distributions: Option[List[Distribution]] = None,
      timeoutMinutes: Option[Int] = None,
      dateCreated: Option[String] = None,
      dateUpdated: Option[String] = None,
      tags: Option[TagMap] = None
    ): DistributionConfiguration =
      DistributionConfiguration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(distributions)(_.distributions(_))
        .ifSome(timeoutMinutes)(_.timeoutMinutes(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(tags)(_.tags(_))
        .build

    def distributionConfigurationSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dateCreated: Option[String] = None,
      dateUpdated: Option[String] = None,
      tags: Option[TagMap] = None,
      regions: Option[List[NonEmptyString]] = None
    ): DistributionConfigurationSummary =
      DistributionConfigurationSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(regions)(_.regions(_))
        .build

    def ebsInstanceBlockDeviceSpecification(
      encrypted: Option[Boolean] = None,
      deleteOnTermination: Option[Boolean] = None,
      iops: Option[Int] = None,
      kmsKeyId: Option[String] = None,
      snapshotId: Option[String] = None,
      volumeSize: Option[Int] = None,
      volumeType: Option[String] = None
    ): EbsInstanceBlockDeviceSpecification =
      EbsInstanceBlockDeviceSpecification
        .builder
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(deleteOnTermination)(_.deleteOnTermination(_))
        .ifSome(iops)(_.iops(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(snapshotId)(_.snapshotId(_))
        .ifSome(volumeSize)(_.volumeSize(_))
        .ifSome(volumeType)(_.volumeType(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def forbiddenException(
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getComponentPolicyRequest(
      componentArn: Option[String] = None
    ): GetComponentPolicyRequest =
      GetComponentPolicyRequest
        .builder
        .ifSome(componentArn)(_.componentArn(_))
        .build

    def getComponentPolicyResponse(
      requestId: Option[String] = None,
      policy: Option[String] = None
    ): GetComponentPolicyResponse =
      GetComponentPolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(policy)(_.policy(_))
        .build

    def getComponentRequest(
      componentBuildVersionArn: Option[String] = None
    ): GetComponentRequest =
      GetComponentRequest
        .builder
        .ifSome(componentBuildVersionArn)(_.componentBuildVersionArn(_))
        .build

    def getComponentResponse(
      requestId: Option[String] = None,
      component: Option[Component] = None
    ): GetComponentResponse =
      GetComponentResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(component)(_.component(_))
        .build

    def getContainerRecipePolicyRequest(
      containerRecipeArn: Option[String] = None
    ): GetContainerRecipePolicyRequest =
      GetContainerRecipePolicyRequest
        .builder
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .build

    def getContainerRecipePolicyResponse(
      requestId: Option[String] = None,
      policy: Option[String] = None
    ): GetContainerRecipePolicyResponse =
      GetContainerRecipePolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(policy)(_.policy(_))
        .build

    def getContainerRecipeRequest(
      containerRecipeArn: Option[String] = None
    ): GetContainerRecipeRequest =
      GetContainerRecipeRequest
        .builder
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .build

    def getContainerRecipeResponse(
      requestId: Option[String] = None,
      containerRecipe: Option[ContainerRecipe] = None
    ): GetContainerRecipeResponse =
      GetContainerRecipeResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(containerRecipe)(_.containerRecipe(_))
        .build

    def getDistributionConfigurationRequest(
      distributionConfigurationArn: Option[String] = None
    ): GetDistributionConfigurationRequest =
      GetDistributionConfigurationRequest
        .builder
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .build

    def getDistributionConfigurationResponse(
      requestId: Option[String] = None,
      distributionConfiguration: Option[DistributionConfiguration] = None
    ): GetDistributionConfigurationResponse =
      GetDistributionConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(distributionConfiguration)(_.distributionConfiguration(_))
        .build

    def getImagePipelineRequest(
      imagePipelineArn: Option[String] = None
    ): GetImagePipelineRequest =
      GetImagePipelineRequest
        .builder
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .build

    def getImagePipelineResponse(
      requestId: Option[String] = None,
      imagePipeline: Option[ImagePipeline] = None
    ): GetImagePipelineResponse =
      GetImagePipelineResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imagePipeline)(_.imagePipeline(_))
        .build

    def getImagePolicyRequest(
      imageArn: Option[String] = None
    ): GetImagePolicyRequest =
      GetImagePolicyRequest
        .builder
        .ifSome(imageArn)(_.imageArn(_))
        .build

    def getImagePolicyResponse(
      requestId: Option[String] = None,
      policy: Option[String] = None
    ): GetImagePolicyResponse =
      GetImagePolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(policy)(_.policy(_))
        .build

    def getImageRecipePolicyRequest(
      imageRecipeArn: Option[String] = None
    ): GetImageRecipePolicyRequest =
      GetImageRecipePolicyRequest
        .builder
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .build

    def getImageRecipePolicyResponse(
      requestId: Option[String] = None,
      policy: Option[String] = None
    ): GetImageRecipePolicyResponse =
      GetImageRecipePolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(policy)(_.policy(_))
        .build

    def getImageRecipeRequest(
      imageRecipeArn: Option[String] = None
    ): GetImageRecipeRequest =
      GetImageRecipeRequest
        .builder
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .build

    def getImageRecipeResponse(
      requestId: Option[String] = None,
      imageRecipe: Option[ImageRecipe] = None
    ): GetImageRecipeResponse =
      GetImageRecipeResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageRecipe)(_.imageRecipe(_))
        .build

    def getImageRequest(
      imageBuildVersionArn: Option[String] = None
    ): GetImageRequest =
      GetImageRequest
        .builder
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .build

    def getImageResponse(
      requestId: Option[String] = None,
      image: Option[Image] = None
    ): GetImageResponse =
      GetImageResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(image)(_.image(_))
        .build

    def getInfrastructureConfigurationRequest(
      infrastructureConfigurationArn: Option[String] = None
    ): GetInfrastructureConfigurationRequest =
      GetInfrastructureConfigurationRequest
        .builder
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .build

    def getInfrastructureConfigurationResponse(
      requestId: Option[String] = None,
      infrastructureConfiguration: Option[InfrastructureConfiguration] = None
    ): GetInfrastructureConfigurationResponse =
      GetInfrastructureConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(infrastructureConfiguration)(_.infrastructureConfiguration(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def image(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      platform: Option[String] = None,
      enhancedImageMetadataEnabled: Option[Boolean] = None,
      osVersion: Option[String] = None,
      state: Option[ImageState] = None,
      imageRecipe: Option[ImageRecipe] = None,
      containerRecipe: Option[ContainerRecipe] = None,
      sourcePipelineName: Option[String] = None,
      sourcePipelineArn: Option[String] = None,
      infrastructureConfiguration: Option[InfrastructureConfiguration] = None,
      distributionConfiguration: Option[DistributionConfiguration] = None,
      imageTestsConfiguration: Option[ImageTestsConfiguration] = None,
      dateCreated: Option[String] = None,
      outputResources: Option[OutputResources] = None,
      tags: Option[TagMap] = None
    ): Image =
      Image
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(enhancedImageMetadataEnabled)(_.enhancedImageMetadataEnabled(_))
        .ifSome(osVersion)(_.osVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(imageRecipe)(_.imageRecipe(_))
        .ifSome(containerRecipe)(_.containerRecipe(_))
        .ifSome(sourcePipelineName)(_.sourcePipelineName(_))
        .ifSome(sourcePipelineArn)(_.sourcePipelineArn(_))
        .ifSome(infrastructureConfiguration)(_.infrastructureConfiguration(_))
        .ifSome(distributionConfiguration)(_.distributionConfiguration(_))
        .ifSome(imageTestsConfiguration)(_.imageTestsConfiguration(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(outputResources)(_.outputResources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def imagePackage(
      packageName: Option[String] = None,
      packageVersion: Option[String] = None
    ): ImagePackage =
      ImagePackage
        .builder
        .ifSome(packageName)(_.packageName(_))
        .ifSome(packageVersion)(_.packageVersion(_))
        .build

    def imagePipeline(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      platform: Option[String] = None,
      enhancedImageMetadataEnabled: Option[Boolean] = None,
      imageRecipeArn: Option[String] = None,
      containerRecipeArn: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None,
      distributionConfigurationArn: Option[String] = None,
      imageTestsConfiguration: Option[ImageTestsConfiguration] = None,
      schedule: Option[Schedule] = None,
      status: Option[String] = None,
      dateCreated: Option[String] = None,
      dateUpdated: Option[String] = None,
      dateLastRun: Option[String] = None,
      dateNextRun: Option[String] = None,
      tags: Option[TagMap] = None
    ): ImagePipeline =
      ImagePipeline
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(enhancedImageMetadataEnabled)(_.enhancedImageMetadataEnabled(_))
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .ifSome(imageTestsConfiguration)(_.imageTestsConfiguration(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(status)(_.status(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(dateLastRun)(_.dateLastRun(_))
        .ifSome(dateNextRun)(_.dateNextRun(_))
        .ifSome(tags)(_.tags(_))
        .build

    def imageRecipe(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      platform: Option[String] = None,
      owner: Option[String] = None,
      version: Option[String] = None,
      components: Option[List[ComponentConfiguration]] = None,
      parentImage: Option[String] = None,
      blockDeviceMappings: Option[List[InstanceBlockDeviceMapping]] = None,
      dateCreated: Option[String] = None,
      tags: Option[TagMap] = None,
      workingDirectory: Option[String] = None
    ): ImageRecipe =
      ImageRecipe
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(version)(_.version(_))
        .ifSome(components)(_.components(_))
        .ifSome(parentImage)(_.parentImage(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(workingDirectory)(_.workingDirectory(_))
        .build

    def imageRecipeSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      platform: Option[String] = None,
      owner: Option[String] = None,
      parentImage: Option[String] = None,
      dateCreated: Option[String] = None,
      tags: Option[TagMap] = None
    ): ImageRecipeSummary =
      ImageRecipeSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(parentImage)(_.parentImage(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(tags)(_.tags(_))
        .build

    def imageState(
      status: Option[String] = None,
      reason: Option[String] = None
    ): ImageState =
      ImageState
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(reason)(_.reason(_))
        .build

    def imageSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      version: Option[String] = None,
      platform: Option[String] = None,
      osVersion: Option[String] = None,
      state: Option[ImageState] = None,
      owner: Option[String] = None,
      dateCreated: Option[String] = None,
      outputResources: Option[OutputResources] = None,
      tags: Option[TagMap] = None
    ): ImageSummary =
      ImageSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(version)(_.version(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(osVersion)(_.osVersion(_))
        .ifSome(state)(_.state(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(outputResources)(_.outputResources(_))
        .ifSome(tags)(_.tags(_))
        .build

    def imageTestsConfiguration(
      imageTestsEnabled: Option[Boolean] = None,
      timeoutMinutes: Option[Int] = None
    ): ImageTestsConfiguration =
      ImageTestsConfiguration
        .builder
        .ifSome(imageTestsEnabled)(_.imageTestsEnabled(_))
        .ifSome(timeoutMinutes)(_.timeoutMinutes(_))
        .build

    def imageVersion(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      version: Option[String] = None,
      platform: Option[String] = None,
      osVersion: Option[String] = None,
      owner: Option[String] = None,
      dateCreated: Option[String] = None
    ): ImageVersion =
      ImageVersion
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(version)(_.version(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(osVersion)(_.osVersion(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .build

    def importComponentRequest(
      name: Option[String] = None,
      semanticVersion: Option[String] = None,
      description: Option[String] = None,
      changeDescription: Option[String] = None,
      `type`: Option[String] = None,
      format: Option[String] = None,
      platform: Option[String] = None,
      data: Option[String] = None,
      uri: Option[String] = None,
      kmsKeyId: Option[String] = None,
      tags: Option[TagMap] = None,
      clientToken: Option[String] = None
    ): ImportComponentRequest =
      ImportComponentRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(semanticVersion)(_.semanticVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(changeDescription)(_.changeDescription(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(format)(_.format(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(data)(_.data(_))
        .ifSome(uri)(_.uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def importComponentResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      componentBuildVersionArn: Option[String] = None
    ): ImportComponentResponse =
      ImportComponentResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(componentBuildVersionArn)(_.componentBuildVersionArn(_))
        .build

    def infrastructureConfiguration(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      instanceTypes: Option[List[InstanceType]] = None,
      instanceProfileName: Option[String] = None,
      securityGroupIds: Option[List[NonEmptyString]] = None,
      subnetId: Option[String] = None,
      logging: Option[Logging] = None,
      keyPair: Option[String] = None,
      terminateInstanceOnFailure: Option[Boolean] = None,
      snsTopicArn: Option[String] = None,
      dateCreated: Option[String] = None,
      dateUpdated: Option[String] = None,
      resourceTags: Option[ResourceTagMap] = None,
      tags: Option[TagMap] = None
    ): InfrastructureConfiguration =
      InfrastructureConfiguration
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(terminateInstanceOnFailure)(_.terminateInstanceOnFailure(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(tags)(_.tags(_))
        .build

    def infrastructureConfigurationSummary(
      arn: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      dateCreated: Option[String] = None,
      dateUpdated: Option[String] = None,
      resourceTags: Option[ResourceTagMap] = None,
      tags: Option[TagMap] = None,
      instanceTypes: Option[List[InstanceType]] = None,
      instanceProfileName: Option[String] = None
    ): InfrastructureConfigurationSummary =
      InfrastructureConfigurationSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(dateCreated)(_.dateCreated(_))
        .ifSome(dateUpdated)(_.dateUpdated(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .build

    def instanceBlockDeviceMapping(
      deviceName: Option[String] = None,
      ebs: Option[EbsInstanceBlockDeviceSpecification] = None,
      virtualName: Option[String] = None,
      noDevice: Option[String] = None
    ): InstanceBlockDeviceMapping =
      InstanceBlockDeviceMapping
        .builder
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(ebs)(_.ebs(_))
        .ifSome(virtualName)(_.virtualName(_))
        .ifSome(noDevice)(_.noDevice(_))
        .build

    def instanceConfiguration(
      image: Option[String] = None,
      blockDeviceMappings: Option[List[InstanceBlockDeviceMapping]] = None
    ): InstanceConfiguration =
      InstanceConfiguration
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(blockDeviceMappings)(_.blockDeviceMappings(_))
        .build

    def invalidPaginationTokenException(
      message: Option[String] = None
    ): InvalidPaginationTokenException =
      InvalidPaginationTokenException
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

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterValueException(
      message: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidVersionNumberException(
      message: Option[String] = None
    ): InvalidVersionNumberException =
      InvalidVersionNumberException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def launchPermissionConfiguration(
      userIds: Option[List[AccountId]] = None,
      userGroups: Option[List[NonEmptyString]] = None
    ): LaunchPermissionConfiguration =
      LaunchPermissionConfiguration
        .builder
        .ifSome(userIds)(_.userIds(_))
        .ifSome(userGroups)(_.userGroups(_))
        .build

    def launchTemplateConfiguration(
      launchTemplateId: Option[String] = None,
      accountId: Option[String] = None,
      setDefaultVersion: Option[Boolean] = None
    ): LaunchTemplateConfiguration =
      LaunchTemplateConfiguration
        .builder
        .ifSome(launchTemplateId)(_.launchTemplateId(_))
        .ifSome(accountId)(_.accountId(_))
        .ifSome(setDefaultVersion)(_.setDefaultVersion(_))
        .build

    def listComponentBuildVersionsRequest(
      componentVersionArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListComponentBuildVersionsRequest =
      ListComponentBuildVersionsRequest
        .builder
        .ifSome(componentVersionArn)(_.componentVersionArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentBuildVersionsResponse(
      requestId: Option[String] = None,
      componentSummaryList: Option[List[ComponentSummary]] = None,
      nextToken: Option[String] = None
    ): ListComponentBuildVersionsResponse =
      ListComponentBuildVersionsResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(componentSummaryList)(_.componentSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentsRequest(
      owner: Option[String] = None,
      filters: Option[List[Filter]] = None,
      byName: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListComponentsRequest =
      ListComponentsRequest
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(byName)(_.byName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listComponentsResponse(
      requestId: Option[String] = None,
      componentVersionList: Option[List[ComponentVersion]] = None,
      nextToken: Option[String] = None
    ): ListComponentsResponse =
      ListComponentsResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(componentVersionList)(_.componentVersionList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContainerRecipesRequest(
      owner: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListContainerRecipesRequest =
      ListContainerRecipesRequest
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listContainerRecipesResponse(
      requestId: Option[String] = None,
      containerRecipeSummaryList: Option[List[ContainerRecipeSummary]] = None,
      nextToken: Option[String] = None
    ): ListContainerRecipesResponse =
      ListContainerRecipesResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(containerRecipeSummaryList)(_.containerRecipeSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDistributionConfigurationsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDistributionConfigurationsRequest =
      ListDistributionConfigurationsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDistributionConfigurationsResponse(
      requestId: Option[String] = None,
      distributionConfigurationSummaryList: Option[List[DistributionConfigurationSummary]] = None,
      nextToken: Option[String] = None
    ): ListDistributionConfigurationsResponse =
      ListDistributionConfigurationsResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(distributionConfigurationSummaryList)(_.distributionConfigurationSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImageBuildVersionsRequest(
      imageVersionArn: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListImageBuildVersionsRequest =
      ListImageBuildVersionsRequest
        .builder
        .ifSome(imageVersionArn)(_.imageVersionArn(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImageBuildVersionsResponse(
      requestId: Option[String] = None,
      imageSummaryList: Option[List[ImageSummary]] = None,
      nextToken: Option[String] = None
    ): ListImageBuildVersionsResponse =
      ListImageBuildVersionsResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageSummaryList)(_.imageSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagePackagesRequest(
      imageBuildVersionArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListImagePackagesRequest =
      ListImagePackagesRequest
        .builder
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagePackagesResponse(
      requestId: Option[String] = None,
      imagePackageList: Option[List[ImagePackage]] = None,
      nextToken: Option[String] = None
    ): ListImagePackagesResponse =
      ListImagePackagesResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imagePackageList)(_.imagePackageList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagePipelineImagesRequest(
      imagePipelineArn: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListImagePipelineImagesRequest =
      ListImagePipelineImagesRequest
        .builder
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagePipelineImagesResponse(
      requestId: Option[String] = None,
      imageSummaryList: Option[List[ImageSummary]] = None,
      nextToken: Option[String] = None
    ): ListImagePipelineImagesResponse =
      ListImagePipelineImagesResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageSummaryList)(_.imageSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagePipelinesRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListImagePipelinesRequest =
      ListImagePipelinesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagePipelinesResponse(
      requestId: Option[String] = None,
      imagePipelineList: Option[List[ImagePipeline]] = None,
      nextToken: Option[String] = None
    ): ListImagePipelinesResponse =
      ListImagePipelinesResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imagePipelineList)(_.imagePipelineList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImageRecipesRequest(
      owner: Option[String] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListImageRecipesRequest =
      ListImageRecipesRequest
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImageRecipesResponse(
      requestId: Option[String] = None,
      imageRecipeSummaryList: Option[List[ImageRecipeSummary]] = None,
      nextToken: Option[String] = None
    ): ListImageRecipesResponse =
      ListImageRecipesResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageRecipeSummaryList)(_.imageRecipeSummaryList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImagesRequest(
      owner: Option[String] = None,
      filters: Option[List[Filter]] = None,
      byName: Option[Boolean] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      includeDeprecated: Option[Boolean] = None
    ): ListImagesRequest =
      ListImagesRequest
        .builder
        .ifSome(owner)(_.owner(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(byName)(_.byName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(includeDeprecated)(_.includeDeprecated(_))
        .build

    def listImagesResponse(
      requestId: Option[String] = None,
      imageVersionList: Option[List[ImageVersion]] = None,
      nextToken: Option[String] = None
    ): ListImagesResponse =
      ListImagesResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageVersionList)(_.imageVersionList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInfrastructureConfigurationsRequest(
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListInfrastructureConfigurationsRequest =
      ListInfrastructureConfigurationsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listInfrastructureConfigurationsResponse(
      requestId: Option[String] = None,
      infrastructureConfigurationSummaryList: Option[List[InfrastructureConfigurationSummary]] = None,
      nextToken: Option[String] = None
    ): ListInfrastructureConfigurationsResponse =
      ListInfrastructureConfigurationsResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(infrastructureConfigurationSummaryList)(_.infrastructureConfigurationSummaryList(_))
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def logging(
      s3Logs: Option[S3Logs] = None
    ): Logging =
      Logging
        .builder
        .ifSome(s3Logs)(_.s3Logs(_))
        .build

    def outputResources(
      amis: Option[List[Ami]] = None,
      containers: Option[List[Container]] = None
    ): OutputResources =
      OutputResources
        .builder
        .ifSome(amis)(_.amis(_))
        .ifSome(containers)(_.containers(_))
        .build

    def putComponentPolicyRequest(
      componentArn: Option[String] = None,
      policy: Option[String] = None
    ): PutComponentPolicyRequest =
      PutComponentPolicyRequest
        .builder
        .ifSome(componentArn)(_.componentArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putComponentPolicyResponse(
      requestId: Option[String] = None,
      componentArn: Option[String] = None
    ): PutComponentPolicyResponse =
      PutComponentPolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(componentArn)(_.componentArn(_))
        .build

    def putContainerRecipePolicyRequest(
      containerRecipeArn: Option[String] = None,
      policy: Option[String] = None
    ): PutContainerRecipePolicyRequest =
      PutContainerRecipePolicyRequest
        .builder
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putContainerRecipePolicyResponse(
      requestId: Option[String] = None,
      containerRecipeArn: Option[String] = None
    ): PutContainerRecipePolicyResponse =
      PutContainerRecipePolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .build

    def putImagePolicyRequest(
      imageArn: Option[String] = None,
      policy: Option[String] = None
    ): PutImagePolicyRequest =
      PutImagePolicyRequest
        .builder
        .ifSome(imageArn)(_.imageArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putImagePolicyResponse(
      requestId: Option[String] = None,
      imageArn: Option[String] = None
    ): PutImagePolicyResponse =
      PutImagePolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageArn)(_.imageArn(_))
        .build

    def putImageRecipePolicyRequest(
      imageRecipeArn: Option[String] = None,
      policy: Option[String] = None
    ): PutImageRecipePolicyRequest =
      PutImageRecipePolicyRequest
        .builder
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putImageRecipePolicyResponse(
      requestId: Option[String] = None,
      imageRecipeArn: Option[String] = None
    ): PutImageRecipePolicyResponse =
      PutImageRecipePolicyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceDependencyException(
      message: Option[String] = None
    ): ResourceDependencyException =
      ResourceDependencyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
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

    def s3Logs(
      s3BucketName: Option[String] = None,
      s3KeyPrefix: Option[String] = None
    ): S3Logs =
      S3Logs
        .builder
        .ifSome(s3BucketName)(_.s3BucketName(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .build

    def schedule(
      scheduleExpression: Option[String] = None,
      timezone: Option[String] = None,
      pipelineExecutionStartCondition: Option[String] = None
    ): Schedule =
      Schedule
        .builder
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(timezone)(_.timezone(_))
        .ifSome(pipelineExecutionStartCondition)(_.pipelineExecutionStartCondition(_))
        .build

    def serviceException(
      message: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startImagePipelineExecutionRequest(
      imagePipelineArn: Option[String] = None,
      clientToken: Option[String] = None
    ): StartImagePipelineExecutionRequest =
      StartImagePipelineExecutionRequest
        .builder
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def startImagePipelineExecutionResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      imageBuildVersionArn: Option[String] = None
    ): StartImagePipelineExecutionResponse =
      StartImagePipelineExecutionResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imageBuildVersionArn)(_.imageBuildVersionArn(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagMap] = None
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

    def targetContainerRepository(
      service: Option[String] = None,
      repositoryName: Option[String] = None
    ): TargetContainerRepository =
      TargetContainerRepository
        .builder
        .ifSome(service)(_.service(_))
        .ifSome(repositoryName)(_.repositoryName(_))
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

    def updateDistributionConfigurationRequest(
      distributionConfigurationArn: Option[String] = None,
      description: Option[String] = None,
      distributions: Option[List[Distribution]] = None,
      clientToken: Option[String] = None
    ): UpdateDistributionConfigurationRequest =
      UpdateDistributionConfigurationRequest
        .builder
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(distributions)(_.distributions(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateDistributionConfigurationResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      distributionConfigurationArn: Option[String] = None
    ): UpdateDistributionConfigurationResponse =
      UpdateDistributionConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .build

    def updateImagePipelineRequest(
      imagePipelineArn: Option[String] = None,
      description: Option[String] = None,
      imageRecipeArn: Option[String] = None,
      containerRecipeArn: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None,
      distributionConfigurationArn: Option[String] = None,
      imageTestsConfiguration: Option[ImageTestsConfiguration] = None,
      enhancedImageMetadataEnabled: Option[Boolean] = None,
      schedule: Option[Schedule] = None,
      status: Option[String] = None,
      clientToken: Option[String] = None
    ): UpdateImagePipelineRequest =
      UpdateImagePipelineRequest
        .builder
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(imageRecipeArn)(_.imageRecipeArn(_))
        .ifSome(containerRecipeArn)(_.containerRecipeArn(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .ifSome(distributionConfigurationArn)(_.distributionConfigurationArn(_))
        .ifSome(imageTestsConfiguration)(_.imageTestsConfiguration(_))
        .ifSome(enhancedImageMetadataEnabled)(_.enhancedImageMetadataEnabled(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(status)(_.status(_))
        .ifSome(clientToken)(_.clientToken(_))
        .build

    def updateImagePipelineResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      imagePipelineArn: Option[String] = None
    ): UpdateImagePipelineResponse =
      UpdateImagePipelineResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(imagePipelineArn)(_.imagePipelineArn(_))
        .build

    def updateInfrastructureConfigurationRequest(
      infrastructureConfigurationArn: Option[String] = None,
      description: Option[String] = None,
      instanceTypes: Option[List[InstanceType]] = None,
      instanceProfileName: Option[String] = None,
      securityGroupIds: Option[List[NonEmptyString]] = None,
      subnetId: Option[String] = None,
      logging: Option[Logging] = None,
      keyPair: Option[String] = None,
      terminateInstanceOnFailure: Option[Boolean] = None,
      snsTopicArn: Option[String] = None,
      clientToken: Option[String] = None,
      resourceTags: Option[ResourceTagMap] = None
    ): UpdateInfrastructureConfigurationRequest =
      UpdateInfrastructureConfigurationRequest
        .builder
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(instanceTypes)(_.instanceTypes(_))
        .ifSome(instanceProfileName)(_.instanceProfileName(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(logging)(_.logging(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(terminateInstanceOnFailure)(_.terminateInstanceOnFailure(_))
        .ifSome(snsTopicArn)(_.snsTopicArn(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(resourceTags)(_.resourceTags(_))
        .build

    def updateInfrastructureConfigurationResponse(
      requestId: Option[String] = None,
      clientToken: Option[String] = None,
      infrastructureConfigurationArn: Option[String] = None
    ): UpdateInfrastructureConfigurationResponse =
      UpdateInfrastructureConfigurationResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(infrastructureConfigurationArn)(_.infrastructureConfigurationArn(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
