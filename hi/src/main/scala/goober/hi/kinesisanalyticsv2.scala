package goober.hi

import goober.free.kinesisanalyticsv2.KinesisAnalyticsV2IO
import software.amazon.awssdk.services.kinesisanalyticsv2.model._


object kinesisanalyticsv2 {
  import goober.free.{kinesisanalyticsv2 ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addApplicationCloudWatchLoggingOptionRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      cloudWatchLoggingOption: Option[CloudWatchLoggingOption] = None,
      conditionalToken: Option[String] = None
    ): AddApplicationCloudWatchLoggingOptionRequest =
      AddApplicationCloudWatchLoggingOptionRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(cloudWatchLoggingOption)(_.cloudWatchLoggingOption(_))
        .ifSome(conditionalToken)(_.conditionalToken(_))
        .build

    def addApplicationCloudWatchLoggingOptionResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      cloudWatchLoggingOptionDescriptions: Option[List[CloudWatchLoggingOptionDescription]] = None
    ): AddApplicationCloudWatchLoggingOptionResponse =
      AddApplicationCloudWatchLoggingOptionResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(cloudWatchLoggingOptionDescriptions)(_.cloudWatchLoggingOptionDescriptions(_))
        .build

    def addApplicationInputProcessingConfigurationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      inputId: Option[String] = None,
      inputProcessingConfiguration: Option[InputProcessingConfiguration] = None
    ): AddApplicationInputProcessingConfigurationRequest =
      AddApplicationInputProcessingConfigurationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(inputId)(_.inputId(_))
        .ifSome(inputProcessingConfiguration)(_.inputProcessingConfiguration(_))
        .build

    def addApplicationInputProcessingConfigurationResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      inputId: Option[String] = None,
      inputProcessingConfigurationDescription: Option[InputProcessingConfigurationDescription] = None
    ): AddApplicationInputProcessingConfigurationResponse =
      AddApplicationInputProcessingConfigurationResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(inputId)(_.inputId(_))
        .ifSome(inputProcessingConfigurationDescription)(_.inputProcessingConfigurationDescription(_))
        .build

    def addApplicationInputRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      input: Option[Input] = None
    ): AddApplicationInputRequest =
      AddApplicationInputRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(input)(_.input(_))
        .build

    def addApplicationInputResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      inputDescriptions: Option[List[InputDescription]] = None
    ): AddApplicationInputResponse =
      AddApplicationInputResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(inputDescriptions)(_.inputDescriptions(_))
        .build

    def addApplicationOutputRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      output: Option[Output] = None
    ): AddApplicationOutputRequest =
      AddApplicationOutputRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(output)(_.output(_))
        .build

    def addApplicationOutputResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      outputDescriptions: Option[List[OutputDescription]] = None
    ): AddApplicationOutputResponse =
      AddApplicationOutputResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(outputDescriptions)(_.outputDescriptions(_))
        .build

    def addApplicationReferenceDataSourceRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      referenceDataSource: Option[ReferenceDataSource] = None
    ): AddApplicationReferenceDataSourceRequest =
      AddApplicationReferenceDataSourceRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(referenceDataSource)(_.referenceDataSource(_))
        .build

    def addApplicationReferenceDataSourceResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      referenceDataSourceDescriptions: Option[List[ReferenceDataSourceDescription]] = None
    ): AddApplicationReferenceDataSourceResponse =
      AddApplicationReferenceDataSourceResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(referenceDataSourceDescriptions)(_.referenceDataSourceDescriptions(_))
        .build

    def addApplicationVpcConfigurationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      vpcConfiguration: Option[VpcConfiguration] = None,
      conditionalToken: Option[String] = None
    ): AddApplicationVpcConfigurationRequest =
      AddApplicationVpcConfigurationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .ifSome(conditionalToken)(_.conditionalToken(_))
        .build

    def addApplicationVpcConfigurationResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      vpcConfigurationDescription: Option[VpcConfigurationDescription] = None
    ): AddApplicationVpcConfigurationResponse =
      AddApplicationVpcConfigurationResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(vpcConfigurationDescription)(_.vpcConfigurationDescription(_))
        .build

    def applicationCodeConfiguration(
      codeContent: Option[CodeContent] = None,
      codeContentType: Option[String] = None
    ): ApplicationCodeConfiguration =
      ApplicationCodeConfiguration
        .builder
        .ifSome(codeContent)(_.codeContent(_))
        .ifSome(codeContentType)(_.codeContentType(_))
        .build

    def applicationCodeConfigurationDescription(
      codeContentType: Option[String] = None,
      codeContentDescription: Option[CodeContentDescription] = None
    ): ApplicationCodeConfigurationDescription =
      ApplicationCodeConfigurationDescription
        .builder
        .ifSome(codeContentType)(_.codeContentType(_))
        .ifSome(codeContentDescription)(_.codeContentDescription(_))
        .build

    def applicationCodeConfigurationUpdate(
      codeContentTypeUpdate: Option[String] = None,
      codeContentUpdate: Option[CodeContentUpdate] = None
    ): ApplicationCodeConfigurationUpdate =
      ApplicationCodeConfigurationUpdate
        .builder
        .ifSome(codeContentTypeUpdate)(_.codeContentTypeUpdate(_))
        .ifSome(codeContentUpdate)(_.codeContentUpdate(_))
        .build

    def applicationConfiguration(
      sqlApplicationConfiguration: Option[SqlApplicationConfiguration] = None,
      flinkApplicationConfiguration: Option[FlinkApplicationConfiguration] = None,
      environmentProperties: Option[EnvironmentProperties] = None,
      applicationCodeConfiguration: Option[ApplicationCodeConfiguration] = None,
      applicationSnapshotConfiguration: Option[ApplicationSnapshotConfiguration] = None,
      vpcConfigurations: Option[List[VpcConfiguration]] = None,
      zeppelinApplicationConfiguration: Option[ZeppelinApplicationConfiguration] = None
    ): ApplicationConfiguration =
      ApplicationConfiguration
        .builder
        .ifSome(sqlApplicationConfiguration)(_.sqlApplicationConfiguration(_))
        .ifSome(flinkApplicationConfiguration)(_.flinkApplicationConfiguration(_))
        .ifSome(environmentProperties)(_.environmentProperties(_))
        .ifSome(applicationCodeConfiguration)(_.applicationCodeConfiguration(_))
        .ifSome(applicationSnapshotConfiguration)(_.applicationSnapshotConfiguration(_))
        .ifSome(vpcConfigurations)(_.vpcConfigurations(_))
        .ifSome(zeppelinApplicationConfiguration)(_.zeppelinApplicationConfiguration(_))
        .build

    def applicationConfigurationDescription(
      sqlApplicationConfigurationDescription: Option[SqlApplicationConfigurationDescription] = None,
      applicationCodeConfigurationDescription: Option[ApplicationCodeConfigurationDescription] = None,
      runConfigurationDescription: Option[RunConfigurationDescription] = None,
      flinkApplicationConfigurationDescription: Option[FlinkApplicationConfigurationDescription] = None,
      environmentPropertyDescriptions: Option[EnvironmentPropertyDescriptions] = None,
      applicationSnapshotConfigurationDescription: Option[ApplicationSnapshotConfigurationDescription] = None,
      vpcConfigurationDescriptions: Option[List[VpcConfigurationDescription]] = None,
      zeppelinApplicationConfigurationDescription: Option[ZeppelinApplicationConfigurationDescription] = None
    ): ApplicationConfigurationDescription =
      ApplicationConfigurationDescription
        .builder
        .ifSome(sqlApplicationConfigurationDescription)(_.sqlApplicationConfigurationDescription(_))
        .ifSome(applicationCodeConfigurationDescription)(_.applicationCodeConfigurationDescription(_))
        .ifSome(runConfigurationDescription)(_.runConfigurationDescription(_))
        .ifSome(flinkApplicationConfigurationDescription)(_.flinkApplicationConfigurationDescription(_))
        .ifSome(environmentPropertyDescriptions)(_.environmentPropertyDescriptions(_))
        .ifSome(applicationSnapshotConfigurationDescription)(_.applicationSnapshotConfigurationDescription(_))
        .ifSome(vpcConfigurationDescriptions)(_.vpcConfigurationDescriptions(_))
        .ifSome(zeppelinApplicationConfigurationDescription)(_.zeppelinApplicationConfigurationDescription(_))
        .build

    def applicationConfigurationUpdate(
      sqlApplicationConfigurationUpdate: Option[SqlApplicationConfigurationUpdate] = None,
      applicationCodeConfigurationUpdate: Option[ApplicationCodeConfigurationUpdate] = None,
      flinkApplicationConfigurationUpdate: Option[FlinkApplicationConfigurationUpdate] = None,
      environmentPropertyUpdates: Option[EnvironmentPropertyUpdates] = None,
      applicationSnapshotConfigurationUpdate: Option[ApplicationSnapshotConfigurationUpdate] = None,
      vpcConfigurationUpdates: Option[List[VpcConfigurationUpdate]] = None,
      zeppelinApplicationConfigurationUpdate: Option[ZeppelinApplicationConfigurationUpdate] = None
    ): ApplicationConfigurationUpdate =
      ApplicationConfigurationUpdate
        .builder
        .ifSome(sqlApplicationConfigurationUpdate)(_.sqlApplicationConfigurationUpdate(_))
        .ifSome(applicationCodeConfigurationUpdate)(_.applicationCodeConfigurationUpdate(_))
        .ifSome(flinkApplicationConfigurationUpdate)(_.flinkApplicationConfigurationUpdate(_))
        .ifSome(environmentPropertyUpdates)(_.environmentPropertyUpdates(_))
        .ifSome(applicationSnapshotConfigurationUpdate)(_.applicationSnapshotConfigurationUpdate(_))
        .ifSome(vpcConfigurationUpdates)(_.vpcConfigurationUpdates(_))
        .ifSome(zeppelinApplicationConfigurationUpdate)(_.zeppelinApplicationConfigurationUpdate(_))
        .build

    def applicationDetail(
      applicationARN: Option[String] = None,
      applicationDescription: Option[String] = None,
      applicationName: Option[String] = None,
      runtimeEnvironment: Option[String] = None,
      serviceExecutionRole: Option[String] = None,
      applicationStatus: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      createTimestamp: Option[Timestamp] = None,
      lastUpdateTimestamp: Option[Timestamp] = None,
      applicationConfigurationDescription: Option[ApplicationConfigurationDescription] = None,
      cloudWatchLoggingOptionDescriptions: Option[List[CloudWatchLoggingOptionDescription]] = None,
      applicationMaintenanceConfigurationDescription: Option[ApplicationMaintenanceConfigurationDescription] = None,
      applicationVersionUpdatedFrom: Option[ApplicationVersionId] = None,
      applicationVersionRolledBackFrom: Option[ApplicationVersionId] = None,
      conditionalToken: Option[String] = None,
      applicationVersionRolledBackTo: Option[ApplicationVersionId] = None,
      applicationMode: Option[String] = None
    ): ApplicationDetail =
      ApplicationDetail
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(runtimeEnvironment)(_.runtimeEnvironment(_))
        .ifSome(serviceExecutionRole)(_.serviceExecutionRole(_))
        .ifSome(applicationStatus)(_.applicationStatus(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(lastUpdateTimestamp)(_.lastUpdateTimestamp(_))
        .ifSome(applicationConfigurationDescription)(_.applicationConfigurationDescription(_))
        .ifSome(cloudWatchLoggingOptionDescriptions)(_.cloudWatchLoggingOptionDescriptions(_))
        .ifSome(applicationMaintenanceConfigurationDescription)(_.applicationMaintenanceConfigurationDescription(_))
        .ifSome(applicationVersionUpdatedFrom)(_.applicationVersionUpdatedFrom(_))
        .ifSome(applicationVersionRolledBackFrom)(_.applicationVersionRolledBackFrom(_))
        .ifSome(conditionalToken)(_.conditionalToken(_))
        .ifSome(applicationVersionRolledBackTo)(_.applicationVersionRolledBackTo(_))
        .ifSome(applicationMode)(_.applicationMode(_))
        .build

    def applicationMaintenanceConfigurationDescription(
      applicationMaintenanceWindowStartTime: Option[String] = None,
      applicationMaintenanceWindowEndTime: Option[String] = None
    ): ApplicationMaintenanceConfigurationDescription =
      ApplicationMaintenanceConfigurationDescription
        .builder
        .ifSome(applicationMaintenanceWindowStartTime)(_.applicationMaintenanceWindowStartTime(_))
        .ifSome(applicationMaintenanceWindowEndTime)(_.applicationMaintenanceWindowEndTime(_))
        .build

    def applicationMaintenanceConfigurationUpdate(
      applicationMaintenanceWindowStartTimeUpdate: Option[String] = None
    ): ApplicationMaintenanceConfigurationUpdate =
      ApplicationMaintenanceConfigurationUpdate
        .builder
        .ifSome(applicationMaintenanceWindowStartTimeUpdate)(_.applicationMaintenanceWindowStartTimeUpdate(_))
        .build

    def applicationRestoreConfiguration(
      applicationRestoreType: Option[String] = None,
      snapshotName: Option[String] = None
    ): ApplicationRestoreConfiguration =
      ApplicationRestoreConfiguration
        .builder
        .ifSome(applicationRestoreType)(_.applicationRestoreType(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .build

    def applicationSnapshotConfiguration(
      snapshotsEnabled: Option[Boolean] = None
    ): ApplicationSnapshotConfiguration =
      ApplicationSnapshotConfiguration
        .builder
        .ifSome(snapshotsEnabled)(_.snapshotsEnabled(_))
        .build

    def applicationSnapshotConfigurationDescription(
      snapshotsEnabled: Option[Boolean] = None
    ): ApplicationSnapshotConfigurationDescription =
      ApplicationSnapshotConfigurationDescription
        .builder
        .ifSome(snapshotsEnabled)(_.snapshotsEnabled(_))
        .build

    def applicationSnapshotConfigurationUpdate(
      snapshotsEnabledUpdate: Option[Boolean] = None
    ): ApplicationSnapshotConfigurationUpdate =
      ApplicationSnapshotConfigurationUpdate
        .builder
        .ifSome(snapshotsEnabledUpdate)(_.snapshotsEnabledUpdate(_))
        .build

    def applicationSummary(
      applicationName: Option[String] = None,
      applicationARN: Option[String] = None,
      applicationStatus: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      runtimeEnvironment: Option[String] = None,
      applicationMode: Option[String] = None
    ): ApplicationSummary =
      ApplicationSummary
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationStatus)(_.applicationStatus(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(runtimeEnvironment)(_.runtimeEnvironment(_))
        .ifSome(applicationMode)(_.applicationMode(_))
        .build

    def applicationVersionSummary(
      applicationVersionId: Option[ApplicationVersionId] = None,
      applicationStatus: Option[String] = None
    ): ApplicationVersionSummary =
      ApplicationVersionSummary
        .builder
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(applicationStatus)(_.applicationStatus(_))
        .build

    def cSVMappingParameters(
      recordRowDelimiter: Option[String] = None,
      recordColumnDelimiter: Option[String] = None
    ): CSVMappingParameters =
      CSVMappingParameters
        .builder
        .ifSome(recordRowDelimiter)(_.recordRowDelimiter(_))
        .ifSome(recordColumnDelimiter)(_.recordColumnDelimiter(_))
        .build

    def catalogConfiguration(
      glueDataCatalogConfiguration: Option[GlueDataCatalogConfiguration] = None
    ): CatalogConfiguration =
      CatalogConfiguration
        .builder
        .ifSome(glueDataCatalogConfiguration)(_.glueDataCatalogConfiguration(_))
        .build

    def catalogConfigurationDescription(
      glueDataCatalogConfigurationDescription: Option[GlueDataCatalogConfigurationDescription] = None
    ): CatalogConfigurationDescription =
      CatalogConfigurationDescription
        .builder
        .ifSome(glueDataCatalogConfigurationDescription)(_.glueDataCatalogConfigurationDescription(_))
        .build

    def catalogConfigurationUpdate(
      glueDataCatalogConfigurationUpdate: Option[GlueDataCatalogConfigurationUpdate] = None
    ): CatalogConfigurationUpdate =
      CatalogConfigurationUpdate
        .builder
        .ifSome(glueDataCatalogConfigurationUpdate)(_.glueDataCatalogConfigurationUpdate(_))
        .build

    def checkpointConfiguration(
      configurationType: Option[String] = None,
      checkpointingEnabled: Option[Boolean] = None,
      checkpointInterval: Option[CheckpointInterval] = None,
      minPauseBetweenCheckpoints: Option[MinPauseBetweenCheckpoints] = None
    ): CheckpointConfiguration =
      CheckpointConfiguration
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(checkpointingEnabled)(_.checkpointingEnabled(_))
        .ifSome(checkpointInterval)(_.checkpointInterval(_))
        .ifSome(minPauseBetweenCheckpoints)(_.minPauseBetweenCheckpoints(_))
        .build

    def checkpointConfigurationDescription(
      configurationType: Option[String] = None,
      checkpointingEnabled: Option[Boolean] = None,
      checkpointInterval: Option[CheckpointInterval] = None,
      minPauseBetweenCheckpoints: Option[MinPauseBetweenCheckpoints] = None
    ): CheckpointConfigurationDescription =
      CheckpointConfigurationDescription
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(checkpointingEnabled)(_.checkpointingEnabled(_))
        .ifSome(checkpointInterval)(_.checkpointInterval(_))
        .ifSome(minPauseBetweenCheckpoints)(_.minPauseBetweenCheckpoints(_))
        .build

    def checkpointConfigurationUpdate(
      configurationTypeUpdate: Option[String] = None,
      checkpointingEnabledUpdate: Option[Boolean] = None,
      checkpointIntervalUpdate: Option[CheckpointInterval] = None,
      minPauseBetweenCheckpointsUpdate: Option[MinPauseBetweenCheckpoints] = None
    ): CheckpointConfigurationUpdate =
      CheckpointConfigurationUpdate
        .builder
        .ifSome(configurationTypeUpdate)(_.configurationTypeUpdate(_))
        .ifSome(checkpointingEnabledUpdate)(_.checkpointingEnabledUpdate(_))
        .ifSome(checkpointIntervalUpdate)(_.checkpointIntervalUpdate(_))
        .ifSome(minPauseBetweenCheckpointsUpdate)(_.minPauseBetweenCheckpointsUpdate(_))
        .build

    def cloudWatchLoggingOption(
      logStreamARN: Option[String] = None
    ): CloudWatchLoggingOption =
      CloudWatchLoggingOption
        .builder
        .ifSome(logStreamARN)(_.logStreamARN(_))
        .build

    def cloudWatchLoggingOptionDescription(
      cloudWatchLoggingOptionId: Option[String] = None,
      logStreamARN: Option[String] = None,
      roleARN: Option[String] = None
    ): CloudWatchLoggingOptionDescription =
      CloudWatchLoggingOptionDescription
        .builder
        .ifSome(cloudWatchLoggingOptionId)(_.cloudWatchLoggingOptionId(_))
        .ifSome(logStreamARN)(_.logStreamARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def cloudWatchLoggingOptionUpdate(
      cloudWatchLoggingOptionId: Option[String] = None,
      logStreamARNUpdate: Option[String] = None
    ): CloudWatchLoggingOptionUpdate =
      CloudWatchLoggingOptionUpdate
        .builder
        .ifSome(cloudWatchLoggingOptionId)(_.cloudWatchLoggingOptionId(_))
        .ifSome(logStreamARNUpdate)(_.logStreamARNUpdate(_))
        .build

    def codeContent(
      textContent: Option[String] = None,
      zipFileContent: Option[ZipFileContent] = None,
      s3ContentLocation: Option[S3ContentLocation] = None
    ): CodeContent =
      CodeContent
        .builder
        .ifSome(textContent)(_.textContent(_))
        .ifSome(zipFileContent)(_.zipFileContent(_))
        .ifSome(s3ContentLocation)(_.s3ContentLocation(_))
        .build

    def codeContentDescription(
      textContent: Option[String] = None,
      codeMD5: Option[String] = None,
      codeSize: Option[CodeSize] = None,
      s3ApplicationCodeLocationDescription: Option[S3ApplicationCodeLocationDescription] = None
    ): CodeContentDescription =
      CodeContentDescription
        .builder
        .ifSome(textContent)(_.textContent(_))
        .ifSome(codeMD5)(_.codeMD5(_))
        .ifSome(codeSize)(_.codeSize(_))
        .ifSome(s3ApplicationCodeLocationDescription)(_.s3ApplicationCodeLocationDescription(_))
        .build

    def codeContentUpdate(
      textContentUpdate: Option[String] = None,
      zipFileContentUpdate: Option[ZipFileContent] = None,
      s3ContentLocationUpdate: Option[S3ContentLocationUpdate] = None
    ): CodeContentUpdate =
      CodeContentUpdate
        .builder
        .ifSome(textContentUpdate)(_.textContentUpdate(_))
        .ifSome(zipFileContentUpdate)(_.zipFileContentUpdate(_))
        .ifSome(s3ContentLocationUpdate)(_.s3ContentLocationUpdate(_))
        .build

    def codeValidationException(
      message: Option[String] = None
    ): CodeValidationException =
      CodeValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createApplicationPresignedUrlRequest(
      applicationName: Option[String] = None,
      urlType: Option[String] = None,
      sessionExpirationDurationInSeconds: Option[SessionExpirationDurationInSeconds] = None
    ): CreateApplicationPresignedUrlRequest =
      CreateApplicationPresignedUrlRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(urlType)(_.urlType(_))
        .ifSome(sessionExpirationDurationInSeconds)(_.sessionExpirationDurationInSeconds(_))
        .build

    def createApplicationPresignedUrlResponse(
      authorizedUrl: Option[String] = None
    ): CreateApplicationPresignedUrlResponse =
      CreateApplicationPresignedUrlResponse
        .builder
        .ifSome(authorizedUrl)(_.authorizedUrl(_))
        .build

    def createApplicationRequest(
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      runtimeEnvironment: Option[String] = None,
      serviceExecutionRole: Option[String] = None,
      applicationConfiguration: Option[ApplicationConfiguration] = None,
      cloudWatchLoggingOptions: Option[List[CloudWatchLoggingOption]] = None,
      tags: Option[List[Tag]] = None,
      applicationMode: Option[String] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(runtimeEnvironment)(_.runtimeEnvironment(_))
        .ifSome(serviceExecutionRole)(_.serviceExecutionRole(_))
        .ifSome(applicationConfiguration)(_.applicationConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(applicationMode)(_.applicationMode(_))
        .build

    def createApplicationResponse(
      applicationDetail: Option[ApplicationDetail] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(applicationDetail)(_.applicationDetail(_))
        .build

    def createApplicationSnapshotRequest(
      applicationName: Option[String] = None,
      snapshotName: Option[String] = None
    ): CreateApplicationSnapshotRequest =
      CreateApplicationSnapshotRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .build

    def createApplicationSnapshotResponse(

    ): CreateApplicationSnapshotResponse =
      CreateApplicationSnapshotResponse
        .builder

        .build

    def customArtifactConfiguration(
      artifactType: Option[String] = None,
      s3ContentLocation: Option[S3ContentLocation] = None,
      mavenReference: Option[MavenReference] = None
    ): CustomArtifactConfiguration =
      CustomArtifactConfiguration
        .builder
        .ifSome(artifactType)(_.artifactType(_))
        .ifSome(s3ContentLocation)(_.s3ContentLocation(_))
        .ifSome(mavenReference)(_.mavenReference(_))
        .build

    def customArtifactConfigurationDescription(
      artifactType: Option[String] = None,
      s3ContentLocationDescription: Option[S3ContentLocation] = None,
      mavenReferenceDescription: Option[MavenReference] = None
    ): CustomArtifactConfigurationDescription =
      CustomArtifactConfigurationDescription
        .builder
        .ifSome(artifactType)(_.artifactType(_))
        .ifSome(s3ContentLocationDescription)(_.s3ContentLocationDescription(_))
        .ifSome(mavenReferenceDescription)(_.mavenReferenceDescription(_))
        .build

    def deleteApplicationCloudWatchLoggingOptionRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      cloudWatchLoggingOptionId: Option[String] = None,
      conditionalToken: Option[String] = None
    ): DeleteApplicationCloudWatchLoggingOptionRequest =
      DeleteApplicationCloudWatchLoggingOptionRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(cloudWatchLoggingOptionId)(_.cloudWatchLoggingOptionId(_))
        .ifSome(conditionalToken)(_.conditionalToken(_))
        .build

    def deleteApplicationCloudWatchLoggingOptionResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      cloudWatchLoggingOptionDescriptions: Option[List[CloudWatchLoggingOptionDescription]] = None
    ): DeleteApplicationCloudWatchLoggingOptionResponse =
      DeleteApplicationCloudWatchLoggingOptionResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(cloudWatchLoggingOptionDescriptions)(_.cloudWatchLoggingOptionDescriptions(_))
        .build

    def deleteApplicationInputProcessingConfigurationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      inputId: Option[String] = None
    ): DeleteApplicationInputProcessingConfigurationRequest =
      DeleteApplicationInputProcessingConfigurationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(inputId)(_.inputId(_))
        .build

    def deleteApplicationInputProcessingConfigurationResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None
    ): DeleteApplicationInputProcessingConfigurationResponse =
      DeleteApplicationInputProcessingConfigurationResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .build

    def deleteApplicationOutputRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      outputId: Option[String] = None
    ): DeleteApplicationOutputRequest =
      DeleteApplicationOutputRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(outputId)(_.outputId(_))
        .build

    def deleteApplicationOutputResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None
    ): DeleteApplicationOutputResponse =
      DeleteApplicationOutputResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .build

    def deleteApplicationReferenceDataSourceRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      referenceId: Option[String] = None
    ): DeleteApplicationReferenceDataSourceRequest =
      DeleteApplicationReferenceDataSourceRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(referenceId)(_.referenceId(_))
        .build

    def deleteApplicationReferenceDataSourceResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None
    ): DeleteApplicationReferenceDataSourceResponse =
      DeleteApplicationReferenceDataSourceResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .build

    def deleteApplicationRequest(
      applicationName: Option[String] = None,
      createTimestamp: Option[Timestamp] = None
    ): DeleteApplicationRequest =
      DeleteApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .build

    def deleteApplicationResponse(

    ): DeleteApplicationResponse =
      DeleteApplicationResponse
        .builder

        .build

    def deleteApplicationSnapshotRequest(
      applicationName: Option[String] = None,
      snapshotName: Option[String] = None,
      snapshotCreationTimestamp: Option[Timestamp] = None
    ): DeleteApplicationSnapshotRequest =
      DeleteApplicationSnapshotRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(snapshotCreationTimestamp)(_.snapshotCreationTimestamp(_))
        .build

    def deleteApplicationSnapshotResponse(

    ): DeleteApplicationSnapshotResponse =
      DeleteApplicationSnapshotResponse
        .builder

        .build

    def deleteApplicationVpcConfigurationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      vpcConfigurationId: Option[String] = None,
      conditionalToken: Option[String] = None
    ): DeleteApplicationVpcConfigurationRequest =
      DeleteApplicationVpcConfigurationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(vpcConfigurationId)(_.vpcConfigurationId(_))
        .ifSome(conditionalToken)(_.conditionalToken(_))
        .build

    def deleteApplicationVpcConfigurationResponse(
      applicationARN: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None
    ): DeleteApplicationVpcConfigurationResponse =
      DeleteApplicationVpcConfigurationResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .build

    def deployAsApplicationConfiguration(
      s3ContentLocation: Option[S3ContentBaseLocation] = None
    ): DeployAsApplicationConfiguration =
      DeployAsApplicationConfiguration
        .builder
        .ifSome(s3ContentLocation)(_.s3ContentLocation(_))
        .build

    def deployAsApplicationConfigurationDescription(
      s3ContentLocationDescription: Option[S3ContentBaseLocationDescription] = None
    ): DeployAsApplicationConfigurationDescription =
      DeployAsApplicationConfigurationDescription
        .builder
        .ifSome(s3ContentLocationDescription)(_.s3ContentLocationDescription(_))
        .build

    def deployAsApplicationConfigurationUpdate(
      s3ContentLocationUpdate: Option[S3ContentBaseLocationUpdate] = None
    ): DeployAsApplicationConfigurationUpdate =
      DeployAsApplicationConfigurationUpdate
        .builder
        .ifSome(s3ContentLocationUpdate)(_.s3ContentLocationUpdate(_))
        .build

    def describeApplicationRequest(
      applicationName: Option[String] = None,
      includeAdditionalDetails: Option[Boolean] = None
    ): DescribeApplicationRequest =
      DescribeApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(includeAdditionalDetails)(_.includeAdditionalDetails(_))
        .build

    def describeApplicationResponse(
      applicationDetail: Option[ApplicationDetail] = None
    ): DescribeApplicationResponse =
      DescribeApplicationResponse
        .builder
        .ifSome(applicationDetail)(_.applicationDetail(_))
        .build

    def describeApplicationSnapshotRequest(
      applicationName: Option[String] = None,
      snapshotName: Option[String] = None
    ): DescribeApplicationSnapshotRequest =
      DescribeApplicationSnapshotRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(snapshotName)(_.snapshotName(_))
        .build

    def describeApplicationSnapshotResponse(
      snapshotDetails: Option[SnapshotDetails] = None
    ): DescribeApplicationSnapshotResponse =
      DescribeApplicationSnapshotResponse
        .builder
        .ifSome(snapshotDetails)(_.snapshotDetails(_))
        .build

    def describeApplicationVersionRequest(
      applicationName: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None
    ): DescribeApplicationVersionRequest =
      DescribeApplicationVersionRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .build

    def describeApplicationVersionResponse(
      applicationVersionDetail: Option[ApplicationDetail] = None
    ): DescribeApplicationVersionResponse =
      DescribeApplicationVersionResponse
        .builder
        .ifSome(applicationVersionDetail)(_.applicationVersionDetail(_))
        .build

    def destinationSchema(
      recordFormatType: Option[String] = None
    ): DestinationSchema =
      DestinationSchema
        .builder
        .ifSome(recordFormatType)(_.recordFormatType(_))
        .build

    def discoverInputSchemaRequest(
      resourceARN: Option[String] = None,
      serviceExecutionRole: Option[String] = None,
      inputStartingPositionConfiguration: Option[InputStartingPositionConfiguration] = None,
      s3Configuration: Option[S3Configuration] = None,
      inputProcessingConfiguration: Option[InputProcessingConfiguration] = None
    ): DiscoverInputSchemaRequest =
      DiscoverInputSchemaRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(serviceExecutionRole)(_.serviceExecutionRole(_))
        .ifSome(inputStartingPositionConfiguration)(_.inputStartingPositionConfiguration(_))
        .ifSome(s3Configuration)(_.s3Configuration(_))
        .ifSome(inputProcessingConfiguration)(_.inputProcessingConfiguration(_))
        .build

    def discoverInputSchemaResponse(
      inputSchema: Option[SourceSchema] = None,
      parsedInputRecords: Option[List[ParsedInputRecord]] = None,
      processedInputRecords: Option[List[ProcessedInputRecord]] = None,
      rawInputRecords: Option[List[RawInputRecord]] = None
    ): DiscoverInputSchemaResponse =
      DiscoverInputSchemaResponse
        .builder
        .ifSome(inputSchema)(_.inputSchema(_))
        .ifSome(parsedInputRecords)(_.parsedInputRecords(_))
        .ifSome(processedInputRecords)(_.processedInputRecords(_))
        .ifSome(rawInputRecords)(_.rawInputRecords(_))
        .build

    def environmentProperties(
      propertyGroups: Option[List[PropertyGroup]] = None
    ): EnvironmentProperties =
      EnvironmentProperties
        .builder
        .ifSome(propertyGroups)(_.propertyGroups(_))
        .build

    def environmentPropertyDescriptions(
      propertyGroupDescriptions: Option[List[PropertyGroup]] = None
    ): EnvironmentPropertyDescriptions =
      EnvironmentPropertyDescriptions
        .builder
        .ifSome(propertyGroupDescriptions)(_.propertyGroupDescriptions(_))
        .build

    def environmentPropertyUpdates(
      propertyGroups: Option[List[PropertyGroup]] = None
    ): EnvironmentPropertyUpdates =
      EnvironmentPropertyUpdates
        .builder
        .ifSome(propertyGroups)(_.propertyGroups(_))
        .build

    def flinkApplicationConfiguration(
      checkpointConfiguration: Option[CheckpointConfiguration] = None,
      monitoringConfiguration: Option[MonitoringConfiguration] = None,
      parallelismConfiguration: Option[ParallelismConfiguration] = None
    ): FlinkApplicationConfiguration =
      FlinkApplicationConfiguration
        .builder
        .ifSome(checkpointConfiguration)(_.checkpointConfiguration(_))
        .ifSome(monitoringConfiguration)(_.monitoringConfiguration(_))
        .ifSome(parallelismConfiguration)(_.parallelismConfiguration(_))
        .build

    def flinkApplicationConfigurationDescription(
      checkpointConfigurationDescription: Option[CheckpointConfigurationDescription] = None,
      monitoringConfigurationDescription: Option[MonitoringConfigurationDescription] = None,
      parallelismConfigurationDescription: Option[ParallelismConfigurationDescription] = None,
      jobPlanDescription: Option[String] = None
    ): FlinkApplicationConfigurationDescription =
      FlinkApplicationConfigurationDescription
        .builder
        .ifSome(checkpointConfigurationDescription)(_.checkpointConfigurationDescription(_))
        .ifSome(monitoringConfigurationDescription)(_.monitoringConfigurationDescription(_))
        .ifSome(parallelismConfigurationDescription)(_.parallelismConfigurationDescription(_))
        .ifSome(jobPlanDescription)(_.jobPlanDescription(_))
        .build

    def flinkApplicationConfigurationUpdate(
      checkpointConfigurationUpdate: Option[CheckpointConfigurationUpdate] = None,
      monitoringConfigurationUpdate: Option[MonitoringConfigurationUpdate] = None,
      parallelismConfigurationUpdate: Option[ParallelismConfigurationUpdate] = None
    ): FlinkApplicationConfigurationUpdate =
      FlinkApplicationConfigurationUpdate
        .builder
        .ifSome(checkpointConfigurationUpdate)(_.checkpointConfigurationUpdate(_))
        .ifSome(monitoringConfigurationUpdate)(_.monitoringConfigurationUpdate(_))
        .ifSome(parallelismConfigurationUpdate)(_.parallelismConfigurationUpdate(_))
        .build

    def flinkRunConfiguration(
      allowNonRestoredState: Option[Boolean] = None
    ): FlinkRunConfiguration =
      FlinkRunConfiguration
        .builder
        .ifSome(allowNonRestoredState)(_.allowNonRestoredState(_))
        .build

    def glueDataCatalogConfiguration(
      databaseARN: Option[String] = None
    ): GlueDataCatalogConfiguration =
      GlueDataCatalogConfiguration
        .builder
        .ifSome(databaseARN)(_.databaseARN(_))
        .build

    def glueDataCatalogConfigurationDescription(
      databaseARN: Option[String] = None
    ): GlueDataCatalogConfigurationDescription =
      GlueDataCatalogConfigurationDescription
        .builder
        .ifSome(databaseARN)(_.databaseARN(_))
        .build

    def glueDataCatalogConfigurationUpdate(
      databaseARNUpdate: Option[String] = None
    ): GlueDataCatalogConfigurationUpdate =
      GlueDataCatalogConfigurationUpdate
        .builder
        .ifSome(databaseARNUpdate)(_.databaseARNUpdate(_))
        .build

    def input(
      namePrefix: Option[String] = None,
      inputProcessingConfiguration: Option[InputProcessingConfiguration] = None,
      kinesisStreamsInput: Option[KinesisStreamsInput] = None,
      kinesisFirehoseInput: Option[KinesisFirehoseInput] = None,
      inputParallelism: Option[InputParallelism] = None,
      inputSchema: Option[SourceSchema] = None
    ): Input =
      Input
        .builder
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(inputProcessingConfiguration)(_.inputProcessingConfiguration(_))
        .ifSome(kinesisStreamsInput)(_.kinesisStreamsInput(_))
        .ifSome(kinesisFirehoseInput)(_.kinesisFirehoseInput(_))
        .ifSome(inputParallelism)(_.inputParallelism(_))
        .ifSome(inputSchema)(_.inputSchema(_))
        .build

    def inputDescription(
      inputId: Option[String] = None,
      namePrefix: Option[String] = None,
      inAppStreamNames: Option[List[InAppStreamName]] = None,
      inputProcessingConfigurationDescription: Option[InputProcessingConfigurationDescription] = None,
      kinesisStreamsInputDescription: Option[KinesisStreamsInputDescription] = None,
      kinesisFirehoseInputDescription: Option[KinesisFirehoseInputDescription] = None,
      inputSchema: Option[SourceSchema] = None,
      inputParallelism: Option[InputParallelism] = None,
      inputStartingPositionConfiguration: Option[InputStartingPositionConfiguration] = None
    ): InputDescription =
      InputDescription
        .builder
        .ifSome(inputId)(_.inputId(_))
        .ifSome(namePrefix)(_.namePrefix(_))
        .ifSome(inAppStreamNames)(_.inAppStreamNames(_))
        .ifSome(inputProcessingConfigurationDescription)(_.inputProcessingConfigurationDescription(_))
        .ifSome(kinesisStreamsInputDescription)(_.kinesisStreamsInputDescription(_))
        .ifSome(kinesisFirehoseInputDescription)(_.kinesisFirehoseInputDescription(_))
        .ifSome(inputSchema)(_.inputSchema(_))
        .ifSome(inputParallelism)(_.inputParallelism(_))
        .ifSome(inputStartingPositionConfiguration)(_.inputStartingPositionConfiguration(_))
        .build

    def inputLambdaProcessor(
      resourceARN: Option[String] = None
    ): InputLambdaProcessor =
      InputLambdaProcessor
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def inputLambdaProcessorDescription(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): InputLambdaProcessorDescription =
      InputLambdaProcessorDescription
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def inputLambdaProcessorUpdate(
      resourceARNUpdate: Option[String] = None
    ): InputLambdaProcessorUpdate =
      InputLambdaProcessorUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .build

    def inputParallelism(
      count: Option[Int] = None
    ): InputParallelism =
      InputParallelism
        .builder
        .ifSome(count)(_.count(_))
        .build

    def inputParallelismUpdate(
      countUpdate: Option[Int] = None
    ): InputParallelismUpdate =
      InputParallelismUpdate
        .builder
        .ifSome(countUpdate)(_.countUpdate(_))
        .build

    def inputProcessingConfiguration(
      inputLambdaProcessor: Option[InputLambdaProcessor] = None
    ): InputProcessingConfiguration =
      InputProcessingConfiguration
        .builder
        .ifSome(inputLambdaProcessor)(_.inputLambdaProcessor(_))
        .build

    def inputProcessingConfigurationDescription(
      inputLambdaProcessorDescription: Option[InputLambdaProcessorDescription] = None
    ): InputProcessingConfigurationDescription =
      InputProcessingConfigurationDescription
        .builder
        .ifSome(inputLambdaProcessorDescription)(_.inputLambdaProcessorDescription(_))
        .build

    def inputProcessingConfigurationUpdate(
      inputLambdaProcessorUpdate: Option[InputLambdaProcessorUpdate] = None
    ): InputProcessingConfigurationUpdate =
      InputProcessingConfigurationUpdate
        .builder
        .ifSome(inputLambdaProcessorUpdate)(_.inputLambdaProcessorUpdate(_))
        .build

    def inputSchemaUpdate(
      recordFormatUpdate: Option[RecordFormat] = None,
      recordEncodingUpdate: Option[String] = None,
      recordColumnUpdates: Option[List[RecordColumn]] = None
    ): InputSchemaUpdate =
      InputSchemaUpdate
        .builder
        .ifSome(recordFormatUpdate)(_.recordFormatUpdate(_))
        .ifSome(recordEncodingUpdate)(_.recordEncodingUpdate(_))
        .ifSome(recordColumnUpdates)(_.recordColumnUpdates(_))
        .build

    def inputStartingPositionConfiguration(
      inputStartingPosition: Option[String] = None
    ): InputStartingPositionConfiguration =
      InputStartingPositionConfiguration
        .builder
        .ifSome(inputStartingPosition)(_.inputStartingPosition(_))
        .build

    def inputUpdate(
      inputId: Option[String] = None,
      namePrefixUpdate: Option[String] = None,
      inputProcessingConfigurationUpdate: Option[InputProcessingConfigurationUpdate] = None,
      kinesisStreamsInputUpdate: Option[KinesisStreamsInputUpdate] = None,
      kinesisFirehoseInputUpdate: Option[KinesisFirehoseInputUpdate] = None,
      inputSchemaUpdate: Option[InputSchemaUpdate] = None,
      inputParallelismUpdate: Option[InputParallelismUpdate] = None
    ): InputUpdate =
      InputUpdate
        .builder
        .ifSome(inputId)(_.inputId(_))
        .ifSome(namePrefixUpdate)(_.namePrefixUpdate(_))
        .ifSome(inputProcessingConfigurationUpdate)(_.inputProcessingConfigurationUpdate(_))
        .ifSome(kinesisStreamsInputUpdate)(_.kinesisStreamsInputUpdate(_))
        .ifSome(kinesisFirehoseInputUpdate)(_.kinesisFirehoseInputUpdate(_))
        .ifSome(inputSchemaUpdate)(_.inputSchemaUpdate(_))
        .ifSome(inputParallelismUpdate)(_.inputParallelismUpdate(_))
        .build

    def invalidApplicationConfigurationException(
      message: Option[String] = None
    ): InvalidApplicationConfigurationException =
      InvalidApplicationConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
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

    def jSONMappingParameters(
      recordRowPath: Option[String] = None
    ): JSONMappingParameters =
      JSONMappingParameters
        .builder
        .ifSome(recordRowPath)(_.recordRowPath(_))
        .build

    def kinesisFirehoseInput(
      resourceARN: Option[String] = None
    ): KinesisFirehoseInput =
      KinesisFirehoseInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def kinesisFirehoseInputDescription(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisFirehoseInputDescription =
      KinesisFirehoseInputDescription
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def kinesisFirehoseInputUpdate(
      resourceARNUpdate: Option[String] = None
    ): KinesisFirehoseInputUpdate =
      KinesisFirehoseInputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .build

    def kinesisFirehoseOutput(
      resourceARN: Option[String] = None
    ): KinesisFirehoseOutput =
      KinesisFirehoseOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def kinesisFirehoseOutputDescription(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisFirehoseOutputDescription =
      KinesisFirehoseOutputDescription
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def kinesisFirehoseOutputUpdate(
      resourceARNUpdate: Option[String] = None
    ): KinesisFirehoseOutputUpdate =
      KinesisFirehoseOutputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .build

    def kinesisStreamsInput(
      resourceARN: Option[String] = None
    ): KinesisStreamsInput =
      KinesisStreamsInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def kinesisStreamsInputDescription(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisStreamsInputDescription =
      KinesisStreamsInputDescription
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def kinesisStreamsInputUpdate(
      resourceARNUpdate: Option[String] = None
    ): KinesisStreamsInputUpdate =
      KinesisStreamsInputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .build

    def kinesisStreamsOutput(
      resourceARN: Option[String] = None
    ): KinesisStreamsOutput =
      KinesisStreamsOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def kinesisStreamsOutputDescription(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisStreamsOutputDescription =
      KinesisStreamsOutputDescription
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def kinesisStreamsOutputUpdate(
      resourceARNUpdate: Option[String] = None
    ): KinesisStreamsOutputUpdate =
      KinesisStreamsOutputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .build

    def lambdaOutput(
      resourceARN: Option[String] = None
    ): LambdaOutput =
      LambdaOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def lambdaOutputDescription(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): LambdaOutputDescription =
      LambdaOutputDescription
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def lambdaOutputUpdate(
      resourceARNUpdate: Option[String] = None
    ): LambdaOutputUpdate =
      LambdaOutputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApplicationSnapshotsRequest(
      applicationName: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationSnapshotsRequest =
      ListApplicationSnapshotsRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationSnapshotsResponse(
      snapshotSummaries: Option[List[SnapshotDetails]] = None,
      nextToken: Option[String] = None
    ): ListApplicationSnapshotsResponse =
      ListApplicationSnapshotsResponse
        .builder
        .ifSome(snapshotSummaries)(_.snapshotSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationVersionsRequest(
      applicationName: Option[String] = None,
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationVersionsRequest =
      ListApplicationVersionsRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationVersionsResponse(
      applicationVersionSummaries: Option[List[ApplicationVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListApplicationVersionsResponse =
      ListApplicationVersionsResponse
        .builder
        .ifSome(applicationVersionSummaries)(_.applicationVersionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsRequest(
      limit: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listApplicationsResponse(
      applicationSummaries: Option[List[ApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ListApplicationsResponse =
      ListApplicationsResponse
        .builder
        .ifSome(applicationSummaries)(_.applicationSummaries(_))
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

    def mappingParameters(
      jSONMappingParameters: Option[JSONMappingParameters] = None,
      cSVMappingParameters: Option[CSVMappingParameters] = None
    ): MappingParameters =
      MappingParameters
        .builder
        .ifSome(jSONMappingParameters)(_.jSONMappingParameters(_))
        .ifSome(cSVMappingParameters)(_.cSVMappingParameters(_))
        .build

    def mavenReference(
      groupId: Option[String] = None,
      artifactId: Option[String] = None,
      version: Option[String] = None
    ): MavenReference =
      MavenReference
        .builder
        .ifSome(groupId)(_.groupId(_))
        .ifSome(artifactId)(_.artifactId(_))
        .ifSome(version)(_.version(_))
        .build

    def monitoringConfiguration(
      configurationType: Option[String] = None,
      metricsLevel: Option[String] = None,
      logLevel: Option[String] = None
    ): MonitoringConfiguration =
      MonitoringConfiguration
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(metricsLevel)(_.metricsLevel(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def monitoringConfigurationDescription(
      configurationType: Option[String] = None,
      metricsLevel: Option[String] = None,
      logLevel: Option[String] = None
    ): MonitoringConfigurationDescription =
      MonitoringConfigurationDescription
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(metricsLevel)(_.metricsLevel(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def monitoringConfigurationUpdate(
      configurationTypeUpdate: Option[String] = None,
      metricsLevelUpdate: Option[String] = None,
      logLevelUpdate: Option[String] = None
    ): MonitoringConfigurationUpdate =
      MonitoringConfigurationUpdate
        .builder
        .ifSome(configurationTypeUpdate)(_.configurationTypeUpdate(_))
        .ifSome(metricsLevelUpdate)(_.metricsLevelUpdate(_))
        .ifSome(logLevelUpdate)(_.logLevelUpdate(_))
        .build

    def output(
      name: Option[String] = None,
      kinesisStreamsOutput: Option[KinesisStreamsOutput] = None,
      kinesisFirehoseOutput: Option[KinesisFirehoseOutput] = None,
      lambdaOutput: Option[LambdaOutput] = None,
      destinationSchema: Option[DestinationSchema] = None
    ): Output =
      Output
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(kinesisStreamsOutput)(_.kinesisStreamsOutput(_))
        .ifSome(kinesisFirehoseOutput)(_.kinesisFirehoseOutput(_))
        .ifSome(lambdaOutput)(_.lambdaOutput(_))
        .ifSome(destinationSchema)(_.destinationSchema(_))
        .build

    def outputDescription(
      outputId: Option[String] = None,
      name: Option[String] = None,
      kinesisStreamsOutputDescription: Option[KinesisStreamsOutputDescription] = None,
      kinesisFirehoseOutputDescription: Option[KinesisFirehoseOutputDescription] = None,
      lambdaOutputDescription: Option[LambdaOutputDescription] = None,
      destinationSchema: Option[DestinationSchema] = None
    ): OutputDescription =
      OutputDescription
        .builder
        .ifSome(outputId)(_.outputId(_))
        .ifSome(name)(_.name(_))
        .ifSome(kinesisStreamsOutputDescription)(_.kinesisStreamsOutputDescription(_))
        .ifSome(kinesisFirehoseOutputDescription)(_.kinesisFirehoseOutputDescription(_))
        .ifSome(lambdaOutputDescription)(_.lambdaOutputDescription(_))
        .ifSome(destinationSchema)(_.destinationSchema(_))
        .build

    def outputUpdate(
      outputId: Option[String] = None,
      nameUpdate: Option[String] = None,
      kinesisStreamsOutputUpdate: Option[KinesisStreamsOutputUpdate] = None,
      kinesisFirehoseOutputUpdate: Option[KinesisFirehoseOutputUpdate] = None,
      lambdaOutputUpdate: Option[LambdaOutputUpdate] = None,
      destinationSchemaUpdate: Option[DestinationSchema] = None
    ): OutputUpdate =
      OutputUpdate
        .builder
        .ifSome(outputId)(_.outputId(_))
        .ifSome(nameUpdate)(_.nameUpdate(_))
        .ifSome(kinesisStreamsOutputUpdate)(_.kinesisStreamsOutputUpdate(_))
        .ifSome(kinesisFirehoseOutputUpdate)(_.kinesisFirehoseOutputUpdate(_))
        .ifSome(lambdaOutputUpdate)(_.lambdaOutputUpdate(_))
        .ifSome(destinationSchemaUpdate)(_.destinationSchemaUpdate(_))
        .build

    def parallelismConfiguration(
      configurationType: Option[String] = None,
      parallelism: Option[Int] = None,
      parallelismPerKPU: Option[Int] = None,
      autoScalingEnabled: Option[Boolean] = None
    ): ParallelismConfiguration =
      ParallelismConfiguration
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(parallelism)(_.parallelism(_))
        .ifSome(parallelismPerKPU)(_.parallelismPerKPU(_))
        .ifSome(autoScalingEnabled)(_.autoScalingEnabled(_))
        .build

    def parallelismConfigurationDescription(
      configurationType: Option[String] = None,
      parallelism: Option[Int] = None,
      parallelismPerKPU: Option[Int] = None,
      currentParallelism: Option[Int] = None,
      autoScalingEnabled: Option[Boolean] = None
    ): ParallelismConfigurationDescription =
      ParallelismConfigurationDescription
        .builder
        .ifSome(configurationType)(_.configurationType(_))
        .ifSome(parallelism)(_.parallelism(_))
        .ifSome(parallelismPerKPU)(_.parallelismPerKPU(_))
        .ifSome(currentParallelism)(_.currentParallelism(_))
        .ifSome(autoScalingEnabled)(_.autoScalingEnabled(_))
        .build

    def parallelismConfigurationUpdate(
      configurationTypeUpdate: Option[String] = None,
      parallelismUpdate: Option[Int] = None,
      parallelismPerKPUUpdate: Option[Int] = None,
      autoScalingEnabledUpdate: Option[Boolean] = None
    ): ParallelismConfigurationUpdate =
      ParallelismConfigurationUpdate
        .builder
        .ifSome(configurationTypeUpdate)(_.configurationTypeUpdate(_))
        .ifSome(parallelismUpdate)(_.parallelismUpdate(_))
        .ifSome(parallelismPerKPUUpdate)(_.parallelismPerKPUUpdate(_))
        .ifSome(autoScalingEnabledUpdate)(_.autoScalingEnabledUpdate(_))
        .build

    def propertyGroup(
      propertyGroupId: Option[String] = None,
      propertyMap: Option[PropertyMap] = None
    ): PropertyGroup =
      PropertyGroup
        .builder
        .ifSome(propertyGroupId)(_.propertyGroupId(_))
        .ifSome(propertyMap)(_.propertyMap(_))
        .build

    def recordColumn(
      name: Option[String] = None,
      mapping: Option[String] = None,
      sqlType: Option[String] = None
    ): RecordColumn =
      RecordColumn
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(mapping)(_.mapping(_))
        .ifSome(sqlType)(_.sqlType(_))
        .build

    def recordFormat(
      recordFormatType: Option[String] = None,
      mappingParameters: Option[MappingParameters] = None
    ): RecordFormat =
      RecordFormat
        .builder
        .ifSome(recordFormatType)(_.recordFormatType(_))
        .ifSome(mappingParameters)(_.mappingParameters(_))
        .build

    def referenceDataSource(
      tableName: Option[String] = None,
      s3ReferenceDataSource: Option[S3ReferenceDataSource] = None,
      referenceSchema: Option[SourceSchema] = None
    ): ReferenceDataSource =
      ReferenceDataSource
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(s3ReferenceDataSource)(_.s3ReferenceDataSource(_))
        .ifSome(referenceSchema)(_.referenceSchema(_))
        .build

    def referenceDataSourceDescription(
      referenceId: Option[String] = None,
      tableName: Option[String] = None,
      s3ReferenceDataSourceDescription: Option[S3ReferenceDataSourceDescription] = None,
      referenceSchema: Option[SourceSchema] = None
    ): ReferenceDataSourceDescription =
      ReferenceDataSourceDescription
        .builder
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(s3ReferenceDataSourceDescription)(_.s3ReferenceDataSourceDescription(_))
        .ifSome(referenceSchema)(_.referenceSchema(_))
        .build

    def referenceDataSourceUpdate(
      referenceId: Option[String] = None,
      tableNameUpdate: Option[String] = None,
      s3ReferenceDataSourceUpdate: Option[S3ReferenceDataSourceUpdate] = None,
      referenceSchemaUpdate: Option[SourceSchema] = None
    ): ReferenceDataSourceUpdate =
      ReferenceDataSourceUpdate
        .builder
        .ifSome(referenceId)(_.referenceId(_))
        .ifSome(tableNameUpdate)(_.tableNameUpdate(_))
        .ifSome(s3ReferenceDataSourceUpdate)(_.s3ReferenceDataSourceUpdate(_))
        .ifSome(referenceSchemaUpdate)(_.referenceSchemaUpdate(_))
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

    def resourceProvisionedThroughputExceededException(
      message: Option[String] = None
    ): ResourceProvisionedThroughputExceededException =
      ResourceProvisionedThroughputExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def rollbackApplicationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None
    ): RollbackApplicationRequest =
      RollbackApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .build

    def rollbackApplicationResponse(
      applicationDetail: Option[ApplicationDetail] = None
    ): RollbackApplicationResponse =
      RollbackApplicationResponse
        .builder
        .ifSome(applicationDetail)(_.applicationDetail(_))
        .build

    def runConfiguration(
      flinkRunConfiguration: Option[FlinkRunConfiguration] = None,
      sqlRunConfigurations: Option[List[SqlRunConfiguration]] = None,
      applicationRestoreConfiguration: Option[ApplicationRestoreConfiguration] = None
    ): RunConfiguration =
      RunConfiguration
        .builder
        .ifSome(flinkRunConfiguration)(_.flinkRunConfiguration(_))
        .ifSome(sqlRunConfigurations)(_.sqlRunConfigurations(_))
        .ifSome(applicationRestoreConfiguration)(_.applicationRestoreConfiguration(_))
        .build

    def runConfigurationDescription(
      applicationRestoreConfigurationDescription: Option[ApplicationRestoreConfiguration] = None,
      flinkRunConfigurationDescription: Option[FlinkRunConfiguration] = None
    ): RunConfigurationDescription =
      RunConfigurationDescription
        .builder
        .ifSome(applicationRestoreConfigurationDescription)(_.applicationRestoreConfigurationDescription(_))
        .ifSome(flinkRunConfigurationDescription)(_.flinkRunConfigurationDescription(_))
        .build

    def runConfigurationUpdate(
      flinkRunConfiguration: Option[FlinkRunConfiguration] = None,
      applicationRestoreConfiguration: Option[ApplicationRestoreConfiguration] = None
    ): RunConfigurationUpdate =
      RunConfigurationUpdate
        .builder
        .ifSome(flinkRunConfiguration)(_.flinkRunConfiguration(_))
        .ifSome(applicationRestoreConfiguration)(_.applicationRestoreConfiguration(_))
        .build

    def s3ApplicationCodeLocationDescription(
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None,
      objectVersion: Option[String] = None
    ): S3ApplicationCodeLocationDescription =
      S3ApplicationCodeLocationDescription
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .ifSome(objectVersion)(_.objectVersion(_))
        .build

    def s3Configuration(
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None
    ): S3Configuration =
      S3Configuration
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .build

    def s3ContentBaseLocation(
      bucketARN: Option[String] = None,
      basePath: Option[String] = None
    ): S3ContentBaseLocation =
      S3ContentBaseLocation
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(basePath)(_.basePath(_))
        .build

    def s3ContentBaseLocationDescription(
      bucketARN: Option[String] = None,
      basePath: Option[String] = None
    ): S3ContentBaseLocationDescription =
      S3ContentBaseLocationDescription
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(basePath)(_.basePath(_))
        .build

    def s3ContentBaseLocationUpdate(
      bucketARNUpdate: Option[String] = None,
      basePathUpdate: Option[String] = None
    ): S3ContentBaseLocationUpdate =
      S3ContentBaseLocationUpdate
        .builder
        .ifSome(bucketARNUpdate)(_.bucketARNUpdate(_))
        .ifSome(basePathUpdate)(_.basePathUpdate(_))
        .build

    def s3ContentLocation(
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None,
      objectVersion: Option[String] = None
    ): S3ContentLocation =
      S3ContentLocation
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .ifSome(objectVersion)(_.objectVersion(_))
        .build

    def s3ContentLocationUpdate(
      bucketARNUpdate: Option[String] = None,
      fileKeyUpdate: Option[String] = None,
      objectVersionUpdate: Option[String] = None
    ): S3ContentLocationUpdate =
      S3ContentLocationUpdate
        .builder
        .ifSome(bucketARNUpdate)(_.bucketARNUpdate(_))
        .ifSome(fileKeyUpdate)(_.fileKeyUpdate(_))
        .ifSome(objectVersionUpdate)(_.objectVersionUpdate(_))
        .build

    def s3ReferenceDataSource(
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None
    ): S3ReferenceDataSource =
      S3ReferenceDataSource
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .build

    def s3ReferenceDataSourceDescription(
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None,
      referenceRoleARN: Option[String] = None
    ): S3ReferenceDataSourceDescription =
      S3ReferenceDataSourceDescription
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .ifSome(referenceRoleARN)(_.referenceRoleARN(_))
        .build

    def s3ReferenceDataSourceUpdate(
      bucketARNUpdate: Option[String] = None,
      fileKeyUpdate: Option[String] = None
    ): S3ReferenceDataSourceUpdate =
      S3ReferenceDataSourceUpdate
        .builder
        .ifSome(bucketARNUpdate)(_.bucketARNUpdate(_))
        .ifSome(fileKeyUpdate)(_.fileKeyUpdate(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def snapshotDetails(
      snapshotName: Option[String] = None,
      snapshotStatus: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None,
      snapshotCreationTimestamp: Option[Timestamp] = None
    ): SnapshotDetails =
      SnapshotDetails
        .builder
        .ifSome(snapshotName)(_.snapshotName(_))
        .ifSome(snapshotStatus)(_.snapshotStatus(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .ifSome(snapshotCreationTimestamp)(_.snapshotCreationTimestamp(_))
        .build

    def sourceSchema(
      recordFormat: Option[RecordFormat] = None,
      recordEncoding: Option[String] = None,
      recordColumns: Option[List[RecordColumn]] = None
    ): SourceSchema =
      SourceSchema
        .builder
        .ifSome(recordFormat)(_.recordFormat(_))
        .ifSome(recordEncoding)(_.recordEncoding(_))
        .ifSome(recordColumns)(_.recordColumns(_))
        .build

    def sqlApplicationConfiguration(
      inputs: Option[List[Input]] = None,
      outputs: Option[List[Output]] = None,
      referenceDataSources: Option[List[ReferenceDataSource]] = None
    ): SqlApplicationConfiguration =
      SqlApplicationConfiguration
        .builder
        .ifSome(inputs)(_.inputs(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(referenceDataSources)(_.referenceDataSources(_))
        .build

    def sqlApplicationConfigurationDescription(
      inputDescriptions: Option[List[InputDescription]] = None,
      outputDescriptions: Option[List[OutputDescription]] = None,
      referenceDataSourceDescriptions: Option[List[ReferenceDataSourceDescription]] = None
    ): SqlApplicationConfigurationDescription =
      SqlApplicationConfigurationDescription
        .builder
        .ifSome(inputDescriptions)(_.inputDescriptions(_))
        .ifSome(outputDescriptions)(_.outputDescriptions(_))
        .ifSome(referenceDataSourceDescriptions)(_.referenceDataSourceDescriptions(_))
        .build

    def sqlApplicationConfigurationUpdate(
      inputUpdates: Option[List[InputUpdate]] = None,
      outputUpdates: Option[List[OutputUpdate]] = None,
      referenceDataSourceUpdates: Option[List[ReferenceDataSourceUpdate]] = None
    ): SqlApplicationConfigurationUpdate =
      SqlApplicationConfigurationUpdate
        .builder
        .ifSome(inputUpdates)(_.inputUpdates(_))
        .ifSome(outputUpdates)(_.outputUpdates(_))
        .ifSome(referenceDataSourceUpdates)(_.referenceDataSourceUpdates(_))
        .build

    def sqlRunConfiguration(
      inputId: Option[String] = None,
      inputStartingPositionConfiguration: Option[InputStartingPositionConfiguration] = None
    ): SqlRunConfiguration =
      SqlRunConfiguration
        .builder
        .ifSome(inputId)(_.inputId(_))
        .ifSome(inputStartingPositionConfiguration)(_.inputStartingPositionConfiguration(_))
        .build

    def startApplicationRequest(
      applicationName: Option[String] = None,
      runConfiguration: Option[RunConfiguration] = None
    ): StartApplicationRequest =
      StartApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(runConfiguration)(_.runConfiguration(_))
        .build

    def startApplicationResponse(

    ): StartApplicationResponse =
      StartApplicationResponse
        .builder

        .build

    def stopApplicationRequest(
      applicationName: Option[String] = None,
      force: Option[Boolean] = None
    ): StopApplicationRequest =
      StopApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(force)(_.force(_))
        .build

    def stopApplicationResponse(

    ): StopApplicationResponse =
      StopApplicationResponse
        .builder

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

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unableToDetectSchemaException(
      message: Option[String] = None,
      rawInputRecords: Option[List[RawInputRecord]] = None,
      processedInputRecords: Option[List[ProcessedInputRecord]] = None
    ): UnableToDetectSchemaException =
      UnableToDetectSchemaException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(rawInputRecords)(_.rawInputRecords(_))
        .ifSome(processedInputRecords)(_.processedInputRecords(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateApplicationMaintenanceConfigurationRequest(
      applicationName: Option[String] = None,
      applicationMaintenanceConfigurationUpdate: Option[ApplicationMaintenanceConfigurationUpdate] = None
    ): UpdateApplicationMaintenanceConfigurationRequest =
      UpdateApplicationMaintenanceConfigurationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationMaintenanceConfigurationUpdate)(_.applicationMaintenanceConfigurationUpdate(_))
        .build

    def updateApplicationMaintenanceConfigurationResponse(
      applicationARN: Option[String] = None,
      applicationMaintenanceConfigurationDescription: Option[ApplicationMaintenanceConfigurationDescription] = None
    ): UpdateApplicationMaintenanceConfigurationResponse =
      UpdateApplicationMaintenanceConfigurationResponse
        .builder
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationMaintenanceConfigurationDescription)(_.applicationMaintenanceConfigurationDescription(_))
        .build

    def updateApplicationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      applicationConfigurationUpdate: Option[ApplicationConfigurationUpdate] = None,
      serviceExecutionRoleUpdate: Option[String] = None,
      runConfigurationUpdate: Option[RunConfigurationUpdate] = None,
      cloudWatchLoggingOptionUpdates: Option[List[CloudWatchLoggingOptionUpdate]] = None,
      conditionalToken: Option[String] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(applicationConfigurationUpdate)(_.applicationConfigurationUpdate(_))
        .ifSome(serviceExecutionRoleUpdate)(_.serviceExecutionRoleUpdate(_))
        .ifSome(runConfigurationUpdate)(_.runConfigurationUpdate(_))
        .ifSome(cloudWatchLoggingOptionUpdates)(_.cloudWatchLoggingOptionUpdates(_))
        .ifSome(conditionalToken)(_.conditionalToken(_))
        .build

    def updateApplicationResponse(
      applicationDetail: Option[ApplicationDetail] = None
    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder
        .ifSome(applicationDetail)(_.applicationDetail(_))
        .build

    def vpcConfiguration(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): VpcConfiguration =
      VpcConfiguration
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def vpcConfigurationDescription(
      vpcConfigurationId: Option[String] = None,
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): VpcConfigurationDescription =
      VpcConfigurationDescription
        .builder
        .ifSome(vpcConfigurationId)(_.vpcConfigurationId(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def vpcConfigurationUpdate(
      vpcConfigurationId: Option[String] = None,
      subnetIdUpdates: Option[List[SubnetId]] = None,
      securityGroupIdUpdates: Option[List[SecurityGroupId]] = None
    ): VpcConfigurationUpdate =
      VpcConfigurationUpdate
        .builder
        .ifSome(vpcConfigurationId)(_.vpcConfigurationId(_))
        .ifSome(subnetIdUpdates)(_.subnetIdUpdates(_))
        .ifSome(securityGroupIdUpdates)(_.securityGroupIdUpdates(_))
        .build

    def zeppelinApplicationConfiguration(
      monitoringConfiguration: Option[ZeppelinMonitoringConfiguration] = None,
      catalogConfiguration: Option[CatalogConfiguration] = None,
      deployAsApplicationConfiguration: Option[DeployAsApplicationConfiguration] = None,
      customArtifactsConfiguration: Option[List[CustomArtifactConfiguration]] = None
    ): ZeppelinApplicationConfiguration =
      ZeppelinApplicationConfiguration
        .builder
        .ifSome(monitoringConfiguration)(_.monitoringConfiguration(_))
        .ifSome(catalogConfiguration)(_.catalogConfiguration(_))
        .ifSome(deployAsApplicationConfiguration)(_.deployAsApplicationConfiguration(_))
        .ifSome(customArtifactsConfiguration)(_.customArtifactsConfiguration(_))
        .build

    def zeppelinApplicationConfigurationDescription(
      monitoringConfigurationDescription: Option[ZeppelinMonitoringConfigurationDescription] = None,
      catalogConfigurationDescription: Option[CatalogConfigurationDescription] = None,
      deployAsApplicationConfigurationDescription: Option[DeployAsApplicationConfigurationDescription] = None,
      customArtifactsConfigurationDescription: Option[List[CustomArtifactConfigurationDescription]] = None
    ): ZeppelinApplicationConfigurationDescription =
      ZeppelinApplicationConfigurationDescription
        .builder
        .ifSome(monitoringConfigurationDescription)(_.monitoringConfigurationDescription(_))
        .ifSome(catalogConfigurationDescription)(_.catalogConfigurationDescription(_))
        .ifSome(deployAsApplicationConfigurationDescription)(_.deployAsApplicationConfigurationDescription(_))
        .ifSome(customArtifactsConfigurationDescription)(_.customArtifactsConfigurationDescription(_))
        .build

    def zeppelinApplicationConfigurationUpdate(
      monitoringConfigurationUpdate: Option[ZeppelinMonitoringConfigurationUpdate] = None,
      catalogConfigurationUpdate: Option[CatalogConfigurationUpdate] = None,
      deployAsApplicationConfigurationUpdate: Option[DeployAsApplicationConfigurationUpdate] = None,
      customArtifactsConfigurationUpdate: Option[List[CustomArtifactConfiguration]] = None
    ): ZeppelinApplicationConfigurationUpdate =
      ZeppelinApplicationConfigurationUpdate
        .builder
        .ifSome(monitoringConfigurationUpdate)(_.monitoringConfigurationUpdate(_))
        .ifSome(catalogConfigurationUpdate)(_.catalogConfigurationUpdate(_))
        .ifSome(deployAsApplicationConfigurationUpdate)(_.deployAsApplicationConfigurationUpdate(_))
        .ifSome(customArtifactsConfigurationUpdate)(_.customArtifactsConfigurationUpdate(_))
        .build

    def zeppelinMonitoringConfiguration(
      logLevel: Option[String] = None
    ): ZeppelinMonitoringConfiguration =
      ZeppelinMonitoringConfiguration
        .builder
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def zeppelinMonitoringConfigurationDescription(
      logLevel: Option[String] = None
    ): ZeppelinMonitoringConfigurationDescription =
      ZeppelinMonitoringConfigurationDescription
        .builder
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def zeppelinMonitoringConfigurationUpdate(
      logLevelUpdate: Option[String] = None
    ): ZeppelinMonitoringConfigurationUpdate =
      ZeppelinMonitoringConfigurationUpdate
        .builder
        .ifSome(logLevelUpdate)(_.logLevelUpdate(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
