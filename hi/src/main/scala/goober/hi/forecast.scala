package goober.hi

import goober.free.forecast.ForecastIO
import software.amazon.awssdk.services.forecast.model._


object forecast {
  import goober.free.{forecast ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def categoricalParameterRange(
      name: Option[String] = None,
      values: Option[List[Value]] = None
    ): CategoricalParameterRange =
      CategoricalParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def continuousParameterRange(
      name: Option[String] = None,
      maxValue: Option[Double] = None,
      minValue: Option[Double] = None,
      scalingType: Option[String] = None
    ): ContinuousParameterRange =
      ContinuousParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(scalingType)(_.scalingType(_))
        .build

    def createDatasetGroupRequest(
      datasetGroupName: Option[String] = None,
      domain: Option[String] = None,
      datasetArns: Option[List[Arn]] = None,
      tags: Option[List[Tag]] = None
    ): CreateDatasetGroupRequest =
      CreateDatasetGroupRequest
        .builder
        .ifSome(datasetGroupName)(_.datasetGroupName(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(datasetArns)(_.datasetArns(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDatasetGroupResponse(
      datasetGroupArn: Option[String] = None
    ): CreateDatasetGroupResponse =
      CreateDatasetGroupResponse
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def createDatasetImportJobRequest(
      datasetImportJobName: Option[String] = None,
      datasetArn: Option[String] = None,
      dataSource: Option[DataSource] = None,
      timestampFormat: Option[String] = None,
      timeZone: Option[String] = None,
      useGeolocationForTimeZone: Option[Boolean] = None,
      geolocationFormat: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDatasetImportJobRequest =
      CreateDatasetImportJobRequest
        .builder
        .ifSome(datasetImportJobName)(_.datasetImportJobName(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(timestampFormat)(_.timestampFormat(_))
        .ifSome(timeZone)(_.timeZone(_))
        .ifSome(useGeolocationForTimeZone)(_.useGeolocationForTimeZone(_))
        .ifSome(geolocationFormat)(_.geolocationFormat(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDatasetImportJobResponse(
      datasetImportJobArn: Option[String] = None
    ): CreateDatasetImportJobResponse =
      CreateDatasetImportJobResponse
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .build

    def createDatasetRequest(
      datasetName: Option[String] = None,
      domain: Option[String] = None,
      datasetType: Option[String] = None,
      dataFrequency: Option[String] = None,
      schema: Option[Schema] = None,
      encryptionConfig: Option[EncryptionConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateDatasetRequest =
      CreateDatasetRequest
        .builder
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(dataFrequency)(_.dataFrequency(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDatasetResponse(
      datasetArn: Option[String] = None
    ): CreateDatasetResponse =
      CreateDatasetResponse
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .build

    def createForecastExportJobRequest(
      forecastExportJobName: Option[String] = None,
      forecastArn: Option[String] = None,
      destination: Option[DataDestination] = None,
      tags: Option[List[Tag]] = None
    ): CreateForecastExportJobRequest =
      CreateForecastExportJobRequest
        .builder
        .ifSome(forecastExportJobName)(_.forecastExportJobName(_))
        .ifSome(forecastArn)(_.forecastArn(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createForecastExportJobResponse(
      forecastExportJobArn: Option[String] = None
    ): CreateForecastExportJobResponse =
      CreateForecastExportJobResponse
        .builder
        .ifSome(forecastExportJobArn)(_.forecastExportJobArn(_))
        .build

    def createForecastRequest(
      forecastName: Option[String] = None,
      predictorArn: Option[String] = None,
      forecastTypes: Option[List[ForecastType]] = None,
      tags: Option[List[Tag]] = None
    ): CreateForecastRequest =
      CreateForecastRequest
        .builder
        .ifSome(forecastName)(_.forecastName(_))
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(forecastTypes)(_.forecastTypes(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createForecastResponse(
      forecastArn: Option[String] = None
    ): CreateForecastResponse =
      CreateForecastResponse
        .builder
        .ifSome(forecastArn)(_.forecastArn(_))
        .build

    def createPredictorBacktestExportJobRequest(
      predictorBacktestExportJobName: Option[String] = None,
      predictorArn: Option[String] = None,
      destination: Option[DataDestination] = None,
      tags: Option[List[Tag]] = None
    ): CreatePredictorBacktestExportJobRequest =
      CreatePredictorBacktestExportJobRequest
        .builder
        .ifSome(predictorBacktestExportJobName)(_.predictorBacktestExportJobName(_))
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPredictorBacktestExportJobResponse(
      predictorBacktestExportJobArn: Option[String] = None
    ): CreatePredictorBacktestExportJobResponse =
      CreatePredictorBacktestExportJobResponse
        .builder
        .ifSome(predictorBacktestExportJobArn)(_.predictorBacktestExportJobArn(_))
        .build

    def createPredictorRequest(
      predictorName: Option[String] = None,
      algorithmArn: Option[String] = None,
      forecastHorizon: Option[Int] = None,
      forecastTypes: Option[List[ForecastType]] = None,
      performAutoML: Option[Boolean] = None,
      autoMLOverrideStrategy: Option[String] = None,
      performHPO: Option[Boolean] = None,
      trainingParameters: Option[TrainingParameters] = None,
      evaluationParameters: Option[EvaluationParameters] = None,
      hPOConfig: Option[HyperParameterTuningJobConfig] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      featurizationConfig: Option[FeaturizationConfig] = None,
      encryptionConfig: Option[EncryptionConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreatePredictorRequest =
      CreatePredictorRequest
        .builder
        .ifSome(predictorName)(_.predictorName(_))
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(forecastHorizon)(_.forecastHorizon(_))
        .ifSome(forecastTypes)(_.forecastTypes(_))
        .ifSome(performAutoML)(_.performAutoML(_))
        .ifSome(autoMLOverrideStrategy)(_.autoMLOverrideStrategy(_))
        .ifSome(performHPO)(_.performHPO(_))
        .ifSome(trainingParameters)(_.trainingParameters(_))
        .ifSome(evaluationParameters)(_.evaluationParameters(_))
        .ifSome(hPOConfig)(_.hPOConfig(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(featurizationConfig)(_.featurizationConfig(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPredictorResponse(
      predictorArn: Option[String] = None
    ): CreatePredictorResponse =
      CreatePredictorResponse
        .builder
        .ifSome(predictorArn)(_.predictorArn(_))
        .build

    def dataDestination(
      s3Config: Option[S3Config] = None
    ): DataDestination =
      DataDestination
        .builder
        .ifSome(s3Config)(_.s3Config(_))
        .build

    def dataSource(
      s3Config: Option[S3Config] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(s3Config)(_.s3Config(_))
        .build

    def datasetGroupSummary(
      datasetGroupArn: Option[String] = None,
      datasetGroupName: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DatasetGroupSummary =
      DatasetGroupSummary
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(datasetGroupName)(_.datasetGroupName(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def datasetImportJobSummary(
      datasetImportJobArn: Option[String] = None,
      datasetImportJobName: Option[String] = None,
      dataSource: Option[DataSource] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DatasetImportJobSummary =
      DatasetImportJobSummary
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .ifSome(datasetImportJobName)(_.datasetImportJobName(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def datasetSummary(
      datasetArn: Option[String] = None,
      datasetName: Option[String] = None,
      datasetType: Option[String] = None,
      domain: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DatasetSummary =
      DatasetSummary
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def deleteDatasetGroupRequest(
      datasetGroupArn: Option[String] = None
    ): DeleteDatasetGroupRequest =
      DeleteDatasetGroupRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def deleteDatasetImportJobRequest(
      datasetImportJobArn: Option[String] = None
    ): DeleteDatasetImportJobRequest =
      DeleteDatasetImportJobRequest
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .build

    def deleteDatasetRequest(
      datasetArn: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .build

    def deleteForecastExportJobRequest(
      forecastExportJobArn: Option[String] = None
    ): DeleteForecastExportJobRequest =
      DeleteForecastExportJobRequest
        .builder
        .ifSome(forecastExportJobArn)(_.forecastExportJobArn(_))
        .build

    def deleteForecastRequest(
      forecastArn: Option[String] = None
    ): DeleteForecastRequest =
      DeleteForecastRequest
        .builder
        .ifSome(forecastArn)(_.forecastArn(_))
        .build

    def deletePredictorBacktestExportJobRequest(
      predictorBacktestExportJobArn: Option[String] = None
    ): DeletePredictorBacktestExportJobRequest =
      DeletePredictorBacktestExportJobRequest
        .builder
        .ifSome(predictorBacktestExportJobArn)(_.predictorBacktestExportJobArn(_))
        .build

    def deletePredictorRequest(
      predictorArn: Option[String] = None
    ): DeletePredictorRequest =
      DeletePredictorRequest
        .builder
        .ifSome(predictorArn)(_.predictorArn(_))
        .build

    def deleteResourceTreeRequest(
      resourceArn: Option[String] = None
    ): DeleteResourceTreeRequest =
      DeleteResourceTreeRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeDatasetGroupRequest(
      datasetGroupArn: Option[String] = None
    ): DescribeDatasetGroupRequest =
      DescribeDatasetGroupRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .build

    def describeDatasetGroupResponse(
      datasetGroupName: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      datasetArns: Option[List[Arn]] = None,
      domain: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribeDatasetGroupResponse =
      DescribeDatasetGroupResponse
        .builder
        .ifSome(datasetGroupName)(_.datasetGroupName(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(datasetArns)(_.datasetArns(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def describeDatasetImportJobRequest(
      datasetImportJobArn: Option[String] = None
    ): DescribeDatasetImportJobRequest =
      DescribeDatasetImportJobRequest
        .builder
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .build

    def describeDatasetImportJobResponse(
      datasetImportJobName: Option[String] = None,
      datasetImportJobArn: Option[String] = None,
      datasetArn: Option[String] = None,
      timestampFormat: Option[String] = None,
      timeZone: Option[String] = None,
      useGeolocationForTimeZone: Option[Boolean] = None,
      geolocationFormat: Option[String] = None,
      dataSource: Option[DataSource] = None,
      estimatedTimeRemainingInMinutes: Option[Long] = None,
      fieldStatistics: Option[FieldStatistics] = None,
      dataSize: Option[Double] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribeDatasetImportJobResponse =
      DescribeDatasetImportJobResponse
        .builder
        .ifSome(datasetImportJobName)(_.datasetImportJobName(_))
        .ifSome(datasetImportJobArn)(_.datasetImportJobArn(_))
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(timestampFormat)(_.timestampFormat(_))
        .ifSome(timeZone)(_.timeZone(_))
        .ifSome(useGeolocationForTimeZone)(_.useGeolocationForTimeZone(_))
        .ifSome(geolocationFormat)(_.geolocationFormat(_))
        .ifSome(dataSource)(_.dataSource(_))
        .ifSome(estimatedTimeRemainingInMinutes)(_.estimatedTimeRemainingInMinutes(_))
        .ifSome(fieldStatistics)(_.fieldStatistics(_))
        .ifSome(dataSize)(_.dataSize(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def describeDatasetRequest(
      datasetArn: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .build

    def describeDatasetResponse(
      datasetArn: Option[String] = None,
      datasetName: Option[String] = None,
      domain: Option[String] = None,
      datasetType: Option[String] = None,
      dataFrequency: Option[String] = None,
      schema: Option[Schema] = None,
      encryptionConfig: Option[EncryptionConfig] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(datasetArn)(_.datasetArn(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(domain)(_.domain(_))
        .ifSome(datasetType)(_.datasetType(_))
        .ifSome(dataFrequency)(_.dataFrequency(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def describeForecastExportJobRequest(
      forecastExportJobArn: Option[String] = None
    ): DescribeForecastExportJobRequest =
      DescribeForecastExportJobRequest
        .builder
        .ifSome(forecastExportJobArn)(_.forecastExportJobArn(_))
        .build

    def describeForecastExportJobResponse(
      forecastExportJobArn: Option[String] = None,
      forecastExportJobName: Option[String] = None,
      forecastArn: Option[String] = None,
      destination: Option[DataDestination] = None,
      message: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribeForecastExportJobResponse =
      DescribeForecastExportJobResponse
        .builder
        .ifSome(forecastExportJobArn)(_.forecastExportJobArn(_))
        .ifSome(forecastExportJobName)(_.forecastExportJobName(_))
        .ifSome(forecastArn)(_.forecastArn(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(message)(_.message(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def describeForecastRequest(
      forecastArn: Option[String] = None
    ): DescribeForecastRequest =
      DescribeForecastRequest
        .builder
        .ifSome(forecastArn)(_.forecastArn(_))
        .build

    def describeForecastResponse(
      forecastArn: Option[String] = None,
      forecastName: Option[String] = None,
      forecastTypes: Option[List[ForecastType]] = None,
      predictorArn: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      estimatedTimeRemainingInMinutes: Option[Long] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribeForecastResponse =
      DescribeForecastResponse
        .builder
        .ifSome(forecastArn)(_.forecastArn(_))
        .ifSome(forecastName)(_.forecastName(_))
        .ifSome(forecastTypes)(_.forecastTypes(_))
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(estimatedTimeRemainingInMinutes)(_.estimatedTimeRemainingInMinutes(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def describePredictorBacktestExportJobRequest(
      predictorBacktestExportJobArn: Option[String] = None
    ): DescribePredictorBacktestExportJobRequest =
      DescribePredictorBacktestExportJobRequest
        .builder
        .ifSome(predictorBacktestExportJobArn)(_.predictorBacktestExportJobArn(_))
        .build

    def describePredictorBacktestExportJobResponse(
      predictorBacktestExportJobArn: Option[String] = None,
      predictorBacktestExportJobName: Option[String] = None,
      predictorArn: Option[String] = None,
      destination: Option[DataDestination] = None,
      message: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribePredictorBacktestExportJobResponse =
      DescribePredictorBacktestExportJobResponse
        .builder
        .ifSome(predictorBacktestExportJobArn)(_.predictorBacktestExportJobArn(_))
        .ifSome(predictorBacktestExportJobName)(_.predictorBacktestExportJobName(_))
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(message)(_.message(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def describePredictorRequest(
      predictorArn: Option[String] = None
    ): DescribePredictorRequest =
      DescribePredictorRequest
        .builder
        .ifSome(predictorArn)(_.predictorArn(_))
        .build

    def describePredictorResponse(
      predictorArn: Option[String] = None,
      predictorName: Option[String] = None,
      algorithmArn: Option[String] = None,
      forecastHorizon: Option[Int] = None,
      forecastTypes: Option[List[ForecastType]] = None,
      performAutoML: Option[Boolean] = None,
      autoMLOverrideStrategy: Option[String] = None,
      performHPO: Option[Boolean] = None,
      trainingParameters: Option[TrainingParameters] = None,
      evaluationParameters: Option[EvaluationParameters] = None,
      hPOConfig: Option[HyperParameterTuningJobConfig] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      featurizationConfig: Option[FeaturizationConfig] = None,
      encryptionConfig: Option[EncryptionConfig] = None,
      predictorExecutionDetails: Option[PredictorExecutionDetails] = None,
      estimatedTimeRemainingInMinutes: Option[Long] = None,
      datasetImportJobArns: Option[List[Arn]] = None,
      autoMLAlgorithmArns: Option[List[Arn]] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): DescribePredictorResponse =
      DescribePredictorResponse
        .builder
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(predictorName)(_.predictorName(_))
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(forecastHorizon)(_.forecastHorizon(_))
        .ifSome(forecastTypes)(_.forecastTypes(_))
        .ifSome(performAutoML)(_.performAutoML(_))
        .ifSome(autoMLOverrideStrategy)(_.autoMLOverrideStrategy(_))
        .ifSome(performHPO)(_.performHPO(_))
        .ifSome(trainingParameters)(_.trainingParameters(_))
        .ifSome(evaluationParameters)(_.evaluationParameters(_))
        .ifSome(hPOConfig)(_.hPOConfig(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(featurizationConfig)(_.featurizationConfig(_))
        .ifSome(encryptionConfig)(_.encryptionConfig(_))
        .ifSome(predictorExecutionDetails)(_.predictorExecutionDetails(_))
        .ifSome(estimatedTimeRemainingInMinutes)(_.estimatedTimeRemainingInMinutes(_))
        .ifSome(datasetImportJobArns)(_.datasetImportJobArns(_))
        .ifSome(autoMLAlgorithmArns)(_.autoMLAlgorithmArns(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def encryptionConfig(
      roleArn: Option[String] = None,
      kMSKeyArn: Option[String] = None
    ): EncryptionConfig =
      EncryptionConfig
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kMSKeyArn)(_.kMSKeyArn(_))
        .build

    def errorMetric(
      forecastType: Option[String] = None,
      wAPE: Option[Double] = None,
      rMSE: Option[Double] = None
    ): ErrorMetric =
      ErrorMetric
        .builder
        .ifSome(forecastType)(_.forecastType(_))
        .ifSome(wAPE)(_.wAPE(_))
        .ifSome(rMSE)(_.rMSE(_))
        .build

    def evaluationParameters(
      numberOfBacktestWindows: Option[Int] = None,
      backTestWindowOffset: Option[Int] = None
    ): EvaluationParameters =
      EvaluationParameters
        .builder
        .ifSome(numberOfBacktestWindows)(_.numberOfBacktestWindows(_))
        .ifSome(backTestWindowOffset)(_.backTestWindowOffset(_))
        .build

    def featurization(
      attributeName: Option[String] = None,
      featurizationPipeline: Option[List[FeaturizationMethod]] = None
    ): Featurization =
      Featurization
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(featurizationPipeline)(_.featurizationPipeline(_))
        .build

    def featurizationConfig(
      forecastFrequency: Option[String] = None,
      forecastDimensions: Option[List[Name]] = None,
      featurizations: Option[List[Featurization]] = None
    ): FeaturizationConfig =
      FeaturizationConfig
        .builder
        .ifSome(forecastFrequency)(_.forecastFrequency(_))
        .ifSome(forecastDimensions)(_.forecastDimensions(_))
        .ifSome(featurizations)(_.featurizations(_))
        .build

    def featurizationMethod(
      featurizationMethodName: Option[String] = None,
      featurizationMethodParameters: Option[FeaturizationMethodParameters] = None
    ): FeaturizationMethod =
      FeaturizationMethod
        .builder
        .ifSome(featurizationMethodName)(_.featurizationMethodName(_))
        .ifSome(featurizationMethodParameters)(_.featurizationMethodParameters(_))
        .build

    def filter(
      key: Option[String] = None,
      value: Option[String] = None,
      condition: Option[String] = None
    ): Filter =
      Filter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(condition)(_.condition(_))
        .build

    def forecastExportJobSummary(
      forecastExportJobArn: Option[String] = None,
      forecastExportJobName: Option[String] = None,
      destination: Option[DataDestination] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): ForecastExportJobSummary =
      ForecastExportJobSummary
        .builder
        .ifSome(forecastExportJobArn)(_.forecastExportJobArn(_))
        .ifSome(forecastExportJobName)(_.forecastExportJobName(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def forecastSummary(
      forecastArn: Option[String] = None,
      forecastName: Option[String] = None,
      predictorArn: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): ForecastSummary =
      ForecastSummary
        .builder
        .ifSome(forecastArn)(_.forecastArn(_))
        .ifSome(forecastName)(_.forecastName(_))
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def getAccuracyMetricsRequest(
      predictorArn: Option[String] = None
    ): GetAccuracyMetricsRequest =
      GetAccuracyMetricsRequest
        .builder
        .ifSome(predictorArn)(_.predictorArn(_))
        .build

    def getAccuracyMetricsResponse(
      predictorEvaluationResults: Option[List[EvaluationResult]] = None,
      autoMLOverrideStrategy: Option[String] = None
    ): GetAccuracyMetricsResponse =
      GetAccuracyMetricsResponse
        .builder
        .ifSome(predictorEvaluationResults)(_.predictorEvaluationResults(_))
        .ifSome(autoMLOverrideStrategy)(_.autoMLOverrideStrategy(_))
        .build

    def hyperParameterTuningJobConfig(
      parameterRanges: Option[ParameterRanges] = None
    ): HyperParameterTuningJobConfig =
      HyperParameterTuningJobConfig
        .builder
        .ifSome(parameterRanges)(_.parameterRanges(_))
        .build

    def inputDataConfig(
      datasetGroupArn: Option[String] = None,
      supplementaryFeatures: Option[List[SupplementaryFeature]] = None
    ): InputDataConfig =
      InputDataConfig
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(supplementaryFeatures)(_.supplementaryFeatures(_))
        .build

    def integerParameterRange(
      name: Option[String] = None,
      maxValue: Option[Int] = None,
      minValue: Option[Int] = None,
      scalingType: Option[String] = None
    ): IntegerParameterRange =
      IntegerParameterRange
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(maxValue)(_.maxValue(_))
        .ifSome(minValue)(_.minValue(_))
        .ifSome(scalingType)(_.scalingType(_))
        .build

    def invalidInputException(
      message: Option[String] = None
    ): InvalidInputException =
      InvalidInputException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
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

    def listDatasetGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetGroupsRequest =
      ListDatasetGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetGroupsResponse(
      datasetGroups: Option[List[DatasetGroupSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetGroupsResponse =
      ListDatasetGroupsResponse
        .builder
        .ifSome(datasetGroups)(_.datasetGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetImportJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListDatasetImportJobsRequest =
      ListDatasetImportJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listDatasetImportJobsResponse(
      datasetImportJobs: Option[List[DatasetImportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetImportJobsResponse =
      ListDatasetImportJobsResponse
        .builder
        .ifSome(datasetImportJobs)(_.datasetImportJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDatasetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetsRequest =
      ListDatasetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetsResponse(
      datasets: Option[List[DatasetSummary]] = None,
      nextToken: Option[String] = None
    ): ListDatasetsResponse =
      ListDatasetsResponse
        .builder
        .ifSome(datasets)(_.datasets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listForecastExportJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListForecastExportJobsRequest =
      ListForecastExportJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listForecastExportJobsResponse(
      forecastExportJobs: Option[List[ForecastExportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListForecastExportJobsResponse =
      ListForecastExportJobsResponse
        .builder
        .ifSome(forecastExportJobs)(_.forecastExportJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listForecastsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListForecastsRequest =
      ListForecastsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listForecastsResponse(
      forecasts: Option[List[ForecastSummary]] = None,
      nextToken: Option[String] = None
    ): ListForecastsResponse =
      ListForecastsResponse
        .builder
        .ifSome(forecasts)(_.forecasts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPredictorBacktestExportJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListPredictorBacktestExportJobsRequest =
      ListPredictorBacktestExportJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listPredictorBacktestExportJobsResponse(
      predictorBacktestExportJobs: Option[List[PredictorBacktestExportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListPredictorBacktestExportJobsResponse =
      ListPredictorBacktestExportJobsResponse
        .builder
        .ifSome(predictorBacktestExportJobs)(_.predictorBacktestExportJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPredictorsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListPredictorsRequest =
      ListPredictorsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listPredictorsResponse(
      predictors: Option[List[PredictorSummary]] = None,
      nextToken: Option[String] = None
    ): ListPredictorsResponse =
      ListPredictorsResponse
        .builder
        .ifSome(predictors)(_.predictors(_))
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
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def metrics(
      rMSE: Option[Double] = None,
      weightedQuantileLosses: Option[List[WeightedQuantileLoss]] = None,
      errorMetrics: Option[List[ErrorMetric]] = None
    ): Metrics =
      Metrics
        .builder
        .ifSome(rMSE)(_.rMSE(_))
        .ifSome(weightedQuantileLosses)(_.weightedQuantileLosses(_))
        .ifSome(errorMetrics)(_.errorMetrics(_))
        .build

    def parameterRanges(
      categoricalParameterRanges: Option[List[CategoricalParameterRange]] = None,
      continuousParameterRanges: Option[List[ContinuousParameterRange]] = None,
      integerParameterRanges: Option[List[IntegerParameterRange]] = None
    ): ParameterRanges =
      ParameterRanges
        .builder
        .ifSome(categoricalParameterRanges)(_.categoricalParameterRanges(_))
        .ifSome(continuousParameterRanges)(_.continuousParameterRanges(_))
        .ifSome(integerParameterRanges)(_.integerParameterRanges(_))
        .build

    def predictorBacktestExportJobSummary(
      predictorBacktestExportJobArn: Option[String] = None,
      predictorBacktestExportJobName: Option[String] = None,
      destination: Option[DataDestination] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): PredictorBacktestExportJobSummary =
      PredictorBacktestExportJobSummary
        .builder
        .ifSome(predictorBacktestExportJobArn)(_.predictorBacktestExportJobArn(_))
        .ifSome(predictorBacktestExportJobName)(_.predictorBacktestExportJobName(_))
        .ifSome(destination)(_.destination(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def predictorExecution(
      algorithmArn: Option[String] = None,
      testWindows: Option[List[TestWindowSummary]] = None
    ): PredictorExecution =
      PredictorExecution
        .builder
        .ifSome(algorithmArn)(_.algorithmArn(_))
        .ifSome(testWindows)(_.testWindows(_))
        .build

    def predictorExecutionDetails(
      predictorExecutions: Option[List[PredictorExecution]] = None
    ): PredictorExecutionDetails =
      PredictorExecutionDetails
        .builder
        .ifSome(predictorExecutions)(_.predictorExecutions(_))
        .build

    def predictorSummary(
      predictorArn: Option[String] = None,
      predictorName: Option[String] = None,
      datasetGroupArn: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      lastModificationTime: Option[Timestamp] = None
    ): PredictorSummary =
      PredictorSummary
        .builder
        .ifSome(predictorArn)(_.predictorArn(_))
        .ifSome(predictorName)(_.predictorName(_))
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModificationTime)(_.lastModificationTime(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
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

    def s3Config(
      path: Option[String] = None,
      roleArn: Option[String] = None,
      kMSKeyArn: Option[String] = None
    ): S3Config =
      S3Config
        .builder
        .ifSome(path)(_.path(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(kMSKeyArn)(_.kMSKeyArn(_))
        .build

    def schema(
      attributes: Option[List[SchemaAttribute]] = None
    ): Schema =
      Schema
        .builder
        .ifSome(attributes)(_.attributes(_))
        .build

    def schemaAttribute(
      attributeName: Option[String] = None,
      attributeType: Option[String] = None
    ): SchemaAttribute =
      SchemaAttribute
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeType)(_.attributeType(_))
        .build

    def statistics(
      count: Option[Int] = None,
      countDistinct: Option[Int] = None,
      countNull: Option[Int] = None,
      countNan: Option[Int] = None,
      min: Option[String] = None,
      max: Option[String] = None,
      avg: Option[Double] = None,
      stddev: Option[Double] = None,
      countLong: Option[Long] = None,
      countDistinctLong: Option[Long] = None,
      countNullLong: Option[Long] = None,
      countNanLong: Option[Long] = None
    ): Statistics =
      Statistics
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(countDistinct)(_.countDistinct(_))
        .ifSome(countNull)(_.countNull(_))
        .ifSome(countNan)(_.countNan(_))
        .ifSome(min)(_.min(_))
        .ifSome(max)(_.max(_))
        .ifSome(avg)(_.avg(_))
        .ifSome(stddev)(_.stddev(_))
        .ifSome(countLong)(_.countLong(_))
        .ifSome(countDistinctLong)(_.countDistinctLong(_))
        .ifSome(countNullLong)(_.countNullLong(_))
        .ifSome(countNanLong)(_.countNanLong(_))
        .build

    def stopResourceRequest(
      resourceArn: Option[String] = None
    ): StopResourceRequest =
      StopResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def supplementaryFeature(
      name: Option[String] = None,
      value: Option[String] = None
    ): SupplementaryFeature =
      SupplementaryFeature
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
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

    def testWindowSummary(
      testWindowStart: Option[Timestamp] = None,
      testWindowEnd: Option[Timestamp] = None,
      status: Option[String] = None,
      message: Option[String] = None
    ): TestWindowSummary =
      TestWindowSummary
        .builder
        .ifSome(testWindowStart)(_.testWindowStart(_))
        .ifSome(testWindowEnd)(_.testWindowEnd(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
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

    def updateDatasetGroupRequest(
      datasetGroupArn: Option[String] = None,
      datasetArns: Option[List[Arn]] = None
    ): UpdateDatasetGroupRequest =
      UpdateDatasetGroupRequest
        .builder
        .ifSome(datasetGroupArn)(_.datasetGroupArn(_))
        .ifSome(datasetArns)(_.datasetArns(_))
        .build

    def updateDatasetGroupResponse(

    ): UpdateDatasetGroupResponse =
      UpdateDatasetGroupResponse
        .builder

        .build

    def weightedQuantileLoss(
      quantile: Option[Double] = None,
      lossValue: Option[Double] = None
    ): WeightedQuantileLoss =
      WeightedQuantileLoss
        .builder
        .ifSome(quantile)(_.quantile(_))
        .ifSome(lossValue)(_.lossValue(_))
        .build

    def windowSummary(
      testWindowStart: Option[Timestamp] = None,
      testWindowEnd: Option[Timestamp] = None,
      itemCount: Option[Int] = None,
      evaluationType: Option[String] = None,
      metrics: Option[Metrics] = None
    ): WindowSummary =
      WindowSummary
        .builder
        .ifSome(testWindowStart)(_.testWindowStart(_))
        .ifSome(testWindowEnd)(_.testWindowEnd(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(evaluationType)(_.evaluationType(_))
        .ifSome(metrics)(_.metrics(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
