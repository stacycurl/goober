package goober.hi

import goober.free.kms.KmsIO
import software.amazon.awssdk.services.kms.model._


object kms {
  import goober.free.{kms ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CancelKeyDeletionRequest
    // ConnectCustomKeyStoreRequest
    // CreateAliasRequest
    // CreateCustomKeyStoreRequest
    // CreateGrantRequest
    // CreateKeyRequest
    // DecryptRequest
    // DeleteAliasRequest
    // DeleteCustomKeyStoreRequest
    // DeleteImportedKeyMaterialRequest
    // DescribeCustomKeyStoresRequest
    // DescribeKeyRequest
    // DisableKeyRequest
    // DisableKeyRotationRequest
    // DisconnectCustomKeyStoreRequest
    // EnableKeyRequest
    // EnableKeyRotationRequest
    // EncryptRequest
    // GenerateDataKeyRequest
    // GenerateDataKeyPairRequest
    // GenerateDataKeyPairWithoutPlaintextRequest
    // GenerateDataKeyWithoutPlaintextRequest
    // GenerateRandomRequest
    // GetKeyPolicyRequest
    // GetKeyRotationStatusRequest
    // GetParametersForImportRequest
    // GetPublicKeyRequest
    // ImportKeyMaterialRequest
    // ListAliasesRequest
    // ListGrantsRequest
    // ListKeyPoliciesRequest
    // ListKeysRequest
    // ListResourceTagsRequest
    // ListRetirableGrantsRequest
    // PutKeyPolicyRequest
    // ReEncryptRequest
    // RetireGrantRequest
    // RevokeGrantRequest
    // ScheduleKeyDeletionRequest
    // SignRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateAliasRequest
    // UpdateCustomKeyStoreRequest
    // UpdateKeyDescriptionRequest
    // VerifyRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
