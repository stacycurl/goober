package goober.hi

import goober.free.dynamodb.DynamoDbIO
import software.amazon.awssdk.services.dynamodb.model._


object dynamodb {
  import goober.free.{dynamodb ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def archivalSummary(
      archivalDateTime: Option[Date] = None,
      archivalReason: Option[String] = None,
      archivalBackupArn: Option[String] = None
    ): ArchivalSummary =
      ArchivalSummary
        .builder
        .ifSome(archivalDateTime)(_.archivalDateTime(_))
        .ifSome(archivalReason)(_.archivalReason(_))
        .ifSome(archivalBackupArn)(_.archivalBackupArn(_))
        .build

    def attributeDefinition(
      attributeName: Option[String] = None,
      attributeType: Option[String] = None
    ): AttributeDefinition =
      AttributeDefinition
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(attributeType)(_.attributeType(_))
        .build

    def attributeValue(
      s: Option[String] = None,
      n: Option[String] = None,
      b: Option[BinaryAttributeValue] = None,
      sS: Option[List[StringAttributeValue]] = None,
      nS: Option[List[NumberAttributeValue]] = None,
      bS: Option[List[BinaryAttributeValue]] = None,
      m: Option[MapAttributeValue] = None,
      l: Option[List[AttributeValue]] = None,
      nULL: Option[Boolean] = None,
      bOOL: Option[Boolean] = None
    ): AttributeValue =
      AttributeValue
        .builder
        .ifSome(s)(_.s(_))
        .ifSome(n)(_.n(_))
        .ifSome(b)(_.b(_))
        .ifSome(sS)(_.sS(_))
        .ifSome(nS)(_.nS(_))
        .ifSome(bS)(_.bS(_))
        .ifSome(m)(_.m(_))
        .ifSome(l)(_.l(_))
        .ifSome(nULL)(_.nULL(_))
        .ifSome(bOOL)(_.bOOL(_))
        .build

    def attributeValueUpdate(
      value: Option[AttributeValue] = None,
      action: Option[String] = None
    ): AttributeValueUpdate =
      AttributeValueUpdate
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(action)(_.action(_))
        .build

    def autoScalingPolicyDescription(
      policyName: Option[String] = None,
      targetTrackingScalingPolicyConfiguration: Option[AutoScalingTargetTrackingScalingPolicyConfigurationDescription] = None
    ): AutoScalingPolicyDescription =
      AutoScalingPolicyDescription
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(targetTrackingScalingPolicyConfiguration)(_.targetTrackingScalingPolicyConfiguration(_))
        .build

    def autoScalingPolicyUpdate(
      policyName: Option[String] = None,
      targetTrackingScalingPolicyConfiguration: Option[AutoScalingTargetTrackingScalingPolicyConfigurationUpdate] = None
    ): AutoScalingPolicyUpdate =
      AutoScalingPolicyUpdate
        .builder
        .ifSome(policyName)(_.policyName(_))
        .ifSome(targetTrackingScalingPolicyConfiguration)(_.targetTrackingScalingPolicyConfiguration(_))
        .build

    def autoScalingSettingsDescription(
      minimumUnits: Option[PositiveLongObject] = None,
      maximumUnits: Option[PositiveLongObject] = None,
      autoScalingDisabled: Option[Boolean] = None,
      autoScalingRoleArn: Option[String] = None,
      scalingPolicies: Option[List[AutoScalingPolicyDescription]] = None
    ): AutoScalingSettingsDescription =
      AutoScalingSettingsDescription
        .builder
        .ifSome(minimumUnits)(_.minimumUnits(_))
        .ifSome(maximumUnits)(_.maximumUnits(_))
        .ifSome(autoScalingDisabled)(_.autoScalingDisabled(_))
        .ifSome(autoScalingRoleArn)(_.autoScalingRoleArn(_))
        .ifSome(scalingPolicies)(_.scalingPolicies(_))
        .build

    def autoScalingSettingsUpdate(
      minimumUnits: Option[PositiveLongObject] = None,
      maximumUnits: Option[PositiveLongObject] = None,
      autoScalingDisabled: Option[Boolean] = None,
      autoScalingRoleArn: Option[String] = None,
      scalingPolicyUpdate: Option[AutoScalingPolicyUpdate] = None
    ): AutoScalingSettingsUpdate =
      AutoScalingSettingsUpdate
        .builder
        .ifSome(minimumUnits)(_.minimumUnits(_))
        .ifSome(maximumUnits)(_.maximumUnits(_))
        .ifSome(autoScalingDisabled)(_.autoScalingDisabled(_))
        .ifSome(autoScalingRoleArn)(_.autoScalingRoleArn(_))
        .ifSome(scalingPolicyUpdate)(_.scalingPolicyUpdate(_))
        .build

    def autoScalingTargetTrackingScalingPolicyConfigurationDescription(
      disableScaleIn: Option[Boolean] = None,
      scaleInCooldown: Option[Int] = None,
      scaleOutCooldown: Option[Int] = None,
      targetValue: Option[Double] = None
    ): AutoScalingTargetTrackingScalingPolicyConfigurationDescription =
      AutoScalingTargetTrackingScalingPolicyConfigurationDescription
        .builder
        .ifSome(disableScaleIn)(_.disableScaleIn(_))
        .ifSome(scaleInCooldown)(_.scaleInCooldown(_))
        .ifSome(scaleOutCooldown)(_.scaleOutCooldown(_))
        .ifSome(targetValue)(_.targetValue(_))
        .build

    def autoScalingTargetTrackingScalingPolicyConfigurationUpdate(
      disableScaleIn: Option[Boolean] = None,
      scaleInCooldown: Option[Int] = None,
      scaleOutCooldown: Option[Int] = None,
      targetValue: Option[Double] = None
    ): AutoScalingTargetTrackingScalingPolicyConfigurationUpdate =
      AutoScalingTargetTrackingScalingPolicyConfigurationUpdate
        .builder
        .ifSome(disableScaleIn)(_.disableScaleIn(_))
        .ifSome(scaleInCooldown)(_.scaleInCooldown(_))
        .ifSome(scaleOutCooldown)(_.scaleOutCooldown(_))
        .ifSome(targetValue)(_.targetValue(_))
        .build

    def backupDescription(
      backupDetails: Option[BackupDetails] = None,
      sourceTableDetails: Option[SourceTableDetails] = None,
      sourceTableFeatureDetails: Option[SourceTableFeatureDetails] = None
    ): BackupDescription =
      BackupDescription
        .builder
        .ifSome(backupDetails)(_.backupDetails(_))
        .ifSome(sourceTableDetails)(_.sourceTableDetails(_))
        .ifSome(sourceTableFeatureDetails)(_.sourceTableFeatureDetails(_))
        .build

    def backupDetails(
      backupArn: Option[String] = None,
      backupName: Option[String] = None,
      backupSizeBytes: Option[BackupSizeBytes] = None,
      backupStatus: Option[String] = None,
      backupType: Option[String] = None,
      backupCreationDateTime: Option[BackupCreationDateTime] = None,
      backupExpiryDateTime: Option[Date] = None
    ): BackupDetails =
      BackupDetails
        .builder
        .ifSome(backupArn)(_.backupArn(_))
        .ifSome(backupName)(_.backupName(_))
        .ifSome(backupSizeBytes)(_.backupSizeBytes(_))
        .ifSome(backupStatus)(_.backupStatus(_))
        .ifSome(backupType)(_.backupType(_))
        .ifSome(backupCreationDateTime)(_.backupCreationDateTime(_))
        .ifSome(backupExpiryDateTime)(_.backupExpiryDateTime(_))
        .build

    def backupInUseException(
      message: Option[String] = None
    ): BackupInUseException =
      BackupInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def backupNotFoundException(
      message: Option[String] = None
    ): BackupNotFoundException =
      BackupNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def backupSummary(
      tableName: Option[String] = None,
      tableId: Option[String] = None,
      tableArn: Option[String] = None,
      backupArn: Option[String] = None,
      backupName: Option[String] = None,
      backupCreationDateTime: Option[BackupCreationDateTime] = None,
      backupExpiryDateTime: Option[Date] = None,
      backupStatus: Option[String] = None,
      backupType: Option[String] = None,
      backupSizeBytes: Option[BackupSizeBytes] = None
    ): BackupSummary =
      BackupSummary
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(tableArn)(_.tableArn(_))
        .ifSome(backupArn)(_.backupArn(_))
        .ifSome(backupName)(_.backupName(_))
        .ifSome(backupCreationDateTime)(_.backupCreationDateTime(_))
        .ifSome(backupExpiryDateTime)(_.backupExpiryDateTime(_))
        .ifSome(backupStatus)(_.backupStatus(_))
        .ifSome(backupType)(_.backupType(_))
        .ifSome(backupSizeBytes)(_.backupSizeBytes(_))
        .build

    def batchExecuteStatementInput(
      statements: Option[List[BatchStatementRequest]] = None
    ): BatchExecuteStatementInput =
      BatchExecuteStatementInput
        .builder
        .ifSome(statements)(_.statements(_))
        .build

    def batchExecuteStatementOutput(
      responses: Option[List[BatchStatementResponse]] = None
    ): BatchExecuteStatementOutput =
      BatchExecuteStatementOutput
        .builder
        .ifSome(responses)(_.responses(_))
        .build

    def batchGetItemInput(
      requestItems: Option[BatchGetRequestMap] = None,
      returnConsumedCapacity: Option[String] = None
    ): BatchGetItemInput =
      BatchGetItemInput
        .builder
        .ifSome(requestItems)(_.requestItems(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .build

    def batchGetItemOutput(
      responses: Option[BatchGetResponseMap] = None,
      unprocessedKeys: Option[BatchGetRequestMap] = None,
      consumedCapacity: Option[List[ConsumedCapacity]] = None
    ): BatchGetItemOutput =
      BatchGetItemOutput
        .builder
        .ifSome(responses)(_.responses(_))
        .ifSome(unprocessedKeys)(_.unprocessedKeys(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .build

    def batchStatementError(
      code: Option[String] = None,
      message: Option[String] = None
    ): BatchStatementError =
      BatchStatementError
        .builder
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def batchStatementRequest(
      statement: Option[String] = None,
      parameters: Option[List[AttributeValue]] = None,
      consistentRead: Option[Boolean] = None
    ): BatchStatementRequest =
      BatchStatementRequest
        .builder
        .ifSome(statement)(_.statement(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(consistentRead)(_.consistentRead(_))
        .build

    def batchStatementResponse(
      error: Option[BatchStatementError] = None,
      tableName: Option[String] = None,
      item: Option[AttributeMap] = None
    ): BatchStatementResponse =
      BatchStatementResponse
        .builder
        .ifSome(error)(_.error(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(item)(_.item(_))
        .build

    def batchWriteItemInput(
      requestItems: Option[BatchWriteItemRequestMap] = None,
      returnConsumedCapacity: Option[String] = None,
      returnItemCollectionMetrics: Option[String] = None
    ): BatchWriteItemInput =
      BatchWriteItemInput
        .builder
        .ifSome(requestItems)(_.requestItems(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(returnItemCollectionMetrics)(_.returnItemCollectionMetrics(_))
        .build

    def batchWriteItemOutput(
      unprocessedItems: Option[BatchWriteItemRequestMap] = None,
      itemCollectionMetrics: Option[ItemCollectionMetricsPerTable] = None,
      consumedCapacity: Option[List[ConsumedCapacity]] = None
    ): BatchWriteItemOutput =
      BatchWriteItemOutput
        .builder
        .ifSome(unprocessedItems)(_.unprocessedItems(_))
        .ifSome(itemCollectionMetrics)(_.itemCollectionMetrics(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .build

    def billingModeSummary(
      billingMode: Option[String] = None,
      lastUpdateToPayPerRequestDateTime: Option[Date] = None
    ): BillingModeSummary =
      BillingModeSummary
        .builder
        .ifSome(billingMode)(_.billingMode(_))
        .ifSome(lastUpdateToPayPerRequestDateTime)(_.lastUpdateToPayPerRequestDateTime(_))
        .build

    def cancellationReason(
      item: Option[AttributeMap] = None,
      code: Option[String] = None,
      message: Option[String] = None
    ): CancellationReason =
      CancellationReason
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(code)(_.code(_))
        .ifSome(message)(_.message(_))
        .build

    def capacity(
      readCapacityUnits: Option[ConsumedCapacityUnits] = None,
      writeCapacityUnits: Option[ConsumedCapacityUnits] = None,
      capacityUnits: Option[ConsumedCapacityUnits] = None
    ): Capacity =
      Capacity
        .builder
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .ifSome(writeCapacityUnits)(_.writeCapacityUnits(_))
        .ifSome(capacityUnits)(_.capacityUnits(_))
        .build

    def condition(
      attributeValueList: Option[List[AttributeValue]] = None,
      comparisonOperator: Option[String] = None
    ): Condition =
      Condition
        .builder
        .ifSome(attributeValueList)(_.attributeValueList(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .build

    def conditionCheck(
      key: Option[Key] = None,
      tableName: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None,
      returnValuesOnConditionCheckFailure: Option[String] = None
    ): ConditionCheck =
      ConditionCheck
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .ifSome(returnValuesOnConditionCheckFailure)(_.returnValuesOnConditionCheckFailure(_))
        .build

    def conditionalCheckFailedException(
      message: Option[String] = None
    ): ConditionalCheckFailedException =
      ConditionalCheckFailedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def consumedCapacity(
      tableName: Option[String] = None,
      capacityUnits: Option[ConsumedCapacityUnits] = None,
      readCapacityUnits: Option[ConsumedCapacityUnits] = None,
      writeCapacityUnits: Option[ConsumedCapacityUnits] = None,
      table: Option[Capacity] = None,
      localSecondaryIndexes: Option[SecondaryIndexesCapacityMap] = None,
      globalSecondaryIndexes: Option[SecondaryIndexesCapacityMap] = None
    ): ConsumedCapacity =
      ConsumedCapacity
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(capacityUnits)(_.capacityUnits(_))
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .ifSome(writeCapacityUnits)(_.writeCapacityUnits(_))
        .ifSome(table)(_.table(_))
        .ifSome(localSecondaryIndexes)(_.localSecondaryIndexes(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .build

    def continuousBackupsDescription(
      continuousBackupsStatus: Option[String] = None,
      pointInTimeRecoveryDescription: Option[PointInTimeRecoveryDescription] = None
    ): ContinuousBackupsDescription =
      ContinuousBackupsDescription
        .builder
        .ifSome(continuousBackupsStatus)(_.continuousBackupsStatus(_))
        .ifSome(pointInTimeRecoveryDescription)(_.pointInTimeRecoveryDescription(_))
        .build

    def continuousBackupsUnavailableException(
      message: Option[String] = None
    ): ContinuousBackupsUnavailableException =
      ContinuousBackupsUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def contributorInsightsSummary(
      tableName: Option[String] = None,
      indexName: Option[String] = None,
      contributorInsightsStatus: Option[String] = None
    ): ContributorInsightsSummary =
      ContributorInsightsSummary
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(contributorInsightsStatus)(_.contributorInsightsStatus(_))
        .build

    def createBackupInput(
      tableName: Option[String] = None,
      backupName: Option[String] = None
    ): CreateBackupInput =
      CreateBackupInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(backupName)(_.backupName(_))
        .build

    def createBackupOutput(
      backupDetails: Option[BackupDetails] = None
    ): CreateBackupOutput =
      CreateBackupOutput
        .builder
        .ifSome(backupDetails)(_.backupDetails(_))
        .build

    def createGlobalSecondaryIndexAction(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None
    ): CreateGlobalSecondaryIndexAction =
      CreateGlobalSecondaryIndexAction
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .build

    def createGlobalTableInput(
      globalTableName: Option[String] = None,
      replicationGroup: Option[List[Replica]] = None
    ): CreateGlobalTableInput =
      CreateGlobalTableInput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .ifSome(replicationGroup)(_.replicationGroup(_))
        .build

    def createGlobalTableOutput(
      globalTableDescription: Option[GlobalTableDescription] = None
    ): CreateGlobalTableOutput =
      CreateGlobalTableOutput
        .builder
        .ifSome(globalTableDescription)(_.globalTableDescription(_))
        .build

    def createReplicaAction(
      regionName: Option[String] = None
    ): CreateReplicaAction =
      CreateReplicaAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .build

    def createReplicationGroupMemberAction(
      regionName: Option[String] = None,
      kMSMasterKeyId: Option[String] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughputOverride] = None,
      globalSecondaryIndexes: Option[List[ReplicaGlobalSecondaryIndex]] = None
    ): CreateReplicationGroupMemberAction =
      CreateReplicationGroupMemberAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(kMSMasterKeyId)(_.kMSMasterKeyId(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .build

    def createTableInput(
      attributeDefinitions: Option[List[AttributeDefinition]] = None,
      tableName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      localSecondaryIndexes: Option[List[LocalSecondaryIndex]] = None,
      globalSecondaryIndexes: Option[List[GlobalSecondaryIndex]] = None,
      billingMode: Option[String] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None,
      streamSpecification: Option[StreamSpecification] = None,
      sSESpecification: Option[SSESpecification] = None,
      tags: Option[List[Tag]] = None
    ): CreateTableInput =
      CreateTableInput
        .builder
        .ifSome(attributeDefinitions)(_.attributeDefinitions(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(localSecondaryIndexes)(_.localSecondaryIndexes(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(billingMode)(_.billingMode(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .ifSome(streamSpecification)(_.streamSpecification(_))
        .ifSome(sSESpecification)(_.sSESpecification(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createTableOutput(
      tableDescription: Option[TableDescription] = None
    ): CreateTableOutput =
      CreateTableOutput
        .builder
        .ifSome(tableDescription)(_.tableDescription(_))
        .build

    def delete(
      key: Option[Key] = None,
      tableName: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None,
      returnValuesOnConditionCheckFailure: Option[String] = None
    ): Delete =
      Delete
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .ifSome(returnValuesOnConditionCheckFailure)(_.returnValuesOnConditionCheckFailure(_))
        .build

    def deleteBackupInput(
      backupArn: Option[String] = None
    ): DeleteBackupInput =
      DeleteBackupInput
        .builder
        .ifSome(backupArn)(_.backupArn(_))
        .build

    def deleteBackupOutput(
      backupDescription: Option[BackupDescription] = None
    ): DeleteBackupOutput =
      DeleteBackupOutput
        .builder
        .ifSome(backupDescription)(_.backupDescription(_))
        .build

    def deleteGlobalSecondaryIndexAction(
      indexName: Option[String] = None
    ): DeleteGlobalSecondaryIndexAction =
      DeleteGlobalSecondaryIndexAction
        .builder
        .ifSome(indexName)(_.indexName(_))
        .build

    def deleteItemInput(
      tableName: Option[String] = None,
      key: Option[Key] = None,
      expected: Option[ExpectedAttributeMap] = None,
      conditionalOperator: Option[String] = None,
      returnValues: Option[String] = None,
      returnConsumedCapacity: Option[String] = None,
      returnItemCollectionMetrics: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None
    ): DeleteItemInput =
      DeleteItemInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(key)(_.key(_))
        .ifSome(expected)(_.expected(_))
        .ifSome(conditionalOperator)(_.conditionalOperator(_))
        .ifSome(returnValues)(_.returnValues(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(returnItemCollectionMetrics)(_.returnItemCollectionMetrics(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .build

    def deleteItemOutput(
      attributes: Option[AttributeMap] = None,
      consumedCapacity: Option[ConsumedCapacity] = None,
      itemCollectionMetrics: Option[ItemCollectionMetrics] = None
    ): DeleteItemOutput =
      DeleteItemOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .ifSome(itemCollectionMetrics)(_.itemCollectionMetrics(_))
        .build

    def deleteReplicaAction(
      regionName: Option[String] = None
    ): DeleteReplicaAction =
      DeleteReplicaAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .build

    def deleteReplicationGroupMemberAction(
      regionName: Option[String] = None
    ): DeleteReplicationGroupMemberAction =
      DeleteReplicationGroupMemberAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .build

    def deleteRequest(
      key: Option[Key] = None
    ): DeleteRequest =
      DeleteRequest
        .builder
        .ifSome(key)(_.key(_))
        .build

    def deleteTableInput(
      tableName: Option[String] = None
    ): DeleteTableInput =
      DeleteTableInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def deleteTableOutput(
      tableDescription: Option[TableDescription] = None
    ): DeleteTableOutput =
      DeleteTableOutput
        .builder
        .ifSome(tableDescription)(_.tableDescription(_))
        .build

    def describeBackupInput(
      backupArn: Option[String] = None
    ): DescribeBackupInput =
      DescribeBackupInput
        .builder
        .ifSome(backupArn)(_.backupArn(_))
        .build

    def describeBackupOutput(
      backupDescription: Option[BackupDescription] = None
    ): DescribeBackupOutput =
      DescribeBackupOutput
        .builder
        .ifSome(backupDescription)(_.backupDescription(_))
        .build

    def describeContinuousBackupsInput(
      tableName: Option[String] = None
    ): DescribeContinuousBackupsInput =
      DescribeContinuousBackupsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeContinuousBackupsOutput(
      continuousBackupsDescription: Option[ContinuousBackupsDescription] = None
    ): DescribeContinuousBackupsOutput =
      DescribeContinuousBackupsOutput
        .builder
        .ifSome(continuousBackupsDescription)(_.continuousBackupsDescription(_))
        .build

    def describeContributorInsightsInput(
      tableName: Option[String] = None,
      indexName: Option[String] = None
    ): DescribeContributorInsightsInput =
      DescribeContributorInsightsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .build

    def describeContributorInsightsOutput(
      tableName: Option[String] = None,
      indexName: Option[String] = None,
      contributorInsightsRuleList: Option[List[ContributorInsightsRule]] = None,
      contributorInsightsStatus: Option[String] = None,
      lastUpdateDateTime: Option[LastUpdateDateTime] = None,
      failureException: Option[FailureException] = None
    ): DescribeContributorInsightsOutput =
      DescribeContributorInsightsOutput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(contributorInsightsRuleList)(_.contributorInsightsRuleList(_))
        .ifSome(contributorInsightsStatus)(_.contributorInsightsStatus(_))
        .ifSome(lastUpdateDateTime)(_.lastUpdateDateTime(_))
        .ifSome(failureException)(_.failureException(_))
        .build

    def describeEndpointsRequest(

    ): DescribeEndpointsRequest =
      DescribeEndpointsRequest
        .builder

        .build

    def describeEndpointsResponse(
      endpoints: Option[List[Endpoint]] = None
    ): DescribeEndpointsResponse =
      DescribeEndpointsResponse
        .builder
        .ifSome(endpoints)(_.endpoints(_))
        .build

    def describeExportInput(
      exportArn: Option[String] = None
    ): DescribeExportInput =
      DescribeExportInput
        .builder
        .ifSome(exportArn)(_.exportArn(_))
        .build

    def describeExportOutput(
      exportDescription: Option[ExportDescription] = None
    ): DescribeExportOutput =
      DescribeExportOutput
        .builder
        .ifSome(exportDescription)(_.exportDescription(_))
        .build

    def describeGlobalTableInput(
      globalTableName: Option[String] = None
    ): DescribeGlobalTableInput =
      DescribeGlobalTableInput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .build

    def describeGlobalTableOutput(
      globalTableDescription: Option[GlobalTableDescription] = None
    ): DescribeGlobalTableOutput =
      DescribeGlobalTableOutput
        .builder
        .ifSome(globalTableDescription)(_.globalTableDescription(_))
        .build

    def describeGlobalTableSettingsInput(
      globalTableName: Option[String] = None
    ): DescribeGlobalTableSettingsInput =
      DescribeGlobalTableSettingsInput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .build

    def describeGlobalTableSettingsOutput(
      globalTableName: Option[String] = None,
      replicaSettings: Option[List[ReplicaSettingsDescription]] = None
    ): DescribeGlobalTableSettingsOutput =
      DescribeGlobalTableSettingsOutput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .ifSome(replicaSettings)(_.replicaSettings(_))
        .build

    def describeKinesisStreamingDestinationInput(
      tableName: Option[String] = None
    ): DescribeKinesisStreamingDestinationInput =
      DescribeKinesisStreamingDestinationInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeKinesisStreamingDestinationOutput(
      tableName: Option[String] = None,
      kinesisDataStreamDestinations: Option[List[KinesisDataStreamDestination]] = None
    ): DescribeKinesisStreamingDestinationOutput =
      DescribeKinesisStreamingDestinationOutput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(kinesisDataStreamDestinations)(_.kinesisDataStreamDestinations(_))
        .build

    def describeLimitsInput(

    ): DescribeLimitsInput =
      DescribeLimitsInput
        .builder

        .build

    def describeLimitsOutput(
      accountMaxReadCapacityUnits: Option[PositiveLongObject] = None,
      accountMaxWriteCapacityUnits: Option[PositiveLongObject] = None,
      tableMaxReadCapacityUnits: Option[PositiveLongObject] = None,
      tableMaxWriteCapacityUnits: Option[PositiveLongObject] = None
    ): DescribeLimitsOutput =
      DescribeLimitsOutput
        .builder
        .ifSome(accountMaxReadCapacityUnits)(_.accountMaxReadCapacityUnits(_))
        .ifSome(accountMaxWriteCapacityUnits)(_.accountMaxWriteCapacityUnits(_))
        .ifSome(tableMaxReadCapacityUnits)(_.tableMaxReadCapacityUnits(_))
        .ifSome(tableMaxWriteCapacityUnits)(_.tableMaxWriteCapacityUnits(_))
        .build

    def describeTableInput(
      tableName: Option[String] = None
    ): DescribeTableInput =
      DescribeTableInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeTableOutput(
      table: Option[TableDescription] = None
    ): DescribeTableOutput =
      DescribeTableOutput
        .builder
        .ifSome(table)(_.table(_))
        .build

    def describeTableReplicaAutoScalingInput(
      tableName: Option[String] = None
    ): DescribeTableReplicaAutoScalingInput =
      DescribeTableReplicaAutoScalingInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeTableReplicaAutoScalingOutput(
      tableAutoScalingDescription: Option[TableAutoScalingDescription] = None
    ): DescribeTableReplicaAutoScalingOutput =
      DescribeTableReplicaAutoScalingOutput
        .builder
        .ifSome(tableAutoScalingDescription)(_.tableAutoScalingDescription(_))
        .build

    def describeTimeToLiveInput(
      tableName: Option[String] = None
    ): DescribeTimeToLiveInput =
      DescribeTimeToLiveInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .build

    def describeTimeToLiveOutput(
      timeToLiveDescription: Option[TimeToLiveDescription] = None
    ): DescribeTimeToLiveOutput =
      DescribeTimeToLiveOutput
        .builder
        .ifSome(timeToLiveDescription)(_.timeToLiveDescription(_))
        .build

    def duplicateItemException(
      message: Option[String] = None
    ): DuplicateItemException =
      DuplicateItemException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def endpoint(
      address: Option[String] = None,
      cachePeriodInMinutes: Option[Long] = None
    ): Endpoint =
      Endpoint
        .builder
        .ifSome(address)(_.address(_))
        .ifSome(cachePeriodInMinutes)(_.cachePeriodInMinutes(_))
        .build

    def executeStatementInput(
      statement: Option[String] = None,
      parameters: Option[List[AttributeValue]] = None,
      consistentRead: Option[Boolean] = None,
      nextToken: Option[String] = None
    ): ExecuteStatementInput =
      ExecuteStatementInput
        .builder
        .ifSome(statement)(_.statement(_))
        .ifSome(parameters)(_.parameters(_))
        .ifSome(consistentRead)(_.consistentRead(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def executeStatementOutput(
      items: Option[List[AttributeMap]] = None,
      nextToken: Option[String] = None
    ): ExecuteStatementOutput =
      ExecuteStatementOutput
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def executeTransactionInput(
      transactStatements: Option[List[ParameterizedStatement]] = None,
      clientRequestToken: Option[String] = None
    ): ExecuteTransactionInput =
      ExecuteTransactionInput
        .builder
        .ifSome(transactStatements)(_.transactStatements(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def executeTransactionOutput(
      responses: Option[List[ItemResponse]] = None
    ): ExecuteTransactionOutput =
      ExecuteTransactionOutput
        .builder
        .ifSome(responses)(_.responses(_))
        .build

    def expectedAttributeValue(
      value: Option[AttributeValue] = None,
      exists: Option[Boolean] = None,
      comparisonOperator: Option[String] = None,
      attributeValueList: Option[List[AttributeValue]] = None
    ): ExpectedAttributeValue =
      ExpectedAttributeValue
        .builder
        .ifSome(value)(_.value(_))
        .ifSome(exists)(_.exists(_))
        .ifSome(comparisonOperator)(_.comparisonOperator(_))
        .ifSome(attributeValueList)(_.attributeValueList(_))
        .build

    def exportConflictException(
      message: Option[String] = None
    ): ExportConflictException =
      ExportConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def exportDescription(
      exportArn: Option[String] = None,
      exportStatus: Option[String] = None,
      startTime: Option[ExportStartTime] = None,
      endTime: Option[ExportEndTime] = None,
      exportManifest: Option[String] = None,
      tableArn: Option[String] = None,
      tableId: Option[String] = None,
      exportTime: Option[ExportTime] = None,
      clientToken: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3BucketOwner: Option[String] = None,
      s3Prefix: Option[String] = None,
      s3SseAlgorithm: Option[String] = None,
      s3SseKmsKeyId: Option[String] = None,
      failureCode: Option[String] = None,
      failureMessage: Option[String] = None,
      exportFormat: Option[String] = None,
      billedSizeBytes: Option[BilledSizeBytes] = None,
      itemCount: Option[ItemCount] = None
    ): ExportDescription =
      ExportDescription
        .builder
        .ifSome(exportArn)(_.exportArn(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .ifSome(startTime)(_.startTime(_))
        .ifSome(endTime)(_.endTime(_))
        .ifSome(exportManifest)(_.exportManifest(_))
        .ifSome(tableArn)(_.tableArn(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(exportTime)(_.exportTime(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3BucketOwner)(_.s3BucketOwner(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(s3SseAlgorithm)(_.s3SseAlgorithm(_))
        .ifSome(s3SseKmsKeyId)(_.s3SseKmsKeyId(_))
        .ifSome(failureCode)(_.failureCode(_))
        .ifSome(failureMessage)(_.failureMessage(_))
        .ifSome(exportFormat)(_.exportFormat(_))
        .ifSome(billedSizeBytes)(_.billedSizeBytes(_))
        .ifSome(itemCount)(_.itemCount(_))
        .build

    def exportNotFoundException(
      message: Option[String] = None
    ): ExportNotFoundException =
      ExportNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def exportSummary(
      exportArn: Option[String] = None,
      exportStatus: Option[String] = None
    ): ExportSummary =
      ExportSummary
        .builder
        .ifSome(exportArn)(_.exportArn(_))
        .ifSome(exportStatus)(_.exportStatus(_))
        .build

    def exportTableToPointInTimeInput(
      tableArn: Option[String] = None,
      exportTime: Option[ExportTime] = None,
      clientToken: Option[String] = None,
      s3Bucket: Option[String] = None,
      s3BucketOwner: Option[String] = None,
      s3Prefix: Option[String] = None,
      s3SseAlgorithm: Option[String] = None,
      s3SseKmsKeyId: Option[String] = None,
      exportFormat: Option[String] = None
    ): ExportTableToPointInTimeInput =
      ExportTableToPointInTimeInput
        .builder
        .ifSome(tableArn)(_.tableArn(_))
        .ifSome(exportTime)(_.exportTime(_))
        .ifSome(clientToken)(_.clientToken(_))
        .ifSome(s3Bucket)(_.s3Bucket(_))
        .ifSome(s3BucketOwner)(_.s3BucketOwner(_))
        .ifSome(s3Prefix)(_.s3Prefix(_))
        .ifSome(s3SseAlgorithm)(_.s3SseAlgorithm(_))
        .ifSome(s3SseKmsKeyId)(_.s3SseKmsKeyId(_))
        .ifSome(exportFormat)(_.exportFormat(_))
        .build

    def exportTableToPointInTimeOutput(
      exportDescription: Option[ExportDescription] = None
    ): ExportTableToPointInTimeOutput =
      ExportTableToPointInTimeOutput
        .builder
        .ifSome(exportDescription)(_.exportDescription(_))
        .build

    def failureException(
      exceptionName: Option[String] = None,
      exceptionDescription: Option[String] = None
    ): FailureException =
      FailureException
        .builder
        .ifSome(exceptionName)(_.exceptionName(_))
        .ifSome(exceptionDescription)(_.exceptionDescription(_))
        .build

    def get(
      key: Option[Key] = None,
      tableName: Option[String] = None,
      projectionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None
    ): Get =
      Get
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(projectionExpression)(_.projectionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .build

    def getItemInput(
      tableName: Option[String] = None,
      key: Option[Key] = None,
      attributesToGet: Option[List[AttributeName]] = None,
      consistentRead: Option[Boolean] = None,
      returnConsumedCapacity: Option[String] = None,
      projectionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None
    ): GetItemInput =
      GetItemInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(key)(_.key(_))
        .ifSome(attributesToGet)(_.attributesToGet(_))
        .ifSome(consistentRead)(_.consistentRead(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(projectionExpression)(_.projectionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .build

    def getItemOutput(
      item: Option[AttributeMap] = None,
      consumedCapacity: Option[ConsumedCapacity] = None
    ): GetItemOutput =
      GetItemOutput
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .build

    def globalSecondaryIndex(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None
    ): GlobalSecondaryIndex =
      GlobalSecondaryIndex
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .build

    def globalSecondaryIndexAutoScalingUpdate(
      indexName: Option[String] = None,
      provisionedWriteCapacityAutoScalingUpdate: Option[AutoScalingSettingsUpdate] = None
    ): GlobalSecondaryIndexAutoScalingUpdate =
      GlobalSecondaryIndexAutoScalingUpdate
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedWriteCapacityAutoScalingUpdate)(_.provisionedWriteCapacityAutoScalingUpdate(_))
        .build

    def globalSecondaryIndexDescription(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None,
      indexStatus: Option[String] = None,
      backfilling: Option[Boolean] = None,
      provisionedThroughput: Option[ProvisionedThroughputDescription] = None,
      indexSizeBytes: Option[Long] = None,
      itemCount: Option[Long] = None,
      indexArn: Option[String] = None
    ): GlobalSecondaryIndexDescription =
      GlobalSecondaryIndexDescription
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .ifSome(indexStatus)(_.indexStatus(_))
        .ifSome(backfilling)(_.backfilling(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .ifSome(indexSizeBytes)(_.indexSizeBytes(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(indexArn)(_.indexArn(_))
        .build

    def globalSecondaryIndexInfo(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None
    ): GlobalSecondaryIndexInfo =
      GlobalSecondaryIndexInfo
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .build

    def globalSecondaryIndexUpdate(
      update: Option[UpdateGlobalSecondaryIndexAction] = None,
      create: Option[CreateGlobalSecondaryIndexAction] = None,
      delete: Option[DeleteGlobalSecondaryIndexAction] = None
    ): GlobalSecondaryIndexUpdate =
      GlobalSecondaryIndexUpdate
        .builder
        .ifSome(update)(_.update(_))
        .ifSome(create)(_.create(_))
        .ifSome(delete)(_.delete(_))
        .build

    def globalTable(
      globalTableName: Option[String] = None,
      replicationGroup: Option[List[Replica]] = None
    ): GlobalTable =
      GlobalTable
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .ifSome(replicationGroup)(_.replicationGroup(_))
        .build

    def globalTableAlreadyExistsException(
      message: Option[String] = None
    ): GlobalTableAlreadyExistsException =
      GlobalTableAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def globalTableDescription(
      replicationGroup: Option[List[ReplicaDescription]] = None,
      globalTableArn: Option[String] = None,
      creationDateTime: Option[Date] = None,
      globalTableStatus: Option[String] = None,
      globalTableName: Option[String] = None
    ): GlobalTableDescription =
      GlobalTableDescription
        .builder
        .ifSome(replicationGroup)(_.replicationGroup(_))
        .ifSome(globalTableArn)(_.globalTableArn(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(globalTableStatus)(_.globalTableStatus(_))
        .ifSome(globalTableName)(_.globalTableName(_))
        .build

    def globalTableGlobalSecondaryIndexSettingsUpdate(
      indexName: Option[String] = None,
      provisionedWriteCapacityUnits: Option[PositiveLongObject] = None,
      provisionedWriteCapacityAutoScalingSettingsUpdate: Option[AutoScalingSettingsUpdate] = None
    ): GlobalTableGlobalSecondaryIndexSettingsUpdate =
      GlobalTableGlobalSecondaryIndexSettingsUpdate
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedWriteCapacityUnits)(_.provisionedWriteCapacityUnits(_))
        .ifSome(provisionedWriteCapacityAutoScalingSettingsUpdate)(_.provisionedWriteCapacityAutoScalingSettingsUpdate(_))
        .build

    def globalTableNotFoundException(
      message: Option[String] = None
    ): GlobalTableNotFoundException =
      GlobalTableNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def idempotentParameterMismatchException(
      message: Option[String] = None
    ): IdempotentParameterMismatchException =
      IdempotentParameterMismatchException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def indexNotFoundException(
      message: Option[String] = None
    ): IndexNotFoundException =
      IndexNotFoundException
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

    def invalidExportTimeException(
      message: Option[String] = None
    ): InvalidExportTimeException =
      InvalidExportTimeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidRestoreTimeException(
      message: Option[String] = None
    ): InvalidRestoreTimeException =
      InvalidRestoreTimeException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def itemCollectionMetrics(
      itemCollectionKey: Option[ItemCollectionKeyAttributeMap] = None,
      sizeEstimateRangeGB: Option[List[ItemCollectionSizeEstimateBound]] = None
    ): ItemCollectionMetrics =
      ItemCollectionMetrics
        .builder
        .ifSome(itemCollectionKey)(_.itemCollectionKey(_))
        .ifSome(sizeEstimateRangeGB)(_.sizeEstimateRangeGB(_))
        .build

    def itemCollectionSizeLimitExceededException(
      message: Option[String] = None
    ): ItemCollectionSizeLimitExceededException =
      ItemCollectionSizeLimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def itemResponse(
      item: Option[AttributeMap] = None
    ): ItemResponse =
      ItemResponse
        .builder
        .ifSome(item)(_.item(_))
        .build

    def keySchemaElement(
      attributeName: Option[String] = None,
      keyType: Option[String] = None
    ): KeySchemaElement =
      KeySchemaElement
        .builder
        .ifSome(attributeName)(_.attributeName(_))
        .ifSome(keyType)(_.keyType(_))
        .build

    def keysAndAttributes(
      keys: Option[List[Key]] = None,
      attributesToGet: Option[List[AttributeName]] = None,
      consistentRead: Option[Boolean] = None,
      projectionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None
    ): KeysAndAttributes =
      KeysAndAttributes
        .builder
        .ifSome(keys)(_.keys(_))
        .ifSome(attributesToGet)(_.attributesToGet(_))
        .ifSome(consistentRead)(_.consistentRead(_))
        .ifSome(projectionExpression)(_.projectionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .build

    def kinesisDataStreamDestination(
      streamArn: Option[String] = None,
      destinationStatus: Option[String] = None,
      destinationStatusDescription: Option[String] = None
    ): KinesisDataStreamDestination =
      KinesisDataStreamDestination
        .builder
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(destinationStatus)(_.destinationStatus(_))
        .ifSome(destinationStatusDescription)(_.destinationStatusDescription(_))
        .build

    def kinesisStreamingDestinationInput(
      tableName: Option[String] = None,
      streamArn: Option[String] = None
    ): KinesisStreamingDestinationInput =
      KinesisStreamingDestinationInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(streamArn)(_.streamArn(_))
        .build

    def kinesisStreamingDestinationOutput(
      tableName: Option[String] = None,
      streamArn: Option[String] = None,
      destinationStatus: Option[String] = None
    ): KinesisStreamingDestinationOutput =
      KinesisStreamingDestinationOutput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(streamArn)(_.streamArn(_))
        .ifSome(destinationStatus)(_.destinationStatus(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listBackupsInput(
      tableName: Option[String] = None,
      limit: Option[Int] = None,
      timeRangeLowerBound: Option[TimeRangeLowerBound] = None,
      timeRangeUpperBound: Option[TimeRangeUpperBound] = None,
      exclusiveStartBackupArn: Option[String] = None,
      backupType: Option[String] = None
    ): ListBackupsInput =
      ListBackupsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(timeRangeLowerBound)(_.timeRangeLowerBound(_))
        .ifSome(timeRangeUpperBound)(_.timeRangeUpperBound(_))
        .ifSome(exclusiveStartBackupArn)(_.exclusiveStartBackupArn(_))
        .ifSome(backupType)(_.backupType(_))
        .build

    def listBackupsOutput(
      backupSummaries: Option[List[BackupSummary]] = None,
      lastEvaluatedBackupArn: Option[String] = None
    ): ListBackupsOutput =
      ListBackupsOutput
        .builder
        .ifSome(backupSummaries)(_.backupSummaries(_))
        .ifSome(lastEvaluatedBackupArn)(_.lastEvaluatedBackupArn(_))
        .build

    def listContributorInsightsInput(
      tableName: Option[String] = None,
      nextToken: Option[String] = None,
      maxResults: Option[Int] = None
    ): ListContributorInsightsInput =
      ListContributorInsightsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(maxResults)(_.maxResults(_))
        .build

    def listContributorInsightsOutput(
      contributorInsightsSummaries: Option[List[ContributorInsightsSummary]] = None,
      nextToken: Option[String] = None
    ): ListContributorInsightsOutput =
      ListContributorInsightsOutput
        .builder
        .ifSome(contributorInsightsSummaries)(_.contributorInsightsSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExportsInput(
      tableArn: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None
    ): ListExportsInput =
      ListExportsInput
        .builder
        .ifSome(tableArn)(_.tableArn(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listExportsOutput(
      exportSummaries: Option[List[ExportSummary]] = None,
      nextToken: Option[String] = None
    ): ListExportsOutput =
      ListExportsOutput
        .builder
        .ifSome(exportSummaries)(_.exportSummaries(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listGlobalTablesInput(
      exclusiveStartGlobalTableName: Option[String] = None,
      limit: Option[Int] = None,
      regionName: Option[String] = None
    ): ListGlobalTablesInput =
      ListGlobalTablesInput
        .builder
        .ifSome(exclusiveStartGlobalTableName)(_.exclusiveStartGlobalTableName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(regionName)(_.regionName(_))
        .build

    def listGlobalTablesOutput(
      globalTables: Option[List[GlobalTable]] = None,
      lastEvaluatedGlobalTableName: Option[String] = None
    ): ListGlobalTablesOutput =
      ListGlobalTablesOutput
        .builder
        .ifSome(globalTables)(_.globalTables(_))
        .ifSome(lastEvaluatedGlobalTableName)(_.lastEvaluatedGlobalTableName(_))
        .build

    def listTablesInput(
      exclusiveStartTableName: Option[String] = None,
      limit: Option[Int] = None
    ): ListTablesInput =
      ListTablesInput
        .builder
        .ifSome(exclusiveStartTableName)(_.exclusiveStartTableName(_))
        .ifSome(limit)(_.limit(_))
        .build

    def listTablesOutput(
      tableNames: Option[List[TableName]] = None,
      lastEvaluatedTableName: Option[String] = None
    ): ListTablesOutput =
      ListTablesOutput
        .builder
        .ifSome(tableNames)(_.tableNames(_))
        .ifSome(lastEvaluatedTableName)(_.lastEvaluatedTableName(_))
        .build

    def listTagsOfResourceInput(
      resourceArn: Option[String] = None,
      nextToken: Option[String] = None
    ): ListTagsOfResourceInput =
      ListTagsOfResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def listTagsOfResourceOutput(
      tags: Option[List[Tag]] = None,
      nextToken: Option[String] = None
    ): ListTagsOfResourceOutput =
      ListTagsOfResourceOutput
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def localSecondaryIndex(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None
    ): LocalSecondaryIndex =
      LocalSecondaryIndex
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .build

    def localSecondaryIndexDescription(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None,
      indexSizeBytes: Option[Long] = None,
      itemCount: Option[Long] = None,
      indexArn: Option[String] = None
    ): LocalSecondaryIndexDescription =
      LocalSecondaryIndexDescription
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .ifSome(indexSizeBytes)(_.indexSizeBytes(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(indexArn)(_.indexArn(_))
        .build

    def localSecondaryIndexInfo(
      indexName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      projection: Option[Projection] = None
    ): LocalSecondaryIndexInfo =
      LocalSecondaryIndexInfo
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(projection)(_.projection(_))
        .build

    def parameterizedStatement(
      statement: Option[String] = None,
      parameters: Option[List[AttributeValue]] = None
    ): ParameterizedStatement =
      ParameterizedStatement
        .builder
        .ifSome(statement)(_.statement(_))
        .ifSome(parameters)(_.parameters(_))
        .build

    def pointInTimeRecoveryDescription(
      pointInTimeRecoveryStatus: Option[String] = None,
      earliestRestorableDateTime: Option[Date] = None,
      latestRestorableDateTime: Option[Date] = None
    ): PointInTimeRecoveryDescription =
      PointInTimeRecoveryDescription
        .builder
        .ifSome(pointInTimeRecoveryStatus)(_.pointInTimeRecoveryStatus(_))
        .ifSome(earliestRestorableDateTime)(_.earliestRestorableDateTime(_))
        .ifSome(latestRestorableDateTime)(_.latestRestorableDateTime(_))
        .build

    def pointInTimeRecoverySpecification(
      pointInTimeRecoveryEnabled: Option[Boolean] = None
    ): PointInTimeRecoverySpecification =
      PointInTimeRecoverySpecification
        .builder
        .ifSome(pointInTimeRecoveryEnabled)(_.pointInTimeRecoveryEnabled(_))
        .build

    def pointInTimeRecoveryUnavailableException(
      message: Option[String] = None
    ): PointInTimeRecoveryUnavailableException =
      PointInTimeRecoveryUnavailableException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def projection(
      projectionType: Option[String] = None,
      nonKeyAttributes: Option[List[NonKeyAttributeName]] = None
    ): Projection =
      Projection
        .builder
        .ifSome(projectionType)(_.projectionType(_))
        .ifSome(nonKeyAttributes)(_.nonKeyAttributes(_))
        .build

    def provisionedThroughput(
      readCapacityUnits: Option[PositiveLongObject] = None,
      writeCapacityUnits: Option[PositiveLongObject] = None
    ): ProvisionedThroughput =
      ProvisionedThroughput
        .builder
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .ifSome(writeCapacityUnits)(_.writeCapacityUnits(_))
        .build

    def provisionedThroughputDescription(
      lastIncreaseDateTime: Option[Date] = None,
      lastDecreaseDateTime: Option[Date] = None,
      numberOfDecreasesToday: Option[PositiveLongObject] = None,
      readCapacityUnits: Option[NonNegativeLongObject] = None,
      writeCapacityUnits: Option[NonNegativeLongObject] = None
    ): ProvisionedThroughputDescription =
      ProvisionedThroughputDescription
        .builder
        .ifSome(lastIncreaseDateTime)(_.lastIncreaseDateTime(_))
        .ifSome(lastDecreaseDateTime)(_.lastDecreaseDateTime(_))
        .ifSome(numberOfDecreasesToday)(_.numberOfDecreasesToday(_))
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .ifSome(writeCapacityUnits)(_.writeCapacityUnits(_))
        .build

    def provisionedThroughputExceededException(
      message: Option[String] = None
    ): ProvisionedThroughputExceededException =
      ProvisionedThroughputExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def provisionedThroughputOverride(
      readCapacityUnits: Option[PositiveLongObject] = None
    ): ProvisionedThroughputOverride =
      ProvisionedThroughputOverride
        .builder
        .ifSome(readCapacityUnits)(_.readCapacityUnits(_))
        .build

    def put(
      item: Option[PutItemInputAttributeMap] = None,
      tableName: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None,
      returnValuesOnConditionCheckFailure: Option[String] = None
    ): Put =
      Put
        .builder
        .ifSome(item)(_.item(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .ifSome(returnValuesOnConditionCheckFailure)(_.returnValuesOnConditionCheckFailure(_))
        .build

    def putItemInput(
      tableName: Option[String] = None,
      item: Option[PutItemInputAttributeMap] = None,
      expected: Option[ExpectedAttributeMap] = None,
      returnValues: Option[String] = None,
      returnConsumedCapacity: Option[String] = None,
      returnItemCollectionMetrics: Option[String] = None,
      conditionalOperator: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None
    ): PutItemInput =
      PutItemInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(item)(_.item(_))
        .ifSome(expected)(_.expected(_))
        .ifSome(returnValues)(_.returnValues(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(returnItemCollectionMetrics)(_.returnItemCollectionMetrics(_))
        .ifSome(conditionalOperator)(_.conditionalOperator(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .build

    def putItemOutput(
      attributes: Option[AttributeMap] = None,
      consumedCapacity: Option[ConsumedCapacity] = None,
      itemCollectionMetrics: Option[ItemCollectionMetrics] = None
    ): PutItemOutput =
      PutItemOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .ifSome(itemCollectionMetrics)(_.itemCollectionMetrics(_))
        .build

    def putRequest(
      item: Option[PutItemInputAttributeMap] = None
    ): PutRequest =
      PutRequest
        .builder
        .ifSome(item)(_.item(_))
        .build

    def queryInput(
      tableName: Option[String] = None,
      indexName: Option[String] = None,
      select: Option[String] = None,
      attributesToGet: Option[List[AttributeName]] = None,
      limit: Option[Int] = None,
      consistentRead: Option[Boolean] = None,
      keyConditions: Option[KeyConditions] = None,
      queryFilter: Option[FilterConditionMap] = None,
      conditionalOperator: Option[String] = None,
      scanIndexForward: Option[Boolean] = None,
      exclusiveStartKey: Option[Key] = None,
      returnConsumedCapacity: Option[String] = None,
      projectionExpression: Option[String] = None,
      filterExpression: Option[String] = None,
      keyConditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None
    ): QueryInput =
      QueryInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(select)(_.select(_))
        .ifSome(attributesToGet)(_.attributesToGet(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(consistentRead)(_.consistentRead(_))
        .ifSome(keyConditions)(_.keyConditions(_))
        .ifSome(queryFilter)(_.queryFilter(_))
        .ifSome(conditionalOperator)(_.conditionalOperator(_))
        .ifSome(scanIndexForward)(_.scanIndexForward(_))
        .ifSome(exclusiveStartKey)(_.exclusiveStartKey(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(projectionExpression)(_.projectionExpression(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(keyConditionExpression)(_.keyConditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .build

    def queryOutput(
      items: Option[List[AttributeMap]] = None,
      count: Option[Int] = None,
      scannedCount: Option[Int] = None,
      lastEvaluatedKey: Option[Key] = None,
      consumedCapacity: Option[ConsumedCapacity] = None
    ): QueryOutput =
      QueryOutput
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(count)(_.count(_))
        .ifSome(scannedCount)(_.scannedCount(_))
        .ifSome(lastEvaluatedKey)(_.lastEvaluatedKey(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .build

    def replica(
      regionName: Option[String] = None
    ): Replica =
      Replica
        .builder
        .ifSome(regionName)(_.regionName(_))
        .build

    def replicaAlreadyExistsException(
      message: Option[String] = None
    ): ReplicaAlreadyExistsException =
      ReplicaAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicaAutoScalingDescription(
      regionName: Option[String] = None,
      globalSecondaryIndexes: Option[List[ReplicaGlobalSecondaryIndexAutoScalingDescription]] = None,
      replicaProvisionedReadCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None,
      replicaProvisionedWriteCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None,
      replicaStatus: Option[String] = None
    ): ReplicaAutoScalingDescription =
      ReplicaAutoScalingDescription
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(replicaProvisionedReadCapacityAutoScalingSettings)(_.replicaProvisionedReadCapacityAutoScalingSettings(_))
        .ifSome(replicaProvisionedWriteCapacityAutoScalingSettings)(_.replicaProvisionedWriteCapacityAutoScalingSettings(_))
        .ifSome(replicaStatus)(_.replicaStatus(_))
        .build

    def replicaAutoScalingUpdate(
      regionName: Option[String] = None,
      replicaGlobalSecondaryIndexUpdates: Option[List[ReplicaGlobalSecondaryIndexAutoScalingUpdate]] = None,
      replicaProvisionedReadCapacityAutoScalingUpdate: Option[AutoScalingSettingsUpdate] = None
    ): ReplicaAutoScalingUpdate =
      ReplicaAutoScalingUpdate
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(replicaGlobalSecondaryIndexUpdates)(_.replicaGlobalSecondaryIndexUpdates(_))
        .ifSome(replicaProvisionedReadCapacityAutoScalingUpdate)(_.replicaProvisionedReadCapacityAutoScalingUpdate(_))
        .build

    def replicaDescription(
      regionName: Option[String] = None,
      replicaStatus: Option[String] = None,
      replicaStatusDescription: Option[String] = None,
      replicaStatusPercentProgress: Option[String] = None,
      kMSMasterKeyId: Option[String] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughputOverride] = None,
      globalSecondaryIndexes: Option[List[ReplicaGlobalSecondaryIndexDescription]] = None,
      replicaInaccessibleDateTime: Option[Date] = None
    ): ReplicaDescription =
      ReplicaDescription
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(replicaStatus)(_.replicaStatus(_))
        .ifSome(replicaStatusDescription)(_.replicaStatusDescription(_))
        .ifSome(replicaStatusPercentProgress)(_.replicaStatusPercentProgress(_))
        .ifSome(kMSMasterKeyId)(_.kMSMasterKeyId(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(replicaInaccessibleDateTime)(_.replicaInaccessibleDateTime(_))
        .build

    def replicaGlobalSecondaryIndex(
      indexName: Option[String] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughputOverride] = None
    ): ReplicaGlobalSecondaryIndex =
      ReplicaGlobalSecondaryIndex
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .build

    def replicaGlobalSecondaryIndexAutoScalingDescription(
      indexName: Option[String] = None,
      indexStatus: Option[String] = None,
      provisionedReadCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None,
      provisionedWriteCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None
    ): ReplicaGlobalSecondaryIndexAutoScalingDescription =
      ReplicaGlobalSecondaryIndexAutoScalingDescription
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(indexStatus)(_.indexStatus(_))
        .ifSome(provisionedReadCapacityAutoScalingSettings)(_.provisionedReadCapacityAutoScalingSettings(_))
        .ifSome(provisionedWriteCapacityAutoScalingSettings)(_.provisionedWriteCapacityAutoScalingSettings(_))
        .build

    def replicaGlobalSecondaryIndexAutoScalingUpdate(
      indexName: Option[String] = None,
      provisionedReadCapacityAutoScalingUpdate: Option[AutoScalingSettingsUpdate] = None
    ): ReplicaGlobalSecondaryIndexAutoScalingUpdate =
      ReplicaGlobalSecondaryIndexAutoScalingUpdate
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedReadCapacityAutoScalingUpdate)(_.provisionedReadCapacityAutoScalingUpdate(_))
        .build

    def replicaGlobalSecondaryIndexDescription(
      indexName: Option[String] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughputOverride] = None
    ): ReplicaGlobalSecondaryIndexDescription =
      ReplicaGlobalSecondaryIndexDescription
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .build

    def replicaGlobalSecondaryIndexSettingsDescription(
      indexName: Option[String] = None,
      indexStatus: Option[String] = None,
      provisionedReadCapacityUnits: Option[PositiveLongObject] = None,
      provisionedReadCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None,
      provisionedWriteCapacityUnits: Option[PositiveLongObject] = None,
      provisionedWriteCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None
    ): ReplicaGlobalSecondaryIndexSettingsDescription =
      ReplicaGlobalSecondaryIndexSettingsDescription
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(indexStatus)(_.indexStatus(_))
        .ifSome(provisionedReadCapacityUnits)(_.provisionedReadCapacityUnits(_))
        .ifSome(provisionedReadCapacityAutoScalingSettings)(_.provisionedReadCapacityAutoScalingSettings(_))
        .ifSome(provisionedWriteCapacityUnits)(_.provisionedWriteCapacityUnits(_))
        .ifSome(provisionedWriteCapacityAutoScalingSettings)(_.provisionedWriteCapacityAutoScalingSettings(_))
        .build

    def replicaGlobalSecondaryIndexSettingsUpdate(
      indexName: Option[String] = None,
      provisionedReadCapacityUnits: Option[PositiveLongObject] = None,
      provisionedReadCapacityAutoScalingSettingsUpdate: Option[AutoScalingSettingsUpdate] = None
    ): ReplicaGlobalSecondaryIndexSettingsUpdate =
      ReplicaGlobalSecondaryIndexSettingsUpdate
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedReadCapacityUnits)(_.provisionedReadCapacityUnits(_))
        .ifSome(provisionedReadCapacityAutoScalingSettingsUpdate)(_.provisionedReadCapacityAutoScalingSettingsUpdate(_))
        .build

    def replicaNotFoundException(
      message: Option[String] = None
    ): ReplicaNotFoundException =
      ReplicaNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def replicaSettingsDescription(
      regionName: Option[String] = None,
      replicaStatus: Option[String] = None,
      replicaBillingModeSummary: Option[BillingModeSummary] = None,
      replicaProvisionedReadCapacityUnits: Option[NonNegativeLongObject] = None,
      replicaProvisionedReadCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None,
      replicaProvisionedWriteCapacityUnits: Option[NonNegativeLongObject] = None,
      replicaProvisionedWriteCapacityAutoScalingSettings: Option[AutoScalingSettingsDescription] = None,
      replicaGlobalSecondaryIndexSettings: Option[List[ReplicaGlobalSecondaryIndexSettingsDescription]] = None
    ): ReplicaSettingsDescription =
      ReplicaSettingsDescription
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(replicaStatus)(_.replicaStatus(_))
        .ifSome(replicaBillingModeSummary)(_.replicaBillingModeSummary(_))
        .ifSome(replicaProvisionedReadCapacityUnits)(_.replicaProvisionedReadCapacityUnits(_))
        .ifSome(replicaProvisionedReadCapacityAutoScalingSettings)(_.replicaProvisionedReadCapacityAutoScalingSettings(_))
        .ifSome(replicaProvisionedWriteCapacityUnits)(_.replicaProvisionedWriteCapacityUnits(_))
        .ifSome(replicaProvisionedWriteCapacityAutoScalingSettings)(_.replicaProvisionedWriteCapacityAutoScalingSettings(_))
        .ifSome(replicaGlobalSecondaryIndexSettings)(_.replicaGlobalSecondaryIndexSettings(_))
        .build

    def replicaSettingsUpdate(
      regionName: Option[String] = None,
      replicaProvisionedReadCapacityUnits: Option[PositiveLongObject] = None,
      replicaProvisionedReadCapacityAutoScalingSettingsUpdate: Option[AutoScalingSettingsUpdate] = None,
      replicaGlobalSecondaryIndexSettingsUpdate: Option[List[ReplicaGlobalSecondaryIndexSettingsUpdate]] = None
    ): ReplicaSettingsUpdate =
      ReplicaSettingsUpdate
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(replicaProvisionedReadCapacityUnits)(_.replicaProvisionedReadCapacityUnits(_))
        .ifSome(replicaProvisionedReadCapacityAutoScalingSettingsUpdate)(_.replicaProvisionedReadCapacityAutoScalingSettingsUpdate(_))
        .ifSome(replicaGlobalSecondaryIndexSettingsUpdate)(_.replicaGlobalSecondaryIndexSettingsUpdate(_))
        .build

    def replicaUpdate(
      create: Option[CreateReplicaAction] = None,
      delete: Option[DeleteReplicaAction] = None
    ): ReplicaUpdate =
      ReplicaUpdate
        .builder
        .ifSome(create)(_.create(_))
        .ifSome(delete)(_.delete(_))
        .build

    def replicationGroupUpdate(
      create: Option[CreateReplicationGroupMemberAction] = None,
      update: Option[UpdateReplicationGroupMemberAction] = None,
      delete: Option[DeleteReplicationGroupMemberAction] = None
    ): ReplicationGroupUpdate =
      ReplicationGroupUpdate
        .builder
        .ifSome(create)(_.create(_))
        .ifSome(update)(_.update(_))
        .ifSome(delete)(_.delete(_))
        .build

    def requestLimitExceeded(
      message: Option[String] = None
    ): RequestLimitExceeded =
      RequestLimitExceeded
        .builder
        .ifSome(message)(_.message(_))
        .build

    def resourceInUseException(
      message: Option[String] = None
    ): ResourceInUseException =
      ResourceInUseException
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

    def restoreSummary(
      sourceBackupArn: Option[String] = None,
      sourceTableArn: Option[String] = None,
      restoreDateTime: Option[Date] = None,
      restoreInProgress: Option[Boolean] = None
    ): RestoreSummary =
      RestoreSummary
        .builder
        .ifSome(sourceBackupArn)(_.sourceBackupArn(_))
        .ifSome(sourceTableArn)(_.sourceTableArn(_))
        .ifSome(restoreDateTime)(_.restoreDateTime(_))
        .ifSome(restoreInProgress)(_.restoreInProgress(_))
        .build

    def restoreTableFromBackupInput(
      targetTableName: Option[String] = None,
      backupArn: Option[String] = None,
      billingModeOverride: Option[String] = None,
      globalSecondaryIndexOverride: Option[List[GlobalSecondaryIndex]] = None,
      localSecondaryIndexOverride: Option[List[LocalSecondaryIndex]] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughput] = None,
      sSESpecificationOverride: Option[SSESpecification] = None
    ): RestoreTableFromBackupInput =
      RestoreTableFromBackupInput
        .builder
        .ifSome(targetTableName)(_.targetTableName(_))
        .ifSome(backupArn)(_.backupArn(_))
        .ifSome(billingModeOverride)(_.billingModeOverride(_))
        .ifSome(globalSecondaryIndexOverride)(_.globalSecondaryIndexOverride(_))
        .ifSome(localSecondaryIndexOverride)(_.localSecondaryIndexOverride(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .ifSome(sSESpecificationOverride)(_.sSESpecificationOverride(_))
        .build

    def restoreTableFromBackupOutput(
      tableDescription: Option[TableDescription] = None
    ): RestoreTableFromBackupOutput =
      RestoreTableFromBackupOutput
        .builder
        .ifSome(tableDescription)(_.tableDescription(_))
        .build

    def restoreTableToPointInTimeInput(
      sourceTableArn: Option[String] = None,
      sourceTableName: Option[String] = None,
      targetTableName: Option[String] = None,
      useLatestRestorableTime: Option[Boolean] = None,
      restoreDateTime: Option[Date] = None,
      billingModeOverride: Option[String] = None,
      globalSecondaryIndexOverride: Option[List[GlobalSecondaryIndex]] = None,
      localSecondaryIndexOverride: Option[List[LocalSecondaryIndex]] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughput] = None,
      sSESpecificationOverride: Option[SSESpecification] = None
    ): RestoreTableToPointInTimeInput =
      RestoreTableToPointInTimeInput
        .builder
        .ifSome(sourceTableArn)(_.sourceTableArn(_))
        .ifSome(sourceTableName)(_.sourceTableName(_))
        .ifSome(targetTableName)(_.targetTableName(_))
        .ifSome(useLatestRestorableTime)(_.useLatestRestorableTime(_))
        .ifSome(restoreDateTime)(_.restoreDateTime(_))
        .ifSome(billingModeOverride)(_.billingModeOverride(_))
        .ifSome(globalSecondaryIndexOverride)(_.globalSecondaryIndexOverride(_))
        .ifSome(localSecondaryIndexOverride)(_.localSecondaryIndexOverride(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .ifSome(sSESpecificationOverride)(_.sSESpecificationOverride(_))
        .build

    def restoreTableToPointInTimeOutput(
      tableDescription: Option[TableDescription] = None
    ): RestoreTableToPointInTimeOutput =
      RestoreTableToPointInTimeOutput
        .builder
        .ifSome(tableDescription)(_.tableDescription(_))
        .build

    def sSEDescription(
      status: Option[String] = None,
      sSEType: Option[String] = None,
      kMSMasterKeyArn: Option[String] = None,
      inaccessibleEncryptionDateTime: Option[Date] = None
    ): SSEDescription =
      SSEDescription
        .builder
        .ifSome(status)(_.status(_))
        .ifSome(sSEType)(_.sSEType(_))
        .ifSome(kMSMasterKeyArn)(_.kMSMasterKeyArn(_))
        .ifSome(inaccessibleEncryptionDateTime)(_.inaccessibleEncryptionDateTime(_))
        .build

    def sSESpecification(
      enabled: Option[Boolean] = None,
      sSEType: Option[String] = None,
      kMSMasterKeyId: Option[String] = None
    ): SSESpecification =
      SSESpecification
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(sSEType)(_.sSEType(_))
        .ifSome(kMSMasterKeyId)(_.kMSMasterKeyId(_))
        .build

    def scanInput(
      tableName: Option[String] = None,
      indexName: Option[String] = None,
      attributesToGet: Option[List[AttributeName]] = None,
      limit: Option[Int] = None,
      select: Option[String] = None,
      scanFilter: Option[FilterConditionMap] = None,
      conditionalOperator: Option[String] = None,
      exclusiveStartKey: Option[Key] = None,
      returnConsumedCapacity: Option[String] = None,
      totalSegments: Option[Int] = None,
      segment: Option[Int] = None,
      projectionExpression: Option[String] = None,
      filterExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None,
      consistentRead: Option[Boolean] = None
    ): ScanInput =
      ScanInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(attributesToGet)(_.attributesToGet(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(select)(_.select(_))
        .ifSome(scanFilter)(_.scanFilter(_))
        .ifSome(conditionalOperator)(_.conditionalOperator(_))
        .ifSome(exclusiveStartKey)(_.exclusiveStartKey(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(totalSegments)(_.totalSegments(_))
        .ifSome(segment)(_.segment(_))
        .ifSome(projectionExpression)(_.projectionExpression(_))
        .ifSome(filterExpression)(_.filterExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .ifSome(consistentRead)(_.consistentRead(_))
        .build

    def scanOutput(
      items: Option[List[AttributeMap]] = None,
      count: Option[Int] = None,
      scannedCount: Option[Int] = None,
      lastEvaluatedKey: Option[Key] = None,
      consumedCapacity: Option[ConsumedCapacity] = None
    ): ScanOutput =
      ScanOutput
        .builder
        .ifSome(items)(_.items(_))
        .ifSome(count)(_.count(_))
        .ifSome(scannedCount)(_.scannedCount(_))
        .ifSome(lastEvaluatedKey)(_.lastEvaluatedKey(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .build

    def sourceTableDetails(
      tableName: Option[String] = None,
      tableId: Option[String] = None,
      tableArn: Option[String] = None,
      tableSizeBytes: Option[Long] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      tableCreationDateTime: Option[TableCreationDateTime] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None,
      itemCount: Option[ItemCount] = None,
      billingMode: Option[String] = None
    ): SourceTableDetails =
      SourceTableDetails
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(tableArn)(_.tableArn(_))
        .ifSome(tableSizeBytes)(_.tableSizeBytes(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(tableCreationDateTime)(_.tableCreationDateTime(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(billingMode)(_.billingMode(_))
        .build

    def sourceTableFeatureDetails(
      localSecondaryIndexes: Option[List[LocalSecondaryIndexInfo]] = None,
      globalSecondaryIndexes: Option[List[GlobalSecondaryIndexInfo]] = None,
      streamDescription: Option[StreamSpecification] = None,
      timeToLiveDescription: Option[TimeToLiveDescription] = None,
      sSEDescription: Option[SSEDescription] = None
    ): SourceTableFeatureDetails =
      SourceTableFeatureDetails
        .builder
        .ifSome(localSecondaryIndexes)(_.localSecondaryIndexes(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(streamDescription)(_.streamDescription(_))
        .ifSome(timeToLiveDescription)(_.timeToLiveDescription(_))
        .ifSome(sSEDescription)(_.sSEDescription(_))
        .build

    def streamSpecification(
      streamEnabled: Option[Boolean] = None,
      streamViewType: Option[String] = None
    ): StreamSpecification =
      StreamSpecification
        .builder
        .ifSome(streamEnabled)(_.streamEnabled(_))
        .ifSome(streamViewType)(_.streamViewType(_))
        .build

    def tableAlreadyExistsException(
      message: Option[String] = None
    ): TableAlreadyExistsException =
      TableAlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tableAutoScalingDescription(
      tableName: Option[String] = None,
      tableStatus: Option[String] = None,
      replicas: Option[List[ReplicaAutoScalingDescription]] = None
    ): TableAutoScalingDescription =
      TableAutoScalingDescription
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(tableStatus)(_.tableStatus(_))
        .ifSome(replicas)(_.replicas(_))
        .build

    def tableDescription(
      attributeDefinitions: Option[List[AttributeDefinition]] = None,
      tableName: Option[String] = None,
      keySchema: Option[List[KeySchemaElement]] = None,
      tableStatus: Option[String] = None,
      creationDateTime: Option[Date] = None,
      provisionedThroughput: Option[ProvisionedThroughputDescription] = None,
      tableSizeBytes: Option[Long] = None,
      itemCount: Option[Long] = None,
      tableArn: Option[String] = None,
      tableId: Option[String] = None,
      billingModeSummary: Option[BillingModeSummary] = None,
      localSecondaryIndexes: Option[List[LocalSecondaryIndexDescription]] = None,
      globalSecondaryIndexes: Option[List[GlobalSecondaryIndexDescription]] = None,
      streamSpecification: Option[StreamSpecification] = None,
      latestStreamLabel: Option[String] = None,
      latestStreamArn: Option[String] = None,
      globalTableVersion: Option[String] = None,
      replicas: Option[List[ReplicaDescription]] = None,
      restoreSummary: Option[RestoreSummary] = None,
      sSEDescription: Option[SSEDescription] = None,
      archivalSummary: Option[ArchivalSummary] = None
    ): TableDescription =
      TableDescription
        .builder
        .ifSome(attributeDefinitions)(_.attributeDefinitions(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(keySchema)(_.keySchema(_))
        .ifSome(tableStatus)(_.tableStatus(_))
        .ifSome(creationDateTime)(_.creationDateTime(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .ifSome(tableSizeBytes)(_.tableSizeBytes(_))
        .ifSome(itemCount)(_.itemCount(_))
        .ifSome(tableArn)(_.tableArn(_))
        .ifSome(tableId)(_.tableId(_))
        .ifSome(billingModeSummary)(_.billingModeSummary(_))
        .ifSome(localSecondaryIndexes)(_.localSecondaryIndexes(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .ifSome(streamSpecification)(_.streamSpecification(_))
        .ifSome(latestStreamLabel)(_.latestStreamLabel(_))
        .ifSome(latestStreamArn)(_.latestStreamArn(_))
        .ifSome(globalTableVersion)(_.globalTableVersion(_))
        .ifSome(replicas)(_.replicas(_))
        .ifSome(restoreSummary)(_.restoreSummary(_))
        .ifSome(sSEDescription)(_.sSEDescription(_))
        .ifSome(archivalSummary)(_.archivalSummary(_))
        .build

    def tableInUseException(
      message: Option[String] = None
    ): TableInUseException =
      TableInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tableNotFoundException(
      message: Option[String] = None
    ): TableNotFoundException =
      TableNotFoundException
        .builder
        .ifSome(message)(_.message(_))
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

    def tagResourceInput(
      resourceArn: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceInput =
      TagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tags)(_.tags(_))
        .build

    def timeToLiveDescription(
      timeToLiveStatus: Option[String] = None,
      attributeName: Option[String] = None
    ): TimeToLiveDescription =
      TimeToLiveDescription
        .builder
        .ifSome(timeToLiveStatus)(_.timeToLiveStatus(_))
        .ifSome(attributeName)(_.attributeName(_))
        .build

    def timeToLiveSpecification(
      enabled: Option[Boolean] = None,
      attributeName: Option[String] = None
    ): TimeToLiveSpecification =
      TimeToLiveSpecification
        .builder
        .ifSome(enabled)(_.enabled(_))
        .ifSome(attributeName)(_.attributeName(_))
        .build

    def transactGetItem(
      get: Option[Get] = None
    ): TransactGetItem =
      TransactGetItem
        .builder
        .ifSome(get)(_.get(_))
        .build

    def transactGetItemsInput(
      transactItems: Option[List[TransactGetItem]] = None,
      returnConsumedCapacity: Option[String] = None
    ): TransactGetItemsInput =
      TransactGetItemsInput
        .builder
        .ifSome(transactItems)(_.transactItems(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .build

    def transactGetItemsOutput(
      consumedCapacity: Option[List[ConsumedCapacity]] = None,
      responses: Option[List[ItemResponse]] = None
    ): TransactGetItemsOutput =
      TransactGetItemsOutput
        .builder
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .ifSome(responses)(_.responses(_))
        .build

    def transactWriteItem(
      conditionCheck: Option[ConditionCheck] = None,
      put: Option[Put] = None,
      delete: Option[Delete] = None,
      update: Option[Update] = None
    ): TransactWriteItem =
      TransactWriteItem
        .builder
        .ifSome(conditionCheck)(_.conditionCheck(_))
        .ifSome(put)(_.put(_))
        .ifSome(delete)(_.delete(_))
        .ifSome(update)(_.update(_))
        .build

    def transactWriteItemsInput(
      transactItems: Option[List[TransactWriteItem]] = None,
      returnConsumedCapacity: Option[String] = None,
      returnItemCollectionMetrics: Option[String] = None,
      clientRequestToken: Option[String] = None
    ): TransactWriteItemsInput =
      TransactWriteItemsInput
        .builder
        .ifSome(transactItems)(_.transactItems(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(returnItemCollectionMetrics)(_.returnItemCollectionMetrics(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .build

    def transactWriteItemsOutput(
      consumedCapacity: Option[List[ConsumedCapacity]] = None,
      itemCollectionMetrics: Option[ItemCollectionMetricsPerTable] = None
    ): TransactWriteItemsOutput =
      TransactWriteItemsOutput
        .builder
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .ifSome(itemCollectionMetrics)(_.itemCollectionMetrics(_))
        .build

    def transactionCanceledException(
      message: Option[String] = None,
      cancellationReasons: Option[List[CancellationReason]] = None
    ): TransactionCanceledException =
      TransactionCanceledException
        .builder
        .ifSome(message)(_.message(_))
        .ifSome(cancellationReasons)(_.cancellationReasons(_))
        .build

    def transactionConflictException(
      message: Option[String] = None
    ): TransactionConflictException =
      TransactionConflictException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def transactionInProgressException(
      message: Option[String] = None
    ): TransactionInProgressException =
      TransactionInProgressException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceInput(
      resourceArn: Option[String] = None,
      tagKeys: Option[List[TagKeyString]] = None
    ): UntagResourceInput =
      UntagResourceInput
        .builder
        .ifSome(resourceArn)(_.resourceArn(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def update(
      key: Option[Key] = None,
      updateExpression: Option[String] = None,
      tableName: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None,
      returnValuesOnConditionCheckFailure: Option[String] = None
    ): Update =
      Update
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(updateExpression)(_.updateExpression(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .ifSome(returnValuesOnConditionCheckFailure)(_.returnValuesOnConditionCheckFailure(_))
        .build

    def updateContinuousBackupsInput(
      tableName: Option[String] = None,
      pointInTimeRecoverySpecification: Option[PointInTimeRecoverySpecification] = None
    ): UpdateContinuousBackupsInput =
      UpdateContinuousBackupsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(pointInTimeRecoverySpecification)(_.pointInTimeRecoverySpecification(_))
        .build

    def updateContinuousBackupsOutput(
      continuousBackupsDescription: Option[ContinuousBackupsDescription] = None
    ): UpdateContinuousBackupsOutput =
      UpdateContinuousBackupsOutput
        .builder
        .ifSome(continuousBackupsDescription)(_.continuousBackupsDescription(_))
        .build

    def updateContributorInsightsInput(
      tableName: Option[String] = None,
      indexName: Option[String] = None,
      contributorInsightsAction: Option[String] = None
    ): UpdateContributorInsightsInput =
      UpdateContributorInsightsInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(contributorInsightsAction)(_.contributorInsightsAction(_))
        .build

    def updateContributorInsightsOutput(
      tableName: Option[String] = None,
      indexName: Option[String] = None,
      contributorInsightsStatus: Option[String] = None
    ): UpdateContributorInsightsOutput =
      UpdateContributorInsightsOutput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(indexName)(_.indexName(_))
        .ifSome(contributorInsightsStatus)(_.contributorInsightsStatus(_))
        .build

    def updateGlobalSecondaryIndexAction(
      indexName: Option[String] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None
    ): UpdateGlobalSecondaryIndexAction =
      UpdateGlobalSecondaryIndexAction
        .builder
        .ifSome(indexName)(_.indexName(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .build

    def updateGlobalTableInput(
      globalTableName: Option[String] = None,
      replicaUpdates: Option[List[ReplicaUpdate]] = None
    ): UpdateGlobalTableInput =
      UpdateGlobalTableInput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .ifSome(replicaUpdates)(_.replicaUpdates(_))
        .build

    def updateGlobalTableOutput(
      globalTableDescription: Option[GlobalTableDescription] = None
    ): UpdateGlobalTableOutput =
      UpdateGlobalTableOutput
        .builder
        .ifSome(globalTableDescription)(_.globalTableDescription(_))
        .build

    def updateGlobalTableSettingsInput(
      globalTableName: Option[String] = None,
      globalTableBillingMode: Option[String] = None,
      globalTableProvisionedWriteCapacityUnits: Option[PositiveLongObject] = None,
      globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate: Option[AutoScalingSettingsUpdate] = None,
      globalTableGlobalSecondaryIndexSettingsUpdate: Option[List[GlobalTableGlobalSecondaryIndexSettingsUpdate]] = None,
      replicaSettingsUpdate: Option[List[ReplicaSettingsUpdate]] = None
    ): UpdateGlobalTableSettingsInput =
      UpdateGlobalTableSettingsInput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .ifSome(globalTableBillingMode)(_.globalTableBillingMode(_))
        .ifSome(globalTableProvisionedWriteCapacityUnits)(_.globalTableProvisionedWriteCapacityUnits(_))
        .ifSome(globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate)(_.globalTableProvisionedWriteCapacityAutoScalingSettingsUpdate(_))
        .ifSome(globalTableGlobalSecondaryIndexSettingsUpdate)(_.globalTableGlobalSecondaryIndexSettingsUpdate(_))
        .ifSome(replicaSettingsUpdate)(_.replicaSettingsUpdate(_))
        .build

    def updateGlobalTableSettingsOutput(
      globalTableName: Option[String] = None,
      replicaSettings: Option[List[ReplicaSettingsDescription]] = None
    ): UpdateGlobalTableSettingsOutput =
      UpdateGlobalTableSettingsOutput
        .builder
        .ifSome(globalTableName)(_.globalTableName(_))
        .ifSome(replicaSettings)(_.replicaSettings(_))
        .build

    def updateItemInput(
      tableName: Option[String] = None,
      key: Option[Key] = None,
      attributeUpdates: Option[AttributeUpdates] = None,
      expected: Option[ExpectedAttributeMap] = None,
      conditionalOperator: Option[String] = None,
      returnValues: Option[String] = None,
      returnConsumedCapacity: Option[String] = None,
      returnItemCollectionMetrics: Option[String] = None,
      updateExpression: Option[String] = None,
      conditionExpression: Option[String] = None,
      expressionAttributeNames: Option[ExpressionAttributeNameMap] = None,
      expressionAttributeValues: Option[ExpressionAttributeValueMap] = None
    ): UpdateItemInput =
      UpdateItemInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(key)(_.key(_))
        .ifSome(attributeUpdates)(_.attributeUpdates(_))
        .ifSome(expected)(_.expected(_))
        .ifSome(conditionalOperator)(_.conditionalOperator(_))
        .ifSome(returnValues)(_.returnValues(_))
        .ifSome(returnConsumedCapacity)(_.returnConsumedCapacity(_))
        .ifSome(returnItemCollectionMetrics)(_.returnItemCollectionMetrics(_))
        .ifSome(updateExpression)(_.updateExpression(_))
        .ifSome(conditionExpression)(_.conditionExpression(_))
        .ifSome(expressionAttributeNames)(_.expressionAttributeNames(_))
        .ifSome(expressionAttributeValues)(_.expressionAttributeValues(_))
        .build

    def updateItemOutput(
      attributes: Option[AttributeMap] = None,
      consumedCapacity: Option[ConsumedCapacity] = None,
      itemCollectionMetrics: Option[ItemCollectionMetrics] = None
    ): UpdateItemOutput =
      UpdateItemOutput
        .builder
        .ifSome(attributes)(_.attributes(_))
        .ifSome(consumedCapacity)(_.consumedCapacity(_))
        .ifSome(itemCollectionMetrics)(_.itemCollectionMetrics(_))
        .build

    def updateReplicationGroupMemberAction(
      regionName: Option[String] = None,
      kMSMasterKeyId: Option[String] = None,
      provisionedThroughputOverride: Option[ProvisionedThroughputOverride] = None,
      globalSecondaryIndexes: Option[List[ReplicaGlobalSecondaryIndex]] = None
    ): UpdateReplicationGroupMemberAction =
      UpdateReplicationGroupMemberAction
        .builder
        .ifSome(regionName)(_.regionName(_))
        .ifSome(kMSMasterKeyId)(_.kMSMasterKeyId(_))
        .ifSome(provisionedThroughputOverride)(_.provisionedThroughputOverride(_))
        .ifSome(globalSecondaryIndexes)(_.globalSecondaryIndexes(_))
        .build

    def updateTableInput(
      attributeDefinitions: Option[List[AttributeDefinition]] = None,
      tableName: Option[String] = None,
      billingMode: Option[String] = None,
      provisionedThroughput: Option[ProvisionedThroughput] = None,
      globalSecondaryIndexUpdates: Option[List[GlobalSecondaryIndexUpdate]] = None,
      streamSpecification: Option[StreamSpecification] = None,
      sSESpecification: Option[SSESpecification] = None,
      replicaUpdates: Option[List[ReplicationGroupUpdate]] = None
    ): UpdateTableInput =
      UpdateTableInput
        .builder
        .ifSome(attributeDefinitions)(_.attributeDefinitions(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(billingMode)(_.billingMode(_))
        .ifSome(provisionedThroughput)(_.provisionedThroughput(_))
        .ifSome(globalSecondaryIndexUpdates)(_.globalSecondaryIndexUpdates(_))
        .ifSome(streamSpecification)(_.streamSpecification(_))
        .ifSome(sSESpecification)(_.sSESpecification(_))
        .ifSome(replicaUpdates)(_.replicaUpdates(_))
        .build

    def updateTableOutput(
      tableDescription: Option[TableDescription] = None
    ): UpdateTableOutput =
      UpdateTableOutput
        .builder
        .ifSome(tableDescription)(_.tableDescription(_))
        .build

    def updateTableReplicaAutoScalingInput(
      globalSecondaryIndexUpdates: Option[List[GlobalSecondaryIndexAutoScalingUpdate]] = None,
      tableName: Option[String] = None,
      provisionedWriteCapacityAutoScalingUpdate: Option[AutoScalingSettingsUpdate] = None,
      replicaUpdates: Option[List[ReplicaAutoScalingUpdate]] = None
    ): UpdateTableReplicaAutoScalingInput =
      UpdateTableReplicaAutoScalingInput
        .builder
        .ifSome(globalSecondaryIndexUpdates)(_.globalSecondaryIndexUpdates(_))
        .ifSome(tableName)(_.tableName(_))
        .ifSome(provisionedWriteCapacityAutoScalingUpdate)(_.provisionedWriteCapacityAutoScalingUpdate(_))
        .ifSome(replicaUpdates)(_.replicaUpdates(_))
        .build

    def updateTableReplicaAutoScalingOutput(
      tableAutoScalingDescription: Option[TableAutoScalingDescription] = None
    ): UpdateTableReplicaAutoScalingOutput =
      UpdateTableReplicaAutoScalingOutput
        .builder
        .ifSome(tableAutoScalingDescription)(_.tableAutoScalingDescription(_))
        .build

    def updateTimeToLiveInput(
      tableName: Option[String] = None,
      timeToLiveSpecification: Option[TimeToLiveSpecification] = None
    ): UpdateTimeToLiveInput =
      UpdateTimeToLiveInput
        .builder
        .ifSome(tableName)(_.tableName(_))
        .ifSome(timeToLiveSpecification)(_.timeToLiveSpecification(_))
        .build

    def updateTimeToLiveOutput(
      timeToLiveSpecification: Option[TimeToLiveSpecification] = None
    ): UpdateTimeToLiveOutput =
      UpdateTimeToLiveOutput
        .builder
        .ifSome(timeToLiveSpecification)(_.timeToLiveSpecification(_))
        .build

    def writeRequest(
      putRequest: Option[PutRequest] = None,
      deleteRequest: Option[DeleteRequest] = None
    ): WriteRequest =
      WriteRequest
        .builder
        .ifSome(putRequest)(_.putRequest(_))
        .ifSome(deleteRequest)(_.deleteRequest(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
