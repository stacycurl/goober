package goober.hi

import goober.free.synthetics.SyntheticsIO
import software.amazon.awssdk.services.synthetics.model._


object synthetics {
  import goober.free.{synthetics ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def canary(
      id: Option[String] = None,
      name: Option[String] = None,
      code: Option[CanaryCodeOutput] = None,
      executionRoleArn: Option[String] = None,
      schedule: Option[CanaryScheduleOutput] = None,
      runConfig: Option[CanaryRunConfigOutput] = None,
      successRetentionPeriodInDays: Option[Int] = None,
      failureRetentionPeriodInDays: Option[Int] = None,
      status: Option[CanaryStatus] = None,
      timeline: Option[CanaryTimeline] = None,
      artifactS3Location: Option[String] = None,
      engineArn: Option[String] = None,
      runtimeVersion: Option[String] = None,
      vpcConfig: Option[VpcConfigOutput] = None,
      tags: Option[TagMap] = None
    ): Canary =
      Canary
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(code)(_.code(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(runConfig)(_.runConfig(_))
        .ifSome(successRetentionPeriodInDays)(_.successRetentionPeriodInDays(_))
        .ifSome(failureRetentionPeriodInDays)(_.failureRetentionPeriodInDays(_))
        .ifSome(status)(_.status(_))
        .ifSome(timeline)(_.timeline(_))
        .ifSome(artifactS3Location)(_.artifactS3Location(_))
        .ifSome(engineArn)(_.engineArn(_))
        .ifSome(runtimeVersion)(_.runtimeVersion(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def canaryCodeInput(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      s3Version: Option[String] = None,
      zipFile: Option[Blob] = None,
      handler: Option[String] = None
    ): CanaryCodeInput =
      CanaryCodeInput
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(s3Version)(_.s3Version(_))
        .ifSome(zipFile)(_.zipFile(_))
        .ifSome(handler)(_.handler(_))
        .build

    def canaryCodeOutput(
      sourceLocationArn: Option[String] = None,
      handler: Option[String] = None
    ): CanaryCodeOutput =
      CanaryCodeOutput
        .builder
        .ifSome(sourceLocationArn)(_.sourceLocationArn(_))
        .ifSome(handler)(_.handler(_))
        .build

    def canaryLastRun(
      canaryName: Option[String] = None,
      lastRun: Option[CanaryRun] = None
    ): CanaryLastRun =
      CanaryLastRun
        .builder
        .ifSome(canaryName)(_.canaryName(_))
        .ifSome(lastRun)(_.lastRun(_))
        .build

    def canaryRun(
      id: Option[String] = None,
      name: Option[String] = None,
      status: Option[CanaryRunStatus] = None,
      timeline: Option[CanaryRunTimeline] = None,
      artifactS3Location: Option[String] = None
    ): CanaryRun =
      CanaryRun
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(timeline)(_.timeline(_))
        .ifSome(artifactS3Location)(_.artifactS3Location(_))
        .build

    def canaryRunConfigInput(
      timeoutInSeconds: Option[Int] = None,
      memoryInMB: Option[Int] = None,
      activeTracing: Option[Boolean] = None,
      environmentVariables: Option[EnvironmentVariablesMap] = None
    ): CanaryRunConfigInput =
      CanaryRunConfigInput
        .builder
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(memoryInMB)(_.memoryInMB(_))
        .ifSome(activeTracing)(_.activeTracing(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .build

    def canaryRunConfigOutput(
      timeoutInSeconds: Option[Int] = None,
      memoryInMB: Option[Int] = None,
      activeTracing: Option[Boolean] = None
    ): CanaryRunConfigOutput =
      CanaryRunConfigOutput
        .builder
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(memoryInMB)(_.memoryInMB(_))
        .ifSome(activeTracing)(_.activeTracing(_))
        .build

    def canaryRunStatus(
      state: Option[String] = None,
      stateReason: Option[String] = None,
      stateReasonCode: Option[String] = None
    ): CanaryRunStatus =
      CanaryRunStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateReasonCode)(_.stateReasonCode(_))
        .build

    def canaryRunTimeline(
      started: Option[Timestamp] = None,
      completed: Option[Timestamp] = None
    ): CanaryRunTimeline =
      CanaryRunTimeline
        .builder
        .ifSome(started)(_.started(_))
        .ifSome(completed)(_.completed(_))
        .build

    def canaryScheduleInput(
      expression: Option[String] = None,
      durationInSeconds: Option[MaxOneYearInSeconds] = None
    ): CanaryScheduleInput =
      CanaryScheduleInput
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .build

    def canaryScheduleOutput(
      expression: Option[String] = None,
      durationInSeconds: Option[MaxOneYearInSeconds] = None
    ): CanaryScheduleOutput =
      CanaryScheduleOutput
        .builder
        .ifSome(expression)(_.expression(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .build

    def canaryStatus(
      state: Option[String] = None,
      stateReason: Option[String] = None,
      stateReasonCode: Option[String] = None
    ): CanaryStatus =
      CanaryStatus
        .builder
        .ifSome(state)(_.state(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateReasonCode)(_.stateReasonCode(_))
        .build

    def canaryTimeline(
      created: Option[Timestamp] = None,
      lastModified: Option[Timestamp] = None,
      lastStarted: Option[Timestamp] = None,
      lastStopped: Option[Timestamp] = None
    ): CanaryTimeline =
      CanaryTimeline
        .builder
        .ifSome(created)(_.created(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(lastStarted)(_.lastStarted(_))
        .ifSome(lastStopped)(_.lastStopped(_))
        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createCanaryRequest(
      name: Option[String] = None,
      code: Option[CanaryCodeInput] = None,
      artifactS3Location: Option[String] = None,
      executionRoleArn: Option[String] = None,
      schedule: Option[CanaryScheduleInput] = None,
      runConfig: Option[CanaryRunConfigInput] = None,
      successRetentionPeriodInDays: Option[Int] = None,
      failureRetentionPeriodInDays: Option[Int] = None,
      runtimeVersion: Option[String] = None,
      vpcConfig: Option[VpcConfigInput] = None,
      tags: Option[TagMap] = None
    ): CreateCanaryRequest =
      CreateCanaryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(code)(_.code(_))
        .ifSome(artifactS3Location)(_.artifactS3Location(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(runConfig)(_.runConfig(_))
        .ifSome(successRetentionPeriodInDays)(_.successRetentionPeriodInDays(_))
        .ifSome(failureRetentionPeriodInDays)(_.failureRetentionPeriodInDays(_))
        .ifSome(runtimeVersion)(_.runtimeVersion(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createCanaryResponse(
      canary: Option[Canary] = None
    ): CreateCanaryResponse =
      CreateCanaryResponse
        .builder
        .ifSome(canary)(_.canary(_))
        .build

    def deleteCanaryRequest(
      name: Option[String] = None
    ): DeleteCanaryRequest =
      DeleteCanaryRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteCanaryResponse(

    ): DeleteCanaryResponse =
      DeleteCanaryResponse
        .builder

        .build

    def describeCanariesLastRunRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeCanariesLastRunRequest =
      DescribeCanariesLastRunRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeCanariesLastRunResponse(
      canariesLastRun: Option[List[CanaryLastRun]] = None,
      nextToken: Option[String] = None
    ): DescribeCanariesLastRunResponse =
      DescribeCanariesLastRunResponse
        .builder
        .ifSome(canariesLastRun)(_.canariesLastRun(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeCanariesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeCanariesRequest =
      DescribeCanariesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeCanariesResponse(
      canaries: Option[List[Canary]] = None,
      nextToken: Option[String] = None
    ): DescribeCanariesResponse =
      DescribeCanariesResponse
        .builder
        .ifSome(canaries)(_.canaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeRuntimeVersionsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeRuntimeVersionsRequest =
      DescribeRuntimeVersionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeRuntimeVersionsResponse(
      runtimeVersions: Option[List[RuntimeVersion]] = None,
      nextToken: Option[String] = None
    ): DescribeRuntimeVersionsResponse =
      DescribeRuntimeVersionsResponse
        .builder
        .ifSome(runtimeVersions)(_.runtimeVersions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCanaryRequest(
      name: Option[String] = None
    ): GetCanaryRequest =
      GetCanaryRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def getCanaryResponse(
      canary: Option[Canary] = None
    ): GetCanaryResponse =
      GetCanaryResponse
        .builder
        .ifSome(canary)(_.canary(_))
        .build

    def getCanaryRunsRequest(
      name: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): GetCanaryRunsRequest =
      GetCanaryRunsRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def getCanaryRunsResponse(
      canaryRuns: Option[List[CanaryRun]] = None,
      nextToken: Option[String] = None
    ): GetCanaryRunsResponse =
      GetCanaryRunsResponse
        .builder
        .ifSome(canaryRuns)(_.canaryRuns(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
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
      tags: Option[TagMap] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def runtimeVersion(
      versionName: Option[String] = None,
      description: Option[String] = None,
      releaseDate: Option[Timestamp] = None,
      deprecationDate: Option[Timestamp] = None
    ): RuntimeVersion =
      RuntimeVersion
        .builder
        .ifSome(versionName)(_.versionName(_))
        .ifSome(description)(_.description(_))
        .ifSome(releaseDate)(_.releaseDate(_))
        .ifSome(deprecationDate)(_.deprecationDate(_))
        .build

    def startCanaryRequest(
      name: Option[String] = None
    ): StartCanaryRequest =
      StartCanaryRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def startCanaryResponse(

    ): StartCanaryResponse =
      StartCanaryResponse
        .builder

        .build

    def stopCanaryRequest(
      name: Option[String] = None
    ): StopCanaryRequest =
      StopCanaryRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def stopCanaryResponse(

    ): StopCanaryResponse =
      StopCanaryResponse
        .builder

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

    def updateCanaryRequest(
      name: Option[String] = None,
      code: Option[CanaryCodeInput] = None,
      executionRoleArn: Option[String] = None,
      runtimeVersion: Option[String] = None,
      schedule: Option[CanaryScheduleInput] = None,
      runConfig: Option[CanaryRunConfigInput] = None,
      successRetentionPeriodInDays: Option[Int] = None,
      failureRetentionPeriodInDays: Option[Int] = None,
      vpcConfig: Option[VpcConfigInput] = None
    ): UpdateCanaryRequest =
      UpdateCanaryRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(code)(_.code(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(runtimeVersion)(_.runtimeVersion(_))
        .ifSome(schedule)(_.schedule(_))
        .ifSome(runConfig)(_.runConfig(_))
        .ifSome(successRetentionPeriodInDays)(_.successRetentionPeriodInDays(_))
        .ifSome(failureRetentionPeriodInDays)(_.failureRetentionPeriodInDays(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .build

    def updateCanaryResponse(

    ): UpdateCanaryResponse =
      UpdateCanaryResponse
        .builder

        .build

    def validationException(
      message: Option[String] = None
    ): ValidationException =
      ValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def vpcConfigInput(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): VpcConfigInput =
      VpcConfigInput
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def vpcConfigOutput(
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None
    ): VpcConfigOutput =
      VpcConfigOutput
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
