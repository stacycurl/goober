package goober.hi

import goober.free.textract.TextractIO
import software.amazon.awssdk.services.textract.model._


object textract {
  import goober.free.{textract ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(

    ): AccessDeniedException =
      AccessDeniedException
        .builder

        .build

    def analyzeDocumentRequest(
      document: Option[Document] = None,
      featureTypes: Option[List[FeatureType]] = None,
      humanLoopConfig: Option[HumanLoopConfig] = None
    ): AnalyzeDocumentRequest =
      AnalyzeDocumentRequest
        .builder
        .ifSome(document)(_.document(_))
        .ifSome(featureTypes)(_.featureTypes(_))
        .ifSome(humanLoopConfig)(_.humanLoopConfig(_))
        .build

    def analyzeDocumentResponse(
      documentMetadata: Option[DocumentMetadata] = None,
      blocks: Option[List[Block]] = None,
      humanLoopActivationOutput: Option[HumanLoopActivationOutput] = None,
      analyzeDocumentModelVersion: Option[String] = None
    ): AnalyzeDocumentResponse =
      AnalyzeDocumentResponse
        .builder
        .ifSome(documentMetadata)(_.documentMetadata(_))
        .ifSome(blocks)(_.blocks(_))
        .ifSome(humanLoopActivationOutput)(_.humanLoopActivationOutput(_))
        .ifSome(analyzeDocumentModelVersion)(_.analyzeDocumentModelVersion(_))
        .build

    def badDocumentException(

    ): BadDocumentException =
      BadDocumentException
        .builder

        .build

    def block(
      blockType: Option[String] = None,
      confidence: Option[Percent] = None,
      text: Option[String] = None,
      textType: Option[String] = None,
      rowIndex: Option[Int] = None,
      columnIndex: Option[Int] = None,
      rowSpan: Option[Int] = None,
      columnSpan: Option[Int] = None,
      geometry: Option[Geometry] = None,
      id: Option[String] = None,
      relationships: Option[List[Relationship]] = None,
      entityTypes: Option[List[EntityType]] = None,
      selectionStatus: Option[String] = None,
      page: Option[Int] = None
    ): Block =
      Block
        .builder
        .ifSome(blockType)(_.blockType(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(text)(_.text(_))
        .ifSome(textType)(_.textType(_))
        .ifSome(rowIndex)(_.rowIndex(_))
        .ifSome(columnIndex)(_.columnIndex(_))
        .ifSome(rowSpan)(_.rowSpan(_))
        .ifSome(columnSpan)(_.columnSpan(_))
        .ifSome(geometry)(_.geometry(_))
        .ifSome(id)(_.id(_))
        .ifSome(relationships)(_.relationships(_))
        .ifSome(entityTypes)(_.entityTypes(_))
        .ifSome(selectionStatus)(_.selectionStatus(_))
        .ifSome(page)(_.page(_))
        .build

    def boundingBox(
      width: Option[Float] = None,
      height: Option[Float] = None,
      left: Option[Float] = None,
      top: Option[Float] = None
    ): BoundingBox =
      BoundingBox
        .builder
        .ifSome(width)(_.width(_))
        .ifSome(height)(_.height(_))
        .ifSome(left)(_.left(_))
        .ifSome(top)(_.top(_))
        .build

    def detectDocumentTextRequest(
      document: Option[Document] = None
    ): DetectDocumentTextRequest =
      DetectDocumentTextRequest
        .builder
        .ifSome(document)(_.document(_))
        .build

    def detectDocumentTextResponse(
      documentMetadata: Option[DocumentMetadata] = None,
      blocks: Option[List[Block]] = None,
      detectDocumentTextModelVersion: Option[String] = None
    ): DetectDocumentTextResponse =
      DetectDocumentTextResponse
        .builder
        .ifSome(documentMetadata)(_.documentMetadata(_))
        .ifSome(blocks)(_.blocks(_))
        .ifSome(detectDocumentTextModelVersion)(_.detectDocumentTextModelVersion(_))
        .build

    def document(
      bytes: Option[ImageBlob] = None,
      s3Object: Option[S3Object] = None
    ): Document =
      Document
        .builder
        .ifSome(bytes)(_.bytes(_))
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def documentLocation(
      s3Object: Option[S3Object] = None
    ): DocumentLocation =
      DocumentLocation
        .builder
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def documentMetadata(
      pages: Option[Int] = None
    ): DocumentMetadata =
      DocumentMetadata
        .builder
        .ifSome(pages)(_.pages(_))
        .build

    def documentTooLargeException(

    ): DocumentTooLargeException =
      DocumentTooLargeException
        .builder

        .build

    def geometry(
      boundingBox: Option[BoundingBox] = None,
      polygon: Option[List[Point]] = None
    ): Geometry =
      Geometry
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(polygon)(_.polygon(_))
        .build

    def getDocumentAnalysisRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetDocumentAnalysisRequest =
      GetDocumentAnalysisRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDocumentAnalysisResponse(
      documentMetadata: Option[DocumentMetadata] = None,
      jobStatus: Option[String] = None,
      nextToken: Option[String] = None,
      blocks: Option[List[Block]] = None,
      warnings: Option[List[Warning]] = None,
      statusMessage: Option[String] = None,
      analyzeDocumentModelVersion: Option[String] = None
    ): GetDocumentAnalysisResponse =
      GetDocumentAnalysisResponse
        .builder
        .ifSome(documentMetadata)(_.documentMetadata(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(blocks)(_.blocks(_))
        .ifSome(warnings)(_.warnings(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(analyzeDocumentModelVersion)(_.analyzeDocumentModelVersion(_))
        .build

    def getDocumentTextDetectionRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetDocumentTextDetectionRequest =
      GetDocumentTextDetectionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getDocumentTextDetectionResponse(
      documentMetadata: Option[DocumentMetadata] = None,
      jobStatus: Option[String] = None,
      nextToken: Option[String] = None,
      blocks: Option[List[Block]] = None,
      warnings: Option[List[Warning]] = None,
      statusMessage: Option[String] = None,
      detectDocumentTextModelVersion: Option[String] = None
    ): GetDocumentTextDetectionResponse =
      GetDocumentTextDetectionResponse
        .builder
        .ifSome(documentMetadata)(_.documentMetadata(_))
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(blocks)(_.blocks(_))
        .ifSome(warnings)(_.warnings(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(detectDocumentTextModelVersion)(_.detectDocumentTextModelVersion(_))
        .build

    def humanLoopActivationOutput(
      humanLoopArn: Option[String] = None,
      humanLoopActivationReasons: Option[List[HumanLoopActivationReason]] = None,
      humanLoopActivationConditionsEvaluationResults: Option[String] = None
    ): HumanLoopActivationOutput =
      HumanLoopActivationOutput
        .builder
        .ifSome(humanLoopArn)(_.humanLoopArn(_))
        .ifSome(humanLoopActivationReasons)(_.humanLoopActivationReasons(_))
        .ifSome(humanLoopActivationConditionsEvaluationResults)(_.humanLoopActivationConditionsEvaluationResults(_))
        .build

    def humanLoopConfig(
      humanLoopName: Option[String] = None,
      flowDefinitionArn: Option[String] = None,
      dataAttributes: Option[HumanLoopDataAttributes] = None
    ): HumanLoopConfig =
      HumanLoopConfig
        .builder
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .ifSome(dataAttributes)(_.dataAttributes(_))
        .build

    def humanLoopDataAttributes(
      contentClassifiers: Option[List[ContentClassifier]] = None
    ): HumanLoopDataAttributes =
      HumanLoopDataAttributes
        .builder
        .ifSome(contentClassifiers)(_.contentClassifiers(_))
        .build

    def humanLoopQuotaExceededException(
      resourceType: Option[String] = None,
      quotaCode: Option[String] = None,
      serviceCode: Option[String] = None
    ): HumanLoopQuotaExceededException =
      HumanLoopQuotaExceededException
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(quotaCode)(_.quotaCode(_))
        .ifSome(serviceCode)(_.serviceCode(_))
        .build

    def idempotentParameterMismatchException(

    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder

        .build

    def internalServerError(

    ): InternalServerError =
      InternalServerError
        .builder

        .build

    def invalidJobIdException(

    ): InvalidJobIdException =
      InvalidJobIdException
        .builder

        .build

    def invalidKMSKeyException(

    ): InvalidKMSKeyException =
      InvalidKMSKeyException
        .builder

        .build

    def invalidParameterException(

    ): InvalidParameterException =
      InvalidParameterException
        .builder

        .build

    def invalidS3ObjectException(

    ): InvalidS3ObjectException =
      InvalidS3ObjectException
        .builder

        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def notificationChannel(
      sNSTopicArn: Option[String] = None,
      roleArn: Option[String] = None
    ): NotificationChannel =
      NotificationChannel
        .builder
        .ifSome(sNSTopicArn)(_.sNSTopicArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def outputConfig(
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None
    ): OutputConfig =
      OutputConfig
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def point(
      x: Option[Float] = None,
      y: Option[Float] = None
    ): Point =
      Point
        .builder
        .ifSome(x)(_.x(_))
        .ifSome(y)(_.y(_))
        .build

    def provisionedThroughputExceededException(

    ): ProvisionedThroughputExceededException =
      ProvisionedThroughputExceededException
        .builder

        .build

    def relationship(
      `type`: Option[String] = None,
      ids: Option[List[NonEmptyString]] = None
    ): Relationship =
      Relationship
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(ids)(_.ids(_))
        .build

    def s3Object(
      bucket: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None
    ): S3Object =
      S3Object
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def startDocumentAnalysisRequest(
      documentLocation: Option[DocumentLocation] = None,
      featureTypes: Option[List[FeatureType]] = None,
      clientRequestToken: Option[String] = None,
      jobTag: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      outputConfig: Option[OutputConfig] = None,
      kMSKeyId: Option[String] = None
    ): StartDocumentAnalysisRequest =
      StartDocumentAnalysisRequest
        .builder
        .ifSome(documentLocation)(_.documentLocation(_))
        .ifSome(featureTypes)(_.featureTypes(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(jobTag)(_.jobTag(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(kMSKeyId)(_.kMSKeyId(_))
        .build

    def startDocumentAnalysisResponse(
      jobId: Option[String] = None
    ): StartDocumentAnalysisResponse =
      StartDocumentAnalysisResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startDocumentTextDetectionRequest(
      documentLocation: Option[DocumentLocation] = None,
      clientRequestToken: Option[String] = None,
      jobTag: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      outputConfig: Option[OutputConfig] = None,
      kMSKeyId: Option[String] = None
    ): StartDocumentTextDetectionRequest =
      StartDocumentTextDetectionRequest
        .builder
        .ifSome(documentLocation)(_.documentLocation(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(jobTag)(_.jobTag(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(kMSKeyId)(_.kMSKeyId(_))
        .build

    def startDocumentTextDetectionResponse(
      jobId: Option[String] = None
    ): StartDocumentTextDetectionResponse =
      StartDocumentTextDetectionResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def throttlingException(

    ): ThrottlingException =
      ThrottlingException
        .builder

        .build

    def unsupportedDocumentException(

    ): UnsupportedDocumentException =
      UnsupportedDocumentException
        .builder

        .build

    def warning(
      errorCode: Option[String] = None,
      pages: Option[List[UInteger]] = None
    ): Warning =
      Warning
        .builder
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(pages)(_.pages(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
