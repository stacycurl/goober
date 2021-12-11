package goober.hi

import goober.free.sagemakerruntime.SageMakerRuntimeIO
import software.amazon.awssdk.services.sagemakerruntime.model._


object sagemakerruntime {
  import goober.free.{sagemakerruntime ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def internalFailure(
      message: Option[String] = None
    ): InternalFailure =
      InternalFailure
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invokeEndpointInput(
      endpointName: Option[String] = None,
      body: Option[BodyBlob] = None,
      contentType: Option[String] = None,
      accept: Option[String] = None,
      customAttributes: Option[String] = None,
      targetModel: Option[String] = None,
      targetVariant: Option[String] = None,
      targetContainerHostname: Option[String] = None,
      inferenceId: Option[String] = None
    ): InvokeEndpointInput =
      InvokeEndpointInput
        .builder
        .ifSome(endpointName)(_.endpointName(_))
        .ifSome(body)(_.body(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(accept)(_.accept(_))
        .ifSome(customAttributes)(_.customAttributes(_))
        .ifSome(targetModel)(_.targetModel(_))
        .ifSome(targetVariant)(_.targetVariant(_))
        .ifSome(targetContainerHostname)(_.targetContainerHostname(_))
        .ifSome(inferenceId)(_.inferenceId(_))
        .build

    def invokeEndpointOutput(
      body: Option[BodyBlob] = None,
      contentType: Option[String] = None,
      invokedProductionVariant: Option[String] = None,
      customAttributes: Option[String] = None
    ): InvokeEndpointOutput =
      InvokeEndpointOutput
        .builder
        .ifSome(body)(_.body(_))
        .ifSome(contentType)(_.contentType(_))
        .ifSome(invokedProductionVariant)(_.invokedProductionVariant(_))
        .ifSome(customAttributes)(_.customAttributes(_))
        .build

    def modelError(
      message: Option[String] = None,
      originalStatusCode: Option[Int] = None,
      originalMessage: Option[String] = None,
      logStreamArn: Option[String] = None
    ): ModelError =
      ModelError
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(originalStatusCode)(_.originalStatusCode(_))
        .ifSome(originalMessage)(_.originalMessage(_))
        .ifSome(logStreamArn)(_.logStreamArn(_))
        .build

    def serviceUnavailable(
      message: Option[String] = None
    ): ServiceUnavailable =
      ServiceUnavailable
        .builder
        .ifSome(message)(_.message(_))
        .build

    def validationError(
      message: Option[String] = None
    ): ValidationError =
      ValidationError
        .builder
        .ifSome(message)(_.message(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
