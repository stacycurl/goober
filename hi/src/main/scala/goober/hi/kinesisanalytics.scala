package goober.hi

import goober.free.kinesisanalytics.KinesisAnalyticsIO
import software.amazon.awssdk.services.kinesisanalytics.model._


object kinesisanalytics {
  import goober.free.{kinesisanalytics ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def addApplicationCloudWatchLoggingOptionRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      cloudWatchLoggingOption: Option[CloudWatchLoggingOption] = None
    ): AddApplicationCloudWatchLoggingOptionRequest =
      AddApplicationCloudWatchLoggingOptionRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(cloudWatchLoggingOption)(_.cloudWatchLoggingOption(_))
        .build

    def addApplicationCloudWatchLoggingOptionResponse(

    ): AddApplicationCloudWatchLoggingOptionResponse =
      AddApplicationCloudWatchLoggingOptionResponse
        .builder

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

    ): AddApplicationInputProcessingConfigurationResponse =
      AddApplicationInputProcessingConfigurationResponse
        .builder

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

    ): AddApplicationInputResponse =
      AddApplicationInputResponse
        .builder

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

    ): AddApplicationOutputResponse =
      AddApplicationOutputResponse
        .builder

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

    ): AddApplicationReferenceDataSourceResponse =
      AddApplicationReferenceDataSourceResponse
        .builder

        .build

    def applicationDetail(
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      applicationARN: Option[String] = None,
      applicationStatus: Option[String] = None,
      createTimestamp: Option[Timestamp] = None,
      lastUpdateTimestamp: Option[Timestamp] = None,
      inputDescriptions: Option[List[InputDescription]] = None,
      outputDescriptions: Option[List[OutputDescription]] = None,
      referenceDataSourceDescriptions: Option[List[ReferenceDataSourceDescription]] = None,
      cloudWatchLoggingOptionDescriptions: Option[List[CloudWatchLoggingOptionDescription]] = None,
      applicationCode: Option[String] = None,
      applicationVersionId: Option[ApplicationVersionId] = None
    ): ApplicationDetail =
      ApplicationDetail
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationStatus)(_.applicationStatus(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(lastUpdateTimestamp)(_.lastUpdateTimestamp(_))
        .ifSome(inputDescriptions)(_.inputDescriptions(_))
        .ifSome(outputDescriptions)(_.outputDescriptions(_))
        .ifSome(referenceDataSourceDescriptions)(_.referenceDataSourceDescriptions(_))
        .ifSome(cloudWatchLoggingOptionDescriptions)(_.cloudWatchLoggingOptionDescriptions(_))
        .ifSome(applicationCode)(_.applicationCode(_))
        .ifSome(applicationVersionId)(_.applicationVersionId(_))
        .build

    def applicationSummary(
      applicationName: Option[String] = None,
      applicationARN: Option[String] = None,
      applicationStatus: Option[String] = None
    ): ApplicationSummary =
      ApplicationSummary
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationARN)(_.applicationARN(_))
        .ifSome(applicationStatus)(_.applicationStatus(_))
        .build

    def applicationUpdate(
      inputUpdates: Option[List[InputUpdate]] = None,
      applicationCodeUpdate: Option[String] = None,
      outputUpdates: Option[List[OutputUpdate]] = None,
      referenceDataSourceUpdates: Option[List[ReferenceDataSourceUpdate]] = None,
      cloudWatchLoggingOptionUpdates: Option[List[CloudWatchLoggingOptionUpdate]] = None
    ): ApplicationUpdate =
      ApplicationUpdate
        .builder
        .ifSome(inputUpdates)(_.inputUpdates(_))
        .ifSome(applicationCodeUpdate)(_.applicationCodeUpdate(_))
        .ifSome(outputUpdates)(_.outputUpdates(_))
        .ifSome(referenceDataSourceUpdates)(_.referenceDataSourceUpdates(_))
        .ifSome(cloudWatchLoggingOptionUpdates)(_.cloudWatchLoggingOptionUpdates(_))
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

    def cloudWatchLoggingOption(
      logStreamARN: Option[String] = None,
      roleARN: Option[String] = None
    ): CloudWatchLoggingOption =
      CloudWatchLoggingOption
        .builder
        .ifSome(logStreamARN)(_.logStreamARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      logStreamARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): CloudWatchLoggingOptionUpdate =
      CloudWatchLoggingOptionUpdate
        .builder
        .ifSome(cloudWatchLoggingOptionId)(_.cloudWatchLoggingOptionId(_))
        .ifSome(logStreamARNUpdate)(_.logStreamARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
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

    def createApplicationRequest(
      applicationName: Option[String] = None,
      applicationDescription: Option[String] = None,
      inputs: Option[List[Input]] = None,
      outputs: Option[List[Output]] = None,
      cloudWatchLoggingOptions: Option[List[CloudWatchLoggingOption]] = None,
      applicationCode: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateApplicationRequest =
      CreateApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(applicationDescription)(_.applicationDescription(_))
        .ifSome(inputs)(_.inputs(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(applicationCode)(_.applicationCode(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createApplicationResponse(
      applicationSummary: Option[ApplicationSummary] = None
    ): CreateApplicationResponse =
      CreateApplicationResponse
        .builder
        .ifSome(applicationSummary)(_.applicationSummary(_))
        .build

    def deleteApplicationCloudWatchLoggingOptionRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      cloudWatchLoggingOptionId: Option[String] = None
    ): DeleteApplicationCloudWatchLoggingOptionRequest =
      DeleteApplicationCloudWatchLoggingOptionRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(cloudWatchLoggingOptionId)(_.cloudWatchLoggingOptionId(_))
        .build

    def deleteApplicationCloudWatchLoggingOptionResponse(

    ): DeleteApplicationCloudWatchLoggingOptionResponse =
      DeleteApplicationCloudWatchLoggingOptionResponse
        .builder

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

    ): DeleteApplicationInputProcessingConfigurationResponse =
      DeleteApplicationInputProcessingConfigurationResponse
        .builder

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

    ): DeleteApplicationOutputResponse =
      DeleteApplicationOutputResponse
        .builder

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

    ): DeleteApplicationReferenceDataSourceResponse =
      DeleteApplicationReferenceDataSourceResponse
        .builder

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

    def describeApplicationRequest(
      applicationName: Option[String] = None
    ): DescribeApplicationRequest =
      DescribeApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .build

    def describeApplicationResponse(
      applicationDetail: Option[ApplicationDetail] = None
    ): DescribeApplicationResponse =
      DescribeApplicationResponse
        .builder
        .ifSome(applicationDetail)(_.applicationDetail(_))
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
      roleARN: Option[String] = None,
      inputStartingPositionConfiguration: Option[InputStartingPositionConfiguration] = None,
      s3Configuration: Option[S3Configuration] = None,
      inputProcessingConfiguration: Option[InputProcessingConfiguration] = None
    ): DiscoverInputSchemaRequest =
      DiscoverInputSchemaRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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

    def inputConfiguration(
      id: Option[String] = None,
      inputStartingPositionConfiguration: Option[InputStartingPositionConfiguration] = None
    ): InputConfiguration =
      InputConfiguration
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(inputStartingPositionConfiguration)(_.inputStartingPositionConfiguration(_))
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
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): InputLambdaProcessor =
      InputLambdaProcessor
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      resourceARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): InputLambdaProcessorUpdate =
      InputLambdaProcessorUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
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

    def jSONMappingParameters(
      recordRowPath: Option[String] = None
    ): JSONMappingParameters =
      JSONMappingParameters
        .builder
        .ifSome(recordRowPath)(_.recordRowPath(_))
        .build

    def kinesisFirehoseInput(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisFirehoseInput =
      KinesisFirehoseInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      resourceARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): KinesisFirehoseInputUpdate =
      KinesisFirehoseInputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
        .build

    def kinesisFirehoseOutput(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisFirehoseOutput =
      KinesisFirehoseOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      resourceARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): KinesisFirehoseOutputUpdate =
      KinesisFirehoseOutputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
        .build

    def kinesisStreamsInput(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisStreamsInput =
      KinesisStreamsInput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      resourceARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): KinesisStreamsInputUpdate =
      KinesisStreamsInputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
        .build

    def kinesisStreamsOutput(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisStreamsOutput =
      KinesisStreamsOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      resourceARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): KinesisStreamsOutputUpdate =
      KinesisStreamsOutputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
        .build

    def lambdaOutput(
      resourceARN: Option[String] = None,
      roleARN: Option[String] = None
    ): LambdaOutput =
      LambdaOutput
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(roleARN)(_.roleARN(_))
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
      resourceARNUpdate: Option[String] = None,
      roleARNUpdate: Option[String] = None
    ): LambdaOutputUpdate =
      LambdaOutputUpdate
        .builder
        .ifSome(resourceARNUpdate)(_.resourceARNUpdate(_))
        .ifSome(roleARNUpdate)(_.roleARNUpdate(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listApplicationsRequest(
      limit: Option[Int] = None,
      exclusiveStartApplicationName: Option[String] = None
    ): ListApplicationsRequest =
      ListApplicationsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(exclusiveStartApplicationName)(_.exclusiveStartApplicationName(_))
        .build

    def listApplicationsResponse(
      applicationSummaries: Option[List[ApplicationSummary]] = None,
      hasMoreApplications: Option[Boolean] = None
    ): ListApplicationsResponse =
      ListApplicationsResponse
        .builder
        .ifSome(applicationSummaries)(_.applicationSummaries(_))
        .ifSome(hasMoreApplications)(_.hasMoreApplications(_))
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

    def s3Configuration(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None
    ): S3Configuration =
      S3Configuration
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .build

    def s3ReferenceDataSource(
      bucketARN: Option[String] = None,
      fileKey: Option[String] = None,
      referenceRoleARN: Option[String] = None
    ): S3ReferenceDataSource =
      S3ReferenceDataSource
        .builder
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(fileKey)(_.fileKey(_))
        .ifSome(referenceRoleARN)(_.referenceRoleARN(_))
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
      fileKeyUpdate: Option[String] = None,
      referenceRoleARNUpdate: Option[String] = None
    ): S3ReferenceDataSourceUpdate =
      S3ReferenceDataSourceUpdate
        .builder
        .ifSome(bucketARNUpdate)(_.bucketARNUpdate(_))
        .ifSome(fileKeyUpdate)(_.fileKeyUpdate(_))
        .ifSome(referenceRoleARNUpdate)(_.referenceRoleARNUpdate(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
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

    def startApplicationRequest(
      applicationName: Option[String] = None,
      inputConfigurations: Option[List[InputConfiguration]] = None
    ): StartApplicationRequest =
      StartApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(inputConfigurations)(_.inputConfigurations(_))
        .build

    def startApplicationResponse(

    ): StartApplicationResponse =
      StartApplicationResponse
        .builder

        .build

    def stopApplicationRequest(
      applicationName: Option[String] = None
    ): StopApplicationRequest =
      StopApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
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

    def updateApplicationRequest(
      applicationName: Option[String] = None,
      currentApplicationVersionId: Option[ApplicationVersionId] = None,
      applicationUpdate: Option[ApplicationUpdate] = None
    ): UpdateApplicationRequest =
      UpdateApplicationRequest
        .builder
        .ifSome(applicationName)(_.applicationName(_))
        .ifSome(currentApplicationVersionId)(_.currentApplicationVersionId(_))
        .ifSome(applicationUpdate)(_.applicationUpdate(_))
        .build

    def updateApplicationResponse(

    ): UpdateApplicationResponse =
      UpdateApplicationResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
