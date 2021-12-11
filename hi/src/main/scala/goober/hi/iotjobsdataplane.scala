package goober.hi

import goober.free.iotjobsdataplane.IotJobsDataPlaneIO
import software.amazon.awssdk.services.iotjobsdataplane.model._


object iotjobsdataplane {
  import goober.free.{iotjobsdataplane ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def certificateValidationException(
      message: Option[String] = None
    ): CertificateValidationException =
      CertificateValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def describeJobExecutionRequest(
      jobId: Option[String] = None,
      thingName: Option[String] = None,
      includeJobDocument: Option[Boolean] = None,
      executionNumber: Option[ExecutionNumber] = None
    ): DescribeJobExecutionRequest =
      DescribeJobExecutionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(includeJobDocument)(_.includeJobDocument(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .build

    def describeJobExecutionResponse(
      execution: Option[JobExecution] = None
    ): DescribeJobExecutionResponse =
      DescribeJobExecutionResponse
        .builder
        .ifSome(execution)(_.execution(_))
        .build

    def getPendingJobExecutionsRequest(
      thingName: Option[String] = None
    ): GetPendingJobExecutionsRequest =
      GetPendingJobExecutionsRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .build

    def getPendingJobExecutionsResponse(
      inProgressJobs: Option[List[JobExecutionSummary]] = None,
      queuedJobs: Option[List[JobExecutionSummary]] = None
    ): GetPendingJobExecutionsResponse =
      GetPendingJobExecutionsResponse
        .builder
        .ifSome(inProgressJobs)(_.inProgressJobs(_))
        .ifSome(queuedJobs)(_.queuedJobs(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidStateTransitionException(
      message: Option[String] = None
    ): InvalidStateTransitionException =
      InvalidStateTransitionException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def jobExecution(
      jobId: Option[String] = None,
      thingName: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[DetailsMap] = None,
      queuedAt: Option[QueuedAt] = None,
      startedAt: Option[StartedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      approximateSecondsBeforeTimedOut: Option[ApproximateSecondsBeforeTimedOut] = None,
      versionNumber: Option[VersionNumber] = None,
      executionNumber: Option[ExecutionNumber] = None,
      jobDocument: Option[String] = None
    ): JobExecution =
      JobExecution
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(queuedAt)(_.queuedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(approximateSecondsBeforeTimedOut)(_.approximateSecondsBeforeTimedOut(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .ifSome(jobDocument)(_.jobDocument(_))
        .build

    def jobExecutionState(
      status: Option[String] = None,
      statusDetails: Option[DetailsMap] = None,
      versionNumber: Option[VersionNumber] = None
    ): JobExecutionState =
      JobExecutionState
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .build

    def jobExecutionSummary(
      jobId: Option[String] = None,
      queuedAt: Option[QueuedAt] = None,
      startedAt: Option[StartedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      versionNumber: Option[VersionNumber] = None,
      executionNumber: Option[ExecutionNumber] = None
    ): JobExecutionSummary =
      JobExecutionSummary
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(queuedAt)(_.queuedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def startNextPendingJobExecutionRequest(
      thingName: Option[String] = None,
      statusDetails: Option[DetailsMap] = None,
      stepTimeoutInMinutes: Option[StepTimeoutInMinutes] = None
    ): StartNextPendingJobExecutionRequest =
      StartNextPendingJobExecutionRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(stepTimeoutInMinutes)(_.stepTimeoutInMinutes(_))
        .build

    def startNextPendingJobExecutionResponse(
      execution: Option[JobExecution] = None
    ): StartNextPendingJobExecutionResponse =
      StartNextPendingJobExecutionResponse
        .builder
        .ifSome(execution)(_.execution(_))
        .build

    def terminalStateException(
      message: Option[String] = None
    ): TerminalStateException =
      TerminalStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def throttlingException(
      message: Option[String] = None,
      payload: Option[BinaryBlob] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(payload)(_.payload(_))
        .build

    def updateJobExecutionRequest(
      jobId: Option[String] = None,
      thingName: Option[String] = None,
      status: Option[String] = None,
      statusDetails: Option[DetailsMap] = None,
      stepTimeoutInMinutes: Option[StepTimeoutInMinutes] = None,
      expectedVersion: Option[ExpectedVersion] = None,
      includeJobExecutionState: Option[Boolean] = None,
      includeJobDocument: Option[Boolean] = None,
      executionNumber: Option[ExecutionNumber] = None
    ): UpdateJobExecutionRequest =
      UpdateJobExecutionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(stepTimeoutInMinutes)(_.stepTimeoutInMinutes(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .ifSome(includeJobExecutionState)(_.includeJobExecutionState(_))
        .ifSome(includeJobDocument)(_.includeJobDocument(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .build

    def updateJobExecutionResponse(
      executionState: Option[JobExecutionState] = None,
      jobDocument: Option[String] = None
    ): UpdateJobExecutionResponse =
      UpdateJobExecutionResponse
        .builder
        .ifSome(executionState)(_.executionState(_))
        .ifSome(jobDocument)(_.jobDocument(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
