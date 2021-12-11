package goober.hi

import goober.free.cognitosync.CognitoSyncIO
import software.amazon.awssdk.services.cognitosync.model._


object cognitosync {
  import goober.free.{cognitosync ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def alreadyStreamedException(
      message: Option[String] = None
    ): AlreadyStreamedException =
      AlreadyStreamedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def bulkPublishRequest(
      identityPoolId: Option[String] = None
    ): BulkPublishRequest =
      BulkPublishRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def bulkPublishResponse(
      identityPoolId: Option[String] = None
    ): BulkPublishResponse =
      BulkPublishResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def cognitoStreams(
      streamName: Option[String] = None,
      roleArn: Option[String] = None,
      streamingStatus: Option[String] = None
    ): CognitoStreams =
      CognitoStreams
        .builder
        .ifSome(streamName)(_.streamName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(streamingStatus)(_.streamingStatus(_))
        .build

    def concurrentModificationException(
      message: Option[String] = None
    ): ConcurrentModificationException =
      ConcurrentModificationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dataset(
      identityId: Option[String] = None,
      datasetName: Option[String] = None,
      creationDate: Option[Date] = None,
      lastModifiedDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      dataStorage: Option[Long] = None,
      numRecords: Option[Long] = None
    ): Dataset =
      Dataset
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(dataStorage)(_.dataStorage(_))
        .ifSome(numRecords)(_.numRecords(_))
        .build

    def deleteDatasetRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      datasetName: Option[String] = None
    ): DeleteDatasetRequest =
      DeleteDatasetRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def deleteDatasetResponse(
      dataset: Option[Dataset] = None
    ): DeleteDatasetResponse =
      DeleteDatasetResponse
        .builder
        .ifSome(dataset)(_.dataset(_))
        .build

    def describeDatasetRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      datasetName: Option[String] = None
    ): DescribeDatasetRequest =
      DescribeDatasetRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .build

    def describeDatasetResponse(
      dataset: Option[Dataset] = None
    ): DescribeDatasetResponse =
      DescribeDatasetResponse
        .builder
        .ifSome(dataset)(_.dataset(_))
        .build

    def describeIdentityPoolUsageRequest(
      identityPoolId: Option[String] = None
    ): DescribeIdentityPoolUsageRequest =
      DescribeIdentityPoolUsageRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def describeIdentityPoolUsageResponse(
      identityPoolUsage: Option[IdentityPoolUsage] = None
    ): DescribeIdentityPoolUsageResponse =
      DescribeIdentityPoolUsageResponse
        .builder
        .ifSome(identityPoolUsage)(_.identityPoolUsage(_))
        .build

