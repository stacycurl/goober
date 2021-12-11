package goober.hi

import goober.free.secretsmanager.SecretsManagerIO
import software.amazon.awssdk.services.secretsmanager.model._


object secretsmanager {
  import goober.free.{secretsmanager ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def cancelRotateSecretRequest(
      secretId: Option[String] = None
    ): CancelRotateSecretRequest =
      CancelRotateSecretRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .build

    def cancelRotateSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      versionId: Option[String] = None
    ): CancelRotateSecretResponse =
      CancelRotateSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def createSecretRequest(
      name: Option[String] = None,
      clientRequestToken: Option[String] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      secretBinary: Option[SecretBinaryType] = None,
      secretString: Option[String] = None,
      tags: Option[List[Tag]] = None,
      addReplicaRegions: Option[List[ReplicaRegionType]] = None,
      forceOverwriteReplicaSecret: Option[Boolean] = None
    ): CreateSecretRequest =
      CreateSecretRequest
        .builder
        .ifSome(name)(_.name(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(secretBinary)(_.secretBinary(_))
        .ifSome(secretString)(_.secretString(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(addReplicaRegions)(_.addReplicaRegions(_))
        .ifSome(forceOverwriteReplicaSecret)(_.forceOverwriteReplicaSecret(_))
        .build

    def createSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      versionId: Option[String] = None,
      replicationStatus: Option[List[ReplicationStatusType]] = None
    ): CreateSecretResponse =
      CreateSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .build

    def decryptionFailure(
      message: Option[String] = None
    ): DecryptionFailure =
      DecryptionFailure
        .builder
        .ifSome(message)(_.message(_))
        .build

    def deleteResourcePolicyRequest(
      secretId: Option[String] = None
    ): DeleteResourcePolicyRequest =
      DeleteResourcePolicyRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .build

    def deleteResourcePolicyResponse(
      aRN: Option[String] = None,
      name: Option[String] = None
    ): DeleteResourcePolicyResponse =
      DeleteResourcePolicyResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .build

    def deleteSecretRequest(
      secretId: Option[String] = None,
      recoveryWindowInDays: Option[RecoveryWindowInDaysType] = None,
      forceDeleteWithoutRecovery: Option[Boolean] = None
    ): DeleteSecretRequest =
      DeleteSecretRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(recoveryWindowInDays)(_.recoveryWindowInDays(_))
        .ifSome(forceDeleteWithoutRecovery)(_.forceDeleteWithoutRecovery(_))
        .build

    def deleteSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      deletionDate: Option[DeletionDateType] = None
    ): DeleteSecretResponse =
      DeleteSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .build

    def describeSecretRequest(
      secretId: Option[String] = None
    ): DescribeSecretRequest =
      DescribeSecretRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .build

    def describeSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      rotationEnabled: Option[Boolean] = None,
      rotationLambdaARN: Option[String] = None,
      rotationRules: Option[RotationRulesType] = None,
      lastRotatedDate: Option[LastRotatedDateType] = None,
      lastChangedDate: Option[LastChangedDateType] = None,
      lastAccessedDate: Option[LastAccessedDateType] = None,
      deletedDate: Option[DeletedDateType] = None,
      tags: Option[List[Tag]] = None,
      versionIdsToStages: Option[SecretVersionsToStagesMapType] = None,
      owningService: Option[String] = None,
      createdDate: Option[TimestampType] = None,
      primaryRegion: Option[String] = None,
      replicationStatus: Option[List[ReplicationStatusType]] = None
    ): DescribeSecretResponse =
      DescribeSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(rotationEnabled)(_.rotationEnabled(_))
        .ifSome(rotationLambdaARN)(_.rotationLambdaARN(_))
        .ifSome(rotationRules)(_.rotationRules(_))
        .ifSome(lastRotatedDate)(_.lastRotatedDate(_))
        .ifSome(lastChangedDate)(_.lastChangedDate(_))
        .ifSome(lastAccessedDate)(_.lastAccessedDate(_))
        .ifSome(deletedDate)(_.deletedDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(versionIdsToStages)(_.versionIdsToStages(_))
        .ifSome(owningService)(_.owningService(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(primaryRegion)(_.primaryRegion(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .build

    def encryptionFailure(
      message: Option[String] = None
    ): EncryptionFailure =
      EncryptionFailure
        .builder
        .ifSome(message)(_.message(_))
        .build

    def filter(
      key: Option[String] = None,
      values: Option[List[FilterValueStringType]] = None
    ): Filter =
      Filter
        .builder
        .ifSome(key)(_.key(_))
        .ifSome(values)(_.values(_))
        .build

    def getRandomPasswordRequest(
      passwordLength: Option[PasswordLengthType] = None,
      excludeCharacters: Option[String] = None,
      excludeNumbers: Option[Boolean] = None,
      excludePunctuation: Option[Boolean] = None,
      excludeUppercase: Option[Boolean] = None,
      excludeLowercase: Option[Boolean] = None,
      includeSpace: Option[Boolean] = None,
      requireEachIncludedType: Option[Boolean] = None
    ): GetRandomPasswordRequest =
      GetRandomPasswordRequest
        .builder
        .ifSome(passwordLength)(_.passwordLength(_))
        .ifSome(excludeCharacters)(_.excludeCharacters(_))
        .ifSome(excludeNumbers)(_.excludeNumbers(_))
        .ifSome(excludePunctuation)(_.excludePunctuation(_))
        .ifSome(excludeUppercase)(_.excludeUppercase(_))
        .ifSome(excludeLowercase)(_.excludeLowercase(_))
        .ifSome(includeSpace)(_.includeSpace(_))
        .ifSome(requireEachIncludedType)(_.requireEachIncludedType(_))
        .build

    def getRandomPasswordResponse(
      randomPassword: Option[String] = None
    ): GetRandomPasswordResponse =
      GetRandomPasswordResponse
        .builder
        .ifSome(randomPassword)(_.randomPassword(_))
        .build

    def getResourcePolicyRequest(
      secretId: Option[String] = None
    ): GetResourcePolicyRequest =
      GetResourcePolicyRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .build

    def getResourcePolicyResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      resourcePolicy: Option[String] = None
    ): GetResourcePolicyResponse =
      GetResourcePolicyResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .build

    def getSecretValueRequest(
      secretId: Option[String] = None,
      versionId: Option[String] = None,
      versionStage: Option[String] = None
    ): GetSecretValueRequest =
      GetSecretValueRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(versionStage)(_.versionStage(_))
        .build

    def getSecretValueResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      versionId: Option[String] = None,
      secretBinary: Option[SecretBinaryType] = None,
      secretString: Option[String] = None,
      versionStages: Option[List[SecretVersionStageType]] = None,
      createdDate: Option[CreatedDateType] = None
    ): GetSecretValueResponse =
      GetSecretValueResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(secretBinary)(_.secretBinary(_))
        .ifSome(secretString)(_.secretString(_))
        .ifSome(versionStages)(_.versionStages(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def internalServiceError(
      message: Option[String] = None
    ): InternalServiceError =
      InternalServiceError
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidNextTokenException(
      message: Option[String] = None
    ): InvalidNextTokenException =
      InvalidNextTokenException
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

    def invalidRequestException(
      message: Option[String] = None
    ): InvalidRequestException =
      InvalidRequestException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def limitExceededException(
      message: Option[String] = None
    ): LimitExceededException =
      LimitExceededException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def listSecretVersionIdsRequest(
      secretId: Option[String] = None,
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      includeDeprecated: Option[Boolean] = None
    ): ListSecretVersionIdsRequest =
      ListSecretVersionIdsRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(includeDeprecated)(_.includeDeprecated(_))
        .build

    def listSecretVersionIdsResponse(
      versions: Option[List[SecretVersionsListEntry]] = None,
      nextToken: Option[String] = None,
      aRN: Option[String] = None,
      name: Option[String] = None
    ): ListSecretVersionIdsResponse =
      ListSecretVersionIdsResponse
        .builder
        .ifSome(versions)(_.versions(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .build

    def listSecretsRequest(
      maxResults: Option[Int] = None,
      nextToken: Option[String] = None,
      filters: Option[List[Filter]] = None,
      sortOrder: Option[String] = None
    ): ListSecretsRequest =
      ListSecretsRequest
        .builder
        .ifSome(maxResults)(_.maxResults(_))
        .ifSome(nextToken)(_.nextToken(_))
        .ifSome(filters)(_.filters(_))
        .ifSome(sortOrder)(_.sortOrder(_))
        .build

    def listSecretsResponse(
      secretList: Option[List[SecretListEntry]] = None,
      nextToken: Option[String] = None
    ): ListSecretsResponse =
      ListSecretsResponse
        .builder
        .ifSome(secretList)(_.secretList(_))
        .ifSome(nextToken)(_.nextToken(_))
        .build

    def malformedPolicyDocumentException(
      message: Option[String] = None
    ): MalformedPolicyDocumentException =
      MalformedPolicyDocumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def preconditionNotMetException(
      message: Option[String] = None
    ): PreconditionNotMetException =
      PreconditionNotMetException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def publicPolicyException(
      message: Option[String] = None
    ): PublicPolicyException =
      PublicPolicyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putResourcePolicyRequest(
      secretId: Option[String] = None,
      resourcePolicy: Option[String] = None,
      blockPublicPolicy: Option[Boolean] = None
    ): PutResourcePolicyRequest =
      PutResourcePolicyRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .ifSome(blockPublicPolicy)(_.blockPublicPolicy(_))
        .build

    def putResourcePolicyResponse(
      aRN: Option[String] = None,
      name: Option[String] = None
    ): PutResourcePolicyResponse =
      PutResourcePolicyResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .build

    def putSecretValueRequest(
      secretId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      secretBinary: Option[SecretBinaryType] = None,
      secretString: Option[String] = None,
      versionStages: Option[List[SecretVersionStageType]] = None
    ): PutSecretValueRequest =
      PutSecretValueRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(secretBinary)(_.secretBinary(_))
        .ifSome(secretString)(_.secretString(_))
        .ifSome(versionStages)(_.versionStages(_))
        .build

    def putSecretValueResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      versionId: Option[String] = None,
      versionStages: Option[List[SecretVersionStageType]] = None
    ): PutSecretValueResponse =
      PutSecretValueResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(versionId)(_.versionId(_))
        .ifSome(versionStages)(_.versionStages(_))
        .build

    def removeRegionsFromReplicationRequest(
      secretId: Option[String] = None,
      removeReplicaRegions: Option[List[RegionType]] = None
    ): RemoveRegionsFromReplicationRequest =
      RemoveRegionsFromReplicationRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(removeReplicaRegions)(_.removeReplicaRegions(_))
        .build

    def removeRegionsFromReplicationResponse(
      aRN: Option[String] = None,
      replicationStatus: Option[List[ReplicationStatusType]] = None
    ): RemoveRegionsFromReplicationResponse =
      RemoveRegionsFromReplicationResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .build

    def replicaRegionType(
      region: Option[String] = None,
      kmsKeyId: Option[String] = None
    ): ReplicaRegionType =
      ReplicaRegionType
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .build

    def replicateSecretToRegionsRequest(
      secretId: Option[String] = None,
      addReplicaRegions: Option[List[ReplicaRegionType]] = None,
      forceOverwriteReplicaSecret: Option[Boolean] = None
    ): ReplicateSecretToRegionsRequest =
      ReplicateSecretToRegionsRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(addReplicaRegions)(_.addReplicaRegions(_))
        .ifSome(forceOverwriteReplicaSecret)(_.forceOverwriteReplicaSecret(_))
        .build

    def replicateSecretToRegionsResponse(
      aRN: Option[String] = None,
      replicationStatus: Option[List[ReplicationStatusType]] = None
    ): ReplicateSecretToRegionsResponse =
      ReplicateSecretToRegionsResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(replicationStatus)(_.replicationStatus(_))
        .build

    def replicationStatusType(
      region: Option[String] = None,
      kmsKeyId: Option[String] = None,
      status: Option[String] = None,
      statusMessage: Option[String] = None,
      lastAccessedDate: Option[LastAccessedDateType] = None
    ): ReplicationStatusType =
      ReplicationStatusType
        .builder
        .ifSome(region)(_.region(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(status)(_.status(_))
        .ifSome(statusMessage)(_.statusMessage(_))
        .ifSome(lastAccessedDate)(_.lastAccessedDate(_))
        .build

    def resourceExistsException(
      message: Option[String] = None
    ): ResourceExistsException =
      ResourceExistsException
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

    def restoreSecretRequest(
      secretId: Option[String] = None
    ): RestoreSecretRequest =
      RestoreSecretRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .build

    def restoreSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None
    ): RestoreSecretResponse =
      RestoreSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .build

    def rotateSecretRequest(
      secretId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      rotationLambdaARN: Option[String] = None,
      rotationRules: Option[RotationRulesType] = None
    ): RotateSecretRequest =
      RotateSecretRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(rotationLambdaARN)(_.rotationLambdaARN(_))
        .ifSome(rotationRules)(_.rotationRules(_))
        .build

    def rotateSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      versionId: Option[String] = None
    ): RotateSecretResponse =
      RotateSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def rotationRulesType(
      automaticallyAfterDays: Option[AutomaticallyRotateAfterDaysType] = None
    ): RotationRulesType =
      RotationRulesType
        .builder
        .ifSome(automaticallyAfterDays)(_.automaticallyAfterDays(_))
        .build

    def secretListEntry(
      aRN: Option[String] = None,
      name: Option[String] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      rotationEnabled: Option[Boolean] = None,
      rotationLambdaARN: Option[String] = None,
      rotationRules: Option[RotationRulesType] = None,
      lastRotatedDate: Option[LastRotatedDateType] = None,
      lastChangedDate: Option[LastChangedDateType] = None,
      lastAccessedDate: Option[LastAccessedDateType] = None,
      deletedDate: Option[DeletedDateType] = None,
      tags: Option[List[Tag]] = None,
      secretVersionsToStages: Option[SecretVersionsToStagesMapType] = None,
      owningService: Option[String] = None,
      createdDate: Option[TimestampType] = None,
      primaryRegion: Option[String] = None
    ): SecretListEntry =
      SecretListEntry
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(rotationEnabled)(_.rotationEnabled(_))
        .ifSome(rotationLambdaARN)(_.rotationLambdaARN(_))
        .ifSome(rotationRules)(_.rotationRules(_))
        .ifSome(lastRotatedDate)(_.lastRotatedDate(_))
        .ifSome(lastChangedDate)(_.lastChangedDate(_))
        .ifSome(lastAccessedDate)(_.lastAccessedDate(_))
        .ifSome(deletedDate)(_.deletedDate(_))
        .ifSome(tags)(_.tags(_))
        .ifSome(secretVersionsToStages)(_.secretVersionsToStages(_))
        .ifSome(owningService)(_.owningService(_))
        .ifSome(createdDate)(_.createdDate(_))
        .ifSome(primaryRegion)(_.primaryRegion(_))
        .build

    def secretVersionsListEntry(
      versionId: Option[String] = None,
      versionStages: Option[List[SecretVersionStageType]] = None,
      lastAccessedDate: Option[LastAccessedDateType] = None,
      createdDate: Option[CreatedDateType] = None
    ): SecretVersionsListEntry =
      SecretVersionsListEntry
        .builder
        .ifSome(versionId)(_.versionId(_))
        .ifSome(versionStages)(_.versionStages(_))
        .ifSome(lastAccessedDate)(_.lastAccessedDate(_))
        .ifSome(createdDate)(_.createdDate(_))
        .build

    def stopReplicationToReplicaRequest(
      secretId: Option[String] = None
    ): StopReplicationToReplicaRequest =
      StopReplicationToReplicaRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .build

    def stopReplicationToReplicaResponse(
      aRN: Option[String] = None
    ): StopReplicationToReplicaResponse =
      StopReplicationToReplicaResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
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
      secretId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def untagResourceRequest(
      secretId: Option[String] = None,
      tagKeys: Option[List[TagKeyType]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateSecretRequest(
      secretId: Option[String] = None,
      clientRequestToken: Option[String] = None,
      description: Option[String] = None,
      kmsKeyId: Option[String] = None,
      secretBinary: Option[SecretBinaryType] = None,
      secretString: Option[String] = None
    ): UpdateSecretRequest =
      UpdateSecretRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(clientRequestToken)(_.clientRequestToken(_))
        .ifSome(description)(_.description(_))
        .ifSome(kmsKeyId)(_.kmsKeyId(_))
        .ifSome(secretBinary)(_.secretBinary(_))
        .ifSome(secretString)(_.secretString(_))
        .build

    def updateSecretResponse(
      aRN: Option[String] = None,
      name: Option[String] = None,
      versionId: Option[String] = None
    ): UpdateSecretResponse =
      UpdateSecretResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .ifSome(versionId)(_.versionId(_))
        .build

    def updateSecretVersionStageRequest(
      secretId: Option[String] = None,
      versionStage: Option[String] = None,
      removeFromVersionId: Option[String] = None,
      moveToVersionId: Option[String] = None
    ): UpdateSecretVersionStageRequest =
      UpdateSecretVersionStageRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(versionStage)(_.versionStage(_))
        .ifSome(removeFromVersionId)(_.removeFromVersionId(_))
        .ifSome(moveToVersionId)(_.moveToVersionId(_))
        .build

    def updateSecretVersionStageResponse(
      aRN: Option[String] = None,
      name: Option[String] = None
    ): UpdateSecretVersionStageResponse =
      UpdateSecretVersionStageResponse
        .builder
        .ifSome(aRN)(_.aRN(_))
        .ifSome(name)(_.name(_))
        .build

    def validateResourcePolicyRequest(
      secretId: Option[String] = None,
      resourcePolicy: Option[String] = None
    ): ValidateResourcePolicyRequest =
      ValidateResourcePolicyRequest
        .builder
        .ifSome(secretId)(_.secretId(_))
        .ifSome(resourcePolicy)(_.resourcePolicy(_))
        .build

    def validateResourcePolicyResponse(
      policyValidationPassed: Option[Boolean] = None,
      validationErrors: Option[List[ValidationErrorsEntry]] = None
    ): ValidateResourcePolicyResponse =
      ValidateResourcePolicyResponse
        .builder
        .ifSome(policyValidationPassed)(_.policyValidationPassed(_))
        .ifSome(validationErrors)(_.validationErrors(_))
        .build

    def validationErrorsEntry(
      checkName: Option[String] = None,
      errorMessage: Option[String] = None
    ): ValidationErrorsEntry =
      ValidationErrorsEntry
        .builder
        .ifSome(checkName)(_.checkName(_))
        .ifSome(errorMessage)(_.errorMessage(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
