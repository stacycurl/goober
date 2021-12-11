package goober.hi

import goober.free.iot1clickdevices.Iot1ClickDevicesIO
import software.amazon.awssdk.services.iot1clickdevices.model._


object iot1clickdevices {
  import goober.free.{iot1clickdevices ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def attributes(

    ): Attributes =
      Attributes
        .builder

        .build

    def claimDevicesByClaimCodeRequest(
      claimCode: Option[String] = None
    ): ClaimDevicesByClaimCodeRequest =
      ClaimDevicesByClaimCodeRequest
        .builder
        .ifSome(claimCode)(_.claimCode(_))
        .build

    def claimDevicesByClaimCodeResponse(
      claimCode: Option[String] = None,
      total: Option[Int] = None
    ): ClaimDevicesByClaimCodeResponse =
      ClaimDevicesByClaimCodeResponse
        .builder
        .ifSome(claimCode)(_.claimCode(_))
        .ifSome(total)(_.total(_))
        .build

    def describeDeviceRequest(
      deviceId: Option[String] = None
    ): DescribeDeviceRequest =
      DescribeDeviceRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def describeDeviceResponse(
      deviceDescription: Option[DeviceDescription] = None
    ): DescribeDeviceResponse =
      DescribeDeviceResponse
        .builder
        .ifSome(deviceDescription)(_.deviceDescription(_))
        .build

    def device(
      attributes: Option[Attributes] = None,
      deviceId: Option[String] = None,
      `type`: Option[String] = None
    ): Device =
      Device
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def deviceClaimResponse(
      state: Option[String] = None
    ): DeviceClaimResponse =
      DeviceClaimResponse
        .builder
        .ifSome(state)(_.state(_))
        .build

    def deviceDescription(
      arn: Option[String] = None,
      attributes: Option[DeviceAttributes] = None,
      deviceId: Option[String] = None,
      enabled: Option[Boolean] = None,
      remainingLife: Option[__doubleMin0Max100] = None,
      `type`: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): DeviceDescription =
      DeviceDescription
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(remainingLife)(_.remainingLife(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(tags)(_.tags(_))
        .build

    def deviceEvent(
      device: Option[Device] = None,
      stdEvent: Option[String] = None
    ): DeviceEvent =
      DeviceEvent
        .builder
        .ifSome(device)(_.device(_))
        .ifSome(stdEvent)(_.stdEvent(_))
        .build

    def deviceEventsResponse(
      events: Option[List[DeviceEvent]] = None,
      nextToken: Option[String] = None
    ): DeviceEventsResponse =
      DeviceEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def deviceMethod(
      deviceType: Option[String] = None,
      methodName: Option[String] = None
    ): DeviceMethod =
      DeviceMethod
        .builder
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(methodName)(_.methodName(_))
        .build

    def empty(

    ): Empty =
      Empty
        .builder

        .build

    def finalizeDeviceClaimRequest(
      deviceId: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): FinalizeDeviceClaimRequest =
      FinalizeDeviceClaimRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def finalizeDeviceClaimResponse(
      state: Option[String] = None
    ): FinalizeDeviceClaimResponse =
      FinalizeDeviceClaimResponse
        .builder
        .ifSome(state)(_.state(_))
        .build

    def forbiddenException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ForbiddenException =
      ForbiddenException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def getDeviceMethodsRequest(
      deviceId: Option[String] = None
    ): GetDeviceMethodsRequest =
      GetDeviceMethodsRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def getDeviceMethodsResponse(
      deviceMethods: Option[List[DeviceMethod]] = None
    ): GetDeviceMethodsResponse =
      GetDeviceMethodsResponse
        .builder
        .ifSome(deviceMethods)(_.deviceMethods(_))
        .build

    def initiateDeviceClaimRequest(
      deviceId: Option[String] = None
    ): InitiateDeviceClaimRequest =
      InitiateDeviceClaimRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def initiateDeviceClaimResponse(
      state: Option[String] = None
    ): InitiateDeviceClaimResponse =
      InitiateDeviceClaimResponse
        .builder
        .ifSome(state)(_.state(_))
        .build

    def internalFailureException(
      code: Option[String] = None,
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      code: Option[String] = None,
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def invokeDeviceMethodRequest(
      deviceId: Option[String] = None,
      deviceMethod: Option[DeviceMethod] = None,
      deviceMethodParameters: Option[String] = None
    ): InvokeDeviceMethodRequest =
      InvokeDeviceMethodRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(deviceMethod)(_.deviceMethod(_))
        .ifSome(deviceMethodParameters)(_.deviceMethodParameters(_))
        .build

    def invokeDeviceMethodResponse(
      deviceMethodResponse: Option[String] = None
    ): InvokeDeviceMethodResponse =
      InvokeDeviceMethodResponse
        .builder
        .ifSome(deviceMethodResponse)(_.deviceMethodResponse(_))
        .build

    def listDeviceEventsRequest(
      deviceId: Option[String] = None,
      fromTimeStamp: Option[__timestampIso8601] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      toTimeStamp: Option[__timestampIso8601] = None
    ): ListDeviceEventsRequest =
      ListDeviceEventsRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(fromTimeStamp)(_.fromTimeStamp(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(toTimeStamp)(_.toTimeStamp(_))
        .build

    def listDeviceEventsResponse(
      events: Option[List[DeviceEvent]] = None,
      nextToken: Option[String] = None
    ): ListDeviceEventsResponse =
      ListDeviceEventsResponse
        .builder
        .ifSome(events)(_.events(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevicesRequest(
      deviceType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDevicesRequest =
      ListDevicesRequest
        .builder
        .ifSome(deviceType)(_.deviceType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDevicesResponse(
      devices: Option[List[DeviceDescription]] = None,
      nextToken: Option[String] = None
    ): ListDevicesResponse =
      ListDevicesResponse
        .builder
        .ifSome(devices)(_.devices(_))
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
      tags: Option[__mapOf__string] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def preconditionFailedException(
      code: Option[String] = None,
      message: Option[String] = None
    ): PreconditionFailedException =
      PreconditionFailedException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def rangeNotSatisfiableException(
      code: Option[String] = None,
      message: Option[String] = None
    ): RangeNotSatisfiableException =
      RangeNotSatisfiableException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceConflictException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ResourceConflictException =
      ResourceConflictException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      code: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      resourceArn: Option[String] = None,
      tags: Option[__mapOf__string] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def unclaimDeviceRequest(
      deviceId: Option[String] = None
    ): UnclaimDeviceRequest =
      UnclaimDeviceRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .build

    def unclaimDeviceResponse(
      state: Option[String] = None
    ): UnclaimDeviceResponse =
      UnclaimDeviceResponse
        .builder
        .ifSome(state)(_.state(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[__string]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateDeviceStateRequest(
      deviceId: Option[String] = None,
      enabled: Option[Boolean] = None
    ): UpdateDeviceStateRequest =
      UpdateDeviceStateRequest
        .builder
        .ifSome(deviceId)(_.deviceId(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def updateDeviceStateResponse(

    ): UpdateDeviceStateResponse =
      UpdateDeviceStateResponse
        .builder

        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
