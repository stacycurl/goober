package goober.hi

import goober.free.s3outposts.S3OutpostsIO
import software.amazon.awssdk.services.s3outposts.model._


object s3outposts {
  import goober.free.{s3outposts ⇒ free}

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

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createEndpointRequest(
      outpostId: Option[String] = None,
      subnetId: Option[String] = None,
      securityGroupId: Option[String] = None
    ): CreateEndpointRequest =
      CreateEndpointRequest
        .builder
        .ifSome(outpostId)(_.outpostId(_))
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(securityGroupId)(_.securityGroupId(_))
        .build

    def deleteEndpointRequest(
      endpointId: Option[String] = None,
      outpostId: Option[String] = None
    ): DeleteEndpointRequest =
      DeleteEndpointRequest
        .builder
        .ifSome(endpointId)(_.endpointId(_))
        .ifSome(outpostId)(_.outpostId(_))
        .build

    def endpoint(
      endpointArn: Option[String] = None,
      outpostsId: Option[String] = None,
      cidrBlock: Option[String] = None,
      status: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      networkInterfaces: Option[List[NetworkInterface]] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(endpointArn)(_.endpointArn(_))
        .ifSome(outpostsId)(_.outpostsId(_))
        .ifSome(cidrBlock)(_.cidrBlock(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(networkInterfaces)(_.networkInterfaces(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listEndpointsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListEndpointsRequest =
      ListEndpointsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def networkInterface(
      networkInterfaceId: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
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
