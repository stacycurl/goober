package goober.hi

import goober.free.comprehend.ComprehendIO
import software.amazon.awssdk.services.comprehend.model._


object comprehend {
  import goober.free.{comprehend ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def augmentedManifestsListItem(
      s3Uri: Option[String] = None,
      attributeNames: Option[List[AttributeNamesListItem]] = None
    ): AugmentedManifestsListItem =
      AugmentedManifestsListItem
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(attributeNames)(_.attributeNames(_))
        .build

    def batchDetectDominantLanguageRequest(
      textList: Option[List[CustomerInputString]] = None
    ): BatchDetectDominantLanguageRequest =
      BatchDetectDominantLanguageRequest
        .builder
        .ifSome(textList)(_.textList(_))
        .build

    def batchDetectDominantLanguageResponse(
      resultList: Option[List[BatchDetectDominantLanguageItemResult]] = None,
      errorList: Option[List[BatchItemError]] = None
    ): BatchDetectDominantLanguageResponse =
      BatchDetectDominantLanguageResponse
        .builder
        .ifSome(resultList)(_.resultList(_))
        .ifSome(errorList)(_.errorList(_))
        .build

    def batchDetectEntitiesRequest(
      textList: Option[List[CustomerInputString]] = None,
      languageCode: Option[String] = None
    ): BatchDetectEntitiesRequest =
      BatchDetectEntitiesRequest
        .builder
        .ifSome(textList)(_.textList(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def batchDetectEntitiesResponse(
      resultList: Option[List[BatchDetectEntitiesItemResult]] = None,
      errorList: Option[List[BatchItemError]] = None
    ): BatchDetectEntitiesResponse =
      BatchDetectEntitiesResponse
        .builder
        .ifSome(resultList)(_.resultList(_))
        .ifSome(errorList)(_.errorList(_))
        .build

    def batchDetectKeyPhrasesRequest(
      textList: Option[List[CustomerInputString]] = None,
      languageCode: Option[String] = None
    ): BatchDetectKeyPhrasesRequest =
      BatchDetectKeyPhrasesRequest
        .builder
        .ifSome(textList)(_.textList(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def batchDetectKeyPhrasesResponse(
      resultList: Option[List[BatchDetectKeyPhrasesItemResult]] = None,
      errorList: Option[List[BatchItemError]] = None
    ): BatchDetectKeyPhrasesResponse =
      BatchDetectKeyPhrasesResponse
        .builder
        .ifSome(resultList)(_.resultList(_))
        .ifSome(errorList)(_.errorList(_))
        .build

    def batchDetectSentimentRequest(
      textList: Option[List[CustomerInputString]] = None,
      languageCode: Option[String] = None
    ): BatchDetectSentimentRequest =
      BatchDetectSentimentRequest
        .builder
        .ifSome(textList)(_.textList(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def batchDetectSentimentResponse(
      resultList: Option[List[BatchDetectSentimentItemResult]] = None,
      errorList: Option[List[BatchItemError]] = None
    ): BatchDetectSentimentResponse =
      BatchDetectSentimentResponse
        .builder
        .ifSome(resultList)(_.resultList(_))
        .ifSome(errorList)(_.errorList(_))
        .build

    def batchDetectSyntaxRequest(
      textList: Option[List[CustomerInputString]] = None,
      languageCode: Option[String] = None
    ): BatchDetectSyntaxRequest =
      BatchDetectSyntaxRequest
        .builder
        .ifSome(textList)(_.textList(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def batchDetectSyntaxResponse(
      resultList: Option[List[BatchDetectSyntaxItemResult]] = None,
      errorList: Option[List[BatchItemError]] = None
    ): BatchDetectSyntaxResponse =
      BatchDetectSyntaxResponse
        .builder
        .ifSome(resultList)(_.resultList(_))
        .ifSome(errorList)(_.errorList(_))
        .build

    def batchItemError(
      index: Option[Int] = None,
      errorCode: Option[String] = None,
      errorMessage: Option[String] = None
    ): BatchItemError =
      BatchItemError
        .builder
        .ifSome(index)(_.index(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def batchSizeLimitExceededException(
      message: Option[String] = None
    ): BatchSizeLimitExceededException =
      BatchSizeLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def classifierEvaluationMetrics(
      accuracy: Option[Double] = None,
      precision: Option[Double] = None,
      recall: Option[Double] = None,
      f1Score: Option[Double] = None,
      microPrecision: Option[Double] = None,
      microRecall: Option[Double] = None,
      microF1Score: Option[Double] = None,
      hammingLoss: Option[Double] = None
    ): ClassifierEvaluationMetrics =
      ClassifierEvaluationMetrics
        .builder
        .ifSome(accuracy)(_.accuracy(_))
        .ifSome(precision)(_.precision(_))
        .ifSome(recall)(_.recall(_))
        .ifSome(f1Score)(_.f1Score(_))
        .ifSome(microPrecision)(_.microPrecision(_))
        .ifSome(microRecall)(_.microRecall(_))
        .ifSome(microF1Score)(_.microF1Score(_))
        .ifSome(hammingLoss)(_.hammingLoss(_))
        .build

    def classifierMetadata(
      numberOfLabels: Option[Int] = None,
      numberOfTrainedDocuments: Option[Int] = None,
      numberOfTestDocuments: Option[Int] = None,
      evaluationMetrics: Option[ClassifierEvaluationMetrics] = None
    ): ClassifierMetadata =
      ClassifierMetadata
        .builder
        .ifSome(numberOfLabels)(_.numberOfLabels(_))
        .ifSome(numberOfTrainedDocuments)(_.numberOfTrainedDocuments(_))
        .ifSome(numberOfTestDocuments)(_.numberOfTestDocuments(_))
        .ifSome(evaluationMetrics)(_.evaluationMetrics(_))
        .build

    def classifyDocumentRequest(
      text: Option[String] = None,
      endpointArn: Option[String] = None
    ): ClassifyDocumentRequest =
      ClassifyDocumentRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def classifyDocumentResponse(
      classes: Option[List[DocumentClass]] = None,
      labels: Option[List[DocumentLabel]] = None
    ): ClassifyDocumentResponse =
      ClassifyDocumentResponse
        .builder
        .ifSome(classes)(_.classes(_))
        .ifSome(labels)(_.labels(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def containsPiiEntitiesRequest(
      text: Option[String] = None,
      languageCode: Option[String] = None
    ): ContainsPiiEntitiesRequest =
      ContainsPiiEntitiesRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def containsPiiEntitiesResponse(
      labels: Option[List[EntityLabel]] = None
    ): ContainsPiiEntitiesResponse =
      ContainsPiiEntitiesResponse
        .builder
        .ifSome(labels)(_.labels(_))
        .build

    def createDocumentClassifierRequest(
      documentClassifierName: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      inputDataConfig: Option[DocumentClassifierInputDataConfig] = None,
      outputDataConfig: Option[DocumentClassifierOutputDataConfig] = None,
      clientRequestToken: Option[String] = None,
      languageCode: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      mode: Option[String] = None,
      modelKmsKeyId: Option[String] = None
    ): CreateDocumentClassifierRequest =
      CreateDocumentClassifierRequest
        .builder
        .ifSome(documentClassifierName)(_.documentClassifierName(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(modelKmsKeyId)(_.modelKmsKeyId(_))
        .build

    def createDocumentClassifierResponse(
      documentClassifierArn: Option[String] = None
    ): CreateDocumentClassifierResponse =
      CreateDocumentClassifierResponse
        .builder
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .build

    def createEndpointRequest(
      endpointName: Option[String] = None,
      modelArn: Option[String] = None,
      desiredInferenceUnits: Option[Int] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None,
      dataAccessRoleArn: Option[String] = None
    ): CreateEndpointRequest =
      CreateEndpointRequest
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(desiredInferenceUnits)(_.desiredInferenceUnits(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .build

    def createEndpointResponse(
      endpointArn: Option[String] = None
    ): CreateEndpointResponse =
      CreateEndpointResponse
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def createEntityRecognizerRequest(
      recognizerName: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      tags: Option[List[Tag]] = None,
      inputDataConfig: Option[EntityRecognizerInputDataConfig] = None,
      clientRequestToken: Option[String] = None,
      languageCode: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      modelKmsKeyId: Option[String] = None
    ): CreateEntityRecognizerRequest =
      CreateEntityRecognizerRequest
        .builder
        .ifSome(recognizerName)(_.recognizerName(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(modelKmsKeyId)(_.modelKmsKeyId(_))
        .build

    def createEntityRecognizerResponse(
      entityRecognizerArn: Option[String] = None
    ): CreateEntityRecognizerResponse =
      CreateEntityRecognizerResponse
        .builder
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .build

    def deleteDocumentClassifierRequest(
      documentClassifierArn: Option[String] = None
    ): DeleteDocumentClassifierRequest =
      DeleteDocumentClassifierRequest
        .builder
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .build

    def deleteDocumentClassifierResponse(

    ): DeleteDocumentClassifierResponse =
      DeleteDocumentClassifierResponse
        .builder

        .build

    def deleteEndpointRequest(
      endpointArn: Option[String] = None
    ): DeleteEndpointRequest =
      DeleteEndpointRequest
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def deleteEndpointResponse(

    ): DeleteEndpointResponse =
      DeleteEndpointResponse
        .builder

        .build

    def deleteEntityRecognizerRequest(
      entityRecognizerArn: Option[String] = None
    ): DeleteEntityRecognizerRequest =
      DeleteEntityRecognizerRequest
        .builder
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .build

    def deleteEntityRecognizerResponse(

    ): DeleteEntityRecognizerResponse =
      DeleteEntityRecognizerResponse
        .builder

        .build

    def describeDocumentClassificationJobRequest(
      jobId: Option[String] = None
    ): DescribeDocumentClassificationJobRequest =
      DescribeDocumentClassificationJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeDocumentClassificationJobResponse(
      documentClassificationJobProperties: Option[DocumentClassificationJobProperties] = None
    ): DescribeDocumentClassificationJobResponse =
      DescribeDocumentClassificationJobResponse
        .builder
        .ifSome(documentClassificationJobProperties)(_.documentClassificationJobProperties(_))
        .build

    def describeDocumentClassifierRequest(
      documentClassifierArn: Option[String] = None
    ): DescribeDocumentClassifierRequest =
      DescribeDocumentClassifierRequest
        .builder
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .build

    def describeDocumentClassifierResponse(
      documentClassifierProperties: Option[DocumentClassifierProperties] = None
    ): DescribeDocumentClassifierResponse =
      DescribeDocumentClassifierResponse
        .builder
        .ifSome(documentClassifierProperties)(_.documentClassifierProperties(_))
        .build

    def describeDominantLanguageDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribeDominantLanguageDetectionJobRequest =
      DescribeDominantLanguageDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeDominantLanguageDetectionJobResponse(
      dominantLanguageDetectionJobProperties: Option[DominantLanguageDetectionJobProperties] = None
    ): DescribeDominantLanguageDetectionJobResponse =
      DescribeDominantLanguageDetectionJobResponse
        .builder
        .ifSome(dominantLanguageDetectionJobProperties)(_.dominantLanguageDetectionJobProperties(_))
        .build

    def describeEndpointRequest(
      endpointArn: Option[String] = None
    ): DescribeEndpointRequest =
      DescribeEndpointRequest
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def describeEndpointResponse(
      endpointProperties: Option[EndpointProperties] = None
    ): DescribeEndpointResponse =
      DescribeEndpointResponse
        .builder
        .ifSome(endpointProperties)(_.endpointProperties(_))
        .build

    def describeEntitiesDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribeEntitiesDetectionJobRequest =
      DescribeEntitiesDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeEntitiesDetectionJobResponse(
      entitiesDetectionJobProperties: Option[EntitiesDetectionJobProperties] = None
    ): DescribeEntitiesDetectionJobResponse =
      DescribeEntitiesDetectionJobResponse
        .builder
        .ifSome(entitiesDetectionJobProperties)(_.entitiesDetectionJobProperties(_))
        .build

    def describeEntityRecognizerRequest(
      entityRecognizerArn: Option[String] = None
    ): DescribeEntityRecognizerRequest =
      DescribeEntityRecognizerRequest
        .builder
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .build

    def describeEntityRecognizerResponse(
      entityRecognizerProperties: Option[EntityRecognizerProperties] = None
    ): DescribeEntityRecognizerResponse =
      DescribeEntityRecognizerResponse
        .builder
        .ifSome(entityRecognizerProperties)(_.entityRecognizerProperties(_))
        .build

    def describeEventsDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribeEventsDetectionJobRequest =
      DescribeEventsDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeEventsDetectionJobResponse(
      eventsDetectionJobProperties: Option[EventsDetectionJobProperties] = None
    ): DescribeEventsDetectionJobResponse =
      DescribeEventsDetectionJobResponse
        .builder
        .ifSome(eventsDetectionJobProperties)(_.eventsDetectionJobProperties(_))
        .build

    def describeKeyPhrasesDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribeKeyPhrasesDetectionJobRequest =
      DescribeKeyPhrasesDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeKeyPhrasesDetectionJobResponse(
      keyPhrasesDetectionJobProperties: Option[KeyPhrasesDetectionJobProperties] = None
    ): DescribeKeyPhrasesDetectionJobResponse =
      DescribeKeyPhrasesDetectionJobResponse
        .builder
        .ifSome(keyPhrasesDetectionJobProperties)(_.keyPhrasesDetectionJobProperties(_))
        .build

    def describePiiEntitiesDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribePiiEntitiesDetectionJobRequest =
      DescribePiiEntitiesDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describePiiEntitiesDetectionJobResponse(
      piiEntitiesDetectionJobProperties: Option[PiiEntitiesDetectionJobProperties] = None
    ): DescribePiiEntitiesDetectionJobResponse =
      DescribePiiEntitiesDetectionJobResponse
        .builder
        .ifSome(piiEntitiesDetectionJobProperties)(_.piiEntitiesDetectionJobProperties(_))
        .build

    def describeSentimentDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribeSentimentDetectionJobRequest =
      DescribeSentimentDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeSentimentDetectionJobResponse(
      sentimentDetectionJobProperties: Option[SentimentDetectionJobProperties] = None
    ): DescribeSentimentDetectionJobResponse =
      DescribeSentimentDetectionJobResponse
        .builder
        .ifSome(sentimentDetectionJobProperties)(_.sentimentDetectionJobProperties(_))
        .build

    def describeTopicsDetectionJobRequest(
      jobId: Option[String] = None
    ): DescribeTopicsDetectionJobRequest =
      DescribeTopicsDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeTopicsDetectionJobResponse(
      topicsDetectionJobProperties: Option[TopicsDetectionJobProperties] = None
    ): DescribeTopicsDetectionJobResponse =
      DescribeTopicsDetectionJobResponse
        .builder
        .ifSome(topicsDetectionJobProperties)(_.topicsDetectionJobProperties(_))
        .build

    def detectDominantLanguageRequest(
      text: Option[String] = None
    ): DetectDominantLanguageRequest =
      DetectDominantLanguageRequest
        .builder
        .ifSome(text)(_.text(_))
        .build

    def detectDominantLanguageResponse(
      languages: Option[List[DominantLanguage]] = None
    ): DetectDominantLanguageResponse =
      DetectDominantLanguageResponse
        .builder
        .ifSome(languages)(_.languages(_))
        .build

    def detectEntitiesRequest(
      text: Option[String] = None,
      languageCode: Option[String] = None,
      endpointArn: Option[String] = None
    ): DetectEntitiesRequest =
      DetectEntitiesRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(endpointArn)(_.endpointArn(_))
        .build

    def detectEntitiesResponse(
      entities: Option[List[Entity]] = None
    ): DetectEntitiesResponse =
      DetectEntitiesResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .build

    def detectKeyPhrasesRequest(
      text: Option[String] = None,
      languageCode: Option[String] = None
    ): DetectKeyPhrasesRequest =
      DetectKeyPhrasesRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def detectKeyPhrasesResponse(
      keyPhrases: Option[List[KeyPhrase]] = None
    ): DetectKeyPhrasesResponse =
      DetectKeyPhrasesResponse
        .builder
        .ifSome(keyPhrases)(_.keyPhrases(_))
        .build

    def detectPiiEntitiesRequest(
      text: Option[String] = None,
      languageCode: Option[String] = None
    ): DetectPiiEntitiesRequest =
      DetectPiiEntitiesRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def detectPiiEntitiesResponse(
      entities: Option[List[PiiEntity]] = None
    ): DetectPiiEntitiesResponse =
      DetectPiiEntitiesResponse
        .builder
        .ifSome(entities)(_.entities(_))
        .build

    def detectSentimentRequest(
      text: Option[String] = None,
      languageCode: Option[String] = None
    ): DetectSentimentRequest =
      DetectSentimentRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def detectSentimentResponse(
      sentiment: Option[String] = None,
      sentimentScore: Option[SentimentScore] = None
    ): DetectSentimentResponse =
      DetectSentimentResponse
        .builder
        .ifSome(sentiment)(_.sentiment(_))
        .ifSome(sentimentScore)(_.sentimentScore(_))
        .build

    def detectSyntaxRequest(
      text: Option[String] = None,
      languageCode: Option[String] = None
    ): DetectSyntaxRequest =
      DetectSyntaxRequest
        .builder
        .ifSome(text)(_.text(_))
        .ifSome(languageCode)(_.languageCode(_))
        .build

    def detectSyntaxResponse(
      syntaxTokens: Option[List[SyntaxToken]] = None
    ): DetectSyntaxResponse =
      DetectSyntaxResponse
        .builder
        .ifSome(syntaxTokens)(_.syntaxTokens(_))
        .build

    def documentClass(
      name: Option[String] = None,
      score: Option[Float] = None
    ): DocumentClass =
      DocumentClass
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(score)(_.score(_))
        .build

    def documentClassificationJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): DocumentClassificationJobFilter =
      DocumentClassificationJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def documentClassificationJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      documentClassifierArn: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): DocumentClassificationJobProperties =
      DocumentClassificationJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def documentClassifierFilter(
      status: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): DocumentClassifierFilter =
      DocumentClassifierFilter
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def documentClassifierInputDataConfig(
      dataFormat: Option[String] = None,
      s3Uri: Option[String] = None,
      labelDelimiter: Option[String] = None,
      augmentedManifests: Option[List[AugmentedManifestsListItem]] = None
    ): DocumentClassifierInputDataConfig =
      DocumentClassifierInputDataConfig
        .builder
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(labelDelimiter)(_.labelDelimiter(_))
        .ifSome(augmentedManifests)(_.augmentedManifests(_))
        .build

    def documentClassifierOutputDataConfig(
      s3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): DocumentClassifierOutputDataConfig =
      DocumentClassifierOutputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def documentClassifierProperties(
      documentClassifierArn: Option[String] = None,
      languageCode: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      trainingStartTime: Option[Timestamp] = None,
      trainingEndTime: Option[Timestamp] = None,
      inputDataConfig: Option[DocumentClassifierInputDataConfig] = None,
      outputDataConfig: Option[DocumentClassifierOutputDataConfig] = None,
      classifierMetadata: Option[ClassifierMetadata] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      mode: Option[String] = None,
      modelKmsKeyId: Option[String] = None
    ): DocumentClassifierProperties =
      DocumentClassifierProperties
        .builder
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(trainingStartTime)(_.trainingStartTime(_))
        .ifSome(trainingEndTime)(_.trainingEndTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(classifierMetadata)(_.classifierMetadata(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(modelKmsKeyId)(_.modelKmsKeyId(_))
        .build

    def documentLabel(
      name: Option[String] = None,
      score: Option[Float] = None
    ): DocumentLabel =
      DocumentLabel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(score)(_.score(_))
        .build

    def dominantLanguage(
      languageCode: Option[String] = None,
      score: Option[Float] = None
    ): DominantLanguage =
      DominantLanguage
        .builder
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(score)(_.score(_))
        .build

    def dominantLanguageDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): DominantLanguageDetectionJobFilter =
      DominantLanguageDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def dominantLanguageDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): DominantLanguageDetectionJobProperties =
      DominantLanguageDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def endpointFilter(
      modelArn: Option[String] = None,
      status: Option[String] = None,
      creationTimeBefore: Option[Timestamp] = None,
      creationTimeAfter: Option[Timestamp] = None
    ): EndpointFilter =
      EndpointFilter
        .builder
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .build

    def endpointProperties(
      endpointArn: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      modelArn: Option[String] = None,
      desiredInferenceUnits: Option[Int] = None,
      currentInferenceUnits: Option[Int] = None,
      creationTime: Option[Timestamp] = None,
      lastModifiedTime: Option[Timestamp] = None,
      dataAccessRoleArn: Option[String] = None
    ): EndpointProperties =
      EndpointProperties
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(modelArn)(_.modelArn(_))
        .ifSome(desiredInferenceUnits)(_.desiredInferenceUnits(_))
        .ifSome(currentInferenceUnits)(_.currentInferenceUnits(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastModifiedTime)(_.lastModifiedTime(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .build

    def entitiesDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): EntitiesDetectionJobFilter =
      EntitiesDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def entitiesDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      entityRecognizerArn: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      languageCode: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): EntitiesDetectionJobProperties =
      EntitiesDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def entity(
      score: Option[Float] = None,
      `type`: Option[String] = None,
      text: Option[String] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None
    ): Entity =
      Entity
        .builder
        .ifSome(score)(_.score(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(text)(_.text(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .build

    def entityLabel(
      name: Option[String] = None,
      score: Option[Float] = None
    ): EntityLabel =
      EntityLabel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(score)(_.score(_))
        .build

    def entityRecognizerAnnotations(
      s3Uri: Option[String] = None
    ): EntityRecognizerAnnotations =
      EntityRecognizerAnnotations
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def entityRecognizerDocuments(
      s3Uri: Option[String] = None
    ): EntityRecognizerDocuments =
      EntityRecognizerDocuments
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def entityRecognizerEntityList(
      s3Uri: Option[String] = None
    ): EntityRecognizerEntityList =
      EntityRecognizerEntityList
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .build

    def entityRecognizerEvaluationMetrics(
      precision: Option[Double] = None,
      recall: Option[Double] = None,
      f1Score: Option[Double] = None
    ): EntityRecognizerEvaluationMetrics =
      EntityRecognizerEvaluationMetrics
        .builder
        .ifSome(precision)(_.precision(_))
        .ifSome(recall)(_.recall(_))
        .ifSome(f1Score)(_.f1Score(_))
        .build

    def entityRecognizerFilter(
      status: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): EntityRecognizerFilter =
      EntityRecognizerFilter
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def entityRecognizerInputDataConfig(
      dataFormat: Option[String] = None,
      entityTypes: Option[List[EntityTypesListItem]] = None,
      documents: Option[EntityRecognizerDocuments] = None,
      annotations: Option[EntityRecognizerAnnotations] = None,
      entityList: Option[EntityRecognizerEntityList] = None,
      augmentedManifests: Option[List[AugmentedManifestsListItem]] = None
    ): EntityRecognizerInputDataConfig =
      EntityRecognizerInputDataConfig
        .builder
        .ifSome(dataFormat)(_.dataFormat(_))
        .ifSome(entityTypes)(_.entityTypes(_))
        .ifSome(documents)(_.documents(_))
        .ifSome(annotations)(_.annotations(_))
        .ifSome(entityList)(_.entityList(_))
        .ifSome(augmentedManifests)(_.augmentedManifests(_))
        .build

    def entityRecognizerMetadata(
      numberOfTrainedDocuments: Option[Int] = None,
      numberOfTestDocuments: Option[Int] = None,
      evaluationMetrics: Option[EntityRecognizerEvaluationMetrics] = None,
      entityTypes: Option[List[EntityRecognizerMetadataEntityTypesListItem]] = None
    ): EntityRecognizerMetadata =
      EntityRecognizerMetadata
        .builder
        .ifSome(numberOfTrainedDocuments)(_.numberOfTrainedDocuments(_))
        .ifSome(numberOfTestDocuments)(_.numberOfTestDocuments(_))
        .ifSome(evaluationMetrics)(_.evaluationMetrics(_))
        .ifSome(entityTypes)(_.entityTypes(_))
        .build

    def entityRecognizerMetadataEntityTypesListItem(
      `type`: Option[String] = None,
      evaluationMetrics: Option[EntityTypesEvaluationMetrics] = None,
      numberOfTrainMentions: Option[Int] = None
    ): EntityRecognizerMetadataEntityTypesListItem =
      EntityRecognizerMetadataEntityTypesListItem
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(evaluationMetrics)(_.evaluationMetrics(_))
        .ifSome(numberOfTrainMentions)(_.numberOfTrainMentions(_))
        .build

    def entityRecognizerProperties(
      entityRecognizerArn: Option[String] = None,
      languageCode: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      trainingStartTime: Option[Timestamp] = None,
      trainingEndTime: Option[Timestamp] = None,
      inputDataConfig: Option[EntityRecognizerInputDataConfig] = None,
      recognizerMetadata: Option[EntityRecognizerMetadata] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      modelKmsKeyId: Option[String] = None
    ): EntityRecognizerProperties =
      EntityRecognizerProperties
        .builder
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(trainingStartTime)(_.trainingStartTime(_))
        .ifSome(trainingEndTime)(_.trainingEndTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(recognizerMetadata)(_.recognizerMetadata(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(modelKmsKeyId)(_.modelKmsKeyId(_))
        .build

    def entityTypesEvaluationMetrics(
      precision: Option[Double] = None,
      recall: Option[Double] = None,
      f1Score: Option[Double] = None
    ): EntityTypesEvaluationMetrics =
      EntityTypesEvaluationMetrics
        .builder
        .ifSome(precision)(_.precision(_))
        .ifSome(recall)(_.recall(_))
        .ifSome(f1Score)(_.f1Score(_))
        .build

    def entityTypesListItem(
      `type`: Option[String] = None
    ): EntityTypesListItem =
      EntityTypesListItem
        .builder
        .ifSome(`type`)(_.`type`(_))
        .build

    def eventsDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): EventsDetectionJobFilter =
      EventsDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def eventsDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      languageCode: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      targetEventTypes: Option[List[EventTypeString]] = None
    ): EventsDetectionJobProperties =
      EventsDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(targetEventTypes)(_.targetEventTypes(_))
        .build

    def inputDataConfig(
      s3Uri: Option[String] = None,
      inputFormat: Option[String] = None
    ): InputDataConfig =
      InputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(inputFormat)(_.inputFormat(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidFilterException(
      message: Option[String] = None
    ): InvalidFilterException =
      InvalidFilterException
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

    def jobNotFoundException(
      message: Option[String] = None
    ): JobNotFoundException =
      JobNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyPhrase(
      score: Option[Float] = None,
      text: Option[String] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None
    ): KeyPhrase =
      KeyPhrase
        .builder
        .ifSome(score)(_.score(_))
        .ifSome(text)(_.text(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .build

    def keyPhrasesDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): KeyPhrasesDetectionJobFilter =
      KeyPhrasesDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def keyPhrasesDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      languageCode: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): KeyPhrasesDetectionJobProperties =
      KeyPhrasesDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def kmsKeyValidationException(
      message: Option[String] = None
    ): KmsKeyValidationException =
      KmsKeyValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDocumentClassificationJobsRequest(
      filter: Option[DocumentClassificationJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDocumentClassificationJobsRequest =
      ListDocumentClassificationJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDocumentClassificationJobsResponse(
      documentClassificationJobPropertiesList: Option[List[DocumentClassificationJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListDocumentClassificationJobsResponse =
      ListDocumentClassificationJobsResponse
        .builder
        .ifSome(documentClassificationJobPropertiesList)(_.documentClassificationJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDocumentClassifiersRequest(
      filter: Option[DocumentClassifierFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDocumentClassifiersRequest =
      ListDocumentClassifiersRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDocumentClassifiersResponse(
      documentClassifierPropertiesList: Option[List[DocumentClassifierProperties]] = None,
      nextToken: Option[String] = None
    ): ListDocumentClassifiersResponse =
      ListDocumentClassifiersResponse
        .builder
        .ifSome(documentClassifierPropertiesList)(_.documentClassifierPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDominantLanguageDetectionJobsRequest(
      filter: Option[DominantLanguageDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDominantLanguageDetectionJobsRequest =
      ListDominantLanguageDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDominantLanguageDetectionJobsResponse(
      dominantLanguageDetectionJobPropertiesList: Option[List[DominantLanguageDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListDominantLanguageDetectionJobsResponse =
      ListDominantLanguageDetectionJobsResponse
        .builder
        .ifSome(dominantLanguageDetectionJobPropertiesList)(_.dominantLanguageDetectionJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEndpointsRequest(
      filter: Option[EndpointFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEndpointsRequest =
      ListEndpointsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEndpointsResponse(
      endpointPropertiesList: Option[List[EndpointProperties]] = None,
      nextToken: Option[String] = None
    ): ListEndpointsResponse =
      ListEndpointsResponse
        .builder
        .ifSome(endpointPropertiesList)(_.endpointPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEntitiesDetectionJobsRequest(
      filter: Option[EntitiesDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEntitiesDetectionJobsRequest =
      ListEntitiesDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEntitiesDetectionJobsResponse(
      entitiesDetectionJobPropertiesList: Option[List[EntitiesDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListEntitiesDetectionJobsResponse =
      ListEntitiesDetectionJobsResponse
        .builder
        .ifSome(entitiesDetectionJobPropertiesList)(_.entitiesDetectionJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEntityRecognizersRequest(
      filter: Option[EntityRecognizerFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEntityRecognizersRequest =
      ListEntityRecognizersRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEntityRecognizersResponse(
      entityRecognizerPropertiesList: Option[List[EntityRecognizerProperties]] = None,
      nextToken: Option[String] = None
    ): ListEntityRecognizersResponse =
      ListEntityRecognizersResponse
        .builder
        .ifSome(entityRecognizerPropertiesList)(_.entityRecognizerPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listEventsDetectionJobsRequest(
      filter: Option[EventsDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEventsDetectionJobsRequest =
      ListEventsDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listEventsDetectionJobsResponse(
      eventsDetectionJobPropertiesList: Option[List[EventsDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListEventsDetectionJobsResponse =
      ListEventsDetectionJobsResponse
        .builder
        .ifSome(eventsDetectionJobPropertiesList)(_.eventsDetectionJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listKeyPhrasesDetectionJobsRequest(
      filter: Option[KeyPhrasesDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListKeyPhrasesDetectionJobsRequest =
      ListKeyPhrasesDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listKeyPhrasesDetectionJobsResponse(
      keyPhrasesDetectionJobPropertiesList: Option[List[KeyPhrasesDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListKeyPhrasesDetectionJobsResponse =
      ListKeyPhrasesDetectionJobsResponse
        .builder
        .ifSome(keyPhrasesDetectionJobPropertiesList)(_.keyPhrasesDetectionJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listPiiEntitiesDetectionJobsRequest(
      filter: Option[PiiEntitiesDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListPiiEntitiesDetectionJobsRequest =
      ListPiiEntitiesDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listPiiEntitiesDetectionJobsResponse(
      piiEntitiesDetectionJobPropertiesList: Option[List[PiiEntitiesDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListPiiEntitiesDetectionJobsResponse =
      ListPiiEntitiesDetectionJobsResponse
        .builder
        .ifSome(piiEntitiesDetectionJobPropertiesList)(_.piiEntitiesDetectionJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSentimentDetectionJobsRequest(
      filter: Option[SentimentDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSentimentDetectionJobsRequest =
      ListSentimentDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSentimentDetectionJobsResponse(
      sentimentDetectionJobPropertiesList: Option[List[SentimentDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListSentimentDetectionJobsResponse =
      ListSentimentDetectionJobsResponse
        .builder
        .ifSome(sentimentDetectionJobPropertiesList)(_.sentimentDetectionJobPropertiesList(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def listTopicsDetectionJobsRequest(
      filter: Option[TopicsDetectionJobFilter] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTopicsDetectionJobsRequest =
      ListTopicsDetectionJobsRequest
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTopicsDetectionJobsResponse(
      topicsDetectionJobPropertiesList: Option[List[TopicsDetectionJobProperties]] = None,
      nextToken: Option[String] = None
    ): ListTopicsDetectionJobsResponse =
      ListTopicsDetectionJobsResponse
        .builder
        .ifSome(topicsDetectionJobPropertiesList)(_.topicsDetectionJobPropertiesList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def outputDataConfig(
      s3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): OutputDataConfig =
      OutputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def partOfSpeechTag(
      tag: Option[String] = None,
      score: Option[Float] = None
    ): PartOfSpeechTag =
      PartOfSpeechTag
        .builder
        .ifSome(tag)(_.tag(_))
        .ifSome(score)(_.score(_))
        .build

    def piiEntitiesDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): PiiEntitiesDetectionJobFilter =
      PiiEntitiesDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def piiEntitiesDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[PiiOutputDataConfig] = None,
      redactionConfig: Option[RedactionConfig] = None,
      languageCode: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      mode: Option[String] = None
    ): PiiEntitiesDetectionJobProperties =
      PiiEntitiesDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(redactionConfig)(_.redactionConfig(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(mode)(_.mode(_))
        .build

    def piiEntity(
      score: Option[Float] = None,
      `type`: Option[String] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None
    ): PiiEntity =
      PiiEntity
        .builder
        .ifSome(score)(_.score(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .build

    def piiOutputDataConfig(
      s3Uri: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): PiiOutputDataConfig =
      PiiOutputDataConfig
        .builder
        .ifSome(s3Uri)(_.s3Uri(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def redactionConfig(
      piiEntityTypes: Option[List[PiiEntityType]] = None,
      maskMode: Option[String] = None,
      maskCharacter: Option[String] = None
    ): RedactionConfig =
      RedactionConfig
        .builder
        .ifSome(piiEntityTypes)(_.piiEntityTypes(_))
        .ifSome(maskMode)(_.maskMode(_))
        .ifSome(maskCharacter)(_.maskCharacter(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceLimitExceededException(
      message: Option[String] = None
    ): ResourceLimitExceededException =
      ResourceLimitExceededException
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

    def resourceUnavailableException(
      message: Option[String] = None
    ): ResourceUnavailableException =
      ResourceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sentimentDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): SentimentDetectionJobFilter =
      SentimentDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def sentimentDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      languageCode: Option[String] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): SentimentDetectionJobProperties =
      SentimentDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def sentimentScore(
      positive: Option[Float] = None,
      negative: Option[Float] = None,
      neutral: Option[Float] = None,
      mixed: Option[Float] = None
    ): SentimentScore =
      SentimentScore
        .builder
        .ifSome(positive)(_.positive(_))
        .ifSome(negative)(_.negative(_))
        .ifSome(neutral)(_.neutral(_))
        .ifSome(mixed)(_.mixed(_))
        .build

    def startDocumentClassificationJobRequest(
      jobName: Option[String] = None,
      documentClassifierArn: Option[String] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      clientRequestToken: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): StartDocumentClassificationJobRequest =
      StartDocumentClassificationJobRequest
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def startDocumentClassificationJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartDocumentClassificationJobResponse =
      StartDocumentClassificationJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startDominantLanguageDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      clientRequestToken: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): StartDominantLanguageDetectionJobRequest =
      StartDominantLanguageDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def startDominantLanguageDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartDominantLanguageDetectionJobResponse =
      StartDominantLanguageDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startEntitiesDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      entityRecognizerArn: Option[String] = None,
      languageCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): StartEntitiesDetectionJobRequest =
      StartEntitiesDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def startEntitiesDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartEntitiesDetectionJobResponse =
      StartEntitiesDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startEventsDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      languageCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      targetEventTypes: Option[List[EventTypeString]] = None
    ): StartEventsDetectionJobRequest =
      StartEventsDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(targetEventTypes)(_.targetEventTypes(_))
        .build

    def startEventsDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartEventsDetectionJobResponse =
      StartEventsDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startKeyPhrasesDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      languageCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): StartKeyPhrasesDetectionJobRequest =
      StartKeyPhrasesDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def startKeyPhrasesDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartKeyPhrasesDetectionJobResponse =
      StartKeyPhrasesDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startPiiEntitiesDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      mode: Option[String] = None,
      redactionConfig: Option[RedactionConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      languageCode: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): StartPiiEntitiesDetectionJobRequest =
      StartPiiEntitiesDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(mode)(_.mode(_))
        .ifSome(redactionConfig)(_.redactionConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def startPiiEntitiesDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartPiiEntitiesDetectionJobResponse =
      StartPiiEntitiesDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startSentimentDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      languageCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): StartSentimentDetectionJobRequest =
      StartSentimentDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(languageCode)(_.languageCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def startSentimentDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartSentimentDetectionJobResponse =
      StartSentimentDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def startTopicsDetectionJobRequest(
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      dataAccessRoleArn: Option[String] = None,
      jobName: Option[String] = None,
      numberOfTopics: Option[Int] = None,
      clientRequestToken: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): StartTopicsDetectionJobRequest =
      StartTopicsDetectionJobRequest
        .builder
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(numberOfTopics)(_.numberOfTopics(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def startTopicsDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StartTopicsDetectionJobResponse =
      StartTopicsDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopDominantLanguageDetectionJobRequest(
      jobId: Option[String] = None
    ): StopDominantLanguageDetectionJobRequest =
      StopDominantLanguageDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopDominantLanguageDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopDominantLanguageDetectionJobResponse =
      StopDominantLanguageDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopEntitiesDetectionJobRequest(
      jobId: Option[String] = None
    ): StopEntitiesDetectionJobRequest =
      StopEntitiesDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopEntitiesDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopEntitiesDetectionJobResponse =
      StopEntitiesDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopEventsDetectionJobRequest(
      jobId: Option[String] = None
    ): StopEventsDetectionJobRequest =
      StopEventsDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopEventsDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopEventsDetectionJobResponse =
      StopEventsDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopKeyPhrasesDetectionJobRequest(
      jobId: Option[String] = None
    ): StopKeyPhrasesDetectionJobRequest =
      StopKeyPhrasesDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopKeyPhrasesDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopKeyPhrasesDetectionJobResponse =
      StopKeyPhrasesDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopPiiEntitiesDetectionJobRequest(
      jobId: Option[String] = None
    ): StopPiiEntitiesDetectionJobRequest =
      StopPiiEntitiesDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopPiiEntitiesDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopPiiEntitiesDetectionJobResponse =
      StopPiiEntitiesDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopSentimentDetectionJobRequest(
      jobId: Option[String] = None
    ): StopSentimentDetectionJobRequest =
      StopSentimentDetectionJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopSentimentDetectionJobResponse(
      jobId: Option[String] = None,
      jobStatus: Option[String] = None
    ): StopSentimentDetectionJobResponse =
      StopSentimentDetectionJobResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .build

    def stopTrainingDocumentClassifierRequest(
      documentClassifierArn: Option[String] = None
    ): StopTrainingDocumentClassifierRequest =
      StopTrainingDocumentClassifierRequest
        .builder
        .ifSome(documentClassifierArn)(_.documentClassifierArn(_))
        .build

    def stopTrainingDocumentClassifierResponse(

    ): StopTrainingDocumentClassifierResponse =
      StopTrainingDocumentClassifierResponse
        .builder

        .build

    def stopTrainingEntityRecognizerRequest(
      entityRecognizerArn: Option[String] = None
    ): StopTrainingEntityRecognizerRequest =
      StopTrainingEntityRecognizerRequest
        .builder
        .ifSome(entityRecognizerArn)(_.entityRecognizerArn(_))
        .build

    def stopTrainingEntityRecognizerResponse(

    ): StopTrainingEntityRecognizerResponse =
      StopTrainingEntityRecognizerResponse
        .builder

        .build

    def syntaxToken(
      tokenId: Option[Int] = None,
      text: Option[String] = None,
      beginOffset: Option[Int] = None,
      endOffset: Option[Int] = None,
      partOfSpeech: Option[PartOfSpeechTag] = None
    ): SyntaxToken =
      SyntaxToken
        .builder
        .ifSome(tokenId)(_.tokenId(_))
        .ifSome(text)(_.text(_))
        .ifSome(beginOffset)(_.beginOffset(_))
        .ifSome(endOffset)(_.endOffset(_))
        .ifSome(partOfSpeech)(_.partOfSpeech(_))
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

    def textSizeLimitExceededException(
      message: Option[String] = None
    ): TextSizeLimitExceededException =
      TextSizeLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagKeysException(
      message: Option[String] = None
    ): TooManyTagKeysException =
      TooManyTagKeysException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tooManyTagsException(
      message: Option[String] = None
    ): TooManyTagsException =
      TooManyTagsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def topicsDetectionJobFilter(
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      submitTimeBefore: Option[Timestamp] = None,
      submitTimeAfter: Option[Timestamp] = None
    ): TopicsDetectionJobFilter =
      TopicsDetectionJobFilter
        .builder
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(submitTimeBefore)(_.submitTimeBefore(_))
        .ifSome(submitTimeAfter)(_.submitTimeAfter(_))
        .build

    def topicsDetectionJobProperties(
      jobId: Option[String] = None,
      jobName: Option[String] = None,
      jobStatus: Option[String] = None,
      message: Option[String] = None,
      submitTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      inputDataConfig: Option[InputDataConfig] = None,
      outputDataConfig: Option[OutputDataConfig] = None,
      numberOfTopics: Option[Int] = None,
      dataAccessRoleArn: Option[String] = None,
      volumeKmsKeyId: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None
    ): TopicsDetectionJobProperties =
      TopicsDetectionJobProperties
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobName)(_.jobName(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(message)(_.message(_))
        .ifSome(submitTime)(_.submitTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(inputDataConfig)(_.inputDataConfig(_))
        .ifSome(outputDataConfig)(_.outputDataConfig(_))
        .ifSome(numberOfTopics)(_.numberOfTopics(_))
        .ifSome(dataAccessRoleArn)(_.dataAccessRoleArn(_))
        .ifSome(volumeKmsKeyId)(_.volumeKmsKeyId(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def unsupportedLanguageException(
      message: Option[String] = None
    ): UnsupportedLanguageException =
      UnsupportedLanguageException
        .builder
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

    def updateEndpointRequest(
      endpointArn: Option[String] = None,
      desiredInferenceUnits: Option[Int] = None
    ): UpdateEndpointRequest =
      UpdateEndpointRequest
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(desiredInferenceUnits)(_.desiredInferenceUnits(_))
        .build

    def updateEndpointResponse(

    ): UpdateEndpointResponse =
      UpdateEndpointResponse
        .builder

        .build

    def vpcConfig(
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      subnets: Option[List[SubnetId]] = None
    ): VpcConfig =
      VpcConfig
        .builder
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(subnets)(_.subnets(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
