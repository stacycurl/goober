package goober.hi

import goober.free.secretsmanager.SecretsManagerIO
import software.amazon.awssdk.services.secretsmanager.model._


object secretsmanager {
  import goober.free.{secretsmanager ⇒ free}

  object model {
    import goober.hi.util.BuilderSyntax._

    // Methods for constructing model classes, requests, etc.
    // CancelRotateSecretRequest
    // CreateSecretRequest
    // DeleteResourcePolicyRequest
    // DeleteSecretRequest
    // DescribeSecretRequest
    // GetRandomPasswordRequest
    // GetResourcePolicyRequest
    // GetSecretValueRequest
    // ListSecretVersionIdsRequest
    // ListSecretsRequest
    // PutResourcePolicyRequest
    // PutSecretValueRequest
    // RemoveRegionsFromReplicationRequest
    // ReplicateSecretToRegionsRequest
    // RestoreSecretRequest
    // RotateSecretRequest
    // StopReplicationToReplicaRequest
    // TagResourceRequest
    // UntagResourceRequest
    // UpdateSecretRequest
    // UpdateSecretVersionStageRequest
    // ValidateResourcePolicyRequest

  }

  // smartConstructors that take paramteers derived from mandatory & optional fields of requests
}
