package goober.hi

import goober.free.sagemakera2iruntime.SageMakerA2IRuntimeIO
import software.amazon.awssdk.services.sagemakera2iruntime.model._


object sagemakera2iruntime {
  import goober.free.{sagemakera2iruntime ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteHumanLoopRequest(
      humanLoopName: Option[String] = None
    ): DeleteHumanLoopRequest =
      DeleteHumanLoopRequest
        .builder
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .build

    def deleteHumanLoopResponse(

    ): DeleteHumanLoopResponse =
      DeleteHumanLoopResponse
        .builder

        .build

    def describeHumanLoopRequest(
      humanLoopName: Option[String] = None
    ): DescribeHumanLoopRequest =
      DescribeHumanLoopRequest
        .builder
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .build

    def describeHumanLoopResponse(
      creationTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None,
      humanLoopStatus: Option[String] = None,
      humanLoopName: Option[String] = None,
      humanLoopArn: Option[String] = None,
      flowDefinitionArn: Option[String] = None,
      humanLoopOutput: Option[HumanLoopOutput] = None
    ): DescribeHumanLoopResponse =
      DescribeHumanLoopResponse
        .builder
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(humanLoopStatus)(_.humanLoopStatus(_))
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .ifSome(humanLoopArn)(_.humanLoopArn(_))
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .ifSome(humanLoopOutput)(_.humanLoopOutput(_))
        .build

    def humanLoopDataAttributes(
      contentClassifiers: Option[List[ContentClassifier]] = None
    ): HumanLoopDataAttributes =
      HumanLoopDataAttributes
        .builder
        .ifSome(contentClassifiers)(_.contentClassifiers(_))
        .build

    def humanLoopInput(
      inputContent: Option[String] = None
    ): HumanLoopInput =
      HumanLoopInput
        .builder
        .ifSome(inputContent)(_.inputContent(_))
        .build

    def humanLoopOutput(
      outputS3Uri: Option[String] = None
    ): HumanLoopOutput =
      HumanLoopOutput
        .builder
        .ifSome(outputS3Uri)(_.outputS3Uri(_))
        .build

    def humanLoopSummary(
      humanLoopName: Option[String] = None,
      humanLoopStatus: Option[String] = None,
      creationTime: Option[Timestamp] = None,
      failureReason: Option[String] = None,
      flowDefinitionArn: Option[String] = None
    ): HumanLoopSummary =
      HumanLoopSummary
        .builder
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .ifSome(humanLoopStatus)(_.humanLoopStatus(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listHumanLoopsRequest(
      creationTimeAfter: Option[Timestamp] = None,
      creationTimeBefore: Option[Timestamp] = None,
      flowDefinitionArn: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListHumanLoopsRequest =
      ListHumanLoopsRequest
        .builder
        .ifSome(creationTimeAfter)(_.creationTimeAfter(_))
        .ifSome(creationTimeBefore)(_.creationTimeBefore(_))
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listHumanLoopsResponse(
      humanLoopSummaries: Option[List[HumanLoopSummary]] = None,
      nextToken: Option[String] = None
    ): ListHumanLoopsResponse =
      ListHumanLoopsResponse
        .builder
        .ifSome(humanLoopSummaries)(_.humanLoopSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceQuotaExceededException(
      message: Option[String] = None
    ): ServiceQuotaExceededException =
      ServiceQuotaExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startHumanLoopRequest(
      humanLoopName: Option[String] = None,
      flowDefinitionArn: Option[String] = None,
      humanLoopInput: Option[HumanLoopInput] = None,
      dataAttributes: Option[HumanLoopDataAttributes] = None
    ): StartHumanLoopRequest =
      StartHumanLoopRequest
        .builder
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .ifSome(flowDefinitionArn)(_.flowDefinitionArn(_))
        .ifSome(humanLoopInput)(_.humanLoopInput(_))
        .ifSome(dataAttributes)(_.dataAttributes(_))
        .build

    def startHumanLoopResponse(
      humanLoopArn: Option[String] = None
    ): StartHumanLoopResponse =
      StartHumanLoopResponse
        .builder
        .ifSome(humanLoopArn)(_.humanLoopArn(_))
        .build

    def stopHumanLoopRequest(
      humanLoopName: Option[String] = None
    ): StopHumanLoopRequest =
      StopHumanLoopRequest
        .builder
        .ifSome(humanLoopName)(_.humanLoopName(_))
        .build

    def stopHumanLoopResponse(

    ): StopHumanLoopResponse =
      StopHumanLoopResponse
        .builder

        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
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
