package goober.hi

import goober.free.cloudformation.CloudFormationIO
import software.amazon.awssdk.services.cloudformation.model._


object cloudformation {
  import goober.free.{cloudformation ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def accountLimit(
      name: Option[String] = None,
      value: Option[Int] = None
    ): AccountLimit =
      AccountLimit
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def alreadyExistsException(

    ): AlreadyExistsException =
      AlreadyExistsException
        .builder

        .build

    def autoDeployment(
      enabled: Option[Boolean] = None,
      retainStacksOnAccountRemoval: Option[Boolean] = None
    ): AutoDeployment =
      AutoDeployment
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(retainStacksOnAccountRemoval)(_.retainStacksOnAccountRemoval(_))
        .build

    def cFNRegistryException(
      message: Option[String] = None
    ): CFNRegistryException =
      CFNRegistryException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelUpdateStackInput(
      stackName: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): CancelUpdateStackInput =
      CancelUpdateStackInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def change(
      `type`: Option[String] = None,
      resourceChange: Option[ResourceChange] = None
    ): Change =
      Change
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(resourceChange)(_.resourceChange(_))
        .build

    def changeSetNotFoundException(

    ): ChangeSetNotFoundException =
      ChangeSetNotFoundException
        .builder

        .build

    def changeSetSummary(
      stackId: Option[String] = None,
      stackName: Option[String] = None,
      changeSetId: Option[String] = None,
      changeSetName: Option[String] = None,
      executionStatus: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      description: Option[String] = None,
      includeNestedStacks: Option[Boolean] = None,
      parentChangeSetId: Option[String] = None,
      rootChangeSetId: Option[String] = None
    ): ChangeSetSummary =
      ChangeSetSummary
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(executionStatus)(_.executionStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(description)(_.description(_))
        .ifSome(includeNestedStacks)(_.includeNestedStacks(_))
        .ifSome(parentChangeSetId)(_.parentChangeSetId(_))
        .ifSome(rootChangeSetId)(_.rootChangeSetId(_))
        .build

    def continueUpdateRollbackInput(
      stackName: Option[String] = None,
      roleARN: Option[String] = None,
      resourcesToSkip: Option[List[ResourceToSkip]] = None,
      clientRequestToken: Option[String] = None
    ): ContinueUpdateRollbackInput =
      ContinueUpdateRollbackInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(resourcesToSkip)(_.resourcesToSkip(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def continueUpdateRollbackOutput(

    ): ContinueUpdateRollbackOutput =
      ContinueUpdateRollbackOutput
        .builder

        .build

    def createChangeSetInput(
      stackName: Option[String] = None,
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      usePreviousTemplate: Option[Boolean] = None,
      parameters: Option[List[Parameter]] = None,
      capabilities: Option[List[Capability]] = None,
      resourceTypes: Option[List[ResourceType]] = None,
      roleARN: Option[String] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      notificationARNs: Option[List[NotificationARN]] = None,
      tags: Option[List[Tag]] = None,
      changeSetName: Option[String] = None,
      clientToken: Option[String] = None,
      description: Option[String] = None,
      changeSetType: Option[String] = None,
      resourcesToImport: Option[List[ResourceToImport]] = None,
      includeNestedStacks: Option[Boolean] = None
    ): CreateChangeSetInput =
      CreateChangeSetInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(usePreviousTemplate)(_.usePreviousTemplate(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(notificationARNs)(_.notificationARNs(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(changeSetType)(_.changeSetType(_))
        .ifSome(resourcesToImport)(_.resourcesToImport(_))
        .ifSome(includeNestedStacks)(_.includeNestedStacks(_))
        .build

    def createChangeSetOutput(
      id: Option[String] = None,
      stackId: Option[String] = None
    ): CreateChangeSetOutput =
      CreateChangeSetOutput
        .builder
        .ifSome(id)(_.id(_))
        .ifSome(stackId)(_.stackId(_))
        .build

    def createStackInput(
      stackName: Option[String] = None,
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      disableRollback: Option[Boolean] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      timeoutInMinutes: Option[Int] = None,
      notificationARNs: Option[List[NotificationARN]] = None,
      capabilities: Option[List[Capability]] = None,
      resourceTypes: Option[List[ResourceType]] = None,
      roleARN: Option[String] = None,
      onFailure: Option[String] = None,
      stackPolicyBody: Option[String] = None,
      stackPolicyURL: Option[String] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None,
      enableTerminationProtection: Option[Boolean] = None
    ): CreateStackInput =
      CreateStackInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(disableRollback)(_.disableRollback(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .ifSome(notificationARNs)(_.notificationARNs(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(onFailure)(_.onFailure(_))
        .ifSome(stackPolicyBody)(_.stackPolicyBody(_))
        .ifSome(stackPolicyURL)(_.stackPolicyURL(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(enableTerminationProtection)(_.enableTerminationProtection(_))
        .build

    def createStackInstancesInput(
      stackSetName: Option[String] = None,
      accounts: Option[List[Account]] = None,
      deploymentTargets: Option[DeploymentTargets] = None,
      regions: Option[List[Region]] = None,
      parameterOverrides: Option[List[Parameter]] = None,
      operationPreferences: Option[StackSetOperationPreferences] = None,
      operationId: Option[String] = None,
      callAs: Option[String] = None
    ): CreateStackInstancesInput =
      CreateStackInstancesInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(accounts)(_.accounts(_))
        .ifSome(deploymentTargets)(_.deploymentTargets(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(parameterOverrides)(_.parameterOverrides(_))
        .ifSome(operationPreferences)(_.operationPreferences(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def createStackInstancesOutput(
      operationId: Option[String] = None
    ): CreateStackInstancesOutput =
      CreateStackInstancesOutput
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def createStackOutput(
      stackId: Option[String] = None
    ): CreateStackOutput =
      CreateStackOutput
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def createStackSetInput(
      stackSetName: Option[String] = None,
      description: Option[String] = None,
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      capabilities: Option[List[Capability]] = None,
      tags: Option[List[Tag]] = None,
      administrationRoleARN: Option[String] = None,
      executionRoleName: Option[String] = None,
      permissionModel: Option[String] = None,
      autoDeployment: Option[AutoDeployment] = None,
      callAs: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): CreateStackSetInput =
      CreateStackSetInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(description)(_.description(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(administrationRoleARN)(_.administrationRoleARN(_))
        .ifSome(executionRoleName)(_.executionRoleName(_))
        .ifSome(permissionModel)(_.permissionModel(_))
        .ifSome(autoDeployment)(_.autoDeployment(_))
        .ifSome(callAs)(_.callAs(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createStackSetOutput(
      stackSetId: Option[String] = None
    ): CreateStackSetOutput =
      CreateStackSetOutput
        .builder
        .ifSome(stackSetId)(_.stackSetId(_))
        .build

    def createdButModifiedException(

    ): CreatedButModifiedException =
      CreatedButModifiedException
        .builder

        .build

    def deleteChangeSetInput(
      changeSetName: Option[String] = None,
      stackName: Option[String] = None
    ): DeleteChangeSetInput =
      DeleteChangeSetInput
        .builder
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(stackName)(_.stackName(_))
        .build

    def deleteChangeSetOutput(

    ): DeleteChangeSetOutput =
      DeleteChangeSetOutput
        .builder

        .build

    def deleteStackInput(
      stackName: Option[String] = None,
      retainResources: Option[List[LogicalResourceId]] = None,
      roleARN: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): DeleteStackInput =
      DeleteStackInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(retainResources)(_.retainResources(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def deleteStackInstancesInput(
      stackSetName: Option[String] = None,
      accounts: Option[List[Account]] = None,
      deploymentTargets: Option[DeploymentTargets] = None,
      regions: Option[List[Region]] = None,
      operationPreferences: Option[StackSetOperationPreferences] = None,
      retainStacks: Option[Boolean] = None,
      operationId: Option[String] = None,
      callAs: Option[String] = None
    ): DeleteStackInstancesInput =
      DeleteStackInstancesInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(accounts)(_.accounts(_))
        .ifSome(deploymentTargets)(_.deploymentTargets(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(operationPreferences)(_.operationPreferences(_))
        .ifSome(retainStacks)(_.retainStacks(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def deleteStackInstancesOutput(
      operationId: Option[String] = None
    ): DeleteStackInstancesOutput =
      DeleteStackInstancesOutput
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def deleteStackSetInput(
      stackSetName: Option[String] = None,
      callAs: Option[String] = None
    ): DeleteStackSetInput =
      DeleteStackSetInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def deleteStackSetOutput(

    ): DeleteStackSetOutput =
      DeleteStackSetOutput
        .builder

        .build

    def deploymentTargets(
      accounts: Option[List[Account]] = None,
      accountsUrl: Option[String] = None,
      organizationalUnitIds: Option[List[OrganizationalUnitId]] = None
    ): DeploymentTargets =
      DeploymentTargets
        .builder
        .ifSome(accounts)(_.accounts(_))
        .ifSome(accountsUrl)(_.accountsUrl(_))
        .ifSome(organizationalUnitIds)(_.organizationalUnitIds(_))
        .build

    def deregisterTypeInput(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      versionId: Option[String] = None
    ): DeregisterTypeInput =
      DeregisterTypeInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def deregisterTypeOutput(

    ): DeregisterTypeOutput =
      DeregisterTypeOutput
        .builder

        .build

    def describeAccountLimitsInput(
      nextToken: Option[String] = None
    ): DescribeAccountLimitsInput =
      DescribeAccountLimitsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeAccountLimitsOutput(
      accountLimits: Option[List[AccountLimit]] = None,
      nextToken: Option[String] = None
    ): DescribeAccountLimitsOutput =
      DescribeAccountLimitsOutput
        .builder
        .ifSome(accountLimits)(_.accountLimits(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeChangeSetInput(
      changeSetName: Option[String] = None,
      stackName: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeChangeSetInput =
      DescribeChangeSetInput
        .builder
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeChangeSetOutput(
      changeSetName: Option[String] = None,
      changeSetId: Option[String] = None,
      stackId: Option[String] = None,
      stackName: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      creationTime: Option[CreationTime] = None,
      executionStatus: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      notificationARNs: Option[List[NotificationARN]] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      capabilities: Option[List[Capability]] = None,
      tags: Option[List[Tag]] = None,
      changes: Option[List[Change]] = None,
      nextToken: Option[String] = None,
      includeNestedStacks: Option[Boolean] = None,
      parentChangeSetId: Option[String] = None,
      rootChangeSetId: Option[String] = None
    ): DescribeChangeSetOutput =
      DescribeChangeSetOutput
        .builder
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(executionStatus)(_.executionStatus(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(notificationARNs)(_.notificationARNs(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(changes)(_.changes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(includeNestedStacks)(_.includeNestedStacks(_))
        .ifSome(parentChangeSetId)(_.parentChangeSetId(_))
        .ifSome(rootChangeSetId)(_.rootChangeSetId(_))
        .build

    def describeStackDriftDetectionStatusInput(
      stackDriftDetectionId: Option[String] = None
    ): DescribeStackDriftDetectionStatusInput =
      DescribeStackDriftDetectionStatusInput
        .builder
        .ifSome(stackDriftDetectionId)(_.stackDriftDetectionId(_))
        .build

    def describeStackDriftDetectionStatusOutput(
      stackId: Option[String] = None,
      stackDriftDetectionId: Option[String] = None,
      stackDriftStatus: Option[String] = None,
      detectionStatus: Option[String] = None,
      detectionStatusReason: Option[String] = None,
      driftedStackResourceCount: Option[Int] = None,
      timestamp: Option[Timestamp] = None
    ): DescribeStackDriftDetectionStatusOutput =
      DescribeStackDriftDetectionStatusOutput
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(stackDriftDetectionId)(_.stackDriftDetectionId(_))
        .ifSome(stackDriftStatus)(_.stackDriftStatus(_))
        .ifSome(detectionStatus)(_.detectionStatus(_))
        .ifSome(detectionStatusReason)(_.detectionStatusReason(_))
        .ifSome(driftedStackResourceCount)(_.driftedStackResourceCount(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def describeStackEventsInput(
      stackName: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeStackEventsInput =
      DescribeStackEventsInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStackEventsOutput(
      stackEvents: Option[List[StackEvent]] = None,
      nextToken: Option[String] = None
    ): DescribeStackEventsOutput =
      DescribeStackEventsOutput
        .builder
        .ifSome(stackEvents)(_.stackEvents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStackInstanceInput(
      stackSetName: Option[String] = None,
      stackInstanceAccount: Option[String] = None,
      stackInstanceRegion: Option[String] = None,
      callAs: Option[String] = None
    ): DescribeStackInstanceInput =
      DescribeStackInstanceInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(stackInstanceAccount)(_.stackInstanceAccount(_))
        .ifSome(stackInstanceRegion)(_.stackInstanceRegion(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def describeStackInstanceOutput(
      stackInstance: Option[StackInstance] = None
    ): DescribeStackInstanceOutput =
      DescribeStackInstanceOutput
        .builder
        .ifSome(stackInstance)(_.stackInstance(_))
        .build

    def describeStackResourceDriftsInput(
      stackName: Option[String] = None,
      stackResourceDriftStatusFilters: Option[List[StackResourceDriftStatus]] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): DescribeStackResourceDriftsInput =
      DescribeStackResourceDriftsInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(stackResourceDriftStatusFilters)(_.stackResourceDriftStatusFilters(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def describeStackResourceDriftsOutput(
      stackResourceDrifts: Option[List[StackResourceDrift]] = None,
      nextToken: Option[String] = None
    ): DescribeStackResourceDriftsOutput =
      DescribeStackResourceDriftsOutput
        .builder
        .ifSome(stackResourceDrifts)(_.stackResourceDrifts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStackResourceInput(
      stackName: Option[String] = None,
      logicalResourceId: Option[String] = None
    ): DescribeStackResourceInput =
      DescribeStackResourceInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .build

    def describeStackResourceOutput(
      stackResourceDetail: Option[StackResourceDetail] = None
    ): DescribeStackResourceOutput =
      DescribeStackResourceOutput
        .builder
        .ifSome(stackResourceDetail)(_.stackResourceDetail(_))
        .build

    def describeStackResourcesInput(
      stackName: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None
    ): DescribeStackResourcesInput =
      DescribeStackResourcesInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .build

    def describeStackResourcesOutput(
      stackResources: Option[List[StackResource]] = None
    ): DescribeStackResourcesOutput =
      DescribeStackResourcesOutput
        .builder
        .ifSome(stackResources)(_.stackResources(_))
        .build

    def describeStackSetInput(
      stackSetName: Option[String] = None,
      callAs: Option[String] = None
    ): DescribeStackSetInput =
      DescribeStackSetInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def describeStackSetOperationInput(
      stackSetName: Option[String] = None,
      operationId: Option[String] = None,
      callAs: Option[String] = None
    ): DescribeStackSetOperationInput =
      DescribeStackSetOperationInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def describeStackSetOperationOutput(
      stackSetOperation: Option[StackSetOperation] = None
    ): DescribeStackSetOperationOutput =
      DescribeStackSetOperationOutput
        .builder
        .ifSome(stackSetOperation)(_.stackSetOperation(_))
        .build

    def describeStackSetOutput(
      stackSet: Option[StackSet] = None
    ): DescribeStackSetOutput =
      DescribeStackSetOutput
        .builder
        .ifSome(stackSet)(_.stackSet(_))
        .build

    def describeStacksInput(
      stackName: Option[String] = None,
      nextToken: Option[String] = None
    ): DescribeStacksInput =
      DescribeStacksInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeStacksOutput(
      stacks: Option[List[Stack]] = None,
      nextToken: Option[String] = None
    ): DescribeStacksOutput =
      DescribeStacksOutput
        .builder
        .ifSome(stacks)(_.stacks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def describeTypeInput(
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      arn: Option[String] = None,
      versionId: Option[String] = None
    ): DescribeTypeInput =
      DescribeTypeInput
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def describeTypeOutput(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      defaultVersionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None,
      description: Option[String] = None,
      schema: Option[String] = None,
      provisioningType: Option[String] = None,
      deprecatedStatus: Option[String] = None,
      loggingConfig: Option[LoggingConfig] = None,
      executionRoleArn: Option[String] = None,
      visibility: Option[String] = None,
      sourceUrl: Option[String] = None,
      documentationUrl: Option[String] = None,
      lastUpdated: Option[Timestamp] = None,
      timeCreated: Option[Timestamp] = None
    ): DescribeTypeOutput =
      DescribeTypeOutput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(schema)(_.schema(_))
        .ifSome(provisioningType)(_.provisioningType(_))
        .ifSome(deprecatedStatus)(_.deprecatedStatus(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(visibility)(_.visibility(_))
        .ifSome(sourceUrl)(_.sourceUrl(_))
        .ifSome(documentationUrl)(_.documentationUrl(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(timeCreated)(_.timeCreated(_))
        .build

    def describeTypeRegistrationInput(
      registrationToken: Option[String] = None
    ): DescribeTypeRegistrationInput =
      DescribeTypeRegistrationInput
        .builder
        .ifSome(registrationToken)(_.registrationToken(_))
        .build

    def describeTypeRegistrationOutput(
      progressStatus: Option[String] = None,
      description: Option[String] = None,
      typeArn: Option[String] = None,
      typeVersionArn: Option[String] = None
    ): DescribeTypeRegistrationOutput =
      DescribeTypeRegistrationOutput
        .builder
        .ifSome(progressStatus)(_.progressStatus(_))
        .ifSome(description)(_.description(_))
        .ifSome(typeArn)(_.typeArn(_))
        .ifSome(typeVersionArn)(_.typeVersionArn(_))
        .build

    def detectStackDriftInput(
      stackName: Option[String] = None,
      logicalResourceIds: Option[List[LogicalResourceId]] = None
    ): DetectStackDriftInput =
      DetectStackDriftInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(logicalResourceIds)(_.logicalResourceIds(_))
        .build

    def detectStackDriftOutput(
      stackDriftDetectionId: Option[String] = None
    ): DetectStackDriftOutput =
      DetectStackDriftOutput
        .builder
        .ifSome(stackDriftDetectionId)(_.stackDriftDetectionId(_))
        .build

    def detectStackResourceDriftInput(
      stackName: Option[String] = None,
      logicalResourceId: Option[String] = None
    ): DetectStackResourceDriftInput =
      DetectStackResourceDriftInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .build

    def detectStackResourceDriftOutput(
      stackResourceDrift: Option[StackResourceDrift] = None
    ): DetectStackResourceDriftOutput =
      DetectStackResourceDriftOutput
        .builder
        .ifSome(stackResourceDrift)(_.stackResourceDrift(_))
        .build

    def detectStackSetDriftInput(
      stackSetName: Option[String] = None,
      operationPreferences: Option[StackSetOperationPreferences] = None,
      operationId: Option[String] = None,
      callAs: Option[String] = None
    ): DetectStackSetDriftInput =
      DetectStackSetDriftInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(operationPreferences)(_.operationPreferences(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def detectStackSetDriftOutput(
      operationId: Option[String] = None
    ): DetectStackSetDriftOutput =
      DetectStackSetDriftOutput
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def estimateTemplateCostInput(
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      parameters: Option[List[Parameter]] = None
    ): EstimateTemplateCostInput =
      EstimateTemplateCostInput
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def estimateTemplateCostOutput(
      url: Option[String] = None
    ): EstimateTemplateCostOutput =
      EstimateTemplateCostOutput
        .builder
        .ifSome(url)(_.url(_))
        .build

    def executeChangeSetInput(
      changeSetName: Option[String] = None,
      stackName: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): ExecuteChangeSetInput =
      ExecuteChangeSetInput
        .builder
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def executeChangeSetOutput(

    ): ExecuteChangeSetOutput =
      ExecuteChangeSetOutput
        .builder

        .build

    def export(
      exportingStackId: Option[String] = None,
      name: Option[String] = None,
      value: Option[String] = None
    ): Export =
      Export
        .builder
        .ifSome(exportingStackId)(_.exportingStackId(_))
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def getStackPolicyInput(
      stackName: Option[String] = None
    ): GetStackPolicyInput =
      GetStackPolicyInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .build

    def getStackPolicyOutput(
      stackPolicyBody: Option[String] = None
    ): GetStackPolicyOutput =
      GetStackPolicyOutput
        .builder
        .ifSome(stackPolicyBody)(_.stackPolicyBody(_))
        .build

    def getTemplateInput(
      stackName: Option[String] = None,
      changeSetName: Option[String] = None,
      templateStage: Option[String] = None
    ): GetTemplateInput =
      GetTemplateInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(changeSetName)(_.changeSetName(_))
        .ifSome(templateStage)(_.templateStage(_))
        .build

    def getTemplateOutput(
      templateBody: Option[String] = None,
      stagesAvailable: Option[List[TemplateStage]] = None
    ): GetTemplateOutput =
      GetTemplateOutput
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(stagesAvailable)(_.stagesAvailable(_))
        .build

    def getTemplateSummaryInput(
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      stackName: Option[String] = None,
      stackSetName: Option[String] = None,
      callAs: Option[String] = None
    ): GetTemplateSummaryInput =
      GetTemplateSummaryInput
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def getTemplateSummaryOutput(
      parameters: Option[List[ParameterDeclaration]] = None,
      description: Option[String] = None,
      capabilities: Option[List[Capability]] = None,
      capabilitiesReason: Option[String] = None,
      resourceTypes: Option[List[ResourceType]] = None,
      version: Option[String] = None,
      metadata: Option[String] = None,
      declaredTransforms: Option[List[TransformName]] = None,
      resourceIdentifierSummaries: Option[List[ResourceIdentifierSummary]] = None
    ): GetTemplateSummaryOutput =
      GetTemplateSummaryOutput
        .builder
        .ifSome(parameters)(_.parameters(_))
        .ifSome(description)(_.description(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(capabilitiesReason)(_.capabilitiesReason(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(version)(_.version(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(declaredTransforms)(_.declaredTransforms(_))
        .ifSome(resourceIdentifierSummaries)(_.resourceIdentifierSummaries(_))
        .build

    def insufficientCapabilitiesException(

    ): InsufficientCapabilitiesException =
      InsufficientCapabilitiesException
        .builder

        .build

    def invalidChangeSetStatusException(

    ): InvalidChangeSetStatusException =
      InvalidChangeSetStatusException
        .builder

        .build

    def invalidOperationException(

    ): InvalidOperationException =
      InvalidOperationException
        .builder

        .build

    def invalidStateTransitionException(

    ): InvalidStateTransitionException =
      InvalidStateTransitionException
        .builder

        .build

    def limitExceededException(

    ): LimitExceededException =
      LimitExceededException
        .builder

        .build

    def listChangeSetsInput(
      stackName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListChangeSetsInput =
      ListChangeSetsInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listChangeSetsOutput(
      summaries: Option[List[ChangeSetSummary]] = None,
      nextToken: Option[String] = None
    ): ListChangeSetsOutput =
      ListChangeSetsOutput
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExportsInput(
      nextToken: Option[String] = None
    ): ListExportsInput =
      ListExportsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExportsOutput(
      exports: Option[List[Export]] = None,
      nextToken: Option[String] = None
    ): ListExportsOutput =
      ListExportsOutput
        .builder
        .ifSome(exports)(_.exports(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImportsInput(
      exportName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListImportsInput =
      ListImportsInput
        .builder
        .ifSome(exportName)(_.exportName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listImportsOutput(
      imports: Option[List[StackName]] = None,
      nextToken: Option[String] = None
    ): ListImportsOutput =
      ListImportsOutput
        .builder
        .ifSome(imports)(_.imports(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStackInstancesInput(
      stackSetName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      filters: Option[List[StackInstanceFilter]] = None,
      stackInstanceAccount: Option[String] = None,
      stackInstanceRegion: Option[String] = None,
      callAs: Option[String] = None
    ): ListStackInstancesInput =
      ListStackInstancesInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(stackInstanceAccount)(_.stackInstanceAccount(_))
        .ifSome(stackInstanceRegion)(_.stackInstanceRegion(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def listStackInstancesOutput(
      summaries: Option[List[StackInstanceSummary]] = None,
      nextToken: Option[String] = None
    ): ListStackInstancesOutput =
      ListStackInstancesOutput
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStackResourcesInput(
      stackName: Option[String] = None,
      nextToken: Option[String] = None
    ): ListStackResourcesInput =
      ListStackResourcesInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStackResourcesOutput(
      stackResourceSummaries: Option[List[StackResourceSummary]] = None,
      nextToken: Option[String] = None
    ): ListStackResourcesOutput =
      ListStackResourcesOutput
        .builder
        .ifSome(stackResourceSummaries)(_.stackResourceSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStackSetOperationResultsInput(
      stackSetName: Option[String] = None,
      operationId: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      callAs: Option[String] = None
    ): ListStackSetOperationResultsInput =
      ListStackSetOperationResultsInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def listStackSetOperationResultsOutput(
      summaries: Option[List[StackSetOperationResultSummary]] = None,
      nextToken: Option[String] = None
    ): ListStackSetOperationResultsOutput =
      ListStackSetOperationResultsOutput
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStackSetOperationsInput(
      stackSetName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      callAs: Option[String] = None
    ): ListStackSetOperationsInput =
      ListStackSetOperationsInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def listStackSetOperationsOutput(
      summaries: Option[List[StackSetOperationSummary]] = None,
      nextToken: Option[String] = None
    ): ListStackSetOperationsOutput =
      ListStackSetOperationsOutput
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStackSetsInput(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      status: Option[String] = None,
      callAs: Option[String] = None
    ): ListStackSetsInput =
      ListStackSetsInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(status)(_.status(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def listStackSetsOutput(
      summaries: Option[List[StackSetSummary]] = None,
      nextToken: Option[String] = None
    ): ListStackSetsOutput =
      ListStackSetsOutput
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStacksInput(
      nextToken: Option[String] = None,
      stackStatusFilter: Option[List[StackStatus]] = None
    ): ListStacksInput =
      ListStacksInput
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(stackStatusFilter)(_.stackStatusFilter(_))
        .build

    def listStacksOutput(
      stackSummaries: Option[List[StackSummary]] = None,
      nextToken: Option[String] = None
    ): ListStacksOutput =
      ListStacksOutput
        .builder
        .ifSome(stackSummaries)(_.stackSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypeRegistrationsInput(
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      typeArn: Option[String] = None,
      registrationStatusFilter: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTypeRegistrationsInput =
      ListTypeRegistrationsInput
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(typeArn)(_.typeArn(_))
        .ifSome(registrationStatusFilter)(_.registrationStatusFilter(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypeRegistrationsOutput(
      registrationTokenList: Option[List[RegistrationToken]] = None,
      nextToken: Option[String] = None
    ): ListTypeRegistrationsOutput =
      ListTypeRegistrationsOutput
        .builder
        .ifSome(registrationTokenList)(_.registrationTokenList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypeVersionsInput(
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      arn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      deprecatedStatus: Option[String] = None
    ): ListTypeVersionsInput =
      ListTypeVersionsInput
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(deprecatedStatus)(_.deprecatedStatus(_))
        .build

    def listTypeVersionsOutput(
      typeVersionSummaries: Option[List[TypeVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListTypeVersionsOutput =
      ListTypeVersionsOutput
        .builder
        .ifSome(typeVersionSummaries)(_.typeVersionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypesInput(
      visibility: Option[String] = None,
      provisioningType: Option[String] = None,
      deprecatedStatus: Option[String] = None,
      `type`: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTypesInput =
      ListTypesInput
        .builder
        .ifSome(visibility)(_.visibility(_))
        .ifSome(provisioningType)(_.provisioningType(_))
        .ifSome(deprecatedStatus)(_.deprecatedStatus(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTypesOutput(
      typeSummaries: Option[List[TypeSummary]] = None,
      nextToken: Option[String] = None
    ): ListTypesOutput =
      ListTypesOutput
        .builder
        .ifSome(typeSummaries)(_.typeSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def loggingConfig(
      logRoleArn: Option[String] = None,
      logGroupName: Option[String] = None
    ): LoggingConfig =
      LoggingConfig
        .builder
        .ifSome(logRoleArn)(_.logRoleArn(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def moduleInfo(
      typeHierarchy: Option[String] = None,
      logicalIdHierarchy: Option[String] = None
    ): ModuleInfo =
      ModuleInfo
        .builder
        .ifSome(typeHierarchy)(_.typeHierarchy(_))
        .ifSome(logicalIdHierarchy)(_.logicalIdHierarchy(_))
        .build

    def nameAlreadyExistsException(

    ): NameAlreadyExistsException =
      NameAlreadyExistsException
        .builder

        .build

    def operationIdAlreadyExistsException(

    ): OperationIdAlreadyExistsException =
      OperationIdAlreadyExistsException
        .builder

        .build

    def operationInProgressException(

    ): OperationInProgressException =
      OperationInProgressException
        .builder

        .build

    def operationNotFoundException(

    ): OperationNotFoundException =
      OperationNotFoundException
        .builder

        .build

    def operationStatusCheckFailedException(

    ): OperationStatusCheckFailedException =
      OperationStatusCheckFailedException
        .builder

        .build

    def output(
      outputKey: Option[String] = None,
      outputValue: Option[String] = None,
      description: Option[String] = None,
      exportName: Option[String] = None
    ): Output =
      Output
        .builder
        .ifSome(outputKey)(_.outputKey(_))
        .ifSome(outputValue)(_.outputValue(_))
        .ifSome(description)(_.description(_))
        .ifSome(exportName)(_.exportName(_))
        .build

    def parameter(
      parameterKey: Option[String] = None,
      parameterValue: Option[String] = None,
      usePreviousValue: Option[Boolean] = None,
      resolvedValue: Option[String] = None
    ): Parameter =
      Parameter
        .builder
        .ifSome(parameterKey)(_.parameterKey(_))
        .ifSome(parameterValue)(_.parameterValue(_))
        .ifSome(usePreviousValue)(_.usePreviousValue(_))
        .ifSome(resolvedValue)(_.resolvedValue(_))
        .build

    def parameterConstraints(
      allowedValues: Option[List[AllowedValue]] = None
    ): ParameterConstraints =
      ParameterConstraints
        .builder
        .ifSome(allowedValues)(_.allowedValues(_))
        .build

    def parameterDeclaration(
      parameterKey: Option[String] = None,
      defaultValue: Option[String] = None,
      parameterType: Option[String] = None,
      noEcho: Option[Boolean] = None,
      description: Option[String] = None,
      parameterConstraints: Option[ParameterConstraints] = None
    ): ParameterDeclaration =
      ParameterDeclaration
        .builder
        .ifSome(parameterKey)(_.parameterKey(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(parameterType)(_.parameterType(_))
        .ifSome(noEcho)(_.noEcho(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameterConstraints)(_.parameterConstraints(_))
        .build

    def physicalResourceIdContextKeyValuePair(
      key: Option[String] = None,
      value: Option[String] = None
    ): PhysicalResourceIdContextKeyValuePair =
      PhysicalResourceIdContextKeyValuePair
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def propertyDifference(
      propertyPath: Option[String] = None,
      expectedValue: Option[String] = None,
      actualValue: Option[String] = None,
      differenceType: Option[String] = None
    ): PropertyDifference =
      PropertyDifference
        .builder
        .ifSome(propertyPath)(_.propertyPath(_))
        .ifSome(expectedValue)(_.expectedValue(_))
        .ifSome(actualValue)(_.actualValue(_))
        .ifSome(differenceType)(_.differenceType(_))
        .build

    def recordHandlerProgressInput(
      bearerToken: Option[String] = None,
      operationStatus: Option[String] = None,
      currentOperationStatus: Option[String] = None,
      statusMessage: Option[String] = None,
      errorCode: Option[String] = None,
      resourceModel: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): RecordHandlerProgressInput =
      RecordHandlerProgressInput
        .builder
        .ifSome(bearerToken)(_.bearerToken(_))
        .ifSome(operationStatus)(_.operationStatus(_))
        .ifSome(currentOperationStatus)(_.currentOperationStatus(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(resourceModel)(_.resourceModel(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def recordHandlerProgressOutput(

    ): RecordHandlerProgressOutput =
      RecordHandlerProgressOutput
        .builder

        .build

    def registerTypeInput(
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      schemaHandlerPackage: Option[String] = None,
      loggingConfig: Option[LoggingConfig] = None,
      executionRoleArn: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): RegisterTypeInput =
      RegisterTypeInput
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(schemaHandlerPackage)(_.schemaHandlerPackage(_))
        .ifSome(loggingConfig)(_.loggingConfig(_))
        .ifSome(executionRoleArn)(_.executionRoleArn(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def registerTypeOutput(
      registrationToken: Option[String] = None
    ): RegisterTypeOutput =
      RegisterTypeOutput
        .builder
        .ifSome(registrationToken)(_.registrationToken(_))
        .build

    def resourceChange(
      action: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      resourceType: Option[String] = None,
      replacement: Option[String] = None,
      scope: Option[List[ResourceAttribute]] = None,
      details: Option[List[ResourceChangeDetail]] = None,
      changeSetId: Option[String] = None,
      moduleInfo: Option[ModuleInfo] = None
    ): ResourceChange =
      ResourceChange
        .builder
        .ifSome(action)(_.action(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(replacement)(_.replacement(_))
        .ifSome(scope)(_.scope(_))
        .ifSome(details)(_.details(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(moduleInfo)(_.moduleInfo(_))
        .build

    def resourceChangeDetail(
      target: Option[ResourceTargetDefinition] = None,
      evaluation: Option[String] = None,
      changeSource: Option[String] = None,
      causingEntity: Option[String] = None
    ): ResourceChangeDetail =
      ResourceChangeDetail
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(evaluation)(_.evaluation(_))
        .ifSome(changeSource)(_.changeSource(_))
        .ifSome(causingEntity)(_.causingEntity(_))
        .build

    def resourceIdentifierSummary(
      resourceType: Option[String] = None,
      logicalResourceIds: Option[List[LogicalResourceId]] = None,
      resourceIdentifiers: Option[List[ResourceIdentifierPropertyKey]] = None
    ): ResourceIdentifierSummary =
      ResourceIdentifierSummary
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(logicalResourceIds)(_.logicalResourceIds(_))
        .ifSome(resourceIdentifiers)(_.resourceIdentifiers(_))
        .build

    def resourceTargetDefinition(
      attribute: Option[String] = None,
      name: Option[String] = None,
      requiresRecreation: Option[String] = None
    ): ResourceTargetDefinition =
      ResourceTargetDefinition
        .builder
        .ifSome(attribute)(_.attribute(_))
        .ifSome(name)(_.name(_))
        .ifSome(requiresRecreation)(_.requiresRecreation(_))
        .build

    def resourceToImport(
      resourceType: Option[String] = None,
      logicalResourceId: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifierProperties] = None
    ): ResourceToImport =
      ResourceToImport
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .build

    def rollbackConfiguration(
      rollbackTriggers: Option[List[RollbackTrigger]] = None,
      monitoringTimeInMinutes: Option[Int] = None
    ): RollbackConfiguration =
      RollbackConfiguration
        .builder
        .ifSome(rollbackTriggers)(_.rollbackTriggers(_))
        .ifSome(monitoringTimeInMinutes)(_.monitoringTimeInMinutes(_))
        .build

    def rollbackTrigger(
      arn: Option[String] = None,
      `type`: Option[String] = None
    ): RollbackTrigger =
      RollbackTrigger
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def setStackPolicyInput(
      stackName: Option[String] = None,
      stackPolicyBody: Option[String] = None,
      stackPolicyURL: Option[String] = None
    ): SetStackPolicyInput =
      SetStackPolicyInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(stackPolicyBody)(_.stackPolicyBody(_))
        .ifSome(stackPolicyURL)(_.stackPolicyURL(_))
        .build

    def setTypeDefaultVersionInput(
      arn: Option[String] = None,
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      versionId: Option[String] = None
    ): SetTypeDefaultVersionInput =
      SetTypeDefaultVersionInput
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def setTypeDefaultVersionOutput(

    ): SetTypeDefaultVersionOutput =
      SetTypeDefaultVersionOutput
        .builder

        .build

    def signalResourceInput(
      stackName: Option[String] = None,
      logicalResourceId: Option[String] = None,
      uniqueId: Option[String] = None,
      status: Option[String] = None
    ): SignalResourceInput =
      SignalResourceInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(uniqueId)(_.uniqueId(_))
        .ifSome(status)(_.status(_))
        .build

    def stack(
      stackId: Option[String] = None,
      stackName: Option[String] = None,
      changeSetId: Option[String] = None,
      description: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      creationTime: Option[CreationTime] = None,
      deletionTime: Option[DeletionTime] = None,
      lastUpdatedTime: Option[LastUpdatedTime] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      stackStatus: Option[String] = None,
      stackStatusReason: Option[String] = None,
      disableRollback: Option[Boolean] = None,
      notificationARNs: Option[List[NotificationARN]] = None,
      timeoutInMinutes: Option[Int] = None,
      capabilities: Option[List[Capability]] = None,
      outputs: Option[List[Output]] = None,
      roleARN: Option[String] = None,
      tags: Option[List[Tag]] = None,
      enableTerminationProtection: Option[Boolean] = None,
      parentId: Option[String] = None,
      rootId: Option[String] = None,
      driftInformation: Option[StackDriftInformation] = None
    ): Stack =
      Stack
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(changeSetId)(_.changeSetId(_))
        .ifSome(description)(_.description(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(deletionTime)(_.deletionTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(stackStatus)(_.stackStatus(_))
        .ifSome(stackStatusReason)(_.stackStatusReason(_))
        .ifSome(disableRollback)(_.disableRollback(_))
        .ifSome(notificationARNs)(_.notificationARNs(_))
        .ifSome(timeoutInMinutes)(_.timeoutInMinutes(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(outputs)(_.outputs(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(enableTerminationProtection)(_.enableTerminationProtection(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(rootId)(_.rootId(_))
        .ifSome(driftInformation)(_.driftInformation(_))
        .build

    def stackDriftInformation(
      stackDriftStatus: Option[String] = None,
      lastCheckTimestamp: Option[Timestamp] = None
    ): StackDriftInformation =
      StackDriftInformation
        .builder
        .ifSome(stackDriftStatus)(_.stackDriftStatus(_))
        .ifSome(lastCheckTimestamp)(_.lastCheckTimestamp(_))
        .build

    def stackDriftInformationSummary(
      stackDriftStatus: Option[String] = None,
      lastCheckTimestamp: Option[Timestamp] = None
    ): StackDriftInformationSummary =
      StackDriftInformationSummary
        .builder
        .ifSome(stackDriftStatus)(_.stackDriftStatus(_))
        .ifSome(lastCheckTimestamp)(_.lastCheckTimestamp(_))
        .build

    def stackEvent(
      stackId: Option[String] = None,
      eventId: Option[String] = None,
      stackName: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      resourceType: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      resourceStatus: Option[String] = None,
      resourceStatusReason: Option[String] = None,
      resourceProperties: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): StackEvent =
      StackEvent
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(eventId)(_.eventId(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(resourceStatus)(_.resourceStatus(_))
        .ifSome(resourceStatusReason)(_.resourceStatusReason(_))
        .ifSome(resourceProperties)(_.resourceProperties(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def stackInstance(
      stackSetId: Option[String] = None,
      region: Option[String] = None,
      account: Option[String] = None,
      stackId: Option[String] = None,
      parameterOverrides: Option[List[Parameter]] = None,
      status: Option[String] = None,
      stackInstanceStatus: Option[StackInstanceComprehensiveStatus] = None,
      statusReason: Option[String] = None,
      organizationalUnitId: Option[String] = None,
      driftStatus: Option[String] = None,
      lastDriftCheckTimestamp: Option[Timestamp] = None
    ): StackInstance =
      StackInstance
        .builder
        .ifSome(stackSetId)(_.stackSetId(_))
        .ifSome(region)(_.region(_))
        .ifSome(account)(_.account(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(parameterOverrides)(_.parameterOverrides(_))
        .ifSome(status)(_.status(_))
        .ifSome(stackInstanceStatus)(_.stackInstanceStatus(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .ifSome(driftStatus)(_.driftStatus(_))
        .ifSome(lastDriftCheckTimestamp)(_.lastDriftCheckTimestamp(_))
        .build

    def stackInstanceComprehensiveStatus(
      detailedStatus: Option[String] = None
    ): StackInstanceComprehensiveStatus =
      StackInstanceComprehensiveStatus
        .builder
        .ifSome(detailedStatus)(_.detailedStatus(_))
        .build

    def stackInstanceFilter(
      name: Option[String] = None,
      values: Option[String] = None
    ): StackInstanceFilter =
      StackInstanceFilter
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(values)(_.values(_))
        .build

    def stackInstanceNotFoundException(

    ): StackInstanceNotFoundException =
      StackInstanceNotFoundException
        .builder

        .build

    def stackInstanceSummary(
      stackSetId: Option[String] = None,
      region: Option[String] = None,
      account: Option[String] = None,
      stackId: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      stackInstanceStatus: Option[StackInstanceComprehensiveStatus] = None,
      organizationalUnitId: Option[String] = None,
      driftStatus: Option[String] = None,
      lastDriftCheckTimestamp: Option[Timestamp] = None
    ): StackInstanceSummary =
      StackInstanceSummary
        .builder
        .ifSome(stackSetId)(_.stackSetId(_))
        .ifSome(region)(_.region(_))
        .ifSome(account)(_.account(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(stackInstanceStatus)(_.stackInstanceStatus(_))
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .ifSome(driftStatus)(_.driftStatus(_))
        .ifSome(lastDriftCheckTimestamp)(_.lastDriftCheckTimestamp(_))
        .build

    def stackResource(
      stackName: Option[String] = None,
      stackId: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      resourceType: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      resourceStatus: Option[String] = None,
      resourceStatusReason: Option[String] = None,
      description: Option[String] = None,
      driftInformation: Option[StackResourceDriftInformation] = None,
      moduleInfo: Option[ModuleInfo] = None
    ): StackResource =
      StackResource
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(resourceStatus)(_.resourceStatus(_))
        .ifSome(resourceStatusReason)(_.resourceStatusReason(_))
        .ifSome(description)(_.description(_))
        .ifSome(driftInformation)(_.driftInformation(_))
        .ifSome(moduleInfo)(_.moduleInfo(_))
        .build

    def stackResourceDetail(
      stackName: Option[String] = None,
      stackId: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      resourceType: Option[String] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None,
      resourceStatus: Option[String] = None,
      resourceStatusReason: Option[String] = None,
      description: Option[String] = None,
      metadata: Option[String] = None,
      driftInformation: Option[StackResourceDriftInformation] = None,
      moduleInfo: Option[ModuleInfo] = None
    ): StackResourceDetail =
      StackResourceDetail
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(stackId)(_.stackId(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(resourceStatus)(_.resourceStatus(_))
        .ifSome(resourceStatusReason)(_.resourceStatusReason(_))
        .ifSome(description)(_.description(_))
        .ifSome(metadata)(_.metadata(_))
        .ifSome(driftInformation)(_.driftInformation(_))
        .ifSome(moduleInfo)(_.moduleInfo(_))
        .build

    def stackResourceDrift(
      stackId: Option[String] = None,
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      physicalResourceIdContext: Option[List[PhysicalResourceIdContextKeyValuePair]] = None,
      resourceType: Option[String] = None,
      expectedProperties: Option[String] = None,
      actualProperties: Option[String] = None,
      propertyDifferences: Option[List[PropertyDifference]] = None,
      stackResourceDriftStatus: Option[String] = None,
      timestamp: Option[Timestamp] = None,
      moduleInfo: Option[ModuleInfo] = None
    ): StackResourceDrift =
      StackResourceDrift
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(physicalResourceIdContext)(_.physicalResourceIdContext(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(expectedProperties)(_.expectedProperties(_))
        .ifSome(actualProperties)(_.actualProperties(_))
        .ifSome(propertyDifferences)(_.propertyDifferences(_))
        .ifSome(stackResourceDriftStatus)(_.stackResourceDriftStatus(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(moduleInfo)(_.moduleInfo(_))
        .build

    def stackResourceDriftInformation(
      stackResourceDriftStatus: Option[String] = None,
      lastCheckTimestamp: Option[Timestamp] = None
    ): StackResourceDriftInformation =
      StackResourceDriftInformation
        .builder
        .ifSome(stackResourceDriftStatus)(_.stackResourceDriftStatus(_))
        .ifSome(lastCheckTimestamp)(_.lastCheckTimestamp(_))
        .build

    def stackResourceDriftInformationSummary(
      stackResourceDriftStatus: Option[String] = None,
      lastCheckTimestamp: Option[Timestamp] = None
    ): StackResourceDriftInformationSummary =
      StackResourceDriftInformationSummary
        .builder
        .ifSome(stackResourceDriftStatus)(_.stackResourceDriftStatus(_))
        .ifSome(lastCheckTimestamp)(_.lastCheckTimestamp(_))
        .build

    def stackResourceSummary(
      logicalResourceId: Option[String] = None,
      physicalResourceId: Option[String] = None,
      resourceType: Option[String] = None,
      lastUpdatedTimestamp: Option[Timestamp] = None,
      resourceStatus: Option[String] = None,
      resourceStatusReason: Option[String] = None,
      driftInformation: Option[StackResourceDriftInformationSummary] = None,
      moduleInfo: Option[ModuleInfo] = None
    ): StackResourceSummary =
      StackResourceSummary
        .builder
        .ifSome(logicalResourceId)(_.logicalResourceId(_))
        .ifSome(physicalResourceId)(_.physicalResourceId(_))
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(lastUpdatedTimestamp)(_.lastUpdatedTimestamp(_))
        .ifSome(resourceStatus)(_.resourceStatus(_))
        .ifSome(resourceStatusReason)(_.resourceStatusReason(_))
        .ifSome(driftInformation)(_.driftInformation(_))
        .ifSome(moduleInfo)(_.moduleInfo(_))
        .build

    def stackSet(
      stackSetName: Option[String] = None,
      stackSetId: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      templateBody: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      capabilities: Option[List[Capability]] = None,
      tags: Option[List[Tag]] = None,
      stackSetARN: Option[String] = None,
      administrationRoleARN: Option[String] = None,
      executionRoleName: Option[String] = None,
      stackSetDriftDetectionDetails: Option[StackSetDriftDetectionDetails] = None,
      autoDeployment: Option[AutoDeployment] = None,
      permissionModel: Option[String] = None,
      organizationalUnitIds: Option[List[OrganizationalUnitId]] = None
    ): StackSet =
      StackSet
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(stackSetId)(_.stackSetId(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(stackSetARN)(_.stackSetARN(_))
        .ifSome(administrationRoleARN)(_.administrationRoleARN(_))
        .ifSome(executionRoleName)(_.executionRoleName(_))
        .ifSome(stackSetDriftDetectionDetails)(_.stackSetDriftDetectionDetails(_))
        .ifSome(autoDeployment)(_.autoDeployment(_))
        .ifSome(permissionModel)(_.permissionModel(_))
        .ifSome(organizationalUnitIds)(_.organizationalUnitIds(_))
        .build

    def stackSetDriftDetectionDetails(
      driftStatus: Option[String] = None,
      driftDetectionStatus: Option[String] = None,
      lastDriftCheckTimestamp: Option[Timestamp] = None,
      totalStackInstancesCount: Option[Int] = None,
      driftedStackInstancesCount: Option[Int] = None,
      inSyncStackInstancesCount: Option[Int] = None,
      inProgressStackInstancesCount: Option[Int] = None,
      failedStackInstancesCount: Option[Int] = None
    ): StackSetDriftDetectionDetails =
      StackSetDriftDetectionDetails
        .builder
        .ifSome(driftStatus)(_.driftStatus(_))
        .ifSome(driftDetectionStatus)(_.driftDetectionStatus(_))
        .ifSome(lastDriftCheckTimestamp)(_.lastDriftCheckTimestamp(_))
        .ifSome(totalStackInstancesCount)(_.totalStackInstancesCount(_))
        .ifSome(driftedStackInstancesCount)(_.driftedStackInstancesCount(_))
        .ifSome(inSyncStackInstancesCount)(_.inSyncStackInstancesCount(_))
        .ifSome(inProgressStackInstancesCount)(_.inProgressStackInstancesCount(_))
        .ifSome(failedStackInstancesCount)(_.failedStackInstancesCount(_))
        .build

    def stackSetNotEmptyException(

    ): StackSetNotEmptyException =
      StackSetNotEmptyException
        .builder

        .build

    def stackSetNotFoundException(

    ): StackSetNotFoundException =
      StackSetNotFoundException
        .builder

        .build

    def stackSetOperation(
      operationId: Option[String] = None,
      stackSetId: Option[String] = None,
      action: Option[String] = None,
      status: Option[String] = None,
      operationPreferences: Option[StackSetOperationPreferences] = None,
      retainStacks: Option[Boolean] = None,
      administrationRoleARN: Option[String] = None,
      executionRoleName: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      endTimestamp: Option[Timestamp] = None,
      deploymentTargets: Option[DeploymentTargets] = None,
      stackSetDriftDetectionDetails: Option[StackSetDriftDetectionDetails] = None
    ): StackSetOperation =
      StackSetOperation
        .builder
        .ifSome(operationId)(_.operationId(_))
        .ifSome(stackSetId)(_.stackSetId(_))
        .ifSome(action)(_.action(_))
        .ifSome(status)(_.status(_))
        .ifSome(operationPreferences)(_.operationPreferences(_))
        .ifSome(retainStacks)(_.retainStacks(_))
        .ifSome(administrationRoleARN)(_.administrationRoleARN(_))
        .ifSome(executionRoleName)(_.executionRoleName(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(endTimestamp)(_.endTimestamp(_))
        .ifSome(deploymentTargets)(_.deploymentTargets(_))
        .ifSome(stackSetDriftDetectionDetails)(_.stackSetDriftDetectionDetails(_))
        .build

    def stackSetOperationPreferences(
      regionConcurrencyType: Option[String] = None,
      regionOrder: Option[List[Region]] = None,
      failureToleranceCount: Option[Int] = None,
      failureTolerancePercentage: Option[Int] = None,
      maxConcurrentCount: Option[Int] = None,
      maxConcurrentPercentage: Option[Int] = None
    ): StackSetOperationPreferences =
      StackSetOperationPreferences
        .builder
        .ifSome(regionConcurrencyType)(_.regionConcurrencyType(_))
        .ifSome(regionOrder)(_.regionOrder(_))
        .ifSome(failureToleranceCount)(_.failureToleranceCount(_))
        .ifSome(failureTolerancePercentage)(_.failureTolerancePercentage(_))
        .ifSome(maxConcurrentCount)(_.maxConcurrentCount(_))
        .ifSome(maxConcurrentPercentage)(_.maxConcurrentPercentage(_))
        .build

    def stackSetOperationResultSummary(
      account: Option[String] = None,
      region: Option[String] = None,
      status: Option[String] = None,
      statusReason: Option[String] = None,
      accountGateResult: Option[AccountGateResult] = None,
      organizationalUnitId: Option[String] = None
    ): StackSetOperationResultSummary =
      StackSetOperationResultSummary
        .builder
        .ifSome(account)(_.account(_))
        .ifSome(region)(_.region(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(accountGateResult)(_.accountGateResult(_))
        .ifSome(organizationalUnitId)(_.organizationalUnitId(_))
        .build

    def stackSetOperationSummary(
      operationId: Option[String] = None,
      action: Option[String] = None,
      status: Option[String] = None,
      creationTimestamp: Option[Timestamp] = None,
      endTimestamp: Option[Timestamp] = None
    ): StackSetOperationSummary =
      StackSetOperationSummary
        .builder
        .ifSome(operationId)(_.operationId(_))
        .ifSome(action)(_.action(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationTimestamp)(_.creationTimestamp(_))
        .ifSome(endTimestamp)(_.endTimestamp(_))
        .build

    def stackSetSummary(
      stackSetName: Option[String] = None,
      stackSetId: Option[String] = None,
      description: Option[String] = None,
      status: Option[String] = None,
      autoDeployment: Option[AutoDeployment] = None,
      permissionModel: Option[String] = None,
      driftStatus: Option[String] = None,
      lastDriftCheckTimestamp: Option[Timestamp] = None
    ): StackSetSummary =
      StackSetSummary
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(stackSetId)(_.stackSetId(_))
        .ifSome(description)(_.description(_))
        .ifSome(status)(_.status(_))
        .ifSome(autoDeployment)(_.autoDeployment(_))
        .ifSome(permissionModel)(_.permissionModel(_))
        .ifSome(driftStatus)(_.driftStatus(_))
        .ifSome(lastDriftCheckTimestamp)(_.lastDriftCheckTimestamp(_))
        .build

    def stackSummary(
      stackId: Option[String] = None,
      stackName: Option[String] = None,
      templateDescription: Option[String] = None,
      creationTime: Option[CreationTime] = None,
      lastUpdatedTime: Option[LastUpdatedTime] = None,
      deletionTime: Option[DeletionTime] = None,
      stackStatus: Option[String] = None,
      stackStatusReason: Option[String] = None,
      parentId: Option[String] = None,
      rootId: Option[String] = None,
      driftInformation: Option[StackDriftInformationSummary] = None
    ): StackSummary =
      StackSummary
        .builder
        .ifSome(stackId)(_.stackId(_))
        .ifSome(stackName)(_.stackName(_))
        .ifSome(templateDescription)(_.templateDescription(_))
        .ifSome(creationTime)(_.creationTime(_))
        .ifSome(lastUpdatedTime)(_.lastUpdatedTime(_))
        .ifSome(deletionTime)(_.deletionTime(_))
        .ifSome(stackStatus)(_.stackStatus(_))
        .ifSome(stackStatusReason)(_.stackStatusReason(_))
        .ifSome(parentId)(_.parentId(_))
        .ifSome(rootId)(_.rootId(_))
        .ifSome(driftInformation)(_.driftInformation(_))
        .build

    def staleRequestException(

    ): StaleRequestException =
      StaleRequestException
        .builder

        .build

    def stopStackSetOperationInput(
      stackSetName: Option[String] = None,
      operationId: Option[String] = None,
      callAs: Option[String] = None
    ): StopStackSetOperationInput =
      StopStackSetOperationInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def stopStackSetOperationOutput(

    ): StopStackSetOperationOutput =
      StopStackSetOperationOutput
        .builder

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

    def templateParameter(
      parameterKey: Option[String] = None,
      defaultValue: Option[String] = None,
      noEcho: Option[Boolean] = None,
      description: Option[String] = None
    ): TemplateParameter =
      TemplateParameter
        .builder
        .ifSome(parameterKey)(_.parameterKey(_))
        .ifSome(defaultValue)(_.defaultValue(_))
        .ifSome(noEcho)(_.noEcho(_))
        .ifSome(description)(_.description(_))
        .build

    def tokenAlreadyExistsException(

    ): TokenAlreadyExistsException =
      TokenAlreadyExistsException
        .builder

        .build

    def typeNotFoundException(

    ): TypeNotFoundException =
      TypeNotFoundException
        .builder

        .build

    def typeSummary(
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      defaultVersionId: Option[String] = None,
      typeArn: Option[String] = None,
      lastUpdated: Option[Timestamp] = None,
      description: Option[String] = None
    ): TypeSummary =
      TypeSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(typeArn)(_.typeArn(_))
        .ifSome(lastUpdated)(_.lastUpdated(_))
        .ifSome(description)(_.description(_))
        .build

    def typeVersionSummary(
      `type`: Option[String] = None,
      typeName: Option[String] = None,
      versionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None,
      arn: Option[String] = None,
      timeCreated: Option[Timestamp] = None,
      description: Option[String] = None
    ): TypeVersionSummary =
      TypeVersionSummary
        .builder
        .ifSome(`type`)(_.`type`(_))
        .ifSome(typeName)(_.typeName(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(timeCreated)(_.timeCreated(_))
        .ifSome(description)(_.description(_))
        .build

    def updateStackInput(
      stackName: Option[String] = None,
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      usePreviousTemplate: Option[Boolean] = None,
      stackPolicyDuringUpdateBody: Option[String] = None,
      stackPolicyDuringUpdateURL: Option[String] = None,
      parameters: Option[List[Parameter]] = None,
      capabilities: Option[List[Capability]] = None,
      resourceTypes: Option[List[ResourceType]] = None,
      roleARN: Option[String] = None,
      rollbackConfiguration: Option[RollbackConfiguration] = None,
      stackPolicyBody: Option[String] = None,
      stackPolicyURL: Option[String] = None,
      notificationARNs: Option[List[NotificationARN]] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): UpdateStackInput =
      UpdateStackInput
        .builder
        .ifSome(stackName)(_.stackName(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(usePreviousTemplate)(_.usePreviousTemplate(_))
        .ifSome(stackPolicyDuringUpdateBody)(_.stackPolicyDuringUpdateBody(_))
        .ifSome(stackPolicyDuringUpdateURL)(_.stackPolicyDuringUpdateURL(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(resourceTypes)(_.resourceTypes(_))
        .ifSome(roleARN)(_.roleARN(_))
        .ifSome(rollbackConfiguration)(_.rollbackConfiguration(_))
        .ifSome(stackPolicyBody)(_.stackPolicyBody(_))
        .ifSome(stackPolicyURL)(_.stackPolicyURL(_))
        .ifSome(notificationARNs)(_.notificationARNs(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def updateStackInstancesInput(
      stackSetName: Option[String] = None,
      accounts: Option[List[Account]] = None,
      deploymentTargets: Option[DeploymentTargets] = None,
      regions: Option[List[Region]] = None,
      parameterOverrides: Option[List[Parameter]] = None,
      operationPreferences: Option[StackSetOperationPreferences] = None,
      operationId: Option[String] = None,
      callAs: Option[String] = None
    ): UpdateStackInstancesInput =
      UpdateStackInstancesInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(accounts)(_.accounts(_))
        .ifSome(deploymentTargets)(_.deploymentTargets(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(parameterOverrides)(_.parameterOverrides(_))
        .ifSome(operationPreferences)(_.operationPreferences(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def updateStackInstancesOutput(
      operationId: Option[String] = None
    ): UpdateStackInstancesOutput =
      UpdateStackInstancesOutput
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def updateStackOutput(
      stackId: Option[String] = None
    ): UpdateStackOutput =
      UpdateStackOutput
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def updateStackSetInput(
      stackSetName: Option[String] = None,
      description: Option[String] = None,
      templateBody: Option[String] = None,
      templateURL: Option[String] = None,
      usePreviousTemplate: Option[Boolean] = None,
      parameters: Option[List[Parameter]] = None,
      capabilities: Option[List[Capability]] = None,
      tags: Option[List[Tag]] = None,
      operationPreferences: Option[StackSetOperationPreferences] = None,
      administrationRoleARN: Option[String] = None,
      executionRoleName: Option[String] = None,
      deploymentTargets: Option[DeploymentTargets] = None,
      permissionModel: Option[String] = None,
      autoDeployment: Option[AutoDeployment] = None,
      operationId: Option[String] = None,
      accounts: Option[List[Account]] = None,
      regions: Option[List[Region]] = None,
      callAs: Option[String] = None
    ): UpdateStackSetInput =
      UpdateStackSetInput
        .builder
        .ifSome(stackSetName)(_.stackSetName(_))
        .ifSome(description)(_.description(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .ifSome(usePreviousTemplate)(_.usePreviousTemplate(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(operationPreferences)(_.operationPreferences(_))
        .ifSome(administrationRoleARN)(_.administrationRoleARN(_))
        .ifSome(executionRoleName)(_.executionRoleName(_))
        .ifSome(deploymentTargets)(_.deploymentTargets(_))
        .ifSome(permissionModel)(_.permissionModel(_))
        .ifSome(autoDeployment)(_.autoDeployment(_))
        .ifSome(operationId)(_.operationId(_))
        .ifSome(accounts)(_.accounts(_))
        .ifSome(regions)(_.regions(_))
        .ifSome(callAs)(_.callAs(_))
        .build

    def updateStackSetOutput(
      operationId: Option[String] = None
    ): UpdateStackSetOutput =
      UpdateStackSetOutput
        .builder
        .ifSome(operationId)(_.operationId(_))
        .build

    def updateTerminationProtectionInput(
      enableTerminationProtection: Option[Boolean] = None,
      stackName: Option[String] = None
    ): UpdateTerminationProtectionInput =
      UpdateTerminationProtectionInput
        .builder
        .ifSome(enableTerminationProtection)(_.enableTerminationProtection(_))
        .ifSome(stackName)(_.stackName(_))
        .build

    def updateTerminationProtectionOutput(
      stackId: Option[String] = None
    ): UpdateTerminationProtectionOutput =
      UpdateTerminationProtectionOutput
        .builder
        .ifSome(stackId)(_.stackId(_))
        .build

    def validateTemplateInput(
      templateBody: Option[String] = None,
      templateURL: Option[String] = None
    ): ValidateTemplateInput =
      ValidateTemplateInput
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(templateURL)(_.templateURL(_))
        .build

    def validateTemplateOutput(
      parameters: Option[List[TemplateParameter]] = None,
      description: Option[String] = None,
      capabilities: Option[List[Capability]] = None,
      capabilitiesReason: Option[String] = None,
      declaredTransforms: Option[List[TransformName]] = None
    ): ValidateTemplateOutput =
      ValidateTemplateOutput
        .builder
        .ifSome(parameters)(_.parameters(_))
        .ifSome(description)(_.description(_))
        .ifSome(capabilities)(_.capabilities(_))
        .ifSome(capabilitiesReason)(_.capabilitiesReason(_))
        .ifSome(declaredTransforms)(_.declaredTransforms(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
