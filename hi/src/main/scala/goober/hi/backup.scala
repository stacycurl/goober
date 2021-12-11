package goober.hi

import goober.free.backup.BackupIO
import software.amazon.awssdk.services.backup.model._


object backup {
  import goober.free.{backup ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def advancedBackupSetting(
      resourceType: Option[String] = None,
      backupOptions: Option[BackupOptions] = None
    ): AdvancedBackupSetting =
      AdvancedBackupSetting
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(backupOptions)(_.backupOptions(_))
        .build

    def alreadyExistsException(
      code: Option[String] = None,
      message: Option[String] = None,
      creatorRequestId: Option[String] = None,
      arn: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def backupJob(
      accountId: Option[String] = None,
      backupJobId: Option[String] = None,
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      resourceArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      percentDone: Option[String] = None,
      backupSizeInBytes: Option[Long] = None,
      iamRoleArn: Option[String] = None,
      createdBy: Option[RecoveryPointCreator] = None,
      expectedCompletionDate: Option[timestamp] = None,
      startBy: Option[timestamp] = None,
      resourceType: Option[String] = None,
      bytesTransferred: Option[Long] = None,
      backupOptions: Option[BackupOptions] = None,
      backupType: Option[String] = None
    ): BackupJob =
      BackupJob
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(backupJobId)(_.backupJobId(_))
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(percentDone)(_.percentDone(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(expectedCompletionDate)(_.expectedCompletionDate(_))
        .ifSome(startBy)(_.startBy(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(bytesTransferred)(_.bytesTransferred(_))
        .ifSome(backupOptions)(_.backupOptions(_))
        .ifSome(backupType)(_.backupType(_))
        .build

    def backupPlan(
      backupPlanName: Option[String] = None,
      rules: Option[List[BackupRule]] = None,
      advancedBackupSettings: Option[List[AdvancedBackupSetting]] = None
    ): BackupPlan =
      BackupPlan
        .builder
        .ifSome(backupPlanName)(_.backupPlanName(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(advancedBackupSettings)(_.advancedBackupSettings(_))
        .build

    def backupPlanInput(
      backupPlanName: Option[String] = None,
      rules: Option[List[BackupRuleInput]] = None,
      advancedBackupSettings: Option[List[AdvancedBackupSetting]] = None
    ): BackupPlanInput =
      BackupPlanInput
        .builder
        .ifSome(backupPlanName)(_.backupPlanName(_))
        .ifSome(rules)(_.rules(_))
        .ifSome(advancedBackupSettings)(_.advancedBackupSettings(_))
        .build

    def backupPlanTemplatesListMember(
      backupPlanTemplateId: Option[String] = None,
      backupPlanTemplateName: Option[String] = None
    ): BackupPlanTemplatesListMember =
      BackupPlanTemplatesListMember
        .builder
        .ifSome(backupPlanTemplateId)(_.backupPlanTemplateId(_))
        .ifSome(backupPlanTemplateName)(_.backupPlanTemplateName(_))
        .build

    def backupPlansListMember(
      backupPlanArn: Option[String] = None,
      backupPlanId: Option[String] = None,
      creationDate: Option[timestamp] = None,
      deletionDate: Option[timestamp] = None,
      versionId: Option[String] = None,
      backupPlanName: Option[String] = None,
      creatorRequestId: Option[String] = None,
      lastExecutionDate: Option[timestamp] = None,
      advancedBackupSettings: Option[List[AdvancedBackupSetting]] = None
    ): BackupPlansListMember =
      BackupPlansListMember
        .builder
        .ifSome(backupPlanArn)(_.backupPlanArn(_))
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(backupPlanName)(_.backupPlanName(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(lastExecutionDate)(_.lastExecutionDate(_))
        .ifSome(advancedBackupSettings)(_.advancedBackupSettings(_))
        .build

    def backupRule(
      ruleName: Option[String] = None,
      targetBackupVaultName: Option[String] = None,
      scheduleExpression: Option[String] = None,
      startWindowMinutes: Option[WindowMinutes] = None,
      completionWindowMinutes: Option[WindowMinutes] = None,
      lifecycle: Option[Lifecycle] = None,
      recoveryPointTags: Option[Tags] = None,
      ruleId: Option[String] = None,
      copyActions: Option[List[CopyAction]] = None,
      enableContinuousBackup: Option[Boolean] = None
    ): BackupRule =
      BackupRule
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(targetBackupVaultName)(_.targetBackupVaultName(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(startWindowMinutes)(_.startWindowMinutes(_))
        .ifSome(completionWindowMinutes)(_.completionWindowMinutes(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(recoveryPointTags)(_.recoveryPointTags(_))
        .ifSome(ruleId)(_.ruleId(_))
        .ifSome(copyActions)(_.copyActions(_))
        .ifSome(enableContinuousBackup)(_.enableContinuousBackup(_))
        .build

    def backupRuleInput(
      ruleName: Option[String] = None,
      targetBackupVaultName: Option[String] = None,
      scheduleExpression: Option[String] = None,
      startWindowMinutes: Option[WindowMinutes] = None,
      completionWindowMinutes: Option[WindowMinutes] = None,
      lifecycle: Option[Lifecycle] = None,
      recoveryPointTags: Option[Tags] = None,
      copyActions: Option[List[CopyAction]] = None,
      enableContinuousBackup: Option[Boolean] = None
    ): BackupRuleInput =
      BackupRuleInput
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(targetBackupVaultName)(_.targetBackupVaultName(_))
        .ifSome(scheduleExpression)(_.scheduleExpression(_))
        .ifSome(startWindowMinutes)(_.startWindowMinutes(_))
        .ifSome(completionWindowMinutes)(_.completionWindowMinutes(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(recoveryPointTags)(_.recoveryPointTags(_))
        .ifSome(copyActions)(_.copyActions(_))
        .ifSome(enableContinuousBackup)(_.enableContinuousBackup(_))
        .build

    def backupSelection(
      selectionName: Option[String] = None,
      iamRoleArn: Option[String] = None,
      resources: Option[List[ARN]] = None,
      listOfTags: Option[List[Condition]] = None
    ): BackupSelection =
      BackupSelection
        .builder
        .ifSome(selectionName)(_.selectionName(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(resources)(_.resources(_))
        .ifSome(listOfTags)(_.listOfTags(_))
        .build

    def backupSelectionsListMember(
      selectionId: Option[String] = None,
      selectionName: Option[String] = None,
      backupPlanId: Option[String] = None,
      creationDate: Option[timestamp] = None,
      creatorRequestId: Option[String] = None,
      iamRoleArn: Option[String] = None
    ): BackupSelectionsListMember =
      BackupSelectionsListMember
        .builder
        .ifSome(selectionId)(_.selectionId(_))
        .ifSome(selectionName)(_.selectionName(_))
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .build

    def backupVaultListMember(
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      encryptionKeyArn: Option[String] = None,
      creatorRequestId: Option[String] = None,
      numberOfRecoveryPoints: Option[long] = None
    ): BackupVaultListMember =
      BackupVaultListMember
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(numberOfRecoveryPoints)(_.numberOfRecoveryPoints(_))
        .build

    def calculatedLifecycle(
      moveToColdStorageAt: Option[timestamp] = None,
      deleteAt: Option[timestamp] = None
    ): CalculatedLifecycle =
      CalculatedLifecycle
        .builder
        .ifSome(moveToColdStorageAt)(_.moveToColdStorageAt(_))
        .ifSome(deleteAt)(_.deleteAt(_))
        .build

    def condition(
      conditionType: Option[String] = None,
      conditionKey: Option[String] = None,
      conditionValue: Option[String] = None
    ): Condition =
      Condition
        .builder
        .ifSome(conditionType)(_.conditionType(_))
        .ifSome(conditionKey)(_.conditionKey(_))
        .ifSome(conditionValue)(_.conditionValue(_))
        .build

    def copyAction(
      lifecycle: Option[Lifecycle] = None,
      destinationBackupVaultArn: Option[String] = None
    ): CopyAction =
      CopyAction
        .builder
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(destinationBackupVaultArn)(_.destinationBackupVaultArn(_))
        .build

    def copyJob(
      accountId: Option[String] = None,
      copyJobId: Option[String] = None,
      sourceBackupVaultArn: Option[String] = None,
      sourceRecoveryPointArn: Option[String] = None,
      destinationBackupVaultArn: Option[String] = None,
      destinationRecoveryPointArn: Option[String] = None,
      resourceArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      backupSizeInBytes: Option[Long] = None,
      iamRoleArn: Option[String] = None,
      createdBy: Option[RecoveryPointCreator] = None,
      resourceType: Option[String] = None
    ): CopyJob =
      CopyJob
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(copyJobId)(_.copyJobId(_))
        .ifSome(sourceBackupVaultArn)(_.sourceBackupVaultArn(_))
        .ifSome(sourceRecoveryPointArn)(_.sourceRecoveryPointArn(_))
        .ifSome(destinationBackupVaultArn)(_.destinationBackupVaultArn(_))
        .ifSome(destinationRecoveryPointArn)(_.destinationRecoveryPointArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def createBackupPlanInput(
      backupPlan: Option[BackupPlanInput] = None,
      backupPlanTags: Option[Tags] = None,
      creatorRequestId: Option[String] = None
    ): CreateBackupPlanInput =
      CreateBackupPlanInput
        .builder
        .ifSome(backupPlan)(_.backupPlan(_))
        .ifSome(backupPlanTags)(_.backupPlanTags(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .build

    def createBackupPlanOutput(
      backupPlanId: Option[String] = None,
      backupPlanArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      versionId: Option[String] = None,
      advancedBackupSettings: Option[List[AdvancedBackupSetting]] = None
    ): CreateBackupPlanOutput =
      CreateBackupPlanOutput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupPlanArn)(_.backupPlanArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(advancedBackupSettings)(_.advancedBackupSettings(_))
        .build

    def createBackupSelectionInput(
      backupPlanId: Option[String] = None,
      backupSelection: Option[BackupSelection] = None,
      creatorRequestId: Option[String] = None
    ): CreateBackupSelectionInput =
      CreateBackupSelectionInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupSelection)(_.backupSelection(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .build

    def createBackupSelectionOutput(
      selectionId: Option[String] = None,
      backupPlanId: Option[String] = None,
      creationDate: Option[timestamp] = None
    ): CreateBackupSelectionOutput =
      CreateBackupSelectionOutput
        .builder
        .ifSome(selectionId)(_.selectionId(_))
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def createBackupVaultInput(
      backupVaultName: Option[String] = None,
      backupVaultTags: Option[Tags] = None,
      encryptionKeyArn: Option[String] = None,
      creatorRequestId: Option[String] = None
    ): CreateBackupVaultInput =
      CreateBackupVaultInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultTags)(_.backupVaultTags(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .build

    def createBackupVaultOutput(
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      creationDate: Option[timestamp] = None
    ): CreateBackupVaultOutput =
      CreateBackupVaultOutput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def deleteBackupPlanInput(
      backupPlanId: Option[String] = None
    ): DeleteBackupPlanInput =
      DeleteBackupPlanInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .build

    def deleteBackupPlanOutput(
      backupPlanId: Option[String] = None,
      backupPlanArn: Option[String] = None,
      deletionDate: Option[timestamp] = None,
      versionId: Option[String] = None
    ): DeleteBackupPlanOutput =
      DeleteBackupPlanOutput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupPlanArn)(_.backupPlanArn(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def deleteBackupSelectionInput(
      backupPlanId: Option[String] = None,
      selectionId: Option[String] = None
    ): DeleteBackupSelectionInput =
      DeleteBackupSelectionInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(selectionId)(_.selectionId(_))
        .build

    def deleteBackupVaultAccessPolicyInput(
      backupVaultName: Option[String] = None
    ): DeleteBackupVaultAccessPolicyInput =
      DeleteBackupVaultAccessPolicyInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def deleteBackupVaultInput(
      backupVaultName: Option[String] = None
    ): DeleteBackupVaultInput =
      DeleteBackupVaultInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def deleteBackupVaultNotificationsInput(
      backupVaultName: Option[String] = None
    ): DeleteBackupVaultNotificationsInput =
      DeleteBackupVaultNotificationsInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def deleteRecoveryPointInput(
      backupVaultName: Option[String] = None,
      recoveryPointArn: Option[String] = None
    ): DeleteRecoveryPointInput =
      DeleteRecoveryPointInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .build

    def dependencyFailureException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): DependencyFailureException =
      DependencyFailureException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def describeBackupJobInput(
      backupJobId: Option[String] = None
    ): DescribeBackupJobInput =
      DescribeBackupJobInput
        .builder
        .ifSome(backupJobId)(_.backupJobId(_))
        .build

    def describeBackupJobOutput(
      accountId: Option[String] = None,
      backupJobId: Option[String] = None,
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      resourceArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      state: Option[String] = None,
      statusMessage: Option[String] = None,
      percentDone: Option[String] = None,
      backupSizeInBytes: Option[Long] = None,
      iamRoleArn: Option[String] = None,
      createdBy: Option[RecoveryPointCreator] = None,
      resourceType: Option[String] = None,
      bytesTransferred: Option[Long] = None,
      expectedCompletionDate: Option[timestamp] = None,
      startBy: Option[timestamp] = None,
      backupOptions: Option[BackupOptions] = None,
      backupType: Option[String] = None
    ): DescribeBackupJobOutput =
      DescribeBackupJobOutput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(backupJobId)(_.backupJobId(_))
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(state)(_.state(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(percentDone)(_.percentDone(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(bytesTransferred)(_.bytesTransferred(_))
        .ifSome(expectedCompletionDate)(_.expectedCompletionDate(_))
        .ifSome(startBy)(_.startBy(_))
        .ifSome(backupOptions)(_.backupOptions(_))
        .ifSome(backupType)(_.backupType(_))
        .build

    def describeBackupVaultInput(
      backupVaultName: Option[String] = None
    ): DescribeBackupVaultInput =
      DescribeBackupVaultInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def describeBackupVaultOutput(
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      encryptionKeyArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      creatorRequestId: Option[String] = None,
      numberOfRecoveryPoints: Option[long] = None
    ): DescribeBackupVaultOutput =
      DescribeBackupVaultOutput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(numberOfRecoveryPoints)(_.numberOfRecoveryPoints(_))
        .build

    def describeCopyJobInput(
      copyJobId: Option[String] = None
    ): DescribeCopyJobInput =
      DescribeCopyJobInput
        .builder
        .ifSome(copyJobId)(_.copyJobId(_))
        .build

    def describeCopyJobOutput(
      copyJob: Option[CopyJob] = None
    ): DescribeCopyJobOutput =
      DescribeCopyJobOutput
        .builder
        .ifSome(copyJob)(_.copyJob(_))
        .build

    def describeGlobalSettingsInput(

    ): DescribeGlobalSettingsInput =
      DescribeGlobalSettingsInput
        .builder

        .build

    def describeGlobalSettingsOutput(
      globalSettings: Option[GlobalSettings] = None,
      lastUpdateTime: Option[timestamp] = None
    ): DescribeGlobalSettingsOutput =
      DescribeGlobalSettingsOutput
        .builder
        .ifSome(globalSettings)(_.globalSettings(_))
        .ifSome(lastUpdateTime)(_.lastUpdateTime(_))
        .build

    def describeProtectedResourceInput(
      resourceArn: Option[String] = None
    ): DescribeProtectedResourceInput =
      DescribeProtectedResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def describeProtectedResourceOutput(
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      lastBackupTime: Option[timestamp] = None
    ): DescribeProtectedResourceOutput =
      DescribeProtectedResourceOutput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(lastBackupTime)(_.lastBackupTime(_))
        .build

    def describeRecoveryPointInput(
      backupVaultName: Option[String] = None,
      recoveryPointArn: Option[String] = None
    ): DescribeRecoveryPointInput =
      DescribeRecoveryPointInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .build

    def describeRecoveryPointOutput(
      recoveryPointArn: Option[String] = None,
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      sourceBackupVaultArn: Option[String] = None,
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      createdBy: Option[RecoveryPointCreator] = None,
      iamRoleArn: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      backupSizeInBytes: Option[Long] = None,
      calculatedLifecycle: Option[CalculatedLifecycle] = None,
      lifecycle: Option[Lifecycle] = None,
      encryptionKeyArn: Option[String] = None,
      isEncrypted: Option[Boolean] = None,
      storageClass: Option[String] = None,
      lastRestoreTime: Option[timestamp] = None
    ): DescribeRecoveryPointOutput =
      DescribeRecoveryPointOutput
        .builder
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(sourceBackupVaultArn)(_.sourceBackupVaultArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(calculatedLifecycle)(_.calculatedLifecycle(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(isEncrypted)(_.isEncrypted(_))
        .ifSome(storageClass)(_.storageClass(_))
        .ifSome(lastRestoreTime)(_.lastRestoreTime(_))
        .build

    def describeRegionSettingsInput(

    ): DescribeRegionSettingsInput =
      DescribeRegionSettingsInput
        .builder

        .build

    def describeRegionSettingsOutput(
      resourceTypeOptInPreference: Option[ResourceTypeOptInPreference] = None
    ): DescribeRegionSettingsOutput =
      DescribeRegionSettingsOutput
        .builder
        .ifSome(resourceTypeOptInPreference)(_.resourceTypeOptInPreference(_))
        .build

    def describeRestoreJobInput(
      restoreJobId: Option[String] = None
    ): DescribeRestoreJobInput =
      DescribeRestoreJobInput
        .builder
        .ifSome(restoreJobId)(_.restoreJobId(_))
        .build

    def describeRestoreJobOutput(
      accountId: Option[String] = None,
      restoreJobId: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      percentDone: Option[String] = None,
      backupSizeInBytes: Option[Long] = None,
      iamRoleArn: Option[String] = None,
      expectedCompletionTimeMinutes: Option[Long] = None,
      createdResourceArn: Option[String] = None,
      resourceType: Option[String] = None
    ): DescribeRestoreJobOutput =
      DescribeRestoreJobOutput
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(restoreJobId)(_.restoreJobId(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(percentDone)(_.percentDone(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(expectedCompletionTimeMinutes)(_.expectedCompletionTimeMinutes(_))
        .ifSome(createdResourceArn)(_.createdResourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def disassociateRecoveryPointInput(
      backupVaultName: Option[String] = None,
      recoveryPointArn: Option[String] = None
    ): DisassociateRecoveryPointInput =
      DisassociateRecoveryPointInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .build

    def exportBackupPlanTemplateInput(
      backupPlanId: Option[String] = None
    ): ExportBackupPlanTemplateInput =
      ExportBackupPlanTemplateInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .build

    def exportBackupPlanTemplateOutput(
      backupPlanTemplateJson: Option[String] = None
    ): ExportBackupPlanTemplateOutput =
      ExportBackupPlanTemplateOutput
        .builder
        .ifSome(backupPlanTemplateJson)(_.backupPlanTemplateJson(_))
        .build

    def getBackupPlanFromJSONInput(
      backupPlanTemplateJson: Option[String] = None
    ): GetBackupPlanFromJSONInput =
      GetBackupPlanFromJSONInput
        .builder
        .ifSome(backupPlanTemplateJson)(_.backupPlanTemplateJson(_))
        .build

    def getBackupPlanFromJSONOutput(
      backupPlan: Option[BackupPlan] = None
    ): GetBackupPlanFromJSONOutput =
      GetBackupPlanFromJSONOutput
        .builder
        .ifSome(backupPlan)(_.backupPlan(_))
        .build

    def getBackupPlanFromTemplateInput(
      backupPlanTemplateId: Option[String] = None
    ): GetBackupPlanFromTemplateInput =
      GetBackupPlanFromTemplateInput
        .builder
        .ifSome(backupPlanTemplateId)(_.backupPlanTemplateId(_))
        .build

    def getBackupPlanFromTemplateOutput(
      backupPlanDocument: Option[BackupPlan] = None
    ): GetBackupPlanFromTemplateOutput =
      GetBackupPlanFromTemplateOutput
        .builder
        .ifSome(backupPlanDocument)(_.backupPlanDocument(_))
        .build

    def getBackupPlanInput(
      backupPlanId: Option[String] = None,
      versionId: Option[String] = None
    ): GetBackupPlanInput =
      GetBackupPlanInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def getBackupPlanOutput(
      backupPlan: Option[BackupPlan] = None,
      backupPlanId: Option[String] = None,
      backupPlanArn: Option[String] = None,
      versionId: Option[String] = None,
      creatorRequestId: Option[String] = None,
      creationDate: Option[timestamp] = None,
      deletionDate: Option[timestamp] = None,
      lastExecutionDate: Option[timestamp] = None,
      advancedBackupSettings: Option[List[AdvancedBackupSetting]] = None
    ): GetBackupPlanOutput =
      GetBackupPlanOutput
        .builder
        .ifSome(backupPlan)(_.backupPlan(_))
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupPlanArn)(_.backupPlanArn(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .ifSome(lastExecutionDate)(_.lastExecutionDate(_))
        .ifSome(advancedBackupSettings)(_.advancedBackupSettings(_))
        .build

    def getBackupSelectionInput(
      backupPlanId: Option[String] = None,
      selectionId: Option[String] = None
    ): GetBackupSelectionInput =
      GetBackupSelectionInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(selectionId)(_.selectionId(_))
        .build

    def getBackupSelectionOutput(
      backupSelection: Option[BackupSelection] = None,
      selectionId: Option[String] = None,
      backupPlanId: Option[String] = None,
      creationDate: Option[timestamp] = None,
      creatorRequestId: Option[String] = None
    ): GetBackupSelectionOutput =
      GetBackupSelectionOutput
        .builder
        .ifSome(backupSelection)(_.backupSelection(_))
        .ifSome(selectionId)(_.selectionId(_))
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(creatorRequestId)(_.creatorRequestId(_))
        .build

    def getBackupVaultAccessPolicyInput(
      backupVaultName: Option[String] = None
    ): GetBackupVaultAccessPolicyInput =
      GetBackupVaultAccessPolicyInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def getBackupVaultAccessPolicyOutput(
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      policy: Option[String] = None
    ): GetBackupVaultAccessPolicyOutput =
      GetBackupVaultAccessPolicyOutput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(policy)(_.policy(_))
        .build

    def getBackupVaultNotificationsInput(
      backupVaultName: Option[String] = None
    ): GetBackupVaultNotificationsInput =
      GetBackupVaultNotificationsInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def getBackupVaultNotificationsOutput(
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      sNSTopicArn: Option[String] = None,
      backupVaultEvents: Option[List[BackupVaultEvent]] = None
    ): GetBackupVaultNotificationsOutput =
      GetBackupVaultNotificationsOutput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(sNSTopicArn)(_.sNSTopicArn(_))
        .ifSome(backupVaultEvents)(_.backupVaultEvents(_))
        .build

    def getRecoveryPointRestoreMetadataInput(
      backupVaultName: Option[String] = None,
      recoveryPointArn: Option[String] = None
    ): GetRecoveryPointRestoreMetadataInput =
      GetRecoveryPointRestoreMetadataInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .build

    def getRecoveryPointRestoreMetadataOutput(
      backupVaultArn: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      restoreMetadata: Option[Metadata] = None
    ): GetRecoveryPointRestoreMetadataOutput =
      GetRecoveryPointRestoreMetadataOutput
        .builder
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(restoreMetadata)(_.restoreMetadata(_))
        .build

    def getSupportedResourceTypesOutput(
      resourceTypes: Option[List[ResourceType]] = None
    ): GetSupportedResourceTypesOutput =
      GetSupportedResourceTypesOutput
        .builder
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .build

    def invalidParameterValueException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): InvalidParameterValueException =
      InvalidParameterValueException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def invalidRequestException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def invalidResourceStateException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): InvalidResourceStateException =
      InvalidResourceStateException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def lifecycle(
      moveToColdStorageAfterDays: Option[Long] = None,
      deleteAfterDays: Option[Long] = None
    ): Lifecycle =
      Lifecycle
        .builder
        .ifSome(moveToColdStorageAfterDays)(_.moveToColdStorageAfterDays(_))
        .ifSome(deleteAfterDays)(_.deleteAfterDays(_))
        .build

    def limitExceededException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def listBackupJobsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      byResourceArn: Option[String] = None,
      byState: Option[String] = None,
      byBackupVaultName: Option[String] = None,
      byCreatedBefore: Option[timestamp] = None,
      byCreatedAfter: Option[timestamp] = None,
      byResourceType: Option[String] = None,
      byAccountId: Option[String] = None
    ): ListBackupJobsInput =
      ListBackupJobsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(byResourceArn)(_.byResourceArn(_))
        .ifSome(byState)(_.byState(_))
        .ifSome(byBackupVaultName)(_.byBackupVaultName(_))
        .ifSome(byCreatedBefore)(_.byCreatedBefore(_))
        .ifSome(byCreatedAfter)(_.byCreatedAfter(_))
        .ifSome(byResourceType)(_.byResourceType(_))
        .ifSome(byAccountId)(_.byAccountId(_))
        .build

    def listBackupJobsOutput(
      backupJobs: Option[List[BackupJob]] = None,
      nextToken: Option[String] = None
    ): ListBackupJobsOutput =
      ListBackupJobsOutput
        .builder
        .ifSome(backupJobs)(_.backupJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listBackupPlanTemplatesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBackupPlanTemplatesInput =
      ListBackupPlanTemplatesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBackupPlanTemplatesOutput(
      nextToken: Option[String] = None,
      backupPlanTemplatesList: Option[List[BackupPlanTemplatesListMember]] = None
    ): ListBackupPlanTemplatesOutput =
      ListBackupPlanTemplatesOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(backupPlanTemplatesList)(_.backupPlanTemplatesList(_))
        .build

    def listBackupPlanVersionsInput(
      backupPlanId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBackupPlanVersionsInput =
      ListBackupPlanVersionsInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBackupPlanVersionsOutput(
      nextToken: Option[String] = None,
      backupPlanVersionsList: Option[List[BackupPlansListMember]] = None
    ): ListBackupPlanVersionsOutput =
      ListBackupPlanVersionsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(backupPlanVersionsList)(_.backupPlanVersionsList(_))
        .build

    def listBackupPlansInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      includeDeleted: Option[Boolean] = None
    ): ListBackupPlansInput =
      ListBackupPlansInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(includeDeleted)(_.includeDeleted(_))
        .build

    def listBackupPlansOutput(
      nextToken: Option[String] = None,
      backupPlansList: Option[List[BackupPlansListMember]] = None
    ): ListBackupPlansOutput =
      ListBackupPlansOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(backupPlansList)(_.backupPlansList(_))
        .build

    def listBackupSelectionsInput(
      backupPlanId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBackupSelectionsInput =
      ListBackupSelectionsInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBackupSelectionsOutput(
      nextToken: Option[String] = None,
      backupSelectionsList: Option[List[BackupSelectionsListMember]] = None
    ): ListBackupSelectionsOutput =
      ListBackupSelectionsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(backupSelectionsList)(_.backupSelectionsList(_))
        .build

    def listBackupVaultsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListBackupVaultsInput =
      ListBackupVaultsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listBackupVaultsOutput(
      backupVaultList: Option[List[BackupVaultListMember]] = None,
      nextToken: Option[String] = None
    ): ListBackupVaultsOutput =
      ListBackupVaultsOutput
        .builder
        .ifSome(backupVaultList)(_.backupVaultList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCopyJobsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      byResourceArn: Option[String] = None,
      byState: Option[String] = None,
      byCreatedBefore: Option[timestamp] = None,
      byCreatedAfter: Option[timestamp] = None,
      byResourceType: Option[String] = None,
      byDestinationVaultArn: Option[String] = None,
      byAccountId: Option[String] = None
    ): ListCopyJobsInput =
      ListCopyJobsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(byResourceArn)(_.byResourceArn(_))
        .ifSome(byState)(_.byState(_))
        .ifSome(byCreatedBefore)(_.byCreatedBefore(_))
        .ifSome(byCreatedAfter)(_.byCreatedAfter(_))
        .ifSome(byResourceType)(_.byResourceType(_))
        .ifSome(byDestinationVaultArn)(_.byDestinationVaultArn(_))
        .ifSome(byAccountId)(_.byAccountId(_))
        .build

    def listCopyJobsOutput(
      copyJobs: Option[List[CopyJob]] = None,
      nextToken: Option[String] = None
    ): ListCopyJobsOutput =
      ListCopyJobsOutput
        .builder
        .ifSome(copyJobs)(_.copyJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProtectedResourcesInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListProtectedResourcesInput =
      ListProtectedResourcesInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listProtectedResourcesOutput(
      results: Option[List[ProtectedResource]] = None,
      nextToken: Option[String] = None
    ): ListProtectedResourcesOutput =
      ListProtectedResourcesOutput
        .builder
        .ifSome(results)(_.results(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRecoveryPointsByBackupVaultInput(
      backupVaultName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      byResourceArn: Option[String] = None,
      byResourceType: Option[String] = None,
      byBackupPlanId: Option[String] = None,
      byCreatedBefore: Option[timestamp] = None,
      byCreatedAfter: Option[timestamp] = None
    ): ListRecoveryPointsByBackupVaultInput =
      ListRecoveryPointsByBackupVaultInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(byResourceArn)(_.byResourceArn(_))
        .ifSome(byResourceType)(_.byResourceType(_))
        .ifSome(byBackupPlanId)(_.byBackupPlanId(_))
        .ifSome(byCreatedBefore)(_.byCreatedBefore(_))
        .ifSome(byCreatedAfter)(_.byCreatedAfter(_))
        .build

    def listRecoveryPointsByBackupVaultOutput(
      nextToken: Option[String] = None,
      recoveryPoints: Option[List[RecoveryPointByBackupVault]] = None
    ): ListRecoveryPointsByBackupVaultOutput =
      ListRecoveryPointsByBackupVaultOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recoveryPoints)(_.recoveryPoints(_))
        .build

    def listRecoveryPointsByResourceInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListRecoveryPointsByResourceInput =
      ListRecoveryPointsByResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listRecoveryPointsByResourceOutput(
      nextToken: Option[String] = None,
      recoveryPoints: Option[List[RecoveryPointByResource]] = None
    ): ListRecoveryPointsByResourceOutput =
      ListRecoveryPointsByResourceOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(recoveryPoints)(_.recoveryPoints(_))
        .build

    def listRestoreJobsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      byAccountId: Option[String] = None,
      byCreatedBefore: Option[timestamp] = None,
      byCreatedAfter: Option[timestamp] = None,
      byStatus: Option[String] = None
    ): ListRestoreJobsInput =
      ListRestoreJobsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(byAccountId)(_.byAccountId(_))
        .ifSome(byCreatedBefore)(_.byCreatedBefore(_))
        .ifSome(byCreatedAfter)(_.byCreatedAfter(_))
        .ifSome(byStatus)(_.byStatus(_))
        .build

    def listRestoreJobsOutput(
      restoreJobs: Option[List[RestoreJobsListMember]] = None,
      nextToken: Option[String] = None
    ): ListRestoreJobsOutput =
      ListRestoreJobsOutput
        .builder
        .ifSome(restoreJobs)(_.restoreJobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTagsInput =
      ListTagsInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTagsOutput(
      nextToken: Option[String] = None,
      tags: Option[Tags] = None
    ): ListTagsOutput =
      ListTagsOutput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(tags)(_.tags(_))
        .build

    def missingParameterValueException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): MissingParameterValueException =
      MissingParameterValueException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def protectedResource(
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      lastBackupTime: Option[timestamp] = None
    ): ProtectedResource =
      ProtectedResource
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(lastBackupTime)(_.lastBackupTime(_))
        .build

    def putBackupVaultAccessPolicyInput(
      backupVaultName: Option[String] = None,
      policy: Option[String] = None
    ): PutBackupVaultAccessPolicyInput =
      PutBackupVaultAccessPolicyInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(policy)(_.policy(_))
        .build

    def putBackupVaultNotificationsInput(
      backupVaultName: Option[String] = None,
      sNSTopicArn: Option[String] = None,
      backupVaultEvents: Option[List[BackupVaultEvent]] = None
    ): PutBackupVaultNotificationsInput =
      PutBackupVaultNotificationsInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(sNSTopicArn)(_.sNSTopicArn(_))
        .ifSome(backupVaultEvents)(_.backupVaultEvents(_))
        .build

    def recoveryPointByBackupVault(
      recoveryPointArn: Option[String] = None,
      backupVaultName: Option[String] = None,
      backupVaultArn: Option[String] = None,
      sourceBackupVaultArn: Option[String] = None,
      resourceArn: Option[String] = None,
      resourceType: Option[String] = None,
      createdBy: Option[RecoveryPointCreator] = None,
      iamRoleArn: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      backupSizeInBytes: Option[Long] = None,
      calculatedLifecycle: Option[CalculatedLifecycle] = None,
      lifecycle: Option[Lifecycle] = None,
      encryptionKeyArn: Option[String] = None,
      isEncrypted: Option[Boolean] = None,
      lastRestoreTime: Option[timestamp] = None
    ): RecoveryPointByBackupVault =
      RecoveryPointByBackupVault
        .builder
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(sourceBackupVaultArn)(_.sourceBackupVaultArn(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(createdBy)(_.createdBy(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(calculatedLifecycle)(_.calculatedLifecycle(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(isEncrypted)(_.isEncrypted(_))
        .ifSome(lastRestoreTime)(_.lastRestoreTime(_))
        .build

    def recoveryPointByResource(
      recoveryPointArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      status: Option[String] = None,
      encryptionKeyArn: Option[String] = None,
      backupSizeBytes: Option[Long] = None,
      backupVaultName: Option[String] = None
    ): RecoveryPointByResource =
      RecoveryPointByResource
        .builder
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(encryptionKeyArn)(_.encryptionKeyArn(_))
        .ifSome(backupSizeBytes)(_.backupSizeBytes(_))
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .build

    def recoveryPointCreator(
      backupPlanId: Option[String] = None,
      backupPlanArn: Option[String] = None,
      backupPlanVersion: Option[String] = None,
      backupRuleId: Option[String] = None
    ): RecoveryPointCreator =
      RecoveryPointCreator
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupPlanArn)(_.backupPlanArn(_))
        .ifSome(backupPlanVersion)(_.backupPlanVersion(_))
        .ifSome(backupRuleId)(_.backupRuleId(_))
        .build

    def resourceNotFoundException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def restoreJobsListMember(
      accountId: Option[String] = None,
      restoreJobId: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      completionDate: Option[timestamp] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      percentDone: Option[String] = None,
      backupSizeInBytes: Option[Long] = None,
      iamRoleArn: Option[String] = None,
      expectedCompletionTimeMinutes: Option[Long] = None,
      createdResourceArn: Option[String] = None,
      resourceType: Option[String] = None
    ): RestoreJobsListMember =
      RestoreJobsListMember
        .builder
        .ifSome(accountId)(_.accountId(_))
        .ifSome(restoreJobId)(_.restoreJobId(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(completionDate)(_.completionDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(percentDone)(_.percentDone(_))
        .ifSome(backupSizeInBytes)(_.backupSizeInBytes(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(expectedCompletionTimeMinutes)(_.expectedCompletionTimeMinutes(_))
        .ifSome(createdResourceArn)(_.createdResourceArn(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def serviceUnavailableException(
      code: Option[String] = None,
      message: Option[String] = None,
      `type`: Option[String] = None,
      context: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(context)(_.context(_))
        .build

    def startBackupJobInput(
      backupVaultName: Option[String] = None,
      resourceArn: Option[String] = None,
      iamRoleArn: Option[String] = None,
      idempotencyToken: Option[String] = None,
      startWindowMinutes: Option[WindowMinutes] = None,
      completeWindowMinutes: Option[WindowMinutes] = None,
      lifecycle: Option[Lifecycle] = None,
      recoveryPointTags: Option[Tags] = None,
      backupOptions: Option[BackupOptions] = None
    ): StartBackupJobInput =
      StartBackupJobInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(startWindowMinutes)(_.startWindowMinutes(_))
        .ifSome(completeWindowMinutes)(_.completeWindowMinutes(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(recoveryPointTags)(_.recoveryPointTags(_))
        .ifSome(backupOptions)(_.backupOptions(_))
        .build

    def startBackupJobOutput(
      backupJobId: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      creationDate: Option[timestamp] = None
    ): StartBackupJobOutput =
      StartBackupJobOutput
        .builder
        .ifSome(backupJobId)(_.backupJobId(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def startCopyJobInput(
      recoveryPointArn: Option[String] = None,
      sourceBackupVaultName: Option[String] = None,
      destinationBackupVaultArn: Option[String] = None,
      iamRoleArn: Option[String] = None,
      idempotencyToken: Option[String] = None,
      lifecycle: Option[Lifecycle] = None
    ): StartCopyJobInput =
      StartCopyJobInput
        .builder
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(sourceBackupVaultName)(_.sourceBackupVaultName(_))
        .ifSome(destinationBackupVaultArn)(_.destinationBackupVaultArn(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .build

    def startCopyJobOutput(
      copyJobId: Option[String] = None,
      creationDate: Option[timestamp] = None
    ): StartCopyJobOutput =
      StartCopyJobOutput
        .builder
        .ifSome(copyJobId)(_.copyJobId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def startRestoreJobInput(
      recoveryPointArn: Option[String] = None,
      metadata: Option[Metadata] = None,
      iamRoleArn: Option[String] = None,
      idempotencyToken: Option[String] = None,
      resourceType: Option[String] = None
    ): StartRestoreJobInput =
      StartRestoreJobInput
        .builder
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(idempotencyToken)(_.idempotencyToken(_))
        .ifSome(resourceType)(_.resourceType(_))
        .build

    def startRestoreJobOutput(
      restoreJobId: Option[String] = None
    ): StartRestoreJobOutput =
      StartRestoreJobOutput
        .builder
        .ifSome(restoreJobId)(_.restoreJobId(_))
        .build

    def stopBackupJobInput(
      backupJobId: Option[String] = None
    ): StopBackupJobInput =
      StopBackupJobInput
        .builder
        .ifSome(backupJobId)(_.backupJobId(_))
        .build

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[Tags] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeyList: Option[List[string]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeyList)(_.tagKeyList(_))
        .build

    def updateBackupPlanInput(
      backupPlanId: Option[String] = None,
      backupPlan: Option[BackupPlanInput] = None
    ): UpdateBackupPlanInput =
      UpdateBackupPlanInput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupPlan)(_.backupPlan(_))
        .build

    def updateBackupPlanOutput(
      backupPlanId: Option[String] = None,
      backupPlanArn: Option[String] = None,
      creationDate: Option[timestamp] = None,
      versionId: Option[String] = None,
      advancedBackupSettings: Option[List[AdvancedBackupSetting]] = None
    ): UpdateBackupPlanOutput =
      UpdateBackupPlanOutput
        .builder
        .ifSome(backupPlanId)(_.backupPlanId(_))
        .ifSome(backupPlanArn)(_.backupPlanArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(advancedBackupSettings)(_.advancedBackupSettings(_))
        .build

    def updateGlobalSettingsInput(
      globalSettings: Option[GlobalSettings] = None
    ): UpdateGlobalSettingsInput =
      UpdateGlobalSettingsInput
        .builder
        .ifSome(globalSettings)(_.globalSettings(_))
        .build

    def updateRecoveryPointLifecycleInput(
      backupVaultName: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      lifecycle: Option[Lifecycle] = None
    ): UpdateRecoveryPointLifecycleInput =
      UpdateRecoveryPointLifecycleInput
        .builder
        .ifSome(backupVaultName)(_.backupVaultName(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .build

    def updateRecoveryPointLifecycleOutput(
      backupVaultArn: Option[String] = None,
      recoveryPointArn: Option[String] = None,
      lifecycle: Option[Lifecycle] = None,
      calculatedLifecycle: Option[CalculatedLifecycle] = None
    ): UpdateRecoveryPointLifecycleOutput =
      UpdateRecoveryPointLifecycleOutput
        .builder
        .ifSome(backupVaultArn)(_.backupVaultArn(_))
        .ifSome(recoveryPointArn)(_.recoveryPointArn(_))
        .ifSome(lifecycle)(_.lifecycle(_))
        .ifSome(calculatedLifecycle)(_.calculatedLifecycle(_))
        .build

    def updateRegionSettingsInput(
      resourceTypeOptInPreference: Option[ResourceTypeOptInPreference] = None
    ): UpdateRegionSettingsInput =
      UpdateRegionSettingsInput
        .builder
        .ifSome(resourceTypeOptInPreference)(_.resourceTypeOptInPreference(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
