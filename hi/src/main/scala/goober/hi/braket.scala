package goober.hi

import goober.free.braket.BraketIO
import software.amazon.awssdk.services.braket.model._


object braket {
  import goober.free.{braket ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accessDeniedException(
      message: Option[String] = None
    ): AccessDeniedException =
      AccessDeniedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelQuantumTaskRequest(
      clientToken: Option[String] = None,
      quantumTaskArn: Option[String] = None
    ): CancelQuantumTaskRequest =
      CancelQuantumTaskRequest
        .builder
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(quantumTaskArn)(_.quantumTaskArn(_))
        .build

    def cancelQuantumTaskResponse(
      cancellationStatus: Option[String] = None,
      quantumTaskArn: Option[String] = None
    ): CancelQuantumTaskResponse =
      CancelQuantumTaskResponse
        .builder
        .ifSome(cancellationStatus)(_.cancellationStatus(_))
        .ifSome(quantumTaskArn)(_.quantumTaskArn(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createQuantumTaskRequest(
      action: Option[String] = None,
      clientToken: Option[String] = None,
      deviceArn: Option[String] = None,
      deviceParameters: Option[String] = None,
      outputS3Bucket: Option[String] = None,
      outputS3KeyPrefix: Option[String] = None,
      shots: Option[CreateQuantumTaskRequestShotsLong] = None,
      tags: Option[TagsMap] = None
    ): CreateQuantumTaskRequest =
      CreateQuantumTaskRequest
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceParameters)(_.deviceParameters(_))
        .ifSome(outputS3Bucket)(_.outputS3Bucket(_))
        .ifSome(outputS3KeyPrefix)(_.outputS3KeyPrefix(_))
        .ifSome(shots)(_.shots(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createQuantumTaskResponse(
      quantumTaskArn: Option[String] = None
    ): CreateQuantumTaskResponse =
      CreateQuantumTaskResponse
        .builder
        .ifSome(quantumTaskArn)(_.quantumTaskArn(_))
        .build

    def deviceOfflineException(
      message: Option[String] = None
    ): DeviceOfflineException =
      DeviceOfflineException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deviceRetiredException(
      message: Option[String] = None
    ): DeviceRetiredException =
      DeviceRetiredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deviceSummary(
      deviceArn: Option[String] = None,
      deviceName: Option[String] = None,
      deviceStatus: Option[String] = None,
      deviceType: Option[String] = None,
      providerName: Option[String] = None
    ): DeviceSummary =
      DeviceSummary
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceStatus)(_.deviceStatus(_))
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def getDeviceRequest(
      deviceArn: Option[String] = None
    ): GetDeviceRequest =
      GetDeviceRequest
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .build

    def getDeviceResponse(
      deviceArn: Option[String] = None,
      deviceCapabilities: Option[String] = None,
      deviceName: Option[String] = None,
      deviceStatus: Option[String] = None,
      deviceType: Option[String] = None,
      providerName: Option[String] = None
    ): GetDeviceResponse =
      GetDeviceResponse
        .builder
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceCapabilities)(_.deviceCapabilities(_))
        .ifSome(deviceName)(_.deviceName(_))
        .ifSome(deviceStatus)(_.deviceStatus(_))
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(providerName)(_.providerName(_))
        .build

    def getQuantumTaskRequest(
      quantumTaskArn: Option[String] = None
    ): GetQuantumTaskRequest =
      GetQuantumTaskRequest
        .builder
        .ifSome(quantumTaskArn)(_.quantumTaskArn(_))
        .build

    def getQuantumTaskResponse(
      createdAt: Option[SyntheticTimestamp_date_time] = None,
      deviceArn: Option[String] = None,
      deviceParameters: Option[String] = None,
      endedAt: Option[SyntheticTimestamp_date_time] = None,
      failureReason: Option[String] = None,
      outputS3Bucket: Option[String] = None,
      outputS3Directory: Option[String] = None,
      quantumTaskArn: Option[String] = None,
      shots: Option[Long] = None,
      status: Option[String] = None,
      tags: Option[TagsMap] = None
    ): GetQuantumTaskResponse =
      GetQuantumTaskResponse
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(deviceParameters)(_.deviceParameters(_))
        .ifSome(endedAt)(_.endedAt(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(outputS3Bucket)(_.outputS3Bucket(_))
        .ifSome(outputS3Directory)(_.outputS3Directory(_))
        .ifSome(quantumTaskArn)(_.quantumTaskArn(_))
        .ifSome(shots)(_.shots(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServiceException(
      message: Option[String] = None
    ): InternalServiceException =
      InternalServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[TagsMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def quantumTaskSummary(
      createdAt: Option[SyntheticTimestamp_date_time] = None,
      deviceArn: Option[String] = None,
      endedAt: Option[SyntheticTimestamp_date_time] = None,
      outputS3Bucket: Option[String] = None,
      outputS3Directory: Option[String] = None,
      quantumTaskArn: Option[String] = None,
      shots: Option[Long] = None,
      status: Option[String] = None,
      tags: Option[TagsMap] = None
    ): QuantumTaskSummary =
      QuantumTaskSummary
        .builder
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deviceArn)(_.deviceArn(_))
        .ifSome(endedAt)(_.endedAt(_))
        .ifSome(outputS3Bucket)(_.outputS3Bucket(_))
        .ifSome(outputS3Directory)(_.outputS3Directory(_))
        .ifSome(quantumTaskArn)(_.quantumTaskArn(_))
        .ifSome(shots)(_.shots(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def searchDevicesFilter(
      name: Option[String] = None,
      values: Option[List[String256]] = None
    ): SearchDevicesFilter =
      SearchDevicesFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def searchDevicesRequest(
      filters: Option[List[SearchDevicesFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchDevicesRequest =
      SearchDevicesRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchDevicesResponse(
      devices: Option[List[DeviceSummary]] = None,
      nextToken: Option[String] = None
    ): SearchDevicesResponse =
      SearchDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchQuantumTasksFilter(
      name: Option[String] = None,
      operator: Option[String] = None,
      values: Option[List[String256]] = None
    ): SearchQuantumTasksFilter =
      SearchQuantumTasksFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(operator)(_.operator(_))
        .ifSome(values)(_.values(_))
        .build

    def searchQuantumTasksRequest(
      filters: Option[List[SearchQuantumTasksFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): SearchQuantumTasksRequest =
      SearchQuantumTasksRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def searchQuantumTasksResponse(
      nextToken: Option[String] = None,
      quantumTasks: Option[List[QuantumTaskSummary]] = None
    ): SearchQuantumTasksResponse =
      SearchQuantumTasksResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(quantumTasks)(_.quantumTasks(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[TagsMap] = None
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

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String]] = None
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

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
