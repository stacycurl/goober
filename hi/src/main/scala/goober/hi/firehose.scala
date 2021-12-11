package goober.hi

import goober.free.firehose.FirehoseIO
import software.amazon.awssdk.services.firehose.model._


object firehose {
  import goober.free.{firehose ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def bufferingHints(
      sizeInMBs: Option[Int] = None,
      intervalInSeconds: Option[Int] = None
    ): BufferingHints =
      BufferingHints
        .builder
        .ifSome(sizeInMBs)(_.sizeInMBs(_))
        .ifSome(intervalInSeconds)(_.intervalInSeconds(_))
        .build

    def cloudWatchLoggingOptions(
      enabled: Option[Boolean] = None,
      logGroupName: Option[String] = None,
      logStreamName: Option[String] = None
    ): CloudWatchLoggingOptions =
      CloudWatchLoggingOptions
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .ifSome(logStreamName)(_.logStreamName(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def copyCommand(
      dataTableName: Option[String] = None,
      dataTableColumns: Option[String] = None,
      copyOptions: Option[String] = None
    ): CopyCommand =
      CopyCommand
        .builder
        .ifSome(dataTableName)(_.dataTableName(_))
        .ifSome(dataTableColumns)(_.dataTableColumns(_))
        .ifSome(copyOptions)(_.copyOptions(_))
        .build

    def createDeliveryStreamInput(
      deliveryStreamName: Option[String] = None,
      deliveryStreamType: Option[String] = None,
      kinesisStreamSourceConfiguration: Option[KinesisStreamSourceConfiguration] = None,
      deliveryStreamEncryptionConfigurationInput: Option[DeliveryStreamEncryptionConfigurationInput] = None,
      s3DestinationConfiguration: Option[S3DestinationConfiguration] = None,
      extendedS3DestinationConfiguration: Option[ExtendedS3DestinationConfiguration] = None,
      redshiftDestinationConfiguration: Option[RedshiftDestinationConfiguration] = None,
      elasticsearchDestinationConfiguration: Option[ElasticsearchDestinationConfiguration] = None,
      splunkDestinationConfiguration: Option[SplunkDestinationConfiguration] = None,
      httpEndpointDestinationConfiguration: Option[HttpEndpointDestinationConfiguration] = None,
      tags: Option[List[Tag]] = None
    ): CreateDeliveryStreamInput =
      CreateDeliveryStreamInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(deliveryStreamType)(_.deliveryStreamType(_))
        .ifSome(kinesisStreamSourceConfiguration)(_.kinesisStreamSourceConfiguration(_))
        .ifSome(deliveryStreamEncryptionConfigurationInput)(_.deliveryStreamEncryptionConfigurationInput(_))
        .ifSome(s3DestinationConfiguration)(_.s3DestinationConfiguration(_))
        .ifSome(extendedS3DestinationConfiguration)(_.extendedS3DestinationConfiguration(_))
        .ifSome(redshiftDestinationConfiguration)(_.redshiftDestinationConfiguration(_))
        .ifSome(elasticsearchDestinationConfiguration)(_.elasticsearchDestinationConfiguration(_))
        .ifSome(splunkDestinationConfiguration)(_.splunkDestinationConfiguration(_))
        .ifSome(httpEndpointDestinationConfiguration)(_.httpEndpointDestinationConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeliveryStreamOutput(
      deliveryStreamARN: Option[String] = None
    ): CreateDeliveryStreamOutput =
      CreateDeliveryStreamOutput
        .builder
        .ifSome(deliveryStreamARN)(_.deliveryStreamARN(_))
        .build

    def dataFormatConversionConfiguration(
      schemaConfiguration: Option[SchemaConfiguration] = None,
      inputFormatConfiguration: Option[InputFormatConfiguration] = None,
      outputFormatConfiguration: Option[OutputFormatConfiguration] = None,
      enabled: Option[Boolean] = None
    ): DataFormatConversionConfiguration =
      DataFormatConversionConfiguration
        .builder
        .ifSome(schemaConfiguration)(_.schemaConfiguration(_))
        .ifSome(inputFormatConfiguration)(_.inputFormatConfiguration(_))
        .ifSome(outputFormatConfiguration)(_.outputFormatConfiguration(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def deleteDeliveryStreamInput(
      deliveryStreamName: Option[String] = None,
      allowForceDelete: Option[Boolean] = None
    ): DeleteDeliveryStreamInput =
      DeleteDeliveryStreamInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(allowForceDelete)(_.allowForceDelete(_))
        .build

    def deleteDeliveryStreamOutput(

    ): DeleteDeliveryStreamOutput =
      DeleteDeliveryStreamOutput
        .builder

        .build

    def deliveryStreamDescription(
      deliveryStreamName: Option[String] = None,
      deliveryStreamARN: Option[String] = None,
      deliveryStreamStatus: Option[String] = None,
      failureDescription: Option[FailureDescription] = None,
      deliveryStreamEncryptionConfiguration: Option[DeliveryStreamEncryptionConfiguration] = None,
      deliveryStreamType: Option[String] = None,
      versionId: Option[String] = None,
      createTimestamp: Option[Timestamp] = None,
      lastUpdateTimestamp: Option[Timestamp] = None,
      source: Option[SourceDescription] = None,
      destinations: Option[List[DestinationDescription]] = None,
      hasMoreDestinations: Option[Boolean] = None
    ): DeliveryStreamDescription =
      DeliveryStreamDescription
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(deliveryStreamARN)(_.deliveryStreamARN(_))
        .ifSome(deliveryStreamStatus)(_.deliveryStreamStatus(_))
        .ifSome(failureDescription)(_.failureDescription(_))
        .ifSome(deliveryStreamEncryptionConfiguration)(_.deliveryStreamEncryptionConfiguration(_))
        .ifSome(deliveryStreamType)(_.deliveryStreamType(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(createTimestamp)(_.createTimestamp(_))
        .ifSome(lastUpdateTimestamp)(_.lastUpdateTimestamp(_))
        .ifSome(source)(_.source(_))
        .ifSome(destinations)(_.destinations(_))
        .ifSome(hasMoreDestinations)(_.hasMoreDestinations(_))
        .build

    def deliveryStreamEncryptionConfiguration(
      keyARN: Option[String] = None,
      keyType: Option[String] = None,
      status: Option[String] = None,
      failureDescription: Option[FailureDescription] = None
    ): DeliveryStreamEncryptionConfiguration =
      DeliveryStreamEncryptionConfiguration
        .builder
        .ifSome(keyARN)(_.keyARN(_))
        .ifSome(keyType)(_.keyType(_))
        .ifSome(status)(_.status(_))
        .ifSome(failureDescription)(_.failureDescription(_))
        .build

    def deliveryStreamEncryptionConfigurationInput(
      keyARN: Option[String] = None,
      keyType: Option[String] = None
    ): DeliveryStreamEncryptionConfigurationInput =
      DeliveryStreamEncryptionConfigurationInput
        .builder
        .ifSome(keyARN)(_.keyARN(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def describeDeliveryStreamInput(
      deliveryStreamName: Option[String] = None,
      limit: Option[Int] = None,
      exclusiveStartDestinationId: Option[String] = None
    ): DescribeDeliveryStreamInput =
      DescribeDeliveryStreamInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(exclusiveStartDestinationId)(_.exclusiveStartDestinationId(_))
        .build

    def describeDeliveryStreamOutput(
      deliveryStreamDescription: Option[DeliveryStreamDescription] = None
    ): DescribeDeliveryStreamOutput =
      DescribeDeliveryStreamOutput
        .builder
        .ifSome(deliveryStreamDescription)(_.deliveryStreamDescription(_))
        .build

    def deserializer(
      openXJsonSerDe: Option[OpenXJsonSerDe] = None,
      hiveJsonSerDe: Option[HiveJsonSerDe] = None
    ): Deserializer =
      Deserializer
        .builder
        .ifSome(openXJsonSerDe)(_.openXJsonSerDe(_))
        .ifSome(hiveJsonSerDe)(_.hiveJsonSerDe(_))
        .build

    def destinationDescription(
      destinationId: Option[String] = None,
      s3DestinationDescription: Option[S3DestinationDescription] = None,
      extendedS3DestinationDescription: Option[ExtendedS3DestinationDescription] = None,
      redshiftDestinationDescription: Option[RedshiftDestinationDescription] = None,
      elasticsearchDestinationDescription: Option[ElasticsearchDestinationDescription] = None,
      splunkDestinationDescription: Option[SplunkDestinationDescription] = None,
      httpEndpointDestinationDescription: Option[HttpEndpointDestinationDescription] = None
    ): DestinationDescription =
      DestinationDescription
        .builder
        .ifSome(destinationId)(_.destinationId(_))
        .ifSome(s3DestinationDescription)(_.s3DestinationDescription(_))
        .ifSome(extendedS3DestinationDescription)(_.extendedS3DestinationDescription(_))
        .ifSome(redshiftDestinationDescription)(_.redshiftDestinationDescription(_))
        .ifSome(elasticsearchDestinationDescription)(_.elasticsearchDestinationDescription(_))
        .ifSome(splunkDestinationDescription)(_.splunkDestinationDescription(_))
        .ifSome(httpEndpointDestinationDescription)(_.httpEndpointDestinationDescription(_))
        .build

    def elasticsearchBufferingHints(
      intervalInSeconds: Option[Int] = None,
      sizeInMBs: Option[Int] = None
    ): ElasticsearchBufferingHints =
      ElasticsearchBufferingHints
        .builder
        .ifSome(intervalInSeconds)(_.intervalInSeconds(_))
        .ifSome(sizeInMBs)(_.sizeInMBs(_))
        .build

    def elasticsearchDestinationConfiguration(
      roleARN: Option[String] = None,
      domainARN: Option[String] = None,
      clusterEndpoint: Option[String] = None,
      indexName: Option[String] = None,
      typeName: Option[String] = None,
      indexRotationPeriod: Option[String] = None,
      bufferingHints: Option[ElasticsearchBufferingHints] = None,
      retryOptions: Option[ElasticsearchRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3Configuration: Option[S3DestinationConfiguration] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      vpcConfiguration: Option[VpcConfiguration] = None
    ): ElasticsearchDestinationConfiguration =
      ElasticsearchDestinationConfiguration
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(domainARN)(_.domainARN(_))
        .ifSome(clusterEndpoint)(_.clusterEndpoint(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(indexRotationPeriod)(_.indexRotationPeriod(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3Configuration)(_.s3Configuration(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def elasticsearchDestinationDescription(
      roleARN: Option[String] = None,
      domainARN: Option[String] = None,
      clusterEndpoint: Option[String] = None,
      indexName: Option[String] = None,
      typeName: Option[String] = None,
      indexRotationPeriod: Option[String] = None,
      bufferingHints: Option[ElasticsearchBufferingHints] = None,
      retryOptions: Option[ElasticsearchRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3DestinationDescription: Option[S3DestinationDescription] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      vpcConfigurationDescription: Option[VpcConfigurationDescription] = None
    ): ElasticsearchDestinationDescription =
      ElasticsearchDestinationDescription
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(domainARN)(_.domainARN(_))
        .ifSome(clusterEndpoint)(_.clusterEndpoint(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(indexRotationPeriod)(_.indexRotationPeriod(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3DestinationDescription)(_.s3DestinationDescription(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(vpcConfigurationDescription)(_.vpcConfigurationDescription(_))
        .build

    def elasticsearchDestinationUpdate(
      roleARN: Option[String] = None,
      domainARN: Option[String] = None,
      clusterEndpoint: Option[String] = None,
      indexName: Option[String] = None,
      typeName: Option[String] = None,
      indexRotationPeriod: Option[String] = None,
      bufferingHints: Option[ElasticsearchBufferingHints] = None,
      retryOptions: Option[ElasticsearchRetryOptions] = None,
      s3Update: Option[S3DestinationUpdate] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): ElasticsearchDestinationUpdate =
      ElasticsearchDestinationUpdate
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(domainARN)(_.domainARN(_))
        .ifSome(clusterEndpoint)(_.clusterEndpoint(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(indexRotationPeriod)(_.indexRotationPeriod(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3Update)(_.s3Update(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def elasticsearchRetryOptions(
      durationInSeconds: Option[Int] = None
    ): ElasticsearchRetryOptions =
      ElasticsearchRetryOptions
        .builder
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .build

    def encryptionConfiguration(
      noEncryptionConfig: Option[String] = None,
      kMSEncryptionConfig: Option[KMSEncryptionConfig] = None
    ): EncryptionConfiguration =
      EncryptionConfiguration
        .builder
        .ifSome(noEncryptionConfig)(_.noEncryptionConfig(_))
        .ifSome(kMSEncryptionConfig)(_.kMSEncryptionConfig(_))
        .build

    def extendedS3DestinationConfiguration(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      prefix: Option[String] = None,
      errorOutputPrefix: Option[String] = None,
      bufferingHints: Option[BufferingHints] = None,
      compressionFormat: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      s3BackupMode: Option[String] = None,
      s3BackupConfiguration: Option[S3DestinationConfiguration] = None,
      dataFormatConversionConfiguration: Option[DataFormatConversionConfiguration] = None
    ): ExtendedS3DestinationConfiguration =
      ExtendedS3DestinationConfiguration
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(errorOutputPrefix)(_.errorOutputPrefix(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3BackupConfiguration)(_.s3BackupConfiguration(_))
        .ifSome(dataFormatConversionConfiguration)(_.dataFormatConversionConfiguration(_))
        .build

    def extendedS3DestinationDescription(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      prefix: Option[String] = None,
      errorOutputPrefix: Option[String] = None,
      bufferingHints: Option[BufferingHints] = None,
      compressionFormat: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      s3BackupMode: Option[String] = None,
      s3BackupDescription: Option[S3DestinationDescription] = None,
      dataFormatConversionConfiguration: Option[DataFormatConversionConfiguration] = None
    ): ExtendedS3DestinationDescription =
      ExtendedS3DestinationDescription
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(errorOutputPrefix)(_.errorOutputPrefix(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3BackupDescription)(_.s3BackupDescription(_))
        .ifSome(dataFormatConversionConfiguration)(_.dataFormatConversionConfiguration(_))
        .build

    def extendedS3DestinationUpdate(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      prefix: Option[String] = None,
      errorOutputPrefix: Option[String] = None,
      bufferingHints: Option[BufferingHints] = None,
      compressionFormat: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      s3BackupMode: Option[String] = None,
      s3BackupUpdate: Option[S3DestinationUpdate] = None,
      dataFormatConversionConfiguration: Option[DataFormatConversionConfiguration] = None
    ): ExtendedS3DestinationUpdate =
      ExtendedS3DestinationUpdate
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(errorOutputPrefix)(_.errorOutputPrefix(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3BackupUpdate)(_.s3BackupUpdate(_))
        .ifSome(dataFormatConversionConfiguration)(_.dataFormatConversionConfiguration(_))
        .build

    def failureDescription(
      `type`: Option[String] = None,
      details: Option[String] = None
    ): FailureDescription =
      FailureDescription
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(details)(_.details(_))
        .build

    def hiveJsonSerDe(
      timestampFormats: Option[List[NonEmptyString]] = None
    ): HiveJsonSerDe =
      HiveJsonSerDe
        .builder
        .ifSome(timestampFormats)(_.timestampFormats(_))
        .build

    def httpEndpointBufferingHints(
      sizeInMBs: Option[Int] = None,
      intervalInSeconds: Option[Int] = None
    ): HttpEndpointBufferingHints =
      HttpEndpointBufferingHints
        .builder
        .ifSome(sizeInMBs)(_.sizeInMBs(_))
        .ifSome(intervalInSeconds)(_.intervalInSeconds(_))
        .build

    def httpEndpointCommonAttribute(
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None
    ): HttpEndpointCommonAttribute =
      HttpEndpointCommonAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .build

    def httpEndpointConfiguration(
      url: Option[String] = None,
      name: Option[String] = None,
      accessKey: Option[String] = None
    ): HttpEndpointConfiguration =
      HttpEndpointConfiguration
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(name)(_.name(_))
        .ifSome(accessKey)(_.accessKey(_))
        .build

    def httpEndpointDescription(
      url: Option[String] = None,
      name: Option[String] = None
    ): HttpEndpointDescription =
      HttpEndpointDescription
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(name)(_.name(_))
        .build

    def httpEndpointDestinationConfiguration(
      endpointConfiguration: Option[HttpEndpointConfiguration] = None,
      bufferingHints: Option[HttpEndpointBufferingHints] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      requestConfiguration: Option[HttpEndpointRequestConfiguration] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      roleARN: Option[String] = None,
      retryOptions: Option[HttpEndpointRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3Configuration: Option[S3DestinationConfiguration] = None
    ): HttpEndpointDestinationConfiguration =
      HttpEndpointDestinationConfiguration
        .builder
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(requestConfiguration)(_.requestConfiguration(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3Configuration)(_.s3Configuration(_))
        .build

    def httpEndpointDestinationDescription(
      endpointConfiguration: Option[HttpEndpointDescription] = None,
      bufferingHints: Option[HttpEndpointBufferingHints] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      requestConfiguration: Option[HttpEndpointRequestConfiguration] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      roleARN: Option[String] = None,
      retryOptions: Option[HttpEndpointRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3DestinationDescription: Option[S3DestinationDescription] = None
    ): HttpEndpointDestinationDescription =
      HttpEndpointDestinationDescription
        .builder
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(requestConfiguration)(_.requestConfiguration(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3DestinationDescription)(_.s3DestinationDescription(_))
        .build

    def httpEndpointDestinationUpdate(
      endpointConfiguration: Option[HttpEndpointConfiguration] = None,
      bufferingHints: Option[HttpEndpointBufferingHints] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None,
      requestConfiguration: Option[HttpEndpointRequestConfiguration] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      roleARN: Option[String] = None,
      retryOptions: Option[HttpEndpointRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3Update: Option[S3DestinationUpdate] = None
    ): HttpEndpointDestinationUpdate =
      HttpEndpointDestinationUpdate
        .builder
        .ifSome(endpointConfiguration)(_.endpointConfiguration(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .ifSome(requestConfiguration)(_.requestConfiguration(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3Update)(_.s3Update(_))
        .build

    def httpEndpointRequestConfiguration(
      contentEncoding: Option[String] = None,
      commonAttributes: Option[List[HttpEndpointCommonAttribute]] = None
    ): HttpEndpointRequestConfiguration =
      HttpEndpointRequestConfiguration
        .builder
        .ifSome(contentEncoding)(_.contentEncoding(_))
        .ifSome(commonAttributes)(_.commonAttributes(_))
        .build

    def httpEndpointRetryOptions(
      durationInSeconds: Option[Int] = None
    ): HttpEndpointRetryOptions =
      HttpEndpointRetryOptions
        .builder
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .build

    def inputFormatConfiguration(
      deserializer: Option[Deserializer] = None
    ): InputFormatConfiguration =
      InputFormatConfiguration
        .builder
        .ifSome(deserializer)(_.deserializer(_))
        .build

    def invalidArgumentException(
      message: Option[String] = None
    ): InvalidArgumentException =
      InvalidArgumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidKMSResourceException(
      code: Option[String] = None,
      message: Option[String] = None
    ): InvalidKMSResourceException =
      InvalidKMSResourceException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def kMSEncryptionConfig(
      aWSKMSKeyARN: Option[String] = None
    ): KMSEncryptionConfig =
      KMSEncryptionConfig
        .builder
        .ifSome(aWSKMSKeyARN)(_.aWSKMSKeyARN(_))
        .build

    def kinesisStreamSourceConfiguration(
      kinesisStreamARN: Option[String] = None,
      roleARN: Option[String] = None
    ): KinesisStreamSourceConfiguration =
      KinesisStreamSourceConfiguration
        .builder
        .ifSome(kinesisStreamARN)(_.kinesisStreamARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .build

    def kinesisStreamSourceDescription(
      kinesisStreamARN: Option[String] = None,
      roleARN: Option[String] = None,
      deliveryStartTimestamp: Option[DeliveryStartTimestamp] = None
    ): KinesisStreamSourceDescription =
      KinesisStreamSourceDescription
        .builder
        .ifSome(kinesisStreamARN)(_.kinesisStreamARN(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(deliveryStartTimestamp)(_.deliveryStartTimestamp(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDeliveryStreamsInput(
      limit: Option[Int] = None,
      deliveryStreamType: Option[String] = None,
      exclusiveStartDeliveryStreamName: Option[String] = None
    ): ListDeliveryStreamsInput =
      ListDeliveryStreamsInput
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(deliveryStreamType)(_.deliveryStreamType(_))
        .ifSome(exclusiveStartDeliveryStreamName)(_.exclusiveStartDeliveryStreamName(_))
        .build

    def listDeliveryStreamsOutput(
      deliveryStreamNames: Option[List[DeliveryStreamName]] = None,
      hasMoreDeliveryStreams: Option[Boolean] = None
    ): ListDeliveryStreamsOutput =
      ListDeliveryStreamsOutput
        .builder
        .ifSome(deliveryStreamNames)(_.deliveryStreamNames(_))
        .ifSome(hasMoreDeliveryStreams)(_.hasMoreDeliveryStreams(_))
        .build

    def listTagsForDeliveryStreamInput(
      deliveryStreamName: Option[String] = None,
      exclusiveStartTagKey: Option[String] = None,
      limit: Option[Int] = None
    ): ListTagsForDeliveryStreamInput =
      ListTagsForDeliveryStreamInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(exclusiveStartTagKey)(_.exclusiveStartTagKey(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTagsForDeliveryStreamOutput(
      tags: Option[List[Tag]] = None,
      hasMoreTags: Option[Boolean] = None
    ): ListTagsForDeliveryStreamOutput =
      ListTagsForDeliveryStreamOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(hasMoreTags)(_.hasMoreTags(_))
        .build

    def openXJsonSerDe(
      convertDotsInJsonKeysToUnderscores: Option[Boolean] = None,
      caseInsensitive: Option[Boolean] = None,
      columnToJsonKeyMappings: Option[ColumnToJsonKeyMappings] = None
    ): OpenXJsonSerDe =
      OpenXJsonSerDe
        .builder
        .ifSome(convertDotsInJsonKeysToUnderscores)(_.convertDotsInJsonKeysToUnderscores(_))
        .ifSome(caseInsensitive)(_.caseInsensitive(_))
        .ifSome(columnToJsonKeyMappings)(_.columnToJsonKeyMappings(_))
        .build

    def orcSerDe(
      stripeSizeBytes: Option[Int] = None,
      blockSizeBytes: Option[Int] = None,
      rowIndexStride: Option[Int] = None,
      enablePadding: Option[Boolean] = None,
      paddingTolerance: Option[Proportion] = None,
      compression: Option[String] = None,
      bloomFilterColumns: Option[List[NonEmptyStringWithoutWhitespace]] = None,
      bloomFilterFalsePositiveProbability: Option[Proportion] = None,
      dictionaryKeyThreshold: Option[Proportion] = None,
      formatVersion: Option[String] = None
    ): OrcSerDe =
      OrcSerDe
        .builder
        .ifSome(stripeSizeBytes)(_.stripeSizeBytes(_))
        .ifSome(blockSizeBytes)(_.blockSizeBytes(_))
        .ifSome(rowIndexStride)(_.rowIndexStride(_))
        .ifSome(enablePadding)(_.enablePadding(_))
        .ifSome(paddingTolerance)(_.paddingTolerance(_))
        .ifSome(compression)(_.compression(_))
        .ifSome(bloomFilterColumns)(_.bloomFilterColumns(_))
        .ifSome(bloomFilterFalsePositiveProbability)(_.bloomFilterFalsePositiveProbability(_))
        .ifSome(dictionaryKeyThreshold)(_.dictionaryKeyThreshold(_))
        .ifSome(formatVersion)(_.formatVersion(_))
        .build

    def outputFormatConfiguration(
      serializer: Option[Serializer] = None
    ): OutputFormatConfiguration =
      OutputFormatConfiguration
        .builder
        .ifSome(serializer)(_.serializer(_))
        .build

    def parquetSerDe(
      blockSizeBytes: Option[Int] = None,
      pageSizeBytes: Option[Int] = None,
      compression: Option[String] = None,
      enableDictionaryCompression: Option[Boolean] = None,
      maxPaddingBytes: Option[Int] = None,
      writerVersion: Option[String] = None
    ): ParquetSerDe =
      ParquetSerDe
        .builder
        .ifSome(blockSizeBytes)(_.blockSizeBytes(_))
        .ifSome(pageSizeBytes)(_.pageSizeBytes(_))
        .ifSome(compression)(_.compression(_))
        .ifSome(enableDictionaryCompression)(_.enableDictionaryCompression(_))
        .ifSome(maxPaddingBytes)(_.maxPaddingBytes(_))
        .ifSome(writerVersion)(_.writerVersion(_))
        .build

    def processingConfiguration(
      enabled: Option[Boolean] = None,
      processors: Option[List[Processor]] = None
    ): ProcessingConfiguration =
      ProcessingConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(processors)(_.processors(_))
        .build

    def processor(
      `type`: Option[String] = None,
      parameters: Option[List[ProcessorParameter]] = None
    ): Processor =
      Processor
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def processorParameter(
      parameterName: Option[String] = None,
      parameterValue: Option[String] = None
    ): ProcessorParameter =
      ProcessorParameter
        .builder
        .ifSome(parameterName)(_.parameterName(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .build

    def putRecordBatchInput(
      deliveryStreamName: Option[String] = None,
      records: Option[List[Record]] = None
    ): PutRecordBatchInput =
      PutRecordBatchInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(records)(_.records(_))
        .build

    def putRecordBatchOutput(
      failedPutCount: Option[Int] = None,
      encrypted: Option[Boolean] = None,
      requestResponses: Option[List[PutRecordBatchResponseEntry]] = None
    ): PutRecordBatchOutput =
      PutRecordBatchOutput
        .builder
        .ifSome(failedPutCount)(_.failedPutCount(_))
        .ifSome(encrypted)(_.encrypted(_))
        .ifSome(requestResponses)(_.requestResponses(_))
        .build

    def putRecordBatchResponseEntry(
      recordId: Option[String] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): PutRecordBatchResponseEntry =
      PutRecordBatchResponseEntry
        .builder
        .ifSome(recordId)(_.recordId(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def putRecordInput(
      deliveryStreamName: Option[String] = None,
      record: Option[Record] = None
    ): PutRecordInput =
      PutRecordInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(record)(_.record(_))
        .build

    def putRecordOutput(
      recordId: Option[String] = None,
      encrypted: Option[Boolean] = None
    ): PutRecordOutput =
      PutRecordOutput
        .builder
        .ifSome(recordId)(_.recordId(_))
        .ifSome(encrypted)(_.encrypted(_))
        .build

    def record(
      data: Option[Data] = None
    ): Record =
      Record
        .builder
        .ifSome(data)(_.data(_))
        .build

    def redshiftDestinationConfiguration(
      roleARN: Option[String] = None,
      clusterJDBCURL: Option[String] = None,
      copyCommand: Option[CopyCommand] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      retryOptions: Option[RedshiftRetryOptions] = None,
      s3Configuration: Option[S3DestinationConfiguration] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      s3BackupMode: Option[String] = None,
      s3BackupConfiguration: Option[S3DestinationConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): RedshiftDestinationConfiguration =
      RedshiftDestinationConfiguration
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(clusterJDBCURL)(_.clusterJDBCURL(_))
        .ifSome(copyCommand)(_.copyCommand(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3Configuration)(_.s3Configuration(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3BackupConfiguration)(_.s3BackupConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def redshiftDestinationDescription(
      roleARN: Option[String] = None,
      clusterJDBCURL: Option[String] = None,
      copyCommand: Option[CopyCommand] = None,
      username: Option[String] = None,
      retryOptions: Option[RedshiftRetryOptions] = None,
      s3DestinationDescription: Option[S3DestinationDescription] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      s3BackupMode: Option[String] = None,
      s3BackupDescription: Option[S3DestinationDescription] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): RedshiftDestinationDescription =
      RedshiftDestinationDescription
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(clusterJDBCURL)(_.clusterJDBCURL(_))
        .ifSome(copyCommand)(_.copyCommand(_))
        .ifSome(username)(_.username(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3DestinationDescription)(_.s3DestinationDescription(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3BackupDescription)(_.s3BackupDescription(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def redshiftDestinationUpdate(
      roleARN: Option[String] = None,
      clusterJDBCURL: Option[String] = None,
      copyCommand: Option[CopyCommand] = None,
      username: Option[String] = None,
      password: Option[String] = None,
      retryOptions: Option[RedshiftRetryOptions] = None,
      s3Update: Option[S3DestinationUpdate] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      s3BackupMode: Option[String] = None,
      s3BackupUpdate: Option[S3DestinationUpdate] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): RedshiftDestinationUpdate =
      RedshiftDestinationUpdate
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(clusterJDBCURL)(_.clusterJDBCURL(_))
        .ifSome(copyCommand)(_.copyCommand(_))
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3Update)(_.s3Update(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3BackupUpdate)(_.s3BackupUpdate(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def redshiftRetryOptions(
      durationInSeconds: Option[Int] = None
    ): RedshiftRetryOptions =
      RedshiftRetryOptions
        .builder
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
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

    def s3DestinationConfiguration(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      prefix: Option[String] = None,
      errorOutputPrefix: Option[String] = None,
      bufferingHints: Option[BufferingHints] = None,
      compressionFormat: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): S3DestinationConfiguration =
      S3DestinationConfiguration
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(errorOutputPrefix)(_.errorOutputPrefix(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def s3DestinationDescription(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      prefix: Option[String] = None,
      errorOutputPrefix: Option[String] = None,
      bufferingHints: Option[BufferingHints] = None,
      compressionFormat: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): S3DestinationDescription =
      S3DestinationDescription
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(errorOutputPrefix)(_.errorOutputPrefix(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def s3DestinationUpdate(
      roleARN: Option[String] = None,
      bucketARN: Option[String] = None,
      prefix: Option[String] = None,
      errorOutputPrefix: Option[String] = None,
      bufferingHints: Option[BufferingHints] = None,
      compressionFormat: Option[String] = None,
      encryptionConfiguration: Option[EncryptionConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): S3DestinationUpdate =
      S3DestinationUpdate
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(bucketARN)(_.bucketARN(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(errorOutputPrefix)(_.errorOutputPrefix(_))
        .ifSome(bufferingHints)(_.bufferingHints(_))
        .ifSome(compressionFormat)(_.compressionFormat(_))
        .ifSome(encryptionConfiguration)(_.encryptionConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def schemaConfiguration(
      roleARN: Option[String] = None,
      catalogId: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      region: Option[String] = None,
      versionId: Option[String] = None
    ): SchemaConfiguration =
      SchemaConfiguration
        .builder
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(catalogId)(_.catalogId(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(region)(_.region(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def serializer(
      parquetSerDe: Option[ParquetSerDe] = None,
      orcSerDe: Option[OrcSerDe] = None
    ): Serializer =
      Serializer
        .builder
        .ifSome(parquetSerDe)(_.parquetSerDe(_))
        .ifSome(orcSerDe)(_.orcSerDe(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sourceDescription(
      kinesisStreamSourceDescription: Option[KinesisStreamSourceDescription] = None
    ): SourceDescription =
      SourceDescription
        .builder
        .ifSome(kinesisStreamSourceDescription)(_.kinesisStreamSourceDescription(_))
        .build

    def splunkDestinationConfiguration(
      hECEndpoint: Option[String] = None,
      hECEndpointType: Option[String] = None,
      hECToken: Option[String] = None,
      hECAcknowledgmentTimeoutInSeconds: Option[Int] = None,
      retryOptions: Option[SplunkRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3Configuration: Option[S3DestinationConfiguration] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): SplunkDestinationConfiguration =
      SplunkDestinationConfiguration
        .builder
        .ifSome(hECEndpoint)(_.hECEndpoint(_))
        .ifSome(hECEndpointType)(_.hECEndpointType(_))
        .ifSome(hECToken)(_.hECToken(_))
        .ifSome(hECAcknowledgmentTimeoutInSeconds)(_.hECAcknowledgmentTimeoutInSeconds(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3Configuration)(_.s3Configuration(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def splunkDestinationDescription(
      hECEndpoint: Option[String] = None,
      hECEndpointType: Option[String] = None,
      hECToken: Option[String] = None,
      hECAcknowledgmentTimeoutInSeconds: Option[Int] = None,
      retryOptions: Option[SplunkRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3DestinationDescription: Option[S3DestinationDescription] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): SplunkDestinationDescription =
      SplunkDestinationDescription
        .builder
        .ifSome(hECEndpoint)(_.hECEndpoint(_))
        .ifSome(hECEndpointType)(_.hECEndpointType(_))
        .ifSome(hECToken)(_.hECToken(_))
        .ifSome(hECAcknowledgmentTimeoutInSeconds)(_.hECAcknowledgmentTimeoutInSeconds(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3DestinationDescription)(_.s3DestinationDescription(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def splunkDestinationUpdate(
      hECEndpoint: Option[String] = None,
      hECEndpointType: Option[String] = None,
      hECToken: Option[String] = None,
      hECAcknowledgmentTimeoutInSeconds: Option[Int] = None,
      retryOptions: Option[SplunkRetryOptions] = None,
      s3BackupMode: Option[String] = None,
      s3Update: Option[S3DestinationUpdate] = None,
      processingConfiguration: Option[ProcessingConfiguration] = None,
      cloudWatchLoggingOptions: Option[CloudWatchLoggingOptions] = None
    ): SplunkDestinationUpdate =
      SplunkDestinationUpdate
        .builder
        .ifSome(hECEndpoint)(_.hECEndpoint(_))
        .ifSome(hECEndpointType)(_.hECEndpointType(_))
        .ifSome(hECToken)(_.hECToken(_))
        .ifSome(hECAcknowledgmentTimeoutInSeconds)(_.hECAcknowledgmentTimeoutInSeconds(_))
        .ifSome(retryOptions)(_.retryOptions(_))
        .ifSome(s3BackupMode)(_.s3BackupMode(_))
        .ifSome(s3Update)(_.s3Update(_))
        .ifSome(processingConfiguration)(_.processingConfiguration(_))
        .ifSome(cloudWatchLoggingOptions)(_.cloudWatchLoggingOptions(_))
        .build

    def splunkRetryOptions(
      durationInSeconds: Option[Int] = None
    ): SplunkRetryOptions =
      SplunkRetryOptions
        .builder
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .build

    def startDeliveryStreamEncryptionInput(
      deliveryStreamName: Option[String] = None,
      deliveryStreamEncryptionConfigurationInput: Option[DeliveryStreamEncryptionConfigurationInput] = None
    ): StartDeliveryStreamEncryptionInput =
      StartDeliveryStreamEncryptionInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(deliveryStreamEncryptionConfigurationInput)(_.deliveryStreamEncryptionConfigurationInput(_))
        .build

    def startDeliveryStreamEncryptionOutput(

    ): StartDeliveryStreamEncryptionOutput =
      StartDeliveryStreamEncryptionOutput
        .builder

        .build

    def stopDeliveryStreamEncryptionInput(
      deliveryStreamName: Option[String] = None
    ): StopDeliveryStreamEncryptionInput =
      StopDeliveryStreamEncryptionInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .build

    def stopDeliveryStreamEncryptionOutput(

    ): StopDeliveryStreamEncryptionOutput =
      StopDeliveryStreamEncryptionOutput
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

    def tagDeliveryStreamInput(
      deliveryStreamName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagDeliveryStreamInput =
      TagDeliveryStreamInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagDeliveryStreamOutput(

    ): TagDeliveryStreamOutput =
      TagDeliveryStreamOutput
        .builder

        .build

    def untagDeliveryStreamInput(
      deliveryStreamName: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagDeliveryStreamInput =
      UntagDeliveryStreamInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagDeliveryStreamOutput(

    ): UntagDeliveryStreamOutput =
      UntagDeliveryStreamOutput
        .builder

        .build

    def updateDestinationInput(
      deliveryStreamName: Option[String] = None,
      currentDeliveryStreamVersionId: Option[String] = None,
      destinationId: Option[String] = None,
      s3DestinationUpdate: Option[S3DestinationUpdate] = None,
      extendedS3DestinationUpdate: Option[ExtendedS3DestinationUpdate] = None,
      redshiftDestinationUpdate: Option[RedshiftDestinationUpdate] = None,
      elasticsearchDestinationUpdate: Option[ElasticsearchDestinationUpdate] = None,
      splunkDestinationUpdate: Option[SplunkDestinationUpdate] = None,
      httpEndpointDestinationUpdate: Option[HttpEndpointDestinationUpdate] = None
    ): UpdateDestinationInput =
      UpdateDestinationInput
        .builder
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(currentDeliveryStreamVersionId)(_.currentDeliveryStreamVersionId(_))
        .ifSome(destinationId)(_.destinationId(_))
        .ifSome(s3DestinationUpdate)(_.s3DestinationUpdate(_))
        .ifSome(extendedS3DestinationUpdate)(_.extendedS3DestinationUpdate(_))
        .ifSome(redshiftDestinationUpdate)(_.redshiftDestinationUpdate(_))
        .ifSome(elasticsearchDestinationUpdate)(_.elasticsearchDestinationUpdate(_))
        .ifSome(splunkDestinationUpdate)(_.splunkDestinationUpdate(_))
        .ifSome(httpEndpointDestinationUpdate)(_.httpEndpointDestinationUpdate(_))
        .build

    def updateDestinationOutput(

    ): UpdateDestinationOutput =
      UpdateDestinationOutput
        .builder

        .build

    def vpcConfiguration(
      subnetIds: Option[List[NonEmptyStringWithoutWhitespace]] = None,
      roleARN: Option[String] = None,
      securityGroupIds: Option[List[NonEmptyStringWithoutWhitespace]] = None
    ): VpcConfiguration =
      VpcConfiguration
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def vpcConfigurationDescription(
      subnetIds: Option[List[NonEmptyStringWithoutWhitespace]] = None,
      roleARN: Option[String] = None,
      securityGroupIds: Option[List[NonEmptyStringWithoutWhitespace]] = None,
      vpcId: Option[String] = None
    ): VpcConfigurationDescription =
      VpcConfigurationDescription
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(vpcId)(_.vpcId(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
