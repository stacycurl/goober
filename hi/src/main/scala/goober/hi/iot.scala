package goober.hi

import goober.free.iot.IotIO
import software.amazon.awssdk.services.iot.model._


object iot {
  import goober.free.{iot ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def abortConfig(
      criteriaList: Option[List[AbortCriteria]] = None
    ): AbortConfig =
      AbortConfig
        .builder
        .ifSome(criteriaList)(_.criteriaList(_))
        .build

    def abortCriteria(
      failureType: Option[String] = None,
      action: Option[String] = None,
      thresholdPercentage: Option[AbortThresholdPercentage] = None,
      minNumberOfExecutedThings: Option[Int] = None
    ): AbortCriteria =
      AbortCriteria
        .builder
        .ifSome(failureType)(_.failureType(_))
        .ifSome(action)(_.action(_))
        .ifSome(thresholdPercentage)(_.thresholdPercentage(_))
        .ifSome(minNumberOfExecutedThings)(_.minNumberOfExecutedThings(_))
        .build

    def acceptCertificateTransferRequest(
      certificateId: Option[String] = None,
      setAsActive: Option[Boolean] = None
    ): AcceptCertificateTransferRequest =
      AcceptCertificateTransferRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(setAsActive)(_.setAsActive(_))
        .build

    def action(
      dynamoDB: Option[DynamoDBAction] = None,
      dynamoDBv2: Option[DynamoDBv2Action] = None,
      lambda: Option[LambdaAction] = None,
      sns: Option[SnsAction] = None,
      sqs: Option[SqsAction] = None,
      kinesis: Option[KinesisAction] = None,
      republish: Option[RepublishAction] = None,
      s3: Option[S3Action] = None,
      firehose: Option[FirehoseAction] = None,
      cloudwatchMetric: Option[CloudwatchMetricAction] = None,
      cloudwatchAlarm: Option[CloudwatchAlarmAction] = None,
      cloudwatchLogs: Option[CloudwatchLogsAction] = None,
      elasticsearch: Option[ElasticsearchAction] = None,
      salesforce: Option[SalesforceAction] = None,
      iotAnalytics: Option[IotAnalyticsAction] = None,
      iotEvents: Option[IotEventsAction] = None,
      iotSiteWise: Option[IotSiteWiseAction] = None,
      stepFunctions: Option[StepFunctionsAction] = None,
      timestream: Option[TimestreamAction] = None,
      http: Option[HttpAction] = None,
      kafka: Option[KafkaAction] = None
    ): Action =
      Action
        .builder
        .ifSome(dynamoDB)(_.dynamoDB(_))
        .ifSome(dynamoDBv2)(_.dynamoDBv2(_))
        .ifSome(lambda)(_.lambda(_))
        .ifSome(sns)(_.sns(_))
        .ifSome(sqs)(_.sqs(_))
        .ifSome(kinesis)(_.kinesis(_))
        .ifSome(republish)(_.republish(_))
        .ifSome(s3)(_.s3(_))
        .ifSome(firehose)(_.firehose(_))
        .ifSome(cloudwatchMetric)(_.cloudwatchMetric(_))
        .ifSome(cloudwatchAlarm)(_.cloudwatchAlarm(_))
        .ifSome(cloudwatchLogs)(_.cloudwatchLogs(_))
        .ifSome(elasticsearch)(_.elasticsearch(_))
        .ifSome(salesforce)(_.salesforce(_))
        .ifSome(iotAnalytics)(_.iotAnalytics(_))
        .ifSome(iotEvents)(_.iotEvents(_))
        .ifSome(iotSiteWise)(_.iotSiteWise(_))
        .ifSome(stepFunctions)(_.stepFunctions(_))
        .ifSome(timestream)(_.timestream(_))
        .ifSome(http)(_.http(_))
        .ifSome(kafka)(_.kafka(_))
        .build

    def activeViolation(
      violationId: Option[String] = None,
      thingName: Option[String] = None,
      securityProfileName: Option[String] = None,
      behavior: Option[Behavior] = None,
      lastViolationValue: Option[MetricValue] = None,
      violationEventAdditionalInfo: Option[ViolationEventAdditionalInfo] = None,
      lastViolationTime: Option[Timestamp] = None,
      violationStartTime: Option[Timestamp] = None
    ): ActiveViolation =
      ActiveViolation
        .builder
        .ifSome(violationId)(_.violationId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(behavior)(_.behavior(_))
        .ifSome(lastViolationValue)(_.lastViolationValue(_))
        .ifSome(violationEventAdditionalInfo)(_.violationEventAdditionalInfo(_))
        .ifSome(lastViolationTime)(_.lastViolationTime(_))
        .ifSome(violationStartTime)(_.violationStartTime(_))
        .build

    def addThingToBillingGroupRequest(
      billingGroupName: Option[String] = None,
      billingGroupArn: Option[String] = None,
      thingName: Option[String] = None,
      thingArn: Option[String] = None
    ): AddThingToBillingGroupRequest =
      AddThingToBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(billingGroupArn)(_.billingGroupArn(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def addThingToBillingGroupResponse(

    ): AddThingToBillingGroupResponse =
      AddThingToBillingGroupResponse
        .builder

        .build

    def addThingToThingGroupRequest(
      thingGroupName: Option[String] = None,
      thingGroupArn: Option[String] = None,
      thingName: Option[String] = None,
      thingArn: Option[String] = None,
      overrideDynamicGroups: Option[Boolean] = None
    ): AddThingToThingGroupRequest =
      AddThingToThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupArn)(_.thingGroupArn(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(overrideDynamicGroups)(_.overrideDynamicGroups(_))
        .build

    def addThingToThingGroupResponse(

    ): AddThingToThingGroupResponse =
      AddThingToThingGroupResponse
        .builder

        .build

    def addThingsToThingGroupParams(
      thingGroupNames: Option[List[ThingGroupName]] = None,
      overrideDynamicGroups: Option[Boolean] = None
    ): AddThingsToThingGroupParams =
      AddThingsToThingGroupParams
        .builder
        .ifSome(thingGroupNames)(_.thingGroupNames(_))
        .ifSome(overrideDynamicGroups)(_.overrideDynamicGroups(_))
        .build

    def alertTarget(
      alertTargetArn: Option[String] = None,
      roleArn: Option[String] = None
    ): AlertTarget =
      AlertTarget
        .builder
        .ifSome(alertTargetArn)(_.alertTargetArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def allowed(
      policies: Option[List[Policy]] = None
    ): Allowed =
      Allowed
        .builder
        .ifSome(policies)(_.policies(_))
        .build

    def assetPropertyTimestamp(
      timeInSeconds: Option[String] = None,
      offsetInNanos: Option[String] = None
    ): AssetPropertyTimestamp =
      AssetPropertyTimestamp
        .builder
        .ifSome(timeInSeconds)(_.timeInSeconds(_))
        .ifSome(offsetInNanos)(_.offsetInNanos(_))
        .build

    def assetPropertyValue(
      value: Option[AssetPropertyVariant] = None,
      timestamp: Option[AssetPropertyTimestamp] = None,
      quality: Option[String] = None
    ): AssetPropertyValue =
      AssetPropertyValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(timestamp)(_.timestamp(_))
        .ifSome(quality)(_.quality(_))
        .build

    def assetPropertyVariant(
      stringValue: Option[String] = None,
      integerValue: Option[String] = None,
      doubleValue: Option[String] = None,
      booleanValue: Option[String] = None
    ): AssetPropertyVariant =
      AssetPropertyVariant
        .builder
        .ifSome(stringValue)(_.stringValue(_))
        .ifSome(integerValue)(_.integerValue(_))
        .ifSome(doubleValue)(_.doubleValue(_))
        .ifSome(booleanValue)(_.booleanValue(_))
        .build

    def associateTargetsWithJobRequest(
      targets: Option[List[TargetArn]] = None,
      jobId: Option[String] = None,
      comment: Option[String] = None,
      namespaceId: Option[String] = None
    ): AssociateTargetsWithJobRequest =
      AssociateTargetsWithJobRequest
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .build

    def associateTargetsWithJobResponse(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      description: Option[String] = None
    ): AssociateTargetsWithJobResponse =
      AssociateTargetsWithJobResponse
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(description)(_.description(_))
        .build

    def attachPolicyRequest(
      policyName: Option[String] = None,
      target: Option[String] = None
    ): AttachPolicyRequest =
      AttachPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(target)(_.target(_))
        .build

    def attachPrincipalPolicyRequest(
      policyName: Option[String] = None,
      principal: Option[String] = None
    ): AttachPrincipalPolicyRequest =
      AttachPrincipalPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(principal)(_.principal(_))
        .build

    def attachSecurityProfileRequest(
      securityProfileName: Option[String] = None,
      securityProfileTargetArn: Option[String] = None
    ): AttachSecurityProfileRequest =
      AttachSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileTargetArn)(_.securityProfileTargetArn(_))
        .build

    def attachSecurityProfileResponse(

    ): AttachSecurityProfileResponse =
      AttachSecurityProfileResponse
        .builder

        .build

    def attachThingPrincipalRequest(
      thingName: Option[String] = None,
      principal: Option[String] = None
    ): AttachThingPrincipalRequest =
      AttachThingPrincipalRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(principal)(_.principal(_))
        .build

    def attachThingPrincipalResponse(

    ): AttachThingPrincipalResponse =
      AttachThingPrincipalResponse
        .builder

        .build

    def attributePayload(
      attributes: Option[Attributes] = None,
      merge: Option[Boolean] = None
    ): AttributePayload =
      AttributePayload
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(merge)(_.merge(_))
        .build

    def auditCheckConfiguration(
      enabled: Option[Boolean] = None
    ): AuditCheckConfiguration =
      AuditCheckConfiguration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def auditCheckDetails(
      checkRunStatus: Option[String] = None,
      checkCompliant: Option[Boolean] = None,
      totalResourcesCount: Option[TotalResourcesCount] = None,
      nonCompliantResourcesCount: Option[NonCompliantResourcesCount] = None,
      suppressedNonCompliantResourcesCount: Option[SuppressedNonCompliantResourcesCount] = None,
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): AuditCheckDetails =
      AuditCheckDetails
        .builder
        .ifSome(checkRunStatus)(_.checkRunStatus(_))
        .ifSome(checkCompliant)(_.checkCompliant(_))
        .ifSome(totalResourcesCount)(_.totalResourcesCount(_))
        .ifSome(nonCompliantResourcesCount)(_.nonCompliantResourcesCount(_))
        .ifSome(suppressedNonCompliantResourcesCount)(_.suppressedNonCompliantResourcesCount(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def auditFinding(
      findingId: Option[String] = None,
      taskId: Option[String] = None,
      checkName: Option[String] = None,
      taskStartTime: Option[Timestamp] = None,
      findingTime: Option[Timestamp] = None,
      severity: Option[String] = None,
      nonCompliantResource: Option[NonCompliantResource] = None,
      relatedResources: Option[List[RelatedResource]] = None,
      reasonForNonCompliance: Option[String] = None,
      reasonForNonComplianceCode: Option[String] = None,
      isSuppressed: Option[Boolean] = None
    ): AuditFinding =
      AuditFinding
        .builder
        .ifSome(findingId)(_.findingId(_))
        .ifSome(taskId)(_.taskId(_))
        .ifSome(checkName)(_.checkName(_))
        .ifSome(taskStartTime)(_.taskStartTime(_))
        .ifSome(findingTime)(_.findingTime(_))
        .ifSome(severity)(_.severity(_))
        .ifSome(nonCompliantResource)(_.nonCompliantResource(_))
        .ifSome(relatedResources)(_.relatedResources(_))
        .ifSome(reasonForNonCompliance)(_.reasonForNonCompliance(_))
        .ifSome(reasonForNonComplianceCode)(_.reasonForNonComplianceCode(_))
        .ifSome(isSuppressed)(_.isSuppressed(_))
        .build

    def auditMitigationActionExecutionMetadata(
      taskId: Option[String] = None,
      findingId: Option[String] = None,
      actionName: Option[String] = None,
      actionId: Option[String] = None,
      status: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): AuditMitigationActionExecutionMetadata =
      AuditMitigationActionExecutionMetadata
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(findingId)(_.findingId(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionId)(_.actionId(_))
        .ifSome(status)(_.status(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def auditMitigationActionsTaskMetadata(
      taskId: Option[String] = None,
      startTime: Option[Timestamp] = None,
      taskStatus: Option[String] = None
    ): AuditMitigationActionsTaskMetadata =
      AuditMitigationActionsTaskMetadata
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .build

    def auditMitigationActionsTaskTarget(
      auditTaskId: Option[String] = None,
      findingIds: Option[List[FindingId]] = None,
      auditCheckToReasonCodeFilter: Option[AuditCheckToReasonCodeFilter] = None
    ): AuditMitigationActionsTaskTarget =
      AuditMitigationActionsTaskTarget
        .builder
        .ifSome(auditTaskId)(_.auditTaskId(_))
        .ifSome(findingIds)(_.findingIds(_))
        .ifSome(auditCheckToReasonCodeFilter)(_.auditCheckToReasonCodeFilter(_))
        .build

    def auditNotificationTarget(
      targetArn: Option[String] = None,
      roleArn: Option[String] = None,
      enabled: Option[Boolean] = None
    ): AuditNotificationTarget =
      AuditNotificationTarget
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def auditSuppression(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      expirationDate: Option[Timestamp] = None,
      suppressIndefinitely: Option[Boolean] = None,
      description: Option[String] = None
    ): AuditSuppression =
      AuditSuppression
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(suppressIndefinitely)(_.suppressIndefinitely(_))
        .ifSome(description)(_.description(_))
        .build

    def auditTaskMetadata(
      taskId: Option[String] = None,
      taskStatus: Option[String] = None,
      taskType: Option[String] = None
    ): AuditTaskMetadata =
      AuditTaskMetadata
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(taskType)(_.taskType(_))
        .build

    def authInfo(
      actionType: Option[String] = None,
      resources: Option[List[Resource]] = None
    ): AuthInfo =
      AuthInfo
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(resources)(_.resources(_))
        .build

    def authorizerConfig(
      defaultAuthorizerName: Option[String] = None,
      allowAuthorizerOverride: Option[Boolean] = None
    ): AuthorizerConfig =
      AuthorizerConfig
        .builder
        .ifSome(defaultAuthorizerName)(_.defaultAuthorizerName(_))
        .ifSome(allowAuthorizerOverride)(_.allowAuthorizerOverride(_))
        .build

    def authorizerDescription(
      authorizerName: Option[String] = None,
      authorizerArn: Option[String] = None,
      authorizerFunctionArn: Option[String] = None,
      tokenKeyName: Option[String] = None,
      tokenSigningPublicKeys: Option[PublicKeyMap] = None,
      status: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      signingDisabled: Option[Boolean] = None
    ): AuthorizerDescription =
      AuthorizerDescription
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerArn)(_.authorizerArn(_))
        .ifSome(authorizerFunctionArn)(_.authorizerFunctionArn(_))
        .ifSome(tokenKeyName)(_.tokenKeyName(_))
        .ifSome(tokenSigningPublicKeys)(_.tokenSigningPublicKeys(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(signingDisabled)(_.signingDisabled(_))
        .build

    def authorizerSummary(
      authorizerName: Option[String] = None,
      authorizerArn: Option[String] = None
    ): AuthorizerSummary =
      AuthorizerSummary
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerArn)(_.authorizerArn(_))
        .build

    def awsJobAbortConfig(
      abortCriteriaList: Option[List[AwsJobAbortCriteria]] = None
    ): AwsJobAbortConfig =
      AwsJobAbortConfig
        .builder
        .ifSome(abortCriteriaList)(_.abortCriteriaList(_))
        .build

    def awsJobAbortCriteria(
      failureType: Option[String] = None,
      action: Option[String] = None,
      thresholdPercentage: Option[AwsJobAbortCriteriaAbortThresholdPercentage] = None,
      minNumberOfExecutedThings: Option[Int] = None
    ): AwsJobAbortCriteria =
      AwsJobAbortCriteria
        .builder
        .ifSome(failureType)(_.failureType(_))
        .ifSome(action)(_.action(_))
        .ifSome(thresholdPercentage)(_.thresholdPercentage(_))
        .ifSome(minNumberOfExecutedThings)(_.minNumberOfExecutedThings(_))
        .build

    def awsJobExecutionsRolloutConfig(
      maximumPerMinute: Option[Int] = None,
      exponentialRate: Option[AwsJobExponentialRolloutRate] = None
    ): AwsJobExecutionsRolloutConfig =
      AwsJobExecutionsRolloutConfig
        .builder
        .ifSome(maximumPerMinute)(_.maximumPerMinute(_))
        .ifSome(exponentialRate)(_.exponentialRate(_))
        .build

    def awsJobExponentialRolloutRate(
      baseRatePerMinute: Option[Int] = None,
      incrementFactor: Option[AwsJobRolloutIncrementFactor] = None,
      rateIncreaseCriteria: Option[AwsJobRateIncreaseCriteria] = None
    ): AwsJobExponentialRolloutRate =
      AwsJobExponentialRolloutRate
        .builder
        .ifSome(baseRatePerMinute)(_.baseRatePerMinute(_))
        .ifSome(incrementFactor)(_.incrementFactor(_))
        .ifSome(rateIncreaseCriteria)(_.rateIncreaseCriteria(_))
        .build

    def awsJobPresignedUrlConfig(
      expiresInSec: Option[ExpiresInSeconds] = None
    ): AwsJobPresignedUrlConfig =
      AwsJobPresignedUrlConfig
        .builder
        .ifSome(expiresInSec)(_.expiresInSec(_))
        .build

    def awsJobRateIncreaseCriteria(
      numberOfNotifiedThings: Option[Int] = None,
      numberOfSucceededThings: Option[Int] = None
    ): AwsJobRateIncreaseCriteria =
      AwsJobRateIncreaseCriteria
        .builder
        .ifSome(numberOfNotifiedThings)(_.numberOfNotifiedThings(_))
        .ifSome(numberOfSucceededThings)(_.numberOfSucceededThings(_))
        .build

    def awsJobTimeoutConfig(
      inProgressTimeoutInMinutes: Option[AwsJobTimeoutInProgressTimeoutInMinutes] = None
    ): AwsJobTimeoutConfig =
      AwsJobTimeoutConfig
        .builder
        .ifSome(inProgressTimeoutInMinutes)(_.inProgressTimeoutInMinutes(_))
        .build

    def behavior(
      name: Option[String] = None,
      metric: Option[String] = None,
      metricDimension: Option[MetricDimension] = None,
      criteria: Option[BehaviorCriteria] = None,
      suppressAlerts: Option[Boolean] = None
    ): Behavior =
      Behavior
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(metric)(_.metric(_))
        .ifSome(metricDimension)(_.metricDimension(_))
        .ifSome(criteria)(_.criteria(_))
        .ifSome(suppressAlerts)(_.suppressAlerts(_))
        .build

    def behaviorCriteria(
      comparisonOperator: Option[String] = None,
      value: Option[MetricValue] = None,
      durationSeconds: Option[Int] = None,
      consecutiveDatapointsToAlarm: Option[Int] = None,
      consecutiveDatapointsToClear: Option[Int] = None,
      statisticalThreshold: Option[StatisticalThreshold] = None,
      mlDetectionConfig: Option[MachineLearningDetectionConfig] = None
    ): BehaviorCriteria =
      BehaviorCriteria
        .builder
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(value)(_.value(_))
        .ifSome(durationSeconds)(_.durationSeconds(_))
        .ifSome(consecutiveDatapointsToAlarm)(_.consecutiveDatapointsToAlarm(_))
        .ifSome(consecutiveDatapointsToClear)(_.consecutiveDatapointsToClear(_))
        .ifSome(statisticalThreshold)(_.statisticalThreshold(_))
        .ifSome(mlDetectionConfig)(_.mlDetectionConfig(_))
        .build

    def behaviorModelTrainingSummary(
      securityProfileName: Option[String] = None,
      behaviorName: Option[String] = None,
      trainingDataCollectionStartDate: Option[Timestamp] = None,
      modelStatus: Option[String] = None,
      datapointsCollectionPercentage: Option[DataCollectionPercentage] = None,
      lastModelRefreshDate: Option[Timestamp] = None
    ): BehaviorModelTrainingSummary =
      BehaviorModelTrainingSummary
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(behaviorName)(_.behaviorName(_))
        .ifSome(trainingDataCollectionStartDate)(_.trainingDataCollectionStartDate(_))
        .ifSome(modelStatus)(_.modelStatus(_))
        .ifSome(datapointsCollectionPercentage)(_.datapointsCollectionPercentage(_))
        .ifSome(lastModelRefreshDate)(_.lastModelRefreshDate(_))
        .build

    def billingGroupMetadata(
      creationDate: Option[CreationDate] = None
    ): BillingGroupMetadata =
      BillingGroupMetadata
        .builder
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def billingGroupProperties(
      billingGroupDescription: Option[String] = None
    ): BillingGroupProperties =
      BillingGroupProperties
        .builder
        .ifSome(billingGroupDescription)(_.billingGroupDescription(_))
        .build

    def cACertificate(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      status: Option[String] = None,
      creationDate: Option[DateType] = None
    ): CACertificate =
      CACertificate
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(status)(_.status(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def cACertificateDescription(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      status: Option[String] = None,
      certificatePem: Option[String] = None,
      ownedBy: Option[String] = None,
      creationDate: Option[DateType] = None,
      autoRegistrationStatus: Option[String] = None,
      lastModifiedDate: Option[DateType] = None,
      customerVersion: Option[Int] = None,
      generationId: Option[String] = None,
      validity: Option[CertificateValidity] = None
    ): CACertificateDescription =
      CACertificateDescription
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(status)(_.status(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(ownedBy)(_.ownedBy(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(autoRegistrationStatus)(_.autoRegistrationStatus(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(customerVersion)(_.customerVersion(_))
        .ifSome(generationId)(_.generationId(_))
        .ifSome(validity)(_.validity(_))
        .build

    def cancelAuditMitigationActionsTaskRequest(
      taskId: Option[String] = None
    ): CancelAuditMitigationActionsTaskRequest =
      CancelAuditMitigationActionsTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def cancelAuditMitigationActionsTaskResponse(

    ): CancelAuditMitigationActionsTaskResponse =
      CancelAuditMitigationActionsTaskResponse
        .builder

        .build

    def cancelAuditTaskRequest(
      taskId: Option[String] = None
    ): CancelAuditTaskRequest =
      CancelAuditTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def cancelAuditTaskResponse(

    ): CancelAuditTaskResponse =
      CancelAuditTaskResponse
        .builder

        .build

    def cancelCertificateTransferRequest(
      certificateId: Option[String] = None
    ): CancelCertificateTransferRequest =
      CancelCertificateTransferRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def cancelDetectMitigationActionsTaskRequest(
      taskId: Option[String] = None
    ): CancelDetectMitigationActionsTaskRequest =
      CancelDetectMitigationActionsTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def cancelDetectMitigationActionsTaskResponse(

    ): CancelDetectMitigationActionsTaskResponse =
      CancelDetectMitigationActionsTaskResponse
        .builder

        .build

    def cancelJobExecutionRequest(
      jobId: Option[String] = None,
      thingName: Option[String] = None,
      force: Option[Boolean] = None,
      expectedVersion: Option[ExpectedVersion] = None,
      statusDetails: Option[DetailsMap] = None
    ): CancelJobExecutionRequest =
      CancelJobExecutionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(force)(_.force(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .build

    def cancelJobRequest(
      jobId: Option[String] = None,
      reasonCode: Option[String] = None,
      comment: Option[String] = None,
      force: Option[Boolean] = None
    ): CancelJobRequest =
      CancelJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(reasonCode)(_.reasonCode(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(force)(_.force(_))
        .build

    def cancelJobResponse(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      description: Option[String] = None
    ): CancelJobResponse =
      CancelJobResponse
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(description)(_.description(_))
        .build

    def certificate(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      status: Option[String] = None,
      certificateMode: Option[String] = None,
      creationDate: Option[DateType] = None
    ): Certificate =
      Certificate
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(status)(_.status(_))
        .ifSome(certificateMode)(_.certificateMode(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def certificateConflictException(
      message: Option[String] = None
    ): CertificateConflictException =
      CertificateConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def certificateDescription(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      caCertificateId: Option[String] = None,
      status: Option[String] = None,
      certificatePem: Option[String] = None,
      ownedBy: Option[String] = None,
      previousOwnedBy: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      customerVersion: Option[Int] = None,
      transferData: Option[TransferData] = None,
      generationId: Option[String] = None,
      validity: Option[CertificateValidity] = None,
      certificateMode: Option[String] = None
    ): CertificateDescription =
      CertificateDescription
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(caCertificateId)(_.caCertificateId(_))
        .ifSome(status)(_.status(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(ownedBy)(_.ownedBy(_))
        .ifSome(previousOwnedBy)(_.previousOwnedBy(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(customerVersion)(_.customerVersion(_))
        .ifSome(transferData)(_.transferData(_))
        .ifSome(generationId)(_.generationId(_))
        .ifSome(validity)(_.validity(_))
        .ifSome(certificateMode)(_.certificateMode(_))
        .build

    def certificateStateException(
      message: Option[String] = None
    ): CertificateStateException =
      CertificateStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def certificateValidationException(
      message: Option[String] = None
    ): CertificateValidationException =
      CertificateValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def certificateValidity(
      notBefore: Option[DateType] = None,
      notAfter: Option[DateType] = None
    ): CertificateValidity =
      CertificateValidity
        .builder
        .ifSome(notBefore)(_.notBefore(_))
        .ifSome(notAfter)(_.notAfter(_))
        .build

    def clearDefaultAuthorizerRequest(

    ): ClearDefaultAuthorizerRequest =
      ClearDefaultAuthorizerRequest
        .builder

        .build

    def clearDefaultAuthorizerResponse(

    ): ClearDefaultAuthorizerResponse =
      ClearDefaultAuthorizerResponse
        .builder

        .build

    def cloudwatchAlarmAction(
      roleArn: Option[String] = None,
      alarmName: Option[String] = None,
      stateReason: Option[String] = None,
      stateValue: Option[String] = None
    ): CloudwatchAlarmAction =
      CloudwatchAlarmAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(alarmName)(_.alarmName(_))
        .ifSome(stateReason)(_.stateReason(_))
        .ifSome(stateValue)(_.stateValue(_))
        .build

    def cloudwatchLogsAction(
      roleArn: Option[String] = None,
      logGroupName: Option[String] = None
    ): CloudwatchLogsAction =
      CloudwatchLogsAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(logGroupName)(_.logGroupName(_))
        .build

    def cloudwatchMetricAction(
      roleArn: Option[String] = None,
      metricNamespace: Option[String] = None,
      metricName: Option[String] = None,
      metricValue: Option[String] = None,
      metricUnit: Option[String] = None,
      metricTimestamp: Option[String] = None
    ): CloudwatchMetricAction =
      CloudwatchMetricAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(metricNamespace)(_.metricNamespace(_))
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricValue)(_.metricValue(_))
        .ifSome(metricUnit)(_.metricUnit(_))
        .ifSome(metricTimestamp)(_.metricTimestamp(_))
        .build

    def codeSigning(
      awsSignerJobId: Option[String] = None,
      startSigningJobParameter: Option[StartSigningJobParameter] = None,
      customCodeSigning: Option[CustomCodeSigning] = None
    ): CodeSigning =
      CodeSigning
        .builder
        .ifSome(awsSignerJobId)(_.awsSignerJobId(_))
        .ifSome(startSigningJobParameter)(_.startSigningJobParameter(_))
        .ifSome(customCodeSigning)(_.customCodeSigning(_))
        .build

    def codeSigningCertificateChain(
      certificateName: Option[String] = None,
      inlineDocument: Option[String] = None
    ): CodeSigningCertificateChain =
      CodeSigningCertificateChain
        .builder
        .ifSome(certificateName)(_.certificateName(_))
        .ifSome(inlineDocument)(_.inlineDocument(_))
        .build

    def codeSigningSignature(
      inlineDocument: Option[Signature] = None
    ): CodeSigningSignature =
      CodeSigningSignature
        .builder
        .ifSome(inlineDocument)(_.inlineDocument(_))
        .build

    def configuration(
      enabled: Option[Boolean] = None
    ): Configuration =
      Configuration
        .builder
        .ifSome(enabled)(_.enabled(_))
        .build

    def confirmTopicRuleDestinationRequest(
      confirmationToken: Option[String] = None
    ): ConfirmTopicRuleDestinationRequest =
      ConfirmTopicRuleDestinationRequest
        .builder
        .ifSome(confirmationToken)(_.confirmationToken(_))
        .build

    def confirmTopicRuleDestinationResponse(

    ): ConfirmTopicRuleDestinationResponse =
      ConfirmTopicRuleDestinationResponse
        .builder

        .build

    def conflictException(
      message: Option[String] = None
    ): ConflictException =
      ConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def conflictingResourceUpdateException(
      message: Option[String] = None
    ): ConflictingResourceUpdateException =
      ConflictingResourceUpdateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def createAuditSuppressionRequest(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      expirationDate: Option[Timestamp] = None,
      suppressIndefinitely: Option[Boolean] = None,
      description: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): CreateAuditSuppressionRequest =
      CreateAuditSuppressionRequest
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(suppressIndefinitely)(_.suppressIndefinitely(_))
        .ifSome(description)(_.description(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createAuditSuppressionResponse(

    ): CreateAuditSuppressionResponse =
      CreateAuditSuppressionResponse
        .builder

        .build

    def createAuthorizerRequest(
      authorizerName: Option[String] = None,
      authorizerFunctionArn: Option[String] = None,
      tokenKeyName: Option[String] = None,
      tokenSigningPublicKeys: Option[PublicKeyMap] = None,
      status: Option[String] = None,
      tags: Option[List[Tag]] = None,
      signingDisabled: Option[Boolean] = None
    ): CreateAuthorizerRequest =
      CreateAuthorizerRequest
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerFunctionArn)(_.authorizerFunctionArn(_))
        .ifSome(tokenKeyName)(_.tokenKeyName(_))
        .ifSome(tokenSigningPublicKeys)(_.tokenSigningPublicKeys(_))
        .ifSome(status)(_.status(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(signingDisabled)(_.signingDisabled(_))
        .build

    def createAuthorizerResponse(
      authorizerName: Option[String] = None,
      authorizerArn: Option[String] = None
    ): CreateAuthorizerResponse =
      CreateAuthorizerResponse
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerArn)(_.authorizerArn(_))
        .build

    def createBillingGroupRequest(
      billingGroupName: Option[String] = None,
      billingGroupProperties: Option[BillingGroupProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateBillingGroupRequest =
      CreateBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(billingGroupProperties)(_.billingGroupProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createBillingGroupResponse(
      billingGroupName: Option[String] = None,
      billingGroupArn: Option[String] = None,
      billingGroupId: Option[String] = None
    ): CreateBillingGroupResponse =
      CreateBillingGroupResponse
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(billingGroupArn)(_.billingGroupArn(_))
        .ifSome(billingGroupId)(_.billingGroupId(_))
        .build

    def createCertificateFromCsrRequest(
      certificateSigningRequest: Option[String] = None,
      setAsActive: Option[Boolean] = None
    ): CreateCertificateFromCsrRequest =
      CreateCertificateFromCsrRequest
        .builder
        .ifSome(certificateSigningRequest)(_.certificateSigningRequest(_))
        .ifSome(setAsActive)(_.setAsActive(_))
        .build

    def createCertificateFromCsrResponse(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      certificatePem: Option[String] = None
    ): CreateCertificateFromCsrResponse =
      CreateCertificateFromCsrResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .build

    def createCustomMetricRequest(
      metricName: Option[String] = None,
      displayName: Option[String] = None,
      metricType: Option[String] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): CreateCustomMetricRequest =
      CreateCustomMetricRequest
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(metricType)(_.metricType(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createCustomMetricResponse(
      metricName: Option[String] = None,
      metricArn: Option[String] = None
    ): CreateCustomMetricResponse =
      CreateCustomMetricResponse
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricArn)(_.metricArn(_))
        .build

    def createDimensionRequest(
      name: Option[String] = None,
      `type`: Option[String] = None,
      stringValues: Option[List[DimensionStringValue]] = None,
      tags: Option[List[Tag]] = None,
      clientRequestToken: Option[String] = None
    ): CreateDimensionRequest =
      CreateDimensionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(stringValues)(_.stringValues(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def createDimensionResponse(
      name: Option[String] = None,
      arn: Option[String] = None
    ): CreateDimensionResponse =
      CreateDimensionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def createDomainConfigurationRequest(
      domainConfigurationName: Option[String] = None,
      domainName: Option[String] = None,
      serverCertificateArns: Option[List[AcmCertificateArn]] = None,
      validationCertificateArn: Option[String] = None,
      authorizerConfig: Option[AuthorizerConfig] = None,
      serviceType: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDomainConfigurationRequest =
      CreateDomainConfigurationRequest
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(serverCertificateArns)(_.serverCertificateArns(_))
        .ifSome(validationCertificateArn)(_.validationCertificateArn(_))
        .ifSome(authorizerConfig)(_.authorizerConfig(_))
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDomainConfigurationResponse(
      domainConfigurationName: Option[String] = None,
      domainConfigurationArn: Option[String] = None
    ): CreateDomainConfigurationResponse =
      CreateDomainConfigurationResponse
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .ifSome(domainConfigurationArn)(_.domainConfigurationArn(_))
        .build

    def createDynamicThingGroupRequest(
      thingGroupName: Option[String] = None,
      thingGroupProperties: Option[ThingGroupProperties] = None,
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      queryVersion: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateDynamicThingGroupRequest =
      CreateDynamicThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupProperties)(_.thingGroupProperties(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createDynamicThingGroupResponse(
      thingGroupName: Option[String] = None,
      thingGroupArn: Option[String] = None,
      thingGroupId: Option[String] = None,
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      queryVersion: Option[String] = None
    ): CreateDynamicThingGroupResponse =
      CreateDynamicThingGroupResponse
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupArn)(_.thingGroupArn(_))
        .ifSome(thingGroupId)(_.thingGroupId(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .build

    def createJobRequest(
      jobId: Option[String] = None,
      targets: Option[List[TargetArn]] = None,
      documentSource: Option[String] = None,
      document: Option[String] = None,
      description: Option[String] = None,
      presignedUrlConfig: Option[PresignedUrlConfig] = None,
      targetSelection: Option[String] = None,
      jobExecutionsRolloutConfig: Option[JobExecutionsRolloutConfig] = None,
      abortConfig: Option[AbortConfig] = None,
      timeoutConfig: Option[TimeoutConfig] = None,
      tags: Option[List[Tag]] = None,
      namespaceId: Option[String] = None,
      jobTemplateArn: Option[String] = None
    ): CreateJobRequest =
      CreateJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(documentSource)(_.documentSource(_))
        .ifSome(document)(_.document(_))
        .ifSome(description)(_.description(_))
        .ifSome(presignedUrlConfig)(_.presignedUrlConfig(_))
        .ifSome(targetSelection)(_.targetSelection(_))
        .ifSome(jobExecutionsRolloutConfig)(_.jobExecutionsRolloutConfig(_))
        .ifSome(abortConfig)(_.abortConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .ifSome(jobTemplateArn)(_.jobTemplateArn(_))
        .build

    def createJobResponse(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      description: Option[String] = None
    ): CreateJobResponse =
      CreateJobResponse
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(description)(_.description(_))
        .build

    def createJobTemplateRequest(
      jobTemplateId: Option[String] = None,
      jobArn: Option[String] = None,
      documentSource: Option[String] = None,
      document: Option[String] = None,
      description: Option[String] = None,
      presignedUrlConfig: Option[PresignedUrlConfig] = None,
      jobExecutionsRolloutConfig: Option[JobExecutionsRolloutConfig] = None,
      abortConfig: Option[AbortConfig] = None,
      timeoutConfig: Option[TimeoutConfig] = None,
      tags: Option[List[Tag]] = None
    ): CreateJobTemplateRequest =
      CreateJobTemplateRequest
        .builder
        .ifSome(jobTemplateId)(_.jobTemplateId(_))
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(documentSource)(_.documentSource(_))
        .ifSome(document)(_.document(_))
        .ifSome(description)(_.description(_))
        .ifSome(presignedUrlConfig)(_.presignedUrlConfig(_))
        .ifSome(jobExecutionsRolloutConfig)(_.jobExecutionsRolloutConfig(_))
        .ifSome(abortConfig)(_.abortConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createJobTemplateResponse(
      jobTemplateArn: Option[String] = None,
      jobTemplateId: Option[String] = None
    ): CreateJobTemplateResponse =
      CreateJobTemplateResponse
        .builder
        .ifSome(jobTemplateArn)(_.jobTemplateArn(_))
        .ifSome(jobTemplateId)(_.jobTemplateId(_))
        .build

    def createKeysAndCertificateRequest(
      setAsActive: Option[Boolean] = None
    ): CreateKeysAndCertificateRequest =
      CreateKeysAndCertificateRequest
        .builder
        .ifSome(setAsActive)(_.setAsActive(_))
        .build

    def createKeysAndCertificateResponse(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      certificatePem: Option[String] = None,
      keyPair: Option[KeyPair] = None
    ): CreateKeysAndCertificateResponse =
      CreateKeysAndCertificateResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(keyPair)(_.keyPair(_))
        .build

    def createMitigationActionRequest(
      actionName: Option[String] = None,
      roleArn: Option[String] = None,
      actionParams: Option[MitigationActionParams] = None,
      tags: Option[List[Tag]] = None
    ): CreateMitigationActionRequest =
      CreateMitigationActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(actionParams)(_.actionParams(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createMitigationActionResponse(
      actionArn: Option[String] = None,
      actionId: Option[String] = None
    ): CreateMitigationActionResponse =
      CreateMitigationActionResponse
        .builder
        .ifSome(actionArn)(_.actionArn(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def createOTAUpdateRequest(
      otaUpdateId: Option[String] = None,
      description: Option[String] = None,
      targets: Option[List[Target]] = None,
      protocols: Option[List[Protocol]] = None,
      targetSelection: Option[String] = None,
      awsJobExecutionsRolloutConfig: Option[AwsJobExecutionsRolloutConfig] = None,
      awsJobPresignedUrlConfig: Option[AwsJobPresignedUrlConfig] = None,
      awsJobAbortConfig: Option[AwsJobAbortConfig] = None,
      awsJobTimeoutConfig: Option[AwsJobTimeoutConfig] = None,
      files: Option[List[OTAUpdateFile]] = None,
      roleArn: Option[String] = None,
      additionalParameters: Option[AdditionalParameterMap] = None,
      tags: Option[List[Tag]] = None
    ): CreateOTAUpdateRequest =
      CreateOTAUpdateRequest
        .builder
        .ifSome(otaUpdateId)(_.otaUpdateId(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(targetSelection)(_.targetSelection(_))
        .ifSome(awsJobExecutionsRolloutConfig)(_.awsJobExecutionsRolloutConfig(_))
        .ifSome(awsJobPresignedUrlConfig)(_.awsJobPresignedUrlConfig(_))
        .ifSome(awsJobAbortConfig)(_.awsJobAbortConfig(_))
        .ifSome(awsJobTimeoutConfig)(_.awsJobTimeoutConfig(_))
        .ifSome(files)(_.files(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(additionalParameters)(_.additionalParameters(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createOTAUpdateResponse(
      otaUpdateId: Option[String] = None,
      awsIotJobId: Option[String] = None,
      otaUpdateArn: Option[String] = None,
      awsIotJobArn: Option[String] = None,
      otaUpdateStatus: Option[String] = None
    ): CreateOTAUpdateResponse =
      CreateOTAUpdateResponse
        .builder
        .ifSome(otaUpdateId)(_.otaUpdateId(_))
        .ifSome(awsIotJobId)(_.awsIotJobId(_))
        .ifSome(otaUpdateArn)(_.otaUpdateArn(_))
        .ifSome(awsIotJobArn)(_.awsIotJobArn(_))
        .ifSome(otaUpdateStatus)(_.otaUpdateStatus(_))
        .build

    def createPolicyRequest(
      policyName: Option[String] = None,
      policyDocument: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreatePolicyRequest =
      CreatePolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createPolicyResponse(
      policyName: Option[String] = None,
      policyArn: Option[String] = None,
      policyDocument: Option[String] = None,
      policyVersionId: Option[String] = None
    ): CreatePolicyResponse =
      CreatePolicyResponse
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .build

    def createPolicyVersionRequest(
      policyName: Option[String] = None,
      policyDocument: Option[String] = None,
      setAsDefault: Option[Boolean] = None
    ): CreatePolicyVersionRequest =
      CreatePolicyVersionRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(setAsDefault)(_.setAsDefault(_))
        .build

    def createPolicyVersionResponse(
      policyArn: Option[String] = None,
      policyDocument: Option[String] = None,
      policyVersionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None
    ): CreatePolicyVersionResponse =
      CreatePolicyVersionResponse
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .build

    def createProvisioningClaimRequest(
      templateName: Option[String] = None
    ): CreateProvisioningClaimRequest =
      CreateProvisioningClaimRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def createProvisioningClaimResponse(
      certificateId: Option[String] = None,
      certificatePem: Option[String] = None,
      keyPair: Option[KeyPair] = None,
      expiration: Option[DateType] = None
    ): CreateProvisioningClaimResponse =
      CreateProvisioningClaimResponse
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(keyPair)(_.keyPair(_))
        .ifSome(expiration)(_.expiration(_))
        .build

    def createProvisioningTemplateRequest(
      templateName: Option[String] = None,
      description: Option[String] = None,
      templateBody: Option[String] = None,
      enabled: Option[Boolean] = None,
      provisioningRoleArn: Option[String] = None,
      preProvisioningHook: Option[ProvisioningHook] = None,
      tags: Option[List[Tag]] = None
    ): CreateProvisioningTemplateRequest =
      CreateProvisioningTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(provisioningRoleArn)(_.provisioningRoleArn(_))
        .ifSome(preProvisioningHook)(_.preProvisioningHook(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createProvisioningTemplateResponse(
      templateArn: Option[String] = None,
      templateName: Option[String] = None,
      defaultVersionId: Option[Int] = None
    ): CreateProvisioningTemplateResponse =
      CreateProvisioningTemplateResponse
        .builder
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .build

    def createProvisioningTemplateVersionRequest(
      templateName: Option[String] = None,
      templateBody: Option[String] = None,
      setAsDefault: Option[Boolean] = None
    ): CreateProvisioningTemplateVersionRequest =
      CreateProvisioningTemplateVersionRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(setAsDefault)(_.setAsDefault(_))
        .build

    def createProvisioningTemplateVersionResponse(
      templateArn: Option[String] = None,
      templateName: Option[String] = None,
      versionId: Option[Int] = None,
      isDefaultVersion: Option[Boolean] = None
    ): CreateProvisioningTemplateVersionResponse =
      CreateProvisioningTemplateVersionResponse
        .builder
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .build

    def createRoleAliasRequest(
      roleAlias: Option[String] = None,
      roleArn: Option[String] = None,
      credentialDurationSeconds: Option[Int] = None,
      tags: Option[List[Tag]] = None
    ): CreateRoleAliasRequest =
      CreateRoleAliasRequest
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(credentialDurationSeconds)(_.credentialDurationSeconds(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createRoleAliasResponse(
      roleAlias: Option[String] = None,
      roleAliasArn: Option[String] = None
    ): CreateRoleAliasResponse =
      CreateRoleAliasResponse
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .ifSome(roleAliasArn)(_.roleAliasArn(_))
        .build

    def createScheduledAuditRequest(
      frequency: Option[String] = None,
      dayOfMonth: Option[String] = None,
      dayOfWeek: Option[String] = None,
      targetCheckNames: Option[List[AuditCheckName]] = None,
      scheduledAuditName: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateScheduledAuditRequest =
      CreateScheduledAuditRequest
        .builder
        .ifSome(frequency)(_.frequency(_))
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .ifSome(targetCheckNames)(_.targetCheckNames(_))
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createScheduledAuditResponse(
      scheduledAuditArn: Option[String] = None
    ): CreateScheduledAuditResponse =
      CreateScheduledAuditResponse
        .builder
        .ifSome(scheduledAuditArn)(_.scheduledAuditArn(_))
        .build

    def createSecurityProfileRequest(
      securityProfileName: Option[String] = None,
      securityProfileDescription: Option[String] = None,
      behaviors: Option[List[Behavior]] = None,
      alertTargets: Option[AlertTargets] = None,
      additionalMetricsToRetain: Option[List[BehaviorMetric]] = None,
      additionalMetricsToRetainV2: Option[List[MetricToRetain]] = None,
      tags: Option[List[Tag]] = None
    ): CreateSecurityProfileRequest =
      CreateSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileDescription)(_.securityProfileDescription(_))
        .ifSome(behaviors)(_.behaviors(_))
        .ifSome(alertTargets)(_.alertTargets(_))
        .ifSome(additionalMetricsToRetain)(_.additionalMetricsToRetain(_))
        .ifSome(additionalMetricsToRetainV2)(_.additionalMetricsToRetainV2(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createSecurityProfileResponse(
      securityProfileName: Option[String] = None,
      securityProfileArn: Option[String] = None
    ): CreateSecurityProfileResponse =
      CreateSecurityProfileResponse
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileArn)(_.securityProfileArn(_))
        .build

    def createStreamRequest(
      streamId: Option[String] = None,
      description: Option[String] = None,
      files: Option[List[StreamFile]] = None,
      roleArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): CreateStreamRequest =
      CreateStreamRequest
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(description)(_.description(_))
        .ifSome(files)(_.files(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createStreamResponse(
      streamId: Option[String] = None,
      streamArn: Option[String] = None,
      description: Option[String] = None,
      streamVersion: Option[Int] = None
    ): CreateStreamResponse =
      CreateStreamResponse
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(streamVersion)(_.streamVersion(_))
        .build

    def createThingGroupRequest(
      thingGroupName: Option[String] = None,
      parentGroupName: Option[String] = None,
      thingGroupProperties: Option[ThingGroupProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateThingGroupRequest =
      CreateThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(parentGroupName)(_.parentGroupName(_))
        .ifSome(thingGroupProperties)(_.thingGroupProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createThingGroupResponse(
      thingGroupName: Option[String] = None,
      thingGroupArn: Option[String] = None,
      thingGroupId: Option[String] = None
    ): CreateThingGroupResponse =
      CreateThingGroupResponse
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupArn)(_.thingGroupArn(_))
        .ifSome(thingGroupId)(_.thingGroupId(_))
        .build

    def createThingRequest(
      thingName: Option[String] = None,
      thingTypeName: Option[String] = None,
      attributePayload: Option[AttributePayload] = None,
      billingGroupName: Option[String] = None
    ): CreateThingRequest =
      CreateThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(attributePayload)(_.attributePayload(_))
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .build

    def createThingResponse(
      thingName: Option[String] = None,
      thingArn: Option[String] = None,
      thingId: Option[String] = None
    ): CreateThingResponse =
      CreateThingResponse
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(thingId)(_.thingId(_))
        .build

    def createThingTypeRequest(
      thingTypeName: Option[String] = None,
      thingTypeProperties: Option[ThingTypeProperties] = None,
      tags: Option[List[Tag]] = None
    ): CreateThingTypeRequest =
      CreateThingTypeRequest
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(thingTypeProperties)(_.thingTypeProperties(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createThingTypeResponse(
      thingTypeName: Option[String] = None,
      thingTypeArn: Option[String] = None,
      thingTypeId: Option[String] = None
    ): CreateThingTypeResponse =
      CreateThingTypeResponse
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(thingTypeArn)(_.thingTypeArn(_))
        .ifSome(thingTypeId)(_.thingTypeId(_))
        .build

    def createTopicRuleDestinationRequest(
      destinationConfiguration: Option[TopicRuleDestinationConfiguration] = None
    ): CreateTopicRuleDestinationRequest =
      CreateTopicRuleDestinationRequest
        .builder
        .ifSome(destinationConfiguration)(_.destinationConfiguration(_))
        .build

    def createTopicRuleDestinationResponse(
      topicRuleDestination: Option[TopicRuleDestination] = None
    ): CreateTopicRuleDestinationResponse =
      CreateTopicRuleDestinationResponse
        .builder
        .ifSome(topicRuleDestination)(_.topicRuleDestination(_))
        .build

    def createTopicRuleRequest(
      ruleName: Option[String] = None,
      topicRulePayload: Option[TopicRulePayload] = None,
      tags: Option[String] = None
    ): CreateTopicRuleRequest =
      CreateTopicRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(topicRulePayload)(_.topicRulePayload(_))
        .ifSome(tags)(_.tags(_))
        .build

    def customCodeSigning(
      signature: Option[CodeSigningSignature] = None,
      certificateChain: Option[CodeSigningCertificateChain] = None,
      hashAlgorithm: Option[String] = None,
      signatureAlgorithm: Option[String] = None
    ): CustomCodeSigning =
      CustomCodeSigning
        .builder
        .ifSome(signature)(_.signature(_))
        .ifSome(certificateChain)(_.certificateChain(_))
        .ifSome(hashAlgorithm)(_.hashAlgorithm(_))
        .ifSome(signatureAlgorithm)(_.signatureAlgorithm(_))
        .build

    def deleteAccountAuditConfigurationRequest(
      deleteScheduledAudits: Option[Boolean] = None
    ): DeleteAccountAuditConfigurationRequest =
      DeleteAccountAuditConfigurationRequest
        .builder
        .ifSome(deleteScheduledAudits)(_.deleteScheduledAudits(_))
        .build

    def deleteAccountAuditConfigurationResponse(

    ): DeleteAccountAuditConfigurationResponse =
      DeleteAccountAuditConfigurationResponse
        .builder

        .build

    def deleteAuditSuppressionRequest(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None
    ): DeleteAuditSuppressionRequest =
      DeleteAuditSuppressionRequest
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .build

    def deleteAuditSuppressionResponse(

    ): DeleteAuditSuppressionResponse =
      DeleteAuditSuppressionResponse
        .builder

        .build

    def deleteAuthorizerRequest(
      authorizerName: Option[String] = None
    ): DeleteAuthorizerRequest =
      DeleteAuthorizerRequest
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .build

    def deleteAuthorizerResponse(

    ): DeleteAuthorizerResponse =
      DeleteAuthorizerResponse
        .builder

        .build

    def deleteBillingGroupRequest(
      billingGroupName: Option[String] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): DeleteBillingGroupRequest =
      DeleteBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def deleteBillingGroupResponse(

    ): DeleteBillingGroupResponse =
      DeleteBillingGroupResponse
        .builder

        .build

    def deleteCACertificateRequest(
      certificateId: Option[String] = None
    ): DeleteCACertificateRequest =
      DeleteCACertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def deleteCACertificateResponse(

    ): DeleteCACertificateResponse =
      DeleteCACertificateResponse
        .builder

        .build

    def deleteCertificateRequest(
      certificateId: Option[String] = None,
      forceDelete: Option[Boolean] = None
    ): DeleteCertificateRequest =
      DeleteCertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(forceDelete)(_.forceDelete(_))
        .build

    def deleteConflictException(
      message: Option[String] = None
    ): DeleteConflictException =
      DeleteConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteCustomMetricRequest(
      metricName: Option[String] = None
    ): DeleteCustomMetricRequest =
      DeleteCustomMetricRequest
        .builder
        .ifSome(metricName)(_.metricName(_))
        .build

    def deleteCustomMetricResponse(

    ): DeleteCustomMetricResponse =
      DeleteCustomMetricResponse
        .builder

        .build

    def deleteDimensionRequest(
      name: Option[String] = None
    ): DeleteDimensionRequest =
      DeleteDimensionRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def deleteDimensionResponse(

    ): DeleteDimensionResponse =
      DeleteDimensionResponse
        .builder

        .build

    def deleteDomainConfigurationRequest(
      domainConfigurationName: Option[String] = None
    ): DeleteDomainConfigurationRequest =
      DeleteDomainConfigurationRequest
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .build

    def deleteDomainConfigurationResponse(

    ): DeleteDomainConfigurationResponse =
      DeleteDomainConfigurationResponse
        .builder

        .build

    def deleteDynamicThingGroupRequest(
      thingGroupName: Option[String] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): DeleteDynamicThingGroupRequest =
      DeleteDynamicThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def deleteDynamicThingGroupResponse(

    ): DeleteDynamicThingGroupResponse =
      DeleteDynamicThingGroupResponse
        .builder

        .build

    def deleteJobExecutionRequest(
      jobId: Option[String] = None,
      thingName: Option[String] = None,
      executionNumber: Option[ExecutionNumber] = None,
      force: Option[Boolean] = None,
      namespaceId: Option[String] = None
    ): DeleteJobExecutionRequest =
      DeleteJobExecutionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .ifSome(force)(_.force(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .build

    def deleteJobRequest(
      jobId: Option[String] = None,
      force: Option[Boolean] = None,
      namespaceId: Option[String] = None
    ): DeleteJobRequest =
      DeleteJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(force)(_.force(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .build

    def deleteJobTemplateRequest(
      jobTemplateId: Option[String] = None
    ): DeleteJobTemplateRequest =
      DeleteJobTemplateRequest
        .builder
        .ifSome(jobTemplateId)(_.jobTemplateId(_))
        .build

    def deleteMitigationActionRequest(
      actionName: Option[String] = None
    ): DeleteMitigationActionRequest =
      DeleteMitigationActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .build

    def deleteMitigationActionResponse(

    ): DeleteMitigationActionResponse =
      DeleteMitigationActionResponse
        .builder

        .build

    def deleteOTAUpdateRequest(
      otaUpdateId: Option[String] = None,
      deleteStream: Option[Boolean] = None,
      forceDeleteAWSJob: Option[Boolean] = None
    ): DeleteOTAUpdateRequest =
      DeleteOTAUpdateRequest
        .builder
        .ifSome(otaUpdateId)(_.otaUpdateId(_))
        .ifSome(deleteStream)(_.deleteStream(_))
        .ifSome(forceDeleteAWSJob)(_.forceDeleteAWSJob(_))
        .build

    def deleteOTAUpdateResponse(

    ): DeleteOTAUpdateResponse =
      DeleteOTAUpdateResponse
        .builder

        .build

    def deletePolicyRequest(
      policyName: Option[String] = None
    ): DeletePolicyRequest =
      DeletePolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def deletePolicyVersionRequest(
      policyName: Option[String] = None,
      policyVersionId: Option[String] = None
    ): DeletePolicyVersionRequest =
      DeletePolicyVersionRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .build

    def deleteProvisioningTemplateRequest(
      templateName: Option[String] = None
    ): DeleteProvisioningTemplateRequest =
      DeleteProvisioningTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def deleteProvisioningTemplateResponse(

    ): DeleteProvisioningTemplateResponse =
      DeleteProvisioningTemplateResponse
        .builder

        .build

    def deleteProvisioningTemplateVersionRequest(
      templateName: Option[String] = None,
      versionId: Option[Int] = None
    ): DeleteProvisioningTemplateVersionRequest =
      DeleteProvisioningTemplateVersionRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def deleteProvisioningTemplateVersionResponse(

    ): DeleteProvisioningTemplateVersionResponse =
      DeleteProvisioningTemplateVersionResponse
        .builder

        .build

    def deleteRegistrationCodeRequest(

    ): DeleteRegistrationCodeRequest =
      DeleteRegistrationCodeRequest
        .builder

        .build

    def deleteRegistrationCodeResponse(

    ): DeleteRegistrationCodeResponse =
      DeleteRegistrationCodeResponse
        .builder

        .build

    def deleteRoleAliasRequest(
      roleAlias: Option[String] = None
    ): DeleteRoleAliasRequest =
      DeleteRoleAliasRequest
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .build

    def deleteRoleAliasResponse(

    ): DeleteRoleAliasResponse =
      DeleteRoleAliasResponse
        .builder

        .build

    def deleteScheduledAuditRequest(
      scheduledAuditName: Option[String] = None
    ): DeleteScheduledAuditRequest =
      DeleteScheduledAuditRequest
        .builder
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .build

    def deleteScheduledAuditResponse(

    ): DeleteScheduledAuditResponse =
      DeleteScheduledAuditResponse
        .builder

        .build

    def deleteSecurityProfileRequest(
      securityProfileName: Option[String] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): DeleteSecurityProfileRequest =
      DeleteSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def deleteSecurityProfileResponse(

    ): DeleteSecurityProfileResponse =
      DeleteSecurityProfileResponse
        .builder

        .build

    def deleteStreamRequest(
      streamId: Option[String] = None
    ): DeleteStreamRequest =
      DeleteStreamRequest
        .builder
        .ifSome(streamId)(_.streamId(_))
        .build

    def deleteStreamResponse(

    ): DeleteStreamResponse =
      DeleteStreamResponse
        .builder

        .build

    def deleteThingGroupRequest(
      thingGroupName: Option[String] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): DeleteThingGroupRequest =
      DeleteThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def deleteThingGroupResponse(

    ): DeleteThingGroupResponse =
      DeleteThingGroupResponse
        .builder

        .build

    def deleteThingRequest(
      thingName: Option[String] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): DeleteThingRequest =
      DeleteThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def deleteThingResponse(

    ): DeleteThingResponse =
      DeleteThingResponse
        .builder

        .build

    def deleteThingTypeRequest(
      thingTypeName: Option[String] = None
    ): DeleteThingTypeRequest =
      DeleteThingTypeRequest
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .build

    def deleteThingTypeResponse(

    ): DeleteThingTypeResponse =
      DeleteThingTypeResponse
        .builder

        .build

    def deleteTopicRuleDestinationRequest(
      arn: Option[String] = None
    ): DeleteTopicRuleDestinationRequest =
      DeleteTopicRuleDestinationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def deleteTopicRuleDestinationResponse(

    ): DeleteTopicRuleDestinationResponse =
      DeleteTopicRuleDestinationResponse
        .builder

        .build

    def deleteTopicRuleRequest(
      ruleName: Option[String] = None
    ): DeleteTopicRuleRequest =
      DeleteTopicRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def deleteV2LoggingLevelRequest(
      targetType: Option[String] = None,
      targetName: Option[String] = None
    ): DeleteV2LoggingLevelRequest =
      DeleteV2LoggingLevelRequest
        .builder
        .ifSome(targetType)(_.targetType(_))
        .ifSome(targetName)(_.targetName(_))
        .build

    def denied(
      implicitDeny: Option[ImplicitDeny] = None,
      explicitDeny: Option[ExplicitDeny] = None
    ): Denied =
      Denied
        .builder
        .ifSome(implicitDeny)(_.implicitDeny(_))
        .ifSome(explicitDeny)(_.explicitDeny(_))
        .build

    def deprecateThingTypeRequest(
      thingTypeName: Option[String] = None,
      undoDeprecate: Option[Boolean] = None
    ): DeprecateThingTypeRequest =
      DeprecateThingTypeRequest
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(undoDeprecate)(_.undoDeprecate(_))
        .build

    def deprecateThingTypeResponse(

    ): DeprecateThingTypeResponse =
      DeprecateThingTypeResponse
        .builder

        .build

    def describeAccountAuditConfigurationRequest(

    ): DescribeAccountAuditConfigurationRequest =
      DescribeAccountAuditConfigurationRequest
        .builder

        .build

    def describeAccountAuditConfigurationResponse(
      roleArn: Option[String] = None,
      auditNotificationTargetConfigurations: Option[AuditNotificationTargetConfigurations] = None,
      auditCheckConfigurations: Option[AuditCheckConfigurations] = None
    ): DescribeAccountAuditConfigurationResponse =
      DescribeAccountAuditConfigurationResponse
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(auditNotificationTargetConfigurations)(_.auditNotificationTargetConfigurations(_))
        .ifSome(auditCheckConfigurations)(_.auditCheckConfigurations(_))
        .build

    def describeAuditFindingRequest(
      findingId: Option[String] = None
    ): DescribeAuditFindingRequest =
      DescribeAuditFindingRequest
        .builder
        .ifSome(findingId)(_.findingId(_))
        .build

    def describeAuditFindingResponse(
      finding: Option[AuditFinding] = None
    ): DescribeAuditFindingResponse =
      DescribeAuditFindingResponse
        .builder
        .ifSome(finding)(_.finding(_))
        .build

    def describeAuditMitigationActionsTaskRequest(
      taskId: Option[String] = None
    ): DescribeAuditMitigationActionsTaskRequest =
      DescribeAuditMitigationActionsTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def describeAuditMitigationActionsTaskResponse(
      taskStatus: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      taskStatistics: Option[AuditMitigationActionsTaskStatistics] = None,
      target: Option[AuditMitigationActionsTaskTarget] = None,
      auditCheckToActionsMapping: Option[AuditCheckToActionsMapping] = None,
      actionsDefinition: Option[List[MitigationAction]] = None
    ): DescribeAuditMitigationActionsTaskResponse =
      DescribeAuditMitigationActionsTaskResponse
        .builder
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(taskStatistics)(_.taskStatistics(_))
        .ifSome(target)(_.target(_))
        .ifSome(auditCheckToActionsMapping)(_.auditCheckToActionsMapping(_))
        .ifSome(actionsDefinition)(_.actionsDefinition(_))
        .build

    def describeAuditSuppressionRequest(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None
    ): DescribeAuditSuppressionRequest =
      DescribeAuditSuppressionRequest
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .build

    def describeAuditSuppressionResponse(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      expirationDate: Option[Timestamp] = None,
      suppressIndefinitely: Option[Boolean] = None,
      description: Option[String] = None
    ): DescribeAuditSuppressionResponse =
      DescribeAuditSuppressionResponse
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(suppressIndefinitely)(_.suppressIndefinitely(_))
        .ifSome(description)(_.description(_))
        .build

    def describeAuditTaskRequest(
      taskId: Option[String] = None
    ): DescribeAuditTaskRequest =
      DescribeAuditTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def describeAuditTaskResponse(
      taskStatus: Option[String] = None,
      taskType: Option[String] = None,
      taskStartTime: Option[Timestamp] = None,
      taskStatistics: Option[TaskStatistics] = None,
      scheduledAuditName: Option[String] = None,
      auditDetails: Option[AuditDetails] = None
    ): DescribeAuditTaskResponse =
      DescribeAuditTaskResponse
        .builder
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(taskType)(_.taskType(_))
        .ifSome(taskStartTime)(_.taskStartTime(_))
        .ifSome(taskStatistics)(_.taskStatistics(_))
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .ifSome(auditDetails)(_.auditDetails(_))
        .build

    def describeAuthorizerRequest(
      authorizerName: Option[String] = None
    ): DescribeAuthorizerRequest =
      DescribeAuthorizerRequest
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .build

    def describeAuthorizerResponse(
      authorizerDescription: Option[AuthorizerDescription] = None
    ): DescribeAuthorizerResponse =
      DescribeAuthorizerResponse
        .builder
        .ifSome(authorizerDescription)(_.authorizerDescription(_))
        .build

    def describeBillingGroupRequest(
      billingGroupName: Option[String] = None
    ): DescribeBillingGroupRequest =
      DescribeBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .build

    def describeBillingGroupResponse(
      billingGroupName: Option[String] = None,
      billingGroupId: Option[String] = None,
      billingGroupArn: Option[String] = None,
      version: Option[Version] = None,
      billingGroupProperties: Option[BillingGroupProperties] = None,
      billingGroupMetadata: Option[BillingGroupMetadata] = None
    ): DescribeBillingGroupResponse =
      DescribeBillingGroupResponse
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(billingGroupId)(_.billingGroupId(_))
        .ifSome(billingGroupArn)(_.billingGroupArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(billingGroupProperties)(_.billingGroupProperties(_))
        .ifSome(billingGroupMetadata)(_.billingGroupMetadata(_))
        .build

    def describeCACertificateRequest(
      certificateId: Option[String] = None
    ): DescribeCACertificateRequest =
      DescribeCACertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def describeCACertificateResponse(
      certificateDescription: Option[CACertificateDescription] = None,
      registrationConfig: Option[RegistrationConfig] = None
    ): DescribeCACertificateResponse =
      DescribeCACertificateResponse
        .builder
        .ifSome(certificateDescription)(_.certificateDescription(_))
        .ifSome(registrationConfig)(_.registrationConfig(_))
        .build

    def describeCertificateRequest(
      certificateId: Option[String] = None
    ): DescribeCertificateRequest =
      DescribeCertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def describeCertificateResponse(
      certificateDescription: Option[CertificateDescription] = None
    ): DescribeCertificateResponse =
      DescribeCertificateResponse
        .builder
        .ifSome(certificateDescription)(_.certificateDescription(_))
        .build

    def describeCustomMetricRequest(
      metricName: Option[String] = None
    ): DescribeCustomMetricRequest =
      DescribeCustomMetricRequest
        .builder
        .ifSome(metricName)(_.metricName(_))
        .build

    def describeCustomMetricResponse(
      metricName: Option[String] = None,
      metricArn: Option[String] = None,
      metricType: Option[String] = None,
      displayName: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): DescribeCustomMetricResponse =
      DescribeCustomMetricResponse
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricArn)(_.metricArn(_))
        .ifSome(metricType)(_.metricType(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def describeDefaultAuthorizerRequest(

    ): DescribeDefaultAuthorizerRequest =
      DescribeDefaultAuthorizerRequest
        .builder

        .build

    def describeDefaultAuthorizerResponse(
      authorizerDescription: Option[AuthorizerDescription] = None
    ): DescribeDefaultAuthorizerResponse =
      DescribeDefaultAuthorizerResponse
        .builder
        .ifSome(authorizerDescription)(_.authorizerDescription(_))
        .build

    def describeDetectMitigationActionsTaskRequest(
      taskId: Option[String] = None
    ): DescribeDetectMitigationActionsTaskRequest =
      DescribeDetectMitigationActionsTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def describeDetectMitigationActionsTaskResponse(
      taskSummary: Option[DetectMitigationActionsTaskSummary] = None
    ): DescribeDetectMitigationActionsTaskResponse =
      DescribeDetectMitigationActionsTaskResponse
        .builder
        .ifSome(taskSummary)(_.taskSummary(_))
        .build

    def describeDimensionRequest(
      name: Option[String] = None
    ): DescribeDimensionRequest =
      DescribeDimensionRequest
        .builder
        .ifSome(name)(_.name(_))
        .build

    def describeDimensionResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      `type`: Option[String] = None,
      stringValues: Option[List[DimensionStringValue]] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): DescribeDimensionResponse =
      DescribeDimensionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(stringValues)(_.stringValues(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def describeDomainConfigurationRequest(
      domainConfigurationName: Option[String] = None
    ): DescribeDomainConfigurationRequest =
      DescribeDomainConfigurationRequest
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .build

    def describeDomainConfigurationResponse(
      domainConfigurationName: Option[String] = None,
      domainConfigurationArn: Option[String] = None,
      domainName: Option[String] = None,
      serverCertificates: Option[List[ServerCertificateSummary]] = None,
      authorizerConfig: Option[AuthorizerConfig] = None,
      domainConfigurationStatus: Option[String] = None,
      serviceType: Option[String] = None,
      domainType: Option[String] = None,
      lastStatusChangeDate: Option[DateType] = None
    ): DescribeDomainConfigurationResponse =
      DescribeDomainConfigurationResponse
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .ifSome(domainConfigurationArn)(_.domainConfigurationArn(_))
        .ifSome(domainName)(_.domainName(_))
        .ifSome(serverCertificates)(_.serverCertificates(_))
        .ifSome(authorizerConfig)(_.authorizerConfig(_))
        .ifSome(domainConfigurationStatus)(_.domainConfigurationStatus(_))
        .ifSome(serviceType)(_.serviceType(_))
        .ifSome(domainType)(_.domainType(_))
        .ifSome(lastStatusChangeDate)(_.lastStatusChangeDate(_))
        .build

    def describeEndpointRequest(
      endpointType: Option[String] = None
    ): DescribeEndpointRequest =
      DescribeEndpointRequest
        .builder
        .ifSome(endpointType)(_.endpointType(_))
        .build

    def describeEndpointResponse(
      endpointAddress: Option[String] = None
    ): DescribeEndpointResponse =
      DescribeEndpointResponse
        .builder
        .ifSome(endpointAddress)(_.endpointAddress(_))
        .build

    def describeEventConfigurationsRequest(

    ): DescribeEventConfigurationsRequest =
      DescribeEventConfigurationsRequest
        .builder

        .build

    def describeEventConfigurationsResponse(
      eventConfigurations: Option[EventConfigurations] = None,
      creationDate: Option[CreationDate] = None,
      lastModifiedDate: Option[LastModifiedDate] = None
    ): DescribeEventConfigurationsResponse =
      DescribeEventConfigurationsResponse
        .builder
        .ifSome(eventConfigurations)(_.eventConfigurations(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def describeIndexRequest(
      indexName: Option[String] = None
    ): DescribeIndexRequest =
      DescribeIndexRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .build

    def describeIndexResponse(
      indexName: Option[String] = None,
      indexStatus: Option[String] = None,
      schema: Option[String] = None
    ): DescribeIndexResponse =
      DescribeIndexResponse
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(indexStatus)(_.indexStatus(_))
        .ifSome(schema)(_.schema(_))
        .build

    def describeJobExecutionRequest(
      jobId: Option[String] = None,
      thingName: Option[String] = None,
      executionNumber: Option[ExecutionNumber] = None
    ): DescribeJobExecutionRequest =
      DescribeJobExecutionRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .build

    def describeJobExecutionResponse(
      execution: Option[JobExecution] = None
    ): DescribeJobExecutionResponse =
      DescribeJobExecutionResponse
        .builder
        .ifSome(execution)(_.execution(_))
        .build

    def describeJobRequest(
      jobId: Option[String] = None
    ): DescribeJobRequest =
      DescribeJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def describeJobResponse(
      documentSource: Option[String] = None,
      job: Option[Job] = None
    ): DescribeJobResponse =
      DescribeJobResponse
        .builder
        .ifSome(documentSource)(_.documentSource(_))
        .ifSome(job)(_.job(_))
        .build

    def describeJobTemplateRequest(
      jobTemplateId: Option[String] = None
    ): DescribeJobTemplateRequest =
      DescribeJobTemplateRequest
        .builder
        .ifSome(jobTemplateId)(_.jobTemplateId(_))
        .build

    def describeJobTemplateResponse(
      jobTemplateArn: Option[String] = None,
      jobTemplateId: Option[String] = None,
      description: Option[String] = None,
      documentSource: Option[String] = None,
      document: Option[String] = None,
      createdAt: Option[DateType] = None,
      presignedUrlConfig: Option[PresignedUrlConfig] = None,
      jobExecutionsRolloutConfig: Option[JobExecutionsRolloutConfig] = None,
      abortConfig: Option[AbortConfig] = None,
      timeoutConfig: Option[TimeoutConfig] = None
    ): DescribeJobTemplateResponse =
      DescribeJobTemplateResponse
        .builder
        .ifSome(jobTemplateArn)(_.jobTemplateArn(_))
        .ifSome(jobTemplateId)(_.jobTemplateId(_))
        .ifSome(description)(_.description(_))
        .ifSome(documentSource)(_.documentSource(_))
        .ifSome(document)(_.document(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(presignedUrlConfig)(_.presignedUrlConfig(_))
        .ifSome(jobExecutionsRolloutConfig)(_.jobExecutionsRolloutConfig(_))
        .ifSome(abortConfig)(_.abortConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .build

    def describeMitigationActionRequest(
      actionName: Option[String] = None
    ): DescribeMitigationActionRequest =
      DescribeMitigationActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .build

    def describeMitigationActionResponse(
      actionName: Option[String] = None,
      actionType: Option[String] = None,
      actionArn: Option[String] = None,
      actionId: Option[String] = None,
      roleArn: Option[String] = None,
      actionParams: Option[MitigationActionParams] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): DescribeMitigationActionResponse =
      DescribeMitigationActionResponse
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionType)(_.actionType(_))
        .ifSome(actionArn)(_.actionArn(_))
        .ifSome(actionId)(_.actionId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(actionParams)(_.actionParams(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def describeProvisioningTemplateRequest(
      templateName: Option[String] = None
    ): DescribeProvisioningTemplateRequest =
      DescribeProvisioningTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def describeProvisioningTemplateResponse(
      templateArn: Option[String] = None,
      templateName: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      defaultVersionId: Option[Int] = None,
      templateBody: Option[String] = None,
      enabled: Option[Boolean] = None,
      provisioningRoleArn: Option[String] = None,
      preProvisioningHook: Option[ProvisioningHook] = None
    ): DescribeProvisioningTemplateResponse =
      DescribeProvisioningTemplateResponse
        .builder
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(provisioningRoleArn)(_.provisioningRoleArn(_))
        .ifSome(preProvisioningHook)(_.preProvisioningHook(_))
        .build

    def describeProvisioningTemplateVersionRequest(
      templateName: Option[String] = None,
      versionId: Option[Int] = None
    ): DescribeProvisioningTemplateVersionRequest =
      DescribeProvisioningTemplateVersionRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def describeProvisioningTemplateVersionResponse(
      versionId: Option[Int] = None,
      creationDate: Option[DateType] = None,
      templateBody: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None
    ): DescribeProvisioningTemplateVersionResponse =
      DescribeProvisioningTemplateVersionResponse
        .builder
        .ifSome(versionId)(_.versionId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .build

    def describeRoleAliasRequest(
      roleAlias: Option[String] = None
    ): DescribeRoleAliasRequest =
      DescribeRoleAliasRequest
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .build

    def describeRoleAliasResponse(
      roleAliasDescription: Option[RoleAliasDescription] = None
    ): DescribeRoleAliasResponse =
      DescribeRoleAliasResponse
        .builder
        .ifSome(roleAliasDescription)(_.roleAliasDescription(_))
        .build

    def describeScheduledAuditRequest(
      scheduledAuditName: Option[String] = None
    ): DescribeScheduledAuditRequest =
      DescribeScheduledAuditRequest
        .builder
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .build

    def describeScheduledAuditResponse(
      frequency: Option[String] = None,
      dayOfMonth: Option[String] = None,
      dayOfWeek: Option[String] = None,
      targetCheckNames: Option[List[AuditCheckName]] = None,
      scheduledAuditName: Option[String] = None,
      scheduledAuditArn: Option[String] = None
    ): DescribeScheduledAuditResponse =
      DescribeScheduledAuditResponse
        .builder
        .ifSome(frequency)(_.frequency(_))
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .ifSome(targetCheckNames)(_.targetCheckNames(_))
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .ifSome(scheduledAuditArn)(_.scheduledAuditArn(_))
        .build

    def describeSecurityProfileRequest(
      securityProfileName: Option[String] = None
    ): DescribeSecurityProfileRequest =
      DescribeSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .build

    def describeSecurityProfileResponse(
      securityProfileName: Option[String] = None,
      securityProfileArn: Option[String] = None,
      securityProfileDescription: Option[String] = None,
      behaviors: Option[List[Behavior]] = None,
      alertTargets: Option[AlertTargets] = None,
      additionalMetricsToRetain: Option[List[BehaviorMetric]] = None,
      additionalMetricsToRetainV2: Option[List[MetricToRetain]] = None,
      version: Option[Version] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): DescribeSecurityProfileResponse =
      DescribeSecurityProfileResponse
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileArn)(_.securityProfileArn(_))
        .ifSome(securityProfileDescription)(_.securityProfileDescription(_))
        .ifSome(behaviors)(_.behaviors(_))
        .ifSome(alertTargets)(_.alertTargets(_))
        .ifSome(additionalMetricsToRetain)(_.additionalMetricsToRetain(_))
        .ifSome(additionalMetricsToRetainV2)(_.additionalMetricsToRetainV2(_))
        .ifSome(version)(_.version(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def describeStreamRequest(
      streamId: Option[String] = None
    ): DescribeStreamRequest =
      DescribeStreamRequest
        .builder
        .ifSome(streamId)(_.streamId(_))
        .build

    def describeStreamResponse(
      streamInfo: Option[StreamInfo] = None
    ): DescribeStreamResponse =
      DescribeStreamResponse
        .builder
        .ifSome(streamInfo)(_.streamInfo(_))
        .build

    def describeThingGroupRequest(
      thingGroupName: Option[String] = None
    ): DescribeThingGroupRequest =
      DescribeThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .build

    def describeThingGroupResponse(
      thingGroupName: Option[String] = None,
      thingGroupId: Option[String] = None,
      thingGroupArn: Option[String] = None,
      version: Option[Version] = None,
      thingGroupProperties: Option[ThingGroupProperties] = None,
      thingGroupMetadata: Option[ThingGroupMetadata] = None,
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      queryVersion: Option[String] = None,
      status: Option[String] = None
    ): DescribeThingGroupResponse =
      DescribeThingGroupResponse
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupId)(_.thingGroupId(_))
        .ifSome(thingGroupArn)(_.thingGroupArn(_))
        .ifSome(version)(_.version(_))
        .ifSome(thingGroupProperties)(_.thingGroupProperties(_))
        .ifSome(thingGroupMetadata)(_.thingGroupMetadata(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .ifSome(status)(_.status(_))
        .build

    def describeThingRegistrationTaskRequest(
      taskId: Option[String] = None
    ): DescribeThingRegistrationTaskRequest =
      DescribeThingRegistrationTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def describeThingRegistrationTaskResponse(
      taskId: Option[String] = None,
      creationDate: Option[CreationDate] = None,
      lastModifiedDate: Option[LastModifiedDate] = None,
      templateBody: Option[String] = None,
      inputFileBucket: Option[String] = None,
      inputFileKey: Option[String] = None,
      roleArn: Option[String] = None,
      status: Option[String] = None,
      message: Option[String] = None,
      successCount: Option[Int] = None,
      failureCount: Option[Int] = None,
      percentageProgress: Option[Int] = None
    ): DescribeThingRegistrationTaskResponse =
      DescribeThingRegistrationTaskResponse
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(inputFileBucket)(_.inputFileBucket(_))
        .ifSome(inputFileKey)(_.inputFileKey(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(status)(_.status(_))
        .ifSome(message)(_.message(_))
        .ifSome(successCount)(_.successCount(_))
        .ifSome(failureCount)(_.failureCount(_))
        .ifSome(percentageProgress)(_.percentageProgress(_))
        .build

    def describeThingRequest(
      thingName: Option[String] = None
    ): DescribeThingRequest =
      DescribeThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .build

    def describeThingResponse(
      defaultClientId: Option[String] = None,
      thingName: Option[String] = None,
      thingId: Option[String] = None,
      thingArn: Option[String] = None,
      thingTypeName: Option[String] = None,
      attributes: Option[Attributes] = None,
      version: Option[Version] = None,
      billingGroupName: Option[String] = None
    ): DescribeThingResponse =
      DescribeThingResponse
        .builder
        .ifSome(defaultClientId)(_.defaultClientId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingId)(_.thingId(_))
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(version)(_.version(_))
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .build

    def describeThingTypeRequest(
      thingTypeName: Option[String] = None
    ): DescribeThingTypeRequest =
      DescribeThingTypeRequest
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .build

    def describeThingTypeResponse(
      thingTypeName: Option[String] = None,
      thingTypeId: Option[String] = None,
      thingTypeArn: Option[String] = None,
      thingTypeProperties: Option[ThingTypeProperties] = None,
      thingTypeMetadata: Option[ThingTypeMetadata] = None
    ): DescribeThingTypeResponse =
      DescribeThingTypeResponse
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(thingTypeId)(_.thingTypeId(_))
        .ifSome(thingTypeArn)(_.thingTypeArn(_))
        .ifSome(thingTypeProperties)(_.thingTypeProperties(_))
        .ifSome(thingTypeMetadata)(_.thingTypeMetadata(_))
        .build

    def destination(
      s3Destination: Option[S3Destination] = None
    ): Destination =
      Destination
        .builder
        .ifSome(s3Destination)(_.s3Destination(_))
        .build

    def detachPolicyRequest(
      policyName: Option[String] = None,
      target: Option[String] = None
    ): DetachPolicyRequest =
      DetachPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(target)(_.target(_))
        .build

    def detachPrincipalPolicyRequest(
      policyName: Option[String] = None,
      principal: Option[String] = None
    ): DetachPrincipalPolicyRequest =
      DetachPrincipalPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(principal)(_.principal(_))
        .build

    def detachSecurityProfileRequest(
      securityProfileName: Option[String] = None,
      securityProfileTargetArn: Option[String] = None
    ): DetachSecurityProfileRequest =
      DetachSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileTargetArn)(_.securityProfileTargetArn(_))
        .build

    def detachSecurityProfileResponse(

    ): DetachSecurityProfileResponse =
      DetachSecurityProfileResponse
        .builder

        .build

    def detachThingPrincipalRequest(
      thingName: Option[String] = None,
      principal: Option[String] = None
    ): DetachThingPrincipalRequest =
      DetachThingPrincipalRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(principal)(_.principal(_))
        .build

    def detachThingPrincipalResponse(

    ): DetachThingPrincipalResponse =
      DetachThingPrincipalResponse
        .builder

        .build

    def detectMitigationActionExecution(
      taskId: Option[String] = None,
      violationId: Option[String] = None,
      actionName: Option[String] = None,
      thingName: Option[String] = None,
      executionStartDate: Option[Timestamp] = None,
      executionEndDate: Option[Timestamp] = None,
      status: Option[String] = None,
      errorCode: Option[String] = None,
      message: Option[String] = None
    ): DetectMitigationActionExecution =
      DetectMitigationActionExecution
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(violationId)(_.violationId(_))
        .ifSome(actionName)(_.actionName(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(executionStartDate)(_.executionStartDate(_))
        .ifSome(executionEndDate)(_.executionEndDate(_))
        .ifSome(status)(_.status(_))
        .ifSome(errorCode)(_.errorCode(_))
        .ifSome(message)(_.message(_))
        .build

    def detectMitigationActionsTaskStatistics(
      actionsExecuted: Option[GenericLongValue] = None,
      actionsSkipped: Option[GenericLongValue] = None,
      actionsFailed: Option[GenericLongValue] = None
    ): DetectMitigationActionsTaskStatistics =
      DetectMitigationActionsTaskStatistics
        .builder
        .ifSome(actionsExecuted)(_.actionsExecuted(_))
        .ifSome(actionsSkipped)(_.actionsSkipped(_))
        .ifSome(actionsFailed)(_.actionsFailed(_))
        .build

    def detectMitigationActionsTaskSummary(
      taskId: Option[String] = None,
      taskStatus: Option[String] = None,
      taskStartTime: Option[Timestamp] = None,
      taskEndTime: Option[Timestamp] = None,
      target: Option[DetectMitigationActionsTaskTarget] = None,
      violationEventOccurrenceRange: Option[ViolationEventOccurrenceRange] = None,
      onlyActiveViolationsIncluded: Option[Boolean] = None,
      suppressedAlertsIncluded: Option[Boolean] = None,
      actionsDefinition: Option[List[MitigationAction]] = None,
      taskStatistics: Option[DetectMitigationActionsTaskStatistics] = None
    ): DetectMitigationActionsTaskSummary =
      DetectMitigationActionsTaskSummary
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(taskStartTime)(_.taskStartTime(_))
        .ifSome(taskEndTime)(_.taskEndTime(_))
        .ifSome(target)(_.target(_))
        .ifSome(violationEventOccurrenceRange)(_.violationEventOccurrenceRange(_))
        .ifSome(onlyActiveViolationsIncluded)(_.onlyActiveViolationsIncluded(_))
        .ifSome(suppressedAlertsIncluded)(_.suppressedAlertsIncluded(_))
        .ifSome(actionsDefinition)(_.actionsDefinition(_))
        .ifSome(taskStatistics)(_.taskStatistics(_))
        .build

    def detectMitigationActionsTaskTarget(
      violationIds: Option[List[ViolationId]] = None,
      securityProfileName: Option[String] = None,
      behaviorName: Option[String] = None
    ): DetectMitigationActionsTaskTarget =
      DetectMitigationActionsTaskTarget
        .builder
        .ifSome(violationIds)(_.violationIds(_))
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(behaviorName)(_.behaviorName(_))
        .build

    def disableTopicRuleRequest(
      ruleName: Option[String] = None
    ): DisableTopicRuleRequest =
      DisableTopicRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def domainConfigurationSummary(
      domainConfigurationName: Option[String] = None,
      domainConfigurationArn: Option[String] = None,
      serviceType: Option[String] = None
    ): DomainConfigurationSummary =
      DomainConfigurationSummary
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .ifSome(domainConfigurationArn)(_.domainConfigurationArn(_))
        .ifSome(serviceType)(_.serviceType(_))
        .build

    def dynamoDBAction(
      tableName: Option[String] = None,
      roleArn: Option[String] = None,
      operation: Option[String] = None,
      hashKeyField: Option[String] = None,
      hashKeyValue: Option[String] = None,
      hashKeyType: Option[String] = None,
      rangeKeyField: Option[String] = None,
      rangeKeyValue: Option[String] = None,
      rangeKeyType: Option[String] = None,
      payloadField: Option[String] = None
    ): DynamoDBAction =
      DynamoDBAction
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(operation)(_.operation(_))
        .ifSome(hashKeyField)(_.hashKeyField(_))
        .ifSome(hashKeyValue)(_.hashKeyValue(_))
        .ifSome(hashKeyType)(_.hashKeyType(_))
        .ifSome(rangeKeyField)(_.rangeKeyField(_))
        .ifSome(rangeKeyValue)(_.rangeKeyValue(_))
        .ifSome(rangeKeyType)(_.rangeKeyType(_))
        .ifSome(payloadField)(_.payloadField(_))
        .build

    def dynamoDBv2Action(
      roleArn: Option[String] = None,
      putItem: Option[PutItemInput] = None
    ): DynamoDBv2Action =
      DynamoDBv2Action
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(putItem)(_.putItem(_))
        .build

    def effectivePolicy(
      policyName: Option[String] = None,
      policyArn: Option[String] = None,
      policyDocument: Option[String] = None
    ): EffectivePolicy =
      EffectivePolicy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .build

    def elasticsearchAction(
      roleArn: Option[String] = None,
      endpoint: Option[String] = None,
      index: Option[String] = None,
      `type`: Option[String] = None,
      id: Option[String] = None
    ): ElasticsearchAction =
      ElasticsearchAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(endpoint)(_.endpoint(_))
        .ifSome(index)(_.index(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(id)(_.id(_))
        .build

    def enableIoTLoggingParams(
      roleArnForLogging: Option[String] = None,
      logLevel: Option[String] = None
    ): EnableIoTLoggingParams =
      EnableIoTLoggingParams
        .builder
        .ifSome(roleArnForLogging)(_.roleArnForLogging(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def enableTopicRuleRequest(
      ruleName: Option[String] = None
    ): EnableTopicRuleRequest =
      EnableTopicRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def errorInfo(
      code: Option[String] = None,
      message: Option[String] = None
    ): ErrorInfo =
      ErrorInfo
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def explicitDeny(
      policies: Option[List[Policy]] = None
    ): ExplicitDeny =
      ExplicitDeny
        .builder
        .ifSome(policies)(_.policies(_))
        .build

    def exponentialRolloutRate(
      baseRatePerMinute: Option[Int] = None,
      incrementFactor: Option[IncrementFactor] = None,
      rateIncreaseCriteria: Option[RateIncreaseCriteria] = None
    ): ExponentialRolloutRate =
      ExponentialRolloutRate
        .builder
        .ifSome(baseRatePerMinute)(_.baseRatePerMinute(_))
        .ifSome(incrementFactor)(_.incrementFactor(_))
        .ifSome(rateIncreaseCriteria)(_.rateIncreaseCriteria(_))
        .build

    def field(
      name: Option[String] = None,
      `type`: Option[String] = None
    ): Field =
      Field
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(`type`)(_.`type`(_))
        .build

    def fileLocation(
      stream: Option[Stream] = None,
      s3Location: Option[S3Location] = None
    ): FileLocation =
      FileLocation
        .builder
        .ifSome(stream)(_.stream(_))
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def firehoseAction(
      roleArn: Option[String] = None,
      deliveryStreamName: Option[String] = None,
      separator: Option[String] = None,
      batchMode: Option[Boolean] = None
    ): FirehoseAction =
      FirehoseAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(deliveryStreamName)(_.deliveryStreamName(_))
        .ifSome(separator)(_.separator(_))
        .ifSome(batchMode)(_.batchMode(_))
        .build

    def getBehaviorModelTrainingSummariesRequest(
      securityProfileName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): GetBehaviorModelTrainingSummariesRequest =
      GetBehaviorModelTrainingSummariesRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getBehaviorModelTrainingSummariesResponse(
      summaries: Option[List[BehaviorModelTrainingSummary]] = None,
      nextToken: Option[String] = None
    ): GetBehaviorModelTrainingSummariesResponse =
      GetBehaviorModelTrainingSummariesResponse
        .builder
        .ifSome(summaries)(_.summaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def getCardinalityRequest(
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      aggregationField: Option[String] = None,
      queryVersion: Option[String] = None
    ): GetCardinalityRequest =
      GetCardinalityRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(aggregationField)(_.aggregationField(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .build

    def getCardinalityResponse(
      cardinality: Option[Int] = None
    ): GetCardinalityResponse =
      GetCardinalityResponse
        .builder
        .ifSome(cardinality)(_.cardinality(_))
        .build

    def getEffectivePoliciesRequest(
      principal: Option[String] = None,
      cognitoIdentityPoolId: Option[String] = None,
      thingName: Option[String] = None
    ): GetEffectivePoliciesRequest =
      GetEffectivePoliciesRequest
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(cognitoIdentityPoolId)(_.cognitoIdentityPoolId(_))
        .ifSome(thingName)(_.thingName(_))
        .build

    def getEffectivePoliciesResponse(
      effectivePolicies: Option[List[EffectivePolicy]] = None
    ): GetEffectivePoliciesResponse =
      GetEffectivePoliciesResponse
        .builder
        .ifSome(effectivePolicies)(_.effectivePolicies(_))
        .build

    def getIndexingConfigurationRequest(

    ): GetIndexingConfigurationRequest =
      GetIndexingConfigurationRequest
        .builder

        .build

    def getIndexingConfigurationResponse(
      thingIndexingConfiguration: Option[ThingIndexingConfiguration] = None,
      thingGroupIndexingConfiguration: Option[ThingGroupIndexingConfiguration] = None
    ): GetIndexingConfigurationResponse =
      GetIndexingConfigurationResponse
        .builder
        .ifSome(thingIndexingConfiguration)(_.thingIndexingConfiguration(_))
        .ifSome(thingGroupIndexingConfiguration)(_.thingGroupIndexingConfiguration(_))
        .build

    def getJobDocumentRequest(
      jobId: Option[String] = None
    ): GetJobDocumentRequest =
      GetJobDocumentRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .build

    def getJobDocumentResponse(
      document: Option[String] = None
    ): GetJobDocumentResponse =
      GetJobDocumentResponse
        .builder
        .ifSome(document)(_.document(_))
        .build

    def getLoggingOptionsRequest(

    ): GetLoggingOptionsRequest =
      GetLoggingOptionsRequest
        .builder

        .build

    def getLoggingOptionsResponse(
      roleArn: Option[String] = None,
      logLevel: Option[String] = None
    ): GetLoggingOptionsResponse =
      GetLoggingOptionsResponse
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def getOTAUpdateRequest(
      otaUpdateId: Option[String] = None
    ): GetOTAUpdateRequest =
      GetOTAUpdateRequest
        .builder
        .ifSome(otaUpdateId)(_.otaUpdateId(_))
        .build

    def getOTAUpdateResponse(
      otaUpdateInfo: Option[OTAUpdateInfo] = None
    ): GetOTAUpdateResponse =
      GetOTAUpdateResponse
        .builder
        .ifSome(otaUpdateInfo)(_.otaUpdateInfo(_))
        .build

    def getPercentilesRequest(
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      aggregationField: Option[String] = None,
      queryVersion: Option[String] = None,
      percents: Option[List[Percent]] = None
    ): GetPercentilesRequest =
      GetPercentilesRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(aggregationField)(_.aggregationField(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .ifSome(percents)(_.percents(_))
        .build

    def getPercentilesResponse(
      percentiles: Option[List[PercentPair]] = None
    ): GetPercentilesResponse =
      GetPercentilesResponse
        .builder
        .ifSome(percentiles)(_.percentiles(_))
        .build

    def getPolicyRequest(
      policyName: Option[String] = None
    ): GetPolicyRequest =
      GetPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def getPolicyResponse(
      policyName: Option[String] = None,
      policyArn: Option[String] = None,
      policyDocument: Option[String] = None,
      defaultVersionId: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      generationId: Option[String] = None
    ): GetPolicyResponse =
      GetPolicyResponse
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(generationId)(_.generationId(_))
        .build

    def getPolicyVersionRequest(
      policyName: Option[String] = None,
      policyVersionId: Option[String] = None
    ): GetPolicyVersionRequest =
      GetPolicyVersionRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .build

    def getPolicyVersionResponse(
      policyArn: Option[String] = None,
      policyName: Option[String] = None,
      policyDocument: Option[String] = None,
      policyVersionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      generationId: Option[String] = None
    ): GetPolicyVersionResponse =
      GetPolicyVersionResponse
        .builder
        .ifSome(policyArn)(_.policyArn(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyDocument)(_.policyDocument(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(generationId)(_.generationId(_))
        .build

    def getRegistrationCodeRequest(

    ): GetRegistrationCodeRequest =
      GetRegistrationCodeRequest
        .builder

        .build

    def getRegistrationCodeResponse(
      registrationCode: Option[String] = None
    ): GetRegistrationCodeResponse =
      GetRegistrationCodeResponse
        .builder
        .ifSome(registrationCode)(_.registrationCode(_))
        .build

    def getStatisticsRequest(
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      aggregationField: Option[String] = None,
      queryVersion: Option[String] = None
    ): GetStatisticsRequest =
      GetStatisticsRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(aggregationField)(_.aggregationField(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .build

    def getStatisticsResponse(
      statistics: Option[Statistics] = None
    ): GetStatisticsResponse =
      GetStatisticsResponse
        .builder
        .ifSome(statistics)(_.statistics(_))
        .build

    def getTopicRuleDestinationRequest(
      arn: Option[String] = None
    ): GetTopicRuleDestinationRequest =
      GetTopicRuleDestinationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def getTopicRuleDestinationResponse(
      topicRuleDestination: Option[TopicRuleDestination] = None
    ): GetTopicRuleDestinationResponse =
      GetTopicRuleDestinationResponse
        .builder
        .ifSome(topicRuleDestination)(_.topicRuleDestination(_))
        .build

    def getTopicRuleRequest(
      ruleName: Option[String] = None
    ): GetTopicRuleRequest =
      GetTopicRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .build

    def getTopicRuleResponse(
      ruleArn: Option[String] = None,
      rule: Option[TopicRule] = None
    ): GetTopicRuleResponse =
      GetTopicRuleResponse
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .ifSome(rule)(_.rule(_))
        .build

    def getV2LoggingOptionsRequest(

    ): GetV2LoggingOptionsRequest =
      GetV2LoggingOptionsRequest
        .builder

        .build

    def getV2LoggingOptionsResponse(
      roleArn: Option[String] = None,
      defaultLogLevel: Option[String] = None,
      disableAllLogs: Option[Boolean] = None
    ): GetV2LoggingOptionsResponse =
      GetV2LoggingOptionsResponse
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(defaultLogLevel)(_.defaultLogLevel(_))
        .ifSome(disableAllLogs)(_.disableAllLogs(_))
        .build

    def groupNameAndArn(
      groupName: Option[String] = None,
      groupArn: Option[String] = None
    ): GroupNameAndArn =
      GroupNameAndArn
        .builder
        .ifSome(groupName)(_.groupName(_))
        .ifSome(groupArn)(_.groupArn(_))
        .build

    def httpAction(
      url: Option[String] = None,
      confirmationUrl: Option[String] = None,
      headers: Option[List[HttpActionHeader]] = None,
      auth: Option[HttpAuthorization] = None
    ): HttpAction =
      HttpAction
        .builder
        .ifSome(url)(_.url(_))
        .ifSome(confirmationUrl)(_.confirmationUrl(_))
        .ifSome(headers)(_.headers(_))
        .ifSome(auth)(_.auth(_))
        .build

    def httpActionHeader(
      key: Option[String] = None,
      value: Option[String] = None
    ): HttpActionHeader =
      HttpActionHeader
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(value)(_.value(_))
        .build

    def httpAuthorization(
      sigv4: Option[SigV4Authorization] = None
    ): HttpAuthorization =
      HttpAuthorization
        .builder
        .ifSome(sigv4)(_.sigv4(_))
        .build

    def httpContext(
      headers: Option[HttpHeaders] = None,
      queryString: Option[String] = None
    ): HttpContext =
      HttpContext
        .builder
        .ifSome(headers)(_.headers(_))
        .ifSome(queryString)(_.queryString(_))
        .build

    def httpUrlDestinationConfiguration(
      confirmationUrl: Option[String] = None
    ): HttpUrlDestinationConfiguration =
      HttpUrlDestinationConfiguration
        .builder
        .ifSome(confirmationUrl)(_.confirmationUrl(_))
        .build

    def httpUrlDestinationProperties(
      confirmationUrl: Option[String] = None
    ): HttpUrlDestinationProperties =
      HttpUrlDestinationProperties
        .builder
        .ifSome(confirmationUrl)(_.confirmationUrl(_))
        .build

    def httpUrlDestinationSummary(
      confirmationUrl: Option[String] = None
    ): HttpUrlDestinationSummary =
      HttpUrlDestinationSummary
        .builder
        .ifSome(confirmationUrl)(_.confirmationUrl(_))
        .build

    def implicitDeny(
      policies: Option[List[Policy]] = None
    ): ImplicitDeny =
      ImplicitDeny
        .builder
        .ifSome(policies)(_.policies(_))
        .build

    def indexNotReadyException(
      message: Option[String] = None
    ): IndexNotReadyException =
      IndexNotReadyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalException(
      message: Option[String] = None
    ): InternalException =
      InternalException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def internalFailureException(
      message: Option[String] = None
    ): InternalFailureException =
      InternalFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAggregationException(
      message: Option[String] = None
    ): InvalidAggregationException =
      InvalidAggregationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidQueryException(
      message: Option[String] = None
    ): InvalidQueryException =
      InvalidQueryException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidResponseException(
      message: Option[String] = None
    ): InvalidResponseException =
      InvalidResponseException
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

    def iotAnalyticsAction(
      channelArn: Option[String] = None,
      channelName: Option[String] = None,
      batchMode: Option[Boolean] = None,
      roleArn: Option[String] = None
    ): IotAnalyticsAction =
      IotAnalyticsAction
        .builder
        .ifSome(channelArn)(_.channelArn(_))
        .ifSome(channelName)(_.channelName(_))
        .ifSome(batchMode)(_.batchMode(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def iotEventsAction(
      inputName: Option[String] = None,
      messageId: Option[String] = None,
      batchMode: Option[Boolean] = None,
      roleArn: Option[String] = None
    ): IotEventsAction =
      IotEventsAction
        .builder
        .ifSome(inputName)(_.inputName(_))
        .ifSome(messageId)(_.messageId(_))
        .ifSome(batchMode)(_.batchMode(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def iotSiteWiseAction(
      putAssetPropertyValueEntries: Option[List[PutAssetPropertyValueEntry]] = None,
      roleArn: Option[String] = None
    ): IotSiteWiseAction =
      IotSiteWiseAction
        .builder
        .ifSome(putAssetPropertyValueEntries)(_.putAssetPropertyValueEntries(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def job(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      targetSelection: Option[String] = None,
      status: Option[String] = None,
      forceCanceled: Option[Boolean] = None,
      reasonCode: Option[String] = None,
      comment: Option[String] = None,
      targets: Option[List[TargetArn]] = None,
      description: Option[String] = None,
      presignedUrlConfig: Option[PresignedUrlConfig] = None,
      jobExecutionsRolloutConfig: Option[JobExecutionsRolloutConfig] = None,
      abortConfig: Option[AbortConfig] = None,
      createdAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None,
      completedAt: Option[DateType] = None,
      jobProcessDetails: Option[JobProcessDetails] = None,
      timeoutConfig: Option[TimeoutConfig] = None,
      namespaceId: Option[String] = None,
      jobTemplateArn: Option[String] = None
    ): Job =
      Job
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(targetSelection)(_.targetSelection(_))
        .ifSome(status)(_.status(_))
        .ifSome(forceCanceled)(_.forceCanceled(_))
        .ifSome(reasonCode)(_.reasonCode(_))
        .ifSome(comment)(_.comment(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(description)(_.description(_))
        .ifSome(presignedUrlConfig)(_.presignedUrlConfig(_))
        .ifSome(jobExecutionsRolloutConfig)(_.jobExecutionsRolloutConfig(_))
        .ifSome(abortConfig)(_.abortConfig(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .ifSome(jobProcessDetails)(_.jobProcessDetails(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .ifSome(jobTemplateArn)(_.jobTemplateArn(_))
        .build

    def jobExecution(
      jobId: Option[String] = None,
      status: Option[String] = None,
      forceCanceled: Option[Boolean] = None,
      statusDetails: Option[JobExecutionStatusDetails] = None,
      thingArn: Option[String] = None,
      queuedAt: Option[DateType] = None,
      startedAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None,
      executionNumber: Option[ExecutionNumber] = None,
      versionNumber: Option[VersionNumber] = None,
      approximateSecondsBeforeTimedOut: Option[ApproximateSecondsBeforeTimedOut] = None
    ): JobExecution =
      JobExecution
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(status)(_.status(_))
        .ifSome(forceCanceled)(_.forceCanceled(_))
        .ifSome(statusDetails)(_.statusDetails(_))
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(queuedAt)(_.queuedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .ifSome(versionNumber)(_.versionNumber(_))
        .ifSome(approximateSecondsBeforeTimedOut)(_.approximateSecondsBeforeTimedOut(_))
        .build

    def jobExecutionStatusDetails(
      detailsMap: Option[DetailsMap] = None
    ): JobExecutionStatusDetails =
      JobExecutionStatusDetails
        .builder
        .ifSome(detailsMap)(_.detailsMap(_))
        .build

    def jobExecutionSummary(
      status: Option[String] = None,
      queuedAt: Option[DateType] = None,
      startedAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None,
      executionNumber: Option[ExecutionNumber] = None
    ): JobExecutionSummary =
      JobExecutionSummary
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(queuedAt)(_.queuedAt(_))
        .ifSome(startedAt)(_.startedAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(executionNumber)(_.executionNumber(_))
        .build

    def jobExecutionSummaryForJob(
      thingArn: Option[String] = None,
      jobExecutionSummary: Option[JobExecutionSummary] = None
    ): JobExecutionSummaryForJob =
      JobExecutionSummaryForJob
        .builder
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(jobExecutionSummary)(_.jobExecutionSummary(_))
        .build

    def jobExecutionSummaryForThing(
      jobId: Option[String] = None,
      jobExecutionSummary: Option[JobExecutionSummary] = None
    ): JobExecutionSummaryForThing =
      JobExecutionSummaryForThing
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(jobExecutionSummary)(_.jobExecutionSummary(_))
        .build

    def jobExecutionsRolloutConfig(
      maximumPerMinute: Option[Int] = None,
      exponentialRate: Option[ExponentialRolloutRate] = None
    ): JobExecutionsRolloutConfig =
      JobExecutionsRolloutConfig
        .builder
        .ifSome(maximumPerMinute)(_.maximumPerMinute(_))
        .ifSome(exponentialRate)(_.exponentialRate(_))
        .build

    def jobProcessDetails(
      processingTargets: Option[List[ProcessingTargetName]] = None,
      numberOfCanceledThings: Option[Int] = None,
      numberOfSucceededThings: Option[Int] = None,
      numberOfFailedThings: Option[Int] = None,
      numberOfRejectedThings: Option[Int] = None,
      numberOfQueuedThings: Option[Int] = None,
      numberOfInProgressThings: Option[Int] = None,
      numberOfRemovedThings: Option[Int] = None,
      numberOfTimedOutThings: Option[Int] = None
    ): JobProcessDetails =
      JobProcessDetails
        .builder
        .ifSome(processingTargets)(_.processingTargets(_))
        .ifSome(numberOfCanceledThings)(_.numberOfCanceledThings(_))
        .ifSome(numberOfSucceededThings)(_.numberOfSucceededThings(_))
        .ifSome(numberOfFailedThings)(_.numberOfFailedThings(_))
        .ifSome(numberOfRejectedThings)(_.numberOfRejectedThings(_))
        .ifSome(numberOfQueuedThings)(_.numberOfQueuedThings(_))
        .ifSome(numberOfInProgressThings)(_.numberOfInProgressThings(_))
        .ifSome(numberOfRemovedThings)(_.numberOfRemovedThings(_))
        .ifSome(numberOfTimedOutThings)(_.numberOfTimedOutThings(_))
        .build

    def jobSummary(
      jobArn: Option[String] = None,
      jobId: Option[String] = None,
      thingGroupId: Option[String] = None,
      targetSelection: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None,
      completedAt: Option[DateType] = None
    ): JobSummary =
      JobSummary
        .builder
        .ifSome(jobArn)(_.jobArn(_))
        .ifSome(jobId)(_.jobId(_))
        .ifSome(thingGroupId)(_.thingGroupId(_))
        .ifSome(targetSelection)(_.targetSelection(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(completedAt)(_.completedAt(_))
        .build

    def jobTemplateSummary(
      jobTemplateArn: Option[String] = None,
      jobTemplateId: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[DateType] = None
    ): JobTemplateSummary =
      JobTemplateSummary
        .builder
        .ifSome(jobTemplateArn)(_.jobTemplateArn(_))
        .ifSome(jobTemplateId)(_.jobTemplateId(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .build

    def kafkaAction(
      destinationArn: Option[String] = None,
      topic: Option[String] = None,
      key: Option[String] = None,
      partition: Option[String] = None,
      clientProperties: Option[ClientProperties] = None
    ): KafkaAction =
      KafkaAction
        .builder
        .ifSome(destinationArn)(_.destinationArn(_))
        .ifSome(topic)(_.topic(_))
        .ifSome(key)(_.key(_))
        .ifSome(partition)(_.partition(_))
        .ifSome(clientProperties)(_.clientProperties(_))
        .build

    def keyPair(
      publicKey: Option[String] = None,
      privateKey: Option[String] = None
    ): KeyPair =
      KeyPair
        .builder
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(privateKey)(_.privateKey(_))
        .build

    def kinesisAction(
      roleArn: Option[String] = None,
      streamName: Option[String] = None,
      partitionKey: Option[String] = None
    ): KinesisAction =
      KinesisAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(streamName)(_.streamName(_))
        .ifSome(partitionKey)(_.partitionKey(_))
        .build

    def lambdaAction(
      functionArn: Option[String] = None
    ): LambdaAction =
      LambdaAction
        .builder
        .ifSome(functionArn)(_.functionArn(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listActiveViolationsRequest(
      thingName: Option[String] = None,
      securityProfileName: Option[String] = None,
      behaviorCriteriaType: Option[String] = None,
      listSuppressedAlerts: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListActiveViolationsRequest =
      ListActiveViolationsRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(behaviorCriteriaType)(_.behaviorCriteriaType(_))
        .ifSome(listSuppressedAlerts)(_.listSuppressedAlerts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listActiveViolationsResponse(
      activeViolations: Option[List[ActiveViolation]] = None,
      nextToken: Option[String] = None
    ): ListActiveViolationsResponse =
      ListActiveViolationsResponse
        .builder
        .ifSome(activeViolations)(_.activeViolations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAttachedPoliciesRequest(
      target: Option[String] = None,
      recursive: Option[Boolean] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListAttachedPoliciesRequest =
      ListAttachedPoliciesRequest
        .builder
        .ifSome(target)(_.target(_))
        .ifSome(recursive)(_.recursive(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listAttachedPoliciesResponse(
      policies: Option[List[Policy]] = None,
      nextMarker: Option[String] = None
    ): ListAttachedPoliciesResponse =
      ListAttachedPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listAuditFindingsRequest(
      taskId: Option[String] = None,
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      listSuppressedFindings: Option[Boolean] = None
    ): ListAuditFindingsRequest =
      ListAuditFindingsRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(listSuppressedFindings)(_.listSuppressedFindings(_))
        .build

    def listAuditFindingsResponse(
      findings: Option[List[AuditFinding]] = None,
      nextToken: Option[String] = None
    ): ListAuditFindingsResponse =
      ListAuditFindingsResponse
        .builder
        .ifSome(findings)(_.findings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAuditMitigationActionsExecutionsRequest(
      taskId: Option[String] = None,
      actionStatus: Option[String] = None,
      findingId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListAuditMitigationActionsExecutionsRequest =
      ListAuditMitigationActionsExecutionsRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(actionStatus)(_.actionStatus(_))
        .ifSome(findingId)(_.findingId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAuditMitigationActionsExecutionsResponse(
      actionsExecutions: Option[List[AuditMitigationActionExecutionMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAuditMitigationActionsExecutionsResponse =
      ListAuditMitigationActionsExecutionsResponse
        .builder
        .ifSome(actionsExecutions)(_.actionsExecutions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAuditMitigationActionsTasksRequest(
      auditTaskId: Option[String] = None,
      findingId: Option[String] = None,
      taskStatus: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): ListAuditMitigationActionsTasksRequest =
      ListAuditMitigationActionsTasksRequest
        .builder
        .ifSome(auditTaskId)(_.auditTaskId(_))
        .ifSome(findingId)(_.findingId(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def listAuditMitigationActionsTasksResponse(
      tasks: Option[List[AuditMitigationActionsTaskMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAuditMitigationActionsTasksResponse =
      ListAuditMitigationActionsTasksResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAuditSuppressionsRequest(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      ascendingOrder: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAuditSuppressionsRequest =
      ListAuditSuppressionsRequest
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAuditSuppressionsResponse(
      suppressions: Option[List[AuditSuppression]] = None,
      nextToken: Option[String] = None
    ): ListAuditSuppressionsResponse =
      ListAuditSuppressionsResponse
        .builder
        .ifSome(suppressions)(_.suppressions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAuditTasksRequest(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      taskType: Option[String] = None,
      taskStatus: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListAuditTasksRequest =
      ListAuditTasksRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(taskType)(_.taskType(_))
        .ifSome(taskStatus)(_.taskStatus(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listAuditTasksResponse(
      tasks: Option[List[AuditTaskMetadata]] = None,
      nextToken: Option[String] = None
    ): ListAuditTasksResponse =
      ListAuditTasksResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listAuthorizersRequest(
      pageSize: Option[Int] = None,
      marker: Option[String] = None,
      ascendingOrder: Option[Boolean] = None,
      status: Option[String] = None
    ): ListAuthorizersRequest =
      ListAuthorizersRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .ifSome(status)(_.status(_))
        .build

    def listAuthorizersResponse(
      authorizers: Option[List[AuthorizerSummary]] = None,
      nextMarker: Option[String] = None
    ): ListAuthorizersResponse =
      ListAuthorizersResponse
        .builder
        .ifSome(authorizers)(_.authorizers(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listBillingGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      namePrefixFilter: Option[String] = None
    ): ListBillingGroupsRequest =
      ListBillingGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(namePrefixFilter)(_.namePrefixFilter(_))
        .build

    def listBillingGroupsResponse(
      billingGroups: Option[List[GroupNameAndArn]] = None,
      nextToken: Option[String] = None
    ): ListBillingGroupsResponse =
      ListBillingGroupsResponse
        .builder
        .ifSome(billingGroups)(_.billingGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listCACertificatesRequest(
      pageSize: Option[Int] = None,
      marker: Option[String] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListCACertificatesRequest =
      ListCACertificatesRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listCACertificatesResponse(
      certificates: Option[List[CACertificate]] = None,
      nextMarker: Option[String] = None
    ): ListCACertificatesResponse =
      ListCACertificatesResponse
        .builder
        .ifSome(certificates)(_.certificates(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listCertificatesByCARequest(
      caCertificateId: Option[String] = None,
      pageSize: Option[Int] = None,
      marker: Option[String] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListCertificatesByCARequest =
      ListCertificatesByCARequest
        .builder
        .ifSome(caCertificateId)(_.caCertificateId(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listCertificatesByCAResponse(
      certificates: Option[List[Certificate]] = None,
      nextMarker: Option[String] = None
    ): ListCertificatesByCAResponse =
      ListCertificatesByCAResponse
        .builder
        .ifSome(certificates)(_.certificates(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listCertificatesRequest(
      pageSize: Option[Int] = None,
      marker: Option[String] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListCertificatesRequest =
      ListCertificatesRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listCertificatesResponse(
      certificates: Option[List[Certificate]] = None,
      nextMarker: Option[String] = None
    ): ListCertificatesResponse =
      ListCertificatesResponse
        .builder
        .ifSome(certificates)(_.certificates(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listCustomMetricsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListCustomMetricsRequest =
      ListCustomMetricsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listCustomMetricsResponse(
      metricNames: Option[List[MetricName]] = None,
      nextToken: Option[String] = None
    ): ListCustomMetricsResponse =
      ListCustomMetricsResponse
        .builder
        .ifSome(metricNames)(_.metricNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectMitigationActionsExecutionsRequest(
      taskId: Option[String] = None,
      violationId: Option[String] = None,
      thingName: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListDetectMitigationActionsExecutionsRequest =
      ListDetectMitigationActionsExecutionsRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(violationId)(_.violationId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectMitigationActionsExecutionsResponse(
      actionsExecutions: Option[List[DetectMitigationActionExecution]] = None,
      nextToken: Option[String] = None
    ): ListDetectMitigationActionsExecutionsResponse =
      ListDetectMitigationActionsExecutionsResponse
        .builder
        .ifSome(actionsExecutions)(_.actionsExecutions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDetectMitigationActionsTasksRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): ListDetectMitigationActionsTasksRequest =
      ListDetectMitigationActionsTasksRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def listDetectMitigationActionsTasksResponse(
      tasks: Option[List[DetectMitigationActionsTaskSummary]] = None,
      nextToken: Option[String] = None
    ): ListDetectMitigationActionsTasksResponse =
      ListDetectMitigationActionsTasksResponse
        .builder
        .ifSome(tasks)(_.tasks(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDimensionsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListDimensionsRequest =
      ListDimensionsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listDimensionsResponse(
      dimensionNames: Option[List[DimensionName]] = None,
      nextToken: Option[String] = None
    ): ListDimensionsResponse =
      ListDimensionsResponse
        .builder
        .ifSome(dimensionNames)(_.dimensionNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listDomainConfigurationsRequest(
      marker: Option[String] = None,
      pageSize: Option[Int] = None,
      serviceType: Option[String] = None
    ): ListDomainConfigurationsRequest =
      ListDomainConfigurationsRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(serviceType)(_.serviceType(_))
        .build

    def listDomainConfigurationsResponse(
      domainConfigurations: Option[List[DomainConfigurationSummary]] = None,
      nextMarker: Option[String] = None
    ): ListDomainConfigurationsResponse =
      ListDomainConfigurationsResponse
        .builder
        .ifSome(domainConfigurations)(_.domainConfigurations(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listIndicesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListIndicesRequest =
      ListIndicesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listIndicesResponse(
      indexNames: Option[List[IndexName]] = None,
      nextToken: Option[String] = None
    ): ListIndicesResponse =
      ListIndicesResponse
        .builder
        .ifSome(indexNames)(_.indexNames(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobExecutionsForJobRequest(
      jobId: Option[String] = None,
      status: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobExecutionsForJobRequest =
      ListJobExecutionsForJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(status)(_.status(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobExecutionsForJobResponse(
      executionSummaries: Option[List[JobExecutionSummaryForJob]] = None,
      nextToken: Option[String] = None
    ): ListJobExecutionsForJobResponse =
      ListJobExecutionsForJobResponse
        .builder
        .ifSome(executionSummaries)(_.executionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobExecutionsForThingRequest(
      thingName: Option[String] = None,
      status: Option[String] = None,
      namespaceId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobExecutionsForThingRequest =
      ListJobExecutionsForThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(status)(_.status(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobExecutionsForThingResponse(
      executionSummaries: Option[List[JobExecutionSummaryForThing]] = None,
      nextToken: Option[String] = None
    ): ListJobExecutionsForThingResponse =
      ListJobExecutionsForThingResponse
        .builder
        .ifSome(executionSummaries)(_.executionSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobTemplatesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListJobTemplatesRequest =
      ListJobTemplatesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobTemplatesResponse(
      jobTemplates: Option[List[JobTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): ListJobTemplatesResponse =
      ListJobTemplatesResponse
        .builder
        .ifSome(jobTemplates)(_.jobTemplates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listJobsRequest(
      status: Option[String] = None,
      targetSelection: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      thingGroupName: Option[String] = None,
      thingGroupId: Option[String] = None,
      namespaceId: Option[String] = None
    ): ListJobsRequest =
      ListJobsRequest
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(targetSelection)(_.targetSelection(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupId)(_.thingGroupId(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .build

    def listJobsResponse(
      jobs: Option[List[JobSummary]] = None,
      nextToken: Option[String] = None
    ): ListJobsResponse =
      ListJobsResponse
        .builder
        .ifSome(jobs)(_.jobs(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMitigationActionsRequest(
      actionType: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListMitigationActionsRequest =
      ListMitigationActionsRequest
        .builder
        .ifSome(actionType)(_.actionType(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listMitigationActionsResponse(
      actionIdentifiers: Option[List[MitigationActionIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListMitigationActionsResponse =
      ListMitigationActionsResponse
        .builder
        .ifSome(actionIdentifiers)(_.actionIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOTAUpdatesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      otaUpdateStatus: Option[String] = None
    ): ListOTAUpdatesRequest =
      ListOTAUpdatesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(otaUpdateStatus)(_.otaUpdateStatus(_))
        .build

    def listOTAUpdatesResponse(
      otaUpdates: Option[List[OTAUpdateSummary]] = None,
      nextToken: Option[String] = None
    ): ListOTAUpdatesResponse =
      ListOTAUpdatesResponse
        .builder
        .ifSome(otaUpdates)(_.otaUpdates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listOutgoingCertificatesRequest(
      pageSize: Option[Int] = None,
      marker: Option[String] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListOutgoingCertificatesRequest =
      ListOutgoingCertificatesRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listOutgoingCertificatesResponse(
      outgoingCertificates: Option[List[OutgoingCertificate]] = None,
      nextMarker: Option[String] = None
    ): ListOutgoingCertificatesResponse =
      ListOutgoingCertificatesResponse
        .builder
        .ifSome(outgoingCertificates)(_.outgoingCertificates(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listPoliciesRequest(
      marker: Option[String] = None,
      pageSize: Option[Int] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListPoliciesRequest =
      ListPoliciesRequest
        .builder
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listPoliciesResponse(
      policies: Option[List[Policy]] = None,
      nextMarker: Option[String] = None
    ): ListPoliciesResponse =
      ListPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listPolicyPrincipalsRequest(
      policyName: Option[String] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListPolicyPrincipalsRequest =
      ListPolicyPrincipalsRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listPolicyPrincipalsResponse(
      principals: Option[List[PrincipalArn]] = None,
      nextMarker: Option[String] = None
    ): ListPolicyPrincipalsResponse =
      ListPolicyPrincipalsResponse
        .builder
        .ifSome(principals)(_.principals(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listPolicyVersionsRequest(
      policyName: Option[String] = None
    ): ListPolicyVersionsRequest =
      ListPolicyVersionsRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .build

    def listPolicyVersionsResponse(
      policyVersions: Option[List[PolicyVersion]] = None
    ): ListPolicyVersionsResponse =
      ListPolicyVersionsResponse
        .builder
        .ifSome(policyVersions)(_.policyVersions(_))
        .build

    def listPrincipalPoliciesRequest(
      principal: Option[String] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListPrincipalPoliciesRequest =
      ListPrincipalPoliciesRequest
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listPrincipalPoliciesResponse(
      policies: Option[List[Policy]] = None,
      nextMarker: Option[String] = None
    ): ListPrincipalPoliciesResponse =
      ListPrincipalPoliciesResponse
        .builder
        .ifSome(policies)(_.policies(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listPrincipalThingsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      principal: Option[String] = None
    ): ListPrincipalThingsRequest =
      ListPrincipalThingsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(principal)(_.principal(_))
        .build

    def listPrincipalThingsResponse(
      things: Option[List[ThingName]] = None,
      nextToken: Option[String] = None
    ): ListPrincipalThingsResponse =
      ListPrincipalThingsResponse
        .builder
        .ifSome(things)(_.things(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProvisioningTemplateVersionsRequest(
      templateName: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProvisioningTemplateVersionsRequest =
      ListProvisioningTemplateVersionsRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProvisioningTemplateVersionsResponse(
      versions: Option[List[ProvisioningTemplateVersionSummary]] = None,
      nextToken: Option[String] = None
    ): ListProvisioningTemplateVersionsResponse =
      ListProvisioningTemplateVersionsResponse
        .builder
        .ifSome(versions)(_.versions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProvisioningTemplatesRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListProvisioningTemplatesRequest =
      ListProvisioningTemplatesRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listProvisioningTemplatesResponse(
      templates: Option[List[ProvisioningTemplateSummary]] = None,
      nextToken: Option[String] = None
    ): ListProvisioningTemplatesResponse =
      ListProvisioningTemplatesResponse
        .builder
        .ifSome(templates)(_.templates(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listRoleAliasesRequest(
      pageSize: Option[Int] = None,
      marker: Option[String] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListRoleAliasesRequest =
      ListRoleAliasesRequest
        .builder
        .ifSome(pageSize)(_.pageSize(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listRoleAliasesResponse(
      roleAliases: Option[List[RoleAlias]] = None,
      nextMarker: Option[String] = None
    ): ListRoleAliasesResponse =
      ListRoleAliasesResponse
        .builder
        .ifSome(roleAliases)(_.roleAliases(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listScheduledAuditsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListScheduledAuditsRequest =
      ListScheduledAuditsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listScheduledAuditsResponse(
      scheduledAudits: Option[List[ScheduledAuditMetadata]] = None,
      nextToken: Option[String] = None
    ): ListScheduledAuditsResponse =
      ListScheduledAuditsResponse
        .builder
        .ifSome(scheduledAudits)(_.scheduledAudits(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSecurityProfilesForTargetRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      recursive: Option[Boolean] = None,
      securityProfileTargetArn: Option[String] = None
    ): ListSecurityProfilesForTargetRequest =
      ListSecurityProfilesForTargetRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(recursive)(_.recursive(_))
        .ifSome(securityProfileTargetArn)(_.securityProfileTargetArn(_))
        .build

    def listSecurityProfilesForTargetResponse(
      securityProfileTargetMappings: Option[List[SecurityProfileTargetMapping]] = None,
      nextToken: Option[String] = None
    ): ListSecurityProfilesForTargetResponse =
      ListSecurityProfilesForTargetResponse
        .builder
        .ifSome(securityProfileTargetMappings)(_.securityProfileTargetMappings(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listSecurityProfilesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      dimensionName: Option[String] = None,
      metricName: Option[String] = None
    ): ListSecurityProfilesRequest =
      ListSecurityProfilesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(dimensionName)(_.dimensionName(_))
        .ifSome(metricName)(_.metricName(_))
        .build

    def listSecurityProfilesResponse(
      securityProfileIdentifiers: Option[List[SecurityProfileIdentifier]] = None,
      nextToken: Option[String] = None
    ): ListSecurityProfilesResponse =
      ListSecurityProfilesResponse
        .builder
        .ifSome(securityProfileIdentifiers)(_.securityProfileIdentifiers(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listStreamsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      ascendingOrder: Option[Boolean] = None
    ): ListStreamsRequest =
      ListStreamsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(ascendingOrder)(_.ascendingOrder(_))
        .build

    def listStreamsResponse(
      streams: Option[List[StreamSummary]] = None,
      nextToken: Option[String] = None
    ): ListStreamsResponse =
      ListStreamsResponse
        .builder
        .ifSome(streams)(_.streams(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsForResourceRequest(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsForResourceRequest =
      ListTagsForResourceRequest
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
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

    def listTargetsForPolicyRequest(
      policyName: Option[String] = None,
      marker: Option[String] = None,
      pageSize: Option[Int] = None
    ): ListTargetsForPolicyRequest =
      ListTargetsForPolicyRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(pageSize)(_.pageSize(_))
        .build

    def listTargetsForPolicyResponse(
      targets: Option[List[PolicyTarget]] = None,
      nextMarker: Option[String] = None
    ): ListTargetsForPolicyResponse =
      ListTargetsForPolicyResponse
        .builder
        .ifSome(targets)(_.targets(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .build

    def listTargetsForSecurityProfileRequest(
      securityProfileName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListTargetsForSecurityProfileRequest =
      ListTargetsForSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listTargetsForSecurityProfileResponse(
      securityProfileTargets: Option[List[SecurityProfileTarget]] = None,
      nextToken: Option[String] = None
    ): ListTargetsForSecurityProfileResponse =
      ListTargetsForSecurityProfileResponse
        .builder
        .ifSome(securityProfileTargets)(_.securityProfileTargets(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingGroupsForThingRequest(
      thingName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThingGroupsForThingRequest =
      ListThingGroupsForThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThingGroupsForThingResponse(
      thingGroups: Option[List[GroupNameAndArn]] = None,
      nextToken: Option[String] = None
    ): ListThingGroupsForThingResponse =
      ListThingGroupsForThingResponse
        .builder
        .ifSome(thingGroups)(_.thingGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingGroupsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      parentGroup: Option[String] = None,
      namePrefixFilter: Option[String] = None,
      recursive: Option[Boolean] = None
    ): ListThingGroupsRequest =
      ListThingGroupsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(parentGroup)(_.parentGroup(_))
        .ifSome(namePrefixFilter)(_.namePrefixFilter(_))
        .ifSome(recursive)(_.recursive(_))
        .build

    def listThingGroupsResponse(
      thingGroups: Option[List[GroupNameAndArn]] = None,
      nextToken: Option[String] = None
    ): ListThingGroupsResponse =
      ListThingGroupsResponse
        .builder
        .ifSome(thingGroups)(_.thingGroups(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingPrincipalsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      thingName: Option[String] = None
    ): ListThingPrincipalsRequest =
      ListThingPrincipalsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(thingName)(_.thingName(_))
        .build

    def listThingPrincipalsResponse(
      principals: Option[List[PrincipalArn]] = None,
      nextToken: Option[String] = None
    ): ListThingPrincipalsResponse =
      ListThingPrincipalsResponse
        .builder
        .ifSome(principals)(_.principals(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingRegistrationTaskReportsRequest(
      taskId: Option[String] = None,
      reportType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThingRegistrationTaskReportsRequest =
      ListThingRegistrationTaskReportsRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(reportType)(_.reportType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThingRegistrationTaskReportsResponse(
      resourceLinks: Option[List[S3FileUrl]] = None,
      reportType: Option[String] = None,
      nextToken: Option[String] = None
    ): ListThingRegistrationTaskReportsResponse =
      ListThingRegistrationTaskReportsResponse
        .builder
        .ifSome(resourceLinks)(_.resourceLinks(_))
        .ifSome(reportType)(_.reportType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingRegistrationTasksRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      status: Option[String] = None
    ): ListThingRegistrationTasksRequest =
      ListThingRegistrationTasksRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(status)(_.status(_))
        .build

    def listThingRegistrationTasksResponse(
      taskIds: Option[List[TaskId]] = None,
      nextToken: Option[String] = None
    ): ListThingRegistrationTasksResponse =
      ListThingRegistrationTasksResponse
        .builder
        .ifSome(taskIds)(_.taskIds(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingTypesRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      thingTypeName: Option[String] = None
    ): ListThingTypesRequest =
      ListThingTypesRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .build

    def listThingTypesResponse(
      thingTypes: Option[List[ThingTypeDefinition]] = None,
      nextToken: Option[String] = None
    ): ListThingTypesResponse =
      ListThingTypesResponse
        .builder
        .ifSome(thingTypes)(_.thingTypes(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingsInBillingGroupRequest(
      billingGroupName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThingsInBillingGroupRequest =
      ListThingsInBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThingsInBillingGroupResponse(
      things: Option[List[ThingName]] = None,
      nextToken: Option[String] = None
    ): ListThingsInBillingGroupResponse =
      ListThingsInBillingGroupResponse
        .builder
        .ifSome(things)(_.things(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingsInThingGroupRequest(
      thingGroupName: Option[String] = None,
      recursive: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListThingsInThingGroupRequest =
      ListThingsInThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(recursive)(_.recursive(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listThingsInThingGroupResponse(
      things: Option[List[ThingName]] = None,
      nextToken: Option[String] = None
    ): ListThingsInThingGroupResponse =
      ListThingsInThingGroupResponse
        .builder
        .ifSome(things)(_.things(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listThingsRequest(
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      attributeName: Option[String] = None,
      attributeValue: Option[String] = None,
      thingTypeName: Option[String] = None,
      usePrefixAttributeValue: Option[Boolean] = None
    ): ListThingsRequest =
      ListThingsRequest
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeValue)(_.attributeValue(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(usePrefixAttributeValue)(_.usePrefixAttributeValue(_))
        .build

    def listThingsResponse(
      things: Option[List[ThingAttribute]] = None,
      nextToken: Option[String] = None
    ): ListThingsResponse =
      ListThingsResponse
        .builder
        .ifSome(things)(_.things(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTopicRuleDestinationsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListTopicRuleDestinationsRequest =
      ListTopicRuleDestinationsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTopicRuleDestinationsResponse(
      destinationSummaries: Option[List[TopicRuleDestinationSummary]] = None,
      nextToken: Option[String] = None
    ): ListTopicRuleDestinationsResponse =
      ListTopicRuleDestinationsResponse
        .builder
        .ifSome(destinationSummaries)(_.destinationSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTopicRulesRequest(
      topic: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      ruleDisabled: Option[Boolean] = None
    ): ListTopicRulesRequest =
      ListTopicRulesRequest
        .builder
        .ifSome(topic)(_.topic(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(ruleDisabled)(_.ruleDisabled(_))
        .build

    def listTopicRulesResponse(
      rules: Option[List[TopicRuleListItem]] = None,
      nextToken: Option[String] = None
    ): ListTopicRulesResponse =
      ListTopicRulesResponse
        .builder
        .ifSome(rules)(_.rules(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listV2LoggingLevelsRequest(
      targetType: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListV2LoggingLevelsRequest =
      ListV2LoggingLevelsRequest
        .builder
        .ifSome(targetType)(_.targetType(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listV2LoggingLevelsResponse(
      logTargetConfigurations: Option[List[LogTargetConfiguration]] = None,
      nextToken: Option[String] = None
    ): ListV2LoggingLevelsResponse =
      ListV2LoggingLevelsResponse
        .builder
        .ifSome(logTargetConfigurations)(_.logTargetConfigurations(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listViolationEventsRequest(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None,
      thingName: Option[String] = None,
      securityProfileName: Option[String] = None,
      behaviorCriteriaType: Option[String] = None,
      listSuppressedAlerts: Option[Boolean] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListViolationEventsRequest =
      ListViolationEventsRequest
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(behaviorCriteriaType)(_.behaviorCriteriaType(_))
        .ifSome(listSuppressedAlerts)(_.listSuppressedAlerts(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listViolationEventsResponse(
      violationEvents: Option[List[ViolationEvent]] = None,
      nextToken: Option[String] = None
    ): ListViolationEventsResponse =
      ListViolationEventsResponse
        .builder
        .ifSome(violationEvents)(_.violationEvents(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def logTarget(
      targetType: Option[String] = None,
      targetName: Option[String] = None
    ): LogTarget =
      LogTarget
        .builder
        .ifSome(targetType)(_.targetType(_))
        .ifSome(targetName)(_.targetName(_))
        .build

    def logTargetConfiguration(
      logTarget: Option[LogTarget] = None,
      logLevel: Option[String] = None
    ): LogTargetConfiguration =
      LogTargetConfiguration
        .builder
        .ifSome(logTarget)(_.logTarget(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def loggingOptionsPayload(
      roleArn: Option[String] = None,
      logLevel: Option[String] = None
    ): LoggingOptionsPayload =
      LoggingOptionsPayload
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def machineLearningDetectionConfig(
      confidenceLevel: Option[String] = None
    ): MachineLearningDetectionConfig =
      MachineLearningDetectionConfig
        .builder
        .ifSome(confidenceLevel)(_.confidenceLevel(_))
        .build

    def malformedPolicyException(
      message: Option[String] = None
    ): MalformedPolicyException =
      MalformedPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def metricDimension(
      dimensionName: Option[String] = None,
      operator: Option[String] = None
    ): MetricDimension =
      MetricDimension
        .builder
        .ifSome(dimensionName)(_.dimensionName(_))
        .ifSome(operator)(_.operator(_))
        .build

    def metricToRetain(
      metric: Option[String] = None,
      metricDimension: Option[MetricDimension] = None
    ): MetricToRetain =
      MetricToRetain
        .builder
        .ifSome(metric)(_.metric(_))
        .ifSome(metricDimension)(_.metricDimension(_))
        .build

    def metricValue(
      count: Option[UnsignedLong] = None,
      cidrs: Option[List[Cidr]] = None,
      ports: Option[List[Port]] = None,
      number: Option[Number] = None,
      numbers: Option[List[Number]] = None,
      strings: Option[List[stringValue]] = None
    ): MetricValue =
      MetricValue
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(cidrs)(_.cidrs(_))
        .ifSome(ports)(_.ports(_))
        .ifSome(number)(_.number(_))
        .ifSome(numbers)(_.numbers(_))
        .ifSome(strings)(_.strings(_))
        .build

    def mitigationAction(
      name: Option[String] = None,
      id: Option[String] = None,
      roleArn: Option[String] = None,
      actionParams: Option[MitigationActionParams] = None
    ): MitigationAction =
      MitigationAction
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(id)(_.id(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(actionParams)(_.actionParams(_))
        .build

    def mitigationActionIdentifier(
      actionName: Option[String] = None,
      actionArn: Option[String] = None,
      creationDate: Option[Timestamp] = None
    ): MitigationActionIdentifier =
      MitigationActionIdentifier
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(actionArn)(_.actionArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def mitigationActionParams(
      updateDeviceCertificateParams: Option[UpdateDeviceCertificateParams] = None,
      updateCACertificateParams: Option[UpdateCACertificateParams] = None,
      addThingsToThingGroupParams: Option[AddThingsToThingGroupParams] = None,
      replaceDefaultPolicyVersionParams: Option[ReplaceDefaultPolicyVersionParams] = None,
      enableIoTLoggingParams: Option[EnableIoTLoggingParams] = None,
      publishFindingToSnsParams: Option[PublishFindingToSnsParams] = None
    ): MitigationActionParams =
      MitigationActionParams
        .builder
        .ifSome(updateDeviceCertificateParams)(_.updateDeviceCertificateParams(_))
        .ifSome(updateCACertificateParams)(_.updateCACertificateParams(_))
        .ifSome(addThingsToThingGroupParams)(_.addThingsToThingGroupParams(_))
        .ifSome(replaceDefaultPolicyVersionParams)(_.replaceDefaultPolicyVersionParams(_))
        .ifSome(enableIoTLoggingParams)(_.enableIoTLoggingParams(_))
        .ifSome(publishFindingToSnsParams)(_.publishFindingToSnsParams(_))
        .build

    def mqttContext(
      username: Option[String] = None,
      password: Option[MqttPassword] = None,
      clientId: Option[String] = None
    ): MqttContext =
      MqttContext
        .builder
        .ifSome(username)(_.username(_))
        .ifSome(password)(_.password(_))
        .ifSome(clientId)(_.clientId(_))
        .build

    def nonCompliantResource(
      resourceType: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      additionalInfo: Option[StringMap] = None
    ): NonCompliantResource =
      NonCompliantResource
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .build

    def notConfiguredException(
      message: Option[String] = None
    ): NotConfiguredException =
      NotConfiguredException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def oTAUpdateFile(
      fileName: Option[String] = None,
      fileType: Option[Int] = None,
      fileVersion: Option[String] = None,
      fileLocation: Option[FileLocation] = None,
      codeSigning: Option[CodeSigning] = None,
      attributes: Option[AttributesMap] = None
    ): OTAUpdateFile =
      OTAUpdateFile
        .builder
        .ifSome(fileName)(_.fileName(_))
        .ifSome(fileType)(_.fileType(_))
        .ifSome(fileVersion)(_.fileVersion(_))
        .ifSome(fileLocation)(_.fileLocation(_))
        .ifSome(codeSigning)(_.codeSigning(_))
        .ifSome(attributes)(_.attributes(_))
        .build

    def oTAUpdateInfo(
      otaUpdateId: Option[String] = None,
      otaUpdateArn: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      description: Option[String] = None,
      targets: Option[List[Target]] = None,
      protocols: Option[List[Protocol]] = None,
      awsJobExecutionsRolloutConfig: Option[AwsJobExecutionsRolloutConfig] = None,
      awsJobPresignedUrlConfig: Option[AwsJobPresignedUrlConfig] = None,
      targetSelection: Option[String] = None,
      otaUpdateFiles: Option[List[OTAUpdateFile]] = None,
      otaUpdateStatus: Option[String] = None,
      awsIotJobId: Option[String] = None,
      awsIotJobArn: Option[String] = None,
      errorInfo: Option[ErrorInfo] = None,
      additionalParameters: Option[AdditionalParameterMap] = None
    ): OTAUpdateInfo =
      OTAUpdateInfo
        .builder
        .ifSome(otaUpdateId)(_.otaUpdateId(_))
        .ifSome(otaUpdateArn)(_.otaUpdateArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(description)(_.description(_))
        .ifSome(targets)(_.targets(_))
        .ifSome(protocols)(_.protocols(_))
        .ifSome(awsJobExecutionsRolloutConfig)(_.awsJobExecutionsRolloutConfig(_))
        .ifSome(awsJobPresignedUrlConfig)(_.awsJobPresignedUrlConfig(_))
        .ifSome(targetSelection)(_.targetSelection(_))
        .ifSome(otaUpdateFiles)(_.otaUpdateFiles(_))
        .ifSome(otaUpdateStatus)(_.otaUpdateStatus(_))
        .ifSome(awsIotJobId)(_.awsIotJobId(_))
        .ifSome(awsIotJobArn)(_.awsIotJobArn(_))
        .ifSome(errorInfo)(_.errorInfo(_))
        .ifSome(additionalParameters)(_.additionalParameters(_))
        .build

    def oTAUpdateSummary(
      otaUpdateId: Option[String] = None,
      otaUpdateArn: Option[String] = None,
      creationDate: Option[DateType] = None
    ): OTAUpdateSummary =
      OTAUpdateSummary
        .builder
        .ifSome(otaUpdateId)(_.otaUpdateId(_))
        .ifSome(otaUpdateArn)(_.otaUpdateArn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def outgoingCertificate(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None,
      transferredTo: Option[String] = None,
      transferDate: Option[DateType] = None,
      transferMessage: Option[String] = None,
      creationDate: Option[DateType] = None
    ): OutgoingCertificate =
      OutgoingCertificate
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(transferredTo)(_.transferredTo(_))
        .ifSome(transferDate)(_.transferDate(_))
        .ifSome(transferMessage)(_.transferMessage(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def percentPair(
      percent: Option[Percent] = None,
      value: Option[PercentValue] = None
    ): PercentPair =
      PercentPair
        .builder
        .ifSome(percent)(_.percent(_))
        .ifSome(value)(_.value(_))
        .build

    def policy(
      policyName: Option[String] = None,
      policyArn: Option[String] = None
    ): Policy =
      Policy
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyArn)(_.policyArn(_))
        .build

    def policyVersion(
      versionId: Option[String] = None,
      isDefaultVersion: Option[Boolean] = None,
      createDate: Option[DateType] = None
    ): PolicyVersion =
      PolicyVersion
        .builder
        .ifSome(versionId)(_.versionId(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .ifSome(createDate)(_.createDate(_))
        .build

    def policyVersionIdentifier(
      policyName: Option[String] = None,
      policyVersionId: Option[String] = None
    ): PolicyVersionIdentifier =
      PolicyVersionIdentifier
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .build

    def presignedUrlConfig(
      roleArn: Option[String] = None,
      expiresInSec: Option[ExpiresInSec] = None
    ): PresignedUrlConfig =
      PresignedUrlConfig
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(expiresInSec)(_.expiresInSec(_))
        .build

    def provisioningHook(
      payloadVersion: Option[String] = None,
      targetArn: Option[String] = None
    ): ProvisioningHook =
      ProvisioningHook
        .builder
        .ifSome(payloadVersion)(_.payloadVersion(_))
        .ifSome(targetArn)(_.targetArn(_))
        .build

    def provisioningTemplateSummary(
      templateArn: Option[String] = None,
      templateName: Option[String] = None,
      description: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None,
      enabled: Option[Boolean] = None
    ): ProvisioningTemplateSummary =
      ProvisioningTemplateSummary
        .builder
        .ifSome(templateArn)(_.templateArn(_))
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .ifSome(enabled)(_.enabled(_))
        .build

    def provisioningTemplateVersionSummary(
      versionId: Option[Int] = None,
      creationDate: Option[DateType] = None,
      isDefaultVersion: Option[Boolean] = None
    ): ProvisioningTemplateVersionSummary =
      ProvisioningTemplateVersionSummary
        .builder
        .ifSome(versionId)(_.versionId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(isDefaultVersion)(_.isDefaultVersion(_))
        .build

    def publishFindingToSnsParams(
      topicArn: Option[String] = None
    ): PublishFindingToSnsParams =
      PublishFindingToSnsParams
        .builder
        .ifSome(topicArn)(_.topicArn(_))
        .build

    def putAssetPropertyValueEntry(
      entryId: Option[String] = None,
      assetId: Option[String] = None,
      propertyId: Option[String] = None,
      propertyAlias: Option[String] = None,
      propertyValues: Option[List[AssetPropertyValue]] = None
    ): PutAssetPropertyValueEntry =
      PutAssetPropertyValueEntry
        .builder
        .ifSome(entryId)(_.entryId(_))
        .ifSome(assetId)(_.assetId(_))
        .ifSome(propertyId)(_.propertyId(_))
        .ifSome(propertyAlias)(_.propertyAlias(_))
        .ifSome(propertyValues)(_.propertyValues(_))
        .build

    def putItemInput(
      tableName: Option[String] = None
    ): PutItemInput =
      PutItemInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def rateIncreaseCriteria(
      numberOfNotifiedThings: Option[Int] = None,
      numberOfSucceededThings: Option[Int] = None
    ): RateIncreaseCriteria =
      RateIncreaseCriteria
        .builder
        .ifSome(numberOfNotifiedThings)(_.numberOfNotifiedThings(_))
        .ifSome(numberOfSucceededThings)(_.numberOfSucceededThings(_))
        .build

    def registerCACertificateRequest(
      caCertificate: Option[String] = None,
      verificationCertificate: Option[String] = None,
      setAsActive: Option[Boolean] = None,
      allowAutoRegistration: Option[Boolean] = None,
      registrationConfig: Option[RegistrationConfig] = None,
      tags: Option[List[Tag]] = None
    ): RegisterCACertificateRequest =
      RegisterCACertificateRequest
        .builder
        .ifSome(caCertificate)(_.caCertificate(_))
        .ifSome(verificationCertificate)(_.verificationCertificate(_))
        .ifSome(setAsActive)(_.setAsActive(_))
        .ifSome(allowAutoRegistration)(_.allowAutoRegistration(_))
        .ifSome(registrationConfig)(_.registrationConfig(_))
        .ifSome(tags)(_.tags(_))
        .build

    def registerCACertificateResponse(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None
    ): RegisterCACertificateResponse =
      RegisterCACertificateResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def registerCertificateRequest(
      certificatePem: Option[String] = None,
      caCertificatePem: Option[String] = None,
      setAsActive: Option[Boolean] = None,
      status: Option[String] = None
    ): RegisterCertificateRequest =
      RegisterCertificateRequest
        .builder
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(caCertificatePem)(_.caCertificatePem(_))
        .ifSome(setAsActive)(_.setAsActive(_))
        .ifSome(status)(_.status(_))
        .build

    def registerCertificateResponse(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None
    ): RegisterCertificateResponse =
      RegisterCertificateResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def registerCertificateWithoutCARequest(
      certificatePem: Option[String] = None,
      status: Option[String] = None
    ): RegisterCertificateWithoutCARequest =
      RegisterCertificateWithoutCARequest
        .builder
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(status)(_.status(_))
        .build

    def registerCertificateWithoutCAResponse(
      certificateArn: Option[String] = None,
      certificateId: Option[String] = None
    ): RegisterCertificateWithoutCAResponse =
      RegisterCertificateWithoutCAResponse
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(certificateId)(_.certificateId(_))
        .build

    def registerThingRequest(
      templateBody: Option[String] = None,
      parameters: Option[Parameters] = None
    ): RegisterThingRequest =
      RegisterThingRequest
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def registerThingResponse(
      certificatePem: Option[String] = None,
      resourceArns: Option[ResourceArns] = None
    ): RegisterThingResponse =
      RegisterThingResponse
        .builder
        .ifSome(certificatePem)(_.certificatePem(_))
        .ifSome(resourceArns)(_.resourceArns(_))
        .build

    def registrationCodeValidationException(
      message: Option[String] = None
    ): RegistrationCodeValidationException =
      RegistrationCodeValidationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def registrationConfig(
      templateBody: Option[String] = None,
      roleArn: Option[String] = None
    ): RegistrationConfig =
      RegistrationConfig
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def rejectCertificateTransferRequest(
      certificateId: Option[String] = None,
      rejectReason: Option[String] = None
    ): RejectCertificateTransferRequest =
      RejectCertificateTransferRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(rejectReason)(_.rejectReason(_))
        .build

    def relatedResource(
      resourceType: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      additionalInfo: Option[StringMap] = None
    ): RelatedResource =
      RelatedResource
        .builder
        .ifSome(resourceType)(_.resourceType(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(additionalInfo)(_.additionalInfo(_))
        .build

    def removeThingFromBillingGroupRequest(
      billingGroupName: Option[String] = None,
      billingGroupArn: Option[String] = None,
      thingName: Option[String] = None,
      thingArn: Option[String] = None
    ): RemoveThingFromBillingGroupRequest =
      RemoveThingFromBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(billingGroupArn)(_.billingGroupArn(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def removeThingFromBillingGroupResponse(

    ): RemoveThingFromBillingGroupResponse =
      RemoveThingFromBillingGroupResponse
        .builder

        .build

    def removeThingFromThingGroupRequest(
      thingGroupName: Option[String] = None,
      thingGroupArn: Option[String] = None,
      thingName: Option[String] = None,
      thingArn: Option[String] = None
    ): RemoveThingFromThingGroupRequest =
      RemoveThingFromThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupArn)(_.thingGroupArn(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .build

    def removeThingFromThingGroupResponse(

    ): RemoveThingFromThingGroupResponse =
      RemoveThingFromThingGroupResponse
        .builder

        .build

    def replaceDefaultPolicyVersionParams(
      templateName: Option[String] = None
    ): ReplaceDefaultPolicyVersionParams =
      ReplaceDefaultPolicyVersionParams
        .builder
        .ifSome(templateName)(_.templateName(_))
        .build

    def replaceTopicRuleRequest(
      ruleName: Option[String] = None,
      topicRulePayload: Option[TopicRulePayload] = None
    ): ReplaceTopicRuleRequest =
      ReplaceTopicRuleRequest
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(topicRulePayload)(_.topicRulePayload(_))
        .build

    def republishAction(
      roleArn: Option[String] = None,
      topic: Option[String] = None,
      qos: Option[Int] = None
    ): RepublishAction =
      RepublishAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(topic)(_.topic(_))
        .ifSome(qos)(_.qos(_))
        .build

    def resourceAlreadyExistsException(
      message: Option[String] = None,
      resourceId: Option[String] = None,
      resourceArn: Option[String] = None
    ): ResourceAlreadyExistsException =
      ResourceAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(resourceId)(_.resourceId(_))
        .ifSome(resourceArn)(_.resourceArn(_))
        .build

    def resourceIdentifier(
      deviceCertificateId: Option[String] = None,
      caCertificateId: Option[String] = None,
      cognitoIdentityPoolId: Option[String] = None,
      clientId: Option[String] = None,
      policyVersionIdentifier: Option[PolicyVersionIdentifier] = None,
      account: Option[String] = None,
      iamRoleArn: Option[String] = None,
      roleAliasArn: Option[String] = None
    ): ResourceIdentifier =
      ResourceIdentifier
        .builder
        .ifSome(deviceCertificateId)(_.deviceCertificateId(_))
        .ifSome(caCertificateId)(_.caCertificateId(_))
        .ifSome(cognitoIdentityPoolId)(_.cognitoIdentityPoolId(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(policyVersionIdentifier)(_.policyVersionIdentifier(_))
        .ifSome(account)(_.account(_))
        .ifSome(iamRoleArn)(_.iamRoleArn(_))
        .ifSome(roleAliasArn)(_.roleAliasArn(_))
        .build

    def resourceNotFoundException(
      message: Option[String] = None
    ): ResourceNotFoundException =
      ResourceNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceRegistrationFailureException(
      message: Option[String] = None
    ): ResourceRegistrationFailureException =
      ResourceRegistrationFailureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def roleAliasDescription(
      roleAlias: Option[String] = None,
      roleAliasArn: Option[String] = None,
      roleArn: Option[String] = None,
      owner: Option[String] = None,
      credentialDurationSeconds: Option[Int] = None,
      creationDate: Option[DateType] = None,
      lastModifiedDate: Option[DateType] = None
    ): RoleAliasDescription =
      RoleAliasDescription
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .ifSome(roleAliasArn)(_.roleAliasArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(owner)(_.owner(_))
        .ifSome(credentialDurationSeconds)(_.credentialDurationSeconds(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def s3Action(
      roleArn: Option[String] = None,
      bucketName: Option[String] = None,
      key: Option[String] = None,
      cannedAcl: Option[String] = None
    ): S3Action =
      S3Action
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(bucketName)(_.bucketName(_))
        .ifSome(key)(_.key(_))
        .ifSome(cannedAcl)(_.cannedAcl(_))
        .build

    def s3Destination(
      bucket: Option[String] = None,
      prefix: Option[String] = None
    ): S3Destination =
      S3Destination
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(prefix)(_.prefix(_))
        .build

    def s3Location(
      bucket: Option[String] = None,
      key: Option[String] = None,
      version: Option[String] = None
    ): S3Location =
      S3Location
        .builder
        .ifSome(bucket)(_.bucket(_))
        .ifSome(key)(_.key(_))
        .ifSome(version)(_.version(_))
        .build

    def salesforceAction(
      token: Option[String] = None,
      url: Option[String] = None
    ): SalesforceAction =
      SalesforceAction
        .builder
        .ifSome(token)(_.token(_))
        .ifSome(url)(_.url(_))
        .build

    def scheduledAuditMetadata(
      scheduledAuditName: Option[String] = None,
      scheduledAuditArn: Option[String] = None,
      frequency: Option[String] = None,
      dayOfMonth: Option[String] = None,
      dayOfWeek: Option[String] = None
    ): ScheduledAuditMetadata =
      ScheduledAuditMetadata
        .builder
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .ifSome(scheduledAuditArn)(_.scheduledAuditArn(_))
        .ifSome(frequency)(_.frequency(_))
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .build

    def searchIndexRequest(
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None,
      queryVersion: Option[String] = None
    ): SearchIndexRequest =
      SearchIndexRequest
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .build

    def searchIndexResponse(
      nextToken: Option[String] = None,
      things: Option[List[ThingDocument]] = None,
      thingGroups: Option[List[ThingGroupDocument]] = None
    ): SearchIndexResponse =
      SearchIndexResponse
        .builder
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(things)(_.things(_))
        .ifSome(thingGroups)(_.thingGroups(_))
        .build

    def securityProfileIdentifier(
      name: Option[String] = None,
      arn: Option[String] = None
    ): SecurityProfileIdentifier =
      SecurityProfileIdentifier
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .build

    def securityProfileTarget(
      arn: Option[String] = None
    ): SecurityProfileTarget =
      SecurityProfileTarget
        .builder
        .ifSome(arn)(_.arn(_))
        .build

    def securityProfileTargetMapping(
      securityProfileIdentifier: Option[SecurityProfileIdentifier] = None,
      target: Option[SecurityProfileTarget] = None
    ): SecurityProfileTargetMapping =
      SecurityProfileTargetMapping
        .builder
        .ifSome(securityProfileIdentifier)(_.securityProfileIdentifier(_))
        .ifSome(target)(_.target(_))
        .build

    def serverCertificateSummary(
      serverCertificateArn: Option[String] = None,
      serverCertificateStatus: Option[String] = None,
      serverCertificateStatusDetail: Option[String] = None
    ): ServerCertificateSummary =
      ServerCertificateSummary
        .builder
        .ifSome(serverCertificateArn)(_.serverCertificateArn(_))
        .ifSome(serverCertificateStatus)(_.serverCertificateStatus(_))
        .ifSome(serverCertificateStatusDetail)(_.serverCertificateStatusDetail(_))
        .build

    def serviceUnavailableException(
      message: Option[String] = None
    ): ServiceUnavailableException =
      ServiceUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def setDefaultAuthorizerRequest(
      authorizerName: Option[String] = None
    ): SetDefaultAuthorizerRequest =
      SetDefaultAuthorizerRequest
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .build

    def setDefaultAuthorizerResponse(
      authorizerName: Option[String] = None,
      authorizerArn: Option[String] = None
    ): SetDefaultAuthorizerResponse =
      SetDefaultAuthorizerResponse
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerArn)(_.authorizerArn(_))
        .build

    def setDefaultPolicyVersionRequest(
      policyName: Option[String] = None,
      policyVersionId: Option[String] = None
    ): SetDefaultPolicyVersionRequest =
      SetDefaultPolicyVersionRequest
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policyVersionId)(_.policyVersionId(_))
        .build

    def setLoggingOptionsRequest(
      loggingOptionsPayload: Option[LoggingOptionsPayload] = None
    ): SetLoggingOptionsRequest =
      SetLoggingOptionsRequest
        .builder
        .ifSome(loggingOptionsPayload)(_.loggingOptionsPayload(_))
        .build

    def setV2LoggingLevelRequest(
      logTarget: Option[LogTarget] = None,
      logLevel: Option[String] = None
    ): SetV2LoggingLevelRequest =
      SetV2LoggingLevelRequest
        .builder
        .ifSome(logTarget)(_.logTarget(_))
        .ifSome(logLevel)(_.logLevel(_))
        .build

    def setV2LoggingOptionsRequest(
      roleArn: Option[String] = None,
      defaultLogLevel: Option[String] = None,
      disableAllLogs: Option[Boolean] = None
    ): SetV2LoggingOptionsRequest =
      SetV2LoggingOptionsRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(defaultLogLevel)(_.defaultLogLevel(_))
        .ifSome(disableAllLogs)(_.disableAllLogs(_))
        .build

    def sigV4Authorization(
      signingRegion: Option[String] = None,
      serviceName: Option[String] = None,
      roleArn: Option[String] = None
    ): SigV4Authorization =
      SigV4Authorization
        .builder
        .ifSome(signingRegion)(_.signingRegion(_))
        .ifSome(serviceName)(_.serviceName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def signingProfileParameter(
      certificateArn: Option[String] = None,
      platform: Option[String] = None,
      certificatePathOnDevice: Option[String] = None
    ): SigningProfileParameter =
      SigningProfileParameter
        .builder
        .ifSome(certificateArn)(_.certificateArn(_))
        .ifSome(platform)(_.platform(_))
        .ifSome(certificatePathOnDevice)(_.certificatePathOnDevice(_))
        .build

    def snsAction(
      targetArn: Option[String] = None,
      roleArn: Option[String] = None,
      messageFormat: Option[String] = None
    ): SnsAction =
      SnsAction
        .builder
        .ifSome(targetArn)(_.targetArn(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(messageFormat)(_.messageFormat(_))
        .build

    def sqlParseException(
      message: Option[String] = None
    ): SqlParseException =
      SqlParseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def sqsAction(
      roleArn: Option[String] = None,
      queueUrl: Option[String] = None,
      useBase64: Option[Boolean] = None
    ): SqsAction =
      SqsAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(queueUrl)(_.queueUrl(_))
        .ifSome(useBase64)(_.useBase64(_))
        .build

    def startAuditMitigationActionsTaskRequest(
      taskId: Option[String] = None,
      target: Option[AuditMitigationActionsTaskTarget] = None,
      auditCheckToActionsMapping: Option[AuditCheckToActionsMapping] = None,
      clientRequestToken: Option[String] = None
    ): StartAuditMitigationActionsTaskRequest =
      StartAuditMitigationActionsTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(target)(_.target(_))
        .ifSome(auditCheckToActionsMapping)(_.auditCheckToActionsMapping(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def startAuditMitigationActionsTaskResponse(
      taskId: Option[String] = None
    ): StartAuditMitigationActionsTaskResponse =
      StartAuditMitigationActionsTaskResponse
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def startDetectMitigationActionsTaskRequest(
      taskId: Option[String] = None,
      target: Option[DetectMitigationActionsTaskTarget] = None,
      actions: Option[List[MitigationActionName]] = None,
      violationEventOccurrenceRange: Option[ViolationEventOccurrenceRange] = None,
      includeOnlyActiveViolations: Option[Boolean] = None,
      includeSuppressedAlerts: Option[Boolean] = None,
      clientRequestToken: Option[String] = None
    ): StartDetectMitigationActionsTaskRequest =
      StartDetectMitigationActionsTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .ifSome(target)(_.target(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(violationEventOccurrenceRange)(_.violationEventOccurrenceRange(_))
        .ifSome(includeOnlyActiveViolations)(_.includeOnlyActiveViolations(_))
        .ifSome(includeSuppressedAlerts)(_.includeSuppressedAlerts(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def startDetectMitigationActionsTaskResponse(
      taskId: Option[String] = None
    ): StartDetectMitigationActionsTaskResponse =
      StartDetectMitigationActionsTaskResponse
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def startOnDemandAuditTaskRequest(
      targetCheckNames: Option[List[AuditCheckName]] = None
    ): StartOnDemandAuditTaskRequest =
      StartOnDemandAuditTaskRequest
        .builder
        .ifSome(targetCheckNames)(_.targetCheckNames(_))
        .build

    def startOnDemandAuditTaskResponse(
      taskId: Option[String] = None
    ): StartOnDemandAuditTaskResponse =
      StartOnDemandAuditTaskResponse
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def startSigningJobParameter(
      signingProfileParameter: Option[SigningProfileParameter] = None,
      signingProfileName: Option[String] = None,
      destination: Option[Destination] = None
    ): StartSigningJobParameter =
      StartSigningJobParameter
        .builder
        .ifSome(signingProfileParameter)(_.signingProfileParameter(_))
        .ifSome(signingProfileName)(_.signingProfileName(_))
        .ifSome(destination)(_.destination(_))
        .build

    def startThingRegistrationTaskRequest(
      templateBody: Option[String] = None,
      inputFileBucket: Option[String] = None,
      inputFileKey: Option[String] = None,
      roleArn: Option[String] = None
    ): StartThingRegistrationTaskRequest =
      StartThingRegistrationTaskRequest
        .builder
        .ifSome(templateBody)(_.templateBody(_))
        .ifSome(inputFileBucket)(_.inputFileBucket(_))
        .ifSome(inputFileKey)(_.inputFileKey(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def startThingRegistrationTaskResponse(
      taskId: Option[String] = None
    ): StartThingRegistrationTaskResponse =
      StartThingRegistrationTaskResponse
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def statisticalThreshold(
      statistic: Option[String] = None
    ): StatisticalThreshold =
      StatisticalThreshold
        .builder
        .ifSome(statistic)(_.statistic(_))
        .build

    def statistics(
      count: Option[Int] = None,
      average: Option[Average] = None,
      sum: Option[Sum] = None,
      minimum: Option[Minimum] = None,
      maximum: Option[Maximum] = None,
      sumOfSquares: Option[SumOfSquares] = None,
      variance: Option[Variance] = None,
      stdDeviation: Option[StdDeviation] = None
    ): Statistics =
      Statistics
        .builder
        .ifSome(count)(_.count(_))
        .ifSome(average)(_.average(_))
        .ifSome(sum)(_.sum(_))
        .ifSome(minimum)(_.minimum(_))
        .ifSome(maximum)(_.maximum(_))
        .ifSome(sumOfSquares)(_.sumOfSquares(_))
        .ifSome(variance)(_.variance(_))
        .ifSome(stdDeviation)(_.stdDeviation(_))
        .build

    def stepFunctionsAction(
      executionNamePrefix: Option[String] = None,
      stateMachineName: Option[String] = None,
      roleArn: Option[String] = None
    ): StepFunctionsAction =
      StepFunctionsAction
        .builder
        .ifSome(executionNamePrefix)(_.executionNamePrefix(_))
        .ifSome(stateMachineName)(_.stateMachineName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def stopThingRegistrationTaskRequest(
      taskId: Option[String] = None
    ): StopThingRegistrationTaskRequest =
      StopThingRegistrationTaskRequest
        .builder
        .ifSome(taskId)(_.taskId(_))
        .build

    def stopThingRegistrationTaskResponse(

    ): StopThingRegistrationTaskResponse =
      StopThingRegistrationTaskResponse
        .builder

        .build

    def stream(
      streamId: Option[String] = None,
      fileId: Option[Int] = None
    ): Stream =
      Stream
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(fileId)(_.fileId(_))
        .build

    def streamFile(
      fileId: Option[Int] = None,
      s3Location: Option[S3Location] = None
    ): StreamFile =
      StreamFile
        .builder
        .ifSome(fileId)(_.fileId(_))
        .ifSome(s3Location)(_.s3Location(_))
        .build

    def streamInfo(
      streamId: Option[String] = None,
      streamArn: Option[String] = None,
      streamVersion: Option[Int] = None,
      description: Option[String] = None,
      files: Option[List[StreamFile]] = None,
      createdAt: Option[DateType] = None,
      lastUpdatedAt: Option[DateType] = None,
      roleArn: Option[String] = None
    ): StreamInfo =
      StreamInfo
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(streamVersion)(_.streamVersion(_))
        .ifSome(description)(_.description(_))
        .ifSome(files)(_.files(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def streamSummary(
      streamId: Option[String] = None,
      streamArn: Option[String] = None,
      streamVersion: Option[Int] = None,
      description: Option[String] = None
    ): StreamSummary =
      StreamSummary
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(streamVersion)(_.streamVersion(_))
        .ifSome(description)(_.description(_))
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
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
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

    def taskAlreadyExistsException(
      message: Option[String] = None
    ): TaskAlreadyExistsException =
      TaskAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def taskStatistics(
      totalChecks: Option[Int] = None,
      inProgressChecks: Option[Int] = None,
      waitingForDataCollectionChecks: Option[Int] = None,
      compliantChecks: Option[Int] = None,
      nonCompliantChecks: Option[Int] = None,
      failedChecks: Option[Int] = None,
      canceledChecks: Option[Int] = None
    ): TaskStatistics =
      TaskStatistics
        .builder
        .ifSome(totalChecks)(_.totalChecks(_))
        .ifSome(inProgressChecks)(_.inProgressChecks(_))
        .ifSome(waitingForDataCollectionChecks)(_.waitingForDataCollectionChecks(_))
        .ifSome(compliantChecks)(_.compliantChecks(_))
        .ifSome(nonCompliantChecks)(_.nonCompliantChecks(_))
        .ifSome(failedChecks)(_.failedChecks(_))
        .ifSome(canceledChecks)(_.canceledChecks(_))
        .build

    def taskStatisticsForAuditCheck(
      totalFindingsCount: Option[TotalFindingsCount] = None,
      failedFindingsCount: Option[FailedFindingsCount] = None,
      succeededFindingsCount: Option[SucceededFindingsCount] = None,
      skippedFindingsCount: Option[SkippedFindingsCount] = None,
      canceledFindingsCount: Option[CanceledFindingsCount] = None
    ): TaskStatisticsForAuditCheck =
      TaskStatisticsForAuditCheck
        .builder
        .ifSome(totalFindingsCount)(_.totalFindingsCount(_))
        .ifSome(failedFindingsCount)(_.failedFindingsCount(_))
        .ifSome(succeededFindingsCount)(_.succeededFindingsCount(_))
        .ifSome(skippedFindingsCount)(_.skippedFindingsCount(_))
        .ifSome(canceledFindingsCount)(_.canceledFindingsCount(_))
        .build

    def testAuthorizationRequest(
      principal: Option[String] = None,
      cognitoIdentityPoolId: Option[String] = None,
      authInfos: Option[List[AuthInfo]] = None,
      clientId: Option[String] = None,
      policyNamesToAdd: Option[List[PolicyName]] = None,
      policyNamesToSkip: Option[List[PolicyName]] = None
    ): TestAuthorizationRequest =
      TestAuthorizationRequest
        .builder
        .ifSome(principal)(_.principal(_))
        .ifSome(cognitoIdentityPoolId)(_.cognitoIdentityPoolId(_))
        .ifSome(authInfos)(_.authInfos(_))
        .ifSome(clientId)(_.clientId(_))
        .ifSome(policyNamesToAdd)(_.policyNamesToAdd(_))
        .ifSome(policyNamesToSkip)(_.policyNamesToSkip(_))
        .build

    def testAuthorizationResponse(
      authResults: Option[List[AuthResult]] = None
    ): TestAuthorizationResponse =
      TestAuthorizationResponse
        .builder
        .ifSome(authResults)(_.authResults(_))
        .build

    def testInvokeAuthorizerRequest(
      authorizerName: Option[String] = None,
      token: Option[String] = None,
      tokenSignature: Option[String] = None,
      httpContext: Option[HttpContext] = None,
      mqttContext: Option[MqttContext] = None,
      tlsContext: Option[TlsContext] = None
    ): TestInvokeAuthorizerRequest =
      TestInvokeAuthorizerRequest
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(token)(_.token(_))
        .ifSome(tokenSignature)(_.tokenSignature(_))
        .ifSome(httpContext)(_.httpContext(_))
        .ifSome(mqttContext)(_.mqttContext(_))
        .ifSome(tlsContext)(_.tlsContext(_))
        .build

    def testInvokeAuthorizerResponse(
      isAuthenticated: Option[Boolean] = None,
      principalId: Option[String] = None,
      policyDocuments: Option[List[PolicyDocument]] = None,
      refreshAfterInSeconds: Option[Int] = None,
      disconnectAfterInSeconds: Option[Int] = None
    ): TestInvokeAuthorizerResponse =
      TestInvokeAuthorizerResponse
        .builder
        .ifSome(isAuthenticated)(_.isAuthenticated(_))
        .ifSome(principalId)(_.principalId(_))
        .ifSome(policyDocuments)(_.policyDocuments(_))
        .ifSome(refreshAfterInSeconds)(_.refreshAfterInSeconds(_))
        .ifSome(disconnectAfterInSeconds)(_.disconnectAfterInSeconds(_))
        .build

    def thingAttribute(
      thingName: Option[String] = None,
      thingTypeName: Option[String] = None,
      thingArn: Option[String] = None,
      attributes: Option[Attributes] = None,
      version: Option[Version] = None
    ): ThingAttribute =
      ThingAttribute
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(thingArn)(_.thingArn(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(version)(_.version(_))
        .build

    def thingConnectivity(
      connected: Option[Boolean] = None,
      timestamp: Option[ConnectivityTimestamp] = None
    ): ThingConnectivity =
      ThingConnectivity
        .builder
        .ifSome(connected)(_.connected(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def thingDocument(
      thingName: Option[String] = None,
      thingId: Option[String] = None,
      thingTypeName: Option[String] = None,
      thingGroupNames: Option[List[ThingGroupName]] = None,
      attributes: Option[Attributes] = None,
      shadow: Option[String] = None,
      connectivity: Option[ThingConnectivity] = None
    ): ThingDocument =
      ThingDocument
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingId)(_.thingId(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(thingGroupNames)(_.thingGroupNames(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(shadow)(_.shadow(_))
        .ifSome(connectivity)(_.connectivity(_))
        .build

    def thingGroupDocument(
      thingGroupName: Option[String] = None,
      thingGroupId: Option[String] = None,
      thingGroupDescription: Option[String] = None,
      attributes: Option[Attributes] = None,
      parentGroupNames: Option[List[ThingGroupName]] = None
    ): ThingGroupDocument =
      ThingGroupDocument
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupId)(_.thingGroupId(_))
        .ifSome(thingGroupDescription)(_.thingGroupDescription(_))
        .ifSome(attributes)(_.attributes(_))
        .ifSome(parentGroupNames)(_.parentGroupNames(_))
        .build

    def thingGroupIndexingConfiguration(
      thingGroupIndexingMode: Option[String] = None,
      managedFields: Option[List[Field]] = None,
      customFields: Option[List[Field]] = None
    ): ThingGroupIndexingConfiguration =
      ThingGroupIndexingConfiguration
        .builder
        .ifSome(thingGroupIndexingMode)(_.thingGroupIndexingMode(_))
        .ifSome(managedFields)(_.managedFields(_))
        .ifSome(customFields)(_.customFields(_))
        .build

    def thingGroupMetadata(
      parentGroupName: Option[String] = None,
      rootToParentThingGroups: Option[List[GroupNameAndArn]] = None,
      creationDate: Option[CreationDate] = None
    ): ThingGroupMetadata =
      ThingGroupMetadata
        .builder
        .ifSome(parentGroupName)(_.parentGroupName(_))
        .ifSome(rootToParentThingGroups)(_.rootToParentThingGroups(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def thingGroupProperties(
      thingGroupDescription: Option[String] = None,
      attributePayload: Option[AttributePayload] = None
    ): ThingGroupProperties =
      ThingGroupProperties
        .builder
        .ifSome(thingGroupDescription)(_.thingGroupDescription(_))
        .ifSome(attributePayload)(_.attributePayload(_))
        .build

    def thingIndexingConfiguration(
      thingIndexingMode: Option[String] = None,
      thingConnectivityIndexingMode: Option[String] = None,
      managedFields: Option[List[Field]] = None,
      customFields: Option[List[Field]] = None
    ): ThingIndexingConfiguration =
      ThingIndexingConfiguration
        .builder
        .ifSome(thingIndexingMode)(_.thingIndexingMode(_))
        .ifSome(thingConnectivityIndexingMode)(_.thingConnectivityIndexingMode(_))
        .ifSome(managedFields)(_.managedFields(_))
        .ifSome(customFields)(_.customFields(_))
        .build

    def thingTypeDefinition(
      thingTypeName: Option[String] = None,
      thingTypeArn: Option[String] = None,
      thingTypeProperties: Option[ThingTypeProperties] = None,
      thingTypeMetadata: Option[ThingTypeMetadata] = None
    ): ThingTypeDefinition =
      ThingTypeDefinition
        .builder
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(thingTypeArn)(_.thingTypeArn(_))
        .ifSome(thingTypeProperties)(_.thingTypeProperties(_))
        .ifSome(thingTypeMetadata)(_.thingTypeMetadata(_))
        .build

    def thingTypeMetadata(
      deprecated: Option[Boolean] = None,
      deprecationDate: Option[DeprecationDate] = None,
      creationDate: Option[CreationDate] = None
    ): ThingTypeMetadata =
      ThingTypeMetadata
        .builder
        .ifSome(deprecated)(_.deprecated(_))
        .ifSome(deprecationDate)(_.deprecationDate(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def thingTypeProperties(
      thingTypeDescription: Option[String] = None,
      searchableAttributes: Option[List[AttributeName]] = None
    ): ThingTypeProperties =
      ThingTypeProperties
        .builder
        .ifSome(thingTypeDescription)(_.thingTypeDescription(_))
        .ifSome(searchableAttributes)(_.searchableAttributes(_))
        .build

    def throttlingException(
      message: Option[String] = None
    ): ThrottlingException =
      ThrottlingException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def timeoutConfig(
      inProgressTimeoutInMinutes: Option[InProgressTimeoutInMinutes] = None
    ): TimeoutConfig =
      TimeoutConfig
        .builder
        .ifSome(inProgressTimeoutInMinutes)(_.inProgressTimeoutInMinutes(_))
        .build

    def timestreamAction(
      roleArn: Option[String] = None,
      databaseName: Option[String] = None,
      tableName: Option[String] = None,
      dimensions: Option[List[TimestreamDimension]] = None,
      timestamp: Option[TimestreamTimestamp] = None
    ): TimestreamAction =
      TimestreamAction
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(databaseName)(_.databaseName(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(dimensions)(_.dimensions(_))
        .ifSome(timestamp)(_.timestamp(_))
        .build

    def timestreamDimension(
      name: Option[String] = None,
      value: Option[String] = None
    ): TimestreamDimension =
      TimestreamDimension
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(value)(_.value(_))
        .build

    def timestreamTimestamp(
      value: Option[String] = None,
      unit: Option[String] = None
    ): TimestreamTimestamp =
      TimestreamTimestamp
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(unit)(_.unit(_))
        .build

    def tlsContext(
      serverName: Option[String] = None
    ): TlsContext =
      TlsContext
        .builder
        .ifSome(serverName)(_.serverName(_))
        .build

    def topicRule(
      ruleName: Option[String] = None,
      sql: Option[String] = None,
      description: Option[String] = None,
      createdAt: Option[CreatedAtDate] = None,
      actions: Option[List[Action]] = None,
      ruleDisabled: Option[Boolean] = None,
      awsIotSqlVersion: Option[String] = None,
      errorAction: Option[Action] = None
    ): TopicRule =
      TopicRule
        .builder
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(sql)(_.sql(_))
        .ifSome(description)(_.description(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(ruleDisabled)(_.ruleDisabled(_))
        .ifSome(awsIotSqlVersion)(_.awsIotSqlVersion(_))
        .ifSome(errorAction)(_.errorAction(_))
        .build

    def topicRuleDestination(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAtDate] = None,
      lastUpdatedAt: Option[LastUpdatedAtDate] = None,
      statusReason: Option[String] = None,
      httpUrlProperties: Option[HttpUrlDestinationProperties] = None,
      vpcProperties: Option[VpcDestinationProperties] = None
    ): TopicRuleDestination =
      TopicRuleDestination
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(httpUrlProperties)(_.httpUrlProperties(_))
        .ifSome(vpcProperties)(_.vpcProperties(_))
        .build

    def topicRuleDestinationConfiguration(
      httpUrlConfiguration: Option[HttpUrlDestinationConfiguration] = None,
      vpcConfiguration: Option[VpcDestinationConfiguration] = None
    ): TopicRuleDestinationConfiguration =
      TopicRuleDestinationConfiguration
        .builder
        .ifSome(httpUrlConfiguration)(_.httpUrlConfiguration(_))
        .ifSome(vpcConfiguration)(_.vpcConfiguration(_))
        .build

    def topicRuleDestinationSummary(
      arn: Option[String] = None,
      status: Option[String] = None,
      createdAt: Option[CreatedAtDate] = None,
      lastUpdatedAt: Option[LastUpdatedAtDate] = None,
      statusReason: Option[String] = None,
      httpUrlSummary: Option[HttpUrlDestinationSummary] = None,
      vpcDestinationSummary: Option[VpcDestinationSummary] = None
    ): TopicRuleDestinationSummary =
      TopicRuleDestinationSummary
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(lastUpdatedAt)(_.lastUpdatedAt(_))
        .ifSome(statusReason)(_.statusReason(_))
        .ifSome(httpUrlSummary)(_.httpUrlSummary(_))
        .ifSome(vpcDestinationSummary)(_.vpcDestinationSummary(_))
        .build

    def topicRuleListItem(
      ruleArn: Option[String] = None,
      ruleName: Option[String] = None,
      topicPattern: Option[String] = None,
      createdAt: Option[CreatedAtDate] = None,
      ruleDisabled: Option[Boolean] = None
    ): TopicRuleListItem =
      TopicRuleListItem
        .builder
        .ifSome(ruleArn)(_.ruleArn(_))
        .ifSome(ruleName)(_.ruleName(_))
        .ifSome(topicPattern)(_.topicPattern(_))
        .ifSome(createdAt)(_.createdAt(_))
        .ifSome(ruleDisabled)(_.ruleDisabled(_))
        .build

    def topicRulePayload(
      sql: Option[String] = None,
      description: Option[String] = None,
      actions: Option[List[Action]] = None,
      ruleDisabled: Option[Boolean] = None,
      awsIotSqlVersion: Option[String] = None,
      errorAction: Option[Action] = None
    ): TopicRulePayload =
      TopicRulePayload
        .builder
        .ifSome(sql)(_.sql(_))
        .ifSome(description)(_.description(_))
        .ifSome(actions)(_.actions(_))
        .ifSome(ruleDisabled)(_.ruleDisabled(_))
        .ifSome(awsIotSqlVersion)(_.awsIotSqlVersion(_))
        .ifSome(errorAction)(_.errorAction(_))
        .build

    def transferAlreadyCompletedException(
      message: Option[String] = None
    ): TransferAlreadyCompletedException =
      TransferAlreadyCompletedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transferCertificateRequest(
      certificateId: Option[String] = None,
      targetAwsAccount: Option[String] = None,
      transferMessage: Option[String] = None
    ): TransferCertificateRequest =
      TransferCertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(targetAwsAccount)(_.targetAwsAccount(_))
        .ifSome(transferMessage)(_.transferMessage(_))
        .build

    def transferCertificateResponse(
      transferredCertificateArn: Option[String] = None
    ): TransferCertificateResponse =
      TransferCertificateResponse
        .builder
        .ifSome(transferredCertificateArn)(_.transferredCertificateArn(_))
        .build

    def transferConflictException(
      message: Option[String] = None
    ): TransferConflictException =
      TransferConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transferData(
      transferMessage: Option[String] = None,
      rejectReason: Option[String] = None,
      transferDate: Option[DateType] = None,
      acceptDate: Option[DateType] = None,
      rejectDate: Option[DateType] = None
    ): TransferData =
      TransferData
        .builder
        .ifSome(transferMessage)(_.transferMessage(_))
        .ifSome(rejectReason)(_.rejectReason(_))
        .ifSome(transferDate)(_.transferDate(_))
        .ifSome(acceptDate)(_.acceptDate(_))
        .ifSome(rejectDate)(_.rejectDate(_))
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

    def updateAccountAuditConfigurationRequest(
      roleArn: Option[String] = None,
      auditNotificationTargetConfigurations: Option[AuditNotificationTargetConfigurations] = None,
      auditCheckConfigurations: Option[AuditCheckConfigurations] = None
    ): UpdateAccountAuditConfigurationRequest =
      UpdateAccountAuditConfigurationRequest
        .builder
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(auditNotificationTargetConfigurations)(_.auditNotificationTargetConfigurations(_))
        .ifSome(auditCheckConfigurations)(_.auditCheckConfigurations(_))
        .build

    def updateAccountAuditConfigurationResponse(

    ): UpdateAccountAuditConfigurationResponse =
      UpdateAccountAuditConfigurationResponse
        .builder

        .build

    def updateAuditSuppressionRequest(
      checkName: Option[String] = None,
      resourceIdentifier: Option[ResourceIdentifier] = None,
      expirationDate: Option[Timestamp] = None,
      suppressIndefinitely: Option[Boolean] = None,
      description: Option[String] = None
    ): UpdateAuditSuppressionRequest =
      UpdateAuditSuppressionRequest
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(resourceIdentifier)(_.resourceIdentifier(_))
        .ifSome(expirationDate)(_.expirationDate(_))
        .ifSome(suppressIndefinitely)(_.suppressIndefinitely(_))
        .ifSome(description)(_.description(_))
        .build

    def updateAuditSuppressionResponse(

    ): UpdateAuditSuppressionResponse =
      UpdateAuditSuppressionResponse
        .builder

        .build

    def updateAuthorizerRequest(
      authorizerName: Option[String] = None,
      authorizerFunctionArn: Option[String] = None,
      tokenKeyName: Option[String] = None,
      tokenSigningPublicKeys: Option[PublicKeyMap] = None,
      status: Option[String] = None
    ): UpdateAuthorizerRequest =
      UpdateAuthorizerRequest
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerFunctionArn)(_.authorizerFunctionArn(_))
        .ifSome(tokenKeyName)(_.tokenKeyName(_))
        .ifSome(tokenSigningPublicKeys)(_.tokenSigningPublicKeys(_))
        .ifSome(status)(_.status(_))
        .build

    def updateAuthorizerResponse(
      authorizerName: Option[String] = None,
      authorizerArn: Option[String] = None
    ): UpdateAuthorizerResponse =
      UpdateAuthorizerResponse
        .builder
        .ifSome(authorizerName)(_.authorizerName(_))
        .ifSome(authorizerArn)(_.authorizerArn(_))
        .build

    def updateBillingGroupRequest(
      billingGroupName: Option[String] = None,
      billingGroupProperties: Option[BillingGroupProperties] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): UpdateBillingGroupRequest =
      UpdateBillingGroupRequest
        .builder
        .ifSome(billingGroupName)(_.billingGroupName(_))
        .ifSome(billingGroupProperties)(_.billingGroupProperties(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def updateBillingGroupResponse(
      version: Option[Version] = None
    ): UpdateBillingGroupResponse =
      UpdateBillingGroupResponse
        .builder
        .ifSome(version)(_.version(_))
        .build

    def updateCACertificateParams(
      action: Option[String] = None
    ): UpdateCACertificateParams =
      UpdateCACertificateParams
        .builder
        .ifSome(action)(_.action(_))
        .build

    def updateCACertificateRequest(
      certificateId: Option[String] = None,
      newStatus: Option[String] = None,
      newAutoRegistrationStatus: Option[String] = None,
      registrationConfig: Option[RegistrationConfig] = None,
      removeAutoRegistration: Option[Boolean] = None
    ): UpdateCACertificateRequest =
      UpdateCACertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(newStatus)(_.newStatus(_))
        .ifSome(newAutoRegistrationStatus)(_.newAutoRegistrationStatus(_))
        .ifSome(registrationConfig)(_.registrationConfig(_))
        .ifSome(removeAutoRegistration)(_.removeAutoRegistration(_))
        .build

    def updateCertificateRequest(
      certificateId: Option[String] = None,
      newStatus: Option[String] = None
    ): UpdateCertificateRequest =
      UpdateCertificateRequest
        .builder
        .ifSome(certificateId)(_.certificateId(_))
        .ifSome(newStatus)(_.newStatus(_))
        .build

    def updateCustomMetricRequest(
      metricName: Option[String] = None,
      displayName: Option[String] = None
    ): UpdateCustomMetricRequest =
      UpdateCustomMetricRequest
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(displayName)(_.displayName(_))
        .build

    def updateCustomMetricResponse(
      metricName: Option[String] = None,
      metricArn: Option[String] = None,
      metricType: Option[String] = None,
      displayName: Option[String] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): UpdateCustomMetricResponse =
      UpdateCustomMetricResponse
        .builder
        .ifSome(metricName)(_.metricName(_))
        .ifSome(metricArn)(_.metricArn(_))
        .ifSome(metricType)(_.metricType(_))
        .ifSome(displayName)(_.displayName(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def updateDeviceCertificateParams(
      action: Option[String] = None
    ): UpdateDeviceCertificateParams =
      UpdateDeviceCertificateParams
        .builder
        .ifSome(action)(_.action(_))
        .build

    def updateDimensionRequest(
      name: Option[String] = None,
      stringValues: Option[List[DimensionStringValue]] = None
    ): UpdateDimensionRequest =
      UpdateDimensionRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(stringValues)(_.stringValues(_))
        .build

    def updateDimensionResponse(
      name: Option[String] = None,
      arn: Option[String] = None,
      `type`: Option[String] = None,
      stringValues: Option[List[DimensionStringValue]] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): UpdateDimensionResponse =
      UpdateDimensionResponse
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(`type`)(_.`type`(_))
        .ifSome(stringValues)(_.stringValues(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def updateDomainConfigurationRequest(
      domainConfigurationName: Option[String] = None,
      authorizerConfig: Option[AuthorizerConfig] = None,
      domainConfigurationStatus: Option[String] = None,
      removeAuthorizerConfig: Option[Boolean] = None
    ): UpdateDomainConfigurationRequest =
      UpdateDomainConfigurationRequest
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .ifSome(authorizerConfig)(_.authorizerConfig(_))
        .ifSome(domainConfigurationStatus)(_.domainConfigurationStatus(_))
        .ifSome(removeAuthorizerConfig)(_.removeAuthorizerConfig(_))
        .build

    def updateDomainConfigurationResponse(
      domainConfigurationName: Option[String] = None,
      domainConfigurationArn: Option[String] = None
    ): UpdateDomainConfigurationResponse =
      UpdateDomainConfigurationResponse
        .builder
        .ifSome(domainConfigurationName)(_.domainConfigurationName(_))
        .ifSome(domainConfigurationArn)(_.domainConfigurationArn(_))
        .build

    def updateDynamicThingGroupRequest(
      thingGroupName: Option[String] = None,
      thingGroupProperties: Option[ThingGroupProperties] = None,
      expectedVersion: Option[OptionalVersion] = None,
      indexName: Option[String] = None,
      queryString: Option[String] = None,
      queryVersion: Option[String] = None
    ): UpdateDynamicThingGroupRequest =
      UpdateDynamicThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupProperties)(_.thingGroupProperties(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(queryString)(_.queryString(_))
        .ifSome(queryVersion)(_.queryVersion(_))
        .build

    def updateDynamicThingGroupResponse(
      version: Option[Version] = None
    ): UpdateDynamicThingGroupResponse =
      UpdateDynamicThingGroupResponse
        .builder
        .ifSome(version)(_.version(_))
        .build

    def updateEventConfigurationsRequest(
      eventConfigurations: Option[EventConfigurations] = None
    ): UpdateEventConfigurationsRequest =
      UpdateEventConfigurationsRequest
        .builder
        .ifSome(eventConfigurations)(_.eventConfigurations(_))
        .build

    def updateEventConfigurationsResponse(

    ): UpdateEventConfigurationsResponse =
      UpdateEventConfigurationsResponse
        .builder

        .build

    def updateIndexingConfigurationRequest(
      thingIndexingConfiguration: Option[ThingIndexingConfiguration] = None,
      thingGroupIndexingConfiguration: Option[ThingGroupIndexingConfiguration] = None
    ): UpdateIndexingConfigurationRequest =
      UpdateIndexingConfigurationRequest
        .builder
        .ifSome(thingIndexingConfiguration)(_.thingIndexingConfiguration(_))
        .ifSome(thingGroupIndexingConfiguration)(_.thingGroupIndexingConfiguration(_))
        .build

    def updateIndexingConfigurationResponse(

    ): UpdateIndexingConfigurationResponse =
      UpdateIndexingConfigurationResponse
        .builder

        .build

    def updateJobRequest(
      jobId: Option[String] = None,
      description: Option[String] = None,
      presignedUrlConfig: Option[PresignedUrlConfig] = None,
      jobExecutionsRolloutConfig: Option[JobExecutionsRolloutConfig] = None,
      abortConfig: Option[AbortConfig] = None,
      timeoutConfig: Option[TimeoutConfig] = None,
      namespaceId: Option[String] = None
    ): UpdateJobRequest =
      UpdateJobRequest
        .builder
        .ifSome(jobId)(_.jobId(_))
        .ifSome(description)(_.description(_))
        .ifSome(presignedUrlConfig)(_.presignedUrlConfig(_))
        .ifSome(jobExecutionsRolloutConfig)(_.jobExecutionsRolloutConfig(_))
        .ifSome(abortConfig)(_.abortConfig(_))
        .ifSome(timeoutConfig)(_.timeoutConfig(_))
        .ifSome(namespaceId)(_.namespaceId(_))
        .build

    def updateMitigationActionRequest(
      actionName: Option[String] = None,
      roleArn: Option[String] = None,
      actionParams: Option[MitigationActionParams] = None
    ): UpdateMitigationActionRequest =
      UpdateMitigationActionRequest
        .builder
        .ifSome(actionName)(_.actionName(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(actionParams)(_.actionParams(_))
        .build

    def updateMitigationActionResponse(
      actionArn: Option[String] = None,
      actionId: Option[String] = None
    ): UpdateMitigationActionResponse =
      UpdateMitigationActionResponse
        .builder
        .ifSome(actionArn)(_.actionArn(_))
        .ifSome(actionId)(_.actionId(_))
        .build

    def updateProvisioningTemplateRequest(
      templateName: Option[String] = None,
      description: Option[String] = None,
      enabled: Option[Boolean] = None,
      defaultVersionId: Option[Int] = None,
      provisioningRoleArn: Option[String] = None,
      preProvisioningHook: Option[ProvisioningHook] = None,
      removePreProvisioningHook: Option[Boolean] = None
    ): UpdateProvisioningTemplateRequest =
      UpdateProvisioningTemplateRequest
        .builder
        .ifSome(templateName)(_.templateName(_))
        .ifSome(description)(_.description(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(defaultVersionId)(_.defaultVersionId(_))
        .ifSome(provisioningRoleArn)(_.provisioningRoleArn(_))
        .ifSome(preProvisioningHook)(_.preProvisioningHook(_))
        .ifSome(removePreProvisioningHook)(_.removePreProvisioningHook(_))
        .build

    def updateProvisioningTemplateResponse(

    ): UpdateProvisioningTemplateResponse =
      UpdateProvisioningTemplateResponse
        .builder

        .build

    def updateRoleAliasRequest(
      roleAlias: Option[String] = None,
      roleArn: Option[String] = None,
      credentialDurationSeconds: Option[Int] = None
    ): UpdateRoleAliasRequest =
      UpdateRoleAliasRequest
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .ifSome(roleArn)(_.roleArn(_))
        .ifSome(credentialDurationSeconds)(_.credentialDurationSeconds(_))
        .build

    def updateRoleAliasResponse(
      roleAlias: Option[String] = None,
      roleAliasArn: Option[String] = None
    ): UpdateRoleAliasResponse =
      UpdateRoleAliasResponse
        .builder
        .ifSome(roleAlias)(_.roleAlias(_))
        .ifSome(roleAliasArn)(_.roleAliasArn(_))
        .build

    def updateScheduledAuditRequest(
      frequency: Option[String] = None,
      dayOfMonth: Option[String] = None,
      dayOfWeek: Option[String] = None,
      targetCheckNames: Option[List[AuditCheckName]] = None,
      scheduledAuditName: Option[String] = None
    ): UpdateScheduledAuditRequest =
      UpdateScheduledAuditRequest
        .builder
        .ifSome(frequency)(_.frequency(_))
        .ifSome(dayOfMonth)(_.dayOfMonth(_))
        .ifSome(dayOfWeek)(_.dayOfWeek(_))
        .ifSome(targetCheckNames)(_.targetCheckNames(_))
        .ifSome(scheduledAuditName)(_.scheduledAuditName(_))
        .build

    def updateScheduledAuditResponse(
      scheduledAuditArn: Option[String] = None
    ): UpdateScheduledAuditResponse =
      UpdateScheduledAuditResponse
        .builder
        .ifSome(scheduledAuditArn)(_.scheduledAuditArn(_))
        .build

    def updateSecurityProfileRequest(
      securityProfileName: Option[String] = None,
      securityProfileDescription: Option[String] = None,
      behaviors: Option[List[Behavior]] = None,
      alertTargets: Option[AlertTargets] = None,
      additionalMetricsToRetain: Option[List[BehaviorMetric]] = None,
      additionalMetricsToRetainV2: Option[List[MetricToRetain]] = None,
      deleteBehaviors: Option[Boolean] = None,
      deleteAlertTargets: Option[Boolean] = None,
      deleteAdditionalMetricsToRetain: Option[Boolean] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): UpdateSecurityProfileRequest =
      UpdateSecurityProfileRequest
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileDescription)(_.securityProfileDescription(_))
        .ifSome(behaviors)(_.behaviors(_))
        .ifSome(alertTargets)(_.alertTargets(_))
        .ifSome(additionalMetricsToRetain)(_.additionalMetricsToRetain(_))
        .ifSome(additionalMetricsToRetainV2)(_.additionalMetricsToRetainV2(_))
        .ifSome(deleteBehaviors)(_.deleteBehaviors(_))
        .ifSome(deleteAlertTargets)(_.deleteAlertTargets(_))
        .ifSome(deleteAdditionalMetricsToRetain)(_.deleteAdditionalMetricsToRetain(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def updateSecurityProfileResponse(
      securityProfileName: Option[String] = None,
      securityProfileArn: Option[String] = None,
      securityProfileDescription: Option[String] = None,
      behaviors: Option[List[Behavior]] = None,
      alertTargets: Option[AlertTargets] = None,
      additionalMetricsToRetain: Option[List[BehaviorMetric]] = None,
      additionalMetricsToRetainV2: Option[List[MetricToRetain]] = None,
      version: Option[Version] = None,
      creationDate: Option[Timestamp] = None,
      lastModifiedDate: Option[Timestamp] = None
    ): UpdateSecurityProfileResponse =
      UpdateSecurityProfileResponse
        .builder
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(securityProfileArn)(_.securityProfileArn(_))
        .ifSome(securityProfileDescription)(_.securityProfileDescription(_))
        .ifSome(behaviors)(_.behaviors(_))
        .ifSome(alertTargets)(_.alertTargets(_))
        .ifSome(additionalMetricsToRetain)(_.additionalMetricsToRetain(_))
        .ifSome(additionalMetricsToRetainV2)(_.additionalMetricsToRetainV2(_))
        .ifSome(version)(_.version(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastModifiedDate)(_.lastModifiedDate(_))
        .build

    def updateStreamRequest(
      streamId: Option[String] = None,
      description: Option[String] = None,
      files: Option[List[StreamFile]] = None,
      roleArn: Option[String] = None
    ): UpdateStreamRequest =
      UpdateStreamRequest
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(description)(_.description(_))
        .ifSome(files)(_.files(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def updateStreamResponse(
      streamId: Option[String] = None,
      streamArn: Option[String] = None,
      description: Option[String] = None,
      streamVersion: Option[Int] = None
    ): UpdateStreamResponse =
      UpdateStreamResponse
        .builder
        .ifSome(streamId)(_.streamId(_))
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(description)(_.description(_))
        .ifSome(streamVersion)(_.streamVersion(_))
        .build

    def updateThingGroupRequest(
      thingGroupName: Option[String] = None,
      thingGroupProperties: Option[ThingGroupProperties] = None,
      expectedVersion: Option[OptionalVersion] = None
    ): UpdateThingGroupRequest =
      UpdateThingGroupRequest
        .builder
        .ifSome(thingGroupName)(_.thingGroupName(_))
        .ifSome(thingGroupProperties)(_.thingGroupProperties(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .build

    def updateThingGroupResponse(
      version: Option[Version] = None
    ): UpdateThingGroupResponse =
      UpdateThingGroupResponse
        .builder
        .ifSome(version)(_.version(_))
        .build

    def updateThingGroupsForThingRequest(
      thingName: Option[String] = None,
      thingGroupsToAdd: Option[List[ThingGroupName]] = None,
      thingGroupsToRemove: Option[List[ThingGroupName]] = None,
      overrideDynamicGroups: Option[Boolean] = None
    ): UpdateThingGroupsForThingRequest =
      UpdateThingGroupsForThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingGroupsToAdd)(_.thingGroupsToAdd(_))
        .ifSome(thingGroupsToRemove)(_.thingGroupsToRemove(_))
        .ifSome(overrideDynamicGroups)(_.overrideDynamicGroups(_))
        .build

    def updateThingGroupsForThingResponse(

    ): UpdateThingGroupsForThingResponse =
      UpdateThingGroupsForThingResponse
        .builder

        .build

    def updateThingRequest(
      thingName: Option[String] = None,
      thingTypeName: Option[String] = None,
      attributePayload: Option[AttributePayload] = None,
      expectedVersion: Option[OptionalVersion] = None,
      removeThingType: Option[Boolean] = None
    ): UpdateThingRequest =
      UpdateThingRequest
        .builder
        .ifSome(thingName)(_.thingName(_))
        .ifSome(thingTypeName)(_.thingTypeName(_))
        .ifSome(attributePayload)(_.attributePayload(_))
        .ifSome(expectedVersion)(_.expectedVersion(_))
        .ifSome(removeThingType)(_.removeThingType(_))
        .build

    def updateThingResponse(

    ): UpdateThingResponse =
      UpdateThingResponse
        .builder

        .build

    def updateTopicRuleDestinationRequest(
      arn: Option[String] = None,
      status: Option[String] = None
    ): UpdateTopicRuleDestinationRequest =
      UpdateTopicRuleDestinationRequest
        .builder
        .ifSome(arn)(_.arn(_))
        .ifSome(status)(_.status(_))
        .build

    def updateTopicRuleDestinationResponse(

    ): UpdateTopicRuleDestinationResponse =
      UpdateTopicRuleDestinationResponse
        .builder

        .build

    def validateSecurityProfileBehaviorsRequest(
      behaviors: Option[List[Behavior]] = None
    ): ValidateSecurityProfileBehaviorsRequest =
      ValidateSecurityProfileBehaviorsRequest
        .builder
        .ifSome(behaviors)(_.behaviors(_))
        .build

    def validateSecurityProfileBehaviorsResponse(
      valid: Option[Boolean] = None,
      validationErrors: Option[List[ValidationError]] = None
    ): ValidateSecurityProfileBehaviorsResponse =
      ValidateSecurityProfileBehaviorsResponse
        .builder
        .ifSome(valid)(_.valid(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def validationError(
      errorMessage: Option[String] = None
    ): ValidationError =
      ValidationError
        .builder
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

    def versionConflictException(
      message: Option[String] = None
    ): VersionConflictException =
      VersionConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def versionsLimitExceededException(
      message: Option[String] = None
    ): VersionsLimitExceededException =
      VersionsLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def violationEvent(
      violationId: Option[String] = None,
      thingName: Option[String] = None,
      securityProfileName: Option[String] = None,
      behavior: Option[Behavior] = None,
      metricValue: Option[MetricValue] = None,
      violationEventAdditionalInfo: Option[ViolationEventAdditionalInfo] = None,
      violationEventType: Option[String] = None,
      violationEventTime: Option[Timestamp] = None
    ): ViolationEvent =
      ViolationEvent
        .builder
        .ifSome(violationId)(_.violationId(_))
        .ifSome(thingName)(_.thingName(_))
        .ifSome(securityProfileName)(_.securityProfileName(_))
        .ifSome(behavior)(_.behavior(_))
        .ifSome(metricValue)(_.metricValue(_))
        .ifSome(violationEventAdditionalInfo)(_.violationEventAdditionalInfo(_))
        .ifSome(violationEventType)(_.violationEventType(_))
        .ifSome(violationEventTime)(_.violationEventTime(_))
        .build

    def violationEventAdditionalInfo(
      confidenceLevel: Option[String] = None
    ): ViolationEventAdditionalInfo =
      ViolationEventAdditionalInfo
        .builder
        .ifSome(confidenceLevel)(_.confidenceLevel(_))
        .build

    def violationEventOccurrenceRange(
      startTime: Option[Timestamp] = None,
      endTime: Option[Timestamp] = None
    ): ViolationEventOccurrenceRange =
      ViolationEventOccurrenceRange
        .builder
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .build

    def vpcDestinationConfiguration(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None,
      roleArn: Option[String] = None
    ): VpcDestinationConfiguration =
      VpcDestinationConfiguration
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def vpcDestinationProperties(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None,
      roleArn: Option[String] = None
    ): VpcDestinationProperties =
      VpcDestinationProperties
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

    def vpcDestinationSummary(
      subnetIds: Option[List[SubnetId]] = None,
      securityGroups: Option[List[SecurityGroupId]] = None,
      vpcId: Option[String] = None,
      roleArn: Option[String] = None
    ): VpcDestinationSummary =
      VpcDestinationSummary
        .builder
        .ifSome(subnetIds)(_.subnetIds(_))
        .ifSome(securityGroups)(_.securityGroups(_))
        .ifSome(vpcId)(_.vpcId(_))
        .ifSome(roleArn)(_.roleArn(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
