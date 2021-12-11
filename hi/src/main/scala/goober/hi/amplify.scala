package goober.hi

import goober.free.amplify.AmplifyIO
import software.amazon.awssdk.services.amplify.model._


object amplify {
  import goober.free.{amplify ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def app(
      appId: Option[String] = None,
      appArn: Option[String] = None,
      name: Option[String] = None,
      tags: Option[TagMap] = None,
      description: Option[String] = None,
      repository: Option[String] = None,
      platform: Option[String] = None,
      createTime: Option[CreateTime] = None,
      updateTime: Option[UpdateTime] = None,
      iamServiceRoleArn: Option[String] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      defaultDomain: Option[String] = None,
      enableBranchAutoBuild: Option[Boolean] = None,
      enableBranchAutoDeletion: Option[Boolean] = None,
      enableBasicAuth: Option[Boolean] = None,
      basicAuthCredentials: Option[String] = None,
      customRules: Option[List[CustomRule]] = None,
      productionBranch: Option[ProductionBranch] = None,
      buildSpec: Option[String] = None,
      customHeaders: Option[String] = None,
      enableAutoBranchCreation: Option[Boolean] = None,
      autoBranchCreationPatterns: Option[List[AutoBranchCreationPattern]] = None,
      autoBranchCreationConfig: Option[AutoBranchCreationConfig] = None
    ): App =
      App
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(appArn)(_.appArn(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(description)(_.description(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .ifSome(iamServiceRoleArn)(_.iamServiceRoleArn(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(defaultDomain)(_.defaultDomain(_))
        .ifSome(enableBranchAutoBuild)(_.enableBranchAutoBuild(_))
        .ifSome(enableBranchAutoDeletion)(_.enableBranchAutoDeletion(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(customRules)(_.customRules(_))
        .ifSome(productionBranch)(_.productionBranch(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(customHeaders)(_.customHeaders(_))
        .ifSome(enableAutoBranchCreation)(_.enableAutoBranchCreation(_))
        .ifSome(autoBranchCreationPatterns)(_.autoBranchCreationPatterns(_))
        .ifSome(autoBranchCreationConfig)(_.autoBranchCreationConfig(_))
        .build

    def artifact(
      artifactFileName: Option[String] = None,
      artifactId: Option[String] = None
    ): Artifact =
      Artifact
        .builder
        .ifSome(artifactFileName)(_.artifactFileName(_))
        .ifSome(artifactId)(_.artifactId(_))
        .build

    def autoBranchCreationConfig(
      stage: Option[String] = None,
      framework: Option[String] = None,
      enableAutoBuild: Option[Boolean] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      basicAuthCredentials: Option[String] = None,
      enableBasicAuth: Option[Boolean] = None,
      enablePerformanceMode: Option[Boolean] = None,
      buildSpec: Option[String] = None,
      enablePullRequestPreview: Option[Boolean] = None,
      pullRequestEnvironmentName: Option[String] = None
    ): AutoBranchCreationConfig =
      AutoBranchCreationConfig
        .builder
        .ifSome(stage)(_.stage(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(enableAutoBuild)(_.enableAutoBuild(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(enablePerformanceMode)(_.enablePerformanceMode(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(enablePullRequestPreview)(_.enablePullRequestPreview(_))
        .ifSome(pullRequestEnvironmentName)(_.pullRequestEnvironmentName(_))
        .build

    def backendEnvironment(
      backendEnvironmentArn: Option[String] = None,
      environmentName: Option[String] = None,
      stackName: Option[String] = None,
      deploymentArtifacts: Option[String] = None,
      createTime: Option[CreateTime] = None,
      updateTime: Option[UpdateTime] = None
    ): BackendEnvironment =
      BackendEnvironment
        .builder
        .ifSome(backendEnvironmentArn)(_.backendEnvironmentArn(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(deploymentArtifacts)(_.deploymentArtifacts(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

    def badRequestException(
      message: Option[String] = None
    ): BadRequestException =
      BadRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def branch(
      branchArn: Option[String] = None,
      branchName: Option[String] = None,
      description: Option[String] = None,
      tags: Option[TagMap] = None,
      stage: Option[String] = None,
      displayName: Option[String] = None,
      enableNotification: Option[Boolean] = None,
      createTime: Option[CreateTime] = None,
      updateTime: Option[UpdateTime] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      enableAutoBuild: Option[Boolean] = None,
      customDomains: Option[List[CustomDomain]] = None,
      framework: Option[String] = None,
      activeJobId: Option[String] = None,
      totalNumberOfJobs: Option[String] = None,
      enableBasicAuth: Option[Boolean] = None,
      enablePerformanceMode: Option[Boolean] = None,
      thumbnailUrl: Option[String] = None,
      basicAuthCredentials: Option[String] = None,
      buildSpec: Option[String] = None,
      ttl: Option[String] = None,
      associatedResources: Option[List[AssociatedResource]] = None,
      enablePullRequestPreview: Option[Boolean] = None,
      pullRequestEnvironmentName: Option[String] = None,
      destinationBranch: Option[String] = None,
      sourceBranch: Option[String] = None,
      backendEnvironmentArn: Option[String] = None
    ): Branch =
      Branch
        .builder
        .ifSome(branchArn)(_.branchArn(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(enableNotification)(_.enableNotification(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(enableAutoBuild)(_.enableAutoBuild(_))
        .ifSome(customDomains)(_.customDomains(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(activeJobId)(_.activeJobId(_))
        .ifSome(totalNumberOfJobs)(_.totalNumberOfJobs(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(enablePerformanceMode)(_.enablePerformanceMode(_))
        .ifSome(thumbnailUrl)(_.thumbnailUrl(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(ttl)(_.ttl(_))
        .ifSome(associatedResources)(_.associatedResources(_))
        .ifSome(enablePullRequestPreview)(_.enablePullRequestPreview(_))
        .ifSome(pullRequestEnvironmentName)(_.pullRequestEnvironmentName(_))
        .ifSome(destinationBranch)(_.destinationBranch(_))
        .ifSome(sourceBranch)(_.sourceBranch(_))
        .ifSome(backendEnvironmentArn)(_.backendEnvironmentArn(_))
        .build

    def createAppRequest(
      name: Option[String] = None,
      description: Option[String] = None,
      repository: Option[String] = None,
      platform: Option[String] = None,
      iamServiceRoleArn: Option[String] = None,
      oauthToken: Option[String] = None,
      accessToken: Option[String] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      enableBranchAutoBuild: Option[Boolean] = None,
      enableBranchAutoDeletion: Option[Boolean] = None,
      enableBasicAuth: Option[Boolean] = None,
      basicAuthCredentials: Option[String] = None,
      customRules: Option[List[CustomRule]] = None,
      tags: Option[TagMap] = None,
      buildSpec: Option[String] = None,
      customHeaders: Option[String] = None,
      enableAutoBranchCreation: Option[Boolean] = None,
      autoBranchCreationPatterns: Option[List[AutoBranchCreationPattern]] = None,
      autoBranchCreationConfig: Option[AutoBranchCreationConfig] = None
    ): CreateAppRequest =
      CreateAppRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(iamServiceRoleArn)(_.iamServiceRoleArn(_))
        .ifSome(oauthToken)(_.oauthToken(_))
        .ifSome(accessToken)(_.accessToken(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(enableBranchAutoBuild)(_.enableBranchAutoBuild(_))
        .ifSome(enableBranchAutoDeletion)(_.enableBranchAutoDeletion(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(customRules)(_.customRules(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(customHeaders)(_.customHeaders(_))
        .ifSome(enableAutoBranchCreation)(_.enableAutoBranchCreation(_))
        .ifSome(autoBranchCreationPatterns)(_.autoBranchCreationPatterns(_))
        .ifSome(autoBranchCreationConfig)(_.autoBranchCreationConfig(_))
        .build

    def createBackendEnvironmentRequest(
      appId: Option[String] = None,
      environmentName: Option[String] = None,
      stackName: Option[String] = None,
      deploymentArtifacts: Option[String] = None
    ): CreateBackendEnvironmentRequest =
      CreateBackendEnvironmentRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(deploymentArtifacts)(_.deploymentArtifacts(_))
        .build

    def createBranchRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      description: Option[String] = None,
      stage: Option[String] = None,
      framework: Option[String] = None,
      enableNotification: Option[Boolean] = None,
      enableAutoBuild: Option[Boolean] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      basicAuthCredentials: Option[String] = None,
      enableBasicAuth: Option[Boolean] = None,
      enablePerformanceMode: Option[Boolean] = None,
      tags: Option[TagMap] = None,
      buildSpec: Option[String] = None,
      ttl: Option[String] = None,
      displayName: Option[String] = None,
      enablePullRequestPreview: Option[Boolean] = None,
      pullRequestEnvironmentName: Option[String] = None,
      backendEnvironmentArn: Option[String] = None
    ): CreateBranchRequest =
      CreateBranchRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(enableNotification)(_.enableNotification(_))
        .ifSome(enableAutoBuild)(_.enableAutoBuild(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(enablePerformanceMode)(_.enablePerformanceMode(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(ttl)(_.ttl(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(enablePullRequestPreview)(_.enablePullRequestPreview(_))
        .ifSome(pullRequestEnvironmentName)(_.pullRequestEnvironmentName(_))
        .ifSome(backendEnvironmentArn)(_.backendEnvironmentArn(_))
        .build

    def createDeploymentRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      fileMap: Option[FileMap] = None
    ): CreateDeploymentRequest =
      CreateDeploymentRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(fileMap)(_.fileMap(_))
        .build

    def createDomainAssociationRequest(
      appId: Option[String] = None,
      domainName: Option[String] = None,
      enableAutoSubDomain: Option[Boolean] = None,
      subDomainSettings: Option[List[SubDomainSetting]] = None,
      autoSubDomainCreationPatterns: Option[List[AutoSubDomainCreationPattern]] = None,
      autoSubDomainIAMRole: Option[String] = None
    ): CreateDomainAssociationRequest =
      CreateDomainAssociationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(enableAutoSubDomain)(_.enableAutoSubDomain(_))
        .ifSome(subDomainSettings)(_.subDomainSettings(_))
        .ifSome(autoSubDomainCreationPatterns)(_.autoSubDomainCreationPatterns(_))
        .ifSome(autoSubDomainIAMRole)(_.autoSubDomainIAMRole(_))
        .build

    def createWebhookRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      description: Option[String] = None
    ): CreateWebhookRequest =
      CreateWebhookRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .build

    def customRule(
      source: Option[String] = None,
      target: Option[String] = None,
      status: Option[String] = None,
      condition: Option[String] = None
    ): CustomRule =
      CustomRule
        .builder
        .ifSome(source)(_.source(_))
        .ifSome(target)(_.target(_))
        .ifSome(status)(_.status(_))
        .ifSome(condition)(_.condition(_))
        .build

    def deleteAppRequest(
      appId: Option[String] = None
    ): DeleteAppRequest =
      DeleteAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def deleteBackendEnvironmentRequest(
      appId: Option[String] = None,
      environmentName: Option[String] = None
    ): DeleteBackendEnvironmentRequest =
      DeleteBackendEnvironmentRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def deleteBranchRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None
    ): DeleteBranchRequest =
      DeleteBranchRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .build

    def deleteDomainAssociationRequest(
      appId: Option[String] = None,
      domainName: Option[String] = None
    ): DeleteDomainAssociationRequest =
      DeleteDomainAssociationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def deleteJobRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      jobId: Option[String] = None
    ): DeleteJobRequest =
      DeleteJobRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def deleteWebhookRequest(
      webhookId: Option[String] = None
    ): DeleteWebhookRequest =
      DeleteWebhookRequest
        .builder
        .ifSome(webhookId)(_.webhookId(_))
        .build

    def dependentServiceFailureException(
      message: Option[String] = None
    ): DependentServiceFailureException =
      DependentServiceFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def domainAssociation(
      domainAssociationArn: Option[String] = None,
      domainName: Option[String] = None,
      enableAutoSubDomain: Option[Boolean] = None,
      autoSubDomainCreationPatterns: Option[List[AutoSubDomainCreationPattern]] = None,
      autoSubDomainIAMRole: Option[String] = None,
      domainStatus: Option[String] = None,
      statusReason: Option[String] = None,
      certificateVerificationDNSRecord: Option[String] = None,
      subDomains: Option[List[SubDomain]] = None
    ): DomainAssociation =
      DomainAssociation
        .builder
        .ifSome(domainAssociationArn)(_.domainAssociationArn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(enableAutoSubDomain)(_.enableAutoSubDomain(_))
        .ifSome(autoSubDomainCreationPatterns)(_.autoSubDomainCreationPatterns(_))
        .ifSome(autoSubDomainIAMRole)(_.autoSubDomainIAMRole(_))
        .ifSome(domainStatus)(_.domainStatus(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(certificateVerificationDNSRecord)(_.certificateVerificationDNSRecord(_))
        .ifSome(subDomains)(_.subDomains(_))
        .build

    def generateAccessLogsRequest(
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      domainName: Option[String] = None,
      appId: Option[String] = None
    ): GenerateAccessLogsRequest =
      GenerateAccessLogsRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(appId)(_.appId(_))
        .build

    def getAppRequest(
      appId: Option[String] = None
    ): GetAppRequest =
      GetAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .build

    def getArtifactUrlRequest(
      artifactId: Option[String] = None
    ): GetArtifactUrlRequest =
      GetArtifactUrlRequest
        .builder
        .ifSome(artifactId)(_.artifactId(_))
        .build

    def getBackendEnvironmentRequest(
      appId: Option[String] = None,
      environmentName: Option[String] = None
    ): GetBackendEnvironmentRequest =
      GetBackendEnvironmentRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .build

    def getBranchRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None
    ): GetBranchRequest =
      GetBranchRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .build

    def getDomainAssociationRequest(
      appId: Option[String] = None,
      domainName: Option[String] = None
    ): GetDomainAssociationRequest =
      GetDomainAssociationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(domainName)(_.domainName(_))
        .build

    def getJobRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      jobId: Option[String] = None
    ): GetJobRequest =
      GetJobRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def getWebhookRequest(
      webhookId: Option[String] = None
    ): GetWebhookRequest =
      GetWebhookRequest
        .builder
        .ifSome(webhookId)(_.webhookId(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def job(
      summary: Option[JobSummary] = None,
      steps: Option[List[Step]] = None
    ): Job =
      Job
        .builder
        .ifSome(summary)(_.summary(_))
        .ifSome(steps)(_.steps(_))
        .build

    def jobSummary(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      commitId: Option[String] = None,
      commitMessage: Option[String] = None,
      commitTime: Option[CommitTime] = None,
      startTime: Option[StartTime] = None,
      status: Option[String] = None,
      endTime: Option[EndTime] = None,
      jobType: Option[String] = None
    ): JobSummary =
      JobSummary
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(commitId)(_.commitId(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(commitTime)(_.commitTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(jobType)(_.jobType(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listAppsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAppsRequest =
      ListAppsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listArtifactsRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      jobId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListArtifactsRequest =
      ListArtifactsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBackendEnvironmentsRequest(
      appId: Option[String] = None,
      environmentName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBackendEnvironmentsRequest =
      ListBackendEnvironmentsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(environmentName)(_.environmentName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBranchesRequest(
      appId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBranchesRequest =
      ListBranchesRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDomainAssociationsRequest(
      appId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDomainAssociationsRequest =
      ListDomainAssociationsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listJobsRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
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

    def listWebhooksRequest(
      appId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWebhooksRequest =
      ListWebhooksRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def productionBranch(
      lastDeployTime: Option[LastDeployTime] = None,
      status: Option[String] = None,
      thumbnailUrl: Option[String] = None,
      branchName: Option[String] = None
    ): ProductionBranch =
      ProductionBranch
        .builder
        .ifSome(lastDeployTime)(_.lastDeployTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(thumbnailUrl)(_.thumbnailUrl(_))
        .ifSome(branchName)(_.branchName(_))
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

    def startDeploymentRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      jobId: Option[String] = None,
      sourceUrl: Option[String] = None
    ): StartDeploymentRequest =
      StartDeploymentRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(sourceUrl)(_.sourceUrl(_))
        .build

    def startJobRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      jobId: Option[String] = None,
      jobType: Option[String] = None,
      jobReason: Option[String] = None,
      commitId: Option[String] = None,
      commitMessage: Option[String] = None,
      commitTime: Option[CommitTime] = None
    ): StartJobRequest =
      StartJobRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobType)(_.jobType(_))
        .ifSome(jobReason)(_.jobReason(_))
        .ifSome(commitId)(_.commitId(_))
        .ifSome(commitMessage)(_.commitMessage(_))
        .ifSome(commitTime)(_.commitTime(_))
        .build

    def step(
      stepName: Option[String] = None,
      startTime: Option[StartTime] = None,
      status: Option[String] = None,
      endTime: Option[EndTime] = None,
      logUrl: Option[String] = None,
      artifactsUrl: Option[String] = None,
      testArtifactsUrl: Option[String] = None,
      testConfigUrl: Option[String] = None,
      screenshots: Option[Screenshots] = None,
      statusReason: Option[String] = None,
      context: Option[String] = None
    ): Step =
      Step
        .builder
        .ifSome(stepName)(_.stepName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(logUrl)(_.logUrl(_))
        .ifSome(artifactsUrl)(_.artifactsUrl(_))
        .ifSome(testArtifactsUrl)(_.testArtifactsUrl(_))
        .ifSome(testConfigUrl)(_.testConfigUrl(_))
        .ifSome(screenshots)(_.screenshots(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(context)(_.context(_))
        .build

    def stopJobRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      jobId: Option[String] = None
    ): StopJobRequest =
      StopJobRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(jobId)(_.jobId(_))
        .build

    def subDomain(
      subDomainSetting: Option[SubDomainSetting] = None,
      verified: Option[Boolean] = None,
      dnsRecord: Option[String] = None
    ): SubDomain =
      SubDomain
        .builder
        .ifSome(subDomainSetting)(_.subDomainSetting(_))
        .ifSome(verified)(_.verified(_))
        .ifSome(dnsRecord)(_.dnsRecord(_))
        .build

    def subDomainSetting(
      prefix: Option[String] = None,
      branchName: Option[String] = None
    ): SubDomainSetting =
      SubDomainSetting
        .builder
        .ifSome(prefix)(_.prefix(_))
        .ifSome(branchName)(_.branchName(_))
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

    def unauthorizedException(
      message: Option[String] = None
    ): UnauthorizedException =
      UnauthorizedException
        .builder
        .ifSome(message)(_.message(_))
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

    def updateAppRequest(
      appId: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      platform: Option[String] = None,
      iamServiceRoleArn: Option[String] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      enableBranchAutoBuild: Option[Boolean] = None,
      enableBranchAutoDeletion: Option[Boolean] = None,
      enableBasicAuth: Option[Boolean] = None,
      basicAuthCredentials: Option[String] = None,
      customRules: Option[List[CustomRule]] = None,
      buildSpec: Option[String] = None,
      customHeaders: Option[String] = None,
      enableAutoBranchCreation: Option[Boolean] = None,
      autoBranchCreationPatterns: Option[List[AutoBranchCreationPattern]] = None,
      autoBranchCreationConfig: Option[AutoBranchCreationConfig] = None,
      repository: Option[String] = None,
      oauthToken: Option[String] = None,
      accessToken: Option[String] = None
    ): UpdateAppRequest =
      UpdateAppRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(iamServiceRoleArn)(_.iamServiceRoleArn(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(enableBranchAutoBuild)(_.enableBranchAutoBuild(_))
        .ifSome(enableBranchAutoDeletion)(_.enableBranchAutoDeletion(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(customRules)(_.customRules(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(customHeaders)(_.customHeaders(_))
        .ifSome(enableAutoBranchCreation)(_.enableAutoBranchCreation(_))
        .ifSome(autoBranchCreationPatterns)(_.autoBranchCreationPatterns(_))
        .ifSome(autoBranchCreationConfig)(_.autoBranchCreationConfig(_))
        .ifSome(repository)(_.repository(_))
        .ifSome(oauthToken)(_.oauthToken(_))
        .ifSome(accessToken)(_.accessToken(_))
        .build

    def updateBranchRequest(
      appId: Option[String] = None,
      branchName: Option[String] = None,
      description: Option[String] = None,
      framework: Option[String] = None,
      stage: Option[String] = None,
      enableNotification: Option[Boolean] = None,
      enableAutoBuild: Option[Boolean] = None,
      environmentVariables: Option[EnvironmentVariables] = None,
      basicAuthCredentials: Option[String] = None,
      enableBasicAuth: Option[Boolean] = None,
      enablePerformanceMode: Option[Boolean] = None,
      buildSpec: Option[String] = None,
      ttl: Option[String] = None,
      displayName: Option[String] = None,
      enablePullRequestPreview: Option[Boolean] = None,
      pullRequestEnvironmentName: Option[String] = None,
      backendEnvironmentArn: Option[String] = None
    ): UpdateBranchRequest =
      UpdateBranchRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .ifSome(framework)(_.framework(_))
        .ifSome(stage)(_.stage(_))
        .ifSome(enableNotification)(_.enableNotification(_))
        .ifSome(enableAutoBuild)(_.enableAutoBuild(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(basicAuthCredentials)(_.basicAuthCredentials(_))
        .ifSome(enableBasicAuth)(_.enableBasicAuth(_))
        .ifSome(enablePerformanceMode)(_.enablePerformanceMode(_))
        .ifSome(buildSpec)(_.buildSpec(_))
        .ifSome(ttl)(_.ttl(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(enablePullRequestPreview)(_.enablePullRequestPreview(_))
        .ifSome(pullRequestEnvironmentName)(_.pullRequestEnvironmentName(_))
        .ifSome(backendEnvironmentArn)(_.backendEnvironmentArn(_))
        .build

    def updateDomainAssociationRequest(
      appId: Option[String] = None,
      domainName: Option[String] = None,
      enableAutoSubDomain: Option[Boolean] = None,
      subDomainSettings: Option[List[SubDomainSetting]] = None,
      autoSubDomainCreationPatterns: Option[List[AutoSubDomainCreationPattern]] = None,
      autoSubDomainIAMRole: Option[String] = None
    ): UpdateDomainAssociationRequest =
      UpdateDomainAssociationRequest
        .builder
        .ifSome(appId)(_.appId(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(enableAutoSubDomain)(_.enableAutoSubDomain(_))
        .ifSome(subDomainSettings)(_.subDomainSettings(_))
        .ifSome(autoSubDomainCreationPatterns)(_.autoSubDomainCreationPatterns(_))
        .ifSome(autoSubDomainIAMRole)(_.autoSubDomainIAMRole(_))
        .build

    def updateWebhookRequest(
      webhookId: Option[String] = None,
      branchName: Option[String] = None,
      description: Option[String] = None
    ): UpdateWebhookRequest =
      UpdateWebhookRequest
        .builder
        .ifSome(webhookId)(_.webhookId(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .build

    def webhook(
      webhookArn: Option[String] = None,
      webhookId: Option[String] = None,
      webhookUrl: Option[String] = None,
      branchName: Option[String] = None,
      description: Option[String] = None,
      createTime: Option[CreateTime] = None,
      updateTime: Option[UpdateTime] = None
    ): Webhook =
      Webhook
        .builder
        .ifSome(webhookArn)(_.webhookArn(_))
        .ifSome(webhookId)(_.webhookId(_))
        .ifSome(webhookUrl)(_.webhookUrl(_))
        .ifSome(branchName)(_.branchName(_))
        .ifSome(description)(_.description(_))
        .ifSome(createTime)(_.createTime(_))
        .ifSome(updateTime)(_.updateTime(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