    def describeIdentityUsageRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None
    ): DescribeIdentityUsageRequest =
      DescribeIdentityUsageRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .build

    def describeIdentityUsageResponse(
      identityUsage: Option[IdentityUsage] = None
    ): DescribeIdentityUsageResponse =
      DescribeIdentityUsageResponse
        .builder
        .ifSome(identityUsage)(_.identityUsage(_))
        .build

    def duplicateRequestException(
      message: Option[String] = None
    ): DuplicateRequestException =
      DuplicateRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def getBulkPublishDetailsRequest(
      identityPoolId: Option[String] = None
    ): GetBulkPublishDetailsRequest =
      GetBulkPublishDetailsRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def getBulkPublishDetailsResponse(
      identityPoolId: Option[String] = None,
      bulkPublishStartTime: Option[Date] = None,
      bulkPublishCompleteTime: Option[Date] = None,
      bulkPublishStatus: Option[String] = None,
      failureMessage: Option[String] = None
    ): GetBulkPublishDetailsResponse =
      GetBulkPublishDetailsResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(bulkPublishStartTime)(_.bulkPublishStartTime(_))
        .ifSome(bulkPublishCompleteTime)(_.bulkPublishCompleteTime(_))
        .ifSome(bulkPublishStatus)(_.bulkPublishStatus(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .build

    def getCognitoEventsRequest(
      identityPoolId: Option[String] = None
    ): GetCognitoEventsRequest =
      GetCognitoEventsRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def getCognitoEventsResponse(
      events: Option[Events] = None
    ): GetCognitoEventsResponse =
      GetCognitoEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .build

    def getIdentityPoolConfigurationRequest(
      identityPoolId: Option[String] = None
    ): GetIdentityPoolConfigurationRequest =
      GetIdentityPoolConfigurationRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .build

    def getIdentityPoolConfigurationResponse(
      identityPoolId: Option[String] = None,
      pushSync: Option[PushSync] = None,
      cognitoStreams: Option[CognitoStreams] = None
    ): GetIdentityPoolConfigurationResponse =
      GetIdentityPoolConfigurationResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(pushSync)(_.pushSync(_))
        .ifSome(cognitoStreams)(_.cognitoStreams(_))
        .build

    def identityPoolUsage(
      identityPoolId: Option[String] = None,
      syncSessionsCount: Option[Long] = None,
      dataStorage: Option[Long] = None,
      lastModifiedDate: Option[Date] = None
    ): IdentityPoolUsage =
      IdentityPoolUsage
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(syncSessionsCount)(_.syncSessionsCount(_))
        .ifSome(dataStorage)(_.dataStorage(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def identityUsage(
      identityId: Option[String] = None,
      identityPoolId: Option[String] = None,
      lastModifiedDate: Option[Date] = None,
      datasetCount: Option[Int] = None,
      dataStorage: Option[Long] = None
    ): IdentityUsage =
      IdentityUsage
        .builder
        .ifSome(identityId)(_.identityId(_))
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(datasetCount)(_.datasetCount(_))
        .ifSome(dataStorage)(_.dataStorage(_))
        .build

    def internalErrorException(
      message: Option[String] = None
    ): InternalErrorException =
      InternalErrorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidConfigurationException(
      message: Option[String] = None
    ): InvalidConfigurationException =
      InvalidConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidLambdaFunctionOutputException(
      message: Option[String] = None
    ): InvalidLambdaFunctionOutputException =
      InvalidLambdaFunctionOutputException
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

    def lambdaThrottledException(
      message: Option[String] = None
    ): LambdaThrottledException =
      LambdaThrottledException
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

    def listDatasetsRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDatasetsRequest =
      ListDatasetsRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDatasetsResponse(
      datasets: Option[List[Dataset]] = None,
      count: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDatasetsResponse =
      ListDatasetsResponse
        .builder
        .ifSome(datasets)(_.datasets(_))
        .ifSome(count)(_.count(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listIdentityPoolUsageRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIdentityPoolUsageRequest =
      ListIdentityPoolUsageRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIdentityPoolUsageResponse(
      identityPoolUsages: Option[List[IdentityPoolUsage]] = None,
      maxResults: Option[Int] = None,
      count: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListIdentityPoolUsageResponse =
      ListIdentityPoolUsageResponse
        .builder
        .ifSome(identityPoolUsages)(_.identityPoolUsages(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(count)(_.count(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecordsRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      datasetName: Option[String] = None,
      lastSyncCount: Option[Long] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      syncSessionToken: Option[String] = None
    ): ListRecordsRequest =
      ListRecordsRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(lastSyncCount)(_.lastSyncCount(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(syncSessionToken)(_.syncSessionToken(_))
        .build

    def listRecordsResponse(
      records: Option[List[Record]] = None,
      nextToken: Option[String] = None,
      count: Option[Int] = None,
      datasetSyncCount: Option[Long] = None,
      lastModifiedBy: Option[String] = None,
      mergedDatasetNames: Option[List[String]] = None,
      datasetExists: Option[Boolean] = None,
      datasetDeletedAfterRequestedSyncCount: Option[Boolean] = None,
      syncSessionToken: Option[String] = None
    ): ListRecordsResponse =
      ListRecordsResponse
        .builder
        .ifSome(records)(_.records(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(count)(_.count(_))
        .ifSome(datasetSyncCount)(_.datasetSyncCount(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(mergedDatasetNames)(_.mergedDatasetNames(_))
        .ifSome(datasetExists)(_.datasetExists(_))
        .ifSome(datasetDeletedAfterRequestedSyncCount)(_.datasetDeletedAfterRequestedSyncCount(_))
        .ifSome(syncSessionToken)(_.syncSessionToken(_))
        .build

    def notAuthorizedException(
      message: Option[String] = None
    ): NotAuthorizedException =
      NotAuthorizedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def pushSync(
      applicationArns: Option[List[ApplicationArn]] = None,
      roleArn: Option[String] = None
    ): PushSync =
      PushSync
        .builder
        .ifSome(applicationArns)(_.applicationArns(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def record(
      key: Option[String] = None,
      value: Option[String] = None,
      syncCount: Option[Long] = None,
      lastModifiedDate: Option[Date] = None,
      lastModifiedBy: Option[String] = None,
      deviceLastModifiedDate: Option[Date] = None
    ): Record =
      Record
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(syncCount)(_.syncCount(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(lastModifiedBy)(_.lastModifiedBy(_))
        .ifSome(deviceLastModifiedDate)(_.deviceLastModifiedDate(_))
        .build

    def recordPatch(
      op: Option[String] = None,
      key: Option[String] = None,
      value: Option[String] = None,
      syncCount: Option[Long] = None,
      deviceLastModifiedDate: Option[Date] = None
    ): RecordPatch =
      RecordPatch
        .builder
        .ifSome(op)(_.op(_))
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .ifSome(syncCount)(_.syncCount(_))
        .ifSome(deviceLastModifiedDate)(_.deviceLastModifiedDate(_))
        .build

    def registerDeviceRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      platform: Option[String] = None,
      token: Option[String] = None
    ): RegisterDeviceRequest =
      RegisterDeviceRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(token)(_.token(_))
        .build

    def registerDeviceResponse(
      deviceId: Option[String] = None
    ): RegisterDeviceResponse =
      RegisterDeviceResponse
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def resourceConflictException(
      message: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
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

    def setCognitoEventsRequest(
      identityPoolId: Option[String] = None,
      events: Option[Events] = None
    ): SetCognitoEventsRequest =
      SetCognitoEventsRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(events)(_.events(_))
        .build

    def setIdentityPoolConfigurationRequest(
      identityPoolId: Option[String] = None,
      pushSync: Option[PushSync] = None,
      cognitoStreams: Option[CognitoStreams] = None
    ): SetIdentityPoolConfigurationRequest =
      SetIdentityPoolConfigurationRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(pushSync)(_.pushSync(_))
        .ifSome(cognitoStreams)(_.cognitoStreams(_))
        .build

    def setIdentityPoolConfigurationResponse(
      identityPoolId: Option[String] = None,
      pushSync: Option[PushSync] = None,
      cognitoStreams: Option[CognitoStreams] = None
    ): SetIdentityPoolConfigurationResponse =
      SetIdentityPoolConfigurationResponse
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(pushSync)(_.pushSync(_))
        .ifSome(cognitoStreams)(_.cognitoStreams(_))
        .build

    def subscribeToDatasetRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      datasetName: Option[String] = None,
      deviceId: Option[String] = None
    ): SubscribeToDatasetRequest =
      SubscribeToDatasetRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def subscribeToDatasetResponse(

    ): SubscribeToDatasetResponse =
      SubscribeToDatasetResponse
        .builder

        .build

    def tooManyRequestsException(
      message: Option[String] = None
    ): TooManyRequestsException =
      TooManyRequestsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def unsubscribeFromDatasetRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      datasetName: Option[String] = None,
      deviceId: Option[String] = None
    ): UnsubscribeFromDatasetRequest =
      UnsubscribeFromDatasetRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def unsubscribeFromDatasetResponse(

    ): UnsubscribeFromDatasetResponse =
      UnsubscribeFromDatasetResponse
        .builder

        .build

    def updateRecordsRequest(
      identityPoolId: Option[String] = None,
      identityId: Option[String] = None,
      datasetName: Option[String] = None,
      deviceId: Option[String] = None,
      recordPatches: Option[List[RecordPatch]] = None,
      syncSessionToken: Option[String] = None,
      clientContext: Option[String] = None
    ): UpdateRecordsRequest =
      UpdateRecordsRequest
        .builder
        .ifSome(identityPoolId)(_.identityPoolId(_))
        .ifSome(identityId)(_.identityId(_))
        .ifSome(datasetName)(_.datasetName(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(recordPatches)(_.recordPatches(_))
        .ifSome(syncSessionToken)(_.syncSessionToken(_))
        .ifSome(clientContext)(_.clientContext(_))
        .build

    def updateRecordsResponse(
      records: Option[List[Record]] = None
    ): UpdateRecordsResponse =
      UpdateRecordsResponse
        .builder
        .ifSome(records)(_.records(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
