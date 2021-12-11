package goober.hi

import goober.free.iotdeviceadvisor.IotDeviceAdvisorIO
import software.amazon.awssdk.services.iotdeviceadvisor.model._


object iotdeviceadvisor {
  import goober.free.{iotdeviceadvisor ⇒ free}

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

    def createSuiteDefinitionRequest(
      suiteDefinitionConfiguration: Option[SuiteDefinitionConfiguration] = None,
      tags: Option[TagMap] = None
    ): CreateSuiteDefinitionRequest =
      CreateSuiteDefinitionRequest
        .builder
        .ifSome(suiteDefinitionConfiguration)(_.suiteDefinitionConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSuiteDefinitionResponse(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionArn: Option[String] = None,
      suiteDefinitionName: Option[String] = None,
      createdAt: Option[Timestamp] = None
    ): CreateSuiteDefinitionResponse =
      CreateSuiteDefinitionResponse
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionArn)(_.suiteDefinitionArn(_))
        .ifSome(suiteDefinitionName)(_.suiteDefinitionName(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def deleteSuiteDefinitionRequest(
      suiteDefinitionId: Option[String] = None
    ): DeleteSuiteDefinitionRequest =
      DeleteSuiteDefinitionRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .build

    def deleteSuiteDefinitionResponse(

    ): DeleteSuiteDefinitionResponse =
      DeleteSuiteDefinitionResponse
        .builder

        .build

    def deviceUnderTest(
      thingArn: Option[String] = None,
      certificateArn: Option[String] = None
    ): DeviceUnderTest =
      DeviceUnderTest
        .builder
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(certificateArn)(_.certificateArn(_))
        .build

    def getSuiteDefinitionRequest(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None
    ): GetSuiteDefinitionRequest =
      GetSuiteDefinitionRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .build

    def getSuiteDefinitionResponse(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionArn: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None,
      latestVersion: Option[String] = None,
      suiteDefinitionConfiguration: Option[SuiteDefinitionConfiguration] = None,
      createdAt: Option[Timestamp] = None,
      lastModifiedAt: Option[Timestamp] = None,
      tags: Option[TagMap] = None
    ): GetSuiteDefinitionResponse =
      GetSuiteDefinitionResponse
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionArn)(_.suiteDefinitionArn(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .ifSome(latestVersion)(_.latestVersion(_))
        .ifSome(suiteDefinitionConfiguration)(_.suiteDefinitionConfiguration(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastModifiedAt)(_.lastModifiedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def getSuiteRunReportRequest(
      suiteDefinitionId: Option[String] = None,
      suiteRunId: Option[String] = None
    ): GetSuiteRunReportRequest =
      GetSuiteRunReportRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteRunId)(_.suiteRunId(_))
        .build

    def getSuiteRunReportResponse(
      qualificationReportDownloadUrl: Option[String] = None
    ): GetSuiteRunReportResponse =
      GetSuiteRunReportResponse
        .builder
        .ifSome(qualificationReportDownloadUrl)(_.qualificationReportDownloadUrl(_))
        .build

    def getSuiteRunRequest(
      suiteDefinitionId: Option[String] = None,
      suiteRunId: Option[String] = None
    ): GetSuiteRunRequest =
      GetSuiteRunRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteRunId)(_.suiteRunId(_))
        .build

    def getSuiteRunResponse(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None,
      suiteRunId: Option[String] = None,
      suiteRunArn: Option[String] = None,
      suiteRunConfiguration: Option[SuiteRunConfiguration] = None,
      testResult: Option[TestResult] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      status: Option[String] = None,
      errorReason: Option[String] = None,
      tags: Option[TagMap] = None
    ): GetSuiteRunResponse =
      GetSuiteRunResponse
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .ifSome(suiteRunId)(_.suiteRunId(_))
        .ifSome(suiteRunArn)(_.suiteRunArn(_))
        .ifSome(suiteRunConfiguration)(_.suiteRunConfiguration(_))
        .ifSome(testResult)(_.testResult(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorReason)(_.errorReason(_))
        .ifSome(tags)(_.tags(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listSuiteDefinitionsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSuiteDefinitionsRequest =
      ListSuiteDefinitionsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSuiteDefinitionsResponse(
      suiteDefinitionInformationList: Option[List[SuiteDefinitionInformation]] = None,
      nextToken: Option[String] = None
    ): ListSuiteDefinitionsResponse =
      ListSuiteDefinitionsResponse
        .builder
        .ifSome(suiteDefinitionInformationList)(_.suiteDefinitionInformationList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSuiteRunsRequest(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSuiteRunsRequest =
      ListSuiteRunsRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSuiteRunsResponse(
      suiteRunsList: Option[List[SuiteRunInformation]] = None,
      nextToken: Option[String] = None
    ): ListSuiteRunsResponse =
      ListSuiteRunsResponse
        .builder
        .ifSome(suiteRunsList)(_.suiteRunsList(_))
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

    def startSuiteRunRequest(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None,
      suiteRunConfiguration: Option[SuiteRunConfiguration] = None,
      tags: Option[TagMap] = None
    ): StartSuiteRunRequest =
      StartSuiteRunRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .ifSome(suiteRunConfiguration)(_.suiteRunConfiguration(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startSuiteRunResponse(
      suiteRunId: Option[String] = None,
      suiteRunArn: Option[String] = None,
      createdAt: Option[Timestamp] = None
    ): StartSuiteRunResponse =
      StartSuiteRunResponse
        .builder
        .ifSome(suiteRunId)(_.suiteRunId(_))
        .ifSome(suiteRunArn)(_.suiteRunArn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def stopSuiteRunRequest(
      suiteDefinitionId: Option[String] = None,
      suiteRunId: Option[String] = None
    ): StopSuiteRunRequest =
      StopSuiteRunRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteRunId)(_.suiteRunId(_))
        .build

    def stopSuiteRunResponse(

    ): StopSuiteRunResponse =
      StopSuiteRunResponse
        .builder

        .build

    def suiteDefinitionConfiguration(
      suiteDefinitionName: Option[String] = None,
      devices: Option[List[DeviceUnderTest]] = None,
      intendedForQualification: Option[Boolean] = None,
      rootGroup: Option[String] = None,
      devicePermissionRoleArn: Option[String] = None
    ): SuiteDefinitionConfiguration =
      SuiteDefinitionConfiguration
        .builder
        .ifSome(suiteDefinitionName)(_.suiteDefinitionName(_))
        .ifSome(devices)(_.devices(_))
        .ifSome(intendedForQualification)(_.intendedForQualification(_))
        .ifSome(rootGroup)(_.rootGroup(_))
        .ifSome(devicePermissionRoleArn)(_.devicePermissionRoleArn(_))
        .build

    def suiteDefinitionInformation(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionName: Option[String] = None,
      defaultDevices: Option[List[DeviceUnderTest]] = None,
      intendedForQualification: Option[Boolean] = None,
      createdAt: Option[Timestamp] = None
    ): SuiteDefinitionInformation =
      SuiteDefinitionInformation
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionName)(_.suiteDefinitionName(_))
        .ifSome(defaultDevices)(_.defaultDevices(_))
        .ifSome(intendedForQualification)(_.intendedForQualification(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def suiteRunConfiguration(
      primaryDevice: Option[DeviceUnderTest] = None,
      selectedTestList: Option[List[UUID]] = None
    ): SuiteRunConfiguration =
      SuiteRunConfiguration
        .builder
        .ifSome(primaryDevice)(_.primaryDevice(_))
        .ifSome(selectedTestList)(_.selectedTestList(_))
        .build

    def suiteRunInformation(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None,
      suiteDefinitionName: Option[String] = None,
      suiteRunId: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      startedAt: Option[Timestamp] = None,
      endAt: Option[Timestamp] = None,
      status: Option[String] = None,
      passed: Option[Int] = None,
      failed: Option[Int] = None
    ): SuiteRunInformation =
      SuiteRunInformation
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .ifSome(suiteDefinitionName)(_.suiteDefinitionName(_))
        .ifSome(suiteRunId)(_.suiteRunId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(endAt)(_.endAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(passed)(_.passed(_))
        .ifSome(failed)(_.failed(_))
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

    def testCaseRun(
      testCaseRunId: Option[String] = None,
      testCaseDefinitionId: Option[String] = None,
      testCaseDefinitionName: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      logUrl: Option[String] = None,
      warnings: Option[String] = None,
      failure: Option[String] = None
    ): TestCaseRun =
      TestCaseRun
        .builder
        .ifSome(testCaseRunId)(_.testCaseRunId(_))
        .ifSome(testCaseDefinitionId)(_.testCaseDefinitionId(_))
        .ifSome(testCaseDefinitionName)(_.testCaseDefinitionName(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(logUrl)(_.logUrl(_))
        .ifSome(warnings)(_.warnings(_))
        .ifSome(failure)(_.failure(_))
        .build

    def untagResourceRequest(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[String128]] = None
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

    def updateSuiteDefinitionRequest(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionConfiguration: Option[SuiteDefinitionConfiguration] = None
    ): UpdateSuiteDefinitionRequest =
      UpdateSuiteDefinitionRequest
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionConfiguration)(_.suiteDefinitionConfiguration(_))
        .build

    def updateSuiteDefinitionResponse(
      suiteDefinitionId: Option[String] = None,
      suiteDefinitionArn: Option[String] = None,
      suiteDefinitionName: Option[String] = None,
      suiteDefinitionVersion: Option[String] = None,
      createdAt: Option[Timestamp] = None,
      lastUpdatedAt: Option[Timestamp] = None
    ): UpdateSuiteDefinitionResponse =
      UpdateSuiteDefinitionResponse
        .builder
        .ifSome(suiteDefinitionId)(_.suiteDefinitionId(_))
        .ifSome(suiteDefinitionArn)(_.suiteDefinitionArn(_))
        .ifSome(suiteDefinitionName)(_.suiteDefinitionName(_))
        .ifSome(suiteDefinitionVersion)(_.suiteDefinitionVersion(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
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
