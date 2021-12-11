package goober.hi

import goober.free.kms.KmsIO
import software.amazon.awssdk.services.kms.model._


object kms {
  import goober.free.{kms ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    def aliasListEntry(
      aliasName: Option[String] = None,
      aliasArn: Option[String] = None,
      targetKeyId: Option[String] = None,
      creationDate: Option[DateType] = None,
      lastUpdatedDate: Option[DateType] = None
    ): AliasListEntry =
      AliasListEntry
        .builder
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(aliasArn)(_.aliasArn(_))
        .ifSome(targetKeyId)(_.targetKeyId(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(lastUpdatedDate)(_.lastUpdatedDate(_))
        .build

    def alreadyExistsException(
      message: Option[String] = None
    ): AlreadyExistsException =
      AlreadyExistsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cancelKeyDeletionRequest(
      keyId: Option[String] = None
    ): CancelKeyDeletionRequest =
      CancelKeyDeletionRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def cancelKeyDeletionResponse(
      keyId: Option[String] = None
    ): CancelKeyDeletionResponse =
      CancelKeyDeletionResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def cloudHsmClusterInUseException(
      message: Option[String] = None
    ): CloudHsmClusterInUseException =
      CloudHsmClusterInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmClusterInvalidConfigurationException(
      message: Option[String] = None
    ): CloudHsmClusterInvalidConfigurationException =
      CloudHsmClusterInvalidConfigurationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmClusterNotActiveException(
      message: Option[String] = None
    ): CloudHsmClusterNotActiveException =
      CloudHsmClusterNotActiveException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmClusterNotFoundException(
      message: Option[String] = None
    ): CloudHsmClusterNotFoundException =
      CloudHsmClusterNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def cloudHsmClusterNotRelatedException(
      message: Option[String] = None
    ): CloudHsmClusterNotRelatedException =
      CloudHsmClusterNotRelatedException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def connectCustomKeyStoreRequest(
      customKeyStoreId: Option[String] = None
    ): ConnectCustomKeyStoreRequest =
      ConnectCustomKeyStoreRequest
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .build

    def connectCustomKeyStoreResponse(

    ): ConnectCustomKeyStoreResponse =
      ConnectCustomKeyStoreResponse
        .builder

        .build

    def createAliasRequest(
      aliasName: Option[String] = None,
      targetKeyId: Option[String] = None
    ): CreateAliasRequest =
      CreateAliasRequest
        .builder
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(targetKeyId)(_.targetKeyId(_))
        .build

    def createCustomKeyStoreRequest(
      customKeyStoreName: Option[String] = None,
      cloudHsmClusterId: Option[String] = None,
      trustAnchorCertificate: Option[String] = None,
      keyStorePassword: Option[String] = None
    ): CreateCustomKeyStoreRequest =
      CreateCustomKeyStoreRequest
        .builder
        .ifSome(customKeyStoreName)(_.customKeyStoreName(_))
        .ifSome(cloudHsmClusterId)(_.cloudHsmClusterId(_))
        .ifSome(trustAnchorCertificate)(_.trustAnchorCertificate(_))
        .ifSome(keyStorePassword)(_.keyStorePassword(_))
        .build

    def createCustomKeyStoreResponse(
      customKeyStoreId: Option[String] = None
    ): CreateCustomKeyStoreResponse =
      CreateCustomKeyStoreResponse
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .build

    def createGrantRequest(
      keyId: Option[String] = None,
      granteePrincipal: Option[String] = None,
      retiringPrincipal: Option[String] = None,
      operations: Option[List[GrantOperation]] = None,
      constraints: Option[GrantConstraints] = None,
      grantTokens: Option[List[GrantTokenType]] = None,
      name: Option[String] = None
    ): CreateGrantRequest =
      CreateGrantRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(granteePrincipal)(_.granteePrincipal(_))
        .ifSome(retiringPrincipal)(_.retiringPrincipal(_))
        .ifSome(operations)(_.operations(_))
        .ifSome(constraints)(_.constraints(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .ifSome(name)(_.name(_))
        .build

    def createGrantResponse(
      grantToken: Option[String] = None,
      grantId: Option[String] = None
    ): CreateGrantResponse =
      CreateGrantResponse
        .builder
        .ifSome(grantToken)(_.grantToken(_))
        .ifSome(grantId)(_.grantId(_))
        .build

    def createKeyRequest(
      policy: Option[String] = None,
      description: Option[String] = None,
      keyUsage: Option[String] = None,
      customerMasterKeySpec: Option[String] = None,
      origin: Option[String] = None,
      customKeyStoreId: Option[String] = None,
      bypassPolicyLockoutSafetyCheck: Option[Boolean] = None,
      tags: Option[List[Tag]] = None
    ): CreateKeyRequest =
      CreateKeyRequest
        .builder
        .ifSome(policy)(_.policy(_))
        .ifSome(description)(_.description(_))
        .ifSome(keyUsage)(_.keyUsage(_))
        .ifSome(customerMasterKeySpec)(_.customerMasterKeySpec(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .ifSome(bypassPolicyLockoutSafetyCheck)(_.bypassPolicyLockoutSafetyCheck(_))
        .ifSome(tags)(_.tags(_))
        .build

    def createKeyResponse(
      keyMetadata: Option[KeyMetadata] = None
    ): CreateKeyResponse =
      CreateKeyResponse
        .builder
        .ifSome(keyMetadata)(_.keyMetadata(_))
        .build

    def customKeyStoreHasCMKsException(
      message: Option[String] = None
    ): CustomKeyStoreHasCMKsException =
      CustomKeyStoreHasCMKsException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def customKeyStoreInvalidStateException(
      message: Option[String] = None
    ): CustomKeyStoreInvalidStateException =
      CustomKeyStoreInvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def customKeyStoreNameInUseException(
      message: Option[String] = None
    ): CustomKeyStoreNameInUseException =
      CustomKeyStoreNameInUseException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def customKeyStoreNotFoundException(
      message: Option[String] = None
    ): CustomKeyStoreNotFoundException =
      CustomKeyStoreNotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def customKeyStoresListEntry(
      customKeyStoreId: Option[String] = None,
      customKeyStoreName: Option[String] = None,
      cloudHsmClusterId: Option[String] = None,
      trustAnchorCertificate: Option[String] = None,
      connectionState: Option[String] = None,
      connectionErrorCode: Option[String] = None,
      creationDate: Option[DateType] = None
    ): CustomKeyStoresListEntry =
      CustomKeyStoresListEntry
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .ifSome(customKeyStoreName)(_.customKeyStoreName(_))
        .ifSome(cloudHsmClusterId)(_.cloudHsmClusterId(_))
        .ifSome(trustAnchorCertificate)(_.trustAnchorCertificate(_))
        .ifSome(connectionState)(_.connectionState(_))
        .ifSome(connectionErrorCode)(_.connectionErrorCode(_))
        .ifSome(creationDate)(_.creationDate(_))
        .build

    def decryptRequest(
      ciphertextBlob: Option[CiphertextType] = None,
      encryptionContext: Option[EncryptionContextType] = None,
      grantTokens: Option[List[GrantTokenType]] = None,
      keyId: Option[String] = None,
      encryptionAlgorithm: Option[String] = None
    ): DecryptRequest =
      DecryptRequest
        .builder
        .ifSome(ciphertextBlob)(_.ciphertextBlob(_))
        .ifSome(encryptionContext)(_.encryptionContext(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(encryptionAlgorithm)(_.encryptionAlgorithm(_))
        .build

    def decryptResponse(
      keyId: Option[String] = None,
      plaintext: Option[PlaintextType] = None,
      encryptionAlgorithm: Option[String] = None
    ): DecryptResponse =
      DecryptResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(plaintext)(_.plaintext(_))
        .ifSome(encryptionAlgorithm)(_.encryptionAlgorithm(_))
        .build

    def deleteAliasRequest(
      aliasName: Option[String] = None
    ): DeleteAliasRequest =
      DeleteAliasRequest
        .builder
        .ifSome(aliasName)(_.aliasName(_))
        .build

    def deleteCustomKeyStoreRequest(
      customKeyStoreId: Option[String] = None
    ): DeleteCustomKeyStoreRequest =
      DeleteCustomKeyStoreRequest
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .build

    def deleteCustomKeyStoreResponse(

    ): DeleteCustomKeyStoreResponse =
      DeleteCustomKeyStoreResponse
        .builder

        .build

    def deleteImportedKeyMaterialRequest(
      keyId: Option[String] = None
    ): DeleteImportedKeyMaterialRequest =
      DeleteImportedKeyMaterialRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def dependencyTimeoutException(
      message: Option[String] = None
    ): DependencyTimeoutException =
      DependencyTimeoutException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def describeCustomKeyStoresRequest(
      customKeyStoreId: Option[String] = None,
      customKeyStoreName: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): DescribeCustomKeyStoresRequest =
      DescribeCustomKeyStoresRequest
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .ifSome(customKeyStoreName)(_.customKeyStoreName(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def describeCustomKeyStoresResponse(
      customKeyStores: Option[List[CustomKeyStoresListEntry]] = None,
      nextMarker: Option[String] = None,
      truncated: Option[Boolean] = None
    ): DescribeCustomKeyStoresResponse =
      DescribeCustomKeyStoresResponse
        .builder
        .ifSome(customKeyStores)(_.customKeyStores(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def describeKeyRequest(
      keyId: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): DescribeKeyRequest =
      DescribeKeyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def describeKeyResponse(
      keyMetadata: Option[KeyMetadata] = None
    ): DescribeKeyResponse =
      DescribeKeyResponse
        .builder
        .ifSome(keyMetadata)(_.keyMetadata(_))
        .build

    def disableKeyRequest(
      keyId: Option[String] = None
    ): DisableKeyRequest =
      DisableKeyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def disableKeyRotationRequest(
      keyId: Option[String] = None
    ): DisableKeyRotationRequest =
      DisableKeyRotationRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def disabledException(
      message: Option[String] = None
    ): DisabledException =
      DisabledException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def disconnectCustomKeyStoreRequest(
      customKeyStoreId: Option[String] = None
    ): DisconnectCustomKeyStoreRequest =
      DisconnectCustomKeyStoreRequest
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .build

    def disconnectCustomKeyStoreResponse(

    ): DisconnectCustomKeyStoreResponse =
      DisconnectCustomKeyStoreResponse
        .builder

        .build

    def enableKeyRequest(
      keyId: Option[String] = None
    ): EnableKeyRequest =
      EnableKeyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def enableKeyRotationRequest(
      keyId: Option[String] = None
    ): EnableKeyRotationRequest =
      EnableKeyRotationRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def encryptRequest(
      keyId: Option[String] = None,
      plaintext: Option[PlaintextType] = None,
      encryptionContext: Option[EncryptionContextType] = None,
      grantTokens: Option[List[GrantTokenType]] = None,
      encryptionAlgorithm: Option[String] = None
    ): EncryptRequest =
      EncryptRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(plaintext)(_.plaintext(_))
        .ifSome(encryptionContext)(_.encryptionContext(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .ifSome(encryptionAlgorithm)(_.encryptionAlgorithm(_))
        .build

    def encryptResponse(
      ciphertextBlob: Option[CiphertextType] = None,
      keyId: Option[String] = None,
      encryptionAlgorithm: Option[String] = None
    ): EncryptResponse =
      EncryptResponse
        .builder
        .ifSome(ciphertextBlob)(_.ciphertextBlob(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(encryptionAlgorithm)(_.encryptionAlgorithm(_))
        .build

    def expiredImportTokenException(
      message: Option[String] = None
    ): ExpiredImportTokenException =
      ExpiredImportTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def generateDataKeyPairRequest(
      encryptionContext: Option[EncryptionContextType] = None,
      keyId: Option[String] = None,
      keyPairSpec: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): GenerateDataKeyPairRequest =
      GenerateDataKeyPairRequest
        .builder
        .ifSome(encryptionContext)(_.encryptionContext(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyPairSpec)(_.keyPairSpec(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def generateDataKeyPairResponse(
      privateKeyCiphertextBlob: Option[CiphertextType] = None,
      privateKeyPlaintext: Option[PlaintextType] = None,
      publicKey: Option[PublicKeyType] = None,
      keyId: Option[String] = None,
      keyPairSpec: Option[String] = None
    ): GenerateDataKeyPairResponse =
      GenerateDataKeyPairResponse
        .builder
        .ifSome(privateKeyCiphertextBlob)(_.privateKeyCiphertextBlob(_))
        .ifSome(privateKeyPlaintext)(_.privateKeyPlaintext(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyPairSpec)(_.keyPairSpec(_))
        .build

    def generateDataKeyPairWithoutPlaintextRequest(
      encryptionContext: Option[EncryptionContextType] = None,
      keyId: Option[String] = None,
      keyPairSpec: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): GenerateDataKeyPairWithoutPlaintextRequest =
      GenerateDataKeyPairWithoutPlaintextRequest
        .builder
        .ifSome(encryptionContext)(_.encryptionContext(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyPairSpec)(_.keyPairSpec(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def generateDataKeyPairWithoutPlaintextResponse(
      privateKeyCiphertextBlob: Option[CiphertextType] = None,
      publicKey: Option[PublicKeyType] = None,
      keyId: Option[String] = None,
      keyPairSpec: Option[String] = None
    ): GenerateDataKeyPairWithoutPlaintextResponse =
      GenerateDataKeyPairWithoutPlaintextResponse
        .builder
        .ifSome(privateKeyCiphertextBlob)(_.privateKeyCiphertextBlob(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyPairSpec)(_.keyPairSpec(_))
        .build

    def generateDataKeyRequest(
      keyId: Option[String] = None,
      encryptionContext: Option[EncryptionContextType] = None,
      numberOfBytes: Option[Int] = None,
      keySpec: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): GenerateDataKeyRequest =
      GenerateDataKeyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(encryptionContext)(_.encryptionContext(_))
        .ifSome(numberOfBytes)(_.numberOfBytes(_))
        .ifSome(keySpec)(_.keySpec(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def generateDataKeyResponse(
      ciphertextBlob: Option[CiphertextType] = None,
      plaintext: Option[PlaintextType] = None,
      keyId: Option[String] = None
    ): GenerateDataKeyResponse =
      GenerateDataKeyResponse
        .builder
        .ifSome(ciphertextBlob)(_.ciphertextBlob(_))
        .ifSome(plaintext)(_.plaintext(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def generateDataKeyWithoutPlaintextRequest(
      keyId: Option[String] = None,
      encryptionContext: Option[EncryptionContextType] = None,
      keySpec: Option[String] = None,
      numberOfBytes: Option[Int] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): GenerateDataKeyWithoutPlaintextRequest =
      GenerateDataKeyWithoutPlaintextRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(encryptionContext)(_.encryptionContext(_))
        .ifSome(keySpec)(_.keySpec(_))
        .ifSome(numberOfBytes)(_.numberOfBytes(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def generateDataKeyWithoutPlaintextResponse(
      ciphertextBlob: Option[CiphertextType] = None,
      keyId: Option[String] = None
    ): GenerateDataKeyWithoutPlaintextResponse =
      GenerateDataKeyWithoutPlaintextResponse
        .builder
        .ifSome(ciphertextBlob)(_.ciphertextBlob(_))
        .ifSome(keyId)(_.keyId(_))
        .build

    def generateRandomRequest(
      numberOfBytes: Option[Int] = None,
      customKeyStoreId: Option[String] = None
    ): GenerateRandomRequest =
      GenerateRandomRequest
        .builder
        .ifSome(numberOfBytes)(_.numberOfBytes(_))
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .build

    def generateRandomResponse(
      plaintext: Option[PlaintextType] = None
    ): GenerateRandomResponse =
      GenerateRandomResponse
        .builder
        .ifSome(plaintext)(_.plaintext(_))
        .build

    def getKeyPolicyRequest(
      keyId: Option[String] = None,
      policyName: Option[String] = None
    ): GetKeyPolicyRequest =
      GetKeyPolicyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(policyName)(_.policyName(_))
        .build

    def getKeyPolicyResponse(
      policy: Option[String] = None
    ): GetKeyPolicyResponse =
      GetKeyPolicyResponse
        .builder
        .ifSome(policy)(_.policy(_))
        .build

    def getKeyRotationStatusRequest(
      keyId: Option[String] = None
    ): GetKeyRotationStatusRequest =
      GetKeyRotationStatusRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .build

    def getKeyRotationStatusResponse(
      keyRotationEnabled: Option[Boolean] = None
    ): GetKeyRotationStatusResponse =
      GetKeyRotationStatusResponse
        .builder
        .ifSome(keyRotationEnabled)(_.keyRotationEnabled(_))
        .build

    def getParametersForImportRequest(
      keyId: Option[String] = None,
      wrappingAlgorithm: Option[String] = None,
      wrappingKeySpec: Option[String] = None
    ): GetParametersForImportRequest =
      GetParametersForImportRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(wrappingAlgorithm)(_.wrappingAlgorithm(_))
        .ifSome(wrappingKeySpec)(_.wrappingKeySpec(_))
        .build

    def getParametersForImportResponse(
      keyId: Option[String] = None,
      importToken: Option[CiphertextType] = None,
      publicKey: Option[PlaintextType] = None,
      parametersValidTo: Option[DateType] = None
    ): GetParametersForImportResponse =
      GetParametersForImportResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(importToken)(_.importToken(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(parametersValidTo)(_.parametersValidTo(_))
        .build

    def getPublicKeyRequest(
      keyId: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): GetPublicKeyRequest =
      GetPublicKeyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def getPublicKeyResponse(
      keyId: Option[String] = None,
      publicKey: Option[PublicKeyType] = None,
      customerMasterKeySpec: Option[String] = None,
      keyUsage: Option[String] = None,
      encryptionAlgorithms: Option[List[EncryptionAlgorithmSpec]] = None,
      signingAlgorithms: Option[List[SigningAlgorithmSpec]] = None
    ): GetPublicKeyResponse =
      GetPublicKeyResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(publicKey)(_.publicKey(_))
        .ifSome(customerMasterKeySpec)(_.customerMasterKeySpec(_))
        .ifSome(keyUsage)(_.keyUsage(_))
        .ifSome(encryptionAlgorithms)(_.encryptionAlgorithms(_))
        .ifSome(signingAlgorithms)(_.signingAlgorithms(_))
        .build

    def grantConstraints(
      encryptionContextSubset: Option[EncryptionContextType] = None,
      encryptionContextEquals: Option[EncryptionContextType] = None
    ): GrantConstraints =
      GrantConstraints
        .builder
        .ifSome(encryptionContextSubset)(_.encryptionContextSubset(_))
        .ifSome(encryptionContextEquals)(_.encryptionContextEquals(_))
        .build

    def grantListEntry(
      keyId: Option[String] = None,
      grantId: Option[String] = None,
      name: Option[String] = None,
      creationDate: Option[DateType] = None,
      granteePrincipal: Option[String] = None,
      retiringPrincipal: Option[String] = None,
      issuingAccount: Option[String] = None,
      operations: Option[List[GrantOperation]] = None,
      constraints: Option[GrantConstraints] = None
    ): GrantListEntry =
      GrantListEntry
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(grantId)(_.grantId(_))
        .ifSome(name)(_.name(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(granteePrincipal)(_.granteePrincipal(_))
        .ifSome(retiringPrincipal)(_.retiringPrincipal(_))
        .ifSome(issuingAccount)(_.issuingAccount(_))
        .ifSome(operations)(_.operations(_))
        .ifSome(constraints)(_.constraints(_))
        .build

    def importKeyMaterialRequest(
      keyId: Option[String] = None,
      importToken: Option[CiphertextType] = None,
      encryptedKeyMaterial: Option[CiphertextType] = None,
      validTo: Option[DateType] = None,
      expirationModel: Option[String] = None
    ): ImportKeyMaterialRequest =
      ImportKeyMaterialRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(importToken)(_.importToken(_))
        .ifSome(encryptedKeyMaterial)(_.encryptedKeyMaterial(_))
        .ifSome(validTo)(_.validTo(_))
        .ifSome(expirationModel)(_.expirationModel(_))
        .build

    def importKeyMaterialResponse(

    ): ImportKeyMaterialResponse =
      ImportKeyMaterialResponse
        .builder

        .build

    def incorrectKeyException(
      message: Option[String] = None
    ): IncorrectKeyException =
      IncorrectKeyException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def incorrectKeyMaterialException(
      message: Option[String] = None
    ): IncorrectKeyMaterialException =
      IncorrectKeyMaterialException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def incorrectTrustAnchorException(
      message: Option[String] = None
    ): IncorrectTrustAnchorException =
      IncorrectTrustAnchorException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidAliasNameException(
      message: Option[String] = None
    ): InvalidAliasNameException =
      InvalidAliasNameException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidArnException(
      message: Option[String] = None
    ): InvalidArnException =
      InvalidArnException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidCiphertextException(
      message: Option[String] = None
    ): InvalidCiphertextException =
      InvalidCiphertextException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidGrantIdException(
      message: Option[String] = None
    ): InvalidGrantIdException =
      InvalidGrantIdException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidGrantTokenException(
      message: Option[String] = None
    ): InvalidGrantTokenException =
      InvalidGrantTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidImportTokenException(
      message: Option[String] = None
    ): InvalidImportTokenException =
      InvalidImportTokenException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidKeyUsageException(
      message: Option[String] = None
    ): InvalidKeyUsageException =
      InvalidKeyUsageException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def invalidMarkerException(
      message: Option[String] = None
    ): InvalidMarkerException =
      InvalidMarkerException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSInternalException(
      message: Option[String] = None
    ): KMSInternalException =
      KMSInternalException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSInvalidSignatureException(
      message: Option[String] = None
    ): KMSInvalidSignatureException =
      KMSInvalidSignatureException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def kMSInvalidStateException(
      message: Option[String] = None
    ): KMSInvalidStateException =
      KMSInvalidStateException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def keyListEntry(
      keyId: Option[String] = None,
      keyArn: Option[String] = None
    ): KeyListEntry =
      KeyListEntry
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(keyArn)(_.keyArn(_))
        .build

    def keyMetadata(
      aWSAccountId: Option[String] = None,
      keyId: Option[String] = None,
      arn: Option[String] = None,
      creationDate: Option[DateType] = None,
      enabled: Option[Boolean] = None,
      description: Option[String] = None,
      keyUsage: Option[String] = None,
      keyState: Option[String] = None,
      deletionDate: Option[DateType] = None,
      validTo: Option[DateType] = None,
      origin: Option[String] = None,
      customKeyStoreId: Option[String] = None,
      cloudHsmClusterId: Option[String] = None,
      expirationModel: Option[String] = None,
      keyManager: Option[String] = None,
      customerMasterKeySpec: Option[String] = None,
      encryptionAlgorithms: Option[List[EncryptionAlgorithmSpec]] = None,
      signingAlgorithms: Option[List[SigningAlgorithmSpec]] = None
    ): KeyMetadata =
      KeyMetadata
        .builder
        .ifSome(aWSAccountId)(_.aWSAccountId(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(arn)(_.arn(_))
        .ifSome(creationDate)(_.creationDate(_))
        .ifSome(enabled)(_.enabled(_))
        .ifSome(description)(_.description(_))
        .ifSome(keyUsage)(_.keyUsage(_))
        .ifSome(keyState)(_.keyState(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .ifSome(validTo)(_.validTo(_))
        .ifSome(origin)(_.origin(_))
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .ifSome(cloudHsmClusterId)(_.cloudHsmClusterId(_))
        .ifSome(expirationModel)(_.expirationModel(_))
        .ifSome(keyManager)(_.keyManager(_))
        .ifSome(customerMasterKeySpec)(_.customerMasterKeySpec(_))
        .ifSome(encryptionAlgorithms)(_.encryptionAlgorithms(_))
        .ifSome(signingAlgorithms)(_.signingAlgorithms(_))
        .build

    def keyUnavailableException(
      message: Option[String] = None
    ): KeyUnavailableException =
      KeyUnavailableException
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

    def listAliasesRequest(
      keyId: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): ListAliasesRequest =
      ListAliasesRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listAliasesResponse(
      aliases: Option[List[AliasListEntry]] = None,
      nextMarker: Option[String] = None,
      truncated: Option[Boolean] = None
    ): ListAliasesResponse =
      ListAliasesResponse
        .builder
        .ifSome(aliases)(_.aliases(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def listGrantsRequest(
      limit: Option[Int] = None,
      marker: Option[String] = None,
      keyId: Option[String] = None,
      grantId: Option[String] = None,
      granteePrincipal: Option[String] = None
    ): ListGrantsRequest =
      ListGrantsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(grantId)(_.grantId(_))
        .ifSome(granteePrincipal)(_.granteePrincipal(_))
        .build

    def listGrantsResponse(
      grants: Option[List[GrantListEntry]] = None,
      nextMarker: Option[String] = None,
      truncated: Option[Boolean] = None
    ): ListGrantsResponse =
      ListGrantsResponse
        .builder
        .ifSome(grants)(_.grants(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def listKeyPoliciesRequest(
      keyId: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): ListKeyPoliciesRequest =
      ListKeyPoliciesRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listKeyPoliciesResponse(
      policyNames: Option[List[PolicyNameType]] = None,
      nextMarker: Option[String] = None,
      truncated: Option[Boolean] = None
    ): ListKeyPoliciesResponse =
      ListKeyPoliciesResponse
        .builder
        .ifSome(policyNames)(_.policyNames(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def listKeysRequest(
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): ListKeysRequest =
      ListKeysRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listKeysResponse(
      keys: Option[List[KeyListEntry]] = None,
      nextMarker: Option[String] = None,
      truncated: Option[Boolean] = None
    ): ListKeysResponse =
      ListKeysResponse
        .builder
        .ifSome(keys)(_.keys(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def listResourceTagsRequest(
      keyId: Option[String] = None,
      limit: Option[Int] = None,
      marker: Option[String] = None
    ): ListResourceTagsRequest =
      ListResourceTagsRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .build

    def listResourceTagsResponse(
      tags: Option[List[Tag]] = None,
      nextMarker: Option[String] = None,
      truncated: Option[Boolean] = None
    ): ListResourceTagsResponse =
      ListResourceTagsResponse
        .builder
        .ifSome(tags)(_.tags(_))
        .ifSome(nextMarker)(_.nextMarker(_))
        .ifSome(truncated)(_.truncated(_))
        .build

    def listRetirableGrantsRequest(
      limit: Option[Int] = None,
      marker: Option[String] = None,
      retiringPrincipal: Option[String] = None
    ): ListRetirableGrantsRequest =
      ListRetirableGrantsRequest
        .builder
        .ifSome(limit)(_.limit(_))
        .ifSome(marker)(_.marker(_))
        .ifSome(retiringPrincipal)(_.retiringPrincipal(_))
        .build

    def malformedPolicyDocumentException(
      message: Option[String] = None
    ): MalformedPolicyDocumentException =
      MalformedPolicyDocumentException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def notFoundException(
      message: Option[String] = None
    ): NotFoundException =
      NotFoundException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def putKeyPolicyRequest(
      keyId: Option[String] = None,
      policyName: Option[String] = None,
      policy: Option[String] = None,
      bypassPolicyLockoutSafetyCheck: Option[Boolean] = None
    ): PutKeyPolicyRequest =
      PutKeyPolicyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(policyName)(_.policyName(_))
        .ifSome(policy)(_.policy(_))
        .ifSome(bypassPolicyLockoutSafetyCheck)(_.bypassPolicyLockoutSafetyCheck(_))
        .build

    def reEncryptRequest(
      ciphertextBlob: Option[CiphertextType] = None,
      sourceEncryptionContext: Option[EncryptionContextType] = None,
      sourceKeyId: Option[String] = None,
      destinationKeyId: Option[String] = None,
      destinationEncryptionContext: Option[EncryptionContextType] = None,
      sourceEncryptionAlgorithm: Option[String] = None,
      destinationEncryptionAlgorithm: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): ReEncryptRequest =
      ReEncryptRequest
        .builder
        .ifSome(ciphertextBlob)(_.ciphertextBlob(_))
        .ifSome(sourceEncryptionContext)(_.sourceEncryptionContext(_))
        .ifSome(sourceKeyId)(_.sourceKeyId(_))
        .ifSome(destinationKeyId)(_.destinationKeyId(_))
        .ifSome(destinationEncryptionContext)(_.destinationEncryptionContext(_))
        .ifSome(sourceEncryptionAlgorithm)(_.sourceEncryptionAlgorithm(_))
        .ifSome(destinationEncryptionAlgorithm)(_.destinationEncryptionAlgorithm(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def reEncryptResponse(
      ciphertextBlob: Option[CiphertextType] = None,
      sourceKeyId: Option[String] = None,
      keyId: Option[String] = None,
      sourceEncryptionAlgorithm: Option[String] = None,
      destinationEncryptionAlgorithm: Option[String] = None
    ): ReEncryptResponse =
      ReEncryptResponse
        .builder
        .ifSome(ciphertextBlob)(_.ciphertextBlob(_))
        .ifSome(sourceKeyId)(_.sourceKeyId(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(sourceEncryptionAlgorithm)(_.sourceEncryptionAlgorithm(_))
        .ifSome(destinationEncryptionAlgorithm)(_.destinationEncryptionAlgorithm(_))
        .build

    def retireGrantRequest(
      grantToken: Option[String] = None,
      keyId: Option[String] = None,
      grantId: Option[String] = None
    ): RetireGrantRequest =
      RetireGrantRequest
        .builder
        .ifSome(grantToken)(_.grantToken(_))
        .ifSome(keyId)(_.keyId(_))
        .ifSome(grantId)(_.grantId(_))
        .build

    def revokeGrantRequest(
      keyId: Option[String] = None,
      grantId: Option[String] = None
    ): RevokeGrantRequest =
      RevokeGrantRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(grantId)(_.grantId(_))
        .build

    def scheduleKeyDeletionRequest(
      keyId: Option[String] = None,
      pendingWindowInDays: Option[Int] = None
    ): ScheduleKeyDeletionRequest =
      ScheduleKeyDeletionRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(pendingWindowInDays)(_.pendingWindowInDays(_))
        .build

    def scheduleKeyDeletionResponse(
      keyId: Option[String] = None,
      deletionDate: Option[DateType] = None
    ): ScheduleKeyDeletionResponse =
      ScheduleKeyDeletionResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(deletionDate)(_.deletionDate(_))
        .build

    def signRequest(
      keyId: Option[String] = None,
      message: Option[PlaintextType] = None,
      messageType: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None,
      signingAlgorithm: Option[String] = None
    ): SignRequest =
      SignRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(message)(_.message(_))
        .ifSome(messageType)(_.messageType(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .build

    def signResponse(
      keyId: Option[String] = None,
      signature: Option[CiphertextType] = None,
      signingAlgorithm: Option[String] = None
    ): SignResponse =
      SignResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(signature)(_.signature(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .build

    def tag(
      tagKey: Option[String] = None,
      tagValue: Option[String] = None
    ): Tag =
      Tag
        .builder
        .ifSome(tagKey)(_.tagKey(_))
        .ifSome(tagValue)(_.tagValue(_))
        .build

    def tagException(
      message: Option[String] = None
    ): TagException =
      TagException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def tagResourceRequest(
      keyId: Option[String] = None,
      tags: Option[List[Tag]] = None
    ): TagResourceRequest =
      TagResourceRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(tags)(_.tags(_))
        .build

    def unsupportedOperationException(
      message: Option[String] = None
    ): UnsupportedOperationException =
      UnsupportedOperationException
        .builder
        .ifSome(message)(_.message(_))
        .build

    def untagResourceRequest(
      keyId: Option[String] = None,
      tagKeys: Option[List[TagKeyType]] = None
    ): UntagResourceRequest =
      UntagResourceRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(tagKeys)(_.tagKeys(_))
        .build

    def updateAliasRequest(
      aliasName: Option[String] = None,
      targetKeyId: Option[String] = None
    ): UpdateAliasRequest =
      UpdateAliasRequest
        .builder
        .ifSome(aliasName)(_.aliasName(_))
        .ifSome(targetKeyId)(_.targetKeyId(_))
        .build

    def updateCustomKeyStoreRequest(
      customKeyStoreId: Option[String] = None,
      newCustomKeyStoreName: Option[String] = None,
      keyStorePassword: Option[String] = None,
      cloudHsmClusterId: Option[String] = None
    ): UpdateCustomKeyStoreRequest =
      UpdateCustomKeyStoreRequest
        .builder
        .ifSome(customKeyStoreId)(_.customKeyStoreId(_))
        .ifSome(newCustomKeyStoreName)(_.newCustomKeyStoreName(_))
        .ifSome(keyStorePassword)(_.keyStorePassword(_))
        .ifSome(cloudHsmClusterId)(_.cloudHsmClusterId(_))
        .build

    def updateCustomKeyStoreResponse(

    ): UpdateCustomKeyStoreResponse =
      UpdateCustomKeyStoreResponse
        .builder

        .build

    def updateKeyDescriptionRequest(
      keyId: Option[String] = None,
      description: Option[String] = None
    ): UpdateKeyDescriptionRequest =
      UpdateKeyDescriptionRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(description)(_.description(_))
        .build

    def verifyRequest(
      keyId: Option[String] = None,
      message: Option[PlaintextType] = None,
      messageType: Option[String] = None,
      signature: Option[CiphertextType] = None,
      signingAlgorithm: Option[String] = None,
      grantTokens: Option[List[GrantTokenType]] = None
    ): VerifyRequest =
      VerifyRequest
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(message)(_.message(_))
        .ifSome(messageType)(_.messageType(_))
        .ifSome(signature)(_.signature(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .ifSome(grantTokens)(_.grantTokens(_))
        .build

    def verifyResponse(
      keyId: Option[String] = None,
      signatureValid: Option[Boolean] = None,
      signingAlgorithm: Option[String] = None
    ): VerifyResponse =
      VerifyResponse
        .builder
        .ifSome(keyId)(_.keyId(_))
        .ifSome(signatureValid)(_.signatureValid(_))
        .ifSome(signingAlgorithm)(_.signingAlgorithm(_))
        .build

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
