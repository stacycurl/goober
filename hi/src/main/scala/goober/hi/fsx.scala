package goober.hi

import goober.free.fsx.FSxIO
import software.amazon.awssdk.services.fsx.model._


object fsx {
  import goober.free.{fsx ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def activeDirectoryBackupAttributes(
      domainName: Option[String] = None,
      activeDirectoryId: Option[String] = None,
      resourceARN: Option[String] = None
    ): ActiveDirectoryBackupAttributes =
      ActiveDirectoryBackupAttributes
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(activeDirectoryId)(_.activeDirectoryId(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .build

    def activeDirectoryError(
      activeDirectoryId: Option[String] = None,
      `type`: Option[String] = None,
      message: Option[String] = None
    ): ActiveDirectoryError =
      ActiveDirectoryError
        .builder
        .ifSome(activeDirectoryId)(_.activeDirectoryId(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(message)(_.message(_))
        .build

    def administrativeAction(
      administrativeActionType: Option[String] = None,
      progressPercent: Option[Int] = None,
      requestTime: Option[RequestTime] = None,
      status: Option[String] = None,
      targetFileSystemValues: Option[FileSystem] = None,
      failureDetails: Option[AdministrativeActionFailureDetails] = None
    ): AdministrativeAction =
      AdministrativeAction
        .builder
        .ifSome(administrativeActionType)(_.administrativeActionType(_))
        .ifSome(progressPercent)(_.progressPercent(_))
        .ifSome(requestTime)(_.requestTime(_))
        .ifSome(status)(_.status(_))
        .ifSome(targetFileSystemValues)(_.targetFileSystemValues(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .build

    def administrativeActionFailureDetails(
      message: Option[String] = None
    ): AdministrativeActionFailureDetails =
      AdministrativeActionFailureDetails
        .builder
        .ifSome(message)(_.message(_))
        .build

    def alias(
      name: Option[String] = None,
      lifecycle: Option[String] = None
    ): Alias =
      Alias
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .build

    def associateFileSystemAliasesRequest(
      clientRequestToken: Option[String] = None,
      fileSystemId: Option[String] = None,
      aliases: Option[List[AlternateDNSName]] = None
    ): AssociateFileSystemAliasesRequest =
      AssociateFileSystemAliasesRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(aliases)(_.aliases(_))
        .build

    def associateFileSystemAliasesResponse(
      aliases: Option[List[Alias]] = None
    ): AssociateFileSystemAliasesResponse =
      AssociateFileSystemAliasesResponse
        .builder
        .ifSome(aliases)(_.aliases(_))
        .build

    def backup(
      backupId: Option[String] = None,
      lifecycle: Option[String] = None,
      failureDetails: Option[BackupFailureDetails] = None,
      `type`: Option[String] = None,
      progressPercent: Option[Int] = None,
      creationTime: Option[CreationTime] = None,
      kmsKeyId: Option[String] = None,
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fileSystem: Option[FileSystem] = None,
      directoryInformation: Option[ActiveDirectoryBackupAttributes] = None,
      ownerId: Option[String] = None,
      sourceBackupId: Option[String] = None,
      sourceBackupRegion: Option[String] = None
    ): Backup =
      Backup
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(progressPercent)(_.progressPercent(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileSystem)(_.fileSystem(_))
        .ifSome(directoryInformation)(_.directoryInformation(_))
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(sourceBackupId)(_.sourceBackupId(_))
        .ifSome(sourceBackupRegion)(_.sourceBackupRegion(_))
        .build

    def backupBeingCopied(
      message: Option[String] = None,
      backupId: Option[String] = None
    ): BackupBeingCopied =
      BackupBeingCopied
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(backupId)(_.backupId(_))
        .build

    def backupFailureDetails(
      message: Option[String] = None
    ): BackupFailureDetails =
      BackupFailureDetails
        .builder
        .ifSome(message)(_.message(_))
        .build

    def backupInProgress(
      message: Option[String] = None
    ): BackupInProgress =
      BackupInProgress
        .builder
        .ifSome(message)(_.message(_))
        .build

    def backupNotFound(
      message: Option[String] = None
    ): BackupNotFound =
      BackupNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def backupRestoring(
      message: Option[String] = None,
      fileSystemId: Option[String] = None
    ): BackupRestoring =
      BackupRestoring
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .build

    def badRequest(
      message: Option[String] = None
    ): BadRequest =
      BadRequest
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelDataRepositoryTaskRequest(
      taskId: Option[String] = None
    ): CancelDataRepositoryTaskRequest =
      CancelDataRepositoryTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def cancelDataRepositoryTaskResponse(
      lifecycle: Option[String] = None,
      taskId: Option[String] = None
    ): CancelDataRepositoryTaskResponse =
      CancelDataRepositoryTaskResponse
        .builder
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(taskId)(_.taskId(_))
        .build

    def completionReport(
      enabled: Option[Boolean] = None,
      path: Option[String] = None,
      format: Option[String] = None,
      scope: Option[String] = None
    ): CompletionReport =
      CompletionReport
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(path)(_.path(_))
        .ifSome(format)(_.format(_))
        .ifSome(scope)(_.scope(_))
        .build

    def copyBackupRequest(
      clientRequestToken: Option[String] = None,
      sourceBackupId: Option[String] = None,
      sourceRegion: Option[String] = None,
      kmsKeyId: Option[String] = None,
      copyTags: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CopyBackupRequest =
      CopyBackupRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(sourceBackupId)(_.sourceBackupId(_))
        .ifSome(sourceRegion)(_.sourceRegion(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(copyTags)(_.copyTags(_))
        .ifSome(tags)(_.tags(_))
        .build

    def copyBackupResponse(
      backup: Option[Backup] = None
    ): CopyBackupResponse =
      CopyBackupResponse
        .builder
        .ifSome(backup)(_.backup(_))
        .build

    def createBackupRequest(
      fileSystemId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateBackupRequest =
      CreateBackupRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBackupResponse(
      backup: Option[Backup] = None
    ): CreateBackupResponse =
      CreateBackupResponse
        .builder
        .ifSome(backup)(_.backup(_))
        .build

    def createDataRepositoryTaskRequest(
      `type`: Option[String] = None,
      paths: Option[List[DataRepositoryTaskPath]] = None,
      fileSystemId: Option[String] = None,
      report: Option[CompletionReport] = None,
      clientRequestToken: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDataRepositoryTaskRequest =
      CreateDataRepositoryTaskRequest
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(paths)(_.paths(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(report)(_.report(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDataRepositoryTaskResponse(
      dataRepositoryTask: Option[DataRepositoryTask] = None
    ): CreateDataRepositoryTaskResponse =
      CreateDataRepositoryTaskResponse
        .builder
        .ifSome(dataRepositoryTask)(_.dataRepositoryTask(_))
        .build

    def createFileSystemFromBackupRequest(
      backupId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      tags: Option[List[Tag]] = None,
      windowsConfiguration: Option[CreateFileSystemWindowsConfiguration] = None,
      lustreConfiguration: Option[CreateFileSystemLustreConfiguration] = None,
      storageType: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): CreateFileSystemFromBackupRequest =
      CreateFileSystemFromBackupRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(windowsConfiguration)(_.windowsConfiguration(_))
        .ifSome(lustreConfiguration)(_.lustreConfiguration(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def createFileSystemFromBackupResponse(
      fileSystem: Option[FileSystem] = None
    ): CreateFileSystemFromBackupResponse =
      CreateFileSystemFromBackupResponse
        .builder
        .ifSome(fileSystem)(_.fileSystem(_))
        .build

    def createFileSystemLustreConfiguration(
      weeklyMaintenanceStartTime: Option[String] = None,
      importPath: Option[String] = None,
      exportPath: Option[String] = None,
      importedFileChunkSize: Option[Int] = None,
      deploymentType: Option[String] = None,
      autoImportPolicy: Option[String] = None,
      perUnitStorageThroughput: Option[Int] = None,
      dailyAutomaticBackupStartTime: Option[String] = None,
      automaticBackupRetentionDays: Option[Int] = None,
      copyTagsToBackups: Option[Boolean] = None,
      driveCacheType: Option[String] = None,
      dataCompressionType: Option[String] = None
    ): CreateFileSystemLustreConfiguration =
      CreateFileSystemLustreConfiguration
        .builder
        .ifSome(weeklyMaintenanceStartTime)(_.weeklyMaintenanceStartTime(_))
        .ifSome(importPath)(_.importPath(_))
        .ifSome(exportPath)(_.exportPath(_))
        .ifSome(importedFileChunkSize)(_.importedFileChunkSize(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(autoImportPolicy)(_.autoImportPolicy(_))
        .ifSome(perUnitStorageThroughput)(_.perUnitStorageThroughput(_))
        .ifSome(dailyAutomaticBackupStartTime)(_.dailyAutomaticBackupStartTime(_))
        .ifSome(automaticBackupRetentionDays)(_.automaticBackupRetentionDays(_))
        .ifSome(copyTagsToBackups)(_.copyTagsToBackups(_))
        .ifSome(driveCacheType)(_.driveCacheType(_))
        .ifSome(dataCompressionType)(_.dataCompressionType(_))
        .build

    def createFileSystemRequest(
      clientRequestToken: Option[String] = None,
      fileSystemType: Option[String] = None,
      storageCapacity: Option[Int] = None,
      storageType: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      securityGroupIds: Option[List[SecurityGroupId]] = None,
      tags: Option[List[Tag]] = None,
      kmsKeyId: Option[String] = None,
      windowsConfiguration: Option[CreateFileSystemWindowsConfiguration] = None,
      lustreConfiguration: Option[CreateFileSystemLustreConfiguration] = None
    ): CreateFileSystemRequest =
      CreateFileSystemRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(fileSystemType)(_.fileSystemType(_))
        .ifSome(storageCapacity)(_.storageCapacity(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroupIds)(_.securityGroupIds(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(windowsConfiguration)(_.windowsConfiguration(_))
        .ifSome(lustreConfiguration)(_.lustreConfiguration(_))
        .build

    def createFileSystemResponse(
      fileSystem: Option[FileSystem] = None
    ): CreateFileSystemResponse =
      CreateFileSystemResponse
        .builder
        .ifSome(fileSystem)(_.fileSystem(_))
        .build

    def createFileSystemWindowsConfiguration(
      activeDirectoryId: Option[String] = None,
      selfManagedActiveDirectoryConfiguration: Option[SelfManagedActiveDirectoryConfiguration] = None,
      deploymentType: Option[String] = None,
      preferredSubnetId: Option[String] = None,
      throughputCapacity: Option[Int] = None,
      weeklyMaintenanceStartTime: Option[String] = None,
      dailyAutomaticBackupStartTime: Option[String] = None,
      automaticBackupRetentionDays: Option[Int] = None,
      copyTagsToBackups: Option[Boolean] = None,
      aliases: Option[List[AlternateDNSName]] = None,
      auditLogConfiguration: Option[WindowsAuditLogCreateConfiguration] = None
    ): CreateFileSystemWindowsConfiguration =
      CreateFileSystemWindowsConfiguration
        .builder
        .ifSome(activeDirectoryId)(_.activeDirectoryId(_))
        .ifSome(selfManagedActiveDirectoryConfiguration)(_.selfManagedActiveDirectoryConfiguration(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(preferredSubnetId)(_.preferredSubnetId(_))
        .ifSome(throughputCapacity)(_.throughputCapacity(_))
        .ifSome(weeklyMaintenanceStartTime)(_.weeklyMaintenanceStartTime(_))
        .ifSome(dailyAutomaticBackupStartTime)(_.dailyAutomaticBackupStartTime(_))
        .ifSome(automaticBackupRetentionDays)(_.automaticBackupRetentionDays(_))
        .ifSome(copyTagsToBackups)(_.copyTagsToBackups(_))
        .ifSome(aliases)(_.aliases(_))
        .ifSome(auditLogConfiguration)(_.auditLogConfiguration(_))
        .build

    def dataRepositoryConfiguration(
      lifecycle: Option[String] = None,
      importPath: Option[String] = None,
      exportPath: Option[String] = None,
      importedFileChunkSize: Option[Int] = None,
      autoImportPolicy: Option[String] = None,
      failureDetails: Option[DataRepositoryFailureDetails] = None
    ): DataRepositoryConfiguration =
      DataRepositoryConfiguration
        .builder
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(importPath)(_.importPath(_))
        .ifSome(exportPath)(_.exportPath(_))
        .ifSome(importedFileChunkSize)(_.importedFileChunkSize(_))
        .ifSome(autoImportPolicy)(_.autoImportPolicy(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .build

    def dataRepositoryFailureDetails(
      message: Option[String] = None
    ): DataRepositoryFailureDetails =
      DataRepositoryFailureDetails
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dataRepositoryTask(
      taskId: Option[String] = None,
      lifecycle: Option[String] = None,
      `type`: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      startTime: Option[StartTime] = None,
      endTime: Option[EndTime] = None,
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      fileSystemId: Option[String] = None,
      paths: Option[List[DataRepositoryTaskPath]] = None,
      failureDetails: Option[DataRepositoryTaskFailureDetails] = None,
      status: Option[DataRepositoryTaskStatus] = None,
      report: Option[CompletionReport] = None
    ): DataRepositoryTask =
      DataRepositoryTask
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(paths)(_.paths(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .ifSome(status)(_.status(_))
        .ifSome(report)(_.report(_))
        .build

    def dataRepositoryTaskEnded(
      message: Option[String] = None
    ): DataRepositoryTaskEnded =
      DataRepositoryTaskEnded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dataRepositoryTaskExecuting(
      message: Option[String] = None
    ): DataRepositoryTaskExecuting =
      DataRepositoryTaskExecuting
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dataRepositoryTaskFailureDetails(
      message: Option[String] = None
    ): DataRepositoryTaskFailureDetails =
      DataRepositoryTaskFailureDetails
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dataRepositoryTaskFilter(
      name: Option[String] = None,
      values: Option[List[DataRepositoryTaskFilterValue]] = None
    ): DataRepositoryTaskFilter =
      DataRepositoryTaskFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def dataRepositoryTaskNotFound(
      message: Option[String] = None
    ): DataRepositoryTaskNotFound =
      DataRepositoryTaskNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def dataRepositoryTaskStatus(
      totalCount: Option[TotalCount] = None,
      succeededCount: Option[SucceededCount] = None,
      failedCount: Option[FailedCount] = None,
      lastUpdatedTime: Option[LastUpdatedTime] = None
    ): DataRepositoryTaskStatus =
      DataRepositoryTaskStatus
        .builder
        .ifSome(totalCount)(_.totalCount(_))
        .ifSome(succeededCount)(_.succeededCount(_))
        .ifSome(failedCount)(_.failedCount(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .build

    def deleteBackupRequest(
      backupId: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): DeleteBackupRequest =
      DeleteBackupRequest
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def deleteBackupResponse(
      backupId: Option[String] = None,
      lifecycle: Option[String] = None
    ): DeleteBackupResponse =
      DeleteBackupResponse
        .builder
        .ifSome(backupId)(_.backupId(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .build

    def deleteFileSystemLustreConfiguration(
      skipFinalBackup: Option[Boolean] = None,
      finalBackupTags: Option[List[Tag]] = None
    ): DeleteFileSystemLustreConfiguration =
      DeleteFileSystemLustreConfiguration
        .builder
        .ifSome(skipFinalBackup)(_.skipFinalBackup(_))
        .ifSome(finalBackupTags)(_.finalBackupTags(_))
        .build

    def deleteFileSystemLustreResponse(
      finalBackupId: Option[String] = None,
      finalBackupTags: Option[List[Tag]] = None
    ): DeleteFileSystemLustreResponse =
      DeleteFileSystemLustreResponse
        .builder
        .ifSome(finalBackupId)(_.finalBackupId(_))
        .ifSome(finalBackupTags)(_.finalBackupTags(_))
        .build

    def deleteFileSystemRequest(
      fileSystemId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      windowsConfiguration: Option[DeleteFileSystemWindowsConfiguration] = None,
      lustreConfiguration: Option[DeleteFileSystemLustreConfiguration] = None
    ): DeleteFileSystemRequest =
      DeleteFileSystemRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(windowsConfiguration)(_.windowsConfiguration(_))
        .ifSome(lustreConfiguration)(_.lustreConfiguration(_))
        .build

    def deleteFileSystemResponse(
      fileSystemId: Option[String] = None,
      lifecycle: Option[String] = None,
      windowsResponse: Option[DeleteFileSystemWindowsResponse] = None,
      lustreResponse: Option[DeleteFileSystemLustreResponse] = None
    ): DeleteFileSystemResponse =
      DeleteFileSystemResponse
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(windowsResponse)(_.windowsResponse(_))
        .ifSome(lustreResponse)(_.lustreResponse(_))
        .build

    def deleteFileSystemWindowsConfiguration(
      skipFinalBackup: Option[Boolean] = None,
      finalBackupTags: Option[List[Tag]] = None
    ): DeleteFileSystemWindowsConfiguration =
      DeleteFileSystemWindowsConfiguration
        .builder
        .ifSome(skipFinalBackup)(_.skipFinalBackup(_))
        .ifSome(finalBackupTags)(_.finalBackupTags(_))
        .build

    def deleteFileSystemWindowsResponse(
      finalBackupId: Option[String] = None,
      finalBackupTags: Option[List[Tag]] = None
    ): DeleteFileSystemWindowsResponse =
      DeleteFileSystemWindowsResponse
        .builder
        .ifSome(finalBackupId)(_.finalBackupId(_))
        .ifSome(finalBackupTags)(_.finalBackupTags(_))
        .build

    def describeBackupsRequest(
      backupIds: Option[List[BackupId]] = None,
      filters: Option[List[Filter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeBackupsRequest =
      DescribeBackupsRequest
        .builder
        .ifSome(backupIds)(_.backupIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeBackupsResponse(
      backups: Option[List[Backup]] = None,
      nextToken: Option[String] = None
    ): DescribeBackupsResponse =
      DescribeBackupsResponse
        .builder
        .ifSome(backups)(_.backups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDataRepositoryTasksRequest(
      taskIds: Option[List[TaskId]] = None,
      filters: Option[List[DataRepositoryTaskFilter]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeDataRepositoryTasksRequest =
      DescribeDataRepositoryTasksRequest
        .builder
        .ifSome(taskIds)(_.taskIds(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeDataRepositoryTasksResponse(
      dataRepositoryTasks: Option[List[DataRepositoryTask]] = None,
      nextToken: Option[String] = None
    ): DescribeDataRepositoryTasksResponse =
      DescribeDataRepositoryTasksResponse
        .builder
        .ifSome(dataRepositoryTasks)(_.dataRepositoryTasks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFileSystemAliasesRequest(
      clientRequestToken: Option[String] = None,
      fileSystemId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFileSystemAliasesRequest =
      DescribeFileSystemAliasesRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFileSystemAliasesResponse(
      aliases: Option[List[Alias]] = None,
      nextToken: Option[String] = None
    ): DescribeFileSystemAliasesResponse =
      DescribeFileSystemAliasesResponse
        .builder
        .ifSome(aliases)(_.aliases(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFileSystemsRequest(
      fileSystemIds: Option[List[FileSystemId]] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): DescribeFileSystemsRequest =
      DescribeFileSystemsRequest
        .builder
        .ifSome(fileSystemIds)(_.fileSystemIds(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeFileSystemsResponse(
      fileSystems: Option[List[FileSystem]] = None,
      nextToken: Option[String] = None
    ): DescribeFileSystemsResponse =
      DescribeFileSystemsResponse
        .builder
        .ifSome(fileSystems)(_.fileSystems(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def disassociateFileSystemAliasesRequest(
      clientRequestToken: Option[String] = None,
      fileSystemId: Option[String] = None,
      aliases: Option[List[AlternateDNSName]] = None
    ): DisassociateFileSystemAliasesRequest =
      DisassociateFileSystemAliasesRequest
        .builder
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(aliases)(_.aliases(_))
        .build

    def disassociateFileSystemAliasesResponse(
      aliases: Option[List[Alias]] = None
    ): DisassociateFileSystemAliasesResponse =
      DisassociateFileSystemAliasesResponse
        .builder
        .ifSome(aliases)(_.aliases(_))
        .build

    def fileSystem(
      ownerId: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      fileSystemId: Option[String] = None,
      fileSystemType: Option[String] = None,
      lifecycle: Option[String] = None,
      failureDetails: Option[FileSystemFailureDetails] = None,
      storageCapacity: Option[Int] = None,
      storageType: Option[String] = None,
      vpcId: Option[String] = None,
      subnetIds: Option[List[SubnetId]] = None,
      networkInterfaceIds: Option[List[NetworkInterfaceId]] = None,
      dNSName: Option[String] = None,
      kmsKeyId: Option[String] = None,
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      windowsConfiguration: Option[WindowsFileSystemConfiguration] = None,
      lustreConfiguration: Option[LustreFileSystemConfiguration] = None,
      administrativeActions: Option[List[AdministrativeAction]] = None
    ): FileSystem =
      FileSystem
        .builder
        .ifSome(ownerId)(_.ownerId(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(fileSystemType)(_.fileSystemType(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(failureDetails)(_.failureDetails(_))
        .ifSome(storageCapacity)(_.storageCapacity(_))
        .ifSome(storageType)(_.storageType(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(networkInterfaceIds)(_.networkInterfaceIds(_))
        .ifSome(dNSName)(_.dNSName(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(windowsConfiguration)(_.windowsConfiguration(_))
        .ifSome(lustreConfiguration)(_.lustreConfiguration(_))
        .ifSome(administrativeActions)(_.administrativeActions(_))
        .build

    def fileSystemFailureDetails(
      message: Option[String] = None
    ): FileSystemFailureDetails =
      FileSystemFailureDetails
        .builder
        .ifSome(message)(_.message(_))
        .build

    def fileSystemNotFound(
      message: Option[String] = None
    ): FileSystemNotFound =
      FileSystemNotFound
        .builder
        .ifSome(message)(_.message(_))
        .build

    def filter(
      name: Option[String] = None,
      values: Option[List[FilterValue]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def incompatibleParameterError(
      parameter: Option[String] = None,
      message: Option[String] = None
    ): IncompatibleParameterError =
      IncompatibleParameterError
        .builder
        .ifSome(parameter)(_.parameter(_))
        .ifSome(message)(_.message(_))
        .build

    def incompatibleRegionForMultiAZ(
      message: Option[String] = None
    ): IncompatibleRegionForMultiAZ =
      IncompatibleRegionForMultiAZ
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalServerError(
      message: Option[String] = None
    ): InternalServerError =
      InternalServerError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidDestinationKmsKey(
      message: Option[String] = None
    ): InvalidDestinationKmsKey =
      InvalidDestinationKmsKey
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidExportPath(
      message: Option[String] = None
    ): InvalidExportPath =
      InvalidExportPath
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidImportPath(
      message: Option[String] = None
    ): InvalidImportPath =
      InvalidImportPath
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNetworkSettings(
      message: Option[String] = None,
      invalidSubnetId: Option[String] = None,
      invalidSecurityGroupId: Option[String] = None
    ): InvalidNetworkSettings =
      InvalidNetworkSettings
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(invalidSubnetId)(_.invalidSubnetId(_))
        .ifSome(invalidSecurityGroupId)(_.invalidSecurityGroupId(_))
        .build

    def invalidPerUnitStorageThroughput(
      message: Option[String] = None
    ): InvalidPerUnitStorageThroughput =
      InvalidPerUnitStorageThroughput
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRegion(
      message: Option[String] = None
    ): InvalidRegion =
      InvalidRegion
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidSourceKmsKey(
      message: Option[String] = None
    ): InvalidSourceKmsKey =
      InvalidSourceKmsKey
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listTagsForResourceRequest(
      resourceARN: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceResponse(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceResponse =
      ListTagsForResourceResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def lustreFileSystemConfiguration(
      weeklyMaintenanceStartTime: Option[String] = None,
      dataRepositoryConfiguration: Option[DataRepositoryConfiguration] = None,
      deploymentType: Option[String] = None,
      perUnitStorageThroughput: Option[Int] = None,
      mountName: Option[String] = None,
      dailyAutomaticBackupStartTime: Option[String] = None,
      automaticBackupRetentionDays: Option[Int] = None,
      copyTagsToBackups: Option[Boolean] = None,
      driveCacheType: Option[String] = None,
      dataCompressionType: Option[String] = None
    ): LustreFileSystemConfiguration =
      LustreFileSystemConfiguration
        .builder
        .ifSome(weeklyMaintenanceStartTime)(_.weeklyMaintenanceStartTime(_))
        .ifSome(dataRepositoryConfiguration)(_.dataRepositoryConfiguration(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(perUnitStorageThroughput)(_.perUnitStorageThroughput(_))
        .ifSome(mountName)(_.mountName(_))
        .ifSome(dailyAutomaticBackupStartTime)(_.dailyAutomaticBackupStartTime(_))
        .ifSome(automaticBackupRetentionDays)(_.automaticBackupRetentionDays(_))
        .ifSome(copyTagsToBackups)(_.copyTagsToBackups(_))
        .ifSome(driveCacheType)(_.driveCacheType(_))
        .ifSome(dataCompressionType)(_.dataCompressionType(_))
        .build

    def missingFileSystemConfiguration(
      message: Option[String] = None
    ): MissingFileSystemConfiguration =
      MissingFileSystemConfiguration
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notServiceResourceError(
      resourceARN: Option[String] = None,
      message: Option[String] = None
    ): NotServiceResourceError =
      NotServiceResourceError
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceDoesNotSupportTagging(
      resourceARN: Option[String] = None,
      message: Option[String] = None
    ): ResourceDoesNotSupportTagging =
      ResourceDoesNotSupportTagging
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(message)(_.message(_))
        .build

    def resourceNotFound(
      resourceARN: Option[String] = None,
      message: Option[String] = None
    ): ResourceNotFound =
      ResourceNotFound
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(message)(_.message(_))
        .build

    def selfManagedActiveDirectoryAttributes(
      domainName: Option[String] = None,
      organizationalUnitDistinguishedName: Option[String] = None,
      fileSystemAdministratorsGroup: Option[String] = None,
      userName: Option[String] = None,
      dnsIps: Option[List[IpAddress]] = None
    ): SelfManagedActiveDirectoryAttributes =
      SelfManagedActiveDirectoryAttributes
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(organizationalUnitDistinguishedName)(_.organizationalUnitDistinguishedName(_))
        .ifSome(fileSystemAdministratorsGroup)(_.fileSystemAdministratorsGroup(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(dnsIps)(_.dnsIps(_))
        .build

    def selfManagedActiveDirectoryConfiguration(
      domainName: Option[String] = None,
      organizationalUnitDistinguishedName: Option[String] = None,
      fileSystemAdministratorsGroup: Option[String] = None,
      userName: Option[String] = None,
      password: Option[String] = None,
      dnsIps: Option[List[IpAddress]] = None
    ): SelfManagedActiveDirectoryConfiguration =
      SelfManagedActiveDirectoryConfiguration
        .builder
        .ifSome(domainName)(_.domainName(_))
        .ifSome(organizationalUnitDistinguishedName)(_.organizationalUnitDistinguishedName(_))
        .ifSome(fileSystemAdministratorsGroup)(_.fileSystemAdministratorsGroup(_))
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .ifSome(dnsIps)(_.dnsIps(_))
        .build

    def selfManagedActiveDirectoryConfigurationUpdates(
      userName: Option[String] = None,
      password: Option[String] = None,
      dnsIps: Option[List[IpAddress]] = None
    ): SelfManagedActiveDirectoryConfigurationUpdates =
      SelfManagedActiveDirectoryConfigurationUpdates
        .builder
        .ifSome(userName)(_.userName(_))
        .ifSome(password)(_.password(_))
        .ifSome(dnsIps)(_.dnsIps(_))
        .build

    def serviceLimitExceeded(
      limit: Option[String] = None,
      message: Option[String] = None
    ): ServiceLimitExceeded =
      ServiceLimitExceeded
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(message)(_.message(_))
        .build

    def sourceBackupUnavailable(
      message: Option[String] = None,
      backupId: Option[String] = None
    ): SourceBackupUnavailable =
      SourceBackupUnavailable
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(backupId)(_.backupId(_))
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

    def tagResourceRequest(
      resourceARN: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tags)(_.tags(_))
        .build

    def tagResourceResponse(

    ): TagResourceResponse =
      TagResourceResponse
        .builder

        .build

    def unsupportedOperation(
      message: Option[String] = None
    ): UnsupportedOperation =
      UnsupportedOperation
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      resourceARN: Option[String] = None,
      tagKeys: Option[List[TagKey]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(resourceARN)(_.resourceARN(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def untagResourceResponse(

    ): UntagResourceResponse =
      UntagResourceResponse
        .builder

        .build

    def updateFileSystemLustreConfiguration(
      weeklyMaintenanceStartTime: Option[String] = None,
      dailyAutomaticBackupStartTime: Option[String] = None,
      automaticBackupRetentionDays: Option[Int] = None,
      autoImportPolicy: Option[String] = None,
      dataCompressionType: Option[String] = None
    ): UpdateFileSystemLustreConfiguration =
      UpdateFileSystemLustreConfiguration
        .builder
        .ifSome(weeklyMaintenanceStartTime)(_.weeklyMaintenanceStartTime(_))
        .ifSome(dailyAutomaticBackupStartTime)(_.dailyAutomaticBackupStartTime(_))
        .ifSome(automaticBackupRetentionDays)(_.automaticBackupRetentionDays(_))
        .ifSome(autoImportPolicy)(_.autoImportPolicy(_))
        .ifSome(dataCompressionType)(_.dataCompressionType(_))
        .build

    def updateFileSystemRequest(
      fileSystemId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      storageCapacity: Option[Int] = None,
      windowsConfiguration: Option[UpdateFileSystemWindowsConfiguration] = None,
      lustreConfiguration: Option[UpdateFileSystemLustreConfiguration] = None
    ): UpdateFileSystemRequest =
      UpdateFileSystemRequest
        .builder
        .ifSome(fileSystemId)(_.fileSystemId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(storageCapacity)(_.storageCapacity(_))
        .ifSome(windowsConfiguration)(_.windowsConfiguration(_))
        .ifSome(lustreConfiguration)(_.lustreConfiguration(_))
        .build

    def updateFileSystemResponse(
      fileSystem: Option[FileSystem] = None
    ): UpdateFileSystemResponse =
      UpdateFileSystemResponse
        .builder
        .ifSome(fileSystem)(_.fileSystem(_))
        .build

    def updateFileSystemWindowsConfiguration(
      weeklyMaintenanceStartTime: Option[String] = None,
      dailyAutomaticBackupStartTime: Option[String] = None,
      automaticBackupRetentionDays: Option[Int] = None,
      throughputCapacity: Option[Int] = None,
      selfManagedActiveDirectoryConfiguration: Option[SelfManagedActiveDirectoryConfigurationUpdates] = None,
      auditLogConfiguration: Option[WindowsAuditLogCreateConfiguration] = None
    ): UpdateFileSystemWindowsConfiguration =
      UpdateFileSystemWindowsConfiguration
        .builder
        .ifSome(weeklyMaintenanceStartTime)(_.weeklyMaintenanceStartTime(_))
        .ifSome(dailyAutomaticBackupStartTime)(_.dailyAutomaticBackupStartTime(_))
        .ifSome(automaticBackupRetentionDays)(_.automaticBackupRetentionDays(_))
        .ifSome(throughputCapacity)(_.throughputCapacity(_))
        .ifSome(selfManagedActiveDirectoryConfiguration)(_.selfManagedActiveDirectoryConfiguration(_))
        .ifSome(auditLogConfiguration)(_.auditLogConfiguration(_))
        .build

    def windowsAuditLogConfiguration(
      fileAccessAuditLogLevel: Option[String] = None,
      fileShareAccessAuditLogLevel: Option[String] = None,
      auditLogDestination: Option[String] = None
    ): WindowsAuditLogConfiguration =
      WindowsAuditLogConfiguration
        .builder
        .ifSome(fileAccessAuditLogLevel)(_.fileAccessAuditLogLevel(_))
        .ifSome(fileShareAccessAuditLogLevel)(_.fileShareAccessAuditLogLevel(_))
        .ifSome(auditLogDestination)(_.auditLogDestination(_))
        .build

    def windowsAuditLogCreateConfiguration(
      fileAccessAuditLogLevel: Option[String] = None,
      fileShareAccessAuditLogLevel: Option[String] = None,
      auditLogDestination: Option[String] = None
    ): WindowsAuditLogCreateConfiguration =
      WindowsAuditLogCreateConfiguration
        .builder
        .ifSome(fileAccessAuditLogLevel)(_.fileAccessAuditLogLevel(_))
        .ifSome(fileShareAccessAuditLogLevel)(_.fileShareAccessAuditLogLevel(_))
        .ifSome(auditLogDestination)(_.auditLogDestination(_))
        .build

    def windowsFileSystemConfiguration(
      activeDirectoryId: Option[String] = None,
      selfManagedActiveDirectoryConfiguration: Option[SelfManagedActiveDirectoryAttributes] = None,
      deploymentType: Option[String] = None,
      remoteAdministrationEndpoint: Option[String] = None,
      preferredSubnetId: Option[String] = None,
      preferredFileServerIp: Option[String] = None,
      throughputCapacity: Option[Int] = None,
      maintenanceOperationsInProgress: Option[List[FileSystemMaintenanceOperation]] = None,
      weeklyMaintenanceStartTime: Option[String] = None,
      dailyAutomaticBackupStartTime: Option[String] = None,
      automaticBackupRetentionDays: Option[Int] = None,
      copyTagsToBackups: Option[Boolean] = None,
      aliases: Option[List[Alias]] = None,
      auditLogConfiguration: Option[WindowsAuditLogConfiguration] = None
    ): WindowsFileSystemConfiguration =
      WindowsFileSystemConfiguration
        .builder
        .ifSome(activeDirectoryId)(_.activeDirectoryId(_))
        .ifSome(selfManagedActiveDirectoryConfiguration)(_.selfManagedActiveDirectoryConfiguration(_))
        .ifSome(deploymentType)(_.deploymentType(_))
        .ifSome(remoteAdministrationEndpoint)(_.remoteAdministrationEndpoint(_))
        .ifSome(preferredSubnetId)(_.preferredSubnetId(_))
        .ifSome(preferredFileServerIp)(_.preferredFileServerIp(_))
        .ifSome(throughputCapacity)(_.throughputCapacity(_))
        .ifSome(maintenanceOperationsInProgress)(_.maintenanceOperationsInProgress(_))
        .ifSome(weeklyMaintenanceStartTime)(_.weeklyMaintenanceStartTime(_))
        .ifSome(dailyAutomaticBackupStartTime)(_.dailyAutomaticBackupStartTime(_))
        .ifSome(automaticBackupRetentionDays)(_.automaticBackupRetentionDays(_))
        .ifSome(copyTagsToBackups)(_.copyTagsToBackups(_))
        .ifSome(aliases)(_.aliases(_))
        .ifSome(auditLogConfiguration)(_.auditLogConfiguration(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
