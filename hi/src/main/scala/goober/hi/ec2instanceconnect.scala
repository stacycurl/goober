package goober.hi

import goober.free.ec2instanceconnect.Ec2InstanceConnectIO
import software.amazon.awssdk.services.ec2instanceconnect.model._


object ec2instanceconnect {
  import goober.free.{ec2instanceconnect ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def authException(
      message: Option[String] = None
    ): AuthException =
      AuthException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def eC2InstanceNotFoundException(
      message: Option[String] = None
    ): EC2InstanceNotFoundException =
      EC2InstanceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def eC2InstanceTypeInvalidException(
      message: Option[String] = None
    ): EC2InstanceTypeInvalidException =
      EC2InstanceTypeInvalidException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArgsException(
      message: Option[String] = None
    ): InvalidArgsException =
      InvalidArgsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sendSSHPublicKeyRequest(
      instanceId: Option[String] = None,
      instanceOSUser: Option[String] = None,
      sSHPublicKey: Option[String] = None,
      availabilityZone: Option[String] = None
    ): SendSSHPublicKeyRequest =
      SendSSHPublicKeyRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(instanceOSUser)(_.instanceOSUser(_))
        .ifSome(sSHPublicKey)(_.sSHPublicKey(_))
        .ifSome(availabilityZone)(_.availabilityZone(_))
        .build

    def sendSSHPublicKeyResponse(
      requestId: Option[String] = None,
      success: Option[Boolean] = None
    ): SendSSHPublicKeyResponse =
      SendSSHPublicKeyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(success)(_.success(_))
        .build

    def sendSerialConsoleSSHPublicKeyRequest(
      instanceId: Option[String] = None,
      serialPort: Option[Int] = None,
      sSHPublicKey: Option[String] = None
    ): SendSerialConsoleSSHPublicKeyRequest =
      SendSerialConsoleSSHPublicKeyRequest
        .builder
        .ifSome(instanceId)(_.instanceId(_))
        .ifSome(serialPort)(_.serialPort(_))
        .ifSome(sSHPublicKey)(_.sSHPublicKey(_))
        .build

    def sendSerialConsoleSSHPublicKeyResponse(
      requestId: Option[String] = None,
      success: Option[Boolean] = None
    ): SendSerialConsoleSSHPublicKeyResponse =
      SendSerialConsoleSSHPublicKeyResponse
        .builder
        .ifSome(requestId)(_.requestId(_))
        .ifSome(success)(_.success(_))
        .build

    def serialConsoleAccessDisabledException(
      message: Option[String] = None
    ): SerialConsoleAccessDisabledException =
      SerialConsoleAccessDisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serialConsoleSessionLimitExceededException(
      message: Option[String] = None
    ): SerialConsoleSessionLimitExceededException =
      SerialConsoleSessionLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serialConsoleSessionUnavailableException(
      message: Option[String] = None
    ): SerialConsoleSessionUnavailableException =
      SerialConsoleSessionUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceException(
      message: Option[String] = None
    ): ServiceException =
      ServiceException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
