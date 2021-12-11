package goober.hi

import goober.free.rekognition.RekognitionIO
import software.amazon.awssdk.services.rekognition.model._


object rekognition {
  import goober.free.{rekognition ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(

    ): AccessDeniedException =
      AccessDeniedException
        .builder

        .build

    def ageRange(
      low: Option[Int] = None,
      high: Option[Int] = None
    ): AgeRange =
      AgeRange
        .builder
        .ifSome(low)(_.low(_))
        .ifSome(high)(_.high(_))
        .build

    def asset(
      groundTruthManifest: Option[GroundTruthManifest] = None
    ): Asset =
      Asset
        .builder
        .ifSome(groundTruthManifest)(_.groundTruthManifest(_))
        .build

    def audioMetadata(
      codec: Option[String] = None,
      durationMillis: Option[ULong] = None,
      sampleRate: Option[ULong] = None,
      numberOfChannels: Option[ULong] = None
    ): AudioMetadata =
      AudioMetadata
        .builder
        .ifSome(codec)(_.codec(_))
        .ifSome(durationMillis)(_.durationMillis(_))
        .ifSome(sampleRate)(_.sampleRate(_))
        .ifSome(numberOfChannels)(_.numberOfChannels(_))
        .build

    def beard(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): Beard =
      Beard
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
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

    def celebrity(
      urls: Option[List[Url]] = None,
      name: Option[String] = None,
      id: Option[String] = None,
      face: Option[ComparedFace] = None,
      matchConfidence: Option[Percent] = None
    ): Celebrity =
      Celebrity
        .builder
        .ifSome(urls)(_.urls(_))
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(face)(_.face(_))
        .ifSome(matchConfidence)(_.matchConfidence(_))
        .build

    def celebrityDetail(
      urls: Option[List[Url]] = None,
      name: Option[String] = None,
      id: Option[String] = None,
      confidence: Option[Percent] = None,
      boundingBox: Option[BoundingBox] = None,
      face: Option[FaceDetail] = None
    ): CelebrityDetail =
      CelebrityDetail
        .builder
        .ifSome(urls)(_.urls(_))
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(face)(_.face(_))
        .build

    def celebrityRecognition(
      timestamp: Option[Timestamp] = None,
      celebrity: Option[CelebrityDetail] = None
    ): CelebrityRecognition =
      CelebrityRecognition
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(celebrity)(_.celebrity(_))
        .build

    def compareFacesMatch(
      similarity: Option[Percent] = None,
      face: Option[ComparedFace] = None
    ): CompareFacesMatch =
      CompareFacesMatch
        .builder
        .ifSome(similarity)(_.similarity(_))
        .ifSome(face)(_.face(_))
        .build

    def compareFacesRequest(
      sourceImage: Option[Image] = None,
      targetImage: Option[Image] = None,
      similarityThreshold: Option[Percent] = None,
      qualityFilter: Option[String] = None
    ): CompareFacesRequest =
      CompareFacesRequest
        .builder
        .ifSome(sourceImage)(_.sourceImage(_))
        .ifSome(targetImage)(_.targetImage(_))
        .ifSome(similarityThreshold)(_.similarityThreshold(_))
        .ifSome(qualityFilter)(_.qualityFilter(_))
        .build

    def compareFacesResponse(
      sourceImageFace: Option[ComparedSourceImageFace] = None,
      faceMatches: Option[List[CompareFacesMatch]] = None,
      unmatchedFaces: Option[List[ComparedFace]] = None,
      sourceImageOrientationCorrection: Option[String] = None,
      targetImageOrientationCorrection: Option[String] = None
    ): CompareFacesResponse =
      CompareFacesResponse
        .builder
        .ifSome(sourceImageFace)(_.sourceImageFace(_))
        .ifSome(faceMatches)(_.faceMatches(_))
        .ifSome(unmatchedFaces)(_.unmatchedFaces(_))
        .ifSome(sourceImageOrientationCorrection)(_.sourceImageOrientationCorrection(_))
        .ifSome(targetImageOrientationCorrection)(_.targetImageOrientationCorrection(_))
        .build

    def comparedFace(
      boundingBox: Option[BoundingBox] = None,
      confidence: Option[Percent] = None,
      landmarks: Option[List[Landmark]] = None,
      pose: Option[Pose] = None,
      quality: Option[ImageQuality] = None
    ): ComparedFace =
      ComparedFace
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(landmarks)(_.landmarks(_))
        .ifSome(pose)(_.pose(_))
        .ifSome(quality)(_.quality(_))
        .build

    def comparedSourceImageFace(
      boundingBox: Option[BoundingBox] = None,
      confidence: Option[Percent] = None
    ): ComparedSourceImageFace =
      ComparedSourceImageFace
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def contentModerationDetection(
      timestamp: Option[Timestamp] = None,
      moderationLabel: Option[ModerationLabel] = None
    ): ContentModerationDetection =
      ContentModerationDetection
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(moderationLabel)(_.moderationLabel(_))
        .build

    def coversBodyPart(
      confidence: Option[Percent] = None,
      value: Option[Boolean] = None
    ): CoversBodyPart =
      CoversBodyPart
        .builder
        .ifSome(confidence)(_.confidence(_))
        .ifSome(value)(_.value(_))
        .build

    def createCollectionRequest(
      collectionId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateCollectionRequest =
      CreateCollectionRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCollectionResponse(
      statusCode: Option[Int] = None,
      collectionArn: Option[String] = None,
      faceModelVersion: Option[String] = None
    ): CreateCollectionResponse =
      CreateCollectionResponse
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(collectionArn)(_.collectionArn(_))
        .ifSome(faceModelVersion)(_.faceModelVersion(_))
        .build

    def createProjectRequest(
      projectName: Option[String] = None
    ): CreateProjectRequest =
      CreateProjectRequest
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def createProjectResponse(
      projectArn: Option[String] = None
    ): CreateProjectResponse =
      CreateProjectResponse
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def createProjectVersionRequest(
      projectArn: Option[String] = None,
      versionName: Option[String] = None,
      outputConfig: Option[OutputConfig] = None,
      trainingData: Option[TrainingData] = None,
      testingData: Option[TestingData] = None,
      tags: Option[TagMap] = None,
      kmsKeyId: Option[String] = None
    ): CreateProjectVersionRequest =
      CreateProjectVersionRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(versionName)(_.versionName(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(trainingData)(_.trainingData(_))
        .ifSome(testingData)(_.testingData(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def createProjectVersionResponse(
      projectVersionArn: Option[String] = None
    ): CreateProjectVersionResponse =
      CreateProjectVersionResponse
        .builder
        .ifSome(projectVersionArn)(_.projectVersionArn(_))
        .build

    def createStreamProcessorRequest(
      input: Option[StreamProcessorInput] = None,
      output: Option[StreamProcessorOutput] = None,
      name: Option[String] = None,
      settings: Option[StreamProcessorSettings] = None,
      roleArn: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateStreamProcessorRequest =
      CreateStreamProcessorRequest
        .builder
        .ifSome(input)(_.input(_))
        .ifSome(output)(_.output(_))
        .ifSome(name)(_.name(_))
        .ifSome(settings)(_.settings(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamProcessorResponse(
      streamProcessorArn: Option[String] = None
    ): CreateStreamProcessorResponse =
      CreateStreamProcessorResponse
        .builder
        .ifSome(streamProcessorArn)(_.streamProcessorArn(_))
        .build

    def customLabel(
      name: Option[String] = None,
      confidence: Option[Percent] = None,
      geometry: Option[Geometry] = None
    ): CustomLabel =
      CustomLabel
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(geometry)(_.geometry(_))
        .build

    def deleteCollectionRequest(
      collectionId: Option[String] = None
    ): DeleteCollectionRequest =
      DeleteCollectionRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .build

    def deleteCollectionResponse(
      statusCode: Option[Int] = None
    ): DeleteCollectionResponse =
      DeleteCollectionResponse
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def deleteFacesRequest(
      collectionId: Option[String] = None,
      faceIds: Option[List[FaceId]] = None
    ): DeleteFacesRequest =
      DeleteFacesRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(faceIds)(_.faceIds(_))
        .build

    def deleteFacesResponse(
      deletedFaces: Option[List[FaceId]] = None
    ): DeleteFacesResponse =
      DeleteFacesResponse
        .builder
        .ifSome(deletedFaces)(_.deletedFaces(_))
        .build

    def deleteProjectRequest(
      projectArn: Option[String] = None
    ): DeleteProjectRequest =
      DeleteProjectRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .build

    def deleteProjectResponse(
      status: Option[String] = None
    ): DeleteProjectResponse =
      DeleteProjectResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def deleteProjectVersionRequest(
      projectVersionArn: Option[String] = None
    ): DeleteProjectVersionRequest =
      DeleteProjectVersionRequest
        .builder
        .ifSome(projectVersionArn)(_.projectVersionArn(_))
        .build

    def deleteProjectVersionResponse(
      status: Option[String] = None
    ): DeleteProjectVersionResponse =
      DeleteProjectVersionResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def deleteStreamProcessorRequest(
      name: Option[String] = None
    ): DeleteStreamProcessorRequest =
      DeleteStreamProcessorRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteStreamProcessorResponse(

    ): DeleteStreamProcessorResponse =
      DeleteStreamProcessorResponse
        .builder

        .build

    def describeCollectionRequest(
      collectionId: Option[String] = None
    ): DescribeCollectionRequest =
      DescribeCollectionRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .build

    def describeCollectionResponse(
      faceCount: Option[ULong] = None,
      faceModelVersion: Option[String] = None,
      collectionARN: Option[String] = None,
      creationTimestamp: Option[DateTime] = None
    ): DescribeCollectionResponse =
      DescribeCollectionResponse
        .builder
        .ifSome(faceCount)(_.faceCount(_))
        .ifSome(faceModelVersion)(_.faceModelVersion(_))
        .ifSome(collectionARN)(_.collectionARN(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .build

    def describeProjectVersionsRequest(
      projectArn: Option[String] = None,
      versionNames: Option[List[VersionName]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeProjectVersionsRequest =
      DescribeProjectVersionsRequest
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(versionNames)(_.versionNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeProjectVersionsResponse(
      projectVersionDescriptions: Option[List[ProjectVersionDescription]] = None,
      nextToken: Option[String] = None
    ): DescribeProjectVersionsResponse =
      DescribeProjectVersionsResponse
        .builder
        .ifSome(projectVersionDescriptions)(_.projectVersionDescriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeProjectsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeProjectsRequest =
      DescribeProjectsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeProjectsResponse(
      projectDescriptions: Option[List[ProjectDescription]] = None,
      nextToken: Option[String] = None
    ): DescribeProjectsResponse =
      DescribeProjectsResponse
        .builder
        .ifSome(projectDescriptions)(_.projectDescriptions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStreamProcessorRequest(
      name: Option[String] = None
    ): DescribeStreamProcessorRequest =
      DescribeStreamProcessorRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeStreamProcessorResponse(
      name: Option[String] = None,
      streamProcessorArn: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      lastUpdateTimestamp: Option[DateTime] = None,
      input: Option[StreamProcessorInput] = None,
      output: Option[StreamProcessorOutput] = None,
      roleArn: Option[String] = None,
      settings: Option[StreamProcessorSettings] = None
    ): DescribeStreamProcessorResponse =
      DescribeStreamProcessorResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(streamProcessorArn)(_.streamProcessorArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(lastUpdateTimestamp)(_.lastUpdateTimestamp(_))
        .ifSome(input)(_.input(_))
        .ifSome(output)(_.output(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(settings)(_.settings(_))
        .build

    def detectCustomLabelsRequest(
      projectVersionArn: Option[String] = None,
      image: Option[Image] = None,
      maxResults: Option[Int] = None,
      minConfidence: Option[Percent] = None
    ): DetectCustomLabelsRequest =
      DetectCustomLabelsRequest
        .builder
        .ifSome(projectVersionArn)(_.projectVersionArn(_))
        .ifSome(image)(_.image(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(minConfidence)(_.minConfidence(_))
        .build

    def detectCustomLabelsResponse(
      customLabels: Option[List[CustomLabel]] = None
    ): DetectCustomLabelsResponse =
      DetectCustomLabelsResponse
        .builder
        .ifSome(customLabels)(_.customLabels(_))
        .build

    def detectFacesRequest(
      image: Option[Image] = None,
      attributes: Option[List[Attribute]] = None
    ): DetectFacesRequest =
      DetectFacesRequest
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def detectFacesResponse(
      faceDetails: Option[List[FaceDetail]] = None,
      orientationCorrection: Option[String] = None
    ): DetectFacesResponse =
      DetectFacesResponse
        .builder
        .ifSome(faceDetails)(_.faceDetails(_))
        .ifSome(orientationCorrection)(_.orientationCorrection(_))
        .build

    def detectLabelsRequest(
      image: Option[Image] = None,
      maxLabels: Option[Int] = None,
      minConfidence: Option[Percent] = None
    ): DetectLabelsRequest =
      DetectLabelsRequest
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(maxLabels)(_.maxLabels(_))
        .ifSome(minConfidence)(_.minConfidence(_))
        .build

    def detectLabelsResponse(
      labels: Option[List[Label]] = None,
      orientationCorrection: Option[String] = None,
      labelModelVersion: Option[String] = None
    ): DetectLabelsResponse =
      DetectLabelsResponse
        .builder
        .ifSome(labels)(_.labels(_))
        .ifSome(orientationCorrection)(_.orientationCorrection(_))
        .ifSome(labelModelVersion)(_.labelModelVersion(_))
        .build

    def detectModerationLabelsRequest(
      image: Option[Image] = None,
      minConfidence: Option[Percent] = None,
      humanLoopConfig: Option[HumanLoopConfig] = None
    ): DetectModerationLabelsRequest =
      DetectModerationLabelsRequest
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(minConfidence)(_.minConfidence(_))
        .ifSome(humanLoopConfig)(_.humanLoopConfig(_))
        .build

    def detectModerationLabelsResponse(
      moderationLabels: Option[List[ModerationLabel]] = None,
      moderationModelVersion: Option[String] = None,
      humanLoopActivationOutput: Option[HumanLoopActivationOutput] = None
    ): DetectModerationLabelsResponse =
      DetectModerationLabelsResponse
        .builder
        .ifSome(moderationLabels)(_.moderationLabels(_))
        .ifSome(moderationModelVersion)(_.moderationModelVersion(_))
        .ifSome(humanLoopActivationOutput)(_.humanLoopActivationOutput(_))
        .build

    def detectProtectiveEquipmentRequest(
      image: Option[Image] = None,
      summarizationAttributes: Option[ProtectiveEquipmentSummarizationAttributes] = None
    ): DetectProtectiveEquipmentRequest =
      DetectProtectiveEquipmentRequest
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(summarizationAttributes)(_.summarizationAttributes(_))
        .build

    def detectProtectiveEquipmentResponse(
      protectiveEquipmentModelVersion: Option[String] = None,
      persons: Option[List[ProtectiveEquipmentPerson]] = None,
      summary: Option[ProtectiveEquipmentSummary] = None
    ): DetectProtectiveEquipmentResponse =
      DetectProtectiveEquipmentResponse
        .builder
        .ifSome(protectiveEquipmentModelVersion)(_.protectiveEquipmentModelVersion(_))
        .ifSome(persons)(_.persons(_))
        .ifSome(summary)(_.summary(_))
        .build

    def detectTextFilters(
      wordFilter: Option[DetectionFilter] = None,
      regionsOfInterest: Option[List[RegionOfInterest]] = None
    ): DetectTextFilters =
      DetectTextFilters
        .builder
        .ifSome(wordFilter)(_.wordFilter(_))
        .ifSome(regionsOfInterest)(_.regionsOfInterest(_))
        .build

    def detectTextRequest(
      image: Option[Image] = None,
      filters: Option[DetectTextFilters] = None
    ): DetectTextRequest =
      DetectTextRequest
        .builder
        .ifSome(image)(_.image(_))
        .ifSome(filters)(_.filters(_))
        .build

    def detectTextResponse(
      textDetections: Option[List[TextDetection]] = None,
      textModelVersion: Option[String] = None
    ): DetectTextResponse =
      DetectTextResponse
        .builder
        .ifSome(textDetections)(_.textDetections(_))
        .ifSome(textModelVersion)(_.textModelVersion(_))
        .build

    def detectionFilter(
      minConfidence: Option[Percent] = None,
      minBoundingBoxHeight: Option[BoundingBoxHeight] = None,
      minBoundingBoxWidth: Option[BoundingBoxWidth] = None
    ): DetectionFilter =
      DetectionFilter
        .builder
        .ifSome(minConfidence)(_.minConfidence(_))
        .ifSome(minBoundingBoxHeight)(_.minBoundingBoxHeight(_))
        .ifSome(minBoundingBoxWidth)(_.minBoundingBoxWidth(_))
        .build

    def emotion(
      `type`: Option[String] = None,
      confidence: Option[Percent] = None
    ): Emotion =
      Emotion
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def equipmentDetection(
      boundingBox: Option[BoundingBox] = None,
      confidence: Option[Percent] = None,
      `type`: Option[String] = None,
      coversBodyPart: Option[CoversBodyPart] = None
    ): EquipmentDetection =
      EquipmentDetection
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(coversBodyPart)(_.coversBodyPart(_))
        .build

    def eyeOpen(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): EyeOpen =
      EyeOpen
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def eyeglasses(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): Eyeglasses =
      Eyeglasses
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def face(
      faceId: Option[String] = None,
      boundingBox: Option[BoundingBox] = None,
      imageId: Option[String] = None,
      externalImageId: Option[String] = None,
      confidence: Option[Percent] = None
    ): Face =
      Face
        .builder
        .ifSome(faceId)(_.faceId(_))
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(imageId)(_.imageId(_))
        .ifSome(externalImageId)(_.externalImageId(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def faceDetail(
      boundingBox: Option[BoundingBox] = None,
      ageRange: Option[AgeRange] = None,
      smile: Option[Smile] = None,
      eyeglasses: Option[Eyeglasses] = None,
      sunglasses: Option[Sunglasses] = None,
      gender: Option[Gender] = None,
      beard: Option[Beard] = None,
      mustache: Option[Mustache] = None,
      eyesOpen: Option[EyeOpen] = None,
      mouthOpen: Option[MouthOpen] = None,
      emotions: Option[List[Emotion]] = None,
      landmarks: Option[List[Landmark]] = None,
      pose: Option[Pose] = None,
      quality: Option[ImageQuality] = None,
      confidence: Option[Percent] = None
    ): FaceDetail =
      FaceDetail
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(ageRange)(_.ageRange(_))
        .ifSome(smile)(_.smile(_))
        .ifSome(eyeglasses)(_.eyeglasses(_))
        .ifSome(sunglasses)(_.sunglasses(_))
        .ifSome(gender)(_.gender(_))
        .ifSome(beard)(_.beard(_))
        .ifSome(mustache)(_.mustache(_))
        .ifSome(eyesOpen)(_.eyesOpen(_))
        .ifSome(mouthOpen)(_.mouthOpen(_))
        .ifSome(emotions)(_.emotions(_))
        .ifSome(landmarks)(_.landmarks(_))
        .ifSome(pose)(_.pose(_))
        .ifSome(quality)(_.quality(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def faceDetection(
      timestamp: Option[Timestamp] = None,
      face: Option[FaceDetail] = None
    ): FaceDetection =
      FaceDetection
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(face)(_.face(_))
        .build

    def faceMatch(
      similarity: Option[Percent] = None,
      face: Option[Face] = None
    ): FaceMatch =
      FaceMatch
        .builder
        .ifSome(similarity)(_.similarity(_))
        .ifSome(face)(_.face(_))
        .build

    def faceRecord(
      face: Option[Face] = None,
      faceDetail: Option[FaceDetail] = None
    ): FaceRecord =
      FaceRecord
        .builder
        .ifSome(face)(_.face(_))
        .ifSome(faceDetail)(_.faceDetail(_))
        .build

    def faceSearchSettings(
      collectionId: Option[String] = None,
      faceMatchThreshold: Option[Percent] = None
    ): FaceSearchSettings =
      FaceSearchSettings
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(faceMatchThreshold)(_.faceMatchThreshold(_))
        .build

    def gender(
      value: Option[String] = None,
      confidence: Option[Percent] = None
    ): Gender =
      Gender
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
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

    def getCelebrityInfoRequest(
      id: Option[String] = None
    ): GetCelebrityInfoRequest =
      GetCelebrityInfoRequest
        .builder
        .ifSome(id)(_.id(_))
        .build

    def getCelebrityInfoResponse(
      urls: Option[List[Url]] = None,
      name: Option[String] = None
    ): GetCelebrityInfoResponse =
      GetCelebrityInfoResponse
        .builder
        .ifSome(urls)(_.urls(_))
        .ifSome(name)(_.name(_))
        .build

    def getCelebrityRecognitionRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None
    ): GetCelebrityRecognitionRequest =
      GetCelebrityRecognitionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getCelebrityRecognitionResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      nextToken: Option[String] = None,
      celebrities: Option[List[CelebrityRecognition]] = None
    ): GetCelebrityRecognitionResponse =
      GetCelebrityRecognitionResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(celebrities)(_.celebrities(_))
        .build

    def getContentModerationRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None
    ): GetContentModerationRequest =
      GetContentModerationRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getContentModerationResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      moderationLabels: Option[List[ContentModerationDetection]] = None,
      nextToken: Option[String] = None,
      moderationModelVersion: Option[String] = None
    ): GetContentModerationResponse =
      GetContentModerationResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(moderationLabels)(_.moderationLabels(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(moderationModelVersion)(_.moderationModelVersion(_))
        .build

    def getFaceDetectionRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetFaceDetectionRequest =
      GetFaceDetectionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getFaceDetectionResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      nextToken: Option[String] = None,
      faces: Option[List[FaceDetection]] = None
    ): GetFaceDetectionResponse =
      GetFaceDetectionResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(faces)(_.faces(_))
        .build

    def getFaceSearchRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None
    ): GetFaceSearchRequest =
      GetFaceSearchRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getFaceSearchResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      nextToken: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      persons: Option[List[PersonMatch]] = None
    ): GetFaceSearchResponse =
      GetFaceSearchResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(persons)(_.persons(_))
        .build

    def getLabelDetectionRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None
    ): GetLabelDetectionRequest =
      GetLabelDetectionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getLabelDetectionResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      nextToken: Option[String] = None,
      labels: Option[List[LabelDetection]] = None,
      labelModelVersion: Option[String] = None
    ): GetLabelDetectionResponse =
      GetLabelDetectionResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(labels)(_.labels(_))
        .ifSome(labelModelVersion)(_.labelModelVersion(_))
        .build

    def getPersonTrackingRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      sortBy: Option[String] = None
    ): GetPersonTrackingRequest =
      GetPersonTrackingRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortBy)(_.sortBy(_))
        .build

    def getPersonTrackingResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      nextToken: Option[String] = None,
      persons: Option[List[PersonDetection]] = None
    ): GetPersonTrackingResponse =
      GetPersonTrackingResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(persons)(_.persons(_))
        .build

    def getSegmentDetectionRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetSegmentDetectionRequest =
      GetSegmentDetectionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getSegmentDetectionResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[List[VideoMetadata]] = None,
      audioMetadata: Option[List[AudioMetadata]] = None,
      nextToken: Option[String] = None,
      segments: Option[List[SegmentDetection]] = None,
      selectedSegmentTypes: Option[List[SegmentTypeInfo]] = None
    ): GetSegmentDetectionResponse =
      GetSegmentDetectionResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(audioMetadata)(_.audioMetadata(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(segments)(_.segments(_))
        .ifSome(selectedSegmentTypes)(_.selectedSegmentTypes(_))
        .build

    def getTextDetectionRequest(
      jobId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetTextDetectionRequest =
      GetTextDetectionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getTextDetectionResponse(
      jobStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      videoMetadata: Option[VideoMetadata] = None,
      textDetections: Option[List[TextDetectionResult]] = None,
      nextToken: Option[String] = None,
      textModelVersion: Option[String] = None
    ): GetTextDetectionResponse =
      GetTextDetectionResponse
        .builder
        .ifSome(jobStatus)(_.jobStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(videoMetadata)(_.videoMetadata(_))
        .ifSome(textDetections)(_.textDetections(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(textModelVersion)(_.textModelVersion(_))
        .build

    def groundTruthManifest(
      s3Object: Option[S3Object] = None
    ): GroundTruthManifest =
      GroundTruthManifest
        .builder
        .ifSome(s3Object)(_.s3Object(_))
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

    def image(
      bytes: Option[ImageBlob] = None,
      s3Object: Option[S3Object] = None
    ): Image =
      Image
        .builder
        .ifSome(bytes)(_.bytes(_))
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def imageQuality(
      brightness: Option[Float] = None,
      sharpness: Option[Float] = None
    ): ImageQuality =
      ImageQuality
        .builder
        .ifSome(brightness)(_.brightness(_))
        .ifSome(sharpness)(_.sharpness(_))
        .build

    def imageTooLargeException(

    ): ImageTooLargeException =
      ImageTooLargeException
        .builder

        .build

    def indexFacesRequest(
      collectionId: Option[String] = None,
      image: Option[Image] = None,
      externalImageId: Option[String] = None,
      detectionAttributes: Option[List[Attribute]] = None,
      maxFaces: Option[Int] = None,
      qualityFilter: Option[String] = None
    ): IndexFacesRequest =
      IndexFacesRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(image)(_.image(_))
        .ifSome(externalImageId)(_.externalImageId(_))
        .ifSome(detectionAttributes)(_.detectionAttributes(_))
        .ifSome(maxFaces)(_.maxFaces(_))
        .ifSome(qualityFilter)(_.qualityFilter(_))
        .build

    def indexFacesResponse(
      faceRecords: Option[List[FaceRecord]] = None,
      orientationCorrection: Option[String] = None,
      faceModelVersion: Option[String] = None,
      unindexedFaces: Option[List[UnindexedFace]] = None
    ): IndexFacesResponse =
      IndexFacesResponse
        .builder
        .ifSome(faceRecords)(_.faceRecords(_))
        .ifSome(orientationCorrection)(_.orientationCorrection(_))
        .ifSome(faceModelVersion)(_.faceModelVersion(_))
        .ifSome(unindexedFaces)(_.unindexedFaces(_))
        .build

    def instance(
      boundingBox: Option[BoundingBox] = None,
      confidence: Option[Percent] = None
    ): Instance =
      Instance
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def internalServerError(

    ): InternalServerError =
      InternalServerError
        .builder

        .build

    def invalidImageFormatException(

    ): InvalidImageFormatException =
      InvalidImageFormatException
        .builder

        .build

    def invalidPaginationTokenException(

    ): InvalidPaginationTokenException =
      InvalidPaginationTokenException
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

    def kinesisDataStream(
      arn: Option[String] = None
    ): KinesisDataStream =
      KinesisDataStream
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def kinesisVideoStream(
      arn: Option[String] = None
    ): KinesisVideoStream =
      KinesisVideoStream
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def label(
      name: Option[String] = None,
      confidence: Option[Percent] = None,
      instances: Option[List[Instance]] = None,
      parents: Option[List[Parent]] = None
    ): Label =
      Label
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(instances)(_.instances(_))
        .ifSome(parents)(_.parents(_))
        .build

    def labelDetection(
      timestamp: Option[Timestamp] = None,
      label: Option[Label] = None
    ): LabelDetection =
      LabelDetection
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(label)(_.label(_))
        .build

    def landmark(
      `type`: Option[String] = None,
      x: Option[Float] = None,
      y: Option[Float] = None
    ): Landmark =
      Landmark
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(x)(_.x(_))
        .ifSome(y)(_.y(_))
        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listCollectionsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCollectionsRequest =
      ListCollectionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCollectionsResponse(
      collectionIds: Option[List[CollectionId]] = None,
      nextToken: Option[String] = None,
      faceModelVersions: Option[List[String]] = None
    ): ListCollectionsResponse =
      ListCollectionsResponse
        .builder
        .ifSome(collectionIds)(_.collectionIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(faceModelVersions)(_.faceModelVersions(_))
        .build

    def listFacesRequest(
      collectionId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListFacesRequest =
      ListFacesRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listFacesResponse(
      faces: Option[List[Face]] = None,
      nextToken: Option[String] = None,
      faceModelVersion: Option[String] = None
    ): ListFacesResponse =
      ListFacesResponse
        .builder
        .ifSome(faces)(_.faces(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(faceModelVersion)(_.faceModelVersion(_))
        .build

    def listStreamProcessorsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListStreamProcessorsRequest =
      ListStreamProcessorsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listStreamProcessorsResponse(
      nextToken: Option[String] = None,
      streamProcessors: Option[List[StreamProcessor]] = None
    ): ListStreamProcessorsResponse =
      ListStreamProcessorsResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(streamProcessors)(_.streamProcessors(_))
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

    def moderationLabel(
      confidence: Option[Percent] = None,
      name: Option[String] = None,
      parentName: Option[String] = None
    ): ModerationLabel =
      ModerationLabel
        .builder
        .ifSome(confidence)(_.confidence(_))
        .ifSome(name)(_.name(_))
        .ifSome(parentName)(_.parentName(_))
        .build

    def mouthOpen(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): MouthOpen =
      MouthOpen
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def mustache(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): Mustache =
      Mustache
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
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
      s3KeyPrefix: Option[String] = None
    ): OutputConfig =
      OutputConfig
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3KeyPrefix)(_.s3KeyPrefix(_))
        .build

    def parent(
      name: Option[String] = None
    ): Parent =
      Parent
        .builder
        .ifSome(name)(_.name(_))
        .build

    def personDetail(
      index: Option[PersonIndex] = None,
      boundingBox: Option[BoundingBox] = None,
      face: Option[FaceDetail] = None
    ): PersonDetail =
      PersonDetail
        .builder
        .ifSome(index)(_.index(_))
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(face)(_.face(_))
        .build

    def personDetection(
      timestamp: Option[Timestamp] = None,
      person: Option[PersonDetail] = None
    ): PersonDetection =
      PersonDetection
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(person)(_.person(_))
        .build

    def personMatch(
      timestamp: Option[Timestamp] = None,
      person: Option[PersonDetail] = None,
      faceMatches: Option[List[FaceMatch]] = None
    ): PersonMatch =
      PersonMatch
        .builder
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(person)(_.person(_))
        .ifSome(faceMatches)(_.faceMatches(_))
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

    def pose(
      roll: Option[Degree] = None,
      yaw: Option[Degree] = None,
      pitch: Option[Degree] = None
    ): Pose =
      Pose
        .builder
        .ifSome(roll)(_.roll(_))
        .ifSome(yaw)(_.yaw(_))
        .ifSome(pitch)(_.pitch(_))
        .build

    def projectDescription(
      projectArn: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      status: Option[String] = None
    ): ProjectDescription =
      ProjectDescription
        .builder
        .ifSome(projectArn)(_.projectArn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(status)(_.status(_))
        .build

    def projectVersionDescription(
      projectVersionArn: Option[String] = None,
      creationTimestamp: Option[DateTime] = None,
      minInferenceUnits: Option[Int] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      billableTrainingTimeInSeconds: Option[ULong] = None,
      trainingEndTimestamp: Option[DateTime] = None,
      outputConfig: Option[OutputConfig] = None,
      trainingDataResult: Option[TrainingDataResult] = None,
      testingDataResult: Option[TestingDataResult] = None,
      evaluationResult: Option[EvaluationResult] = None,
      manifestSummary: Option[GroundTruthManifest] = None,
      kmsKeyId: Option[String] = None
    ): ProjectVersionDescription =
      ProjectVersionDescription
        .builder
        .ifSome(projectVersionArn)(_.projectVersionArn(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(minInferenceUnits)(_.minInferenceUnits(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(billableTrainingTimeInSeconds)(_.billableTrainingTimeInSeconds(_))
        .ifSome(trainingEndTimestamp)(_.trainingEndTimestamp(_))
        .ifSome(outputConfig)(_.outputConfig(_))
        .ifSome(trainingDataResult)(_.trainingDataResult(_))
        .ifSome(testingDataResult)(_.testingDataResult(_))
        .ifSome(evaluationResult)(_.evaluationResult(_))
        .ifSome(manifestSummary)(_.manifestSummary(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def protectiveEquipmentBodyPart(
      name: Option[String] = None,
      confidence: Option[Percent] = None,
      equipmentDetections: Option[List[EquipmentDetection]] = None
    ): ProtectiveEquipmentBodyPart =
      ProtectiveEquipmentBodyPart
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(equipmentDetections)(_.equipmentDetections(_))
        .build

    def protectiveEquipmentPerson(
      bodyParts: Option[List[ProtectiveEquipmentBodyPart]] = None,
      boundingBox: Option[BoundingBox] = None,
      confidence: Option[Percent] = None,
      id: Option[Int] = None
    ): ProtectiveEquipmentPerson =
      ProtectiveEquipmentPerson
        .builder
        .ifSome(bodyParts)(_.bodyParts(_))
        .ifSome(boundingBox)(_.boundingBox(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(id)(_.id(_))
        .build

    def protectiveEquipmentSummarizationAttributes(
      minConfidence: Option[Percent] = None,
      requiredEquipmentTypes: Option[List[ProtectiveEquipmentType]] = None
    ): ProtectiveEquipmentSummarizationAttributes =
      ProtectiveEquipmentSummarizationAttributes
        .builder
        .ifSome(minConfidence)(_.minConfidence(_))
        .ifSome(requiredEquipmentTypes)(_.requiredEquipmentTypes(_))
        .build

    def protectiveEquipmentSummary(
      personsWithRequiredEquipment: Option[List[UInteger]] = None,
      personsWithoutRequiredEquipment: Option[List[UInteger]] = None,
      personsIndeterminate: Option[List[UInteger]] = None
    ): ProtectiveEquipmentSummary =
      ProtectiveEquipmentSummary
        .builder
        .ifSome(personsWithRequiredEquipment)(_.personsWithRequiredEquipment(_))
        .ifSome(personsWithoutRequiredEquipment)(_.personsWithoutRequiredEquipment(_))
        .ifSome(personsIndeterminate)(_.personsIndeterminate(_))
        .build

    def provisionedThroughputExceededException(

    ): ProvisionedThroughputExceededException =
      ProvisionedThroughputExceededException
        .builder

        .build

    def recognizeCelebritiesRequest(
      image: Option[Image] = None
    ): RecognizeCelebritiesRequest =
      RecognizeCelebritiesRequest
        .builder
        .ifSome(image)(_.image(_))
        .build

    def recognizeCelebritiesResponse(
      celebrityFaces: Option[List[Celebrity]] = None,
      unrecognizedFaces: Option[List[ComparedFace]] = None,
      orientationCorrection: Option[String] = None
    ): RecognizeCelebritiesResponse =
      RecognizeCelebritiesResponse
        .builder
        .ifSome(celebrityFaces)(_.celebrityFaces(_))
        .ifSome(unrecognizedFaces)(_.unrecognizedFaces(_))
        .ifSome(orientationCorrection)(_.orientationCorrection(_))
        .build

    def regionOfInterest(
      boundingBox: Option[BoundingBox] = None
    ): RegionOfInterest =
      RegionOfInterest
        .builder
        .ifSome(boundingBox)(_.boundingBox(_))
        .build

    def resourceAlreadyExistsException(

    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder

        .build

    def resourceInUseException(

    ): ResourceInUseException =
      ResourceInUseException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def resourceNotReadyException(

    ): ResourceNotReadyException =
      ResourceNotReadyException
        .builder

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

    def searchFacesByImageRequest(
      collectionId: Option[String] = None,
      image: Option[Image] = None,
      maxFaces: Option[Int] = None,
      faceMatchThreshold: Option[Percent] = None,
      qualityFilter: Option[String] = None
    ): SearchFacesByImageRequest =
      SearchFacesByImageRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(image)(_.image(_))
        .ifSome(maxFaces)(_.maxFaces(_))
        .ifSome(faceMatchThreshold)(_.faceMatchThreshold(_))
        .ifSome(qualityFilter)(_.qualityFilter(_))
        .build

    def searchFacesByImageResponse(
      searchedFaceBoundingBox: Option[BoundingBox] = None,
      searchedFaceConfidence: Option[Percent] = None,
      faceMatches: Option[List[FaceMatch]] = None,
      faceModelVersion: Option[String] = None
    ): SearchFacesByImageResponse =
      SearchFacesByImageResponse
        .builder
        .ifSome(searchedFaceBoundingBox)(_.searchedFaceBoundingBox(_))
        .ifSome(searchedFaceConfidence)(_.searchedFaceConfidence(_))
        .ifSome(faceMatches)(_.faceMatches(_))
        .ifSome(faceModelVersion)(_.faceModelVersion(_))
        .build

    def searchFacesRequest(
      collectionId: Option[String] = None,
      faceId: Option[String] = None,
      maxFaces: Option[Int] = None,
      faceMatchThreshold: Option[Percent] = None
    ): SearchFacesRequest =
      SearchFacesRequest
        .builder
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(faceId)(_.faceId(_))
        .ifSome(maxFaces)(_.maxFaces(_))
        .ifSome(faceMatchThreshold)(_.faceMatchThreshold(_))
        .build

    def searchFacesResponse(
      searchedFaceId: Option[String] = None,
      faceMatches: Option[List[FaceMatch]] = None,
      faceModelVersion: Option[String] = None
    ): SearchFacesResponse =
      SearchFacesResponse
        .builder
        .ifSome(searchedFaceId)(_.searchedFaceId(_))
        .ifSome(faceMatches)(_.faceMatches(_))
        .ifSome(faceModelVersion)(_.faceModelVersion(_))
        .build

    def segmentDetection(
      `type`: Option[String] = None,
      startTimestampMillis: Option[Timestamp] = None,
      endTimestampMillis: Option[Timestamp] = None,
      durationMillis: Option[ULong] = None,
      startTimecodeSMPTE: Option[String] = None,
      endTimecodeSMPTE: Option[String] = None,
      durationSMPTE: Option[String] = None,
      technicalCueSegment: Option[TechnicalCueSegment] = None,
      shotSegment: Option[ShotSegment] = None
    ): SegmentDetection =
      SegmentDetection
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(startTimestampMillis)(_.startTimestampMillis(_))
        .ifSome(endTimestampMillis)(_.endTimestampMillis(_))
        .ifSome(durationMillis)(_.durationMillis(_))
        .ifSome(startTimecodeSMPTE)(_.startTimecodeSMPTE(_))
        .ifSome(endTimecodeSMPTE)(_.endTimecodeSMPTE(_))
        .ifSome(durationSMPTE)(_.durationSMPTE(_))
        .ifSome(technicalCueSegment)(_.technicalCueSegment(_))
        .ifSome(shotSegment)(_.shotSegment(_))
        .build

    def segmentTypeInfo(
      `type`: Option[String] = None,
      modelVersion: Option[String] = None
    ): SegmentTypeInfo =
      SegmentTypeInfo
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(modelVersion)(_.modelVersion(_))
        .build

    def serviceQuotaExceededException(

    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder

        .build

    def shotSegment(
      index: Option[ULong] = None,
      confidence: Option[SegmentConfidence] = None
    ): ShotSegment =
      ShotSegment
        .builder
        .ifSome(index)(_.index(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def smile(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): Smile =
      Smile
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def startCelebrityRecognitionRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None
    ): StartCelebrityRecognitionRequest =
      StartCelebrityRecognitionRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .build

    def startCelebrityRecognitionResponse(
      jobId: Option[String] = None
    ): StartCelebrityRecognitionResponse =
      StartCelebrityRecognitionResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startContentModerationRequest(
      video: Option[Video] = None,
      minConfidence: Option[Percent] = None,
      clientRequestToken: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None
    ): StartContentModerationRequest =
      StartContentModerationRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(minConfidence)(_.minConfidence(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .build

    def startContentModerationResponse(
      jobId: Option[String] = None
    ): StartContentModerationResponse =
      StartContentModerationResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startFaceDetectionRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      faceAttributes: Option[String] = None,
      jobTag: Option[String] = None
    ): StartFaceDetectionRequest =
      StartFaceDetectionRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(faceAttributes)(_.faceAttributes(_))
        .ifSome(jobTag)(_.jobTag(_))
        .build

    def startFaceDetectionResponse(
      jobId: Option[String] = None
    ): StartFaceDetectionResponse =
      StartFaceDetectionResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startFaceSearchRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      faceMatchThreshold: Option[Percent] = None,
      collectionId: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None
    ): StartFaceSearchRequest =
      StartFaceSearchRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(faceMatchThreshold)(_.faceMatchThreshold(_))
        .ifSome(collectionId)(_.collectionId(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .build

    def startFaceSearchResponse(
      jobId: Option[String] = None
    ): StartFaceSearchResponse =
      StartFaceSearchResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startLabelDetectionRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      minConfidence: Option[Percent] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None
    ): StartLabelDetectionRequest =
      StartLabelDetectionRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(minConfidence)(_.minConfidence(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .build

    def startLabelDetectionResponse(
      jobId: Option[String] = None
    ): StartLabelDetectionResponse =
      StartLabelDetectionResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startPersonTrackingRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None
    ): StartPersonTrackingRequest =
      StartPersonTrackingRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .build

    def startPersonTrackingResponse(
      jobId: Option[String] = None
    ): StartPersonTrackingResponse =
      StartPersonTrackingResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startProjectVersionRequest(
      projectVersionArn: Option[String] = None,
      minInferenceUnits: Option[Int] = None
    ): StartProjectVersionRequest =
      StartProjectVersionRequest
        .builder
        .ifSome(projectVersionArn)(_.projectVersionArn(_))
        .ifSome(minInferenceUnits)(_.minInferenceUnits(_))
        .build

    def startProjectVersionResponse(
      status: Option[String] = None
    ): StartProjectVersionResponse =
      StartProjectVersionResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def startSegmentDetectionFilters(
      technicalCueFilter: Option[StartTechnicalCueDetectionFilter] = None,
      shotFilter: Option[StartShotDetectionFilter] = None
    ): StartSegmentDetectionFilters =
      StartSegmentDetectionFilters
        .builder
        .ifSome(technicalCueFilter)(_.technicalCueFilter(_))
        .ifSome(shotFilter)(_.shotFilter(_))
        .build

    def startSegmentDetectionRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None,
      filters: Option[StartSegmentDetectionFilters] = None,
      segmentTypes: Option[List[SegmentType]] = None
    ): StartSegmentDetectionRequest =
      StartSegmentDetectionRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(segmentTypes)(_.segmentTypes(_))
        .build

    def startSegmentDetectionResponse(
      jobId: Option[String] = None
    ): StartSegmentDetectionResponse =
      StartSegmentDetectionResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def startShotDetectionFilter(
      minSegmentConfidence: Option[SegmentConfidence] = None
    ): StartShotDetectionFilter =
      StartShotDetectionFilter
        .builder
        .ifSome(minSegmentConfidence)(_.minSegmentConfidence(_))
        .build

    def startStreamProcessorRequest(
      name: Option[String] = None
    ): StartStreamProcessorRequest =
      StartStreamProcessorRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startStreamProcessorResponse(

    ): StartStreamProcessorResponse =
      StartStreamProcessorResponse
        .builder

        .build

    def startTechnicalCueDetectionFilter(
      minSegmentConfidence: Option[SegmentConfidence] = None
    ): StartTechnicalCueDetectionFilter =
      StartTechnicalCueDetectionFilter
        .builder
        .ifSome(minSegmentConfidence)(_.minSegmentConfidence(_))
        .build

    def startTextDetectionFilters(
      wordFilter: Option[DetectionFilter] = None,
      regionsOfInterest: Option[List[RegionOfInterest]] = None
    ): StartTextDetectionFilters =
      StartTextDetectionFilters
        .builder
        .ifSome(wordFilter)(_.wordFilter(_))
        .ifSome(regionsOfInterest)(_.regionsOfInterest(_))
        .build

    def startTextDetectionRequest(
      video: Option[Video] = None,
      clientRequestToken: Option[String] = None,
      notificationChannel: Option[NotificationChannel] = None,
      jobTag: Option[String] = None,
      filters: Option[StartTextDetectionFilters] = None
    ): StartTextDetectionRequest =
      StartTextDetectionRequest
        .builder
        .ifSome(video)(_.video(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(notificationChannel)(_.notificationChannel(_))
        .ifSome(jobTag)(_.jobTag(_))
        .ifSome(filters)(_.filters(_))
        .build

    def startTextDetectionResponse(
      jobId: Option[String] = None
    ): StartTextDetectionResponse =
      StartTextDetectionResponse
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def stopProjectVersionRequest(
      projectVersionArn: Option[String] = None
    ): StopProjectVersionRequest =
      StopProjectVersionRequest
        .builder
        .ifSome(projectVersionArn)(_.projectVersionArn(_))
        .build

    def stopProjectVersionResponse(
      status: Option[String] = None
    ): StopProjectVersionResponse =
      StopProjectVersionResponse
        .builder
        .ifSome(status)(_.status(_))
        .build

    def stopStreamProcessorRequest(
      name: Option[String] = None
    ): StopStreamProcessorRequest =
      StopStreamProcessorRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopStreamProcessorResponse(

    ): StopStreamProcessorResponse =
      StopStreamProcessorResponse
        .builder

        .build

    def streamProcessor(
      name: Option[String] = None,
      status: Option[String] = None
    ): StreamProcessor =
      StreamProcessor
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .build

    def streamProcessorInput(
      kinesisVideoStream: Option[KinesisVideoStream] = None
    ): StreamProcessorInput =
      StreamProcessorInput
        .builder
        .ifSome(kinesisVideoStream)(_.kinesisVideoStream(_))
        .build

    def streamProcessorOutput(
      kinesisDataStream: Option[KinesisDataStream] = None
    ): StreamProcessorOutput =
      StreamProcessorOutput
        .builder
        .ifSome(kinesisDataStream)(_.kinesisDataStream(_))
        .build

    def streamProcessorSettings(
      faceSearch: Option[FaceSearchSettings] = None
    ): StreamProcessorSettings =
      StreamProcessorSettings
        .builder
        .ifSome(faceSearch)(_.faceSearch(_))
        .build

    def summary(
      s3Object: Option[S3Object] = None
    ): Summary =
      Summary
        .builder
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def sunglasses(
      value: Option[Boolean] = None,
      confidence: Option[Percent] = None
    ): Sunglasses =
      Sunglasses
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(confidence)(_.confidence(_))
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

    def technicalCueSegment(
      `type`: Option[String] = None,
      confidence: Option[SegmentConfidence] = None
    ): TechnicalCueSegment =
      TechnicalCueSegment
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(confidence)(_.confidence(_))
        .build

    def testingData(
      assets: Option[List[Asset]] = None,
      autoCreate: Option[Boolean] = None
    ): TestingData =
      TestingData
        .builder
        .ifSome(assets)(_.assets(_))
        .ifSome(autoCreate)(_.autoCreate(_))
        .build

    def textDetection(
      detectedText: Option[String] = None,
      `type`: Option[String] = None,
      id: Option[Int] = None,
      parentId: Option[Int] = None,
      confidence: Option[Percent] = None,
      geometry: Option[Geometry] = None
    ): TextDetection =
      TextDetection
        .builder
        .ifSome(detectedText)(_.detectedText(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(confidence)(_.confidence(_))
        .ifSome(geometry)(_.geometry(_))
        .build

    def throttlingException(

    ): ThrottlingException =
      ThrottlingException
        .builder

        .build

    def trainingData(
      assets: Option[List[Asset]] = None
    ): TrainingData =
      TrainingData
        .builder
        .ifSome(assets)(_.assets(_))
        .build

    def unindexedFace(
      reasons: Option[List[Reason]] = None,
      faceDetail: Option[FaceDetail] = None
    ): UnindexedFace =
      UnindexedFace
        .builder
        .ifSome(reasons)(_.reasons(_))
        .ifSome(faceDetail)(_.faceDetail(_))
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

    def validationData(
      assets: Option[List[Asset]] = None
    ): ValidationData =
      ValidationData
        .builder
        .ifSome(assets)(_.assets(_))
        .build

    def video(
      s3Object: Option[S3Object] = None
    ): Video =
      Video
        .builder
        .ifSome(s3Object)(_.s3Object(_))
        .build

    def videoMetadata(
      codec: Option[String] = None,
      durationMillis: Option[ULong] = None,
      format: Option[String] = None,
      frameRate: Option[Float] = None,
      frameHeight: Option[ULong] = None,
      frameWidth: Option[ULong] = None
    ): VideoMetadata =
      VideoMetadata
        .builder
        .ifSome(codec)(_.codec(_))
        .ifSome(durationMillis)(_.durationMillis(_))
        .ifSome(format)(_.format(_))
        .ifSome(frameRate)(_.frameRate(_))
        .ifSome(frameHeight)(_.frameHeight(_))
        .ifSome(frameWidth)(_.frameWidth(_))
        .build

    def videoTooLargeException(

    ): VideoTooLargeException =
      VideoTooLargeException
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
