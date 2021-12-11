package goober.hi

import goober.free.codebuild.CodeBuildIO
import software.amazon.awssdk.services.codebuild.model._


object codebuild {
  import goober.free.{codebuild ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountLimitExceededException(

    ): AccountLimitExceededException =
      AccountLimitExceededException
        .builder

        .build

    def batchDeleteBuildsInput(
      ids: Option[List[NonEmptyString]] = None
    ): BatchDeleteBuildsInput =
      BatchDeleteBuildsInput
        .builder
        .ifSome(ids)(_.ids(_))
        .build

    def batchDeleteBuildsOutput(
      buildsDeleted: Option[List[NonEmptyString]] = None,
      buildsNotDeleted: Option[List[BuildNotDeleted]] = None
    ): BatchDeleteBuildsOutput =
      BatchDeleteBuildsOutput
        .builder
        .ifSome(buildsDeleted)(_.buildsDeleted(_))
        .ifSome(buildsNotDeleted)(_.buildsNotDeleted(_))
        .build

    def batchGetBuildBatchesInput(
      ids: Option[List[NonEmptyString]] = None
    ): BatchGetBuildBatchesInput =
      BatchGetBuildBatchesInput
        .builder
        .ifSome(ids)(_.ids(_))
        .build

    def batchGetBuildBatchesOutput(
      buildBatches: Option[List[BuildBatch]] = None,
      buildBatchesNotFound: Option[List[NonEmptyString]] = None
    ): BatchGetBuildBatchesOutput =
      BatchGetBuildBatchesOutput
        .builder
        .ifSome(buildBatches)(_.buildBatches(_))
        .ifSome(buildBatchesNotFound)(_.buildBatchesNotFound(_))
        .build

    def batchGetBuildsInput(
      ids: Option[List[NonEmptyString]] = None
    ): BatchGetBuildsInput =
      BatchGetBuildsInput
        .builder
        .ifSome(ids)(_.ids(_))
        .build

    def batchGetBuildsOutput(
      builds: Option[List[Build]] = None,
      buildsNotFound: Option[List[NonEmptyString]] = None
    ): BatchGetBuildsOutput =
      BatchGetBuildsOutput
        .builder
        .ifSome(builds)(_.builds(_))
        .ifSome(buildsNotFound)(_.buildsNotFound(_))
        .build

    def batchGetProjectsInput(
      names: Option[List[NonEmptyString]] = None
    ): BatchGetProjectsInput =
      BatchGetProjectsInput
        .builder
        .ifSome(names)(_.names(_))
        .build

    def batchGetProjectsOutput(
      projects: Option[List[Project]] = None,
      projectsNotFound: Option[List[NonEmptyString]] = None
    ): BatchGetProjectsOutput =
      BatchGetProjectsOutput
        .builder
        .ifSome(projects)(_.projects(_))
        .ifSome(projectsNotFound)(_.projectsNotFound(_))
        .build

    def batchGetReportGroupsInput(
      reportGroupArns: Option[List[NonEmptyString]] = None
    ): BatchGetReportGroupsInput =
      BatchGetReportGroupsInput
        .builder
        .ifSome(reportGroupArns)(_.reportGroupArns(_))
        .build

    def batchGetReportGroupsOutput(
      reportGroups: Option[List[ReportGroup]] = None,
      reportGroupsNotFound: Option[List[NonEmptyString]] = None
    ): BatchGetReportGroupsOutput =
      BatchGetReportGroupsOutput
        .builder
        .ifSome(reportGroups)(_.reportGroups(_))
        .ifSome(reportGroupsNotFound)(_.reportGroupsNotFound(_))
        .build

    def batchGetReportsInput(
      reportArns: Option[List[NonEmptyString]] = None
    ): BatchGetReportsInput =
      BatchGetReportsInput
        .builder
        .ifSome(reportArns)(_.reportArns(_))
        .build

    def batchGetReportsOutput(
      reports: Option[List[Report]] = None,
      reportsNotFound: Option[List[NonEmptyString]] = None
    ): BatchGetReportsOutput =
      BatchGetReportsOutput
        .builder
        .ifSome(reports)(_.reports(_))
        .ifSome(reportsNotFound)(_.reportsNotFound(_))
        .build

    def batchRestrictions(
      maximumBuildsAllowed: Option[Int] = None,
      computeTypesAllowed: Option[List[NonEmptyString]] = None
    ): BatchRestrictions =
      BatchRestrictions
        .builder
        .ifSome(maximumBuildsAllowed)(_.maximumBuildsAllowed(_))
        .ifSome(computeTypesAllowed)(_.computeTypesAllowed(_))
        .build

    def build(
      id: Option[String] = None,
      arn: Option[String] = None,
      buildNumber: Option[WrapperLong] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      currentPhase: Option[String] = None,
      buildStatus: Option[String] = None,
      sourceVersion: Option[String] = None,
      resolvedSourceVersion: Option[String] = None,
      projectName: Option[String] = None,
      phases: Option[List[BuildPhase]] = None,
      source: Option[ProjectSource] = None,
      secondarySources: Option[List[ProjectSource]] = None,
      secondarySourceVersions: Option[List[ProjectSourceVersion]] = None,
      artifacts: Option[BuildArtifacts] = None,
      secondaryArtifacts: Option[List[BuildArtifacts]] = None,
      cache: Option[ProjectCache] = None,
      environment: Option[ProjectEnvironment] = None,
      serviceRole: Option[String] = None,
      logs: Option[LogsLocation] = None,
      timeoutInMinutes: Option[Int] = None,
      queuedTimeoutInMinutes: Option[Int] = None,
      buildComplete: Option[Boolean] = None,
      initiator: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      networkInterface: Option[NetworkInterface] = None,
      encryptionKey: Option[String] = None,
      exportedEnvironmentVariables: Option[List[ExportedEnvironmentVariable]] = None,
      reportArns: Option[List[String]] = None,
      fileSystemLocations: Option[List[ProjectFileSystemLocation]] = None,
      debugSession: Option[DebugSession] = None,
      buildBatchArn: Option[String] = None
    ): Build =
      Build
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(buildNumber)(_.buildNumber(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(currentPhase)(_.currentPhase(_))
        .ifSome(buildStatus)(_.buildStatus(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(resolvedSourceVersion)(_.resolvedSourceVersion(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(phases)(_.phases(_))
        .ifSome(source)(_.source(_))
        .ifSome(secondarySources)(_.secondarySources(_))
        .ifSome(secondarySourceVersions)(_.secondarySourceVersions(_))
        .ifSome(artifacts)(_.artifacts(_))
        .ifSome(secondaryArtifacts)(_.secondaryArtifacts(_))
        .ifSome(cache)(_.cache(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(logs)(_.logs(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .ifSome(queuedTimeoutInMinutes)(_.queuedTimeoutInMinutes(_))
        .ifSome(buildComplete)(_.buildComplete(_))
        .ifSome(initiator)(_.initiator(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(networkInterface)(_.networkInterface(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(exportedEnvironmentVariables)(_.exportedEnvironmentVariables(_))
        .ifSome(reportArns)(_.reportArns(_))
        .ifSome(fileSystemLocations)(_.fileSystemLocations(_))
        .ifSome(debugSession)(_.debugSession(_))
        .ifSome(buildBatchArn)(_.buildBatchArn(_))
        .build

    def buildArtifacts(
      location: Option[String] = None,
      sha256sum: Option[String] = None,
      md5sum: Option[String] = None,
      overrideArtifactName: Option[Boolean] = None,
      encryptionDisabled: Option[Boolean] = None,
      artifactIdentifier: Option[String] = None,
      bucketOwnerAccess: Option[String] = None
    ): BuildArtifacts =
      BuildArtifacts
        .builder
        .ifSome(location)(_.location(_))
        .ifSome(sha256sum)(_.sha256sum(_))
        .ifSome(md5sum)(_.md5sum(_))
        .ifSome(overrideArtifactName)(_.overrideArtifactName(_))
        .ifSome(encryptionDisabled)(_.encryptionDisabled(_))
        .ifSome(artifactIdentifier)(_.artifactIdentifier(_))
        .ifSome(bucketOwnerAccess)(_.bucketOwnerAccess(_))
        .build

    def buildBatch(
      id: Option[String] = None,
      arn: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      currentPhase: Option[String] = None,
      buildBatchStatus: Option[String] = None,
      sourceVersion: Option[String] = None,
      resolvedSourceVersion: Option[String] = None,
      projectName: Option[String] = None,
      phases: Option[List[BuildBatchPhase]] = None,
      source: Option[ProjectSource] = None,
      secondarySources: Option[List[ProjectSource]] = None,
      secondarySourceVersions: Option[List[ProjectSourceVersion]] = None,
      artifacts: Option[BuildArtifacts] = None,
      secondaryArtifacts: Option[List[BuildArtifacts]] = None,
      cache: Option[ProjectCache] = None,
      environment: Option[ProjectEnvironment] = None,
      serviceRole: Option[String] = None,
      logConfig: Option[LogsConfig] = None,
      buildTimeoutInMinutes: Option[Int] = None,
      queuedTimeoutInMinutes: Option[Int] = None,
      complete: Option[Boolean] = None,
      initiator: Option[String] = None,
      vpcConfig: Option[VpcConfig] = None,
      encryptionKey: Option[String] = None,
      buildBatchNumber: Option[WrapperLong] = None,
      fileSystemLocations: Option[List[ProjectFileSystemLocation]] = None,
      buildBatchConfig: Option[ProjectBuildBatchConfig] = None,
      buildGroups: Option[List[BuildGroup]] = None,
      debugSessionEnabled: Option[Boolean] = None
    ): BuildBatch =
      BuildBatch
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(currentPhase)(_.currentPhase(_))
        .ifSome(buildBatchStatus)(_.buildBatchStatus(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(resolvedSourceVersion)(_.resolvedSourceVersion(_))
        .ifSome(projectName)(_.projectName(_))
        .ifSome(phases)(_.phases(_))
        .ifSome(source)(_.source(_))
        .ifSome(secondarySources)(_.secondarySources(_))
        .ifSome(secondarySourceVersions)(_.secondarySourceVersions(_))
        .ifSome(artifacts)(_.artifacts(_))
        .ifSome(secondaryArtifacts)(_.secondaryArtifacts(_))
        .ifSome(cache)(_.cache(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(logConfig)(_.logConfig(_))
        .ifSome(buildTimeoutInMinutes)(_.buildTimeoutInMinutes(_))
        .ifSome(queuedTimeoutInMinutes)(_.queuedTimeoutInMinutes(_))
        .ifSome(complete)(_.complete(_))
        .ifSome(initiator)(_.initiator(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(buildBatchNumber)(_.buildBatchNumber(_))
        .ifSome(fileSystemLocations)(_.fileSystemLocations(_))
        .ifSome(buildBatchConfig)(_.buildBatchConfig(_))
        .ifSome(buildGroups)(_.buildGroups(_))
        .ifSome(debugSessionEnabled)(_.debugSessionEnabled(_))
        .build

    def buildBatchFilter(
      status: Option[String] = None
    ): BuildBatchFilter =
      BuildBatchFilter
        .builder
        .ifSome(status)(_.status(_))
        .build

    def buildBatchPhase(
      phaseType: Option[String] = None,
      phaseStatus: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      durationInSeconds: Option[WrapperLong] = None,
      contexts: Option[List[PhaseContext]] = None
    ): BuildBatchPhase =
      BuildBatchPhase
        .builder
        .ifSome(phaseType)(_.phaseType(_))
        .ifSome(phaseStatus)(_.phaseStatus(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .ifSome(contexts)(_.contexts(_))
        .build

    def buildGroup(
      identifier: Option[String] = None,
      dependsOn: Option[List[NonEmptyString]] = None,
      ignoreFailure: Option[Boolean] = None,
      currentBuildSummary: Option[BuildSummary] = None,
      priorBuildSummaryList: Option[List[BuildSummary]] = None
    ): BuildGroup =
      BuildGroup
        .builder
        .ifSome(identifier)(_.identifier(_))
        .ifSome(dependsOn)(_.dependsOn(_))
        .ifSome(ignoreFailure)(_.ignoreFailure(_))
        .ifSome(currentBuildSummary)(_.currentBuildSummary(_))
        .ifSome(priorBuildSummaryList)(_.priorBuildSummaryList(_))
        .build

    def buildNotDeleted(
      id: Option[String] = None,
      statusCode: Option[String] = None
    ): BuildNotDeleted =
      BuildNotDeleted
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(statusCode)(_.statusCode(_))
        .build

    def buildPhase(
      phaseType: Option[String] = None,
      phaseStatus: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      durationInSeconds: Option[WrapperLong] = None,
      contexts: Option[List[PhaseContext]] = None
    ): BuildPhase =
      BuildPhase
        .builder
        .ifSome(phaseType)(_.phaseType(_))
        .ifSome(phaseStatus)(_.phaseStatus(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(durationInSeconds)(_.durationInSeconds(_))
        .ifSome(contexts)(_.contexts(_))
        .build

    def buildStatusConfig(
      context: Option[String] = None,
      targetUrl: Option[String] = None
    ): BuildStatusConfig =
      BuildStatusConfig
        .builder
        .ifSome(context)(_.context(_))
        .ifSome(targetUrl)(_.targetUrl(_))
        .build

    def buildSummary(
      arn: Option[String] = None,
      requestedOn: Option[Timestamp] = None,
      buildStatus: Option[String] = None,
      primaryArtifact: Option[ResolvedArtifact] = None,
      secondaryArtifacts: Option[List[ResolvedArtifact]] = None
    ): BuildSummary =
      BuildSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(requestedOn)(_.requestedOn(_))
        .ifSome(buildStatus)(_.buildStatus(_))
        .ifSome(primaryArtifact)(_.primaryArtifact(_))
        .ifSome(secondaryArtifacts)(_.secondaryArtifacts(_))
        .build

    def cloudWatchLogsConfig(
      status: Option[String] = None,
      groupName: Option[String] = None,
      streamName: Option[String] = None
    ): CloudWatchLogsConfig =
      CloudWatchLogsConfig
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(groupName)(_.groupName(_))
        .ifSome(streamName)(_.streamName(_))
        .build

    def codeCoverage(
      id: Option[String] = None,
      reportARN: Option[String] = None,
      filePath: Option[String] = None,
      lineCoveragePercentage: Option[Percentage] = None,
      linesCovered: Option[Int] = None,
      linesMissed: Option[Int] = None,
      branchCoveragePercentage: Option[Percentage] = None,
      branchesCovered: Option[Int] = None,
      branchesMissed: Option[Int] = None,
      expired: Option[Timestamp] = None
    ): CodeCoverage =
      CodeCoverage
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(reportARN)(_.reportARN(_))
        .ifSome(filePath)(_.filePath(_))
        .ifSome(lineCoveragePercentage)(_.lineCoveragePercentage(_))
        .ifSome(linesCovered)(_.linesCovered(_))
        .ifSome(linesMissed)(_.linesMissed(_))
        .ifSome(branchCoveragePercentage)(_.branchCoveragePercentage(_))
        .ifSome(branchesCovered)(_.branchesCovered(_))
        .ifSome(branchesMissed)(_.branchesMissed(_))
        .ifSome(expired)(_.expired(_))
        .build

    def codeCoverageReportSummary(
      lineCoveragePercentage: Option[Percentage] = None,
      linesCovered: Option[Int] = None,
      linesMissed: Option[Int] = None,
      branchCoveragePercentage: Option[Percentage] = None,
      branchesCovered: Option[Int] = None,
      branchesMissed: Option[Int] = None
    ): CodeCoverageReportSummary =
      CodeCoverageReportSummary
        .builder
        .ifSome(lineCoveragePercentage)(_.lineCoveragePercentage(_))
        .ifSome(linesCovered)(_.linesCovered(_))
        .ifSome(linesMissed)(_.linesMissed(_))
        .ifSome(branchCoveragePercentage)(_.branchCoveragePercentage(_))
        .ifSome(branchesCovered)(_.branchesCovered(_))
        .ifSome(branchesMissed)(_.branchesMissed(_))
        .build

    def createProjectInput(
      name: Option[String] = None,
      description: Option[String] = None,
      source: Option[ProjectSource] = None,
      secondarySources: Option[List[ProjectSource]] = None,
      sourceVersion: Option[String] = None,
      secondarySourceVersions: Option[List[ProjectSourceVersion]] = None,
      artifacts: Option[ProjectArtifacts] = None,
      secondaryArtifacts: Option[List[ProjectArtifacts]] = None,
      cache: Option[ProjectCache] = None,
      environment: Option[ProjectEnvironment] = None,
      serviceRole: Option[String] = None,
      timeoutInMinutes: Option[Int] = None,
      queuedTimeoutInMinutes: Option[Int] = None,
      encryptionKey: Option[String] = None,
      tags: Option[List[Tag]] = None,
      vpcConfig: Option[VpcConfig] = None,
      badgeEnabled: Option[Boolean] = None,
      logsConfig: Option[LogsConfig] = None,
      fileSystemLocations: Option[List[ProjectFileSystemLocation]] = None,
      buildBatchConfig: Option[ProjectBuildBatchConfig] = None,
      concurrentBuildLimit: Option[Int] = None
    ): CreateProjectInput =
      CreateProjectInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(secondarySources)(_.secondarySources(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(secondarySourceVersions)(_.secondarySourceVersions(_))
        .ifSome(artifacts)(_.artifacts(_))
        .ifSome(secondaryArtifacts)(_.secondaryArtifacts(_))
        .ifSome(cache)(_.cache(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .ifSome(queuedTimeoutInMinutes)(_.queuedTimeoutInMinutes(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(badgeEnabled)(_.badgeEnabled(_))
        .ifSome(logsConfig)(_.logsConfig(_))
        .ifSome(fileSystemLocations)(_.fileSystemLocations(_))
        .ifSome(buildBatchConfig)(_.buildBatchConfig(_))
        .ifSome(concurrentBuildLimit)(_.concurrentBuildLimit(_))
        .build

    def createProjectOutput(
      project: Option[Project] = None
    ): CreateProjectOutput =
      CreateProjectOutput
        .builder
        .ifSome(project)(_.project(_))
        .build

    def createReportGroupInput(
      name: Option[String] = None,
      `type`: Option[String] = None,
      exportConfig: Option[ReportExportConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateReportGroupInput =
      CreateReportGroupInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(exportConfig)(_.exportConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createReportGroupOutput(
      reportGroup: Option[ReportGroup] = None
    ): CreateReportGroupOutput =
      CreateReportGroupOutput
        .builder
        .ifSome(reportGroup)(_.reportGroup(_))
        .build

    def createWebhookInput(
      projectName: Option[String] = None,
      branchFilter: Option[String] = None,
      filterGroups: Option[List[FilterGroup]] = None,
      buildType: Option[String] = None
    ): CreateWebhookInput =
      CreateWebhookInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(branchFilter)(_.branchFilter(_))
        .ifSome(filterGroups)(_.filterGroups(_))
        .ifSome(buildType)(_.buildType(_))
        .build

    def createWebhookOutput(
      webhook: Option[Webhook] = None
    ): CreateWebhookOutput =
      CreateWebhookOutput
        .builder
        .ifSome(webhook)(_.webhook(_))
        .build

    def debugSession(
      sessionEnabled: Option[Boolean] = None,
      sessionTarget: Option[String] = None
    ): DebugSession =
      DebugSession
        .builder
        .ifSome(sessionEnabled)(_.sessionEnabled(_))
        .ifSome(sessionTarget)(_.sessionTarget(_))
        .build

    def deleteBuildBatchInput(
      id: Option[String] = None
    ): DeleteBuildBatchInput =
      DeleteBuildBatchInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def deleteBuildBatchOutput(
      statusCode: Option[String] = None,
      buildsDeleted: Option[List[NonEmptyString]] = None,
      buildsNotDeleted: Option[List[BuildNotDeleted]] = None
    ): DeleteBuildBatchOutput =
      DeleteBuildBatchOutput
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(buildsDeleted)(_.buildsDeleted(_))
        .ifSome(buildsNotDeleted)(_.buildsNotDeleted(_))
        .build

    def deleteProjectInput(
      name: Option[String] = None
    ): DeleteProjectInput =
      DeleteProjectInput
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteProjectOutput(

    ): DeleteProjectOutput =
      DeleteProjectOutput
        .builder

        .build

    def deleteReportGroupInput(
      arn: Option[String] = None,
      deleteReports: Option[Boolean] = None
    ): DeleteReportGroupInput =
      DeleteReportGroupInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(deleteReports)(_.deleteReports(_))
        .build

    def deleteReportGroupOutput(

    ): DeleteReportGroupOutput =
      DeleteReportGroupOutput
        .builder

        .build

    def deleteReportInput(
      arn: Option[String] = None
    ): DeleteReportInput =
      DeleteReportInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteReportOutput(

    ): DeleteReportOutput =
      DeleteReportOutput
        .builder

        .build

    def deleteResourcePolicyInput(
      resourceArn: Option[String] = None
    ): DeleteResourcePolicyInput =
      DeleteResourcePolicyInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def deleteResourcePolicyOutput(

    ): DeleteResourcePolicyOutput =
      DeleteResourcePolicyOutput
        .builder

        .build

    def deleteSourceCredentialsInput(
      arn: Option[String] = None
    ): DeleteSourceCredentialsInput =
      DeleteSourceCredentialsInput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteSourceCredentialsOutput(
      arn: Option[String] = None
    ): DeleteSourceCredentialsOutput =
      DeleteSourceCredentialsOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteWebhookInput(
      projectName: Option[String] = None
    ): DeleteWebhookInput =
      DeleteWebhookInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def deleteWebhookOutput(

    ): DeleteWebhookOutput =
      DeleteWebhookOutput
        .builder

        .build

    def describeCodeCoveragesInput(
      reportArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      minLineCoveragePercentage: Option[Percentage] = None,
      maxLineCoveragePercentage: Option[Percentage] = None
    ): DescribeCodeCoveragesInput =
      DescribeCodeCoveragesInput
        .builder
        .ifSome(reportArn)(_.reportArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(minLineCoveragePercentage)(_.minLineCoveragePercentage(_))
        .ifSome(maxLineCoveragePercentage)(_.maxLineCoveragePercentage(_))
        .build

    def describeCodeCoveragesOutput(
      nextToken: Option[String] = None,
      codeCoverages: Option[List[CodeCoverage]] = None
    ): DescribeCodeCoveragesOutput =
      DescribeCodeCoveragesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(codeCoverages)(_.codeCoverages(_))
        .build

    def describeTestCasesInput(
      reportArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[TestCaseFilter] = None
    ): DescribeTestCasesInput =
      DescribeTestCasesInput
        .builder
        .ifSome(reportArn)(_.reportArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .build

    def describeTestCasesOutput(
      nextToken: Option[String] = None,
      testCases: Option[List[TestCase]] = None
    ): DescribeTestCasesOutput =
      DescribeTestCasesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(testCases)(_.testCases(_))
        .build

    def environmentImage(
      name: Option[String] = None,
      description: Option[String] = None,
      versions: Option[List[String]] = None
    ): EnvironmentImage =
      EnvironmentImage
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(versions)(_.versions(_))
        .build

    def environmentLanguage(
      language: Option[String] = None,
      images: Option[List[EnvironmentImage]] = None
    ): EnvironmentLanguage =
      EnvironmentLanguage
        .builder
        .ifSome(language)(_.language(_))
        .ifSome(images)(_.images(_))
        .build

    def environmentPlatform(
      platform: Option[String] = None,
      languages: Option[List[EnvironmentLanguage]] = None
    ): EnvironmentPlatform =
      EnvironmentPlatform
        .builder
        .ifSome(platform)(_.platform(_))
        .ifSome(languages)(_.languages(_))
        .build

    def environmentVariable(
      name: Option[String] = None,
      value: Option[String] = None,
      `type`: Option[String] = None
    ): EnvironmentVariable =
      EnvironmentVariable
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def exportedEnvironmentVariable(
      name: Option[String] = None,
      value: Option[String] = None
    ): ExportedEnvironmentVariable =
      ExportedEnvironmentVariable
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def getReportGroupTrendInput(
      reportGroupArn: Option[String] = None,
      numOfReports: Option[Int] = None,
      trendField: Option[String] = None
    ): GetReportGroupTrendInput =
      GetReportGroupTrendInput
        .builder
        .ifSome(reportGroupArn)(_.reportGroupArn(_))
        .ifSome(numOfReports)(_.numOfReports(_))
        .ifSome(trendField)(_.trendField(_))
        .build

    def getReportGroupTrendOutput(
      stats: Option[ReportGroupTrendStats] = None,
      rawData: Option[List[ReportWithRawData]] = None
    ): GetReportGroupTrendOutput =
      GetReportGroupTrendOutput
        .builder
        .ifSome(stats)(_.stats(_))
        .ifSome(rawData)(_.rawData(_))
        .build

    def getResourcePolicyInput(
      resourceArn: Option[String] = None
    ): GetResourcePolicyInput =
      GetResourcePolicyInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def getResourcePolicyOutput(
      policy: Option[String] = None
    ): GetResourcePolicyOutput =
      GetResourcePolicyOutput
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def gitSubmodulesConfig(
      fetchSubmodules: Option[Boolean] = None
    ): GitSubmodulesConfig =
      GitSubmodulesConfig
        .builder
        .ifSome(fetchSubmodules)(_.fetchSubmodules(_))
        .build

    def importSourceCredentialsInput(
      username: Option[String] = None,
      token: Option[String] = None,
      serverType: Option[String] = None,
      authType: Option[String] = None,
      shouldOverwrite: Option[Boolean] = None
    ): ImportSourceCredentialsInput =
      ImportSourceCredentialsInput
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(token)(_.token(_))
        .ifSome(serverType)(_.serverType(_))
        .ifSome(authType)(_.authType(_))
        .ifSome(shouldOverwrite)(_.shouldOverwrite(_))
        .build

    def importSourceCredentialsOutput(
      arn: Option[String] = None
    ): ImportSourceCredentialsOutput =
      ImportSourceCredentialsOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def invalidInputException(

    ): InvalidInputException =
      InvalidInputException
        .builder

        .build

    def invalidateProjectCacheInput(
      projectName: Option[String] = None
    ): InvalidateProjectCacheInput =
      InvalidateProjectCacheInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .build

    def invalidateProjectCacheOutput(

    ): InvalidateProjectCacheOutput =
      InvalidateProjectCacheOutput
        .builder

        .build

    def listBuildBatchesForProjectInput(
      projectName: Option[String] = None,
      filter: Option[BuildBatchFilter] = None,
      maxResults: Option[Int] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBuildBatchesForProjectInput =
      ListBuildBatchesForProjectInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildBatchesForProjectOutput(
      ids: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None
    ): ListBuildBatchesForProjectOutput =
      ListBuildBatchesForProjectOutput
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildBatchesInput(
      filter: Option[BuildBatchFilter] = None,
      maxResults: Option[Int] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBuildBatchesInput =
      ListBuildBatchesInput
        .builder
        .ifSome(filter)(_.filter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildBatchesOutput(
      ids: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None
    ): ListBuildBatchesOutput =
      ListBuildBatchesOutput
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildsForProjectInput(
      projectName: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBuildsForProjectInput =
      ListBuildsForProjectInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildsForProjectOutput(
      ids: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None
    ): ListBuildsForProjectOutput =
      ListBuildsForProjectOutput
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildsInput(
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None
    ): ListBuildsInput =
      ListBuildsInput
        .builder
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBuildsOutput(
      ids: Option[List[NonEmptyString]] = None,
      nextToken: Option[String] = None
    ): ListBuildsOutput =
      ListBuildsOutput
        .builder
        .ifSome(ids)(_.ids(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCuratedEnvironmentImagesInput(

    ): ListCuratedEnvironmentImagesInput =
      ListCuratedEnvironmentImagesInput
        .builder

        .build

    def listCuratedEnvironmentImagesOutput(
      platforms: Option[List[EnvironmentPlatform]] = None
    ): ListCuratedEnvironmentImagesOutput =
      ListCuratedEnvironmentImagesOutput
        .builder
        .ifSome(platforms)(_.platforms(_))
        .build

    def listProjectsInput(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None
    ): ListProjectsInput =
      ListProjectsInput
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProjectsOutput(
      nextToken: Option[String] = None,
      projects: Option[List[NonEmptyString]] = None
    ): ListProjectsOutput =
      ListProjectsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(projects)(_.projects(_))
        .build

    def listReportGroupsInput(
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListReportGroupsInput =
      ListReportGroupsInput
        .builder
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listReportGroupsOutput(
      nextToken: Option[String] = None,
      reportGroups: Option[List[NonEmptyString]] = None
    ): ListReportGroupsOutput =
      ListReportGroupsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reportGroups)(_.reportGroups(_))
        .build

    def listReportsForReportGroupInput(
      reportGroupArn: Option[String] = None,
      nextToken: Option[String] = None,
      sortOrder: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[ReportFilter] = None
    ): ListReportsForReportGroupInput =
      ListReportsForReportGroupInput
        .builder
        .ifSome(reportGroupArn)(_.reportGroupArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listReportsForReportGroupOutput(
      nextToken: Option[String] = None,
      reports: Option[List[NonEmptyString]] = None
    ): ListReportsForReportGroupOutput =
      ListReportsForReportGroupOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reports)(_.reports(_))
        .build

    def listReportsInput(
      sortOrder: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filter: Option[ReportFilter] = None
    ): ListReportsInput =
      ListReportsInput
        .builder
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filter)(_.filter(_))
        .build

    def listReportsOutput(
      nextToken: Option[String] = None,
      reports: Option[List[NonEmptyString]] = None
    ): ListReportsOutput =
      ListReportsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reports)(_.reports(_))
        .build

    def listSharedProjectsInput(
      sortBy: Option[String] = None,
      sortOrder: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListSharedProjectsInput =
      ListSharedProjectsInput
        .builder
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSharedProjectsOutput(
      nextToken: Option[String] = None,
      projects: Option[List[NonEmptyString]] = None
    ): ListSharedProjectsOutput =
      ListSharedProjectsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(projects)(_.projects(_))
        .build

    def listSharedReportGroupsInput(
      sortOrder: Option[String] = None,
      sortBy: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListSharedReportGroupsInput =
      ListSharedReportGroupsInput
        .builder
        .ifSome(sortOrder)(_.sortOrder(_))
        .ifSome(sortBy)(_.sortBy(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listSharedReportGroupsOutput(
      nextToken: Option[String] = None,
      reportGroups: Option[List[NonEmptyString]] = None
    ): ListSharedReportGroupsOutput =
      ListSharedReportGroupsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(reportGroups)(_.reportGroups(_))
        .build

    def listSourceCredentialsInput(

    ): ListSourceCredentialsInput =
      ListSourceCredentialsInput
        .builder

        .build

    def listSourceCredentialsOutput(
      sourceCredentialsInfos: Option[List[SourceCredentialsInfo]] = None
    ): ListSourceCredentialsOutput =
      ListSourceCredentialsOutput
        .builder
        .ifSome(sourceCredentialsInfos)(_.sourceCredentialsInfos(_))
        .build

    def logsConfig(
      cloudWatchLogs: Option[CloudWatchLogsConfig] = None,
      s3Logs: Option[S3LogsConfig] = None
    ): LogsConfig =
      LogsConfig
        .builder
        .ifSome(cloudWatchLogs)(_.cloudWatchLogs(_))
        .ifSome(s3Logs)(_.s3Logs(_))
        .build

    def logsLocation(
      groupName: Option[String] = None,
      streamName: Option[String] = None,
      deepLink: Option[String] = None,
      s3DeepLink: Option[String] = None,
      cloudWatchLogsArn: Option[String] = None,
      s3LogsArn: Option[String] = None,
      cloudWatchLogs: Option[CloudWatchLogsConfig] = None,
      s3Logs: Option[S3LogsConfig] = None
    ): LogsLocation =
      LogsLocation
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(deepLink)(_.deepLink(_))
        .ifSome(s3DeepLink)(_.s3DeepLink(_))
        .ifSome(cloudWatchLogsArn)(_.cloudWatchLogsArn(_))
        .ifSome(s3LogsArn)(_.s3LogsArn(_))
        .ifSome(cloudWatchLogs)(_.cloudWatchLogs(_))
        .ifSome(s3Logs)(_.s3Logs(_))
        .build

    def networkInterface(
      subnetId: Option[String] = None,
      networkInterfaceId: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(subnetId)(_.subnetId(_))
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .build

    def oAuthProviderException(

    ): OAuthProviderException =
      OAuthProviderException
        .builder

        .build

    def phaseContext(
      statusCode: Option[String] = None,
      message: Option[String] = None
    ): PhaseContext =
      PhaseContext
        .builder
        .ifSome(statusCode)(_.statusCode(_))
        .ifSome(message)(_.message(_))
        .build

    def project(
      name: Option[String] = None,
      arn: Option[String] = None,
      description: Option[String] = None,
      source: Option[ProjectSource] = None,
      secondarySources: Option[List[ProjectSource]] = None,
      sourceVersion: Option[String] = None,
      secondarySourceVersions: Option[List[ProjectSourceVersion]] = None,
      artifacts: Option[ProjectArtifacts] = None,
      secondaryArtifacts: Option[List[ProjectArtifacts]] = None,
      cache: Option[ProjectCache] = None,
      environment: Option[ProjectEnvironment] = None,
      serviceRole: Option[String] = None,
      timeoutInMinutes: Option[Int] = None,
      queuedTimeoutInMinutes: Option[Int] = None,
      encryptionKey: Option[String] = None,
      tags: Option[List[Tag]] = None,
      created: Option[Timestamp] = None,
      lastModified: Option[Timestamp] = None,
      webhook: Option[Webhook] = None,
      vpcConfig: Option[VpcConfig] = None,
      badge: Option[ProjectBadge] = None,
      logsConfig: Option[LogsConfig] = None,
      fileSystemLocations: Option[List[ProjectFileSystemLocation]] = None,
      buildBatchConfig: Option[ProjectBuildBatchConfig] = None,
      concurrentBuildLimit: Option[Int] = None
    ): Project =
      Project
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(secondarySources)(_.secondarySources(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(secondarySourceVersions)(_.secondarySourceVersions(_))
        .ifSome(artifacts)(_.artifacts(_))
        .ifSome(secondaryArtifacts)(_.secondaryArtifacts(_))
        .ifSome(cache)(_.cache(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .ifSome(queuedTimeoutInMinutes)(_.queuedTimeoutInMinutes(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(created)(_.created(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(webhook)(_.webhook(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(badge)(_.badge(_))
        .ifSome(logsConfig)(_.logsConfig(_))
        .ifSome(fileSystemLocations)(_.fileSystemLocations(_))
        .ifSome(buildBatchConfig)(_.buildBatchConfig(_))
        .ifSome(concurrentBuildLimit)(_.concurrentBuildLimit(_))
        .build

    def projectArtifacts(
      `type`: Option[String] = None,
      location: Option[String] = None,
      path: Option[String] = None,
      namespaceType: Option[String] = None,
      name: Option[String] = None,
      packaging: Option[String] = None,
      overrideArtifactName: Option[Boolean] = None,
      encryptionDisabled: Option[Boolean] = None,
      artifactIdentifier: Option[String] = None,
      bucketOwnerAccess: Option[String] = None
    ): ProjectArtifacts =
      ProjectArtifacts
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(path)(_.path(_))
        .ifSome(namespaceType)(_.namespaceType(_))
        .ifSome(name)(_.name(_))
        .ifSome(packaging)(_.packaging(_))
        .ifSome(overrideArtifactName)(_.overrideArtifactName(_))
        .ifSome(encryptionDisabled)(_.encryptionDisabled(_))
        .ifSome(artifactIdentifier)(_.artifactIdentifier(_))
        .ifSome(bucketOwnerAccess)(_.bucketOwnerAccess(_))
        .build

    def projectBadge(
      badgeEnabled: Option[Boolean] = None,
      badgeRequestUrl: Option[String] = None
    ): ProjectBadge =
      ProjectBadge
        .builder
        .ifSome(badgeEnabled)(_.badgeEnabled(_))
        .ifSome(badgeRequestUrl)(_.badgeRequestUrl(_))
        .build

    def projectBuildBatchConfig(
      serviceRole: Option[String] = None,
      combineArtifacts: Option[Boolean] = None,
      restrictions: Option[BatchRestrictions] = None,
      timeoutInMins: Option[Int] = None
    ): ProjectBuildBatchConfig =
      ProjectBuildBatchConfig
        .builder
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(combineArtifacts)(_.combineArtifacts(_))
        .ifSome(restrictions)(_.restrictions(_))
        .ifSome(timeoutInMins)(_.timeoutInMins(_))
        .build

    def projectCache(
      `type`: Option[String] = None,
      location: Option[String] = None,
      modes: Option[List[CacheMode]] = None
    ): ProjectCache =
      ProjectCache
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(modes)(_.modes(_))
        .build

    def projectEnvironment(
      `type`: Option[String] = None,
      image: Option[String] = None,
      computeType: Option[String] = None,
      environmentVariables: Option[List[EnvironmentVariable]] = None,
      privilegedMode: Option[Boolean] = None,
      certificate: Option[String] = None,
      registryCredential: Option[RegistryCredential] = None,
      imagePullCredentialsType: Option[String] = None
    ): ProjectEnvironment =
      ProjectEnvironment
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(image)(_.image(_))
        .ifSome(computeType)(_.computeType(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(privilegedMode)(_.privilegedMode(_))
        .ifSome(certificate)(_.certificate(_))
        .ifSome(registryCredential)(_.registryCredential(_))
        .ifSome(imagePullCredentialsType)(_.imagePullCredentialsType(_))
        .build

    def projectFileSystemLocation(
      `type`: Option[String] = None,
      location: Option[String] = None,
      mountPoint: Option[String] = None,
      identifier: Option[String] = None,
      mountOptions: Option[String] = None
    ): ProjectFileSystemLocation =
      ProjectFileSystemLocation
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(mountPoint)(_.mountPoint(_))
        .ifSome(identifier)(_.identifier(_))
        .ifSome(mountOptions)(_.mountOptions(_))
        .build

    def projectSource(
      `type`: Option[String] = None,
      location: Option[String] = None,
      gitCloneDepth: Option[Int] = None,
      gitSubmodulesConfig: Option[GitSubmodulesConfig] = None,
      buildspec: Option[String] = None,
      auth: Option[SourceAuth] = None,
      reportBuildStatus: Option[Boolean] = None,
      buildStatusConfig: Option[BuildStatusConfig] = None,
      insecureSsl: Option[Boolean] = None,
      sourceIdentifier: Option[String] = None
    ): ProjectSource =
      ProjectSource
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(gitCloneDepth)(_.gitCloneDepth(_))
        .ifSome(gitSubmodulesConfig)(_.gitSubmodulesConfig(_))
        .ifSome(buildspec)(_.buildspec(_))
        .ifSome(auth)(_.auth(_))
        .ifSome(reportBuildStatus)(_.reportBuildStatus(_))
        .ifSome(buildStatusConfig)(_.buildStatusConfig(_))
        .ifSome(insecureSsl)(_.insecureSsl(_))
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .build

    def projectSourceVersion(
      sourceIdentifier: Option[String] = None,
      sourceVersion: Option[String] = None
    ): ProjectSourceVersion =
      ProjectSourceVersion
        .builder
        .ifSome(sourceIdentifier)(_.sourceIdentifier(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .build

    def putResourcePolicyInput(
      policy: Option[String] = None,
      resourceArn: Option[String] = None
    ): PutResourcePolicyInput =
      PutResourcePolicyInput
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def putResourcePolicyOutput(
      resourceArn: Option[String] = None
    ): PutResourcePolicyOutput =
      PutResourcePolicyOutput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def registryCredential(
      credential: Option[String] = None,
      credentialProvider: Option[String] = None
    ): RegistryCredential =
      RegistryCredential
        .builder
        .ifSome(credential)(_.credential(_))
        .ifSome(credentialProvider)(_.credentialProvider(_))
        .build

    def report(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      name: Option[String] = None,
      reportGroupArn: Option[String] = None,
      executionId: Option[String] = None,
      status: Option[String] = None,
      created: Option[Timestamp] = None,
      expired: Option[Timestamp] = None,
      exportConfig: Option[ReportExportConfig] = None,
      truncated: Option[Boolean] = None,
      testSummary: Option[TestReportSummary] = None,
      codeCoverageSummary: Option[CodeCoverageReportSummary] = None
    ): Report =
      Report
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(name)(_.name(_))
        .ifSome(reportGroupArn)(_.reportGroupArn(_))
        .ifSome(executionId)(_.executionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(created)(_.created(_))
        .ifSome(expired)(_.expired(_))
        .ifSome(exportConfig)(_.exportConfig(_))
        .ifSome(truncated)(_.truncated(_))
        .ifSome(testSummary)(_.testSummary(_))
        .ifSome(codeCoverageSummary)(_.codeCoverageSummary(_))
        .build

    def reportExportConfig(
      exportConfigType: Option[String] = None,
      s3Destination: Option[S3ReportExportConfig] = None
    ): ReportExportConfig =
      ReportExportConfig
        .builder
        .ifSome(exportConfigType)(_.exportConfigType(_))
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def reportFilter(
      status: Option[String] = None
    ): ReportFilter =
      ReportFilter
        .builder
        .ifSome(status)(_.status(_))
        .build

    def reportGroup(
      arn: Option[String] = None,
      name: Option[String] = None,
      `type`: Option[String] = None,
      exportConfig: Option[ReportExportConfig] = None,
      created: Option[Timestamp] = None,
      lastModified: Option[Timestamp] = None,
      tags: Option[List[Tag]] = None,
      status: Option[String] = None
    ): ReportGroup =
      ReportGroup
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(exportConfig)(_.exportConfig(_))
        .ifSome(created)(_.created(_))
        .ifSome(lastModified)(_.lastModified(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(status)(_.status(_))
        .build

    def reportGroupTrendStats(
      average: Option[String] = None,
      max: Option[String] = None,
      min: Option[String] = None
    ): ReportGroupTrendStats =
      ReportGroupTrendStats
        .builder
        .ifSome(average)(_.average(_))
        .ifSome(max)(_.max(_))
        .ifSome(min)(_.min(_))
        .build

    def reportWithRawData(
      reportArn: Option[String] = None,
      data: Option[String] = None
    ): ReportWithRawData =
      ReportWithRawData
        .builder
        .ifSome(reportArn)(_.reportArn(_))
        .ifSome(data)(_.data(_))
        .build

    def resolvedArtifact(
      `type`: Option[String] = None,
      location: Option[String] = None,
      identifier: Option[String] = None
    ): ResolvedArtifact =
      ResolvedArtifact
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(location)(_.location(_))
        .ifSome(identifier)(_.identifier(_))
        .build

    def resourceAlreadyExistsException(

    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder

        .build

    def resourceNotFoundException(

    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder

        .build

    def retryBuildBatchInput(
      id: Option[String] = None,
      idempotencyToken: Option[String] = None,
      retryType: Option[String] = None
    ): RetryBuildBatchInput =
      RetryBuildBatchInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(retryType)(_.retryType(_))
        .build

    def retryBuildBatchOutput(
      buildBatch: Option[BuildBatch] = None
    ): RetryBuildBatchOutput =
      RetryBuildBatchOutput
        .builder
        .ifSome(buildBatch)(_.buildBatch(_))
        .build

    def retryBuildInput(
      id: Option[String] = None,
      idempotencyToken: Option[String] = None
    ): RetryBuildInput =
      RetryBuildInput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .build

    def retryBuildOutput(
      build: Option[Build] = None
    ): RetryBuildOutput =
      RetryBuildOutput
        .builder
        .ifSome(build)(_.build(_))
        .build

    def s3LogsConfig(
      status: Option[String] = None,
      location: Option[String] = None,
      encryptionDisabled: Option[Boolean] = None,
      bucketOwnerAccess: Option[String] = None
    ): S3LogsConfig =
      S3LogsConfig
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(location)(_.location(_))
        .ifSome(encryptionDisabled)(_.encryptionDisabled(_))
        .ifSome(bucketOwnerAccess)(_.bucketOwnerAccess(_))
        .build

    def s3ReportExportConfig(
      bucket: Option[String] = None,
      bucketOwner: Option[String] = None,
      path: Option[String] = None,
      packaging: Option[String] = None,
      encryptionKey: Option[String] = None,
      encryptionDisabled: Option[Boolean] = None
    ): S3ReportExportConfig =
      S3ReportExportConfig
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(bucketOwner)(_.bucketOwner(_))
        .ifSome(path)(_.path(_))
        .ifSome(packaging)(_.packaging(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(encryptionDisabled)(_.encryptionDisabled(_))
        .build

    def sourceAuth(
      `type`: Option[String] = None,
      resource: Option[String] = None
    ): SourceAuth =
      SourceAuth
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(resource)(_.resource(_))
        .build

    def sourceCredentialsInfo(
      arn: Option[String] = None,
      serverType: Option[String] = None,
      authType: Option[String] = None
    ): SourceCredentialsInfo =
      SourceCredentialsInfo
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(serverType)(_.serverType(_))
        .ifSome(authType)(_.authType(_))
        .build

    def startBuildBatchInput(
      projectName: Option[String] = None,
      secondarySourcesOverride: Option[List[ProjectSource]] = None,
      secondarySourcesVersionOverride: Option[List[ProjectSourceVersion]] = None,
      sourceVersion: Option[String] = None,
      artifactsOverride: Option[ProjectArtifacts] = None,
      secondaryArtifactsOverride: Option[List[ProjectArtifacts]] = None,
      environmentVariablesOverride: Option[List[EnvironmentVariable]] = None,
      sourceTypeOverride: Option[String] = None,
      sourceLocationOverride: Option[String] = None,
      sourceAuthOverride: Option[SourceAuth] = None,
      gitCloneDepthOverride: Option[Int] = None,
      gitSubmodulesConfigOverride: Option[GitSubmodulesConfig] = None,
      buildspecOverride: Option[String] = None,
      insecureSslOverride: Option[Boolean] = None,
      reportBuildBatchStatusOverride: Option[Boolean] = None,
      environmentTypeOverride: Option[String] = None,
      imageOverride: Option[String] = None,
      computeTypeOverride: Option[String] = None,
      certificateOverride: Option[String] = None,
      cacheOverride: Option[ProjectCache] = None,
      serviceRoleOverride: Option[String] = None,
      privilegedModeOverride: Option[Boolean] = None,
      buildTimeoutInMinutesOverride: Option[Int] = None,
      queuedTimeoutInMinutesOverride: Option[Int] = None,
      encryptionKeyOverride: Option[String] = None,
      idempotencyToken: Option[String] = None,
      logsConfigOverride: Option[LogsConfig] = None,
      registryCredentialOverride: Option[RegistryCredential] = None,
      imagePullCredentialsTypeOverride: Option[String] = None,
      buildBatchConfigOverride: Option[ProjectBuildBatchConfig] = None,
      debugSessionEnabled: Option[Boolean] = None
    ): StartBuildBatchInput =
      StartBuildBatchInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(secondarySourcesOverride)(_.secondarySourcesOverride(_))
        .ifSome(secondarySourcesVersionOverride)(_.secondarySourcesVersionOverride(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(artifactsOverride)(_.artifactsOverride(_))
        .ifSome(secondaryArtifactsOverride)(_.secondaryArtifactsOverride(_))
        .ifSome(environmentVariablesOverride)(_.environmentVariablesOverride(_))
        .ifSome(sourceTypeOverride)(_.sourceTypeOverride(_))
        .ifSome(sourceLocationOverride)(_.sourceLocationOverride(_))
        .ifSome(sourceAuthOverride)(_.sourceAuthOverride(_))
        .ifSome(gitCloneDepthOverride)(_.gitCloneDepthOverride(_))
        .ifSome(gitSubmodulesConfigOverride)(_.gitSubmodulesConfigOverride(_))
        .ifSome(buildspecOverride)(_.buildspecOverride(_))
        .ifSome(insecureSslOverride)(_.insecureSslOverride(_))
        .ifSome(reportBuildBatchStatusOverride)(_.reportBuildBatchStatusOverride(_))
        .ifSome(environmentTypeOverride)(_.environmentTypeOverride(_))
        .ifSome(imageOverride)(_.imageOverride(_))
        .ifSome(computeTypeOverride)(_.computeTypeOverride(_))
        .ifSome(certificateOverride)(_.certificateOverride(_))
        .ifSome(cacheOverride)(_.cacheOverride(_))
        .ifSome(serviceRoleOverride)(_.serviceRoleOverride(_))
        .ifSome(privilegedModeOverride)(_.privilegedModeOverride(_))
        .ifSome(buildTimeoutInMinutesOverride)(_.buildTimeoutInMinutesOverride(_))
        .ifSome(queuedTimeoutInMinutesOverride)(_.queuedTimeoutInMinutesOverride(_))
        .ifSome(encryptionKeyOverride)(_.encryptionKeyOverride(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(logsConfigOverride)(_.logsConfigOverride(_))
        .ifSome(registryCredentialOverride)(_.registryCredentialOverride(_))
        .ifSome(imagePullCredentialsTypeOverride)(_.imagePullCredentialsTypeOverride(_))
        .ifSome(buildBatchConfigOverride)(_.buildBatchConfigOverride(_))
        .ifSome(debugSessionEnabled)(_.debugSessionEnabled(_))
        .build

    def startBuildBatchOutput(
      buildBatch: Option[BuildBatch] = None
    ): StartBuildBatchOutput =
      StartBuildBatchOutput
        .builder
        .ifSome(buildBatch)(_.buildBatch(_))
        .build

    def startBuildInput(
      projectName: Option[String] = None,
      secondarySourcesOverride: Option[List[ProjectSource]] = None,
      secondarySourcesVersionOverride: Option[List[ProjectSourceVersion]] = None,
      sourceVersion: Option[String] = None,
      artifactsOverride: Option[ProjectArtifacts] = None,
      secondaryArtifactsOverride: Option[List[ProjectArtifacts]] = None,
      environmentVariablesOverride: Option[List[EnvironmentVariable]] = None,
      sourceTypeOverride: Option[String] = None,
      sourceLocationOverride: Option[String] = None,
      sourceAuthOverride: Option[SourceAuth] = None,
      gitCloneDepthOverride: Option[Int] = None,
      gitSubmodulesConfigOverride: Option[GitSubmodulesConfig] = None,
      buildspecOverride: Option[String] = None,
      insecureSslOverride: Option[Boolean] = None,
      reportBuildStatusOverride: Option[Boolean] = None,
      buildStatusConfigOverride: Option[BuildStatusConfig] = None,
      environmentTypeOverride: Option[String] = None,
      imageOverride: Option[String] = None,
      computeTypeOverride: Option[String] = None,
      certificateOverride: Option[String] = None,
      cacheOverride: Option[ProjectCache] = None,
      serviceRoleOverride: Option[String] = None,
      privilegedModeOverride: Option[Boolean] = None,
      timeoutInMinutesOverride: Option[Int] = None,
      queuedTimeoutInMinutesOverride: Option[Int] = None,
      encryptionKeyOverride: Option[String] = None,
      idempotencyToken: Option[String] = None,
      logsConfigOverride: Option[LogsConfig] = None,
      registryCredentialOverride: Option[RegistryCredential] = None,
      imagePullCredentialsTypeOverride: Option[String] = None,
      debugSessionEnabled: Option[Boolean] = None
    ): StartBuildInput =
      StartBuildInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(secondarySourcesOverride)(_.secondarySourcesOverride(_))
        .ifSome(secondarySourcesVersionOverride)(_.secondarySourcesVersionOverride(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(artifactsOverride)(_.artifactsOverride(_))
        .ifSome(secondaryArtifactsOverride)(_.secondaryArtifactsOverride(_))
        .ifSome(environmentVariablesOverride)(_.environmentVariablesOverride(_))
        .ifSome(sourceTypeOverride)(_.sourceTypeOverride(_))
        .ifSome(sourceLocationOverride)(_.sourceLocationOverride(_))
        .ifSome(sourceAuthOverride)(_.sourceAuthOverride(_))
        .ifSome(gitCloneDepthOverride)(_.gitCloneDepthOverride(_))
        .ifSome(gitSubmodulesConfigOverride)(_.gitSubmodulesConfigOverride(_))
        .ifSome(buildspecOverride)(_.buildspecOverride(_))
        .ifSome(insecureSslOverride)(_.insecureSslOverride(_))
        .ifSome(reportBuildStatusOverride)(_.reportBuildStatusOverride(_))
        .ifSome(buildStatusConfigOverride)(_.buildStatusConfigOverride(_))
        .ifSome(environmentTypeOverride)(_.environmentTypeOverride(_))
        .ifSome(imageOverride)(_.imageOverride(_))
        .ifSome(computeTypeOverride)(_.computeTypeOverride(_))
        .ifSome(certificateOverride)(_.certificateOverride(_))
        .ifSome(cacheOverride)(_.cacheOverride(_))
        .ifSome(serviceRoleOverride)(_.serviceRoleOverride(_))
        .ifSome(privilegedModeOverride)(_.privilegedModeOverride(_))
        .ifSome(timeoutInMinutesOverride)(_.timeoutInMinutesOverride(_))
        .ifSome(queuedTimeoutInMinutesOverride)(_.queuedTimeoutInMinutesOverride(_))
        .ifSome(encryptionKeyOverride)(_.encryptionKeyOverride(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(logsConfigOverride)(_.logsConfigOverride(_))
        .ifSome(registryCredentialOverride)(_.registryCredentialOverride(_))
        .ifSome(imagePullCredentialsTypeOverride)(_.imagePullCredentialsTypeOverride(_))
        .ifSome(debugSessionEnabled)(_.debugSessionEnabled(_))
        .build

    def startBuildOutput(
      build: Option[Build] = None
    ): StartBuildOutput =
      StartBuildOutput
        .builder
        .ifSome(build)(_.build(_))
        .build

    def stopBuildBatchInput(
      id: Option[String] = None
    ): StopBuildBatchInput =
      StopBuildBatchInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def stopBuildBatchOutput(
      buildBatch: Option[BuildBatch] = None
    ): StopBuildBatchOutput =
      StopBuildBatchOutput
        .builder
        .ifSome(buildBatch)(_.buildBatch(_))
        .build

    def stopBuildInput(
      id: Option[String] = None
    ): StopBuildInput =
      StopBuildInput
        .builder
        .ifSome(id)(_.id(_))
        .build

    def stopBuildOutput(
      build: Option[Build] = None
    ): StopBuildOutput =
      StopBuildOutput
        .builder
        .ifSome(build)(_.build(_))
        .build

    def tag(
      key: Option[String] = None,
      value: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def testCase(
      reportArn: Option[String] = None,
      testRawDataPath: Option[String] = None,
      prefix: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      durationInNanoSeconds: Option[WrapperLong] = None,
      message: Option[String] = None,
      expired: Option[Timestamp] = None
    ): TestCase =
      TestCase
        .builder
        .ifSome(reportArn)(_.reportArn(_))
        .ifSome(testRawDataPath)(_.testRawDataPath(_))
        .ifSome(prefix)(_.prefix(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(durationInNanoSeconds)(_.durationInNanoSeconds(_))
        .ifSome(message)(_.message(_))
        .ifSome(expired)(_.expired(_))
        .build

    def testCaseFilter(
      status: Option[String] = None,
      keyword: Option[String] = None
    ): TestCaseFilter =
      TestCaseFilter
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(keyword)(_.keyword(_))
        .build

    def testReportSummary(
      total: Option[Int] = None,
      statusCounts: Option[ReportStatusCounts] = None,
      durationInNanoSeconds: Option[WrapperLong] = None
    ): TestReportSummary =
      TestReportSummary
        .builder
        .ifSome(total)(_.total(_))
        .ifSome(statusCounts)(_.statusCounts(_))
        .ifSome(durationInNanoSeconds)(_.durationInNanoSeconds(_))
        .build

    def updateProjectInput(
      name: Option[String] = None,
      description: Option[String] = None,
      source: Option[ProjectSource] = None,
      secondarySources: Option[List[ProjectSource]] = None,
      sourceVersion: Option[String] = None,
      secondarySourceVersions: Option[List[ProjectSourceVersion]] = None,
      artifacts: Option[ProjectArtifacts] = None,
      secondaryArtifacts: Option[List[ProjectArtifacts]] = None,
      cache: Option[ProjectCache] = None,
      environment: Option[ProjectEnvironment] = None,
      serviceRole: Option[String] = None,
      timeoutInMinutes: Option[Int] = None,
      queuedTimeoutInMinutes: Option[Int] = None,
      encryptionKey: Option[String] = None,
      tags: Option[List[Tag]] = None,
      vpcConfig: Option[VpcConfig] = None,
      badgeEnabled: Option[Boolean] = None,
      logsConfig: Option[LogsConfig] = None,
      fileSystemLocations: Option[List[ProjectFileSystemLocation]] = None,
      buildBatchConfig: Option[ProjectBuildBatchConfig] = None,
      concurrentBuildLimit: Option[Int] = None
    ): UpdateProjectInput =
      UpdateProjectInput
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(source)(_.source(_))
        .ifSome(secondarySources)(_.secondarySources(_))
        .ifSome(sourceVersion)(_.sourceVersion(_))
        .ifSome(secondarySourceVersions)(_.secondarySourceVersions(_))
        .ifSome(artifacts)(_.artifacts(_))
        .ifSome(secondaryArtifacts)(_.secondaryArtifacts(_))
        .ifSome(cache)(_.cache(_))
        .ifSome(environment)(_.environment(_))
        .ifSome(serviceRole)(_.serviceRole(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .ifSome(queuedTimeoutInMinutes)(_.queuedTimeoutInMinutes(_))
        .ifSome(encryptionKey)(_.encryptionKey(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(badgeEnabled)(_.badgeEnabled(_))
        .ifSome(logsConfig)(_.logsConfig(_))
        .ifSome(fileSystemLocations)(_.fileSystemLocations(_))
        .ifSome(buildBatchConfig)(_.buildBatchConfig(_))
        .ifSome(concurrentBuildLimit)(_.concurrentBuildLimit(_))
        .build

    def updateProjectOutput(
      project: Option[Project] = None
    ): UpdateProjectOutput =
      UpdateProjectOutput
        .builder
        .ifSome(project)(_.project(_))
        .build

    def updateReportGroupInput(
      arn: Option[String] = None,
      exportConfig: Option[ReportExportConfig] = None,
      tags: Option[List[Tag]] = None
    ): UpdateReportGroupInput =
      UpdateReportGroupInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(exportConfig)(_.exportConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def updateReportGroupOutput(
      reportGroup: Option[ReportGroup] = None
    ): UpdateReportGroupOutput =
      UpdateReportGroupOutput
        .builder
        .ifSome(reportGroup)(_.reportGroup(_))
        .build

    def updateWebhookInput(
      projectName: Option[String] = None,
      branchFilter: Option[String] = None,
      rotateSecret: Option[Boolean] = None,
      filterGroups: Option[List[FilterGroup]] = None,
      buildType: Option[String] = None
    ): UpdateWebhookInput =
      UpdateWebhookInput
        .builder
        .ifSome(projectName)(_.projectName(_))
        .ifSome(branchFilter)(_.branchFilter(_))
        .ifSome(rotateSecret)(_.rotateSecret(_))
        .ifSome(filterGroups)(_.filterGroups(_))
        .ifSome(buildType)(_.buildType(_))
        .build

    def updateWebhookOutput(
      webhook: Option[Webhook] = None
    ): UpdateWebhookOutput =
      UpdateWebhookOutput
        .builder
        .ifSome(webhook)(_.webhook(_))
        .build

    def vpcConfig(
      vpcId: Option[String] = None,
      subnets: Option[List[NonEmptyString]] = None,
      securityGroupIds: Option[List[NonEmptyString]] = None
    ): VpcConfig =
      VpcConfig
        .builder
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .build

    def webhook(
      url: Option[String] = None,
      payloadUrl: Option[String] = None,
      secret: Option[String] = None,
      branchFilter: Option[String] = None,
      filterGroups: Option[List[FilterGroup]] = None,
      buildType: Option[String] = None,
      lastModifiedSecret: Option[Timestamp] = None
    ): Webhook =
      Webhook
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(payloadUrl)(_.payloadUrl(_))
        .ifSome(secret)(_.secret(_))
        .ifSome(branchFilter)(_.branchFilter(_))
        .ifSome(filterGroups)(_.filterGroups(_))
        .ifSome(buildType)(_.buildType(_))
        .ifSome(lastModifiedSecret)(_.lastModifiedSecret(_))
        .build

    def webhookFilter(
      `type`: Option[String] = None,
      pattern: Option[String] = None,
      excludeMatchedPattern: Option[Boolean] = None
    ): WebhookFilter =
      WebhookFilter
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(pattern)(_.pattern(_))
        .ifSome(excludeMatchedPattern)(_.excludeMatchedPattern(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
