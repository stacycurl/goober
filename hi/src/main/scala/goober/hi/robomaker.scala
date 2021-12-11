package goober.hi

import goober.free.robomaker.RoboMakerIO
import software.amazon.awssdk.services.robomaker.model._


object robomaker {
  import goober.free.{robomaker ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def batchDeleteWorldsRequest(
      worlds: Option[List[Arn]] = None
    ): BatchDeleteWorldsRequest =
      BatchDeleteWorldsRequest
        .builder
        .ifSome(worlds)(_.worlds(_))
        .build

    def batchDeleteWorldsResponse(
      unprocessedWorlds: Option[List[Arn]] = None
    ): BatchDeleteWorldsResponse =
      BatchDeleteWorldsResponse
        .builder
        .ifSome(unprocessedWorlds)(_.unprocessedWorlds(_))
        .build

    def batchDescribeSimulationJobRequest(
      jobs: Option[List[Arn]] = None
    ): BatchDescribeSimulationJobRequest =
      BatchDescribeSimulationJobRequest
        .builder
        .ifSome(jobs)(_.jobs(_))
        .build

    def batchDescribeSimulationJobResponse(
      jobs: Option[List[SimulationJob]] = None,
      unprocessedJobs: Option[List[Arn]] = None
    ): BatchDescribeSimulationJobResponse =
      BatchDescribeSimulationJobResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(unprocessedJobs)(_.unprocessedJobs(_))
        .build

    def batchPolicy(
      timeoutInSeconds: Option[BatchTimeoutInSeconds] = None,
      maxConcurrency: Option[Int] = None
    ): BatchPolicy =
      BatchPolicy
        .builder
        .ifSome(timeoutInSeconds)(_.timeoutInSeconds(_))
        .ifSome(maxConcurrency)(_.maxConcurrency(_))
        .build

    def cancelDeploymentJobRequest(
      job: Option[String] = None
    ): CancelDeploymentJobRequest =
      CancelDeploymentJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def cancelDeploymentJobResponse(

    ): CancelDeploymentJobResponse =
      CancelDeploymentJobResponse
        .builder

        .build

    def cancelSimulationJobBatchRequest(
      batch: Option[String] = None
    ): CancelSimulationJobBatchRequest =
      CancelSimulationJobBatchRequest
        .builder
        .ifSome(batch)(_.batch(_))
        .build

    def cancelSimulationJobBatchResponse(

    ): CancelSimulationJobBatchResponse =
      CancelSimulationJobBatchResponse
        .builder

        .build

    def cancelSimulationJobRequest(
      job: Option[String] = None
    ): CancelSimulationJobRequest =
      CancelSimulationJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def cancelSimulationJobResponse(

    ): CancelSimulationJobResponse =
      CancelSimulationJobResponse
        .builder

        .build

    def cancelWorldExportJobRequest(
      job: Option[String] = None
    ): CancelWorldExportJobRequest =
      CancelWorldExportJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def cancelWorldExportJobResponse(

    ): CancelWorldExportJobResponse =
      CancelWorldExportJobResponse
        .builder

        .build

    def cancelWorldGenerationJobRequest(
      job: Option[String] = None
    ): CancelWorldGenerationJobRequest =
      CancelWorldGenerationJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def cancelWorldGenerationJobResponse(

    ): CancelWorldGenerationJobResponse =
      CancelWorldGenerationJobResponse
        .builder

        .build

    def compute(
      simulationUnitLimit: Option[Int] = None
    ): Compute =
      Compute
        .builder
        .ifSome(simulationUnitLimit)(_.simulationUnitLimit(_))
        .build

    def computeResponse(
      simulationUnitLimit: Option[Int] = None
    ): ComputeResponse =
      ComputeResponse
        .builder
        .ifSome(simulationUnitLimit)(_.simulationUnitLimit(_))
        .build

    def concurrentDeploymentException(
      message: Option[String] = None
    ): ConcurrentDeploymentException =
      ConcurrentDeploymentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createDeploymentJobRequest(
      deploymentConfig: Option[DeploymentConfig] = None,
      clientRequestToken: Option[String] = None,
      fleet: Option[String] = None,
      deploymentApplicationConfigs: Option[List[DeploymentApplicationConfig]] = None,
      tags: Option[TagMap] = None
    ): CreateDeploymentJobRequest =
      CreateDeploymentJobRequest
        .builder
        .ifSome(deploymentConfig)(_.deploymentConfig(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(fleet)(_.fleet(_))
        .ifSome(deploymentApplicationConfigs)(_.deploymentApplicationConfigs(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDeploymentJobResponse(
      arn: Option[String] = None,
      fleet: Option[String] = None,
      status: Option[String] = None,
      deploymentApplicationConfigs: Option[List[DeploymentApplicationConfig]] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      deploymentConfig: Option[DeploymentConfig] = None,
      tags: Option[TagMap] = None
    ): CreateDeploymentJobResponse =
      CreateDeploymentJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(fleet)(_.fleet(_))
        .ifSome(status)(_.status(_))
        .ifSome(deploymentApplicationConfigs)(_.deploymentApplicationConfigs(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(deploymentConfig)(_.deploymentConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFleetRequest(
      name: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateFleetRequest =
      CreateFleetRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createFleetResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      tags: Option[TagMap] = None
    ): CreateFleetResponse =
      CreateFleetResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRobotApplicationRequest(
      name: Option[String] = None,
      sources: Option[List[SourceConfig]] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      tags: Option[TagMap] = None
    ): CreateRobotApplicationRequest =
      CreateRobotApplicationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRobotApplicationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      revisionId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateRobotApplicationResponse =
      CreateRobotApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRobotApplicationVersionRequest(
      application: Option[String] = None,
      currentRevisionId: Option[String] = None
    ): CreateRobotApplicationVersionRequest =
      CreateRobotApplicationVersionRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(currentRevisionId)(_.currentRevisionId(_))
        .build

    def createRobotApplicationVersionResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      revisionId: Option[String] = None
    ): CreateRobotApplicationVersionResponse =
      CreateRobotApplicationVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def createRobotRequest(
      name: Option[String] = None,
      architecture: Option[String] = None,
      greengrassGroupId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateRobotRequest =
      CreateRobotRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(greengrassGroupId)(_.greengrassGroupId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRobotResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      greengrassGroupId: Option[String] = None,
      architecture: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateRobotResponse =
      CreateRobotResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(greengrassGroupId)(_.greengrassGroupId(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSimulationApplicationRequest(
      name: Option[String] = None,
      sources: Option[List[SourceConfig]] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      renderingEngine: Option[RenderingEngine] = None,
      tags: Option[TagMap] = None
    ): CreateSimulationApplicationRequest =
      CreateSimulationApplicationRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(renderingEngine)(_.renderingEngine(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSimulationApplicationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      renderingEngine: Option[RenderingEngine] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      revisionId: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateSimulationApplicationResponse =
      CreateSimulationApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(renderingEngine)(_.renderingEngine(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSimulationApplicationVersionRequest(
      application: Option[String] = None,
      currentRevisionId: Option[String] = None
    ): CreateSimulationApplicationVersionRequest =
      CreateSimulationApplicationVersionRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(currentRevisionId)(_.currentRevisionId(_))
        .build

    def createSimulationApplicationVersionResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      renderingEngine: Option[RenderingEngine] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      revisionId: Option[String] = None
    ): CreateSimulationApplicationVersionResponse =
      CreateSimulationApplicationVersionResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(renderingEngine)(_.renderingEngine(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def createSimulationJobRequest(
      clientRequestToken: Option[String] = None,
      outputLocation: Option[OutputLocation] = None,
      loggingConfig: Option[LoggingConfig] = None,
      maxJobDurationInSeconds: Option[JobDuration] = None,
      iamRole: Option[String] = None,
      failureBehavior: Option[String] = None,
      robotApplications: Option[List[RobotApplicationConfig]] = None,
      simulationApplications: Option[List[SimulationApplicationConfig]] = None,
      dataSources: Option[List[DataSourceConfig]] = None,
      tags: Option[TagMap] = None,
      vpcConfig: Option[VPCConfig] = None,
      compute: Option[Compute] = None
    ): CreateSimulationJobRequest =
      CreateSimulationJobRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(maxJobDurationInSeconds)(_.maxJobDurationInSeconds(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(failureBehavior)(_.failureBehavior(_))
        .ifSome(robotApplications)(_.robotApplications(_))
        .ifSome(simulationApplications)(_.simulationApplications(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(compute)(_.compute(_))
        .build

    def createSimulationJobResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      lastStartedAt: Option[LastStartedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      failureBehavior: Option[String] = None,
      failureCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      outputLocation: Option[OutputLocation] = None,
      loggingConfig: Option[LoggingConfig] = None,
      maxJobDurationInSeconds: Option[JobDuration] = None,
      simulationTimeMillis: Option[SimulationTimeMillis] = None,
      iamRole: Option[String] = None,
      robotApplications: Option[List[RobotApplicationConfig]] = None,
      simulationApplications: Option[List[SimulationApplicationConfig]] = None,
      dataSources: Option[List[DataSource]] = None,
      tags: Option[TagMap] = None,
      vpcConfig: Option[VPCConfigResponse] = None,
      compute: Option[ComputeResponse] = None
    ): CreateSimulationJobResponse =
      CreateSimulationJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastStartedAt)(_.lastStartedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(failureBehavior)(_.failureBehavior(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(maxJobDurationInSeconds)(_.maxJobDurationInSeconds(_))
        .ifSome(simulationTimeMillis)(_.simulationTimeMillis(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(robotApplications)(_.robotApplications(_))
        .ifSome(simulationApplications)(_.simulationApplications(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(compute)(_.compute(_))
        .build

    def createWorldExportJobRequest(
      clientRequestToken: Option[String] = None,
      worlds: Option[List[Arn]] = None,
      outputLocation: Option[OutputLocation] = None,
      iamRole: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateWorldExportJobRequest =
      CreateWorldExportJobRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(worlds)(_.worlds(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorldExportJobResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      failureCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      outputLocation: Option[OutputLocation] = None,
      iamRole: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateWorldExportJobResponse =
      CreateWorldExportJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorldGenerationJobRequest(
      clientRequestToken: Option[String] = None,
      template: Option[String] = None,
      worldCount: Option[WorldCount] = None,
      tags: Option[TagMap] = None,
      worldTags: Option[TagMap] = None
    ): CreateWorldGenerationJobRequest =
      CreateWorldGenerationJobRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(template)(_.template(_))
        .ifSome(worldCount)(_.worldCount(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(worldTags)(_.worldTags(_))
        .build

    def createWorldGenerationJobResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      failureCode: Option[String] = None,
      clientRequestToken: Option[String] = None,
      template: Option[String] = None,
      worldCount: Option[WorldCount] = None,
      tags: Option[TagMap] = None,
      worldTags: Option[TagMap] = None
    ): CreateWorldGenerationJobResponse =
      CreateWorldGenerationJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(template)(_.template(_))
        .ifSome(worldCount)(_.worldCount(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(worldTags)(_.worldTags(_))
        .build

    def createWorldTemplateRequest(
      clientRequestToken: Option[String] = None,
      name: Option[String] = None,
      templateBody: Option[String] = None,
      templateLocation: Option[TemplateLocation] = None,
      tags: Option[TagMap] = None
    ): CreateWorldTemplateRequest =
      CreateWorldTemplateRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateLocation)(_.templateLocation(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createWorldTemplateResponse(
      arn: Option[String] = None,
      clientRequestToken: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      name: Option[String] = None,
      tags: Option[TagMap] = None
    ): CreateWorldTemplateResponse =
      CreateWorldTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(tags)(_.tags(_))
        .build

    def dataSource(
      name: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3Keys: Option[List[S3KeyOutput]] = None
    ): DataSource =
      DataSource
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Keys)(_.s3Keys(_))
        .build

    def dataSourceConfig(
      name: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3Keys: Option[List[S3Key]] = None
    ): DataSourceConfig =
      DataSourceConfig
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Keys)(_.s3Keys(_))
        .build

    def deleteFleetRequest(
      fleet: Option[String] = None
    ): DeleteFleetRequest =
      DeleteFleetRequest
        .builder
        .ifSome(fleet)(_.fleet(_))
        .build

    def deleteFleetResponse(

    ): DeleteFleetResponse =
      DeleteFleetResponse
        .builder

        .build

    def deleteRobotApplicationRequest(
      application: Option[String] = None,
      applicationVersion: Option[String] = None
    ): DeleteRobotApplicationRequest =
      DeleteRobotApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .build

    def deleteRobotApplicationResponse(

    ): DeleteRobotApplicationResponse =
      DeleteRobotApplicationResponse
        .builder

        .build

    def deleteRobotRequest(
      robot: Option[String] = None
    ): DeleteRobotRequest =
      DeleteRobotRequest
        .builder
        .ifSome(robot)(_.robot(_))
        .build

    def deleteRobotResponse(

    ): DeleteRobotResponse =
      DeleteRobotResponse
        .builder

        .build

    def deleteSimulationApplicationRequest(
      application: Option[String] = None,
      applicationVersion: Option[String] = None
    ): DeleteSimulationApplicationRequest =
      DeleteSimulationApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .build

    def deleteSimulationApplicationResponse(

    ): DeleteSimulationApplicationResponse =
      DeleteSimulationApplicationResponse
        .builder

        .build

    def deleteWorldTemplateRequest(
      template: Option[String] = None
    ): DeleteWorldTemplateRequest =
      DeleteWorldTemplateRequest
        .builder
        .ifSome(template)(_.template(_))
        .build

    def deleteWorldTemplateResponse(

    ): DeleteWorldTemplateResponse =
      DeleteWorldTemplateResponse
        .builder

        .build

    def deploymentApplicationConfig(
      application: Option[String] = None,
      applicationVersion: Option[String] = None,
      launchConfig: Option[DeploymentLaunchConfig] = None
    ): DeploymentApplicationConfig =
      DeploymentApplicationConfig
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .ifSome(launchConfig)(_.launchConfig(_))
        .build

    def deploymentConfig(
      concurrentDeploymentPercentage: Option[Int] = None,
      failureThresholdPercentage: Option[Int] = None,
      robotDeploymentTimeoutInSeconds: Option[DeploymentTimeout] = None,
      downloadConditionFile: Option[S3Object] = None
    ): DeploymentConfig =
      DeploymentConfig
        .builder
        .ifSome(concurrentDeploymentPercentage)(_.concurrentDeploymentPercentage(_))
        .ifSome(failureThresholdPercentage)(_.failureThresholdPercentage(_))
        .ifSome(robotDeploymentTimeoutInSeconds)(_.robotDeploymentTimeoutInSeconds(_))
        .ifSome(downloadConditionFile)(_.downloadConditionFile(_))
        .build

    def deploymentJob(
      arn: Option[String] = None,
      fleet: Option[String] = None,
      status: Option[String] = None,
      deploymentApplicationConfigs: Option[List[DeploymentApplicationConfig]] = None,
      deploymentConfig: Option[DeploymentConfig] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None,
      createdAt: Option[CreatedAt] = None
    ): DeploymentJob =
      DeploymentJob
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(fleet)(_.fleet(_))
        .ifSome(status)(_.status(_))
        .ifSome(deploymentApplicationConfigs)(_.deploymentApplicationConfigs(_))
        .ifSome(deploymentConfig)(_.deploymentConfig(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def deploymentLaunchConfig(
      packageName: Option[String] = None,
      preLaunchFile: Option[String] = None,
      launchFile: Option[String] = None,
      postLaunchFile: Option[String] = None,
      environmentVariables: Option[EnvironmentVariableMap] = None
    ): DeploymentLaunchConfig =
      DeploymentLaunchConfig
        .builder
        .ifSome(packageName)(_.packageName(_))
        .ifSome(preLaunchFile)(_.preLaunchFile(_))
        .ifSome(launchFile)(_.launchFile(_))
        .ifSome(postLaunchFile)(_.postLaunchFile(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .build

    def deregisterRobotRequest(
      fleet: Option[String] = None,
      robot: Option[String] = None
    ): DeregisterRobotRequest =
      DeregisterRobotRequest
        .builder
        .ifSome(fleet)(_.fleet(_))
        .ifSome(robot)(_.robot(_))
        .build

    def deregisterRobotResponse(
      fleet: Option[String] = None,
      robot: Option[String] = None
    ): DeregisterRobotResponse =
      DeregisterRobotResponse
        .builder
        .ifSome(fleet)(_.fleet(_))
        .ifSome(robot)(_.robot(_))
        .build

    def describeDeploymentJobRequest(
      job: Option[String] = None
    ): DescribeDeploymentJobRequest =
      DescribeDeploymentJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def describeDeploymentJobResponse(
      arn: Option[String] = None,
      fleet: Option[String] = None,
      status: Option[String] = None,
      deploymentConfig: Option[DeploymentConfig] = None,
      deploymentApplicationConfigs: Option[List[DeploymentApplicationConfig]] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      robotDeploymentSummary: Option[List[RobotDeployment]] = None,
      tags: Option[TagMap] = None
    ): DescribeDeploymentJobResponse =
      DescribeDeploymentJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(fleet)(_.fleet(_))
        .ifSome(status)(_.status(_))
        .ifSome(deploymentConfig)(_.deploymentConfig(_))
        .ifSome(deploymentApplicationConfigs)(_.deploymentApplicationConfigs(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(robotDeploymentSummary)(_.robotDeploymentSummary(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeFleetRequest(
      fleet: Option[String] = None
    ): DescribeFleetRequest =
      DescribeFleetRequest
        .builder
        .ifSome(fleet)(_.fleet(_))
        .build

    def describeFleetResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      robots: Option[List[Robot]] = None,
      createdAt: Option[CreatedAt] = None,
      lastDeploymentStatus: Option[String] = None,
      lastDeploymentJob: Option[String] = None,
      lastDeploymentTime: Option[CreatedAt] = None,
      tags: Option[TagMap] = None
    ): DescribeFleetResponse =
      DescribeFleetResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(robots)(_.robots(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastDeploymentStatus)(_.lastDeploymentStatus(_))
        .ifSome(lastDeploymentJob)(_.lastDeploymentJob(_))
        .ifSome(lastDeploymentTime)(_.lastDeploymentTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeRobotApplicationRequest(
      application: Option[String] = None,
      applicationVersion: Option[String] = None
    ): DescribeRobotApplicationRequest =
      DescribeRobotApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .build

    def describeRobotApplicationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      revisionId: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      tags: Option[TagMap] = None
    ): DescribeRobotApplicationResponse =
      DescribeRobotApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeRobotRequest(
      robot: Option[String] = None
    ): DescribeRobotRequest =
      DescribeRobotRequest
        .builder
        .ifSome(robot)(_.robot(_))
        .build

    def describeRobotResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      fleetArn: Option[String] = None,
      status: Option[String] = None,
      greengrassGroupId: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      architecture: Option[String] = None,
      lastDeploymentJob: Option[String] = None,
      lastDeploymentTime: Option[CreatedAt] = None,
      tags: Option[TagMap] = None
    ): DescribeRobotResponse =
      DescribeRobotResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(greengrassGroupId)(_.greengrassGroupId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(lastDeploymentJob)(_.lastDeploymentJob(_))
        .ifSome(lastDeploymentTime)(_.lastDeploymentTime(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeSimulationApplicationRequest(
      application: Option[String] = None,
      applicationVersion: Option[String] = None
    ): DescribeSimulationApplicationRequest =
      DescribeSimulationApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .build

    def describeSimulationApplicationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      renderingEngine: Option[RenderingEngine] = None,
      revisionId: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      tags: Option[TagMap] = None
    ): DescribeSimulationApplicationResponse =
      DescribeSimulationApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(renderingEngine)(_.renderingEngine(_))
        .ifSome(revisionId)(_.revisionId(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeSimulationJobBatchRequest(
      batch: Option[String] = None
    ): DescribeSimulationJobBatchRequest =
      DescribeSimulationJobBatchRequest
        .builder
        .ifSome(batch)(_.batch(_))
        .build

    def describeSimulationJobBatchResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      createdAt: Option[CreatedAt] = None,
      clientRequestToken: Option[String] = None,
      batchPolicy: Option[BatchPolicy] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None,
      failedRequests: Option[List[FailedCreateSimulationJobRequest]] = None,
      pendingRequests: Option[List[SimulationJobRequest]] = None,
      createdRequests: Option[List[SimulationJobSummary]] = None,
      tags: Option[TagMap] = None
    ): DescribeSimulationJobBatchResponse =
      DescribeSimulationJobBatchResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(batchPolicy)(_.batchPolicy(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failedRequests)(_.failedRequests(_))
        .ifSome(pendingRequests)(_.pendingRequests(_))
        .ifSome(createdRequests)(_.createdRequests(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeSimulationJobRequest(
      job: Option[String] = None
    ): DescribeSimulationJobRequest =
      DescribeSimulationJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def describeSimulationJobResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      lastStartedAt: Option[LastStartedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      failureBehavior: Option[String] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None,
      clientRequestToken: Option[String] = None,
      outputLocation: Option[OutputLocation] = None,
      loggingConfig: Option[LoggingConfig] = None,
      maxJobDurationInSeconds: Option[JobDuration] = None,
      simulationTimeMillis: Option[SimulationTimeMillis] = None,
      iamRole: Option[String] = None,
      robotApplications: Option[List[RobotApplicationConfig]] = None,
      simulationApplications: Option[List[SimulationApplicationConfig]] = None,
      dataSources: Option[List[DataSource]] = None,
      tags: Option[TagMap] = None,
      vpcConfig: Option[VPCConfigResponse] = None,
      networkInterface: Option[NetworkInterface] = None,
      compute: Option[ComputeResponse] = None
    ): DescribeSimulationJobResponse =
      DescribeSimulationJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastStartedAt)(_.lastStartedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(failureBehavior)(_.failureBehavior(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(maxJobDurationInSeconds)(_.maxJobDurationInSeconds(_))
        .ifSome(simulationTimeMillis)(_.simulationTimeMillis(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(robotApplications)(_.robotApplications(_))
        .ifSome(simulationApplications)(_.simulationApplications(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(networkInterface)(_.networkInterface(_))
        .ifSome(compute)(_.compute(_))
        .build

    def describeWorldExportJobRequest(
      job: Option[String] = None
    ): DescribeWorldExportJobRequest =
      DescribeWorldExportJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def describeWorldExportJobResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None,
      clientRequestToken: Option[String] = None,
      worlds: Option[List[Arn]] = None,
      outputLocation: Option[OutputLocation] = None,
      iamRole: Option[String] = None,
      tags: Option[TagMap] = None
    ): DescribeWorldExportJobResponse =
      DescribeWorldExportJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(worlds)(_.worlds(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeWorldGenerationJobRequest(
      job: Option[String] = None
    ): DescribeWorldGenerationJobRequest =
      DescribeWorldGenerationJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def describeWorldGenerationJobResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None,
      clientRequestToken: Option[String] = None,
      template: Option[String] = None,
      worldCount: Option[WorldCount] = None,
      finishedWorldsSummary: Option[FinishedWorldsSummary] = None,
      tags: Option[TagMap] = None,
      worldTags: Option[TagMap] = None
    ): DescribeWorldGenerationJobResponse =
      DescribeWorldGenerationJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(template)(_.template(_))
        .ifSome(worldCount)(_.worldCount(_))
        .ifSome(finishedWorldsSummary)(_.finishedWorldsSummary(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(worldTags)(_.worldTags(_))
        .build

    def describeWorldRequest(
      world: Option[String] = None
    ): DescribeWorldRequest =
      DescribeWorldRequest
        .builder
        .ifSome(world)(_.world(_))
        .build

    def describeWorldResponse(
      arn: Option[String] = None,
      generationJob: Option[String] = None,
      template: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      tags: Option[TagMap] = None
    ): DescribeWorldResponse =
      DescribeWorldResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(generationJob)(_.generationJob(_))
        .ifSome(template)(_.template(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def describeWorldTemplateRequest(
      template: Option[String] = None
    ): DescribeWorldTemplateRequest =
      DescribeWorldTemplateRequest
        .builder
        .ifSome(template)(_.template(_))
        .build

    def describeWorldTemplateResponse(
      arn: Option[String] = None,
      clientRequestToken: Option[String] = None,
      name: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      tags: Option[TagMap] = None
    ): DescribeWorldTemplateResponse =
      DescribeWorldTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(tags)(_.tags(_))
        .build

    def failedCreateSimulationJobRequest(
      request: Option[SimulationJobRequest] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None,
      failedAt: Option[FailedAt] = None
    ): FailedCreateSimulationJobRequest =
      FailedCreateSimulationJobRequest
        .builder
        .ifSome(request)(_.request(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failedAt)(_.failedAt(_))
        .build

    def failureSummary(
      totalFailureCount: Option[Int] = None,
      failures: Option[List[WorldFailure]] = None
    ): FailureSummary =
      FailureSummary
        .builder
        .ifSome(totalFailureCount)(_.totalFailureCount(_))
        .ifSome(failures)(_.failures(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[Name]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def finishedWorldsSummary(
      finishedCount: Option[Int] = None,
      succeededWorlds: Option[List[Arn]] = None,
      failureSummary: Option[FailureSummary] = None
    ): FinishedWorldsSummary =
      FinishedWorldsSummary
        .builder
        .ifSome(finishedCount)(_.finishedCount(_))
        .ifSome(succeededWorlds)(_.succeededWorlds(_))
        .ifSome(failureSummary)(_.failureSummary(_))
        .build

    def fleet(
      name: Option[String] = None,
      arn: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      lastDeploymentStatus: Option[String] = None,
      lastDeploymentJob: Option[String] = None,
      lastDeploymentTime: Option[CreatedAt] = None
    ): Fleet =
      Fleet
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastDeploymentStatus)(_.lastDeploymentStatus(_))
        .ifSome(lastDeploymentJob)(_.lastDeploymentJob(_))
        .ifSome(lastDeploymentTime)(_.lastDeploymentTime(_))
        .build

    def getWorldTemplateBodyRequest(
      template: Option[String] = None,
      generationJob: Option[String] = None
    ): GetWorldTemplateBodyRequest =
      GetWorldTemplateBodyRequest
        .builder
        .ifSome(template)(_.template(_))
        .ifSome(generationJob)(_.generationJob(_))
        .build

    def getWorldTemplateBodyResponse(
      templateBody: Option[String] = None
    ): GetWorldTemplateBodyResponse =
      GetWorldTemplateBodyResponse
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServerException(
      message: Option[String] = None
    ): InternalServerException =
      InternalServerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidParameterException(
      message: Option[String] = None
    ): InvalidParameterException =
      InvalidParameterException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def launchConfig(
      packageName: Option[String] = None,
      launchFile: Option[String] = None,
      environmentVariables: Option[EnvironmentVariableMap] = None,
      portForwardingConfig: Option[PortForwardingConfig] = None,
      streamUI: Option[Boolean] = None
    ): LaunchConfig =
      LaunchConfig
        .builder
        .ifSome(packageName)(_.packageName(_))
        .ifSome(launchFile)(_.launchFile(_))
        .ifSome(environmentVariables)(_.environmentVariables(_))
        .ifSome(portForwardingConfig)(_.portForwardingConfig(_))
        .ifSome(streamUI)(_.streamUI(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listDeploymentJobsRequest(
      filters: Option[List[Filter]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDeploymentJobsRequest =
      ListDeploymentJobsRequest
        .builder
        .ifSome(filters)(_.filters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDeploymentJobsResponse(
      deploymentJobs: Option[List[DeploymentJob]] = None,
      nextToken: Option[String] = None
    ): ListDeploymentJobsResponse =
      ListDeploymentJobsResponse
        .builder
        .ifSome(deploymentJobs)(_.deploymentJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listFleetsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListFleetsRequest =
      ListFleetsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listFleetsResponse(
      fleetDetails: Option[List[Fleet]] = None,
      nextToken: Option[String] = None
    ): ListFleetsResponse =
      ListFleetsResponse
        .builder
        .ifSome(fleetDetails)(_.fleetDetails(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRobotApplicationsRequest(
      versionQualifier: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListRobotApplicationsRequest =
      ListRobotApplicationsRequest
        .builder
        .ifSome(versionQualifier)(_.versionQualifier(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listRobotApplicationsResponse(
      robotApplicationSummaries: Option[List[RobotApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ListRobotApplicationsResponse =
      ListRobotApplicationsResponse
        .builder
        .ifSome(robotApplicationSummaries)(_.robotApplicationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRobotsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListRobotsRequest =
      ListRobotsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listRobotsResponse(
      robots: Option[List[Robot]] = None,
      nextToken: Option[String] = None
    ): ListRobotsResponse =
      ListRobotsResponse
        .builder
        .ifSome(robots)(_.robots(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSimulationApplicationsRequest(
      versionQualifier: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListSimulationApplicationsRequest =
      ListSimulationApplicationsRequest
        .builder
        .ifSome(versionQualifier)(_.versionQualifier(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listSimulationApplicationsResponse(
      simulationApplicationSummaries: Option[List[SimulationApplicationSummary]] = None,
      nextToken: Option[String] = None
    ): ListSimulationApplicationsResponse =
      ListSimulationApplicationsResponse
        .builder
        .ifSome(simulationApplicationSummaries)(_.simulationApplicationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSimulationJobBatchesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListSimulationJobBatchesRequest =
      ListSimulationJobBatchesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listSimulationJobBatchesResponse(
      simulationJobBatchSummaries: Option[List[SimulationJobBatchSummary]] = None,
      nextToken: Option[String] = None
    ): ListSimulationJobBatchesResponse =
      ListSimulationJobBatchesResponse
        .builder
        .ifSome(simulationJobBatchSummaries)(_.simulationJobBatchSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSimulationJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListSimulationJobsRequest =
      ListSimulationJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listSimulationJobsResponse(
      simulationJobSummaries: Option[List[SimulationJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListSimulationJobsResponse =
      ListSimulationJobsResponse
        .builder
        .ifSome(simulationJobSummaries)(_.simulationJobSummaries(_))
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

    def listWorldExportJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListWorldExportJobsRequest =
      ListWorldExportJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listWorldExportJobsResponse(
      worldExportJobSummaries: Option[List[WorldExportJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorldExportJobsResponse =
      ListWorldExportJobsResponse
        .builder
        .ifSome(worldExportJobSummaries)(_.worldExportJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorldGenerationJobsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListWorldGenerationJobsRequest =
      ListWorldGenerationJobsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listWorldGenerationJobsResponse(
      worldGenerationJobSummaries: Option[List[WorldGenerationJobSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorldGenerationJobsResponse =
      ListWorldGenerationJobsResponse
        .builder
        .ifSome(worldGenerationJobSummaries)(_.worldGenerationJobSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorldTemplatesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListWorldTemplatesRequest =
      ListWorldTemplatesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listWorldTemplatesResponse(
      templateSummaries: Option[List[TemplateSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorldTemplatesResponse =
      ListWorldTemplatesResponse
        .builder
        .ifSome(templateSummaries)(_.templateSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listWorldsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[Filter]] = None
    ): ListWorldsRequest =
      ListWorldsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .build

    def listWorldsResponse(
      worldSummaries: Option[List[WorldSummary]] = None,
      nextToken: Option[String] = None
    ): ListWorldsResponse =
      ListWorldsResponse
        .builder
        .ifSome(worldSummaries)(_.worldSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loggingConfig(
      recordAllRosTopics: Option[Boolean] = None
    ): LoggingConfig =
      LoggingConfig
        .builder
        .ifSome(recordAllRosTopics)(_.recordAllRosTopics(_))
        .build

    def networkInterface(
      networkInterfaceId: Option[String] = None,
      privateIpAddress: Option[String] = None,
      publicIpAddress: Option[String] = None
    ): NetworkInterface =
      NetworkInterface
        .builder
        .ifSome(networkInterfaceId)(_.networkInterfaceId(_))
        .ifSome(privateIpAddress)(_.privateIpAddress(_))
        .ifSome(publicIpAddress)(_.publicIpAddress(_))
        .build

    def outputLocation(
      s3Bucket: Option[String] = None,
      s3Prefix: Option[String] = None
    ): OutputLocation =
      OutputLocation
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .build

    def portForwardingConfig(
      portMappings: Option[List[PortMapping]] = None
    ): PortForwardingConfig =
      PortForwardingConfig
        .builder
        .ifSome(portMappings)(_.portMappings(_))
        .build

    def portMapping(
      jobPort: Option[Int] = None,
      applicationPort: Option[Int] = None,
      enableOnPublicIp: Option[Boolean] = None
    ): PortMapping =
      PortMapping
        .builder
        .ifSome(jobPort)(_.jobPort(_))
        .ifSome(applicationPort)(_.applicationPort(_))
        .ifSome(enableOnPublicIp)(_.enableOnPublicIp(_))
        .build

    def progressDetail(
      currentProgress: Option[String] = None,
      percentDone: Option[PercentDone] = None,
      estimatedTimeRemainingSeconds: Option[Int] = None,
      targetResource: Option[String] = None
    ): ProgressDetail =
      ProgressDetail
        .builder
        .ifSome(currentProgress)(_.currentProgress(_))
        .ifSome(percentDone)(_.percentDone(_))
        .ifSome(estimatedTimeRemainingSeconds)(_.estimatedTimeRemainingSeconds(_))
        .ifSome(targetResource)(_.targetResource(_))
        .build

    def registerRobotRequest(
      fleet: Option[String] = None,
      robot: Option[String] = None
    ): RegisterRobotRequest =
      RegisterRobotRequest
        .builder
        .ifSome(fleet)(_.fleet(_))
        .ifSome(robot)(_.robot(_))
        .build

    def registerRobotResponse(
      fleet: Option[String] = None,
      robot: Option[String] = None
    ): RegisterRobotResponse =
      RegisterRobotResponse
        .builder
        .ifSome(fleet)(_.fleet(_))
        .ifSome(robot)(_.robot(_))
        .build

    def renderingEngine(
      name: Option[String] = None,
      version: Option[String] = None
    ): RenderingEngine =
      RenderingEngine
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def restartSimulationJobRequest(
      job: Option[String] = None
    ): RestartSimulationJobRequest =
      RestartSimulationJobRequest
        .builder
        .ifSome(job)(_.job(_))
        .build

    def restartSimulationJobResponse(

    ): RestartSimulationJobResponse =
      RestartSimulationJobResponse
        .builder

        .build

    def robot(
      arn: Option[String] = None,
      name: Option[String] = None,
      fleetArn: Option[String] = None,
      status: Option[String] = None,
      greenGrassGroupId: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      architecture: Option[String] = None,
      lastDeploymentJob: Option[String] = None,
      lastDeploymentTime: Option[CreatedAt] = None
    ): Robot =
      Robot
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(fleetArn)(_.fleetArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(greenGrassGroupId)(_.greenGrassGroupId(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(architecture)(_.architecture(_))
        .ifSome(lastDeploymentJob)(_.lastDeploymentJob(_))
        .ifSome(lastDeploymentTime)(_.lastDeploymentTime(_))
        .build

    def robotApplicationConfig(
      application: Option[String] = None,
      applicationVersion: Option[String] = None,
      launchConfig: Option[LaunchConfig] = None,
      uploadConfigurations: Option[List[UploadConfiguration]] = None,
      useDefaultUploadConfigurations: Option[Boolean] = None,
      tools: Option[List[Tool]] = None,
      useDefaultTools: Option[Boolean] = None
    ): RobotApplicationConfig =
      RobotApplicationConfig
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .ifSome(launchConfig)(_.launchConfig(_))
        .ifSome(uploadConfigurations)(_.uploadConfigurations(_))
        .ifSome(useDefaultUploadConfigurations)(_.useDefaultUploadConfigurations(_))
        .ifSome(tools)(_.tools(_))
        .ifSome(useDefaultTools)(_.useDefaultTools(_))
        .build

    def robotApplicationSummary(
      name: Option[String] = None,
      arn: Option[String] = None,
      version: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None
    ): RobotApplicationSummary =
      RobotApplicationSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(version)(_.version(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .build

    def robotDeployment(
      arn: Option[String] = None,
      deploymentStartTime: Option[CreatedAt] = None,
      deploymentFinishTime: Option[CreatedAt] = None,
      status: Option[String] = None,
      progressDetail: Option[ProgressDetail] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None
    ): RobotDeployment =
      RobotDeployment
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(deploymentStartTime)(_.deploymentStartTime(_))
        .ifSome(deploymentFinishTime)(_.deploymentFinishTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(progressDetail)(_.progressDetail(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .build

    def robotSoftwareSuite(
      name: Option[String] = None,
      version: Option[String] = None
    ): RobotSoftwareSuite =
      RobotSoftwareSuite
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def s3KeyOutput(
      s3Key: Option[String] = None,
      etag: Option[String] = None
    ): S3KeyOutput =
      S3KeyOutput
        .builder
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(etag)(_.etag(_))
        .build

    def s3Object(
      bucket: Option[String] = None,
      key: Option[String] = None,
      etag: Option[String] = None
    ): S3Object =
      S3Object
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(etag)(_.etag(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def simulationApplicationConfig(
      application: Option[String] = None,
      applicationVersion: Option[String] = None,
      launchConfig: Option[LaunchConfig] = None,
      uploadConfigurations: Option[List[UploadConfiguration]] = None,
      worldConfigs: Option[List[WorldConfig]] = None,
      useDefaultUploadConfigurations: Option[Boolean] = None,
      tools: Option[List[Tool]] = None,
      useDefaultTools: Option[Boolean] = None
    ): SimulationApplicationConfig =
      SimulationApplicationConfig
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(applicationVersion)(_.applicationVersion(_))
        .ifSome(launchConfig)(_.launchConfig(_))
        .ifSome(uploadConfigurations)(_.uploadConfigurations(_))
        .ifSome(worldConfigs)(_.worldConfigs(_))
        .ifSome(useDefaultUploadConfigurations)(_.useDefaultUploadConfigurations(_))
        .ifSome(tools)(_.tools(_))
        .ifSome(useDefaultTools)(_.useDefaultTools(_))
        .build

    def simulationApplicationSummary(
      name: Option[String] = None,
      arn: Option[String] = None,
      version: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None
    ): SimulationApplicationSummary =
      SimulationApplicationSummary
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(version)(_.version(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .build

    def simulationJob(
      arn: Option[String] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      lastStartedAt: Option[LastStartedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      failureBehavior: Option[String] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None,
      clientRequestToken: Option[String] = None,
      outputLocation: Option[OutputLocation] = None,
      loggingConfig: Option[LoggingConfig] = None,
      maxJobDurationInSeconds: Option[JobDuration] = None,
      simulationTimeMillis: Option[SimulationTimeMillis] = None,
      iamRole: Option[String] = None,
      robotApplications: Option[List[RobotApplicationConfig]] = None,
      simulationApplications: Option[List[SimulationApplicationConfig]] = None,
      dataSources: Option[List[DataSource]] = None,
      tags: Option[TagMap] = None,
      vpcConfig: Option[VPCConfigResponse] = None,
      networkInterface: Option[NetworkInterface] = None,
      compute: Option[ComputeResponse] = None
    ): SimulationJob =
      SimulationJob
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(lastStartedAt)(_.lastStartedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(failureBehavior)(_.failureBehavior(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(maxJobDurationInSeconds)(_.maxJobDurationInSeconds(_))
        .ifSome(simulationTimeMillis)(_.simulationTimeMillis(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(robotApplications)(_.robotApplications(_))
        .ifSome(simulationApplications)(_.simulationApplications(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(networkInterface)(_.networkInterface(_))
        .ifSome(compute)(_.compute(_))
        .build

    def simulationJobBatchSummary(
      arn: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      createdAt: Option[CreatedAt] = None,
      status: Option[String] = None,
      failedRequestCount: Option[Int] = None,
      pendingRequestCount: Option[Int] = None,
      createdRequestCount: Option[Int] = None
    ): SimulationJobBatchSummary =
      SimulationJobBatchSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(failedRequestCount)(_.failedRequestCount(_))
        .ifSome(pendingRequestCount)(_.pendingRequestCount(_))
        .ifSome(createdRequestCount)(_.createdRequestCount(_))
        .build

    def simulationJobRequest(
      outputLocation: Option[OutputLocation] = None,
      loggingConfig: Option[LoggingConfig] = None,
      maxJobDurationInSeconds: Option[JobDuration] = None,
      iamRole: Option[String] = None,
      failureBehavior: Option[String] = None,
      useDefaultApplications: Option[Boolean] = None,
      robotApplications: Option[List[RobotApplicationConfig]] = None,
      simulationApplications: Option[List[SimulationApplicationConfig]] = None,
      dataSources: Option[List[DataSourceConfig]] = None,
      vpcConfig: Option[VPCConfig] = None,
      compute: Option[Compute] = None,
      tags: Option[TagMap] = None
    ): SimulationJobRequest =
      SimulationJobRequest
        .builder
        .ifSome(outputLocation)(_.outputLocation(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(maxJobDurationInSeconds)(_.maxJobDurationInSeconds(_))
        .ifSome(iamRole)(_.iamRole(_))
        .ifSome(failureBehavior)(_.failureBehavior(_))
        .ifSome(useDefaultApplications)(_.useDefaultApplications(_))
        .ifSome(robotApplications)(_.robotApplications(_))
        .ifSome(simulationApplications)(_.simulationApplications(_))
        .ifSome(dataSources)(_.dataSources(_))
        .ifSome(vpcConfig)(_.vpcConfig(_))
        .ifSome(compute)(_.compute(_))
        .ifSome(tags)(_.tags(_))
        .build

    def simulationJobSummary(
      arn: Option[String] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      name: Option[String] = None,
      status: Option[String] = None,
      simulationApplicationNames: Option[List[Name]] = None,
      robotApplicationNames: Option[List[Name]] = None,
      dataSourceNames: Option[List[Name]] = None
    ): SimulationJobSummary =
      SimulationJobSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .ifSome(status)(_.status(_))
        .ifSome(simulationApplicationNames)(_.simulationApplicationNames(_))
        .ifSome(robotApplicationNames)(_.robotApplicationNames(_))
        .ifSome(dataSourceNames)(_.dataSourceNames(_))
        .build

    def simulationSoftwareSuite(
      name: Option[String] = None,
      version: Option[String] = None
    ): SimulationSoftwareSuite =
      SimulationSoftwareSuite
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .build

    def source(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      etag: Option[String] = None,
      architecture: Option[String] = None
    ): Source =
      Source
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(etag)(_.etag(_))
        .ifSome(architecture)(_.architecture(_))
        .build

    def sourceConfig(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None,
      architecture: Option[String] = None
    ): SourceConfig =
      SourceConfig
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .ifSome(architecture)(_.architecture(_))
        .build

    def startSimulationJobBatchRequest(
      clientRequestToken: Option[String] = None,
      batchPolicy: Option[BatchPolicy] = None,
      createSimulationJobRequests: Option[List[SimulationJobRequest]] = None,
      tags: Option[TagMap] = None
    ): StartSimulationJobBatchRequest =
      StartSimulationJobBatchRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(batchPolicy)(_.batchPolicy(_))
        .ifSome(createSimulationJobRequests)(_.createSimulationJobRequests(_))
        .ifSome(tags)(_.tags(_))
        .build

    def startSimulationJobBatchResponse(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      clientRequestToken: Option[String] = None,
      batchPolicy: Option[BatchPolicy] = None,
      failureCode: Option[String] = None,
      failureReason: Option[String] = None,
      failedRequests: Option[List[FailedCreateSimulationJobRequest]] = None,
      pendingRequests: Option[List[SimulationJobRequest]] = None,
      createdRequests: Option[List[SimulationJobSummary]] = None,
      tags: Option[TagMap] = None
    ): StartSimulationJobBatchResponse =
      StartSimulationJobBatchResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(batchPolicy)(_.batchPolicy(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failedRequests)(_.failedRequests(_))
        .ifSome(pendingRequests)(_.pendingRequests(_))
        .ifSome(createdRequests)(_.createdRequests(_))
        .ifSome(tags)(_.tags(_))
        .build

    def syncDeploymentJobRequest(
      clientRequestToken: Option[String] = None,
      fleet: Option[String] = None
    ): SyncDeploymentJobRequest =
      SyncDeploymentJobRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(fleet)(_.fleet(_))
        .build

    def syncDeploymentJobResponse(
      arn: Option[String] = None,
      fleet: Option[String] = None,
      status: Option[String] = None,
      deploymentConfig: Option[DeploymentConfig] = None,
      deploymentApplicationConfigs: Option[List[DeploymentApplicationConfig]] = None,
      failureReason: Option[String] = None,
      failureCode: Option[String] = None,
      createdAt: Option[CreatedAt] = None
    ): SyncDeploymentJobResponse =
      SyncDeploymentJobResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(fleet)(_.fleet(_))
        .ifSome(status)(_.status(_))
        .ifSome(deploymentConfig)(_.deploymentConfig(_))
        .ifSome(deploymentApplicationConfigs)(_.deploymentApplicationConfigs(_))
        .ifSome(failureReason)(_.failureReason(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(createdAt)(_.createdAt(_))
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

    def templateLocation(
      s3Bucket: Option[String] = None,
      s3Key: Option[String] = None
    ): TemplateLocation =
      TemplateLocation
        .builder
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3Key)(_.s3Key(_))
        .build

    def templateSummary(
      arn: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      name: Option[String] = None
    ): TemplateSummary =
      TemplateSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(name)(_.name(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tool(
      streamUI: Option[Boolean] = None,
      name: Option[String] = None,
      command: Option[String] = None,
      streamOutputToCloudWatch: Option[Boolean] = None,
      exitBehavior: Option[String] = None
    ): Tool =
      Tool
        .builder
        .ifSome(streamUI)(_.streamUI(_))
        .ifSome(name)(_.name(_))
        .ifSome(command)(_.command(_))
        .ifSome(streamOutputToCloudWatch)(_.streamOutputToCloudWatch(_))
        .ifSome(exitBehavior)(_.exitBehavior(_))
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

    def updateRobotApplicationRequest(
      application: Option[String] = None,
      sources: Option[List[SourceConfig]] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      currentRevisionId: Option[String] = None
    ): UpdateRobotApplicationRequest =
      UpdateRobotApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(currentRevisionId)(_.currentRevisionId(_))
        .build

    def updateRobotApplicationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      revisionId: Option[String] = None
    ): UpdateRobotApplicationResponse =
      UpdateRobotApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateSimulationApplicationRequest(
      application: Option[String] = None,
      sources: Option[List[SourceConfig]] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      renderingEngine: Option[RenderingEngine] = None,
      currentRevisionId: Option[String] = None
    ): UpdateSimulationApplicationRequest =
      UpdateSimulationApplicationRequest
        .builder
        .ifSome(application)(_.application(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(renderingEngine)(_.renderingEngine(_))
        .ifSome(currentRevisionId)(_.currentRevisionId(_))
        .build

    def updateSimulationApplicationResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      version: Option[String] = None,
      sources: Option[List[Source]] = None,
      simulationSoftwareSuite: Option[SimulationSoftwareSuite] = None,
      robotSoftwareSuite: Option[RobotSoftwareSuite] = None,
      renderingEngine: Option[RenderingEngine] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None,
      revisionId: Option[String] = None
    ): UpdateSimulationApplicationResponse =
      UpdateSimulationApplicationResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(version)(_.version(_))
        .ifSome(sources)(_.sources(_))
        .ifSome(simulationSoftwareSuite)(_.simulationSoftwareSuite(_))
        .ifSome(robotSoftwareSuite)(_.robotSoftwareSuite(_))
        .ifSome(renderingEngine)(_.renderingEngine(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(revisionId)(_.revisionId(_))
        .build

    def updateWorldTemplateRequest(
      template: Option[String] = None,
      name: Option[String] = None,
      templateBody: Option[String] = None,
      templateLocation: Option[TemplateLocation] = None
    ): UpdateWorldTemplateRequest =
      UpdateWorldTemplateRequest
        .builder
        .ifSome(template)(_.template(_))
        .ifSome(name)(_.name(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateLocation)(_.templateLocation(_))
        .build

    def updateWorldTemplateResponse(
      arn: Option[String] = None,
      name: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      lastUpdatedAt: Option[LastUpdatedAt] = None
    ): UpdateWorldTemplateResponse =
      UpdateWorldTemplateResponse
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(name)(_.name(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .build

    def uploadConfiguration(
      name: Option[String] = None,
      path: Option[String] = None,
      uploadBehavior: Option[String] = None
    ): UploadConfiguration =
      UploadConfiguration
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(path)(_.path(_))
        .ifSome(uploadBehavior)(_.uploadBehavior(_))
        .build

    def vPCConfig(
      subnets: Option[List[NonEmptyString]] = None,
      securityGroups: Option[List[NonEmptyString]] = None,
      assignPublicIp: Option[Boolean] = None
    ): VPCConfig =
      VPCConfig
        .builder
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(assignPublicIp)(_.assignPublicIp(_))
        .build

    def vPCConfigResponse(
      subnets: Option[List[NonEmptyString]] = None,
      securityGroups: Option[List[NonEmptyString]] = None,
      vpcId: Option[String] = None,
      assignPublicIp: Option[Boolean] = None
    ): VPCConfigResponse =
      VPCConfigResponse
        .builder
        .ifSome(subnets)(_.subnets(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(assignPublicIp)(_.assignPublicIp(_))
        .build

    def worldConfig(
      world: Option[String] = None
    ): WorldConfig =
      WorldConfig
        .builder
        .ifSome(world)(_.world(_))
        .build

    def worldCount(
      floorplanCount: Option[Int] = None,
      interiorCountPerFloorplan: Option[Int] = None
    ): WorldCount =
      WorldCount
        .builder
        .ifSome(floorplanCount)(_.floorplanCount(_))
        .ifSome(interiorCountPerFloorplan)(_.interiorCountPerFloorplan(_))
        .build

    def worldExportJobSummary(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      worlds: Option[List[Arn]] = None
    ): WorldExportJobSummary =
      WorldExportJobSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(worlds)(_.worlds(_))
        .build

    def worldFailure(
      failureCode: Option[String] = None,
      sampleFailureReason: Option[String] = None,
      failureCount: Option[Int] = None
    ): WorldFailure =
      WorldFailure
        .builder
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(sampleFailureReason)(_.sampleFailureReason(_))
        .ifSome(failureCount)(_.failureCount(_))
        .build

    def worldGenerationJobSummary(
      arn: Option[String] = None,
      template: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      status: Option[String] = None,
      worldCount: Option[WorldCount] = None,
      succeededWorldCount: Option[Int] = None,
      failedWorldCount: Option[Int] = None
    ): WorldGenerationJobSummary =
      WorldGenerationJobSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(template)(_.template(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(status)(_.status(_))
        .ifSome(worldCount)(_.worldCount(_))
        .ifSome(succeededWorldCount)(_.succeededWorldCount(_))
        .ifSome(failedWorldCount)(_.failedWorldCount(_))
        .build

    def worldSummary(
      arn: Option[String] = None,
      createdAt: Option[CreatedAt] = None,
      generationJob: Option[String] = None,
      template: Option[String] = None
    ): WorldSummary =
      WorldSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(generationJob)(_.generationJob(_))
        .ifSome(template)(_.template(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
